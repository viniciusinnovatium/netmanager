//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUtilNum
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:04
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ;   Routines relating to numbers/rounding etc...
//<< ;-------------------------------------------------------------------------------
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
//<< #include WWWConst
import include.WWWConst;

//<< COMUtilNum
public class COMUtilNum extends mClass {

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
    _COMUtilNum();
  }

  public void _COMUtilNum() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^COMUtilNum("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< Ceiling(val)
  public Object Ceiling(Object ... _p) {
    mVar val = m$.newVarRef("val",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return the ceiling of a number
    //<< ;
    //<< ; 12.345 => 13      -12.345 => -12
    //<< ;
    //<< ; History:
    //<< ; 19-May-2006   GRF     Created (SR14651)
    //<< ;-------------------------------------------------------------------------------
    //<< new result
    mVar result = m$.var("result");
    m$.newVar(result);
    //<< 
    //<< set val    = +$get(val)
    val.set(mOp.Positive(m$.Fnc.$get(val)));
    //<< set result = val\1
    result.set(mOp.IntegerDivide(val.get(),1));
    //<< set:result'=val result = $select(val>0:result+1,1:result)
    if (mOp.NotEqual(result.get(),val.get())) {
      result.set(m$.Fnc.$select(mOp.Greater(val.get(),0),mOp.Add(result.get(),1),1,result.get()));
    }
    //<< quit result
    return result.get();
  }

  //<< 
  //<< 
  //<< Floor(val)
  public Object Floor(Object ... _p) {
    mVar val = m$.newVarRef("val",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return the floor of a number
    //<< ;
    //<< ; 12.345 => 12      -12.345 => -13
    //<< ;
    //<< ; History:
    //<< ; 19-May-2006   GRF     Created (SR14651)
    //<< ;-------------------------------------------------------------------------------
    //<< new result
    mVar result = m$.var("result");
    m$.newVar(result);
    //<< 
    //<< set val    = +$get(val)
    val.set(mOp.Positive(m$.Fnc.$get(val)));
    //<< set result = val\1
    result.set(mOp.IntegerDivide(val.get(),1));
    //<< set:result'=val result = $select(val<0:result-1,1:result)
    if (mOp.NotEqual(result.get(),val.get())) {
      result.set(m$.Fnc.$select(mOp.Less(val.get(),0),mOp.Subtract(result.get(),1),1,result.get()));
    }
    //<< quit result
    return result.get();
  }

  //<< 
  //<< 
  //<< Round(pfltValue,pidForm="",pidField="")
  public Object Round(Object ... _p) {
    mVar pfltValue = m$.newVarRef("pfltValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Rounds a single number (not FC) to the correct number of decimal places
    //<< ;
    //<< ; Returns:Float
    //<< ;
    //<< ; History:
    //<< ; 19-Apr-2005   Paul K  Created SR:5
    //<< ;-------------------------------------------------------------------------------
    //<< ; FIXME : <GRF> Should calls to Round^COMUtils (which is hard coded to 2dp) use this instead?
    //<< ;         See also the routine WWWDECIMALLEN which uses D123 of ^WWW122D(0,YFORM,YLFN1,YM,1))
    //<< ;         Round^COMUtils  :  quit $fnumber(pcurAmount,"",2)
    //<< quit +$justify(pfltValue,0,$$GetDecimalPlaces(pidForm,pidField))
    return mOp.Positive(m$.Fnc.$justify(pfltValue.get(),0,m$.fnc$("GetDecimalPlaces",pidForm.get(),pidField.get())));
  }

  //<< 
  //<< 
  //<< OldGetDecimalPlaces(pidForm="",pidField="") ; SR17250 DEPRECATED - original code
  public Object OldGetDecimalPlaces(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get number of decimal points for a field.
    //<< ;
    //<< ; Called By : Round^COMUtilNum
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Apr-2005   PaulK   Created. SR:5
    //<< ;-------------------------------------------------------------------------------
    //<< new intDecimal,objForm,objField
    mVar intDecimal = m$.var("intDecimal");
    mVar objForm = m$.var("objForm");
    mVar objField = m$.var("objField");
    m$.newVar(intDecimal,objForm,objField);
    //<< 
    //<< $$$LogR("OldGetDecimalPlaces",pidForm_"<"_pidField)
    $$$LogR(m$,"OldGetDecimalPlaces",mOp.Concat(mOp.Concat(pidForm.get(),"<"),pidField.get()));
    //<< 
    //<< set intDecimal = ""
    intDecimal.set("");
    //<< 
    //<< if (pidForm'="") && (pidField'="") {
    if ((mOp.NotEqual(pidForm.get(),"")) && (mOp.NotEqual(pidField.get(),""))) {
      //<< set objForm = $get(^WWW120(0,pidForm,1))
      objForm.set(m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1)));
      //<< 
      //<< ; D Fields in form [5 = idxForm, ClassDld]
      //<< ;-----------------------------------
      //<< if $data(^WWW122s(0,5,$$$Index(pidForm),pidField)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,5,include.MEDConst.$$$Index(m$,pidForm),pidField.get())))) {
        //<< set intDecimal = $$$WWW122DDecimals($get(^WWW122D(0,pidForm,$order(^WWW122s(0,5,$$$Index(pidForm),pidField,pidForm,"")),YM,1)))
        intDecimal.set(include.WWWConst.$$$WWW122DDecimals(m$,m$.Fnc.$get(m$.var("^WWW122D",0,pidForm.get(),m$.Fnc.$order(m$.var("^WWW122s",0,5,include.MEDConst.$$$Index(m$,pidForm),pidField.get(),pidForm.get(),"")),m$.var("YM").get(),1))));
        //<< if intDecimal="" {
        if (mOp.Equal(intDecimal.get(),"")) {
          //<< 
          //<< ; FIXME : <GRF> pidField is the form's field number - there need not be a direct
          //<< ;         match to the class, indeed there may not be a class - also not checked.
          //<< ;         Needs to find and use the corresponding class field no.  SR15379
          //<< ;         (seems to have been written "flexibly" - see below - but concept is flawed.
          //<< 
          //<< set objField   = $get(^WWW003(0,$$$WWW120ClassUsedInForm(objForm),pidField,1))
          objField.set(m$.Fnc.$get(m$.var("^WWW003",0,include.WWWConst.$$$WWW120ClassUsedInForm(m$,objForm),pidField.get(),1)));
          //<< set intDecimal = $$$WWW003NoOfDecimals(objField)
          intDecimal.set(include.WWWConst.$$$WWW003NoOfDecimals(m$,objField));
          //<< if intDecimal="" {
          if (mOp.Equal(intDecimal.get(),"")) {
            //<< if $$$WWW003InputType(objField)=8 {    ; Currency
            if (mOp.Equal(include.WWWConst.$$$WWW003InputType(m$,objField),8)) {
              //<< set intDecimal = 2
              intDecimal.set(2);
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< ; M Fields in form
      //<< ;-----------------------------------
      //<< ; FIXME : <GRF> May not be able to access this block if the form field number associated
      //<< ;         with the M field corresponds to a class field number that is on the form at a
      //<< ;         different form field location.
      //<< ;         e.g.  Form (Class)               Class
      //<< ;                 F1 (D2)  D field           D1
      //<< ;                 F2 (-)   M field           D2   (no other fields)
      //<< ;                 F3 (-)   M field
      //<< ;
      //<< ;         Passing pidField=2 will find a match in WWW122s to F1
      //<< ;                         =3 will not find a match and so will get customisation for F3
      //<< ;                         can never apply customisation to F2
      //<< ;-----------------------------------
      //<< } else {
      else {
        //<< set intDecimal = $$$WWW122DDecimals($get(^WWW122D(0,pidForm,pidField,YM,1)))
        intDecimal.set(include.WWWConst.$$$WWW122DDecimals(m$,m$.Fnc.$get(m$.var("^WWW122D",0,pidForm.get(),pidField.get(),m$.var("YM").get(),1))));
        //<< if intDecimal="" {
        if (mOp.Equal(intDecimal.get(),"")) {
          //<< if $$$WWW122InputType($get(^WWW122(0,pidForm,pidField,1)))=8 {    ; Currency
          if (mOp.Equal(include.WWWConst.$$$WWW122InputType(m$,m$.Fnc.$get(m$.var("^WWW122",0,pidForm.get(),pidField.get(),1))),8)) {
            //<< set intDecimal = 2
            intDecimal.set(2);
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< } else {
    else {
      //<< set intDecimal = 2
      intDecimal.set(2);
    }
    //<< }
    //<< quit intDecimal
    return intDecimal.get();
  }

  //<< 
  //<< 
  //<< GetDecimalPlaces(pidForm,pidFormFldNo,pidUnit="",pobjCurrent="",pobjWWW122="")
  public Object GetDecimalPlaces(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFormFldNo = m$.newVarRef("pidFormFldNo",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidUnit = m$.newVarRef("pidUnit",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pobjCurrent = m$.newVarRef("pobjCurrent",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pobjWWW122 = m$.newVarRef("pobjWWW122",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; If we are displaying a quantity field that has been associated with a unit
    //<< ; field and the unit code has been set to a particular degree of accuracy, use
    //<< ; that figure unless there is a WWW122D customisation.
    //<< ; If neither are set, will use the WWW003 setting or default to YDECIMALLEN.
    //<< ;
    //<< ; Called By: ScreenUpdate^COMGridEdit31S (for type 8 Currency & 12 Floating)
    //<< ;            PARA^COMGridEdit31Body, (alTFR.dUTransferLine).CreateFromReqLine
    //<< ;            Round^COMUtilNum, OnBlur^INTFRLine
    //<< ;
    //<< ; History:
    //<< ; 23-Jun-2011   shobby  SR17250.1: New'd idItem
    //<< ; 25-May-2011   GRF     SR17250: Reconstructed as common function from
    //<< ;                           GetQtyDecimals^^COMGridEditUtil
    //<< ;-------------------------------------------------------------------------------
    //<< new blnIsItem,blnIsUnit,idAssocClassFld,idClass,idClassFldNo,intDecimalPoints
    mVar blnIsItem = m$.var("blnIsItem");
    mVar blnIsUnit = m$.var("blnIsUnit");
    mVar idAssocClassFld = m$.var("idAssocClassFld");
    mVar idClass = m$.var("idClass");
    mVar idClassFldNo = m$.var("idClassFldNo");
    mVar intDecimalPoints = m$.var("intDecimalPoints");
    m$.newVar(blnIsItem,blnIsUnit,idAssocClassFld,idClass,idClassFldNo,intDecimalPoints);
    //<< new idItem ;SR17250.1
    mVar idItem = m$.var("idItem");
    m$.newVar(idItem);
    //<< 
    //<< $$$LogR("GetDecimalPlaces",pidForm_"<"_pidFormFldNo_"<"_pidUnit_"<")
    $$$LogR(m$,"GetDecimalPlaces",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidForm.get(),"<"),pidFormFldNo.get()),"<"),pidUnit.get()),"<"));
    //<< 
    //<< quit:(pidForm="")||(pidFormFldNo="") $get(YDECIMALLEN,2)
    if ((mOp.Equal(pidForm.get(),"")) || (mOp.Equal(pidFormFldNo.get(),""))) {
      return m$.Fnc.$get(m$.var("YDECIMALLEN"),2);
    }
    //<< 
    //<< ; Get DP from Form, Class, Customisation, and Inventory Cost if applicable
    //<< ;---------------------------
    //<< if pobjWWW122="" set pobjWWW122 = $$Get^WWW122(pidForm,pidFormFldNo)
    if (mOp.Equal(pobjWWW122.get(),"")) {
      pobjWWW122.set(m$.fnc$("WWW122.Get",pidForm.get(),pidFormFldNo.get()));
    }
    //<< 
    //<< set intDecimalPoints = $$$WWW122Decimals(pobjWWW122)
    intDecimalPoints.set(include.WWWConst.$$$WWW122Decimals(m$,pobjWWW122));
    //<< 
    //<< $$$LogRx("GDP1:"_intDecimalPoints_"<")
    $$$LogRx(m$,mOp.Concat(mOp.Concat("GDP1:",intDecimalPoints.get()),"<"));
    //<< 
    //<< ; Override with Unit-based dp
    //<< ;---------------------------
    //<< if pidUnit="" {
    if (mOp.Equal(pidUnit.get(),"")) {
      //<< set idClass         =  $$$WWW120ClassUsedInForm($get(^WWW120(0,pidForm,1)))
      idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1))));
      //<< set idClassFldNo    = +$$$WWW122SequenceNumber(pobjWWW122)
      idClassFldNo.set(mOp.Positive(include.WWWConst.$$$WWW122SequenceNumber(m$,pobjWWW122)));
      //<< set idAssocClassFld =  $$$WWW122AssociatedwithField(pobjWWW122)
      idAssocClassFld.set(include.WWWConst.$$$WWW122AssociatedwithField(m$,pobjWWW122));
      //<< if idAssocClassFld {
      if (mOp.Logical(idAssocClassFld.get())) {
        //<< do CheckRelation^WWWEVENTUtils(pidForm,idClass,pidFormFldNo,idClassFldNo,idAssocClassFld,.blnIsUnit,.blnIsItem)
        m$.Cmd.Do("WWWEVENTUtils.CheckRelation",pidForm.get(),idClass.get(),pidFormFldNo.get(),idClassFldNo.get(),idAssocClassFld.get(),blnIsUnit,blnIsItem);
        //<< 
        //<< if blnIsUnit {
        if (mOp.Logical(blnIsUnit.get())) {
          //<< set pidUnit = $piece(pobjCurrent,Y,idAssocClassFld)
          pidUnit.set(m$.Fnc.$piece(pobjCurrent.get(),m$.var("Y").get(),idAssocClassFld.get()));
        }
        //<< 
        //<< } elseif blnIsItem {
        else if (mOp.Logical(blnIsItem.get())) {
          //<< set idItem = $piece(pobjCurrent,Y,idAssocClassFld)
          idItem.set(m$.Fnc.$piece(pobjCurrent.get(),m$.var("Y").get(),idAssocClassFld.get()));
          //<< if idItem'="" set pidUnit = $$$INARTUnitofMeasure($get(^INART(0,idItem,1)))
          if (mOp.NotEqual(idItem.get(),"")) {
            pidUnit.set(include.INConst.$$$INARTUnitofMeasure(m$,m$.Fnc.$get(m$.var("^INART",0,idItem.get(),1))));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< ; NOTE: Don't try to default to item's Inventory Unit if only item supplied - assume a
    //<< if pidUnit'="" set intDecimalPoints = $$$COMUnitDecimalPlaces($get(^COMUnit(0,pidUnit,1)))
    if (mOp.NotEqual(pidUnit.get(),"")) {
      intDecimalPoints.set(include.COMConst.$$$COMUnitDecimalPlaces(m$,m$.Fnc.$get(m$.var("^COMUnit",0,pidUnit.get(),1))));
    }
    //<< 
    //<< ; Default
    //<< ;---------------------------
    //<< if intDecimalPoints="" {
    if (mOp.Equal(intDecimalPoints.get(),"")) {
      //<< set intDecimalPoints = $get(YDECIMALLEN,2)
      intDecimalPoints.set(m$.Fnc.$get(m$.var("YDECIMALLEN"),2));
    }
    //<< }
    //<< $$$LogRx("GDP2:"_intDecimalPoints)
    $$$LogRx(m$,mOp.Concat("GDP2:",intDecimalPoints.get()));
    //<< 
    //<< quit intDecimalPoints
    return intDecimalPoints.get();
  }

  //<< 
  //<< 
  //<< VirtualRoundEven(pfltAmount,pintDistributions,pintDecimalPlaces=0,plstResults)
  public Object VirtualRoundEven(Object ... _p) {
    mVar pfltAmount = m$.newVarRef("pfltAmount",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintDistributions = m$.newVarRef("pintDistributions",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintDecimalPlaces = m$.newVarRef("pintDecimalPlaces",(((_p!=null)&&(_p.length>=3))?_p[2]:null),0);
    mVar plstResults = m$.newVarRef("plstResults",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Function to apply virtual rounding over a number of different items.
    //<< ; Currently will attempt to distribute equally.
    //<< ;
    //<< ; History
    //<< ; 12-Sep-2005   JW      Moved from COMUtils. Use pintDecimalPlaces parameter
    //<< ; 05-Nov-2004   GRF     Convert dot to { form
    //<< ; 11-Mar-2003   shobby  Creation
    //<< ; ----------------------------------------------------------------------------
    //<< new fltAmount,fltAmountRounded,fltExcess,i
    mVar fltAmount = m$.var("fltAmount");
    mVar fltAmountRounded = m$.var("fltAmountRounded");
    mVar fltExcess = m$.var("fltExcess");
    mVar i = m$.var("i");
    m$.newVar(fltAmount,fltAmountRounded,fltExcess,i);
    //<< 
    //<< set fltExcess=0
    fltExcess.set(0);
    //<< set plstResults=""
    plstResults.set("");
    //<< 
    //<< for i=1:1:pintDistributions {
    for (i.set(1);(mOp.LessOrEqual(i.get(),pintDistributions.get()));i.set(mOp.Add(i.get(),1))) {
      //<< set fltAmount        = (pfltAmount/pintDistributions)+fltExcess
      fltAmount.set(mOp.Add((mOp.Divide(pfltAmount.get(),pintDistributions.get())),fltExcess.get()));
      //<< ;set fltAmountRounded = $fnumber(fltAmount,"",2)
      //<< set fltAmountRounded = $fnumber(fltAmount,"",pintDecimalPlaces)
      fltAmountRounded.set(m$.Fnc.$fnumber(fltAmount.get(),"",pintDecimalPlaces.get()));
      //<< set fltExcess        = fltAmount-fltAmountRounded
      fltExcess.set(mOp.Subtract(fltAmount.get(),fltAmountRounded.get()));
      //<< set plstResults      = plstResults_$listbuild(fltAmountRounded)
      plstResults.set(mOp.Concat(plstResults.get(),m$.Fnc.$listbuild(fltAmountRounded.get())));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< VirtualRoundApportion(pfltAmount=0,parrAmounts,parrResults,pfltTotal="",pintDecimalPlaces=2)
  public Object VirtualRoundApportion(Object ... _p) {
    mVar pfltAmount = m$.newVarRef("pfltAmount",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    mVar parrAmounts = m$.newVarRef("parrAmounts",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar parrResults = m$.newVarRef("parrResults",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pfltTotal = m$.newVarRef("pfltTotal",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pintDecimalPlaces = m$.newVarRef("pintDecimalPlaces",(((_p!=null)&&(_p.length>=5))?_p[4]:null),2);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Function to apportion an amount over an array using virtual rounding.
    //<< ;
    //<< ; Params:   pfltAmount - amount to apportion
    //<< ;           parrAmounts - amounts to be apportioned over: parrAmounts(id)=amount
    //<< ;           parrResults - byRef: the apportioned values
    //<< ;           pTotal - byRef: the summed total of the amounts (can be passed in as well if known prior)
    //<< ;           pintDecimalPlaces - num of dp to round to.
    //<< ;
    //<< ; History
    //<< ; 13-Sep-2005   JW      SR13434: Creation (modified above function)
    //<< ; ----------------------------------------------------------------------------
    //<< new fltAmount,fltAmountRounded,fltExcess,portion,idAmount
    mVar fltAmount = m$.var("fltAmount");
    mVar fltAmountRounded = m$.var("fltAmountRounded");
    mVar fltExcess = m$.var("fltExcess");
    mVar portion = m$.var("portion");
    mVar idAmount = m$.var("idAmount");
    m$.newVar(fltAmount,fltAmountRounded,fltExcess,portion,idAmount);
    //<< 
    //<< set pfltAmount = $justify(pfltAmount,0,pintDecimalPlaces)
    pfltAmount.set(m$.Fnc.$justify(pfltAmount.get(),0,pintDecimalPlaces.get()));
    //<< 
    //<< if pfltTotal="" {       // If not passed in
    if (mOp.Equal(pfltTotal.get(),"")) {
      //<< set idAmount = ""
      idAmount.set("");
      //<< for {
      for (;true;) {
        //<< set idAmount = $order(parrAmounts(idAmount))
        idAmount.set(m$.Fnc.$order(parrAmounts.var(idAmount.get())));
        //<< quit:idAmount=""
        if (mOp.Equal(idAmount.get(),"")) {
          break;
        }
        //<< 
        //<< set pfltTotal = pfltTotal + $get(parrAmounts(idAmount))
        pfltTotal.set(mOp.Add(pfltTotal.get(),m$.Fnc.$get(parrAmounts.var(idAmount.get()))));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if +pfltTotal=0 {
    if (mOp.Equal(mOp.Positive(pfltTotal.get()),0)) {
      //<< set portion = 0
      portion.set(0);
    }
    //<< } else {
    else {
      //<< set portion = pfltAmount / pfltTotal
      portion.set(mOp.Divide(pfltAmount.get(),pfltTotal.get()));
    }
    //<< }
    //<< 
    //<< kill parrResults
    parrResults.kill();
    //<< set fltExcess=0
    fltExcess.set(0);
    //<< 
    //<< set idAmount = ""
    idAmount.set("");
    //<< for {
    for (;true;) {
      //<< set idAmount = $order(parrAmounts(idAmount))
      idAmount.set(m$.Fnc.$order(parrAmounts.var(idAmount.get())));
      //<< quit:idAmount=""
      if (mOp.Equal(idAmount.get(),"")) {
        break;
      }
      //<< 
      //<< set fltAmount           = (parrAmounts(idAmount)*portion) + fltExcess
      fltAmount.set(mOp.Add((mOp.Multiply(parrAmounts.var(idAmount.get()).get(),portion.get())),fltExcess.get()));
      //<< set fltAmountRounded    = $justify(fltAmount,0,pintDecimalPlaces)
      fltAmountRounded.set(m$.Fnc.$justify(fltAmount.get(),0,pintDecimalPlaces.get()));
      //<< set fltExcess           = fltAmount-fltAmountRounded
      fltExcess.set(mOp.Subtract(fltAmount.get(),fltAmountRounded.get()));
      //<< set parrResults(idAmount) = fltAmountRounded
      parrResults.var(idAmount.get()).set(fltAmountRounded.get());
    }
    //<< }
    //<< quit
    return null;
  }

//<< 
}
