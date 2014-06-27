//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTPACK
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 20:46:52
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
//<< #include INConst
import include.INConst;

//<< INARTPACK
public class INARTPACK extends mClass {

  //<< 
  //<< #define FORMFldINARTPACKIsBaseUnit      11
  public static Object $$$FORMFldINARTPACKIsBaseUnit(mContext m$) {
    return (11);
  }

  //<< #define FORMFldINARTPACKIsInventoryUnit 12
  public static Object $$$FORMFldINARTPACKIsInventoryUnit(mContext m$) {
    return (12);
  }

  //<< #define FORMFldINARTPACKIsObsolete      13
  public static Object $$$FORMFldINARTPACKIsObsolete(mContext m$) {
    return (13);
  }

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogRx(%1)       ;
  public static Object $$$LogRx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogRm(%1)       ;
  public static Object $$$LogRm(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _INARTPACK();
  }

  public void _INARTPACK() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^INARTPACK("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< IsValid(pidItem="",pidUnit="",pidCurrentUnit="")
  public Object IsValid(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidUnit = m$.newVarRef("pidUnit",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pidCurrentUnit = m$.newVarRef("pidCurrentUnit",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By: OnBeforeDataAccess^INARTOBDA
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2010   GRF     SR17243: New INARTPACK records may be empty - test '$d
    //<< ; 28-Jan-2010   shobby  SR17138: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objINARTPACK,strStatus
    mVar objINARTPACK = m$.var("objINARTPACK");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objINARTPACK,strStatus);
    //<< 
    //<< set strStatus = $$$NO     ; FIXME : include explanation or isn't message needed?
    strStatus.set(include.COMSYS.$$$NO(m$));
    //<< if (pidItem'="") && (pidUnit'="") {
    if ((mOp.NotEqual(pidItem.get(),"")) && (mOp.NotEqual(pidUnit.get(),""))) {
      //<< set strStatus = $$$OK
      strStatus.set(include.COMSYS.$$$OK(m$));
      //<< set objINARTPACK = $get(^INARTPACK(0,pidItem,pidUnit,1))
      objINARTPACK.set(m$.Fnc.$get(m$.var("^INARTPACK",0,pidItem.get(),pidUnit.get(),1)));
      //<< ;   if (objINARTPACK="") {   ; SR17243
      //<< if '$data(^INARTPACK(0,pidItem,pidUnit,1)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^INARTPACK",0,pidItem.get(),pidUnit.get(),1)))) {
        //<< set strStatus = $$$MakeStatus("IN01178",pidUnit,pidItem)  ; "Unit '%1' is not associated with Item '%2'."
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN01178",pidUnit,pidItem));
      }
      //<< 
      //<< } elseif $$$INARTPACKIsObsolete(objINARTPACK) {
      else if (mOp.Logical(include.INConst.$$$INARTPACKIsObsolete(m$,objINARTPACK))) {
        //<< ; Show obsolete unit if it is the currently selected unit.
        //<< set strStatus = (pidUnit=pidCurrentUnit)
        strStatus.set((mOp.Equal(pidUnit.get(),pidCurrentUnit.get())));
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< IsBaseUnit(pYKEY)
  public Object IsBaseUnit(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Feb-2010   shobby  SR17138: Check with $$$NoKey
    //<< ;-------------------------------------------------------------------------------
    //<< new blnIsBaseUnit,idItem,objItem
    mVar blnIsBaseUnit = m$.var("blnIsBaseUnit");
    mVar idItem = m$.var("idItem");
    mVar objItem = m$.var("objItem");
    m$.newVar(blnIsBaseUnit,idItem,objItem);
    //<< 
    //<< set blnIsBaseUnit = $$$NO
    blnIsBaseUnit.set(include.COMSYS.$$$NO(m$));
    //<< if '$$$NoKey(pYKEY) {               ;SR17138
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pYKEY))) {
      //<< set idItem  = $$$KEY1(pYKEY)
      idItem.set(include.COMSYSWWW.$$$KEY1(m$,pYKEY));
      //<< set objItem = $get(^INART(0,idItem,1))
      objItem.set(m$.Fnc.$get(m$.var("^INART",0,idItem.get(),1)));
      //<< if $$$INARTBaseUnit(objItem) = $$$KEY2(pYKEY) {
      if (mOp.Equal(include.INConst.$$$INARTBaseUnit(m$,objItem),include.COMSYSWWW.$$$KEY2(m$,pYKEY))) {
        //<< set blnIsBaseUnit = $$$YES
        blnIsBaseUnit.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnIsBaseUnit
    return blnIsBaseUnit.get();
  }

  //<< 
  //<< 
  //<< IsInventoryUnit(pYKEY)
  public Object IsInventoryUnit(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Does this record match the Inventory Unit on the INART
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Jan-2010   shobby  SR17119: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idItem,objItem,blnIsInventoryUnit
    mVar idItem = m$.var("idItem");
    mVar objItem = m$.var("objItem");
    mVar blnIsInventoryUnit = m$.var("blnIsInventoryUnit");
    m$.newVar(idItem,objItem,blnIsInventoryUnit);
    //<< 
    //<< set blnIsInventoryUnit = $$$NO
    blnIsInventoryUnit.set(include.COMSYS.$$$NO(m$));
    //<< if '$$$NoKey(pYKEY) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pYKEY))) {
      //<< set idItem  = $$$KEY1(pYKEY)
      idItem.set(include.COMSYSWWW.$$$KEY1(m$,pYKEY));
      //<< set objItem = $get(^INART(0,idItem,1))
      objItem.set(m$.Fnc.$get(m$.var("^INART",0,idItem.get(),1)));
      //<< if $$$INARTUnitofMeasure(objItem) = $$$KEY2(pYKEY) {
      if (mOp.Equal(include.INConst.$$$INARTUnitofMeasure(m$,objItem),include.COMSYSWWW.$$$KEY2(m$,pYKEY))) {
        //<< set blnIsInventoryUnit = $$$YES
        blnIsInventoryUnit.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnIsInventoryUnit
    return blnIsInventoryUnit.get();
  }

  //<< 
  //<< 
  //<< OnBeforeFormConstruction(YBBN,YKEY)
  public Object OnBeforeFormConstruction(Object ... _p) {
    mVar YBBN = m$.newVarRef("YBBN",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Disable the IsObsolete field if these records are already the Base or Inventory UOM
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Feb-2010   GRF     SR17119: FORMFld macro
    //<< ; 13-Jan-2010   shobby  SR17119: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objINART
    mVar objINART = m$.var("objINART");
    m$.newVar(objINART);
    //<< 
    //<< if YBBN=$$$FORMFldINARTPACKIsObsolete {
    if (mOp.Equal(YBBN.get(),$$$FORMFldINARTPACKIsObsolete(m$))) {
      //<< if '$$$NoKey(YKEY) {
      if (mOp.Not(include.COMSYS.$$$NoKey(m$,YKEY))) {
        //<< set objINART = $get(^INART(0,$$$KEY1(YKEY),1))
        objINART.set(m$.Fnc.$get(m$.var("^INART",0,include.COMSYSWWW.$$$KEY1(m$,YKEY),1)));
        //<< 
        //<< if $$$KEY2(YKEY)=$$$INARTBaseUnit(objINART) {
        if (mOp.Equal(include.COMSYSWWW.$$$KEY2(m$,YKEY),include.INConst.$$$INARTBaseUnit(m$,objINART))) {
          //<< set YHID = 2
          mVar YHID = m$.var("YHID");
          YHID.set(2);
        }
        //<< 
        //<< } elseif $$$KEY2(YKEY)=$$$INARTUnitofMeasure(objINART) {
        else if (mOp.Equal(include.COMSYSWWW.$$$KEY2(m$,YKEY),include.INConst.$$$INARTUnitofMeasure(m$,objINART))) {
          //<< set YHID = 2
          mVar YHID = m$.var("YHID");
          YHID.set(2);
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DefaultVariableInput(pintField,YKEY)
  public Object DefaultVariableInput(Object ... _p) {
    mVar pintField = m$.newVarRef("pintField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Populates the IsBaseUnit and IsInventoryUnit manual fields from INART
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Feb-2010   GRF     SR17119: FORMFld macros
    //<< ; 13-Jan-2010   shobby  SR17119: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnValue
    mVar blnValue = m$.var("blnValue");
    m$.newVar(blnValue);
    //<< 
    //<< if pintField=$$$FORMFldINARTPACKIsBaseUnit      set blnValue = $$IsBaseUnit(YKEY)
    if (mOp.Equal(pintField.get(),$$$FORMFldINARTPACKIsBaseUnit(m$))) {
      blnValue.set(m$.fnc$("IsBaseUnit",YKEY.get()));
    }
    //<< if pintField=$$$FORMFldINARTPACKIsInventoryUnit set blnValue = $$IsInventoryUnit(YKEY)
    if (mOp.Equal(pintField.get(),$$$FORMFldINARTPACKIsInventoryUnit(m$))) {
      blnValue.set(m$.fnc$("IsInventoryUnit",YKEY.get()));
    }
    //<< quit blnValue
    return blnValue.get();
  }

  //<< 
  //<< 
  //<< OnBeforeSaveHook(pYKEY,&pYFELD)
  public Object OnBeforeSaveHook(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Validation, must have 1 record set as Inventory Unit
    //<< ; Verifies that the resultant record does not lead to recursion ie:
    //<< ;   A => B => C => A Is not allowed
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 11-Nov-2010   GRF     SR17243: separate circular ref check for common use
    //<< ; 13-Jan-2010   shobby  SR17119: Removed some code as Base UOM and Inventory UOM
    //<< ;                           are no longer stored on INARTPACK
    //<< ; 13-Mar-2009   HQN     SR16420: no longer checks if inventory unit is an end node
    //<< ; 16-Feb-2009   GRF     SR16347: Some tests should not have been subject to
    //<< ;                           Inner Unit being defined (e.g. Each = 1 Each is not
    //<< ;                           required)
    //<< ; 20-Feb-2009   GRF     SR16347: Obsolete item testing
    //<< ; 16-Feb-2009   GRF     SR16347: Recognise self-referencing entry.
    //<< ; 13-Feb-2009   GRF     SR16347: language text, functionality corrected (PEER)
    //<< ; 12-Feb-2009   HQN     SR16347: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idItem,idInnerUnit,idOuterUnit,strStatus
    mVar idItem = m$.var("idItem");
    mVar idInnerUnit = m$.var("idInnerUnit");
    mVar idOuterUnit = m$.var("idOuterUnit");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idItem,idInnerUnit,idOuterUnit,strStatus);
    //<< 
    //<< set strStatus   = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idItem      = $$$KEY1(pYKEY)
    idItem.set(include.COMSYSWWW.$$$KEY1(m$,pYKEY));
    //<< set idOuterUnit = $$$KEY2(pYKEY)
    idOuterUnit.set(include.COMSYSWWW.$$$KEY2(m$,pYKEY));
    //<< 
    //<< ;---------------------------------------
    //<< ; Linked List Traversal
    //<< ; 1) If inner unit isn't defined for item, we know we can't have circular reference
    //<< ; 2) If next inner unit links back to either of the initial outer or inner
    //<< ;    units indicate we have an error.
    //<< ;
    //<< ; Other Validation  (Index 5 : D15 : Is Inventory Unit)
    //<< ; 1) Inner Unit specified but no multiplier
    //<< ; 2) Saving a record when none are labelled as being the INVENTORY UNIT  ...or...
    //<< ;    Cancelling the INVENTORY UNIT label on a record (Correct procedure
    //<< ;    is to set ANOTHER record to yes and this will remove the setting on
    //<< ;    the previously flagged record.)
    //<< ;---------------------------------------
    //<< ; SR17243 vvv
    //<< set strStatus = $$CheckOneUnit(idItem,idOuterUnit,pYFELD,.idInnerUnit)
    strStatus.set(m$.fnc$("CheckOneUnit",idItem.get(),idOuterUnit.get(),pYFELD.get(),idInnerUnit));
    //<< 
    //<< if $$$ISOK(strStatus) && (idInnerUnit'="") && (+$$$INARTPACKQuantity(pYFELD)=0) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus)) && (mOp.NotEqual(idInnerUnit.get(),"")) && (mOp.Equal(mOp.Positive(include.INConst.$$$INARTPACKQuantity(m$,pYFELD)),0))) {
      //<< set strStatus = $$$MakeStatus("IN00887")
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00887"));
    }
    //<< } ; "Quantity required."
    //<< 
    //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
      //<< if $$$ISOK(strStatus) && ((idInnerUnit'="") && (idInnerUnit'=idOuterUnit)) &&
      //<< '$data(^INARTPACK(0,idItem,idInnerUnit)) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus)) && mOp.Logical(((mOp.NotEqual(idInnerUnit.get(),"")) && (mOp.NotEqual(idInnerUnit.get(),idOuterUnit.get())))) && mOp.Not(m$.Fnc.$data(m$.var("^INARTPACK",0,idItem.get(),idInnerUnit.get())))) {
        //<< new objItem,descItem,descUnit
        mVar objItem = m$.var("objItem");
        mVar descItem = m$.var("descItem");
        mVar descUnit = m$.var("descUnit");
        m$.newVar(objItem,descItem,descUnit);
        //<< set strStatus = '$$$OK
        strStatus.set(mOp.Not(include.COMSYS.$$$OK(m$)));
        //<< 
        //<< set objItem  = $get(^INART(YM,idItem,1))
        objItem.set(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),idItem.get(),1)));
        //<< set descItem = idItem_" - "_$$$INARTSearchName(objItem)
        descItem.set(mOp.Concat(mOp.Concat(idItem.get()," - "),include.INConst.$$$INARTSearchName(m$,objItem)));
        //<< set descUnit = idInnerUnit_ " - "_$$$WWW101Text($$Get^WWW101("EINHEIT",SPRACHE,idInnerUnit))
        descUnit.set(mOp.Concat(mOp.Concat(idInnerUnit.get()," - "),include.WWWConst.$$$WWW101Text(m$,m$.fnc$("WWW101.Get","EINHEIT",m$.var("SPRACHE").get(),idInnerUnit.get()))));
        //<< 
        //<< $$$StartScript()
        include.COMSYS.$$$StartScript(m$);
        //<< write "alert('"_$$$Text($$$MakeStatus("IN01801",descUnit,descItem))_"')"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('",include.COMSYS.$$$Text(m$,include.COMSYS.$$$MakeStatus(m$,"IN01801",descUnit,descItem))),"')"));
        //<< $$$EndScript()
        include.COMSYS.$$$EndScript(m$);
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< /*
  //<< set idInnerUnit = $$$INARTPACKUnit(pYFELD)    ; Pre-save record
  //<< 
  //<< if (idInnerUnit'="") {
  //<< set idCurUnit = idInnerUnit
  //<< set idLastCur = idCurUnit
  //<< for {
  //<< quit:'$data(^INARTPACK(0,idItem,idCurUnit))
  //<< 
  //<< set idCurUnit = $$$INARTPACKUnit($get(^INARTPACK(0,idItem,idCurUnit,1)))
  //<< quit:idCurUnit=""
  //<< quit:idCurUnit=idLastCur              ; self referencing is okay - go no further
  //<< 
  //<< set idLastCur = idCurUnit
  //<< if (idCurUnit = idInnerUnit) || (idCurUnit = idOuterUnit) {
  //<< set strStatus = $$$MakeStatus("IN00849")        ; "A circular reference has been detected."
  //<< quit
  //<< }
  //<< }
  //<< 
  //<< if $$$ISOK(strStatus) && (+$$$INARTPACKQuantity(pYFELD)=0) {
  //<< set strStatus = $$$MakeStatus("IN00887")            ; "Quantity required."
  //<< }
  //<< }
  //<< quit strStatus
  //<< */
  //<< ; SR17243 ^^^
  //<< 
  //<< 
  //<< OnAfterSaveHook(pYKEY,&pYFELD)
  public Object OnAfterSaveHook(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Ensures that there will always be an end node defined,
    //<< ; clears other INARTPACK fields for Inventory/base if this record has
    //<< ; IsInventory/IsBase set
    //<< ; Updates INART record if Inventory/Base set
    //<< ;
    //<< ; History:
    //<< ; 13-Jan-2010   shobby  SR17119: Removed some code as Base UOM and Inventory UOM
    //<< ;                           are no longer stored on INARTPACK
    //<< ; 18-Aug-2009   DWR     SR16843: added validation and resetting of Pack Unit
    //<< ; 12-Feb-2009   HQN     SR16347: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idInnerUnit,idItem,idOuterUnit,idUnit,objPackage,strStatus
    mVar idInnerUnit = m$.var("idInnerUnit");
    mVar idItem = m$.var("idItem");
    mVar idOuterUnit = m$.var("idOuterUnit");
    mVar idUnit = m$.var("idUnit");
    mVar objPackage = m$.var("objPackage");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idInnerUnit,idItem,idOuterUnit,idUnit,objPackage,strStatus);
    //<< 
    //<< set strStatus       = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idItem          = $$$KEY1(pYKEY)
    idItem.set(include.COMSYSWWW.$$$KEY1(m$,pYKEY));
    //<< set idOuterUnit     = $$$KEY2(pYKEY)
    idOuterUnit.set(include.COMSYSWWW.$$$KEY2(m$,pYKEY));
    //<< set idInnerUnit     = $$$INARTPACKUnit(pYFELD)
    idInnerUnit.set(include.INConst.$$$INARTPACKUnit(m$,pYFELD));
    //<< //set objItem         = $get(^INART(0,idItem,1))
    //<< //set blnItemModified = $$$NO
    //<< 
    //<< ; End node definition
    //<< if (idInnerUnit'="") && '$data(^INARTPACK(0,idItem,idInnerUnit)) {
    if ((mOp.NotEqual(idInnerUnit.get(),"")) && mOp.Not(m$.Fnc.$data(m$.var("^INARTPACK",0,idItem.get(),idInnerUnit.get())))) {
      //<< set strStatus = $$$Save("INARTPACK",idItem_$$$COMMA_idInnerUnit,"",$$$YES)
      strStatus.set(include.COMSYS.$$$Save(m$,"INARTPACK",mOp.Concat(mOp.Concat(idItem.get(),include.COMSYSString.$$$COMMA(m$)),idInnerUnit.get()),"",include.COMSYS.$$$YES(m$)));
    }
    //<< }
    //<< 
    //<< ; Clear any other Pack Unit entries if stating that this entry is the Pack Unit
    //<< ;---------------------------------------
    //<< if $$$ISOK(strStatus) && ($$$INARTPACKIsPackUnit(pYFELD) = $$$YES) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus)) && (mOp.Equal(include.INConst.$$$INARTPACKIsPackUnit(m$,pYFELD),include.COMSYS.$$$YES(m$)))) {
      //<< set idUnit = ""
      idUnit.set("");
      //<< for {
      for (;true;) {
        //<< set idUnit = $order(^INARTPACKs(0,6,$$$YES,idItem,idUnit))
        idUnit.set(m$.Fnc.$order(m$.var("^INARTPACKs",0,6,include.COMSYS.$$$YES(m$),idItem.get(),idUnit.get())));
        //<< quit:idUnit=""
        if (mOp.Equal(idUnit.get(),"")) {
          break;
        }
        //<< continue:idUnit=idOuterUnit
        if (mOp.Equal(idUnit.get(),idOuterUnit.get())) {
          continue;
        }
        //<< 
        //<< set objPackage = $get(^INARTPACK(0,idItem,idUnit,1))
        objPackage.set(m$.Fnc.$get(m$.var("^INARTPACK",0,idItem.get(),idUnit.get(),1)));
        //<< set $$$INARTPACKIsPackUnit(objPackage) = ""        ; @nM $$$NO
        include.INConst.$$$INARTPACKIsPackUnitSet(m$,objPackage,"");
        //<< set strStatus = $$$Save("INARTPACK",idItem_$$$COMMA_idUnit,objPackage,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"INARTPACK",mOp.Concat(mOp.Concat(idItem.get(),include.COMSYSString.$$$COMMA(m$)),idUnit.get()),objPackage,include.COMSYS.$$$YES(m$)));
        //<< quit:$$$ISERR(strStatus)
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
          break;
        }
      }
    }
    //<< }
    //<< //Do not update Inventory Unit
    //<< //if $$$INARTUnitofMeasure(objItem) '= idOuterUnit {
    //<< //  set $$$INARTUnitofMeasure(objItem) = idOuterUnit
    //<< //  set blnItemModified = $$$YES
    //<< //}
    //<< }
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnBeforeDeleteHook(pYKEY,&pYFELD)
  public Object OnBeforeDeleteHook(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Do not delete entries set as Inventory Unit or Base Unit on Item Master Data
    //<< ;
    //<< ; Called By:
    //<< ;   INARTPACK Class
    //<< ;
    //<< ; History:
    //<< ; 08-Nov-2010   GRF     SR17243: Fix duplicated message no; remove health check
    //<< ;                           record so it is refreshed
    //<< ; 13-Jan-2010   shobby  SR17119: Can't delete Base UOM or Inventory UOM.
    //<< ; 16-fEB-2009   GRF     SR16347: Language Text
    //<< ; 13-Feb-2009   HQN     SR16347: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,objINART
    mVar strStatus = m$.var("strStatus");
    mVar objINART = m$.var("objINART");
    m$.newVar(strStatus,objINART);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if '$$$NoKey(pYKEY) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pYKEY))) {
      //<< set objINART=$get(^INART(0,$$$KEY1(pYKEY),1))
      objINART.set(m$.Fnc.$get(m$.var("^INART",0,include.COMSYSWWW.$$$KEY1(m$,pYKEY),1)));
      //<< if $$$INARTUnitofMeasure(objINART)=$$$KEY2(pYKEY) {
      if (mOp.Equal(include.INConst.$$$INARTUnitofMeasure(m$,objINART),include.COMSYSWWW.$$$KEY2(m$,pYKEY))) {
        //<< set strStatus = $$$MakeStatus("IN00890")
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00890"));
      }
      //<< ; "Unable to delete the unit marked as the Inventory Unit"
      //<< 
      //<< } elseif $$$INARTBaseUnit(objINART)=$$$KEY2(pYKEY)&&('+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
      else if (mOp.Equal(include.INConst.$$$INARTBaseUnit(m$,objINART),include.COMSYSWWW.$$$KEY2(m$,pYKEY)) && (mOp.Not(mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
        //<< set strStatus = $$$MakeStatus("IN01275")              ; SR17243
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN01275"));
      }
    }
    //<< } ; "Unable to delete the unit marked as the Base Unit"
    //<< }
    //<< kill ^CacheTempHealthCheck(YUSER,"INARTPACK")   ; SR17243
    m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK").kill();
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnBeforeDeletePossible(pYKEY,&pYFELD)
  public Object OnBeforeDeletePossible(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Do not delete entries marked as Inventory/Base Unit
    //<< ;
    //<< ; Called By:
    //<< ;   INARTPACK Form
    //<< ;
    //<< ; History:
    //<< ; 16-Feb-2009   GRF     SR16347: Rename; don't return value; pass pYFELD as byRef
    //<< ; 13-Feb-2009   HQN     SR16347: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$OnBeforeDeleteHook^INARTPACK(pYKEY,.pYFELD)
    strStatus.set(m$.fnc$("INARTPACK.OnBeforeDeleteHook",pYKEY.get(),pYFELD));
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set Q = $$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
      //<< $$$YQHandler(strStatus)
      include.COMSYS.$$$YQHandler(m$,strStatus);
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ItemUnits(pidItem)
  public Object ItemUnits(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 16-Feb-2009   GRF     SR16347: Created to improve INART presentation
    //<< ;-------------------------------------------------------------------------------
    //<< new fltMultiplier,idInnerUnit,idUnit,objPack,strInner
    mVar fltMultiplier = m$.var("fltMultiplier");
    mVar idInnerUnit = m$.var("idInnerUnit");
    mVar idUnit = m$.var("idUnit");
    mVar objPack = m$.var("objPack");
    mVar strInner = m$.var("strInner");
    m$.newVar(fltMultiplier,idInnerUnit,idUnit,objPack,strInner);
    //<< 
    //<< kill ^COMTempList(0,YUSER,"INARTPACK")
    m$.var("^COMTempList",0,m$.var("YUSER").get(),"INARTPACK").kill();
    //<< 
    //<< if (pidItem'="") && $data(^INARTPACK(0,pidItem)) {
    if ((mOp.NotEqual(pidItem.get(),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^INARTPACK",0,pidItem.get())))) {
      //<< set idUnit = ""
      idUnit.set("");
      //<< for {
      for (;true;) {
        //<< set idUnit = $order(^INARTPACK(0,pidItem,idUnit))
        idUnit.set(m$.Fnc.$order(m$.var("^INARTPACK",0,pidItem.get(),idUnit.get())));
        //<< quit:idUnit=""
        if (mOp.Equal(idUnit.get(),"")) {
          break;
        }
        //<< 
        //<< set objPack = $get(^INARTPACK(0,pidItem,idUnit,1))
        objPack.set(m$.Fnc.$get(m$.var("^INARTPACK",0,pidItem.get(),idUnit.get(),1)));
        //<< continue:$$$INARTPACKIsObsolete(objPack)
        if (mOp.Logical(include.INConst.$$$INARTPACKIsObsolete(m$,objPack))) {
          continue;
        }
        //<< 
        //<< set fltMultiplier = $$$INARTPACKQuantity(objPack)
        fltMultiplier.set(include.INConst.$$$INARTPACKQuantity(m$,objPack));
        //<< if fltMultiplier="" set fltMultiplier = "?"
        if (mOp.Equal(fltMultiplier.get(),"")) {
          fltMultiplier.set("?");
        }
        //<< set idInnerUnit   = $$$INARTPACKUnit(objPack)
        idInnerUnit.set(include.INConst.$$$INARTPACKUnit(m$,objPack));
        //<< if idInnerUnit = "" {
        if (mOp.Equal(idInnerUnit.get(),"")) {
          //<< set strInner = ""
          strInner.set("");
        }
        //<< } else {
        else {
          //<< set strInner = " = "_fltMultiplier_" "_$$$AppEnum("EINHEIT",idInnerUnit)
          strInner.set(mOp.Concat(mOp.Concat(mOp.Concat(" = ",fltMultiplier.get())," "),include.COMSYSWWW.$$$AppEnum(m$,"EINHEIT",idInnerUnit)));
        }
        //<< }
        //<< 
        //<< set ^COMTempList(0,YUSER,"INARTPACK",idUnit,1) = $$$AppEnum("EINHEIT",idUnit)_Y_strInner
        m$.var("^COMTempList",0,m$.var("YUSER").get(),"INARTPACK",idUnit.get(),1).set(mOp.Concat(mOp.Concat(include.COMSYSWWW.$$$AppEnum(m$,"EINHEIT",idUnit),m$.var("Y").get()),strInner.get()));
      }
    }
    //<< }
    //<< 
    //<< } else {    ; FIXME : Does INART update INARTPACK for base unit? May need to access INARTPACK *BEFORE* able to enter this data. <GRF>
    else {
      //<< set idUnit = ""
      idUnit.set("");
      //<< for {
      for (;true;) {
        //<< set idUnit = $order(^WWW101(0,"EINHEIT","EN",idUnit))
        idUnit.set(m$.Fnc.$order(m$.var("^WWW101",0,"EINHEIT","EN",idUnit.get())));
        //<< quit:idUnit=""
        if (mOp.Equal(idUnit.get(),"")) {
          break;
        }
        //<< 
        //<< set ^COMTempList(0,YUSER,"INARTPACK",idUnit,1) = $$$AppEnum("EINHEIT",idUnit)
        m$.var("^COMTempList",0,m$.var("YUSER").get(),"INARTPACK",idUnit.get(),1).set(include.COMSYSWWW.$$$AppEnum(m$,"EINHEIT",idUnit));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnDataAccess(pidKey,pidForm)
  public Object OnDataAccess(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Whether a Item Unit can be used at this time.
    //<< ;
    //<< ; Called By: INARTPACK Class Call Back
    //<< ;
    //<< ; Params:   pidKey      YKEY
    //<< ;           pidForm     YFORM
    //<< ;
    //<< ; Returns: blnDataAccess
    //<< ;   $$$NO       Item Unit is not marked as Obsolete
    //<< ;   $$$YES      Req is Accessable
    //<< ;
    //<< ; History:
    //<< ; 03-Mar-2009   HQN     SR16407: Corrected variables
    //<< ; 20-Feb-2009   GRF     SR16347: Based on INIssue
    //<< ;-------------------------------------------------------------------------------
    //<< new blnDataAccess,idItem,idUnit,objItemUnit
    mVar blnDataAccess = m$.var("blnDataAccess");
    mVar idItem = m$.var("idItem");
    mVar idUnit = m$.var("idUnit");
    mVar objItemUnit = m$.var("objItemUnit");
    m$.newVar(blnDataAccess,idItem,idUnit,objItemUnit);
    //<< 
    //<< set blnDataAccess = $$$YES
    blnDataAccess.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< set idItem = $$$KEY1(pidKey)
    idItem.set(include.COMSYSWWW.$$$KEY1(m$,pidKey));
    //<< set idUnit = $$$KEY2(pidKey)
    idUnit.set(include.COMSYSWWW.$$$KEY2(m$,pidKey));
    //<< 
    //<< if (idItem'="") && (idUnit'="") {
    if ((mOp.NotEqual(idItem.get(),"")) && (mOp.NotEqual(idUnit.get(),""))) {
      //<< set objItemUnit = $get(^INARTPACK(0,idItem,idUnit,1))
      objItemUnit.set(m$.Fnc.$get(m$.var("^INARTPACK",0,idItem.get(),idUnit.get(),1)));
      //<< set blnDataAccess = ''$$$INARTPACKIsObsolete(objItemUnit)
      blnDataAccess.set(mOp.Not(mOp.Not(include.INConst.$$$INARTPACKIsObsolete(m$,objItemUnit))));
    }
    //<< }
    //<< quit blnDataAccess
    return blnDataAccess.get();
  }

  //<< 
  //<< 
  //<< OnBeforeFormat(YKEY,pobjPack,YART,YLFN,&pstrBGOverride)  ; Code is test mode
  public Object OnBeforeFormat(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjPack = m$.newVarRef("pobjPack",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pstrBGOverride = m$.newVarRef("pstrBGOverride",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Identify pack entries that fail the health check.
    //<< ; Outer Unit Key is coloured yellow and
    //<< ;
    //<< ; Called By: OnBeforeFormat^WWWFORM4 (similar to COMGridEdit CallEvent)
    //<< ;
    //<< ; Inputs :
    //<< ;   YKEY        : idItem,idUnit
    //<< ;   pobjPack    : INARTPACK record
    //<< ;   YART        : "P", "D" (no code)
    //<< ;   YLFN        : Class Field No (not used)
    //<< ;   pstrBGOverride (ByRef)
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 10-Nov-2010   GRF     SR17243: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCircleFound,idItem,idOuterUnit,idInnerUnit,fltQty,strOutUnit,strStatus
    mVar blnCircleFound = m$.var("blnCircleFound");
    mVar idItem = m$.var("idItem");
    mVar idOuterUnit = m$.var("idOuterUnit");
    mVar idInnerUnit = m$.var("idInnerUnit");
    mVar fltQty = m$.var("fltQty");
    mVar strOutUnit = m$.var("strOutUnit");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnCircleFound,idItem,idOuterUnit,idInnerUnit,fltQty,strOutUnit,strStatus);
    //<< 
    //<< set pstrBGOverride = ""
    pstrBGOverride.set("");
    //<< set blnCircleFound = $$$NO
    blnCircleFound.set(include.COMSYS.$$$NO(m$));
    //<< kill YTOOLTIP
    m$.var("YTOOLTIP").kill();
    //<< 
    //<< if (YART="P") {
    if ((mOp.Equal(YART.get(),"P"))) {
      //<< set idItem      = $$$KEY1(YKEY)
      idItem.set(include.COMSYSWWW.$$$KEY1(m$,YKEY));
      //<< set idOuterUnit = $$$KEY2(YKEY)
      idOuterUnit.set(include.COMSYSWWW.$$$KEY2(m$,YKEY));
      //<< set idInnerUnit = $$$INARTPACKUnit(pobjPack)
      idInnerUnit.set(include.INConst.$$$INARTPACKUnit(m$,pobjPack));
      //<< set fltQty      = $$$INARTPACKQuantity(pobjPack)
      fltQty.set(include.INConst.$$$INARTPACKQuantity(m$,pobjPack));
      //<< set strOutUnit  = $$$AppEnum("EINHEIT",idOuterUnit)
      strOutUnit.set(include.COMSYSWWW.$$$AppEnum(m$,"EINHEIT",idOuterUnit));
      //<< 
      //<< ; Create entries once per refresh
      //<< ;-----------------------------------
      //<< if '$data(^CacheTempWWWFORM4(YUSER,"OnBeforeFormat")) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^CacheTempWWWFORM4",m$.var("YUSER").get(),"OnBeforeFormat")))) {
        //<< kill ^CacheTempHealthCheck(YUSER,"INARTPACK")
        m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK").kill();
        //<< set blnCircleFound = $$CheckCircularRef(idItem)
        blnCircleFound.set(m$.fnc$("CheckCircularRef",idItem.get()));
        //<< if 'blnCircleFound set strStatus = $$CheckValid(idItem)
        if (mOp.Not(blnCircleFound.get())) {
          strStatus.set(m$.fnc$("CheckValid",idItem.get()));
        }
        //<< set ^CacheTempWWWFORM4(YUSER,"OnBeforeFormat") = $$$YES
        m$.var("^CacheTempWWWFORM4",m$.var("YUSER").get(),"OnBeforeFormat").set(include.COMSYS.$$$YES(m$));
      }
      //<< }
      //<< 
      //<< ; Use entries
      //<< ;-----------------------------------
      //<< set strStatus = $get(^CacheTempHealthCheck(YUSER,"INARTPACK","unit",idOuterUnit))
      strStatus.set(m$.Fnc.$get(m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK","unit",idOuterUnit.get())));
      //<< if $$$ISERR(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        //<< set pstrBGOverride = $get(YRED,"red")
        pstrBGOverride.set(m$.Fnc.$get(m$.var("YRED"),"red"));
        //<< set YTOOLTIP       = $$$Text(strStatus)
        mVar YTOOLTIP = m$.var("YTOOLTIP");
        YTOOLTIP.set(include.COMSYS.$$$Text(m$,strStatus));
      }
    }
    //<< }
    //<< 
    //<< } elseif (YART="D") {
    else if ((mOp.Equal(YART.get(),"D"))) {
      //<< if YLFN=2 {            ; Inner Unit
      if (mOp.Equal(YLFN.get(),2)) {
        //<< set idItem      = $$$KEY1(YKEY)
        idItem.set(include.COMSYSWWW.$$$KEY1(m$,YKEY));
        //<< set idOuterUnit = $$$KEY2(YKEY)
        idOuterUnit.set(include.COMSYSWWW.$$$KEY2(m$,YKEY));
        //<< set idInnerUnit = $$$INARTPACKUnit(pobjPack)
        idInnerUnit.set(include.INConst.$$$INARTPACKUnit(m$,pobjPack));
        //<< 
        //<< if (idInnerUnit'="") && '$data(^INARTPACK(0,idItem,idInnerUnit,1)) {
        if ((mOp.NotEqual(idInnerUnit.get(),"")) && mOp.Not(m$.Fnc.$data(m$.var("^INARTPACK",0,idItem.get(),idInnerUnit.get(),1)))) {
          //<< set strStatus = $$$MakeStatus("IN01279","("_idOuterUnit_") "_$$$AppEnum("EINHEIT",idOuterUnit))
          strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN01279",mOp.Concat(mOp.Concat(mOp.Concat("(",idOuterUnit.get()),") "),include.COMSYSWWW.$$$AppEnum(m$,"EINHEIT",idOuterUnit))));
          //<< ; "Unit %1 : Inner Unit is not defined"
          //<< set pstrBGOverride = $get(YRED,"red")
          pstrBGOverride.set(m$.Fnc.$get(m$.var("YRED"),"red"));
          //<< set YTOOLTIP       = $$$Text(strStatus)
          mVar YTOOLTIP = m$.var("YTOOLTIP");
          YTOOLTIP.set(include.COMSYS.$$$Text(m$,strStatus));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< ;---------------------------------------
  //<< ;   HEALTH CHECK AND VALIDATION SUBROUTINES
  //<< ;---------------------------------------
  //<< 
  //<< HealthCheck(pidItem)
  public Object HealthCheck(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Because part of the unit definition occurs on INART and part on INARTPACK it
    //<< ; is not possible to fully validate the INARTPACK records since it would be
    //<< ; impossible to have both sets of changes occur at once.
    //<< ; Instead, following the save of a change to INART (in particular a change to
    //<< ; the Base Unit), the following health check will be performed and the user will
    //<< ; be directed to the INARTPACK form if any problems are reported.
    //<< ;
    //<< ; Called By: ^INART (On After Save from form INART)
    //<< ;
    //<< ; Returns : strStatus - if $$$ISERR causes INARTPACK form to be displayed
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2010   GRF     SR17243: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCircleFound,strStatus
    mVar blnCircleFound = m$.var("blnCircleFound");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnCircleFound,strStatus);
    //<< 
    //<< $$$LogR("HealthCheck",pidItem)
    $$$LogR(m$,"HealthCheck",pidItem);
    //<< 
    //<< kill ^CacheTempHealthCheck(YUSER,"INARTPACK")
    m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK").kill();
    //<< 
    //<< set strStatus  = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< ; 1. Circular references
    //<< ; 2. Inner Unit without quantity
    //<< ;---------------------------------------
    //<< set blnCircleFound = $$CheckCircularRef(pidItem)
    blnCircleFound.set(m$.fnc$("CheckCircularRef",pidItem.get()));
    //<< 
    //<< ; 3. self-referencing unit with quantity other than 1 (blank inner
    //<< ;    unit with blank quantity is treated as 1)
    //<< ; 4. multiple self-referencing units indicates multiple independant
    //<< ;    hierarchies - can't calculate unit conversion factor
    //<< ;---------------------------------------
    //<< if blnCircleFound {
    if (mOp.Logical(blnCircleFound.get())) {
      //<< set strStatus = $$$MakeStatus("IN00849")    ; "A circular reference has been detected."
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00849"));
    }
    //<< 
    //<< } else {
    else {
      //<< set strStatus = $$CheckValid(pidItem)
      strStatus.set(m$.fnc$("CheckValid",pidItem.get()));
    }
    //<< }
    //<< $$$LogRx(strStatus)
    $$$LogRx(m$,strStatus);
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< CheckCircularRef(pidItem)
  public Object CheckCircularRef(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   OnLoad : Health Check of all units
    //<< ;   OnSave : Perform Health Check on saved item
    //<< ;
    //<< ;   produces ^CacheTempHealthCheck(YUSER,"INARTPACK","unit",idOuterUnit) = strStatus
    //<< ;
    //<< ; History:
    //<< ; 11-Nov-2010   GRF     SR17243: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCircleFound,idInnerUnit,idOuterUnit,objPack,strStatus
    mVar blnCircleFound = m$.var("blnCircleFound");
    mVar idInnerUnit = m$.var("idInnerUnit");
    mVar idOuterUnit = m$.var("idOuterUnit");
    mVar objPack = m$.var("objPack");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnCircleFound,idInnerUnit,idOuterUnit,objPack,strStatus);
    //<< 
    //<< set blnCircleFound = $$$NO
    blnCircleFound.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set idOuterUnit = ""
    idOuterUnit.set("");
    //<< for {
    for (;true;) {
      //<< set idOuterUnit = $order(^INARTPACK(0,pidItem,idOuterUnit))
      idOuterUnit.set(m$.Fnc.$order(m$.var("^INARTPACK",0,pidItem.get(),idOuterUnit.get())));
      //<< quit:idOuterUnit=""
      if (mOp.Equal(idOuterUnit.get(),"")) {
        break;
      }
      //<< 
      //<< set objPack   = $get(^INARTPACK(0,pidItem,idOuterUnit,1))
      objPack.set(m$.Fnc.$get(m$.var("^INARTPACK",0,pidItem.get(),idOuterUnit.get(),1)));
      //<< set strStatus = $$CheckOneUnit(pidItem,idOuterUnit,objPack,.idInnerUnit)
      strStatus.set(m$.fnc$("CheckOneUnit",pidItem.get(),idOuterUnit.get(),objPack.get(),idInnerUnit));
      //<< if $$$ISERR(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        //<< set blnCircleFound = $$$YES
        blnCircleFound.set(include.COMSYS.$$$YES(m$));
      }
      //<< 
      //<< } elseif (idInnerUnit'="") && (+$$$INARTPACKQuantity(objPack)=0) {
      else if ((mOp.NotEqual(idInnerUnit.get(),"")) && (mOp.Equal(mOp.Positive(include.INConst.$$$INARTPACKQuantity(m$,objPack)),0))) {
        //<< set strStatus = $$$MakeStatus("IN00887")
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00887"));
      }
      //<< } ; "Quantity required."
      //<< 
      //<< set ^CacheTempHealthCheck(YUSER,"INARTPACK","unit",idOuterUnit) = strStatus
      m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK","unit",idOuterUnit.get()).set(strStatus.get());
    }
    //<< }
    //<< quit blnCircleFound
    return blnCircleFound.get();
  }

  //<< 
  //<< 
  //<< CheckOneUnit(pidItem,pidOuterUnit,pobjPack,&pidInnerUnit)
  public Object CheckOneUnit(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidOuterUnit = m$.newVarRef("pidOuterUnit",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjPack = m$.newVarRef("pobjPack",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidInnerUnit = m$.newVarRef("pidInnerUnit",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; History:
    //<< ; 11-Nov-2010   GRF     SR17243: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCurUnit,idLastCur,strStatus
    mVar idCurUnit = m$.var("idCurUnit");
    mVar idLastCur = m$.var("idLastCur");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idCurUnit,idLastCur,strStatus);
    //<< 
    //<< set strStatus    = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set pidInnerUnit = $$$INARTPACKUnit(pobjPack)
    pidInnerUnit.set(include.INConst.$$$INARTPACKUnit(m$,pobjPack));
    //<< 
    //<< if (pidInnerUnit'="") {
    if ((mOp.NotEqual(pidInnerUnit.get(),""))) {
      //<< set idCurUnit = pidInnerUnit
      idCurUnit.set(pidInnerUnit.get());
      //<< set idLastCur = idCurUnit
      idLastCur.set(idCurUnit.get());
      //<< for {
      for (;true;) {
        //<< quit:'$data(^INARTPACK(0,pidItem,idCurUnit))
        if (mOp.Not(m$.Fnc.$data(m$.var("^INARTPACK",0,pidItem.get(),idCurUnit.get())))) {
          break;
        }
        //<< 
        //<< set idCurUnit = $$$INARTPACKUnit($get(^INARTPACK(0,pidItem,idCurUnit,1)))
        idCurUnit.set(include.INConst.$$$INARTPACKUnit(m$,m$.Fnc.$get(m$.var("^INARTPACK",0,pidItem.get(),idCurUnit.get(),1))));
        //<< quit:idCurUnit=""
        if (mOp.Equal(idCurUnit.get(),"")) {
          break;
        }
        //<< quit:idCurUnit=idLastCur              ; self referencing is okay - go no further
        if (mOp.Equal(idCurUnit.get(),idLastCur.get())) {
          break;
        }
        //<< 
        //<< set idLastCur = idCurUnit
        idLastCur.set(idCurUnit.get());
        //<< if (idCurUnit = pidInnerUnit) || (idCurUnit = pidOuterUnit) {
        if ((mOp.Equal(idCurUnit.get(),pidInnerUnit.get())) || (mOp.Equal(idCurUnit.get(),pidOuterUnit.get()))) {
          //<< set strStatus = $$$MakeStatus("IN00849")
          strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN00849"));
          //<< quit
          break;
        }
      }
    }
    //<< }
    //<< } ; "A circular reference has been detected."
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< CheckValid(pidItem)
  public Object CheckValid(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Follow linked list through Pack Unit hierarchy (stop if encounter a node
    //<< ; that has already been checked)
    //<< ;  - If multiple entries which are self-referencing, have separate linked lists
    //<< ;    and potential for invalid conversion factors
    //<< ;  - If unit is self-referencing then must have a conversion factor of 1
    //<< ;    (blank equates to 1 if both InnerUnit and Qty are blank)
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 01-Mar-2011   GRF     SR17243: was incorrectly reporting multiple hierarchies
    //<< ;                           when base unit didn't have an inner unit.
    //<< ; 11-Nov-2010   GRF     SR17243: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrChecked,blnErrorFound,blnMultipleLists
    mVar arrChecked = m$.var("arrChecked");
    mVar blnErrorFound = m$.var("blnErrorFound");
    mVar blnMultipleLists = m$.var("blnMultipleLists");
    m$.newVar(arrChecked,blnErrorFound,blnMultipleLists);
    //<< new idCurrUnit,idInnerUnit,idOuterUnit,objPack,strStatus
    mVar idCurrUnit = m$.var("idCurrUnit");
    mVar idInnerUnit = m$.var("idInnerUnit");
    mVar idOuterUnit = m$.var("idOuterUnit");
    mVar objPack = m$.var("objPack");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idCurrUnit,idInnerUnit,idOuterUnit,objPack,strStatus);
    //<< 
    //<< $$$LogR("CheckValid",pidItem)
    $$$LogR(m$,"CheckValid",pidItem);
    //<< 
    //<< set blnErrorFound    = $$$NO
    blnErrorFound.set(include.COMSYS.$$$NO(m$));
    //<< set blnMultipleLists = $$$NO
    blnMultipleLists.set(include.COMSYS.$$$NO(m$));
    //<< set strStatus        = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set idCurrUnit = ""
    idCurrUnit.set("");
    //<< for {
    for (;true;) {
      //<< set idCurrUnit = $order(^INARTPACK(0,pidItem,idCurrUnit))
      idCurrUnit.set(m$.Fnc.$order(m$.var("^INARTPACK",0,pidItem.get(),idCurrUnit.get())));
      //<< quit:idCurrUnit=""
      if (mOp.Equal(idCurrUnit.get(),"")) {
        break;
      }
      //<< $$$LogRx("CV:1:"_idCurrUnit_"<"_$get(arrChecked(idCurrUnit))_"<")
      $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CV:1:",idCurrUnit.get()),"<"),m$.Fnc.$get(arrChecked.var(idCurrUnit.get()))),"<"));
      //<< continue:$get(arrChecked(idCurrUnit))   ; don't repeat once checked
      if (mOp.Logical(m$.Fnc.$get(arrChecked.var(idCurrUnit.get())))) {
        continue;
      }
      //<< 
      //<< set idOuterUnit = idCurrUnit
      idOuterUnit.set(idCurrUnit.get());
      //<< for {
      for (;true;) {
        //<< quit:idOuterUnit=""
        if (mOp.Equal(idOuterUnit.get(),"")) {
          break;
        }
        //<< 
        //<< set objPack = $get(^INARTPACK(0,pidItem,idOuterUnit,1))
        objPack.set(m$.Fnc.$get(m$.var("^INARTPACK",0,pidItem.get(),idOuterUnit.get(),1)));
        //<< set idInnerUnit = $$$INARTPACKUnit(objPack)
        idInnerUnit.set(include.INConst.$$$INARTPACKUnit(m$,objPack));
        //<< quit:((idInnerUnit'="") && $get(arrChecked(idInnerUnit)))   ; don't repeat once checked
        if (mOp.Logical(((mOp.NotEqual(idInnerUnit.get(),"")) && mOp.Logical(m$.Fnc.$get(arrChecked.var(idInnerUnit.get())))))) {
          break;
        }
        //<< 
        //<< if (idInnerUnit="") {
        if ((mOp.Equal(idInnerUnit.get(),""))) {
          //<< if ($$$INARTPACKQuantity(objPack)'="") && ($$$INARTPACKQuantity(objPack)'=1) {
          if ((mOp.NotEqual(include.INConst.$$$INARTPACKQuantity(m$,objPack),"")) && (mOp.NotEqual(include.INConst.$$$INARTPACKQuantity(m$,objPack),1))) {
            //<< set strStatus = $$$MakeStatus("IN01274","("_idOuterUnit_") "_$$$AppEnum("EINHEIT",idOuterUnit))
            strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN01274",mOp.Concat(mOp.Concat(mOp.Concat("(",idOuterUnit.get()),") "),include.COMSYSWWW.$$$AppEnum(m$,"EINHEIT",idOuterUnit))));
          }
          //<< } ; "Unit %1 : Quantity must be 1 if self-referencing"
          //<< 
          //<< if $data(^CacheTempHealthCheck(YUSER,"INARTPACK","self")) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK","self")))) {
            //<< set blnMultipleLists = $$$YES
            blnMultipleLists.set(include.COMSYS.$$$YES(m$));
          }
          //<< }
          //<< set ^CacheTempHealthCheck(YUSER,"INARTPACK","self",idOuterUnit) = $$$YES
          m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK","self",idOuterUnit.get()).set(include.COMSYS.$$$YES(m$));
          //<< set arrChecked(idOuterUnit) = $$$YES     ; 01-Mar-2011
          arrChecked.var(idOuterUnit.get()).set(include.COMSYS.$$$YES(m$));
        }
        //<< 
        //<< } elseif idInnerUnit=idOuterUnit {
        else if (mOp.Equal(idInnerUnit.get(),idOuterUnit.get())) {
          //<< if $$$INARTPACKQuantity(objPack)'=1 {
          if (mOp.NotEqual(include.INConst.$$$INARTPACKQuantity(m$,objPack),1)) {
            //<< set strStatus = $$$MakeStatus("IN01274","("_idOuterUnit_") "_$$$AppEnum("EINHEIT",idOuterUnit))
            strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN01274",mOp.Concat(mOp.Concat(mOp.Concat("(",idOuterUnit.get()),") "),include.COMSYSWWW.$$$AppEnum(m$,"EINHEIT",idOuterUnit))));
          }
          //<< } ; "Unit %1 : Quantity must be 1 if self-referencing"
          //<< 
          //<< if $data(^CacheTempHealthCheck(YUSER,"INARTPACK","self")) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK","self")))) {
            //<< set blnMultipleLists = $$$YES
            blnMultipleLists.set(include.COMSYS.$$$YES(m$));
          }
          //<< }
          //<< set ^CacheTempHealthCheck(YUSER,"INARTPACK","self",idOuterUnit) = $$$YES
          m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK","self",idOuterUnit.get()).set(include.COMSYS.$$$YES(m$));
        }
        //<< 
        //<< } elseif '$data(^INARTPACK(0,pidItem,idInnerUnit,1)) {
        else if (mOp.Not(m$.Fnc.$data(m$.var("^INARTPACK",0,pidItem.get(),idInnerUnit.get(),1)))) {
          //<< set strStatus = $$$MakeStatus("IN01279","("_idOuterUnit_") "_$$$AppEnum("EINHEIT",idOuterUnit))
          strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN01279",mOp.Concat(mOp.Concat(mOp.Concat("(",idOuterUnit.get()),") "),include.COMSYSWWW.$$$AppEnum(m$,"EINHEIT",idOuterUnit))));
        }
        //<< } ; "Unit %1 : Inner Unit is not defined"
        //<< 
        //<< if $$$ISERR(strStatus) {
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
          //<< set blnErrorFound = $$$YES
          blnErrorFound.set(include.COMSYS.$$$YES(m$));
          //<< set ^CacheTempHealthCheck(YUSER,"INARTPACK","unit",idOuterUnit) = strStatus
          m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK","unit",idOuterUnit.get()).set(strStatus.get());
        }
        //<< }
        //<< if idInnerUnit'="" {
        if (mOp.NotEqual(idInnerUnit.get(),"")) {
          //<< set arrChecked(idInnerUnit) = $$$YES
          arrChecked.var(idInnerUnit.get()).set(include.COMSYS.$$$YES(m$));
        }
        //<< }
        //<< set idOuterUnit = idInnerUnit
        idOuterUnit.set(idInnerUnit.get());
        //<< set strStatus   = $$$OK
        strStatus.set(include.COMSYS.$$$OK(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if blnMultipleLists {
    if (mOp.Logical(blnMultipleLists.get())) {
      //<< set strStatus = $$$MakeStatus("IN01277")
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN01277"));
      //<< ; "Multiple Package Unit hierarchies exist - may not calculate correct unit conversion factor - Please Review"
      //<< set idOuterUnit = ""
      idOuterUnit.set("");
      //<< for {
      for (;true;) {
        //<< set idOuterUnit = $order(^CacheTempHealthCheck(YUSER,"INARTPACK","self",idOuterUnit))
        idOuterUnit.set(m$.Fnc.$order(m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK","self",idOuterUnit.get())));
        //<< quit:idOuterUnit=""
        if (mOp.Equal(idOuterUnit.get(),"")) {
          break;
        }
        //<< 
        //<< set ^CacheTempHealthCheck(YUSER,"INARTPACK","unit",idOuterUnit) = strStatus
        m$.var("^CacheTempHealthCheck",m$.var("YUSER").get(),"INARTPACK","unit",idOuterUnit.get()).set(strStatus.get());
      }
    }
    //<< }
    //<< 
    //<< } elseif blnErrorFound {
    else if (mOp.Logical(blnErrorFound.get())) {
      //<< set strStatus = $$$MakeStatus("IN01278")
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"IN01278"));
    }
    //<< } ; "Error found while checking Package Units - Please Review"
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< OnBeforeDelete(pYKEY,&pYFELD)
  public Object OnBeforeDelete(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
      //<< new strStatus,objINART,idOuterUnit,objPack,idInnerUnit,arrReferedUnits,idRefUnit,blnLockAlert
      mVar strStatus = m$.var("strStatus");
      mVar objINART = m$.var("objINART");
      mVar idOuterUnit = m$.var("idOuterUnit");
      mVar objPack = m$.var("objPack");
      mVar idInnerUnit = m$.var("idInnerUnit");
      mVar arrReferedUnits = m$.var("arrReferedUnits");
      mVar idRefUnit = m$.var("idRefUnit");
      mVar blnLockAlert = m$.var("blnLockAlert");
      m$.newVar(strStatus,objINART,idOuterUnit,objPack,idInnerUnit,arrReferedUnits,idRefUnit,blnLockAlert);
      //<< 
      //<< set strStatus = $$$OK
      strStatus.set(include.COMSYS.$$$OK(m$));
      //<< 
      //<< if '$$$NoKey(pYKEY) {
      if (mOp.Not(include.COMSYS.$$$NoKey(m$,pYKEY))) {
        //<< set objINART=$get(^INART(0,$$$KEY1(pYKEY),1))
        objINART.set(m$.Fnc.$get(m$.var("^INART",0,include.COMSYSWWW.$$$KEY1(m$,pYKEY),1)));
        //<< if ($$$INARTBaseUnit(objINART) = $$$KEY2(pYKEY)) {
        if ((mOp.Equal(include.INConst.$$$INARTBaseUnit(m$,objINART),include.COMSYSWWW.$$$KEY2(m$,pYKEY)))) {
          //<< set $$$INARTBaseUnit(objINART) = $$$INARTUnitofMeasure(objINART)
          include.INConst.$$$INARTBaseUnitSet(m$,objINART,include.INConst.$$$INARTUnitofMeasure(m$,objINART));
          //<< set strStatus = $$$Save("INART",$$$KEY1(pYKEY),objINART,$$$YES)
          strStatus.set(include.COMSYS.$$$Save(m$,"INART",include.COMSYSWWW.$$$KEY1(m$,pYKEY),objINART,include.COMSYS.$$$YES(m$)));
        }
        //<< }
        //<< 
        //<< do CheckReferedUnits^VARINARTPACK($$$KEY1(pYKEY),$$$KEY2(pYKEY),.arrReferedUnits)
        m$.Cmd.Do("VARINARTPACK.CheckReferedUnits",include.COMSYSWWW.$$$KEY1(m$,pYKEY),include.COMSYSWWW.$$$KEY2(m$,pYKEY),arrReferedUnits);
        //<< if $data(arrReferedUnits) {
        if (mOp.Logical(m$.Fnc.$data(arrReferedUnits))) {
          //<< lock +blnLockAlert
          m$.Cmd.LockInc(m$.var("blnLockAlert"));
          //<< if $test {
          if (mOp.Logical(m$.Fnc.$test())) {
            //<< $$$StartScript()
            include.COMSYS.$$$StartScript(m$);
            //<< write "alert('"_$$$Text($$$MakeStatus("IN01800",$$$KEY2(pYKEY)))_"')"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('",include.COMSYS.$$$Text(m$,include.COMSYS.$$$MakeStatus(m$,"IN01800",include.COMSYSWWW.$$$KEY2(m$,pYKEY)))),"')"));
            //<< $$$EndScript()
            include.COMSYS.$$$EndScript(m$);
          }
          //<< }
          //<< set idRefUnit = ""
          idRefUnit.set("");
          //<< for {
          for (;true;) {
            //<< set idRefUnit = $order(arrReferedUnits($$$KEY1(pYKEY),idRefUnit),-1)
            idRefUnit.set(m$.Fnc.$order(arrReferedUnits.var(include.COMSYSWWW.$$$KEY1(m$,pYKEY),idRefUnit.get()),mOp.Negative(1)));
            //<< quit:idRefUnit=""
            if (mOp.Equal(idRefUnit.get(),"")) {
              break;
            }
            //<< quit:$$$ISERR(strStatus)
            if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
              break;
            }
            //<< 
            //<< set strStatus = $$$Kill("INARTPACK",""""_$$$KEY1(pYKEY)_","_idRefUnit_"""") ;Reverse code of OnBeforeDelete (Remove all units that using deleted InnerUnit)
            strStatus.set(include.COMSYS.$$$Kill(m$,"INARTPACK",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("\"",include.COMSYSWWW.$$$KEY1(m$,pYKEY)),","),idRefUnit.get()),"\"")));
          }
          //<< }
          //<< lock -blnLockAlert
          m$.Cmd.Unlock(m$.var("blnLockAlert"));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if $$$ISERR(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        //<< set $zerror = $$DecodeError^COMUtilError(strStatus)
        mVar $zerror = m$.var("$zerror");
        $zerror.set(m$.fnc$("COMUtilError.DecodeError",strStatus.get()));
        //<< zquit 1 GOTO @$ZTRAP
        m$.Cmd.Goto(m$.Fnc.$ztrap());
        return null;
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< LoadCombo(pidItem,pblnOverride,&pSUCH)
  public Object LoadCombo(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnOverride = m$.newVarRef("pblnOverride",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pSUCH = m$.newVarRef("pSUCH",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Populates the Unit with the UOM as defined in INARTPACK only, excludes
    //<< ; units that the item does not come in.
    //<< ;
    //<< ; set pSUCH as the items to be used when you override the list (set via blnOverride)
    //<< ;
    //<< ; Called By: various OnBeforeDisplayCombo^YFORM routines via COMGridEdit31Events executable
    //<< ;
    //<< ; Inputs:
    //<< ;   pstrKeys        YKEY
    //<< ;   pobjSummary     YFELD
    //<< ;
    //<< ; Returns: $$$YES or $$$NO (override the data)
    //<< ;
    //<< ; History:
    //<< ; 03-Oct-2012   SCR     SR17993; Copied from 1.74
    //<< ; 15-Jul-2011   GRF     SR17669: Created as common call
    //<< ;-------------------------------------------------------------------------------
    //<< new enumUnit
    mVar enumUnit = m$.var("enumUnit");
    m$.newVar(enumUnit);
    //<< 
    //<< kill pSUCH
    pSUCH.kill();
    //<< set pSUCH  = "SUCH"
    pSUCH.set("SUCH");
    //<< 
    //<< if pidItem '= "" {
    if (mOp.NotEqual(pidItem.get(),"")) {
      //<< set enumUnit = ""
      enumUnit.set("");
      //<< for {
      for (;true;) {
        //<< set enumUnit = $order(^INARTPACK(0,pidItem,enumUnit))
        enumUnit.set(m$.Fnc.$order(m$.var("^INARTPACK",0,pidItem.get(),enumUnit.get())));
        //<< quit:enumUnit=""
        if (mOp.Equal(enumUnit.get(),"")) {
          break;
        }
        //<< 
        //<< set pSUCH(enumUnit) = enumUnit
        pSUCH.var(enumUnit.get()).set(enumUnit.get());
      }
      //<< }
      //<< set pblnOverride = $$$YES
      pblnOverride.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< quit pblnOverride
    return pblnOverride.get();
  }

//<< 
//<< 
}
