//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUtilCookie
//** Innovatium Systems - Code Converter - v1.24
//** 2014-06-02 16:12:08
//*****************************************************************************

import mLibrary.*;

//<< 
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

//<< COMUtilCookie
public class COMUtilCookie extends mClass {

  public void main() {
    _COMUtilCookie();
  }

  public void _COMUtilCookie() {
  }

  //<< 
  //<< AddCookie(pidSession="")
  public Object AddCookie(Object ... _p) {
    mVar pidSession = m$.newVarRef("pidSession",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add a cookie common across all namespaces.  Basically this keeps a count on the
    //<< ; number of successful logins to Alphalinc across all namespaces as the %session.SessionId
    //<< ; will be common across multiply browser sessions running on the same PC and the
    //<< ; same instance of Cache.
    //<< ;
    //<< ; Params:
    //<< ;           pidSession:The value of the %session.SessionId
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Oct-2009   shobby  SR16948: Leave a cookie here for the original URL
    //<< ; 20-Mar-2007   RPW     SRBR014275: + on $h is faster here.
    //<< ; 19-Mar-2007   shobby  SRBR014275: Renamed global from ^["%SYS"]AlphalincCookie
    //<< ; 19-Mar-2007   shobby  SRBR014275: Created
    //<< ;-------------------------------------------------------------------------------
    //<< do CleanUp()
    m$.Cmd.Do("CleanUp");
    //<< set ^CacheTempCookie(pidSession,$order(^CacheTempCookie(pidSession,""),-1)+1) = +$horolog
    m$.var("^CacheTempCookie",pidSession.get(),mOp.Add(m$.Fnc.$order(m$.var("^CacheTempCookie",pidSession.get(),""),mOp.Negative(1)),1)).set(mOp.Positive(m$.Fnc.$horolog()));
    //<< if ($get(YUCI)'="") && ($get(YUSER)'="") && ($get(YXURL)'="") set ^CacheTempURL(YUCI,YUSER) = YXURL  ;16948
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YUCI")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YXURL")),""))) {
      m$.var("^CacheTempURL",m$.var("YUCI").get(),m$.var("YUSER").get()).set(m$.var("YXURL").get());
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< RemoveCookie(pidSession="")
  public Object RemoveCookie(Object ... _p) {
    mVar pidSession = m$.newVarRef("pidSession",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Removes the cookies created in AddCookie.  Removed in reverse order by date/time.
    //<< ; It is not really important in which order they are removed only to know when the
    //<< ; last one is about to be removed so that the %session.SessionId can be ended freeing
    //<< ; up a license on cache.
    //<< ;
    //<< ; Params:
    //<< ;           pidSession:The value of the %session.SessionId
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;           A flag indicating whether the last cookie has been removed and the
    //<< ;           session can be ended.
    //<< ;
    //<< ; History:
    //<< ; 19-Mar-2007   shobby  SRBR014275: Renamed global from ^["%SYS"]AlphalincCookie
    //<< ; 19-Mar-2007   shobby  SRBR014275: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCookie
    mVar idCookie = m$.var("idCookie");
    m$.newVar(idCookie);
    //<< 
    //<< do CleanUp()
    m$.Cmd.Do("CleanUp");
    //<< set idCookie = $order(^CacheTempCookie(pidSession,""),-1)
    idCookie.set(m$.Fnc.$order(m$.var("^CacheTempCookie",pidSession.get(),""),mOp.Negative(1)));
    //<< if idCookie'="" {
    if (mOp.NotEqual(idCookie.get(),"")) {
      //<< kill ^CacheTempCookie(pidSession,idCookie)
      m$.var("^CacheTempCookie",pidSession.get(),idCookie.get()).kill();
    }
    //<< }
    //<< quit '$data(^CacheTempCookie(pidSession))
    return mOp.Not(m$.Fnc.$data(m$.var("^CacheTempCookie",pidSession.get())));
  }

  //<< 
  //<< 
  //<< CleanUp()
  public Object CleanUp(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Remove orphaned cookies that are still here because of system crashes.  Actually
    //<< ; the session id will have already been cleaned up by Cache (after about 20 minutes)
    //<< ; but if we ever get to reuse the same sessionid we don't want interference from
    //<< ; crashed sessions.  Actually the chance of reuse of a sessionid outside of the
    //<< ; reuse expected from the same user on the same pc running multiple versions of
    //<< ; Alphalinc is probably 1 in 839,299,365,868,340,224
    //<< ; but might as well do the cleanup anyway.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-May-2010   GRF     -: replace order macro
    //<< ; 20-Mar-2007   RPW     SRBR014275: + is not needed on $h here.
    //<< ; 19-Mar-2007   shobby  SRBR014275: Renamed global from ^["%SYS"]AlphalincCookie
    //<< ; 19-Mar-2007   shobby  SRBR014275: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intCookie,dteDate,idSession
    mVar intCookie = m$.var("intCookie");
    mVar dteDate = m$.var("dteDate");
    mVar idSession = m$.var("idSession");
    m$.newVar(intCookie,dteDate,idSession);
    //<< 
    //<< set idSession = ""
    idSession.set("");
    //<< for {
    for (;true;) {
      //<< set idSession = $order(^CacheTempCookie(idSession))
      idSession.set(m$.Fnc.$order(m$.var("^CacheTempCookie",idSession.get())));
      //<< quit:idSession=""
      if (mOp.Equal(idSession.get(),"")) {
        break;
      }
      //<< 
      //<< set intCookie = ""
      intCookie.set("");
      //<< for {
      for (;true;) {
        //<< set intCookie = $order(^CacheTempCookie(idSession,intCookie))
        intCookie.set(m$.Fnc.$order(m$.var("^CacheTempCookie",idSession.get(),intCookie.get())));
        //<< quit:intCookie=""
        if (mOp.Equal(intCookie.get(),"")) {
          break;
        }
        //<< 
        //<< set dteDate = $get(^CacheTempCookie(idSession,intCookie))
        dteDate.set(m$.Fnc.$get(m$.var("^CacheTempCookie",idSession.get(),intCookie.get())));
        //<< if ($horolog-dteDate)>2 {
        if (mOp.Greater((mOp.Subtract(m$.Fnc.$horolog(),dteDate.get())),2)) {
          //<< kill ^CacheTempCookie(idSession,intCookie)
          m$.var("^CacheTempCookie",idSession.get(),intCookie.get()).kill();
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

//<< 
}
