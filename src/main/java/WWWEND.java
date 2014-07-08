//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWEND
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-08 11:15:07
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

//<< WWWEND
public class WWWEND extends mClass {

  public void main() {
    _WWWEND();
  }

  public void _WWWEND() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SESSION ENDE
    //<< ;
    //<< ; Note: **** Redundant after SR16427
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 23-Mar-2009   shobby  SR16427: Don't load the temporary close down form.
    //<< ; 19-Mar-2009   shobby  SR16427: Changed the 'job CleanUpBackground' to
    //<< ;                           'do CleanUpBackground' (much faster now)
    //<< ; 18-Feb-2009   FIS     SR16065: added tiemout to work properly (needs time to
    //<< ;                           start the job)
    //<< ; xx-Mar-2007   Shobby  SRBR014275: Call new cookie code.
    //<< ; 18-Jan-2007   Steve S SR15355: Pass company to the clean up routine
    //<< ; 19-Dec-2006   JW      BR014262: Only end session for parent user.
    //<< ; 05-May-2006   Steve S SR14508: Clean up Cache Temp's, multi-locks
    //<< ; 13-Apr-2006   JW      Removed + from user id's in lock check
    //<< ; 13-Dec-2005   Steve S SR14019: Do NOT call WWWVAR -- this will change YUSER!!!
    //<< ; 21.04.2002    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< WRITE "<HTML>"
    m$.Cmd.Write("<HTML>");
    //<< WRITE "<BODY"
    m$.Cmd.Write("<BODY");
    //<< ;WRITE " onload=""window.Parent.close();self.close()"""
    //<< ;WRITE " onLoad=""self.close()"""
    //<< WRITE " onLoad=""window.setTimeout('self.close()',500);"""       //SR16065
    m$.Cmd.Write(" onLoad=\"window.setTimeout('self.close()',500);\"");
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< ;WRITE "document.close();"
    //<< WRITE "window.setTimeout('document.close()',500);"              //SR16065
    m$.Cmd.Write("window.setTimeout('document.close()',500);");
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< WRITE "<input type=button value=Close onClick=""self.close()"">"
    m$.Cmd.Write("<input type=button value=Close onClick=\"self.close()\">");
    //<< do CleanUpBackground(YM,YUSER)                                  //SR15355 ;SR16427
    m$.Cmd.Do("CleanUpBackground",m$.var("YM").get(),m$.var("YUSER").get());
    //<< //job CleanUpBackground(YUSER)                                  //SR14508
    //<< WRITE "</BODY>",YCR
    m$.Cmd.Write("</BODY>",m$.var("YCR").get());
    //<< WRITE "</HTML>",YCR
    m$.Cmd.Write("</HTML>",m$.var("YCR").get());
    //<< if $$$IsTopUser(YUSER) && ($get(YHYPER)=1) && ($data(%session)) {    //BR014262
    if (mOp.Logical(include.COMSYSWWW.$$$IsTopUser(m$,m$.var("YUSER"))) && (mOp.Equal(m$.Fnc.$get(m$.var("YHYPER")),1)) && mOp.Logical((m$.Fnc.$data(m$.getSession())))) {
      //<< if $$RemoveCookie^COMUtilCookie(%session.SessionId) {             ;BR014275
      if (mOp.Logical(m$.fnc$("COMUtilCookie.RemoveCookie",m$.getSession().getSessionId()))) {
      }
    }
    //<< ;set %session.EndSession = 1 ;shobby 25-Nov-2009.  Testing.  Is this what causes timeout errors?
    //<< }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< End(YM,YUSER)
  public Object End(Object ... _p) {
    mVar YM = m$.newVarRef("YM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YUSER = m$.newVarRef("YUSER",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Replacement for the main WWWEND routine.  It should not be necessary to load a
    //<< ; temporary form to close another form.
    //<< ; This is called directly (see example in WWWMENU5)
    //<< ;
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; 19-Mar-2009   shobby  SR16427: Created
    //<< ;-------------------------------------------------------------------------------
    //<< do CleanUpBackground(YM,YUSER)
    m$.Cmd.Do("CleanUpBackground",YM.get(),YUSER.get());
    //<< if $$$IsTopUser(YUSER) && ($get(YHYPER)=1) && ($data(%session)) {       //BR014262
    if (mOp.Logical(include.COMSYSWWW.$$$IsTopUser(m$,YUSER)) && (mOp.Equal(m$.Fnc.$get(m$.var("YHYPER")),1)) && mOp.Logical((m$.Fnc.$data(m$.getSession())))) {
      //<< if $$RemoveCookie^COMUtilCookie(%session.SessionId) {                ;BR014275
      if (mOp.Logical(m$.fnc$("COMUtilCookie.RemoveCookie",m$.getSession().getSessionId()))) {
      }
    }
    //<< ;set %session.EndSession = 1  ;shobby 25-Nov-2009.  Testing.  Is this what causes timeout errors?
    //<< }
    //<< }
    //<< quit 1
    return 1;
  }

  //<< 
  //<< 
  //<< CleanUpBackground(pYM,pYUSER)
  public Object CleanUpBackground(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYUSER = m$.newVarRef("pYUSER",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Clean up any old session-based data when logging out.
    //<< ;
    //<< ; Params:   pYM         : The company number
    //<< ;           pYUSER      : The YUSER number
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Nov-2011   shobby  SR17936: Clean up WWWDATEN when window is closed or returned
    //<< ;                                to the Login screen.
    //<< ; 02-Mar-2010   shobby  SR17208: Improved fast version of cleanup.
    //<< ; 07-Aug-2009   shobby  SR16758: If ending the session remove any left over locks.
    //<< ; 19-Mar-2009   shobby  SR16427: Subroutine ordering through CacheTemp globals
    //<< ; 19-Feb-2009   FIS     SR16065: keep CacheTempSession*, mark session as ended
    //<< ; 18-Jan-2007   Steve S SR15355: Clear off COMTempList entries
    //<< ;                            Clear off YUCI-based CacheTemp's
    //<< ; 19-Dec-2006   JW      BR014262: Reset frame formed.
    //<< ; 12-May-2006   Steve S SR14508: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YUSER,Y,YM,strNS,strUser
    mVar YUSER = m$.var("YUSER");
    mVar Y = m$.var("Y");
    mVar YM = m$.var("YM");
    mVar strNS = m$.var("strNS");
    mVar strUser = m$.var("strUser");
    m$.newVar(YUSER,Y,YM,strNS,strUser);
    //<< 
    //<< set YUSER = pYUSER
    YUSER.set(pYUSER.get());
    //<< set Y     = "~"
    Y.set("~");
    //<< set YM    = pYM
    YM.set(pYM.get());
    //<< set strNS = $zutil(5)
    strNS.set(m$.Fnc.$zutil(5));
    //<< 
    //<< if $data(^CacheTempLockInterest(YUSER)) { ;SR16758
    if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempLockInterest",YUSER.get())))) {
      //<< do RemoveLockingInterest^COMLock($piece(^CacheTempLockInterest(YUSER),Y,1),$piece(^CacheTempLockInterest(YUSER),Y,1))
      m$.Cmd.Do("COMLock.RemoveLockingInterest",m$.Fnc.$piece(m$.var("^CacheTempLockInterest",YUSER.get()).get(),Y.get(),1),m$.Fnc.$piece(m$.var("^CacheTempLockInterest",YUSER.get()).get(),Y.get(),1));
    }
    //<< }
    //<< 
    //<< // Kill off old ^WWW006 entries
    //<< do CleanUpLocks^WWW006(YUSER,$$$YES)
    m$.Cmd.Do("WWW006.CleanUpLocks",YUSER.get(),include.COMSYS.$$$YES(m$));
    //<< 
    //<< kill ^WWWSOR(YUSER)
    m$.var("^WWWSOR",YUSER.get()).kill();
    //<< kill ^COMTempList(YM,YUSER)                                      //SR15355
    m$.var("^COMTempList",YM.get(),YUSER.get()).kill();
    //<< kill ^WWWDATEN(0,+$h,YUSER) ;SR17936
    m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),YUSER.get()).kill();
    //<< 
    //<< if $data(^WWWUSER(0,YUSER)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWUSER",0,YUSER.get())))) {
      //<< set $$$WWWUSERFrameFormed(^WWWUSER(0,YUSER,1))=""            //BR014262
      include.WWWConst.$$$WWWUSERFrameFormedSet(m$,m$.var("^WWWUSER",0,YUSER.get(),1),"");
      //<< set $$$WWWUSERTransactionnoLockReturnI(^WWWUSER(0,YUSER,1))=""
      include.WWWConst.$$$WWWUSERTransactionnoLockReturnISet(m$,m$.var("^WWWUSER",0,YUSER.get(),1),"");
    }
    //<< }
    //<< 
    //<< // Kill off any multi-locks
    //<< do ClearOld^WWWMultiLock(YUSER)
    m$.Cmd.Do("WWWMultiLock.ClearOld",YUSER.get());
    //<< 
    //<< // Kill off any old cache temp's
    //<< set strUser = $$^WWWKEYBUILD(YUSER)   ; FIXME : not used - remove?
    strUser.set(m$.fnc$("WWWKEYBUILD.main",YUSER.get()));
    //<< 
    //<< ;SR17208 if '$data(^WWWCacheTempList(strNS)) || ($get(^WWWCacheTempList(strNS,"!LastBuilt"))'=+$horolog) {
    //<< ;SR17208    job BuildList(strNS)
    //<< ;SR17208 } else {
    //<< do ClearList(strNS,YUSER)
    m$.Cmd.Do("ClearList",strNS.get(),YUSER.get());
    //<< ;SR17208 }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< BuildList(YUCI)
  public Object BuildList(Object ... _p) {
    mVar YUCI = m$.newVarRef("YUCI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Build up a list of things that can be blown away.
    //<< ; Note that ordering through the ^$global variable is very slow so we have to cache
    //<< ; the results to get reasonable performance.
    //<< ;
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; 02-Mar-2010   shobby  SR17208: Redundant.
    //<< ; 19-Jun-2009   shobby  SR16644: Clear the list of things to clear before rebuilding.
    //<< ; 19-Mar-2009   shobby  SR16427: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit
    return null;
  }

  //<< 
  //<< ;SR17208 new idBase,idGlobal
  //<< 
  //<< ;SR17208 set idBase      = "^CacheTemp"
  //<< ;SR17208 set idGlobal = $order(^$global(idBase),-1)
  //<< 
  //<< ;SR17208 kill ^WWWCacheTempList(YUCI)                                ;SR16644
  //<< ;SR17208 set ^WWWCacheTempList(YUCI,"!LastBuilt") = +$horolog
  //<< ;SR17208 for {
  //<< ;SR17208    set idGlobal=$order(^$global(idGlobal))
  //<< ;SR17208    write !,idGlobal
  //<< ;SR17208    quit:($extract(idGlobal,1,$length(idBase))'=idBase)     ; Only ^CacheTemp*
  //<< ;SR17208    continue:($extract(idGlobal,1,17)="^CacheTempSession")  ;SR16065: keep session information
  //<< ;SR17208 ;  continue:($extract(idGlobal,1,14)="^CacheTempList")     ;SR16427: Keep the list of things not to keep (19-Jun-2009: Actually the variable is WWWCacheTempList)
  //<< 
  //<< ;SR17208    set ^WWWCacheTempList(YUCI,idGlobal)=""
  //<< ;SR17208 }
  //<< ;SR17208 do ClearList(YUCI,YUSER)
  //<< ;quit
  //<< 
  //<< 
  //<< ClearList(YUCI,YUSER)
  public Object ClearList(Object ... _p) {
    mVar YUCI = m$.newVarRef("YUCI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YUSER = m$.newVarRef("YUSER",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Clears out the CacheTemp variables
    //<< ;
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; 02-Mar-2010   shobby  SR17208: Simplified using call to COMSYSGlobalQuery
    //<< ; 19-Jun-2009   shobby  SR16644: Validation added
    //<< ; 23-Mar-2009   shobby  SR16427: Enclosed subscripts of kills in quotes to
    //<< ;                            handle YUSER values that are strings.
    //<< ; 19-Mar-2009   shobby  SR16427: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idGlobal,objGlobal
    mVar idGlobal = m$.var("idGlobal");
    mVar objGlobal = m$.var("objGlobal");
    m$.newVar(idGlobal,objGlobal);
    //<< 
    //<< do Global^COMSYSGlobalQuery(.objGlobal,"^CacheTemp",$$$YES)         ;SR17208
    m$.Cmd.Do("COMSYSGlobalQuery.Global",objGlobal,"^CacheTemp",include.COMSYS.$$$YES(m$));
    //<< 
    //<< ;set idGlobal = "!LastBuilt"
    //<< set idGlobal=""
    idGlobal.set("");
    //<< for {
    for (;true;) {
      //<< ;   set idGlobal = $order(^WWWCacheTempList(YUCI,idGlobal))     ;SR17208
      //<< set idGlobal = $order(objGlobal(idGlobal))                      ;SR17208
      idGlobal.set(m$.Fnc.$order(objGlobal.var(idGlobal.get())));
      //<< quit:idGlobal=""
      if (mOp.Equal(idGlobal.get(),"")) {
        break;
      }
      //<< 
      //<< continue:($extract(idGlobal,1,17)="^CacheTempSession")          ;SR17208
      if ((mOp.Equal(m$.Fnc.$extract(idGlobal.get(),1,17),"^CacheTempSession"))) {
        continue;
      }
      //<< if $$IsValid(idGlobal) {                                     ; SR16644
      if (mOp.Logical(m$.fnc$("IsValid",idGlobal.get()))) {
        //<< kill @(idGlobal_"("""_YUSER_""")")                       //SR15355
        m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(idGlobal.get(),"(\""),YUSER.get()),"\")"))).kill();
        //<< kill @(idGlobal_"("""_YUCI_""","""_YUSER_""")")          //SR15355
        m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idGlobal.get(),"(\""),YUCI.get()),"\",\""),YUSER.get()),"\")"))).kill();
      }
    }
    //<< }
    //<< }
    //<< 
    //<< do EndSession^WWWUSER(YUSER)  //SR16065:mark session as ended
    m$.Cmd.Do("WWWUSER.EndSession",YUSER.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< IsValid(pidGlobal)
  public Object IsValid(Object ... _p) {
    mVar pidGlobal = m$.newVarRef("pidGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks whether somehow we ended up with an invalid global name
    //<< ; On MANUALWINDOWS we ended up with a global named ^CacheTempWWW0121RelTmp644ADA.
    //<< ; The dot on the end is impossible but yet it was there and trying to kill it
    //<< ; would cause the ClearList to crash.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 30-Jun-2009   GRF     SR16644: boolean macros
    //<< ; 19-Jun-2009   shobby  SR16644: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strTemp,strTrap
    mVar strTemp = m$.var("strTemp");
    mVar strTrap = m$.var("strTrap");
    m$.newVar(strTemp,strTrap);
    //<< 
    //<< set strTrap = $ztrap      ; FIXME : we aren't restoring this
    strTrap.set(m$.Fnc.$ztrap());
    //<< set $ztrap  = "Continue"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("Continue");
    //<< set strTemp = $data(@pidGlobal)
    strTemp.set(m$.Fnc.$data(m$.indirectVar(pidGlobal.get())));
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< Continue ; Internal Tag
  public void Continue() {
    //<< set $ztrap = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< quit $$$NO
    return include.COMSYS.$$$NO(m$);
  }

//<< 
}
