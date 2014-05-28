//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWYM
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:41
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWYM(YDATEI,KOMMA) ;WWWYM;DT;MANDANTENUEBERGREIFENDE DATEI;03.05.1999
public class WWWYM extends mClass {

  public Object main(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar KOMMA = m$.newVarRef("KOMMA",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _WWWYM(YDATEI,KOMMA);
  }

  public Object _WWWYM(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar KOMMA = m$.newVarRef("KOMMA",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       MANDANTENUEBERGREIFENDE DATEI
    //<< ;
    //<< ; KOMMA=1 DANN MIT KOMMMA SONST OHNE ;by means of otherwise without
    //<< ; KEIN KOMMA Z.B. IM PRG WWWMENU1 -- "WWWMAIL" WEIL $O
    //<< ;
    //<< ; Inputs :
    //<< ;   YDATEI          idClass
    //<< ;   KOMMA           blnAppendComma
    //<< ;
    //<< ; ByRef :
    //<< ;   YM              current company
    //<< ;
    //<< ; Returns :
    //<< ;   Value of YM for the class in question - 0 if a shared class, current company
    //<< ;   otherwise.  Append a comma if KOMMA is $$$YES
    //<< ;
    //<< ; History :
    //<< ; 14-Sep-2005   RPW     SR13306: Changed syntax to equivalent but MUCH faster,
    //<< ;                           also $extract(KEY1) is used three times when KEY1
    //<< ;                           does not change
    //<< ; 03.05.1999    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW ALTERN,YDATA,KOM
    mVar ALTERN = m$.var("ALTERN");
    mVar YDATA = m$.var("YDATA");
    mVar KOM = m$.var("KOM");
    m$.newVar(ALTERN,YDATA,KOM);
    //<< 
    //<< set KOMMA=$get(KOMMA)
    KOMMA.set(m$.Fnc.$get(KOMMA));
    //<< QUIT:YDATEI="" ""
    if (mOp.Equal(YDATEI.get(),"")) {
      return "";
    }
    //<< 
    //<< ; Suffix based on switch KOMMA
    //<< SET KOM=","
    KOM.set(",");
    //<< SET:KOMMA'=1 KOM=""
    if (mOp.NotEqual(KOMMA.get(),1)) {
      KOM.set("");
    }
    //<< 
    //<< SET YDATA=$GET(^WWW001(0,YDATEI,1))
    YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)));
    //<< //IF +$$$WWW001AltSaveProcedure(YDATA)=4         QUIT ""   ;OBJEKTE = OHNE YM UND KOMMA ;without And comma
    //<< IF +$$$WWW001AltSaveProcedure(YDATA)=3 DO ALTERN QUIT ALTERN
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW001AltSaveProcedure(m$,YDATA)),3)) {
      m$.Cmd.Do("ALTERN");
      return ALTERN.get();
    }
    //<< IF $$$WWW001SharedFile(YDATA)=1                  QUIT 0_KOM
    if (mOp.Equal(include.WWWConst.$$$WWW001SharedFile(m$,YDATA),1)) {
      return mOp.Concat(0,KOM.get());
    }
    //<< ;IF KOM="," QUIT """"_YM_""""_KOM
    //<< QUIT YM_KOM
    return mOp.Concat(m$.var("YM").get(),KOM.get());
  }

  //<< 
  //<< ALTERN ;ALTERNATIVE SPEICHERUNG/SUCHEN MANDANT ;option Company
  public void ALTERN() {
    //<< new strKey1
    mVar strKey1 = m$.var("strKey1");
    m$.newVar(strKey1);
    //<< 
    //<< SET ALTERN=""
    mVar ALTERN = m$.var("ALTERN");
    ALTERN.set("");
    //<< SET KEY1=$PIECE($GET(^WWW002(0,YDATEI,1,1)),Y,11)
    mVar KEY1 = m$.var("KEY1");
    KEY1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),1,1)),m$.var("Y").get(),11));
    //<< QUIT:KEY1=""
    if (mOp.Equal(KEY1.get(),"")) {
      return;
    }
    //<< 
    //<< set strKey1=$extract(KEY1)
    strKey1.set(m$.Fnc.$extract(KEY1.get()));
    //<< IF strKey1=""""  SET ALTERN = KEY1_KOM                QUIT   ;TEXT
    if (mOp.Equal(strKey1.get(),"\"")) {
      ALTERN.set(mOp.Concat(KEY1.get(),m$.var("KOM").get()));
      return;
    }
    //<< IF strKey1'="""" IF '$DATA(@$PIECE(KEY1,",",1))       QUIT   ;NICHT DEFINIERTE VAR. ;Not
    if (mOp.NotEqual(strKey1.get(),"\"")) {
      if (mOp.Not(m$.Fnc.$data(m$.indirectVar(m$.Fnc.$piece(KEY1.get(),",",1))))) {
        return;
      }
    }
    //<< IF strKey1'="""" SET ALTERN = @$PIECE(KEY1,",",1)_KOM QUIT   ;VARIABLE
    if (mOp.NotEqual(strKey1.get(),"\"")) {
      ALTERN.set(mOp.Concat(m$.indirectVar(m$.Fnc.$piece(KEY1.get(),",",1)).get(),m$.var("KOM").get()));
      return;
    }
    //<< QUIT
    return;
  }

//<< 
}
