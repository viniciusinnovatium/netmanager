//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWUSER
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:01
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
//<< #include WWWConst
import include.WWWConst;

//<< WWWUSER
public class WWWUSER extends mClass {

  public void main() {
    _WWWUSER();
  }

  public void _WWWUSER() {
  }

  //<< 
  //<< GetChildUser(pidUser)
  public Object GetChildUser(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;--------------------------------------------------------------------------------
    //<< ; Get a child user id for the current user
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Jan-2007   JW      BR014262: Changed "-" to "x" to resolve multiple problems.
    //<< ; 19-Apr-2006   JW      Only have two levels of YUSER
    //<< ; 10-Nov-2005   JW      SR13817: Created
    //<< ;---------------------------------------------------------------------------------
    //<< new idChildUser
    mVar idChildUser = m$.var("idChildUser");
    m$.newVar(idChildUser);
    //<< 
    //<< set pidUser = $$$GetParentUser(pidUser)
    pidUser.set(include.COMSYSWWW.$$$GetParentUser(m$,pidUser));
    //<< do {
    //<< //set idChildUser = pidUser_"-"_$random(1000)
    //<< set idChildUser = pidUser_"x"_$random(1000)     //BR014262
    do {
      idChildUser.set(mOp.Concat(mOp.Concat(pidUser.get(),"x"),m$.Fnc.$random(1000)));
    }
    //<< } while ($data(^WWWUSER(0,idChildUser)))
    while (mOp.Logical((m$.Fnc.$data(m$.var("^WWWUSER",0,idChildUser.get())))));
    //<< 
    //<< quit idChildUser
    return idChildUser.get();
  }

