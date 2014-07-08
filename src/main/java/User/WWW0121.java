//*****************************************************************************
//** TASC - ALPHALINC - CLASS User.WWW0121
//** Innovatium Systems - Code Converter - v1.31
//** 2014-07-07 18:10:14
//*****************************************************************************

package User;

import mLibrary.*;

//<< /// Location Master Data  :
//<< Class User.WWW0121 Extends (%Library.Persistent, %XML.Adaptor, %Library.Populate) [ ClassType = persistent, Not ProcedureBlock, StorageStrategy = StorageAtNet ]
public class WWW0121 extends mPersistent {
  //<< {
  //<< 
  //<< Property AddressFormatted As %String(CAPTION = "Formatted Address") [ Calculated, SqlComputeCode = { set {AddressFormatted}=$$GetAddressString^WWW0121RP({Company},{Location},"T")}, SqlComputed ];
  public String AddressFormatted;
  //<< 
  //<< Property AddressString As %String(CAPTION = "AddressString") [ Calculated, SqlComputeCode = { set {AddressString}=$$GetAddressString^WWW0121RP({Company},{Location})}, SqlComputed ];
  public String AddressString;
  //<< 
  //<< /// Administrative Location
  //<< Property AdminLocn As %Boolean(CAPTION = "Administrative Location ");
  public Boolean AdminLocn;
  //<< 
  //<< /// Alternative Location ID
  //<< Property AlternativeLocationID As %String(CAPTION = "Alternative Location ID", MAXLEN = 30);
  public String AlternativeLocationID;
  //<< 
  //<< /// Auto Receipt of Transfer Orders
  //<< Property AutoReceiptTransferOrders As %Boolean(CAPTION = "Auto Receipt of Transfer Orders");
  public Boolean AutoReceiptTransferOrders;
  //<< 
  //<< /// Bill-To Location
  //<< Property BillTo As %String(CAPTION = "Bill-To Location", MAXLEN = 30);
  public String BillTo;
  //<< 
  //<< Property BillToLoc As %String(CAPTION = "BillTo") [ Calculated, SqlComputeCode = { set {BillToLoc}=$$GetBillTo^WWW0121Utils({Location})}, SqlComputed ];
  public String BillToLoc;
  //<< 
  //<< /// Calendar Default
  //<< Property CalendarDefault As %String(CAPTION = "Calendar Default", MAXLEN = 30);
  public String CalendarDefault;
  //<< 
  //<< /// City
  //<< Property City As %String(CAPTION = "City  ", MAXLEN = 30);
  public String City;
  //<< 
  //<< Property CityZip As %String(CAPTION = "City and Zip") [ Calculated, SqlComputeCode = { set {CityZip}={City}_", "_{Zipcode}}, SqlComputed ];
  public String CityZip;
  //<< 
  //<< /// Color Table Header
  //<< Property ColorTableHeader As %String(CAPTION = "Color Table Header", MAXLEN = 30);
  public String ColorTableHeader;
  //<< 
  //<< /// Company
  //<< Property Company As %String(CAPTION = "Company  ", COLLATION = "EXACT", MAXLEN = 30, XMLPROJECTION = "attribute") [ Required ];
  public String Company;
  //<< 
  //<< /// Company Name
  //<< Property CompanyName As %String(CAPTION = "Company Name", MAXLEN = 30);
  public String CompanyName;
  //<< 
  //<< /// Company Name
  //<< Property CompanyName1 As %String(CAPTION = "Company Name", MAXLEN = 30);
  public String CompanyName1;
  //<< 
  //<< /// Country
  //<< Property Country As %String(CAPTION = "Country  ", MAXLEN = 30);
  public String Country;
  //<< 
  //<< /// Customer Return Storage
  //<< Property CustReturnStorage As %String(CAPTION = "Customer Return Storage", MAXLEN = 30);
  public String CustReturnStorage;
  //<< 
  //<< /// Damaged Stock Storage
  //<< Property DamagedStockStorage As %String(CAPTION = "Damaged Stock Storage", MAXLEN = 30);
  public String DamagedStockStorage;
  //<< 
  //<< /// Despatch Storage
  //<< Property DespatchStorage As %String(CAPTION = "Despatch Storage", MAXLEN = 30);
  public String DespatchStorage;
  //<< 
  //<< /// Transfer Location
  //<< Property DistributionLocn As %Boolean(CAPTION = "Transfer Location");
  public Boolean DistributionLocn;
  //<< 
  //<< /// E-mail
  //<< Property Email As %String(CAPTION = "E-mail", MAXLEN = 50);
  public String Email;
  //<< 
  //<< /// Enable Scanning For Operation
  //<< Property EnableScanning As %String(CAPTION = "Enable Scanning For Operation", MAXLEN = 200);
  public String EnableScanning;
  //<< 
  //<< /// Entity
  //<< Property Entity As %String(CAPTION = "Entity", MAXLEN = 30);
  public String Entity;
  //<< 
  //<< /// Erase Quantity On Inter Warehouse Traffic
  //<< Property EraseQuantityOnInterWareh As %Boolean(CAPTION = "Erase Quantity On Inter Warehouse Traffic  ");
  public Boolean EraseQuantityOnInterWareh;
  //<< 
  //<< /// _FREE
  //<< Property FREE1 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE1;
  //<< 
  //<< /// _FREE
  //<< Property FREE10 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE10;
  //<< 
  //<< /// _FREE
  //<< Property FREE11 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE11;
  //<< 
  //<< /// _FREE
  //<< Property FREE12 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE12;
  //<< 
  //<< /// _FREE
  //<< Property FREE13 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE13;
  //<< 
  //<< /// _FREE
  //<< Property FREE14 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE14;
  //<< 
  //<< /// _FREE
  //<< Property FREE15 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE15;
  //<< 
  //<< /// _FREE
  //<< Property FREE16 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE16;
  //<< 
  //<< /// _FREE
  //<< Property FREE17 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE17;
  //<< 
  //<< /// _FREE
  //<< Property FREE18 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE18;
  //<< 
  //<< /// _FREE
  //<< Property FREE19 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE19;
  //<< 
  //<< /// _FREE
  //<< Property FREE2 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE2;
  //<< 
  //<< /// _FREE
  //<< Property FREE20 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE20;
  //<< 
  //<< /// _FREE
  //<< Property FREE3 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE3;
  //<< 
  //<< /// _FREE
  //<< Property FREE4 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE4;
  //<< 
  //<< /// _FREE
  //<< Property FREE5 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE5;
  //<< 
  //<< /// _FREE
  //<< Property FREE6 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE6;
  //<< 
  //<< /// _FREE
  //<< Property FREE7 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE7;
  //<< 
  //<< /// _FREE
  //<< Property FREE8 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE8;
  //<< 
  //<< /// _FREE
  //<< Property FREE9 As %String(CAPTION = "_FREE  ", MAXLEN = 300);
  public String FREE9;
  //<< 
  //<< /// Fix Surcharge
  //<< Property FixSurcharge As %Currency(CAPTION = "Fix Surcharge  ");
  public Double FixSurcharge;
  //<< 
  //<< Property FixSurchargeBASE As %Float(CAPTION = "FixSurchargeBASE") [ Calculated, SqlComputeCode = { set {FixSurchargeBASE}=$$FCBase^COMSYSFC({FixSurcharge})}, SqlComputed ];
  public Double FixSurchargeBASE;
  //<< 
  //<< /// Group Demands By
  //<< Property GroupDemandsBy As %String(CAPTION = "Group Demands By", MAXLEN = 30);
  public String GroupDemandsBy;
  //<< 
  //<< /// Inactive
  //<< Property Inactive1 As %Boolean(CAPTION = "Inactive");
  public Boolean Inactive1;
  //<< 
  //<< /// Location
  //<< Property Location As %String(CAPTION = "Location", COLLATION = "EXACT", MAXLEN = 20, XMLPROJECTION = "attribute") [ Required ];
  public String Location;
  //<< 
  //<< /// Location Name
  //<< Property LocationName As %String(CAPTION = "Location Name  ", MAXLEN = 30);
  public String LocationName;
  //<< 
  //<< /// Location Type
  //<< Property LocationType As %String(CAPTION = "Location Type", MAXLEN = 30) [ Required ];
  public String LocationType;
  //<< 
  //<< /// Manufacturing Return Storage
  //<< Property ManuReturnStorage As %String(CAPTION = "Manufacturing Return Storage", MAXLEN = 30);
  public String ManuReturnStorage;
  //<< 
  //<< /// Missing Stock Storage
  //<< Property MissingStockStorage As %String(CAPTION = "Missing Stock Storage", MAXLEN = 30);
  public String MissingStockStorage;
  //<< 
  //<< /// On Hand Storage
  //<< Property OnHandStorage As %String(CAPTION = "On Hand Storage", MAXLEN = 30);
  public String OnHandStorage;
  //<< 
  //<< /// Only Track Programs
  //<< Property OnlyTrackPrograms As %Boolean(CAPTION = "Only Track Programs");
  public Boolean OnlyTrackPrograms;
  //<< 
  //<< /// Parent Location
  //<< Property ParentLocn As %String(CAPTION = "Parent Location", MAXLEN = 30);
  public String ParentLocn;
  //<< 
  //<< /// Surcharge In %
  //<< Property PercentageSurcharge As %Numeric(CAPTION = "Surcharge In %  ");
  public Double PercentageSurcharge;
  //<< 
  //<< /// Picture
  //<< Property Picture As %String(CAPTION = "Picture  ", MAXLEN = 50);
  public String Picture;
  //<< 
  //<< /// Planning Location
  //<< Property PlanningLocn As %Boolean(CAPTION = "Planning Location");
  public Boolean PlanningLocn;
  //<< 
  //<< /// Posting Characteristic 1
  //<< Property PostingCharacteristic1 As %String(CAPTION = "Posting Characteristic 1 ", MAXLEN = 30);
  public String PostingCharacteristic1;
  //<< 
  //<< /// Posting Characteristic 2
  //<< Property PostingCharacteristic2 As %String(CAPTION = "Posting Characteristic 2 ", MAXLEN = 30);
  public String PostingCharacteristic2;
  //<< 
  //<< /// Pricing Location
  //<< Property PricingLocation As %String(CAPTION = "Pricing Location", MAXLEN = 30);
  public String PricingLocation;
  //<< 
  //<< /// Production Location
  //<< Property ProductionLocn As %Boolean(CAPTION = "Production Location");
  public Boolean ProductionLocn;
  //<< 
  //<< /// Purchase Location
  //<< Property PurchaseLocn As %Boolean(CAPTION = "Purchase Location  ");
  public Boolean PurchaseLocn;
  //<< 
  //<< /// Receipt Storage
  //<< Property ReceiptStorage As %String(CAPTION = "Receipt Storage", MAXLEN = 30);
  public String ReceiptStorage;
  //<< 
  //<< /// Requisition Issue
  //<< Property RequisitionIssue As %Numeric(CAPTION = "Requisition Issue");
  public Double RequisitionIssue;
  //<< 
  //<< /// Responsible
  //<< Property Responsible As %String(CAPTION = "Responsible  ", MAXLEN = 30);
  public String Responsible;
  //<< 
  //<< /// Routing Description
  //<< Property RoutingDescription As %String(CAPTION = "Routing Description  ", MAXLEN = 32000);
  public String RoutingDescription;
  //<< 
  //<< /// Sales Location
  //<< Property SalesLocn As %Boolean(CAPTION = "Sales Location");
  public Boolean SalesLocn;
  //<< 
  //<< /// Ship-To Location
  //<< Property ShipTo As %String(CAPTION = "Ship-To Location", MAXLEN = 30);
  public String ShipTo;
  //<< 
  //<< Property ShipToLoc As %String(CAPTION = "ShipTo") [ Calculated, SqlComputeCode = { set {ShipToLoc}=$$GetShipTo^WWW0121Utils({Location})}, SqlComputed ];
  public String ShipToLoc;
  //<< 
  //<< /// State
  //<< Property State As %String(CAPTION = "State  ", MAXLEN = 30);
  public String State;
  //<< 
  //<< /// Stock Move Possible
  //<< Property StockMovePossible As %Boolean(CAPTION = "Stock Move Possible  ");
  public Boolean StockMovePossible;
  //<< 
  //<< /// Inventory Location
  //<< Property StorageLocn As %Boolean(CAPTION = "Inventory Location  ");
  public Boolean StorageLocn;
  //<< 
  //<< /// Street
  //<< Property Street As %String(CAPTION = "Street", MAXLEN = 30);
  public String Street;
  //<< 
  //<< /// Supplier Return Storage
  //<< Property SuppReturnStorage As %String(CAPTION = "Supplier Return Storage", MAXLEN = 30);
  public String SuppReturnStorage;
  //<< 
  //<< /// Tax Location
  //<< Property TaxLocation As %String(CAPTION = "Tax Location", MAXLEN = 20);
  public String TaxLocation;
  //<< 
  //<< /// Tel.
  //<< Property Tel As %String(CAPTION = "Tel.", MAXLEN = 20);
  public String Tel;
  //<< 
  //<< /// Telefax
  //<< Property Telefax As %String(CAPTION = "Telefax", MAXLEN = 20);
  public String Telefax;
  //<< 
  //<< /// Telephone 2
  //<< Property Telephone2 As %String(CAPTION = "Telephone 2 ", MAXLEN = 30);
  public String Telephone2;
  //<< 
  //<< /// Temporary Storage Locations
  //<< Property TemporaryStorageLocations As %Numeric(CAPTION = "Temporary Storage Locations");
  public Double TemporaryStorageLocations;
  //<< 
  //<< /// Time difference GMT
  //<< Property TimedifferenceGMT As %Float(CAPTION = "Time difference GMT  ");
  public Double TimedifferenceGMT;
  //<< 
  //<< /// URL For XML Transfer
  //<< Property URLForXMLTransfer As %String(CAPTION = "URL For XML Transfer", MAXLEN = 70);
  public String URLForXMLTransfer;
  //<< 
  //<< /// Zipcode
  //<< Property Zipcode As %String(CAPTION = "Zipcode", MAXLEN = 10);
  public String Zipcode;

