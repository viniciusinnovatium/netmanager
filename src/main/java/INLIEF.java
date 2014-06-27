//*****************************************************************************
//** TASC - ALPHALINC - MAC INLIEF
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 13:51:57
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
//import INSupStatus;
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
          //TODO REVISAR FALTA INCLUDE strStatus.set($$$include.$$$HasPermission(m$,pidSupplier,idStatus,intField));
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
    //TODO REVISAR FALTA INCLUDE strStatus.set($$$include.$$$HasPermission(m$,pidSupplier,idStatus,include.INConst.$$$FldINSupStatusReceiveGoods(m$)));
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
  //TODO REVISAR FALTA strStatus.set($$$include.$$$HasPermission(m$,pidSupplier,idStatus,include.INConst.$$$FldINSupStatusDRPOrders(m$)));
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
  //TODO REVISAR FALTA strStatus.set($$$include.$$$HasPermission(m$,pidSupplier,idStatus,include.INConst.$$$FldINSupStatusSourceReqs(m$)));
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
    }
    return null; //TODO REVISAR CLASSE GERADA INCOMPLETA
    }
}