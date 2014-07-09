//*****************************************************************************
//** TASC - ALPHALINC - CLASS alREQ.dUReqLine
//** Innovatium Systems - Code Converter - v1.32
//** 2014-07-07 18:56:37
//*****************************************************************************

package alREQ;

import mLibrary.*;

//<< Include (INConst, COMSYS)
import include.INConst;
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

//<< 
//<< Class alREQ.dUReqLine Extends User.INReqLine [ ClassType = persistent, ProcedureBlock, StorageStrategy = StorageAtNet ]
public class dUReqLine extends User.INReqLine {
  //<< {
  //<< 
  //<< /*----------------------------------------------------------------------------------
  //<< ; History
  //<< ; 15-Jan-2009   HQN     Moved GetReqLines query from dUReq so the table schema
  //<< ;                           compiles in correct sequence
  //<< ; 30-Jan-2008   LB      SR15626 Changed the signature of dStatus to dUStatus
  //<< ; 24-Jan-2008   HQN     SR15625 Copied from INREQLine; Changed class signature
  //<< ;                           dLocation to dULocation and dREQ to dUReq
  //<< /---------------------------------------------------------------------------------*/
  //<< Property Company As %String(CAPTION = "AL00248", MAXLEN = 30, XMLPROJECTION = "attribute") [ InitialExpression = "0", Required ];
  public String Company;
  //<< 
  //<< Property objFromStockLocn As alLOC.dULocation(CAPTION = "AL00253") [ Private, Transient ];
  private alLOC.dULocation objFromStockLocn;
  //<< 
  //<< Property objStatus As alSYS.Status.dUStatus(CAPTION = "AL00254") [ Private, Transient ];
  private alSYS.Status.dUStatus objStatus;
  //<< 
  //<< /// QtyIssued
  //<< Property QtyIssued As %Float(CAPTION = "QtyIssued") [ InitialExpression = 0 ];
  public Double QtyIssued;
  //<< 
  //<< /// QtyReceived
  //<< Property QtyReceived As %Float(CAPTION = "QtyReceived") [ InitialExpression = 0 ];
  public Double QtyReceived;
  //<< 
  //<< /// QtyToIssue
  //<< Property QtyToIssue As %Float(CAPTION = "QtyToIssue") [ InitialExpression = 0 ];
  public Double QtyToIssue;
  //<< 
  //<< Property Requisition As alREQ.dUReq(CAPTION = "AL00250") [ Transient ];
  public alREQ.dUReq Requisition;
  //<< 
  //<< Property objSupply As User.INDRPSUPPLY(CAPTION = "AL00255") [ Transient ];
  public User.INDRPSUPPLY objSupply;
  //<< 
  //<< Property Supply As %String(CAPTION = "AL00251", TRUNCATE = 1) [ Transient ];
  public String Supply;
  //<< 
  //<< Property objDemand As User.INDRPDEMAND(CAPTION = "AL00252") [ Transient ];
  public User.INDRPDEMAND objDemand;
  //<< 
  //<< Property Demand As %String(CAPTION = "AL00249", TRUNCATE = 1) [ Transient ];
  public String Demand;