  //<< 
  //<< 
  //<< CopyParent(pidUser,pblnNewSession=$$$YES)
  public Object CopyParent(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnNewSession = m$.newVarRef("pblnNewSession",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    //<< ;--------------------------------------------------------------------------------
    //<< ; If no data in current user, copy from GetParentUser.
    //<< ;
    //<< ; Params:   pidUser         - child user
    //<< ;           pblnNewSession  - if we are opening a new browser session (window)
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: null. writes to current user if null.
    //<< ;
    //<< ; History:
    //<< ; 18-Dec-2006   JW      BR014262: Set frame formed to null. Added pblnNewSession
    //<< ; 27-Mar-2006   SC      SR13942: Created
    //<< ;---------------------------------------------------------------------------------
    //<< new idParentUser,objUser
    mVar idParentUser = m$.var("idParentUser");
    mVar objUser = m$.var("objUser");
    m$.newVar(idParentUser,objUser);
    //<< 
    //<< if '$data(^WWWUSER(0,pidUser,1)) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWWUSER",0,pidUser.get(),1)))) {
      //<< set idParentUser = $$$GetParentUser(pidUser)
      idParentUser.set(include.COMSYSWWW.$$$GetParentUser(m$,pidUser));
      //<< if idParentUser'="" {   //SR13817 - child user
      if (mOp.NotEqual(idParentUser.get(),"")) {
        //<< 
        //<< set objUser = $get(^WWWUSER(0,idParentUser,1))      // BR014262
        objUser.set(m$.Fnc.$get(m$.var("^WWWUSER",0,idParentUser.get(),1)));
        //<< if pblnNewSession set $$$WWWUSERFrameFormed(objUser)=""
        if (mOp.Logical(pblnNewSession.get())) {
          include.WWWConst.$$$WWWUSERFrameFormedSet(m$,objUser,"");
        }
        //<< set ^WWWUSER(0,pidUser,1) = objUser
        m$.var("^WWWUSER",0,pidUser.get(),1).set(objUser.get());
      }
    }
    //<< 
    //<< //set ^WWWUSER(0,pidUser,1) = $get(^WWWUSER(0,idParentUser,1))  BR014262
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< NewUser(pidUser,pblnNewSession=$$$YES)
  public Object NewUser(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnNewSession = m$.newVarRef("pblnNewSession",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create a new user
    //<< ;
    //<< ; History:
    //<< ; 11-Apr-2013   shobby  CORE-70: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWWUser,idUser
    mVar objWWWUser = m$.var("objWWWUser");
    mVar idUser = m$.var("idUser");
    m$.newVar(objWWWUser,idUser);
    //<< set objWWWUser=^WWWUSER(0,pidUser,1)
    objWWWUser.set(m$.var("^WWWUSER",0,pidUser.get(),1).get());
    //<< set idUser=$$NewUserSession^WWWUSER()
    idUser.set(m$.fnc$("WWWUSER.NewUserSession"));
    //<< set $$$WWWUSERFrameFormed(^WWWUSER(0,objWWWUser,1))=""
    include.WWWConst.$$$WWWUSERFrameFormedSet(m$,m$.var("^WWWUSER",0,objWWWUser.get(),1),"");
    //<< set ^WWWUSER(0,idUser,1)=objWWWUser
    m$.var("^WWWUSER",0,idUser.get(),1).set(objWWWUser.get());
    //<< quit idUser
    return idUser.get();
  }

  //<< 
  //<< 
  //<< CreateChildUser(pidUser,pblnNewSession=$$$YES)
  public Object CreateChildUser(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnNewSession = m$.newVarRef("pblnNewSession",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get a child user and create its WWWUSER record.
    //<< ;
    //<< ; Params:   pidUser         - parent user
    //<< ;           pblnNewSession  - if we are opening a new browser session (window)
    //<< ;
    //<< ; Returns:  child id
    //<< ;
    //<< ; History:
    //<< ; 11-Jan-2007   JW      SRBR014262: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idChildUser
    mVar idChildUser = m$.var("idChildUser");
    m$.newVar(idChildUser);
    //<< 
    //<< set idChildUser = $$GetChildUser^WWWUSER(pidUser)
    idChildUser.set(m$.fnc$("WWWUSER.GetChildUser",pidUser.get()));
    //<< do CopyParent^WWWUSER(idChildUser,pblnNewSession)
    m$.Cmd.Do("WWWUSER.CopyParent",idChildUser.get(),pblnNewSession.get());
    //<< 
    //<< quit idChildUser
    return idChildUser.get();
  }

  //<< 
  //<< 
  //<< NewUserSession(pstrSource="")
  public Object NewUserSession(Object ... _p) {
    mVar pstrSource = m$.newVarRef("pstrSource",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create New User Session (YUSER) which is unique across namespaces
    //<< ;
    //<< ;     set YUSER = $$NewUserSession^WWWUSER("audit string")
    //<< ;     then construct ^WWWUSER(0,YUSER,1)
    //<< ;
    //<< ;
    //<< ; Returns:  session id (YUSER) and builds ^CacheTempSession(YUSER)
    //<< ;
    //<< ; History:
    //<< ; 30-Apr-2010   GRF     -: Add second "1" to break up long string of zeros in
    //<< ;                           initial value (for developers benefit);  initialise
    //<< ;                           outside FOR loop
    //<< ; 19-Feb-2009   FIS     SR16065: store Client IP in CacheTempSession
    //<< ; 15-Jan-2009   GRF     SR15853: to retain unpredictability add random component
    //<< ;                           to the increment; added pstrSource
    //<< ; 14-Jan-2009   FIS     SR15853: re-written using $increment - no need to lock,
    //<< ;                           no $random required
    //<< ; 14-Jan-2009   FIS     SR15853: 11 digits session id to not correlate with 10
    //<< ;                           digit PID ($job)
    //<< ; 18-Aug-2008   FIS     SR15853: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idSession
    mVar idSession = m$.var("idSession");
    m$.newVar(idSession);
    //<< 
    //<< ;for {
    //<< ;   if (+$get(^CacheTempSession) = 0) {      ; Initiate with 11 digits
    //<< ;;      set idSession = $increment(^CacheTempSession,10000000000+$random(100000))
    //<< ;       set idSession = $increment(^CacheTempSession,10010000000+$random(100000))
    //<< ;   } else {
    //<< ;       set idSession = $increment(^CacheTempSession,1+$random(10000))
    //<< ;   }
    //<< ;   quit:'$data(^WWWUSER(0,idSession))  //old data, not removed yet
    //<< ;}
    //<< 
    //<< if ($get(^CacheTempSession)<10010000000) set ^CacheTempSession = 10010000000   ; Initialise with 11 digits
    if ((mOp.Less(m$.Fnc.$get(m$.var("^CacheTempSession")),10010000000D))) {
      m$.var("^CacheTempSession").set(10010000000D);
    }
    //<< for {
    for (;true;) {
      //<< set idSession = $increment(^CacheTempSession,1+$random(10000))
      idSession.set(m$.Fnc.$increment(m$.var("^CacheTempSession"),mOp.Add(1,m$.Fnc.$random(10000))));
      //<< quit:'$data(^WWWUSER(0,idSession))  //old data, not removed yet
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWWUSER",0,idSession.get())))) {
        break;
      }
    }
    //<< }
    //<< 
    //<< set ^CacheTempSession(idSession) = $listbuild($job,$zutil(5),pstrSource,$select($get(%request)'="":%request.CgiEnvs("REMOTE_ADDR"),1:$get(%CGIEVAR("HTTP_USER_AGENT"))))
    m$.var("^CacheTempSession",idSession.get()).set(m$.Fnc.$listbuild(m$.Fnc.$job(),m$.Fnc.$zutil(5),pstrSource.get(),m$.Fnc.$select(mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),""),m$.getRequest().getCgiEnvs("REMOTE_ADDR"),1,m$.Fnc.$get(m$.var("%CGIEVAR","HTTP_USER_AGENT")))));
    //<< set ^CacheTempSessionStart(+$horolog,idSession) = $listbuild($horolog,$zhorolog)
    m$.var("^CacheTempSessionStart",mOp.Positive(m$.Fnc.$horolog()),idSession.get()).set(m$.Fnc.$listbuild(m$.Fnc.$horolog(),m$.Fnc.$zhorolog()));
    //<< 
    //<< quit idSession
    return idSession.get();
  }

  //<< 
  //<< 
  //<< LogAction(idSession)
  public Object LogAction(Object ... _p) {
    mVar idSession = m$.newVarRef("idSession",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Log last Action Event
    //<< ;
    //<< ; History:
    //<< ; 19-Feb-2009   FIS     SR16065: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set ^CacheTempSessionLastAction(idSession) = $listbuild($horolog,$zhorolog)
    m$.var("^CacheTempSessionLastAction",idSession.get()).set(m$.Fnc.$listbuild(m$.Fnc.$horolog(),m$.Fnc.$zhorolog()));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< EndSession(idSession)
  public Object EndSession(Object ... _p) {
    mVar idSession = m$.newVarRef("idSession",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Flag Session As Ended
    //<< ;
    //<< ; History:
    //<< ; 19-Feb-2009   FIS     SR16065: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set ^CacheTempSessionEnd(idSession) = $listbuild($horolog,$zhorolog)
    m$.var("^CacheTempSessionEnd",idSession.get()).set(m$.Fnc.$listbuild(m$.Fnc.$horolog(),m$.Fnc.$zhorolog()));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetActiveSessions(arrActiveSessions,intCount)
  public Object GetActiveSessions(Object ... _p) {
    mVar arrActiveSessions = m$.newVarRef("arrActiveSessions",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar intCount = m$.newVarRef("intCount",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return Current Session Numbers in an Array
    //<< ;
    //<< ; ByRef arrActiveSessions (as global array)
    //<< ; OR
    //<< ; Global Ref. arrActiveSessions (ie. "^CacheTempCurrentSessions")
    //<< ;
    //<< ; ByRef intCount (returns total number of open sessions)
    //<< ;
    //<< ; History:
    //<< ; 27-Feb-2009   FIS     SR16065: Web Service Session added
    //<< ; 27-Feb-2009   FIS     SR16065: ByRef intCount added to return number of sessions
    //<< ; 19-Feb-2009   FIS     SR16065: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new dteDay,idSession,sqlRS
    mVar dteDay = m$.var("dteDay");
    mVar idSession = m$.var("idSession");
    mVar sqlRS = m$.var("sqlRS");
    m$.newVar(dteDay,idSession,sqlRS);
    //<< set intCount = $get(intCount)
    intCount.set(m$.Fnc.$get(intCount));
    //<< 
    //<< // Alphalinc User Sessions
    //<< // -----------------------
    //<< for dteDay = +$horolog-1,+$horolog {  //sessions started yesterday or today only
    for (Object _dteDay: new Object[] {mOp.Subtract(mOp.Positive(m$.Fnc.$horolog()),1),mOp.Positive(m$.Fnc.$horolog())}) {
    dteDay.set(_dteDay);
      //<< set idSession = ""
      idSession.set("");
      //<< for {
      for (;true;) {
        //<< set idSession = $order(^CacheTempSessionStart(dteDay,idSession))
        idSession.set(m$.Fnc.$order(m$.var("^CacheTempSessionStart",_dteDay,idSession.get())));
        //<< quit:idSession=""
        if (mOp.Equal(idSession.get(),"")) {
          break;
        }
        //<< 
        //<< continue:'$data(^WWWUSER(0,idSession))           //invalid session id
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWWUSER",0,idSession.get())))) {
          continue;
        }
        //<< continue:'$data(^CacheTempSession(idSession))    //invalid session id
        if (mOp.Not(m$.Fnc.$data(m$.var("^CacheTempSession",idSession.get())))) {
          continue;
        }
        //<< continue:$listget(^CacheTempSession(idSession),2)'=$zu(5)  //count own namespce only
        if (mOp.NotEqual(m$.Fnc.$listget(m$.var("^CacheTempSession",idSession.get()).get(),2),m$.Fnc.$zutil(5))) {
          continue;
        }
        //<< continue:$data(^CacheTempSessionEnd(idSession))  //Session Ended
        if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempSessionEnd",idSession.get())))) {
          continue;
        }
        //<< continue:'$data(^CacheTempSessionLastAction(idSession))
        if (mOp.Not(m$.Fnc.$data(m$.var("^CacheTempSessionLastAction",idSession.get())))) {
          continue;
        }
        //<< 
        //<< set dteLastAction = $listget(^CacheTempSessionLastAction(idSession),1)
        mVar dteLastAction = m$.var("dteLastAction");
        dteLastAction.set(m$.Fnc.$listget(m$.var("^CacheTempSessionLastAction",idSession.get()).get(),1));
        //<< 
        //<< if (+dteLastAction = +$horolog) && ($piece(dteLastAction,",",2) < ($piece($horolog,",",2)-900)) continue  //session not active
        if ((mOp.Equal(mOp.Positive(dteLastAction.get()),mOp.Positive(m$.Fnc.$horolog()))) && (mOp.Less(m$.Fnc.$piece(dteLastAction.get(),",",2),(mOp.Subtract(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),900))))) {
          continue;
        }
        //<< if (+dteLastAction < +$horolog) && ($piece($horolog,",",2) > 900) continue  //session not active
        if ((mOp.Less(mOp.Positive(dteLastAction.get()),mOp.Positive(m$.Fnc.$horolog()))) && (mOp.Greater(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),900))) {
          continue;
        }
        //<< 
        //<< set intCount = intCount + 1  //FIS;27-Feb-2009
        intCount.set(mOp.Add(intCount.get(),1));
        //<< 
        //<< if $extract($get(arrActiveSessions)) = "^" {
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(arrActiveSessions)),"^")) {
          //<< set @arrActiveSessions@(idSession)=""
          m$.indirectVar(arrActiveSessions.get()).var(idSession.get()).set("");
        }
        //<< } else {
        else {
          //<< set arrActiveSessions(idSession)=""
          arrActiveSessions.var(idSession.get()).set("");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< // Alphalinc Web Service Sessions
    //<< // ------------------------------
    //<< do ##class(alWEB.WS.Session).ClearSessions()  //delete all old sessions
    m$.Cmd.Do("alWEB.WS.Session.ClearSessions");
    //<< set sqlRS = ##class(%Library.ResultSet).%New()
    sqlRS.set(m$.fnc$("$Library.ResultSet.$New"));
    //<< if (sqlRS.Prepare("SELECT %ID FROM alWEB_WS.Session")) {
    if (mOp.Logical((m$.fnc$(sqlRS.getORef(),"Prepare","SELECT %ID FROM alWEB_WS.Session")))) {
      //<< if (sqlRS.Execute()) {
      if (mOp.Logical((m$.fnc$(sqlRS.getORef(),"Execute")))) {
        //<< while (sqlRS.Next()) {
        while (mOp.Logical((m$.fnc$(sqlRS.getORef(),"Next")))) {
          //<< set idSession = sqlRS.Get("ID")
          idSession.set(m$.fnc$(sqlRS.getORef(),"Get","ID"));
          //<< if (idSession '= "") && (##class(alWEB.WS.Session).ValidateSession(idSession) = 1) {
          if ((mOp.NotEqual(idSession.get(),"")) && (mOp.Equal(m$.fnc$("alWEB.WS.Session.ValidateSession",idSession.get()),1))) {
            //<< set intCount = intCount + 1
            intCount.set(mOp.Add(intCount.get(),1));
            //<< if $extract($get(arrActiveSessions)) = "^" {
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(arrActiveSessions)),"^")) {
              //<< set @arrActiveSessions@("WS"_idSession)=""
              m$.indirectVar(arrActiveSessions.get()).var(mOp.Concat("WS",idSession.get())).set("");
            }
            //<< } else {
            else {
              //<< set arrActiveSessions("WS"_idSession)=""
              arrActiveSessions.var(mOp.Concat("WS",idSession.get())).set("");
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

//<< 
//<< 
//<< 
//<< 
}
