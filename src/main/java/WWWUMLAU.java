//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWUMLAU
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:53
//*****************************************************************************

import mLibrary.*;

//<< #include COMSYS
import include.COMSYS;
import include.COMSYSDate;
import include.COMSYSNum;
import include.COMSYSString;
import include.COMSYSWWW;
import include.COMSYSOutput;
import include.COMSYSEnum;
import include.COMGridEdit31Interface;
import include.COMTab;
import include.COMEditor;
import include.COMSYSJS;
import include.$occInclude;

public class WWWUMLAU extends mClass {

  //<< WWWUMLAU(X,Z="",COMMA=$$$NO)
  public Object main(Object ... _p) {
    mVar X = m$.newVarRef("X",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Z = m$.newVarRef("Z",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar COMMA = m$.newVarRef("COMMA",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    return _WWWUMLAU(X,Z,COMMA);
  }

  public Object _WWWUMLAU(Object ... _p) {
    mVar X = m$.newVarRef("X",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Z = m$.newVarRef("Z",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar COMMA = m$.newVarRef("COMMA",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Convert Umlauts
    //<< ;
    //<< ;   +++++++++++++++++++++++++++++++++++++++++++++++++++++
    //<< ;   + WARNING : It is possible for the results for some +
    //<< ;   +           values of Z to be a null string.        +
    //<< ;   +++++++++++++++++++++++++++++++++++++++++++++++++++++
    //<< ;
    //<< ;   S TEXT=$$^WWWUMLAU(TEXT,1)
    //<< ;
    //<< ; Inputs :
    //<< ;   X=TEXT
    //<< ;
    //<< ;   Z="" NUR UMLAUTE                                          ;Only umlauts
    //<< ;   Z=1 UMLAUTE GROSS UND SONDERZEICHEN ZU LEER  (SORTIERUNG) ;Umlauts, large, and remove special characters
    //<< ;   Z=2 UMLAUTE GROSS SONDERZEICHEN NICHT VERÄNDERN           ;Umlauts, large
    //<< ;   Z=3 UMLAUTE GROSS UND SONDERZEICHEN LÖSCHEN               ;& Delete special character
    //<< ;   Z=4 UMLAUTE 1. ZEICHEN GROSS SONDERZEICHEN LÖSCHEN        ;sign special character Delete
    //<< ;   Z=5 UMLAUTE KEINE LEER SONDERZEICHEN LÖSCHEN KEINE ZAHLEN AN 1.STELLE ;no void special character Delete no upon
    //<< ;   Z=6 SONDERZEICHEN ZU LEER UMLAUTE                         ;special character within void
    //<< ;
    //<< ;   COMMA=$$$YES    DO NOT DELETE "," COMMAS
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns : Modified X
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 10-Dec-2010   GRF     Code cleanup - old commented code removed
    //<< ; 28-Mar-2007   HeberB  SRBR014367: moved code upwards
    //<< ; 10-Oct-2005   JW      SR13641: Corrected, sped up.
    //<< ; 19-Jul-2005   JW      SR12934: Changed 255 to 254
    //<< ; 17-Jun-2005   Paul K  Fixed subscript error if length of "strOriginal" > 255
    //<< ; 16-Jun-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 08-Jun-2005   GRF     Clarify
    //<< ; 01-Jun-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 27-May-2005   GRF     Replace $Data test for Z with default argument to try to get
    //<< ;                       around 'eventQueueManager^COMDCMControlModule()' problem in
    //<< ;                       scheduler.
    //<< ; 24.11.1994    DT      Created - UMSETZEN UMLAUTE
    //<< ;-------------------------------------------------------------------------------
    //<< if Z'=1 quit:X="" X
    if (mOp.NotEqual(Z.get(),1)) {
      if (mOp.Equal(X.get(),"")) {
        return X.get();
      }
    }
    //<< new K,TRX,YQ,YI,strOriginal,strUMLAU
    mVar K = m$.var("K");
    mVar TRX = m$.var("TRX");
    mVar YQ = m$.var("YQ");
    mVar YI = m$.var("YI");
    mVar strOriginal = m$.var("strOriginal");
    mVar strUMLAU = m$.var("strUMLAU");
    m$.newVar(K,TRX,YQ,YI,strOriginal,strUMLAU);
    //<< new LW,UP,LW2,UP2,LW0,UP0,UP6
    mVar LW = m$.var("LW");
    mVar UP = m$.var("UP");
    mVar LW2 = m$.var("LW2");
    mVar UP2 = m$.var("UP2");
    mVar LW0 = m$.var("LW0");
    mVar UP0 = m$.var("UP0");
    mVar UP6 = m$.var("UP6");
    m$.newVar(LW,UP,LW2,UP2,LW0,UP0,UP6);
    //<< 
    //<< set strOriginal = $select($get(X)="":" ",1:X)
    strOriginal.set(m$.Fnc.$select(mOp.Equal(m$.Fnc.$get(X),"")," ",1,X.get()));
    //<< 
    //<< if $get(YUCI)="" set YUCI = $zutil(5)
    if (mOp.Equal(m$.Fnc.$get(m$.var("YUCI")),"")) {
      mVar YUCI = m$.var("YUCI");
      YUCI.set(m$.Fnc.$zutil(5));
    }
    //<< 
    //<< if ($length(strOriginal)<254) && ($length(Z)<254) {
    if ((mOp.Less(m$.Fnc.$length(strOriginal.get()),254)) && (mOp.Less(m$.Fnc.$length(Z.get()),254))) {
      //<< set strUMLAU = $get(^CacheTempWWWUMLAUCACHE(YUCI,strOriginal,$select(Z="":" ",1:Z),$select(COMMA="":0,1:COMMA)))
      strUMLAU.set(m$.Fnc.$get(m$.var("^CacheTempWWWUMLAUCACHE",m$.var("YUCI").get(),strOriginal.get(),m$.Fnc.$select(mOp.Equal(Z.get(),"")," ",1,Z.get()),m$.Fnc.$select(mOp.Equal(COMMA.get(),""),0,1,COMMA.get()))));
      //<< if strUMLAU'="" {
      if (mOp.NotEqual(strUMLAU.get(),"")) {
        //<< quit strUMLAU              ; *** EARLY EXIT ***
        return strUMLAU.get();
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $get(YUMLAU)'="" {    ;UMLAU SPEED UP;TYBD;5,10,2004;PARAMETER UMLAUTUMSETZUNG ;KEINE UMLAUTE;TYBD;6,10,2004;26526
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUMLAU")),"")) {
      //<< set strUMLAU = ""
      strUMLAU.set("");
      //<< for YI=1:1:$length(YUMLAU,",") {
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),m$.Fnc.$length(m$.var("YUMLAU").get(),",")));YI.set(mOp.Add(YI.get(),1))) {
        //<< set strUMLAU = strUMLAU_$char($piece(YUMLAU,",",YI))
        strUMLAU.set(mOp.Concat(strUMLAU.get(),m$.Fnc.$char(m$.Fnc.$piece(m$.var("YUMLAU").get(),",",YI.get()))));
      }
      //<< }
      //<< set YQ = (X=$translate(X,strUMLAU))
      YQ.set((mOp.Equal(X.get(),m$.Fnc.$translate(X.get(),strUMLAU.get()))));
      //<< 
      //<< if YQ'=$$$YES {
      if (mOp.NotEqual(YQ.get(),include.COMSYS.$$$YES(m$))) {
        //<< if '$data(^CacheTempWWWUMLAU) {
        if (mOp.Not(m$.Fnc.$data(m$.var("^CacheTempWWWUMLAU")))) {
          //<< merge ^CacheTempWWWUMLAU=^WWWUMLAU
          m$.Cmd.Merge(m$.var("^CacheTempWWWUMLAU"),m$.var("^WWWUMLAU"));
        }
        //<< }
        //<< 
        //<< set CHAR=""
        mVar CHAR = m$.var("CHAR");
        CHAR.set("");
        //<< for  set CHAR = $order(^CacheTempWWWUMLAU(0,CHAR)) quit:CHAR=""  do CHAR
        for (;true;) {
          CHAR.set(m$.Fnc.$order(m$.var("^CacheTempWWWUMLAU",0,CHAR.get())));
          if (mOp.Equal(CHAR.get(),"")) {
            break;
          }
          m$.Cmd.Do("CHAR");
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ;f Z=1 set LW  = "ÜÄÖüäöß][\}{|~abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?"_$CHAR(128)_""""_" ",UP="UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ                   " ; SR17225
    //<< if Z=1 set LW  = "ÜÄÖüäöß][\}{|~abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/"_$char(128)_""""_" ",UP="UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ                   "
    if (mOp.Equal(Z.get(),1)) {
      LW.set(mOp.Concat(mOp.Concat(mOp.Concat("ÜÄÖüäöß][\\}{|~abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\"")," "));
      UP.set("UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ                   ");
    }
    //<< if Z=2 set LW2 = "ÜÄÖüäöß][\}{|~abcdefghijklmnopqrstuvwxyz",UP2="UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ"
    if (mOp.Equal(Z.get(),2)) {
      LW2.set("ÜÄÖüäöß][\\}{|~abcdefghijklmnopqrstuvwxyz");
      UP2.set("UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }
    //<< if Z=5 set LW5 = "ÜÄÖüäöß][\}{|~ ,()@#$%^&*_=+<>?/"_$char(128)_"""",UP5="UAOUAOSUAOUAOS"
    if (mOp.Equal(Z.get(),5)) {
      mVar LW5 = m$.var("LW5");
      LW5.set(mOp.Concat(mOp.Concat("ÜÄÖüäöß][\\}{|~ ,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\""));
      mVar UP5 = m$.var("UP5");
      UP5.set("UAOUAOSUAOUAOS");
    }
    //<< if Z=6 set UP6 = "UAOUAOSUAOUAOSabcdefghijklmnopqrstuvwxyz"
    if (mOp.Equal(Z.get(),6)) {
      UP6.set("UAOUAOSUAOUAOSabcdefghijklmnopqrstuvwxyz");
    }
    //<< set LW0 = "ÜÄÖüäöß][\}{|~abcdefghijklmnopqrstuvwxyz ,()@#$%^&*_=+<>?/"_$char(128)_""""
    LW0.set(mOp.Concat(mOp.Concat("ÜÄÖüäöß][\\}{|~abcdefghijklmnopqrstuvwxyz ,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\""));
    //<< set UP0 = "UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ"
    UP0.set("UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ");
    //<< 
    //<< if (COMMA=$$$YES) && $find(X,",") {   ;NO COMMA ON COMMA=$$$YES
    if ((mOp.Equal(COMMA.get(),include.COMSYS.$$$YES(m$))) && mOp.Logical(m$.Fnc.$find(X.get(),","))) {
      //<< set LW  = $translate($get(LW),",")
      LW.set(m$.Fnc.$translate(m$.Fnc.$get(LW),","));
      //<< set LW2 = $translate($get(LW2),",")
      LW2.set(m$.Fnc.$translate(m$.Fnc.$get(LW2),","));
      //<< set LW5 = $translate($get(LW5),",")
      mVar LW5 = m$.var("LW5");
      LW5.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("LW5")),","));
      //<< set LW0 = $translate($get(LW0),",")
      LW0.set(m$.Fnc.$translate(m$.Fnc.$get(LW0),","));
      //<< set UP  = $translate($get(UP),",")  ;FIS;03.03.05;27426;SONST FALSCHER TRANSLATE
      UP.set(m$.Fnc.$translate(m$.Fnc.$get(UP),","));
    }
    //<< }
    //<< 
    //<< ; ***** EARLY EXITS ON EACH TEST *****
    //<< if Z=1 if $length(X)=1 if $find("+-/=",X) set:($length(strOriginal)<254) ^CacheTempWWWUMLAUCACHE(YUCI,strOriginal,Z,$select(COMMA="":0,1:COMMA))=X quit X   ;TYBD;7.3.2003;23432;SONDERUMSETZUNG WENN NUR EIN ZEICHEN
    if (mOp.Equal(Z.get(),1)) {
      if (mOp.Equal(m$.Fnc.$length(X.get()),1)) {
        if (mOp.Logical(m$.Fnc.$find("+-/=",X.get()))) {
          if ((mOp.Less(m$.Fnc.$length(strOriginal.get()),254))) {
            m$.var("^CacheTempWWWUMLAUCACHE",m$.var("YUCI").get(),strOriginal.get(),Z.get(),m$.Fnc.$select(mOp.Equal(COMMA.get(),""),0,1,COMMA.get())).set(X.get());
          }
          return X.get();
        }
      }
    }
    //<< if Z=1 {
    if (mOp.Equal(Z.get(),1)) {
      //<< set X=$translate(X,LW,UP)
      X.set(m$.Fnc.$translate(X.get(),LW.get(),UP.get()));
      //<< set:X="" X=" "
      if (mOp.Equal(X.get(),"")) {
        X.set(" ");
      }
      //<< set:($length(strOriginal)<254) ^CacheTempWWWUMLAUCACHE(YUCI,strOriginal,Z,$select(COMMA="":0,1:COMMA))=X
      if ((mOp.Less(m$.Fnc.$length(strOriginal.get()),254))) {
        m$.var("^CacheTempWWWUMLAUCACHE",m$.var("YUCI").get(),strOriginal.get(),Z.get(),m$.Fnc.$select(mOp.Equal(COMMA.get(),""),0,1,COMMA.get())).set(X.get());
      }
      //<< quit X
      return X.get();
    }
    //<< }
    //<< if Z=2 quit $translate(X,LW2,UP2)
    if (mOp.Equal(Z.get(),2)) {
      return m$.Fnc.$translate(X.get(),LW2.get(),UP2.get());
    }
    //<< if Z=3 quit $translate(X,LW0,UP0)
    if (mOp.Equal(Z.get(),3)) {
      return m$.Fnc.$translate(X.get(),LW0.get(),UP0.get());
    }
    //<< if Z=4 quit $extract($translate(X,LW0,UP0))_$extract($zconvert($translate(X,LW0,UP0),"L"),2,99)
    if (mOp.Equal(Z.get(),4)) {
      return mOp.Concat(m$.Fnc.$extract(m$.Fnc.$translate(X.get(),LW0.get(),UP0.get())),m$.Fnc.$extract(m$.Fnc.$zconvert(m$.Fnc.$translate(X.get(),LW0.get(),UP0.get()),"L"),2,99));
    }
    //<< if Z=5 for  quit:X=""  quit:'$find("1234567890",$extract(X))  set X = $extract(X,2,99999)
    if (mOp.Equal(Z.get(),5)) {
      for (;true;) {
        if (mOp.Equal(X.get(),"")) {
          break;
        }
        if (mOp.Not(m$.Fnc.$find("1234567890",m$.Fnc.$extract(X.get())))) {
          break;
        }
        X.set(m$.Fnc.$extract(X.get(),2,99999));
      }
    }
    //<< if Z=5 quit $translate(X,LW5,UP5)
    if (mOp.Equal(Z.get(),5)) {
      return m$.Fnc.$translate(X.get(),m$.var("LW5").get(),m$.var("UP5").get());
    }
    //<< if Z=6 quit $translate(X,LW0,UP6)
    if (mOp.Equal(Z.get(),6)) {
      return m$.Fnc.$translate(X.get(),LW0.get(),UP6.get());
    }
    //<< 
    //<< if ($length(strOriginal)<254) && ($length(Z)<254) {
    if ((mOp.Less(m$.Fnc.$length(strOriginal.get()),254)) && (mOp.Less(m$.Fnc.$length(Z.get()),254))) {
      //<< set ^CacheTempWWWUMLAUCACHE(YUCI,strOriginal,$select(Z="":" ",1:Z),$select(COMMA="":0,1:COMMA)) = X
      m$.var("^CacheTempWWWUMLAUCACHE",m$.var("YUCI").get(),strOriginal.get(),m$.Fnc.$select(mOp.Equal(Z.get(),"")," ",1,Z.get()),m$.Fnc.$select(mOp.Equal(COMMA.get(),""),0,1,COMMA.get())).set(X.get());
    }
    //<< }
    //<< quit X
    return X.get();
  }

  //<< 
  //<< 
  //<< CHAR
  public void CHAR() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   umsevtzen der umlaute und sonderzeichen
    //<< ;   convert the umlauts and special characters
    //<< ;-------------------------------------------------------------------------------
    //<< new UML,K
    mVar UML = m$.var("UML");
    mVar K = m$.var("K");
    m$.newVar(UML,K);
    //<< 
    //<< set UML = $piece($get(^CacheTempWWWUMLAU(0,CHAR,1)),Y,2)
    UML.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^CacheTempWWWUMLAU",0,m$.var("CHAR").get(),1)),m$.var("Y").get(),2));
    //<< quit:UML=""
    if (mOp.Equal(UML.get(),"")) {
      return;
    }
    //<< for  quit:'$find(X,$char(CHAR))  set K = $find(X,$char(CHAR)) if K set X = $extract(X,1,K-2)_UML_$extract(X,K,$length(X))
    for (;true;) {
      if (mOp.Not(m$.Fnc.$find(m$.var("X").get(),m$.Fnc.$char(m$.var("CHAR").get())))) {
        break;
      }
      K.set(m$.Fnc.$find(m$.var("X").get(),m$.Fnc.$char(m$.var("CHAR").get())));
      if (mOp.Logical(K.get())) {
        mVar X = m$.var("X");
        X.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(m$.var("X").get(),1,mOp.Subtract(K.get(),2)),UML.get()),m$.Fnc.$extract(m$.var("X").get(),K.get(),m$.Fnc.$length(m$.var("X").get()))));
      }
    }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< LW()
  public Object LW(Object ... _p) {
    //<< quit "ÜÄÖüäöß][\}{|~abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/"_$char(128)_""""_" "
    return mOp.Concat(mOp.Concat(mOp.Concat("ÜÄÖüäöß][\\}{|~abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\"")," ");
  }

  //<< 
  //<< UP()
  public Object UP(Object ... _p) {
    //<< quit "UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ                   "
    return "UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ                   ";
  }

  //<< 
  //<< LW0()
  public Object LW0(Object ... _p) {
    //<< quit "ÜÄÖüäöß][\}{|~abcdefghijklmnopqrstuvwxyz ,()@#$%^&*_=+<>?/"_$char(128)_""""
    return mOp.Concat(mOp.Concat("ÜÄÖüäöß][\\}{|~abcdefghijklmnopqrstuvwxyz ,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\"");
  }

  //<< 
  //<< UP0()
  public Object UP0(Object ... _p) {
    //<< quit "UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ"
    return "UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ";
  }

  //<< 
  //<< LW2()
  public Object LW2(Object ... _p) {
    //<< quit "ÜÄÖüäöß][\}{|~abcdefghijklmnopqrstuvwxyz"
    return "ÜÄÖüäöß][\\}{|~abcdefghijklmnopqrstuvwxyz";
  }

  //<< 
  //<< UP2()
  public Object UP2(Object ... _p) {
    //<< quit "UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ"
    return "UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ";
  }

  //<< 
  //<< LW5()
  public Object LW5(Object ... _p) {
    //<< quit "ÜÄÖüäöß][\}{|~ ,()@#$%^&*_=+<>?/"_$char(128)_""""
    return mOp.Concat(mOp.Concat("ÜÄÖüäöß][\\}{|~ ,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\"");
  }

  //<< 
  //<< UP5()
  public Object UP5(Object ... _p) {
    //<< quit "UAOUAOSUAOUAOS"
    return "UAOUAOSUAOUAOS";
  }

  //<< 
  //<< UP6()
  public Object UP6(Object ... _p) {
    //<< quit "UAOUAOSUAOUAOSabcdefghijklmnopqrstuvwxyz"
    return "UAOUAOSUAOUAOSabcdefghijklmnopqrstuvwxyz";
  }

//<< 
//<< 
}
