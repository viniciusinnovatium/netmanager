//*****************************************************************************
//** TASC - ALPHALINC - MAC COMSTARTZstart
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:56
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include VARLog
import include.VARLog;
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
//<< #include %syPidtab
import include.$syPidtab;

//<< %ZSTART ; User startup routine. Must be installed in %SYS to operate
public class COMSTARTZstart extends mClass {

  //<< ;=========================================================================
  //<< ; WARNING - Any modifications to this routine when it is installed in %SYS
  //<< ;           will be OVER-WRITTEN with the next upgrade of COM.
  //<< ;           All required changes should be made in COM.
  //<< ;=========================================================================
  //<< ; MS    8-Jul-2005  SR12933 Add quit:strNameSpace="", prevent infinite loop
  //<< ;-------------------------------------------------------------------------------
  //<< #define ME                      "ZSTART"
  public static Object $$$ME(mContext m$) {
    return ("ZSTART");
  }

  //<< #define BgnSet                  "Start"
  public static Object $$$BgnSet(mContext m$) {
    return ("Start");
  }

  //<< #define Empty                   ""
  public static Object $$$Empty(mContext m$) {
    return ("");
  }

  //<< #define OprLog                  1
  public static Object $$$OprLog(mContext m$) {
    return (1);
  }

  //<< 
  //<< #define WEBACCESSTYPE           "WEB"
  public static Object $$$WEBACCESSTYPE(mContext m$) {
    return ("WEB");
  }

  //<< #define SERVICEACCESSTYPE       "SERVICE"
  public static Object $$$SERVICEACCESSTYPE(mContext m$) {
    return ("SERVICE");
  }

  //<< #define WEBSERVICEACCESSTYPE    "WEBSERVICE"
  public static Object $$$WEBSERVICEACCESSTYPE(mContext m$) {
    return ("WEBSERVICE");
  }

  //<< #define REPORTACCESSTYPE        "REPORT"
  public static Object $$$REPORTACCESSTYPE(mContext m$) {
    return ("REPORT");
  }

  //<< #define MOBILEACCESSTYPE        "MOBILE"
  public static Object $$$MOBILEACCESSTYPE(mContext m$) {
    return ("MOBILE");
  }

  //<< #define STUDIOACCESSTYPE        "STUDIO"
  public static Object $$$STUDIOACCESSTYPE(mContext m$) {
    return ("STUDIO");
  }

  //<< #define TERMINALACCESSTYPE      "TERMINAL"
  public static Object $$$TERMINALACCESSTYPE(mContext m$) {
    return ("TERMINAL");
  }

  public void main() {
    $ZSTART();
  }

  public void $ZSTART() {
    //<< quit
    return;
  }

  //<< 
  //<< IDENT ;;COMSTARTZstart
  public Object IDENT() {
    //<< ; this identity ensures only COMSTARTZstart routines are replaced
    //<< quit
    return null;
  }

