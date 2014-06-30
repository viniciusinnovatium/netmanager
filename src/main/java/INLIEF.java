//*****************************************************************************
//** TASC - ALPHALINC - MAC INLIEF
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 18:27:20
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
//<< #include WWWConst
import include.WWWConst;
//<< #include INSupStatus
import include.INSupStatus;
import include.INConst;
//<< #include INConst
import include.INConst;
//<< #include COMConst
import include.COMConst;
//<< #include COMSYSDate
import include.COMSYSDate;

//<< INLIEF
public class INLIEF extends mClass {

  //<< 
  //<< #define SecondsInDay 86400
  public static Object $$$SecondsInDay(mContext m$) {
    return (86400);
  }

  //<< #define MonthsInYear 12
  public static Object $$$MonthsInYear(mContext m$) {
    return (12);
  }

  public void main() {
    _INLIEF();
  }

  public void _INLIEF() {
  }

  //<< 
  //<< OnBlur(YLFN,YFELD,YKEY)
  public Object OnBlur(Object ... _p) {
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Whether supplier can be used at this time.
    //<< ;
    //<< ; Params:   YLFN    :Field Number
    //<< ;           YFELD   :Data record
    //<< ;           YKE     :Id of the record (not currently used)
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 09-Sep-2007   shobby  SRBR014396: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if (YLFN=$$$FldINLIEFName1) {
    if ((mOp.Equal(YLFN.get(),include.INConst.$$$FldINLIEFName1(m$)))) {
      //<< if $$$INLIEFShortName(YFELD)="" {
      if (mOp.Equal(include.INConst.$$$INLIEFShortName(m$,YFELD),"")) {
        //<< SET %TXT(1) = $get(%TXT(1))_"#Y"_YFORM_"D"_$$$FldINLIEFShortName_"~"_$$$INLIEFName1(YFELD)    ;Date
        m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("%TXT",1)),"#Y"),m$.var("YFORM").get()),"D"),include.INConst.$$$FldINLIEFShortName(m$)),"~"),include.INConst.$$$INLIEFName1(m$,YFELD)));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< IsUsable(pidSupplier,pidForm)
  public Object IsUsable(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Whether supplier can be used at this time.
    //<< ;
    //<< ; Params:   pidSupplier
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 03-May-2013   SCR     CORE-97: Add Validation to VAR code
    //<< ; 22-Oct-2010   shobby  SR17540: Ignore invalid supplier id.
    //<< ; 23-Feb-2007   JW      SR15453: Inactive Date -> Status
    //<< ; 15-Aug-2005   JW      SR12290: Created (copied from FINAPSupplier)
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,idStatus,intField,strPre,objINLIEF
    mVar strStatus = m$.var("strStatus");
    mVar idStatus = m$.var("idStatus");
    mVar intField = m$.var("intField");
    mVar strPre = m$.var("strPre");
    mVar objINLIEF = m$.var("objINLIEF");
    m$.newVar(strStatus,idStatus,intField,strPre,objINLIEF);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< ;if ($get(pidSupplier)'="") && ($extract(pidForm,1,2) = "IN") {
    //<< if ($get(pidSupplier)'="") {  ; HEVA-97
    if ((mOp.NotEqual(m$.Fnc.$get(pidSupplier),""))) {
      //<< set objINLIEF = $get(^INLIEF(YM,pidSupplier,1))               ;SR17540
      objINLIEF.set(m$.Fnc.$get(m$.var("^INLIEF",m$.var("YM").get(),pidSupplier.get(),1)));
      //<< if objINLIEF'="" {
      if (mOp.NotEqual(objINLIEF.get(),"")) {
        //<< set idStatus = $$$INLIEFStatus(objINLIEF)
        idStatus.set(include.INConst.$$$INLIEFStatus(m$,objINLIEF));
        //<< if idStatus="" {
        if (mOp.Equal(idStatus.get(),"")) {
          //<< set strStatus = $$$AppError("P0060000014")      // "Mandatory field should not be blank."
          strStatus.set(include.COMSYS.$$$AppError(m$,"P0060000014"));
        }
        //<< 
        //<< } else {
        else {
          //<< set strPre = $extract(pidForm,3,5)
          strPre.set(m$.Fnc.$extract(pidForm.get(),3,5));
          //<< ; $$$FldINSupStatusReceiveGoods DEPRECATED - with removal of INWEAUF*/INWEFREI - check INRECSummary w/out ON/OL? SR16361
          //<< set intField = $select( strPre = "ART"                  : $$$FldINSupStatusItemConditions,
          //<< ;   pidForm="INAUFNEU"              : $$$FldINSupStatusPurchaseOrders,
          //<< strPre = "AUF"                  : $$$FldINSupStatusPurchaseOrders,
          //<< strPre = "Pur"                  : $$$FldINSupStatusPurchaseOrders,
          //<< strPre = "DRP"                  : $$$FldINSupStatusDRPOrders,
          //<< pidForm [ "Agree"               : $$$FldINSupStatusSourceReqs,
          //<< strPre = "Req"                  : $$$FldINSupStatusSourceReqs,
          //<< pidForm = "INWEFREI"            : $$$FldINSupStatusReceiveGoods,
          //<< $extract(pidForm,3,7)="ERECH"   : $$$FldINSupStatusInvoices,
          //<< pidForm = "INReceipt"           : $$$FldINSupStatusReceiveGoods,
          //<< pidForm = "VARCompra"           : $$$FldINSupStatusPurchaseOrders,
          //<< pidForm = "VARAta"              : $$$FldINSupStatusSourceReqs,
          //<< 1                               :$$$FldINSupStatusOther) ; CORE-97
          intField.set(m$.Fnc.$select(mOp.Equal(strPre.get(),"ART"),include.INConst.$$$FldINSupStatusItemConditions(m$),mOp.Equal(strPre.get(),"AUF"),include.INConst.$$$FldINSupStatusPurchaseOrders(m$),mOp.Equal(strPre.get(),"Pur"),include.INConst.$$$FldINSupStatusPurchaseOrders(m$),mOp.Equal(strPre.get(),"DRP"),include.INConst.$$$FldINSupStatusDRPOrders(m$),mOp.Contains(pidForm.get(),"Agree"),include.INConst.$$$FldINSupStatusSourceReqs(m$),mOp.Equal(strPre.get(),"Req"),include.INConst.$$$FldINSupStatusSourceReqs(m$),mOp.Equal(pidForm.get(),"INWEFREI"),include.INConst.$$$FldINSupStatusReceiveGoods(m$),mOp.Equal(m$.Fnc.$extract(pidForm.get(),3,7),"ERECH"),include.INConst.$$$FldINSupStatusInvoices(m$),mOp.Equal(pidForm.get(),"INReceipt"),include.INConst.$$$FldINSupStatusReceiveGoods(m$),mOp.Equal(pidForm.get(),"VARCompra"),include.INConst.$$$FldINSupStatusPurchaseOrders(m$),mOp.Equal(pidForm.get(),"VARAta"),include.INConst.$$$FldINSupStatusSourceReqs(m$),1,include.INConst.$$$FldINSupStatusOther(m$)));
          //<< set strStatus = $$$HasPermission(pidSupplier,idStatus,intField)
          strStatus.set(include.INSupStatus.$$$HasPermission(m$,pidSupplier,idStatus,intField));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< CanReceive(pidSupplier)
  public Object CanReceive(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Can we receive goods for this supplier?
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 23-Feb-2007   JW      SR15453: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,idStatus
    mVar strStatus = m$.var("strStatus");
    mVar idStatus = m$.var("idStatus");
    m$.newVar(strStatus,idStatus);
    //<< 
    //<< set idStatus  = $$$INLIEFStatus($get(^INLIEF(YM,pidSupplier,1)))
    idStatus.set(include.INConst.$$$INLIEFStatus(m$,m$.Fnc.$get(m$.var("^INLIEF",m$.var("YM").get(),pidSupplier.get(),1))));
    //<< set strStatus = $$$HasPermission(pidSupplier,idStatus,$$$FldINSupStatusReceiveGoods)
    strStatus.set(include.INSupStatus.$$$HasPermission(m$,pidSupplier,idStatus,include.INConst.$$$FldINSupStatusReceiveGoods(m$)));
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< CanDRPOrder(pidSupplier)
  public Object CanDRPOrder(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Can DRP create an order for this supplier?
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:  boolean
    //<< ;
    //<< ; History:
    //<< ; 26-Feb-2007   JW      SR15453: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,idStatus
    mVar strStatus = m$.var("strStatus");
    mVar idStatus = m$.var("idStatus");
    m$.newVar(strStatus,idStatus);
    //<< 
    //<< set idStatus  = $$$INLIEFStatus($get(^INLIEF(YM,pidSupplier,1)))
    idStatus.set(include.INConst.$$$INLIEFStatus(m$,m$.Fnc.$get(m$.var("^INLIEF",m$.var("YM").get(),pidSupplier.get(),1))));
    //<< set strStatus = $$$HasPermission(pidSupplier,idStatus,$$$FldINSupStatusDRPOrders)
    strStatus.set(include.INSupStatus.$$$HasPermission(m$,pidSupplier,idStatus,include.INConst.$$$FldINSupStatusDRPOrders(m$)));
    //<< 
    //<< quit $$$ISOK(strStatus)
    return include.COMSYS.$$$ISOK(m$,strStatus);
  }

  //<< 
  //<< 
  //<< CanSourceReqs(pidSupplier)
  public Object CanSourceReqs(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Can we source reqs for this supplier?
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:  boolean
    //<< ;
    //<< ; History:
    //<< ; 22-Nov-2007   shobby  SRBR014807:Assume that a supplier with no status is inactive.
    //<< ; 27-Feb-2007   JW      SR15453: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,idStatus
    mVar strStatus = m$.var("strStatus");
    mVar idStatus = m$.var("idStatus");
    m$.newVar(strStatus,idStatus);
    //<< 
    //<< set idStatus = $$$INLIEFStatus($get(^INLIEF(YM,pidSupplier,1)))
    idStatus.set(include.INConst.$$$INLIEFStatus(m$,m$.Fnc.$get(m$.var("^INLIEF",m$.var("YM").get(),pidSupplier.get(),1))));
    //<< if idStatus="" set idStatus = 0                                       ; Inactive
    if (mOp.Equal(idStatus.get(),"")) {
      idStatus.set(0);
    }
    //<< set strStatus = $$$HasPermission(pidSupplier,idStatus,$$$FldINSupStatusSourceReqs)
    strStatus.set(include.INSupStatus.$$$HasPermission(m$,pidSupplier,idStatus,include.INConst.$$$FldINSupStatusSourceReqs(m$)));
    //<< 
    //<< quit $$$ISOK(strStatus)
    return include.COMSYS.$$$ISOK(m$,strStatus);
  }

  //<< 
  //<< 
  //<< GetFCCode(pidSupplier="")
  public Object GetFCCode(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the FC Code for the supplier
    //<< ;
    //<< ; if the FC Code = the Base Currency, return ""
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 31-May-2004   PO      SR13591: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new SupplierRec,SupplierCurrency,CompanyCurrency
    mVar SupplierRec = m$.var("SupplierRec");
    mVar SupplierCurrency = m$.var("SupplierCurrency");
    mVar CompanyCurrency = m$.var("CompanyCurrency");
    m$.newVar(SupplierRec,SupplierCurrency,CompanyCurrency);
    //<< 
    //<< quit:pidSupplier="" ""
    if (mOp.Equal(pidSupplier.get(),"")) {
      return "";
    }
    //<< 
    //<< set SupplierRec      = $get(^INLIEF(0,pidSupplier,1))
    SupplierRec.set(m$.Fnc.$get(m$.var("^INLIEF",0,pidSupplier.get(),1)));
    //<< set SupplierCurrency = $$$INLIEFCurrency(SupplierRec)
    SupplierCurrency.set(include.INConst.$$$INLIEFCurrency(m$,SupplierRec));
    //<< set CompanyCurrency  = $$$WWW012StandardCurrency($get(^WWW012(0,0,1)))
    CompanyCurrency.set(include.WWWConst.$$$WWW012StandardCurrency(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))));
    //<< 
    //<< if SupplierCurrency = CompanyCurrency {
    if (mOp.Equal(SupplierCurrency.get(),CompanyCurrency.get())) {
      //<< set SupplierCurrency = ""
      SupplierCurrency.set("");
    }
    //<< }
    //<< quit SupplierCurrency
    return SupplierCurrency.get();
  }

  //<< 
  //<< 
  //<< ExchangeRateField(LIEF,YINHALT)
  public Object ExchangeRateField(Object ... _p) {
    mVar LIEF = m$.newVarRef("LIEF",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Encapsulate exchange rate function
    //<< ;
    //<< ; Params: LIEF - supplier
    //<< ;         YINHALT - value (by ref)
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Oct-2005   JW      SR13074: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new WHR
    mVar WHR = m$.var("WHR");
    m$.newVar(WHR);
    //<< 
    //<< SET WHR = $$$INLIEFCurrency($GET(^INLIEF(YM,LIEF,1)))
    WHR.set(include.INConst.$$$INLIEFCurrency(m$,m$.Fnc.$get(m$.var("^INLIEF",m$.var("YM").get(),LIEF.get(),1))));
    //<< 
    //<< IF (WHR'="") && (WHR'=YWHR) {
    if ((mOp.NotEqual(WHR.get(),"")) && (mOp.NotEqual(WHR.get(),m$.var("YWHR").get()))) {
      //<< IF YINHALT="" {
      if (mOp.Equal(YINHALT.get(),"")) {
        //<< SET YINHALT = $$^WWWTR(0,18,$$$WWWWAEUnitPrice($get(^WWWWAE(0,WHR,1))))
        YINHALT.set(m$.fnc$("WWWTR.main",0,18,include.WWWConst.$$$WWWWAEUnitPrice(m$,m$.Fnc.$get(m$.var("^WWWWAE",0,WHR.get(),1)))));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< SET YHID    = 2
      mVar YHID = m$.var("YHID");
      YHID.set(2);
      //<< SET YINHALT = ""
      YINHALT.set("");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PurchaseHistory(pidSupplier="")
  public Object PurchaseHistory(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Show COMView with "PurchaseHistory" favourite to list items purchased from a
    //<< ;   supplier.
    //<< ;
    //<< ; Called by : Purchase History button on form INLIEF "Supplier Master Data"
    //<< ;  the button in supplier master to show purchased line items
    //<< ;
    //<< ; History:
    //<< ; 17-Aug-2006   GRF     SR14856: Doco; boolean macro; explicit parameter specification
    //<< ; 09-Aug-2006   FIS     SR14856: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if pidSupplier'="" {
    if (mOp.NotEqual(pidSupplier.get(),"")) {
      //<< do Initialise^COMViewCustom("INAUFP","",$$$NO,$$$YES)
      m$.Cmd.Do("COMViewCustom.Initialise","INAUFP","",include.COMSYS.$$$NO(m$),include.COMSYS.$$$YES(m$));
      //<< do AddFilter^COMViewCustom("D"_$$$FldINAUFPSupplier,"=",pidSupplier)  ;SUPPLIER
      m$.Cmd.Do("COMViewCustom.AddFilter",mOp.Concat("D",include.INConst.$$$FldINAUFPSupplier(m$)),"=",pidSupplier.get());
      //<< do AddFilter^COMViewCustom("D"_$$$FldINAUFPSource,"=",1)              ;PURCHASE ONLY
      m$.Cmd.Do("COMViewCustom.AddFilter",mOp.Concat("D",include.INConst.$$$FldINAUFPSource(m$)),"=",1);
      //<< do Start^COMViewCustom()
      m$.Cmd.Do("COMViewCustom.Start");
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< OnBeforeSave(pidSupplier,&pobjSupplier)
  public Object OnBeforeSave(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjSupplier = m$.newVarRef("pobjSupplier",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;------------------------------------------------------------------\
    //<< ; Description of Function :
    //<< ;       TESTEN NUMMERNKREIS
    //<< ;
    //<< ; Params:   pidSupplier     - INLIEF id
    //<< ;           pobjSupplier    - INLIEF obj
    //<< ;
    //<< ; ByRef :   Q
    //<< ;
    //<< ; Returns : Nothing
    //<< ;
    //<< ; History :
    //<< ; 15-Feb-2006   RGB     Fixed the issue regarding EFT Payment Supplier SR BR014300
    //<< ; 15-Nov-2006   RGB     Added the INLIEFAccounts OnBeforeSave call
    //<< ; 20-Sep-2006   JW      SR14940: Fixed dot level. Cleaned up.
    //<< ; 20-Sep-2006   JW      SR14612: Moved from INLIEFCHECK. Added Account check.
    //<< ; 24-Aug-2006   GRF     Doco; expand commands; FIXME
    //<< ; 12-Apr-2006   SC      SR14195/SR14196: Validate Agent type OnBeforeSave.
    //<< ; 07.01.03      ULM     Created.
    //<< ;------------------------------------------------------------------/
    //<< new strStatus,objINVORG,idFrom,idTo
    mVar strStatus = m$.var("strStatus");
    mVar objINVORG = m$.var("objINVORG");
    mVar idFrom = m$.var("idFrom");
    mVar idTo = m$.var("idTo");
    m$.newVar(strStatus,objINVORG,idFrom,idTo);
    //<< 
    //<< quit:$get(pidSupplier)=""
    if (mOp.Equal(m$.Fnc.$get(pidSupplier),"")) {
      return null;
    }
    //<< 
    //<< do OnBeforeSave^INLIEFAccounts(YKEY,YFELD)
    m$.Cmd.Do("INLIEFAccounts.OnBeforeSave",m$.var("YKEY").get(),m$.var("YFELD").get());
    //<< do OnAfterSave^INLIEFAccounts(.pobjSupplier)
    m$.Cmd.Do("INLIEFAccounts.OnAfterSave",pobjSupplier);
    //<< 
    //<< // Check supplier range in General Parameters
    //<< set objINVORG=$GET(^INVORG(YM,YM,1))
    objINVORG.set(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)));
    //<< if (objINVORG'="") {
    if ((mOp.NotEqual(objINVORG.get(),""))) {
      //<< set idFrom = $$$INVORGRangeOfSupplierNosFrom(objINVORG)
      idFrom.set(include.INConst.$$$INVORGRangeOfSupplierNosFrom(m$,objINVORG));
      //<< set idTo = $$$INVORGTo2(objINVORG)
      idTo.set(include.INConst.$$$INVORGTo2(m$,objINVORG));
      //<< 
      //<< IF (idFrom'="") && (pidSupplier '] idFrom) {
      if ((mOp.NotEqual(idFrom.get(),"")) && (mOp.NotFollows(pidSupplier.get(),idFrom.get()))) {
        //<< do SendMsg(pidSupplier,pobjSupplier)
        m$.Cmd.Do("SendMsg",pidSupplier.get(),pobjSupplier.get());
      }
      //<< 
      //<< } elseif (idTo'="") && (pidSupplier ] idTo) {
      else if ((mOp.NotEqual(idTo.get(),"")) && (mOp.Follows(pidSupplier.get(),idTo.get()))) {
        //<< do SendMsg(pidSupplier,pobjSupplier)
        m$.Cmd.Do("SendMsg",pidSupplier.get(),pobjSupplier.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if '$$$INLIEFBroker(pobjSupplier) && '$$$INLIEFSupplier(pobjSupplier) {
    if (mOp.Not(include.INConst.$$$INLIEFBroker(m$,pobjSupplier)) && mOp.Not(include.INConst.$$$INLIEFSupplier(m$,pobjSupplier))) {
      //<< set strStatus = $listbuild("IN00410")     ; "Must select at least one Agent type."
      strStatus.set(m$.Fnc.$listbuild("IN00410"));
    }
    //<< 
    //<< } elseif $$$INLIEFMethodOfPayment(pobjSupplier) = $$$EnumPayByEFT {
    else if (mOp.Equal(include.INConst.$$$INLIEFMethodOfPayment(m$,pobjSupplier),include.COMSYSEnum.$$$EnumPayByEFT(m$))) {
      //<< if ($$$INLIEFBankAccountNumber1(pobjSupplier)="") || ($$$INLIEFBankCode1(pobjSupplier)="") {
      if ((mOp.Equal(include.INConst.$$$INLIEFBankAccountNumber1(m$,pobjSupplier),"")) || (mOp.Equal(include.INConst.$$$INLIEFBankCode1(m$,pobjSupplier),""))) {
        //<< set strStatus = $listbuild("IN00545")
        strStatus.set(m$.Fnc.$listbuild("IN00545"));
      }
    }
    //<< } ; "Method of Payment is EFT. Please enter Bank Account Number 1 and Bank Code 1 in the Account tab"
    //<< }
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set Q=$$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
      //<< $$$Error(strStatus)
      include.COMSYS.$$$Error(m$,strStatus);
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SendMsg(pidSupplier,pobjSupplier)   private
  public Object SendMsg(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjSupplier = m$.newVarRef("pobjSupplier",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Send a msg regarding the supplier number being out of range.
    //<< ;
    //<< ; Params:   pidSupplier     - INLIEF id
    //<< ;           pobjSupplier    - INLIEF obj
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Sep-2006   JW      SR14940: Created (encapsulated from OnBeforeSave)
    //<< ;-------------------------------------------------------------------------------
    //<< new YFORM,YVOR // <-- Is this required? Is this for call to SPEI
    mVar YFORM = m$.var("YFORM");
    mVar YVOR = m$.var("YVOR");
    m$.newVar(YFORM,YVOR);
    //<< new objRecord,idRecord
    mVar objRecord = m$.var("objRecord");
    mVar idRecord = m$.var("idRecord");
    m$.newVar(objRecord,idRecord);
    //<< 
    //<< IF $get(YBED)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) {
      //<< set idRecord = $$^WWWNEXT("WWW013M")
      idRecord.set(m$.fnc$("WWWNEXT.main","WWW013M"));
      //<< if idRecord '= "" {
      if (mOp.NotEqual(idRecord.get(),"")) {
        //<< set objRecord = pidSupplier_" "_$$$INLIEFShortName(pobjSupplier)_"\n"_$$$Text(32198)  ;RICHTIGER NUMMERNKREIS ?
        objRecord.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidSupplier.get()," "),include.INConst.$$$INLIEFShortName(m$,pobjSupplier)),"\\n"),include.COMSYS.$$$Text(m$,32198)));
        //<< do ^WWWSPEI("WWW013M",YBED_","_idRecord,objRecord)  ;SPEICHERN INFO-NACHRICHT ;Save
        m$.Cmd.Do("WWWSPEI.main","WWW013M",mOp.Concat(mOp.Concat(m$.var("YBED").get(),","),idRecord.get()),objRecord.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterSave()
  public Object OnAfterSave() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Method Usage
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Feb-2007   RGB     SRBR014300: Created
    //<< ;-------------------------------------------------------------------------------
    //<< do ^INFIBKRE
    m$.Cmd.Do("INFIBKRE.main");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeSaveHook(pidSupplier, pobjSupplier)
  public Object OnBeforeSaveHook(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjSupplier = m$.newVarRef("pobjSupplier",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check if CPF/CNPJ code is unique and blank
    //<< ; **** Note: This is optional code that is called based on an OnBeforeSave VAR hook
    //<< ;            being created on the INLIEF class.
    //<< ;            Currently it's use is only of interest to SES and Celesc but will apply
    //<< ;            to any new Brasilian clients.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: strStatus
    //<< ;
    //<< ; History:
    //<< ; 22-Oct-2008   shobby  SRBR014968: Changed $lb to $$$MakeStatus
    //<< ; 26-Aug-2008   shobby  SRBR014968: initialised a value for strCompanyNumberClean and only test for CPF
    //<< ;                                   if FREE16 is populated with 1.
    //<< ; 30-May-2007   HeberB  SRBR014329: (rewritten)Use symbols to save and search index
    //<< ; 15-May-2007   RPW     SRBR014329: Fixed logic, would fail if pidSupplier = the value for the index.
    //<< ;                       Would still get the error message
    //<< ; 14-May-2007   GM      SRBR014329: Parameters removed
    //<< ; 03-May-2007   shobby  SRBR014408: Renamed from OnBeforeSaveDataField
    //<< ; 26-Apr-2007   GM      SRBR014329: change prefix of language text
    //<< ; 23-Mar-2007   HeberB  SRBR014408: remove symbols from strCompanyNumber before validating
    //<< ; 15-Mar-2007   shobby  SRBR014329: shobby renamed tag, fixed some coding errors. Fixed reference to index 6
    //<< ; 17-Nov-2006   GM      SRBR014329: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $get(Y)="" do ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< 
    //<< new blnCompanyNumberIsUsed,idSupplier,idxCompanyNumber
    mVar blnCompanyNumberIsUsed = m$.var("blnCompanyNumberIsUsed");
    mVar idSupplier = m$.var("idSupplier");
    mVar idxCompanyNumber = m$.var("idxCompanyNumber");
    m$.newVar(blnCompanyNumberIsUsed,idSupplier,idxCompanyNumber);
    //<< new strCompanyNumber,strCompanyNumberClean,strFiscal,strStatus
    mVar strCompanyNumber = m$.var("strCompanyNumber");
    mVar strCompanyNumberClean = m$.var("strCompanyNumberClean");
    mVar strFiscal = m$.var("strFiscal");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strCompanyNumber,strCompanyNumberClean,strFiscal,strStatus);
    //<< 
    //<< quit:(pidSupplier="") $$$NO
    if ((mOp.Equal(pidSupplier.get(),""))) {
      return include.COMSYS.$$$NO(m$);
    }
    //<< 
    //<< set strStatus             = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set strCompanyNumber      = $$$INLIEFCompanyNumber(pobjSupplier)
    strCompanyNumber.set(include.INConst.$$$INLIEFCompanyNumber(m$,pobjSupplier));
    //<< set strCompanyNumberClean = ""
    strCompanyNumberClean.set("");
    //<< set strFiscal = $$$INLIEFFREE16(pobjSupplier)
    strFiscal.set(include.INConst.$$$INLIEFFREE16(m$,pobjSupplier));
    //<< 
    //<< if strCompanyNumber="" {
    if (mOp.Equal(strCompanyNumber.get(),"")) {
      //<< if strFiscal=1 {
      if (mOp.Equal(strFiscal.get(),1)) {
        //<< set strStatus = $$$MakeStatus("Com00294")        ; "Fill out the Person Number(CPF)"
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"Com00294"));
      }
      //<< 
      //<< } elseif strFiscal=2 {
      else if (mOp.Equal(strFiscal.get(),2)) {
        //<< set strStatus = $$$MakeStatus("Com00295")        ; "Fill out the Company Number(CNPJ)"
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"Com00295"));
      }
      //<< 
      //<< } else {
      else {
      }
    }
    //<< /* Do not care */
    //<< }
    //<< } else {
    else {
      //<< if strFiscal="" {
      if (mOp.Equal(strFiscal.get(),"")) {
        //<< set strStatus = $$$MakeStatus("Com00296")      ; "Fill out the "Natureza Fiscal""
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"Com00296"));
      }
      //<< 
      //<< } else {
      else {
        //<< ; if number provided with no symbols add them to be saved and
        //<< ; checked whether has already being used
        //<< ; 3N1"."3N1"."3N1"-"2N      2N1"."3N1"."3N1"/"4N1"-"2N
        //<< if '$find(strCompanyNumber,".") {
        if (mOp.Not(m$.Fnc.$find(strCompanyNumber.get(),"."))) {
          //<< set strCompanyNumberClean = strCompanyNumber
          strCompanyNumberClean.set(strCompanyNumber.get());
          //<< if (strFiscal=2) {  // CNPJ
          if ((mOp.Equal(strFiscal.get(),2))) {
            //<< set strCompanyNumber =  $extract(strCompanyNumber,1,2)_"."_
            //<< $extract(strCompanyNumber,3,5)_"."_
            //<< $extract(strCompanyNumber,6,8)_"/"_
            //<< $extract(strCompanyNumber,9,12)_"-"_
            //<< $extract(strCompanyNumber,13,14)
            strCompanyNumber.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(strCompanyNumber.get(),1,2),"."),m$.Fnc.$extract(strCompanyNumber.get(),3,5)),"."),m$.Fnc.$extract(strCompanyNumber.get(),6,8)),"/"),m$.Fnc.$extract(strCompanyNumber.get(),9,12)),"-"),m$.Fnc.$extract(strCompanyNumber.get(),13,14)));
          }
          //<< } else {            // CPF
          else {
            //<< set strCompanyNumber =  $extract(strCompanyNumber,1,3)_"."_
            //<< $extract(strCompanyNumber,4,6)_"."_
            //<< $extract(strCompanyNumber,7,9)_"-"_
            //<< $extract(strCompanyNumber,10,11)
            strCompanyNumber.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(strCompanyNumber.get(),1,3),"."),m$.Fnc.$extract(strCompanyNumber.get(),4,6)),"."),m$.Fnc.$extract(strCompanyNumber.get(),7,9)),"-"),m$.Fnc.$extract(strCompanyNumber.get(),10,11)));
          }
          //<< }
          //<< set $$$INLIEFCompanyNumber(pobjSupplier) =  strCompanyNumber
          include.INConst.$$$INLIEFCompanyNumberSet(m$,pobjSupplier,strCompanyNumber.get());
        }
        //<< } else {
        else {
          //<< set strCompanyNumberClean = $translate(strCompanyNumber,".-/")
          strCompanyNumberClean.set(m$.Fnc.$translate(strCompanyNumber.get(),".-/"));
        }
        //<< }
        //<< 
        //<< set idxCompanyNumber = $$$Index(strCompanyNumber)
        idxCompanyNumber.set(include.MEDConst.$$$Index(m$,strCompanyNumber));
        //<< if $data(^INLIEFs(YM,6,idxCompanyNumber)) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^INLIEFs",m$.var("YM").get(),6,idxCompanyNumber.get())))) {
          //<< set blnCompanyNumberIsUsed = $$$NO
          blnCompanyNumberIsUsed.set(include.COMSYS.$$$NO(m$));
          //<< $$$Order4(^INLIEFs,YM,6,idxCompanyNumber,idSupplier)
          idSupplier.set("");
          for (;true;) {
            idSupplier.set(m$.Fnc.$order(m$.var("^INLIEFs",m$.var("YM").get(),6,idxCompanyNumber.get(),idSupplier.get())));
            if (mOp.Equal(idSupplier.get(),"")) {
              break;
            }
            //<< if (idSupplier'=pidSupplier) {
            if ((mOp.NotEqual(idSupplier.get(),pidSupplier.get()))) {
              //<< set blnCompanyNumberIsUsed = $$$YES
              blnCompanyNumberIsUsed.set(include.COMSYS.$$$YES(m$));
              //<< quit
              break;
            }
          }
          //<< }
          //<< $$$End
          //<< if (blnCompanyNumberIsUsed) {
          if (mOp.Logical((blnCompanyNumberIsUsed.get()))) {
            //<< set strStatus = $$$MakeStatus("Com00293")
            strStatus.set(include.COMSYS.$$$MakeStatus(m$,"Com00293"));
          }
        }
      }
    }
    //<< } ; "This Person Number(CPF) or Company Number(CNPJ) has already been used"
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< if (strFiscal=2) {
      if ((mOp.Equal(strFiscal.get(),2))) {
        //<< set strStatus = $$ValidateCNPJ^COMValidation(strCompanyNumberClean)
        strStatus.set(m$.fnc$("COMValidation.ValidateCNPJ",strCompanyNumberClean.get()));
      }
      //<< 
      //<< } elseif (strFiscal=1) {
      else if ((mOp.Equal(strFiscal.get(),1))) {
        //<< set strStatus = $$ValidateCPF^COMValidation(strCompanyNumberClean)
        strStatus.set(m$.fnc$("COMValidation.ValidateCPF",strCompanyNumberClean.get()));
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnAfterPrimaryKeyVAR(pidSupplier)
  public Object OnAfterPrimaryKeyVAR(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get values below and loads into CacheTemp to be used on form. Called from
    //<< ; 'Execute After Data Field' customization field of Primary Key. Used in conjunction
    //<< ; with OnBeforeDataFieldVAR
    //<< ;
    //<< ; Data: (date of last purchase)
    //<< ; Valor: (value of last purchase)
    //<< ; Number of receipt (nota fiscal) of last purchase
    //<< ; No Mês: $  (Monthly total)
    //<< ; No Ano: $ (Year total)
    //<< ;
    //<< ; Params: pidSupplier - Supplier Number
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Jun-2007   HeberB  SRBR014327(1): Change to comply with INRECB
    //<< ; 16-May-2007   RPW     SRBR014327: Removed string from CacheTempDetailsLastPurchase as its not needed
    //<< ; 15-May-2007   HeberB  SRBR014327: Changed CacheTemp to CacheTempDetailsLastPurchase
    //<< ;                           Use of macros
    //<< ;                           dteLast '= 1 -> indication a receipt was found
    //<< ; 14-May-2007   HeberB  SRBR014327: Created based on OnBeforeDataField
    //<< ;-------------------------------------------------------------------------------
    //<< quit:$$$NoKey(pidSupplier)
    if (mOp.Logical(include.COMSYS.$$$NoKey(m$,pidSupplier))) {
      return null;
    }
    //<< 
    //<< new arrINREC,dteDeliveryNoteDate,dteLast,dteINRECMonth,dteINRECYear,fltYearValue
    mVar arrINREC = m$.var("arrINREC");
    mVar dteDeliveryNoteDate = m$.var("dteDeliveryNoteDate");
    mVar dteLast = m$.var("dteLast");
    mVar dteINRECMonth = m$.var("dteINRECMonth");
    mVar dteINRECYear = m$.var("dteINRECYear");
    mVar fltYearValue = m$.var("fltYearValue");
    m$.newVar(arrINREC,dteDeliveryNoteDate,dteLast,dteINRECMonth,dteINRECYear,fltYearValue);
    //<< new idINREC,objINREC,idINRECLast,objINRECLast,idINAUF,objINAUF
    mVar idINREC = m$.var("idINREC");
    mVar objINREC = m$.var("objINREC");
    mVar idINRECLast = m$.var("idINRECLast");
    mVar objINRECLast = m$.var("objINRECLast");
    mVar idINAUF = m$.var("idINAUF");
    mVar objINAUF = m$.var("objINAUF");
    m$.newVar(idINREC,objINREC,idINRECLast,objINRECLast,idINAUF,objINAUF);
    //<< 
    //<< kill ^CacheTempDetailsLastPurchase(YUSER,YUCI,"DetailsLastPurchase",pidSupplier)
    m$.var("^CacheTempDetailsLastPurchase",m$.var("YUSER").get(),m$.var("YUCI").get(),"DetailsLastPurchase",pidSupplier.get()).kill();
    //<< kill arrINREC
    arrINREC.kill();
    //<< 
    //<< set arrINREC    = ""
    arrINREC.set("");
    //<< set idINRECLast = ""
    idINRECLast.set("");
    //<< set dteLast     = 1
    dteLast.set(1);
    //<< 
    //<< ; loop to find the last INREC and to calculate the total of the month and year
    //<< set idINREC = ""
    idINREC.set("");
    //<< for {
    for (;true;) {
      //<< set idINREC = $order(^INREC(YM,idINREC))
      idINREC.set(m$.Fnc.$order(m$.var("^INREC",m$.var("YM").get(),idINREC.get())));
      //<< quit:idINREC=""
      if (mOp.Equal(idINREC.get(),"")) {
        break;
      }
      //<< 
      //<< set objINREC = $get(^INREC(YM,idINREC,1))
      objINREC.set(m$.Fnc.$get(m$.var("^INREC",m$.var("YM").get(),idINREC.get(),1)));
      //<< 
      //<< continue:($$$INRECStatus(objINREC) '= $$$EnumINSTATUSProcessed)
      if ((mOp.NotEqual(include.INConst.$$$INRECStatus(m$,objINREC),include.INConst.$$$EnumINSTATUSProcessed(m$)))) {
        continue;
      }
      //<< continue:($$$INRECDeliveryNoteDate(objINREC) = "")
      if ((mOp.Equal(include.INConst.$$$INRECDeliveryNoteDate(m$,objINREC),""))) {
        continue;
      }
      //<< continue:(+$$$INRECDeliveryNoteDate(objINREC) < $$$DateFirstDayOfYear(dteLast))
      if ((mOp.Less(mOp.Positive(include.INConst.$$$INRECDeliveryNoteDate(m$,objINREC)),include.COMSYSDate.$$$DateFirstDayOfYear(m$,dteLast)))) {
        continue;
      }
      //<< 
      //<< ;SRBR014327(1)
      //<< ;set idINAUF = $$$INRECFREE10(objINREC)
      //<< set idINAUF = $$$INRECSupplierOrder(objINREC)
      idINAUF.set(include.INConst.$$$INRECSupplierOrder(m$,objINREC));
      //<< continue:(idINAUF = "")
      if ((mOp.Equal(idINAUF.get(),""))) {
        continue;
      }
      //<< 
      //<< set objINAUF = $get(^INAUF(YM,idINAUF,1))
      objINAUF.set(m$.Fnc.$get(m$.var("^INAUF",m$.var("YM").get(),idINAUF.get(),1)));
      //<< 
      //<< continue:(pidSupplier '= $$$INAUFSupplierNumber(objINAUF))
      if ((mOp.NotEqual(pidSupplier.get(),include.INConst.$$$INAUFSupplierNumber(m$,objINAUF)))) {
        continue;
      }
      //<< 
      //<< if (+$$$INRECDeliveryNoteDate(objINREC) >= +dteLast) {
      if ((mOp.GreaterOrEqual(mOp.Positive(include.INConst.$$$INRECDeliveryNoteDate(m$,objINREC)),mOp.Positive(dteLast.get())))) {
        //<< set dteLast = $$$INRECDeliveryNoteDate(objINREC)
        dteLast.set(include.INConst.$$$INRECDeliveryNoteDate(m$,objINREC));
        //<< set objINRECLast = objINREC
        objINRECLast.set(objINREC.get());
        //<< set idINRECLast  = idINREC
        idINRECLast.set(idINREC.get());
      }
      //<< }
      //<< set dteINRECMonth = $$$DateMonth($$$INRECDeliveryNoteDate(objINREC))
      dteINRECMonth.set(include.COMSYSDate.$$$DateMonth(m$,include.INConst.$$$INRECDeliveryNoteDate(m$,objINREC)));
      //<< set dteINRECYear =  $$$DateYear($$$INRECDeliveryNoteDate(objINREC))
      dteINRECYear.set(include.COMSYSDate.$$$DateYear(m$,include.INConst.$$$INRECDeliveryNoteDate(m$,objINREC)));
      //<< 
      //<< set arrINREC(dteINRECYear,dteINRECMonth) = $get(arrINREC(dteINRECYear,dteINRECMonth),0) + $$$INRECAmount(objINREC)
      arrINREC.var(dteINRECYear.get(),dteINRECMonth.get()).set(mOp.Add(m$.Fnc.$get(arrINREC.var(dteINRECYear.get(),dteINRECMonth.get()),0),include.INConst.$$$INRECAmount(m$,objINREC)));
    }
    //<< }
    //<< 
    //<< if dteLast '= 1 {
    if (mOp.NotEqual(dteLast.get(),1)) {
      //<< set fltYearValue  = 0
      fltYearValue.set(0);
      //<< set dteINRECMonth = ""
      dteINRECMonth.set("");
      //<< for {
      for (;true;) {
        //<< set dteINRECMonth = $order(arrINREC($$$DateYear(dteLast),dteINRECMonth))
        dteINRECMonth.set(m$.Fnc.$order(arrINREC.var(include.COMSYSDate.$$$DateYear(m$,dteLast),dteINRECMonth.get())));
        //<< quit:dteINRECMonth=""
        if (mOp.Equal(dteINRECMonth.get(),"")) {
          break;
        }
        //<< 
        //<< set fltYearValue = fltYearValue + arrINREC($$$DateYear(dteLast),dteINRECMonth)
        fltYearValue.set(mOp.Add(fltYearValue.get(),arrINREC.var(include.COMSYSDate.$$$DateYear(m$,dteLast),dteINRECMonth.get()).get()));
      }
      //<< }
      //<< 
      //<< set ^CacheTempDetailsLastPurchase(YUSER,YUCI,pidSupplier,"LastDate")    = $$^WWWDATE(dteLast)
      m$.var("^CacheTempDetailsLastPurchase",m$.var("YUSER").get(),m$.var("YUCI").get(),pidSupplier.get(),"LastDate").set(m$.fnc$("WWWDATE.main",dteLast.get()));
      //<< set ^CacheTempDetailsLastPurchase(YUSER,YUCI,pidSupplier,"LastInvoice") = +$$$INRECInvoiceNumber(objINRECLast)
      m$.var("^CacheTempDetailsLastPurchase",m$.var("YUSER").get(),m$.var("YUCI").get(),pidSupplier.get(),"LastInvoice").set(mOp.Positive(include.INConst.$$$INRECInvoiceNumber(m$,objINRECLast)));
      //<< set ^CacheTempDetailsLastPurchase(YUSER,YUCI,pidSupplier,"LastAmount")  = $$^WWWZAHL(+$$$INRECAmount(objINRECLast))
      m$.var("^CacheTempDetailsLastPurchase",m$.var("YUSER").get(),m$.var("YUCI").get(),pidSupplier.get(),"LastAmount").set(m$.fnc$("WWWZAHL.main",mOp.Positive(include.INConst.$$$INRECAmount(m$,objINRECLast))));
      //<< set ^CacheTempDetailsLastPurchase(YUSER,YUCI,pidSupplier,"MonthValue")  = $$^WWWZAHL(arrINREC($$$DateYear(dteLast),$$$DateMonth(dteLast)))
      m$.var("^CacheTempDetailsLastPurchase",m$.var("YUSER").get(),m$.var("YUCI").get(),pidSupplier.get(),"MonthValue").set(m$.fnc$("WWWZAHL.main",arrINREC.var(include.COMSYSDate.$$$DateYear(m$,dteLast),include.COMSYSDate.$$$DateMonth(m$,dteLast)).get()));
      //<< set ^CacheTempDetailsLastPurchase(YUSER,YUCI,pidSupplier,"AnualValue")  = $$^WWWZAHL(fltYearValue)
      m$.var("^CacheTempDetailsLastPurchase",m$.var("YUSER").get(),m$.var("YUCI").get(),pidSupplier.get(),"AnualValue").set(m$.fnc$("WWWZAHL.main",fltYearValue.get()));
    }
    //<< 
    //<< } else {           // FIXME: Is this even needed
    else {
      //<< set ^CacheTempDetailsLastPurchase(YUSER,YUCI,pidSupplier) = ""
      m$.var("^CacheTempDetailsLastPurchase",m$.var("YUSER").get(),m$.var("YUCI").get(),pidSupplier.get()).set("");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeDataFieldVAR(pidSupplier,pstrType)
  public Object OnBeforeDataFieldVAR(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get loaded into CacheTemp to be used on form
    //<< ;
    //<< ; Params: pidSupplier - Supplier Number
    //<< ;         pstrType  - Identifies data to be recovered
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ;
    //<< ; 15-May-2007   HeberB  SRBR014327: Changed CacheTemp to CacheTempDetailsLastPurchase
    //<< ; 14-May-2007   HeberB  SRBR014327: Created based on OnBeforeDataField
    //<< ;-------------------------------------------------------------------------------
    //<< new strValue
    mVar strValue = m$.var("strValue");
    m$.newVar(strValue);
    //<< 
    //<< quit:$$$NoKey(pidSupplier) ""
    if (mOp.Logical(include.COMSYS.$$$NoKey(m$,pidSupplier))) {
      return "";
    }
    //<< quit:pstrType="" ""
    if (mOp.Equal(pstrType.get(),"")) {
      return "";
    }
    //<< 
    //<< quit:('$data(^CacheTempDetailsLastPurchase(YUSER,YUCI,pidSupplier,pstrType))) ""
    if ((mOp.Not(m$.Fnc.$data(m$.var("^CacheTempDetailsLastPurchase",m$.var("YUSER").get(),m$.var("YUCI").get(),pidSupplier.get(),pstrType.get()))))) {
      return "";
    }
    //<< 
    //<< set strValue = $get(^CacheTempDetailsLastPurchase(YUSER,YUCI,pidSupplier,pstrType))
    strValue.set(m$.Fnc.$get(m$.var("^CacheTempDetailsLastPurchase",m$.var("YUSER").get(),m$.var("YUCI").get(),pidSupplier.get(),pstrType.get())));
    //<< 
    //<< kill ^CacheTempDetailsLastPurchase(YUSER,YUCI,pidSupplier,pstrType)
    m$.var("^CacheTempDetailsLastPurchase",m$.var("YUSER").get(),m$.var("YUCI").get(),pidSupplier.get(),pstrType.get()).kill();
    //<< 
    //<< quit strValue
    return strValue.get();
  }

}
