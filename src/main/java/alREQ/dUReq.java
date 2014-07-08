//*****************************************************************************
//** TASC - ALPHALINC - CLASS alREQ.dUReq
//** Innovatium Systems - Code Converter - v1.32
//** 2014-07-07 18:53:12
//*****************************************************************************

package alREQ;

import mLibrary.*;

//<< Include (COMConst, COMSYS, WWWConst, INConst)
import include.COMConst;
import include.COMSYS;
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
import include.WWWConst;
import include.INConst;

//<< 
//<< ///
//<< /// <p>Requisition Object</p>
//<< /// <p>Represents a request for stock from one location to another location
//<< /// within a site</p>
//<< ///
//<< Class alREQ.dUReq Extends User.INReq [ ClassType = persistent, ProcedureBlock ]
public class dUReq extends User.INReq {
  //<< {
  //<< 
  //<< /*----------------------------------------------------------------------------------
  //<< // 27-Feb-2008  HQN     Added default values for properties when utilising object
  //<< //                      directly
  //<< //                      Added V2 User handling and defaults from User
  //<< // 24-Jan-2008  HQN     SR15625 Copied from dREQ; Changed class signature dLocation
  //<< //                          to dULocation & dREQLine to dUReqLine
  //<< /---------------------------------------------------------------------------------*/
  //<< /// Created By
  //<< Property CreatedBy As %String(CAPTION = "Created By", MAXLEN = 30) [ InitialExpression = "UNKNOWN" ];
  public String CreatedBy;
  //<< 
  //<< /// Created On
  //<< Property CreatedOn As WWW.DiscTimestamp(CAPTION = "Created On") [ InitialExpression = {+$h} ];
  public String CreatedOn;
  //<< 
  //<< /// Transient storage for swizzled Pseudo object property
  //<< Property objToLocn As alLOC.dULocation(CAPTION = "AL00247") [ Private, Transient ];
  private alLOC.dULocation objToLocn;
  //<< 
  //<< /// Transient storage for swizzled Pseudo object property
  //<< Property objFromLocn As alLOC.dULocation(CAPTION = "AL00245") [ Private, Transient ];
  private alLOC.dULocation objFromLocn;
  //<< 
  //<< /// Transient storage for swizzled Pseudo object property
  //<< Property objStatus As alSYS.Status.dUStatus(CAPTION = "AL00246") [ Private, Transient ];
  private alSYS.Status.dUStatus objStatus;
  //<< 
  //<< /// Transient storage for swizzled Pseudo object relation
  //<< Property ReqLines As list Of alREQ.dUReqLine(CAPTION = "AL00243") [ Transient ];
  public mList<alREQ.dUReqLine> ReqLines = new mList<alREQ.dUReqLine>();//TODO ATRIBUTO PRECISA SER INICIALIZADO
  //<< 
  //<< /// Status
  //<< Property Status As %String(CAPTION = "Status", MAXLEN = 30) [ InitialExpression = "1" ];
  public String Status;
  //<< 
  //<< Property User As alUSR.dUser(CAPTION = "AL00244") [ Transient ];
  public alUSR.dUser User;

  //<< 
  //<< ///
  //<< /// <p>Returns whether a Requisition is allowed for this instance</p>
  //<< ///
  //<< Method RequisitionAllowed() As %Boolean
  public Object RequisitionAllowed() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 01-Nov-2007   LB      SR15600: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set blnReturn = $$$YES
    mVar blnReturn = m$.var("blnReturn");
    blnReturn.set(include.COMSYS.$$$YES(m$));
    //<< if %this.ToLocn = %this.FromLocn {
    if (mOp.Equal(this.ToLocn,this.FromLocn)) {
      //<< set blnReturn = $$$NO
      blnReturn.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< ;  TODO : <GRF> Need to ensure same main location
    //<< quit blnReturn
    return blnReturn.get();
  //<< }
  }