  //<< 
  //<< //++++++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< Query GetReqLines(ReqNum As %String) As %SQLQuery(CONTAINID = 1)
  public Object GetReqLines(Object ... _p) {
    mVar ReqNum = m$.newVarRef("ReqNum",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(ReqNum);
    //<< {
    //<< SELECT %ID,Company,DueDate,FromStockLocn,Item,LineNumber,QtyIssued,QtyOrdered,QtyReceived,QtyRequired,QtyToIssue,QtyToReceive,ReqNumber,Status,Unit FROM alREQ.dUReqLine
    //<< WHERE (ReqNumber = :ReqNum)
    m$.Cmd.SQL();
    return null;
  //<< }
  }

  //<< 
  //<< //++++++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< /// Updates the Status Field on the gridline for status by creating a status object
  //<< /// and taking the description from it. <br><br>
  //<< ///
  //<< ///  TODO: When we access to a USER interface, get the User details from the interface and
  //<< ///  get the information regarding the date of the parent from the DATEN. <br>
  //<< ///  At the moment resides in the INReqLine.mac <br>
  //<< Method upDateStatus()
  public Object upDateStatus() {
    m$.newVar();
    return null;
  //<< {
  }

  //<< // TODO DELETE from script and here  <lb>
  //<< ; FIXME : <GRF> rename as UpdateStatus()
  //<< ;do UpdateManualField^COMGridEdit31Interface(%this.LineNumber,10,%this.Status.StatusCode)
  //<< }
  //<< 
  //<< Method StatusSet(Arg) As %Status
  public Object StatusSet(Object ... _p) {
    mVar Arg = m$.newVarRef("Arg",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(Arg);
    //<< {
    //<< if $IsObject(Arg) && Arg.%Extends("alSYS.Status.dUStatus") {
    if (mOp.Logical(m$.Fnc.$isobject(Arg.get())) && mOp.Logical(m$.fnc$(m$.var("Arg").getORef(),"%Extends","alSYS.Status.dUStatus"))) {
      //<< set i%objStatus = $$$NULLOREF
      m$.prop(this,"objStatus").set(include.$occConstant.$$$NULLOREF(m$));
      //<< set i%Status = Arg.StatusCode
      m$.prop(this,"Status").set(m$.prop(m$.var("Arg").get(),"StatusCode").get());
    }
    //<< } elseif (Arg?.N1"||".A1"||".N) {
    else if ((mOp.Match(Arg.get(),".N1\"||\".A1\"||\".N"))) {
      //<< set i%Status = $piece(Arg,"||",3) ; hack, OID expected in this format "0||ClassName||YKEY"
      m$.prop(this,"Status").set(m$.Fnc.$piece(Arg.get(),"||",3));
    }
    //<< } else {
    else {
      //<< set i%Status = Arg
      m$.prop(this,"Status").set(Arg.get());
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  //<< }
  }

  //<< 
  //<< Method StatusGet() As alSYS.Status.dUStatus
  public Object StatusGet() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 25-Feb-2008   GRF     Corrected pairing of parentheses
    //<< ;-------------------------------------------------------------------------------
    //<< ;quit ##class(alSYS.Status.dUStatus).%OpenId("0||INReqLine||"_i%Status)
    //<< if ((i%Status '= $$$NULLOREF) && (i%objStatus = "")) ||
    //<< ($IsObject(i%objStatus)   &&  (i%objStatus.StatusCode '= i%Status)) {
    if (mOp.Logical(((mOp.NotEqual(m$.var("i%Status").get(),include.$occConstant.$$$NULLOREF(m$))) && (mOp.Equal(m$.var("i%objStatus").get(),"")))) || (mOp.Logical(m$.Fnc.$isobject(m$.var("i%objStatus").get())) && (mOp.NotEqual(m$.prop(m$.var("i%objStatus").get(),"StatusCode").get(),m$.var("i%Status").get())))) {
      //<< set i%objStatus =  ##class(alSYS.Status.dUStatus).%OpenId("0||INReqLine||"_i%Status)
      m$.prop(this,"objStatus").set(m$.fnc$("alSYS.Status.dUStatus.$OpenId",mOp.Concat("0||INReqLine||",m$.var("i%Status").get())));
    }
    //<< }
    //<< quit i%objStatus
    return m$.var("i%objStatus").get();
  //<< }
  }

  //<< 
  //<< Method RequisitionSet(objReq As alREQ.dUReq) As %Status
  public Object RequisitionSet(Object ... _p) {
    mVar objReq = m$.newVarRef("objReq",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(objReq);
    //<< {
    //<< ; attempt to do auto swizzling as a relation
    //<< set i%Requisition = objReq
    m$.prop(this,"Requisition").set(objReq.get());
    return null;
  //<< }
  }

  //<< 
  //<< Method RequisitionGet() As alREQ.dUReq
  public Object RequisitionGet() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dREQ to dUReq
    //<< ;-------------------------------------------------------------------------------
    //<< if (i%Requisition = $$$NULLOREF) && (%this.ReqNumber '= "") {
    if ((mOp.Equal(m$.var("i%Requisition").get(),include.$occConstant.$$$NULLOREF(m$))) && (mOp.NotEqual(this.ReqNumber,""))) {
      //<< set i%Requisition = ##class(alREQ.dUReq).%OpenId("0||"_%this.ReqNumber)
      m$.prop(this,"Requisition").set(m$.fnc$("alREQ.dUReq.$OpenId",mOp.Concat("0||",this.ReqNumber)));
    }
    //<< }
    //<< quit i%Requisition
    return m$.var("i%Requisition").get();
  //<< }
  }

  //<< 
  //<< Method getHeaderStatus() As %String
  public Object getHeaderStatus() {
    m$.newVar();
    //<< {
    //<< // TODO : Clean up <lb>
    //<< // Looks like we can remove this as it is not accessed
    //<< 
    //<< //FIXME : <GRF> rename as GetHeaderStatus()
    //<< quit ..Requisition.Status
    return m$.prop(this.Requisition,"Status").get();
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
  //<< Method ANMSave() As %Status
  public Object ANMSave() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; 30-Oct-2009   DWR     SR16999: pass status message into $$DecodeError^COMUtilError
    //<< ; 07-Aug-2008   Luke    SR15814 SR15831: corrected sc return value
    //<< ; 01-Aug-2008   Luke    SR15814: Corrected sc formation and use of $$$Tex
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< set ANMKeyLine = %this.Requisition.ReqNum_","_%this.LineNumber
    mVar ANMKeyLine = m$.var("ANMKeyLine");
    ANMKeyLine.set(mOp.Concat(mOp.Concat(m$.prop(this.Requisition,"ReqNum").get(),","),this.LineNumber));
    //<< set ANMReqLine = $get(^INReqLine(%this.Company,%this.Requisition.ReqNum,%this.LineNumber,1))
    mVar ANMReqLine = m$.var("ANMReqLine");
    ANMReqLine.set(m$.Fnc.$get(m$.var("^INReqLine",this.Company,m$.prop(this.Requisition,"ReqNum").get(),this.LineNumber,1)));
    //<< set $$$INReqLineItem(ANMReqLine)          = i%Item
    include.INConst.$$$INReqLineItemSet(m$,ANMReqLine,m$.var("i%Item").get());
    //<< set $$$INReqLineUnit(ANMReqLine)          = i%Unit
    include.INConst.$$$INReqLineUnitSet(m$,ANMReqLine,m$.var("i%Unit").get());
    //<< set $$$INReqLineQtyOrdered(ANMReqLine)    = i%QtyOrdered
    include.INConst.$$$INReqLineQtyOrderedSet(m$,ANMReqLine,m$.var("i%QtyOrdered").get());
    //<< set $$$INReqLineQtyRequired(ANMReqLine)   = i%QtyRequired
    include.INConst.$$$INReqLineQtyRequiredSet(m$,ANMReqLine,m$.var("i%QtyRequired").get());
    //<< set $$$INReqLineQtyToReceive(ANMReqLine)  = i%QtyToReceive
    include.INConst.$$$INReqLineQtyToReceiveSet(m$,ANMReqLine,m$.var("i%QtyToReceive").get());
    //<< set $$$INReqLineQtyReceived(ANMReqLine)   = i%QtyReceived
    include.INConst.$$$INReqLineQtyReceivedSet(m$,ANMReqLine,m$.var("i%QtyReceived").get());
    //<< set $$$INReqLineQtyToIssue(ANMReqLine)    = i%QtyToIssue
    include.INConst.$$$INReqLineQtyToIssueSet(m$,ANMReqLine,m$.var("i%QtyToIssue").get());
    //<< set $$$INReqLineQtyIssued(ANMReqLine)     = i%QtyIssued
    include.INConst.$$$INReqLineQtyIssuedSet(m$,ANMReqLine,m$.var("i%QtyIssued").get());
    //<< set $$$INReqLineFromStockLocn(ANMReqLine) = i%FromStockLocn
    include.INConst.$$$INReqLineFromStockLocnSet(m$,ANMReqLine,m$.var("i%FromStockLocn").get());
    //<< set $$$INReqLineStatus(ANMReqLine)        = i%Status
    include.INConst.$$$INReqLineStatusSet(m$,ANMReqLine,m$.var("i%Status").get());
    //<< set $$$INReqLineDueDate(ANMReqLine)       = i%DueDate
    include.INConst.$$$INReqLineDueDateSet(m$,ANMReqLine,m$.var("i%DueDate").get());
    //<< 
    //<< set strStatus = $$Save^COMUtils("INReqLine",ANMKeyLine,ANMReqLine,$$$YES)
    mVar strStatus = m$.var("strStatus");
    strStatus.set(m$.fnc$("COMUtils.Save","INReqLine",ANMKeyLine.get(),ANMReqLine.get(),include.COMSYS.$$$YES(m$)));
    //<< ; should this be a save always without checking locks?
    //<< if $$$ISERR(strStatus){
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set strMessage = $$DecodeError^COMUtilError(strStatus)
      mVar strMessage = m$.var("strMessage");
      strMessage.set(m$.fnc$("COMUtilError.DecodeError",strStatus.get()));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< }
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< Method SupplyGet() As User.INDRPSUPPLY
  public Object SupplyGet() {
    m$.newVar();
    //<< {
    //<< if (%this.%Id()'=$$$NULLOREF) && (i%objSupply=$$$NULLOREF) {
    if ((mOp.NotEqual(m$.fnc$(this,"$Id"),include.$occConstant.$$$NULLOREF(m$))) && (mOp.Equal(m$.var("i%objSupply").get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< set objResultSet = ##class(%Library.ResultSet).%New()
      mVar objResultSet = m$.var("objResultSet");
      objResultSet.set(m$.fnc$("$Library.ResultSet.$New"));
      //<< do objResultSet.Prepare("SELECT ID FROM SQLUser.INDRPSUPPLY WHERE SupplyType = 7 AND RequisitionNumber = ? AND Reference = ?")
      m$.Cmd.Do(objResultSet.getORef(),"Prepare","SELECT ID FROM SQLUser.INDRPSUPPLY WHERE SupplyType = 7 AND RequisitionNumber = ? AND Reference = ?");
      //<< set sc = objResultSet.Execute(%this.ReqNumber, %this.LineNumber)
      mVar sc = m$.var("sc");
      sc.set(m$.fnc$(objResultSet.getORef(),"Execute",this.ReqNumber,this.LineNumber));
      //<< if objResultSet.Next(.sc) {
      if (mOp.Logical(m$.fnc$(objResultSet.getORef(),"Next",sc))) {
        //<< set objSupply = ##class(User.INDRPSUPPLY).%OpenId(objResultSet.Get("ID"))
        mVar objSupply = m$.var("objSupply");
        objSupply.set(m$.fnc$("User.INDRPSUPPLY.$OpenId",m$.fnc$(objResultSet.getORef(),"Get","ID")));
        //<< if '$$$ISERR(objSupply) {
        if (mOp.Not(include.COMSYS.$$$ISERR(m$,objSupply))) {
          //<< set i%Supply    = objSupply.SupplyNo
          m$.prop(this,"Supply").set(m$.prop(objSupply.get(),"SupplyNo").get());
          //<< set i%objSupply = objSupply
          m$.prop(this,"objSupply").set(objSupply.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit i%objSupply
    return m$.var("i%objSupply").get();
  //<< }
  }

  //<< 
  //<< Method DemandGet() As User.INDRPDEMAND
  public Object DemandGet() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 07-Dec-2007   HQN     Changed DemandType value comparison to reflect new
    //<< ;                           status code (5 -> 7)
    //<< ;-------------------------------------------------------------------------------
    //<< if (%this.%Id()'=$$$NULLOREF) && (i%objDemand=$$$NULLOREF) {
    if ((mOp.NotEqual(m$.fnc$(this,"$Id"),include.$occConstant.$$$NULLOREF(m$))) && (mOp.Equal(m$.var("i%objDemand").get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< set objResultSet = ##class(%Library.ResultSet).%New()
      mVar objResultSet = m$.var("objResultSet");
      objResultSet.set(m$.fnc$("$Library.ResultSet.$New"));
      //<< do objResultSet.Prepare("SELECT ID FROM SQLUser.INDRPDEMAND WHERE DemandType = 7 AND RequisitionNumber = ? AND Reference = ?")
      m$.Cmd.Do(objResultSet.getORef(),"Prepare","SELECT ID FROM SQLUser.INDRPDEMAND WHERE DemandType = 7 AND RequisitionNumber = ? AND Reference = ?");
      //<< set sc = objResultSet.Execute(%this.ReqNumber, %this.LineNumber)
      mVar sc = m$.var("sc");
      sc.set(m$.fnc$(objResultSet.getORef(),"Execute",this.ReqNumber,this.LineNumber));
      //<< if objResultSet.Next(.sc) {
      if (mOp.Logical(m$.fnc$(objResultSet.getORef(),"Next",sc))) {
        //<< set objDemand = ##class(User.INDRPDEMAND).%OpenId(objResultSet.Get("ID"))
        mVar objDemand = m$.var("objDemand");
        objDemand.set(m$.fnc$("User.INDRPDEMAND.$OpenId",m$.fnc$(objResultSet.getORef(),"Get","ID")));
        //<< if '$$$ISERR(objDemand) {
        if (mOp.Not(include.COMSYS.$$$ISERR(m$,objDemand))) {
          //<< set i%Demand = objDemand.DemandNo
          m$.prop(this,"Demand").set(m$.prop(objDemand.get(),"DemandNo").get());
          //<< set i%objDemand = objDemand
          m$.prop(this,"objDemand").set(objDemand.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit i%objDemand
    return m$.var("i%objDemand").get();
  //<< }
  }

  //<< 
  //<< Method FromStockLocnSet(strStockLocn) As %Status
  public Object FromStockLocnSet(Object ... _p) {
    mVar strStockLocn = m$.newVarRef("strStockLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(strStockLocn);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dLocation to dULocation
    //<< ;-------------------------------------------------------------------------------
    //<< if $IsObject(strStockLocn) && strStockLocn.%Extends("alLOC.dULocation") {
    if (mOp.Logical(m$.Fnc.$isobject(strStockLocn.get())) && mOp.Logical(m$.fnc$(m$.var("strStockLocn").getORef(),"%Extends","alLOC.dULocation"))) {
      //<< set i%objFromStockLocn = strStockLocn
      m$.prop(this,"objFromStockLocn").set(strStockLocn.get());
      //<< set i%FromStockLocn = i%objFromStockLocn.Location
      m$.prop(this,"FromStockLocn").set(m$.prop(m$.var("i%objFromStockLocn").get(),"Location").get());
    }
    //<< 
    //<< } elseif (strStockLocn?.N1"||".A1"||".N) {
    else if ((mOp.Match(strStockLocn.get(),".N1\"||\".A1\"||\".N"))) {
      //<< set i%FromStockLocn = $piece(strStockLocn,"||",3) ; hack, OID expected in this format "0||ClassName||YKEY"
      m$.prop(this,"FromStockLocn").set(m$.Fnc.$piece(strStockLocn.get(),"||",3));
    }
    //<< 
    //<< } else {
    else {
      //<< set i%FromStockLocn = strStockLocn
      m$.prop(this,"FromStockLocn").set(strStockLocn.get());
    }
    return null;
  //<< }
  }

  //<< }
  //<< 
  //<< Method FromStockLocnGet() As alLOC.dULocation
  public Object FromStockLocnGet() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dLocation to dULocation
    //<< ;-------------------------------------------------------------------------------
    //<< if (i%FromStockLocn '= $$$NULLOREF) && (i%objFromStockLocn = $$$NULLOREF) {
    if ((mOp.NotEqual(m$.var("i%FromStockLocn").get(),include.$occConstant.$$$NULLOREF(m$))) && (mOp.Equal(m$.var("i%objFromStockLocn").get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< set objFromStockLocn = ##class(alLOC.dULocation).%OpenId("0||"_i%FromStockLocn)
      mVar objFromStockLocn = m$.var("objFromStockLocn");
      objFromStockLocn.set(m$.fnc$("alLOC.dULocation.$OpenId",mOp.Concat("0||",m$.var("i%FromStockLocn").get())));
      //<< if (objFromStockLocn '= $$$NULLOREF) {
      if ((mOp.NotEqual(objFromStockLocn.get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< set i%objFromStockLocn = objFromStockLocn
        m$.prop(this,"objFromStockLocn").set(objFromStockLocn.get());
      }
    }
    //<< }
    //<< }
    //<< quit i%objFromStockLocn
    return m$.var("i%objFromStockLocn").get();
  //<< }
  }

  //<< 
  //<< Method AutoClose() As %Status
  public Object AutoClose() {
    m$.newVar();
    //<< {
    //<< ;---------------------------------------------------------------------
    //<< ; History
    //<< ; 05-Jul-2012   SCR     SR18045:Consider Rejected Quantity also
    //<< ; 03-Jun-2011   PPP     SR17776:If Already closed do not try closing
    //<< ; 26-Feb-2008   GRF     Error code; $$$MakeStatus (SR15814?)
    //<< ; 18-Dec-2007   HQN     Altered check to utilise QtyReceived instead
    //<< ;                           of Issued
    //<< ;---------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if '%this.IsClosed()    {
    if (mOp.Not(m$.fnc$(this,"IsClosed"))) {
      //<< if %this.IsClosable() {
      if (mOp.Logical(m$.fnc$(this,"IsClosable"))) {
        //<< ;if %this.QtyReceived >= %this.QtyRequired {
        //<< if (%this.QtyReceived + %this.QtyRejected)>= %this.QtyRequired {
        if (mOp.GreaterOrEqual((mOp.Add(this.QtyReceived,this.QtyRejected)),this.QtyRequired)) {
          //<< set %this.Status = 9 ; Auto - Close
          m$.prop(this,"Status").set(9);
        }
        //<< }
        //<< set sc = %this.%Save()
        sc.set(m$.fnc$(this,"$Save"));
      }
      //<< } else {
      else {
        //<< set strMessage = $$$Text("IN00731")
        mVar strMessage = m$.var("strMessage");
        strMessage.set(include.COMSYS.$$$Text(m$,"IN00731"));
        //<< set sc = $$$ERROR($$$GeneralError,strMessage)
        sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
      }
    }
    //<< } ; "Not in a closable state"
    //<< }
    //<< 
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< Method ManuallyClose() As %Status
  public Object ManuallyClose() {
    m$.newVar();
    //<< {
    //<< ;---------------------------------------------------------------------
    //<< ; History
    //<< ; 20-Sep-2010   shobby  SR17485: Don't close if not closeable.
    //<< ; 27-Jan-2010   PPP     SR17145: If the Req Line has an Imported Demand,
    //<< ;                       reset the demand values
    //<< ; 14-Dec-2007   HQN     Check for NULLOREF INDRP due to Open ReqLines
    //<< ; 06-Dec-2007   HQN     TODO: Remove/Unlink Issues associated with
    //<< ;                           this Requisition
    //<< ;---------------------------------------------------------------------
    //<< set sc=$$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< if ..IsClosable() {
    if (mOp.Logical(m$.fnc$(this,"IsClosable"))) {
      //<< set objManualCloseStatus = ##class(alSYS.Status.dUStatus).%OpenId("0||INReqLine||8") ; M-Close
      mVar objManualCloseStatus = m$.var("objManualCloseStatus");
      objManualCloseStatus.set(m$.fnc$("alSYS.Status.dUStatus.$OpenId","0||INReqLine||8"));
      //<< set objAutoCloseStatus   = ##class(alSYS.Status.dUStatus).%OpenId("0||INReqLine||9") ; A-Close
      mVar objAutoCloseStatus = m$.var("objAutoCloseStatus");
      objAutoCloseStatus.set(m$.fnc$("alSYS.Status.dUStatus.$OpenId","0||INReqLine||9"));
      //<< 
      //<< if (%this.QtyRequired > %this.QtyIssued) {
      if ((mOp.Greater(this.QtyRequired,this.QtyIssued))) {
        //<< set %this.QtyRequired = %this.QtyIssued
        m$.prop(this,"QtyRequired").set(this.QtyIssued);
      }
      //<< }
      //<< if (%this.QtyRequired > %this.QtyReceived) {
      if ((mOp.Greater(this.QtyRequired,this.QtyReceived))) {
        //<< set %this.QtyRequired = %this.QtyReceived
        m$.prop(this,"QtyRequired").set(this.QtyReceived);
      }
      //<< }
      //<< set %this.Status = objManualCloseStatus
      m$.prop(this,"Status").set(objManualCloseStatus.get());
      //<< 
      //<< // Update Imported Demand    ; SR17145
      //<< if %this.ImportedDemand {
      if (mOp.Logical(this.ImportedDemand)) {
        //<< do ResetDemand^INDRPReq(%this)
        m$.Cmd.Do("INDRPReq.ResetDemand",this);
      }
      //<< 
      //<< } else {
      else {
        //<< ; set closed for DRP records
        //<< if %this.Supply '= $$$NULLOREF {
        if (mOp.NotEqual(this.Supply,include.$occConstant.$$$NULLOREF(m$))) {
          //<< set %this.Supply.Closed = $$$YES
          m$.prop(this.Supply,"Closed").set(include.COMSYS.$$$YES(m$));
          //<< do %this.Supply.%Save()
          m$.Cmd.Do(this.Supply,"$Save");
        }
        //<< }
        //<< 
        //<< if %this.Demand '= $$$NULLOREF {
        if (mOp.NotEqual(this.Demand,include.$occConstant.$$$NULLOREF(m$))) {
          //<< set %this.Demand.DemandClosed = $$$YES
          m$.prop(this.Demand,"DemandClosed").set(include.COMSYS.$$$YES(m$));
          //<< do %this.Demand.%Save()
          m$.Cmd.Do(this.Demand,"$Save");
        }
      }
    }
    //<< }
    //<< }
    //<< } else {
    else {
      //<< set strMessage = $$$Text("IN01265")
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,"IN01265"));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< } ; "Unable to close."
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< Method ManuallyCloseRelated() As %Status
  public Object ManuallyCloseRelated() {
    m$.newVar();
    //<< {
    //<< if (..Requisition.Type = 1) { ; Department
    if ((mOp.Equal(m$.prop(this.Requisition,"Type").get(),1))) {
      //<< set sc=..ManuallyCloseRelatedIssues()
      mVar sc = m$.var("sc");
      sc.set(m$.fnc$(this,"ManuallyCloseRelatedIssues"));
    }
    //<< } elseif (..Requisition.Type = 2) { ;Transfers
    else if ((mOp.Equal(m$.prop(this.Requisition,"Type").get(),2))) {
      //<< set sc=..ManuallyCloseRelatedTransfers()
      mVar sc = m$.var("sc");
      sc.set(m$.fnc$(this,"ManuallyCloseRelatedTransfers"));
    }
    //<< }
    //<< quit sc
    return m$.var("sc").get();
  //<< }
  }

  //<< 
  //<< Method ManuallyCloseRelatedIssues() As %Status
  public Object ManuallyCloseRelatedIssues() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Close the issues related to this line
    //<< ;
    //<< ; Called By : Button
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 13-Sep-2010   shobby  SR17485:Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< set lstIssues = ##class(alREQ.dUReqIssue).GetByReqNum(%this.ReqNumber,.sc)
    mVar lstIssues = m$.var("lstIssues");
    lstIssues.set(m$.fnc$("alREQ.dUReqIssue.GetByReqNum",this.ReqNumber,m$.var("sc")));
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,m$.var("sc")))) {
      //<< for loopIssues=1:1:lstIssues.Count() {
      mVar loopIssues = m$.var("loopIssues");
      for (loopIssues.set(1);(mOp.LessOrEqual(loopIssues.get(),m$.fnc$(lstIssues.getORef(),"Count")));loopIssues.set(mOp.Add(loopIssues.get(),1))) {
        //<< set objIssue = lstIssues.GetAt(loopIssues)
        mVar objIssue = m$.var("objIssue");
        objIssue.set(m$.fnc$(lstIssues.getORef(),"GetAt",loopIssues.get()));
        //<< if objIssue.Status.StatusCode = 1 { ; Open Issue
        if (mOp.Equal(m$.prop(objIssue.get(),"Status.StatusCode").get(),1)) {
          //<< for loopIssueLine=1:1:objIssue.IssueLines.Count() {
          mVar loopIssueLine = m$.var("loopIssueLine");
          for (loopIssueLine.set(1);(mOp.LessOrEqual(loopIssueLine.get(),m$.fnc$(objIssue.getORef(),"IssueLines.Count")));loopIssueLine.set(mOp.Add(loopIssueLine.get(),1))) {
            //<< set objIssueLine = objIssue.IssueLines.GetAt(loopIssueLine)
            mVar objIssueLine = m$.var("objIssueLine");
            objIssueLine.set(m$.fnc$(objIssue.getORef(),"IssueLines.GetAt",loopIssueLine.get()));
            //<< if objIssueLine.Reference=%this.LineNumber {
            if (mOp.Equal(m$.prop(objIssueLine.get(),"Reference").get(),this.LineNumber)) {
              //<< set sc = objIssueLine.ManuallyClose()
              mVar sc = m$.var("sc");
              sc.set(m$.fnc$(objIssueLine.getORef(),"ManuallyClose"));
              //<< if $$$ISOK(sc) set sc = objIssueLine.%Save()
              if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
                sc.set(m$.fnc$(objIssueLine.getORef(),"%Save"));
              }
            }
            //<< }
            //<< quit:$$$ISERR(sc)
            if (mOp.Logical(include.COMSYS.$$$ISERR(m$,m$.var("sc")))) {
              break;
            }
          }
        }
        //<< }
        //<< }
        //<< quit:$$$ISERR(sc)
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,m$.var("sc")))) {
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< quit sc
    return m$.var("sc").get();
  //<< }
  }

  //<< 
  //<< Method ManuallyCloseRelatedTransfers()
  public Object ManuallyCloseRelatedTransfers() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Close the issues related to this line
    //<< ;
    //<< ; Called By : Button
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 13-Sep-2010   shobby  SR17485:Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set objResultSet = ##class(%Library.ResultSet).%New("alTFR.dUTransferLine:GetTfrLinesViaReqLines")
    mVar objResultSet = m$.var("objResultSet");
    objResultSet.set(m$.fnc$("$Library.ResultSet.$New","alTFR.dUTransferLine:GetTfrLinesViaReqLines"));
    //<< set sc = objResultSet.Execute(%this.ReqNumber,%this.LineNumber)
    sc.set(m$.fnc$(objResultSet.getORef(),"Execute",this.ReqNumber,this.LineNumber));
    //<< 
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< while objResultSet.Next(.sc) {
      while (mOp.Logical(m$.fnc$(objResultSet.getORef(),"Next",sc))) {
        //<< quit:$$$ISERR(sc)
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
          break;
        }
        //<< set idTransferLine="0||"_objResultSet.Data("ID")_"||"_objResultSet.Data("Line")
        mVar idTransferLine = m$.var("idTransferLine");
        idTransferLine.set(mOp.Concat(mOp.Concat(mOp.Concat("0||",m$.fnc$(objResultSet.getORef(),"Data","ID")),"||"),m$.fnc$(objResultSet.getORef(),"Data","Line")));
        //<< set objUTransferLine = ##class(alTFR.dUTransferLine).%OpenId(idTransferLine,,.sc)
        mVar objUTransferLine = m$.var("objUTransferLine");
        objUTransferLine.set(m$.fnc$("alTFR.dUTransferLine.$OpenId",idTransferLine.get(),null,sc));
        //<< if objUTransferLine '= $$$NULLOREF {
        if (mOp.NotEqual(objUTransferLine.get(),include.$occConstant.$$$NULLOREF(m$))) {
          //<< set intStatus = objUTransferLine.Transfer.Status
          mVar intStatus = m$.var("intStatus");
          intStatus.set(m$.prop(objUTransferLine.get(),"Transfer.Status").get());
          //<< if (intStatus = 0) {        ; Open
          if ((mOp.Equal(intStatus.get(),0))) {
            //<< if objUTransferLine.Transfer.TfrLines.Count()=1 {
            if (mOp.Equal(m$.fnc$(objUTransferLine.getORef(),"Transfer.TfrLines.Count"),1)) {
              //<< set sc = objUTransferLine.Transfer.%DeleteId(objUTransferLine.%Id())
              sc.set(m$.fnc$(objUTransferLine.getORef(),"Transfer.%DeleteId",m$.fnc$(objUTransferLine.getORef(),"%Id")));
            }
            //<< }
            //<< if $$$ISOK(sc) set sc = objUTransferLine.%DeleteId(objUTransferLine.%Id())
            if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
              sc.set(m$.fnc$(objUTransferLine.getORef(),"%DeleteId",m$.fnc$(objUTransferLine.getORef(),"%Id")));
            }
          }
          //<< } else {  ; Firmed and others
          else {
            //<< set sc = $$$MakeStatus("Unable to delete") ;######    ; FIXME WWW009
            sc.set(include.COMSYS.$$$MakeStatus(m$,"Unable to delete"));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< /// Firms the REQLine <br>
  //<< ///
  //<< /// checks to see if it is firmable,
  //<< /// then creates a supply and demand if it can be.
  //<< /// <br>
  //<< Method FirmRequisition() As %Status
  public Object FirmRequisition() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History
    //<< ; 12-Feb-2010   GRF     SR17145/2: INDRPReq functions return strStatus - convert
    //<< ;                           to sc here if necessary
    //<< ; 11-Feb-2010   PPP     SR17145/1: Checked Status correctly
    //<< ; 27-Jan-2010   PPP     SR17145: If the Req Line has an Imported Demand, do not
    //<< ;                           create a new one
    //<< ; 07-Dec-2007   HQN     SR15598: Checks validity before processing
    //<< ;-------------------------------------------------------------------------------
    //<< /* now set prior to operating
    //<< if (%this.QtyOrdered = $$$NULLOREF) || (%this.QtyOrdered = 0) {
    //<< set %this.QtyOrdered = %this.QtyRequired
    //<< }*/
    //<< set sc = %this.IsFirmable()
    mVar sc = m$.var("sc");
    sc.set(m$.fnc$(this,"IsFirmable"));
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< if %this.DueDate = ""     set %this.DueDate     = +$horolog
      if (mOp.Equal(this.DueDate,"")) {
        m$.prop(this,"DueDate").set(mOp.Positive(m$.Fnc.$horolog()));
      }
      //<< if %this.QtyToIssue = ""  set %this.QtyToIssue  = 0
      if (mOp.Equal(this.QtyToIssue,"")) {
        m$.prop(this,"QtyToIssue").set(0);
      }
      //<< if %this.QtyIssued = ""   set %this.QtyIssued   = 0
      if (mOp.Equal(this.QtyIssued,"")) {
        m$.prop(this,"QtyIssued").set(0);
      }
      //<< if %this.QtyReceived = "" set %this.QtyReceived = 0
      if (mOp.Equal(this.QtyReceived,"")) {
        m$.prop(this,"QtyReceived").set(0);
      }
      //<< 
      //<< //set sc = $$$NO
      //<< //SR17145
      //<< /*if %this.ImportedDemand || ($$CreateSupply^INDRPReq(%this,.supplykey) && $$CreateDemand^INDRPReq(%this,supplykey)) {
      //<< set %this.Status = 2                                 ; Firmed
      //<< set sc = %this.ANMSave()
      //<< }
      //<< */
      //<< 
      //<< //SR17145
      //<< //set strStatus =$$$OK
      //<< set supplyKey = ""
      mVar supplyKey = m$.var("supplyKey");
      supplyKey.set("");
      //<< if %this.ImportedDemand {      // Update demand
      if (mOp.Logical(this.ImportedDemand)) {
        //<< set strStatus = $$UpdateDemand^INDRPReq(%this)
        mVar strStatus = m$.var("strStatus");
        strStatus.set(m$.fnc$("INDRPReq.UpdateDemand",this));
      }
      //<< 
      //<< } else {                       // Create a Demand & Supply
      else {
        //<< set strStatus = $$CreateSupply^INDRPReq(%this,.supplykey)     // SR17145/1 SR17145/2
        mVar strStatus = m$.var("strStatus");
        strStatus.set(m$.fnc$("INDRPReq.CreateSupply",this,m$.var("supplykey")));
        //<< if $$$ISOK(strStatus) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
          //<< set strStatus = $$CreateDemand^INDRPReq(%this,supplykey)
          strStatus.set(m$.fnc$("INDRPReq.CreateDemand",this,m$.var("supplykey").get()));
        }
      }
      //<< }
      //<< }
      //<< if $$$ISERR(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,m$.var("strStatus")))) {
        //<< set sc = $$$ERROR($$$GeneralError,$$DecodeError^COMUtilError(strStatus))   ; SR17145/2
        sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),m$.fnc$("COMUtilError.DecodeError",m$.var("strStatus").get())));
      }
      //<< }
      //<< 
      //<< if $$$ISOK(sc) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
        //<< set %this.Status = 2                                 ; Firmed
        m$.prop(this,"Status").set(2);
        //<< set sc = %this.ANMSave()
        sc.set(m$.fnc$(this,"ANMSave"));
      }
    }
    //<< }
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
  //<< ;
  //<< ; TODO : Check if now obsolete
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
    //<< ;
    //<< ; TODO : Check if now obsolete
    //<< ;
    //<< ; History
    //<< ; 27-Nov-2007   GRF     SR15615: Created
    //<< ;-------------------------------------------------------------------------------
    //<< Quit ##super("0||"_id)
    return super.$ExistsId(mOp.Concat("0||",id.get()));
  //<< }
  }

  //<< 
  //<< /// Checks if the Line can be changed into a firmed status. <br>
  //<< /// this checks <br>
  //<< ///     - QtyRequired is greater than 0 and not less then 0  <br>
  //<< /// <br>
  //<< /// TODO <br>
  //<< /// Add Location validation review<br>
  //<< /// if %this.objFromStockLocn<br>
  //<< /// if %this.ReqNumber.objToLocn<br>
  //<< /// ValidRelation^WWWFieldValidation<br>
  //<< Method IsFirmable() As %Status
  public Object IsFirmable() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; History
    //<< ; 08-Jun-2010   PPP     SR17351: Allow ""/0 on QuantityRequired
    //<< ; 09-Oct-2008   Luke    SR16017: Allow "" on the datedue field
    //<< ; 07-Oct-2008   Luke    SR15946: added date check on the line
    //<< ; 01-Aug-2008   Luke    SR15814: Corrected sc formation and use of $$$Text
    //<< ; 20-May-2008   HQN     SR15762: Corrected passing back status code for QtyRequired
    //<< ; 02-May-2008   Luke    SR15699: Language codes for errors
    //<< ; 13-Dec-2007   GRF     Additional validation of locations
    //<< ; 07-Dec-2007   HQN     SR15598: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< //VV SR17351
    //<< // (%this.QtyRequired = "") || (%this.QtyRequired < 0) {
    //<< //  set strMessage =$$$Text($listbuild("alREQ0003",%this.LineNumber))
    //<< //  set sc =$$$ERROR($$$GeneralError,strMessage)
    //<< //}
    //<< //if $$$ISOK(sc) && (%this.QtyRequired = 0) {
    //<< //  set strMessage =$$$Text($listbuild("alREQ0004",%this.LineNumber))
    //<< //  set sc =$$$ERROR($$$GeneralError,strMessage)
    //<< //} //^^ SR17351
    //<< 
    //<< if $$$ISOK(sc) && (%this.DueDate '= "" ) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc)) && (mOp.NotEqual(this.DueDate,""))) {
      //<< if (%this.DueDate < $horolog) {
      if ((mOp.Less(this.DueDate,m$.Fnc.$horolog()))) {
        //<< set strMessage = $$$Text("INREQ23")
        mVar strMessage = m$.var("strMessage");
        strMessage.set(include.COMSYS.$$$Text(m$,"INREQ23"));
        //<< set sc = $$$ERROR($$$GeneralError,strMessage)
        sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< ; Check INReqLine FromLocn to INReq ToLocn must be same main locn but different locn
      //<< set ANMKey    = %this.Requisition.ReqNum_","_%this.LineNumber
      mVar ANMKey = m$.var("ANMKey");
      ANMKey.set(mOp.Concat(mOp.Concat(m$.prop(this.Requisition,"ReqNum").get(),","),this.LineNumber));
      //<< set ANMData   = $get(^INReqLine(%this.Company,%this.Requisition.ReqNum,%this.LineNumber,1))
      mVar ANMData = m$.var("ANMData");
      ANMData.set(m$.Fnc.$get(m$.var("^INReqLine",this.Company,m$.prop(this.Requisition,"ReqNum").get(),this.LineNumber,1)));
      //<< set strStatus = $$$OK
      mVar strStatus = m$.var("strStatus");
      strStatus.set(include.COMSYS.$$$OK(m$));
      //<< set strStatus = $$TempReqLineValidation^WWW0121(ANMKey,ANMData,%this.Company,%this.FromStockLocn.Location)
      strStatus.set(m$.fnc$("WWW0121.TempReqLineValidation",ANMKey.get(),ANMData.get(),this.Company,m$.prop(this.FromStockLocn,"Location").get()));
      //<< if $$$ISERR(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        //<< set sc = $$$ERROR($$$GeneralError,$$DecodeError^COMUtilError(strStatus))
        sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),m$.fnc$("COMUtilError.DecodeError",strStatus.get())));
      }
    }
    //<< }
    //<< }
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< Method IsClosed() As %Boolean
  public Object IsClosed() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks if this line is already closed.
    //<< ;
    //<< ; History
    //<< ; 22-Sep-2010   shobby      SR17485: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set blnResult = $$$NO
    mVar blnResult = m$.var("blnResult");
    blnResult.set(include.COMSYS.$$$NO(m$));
    //<< //Firmed, ManualClosed, AutoClosed  //SR16586 (Added 2) //SR16838 (Removed 2)
    //<< //7 - Active/Pending
    //<< if (%this.Status.StatusCode = 8) || (%this.Status.StatusCode = 9) {  ;SR17485
    if ((mOp.Equal(m$.prop(this.Status,"StatusCode").get(),8)) || (mOp.Equal(m$.prop(this.Status,"StatusCode").get(),9))) {
      //<< set blnResult = $$$YES
      blnResult.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< quit blnResult
    return blnResult.get();
  //<< }
  }

  //<< 
  //<< /// Checks the validity of a REQLine to be closed.
  //<< Method IsClosable() As %Boolean
  public Object IsClosable() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History
    //<< ; 20-Sep-2010   shobby  SR17485: Don't allow closing of Active/Pending.
    //<< ; 13-Aug-2009   PPP     SR16838: The Status = 2, Firmed, does not need to be checked.
    //<< ; 29-May-2009   PPP     SR16586: Simplify Process (remove unnecessary calls to Script Engine/State Engine)
    //<< ; 19-Dec-2007   HQN     SR15598: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set blnResult = $$$YES
    mVar blnResult = m$.var("blnResult");
    blnResult.set(include.COMSYS.$$$YES(m$));
    //<< //Firmed, ManualClosed, AutoClosed
    //<< //7 - Active/Pending
    //<< if (%this.Status.StatusCode = 8) || (%this.Status.StatusCode = 9)|| (%this.Status.StatusCode = 7) {  ;SR17485
    if ((mOp.Equal(m$.prop(this.Status,"StatusCode").get(),8)) || (mOp.Equal(m$.prop(this.Status,"StatusCode").get(),9)) || (mOp.Equal(m$.prop(this.Status,"StatusCode").get(),7))) {
      //<< set blnResult = $$$NO
      blnResult.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< 
    //<< quit blnResult
    return blnResult.get();
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
  //<< Method %OnBeforeSave(insert As %Boolean) As %Status [ Private ]
  public Object $OnBeforeSave(Object ... _p) {
    mVar insert = m$.newVarRef("insert",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(insert);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 17-Sep-2010   SCR     SR17471: Call to super
    //<< ; 16-Dec-2007   HQN     Check for NULLOREFs
    //<< ;-------------------------------------------------------------------------------
    //<< if (i%objStatus '= $$$NULLOREF) && (i%objStatus.%IsModified()) {
    if ((mOp.NotEqual(m$.var("i%objStatus").get(),include.$occConstant.$$$NULLOREF(m$))) && mOp.Logical((m$.fnc$(this.objStatus,"$IsModified")))) {
      //<< set i%Status = i%objStatus.StatusCode
      m$.prop(this,"Status").set(m$.prop(m$.var("i%objStatus").get(),"StatusCode").get());
    }
    //<< }
    //<< set sc = ##Super(insert) ; SR17471
    mVar sc = m$.var("sc");
    sc.set(super.$OnBeforeSave(insert.get()));
    //<< 
    //<< quit sc
    return sc.get();
  //<< }
  }

//<< 
//<< //++++++++++++++++++++++++++++++++++++++++++
//<< 
//<< }
}
