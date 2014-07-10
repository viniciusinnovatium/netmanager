//*****************************************************************************
//** TASC - ALPHALINC - CLASS User.INDRPDEMAND
//** Innovatium Systems - Code Converter - v1.32
//** 2014-07-07 19:00:41
//*****************************************************************************

package User;

import mLibrary.*;

//<< /// Demand    :
//<< Class User.INDRPDEMAND Extends (%Library.Persistent, %XML.Adaptor, %Library.Populate) [ ClassType = persistent, Not ProcedureBlock, StorageStrategy = StorageAtNet ]
public class INDRPDEMAND extends mPersistent {
  //<< {
  //<< 
  //<< /// Blocked
  //<< Property Blocked As %Boolean(CAPTION = "Blocked");
  public Boolean Blocked;
  //<< 
  //<< Property Company As %String(MAXLEN = 30, XMLPROJECTION = "attribute") [ Required ];
  public String Company;
  //<< 
  //<< /// Completion Confirmed
  //<< Property CompletionConfirmed As WWW.DiscDate(CAPTION = "Completion Confirmed  ");
  public mDiscDate CompletionConfirmed;
  //<< 
  //<< /// Completion Planned
  //<< Property CompletionPlanned As WWW.DiscDate(CAPTION = "Completion Planned  ");
  public mDiscDate CompletionPlanned;
  //<< 
  //<< /// Confirmation Received
  //<< Property ConfirmationReceived As WWW.DiscDate(CAPTION = "Confirmation Received   ");
  public mDiscDate ConfirmationReceived;
  //<< 
  //<< /// Confirmed Receipt Date
  //<< Property ConfirmedReceiptDate As WWW.DiscDate(CAPTION = "Confirmed Receipt Date  ");
  public mDiscDate ConfirmedReceiptDate;
  //<< 
  //<< /// Created By
  //<< Property CreatedBy As %String(CAPTION = "Created By ", MAXLEN = 30);
  public String CreatedBy;
  //<< 
  //<< /// Created on
  //<< Property Createdon As WWW.DiscDate(CAPTION = "Created on  ");
  public mDiscDate Createdon;
  //<< 
  //<< /// Customer = Delivery Address
  //<< Property CustomerDeliveryAddress As %String(CAPTION = "Customer = Delivery Address", MAXLEN = 30);
  public String CustomerDeliveryAddress;
  //<< 
  //<< /// Date Received
  //<< Property DateReceived As WWW.DiscDate(CAPTION = "Date Received");
  public mDiscDate DateReceived;
  //<< 
  //<< /// Date Shipped
  //<< Property DateShipped As WWW.DiscDate(CAPTION = "Date Shipped    ");
  public mDiscDate DateShipped;
  //<< 
  //<< /// Delete Order
  //<< Property DeleteOrder As %Boolean(CAPTION = "Delete Order");
  public Boolean DeleteOrder;
  //<< 
  //<< /// Delivery Note Printed Through
  //<< Property DeliveryNotePrintedThroug As %String(CAPTION = "Delivery Note Printed Through", MAXLEN = 30);
  public String DeliveryNotePrintedThroug;
  //<< 
  //<< /// Delivery Note Printed To
  //<< Property DeliveryNotePrintedTo As WWW.DiscDate(CAPTION = "Delivery Note Printed To");
  public mDiscDate DeliveryNotePrintedTo;
  //<< 
  //<< /// Demand
  //<< Property Demand As %String(CAPTION = "Demand", MAXLEN = 10);
  public String Demand;
  //<< 
  //<< /// Demand Closed
  //<< Property DemandClosed As %Boolean(CAPTION = "Demand Closed");
  public Boolean DemandClosed;
  //<< 
  //<< /// Demand No.
  //<< Property DemandNo As %String(CAPTION = "Demand No.", COLLATION = "EXACT", XMLPROJECTION = "attribute") [ Required ];
  public String DemandNo;
  //<< 
  //<< /// Demand Time
  //<< Property DemandTime As %Time(CAPTION = "Demand Time");
  public Double DemandTime;
  //<< 
  //<< /// Demand Type
  //<< Property DemandType As %String(CAPTION = "Demand Type", MAXLEN = 15);
  public String DemandType;
  //<< 
  //<< /// Demand has Changed (UPA)
  //<< Property DemandhasChangedUPA As %Boolean(CAPTION = "Demand has Changed (UPA)  ");
  public Boolean DemandhasChangedUPA;
  //<< 
  //<< /// Dispatch Number
  //<< Property DispatchNumber As %String(CAPTION = "Dispatch Number", MAXLEN = 10);
  public String DispatchNumber;
  //<< 
  //<< /// Due On/Before
  //<< Property DueOnBefore As WWW.DiscDate(CAPTION = "Due On/Before");
  public mDiscDate DueOnBefore;
  //<< 
  //<< /// External UOM
  //<< Property ExternalUOM As %String(CAPTION = "External UOM", MAXLEN = 30);
  public String ExternalUOM;
  //<< 
  //<< /// _FREE126
  //<< Property FREE126 As %String(CAPTION = "_FREE126", MAXLEN = 300);
  public String FREE126;
  //<< 
  //<< /// _FREE127
  //<< Property FREE127 As %String(CAPTION = "_FREE127", MAXLEN = 300);
  public String FREE127;
  //<< 
  //<< /// _FREE128
  //<< Property FREE128 As %String(CAPTION = "_FREE128", MAXLEN = 300);
  public String FREE128;
  //<< 
  //<< /// _FREE129
  //<< Property FREE129 As %String(CAPTION = "_FREE129", MAXLEN = 300);
  public String FREE129;
  //<< 
  //<< /// _FREE130
  //<< Property FREE130 As %String(CAPTION = "_FREE130", MAXLEN = 300);
  public String FREE130;
  //<< 
  //<< /// _FREE131
  //<< Property FREE131 As %String(CAPTION = "_FREE131", MAXLEN = 300);
  public String FREE131;
  //<< 
  //<< /// _FREE132
  //<< Property FREE132 As %String(CAPTION = "_FREE132", MAXLEN = 300);
  public String FREE132;
  //<< 
  //<< /// _FREE133
  //<< Property FREE133 As %String(CAPTION = "_FREE133", MAXLEN = 300);
  public String FREE133;
  //<< 
  //<< /// _FREE134
  //<< Property FREE134 As %String(CAPTION = "_FREE134", MAXLEN = 300);
  public String FREE134;
  //<< 
  //<< /// _FREE135
  //<< Property FREE135 As %String(CAPTION = "_FREE135", MAXLEN = 300);
  public String FREE135;
  //<< 
  //<< /// _FREE136
  //<< Property FREE136 As %String(CAPTION = "_FREE136", MAXLEN = 300);
  public String FREE136;
  //<< 
  //<< /// _FREE137
  //<< Property FREE137 As %String(CAPTION = "_FREE137", MAXLEN = 300);
  public String FREE137;
  //<< 
  //<< /// _FREE138
  //<< Property FREE138 As %String(CAPTION = "_FREE138", MAXLEN = 300);
  public String FREE138;
  //<< 
  //<< /// _FREE139
  //<< Property FREE139 As %String(CAPTION = "_FREE139", MAXLEN = 300);
  public String FREE139;
  //<< 
  //<< /// _FREE140
  //<< Property FREE140 As %String(CAPTION = "_FREE140", MAXLEN = 300);
  public String FREE140;
  //<< 
  //<< /// _FREE141
  //<< Property FREE141 As %String(CAPTION = "_FREE141", MAXLEN = 300);
  public String FREE141;
  //<< 
  //<< /// _FREE142
  //<< Property FREE142 As %String(CAPTION = "_FREE142", MAXLEN = 300);
  public String FREE142;
  //<< 
  //<< /// _FREE143
  //<< Property FREE143 As %String(CAPTION = "_FREE143", MAXLEN = 300);
  public String FREE143;
  //<< 
  //<< /// _FREE144
  //<< Property FREE144 As %String(CAPTION = "_FREE144", MAXLEN = 300);
  public String FREE144;
  //<< 
  //<< /// _FREE145
  //<< Property FREE145 As %String(CAPTION = "_FREE145", MAXLEN = 300);
  public String FREE145;
  //<< 
  //<< /// _FREE146
  //<< Property FREE146 As %String(CAPTION = "_FREE146", MAXLEN = 300);
  public String FREE146;
  //<< 
  //<< /// _FREE147
  //<< Property FREE147 As %String(CAPTION = "_FREE147", MAXLEN = 300);
  public String FREE147;
  //<< 
  //<< /// _FREE148
  //<< Property FREE148 As %String(CAPTION = "_FREE148", MAXLEN = 300);
  public String FREE148;
  //<< 
  //<< /// _FREE149
  //<< Property FREE149 As %String(CAPTION = "_FREE149", MAXLEN = 300);
  public String FREE149;
  //<< 
  //<< /// _FREE150
  //<< Property FREE150 As %String(CAPTION = "_FREE150", MAXLEN = 300);
  public String FREE150;
  //<< 
  //<< /// _FREE151
  //<< Property FREE151 As %String(CAPTION = "_FREE151", MAXLEN = 300);
  public String FREE151;
  //<< 
  //<< /// _FREE152
  //<< Property FREE152 As %String(CAPTION = "_FREE152", MAXLEN = 300);
  public String FREE152;
  //<< 
  //<< /// _FREE153
  //<< Property FREE153 As %String(CAPTION = "_FREE153", MAXLEN = 300);
  public String FREE153;
  //<< 
  //<< /// _FREE154
  //<< Property FREE154 As %String(CAPTION = "_FREE154", MAXLEN = 300);
  public String FREE154;
  //<< 
  //<< /// _FREE155
  //<< Property FREE155 As %String(CAPTION = "_FREE155", MAXLEN = 300);
  public String FREE155;
  //<< 
  //<< /// Group Number
  //<< Property GroupNumber As %String(CAPTION = "Group Number", MAXLEN = 30);
  public String GroupNumber;
  //<< 
  //<< /// Is New
  //<< Property IsNew As %Boolean(CAPTION = "Is New");
  public Boolean IsNew;
  //<< 
  //<< /// Issue Type
  //<< Property IssueType As %String(CAPTION = "Issue Type", MAXLEN = 30);
  public String IssueType;
  //<< 
  //<< Property ItemDescription As %String(CAPTION = "Item Description") [ Calculated, SqlComputeCode = { set {ItemDescription}=$$ItemDetail^INRPItem({Company},{ItemNo},10)}, SqlComputed ];
  public String ItemDescription;
  //<< 
  //<< Property ItemGroup As %String(CAPTION = "Item Group") [ Calculated, SqlComputeCode = { set {ItemGroup}=$$ItemDetail^INRPItem({Company},{ItemNo},30)}, SqlComputed ];
  public String ItemGroup;
  //<< 
  //<< Property ItemName As %String(CAPTION = "Item Name") [ Calculated, SqlComputeCode = { set {ItemName}=$$ItemDetail^INRPItem({Company},{ItemNo},1)}, SqlComputed ];
  public String ItemName;
  //<< 
  //<< /// Item No.
  //<< Property ItemNo As %String(CAPTION = "Item No.", MAXLEN = 15);
  public String ItemNo;
  //<< 
  //<< /// Item Structure
  //<< Property ItemStructure As %String(CAPTION = "Item Structure  ", MAXLEN = 20);
  public String ItemStructure;
  //<< 
  //<< Property ItemUOM As %String(CAPTION = "Item UOM") [ Calculated, SqlComputeCode = { set {ItemUOM}=$$ItemDetail^INRPItem({Company},{ItemNo},40)}, SqlComputed ];
  public String ItemUOM;
  //<< 
  //<< /// Load List Print Date
  //<< Property LoadListPrintDate As WWW.DiscDate(CAPTION = "Load List Print Date");
  public mDiscDate LoadListPrintDate;
  //<< 
  //<< /// Load Quantity Controlled By
  //<< Property LoadQuantityControlledBy As %String(CAPTION = "Load Quantity Controlled By   ", MAXLEN = 30);
  public String LoadQuantityControlledBy;
  //<< 
  //<< /// Loaded Quantity
  //<< Property LoadedQuantity As %Float(CAPTION = "Loaded Quantity");
  public Double LoadedQuantity;
  //<< 
  //<< /// Location
  //<< Property Location As %String(CAPTION = "Location", COLLATION = "EXACT", MAXLEN = 20, XMLPROJECTION = "attribute") [ Required ];
  public String Location;
  //<< 
  //<< Property LocationDescription As %String(CAPTION = "Location Description") [ Calculated, SqlComputeCode = { set {LocationDescription}=$$GetLocationName^INRPDRPDEMAND({Company},{Location})}, SqlComputed ];
  public String LocationDescription;
  //<< 
  //<< /// Memo
  //<< Property Memo As %String(CAPTION = "Memo", MAXLEN = 30);
  public String Memo;
  //<< 
  //<< /// Order No.
  //<< Property OrderNo As %String(CAPTION = "Order No.", MAXLEN = 20);
  public String OrderNo;
  //<< 
  //<< /// Order Planned For
  //<< Property OrderPlannedFor As WWW.DiscDate(CAPTION = "Order Planned For");
  public mDiscDate OrderPlannedFor;
  //<< 
  //<< /// Pick List Print Date
  //<< Property PickListPrintDate As WWW.DiscDate(CAPTION = "Pick List Print Date ");
  public mDiscDate PickListPrintDate;
  //<< 
  //<< /// Picked By
  //<< Property PickedBy As %String(CAPTION = "Picked By", MAXLEN = 30);
  public String PickedBy;
  //<< 
  //<< /// Picked Quantity
  //<< Property PickedQuantity As %Float(CAPTION = "Picked Quantity");
  public Double PickedQuantity;
  //<< 
  //<< /// Planned By
  //<< Property PlannedBy As %String(CAPTION = "Planned By", MAXLEN = 30);
  public String PlannedBy;
  //<< 
  //<< /// Planned Date
  //<< Property PlannedDate As WWW.DiscDate(CAPTION = "Planned Date");
  public mDiscDate PlannedDate;
  //<< 
  //<< /// Planned Shipping Date
  //<< Property PlannedShippingDate As WWW.DiscDate(CAPTION = "Planned Shipping Date  ");
  public mDiscDate PlannedShippingDate;
  //<< 
  //<< /// Price Per Unit
  //<< Property PricePerUnit As %Currency(CAPTION = "Price Per Unit");
  public Double PricePerUnit;
  //<< 
  //<< Property PricePerUnitBASE As %Float(CAPTION = "PricePerUnitBASE") [ Calculated, SqlComputeCode = { set {PricePerUnitBASE}=$$FCBase^COMSYSFC({PricePerUnit})}, SqlComputed ];
  public Double PricePerUnitBASE;
  //<< 
  //<< /// Priority
  //<< Property Priority As %String(CAPTION = "Priority", MAXLEN = 15);
  public String Priority;
  //<< 
  //<< Property QOHFromLocation As %Float(CAPTION = "QOH From Location") [ Calculated, SqlComputeCode = { set {QOHFromLocation}=$$GetQOHFromLocation^INRPItem({Company},{Location},{ItemNo})}, SqlComputed ];
  public Double QOHFromLocation;
  //<< 
  //<< /// Quantity
  //<< Property Quantity As %Float(CAPTION = "Quantity");
  public Double Quantity;
  //<< 
  //<< /// Quote Information
  //<< Property QuoteInformation As %String(CAPTION = "Quote Information", MAXLEN = 15);
  public String QuoteInformation;
  //<< 
  //<< /// Ready For Delivery
  //<< Property ReadyForDelivery As %Boolean(CAPTION = "Ready For Delivery  ");
  public Boolean ReadyForDelivery;
  //<< 
  //<< /// Received By
  //<< Property ReceivedBy As %String(CAPTION = "Received By", MAXLEN = 30);
  public String ReceivedBy;
  //<< 
  //<< /// Received Quantity
  //<< Property ReceivedQuantity As %Float(CAPTION = "Received Quantity");
  public Double ReceivedQuantity;
  //<< 
  //<< /// Reference
  //<< Property Reference As %String(CAPTION = "Reference", MAXLEN = 30);
  public String Reference;
  //<< 
  //<< /// Released by
  //<< Property Releasedby As %String(CAPTION = "Released by  ", MAXLEN = 30);
  public String Releasedby;
  //<< 
  //<< /// Released on
  //<< Property Releasedon As WWW.DiscDate(CAPTION = "Released on ");
  public mDiscDate Releasedon;
  //<< 
  //<< Property ReqLocDescription As %String(CAPTION = "Requesting Location Desc") [ Calculated, SqlComputeCode = { set {ReqLocDescription}=$$GetLocationName^INRPDRPDEMAND({Company},{RequestingLocation})}, SqlComputed ];
  public String ReqLocDescription;
  //<< 
  //<< /// Location
  //<< Property RequestingLocation As %String(CAPTION = "Location", MAXLEN = 30);
  public String RequestingLocation;
  //<< 
  //<< /// Supply Number
  //<< Property RequisitionNumber As %String(CAPTION = "Supply Number", MAXLEN = 30);
  public String RequisitionNumber;
  //<< 
  //<< /// Responsible Planner
  //<< Property ResponsiblePlanner As %String(CAPTION = "Responsible Planner  ", MAXLEN = 30);
  public String ResponsiblePlanner;
  //<< 
  //<< /// Shipped Quantity
  //<< Property ShippedQuantity As %Float(CAPTION = "Shipped Quantity");
  public Double ShippedQuantity;
  //<< 
  //<< /// Source Storage
  //<< Property SourceStockLocation As %String(CAPTION = "Source Storage", MAXLEN = 30);
  public String SourceStockLocation;
  //<< 
  //<< /// Sourced Quantity
  //<< Property SourcedQuantity As %Float(CAPTION = "Sourced Quantity");
  public Double SourcedQuantity;
  //<< 
  //<< /// Special Order
  //<< Property SpecialOrder As %Boolean(CAPTION = "Special Order");
  public Boolean SpecialOrder;
  //<< 
  //<< /// Specification
  //<< Property Specification As %String(CAPTION = "Specification  ", MAXLEN = 32000);
  public String Specification;
  //<< 
  //<< /// Status
  //<< Property Status As %String(CAPTION = "Status  ", MAXLEN = 30);
  public String Status;
  //<< 
  //<< /// Suggested Qty On Change
  //<< Property SuggestedQtyOnChange As %Numeric(CAPTION = "Suggested Qty On Change ");
  public Double SuggestedQtyOnChange;
  //<< 
  //<< /// Suggested Quantity
  //<< Property SuggestedQuantity As %Float(CAPTION = "Suggested Quantity");
  public Double SuggestedQuantity;
  //<< 
  //<< /// Supply Created
  //<< Property SupplyCreated As WWW.DiscTimestamp(CAPTION = "Supply Created");
  public String SupplyCreated;
  //<< 
  //<< /// Text
  //<< Property Text As %String(CAPTION = "Text", MAXLEN = 32000);
  public String Text;
  //<< 
  //<< /// Transfer
  //<< Property Transfer As %String(CAPTION = "Transfer", MAXLEN = 30);
  public String Transfer;
  //<< 
  //<< /// Transfer Structure Of Level
  //<< Property TransferStructureOfLevel As WWW.DiscTimestamp(CAPTION = "Transfer Structure Of Level");
  public String TransferStructureOfLevel;

