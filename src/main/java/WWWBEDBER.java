//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWBEDBER
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:00
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWBEDBER(pidUser)
public class WWWBEDBER extends mClass {

  public Object main(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWBEDBER(pidUser);
  }

  public Object _WWWBEDBER(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns an ordered list of access levels for a given user.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 14-Aug-2007   shobby  SRBR014321: If the system administrator has other
    //<< ;                           permissions just assume they are a system admin
    //<< ; 29-Nov-2006   JW      SR15205: Doco. Rewritten
    //<< ; 11.09.2000    DT      BERECHTIGUNG DES USER
    //<< ;-------------------------------------------------------------------------------
    //<< new strAccess
    mVar strAccess = m$.var("strAccess");
    m$.newVar(strAccess);
    //<< 
    //<< set strAccess = 99      // If no user is logged in, set access to 99
    strAccess.set(99);
    //<< if $get(pidUser)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidUser),"")) {
      //<< set strAccess = $translate($$$WWW013UserAccess($get(^WWW013(0,pidUser,1))),";",",")
      strAccess.set(m$.Fnc.$translate(include.WWWConst.$$$WWW013UserAccess(m$,m$.Fnc.$get(m$.var("^WWW013",0,pidUser.get(),1))),";",","));
      //<< if (","_strAccess_",")[",1," {
      if (mOp.Contains((mOp.Concat(mOp.Concat(",",strAccess.get()),",")),",1,")) {
        //<< set strAccess = 1
        strAccess.set(1);
      }
      //<< } else {
      else {
        //<< set strAccess = $$SortString^COMUtilStr(strAccess)
        strAccess.set(m$.fnc$("COMUtilStr.SortString",strAccess.get()));
      }
      //<< }
      //<< 
      //<< if strAccess="" set strAccess = 0   // If user has no access, set it to 0  -- FIXME ?
      if (mOp.Equal(strAccess.get(),"")) {
        strAccess.set(0);
      }
    }
    //<< }
    //<< quit strAccess
    return strAccess.get();
  }

//<< 
//<< 
}
