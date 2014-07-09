//*****************************************************************************
//** TASC - ALPHALINC - CLASS User.INDRPSUPPLY
//** Innovatium Systems - Code Converter - v1.32
//** 2014-07-07 19:00:40
//*****************************************************************************

package User;

import mLibrary.*;

//<< /// Supply:
//<< Class User.INDRPSUPPLY Extends (%Library.Persistent, %XML.Adaptor, %Library.Populate) [ ClassType = persistent, Not ProcedureBlock, StorageStrategy = StorageAtNet ]
public class INDRPSUPPLY extends mPersistent {
  //<< {
  //<< 
  //<< /// Closed
  //<< Property Closed As %Boolean(CAPTION = "Closed  ");
  public Boolean Closed;
  //<< 
  //<< Property Company As %String(MAXLEN = 30, XMLPROJECTION = "attribute") [ Required ];
  public String Company;
  //<< 
  //<< /// Confirmed Due Date
  //<< Property ConfirmedDueDate As WWW.DiscDate(CAPTION = "Confirmed Due Date");
  public mDiscDate ConfirmedDueDate;
  //<< 
  //<< /// Confirmed In-Date
  //<< Property ConfirmedInDate As WWW.DiscDate(CAPTION = "Confirmed In-Date");
  public mDiscDate ConfirmedInDate;
  //<< 
  //<< /// Created Through
  //<< Property CreatedThrough As %String(CAPTION = "Created Through", MAXLEN = 10);
  public String CreatedThrough;
  //<< 
  //<< /// Created Thru Demand
  //<< Property CreatedThruDemand As WWW.DiscTimestamp(CAPTION = "Created Thru Demand ");
  public String CreatedThruDemand;
  //<< 
  //<< /// Date
  //<< Property Date1 As WWW.DiscDate(CAPTION = "Date");
  public mDiscDate Date1;
  //<< 
  //<< /// Date Received
  //<< Property DateReceived As WWW.DiscDate(CAPTION = "Date Received");
  public mDiscDate DateReceived;
  //<< 
  //<< /// Date Shipped
  //<< Property DateShipped As WWW.DiscDate(CAPTION = "Date Shipped");
  public mDiscDate DateShipped;
  //<< 
  //<< /// Deleted Order
  //<< Property DeletedOrder As %Boolean(CAPTION = "Deleted Order");
  public Boolean DeletedOrder;
  //<< 
  //<< /// Blocked
  //<< Property Disabled As %Boolean(CAPTION = "Blocked");
  public Boolean Disabled;
  //<< 
  //<< /// Dispatch Number
  //<< Property DispatchNumber As %String(CAPTION = "Dispatch Number", MAXLEN = 30);
  public String DispatchNumber;
  //<< 
  //<< /// Due On/Before
  //<< Property DueOnBefore As WWW.DiscDate(CAPTION = "Due On/Before");
  public mDiscDate DueOnBefore;
  //<< 
  //<< /// Firmed
  //<< Property Firmed As WWW.DiscDate(CAPTION = "Firmed");
  public mDiscDate Firmed;
  //<< 
  //<< /// Firmed   by
  //<< Property Firmedby As %String(CAPTION = "Firmed   by", MAXLEN = 10);
  public String Firmedby;
  //<< 
  //<< /// Group Number
  //<< Property GroupNumber As %String(CAPTION = "Group Number", MAXLEN = 30);
  public String GroupNumber;
  //<< 
  //<< /// Is New
  //<< Property IsNew As %Boolean(CAPTION = "Is New");
  public Boolean IsNew;
  //<< 
  //<< Property ItemDescription As %String(CAPTION = "Item Description") [ Calculated, SqlComputeCode = { set {ItemDescription}=$$ItemDetail^INRPItem({Company},{ItemNo},10)}, SqlComputed ];
  public String ItemDescription;
  //<< 
  //<< /// Item No.
  //<< Property ItemNo As %String(CAPTION = "Item No.", MAXLEN = 15);
  public String ItemNo;
  //<< 
  //<< Property ItemUOM As %String(CAPTION = "Item UOM") [ Calculated, SqlComputeCode = { set {ItemUOM}=$$ItemDetail^INRPItem({Company},{ItemNo},40)}, SqlComputed ];
  public String ItemUOM;
  //<< 
  //<< /// Location
  //<< Property Location As %String(CAPTION = "Location", COLLATION = "EXACT", MAXLEN = 10, XMLPROJECTION = "attribute") [ Required ];
  public String Location;
  //<< 
  //<< /// Location
  //<< Property Location1 As %String(CAPTION = "Location", MAXLEN = 30);
  public String Location1;
  //<< 
  //<< /// Order No.
  //<< Property OrderNo As %String(CAPTION = "Order No.", MAXLEN = 10);
  public String OrderNo;
  //<< 
  //<< /// Pick List Print Date
  //<< Property PickListPrintDate As WWW.DiscDate(CAPTION = "Pick List Print Date");
  public mDiscDate PickListPrintDate;
  //<< 
  //<< /// Picked By
  //<< Property PickedBy As %String(CAPTION = "Picked By", MAXLEN = 10);
  public String PickedBy;
  //<< 
  //<< /// Picked Quantity
  //<< Property PickedQuantity As %Float(CAPTION = "Picked Quantity");
  public Double PickedQuantity;
  //<< 
  //<< /// Planned By
  //<< Property PlannedBy As %String(CAPTION = "Planned By", MAXLEN = 10);
  public String PlannedBy;
  //<< 
  //<< /// Planned Date
  //<< Property PlannedDate As WWW.DiscDate(CAPTION = "Planned Date");
  public mDiscDate PlannedDate;
  //<< 
  //<< /// Planned Due Date
  //<< Property PlannedDueDate As WWW.DiscDate(CAPTION = "Planned Due Date");
  public mDiscDate PlannedDueDate;
  //<< 
  //<< /// Planned Ship Date
  //<< Property PlannedShipDate As WWW.DiscDate(CAPTION = "Planned Ship Date");
  public mDiscDate PlannedShipDate;
  //<< 
  //<< /// Planner
  //<< Property Planner As %String(CAPTION = "Planner", MAXLEN = 10);
  public String Planner;
  //<< 
  //<< /// Priority
  //<< Property Priority As %String(CAPTION = "Priority", MAXLEN = 15);
  public String Priority;
  //<< 
  //<< Property QtyFromLocation As %Float(CAPTION = "Qty From Location") [ Calculated, SqlComputeCode = { set {QtyFromLocation}=$$GetQOHFromLocation^INRPItem({Company},{Location},{ItemNo})}, SqlComputed ];
  public Double QtyFromLocation;
  //<< 
  //<< /// Quantity
  //<< Property Quantity As %Float(CAPTION = "Quantity");
  public Double Quantity;
  //<< 
  //<< /// Ready For Delivery
  //<< Property ReadyForDelivery As %Boolean(CAPTION = "Ready For Delivery");
  public Boolean ReadyForDelivery;
  //<< 
  //<< /// Received By
  //<< Property ReceivedBy As %String(CAPTION = "Received By", MAXLEN = 10);
  public String ReceivedBy;
  //<< 
  //<< /// Received Confirmation
  //<< Property ReceivedConfirmation As WWW.DiscDate(CAPTION = "Received Confirmation");
  public mDiscDate ReceivedConfirmation;
  //<< 
  //<< /// Received Quantity
  //<< Property ReceivedQuantity As %Float(CAPTION = "Received Quantity");
  public Double ReceivedQuantity;
  //<< 
  //<< /// Received Quantity
  //<< Property ReceivedQuantity1 As %Float(CAPTION = "Received Quantity");
  public Double ReceivedQuantity1;
  //<< 
  //<< /// Reference
  //<< Property Reference As %String(CAPTION = "Reference", MAXLEN = 30);
  public String Reference;
  //<< 
  //<< /// Requisition Number
  //<< Property RequisitionNumber As %String(CAPTION = "Requisition Number", MAXLEN = 30);
  public String RequisitionNumber;
  //<< 
  //<< /// Status
  //<< Property Status As %String(CAPTION = "Status  ", MAXLEN = 30);
  public String Status;
  //<< 
  //<< /// Structure Of Level
  //<< Property StructureOfLevel As %String(CAPTION = "Structure Of Level", MAXLEN = 20);
  public String StructureOfLevel;
  //<< 
  //<< /// Supply
  //<< Property Supply As %String(CAPTION = "Supply", MAXLEN = 30);
  public String Supply;
  //<< 
  //<< /// Supply-No.
  //<< Property SupplyNo As %String(CAPTION = "Supply-No.", COLLATION = "EXACT", XMLPROJECTION = "attribute") [ Required ];
  public String SupplyNo;
  //<< 
  //<< /// Supply Time
  //<< Property SupplyTime As %Time(CAPTION = "Supply Time");
  public Double SupplyTime;
  //<< 
  //<< /// Supply Type
  //<< Property SupplyType As %String(CAPTION = "Supply Type", MAXLEN = 15);
  public String SupplyType;
  //<< 
  //<< /// Text
  //<< Property Text As %String(CAPTION = "Text", MAXLEN = 32000);
  public String Text;
  //<< 
  //<< /// Transfer
  //<< Property Transfer As %String(CAPTION = "Transfer", MAXLEN = 30);
  public String Transfer;
  //<< 
  //<< /// Transfer Item Structure
  //<< Property TransferItemStructure As WWW.DiscTimestamp(CAPTION = "Transfer Item Structure  ");
  public String TransferItemStructure;