  //<< 
  //<< Index IDKEY On (Company, Location, DemandNo) [ IdKey, PrimaryKey, Unique ];
  //<< 
  //<< Method %OnBeforeSave(insert As %Boolean) As %Status [ Private, ServerOnly = 1 ]
  public Object $OnBeforeSave(Object ... _p) {
    mVar insert = m$.newVarRef("insert",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< {
    //<< set strClass="INDRPDEMAND"
    mVar strClass = m$.var("strClass");
    strClass.set("INDRPDEMAND");
    //<< set $piece(idKey,",",1)=i%Location
    m$.pieceVar(m$.var("idKey"),",",1).set(m$.var("i%Location").get());
    //<< set $piece(idKey,",",2)=i%DemandNo
    m$.pieceVar(m$.var("idKey"),",",2).set(m$.var("i%DemandNo").get());
    //<< set $piece(objRec,"~",1)=i%RequestingLocation
    m$.pieceVar(m$.var("objRec"),"~",1).set(m$.var("i%RequestingLocation").get());
    //<< set $piece(objRec,"~",2)=i%OrderNo
    m$.pieceVar(m$.var("objRec"),"~",2).set(m$.var("i%OrderNo").get());
    //<< set $piece(objRec,"~",3)=i%Createdon
    m$.pieceVar(m$.var("objRec"),"~",3).set(m$.var("i%Createdon").get());
    //<< set $piece(objRec,"~",4)=i%ItemNo
    m$.pieceVar(m$.var("objRec"),"~",4).set(m$.var("i%ItemNo").get());
    //<< set $piece(objRec,"~",5)=i%Quantity
    m$.pieceVar(m$.var("objRec"),"~",5).set(m$.var("i%Quantity").get());
    //<< set $piece(objRec,"~",6)=i%DueOnBefore
    m$.pieceVar(m$.var("objRec"),"~",6).set(m$.var("i%DueOnBefore").get());
    //<< set $piece(objRec,"~",7)=i%ConfirmedReceiptDate
    m$.pieceVar(m$.var("objRec"),"~",7).set(m$.var("i%ConfirmedReceiptDate").get());
    //<< set $piece(objRec,"~",8)=i%ResponsiblePlanner
    m$.pieceVar(m$.var("objRec"),"~",8).set(m$.var("i%ResponsiblePlanner").get());
    //<< set $piece(objRec,"~",9)=i%Demand
    m$.pieceVar(m$.var("objRec"),"~",9).set(m$.var("i%Demand").get());
    //<< set $piece(objRec,"~",10)=i%CreatedBy
    m$.pieceVar(m$.var("objRec"),"~",10).set(m$.var("i%CreatedBy").get());
    //<< set $piece(objRec,"~",11)=i%IssueType
    m$.pieceVar(m$.var("objRec"),"~",11).set(m$.var("i%IssueType").get());
    //<< set $piece(objRec,"~",12)=i%CompletionPlanned
    m$.pieceVar(m$.var("objRec"),"~",12).set(m$.var("i%CompletionPlanned").get());
    //<< set $piece(objRec,"~",13)=i%CompletionConfirmed
    m$.pieceVar(m$.var("objRec"),"~",13).set(m$.var("i%CompletionConfirmed").get());
    //<< set $piece(objRec,"~",14)=i%ExternalUOM
    m$.pieceVar(m$.var("objRec"),"~",14).set(m$.var("i%ExternalUOM").get());
    //<< set $piece(objRec,"~",15)=i%PlannedDate
    m$.pieceVar(m$.var("objRec"),"~",15).set(m$.var("i%PlannedDate").get());
    //<< set $piece(objRec,"~",16)=i%PlannedBy
    m$.pieceVar(m$.var("objRec"),"~",16).set(m$.var("i%PlannedBy").get());
    //<< set $piece(objRec,"~",17)=i%DemandTime
    m$.pieceVar(m$.var("objRec"),"~",17).set(m$.var("i%DemandTime").get());
    //<< set $piece(objRec,"~",19)=i%Blocked
    m$.pieceVar(m$.var("objRec"),"~",19).set(m$.var("i%Blocked").get());
    //<< set $piece(objRec,"~",20)=i%Releasedon
    m$.pieceVar(m$.var("objRec"),"~",20).set(m$.var("i%Releasedon").get());
    //<< set $piece(objRec,"~",21)=i%Releasedby
    m$.pieceVar(m$.var("objRec"),"~",21).set(m$.var("i%Releasedby").get());
    //<< set $piece(objRec,"~",22)=i%ConfirmationReceived
    m$.pieceVar(m$.var("objRec"),"~",22).set(m$.var("i%ConfirmationReceived").get());
    //<< set $piece(objRec,"~",26)=i%ShippedQuantity
    m$.pieceVar(m$.var("objRec"),"~",26).set(m$.var("i%ShippedQuantity").get());
    //<< set $piece(objRec,"~",39)=i%ReadyForDelivery
    m$.pieceVar(m$.var("objRec"),"~",39).set(m$.var("i%ReadyForDelivery").get());
    //<< set $piece(objRec,"~",40)=i%PlannedShippingDate
    m$.pieceVar(m$.var("objRec"),"~",40).set(m$.var("i%PlannedShippingDate").get());
    //<< set $piece(objRec,"~",41)=i%DispatchNumber
    m$.pieceVar(m$.var("objRec"),"~",41).set(m$.var("i%DispatchNumber").get());
    //<< set $piece(objRec,"~",42)=i%PickListPrintDate
    m$.pieceVar(m$.var("objRec"),"~",42).set(m$.var("i%PickListPrintDate").get());
    //<< set $piece(objRec,"~",46)=i%PickedBy
    m$.pieceVar(m$.var("objRec"),"~",46).set(m$.var("i%PickedBy").get());
    //<< set $piece(objRec,"~",50)=i%PickedQuantity
    m$.pieceVar(m$.var("objRec"),"~",50).set(m$.var("i%PickedQuantity").get());
    //<< set $piece(objRec,"~",52)=i%LoadListPrintDate
    m$.pieceVar(m$.var("objRec"),"~",52).set(m$.var("i%LoadListPrintDate").get());
    //<< set $piece(objRec,"~",56)=i%LoadQuantityControlledBy
    m$.pieceVar(m$.var("objRec"),"~",56).set(m$.var("i%LoadQuantityControlledBy").get());
    //<< set $piece(objRec,"~",60)=i%LoadedQuantity
    m$.pieceVar(m$.var("objRec"),"~",60).set(m$.var("i%LoadedQuantity").get());
    //<< set $piece(objRec,"~",61)=i%DateShipped
    m$.pieceVar(m$.var("objRec"),"~",61).set(m$.var("i%DateShipped").get());
    //<< set $piece(objRec,"~",62)=i%DeliveryNotePrintedTo
    m$.pieceVar(m$.var("objRec"),"~",62).set(m$.var("i%DeliveryNotePrintedTo").get());
    //<< set $piece(objRec,"~",63)=i%DeliveryNotePrintedThroug
    m$.pieceVar(m$.var("objRec"),"~",63).set(m$.var("i%DeliveryNotePrintedThroug").get());
    //<< set $piece(objRec,"~",64)=i%DateReceived
    m$.pieceVar(m$.var("objRec"),"~",64).set(m$.var("i%DateReceived").get());
    //<< set $piece(objRec,"~",66)=i%ReceivedBy
    m$.pieceVar(m$.var("objRec"),"~",66).set(m$.var("i%ReceivedBy").get());
    //<< set $piece(objRec,"~",67)=i%ReceivedQuantity
    m$.pieceVar(m$.var("objRec"),"~",67).set(m$.var("i%ReceivedQuantity").get());
    //<< set $piece(objRec,"~",70)=i%DemandType
    m$.pieceVar(m$.var("objRec"),"~",70).set(m$.var("i%DemandType").get());
    //<< set $piece(objRec,"~",71)=i%Priority
    m$.pieceVar(m$.var("objRec"),"~",71).set(m$.var("i%Priority").get());
    //<< set $piece(objRec,"~",72)=i%ItemStructure
    m$.pieceVar(m$.var("objRec"),"~",72).set(m$.var("i%ItemStructure").get());
    //<< set $piece(objRec,"~",73)=i%Status
    m$.pieceVar(m$.var("objRec"),"~",73).set(m$.var("i%Status").get());
    //<< set $piece(objRec,"~",80)=i%SourcedQuantity
    m$.pieceVar(m$.var("objRec"),"~",80).set(m$.var("i%SourcedQuantity").get());
    //<< set $piece(objRec,"~",98)=i%DeleteOrder
    m$.pieceVar(m$.var("objRec"),"~",98).set(m$.var("i%DeleteOrder").get());
    //<< set $piece(objRec,"~",99)=i%DemandClosed
    m$.pieceVar(m$.var("objRec"),"~",99).set(m$.var("i%DemandClosed").get());
    //<< set $piece(objRec,"~",100)=i%Text
    m$.pieceVar(m$.var("objRec"),"~",100).set(m$.var("i%Text").get());
    //<< set $piece(objRec,"~",101)=i%TransferStructureOfLevel
    m$.pieceVar(m$.var("objRec"),"~",101).set(m$.var("i%TransferStructureOfLevel").get());
    //<< set $piece(objRec,"~",105)=i%Specification
    m$.pieceVar(m$.var("objRec"),"~",105).set(m$.var("i%Specification").get());
    //<< set $piece(objRec,"~",110)=i%SpecialOrder
    m$.pieceVar(m$.var("objRec"),"~",110).set(m$.var("i%SpecialOrder").get());
    //<< set $piece(objRec,"~",111)=i%Reference
    m$.pieceVar(m$.var("objRec"),"~",111).set(m$.var("i%Reference").get());
    //<< set $piece(objRec,"~",112)=i%OrderPlannedFor
    m$.pieceVar(m$.var("objRec"),"~",112).set(m$.var("i%OrderPlannedFor").get());
    //<< set $piece(objRec,"~",113)=i%SuggestedQuantity
    m$.pieceVar(m$.var("objRec"),"~",113).set(m$.var("i%SuggestedQuantity").get());
    //<< set $piece(objRec,"~",114)=i%QuoteInformation
    m$.pieceVar(m$.var("objRec"),"~",114).set(m$.var("i%QuoteInformation").get());
    //<< set $piece(objRec,"~",115)=i%Memo
    m$.pieceVar(m$.var("objRec"),"~",115).set(m$.var("i%Memo").get());
    //<< set $piece(objRec,"~",116)=i%PricePerUnit
    m$.pieceVar(m$.var("objRec"),"~",116).set(m$.var("i%PricePerUnit").get());
    //<< set $piece(objRec,"~",117)=i%CustomerDeliveryAddress
    m$.pieceVar(m$.var("objRec"),"~",117).set(m$.var("i%CustomerDeliveryAddress").get());
    //<< set $piece(objRec,"~",118)=i%DemandhasChangedUPA
    m$.pieceVar(m$.var("objRec"),"~",118).set(m$.var("i%DemandhasChangedUPA").get());
    //<< set $piece(objRec,"~",119)=i%SuggestedQtyOnChange
    m$.pieceVar(m$.var("objRec"),"~",119).set(m$.var("i%SuggestedQtyOnChange").get());
    //<< set $piece(objRec,"~",120)=i%SupplyCreated
    m$.pieceVar(m$.var("objRec"),"~",120).set(m$.var("i%SupplyCreated").get());
    //<< set $piece(objRec,"~",121)=i%SourceStockLocation
    m$.pieceVar(m$.var("objRec"),"~",121).set(m$.var("i%SourceStockLocation").get());
    //<< set $piece(objRec,"~",122)=i%Transfer
    m$.pieceVar(m$.var("objRec"),"~",122).set(m$.var("i%Transfer").get());
    //<< set $piece(objRec,"~",123)=i%IsNew
    m$.pieceVar(m$.var("objRec"),"~",123).set(m$.var("i%IsNew").get());
    //<< set $piece(objRec,"~",124)=i%GroupNumber
    m$.pieceVar(m$.var("objRec"),"~",124).set(m$.var("i%GroupNumber").get());
    //<< set $piece(objRec,"~",125)=i%RequisitionNumber
    m$.pieceVar(m$.var("objRec"),"~",125).set(m$.var("i%RequisitionNumber").get());
    //<< set $piece(objRec,"~",126)=i%FREE126
    m$.pieceVar(m$.var("objRec"),"~",126).set(m$.var("i%FREE126").get());
    //<< set $piece(objRec,"~",127)=i%FREE127
    m$.pieceVar(m$.var("objRec"),"~",127).set(m$.var("i%FREE127").get());
    //<< set $piece(objRec,"~",128)=i%FREE128
    m$.pieceVar(m$.var("objRec"),"~",128).set(m$.var("i%FREE128").get());
    //<< set $piece(objRec,"~",129)=i%FREE129
    m$.pieceVar(m$.var("objRec"),"~",129).set(m$.var("i%FREE129").get());
    //<< set $piece(objRec,"~",130)=i%FREE130
    m$.pieceVar(m$.var("objRec"),"~",130).set(m$.var("i%FREE130").get());
    //<< set $piece(objRec,"~",131)=i%FREE131
    m$.pieceVar(m$.var("objRec"),"~",131).set(m$.var("i%FREE131").get());
    //<< set $piece(objRec,"~",132)=i%FREE132
    m$.pieceVar(m$.var("objRec"),"~",132).set(m$.var("i%FREE132").get());
    //<< set $piece(objRec,"~",133)=i%FREE133
    m$.pieceVar(m$.var("objRec"),"~",133).set(m$.var("i%FREE133").get());
    //<< set $piece(objRec,"~",134)=i%FREE134
    m$.pieceVar(m$.var("objRec"),"~",134).set(m$.var("i%FREE134").get());
    //<< set $piece(objRec,"~",135)=i%FREE135
    m$.pieceVar(m$.var("objRec"),"~",135).set(m$.var("i%FREE135").get());
    //<< set $piece(objRec,"~",136)=i%FREE136
    m$.pieceVar(m$.var("objRec"),"~",136).set(m$.var("i%FREE136").get());
    //<< set $piece(objRec,"~",137)=i%FREE137
    m$.pieceVar(m$.var("objRec"),"~",137).set(m$.var("i%FREE137").get());
    //<< set $piece(objRec,"~",138)=i%FREE138
    m$.pieceVar(m$.var("objRec"),"~",138).set(m$.var("i%FREE138").get());
    //<< set $piece(objRec,"~",139)=i%FREE139
    m$.pieceVar(m$.var("objRec"),"~",139).set(m$.var("i%FREE139").get());
    //<< set $piece(objRec,"~",140)=i%FREE140
    m$.pieceVar(m$.var("objRec"),"~",140).set(m$.var("i%FREE140").get());
    //<< set $piece(objRec,"~",141)=i%FREE141
    m$.pieceVar(m$.var("objRec"),"~",141).set(m$.var("i%FREE141").get());
    //<< set $piece(objRec,"~",142)=i%FREE142
    m$.pieceVar(m$.var("objRec"),"~",142).set(m$.var("i%FREE142").get());
    //<< set $piece(objRec,"~",143)=i%FREE143
    m$.pieceVar(m$.var("objRec"),"~",143).set(m$.var("i%FREE143").get());
    //<< set $piece(objRec,"~",144)=i%FREE144
    m$.pieceVar(m$.var("objRec"),"~",144).set(m$.var("i%FREE144").get());
    //<< set $piece(objRec,"~",145)=i%FREE145
    m$.pieceVar(m$.var("objRec"),"~",145).set(m$.var("i%FREE145").get());
    //<< set $piece(objRec,"~",146)=i%FREE146
    m$.pieceVar(m$.var("objRec"),"~",146).set(m$.var("i%FREE146").get());
    //<< set $piece(objRec,"~",147)=i%FREE147
    m$.pieceVar(m$.var("objRec"),"~",147).set(m$.var("i%FREE147").get());
    //<< set $piece(objRec,"~",148)=i%FREE148
    m$.pieceVar(m$.var("objRec"),"~",148).set(m$.var("i%FREE148").get());
    //<< set $piece(objRec,"~",149)=i%FREE149
    m$.pieceVar(m$.var("objRec"),"~",149).set(m$.var("i%FREE149").get());
    //<< set $piece(objRec,"~",150)=i%FREE150
    m$.pieceVar(m$.var("objRec"),"~",150).set(m$.var("i%FREE150").get());
    //<< set $piece(objRec,"~",151)=i%FREE151
    m$.pieceVar(m$.var("objRec"),"~",151).set(m$.var("i%FREE151").get());
    //<< set $piece(objRec,"~",152)=i%FREE152
    m$.pieceVar(m$.var("objRec"),"~",152).set(m$.var("i%FREE152").get());
    //<< set $piece(objRec,"~",153)=i%FREE153
    m$.pieceVar(m$.var("objRec"),"~",153).set(m$.var("i%FREE153").get());
    //<< set $piece(objRec,"~",154)=i%FREE154
    m$.pieceVar(m$.var("objRec"),"~",154).set(m$.var("i%FREE154").get());
    //<< set $piece(objRec,"~",155)=i%FREE155
    m$.pieceVar(m$.var("objRec"),"~",155).set(m$.var("i%FREE155").get());
    //<< set sc=$$OnBeforeSave^COMObject(insert,strClass,idKey,.objRec)
    mVar sc = m$.var("sc");
    sc.set(m$.fnc$("COMObject.OnBeforeSave",insert.get(),strClass.get(),m$.var("idKey").get(),m$.var("objRec")));
    //<< set i%RequestingLocation=$piece(objRec,"~",1)
    m$.prop(this,"RequestingLocation").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",1));
    //<< set i%OrderNo=$piece(objRec,"~",2)
    m$.prop(this,"OrderNo").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",2));
    //<< set i%Createdon=$piece(objRec,"~",3)
    m$.prop(this,"Createdon").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",3));
    //<< set i%ItemNo=$piece(objRec,"~",4)
    m$.prop(this,"ItemNo").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",4));
    //<< set i%Quantity=$piece(objRec,"~",5)
    m$.prop(this,"Quantity").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",5));
    //<< set i%DueOnBefore=$piece(objRec,"~",6)
    m$.prop(this,"DueOnBefore").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",6));
    //<< set i%ConfirmedReceiptDate=$piece(objRec,"~",7)
    m$.prop(this,"ConfirmedReceiptDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",7));
    //<< set i%ResponsiblePlanner=$piece(objRec,"~",8)
    m$.prop(this,"ResponsiblePlanner").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",8));
    //<< set i%Demand=$piece(objRec,"~",9)
    m$.prop(this,"Demand").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",9));
    //<< set i%CreatedBy=$piece(objRec,"~",10)
    m$.prop(this,"CreatedBy").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",10));
    //<< set i%IssueType=$piece(objRec,"~",11)
    m$.prop(this,"IssueType").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",11));
    //<< set i%CompletionPlanned=$piece(objRec,"~",12)
    m$.prop(this,"CompletionPlanned").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",12));
    //<< set i%CompletionConfirmed=$piece(objRec,"~",13)
    m$.prop(this,"CompletionConfirmed").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",13));
    //<< set i%ExternalUOM=$piece(objRec,"~",14)
    m$.prop(this,"ExternalUOM").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",14));
    //<< set i%PlannedDate=$piece(objRec,"~",15)
    m$.prop(this,"PlannedDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",15));
    //<< set i%PlannedBy=$piece(objRec,"~",16)
    m$.prop(this,"PlannedBy").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",16));
    //<< set i%DemandTime=$piece(objRec,"~",17)
    m$.prop(this,"DemandTime").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",17));
    //<< set i%Blocked=$piece(objRec,"~",19)
    m$.prop(this,"Blocked").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",19));
    //<< set i%Releasedon=$piece(objRec,"~",20)
    m$.prop(this,"Releasedon").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",20));
    //<< set i%Releasedby=$piece(objRec,"~",21)
    m$.prop(this,"Releasedby").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",21));
    //<< set i%ConfirmationReceived=$piece(objRec,"~",22)
    m$.prop(this,"ConfirmationReceived").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",22));
    //<< set i%ShippedQuantity=$piece(objRec,"~",26)
    m$.prop(this,"ShippedQuantity").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",26));
    //<< set i%ReadyForDelivery=$piece(objRec,"~",39)
    m$.prop(this,"ReadyForDelivery").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",39));
    //<< set i%PlannedShippingDate=$piece(objRec,"~",40)
    m$.prop(this,"PlannedShippingDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",40));
    //<< set i%DispatchNumber=$piece(objRec,"~",41)
    m$.prop(this,"DispatchNumber").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",41));
    //<< set i%PickListPrintDate=$piece(objRec,"~",42)
    m$.prop(this,"PickListPrintDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",42));
    //<< set i%PickedBy=$piece(objRec,"~",46)
    m$.prop(this,"PickedBy").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",46));
    //<< set i%PickedQuantity=$piece(objRec,"~",50)
    m$.prop(this,"PickedQuantity").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",50));
    //<< set i%LoadListPrintDate=$piece(objRec,"~",52)
    m$.prop(this,"LoadListPrintDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",52));
    //<< set i%LoadQuantityControlledBy=$piece(objRec,"~",56)
    m$.prop(this,"LoadQuantityControlledBy").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",56));
    //<< set i%LoadedQuantity=$piece(objRec,"~",60)
    m$.prop(this,"LoadedQuantity").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",60));
    //<< set i%DateShipped=$piece(objRec,"~",61)
    m$.prop(this,"DateShipped").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",61));
    //<< set i%DeliveryNotePrintedTo=$piece(objRec,"~",62)
    m$.prop(this,"DeliveryNotePrintedTo").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",62));
    //<< set i%DeliveryNotePrintedThroug=$piece(objRec,"~",63)
    m$.prop(this,"DeliveryNotePrintedThroug").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",63));
    //<< set i%DateReceived=$piece(objRec,"~",64)
    m$.prop(this,"DateReceived").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",64));
    //<< set i%ReceivedBy=$piece(objRec,"~",66)
    m$.prop(this,"ReceivedBy").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",66));
    //<< set i%ReceivedQuantity=$piece(objRec,"~",67)
    m$.prop(this,"ReceivedQuantity").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",67));
    //<< set i%DemandType=$piece(objRec,"~",70)
    m$.prop(this,"DemandType").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",70));
    //<< set i%Priority=$piece(objRec,"~",71)
    m$.prop(this,"Priority").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",71));
    //<< set i%ItemStructure=$piece(objRec,"~",72)
    m$.prop(this,"ItemStructure").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",72));
    //<< set i%Status=$piece(objRec,"~",73)
    m$.prop(this,"Status").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",73));
    //<< set i%SourcedQuantity=$piece(objRec,"~",80)
    m$.prop(this,"SourcedQuantity").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",80));
    //<< set i%DeleteOrder=$piece(objRec,"~",98)
    m$.prop(this,"DeleteOrder").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",98));
    //<< set i%DemandClosed=$piece(objRec,"~",99)
    m$.prop(this,"DemandClosed").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",99));
    //<< set i%Text=$piece(objRec,"~",100)
    m$.prop(this,"Text").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",100));
    //<< set i%TransferStructureOfLevel=$piece(objRec,"~",101)
    m$.prop(this,"TransferStructureOfLevel").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",101));
    //<< set i%Specification=$piece(objRec,"~",105)
    m$.prop(this,"Specification").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",105));
    //<< set i%SpecialOrder=$piece(objRec,"~",110)
    m$.prop(this,"SpecialOrder").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",110));
    //<< set i%Reference=$piece(objRec,"~",111)
    m$.prop(this,"Reference").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",111));
    //<< set i%OrderPlannedFor=$piece(objRec,"~",112)
    m$.prop(this,"OrderPlannedFor").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",112));
    //<< set i%SuggestedQuantity=$piece(objRec,"~",113)
    m$.prop(this,"SuggestedQuantity").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",113));
    //<< set i%QuoteInformation=$piece(objRec,"~",114)
    m$.prop(this,"QuoteInformation").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",114));
    //<< set i%Memo=$piece(objRec,"~",115)
    m$.prop(this,"Memo").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",115));
    //<< set i%PricePerUnit=$piece(objRec,"~",116)
    m$.prop(this,"PricePerUnit").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",116));
    //<< set i%CustomerDeliveryAddress=$piece(objRec,"~",117)
    m$.prop(this,"CustomerDeliveryAddress").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",117));
    //<< set i%DemandhasChangedUPA=$piece(objRec,"~",118)
    m$.prop(this,"DemandhasChangedUPA").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",118));
    //<< set i%SuggestedQtyOnChange=$piece(objRec,"~",119)
    m$.prop(this,"SuggestedQtyOnChange").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",119));
    //<< set i%SupplyCreated=$piece(objRec,"~",120)
    m$.prop(this,"SupplyCreated").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",120));
    //<< set i%SourceStockLocation=$piece(objRec,"~",121)
    m$.prop(this,"SourceStockLocation").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",121));
    //<< set i%Transfer=$piece(objRec,"~",122)
    m$.prop(this,"Transfer").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",122));
    //<< set i%IsNew=$piece(objRec,"~",123)
    m$.prop(this,"IsNew").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",123));
    //<< set i%GroupNumber=$piece(objRec,"~",124)
    m$.prop(this,"GroupNumber").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",124));
    //<< set i%RequisitionNumber=$piece(objRec,"~",125)
    m$.prop(this,"RequisitionNumber").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",125));
    //<< set i%FREE126=$piece(objRec,"~",126)
    m$.prop(this,"FREE126").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",126));
    //<< set i%FREE127=$piece(objRec,"~",127)
    m$.prop(this,"FREE127").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",127));
    //<< set i%FREE128=$piece(objRec,"~",128)
    m$.prop(this,"FREE128").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",128));
    //<< set i%FREE129=$piece(objRec,"~",129)
    m$.prop(this,"FREE129").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",129));
    //<< set i%FREE130=$piece(objRec,"~",130)
    m$.prop(this,"FREE130").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",130));
    //<< set i%FREE131=$piece(objRec,"~",131)
    m$.prop(this,"FREE131").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",131));
    //<< set i%FREE132=$piece(objRec,"~",132)
    m$.prop(this,"FREE132").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",132));
    //<< set i%FREE133=$piece(objRec,"~",133)
    m$.prop(this,"FREE133").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",133));
    //<< set i%FREE134=$piece(objRec,"~",134)
    m$.prop(this,"FREE134").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",134));
    //<< set i%FREE135=$piece(objRec,"~",135)
    m$.prop(this,"FREE135").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",135));
    //<< set i%FREE136=$piece(objRec,"~",136)
    m$.prop(this,"FREE136").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",136));
    //<< set i%FREE137=$piece(objRec,"~",137)
    m$.prop(this,"FREE137").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",137));
    //<< set i%FREE138=$piece(objRec,"~",138)
    m$.prop(this,"FREE138").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",138));
    //<< set i%FREE139=$piece(objRec,"~",139)
    m$.prop(this,"FREE139").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",139));
    //<< set i%FREE140=$piece(objRec,"~",140)
    m$.prop(this,"FREE140").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",140));
    //<< set i%FREE141=$piece(objRec,"~",141)
    m$.prop(this,"FREE141").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",141));
    //<< set i%FREE142=$piece(objRec,"~",142)
    m$.prop(this,"FREE142").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",142));
    //<< set i%FREE143=$piece(objRec,"~",143)
    m$.prop(this,"FREE143").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",143));
    //<< set i%FREE144=$piece(objRec,"~",144)
    m$.prop(this,"FREE144").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",144));
    //<< set i%FREE145=$piece(objRec,"~",145)
    m$.prop(this,"FREE145").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",145));
    //<< set i%FREE146=$piece(objRec,"~",146)
    m$.prop(this,"FREE146").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",146));
    //<< set i%FREE147=$piece(objRec,"~",147)
    m$.prop(this,"FREE147").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",147));
    //<< set i%FREE148=$piece(objRec,"~",148)
    m$.prop(this,"FREE148").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",148));
    //<< set i%FREE149=$piece(objRec,"~",149)
    m$.prop(this,"FREE149").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",149));
    //<< set i%FREE150=$piece(objRec,"~",150)
    m$.prop(this,"FREE150").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",150));
    //<< set i%FREE151=$piece(objRec,"~",151)
    m$.prop(this,"FREE151").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",151));
    //<< set i%FREE152=$piece(objRec,"~",152)
    m$.prop(this,"FREE152").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",152));
    //<< set i%FREE153=$piece(objRec,"~",153)
    m$.prop(this,"FREE153").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",153));
    //<< set i%FREE154=$piece(objRec,"~",154)
    m$.prop(this,"FREE154").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",154));
    //<< set i%FREE155=$piece(objRec,"~",155)
    m$.prop(this,"FREE155").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",155));
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
  //<< Method ItemGroupGet() As %String [ CodeMode = expression ]
  public Object ItemGroupGet() {
    //<< {
    //<< $$ItemDetail^INRPItem(..Company,..ItemNo,30)
    return m$.fnc$("INRPItem.ItemDetail",this.Company,this.ItemNo,30);
  //<< }
  }

  //<< 
  //<< Method ItemNameGet() As %String [ CodeMode = expression ]
  public Object ItemNameGet() {
    //<< {
    //<< $$ItemDetail^INRPItem(..Company,..ItemNo,1)
    return m$.fnc$("INRPItem.ItemDetail",this.Company,this.ItemNo,1);
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
  //<< Method LocationDescriptionGet() As %String [ CodeMode = expression ]
  public Object LocationDescriptionGet() {
    //<< {
    //<< $$GetLocationName^INRPDRPDEMAND(..Company,..Location)
    return m$.fnc$("INRPDRPDEMAND.GetLocationName",this.Company,this.Location);
  //<< }
  }

  //<< 
  //<< Method PricePerUnitBASEGet() As %Float [ CodeMode = expression ]
  public Object PricePerUnitBASEGet() {
    //<< {
    //<< $$FCBase^COMSYSFC(..PricePerUnit)
    return m$.fnc$("COMSYSFC.FCBase",this.PricePerUnit);
  //<< }
  }

  //<< 
  //<< Method QOHFromLocationGet() As %Float [ CodeMode = expression ]
  public Object QOHFromLocationGet() {
    //<< {
    //<< $$GetQOHFromLocation^INRPItem(..Company,..Location,..ItemNo)
    return m$.fnc$("INRPItem.GetQOHFromLocation",this.Company,this.Location,this.ItemNo);
  //<< }
  }

  //<< 
  //<< Method ReqLocDescriptionGet() As %String [ CodeMode = expression ]
  public Object ReqLocDescriptionGet() {
    //<< {
    //<< $$GetLocationName^INRPDRPDEMAND(..Company,..RequestingLocation)
    return m$.fnc$("INRPDRPDEMAND.GetLocationName",this.Company,this.RequestingLocation);
  //<< }
  }

//<< 
//<< }
}
