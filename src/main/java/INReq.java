//*****************************************************************************
//** TASC - ALPHALINC - MAC INReq
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-07 13:42:47
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
//<< #include COMConst
import include.COMConst;
//<< #include INConst
import include.INConst;
//<< #include %occInclude
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;

//<< INReq
public class INReq extends mClass {

  public void main() {
    _INReq();
  }

  public void _INReq() {
  }

  //<< 
  //<< IsProgramOutOfDateRange(YFELD)          ;SR17034
  public Object IsProgramOutOfDateRange(Object ... _p) {
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : Core Rules - INReq F24, INReqKit F22
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$IsProgramOutOfDateRange^INPROJECT($$$INReqProgram1(YFELD),$$$INReqDate1(YFELD))
    return m$.fnc$("INPROJECT.IsProgramOutOfDateRange",include.INConst.$$$INReqProgram1(m$,YFELD),include.INConst.$$$INReqDate1(m$,YFELD));
  }

  //<< 
  //<< 
  //<< Editable(pidReq)
  public Object Editable(Object ... _p) {
    mVar pidReq = m$.newVarRef("pidReq",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Is form editable (unprocessed) ?
    //<< ;
    //<< ; Params:   pidReq - Req id
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dREQ to dUReq
    //<< ; 04-Dec-2007   PPP     SR15597 - Creation
    //<< ;-------------------------------------------------------------------------------
    //<< new objReq,strStatus
    mVar objReq = m$.var("objReq");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objReq,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if '$$$NoKey(pidReq) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pidReq))) {
      //<< set objReq = $get(^INReq(0,pidReq,1))
      objReq.set(m$.Fnc.$get(m$.var("^INReq",0,pidReq.get(),1)));
      //<< 
      //<< if $$$INReqStatus(objReq) > 1 {
      if (mOp.Greater(include.INConst.$$$INReqStatus(m$,objReq),1)) {
        //<< set strStatus = $$$MakeStatus("INREQ01")
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"INREQ01"));
      }
    }
    //<< } ; "Requisition has been Firmed"
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< OnBlurDueDate(pYINHALT,pYFELD)
  public Object OnBlurDueDate(Object ... _p) {
    mVar pYINHALT = m$.newVarRef("pYINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; FIX ME impliment user feed back of YTOOLTIP
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 26-Sep-2008   Luke    SR15946 Corrected the Check to %TXT
    //<< ; 24-Sep-2008   Luke    SR15946 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objCompany,strStatus,strWarningColor
    mVar objCompany = m$.var("objCompany");
    mVar strStatus = m$.var("strStatus");
    mVar strWarningColor = m$.var("strWarningColor");
    m$.newVar(objCompany,strStatus,strWarningColor);
    //<< 
    //<< if pYINHALT '= "" {
    if (mOp.NotEqual(pYINHALT.get(),"")) {
      //<< if $$$INReqDueDate(pYFELD) < $horolog {
      if (mOp.Less(include.INConst.$$$INReqDueDate(m$,pYFELD),m$.Fnc.$horolog())) {
        //<< set YTOOLTIP = $$$Text("INREQ23")
        mVar YTOOLTIP = m$.var("YTOOLTIP");
        YTOOLTIP.set(include.COMSYS.$$$Text(m$,"INREQ23"));
      }
    }
    //<< } ; "Due Date can only be today or later"
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterDataFields(pYM,pYFORM,pintPage,pYKEY,pYFELD)
  public Object OnAfterDataFields(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintPage = m$.newVarRef("pintPage",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called By :
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 27-Jan-2010   PPP     SR17145: Added the OpenDemands Table
    //<< ; 01-Jun-2009   PPP     SR16586: Simplify Process (Display Issue for a Requisition)
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ; 12-Mar-2009   HQN     SR16417: Disable ToLocn if key is valid; $$$NoKey macro
    //<< ; 30-Nov-2007   HQN     Created
    //<< ;-------------------------------------------------------------------------------
    //<< do RemoveLocksIfRequired^COMLock(pYFORM,pYKEY,$$GetRemovalCode(,pYKEY),$$$YES)
    m$.Cmd.Do("COMLock.RemoveLocksIfRequired",pYFORM.get(),pYKEY.get(),m$.fnc$("GetRemovalCode",null,pYKEY.get()),include.COMSYS.$$$YES(m$));
    //<< 
    //<< if ((+$$$WWWClientParamCoreChangesSESDF($get(^WWWClientParam(YM,YM,1))))||
    //<< (+$$$WWWClientParamCoreChangesSESPE($get(^WWWClientParam(YM,YM,1))))||
    //<< (+$$$WWWClientParamCoreChangesHEVA($get(^WWWClientParam(YM,YM,1))))) {
    if ((mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESDF(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESPE(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesHEVA(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))))) {
      //<< do PrintJS^VARINReq(YVOR)
      m$.Cmd.Do("VARINReq.PrintJS",m$.var("YVOR").get());
    }
    //<< }
    //<< 
    //<< if $$$NoKey(pYKEY) {
    if (mOp.Logical(include.COMSYS.$$$NoKey(m$,pYKEY))) {
      //<< if '$$$INVORGHideOpenDemands($$Get^INVORG()) {
      if (mOp.Not(include.INConst.$$$INVORGHideOpenDemands(m$,m$.fnc$("INVORG.Get")))) {
        //<< do OpenDemandsTable^INReqOpenDemands(YLOCATION)
        m$.Cmd.Do("INReqOpenDemands.OpenDemandsTable",m$.var("YLOCATION").get());
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< do LoadGrid(0,pYFORM,pYKEY,pYFELD)
      m$.Cmd.Do("LoadGrid",0,pYFORM.get(),pYKEY.get(),pYFELD.get());
    }
    //<< }
    //<< 
    //<< if ($$$INReqStatus(pYFELD) '= 1) {    ; not Open        //SR16586
    if ((mOp.NotEqual(include.INConst.$$$INReqStatus(m$,pYFELD),1))) {
      //<< do ShowIssuedTable^INReqShowIssue(pYKEY)
      m$.Cmd.Do("INReqShowIssue.ShowIssuedTable",pYKEY.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetRemovalCode(pstrClass="",pidClass="")
  public Object GetRemovalCode(Object ... _p) {
    mVar pstrClass = m$.newVarRef("pstrClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; How to determine whether lock is still required.
    //<< ;
    //<< ; Params:
    //<< ; pstrClass - ** Not used **
    //<< ; pidClass - The key of the header record the index is related to.
    //<< ;
    //<< ; ByRefs: None
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 27-Jan-2010   PPP     SR17145: Created
    //<< ;-------------------------------------------------------------------------------
    //<< //quit $$$LOCKCODE_"'$data(^INReqLines0,3,$$Index^COMUtils(strClassId),"""_pidClass_"""))"
    //<< quit $$$LOCKCALL_"CanRemoveLock^INReq(strClassId,"""_pidClass_""")"
    return mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYS.$$$LOCKCALL(m$),"CanRemoveLock^INReq(strClassId,\""),pidClass.get()),"\")");
  }

  //<< 
  //<< 
  //<< CanRemoveLock(pstrClassId,pidClass)
  public Object CanRemoveLock(Object ... _p) {
    mVar pstrClassId = m$.newVarRef("pstrClassId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines whether a given lock can be removed
    //<< ;
    //<< ; Params:
    //<< ; pstrClassId  : The id of the class to be removed
    //<< ; pidClass     : The id of the lock owner record
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; Boolean
    //<< ;
    //<< ; History:
    //<< ; 27-Jan-2010   PPP     SR17145: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnRemove,idReq,idStatus
    mVar blnRemove = m$.var("blnRemove");
    mVar idReq = m$.var("idReq");
    mVar idStatus = m$.var("idStatus");
    m$.newVar(blnRemove,idReq,idStatus);
    //<< /*
    //<< if pstrClassName="INReqLine" {
    //<< set blnRemove='$data(^INReqToSupOrderLines(0,1,$$$Index(pstrClassId),pidClass))
    //<< } else {
    //<< set blnRemove='$data(^INReqToSupOrderLines(0,2,$$$Index($$$KEY1(pstrClassId)),$$$Index($$$KEY2(pstrClassId)),pidClass))
    //<< }
    //<< */
    //<< 
    //<< set blnRemove = $$$NO
    blnRemove.set(include.COMSYS.$$$NO(m$));
    //<< set idReq = $order(^INReqLines(0,3,$$$Index(pstrClassId),idReq))
    idReq.set(m$.Fnc.$order(m$.var("^INReqLines",0,3,include.MEDConst.$$$Index(m$,pstrClassId),idReq.get())));
    //<< 
    //<< if idReq'="" {
    if (mOp.NotEqual(idReq.get(),"")) {
      //<< set idStatus = $$$INReqStatus($get(^INReq(0,idReq,1)))
      idStatus.set(include.INConst.$$$INReqStatus(m$,m$.Fnc.$get(m$.var("^INReq",0,idReq.get(),1))));
      //<< if (idStatus>0) && (idStatus<7) {
      if ((mOp.Greater(idStatus.get(),0)) && (mOp.Less(idStatus.get(),7))) {
        //<< set blnRemove = $$$YES
        blnRemove.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnRemove
    return blnRemove.get();
  }

  //<< 
  //<< 
  //<< OnBeforeDelete(pYM,pYFORM,pstrKey,pYFELD,pYFORMLine="INReqLine")
  public Object OnBeforeDelete(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pYFORMLine = m$.newVarRef("pYFORMLine",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"INReqLine");
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called By : OnBeforeDelete^INReqCancel, OnBeforeDelete^INReqKit, OnBeforeDelete^INReqReject
    //<< ;             Form INReq : Execute On Before Delete
    //<< ;                          (other forms call the OnBeforeDelete tags shown above)
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 22-Apr-2010   shobby  SR17267: Line Form could be INReqKitLine, INReqCancel,
    //<< ;                           etc. so add pYFORMLine to parameters
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ; 11-Dec-2007   HQN     Code cleanup, added new
    //<< ; 18-Oct-2007   LB      SR15600: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set Q = $$$QSave
    mVar Q = m$.var("Q");
    Q.set(include.COMSYSWWW.$$$QSave(m$));
    //<< 
    //<< //set strStatus = $$ExecuteRule(pYFORM,0,pstrKey,"Delete")
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< ;***************************************
      //<< tstart
      //<< if ($$DeleteAll^INReqLine(pYFORMLine) && $$$GRIDSave(pstrKey)) {        ;SR17267
      if ((mOp.Logical(m$.fnc$("INReqLine.DeleteAll",pYFORMLine.get())) && mOp.Logical(include.COMGridEdit31Interface.$$$GRIDSave(m$,pstrKey)))) {
        //<< $$$GRIDDelete
        include.COMGridEdit31Interface.$$$GRIDDelete(m$);
      }
      //<< tcommit
      //<< } else {
      else {
        //<< trollback
        //<< ;***************************************
        //<< set strStatus = $$$NO      ; FIXME : <GRF> Error message?
        strStatus.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< //Remove any COMLock records if present
    //<< do RemoveLocksIfRequired^COMLock(pYFORM,pstrKey)
    m$.Cmd.Do("COMLock.RemoveLocksIfRequired",pYFORM.get(),pstrKey.get());
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< do ReturnError^COMUtilError(strStatus)
      m$.Cmd.Do("COMUtilError.ReturnError",strStatus.get());
      //<< set Q = $$$QDontSave
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeSave(pYM,pYFORM,pstrKey,pYFELD,pYFORMLine="INReqLine")
  public Object OnBeforeSave(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pYFORMLine = m$.newVarRef("pYFORMLine",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"INReqLine");
    //<< ;-------------------------------------------------------------------------------
    //<< ; this gets called before the screen write plus its enclosed in a hyper
    //<< ; event or javascript call!
    //<< ;
    //<< ; Called By : OnBeforeSave^INReqKit  (from Form INReqKit)
    //<< ;             Form INReq : Execute On Before Save
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History:
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ; 24-Sep-2008   Luke    SR15946 Added DueDate check and high light
    //<< ; 11-Dec-2007   HQN     Code cleanup, added new
    //<< ; 18-Oct-2007   Luke    SR15600: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objCompany,objReq,objStatus,strStatus,strWarningColor
    mVar objCompany = m$.var("objCompany");
    mVar objReq = m$.var("objReq");
    mVar objStatus = m$.var("objStatus");
    mVar strStatus = m$.var("strStatus");
    mVar strWarningColor = m$.var("strWarningColor");
    m$.newVar(objCompany,objReq,objStatus,strStatus,strWarningColor);
    //<< 
    //<< set Q         = $$$QSave
    mVar Q = m$.var("Q");
    Q.set(include.COMSYSWWW.$$$QSave(m$));
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if ($$$INReqFromLocn(pYFELD)'="") && ( $$$INReqToLocn(pYFELD)'="") {
    if ((mOp.NotEqual(include.INConst.$$$INReqFromLocn(m$,pYFELD),"")) && (mOp.NotEqual(include.INConst.$$$INReqToLocn(m$,pYFELD),""))) {
      //<< set $$$INReqType(pYFELD) = $$GetReqType(pYFELD)
      include.INConst.$$$INReqTypeSet(m$,pYFELD,m$.fnc$("GetReqType",pYFELD.get()));
    }
    //<< }
    //<< 
    //<< if '$$$NoKey(pstrKey) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pstrKey))) {
      //<< if ($$$INReqDueDate(pYFELD)'="") && ($$$INReqDueDate(pYFELD)<$horolog)  {
      if ((mOp.NotEqual(include.INConst.$$$INReqDueDate(m$,pYFELD),"")) && (mOp.Less(include.INConst.$$$INReqDueDate(m$,pYFELD),m$.Fnc.$horolog()))) {
        //<< set strStatus = $$$MakeStatus("INREQ23")            ; "Due Date can only be today or later"
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"INREQ23"));
        //<< set Q         = $$$QDontSave
        Q.set(include.COMSYSWWW.$$$QDontSave(m$));
      }
      //<< }
      //<< //  FIXME : Are the following
      //<< if (YOPTION = 2) || ($$$INReqCancelled(pYFELD) = $$$YES) {
      if ((mOp.Equal(m$.var("YOPTION").get(),2)) || (mOp.Equal(include.INConst.$$$INReqCancelled(m$,pYFELD),include.COMSYS.$$$YES(m$)))) {
        //<< if $$$INReqReasonCancellation(pYFELD) = "" {
        if (mOp.Equal(include.INConst.$$$INReqReasonCancellation(m$,pYFELD),"")) {
          //<< set Q = $$$QDontSave
          Q.set(include.COMSYSWWW.$$$QDontSave(m$));
          //<< set strStatus = $$$MakeStatus("WWW00105",$$$WWW003CaptionInForms($get(^WWW003(0,"INReq",$$$FldINReqReasonCancellation,1))))
          strStatus.set(include.COMSYS.$$$MakeStatus(m$,"WWW00105",include.WWWConst.$$$WWW003CaptionInForms(m$,m$.Fnc.$get(m$.var("^WWW003",0,"INReq",include.INConst.$$$FldINReqReasonCancellation(m$),1)))));
        }
      }
      //<< }                                                   ; "Reason Cancelled : Mandatory Field"
      //<< }
      //<< 
      //<< if (YOPTION = 3) || ($$$INReqRejected(pYFELD) = $$$YES) {
      if ((mOp.Equal(m$.var("YOPTION").get(),3)) || (mOp.Equal(include.INConst.$$$INReqRejected(m$,pYFELD),include.COMSYS.$$$YES(m$)))) {
        //<< if $$$INReqReasonRejection(pYFELD) = "" {
        if (mOp.Equal(include.INConst.$$$INReqReasonRejection(m$,pYFELD),"")) {
          //<< set Q = $$$QDontSave
          Q.set(include.COMSYSWWW.$$$QDontSave(m$));
          //<< set strStatus = $$$MakeStatus("WWW00105",$$$WWW003CaptionInForms($get(^WWW003(0,"INReq",$$$FldINReqReasonRejection,1))))
          strStatus.set(include.COMSYS.$$$MakeStatus(m$,"WWW00105",include.WWWConst.$$$WWW003CaptionInForms(m$,m$.Fnc.$get(m$.var("^WWW003",0,"INReq",include.INConst.$$$FldINReqReasonRejection(m$),1)))));
        }
      }
    }
    //<< }                                                   ; "Reason Rejected : Mandatory Field"
    //<< }
    //<< }
    //<< 
    //<< if Q=$$$QSave {
    if (mOp.Equal(Q.get(),include.COMSYSWWW.$$$QSave(m$))) {
      //<< set objReq = ##class(alREQ.dUReq).%OpenId("0||"_pstrKey)
      objReq.set(m$.fnc$("alREQ.dUReq.$OpenId",mOp.Concat("0||",pstrKey.get())));
      //<< 
      //<< if objReq'= $$$NULLOREF {
      if (mOp.NotEqual(objReq.get(),include.$occConstant.$$$NULLOREF(m$))) {
        //<< if objReq.RequisitionAllowed() {
        if (mOp.Logical(m$.fnc$(objReq.getORef(),"RequisitionAllowed"))) {
          //<< set objStatus = ##class(alSYS.Status.dUStatus).%OpenId("0||INReq||1")
          objStatus.set(m$.fnc$("alSYS.Status.dUStatus.$OpenId","0||INReq||1"));
          //<< if (objReq.NewRecord()) {
          if (mOp.Logical((m$.fnc$(objReq.getORef(),"NewRecord")))) {
            //<< set objReq.Status = objStatus
            m$.prop(objReq.get(),"Status").set(objStatus.get());
          }
          //<< }
          //<< set strStatus = $$SAVE^COMGridEdit31Save(pstrKey,pYFORMLine)        // "INReqLine"      ;SR17267
          strStatus.set(m$.fnc$("COMGridEdit31Save.SAVE",pstrKey.get(),pYFORMLine.get()));
        }
        //<< 
        //<< } else {
        else {
          //<< set strStatus = $$$MakeStatus("INREQ13")   ; "Requisition must be with the same main site"
          strStatus.set(include.COMSYS.$$$MakeStatus(m$,"INREQ13"));
        }
        //<< }
        //<< do objReq.%Close()
        m$.Cmd.Do(objReq.getORef(),"$Close");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< do ReturnError^COMUtilError(strStatus)
      m$.Cmd.Do("COMUtilError.ReturnError",strStatus.get());
      //<< set Q = $$$QDontSave
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterSave(pidReq,pobjReq)
  public Object OnAfterSave(Object ... _p) {
    mVar pidReq = m$.newVarRef("pidReq",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjReq = m$.newVarRef("pobjReq",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create Req lines if location selected in "Open" Demands table then firm Req
    //<< ;
    //<< ; Params:
    //<< ; pidReq - Req Id
    //<< ; pobjReq - Req Record
    //<< ;
    //<< ; ByRefs: None
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 08-Jun-2010   PPP     SR17351: Moved call to ClearBlanks^INReq from
    //<< ;                           OnAfterSave to FirmRequisition
    //<< ; 11-Feb-2010   PPP     SR17122: Added the ClearBlank Lines routine
    //<< ; 27-Jan-2010   PPP     SR17145: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if $$$INReqStatus(pobjReq) = 1 {        // Open
    if (mOp.Equal(include.INConst.$$$INReqStatus(m$,pobjReq),1)) {
      //<< //  set strStatus = $$Transaction^COMTransaction("ClearBlanks^INReq("""_pidReq_""")")  //SR17351
      //<< 
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< //This is created by LinesToCreate^INReqOpenDemands
        //<< if $data(^CacheTempReqLinesToCreate(YUSER)) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempReqLinesToCreate",m$.var("YUSER").get())))) {
          //<< set strStatus = $$Transaction^COMTransaction("CreateLinesReq^INReqOpenDemands("""_pidReq_""")")
          strStatus.set(m$.fnc$("COMTransaction.Transaction",mOp.Concat(mOp.Concat("CreateLinesReq^INReqOpenDemands(\"",pidReq.get()),"\")")));
          //<< 
          //<< if $$$ISOK(strStatus) {
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
            //<< set strStatus = $$Transaction^COMTransaction("FirmTxn^INReq("""_pidReq_""")")
            strStatus.set(m$.fnc$("COMTransaction.Transaction",mOp.Concat(mOp.Concat("FirmTxn^INReq(\"",pidReq.get()),"\")")));
          }
          //<< }
          //<< 
          //<< if $$$ISOK(strStatus) {
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
          }
          //<< //set %("%KEY","HYPEREVENT") = $$$YES
          //<< //
          //<< //  This will cause GoToForm^COMUtilForm to load for in main frame using js,
          //<< //  if omitted transfer form will appear at the bottom of the page.
          //<< //do PrintPick^INTRNPick(pidTFR)
          //<< }
          //<< kill ^CacheTempReqLinesToCreate(YUSER)
          m$.var("^CacheTempReqLinesToCreate",m$.var("YUSER").get()).kill();
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
  //<< ClearBlanks(pidReq)
  public Object ClearBlanks(Object ... _p) {
    mVar pidReq = m$.newVarRef("pidReq",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Clear/Delete All Lines where the Qty is Blank or Zero
    //<< ;
    //<< ;
    //<< ; Returns:Status
    //<< ;
    //<< ; History:
    //<< ; 29-Jun-2010   SCR     SR17394: Remove Zero Qty Lines also
    //<< ; 11-Feb-2010   PPP     SR17122: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLine,objReqLine,strStatus
    mVar idLine = m$.var("idLine");
    mVar objReqLine = m$.var("objReqLine");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idLine,objReqLine,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set idLine = ""
    idLine.set("");
    //<< for {
    for (;true;) {
      //<< quit:$$$ISERR(strStatus)
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        break;
      }
      //<< 
      //<< set idLine = $order(^INReqLine(0,pidReq,idLine))
      idLine.set(m$.Fnc.$order(m$.var("^INReqLine",0,pidReq.get(),idLine.get())));
      //<< quit:idLine=""
      if (mOp.Equal(idLine.get(),"")) {
        break;
      }
      //<< 
      //<< set objReqLine = $get(^INReqLine(0,pidReq,idLine,1))
      objReqLine.set(m$.Fnc.$get(m$.var("^INReqLine",0,pidReq.get(),idLine.get(),1)));
      //<< 
      //<< if +$$$INReqLineQtyOrdered(objReqLine)=0 {  ; Remove Blank or Zero lines
      if (mOp.Equal(mOp.Positive(include.INConst.$$$INReqLineQtyOrdered(m$,objReqLine)),0)) {
        //<< set strStatus = $$$Kill("INReqLine",pidReq_$$$COMMA_idLine)
        strStatus.set(include.COMSYS.$$$Kill(m$,"INReqLine",mOp.Concat(mOp.Concat(pidReq.get(),include.COMSYSString.$$$COMMA(m$)),idLine.get())));
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< FirmRequisition(pYM=0,pYFORM,pYKEY,pYFELD)
  public Object FirmRequisition(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Post adjustment
    //<< ;
    //<< ; Called By: Form INDispenseToPatient : Button 1 - Execute OnClick
    //<< ;            Form INReq               : Button 1 - Execute OnClick
    //<< ;
    //<< ; Returns:Status
    //<< ;
    //<< ; History:
    //<< ; 08-Jun-2010   PPP     SR17351: Moved call to ClearBlanks^INReq from
    //<< ;                           OnAfterSave to FirmRequisition
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ; 15-May-2009   GRF     SR16199: sc/strStatus use clarified
    //<< ; 11-May-2009   PPP     SR16199: Updated as a Single Interface for both
    //<< ;                           Department Issue and POS/Sale Issue
    //<< ;-------------------------------------------------------------------------------
    //<< new objIssue,strStatus
    mVar objIssue = m$.var("objIssue");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objIssue,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if $$$INReqStatus(pYFELD) = 2 {
    if (mOp.Equal(include.INConst.$$$INReqStatus(m$,pYFELD),2)) {
      //<< set strStatus = $$$MakeStatus("INREQ01")           ; "Requisition has been Firmed"
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"INREQ01"));
    }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set strStatus = $$Transaction^COMTransaction("ClearBlanks^INReq("""_pYKEY_""")",$$$YES)  //SR17351
      strStatus.set(m$.fnc$("COMTransaction.Transaction",mOp.Concat(mOp.Concat("ClearBlanks^INReq(\"",pYKEY.get()),"\")"),include.COMSYS.$$$YES(m$)));
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< set strStatus = $$Transaction^COMTransaction("FirmTxn^INReq("""_pYKEY_""")",$$$YES)
        strStatus.set(m$.fnc$("COMTransaction.Transaction",mOp.Concat(mOp.Concat("FirmTxn^INReq(\"",pYKEY.get()),"\")"),include.COMSYS.$$$YES(m$)));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< 
      //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
      if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
        //<< set $piece(^INReq(YM,pYKEY,1),Y,50) = $horolog  ;Free12 - Confirmado Em
        m$.pieceVar(m$.var("^INReq",m$.var("YM").get(),pYKEY.get(),1),m$.var("Y").get(),50).set(m$.Fnc.$horolog());
        //<< set $piece(^INReq(YM,pYKEY,1),Y,52) = YBED      ;Free14 - Confirmado Por
        m$.pieceVar(m$.var("^INReq",m$.var("YM").get(),pYKEY.get(),1),m$.var("Y").get(),52).set(m$.var("YBED").get());
      }
      //<< }
      //<< 
      //<< do ^WWWFORM
      m$.Cmd.Do("WWWFORM.main");
    }
    //<< } else {
    else {
      //<< do ReturnError^COMUtilError(strStatus)
      m$.Cmd.Do("COMUtilError.ReturnError",strStatus.get());
    }
    //<< }
    //<< $$$YQHandler(strStatus)
    include.COMSYS.$$$YQHandler(m$,strStatus);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< FirmTxn(pidReq)
  public Object FirmTxn(Object ... _p) {
    mVar pidReq = m$.newVarRef("pidReq",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;       Forces a change of state to FIRMED
    //<< ;
    //<< ; Called By :
    //<< ;   Form - INReq
    //<< ;   Routines -
    //<< ;       Button from INReq form
    //<< ;
    //<< ; Inputs :
    //<< ;   companyId   -   Primary Key of Company
    //<< ;   reqId       -   %Id of INReq instance
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ;-------------------------------------------------------------------------------
    //<< new objReq,sc,strStatus
    mVar objReq = m$.var("objReq");
    mVar sc = m$.var("sc");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objReq,sc,strStatus);
    //<< 
    //<< set (strStatus,sc) = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    sc.set(include.COMSYS.$$$OK(m$));
    //<< //$$ExecuteRule(pYFORM,0,pYKEY,"canFirm")
    //<< //set strStatus = $$ExecuteStatus(pYFORM,0,pYKEY,"Firm")
    //<< 
    //<< set objReq = ##class(alREQ.dUReq).%OpenId("0||"_pidReq)
    objReq.set(m$.fnc$("alREQ.dUReq.$OpenId",mOp.Concat("0||",pidReq.get())));
    //<< 
    //<< if objReq'= $$$NULLOREF {
    if (mOp.NotEqual(objReq.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< if objReq.RequisitionAllowed() {
      if (mOp.Logical(m$.fnc$(objReq.getORef(),"RequisitionAllowed"))) {
        //<< if (objReq.ReqLinesCount() > "0") {
        if ((mOp.Greater(m$.fnc$(objReq.getORef(),"ReqLinesCount"),"0"))) {
          //<< set sc = objReq.FirmRequisition()
          sc.set(m$.fnc$(objReq.getORef(),"FirmRequisition"));
          //<< if $$$ISOK(sc) {
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
            //<< set objReq.Status = ##class(alSYS.Status.dUStatus).%OpenId("0||INReq||2")
            m$.prop(objReq.get(),"Status").set(m$.fnc$("alSYS.Status.dUStatus.$OpenId","0||INReq||2"));
            //<< set sc = objReq.%Save()
            sc.set(m$.fnc$(objReq.getORef(),"%Save"));
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< set strStatus = $$$MakeStatus("INREQ07")  ; "Requisition has no lines to issue"
          strStatus.set(include.COMSYS.$$$MakeStatus(m$,"INREQ07"));
        }
      }
      //<< }
      //<< 
      //<< } else {
      else {
        //<< set strStatus = $$$MakeStatus("INREQ13")       ; "Requisition must be with the same main site"
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"INREQ13"));
      }
      //<< }
      //<< do objReq.%Close()
      m$.Cmd.Do(objReq.getORef(),"$Close");
    }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set:$$$ISERR(sc) strStatus = $$ISStatusToDLStatus^COMUtilError(sc,$$$NO)
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
        strStatus.set(m$.fnc$("COMUtilError.ISStatusToDLStatus",sc.get(),include.COMSYS.$$$NO(m$)));
      }
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< /* REDUNDANT - Replaced by BELOW
  //<< ManuallyClose(pYM=0,pYFORM,pYKEY,pYFELD)
  //<< ;-------------------------------------------------------------------------------
  //<< ;
  //<< 
  //<< new objReq,sc,strStatus
  //<< 
  //<< set (strStatus,sc) = $$$OK
  //<< //set strStatus = $$ExecuteRule(pYFORM,0,pYKEY,"manClose")
  //<< 
  //<< set objReq = ##class(alREQ.dUReq).%OpenId("0||"_pYKEY)
  //<< 
  //<< 
  //<< 
  //<< $$$YQHandler(strStatus)
  //<< quit
  //<< */
  //<< 
  //<< ManuallyClose(pYM=0,pYFORM,pYKEY,pYFELD,pVerbose=0)
  public Object ManuallyClose(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pVerbose = m$.newVarRef("pVerbose",(((_p!=null)&&(_p.length>=5))?_p[4]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called By :
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 03-Jun-2011   PPP     SR17776: Updated to include Transaction boundary
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ; 11-Dec-2007   HQN     Code cleanup, added new
    //<< ; 30-Nov-2007   HQN     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objReq,sc,strStatus
    mVar objReq = m$.var("objReq");
    mVar sc = m$.var("sc");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objReq,sc,strStatus);
    //<< 
    //<< set strStatus = $$Transaction^COMTransaction("ManuallyCloseTxn^INReq("""_pYKEY_""")",$$$YES)
    strStatus.set(m$.fnc$("COMTransaction.Transaction",mOp.Concat(mOp.Concat("ManuallyCloseTxn^INReq(\"",pYKEY.get()),"\")"),include.COMSYS.$$$YES(m$)));
    //<< 
    //<< if pVerbose=0 { //If it's coming from an integration, do not change the form
    if (mOp.Equal(pVerbose.get(),0)) {
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< if ((+$$$WWWClientParamCoreChangesSESDF($get(^WWWClientParam(YM,YM,1))))||
        //<< (+$$$WWWClientParamCoreChangesSESPE($get(^WWWClientParam(YM,YM,1))))||
        //<< (+$$$WWWClientParamCoreChangesHEVA($get(^WWWClientParam(YM,YM,1))))) {
        if ((mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESDF(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESPE(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesHEVA(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))))) {
          //<< do GoToForm^COMUtilForm(pYFORM,pYKEY)
          m$.Cmd.Do("COMUtilForm.GoToForm",pYFORM.get(),pYKEY.get());
        }
        //<< } else {
        else {
          //<< do ^WWWFORM
          m$.Cmd.Do("WWWFORM.main");
        }
      }
      //<< }
      //<< } else {
      else {
        //<< do ReturnError^COMUtilError(strStatus)
        m$.Cmd.Do("COMUtilError.ReturnError",strStatus.get());
      }
    }
    //<< }
    //<< } else {
    else {
      //<< q strStatus
      return strStatus.get();
    }
    //<< }
    //<< 
    //<< $$$YQHandler(strStatus)
    include.COMSYS.$$$YQHandler(m$,strStatus);
    //<< quit
    return null;
  }

  //<< 
  //<< ManuallyCloseTxn(pidReq)
  public Object ManuallyCloseTxn(Object ... _p) {
    mVar pidReq = m$.newVarRef("pidReq",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called By :
    //<< ;
    //<< ; Inputs : pidReq
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 03-Jun-2011   PPP SR17776: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objReq,sc,strStatus
    mVar objReq = m$.var("objReq");
    mVar sc = m$.var("sc");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objReq,sc,strStatus);
    //<< 
    //<< set (strStatus,sc) = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set objReq = ##class(alREQ.dUReq).%OpenId("0||"_pidReq)
    objReq.set(m$.fnc$("alREQ.dUReq.$OpenId",mOp.Concat("0||",pidReq.get())));
    //<< 
    //<< if objReq'= $$$NULLOREF {
    if (mOp.NotEqual(objReq.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< set sc = objReq.ManuallyClose()
      sc.set(m$.fnc$(objReq.getORef(),"ManuallyClose"));
      //<< do objReq.%Close()
      m$.Cmd.Do(objReq.getORef(),"$Close");
    }
    //<< }
    //<< 
    //<< if $$$ISERR(sc) set strStatus = $$ISStatusToDLStatus^COMUtilError(sc,$$$NO)
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
      strStatus.set(m$.fnc$("COMUtilError.ISStatusToDLStatus",sc.get(),include.COMSYS.$$$NO(m$)));
    }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< Print(pYKEY, &pYFELD)
  public Object Print(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called By :
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ; 11-Dec-2007   HQN     Code cleanup, added new
    //<< ; 30-Nov-2007   HQN     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objReq,sc,strStatus
    mVar objReq = m$.var("objReq");
    mVar sc = m$.var("sc");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objReq,sc,strStatus);
    //<< 
    //<< set (strStatus,sc) = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    sc.set(include.COMSYS.$$$OK(m$));
    //<< //set strStatus = $$ExecuteStatus(YFORM,YM,YKEY,"Print")
    //<< 
    //<< set objReq = ##class(alREQ.dUReq).%OpenId("0||"_pYKEY)
    objReq.set(m$.fnc$("alREQ.dUReq.$OpenId",mOp.Concat("0||",pYKEY.get())));
    //<< 
    //<< if objReq'= $$$NULLOREF {
    if (mOp.NotEqual(objReq.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< set sc = objReq.Print()
      sc.set(m$.fnc$(objReq.getORef(),"Print"));
      //<< do objReq.%Close()
      m$.Cmd.Do(objReq.getORef(),"$Close");
    }
    //<< }
    //<< 
    //<< if $$$ISERR(sc) set strStatus = $$ISStatusToDLStatus^COMUtilError(sc,$$$NO)
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
      strStatus.set(m$.fnc$("COMUtilError.ISStatusToDLStatus",sc.get(),include.COMSYS.$$$NO(m$)));
    }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< do ^WWWFORM
      m$.Cmd.Do("WWWFORM.main");
    }
    //<< } else {
    else {
      //<< do ReturnError^COMUtilError(strStatus)
      m$.Cmd.Do("COMUtilError.ReturnError",strStatus.get());
    }
    //<< }
    //<< 
    //<< $$$YQHandler(strStatus)
    include.COMSYS.$$$YQHandler(m$,strStatus);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< LoadGrid(pYM,pYFORM,pstrKey,pYFELD)
  public Object LoadGrid(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called By :
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 14-Aug-2013   shobby  CORE-233.1: Some problems resizing in HEVA
    //<< ; 13-Aug-2009   GRF     SR16544: explicit Hide switches
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ; 29-Jan-2009   HQN     SR16296: show columns when lines marked as rejected
    //<< ;                           or cancelled
    //<< ; 11-Dec-2007   HQN     Code cleanup, added new
    //<< ; 30-Nov-2007   HQN     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCancelled,blnLoadControls,blnRejected,idReqLine
    mVar blnCancelled = m$.var("blnCancelled");
    mVar blnLoadControls = m$.var("blnLoadControls");
    mVar blnRejected = m$.var("blnRejected");
    mVar idReqLine = m$.var("idReqLine");
    m$.newVar(blnCancelled,blnLoadControls,blnRejected,idReqLine);
    //<< new objReq,objReqLine,strStatus,YAUSWAHL,YFORM
    mVar objReq = m$.var("objReq");
    mVar objReqLine = m$.var("objReqLine");
    mVar strStatus = m$.var("strStatus");
    mVar YAUSWAHL = m$.var("YAUSWAHL");
    mVar YFORM = m$.var("YFORM");
    m$.newVar(objReq,objReqLine,strStatus,YAUSWAHL,YFORM);
    //<< 
    //<< if (pstrKey '= "") {
    if ((mOp.NotEqual(pstrKey.get(),""))) {
      //<< ; FIXME : does editgrid do line locking?
      //<< kill ^CacheTempLocked(YUSER)
      m$.var("^CacheTempLocked",m$.var("YUSER").get()).kill();
      //<< do ClearOld^WWWMultiLock(YUSER)
      m$.Cmd.Do("WWWMultiLock.ClearOld",m$.var("YUSER").get());
      //<< set YFORM = "INReqLine"
      YFORM.set("INReqLine");
      //<< 
      //<< set $$$COMGridEditParameterSharedForm(YAUSWAHL)    = $$$YES
      include.COMConst.$$$COMGridEditParameterSharedFormSet(m$,YAUSWAHL,include.COMSYS.$$$YES(m$));
      //<< set $$$COMGridEditParameterMaximumHeight(YAUSWAHL) = 400
      include.COMConst.$$$COMGridEditParameterMaximumHeightSet(m$,YAUSWAHL,400);
      //<< set $$$COMGridEditParameterGridName(YAUSWAHL)      = YFORM
      include.COMConst.$$$COMGridEditParameterGridNameSet(m$,YAUSWAHL,YFORM.get());
      //<< set $$$COMGridEditParameterContainer(YAUSWAHL)     = "INReq"
      include.COMConst.$$$COMGridEditParameterContainerSet(m$,YAUSWAHL,"INReq");
      //<< set $$$COMGridEditParameterEnabled(YAUSWAHL)       = ($$$INReqStatus(pYFELD) = 1) ; open
      include.COMConst.$$$COMGridEditParameterEnabledSet(m$,YAUSWAHL,(mOp.Equal(include.INConst.$$$INReqStatus(m$,pYFELD),1)));
      //<< 
      //<< //  set strStatus = $$ExecuteRule(YFORM,0,pstrKey,"LoadGrid")
      //<< do Start^COMGridEdit31(YFORM,pstrKey)
      m$.Cmd.Do("COMGridEdit31.Start",YFORM.get(),pstrKey.get());
      //<< 
      //<< ; Hide/Show correct Cancel/Reject columns
      //<< if YOPTION = 1 {        // Editing, cancel reject meaningless
      if (mOp.Equal(m$.var("YOPTION").get(),1)) {
        //<< $$$StartScript()
        include.COMSYS.$$$StartScript(m$);
        //<< $$$GRIDHideShowColumns("12;13;14;15;16;18;19;20",$$$YES)  ; Hide form columns
        include.COMGridEdit31Interface.$$$GRIDHideShowColumns(m$,"12;13;14;15;16;18;19;20",include.COMSYS.$$$YES(m$));
        //<< $$$EndScript()
        include.COMSYS.$$$EndScript(m$);
      }
      //<< 
      //<< } else {
      else {
        //<< if YLOCATION = $$$INReqFromLocn(pYFELD) {
        if (mOp.Equal(m$.var("YLOCATION").get(),include.INConst.$$$INReqFromLocn(m$,pYFELD))) {
          //<< $$$StartScript()
          include.COMSYS.$$$StartScript(m$);
          //<< $$$GRIDHideShowColumns("13;15;19",$$$YES)  ; Hide : F13 Rejected, F15 Reason Rejection, F19 Rejection Date
          include.COMGridEdit31Interface.$$$GRIDHideShowColumns(m$,"13;15;19",include.COMSYS.$$$YES(m$));
          //<< $$$EndScript()
          include.COMSYS.$$$EndScript(m$);
        }
        //<< 
        //<< } elseif YLOCATION = $$$INReqToLocn(pYFELD) {
        else if (mOp.Equal(m$.var("YLOCATION").get(),include.INConst.$$$INReqToLocn(m$,pYFELD))) {
          //<< $$$StartScript()
          include.COMSYS.$$$StartScript(m$);
          //<< $$$GRIDHideShowColumns("12;14;18",$$$YES)  ; Hide : F12 Cancelled, F14 Reason Cancellation, F18 Cancellation Date
          include.COMGridEdit31Interface.$$$GRIDHideShowColumns(m$,"12;14;18",include.COMSYS.$$$YES(m$));
          //<< $$$EndScript()
          include.COMSYS.$$$EndScript(m$);
        }
      }
      //<< }
      //<< }
      //<< 
      //<< ; 29-Jan-2009 vvvv
      //<< set blnRejected  = $$$NO
      blnRejected.set(include.COMSYS.$$$NO(m$));
      //<< set blnCancelled = $$$NO
      blnCancelled.set(include.COMSYS.$$$NO(m$));
      //<< set idReqLine = ""
      idReqLine.set("");
      //<< for {
      for (;true;) {
        //<< set idReqLine = $order(^INReqLine(0,pstrKey,idReqLine))
        idReqLine.set(m$.Fnc.$order(m$.var("^INReqLine",0,pstrKey.get(),idReqLine.get())));
        //<< quit:idReqLine=""
        if (mOp.Equal(idReqLine.get(),"")) {
          break;
        }
        //<< 
        //<< set objReqLine = $get(^INReqLine(0,pstrKey,idReqLine,1))
        objReqLine.set(m$.Fnc.$get(m$.var("^INReqLine",0,pstrKey.get(),idReqLine.get(),1)));
        //<< if $$$INReqLineRejected(objReqLine)=$$$YES  set blnRejected  = $$$YES
        if (mOp.Equal(include.INConst.$$$INReqLineRejected(m$,objReqLine),include.COMSYS.$$$YES(m$))) {
          blnRejected.set(include.COMSYS.$$$YES(m$));
        }
        //<< if $$$INReqLineCancelled(objReqLine)=$$$YES set blnCancelled = $$$YES
        if (mOp.Equal(include.INConst.$$$INReqLineCancelled(m$,objReqLine),include.COMSYS.$$$YES(m$))) {
          blnCancelled.set(include.COMSYS.$$$YES(m$));
        }
      }
      //<< }
      //<< if blnRejected {
      if (mOp.Logical(blnRejected.get())) {
        //<< $$$StartScript()
        include.COMSYS.$$$StartScript(m$);
        //<< $$$GRIDHideShowColumns("15;16;19",$$$NO)  ; Show form columns
        include.COMGridEdit31Interface.$$$GRIDHideShowColumns(m$,"15;16;19",include.COMSYS.$$$NO(m$));
        //<< $$$EndScript()
        include.COMSYS.$$$EndScript(m$);
      }
      //<< }
      //<< if blnCancelled {
      if (mOp.Logical(blnCancelled.get())) {
        //<< $$$StartScript()
        include.COMSYS.$$$StartScript(m$);
        //<< $$$GRIDHideShowColumns("14;18;20",$$$NO)  ; Show form columns
        include.COMGridEdit31Interface.$$$GRIDHideShowColumns(m$,"14;18;20",include.COMSYS.$$$NO(m$));
        //<< $$$EndScript()
        include.COMSYS.$$$EndScript(m$);
      }
      //<< }
      //<< $$$StartScript()            ;CORE-233.1
      include.COMSYS.$$$StartScript(m$);
      //<< write "moveFocus('T');"     ;CORE-233.1
      m$.Cmd.Write("moveFocus('T');");
      //<< $$$EndScript()              ;CORE-233.1
      include.COMSYS.$$$EndScript(m$);
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< IsDeletable(pYM,pYFORM,pYKEY,pYFELD)
  public Object IsDeletable(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called By : Button - Delete
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 18-Dec-2007   PPP     Only Status 1 - can be deleted (not after Firm (2))
    //<< ; 11-Dec-2007   HQN     Code cleanup, added new
    //<< ; 30-Nov-2007   HQN     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnStatus
    mVar blnStatus = m$.var("blnStatus");
    m$.newVar(blnStatus);
    //<< 
    //<< set blnStatus = ($$$INReqStatus(pYFELD) = 1) ; open
    blnStatus.set((mOp.Equal(include.INConst.$$$INReqStatus(m$,pYFELD),1)));
    //<< 
    //<< $$$YQHandler(blnStatus)
    include.COMSYS.$$$YQHandler(m$,blnStatus);
    //<< quit blnStatus
    return blnStatus.get();
  }

  //<< 
  //<< 
  //<< IsFirmable(pYM,pYFORM,pYKEY,pYFELD)
  public Object IsFirmable(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Test if buttons should be disabled
    //<< ;
    //<< ; Called by INReq : Button "Firm"
    //<< ;           and ???
    //<< ;
    //<< ; History:
    //<< ; 18-Aug-2009   PPP     SR16838: Check that the Status is > 1
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ; 15-Sep-2008   HQN     SR15903: Using optional setting to strip object error
    //<< ;                           code
    //<< ; 01-Aug-2008   Luke    SR15814: Corrected use of status and naming
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dREQ to dUReq
    //<< ; 11-Dec-2007   HQN     Code cleanup, added new
    //<< ; 22-Nov-2007   GRF     SR15614: Proper case for tag
    //<< ; 06-Dec-2007   HQN     Additional checks in place, needs to be converted to
    //<< ;                           Script engine
    //<< ;-------------------------------------------------------------------------------
    //<< new objReq,sc,strStatus
    mVar objReq = m$.var("objReq");
    mVar sc = m$.var("sc");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objReq,sc,strStatus);
    //<< 
    //<< //set strStatus = $$ExecuteRule(pYFORM,0,pYKEY,"canFirm")
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if $$$INReqStatus(pYFELD) > 1 {    ; Firmed
    if (mOp.Greater(include.INConst.$$$INReqStatus(m$,pYFELD),1)) {
      //<< set strStatus = $$$MakeStatus("INREQ01")     ; "Requisition has been Firmed"
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"INREQ01"));
    }
    //<< }
    //<< ;06-Apr-2011 Karine: CoreChange-Verifica se existe saldo em estoque para aprovar a requisi????o
    //<< ;                    Isso s?? ocorre se o par??metro de usu??rio que libera requisi????o com estoque zerado estiver = 1
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set strStatus = $$CheckIfHasSOHForApproval^VARTCIReq(pYKEY)
      strStatus.set(m$.fnc$("VARTCIReq.CheckIfHasSOHForApproval",pYKEY.get()));
    }
    //<< }
    //<< ;^^^^
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set objReq = ##class(alREQ.dUReq).%OpenId("0||"_pYKEY)
      objReq.set(m$.fnc$("alREQ.dUReq.$OpenId",mOp.Concat("0||",pYKEY.get())));
      //<< if objReq'= $$$NULLOREF {
      if (mOp.NotEqual(objReq.get(),include.$occConstant.$$$NULLOREF(m$))) {
        //<< set sc = objReq.IsFirmable()
        sc.set(m$.fnc$(objReq.getORef(),"IsFirmable"));
        //<< set:$$$ISERR(sc) strStatus = $$ISStatusToDLStatus^COMUtilError(sc,$$$NO)
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
          strStatus.set(m$.fnc$("COMUtilError.ISStatusToDLStatus",sc.get(),include.COMSYS.$$$NO(m$)));
        }
        //<< do objReq.%Close()
        m$.Cmd.Do(objReq.getORef(),"$Close");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if (+$$$WWWClientParamCoreChangesHEVA($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesHEVA(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
      //<< if ($$getControlarAutorizacaoProdutos^VARParametroCliente(YM)){
      if (mOp.Logical((m$.fnc$("VARParametroCliente.getControlarAutorizacaoProdutos",m$.var("YM").get())))) {
        //<< if ((pYFORM = "INReq")&&(pYKEY '= "")){
        if (mOp.Logical(((mOp.Equal(pYFORM.get(),"INReq")) && (mOp.NotEqual(pYKEY.get(),""))))) {
          //<< if $$$ISOK(strStatus){
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
            //<< 
            //<< set idReq  = pYKEY
            mVar idReq = m$.var("idReq");
            idReq.set(pYKEY.get());
            //<< set objReq = $get(^INReq(YM,idReq,1))
            objReq.set(m$.Fnc.$get(m$.var("^INReq",m$.var("YM").get(),idReq.get(),1)));
            //<< 
            //<< set idStatus = $$$INReqStatus(objReq)
            mVar idStatus = m$.var("idStatus");
            idStatus.set(include.INConst.$$$INReqStatus(m$,objReq));
            //<< set idToLocn = $$$INReqToLocn(objReq)
            mVar idToLocn = m$.var("idToLocn");
            idToLocn.set(include.INConst.$$$INReqToLocn(m$,objReq));
            //<< set reqLine  = ""
            mVar reqLine = m$.var("reqLine");
            reqLine.set("");
            //<< 
            //<< for{
            for (;true;) {
              //<< set reqLine = $order(^INReqLine(pYM,idReq,reqLine))
              reqLine.set(m$.Fnc.$order(m$.var("^INReqLine",pYM.get(),idReq.get(),reqLine.get())));
              //<< quit:(reqLine="")
              if ((mOp.Equal(reqLine.get(),""))) {
                break;
              }
              //<< 
              //<< set objReqLine = $get(^INReqLine(pYM,idReq,reqLine,1))
              mVar objReqLine = m$.var("objReqLine");
              objReqLine.set(m$.Fnc.$get(m$.var("^INReqLine",pYM.get(),idReq.get(),reqLine.get(),1)));
              //<< set idItem = $piece(objReqLine,"~",1)
              mVar idItem = m$.var("idItem");
              idItem.set(m$.Fnc.$piece(objReqLine.get(),"~",1));
              //<< 
              //<< if ((idToLocn'="")&&(idItem'="")){
              if (mOp.Logical(((mOp.NotEqual(idToLocn.get(),"")) && (mOp.NotEqual(idItem.get(),""))))) {
                //<< if ($$GetDRPRecord^INDRPITEM(idToLocn,idItem) = "") {
                if ((mOp.Equal(m$.fnc$("INDRPITEM.GetDRPRecord",idToLocn.get(),idItem.get()),""))) {
                  //<< set strStatus = "Produto "_idItem_" n??o autorizado para o local "_idToLocn_"."
                  strStatus.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Produto ",idItem.get())," n??o autorizado para o local "),idToLocn.get()),"."));
                }
              }
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
    //<< }
    //<< }
    //<< 
    //<< $$$YQHandler(strStatus)
    include.COMSYS.$$$YQHandler(m$,strStatus);
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< CanLoadTemplate(pYM,pYFORM,pYKEY,pYFELD)
  public Object CanLoadTemplate(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called By : Button - Use Template
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 18-Dec-2007   PPP     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnStatus
    mVar blnStatus = m$.var("blnStatus");
    m$.newVar(blnStatus);
    //<< 
    //<< set blnStatus = ($$$INReqStatus(pYFELD)=1)   ; open
    blnStatus.set((mOp.Equal(include.INConst.$$$INReqStatus(m$,pYFELD),1)));
    //<< 
    //<< $$$YQHandler(blnStatus)
    include.COMSYS.$$$YQHandler(m$,blnStatus);
    //<< quit blnStatus
    return blnStatus.get();
  }

  //<< 
  //<< 
  //<< HasLines(pYM,pYFORM,pYKEY,pYFELD)
  public Object HasLines(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Test if buttons should be disabled
    //<< ;
    //<< ; Called by INReq : Button 3 "Save As Template"
    //<< ;
    //<< ; History:
    //<< ; 22-Nov-2007   GRF     SR15614: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnStatus
    mVar blnStatus = m$.var("blnStatus");
    m$.newVar(blnStatus);
    //<< 
    //<< if (pYKEY'="") && $data(^INReqLine(0,pYKEY)) {
    if ((mOp.NotEqual(pYKEY.get(),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^INReqLine",0,pYKEY.get())))) {
      //<< set blnStatus = $$$YES
      blnStatus.set(include.COMSYS.$$$YES(m$));
    }
    //<< } else {
    else {
      //<< set blnStatus = $$$NO
      blnStatus.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< 
    //<< $$$YQHandler(blnStatus)
    include.COMSYS.$$$YQHandler(m$,blnStatus);
    //<< quit blnStatus
    return blnStatus.get();
  }

  //<< 
  //<< 
  //<< IsManuallyCloseable(pYM,pYFORM,pYKEY,pYFELD)
  public Object IsManuallyCloseable(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Test if buttons should be disabled
    //<< ;
    //<< ; Called by INReq : Button 2 "Firm Requisition"
    //<< ;
    //<< ; History:
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ; 28-May-2009   DWR     SR16582: replaced DEV00000 entry with language text
    //<< ; 28-Jan-2009   HQN     SR16296: Replicate OpenStatus handling
    //<< ; 06-Dec-2007   HQN     (Test script Req-001[22])
    //<< ;                           Added status check for already manually closed
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCloseable
    mVar blnCloseable = m$.var("blnCloseable");
    m$.newVar(blnCloseable);
    //<< set blnCloseable = $$$NO
    blnCloseable.set(include.COMSYS.$$$NO(m$));
    //<< if ($$IsFirmable^INReq(0,pYFORM,pYKEY,pYFELD)) {
    if (mOp.Logical((m$.fnc$("INReq.IsFirmable",0,pYFORM.get(),pYKEY.get(),pYFELD.get())))) {
      //<< set blnCloseable = $$$NO
      blnCloseable.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< if '$$$NoKey(pYKEY) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pYKEY))) {
      //<< if $$$INReqStatus(pYFELD)=1 {    ; open
      if (mOp.Equal(include.INConst.$$$INReqStatus(m$,pYFELD),1)) {
        //<< set blnCloseable = $$$MakeStatus("IN01046")    ; "Not yet firmed"
        blnCloseable.set(include.COMSYS.$$$MakeStatus(m$,"IN01046"));
      }
      //<< 
      //<< } elseif ($$$INReqStatus(pYFELD)'=7) && ($$$INReqStatus(pYFELD)'=8) && ($$$INReqStatus(pYFELD)'=9) {
      else if ((mOp.NotEqual(include.INConst.$$$INReqStatus(m$,pYFELD),7)) && (mOp.NotEqual(include.INConst.$$$INReqStatus(m$,pYFELD),8)) && (mOp.NotEqual(include.INConst.$$$INReqStatus(m$,pYFELD),9))) {
        //<< set blnCloseable =  $$$YES    ; not Manual-Close nor Auto-Close
        blnCloseable.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< $$$YQHandler(blnCloseable)
    include.COMSYS.$$$YQHandler(m$,blnCloseable);
    //<< quit blnCloseable
    return blnCloseable.get();
  }

  //<< 
  //<< 
  //<< GetHomeLocation(pidUser)
  public Object GetHomeLocation(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Users have a single Home Location and a set of Allowed Locations
    //<< ; This function returns the former.
    //<< ;
    //<< ; Called By : [Removed from Form INReqReject F3 "To Location"]
    //<< ;             Form INReq F3
    //<< ;             Form INReqCancel F3
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 30-Nov-2007   HQN     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objUser
    mVar objUser = m$.var("objUser");
    m$.newVar(objUser);
    //<< 
    //<< set objUser = $get(^WWW013(0,pidUser,1))   ;User Defaults
    objUser.set(m$.Fnc.$get(m$.var("^WWW013",0,pidUser.get(),1)));
    //<< quit $$$WWW013HomeLocation(objUser)
    return include.WWWConst.$$$WWW013HomeLocation(m$,objUser);
  }

  //<< 
  //<< 
  //<< OnDataAccess(pidReq,pidForm)
  public Object OnDataAccess(Object ... _p) {
    mVar pidReq = m$.newVarRef("pidReq",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Whether a Req can be used at this time.
    //<< ;
    //<< ; Params:   pidReq
    //<< ;           Form
    //<< ;
    //<< ; Returns: blnDataAccess
    //<< ;   $$$NO       Req is Not Accessable
    //<< ;   $$$YES      Req is Accessable
    //<< ;
    //<< ; History:
    //<< ; 04-Jun-2009   PPP     SR16544: No checks if the form is INIssueReleaseLine
    //<< ; 18-Dec-2007   PPP     SR15600: Updated the Status Checks
    //<< ; 11-Dec-2007   PPP     SR15600: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnDataAccess,objReq
    mVar blnDataAccess = m$.var("blnDataAccess");
    mVar objReq = m$.var("objReq");
    m$.newVar(blnDataAccess,objReq);
    //<< 
    //<< set blnDataAccess = $$$YES
    blnDataAccess.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< //if Issue Release no checks required
    //<< if pidForm = "INIssueReleaseLine" quit blnDataAccess              //EARLY EXIT
    if (mOp.Equal(pidForm.get(),"INIssueReleaseLine")) {
      return blnDataAccess.get();
    }
    //<< 
    //<< if '$$$NoKey(pidReq) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pidReq))) {
      //<< set blnDataAccess = $$$NO
      blnDataAccess.set(include.COMSYS.$$$NO(m$));
      //<< set objReq        = $get(^INReq(0,pidReq,1))
      objReq.set(m$.Fnc.$get(m$.var("^INReq",0,pidReq.get(),1)));
      //<< 
      //<< if (+$$$WWWClientParamCoreChangesTCI($get(^WWWClientParam(YM,YM,1)))) {
      if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesTCI(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
        //<< if ($$$INReqStatus(objReq) > 2)               &&
        //<< ($$$INReqStatus(objReq) < 8)                  {
        if ((mOp.Greater(include.INConst.$$$INReqStatus(m$,objReq),2)) && (mOp.Less(include.INConst.$$$INReqStatus(m$,objReq),8))) {
          //<< 
          //<< set blnDataAccess = $$$YES
          blnDataAccess.set(include.COMSYS.$$$YES(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnDataAccess
    return blnDataAccess.get();
  }

  //<< 
  //<< 
  //<< OnBeforeFormConstruction(pYPARA,&pYSATZ="")
  public Object OnBeforeFormConstruction(Object ... _p) {
    mVar pYPARA = m$.newVarRef("pYPARA",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYSATZ = m$.newVarRef("pYSATZ",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Params:
    //<< ;   pYSATZ      WWW122 record from Data Field
    //<< ;
    //<< ; ByRef:
    //<< ;   YKOPF       Form Title
    //<< ;   YKEY        Primary Key for INReq
    //<< ;   YBBN        Form Field Id
    //<< ;   YPFLICHT    (compulsory?  Boolean?)
    //<< ;
    //<< ; History:
    //<< ; 08-Dec-2009   shobby  SR17034: Display 'Program' dropdown based on setting in INVORG.
    //<< ; 10-Jun-2009   GRF     Repair macros (property names changed in class)
    //<< ; 13-Jan-2009   HQN     Set ReqType to read only when record is already saved
    //<< ; 08-Jan-2009   HQN     Alter Form Title depending on value of pYPARA
    //<< ;-------------------------------------------------------------------------------
    //<< ;if pYPARA = $$$AppParameter
    //<< 
    //<< if $get(YBBN) = $$$GetFormField("INReq",$$$FldINReqType) {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YBBN")),include.COMSYSWWW.$$$GetFormField(m$,"INReq",include.INConst.$$$FldINReqType(m$)))) {
      //<< if '$$$NoKey(YKEY) set YHID = 2
      if (mOp.Not(include.COMSYS.$$$NoKey(m$,m$.var("YKEY")))) {
        mVar YHID = m$.var("YHID");
        YHID.set(2);
      }
    }
    //<< 
    //<< } elseif $get(YBBN) = $$$GetFormField("INReq",$$$FldINReqFromLocn) {
    else if (mOp.Equal(m$.Fnc.$get(m$.var("YBBN")),include.COMSYSWWW.$$$GetFormField(m$,"INReq",include.INConst.$$$FldINReqFromLocn(m$)))) {
      //<< if (YOPTION '= 1)  set YHID = 2
      if ((mOp.NotEqual(m$.var("YOPTION").get(),1))) {
        mVar YHID = m$.var("YHID");
        YHID.set(2);
      }
    }
    //<< 
    //<< } elseif $get(YBBN) = $$$GetFormField("INReq",$$$FldINReqDueDate) {
    else if (mOp.Equal(m$.Fnc.$get(m$.var("YBBN")),include.COMSYSWWW.$$$GetFormField(m$,"INReq",include.INConst.$$$FldINReqDueDate(m$)))) {
      //<< if (YOPTION '= 1)  set YHID = 2
      if ((mOp.NotEqual(m$.var("YOPTION").get(),1))) {
        mVar YHID = m$.var("YHID");
        YHID.set(2);
      }
    }
    //<< 
    //<< } elseif $get(YBBN) = $$$GetFormField("INReq",$$$FldINReqPriority) {
    else if (mOp.Equal(m$.Fnc.$get(m$.var("YBBN")),include.COMSYSWWW.$$$GetFormField(m$,"INReq",include.INConst.$$$FldINReqPriority(m$)))) {
      //<< if (YOPTION '= 1)   set YHID = 2
      if ((mOp.NotEqual(m$.var("YOPTION").get(),1))) {
        mVar YHID = m$.var("YHID");
        YHID.set(2);
      }
    }
    //<< 
    //<< } elseif $get(YBBN) = $$$GetFormField("INReq",$$$FldINReqReasonCancellation) {
    else if (mOp.Equal(m$.Fnc.$get(m$.var("YBBN")),include.COMSYSWWW.$$$GetFormField(m$,"INReq",include.INConst.$$$FldINReqReasonCancellation(m$)))) {
      //<< set YPFLICHT = 1               ; Used within WWWFORM7 by ref
      mVar YPFLICHT = m$.var("YPFLICHT");
      YPFLICHT.set(1);
    }
    //<< 
    //<< } elseif $get(YBBN) = $$$GetFormField("INReq",$$$FldINReqReasonRejection) {
    else if (mOp.Equal(m$.Fnc.$get(m$.var("YBBN")),include.COMSYSWWW.$$$GetFormField(m$,"INReq",include.INConst.$$$FldINReqReasonRejection(m$)))) {
      //<< set YPFLICHT = 1               ; Used within WWWFORM7 by ref
      mVar YPFLICHT = m$.var("YPFLICHT");
      YPFLICHT.set(1);
    }
    //<< }
    //<< 
    //<< set YOPTION1 = '$$DisableProgramFunctionality^INVORG()  ;SR17034
    mVar YOPTION1 = m$.var("YOPTION1");
    YOPTION1.set(mOp.Not(m$.fnc$("INVORG.DisableProgramFunctionality")));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBlur(pFormFieldId,pYFELD)
  public Object OnBlur(Object ... _p) {
    mVar pFormFieldId = m$.newVarRef("pFormFieldId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Depending on the Locations, set the ReqType to the correct one
    //<< ;
    //<< ; ByRef:
    //<< ;   YM      Company ID
    //<< ;   YFORM   Form ID (Should be INReq)
    //<< ;
    //<< ; History:
    //<< ; 23-Apr-2013   SCR     HEVA-811: Correct Req Type
    //<< ; 28-Mar-2013   SCR     HEVA-811: Use 'Transfer or Issue' Calc
    //<< ; 19-Mar-2013   SCR     HEVA-811: If enabled the Destination Location type dictates the Requisition Type.
    //<< ;                                   If the Location is a consumption an Issue is created else a Transfer is created
    //<< ; 08-Dec-2009   shobby  SR17034: When 'Program' changes update the grid and the
    //<< ;                           Dynamic table.
    //<< ; 10-Jun-2009   GRF     Repair macros (property names changed in class)
    //<< ; 13-Jan-2009   HQN     SR16296: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intReqType,objVORG,objDest,idCalc
    mVar intReqType = m$.var("intReqType");
    mVar objVORG = m$.var("objVORG");
    mVar objDest = m$.var("objDest");
    mVar idCalc = m$.var("idCalc");
    m$.newVar(intReqType,objVORG,objDest,idCalc);
    //<< 
    //<< if pFormFieldId=$$$FldINReqFromLocn {
    if (mOp.Equal(pFormFieldId.get(),include.INConst.$$$FldINReqFromLocn(m$))) {
      //<< if $$$INReqType(pYFELD) = "" {
      if (mOp.Equal(include.INConst.$$$INReqType(m$,pYFELD),"")) {
        //<< set objVORG = $get(^INVORG(YM,YM,1))
        objVORG.set(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)));
        //<< set idCalc  = +$$$INVORGTransferorIssueCalc(objVORG)
        idCalc.set(mOp.Positive(include.INConst.$$$INVORGTransferorIssueCalc(m$,objVORG)));
        //<< if ((idCalc =1) && ($$$INReqToLocn(pYFELD)'="")) {
        if (mOp.Logical(((mOp.Equal(idCalc.get(),1)) && (mOp.NotEqual(include.INConst.$$$INReqToLocn(m$,pYFELD),""))))) {
          //<< set objDest = $get(^WWW0121(0,YM,$$$INReqToLocn(pYFELD),1))
          objDest.set(m$.Fnc.$get(m$.var("^WWW0121",0,m$.var("YM").get(),include.INConst.$$$INReqToLocn(m$,pYFELD),1)));
          //<< 
          //<< if $$$WWW0121StorageLocn(objDest) {
          if (mOp.Logical(include.WWWConst.$$$WWW0121StorageLocn(m$,objDest))) {
            //<< set intReqType = 2
            intReqType.set(2);
          }
          //<< } else {
          else {
            //<< set intReqType = 1
            intReqType.set(1);
          }
        }
        //<< }
        //<< } elseif idCalc=0 {
        else if (mOp.Equal(idCalc.get(),0)) {
          //<< if $$MainSite^WWW0121Utils(0,$$$INReqFromLocn(pYFELD)) = $$MainSite^WWW0121Utils(0,$$$INReqToLocn(pYFELD)) {
          if (mOp.Equal(m$.fnc$("WWW0121Utils.MainSite",0,include.INConst.$$$INReqFromLocn(m$,pYFELD)),m$.fnc$("WWW0121Utils.MainSite",0,include.INConst.$$$INReqToLocn(m$,pYFELD)))) {
            //<< set intReqType = 1
            intReqType.set(1);
          }
          //<< } else {
          else {
            //<< set intReqType = 2
            intReqType.set(2);
          }
        }
        //<< }
        //<< } elseif idCalc=2 {
        else if (mOp.Equal(idCalc.get(),2)) {
          //<< set intReqType=2
          intReqType.set(2);
        }
        //<< } elseif idCalc=3 {
        else if (mOp.Equal(idCalc.get(),3)) {
          //<< set intReqType=1
          intReqType.set(1);
        }
        //<< }
        //<< set %TXT(1) = %TXT(1)_"#Y"_YFORM_"D"_$$$FldINReqType_"~"_intReqType
        m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#Y"),m$.var("YFORM").get()),"D"),include.INConst.$$$FldINReqType(m$)),"~"),intReqType.get()));
      }
    }
    //<< }
    //<< 
    //<< } elseif pFormFieldId=$$$FldINReqType {
    else if (mOp.Equal(pFormFieldId.get(),include.INConst.$$$FldINReqType(m$))) {
      //<< if $$$INReqType(pYFELD) = 4 {                      ; SurgicalKit
      if (mOp.Equal(include.INConst.$$$INReqType(m$,pYFELD),4)) {
        //<< do GoToForm^COMUtilForm("INReqKit","",1,"")
        m$.Cmd.Do("COMUtilForm.GoToForm","INReqKit","",1,"");
      }
    }
    //<< }
    //<< 
    //<< } elseif pFormFieldId=$$$FldINReqProgram1 {
    else if (mOp.Equal(pFormFieldId.get(),include.INConst.$$$FldINReqProgram1(m$))) {
      //<< if '$$$NoKey(YKEY) {
      if (mOp.Not(include.COMSYS.$$$NoKey(m$,m$.var("YKEY")))) {
        //<< do Update^COMGridEdit31Interface("INReqLine",YKEY,pYFELD)                            ; SR17034
        m$.Cmd.Do("COMGridEdit31Interface.Update","INReqLine",m$.var("YKEY").get(),pYFELD.get());
        //<< do ShowItems^INReqTable(1,"INReq"_$char(31)_"INReqLine"_$char(31)_"1"_$char(31)_"1") ; SR17034
        m$.Cmd.Do("INReqTable.ShowItems",1,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("INReq",m$.Fnc.$char(31)),"INReqLine"),m$.Fnc.$char(31)),"1"),m$.Fnc.$char(31)),"1"));
      }
    }
    //<< }  ; [idForm*idGrid*idKey*intRow]
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< GetReqType(pYFELD)
  public Object GetReqType(Object ... _p) {
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Req Type
    //<< ;
    //<< ; ByRef:
    //<< ;   YFORM   Form ID (Should be INReq)
    //<< ;
    //<< ; History:
    //<< ; 24-Apr-2013   SCR     HEVA-811: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objVORG,idCalc,intReqType
    mVar objVORG = m$.var("objVORG");
    mVar idCalc = m$.var("idCalc");
    mVar intReqType = m$.var("intReqType");
    m$.newVar(objVORG,idCalc,intReqType);
    //<< 
    //<< set intReqType  = $$$INReqType(pYFELD) ; Default to existing
    intReqType.set(include.INConst.$$$INReqType(m$,pYFELD));
    //<< set objVORG     = $get(^INVORG(YM,YM,1))
    objVORG.set(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)));
    //<< set idCalc  = +$$$INVORGTransferorIssueCalc(objVORG)
    idCalc.set(mOp.Positive(include.INConst.$$$INVORGTransferorIssueCalc(m$,objVORG)));
    //<< if ((idCalc =1) && ($$$INReqToLocn(pYFELD)'="")) {
    if (mOp.Logical(((mOp.Equal(idCalc.get(),1)) && (mOp.NotEqual(include.INConst.$$$INReqToLocn(m$,pYFELD),""))))) {
      //<< set objDest = $get(^WWW0121(0,YM,$$$INReqToLocn(pYFELD),1))
      mVar objDest = m$.var("objDest");
      objDest.set(m$.Fnc.$get(m$.var("^WWW0121",0,m$.var("YM").get(),include.INConst.$$$INReqToLocn(m$,pYFELD),1)));
      //<< 
      //<< if $$$WWW0121StorageLocn(objDest) {
      if (mOp.Logical(include.WWWConst.$$$WWW0121StorageLocn(m$,objDest))) {
        //<< set intReqType = 2
        intReqType.set(2);
      }
      //<< } else {
      else {
        //<< set intReqType = 1
        intReqType.set(1);
      }
    }
    //<< }
    //<< } elseif idCalc=0 {
    else if (mOp.Equal(idCalc.get(),0)) {
      //<< if $$MainSite^WWW0121Utils(0,$$$INReqFromLocn(pYFELD)) = $$MainSite^WWW0121Utils(0,$$$INReqToLocn(pYFELD)) {
      if (mOp.Equal(m$.fnc$("WWW0121Utils.MainSite",0,include.INConst.$$$INReqFromLocn(m$,pYFELD)),m$.fnc$("WWW0121Utils.MainSite",0,include.INConst.$$$INReqToLocn(m$,pYFELD)))) {
        //<< set intReqType = 1
        intReqType.set(1);
      }
      //<< } else {
      else {
        //<< set intReqType = 2
        intReqType.set(2);
      }
    }
    //<< }
    //<< } elseif idCalc=2 {
    else if (mOp.Equal(idCalc.get(),2)) {
      //<< set intReqType=2
      intReqType.set(2);
    }
    //<< } elseif idCalc=3 {
    else if (mOp.Equal(idCalc.get(),3)) {
      //<< set intReqType=1
      intReqType.set(1);
    }
    //<< }
    //<< 
    //<< quit intReqType
    return intReqType.get();
  }

  //<< 
  //<< 
  //<< IsRejectable(pYKEY)
  public Object IsRejectable(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns whether this Req is in a Rejectable state
    //<< ;
    //<< ; CalledBy:
    //<< ;   INReq @nm Form  [Reject] Button
    //<< ;
    //<< ; ByRef:
    //<< ;   YQ  Hidden flag
    //<< ;   YLOCATION Location ID
    //<< ;
    //<< ; History:
    //<< ; 28-May-2009   DWR     SR16582: Created Language Texts for DEV00000 entries.
    //<< ; 14-Jan-2009   HQN     SR16296: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnRejectable,objReq
    mVar blnRejectable = m$.var("blnRejectable");
    mVar objReq = m$.var("objReq");
    m$.newVar(blnRejectable,objReq);
    //<< 
    //<< set blnRejectable = $$$NO
    blnRejectable.set(include.COMSYS.$$$NO(m$));
    //<< set YQ = 2
    mVar YQ = m$.var("YQ");
    YQ.set(2);
    //<< 
    //<< quit:$$$NoKey(pYKEY) blnRejectable
    if (mOp.Logical(include.COMSYS.$$$NoKey(m$,pYKEY))) {
      return blnRejectable.get();
    }
    //<< 
    //<< set objReq = $get(^INReq(0,pYKEY,1))
    objReq.set(m$.Fnc.$get(m$.var("^INReq",0,pYKEY.get(),1)));
    //<< if objReq '= $$$NULLOREF {
    if (mOp.NotEqual(objReq.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< if $$$INReqStatus(objReq) = 1 {
      if (mOp.Equal(include.INConst.$$$INReqStatus(m$,objReq),1)) {
        //<< $$$YQHandler($$$MakeStatus("IN01046"))         ; "Not yet firmed"
        include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"IN01046"));
      }
      //<< 
      //<< } elseif $get(YLOCATION) '= $$$INReqFromLocn(objReq) {
      else if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLOCATION")),include.INConst.$$$INReqFromLocn(m$,objReq))) {
        //<< $$$YQHandler($$$MakeStatus("IN01047"))         ; "Only the sending location may perform the processing"
        include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"IN01047"));
      }
      //<< 
      //<< } else {
      else {
        //<< ; Check Status
        //<< if ($$$INReqStatus(objReq) = 8) || ($$$INReqStatus(objReq) = 9) {
        if ((mOp.Equal(include.INConst.$$$INReqStatus(m$,objReq),8)) || (mOp.Equal(include.INConst.$$$INReqStatus(m$,objReq),9))) {
          //<< $$$YQHandler($$$MakeStatus("alREQ0002"))   ; "Already Closed"
          include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"alREQ0002"));
        }
        //<< 
        //<< } elseif ($$$INReqStatus(objReq) = 6) || ($$$INReqStatus(objReq) = 7) {
        else if ((mOp.Equal(include.INConst.$$$INReqStatus(m$,objReq),6)) || (mOp.Equal(include.INConst.$$$INReqStatus(m$,objReq),7))) {
          //<< $$$YQHandler($$$MakeStatus("INREQ06"))     ; "Requisition line is not Outstanding"
          include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"INREQ06"));
        }
        //<< 
        //<< //} elseif ($$$INReqStatus(objReq) = 3) {
        //<< //  $$$YQHandler($$$MakeStatus("IN01048"))     ; "Cannot Reject Record with Status = Active"
        //<< 
        //<< } else {
        else {
          //<< if $$$INReqCancelled(objReq) '= "" {
          if (mOp.NotEqual(include.INConst.$$$INReqCancelled(m$,objReq),"")) {
            //<< $$$YQHandler($$$MakeStatus("IN01043")) ; "Already Cancelled"
            include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"IN01043"));
          }
          //<< 
          //<< } elseif $$$INReqRejected(objReq) '= "" {
          else if (mOp.NotEqual(include.INConst.$$$INReqRejected(m$,objReq),"")) {
            //<< $$$YQHandler($$$MakeStatus("IN01044")) ; "Already Rejected"
            include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"IN01044"));
          }
          //<< 
          //<< } else {
          else {
            //<< set YQ = 0
            YQ.set(0);
            //<< set blnRejectable = $$$OK
            blnRejectable.set(include.COMSYS.$$$OK(m$));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< $$$YQHandler($$$MakeStatus("IN01045",pYKEY))       ; "Unable to load Req: %1"
      include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"IN01045",pYKEY));
    }
    //<< }
    //<< quit blnRejectable
    return blnRejectable.get();
  }

  //<< 
  //<< 
  //<< OnBeforeButtonLine(pYM,pYFORM,pintPage,pYKEY,&pYFELD)
  public Object OnBeforeButtonLine(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintPage = m$.newVarRef("pintPage",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set form to readonly if not editable
    //<< ;
    //<< ; Params:   pidReq      - Req id
    //<< ;           pobjReq     - Req object
    //<< ;
    //<< ; ByRef:
    //<< ;   YVOR        WWW122 record
    //<< ;   YPARA
    //<< ;
    //<< ; History:
    //<< ; 19-Jan-2009   HQN     SR16296: Moved from OnAfterPrimaryKey
    //<< ;                           Added YPARA options to alter form for
    //<< ;                           rejecting/cancelling
    //<< ; 04-Dec-2007   PPP     SR15597 - Creation
    //<< ;-------------------------------------------------------------------------------
    //<< set YOPTION = 1
    mVar YOPTION = m$.var("YOPTION");
    YOPTION.set(1);
    //<< 
    //<< if '$$$NoKey(pYKEY) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pYKEY))) {
      //<< if (YPARA = "REJECT") || (YPARA = "CANCEL") || (YPARA = "REJECTLINES") {
      if ((mOp.Equal(m$.var("YPARA").get(),"REJECT")) || (mOp.Equal(m$.var("YPARA").get(),"CANCEL")) || (mOp.Equal(m$.var("YPARA").get(),"REJECTLINES"))) {
        //<< if YPARA = "REJECT" {
        if (mOp.Equal(m$.var("YPARA").get(),"REJECT")) {
          //<< set YOPTION = 3
          YOPTION.set(3);
          //<< if '$$IsRejectable(pYKEY) {
          if (mOp.Not(m$.fnc$("IsRejectable",pYKEY.get()))) {
            //<< set $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly
            include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
          }
          //<< } else {
          else {
            //<< set $$$INReqRejected(pYFELD) = $$$YES
            include.INConst.$$$INReqRejectedSet(m$,pYFELD,include.COMSYS.$$$YES(m$));
          }
        }
        //<< }
        //<< 
        //<< } elseif YPARA = "CANCEL" {
        else if (mOp.Equal(m$.var("YPARA").get(),"CANCEL")) {
          //<< set YOPTION = 2
          YOPTION.set(2);
          //<< if '$$IsCancellable(pYKEY) {
          if (mOp.Not(m$.fnc$("IsCancellable",pYKEY.get()))) {
            //<< set $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly
            include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
          }
          //<< } else {
          else {
            //<< set $$$INReqCancelled(pYFELD) = $$$YES
            include.INConst.$$$INReqCancelledSet(m$,pYFELD,include.COMSYS.$$$YES(m$));
          }
        }
        //<< }
        //<< 
        //<< } elseif YPARA = "REJECTLINES" {
        else if (mOp.Equal(m$.var("YPARA").get(),"REJECTLINES")) {
          //<< set YOPTION = 5
          YOPTION.set(5);
        }
        //<< }
        //<< set YPARA = ""
        mVar YPARA = m$.var("YPARA");
        YPARA.set("");
      }
      //<< 
      //<< } else {
      else {
        //<< if '$$Editable(pYKEY) {
        if (mOp.Not(m$.fnc$("Editable",pYKEY.get()))) {
          //<< set $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly
          include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
        }
        //<< }
        //<< if $$$INReqRejected(pYFELD) '= "" {
        if (mOp.NotEqual(include.INConst.$$$INReqRejected(m$,pYFELD),"")) {
          //<< set YOPTION = 3     // "REJECT"
          YOPTION.set(3);
        }
        //<< 
        //<< } elseif $$$INReqCancelled(pYFELD) '= "" {
        else if (mOp.NotEqual(include.INConst.$$$INReqCancelled(m$,pYFELD),"")) {
          //<< set YOPTION = 2     // "CANCEL"
          YOPTION.set(2);
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
  //<< IsCancellable(pYKEY)
  public Object IsCancellable(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns whether this Req is in a Cancellable state
    //<< ;
    //<< ; CalledBy:
    //<< ;   INReq @nm Form  [Cancel] Button
    //<< ;
    //<< ; ByRef:
    //<< ;   YQ  Hidden flag
    //<< ;   YLOCATION Location ID
    //<< ;
    //<< ; History:
    //<< ; 28-May-2009   DWR     SR16582: Created Language Texts for DEV00000 entries.
    //<< ; 19-Jan-2009   HQN     SR16296: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCancellable,objReq
    mVar blnCancellable = m$.var("blnCancellable");
    mVar objReq = m$.var("objReq");
    m$.newVar(blnCancellable,objReq);
    //<< 
    //<< set blnCancellable = $$$NO
    blnCancellable.set(include.COMSYS.$$$NO(m$));
    //<< set YQ = 2
    mVar YQ = m$.var("YQ");
    YQ.set(2);
    //<< 
    //<< quit:$$$NoKey(pYKEY) blnCancellable
    if (mOp.Logical(include.COMSYS.$$$NoKey(m$,pYKEY))) {
      return blnCancellable.get();
    }
    //<< 
    //<< set objReq = $get(^INReq(0,pYKEY,1))
    objReq.set(m$.Fnc.$get(m$.var("^INReq",0,pYKEY.get(),1)));
    //<< 
    //<< if objReq '= $$$NULLOREF {
    if (mOp.NotEqual(objReq.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< if $get(YLOCATION) '= $$$INReqToLocn(objReq) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLOCATION")),include.INConst.$$$INReqToLocn(m$,objReq))) {
        //<< $$$YQHandler($$$MakeStatus("IN01041"))         ; "Only the receiving location may perform the processing"
        include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"IN01041"));
      }
      //<< 
      //<< } else {
      else {
        //<< ; Check Status
        //<< if ($$$INReqStatus(objReq) = 1) {
        if ((mOp.Equal(include.INConst.$$$INReqStatus(m$,objReq),1))) {
          //<< set YQ = 1
          YQ.set(1);
        }
        //<< 
        //<< } elseif ($$$INReqStatus(objReq) = 8) || ($$$INReqStatus(objReq) = 9) {
        else if ((mOp.Equal(include.INConst.$$$INReqStatus(m$,objReq),8)) || (mOp.Equal(include.INConst.$$$INReqStatus(m$,objReq),9))) {
          //<< $$$YQHandler($$$MakeStatus("alREQ0002"))   ; "Already Closed"
          include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"alREQ0002"));
        }
        //<< 
        //<< } elseif ($$$INReqStatus(objReq) = 6) || ($$$INReqStatus(objReq) = 7) {
        else if ((mOp.Equal(include.INConst.$$$INReqStatus(m$,objReq),6)) || (mOp.Equal(include.INConst.$$$INReqStatus(m$,objReq),7))) {
          //<< $$$YQHandler($$$MakeStatus("INREQ06"))     ; "Requisition line is not Outstanding"
          include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"INREQ06"));
        }
        //<< 
        //<< } elseif ($$$INReqStatus(objReq) = 3) {
        else if ((mOp.Equal(include.INConst.$$$INReqStatus(m$,objReq),3))) {
          //<< $$$YQHandler($$$MakeStatus("IN01042"))     ;"Cannot Cancel Record with Status = Active"
          include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"IN01042"));
        }
        //<< 
        //<< } else {
        else {
          //<< if $$$INReqCancelled(objReq) '= "" {
          if (mOp.NotEqual(include.INConst.$$$INReqCancelled(m$,objReq),"")) {
            //<< $$$YQHandler($$$MakeStatus("IN01043")) ; "Already Cancelled"
            include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"IN01043"));
          }
          //<< 
          //<< } elseif $$$INReqRejected(objReq) '= "" {
          else if (mOp.NotEqual(include.INConst.$$$INReqRejected(m$,objReq),"")) {
            //<< $$$YQHandler($$$MakeStatus("IN01044")) ; "Already Rejected"
            include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"IN01044"));
          }
          //<< 
          //<< } else {
          else {
            //<< set YQ = 0
            YQ.set(0);
            //<< set blnCancellable = $$$OK
            blnCancellable.set(include.COMSYS.$$$OK(m$));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< $$$YQHandler($$$MakeStatus("IN01045",pYKEY))       ; "Unable to load Req: %1"
      include.COMSYS.$$$YQHandler(m$,include.COMSYS.$$$MakeStatus(m$,"IN01045",pYKEY));
    }
    //<< }
    //<< 
    //<< quit blnCancellable
    return blnCancellable.get();
  }

  //<< 
  //<< 
  //<< HyperEvent(pYINHALT,pYVAR)
  public Object HyperEvent(Object ... _p) {
    mVar pYINHALT = m$.newVarRef("pYINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYVAR = m$.newVarRef("pYVAR",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< $$$Alert($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","P",1)))
    include.COMSYS.$$$Alert(m$,m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),"INReq","P",1)));
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< ;*******************************************************************************
  //<< ;  vvv OBSOLETE CODE - DO NOT USE vvv
  //<< ;*******************************************************************************
  //<< 
  //<< Cancel(pYM=0,pYFORM,pYKEY,pYFELD)
  public Object Cancel(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;*** DEPRECATED, Not used apart from bogus button on form INReq <DWR> ***
    //<< ;
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 19-Jan-2009   HQN     SR16296: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$$OK     ; DEPRECATED
    return include.COMSYS.$$$OK(m$);
  }

  //<< /*
  //<< new strStatus
  //<< 
  //<< set strStatus = $$$OK
  //<< ;set YOPTION = 1
  //<< if $$IsCancellable(pYKEY) {
  //<< set objReq = $get(^INReq(0,pYKEY,1))
  //<< if objReq = $$$NULLOREF {
  //<< set strStatus = $$$MakeStatus("DEV00000","NOT IMPLEMENTED")
  //<< } else {
  //<< if $$$INReqReasonCancellation(objReq) = "" {
  //<< set strStatus = $$$MakeStatus("WWW00105",$$$WWW003CaptionInForms($get(^WWW003(0,"INReq",$$$FldINReqReasonCancellation,1))))
  //<< } else {
  //<< set $$$INReqCancelled(objReq) = $$$YES
  //<< set $$$INReqDateCancellation(objReq) = +$horolog
  //<< set strStatus = $$$Save("INReq",pYKEY,objReq,$$$YES)
  //<< 
  //<< if $$$ISOK(strStatus) {
  //<< kill YBUTTON ; HACK, Get around WWWFORM killing YKEY when doing redirects from a routine called via button action
  //<< set strStatus = $$ExecuteRule(pYFORM,0,pYKEY,"manClose")
  //<< if $$$ISOK(strStatus) {
  //<< do RedirectForm^COMUtilForm(pYFORM,pYKEY,YBACK,YPARA,YSEITE)
  //<< } else {
  //<< do ReturnError^COMUtilError(strStatus)
  //<< }
  //<< ;do ManuallyClose(0,"INReq",pYKEY)
  //<< quit
  //<< }
  //<< }
  //<< }
  //<< }
  //<< $$$YQHandler(strStatus)
  //<< do:$$$ISERR(strStatus) ReturnError^COMUtilError(strStatus)
  //<< quit strStatus
  //<< */
  //<< 
  //<< 
  //<< ExecuteRule(pidForm,YM,YKEY="",pstrMethod)
  public Object ExecuteRule(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YM = m$.newVarRef("YM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstrMethod = m$.newVarRef("pstrMethod",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ; *************************** NOT USED, DEPRECATED **************************
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< ; Executes a rule (see alSYS.Script.iScriptEngine) that returns a status.
    //<< ; this is passed back to the calling method which deals with it appropriately
    //<< ;
    //<< ; Params:
    //<< ;   pidForm         The Form we are on
    //<< ;   pYM             The company data
    //<< ;   YKEY            The key of the INReq object we are dealing with
    //<< ;   pstrMethod      The type of method we are trying to perform
    //<< ;
    //<< ; Returns:
    //<< ;   Status          Error messages if needed to be displayed on screen
    //<< ;
    //<< ; History:
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to
    //<< ;                           Script Engine/State Engine)
    //<< ; 09-sep-2008   Luke    SR15897 Reverted SR15800:
    //<< ; 05-Aug-2008   Luke    SR15814: Corrected logic flow to Object for status
    //<< ; 17-Jul-2008   Luke    SR15800: Add check if the Conversion has been run
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dREQ to dUReq
    //<< ; 11-Dec-2007   HQN     Code cleanup, added new[s]
    //<< ; 17-Oct2007    LB      SR15600: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$$OK      ; DEPRECATED
    return include.COMSYS.$$$OK(m$);
  }

  //<< /*
  //<< 
  //<< new blnDoRule,objReq,sc,strStatus
  //<< 
  //<< set sc        = $$$OK
  //<< set strStatus = $$$OK
  //<< set blnDoRule = $$$YES
  //<< 
  //<< ;if ($g(^SysSetup("V2Convert"))= $$$YES) {  ///SR15800 //SR15897
  //<< if (YKEY = "+")||(YKEY = "") {
  //<< set blnDoRule = $$$NO
  //<< }
  //<< if blnDoRule {
  //<< set objReq = ##class(alREQ.dUReq).%OpenId("0||"_YKEY)
  //<< if objReq'=$$$NULLOREF {
  //<< set objReq.Date1    = $piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",2)
  //<< set objReq.DueDate  = $piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",5)
  //<< set objReq.FromLocn = $piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",4)
  //<< set objReq.Priority = $piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",6)
  //<< set objReq.ToLocn   = $piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",3)
  //<< set objReq.Status   = ##class(alSYS.Status.dUStatus).%OpenId("0||INReq||"_$piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",1))
  //<< 
  //<< set sc = ##class(alSYS.Script.iScriptEngine).RunRule(objReq,pstrMethod,pidForm)
  //<< set:$$$ISERR(sc) strStatus = $$ISStatusToDLStatus^COMUtilError(sc) ; SR15814:
  //<< 
  //<< do objReq.%Close()
  //<< }
  //<< }
  //<< ;} else {
  //<< ;   set strStatus = $$$MakeStatus("alSYS00018") ;   ///SR15800
  //<< ;}  "The COMConversion routine has not been run. Unable to proceed."
  //<< 
  //<< quit strStatus
  //<< */
  //<< 
  //<< 
  //<< ExecuteStatus(pidForm,pYM,YKEY="",pstrMethod)
  public Object ExecuteStatus(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstrMethod = m$.newVarRef("pstrMethod",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ; *************************** NOT USED, DEPRECATED **************************
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to Script Engine/State Engine)
    //<< ;-------------------------------------------------------------------------------
    //<< ; Executes a status change (see alSYS.State.iState ) for the INReq on based on a
    //<< ; set of rules (see alSYS.Script.iScriptEngine) If it fails, it responded with the
    //<< ; error message to display on screen to the user.
    //<< ;
    //<< ; Params:
    //<< ;   pidForm         The Form we are on
    //<< ;   pYM             The company data
    //<< ;   YKEY            The key of the INReq object we are dealing with
    //<< ;   pstrMethod      The type of method we are trying to perform
    //<< ;
    //<< ; Returns:
    //<< ;   Status          Error messages if needed to be displayed on screen
    //<< ; History:
    //<< ; 09-sep-2008   Luke    SR15897 Reverted SR15800:
    //<< ; 05-Aug-2008   Luke    SR15814: Corrected logic flow to Object for status
    //<< ; 30-Jan-2008   LB      SR15626 Changed the signature of dStatus to dUStatus
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dREQ to dUReq
    //<< ; 11-Dec-2007   HQN     Code cleanup, added new[s]
    //<< ; 17-Oct-2007   LB      SR15600: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$$OK     ; DEPRECATED
    return include.COMSYS.$$$OK(m$);
  }

  //<< /*
  //<< new blnDoRule,objReq,strStatus,sc
  //<< 
  //<< set sc        = $$$OK         //SR15814
  //<< set strStatus = $$$OK
  //<< set blnDoRule = $$$YES
  //<< ;if ($g(^SysSetup("V2Convert"))= $$$YES) {  ///SR15800 SR15897
  //<< if (YKEY = "+")||(YKEY = "") {
  //<< set blnDoRule = $$$NO
  //<< }
  //<< if blnDoRule {
  //<< set objReq = ##class(alREQ.dUReq).%OpenId("0||"_YKEY)
  //<< if objReq'=$$$NULLOREF {
  //<< set objReq.Date1    = $piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",2)
  //<< set objReq.DueDate  = $piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",5)
  //<< set objReq.FromLocn = $piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",4)
  //<< set objReq.Priority = $piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",6)
  //<< set objReq.ToLocn   = $piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",3)
  //<< set objReq.Status   = ##class(alSYS.Status.dUStatus).%OpenId("0||INReq||"_$piece($get(^WWWDATEN(0,+$horolog,YUSER,"INReq","D",1)),"~",1)) //SR15626
  //<< 
  //<< set sc = ##class(alSYS.State.iState).ChangeStatusV1(.objReq,pstrMethod,pidForm)
  //<< set:$$$ISERR(sc) strStatus = $$ISStatusToDLStatus^COMUtilError(sc) ; SR15814:
  //<< 
  //<< do objReq.%Close()
  //<< }
  //<< }
  //<< ;} else {
  //<< ;   set strStatus = $$$MakeStatus("alSYS00018") ;   ///SR15800
  //<< ;}  "The COMConversion routine has not been run. Unable to proceed."
  //<< 
  //<< quit strStatus
  //<< */
  //<< 
  //<< 
  //<< Reject(pYM=0,pYFORM,pYKEY,pYFELD)
  public Object Reject(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;*** DEPRECATED, Not used apart from bogus button on form INReq <DWR> ***
    //<< ;
    //<< ; History:
    //<< ; 14-Jan-2009   HQN     SR16296: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$$OK     ; DEPRECATED
    return include.COMSYS.$$$OK(m$);
  }

//<< /*
//<< new strStatus
//<< 
//<< set strStatus = $$$OK
//<< 
//<< if $$IsRejectable(pYKEY) {
//<< set objReq = $get(^INReq(0,pYKEY,1))
//<< if objReq = $$$NULLOREF {
//<< set strStatus = $$$MakeStatus("DEV00000","NOT IMPLEMENTED")
//<< 
//<< } else {
//<< if $$$INReqReasonRejection(objReq) = "" {
//<< set strStatus = $$$MakeStatus("WWW00105",$$$WWW003CaptionInForms($get(^WWW003(0,"INReq",$$$FldINReqReasonRejection,1))))
//<< } else {
//<< set $$$INReqRejected(objReq) = $$$YES
//<< set $$$INReqDateRejection(objReq) = +$horolog
//<< set strStatus = $$$Save("INReq",pYKEY,objReq,$$$YES)
//<< 
//<< if $$$ISOK(strStatus) {
//<< kill YBUTTON ; HACK, Get around WWWFORM killing YKEY when doing redirects from a routine called via button action
//<< set strStatus = $$ExecuteRule(pYFORM,0,pYKEY,"manClose") ; HUYN: Should deprecate all calls to original WIP ScriptEngine
//<< if $$$ISOK(strStatus) {
//<< do RedirectForm^COMUtilForm(pYFORM,pYKEY,YBACK,YPARA,YSEITE)
//<< } else {
//<< do ReturnError^COMUtilError(strStatus)
//<< }
//<< ;do ManuallyClose(0,"INReq",pYKEY)
//<< quit
//<< }
//<< }
//<< }
//<< }
//<< $$$YQHandler(strStatus)
//<< do:$$$ISERR(strStatus) ReturnError^COMUtilError(strStatus)
//<< quit strStatus
//<< */
//<< 
//<< /*
//<< OnAfterPrimaryKeys(pidReq,pobjReq,&pobjForm) ; DO NOTHING TAG - COMMENTED ON FORM SR17085
//<< ;-------------------------------------------------------------------------------
//<< ; History:
//<< ; 19-Jan-2009   HQN     SR16296: Moved Logic to OnBeforeButtonLine
//<< ;-------------------------------------------------------------------------------
//<< quit
//<< */
//<< 
//<< /*
//<< OnAfterButtonLine(pYM,pYFORM,pintPage,pYKEY,pYFELD) ; DO NOTHING TAG - COMMENTED ON FORM SR17085
//<< ;-------------------------------------------------------------------------------
//<< ; populate requisition with default values if FORMSPEC doesn't support all defaults
//<< ; streamline and limit possible inputs depending on state
//<< ;
//<< ; Called By : OnAfterButtonLine^INReqKit (commented), Form INReq (commented)
//<< ;
//<< ; Inputs :
//<< ;
//<< ; ByRef :
//<< ;
//<< ; Returns :
//<< ;
//<< ; History :
//<< ; 05-Nov-2007   HQN     Created
//<< ;-------------------------------------------------------------------------------
//<< quit
//<< */
//<< 
//<< /*
//<< OnAfterSave(pYM,pYFORM,pYKEY,pYFELD) ; DO NOTHING TAG - COMMENTED ON FORM SR17085
//<< ;-------------------------------------------------------------------------------
//<< ;
//<< ; Called By : Form INReq (commented)
//<< ;
//<< ; Inputs :
//<< ;
//<< ; ByRef :
//<< ;
//<< ; Returns :
//<< ;
//<< ; History :
//<< ; 30-Nov-2007   HQN     Created
//<< ;-------------------------------------------------------------------------------
//<< ; trigger updates here
//<< ;-------------------------------------------------------------------------------
//<< quit
//<< */
//<< 
//<< /*
//<< OnBlurStatus(pYINHALT,pYFELD) ; DO NOTHING TAG - COMMENTED ON FORMS SR17085
//<< ;-------------------------------------------------------------------------------
//<< ; validate that status to change to is valid
//<< ;
//<< ; Called By: Forms InReq / InReqCancel / InReqReject Field F1 "Status" OnBlur
//<< ;
//<< ; Inputs:
//<< ;   pYINHALT    the status to change to, check object status flow to validate
//<< ;   pYFELD
//<< ;
//<< ; ByRef:
//<< ;   %TXT(1)
//<< ;
//<< ; Returns :
//<< ;
//<< ; History :
//<< ; 05-Nov-2007   HQN     Created
//<< ;-------------------------------------------------------------------------------
//<< quit
//<< */
//<< 
//<< 
}