  //<< 
  //<< SYSTEM
  public void SYSTEM() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;Cache starting
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Feb-2008   shobby  SRBR014903: Don't try and start the scheduler on ECP
    //<< ;                           linked namespaces.
    //<< ; 13-Mar-2007   RPW     SR10754: Do not use ^%COMSTARTUtils and start scheduler
    //<< ;                           per namespace.
    //<< ; 30-Jun-2006   shobby  SRBR014097: Find namespace that has the most recent
    //<< ;                           version of the scheduler.
    //<< ; 29-Jun-2006   shobby  SRBR014097: Checking of global ^ROUTINE("COMSchedule").
    //<< ;                           Could error and therefore scheduler would fail to start.
    //<< ; 08-Jul-2005   MS/shobby SR12933 : Prevent continuous looping through namespaces.
    //<< ;-------------------------------------------------------------------------------
    //<< new EntryPoint, strCurrentNamespace, Items, intCount, strNameSpace, arrNameSpace
    mVar EntryPoint = m$.var("EntryPoint");
    mVar strCurrentNamespace = m$.var("strCurrentNamespace");
    mVar Items = m$.var("Items");
    mVar intCount = m$.var("intCount");
    mVar strNameSpace = m$.var("strNameSpace");
    mVar arrNameSpace = m$.var("arrNameSpace");
    m$.newVar(EntryPoint,strCurrentNamespace,Items,intCount,strNameSpace,arrNameSpace);
    //<< 
    //<< set $ztrap = "SYSTEMExit"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("SYSTEMExit");
    //<< set EntryPoint = "SYSTEM"
    EntryPoint.set("SYSTEM");
    //<< set strCurrentNamespace = $zutil(5)
    strCurrentNamespace.set(m$.Fnc.$zutil(5));
    //<< 
    //<< do configLicenseUserIdentification()
    m$.Cmd.Do("configLicenseUserIdentification");
    //<< 
    //<< ; record the fact we got started in the console log
    //<< do WriteConsole(EntryPoint_"^%"_$$$ME_" called @ "_$zdatetime($horolog, 3))
    m$.Cmd.Do("WriteConsole",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(EntryPoint.get(),"^%"),$$$ME(m$))," called @ "),m$.Fnc.$zdatetime(m$.Fnc.$horolog(),3)));
    //<< 
    //<< ; log the data accumulate results
    //<< set Items = $listbuild($$$BgnSet, $zdatetime($horolog, 3), "Job", $job,
    //<< "Computer", $zutil(110), "Version", $zversion,
    //<< "StdIO", $principal, "Namespace", $zutil(5),
    //<< "CurDirPath", $zutil(12), "CurNSPath", $zutil(12, ""),
    //<< "CurDevName", $zutil(67, 7, $job), "JobType", $zutil(67, 10, $job),
    //<< "JobStatus", $zhex($zjob), "StackFrames", $stack,
    //<< "AvailStorage", $storage, "UserName", $zutil(67, 11, $job))
    Items.set(m$.Fnc.$listbuild($$$BgnSet(m$),m$.Fnc.$zdatetime(m$.Fnc.$horolog(),3),"Job",m$.Fnc.$job(),"Computer",m$.Fnc.$zutil(110),"Version",m$.Fnc.$zversion(),"StdIO",m$.Fnc.$principal(),"Namespace",m$.Fnc.$zutil(5),"CurDirPath",m$.Fnc.$zutil(12),"CurNSPath",m$.Fnc.$zutil(12,""),"CurDevName",m$.Fnc.$zutil(67,7,m$.Fnc.$job()),"JobType",m$.Fnc.$zutil(67,10,m$.Fnc.$job()),"JobStatus",m$.Fnc.$zhex(m$.Fnc.$zjob()),"StackFrames",m$.Fnc.$stack(),"AvailStorage",m$.Fnc.$storage(),"UserName",m$.Fnc.$zutil(67,11,m$.Fnc.$job())));
    //<< 
    //<< ; Startup scheduler (if required)
    //<< for intCount = 1:1:$zutil(90, 0) {
    for (intCount.set(1);(mOp.LessOrEqual(intCount.get(),m$.Fnc.$zutil(90,0)));intCount.set(mOp.Add(intCount.get(),1))) {
      //<< set strNameSpace = $Zutil(90, 2, 0, intCount)
      strNameSpace.set(m$.Fnc.$zutil(90,2,0,intCount.get()));
      //<< if ($length(strNameSpace) = 0) quit
      if ((mOp.Equal(m$.Fnc.$length(strNameSpace.get()),0))) {
        break;
      }
      //<< 
      //<< set arrNameSpace(strNameSpace) = ""
      arrNameSpace.var(strNameSpace.get()).set("");
    }
    //<< }
    //<< 
    //<< set strNameSpace = $order(arrNameSpace(""))
    strNameSpace.set(m$.Fnc.$order(arrNameSpace.var("")));
    //<< while ($length(strNameSpace) > 0) {
    while ((mOp.Greater(m$.Fnc.$length(strNameSpace.get()),0))) {
      //<< if ($$defsys^%GLO(strNameSpace) '= "") {  ;BR014903
      if ((mOp.NotEqual(m$.fnc$("$GLO.defsys",strNameSpace.get()),""))) {
        //<< ;Don't start scheduler on ECP namespaces. ;BR014903
        //<< do WriteConsole(EntryPoint_"^%"_$$$ME_" scheduler ignored for ECP namespace "_strNameSpace)
        m$.Cmd.Do("WriteConsole",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(EntryPoint.get(),"^%"),$$$ME(m$))," scheduler ignored for ECP namespace "),strNameSpace.get()));
      }
      //<< }
      //<< else {
      else {
        //<< do $zutil(5, strNameSpace)
        m$.Cmd.Do("$zutil",5,strNameSpace.get());
        //<< 
        //<< if ($zutil(5) = strNameSpace) {
        if ((mOp.Equal(m$.Fnc.$zutil(5),strNameSpace.get()))) {
          //<< do ##class(VAR.infra.services.PrimaryServicesMonitor).VerifyAndStartService()
          m$.Cmd.Do("VAR.infra.services.PrimaryServicesMonitor.VerifyAndStartService");
          //<< do ##class(VAR.infra.services.SecondaryServicesMonitor).VerifyAndStartService()
          m$.Cmd.Do("VAR.infra.services.SecondaryServicesMonitor.VerifyAndStartService");
          //<< 
          //<< if ($$CheckForError()) {
          if (mOp.Logical((m$.fnc$("CheckForError")))) {
            //<< if ($get(^COMScheduler("Start"))) {
            if (mOp.Logical((m$.Fnc.$get(m$.var("^COMScheduler","Start"))))) {
              //<< do WriteConsole(EntryPoint_"^%"_$$$ME_" started scheduler from "_strNameSpace)
              m$.Cmd.Do("WriteConsole",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(EntryPoint.get(),"^%"),$$$ME(m$))," started scheduler from "),strNameSpace.get()));
              //<< do Start^COMSchedule
              m$.Cmd.Do("COMSchedule.Start");
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< set strNameSpace = $order(arrNameSpace(strNameSpace))
      strNameSpace.set(m$.Fnc.$order(arrNameSpace.var(strNameSpace.get())));
    }
    SYSTEMExit();
  }

  //<< }
  //<< 
  //<< SYSTEMExit ;Internal Tag
  public void SYSTEMExit() {
    //<< set $ztrap = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< do $zutil(5, strCurrentNamespace)
    m$.Cmd.Do("$zutil",5,m$.var("strCurrentNamespace").get());
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< CheckForError()
  public Object CheckForError(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check whether the test for the routine existence fails.  Error occurs when
    //<< ; finding an unmounted database
    //<< ;
    //<< ; History:
    //<< ; 31-Jul-2007   shobby  SRBR014652:  Do the check on rOBJ because ^ROUTINE won't
    //<< ;                           exist when source code has been removed.
    //<< ; 01-Jul-2006   shobby  SRBR014097:  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnResult
    mVar blnResult = m$.var("blnResult");
    m$.newVar(blnResult);
    //<< 
    //<< set blnResult = 0
    blnResult.set(0);
    //<< set $ztrap = "ErrorCheckForError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("ErrorCheckForError");
    //<< set blnResult = $data(^rOBJ("COMSchedule"))
    blnResult.set(m$.Fnc.$data(m$.var("^rOBJ","COMSchedule")));
    return null;
  }

  //<< 
  //<< //ErrorCheckForError
  //<< ErrorCheckForError() ; Internal Tag ;Goto point. Not start of a new routine.
  public Object ErrorCheckForError(Object ... _p) {
    //<< set $ztrap = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< 
    //<< quit blnResult
    return m$.var("blnResult").get();
  }

  //<< 
  //<< 
  //<< DateDiff(pdteFirst="",pdteSecond="")
  public Object DateDiff(Object ... _p) {
    mVar pdteFirst = m$.newVarRef("pdteFirst",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pdteSecond = m$.newVarRef("pdteSecond",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine the number of seconds difference between two $horolog dates
    //<< ;
    //<< ; NOTE: This is not taking leap seconds into consideration.
    //<< ;
    //<< ; History:
    //<< ; 01-Jul-2006   shobby  SRBR014097: Copied from COMDateUtils (to remove
    //<< ;                           dependency of this routine on that routine)
    //<< ; 05-Nov-2004   GRF     Add parameter defaults
    //<< ; 28-Mar-2003   PaulK   Created(Commented)
    //<< ;-------------------------------------------------------------------------------
    //<< new plngFirst,plngSecond
    mVar plngFirst = m$.var("plngFirst");
    mVar plngSecond = m$.var("plngSecond");
    m$.newVar(plngFirst,plngSecond);
    //<< 
    //<< set plngFirst  = $piece(pdteFirst ,",",1)*86400+$piece(pdteFirst ,",",2)
    plngFirst.set(mOp.Add(mOp.Multiply(m$.Fnc.$piece(pdteFirst.get(),",",1),86400),m$.Fnc.$piece(pdteFirst.get(),",",2)));
    //<< set plngSecond = $piece(pdteSecond,",",1)*86400+$piece(pdteSecond,",",2)
    plngSecond.set(mOp.Add(mOp.Multiply(m$.Fnc.$piece(pdteSecond.get(),",",1),86400),m$.Fnc.$piece(pdteSecond.get(),",",2)));
    //<< quit plngSecond-plngFirst
    return mOp.Subtract(plngSecond.get(),plngFirst.get());
  }

  //<< 
  //<< 
  //<< LOGIN
  public void LOGIN() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; a user logs into Cache (user account or telnet)
    //<< ;-------------------------------------------------------------------------------
    //<< if ($$isExplicitLicenseUserIdentification() && $$isTerminal()) {
    if ((mOp.Logical(m$.fnc$("isExplicitLicenseUserIdentification")) && mOp.Logical(m$.fnc$("isTerminal")))) {
      //<< do allocTerminalLicense($$getLicenseUserIdFromIpAddress($$getIpAddress()))
      m$.Cmd.Do("allocTerminalLicense",m$.fnc$("getLicenseUserIdFromIpAddress",m$.fnc$("getIpAddress")));
    }
    //<< }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< JOB
  public void JOB() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; JOB'd process begins
    //<< ;-------------------------------------------------------------------------------
    //<< if ($$isExplicitLicenseUserIdentification() && $$isStudio()) {
    if ((mOp.Logical(m$.fnc$("isExplicitLicenseUserIdentification")) && mOp.Logical(m$.fnc$("isStudio")))) {
      //<< do allocStudioLicense($$getLicenseUserIdFromIpAddress($$getIpAddress()))
      m$.Cmd.Do("allocStudioLicense",m$.fnc$("getLicenseUserIdFromIpAddress",m$.fnc$("getIpAddress")));
    }
    //<< }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< CALLIN
  public Object CALLIN() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; a process enters via CALLIN interface
    //<< ;-------------------------------------------------------------------------------
    //<< quit
    return null;
  }

  //<< 
  //<< setLicenseUserIdentification(pblnExplicitIdentification)
  public Object setLicenseUserIdentification(Object ... _p) {
    mVar pblnExplicitIdentification = m$.newVarRef("pblnExplicitIdentification",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< set ^|"%SYS"|SYS("UserIdentification") = pblnExplicitIdentification
    m$.var("^|%SYS|SYS","UserIdentification").set(pblnExplicitIdentification.get());
    //<< do configLicenseUserIdentification()
    m$.Cmd.Do("configLicenseUserIdentification");
    //<< quit
    return null;
  }

  //<< 
  //<< configLicenseUserIdentification()
  public Object configLicenseUserIdentification(Object ... _p) {
    //<< do $System.License.DeferUserIdentification($$isExplicitLicenseUserIdentification())
    m$.getSystem().getLicense().DeferUserIdentification(m$.fnc$("isExplicitLicenseUserIdentification"));
    //<< quit
    return null;
  }

  //<< 
  //<< isExplicitLicenseUserIdentification()
  public Object isExplicitLicenseUserIdentification(Object ... _p) {
    //<< quit +$get(^|"%SYS"|SYS("UserIdentification"))
    return mOp.Positive(m$.Fnc.$get(m$.var("^|%SYS|SYS","UserIdentification")));
  }

  //<< 
  //<< setDefaultLicenseUserIds(pstrDefaultLicenseUserIds)
  public Object setDefaultLicenseUserIds(Object ... _p) {
    mVar pstrDefaultLicenseUserIds = m$.newVarRef("pstrDefaultLicenseUserIds",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< set ^|"%SYS"|SYS("DefaultLicenseUserIds") = pstrDefaultLicenseUserIds
    m$.var("^|%SYS|SYS","DefaultLicenseUserIds").set(pstrDefaultLicenseUserIds.get());
    //<< quit
    return null;
  }

  //<< 
  //<< getAvailableDefaultLicenseUserId()
  public Object getAvailableDefaultLicenseUserId(Object ... _p) {
    //<< new strLicenseUserId, strDefaultLicenseUserIds, i, strCurrentLicenseUserId
    mVar strLicenseUserId = m$.var("strLicenseUserId");
    mVar strDefaultLicenseUserIds = m$.var("strDefaultLicenseUserIds");
    mVar i = m$.var("i");
    mVar strCurrentLicenseUserId = m$.var("strCurrentLicenseUserId");
    m$.newVar(strLicenseUserId,strDefaultLicenseUserIds,i,strCurrentLicenseUserId);
    //<< 
    //<< set strLicenseUserId = ""
    strLicenseUserId.set("");
    //<< set strDefaultLicenseUserIds = $get(^|"%SYS"|SYS("DefaultLicenseUserIds"))
    strDefaultLicenseUserIds.set(m$.Fnc.$get(m$.var("^|%SYS|SYS","DefaultLicenseUserIds")));
    //<< for i = 1:1:$length(strDefaultLicenseUserIds, ";") {
    for (i.set(1);(mOp.LessOrEqual(i.get(),m$.Fnc.$length(strDefaultLicenseUserIds.get(),";")));i.set(mOp.Add(i.get(),1))) {
      //<< set strCurrentLicenseUserId = $piece(strDefaultLicenseUserIds, ";", i)
      strCurrentLicenseUserId.set(m$.Fnc.$piece(strDefaultLicenseUserIds.get(),";",i.get()));
      //<< 
      //<< if ($length(strCurrentLicenseUserId) = 0) continue
      if ((mOp.Equal(m$.Fnc.$length(strCurrentLicenseUserId.get()),0))) {
        continue;
      }
      //<< 
      //<< if ($System.License.ConnectionCount(strCurrentLicenseUserId) <
      //<< $System.License.MaxConnections()) {
      if ((mOp.Less(m$.getSystem().getLicense().ConnectionCount(strCurrentLicenseUserId.get()),m$.getSystem().getLicense().MaxConnections()))) {
        //<< set strLicenseUserId = strCurrentLicenseUserId
        strLicenseUserId.set(strCurrentLicenseUserId.get());
        //<< quit
        break;
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strLicenseUserId
    return strLicenseUserId.get();
  }

  //<< 
  //<< isTerminal()
  public Object isTerminal(Object ... _p) {
    //<< new job, isTerminal
    mVar job = m$.var("job");
    mVar isTerminal = m$.var("isTerminal");
    m$.newVar(job,isTerminal);
    //<< 
    //<< set $ztrap = "exceptionIsTerminal"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("exceptionIsTerminal");
    //<< 
    //<< if ($SYSTEM.Version.GetNumber() > 2008.1) {
    if ((mOp.Greater(m$.getSystem().getVersion().GetNumber(),2008.1))) {
      //<< set job = ##class(%SYS.ProcessQuery).%OpenId($job)
      job.set(m$.fnc$("$SYS.ProcessQuery.$OpenId",m$.Fnc.$job()));
    }
    //<< }
    //<< else {
    else {
      //<< set job = ##class(%SYSTEM.Process).%OpenId($job)
      job.set(m$.getSystem().getProcess().$OpenId(m$.Fnc.$job()));
    }
    //<< }
    //<< 
    //<< set isTerminal = (('job.IsGhost) &&
    //<< (job.JobType = $$$FOREJOB) &&
    //<< ($length(job.CSPSessionID) = 0) &&
    //<< ($length(job.ClientExecutableName) = 0) &&
    //<< ($extract(job.CurrentDevice, 1, $length("|TNT|")) = "|TNT|"))
    isTerminal.set(((mOp.Not(m$.prop(job.get(),"IsGhost").get())) && (mOp.Equal(m$.prop(job.get(),"JobType").get(),include.$syPidtab.$$$FOREJOB(m$))) && (mOp.Equal(m$.Fnc.$length(m$.prop(job.get(),"CSPSessionID").get()),0)) && (mOp.Equal(m$.Fnc.$length(m$.prop(job.get(),"ClientExecutableName").get()),0)) && (mOp.Equal(m$.Fnc.$extract(m$.prop(job.get(),"CurrentDevice").get(),1,m$.Fnc.$length("|TNT|")),"|TNT|"))));
    //<< goto finallyIsTerminal
    m$.Cmd.Goto("finallyIsTerminal");
    return null;
  }

  //<< 
  //<< exceptionIsTerminal
  public void exceptionIsTerminal() {
    //<< set $ztrap = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< goto finallyIsTerminal
    m$.Cmd.Goto("finallyIsTerminal");
    return;
  }

  //<< 
  //<< finallyIsTerminal
  public Object finallyIsTerminal() {
    //<< quit isTerminal
    return m$.var("isTerminal").get();
  }

  //<< 
  //<< isStudio()
  public Object isStudio(Object ... _p) {
    //<< new job, isStudio
    mVar job = m$.var("job");
    mVar isStudio = m$.var("isStudio");
    m$.newVar(job,isStudio);
    //<< 
    //<< set $ztrap = "exceptionIsStudio"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("exceptionIsStudio");
    //<< 
    //<< if ($SYSTEM.Version.GetNumber() > 2008.1) {
    if ((mOp.Greater(m$.getSystem().getVersion().GetNumber(),2008.1))) {
      //<< set job = ##class(%SYS.ProcessQuery).%OpenId($job)
      job.set(m$.fnc$("$SYS.ProcessQuery.$OpenId",m$.Fnc.$job()));
    }
    //<< }
    //<< else {
    else {
      //<< set job = ##class(%SYSTEM.Process).%OpenId($job)
      job.set(m$.getSystem().getProcess().$OpenId(m$.Fnc.$job()));
    }
    //<< }
    //<< 
    //<< set isStudio = (('job.IsGhost) &&
    //<< (job.JobType = $$$ODBCSRV) &&
    //<< ($length(job.CSPSessionID) = 0) &&
    //<< (job.ClientExecutableName = "CSTUDIO.EXE"))
    isStudio.set(((mOp.Not(m$.prop(job.get(),"IsGhost").get())) && (mOp.Equal(m$.prop(job.get(),"JobType").get(),include.$syPidtab.$$$ODBCSRV(m$))) && (mOp.Equal(m$.Fnc.$length(m$.prop(job.get(),"CSPSessionID").get()),0)) && (mOp.Equal(m$.prop(job.get(),"ClientExecutableName").get(),"CSTUDIO.EXE"))));
    //<< goto finallyIsStudio
    m$.Cmd.Goto("finallyIsStudio");
    return null;
  }

  //<< 
  //<< exceptionIsStudio
  public void exceptionIsStudio() {
    //<< set $ztrap = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< goto finallyIsStudio
    m$.Cmd.Goto("finallyIsStudio");
    return;
  }

  //<< 
  //<< finallyIsStudio
  public Object finallyIsStudio() {
    //<< quit isStudio
    return m$.var("isStudio").get();
  }

  //<< 
  //<< getIpAddress()
  public Object getIpAddress(Object ... _p) {
    //<< new job, ip
    mVar job = m$.var("job");
    mVar ip = m$.var("ip");
    m$.newVar(job,ip);
    //<< 
    //<< set $ztrap = "exceptionGetIpAddress"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("exceptionGetIpAddress");
    //<< 
    //<< if ($SYSTEM.Version.GetNumber() > 2008.1) {
    if ((mOp.Greater(m$.getSystem().getVersion().GetNumber(),2008.1))) {
      //<< set job = ##class(%SYS.ProcessQuery).%OpenId($job)
      job.set(m$.fnc$("$SYS.ProcessQuery.$OpenId",m$.Fnc.$job()));
    }
    //<< }
    //<< else {
    else {
      //<< set job = ##class(%SYSTEM.Process).%OpenId($job)
      job.set(m$.getSystem().getProcess().$OpenId(m$.Fnc.$job()));
    }
    //<< }
    //<< 
    //<< set ip = job.ClientIPAddress
    ip.set(m$.prop(job.get(),"ClientIPAddress").get());
    //<< goto finallyGetIpAddress
    m$.Cmd.Goto("finallyGetIpAddress");
    return null;
  }

  //<< 
  //<< exceptionGetIpAddress
  public void exceptionGetIpAddress() {
    //<< set $ztrap = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< goto finallyGetIpAddress
    m$.Cmd.Goto("finallyGetIpAddress");
    return;
  }

  //<< 
  //<< finallyGetIpAddress
  public Object finallyGetIpAddress() {
    //<< quit ip
    return m$.var("ip").get();
  }

  //<< 
  //<< clearIpMaskToLicenseUserIdMap()
  public Object clearIpMaskToLicenseUserIdMap(Object ... _p) {
    //<< kill ^|"%SYS"|SYS("IpMaskToLicenseUserIdMap")
    m$.var("^|%SYS|SYS","IpMaskToLicenseUserIdMap").kill();
    //<< quit
    return null;
  }

  //<< 
  //<< setIpMaskToLicenseUserIdMap(pstrIpMask, pstrLicenseUserId)
  public Object setIpMaskToLicenseUserIdMap(Object ... _p) {
    mVar pstrIpMask = m$.newVarRef("pstrIpMask",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrLicenseUserId = m$.newVarRef("pstrLicenseUserId",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< set ^|"%SYS"|SYS("IpMaskToLicenseUserIdMap", pstrIpMask) = pstrLicenseUserId
    m$.var("^|%SYS|SYS","IpMaskToLicenseUserIdMap",pstrIpMask.get()).set(pstrLicenseUserId.get());
    //<< quit
    return null;
  }

  //<< 
  //<< getLicenseUserIdFromIpAddress(pstrIpAddress)
  public Object getLicenseUserIdFromIpAddress(Object ... _p) {
    mVar pstrIpAddress = m$.newVarRef("pstrIpAddress",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new strLicenseUserId, intLevelMatch, strIpMask
    mVar strLicenseUserId = m$.var("strLicenseUserId");
    mVar intLevelMatch = m$.var("intLevelMatch");
    mVar strIpMask = m$.var("strIpMask");
    m$.newVar(strLicenseUserId,intLevelMatch,strIpMask);
    //<< 
    //<< set strLicenseUserId = ""
    strLicenseUserId.set("");
    //<< 
    //<< set intLevelMatch = 0
    intLevelMatch.set(0);
    //<< set strIpMask = $order(^|"%SYS"|SYS("IpMaskToLicenseUserIdMap", ""))
    strIpMask.set(m$.Fnc.$order(m$.var("^|%SYS|SYS","IpMaskToLicenseUserIdMap","")));
    //<< while ($length(strIpMask) > 0) {
    while ((mOp.Greater(m$.Fnc.$length(strIpMask.get()),0))) {
      //<< if ($$isMatchIpMask(pstrIpAddress, strIpMask) > intLevelMatch) {
      if ((mOp.Greater(m$.fnc$("isMatchIpMask",pstrIpAddress.get(),strIpMask.get()),intLevelMatch.get()))) {
        //<< set strLicenseUserId = ^|"%SYS"|SYS("IpMaskToLicenseUserIdMap", strIpMask)
        strLicenseUserId.set(m$.var("^|%SYS|SYS","IpMaskToLicenseUserIdMap",strIpMask.get()).get());
        //<< set intLevelMatch = $$isMatchIpMask(pstrIpAddress, strIpMask)
        intLevelMatch.set(m$.fnc$("isMatchIpMask",pstrIpAddress.get(),strIpMask.get()));
      }
      //<< }
      //<< 
      //<< set strIpMask = $order(^|"%SYS"|SYS("IpMaskToLicenseUserIdMap", strIpMask))
      strIpMask.set(m$.Fnc.$order(m$.var("^|%SYS|SYS","IpMaskToLicenseUserIdMap",strIpMask.get())));
    }
    //<< }
    //<< 
    //<< quit strLicenseUserId
    return strLicenseUserId.get();
  }

  //<< 
  //<< isMatchIpMask(pstrIpAddress, pstrIpMask)
  public Object isMatchIpMask(Object ... _p) {
    mVar pstrIpAddress = m$.newVarRef("pstrIpAddress",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrIpMask = m$.newVarRef("pstrIpMask",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if ($extract(pstrIpAddress, 1, $length(pstrIpMask)) = pstrIpMask) {
    if ((mOp.Equal(m$.Fnc.$extract(pstrIpAddress.get(),1,m$.Fnc.$length(pstrIpMask.get())),pstrIpMask.get()))) {
      //<< quit $length(pstrIpMask)
      return m$.Fnc.$length(pstrIpMask.get());
    }
    //<< }
    //<< 
    //<< quit 0
    return 0;
  }

  //<< 
  //<< allocWebLicense(pstrLicenseUserId)
  public Object allocWebLicense(Object ... _p) {
    mVar pstrLicenseUserId = m$.newVarRef("pstrLicenseUserId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$allocLicense($$$WEBACCESSTYPE, pstrLicenseUserId)
    return m$.fnc$("allocLicense",$$$WEBACCESSTYPE(m$),pstrLicenseUserId.get());
  }

  //<< 
  //<< allocServiceLicense(pstrLicenseUserId)
  public Object allocServiceLicense(Object ... _p) {
    mVar pstrLicenseUserId = m$.newVarRef("pstrLicenseUserId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$allocLicense($$$SERVICEACCESSTYPE, pstrLicenseUserId)
    return m$.fnc$("allocLicense",$$$SERVICEACCESSTYPE(m$),pstrLicenseUserId.get());
  }

  //<< 
  //<< allocWebServiceLicense(pstrLicenseUserId)
  public Object allocWebServiceLicense(Object ... _p) {
    mVar pstrLicenseUserId = m$.newVarRef("pstrLicenseUserId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$allocLicense($$$WEBSERVICEACCESSTYPE, pstrLicenseUserId)
    return m$.fnc$("allocLicense",$$$WEBSERVICEACCESSTYPE(m$),pstrLicenseUserId.get());
  }

  //<< 
  //<< allocReportLicense(pstrLicenseUserId)
  public Object allocReportLicense(Object ... _p) {
    mVar pstrLicenseUserId = m$.newVarRef("pstrLicenseUserId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$allocLicense($$$REPORTACCESSTYPE, pstrLicenseUserId)
    return m$.fnc$("allocLicense",$$$REPORTACCESSTYPE(m$),pstrLicenseUserId.get());
  }

  //<< 
  //<< allocMobileLicense(pstrLicenseUserId)
  public Object allocMobileLicense(Object ... _p) {
    mVar pstrLicenseUserId = m$.newVarRef("pstrLicenseUserId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$allocLicense($$$MOBILEACCESSTYPE, pstrLicenseUserId)
    return m$.fnc$("allocLicense",$$$MOBILEACCESSTYPE(m$),pstrLicenseUserId.get());
  }

  //<< 
  //<< allocStudioLicense(pstrLicenseUserId)
  public Object allocStudioLicense(Object ... _p) {
    mVar pstrLicenseUserId = m$.newVarRef("pstrLicenseUserId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$allocLicense($$$STUDIOACCESSTYPE, pstrLicenseUserId)
    return m$.fnc$("allocLicense",$$$STUDIOACCESSTYPE(m$),pstrLicenseUserId.get());
  }

  //<< 
  //<< allocTerminalLicense(pstrLicenseUserId)
  public Object allocTerminalLicense(Object ... _p) {
    mVar pstrLicenseUserId = m$.newVarRef("pstrLicenseUserId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$allocLicense($$$TERMINALACCESSTYPE, pstrLicenseUserId)
    return m$.fnc$("allocLicense",$$$TERMINALACCESSTYPE(m$),pstrLicenseUserId.get());
  }

  //<< 
  //<< allocLicense(pstrAccessType, pstrLicenseUserId)
  public Object allocLicense(Object ... _p) {
    mVar pstrAccessType = m$.newVarRef("pstrAccessType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrLicenseUserId = m$.newVarRef("pstrLicenseUserId",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< new intOldLicCount, intOldConnCount, strRemoteAddrBkp, strStatus,
    //<< intNewLicCount, intNewConnCount, strMsg
    mVar intOldLicCount = m$.var("intOldLicCount");
    mVar intOldConnCount = m$.var("intOldConnCount");
    mVar strRemoteAddrBkp = m$.var("strRemoteAddrBkp");
    mVar strStatus = m$.var("strStatus");
    mVar intNewLicCount = m$.var("intNewLicCount");
    mVar intNewConnCount = m$.var("intNewConnCount");
    mVar strMsg = m$.var("strMsg");
    m$.newVar(intOldLicCount,intOldConnCount,strRemoteAddrBkp,strStatus,intNewLicCount,intNewConnCount,strMsg);
    //<< 
    //<< if ($length(pstrLicenseUserId) = 0) {
    if ((mOp.Equal(m$.Fnc.$length(pstrLicenseUserId.get()),0))) {
      //<< set pstrLicenseUserId = $$getAvailableDefaultLicenseUserId()
      pstrLicenseUserId.set(m$.fnc$("getAvailableDefaultLicenseUserId"));
    }
    //<< }
    //<< if ($length(pstrLicenseUserId) = 0) {
    if ((mOp.Equal(m$.Fnc.$length(pstrLicenseUserId.get()),0))) {
      //<< quit 0
      return 0;
    }
    //<< }
    //<< if ($System.License.GetUserId() = pstrLicenseUserId) {
    if ((mOp.Equal(m$.getSystem().getLicense().GetUserId(),pstrLicenseUserId.get()))) {
      //<< quit 1
      return 1;
    }
    //<< }
    //<< 
    //<< set intOldLicCount = $System.License.LUConsumed()
    intOldLicCount.set(m$.getSystem().getLicense().LUConsumed());
    //<< set intOldConnCount = $System.License.ConnectionCount(pstrLicenseUserId)
    intOldConnCount.set(m$.getSystem().getLicense().ConnectionCount(pstrLicenseUserId.get()));
    //<< 
    //<< if ($isObject($get(%session))) {
    if (mOp.Logical((m$.Fnc.$isobject(m$.Fnc.$get(m$.getSession()))))) {
      //<< set strRemoteAddrBkp = %request.CgiEnvs("REMOTE_ADDR")
      strRemoteAddrBkp.set(m$.getRequest().getCgiEnvs("REMOTE_ADDR"));
      //<< set %request.CgiEnvs("REMOTE_ADDR") = "127.0.0.1"
      m$.getRequest().setCgiEnvs("REMOTE_ADDR","127.0.0.1");
      //<< 
      //<< set strStatus = %session.Login(pstrLicenseUserId, "", 1)
      strStatus.set(m$.getSession().getLogin(pstrLicenseUserId.get(),"",1));
      //<< if ($$$ISOK(strStatus) && ($System.License.GetUserId() '= pstrLicenseUserId)) {
      if ((mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus)) && (mOp.NotEqual(m$.getSystem().getLicense().GetUserId(),pstrLicenseUserId.get())))) {
        //<< set strStatus = $System.License.Login(pstrLicenseUserId)
        strStatus.set(m$.getSystem().getLicense().Login(pstrLicenseUserId.get()));
      }
      //<< }
      //<< 
      //<< set %request.CgiEnvs("REMOTE_ADDR") = strRemoteAddrBkp
      m$.getRequest().setCgiEnvs("REMOTE_ADDR",strRemoteAddrBkp.get());
    }
    //<< }
    //<< else {
    else {
      //<< set strStatus = $System.License.Login(pstrLicenseUserId)
      strStatus.set(m$.getSystem().getLicense().Login(pstrLicenseUserId.get()));
    }
    //<< }
    //<< 
    //<< if ($$$ISOK(strStatus)) {
    if (mOp.Logical((include.COMSYS.$$$ISOK(m$,strStatus)))) {
      //<< set intNewLicCount = $System.License.LUConsumed()
      intNewLicCount.set(m$.getSystem().getLicense().LUConsumed());
      //<< set intNewConnCount = $System.License.ConnectionCount(pstrLicenseUserId)
      intNewConnCount.set(m$.getSystem().getLicense().ConnectionCount(pstrLicenseUserId.get()));
      //<< 
      //<< set ^WWWLicenseAllocationLog($piece($horolog, ",", 1),
      //<< $piece($horolog, ",", 2), pstrLicenseUserId, pstrAccessType, $$$UPPER($znspace)) =
      //<< intNewLicCount_"~"_(intNewLicCount - intOldLicCount)_"~"_
      //<< intNewConnCount_"~"_(intNewConnCount - intOldConnCount)_"~"_$job
      m$.var("^WWWLicenseAllocationLog",m$.Fnc.$piece(m$.Fnc.$horolog(),",",1),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),pstrLicenseUserId.get(),pstrAccessType.get(),include.COMSYSString.$$$UPPER(m$,m$.Fnc.$znspace())).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(intNewLicCount.get(),"~"),(mOp.Subtract(intNewLicCount.get(),intOldLicCount.get()))),"~"),intNewConnCount.get()),"~"),(mOp.Subtract(intNewConnCount.get(),intOldConnCount.get()))),"~"),m$.Fnc.$job()));
      //<< 
      //<< if (##class(%Dictionary.ClassDefinition).%ExistsId("VAR.infra.log.Logger")) {
      if (mOp.Logical((m$.fnc$("$Dictionary.ClassDefinition.$ExistsId","VAR.infra.log.Logger")))) {
        //<< set strMsg = "License allocated: userId="_pstrLicenseUserId_", "_
        //<< "accessType="_pstrAccessType_", namespace="_$$$UPPER($znspace)_", "_
        //<< "licCount="_intNewLicCount_", licDiff="_(intNewLicCount - intOldLicCount)_", "_
        //<< "connCount="_intNewConnCount_", connDiff="_(intNewConnCount - intOldConnCount)
        strMsg.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("License allocated: userId=",pstrLicenseUserId.get()),", "),"accessType="),pstrAccessType.get()),", namespace="),include.COMSYSString.$$$UPPER(m$,m$.Fnc.$znspace())),", "),"licCount="),intNewLicCount.get()),", licDiff="),(mOp.Subtract(intNewLicCount.get(),intOldLicCount.get()))),", "),"connCount="),intNewConnCount.get()),", connDiff="),(mOp.Subtract(intNewConnCount.get(),intOldConnCount.get()))));
        //<< $$$VARLOGINFO(strMsg)
        include.VARLog.$$$VARLOGINFO(m$,strMsg);
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< unallocLicense(){
  public Object unallocLicense(Object ... _p) {
    //<< do $System.License.Login($char(0))
    m$.getSystem().getLicense().Login(m$.Fnc.$char(0));
    return null;
  }

  //<< }
  //<< 
  //<< WriteConsole(LineText) PUBLIC
  public Object WriteConsole(Object ... _p) {
    mVar LineText = m$.newVarRef("LineText",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; write the line to the console log
    //<< ; by default the file cconsole.log in the MGR directory
    //<< ;
    //<< ; History:
    //<< ; 13-Mar-2007   RPW     SR10754: Copied from COMSTARTUtils
    //<< ;-------------------------------------------------------------------------------
    //<< new SaveIO
    mVar SaveIO = m$.var("SaveIO");
    m$.newVar(SaveIO);
    //<< 
    //<< ; save the current device and open the operator console
    //<< ; set up error handling to cope with errors
    //<< ; there is little to do if an error happens
    //<< set SaveIO = $io
    SaveIO.set(m$.Fnc.$io());
    //<< set $ztrap = "WriteConsoleExit"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("WriteConsoleExit");
    //<< open $$$OprLog
    m$.Cmd.Open($$$OprLog(m$));
    //<< use $$$OprLog
    m$.Cmd.Use($$$OprLog(m$));
    //<< ; we do not need an "!" for line termination
    //<< ; each WRITE becomes its own console record
    //<< write LineText
    m$.Cmd.Write(LineText.get());
    //<< ; restore the previous io device
    //<< close $$$OprLog
    m$.Cmd.Close($$$OprLog(m$));
    WriteConsoleExit();
    return null;
  }

  //<< ; pick up here in case of an error
  //<< 
  //<< WriteConsoleExit ;Internal Tag
  public void WriteConsoleExit() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 13-Mar-2007   RPW     SR10754: Copied from COMSTARTUtils
    //<< ;-------------------------------------------------------------------------------
    //<< set $ztrap = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< use SaveIO
    m$.Cmd.Use(m$.var("SaveIO").get());
    //<< quit
    return;
  }

}
