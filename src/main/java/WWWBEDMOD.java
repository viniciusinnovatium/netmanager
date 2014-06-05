//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWBEDMOD
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:45
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWBEDMOD(pidUser)
public class WWWBEDMOD extends mClass {

  public Object main(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWBEDMOD(pidUser);
  }

  public Object _WWWBEDMOD(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Returns a string of module access levels for a given user.
    //<< ;       USER MODULE AUTHORISATION
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; Returns : Module Access list (comma-delimited)
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 29-Nov-2006   JW      SR15205: Doco. Rewritten
    //<< ; 11.09.2000    DT      MODUL BEREICHIGUNG DES USER
    //<< ;-------------------------------------------------------------------------------
    //<< new strAccess
    mVar strAccess = m$.var("strAccess");
    m$.newVar(strAccess);
    //<< 
    //<< set strAccess=""
    strAccess.set("");
    //<< if $get(pidUser)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidUser),"")) {
      //<< set strAccess = $translate($$$WWW013Module1($GET(^WWW013(0,pidUser,1))),";",",")
      strAccess.set(m$.Fnc.$translate(include.WWWConst.$$$WWW013Module1(m$,m$.Fnc.$get(m$.var("^WWW013",0,pidUser.get(),1))),";",","));
    }
    //<< }
    //<< quit strAccess
    return strAccess.get();
  }

//<< 
//<< 
}