  //<< 
  //<< Index IDKEY On (Company, Location) [ IdKey, PrimaryKey, Unique ];
  //<< 
  //<< Method %OnBeforeSave(insert As %Boolean) As %Status [ Private, ServerOnly = 1 ]
  public Object $OnBeforeSave(Object ... _p) {
    mVar insert = m$.newVarRef("insert",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< {
    //<< set strClass="WWW0121"
    mVar strClass = m$.var("strClass");
    strClass.set("WWW0121");
    //<< set $piece(idKey,",",1)=i%Company
    m$.pieceVar(m$.var("idKey"),",",1).set(m$.var("i%Company").get());
    //<< set $piece(idKey,",",2)=i%Location
    m$.pieceVar(m$.var("idKey"),",",2).set(m$.var("i%Location").get());
    //<< set $piece(objRec,"~",1)=i%LocationName
    m$.pieceVar(m$.var("objRec"),"~",1).set(m$.var("i%LocationName").get());
    //<< set $piece(objRec,"~",2)=i%CompanyName
    m$.pieceVar(m$.var("objRec"),"~",2).set(m$.var("i%CompanyName").get());
    //<< set $piece(objRec,"~",3)=i%CompanyName1
    m$.pieceVar(m$.var("objRec"),"~",3).set(m$.var("i%CompanyName1").get());
    //<< set $piece(objRec,"~",4)=i%Street
    m$.pieceVar(m$.var("objRec"),"~",4).set(m$.var("i%Street").get());
    //<< set $piece(objRec,"~",5)=i%LocationType
    m$.pieceVar(m$.var("objRec"),"~",5).set(m$.var("i%LocationType").get());
    //<< set $piece(objRec,"~",6)=i%Zipcode
    m$.pieceVar(m$.var("objRec"),"~",6).set(m$.var("i%Zipcode").get());
    //<< set $piece(objRec,"~",7)=i%Inactive1
    m$.pieceVar(m$.var("objRec"),"~",7).set(m$.var("i%Inactive1").get());
    //<< set $piece(objRec,"~",8)=i%City
    m$.pieceVar(m$.var("objRec"),"~",8).set(m$.var("i%City").get());
    //<< set $piece(objRec,"~",10)=i%State
    m$.pieceVar(m$.var("objRec"),"~",10).set(m$.var("i%State").get());
    //<< set $piece(objRec,"~",11)=i%Tel
    m$.pieceVar(m$.var("objRec"),"~",11).set(m$.var("i%Tel").get());
    //<< set $piece(objRec,"~",12)=i%Telefax
    m$.pieceVar(m$.var("objRec"),"~",12).set(m$.var("i%Telefax").get());
    //<< set $piece(objRec,"~",13)=i%Email
    m$.pieceVar(m$.var("objRec"),"~",13).set(m$.var("i%Email").get());
    //<< set $piece(objRec,"~",14)=i%RoutingDescription
    m$.pieceVar(m$.var("objRec"),"~",14).set(m$.var("i%RoutingDescription").get());
    //<< set $piece(objRec,"~",15)=i%Picture
    m$.pieceVar(m$.var("objRec"),"~",15).set(m$.var("i%Picture").get());
    //<< set $piece(objRec,"~",17)=i%Country
    m$.pieceVar(m$.var("objRec"),"~",17).set(m$.var("i%Country").get());
    //<< set $piece(objRec,"~",18)=i%URLForXMLTransfer
    m$.pieceVar(m$.var("objRec"),"~",18).set(m$.var("i%URLForXMLTransfer").get());
    //<< set $piece(objRec,"~",20)=i%ParentLocn
    m$.pieceVar(m$.var("objRec"),"~",20).set(m$.var("i%ParentLocn").get());
    //<< set $piece(objRec,"~",21)=i%ProductionLocn
    m$.pieceVar(m$.var("objRec"),"~",21).set(m$.var("i%ProductionLocn").get());
    //<< set $piece(objRec,"~",22)=i%DistributionLocn
    m$.pieceVar(m$.var("objRec"),"~",22).set(m$.var("i%DistributionLocn").get());
    //<< set $piece(objRec,"~",23)=i%SalesLocn
    m$.pieceVar(m$.var("objRec"),"~",23).set(m$.var("i%SalesLocn").get());
    //<< set $piece(objRec,"~",24)=i%StorageLocn
    m$.pieceVar(m$.var("objRec"),"~",24).set(m$.var("i%StorageLocn").get());
    //<< set $piece(objRec,"~",25)=i%PurchaseLocn
    m$.pieceVar(m$.var("objRec"),"~",25).set(m$.var("i%PurchaseLocn").get());
    //<< set $piece(objRec,"~",26)=i%AdminLocn
    m$.pieceVar(m$.var("objRec"),"~",26).set(m$.var("i%AdminLocn").get());
    //<< set $piece(objRec,"~",27)=i%PlanningLocn
    m$.pieceVar(m$.var("objRec"),"~",27).set(m$.var("i%PlanningLocn").get());
    //<< set $piece(objRec,"~",30)=i%PercentageSurcharge
    m$.pieceVar(m$.var("objRec"),"~",30).set(m$.var("i%PercentageSurcharge").get());
    //<< set $piece(objRec,"~",31)=i%FixSurcharge
    m$.pieceVar(m$.var("objRec"),"~",31).set(m$.var("i%FixSurcharge").get());
    //<< set $piece(objRec,"~",32)=i%EraseQuantityOnInterWareh
    m$.pieceVar(m$.var("objRec"),"~",32).set(m$.var("i%EraseQuantityOnInterWareh").get());
    //<< set $piece(objRec,"~",37)=i%StockMovePossible
    m$.pieceVar(m$.var("objRec"),"~",37).set(m$.var("i%StockMovePossible").get());
    //<< set $piece(objRec,"~",40)=i%OnHandStorage
    m$.pieceVar(m$.var("objRec"),"~",40).set(m$.var("i%OnHandStorage").get());
    //<< set $piece(objRec,"~",41)=i%ReceiptStorage
    m$.pieceVar(m$.var("objRec"),"~",41).set(m$.var("i%ReceiptStorage").get());
    //<< set $piece(objRec,"~",42)=i%DespatchStorage
    m$.pieceVar(m$.var("objRec"),"~",42).set(m$.var("i%DespatchStorage").get());
    //<< set $piece(objRec,"~",43)=i%SuppReturnStorage
    m$.pieceVar(m$.var("objRec"),"~",43).set(m$.var("i%SuppReturnStorage").get());
    //<< set $piece(objRec,"~",44)=i%CustReturnStorage
    m$.pieceVar(m$.var("objRec"),"~",44).set(m$.var("i%CustReturnStorage").get());
    //<< set $piece(objRec,"~",45)=i%MissingStockStorage
    m$.pieceVar(m$.var("objRec"),"~",45).set(m$.var("i%MissingStockStorage").get());
    //<< set $piece(objRec,"~",46)=i%DamagedStockStorage
    m$.pieceVar(m$.var("objRec"),"~",46).set(m$.var("i%DamagedStockStorage").get());
    //<< set $piece(objRec,"~",52)=i%TaxLocation
    m$.pieceVar(m$.var("objRec"),"~",52).set(m$.var("i%TaxLocation").get());
    //<< set $piece(objRec,"~",53)=i%TimedifferenceGMT
    m$.pieceVar(m$.var("objRec"),"~",53).set(m$.var("i%TimedifferenceGMT").get());
    //<< set $piece(objRec,"~",54)=i%CalendarDefault
    m$.pieceVar(m$.var("objRec"),"~",54).set(m$.var("i%CalendarDefault").get());
    //<< set $piece(objRec,"~",55)=i%Responsible
    m$.pieceVar(m$.var("objRec"),"~",55).set(m$.var("i%Responsible").get());
    //<< set $piece(objRec,"~",60)=i%FREE1
    m$.pieceVar(m$.var("objRec"),"~",60).set(m$.var("i%FREE1").get());
    //<< set $piece(objRec,"~",61)=i%FREE2
    m$.pieceVar(m$.var("objRec"),"~",61).set(m$.var("i%FREE2").get());
    //<< set $piece(objRec,"~",62)=i%FREE3
    m$.pieceVar(m$.var("objRec"),"~",62).set(m$.var("i%FREE3").get());
    //<< set $piece(objRec,"~",63)=i%FREE4
    m$.pieceVar(m$.var("objRec"),"~",63).set(m$.var("i%FREE4").get());
    //<< set $piece(objRec,"~",64)=i%FREE5
    m$.pieceVar(m$.var("objRec"),"~",64).set(m$.var("i%FREE5").get());
    //<< set $piece(objRec,"~",65)=i%FREE6
    m$.pieceVar(m$.var("objRec"),"~",65).set(m$.var("i%FREE6").get());
    //<< set $piece(objRec,"~",66)=i%FREE7
    m$.pieceVar(m$.var("objRec"),"~",66).set(m$.var("i%FREE7").get());
    //<< set $piece(objRec,"~",67)=i%FREE8
    m$.pieceVar(m$.var("objRec"),"~",67).set(m$.var("i%FREE8").get());
    //<< set $piece(objRec,"~",68)=i%FREE9
    m$.pieceVar(m$.var("objRec"),"~",68).set(m$.var("i%FREE9").get());
    //<< set $piece(objRec,"~",69)=i%FREE10
    m$.pieceVar(m$.var("objRec"),"~",69).set(m$.var("i%FREE10").get());
    //<< set $piece(objRec,"~",70)=i%PostingCharacteristic1
    m$.pieceVar(m$.var("objRec"),"~",70).set(m$.var("i%PostingCharacteristic1").get());
    //<< set $piece(objRec,"~",71)=i%PostingCharacteristic2
    m$.pieceVar(m$.var("objRec"),"~",71).set(m$.var("i%PostingCharacteristic2").get());
    //<< set $piece(objRec,"~",72)=i%Telephone2
    m$.pieceVar(m$.var("objRec"),"~",72).set(m$.var("i%Telephone2").get());
    //<< set $piece(objRec,"~",75)=i%ColorTableHeader
    m$.pieceVar(m$.var("objRec"),"~",75).set(m$.var("i%ColorTableHeader").get());
    //<< set $piece(objRec,"~",76)=i%AutoReceiptTransferOrders
    m$.pieceVar(m$.var("objRec"),"~",76).set(m$.var("i%AutoReceiptTransferOrders").get());
    //<< set $piece(objRec,"~",77)=i%GroupDemandsBy
    m$.pieceVar(m$.var("objRec"),"~",77).set(m$.var("i%GroupDemandsBy").get());
    //<< set $piece(objRec,"~",78)=i%FREE11
    m$.pieceVar(m$.var("objRec"),"~",78).set(m$.var("i%FREE11").get());
    //<< set $piece(objRec,"~",79)=i%FREE12
    m$.pieceVar(m$.var("objRec"),"~",79).set(m$.var("i%FREE12").get());
    //<< set $piece(objRec,"~",80)=i%FREE13
    m$.pieceVar(m$.var("objRec"),"~",80).set(m$.var("i%FREE13").get());
    //<< set $piece(objRec,"~",81)=i%FREE14
    m$.pieceVar(m$.var("objRec"),"~",81).set(m$.var("i%FREE14").get());
    //<< set $piece(objRec,"~",82)=i%FREE15
    m$.pieceVar(m$.var("objRec"),"~",82).set(m$.var("i%FREE15").get());
    //<< set $piece(objRec,"~",83)=i%FREE16
    m$.pieceVar(m$.var("objRec"),"~",83).set(m$.var("i%FREE16").get());
    //<< set $piece(objRec,"~",84)=i%FREE17
    m$.pieceVar(m$.var("objRec"),"~",84).set(m$.var("i%FREE17").get());
    //<< set $piece(objRec,"~",85)=i%FREE18
    m$.pieceVar(m$.var("objRec"),"~",85).set(m$.var("i%FREE18").get());
    //<< set $piece(objRec,"~",86)=i%FREE19
    m$.pieceVar(m$.var("objRec"),"~",86).set(m$.var("i%FREE19").get());
    //<< set $piece(objRec,"~",87)=i%FREE20
    m$.pieceVar(m$.var("objRec"),"~",87).set(m$.var("i%FREE20").get());
    //<< set $piece(objRec,"~",88)=i%AlternativeLocationID
    m$.pieceVar(m$.var("objRec"),"~",88).set(m$.var("i%AlternativeLocationID").get());
    //<< set $piece(objRec,"~",89)=i%EnableScanning
    m$.pieceVar(m$.var("objRec"),"~",89).set(m$.var("i%EnableScanning").get());
    //<< set $piece(objRec,"~",90)=i%PricingLocation
    m$.pieceVar(m$.var("objRec"),"~",90).set(m$.var("i%PricingLocation").get());
    //<< set $piece(objRec,"~",91)=i%Entity
    m$.pieceVar(m$.var("objRec"),"~",91).set(m$.var("i%Entity").get());
    //<< set $piece(objRec,"~",92)=i%ShipTo
    m$.pieceVar(m$.var("objRec"),"~",92).set(m$.var("i%ShipTo").get());
    //<< set $piece(objRec,"~",93)=i%BillTo
    m$.pieceVar(m$.var("objRec"),"~",93).set(m$.var("i%BillTo").get());
    //<< set $piece(objRec,"~",94)=i%ManuReturnStorage
    m$.pieceVar(m$.var("objRec"),"~",94).set(m$.var("i%ManuReturnStorage").get());
    //<< set $piece(objRec,"~",95)=i%TemporaryStorageLocations
    m$.pieceVar(m$.var("objRec"),"~",95).set(m$.var("i%TemporaryStorageLocations").get());
    //<< set $piece(objRec,"~",96)=i%RequisitionIssue
    m$.pieceVar(m$.var("objRec"),"~",96).set(m$.var("i%RequisitionIssue").get());
    //<< set $piece(objRec,"~",97)=i%OnlyTrackPrograms
    m$.pieceVar(m$.var("objRec"),"~",97).set(m$.var("i%OnlyTrackPrograms").get());
    //<< set sc=$$OnBeforeSave^COMObject(insert,strClass,idKey,.objRec)
    mVar sc = m$.var("sc");
    sc.set(m$.fnc$("COMObject.OnBeforeSave",insert.get(),strClass.get(),m$.var("idKey").get(),m$.var("objRec")));
    //<< set i%LocationName=$piece(objRec,"~",1)
    m$.prop(this,"LocationName").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",1));
    //<< set i%CompanyName=$piece(objRec,"~",2)
    m$.prop(this,"CompanyName").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",2));
    //<< set i%CompanyName1=$piece(objRec,"~",3)
    m$.prop(this,"CompanyName1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",3));
    //<< set i%Street=$piece(objRec,"~",4)
    m$.prop(this,"Street").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",4));
    //<< set i%LocationType=$piece(objRec,"~",5)
    m$.prop(this,"LocationType").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",5));
    //<< set i%Zipcode=$piece(objRec,"~",6)
    m$.prop(this,"Zipcode").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",6));
    //<< set i%Inactive1=$piece(objRec,"~",7)
    m$.prop(this,"Inactive1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",7));
    //<< set i%City=$piece(objRec,"~",8)
    m$.prop(this,"City").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",8));
    //<< set i%State=$piece(objRec,"~",10)
    m$.prop(this,"State").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",10));
    //<< set i%Tel=$piece(objRec,"~",11)
    m$.prop(this,"Tel").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",11));
    //<< set i%Telefax=$piece(objRec,"~",12)
    m$.prop(this,"Telefax").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",12));
    //<< set i%Email=$piece(objRec,"~",13)
    m$.prop(this,"Email").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",13));
    //<< set i%RoutingDescription=$piece(objRec,"~",14)
    m$.prop(this,"RoutingDescription").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",14));
    //<< set i%Picture=$piece(objRec,"~",15)
    m$.prop(this,"Picture").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",15));
    //<< set i%Country=$piece(objRec,"~",17)
    m$.prop(this,"Country").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",17));
    //<< set i%URLForXMLTransfer=$piece(objRec,"~",18)
    m$.prop(this,"URLForXMLTransfer").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",18));
    //<< set i%ParentLocn=$piece(objRec,"~",20)
    m$.prop(this,"ParentLocn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",20));
    //<< set i%ProductionLocn=$piece(objRec,"~",21)
    m$.prop(this,"ProductionLocn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",21));
    //<< set i%DistributionLocn=$piece(objRec,"~",22)
    m$.prop(this,"DistributionLocn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",22));
    //<< set i%SalesLocn=$piece(objRec,"~",23)
    m$.prop(this,"SalesLocn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",23));
    //<< set i%StorageLocn=$piece(objRec,"~",24)
    m$.prop(this,"StorageLocn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",24));
    //<< set i%PurchaseLocn=$piece(objRec,"~",25)
    m$.prop(this,"PurchaseLocn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",25));
    //<< set i%AdminLocn=$piece(objRec,"~",26)
    m$.prop(this,"AdminLocn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",26));
    //<< set i%PlanningLocn=$piece(objRec,"~",27)
    m$.prop(this,"PlanningLocn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",27));
    //<< set i%PercentageSurcharge=$piece(objRec,"~",30)
    m$.prop(this,"PercentageSurcharge").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",30));
    //<< set i%FixSurcharge=$piece(objRec,"~",31)
    m$.prop(this,"FixSurcharge").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",31));
    //<< set i%EraseQuantityOnInterWareh=$piece(objRec,"~",32)
    m$.prop(this,"EraseQuantityOnInterWareh").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",32));
    //<< set i%StockMovePossible=$piece(objRec,"~",37)
    m$.prop(this,"StockMovePossible").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",37));
    //<< set i%OnHandStorage=$piece(objRec,"~",40)
    m$.prop(this,"OnHandStorage").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",40));
    //<< set i%ReceiptStorage=$piece(objRec,"~",41)
    m$.prop(this,"ReceiptStorage").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",41));
    //<< set i%DespatchStorage=$piece(objRec,"~",42)
    m$.prop(this,"DespatchStorage").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",42));
    //<< set i%SuppReturnStorage=$piece(objRec,"~",43)
    m$.prop(this,"SuppReturnStorage").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",43));
    //<< set i%CustReturnStorage=$piece(objRec,"~",44)
    m$.prop(this,"CustReturnStorage").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",44));
    //<< set i%MissingStockStorage=$piece(objRec,"~",45)
    m$.prop(this,"MissingStockStorage").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",45));
    //<< set i%DamagedStockStorage=$piece(objRec,"~",46)
    m$.prop(this,"DamagedStockStorage").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",46));
    //<< set i%TaxLocation=$piece(objRec,"~",52)
    m$.prop(this,"TaxLocation").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",52));
    //<< set i%TimedifferenceGMT=$piece(objRec,"~",53)
    m$.prop(this,"TimedifferenceGMT").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",53));
    //<< set i%CalendarDefault=$piece(objRec,"~",54)
    m$.prop(this,"CalendarDefault").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",54));
    //<< set i%Responsible=$piece(objRec,"~",55)
    m$.prop(this,"Responsible").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",55));
    //<< set i%FREE1=$piece(objRec,"~",60)
    m$.prop(this,"FREE1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",60));
    //<< set i%FREE2=$piece(objRec,"~",61)
    m$.prop(this,"FREE2").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",61));
    //<< set i%FREE3=$piece(objRec,"~",62)
    m$.prop(this,"FREE3").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",62));
    //<< set i%FREE4=$piece(objRec,"~",63)
    m$.prop(this,"FREE4").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",63));
    //<< set i%FREE5=$piece(objRec,"~",64)
    m$.prop(this,"FREE5").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",64));
    //<< set i%FREE6=$piece(objRec,"~",65)
    m$.prop(this,"FREE6").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",65));
    //<< set i%FREE7=$piece(objRec,"~",66)
    m$.prop(this,"FREE7").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",66));
    //<< set i%FREE8=$piece(objRec,"~",67)
    m$.prop(this,"FREE8").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",67));
    //<< set i%FREE9=$piece(objRec,"~",68)
    m$.prop(this,"FREE9").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",68));
    //<< set i%FREE10=$piece(objRec,"~",69)
    m$.prop(this,"FREE10").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",69));
    //<< set i%PostingCharacteristic1=$piece(objRec,"~",70)
    m$.prop(this,"PostingCharacteristic1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",70));
    //<< set i%PostingCharacteristic2=$piece(objRec,"~",71)
    m$.prop(this,"PostingCharacteristic2").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",71));
    //<< set i%Telephone2=$piece(objRec,"~",72)
    m$.prop(this,"Telephone2").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",72));
    //<< set i%ColorTableHeader=$piece(objRec,"~",75)
    m$.prop(this,"ColorTableHeader").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",75));
    //<< set i%AutoReceiptTransferOrders=$piece(objRec,"~",76)
    m$.prop(this,"AutoReceiptTransferOrders").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",76));
    //<< set i%GroupDemandsBy=$piece(objRec,"~",77)
    m$.prop(this,"GroupDemandsBy").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",77));
    //<< set i%FREE11=$piece(objRec,"~",78)
    m$.prop(this,"FREE11").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",78));
    //<< set i%FREE12=$piece(objRec,"~",79)
    m$.prop(this,"FREE12").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",79));
    //<< set i%FREE13=$piece(objRec,"~",80)
    m$.prop(this,"FREE13").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",80));
    //<< set i%FREE14=$piece(objRec,"~",81)
    m$.prop(this,"FREE14").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",81));
    //<< set i%FREE15=$piece(objRec,"~",82)
    m$.prop(this,"FREE15").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",82));
    //<< set i%FREE16=$piece(objRec,"~",83)
    m$.prop(this,"FREE16").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",83));
    //<< set i%FREE17=$piece(objRec,"~",84)
    m$.prop(this,"FREE17").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",84));
    //<< set i%FREE18=$piece(objRec,"~",85)
    m$.prop(this,"FREE18").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",85));
    //<< set i%FREE19=$piece(objRec,"~",86)
    m$.prop(this,"FREE19").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",86));
    //<< set i%FREE20=$piece(objRec,"~",87)
    m$.prop(this,"FREE20").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",87));
    //<< set i%AlternativeLocationID=$piece(objRec,"~",88)
    m$.prop(this,"AlternativeLocationID").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",88));
    //<< set i%EnableScanning=$piece(objRec,"~",89)
    m$.prop(this,"EnableScanning").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",89));
    //<< set i%PricingLocation=$piece(objRec,"~",90)
    m$.prop(this,"PricingLocation").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",90));
    //<< set i%Entity=$piece(objRec,"~",91)
    m$.prop(this,"Entity").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",91));
    //<< set i%ShipTo=$piece(objRec,"~",92)
    m$.prop(this,"ShipTo").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",92));
    //<< set i%BillTo=$piece(objRec,"~",93)
    m$.prop(this,"BillTo").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",93));
    //<< set i%ManuReturnStorage=$piece(objRec,"~",94)
    m$.prop(this,"ManuReturnStorage").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",94));
    //<< set i%TemporaryStorageLocations=$piece(objRec,"~",95)
    m$.prop(this,"TemporaryStorageLocations").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",95));
    //<< set i%RequisitionIssue=$piece(objRec,"~",96)
    m$.prop(this,"RequisitionIssue").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",96));
    //<< set i%OnlyTrackPrograms=$piece(objRec,"~",97)
    m$.prop(this,"OnlyTrackPrograms").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",97));
    //<< Quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< Method AddressFormattedGet() As %String [ CodeMode = expression ]
  public Object AddressFormattedGet() {
    //<< {
    //<< $$GetAddressString^WWW0121RP(..Company,..Location,"T")
    return m$.fnc$("WWW0121RP.GetAddressString",this.Company,this.Location,"T");
  //<< }
  }

  //<< 
  //<< Method AddressStringGet() As %String [ CodeMode = expression ]
  public Object AddressStringGet() {
    //<< {
    //<< $$GetAddressString^WWW0121RP(..Company,..Location)
    return m$.fnc$("WWW0121RP.GetAddressString",this.Company,this.Location);
  //<< }
  }

  //<< 
  //<< Method BillToLocGet() As %String [ CodeMode = expression ]
  public Object BillToLocGet() {
    //<< {
    //<< $$GetBillTo^WWW0121Utils(..Location)
    return m$.fnc$("WWW0121Utils.GetBillTo",this.Location);
  //<< }
  }

  //<< 
  //<< Method CityZipGet() As %String [ CodeMode = expression ]
  public Object CityZipGet() {
    //<< {
    //<< ..City_", "_..Zipcode
    return mOp.Concat(mOp.Concat(this.City,", "),this.Zipcode);
  //<< }
  }

  //<< 
  //<< Method FixSurchargeBASEGet() As %Float [ CodeMode = expression ]
  public Object FixSurchargeBASEGet() {
    //<< {
    //<< $$FCBase^COMSYSFC(..FixSurcharge)
    return m$.fnc$("COMSYSFC.FCBase",this.FixSurcharge);
  //<< }
  }

  //<< 
  //<< Method ShipToLocGet() As %String [ CodeMode = expression ]
  public Object ShipToLocGet() {
    //<< {
    //<< $$GetShipTo^WWW0121Utils(..Location)
    return m$.fnc$("WWW0121Utils.GetShipTo",this.Location);
  //<< }
  }

//<< 
//<< }
}