  //<< 
  //<< /// <p>Locks this record from further editing</p>
  //<< Method FirmRequisition() As %Status
  public Object FirmRequisition() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History :
    //<< ; 07-Dec-2007   HQN     Moved validation into IsFirmable
    //<< ;-------------------------------------------------------------------------------
    //<< ; Req is invalid with no DueDate, set to today
    //<< set:(%this.DueDate = "") %this.DueDate = +$horolog
    if ((mOp.Equal(this.DueDate,""))) {
      m$.prop(this,"DueDate").set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< set sc = %this.IsFirmable()
    mVar sc = m$.var("sc");
    sc.set(m$.fnc$(this,"IsFirmable"));
    //<< 
    //<< for loopReqLine = 1:1:%this.ReqLines.Count() {
    mVar loopReqLine = m$.var("loopReqLine");
    for (loopReqLine.set(1);(mOp.LessOrEqual(loopReqLine.get(),m$.fnc$(this.ReqLines,"Count")));loopReqLine.set(mOp.Add(loopReqLine.get(),1))) {
      //<< set reqLine = %this.ReqLines.GetAt(loopReqLine)
      mVar reqLine = m$.var("reqLine");
      reqLine.set(m$.fnc$(this.ReqLines,"GetAt",loopReqLine.get()));
      //<< ;++++++++++++++++++++++++++++++++++++++++++
      //<< tstart
      //<< 
      //<< set sc = reqLine.FirmRequisition()
      sc.set(m$.fnc$(reqLine.getORef(),"FirmRequisition"));
      //<< 
      //<< if $$$ISOK(sc) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      }
      //<< tcommit:($tlevel > 0)
      //<< } else {
      else {
        //<< trollback
        //<< quit                                ;   for break
        break;
      }
    }
    //<< }
    //<< ;++++++++++++++++++++++++++++++++++++++++++
    //<< }
    //<< 
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< ///
  //<< /// <p>Sets the status for this record</p>
  //<< /// <p>Expected input to be:</br>
  //<< /// Params:</br>
  //<< /// <ul>
  //<< ///     <li>User.WWWStatus.%Oid</li>
  //<< ///     <li>WWWStatus::INReq::(Status Constant) as Integer</li>
  //<< ///     <li>%Library.ObjectHandle(Instance of WWWStatus)</li>
  //<< /// </ul>
  //<< /// </p>
  //<< ///
  //<< Method StatusSet(Arg) As %Status
  public Object StatusSet(Object ... _p) {
    mVar Arg = m$.newVarRef("Arg",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(Arg);
    //<< {
    //<< // && Arg.%Extends("alSYS.Status.dUStatus")
    //<< if ($IsObject(Arg)) {
    if (mOp.Logical((m$.Fnc.$isobject(Arg.get())))) {
      //<< set i%Status    = Arg.StatusCode
      m$.prop(this,"Status").set(m$.prop(m$.var("Arg").get(),"StatusCode").get());
      //<< set i%objStatus = $$$NULLOREF
      m$.prop(this,"objStatus").set(include.$occConstant.$$$NULLOREF(m$));
    }
    //<< 
    //<< } elseif (Arg?.N1"||".A1"||".N) {
    else if ((mOp.Match(Arg.get(),".N1\"||\".A1\"||\".N"))) {
      //<< set i%Status = $piece(Arg,"||",3) ; OID expected in this format "YM||ClassName||YKEY"
      m$.prop(this,"Status").set(m$.Fnc.$piece(Arg.get(),"||",3));
    }
    //<< 
    //<< } else {
    else {
      //<< set i%Status = Arg
      m$.prop(this,"Status").set(Arg.get());
    }
    //<< }
    //<< 
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  //<< }
  }

  //<< 
  //<< Method StatusGet() As alSYS.Status.dUStatus
  public Object StatusGet() {
    m$.newVar();
    //<< {
    //<< //set strReturn =  %this.Company_"||INReq||"_i%Status
    //<< if (i%Status '= $$$NULLOREF) && (i%objStatus = $$$NULLOREF) {
    if ((mOp.NotEqual(m$.var("i%Status").get(),include.$occConstant.$$$NULLOREF(m$))) && (mOp.Equal(m$.var("i%objStatus").get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< set i%objStatus =  ##class(alSYS.Status.dUStatus).%OpenId("0||INReq||"_i%Status)
      m$.prop(this,"objStatus").set(m$.fnc$("alSYS.Status.dUStatus.$OpenId",mOp.Concat("0||INReq||",m$.var("i%Status").get())));
    }
    //<< }
    //<< quit i%objStatus
    return m$.var("i%objStatus").get();
  //<< }
  }

  //<< 
  //<< /*
  //<< Method ReqLinesGet() As %ListOfObjects
  //<< {
  //<< if (i%ReqLines = $$$NULLOREF) {
  //<< set blnModified = %this.%IsModified()
  //<< set objReqLines    = ##class(%ListOfObjects).%New()
  //<< set reqLinesQuery = ##class(%ResultSet).%New("alREQ.dUReq:GetReqLines")
  //<< set sc = reqLinesQuery.Execute(%this.ReqNum)
  //<< while (reqLinesQuery.Next(.sc)) {
  //<< if ($SYSTEM.Status.IsOK(sc)) {
  //<< set objReqLine = ##class(alREQ.dUReqLine).%OpenId(reqLinesQuery.Data("ID"))
  //<< if (objReqLine '= $$$NULLOREF) {
  //<< ;set objReqLine.Requisition = %this
  //<< do objReqLines.Insert(objReqLine)
  //<< }
  //<< }
  //<< }
  //<< if objReqLines.Count() > 0 {
  //<< set i%ReqLines = objReqLines
  //<< do i%ReqLines.%SetModified($$$NO) ; Loading doesn't touch modification bit
  //<< do %this.%SetModified(blnModified) ; Loading doesn't touch modification bit
  //<< }
  //<< }
  //<< quit i%ReqLines
  //<< }
  //<< */
  //<< ///     Manually close a Requisition Entry<br>
  //<< ///     Returns a <class>%Status</class> refering to success/failure<p>
  //<< ///     Closes Requisition Lines, which in turn closes/process
  //<< ///         RequisitionIssueLines and updates state of DRP records</p>
  //<< ///
  //<< ///  Params:<br>
  //<< ///
  //<< ///  Returns: <br>
  //<< ///     <class>%Status</class>
  //<< Method ManuallyClose() As %Status
  public Object ManuallyClose() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History :
    //<< ; 03-Jun-2011   PPP     SR17776: When deleting Transfers update relevant info
    //<< ; 23-Sep-2010   shobby  SR17485: Quit out of loop if error on any line.
    //<< ; 23-Sep-2010   shobby  SR17485: Open transfer requires 0||
    //<< ; 23-Sep-2010   shobby  SR17485: On INReq the key is ReqNum not ReqNumber
    //<< ; 22-Sep-2010   shobby  SR17485.b: Don't check IsIssued for transfers.
    //<< ; 22-Sep-2010   shobby  SR17485.b: Corrected %Library.ResultSet spelling
    //<< ; 14-Jan-2008   HQN     SR16296: Support ReqType:2 Transfers
    //<< ; 28-Feb-2008   HQN     Changed dStatus to dUStatus
    //<< ; 30-Jan-2008   HQN     SR15625: Changed class signature dREQIssue to dUReqIssue
    //<< ; 14-Dec-2007   HQN     $$$ISOK should be $$$ISERR
    //<< ; 12-Dec-2007   HQN     Implemented Close Open Issues if this has any
    //<< ;                       Converted to %Save
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< set objManualCloseStatus = ##class(alSYS.Status.dUStatus).%OpenId("0||INReq||8") ; M-Close
    mVar objManualCloseStatus = m$.var("objManualCloseStatus");
    objManualCloseStatus.set(m$.fnc$("alSYS.Status.dUStatus.$OpenId","0||INReq||8"));
    //<< set objAutoCloseStatus   = ##class(alSYS.Status.dUStatus).%OpenId("0||INReq||9") ; A-Close
    mVar objAutoCloseStatus = m$.var("objAutoCloseStatus");
    objAutoCloseStatus.set(m$.fnc$("alSYS.Status.dUStatus.$OpenId","0||INReq||9"));
    //<< //if (%this.Status =(##class(User.WWWStatus).%OpenId("0||INReq||7")).%Id()) {
    //<< 
    //<< if (%this.ReqLines = $$$NULLOREF) || ( %this.ReqLines.Count() = 0 ) {
    if ((mOp.Equal(this.ReqLines,include.$occConstant.$$$NULLOREF(m$))) || (mOp.Equal(m$.fnc$(this.ReqLines,"Count"),0))) {
      //<< set %this.Status = objManualCloseStatus ; M-Close
      m$.prop(this,"Status").set(objManualCloseStatus.get());
      //<< set sc = %this.%Save()
      sc.set(m$.fnc$(this,"$Save"));
    }
    //<< 
    //<< } else {
    else {
      //<< //tstart
      //<< set objReqLines = %this.ReqLines
      mVar objReqLines = m$.var("objReqLines");
      objReqLines.set(this.ReqLines);
      //<< for loopLines = 1:1:objReqLines.Count() {
      mVar loopLines = m$.var("loopLines");
      for (loopLines.set(1);(mOp.LessOrEqual(loopLines.get(),m$.fnc$(objReqLines.getORef(),"Count")));loopLines.set(mOp.Add(loopLines.get(),1))) {
        //<< set objReqLine = objReqLines.GetAt(loopLines)
        mVar objReqLine = m$.var("objReqLine");
        objReqLine.set(m$.fnc$(objReqLines.getORef(),"GetAt",loopLines.get()));
        //<< if 'objReqLine.IsClosed() set sc  = objReqLine.ManuallyClose()
        if (mOp.Not(m$.fnc$(objReqLine.getORef(),"IsClosed"))) {
          sc.set(m$.fnc$(objReqLine.getORef(),"ManuallyClose"));
        }
        //<< quit:($$$ISERR(sc))
        if (mOp.Logical((include.COMSYS.$$$ISERR(m$,sc)))) {
          break;
        }
      }
      //<< }
      //<< if $$$ISERR(sc) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
      }
      //<< //  trollback
      //<< } else {
      else {
        //<< set %this.Status = objManualCloseStatus ; M-Close
        m$.prop(this,"Status").set(objManualCloseStatus.get());
        //<< set sc = %this.%Save()
        sc.set(m$.fnc$(this,"$Save"));
        //<< if $$$ISOK(sc) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
          //<< ; Determine Type
          //<< if (%this.Type = 1) { ; Department          ;SR17485.b
          if ((mOp.Equal(this.Type,1))) {
            //<< if (%this.IsIssued()) {                 ;SR17485.b
            if (mOp.Logical((m$.fnc$(this,"IsIssued")))) {
              //<< ; Manually close open Issues(Update Status[es])
              //<< set lstIssues = ##class(alREQ.dUReqIssue).GetByReqNum(%this.ReqNum,.sc)
              mVar lstIssues = m$.var("lstIssues");
              lstIssues.set(m$.fnc$("alREQ.dUReqIssue.GetByReqNum",this.ReqNum,sc));
              //<< if $$$ISOK(sc) {
              if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
                //<< for loopIssues=1:1:lstIssues.Count() {
                mVar loopIssues = m$.var("loopIssues");
                for (loopIssues.set(1);(mOp.LessOrEqual(loopIssues.get(),m$.fnc$(lstIssues.getORef(),"Count")));loopIssues.set(mOp.Add(loopIssues.get(),1))) {
                  //<< set objIssue = lstIssues.GetAt(loopIssues)
                  mVar objIssue = m$.var("objIssue");
                  objIssue.set(m$.fnc$(lstIssues.getORef(),"GetAt",loopIssues.get()));
                  //<< if objIssue.Status.StatusCode = 1 { ; Open Issue
                  if (mOp.Equal(m$.prop(objIssue.get(),"Status.StatusCode").get(),1)) {
                    //<< do objIssue.ManuallyClose()
                    m$.Cmd.Do(objIssue.getORef(),"ManuallyClose");
                  }
                }
              }
            }
          }
          //<< }
          //<< }
          //<< }
          //<< }
          //<< ; SR16296 vvvv
          //<< } elseif (%this.Type = 2) { ; Transfer
          else if ((mOp.Equal(this.Type,2))) {
            //<< ;for l=1:1:100 hang 1
            //<< set objResultSet = ##class(%Library.ResultSet).%New("alTFR.dUTransferLine:GetTransfersViaRequisition") ;SR17485
            mVar objResultSet = m$.var("objResultSet");
            objResultSet.set(m$.fnc$("$Library.ResultSet.$New","alTFR.dUTransferLine:GetTransfersViaRequisition"));
            //<< set sc = objResultSet.Execute(%this.ReqNum) ;SR17485
            sc.set(m$.fnc$(objResultSet.getORef(),"Execute",this.ReqNum));
            //<< if $$$ISOK(sc) {
            if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
              //<< while objResultSet.Next(.sc) {
              while (mOp.Logical(m$.fnc$(objResultSet.getORef(),"Next",sc))) {
                //<< //set idUTransfer  = "0||"_objResultSet.Data("ID")                                              ;SR17485
                //<< set idTfr = objResultSet.Data("ID")     //SR17776
                mVar idTfr = m$.var("idTfr");
                idTfr.set(m$.fnc$(objResultSet.getORef(),"Data","ID"));
                //<< set idUTransfer  = "0||"_idTfr          ;SR17485
                mVar idUTransfer = m$.var("idUTransfer");
                idUTransfer.set(mOp.Concat("0||",idTfr.get()));
                //<< set objUTransfer = ##class(alTFR.dUTransfer).%OpenId(idUTransfer,,.sc)  ;SR17485
                mVar objUTransfer = m$.var("objUTransfer");
                objUTransfer.set(m$.fnc$("alTFR.dUTransfer.$OpenId",idUTransfer.get(),null,sc));
                //<< if objUTransfer '= $$$NULLOREF {
                if (mOp.NotEqual(objUTransfer.get(),include.$occConstant.$$$NULLOREF(m$))) {
                  //<< if (objUTransfer.Status = 0) || (objUTransfer.Status = 1) { ; Open / Firmed
                  if ((mOp.Equal(m$.prop(objUTransfer.get(),"Status").get(),0)) || (mOp.Equal(m$.prop(objUTransfer.get(),"Status").get(),1))) {
                    //<< //set sc = objUTransfer.%DeleteId(objUTransfer.%Id())
                    //<< //SR17776 VVV
                    //<< set strStatus = $$OnBeforeDelete^INTRN("",idTfr)
                    mVar strStatus = m$.var("strStatus");
                    strStatus.set(m$.fnc$("INTRN.OnBeforeDelete","",idTfr.get()));
                    //<< if $$$ISOK(strStatus) {
                    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
                      //<< set sc = objUTransfer.%DeleteId(objUTransfer.%Id())
                      sc.set(m$.fnc$(objUTransfer.getORef(),"%DeleteId",m$.fnc$(objUTransfer.getORef(),"%Id")));
                    }
                    //<< }
                    //<< if $$$ISERR(strStatus) {
                    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
                      //<< set sc = $$$ERROR($$$GeneralError,strStatus)
                      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strStatus));
                    }
                  }
                  //<< }
                  //<< /// SR17776 ^^^
                  //<< } elseif (objUTransfer.Status = 2) { ; Sent
                  else if ((mOp.Equal(m$.prop(objUTransfer.get(),"Status").get(),2))) {
                  }
                  //<< //set sc = $$$ERR("NOT SUPPORTED YET")
                  //<< ; Reverse?
                  //<< } elseif (objUTransfer.Status = 3) { ; Received
                  else if ((mOp.Equal(m$.prop(objUTransfer.get(),"Status").get(),3))) {
                  }
                }
                //<< //set sc = $$$ERR("NOT SUPPORTED YET")
                //<< }
                //<< }
                //<< quit:$$$ISERR(sc)                                                                       ;SR17485
                if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
                  break;
                }
              }
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< ; SR16296 ^^^^
    //<< }
    //<< }
    //<< //  tcommit
    //<< }
    //<< 
    //<< }
    //<< //}
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< Method Print() As %Status
  public Object Print() {
    m$.newVar();
    //<< {
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  //<< }
  }

