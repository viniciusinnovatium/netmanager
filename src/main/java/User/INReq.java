//*****************************************************************************
//** TASC - ALPHALINC - CLASS User.INReq
//** Innovatium Systems - Code Converter - v1.31
//** 2014-07-07 17:54:48
//*****************************************************************************

package User;

import mLibrary.*;

//<< /// Requisition:
//<< Class User.INReq Extends (%Library.Persistent, %XML.Adaptor) [ ClassType = persistent, Not ProcedureBlock, StorageStrategy = StorageAtNet ]
public class INReq extends mPersistent {
  //<< {
  //<< 
  //<< Property ActiveIssueNumber As %String(CAPTION = "Active Issue Number") [ Calculated, SqlComputeCode = { set {ActiveIssueNumber}=$$GetActiveTransfer^VARINReqIssue({ReqNum})}, SqlComputed ];
  public String ActiveIssueNumber;
  //<< 
  //<< /// Allow Variation
  //<< Property AllowVariation As %Boolean(CAPTION = "Allow Variation");
  public Boolean AllowVariation;
  //<< 
  //<< /// Cancelled
  //<< Property Cancelled As %Boolean(CAPTION = "Cancelled");
  public Boolean Cancelled;
  //<< 
  //<< /// Changed By
  //<< Property ChangedBy As %String(CAPTION = "Changed By", MAXLEN = 30);
  public String ChangedBy;
  //<< 
  //<< /// Changed On
  //<< Property ChangedOn As WWW.DiscTimestamp(CAPTION = "Changed On");
  public String ChangedOn;
  //<< 
  //<< /// Close All Lines
  //<< Property CloseAllLines As %Boolean(CAPTION = "Close All Lines");
  public Boolean CloseAllLines;
  //<< 
  //<< /// Collected Date & Time
  //<< Property CollectedDateTime As WWW.DiscTimestamp(CAPTION = "Collected Date & Time");
  public String CollectedDateTime;
  //<< 
  //<< /// Collected by User
  //<< Property CollectedbyUser As %String(CAPTION = "Collected by User", MAXLEN = 30);
  public String CollectedbyUser;
  //<< 
  //<< Property Company As %String(MAXLEN = 30, XMLPROJECTION = "attribute") [ Required ];
  public String Company;
  //<< 
  //<< /// Created By
  //<< Property CreatedBy As %String(CAPTION = "Created By", MAXLEN = 30);
  public String CreatedBy;
  //<< 
  //<< /// Created On
  //<< Property CreatedOn As WWW.DiscTimestamp(CAPTION = "Created On");
  public String CreatedOn;
  //<< 
  //<< /// Current Bed
  //<< Property Currentbed As %String(CAPTION = "Current Bed", MAXLEN = 30);
  public String Currentbed;
  //<< 
  //<< /// Date
  //<< Property Date1 As WWW.DiscDate(CAPTION = "Date") [ Required ];
  public mDiscDate Date1;
  //<< 
  //<< /// Date Cancellation
  //<< Property DateCancellation As WWW.DiscDate(CAPTION = "Date Cancellation");
  public mDiscDate DateCancellation;
  //<< 
  //<< /// Date Rejection
  //<< Property DateRejection As WWW.DiscDate(CAPTION = "Date Rejection");
  public mDiscDate DateRejection;
  //<< 
  //<< /// Doctor
  //<< Property Doctor As %String(CAPTION = "Doctor", MAXLEN = 30);
  public String Doctor;
  //<< 
  //<< /// DueDate
  //<< Property DueDate As WWW.DiscDate(CAPTION = "DueDate");
  public mDiscDate DueDate;
  //<< 
  //<< /// Due Date
  //<< Property DueDate1 As WWW.DiscDate(CAPTION = "Due Date");
  public mDiscDate DueDate1;
  //<< 
  //<< /// Due Time
  //<< Property DueTime As %Time(CAPTION = "Due Time");
  public Double DueTime;
  //<< 
  //<< /// Emergency Purchase Requestion
  //<< Property EmergencyPurchaseRequesti As %Boolean(CAPTION = "Emergency Purchase Requestion");
  public Boolean EmergencyPurchaseRequesti;
  //<< 
  //<< /// Entry Type
  //<< Property EntryType As %String(CAPTION = "Entry Type", MAXLEN = 30);
  public String EntryType;
  //<< 
  //<< /// Episode
  //<< Property Episode As %String(CAPTION = "Episode", MAXLEN = 30);
  public String Episode;
  //<< 
  //<< /// _FREE
  //<< Property FREE10 As %String(CAPTION = "_FREE", MAXLEN = 300);
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
  //<< Property FREE15 As %String(CAPTION = "_FREE", MAXLEN = 300);
  public String FREE15;
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
  //<< Property FromLocn As %String(CAPTION = "From Location", MAXLEN = 30) [ Required ];
  public String FromLocn;
  //<< 
  //<< Property HaveLinesOK As %Boolean(CAPTION = "All lines OK") [ Calculated, SqlComputeCode = { set {HaveLinesOK}=$$GetLineGeneralStatus^VARINReqIssue({ReqNum},1)}, SqlComputed ];
  public Boolean HaveLinesOK;
  //<< 
  //<< Property HaveLinesOutOfStock As %Boolean(CAPTION = "All lines out of stock") [ Calculated, SqlComputeCode = { set {HaveLinesOutOfStock}=$$GetLineGeneralStatus^VARINReqIssue({ReqNum},3)}, SqlComputed ];
  public Boolean HaveLinesOutOfStock;
  //<< 
  //<< Property HaveLinesPartial As %Boolean(CAPTION = "All lines partial") [ Calculated, SqlComputeCode = { set {HaveLinesPartial}=$$GetLineGeneralStatus^VARINReqIssue({ReqNum},2)}, SqlComputed ];
  public Boolean HaveLinesPartial;
  //<< 
  //<< /// Kit Code
  //<< Property KitCode As %String(CAPTION = "Kit Code", MAXLEN = 30);
  public String KitCode;
  //<< 
  //<< Property LinesOK As %Integer(CAPTION = "LinesOK") [ Calculated, SqlComputeCode = { set {LinesOK}=$$GetOutLineForReq^INReqLineStatus({ReqNum},1)}, SqlComputed ];
  public Long LinesOK;
  //<< 
  //<< Property LinesOutOfStock As %Integer(CAPTION = "LinesOutOfStock") [ Calculated, SqlComputeCode = { set {LinesOutOfStock}=$$GetOutLineForReq^INReqLineStatus({ReqNum},3)}, SqlComputed ];
  public Long LinesOutOfStock;
  //<< 
  //<< Property LinesOutstanding As %Integer(CAPTION = "Lines Outstanding") [ Calculated, SqlComputeCode = { set {LinesOutstanding}=$$GetOutLineForReq^INReqLineStatus({ReqNum},0)}, SqlComputed ];
  public Long LinesOutstanding;
  //<< 
  //<< Property LinesPartial As %Integer(CAPTION = "LinesPartial") [ Calculated, SqlComputeCode = { set {LinesPartial}=$$GetOutLineForReq^INReqLineStatus({ReqNum},2)}, SqlComputed ];
  public Long LinesPartial;
  //<< 
  //<< /// Notes
  //<< Property Notes As %String(CAPTION = "Notes", MAXLEN = 32000);
  public String Notes;
  //<< 
  //<< /// Notes
  //<< Property Notes1 As %String(CAPTION = "Notes", MAXLEN = 32000);
  public String Notes1;
  //<< 
  //<< /// Patient ID
  //<< Property PatientID As %String(CAPTION = "Patient ID", MAXLEN = 30);
  public String PatientID;
  //<< 
  //<< /// Patient Name
  //<< Property PatientName As %String(CAPTION = "Patient Name", MAXLEN = 30);
  public String PatientName;
  //<< 
  //<< /// Payment Terms
  //<< Property PayTerms As %String(CAPTION = "Payment Terms", MAXLEN = 30);
  public String PayTerms;
  //<< 
  //<< /// Priority
  //<< Property Priority As %Numeric(CAPTION = "Priority");
  public Double Priority;
  //<< 
  //<< /// Process Date
  //<< Property ProcessDate As WWW.DiscTimestamp(CAPTION = "Process Date");
  public String ProcessDate;
  //<< 
  //<< /// Process Number
  //<< Property ProcessNumber As %String(CAPTION = "Process Number", MAXLEN = 30);
  public String ProcessNumber;
  //<< 
  //<< /// Program
  //<< Property Program1 As %String(CAPTION = "Program", MAXLEN = 30);
  public String Program1;
  //<< 
  //<< /// Reason Cancellation
  //<< Property ReasonCancellation As %String(CAPTION = "Reason Cancellation", MAXLEN = 32000);
  public String ReasonCancellation;
  //<< 
  //<< /// Reason Rejection
  //<< Property ReasonRejection As %String(CAPTION = "Reason Rejection", MAXLEN = 32000);
  public String ReasonRejection;
  //<< 
  //<< /// Receive Date
  //<< Property ReceiveDate As WWW.DiscTimestamp(CAPTION = "Receive Date");
  public String ReceiveDate;
  //<< 
  //<< /// Reference
  //<< Property Reference As %String(CAPTION = "Reference", MAXLEN = 30);
  public String Reference;
  //<< 
  //<< /// Rejected
  //<< Property Rejected As %Boolean(CAPTION = "Rejected");
  public Boolean Rejected;
  //<< 
  //<< /// Number
  //<< Property ReqNum As %String(CAPTION = "Number", COLLATION = "EXACT", XMLPROJECTION = "attribute") [ Required ];
  public String ReqNum;
  //<< 
  //<< /// Requesting Department
  //<< Property RequestingDepartment As %String(CAPTION = "Requesting Department", MAXLEN = 30);
  public String RequestingDepartment;
  //<< 
  //<< /// Sector
  //<< Property Sector As %String(CAPTION = "Sector", MAXLEN = 30);
  public String Sector;
  //<< 
  //<< /// Ship To
  //<< Property ShipTo As %String(CAPTION = "Ship To", MAXLEN = 30);
  public String ShipTo;
  //<< 
  //<< /// Status
  //<< Property Status As %String(CAPTION = "Status", MAXLEN = 30);
  public String Status;
  //<< 
  //<< /// Supplier Name
  //<< Property SupName As %String(CAPTION = "Supplier Name", MAXLEN = 30);
  public String SupName;
  //<< 
  //<< /// Supplier
  //<< Property Supplier As %String(CAPTION = "Supplier", MAXLEN = 30);
  public String Supplier;
  //<< 
  //<< /// Surgery Room
  //<< Property SurgeryRoom As %String(CAPTION = "Surgery Room", MAXLEN = 30);
  public String SurgeryRoom;
  //<< 
  //<< /// ToLocn
  //<< Property ToLocn As %String(CAPTION = "ToLocn", MAXLEN = 30);
  public String ToLocn;
  //<< 
  //<< /// Transportation Method
  //<< Property Transport As %String(CAPTION = "Transportation Method", MAXLEN = 30);
  public String Transport;
  //<< 
  //<< /// Type
  //<< Property Type As %String(CAPTION = "Type", MAXLEN = 30);
  public String Type;

