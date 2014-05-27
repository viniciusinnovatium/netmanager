//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUtilError
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:26
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; Common Utilities for Error processing
//<< ;
//<< ; See also :
//<< ;   COMUtilDate     Date/Time Utilities
//<< ;   COMUtilStr      String Manipulation
//<< ;   COMUtilGlo      Global Manipulation
//<< ;   COMUtilForm     @netManager Form Utilities
//<< ;   COMUtilClass    @netManager Class Utilities
//<< ;
//<< ; History:
//<< ; 30-Mar-2007   GRF     SR12293: Moved GetDataBaseAdministrator to COMUtilUser
//<< ; 23-Feb-2005   GRF     Created; moved some routines from COMUtils
//<< ;-------------------------------------------------------------------------------
//<< #include COMConst
import include.COMConst;
import include.COMSYS;
//<< #include WWWConst
import include.WWWConst;
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

//<< COMUtilError
public class COMUtilError extends mClass {

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
    _COMUtilError();
  }

  public void _COMUtilError() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^COMUtilError("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< 
  //<< ReturnError(plstParams="")
  public Object ReturnError(Object ... _p) {
    mVar plstParams = m$.newVarRef("plstParams",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Error log tracking for front end processes
    //<< ; Creates a Info error message on screen
    //<< ;
    //<< ; plstParams        a strStatus error message
    //<< ;
    //<< ; History:
    //<< ; 13-Dec-2006   JW&SH   SR****: Switched condition.  '$$$InHyperEvent is incorrect.
    //<< ; 10-Aug-2006   JW      SR13594: Added Alert when in hyperevent
    //<< ; 07-Sep-2005   shobby  SR12761/SR13438: Ignore if in a hyperevent, will crash with Javascript errors.
    //<< ;                       The error should still be reported during the submit.
    //<< ; 09-Jun-2005   PK/PO   Return JS if hyper-event. Reverted
    //<< ; 05-Jan-2003   Paul K  Created.
    //<< ;-------------------------------------------------------------------------------
    //<< ;if '$get(%("%KEY","HYPEREVENT")) {
    //<< 
    //<< ; TODO : WWWINFO already checks for $$$InHyperEvent so don't need to check again here.
    //<< ;        $$$Alert includes $$DecodeError call so entry in WWWINFO will convert list to
    //<< ;        string and then check that string doesn't need further conversion.
    //<< ;        Should have clear definition of what form parameter should be in and process
    //<< ;        accordingly - possibly separate entry points.                <GRF>
    //<< 
    //<< $$$LogR("ReturnError",plstParams)
    $$$LogR(m$,"ReturnError",plstParams);
    //<< 
    //<< if $$$InHyperEvent {          //SR13594
    if (mOp.Logical(include.COMSYS.$$$InHyperEvent(m$))) {
      //<< $$$Alert(plstParams)      //SR13594
      include.COMSYS.$$$Alert(m$,plstParams);
    }
    //<< 
    //<< } else {
    else {
      //<< do ^WWWINFO($$DecodeError(plstParams))   ; FIXME : WWWINFO tests $$$InHyperEvent and performs $$$Alert
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("DecodeError",plstParams.get()));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< RaiseError(plstParams="",pstrForm,pidKey)
  public Object RaiseError(Object ... _p) {
    mVar plstParams = m$.newVarRef("plstParams",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Error log tracking for back end processes, creates a reminder text for all
    //<< ; system and database administators
    //<< ;
    //<< ; History:
    //<< ; 30-Mar-2007   GRF     SR12293: Moved GetDataBaseAdministrator to COMUtilUser
    //<< ; 29-Jun-2005   JW      Moved null checks to top
    //<< ;-------------------------------------------------------------------------------
    //<< new strText,lstUsers,numUsers,lngUserLoop,strUser
    mVar strText = m$.var("strText");
    mVar lstUsers = m$.var("lstUsers");
    mVar numUsers = m$.var("numUsers");
    mVar lngUserLoop = m$.var("lngUserLoop");
    mVar strUser = m$.var("strUser");
    m$.newVar(strText,lstUsers,numUsers,lngUserLoop,strUser);
    //<< 
    //<< if ($get(pstrForm)'="") && ($get(pidKey)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(pstrForm),"")) && (mOp.NotEqual(m$.Fnc.$get(pidKey),""))) {
      //<< do RemoveError(pstrForm,pidKey)
      m$.Cmd.Do("RemoveError",pstrForm.get(),pidKey.get());
      //<< set strText  = $$DecodeError(plstParams)
      strText.set(m$.fnc$("DecodeError",plstParams.get()));
      //<< 
      //<< set lstUsers = $$GetDataBaseAdministrator^COMUtilUser()        ; SR12293
      lstUsers.set(m$.fnc$("COMUtilUser.GetDataBaseAdministrator"));
      //<< set numUsers = $listlength(lstUsers)
      numUsers.set(m$.Fnc.$listlength(lstUsers.get()));
      //<< 
      //<< for lngUserLoop=1:1:numUsers {
      for (lngUserLoop.set(1);(mOp.LessOrEqual(lngUserLoop.get(),numUsers.get()));lngUserLoop.set(mOp.Add(lngUserLoop.get(),1))) {
        //<< set strUser = $listget(lstUsers,lngUserLoop)
        strUser.set(m$.Fnc.$listget(lstUsers.get(),lngUserLoop.get()));
        //<< set ^WWWWV(YM,strUser,$piece($horolog,",",1),pstrForm,pidKey,1) = $piece($horolog,",",1)_Y_$piece($horolog,",",2)_Y_""_Y_strText
        m$.var("^WWWWV",m$.var("YM").get(),strUser.get(),m$.Fnc.$piece(m$.Fnc.$horolog(),",",1),pstrForm.get(),pidKey.get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$horolog(),",",1),m$.var("Y").get()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2)),m$.var("Y").get()),""),m$.var("Y").get()),strText.get()));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< RemoveError(pstrForm,pidKey)
  public Object RemoveError(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Removes user errors from the @Net error log.
    //<< ; removes all reminders for all users for a given form and key
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 30-Mar-2007   GRF     SR12293: Moved GetDataBaseAdministrator to COMUtilUser
    //<< ; 29-Jun-2005   JW      Added null checks. Removed blnFound completely
    //<< ; 30-Mar-2004   Paul K  Removes all instances, not just the first one.
    //<< ;-------------------------------------------------------------------------------
    //<< new dteErrorDate,lstUsers,strUser,lngUserLoop,numUsers
    mVar dteErrorDate = m$.var("dteErrorDate");
    mVar lstUsers = m$.var("lstUsers");
    mVar strUser = m$.var("strUser");
    mVar lngUserLoop = m$.var("lngUserLoop");
    mVar numUsers = m$.var("numUsers");
    m$.newVar(dteErrorDate,lstUsers,strUser,lngUserLoop,numUsers);
    //<< 
    //<< quit:($get(pstrForm)="")||($get(pidKey)="")
    if ((mOp.Equal(m$.Fnc.$get(pstrForm),"")) || (mOp.Equal(m$.Fnc.$get(pidKey),""))) {
      return null;
    }
    //<< 
    //<< set dteErrorDate = ""
    dteErrorDate.set("");
    //<< ;set blnFound     = $$$NO
    //<< set lstUsers     = $$GetDataBaseAdministrator^COMUtilUser()      ; SR12293
    lstUsers.set(m$.fnc$("COMUtilUser.GetDataBaseAdministrator"));
    //<< set numUsers     = $listlength(lstUsers)
    numUsers.set(m$.Fnc.$listlength(lstUsers.get()));
    //<< 
    //<< for lngUserLoop=1:1:numUsers {
    for (lngUserLoop.set(1);(mOp.LessOrEqual(lngUserLoop.get(),numUsers.get()));lngUserLoop.set(mOp.Add(lngUserLoop.get(),1))) {
      //<< set strUser = $listget(lstUsers,lngUserLoop)
      strUser.set(m$.Fnc.$listget(lstUsers.get(),lngUserLoop.get()));
      //<< for {
      for (;true;) {
        //<< set dteErrorDate = $order(^WWWWV(YM,strUser,dteErrorDate))
        dteErrorDate.set(m$.Fnc.$order(m$.var("^WWWWV",m$.var("YM").get(),strUser.get(),dteErrorDate.get())));
        //<< quit:dteErrorDate=""
        if (mOp.Equal(dteErrorDate.get(),"")) {
          break;
        }
        //<< 
        //<< kill ^WWWWV(YM,strUser,dteErrorDate,pstrForm,pidKey,1)
        m$.var("^WWWWV",m$.var("YM").get(),strUser.get(),dteErrorDate.get(),pstrForm.get(),pidKey.get(),1).kill();
      }
    }
    //<< 
    //<< ;if $data(^WWWWV(YM,strUser,dteErrorDate,pstrForm,pidKey,1)) {
    //<< ;   set blnFound=$$$YES
    //<< ;   kill ^WWWWV(YM,strUser,dteErrorDate,pstrForm,pidKey,1)
    //<< ;}
    //<< ;quit:blnFound
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DecodeError(plstParams="",pblnDecode=$$$NO,pidLang="")
  public Object DecodeError(Object ... _p) {
    mVar plstParams = m$.newVarRef("plstParams",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pblnDecode = m$.newVarRef("pblnDecode",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Decodes a listbuild language text list into the appropriate string
    //<< ;
    //<< ; N.B. don't pass through more than 9 extra params
    //<< ;
    //<< ; Params:
    //<< ; plstParams    List or String  contains a list of: Error No,Param1,Param2,...Param9
    //<< ;
    //<< ; History:
    //<< ; 09-Sep-2008   shobby  BR014979: Don't allow pidLang to change the system wide setting.
    //<< ; 05-Jan-2007   GRF     SR15338: $$IsList will invalidly treat strings composed of
    //<< ;                       string and list as a list.  This will cause problems if
    //<< ;                       $list... functions are used.
    //<< ; 03-Jan-2007   GRF     SR15338: Recognise possible leading zero-space
    //<< ; 22-Sep-2005   Steve S Allow override language
    //<< ; 24-Jun-2005   RobertW SR12690: Removed this as it's causing HTML issues with \'s.
    //<< ; 05-Feb-2004   PK      Try and convert the text if not a list.
    //<< ; 15-May-2003   PK      Checked to see if error is a list before decoding.
    //<< ; 15-Jan-2003   PK      Created(Commented)
    //<< ;-------------------------------------------------------------------------------
    //<< new numParams,strText,lngLoop,strParam
    mVar numParams = m$.var("numParams");
    mVar strText = m$.var("strText");
    mVar lngLoop = m$.var("lngLoop");
    mVar strParam = m$.var("strParam");
    m$.newVar(numParams,strText,lngLoop,strParam);
    //<< 
    //<< $$$DecomposeStatus(plstParams)   ; strip zero-space prefix   SR15338
    include.COMSYS.$$$DecomposeStatus(m$,plstParams);
    //<< 
    //<< ; Temp? code to handle older $$$NO_$listbuild(idErrorNo) strings   ; SR15338
    //<< if $extract(plstParams,1)="0" set plstParams = $extract(plstParams,2,$length(plstParams))
    if (mOp.Equal(m$.Fnc.$extract(plstParams.get(),1),"0")) {
      plstParams.set(m$.Fnc.$extract(plstParams.get(),2,m$.Fnc.$length(plstParams.get())));
    }
    //<< 
    //<< if $get(SPRACHE)="" do ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< if (pidLang'="") {
    if ((mOp.NotEqual(pidLang.get(),""))) {
      //<< new SPRACHE               ; BR014979
      mVar SPRACHE = m$.var("SPRACHE");
      m$.newVar(SPRACHE);
      //<< set SPRACHE = pidLang
      SPRACHE.set(pidLang.get());
    }
    //<< }
    //<< 
    //<< if $$IsList^COMUtils(plstParams) {
    if (mOp.Logical(m$.fnc$("COMUtils.IsList",plstParams.get()))) {
      //<< set numParams   = $listlength(plstParams)
      numParams.set(m$.Fnc.$listlength(plstParams.get()));
      //<< set strParam    = $listget(plstParams,1)
      strParam.set(m$.Fnc.$listget(plstParams.get(),1));
      //<< set strText     = $$^WWWTEXT(strParam)  ; if param passed through, get message from WWWTEXT
      strText.set(m$.fnc$("WWWTEXT.main",strParam.get()));
      //<< 
      //<< for lngLoop=1:1:(numParams-1) {                 ; loop through the extra params, replacing the %1 etc with the param
      for (lngLoop.set(1);(mOp.LessOrEqual(lngLoop.get(),(mOp.Subtract(numParams.get(),1))));lngLoop.set(mOp.Add(lngLoop.get(),1))) {
        //<< for {
        for (;true;) {
          //<< quit:$find(strText,"%"_lngLoop)=0                           ; quit if can't find any more occurances
          if (mOp.Equal(m$.Fnc.$find(strText.get(),mOp.Concat("%",lngLoop.get())),0)) {
            break;
          }
          //<< quit:$find($listget(plstParams,lngLoop+1),"%"_lngLoop)'=0   ; quit if param contains the string "%"
          if (mOp.NotEqual(m$.Fnc.$find(m$.Fnc.$listget(plstParams.get(),mOp.Add(lngLoop.get(),1)),mOp.Concat("%",lngLoop.get())),0)) {
            break;
          }
          //<< 
          //<< set strText = $piece(strText,"%"_lngLoop,1)_$listget(plstParams,lngLoop+1)_$piece(strText,"%"_lngLoop,2,99)
          strText.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(strText.get(),mOp.Concat("%",lngLoop.get()),1),m$.Fnc.$listget(plstParams.get(),mOp.Add(lngLoop.get(),1))),m$.Fnc.$piece(strText.get(),mOp.Concat("%",lngLoop.get()),2,99)));
        }
      }
      //<< }
      //<< }
      //<< set plstParams = $listget(plstParams,1)
      plstParams.set(m$.Fnc.$listget(plstParams.get(),1));
    }
    //<< 
    //<< } else {
    else {
      //<< ;   NOTE : Can return spurious error messages if already expanded
      //<< ;          since space delimited sub-strings are checked for a
      //<< ;          matching idError : e.g. "Line Number 1 requires..."
      //<< ;          matches ^WWW009(0,1,"EN",1) = "User-Identification"
      //<< if pidLang="" {
      if (mOp.Equal(pidLang.get(),"")) {
        //<< set strText = $$^WWWTEXT(plstParams)
        strText.set(m$.fnc$("WWWTEXT.main",plstParams.get()));
      }
      //<< } else {
      else {
        //<< set strText = $$^WWWTEXT(plstParams,,,pidLang)
        strText.set(m$.fnc$("WWWTEXT.main",plstParams.get(),null,null,pidLang.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; 01-Jul-2005   RobertW     SR12690: Removed this line it's not needed
    //<< ;if pblnDecode set strText=$zcvt(strText,"o","JS")
    //<< 
    //<< quit strText
    return strText.get();
  }

  //<< 
  //<< 
  //<< DecodeCacheError(pobjStatus="",pblnIncludeLastError=$$$NO)
  public Object DecodeCacheError(Object ... _p) {
    mVar pobjStatus = m$.newVarRef("pobjStatus",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pblnIncludeLastError = m$.newVarRef("pblnIncludeLastError",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Decode an internal cache status string
    //<< ;
    //<< ; e.g. where pobjStatus is created by :
    //<< ;  set pobjStatus = $system.Status.Error(5001,"Invalid StateId entered")
    //<< ; err(1) will contain "ERROR #5001: Invalid StateId entered"
    //<< ;
    //<< ;   Can have nested errors by using $system.Status.AppendStatus
    //<< ;   e.g.
    //<< ;  set sc  = $system.Status.Error(5001,"Message1")
    //<< ;  set sc2 = $system.Status.Error(5001,"Message2")
    //<< ;  set sc  = $system.Status.AppendStatus(sc,sc2)
    //<< ;
    //<< ;   DecodeCacheError returns just the first error
    //<< ;  ERROR #5001: Message1
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Aug-2012 shobby       SR18078: Corrected duplication of error message when there
    //<< ;                               is only one error.
    //<< ; 18-Aug-2010 Pablo G/PPP  SR17505: Added Other Error Messages
    //<< ; 07-Jul-2005 Steve S  SR10421: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrErr,idLastErr,strLastError
    mVar arrErr = m$.var("arrErr");
    mVar idLastErr = m$.var("idLastErr");
    mVar strLastError = m$.var("strLastError");
    m$.newVar(arrErr,idLastErr,strLastError);
    //<< 
    //<< do $System.Status.DecomposeStatus(pobjStatus,.arrErr)
    m$.getSystem().getStatus().DecomposeStatus(pobjStatus.get(),arrErr);
    //<< 
    //<< set strLastError = ""
    strLastError.set("");
    //<< 
    //<< //SR17505
    //<< if (pblnIncludeLastError) {
    if (mOp.Logical((pblnIncludeLastError.get()))) {
      //<< set idLastErr = $order(arrErr(""),-1)
      idLastErr.set(m$.Fnc.$order(arrErr.var(""),mOp.Negative(1)));
      //<< ;18078 if idLastErr {
      //<< if idLastErr>1 {                                    ;18078
      if (mOp.Greater(idLastErr.get(),1)) {
        //<< if $get(arrErr(idLastErr,"param",1))'="" {
        if (mOp.NotEqual(m$.Fnc.$get(arrErr.var(idLastErr.get(),"param",1)),"")) {
          //<< set strLastError = " - "_$get(arrErr(idLastErr,"param",1))
          strLastError.set(mOp.Concat(" - ",m$.Fnc.$get(arrErr.var(idLastErr.get(),"param",1))));
        }
        //<< } else {
        else {
          //<< set strLastError = " - "_$get(arrErr(idLastErr,"caller"))
          strLastError.set(mOp.Concat(" - ",m$.Fnc.$get(arrErr.var(idLastErr.get(),"caller"))));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit $select($get(arrErr(1))'="":arrErr(1)_strLastError,1:$get(arrErr))
    return m$.Fnc.$select(mOp.NotEqual(m$.Fnc.$get(arrErr.var(1)),""),mOp.Concat(arrErr.var(1).get(),strLastError.get()),1,m$.Fnc.$get(arrErr));
  }

  //<< 
  //<< 
  //<< ISStatusToDLStatus(sc,pblnFullMessage=$$$YES)
  public Object ISStatusToDLStatus(Object ... _p) {
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnFullMessage = m$.newVarRef("pblnFullMessage",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Translate an Intersystems Status to a Disclinc Status
    //<< ;
    //<< ; e.g. set sc = $system.Status.Error(5395,"alPKG","TxName","Subr^COMRoutine()")
    //<< ;
    //<< ; will return an error sc of the form;
    //<< ;   When strStatus is "0 "_$lb($lb(code,param,param,....),$lb(code,param,param,....),...)
    //<< ;                                ^^^^ 1st Error ^^^^         ^^^^ 2nd Error ^^^^       etc.
    //<< ;
    //<< ;
    //<< ; This subroutine will return the first error as a DiscLinc strStatus with the text as
    //<< ;
    //<< ; ERROR #5395: Invalid routine to call from class 'alPKG' to method 'TxName' via label 'Subr^COMRoutine()'
    //<< ;---------------------------------------
    //<< ;
    //<< ; Inputs:
    //<< ;       sc                  Cache standard status
    //<< ;       pblnFullMessage     What to include in strStatus
    //<< ;           $$$NO  : Uses just strXXX from strError = "ERROR #"_strAAA_": "_strXXX
    //<< ;           $$$YES : Uses whole strError
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 30-Jul-2013   SCR     CORE-194: Always remove "ERROR #5001"
    //<< ; 20-Sep-2010   PPP     SR17505:1 Bug Fix, Pass parameter through to DecodeCacheError
    //<< ; 18-Aug-2010   Pablo G/PPP SR17505: Added Other Error Messages
    //<< ; 24-Sep-2008   GRF     SR15903: Missing () around 2nd clause (removed redundant
    //<< ;                            not zero check); standard variable naming;
    //<< ;                            clarify; early exit.
    //<< ; 15-Sep-2008   HQN     SR15903: Added option to strip default object error code
    //<< ; 08-May-2008   GRF     SR15717: Prepend "0 " with MakeStatus
    //<< ; 10-Jul-2007   RPW     SR15571: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strError,strStatus
    mVar strError = m$.var("strError");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strError,strStatus);
    //<< 
    //<< if sc=$$$YES quit $$$YES         ; no error - shortcut
    if (mOp.Equal(sc.get(),include.COMSYS.$$$YES(m$))) {
      return include.COMSYS.$$$YES(m$);
    }
    //<< 
    //<< set strStatus = ""
    strStatus.set("");
    //<< //set strError  = $$DecodeCacheError(sc,$$$YES) //SR17505:1
    //<< set strError  = $$DecodeCacheError(sc,pblnFullMessage)  //SR17505:1
    strError.set(m$.fnc$("DecodeCacheError",sc.get(),pblnFullMessage.get()));
    //<< 
    //<< if strError'="" {
    if (mOp.NotEqual(strError.get(),"")) {
      //<< if (pblnFullMessage=$$$NO) && $find(strError,"ERROR #") {
      if ((mOp.Equal(pblnFullMessage.get(),include.COMSYS.$$$NO(m$))) && mOp.Logical(m$.Fnc.$find(strError.get(),"ERROR #"))) {
        //<< set strError = $extract(strError,$find(strError,": ",$length("ERROR #")),$length(strError))
        strError.set(m$.Fnc.$extract(strError.get(),m$.Fnc.$find(strError.get(),": ",m$.Fnc.$length("ERROR #")),m$.Fnc.$length(strError.get())));
      }
      //<< }
      //<< set:strError["#5001:" strError  = $piece(strError,"#5001:",2,99) ; CORE-194
      if (mOp.Contains(strError.get(),"#5001:")) {
        strError.set(m$.Fnc.$piece(strError.get(),"#5001:",2,99));
      }
      //<< set strStatus = $$$MakeStatus("WWW00070",strError)     ; "%1"
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"WWW00070",strError));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< ISStatusToDLStatusAllMessages(sc)
  public Object ISStatusToDLStatusAllMessages(Object ... _p) {
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Translate All Intersystems Status to a Disclinc Status
    //<< ;
    //<< ; Inputs:
    //<< ;       sc                  Cache standard status
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Jul-2010   PPP     SR17465: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrErr,intCnt,strError,strStatus
    mVar arrErr = m$.var("arrErr");
    mVar intCnt = m$.var("intCnt");
    mVar strError = m$.var("strError");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(arrErr,intCnt,strError,strStatus);
    //<< 
    //<< if sc=$$$YES quit $$$YES         ; no error - shortcut
    if (mOp.Equal(sc.get(),include.COMSYS.$$$YES(m$))) {
      return include.COMSYS.$$$YES(m$);
    }
    //<< 
    //<< set (strStatus,strError) = ""
    strStatus.set("");
    strError.set("");
    //<< do $System.Status.DecomposeStatus(sc,.arrErr)
    m$.getSystem().getStatus().DecomposeStatus(sc.get(),arrErr);
    //<< 
    //<< set intCnt = 0
    intCnt.set(0);
    //<< for {
    for (;true;) {
      //<< set intCnt = $order(arrErr(intCnt))
      intCnt.set(m$.Fnc.$order(arrErr.var(intCnt.get())));
      //<< quit:intCnt=""
      if (mOp.Equal(intCnt.get(),"")) {
        break;
      }
      //<< 
      //<< set strError = strError_" <"_$get(arrErr(intCnt,"param",1))_"> "
      strError.set(mOp.Concat(mOp.Concat(mOp.Concat(strError.get()," <"),m$.Fnc.$get(arrErr.var(intCnt.get(),"param",1))),"> "));
    }
    //<< }
    //<< 
    //<< if strError'="" set strStatus = $$$MakeStatus("WWW00070",strError)     ; "%1"
    if (mOp.NotEqual(strError.get(),"")) {
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"WWW00070",strError));
    }
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
//<< 
}
