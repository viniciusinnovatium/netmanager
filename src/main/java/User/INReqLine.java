//*****************************************************************************
//** TASC - ALPHALINC - CLASS User.INReqLine
//** Innovatium Systems - Code Converter - v1.31
//** 2014-07-07 17:54:42
//*****************************************************************************

package User;

import mLibrary.*;

//<< /// Requisition Line:
//<< Class User.INReqLine Extends (%Library.Persistent, %XML.Adaptor) [ ClassType = persistent, Not ProcedureBlock, StorageStrategy = StorageAtNet ]
public class INReqLine extends mPersistent {
  //<< {
  //<< 
  //<< /// Cancelled
  //<< Property Cancelled As %Boolean(CAPTION = "Cancelled");
  public Boolean Cancelled;
  //<< 
  //<< Property Company As %String(MAXLEN = 30, XMLPROJECTION = "attribute") [ Required ];
  public String Company;
  //<< 
  //<< /// DateCancellation
  //<< Property DateCancellation As WWW.DiscDate(CAPTION = "DateCancellation");
  public mDiscDate DateCancellation;
  //<< 
  //<< /// DateRejection
  //<< Property DateRejection As WWW.DiscDate(CAPTION = "DateRejection");
  public mDiscDate DateRejection;
  //<< 
  //<< /// DemandLoaded
  //<< Property DemandLoaded As %String(CAPTION = "DemandLoaded", MAXLEN = 30);
  public String DemandLoaded;
  //<< 
  //<< /// DueDate
  //<< Property DueDate As WWW.DiscDate(CAPTION = "DueDate");
  public mDiscDate DueDate;
  //<< 
  //<< /// _FREE
  //<< Property FREE1 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE1;
  //<< 
  //<< /// _FREE
  //<< Property FREE10 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE10;
  //<< 
  //<< /// _FREE
  //<< Property FREE2 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE2;
  //<< 
  //<< /// _FREE
  //<< Property FREE3 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE3;
  //<< 
  //<< /// _FREE
  //<< Property FREE4 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE4;
  //<< 
  //<< /// _FREE
  //<< Property FREE5 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE5;
  //<< 
  //<< /// _FREE
  //<< Property FREE6 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE6;
  //<< 
  //<< /// _FREE
  //<< Property FREE7 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE7;
  //<< 
  //<< /// _FREE
  //<< Property FREE8 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE8;
  //<< 
  //<< /// _FREE
  //<< Property FREE9 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE9;
  //<< 
  //<< /// From Location
  //<< Property FromStockLocn As %String(CAPTION = "From Location", MAXLEN = 30);
  public String FromStockLocn;
  //<< 
  //<< /// Imported Demand
  //<< Property ImportedDemand As %Boolean(CAPTION = "Imported Demand");
  public Boolean ImportedDemand;
  //<< 
  //<< /// Item
  //<< Property Item As %String(CAPTION = "Item", MAXLEN = 30);
  public String Item;
  //<< 
  //<< /// LineNumber
  //<< Property LineNumber As %String(CAPTION = "LineNumber", COLLATION = "EXACT", MAXLEN = 30, XMLPROJECTION = "attribute") [ Required ];
  public String LineNumber;
  //<< 
  //<< /// ProductionOrder
  //<< Property ProductionOrder As %String(CAPTION = "ProductionOrder", MAXLEN = 30);
  public String ProductionOrder;
  //<< 
  //<< /// Purchase Order
  //<< Property PurchaseOrder As %String(CAPTION = "Purchase Order", MAXLEN = 30);
  public String PurchaseOrder;
  //<< 
  //<< /// QtyCancelled
  //<< Property QtyCancelled As %Float(CAPTION = "QtyCancelled");
  public Double QtyCancelled;
  //<< 
  //<< /// Issued Quantity
  //<< Property QtyIssued As %Float(CAPTION = "Issued Quantity");
  public Double QtyIssued;
  //<< 
  //<< /// QtyOrdered
  //<< Property QtyOrdered As %Float(CAPTION = "QtyOrdered");
  public Double QtyOrdered;
  //<< 
  //<< /// Received Quantity
  //<< Property QtyReceived As %Float(CAPTION = "Received Quantity");
  public Double QtyReceived;
  //<< 
  //<< /// QtyRejected
  //<< Property QtyRejected As %Float(CAPTION = "QtyRejected");
  public Double QtyRejected;
  //<< 
  //<< /// Required Quantity
  //<< Property QtyRequired As %Float(CAPTION = "Required Quantity");
  public Double QtyRequired;
  //<< 
  //<< /// Returned Quantity
  //<< Property QtyReversed As %Float(CAPTION = "Returned Quantity");
  public Double QtyReversed;
  //<< 
  //<< /// QtyToIssue
  //<< Property QtyToIssue As %Float(CAPTION = "QtyToIssue");
  public Double QtyToIssue;
  //<< 
  //<< /// QtyToReceive
  //<< Property QtyToReceive As %Float(CAPTION = "QtyToReceive");
  public Double QtyToReceive;
  //<< 
  //<< /// ReasonCancellation
  //<< Property ReasonCancellation As %String(CAPTION = "ReasonCancellation", MAXLEN = 32000);
  public String ReasonCancellation;
  //<< 
  //<< /// ReasonRejection
  //<< Property ReasonRejection As %String(CAPTION = "ReasonRejection", MAXLEN = 32000);
  public String ReasonRejection;
  //<< 
  //<< /// Rejected
  //<< Property Rejected As %Boolean(CAPTION = "Rejected");
  public Boolean Rejected;
  //<< 
  //<< /// ReqNumber
  //<< Property ReqNumber As %String(CAPTION = "ReqNumber", COLLATION = "EXACT", MAXLEN = 30, XMLPROJECTION = "attribute") [ Required ];
  public String ReqNumber;
  //<< 
  //<< /// Status
  //<< Property Status As %String(CAPTION = "Status", MAXLEN = 30) [ Required ];
  public String Status;
  //<< 
  //<< /// Unit
  //<< Property Unit As %String(CAPTION = "Unit", MAXLEN = 30) [ Required ];
  public String Unit;
  //<< 
  //<< /// Unit Price
  //<< Property UnitPrice As %Float(CAPTION = "Unit Price");
  public Double UnitPrice;

