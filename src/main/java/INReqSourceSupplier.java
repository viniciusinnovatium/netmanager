//*****************************************************************************
//** TASC - ALPHALINC - MAC INReqSourceSupplier
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 14:12:03
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
//<< #include INConst
import include.INConst;

//<< INReqSourceSupplier
public class INReqSourceSupplier extends mClass {

  public void main() {
    _INReqSourceSupplier();
  }

  public void _INReqSourceSupplier() {
  }

  //<< 
  //<< OnBeforeDataAccess(pYKEY,pYUSER)
  public Object OnBeforeDataAccess(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYUSER = m$.newVarRef("pYUSER",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; In COMView, show just suppliers from item selected
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Jan-2008   GM          SRBR014818: fixed errors - parameters and result for
    //<< ;                               CheckSuppliers
    //<< ; 17-Dec-2007   GM/Shobby   SRBR014818: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if YFORM="INReqSourceLine" {
    if (mOp.Equal(m$.var("YFORM").get(),"INReqSourceLine")) {
      //<< set strStatus = $$CheckSuppliers(pYKEY,+YUSER)
      strStatus.set(m$.fnc$("CheckSuppliers",pYKEY.get(),mOp.Positive(m$.var("YUSER").get())));
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< CheckSuppliers(pidSupplier,YUSER=0)
  public Object CheckSuppliers(Object ... _p) {
    mVar pidSupplier = m$.newVarRef("pidSupplier",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YUSER = m$.newVarRef("YUSER",(((_p!=null)&&(_p.length>=2))?_p[1]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; In COMView, get suppliers from item selected
    //<< ;
    //<< ; Params:
    //<< ;   pidSupplier     Supplier Key
    //<< ;   YUSER
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Feb-2008   GRF     SRBR014818: Error text updated; removed blnRequiresHasNone
    //<< ; 19-Feb-2008   GM      SRBR014818: Changed results to return error messages
    //<< ; 15-Feb-2008   GRF     SRBR014818: no need to use idSupplier *AND* pYKEY;
    //<< ;                           YUSER default to 0 rather than null to avoid
    //<< ;                           possible SUBSCRIPT error; unused variables removed
    //<< ;                           from new list.
    //<< ; 22-Jan-2008   GM      SRBR014818: fixed errors - parameters and result
    //<< ; 07-Jan-2008   GM      SRBR014818: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnHasNoAgreement,blnRequiresAgreement,idItem,objLine,intRow,idYKEY,strStatus
    mVar blnHasNoAgreement = m$.var("blnHasNoAgreement");
    mVar blnRequiresAgreement = m$.var("blnRequiresAgreement");
    mVar idItem = m$.var("idItem");
    mVar objLine = m$.var("objLine");
    mVar intRow = m$.var("intRow");
    mVar idYKEY = m$.var("idYKEY");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnHasNoAgreement,blnRequiresAgreement,idItem,objLine,intRow,idYKEY,strStatus);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set idItem=""
    idItem.set("");
    //<< set intRow = $piece($piece($get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","FOCUSFIELD")),"Y",2),"_",1)
    intRow.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),m$.var("YFORM").get(),"V","FOCUSFIELD")),"Y",2),"_",1));
    //<< if intRow'="" {
    if (mOp.NotEqual(intRow.get(),"")) {
      //<< set idYKEY = $$GetYKEY^COMGridEdit31Interface(intRow)
      idYKEY.set(m$.fnc$("COMGridEdit31Interface.GetYKEY",intRow.get()));
      //<< set objLine = $$$GRIDGetYFELD(idYKEY)
      objLine.set(include.COMGridEdit31Interface.$$$GRIDGetYFELD(m$,idYKEY));
      //<< set idItem  = $$$INRequisitionItem(objLine)
      idItem.set(include.INConst.$$$INRequisitionItem(m$,objLine));
      //<< set blnRequiresAgreement = $$RequiresMasterAgreement^INReqSourceLine(objLine)
      blnRequiresAgreement.set(m$.fnc$("INReqSourceLine.RequiresMasterAgreement",objLine.get()));
      //<< set blnHasNoAgreement    = $$HasNoMasterAgreements^INReqSourceLine(objLine)      ; no ^INSupMastAgreeItem for item
      blnHasNoAgreement.set(m$.fnc$("INReqSourceLine.HasNoMasterAgreements",objLine.get()));
    }
    //<< }
    //<< 
    //<< ; **************************************  vvvvv  <GRF> I BELIEVE THAT THIS CODE
    //<< 
    //<< if idItem="" {
    if (mOp.Equal(idItem.get(),"")) {
      //<< set strStatus = $$$MakeStatus("IN00832")  ; "Item number is empty"
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00832"));
    }
    //<< 
    //<< ; FIXME : <GRF> In routine INReqSourceTable this test is only considered when we
    //<< ;               don't have a required agreement.  Is it even relevant in its
    //<< ;      vvv      current state?
    //<< ;
    //<< } elseif '$data(^INARTK(YM,idItem,pidSupplier)) {
    else if (mOp.Not(m$.Fnc.$data(m$.var("^INARTK",m$.var("YM").get(),idItem.get(),pidSupplier.get())))) {
      //<< set strStatus = $$$MakeStatus("IN00834",pidSupplier,idItem)  ; "'Supplier %1 does not have any conditions for item %2."
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00834",pidSupplier,idItem));
    }
    //<< 
    //<< } elseif ('blnRequiresAgreement) && ('blnHasNoAgreement) {  ; Case 3 in logic review at end of routine
    else if ((mOp.Not(blnRequiresAgreement.get())) && (mOp.Not(blnHasNoAgreement.get()))) {
      //<< if '$$CanSourceReqs^INLIEF(pidSupplier) {
      if (mOp.Not(m$.fnc$("INLIEF.CanSourceReqs",pidSupplier.get()))) {
        //<< set strStatus = $$$MakeStatus("IN00836",pidSupplier)  ; "Can not source requisitions for supplier %1"
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00836",pidSupplier));
      }
      //<< } else {
      else {
        //<< set strStatus = $$$OK
        strStatus.set(include.COMSYS.$$$OK(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; **************************************  vvvvv  SHOULD BE REPLACED WITH THIS
    //<< 
    //<< /*
    //<< 
    //<< ; vvv Note : "not" Emergency rather than just Emergency
    //<< set blnRequiresHasNone   = (blnRequiresAgreement && blnHasNoAgreement && '$$$INRequisitionEmergency(objLine))
    //<< 
    //<< if idItem="" {
    //<< set strStatus = $$$MakeStatus("IN00832")  ; "Item number is empty"
    //<< 
    //<< ; vvv Still subject to FIXME from above vvv
    //<< } elseif '$data(^INARTK(YM,idItem,pidSupplier)) {
    //<< set strStatus = $$$MakeStatus("IN00834",pidSupplier,idItem)  ; "'Supplier %1 does not have any conditions for item %2."
    //<< 
    //<< ; vvv replace INxxxxx with valid text vvv
    //<< } elseif blnRequiresHasNone {   ; Case 2
    //<< set strStatus = $$$MakeStatus("INxxxxx",idItem,pidSupplier)   ; "Agreement is required for item %1 and supplier %2."
    //<< 
    //<< } elseif '$$CanSourceReqs^INLIEF(pidSupplier) {   ; Cases 1, 3 and 4 + Case 2 with Emergency Over-ride
    //<< set strStatus = $$$MakeStatus("IN00836",pidSupplier)  ; "Can not source requisitions for supplier %1"
    //<< }
    //<< */
    //<< ; **************************************  ^^^^^
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
//<< 
//<< /*
//<< ;---------------------------------------
//<< FIXME : <GRF>   Logic Review
//<< 
//<< Requires Agreement?
//<< YES         NO
//<< -----------------       blnHasNoAgreement
//<< Have        YES :   1. GOOD     3. GOOD         = NO
//<< Agreement?  NO  :   2. BAD      4. GOOD         = YES
//<< 
//<< What is special about 3 compared to 1 and 4?
//<< 
//<< Shouldn't we be looking to reject case 2 and then applying the extra test to
//<< either all three of the others or to perhaps just 3 and 4?
//<< 
//<< Case 2 is the option which needs to be rechecked to see if an emergency exists.
//<< In that case it too would become "GOOD" and would need to have the extra test
//<< applied as well.
//<< 
//<< ----------------
//<< Routine INReqSourceTable reviews suppliers in either ^INSupMastAgreeItems or
//<< ^INARTK.
//<< 
//<< ^INARTK exists check
//<< If we don't have a record in ^INSupMastAgreeItems when we need one we may get
//<< the required information from ^INARTK.
//<< Thus
//<< 
//<< 
//<< 
//<< ;---------------------------------------
//<< */
//<< 
//<< 
//<< /*
//<< From INReqSourceTable
//<< ; Case A.  There is
//<< ;
//<< 
//<< set blnRequiresAgreement = $$RequiresMasterAgreement^INReqSourceLine(objLine)
//<< set blnHasNoAgreement    = $$HasNoMasterAgreements^INReqSourceLine(objLine)
//<< set blnRequiresHasNone   = (blnRequiresAgreement && blnHasNoAgreement && '$$$INRequisitionEmergency(objLine))
//<< 
//<< kill ^CacheTempSupplierOmit(YUCI,YUSER)
//<< 
//<< $$$Order4(^INSupMastAgreeItems,YM,5,idxItem,idSupplier)
//<< if '$$CanSourceReqs^INLIEF(idSupplier) {
//<< set ^CacheTempSupplierOmit(YUCI,YUSER,idSupplier) = ""
//<< } else {
//<< if blnRequiresHasNone && ($get(^INARTK(YM,idItem,idSupplier,1)) '= "") {
//<< set ^CacheTempSupplierOmit(YUCI,YUSER,idSupplier) = ""
//<< if $$CanSourceReqs^INLIEF(idSupplier) do SupplierLine^DUMMY(idItem,idSupplier,.idLine,blnHide)
//<< }
//<< }
//<< $$$End
//<< 
//<< if ('blnRequiresAgreement) || blnRequiresHasNone {
//<< $$$Order3(^INARTK,YM,idItem,idSupplier)
//<< continue:$data(^CacheTempSupplierOmit(YUCI,YUSER,idSupplier))
//<< do SupplierLine^DUMMY(idItem,idSupplier,.idLine,blnHide)
//<< $$$End
//<< }
//<< QUIT
//<< */
//<< 
}
