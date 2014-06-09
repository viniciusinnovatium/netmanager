//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWBITSETXREF
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-05 20:52:33
//*****************************************************************************

import mLibrary.*;


//<< WWWBITSETXREF(YDATEI,YXDATEI,YKEY,YXKEY,SET,YYM) ;WWWBITSETXREF;TYBD;BITS SETZTEN ALS REFERENCE ANDERERE FILES;19,12,2004
public class WWWBITSETXREF extends mClass {

  public Object main(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YXDATEI = m$.newVarRef("YXDATEI",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YXKEY = m$.newVarRef("YXKEY",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar SET = m$.newVarRef("SET",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar YYM = m$.newVarRef("YYM",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    return _WWWBITSETXREF(YDATEI,YXDATEI,YKEY,YXKEY,SET,YYM);
  }

  public Object _WWWBITSETXREF(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YXDATEI = m$.newVarRef("YXDATEI",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YXKEY = m$.newVarRef("YXKEY",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar SET = m$.newVarRef("SET",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar YYM = m$.newVarRef("YYM",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      BITS SETZTEN ALS REFERENCE ANDERERE FILES
    //<< ;|
    //<< ;| Inputs :
    //<< ;|
    //<< ;|
    //<< ;| ByRef :
    //<< ;|
    //<< ;|
    //<< ;| Returns :
    //<< ;|
    //<< ;|
    //<< ;| History :
    //<< ;|
    //<< ;| TYBD 19,12,2004
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< ;YDATEI      =FILE
    //<< ;YXDATEI     =XREF FILE
    //<< ;YKEY        =NORMAL KEY
    //<< ;YXKEY       =KEY TO XREF
    //<< ;SET         = 0 = KILL, SET 0
    //<< ;YYM         =COMPANY OR 0 FOR CENTRAL FILE OR ""
    //<< ; SET OK=$$^WWWBITSETXREF("INARTFAV","INART","TYBD,12345",12345,1,"0")  ;BEISPIEL/SAMPLE
    //<< ;DABEI MUSS DER ^YXDATEI(YM,YXKEY,1) VORHANDEN SEIN. DER BIT KOMMT DANN AUS DIESER FOLGE
    //<< NEW RETURN,YRET,WWWYM
    mVar RETURN = m$.var("RETURN");
    mVar YRET = m$.var("YRET");
    mVar WWWYM = m$.var("WWWYM");
    m$.newVar(RETURN,YRET,WWWYM);
    //<< SET RETURN=""
    RETURN.set("");
    //<< QUIT:$GET(YDATEI)="" RETURN
    if (mOp.Equal(m$.Fnc.$get(YDATEI),"")) {
      return RETURN.get();
    }
    //<< QUIT:$GET(YXDATEI)="" RETURN
    if (mOp.Equal(m$.Fnc.$get(YXDATEI),"")) {
      return RETURN.get();
    }
    //<< QUIT:$GET(YKEY)="" RETURN
    if (mOp.Equal(m$.Fnc.$get(YKEY),"")) {
      return RETURN.get();
    }
    //<< QUIT:$GET(YXKEY)="" RETURN
    if (mOp.Equal(m$.Fnc.$get(YXKEY),"")) {
      return RETURN.get();
    }
    //<< SET WWWYM=$GET(YYM)
    WWWYM.set(m$.Fnc.$get(YYM));
    //<< SET SET=$GET(SET)
    SET.set(m$.Fnc.$get(SET));
    //<< SET WWWYM=$P($GET(YYM),",",1)  ;NICHT MIT ","
    WWWYM.set(m$.Fnc.$piece(m$.Fnc.$get(YYM),",",1));
    //<< IF WWWYM="" SET WWWYM=$$^WWWYM(YDATEI,0)
    if (mOp.Equal(WWWYM.get(),"")) {
      WWWYM.set(m$.fnc$("WWWYM.main",YDATEI.get(),0));
    }
    do {
      //<< DO
      //<< . NEW BIT,BITX,BITS,BITM,COUNT,FIELD,YLFN,YLFN1,OK,YKEY1,ID,SCHL
      mVar BIT = m$.var("BIT");
      mVar BITX = m$.var("BITX");
      mVar BITS = m$.var("BITS");
      mVar BITM = m$.var("BITM");
      mVar COUNT = m$.var("COUNT");
      mVar FIELD = m$.var("FIELD");
      mVar YLFN = m$.var("YLFN");
      mVar YLFN1 = m$.var("YLFN1");
      mVar OK = m$.var("OK");
      mVar YKEY1 = m$.var("YKEY1");
      mVar ID = m$.var("ID");
      mVar SCHL = m$.var("SCHL");
      m$.newVarBlock(1,BIT,BITX,BITS,BITM,COUNT,FIELD,YLFN,YLFN1,OK,YKEY1,ID,SCHL);
      //<< . SET OK=0
      OK.set(0);
      //<< . DO
      do {
        //<< . . SET SCHL(1)="^"_YXDATEI_"bi("_""""_WWWYM_""""_","_2_","_""""_$TRANSLATE(YXKEY,"""")_""""_")"
        SCHL.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YXDATEI.get()),"bi("),"\""),WWWYM.get()),"\""),","),2),","),"\""),m$.Fnc.$translate(YXKEY.get(),"\"")),"\""),")"));
        //<< . . SET SCHL(10)="^"_YXDATEI_"bi("_""""_WWWYM_""""_","_2_","_""""_$TRANSLATE(YXKEY,"""")_""""_",ID)"
        SCHL.var(10).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YXDATEI.get()),"bi("),"\""),WWWYM.get()),"\""),","),2),","),"\""),m$.Fnc.$translate(YXKEY.get(),"\"")),"\""),",ID)"));
        //<< . . IF '$DATA(@SCHL(1)) QUIT  ;NICHT VORHANDEN
        if (mOp.Not(m$.Fnc.$data(m$.indirectVar(SCHL.var(1).get())))) {
          break;
        }
        //<< . . SET ID=""
        ID.set("");
        //<< . . SET ID=$ORDER(@SCHL(10))
        ID.set(m$.Fnc.$order(m$.indirectVar(SCHL.var(10).get())));
        //<< . . IF ID'="" SET OK=1
        if (mOp.NotEqual(ID.get(),"")) {
          OK.set(1);
        }
        //<< . . QUIT
        break;
      } while(false);
      //<< . QUIT:OK=0
      if (mOp.Equal(OK.get(),0)) {
        break;
      }
      //<< . ;
      //<< . SET BIT=0   ;=DATENSATZ VORHANDEN j/n ;on hand
      BIT.set(0);
      //<< . SET BITX=$PIECE(YKEY,",",1,$L(YKEY,",")-1)  ;=DATENbit
      BITX.set(m$.Fnc.$piece(YKEY.get(),",",1,mOp.Subtract(m$.Fnc.$length(YKEY.get(),","),1)));
      //<< . SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,SET,WWWYM)  ;KEY, MAIN BIT 0 = EXISTS
      OK.set(m$.fnc$("WWWBIT.main",YDATEI.get(),ID.get(),BIT.get(),BITX.get(),SET.get(),WWWYM.get()));
      //<< . SET RETURN=1  ;OK
      RETURN.set(1);
      //<< . ;
      //<< . QUIT
      break;
    } while(false);
    m$.restoreVarBlock(1);
    //<< QUIT RETURN
    return RETURN.get();
  }

//<< 
}
