//*****************************************************************************
//** TASC - ALPHALINC - MAC COMTransaction
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:10
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

//<< COMTransaction
public class COMTransaction extends mClass {

  //<< 
  //<< #define LogR(%1,%2) ;
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
    _COMTransaction();
  }

  public void _COMTransaction() {
    Example();
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^COMTransaction("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< Example private
  public void Example() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Post Button on form XXX calls "Perform^COMTransaction(YFORM,YKEY,Post^XXX(pstrKey))"
    //<< ;
    //<< ; Post^XXX determines if processing can continue and then continues to a command
    //<< ;   set strStatus = $$Transaction^COMTransaction("PostTxn^XXX("""_pidXXX_""","""_objXXX_""")",$$$YES)
    //<< ;
    //<< ;   NOTE : objXXX will be the full record in this case - possible better to pass
    //<< ;          the keys and load it again if the string length could be excessive.
    //<< ;          Can't just specify variables unless we can guarantee they will exist
    //<< ;          inside Transaction^COMTransaction.
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< set strStatus=$$Transaction("Routine^Somewhere")
    strStatus.set(m$.fnc$("Transaction","Routine^Somewhere"));
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
    }
    //<< } else {
    else {
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< Transaction(pstrCode,pblnShowInfo=$$$NO)
  public Object Transaction(Object ... _p) {
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnShowInfo = m$.newVarRef("pblnShowInfo",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for transactions
    //<< ;   pstrCode        - Code to run
    //<< ;   pstrStatus      - Variable to return the status.  List format.
    //<< ;   pblnShowInfo    - If this variable is set.  Display the info screen,
    //<< ;                     validation type errors NOT cache errors.
    //<< ;   pstrParamN      - Override parameters to pass to the error display when
    //<< ;                     forcing an error message different from the calculated one.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 01-Feb-2008   shobby  SRBR014697: Return a fail message if transaction crashed and rolled back.
    //<< ; 18-Mar-2006   RPW/PO  Added check for whether already inside error handler
    //<< ; 04-May-2005   shobby  Created SR11875
    //<< ;-------------------------------------------------------------------------------
    //<< new intParameters,strStatus,trap
    mVar intParameters = m$.var("intParameters");
    mVar strStatus = m$.var("strStatus");
    mVar trap = m$.var("trap");
    m$.newVar(intParameters,strStatus,trap);
    //<< 
    //<< $$$LogR("Transaction",pstrCode)
    $$$LogR(m$,"Transaction",pstrCode);
    //<< set trap = $ztrap
    trap.set(m$.Fnc.$ztrap());
    //<< 
    //<< set $ztrap = "TransactionError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("TransactionError");
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< ;***************************************
    //<< $$$LogRx("")
    $$$LogRx(m$,"");
    //<< $$$LogRx("------------- TSTART vvvvvvvvv")
    $$$LogRx(m$,"------------- TSTART vvvvvvvvv");
    //<< $$$LogRx("")
    $$$LogRx(m$,"");
    //<< tstart
    //<< ;***************************************                    ; *** EXECUTE ***
    //<< 
    //<< xecute "set strStatus=$$"_pstrCode
    m$.Cmd.Xecute(mOp.Concat("set strStatus=$$",pstrCode.get()));
    //<< 
    //<< ;***************************************
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< if $tlevel>0 tcommit
      if (mOp.Greater(m$.Fnc.$tlevel(),0)) {
      }
      //<< $$$LogRx("")
      $$$LogRx(m$,"");
      //<< $$$LogRx("------------- TCOMMIT ^^^^^^^^")
      $$$LogRx(m$,"------------- TCOMMIT ^^^^^^^^");
      //<< $$$LogRx("")
      $$$LogRx(m$,"");
    }
    //<< } else {
    else {
      //<< trollback
      //<< $$$LogRx("")
      $$$LogRx(m$,"");
      //<< $$$LogRx("------------- TROLLBACK ^^^^^^^^")
      $$$LogRx(m$,"------------- TROLLBACK ^^^^^^^^");
      //<< $$$LogRx("")
      $$$LogRx(m$,"");
      //<< if pblnShowInfo {
      if (mOp.Logical(pblnShowInfo.get())) {
        //<< do ReturnError^COMUtilError(strStatus)
        m$.Cmd.Do("COMUtilError.ReturnError",strStatus.get());
      }
    }
    //<< }
    //<< }
    //<< ;***************************************
    //<< 
    //<< set $ztrap=trap
    $ztrap.set(trap.get());
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< ; FIXME : Following a <SUBSCRIPT> error elsewhere we are getting an <UNDEFINED>
  //<< ;         error in the line     xecute:trap'="" "do "_trap
  //<< ;         where the variable trap does not exist.
  //<< ;         NOTE : The tag Transaction is called once with trap containing the
  //<< ;         correct tag^Routine but then TransactionError is called twice - once
  //<< ;         with trap not defined and then with the value from Transaction.
  //<< ;
  //<< ;   Interim fix - add $get() around trap - find what is causing it
  //<< ;   [save on INReq calling CreateReceiptTxn^INTRNRec which generated an error while trying to save "INRECLine"]
  //<< 
  //<< //TransactionError  ;Internal Tag
  //<< TransactionError()  ;Internal Tag
  public Object TransactionError(Object ... _p) {
    //<< new strError
    mVar strError = m$.var("strError");
    m$.newVar(strError);
    //<< 
    //<< $$$LogR("TransactionError","")
    $$$LogR(m$,"TransactionError","");
    //<< 
    //<< set strError=$zerror
    strError.set(m$.Fnc.$zerror());
    //<< set $ztrap=$get(trap)
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set(m$.Fnc.$get(m$.var("trap")));
    //<< ;***************************************
    //<< trollback
    //<< ;***************************************
    //<< set $zerror=strError
    mVar $zerror = m$.var("$zerror");
    $zerror.set(strError.get());
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   USE TO DEBUG IF ERROR IS OBSCURED
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;do $zu(139,1) set ^zzERR($i(^zzERR)) = $horolog_":"_$get(strError)_"<" do $zu(139,0)
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< ;xecute:trap'="" "do "_trap
    //<< xecute:$get(trap)'="" "do "_trap
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("trap")),"")) {
      m$.Cmd.Xecute(mOp.Concat("do ",m$.var("trap").get()));
    }
    //<< ;set strStatus = "ROLLBACK"                         ;BR014697
    //<< set strStatus = $$$MakeStatus("ROLLBACK:"_strError) ;BR014697
    mVar strStatus = m$.var("strStatus");
    strStatus.set(include.COMSYS.$$$MakeStatus(m$,mOp.Concat("ROLLBACK:",strError.get())));
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< Perform(pstrForm,pstrKeyPerform,pstrCode,pstrLangText,&pstrStatus)
  public Object Perform(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrKeyPerform = m$.newVarRef("pstrKeyPerform",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrLangText = m$.newVarRef("pstrLangText",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pstrStatus = m$.newVarRef("pstrStatus",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Execute particular code for a particular record.
    //<< ;
    //<< ; Params: pstrForm      Form from which transaction is performed (YDATEI not available when WWWMANU calls this code).
    //<< ;         pstrKey       Record key.
    //<< ;         pstrCode      Code to execute, either Procedure^Routine or $$Procedure^Routine. Argument list is optional as well as ().
    //<< ;         pstrLangText  Language Text id for message if not able to raise semaphore for record.
    //<< ;
    //<< ; ByRefs: pstrStatus - result of code executed.
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 03-Feb-2010   GRF     SR17160: ReturnError^COMUtilError checks $$$InHyperEvent
    //<< ; 14-Mar-2006   PO      SR14409: Include cachetemp semaphore global to ensure
    //<< ;                           one transaction at a time.  ALSO change from
    //<< ;                           returning status via quit to return byRef.
    //<< ; 05-Jan-2006   PO      SR14118: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set $ztrap = "PerformError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("PerformError");
    //<< 
    //<< new blnGotLock,strClassPerform
    mVar blnGotLock = m$.var("blnGotLock");
    mVar strClassPerform = m$.var("strClassPerform");
    m$.newVar(blnGotLock,strClassPerform);
    //<< 
    //<< $$$LogR("Perform",$get(pstrCode)_"<"_$get(pstrLangText))
    $$$LogR(m$,"Perform",mOp.Concat(mOp.Concat(m$.Fnc.$get(pstrCode),"<"),m$.Fnc.$get(pstrLangText)));
    //<< 
    //<< set pstrStatus = $$$NO
    pstrStatus.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< quit:(pstrForm="")||(pstrKeyPerform="")||(pstrCode="")
    if ((mOp.Equal(pstrForm.get(),"")) || (mOp.Equal(pstrKeyPerform.get(),"")) || (mOp.Equal(pstrCode.get(),""))) {
      return null;
    }
    //<< 
    //<< set blnGotLock = $$$NO
    blnGotLock.set(include.COMSYS.$$$NO(m$));
    //<< set strClassPerform   = $$$WWW120ClassUsedInForm($get(^WWW120(0,pstrForm,1)))
    strClassPerform.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,pstrForm.get(),1))));
    //<< 
    //<< if strClassPerform'="" {
    if (mOp.NotEqual(strClassPerform.get(),"")) {
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< lock ^Semaphore(strClassPerform,pstrKeyPerform):2
      m$.Cmd.Lock(m$.var("^Semaphore",strClassPerform.get(),pstrKeyPerform.get()),2);
      //<< 
      //<< if $test {
      if (mOp.Logical(m$.Fnc.$test())) {
        //<< set blnGotLock = $case($increment(^CacheTempSemaphore(strClassPerform,pstrKeyPerform)),1:$$$YES,:$$$NO)
        blnGotLock.set(m$.Fnc.$case(m$.Fnc.$increment(m$.var("^CacheTempSemaphore",strClassPerform.get(),pstrKeyPerform.get())),1,include.COMSYS.$$$YES(m$),include.COMSYS.$$$NO(m$)));
      }
      //<< }
      //<< 
      //<< lock -^Semaphore(strClassPerform,pstrKeyPerform)
      m$.Cmd.Unlock(m$.var("^Semaphore",strClassPerform.get(),pstrKeyPerform.get()));
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< 
      //<< if blnGotLock {
      if (mOp.Logical(blnGotLock.get())) {
        //<< ;***************************************                    ; *** EXECUTE ***
        //<< if $extract(pstrCode,1,2) = "$$" {
        if (mOp.Equal(m$.Fnc.$extract(pstrCode.get(),1,2),"$$")) {
          //<< xecute "set pstrStatus = "_pstrCode
          m$.Cmd.Xecute(mOp.Concat("set pstrStatus = ",pstrCode.get()));
        }
        //<< } else {
        else {
          //<< xecute "do "_pstrCode
          m$.Cmd.Xecute(mOp.Concat("do ",pstrCode.get()));
          //<< set pstrStatus = $$$OK
          pstrStatus.set(include.COMSYS.$$$OK(m$));
        }
        //<< }
        //<< ;***************************************
        //<< kill ^CacheTempSemaphore(strClassPerform,pstrKeyPerform)
        m$.var("^CacheTempSemaphore",strClassPerform.get(),pstrKeyPerform.get()).kill();
      }
      //<< 
      //<< } else {
      else {
        //<< $$$LogR("Perform","CacheTempSemaphore stopped processing")
        $$$LogR(m$,"Perform","CacheTempSemaphore stopped processing");
        //<< 
        //<< ;          SR17160 vvv
        //<< ; Should never see this if return from transaction processing via quits.
        //<< if $get(pstrLangText)="" set pstrLangText="WWW00041"  ; "Unable to obtain lock."
        if (mOp.Equal(m$.Fnc.$get(pstrLangText),"")) {
          pstrLangText.set("WWW00041");
        }
        //<< do ReturnError^COMUtilError(pstrLangText)
        m$.Cmd.Do("COMUtilError.ReturnError",pstrLangText.get());
      }
    }
    //<< 
    //<< ;   if $$$InHyperEvent { ; Included for Supplier Payments UnPosting
    //<< ;       if $data(pstrLangText)#10 $$$Alert(pstrLangText)
    //<< ;   } else {
    //<< ;       if $data(pstrLangText)#10 do ReturnError^COMUtilError(pstrLangText)
    //<< ;   }      SR17160 ^^^
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< PerformError  ; Internal Tag
  public void PerformError() {
    //<< set $ztrap = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< 
    //<< lock -^Semaphore(strClassPerform,pstrKeyPerform)
    m$.Cmd.Unlock(m$.var("^Semaphore",m$.var("strClassPerform").get(),m$.var("pstrKeyPerform").get()));
    //<< kill ^CacheTempSemaphore(strClassPerform,pstrKeyPerform)
    m$.var("^CacheTempSemaphore",m$.var("strClassPerform").get(),m$.var("pstrKeyPerform").get()).kill();
    //<< 
    //<< $$$LogR("PerformError",$zerror)
    $$$LogR(m$,"PerformError",m$.Fnc.$zerror());
    //<< 
    //<< do ReturnError^COMUtilError($listbuild("Fin00263",$zerror)) ; "Error in Processing, Details %1"
    m$.Cmd.Do("COMUtilError.ReturnError",m$.Fnc.$listbuild("Fin00263",m$.Fnc.$zerror()));
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< ; FIXME : "p" prefixes for parameters <GRF>
  //<< TransactionUnit(pstrForm,pstrTransaction,pblnNoTControl=$$$NO,&strTError,&blnTQuit)
  public Object TransactionUnit(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrTransaction = m$.newVarRef("pstrTransaction",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnNoTControl = m$.newVarRef("pblnNoTControl",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    mVar strTError = m$.newVarRef("strTError",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar blnTQuit = m$.newVarRef("blnTQuit",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for transaction units (chain of multiple functions as one unit)
    //<< ;   pstrForm        - Form related Transaction Table
    //<< ;   pstrTransaction - Name of Transaction Unit
    //<< ;   pblnNoTControl  - Do Not Start/End Transaction Control (ie. because already done)
    //<< ;
    //<< ; By Refs:
    //<< ;   strTError       - Variable to set error flag (any value will cause rollback)
    //<< ;   blnTQuit        - Variable to stop form execution (= @net Manager variable "Q")
    //<< ;                     (ExecuteAfterSave only)
    //<< ;
    //<< ; Returns:
    //<< ;   pstrStatus      - Variable to return the status (any other value than 1 will cause rollback)
    //<< ;
    //<< ; History:
    //<< ; 07-Oct-2008   FIS     SR15947: allow set commands (ie. set Q=1)
    //<< ; 30-Sep-2008   FIS     SR15947: Changed WWWTransactionTable into WWWTransactionLine
    //<< ;                       - Sort Run Sequence by Sequence No.
    //<< ; 24-Sep-2008   FIS     Created SR15947
    //<< ;-------------------------------------------------------------------------------
    //<< new arrLines,intNo,intSeq,objTask,Q,strExec,strStatus,strTStatus
    mVar arrLines = m$.var("arrLines");
    mVar intNo = m$.var("intNo");
    mVar intSeq = m$.var("intSeq");
    mVar objTask = m$.var("objTask");
    mVar Q = m$.var("Q");
    mVar strExec = m$.var("strExec");
    mVar strStatus = m$.var("strStatus");
    mVar strTStatus = m$.var("strTStatus");
    m$.newVar(arrLines,intNo,intSeq,objTask,Q,strExec,strStatus,strTStatus);
    //<< 
    //<< set strTStatus = $$$NO
    strTStatus.set(include.COMSYS.$$$NO(m$));
    //<< set strTError = ""
    strTError.set("");
    //<< set $ztrap="TransactionUnitError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("TransactionUnitError");
    //<< 
    //<< if ($get(pstrForm) '= "")          &&
    //<< ($get(pstrTransaction) '= "")   &&
    //<< ($$$WWWTransactionActive1($get(^WWWTransaction(0,pstrForm,pstrTransaction,1))) = $$$YES) {
    if ((mOp.NotEqual(m$.Fnc.$get(pstrForm),"")) && (mOp.NotEqual(m$.Fnc.$get(pstrTransaction),"")) && (mOp.Equal(include.WWWConst.$$$WWWTransactionActive1(m$,m$.Fnc.$get(m$.var("^WWWTransaction",0,pstrForm.get(),pstrTransaction.get(),1))),include.COMSYS.$$$YES(m$)))) {
      //<< if (pblnNoTControl '= $$$YES) {
      if ((mOp.NotEqual(pblnNoTControl.get(),include.COMSYS.$$$YES(m$)))) {
        //<< set strTStatus = $$StartUnit(pstrForm,pstrTransaction)  //start transaction, set locks
        strTStatus.set(m$.fnc$("StartUnit",pstrForm.get(),pstrTransaction.get()));
      }
      //<< 
      //<< } else {
      else {
        //<< set strTStatus = $$$OK
        strTStatus.set(include.COMSYS.$$$OK(m$));
      }
      //<< }
      //<< if $$$ISOK(strTStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strTStatus))) {
        //<< //sort to sequence
        //<< set intNo=""
        intNo.set("");
        //<< for {
        for (;true;) {
          //<< set intNo = $order(^WWWTransactionLine(0,pstrForm,pstrTransaction,intNo))  //get task by task in sequence
          intNo.set(m$.Fnc.$order(m$.var("^WWWTransactionLine",0,pstrForm.get(),pstrTransaction.get(),intNo.get())));
          //<< quit:intNo=""
          if (mOp.Equal(intNo.get(),"")) {
            break;
          }
          //<< 
          //<< set objTask = $get(^WWWTransactionLine(0,pstrForm,pstrTransaction,intNo,1))
          objTask.set(m$.Fnc.$get(m$.var("^WWWTransactionLine",0,pstrForm.get(),pstrTransaction.get(),intNo.get(),1)));
          //<< set arrLines(+$$$WWWTransactionLineSequence1(objTask),intNo)=""
          arrLines.var(mOp.Positive(include.WWWConst.$$$WWWTransactionLineSequence1(m$,objTask)),intNo.get()).set("");
        }
        //<< }
        //<< //run in sequence
        //<< set intSeq=""
        intSeq.set("");
        //<< for {
        for (;true;) {
          //<< set intSeq = $order(arrLines(intSeq))
          intSeq.set(m$.Fnc.$order(arrLines.var(intSeq.get())));
          //<< quit:intSeq=""
          if (mOp.Equal(intSeq.get(),"")) {
            break;
          }
          //<< 
          //<< set intNo=""
          intNo.set("");
          //<< for {
          for (;true;) {
            //<< set intNo = $order(arrLines(intSeq,intNo))  //get task by task in sequence
            intNo.set(m$.Fnc.$order(arrLines.var(intSeq.get(),intNo.get())));
            //<< quit:intNo=""
            if (mOp.Equal(intNo.get(),"")) {
              break;
            }
            //<< 
            //<< set objTask = $get(^WWWTransactionLine(0,pstrForm,pstrTransaction,intNo,1))
            objTask.set(m$.Fnc.$get(m$.var("^WWWTransactionLine",0,pstrForm.get(),pstrTransaction.get(),intNo.get(),1)));
            //<< continue:($$$WWWTransactionLineEnabled(objTask) '= $$$YES)
            if ((mOp.NotEqual(include.WWWConst.$$$WWWTransactionLineEnabled(m$,objTask),include.COMSYS.$$$YES(m$)))) {
              continue;
            }
            //<< 
            //<< set strExec = $$$WWWTransactionLineExecute1(objTask)  //execute command (ie: $$OnAfterSave^Routine)
            strExec.set(include.WWWConst.$$$WWWTransactionLineExecute1(m$,objTask));
            //<< if $extract(strExec,1,2)="$$" {
            if (mOp.Equal(m$.Fnc.$extract(strExec.get(),1,2),"$$")) {
              //<< set strExec="set strStatus="_strExec
              strExec.set(mOp.Concat("set strStatus=",strExec.get()));
            }
            //<< 
            //<< } elseif ($extract($zconvert(strExec,"U"),1,2)="S ") || ($extract($zconvert(strExec,"U"),1,4)="SET ") {
            else if ((mOp.Equal(m$.Fnc.$extract(m$.Fnc.$zconvert(strExec.get(),"U"),1,2),"S ")) || (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$zconvert(strExec.get(),"U"),1,4),"SET "))) {
              //<< set strExec="set strStatus="_$$$OK_" "_strExec
              strExec.set(mOp.Concat(mOp.Concat(mOp.Concat("set strStatus=",include.COMSYS.$$$OK(m$))," "),strExec.get()));
            }
            //<< 
            //<< } elseif ($extract($zconvert(strExec,"U"),1,2)'="D ") && ($extract($zconvert(strExec,"U"),1,3)'="DO ") {
            else if ((mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$zconvert(strExec.get(),"U"),1,2),"D ")) && (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$zconvert(strExec.get(),"U"),1,3),"DO "))) {
              //<< set strExec="set strStatus=$$"_strExec
              strExec.set(mOp.Concat("set strStatus=$$",strExec.get()));
            }
            //<< }
            //<< if (strExec '= "") {
            if ((mOp.NotEqual(strExec.get(),""))) {
              //<< kill Q
              Q.kill();
              //<< set strStatus = $$$OK
              strStatus.set(include.COMSYS.$$$OK(m$));
              //<< ;***************************************                                 ; *** EXECUTE ***
              //<< xecute strExec
              m$.Cmd.Xecute(strExec.get());
              //<< ;***************************************
              //<< if $get(Q)=$$$QDontDelete set blnTQuit = $$$YES
              if (mOp.Equal(m$.Fnc.$get(Q),include.COMSYSWWW.$$$QDontDelete(m$))) {
                blnTQuit.set(include.COMSYS.$$$YES(m$));
              }
              //<< if '$$$ISOK(strStatus) set strTStatus=strStatus quit  //failed status  [$listbuild(0,"Error Message")]
              if (mOp.Not(include.COMSYS.$$$ISOK(m$,strStatus))) {
                strTStatus.set(strStatus.get());
                break;
              }
              //<< quit:(strTError '= "")     //set error flag [$listbuild(1,"Error Message")]
              if ((mOp.NotEqual(strTError.get(),""))) {
                break;
              }
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< if (pblnNoTControl '= $$$YES) {
        if ((mOp.NotEqual(pblnNoTControl.get(),include.COMSYS.$$$YES(m$)))) {
          //<< set strTStatus(1) = $$EndUnit(pstrForm,pstrTransaction,strTStatus,strTError)  //release locks, commit transaction
          strTStatus.var(1).set(m$.fnc$("EndUnit",pstrForm.get(),pstrTransaction.get(),strTStatus.get(),strTError.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< //valid but not active
    //<< } elseif ($get(pstrForm) '= "")                                &&
    //<< ($get(pstrTransaction) '= "")                         &&
    //<< $data(^WWWTransaction(0,pstrForm,pstrTransaction))    &&
    //<< ($$$WWWTransactionActive1($get(^WWWTransaction(0,pstrForm,pstrTransaction,1))) '= $$$YES) {
    else if ((mOp.NotEqual(m$.Fnc.$get(pstrForm),"")) && (mOp.NotEqual(m$.Fnc.$get(pstrTransaction),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^WWWTransaction",0,pstrForm.get(),pstrTransaction.get()))) && (mOp.NotEqual(include.WWWConst.$$$WWWTransactionActive1(m$,m$.Fnc.$get(m$.var("^WWWTransaction",0,pstrForm.get(),pstrTransaction.get(),1))),include.COMSYS.$$$YES(m$)))) {
      //<< set strTStatus = $$$YES
      strTStatus.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< quit strTStatus
    return strTStatus.get();
  }

  //<< 
  //<< //TransactionUnitError  ; Internal Tag
  //<< TransactionUnitError()  ; Internal Tag
  public Object TransactionUnitError(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; transaction units error handling
    //<< ;
    //<< ; History:
    //<< ; 24-Sep-2008   FIS Created SR15947
    //<< ;-------------------------------------------------------------------------------
    //<< new strError,strStatus
    mVar strError = m$.var("strError");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strError,strStatus);
    //<< 
    //<< ; FIXME : Should we follow similar error handling blocks with single exit path?
    //<< ;         They don't use goto @$ztrap.  strStatus doesn't appear to follow coding
    //<< ;         standards - needs to contain "0 "_$lb(errCode,params) or $$$YES <GRF>
    //<< 
    //<< set strError = $zerror
    strError.set(m$.Fnc.$zerror());
    //<< //==========================
    //<< if ($get(pstrForm) '= "") &&($get(pstrTransaction) '= "") && ($$$WWWTransactionTransactionControl($get(^WWWTransaction(0,pstrForm,pstrTransaction,1))) = $$$YES) {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("pstrForm")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("pstrTransaction")),"")) && (mOp.Equal(include.WWWConst.$$$WWWTransactionTransactionControl(m$,m$.Fnc.$get(m$.var("^WWWTransaction",0,m$.var("pstrForm").get(),m$.var("pstrTransaction").get(),1))),include.COMSYS.$$$YES(m$)))) {
      //<< trollback  //transaction rollback
      //<< $$$LogRx("TUE: TROLLBACK")
      $$$LogRx(m$,"TUE: TROLLBACK");
    }
    //<< }
    //<< //==========================
    //<< set $zerror = strError
    mVar $zerror = m$.var("$zerror");
    $zerror.set(strError.get());
    //<< 
    //<< if ($get(pstrForm) '= "") &&($get(pstrTransaction) '= "") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("pstrForm")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("pstrTransaction")),""))) {
      //<< kill ^CacheTempTransactionControl(YUSER,pstrForm,pstrTransaction)
      m$.var("^CacheTempTransactionControl",m$.var("YUSER").get(),m$.var("pstrForm").get(),m$.var("pstrTransaction").get()).kill();
    }
    //<< }
    //<< 
    //<< //Server Side Event
    //<< if $$$InHyperEvent {
    if (mOp.Logical(include.COMSYS.$$$InHyperEvent(m$))) {
      //<< do BACKGROUND^WWWERROR  ;save error log
      m$.Cmd.Do("WWWERROR.BACKGROUND");
      //<< if $find($zerror,"<") && $find($zerror,">") {  //Caché errors
      if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$zerror(),"<")) && mOp.Logical(m$.Fnc.$find(m$.Fnc.$zerror(),">"))) {
        //<< set strStatus = $$^WWWTEXT(387)_"|Info : "_$piece($piece($zerror,"<",2),">",1)_"|Prog.: "_$piece($zerror,">",2,9)
        strStatus.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",387),"|Info : "),m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$zerror(),"<",2),">",1)),"|Prog.: "),m$.Fnc.$piece(m$.Fnc.$zerror(),">",2,9)));
      }
      //<< 
      //<< } else {
      else {
        //<< set strStatus = $$DecodeError^COMUtilError($zerror)  //error status or error flag
        strStatus.set(m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$zerror()));
      }
      //<< }
      //<< do MSG^WWW013MSG(YBED,strStatus)  //inform user
      m$.Cmd.Do("WWW013MSG.MSG",m$.var("YBED").get(),strStatus.get());
      //<< set $zerror = ""
      $zerror.set("");
      //<< quit $$$MakeStatus(strStatus)  ;return error
      return include.COMSYS.$$$MakeStatus(m$,strStatus);
    }
    //<< 
    //<< // Front End Event
    //<< } else {
    else {
      //<< if '$find($zerror,"<") || '$find($zerror,">") {        //error status or error flag
      if (mOp.Not(m$.Fnc.$find(m$.Fnc.$zerror(),"<")) || mOp.Not(m$.Fnc.$find(m$.Fnc.$zerror(),">"))) {
        //<< set strStatus = $$DecodeError^COMUtilError($zerror)
        strStatus.set(m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$zerror()));
        //<< do Alert^COMConst(strStatus)
        m$.Cmd.Do("COMConst.Alert",strStatus.get());
        //<< set $zerror = ""
        $zerror.set("");
        //<< quit strStatus
        return strStatus.get();
      }
      //<< 
      //<< } else {  //Caché error
      else {
        //<< zquit 1 goto @$ztrap  ;run default error handler
        m$.Cmd.Goto(m$.Fnc.$ztrap());
        return null;
      }
    }
    //<< }
    //<< }
    //<< quit 0
  }

  //<< 
  //<< 
  //<< StartUnit(pstrForm,pstrTransaction)
  public Object StartUnit(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrTransaction = m$.newVarRef("pstrTransaction",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Start transaction unit and set locks
    //<< ;   pstrForm        - Form related Transaction
    //<< ;   pstrTransaction - Transaction to get the required locks
    //<< ;
    //<< ; Returns:
    //<< ;   strStatus       - Variable to return the status.  List format.
    //<< ;
    //<< ;
    //<< ; set $ztrap="TransactionUnitError" if calling without $$TransactionUnit !!!
    //<< ; ==========================================================================
    //<< ;
    //<< ; History:
    //<< ; 24-Sep-2008   FIS Created SR15947
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< $$$LogR("StartUnit",$get(pstrForm)_"<"_$get(pstrTransaction))
    $$$LogR(m$,"StartUnit",mOp.Concat(mOp.Concat(m$.Fnc.$get(pstrForm),"<"),m$.Fnc.$get(pstrTransaction)));
    //<< 
    //<< set strStatus = $$$NO
    strStatus.set(include.COMSYS.$$$NO(m$));
    //<< if ($get(pstrForm) '= "") && ($get(pstrTransaction) '= "") && '$data(^CacheTempTransactionControl(YUSER,pstrForm,pstrTransaction)) {
    if ((mOp.NotEqual(m$.Fnc.$get(pstrForm),"")) && (mOp.NotEqual(m$.Fnc.$get(pstrTransaction),"")) && mOp.Not(m$.Fnc.$data(m$.var("^CacheTempTransactionControl",m$.var("YUSER").get(),pstrForm.get(),pstrTransaction.get())))) {
      //<< set ^CacheTempTransactionControl(YUSER,pstrForm,pstrTransaction,"Started") = $zhorolog
      m$.var("^CacheTempTransactionControl",m$.var("YUSER").get(),pstrForm.get(),pstrTransaction.get(),"Started").set(m$.Fnc.$zhorolog());
      //<< 
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< if ($$$WWWTransactionTransactionControl($get(^WWWTransaction(0,pstrForm,pstrTransaction,1))) = $$$YES) {
      if ((mOp.Equal(include.WWWConst.$$$WWWTransactionTransactionControl(m$,m$.Fnc.$get(m$.var("^WWWTransaction",0,pstrForm.get(),pstrTransaction.get(),1))),include.COMSYS.$$$YES(m$)))) {
        //<< $$$LogRx("SU: TSTART")
        $$$LogRx(m$,"SU: TSTART");
      }
      //<< tstart  //start transaction
      //<< }
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< 
      //<< set strStatus = $$LockUnit("+",pstrForm,pstrTransaction)
      strStatus.set(m$.fnc$("LockUnit","+",pstrForm.get(),pstrTransaction.get()));
      //<< 
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< if '$$$ISOK(strStatus) {  //unable to lock records
      if (mOp.Not(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< tcommit             ; FIXME : This will occur regardless of whether or not the tstart in this subroutine is performed <GRF>
        //<< $$$LogRx("SU: TCOMMIT")
        $$$LogRx(m$,"SU: TCOMMIT");
        //<< kill ^CacheTempTransactionControl(YUSER,pstrForm,pstrTransaction)
        m$.var("^CacheTempTransactionControl",m$.var("YUSER").get(),pstrForm.get(),pstrTransaction.get()).kill();
      }
    }
    //<< }
    //<< ;+++++++++++++++++++++++++++++++++++++++ ; FIXME : trollback? <GRF>
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< EndUnit(pstrForm,pstrTransaction,pstrTStatus=$$$OK,pstrTError="")
  public Object EndUnit(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrTransaction = m$.newVarRef("pstrTransaction",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrTStatus = m$.newVarRef("pstrTStatus",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$OK(m$));
    mVar pstrTError = m$.newVarRef("pstrTError",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for transaction units (chain of multiple functions as one unit)
    //<< ;   pstrTransaction - Transaction to get the locks
    //<< ;   pstrTStatus     - Current Status
    //<< ;   pstrTError      - Current Error Flag
    //<< ;
    //<< ; Returns:
    //<< ;   pstrTStatus     - Variable to return the status.  List format.
    //<< ;
    //<< ; History:
    //<< ; 24-Sep-2008   FIS Created SR15947
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< $$$LogR("EndUnit",$get(pstrForm)_"<"_$get(pstrTransaction))
    $$$LogR(m$,"EndUnit",mOp.Concat(mOp.Concat(m$.Fnc.$get(pstrForm),"<"),m$.Fnc.$get(pstrTransaction)));
    //<< 
    //<< set strStatus = $$LockUnit("-",pstrForm,pstrTransaction)
    strStatus.set(m$.fnc$("LockUnit","-",pstrForm.get(),pstrTransaction.get()));
    //<< 
    //<< //==========================
    //<< if ($get(pstrForm) '= "")        &&
    //<< ($get(pstrTransaction) '= "") &&
    //<< ($$$WWWTransactionTransactionControl($get(^WWWTransaction(0,pstrForm,pstrTransaction,1))) = $$$YES) {
    if ((mOp.NotEqual(m$.Fnc.$get(pstrForm),"")) && (mOp.NotEqual(m$.Fnc.$get(pstrTransaction),"")) && (mOp.Equal(include.WWWConst.$$$WWWTransactionTransactionControl(m$,m$.Fnc.$get(m$.var("^WWWTransaction",0,pstrForm.get(),pstrTransaction.get(),1))),include.COMSYS.$$$YES(m$)))) {
      //<< if $tlevel >0 {
      if (mOp.Greater(m$.Fnc.$tlevel(),0)) {
        //<< if ('$$$ISOK(pstrTStatus)) {  //failed status from subroutine    ; FIXME : $$$ISERR <GRF>
        if ((mOp.Not(include.COMSYS.$$$ISOK(m$,pstrTStatus)))) {
          //<< set $zerror = pstrTStatus
          mVar $zerror = m$.var("$zerror");
          $zerror.set(pstrTStatus.get());
          //<< goto @$ztrap  ;TransactionUnitError
          m$.Cmd.Goto(m$.Fnc.$ztrap());
          return null;
        }
        //<< 
        //<< } elseif (pstrTError '= "") {  //error flag from subroutine
        else if ((mOp.NotEqual(pstrTError.get(),""))) {
          //<< set $zerror = pstrTError
          mVar $zerror = m$.var("$zerror");
          $zerror.set(pstrTError.get());
          //<< goto @$ztrap  ;TransactionUnitError
          m$.Cmd.Goto(m$.Fnc.$ztrap());
          return null;
        }
        //<< 
        //<< } else {
        else {
          //<< tcommit  //end transaction
          //<< $$$LogRx("EU: TCOMMIT")
          $$$LogRx(m$,"EU: TCOMMIT");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< //==========================
    //<< 
    //<< kill ^CacheTempTransactionControl(YUSER,pstrForm,pstrTransaction)
    m$.var("^CacheTempTransactionControl",m$.var("YUSER").get(),pstrForm.get(),pstrTransaction.get()).kill();
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< LockUnit(pstrLockSet,pstrForm,pstrTransaction)
  public Object LockUnit(Object ... _p) {
    mVar pstrLockSet = m$.newVarRef("pstrLockSet",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrTransaction = m$.newVarRef("pstrTransaction",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set/Release locks for transaction units
    //<< ;   pstrLockSet     - "+" = Set / "-" = Release
    //<< ;   pstrTransaction - Transaction to get the locks
    //<< ;
    //<< ; Returns:
    //<< ;   pstrTStatus     - Variable to return the status.  List format.
    //<< ;
    //<< ; History:
    //<< ; 24-Sep-2008   FIS Created SR15947
    //<< ;-------------------------------------------------------------------------------
    //<< new strLockRec,strLockKey,objLockRec,strLockStr,idx,strStatus
    mVar strLockRec = m$.var("strLockRec");
    mVar strLockKey = m$.var("strLockKey");
    mVar objLockRec = m$.var("objLockRec");
    mVar strLockStr = m$.var("strLockStr");
    mVar idx = m$.var("idx");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strLockRec,strLockKey,objLockRec,strLockStr,idx,strStatus);
    //<< 
    //<< quit $$$OK  // LOCKS NOT IMPLEMENTED YET !!!!!!!!!!!!!
    return include.COMSYS.$$$OK(m$);
  }

//<< 
//<< /*
//<< set strStatus = $$$NO
//<< 
//<< //set locks
//<< if (pstrTransaction '= "") && ($extract(pstrLockSet) = "+") {
//<< set strStatus = $$$OK
//<< set strLockRec=""
//<< for {
//<< set strLockRec=$order(^WWWTransactionLocks(0,pstrTransaction,strLockRec))
//<< quit:strLockRec=""
//<< 
//<< set objLockRec = $get(^WWWTransactionLocks(0,pstrTransaction,strLockRec,1))
//<< 
//<< set strLockStr = "^"_strLockRec_"("_""""_$$^WWWYM(strLockRec)_""""
//<< if ($piece(objLockRec,Y,1) '= "") {
//<< for idx=1:1:$length($piece(objLockRec,Y,1),",") {
//<< set strLockStr = strLockStr_","
//<< if ($extract($piece($piece(objLockRec,Y,1),",",idx)) = """") {
//<< set strLockStr = strLockStr_""""_$piece($piece(objLockRec,Y,1),",",idx)_""""
//<< 
//<< } else {
//<< set strLockStr = strLockStr_@$piece($piece(objLockRec,Y,1),",",idx)
//<< }
//<< }
//<< }
//<< set strLockStr = strLockStr_")"
//<< 
//<< if pstrLockSet="+" {  //set incremental lock
//<< lock +@strLockStr:1
//<< if $test {
//<< set ^CacheTempTransactionControl(YUSER,pstrTransaction,"lock",strLockStr)=""
//<< 
//<< } else {
//<< set strStatus = $$$NO
//<< }
//<< }
//<< if pstrLockSet="++" {  //set new lock
//<< lock @strLockStr:1
//<< if $test {
//<< set ^CacheTempTransactionControl(YUSER,pstrTransaction,"lock",strLockStr)=""
//<< 
//<< } else {
//<< set strStatus = $$$NO
//<< }
//<< }
//<< }
//<< 
//<< //release locks
//<< } elseif (pstrTransaction '= "") && ($extract(pstrLockSet) = "-") {
//<< set strStatus = $$$OK
//<< set strLockStr=""
//<< for {
//<< set strLockStr=$order(^CacheTempTransactionControl(YUSER,pstrTransaction,"lock",strLockStr))
//<< quit:strLockStr=""
//<< 
//<< if pstrLockSet = "-" {
//<< lock -@strLockStr:1
//<< if $test {
//<< kill ^CacheTempTransactionControl(YUSER,pstrTransaction,"lock",strLockStr)
//<< }
//<< 
//<< } elseif pstrLockSet = "--" {
//<< lock @strLockStr:1
//<< if $test {
//<< lock -@strLockStr
//<< kill ^CacheTempTransactionControl(YUSER,pstrTransaction,"lock",strLockStr)
//<< }
//<< }
//<< }
//<< }
//<< quit strStatus
//<< */
//<< 
//<< 
//<< 
}