  //<< 
  //<< Index IDKEY On (Company, Location, SupplyNo) [ IdKey, PrimaryKey, Unique ];
  //<< 
  //<< Method %OnBeforeSave(insert As %Boolean) As %Status [ Private, ServerOnly = 1 ]
  public Object $OnBeforeSave(Object ... _p) {
    mVar insert = m$.newVarRef("insert",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< {
    //<< set strClass="INDRPSUPPLY"
    mVar strClass = m$.var("strClass");
    strClass.set("INDRPSUPPLY");
    //<< set $piece(idKey,",",1)=i%Location
    m$.pieceVar(m$.var("idKey"),",",1).set(m$.var("i%Location").get());
    //<< set $piece(idKey,",",2)=i%SupplyNo
    m$.pieceVar(m$.var("idKey"),",",2).set(m$.var("i%SupplyNo").get());
    //<< set $piece(objRec,"~",1)=i%Location1
    m$.pieceVar(m$.var("objRec"),"~",1).set(m$.var("i%Location1").get());
    //<< set $piece(objRec,"~",2)=i%OrderNo
    m$.pieceVar(m$.var("objRec"),"~",2).set(m$.var("i%OrderNo").get());
    //<< set $piece(objRec,"~",3)=i%Date1
    m$.pieceVar(m$.var("objRec"),"~",3).set(m$.var("i%Date1").get());
    //<< set $piece(objRec,"~",4)=i%ItemNo
    m$.pieceVar(m$.var("objRec"),"~",4).set(m$.var("i%ItemNo").get());
    //<< set $piece(objRec,"~",5)=i%Quantity
    m$.pieceVar(m$.var("objRec"),"~",5).set(m$.var("i%Quantity").get());
    //<< set $piece(objRec,"~",6)=i%DueOnBefore
    m$.pieceVar(m$.var("objRec"),"~",6).set(m$.var("i%DueOnBefore").get());
    //<< set $piece(objRec,"~",7)=i%ConfirmedInDate
    m$.pieceVar(m$.var("objRec"),"~",7).set(m$.var("i%ConfirmedInDate").get());
    //<< set $piece(objRec,"~",8)=i%Planner
    m$.pieceVar(m$.var("objRec"),"~",8).set(m$.var("i%Planner").get());
    //<< set $piece(objRec,"~",9)=i%Supply
    m$.pieceVar(m$.var("objRec"),"~",9).set(m$.var("i%Supply").get());
    //<< set $piece(objRec,"~",10)=i%CreatedThrough
    m$.pieceVar(m$.var("objRec"),"~",10).set(m$.var("i%CreatedThrough").get());
    //<< set $piece(objRec,"~",12)=i%PlannedDueDate
    m$.pieceVar(m$.var("objRec"),"~",12).set(m$.var("i%PlannedDueDate").get());
    //<< set $piece(objRec,"~",13)=i%ConfirmedDueDate
    m$.pieceVar(m$.var("objRec"),"~",13).set(m$.var("i%ConfirmedDueDate").get());
    //<< set $piece(objRec,"~",15)=i%PlannedDate
    m$.pieceVar(m$.var("objRec"),"~",15).set(m$.var("i%PlannedDate").get());
    //<< set $piece(objRec,"~",16)=i%PlannedBy
    m$.pieceVar(m$.var("objRec"),"~",16).set(m$.var("i%PlannedBy").get());
    //<< set $piece(objRec,"~",17)=i%SupplyTime
    m$.pieceVar(m$.var("objRec"),"~",17).set(m$.var("i%SupplyTime").get());
    //<< set $piece(objRec,"~",19)=i%Disabled
    m$.pieceVar(m$.var("objRec"),"~",19).set(m$.var("i%Disabled").get());
    //<< set $piece(objRec,"~",20)=i%Firmed
    m$.pieceVar(m$.var("objRec"),"~",20).set(m$.var("i%Firmed").get());
    //<< set $piece(objRec,"~",21)=i%Firmedby
    m$.pieceVar(m$.var("objRec"),"~",21).set(m$.var("i%Firmedby").get());
    //<< set $piece(objRec,"~",22)=i%ReceivedConfirmation
    m$.pieceVar(m$.var("objRec"),"~",22).set(m$.var("i%ReceivedConfirmation").get());
    //<< set $piece(objRec,"~",26)=i%ReceivedQuantity
    m$.pieceVar(m$.var("objRec"),"~",26).set(m$.var("i%ReceivedQuantity").get());
    //<< set $piece(objRec,"~",39)=i%ReadyForDelivery
    m$.pieceVar(m$.var("objRec"),"~",39).set(m$.var("i%ReadyForDelivery").get());
    //<< set $piece(objRec,"~",40)=i%PlannedShipDate
    m$.pieceVar(m$.var("objRec"),"~",40).set(m$.var("i%PlannedShipDate").get());
    //<< set $piece(objRec,"~",41)=i%DispatchNumber
    m$.pieceVar(m$.var("objRec"),"~",41).set(m$.var("i%DispatchNumber").get());
    //<< set $piece(objRec,"~",42)=i%PickListPrintDate
    m$.pieceVar(m$.var("objRec"),"~",42).set(m$.var("i%PickListPrintDate").get());
    //<< set $piece(objRec,"~",46)=i%PickedBy
    m$.pieceVar(m$.var("objRec"),"~",46).set(m$.var("i%PickedBy").get());
    //<< set $piece(objRec,"~",50)=i%PickedQuantity
    m$.pieceVar(m$.var("objRec"),"~",50).set(m$.var("i%PickedQuantity").get());
    //<< set $piece(objRec,"~",61)=i%DateShipped
    m$.pieceVar(m$.var("objRec"),"~",61).set(m$.var("i%DateShipped").get());
    //<< set $piece(objRec,"~",64)=i%DateReceived
    m$.pieceVar(m$.var("objRec"),"~",64).set(m$.var("i%DateReceived").get());
    //<< set $piece(objRec,"~",66)=i%ReceivedBy
    m$.pieceVar(m$.var("objRec"),"~",66).set(m$.var("i%ReceivedBy").get());
    //<< set $piece(objRec,"~",67)=i%ReceivedQuantity1
    m$.pieceVar(m$.var("objRec"),"~",67).set(m$.var("i%ReceivedQuantity1").get());
    //<< set $piece(objRec,"~",70)=i%SupplyType
    m$.pieceVar(m$.var("objRec"),"~",70).set(m$.var("i%SupplyType").get());
    //<< set $piece(objRec,"~",71)=i%Priority
    m$.pieceVar(m$.var("objRec"),"~",71).set(m$.var("i%Priority").get());
    //<< set $piece(objRec,"~",72)=i%StructureOfLevel
    m$.pieceVar(m$.var("objRec"),"~",72).set(m$.var("i%StructureOfLevel").get());
    //<< set $piece(objRec,"~",73)=i%Status
    m$.pieceVar(m$.var("objRec"),"~",73).set(m$.var("i%Status").get());
    //<< set $piece(objRec,"~",98)=i%DeletedOrder
    m$.pieceVar(m$.var("objRec"),"~",98).set(m$.var("i%DeletedOrder").get());
    //<< set $piece(objRec,"~",99)=i%Closed
    m$.pieceVar(m$.var("objRec"),"~",99).set(m$.var("i%Closed").get());
    //<< set $piece(objRec,"~",100)=i%Text
    m$.pieceVar(m$.var("objRec"),"~",100).set(m$.var("i%Text").get());
    //<< set $piece(objRec,"~",101)=i%TransferItemStructure
    m$.pieceVar(m$.var("objRec"),"~",101).set(m$.var("i%TransferItemStructure").get());
    //<< set $piece(objRec,"~",111)=i%Reference
    m$.pieceVar(m$.var("objRec"),"~",111).set(m$.var("i%Reference").get());
    //<< set $piece(objRec,"~",120)=i%CreatedThruDemand
    m$.pieceVar(m$.var("objRec"),"~",120).set(m$.var("i%CreatedThruDemand").get());
    //<< set $piece(objRec,"~",121)=i%IsNew
    m$.pieceVar(m$.var("objRec"),"~",121).set(m$.var("i%IsNew").get());
    //<< set $piece(objRec,"~",122)=i%Transfer
    m$.pieceVar(m$.var("objRec"),"~",122).set(m$.var("i%Transfer").get());
    //<< set $piece(objRec,"~",124)=i%GroupNumber
    m$.pieceVar(m$.var("objRec"),"~",124).set(m$.var("i%GroupNumber").get());
    //<< set $piece(objRec,"~",125)=i%RequisitionNumber
    m$.pieceVar(m$.var("objRec"),"~",125).set(m$.var("i%RequisitionNumber").get());
    //<< set sc=$$OnBeforeSave^COMObject(insert,strClass,idKey,.objRec)
    mVar sc = m$.var("sc");
    sc.set(m$.fnc$("COMObject.OnBeforeSave",insert.get(),strClass.get(),m$.var("idKey").get(),m$.var("objRec")));
    //<< set i%Location1=$piece(objRec,"~",1)
    m$.prop(this,"Location1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",1));
    //<< set i%OrderNo=$piece(objRec,"~",2)
    m$.prop(this,"OrderNo").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",2));
    //<< set i%Date1=$piece(objRec,"~",3)
    m$.prop(this,"Date1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",3));
    //<< set i%ItemNo=$piece(objRec,"~",4)
    m$.prop(this,"ItemNo").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",4));
    //<< set i%Quantity=$piece(objRec,"~",5)
    m$.prop(this,"Quantity").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",5));
    //<< set i%DueOnBefore=$piece(objRec,"~",6)
    m$.prop(this,"DueOnBefore").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",6));
    //<< set i%ConfirmedInDate=$piece(objRec,"~",7)
    m$.prop(this,"ConfirmedInDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",7));
    //<< set i%Planner=$piece(objRec,"~",8)
    m$.prop(this,"Planner").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",8));
    //<< set i%Supply=$piece(objRec,"~",9)
    m$.prop(this,"Supply").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",9));
    //<< set i%CreatedThrough=$piece(objRec,"~",10)
    m$.prop(this,"CreatedThrough").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",10));
    //<< set i%PlannedDueDate=$piece(objRec,"~",12)
    m$.prop(this,"PlannedDueDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",12));
    //<< set i%ConfirmedDueDate=$piece(objRec,"~",13)
    m$.prop(this,"ConfirmedDueDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",13));
    //<< set i%PlannedDate=$piece(objRec,"~",15)
    m$.prop(this,"PlannedDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",15));
    //<< set i%PlannedBy=$piece(objRec,"~",16)
    m$.prop(this,"PlannedBy").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",16));
    //<< set i%SupplyTime=$piece(objRec,"~",17)
    m$.prop(this,"SupplyTime").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",17));
    //<< set i%Disabled=$piece(objRec,"~",19)
    m$.prop(this,"Disabled").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",19));
    //<< set i%Firmed=$piece(objRec,"~",20)
    m$.prop(this,"Firmed").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",20));
    //<< set i%Firmedby=$piece(objRec,"~",21)
    m$.prop(this,"Firmedby").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",21));
    //<< set i%ReceivedConfirmation=$piece(objRec,"~",22)
    m$.prop(this,"ReceivedConfirmation").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",22));
    //<< set i%ReceivedQuantity=$piece(objRec,"~",26)
    m$.prop(this,"ReceivedQuantity").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",26));
    //<< set i%ReadyForDelivery=$piece(objRec,"~",39)
    m$.prop(this,"ReadyForDelivery").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",39));
    //<< set i%PlannedShipDate=$piece(objRec,"~",40)
    m$.prop(this,"PlannedShipDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",40));
    //<< set i%DispatchNumber=$piece(objRec,"~",41)
    m$.prop(this,"DispatchNumber").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",41));
    //<< set i%PickListPrintDate=$piece(objRec,"~",42)
    m$.prop(this,"PickListPrintDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",42));
    //<< set i%PickedBy=$piece(objRec,"~",46)
    m$.prop(this,"PickedBy").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",46));
    //<< set i%PickedQuantity=$piece(objRec,"~",50)
    m$.prop(this,"PickedQuantity").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",50));
    //<< set i%DateShipped=$piece(objRec,"~",61)
    m$.prop(this,"DateShipped").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",61));
    //<< set i%DateReceived=$piece(objRec,"~",64)
    m$.prop(this,"DateReceived").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",64));
    //<< set i%ReceivedBy=$piece(objRec,"~",66)
    m$.prop(this,"ReceivedBy").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",66));
    //<< set i%ReceivedQuantity1=$piece(objRec,"~",67)
    m$.prop(this,"ReceivedQuantity1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",67));
    //<< set i%SupplyType=$piece(objRec,"~",70)
    m$.prop(this,"SupplyType").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",70));
    //<< set i%Priority=$piece(objRec,"~",71)
    m$.prop(this,"Priority").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",71));
    //<< set i%StructureOfLevel=$piece(objRec,"~",72)
    m$.prop(this,"StructureOfLevel").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",72));
    //<< set i%Status=$piece(objRec,"~",73)
    m$.prop(this,"Status").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",73));
    //<< set i%DeletedOrder=$piece(objRec,"~",98)
    m$.prop(this,"DeletedOrder").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",98));
    //<< set i%Closed=$piece(objRec,"~",99)
    m$.prop(this,"Closed").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",99));
    //<< set i%Text=$piece(objRec,"~",100)
    m$.prop(this,"Text").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",100));
    //<< set i%TransferItemStructure=$piece(objRec,"~",101)
    m$.prop(this,"TransferItemStructure").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",101));
    //<< set i%Reference=$piece(objRec,"~",111)
    m$.prop(this,"Reference").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",111));
    //<< set i%CreatedThruDemand=$piece(objRec,"~",120)
    m$.prop(this,"CreatedThruDemand").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",120));
    //<< set i%IsNew=$piece(objRec,"~",121)
    m$.prop(this,"IsNew").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",121));
    //<< set i%Transfer=$piece(objRec,"~",122)
    m$.prop(this,"Transfer").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",122));
    //<< set i%GroupNumber=$piece(objRec,"~",124)
    m$.prop(this,"GroupNumber").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",124));
    //<< set i%RequisitionNumber=$piece(objRec,"~",125)
    m$.prop(this,"RequisitionNumber").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",125));
    //<< Quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< Method ItemDescriptionGet() As %String [ CodeMode = expression ]
  public Object ItemDescriptionGet() {
    //<< {
    //<< $$ItemDetail^INRPItem(..Company,..ItemNo,10)
    return m$.fnc$("INRPItem.ItemDetail",this.Company,this.ItemNo,10);
  //<< }
  }

  //<< 
  //<< Method ItemUOMGet() As %String [ CodeMode = expression ]
  public Object ItemUOMGet() {
    //<< {
    //<< $$ItemDetail^INRPItem(..Company,..ItemNo,40)
    return m$.fnc$("INRPItem.ItemDetail",this.Company,this.ItemNo,40);
  //<< }
  }

  //<< 
  //<< Method QtyFromLocationGet() As %Float [ CodeMode = expression ]
  public Object QtyFromLocationGet() {
    //<< {
    //<< $$GetQOHFromLocation^INRPItem(..Company,..Location,..ItemNo)
    return m$.fnc$("INRPItem.GetQOHFromLocation",this.Company,this.Location,this.ItemNo);
  //<< }
  }

//<< 
//<< }
}
