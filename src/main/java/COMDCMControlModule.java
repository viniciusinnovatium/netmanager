//*****************************************************************************
//** TASC - ALPHALINC - MAC COMDCMControlModule
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:01
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; Control Module Event Queue handling
//<< ;-------------------------------------------------------------------------------
//<< #include %occStatus
import include.$occStatus;
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
//<< #include COMConst
import include.COMConst;

//<< COMDCMControlModule
public class COMDCMControlModule extends mClass {

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogRx(%1)       ;
  public static Object $$$LogRx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _COMDCMControlModule();
  }

  public void _COMDCMControlModule() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1_"^COMDCMControlModule("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< handleRelevantEvents(systemType,dataSourceName,eventType,recordKeys,recordData,pblnTransactions=$$$NO,pcheckSum="")  ;SR14365
  public Object handleRelevantEvents(Object ... _p) {
    mVar systemType = m$.newVarRef("systemType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar dataSourceName = m$.newVarRef("dataSourceName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar eventType = m$.newVarRef("eventType",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar recordKeys = m$.newVarRef("recordKeys",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar recordData = m$.newVarRef("recordData",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pblnTransactions = m$.newVarRef("pblnTransactions",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$NO(m$));
    mVar pcheckSum = m$.newVarRef("pcheckSum",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; check to see whether we are interested in the event
    //<< ; and if so performs any associated methods - Queue Jumper
    //<< ;
    //<< ; Returns:Status
    //<< ;
    //<< ; History:
    //<< ; 02-Oct-2007   GRF     SR15604: Relocated COMClassLog call before checking if
    //<< ;                       subsequent processing required (i.e. ALWAYS log
    //<< ;                       class/form changes).
    //<< ; 08-Jun-2006   shobby  SR14365: New optional field 'pcheckSum'.  This can be
    //<< ;                       used to determine if the record at both sites was the
    //<< ;                       same before modification.
    //<< ; 14-Oct-2005   Steve S SR13701: Set blnInterested before checking interested data
    //<< ; 10-Oct-2005   JW      SR13641: Remember whether event exists.
    //<< ; 08-Sep-2005   GRF     Reverted 13363 change until further notice
    //<< ; 05-Sep-2005   RPW     SR13363: If WWW122 or WWW121 comes through here, reindex it!
    //<< ; 04-Aug-2005   RPW     SR13149: Modified to make more like the original, if txns
    //<< ;                       are used then use them, otherwise do not use them.
    //<< ; 17-Jul-2005   RPW     SR13000: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;  eventComplete    state - "COMDCMPROCSTATUS"
    //<< ;                       0 - Error
    //<< ;                       1 - Processed
    //<< ;                       2 - Skipped
    //<< ;                       3 - Blocked
    //<< ;-------------------------------------------------------------------------------
    //<< $$$LogR("handleRelevantEvents",$get(dataSourceName)_"<"_$get(eventType)_"<"_$get(recordKeys))
    $$$LogR(m$,"handleRelevantEvents",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(dataSourceName),"<"),m$.Fnc.$get(eventType)),"<"),m$.Fnc.$get(recordKeys)));
    //<< 
    //<< quit:($get(dataSourceName)="")||($get(eventType)="") $$$OK      // SR13641
    if ((mOp.Equal(m$.Fnc.$get(dataSourceName),"")) || (mOp.Equal(m$.Fnc.$get(eventType),""))) {
      return include.COMSYS.$$$OK(m$);
    }
    //<< 
    //<< do:+$get(^SysSetup("COMClassLog","LoggingEnabled"))'=0 Log^COMClassLog($get(dataSourceName),$get(recordKeys),$get(recordData)) ;SR15604
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","COMClassLog","LoggingEnabled"))),0)) {
      m$.Cmd.Do("COMClassLog.Log",m$.Fnc.$get(dataSourceName),m$.Fnc.$get(recordKeys),m$.Fnc.$get(recordData));
    }
    //<< quit:($get(YUSER)'="")&&($get(^CacheTempDCMEventExists(YUSER,dataSourceName,eventType))=$$$NO) $$$OK
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) && (mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempDCMEventExists",m$.var("YUSER").get(),dataSourceName.get(),eventType.get())),include.COMSYS.$$$NO(m$)))) {
      return include.COMSYS.$$$OK(m$);
    }
    //<< 
    //<< new status,eventName,dataSourceNameUC,currLoc,DEBUG,actionperformed
    mVar status = m$.var("status");
    mVar eventName = m$.var("eventName");
    mVar dataSourceNameUC = m$.var("dataSourceNameUC");
    mVar currLoc = m$.var("currLoc");
    mVar DEBUG = m$.var("DEBUG");
    mVar actionperformed = m$.var("actionperformed");
    m$.newVar(status,eventName,dataSourceNameUC,currLoc,DEBUG,actionperformed);
    //<< new httpRequest,blockedTarget,recordNo,eventComplete,idxCurrLoc
    mVar httpRequest = m$.var("httpRequest");
    mVar blockedTarget = m$.var("blockedTarget");
    mVar recordNo = m$.var("recordNo");
    mVar eventComplete = m$.var("eventComplete");
    mVar idxCurrLoc = m$.var("idxCurrLoc");
    m$.newVar(httpRequest,blockedTarget,recordNo,eventComplete,idxCurrLoc);
    //<< new methodName,target,blnImmediate,blnInterested,eventTypeUC
    mVar methodName = m$.var("methodName");
    mVar target = m$.var("target");
    mVar blnImmediate = m$.var("blnImmediate");
    mVar blnInterested = m$.var("blnInterested");
    mVar eventTypeUC = m$.var("eventTypeUC");
    m$.newVar(methodName,target,blnImmediate,blnInterested,eventTypeUC);
    //<< 
    //<< set DEBUG=$data(^COMDCMDebug)
    DEBUG.set(m$.Fnc.$data(m$.var("^COMDCMDebug")));
    //<< do:DEBUG LogDebugMessage^COMDCMUtilities("START","handleRelevantEvents")
    if (mOp.Logical(DEBUG.get())) {
      m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","START","handleRelevantEvents");
    }
    //<< 
    //<< set systemType       = $get(systemType)
    systemType.set(m$.Fnc.$get(systemType));
    //<< set eventTypeUC      = $$$Index($get(eventType))
    eventTypeUC.set(include.MEDConst.$$$Index(m$,m$.Fnc.$get(eventType)));
    //<< set dataSourceNameUC = $$$Index($get(dataSourceName))
    dataSourceNameUC.set(include.MEDConst.$$$Index(m$,m$.Fnc.$get(dataSourceName)));
    //<< 
    //<< ;do:+$get(^SysSetup("COMClassLog","LoggingEnabled"))'=0 Log^COMClassLog($get(dataSourceName),$get(recordKeys),$get(recordData)) ;SR15604 move ^^^
    //<< 
    //<< set currLoc = $$getCurrentLocation^COMDCMUtilities()
    currLoc.set(m$.fnc$("COMDCMUtilities.getCurrentLocation"));
    //<< $$$LogRx("CDCM:1:"_currLoc)
    $$$LogRx(m$,mOp.Concat("CDCM:1:",currLoc.get()));
    //<< 
    //<< do:DEBUG LogDebugMessage^COMDCMUtilities("currLoc",currLoc)
    if (mOp.Logical(DEBUG.get())) {
      m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","currLoc",currLoc.get());
    }
    //<< set idxCurrLoc = $$$Index(currLoc)
    idxCurrLoc.set(include.MEDConst.$$$Index(m$,currLoc));
    //<< 
    //<< set status          = 1                 ; indicates nothing performed
    status.set(1);
    //<< set actionperformed = $$$NO
    actionperformed.set(include.COMSYS.$$$NO(m$));
    //<< set httpRequest     = ""
    httpRequest.set("");
    //<< set blockedTarget   = ""
    blockedTarget.set("");
    //<< 
    //<< ; Cleanup any past runs
    //<< kill ^mtemp("COMDCMTryEvent",$job)
    m$.var("^mtemp","COMDCMTryEvent",m$.Fnc.$job()).kill();
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if pblnTransactions {
    if (mOp.Logical(pblnTransactions.get())) {
    }
    //<< tstart
    //<< }
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< set blnInterested = $$$NO
    blnInterested.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if ((currLoc'="") &&
    //<< (($zconvert(systemType,"U")="INTRAPREND") ||
    //<< ($zconvert(systemType,"U")="DISCLINC") )   ) {
    if (mOp.Logical(((mOp.NotEqual(currLoc.get(),"")) && mOp.Logical(((mOp.Equal(m$.Fnc.$zconvert(systemType.get(),"U"),"INTRAPREND")) || (mOp.Equal(m$.Fnc.$zconvert(systemType.get(),"U"),"DISCLINC"))))))) {
      //<< 
      //<< set eventName = ""
      eventName.set("");
      //<< for   {
      for (;true;) {
        //<< set eventName = $order(^COMDCMEvents(0,1,eventTypeUC,dataSourceNameUC,eventName))
        eventName.set(m$.Fnc.$order(m$.var("^COMDCMEvents",0,1,eventTypeUC.get(),dataSourceNameUC.get(),eventName.get())));
        //<< quit:eventName=""
        if (mOp.Equal(eventName.get(),"")) {
          break;
        }
        //<< 
        //<< ; Not allowed for immediate access
        //<< set blnImmediate = +$$$COMDCMEventAllowImmediate($get(^COMDCMEvent(0,eventName,1)))
        blnImmediate.set(mOp.Positive(include.COMConst.$$$COMDCMEventAllowImmediate(m$,m$.Fnc.$get(m$.var("^COMDCMEvent",0,eventName.get(),1)))));
        //<< 
        //<< $$$LogRx("CDCM:2:"_eventName_"<"_blnImmediate)
        $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat("CDCM:2:",eventName.get()),"<"),blnImmediate.get()));
        //<< ; not an event that's relevant for current location
        //<< if ('$$checkInterestedEvent^COMDCMUtilities(currLoc,eventName)) continue
        if ((mOp.Not(m$.fnc$("COMDCMUtilities.checkInterestedEvent",currLoc.get(),eventName.get())))) {
          continue;
        }
        //<< set blnInterested=$$$YES         ;SR13701 Set this before checking interested data
        blnInterested.set(include.COMSYS.$$$YES(m$));
        //<< if ('$$checkInterestedData^COMDCMUtilities(eventName,$get(recordKeys),$get(recordData))) continue   ;SR12578
        if ((mOp.Not(m$.fnc$("COMDCMUtilities.checkInterestedData",eventName.get(),m$.Fnc.$get(recordKeys),m$.Fnc.$get(recordData))))) {
          continue;
        }
        //<< 
        //<< ;SR13701 Set this before checking interested data
        //<< ;set blnInterested=$$$YES
        //<< 
        //<< set status = $$putEventOnQueue(eventName,systemType,dataSourceName,recordKeys,$get(recordData),'blnImmediate,DEBUG,pcheckSum)  ;SR14365
        status.set(m$.fnc$("putEventOnQueue",eventName.get(),systemType.get(),dataSourceName.get(),recordKeys.get(),m$.Fnc.$get(recordData),mOp.Not(blnImmediate.get()),DEBUG.get(),pcheckSum.get()));
        //<< $$$LogRx("CDCM:3:"_status)
        $$$LogRx(m$,mOp.Concat("CDCM:3:",status.get()));
        //<< quit:'$piece(status,Y,1)
        if (mOp.Not(m$.Fnc.$piece(status.get(),m$.var("Y").get(),1))) {
          break;
        }
        //<< 
        //<< if blnImmediate {
        if (mOp.Logical(blnImmediate.get())) {
          //<< ; Now ready to perform the event
          //<< set recordNo      = $piece(status,Y,2)      ; entry no returned on success
          recordNo.set(m$.Fnc.$piece(status.get(),m$.var("Y").get(),2));
          //<< set eventComplete = 1
          eventComplete.set(1);
          //<< set status        = $$performEvent(currLoc,.httpRequest,.blockedTarget,recordNo,.eventComplete,$$$NO,DEBUG,idxCurrLoc)
          status.set(m$.fnc$("performEvent",currLoc.get(),httpRequest,blockedTarget,recordNo.get(),eventComplete,include.COMSYS.$$$NO(m$),DEBUG.get(),idxCurrLoc.get()));
          //<< $$$LogRx("CDCM:4:"_status)
          $$$LogRx(m$,mOp.Concat("CDCM:4:",status.get()));
          //<< 
          //<< ; Downgrade any Errors to Skipped - as Synchronous events not reprocessed
          //<< if (eventComplete=0) set eventComplete = 2
          if ((mOp.Equal(eventComplete.get(),0))) {
            eventComplete.set(2);
          }
          //<< 
          //<< ; update the Events Processed information
          //<< set %d = $get(^mtemp("COMDCMEvent",recordNo,1))
          m$.var("%d").set(m$.Fnc.$get(m$.var("^mtemp","COMDCMEvent",recordNo.get(),1)));
          //<< set $$$COMDCMEventsProcessedProcDateTime(%d) = $HOROLOG
          include.COMConst.$$$COMDCMEventsProcessedProcDateTimeSet(m$,m$.var("%d"),m$.Fnc.$horolog());
          //<< set $$$COMDCMEventsProcessedProcStatus(%d)   = eventComplete
          include.COMConst.$$$COMDCMEventsProcessedProcStatusSet(m$,m$.var("%d"),eventComplete.get());
          //<< do Save^COMUtils("COMDCMEventsProcessed",recordNo,%d,1)
          m$.Cmd.Do("COMUtils.Save","COMDCMEventsProcessed",recordNo.get(),m$.var("%d").get(),1);
          //<< 
          //<< $$$LogRx("CDCM:5:"_recordNo)
          $$$LogRx(m$,mOp.Concat("CDCM:5:",recordNo.get()));
          //<< merge ^COMDCMEventsProcessedData(0,recordNo)        = ^mtemp("COMDCMEventData",recordNo)
          m$.Cmd.Merge(m$.var("^COMDCMEventsProcessedData",0,recordNo.get()),m$.var("^mtemp","COMDCMEventData",recordNo.get()));
          //<< merge ^COMDCMEventsProcessedDataComplex(0,recordNo) = ^mtemp("COMDCMEventDataComplex",recordNo)
          m$.Cmd.Merge(m$.var("^COMDCMEventsProcessedDataComplex",0,recordNo.get()),m$.var("^mtemp","COMDCMEventDataComplex",recordNo.get()));
          //<< 
          //<< ; cleanup the event entries
          //<< kill ^mtemp("COMDCMEvent",recordNo)
          m$.var("^mtemp","COMDCMEvent",recordNo.get()).kill();
          //<< kill ^mtemp("COMDCMEventData",recordNo)
          m$.var("^mtemp","COMDCMEventData",recordNo.get()).kill();
          //<< kill ^mtemp("COMDCMEventDataComplex",recordNo)
          m$.var("^mtemp","COMDCMEventDataComplex",recordNo.get()).kill();
          //<< 
          //<< $$$LogRx("CDCM:6:"_status)
          $$$LogRx(m$,mOp.Concat("CDCM:6:",status.get()));
          //<< quit:'$piece(status,Y,1)        ; stop on first error
          if (mOp.Not(m$.Fnc.$piece(status.get(),m$.var("Y").get(),1))) {
            break;
          }
          //<< 
          //<< ; Save the returned data
          //<< set methodName=""
          methodName.set("");
          //<< for {
          for (;true;) {
            //<< set methodName=$order(^COMDCMEventsProcessedTarget(0,recordNo,methodName))
            methodName.set(m$.Fnc.$order(m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get())));
            //<< quit:(methodName="")
            if ((mOp.Equal(methodName.get(),""))) {
              break;
            }
            //<< 
            //<< set target=""
            target.set("");
            //<< for {
            for (;true;) {
              //<< set target=$order(^COMDCMEventsProcessedTarget(0,recordNo,methodName,target))
              target.set(m$.Fnc.$order(m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get(),target.get())));
              //<< quit:(target="")
              if ((mOp.Equal(target.get(),""))) {
                break;
              }
              //<< 
              //<< $$$LogRx("CDCM:7:"_methodName_"<"_target_"<")
              $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CDCM:7:",methodName.get()),"<"),target.get()),"<"));
              //<< set ^mtemp("COMDCMTryEvent",$job,recordNo,methodName,target,"*Result*")=$$$COMDCMEventsProcessedTargetMessage1($get(^COMDCMEventsProcessedTarget(0,recordNo,methodName,target,1)))
              m$.var("^mtemp","COMDCMTryEvent",m$.Fnc.$job(),recordNo.get(),methodName.get(),target.get(),"*Result*").set(include.COMConst.$$$COMDCMEventsProcessedTargetMessage1(m$,m$.Fnc.$get(m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get(),target.get(),1))));
            }
          }
          //<< }
          //<< }
          //<< merge ^mtemp("COMDCMTryEvent",$job,recordNo)=^COMDCMEventsProcessedTargetReturn(0,recordNo)
          m$.Cmd.Merge(m$.var("^mtemp","COMDCMTryEvent",m$.Fnc.$job(),recordNo.get()),m$.var("^COMDCMEventsProcessedTargetReturn",0,recordNo.get()));
          //<< set actionperformed=$$$YES
          actionperformed.set(include.COMSYS.$$$YES(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if $get(YUSER)'="" {                // SR13641
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      //<< set ^CacheTempDCMEventExists(YUSER,dataSourceName,eventType) = blnInterested
      m$.var("^CacheTempDCMEventExists",m$.var("YUSER").get(),dataSourceName.get(),eventType.get()).set(blnInterested.get());
    }
    //<< }
    //<< 
    //<< $$$LogRx("CDCM:8:"_status)
    $$$LogRx(m$,mOp.Concat("CDCM:8:",status.get()));
    //<< if ('$piece(status,Y,1)) {
    if ((mOp.Not(m$.Fnc.$piece(status.get(),m$.var("Y").get(),1)))) {
      //<< if pblnTransactions {
      if (mOp.Logical(pblnTransactions.get())) {
        //<< ;+++++++++++++++++++++++++++++++++++++++
        //<< $$$LogRx("CDCM:TROLLBACK:")
        $$$LogRx(m$,"CDCM:TROLLBACK:");
        //<< TROLLBACK
        //<< ;+++++++++++++++++++++++++++++++++++++++
        //<< do NotifyAdmin^COMUtils("handleRelevantEvents^COMDCMControlModule",status)
        m$.Cmd.Do("COMUtils.NotifyAdmin","handleRelevantEvents^COMDCMControlModule",status.get());
      }
    }
    //<< }
    //<< } else {
    else {
      //<< if pblnTransactions {
      if (mOp.Logical(pblnTransactions.get())) {
        //<< ;+++++++++++++++++++++++++++++++++++++++
        //<< $$$LogRx("CDCM:TCOMMIT")
        $$$LogRx(m$,"CDCM:TCOMMIT");
        //<< if $tlevel>0 TCOMMIT
        if (mOp.Greater(m$.Fnc.$tlevel(),0)) {
        }
      }
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< 
      //<< ; SR13363
      //<< ;   if (dataSourceName="WWW122")||(dataSourceName="WWW121") {
      //<< ;       do START1^WWWSORTGEN(dataSourceName,YM)   ;JOB STARTEN ;launching
      //<< ;   }
      //<< }
      //<< if actionperformed {
      if (mOp.Logical(actionperformed.get())) {
        //<< set status=1_Y_"^mtemp(""COMDCMTryEvent"","_$job_")"
        status.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(1,m$.var("Y").get()),"^mtemp(\"COMDCMTryEvent\","),m$.Fnc.$job()),")"));
      }
    }
    //<< }
    //<< }
    //<< quit status
    return status.get();
  }

  //<< 
  //<< 
  //<< setRelevantEvents(systemType,dataSourceName,eventType,recordKeys,recordData,pcheckSum="") ;SR14365
  public Object setRelevantEvents(Object ... _p) {
    mVar systemType = m$.newVarRef("systemType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar dataSourceName = m$.newVarRef("dataSourceName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar eventType = m$.newVarRef("eventType",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar recordKeys = m$.newVarRef("recordKeys",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar recordData = m$.newVarRef("recordData",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pcheckSum = m$.newVarRef("pcheckSum",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    //<< /*------------------------------------------------------------------------------
    //<< ; check to see whether we are interested in the event
    //<< ; and if so calls the routine to place details on the queue
    //<< ;
    //<< ; Uses Index : 1.1 Exent Type       (Save, Delete, Other)
    //<< ;              1.2 Data Source Name (Class name)
    //<< ;
    //<< ; NOTE : handled RelevantEvents *** WILL *** invoke transaction processing (TSTART/TCOMMIT/TROLLBACK)
    //<< ;
    //<< ; Returns:Status
    //<< ;
    //<< ; History:
    //<< ; 02-Mar-2005   shobby  SR14365: New optional field 'pcheckSum'.  This can be
    //<< ;                       used to determine if the record at both sites was the
    //<< ;                       same before modification.
    //<< ; 04-Aug-2005   RPW     SR13149: We want transaction handling in handleRelevantEvents
    //<< ; 30-Jun-2005   shobby  SR12578: Call to checkInterestedData to determine whether
    //<< ;                       this item should not be placed on DCM queue.
    //<< ; 13-Apr-2005   SCR     SR: Class & Form Logging
    //<< ; 21-Feb-2005   RobertW SR11273: tcommit needs the $tlevel check, not the trollback
    //<< ; 05-Jul-2004   Paul K  added check for $tlevel
    //<< ;-----------------------------------------------------------------------------*/
    //<< quit $$handleRelevantEvents($get(systemType),$get(dataSourceName),$get(eventType),$get(recordKeys),$get(recordData),$$$YES,$get(pcheckSum)) ;SR14365
    return m$.fnc$("handleRelevantEvents",m$.Fnc.$get(systemType),m$.Fnc.$get(dataSourceName),m$.Fnc.$get(eventType),m$.Fnc.$get(recordKeys),m$.Fnc.$get(recordData),include.COMSYS.$$$YES(m$),m$.Fnc.$get(pcheckSum));
  }

  //<< 
  //<< tryRelevantEvents(systemType,dataSourceName,eventType,recordKeys,recordData)
  public Object tryRelevantEvents(Object ... _p) {
    mVar systemType = m$.newVarRef("systemType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar dataSourceName = m$.newVarRef("dataSourceName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar eventType = m$.newVarRef("eventType",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar recordKeys = m$.newVarRef("recordKeys",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar recordData = m$.newVarRef("recordData",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< /*------------------------------------------------------------------------------
    //<< ; check to see whether we are interested in the event
    //<< ; and if so performs any associated methods - Queue Jumper
    //<< ;
    //<< ; NOTE : handled RelevantEvents *** WILL NOT *** invoke transaction processing (TSTART/TCOMMIT/TROLLBACK)
    //<< ;
    //<< ; Returns:Status
    //<< ;
    //<< ; History:
    //<< ; 04-Jun-2007   GRF     Explicitly show blnTransaction as $$$NO
    //<< ; 27-Apr-2005   Paul K  Pass in DCM Location.
    //<< ;-----------------------------------------------------------------------------*/
    //<< quit $$handleRelevantEvents($get(systemType),$get(dataSourceName),$get(eventType),$get(recordKeys),$get(recordData),$$$NO)
    return m$.fnc$("handleRelevantEvents",m$.Fnc.$get(systemType),m$.Fnc.$get(dataSourceName),m$.Fnc.$get(eventType),m$.Fnc.$get(recordKeys),m$.Fnc.$get(recordData),include.COMSYS.$$$NO(m$));
  }

  //<< 
  //<< putEventOnQueue(eventName,systemType,%recordName,%recordKeys,%recordData,storeOnQueue,DEBUG,%checkSum="") ;SR14365
  public Object putEventOnQueue(Object ... _p) {
    mVar eventName = m$.newVarRef("eventName",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar systemType = m$.newVarRef("systemType",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$recordName = m$.newVarRef("p$recordName",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar p$recordKeys = m$.newVarRef("p$recordKeys",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar p$recordData = m$.newVarRef("p$recordData",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar storeOnQueue = m$.newVarRef("storeOnQueue",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar DEBUG = m$.newVarRef("DEBUG",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar p$checkSum = m$.newVarRef("p$checkSum",(((_p!=null)&&(_p.length>=8))?_p[7]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Place details of the Event on the Queue
    //<< ;
    //<< ;       +++++++++++++++++++++++++++++++++++++++++++++++
    //<< ;       +                                             +
    //<< ;       + Event definition makes use of variables     +
    //<< ;       + available in this routine - thus parameters +
    //<< ;       + may not appear to be used.                  +
    //<< ;       +                                             +
    //<< ;       +++++++++++++++++++++++++++++++++++++++++++++++
    //<< ;
    //<< ; See : System >> Control Module >> Available Events : Field definition
    //<< ;       (e.g. %recordData => 'Data', %recordKeys => 'Key')
    //<< ;
    //<< ; History :
    //<< ; 18-Jun-2007   GRF     SR15546: identify source of error
    //<< ; 05-Jun-2007   GRF     SR15533: make sure slate is clean since TROLLBACK
    //<< ;                       won't clear ^mtemp
    //<< ; 02-Mar-2006   shobby  SR14365: New optional field '%checkSum'. This can be
    //<< ;                       used to determine if the record at both sites was the
    //<< ;                       same before modification.
    //<< ; 05-Jan-2005   GRF     SR11415 : Use Macros
    //<< ;-------------------------------------------------------------------------------
    //<< new dataItem,queuePos,XMLInput,status,txtlist
    mVar dataItem = m$.var("dataItem");
    mVar queuePos = m$.var("queuePos");
    mVar XMLInput = m$.var("XMLInput");
    mVar status = m$.var("status");
    mVar txtlist = m$.var("txtlist");
    m$.newVar(dataItem,queuePos,XMLInput,status,txtlist);
    //<< new %d,complexData,code,gloName,savedYM,savedTlevel
    mVar complexData = m$.var("complexData");
    mVar code = m$.var("code");
    mVar gloName = m$.var("gloName");
    mVar savedYM = m$.var("savedYM");
    mVar savedTlevel = m$.var("savedTlevel");
    m$.newVar(complexData,code,gloName,savedYM,savedTlevel);
    //<< 
    //<< set $ZTRAP="putEventOnQueueErr"
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("putEventOnQueueErr");
    //<< do:DEBUG LogDebugMessage^COMDCMUtilities("START","putEventOnQueue")
    if (mOp.Logical(DEBUG.get())) {
      m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","START","putEventOnQueue");
    }
    //<< 
    //<< ; Ensure a single counter for all companies
    //<< set savedYM=YM
    savedYM.set(m$.var("YM").get());
    //<< set YM=0
    mVar YM = m$.var("YM");
    YM.set(0);
    //<< set %("%KEY","YM")=YM
    m$.var("%","%KEY","YM").set(YM.get());
    //<< set queuePos=$$^WWWNEXT("COMDCMEventsQueue")
    queuePos.set(m$.fnc$("WWWNEXT.main","COMDCMEventsQueue"));
    //<< set YM=savedYM
    YM.set(savedYM.get());
    //<< set %("%KEY","YM")=YM
    m$.var("%","%KEY","YM").set(YM.get());
    //<< 
    //<< lock +^COMDCMEventsQueue(0,queuePos,1):30
    m$.Cmd.LockInc(m$.var("^COMDCMEventsQueue",0,queuePos.get(),1),30);
    //<< if ('$TEST) {
    if ((mOp.Not(m$.Fnc.$test()))) {
      //<< set status=0_Y_$$DecodeError^COMUtilError($listbuild("Com00083",queuePos)) ;    Unable to lock queue entry
      status.set(mOp.Concat(mOp.Concat(0,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild("Com00083",queuePos.get()))));
      //<< quit status
      return status.get();
    }
    //<< }
    //<< 
    //<< set %d=""
    m$.var("%d").set("");
    //<< set $$$COMDCMEventsQueueEventName(%d)   = eventName
    include.COMConst.$$$COMDCMEventsQueueEventNameSet(m$,m$.var("%d"),eventName.get());
    //<< set $$$COMDCMEventsQueueLogDateTime(%d) = $HOROLOG
    include.COMConst.$$$COMDCMEventsQueueLogDateTimeSet(m$,m$.var("%d"),m$.Fnc.$horolog());
    //<< set $$$COMDCMEventsQueueSystemType(%d)  = systemType
    include.COMConst.$$$COMDCMEventsQueueSystemTypeSet(m$,m$.var("%d"),systemType.get());
    //<< set $$$COMDCMEventsQueueCompany1(%d)    = savedYM
    include.COMConst.$$$COMDCMEventsQueueCompany1Set(m$,m$.var("%d"),savedYM.get());
    //<< 
    //<< if (storeOnQueue) {
    if (mOp.Logical((storeOnQueue.get()))) {
      //<< set ^COMDCMEventsQueue(0,queuePos,1)=%d
      m$.var("^COMDCMEventsQueue",0,queuePos.get(),1).set(m$.var("%d").get());
    }
    //<< } else {
    else {
      //<< kill ^mtemp("COMDCMEvent",queuePos)                 ; SR15533 make sure slate is clean
      m$.var("^mtemp","COMDCMEvent",queuePos.get()).kill();
      //<< kill ^mtemp("COMDCMEventData",queuePos)
      m$.var("^mtemp","COMDCMEventData",queuePos.get()).kill();
      //<< kill ^mtemp("COMDCMEventComplex",queuePos)
      m$.var("^mtemp","COMDCMEventComplex",queuePos.get()).kill();
      //<< set ^mtemp("COMDCMEvent",queuePos,1)=%d
      m$.var("^mtemp","COMDCMEvent",queuePos.get(),1).set(m$.var("%d").get());
    }
    //<< }
    //<< 
    //<< set status=$$$OK        ; nothing processed
    status.set(include.COMSYS.$$$OK(m$));
    //<< set dataItem=""
    dataItem.set("");
    //<< for   {
    for (;true;) {
      //<< set dataItem=$order(^COMDCMEventFields(0,eventName,dataItem))
      dataItem.set(m$.Fnc.$order(m$.var("^COMDCMEventFields",0,eventName.get(),dataItem.get())));
      //<< quit:dataItem=""
      if (mOp.Equal(dataItem.get(),"")) {
        break;
      }
      //<< 
      //<< set %d=$get(^COMDCMEventFields(0,eventName,dataItem,1))
      m$.var("%d").set(m$.Fnc.$get(m$.var("^COMDCMEventFields",0,eventName.get(),dataItem.get(),1)));
      //<< set code=$$$COMDCMEventFieldsFunctionCall(%d)
      code.set(include.COMConst.$$$COMDCMEventFieldsFunctionCall(m$,m$.var("%d")));
      //<< set code=$translate(code,$$$ACUTE,$$$DBLQUOTE)  ; get the quotes back
      code.set(m$.Fnc.$translate(code.get(),include.COMSYSString.$$$ACUTE(m$),include.COMSYSString.$$$DBLQUOTE(m$)));
      //<< 
      //<< if (storeOnQueue) {
      if (mOp.Logical((storeOnQueue.get()))) {
        //<< set code="s ^COMDCMEventsQueueData(0,"""_queuePos_""","""_dataItem_""",1)="_code
        code.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("s ^COMDCMEventsQueueData(0,\"",queuePos.get()),"\",\""),dataItem.get()),"\",1)="),code.get()));
      }
      //<< } else {
      else {
        //<< set code="s ^mtemp(""COMDCMEventData"","""_queuePos_""","""_dataItem_""",1)="_code
        code.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("s ^mtemp(\"COMDCMEventData\",\"",queuePos.get()),"\",\""),dataItem.get()),"\",1)="),code.get()));
      }
      //<< }
      //<< set savedTlevel=$tlevel
      savedTlevel.set(m$.Fnc.$tlevel());
      //<< do:DEBUG LogDebugMessage^COMDCMUtilities("Data marshalling code",code)
      if (mOp.Logical(DEBUG.get())) {
        m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","Data marshalling code",code.get());
      }
      //<< 
      //<< xecute code      ; save Event Queue Data
      m$.Cmd.Xecute(code.get());
      //<< 
      //<< do:(DEBUG && storeOnQueue) LogDebugMessage^COMDCMUtilities("Returned",$get(^COMDCMEventsQueueData(0,queuePos,dataItem,1)))
      if ((mOp.Logical(DEBUG.get()) && mOp.Logical(storeOnQueue.get()))) {
        m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","Returned",m$.Fnc.$get(m$.var("^COMDCMEventsQueueData",0,queuePos.get(),dataItem.get(),1)));
      }
      //<< do:(DEBUG && 'storeOnQueue) LogDebugMessage^COMDCMUtilities("Returned",$get(^mtemp("COMDCMEvent",queuePos,dataItem,1)))
      if ((mOp.Logical(DEBUG.get()) && mOp.Not(storeOnQueue.get()))) {
        m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","Returned",m$.Fnc.$get(m$.var("^mtemp","COMDCMEvent",queuePos.get(),dataItem.get(),1)));
      }
      //<< 
      //<< if (savedTlevel'=$tlevel) {
      if ((mOp.NotEqual(savedTlevel.get(),m$.Fnc.$tlevel()))) {
        //<< ; Called routine has changed TLEVEL  (either tstart without tcommit or else trollback - resets level to 0)
        //<< if (storeOnQueue) {
        if (mOp.Logical((storeOnQueue.get()))) {
          //<< set txtlist=$get(^COMDCMEventsQueueData(0,queuePos,dataItem,1))
          txtlist.set(m$.Fnc.$get(m$.var("^COMDCMEventsQueueData",0,queuePos.get(),dataItem.get(),1)));
        }
        //<< } else {
        else {
          //<< set txtlist=$get(^mtemp("COMDCMEventData",queuePos,dataItem,1))
          txtlist.set(m$.Fnc.$get(m$.var("^mtemp","COMDCMEventData",queuePos.get(),dataItem.get(),1)));
        }
        //<< }
        //<< ;   set txtlist=$listbuild("Com00037",code,txtlist) ; Transaction Level not maintained by called routine: %1 returned: %2
        //<< set txtlist=$listbuild("Com00037",code,txtlist_" (Ref:37021)")  ; SR15546
        txtlist.set(m$.Fnc.$listbuild("Com00037",code.get(),mOp.Concat(txtlist.get()," (Ref:37021)")));
        //<< set status=0_Y_$$DecodeError^COMUtilError(txtlist)
        status.set(mOp.Concat(mOp.Concat(0,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
        //<< quit
        break;
      }
      //<< }
      //<< 
      //<< ; if complex data, the event field function should have created it and what should be in the event queue
      //<< ; is now the name of the global holding the complex data. The function for a complex data type should
      //<< ; always return a global or local array name.  Merge the complex data from the global/array into
      //<< ; the event queue and remove the user's global/array
      //<< 
      //<< set complexData=$$$COMDCMEventFieldsComplexData(%d)
      complexData.set(include.COMConst.$$$COMDCMEventFieldsComplexData(m$,m$.var("%d")));
      //<< if (complexData) {
      if (mOp.Logical((complexData.get()))) {
        //<< if (storeOnQueue) {
        if (mOp.Logical((storeOnQueue.get()))) {
          //<< set gloName=$get(^COMDCMEventsQueueData(0,queuePos,dataItem,1))
          gloName.set(m$.Fnc.$get(m$.var("^COMDCMEventsQueueData",0,queuePos.get(),dataItem.get(),1)));
          //<< merge ^COMDCMEventsQueueDataComplex(0,queuePos,dataItem)=@gloName
          m$.Cmd.Merge(m$.var("^COMDCMEventsQueueDataComplex",0,queuePos.get(),dataItem.get()),m$.indirectVar(gloName.get()));
        }
        //<< } else {
        else {
          //<< set gloName=$get(^mtemp("COMDCMEventData",queuePos,dataItem,1))
          gloName.set(m$.Fnc.$get(m$.var("^mtemp","COMDCMEventData",queuePos.get(),dataItem.get(),1)));
          //<< merge ^mtemp("COMDCMEventDataComplex",queuePos,dataItem)=@gloName
          m$.Cmd.Merge(m$.var("^mtemp","COMDCMEventDataComplex",queuePos.get(),dataItem.get()),m$.indirectVar(gloName.get()));
        }
        //<< }
        //<< kill @gloName
        m$.indirectVar(gloName.get()).kill();
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; Note that Event Fields are picked up even if XML Input for this event, since some fields
    //<< ; may be used to determine the targetting and/or method
    //<< lock -^COMDCMEventsQueue(0,queuePos,1)#"I"
    m$.Cmd.Unlock(m$.var("^COMDCMEventsQueue",0,queuePos.get(),1),"I");
    //<< 
    //<< set:(status=$$$OK) status=$$$OK_Y_queuePos      ; return the Queue entry no
    if ((mOp.Equal(status.get(),include.COMSYS.$$$OK(m$)))) {
      status.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$OK(m$),m$.var("Y").get()),queuePos.get()));
    }
    //<< quit status
    return status.get();
  }

  //<< 
  //<< ///putEventOnQueueErr   ; Internal Tag
  //<< putEventOnQueueErr()    ; Internal Tag
  public Object putEventOnQueueErr(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; run-time error
    //<< ;-------------------------------------------------------------------------------
    //<< set $ZTRAP=""
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("");
    //<< if $get(^SysSetup("Debug")) do Debug
    if (mOp.Logical(m$.Fnc.$get(m$.var("^SysSetup","Debug")))) {
      m$.Cmd.Do("Debug");
    }
    //<< set status=0_Y_$$DecodeError^COMUtilError($listbuild("Com00020",eventName,dataItem,$ZERROR))    ;Data Marshalling Error for event (%1) and field (%2): %3
    mVar status = m$.var("status");
    status.set(mOp.Concat(mOp.Concat(0,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild("Com00020",m$.var("eventName").get(),m$.var("dataItem").get(),m$.Fnc.$zerror()))));
    //<< lock -^COMDCMEventsQueue(0,queuePos,1)#"I"
    m$.Cmd.Unlock(m$.var("^COMDCMEventsQueue",0,m$.var("queuePos").get(),1),"I");
    //<< do:DEBUG LogDebugMessage^COMDCMUtilities("putEventOnQueueErr",status)
    if (mOp.Logical(m$.var("DEBUG").get())) {
      m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","putEventOnQueueErr",status.get());
    }
    //<< quit status
    return status.get();
  }

  //<< 
  //<< Debug   ; Internal Tag
  public void Debug() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; In the event of an error in putEventOnQueue
    //<< ;
    //<< ; PLEASE NOTE : reference to XMLInput currently showing up as error in code check
    //<< ;
    //<< ; History:
    //<< ; 10-Sep-2008   GRF     Generalize
    //<< ; 08-Aug-2005   PO      SR13029: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;In case Common Dump does not work, store relevant variables myself.
    //<< 
    //<< ;Arguments
    //<< set ^zzDCM($i(^zzDCM),"eventName") = $get(eventName)
    m$.var("^zzDCM",m$.Fnc.$increment(m$.var("^zzDCM")),"eventName").set(m$.Fnc.$get(m$.var("eventName")));
    //<< set ^zzDCM(^zzDCM,"systemType")    = $get(systemType)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"systemType").set(m$.Fnc.$get(m$.var("systemType")));
    //<< set ^zzDCM(^zzDCM,"%recordName")   = $get(%recordName)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"%recordName").set(m$.Fnc.$get(m$.var("%recordName")));
    //<< set ^zzDCM(^zzDCM,"%recordKeys")   = $get(%recordKeys)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"%recordKeys").set(m$.Fnc.$get(m$.var("%recordKeys")));
    //<< set ^zzDCM(^zzDCM,"%recordData")   = $get(%recordData)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"%recordData").set(m$.Fnc.$get(m$.var("%recordData")));
    //<< set ^zzDCM(^zzDCM,"sotreOnQueue")  = $get(storeOnQueue)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"sotreOnQueue").set(m$.Fnc.$get(m$.var("storeOnQueue")));
    //<< set ^zzDCM(^zzDCM,"DEBUG")         = $get(DEBUG)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"DEBUG").set(m$.Fnc.$get(m$.var("DEBUG")));
    //<< 
    //<< ;Variables
    //<< set ^zzDCM(^zzDCM,"dataItem")      = $get(dataItem)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"dataItem").set(m$.Fnc.$get(m$.var("dataItem")));
    //<< set ^zzDCM(^zzDCM,"queuePos")      = $get(queuePos)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"queuePos").set(m$.Fnc.$get(m$.var("queuePos")));
    //<< set ^zzDCM(^zzDCM,"XMLInput")      = $get(XMLInput) // XMLInput
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"XMLInput").set(m$.Fnc.$get(m$.var("XMLInput")));
    //<< set ^zzDCM(^zzDCM,"status")        = $get(status)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"status").set(m$.Fnc.$get(m$.var("status")));
    //<< set ^zzDCM(^zzDCM,"txtlist")       = $get(txtlist)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"txtlist").set(m$.Fnc.$get(m$.var("txtlist")));
    //<< set ^zzDCM(^zzDCM,"%d")            = $get(%d)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"%d").set(m$.Fnc.$get(m$.var("%d")));
    //<< set ^zzDCM(^zzDCM,"complexData")   = $get(complexData)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"complexData").set(m$.Fnc.$get(m$.var("complexData")));
    //<< set ^zzDCM(^zzDCM,"code")          = $get(code)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"code").set(m$.Fnc.$get(m$.var("code")));
    //<< set ^zzDCM(^zzDCM,"gloName")       = $get(gloName)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"gloName").set(m$.Fnc.$get(m$.var("gloName")));
    //<< set ^zzDCM(^zzDCM,"savedYM")       = $get(savedYM)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"savedYM").set(m$.Fnc.$get(m$.var("savedYM")));
    //<< set ^zzDCM(^zzDCM,"savedTlevel")   = $get(savedTlevel)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"savedTlevel").set(m$.Fnc.$get(m$.var("savedTlevel")));
    //<< 
    //<< ;@NM globals
    //<< set ^zzDCM(^zzDCM,"YM")            = $get(YM)
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"YM").set(m$.Fnc.$get(m$.var("YM")));
    //<< 
    //<< ;Error details
    //<< set ^zzDCM(^zzDCM,"$ZERROR")       = $ZERROR
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"$ZERROR").set(m$.Fnc.$zerror());
    //<< set ^zzDCM(^zzDCM,"time of error") = $horolog
    m$.var("^zzDCM",m$.var("^zzDCM").get(),"time of error").set(m$.Fnc.$horolog());
    //<< 
    //<< do ##class(Common.Dump).DumpFile("error trap in putEventOnQueue","DCM")
    m$.Cmd.Do("Common.Dump.DumpFile","error trap in putEventOnQueue","DCM");
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< eventQueueManager()
  public Object eventQueueManager(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Processes the Event Queue
    //<< ;
    //<< ; Called by Housekeeping Scheduler "Process Event Queue" and also by
    //<< ; manual "Process Event Queue" menu option.
    //<< ;
    //<< ; 08-Sep-2006   JW      SR14987: NotifyAdmin done in perform event
    //<< ; ??-May-2006   JW      SR14615: Don't define local location details here
    //<< ; 20-Mar-2006   RPW/PO  SR14379: Get the error from perform event and if
    //<< ;                                it's an error, log it into [!]
    //<< ;-------------------------------------------------------------------------------
    //<< new recordNo,httpRequest,blockedTarget,eventComplete,DEBUG,eventLocationID,lastRecNo,status,savedYFORM,response,idxEventLocation
    mVar recordNo = m$.var("recordNo");
    mVar httpRequest = m$.var("httpRequest");
    mVar blockedTarget = m$.var("blockedTarget");
    mVar eventComplete = m$.var("eventComplete");
    mVar DEBUG = m$.var("DEBUG");
    mVar eventLocationID = m$.var("eventLocationID");
    mVar lastRecNo = m$.var("lastRecNo");
    mVar status = m$.var("status");
    mVar savedYFORM = m$.var("savedYFORM");
    mVar response = m$.var("response");
    mVar idxEventLocation = m$.var("idxEventLocation");
    m$.newVar(recordNo,httpRequest,blockedTarget,eventComplete,DEBUG,eventLocationID,lastRecNo,status,savedYFORM,response,idxEventLocation);
    //<< 
    //<< set recordNo=""
    recordNo.set("");
    //<< set httpRequest=""
    httpRequest.set("");
    //<< set blockedTarget=""
    blockedTarget.set("");
    //<< 
    //<< set response=$$^WWWTEXT("Com00018") ; Single shot processing completed
    response.set(m$.fnc$("WWWTEXT.main","Com00018"));
    //<< 
    //<< set DEBUG=$data(^COMDCMDebug)
    DEBUG.set(m$.Fnc.$data(m$.var("^COMDCMDebug")));
    //<< do:DEBUG LogDebugMessage^COMDCMUtilities("START","eventQueueManager")
    if (mOp.Logical(DEBUG.get())) {
      m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","START","eventQueueManager");
    }
    //<< 
    //<< /*  SR14615
    //<< ; Check the current location
    //<< set eventLocationID=$$getCurrentLocation^COMDCMUtilities()
    //<< 
    //<< if (eventLocationID="") ||
    //<< ('$data(^COMDCMLocation(0,eventLocationID,1))) {
    //<< quit $$^WWWTEXT("Com00015") ; Local location details have not been defined
    //<< }
    //<< set idxEventLocation=$$$Index(eventLocationID)
    //<< */
    //<< 
    //<< lock +^COMDCMEventsQueue(0,"processLock"):0
    m$.Cmd.LockInc(m$.var("^COMDCMEventsQueue",0,"processLock"),0);
    //<< if '$test {
    if (mOp.Not(m$.Fnc.$test())) {
      //<< quit $$^WWWTEXT("Com00016") ;   Not started as another instance is running
      return m$.fnc$("WWWTEXT.main","Com00016");
    }
    //<< }
    //<< 
    //<< 
    //<< ; Loop through the Event Queue
    //<< set lastRecNo=$order(^COMDCMEventsQueue(0,""),-1)
    lastRecNo.set(m$.Fnc.$order(m$.var("^COMDCMEventsQueue",0,""),mOp.Negative(1)));
    //<< set recordNo=""
    recordNo.set("");
    //<< for   {
    for (;true;) {
      //<< set recordNo=$order(^COMDCMEventsQueue(0,recordNo))
      recordNo.set(m$.Fnc.$order(m$.var("^COMDCMEventsQueue",0,recordNo.get())));
      //<< quit:recordNo=""
      if (mOp.Equal(recordNo.get(),"")) {
        break;
      }
      //<< 
      //<< lock +^COMDCMEventsQueue(0,recordNo,1):30
      m$.Cmd.LockInc(m$.var("^COMDCMEventsQueue",0,recordNo.get(),1),30);
      //<< if '$test {
      if (mOp.Not(m$.Fnc.$test())) {
        //<< set response=$$DecodeError^COMUtilError($listbuild("Com00083",recordNo)) ;  Unable to lock queue entry
        response.set(m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild("Com00083",recordNo.get())));
        //<< quit    ; skip any other queue entries
        break;
      }
      //<< }
      //<< 
      //<< ; N.B. handle any errors by using eventComplete
      //<< set eventComplete=1
      eventComplete.set(1);
      //<< 
      //<< ;do performEvent(eventLocationID,.httpRequest,.blockedTarget,recordNo,.eventComplete,1,DEBUG)
      //<< 
      //<< //set status=$$performEvent(eventLocationID,.httpRequest,.blockedTarget,recordNo,.eventComplete,1,DEBUG,idxEventLocation) // SR14379
      //<< set status=$$performEvent(,.httpRequest,.blockedTarget,recordNo,.eventComplete,1,DEBUG) // SR14379
      status.set(m$.fnc$("performEvent",null,httpRequest,blockedTarget,recordNo.get(),eventComplete,1,DEBUG.get()));
      //<< 
      //<< /* SR14987 - redundant, this is done in performEvent
      //<< // SR14379
      //<< if ('$piece(status,Y,1)) {
      //<< do NotifyAdmin^COMUtils("eventQueueManager^COMDCMControlModule",status)
      //<< } */
      //<< 
      //<< ; update the events processed information
      //<< 
      //<< set %d=$get(^COMDCMEventsQueue(0,recordNo,1))
      m$.var("%d").set(m$.Fnc.$get(m$.var("^COMDCMEventsQueue",0,recordNo.get(),1)));
      //<< set $$$COMDCMEventsProcessedProcDateTime(%d) = $HOROLOG
      include.COMConst.$$$COMDCMEventsProcessedProcDateTimeSet(m$,m$.var("%d"),m$.Fnc.$horolog());
      //<< set $$$COMDCMEventsProcessedProcStatus(%d)   = eventComplete
      include.COMConst.$$$COMDCMEventsProcessedProcStatusSet(m$,m$.var("%d"),eventComplete.get());
      //<< set status = $$$Save("COMDCMEventsProcessed",recordNo,%d,$$$YES)
      status.set(include.COMSYS.$$$Save(m$,"COMDCMEventsProcessed",recordNo,m$.var("%d"),include.COMSYS.$$$YES(m$)));
      //<< 
      //<< // SR14379
      //<< if $$$ISERR(status) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,status))) {
        //<< do NotifyAdmin^COMUtils("eventQueueManager^COMDCMControlModule",$$$Text(status))
        m$.Cmd.Do("COMUtils.NotifyAdmin","eventQueueManager^COMDCMControlModule",include.COMSYS.$$$Text(m$,status));
      }
      //<< }
      //<< 
      //<< merge ^COMDCMEventsProcessedData(0,recordNo)        = ^COMDCMEventsQueueData(0,recordNo)
      m$.Cmd.Merge(m$.var("^COMDCMEventsProcessedData",0,recordNo.get()),m$.var("^COMDCMEventsQueueData",0,recordNo.get()));
      //<< merge ^COMDCMEventsProcessedDataComplex(0,recordNo) = ^COMDCMEventsQueueDataComplex(0,recordNo)
      m$.Cmd.Merge(m$.var("^COMDCMEventsProcessedDataComplex",0,recordNo.get()),m$.var("^COMDCMEventsQueueDataComplex",0,recordNo.get()));
      //<< 
      //<< if ((eventComplete=1) || (eventComplete=2)) {
      if (mOp.Logical(((mOp.Equal(eventComplete.get(),1)) || (mOp.Equal(eventComplete.get(),2))))) {
        //<< ; cleanup the event queue for Complete or Skipped entries
        //<< kill ^COMDCMEventsQueue(0,recordNo,1)
        m$.var("^COMDCMEventsQueue",0,recordNo.get(),1).kill();
        //<< kill ^COMDCMEventsQueueData(0,recordNo)
        m$.var("^COMDCMEventsQueueData",0,recordNo.get()).kill();
        //<< kill ^COMDCMEventsQueueDataComplex(0,recordNo)
        m$.var("^COMDCMEventsQueueDataComplex",0,recordNo.get()).kill();
      }
      //<< }
      //<< lock -^COMDCMEventsQueue(0,recordNo,1)#"I"
      m$.Cmd.Unlock(m$.var("^COMDCMEventsQueue",0,recordNo.get(),1),"I");
      //<< 
      //<< if (recordNo=lastRecNo) quit    ;   skip any new queue entries
      if ((mOp.Equal(recordNo.get(),lastRecNo.get()))) {
        break;
      }
    }
    //<< 
    //<< }   ;   event loop
    //<< 
    //<< lock -^COMDCMEventsQueue(0,"processLock")#"I"
    m$.Cmd.Unlock(m$.var("^COMDCMEventsQueue",0,"processLock"),"I");
    //<< quit response
    return response.get();
  }

  //<< 
  //<< 
  //<< performEvent(eventLocationID,httpRequest,blockedTarget,recordNo,eventComplete,eventOnQueue,DEBUG,pidxEventLocation="")
  public Object performEvent(Object ... _p) {
    mVar eventLocationID = m$.newVarRef("eventLocationID",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar httpRequest = m$.newVarRef("httpRequest",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar blockedTarget = m$.newVarRef("blockedTarget",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar recordNo = m$.newVarRef("recordNo",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar eventComplete = m$.newVarRef("eventComplete",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar eventOnQueue = m$.newVarRef("eventOnQueue",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar DEBUG = m$.newVarRef("DEBUG",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pidxEventLocation = m$.newVarRef("pidxEventLocation",(((_p!=null)&&(_p.length>=8))?_p[7]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Processes an event
    //<< ;
    //<< ; Inputs:
    //<< ;   eventComplete       State code - initially 1
    //<< ;   eventOnQueue        boolean; Data is in ^COMDCMEventsQueue if $$$YES; otherwise it is in ^mtemp
    //<< ;
    //<< ; History :
    //<< ; 20-Jun-2008   GRF     SR15787: eventOnQueue tested once instead of for each
    //<< ;                           value - performance; include target if notifying
    //<< ;                           Administrator of error
    //<< ; 12-Jun-2008   GRF     SR15787: add error text; doco; boolean macro
    //<< ; 18-Jun-2007   GRF     SR15546: identify source of error
    //<< ; 08-Sep-2006   JW      SR14987: Only send email once
    //<< ; 23-May-2006   RPW     SR14662: If we are about to run something locally, check if the
    //<< ;                       method is marked do not run locally.
    //<< ; ??-May-2006   JW      SR14615: Define local location details
    //<< ; 21-Feb-2005   RobertW SR11273: tcommit needs the $tlevel check, not the trollback
    //<< ; 05-Jan-2005   GRF     SR11415 : Use Macros
    //<< ;-------------------------------------------------------------------------------
    //<< new %d,%eventFields,%i,%j,code,company,condition,conditionallyRun,currStatus
    mVar code = m$.var("code");
    mVar company = m$.var("company");
    mVar condition = m$.var("condition");
    mVar conditionallyRun = m$.var("conditionallyRun");
    mVar currStatus = m$.var("currStatus");
    m$.newVar(code,company,condition,conditionallyRun,currStatus);
    //<< new errorMsg,eventLocationUC,eventName,eventRule,eventUC,fieldName,hubLocation
    mVar errorMsg = m$.var("errorMsg");
    mVar eventLocationUC = m$.var("eventLocationUC");
    mVar eventName = m$.var("eventName");
    mVar eventRule = m$.var("eventRule");
    mVar eventUC = m$.var("eventUC");
    mVar fieldName = m$.var("fieldName");
    mVar hubLocation = m$.var("hubLocation");
    m$.newVar(errorMsg,eventLocationUC,eventName,eventRule,eventUC,fieldName,hubLocation);
    //<< new locations,MethodList,methodName,methodRule,methodUC,precedence,remoteLocation
    mVar locations = m$.var("locations");
    mVar MethodList = m$.var("MethodList");
    mVar methodName = m$.var("methodName");
    mVar methodRule = m$.var("methodRule");
    mVar methodUC = m$.var("methodUC");
    mVar precedence = m$.var("precedence");
    mVar remoteLocation = m$.var("remoteLocation");
    m$.newVar(locations,MethodList,methodName,methodRule,methodUC,precedence,remoteLocation);
    //<< new requestTimeout,savedYM,savedTlevel,saveTime,spokeLocation,status,strTarget
    mVar requestTimeout = m$.var("requestTimeout");
    mVar savedYM = m$.var("savedYM");
    mVar savedTlevel = m$.var("savedTlevel");
    mVar saveTime = m$.var("saveTime");
    mVar spokeLocation = m$.var("spokeLocation");
    mVar status = m$.var("status");
    mVar strTarget = m$.var("strTarget");
    m$.newVar(requestTimeout,savedYM,savedTlevel,saveTime,spokeLocation,status,strTarget);
    //<< new target,targettingFunction,targetList,targetsSkipped,txtlist,validLoc
    mVar target = m$.var("target");
    mVar targettingFunction = m$.var("targettingFunction");
    mVar targetList = m$.var("targetList");
    mVar targetsSkipped = m$.var("targetsSkipped");
    mVar txtlist = m$.var("txtlist");
    mVar validLoc = m$.var("validLoc");
    m$.newVar(target,targettingFunction,targetList,targetsSkipped,txtlist,validLoc);
    //<< 
    //<< set $ZTRAP="performEventErr"
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("performEventErr");
    //<< 
    //<< set eventName       = ""
    eventName.set("");
    //<< set methodName      = ""
    methodName.set("");
    //<< set errorMsg        = "Com00021"
    errorMsg.set("Com00021");
    //<< set status          = $$$YES
    status.set(include.COMSYS.$$$YES(m$));
    //<< ;set eventLocationUC = $select(pidxEventLocation="":$$^WWWUMLAU(eventLocationID,1),1:pidxEventLocation)
    //<< 
    //<< if (eventOnQueue) {
    if (mOp.Logical((eventOnQueue.get()))) {
      //<< set %d=$get(^COMDCMEventsQueue(0,recordNo,1))
      m$.var("%d").set(m$.Fnc.$get(m$.var("^COMDCMEventsQueue",0,recordNo.get(),1)));
    }
    //<< } else {
    else {
      //<< set %d=$get(^mtemp("COMDCMEvent",recordNo,1))
      m$.var("%d").set(m$.Fnc.$get(m$.var("^mtemp","COMDCMEvent",recordNo.get(),1)));
    }
    //<< }
    //<< set eventName     = $$$COMDCMEventsQueueEventName(%d)
    eventName.set(include.COMConst.$$$COMDCMEventsQueueEventName(m$,m$.var("%d")));
    //<< set company       = $$$COMDCMEventsQueueCompany1(%d)
    company.set(include.COMConst.$$$COMDCMEventsQueueCompany1(m$,m$.var("%d")));
    //<< set eventComplete = 1           ; default to Complete
    eventComplete.set(1);
    //<< 
    //<< set savedYM=YM
    savedYM.set(m$.var("YM").get());
    //<< set YM=company
    mVar YM = m$.var("YM");
    YM.set(company.get());
    //<< set %("%KEY","YM")=YM
    m$.var("%","%KEY","YM").set(YM.get());
    //<< 
    //<< if $get(eventLocationID)="" {               //SR14615
    if (mOp.Equal(m$.Fnc.$get(eventLocationID),"")) {
      //<< ; Check the event location (uses YM)
      //<< set eventLocationID=$$getCurrentLocation^COMDCMUtilities()
      eventLocationID.set(m$.fnc$("COMDCMUtilities.getCurrentLocation"));
      //<< if (eventLocationID="") || ('$data(^COMDCMLocation(0,eventLocationID,1))) {
      if ((mOp.Equal(eventLocationID.get(),"")) || (mOp.Not(m$.Fnc.$data(m$.var("^COMDCMLocation",0,eventLocationID.get(),1))))) {
        //<< quit 0_Y_$$^WWWTEXT("Com00015")      ; "Local location details have not been defined"
        return mOp.Concat(mOp.Concat(0,m$.var("Y").get()),m$.fnc$("WWWTEXT.main","Com00015"));
      }
      //<< }
      //<< set pidxEventLocation=$$$Index(eventLocationID)
      pidxEventLocation.set(include.MEDConst.$$$Index(m$,eventLocationID));
    }
    //<< }
    //<< set eventLocationUC = pidxEventLocation
    eventLocationUC.set(pidxEventLocation.get());
    //<< 
    //<< ; Have determined the eventName from the next item on the queue
    //<< ;  - Find every event rule that matches the eventName
    //<< ;  - Get precedence order for event rule (not used; could be
    //<< ;    different for separate methodRules)
    //<< ;  - Find all methods against eventName that match the methodRule
    //<< ;    - Add to list for use in next block
    //<< 
    //<< ;---------------------------------------
    //<< ; FIXME : <GRF> See references in block below
    //<< ;
    //<< ; Note 1
    //<< ;       Index 1 is (P1,P2,Precedence,P3)
    //<< ;       This code gets the precedence but never uses it.
    //<< ;
    //<< ;   ?   Should use next level to get methodRule in priority order, instead goes
    //<< ;       through them alphabetically - repeating all methodRules for each
    //<< ;       precedence level. (currently only using precedence=1 so repetition is
    //<< ;       not a practical issue)
    //<< ;
    //<< ;       May be more appropriate to have precedence *BEFORE* the event rule so
    //<< ;       that a specific event/method pairing can be given a higher priority
    //<< ;       instead of the eventRules all being accessed in alphabetical order when
    //<< ;       building MethodList.
    //<< ;
    //<< ; Note 2 May want to have specific override general reference
    //<< ;       e.g. INCALLSave/INCALLSave and INCALL*/INCALL*
    //<< ;       At present have to enter all explicitly rather than use overlapping wildcards.
    //<< ;---------------------------------------
    //<< kill MethodList
    MethodList.kill();
    //<< 
    //<< set %i=1
    m$.var("%i").set(1);
    //<< set eventRule=""
    eventRule.set("");
    //<< for {
    for (;true;) {
      //<< set eventRule=$order(^COMDCMLocEvent(0,eventLocationID,eventRule))
      eventRule.set(m$.Fnc.$order(m$.var("^COMDCMLocEvent",0,eventLocationID.get(),eventRule.get())));
      //<< quit:(eventRule="")
      if ((mOp.Equal(eventRule.get(),""))) {
        break;
      }
      //<< continue:('$$checkPatternMatch^COMUtils(eventRule,eventName))
      if ((mOp.Not(m$.fnc$("COMUtils.checkPatternMatch",eventRule.get(),eventName.get())))) {
        continue;
      }
      //<< 
      //<< set eventUC=$$$Index(eventRule) // SR14220
      eventUC.set(include.MEDConst.$$$Index(m$,eventRule));
      //<< set precedence=""
      precedence.set("");
      //<< for   {
      for (;true;) {
        //<< set precedence=$order(^COMDCMLocEvents(0,1,eventLocationUC,eventUC,precedence))
        precedence.set(m$.Fnc.$order(m$.var("^COMDCMLocEvents",0,1,eventLocationUC.get(),eventUC.get(),precedence.get())));
        //<< quit:(precedence="")      ; FIXME : see note 1 above
        if ((mOp.Equal(precedence.get(),""))) {
          break;
        }
        //<< 
        //<< set methodRule=""
        methodRule.set("");
        //<< for   {
        for (;true;) {
          //<< set methodRule=$order(^COMDCMLocEvent(0,eventLocationID,eventRule,methodRule))
          methodRule.set(m$.Fnc.$order(m$.var("^COMDCMLocEvent",0,eventLocationID.get(),eventRule.get(),methodRule.get())));
          //<< quit:(methodRule="")
          if ((mOp.Equal(methodRule.get(),""))) {
            break;
          }
          //<< 
          //<< set methodName=""
          methodName.set("");
          //<< for {
          for (;true;) {
            //<< set methodName=$order(^COMDCMMethod(0,eventName,methodName))  ; for single eventName
            methodName.set(m$.Fnc.$order(m$.var("^COMDCMMethod",0,eventName.get(),methodName.get())));
            //<< quit:(methodName="")
            if ((mOp.Equal(methodName.get(),""))) {
              break;
            }
            //<< continue:('$$checkPatternMatch^COMUtils(methodRule,methodName))
            if ((mOp.Not(m$.fnc$("COMUtils.checkPatternMatch",methodRule.get(),methodName.get())))) {
              continue;
            }
            //<< //  continue:'$$checkInterestedMethod(eventName,methodName,%recordKeys,%recordData)
            //<< 
            //<< ; Check to see if method already identified - if so override ;  FIXME : see note 2 above
            //<< for %j=1:1:%i {
            for (m$.var("%j").set(1);(mOp.LessOrEqual(m$.var("%j").get(),m$.var("%i").get()));m$.var("%j").set(mOp.Add(m$.var("%j").get(),1))) {
              //<< quit:($get(MethodList(%j,1))=methodName)
              if ((mOp.Equal(m$.Fnc.$get(MethodList.var(m$.var("%j").get(),1)),methodName.get()))) {
                break;
              }
            }
            //<< }
            //<< 
            //<< set MethodList(%j,1)=methodName
            MethodList.var(m$.var("%j").get(),1).set(methodName.get());
            //<< set MethodList(%j,2)=$get(^COMDCMLocEvent(0,eventLocationID,eventRule,methodRule,1))
            MethodList.var(m$.var("%j").get(),2).set(m$.Fnc.$get(m$.var("^COMDCMLocEvent",0,eventLocationID.get(),eventRule.get(),methodRule.get(),1)));
            //<< set %i=%i+1
            m$.var("%i").set(mOp.Add(m$.var("%i").get(),1));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< ; ************************************** MethodList Loop vvv
    //<< ; For each entry in MethodList
    //<< ; e.g. MethodList(#,1) = "INCALLSave"      MethodList(#,2) = "1~~~Spokes"
    //<< ;
    //<< ; Get targetList from previous run if it exists, otherwise
    //<< ;
    //<< ; 1) Store the data attributes from ^COMDCMEventsQueueData in %eventFields
    //<< ;    for use as parameters in condition and targettingFunction
    //<< ;
    //<< ; 2) if D2 conditionallyRun then use D3 condition to build boolean targetsSkipped
    //<< ;    e.g. $$CanTransfer^COMDCMLanguage(  $get(%eventFields(´Global´)),
    //<< ;                                        $get(%eventFields(´Key´)),
    //<< ;                                        $get(%eventFields(´Data´))    )
    //<< ;
    //<< ; 3) if targetsSkipped is $$$YES, note the fact and go to next method, otherwise
    //<< ;
    //<< ; 4) if D4 target =
    //<< ;  "Self"     then targetList = this location
    //<< ;  "Hub"      then targetList = this location's hub
    //<< ;  "Spokes"   then targetList = all locations with this location as the hub
    //<< ;  "Function" then use D5 targettingFunction e.g. %eventFields(´DestSite´)
    //<< ;                  to get targetList from location string
    //<< ; **************************************
    //<< for %i=1:1 {
    for (m$.var("%i").set(1);(true);m$.var("%i").set(mOp.Add(m$.var("%i").get(),1))) {
      //<< set methodName=$get(MethodList(%i,1))
      methodName.set(m$.Fnc.$get(MethodList.var(m$.var("%i").get(),1)));
      //<< quit:methodName=""
      if (mOp.Equal(methodName.get(),"")) {
        break;
      }
      //<< 
      //<< ; establish targetting for this method
      //<< 
      //<< set %d=$get(MethodList(%i,2))
      m$.var("%d").set(m$.Fnc.$get(MethodList.var(m$.var("%i").get(),2)));
      //<< set conditionallyRun   = $$$COMDCMLocEventConditionallyRun(%d)
      conditionallyRun.set(include.COMConst.$$$COMDCMLocEventConditionallyRun(m$,m$.var("%d")));
      //<< set condition          = $$$COMDCMLocEventCondition(%d)
      condition.set(include.COMConst.$$$COMDCMLocEventCondition(m$,m$.var("%d")));
      //<< set target             = $$$COMDCMLocEventTarget(%d)
      target.set(include.COMConst.$$$COMDCMLocEventTarget(m$,m$.var("%d")));
      //<< set targettingFunction = $$$COMDCMLocEventTargetFunction(%d)
      targettingFunction.set(include.COMConst.$$$COMDCMLocEventTargetFunction(m$,m$.var("%d")));
      //<< set targettingFunction = $translate(targettingFunction,$$$ACUTE,$$$DBLQUOTE)    ; get the quotes back
      targettingFunction.set(m$.Fnc.$translate(targettingFunction.get(),include.COMSYSString.$$$ACUTE(m$),include.COMSYSString.$$$DBLQUOTE(m$)));
      //<< set requestTimeout     = $$$COMDCMLocEventRequestTimeout(%d)
      requestTimeout.set(include.COMConst.$$$COMDCMLocEventRequestTimeout(m$,m$.var("%d")));
      //<< set targetsSkipped     = $$$NO                                      ; 12-Jun-2008
      targetsSkipped.set(include.COMSYS.$$$NO(m$));
      //<< 
      //<< kill ^COMDCMEventsProcessedTarget(0,recordNo,methodName,"*NONE*",1) ; cleanup any past error messages
      m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get(),"*NONE*",1).kill();
      //<< 
      //<< kill targetList
      targetList.kill();
      //<< merge targetList=^COMDCMEventsProcessedTarget(0,recordNo,methodName)
      m$.Cmd.Merge(targetList,m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get()));
      //<< 
      //<< ; ********************************** New targetList vvv
      //<< if ($order(targetList(""))="") {
      if ((mOp.Equal(m$.Fnc.$order(targetList.var("")),""))) {
        //<< ; Establish the target list from scratch
        //<< 
        //<< ; Setup Event field values for foreign routines
        //<< kill %eventFields
        m$.var("%eventFields").kill();
        //<< set fieldName=""
        fieldName.set("");
        //<< if (eventOnQueue) {
        if (mOp.Logical((eventOnQueue.get()))) {
          //<< for   {
          for (;true;) {
            //<< set fieldName=$order(^COMDCMEventsQueueData(0,recordNo,fieldName))
            fieldName.set(m$.Fnc.$order(m$.var("^COMDCMEventsQueueData",0,recordNo.get(),fieldName.get())));
            //<< quit:(fieldName="")
            if ((mOp.Equal(fieldName.get(),""))) {
              break;
            }
            //<< 
            //<< set %eventFields(fieldName)=$get(^COMDCMEventsQueueData(0,recordNo,fieldName,1))
            m$.var("%eventFields",fieldName.get()).set(m$.Fnc.$get(m$.var("^COMDCMEventsQueueData",0,recordNo.get(),fieldName.get(),1)));
          }
          //<< }
          //<< for   {
          for (;true;) {
            //<< set fieldName=$order(^mtemp("COMDCMEventData",recordNo,fieldName))
            fieldName.set(m$.Fnc.$order(m$.var("^mtemp","COMDCMEventData",recordNo.get(),fieldName.get())));
            //<< quit:(fieldName="")
            if ((mOp.Equal(fieldName.get(),""))) {
              break;
            }
            //<< 
            //<< set %eventFields(fieldName)=$get(^mtemp("COMDCMEventData",recordNo,fieldName,1))
            m$.var("%eventFields",fieldName.get()).set(m$.Fnc.$get(m$.var("^mtemp","COMDCMEventData",recordNo.get(),fieldName.get(),1)));
          }
        }
        //<< }
        //<< }
        //<< /*   ; SR15787
        //<< for   {
        //<< if (eventOnQueue) {
        //<< set fieldName=$order(^COMDCMEventsQueueData(0,recordNo,fieldName))
        //<< } else {
        //<< set fieldName=$order(^mtemp("COMDCMEventData",recordNo,fieldName))
        //<< }
        //<< quit:(fieldName="")
        //<< 
        //<< if (eventOnQueue) {
        //<< set %eventFields(fieldName)=$get(^COMDCMEventsQueueData(0,recordNo,fieldName,1))
        //<< } else {
        //<< set %eventFields(fieldName)=$get(^mtemp("COMDCMEventData",recordNo,fieldName,1))
        //<< }
        //<< }
        //<< 
        //<< */
        //<< ;merge %eventFields=^COMDCMEventsQueueDataComplex(0,recordNo)
        //<< 
        //<< if (conditionallyRun) {
        if (mOp.Logical((conditionallyRun.get()))) {
          //<< ; only run the method if the condition evaluates true
          //<< set errorMsg="Com00025"
          errorMsg.set("Com00025");
          //<< ;   "Conditional Routine Error for event (%2) and method (%3): %1"
          //<< 
          //<< set code=$translate(condition,$$$ACUTE,$$$DBLQUOTE) ; get the quotes back
          code.set(m$.Fnc.$translate(condition.get(),include.COMSYSString.$$$ACUTE(m$),include.COMSYSString.$$$DBLQUOTE(m$)));
          //<< set code="s targetsSkipped='("_code_")"
          code.set(mOp.Concat(mOp.Concat("s targetsSkipped='(",code.get()),")"));
          //<< set savedTlevel=$tlevel
          savedTlevel.set(m$.Fnc.$tlevel());
          //<< do:DEBUG LogDebugMessage^COMDCMUtilities("Conditonal Execution code",code)
          if (mOp.Logical(DEBUG.get())) {
            m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","Conditonal Execution code",code.get());
          }
          //<< 
          //<< xecute code               ; returns boolean
          m$.Cmd.Xecute(code.get());
          //<< 
          //<< do:DEBUG LogDebugMessage^COMDCMUtilities("Returned",targetsSkipped)
          if (mOp.Logical(DEBUG.get())) {
            m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","Returned",targetsSkipped.get());
          }
          //<< set errorMsg="Com00021"
          errorMsg.set("Com00021");
          //<< ;   "Event Queue Processing Error for event (%2) and method (%3): %1"
          //<< 
          //<< if (savedTlevel'=$tlevel) {
          if ((mOp.NotEqual(savedTlevel.get(),m$.Fnc.$tlevel()))) {
            //<< ; Called routine has changed TLEVEL
            //<< ;+++++++++++++++++++++++++++++++++++++++
            //<< trollback
            //<< ;+++++++++++++++++++++++++++++++++++++++
            //<< ;   set txtlist=$listbuild("Com00037",code,targetsSkipped)
            //<< set txtlist=$listbuild("Com00037",code,targetsSkipped_" (Ref:37022)")  ; SR15546
            txtlist.set(m$.Fnc.$listbuild("Com00037",code.get(),mOp.Concat(targetsSkipped.get()," (Ref:37022)")));
            //<< set %d=""
            m$.var("%d").set("");
            //<< set $$$COMDCMEventsProcessedTargetProcDateTime(%d) = $horolog
            include.COMConst.$$$COMDCMEventsProcessedTargetProcDateTimeSet(m$,m$.var("%d"),m$.Fnc.$horolog());
            //<< set $$$COMDCMEventsProcessedTargetProcStatus(%d)   = 0
            include.COMConst.$$$COMDCMEventsProcessedTargetProcStatusSet(m$,m$.var("%d"),0);
            //<< set $$$COMDCMEventsProcessedTargetMessage1(%d)     = $$DecodeError^COMUtilError(txtlist)   ; transaction level not maintained
            include.COMConst.$$$COMDCMEventsProcessedTargetMessage1Set(m$,m$.var("%d"),m$.fnc$("COMUtilError.DecodeError",txtlist.get()));
            //<< set ^COMDCMEventsProcessedTarget(0,recordNo,methodName,"*NONE*",1)=%d
            m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get(),"*NONE*",1).set(m$.var("%d").get());
            //<< set eventComplete=$$highestStatus(eventComplete,0)
            eventComplete.set(m$.fnc$("highestStatus",eventComplete.get(),0));
            //<< quit             ; skip any remaining methods
            break;
          }
          //<< }
          //<< 
          //<< 
          //<< ;---------------------------
          //<< 
          //<< if (targetsSkipped) {
          if (mOp.Logical((targetsSkipped.get()))) {
            //<< set %d=""
            m$.var("%d").set("");
            //<< set $$$COMDCMEventsProcessedTargetProcDateTime(%d) = $horolog
            include.COMConst.$$$COMDCMEventsProcessedTargetProcDateTimeSet(m$,m$.var("%d"),m$.Fnc.$horolog());
            //<< set $$$COMDCMEventsProcessedTargetProcStatus(%d)   = 2
            include.COMConst.$$$COMDCMEventsProcessedTargetProcStatusSet(m$,m$.var("%d"),2);
            //<< set $$$COMDCMEventsProcessedTargetMessage1(%d)     = $$^WWWTEXT("Com00023")   ; "Event skipped as a result of method conditional processing"
            include.COMConst.$$$COMDCMEventsProcessedTargetMessage1Set(m$,m$.var("%d"),m$.fnc$("WWWTEXT.main","Com00023"));
            //<< set ^COMDCMEventsProcessedTarget(0,recordNo,methodName,"*ALL*",1)=%d
            m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get(),"*ALL*",1).set(m$.var("%d").get());
            //<< set eventComplete=$$highestStatus(eventComplete,2)
            eventComplete.set(m$.fnc$("highestStatus",eventComplete.get(),2));
            //<< continue ;      skip the rest of this method
            continue;
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if (target="Self") {
        if ((mOp.Equal(target.get(),"Self"))) {
          //<< set targetList(eventLocationID,1)=""
          targetList.var(eventLocationID.get(),1).set("");
        }
        //<< 
        //<< } elseif (target="Hub") {
        else if ((mOp.Equal(target.get(),"Hub"))) {
          //<< set hubLocation=$$$COMDCMLocationHubLocId($GET(^COMDCMLocation(0,eventLocationID,1)))
          hubLocation.set(include.COMConst.$$$COMDCMLocationHubLocId(m$,m$.Fnc.$get(m$.var("^COMDCMLocation",0,eventLocationID.get(),1))));
          //<< if (hubLocation'="") {
          if ((mOp.NotEqual(hubLocation.get(),""))) {
            //<< set targetList(hubLocation,1)=""
            targetList.var(hubLocation.get(),1).set("");
          }
        }
        //<< }
        //<< 
        //<< } elseif (target="Spokes") {
        else if ((mOp.Equal(target.get(),"Spokes"))) {
          //<< set spokeLocation=""
          spokeLocation.set("");
          //<< for   {
          for (;true;) {
            //<< set spokeLocation=$order(^COMDCMLocations(0,1,eventLocationUC,spokeLocation))
            spokeLocation.set(m$.Fnc.$order(m$.var("^COMDCMLocations",0,1,eventLocationUC.get(),spokeLocation.get())));
            //<< quit:spokeLocation=""
            if (mOp.Equal(spokeLocation.get(),"")) {
              break;
            }
            //<< 
            //<< set targetList(spokeLocation,1)=""
            targetList.var(spokeLocation.get(),1).set("");
          }
        }
        //<< }
        //<< 
        //<< } elseif (target="Function") {
        else if ((mOp.Equal(target.get(),"Function"))) {
          //<< set errorMsg="Com00026"
          errorMsg.set("Com00026");
          //<< ;   "Targeting Routine Error for event (%2) and method (%3): %1"
          //<< /*
          //<< set savedYM=YM
          //<< set YM=company
          //<< set %("%KEY","YM")=YM
          //<< */
          //<< set locations=""
          locations.set("");
          //<< set code="s locations="_targettingFunction
          code.set(mOp.Concat("s locations=",targettingFunction.get()));
          //<< set savedTlevel=$tlevel
          savedTlevel.set(m$.Fnc.$tlevel());
          //<< do:DEBUG LogDebugMessage^COMDCMUtilities("Targetting Function code",code)
          if (mOp.Logical(DEBUG.get())) {
            m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","Targetting Function code",code.get());
          }
          //<< 
          //<< xecute code    ; function must return a comma separated list of locations
          m$.Cmd.Xecute(code.get());
          //<< 
          //<< do:DEBUG LogDebugMessage^COMDCMUtilities("Returned",locations)
          if (mOp.Logical(DEBUG.get())) {
            m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","Returned",locations.get());
          }
          //<< set errorMsg="Com00021"
          errorMsg.set("Com00021");
          //<< ;   "Event Queue Processing Error for event (%2) and method (%3): %1"
          //<< /*
          //<< set YM=savedYM
          //<< set %("%KEY","YM")=YM
          //<< */
          //<< if (savedTlevel'=$tlevel) {
          if ((mOp.NotEqual(savedTlevel.get(),m$.Fnc.$tlevel()))) {
            //<< ; Called routine has changed TLEVEL
            //<< ;+++++++++++++++++++++++++++++++++++++++
            //<< trollback
            //<< ;+++++++++++++++++++++++++++++++++++++++
            //<< ;   set txtlist=$listbuild("Com00037",code,locations)
            //<< set txtlist=$listbuild("Com00037",code,locations_" (Ref:37023)")  ; SR15546
            txtlist.set(m$.Fnc.$listbuild("Com00037",code.get(),mOp.Concat(locations.get()," (Ref:37023)")));
            //<< set %d=""
            m$.var("%d").set("");
            //<< set $$$COMDCMEventsProcessedTargetProcDateTime(%d) = $horolog
            include.COMConst.$$$COMDCMEventsProcessedTargetProcDateTimeSet(m$,m$.var("%d"),m$.Fnc.$horolog());
            //<< set $$$COMDCMEventsProcessedTargetProcStatus(%d)   = 0
            include.COMConst.$$$COMDCMEventsProcessedTargetProcStatusSet(m$,m$.var("%d"),0);
            //<< set $$$COMDCMEventsProcessedTargetMessage1(%d)     = $$DecodeError^COMUtilError(txtlist)   ; transaction level not maintained
            include.COMConst.$$$COMDCMEventsProcessedTargetMessage1Set(m$,m$.var("%d"),m$.fnc$("COMUtilError.DecodeError",txtlist.get()));
            //<< set ^COMDCMEventsProcessedTarget(0,recordNo,methodName,"*NONE*",1)=%d
            m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get(),"*NONE*",1).set(m$.var("%d").get());
            //<< set eventComplete=$$highestStatus(eventComplete,0)
            eventComplete.set(m$.fnc$("highestStatus",eventComplete.get(),0));
            //<< quit ;      skip any remaining methods
            break;
          }
          //<< }
          //<< 
          //<< if (locations="") {
          if ((mOp.Equal(locations.get(),""))) {
            //<< set %d=""
            m$.var("%d").set("");
            //<< set $$$COMDCMEventsProcessedTargetProcDateTime(%d) = $horolog
            include.COMConst.$$$COMDCMEventsProcessedTargetProcDateTimeSet(m$,m$.var("%d"),m$.Fnc.$horolog());
            //<< set $$$COMDCMEventsProcessedTargetProcStatus(%d)   = 2
            include.COMConst.$$$COMDCMEventsProcessedTargetProcStatusSet(m$,m$.var("%d"),2);
            //<< set $$$COMDCMEventsProcessedTargetMessage1(%d)     = $$^WWWTEXT("Com00070")   ; set the skipped status
            include.COMConst.$$$COMDCMEventsProcessedTargetMessage1Set(m$,m$.var("%d"),m$.fnc$("WWWTEXT.main","Com00070"));
            //<< ;   "Event skipped as a result of targets not identified"
            //<< set ^COMDCMEventsProcessedTarget(0,recordNo,methodName,"*ALL*",1)=%d
            m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get(),"*ALL*",1).set(m$.var("%d").get());
            //<< set eventComplete=$$highestStatus(eventComplete,2)
            eventComplete.set(m$.fnc$("highestStatus",eventComplete.get(),2));
            //<< continue ;      skip the rest of this method
            continue;
          }
          //<< }
          //<< 
          //<< for   {
          for (;true;) {
            //<< set remoteLocation=$piece($get(locations),",")
            remoteLocation.set(m$.Fnc.$piece(m$.Fnc.$get(locations),","));
            //<< quit:remoteLocation=""
            if (mOp.Equal(remoteLocation.get(),"")) {
              break;
            }
            //<< 
            //<< set targetList(remoteLocation,1)=""
            targetList.var(remoteLocation.get(),1).set("");
            //<< set locations=$piece(locations,",",2,999)
            locations.set(m$.Fnc.$piece(locations.get(),",",2,999));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< ; check the target list to ensure all locations exist
        //<< set validLoc=0
        validLoc.set(0);
        //<< set target=""
        target.set("");
        //<< for   {
        for (;true;) {
          //<< set target=$order(targetList(target))
          target.set(m$.Fnc.$order(targetList.var(target.get())));
          //<< quit:target=""
          if (mOp.Equal(target.get(),"")) {
            break;
          }
          //<< if ('$data(^COMDCMLocation(0,target,1))) {
          if ((mOp.Not(m$.Fnc.$data(m$.var("^COMDCMLocation",0,target.get(),1))))) {
            //<< set validLoc=0
            validLoc.set(0);
            //<< quit
            break;
          }
          //<< }
          //<< 
          //<< set validLoc=validLoc+1
          validLoc.set(mOp.Add(validLoc.get(),1));
        }
        //<< }
        //<< if ('validLoc) {
        if ((mOp.Not(validLoc.get()))) {
          //<< set txtlist=$listbuild("Com00024",target)
          txtlist.set(m$.Fnc.$listbuild("Com00024",target.get()));
          //<< set %d=""
          m$.var("%d").set("");
          //<< set $$$COMDCMEventsProcessedTargetProcDateTime(%d) = $horolog
          include.COMConst.$$$COMDCMEventsProcessedTargetProcDateTimeSet(m$,m$.var("%d"),m$.Fnc.$horolog());
          //<< set $$$COMDCMEventsProcessedTargetProcStatus(%d)   = 0
          include.COMConst.$$$COMDCMEventsProcessedTargetProcStatusSet(m$,m$.var("%d"),0);
          //<< set $$$COMDCMEventsProcessedTargetMessage1(%d)     = $$DecodeError^COMUtilError(txtlist)   ; error with a target location
          include.COMConst.$$$COMDCMEventsProcessedTargetMessage1Set(m$,m$.var("%d"),m$.fnc$("COMUtilError.DecodeError",txtlist.get()));
          //<< set ^COMDCMEventsProcessedTarget(0,recordNo,methodName,"*NONE*",1)=%d
          m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get(),"*NONE*",1).set(m$.var("%d").get());
          //<< set eventComplete=$$highestStatus(eventComplete,0)
          eventComplete.set(m$.fnc$("highestStatus",eventComplete.get(),0));
          //<< quit ;      skip any remaining methods
          break;
        }
        //<< }
        //<< 
        //<< ; save the target list in case we get stopped half way
        //<< merge ^COMDCMEventsProcessedTarget(0,recordNo,methodName)=targetList
        m$.Cmd.Merge(m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get()),targetList);
      }
      //<< }
      //<< ; ********************************** New targetList ^^^
      //<< 
      //<< 
      //<< 
      //<< 
      //<< ; ********************************** Process targetList vvv
      //<< set target=""
      target.set("");
      //<< for   {
      for (;true;) {
        //<< set target=$order(targetList(target))
        target.set(m$.Fnc.$order(targetList.var(target.get())));
        //<< quit:target=""
        if (mOp.Equal(target.get(),"")) {
          break;
        }
        //<< 
        //<< set currStatus=$$$COMDCMEventsProcessedTargetProcStatus($get(^COMDCMEventsProcessedTarget(0,recordNo,methodName,target,1)))
        currStatus.set(include.COMConst.$$$COMDCMEventsProcessedTargetProcStatus(m$,m$.Fnc.$get(m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get(),target.get(),1))));
        //<< if ('$data(blockedTarget(target))) {                     ; This target is available
        if ((mOp.Not(m$.Fnc.$data(blockedTarget.var(target.get()))))) {
          //<< if (currStatus'=1) && (currStatus'=2) {              ; and has not yet been correctly processed
          if ((mOp.NotEqual(currStatus.get(),1)) && (mOp.NotEqual(currStatus.get(),2))) {
            //<< set saveTime=$zhorolog
            saveTime.set(m$.Fnc.$zhorolog());
            //<< if (target=eventLocationID) {                    ; "Self"
            if ((mOp.Equal(target.get(),eventLocationID.get()))) {
              //<< if '$$$COMDCMMethodDoNotExecuteLocally($get(^COMDCMMethod(0,eventName,methodName,1))) { // SR14662
              if (mOp.Not(include.COMConst.$$$COMDCMMethodDoNotExecuteLocally(m$,m$.Fnc.$get(m$.var("^COMDCMMethod",0,eventName.get(),methodName.get(),1))))) {
                //<< set status=$$localMethod^COMDCMRunMethod(company,eventName,methodName,recordNo,eventOnQueue,DEBUG)
                status.set(m$.fnc$("COMDCMRunMethod.localMethod",company.get(),eventName.get(),methodName.get(),recordNo.get(),eventOnQueue.get(),DEBUG.get()));
              }
              //<< } else {
              else {
                //<< set status=$$$OK
                status.set(include.COMSYS.$$$OK(m$));
              }
            }
            //<< }
            //<< } else {
            else {
              //<< set status=$$remoteMethod^COMDCMRunMethod(.httpRequest,target,company,eventName,methodName,recordNo,requestTimeout,eventOnQueue,DEBUG)
              status.set(m$.fnc$("COMDCMRunMethod.remoteMethod",httpRequest,target.get(),company.get(),eventName.get(),methodName.get(),recordNo.get(),requestTimeout.get(),eventOnQueue.get(),DEBUG.get()));
            }
            //<< }
            //<< 
            //<< set %d=""
            m$.var("%d").set("");
            //<< set $$$COMDCMEventsProcessedTargetProcDateTime(%d)= $horolog
            include.COMConst.$$$COMDCMEventsProcessedTargetProcDateTimeSet(m$,m$.var("%d"),m$.Fnc.$horolog());
            //<< set $$$COMDCMEventsProcessedTargetProcStatus(%d)  = $piece(status,Y,1)
            include.COMConst.$$$COMDCMEventsProcessedTargetProcStatusSet(m$,m$.var("%d"),m$.Fnc.$piece(status.get(),m$.var("Y").get(),1));
            //<< set $$$COMDCMEventsProcessedTargetMessage1(%d)    = $piece(status,Y,2)
            include.COMConst.$$$COMDCMEventsProcessedTargetMessage1Set(m$,m$.var("%d"),m$.Fnc.$piece(status.get(),m$.var("Y").get(),2));
            //<< set $$$COMDCMEventsProcessedTargetDuration(%d)    = $zhorolog-saveTime
            include.COMConst.$$$COMDCMEventsProcessedTargetDurationSet(m$,m$.var("%d"),mOp.Subtract(m$.Fnc.$zhorolog(),saveTime.get()));
            //<< set ^COMDCMEventsProcessedTarget(0,recordNo,methodName,target,1)=%d
            m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get(),target.get(),1).set(m$.var("%d").get());
            //<< 
            //<< set eventComplete=$$highestStatus(eventComplete,$piece(status,Y,1))
            eventComplete.set(m$.fnc$("highestStatus",eventComplete.get(),m$.Fnc.$piece(status.get(),m$.var("Y").get(),1)));
            //<< if '$piece(status,Y,1) {
            if (mOp.Not(m$.Fnc.$piece(status.get(),m$.var("Y").get(),1))) {
              //<< ; failed method blocks the target
              //<< set blockedTarget(target)=""
              blockedTarget.var(target.get()).set("");
              //<< do:DEBUG LogDebugMessage^COMDCMUtilities("Target blocked",target)
              if (mOp.Logical(DEBUG.get())) {
                m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","Target blocked",target.get());
              }
              //<< 
              //<< //  SR14987: Only send email once.
              //<< ; FIXME : <GRF> see SR15538
              //<< ;           ^COMDCMEventsProcessed is generated after pre-processing remaining messages
              //<< ;           on the event queue so if any of them have errors as well they will not have
              //<< ;           e-mails generated.
              //<< if '$data(^COMDCMEventsProcessed(0,recordNo,1)) {
              if (mOp.Not(m$.Fnc.$data(m$.var("^COMDCMEventsProcessed",0,recordNo.get(),1)))) {
                //<< ;   do NotifyAdmin^COMUtils("performEvent^COMDCMControlModule",status)   ; SR15787
                //<< do NotifyAdmin^COMUtils("performEvent^COMDCMControlModule for "_target,status)
                m$.Cmd.Do("COMUtils.NotifyAdmin",mOp.Concat("performEvent^COMDCMControlModule for ",target.get()),status.get());
              }
            }
          }
          //<< }
          //<< }
          //<< } else {
          else {
            //<< set eventComplete=$$highestStatus(eventComplete,currStatus)
            eventComplete.set(m$.fnc$("highestStatus",eventComplete.get(),currStatus.get()));
          }
        }
        //<< }
        //<< 
        //<< } else {      ; This target has been blocked - other targets will still be processed.
        else {
          //<< if (currStatus'=1) && (currStatus'=2) {
          if ((mOp.NotEqual(currStatus.get(),1)) && (mOp.NotEqual(currStatus.get(),2))) {
            //<< set eventComplete=$$highestStatus(eventComplete,3)
            eventComplete.set(m$.fnc$("highestStatus",eventComplete.get(),3));
            //<< set %d=""
            m$.var("%d").set("");
            //<< set $$$COMDCMEventsProcessedTargetProcDateTime(%d) = $horolog
            include.COMConst.$$$COMDCMEventsProcessedTargetProcDateTimeSet(m$,m$.var("%d"),m$.Fnc.$horolog());
            //<< set $$$COMDCMEventsProcessedTargetProcStatus(%d)   = 3
            include.COMConst.$$$COMDCMEventsProcessedTargetProcStatusSet(m$,m$.var("%d"),3);
            //<< set $$$COMDCMEventsProcessedTargetMessage1(%d)     = $$^WWWTEXT("Com00039")   ; set the blocked status
            include.COMConst.$$$COMDCMEventsProcessedTargetMessage1Set(m$,m$.var("%d"),m$.fnc$("WWWTEXT.main","Com00039"));
            //<< ;   "Message blocked due to prior transaction failure"
            //<< set ^COMDCMEventsProcessedTarget(0,recordNo,methodName,target,1)=%d
            m$.var("^COMDCMEventsProcessedTarget",0,recordNo.get(),methodName.get(),target.get(),1).set(m$.var("%d").get());
          }
          //<< } else {
          else {
            //<< set eventComplete=$$highestStatus(eventComplete,currStatus)
            eventComplete.set(m$.fnc$("highestStatus",eventComplete.get(),currStatus.get()));
          }
          //<< }
          //<< do:DEBUG LogDebugMessage^COMDCMUtilities("Target skipped due to block",target)
          if (mOp.Logical(DEBUG.get())) {
            m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","Target skipped due to block",target.get());
          }
        }
      }
    }
    //<< }
    //<< }
    //<< ; ********************************** Process targetList ^^^
    //<< 
    //<< ;if ('eventComplete)    quit ;      skip any remaining methods
    //<< }
    //<< ; ************************************** MethodList Loop ^^^
    //<< 
    //<< //SR14615
    //<< set YM=savedYM
    YM.set(savedYM.get());
    //<< set %("%KEY","YM")=YM
    m$.var("%","%KEY","YM").set(YM.get());
    //<< 
    //<< quit status
    return status.get();
  }

  //<< 
  //<< 
  //<< ///performEventErr  ; Internal Tag
  //<< performEventErr()   ; Internal Tag
  public Object performEventErr(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; History :
    //<< ; 20-Jun-2008   GRF     SR15787: include target in notification if available
    //<< ; 15-Mar-2005   Paul K  Added macro usage
    //<< ; 21-Feb-2005   RobertW SR11273: tcommit needs the $tlevel check, not the trollback
    //<< ; 05-Jan-2005   GRF     SR11415: Use Macros
    //<< ;-------------------------------------------------------------------------------
    //<< set $ZTRAP=""
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("");
    //<< set txtlist       = $listbuild(errorMsg,$ZERROR,eventName,methodName)
    mVar txtlist = m$.var("txtlist");
    txtlist.set(m$.Fnc.$listbuild(m$.var("errorMsg").get(),m$.Fnc.$zerror(),m$.var("eventName").get(),m$.var("methodName").get()));
    //<< set eventComplete = $$highestStatus(eventComplete,0)
    mVar eventComplete = m$.var("eventComplete");
    eventComplete.set(m$.fnc$("highestStatus",m$.var("eventComplete").get(),0));
    //<< set $ZERROR=""
    mVar $ZERROR = m$.var("$ZERROR");
    $ZERROR.set("");
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< trollback           ; just in case an external routine left us in a trans
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< set %d=""
    m$.var("%d").set("");
    //<< set $$$COMDCMEventsProcessedTargetProcDateTime(%d) = $horolog
    include.COMConst.$$$COMDCMEventsProcessedTargetProcDateTimeSet(m$,m$.var("%d"),m$.Fnc.$horolog());
    //<< set $$$COMDCMEventsProcessedTargetProcStatus(%d)   = $$$NO
    include.COMConst.$$$COMDCMEventsProcessedTargetProcStatusSet(m$,m$.var("%d"),include.COMSYS.$$$NO(m$));
    //<< set $$$COMDCMEventsProcessedTargetMessage1(%d)     = $$$Text(txtlist)
    include.COMConst.$$$COMDCMEventsProcessedTargetMessage1Set(m$,m$.var("%d"),include.COMSYS.$$$Text(m$,txtlist));
    //<< 
    //<< set ^COMDCMEventsProcessedTarget(0,recordNo,methodName,"*NONE*",1)=%d
    m$.var("^COMDCMEventsProcessedTarget",0,m$.var("recordNo").get(),m$.var("methodName").get(),"*NONE*",1).set(m$.var("%d").get());
    //<< do:DEBUG LogDebugMessage^COMDCMUtilities("performEventErr",$$$Text(txtlist))
    if (mOp.Logical(m$.var("DEBUG").get())) {
      m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","performEventErr",include.COMSYS.$$$Text(m$,txtlist));
    }
    //<< do NotifyAdmin^COMUtils("performEventErr^COMDCMControlModule",$$$Text(txtlist))
    m$.Cmd.Do("COMUtils.NotifyAdmin","performEventErr^COMDCMControlModule",include.COMSYS.$$$Text(m$,txtlist));
    //<< quit status
    return m$.var("status").get();
  }

  //<< 
  //<< 
  //<< highestStatus(current,proposed)
  public Object highestStatus(Object ... _p) {
    mVar current = m$.newVarRef("current",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar proposed = m$.newVarRef("proposed",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Routine to maintain the Status Precedence
    //<< ; 0 overrides 3 overrides 2 overrides 1 overrides current
    //<< ;-------------------------------------------------------------------------------
    //<< new status
    mVar status = m$.var("status");
    m$.newVar(status);
    //<< 
    //<< set status=current
    status.set(current.get());
    //<< ; NB these commands are applied in reverse priority order
    //<< if ((proposed=1) || (current=1)) set status=1       ; Everything OK
    if (mOp.Logical(((mOp.Equal(proposed.get(),1)) || (mOp.Equal(current.get(),1))))) {
      status.set(1);
    }
    //<< if ((proposed=2) || (current=2)) set status=2       ; Skipped
    if (mOp.Logical(((mOp.Equal(proposed.get(),2)) || (mOp.Equal(current.get(),2))))) {
      status.set(2);
    }
    //<< if ((proposed=3) || (current=3)) set status=3       ; Blocked
    if (mOp.Logical(((mOp.Equal(proposed.get(),3)) || (mOp.Equal(current.get(),3))))) {
      status.set(3);
    }
    //<< if ((proposed=0) || (current=0)) set status=0       ; Error occurred
    if (mOp.Logical(((mOp.Equal(proposed.get(),0)) || (mOp.Equal(current.get(),0))))) {
      status.set(0);
    }
    //<< 
    //<< quit status
    return status.get();
  }

//<< 
//<< 
}