  //<< 
  //<< Method ANMSave(blnDpSav As %Boolean = 0) As %Status
  public Object ANMSave(Object ... _p) {
    mVar blnDpSav = m$.newVarRef("blnDpSav",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    m$.newVarExcept(blnDpSav);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 30-Oct-2009   DWR     SR16999: pass status message into $$DecodeError^COMUtilError
    //<< ; 01-Aug-2008   Luke    SR15814: Corrected sc formation and use of $$$Text
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< set sc     = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< ;  set ANMKey = %this.Company_","_%this.ReqNum
    //<< set ANMKey = %this.ReqNum
    mVar ANMKey = m$.var("ANMKey");
    ANMKey.set(this.ReqNum);
    //<< set ANMReq = ^INReq(%this.Company,%this.ReqNum,1)
    mVar ANMReq = m$.var("ANMReq");
    ANMReq.set(m$.var("^INReq",this.Company,this.ReqNum,1).get());
    //<< 
    //<< set $$$INReqStatus(ANMReq)      = i%Status
    include.INConst.$$$INReqStatusSet(m$,ANMReq,m$.var("i%Status").get());
    //<< set $$$INReqDate1(ANMReq)       = i%Date1
    include.INConst.$$$INReqDate1Set(m$,ANMReq,m$.var("i%Date1").get());
    //<< set $$$INReqToLocn(ANMReq)      = i%ToLocn
    include.INConst.$$$INReqToLocnSet(m$,ANMReq,m$.var("i%ToLocn").get());
    //<< set $$$INReqFromLocn(ANMReq)    = i%FromLocn
    include.INConst.$$$INReqFromLocnSet(m$,ANMReq,m$.var("i%FromLocn").get());
    //<< set $$$INReqDueDate(ANMReq)     = i%DueDate
    include.INConst.$$$INReqDueDateSet(m$,ANMReq,m$.var("i%DueDate").get());
    //<< set $$$INReqPriority(ANMReq)    = i%Priority
    include.INConst.$$$INReqPrioritySet(m$,ANMReq,m$.var("i%Priority").get());
    //<< set $$$INReqType(ANMReq)     = i%Type
    include.INConst.$$$INReqTypeSet(m$,ANMReq,m$.var("i%Type").get());
    //<< set $$$INReqProcessDate(ANMReq) = i%ProcessDate
    include.INConst.$$$INReqProcessDateSet(m$,ANMReq,m$.var("i%ProcessDate").get());
    //<< set $$$INReqReceiveDate(ANMReq) = i%ReceiveDate
    include.INConst.$$$INReqReceiveDateSet(m$,ANMReq,m$.var("i%ReceiveDate").get());
    //<< 
    //<< if blnDpSav {
    if (mOp.Logical(blnDpSav.get())) {
      //<< ; FIXME : Is NULLOREF test unnecessary?
      //<< if (..ReqLines '= $$$NULLOREF) || (..ReqLines.Count() '= 0) {
      if ((mOp.NotEqual(this.ReqLines,include.$occConstant.$$$NULLOREF(m$))) || (mOp.NotEqual(m$.fnc$(this.ReqLines,"Count"),0))) {
        //<< for loopLines = 1:1:..ReqLines.Count() {
        mVar loopLines = m$.var("loopLines");
        for (loopLines.set(1);(mOp.LessOrEqual(loopLines.get(),m$.fnc$(this.ReqLines,"Count")));loopLines.set(mOp.Add(loopLines.get(),1))) {
          //<< set tempReqLine = ..ReqLines.GetAt(loopLines)
          mVar tempReqLine = m$.var("tempReqLine");
          tempReqLine.set(m$.fnc$(this.ReqLines,"GetAt",loopLines.get()));
          //<< set sc          = tempReqLine.ANMSave()
          sc.set(m$.fnc$(tempReqLine.getORef(),"ANMSave"));
        }
      }
    }
    //<< /*
    //<< set ANMKeyLine =  %this.Company_","_ %this.ReqNum
    //<< set ANMReqLine = ^INReqLine(%this.Company,%this.ReqNum,loopLines)
    //<< 1 Item
    //<< 2 Unit
    //<< 3 QtyOrdered
    //<< 4 Required Quantity
    //<< 5 QtyToReceive
    //<< 6 QtyReceived
    //<< 7 QtyToIssue
    //<< 8 QtyIssued
    //<< 9 From Dept/Site
    //<< 10 Line Status
    //<< 11 DueDate
    //<< */
    //<< // ^INReqLine(0,"P0060000002",1,1)=1020~1~~4~~~~~3~1~60963
    //<< }
    //<< }
    //<< }
    //<< set strStatus = $$Save^COMUtils("INReq",ANMKey,ANMReq,$$$YES) // SR15814:
    mVar strStatus = m$.var("strStatus");
    strStatus.set(m$.fnc$("COMUtils.Save","INReq",ANMKey.get(),ANMReq.get(),include.COMSYS.$$$YES(m$)));
    //<< ; should this be a save always without checking locks?
    //<< if $$$ISERR(strStatus){
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< ;   set strMessage = $$DecodeError^COMUtilError() // SR15814:
      //<< set strMessage = $$DecodeError^COMUtilError(strStatus) // SR15814:  ; SR16999
      mVar strMessage = m$.var("strMessage");
      strMessage.set(m$.fnc$("COMUtilError.DecodeError",strStatus.get()));
      //<< set sc =$$$ERROR($$$GeneralError,strMessage) // SR15814:
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< }
    //<< 
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< /// Returns true (1) if this instance has been modified, otherwise false (0).
  //<< /// calls to Super IsModified()
  //<< Method ANMIsModified() As %Boolean
  public Object ANMIsModified() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 19-Dev-2007   LB      change comparators to object variables
    //<< ; 07-Nov-2007   LB      SR15600: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set blnReturn = $$$NO
    mVar blnReturn = m$.var("blnReturn");
    blnReturn.set(include.COMSYS.$$$NO(m$));
    //<< set objReq = ##class(alREQ.dUReq).%OpenId(%this.Company,%this.ReqNum)
    mVar objReq = m$.var("objReq");
    objReq.set(m$.fnc$("alREQ.dUReq.$OpenId",this.Company,this.ReqNum));
    //<< if objReq'= $$$NULLOREF {
    if (mOp.NotEqual(objReq.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< if (objReq.Company             '= i%Company)     ||
      //<< (objReq.Date1               '= i%Date1)       ||
      //<< (objReq.DueDate             '= i%DueDate)     ||
      //<< (objReq.FromLocn.Location   '= i%FromLocn)    ||
      //<< (objReq.Priority            '= i%Priority)    ||
      //<< (objReq.ProcessDate         '= i%ProcessDate) ||
      //<< (objReq.ReceiveDate         '= i%ReceiveDate) ||
      //<< (objReq.ReqNum              '= i%ReqNum)      ||
      //<< (objReq.Type             '= i%Type)     ||
      //<< (objReq.Status.StatusCode   '= i%Status)      ||
      //<< (objReq.ToLocn.Location     '= i%ToLocn)         {
      if ((mOp.NotEqual(m$.prop(objReq.get(),"Company").get(),m$.var("i%Company").get())) || (mOp.NotEqual(m$.prop(objReq.get(),"Date1").get(),m$.var("i%Date1").get())) || (mOp.NotEqual(m$.prop(objReq.get(),"DueDate").get(),m$.var("i%DueDate").get())) || (mOp.NotEqual(m$.prop(objReq.get(),"FromLocn.Location").get(),m$.var("i%FromLocn").get())) || (mOp.NotEqual(m$.prop(objReq.get(),"Priority").get(),m$.var("i%Priority").get())) || (mOp.NotEqual(m$.prop(objReq.get(),"ProcessDate").get(),m$.var("i%ProcessDate").get())) || (mOp.NotEqual(m$.prop(objReq.get(),"ReceiveDate").get(),m$.var("i%ReceiveDate").get())) || (mOp.NotEqual(m$.prop(objReq.get(),"ReqNum").get(),m$.var("i%ReqNum").get())) || (mOp.NotEqual(m$.prop(objReq.get(),"Type").get(),m$.var("i%Type").get())) || (mOp.NotEqual(m$.prop(objReq.get(),"Status.StatusCode").get(),m$.var("i%Status").get())) || (mOp.NotEqual(m$.prop(objReq.get(),"ToLocn.Location").get(),m$.var("i%ToLocn").get()))) {
        //<< set blnReturn = $$$YES
        blnReturn.set(include.COMSYS.$$$YES(m$));
      }
      //<< }
      //<< do objReq.%Close()
      m$.Cmd.Do(objReq.getORef(),"$Close");
    }
    //<< }
    //<< quit blnReturn
    return blnReturn.get();
  //<< }
  }

  //<< 
  //<< /// Returns true (1) if this instance has been modified, otherwise false (0).
  //<< /// calls to Super IsModified()
  //<< ///
  //<< /// Calls the @nM version of the IsModified (<code>ANMIsModified</code>
  //<< /// this is because calling the %IsModified directly will always be modified in an
  //<< /// @net Manager system <br>
  //<< Method IsModified() As %Boolean
  public Object IsModified() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 01-Nov-2007   LB      SR15600: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit ..ANMIsModified()
    return m$.fnc$(this,"ANMIsModified");
  //<< }
  }

  //<< 
  //<< ///     <p>Based on current instance state, returns wether it can go to the
  //<< ///     Firmed(WWWStatus::INReq::2) State</p>
  //<< ///
  //<< Method IsFirmable() As %Status
  public Object IsFirmable() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 30-Oct-2009   DWR     SR16999: pass status message into $$DecodeError^COMUtilError
    //<< ; 29-Oct-2008   HQN     Can't set FIRMED if already ISSUED
    //<< ; 12-Sep-2008   HQN     SR15903: Check FromStockLocn against this.ToLocn
    //<< ; 01-Aug-2008   Luke    SR15814: Corrected sc formation and use of $$$Text and use of status
    //<< ; 13-Dec-2007   GRF     Additional validation of locations
    //<< ; 07-Dec-2007   HQN     SR15598: Created; Moved and clarified No Lines check
    //<< ;                           from FirmRequisition
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = '..IsIssued()
    mVar sc = m$.var("sc");
    sc.set(mOp.Not(m$.fnc$(this,"IsIssued")));
    //<< if %this.ReqLines.Count() = 0 {
    if (mOp.Equal(m$.fnc$(this.ReqLines,"Count"),0)) {
      //<< set reqLineRow = $$$NULLOREF
      mVar reqLineRow = m$.var("reqLineRow");
      reqLineRow.set(include.$occConstant.$$$NULLOREF(m$));
      //<< set strMessage = $$$Text("INREQ15")      // SR15814:
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,"INREQ15"));
      //<< set sc =$$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< //set sc = $$$MakeStatus("INREQ15")   ; No lines exist on Requisition
    //<< }
    //<< 
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< ; Check INReq From/To Locns - same main location but different locn
      //<< set ANMKey  = %this.ReqNum
      mVar ANMKey = m$.var("ANMKey");
      ANMKey.set(this.ReqNum);
      //<< set ANMData = $get(^INReq(%this.Company,%this.ReqNum,1))
      mVar ANMData = m$.var("ANMData");
      ANMData.set(m$.Fnc.$get(m$.var("^INReq",this.Company,this.ReqNum,1)));
      //<< // VVVV // SR15814:
      //<< set strStatus = $$$OK
      mVar strStatus = m$.var("strStatus");
      strStatus.set(include.COMSYS.$$$OK(m$));
      //<< set strStatus = $$TempReqValidation^WWW0121(ANMKey,ANMData,%this.Company,%this.ToLocn.Location,%this.FromLocn.Location) // SR15814:
      strStatus.set(m$.fnc$("WWW0121.TempReqValidation",ANMKey.get(),ANMData.get(),this.Company,m$.prop(this.ToLocn,"Location").get(),m$.prop(this.FromLocn,"Location").get()));
      //<< if $$$ISERR(strStatus){
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        //<< ;set strMessage = $$DecodeError^COMUtilError()
        //<< set strMessage = $$DecodeError^COMUtilError(strStatus)     ; SR16999
        mVar strMessage = m$.var("strMessage");
        strMessage.set(m$.fnc$("COMUtilError.DecodeError",strStatus.get()));
        //<< set sc =$$$ERROR($$$GeneralError,strMessage) // SR15814:
        sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
      }
    }
    //<< }
    //<< //set sc      = $$TempReqValidation^WWW0121(ANMKey,ANMData,%this.Company,%this.ToLocn.Location,%this.FromLocn.Location)
    //<< // ^^^^ // SR15814:
    //<< }
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< for loopLines=1:1:%this.ReqLines.Count() {
      mVar loopLines = m$.var("loopLines");
      for (loopLines.set(1);(mOp.LessOrEqual(loopLines.get(),m$.fnc$(this.ReqLines,"Count")));loopLines.set(mOp.Add(loopLines.get(),1))) {
        //<< set sc = %this.ReqLines.GetAt(loopLines).IsFirmable()
        sc.set(m$.fnc$(m$.fnc$(this.ReqLines,"GetAt",loopLines.get()),"IsFirmable"));
        //<< if %this.ReqLines.GetAt(loopLines).FromStockLocn = %this.ToLocn {
        if (mOp.Equal(m$.prop(m$.fnc$(this.ReqLines,"GetAt",loopLines.get()),"FromStockLocn").get(),this.ToLocn)) {
          //<< set sc = $$$ERROR($$$GeneralError,$$$Text("IN00404")) ;Requisition requires different locations SR15903
          sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),include.COMSYS.$$$Text(m$,"IN00404")));
        }
        //<< }
        //<< quit:($$$ISERR(sc))
        if (mOp.Logical((include.COMSYS.$$$ISERR(m$,sc)))) {
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< Method NewRecord() As %Boolean
  public Object NewRecord() {
    m$.newVar();
    //<< {
    //<< set returnval = $$$NO
    mVar returnval = m$.var("returnval");
    returnval.set(include.COMSYS.$$$NO(m$));
    //<< //set x = %this.%Id()
    //<< if %this.%Id() = $$$NULLOREF {
    if (mOp.Equal(m$.fnc$(this,"$Id"),include.$occConstant.$$$NULLOREF(m$))) {
      //<< set returnval = $$$YES
      returnval.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< quit returnval
    return returnval.get();
  //<< }
  }

  //<< 
  //<< ///
  //<< /// Create an Issue Header for objLocation for all outstanding lines from this INReq
  //<< ///
  //<< Method CreateIssue(
  //<< objLocation As alLOC.dULocation,
  //<< Output sc As %Status) As alREQ.dUReqIssue
  public Object CreateIssue(Object ... _p) {
    mVar objLocation = m$.newVarRef("objLocation",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Output = m$.newVarRef("Output",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(objLocation,Output,sc);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By :
    //<< ;   INReqIssueAsReq
    //<< ;
    //<< ; History:
    //<< ; 01-Dec-2009   shobby  SR17034: Include Program1
    //<< ; 04-Jun-2009   PPP     SR16544: Type can be Dep Issue or Kit, from the Reqn
    //<< ; 18-Mar-2009   DavidR  SR16406: Added Listbuild to error
    //<< ; 01-Aug-2008   Luke    SR15814: Corrected sc formation and use of $$$Text
    //<< ; 31-Mar-2008   HQN     Force OpenId on DemandType, catches setup errors
    //<< ; 25-Feb-2008   HQN     SR15625 Changed class signature dStatus to dUStatus
    //<< ; 30-Jan-2008   HQN     SR15625 Changed class signature dREQIssue to dUReqIssue
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dLocation to dULocation
    //<< ; 13-Dec-2007   HQN     Set IssueNumber to ANM generated key
    //<< ; 12-Dec-2007   HQN     Converted to %Save
    //<< ; 06-Dec-PPP    PPP     SR15598 : Demand Type updated from 5 - Supplies to
    //<< ;                           7 - Requisitions
    //<< ; 06-Nov-2007   GRF     Create Issue Lines returns sc as ByRef
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< //for %david = 1:1:100 hang 1
    //<< 
    //<< //1 ; Open Status for INIssue
    //<< ;***************************************
    //<< tstart
    //<< ;***************************************
    //<< 
    //<< set objIssue = ##class(alREQ.dUReqIssue).%New()
    mVar objIssue = m$.var("objIssue");
    objIssue.set(m$.fnc$("alREQ.dUReqIssue.$New"));
    //<< set objIssue.Company    = %this.Company
    m$.prop(objIssue.get(),"Company").set(this.Company);
    //<< set objIssue.DemandType = ##class(User.WWW101).%OpenId("AL-DEMANDTYPE||EN||7").SearchItem   ; Requisition type from INDRPDEMAND/INDRPSUPPLY constants
    m$.prop(objIssue.get(),"DemandType").set(m$.prop(m$.fnc$("User.WWW101.$OpenId","AL-DEMANDTYPE||EN||7"),"SearchItem").get());
    //<< set objIssue.Reference  = %this.ReqNum
    m$.prop(objIssue.get(),"Reference").set(this.ReqNum);
    //<< set objIssue.FromLocn   = objLocation.Location
    m$.prop(objIssue.get(),"FromLocn").set(m$.prop(m$.var("objLocation").get(),"Location").get());
    //<< set objIssue.ToLocn     = %this.ToLocn
    m$.prop(objIssue.get(),"ToLocn").set(this.ToLocn);
    //<< set objIssue.Priority   = %this.Priority
    m$.prop(objIssue.get(),"Priority").set(this.Priority);
    //<< set objIssue.Status     = ##class(alSYS.Status.dUStatus).%OpenId("0||INIssue||1") ; Open Status
    m$.prop(objIssue.get(),"Status").set(m$.fnc$("alSYS.Status.dUStatus.$OpenId","0||INIssue||1"));
    //<< set objIssue.Program1   = %this.Program1    ;SR17034
    m$.prop(objIssue.get(),"Program1").set(this.Program1);
    //<< set strFormName = %("%KEY","YFORM")
    mVar strFormName = m$.var("strFormName");
    strFormName.set(m$.var("%","%KEY","YFORM").get());
    //<< set %("%KEY","YFORM") = "INIssue"
    m$.var("%","%KEY","YFORM").set("INIssue");
    //<< set objIssue.IssueNumber = $$^WWWNEXT("INIssue") ; ANM provided key
    m$.prop(objIssue.get(),"IssueNumber").set(m$.fnc$("WWWNEXT.main","INIssue"));
    //<< set %("%KEY","YFORM") = strFormName
    m$.var("%","%KEY","YFORM").set(strFormName.get());
    //<< 
    //<< //set objIssue.Type     = 1             //Inter-Departmental Issue
    //<< set objIssue.Type     = %this.Type      //Inter-Departmental Issue
    m$.prop(objIssue.get(),"Type").set(this.Type);
    //<< set sc = objIssue.%Save()
    sc.set(m$.fnc$(objIssue.getORef(),"%Save"));
    //<< 
    //<< ;---------------------------------------
    //<< ; Req Header        1:1                     Issue Header
    //<< ;
    //<< ;  loopReqLine vvv                          GetAt               Insert
    //<< ;       Req Line    1:n                         1   Issue Line  1
    //<< ;
    //<< ;       Req Line    1:n  CreateIssueLines =>    1   Issue Line  2
    //<< ;                                               2   Issue Line  3
    //<< ;
    //<< ;       Req Line    1:n                         1   Issue Line  4
    //<< ;---------------------------------------
    //<< 
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< for loopReqLine = 1:1:%this.ReqLines.Count() {
      mVar loopReqLine = m$.var("loopReqLine");
      for (loopReqLine.set(1);(mOp.LessOrEqual(loopReqLine.get(),m$.fnc$(this.ReqLines,"Count")));loopReqLine.set(mOp.Add(loopReqLine.get(),1))) {
        //<< set objReqLine = %this.ReqLines.GetAt(loopReqLine)
        mVar objReqLine = m$.var("objReqLine");
        objReqLine.set(m$.fnc$(this.ReqLines,"GetAt",loopReqLine.get()));
        //<< 
        //<< ;   create Issue only where there is required stock not previously issued for this location
        //<< if (objReqLine.QtyRequired > objReqLine.QtyIssued) &&
        //<< (objReqLine.FromStockLocn = objIssue.FromLocn)     {
        if ((mOp.Greater(m$.prop(objReqLine.get(),"QtyRequired").get(),m$.prop(objReqLine.get(),"QtyIssued").get())) && (mOp.Equal(m$.prop(objReqLine.get(),"FromStockLocn").get(),m$.prop(objIssue.get(),"FromLocn").get()))) {
          //<< 
          //<< ; create IssueLine from dUReqLine
          //<< set objIssueLines = objIssue.CreateIssueLines(objReqLine,.sc)
          mVar objIssueLines = m$.var("objIssueLines");
          objIssueLines.set(m$.fnc$(objIssue.getORef(),"CreateIssueLines",objReqLine.get(),sc));
          //<< quit:$$$ISERR(sc)
          if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
            break;
          }
          //<< 
          //<< for loopIssueLine=1:1:objIssueLines.Count() {
          mVar loopIssueLine = m$.var("loopIssueLine");
          for (loopIssueLine.set(1);(mOp.LessOrEqual(loopIssueLine.get(),m$.fnc$(objIssueLines.getORef(),"Count")));loopIssueLine.set(mOp.Add(loopIssueLine.get(),1))) {
            //<< set objIssueLine = objIssueLines.GetAt(loopIssueLine)
            mVar objIssueLine = m$.var("objIssueLine");
            objIssueLine.set(m$.fnc$(objIssueLines.getORef(),"GetAt",loopIssueLine.get()));
            //<< do objIssue.IssueLines.Insert(objIssueLine)
            m$.Cmd.Do(objIssue.getORef(),"IssueLines.Insert",objIssueLine.get());
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< ;   None of requisition lines belonging to this location still have stock waiting for issue
      //<< if (objIssue.IssueLines.Count() > 0) {
      if ((mOp.Greater(m$.fnc$(objIssue.getORef(),"IssueLines.Count"),0))) {
        //<< set %this.Status = ##class(alSYS.Status.dUStatus).%OpenId("0||INReq||3") ; active
        m$.prop(this,"Status").set(m$.fnc$("alSYS.Status.dUStatus.$OpenId","0||INReq||3"));
        //<< set sc = %this.ANMSave()
        sc.set(m$.fnc$(this,"ANMSave"));
      }
      //<< } else {
      else {
        //<< set strMessage = $$$Text($listbuild("INREQ16",%this.ReqNum)) ;"Couldn't create an issue for Requisition %1"     // SR15814: ;SR16406
        mVar strMessage = m$.var("strMessage");
        strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("INREQ16",this.ReqNum)));
        //<< set sc =$$$ERROR($$$GeneralError,strMessage)
        sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
      }
    }
    //<< }
    //<< }
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
    }
    //<< ;***************************************
    //<< tcommit:($tlevel>0)
    //<< } else {
    else {
      //<< trollback
      //<< set objIssue = $$$NULLOREF
      objIssue.set(include.$occConstant.$$$NULLOREF(m$));
    }
    //<< ;***************************************
    //<< }
    //<< ; should notify of errors
    //<< quit objIssue
    return objIssue.get();
  //<< }
  }

  //<< 
  //<< /*
  //<< method saveCode() as %String
  //<< {
  //<< ;***************************************
  //<< tstart
  //<< ;***************************************
  //<< set sc = objIssue.ANMSave()
  //<< if $$$ISOK(sc) {
  //<< 
  //<< for loopReqLine = 1:1:%this.ReqLines.Count() {
  //<< set objReqLine = %this.ReqLines.GetAt(loopReqLine)
  //<< ; create Issue only for lines that are in the same locn as this issue
  //<< if (objReqLine.QtyRequired > objReqLine.QtyIssued) &&
  //<< (objReqLine.FromStockLocn = objIssue.FromLocn)     {
  //<< 
  //<< ; create IssueLine from dUReqLine
  //<< set objIssueLines = objIssue.CreateIssueLines(objReqLine,.sc)
  //<< if $$$ISERR(sc) {
  //<< ;***************************************
  //<< trollback
  //<< quit ; for break
  //<< ;***************************************
  //<< } else {
  //<< for loopIssueLine=1:1:objIssueLines.Count() {
  //<< set objIssueLine = objIssueLines.GetAt(loopIssueLine)
  //<< do objIssue.IssueLines.Insert(objIssueLine)
  //<< }
  //<< ;set objIssue.IssueLines = objIssueLines ;.%ConstructClone($$$YES)
  //<< }
  //<< } else {
  //<< ; ReqLine already fulfilled
  //<< }
  //<< }
  //<< if $$$ISOK(sc) {
  //<< set %this.Status = ##class(alSYS.Status.dStatus).%OpenId("0||INReq||3") ; active
  //<< if %this.ANMSave() && (objIssue.IssueLines.Count() > 0) {
  //<< ;***************************************
  //<< tcommit
  //<< quit objIssue
  //<< } else {
  //<< trollback
  //<< quit $$$NO_"No lines created"      ; FIXME : status
  //<< ;***************************************
  //<< }
  //<< } else {
  //<< 
  //<< }
  //<< }
  //<< }
  //<< */
  //<< Method ToLocnGet() As alLOC.dULocation
  public Object ToLocnGet() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dLocation to dULocation
    //<< ;-------------------------------------------------------------------------------
    //<< if (i%ToLocn '= $$$NULLOREF) && (i%objToLocn = $$$NULLOREF) {
    if ((mOp.NotEqual(m$.var("i%ToLocn").get(),include.$occConstant.$$$NULLOREF(m$))) && (mOp.Equal(m$.var("i%objToLocn").get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< set objToLocn = ##class(alLOC.dULocation).%OpenId(0_"||"_i%ToLocn)
      mVar objToLocn = m$.var("objToLocn");
      objToLocn.set(m$.fnc$("alLOC.dULocation.$OpenId",mOp.Concat(mOp.Concat(0,"||"),m$.var("i%ToLocn").get())));
      //<< if (objToLocn '= $$$NULLOREF) {
      if ((mOp.NotEqual(objToLocn.get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< set i%objToLocn = objToLocn
        m$.prop(this,"objToLocn").set(objToLocn.get());
      }
    }
    //<< }
    //<< }
    //<< quit i%objToLocn
    return m$.var("i%objToLocn").get();
  //<< }
  }

  //<< 
  //<< Method ToLocnSet(ToLocn) As %Status
  public Object ToLocnSet(Object ... _p) {
    mVar ToLocn = m$.newVarRef("ToLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(ToLocn);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dLocation to dULocation
    //<< ;-------------------------------------------------------------------------------
    //<< if $IsObject(ToLocn) && ToLocn.%Extends("alLOC.dULocation") {
    if (mOp.Logical(m$.Fnc.$isobject(ToLocn.get())) && mOp.Logical(m$.fnc$(m$.var("ToLocn").getORef(),"%Extends","alLOC.dULocation"))) {
      //<< set i%objToLocn = ToLocn
      m$.prop(this,"objToLocn").set(ToLocn.get());
      //<< set i%ToLocn    = ToLocn.Location
      m$.prop(this,"ToLocn").set(m$.prop(m$.var("ToLocn").get(),"Location").get());
    }
    //<< } else {
    else {
      //<< set i%ToLocn = ToLocn
      m$.prop(this,"ToLocn").set(ToLocn.get());
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  //<< }
  }

  //<< 
  //<< Method FromLocnGet() As alLOC.dULocation
  public Object FromLocnGet() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dLocation to dULocation
    //<< ;-------------------------------------------------------------------------------
    //<< if (i%FromLocn '= $$$NULLOREF) && (i%objFromLocn = $$$NULLOREF) {
    if ((mOp.NotEqual(m$.var("i%FromLocn").get(),include.$occConstant.$$$NULLOREF(m$))) && (mOp.Equal(m$.var("i%objFromLocn").get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< set objFromLocn = ##class(alLOC.dULocation).%OpenId("0||"_i%FromLocn)
      mVar objFromLocn = m$.var("objFromLocn");
      objFromLocn.set(m$.fnc$("alLOC.dULocation.$OpenId",mOp.Concat("0||",m$.var("i%FromLocn").get())));
      //<< if (objFromLocn '= $$$NULLOREF) {
      if ((mOp.NotEqual(objFromLocn.get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< set i%objFromLocn = objFromLocn
        m$.prop(this,"objFromLocn").set(objFromLocn.get());
      }
    }
    //<< }
    //<< }
    //<< quit i%objFromLocn
    return m$.var("i%objFromLocn").get();
  //<< }
  }

  //<< 
  //<< Method FromLocnSet(FromLocn) As %Status
  public Object FromLocnSet(Object ... _p) {
    mVar FromLocn = m$.newVarRef("FromLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(FromLocn);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dLocation to dULocation
    //<< ;-------------------------------------------------------------------------------
    //<< if $IsObject(FromLocn) && FromLocn.%Extends("alLOC.dULocation") {
    if (mOp.Logical(m$.Fnc.$isobject(FromLocn.get())) && mOp.Logical(m$.fnc$(m$.var("FromLocn").getORef(),"%Extends","alLOC.dULocation"))) {
      //<< set i%objFromLocn = FromLocn
      m$.prop(this,"objFromLocn").set(FromLocn.get());
      //<< set i%FromLocn    = FromLocn.Location
      m$.prop(this,"FromLocn").set(m$.prop(m$.var("FromLocn").get(),"Location").get());
    }
    //<< } else {
    else {
      //<< set i%FromLocn = FromLocn
      m$.prop(this,"FromLocn").set(FromLocn.get());
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  //<< }
  }

  //<< 
  //<< /// a hack to get around the fact that the script engine can't handle
  //<< /// properties that are objects properly (YET :) )
  //<< Method ReqLinesCount() As %String
  public Object ReqLinesCount() {
    m$.newVar();
    //<< {
    //<< quit ..ReqLines.Count()
    return m$.fnc$(this.ReqLines,"Count");
  //<< }
  }

  //<< 
  //<< /// This callback method is invoked by the <METHOD>%Delete</METHOD> method to
  //<< /// provide notification that the object specified by <VAR>oid</VAR> is being deleted.
  //<< ///
  //<< /// <P>If this method returns an error then the object will not be deleted.
  //<< ClassMethod %OnDelete(oid As %ObjectIdentity) As %Status [ Private ]
  public Object $OnDelete(Object ... _p) {
    mVar oid = m$.newVarRef("oid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(oid);
    //<< {
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< set objReq = ##class(alREQ.dUReq).%Open(oid)
    mVar objReq = m$.var("objReq");
    objReq.set(m$.fnc$("alREQ.dUReq.$Open",oid.get()));
    //<< ; FIXME : $$$NULLOREF?
    //<< set listReqLines = objReq.ReqLines
    mVar listReqLines = m$.var("listReqLines");
    listReqLines.set(m$.prop(objReq.get(),"ReqLines").get());
    //<< 
    //<< for loopReqLines=1:1:listReqLines.Count() {
    mVar loopReqLines = m$.var("loopReqLines");
    for (loopReqLines.set(1);(mOp.LessOrEqual(loopReqLines.get(),m$.fnc$(listReqLines.getORef(),"Count")));loopReqLines.set(mOp.Add(loopReqLines.get(),1))) {
      //<< set objReqLine = listReqLines.GetAt(loopReqLines)
      mVar objReqLine = m$.var("objReqLine");
      objReqLine.set(m$.fnc$(listReqLines.getORef(),"GetAt",loopReqLines.get()));
      //<< set sc = objReqLine.%Delete(objReqLine.%Oid())
      sc.set(m$.fnc$(objReqLine.getORef(),"%Delete",m$.fnc$(objReqLine.getORef(),"%Oid")));
      //<< quit:$$$ISERR(sc)
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
        break;
      }
    }
    //<< }
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< /// Checks to see if the object identified by the ID <var>id</var> exists in the extent.
  //<< ///
  //<< /// <p>Returns <CLASS>%Boolean</CLASS> TRUE is it exists, FALSE if it does not.
  //<< /*
  //<< ClassMethod %ExistsId(id As %String) As %Boolean [ CodeMode = generator, ProcedureBlock = 1 ]
  //<< {
  //<< ;-------------------------------------------------------------------------------
  //<< ; Wrapper to prepend company to key before checking for record
  //<< ;
  //<< ; History
  //<< ; 27-Nov-2007   GRF     SR15615: Created
  //<< ;-------------------------------------------------------------------------------
  //<< set %code=0
  //<< $$$GENERATE(" quit ##super(""0||""_id)")
  //<< quit $$$OK
  //<< }
  //<< */
  //<< ClassMethod %ExistsId(id As %String) As %Boolean [ ProcedureBlock = 1 ]
  public Object $ExistsId(Object ... _p) {
    mVar id = m$.newVarRef("id",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(id);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper to prepend company to key before checking for record
    //<< ;
    //<< ; History
    //<< ; 27-Nov-2007   GRF     SR15615: Created
    //<< ;-------------------------------------------------------------------------------
    //<< Quit ##super("0||"_id)
    return super.$ExistsId(mOp.Concat("0||",id.get()));
  //<< }
  }

  //<< 
  //<< /// <p>Attempt to move status to WWWStatus::INReq::9 state</p>
  //<< ///
  //<< ///  Returns: Status containing why it couldn't switch state
  //<< Method AutoClose() As %Status
  public Object AutoClose() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; If all lines are closed, make sure requisition is closed
    //<< ;
    //<< ; History
    //<< ;
    //<< ; 21-May-2013   SCR     CORE-95: If Transfer (inter-site) use Rec & Rejected qty for closing
    //<< ; 19-Dec-2007   HQN     Corrected logic for detecting line closability
    //<< ;                           Corrected Status setter
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< 
    //<< if (%this.IsClosable()) {
    if (mOp.Logical((m$.fnc$(this,"IsClosable")))) {
      //<< set blnAllLinesClosed = $$$YES
      mVar blnAllLinesClosed = m$.var("blnAllLinesClosed");
      blnAllLinesClosed.set(include.COMSYS.$$$YES(m$));
      //<< for loopLines=1:1:%this.ReqLines.Count() {
      mVar loopLines = m$.var("loopLines");
      for (loopLines.set(1);(mOp.LessOrEqual(loopLines.get(),m$.fnc$(this.ReqLines,"Count")));loopLines.set(mOp.Add(loopLines.get(),1))) {
        //<< set objReqLine = %this.ReqLines.GetAt(loopLines)
        mVar objReqLine = m$.var("objReqLine");
        objReqLine.set(m$.fnc$(this.ReqLines,"GetAt",loopLines.get()));
        //<< if objReqLine.IsClosable() {         ; 'can be closed' therefore hasn't been yet
        if (mOp.Logical(m$.fnc$(objReqLine.getORef(),"IsClosable"))) {
          //<< set blnAllLinesClosed = $$$NO
          blnAllLinesClosed.set(include.COMSYS.$$$NO(m$));
          //<< quit ; for break
          break;
        }
        //<< }
        //<< ; CORE-95 vvvv
        //<< if %this.Type = 2 {
        if (mOp.Equal(this.Type,2)) {
          //<< if (objReqLine.QtyReceived + objReqLine.QtyRejected) < objReqLine.QtyRequired {
          if (mOp.Less((mOp.Add(m$.prop(objReqLine.get(),"QtyReceived").get(),m$.prop(objReqLine.get(),"QtyRejected").get())),m$.prop(objReqLine.get(),"QtyRequired").get())) {
            //<< set blnAllLinesClosed = $$$NO
            blnAllLinesClosed.set(include.COMSYS.$$$NO(m$));
            //<< quit ; for break
            break;
          }
        }
        //<< }
        //<< } else {  ; CORE-95 ^^^^
        else {
          //<< if objReqLine.QtyIssued < objReqLine.QtyRequired {
          if (mOp.Less(m$.prop(objReqLine.get(),"QtyIssued").get(),m$.prop(objReqLine.get(),"QtyRequired").get())) {
            //<< set blnAllLinesClosed = $$$NO
            blnAllLinesClosed.set(include.COMSYS.$$$NO(m$));
            //<< quit ; for break
            break;
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< if blnAllLinesClosed {
      if (mOp.Logical(blnAllLinesClosed.get())) {
        //<< ; Update status
        //<< set %this.Status = 9
        m$.prop(this,"Status").set(9);
        //<< set sc = %this.%Save()
        sc.set(m$.fnc$(this,"$Save"));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set sc = $$$MakeStatus("INREQ17")                  ; "Requisition can not be closed"
      sc.set(include.COMSYS.$$$MakeStatus(m$,"INREQ17"));
    }
    //<< }
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< Method IsClosable() As %Boolean
  public Object IsClosable() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History
    //<< ;
    //<< ; 19-Dec-2007   HQN     SR15598: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set blnResult = $$$YES
    mVar blnResult = m$.var("blnResult");
    blnResult.set(include.COMSYS.$$$YES(m$));
    //<< if (%this.Status.StatusCode = 8) ||    ; Manual - Close[d]
    //<< (%this.Status.StatusCode = 9)    {  ; Auto - Close[d]
    if ((mOp.Equal(m$.prop(this.Status,"StatusCode").get(),8)) || (mOp.Equal(m$.prop(this.Status,"StatusCode").get(),9))) {
      //<< set blnResult = $$$NO
      blnResult.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< ; check Lines for closability
    //<< for loopLines=1:1:%this.ReqLines.Count() {
    mVar loopLines = m$.var("loopLines");
    for (loopLines.set(1);(mOp.LessOrEqual(loopLines.get(),m$.fnc$(this.ReqLines,"Count")));loopLines.set(mOp.Add(loopLines.get(),1))) {
      //<< if %this.ReqLines.GetAt(loopLines).IsClosable() {
      if (mOp.Logical(m$.fnc$(m$.fnc$(this.ReqLines,"GetAt",loopLines.get()),"IsClosable"))) {
        //<< set blnResult = $$$NO
        blnResult.set(include.COMSYS.$$$NO(m$));
        //<< quit:(blnResult = $$$NO)
        if ((mOp.Equal(blnResult.get(),include.COMSYS.$$$NO(m$)))) {
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< quit blnResult
    return blnResult.get();
  //<< }
  }

  //<< 
  //<< /// This callback method is invoked by the <METHOD>%Open</METHOD> method to
  //<< /// provide notification that the object specified by <VAR>oid</VAR> is being opened.
  //<< ///
  //<< /// <P>If this method returns an error then the object will not be opened.</P>
  //<< /// <P>Load all lines for this record, sets modified to $$$NO</br>
  //<< /// Workaround for pseudo relations, this would be automated for true Relations
  //<< /// </P>
  //<< Method %OnOpen() As %Status [ Private ]
  public Object $OnOpen() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dREQLine to dUReqLine
    //<< ;-------------------------------------------------------------------------------
    //<< if (%this.ReqLines.Count() = 0) {
    if ((mOp.Equal(m$.fnc$(this.ReqLines,"Count"),0))) {
      //<< set blnModified = %this.ReqLines.%IsModified()
      mVar blnModified = m$.var("blnModified");
      blnModified.set(m$.fnc$(this.ReqLines,"$IsModified"));
      //<< set reqLinesQuery = ##class(%ResultSet).%New("alREQ.dUReqLine:GetReqLines")
      mVar reqLinesQuery = m$.var("reqLinesQuery");
      reqLinesQuery.set(m$.fnc$("$Library.ResultSet.%New","alREQ.dUReqLine:GetReqLines"));
      //<< set sc = reqLinesQuery.Execute(%this.ReqNum)
      mVar sc = m$.var("sc");
      sc.set(m$.fnc$(reqLinesQuery.getORef(),"Execute",this.ReqNum));
      //<< 
      //<< while (reqLinesQuery.Next(.sc)) {
      while (mOp.Logical((m$.fnc$(reqLinesQuery.getORef(),"Next",sc)))) {
        //<< if ($SYSTEM.Status.IsOK(sc)) {
        if (mOp.Logical((m$.getSystem().getStatus().IsOK(sc.get())))) {
          //<< set objReqLine = ##class(alREQ.dUReqLine).%OpenId(reqLinesQuery.Data("ID"))
          mVar objReqLine = m$.var("objReqLine");
          objReqLine.set(m$.fnc$("alREQ.dUReqLine.$OpenId",m$.fnc$(reqLinesQuery.getORef(),"Data","ID")));
          //<< if (objReqLine '= $$$NULLOREF) {
          if ((mOp.NotEqual(objReqLine.get(),include.$occConstant.$$$NULLOREF(m$)))) {
            //<< ;set objReqLine.Requisition = %this
            //<< do %this.ReqLines.Insert(objReqLine)
            m$.Cmd.Do(this.ReqLines,"Insert",objReqLine.get());
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< if %this.ReqLines.Count() > 0 {      ; Loading doesn't touch modification bit
      if (mOp.Greater(m$.fnc$(this.ReqLines,"Count"),0)) {
        //<< do %this.ReqLines.%SetModified($$$NO)
        m$.Cmd.Do(this.ReqLines,"$SetModified",include.COMSYS.$$$NO(m$));
        //<< do %this.%SetModified(blnModified)
        m$.Cmd.Do(this,"$SetModified",blnModified.get());
      }
    }
    //<< }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  //<< }
  }

  //<< 
  //<< /// This callback method is invoked by the <METHOD>%Save</METHOD> method to
  //<< /// provide notification that the object is being saved. It is called before
  //<< /// any data is written to disk.
  //<< ///
  //<< /// <P><VAR>insert</VAR> will be set to 1 if this object is being saved for the first time.
  //<< ///
  //<< /// <P>If this method returns an error then the call to <METHOD>%Save</METHOD> will fail.
  //<< /// <p>Makes sure edited transient objects have their values saved</p>
  //<< Method %OnBeforeSave(insert As %Boolean) As %Status [ Private ]
  public Object $OnBeforeSave(Object ... _p) {
    mVar insert = m$.newVarRef("insert",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(insert);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 28-Jul-2010   SCR     SR17471: Added Call to Super:%OnBeforeSave(insert)
    //<< ; 27-Feb-2008   HQN     Added Default loading from V2 dUser
    //<< ; 16-Dec-2007   HQN     Check for NULLOREFs
    //<< ; 06-Dec-2007   HQN     Created to make sure our Transient properties are saved
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< ; Grab default location from user if exists
    //<< if (%this.User '= $$$NULLOREF) {
    if ((mOp.NotEqual(this.User,include.$occConstant.$$$NULLOREF(m$)))) {
      //<< if (%this.ToLocn = $$$NULLOREF) {
      if ((mOp.Equal(this.ToLocn,include.$occConstant.$$$NULLOREF(m$)))) {
        //<< ; V2 -> V1.5 mangling here
        //<< set UserLocation = %this.User.HomeLocation ; V2
        mVar UserLocation = m$.var("UserLocation");
        UserLocation.set(m$.prop(this.User,"HomeLocation").get());
        //<< set:(UserLocation '= $$$NULLOREF) %this.ToLocn = UserLocation.Code
        if ((mOp.NotEqual(UserLocation.get(),include.$occConstant.$$$NULLOREF(m$)))) {
          m$.prop(this,"ToLocn").set(m$.prop(UserLocation.get(),"Code").get());
        }
      }
      //<< }
      //<< set:(%this.User.UserName '= "") %this.CreatedBy = %this.User.UserName
      if ((mOp.NotEqual(m$.prop(this.User,"UserName").get(),""))) {
        m$.prop(this,"CreatedBy").set(m$.prop(this.User,"UserName").get());
      }
    }
    //<< }
    //<< 
    //<< if (%this.Status '= $$$NULLOREF)   && (%this.Status.%IsModified()) {
    if ((mOp.NotEqual(this.Status,include.$occConstant.$$$NULLOREF(m$))) && mOp.Logical((m$.fnc$(this.Status,"$IsModified")))) {
      //<< set i%Status = %this.Status.StatusCode
      m$.prop(this,"Status").set(m$.prop(this.Status,"StatusCode").get());
    }
    //<< }
    //<< if (%this.ToLocn '= $$$NULLOREF)   && (%this.ToLocn.%IsModified()) {
    if ((mOp.NotEqual(this.ToLocn,include.$occConstant.$$$NULLOREF(m$))) && mOp.Logical((m$.fnc$(this.ToLocn,"$IsModified")))) {
      //<< set i%ToLocn = %this.ToLocn.Location
      m$.prop(this,"ToLocn").set(m$.prop(this.ToLocn,"Location").get());
    }
    //<< }
    //<< if (%this.FromLocn '= $$$NULLOREF) && (%this.FromLocn.%IsModified()) {
    if ((mOp.NotEqual(this.FromLocn,include.$occConstant.$$$NULLOREF(m$))) && mOp.Logical((m$.fnc$(this.FromLocn,"$IsModified")))) {
      //<< set i%FromLocn = %this.FromLocn.Location
      m$.prop(this,"FromLocn").set(m$.prop(this.FromLocn,"Location").get());
    }
    //<< }
    //<< set sc=##Super(insert) ; SR17471
    sc.set(super.$OnBeforeSave(insert.get()));
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< /// <P>Returns whether or not this Req has been Issued</P>
  //<< ///
  //<< Method IsIssued(Output sc) As %Boolean
  public Object IsIssued(Object ... _p) {
    mVar Output = m$.newVarRef("Output",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.newVarExcept(Output,sc);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 30-Jan-2008   HQN     SR15625 Changed class signature dREQIssue to dUReqIssue
    //<< ;-------------------------------------------------------------------------------
    //<< set blnIssued = $$$NO
    mVar blnIssued = m$.var("blnIssued");
    blnIssued.set(include.COMSYS.$$$NO(m$));
    //<< set objResultSet = ##class(%Library.ResultSet).%New("alREQ.dUReqIssue:ByReqNum")
    mVar objResultSet = m$.var("objResultSet");
    objResultSet.set(m$.fnc$("$Library.ResultSet.$New","alREQ.dUReqIssue:ByReqNum"));
    //<< set sc = objResultSet.Execute(%this.ReqNum)
    sc.set(m$.fnc$(objResultSet.getORef(),"Execute",this.ReqNum));
    //<< 
    //<< if ($$$ISOK(sc)) {
    if (mOp.Logical((include.COMSYS.$$$ISOK(m$,sc)))) {
      //<< if objResultSet.Next(.sc) {
      if (mOp.Logical(m$.fnc$(objResultSet.getORef(),"Next",sc))) {
        //<< set blnIssued = $$$YES
        blnIssued.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnIssued
    return blnIssued.get();
  //<< }
  }

  //<< 
  //<< Method IsRejectable() As %Boolean
  public Object IsRejectable() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 29-Jan-2009   HQN     SR16296: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set blnStatus = $$$YES
    mVar blnStatus = m$.var("blnStatus");
    blnStatus.set(include.COMSYS.$$$YES(m$));
    //<< quit blnStatus
    return blnStatus.get();
  //<< }
  }

  //<< 
  //<< Method Reject(strReason As %String) As %Status
  public Object Reject(Object ... _p) {
    mVar strReason = m$.newVarRef("strReason",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(strReason);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 29-Jan-2009   HQN     SR16296: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< quit sc
    return sc.get();
  //<< }
  }

//<< 
//<< }
}
