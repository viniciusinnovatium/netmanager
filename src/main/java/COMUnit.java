//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUnit
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:28
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
//<< #include COMConst
import include.COMConst;
//<< #include INConst
import include.INConst;

//<< COMUnit
public class COMUnit extends mClass {

  //<< 
  //<< #define ERROR       -1
  public static Object $$$ERROR(mContext m$) {
    return (mOp.Negative(1));
  }

  //<< #define NOCOMUNIT   -2
  public static Object $$$NOCOMUNIT(mContext m$) {
    return (mOp.Negative(2));
  }

  //<< #define NOUNIT      -3
  public static Object $$$NOUNIT(mContext m$) {
    return (mOp.Negative(3));
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

  public void main() {
    _COMUnit();
  }

  public void _COMUnit() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^COMUnit("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ;                 See also - Unit Utilities in INUOMConversion
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< 
  //<< IsValidQtyUnit(pidItem,pidUnit,pfltQty,pidLocn)
  public Object IsValidQtyUnit(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidUnit = m$.newVarRef("pidUnit",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pfltQty = m$.newVarRef("pfltQty",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine if the Quantity is valid with the number of decimal places on the unit.
    //<< ;
    //<< ; If the unit is unknown, get the default unit from the product.
    //<< ;
    //<< ; If the product does not exist, exit.
    //<< ;
    //<< ; Inputs:
    //<< ;   pidItem     : The product we are interested in searching for.
    //<< ;   pidUnit     : The unit to find the decimal places for
    //<< ;   pfltQty     : The quantity to check
    //<< ;   pidLocn     : Currently UNUSED, reserved for future use.
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ; Boolean, $$$YES - This is valid, $$$NO - This is invalid.
    //<< ;
    //<< ; History:
    //<< ; 15-May-2007   RPW/GRF SRBR014469: Fixed extra checks for missing types
    //<< ; 09-May-2007   GRF     SRBR014310: Use new GetDecimalsForItemUnit routine
    //<< ; 27-Apr-2007   RPW     SRBR014310: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnValid,intDecimalPlaces
    mVar blnValid = m$.var("blnValid");
    mVar intDecimalPlaces = m$.var("intDecimalPlaces");
    m$.newVar(blnValid,intDecimalPlaces);
    //<< 
    //<< $$$LogR("IsValidQtyUnit",$get(pidItem)_"<"_$get(pidUnit)_"<"_$get(pfltQty)_"<"_$get(pidLocn))
    $$$LogR(m$,"IsValidQtyUnit",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(pidItem),"<"),m$.Fnc.$get(pidUnit)),"<"),m$.Fnc.$get(pfltQty)),"<"),m$.Fnc.$get(pidLocn)));
    //<< 
    //<< set blnValid = $$$YES
    blnValid.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< set intDecimalPlaces = $$GetDecimalsForItemUnit(pidItem,pidUnit)
    intDecimalPlaces.set(m$.fnc$("GetDecimalsForItemUnit",pidItem.get(),pidUnit.get()));
    //<< $$$LogRx("DP="_intDecimalPlaces)
    $$$LogRx(m$,mOp.Concat("DP=",intDecimalPlaces.get()));
    //<< 
    //<< if (intDecimalPlaces'=$$$NOCOMUNIT) && (intDecimalPlaces'=$$$NOUNIT) {
    if ((mOp.NotEqual(intDecimalPlaces.get(),$$$NOCOMUNIT(m$))) && (mOp.NotEqual(intDecimalPlaces.get(),$$$NOUNIT(m$)))) {
      //<< if (intDecimalPlaces=$$$ERROR) || (intDecimalPlaces<$length($piece(+pfltQty,".",2))) {
      if ((mOp.Equal(intDecimalPlaces.get(),$$$ERROR(m$))) || (mOp.Less(intDecimalPlaces.get(),m$.Fnc.$length(m$.Fnc.$piece(mOp.Positive(pfltQty.get()),".",2))))) {
        //<< set blnValid = $$$NO
        blnValid.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnValid
    return blnValid.get();
  }

  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< ; See general function : GetDecimalPlaces^COMUtilNum
  //<< ;   - Includes Inventory Cost and unit-based decimal places.
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< GetDecimalsForItemUnit(pidItem,pidUnit="")
  public Object GetDecimalsForItemUnit(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidUnit = m$.newVarRef("pidUnit",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the number of decimal places given the product and the unit.
    //<< ;
    //<< ; If the unit is blank then get the unit from the product. If this is blank just crash.
    //<< ;
    //<< ; Called By : IsValidQtyUnit^COMUnit, SetCancelVal^INReqCancel,
    //<< ;             QtyCancelled^INReqLineCancel, QtyRejected^INReqLineReject,
    //<< ;             SetRejectVal^INReqReject, FirmTxn^INTRNFirm
    //<< ;
    //<< ; Inputs:   pidItem : Item - used for Inventory Unit
    //<< ;           pidUnit : Unit from associate field - Null if need to get item's inventory unit
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ; >=0 valid number of decimal places
    //<< ; -1  this is an error and MUST be treated as such.
    //<< ;
    //<< ; TODO: Make each error type return different negative numbers
    //<< ;
    //<< ; History:
    //<< ; 15-May-2007   RPW/GRF SRBR014469: Fixed extra checks for missing types
    //<< ; 11-May-2007   RPW     SRBR014310: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intDecimalPlaces
    mVar intDecimalPlaces = m$.var("intDecimalPlaces");
    m$.newVar(intDecimalPlaces);
    //<< 
    //<< set intDecimalPlaces = $$$ERROR              // ERROR
    intDecimalPlaces.set($$$ERROR(m$));
    //<< 
    //<< quit:(pidItem="")||'$data(^INART(0,pidItem)) intDecimalPlaces
    if ((mOp.Equal(pidItem.get(),"")) || mOp.Not(m$.Fnc.$data(m$.var("^INART",0,pidItem.get())))) {
      return intDecimalPlaces.get();
    }
    //<< ; FIXME : should we only exit early if both params are null, or if unit is null and INART doesn't exist?
    //<< 
    //<< set intDecimalPlaces = $$$NOCOMUNIT          // No COMUnit found
    intDecimalPlaces.set($$$NOCOMUNIT(m$));
    //<< 
    //<< if pidUnit="" {
    if (mOp.Equal(pidUnit.get(),"")) {
      //<< set pidUnit = $$$INARTUnitofMeasure($get(^INART(0,pidItem,1)))
      pidUnit.set(include.INConst.$$$INARTUnitofMeasure(m$,m$.Fnc.$get(m$.var("^INART",0,pidItem.get(),1))));
    }
    //<< }
    //<< 
    //<< if pidUnit'="" {
    if (mOp.NotEqual(pidUnit.get(),"")) {
      //<< if $data(^COMUnit(0,pidUnit)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^COMUnit",0,pidUnit.get())))) {
        //<< set intDecimalPlaces = $$$COMUnitDecimalPlaces($get(^COMUnit(0,pidUnit,1)))
        intDecimalPlaces.set(include.COMConst.$$$COMUnitDecimalPlaces(m$,m$.Fnc.$get(m$.var("^COMUnit",0,pidUnit.get(),1))));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set intDecimalPlaces = $$$NOUNIT         // No Unit found
      intDecimalPlaces.set($$$NOUNIT(m$));
    }
    //<< }
    //<< quit intDecimalPlaces
    return intDecimalPlaces.get();
  }

//<< 
//<< 
}
