//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWPWDCHECK
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:07
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

public class WWWPWDCHECK extends mClass {

  //<< WWWPWDCHECK(YPWD)
  public Object main(Object ... _p) {
    mVar YPWD = m$.newVarRef("YPWD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWPWDCHECK(YPWD);
  }

  public Object _WWWPWDCHECK(Object ... _p) {
    mVar YPWD = m$.newVarRef("YPWD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert code to plain text
    //<< ;
    //<< ; Inputs :
    //<< ;   YPWD        Code
    //<< ;
    //<< ; Returns :     Plain Text
    //<< ;
    //<< ; History :
    //<< ; 02-Jan-2007   GRF     Doco; FIXME
    //<< ; 07.01.2004    TYBD    Created
    //<< ;-------------------------------------------------------------------------------
    //<< NEW RETURN,YI
    mVar RETURN = m$.var("RETURN");
    mVar YI = m$.var("YI");
    m$.newVar(RETURN,YI);
    //<< 
    //<< SET RETURN=$GET(YPWD)
    RETURN.set(m$.Fnc.$get(YPWD));
    //<< QUIT:$EXTRACT($GET(YPWD),1,2)'="^1" RETURN
    if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$get(YPWD),1,2),"^1")) {
      return RETURN.get();
    }
    //<< SET YI(1)=$EXTRACT(YPWD,2,999)
    YI.var(1).set(m$.Fnc.$extract(YPWD.get(),2,999));
    //<< SET RETURN=""
    RETURN.set("");
    //<< FOR YI(2)=1:1 SET YI(3)=$EXTRACT($PIECE(YI(1),",",YI(2)),2,9) QUIT:YI(3)=""  SET RETURN=RETURN_$CHAR(YI(3)/9)
    for (m$.var("YI",2).set(1);(true);m$.var("YI",2).set(mOp.Add(m$.var("YI",2).get(),1))) {
      YI.var(3).set(m$.Fnc.$extract(m$.Fnc.$piece(YI.var(1).get(),",",YI.var(2).get()),2,9));
      if (mOp.Equal(YI.var(3).get(),"")) {
        break;
      }
      RETURN.set(mOp.Concat(RETURN.get(),m$.Fnc.$char(mOp.Divide(YI.var(3).get(),9))));
    }
    //<< QUIT RETURN
    return RETURN.get();
  }

  //<< 
  //<< SET(YPWD)
  public Object SET(Object ... _p) {
    mVar YPWD = m$.newVarRef("YPWD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert plain text to code    ; UMWANDELN
    //<< ;
    //<< ; Inputs :
    //<< ;   YPWD        Plain Text
    //<< ;
    //<< ; Returns :     if switch set   Code
    //<< ;               else            YPWD unaltered
    //<< ;
    //<< ; History :
    //<< ; 02-Jan-2007   GRF     BR014748 - commented YI(1) line copied from original code.
    //<< ; 07.01.2004    TYBD    Created
    //<< ;-------------------------------------------------------------------------------
    //<< NEW RETURN,YI
    mVar RETURN = m$.var("RETURN");
    mVar YI = m$.var("YI");
    m$.newVar(RETURN,YI);
    //<< 
    //<< SET RETURN=$GET(YPWD)
    RETURN.set(m$.Fnc.$get(YPWD));
    //<< ;   D148    $$$WWW012PasswordEncrypted()
    //<< IF $PIECE($GET(^WWW012(0,YM,1)),Y,148)'=1 QUIT RETURN  ;AUSGESCHALTET
    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),148),1)) {
      return RETURN.get();
    }
    //<< QUIT:$EXTRACT($GET(YPWD),1,2)="^1" RETURN              ;SCHON UMGESETZT ;yet
    if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(YPWD),1,2),"^1")) {
      return RETURN.get();
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;  FIXME : <GRF> Should have some function to provide a dummy encryption for
    //<< ;                unset passwords.
    //<< ;  e.g. generate random number between 2000 and 99999 and append to "^"
    //<< ;  thus ^1###[,####] is valid
    //<< ;  and  ^2###[,####] through ^9###[,####] represents ""
    //<< ;
    //<< ;  Would need to amend CHECK and WWWPWDCHECK.
    //<< ;
    //<< ;  NOTE : The encryption mechanism used below stores the same encrypted text for
    //<< ;         the same plain text as well as having a one to one match with the
    //<< ;         password length and is an inferior mechanism.
    //<< ;---------------------------------------
    //<< IF $GET(YPWD)="" QUIT RETURN  ;KEIN PASSWORD ;no password
    if (mOp.Equal(m$.Fnc.$get(YPWD),"")) {
      return RETURN.get();
    }
    //<< 
    //<< ;SET YI(1)=$EXTRACT(YPWD,2,999)                        ; This is not used
    //<< SET RETURN="^"
    RETURN.set("^");
    //<< FOR YI(2)=1:1:$LENGTH(YPWD) SET RETURN=RETURN_1_($ASCII($EXTRACT(YPWD,YI(2)))*9)_","
    for (m$.var("YI",2).set(1);(mOp.LessOrEqual(m$.var("YI",2).get(),m$.Fnc.$length(YPWD.get())));m$.var("YI",2).set(mOp.Add(m$.var("YI",2).get(),1))) {
      RETURN.set(mOp.Concat(mOp.Concat(mOp.Concat(RETURN.get(),1),(mOp.Multiply(m$.Fnc.$ascii(m$.Fnc.$extract(YPWD.get(),YI.var(2).get())),9))),","));
    }
    //<< QUIT RETURN
    return RETURN.get();
  }

  //<< 
  //<< 
  //<< CHECK(pPWD1="",pPWD2="")
  public Object CHECK(Object ... _p) {
    mVar pPWD1 = m$.newVarRef("pPWD1",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pPWD2 = m$.newVarRef("pPWD2",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; This check handles both encrypted and unencrypted passwords.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-Jan-2007   GRF     BR014748 - commented blnCheck line.
    //<< ; 01-Nov-2007   shobby  SRBR014748: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strPWDDecoded1,strPWDDecoded2
    mVar strPWDDecoded1 = m$.var("strPWDDecoded1");
    mVar strPWDDecoded2 = m$.var("strPWDDecoded2");
    m$.newVar(strPWDDecoded1,strPWDDecoded2);
    //<< 
    //<< set pPWD1=$$$UPPER(pPWD1)
    pPWD1.set(include.COMSYSString.$$$UPPER(m$,pPWD1));
    //<< set pPWD2=$$$UPPER(pPWD2)
    pPWD2.set(include.COMSYSString.$$$UPPER(m$,pPWD2));
    //<< set strPWDDecoded1=$$$UPPER($$^WWWPWDCHECK(pPWD1))
    strPWDDecoded1.set(include.COMSYSString.$$$UPPER(m$,m$.fnc$("WWWPWDCHECK.main",pPWD1.get())));
    //<< set strPWDDecoded2=$$$UPPER($$^WWWPWDCHECK(pPWD2))
    strPWDDecoded2.set(include.COMSYSString.$$$UPPER(m$,m$.fnc$("WWWPWDCHECK.main",pPWD2.get())));
    //<< ;set blnCheck=$$$NO                                    ; This is not used
    //<< quit (pPWD1=pPWD2)||(strPWDDecoded1=strPWDDecoded2)
    return (mOp.Equal(pPWD1.get(),pPWD2.get())) || (mOp.Equal(strPWDDecoded1.get(),strPWDDecoded2.get()));
  }

//<< 
//<< 
}
