//*****************************************************************************
//** TASC - ALPHALINC - MAC INVORG
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 20:25:13
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include INConst
import include.INConst;
import include.COMSYS;
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

//<< INVORG
public class INVORG extends mClass {

  public void main() {
    _INVORG();
  }

  public void _INVORG() {
  }

  //<< ;-------------------------------------------------------------------------------
  //<< ; 09-Feb-2010   shobby  SR17138.3 (Class/Form INVORG changed) - Do not remove comment
  //<< ; 17-Mar-2008   shobby  BR014772  (Class/Form INVORG changed) - Do not remove comment
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< Get()
  public Object Get() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Public method to get the INVORG record
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 30-Nov-2009   shobby  SRAdhoc   : Use YM,YM not 0,0
    //<< ; 06-Nov-2007   shobby  SRBR014764: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $get(^INVORG(YM,YM,1))
    return m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1));
  }

  //<< 
  //<< 
  //<< DisableProgramFunctionality()       ;SR17034
  public Object DisableProgramFunctionality() {
    //<< quit $$$INVORGDisableProgramFunctiona($$Get())
    return include.INConst.$$$INVORGDisableProgramFunctiona(m$,m$.fnc$("Get"));
  }

  //<< 
  //<< 
  //<< PickMoreThanTransfer() quit $$$INVORGPickMoreThanTransfer($$Get())  ;SR17729
  public Object PickMoreThanTransfer() {
    return include.INConst.$$$INVORGPickMoreThanTransfer(m$,m$.fnc$("Get"));
  }

  //<< 
  //<< 
  //<< OnBeforeSave()
  public Object OnBeforeSave() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Prevent save if any of the day offsets are negative
    //<< ;
    //<< ; If we can access the stock from other locations, we must be able to see the
    //<< ; stock from these locations as well
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Oct-2008   GRF     SR16028: DecomposeStatus is redundant; Once a Default
    //<< ;                           Group has been specified it cannot be deleted
    //<< ;                           (changes are permitted).
    //<< ; 15-Nov-2007   shobby  SRBR014765:Validate stocktake counts.
    //<< ; 12-Jan-2007   PO      SR15344: Validation added
    //<< ; 09-Jun-2005   GRF     $$$INVORGAccessOtherItemLocns - name updated
    //<< ; 31-May-2005   RPW     Created SR11649
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,strStatus
    mVar idField = m$.var("idField");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idField,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if ($$$INVORGStocktakeMinCount(YFELD)>$$$INVORGStocktakeMaxCount(YFELD)) && ($$$INVORGStocktakeMaxCount(YFELD)'="") {
    if ((mOp.Greater(include.INConst.$$$INVORGStocktakeMinCount(m$,m$.var("YFELD")),include.INConst.$$$INVORGStocktakeMaxCount(m$,m$.var("YFELD")))) && (mOp.NotEqual(include.INConst.$$$INVORGStocktakeMaxCount(m$,m$.var("YFELD")),""))) {
      //<< set strStatus=$$$MakeStatus("IN00793")  ; "Minimum count must be less than maximum count."
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00793"));
    }
    //<< 
    //<< } elseif ($$$INVORGStocktakeMinCount(YFELD)<1) && ($$$INVORGStocktakeMinCount(YFELD)'="") {
    else if ((mOp.Less(include.INConst.$$$INVORGStocktakeMinCount(m$,m$.var("YFELD")),1)) && (mOp.NotEqual(include.INConst.$$$INVORGStocktakeMinCount(m$,m$.var("YFELD")),""))) {
      //<< set strStatus=$$$MakeStatus("IN00794")  ; "Minimum count if specified must be at least 1."
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00794"));
    }
    //<< 
    //<< } elseif ($$$INVORGStocktakeMaxCount(YFELD)<1) && ($$$INVORGStocktakeMaxCount(YFELD)'="") {
    else if ((mOp.Less(include.INConst.$$$INVORGStocktakeMaxCount(m$,m$.var("YFELD")),1)) && (mOp.NotEqual(include.INConst.$$$INVORGStocktakeMaxCount(m$,m$.var("YFELD")),""))) {
      //<< set strStatus=$$$MakeStatus("IN00795")  ; "Maximum count if specified must be at least 1."
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00795"));
    }
    //<< }
    //<< 
    //<< ; If allowed the more restrictive access, ensure the less restrictive is available
    //<< if $$$INVORGAccessOtherItemLocns(YFELD)=$$$YES {
    if (mOp.Equal(include.INConst.$$$INVORGAccessOtherItemLocns(m$,m$.var("YFELD")),include.COMSYS.$$$YES(m$))) {
      //<< set $$$INVORGViewStockFromAllLocations(YFELD)=$$$YES
      include.INConst.$$$INVORGViewStockFromAllLocationsSet(m$,m$.var("YFELD"),include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< for idField = $$$FldINVORGFirm,$$$FldINVORGSource,$$$FldINVORGRaise,$$$FldINVORGPlace,$$$FldINVORGConfirm,$$$FldINVORGSupplier {
    for (Object _idField: new Object[] {include.INConst.$$$FldINVORGFirm(m$),include.INConst.$$$FldINVORGSource(m$),include.INConst.$$$FldINVORGRaise(m$),include.INConst.$$$FldINVORGPlace(m$),include.INConst.$$$FldINVORGConfirm(m$),include.INConst.$$$FldINVORGSupplier(m$)}) {
    idField.set(_idField);
      //<< if $piece(YFELD,Y,idField) < 0 {
      if (mOp.Less(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),_idField),0)) {
        //<< set strStatus = $$$MakeStatus("IN00638",$$^WWWFELDNAME(YFORM,"D",idField))
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00638",m$.fnc$("WWWFELDNAME.main",m$.var("YFORM").get(),"D",_idField)));
        //<< quit
        break;
      }
    }
    //<< }    ; "%1 number of days must be greater than or equal to zero."
    //<< }
    //<< 
    //<< ; SR16028
    //<< if $$$ISOK(strStatus) && ($$$INVORGDefaultItemGroup(YFELD)="") {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus)) && (mOp.Equal(include.INConst.$$$INVORGDefaultItemGroup(m$,m$.var("YFELD")),""))) {
      //<< if $$$INVORGDefaultItemGroup($get(^INVORG(0,0,1)))'="" {
      if (mOp.NotEqual(include.INConst.$$$INVORGDefaultItemGroup(m$,m$.Fnc.$get(m$.var("^INVORG",0,0,1))),"")) {
        //<< set strStatus = $$$MakeStatus("IN00766")       ; "Can not delete the Default Item Group once set"
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00766"));
      }
    }
    //<< }
    //<< }
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< ;   $$$DecomposeStatus(strStatus)
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
      //<< set Q = $$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DPforInventoryCost()
  public Object DPforInventoryCost() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return the number of Decimal Places to be used for Inventory Cost fields.
    //<< ;    See also - logic in common function : GetDecimalPlaces^COMUtilNum
    //<< ;
    //<< ; Returns: Number of Decimal Places
    //<< ;
    //<< ; History:
    //<< ; 01-Jun-2009   GRF     SR16588: Only provide default DP if not set - may want 0
    //<< ; 24-Oct-2005   PO      SR13702: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intNumberOfDP
    mVar intNumberOfDP = m$.var("intNumberOfDP");
    m$.newVar(intNumberOfDP);
    //<< 
    //<< set intNumberOfDP = $$$INVORGDecimalpointsforinventory($get(^INVORG(0,0,1)))
    intNumberOfDP.set(include.INConst.$$$INVORGDecimalpointsforinventory(m$,m$.Fnc.$get(m$.var("^INVORG",0,0,1))));
    //<< if intNumberOfDP="" set intNumberOfDP = 4
    if (mOp.Equal(intNumberOfDP.get(),"")) {
      intNumberOfDP.set(4);
    }
    //<< quit intNumberOfDP
    return intNumberOfDP.get();
  }

  //<< 
  //<< 
  //<< PopulateINVORGLANG(pstrLang="EN")
  public Object PopulateINVORGLANG(Object ... _p) {
    mVar pstrLang = m$.newVarRef("pstrLang",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"EN");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Copies INVORG fields to INVORGLANG for one language
    //<< ;
    //<< ; Params:   pstrLang - language to copy to
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 28-Apr-2006   JW      SR14421: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objINVORG,objINVORGLANG,strStatus,YM
    mVar objINVORG = m$.var("objINVORG");
    mVar objINVORGLANG = m$.var("objINVORGLANG");
    mVar strStatus = m$.var("strStatus");
    mVar YM = m$.var("YM");
    m$.newVar(objINVORG,objINVORGLANG,strStatus,YM);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set YM = ""
    YM.set("");
    //<< for {
    for (;true;) {
      //<< set YM = $order(^INVORG(YM))
      YM.set(m$.Fnc.$order(m$.var("^INVORG",YM.get())));
      //<< quit:YM=""
      if (mOp.Equal(YM.get(),"")) {
        break;
      }
      //<< 
      //<< set objINVORG     = $get(^INVORG(0,0,1))
      objINVORG.set(m$.Fnc.$get(m$.var("^INVORG",0,0,1)));
      //<< set objINVORGLANG = $$$INVORGTextWithinManifest(objINVORG)_"~"_$$$INVORGTextAfterPickList(objINVORG)_"~"_$$$INVORGAfterTextInternalDelivery(objINVORG)_"~"_$$$INVORGTextforEmailReminder(objINVORG)
      objINVORGLANG.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(include.INConst.$$$INVORGTextWithinManifest(m$,objINVORG),"~"),include.INConst.$$$INVORGTextAfterPickList(m$,objINVORG)),"~"),include.INConst.$$$INVORGAfterTextInternalDelivery(m$,objINVORG)),"~"),include.INConst.$$$INVORGTextforEmailReminder(m$,objINVORG)));
      //<< set strStatus = $$$Save("INVORGLANG",YM_","_pstrLang,objINVORGLANG)
      strStatus.set(include.COMSYS.$$$Save(m$,"INVORGLANG",mOp.Concat(mOp.Concat(YM.get(),","),pstrLang.get()),objINVORGLANG));
      //<< 
      //<< quit:$$$ISERR(strStatus)
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        break;
      }
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnAfterSave()
  public Object OnAfterSave() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; - Create Delete Storage for all locations
    //<< ; - Refresh Item Groups if default Item Group is changed.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Oct-2008   HQN     SR16028: Update V1.5 Default ItemGroup
    //<< ; 26-Oct-2007   GRF     SR15563: explicitly pass YM to DeleteStockLoc
    //<< ; 28-Apr-2006   JW      SR14421: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLocn,objUItemGroup,sc
    mVar idLocn = m$.var("idLocn");
    mVar objUItemGroup = m$.var("objUItemGroup");
    mVar sc = m$.var("sc");
    m$.newVar(idLocn,objUItemGroup,sc);
    //<< 
    //<< set idLocn=""
    idLocn.set("");
    //<< for {
    for (;true;) {
      //<< set idLocn=$order(^WWW0121(0,0,idLocn))
      idLocn.set(m$.Fnc.$order(m$.var("^WWW0121",0,0,idLocn.get())));
      //<< quit:idLocn=""
      if (mOp.Equal(idLocn.get(),"")) {
        break;
      }
      //<< 
      //<< do CreateDeleteStockLoc^WWW0121(0,idLocn)
      m$.Cmd.Do("WWW0121.CreateDeleteStockLoc",0,idLocn.get());
    }
    //<< }
    //<< 
    //<< if $$$INVORGDefaultItemGroup($get(YFELD))'="" {       ; SR16028
    if (mOp.NotEqual(include.INConst.$$$INVORGDefaultItemGroup(m$,m$.Fnc.$get(m$.var("YFELD"))),"")) {
      //<< set objUItemGroup = ##class(alINV.dUItemGroup).%OpenId("0||"_$$$INVORGDefaultItemGroup($get(YFELD)),4,.sc)
      objUItemGroup.set(m$.fnc$("alINV.dUItemGroup.$OpenId",mOp.Concat("0||",include.INConst.$$$INVORGDefaultItemGroup(m$,m$.Fnc.$get(m$.var("YFELD")))),4,sc));
      //<< if $$$ISOK(sc) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
        //<< set objUItemGroup.IsDefault = $$$YES
        m$.prop(objUItemGroup.get(),"IsDefault").set(include.COMSYS.$$$YES(m$));
        //<< set sc = objUItemGroup.%Save()
        sc.set(m$.fnc$(objUItemGroup.getORef(),"%Save"));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< HideCustoms()
  public Object HideCustoms() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines whether or not we are hiding customs information.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 31-Oct-2006   Steve S SRBR014280: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit +$$$INVORGHideCustomsInformation($get(^INVORG(0,0,1)))
    return mOp.Positive(include.INConst.$$$INVORGHideCustomsInformation(m$,m$.Fnc.$get(m$.var("^INVORG",0,0,1))));
  }

  //<< 
  //<< 
  //<< SetEnablePricePlan(pidCompany,pblnEnable)
  public Object SetEnablePricePlan(Object ... _p) {
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnEnable = m$.newVarRef("pblnEnable",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set the price plan checkbox. Called from terminal for testing purposes only
    //<< ; until Price Plan is fully functional.
    //<< ;
    //<< ; Params:   pidCompany - company id
    //<< ;           pblnChecked - whether to check/uncheck  - defaults to uncheck
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 15-Jan-2007   JW      SR15274: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objINVORG,strMessage,strStatus,YM
    mVar objINVORG = m$.var("objINVORG");
    mVar strMessage = m$.var("strMessage");
    mVar strStatus = m$.var("strStatus");
    mVar YM = m$.var("YM");
    m$.newVar(objINVORG,strMessage,strStatus,YM);
    //<< 
    //<< quit:($get(pidCompany)="") "Please enter a valid company id"     ; FIXME : WWW009 text (preset SPRACHE) <GRF>
    if ((mOp.Equal(m$.Fnc.$get(pidCompany),""))) {
      return "Please enter a valid company id";
    }
    //<< quit:('$data(^WWW012(0,pidCompany))) "Please enter a valid company id"
    if ((mOp.Not(m$.Fnc.$data(m$.var("^WWW012",0,pidCompany.get()))))) {
      return "Please enter a valid company id";
    }
    //<< 
    //<< quit:($IO'["|TNT|")||($IO'["|TRM|") "This must be run from either Terminal or Telnet"
    if ((mOp.NotContains(m$.Fnc.$io(),"|TNT|")) || (mOp.NotContains(m$.Fnc.$io(),"|TRM|"))) {
      return "This must be run from either Terminal or Telnet";
    }
    //<< 
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< set YM = pidCompany
    YM.set(pidCompany.get());
    //<< 
    //<< set pblnEnable = $select($get(pblnEnable):$$$YES,1:$$$NO)
    pblnEnable.set(m$.Fnc.$select(m$.Fnc.$get(pblnEnable),include.COMSYS.$$$YES(m$),1,include.COMSYS.$$$NO(m$)));
    //<< 
    //<< set objINVORG = $get(^INVORG(0,0,1))
    objINVORG.set(m$.Fnc.$get(m$.var("^INVORG",0,0,1)));
    //<< 
    //<< if $$$INVORGPricePlan(objINVORG) && pblnEnable {
    if (mOp.Logical(include.INConst.$$$INVORGPricePlan(m$,objINVORG)) && mOp.Logical(pblnEnable.get())) {
      //<< set strMessage = "Price plan already enabled."
      strMessage.set("Price plan already enabled.");
    }
    //<< 
    //<< } elseif '$$$INVORGPricePlan(objINVORG) && 'pblnEnable {
    else if (mOp.Not(include.INConst.$$$INVORGPricePlan(m$,objINVORG)) && mOp.Not(pblnEnable.get())) {
      //<< set strMessage = "Price plan already disabled."
      strMessage.set("Price plan already disabled.");
    }
    //<< 
    //<< } else {
    else {
      //<< set $$$INVORGPricePlan(objINVORG) = pblnEnable
      include.INConst.$$$INVORGPricePlanSet(m$,objINVORG,pblnEnable.get());
      //<< set strStatus = $$$Save("INVORG",0,objINVORG,$$$YES)
      strStatus.set(include.COMSYS.$$$Save(m$,"INVORG",0,objINVORG,include.COMSYS.$$$YES(m$)));
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< set strMessage = "Price plan now "_$select(pblnEnable:"enabled",1:"disabled")_"."
        strMessage.set(mOp.Concat(mOp.Concat("Price plan now ",m$.Fnc.$select(pblnEnable.get(),"enabled",1,"disabled")),"."));
      }
      //<< } else {
      else {
        //<< set strMessage = "Error while updating: "_$$$Text(strStatus)
        strMessage.set(mOp.Concat("Error while updating: ",include.COMSYS.$$$Text(m$,strStatus)));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strMessage
    return strMessage.get();
  }

  //<< 
  //<< 
  //<< OnAfterDataFields()
  public Object OnAfterDataFields() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add an event on the INVORG form.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 24-May-2007   Frank   SRBR14442: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if YSEITE = 2 {
    if (mOp.Equal(m$.var("YSEITE").get(),2)) {
      //<< do InitConsumptionFields()
      m$.Cmd.Do("InitConsumptionFields");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< InitConsumptionFields()
  public Object InitConsumptionFields() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add some behaviour to the consumption fields. If Period type is neither month-specific
    //<< ; not quarter-specific, the field 'Historical Month/Quarter' should be disabled.
    //<< ; If Period Type is Month-Specific the field will be filled with the months of the year,
    //<< ; and if Period Type is Quarter-Specific the field will be filled with the quarters
    //<< ; of the year.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 30-Jun-2009   GRF     Remove order macros; consistancy with other subr.
    //<< ; 24-May-2007   Frank   SRBR14442: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idMonth,idQuarter,idx1,idx2,intPeriodType,intMonthQuarter
    mVar idMonth = m$.var("idMonth");
    mVar idQuarter = m$.var("idQuarter");
    mVar idx1 = m$.var("idx1");
    mVar idx2 = m$.var("idx2");
    mVar intPeriodType = m$.var("intPeriodType");
    mVar intMonthQuarter = m$.var("intMonthQuarter");
    m$.newVar(idMonth,idQuarter,idx1,idx2,intPeriodType,intMonthQuarter);
    //<< new lstMonths,lstQuarters,objMonth,objQuarter,objINVORG
    mVar lstMonths = m$.var("lstMonths");
    mVar lstQuarters = m$.var("lstQuarters");
    mVar objMonth = m$.var("objMonth");
    mVar objQuarter = m$.var("objQuarter");
    mVar objINVORG = m$.var("objINVORG");
    m$.newVar(lstMonths,lstQuarters,objMonth,objQuarter,objINVORG);
    //<< 
    //<< set objINVORG    = $get(^INVORG(0,0,1))
    objINVORG.set(m$.Fnc.$get(m$.var("^INVORG",0,0,1)));
    //<< set intPeriodType   = +$$$INVORGHistoricalPeriodType(objINVORG)
    intPeriodType.set(mOp.Positive(include.INConst.$$$INVORGHistoricalPeriodType(m$,objINVORG)));
    //<< set intMonthQuarter = +$$$INVORGHistoricalMonthQuarter(objINVORG)
    intMonthQuarter.set(mOp.Positive(include.INConst.$$$INVORGHistoricalMonthQuarter(m$,objINVORG)));
    //<< set lstMonths   = ""
    lstMonths.set("");
    //<< set lstQuarters = ""
    lstQuarters.set("");
    //<< 
    //<< // Loading months.
    //<< set idMonth = ""
    idMonth.set("");
    //<< for {
    for (;true;) {
      //<< set idMonth   = $order(^WWW101(0,"COMMONTHSOFYEAR",SPRACHE,idMonth))
      idMonth.set(m$.Fnc.$order(m$.var("^WWW101",0,"COMMONTHSOFYEAR",m$.var("SPRACHE").get(),idMonth.get())));
      //<< quit:idMonth=""
      if (mOp.Equal(idMonth.get(),"")) {
        break;
      }
      //<< 
      //<< set objMonth  = $get(^WWW101(0, "COMMONTHSOFYEAR", SPRACHE, idMonth, 1))
      objMonth.set(m$.Fnc.$get(m$.var("^WWW101",0,"COMMONTHSOFYEAR",m$.var("SPRACHE").get(),idMonth.get(),1)));
      //<< set lstMonths = lstMonths_$listbuild($$$WWW101Text(objMonth))
      lstMonths.set(mOp.Concat(lstMonths.get(),m$.Fnc.$listbuild(include.WWWConst.$$$WWW101Text(m$,objMonth))));
    }
    //<< }
    //<< 
    //<< // Loading quarters.
    //<< set idQuarter = ""
    idQuarter.set("");
    //<< for {
    for (;true;) {
      //<< set idQuarter = $order(^WWW101(0,"COMQUARTER",SPRACHE,idQuarter))
      idQuarter.set(m$.Fnc.$order(m$.var("^WWW101",0,"COMQUARTER",m$.var("SPRACHE").get(),idQuarter.get())));
      //<< quit:idQuarter=""
      if (mOp.Equal(idQuarter.get(),"")) {
        break;
      }
      //<< 
      //<< set objQuarter = $get(^WWW101(0, "COMQUARTER", SPRACHE, idQuarter, 1))
      objQuarter.set(m$.Fnc.$get(m$.var("^WWW101",0,"COMQUARTER",m$.var("SPRACHE").get(),idQuarter.get(),1)));
      //<< set lstQuarters = lstQuarters_$listbuild($$$WWW101Text(objQuarter))
      lstQuarters.set(mOp.Concat(lstQuarters.get(),m$.Fnc.$listbuild(include.WWWConst.$$$WWW101Text(m$,objQuarter))));
    }
    //<< }
    //<< 
    //<< write "<script language=""Javascript"">",!
    m$.Cmd.Write("<script language=\"Javascript\">","\n");
    //<< &html<
    //<< arrMonths = new Array();
    //<< arrQuarters = new Array();
    //<< function initConsumptionFields() {
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("        arrMonths = new Array();","\n");
    m$.Cmd.WriteHtml("        arrQuarters = new Array();","\n");
    m$.Cmd.WriteHtml("        function initConsumptionFields() {","\n");
    m$.Cmd.WriteHtml("    ");
    //<< for idx1 = 1 : 1 : $listlength(lstMonths) {
    for (idx1.set(1);(mOp.LessOrEqual(idx1.get(),m$.Fnc.$listlength(lstMonths.get())));idx1.set(mOp.Add(idx1.get(),1))) {
      //<< &html<  arrMonths[arrMonths.length] = '#($list(lstMonths, idx1))#';>
      m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("  arrMonths[arrMonths.length] = '",(m$.Fnc.$list(lstMonths.get(),idx1.get()))),"';"));
    }
    //<< }
    //<< 
    //<< for idx2 = 1 : 1 : $listlength(lstQuarters) {
    for (idx2.set(1);(mOp.LessOrEqual(idx2.get(),m$.Fnc.$listlength(lstQuarters.get())));idx2.set(mOp.Add(idx2.get(),1))) {
      //<< &html<  arrQuarters[arrQuarters.length] = '#($list(lstQuarters, idx2))#';>
      m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("  arrQuarters[arrQuarters.length] = '",(m$.Fnc.$list(lstQuarters.get(),idx2.get()))),"';"));
    }
    //<< }
    //<< 
    //<< &html<
    //<< checkPeriodType();
    //<< }
    //<< function checkPeriodType() {
    //<< if (WWW2.YINVORGD233.selectedIndex == #($$$EnumINHISTORICALPERIODTYPEMonthSpecific)#) {
    //<< setMonth();
    //<< } else if (WWW2.YINVORGD233.selectedIndex == #($$$EnumINHISTORICALPERIODTYPEQuarterSpecific)#) {
    //<< setQuarter();
    //<< } else {
    //<< disableMonthQuarter();
    //<< }
    //<< }
    //<< 
    //<< function disableMonthQuarter() {
    //<< clearMonthQuarter();
    //<< WWW2.YINVORGD235.disabled = true;
    //<< }
    //<< 
    //<< function clearMonthQuarter() {
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("            checkPeriodType();","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        function checkPeriodType() {","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            if (WWW2.YINVORGD233.selectedIndex == ",(include.INConst.$$$EnumINHISTORICALPERIODTYPEMonthSpecific(m$))),") {"),"\n");
    m$.Cmd.WriteHtml("                setMonth();","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            } else if (WWW2.YINVORGD233.selectedIndex == ",(include.INConst.$$$EnumINHISTORICALPERIODTYPEQuarterSpecific(m$))),") {"),"\n");
    m$.Cmd.WriteHtml("                setQuarter();","\n");
    m$.Cmd.WriteHtml("            } else {","\n");
    m$.Cmd.WriteHtml("                disableMonthQuarter();","\n");
    m$.Cmd.WriteHtml("            }","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        ","\n");
    m$.Cmd.WriteHtml("        function disableMonthQuarter() {","\n");
    m$.Cmd.WriteHtml("            clearMonthQuarter();","\n");
    m$.Cmd.WriteHtml("            WWW2.YINVORGD235.disabled = true;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        ","\n");
    m$.Cmd.WriteHtml("        function clearMonthQuarter() {","\n");
    m$.Cmd.WriteHtml("    ");
    //<< write "         for (var idx = WWW2.YINVORGD235.length - 1; idx >= 0; idx--) {",!
    m$.Cmd.Write("         for (var idx = WWW2.YINVORGD235.length - 1; idx >= 0; idx--) {","\n");
    //<< &html<      WWW2.YINVORGD235.options[idx] = null;
    //<< }
    //<< }
    //<< 
    //<< function setMonth() {
    //<< clearMonthQuarter();
    //<< WWW2.YINVORGD235.options[0] = new Option(" ", 0);
    //<< >
    m$.Cmd.WriteHtml("      WWW2.YINVORGD235.options[idx] = null;","\n");
    m$.Cmd.WriteHtml("            }       ","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        ","\n");
    m$.Cmd.WriteHtml("        function setMonth() {","\n");
    m$.Cmd.WriteHtml("            clearMonthQuarter();","\n");
    m$.Cmd.WriteHtml("            WWW2.YINVORGD235.options[0] = new Option(\" \", 0);","\n");
    m$.Cmd.WriteHtml("    ");
    //<< 
    //<< write "     for (var idx = 1; idx <= arrMonths.length; idx++) { "
    m$.Cmd.Write("     for (var idx = 1; idx <= arrMonths.length; idx++) { ");
    //<< &html<
    //<< WWW2.YINVORGD235.options[idx] = new Option(arrMonths[idx - 1], idx);
    //<< WWW2.YINVORGD235.disabled = false;
    //<< }
    //<< }
    //<< 
    //<< function setQuarter() {
    //<< clearMonthQuarter();
    //<< WWW2.YINVORGD235.options[0] = new Option(" ", 0);
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("                    WWW2.YINVORGD235.options[idx] = new Option(arrMonths[idx - 1], idx);","\n");
    m$.Cmd.WriteHtml("                    WWW2.YINVORGD235.disabled = false;","\n");
    m$.Cmd.WriteHtml("                }","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        ","\n");
    m$.Cmd.WriteHtml("        function setQuarter() {","\n");
    m$.Cmd.WriteHtml("            clearMonthQuarter();","\n");
    m$.Cmd.WriteHtml("            WWW2.YINVORGD235.options[0] = new Option(\" \", 0);","\n");
    m$.Cmd.WriteHtml("    ");
    //<< 
    //<< write "     for (var idx = 1; idx <= arrQuarters.length; idx++) { "
    m$.Cmd.Write("     for (var idx = 1; idx <= arrQuarters.length; idx++) { ");
    //<< &html<
    //<< WWW2.YINVORGD235.options[idx] = new Option(arrQuarters[idx - 1], idx);
    //<< WWW2.YINVORGD235.disabled = false;
    //<< }
    //<< }
    //<< initConsumptionFields();
    //<< if ((#(intPeriodType)# == #($$$EnumINHISTORICALPERIODTYPEMonthSpecific)#) ||
    //<< (#(intPeriodType)# == #($$$EnumINHISTORICALPERIODTYPEQuarterSpecific)#)) {
    //<< 
    //<< WWW2.YINVORGD235.selectedIndex = #(intMonthQuarter)#;
    //<< }
    //<< WWW2.YINVORGD233.onchange = checkPeriodType;
    //<< </script>
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("                    WWW2.YINVORGD235.options[idx] = new Option(arrQuarters[idx - 1], idx);","\n");
    m$.Cmd.WriteHtml("                    WWW2.YINVORGD235.disabled = false;","\n");
    m$.Cmd.WriteHtml("                }","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        initConsumptionFields();","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("        if ((",(intPeriodType.get()))," == "),(include.INConst.$$$EnumINHISTORICALPERIODTYPEMonthSpecific(m$))),") || "),"\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("            (",(intPeriodType.get()))," == "),(include.INConst.$$$EnumINHISTORICALPERIODTYPEQuarterSpecific(m$))),")) {"),"\n");
    m$.Cmd.WriteHtml("                ","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            WWW2.YINVORGD235.selectedIndex = ",(intMonthQuarter.get())),";   "),"\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        WWW2.YINVORGD233.onchange = checkPeriodType;","\n");
    m$.Cmd.WriteHtml("        </script>","\n");
    m$.Cmd.WriteHtml("    ");
    //<< quit
    return null;
  }

//<< 
//<< 
}
