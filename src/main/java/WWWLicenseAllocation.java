//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWLicenseAllocation
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:40
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

public class WWWLicenseAllocation extends mClass {

  //<< 
  //<< WWWLicenseAllocation(pstrProcess="", pblnShowError=$$$NO)    ; FIXME : Separate routine and tag <GRF>
  public Object main(Object ... _p) {
    mVar pstrProcess = m$.newVarRef("pstrProcess",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pblnShowError = m$.newVarRef("pblnShowError",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    return _WWWLicenseAllocation(pstrProcess,pblnShowError);
  }

  public Object _WWWLicenseAllocation(Object ... _p) {
    mVar pstrProcess = m$.newVarRef("pstrProcess",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pblnShowError = m$.newVarRef("pblnShowError",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Allocate sessions and processes to license
    //<< ;
    //<< ;   set blnSessionLoginOK=$$^WWWLicenseAllocation("BackgroundJob")
    //<< ;
    //<< ; Inputs: pstrProcess = "" if normal entry (www.cls, COMLogin.cls)
    //<< ;                      "BackgroundJob" in case of a backgoundJob
    //<< ;
    //<< ;         pblnShowError = 1 if a error message should appear
    //<< ;
    //<< ; Returns:  1 = OK  0 = Error
    //<< ;
    //<< ; History:
    //<< ; 21-Oct-2008   FIS     SR16065: re-written
    //<< ; 05-Jul-2007   GRF     SR15550: Boolean Macros; default arguments rather than
    //<< ;                       $get
    //<< ; 21-Jun-2007   ANDREAS SR15550: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClient, strStatus, YBED, YUSER, intMaxCon, intAddNo, blnCSPSession,
    //<< blnNewCon
    mVar idClient = m$.var("idClient");
    mVar strStatus = m$.var("strStatus");
    mVar YBED = m$.var("YBED");
    mVar YUSER = m$.var("YUSER");
    mVar intMaxCon = m$.var("intMaxCon");
    mVar intAddNo = m$.var("intAddNo");
    mVar blnCSPSession = m$.var("blnCSPSession");
    mVar blnNewCon = m$.var("blnNewCon");
    m$.newVar(idClient,strStatus,YBED,YUSER,intMaxCon,intAddNo,blnCSPSession,blnNewCon);
    //<< 
    //<< set strStatus     = '$$$OK   ;return status     ; FIXME : Why no error message in this case? <GRF>
    strStatus.set(mOp.Not(include.COMSYS.$$$OK(m$)));
    //<< set blnCSPSession =  $$$NO   ;is CSP session
    blnCSPSession.set(include.COMSYS.$$$NO(m$));
    //<< set blnNewCon     =  $$$NO   ;is New Connection
    blnNewCon.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< // Set ClientId
    //<< if ($$isExplicitLicenseUserIdentification^COMSTARTZstart()) {
    if (mOp.Logical((m$.fnc$("COMSTARTZstart.isExplicitLicenseUserIdentification")))) {
      //<< if (($length($get(YBED)) = 0) && $isObject($get(%request))) {
      if (mOp.Logical(((mOp.Equal(m$.Fnc.$length(m$.Fnc.$get(YBED)),0)) && mOp.Logical(m$.Fnc.$isobject(m$.Fnc.$get(m$.getRequest())))))) {
        //<< set YBED = $$$UPPER($get(%request.Data("YBED", 1), ""))
        YBED.set(include.COMSYSString.$$$UPPER(m$,m$.Fnc.$get(m$.getRequest().varData("YBED",1),"")));
        //<< if ($length(YBED) = 0) {
        if ((mOp.Equal(m$.Fnc.$length(YBED.get()),0))) {
          //<< set YBED = $$$UPPER($get(%request.CgiEnvs("YBED", 1), ""))
          YBED.set(include.COMSYSString.$$$UPPER(m$,m$.Fnc.$get(m$.getRequest().getCgiEnvs("YBED",1),"")));
        }
        //<< }
        //<< 
        //<< if ($length(YBED) = 0) {
        if ((mOp.Equal(m$.Fnc.$length(YBED.get()),0))) {
          //<< set YUSER = $get(%request.Data("YUSER", 1), "")
          YUSER.set(m$.Fnc.$get(m$.getRequest().varData("YUSER",1),""));
          //<< if ($length(YUSER) = 0) {
          if ((mOp.Equal(m$.Fnc.$length(YUSER.get()),0))) {
            //<< set YUSER = $get(%request.CgiEnvs("YUSER", 1), "")
            YUSER.set(m$.Fnc.$get(m$.getRequest().getCgiEnvs("YUSER",1),""));
          }
          //<< }
          //<< 
          //<< if ($length(YUSER) > 0) {
          if ((mOp.Greater(m$.Fnc.$length(YUSER.get()),0))) {
            //<< set YBED = $$$WWWUSERUser1($get(^WWWUSER(0, YUSER, 1)))
            YBED.set(include.WWWConst.$$$WWWUSERUser1(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1))));
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< set strStatus = $$AllocWebLicense($get(YBED))
      strStatus.set(m$.fnc$("AllocWebLicense",m$.Fnc.$get(YBED)));
      //<< set idClient = $System.License.GetUserId()
      idClient.set(m$.getSystem().getLicense().GetUserId());
    }
    //<< }
    //<< else {
    else {
      //<< if (pstrProcess '= "") {         // fix license id
      if ((mOp.NotEqual(pstrProcess.get(),""))) {
        //<< set idClient = pstrProcess
        idClient.set(pstrProcess.get());
      }
      //<< }
      //<< elseif ($get(%request) '="") {   // IP Address
      else if ((mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),""))) {
        //<< set idClient      = $get(%request.CgiEnvs("REMOTE_ADDR"), "unknown")
        idClient.set(m$.Fnc.$get(m$.getRequest().getCgiEnvs("REMOTE_ADDR"),"unknown"));
        //<< set blnCSPSession = $$$YES
        blnCSPSession.set(include.COMSYS.$$$YES(m$));
      }
      //<< }
      //<< else {                           // Background Job
      else {
        //<< set idClient = "BackgroundJob"
        idClient.set("BackgroundJob");
      }
      //<< }
      //<< 
      //<< // Increase ClientId if max. connection are reached
      //<< set intAddNo  = 0
      intAddNo.set(0);
      //<< set intMaxCon = $System.License.MaxConnections() - 1  ; no. of available connections less 1 (just in case)
      intMaxCon.set(mOp.Subtract(m$.getSystem().getLicense().MaxConnections(),1));
      //<< while ($System.License.ConnectionCount(idClient) > intMaxCon) {
      while ((mOp.Greater(m$.getSystem().getLicense().ConnectionCount(idClient.get()),intMaxCon.get()))) {
        //<< set idClient = $piece(idClient, "_", 1)_"_"_$increment(intAddNo)
        idClient.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(idClient.get(),"_",1),"_"),m$.Fnc.$increment(intAddNo)));
      }
      //<< }
      //<< if ($System.License.ConnectionCount(idClient) = 0) set blnNewCon = $$$YES
      if ((mOp.Equal(m$.getSystem().getLicense().ConnectionCount(idClient.get()),0))) {
        blnNewCon.set(include.COMSYS.$$$YES(m$));
      }
      //<< 
      //<< // Do Login
      //<< if (blnCSPSession = $$$YES)  {  // CSP Login
      if ((mOp.Equal(blnCSPSession.get(),include.COMSYS.$$$YES(m$)))) {
        //<< set strStatus = %session.Login(idClient, , 1)    ; FIXME : Do we need sc to strStatus conversion? <GRF?
        strStatus.set(m$.getSession().getLogin(idClient.get(),null,1));
      }
      //<< }
      //<< else {                          // Job Login
      else {
        //<< set strStatus = $System.License.Login(idClient)  ; FIXME : ditto
        strStatus.set(m$.getSystem().getLicense().Login(idClient.get()));
      }
      //<< }
      //<< 
      //<< // Log Login
      //<< if ($$$ISOK(strStatus)) {
      if (mOp.Logical((include.COMSYS.$$$ISOK(m$,strStatus)))) {
        //<< do Log(idClient, blnNewCon)
        m$.Cmd.Do("Log",idClient.get(),blnNewCon.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< // Display Error Message on screen
    //<< if (('$$$ISOK(strStatus)) && (pblnShowError = $$$YES)) {
    if (mOp.Logical(((mOp.Not(include.COMSYS.$$$ISOK(m$,strStatus))) && (mOp.Equal(pblnShowError.get(),include.COMSYS.$$$YES(m$)))))) {
      //<< write "<b>Unable to allocate license<b>"
      m$.Cmd.Write("<b>Unable to allocate license<b>");
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< AllocWebLicense(YBED)
  public Object AllocWebLicense(Object ... _p) {
    mVar YBED = m$.newVarRef("YBED",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$allocWebLicense^COMSTARTZstart($$GetLicenseIdFromUser(YBED))
    return m$.fnc$("COMSTARTZstart.allocWebLicense",m$.fnc$("GetLicenseIdFromUser",YBED.get()));
  }

  //<< 
  //<< AllocWebServiceLicense(YBED)
  public Object AllocWebServiceLicense(Object ... _p) {
    mVar YBED = m$.newVarRef("YBED",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$allocWebServiceLicense^COMSTARTZstart($$GetLicenseIdFromUser(YBED))
    return m$.fnc$("COMSTARTZstart.allocWebServiceLicense",m$.fnc$("GetLicenseIdFromUser",YBED.get()));
  }

  //<< 
  //<< AllocServiceLicense(YBED)
  public Object AllocServiceLicense(Object ... _p) {
    mVar YBED = m$.newVarRef("YBED",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$allocServiceLicense^COMSTARTZstart($$GetLicenseIdFromUser(YBED))
    return m$.fnc$("COMSTARTZstart.allocServiceLicense",m$.fnc$("GetLicenseIdFromUser",YBED.get()));
  }

  //<< 
  //<< GetLicenseIdFromUser(YBED)
  public Object GetLicenseIdFromUser(Object ... _p) {
    mVar YBED = m$.newVarRef("YBED",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new strLicenseUserId
    mVar strLicenseUserId = m$.var("strLicenseUserId");
    m$.newVar(strLicenseUserId);
    //<< 
    //<< if ($length(YBED) > 0) {
    if ((mOp.Greater(m$.Fnc.$length(YBED.get()),0))) {
      //<< set strLicenseUserId = $$$WWW013LicenseUserId($get(^WWW013(0, YBED, 1)))
      strLicenseUserId.set(include.WWWConst.$$$WWW013LicenseUserId(m$,m$.Fnc.$get(m$.var("^WWW013",0,YBED.get(),1))));
      //<< if ($length(strLicenseUserId) = 0) {
      if ((mOp.Equal(m$.Fnc.$length(strLicenseUserId.get()),0))) {
        //<< set strLicenseUserId = YBED
        strLicenseUserId.set(YBED.get());
      }
    }
    //<< }
    //<< }
    //<< else {
    else {
      //<< set strLicenseUserId = ""
      strLicenseUserId.set("");
    }
    //<< }
    //<< 
    //<< quit strLicenseUserId
    return strLicenseUserId.get();
  }

  //<< 
  //<< Log(pidClient="unknown", pblnNewCon=$$$NO)
  public Object Log(Object ... _p) {
    mVar pidClient = m$.newVarRef("pidClient",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"unknown");
    mVar pblnNewCon = m$.newVarRef("pblnNewCon",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Log CSP License Logins
    //<< ;
    //<< ; Inputs: pidClient    = Client Id
    //<< ;         pblnNewCon   = New Connection (force log)
    //<< ;
    //<< ; History:
    //<< ; 22-Oct-2008   FIS     SR16065: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intLogin, intHrs
    mVar intLogin = m$.var("intLogin");
    mVar intHrs = m$.var("intHrs");
    m$.newVar(intLogin,intHrs);
    //<< 
    //<< set intHrs = $piece($horolog, ",", 2) / 60 \ 60  ; current hour
    intHrs.set(mOp.IntegerDivide(mOp.Divide(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),60),60));
    //<< 
    //<< if ((pblnNewCon = $$$YES) ||
    //<< ('$data(^CacheTempLicenseLogin(+$horolog,pidClient)))) {
    if (mOp.Logical(((mOp.Equal(pblnNewCon.get(),include.COMSYS.$$$YES(m$))) || (mOp.Not(m$.Fnc.$data(m$.var("^CacheTempLicenseLogin",mOp.Positive(m$.Fnc.$horolog()),pidClient.get()))))))) {
      //<< set intLogin = $order(^CacheTempLicenseLogin(+$horolog, pidClient, ""), -1) + 1
      intLogin.set(mOp.Add(m$.Fnc.$order(m$.var("^CacheTempLicenseLogin",mOp.Positive(m$.Fnc.$horolog()),pidClient.get(),""),mOp.Negative(1)),1));
      //<< set ^CacheTempLicenseLogin(+$horolog, pidClient, intLogin) =
      //<< $listbuild($piece($horolog, ",", 2), intHrs)
      m$.var("^CacheTempLicenseLogin",mOp.Positive(m$.Fnc.$horolog()),pidClient.get(),intLogin.get()).set(m$.Fnc.$listbuild(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),intHrs.get()));
    }
    //<< }
    //<< 
    //<< quit 1
    return 1;
  }

  //<< 
  //<< Snapshot()
  public Object Snapshot(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Log Snapshot of License Usage
    //<< ;
    //<< ; History:
    //<< ; 22-Oct-2008   FIS     SR16065: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intHrs, intNext, intSum
    mVar intHrs = m$.var("intHrs");
    mVar intNext = m$.var("intNext");
    mVar intSum = m$.var("intSum");
    m$.newVar(intHrs,intNext,intSum);
    //<< 
    //<< set intHrs = $piece($horolog, ",", 2) / 60 \ 60  ; current hour
    intHrs.set(mOp.IntegerDivide(mOp.Divide(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),60),60));
    //<< 
    //<< // Save current license usage
    //<< set intNext = $order(^CacheTempLicenseUsage(+$horolog, intHrs, ""), -1) + 1
    intNext.set(mOp.Add(m$.Fnc.$order(m$.var("^CacheTempLicenseUsage",mOp.Positive(m$.Fnc.$horolog()),intHrs.get(),""),mOp.Negative(1)),1));
    //<< set ^CacheTempLicenseUsage(+$horolog, intHrs, intNext) =
    //<< $System.License.LUConsumed()  // current license consumption
    m$.var("^CacheTempLicenseUsage",mOp.Positive(m$.Fnc.$horolog()),intHrs.get(),intNext.get()).set(m$.getSystem().getLicense().LUConsumed());
    //<< 
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< GetHourConsumption(pdteDay, pintHrs, pblnGetMax=$$$NO)
  public Object GetHourConsumption(Object ... _p) {
    mVar pdteDay = m$.newVarRef("pdteDay",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintHrs = m$.newVarRef("pintHrs",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnGetMax = m$.newVarRef("pblnGetMax",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Calculate Maximum / Average License Usage per Hour
    //<< ;
    //<< ; Inputs:
    //<< ; pdteDay   = Day
    //<< ; pintHrs   = Hour (0-23, where 0= 0:00am-0:59am, 1= 1:00am-1:59am, ... 23= 11:00pm-11:59pm)
    //<< ; blnGetMax = Return Max. Consumption per Hour (default = Return Average Consumption)
    //<< ;
    //<< ; History:
    //<< ; 22-Oct-2008   FIS     SR16065: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intCounts, intNext, intSum, intMax, intNumber
    mVar intCounts = m$.var("intCounts");
    mVar intNext = m$.var("intNext");
    mVar intSum = m$.var("intSum");
    mVar intMax = m$.var("intMax");
    mVar intNumber = m$.var("intNumber");
    m$.newVar(intCounts,intNext,intSum,intMax,intNumber);
    //<< 
    //<< set intMax    = 0
    intMax.set(0);
    //<< set intSum    = 0
    intSum.set(0);
    //<< set intCounts = 0
    intCounts.set(0);
    //<< 
    //<< set pdteDay = +$get(pdteDay)
    pdteDay.set(mOp.Positive(m$.Fnc.$get(pdteDay)));
    //<< if (pdteDay = 0) set pdteDay = +$horolog
    if ((mOp.Equal(pdteDay.get(),0))) {
      pdteDay.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< 
    //<< // Calculate maximum / average License Usage per hour
    //<< if ((pintHrs '< 0) && (pintHrs '> 23)) {
    if (mOp.Logical(((mOp.NotLess(pintHrs.get(),0)) && (mOp.NotGreater(pintHrs.get(),23))))) {
      //<< set intNext = ""
      intNext.set("");
      //<< for {
      for (;true;) {
        //<< set intNext = $order(^CacheTempLicenseUsage(pdteDay, pintHrs, intNext))
        intNext.set(m$.Fnc.$order(m$.var("^CacheTempLicenseUsage",pdteDay.get(),pintHrs.get(),intNext.get())));
        //<< if (intNext = "") quit
        if ((mOp.Equal(intNext.get(),""))) {
          break;
        }
        //<< 
        //<< set intCounts = intCounts +1
        intCounts.set(mOp.Add(intCounts.get(),1));
        //<< set intNumber = $get(^CacheTempLicenseUsage(pdteDay, pintHrs, intNext))
        intNumber.set(m$.Fnc.$get(m$.var("^CacheTempLicenseUsage",pdteDay.get(),pintHrs.get(),intNext.get())));
        //<< set intSum = intSum + intNumber
        intSum.set(mOp.Add(intSum.get(),intNumber.get()));
        //<< if (intNumber > intMax) set intMax = intNumber
        if ((mOp.Greater(intNumber.get(),intMax.get()))) {
          intMax.set(intNumber.get());
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if (intCounts '= 0) {
    if ((mOp.NotEqual(intCounts.get(),0))) {
      //<< if (pblnGetMax = $$$YES) {             // Return Max. Number
      if ((mOp.Equal(pblnGetMax.get(),include.COMSYS.$$$YES(m$)))) {
        //<< set intSum = intMax
        intSum.set(intMax.get());
      }
      //<< }
      //<< else {
      else {
        //<< set intSum = (intSum \ intCounts)  // Return Average Number
        intSum.set((mOp.IntegerDivide(intSum.get(),intCounts.get())));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit intSum
    return intSum.get();
  }

  //<< 
  //<< GetDayConsumption(pdteDay, pblnGetMax=$$$NO)
  public Object GetDayConsumption(Object ... _p) {
    mVar pdteDay = m$.newVarRef("pdteDay",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnGetMax = m$.newVarRef("pblnGetMax",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Calculate Maximum / Average License Usage per Day
    //<< ;
    //<< ; Inputs:
    //<< ; pdteDay   = Day
    //<< ; blnGetMax = Return Max. Consumption (default = Return Average Consumption)
    //<< ;
    //<< ; History:
    //<< ; 22-Oct-2008   FIS     SR16065: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intSum, intMax, intNumber
    mVar intSum = m$.var("intSum");
    mVar intMax = m$.var("intMax");
    mVar intNumber = m$.var("intNumber");
    m$.newVar(intSum,intMax,intNumber);
    //<< 
    //<< set intSum = 0
    intSum.set(0);
    //<< set intMax = 0
    intMax.set(0);
    //<< 
    //<< set pdteDay = +$get(pdteDay)
    pdteDay.set(mOp.Positive(m$.Fnc.$get(pdteDay)));
    //<< if (pdteDay = 0) set pdteDay = +$horolog
    if ((mOp.Equal(pdteDay.get(),0))) {
      pdteDay.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< 
    //<< for intHrs = 0:1:23 {
    mVar intHrs = m$.var("intHrs");
    for (intHrs.set(0);(mOp.LessOrEqual(intHrs.get(),23));intHrs.set(mOp.Add(intHrs.get(),1))) {
      //<< set intNumber = $$GetHourConsumption(pdteDay, intHrs, pblnGetMax)
      intNumber.set(m$.fnc$("GetHourConsumption",pdteDay.get(),intHrs.get(),pblnGetMax.get()));
      //<< set intSum = intSum + intNumber
      intSum.set(mOp.Add(intSum.get(),intNumber.get()));
      //<< if (intNumber > intMax) set intMax = intNumber
      if ((mOp.Greater(intNumber.get(),intMax.get()))) {
        intMax.set(intNumber.get());
      }
    }
    //<< }
    //<< 
    //<< if (pblnGetMax) {
    if (mOp.Logical((pblnGetMax.get()))) {
      //<< set intSum = intMax
      intSum.set(intMax.get());
    }
    //<< }
    //<< elseif (intSum '= 0) {
    else if ((mOp.NotEqual(intSum.get(),0))) {
      //<< if ((intSum \ 24) > 0) {
      if ((mOp.Greater((mOp.IntegerDivide(intSum.get(),24)),0))) {
        //<< set intSum = (intSum \ 24)
        intSum.set((mOp.IntegerDivide(intSum.get(),24)));
      }
      //<< }
      //<< else {
      else {
        //<< set intSum = 1
        intSum.set(1);
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit intSum
    return intSum.get();
  }

  //<< 
  //<< GetMaxConsumption()
  public Object GetMaxConsumption(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return Maximum License Usage since installation
    //<< ;
    //<< ; History:
    //<< ; 22-Oct-2008   FIS     SR16065: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $System.License.LUMaxConsumed()  //current license consumption
    return m$.getSystem().getLicense().LUMaxConsumed();
  }

}
