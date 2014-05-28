//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMultiLock
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:34
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
import include.$occInclude;
//<< #include WWWConst
import include.WWWConst;

//<< WWWMultiLock
public class WWWMultiLock extends mClass {

  //<< 
  //<< ; FIXME : DEPRECATED YM always 0 - see if can be skipped altogether
  //<< #define AddCompany(%1,%2)       set %1 = $$$WWWYM($$$WWW120ClassUsedInForm($get(^WWW120(0,%2,1))))_$$$COMMA_%1
  public static Object $$$AddCompany(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    p$1.set(mOp.Concat(mOp.Concat(include.COMSYSWWW.$$$WWWYM(m$,include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,p$2.get(),1)))),include.COMSYSString.$$$COMMA(m$)),p$1.get()));
    return null;
  }

  public void main() {
    _WWWMultiLock();
  }

  public void _WWWMultiLock() {
  }

  //<< 
  //<< ;*******************************************************************************
  //<< ; SR14508: Multi-locking
  //<< ;
  //<< ; Routines for multi-locking a single YUSER against multiple records (keys).
  //<< ; Locks are automatically cleared when the YUSER closes the browser,
  //<< ; or navigates to another form.
  //<< ;
  //<< ; Mainly intended for usage in Edit Grid scenarios, where multiple records
  //<< ; are shown per YUSER session, and you wish to have special logic for "locking"
  //<< ; rows of the grid as the user performs an action.
  //<< ;
  //<< ; IMPORTANT:
  //<< ; Do **NOT** kill locks manually in any application code. Always go through
  //<< ; the KILL routine (this is due to an index file being present.)
  //<< ;
  //<< ;*******************************************************************************
  //<< 
  //<< LockSet(pYFORMHeader,pYFORMLine,pstrKeys,plstInUseMessage="")
  public Object LockSet(Object ... _p) {
    mVar pYFORMHeader = m$.newVarRef("pYFORMHeader",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORMLine = m$.newVarRef("pYFORMLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrKeys = m$.newVarRef("pstrKeys",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar plstInUseMessage = m$.newVarRef("plstInUseMessage",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; If possible, set the multi-lock
    //<< ;
    //<< ; History:
    //<< ; 01-Dec-2009   GRF     SR17007: separate tags for different operation
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$ManageLock($get(pYFORMHeader),$get(pYFORMLine),$get(pstrKeys),$$$YES,plstInUseMessage)
    return m$.fnc$("ManageLock",m$.Fnc.$get(pYFORMHeader),m$.Fnc.$get(pYFORMLine),m$.Fnc.$get(pstrKeys),include.COMSYS.$$$YES(m$),plstInUseMessage.get());
  }

  //<< 
  //<< 
  //<< GetLock(pYFORMHeader,pYFORMLine,pstrKeys,plstInUseMessage="")
  public Object GetLock(Object ... _p) {
    mVar pYFORMHeader = m$.newVarRef("pYFORMHeader",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORMLine = m$.newVarRef("pYFORMLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrKeys = m$.newVarRef("pstrKeys",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar plstInUseMessage = m$.newVarRef("plstInUseMessage",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; If possible, get the multi-lock
    //<< ;
    //<< ; History:
    //<< ; 01-Dec-2009   GRF     SR17007: separate tags for different operation; strip
    //<< ;                           argument 4
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$ManageLock($get(pYFORMHeader),$get(pYFORMLine),$get(pstrKeys),$$$NO,plstInUseMessage)
    return m$.fnc$("ManageLock",m$.Fnc.$get(pYFORMHeader),m$.Fnc.$get(pYFORMLine),m$.Fnc.$get(pstrKeys),include.COMSYS.$$$NO(m$),plstInUseMessage.get());
  }

  //<< 
  //<< 
  //<< ManageLock(pYFORMHeader,pYFORMLine,pstrKeys,pblnSet,plstInUseMessage) private
  public Object ManageLock(Object ... _p) {
    mVar pYFORMHeader = m$.newVarRef("pYFORMHeader",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORMLine = m$.newVarRef("pYFORMLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrKeys = m$.newVarRef("pstrKeys",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnSet = m$.newVarRef("pblnSet",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar plstInUseMessage = m$.newVarRef("plstInUseMessage",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Attempts to get/set a multi-lock
    //<< ;
    //<< ; Params: pYFORMHeader      : The YFORM of the header
    //<< ;         pYFORMLine        : The YFORM of the lines (grid)
    //<< ;         pstrKeys          : The keys of the locked record (K1_,_K2_ ... _ Kn)
    //<< ;         pblnSet           : If you can get it, set it
    //<< ;         plstInUseMessage  : $lb() of error to use, if record is in use.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: strStatus
    //<< ;
    //<< ; History:
    //<< ; 01-Dec-2009   GRF     SR17007: renamed with separate calling tags
    //<< ; 18-Jan-2007   SteveS  SR15355: Use namespace subscript
    //<< ; 17-Jan-2007   SteveS  SR15392: Check for @net lock
    //<< ; 23-Jun-2006   SteveS  SR14698: Can now display a custom message
    //<< ; 05-May-2006   SteveS  SR14508: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idUser,idYUSER,loop,strKey,strNS,strStatus,tmsLock
    mVar idUser = m$.var("idUser");
    mVar idYUSER = m$.var("idYUSER");
    mVar loop = m$.var("loop");
    mVar strKey = m$.var("strKey");
    mVar strNS = m$.var("strNS");
    mVar strStatus = m$.var("strStatus");
    mVar tmsLock = m$.var("tmsLock");
    m$.newVar(idUser,idYUSER,loop,strKey,strNS,strStatus,tmsLock);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if (pYFORMHeader="") || (pYFORMLine="") {      ; FIXME : $$$MakeStatus for consistancy
    if ((mOp.Equal(pYFORMHeader.get(),"")) || (mOp.Equal(pYFORMLine.get(),""))) {
      //<< set strStatus = $listbuild(35)                               ; "No Form Default"
      strStatus.set(m$.Fnc.$listbuild(35));
    }
    //<< 
    //<< } else {
    else {
      //<< for loop=1:1:$length(pstrKeys,$$$COMMA) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(pstrKeys.get(),include.COMSYSString.$$$COMMA(m$))));loop.set(mOp.Add(loop.get(),1))) {
        //<< if $$$ISOK(strStatus) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
          //<< set strKey = $piece(pstrKeys,$$$COMMA,loop)
          strKey.set(m$.Fnc.$piece(pstrKeys.get(),include.COMSYSString.$$$COMMA(m$),loop.get()));
          //<< if $$$NoKey(strKey) set strStatus = $listbuild(278)  ; "No Primary Key"
          if (mOp.Logical(include.COMSYS.$$$NoKey(m$,strKey))) {
            strStatus.set(m$.Fnc.$listbuild(278));
          }
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< $$$AddCompany(pstrKeys,pYFORMLine)
        $$$AddCompany(m$,pstrKeys,pYFORMLine);
        //<< set strNS = $zutil(5)
        strNS.set(m$.Fnc.$zutil(5));
        //<< 
        //<< lock +^CacheTempMultiLock(pYFORMHeader,pYFORMLine,pstrKeys,strNS):10
        m$.Cmd.LockInc(m$.var("^CacheTempMultiLock",pYFORMHeader.get(),pYFORMLine.get(),pstrKeys.get(),strNS.get()),10);
        //<< if $test {
        if (mOp.Logical(m$.Fnc.$test())) {
          //<< set idYUSER = $order(^CacheTempMultiLock(pYFORMHeader,pYFORMLine,pstrKeys,strNS,""))
          idYUSER.set(m$.Fnc.$order(m$.var("^CacheTempMultiLock",pYFORMHeader.get(),pYFORMLine.get(),pstrKeys.get(),strNS.get(),"")));
          //<< 
          //<< if (idYUSER'="") && (idYUSER'=YUSER) {     ; someone else has it ...
          if ((mOp.NotEqual(idYUSER.get(),"")) && (mOp.NotEqual(idYUSER.get(),m$.var("YUSER").get()))) {
            //<< if plstInUseMessage="" {
            if (mOp.Equal(plstInUseMessage.get(),"")) {
              //<< set idUser    = $$$WWWUSERUser1($get(^WWWUSER(0,idYUSER,1)))
              idUser.set(include.WWWConst.$$$WWWUSERUser1(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,idYUSER.get(),1))));
              //<< set tmsLock   = $get(^CacheTempMultiLock(pYFORMHeader,pYFORMLine,pstrKeys,strNS,idYUSER))
              tmsLock.set(m$.Fnc.$get(m$.var("^CacheTempMultiLock",pYFORMHeader.get(),pYFORMLine.get(),pstrKeys.get(),strNS.get(),idYUSER.get())));
              //<< set strStatus = $listbuild("WWW00040",idUser,$$$FormatTimeStamp(tmsLock))
              strStatus.set(m$.Fnc.$listbuild("WWW00040",idUser.get(),include.COMSYSWWW.$$$FormatTimeStamp(m$,tmsLock)));
            }
            //<< ;                 "Item locked by user `%1` at %2."
            //<< } else {
            else {
              //<< set strStatus = plstInUseMessage
              strStatus.set(plstInUseMessage.get());
            }
          }
          //<< }
          //<< 
          //<< } else {                                   ; can get it
          else {
            //<< set strStatus = $$IsAvailable(pYFORMLine,pstrKeys)
            strStatus.set(m$.fnc$("IsAvailable",pYFORMLine.get(),pstrKeys.get()));
            //<< if $$$ISOK(strStatus) && pblnSet {
            if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus)) && mOp.Logical(pblnSet.get())) {
              //<< set ^CacheTempMultiLock(pYFORMHeader,pYFORMLine,pstrKeys,strNS,YUSER)  = $horolog
              m$.var("^CacheTempMultiLock",pYFORMHeader.get(),pYFORMLine.get(),pstrKeys.get(),strNS.get(),m$.var("YUSER").get()).set(m$.Fnc.$horolog());
              //<< set ^CacheTempMultiLocks(strNS,YUSER,pYFORMHeader,pYFORMLine,pstrKeys) = ""
              m$.var("^CacheTempMultiLocks",strNS.get(),m$.var("YUSER").get(),pYFORMHeader.get(),pYFORMLine.get(),pstrKeys.get()).set("");
            }
          }
          //<< }
          //<< }
          //<< lock -^CacheTempMultiLock(pYFORMHeader,pYFORMLine,pstrKeys,strNS)
          m$.Cmd.Unlock(m$.var("^CacheTempMultiLock",pYFORMHeader.get(),pYFORMLine.get(),pstrKeys.get(),strNS.get()));
        }
        //<< 
        //<< } else {
        else {
          //<< set strStatus = $$$MakeStatus("WWW00041")  ; "Unable to obtain lock."
          strStatus.set(include.COMSYS.$$$MakeStatus(m$,"WWW00041"));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< IsAvailable(pYFORM,pstrKeys) private
  public Object IsAvailable(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrKeys = m$.newVarRef("pstrKeys",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines if this record is "unlocked" (ie, has no @net locks)
    //<< ;
    //<< ; Params:   pYFORMLine      : The form
    //<< ;           pstrKeys        : The full keys
    //<< ;
    //<< ; Returns:  strStatus
    //<< ;
    //<< ; History:
    //<< ; 09-Jun-2009   PPP     SR16544: Removed Order Macros
    //<< ; 18-Jan-2007   SS      SR15355: Use namespace subscript
    //<< ; 17-Jan-2007   SS      SR15392: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new dteLock,idClass,idLock,idSession,idUserAtNetLock,objWWW006,strStatus,tmeLock
    mVar dteLock = m$.var("dteLock");
    mVar idClass = m$.var("idClass");
    mVar idLock = m$.var("idLock");
    mVar idSession = m$.var("idSession");
    mVar idUserAtNetLock = m$.var("idUserAtNetLock");
    mVar objWWW006 = m$.var("objWWW006");
    mVar strStatus = m$.var("strStatus");
    mVar tmeLock = m$.var("tmeLock");
    m$.newVar(dteLock,idClass,idLock,idSession,idUserAtNetLock,objWWW006,strStatus,tmeLock);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idClass   = $$$WWW120ClassUsedInForm($get(^WWW120(0,pYFORM,1)))
    idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,pYFORM.get(),1))));
    //<< set idLock    = "^"_idClass_"/"_$translate(pstrKeys,",",".")_".1/"
    idLock.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",idClass.get()),"/"),m$.Fnc.$translate(pstrKeys.get(),",",".")),".1/"));
    //<< 
    //<< set dteLock = ""
    dteLock.set("");
    //<< for {                                          // This allows locks held overnight.
    for (;true;) {
      //<< set dteLock = $order(^WWW006(0,dteLock))
      dteLock.set(m$.Fnc.$order(m$.var("^WWW006",0,dteLock.get())));
      //<< quit:dteLock=""
      if (mOp.Equal(dteLock.get(),"")) {
        break;
      }
      //<< continue:'$data(^WWW006(0,dteLock,idLock))
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW006",0,dteLock.get(),idLock.get())))) {
        continue;
      }
      //<< 
      //<< set objWWW006 = $get(^WWW006(0,dteLock,idLock,1))
      objWWW006.set(m$.Fnc.$get(m$.var("^WWW006",0,dteLock.get(),idLock.get(),1)));
      //<< set idSession = $$$WWW006User1(objWWW006)
      idSession.set(include.WWWConst.$$$WWW006User1(m$,objWWW006));
      //<< continue:(idSession=YUSER)      // This does nothing really - can't have 2 forms open with the same YUSER.
      if ((mOp.Equal(idSession.get(),m$.var("YUSER").get()))) {
        continue;
      }
      //<< 
      //<< set tmeLock         = $$$WWW006LockedUntilTime(objWWW006)       ; locked by another user
      tmeLock.set(include.WWWConst.$$$WWW006LockedUntilTime(m$,objWWW006));
      //<< set idUserAtNetLock = $$$WWWUSERUser1($get(^WWWUSER(0,idSession,1)))
      idUserAtNetLock.set(include.WWWConst.$$$WWWUSERUser1(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,idSession.get(),1))));
      //<< set strStatus       = $$$MakeStatus("WWW00040",idUserAtNetLock,$$$FormatTimeStamp(dteLock_","_tmeLock))
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"WWW00040",idUserAtNetLock,include.COMSYSWWW.$$$FormatTimeStamp(m$,mOp.Concat(mOp.Concat(dteLock.get(),","),tmeLock.get()))));
      //<< quit:$$$ISERR(strStatus)     ; "Item locked by user `%1` at %2."
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        break;
      }
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< HaveLock(pidFormHeader,pidFormLine,pYKEY)
  public Object HaveLock(Object ... _p) {
    mVar pidFormHeader = m$.newVarRef("pidFormHeader",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFormLine = m$.newVarRef("pidFormLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; See if this record is owned (locked) by me
    //<< ;
    //<< ; Params:   pidFormHeader   : The form header
    //<< ;           pidFormLine     : The form line
    //<< ;           pYKEY           : The record key
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Jan-2007   SS      SR15355: Use namespace subscript
    //<< ; 16-Jan-2007   SS      SR15339: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnLockedByMe,strNS
    mVar blnLockedByMe = m$.var("blnLockedByMe");
    mVar strNS = m$.var("strNS");
    m$.newVar(blnLockedByMe,strNS);
    //<< 
    //<< set strNS = $zutil(5)
    strNS.set(m$.Fnc.$zutil(5));
    //<< set blnLockedByMe = $$$NO
    blnLockedByMe.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< $$$AddCompany(pYKEY,pidFormLine)
    $$$AddCompany(m$,pYKEY,pidFormLine);
    //<< 
    //<< if $data(^CacheTempMultiLocks(strNS,YUSER,pidFormHeader,pidFormLine,pYKEY)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempMultiLocks",strNS.get(),m$.var("YUSER").get(),pidFormHeader.get(),pidFormLine.get(),pYKEY.get())))) {
      //<< set blnLockedByMe = $$$YES
      blnLockedByMe.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< quit blnLockedByMe
    return blnLockedByMe.get();
  }

  //<< 
  //<< 
  //<< GetLockUser(pYFORMHeader,pYFORMLine,pstrKeys)
  public Object GetLockUser(Object ... _p) {
    mVar pYFORMHeader = m$.newVarRef("pYFORMHeader",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORMLine = m$.newVarRef("pYFORMLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrKeys = m$.newVarRef("pstrKeys",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Which user owns this lock?
    //<< ;
    //<< ; Params: pYFORMHeader  : The YFORM of the header
    //<< ;         pYFORMLine    : The YFORM of the lines (grid)
    //<< ;         pstrKeys      : The keys of the locked record (K1_,_K2_ ... _ Kn)
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Jan-2007   SS      SR15355: Use namespace subscript
    //<< ; 05-May-2006   SS      SR14508: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idUser,idYUSER,strNS
    mVar idUser = m$.var("idUser");
    mVar idYUSER = m$.var("idYUSER");
    mVar strNS = m$.var("strNS");
    m$.newVar(idUser,idYUSER,strNS);
    //<< 
    //<< set strNS  = $zutil(5)
    strNS.set(m$.Fnc.$zutil(5));
    //<< set idUser = ""
    idUser.set("");
    //<< 
    //<< if ($get(pYFORMHeader)'="") && ($get(pYFORMLine)'="") && ($get(pstrKeys)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(pYFORMHeader),"")) && (mOp.NotEqual(m$.Fnc.$get(pYFORMLine),"")) && (mOp.NotEqual(m$.Fnc.$get(pstrKeys),""))) {
      //<< $$$AddCompany(pstrKeys,pYFORMLine)
      $$$AddCompany(m$,pstrKeys,pYFORMLine);
      //<< set idYUSER = $order(^CacheTempMultiLock(pYFORMHeader,pYFORMLine,pstrKeys,strNS,""))
      idYUSER.set(m$.Fnc.$order(m$.var("^CacheTempMultiLock",pYFORMHeader.get(),pYFORMLine.get(),pstrKeys.get(),strNS.get(),"")));
      //<< set:(idYUSER'="") idUser = $$$WWWUSERUser1($get(^WWWUSER(0,idYUSER,1)))
      if ((mOp.NotEqual(idYUSER.get(),""))) {
        idUser.set(include.WWWConst.$$$WWWUSERUser1(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,idYUSER.get(),1))));
      }
    }
    //<< }
    //<< quit idUser
    return idUser.get();
  }

  //<< 
  //<< 
  //<< IsFree(pYFORMHeader,pYFORMLine,pstrKeys)
  public Object IsFree(Object ... _p) {
    mVar pYFORMHeader = m$.newVarRef("pYFORMHeader",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORMLine = m$.newVarRef("pYFORMLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrKeys = m$.newVarRef("pstrKeys",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks if this record is free (ie, locked by no-one).
    //<< ;
    //<< ; Params: pYFORMHeader  : The YFORM of the header
    //<< ;         pYFORMLine    : The YFORM of the lines (grid)
    //<< ;         pstrKeys      : The keys of the locked record (K1_,_K2_ ... _ Kn)
    //<< ;
    //<< ; Returns: boolean
    //<< ;
    //<< ; History:
    //<< ; 24-Jan-2007   Steve S     Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit ($$GetLockUser(pYFORMHeader,pYFORMLine,pstrKeys)="")
    return (mOp.Equal(m$.fnc$("GetLockUser",pYFORMHeader.get(),pYFORMLine.get(),pstrKeys.get()),""));
  }

  //<< 
  //<< 
  //<< ClearOld(pYUSER,pYFORM="")
  public Object ClearOld(Object ... _p) {
    mVar pYUSER = m$.newVarRef("pYUSER",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Remove all multi-locks for a YUSER, except for those of the current form.
    //<< ;
    //<< ; I'm on this form -- clear any multi-locks I no longer own.
    //<< ;
    //<< ; Params:   pYUSER  : The YUSER number
    //<< ;           pYFORM  : The YFORM I'm opening
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Jun-2009   PPP     SR16544: Removed Order Macros
    //<< ; 18-Jan-2007   SS      SR15355: Use namespace subscript
    //<< ; 11-Jan-2007   SS      SR15355: Order macros
    //<< ; 05-May-2006   SS      SR14508: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idYFORMHeader,idYFORMLine,strKeys,strNS
    mVar idYFORMHeader = m$.var("idYFORMHeader");
    mVar idYFORMLine = m$.var("idYFORMLine");
    mVar strKeys = m$.var("strKeys");
    mVar strNS = m$.var("strNS");
    m$.newVar(idYFORMHeader,idYFORMLine,strKeys,strNS);
    //<< 
    //<< quit:$get(pYUSER)=""
    if (mOp.Equal(m$.Fnc.$get(pYUSER),"")) {
      return null;
    }
    //<< 
    //<< set strNS = $zutil(5)
    strNS.set(m$.Fnc.$zutil(5));
    //<< 
    //<< set idYFORMHeader = ""
    idYFORMHeader.set("");
    //<< for {
    for (;true;) {
      //<< set idYFORMHeader = $order(^CacheTempMultiLocks(strNS,pYUSER,idYFORMHeader))
      idYFORMHeader.set(m$.Fnc.$order(m$.var("^CacheTempMultiLocks",strNS.get(),pYUSER.get(),idYFORMHeader.get())));
      //<< quit:idYFORMHeader=""
      if (mOp.Equal(idYFORMHeader.get(),"")) {
        break;
      }
      //<< continue:(idYFORMHeader=pYFORM)
      if ((mOp.Equal(idYFORMHeader.get(),pYFORM.get()))) {
        continue;
      }
      //<< 
      //<< set idYFORMLine = ""
      idYFORMLine.set("");
      //<< for {
      for (;true;) {
        //<< set idYFORMLine = $order(^CacheTempMultiLocks(strNS,pYUSER,idYFORMHeader,idYFORMLine))
        idYFORMLine.set(m$.Fnc.$order(m$.var("^CacheTempMultiLocks",strNS.get(),pYUSER.get(),idYFORMHeader.get(),idYFORMLine.get())));
        //<< quit:idYFORMLine=""
        if (mOp.Equal(idYFORMLine.get(),"")) {
          break;
        }
        //<< 
        //<< set strKeys = ""
        strKeys.set("");
        //<< for {
        for (;true;) {
          //<< set strKeys = $order(^CacheTempMultiLocks(strNS,pYUSER,idYFORMHeader,idYFORMLine,strKeys))
          strKeys.set(m$.Fnc.$order(m$.var("^CacheTempMultiLocks",strNS.get(),pYUSER.get(),idYFORMHeader.get(),idYFORMLine.get(),strKeys.get())));
          //<< quit:strKeys=""
          if (mOp.Equal(strKeys.get(),"")) {
            break;
          }
          //<< 
          //<< do KILL(idYFORMHeader,idYFORMLine,strKeys,pYUSER,,strNS)
          m$.Cmd.Do("KILL",idYFORMHeader.get(),idYFORMLine.get(),strKeys.get(),pYUSER.get(),null,strNS.get());
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
  //<< 
  //<< KILL(pYFORMHeader,pYFORMLine,pstrKeys,pYUSER="",pblnPrefix=$$$NO,pstrNS="")
  public Object KILL(Object ... _p) {
    mVar pYFORMHeader = m$.newVarRef("pYFORMHeader",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORMLine = m$.newVarRef("pYFORMLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrKeys = m$.newVarRef("pstrKeys",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYUSER = m$.newVarRef("pYUSER",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pblnPrefix = m$.newVarRef("pblnPrefix",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    mVar pstrNS = m$.newVarRef("pstrNS",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Kill this one lock record
    //<< ;
    //<< ; Params: pYFORMHeader  : The YFORM of the header
    //<< ;         pYFORMLine    : The YFORM of the lines (grid)
    //<< ;         pstrKeys      : The keys of the locked record (K1_,_K2_ ... _ Kn)
    //<< ;         pYUSER        : The YUSER (defaults to current YUSER)
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 05-May-2006   SS      SR14508: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strNS
    mVar strNS = m$.var("strNS");
    m$.newVar(strNS);
    //<< 
    //<< set strNS = $select(pstrNS="":$zutil(5),1:pstrNS)
    strNS.set(m$.Fnc.$select(mOp.Equal(pstrNS.get(),""),m$.Fnc.$zutil(5),1,pstrNS.get()));
    //<< 
    //<< if pYUSER="" set pYUSER = $get(YUSER)
    if (mOp.Equal(pYUSER.get(),"")) {
      pYUSER.set(m$.Fnc.$get(m$.var("YUSER")));
    }
    //<< if pblnPrefix $$$AddCompany(pstrKeys,pYFORMLine)
    if (mOp.Logical(pblnPrefix.get())) {
      $$$AddCompany(m$,pstrKeys,pYFORMLine);
    }
    //<< 
    //<< kill ^CacheTempMultiLocks(strNS,pYUSER,pYFORMHeader,pYFORMLine,pstrKeys)
    m$.var("^CacheTempMultiLocks",strNS.get(),pYUSER.get(),pYFORMHeader.get(),pYFORMLine.get(),pstrKeys.get()).kill();
    //<< kill ^CacheTempMultiLock(pYFORMHeader,pYFORMLine,pstrKeys,strNS,pYUSER)
    m$.var("^CacheTempMultiLock",pYFORMHeader.get(),pYFORMLine.get(),pstrKeys.get(),strNS.get(),pYUSER.get()).kill();
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetLockIds(pidForm,pidGrid,pstrUser)
  public Object GetLockIds(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidGrid = m$.newVarRef("pidGrid",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrUser = m$.newVarRef("pstrUser",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get all the lock ids for the current user/form/grid
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Aug-2009   GRF     SR16544: Removed Order Macros
    //<< ; 12-Apr-2007   RPW     SR15513: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strKeys
    mVar strKeys = m$.var("strKeys");
    m$.newVar(strKeys);
    //<< 
    //<< kill ^CacheTempMultiLockIds(pstrUser,YUCI)
    m$.var("^CacheTempMultiLockIds",pstrUser.get(),m$.var("YUCI").get()).kill();
    //<< set strKeys = ""
    strKeys.set("");
    //<< for {
    for (;true;) {
      //<< set strKeys = $order(^CacheTempMultiLocks(YUCI,pstrUser,pidForm,pidGrid,strKeys))
      strKeys.set(m$.Fnc.$order(m$.var("^CacheTempMultiLocks",m$.var("YUCI").get(),pstrUser.get(),pidForm.get(),pidGrid.get(),strKeys.get())));
      //<< quit:strKeys=""
      if (mOp.Equal(strKeys.get(),"")) {
        break;
      }
      //<< 
      //<< set ^CacheTempMultiLockIds(pstrUser,YUCI,strKeys)=""
      m$.var("^CacheTempMultiLockIds",pstrUser.get(),m$.var("YUCI").get(),strKeys.get()).set("");
    }
    //<< }
    //<< quit
    return null;
  }

//<< 
//<< 
}
