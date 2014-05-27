//*****************************************************************************
//** TASC - ALPHALINC - MAC COMLock
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:27
//*****************************************************************************

import mLibrary.*;

//<< /**************************************************
//<< * PLEASE BE CAREFUL IF CHANGING ANY CODE IN HERE *
//<< **************************************************/
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
import include.$occInclude;
//<< #include COMConst
import include.COMConst;

//<< COMLock
public class COMLock extends mClass {

  //<< 
  //<< #define GetLockId(%1,%2)        $order(^COMLocks(0,1,$$$Index(%1),$$$Index(%2),""))
  public static Object $$$GetLockId(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$order(m$.var("^COMLocks",0,1,include.MEDConst.$$$Index(m$,p$1),include.MEDConst.$$$Index(m$,p$2),"")));
  }

  //<< #define LockOK                  (enmStatus=$$$EnumCOMLOCKLockSuccessful)
  public static Object $$$LockOK(mContext m$) {
    return ((mOp.Equal(m$.var("enmStatus").get(),include.COMConst.$$$EnumCOMLOCKLockSuccessful(m$))));
  }

  //<< #define LockAvailable           (+$get(^CacheTempLock(pstrLocking,pstrLocked))=1)
  public static Object $$$LockAvailable(mContext m$) {
    return ((mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempLock",m$.var("pstrLocking").get(),m$.var("pstrLocked").get()))),1)));
  }

  //<< #define IncrementLock           set ^CacheTempLock(pstrLocking,pstrLocked)=$increment(^CacheTempLock(pstrLocking,pstrLocked)),blnLocked=$$$YES
  public static Object $$$IncrementLock(mContext m$) {
    m$.var("^CacheTempLock",m$.var("pstrLocking").get(),m$.var("pstrLocked").get()).set(m$.Fnc.$increment(m$.var("^CacheTempLock",m$.var("pstrLocking").get(),m$.var("pstrLocked").get())));
    mVar blnLocked = m$.var("blnLocked");
    blnLocked.set(include.COMSYS.$$$YES(m$));
    return null;
  }

  //<< #define DecrementLock           set ^CacheTempLock(pstrLocking,pstrLocked)=$increment(^CacheTempLock(pstrLocking,pstrLocked),-1),blnLocked=$$$NO
  public static Object $$$DecrementLock(mContext m$) {
    m$.var("^CacheTempLock",m$.var("pstrLocking").get(),m$.var("pstrLocked").get()).set(m$.Fnc.$increment(m$.var("^CacheTempLock",m$.var("pstrLocking").get(),m$.var("pstrLocked").get()),mOp.Negative(1)));
    mVar blnLocked = m$.var("blnLocked");
    blnLocked.set(include.COMSYS.$$$NO(m$));
    return null;
  }

  //<< #define Lock                    lock ^CacheTempLock(pstrLocking,pstrLocked):2
  public static Object $$$Lock(mContext m$) {
    m$.Cmd.Lock(m$.var("^CacheTempLock",m$.var("pstrLocking").get(),m$.var("pstrLocked").get()),2);
    return null;
  }

  //<< #define UnLock                  lock -^CacheTempLock(pstrLocking,pstrLocked)#"I"
  public static Object $$$UnLock(mContext m$) {
    m$.Cmd.Unlock(m$.var("^CacheTempLock",m$.var("pstrLocking").get(),m$.var("pstrLocked").get()),"I");
    return null;
  }

  //<< #define DoIHaveLock(%1,%2,%3)   ''$data(^COMLocks(0,2,$$$Index(%1),$$$Index(%2),%3))
  public static Object $$$DoIHaveLock(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$3 = m$.varRef("p$3",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return (mOp.Not(mOp.Not(m$.Fnc.$data(m$.var("^COMLocks",0,2,include.MEDConst.$$$Index(m$,p$1),include.MEDConst.$$$Index(m$,p$2),p$3.get())))));
  }

  //<< 
  //<< #define NOCODE                  "NOCODE"
  public static Object $$$NOCODE(mContext m$) {
    return ("NOCODE");
  }

  public void main() {
    _COMLock();
  }

  public void _COMLock() {
  }

  //<< 
  //<< AddLock(pstrLocking,pidLocking,pstrLocked,pidLocked)
  public Object AddLock(Object ... _p) {
    mVar pstrLocking = m$.newVarRef("pstrLocking",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocking = m$.newVarRef("pidLocking",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrLocked = m$.newVarRef("pstrLocked",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidLocked = m$.newVarRef("pidLocked",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Adds a lock for an object if it can be done.
    //<< ;
    //<< ; Params:
    //<< ; pstrLocking: The class requesting the lock
    //<< ; pidLocking : It's id
    //<< ; pstrLocked : The class requested to be locked
    //<< ; pindLocked : It's id.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; 0 - Lock Owned By Someone else
    //<< ; 1 - Lock Owned By Me
    //<< ; 2 - Lock Successful
    //<< ; 3 - Lock Sync Failure - Record Exists no owner
    //<< ; 4 - Lock Sync Failure - Unable to Create Lock, save failed
    //<< ; 5 - Lock Sync Failure - Process Swapping
    //<< ; 6 - Lock Failed - Cache error
    //<< ;
    //<< ; History:
    //<< ; 08-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new enmStatus,idLock,blnLocked,strStatus
    mVar enmStatus = m$.var("enmStatus");
    mVar idLock = m$.var("idLock");
    mVar blnLocked = m$.var("blnLocked");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(enmStatus,idLock,blnLocked,strStatus);
    //<< 
    //<< set blnLocked=$$$NO
    blnLocked.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set $ztrap="AddLockError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("AddLockError");
    //<< 
    //<< set enmStatus = $$$EnumCOMLOCKLockSuccessful
    enmStatus.set(include.COMConst.$$$EnumCOMLOCKLockSuccessful(m$));
    //<< 
    //<< set idLock = $$$GetLockId(pstrLocked,pidLocked) // If this returns blank, the record is not locked
    idLock.set($$$GetLockId(m$,pstrLocked,pidLocked));
    //<< 
    //<< if idLock'="" {
    if (mOp.NotEqual(idLock.get(),"")) {
      //<< // There is a lock, either I have it or someone else does. Obvious huh?
      //<< if $$$DoIHaveLock(pstrLocking,pidLocking,idLock) {
      if (mOp.Logical($$$DoIHaveLock(m$,pstrLocking,pidLocking,idLock))) {
        //<< set enmStatus = $$$EnumCOMLOCKLockOwnedByMe
        enmStatus.set(include.COMConst.$$$EnumCOMLOCKLockOwnedByMe(m$));
      }
      //<< } else {
      else {
        //<< set enmStatus = $$$EnumCOMLOCKLockOwnedBySomeoneelse
        enmStatus.set(include.COMConst.$$$EnumCOMLOCKLockOwnedBySomeoneelse(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $$$LockOK {
    if (mOp.Logical($$$LockOK(m$))) {
      //<< $$$Lock // Take out a Cache lock
      $$$Lock(m$);
      //<< if $test {
      if (mOp.Logical(m$.Fnc.$test())) {
        //<< $$$IncrementLock // Increase the semaphore
        $$$IncrementLock(m$);
        //<< if $$$LockAvailable {
        if (mOp.Logical($$$LockAvailable(m$))) {
          //<< // Yep, now create our lock
          //<< set strStatus = $$CreateLock(pstrLocking,pidLocking,pstrLocked,pidLocked)
          strStatus.set(m$.fnc$("CreateLock",pstrLocking.get(),pidLocking.get(),pstrLocked.get(),pidLocked.get()));
          //<< $$$DecrementLock // Remove the semaphore
          $$$DecrementLock(m$);
          //<< 
          //<< $$$UnLock // Unlock the Cache lock
          $$$UnLock(m$);
          //<< 
          //<< // If the status is good, we got the lock, otherwise the save failed.
          //<< // So we couldn't get it.
          //<< 
          //<< if $$$ISOK(strStatus) {
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
            //<< set enmStatus = $$$EnumCOMLOCKLockSuccessful
            enmStatus.set(include.COMConst.$$$EnumCOMLOCKLockSuccessful(m$));
          }
          //<< } else {
          else {
            //<< set enmStatus = $$$EnumCOMLOCKLockSyncFailureUnabletoCreateLocksavefailed
            enmStatus.set(include.COMConst.$$$EnumCOMLOCKLockSyncFailureUnabletoCreateLocksavefailed(m$));
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< $$$DecrementLock // Remove the semaphore
          $$$DecrementLock(m$);
          //<< // There is a BAD lock. We could remove it and try again, but will leave that for the COMLock manager.
          //<< set enmStatus = $$$EnumCOMLOCKLockSyncFailureRecordExistsnoowner
          enmStatus.set(include.COMConst.$$$EnumCOMLOCKLockSyncFailureRecordExistsnoowner(m$));
        }
      }
      //<< }
      //<< 
      //<< } else {
      else {
        //<< // Just in case two or more processes swap out somewhere in the middle, we still need to fail nicely.
        //<< set enmStatus = $$$EnumCOMLOCKLockSyncFailureProcessSwapping
        enmStatus.set(include.COMConst.$$$EnumCOMLOCKLockSyncFailureProcessSwapping(m$));
      }
    }
    //<< }
    //<< }
    //<< quit enmStatus
    return enmStatus.get();
  }

  //<< 
  //<< //AddLockError ; Internal Tag
  //<< AddLockError() ; Internal Tag
  public Object AddLockError(Object ... _p) {
    //<< set $ztrap=""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< 
    //<< if +$get(blnLocked) {
    if (mOp.Logical(mOp.Positive(m$.Fnc.$get(m$.var("blnLocked"))))) {
      //<< $$$DecrementLock // Remove the semaphore
      $$$DecrementLock(m$);
      //<< $$$UnLock        // Unlock the Cache lock
      $$$UnLock(m$);
    }
    //<< }
    //<< quit $$$EnumCOMLOCKLockFailedCacheError
    return include.COMConst.$$$EnumCOMLOCKLockFailedCacheError(m$);
  }

  //<< 
  //<< 
  //<< CreateLock(pstrLocking,pidLocking,pstrLocked,pidLocked) private
  public Object CreateLock(Object ... _p) {
    mVar pstrLocking = m$.newVarRef("pstrLocking",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocking = m$.newVarRef("pidLocking",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrLocked = m$.newVarRef("pstrLocked",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidLocked = m$.newVarRef("pidLocked",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Actually create the lock object
    //<< ;
    //<< ; Params:
    //<< ; pstrLocking: The class doing requesting the lock
    //<< ; pidLocking : It's id
    //<< ; pstrLocked : The class requested to be locked
    //<< ; pindLocked : It's id.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; The status of the save, extremely important
    //<< ;
    //<< ; History:
    //<< ; 08-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set $ztrap="CreateLockError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("CreateLockError");
    //<< 
    //<< new objData
    mVar objData = m$.var("objData");
    m$.newVar(objData);
    //<< 
    //<< set objData = ""
    objData.set("");
    //<< set $$$COMLockLockingClassName(objData) = pstrLocking
    include.COMConst.$$$COMLockLockingClassNameSet(m$,objData,pstrLocking.get());
    //<< set $$$COMLockLockingClassId(objData)   = pidLocking
    include.COMConst.$$$COMLockLockingClassIdSet(m$,objData,pidLocking.get());
    //<< set $$$COMLockLockedClassName(objData)  = pstrLocked
    include.COMConst.$$$COMLockLockedClassNameSet(m$,objData,pstrLocked.get());
    //<< set $$$COMLockLockedClassId(objData)    = pidLocked
    include.COMConst.$$$COMLockLockedClassIdSet(m$,objData,pidLocked.get());
    //<< 
    //<< quit $$$Save("COMLock",$$^WWWNEXT("COMLock"),objData,$$$YES)
    return include.COMSYS.$$$Save(m$,"COMLock",m$.fnc$("WWWNEXT.main","COMLock"),objData,include.COMSYS.$$$YES(m$));
  }

  //<< 
  //<< //CreateLockError ; Internal Tag
  //<< CreateLockError() ; Internal Tag
  public Object CreateLockError(Object ... _p) {
    //<< set $ztrap=""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< quit '$$$OK
    return mOp.Not(include.COMSYS.$$$OK(m$));
  }

  //<< 
  //<< 
  //<< RemoveLock(pstrLocking,pidLocking,pstrLocked,pidLocked)
  public Object RemoveLock(Object ... _p) {
    mVar pstrLocking = m$.newVarRef("pstrLocking",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocking = m$.newVarRef("pidLocking",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrLocked = m$.newVarRef("pstrLocked",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidLocked = m$.newVarRef("pidLocked",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; This allows the system to remove a lock. First it checks that I have the lock
    //<< ; and if so, kill the lock object.
    //<< ;
    //<< ; Params:
    //<< ; pstrLocking: The class doing requesting the lock
    //<< ; pidLocking : It's id
    //<< ; pstrLocked : The class requested to be locked
    //<< ; pindLocked : It's id.
    //<< ;
    //<< ; ByRefs:   pstrStatus - status of kill removal
    //<< ;
    //<< ; Returns:
    //<< ; Boolean, $$$NO = It couldn't be removed, $$$YES = Removed
    //<< ;
    //<< ; History:
    //<< ; 19-Oct-2006   JW      SR15134: Look at kill status. Return status, not boolean
    //<< ; 08-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLock,blnRemove,strStatus
    mVar idLock = m$.var("idLock");
    mVar blnRemove = m$.var("blnRemove");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idLock,blnRemove,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idLock=$$$GetLockId(pstrLocked,pidLocked)
    idLock.set($$$GetLockId(m$,pstrLocked,pidLocked));
    //<< 
    //<< if (idLock'="") && $$$DoIHaveLock(pstrLocking,pidLocking,idLock) {
    if ((mOp.NotEqual(idLock.get(),"")) && mOp.Logical($$$DoIHaveLock(m$,pstrLocking,pidLocking,idLock))) {
      //<< set strStatus = $$$Kill("COMLock",idLock)
      strStatus.set(include.COMSYS.$$$Kill(m$,"COMLock",idLock));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetMyLocks(pstrLocking,pidLocking,&parrLocks)
  public Object GetMyLocks(Object ... _p) {
    mVar pstrLocking = m$.newVarRef("pstrLocking",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocking = m$.newVarRef("pidLocking",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar parrLocks = m$.newVarRef("parrLocks",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the list of locks that I own. Could have used a listbuild, but an array
    //<< ; is more expansive.
    //<< ;
    //<< ; Params:
    //<< ; pstrLocking: The class requesting the lock
    //<< ; pidLocking : It's id
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLock,idxLocking,intCount,objLock,strLocking
    mVar idLock = m$.var("idLock");
    mVar idxLocking = m$.var("idxLocking");
    mVar intCount = m$.var("intCount");
    mVar objLock = m$.var("objLock");
    mVar strLocking = m$.var("strLocking");
    m$.newVar(idLock,idxLocking,intCount,objLock,strLocking);
    //<< 
    //<< set strLocking = $$$Index(pstrLocking)
    strLocking.set(include.MEDConst.$$$Index(m$,pstrLocking));
    //<< set idxLocking = $$$Index(pidLocking)
    idxLocking.set(include.MEDConst.$$$Index(m$,pidLocking));
    //<< set idLock = ""
    idLock.set("");
    //<< for {
    for (;true;) {
      //<< set idLock = $order(^COMLocks(0,2,strLocking,idxLocking,idLock))
      idLock.set(m$.Fnc.$order(m$.var("^COMLocks",0,2,strLocking.get(),idxLocking.get(),idLock.get())));
      //<< quit:idLock=""
      if (mOp.Equal(idLock.get(),"")) {
        break;
      }
      //<< 
      //<< set objLock = $get(^COMLock(0,idLock,1))
      objLock.set(m$.Fnc.$get(m$.var("^COMLock",0,idLock.get(),1)));
      //<< set parrLocks($increment(intCount)) = $$$COMLockLockedClassName(objLock)_Y_$$$COMLockLockedClassId(objLock)
      parrLocks.var(m$.Fnc.$increment(intCount)).set(mOp.Concat(mOp.Concat(include.COMConst.$$$COMLockLockedClassName(m$,objLock),m$.var("Y").get()),include.COMConst.$$$COMLockLockedClassId(m$,objLock)));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< RemoveLocksIfRequired(pstrLocking,pidLocking,pstrCode="",pblnForce=$$$NO)
  public Object RemoveLocksIfRequired(Object ... _p) {
    mVar pstrLocking = m$.newVarRef("pstrLocking",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocking = m$.newVarRef("pidLocking",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnForce = m$.newVarRef("pblnForce",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Remove all locks for the locker if they should be removed.
    //<< ;
    //<< ; Params:
    //<< ; pstrLocking   : The class requesting the lock
    //<< ; pidLocking    : It's id
    //<< ; pstrCode      : The code to run to remove unnecessary locks.
    //<< ; pblnForce     : Whether to ignore failures/status.
    //<< ;                   $$$YES - ignore, $$$NO - stop at first failure
    //<< ;                   Set to $$$YES when you want to remove as many as possible
    //<< ;                   (changing forms) and set to $$$NO when inside of a transaction
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 01-Jul-2011   GRF     -: Replace Order macros
    //<< ; 19-Oct-2006   JW      SR15134: Look at kill status. Return status. Added pblnForce
    //<< ; 10-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrLocks,blnKill,blnRunCode,intCount,strClassId,strClassName,strStatus
    mVar arrLocks = m$.var("arrLocks");
    mVar blnKill = m$.var("blnKill");
    mVar blnRunCode = m$.var("blnRunCode");
    mVar intCount = m$.var("intCount");
    mVar strClassId = m$.var("strClassId");
    mVar strClassName = m$.var("strClassName");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(arrLocks,blnKill,blnRunCode,intCount,strClassId,strClassName,strStatus);
    //<< 
    //<< set $ztrap="RLIRError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("RLIRError");
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< do GetMyLocks(pstrLocking,pidLocking,.arrLocks)
    m$.Cmd.Do("GetMyLocks",pstrLocking.get(),pidLocking.get(),arrLocks);
    //<< 
    //<< set blnKill = $$$NO
    blnKill.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if pstrCode="" {
    if (mOp.Equal(pstrCode.get(),"")) {
      //<< set blnKill    = $$$YES
      blnKill.set(include.COMSYS.$$$YES(m$));
      //<< set blnRunCode = $$$NO
      blnRunCode.set(include.COMSYS.$$$NO(m$));
    }
    //<< } else {
    else {
      //<< set pstrCode   = "set blnKill="_$$GetCode(pstrCode)
      pstrCode.set(mOp.Concat("set blnKill=",m$.fnc$("GetCode",pstrCode.get())));
      //<< set blnRunCode = $$$YES
      blnRunCode.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< set intCount = ""
    intCount.set("");
    //<< for {
    for (;true;) {
      //<< set intCount = $order(arrLocks(intCount))
      intCount.set(m$.Fnc.$order(arrLocks.var(intCount.get())));
      //<< quit:intCount=""
      if (mOp.Equal(intCount.get(),"")) {
        break;
      }
      //<< 
      //<< set strClassName = $piece(arrLocks(intCount),Y,1)
      strClassName.set(m$.Fnc.$piece(arrLocks.var(intCount.get()).get(),m$.var("Y").get(),1));
      //<< set strClassId   = $piece(arrLocks(intCount),Y,2)
      strClassId.set(m$.Fnc.$piece(arrLocks.var(intCount.get()).get(),m$.var("Y").get(),2));
      //<< 
      //<< if blnRunCode xecute pstrCode
      if (mOp.Logical(blnRunCode.get())) {
        m$.Cmd.Xecute(pstrCode.get());
      }
      //<< 
      //<< if blnKill {
      if (mOp.Logical(blnKill.get())) {
        //<< set strStatus = $$RemoveLock(pstrLocking,pidLocking,strClassName,strClassId)
        strStatus.set(m$.fnc$("RemoveLock",pstrLocking.get(),pidLocking.get(),strClassName.get(),strClassId.get()));
      }
      //<< }
      //<< quit:'pblnForce&&$$$ISERR(strStatus)
      if (mOp.Not(pblnForce.get()) && mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        break;
      }
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< RLIRError ; Internal Tag
  public void RLIRError() {
    //<< set $ztrap=""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< GetCode(pstrCode)
  public Object GetCode(Object ... _p) {
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If the code is not a routine call, remove the = in front.
    //<< ;
    //<< ; Params:
    //<< ; pstrCode   : The code to run to remove unessecary locks.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; The code to be executed.
    //<< ;
    //<< ; History:
    //<< ; 08-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $extract(pstrCode,$$$LOCKCODELEN)=$$$LOCKCODE {
    if (mOp.Equal(m$.Fnc.$extract(pstrCode.get(),include.COMSYS.$$$LOCKCODELEN(m$)),include.COMSYS.$$$LOCKCODE(m$))) {
      //<< set pstrCode = $extract(pstrCode,$$$LOCKCODELEN+1,$length(pstrCode))
      pstrCode.set(m$.Fnc.$extract(pstrCode.get(),mOp.Add(include.COMSYS.$$$LOCKCODELEN(m$),1),m$.Fnc.$length(pstrCode.get())));
    }
    //<< }
    //<< quit pstrCode
    return pstrCode.get();
  }

  //<< 
  //<< 
  //<< RemoveOrphanedLocks(pblnReload=$$$YES)
  public Object RemoveOrphanedLocks(Object ... _p) {
    mVar pblnReload = m$.newVarRef("pblnReload",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Find all locks in the system that the locking entry no longer exists. If this
    //<< ; happens, they need to be removed.
    //<< ;
    //<< ; Params:
    //<< ; pblnReload: Should we reload the form? (Defaults to Yes).
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 01-Jul-2011   GRF     -: Replace Order macros
    //<< ; 19-Oct-2006   JW      SR15134: Force to delete all locks (ignore status)
    //<< ; 08-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrClasses,idLock,idLocking,objLock,strCode,strLocking
    mVar arrClasses = m$.var("arrClasses");
    mVar idLock = m$.var("idLock");
    mVar idLocking = m$.var("idLocking");
    mVar objLock = m$.var("objLock");
    mVar strCode = m$.var("strCode");
    mVar strLocking = m$.var("strLocking");
    m$.newVar(arrClasses,idLock,idLocking,objLock,strCode,strLocking);
    //<< 
    //<< if $$^WWWRELOAD()'=1 {
    if (mOp.NotEqual(m$.fnc$("WWWRELOAD.main"),1)) {
      //<< set idLock = ""
      idLock.set("");
      //<< for {
      for (;true;) {
        //<< set idLock = $order(^COMLock(0,idLock))
        idLock.set(m$.Fnc.$order(m$.var("^COMLock",0,idLock.get())));
        //<< quit:idLock=""
        if (mOp.Equal(idLock.get(),"")) {
          break;
        }
        //<< 
        //<< set objLock    = $get(^COMLock(0,idLock,1))
        objLock.set(m$.Fnc.$get(m$.var("^COMLock",0,idLock.get(),1)));
        //<< set strLocking = $$$COMLockLockingClassName(objLock)
        strLocking.set(include.COMConst.$$$COMLockLockingClassName(m$,objLock));
        //<< set idLocking  = $$$COMLockLockingClassId(objLock)
        idLocking.set(include.COMConst.$$$COMLockLockingClassId(m$,objLock));
        //<< 
        //<< if '$data(arrClasses(strLocking,idLocking)) {
        if (mOp.Not(m$.Fnc.$data(arrClasses.var(strLocking.get(),idLocking.get())))) {
          //<< 
          //<< set arrClasses(strLocking,idLocking) = ""
          arrClasses.var(strLocking.get(),idLocking.get()).set("");
          //<< set strCode = $$GetRemovalCode(strLocking,idLocking)
          strCode.set(m$.fnc$("GetRemovalCode",strLocking.get(),idLocking.get()));
          //<< if strCode'=$$$NOCODE {
          if (mOp.NotEqual(strCode.get(),$$$NOCODE(m$))) {
            //<< do RemoveLocksIfRequired(strLocking,idLocking,strCode,$$$YES)
            m$.Cmd.Do("RemoveLocksIfRequired",strLocking.get(),idLocking.get(),strCode.get(),include.COMSYS.$$$YES(m$));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< do:pblnReload ReloadForm^COMUtilForm()
    if (mOp.Logical(pblnReload.get())) {
      m$.Cmd.Do("COMUtilForm.ReloadForm");
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetRemovalCode(pstrLocking,pidLocking)
  public Object GetRemovalCode(Object ... _p) {
    mVar pstrLocking = m$.newVarRef("pstrLocking",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocking = m$.newVarRef("pidLocking",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check that the routine for getting the removal code exists and execute it.
    //<< ;
    //<< ; Params:
    //<< ; pstrLocking: The class doing requesting the lock
    //<< ; pidLocking : It's id
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; The Code
    //<< ;
    //<< ; History:
    //<< ; 05-Feb-2007   RPW     SR14900: Use ExecuteCode to handle invalid code instead of $text
    //<< ; 01-Feb-2007   RPW     SR15418: Fixed logging and remove early quits.
    //<< ; 16-Oct-2006   RPW     SR15123: added logging for invalid keys.
    //<< ; 11-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strCall,strClass,strCode,strRoutine
    mVar strCall = m$.var("strCall");
    mVar strClass = m$.var("strClass");
    mVar strCode = m$.var("strCode");
    mVar strRoutine = m$.var("strRoutine");
    m$.newVar(strCall,strClass,strCode,strRoutine);
    //<< 
    //<< set $ztrap="GRCError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("GRCError");
    //<< 
    //<< ; FIXME : Should make formal ^COMGRCError or ^LOGGRCError global rather than using
    //<< ;         zzGRCError
    //<< 
    //<< quit:(pstrLocking="")||(pidLocking="") ""
    if ((mOp.Equal(pstrLocking.get(),"")) || (mOp.Equal(pidLocking.get(),""))) {
      return "";
    }
    //<< 
    //<< if $piece(pidLocking,$$$COMMA,$length(pidLocking,$$$COMMA))="" {
    if (mOp.Equal(m$.Fnc.$piece(pidLocking.get(),include.COMSYSString.$$$COMMA(m$),m$.Fnc.$length(pidLocking.get(),include.COMSYSString.$$$COMMA(m$))),"")) {
      //<< set ^zzGRCError($i(^zzGRCError)) = $zdatetime($horolog,3)_">>"_pstrLocking_">>"_pidLocking_"."
      m$.var("^zzGRCError",m$.Fnc.$increment(m$.var("^zzGRCError"))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$zdatetime(m$.Fnc.$horolog(),3),">>"),pstrLocking.get()),">>"),pidLocking.get()),"."));
      //<< do:$get(^SysSetup("Logging","SR15123"),0) StackDump^COMDebug("GetRemovalCode")   ; => ^LogStackDump
      if (mOp.Logical(m$.Fnc.$get(m$.var("^SysSetup","Logging","SR15123"),0))) {
        m$.Cmd.Do("COMDebug.StackDump","GetRemovalCode");
      }
      //<< set strCode = ""
      strCode.set("");
    }
    //<< 
    //<< } elseif $data($$$DATA(pstrLocking,pidLocking)) {
    else if (mOp.Logical(m$.Fnc.$data(include.COMSYSWWW.$$$DATAVar(m$,pstrLocking,pidLocking)))) {
      //<< if '$$ExecuteCode^COMUtils("set strCode=$$GetRemovalCode^"_pstrLocking_"("""_pstrLocking_""","""_pidLocking_""")") {
      if (mOp.Not(m$.fnc$("COMUtils.ExecuteCode",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("set strCode=$$GetRemovalCode^",pstrLocking.get()),"(\""),pstrLocking.get()),"\",\""),pidLocking.get()),"\")")))) {
        //<< set strCode = $$$NOCODE
        strCode.set($$$NOCODE(m$));
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set strCode = ""
      strCode.set("");
    }
    //<< }
    //<< quit strCode
    return strCode.get();
  }

  //<< 
  //<< //GRCError ; Internal Tag
  //<< GRCError() ; Internal Tag
  public Object GRCError(Object ... _p) {
    //<< set $ztrap=""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< set ^zzGRCError($i(^zzGRCError))=$zdatetime($horolog,3)_">>"_pstrLocking_">>"_pidLocking_". "_$zerror
    m$.var("^zzGRCError",m$.Fnc.$increment(m$.var("^zzGRCError"))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$zdatetime(m$.Fnc.$horolog(),3),">>"),m$.var("pstrLocking").get()),">>"),m$.var("pidLocking").get()),". "),m$.Fnc.$zerror()));
    //<< do:$get(^SysSetup("Logging","SR15123"),0) StackDump^COMDebug("GetRemovalCode")
    if (mOp.Logical(m$.Fnc.$get(m$.var("^SysSetup","Logging","SR15123"),0))) {
      m$.Cmd.Do("COMDebug.StackDump","GetRemovalCode");
    }
    //<< quit ""
    return "";
  }

  //<< 
  //<< 
  //<< IsExternallyLocked(pstrLocked,pidLocked)
  public Object IsExternallyLocked(Object ... _p) {
    mVar pstrLocked = m$.newVarRef("pstrLocked",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocked = m$.newVarRef("pidLocked",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines where the a locked object is locked by someone else or not locked.
    //<< ;
    //<< ; Params:
    //<< ; pstrLocking: The class doing requesting the lock
    //<< ; pidLocking : It's id
    //<< ; pstrLocked : The class requested to be locked
    //<< ; pindLocked : It's id.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; Boolean
    //<< ;
    //<< ; History:
    //<< ; 18-May-2006   Steve S Newed strData
    //<< ; 11-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnExternal,idLockClass,idLocked,strData,strLockClass
    mVar blnExternal = m$.var("blnExternal");
    mVar idLockClass = m$.var("idLockClass");
    mVar idLocked = m$.var("idLocked");
    mVar strData = m$.var("strData");
    mVar strLockClass = m$.var("strLockClass");
    m$.newVar(blnExternal,idLockClass,idLocked,strData,strLockClass);
    //<< 
    //<< set strData = $get(^CacheTempLockInterest(YUSER))
    strData.set(m$.Fnc.$get(m$.var("^CacheTempLockInterest",m$.var("YUSER").get())));
    //<< 
    //<< set strLockClass = $piece(strData,Y,1)
    strLockClass.set(m$.Fnc.$piece(strData.get(),m$.var("Y").get(),1));
    //<< set idLockClass  = $piece(strData,Y,2)
    idLockClass.set(m$.Fnc.$piece(strData.get(),m$.var("Y").get(),2));
    //<< 
    //<< set idLocked = $$$GetLockId(pstrLocked,pidLocked)
    idLocked.set($$$GetLockId(m$,pstrLocked,pidLocked));
    //<< if idLocked'="" {
    if (mOp.NotEqual(idLocked.get(),"")) {
      //<< set blnExternal = '$$$DoIHaveLock(strLockClass,idLockClass,idLocked)
      blnExternal.set(mOp.Not($$$DoIHaveLock(m$,strLockClass,idLockClass,idLocked)));
    }
    //<< } else {
    else {
      //<< set blnExternal = $$$NO
      blnExternal.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< quit blnExternal
    return blnExternal.get();
  }

  //<< 
  //<< 
  //<< SetLockingInterest(pstrLocking,pidLocking)
  public Object SetLockingInterest(Object ... _p) {
    mVar pstrLocking = m$.newVarRef("pstrLocking",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocking = m$.newVarRef("pidLocking",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Prepare to set this owner as the lock owner.
    //<< ;
    //<< ; Params:
    //<< ; pstrLocking: The class doing requesting the lock
    //<< ; pidLocking : It's id
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Aug-2006   RPW/SCH SRBR014167:Modified to send out the javascript to call
    //<< ;                           SetLockingInterest1
    //<< ; 11-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write "function LoadEvent() {"
    m$.Cmd.Write("function LoadEvent() {");
    //<< if '$$$NoKey(pidLocking) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pidLocking))) {
      //<< write "if (typeof(CallBackNow) != 'undefined') { CallBackNow('SetLockingInterest1^COMLock','"_pstrLocking_"','"_pidLocking_"'); }"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("if (typeof(CallBackNow) != 'undefined') { CallBackNow('SetLockingInterest1^COMLock','",pstrLocking.get()),"','"),pidLocking.get()),"'); }"));
    }
    //<< }
    //<< write "}"
    m$.Cmd.Write("}");
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetLockingInterest1(pstrLocking,pidLocking)
  public Object SetLockingInterest1(Object ... _p) {
    mVar pstrLocking = m$.newVarRef("pstrLocking",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocking = m$.newVarRef("pidLocking",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set this form to be a Lock Owner.
    //<< ; Used primarily for COMView at this stage.
    //<< ;
    //<< ; Params:
    //<< ; pstrLocking: The class doing requesting the lock
    //<< ; pidLocking : It's id
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Aug-2006   RPW/SCH SRBR014167: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if (pstrLocking'="") && (pidLocking'="") {
    if ((mOp.NotEqual(pstrLocking.get(),"")) && (mOp.NotEqual(pidLocking.get(),""))) {
      //<< set ^CacheTempLockInterest(YUSER) = pstrLocking_Y_pidLocking
      m$.var("^CacheTempLockInterest",m$.var("YUSER").get()).set(mOp.Concat(mOp.Concat(pstrLocking.get(),m$.var("Y").get()),pidLocking.get()));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< RemoveLockingInterest(pstrLocking,pidLocking)
  public Object RemoveLockingInterest(Object ... _p) {
    mVar pstrLocking = m$.newVarRef("pstrLocking",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocking = m$.newVarRef("pidLocking",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set this form as no longer a Lock Owner and remove all it's locks.
    //<< ;
    //<< ; Params:
    //<< ; pstrLocking: The class doing requesting the lock
    //<< ; pidLocking : It's id
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Oct-2006   JW      SR15134: Force to delete all locks (ignore status)
    //<< ; 11-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strCode
    mVar strCode = m$.var("strCode");
    m$.newVar(strCode);
    //<< 
    //<< kill ^CacheTempLockInterest(YUSER)
    m$.var("^CacheTempLockInterest",m$.var("YUSER").get()).kill();
    //<< 
    //<< set strCode = $$GetRemovalCode(pstrLocking,pidLocking)
    strCode.set(m$.fnc$("GetRemovalCode",pstrLocking.get(),pidLocking.get()));
    //<< if strCode'=$$$NOCODE {
    if (mOp.NotEqual(strCode.get(),$$$NOCODE(m$))) {
      //<< do RemoveLocksIfRequired(pstrLocking,pidLocking,strCode,$$$YES)
      m$.Cmd.Do("RemoveLocksIfRequired",pstrLocking.get(),pidLocking.get(),strCode.get(),include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< quit
    return null;
  }

//<< 
//<< 
}