  //<< 
  //<< Index IDKEY On (Company, ReqNumber, LineNumber) [ IdKey, PrimaryKey, Unique ];
  //<< 
  //<< Method %OnBeforeSave(insert As %Boolean) As %Status [ Private, ServerOnly = 1 ]
  public Object $OnBeforeSave(Object ... _p) {
    mVar insert = m$.newVarRef("insert",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< {
    //<< set strClass="INReqLine"
    mVar strClass = m$.var("strClass");
    strClass.set("INReqLine");
    //<< set $piece(idKey,",",1)=i%ReqNumber
    m$.pieceVar(m$.var("idKey"),",",1).set(m$.var("i%ReqNumber").get());
    //<< set $piece(idKey,",",2)=i%LineNumber
    m$.pieceVar(m$.var("idKey"),",",2).set(m$.var("i%LineNumber").get());
    //<< set $piece(objRec,"~",1)=i%Item
    m$.pieceVar(m$.var("objRec"),"~",1).set(m$.var("i%Item").get());
    //<< set $piece(objRec,"~",2)=i%Unit
    m$.pieceVar(m$.var("objRec"),"~",2).set(m$.var("i%Unit").get());
    //<< set $piece(objRec,"~",3)=i%QtyOrdered
    m$.pieceVar(m$.var("objRec"),"~",3).set(m$.var("i%QtyOrdered").get());
    //<< set $piece(objRec,"~",4)=i%QtyRequired
    m$.pieceVar(m$.var("objRec"),"~",4).set(m$.var("i%QtyRequired").get());
    //<< set $piece(objRec,"~",5)=i%QtyToReceive
    m$.pieceVar(m$.var("objRec"),"~",5).set(m$.var("i%QtyToReceive").get());
    //<< set $piece(objRec,"~",6)=i%QtyReceived
    m$.pieceVar(m$.var("objRec"),"~",6).set(m$.var("i%QtyReceived").get());
    //<< set $piece(objRec,"~",7)=i%QtyToIssue
    m$.pieceVar(m$.var("objRec"),"~",7).set(m$.var("i%QtyToIssue").get());
    //<< set $piece(objRec,"~",8)=i%QtyIssued
    m$.pieceVar(m$.var("objRec"),"~",8).set(m$.var("i%QtyIssued").get());
    //<< set $piece(objRec,"~",9)=i%FromStockLocn
    m$.pieceVar(m$.var("objRec"),"~",9).set(m$.var("i%FromStockLocn").get());
    //<< set $piece(objRec,"~",10)=i%Status
    m$.pieceVar(m$.var("objRec"),"~",10).set(m$.var("i%Status").get());
    //<< set $piece(objRec,"~",11)=i%DueDate
    m$.pieceVar(m$.var("objRec"),"~",11).set(m$.var("i%DueDate").get());
    //<< set $piece(objRec,"~",12)=i%FREE1
    m$.pieceVar(m$.var("objRec"),"~",12).set(m$.var("i%FREE1").get());
    //<< set $piece(objRec,"~",13)=i%FREE2
    m$.pieceVar(m$.var("objRec"),"~",13).set(m$.var("i%FREE2").get());
    //<< set $piece(objRec,"~",14)=i%FREE3
    m$.pieceVar(m$.var("objRec"),"~",14).set(m$.var("i%FREE3").get());
    //<< set $piece(objRec,"~",15)=i%FREE4
    m$.pieceVar(m$.var("objRec"),"~",15).set(m$.var("i%FREE4").get());
    //<< set $piece(objRec,"~",16)=i%FREE5
    m$.pieceVar(m$.var("objRec"),"~",16).set(m$.var("i%FREE5").get());
    //<< set $piece(objRec,"~",17)=i%FREE6
    m$.pieceVar(m$.var("objRec"),"~",17).set(m$.var("i%FREE6").get());
    //<< set $piece(objRec,"~",18)=i%FREE7
    m$.pieceVar(m$.var("objRec"),"~",18).set(m$.var("i%FREE7").get());
    //<< set $piece(objRec,"~",19)=i%FREE8
    m$.pieceVar(m$.var("objRec"),"~",19).set(m$.var("i%FREE8").get());
    //<< set $piece(objRec,"~",20)=i%FREE9
    m$.pieceVar(m$.var("objRec"),"~",20).set(m$.var("i%FREE9").get());
    //<< set $piece(objRec,"~",21)=i%FREE10
    m$.pieceVar(m$.var("objRec"),"~",21).set(m$.var("i%FREE10").get());
    //<< set $piece(objRec,"~",22)=i%Cancelled
    m$.pieceVar(m$.var("objRec"),"~",22).set(m$.var("i%Cancelled").get());
    //<< set $piece(objRec,"~",23)=i%Rejected
    m$.pieceVar(m$.var("objRec"),"~",23).set(m$.var("i%Rejected").get());
    //<< set $piece(objRec,"~",24)=i%ReasonCancellation
    m$.pieceVar(m$.var("objRec"),"~",24).set(m$.var("i%ReasonCancellation").get());
    //<< set $piece(objRec,"~",25)=i%ReasonRejection
    m$.pieceVar(m$.var("objRec"),"~",25).set(m$.var("i%ReasonRejection").get());
    //<< set $piece(objRec,"~",26)=i%QtyCancelled
    m$.pieceVar(m$.var("objRec"),"~",26).set(m$.var("i%QtyCancelled").get());
    //<< set $piece(objRec,"~",27)=i%QtyRejected
    m$.pieceVar(m$.var("objRec"),"~",27).set(m$.var("i%QtyRejected").get());
    //<< set $piece(objRec,"~",28)=i%QtyReversed
    m$.pieceVar(m$.var("objRec"),"~",28).set(m$.var("i%QtyReversed").get());
    //<< set $piece(objRec,"~",29)=i%DateCancellation
    m$.pieceVar(m$.var("objRec"),"~",29).set(m$.var("i%DateCancellation").get());
    //<< set $piece(objRec,"~",30)=i%DateRejection
    m$.pieceVar(m$.var("objRec"),"~",30).set(m$.var("i%DateRejection").get());
    //<< set $piece(objRec,"~",31)=i%UnitPrice
    m$.pieceVar(m$.var("objRec"),"~",31).set(m$.var("i%UnitPrice").get());
    //<< set $piece(objRec,"~",32)=i%PurchaseOrder
    m$.pieceVar(m$.var("objRec"),"~",32).set(m$.var("i%PurchaseOrder").get());
    //<< set $piece(objRec,"~",33)=i%ProductionOrder
    m$.pieceVar(m$.var("objRec"),"~",33).set(m$.var("i%ProductionOrder").get());
    //<< set $piece(objRec,"~",34)=i%ImportedDemand
    m$.pieceVar(m$.var("objRec"),"~",34).set(m$.var("i%ImportedDemand").get());
    //<< set $piece(objRec,"~",35)=i%DemandLoaded
    m$.pieceVar(m$.var("objRec"),"~",35).set(m$.var("i%DemandLoaded").get());
    //<< set sc=$$OnBeforeSave^COMObject(insert,strClass,idKey,.objRec)
    mVar sc = m$.var("sc");
    sc.set(m$.fnc$("COMObject.OnBeforeSave",insert.get(),strClass.get(),m$.var("idKey").get(),m$.var("objRec")));
    //<< set i%Item=$piece(objRec,"~",1)
    m$.prop(this,"Item").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",1));
    //<< set i%Unit=$piece(objRec,"~",2)
    m$.prop(this,"Unit").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",2));
    //<< set i%QtyOrdered=$piece(objRec,"~",3)
    m$.prop(this,"QtyOrdered").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",3));
    //<< set i%QtyRequired=$piece(objRec,"~",4)
    m$.prop(this,"QtyRequired").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",4));
    //<< set i%QtyToReceive=$piece(objRec,"~",5)
    m$.prop(this,"QtyToReceive").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",5));
    //<< set i%QtyReceived=$piece(objRec,"~",6)
    m$.prop(this,"QtyReceived").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",6));
    //<< set i%QtyToIssue=$piece(objRec,"~",7)
    m$.prop(this,"QtyToIssue").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",7));
    //<< set i%QtyIssued=$piece(objRec,"~",8)
    m$.prop(this,"QtyIssued").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",8));
    //<< set i%FromStockLocn=$piece(objRec,"~",9)
    m$.prop(this,"FromStockLocn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",9));
    //<< set i%Status=$piece(objRec,"~",10)
    m$.prop(this,"Status").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",10));
    //<< set i%DueDate=$piece(objRec,"~",11)
    m$.prop(this,"DueDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",11));
    //<< set i%FREE1=$piece(objRec,"~",12)
    m$.prop(this,"FREE1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",12));
    //<< set i%FREE2=$piece(objRec,"~",13)
    m$.prop(this,"FREE2").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",13));
    //<< set i%FREE3=$piece(objRec,"~",14)
    m$.prop(this,"FREE3").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",14));
    //<< set i%FREE4=$piece(objRec,"~",15)
    m$.prop(this,"FREE4").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",15));
    //<< set i%FREE5=$piece(objRec,"~",16)
    m$.prop(this,"FREE5").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",16));
    //<< set i%FREE6=$piece(objRec,"~",17)
    m$.prop(this,"FREE6").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",17));
    //<< set i%FREE7=$piece(objRec,"~",18)
    m$.prop(this,"FREE7").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",18));
    //<< set i%FREE8=$piece(objRec,"~",19)
    m$.prop(this,"FREE8").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",19));
    //<< set i%FREE9=$piece(objRec,"~",20)
    m$.prop(this,"FREE9").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",20));
    //<< set i%FREE10=$piece(objRec,"~",21)
    m$.prop(this,"FREE10").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",21));
    //<< set i%Cancelled=$piece(objRec,"~",22)
    m$.prop(this,"Cancelled").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",22));
    //<< set i%Rejected=$piece(objRec,"~",23)
    m$.prop(this,"Rejected").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",23));
    //<< set i%ReasonCancellation=$piece(objRec,"~",24)
    m$.prop(this,"ReasonCancellation").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",24));
    //<< set i%ReasonRejection=$piece(objRec,"~",25)
    m$.prop(this,"ReasonRejection").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",25));
    //<< set i%QtyCancelled=$piece(objRec,"~",26)
    m$.prop(this,"QtyCancelled").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",26));
    //<< set i%QtyRejected=$piece(objRec,"~",27)
    m$.prop(this,"QtyRejected").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",27));
    //<< set i%QtyReversed=$piece(objRec,"~",28)
    m$.prop(this,"QtyReversed").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",28));
    //<< set i%DateCancellation=$piece(objRec,"~",29)
    m$.prop(this,"DateCancellation").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",29));
    //<< set i%DateRejection=$piece(objRec,"~",30)
    m$.prop(this,"DateRejection").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",30));
    //<< set i%UnitPrice=$piece(objRec,"~",31)
    m$.prop(this,"UnitPrice").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",31));
    //<< set i%PurchaseOrder=$piece(objRec,"~",32)
    m$.prop(this,"PurchaseOrder").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",32));
    //<< set i%ProductionOrder=$piece(objRec,"~",33)
    m$.prop(this,"ProductionOrder").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",33));
    //<< set i%ImportedDemand=$piece(objRec,"~",34)
    m$.prop(this,"ImportedDemand").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",34));
    //<< set i%DemandLoaded=$piece(objRec,"~",35)
    m$.prop(this,"DemandLoaded").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",35));
    //<< Quit sc
    return sc.get();
  //<< }
  }

//<< 
//<< }
}