  //<< 
  //<< Index IDKEY On (Company, ReqNum) [ IdKey, PrimaryKey, Unique ];
  //<< 
  //<< Method %OnBeforeSave(insert As %Boolean) As %Status [ Private, ServerOnly = 1 ]
  public Object $OnBeforeSave(Object ... _p) {
    mVar insert = m$.newVarRef("insert",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< {
    //<< set strClass="INReq"
    mVar strClass = m$.var("strClass");
    strClass.set("INReq");
    //<< set $piece(idKey,",",1)=i%ReqNum
    m$.pieceVar(m$.var("idKey"),",",1).set(m$.var("i%ReqNum").get());
    //<< set $piece(objRec,"~",1)=i%Status
    m$.pieceVar(m$.var("objRec"),"~",1).set(m$.var("i%Status").get());
    //<< set $piece(objRec,"~",2)=i%Date1
    m$.pieceVar(m$.var("objRec"),"~",2).set(m$.var("i%Date1").get());
    //<< set $piece(objRec,"~",3)=i%ToLocn
    m$.pieceVar(m$.var("objRec"),"~",3).set(m$.var("i%ToLocn").get());
    //<< set $piece(objRec,"~",4)=i%FromLocn
    m$.pieceVar(m$.var("objRec"),"~",4).set(m$.var("i%FromLocn").get());
    //<< set $piece(objRec,"~",5)=i%DueDate
    m$.pieceVar(m$.var("objRec"),"~",5).set(m$.var("i%DueDate").get());
    //<< set $piece(objRec,"~",6)=i%Priority
    m$.pieceVar(m$.var("objRec"),"~",6).set(m$.var("i%Priority").get());
    //<< set $piece(objRec,"~",7)=i%Type
    m$.pieceVar(m$.var("objRec"),"~",7).set(m$.var("i%Type").get());
    //<< set $piece(objRec,"~",8)=i%ProcessDate
    m$.pieceVar(m$.var("objRec"),"~",8).set(m$.var("i%ProcessDate").get());
    //<< set $piece(objRec,"~",9)=i%ReceiveDate
    m$.pieceVar(m$.var("objRec"),"~",9).set(m$.var("i%ReceiveDate").get());
    //<< set $piece(objRec,"~",10)=i%Supplier
    m$.pieceVar(m$.var("objRec"),"~",10).set(m$.var("i%Supplier").get());
    //<< set $piece(objRec,"~",11)=i%SupName
    m$.pieceVar(m$.var("objRec"),"~",11).set(m$.var("i%SupName").get());
    //<< set $piece(objRec,"~",12)=i%PayTerms
    m$.pieceVar(m$.var("objRec"),"~",12).set(m$.var("i%PayTerms").get());
    //<< set $piece(objRec,"~",13)=i%Transport
    m$.pieceVar(m$.var("objRec"),"~",13).set(m$.var("i%Transport").get());
    //<< set $piece(objRec,"~",14)=i%FREE5
    m$.pieceVar(m$.var("objRec"),"~",14).set(m$.var("i%FREE5").get());
    //<< set $piece(objRec,"~",15)=i%FREE6
    m$.pieceVar(m$.var("objRec"),"~",15).set(m$.var("i%FREE6").get());
    //<< set $piece(objRec,"~",16)=i%FREE7
    m$.pieceVar(m$.var("objRec"),"~",16).set(m$.var("i%FREE7").get());
    //<< set $piece(objRec,"~",17)=i%FREE8
    m$.pieceVar(m$.var("objRec"),"~",17).set(m$.var("i%FREE8").get());
    //<< set $piece(objRec,"~",18)=i%FREE9
    m$.pieceVar(m$.var("objRec"),"~",18).set(m$.var("i%FREE9").get());
    //<< set $piece(objRec,"~",19)=i%FREE10
    m$.pieceVar(m$.var("objRec"),"~",19).set(m$.var("i%FREE10").get());
    //<< set $piece(objRec,"~",20)=i%CreatedOn
    m$.pieceVar(m$.var("objRec"),"~",20).set(m$.var("i%CreatedOn").get());
    //<< set $piece(objRec,"~",21)=i%CreatedBy
    m$.pieceVar(m$.var("objRec"),"~",21).set(m$.var("i%CreatedBy").get());
    //<< set $piece(objRec,"~",22)=i%ChangedOn
    m$.pieceVar(m$.var("objRec"),"~",22).set(m$.var("i%ChangedOn").get());
    //<< set $piece(objRec,"~",23)=i%ChangedBy
    m$.pieceVar(m$.var("objRec"),"~",23).set(m$.var("i%ChangedBy").get());
    //<< set $piece(objRec,"~",24)=i%Reference
    m$.pieceVar(m$.var("objRec"),"~",24).set(m$.var("i%Reference").get());
    //<< set $piece(objRec,"~",25)=i%Notes
    m$.pieceVar(m$.var("objRec"),"~",25).set(m$.var("i%Notes").get());
    //<< set $piece(objRec,"~",26)=i%Cancelled
    m$.pieceVar(m$.var("objRec"),"~",26).set(m$.var("i%Cancelled").get());
    //<< set $piece(objRec,"~",27)=i%Rejected
    m$.pieceVar(m$.var("objRec"),"~",27).set(m$.var("i%Rejected").get());
    //<< set $piece(objRec,"~",28)=i%ReasonCancellation
    m$.pieceVar(m$.var("objRec"),"~",28).set(m$.var("i%ReasonCancellation").get());
    //<< set $piece(objRec,"~",29)=i%ReasonRejection
    m$.pieceVar(m$.var("objRec"),"~",29).set(m$.var("i%ReasonRejection").get());
    //<< set $piece(objRec,"~",30)=i%DateCancellation
    m$.pieceVar(m$.var("objRec"),"~",30).set(m$.var("i%DateCancellation").get());
    //<< set $piece(objRec,"~",31)=i%DateRejection
    m$.pieceVar(m$.var("objRec"),"~",31).set(m$.var("i%DateRejection").get());
    //<< set $piece(objRec,"~",32)=i%EmergencyPurchaseRequesti
    m$.pieceVar(m$.var("objRec"),"~",32).set(m$.var("i%EmergencyPurchaseRequesti").get());
    //<< set $piece(objRec,"~",33)=i%EntryType
    m$.pieceVar(m$.var("objRec"),"~",33).set(m$.var("i%EntryType").get());
    //<< set $piece(objRec,"~",34)=i%RequestingDepartment
    m$.pieceVar(m$.var("objRec"),"~",34).set(m$.var("i%RequestingDepartment").get());
    //<< set $piece(objRec,"~",35)=i%Sector
    m$.pieceVar(m$.var("objRec"),"~",35).set(m$.var("i%Sector").get());
    //<< set $piece(objRec,"~",36)=i%Notes1
    m$.pieceVar(m$.var("objRec"),"~",36).set(m$.var("i%Notes1").get());
    //<< set $piece(objRec,"~",37)=i%ProcessNumber
    m$.pieceVar(m$.var("objRec"),"~",37).set(m$.var("i%ProcessNumber").get());
    //<< set $piece(objRec,"~",38)=i%KitCode
    m$.pieceVar(m$.var("objRec"),"~",38).set(m$.var("i%KitCode").get());
    //<< set $piece(objRec,"~",39)=i%PatientID
    m$.pieceVar(m$.var("objRec"),"~",39).set(m$.var("i%PatientID").get());
    //<< set $piece(objRec,"~",40)=i%SurgeryRoom
    m$.pieceVar(m$.var("objRec"),"~",40).set(m$.var("i%SurgeryRoom").get());
    //<< set $piece(objRec,"~",41)=i%Episode
    m$.pieceVar(m$.var("objRec"),"~",41).set(m$.var("i%Episode").get());
    //<< set $piece(objRec,"~",42)=i%Doctor
    m$.pieceVar(m$.var("objRec"),"~",42).set(m$.var("i%Doctor").get());
    //<< set $piece(objRec,"~",43)=i%Currentbed
    m$.pieceVar(m$.var("objRec"),"~",43).set(m$.var("i%Currentbed").get());
    //<< set $piece(objRec,"~",44)=i%PatientName
    m$.pieceVar(m$.var("objRec"),"~",44).set(m$.var("i%PatientName").get());
    //<< set $piece(objRec,"~",45)=i%DueDate1
    m$.pieceVar(m$.var("objRec"),"~",45).set(m$.var("i%DueDate1").get());
    //<< set $piece(objRec,"~",46)=i%DueTime
    m$.pieceVar(m$.var("objRec"),"~",46).set(m$.var("i%DueTime").get());
    //<< set $piece(objRec,"~",47)=i%CollectedbyUser
    m$.pieceVar(m$.var("objRec"),"~",47).set(m$.var("i%CollectedbyUser").get());
    //<< set $piece(objRec,"~",48)=i%CollectedDateTime
    m$.pieceVar(m$.var("objRec"),"~",48).set(m$.var("i%CollectedDateTime").get());
    //<< set $piece(objRec,"~",49)=i%FREE11
    m$.pieceVar(m$.var("objRec"),"~",49).set(m$.var("i%FREE11").get());
    //<< set $piece(objRec,"~",50)=i%FREE12
    m$.pieceVar(m$.var("objRec"),"~",50).set(m$.var("i%FREE12").get());
    //<< set $piece(objRec,"~",51)=i%FREE13
    m$.pieceVar(m$.var("objRec"),"~",51).set(m$.var("i%FREE13").get());
    //<< set $piece(objRec,"~",52)=i%FREE14
    m$.pieceVar(m$.var("objRec"),"~",52).set(m$.var("i%FREE14").get());
    //<< set $piece(objRec,"~",53)=i%FREE15
    m$.pieceVar(m$.var("objRec"),"~",53).set(m$.var("i%FREE15").get());
    //<< set $piece(objRec,"~",54)=i%Program1
    m$.pieceVar(m$.var("objRec"),"~",54).set(m$.var("i%Program1").get());
    //<< set $piece(objRec,"~",55)=i%AllowVariation
    m$.pieceVar(m$.var("objRec"),"~",55).set(m$.var("i%AllowVariation").get());
    //<< set $piece(objRec,"~",56)=i%CloseAllLines
    m$.pieceVar(m$.var("objRec"),"~",56).set(m$.var("i%CloseAllLines").get());
    //<< set $piece(objRec,"~",57)=i%ShipTo
    m$.pieceVar(m$.var("objRec"),"~",57).set(m$.var("i%ShipTo").get());
    //<< set sc=$$OnBeforeSave^COMObject(insert,strClass,idKey,.objRec)
    mVar sc = m$.var("sc");
    sc.set(m$.fnc$("COMObject.OnBeforeSave",insert.get(),strClass.get(),m$.var("idKey").get(),m$.var("objRec")));
    //<< set i%Status=$piece(objRec,"~",1)
    m$.prop(this,"Status").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",1));
    //<< set i%Date1=$piece(objRec,"~",2)
    m$.prop(this,"Date1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",2));
    //<< set i%ToLocn=$piece(objRec,"~",3)
    m$.prop(this,"ToLocn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",3));
    //<< set i%FromLocn=$piece(objRec,"~",4)
    m$.prop(this,"FromLocn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",4));
    //<< set i%DueDate=$piece(objRec,"~",5)
    m$.prop(this,"DueDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",5));
    //<< set i%Priority=$piece(objRec,"~",6)
    m$.prop(this,"Priority").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",6));
    //<< set i%Type=$piece(objRec,"~",7)
    m$.prop(this,"Type").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",7));
    //<< set i%ProcessDate=$piece(objRec,"~",8)
    m$.prop(this,"ProcessDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",8));
    //<< set i%ReceiveDate=$piece(objRec,"~",9)
    m$.prop(this,"ReceiveDate").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",9));
    //<< set i%Supplier=$piece(objRec,"~",10)
    m$.prop(this,"Supplier").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",10));
    //<< set i%SupName=$piece(objRec,"~",11)
    m$.prop(this,"SupName").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",11));
    //<< set i%PayTerms=$piece(objRec,"~",12)
    m$.prop(this,"PayTerms").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",12));
    //<< set i%Transport=$piece(objRec,"~",13)
    m$.prop(this,"Transport").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",13));
    //<< set i%FREE5=$piece(objRec,"~",14)
    m$.prop(this,"FREE5").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",14));
    //<< set i%FREE6=$piece(objRec,"~",15)
    m$.prop(this,"FREE6").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",15));
    //<< set i%FREE7=$piece(objRec,"~",16)
    m$.prop(this,"FREE7").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",16));
    //<< set i%FREE8=$piece(objRec,"~",17)
    m$.prop(this,"FREE8").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",17));
    //<< set i%FREE9=$piece(objRec,"~",18)
    m$.prop(this,"FREE9").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",18));
    //<< set i%FREE10=$piece(objRec,"~",19)
    m$.prop(this,"FREE10").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",19));
    //<< set i%CreatedOn=$piece(objRec,"~",20)
    m$.prop(this,"CreatedOn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",20));
    //<< set i%CreatedBy=$piece(objRec,"~",21)
    m$.prop(this,"CreatedBy").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",21));
    //<< set i%ChangedOn=$piece(objRec,"~",22)
    m$.prop(this,"ChangedOn").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",22));
    //<< set i%ChangedBy=$piece(objRec,"~",23)
    m$.prop(this,"ChangedBy").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",23));
    //<< set i%Reference=$piece(objRec,"~",24)
    m$.prop(this,"Reference").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",24));
    //<< set i%Notes=$piece(objRec,"~",25)
    m$.prop(this,"Notes").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",25));
    //<< set i%Cancelled=$piece(objRec,"~",26)
    m$.prop(this,"Cancelled").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",26));
    //<< set i%Rejected=$piece(objRec,"~",27)
    m$.prop(this,"Rejected").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",27));
    //<< set i%ReasonCancellation=$piece(objRec,"~",28)
    m$.prop(this,"ReasonCancellation").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",28));
    //<< set i%ReasonRejection=$piece(objRec,"~",29)
    m$.prop(this,"ReasonRejection").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",29));
    //<< set i%DateCancellation=$piece(objRec,"~",30)
    m$.prop(this,"DateCancellation").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",30));
    //<< set i%DateRejection=$piece(objRec,"~",31)
    m$.prop(this,"DateRejection").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",31));
    //<< set i%EmergencyPurchaseRequesti=$piece(objRec,"~",32)
    m$.prop(this,"EmergencyPurchaseRequesti").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",32));
    //<< set i%EntryType=$piece(objRec,"~",33)
    m$.prop(this,"EntryType").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",33));
    //<< set i%RequestingDepartment=$piece(objRec,"~",34)
    m$.prop(this,"RequestingDepartment").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",34));
    //<< set i%Sector=$piece(objRec,"~",35)
    m$.prop(this,"Sector").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",35));
    //<< set i%Notes1=$piece(objRec,"~",36)
    m$.prop(this,"Notes1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",36));
    //<< set i%ProcessNumber=$piece(objRec,"~",37)
    m$.prop(this,"ProcessNumber").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",37));
    //<< set i%KitCode=$piece(objRec,"~",38)
    m$.prop(this,"KitCode").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",38));
    //<< set i%PatientID=$piece(objRec,"~",39)
    m$.prop(this,"PatientID").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",39));
    //<< set i%SurgeryRoom=$piece(objRec,"~",40)
    m$.prop(this,"SurgeryRoom").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",40));
    //<< set i%Episode=$piece(objRec,"~",41)
    m$.prop(this,"Episode").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",41));
    //<< set i%Doctor=$piece(objRec,"~",42)
    m$.prop(this,"Doctor").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",42));
    //<< set i%Currentbed=$piece(objRec,"~",43)
    m$.prop(this,"Currentbed").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",43));
    //<< set i%PatientName=$piece(objRec,"~",44)
    m$.prop(this,"PatientName").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",44));
    //<< set i%DueDate1=$piece(objRec,"~",45)
    m$.prop(this,"DueDate1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",45));
    //<< set i%DueTime=$piece(objRec,"~",46)
    m$.prop(this,"DueTime").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",46));
    //<< set i%CollectedbyUser=$piece(objRec,"~",47)
    m$.prop(this,"CollectedbyUser").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",47));
    //<< set i%CollectedDateTime=$piece(objRec,"~",48)
    m$.prop(this,"CollectedDateTime").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",48));
    //<< set i%FREE11=$piece(objRec,"~",49)
    m$.prop(this,"FREE11").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",49));
    //<< set i%FREE12=$piece(objRec,"~",50)
    m$.prop(this,"FREE12").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",50));
    //<< set i%FREE13=$piece(objRec,"~",51)
    m$.prop(this,"FREE13").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",51));
    //<< set i%FREE14=$piece(objRec,"~",52)
    m$.prop(this,"FREE14").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",52));
    //<< set i%FREE15=$piece(objRec,"~",53)
    m$.prop(this,"FREE15").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",53));
    //<< set i%Program1=$piece(objRec,"~",54)
    m$.prop(this,"Program1").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",54));
    //<< set i%AllowVariation=$piece(objRec,"~",55)
    m$.prop(this,"AllowVariation").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",55));
    //<< set i%CloseAllLines=$piece(objRec,"~",56)
    m$.prop(this,"CloseAllLines").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",56));
    //<< set i%ShipTo=$piece(objRec,"~",57)
    m$.prop(this,"ShipTo").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",57));
    //<< Quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< Method ActiveIssueNumberGet() As %String [ CodeMode = expression ]
  public Object ActiveIssueNumberGet() {
    //<< {
    //<< $$GetActiveTransfer^VARINReqIssue(..ReqNum)
    return m$.fnc$("VARINReqIssue.GetActiveTransfer",this.ReqNum);
  //<< }
  }

  //<< 
  //<< Method HaveLinesOKGet() As %Boolean [ CodeMode = expression ]
  public Object HaveLinesOKGet() {
    //<< {
    //<< $$GetLineGeneralStatus^VARINReqIssue(..ReqNum,1)
    return m$.fnc$("VARINReqIssue.GetLineGeneralStatus",this.ReqNum,1);
  //<< }
  }

  //<< 
  //<< Method HaveLinesOutOfStockGet() As %Boolean [ CodeMode = expression ]
  public Object HaveLinesOutOfStockGet() {
    //<< {
    //<< $$GetLineGeneralStatus^VARINReqIssue(..ReqNum,3)
    return m$.fnc$("VARINReqIssue.GetLineGeneralStatus",this.ReqNum,3);
  //<< }
  }

  //<< 
  //<< Method HaveLinesPartialGet() As %Boolean [ CodeMode = expression ]
  public Object HaveLinesPartialGet() {
    //<< {
    //<< $$GetLineGeneralStatus^VARINReqIssue(..ReqNum,2)
    return m$.fnc$("VARINReqIssue.GetLineGeneralStatus",this.ReqNum,2);
  //<< }
  }

  //<< 
  //<< Method LinesOKGet() As %Integer [ CodeMode = expression ]
  public Object LinesOKGet() {
    //<< {
    //<< $$GetOutLineForReq^INReqLineStatus(..ReqNum,1)
    return m$.fnc$("INReqLineStatus.GetOutLineForReq",this.ReqNum,1);
  //<< }
  }

  //<< 
  //<< Method LinesOutOfStockGet() As %Integer [ CodeMode = expression ]
  public Object LinesOutOfStockGet() {
    //<< {
    //<< $$GetOutLineForReq^INReqLineStatus(..ReqNum,3)
    return m$.fnc$("INReqLineStatus.GetOutLineForReq",this.ReqNum,3);
  //<< }
  }

  //<< 
  //<< Method LinesOutstandingGet() As %Integer [ CodeMode = expression ]
  public Object LinesOutstandingGet() {
    //<< {
    //<< $$GetOutLineForReq^INReqLineStatus(..ReqNum,0)
    return m$.fnc$("INReqLineStatus.GetOutLineForReq",this.ReqNum,0);
  //<< }
  }

  //<< 
  //<< Method LinesPartialGet() As %Integer [ CodeMode = expression ]
  public Object LinesPartialGet() {
    //<< {
    //<< $$GetOutLineForReq^INReqLineStatus(..ReqNum,2)
    return m$.fnc$("INReqLineStatus.GetOutLineForReq",this.ReqNum,2);
  //<< }
  }

//<< 
//<< }
}
