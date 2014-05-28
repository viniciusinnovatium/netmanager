//*****************************************************************************
//** TASC - ALPHALINC - MAC COMGridEdit31Events
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:07
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include COMConst
import include.COMConst;
import include.COMSYS;
//<< #include COMGridEdit31
import include.COMGridEdit31;
//<< #include WWWConst
import include.WWWConst;

//<< COMGridEdit31Events
public class COMGridEdit31Events extends mClass {

  //<< 
  //<< #def1arg WWWDATEN(%args)    ^WWWDATEN(0,+$horolog,YUSER,YFORM,"V",%args)
  public static Object $$$WWWDATEN(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",p$args.get()).get());
  }

  public static mVar $$$WWWDATENVar(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",p$args.get()));
  }

  //<< #define IsPrimaryKey(%1)    (%1=0)
  public static Object $$$IsPrimaryKey(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal(p$1.get(),0)));
  }

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogR2(%1,%2)    ;
  public static Object $$$LogR2(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogRx(%1)       ;
  public static Object $$$LogRx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogR2x(%1)      ;
  public static Object $$$LogR2x(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogRm(%1)       ;
  public static Object $$$LogRm(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _COMGridEdit31Events();
  }

  public void _COMGridEdit31Events() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^CGEEvents("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogR2(%1,%2)   $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^CGEEvents("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogR2x(%1)     $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< OnDisplayRightClickMenu(pstrYFORM="",pintLine="")
  public Object OnDisplayRightClickMenu(Object ... _p) {
    mVar pstrYFORM = m$.newVarRef("pstrYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintLine = m$.newVarRef("pintLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Code to build customised right click menus
    //<< ;
    //<< ; Returns: List of menu items each either a list of 5 entries corresponding to
    //<< ;          the parameters in AddRow^COMViewColumnMenu or "Separator"
    //<< ;
    //<< ; History:
    //<< ; 06-Oct-2005   JW      SR11573: Call CallEvent
    //<< ; 25-Feb-2005   shobby  Set initial value for lstNewMenuItems.
    //<< ; 23-Feb-2005   Shobby  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new lstNewMenuItems,YFELD,YFORM,YKEY
    mVar lstNewMenuItems = m$.var("lstNewMenuItems");
    mVar YFELD = m$.var("YFELD");
    mVar YFORM = m$.var("YFORM");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(lstNewMenuItems,YFELD,YFORM,YKEY);
    //<< 
    //<< set YFORM = pstrYFORM
    YFORM.set(pstrYFORM.get());
    //<< if pstrYFORM="" set YFORM = $get(^CacheTemp(YUSER,"Grid","Name"))
    if (mOp.Equal(pstrYFORM.get(),"")) {
      YFORM.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    }
    //<< 
    //<< set YKEY  = $$GetYKEY^COMGridEdit31G(pintLine,pstrYFORM)
    YKEY.set(m$.fnc$("COMGridEdit31G.GetYKEY",pintLine.get(),pstrYFORM.get()));
    //<< set YFELD = $$GetYFELDEX^COMGridEdit31G(pstrYFORM,YKEY)
    YFELD.set(m$.fnc$("COMGridEdit31G.GetYFELDEX",pstrYFORM.get(),YKEY.get()));
    //<< 
    //<< set lstNewMenuItems = ""
    lstNewMenuItems.set("");
    //<< do CallEvent("set lstNewMenuItems=$$OnDisplayRightClickMenu^"_YFORM_"(YKEY,YFELD,YFORM)","RightClick")  ; *** EXECUTE Grid ***
    m$.Cmd.Do("CallEvent",mOp.Concat(mOp.Concat("set lstNewMenuItems=$$OnDisplayRightClickMenu^",YFORM.get()),"(YKEY,YFELD,YFORM)"),"RightClick");
    //<< 
    //<< quit lstNewMenuItems
    return lstNewMenuItems.get();
  }

  //<< 
  //<< 
  //<< OnBlur(pstrYLFDAT,pstrYKEY,&YFELD,pblnUpdateContainer=$$$YES)
  public Object OnBlur(Object ... _p) {
    mVar pstrYLFDAT = m$.newVarRef("pstrYLFDAT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrYKEY = m$.newVarRef("pstrYKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnUpdateContainer = m$.newVarRef("pblnUpdateContainer",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Call out to any onBlur code.   (OnBlur is actually OnChange)
    //<< ; NOTE : Appears data in YFELD has not been written into WWWDATEN at this stage
    //<< ;
    //<< ; Called By : ^COMGridEdit31S, OnClickError^COMGridEdit31S
    //<< ;
    //<< ; Inputs :  pstrYLFDAT    : "Yr_c"   where row 'r' & column 'c' are copied to GROW and GCOL
    //<< ;           pstrYKEY      : idGridClass   e.g. idContainer,idGridLine
    //<< ;           YFELD [byRef] : objGridClass
    //<< ;           pblnUpdateContainer : Update headers, now that the grid has been updated.
    //<< ;
    //<< ; Returns: nothing
    //<< ;
    //<< ; Note.     Use standard naming for YFELD when calling OnBlur events.
    //<< ;
    //<< ; History:
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag for WWWTR calls
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 01-Sep-2009   shobby  SR16411: Get YFELDCONTAINER before blur code is run.
    //<< ; 06-May-2009   PPP     SR16521: Barcodes scanned to get Item # (YINHALT, can be
    //<< ;                           changed in the current routine).
    //<< ; 15-Oct-2008   GRF     SR15810: comments
    //<< ; 21-Apr-2008   heber   SRBR014936: Disable updating style to keep applied rules(WWW122D2)
    //<< ; 13-Apr-2008   heber   SRBR014932: Apply masking to grid fields
    //<< ; 08-Jul-2007   shobby  SRBR014616: Consider customisation rules.
    //<< ; 06-Jul-2007   shobby  SRBR014553: Consider customisation of WWW122, Renamed
    //<< ;                           objFormField to objWWW122
    //<< ; 26-Mar-2007   JW      SR15384: Changed name from GetValidationDetails
    //<< ; 17-Jan-2007   RPW     SR15249: Always define YKEY here for OnBeforeFormat.
    //<< ; 21-Sep-2006   JW      SR15063: Define YDATEI,YLFN.
    //<< ; 05-Jul-2006   RPW     SR12522: If we have a relation, check if it uses quick search
    //<< ; 26-Jun-2006   JW      SR12775: Always call ScreenUpdate - to update style
    //<< ; 31-Oct-2005   JW      SR13626: ExecuteCode is unnecessary
    //<< ; 16-Aug-2005   RPW     SR11983: Attempt to determine if the user changed this
    //<< ;                           value or the system.
    //<< ; 28-Jun-2005   JW      SR10412: Added macros. Define GFLD - replaces strFieldNo
    //<< ; 02-Jun-2005   PO      SR:12050 Removed some work from SR:11349, removed code
    //<< ;                           for editting base amount of a FC amount
    //<< ; 24-May-2005   JW      SR11573: Moved UpdateContainer outside if and only call it
    //<< ;                           if pblnUpdateContainer. eg. Don't when ClickAllRows
    //<< ; 18-Apr-2005   PO      SR11349: FC support
    //<< ; 08-Apr-2005   RobertW SR11836: Change FCMake to FCJoin
    //<< ; 17-Mar-2005   JW      SR11916: Update headers
    //<< ; 03-Feb-2005   RobertW Use the new ExecuteCode Command in COMUtils
    //<< ; 07-Dec-2004   Shobby  Created
    //<< ;-------------------------------------------------------------------------------
    //<< ; "Standard" call will have a format similar to;
    //<< ;                  do OnBlur^FormName(YKEY,.YFELD,GROW,GCOL)
    //<< ;
    //<< ; May assume passing : GCOL,GROW,GDATA,GKEY,YKEY,YFELD and perhaps GFLD
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< new amtFC,blnTest,idClass,idRelation,idDisplay,GCOL,GDATA,GFLD,GKEY,GROW,objWWW122
    mVar amtFC = m$.var("amtFC");
    mVar blnTest = m$.var("blnTest");
    mVar idClass = m$.var("idClass");
    mVar idRelation = m$.var("idRelation");
    mVar idDisplay = m$.var("idDisplay");
    mVar GCOL = m$.var("GCOL");
    mVar GDATA = m$.var("GDATA");
    mVar GFLD = m$.var("GFLD");
    mVar GKEY = m$.var("GKEY");
    mVar GROW = m$.var("GROW");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(amtFC,blnTest,idClass,idRelation,idDisplay,GCOL,GDATA,GFLD,GKEY,GROW,objWWW122);
    //<< new strCommand,strCur,strFieldNo,strRelKeys,strSortKeys,strValue,strYFELDOld
    mVar strCommand = m$.var("strCommand");
    mVar strCur = m$.var("strCur");
    mVar strFieldNo = m$.var("strFieldNo");
    mVar strRelKeys = m$.var("strRelKeys");
    mVar strSortKeys = m$.var("strSortKeys");
    mVar strValue = m$.var("strValue");
    mVar strYFELDOld = m$.var("strYFELDOld");
    m$.newVar(strCommand,strCur,strFieldNo,strRelKeys,strSortKeys,strValue,strYFELDOld);
    //<< new YFELDCONTAINER
    mVar YFELDCONTAINER = m$.var("YFELDCONTAINER");
    m$.newVar(YFELDCONTAINER);
    //<< 
    //<< set YFELDCONTAINER  = $$$GRIDYFELDContainer
    YFELDCONTAINER.set(include.COMGridEdit31Interface.$$$GRIDYFELDContainer(m$));
    //<< 
    //<< $$$LogR2("OnBlur",$get(pstrYKEY)_":"_$get(YFELD)_"<"_pstrYLFDAT_"<")
    $$$LogR2(m$,"OnBlur",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(pstrYKEY),":"),m$.Fnc.$get(YFELD)),"<"),pstrYLFDAT.get()),"<"));
    //<< 
    //<< set GCOL = $piece(pstrYLFDAT,"_",2)
    GCOL.set(m$.Fnc.$piece(pstrYLFDAT.get(),"_",2));
    //<< 
    //<< set objWWW122 = $$Get^WWW122(YFORM,GCOL) ; FIXME : Neither field used is customisable - faster to have direct get
    objWWW122.set(m$.fnc$("WWW122.Get",m$.var("YFORM").get(),GCOL.get()));
    //<< 
    //<< set GFLD        = $$$WWW122SequenceNumber(objWWW122)   ; Class Field No
    GFLD.set(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122));
    //<< set strYFELDOld = YFELD
    strYFELDOld.set(YFELD.get());
    //<< set pstrYKEY    = $translate($get(pstrYKEY),"""")
    pstrYKEY.set(m$.Fnc.$translate(m$.Fnc.$get(pstrYKEY),"\""));
    //<< set YKEY        = pstrYKEY
    mVar YKEY = m$.var("YKEY");
    YKEY.set(pstrYKEY.get());
    //<< 
    //<< set GROW = $piece($piece(pstrYLFDAT,"_",1),"Y",2)
    GROW.set(m$.Fnc.$piece(m$.Fnc.$piece(pstrYLFDAT.get(),"_",1),"Y",2));
    //<< 
    //<< 
    //<< set idClass = $$$GRIDClass(YFORM)
    idClass.set(include.COMGridEdit31.$$$GRIDClass(m$,m$.var("YFORM")));
    //<< if (idClass'="") && (GFLD'="") {
    if ((mOp.NotEqual(idClass.get(),"")) && (mOp.NotEqual(GFLD.get(),""))) {
      //<< do GetDetails^WWWFieldValidation("D",YFORM,idClass,GFLD,"",,.idRelation)
      m$.Cmd.Do("WWWFieldValidation.GetDetails","D",m$.var("YFORM").get(),idClass.get(),GFLD.get(),"",null,idRelation);
      //<< if idRelation'="" {
      if (mOp.NotEqual(idRelation.get(),"")) {
        //<< set ($piece(YFELD,Y,GFLD),YINHALT) = $$PerformQuickSearch^COMQuickSearch(idRelation,$piece(YFELD,Y,GFLD))
        m$.pieceVar(YFELD,m$.var("Y").get(),GFLD.get()).set(m$.fnc$("COMQuickSearch.PerformQuickSearch",idRelation.get(),m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),GFLD.get())));
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set(m$.fnc$("COMQuickSearch.PerformQuickSearch",idRelation.get(),m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),GFLD.get())));
        //<< $$$GRIDSplitKey(pstrYLFDAT,intRow,intCol)
        include.COMGridEdit31Interface.$$$GRIDSplitKey(m$,pstrYLFDAT,m$.var("intRow"),m$.var("intCol"));
        //<< do UpdateManualField^COMGridEdit31G(intRow,intCol,$piece(YFELD,Y,GFLD))
        m$.Cmd.Do("COMGridEdit31G.UpdateManualField",m$.var("intRow").get(),m$.var("intCol").get(),m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),GFLD.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $$$WWW122ExecuteOnBlur(objWWW122)'="" {             ; *** EXECUTE Grid ***  May assume passing : GCOL,GROW,GFLD,GDATA,GKEY,YKEY,YFELD
    if (mOp.NotEqual(include.WWWConst.$$$WWW122ExecuteOnBlur(m$,objWWW122),"")) {
      //<< set GKEY  = pstrYKEY
      GKEY.set(pstrYKEY.get());
      //<< set GDATA = YFELD
      GDATA.set(YFELD.get());
      //<< set strCommand = $$$WWW122ExecuteOnBlur(objWWW122)
      strCommand.set(include.WWWConst.$$$WWW122ExecuteOnBlur(m$,objWWW122));
      //<< 
      //<< ; If entered amount is not qualified with a currency and currently displaying FC then make amount FC
      //<< if GFLD'="" {
      if (mOp.NotEqual(GFLD.get(),"")) {
        //<< set strValue = $piece(YFELD,Y,GFLD)
        strValue.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),GFLD.get()));
        //<< if ($$GetFieldType^COMUtilClass(YFORM,GCOL)=8) {
        if ((mOp.Equal(m$.fnc$("COMUtilClass.GetFieldType",m$.var("YFORM").get(),GCOL.get()),8))) {
          //<< set strCur = $get(^CacheTemp(YUSER,$get(^CacheTemp(YUSER,"Grid","Container")),"Display Currency"))
          strCur.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")),"Display Currency")));
          //<< 
          //<< ; FIXME: <GRF> strValue is ALREADY an internal value
          //<< ;vvvvvvvvvvvvvvvv likely replacement code
          //<< ;           if ($$$CurrencyToUse="Foreign")&&'$$$AmountIsFC(strValue) {
          //<< ;               set $piece(YFELD,Y,GFLD) = strCur_strValue
          //<< ;^^^^^^^^^^^^^^^^
          //<< if ($$$CurrencyToUse="Foreign") && '$$$AmountIsFC($$GetInternal^WWWTR(8,strValue)) {
          if ((mOp.Equal(include.COMSYSNum.$$$CurrencyToUse(m$),"Foreign")) && mOp.Not(include.COMSYSNum.$$$AmountIsFC(m$,m$.fnc$("WWWTR.GetInternal",8,strValue.get())))) {
            //<< set $piece(YFELD,Y,GFLD) = $$GetInternal^WWWTR(8,strCur_strValue)
            m$.pieceVar(YFELD,m$.var("Y").get(),GFLD.get()).set(m$.fnc$("WWWTR.GetInternal",8,mOp.Concat(strCur.get(),strValue.get())));
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< xecute strCommand
      m$.Cmd.Xecute(strCommand.get());
    }
    //<< }
    //<< 
    //<< $$$LogR2x("31E-OB:1:"_YFELD)
    $$$LogR2x(m$,mOp.Concat("31E-OB:1:",YFELD.get()));
    //<< do ApplyCoreMasking^WWWFORM8(GROW,YFORM,.YFELD)
    m$.Cmd.Do("WWWFORM8.ApplyCoreMasking",GROW.get(),m$.var("YFORM").get(),YFELD);
    //<< $$$LogR2x("31E-OB:2:"_YFELD)
    $$$LogR2x(m$,mOp.Concat("31E-OB:2:",YFELD.get()));
    //<< do CheckRules^WWWEVENT(YFORM,.YFELD,GROW)
    m$.Cmd.Do("WWWEVENT.CheckRules",m$.var("YFORM").get(),YFELD,GROW.get());
    //<< $$$LogR2x("31E-OB:3:"_YFELD)
    $$$LogR2x(m$,mOp.Concat("31E-OB:3:",YFELD.get()));
    //<< 
    //<< ;---------------------------------------
    //<< ; Update WWWDATEN Record
    //<< ;---------------------------------------
    //<< 
    //<< if YBED'["aSHOBBY" {           // SRBR014936
    if (mOp.NotContains(m$.var("YBED").get(),"aSHOBBY")) {
      //<< do ScreenUpdate^COMGridEdit31S(pstrYLFDAT,YFELD,strYFELDOld)
      m$.Cmd.Do("COMGridEdit31S.ScreenUpdate",pstrYLFDAT.get(),YFELD.get(),strYFELDOld.get());
    }
    //<< } else {
    else {
      //<< do ScreenUpdate^COMGridEdit31S(pstrYLFDAT,YFELD,strYFELDOld,,,$$$YES)
      m$.Cmd.Do("COMGridEdit31S.ScreenUpdate",pstrYLFDAT.get(),YFELD.get(),strYFELDOld.get(),null,null,include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< ; Update headers, now that the grid has been updated.
    //<< if pblnUpdateContainer {
    if (mOp.Logical(pblnUpdateContainer.get())) {
      //<< do UpdateContainer^COMGridEdit31G(GFLD)
      m$.Cmd.Do("COMGridEdit31G.UpdateContainer",GFLD.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PerformQuickSearch(pidClass,objData)
  public Object PerformQuickSearch(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar objData = m$.newVarRef("objData",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Call the class based Perform Quick Search.
    //<< ;
    //<< ; Params:
    //<< ; pidClass: The id of the class to search on
    //<< ; objData : The data of the field that has been changed.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; objObject: This can be any data type, we are unsure.
    //<< ;
    //<< ; History:
    //<< ; 05-Jul-2006   RPW     SR12522: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objObject
    mVar objObject = m$.var("objObject");
    m$.newVar(objObject);
    //<< 
    //<< set objObject=""
    objObject.set("");
    //<< $$$CallEvent("set objObject=$$PerformQuickSearch^"_pidClass_"(objData)","QuickSearch")  ; FIXME : pidClass or pidForm? <GRF>
    include.COMGridEdit31.$$$CallEvent(m$,mOp.Concat(mOp.Concat("set objObject=$$PerformQuickSearch^",pidClass.get()),"(objData)"),"QuickSearch");
    //<< 
    //<< quit objObject
    return objObject.get();
  }

  //<< 
  //<< 
  //<< OnColumnResize(pid,pintWidth)
  public Object OnColumnResize(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintWidth = m$.newVarRef("pintWidth",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 24-Aug-2005   shobby  SR11983: Structure of line ids now includes form name.
    //<< ; 07-Jun-2005   shobby  SR12449: Initial value for strType.
    //<< ; 06-Jun-2005   shobby  SR12449: Included Primary Key.
    //<< ;-------------------------------------------------------------------------------
    //<< new idCOMGridEditLayout,intField,objCOMGridEditLayout,strForm,strStatus,strType
    mVar idCOMGridEditLayout = m$.var("idCOMGridEditLayout");
    mVar intField = m$.var("intField");
    mVar objCOMGridEditLayout = m$.var("objCOMGridEditLayout");
    mVar strForm = m$.var("strForm");
    mVar strStatus = m$.var("strStatus");
    mVar strType = m$.var("strType");
    m$.newVar(idCOMGridEditLayout,intField,objCOMGridEditLayout,strForm,strStatus,strType);
    //<< 
    //<< set strForm  = $piece(pid,";",1)
    strForm.set(m$.Fnc.$piece(pid.get(),";",1));
    //<< set pid      = $piece(pid,";",2)
    pid.set(m$.Fnc.$piece(pid.get(),";",2));
    //<< set strType  = ""
    strType.set("");
    //<< set intField = $piece($piece(pid,"fld",2),"_",3)
    intField.set(m$.Fnc.$piece(m$.Fnc.$piece(pid.get(),"fld",2),"_",3));
    //<< if intField="" {
    if (mOp.Equal(intField.get(),"")) {
      //<< set intField = $piece(pid,"key",2)
      intField.set(m$.Fnc.$piece(pid.get(),"key",2));
      //<< if intField'="Expand" {
      if (mOp.NotEqual(intField.get(),"Expand")) {
        //<< set intField = $piece($piece(pid,"key",2),"_",3)
        intField.set(m$.Fnc.$piece(m$.Fnc.$piece(pid.get(),"key",2),"_",3));
      }
      //<< }
      //<< set strType = "P"
      strType.set("P");
    }
    //<< }
    //<< set idCOMGridEditLayout = """"_YBED_""","""_strForm_""","_strType_intField
    idCOMGridEditLayout.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("\"",m$.var("YBED").get()),"\",\""),strForm.get()),"\","),strType.get()),intField.get()));
    //<< set $$$COMGridEditLayoutWidth(objCOMGridEditLayout) = pintWidth        ; FIXME : why not add \1 ? <GRF>
    include.COMConst.$$$COMGridEditLayoutWidthSet(m$,objCOMGridEditLayout,pintWidth.get());
    //<< set strStatus = $$$Save("COMGridEditLayout",idCOMGridEditLayout,objCOMGridEditLayout,$$$YES)
    strStatus.set(include.COMSYS.$$$Save(m$,"COMGridEditLayout",idCOMGridEditLayout,objCOMGridEditLayout,include.COMSYS.$$$YES(m$)));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeDisplayCombo(pYKEY,pYFIELDNAME,&pSUCH,&pblnOverride)
  public Object OnBeforeDisplayCombo(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFIELDNAME = m$.newVarRef("pYFIELDNAME",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pSUCH = m$.newVarRef("pSUCH",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnOverride = m$.newVarRef("pblnOverride",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Before displaying the combo call out to see if we want to generate a custom
    //<< ; list.
    //<< ;
    //<< ; Called By : SELECT^COMGridEdit31F
    //<< ;
    //<< ; Inputs:
    //<< ;   pYKEY
    //<< ;   pYFIELDNAME         (t?)Yrow_col
    //<< ;   pSUCH               ByRef : Override? / Returned Search
    //<< ;   pblnOverride        ByRef :
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 31-Aug-2011   shobby  SR17889: Create a YFELDCONTAINER variable to be used in
    //<< ;                          all OnBeforeDisplayCombo routines.
    //<< ; 30-Oct-2008   GRF     Show & for ByRef
    //<< ; 06-Oct-2005   JW      SR11573: Call CallEvent
    //<< ; 03-Feb-2005   RobertW Use the new ExecuteCode Command in COMUtils...
    //<< ; 18-Jan-2005   Shobby  Created (SR10061)
    //<< ;-------------------------------------------------------------------------------
    //<< new intRow,YCOL,YFELD,YFORM,YKEY
    mVar intRow = m$.var("intRow");
    mVar YCOL = m$.var("YCOL");
    mVar YFELD = m$.var("YFELD");
    mVar YFORM = m$.var("YFORM");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(intRow,YCOL,YFELD,YFORM,YKEY);
    //<< new YFELDCONTAINER ;SR17889
    mVar YFELDCONTAINER = m$.var("YFELDCONTAINER");
    m$.newVar(YFELDCONTAINER);
    //<< 
    //<< set YFORM  = $get(^CacheTemp(YUSER,"Grid","Name"))
    YFORM.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    //<< set intRow = $piece($piece(pYFIELDNAME,"Y",2),"_",1)
    intRow.set(m$.Fnc.$piece(m$.Fnc.$piece(pYFIELDNAME.get(),"Y",2),"_",1));
    //<< set YCOL   = $piece(pYFIELDNAME,"_",2)
    YCOL.set(m$.Fnc.$piece(pYFIELDNAME.get(),"_",2));
    //<< set YKEY   = $$GetYKEY^COMGridEdit31G(intRow)
    YKEY.set(m$.fnc$("COMGridEdit31G.GetYKEY",intRow.get()));
    //<< set YFELD  = $$GetYFELDEX^COMGridEdit31G(YFORM,YKEY)
    YFELD.set(m$.fnc$("COMGridEdit31G.GetYFELDEX",YFORM.get(),YKEY.get()));
    //<< set YFELDCONTAINER=$$GetYFELDContainer^COMGridEdit31G() ;SR17889
    YFELDCONTAINER.set(m$.fnc$("COMGridEdit31G.GetYFELDContainer"));
    //<< 
    //<< do CallEvent("set pblnOverride=$$OnBeforeDisplayCombo^"_YFORM_"(YKEY,YFELD,YCOL,.pSUCH)","Combo") ; *** EXECUTE Grid ***
    m$.Cmd.Do("CallEvent",mOp.Concat(mOp.Concat("set pblnOverride=$$OnBeforeDisplayCombo^",YFORM.get()),"(YKEY,YFELD,YCOL,.pSUCH)"),"Combo");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeFormConstruction(pYTXT,YBBN) ;CORE-233.11
  public Object OnBeforeFormConstruction(Object ... _p) {
    mVar pYTXT = m$.newVarRef("pYTXT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YBBN = m$.newVarRef("YBBN",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   EXECUTE VOR DATENFELD
    //<< ;
    //<< ; History:
    //<< ; 16-Aug-2013   shobby  CORE-233.11: YBBN
    //<< ; 19-Jun-2009   GRF     Use field macro
    //<< ; 01-Sep-2004   FIS     26346
    //<< ;-------------------------------------------------------------------------------
    //<< if $$$WWW122ExecuteBeforeDataField(pYTXT) '="" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW122ExecuteBeforeDataField(m$,pYTXT),"")) {
      //<< xecute $$$WWW122ExecuteBeforeDataField(pYTXT)           ; *** EXECUTE Grid ***
      m$.Cmd.Xecute(include.WWWConst.$$$WWW122ExecuteBeforeDataField(m$,pYTXT));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforePrimaryKey(YFORM)
  public Object OnBeforePrimaryKey(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Before the field is drawn allow new information to be used.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Oct-2009   GRF     SR16886: Use CallEvent wrapper
    //<< ; 29-May-2007   RPW     SR15513: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;do ExecuteCode^COMUtils("do OnBeforePrimaryKey^"_YFORM_"()")
    //<< do CallEvent("do OnBeforePrimaryKey^"_YFORM_"()","BeforeKey") ; *** EXECUTE Grid ***
    m$.Cmd.Do("CallEvent",mOp.Concat(mOp.Concat("do OnBeforePrimaryKey^",YFORM.get()),"()"),"BeforeKey");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< UpdatePrimaryKeyFormat(YFORM,pintRow,pobjRow,&pblnUpdate)
  public Object UpdatePrimaryKeyFormat(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintRow = m$.newVarRef("pintRow",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjRow = m$.newVarRef("pobjRow",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnUpdate = m$.newVarRef("pblnUpdate",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Before the field is drawn allow new information to be used.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Oct-2009   GRF     SR16886: Use CallEvent wrapper
    //<< ; 10-Sep-2009   PPP     SR16886: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;do ExecuteCode^COMUtils("do UpdatePrimaryKeyFormat^"_YFORM_"(pintRow,pobjRow,.pblnUpdate)")
    //<< do CallEvent("do UpdatePrimaryKeyFormat^"_YFORM_"(pintRow,pobjRow,.pblnUpdate)","KeyFormat") ; *** EXECUTE Grid ***
    m$.Cmd.Do("CallEvent",mOp.Concat(mOp.Concat("do UpdatePrimaryKeyFormat^",YFORM.get()),"(pintRow,pobjRow,.pblnUpdate)"),"KeyFormat");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterPrimaryKey(YFORM,YKEY)
  public Object OnAfterPrimaryKey(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; 31-Oct-2005   JW      SR13626: ExecuteCode is unnecessary
    //<< ; 03-Feb-2005   RobertW Use the new ExecuteCode Command in COMUtils...
    //<< ;-------------------------------------------------------------------------------
    //<< new strCode
    mVar strCode = m$.var("strCode");
    m$.newVar(strCode);
    //<< 
    //<< set strCode = $$$WWW120ExecuteAfterPrimaryKey($$$GRIDYVOR(YFORM))
    strCode.set(include.WWWConst.$$$WWW120ExecuteAfterPrimaryKey(m$,include.COMGridEdit31.$$$GRIDYVOR(m$,YFORM)));
    //<< if strCode'="" {
    if (mOp.NotEqual(strCode.get(),"")) {
      //<< set YKEY = $translate(YKEY,"""")
      YKEY.set(m$.Fnc.$translate(YKEY.get(),"\""));
      //<< xecute strCode                                               ; *** EXECUTE Grid ***
      m$.Cmd.Xecute(strCode.get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeButtonLine()
  public Object OnBeforeButtonLine(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; ByRef :
    //<< ;   YKEY
    //<< ;   ??? Needed by strCode
    //<< ;
    //<< ; History:
    //<< ; 28-Nov-2008   HQN     SR16194: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strCode
    mVar strCode = m$.var("strCode");
    m$.newVar(strCode);
    //<< 
    //<< set strCode = $$$WWW120ExecuteBeforeButtonline($$$GRIDYVOR(YFORM))
    strCode.set(include.WWWConst.$$$WWW120ExecuteBeforeButtonline(m$,include.COMGridEdit31.$$$GRIDYVOR(m$,m$.var("YFORM"))));
    //<< if strCode'="" {
    if (mOp.NotEqual(strCode.get(),"")) {
      //<< set YKEY = $translate(YKEY,"""")
      mVar YKEY = m$.var("YKEY");
      YKEY.set(m$.Fnc.$translate(m$.var("YKEY").get(),"\""));
      //<< xecute strCode                                               ; *** EXECUTE Grid ***
      m$.Cmd.Xecute(strCode.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterDataFields()
  public Object OnAfterDataFields(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Routine that runs after all the fields in a record have been added.
    //<< ; This can be used to update fields on the main form based on the contents of
    //<< ; a grid.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 05-Apr-2006   JW      Put SR14093 check in UpdateContainer function
    //<< ; 03-Feb-2006   RPW     SR14093: Do not attempt to update the header if the
    //<< ;                           developer doesn't require this.
    //<< ; 31-Oct-2005   JW      SR13626: ExecuteCode is unnecessary
    //<< ; 17-Mar-2005   JW      SR11916: Update headers
    //<< ; 11-Mar-2005   JW      Added YSEITE.
    //<< ; 03-Feb-2005   RPW     Use the new ExecuteCode Command in COMUtils...
    //<< ; 14-Jan-2005   Shobby  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strCode,YSEITE
    mVar strCode = m$.var("strCode");
    mVar YSEITE = m$.var("YSEITE");
    m$.newVar(strCode,YSEITE);
    //<< 
    //<< set YSEITE  = $get(^CacheTemp(YUSER,"Grid","YSEITE"))
    YSEITE.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","YSEITE")));
    //<< set strCode = $$$WWW120ExecuteAfterDataFields($$$GRIDYVOR(YFORM))
    strCode.set(include.WWWConst.$$$WWW120ExecuteAfterDataFields(m$,include.COMGridEdit31.$$$GRIDYVOR(m$,m$.var("YFORM"))));
    //<< xecute strCode                                                   ; *** EXECUTE Grid ***
    m$.Cmd.Xecute(strCode.get());
    //<< 
    //<< do UpdateContainer^COMGridEdit31G("",$$$NO)
    m$.Cmd.Do("COMGridEdit31G.UpdateContainer","",include.COMSYS.$$$NO(m$));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeDisplayLine(pYFORM,pYKEY="",pYFELD="")
  public Object OnBeforeDisplayLine(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;------------------------------------------------------------------------------
    //<< ; Callout to module for custom code as to whether to show the line or not. (SR11054)
    //<< ;
    //<< ;   WARNING : This is called from within a $sortbegin/$sortend block.
    //<< ;             ^WWWDATEN and other saved globals may not be available until
    //<< ;             written at the end of the block.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Aug-2009   shobby  SR16511: YFELDCONTAINER
    //<< ; 04-Aug-2006   JW      SR14730: Sped up - removed unnecessary lines
    //<< ; 06-Oct-2005   JW      SR11573: Call CallEvent
    //<< ; 03-Feb-2005   RobertW Use the new ExecuteCode Command in COMUtils...
    //<< ; 06-Dec-2004   shobby  Include YKEY
    //<< ; 06-Dec-2004   Shobby  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnDisplay,YFELDCONTAINER
    mVar blnDisplay = m$.var("blnDisplay");
    mVar YFELDCONTAINER = m$.var("YFELDCONTAINER");
    m$.newVar(blnDisplay,YFELDCONTAINER);
    //<< 
    //<< set blnDisplay      = $$$YES
    blnDisplay.set(include.COMSYS.$$$YES(m$));
    //<< set YFELDCONTAINER  = $$$GRIDYFELDContainer
    YFELDCONTAINER.set(include.COMGridEdit31Interface.$$$GRIDYFELDContainer(m$));
    //<< do CallEvent("set blnDisplay=$$OnBeforeDisplayLine^"_pYFORM_"(pYKEY,pYFELD)","Display")   ; *** EXECUTE Grid ***
    m$.Cmd.Do("CallEvent",mOp.Concat(mOp.Concat("set blnDisplay=$$OnBeforeDisplayLine^",pYFORM.get()),"(pYKEY,pYFELD)"),"Display");
    //<< quit blnDisplay
    return blnDisplay.get();
  }

  //<< 
  //<< 
  //<< OnBeforeFormat(YFORM,pYFIELDNAME,pblnOnBlur=$$$NO,pblnEnabled=$$$YES,pobjRow="")
  public Object OnBeforeFormat(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFIELDNAME = m$.newVarRef("pYFIELDNAME",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnOnBlur = m$.newVarRef("pblnOnBlur",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    mVar pblnEnabled = m$.newVarRef("pblnEnabled",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$YES(m$));
    mVar pobjRow = m$.newVarRef("pobjRow",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Formatting of a cell about to be displayed can be done through calling out to
    //<< ; routines associated with a form.
    //<< ;
    //<< ; Called By : BodyFieldCell^COMGridEdit31Body
    //<< ;             ScreenUpdateStyle^COMGridEdit31S
    //<< ;
    //<< ; Inputs:
    //<< ;   YGRIDWHITE      Implicit
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; Variables that can be modified include:
    //<< ;   YTOOLTIP        YFONTCOLOR      YBACKGROUNDCOLOR        YFONT
    //<< ;   YFONTSIZE       YWIDTH          YHEIGHT                 YVALIGN
    //<< ;
    //<< ; History:
    //<< ; 24-Sep-2012   shobby  SR18123: Temporary change to set YKEY if not already defined.
    //<< ;                           result of patching back to 1.70.4.br
    //<< ; 12-Jun-2012   shobby  SR18026: FOCUSFIELD preserved during processing.
    //<< ; 29-Aug-2011   shobby  SR17847: Brought OnBeforeFormat into line with other
    //<< ;                           types of events.
    //<< ; 09-Mar-2010   shobby  SR17200: Corrected issue where warning was showing red text on
    //<< ;                           a red background.
    //<< ; 17-Jan-2007   RPW     SR15351: Optionally pass through edit grid row to save
    //<< ;                           getting multiple times when updating multiple fields
    //<< ; 12-Dec-2006   JW&PO   SR<>: Only change to mandatory colour if not already changed.
    //<< ; 28-Nov-2006   RPW     SR15249: Fixed the row number to handle subrows, ie 11x01
    //<< ; 10-Nov-2006   JW      SR15211: Define reason from cache if not blurring
    //<< ; 26-Jun-2006   JW      SR12775: Added validation and colour processing
    //<< ; 06-Oct-2005   JW      SR11573: Call CallEvent
    //<< ; 20-Jun-2005   shobby  If pYFIELDNAME is passed in with the td then strip it off.
    //<< ; 18-Mar-2005   shobby  Passed YFORM as a parameter rather than getting the form
    //<< ;                           name from ^CacheTemp.  Allows the grid to support
    //<< ;                           multiple forms in different lines.
    //<< ; 03-Feb-2005   RPW     Use the new ExecuteCode Command in COMUtils...
    //<< ; 14-Jan-2005   Shobby  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnValid,idClsFld,idField,intColour,intRow,strReason,strText,strValue,YFELD,YDATEI
    mVar blnValid = m$.var("blnValid");
    mVar idClsFld = m$.var("idClsFld");
    mVar idField = m$.var("idField");
    mVar intColour = m$.var("intColour");
    mVar intRow = m$.var("intRow");
    mVar strReason = m$.var("strReason");
    mVar strText = m$.var("strText");
    mVar strValue = m$.var("strValue");
    mVar YFELD = m$.var("YFELD");
    mVar YDATEI = m$.var("YDATEI");
    m$.newVar(blnValid,idClsFld,idField,intColour,intRow,strReason,strText,strValue,YFELD,YDATEI);
    //<< 
    //<< new YFOCUSFIELD                                 ;SR18026
    mVar YFOCUSFIELD = m$.var("YFOCUSFIELD");
    m$.newVar(YFOCUSFIELD);
    //<< set YFOCUSFIELD=$get($$$WWWDATEN("FOCUSFIELD")) ;SR18026
    YFOCUSFIELD.set(m$.Fnc.$get($$$WWWDATENVar(m$,"FOCUSFIELD")));
    //<< 
    //<< ;SR17847 vvvvv
    //<< 
    //<< ;SR17847 if $get($$$EventExists("Format"))'=$$$NO {
    //<< ;SR17847    if $get(pYFIELDNAME)'="" {
    //<< ;SR17847        set strText=""      // Not used
    //<< ;SR17847        set intRow      = $piece($piece(pYFIELDNAME,"Y",2),"_",1)
    //<< ;SR17847        set pYFIELDNAME = $translate(pYFIELDNAME,"td")
    //<< ;SR17847        if pobjRow="" {
    //<< ;SR17847            set YFELD = $$GetYFELD^COMGridEdit31G(YFORM,intRow)
    //<< ;SR17847        } else {
    //<< ;SR17847            set YFELD = pobjRow
    //<< ;SR17847        }
    //<< ;SR17847        do CallEvent("do OnBeforeFormat^"_YFORM_"(pYFIELDNAME,strText,YFELD)","Format")   ; *** EXECUTE Grid ***
    //<< ;SR17847    }
    //<< ;SR17847 }
    //<< 
    //<< set intRow      = $piece($piece(pYFIELDNAME,"Y",2),"_",1)
    intRow.set(m$.Fnc.$piece(m$.Fnc.$piece(pYFIELDNAME.get(),"Y",2),"_",1));
    //<< set pYFIELDNAME = $translate(pYFIELDNAME,"td")
    pYFIELDNAME.set(m$.Fnc.$translate(pYFIELDNAME.get(),"td"));
    //<< if pobjRow="" {
    if (mOp.Equal(pobjRow.get(),"")) {
      //<< set YFELD = $$GetYFELD^COMGridEdit31G(YFORM,intRow)
      YFELD.set(m$.fnc$("COMGridEdit31G.GetYFELD",YFORM.get(),intRow.get()));
    }
    //<< } else {
    else {
      //<< set YFELD = pobjRow
      YFELD.set(pobjRow.get());
    }
    //<< }
    //<< do ExecuteHook^WWW001Hook($$$GetClass(YFORM),$$$EnumWWWEVENTTYPEOnBeforeFormat,.YKEY,.YFELD,YFORM,,pYFIELDNAME)   ; *** EXECUTE Grid ***
    m$.Cmd.Do("WWW001Hook.ExecuteHook",include.COMSYSWWW.$$$GetClass(m$,YFORM),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeFormat(m$),m$.var("YKEY"),YFELD,YFORM.get(),null,pYFIELDNAME.get());
    //<< ;SR17847 ^^^^^
    //<< 
    //<< ; FIXME : Validation in the OnBeforeFormat subroutine may set YBACKGROUNDCOLOR and YTOOLTIP
    //<< ;         CallEvent wrapper seems to lose this setting for INIssueLine. <GRF>
    //<< 
    //<< if (YFORM'="") && pblnEnabled {
    if ((mOp.NotEqual(YFORM.get(),"")) && mOp.Logical(pblnEnabled.get())) {
      //<< set idField  = $piece(pYFIELDNAME,"_",2)        // Only validate single field
      idField.set(m$.Fnc.$piece(pYFIELDNAME.get(),"_",2));
      //<< set strValue = $get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"V",pYFIELDNAME,1))
      strValue.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V",pYFIELDNAME.get(),1)));
      //<< 
      //<< // Only check on blur, as just displaying the data won't have changed it
      //<< set blnValid = $$$YES
      blnValid.set(include.COMSYS.$$$YES(m$));
      //<< if pblnOnBlur {
      if (mOp.Logical(pblnOnBlur.get())) {
        //<< $$$SetFocusField(pYFIELDNAME)   // To get the correct line in focus for validation
        include.COMGridEdit31.$$$SetFocusField(m$,pYFIELDNAME);
        //<< 
        //<< set idClsFld = $$$GetClassField(YFORM,idField)
        idClsFld.set(include.COMSYSWWW.$$$GetClassField(m$,YFORM,idField));
        //<< if idClsFld'="" {
        if (mOp.NotEqual(idClsFld.get(),"")) {
          //<< set YDATEI = $$$GRIDClass(YFORM)
          YDATEI.set(include.COMGridEdit31.$$$GRIDClass(m$,YFORM));
          //<< set blnValid = $$ValidRelation^WWWFieldValidation("D",YDATEI,YFORM,idClsFld,strValue,$$$NO,.strReason)
          blnValid.set(m$.fnc$("WWWFieldValidation.ValidRelation","D",YDATEI.get(),YFORM.get(),idClsFld.get(),strValue.get(),include.COMSYS.$$$NO(m$),strReason));
          //<< if 'blnValid {
          if (mOp.Not(blnValid.get())) {
            //<< set $$$FLDRelError(pYFIELDNAME) = strReason     // Store error in cache
            include.COMGridEdit31.$$$FLDRelErrorVar(m$,pYFIELDNAME).set(strReason.get());
            //<< if strReason'="" {
            if (mOp.NotEqual(strReason.get(),"")) {
              //<< $$$Alert(strReason)     // Alert if data access error
              include.COMSYS.$$$Alert(m$,strReason);
            }
          }
          //<< }
          //<< } else {
          else {
            //<< kill $$$FLDRelError(pYFIELDNAME)
            m$.var("$$$FLDRelError").var(pYFIELDNAME.get()).kill();
          }
        }
      }
      //<< }
      //<< }
      //<< } else {
      else {
        //<< set blnValid = '$data($$$FLDRelError(pYFIELDNAME))            // Check cache
        blnValid.set(mOp.Not(m$.Fnc.$data(include.COMGridEdit31.$$$FLDRelErrorVar(m$,pYFIELDNAME))));
        //<< if 'blnValid set strReason = $$$FLDRelError(pYFIELDNAME)      // get reason
        if (mOp.Not(blnValid.get())) {
          strReason.set(include.COMGridEdit31.$$$FLDRelError(m$,pYFIELDNAME));
        }
      }
      //<< }
      //<< 
      //<< if 'blnValid {
      if (mOp.Not(blnValid.get())) {
        //<< set YWARNING = $$$YES
        mVar YWARNING = m$.var("YWARNING");
        YWARNING.set(include.COMSYS.$$$YES(m$));
        //<< if strReason="" set strReason = $listbuild("WWW00028",strValue) ; "´%1´ is invalid"
        if (mOp.Equal(strReason.get(),"")) {
          strReason.set(m$.Fnc.$listbuild("WWW00028",strValue.get()));
        }
        //<< set YTOOLTIP = $$$Text(strReason)
        mVar YTOOLTIP = m$.var("YTOOLTIP");
        YTOOLTIP.set(include.COMSYS.$$$Text(m$,strReason));
      }
      //<< 
      //<< } elseif $get($$$FLDMandatory(idField)) {
      else if (mOp.Logical(m$.Fnc.$get(include.COMGridEdit31.$$$FLDMandatoryVar(m$,idField)))) {
        //<< set YMANDATORY = $$$YES
        mVar YMANDATORY = m$.var("YMANDATORY");
        YMANDATORY.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< new strDisabledColor,strRequiredColor,strWarningColor,strDisabledFontColor
    mVar strDisabledColor = m$.var("strDisabledColor");
    mVar strRequiredColor = m$.var("strRequiredColor");
    mVar strWarningColor = m$.var("strWarningColor");
    mVar strDisabledFontColor = m$.var("strDisabledFontColor");
    m$.newVar(strDisabledColor,strRequiredColor,strWarningColor,strDisabledFontColor);
    //<< 
    //<< set strDisabledFontColor = "black"
    strDisabledFontColor.set("black");
    //<< set strWarningColor  = $$$SysEnum("FARBE",$$$WWW012ColorforWarnings($get(^WWW012(0,0,1))))
    strWarningColor.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012ColorforWarnings(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1)))));
    //<< set strRequiredColor = $$$SysEnum("FARBE",$$$WWW012FontColorMandatoryInput($get(^WWW012(0,0,1))))
    strRequiredColor.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012FontColorMandatoryInput(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1)))));
    //<< set strDisabledColor = $$$SysEnum("FARBE",$$$WWW012BackgroundColor($get(^WWW012(0,0,1))))
    strDisabledColor.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012BackgroundColor(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1)))));
    //<< 
    //<< if YMANDATORY && (YBACKGROUNDCOLOR="ivory") set YBACKGROUNDCOLOR = strRequiredColor
    if (mOp.Logical(m$.var("YMANDATORY").get()) && (mOp.Equal(m$.var("YBACKGROUNDCOLOR").get(),"ivory"))) {
      mVar YBACKGROUNDCOLOR = m$.var("YBACKGROUNDCOLOR");
      YBACKGROUNDCOLOR.set(strRequiredColor.get());
    }
    //<< if YREQUIRED  && (YBACKGROUNDCOLOR="ivory") set YBACKGROUNDCOLOR = strRequiredColor
    if (mOp.Logical(m$.var("YREQUIRED").get()) && (mOp.Equal(m$.var("YBACKGROUNDCOLOR").get(),"ivory"))) {
      mVar YBACKGROUNDCOLOR = m$.var("YBACKGROUNDCOLOR");
      YBACKGROUNDCOLOR.set(strRequiredColor.get());
    }
    //<< if YENABLED    {
    if (mOp.Logical(m$.var("YENABLED").get())) {
      //<< if YWARNING set YBACKGROUNDCOLOR = strWarningColor      ;SR17200
      if (mOp.Logical(m$.var("YWARNING").get())) {
        mVar YBACKGROUNDCOLOR = m$.var("YBACKGROUNDCOLOR");
        YBACKGROUNDCOLOR.set(strWarningColor.get());
      }
    }
    //<< 
    //<< } else {
    else {
      //<< if YBACKGROUNDCOLOR="ivory" set YBACKGROUNDCOLOR = strDisabledColor
      if (mOp.Equal(m$.var("YBACKGROUNDCOLOR").get(),"ivory")) {
        mVar YBACKGROUNDCOLOR = m$.var("YBACKGROUNDCOLOR");
        YBACKGROUNDCOLOR.set(strDisabledColor.get());
      }
      //<< if YWARNING {
      if (mOp.Logical(m$.var("YWARNING").get())) {
        //<< set YFONTCOLOR = strWarningColor
        mVar YFONTCOLOR = m$.var("YFONTCOLOR");
        YFONTCOLOR.set(strWarningColor.get());
      }
      //<< } else {
      else {
        //<< set YFONTCOLOR = strDisabledFontColor
        mVar YFONTCOLOR = m$.var("YFONTCOLOR");
        YFONTCOLOR.set(strDisabledFontColor.get());
      }
    }
    //<< }
    //<< }
    //<< set $$$WWWDATEN("FOCUSFIELD")=YFOCUSFIELD ;SR18026
    $$$WWWDATENVar(m$,"FOCUSFIELD").set(YFOCUSFIELD.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterSave(YKEY,YFELD,YVOR)
  public Object OnAfterSave(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YVOR = m$.newVarRef("YVOR",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Run the After Save code
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2009   GRF     Use field macro
    //<< ; 19-Nov-2004   Shobby  Created (SR10468)
    //<< ; 07.06.2004    BEC     DA ZENTRALE DATEI
    //<< ;-------------------------------------------------------------------------------
    //<< new strCode
    mVar strCode = m$.var("strCode");
    m$.newVar(strCode);
    //<< 
    //<< set strCode = $$$WWW120ExecuteOnAfterSaveData(YVOR)
    strCode.set(include.WWWConst.$$$WWW120ExecuteOnAfterSaveData(m$,YVOR));
    //<< if strCode'="" {
    if (mOp.NotEqual(strCode.get(),"")) {
      //<< set YKEY = $translate(YKEY,"""")
      YKEY.set(m$.Fnc.$translate(YKEY.get(),"\""));
      //<< xecute strCode                                               ; *** EXECUTE Grid ***
      m$.Cmd.Xecute(strCode.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeSave(YKEY,YFELD,YVOR)
  public Object OnBeforeSave(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YVOR = m$.newVarRef("YVOR",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Run the Before Save code
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2009   GRF     Use field macro
    //<< ; 04-Jun-2006   shobby  SRBR014952: Prevent saving a line from a grid if no
    //<< ;                           valid lock is held.
    //<< ; 14-Apr-2005   shobby/pk   Get strStatus from YRETVAL
    //<< ; 19-Nov-2004   Shobby  Created (SR10468)
    //<< ; 07.06.2004    BEC     25866: DA ZENTRALE DATEI
    //<< ;-------------------------------------------------------------------------------
    //<< new strCode,strStatus
    mVar strCode = m$.var("strCode");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strCode,strStatus);
    //<< 
    //<< $$$LogR("OnBeforeSave",$get(YKEY)_":"_$get(YFELD)_"<")
    $$$LogR(m$,"OnBeforeSave",mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(YKEY),":"),m$.Fnc.$get(YFELD)),"<"));
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if '$$IsLockOkTest^WWWEVENT(YUSER,$$$GRIDContainer) {
    if (mOp.Not(m$.fnc$("WWWEVENT.IsLockOkTest",m$.var("YUSER").get(),include.COMGridEdit31Interface.$$$GRIDContainer(m$)))) {
      //<< set strStatus = $$$MakeStatus($$^WWWTEXT(392,,1))
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,m$.fnc$("WWWTEXT.main",392,null,1)));
    }
    //<< ; "Another User has changed the data record. Please Refresh This Page. Save is not possible."
    //<< } else {
    else {
      //<< set strCode = $$$WWW120ExecuteOnBeforeSaveData(YVOR)
      strCode.set(include.WWWConst.$$$WWW120ExecuteOnBeforeSaveData(m$,YVOR));
      //<< 
      //<< $$$LogRx("strCode:"_strCode)
      $$$LogRx(m$,mOp.Concat("strCode:",strCode.get()));
      //<< if strCode'="" {
      if (mOp.NotEqual(strCode.get(),"")) {
        //<< set YKEY = $translate(YKEY,"""")
        YKEY.set(m$.Fnc.$translate(YKEY.get(),"\""));
        //<< xecute strCode                                           ; *** EXECUTE Grid ***
        m$.Cmd.Xecute(strCode.get());
        //<< if $get(YRETVAL)'="" set strStatus = YRETVAL
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YRETVAL")),"")) {
          strStatus.set(m$.var("YRETVAL").get());
        }
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnBeforeDelete(YFORM,YKEY,YFELD)
  public Object OnBeforeDelete(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Run the Before Delete code
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Jun-2006   shobby  SRBR014952: Prevent deleting a line from a grid if no
    //<< ;                           valid lock is held.
    //<< ; 10-Feb-2006   RPW     SR14135: Show an alert if there is a message to show
    //<< ; 31-Oct-2005   JW      SR13626: ExecuteCode is unnecessary
    //<< ; 12-Oct-2005   JW      SR13670: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strCode,strStatus,strAlert
    mVar strCode = m$.var("strCode");
    mVar strStatus = m$.var("strStatus");
    mVar strAlert = m$.var("strAlert");
    m$.newVar(strCode,strStatus,strAlert);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set strAlert  = ""
    strAlert.set("");
    //<< 
    //<< set strStatus = $$IsLockOkTest^WWWEVENT(YUSER,$$$GRIDContainer)
    strStatus.set(m$.fnc$("WWWEVENT.IsLockOkTest",m$.var("YUSER").get(),include.COMGridEdit31Interface.$$$GRIDContainer(m$)));
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set strAlert = $$^WWWTEXT(392,,1)
      strAlert.set(m$.fnc$("WWWTEXT.main",392,null,1));
    }
    //<< ; "Another User has changed the data record. Please Refresh This Page. Save is not possible."
    //<< } else {
    else {
      //<< set strCode = $$$WWW120ExecuteBeforeDeletionData($$$GRIDYVOR(YFORM))
      strCode.set(include.WWWConst.$$$WWW120ExecuteBeforeDeletionData(m$,include.COMGridEdit31.$$$GRIDYVOR(m$,YFORM)));
      //<< 
      //<< if strCode'="" {
      if (mOp.NotEqual(strCode.get(),"")) {
        //<< set YKEY = $translate(YKEY,"""")
        YKEY.set(m$.Fnc.$translate(YKEY.get(),"\""));
        //<< xecute strCode                                           ; *** EXECUTE Grid ***
        m$.Cmd.Xecute(strCode.get());
      }
      //<< }
      //<< 
      //<< set strStatus = $$$OK
      strStatus.set(include.COMSYS.$$$OK(m$));
      //<< if $extract(Q)=1 {
      if (mOp.Equal(m$.Fnc.$extract(m$.var("Q").get()),1)) {
        //<< set strAlert  = $extract(Q,2,999)
        strAlert.set(m$.Fnc.$extract(m$.var("Q").get(),2,999));
        //<< set strStatus = '$$$OK
        strStatus.set(mOp.Not(include.COMSYS.$$$OK(m$)));
      }
    }
    //<< }
    //<< }
    //<< if strAlert'="" {
    if (mOp.NotEqual(strAlert.get(),"")) {
      //<< write "alert('"_strAlert_"');"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('",strAlert.get()),"');"));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnSetLineDefaults(p1,p2)
  public Object OnSetLineDefaults(Object ... _p) {
    mVar p1 = m$.newVarRef("p1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p2 = m$.newVarRef("p2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Sets line defaults. It calls the SetLineDefaults callback into the
    //<< ; grids form. Note the parameters are not used.
    //<< ;
    //<< ; Returns: 0 ($$$NO? $$$YQEnable? $$$Qsave?)
    //<< ;
    //<< ; History:
    //<< ; 25-Aug-2005   PO      SR12965: Get Header as well as Grid
    //<< ; 03-Feb-2005   RPW     Use the new ExecuteCode Command in COMUtils
    //<< ; 01-Feb-2005   shobby  Code Check.
    //<< ; 18-Jan-2005   RPW     Moved from 31R as this is an event handler.
    //<< ; 30-Dec-2004   RPW     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strCommand,objGrid
    mVar strCommand = m$.var("strCommand");
    mVar objGrid = m$.var("objGrid");
    m$.newVar(strCommand,objGrid);
    //<< 
    //<< do GetObject^COMGridEdit31Interface(.objGrid,$$$YES) ; returns both simple variable and array
    m$.Cmd.Do("COMGridEdit31Interface.GetObject",objGrid,include.COMSYS.$$$YES(m$));
    //<< set strCommand = "do SetLineDefaults^"_$get(^CacheTemp(YUSER,"Grid","Name"))_"(.objGrid)"
    strCommand.set(mOp.Concat(mOp.Concat("do SetLineDefaults^",m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name"))),"(.objGrid)"));
    //<< do CallEvent(strCommand,"Defaults")                              ; *** EXECUTE Grid ***
    m$.Cmd.Do("CallEvent",strCommand.get(),"Defaults");
    //<< 
    //<< quit 0
    return 0;
  }

  //<< 
  //<< 
  //<< OnGridUpdate(pidDataLine,YFELD,YFELDOLD,pstrFormName="")
  public Object OnGridUpdate(Object ... _p) {
    mVar pidDataLine = m$.newVarRef("pidDataLine",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELDOLD = m$.newVarRef("YFELDOLD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrFormName = m$.newVarRef("pstrFormName",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Hide the OnInternalBlur code from outside prying.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Jul-2009   GRF     SR16669: use consistent variable names
    //<< ; 23-Mar-2005   shobby  Translate the Key to a line reference.
    //<< ; 18-Jan-2005   RPW     Created (SR10061)
    //<< ;-------------------------------------------------------------------------------
    //<< new YLFDAT,OYFORM
    mVar YLFDAT = m$.var("YLFDAT");
    mVar OYFORM = m$.var("OYFORM");
    m$.newVar(YLFDAT,OYFORM);
    //<< 
    //<< if $get(pidDataLine)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidDataLine),"")) {
      //<< set YLFDAT = "Y"_$get($$$WWWDATEN("REFERENCEROW",pidDataLine,1))
      YLFDAT.set(mOp.Concat("Y",m$.Fnc.$get($$$WWWDATENVar(m$,"REFERENCEROW",pidDataLine,1))));
      //<< if pstrFormName'="" {
      if (mOp.NotEqual(pstrFormName.get(),"")) {
        //<< set OYFORM = YFORM
        OYFORM.set(m$.var("YFORM").get());
        //<< set YFORM  = pstrFormName
        mVar YFORM = m$.var("YFORM");
        YFORM.set(pstrFormName.get());
      }
      //<< }
      //<< do OnInternalBlur(YLFDAT,YFELD,YFELDOLD,pstrFormName)
      m$.Cmd.Do("OnInternalBlur",YLFDAT.get(),YFELD.get(),YFELDOLD.get(),pstrFormName.get());
      //<< 
      //<< if $get(OYFORM)'="" {
      if (mOp.NotEqual(m$.Fnc.$get(OYFORM),"")) {
        //<< set YFORM = OYFORM
        mVar YFORM = m$.var("YFORM");
        YFORM.set(OYFORM.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnGetText(strTextId,b)
  public Object OnGetText(Object ... _p) {
    mVar strTextId = m$.newVarRef("strTextId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar b = m$.newVarRef("b",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit $$$JSText($$DecodeError^COMUtils(strTextId))
    return include.COMSYSString.$$$JSText(m$,m$.fnc$("COMUtils.DecodeError",strTextId.get()));
  }

  //<< 
  //<< 
  //<< OnLineAdded(pstrYFORM,pintRowCount,pstrKey)
  public Object OnLineAdded(Object ... _p) {
    mVar pstrYFORM = m$.newVarRef("pstrYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintRowCount = m$.newVarRef("pintRowCount",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Before displaying the combo call out to see if we want to generate a custom
    //<< ; list.
    //<< ; Examples of use :
    //<< ;   FINAPInvLineEvents      - Make fields read only, update charges & discounts
    //<< ;   INDispenseToPatientLine - Set values for manual fields
    //<< ;
    //<< ; Called by: Macro $$$OnLineAdded in COMGridEdit31.INC
    //<< ;   AddLines^COMGridEdit31Body      LINEDATA^COMGridEdit31Body
    //<< ;   LineDataCD^COMGridEdit31Body2   LineDataAdd^COMGridEdit31Body2
    //<< ;
    //<< ; Inputs: pstrYFORM         Form ID
    //<< ;         pintRowCount      $$$WWWDATEN("ROWCOUNT")
    //<< ;         pstrKey           e.g. "REC0123",2.01 (strDataKeys)
    //<< ;
    //<< ; Returns: nothing
    //<< ;
    //<< ; History:
    //<< ; 06-Oct-2005   JW      SR11573: Call CallEvent
    //<< ; 03-Feb-2005   RobertW Use the new ExecuteCode Command in COMUtils...
    //<< ; 18-Jan-2005   Shobby  SR10061: Created
    //<< ;-------------------------------------------------------------------------------
    //<< $$$LogR("OnLineAdded",pstrYFORM_":"_pintRowCount_":"_pstrKey)
    $$$LogR(m$,"OnLineAdded",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrYFORM.get(),":"),pintRowCount.get()),":"),pstrKey.get()));
    //<< do CallEvent("do OnLineAdded^"_pstrYFORM_"("_pintRowCount_","""_$translate(pstrKey,$char(34))_""")","LineAdded")  ; *** EXECUTE Grid ***
    m$.Cmd.Do("CallEvent",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("do OnLineAdded^",pstrYFORM.get()),"("),pintRowCount.get()),",\""),m$.Fnc.$translate(pstrKey.get(),m$.Fnc.$char(34))),"\")"),"LineAdded");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnLineDeleted(pstrYFORM,pstrYKEY,pintRowCount)
  public Object OnLineDeleted(Object ... _p) {
    mVar pstrYFORM = m$.newVarRef("pstrYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrYKEY = m$.newVarRef("pstrYKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintRowCount = m$.newVarRef("pintRowCount",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Before displaying the combo call out to see if we want to generate a custom
    //<< ; list.
    //<< ;
    //<< ; Params:   pstrYFORM - grid form
    //<< ;           pstrYKEY - key of deleted line
    //<< ;           pintRowCount - number of rows in grid after this delete
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-Mar-2006   JW      SR13305: Added pstrYKEY parameter
    //<< ; 06-Oct-2005   JW      SR11573: Call CallEvent
    //<< ; 03-Feb-2005   RobertW Use the new ExecuteCode Command in COMUtils...
    //<< ; 18-Jan-2005   Shobby  SR10061: Created
    //<< ;-------------------------------------------------------------------------------
    //<< $$$LogR("OnLineDeleted",pstrYFORM_":"_pintRowCount_":"_pstrYKEY)
    $$$LogR(m$,"OnLineDeleted",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrYFORM.get(),":"),pintRowCount.get()),":"),pstrYKEY.get()));
    //<< do CallEvent("do OnLineDeleted^"_pstrYFORM_"("""_$translate(pstrYKEY,"""")_""","_pintRowCount_")","LineDeleted")  ; *** EXECUTE Grid ***
    m$.Cmd.Do("CallEvent",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("do OnLineDeleted^",pstrYFORM.get()),"(\""),m$.Fnc.$translate(pstrYKEY.get(),"\"")),"\","),pintRowCount.get()),")"),"LineDeleted");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnInternalBlur(pYLFDAT,YFELD,YFELDOLD,pstrFormName="")
  public Object OnInternalBlur(Object ... _p) {
    mVar pYLFDAT = m$.newVarRef("pYLFDAT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELDOLD = m$.newVarRef("YFELDOLD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrFormName = m$.newVarRef("pstrFormName",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Handles a blur call where the data is precalculated. YFELD contains the new
    //<< ; row data and YFELDOLD contains the old.
    //<< ; pYLFDAT is in the form tdYn of just Yn where n is the grid row number.
    //<< ;
    //<< ; This works on an entire row.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Oct-2010   PPP     SR16642: YKEY needs to be defined even if there are no
    //<< ;                           OnBlur events because the Scan needs it to be
    //<< ;                           available.  Moved it up the subroutine
    //<< ; 06-Jul-2007   shobby  SRBR014553: Consider customisation of WWW122, Renamed
    //<< ;                           objField to objWWW122
    //<< ; 16-Aug-2005   RPW     SR11983: Attempt to determine if the user changed set
    //<< ;                           this value or the system.  Also moved ScreenUpdate
    //<< ;                           outside the loop
    //<< ; 08-Jul-2005   RPW     Code Check
    //<< ; 29-Jun-2005   PO      SR12797: Removed ^COMGridEdit31S from call to AddReference
    //<< ; 17-Jun-2005   shobby  Code Check
    //<< ; 26-Apr-2005   RobertW Only blur fields if YFELD'=YFELDOLD
    //<< ; 21-Apr-2005   RobertW Only blur fields that have changed.
    //<< ; 28-Feb-2005   JW      Added call to AddReference - formatting for changes.
    //<< ; 17-Dec-2004   RobertW Modified to handle rows not starting at 1
    //<< ; 30-Dec-2004   RobertW Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strFormName,GCOL,strCommand,strYFELDOld,objWWW122,GROW,GDATA,YKEY
    mVar strFormName = m$.var("strFormName");
    mVar GCOL = m$.var("GCOL");
    mVar strCommand = m$.var("strCommand");
    mVar strYFELDOld = m$.var("strYFELDOld");
    mVar objWWW122 = m$.var("objWWW122");
    mVar GROW = m$.var("GROW");
    mVar GDATA = m$.var("GDATA");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(strFormName,GCOL,strCommand,strYFELDOld,objWWW122,GROW,GDATA,YKEY);
    //<< 
    //<< if pstrFormName'="" {
    if (mOp.NotEqual(pstrFormName.get(),"")) {
      //<< set strFormName = pstrFormName
      strFormName.set(pstrFormName.get());
    }
    //<< } else {
    else {
      //<< set strFormName = $get(^CacheTemp(YUSER,"Grid","Name"))
      strFormName.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    }
    //<< }
    //<< set GCOL  = ""
    GCOL.set("");
    //<< set GROW  = +$piece(pYLFDAT,"Y",2)
    GROW.set(mOp.Positive(m$.Fnc.$piece(pYLFDAT.get(),"Y",2)));
    //<< set GDATA = YFELD
    GDATA.set(YFELD.get());
    //<< 
    //<< set YKEY = $$GetYKEY^COMGridEdit31G(GROW,strFormName)   //SR16642
    YKEY.set(m$.fnc$("COMGridEdit31G.GetYKEY",GROW.get(),strFormName.get()));
    //<< 
    //<< if YFELD'=YFELDOLD {
    if (mOp.NotEqual(YFELD.get(),YFELDOLD.get())) {
      //<< if '$$$KilledRecord(GROW,strFormName) {
      if (mOp.Not(include.COMGridEdit31.$$$KilledRecord(m$,GROW,strFormName))) {
        //<< for {
        for (;true;) {
          //<< set GCOL = $order(^WWW122(0,strFormName,GCOL))
          GCOL.set(m$.Fnc.$order(m$.var("^WWW122",0,strFormName.get(),GCOL.get())));
          //<< quit:GCOL=""
          if (mOp.Equal(GCOL.get(),"")) {
            break;
          }
          //<< 
          //<< set objWWW122 = $$Get^WWW122(strFormName,GCOL) ; FIXME : Neither field used is customisable - faster to have direct get
          objWWW122.set(m$.fnc$("WWW122.Get",strFormName.get(),GCOL.get()));
          //<< 
          //<< ; FIXME : <GRF> Consider adding the following to ensure GFLD is available
          //<< ;         for any OnBlur called routines - see OnBlur above.
          //<< ;         If set, can use in following lines as well.
          //<< ;   set GFLD = $$$WWW122SequenceNumber(objWWW122)
          //<< 
          //<< if $$$WWW122ExecuteOnBlur(objWWW122)'="" {           ; *** EXECUTE Grid ***  May assume passing : GCOL,GROW,GDATA,GKEY,YKEY,YFELD -  but not GFLD?
          if (mOp.NotEqual(include.WWWConst.$$$WWW122ExecuteOnBlur(m$,objWWW122),"")) {
            //<< set strCommand = $$$WWW122ExecuteOnBlur(objWWW122)
            strCommand.set(include.WWWConst.$$$WWW122ExecuteOnBlur(m$,objWWW122));
            //<< 
            //<< if $piece(YFELD,Y,$$$WWW122SequenceNumber(objWWW122))'=$piece(YFELDOLD,Y,$$$WWW122SequenceNumber(objWWW122)) {
            if (mOp.NotEqual(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122)),m$.Fnc.$piece(YFELDOLD.get(),m$.var("Y").get(),include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122)))) {
              //<< //set YKEY = $$GetYKEY^COMGridEdit31G(GROW,strFormName)     //SR16642 Moved up
              //<< 
              //<< if strCommand'="" {
              if (mOp.NotEqual(strCommand.get(),"")) {
                //<< ;   do SetDirty^COMGridEdit31Interface(strFormName,GROW,GCOL,$$$NO)
                //<< xecute strCommand
                m$.Cmd.Xecute(strCommand.get());
              }
            }
            //<< }
            //<< }
            //<< do AddReference(GCOL)
            m$.Cmd.Do("AddReference",GCOL.get());
          }
        }
        //<< }
        //<< }
        //<< do ScreenUpdate^COMGridEdit31S(pYLFDAT,YFELD,YFELDOLD)
        m$.Cmd.Do("COMGridEdit31S.ScreenUpdate",pYLFDAT.get(),YFELD.get(),YFELDOLD.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AddReference(pidField,pstrType="D",pstrForm="")
  public Object AddReference(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"D");
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add a reference to a field that may have changed and requires recalculation
    //<< ; for display on screen.
    //<< ;
    //<< ; $$$WWWDATEN("REFERENCELIST") is processed and cleared by ScreenUpdateStyle^COMGridEdit31S
    //<< ;
    //<< ; This is a list of *FORM* field numbers, comma-delimited.
    //<< ;
    //<< ; Inputs:
    //<< ;   pidField    Class Field Id for "D" type entries, Form Field Id for "M"
    //<< ;                   or "P"  (These are identical for "P")
    //<< ;   pstrType    "P" for key, "D" for data fields based on classes, "M" for
    //<< ;                   Manual form fields.
    //<< ;   pstrForm    YFORM
    //<< ;
    //<< ; History:
    //<< ; 20-Jun-2005   Paul K  SR12496: Passed in pstrForm and newed YFORM
    //<< ;-------------------------------------------------------------------------------
    //<< quit:$get(pidField)=""
    if (mOp.Equal(m$.Fnc.$get(pidField),"")) {
      return null;
    }
    //<< 
    //<< if pstrForm="" set pstrForm = YFORM
    if (mOp.Equal(pstrForm.get(),"")) {
      pstrForm.set(m$.var("YFORM").get());
    }
    //<< new strList,YFORM
    mVar strList = m$.var("strList");
    mVar YFORM = m$.var("YFORM");
    m$.newVar(strList,YFORM);
    //<< 
    //<< set YFORM = pstrForm    ; (required for macro)
    YFORM.set(pstrForm.get());
    //<< 
    //<< set strList = $get($$$WWWDATEN("REFERENCELIST"),",")
    strList.set(m$.Fnc.$get($$$WWWDATENVar(m$,"REFERENCELIST"),","));
    //<< if pstrType="D" set pidField = $$$GetFormField(pstrForm,pidField) ; convert class field to form field
    if (mOp.Equal(pstrType.get(),"D")) {
      pidField.set(include.COMSYSWWW.$$$GetFormField(m$,pstrForm,pidField));
    }
    //<< 
    //<< if strList'[(","_pidField_",") {
    if (mOp.NotContains(strList.get(),(mOp.Concat(mOp.Concat(",",pidField.get()),",")))) {
      //<< set strList = strList_pidField_","
      strList.set(mOp.Concat(mOp.Concat(strList.get(),pidField.get()),","));
    }
    //<< }
    //<< 
    //<< set $$$WWWDATEN("REFERENCELIST") = strList
    $$$WWWDATENVar(m$,"REFERENCELIST").set(strList.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeDeleteAll()
  public Object OnBeforeDeleteAll(Object ... _p) {
    //<< ;/*-----------------------------------------------------------------------------
    //<< ; Callout to module for custom code as to whether to show the line or not. (SR11054)
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Mar-2006   RPW     SR14557 Created
    //<< ;-----------------------------------------------------------------------------*/
    //<< new blnDelete,strName,VORG
    mVar blnDelete = m$.var("blnDelete");
    mVar strName = m$.var("strName");
    mVar VORG = m$.var("VORG");
    m$.newVar(blnDelete,strName,VORG);
    //<< 
    //<< set blnDelete = $$$YES
    blnDelete.set(include.COMSYS.$$$YES(m$));
    //<< set strName   = $get(^CacheTemp(YUSER,"Grid","Name"))
    strName.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    //<< 
    //<< do CallEvent("set blnDelete=$$OnBeforeDeleteAll^"_strName_"()","DeleteAll")  ; *** EXECUTE Grid ***
    m$.Cmd.Do("CallEvent",mOp.Concat(mOp.Concat("set blnDelete=$$OnBeforeDeleteAll^",strName.get()),"()"),"DeleteAll");
    //<< 
    //<< quit blnDelete
    return blnDelete.get();
  }

  //<< 
  //<< 
  //<< OnBeforeCopy(pstrKey,&pobjLine)
  public Object OnBeforeCopy(Object ... _p) {
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjLine = m$.newVarRef("pobjLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Event before copying a line. Can update line data.
    //<< ;
    //<< ; Params:   pstrKey
    //<< ;
    //<< ; ByRefs:   pobjLine
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ;  6-Apr-2006   JW      SR14421: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strName
    mVar strName = m$.var("strName");
    m$.newVar(strName);
    //<< 
    //<< set strName = $get(^CacheTemp(YUSER,"Grid","Name"))
    strName.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    //<< do CallEvent("do OnBeforeCopy^"_strName_"(pstrKey,.pobjLine)","Copy")      ; *** EXECUTE Grid ***
    m$.Cmd.Do("CallEvent",mOp.Concat(mOp.Concat("do OnBeforeCopy^",strName.get()),"(pstrKey,.pobjLine)"),"Copy");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetRefresh(YFORM,YYKEY,YFELD,&pblnRefresh="")
  public Object SetRefresh(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YYKEY = m$.newVarRef("YYKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnRefresh = m$.newVarRef("pblnRefresh",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Before displaying the combo call out to see if we want to generate a custom
    //<< ; list.
    //<< ;
    //<< ; Inputs: (set to isolate variables)
    //<< ;   YFORM         Form ID
    //<< ;   YYKEY           pstrKey  - e.g. "REC0123",2.01 (strDataKeys)
    //<< ;   YFELD           pobjData - Record being processed
    //<< ;
    //<< ; Returns: nothing
    //<< ;
    //<< ; History:
    //<< ; 11-Aug-2009   GRF     SR16787: Created
    //<< ;-------------------------------------------------------------------------------
    //<< $$$LogR("Refresh",YFORM_":"_YYKEY)
    $$$LogR(m$,"Refresh",mOp.Concat(mOp.Concat(YFORM.get(),":"),YYKEY.get()));
    //<< 
    //<< if pblnRefresh="" {
    if (mOp.Equal(pblnRefresh.get(),"")) {
      //<< set pblnRefresh = ($get($$$EventExists("Refresh"))'=$$$NO)
      pblnRefresh.set((mOp.NotEqual(m$.Fnc.$get(include.COMGridEdit31.$$$EventExistsVar(m$,"Refresh")),include.COMSYS.$$$NO(m$))));
    }
    //<< }
    //<< 
    //<< if pblnRefresh do CallEvent("do SetRefresh^"_YFORM_"("""_$$$DEQUOTE(YYKEY)_""",YFELD)","Refresh")  ; *** EXECUTE Grid ***
    if (mOp.Logical(pblnRefresh.get())) {
      m$.Cmd.Do("CallEvent",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("do SetRefresh^",YFORM.get()),"(\""),include.COMSYSString.$$$DEQUOTE(m$,YYKEY)),"\",YFELD)"),"Refresh");
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CallEvent(pstrCode,pstrEvent)
  public Object CallEvent(Object ... _p) {
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrEvent = m$.newVarRef("pstrEvent",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Method to call a grid-based event that may not exist. If we:
    //<< ;   (a) know it exists, XECUTE it
    //<< ;   (b) otherwise, test it (and set) with ExecuteCode <-- always in dev
    //<< ;
    //<< ; Params:   pstrCode    - event code
    //<< ;           pstrEvent   - event name
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 31-Jul-2006   JW      SR14730: Reversed if conditions, use local var
    //<< ; 06-Feb-2006   RPW     SR14093: Do not do the event if we don't need to.
    //<< ; 06-Oct-2005   JW      SR11573: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strExists
    mVar strExists = m$.var("strExists");
    m$.newVar(strExists);
    //<< 
    //<< ; $$$EventExists(pstrEvent) can have 3 values:
    //<< 
    //<< set strExists = $get($$$EventExists(pstrEvent))                       ; *** EXECUTE Grid *** Wrapper for other executable calls
    strExists.set(m$.Fnc.$get(include.COMGridEdit31.$$$EventExistsVar(m$,pstrEvent)));
    //<< if strExists {              // TRUE - the event exists, so execute it
    if (mOp.Logical(strExists.get())) {
      //<< xecute pstrCode
      m$.Cmd.Xecute(pstrCode.get());
    }
    //<< 
    //<< } elseif strExists="" {     // NULL - don't know yet, so test
    else if (mOp.Equal(strExists.get(),"")) {
      //<< set $$$EventExists(pstrEvent) = $$ExecuteCode^COMUtils(pstrCode)
      include.COMGridEdit31.$$$EventExistsVar(m$,pstrEvent).set(m$.fnc$("COMUtils.ExecuteCode",pstrCode.get()));
    }
    //<< }
    //<< // FALSE - doesn't exist, so ignore it
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnSortGrid(pstrFocusCell,pstrSortData)
  public Object OnSortGrid(Object ... _p) {
    mVar pstrFocusCell = m$.newVarRef("pstrFocusCell",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrSortData = m$.newVarRef("pstrSortData",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Allow the grid to be sorted, finds the correct page and orders the data
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns: Null - Why?
    //<< ;
    //<< ; History:
    //<< ; 13-Aug-2013   shobby  CORE-172.1: Didn't fix sorting when primary key is a string.
    //<< ; 23-Jul-2013   shobby  CORE-172: Fix sorting on floating point numbers and when grid has more than one page.
    //<< ; 20-Jul-2012   shobby  SR18063: Can now sort by relation.
    //<< ; 16-Jul-2012   shobby  SR18061: Modification to allow sorting on Manual Fields.
    //<< ; 07-Mar-2011   GRF     SR17676.1: Primary keys don't have rules - won't have
    //<< ;                           idColumn defined.
    //<< ; 04-Mar-2011   shobby  SR17676: If a field has rules to calculate a transient value
    //<< ;                           then we can use this for sorting.  Careful, this could
    //<< ;                           slow things down.
    //<< ; 05-Dec-2008   HQN     SR16026: Missed a $$$GRIDPerPage macro replace
    //<< ; 03-Jun-2008   GRF     SR15739: Activate CreateDisplayList and deactivate
    //<< ;                           "DISPLAYORDER"; removed unused code previously
    //<< ;                           reverted on 22-May for clarity
    //<< ; 26-May-2008   GRF     SR15739: Reposition last "}" to correct place
    //<< ; 22-May-2008   GRF     SR15739: *** REVERT CHANGES FROM 14-May onwards keeping
    //<< ;                           change that ensures arithmetic is performed on
    //<< ;                           numbers rather than numeric value of string
    //<< ;                           i.e. "2" and "2x01" plus 1 => "3" instead of
    //<< ;                           "2.01" => "3.01"
    //<< ; 15-May-2008   HQN     SR15739: Store last sort for later retrieval, insertions
    //<< ;                           after sorting require resorting
    //<< ; 14-May-2008   HQN     SR15739: Corrected reordering of DISPLAYORDER, copied lines
    //<< ;                       are treated as floats
    //<< ; ***********
    //<< ; 16-Jul-2012   shobby  SR18061:    Allow sorting on Manual Fields.
    //<< ; 14-May-2008   shobby  SRBR014943: GRIDPerPage
    //<< ; 27-Mar-2008   shobby  SRBR014918: Removed a crash when sorting on long strings.
    //<< ; 25-Sep-2007   shobby  SRBR014701: Removed references to idClass
    //<< ; 21-Sep-2007   shobby  SRBR014701: If the field is a primary key don't do the 'checkbox' test.
    //<< ; 11-Sep-2007   shobby  SRBR014701: If a boolean field then empty is the same as false.
    //<< ; 04-Sep-2007   shobby  SRBR014701: Incorrect parameter used in $$$GRIDGetYFELD
    //<< ; 07-Aug-2007   shobby  SR15529: Removed crash when trying to sort on unsaved data
    //<< ; 19-Jul-2007   RPW     SR15529: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrRow,blnCheckbox,blnHasRules,blnPrimary,idColumn,idGridRow,idKey,idSeqNum
    mVar arrRow = m$.var("arrRow");
    mVar blnCheckbox = m$.var("blnCheckbox");
    mVar blnHasRules = m$.var("blnHasRules");
    mVar blnPrimary = m$.var("blnPrimary");
    mVar idColumn = m$.var("idColumn");
    mVar idGridRow = m$.var("idGridRow");
    mVar idKey = m$.var("idKey");
    mVar idSeqNum = m$.var("idSeqNum");
    m$.newVar(arrRow,blnCheckbox,blnHasRules,blnPrimary,idColumn,idGridRow,idKey,idSeqNum);
    //<< new intCol,intColumn,intDirection,intPage,intPageRow,intPos,intRow
    mVar intCol = m$.var("intCol");
    mVar intColumn = m$.var("intColumn");
    mVar intDirection = m$.var("intDirection");
    mVar intPage = m$.var("intPage");
    mVar intPageRow = m$.var("intPageRow");
    mVar intPos = m$.var("intPos");
    mVar intRow = m$.var("intRow");
    m$.newVar(intCol,intColumn,intDirection,intPage,intPageRow,intPos,intRow);
    //<< new loop,objData,strDescription,strOrder,strValue
    mVar loop = m$.var("loop");
    mVar objData = m$.var("objData");
    mVar strDescription = m$.var("strDescription");
    mVar strOrder = m$.var("strOrder");
    mVar strValue = m$.var("strValue");
    m$.newVar(loop,objData,strDescription,strOrder,strValue);
    //<< new blnByRelation ;SR18063
    mVar blnByRelation = m$.var("blnByRelation");
    m$.newVar(blnByRelation);
    //<< new intType ;CORE-172
    mVar intType = m$.var("intType");
    m$.newVar(intType);
    //<< 
    //<< set intType=1 ;CORE-172
    intType.set(1);
    //<< 
    //<< set intColumn      = $piece(pstrSortData,Y,1)
    intColumn.set(m$.Fnc.$piece(pstrSortData.get(),m$.var("Y").get(),1));
    //<< set strDescription = $piece(pstrSortData,Y,2)
    strDescription.set(m$.Fnc.$piece(pstrSortData.get(),m$.var("Y").get(),2));
    //<< set blnByRelation  = $piece(pstrSortData,Y,3)  ;SR18063
    blnByRelation.set(m$.Fnc.$piece(pstrSortData.get(),m$.var("Y").get(),3));
    //<< set blnPrimary     = $$$IsPrimaryKey(intColumn)
    blnPrimary.set($$$IsPrimaryKey(m$,intColumn));
    //<< 
    //<< $$$GRIDSplitKey(pstrFocusCell,intRow,intCol)
    include.COMGridEdit31Interface.$$$GRIDSplitKey(m$,pstrFocusCell,intRow,intCol);
    //<< set idSeqNum = -1 // Allow for Primary Keys
    idSeqNum.set(mOp.Negative(1));
    //<< 
    //<< set blnCheckbox = $$$NO
    blnCheckbox.set(include.COMSYS.$$$NO(m$));
    //<< if 'blnPrimary {
    if (mOp.Not(blnPrimary.get())) {
      //<< set idColumn    = $piece($$$GRIDColumnOrder,$$$COMMA,intColumn)
      idColumn.set(m$.Fnc.$piece(include.COMGridEdit31Interface.$$$GRIDColumnOrder(m$),include.COMSYSString.$$$COMMA(m$),intColumn.get()));
      //<< set intType     = $$GetFieldType^COMUtilClass(YFORM,idColumn) ;CORE-172
      intType.set(m$.fnc$("COMUtilClass.GetFieldType",m$.var("YFORM").get(),idColumn.get()));
      //<< set blnCheckbox = (intType=2)                                 ;CORE-172
      blnCheckbox.set((mOp.Equal(intType.get(),2)));
      //<< set idSeqNum    = $$$WWW122SequenceNumber($get(^WWW122(0,YFORM,idColumn,1)))
      idSeqNum.set(include.WWWConst.$$$WWW122SequenceNumber(m$,m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),idColumn.get(),1))));
    }
    //<< }
    //<< 
    //<< ;-----------------------------------
    //<< ; - Sort by selected column by copying values into an array
    //<< ;-----------------------------------
    //<< 
    //<< ;   set blnHasRules = $$HasRules^WWWFORMD(YFORM,idColumn)                       ;SR17676
    //<< set blnHasRules = ('blnPrimary && $$HasRules^WWWFORMD(YFORM,idColumn))      ;SR17676.1
    blnHasRules.set((mOp.Not(blnPrimary.get()) && mOp.Logical(m$.fnc$("WWWFORMD.HasRules",m$.var("YFORM").get(),idColumn.get()))));
    //<< set idGridRow = ""
    idGridRow.set("");
    //<< for {
    for (;true;) {
      //<< set idGridRow = $order(^WWWDATEN(0,+$horolog,YUSER,YFORM,"V","REFERENCEKEY",idGridRow))
      idGridRow.set(m$.Fnc.$order(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","REFERENCEKEY",idGridRow.get())));
      //<< quit:idGridRow=""
      if (mOp.Equal(idGridRow.get(),"")) {
        break;
      }
      //<< 
      //<< set idKey = $translate($get($$$WWWDATEN("REFERENCEKEY",idGridRow,1)),"""") ;CORE-172.1
      idKey.set(m$.Fnc.$translate(m$.Fnc.$get($$$WWWDATENVar(m$,"REFERENCEKEY",idGridRow,1)),"\""));
      //<< if blnPrimary {                                ; Primary Key
      if (mOp.Logical(blnPrimary.get())) {
        //<< set strValue = $$$KEYMAX(idKey)
        strValue.set(include.COMSYSWWW.$$$KEYMAX(m$,idKey));
      }
      //<< 
      //<< } else {
      else {
        //<< set objData  = $$$GRIDGetYFELD(idKey)
        objData.set(include.COMGridEdit31Interface.$$$GRIDGetYFELD(m$,idKey));
        //<< if idSeqNum="" { ;Manual Field                                                      ;SR18061
        if (mOp.Equal(idSeqNum.get(),"")) {
          //<< ;CORE-172 set strValue   = $$GetYMFELDValue^COMGridEdit31G(idGridRow,idColumn)  ;SR18061
          //<< set strValue = $$GetDefaultValue^COMGridEdit31Body(YFORM,idKey,idColumn,intType,objData) ;CORE-172
          strValue.set(m$.fnc$("COMGridEdit31Body.GetDefaultValue",m$.var("YFORM").get(),idKey.get(),idColumn.get(),intType.get(),objData.get()));
        }
        //<< } else {                                                                    ;SR18061
        else {
          //<< set strValue = $piece(objData,Y,idSeqNum)                               ;SR18061
          strValue.set(m$.Fnc.$piece(objData.get(),m$.var("Y").get(),idSeqNum.get()));
        }
        //<< }                                                                           ;SR18061
        //<< if blnByRelation {                                                                  ;SR18063
        if (mOp.Logical(blnByRelation.get())) {
          //<< set strValue=$$GetRelation^COMGridEdit31Excel(YFORM,idColumn,strValue,$$$YES)   ;SR18063
          strValue.set(m$.fnc$("COMGridEdit31Excel.GetRelation",m$.var("YFORM").get(),idColumn.get(),strValue.get(),include.COMSYS.$$$YES(m$)));
        }
        //<< }                                                                                   ;SR18063
        //<< if blnHasRules do CheckRules^WWWFORMD(YFORM,idColumn,objData,,,,,,,,,,,,.strValue)  ;SR17676
        if (mOp.Logical(blnHasRules.get())) {
          m$.Cmd.Do("WWWFORMD.CheckRules",m$.var("YFORM").get(),idColumn.get(),objData.get(),null,null,null,null,null,null,null,null,null,null,null,strValue);
        }
      }
      //<< }
      //<< if blnCheckbox {
      if (mOp.Logical(blnCheckbox.get())) {
        //<< if $$$TRIMWS(strValue)="" set strValue=0   ; checkbox test
        if (mOp.Equal(include.COMSYSString.$$$TRIMWS(m$,strValue),"")) {
          strValue.set(0);
        }
      }
      //<< } else {
      else {
        //<< if strValue="" set strValue=" "
        if (mOp.Equal(strValue.get(),"")) {
          strValue.set(" ");
        }
      }
      //<< }
      //<< set strValue = $extract(strValue,1,255)
      strValue.set(m$.Fnc.$extract(strValue.get(),1,255));
      //<< if intType=12 {                                ;Floating    ;CORE-172
      if (mOp.Equal(intType.get(),12)) {
        //<< set strValue=+strValue                                  ;CORE-172
        strValue.set(mOp.Positive(strValue.get()));
      }
      //<< }                                                           ;CORE-172
      //<< set arrRow(strValue,idGridRow)=""              ; Order by value and then row id
      arrRow.var(strValue.get(),idGridRow.get()).set("");
    }
    //<< }
    //<< set strOrder   = ""
    strOrder.set("");
    //<< set intPageRow = 1
    intPageRow.set(1);
    //<< 
    //<< ;-----------------------------------
    //<< ; - Order the data by value in the direction required.
    //<< ;   If multiple rows have the same value sub-sort in
    //<< ;   ascending order of the row number.
    //<< ; - Identify the new absolute position (intPageRow) of
    //<< ;   the line that currently has focus (intRow).
    //<< ;-----------------------------------
    //<< 
    //<< set intDirection = $select($$$JSBoolean(strDescription):$$$DirUp,1:$$$DirDown)
    intDirection.set(m$.Fnc.$select(include.COMSYS.$$$JSBoolean(m$,strDescription),include.COMSYS.$$$DirUp(m$),1,include.COMSYS.$$$DirDown(m$)));
    //<< set strValue = ""
    strValue.set("");
    //<< for {
    for (;true;) {
      //<< set strValue = $order(arrRow(strValue),intDirection)
      strValue.set(m$.Fnc.$order(arrRow.var(strValue.get()),intDirection.get()));
      //<< quit:strValue=""
      if (mOp.Equal(strValue.get(),"")) {
        break;
      }
      //<< 
      //<< set idGridRow = ""
      idGridRow.set("");
      //<< for {
      for (;true;) {
        //<< set idGridRow = $order(arrRow(strValue,idGridRow),$$$DirDown)
        idGridRow.set(m$.Fnc.$order(arrRow.var(strValue.get(),idGridRow.get()),include.COMSYS.$$$DirDown(m$)));
        //<< quit:idGridRow=""
        if (mOp.Equal(idGridRow.get(),"")) {
          break;
        }
        //<< 
        //<< set strOrder = strOrder_$$$COMMA_idGridRow
        strOrder.set(mOp.Concat(mOp.Concat(strOrder.get(),include.COMSYSString.$$$COMMA(m$)),idGridRow.get()));
        //<< if idGridRow=intRow {
        if (mOp.Equal(idGridRow.get(),intRow.get())) {
          //<< set intPageRow = $length(strOrder,$$$COMMA)-1
          intPageRow.set(mOp.Subtract(m$.Fnc.$length(strOrder.get(),include.COMSYSString.$$$COMMA(m$)),1));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< ;-----------------------------------
    //<< ; - Figure out the correct page for the line that
    //<< ;   currently has focus.
    //<< ;-----------------------------------
    //<< 
    //<< ;   set intPage = ((intPageRow-1)\$get($$$GRIDPerPage))+1 ; SR16026
    //<< set intPage = ((intPageRow-1)\$$GetRowsPerPage^COMGridEdit31(YBED,YFORM))+1
    intPage.set(mOp.Add((mOp.IntegerDivide((mOp.Subtract(intPageRow.get(),1)),m$.fnc$("COMGridEdit31.GetRowsPerPage",m$.var("YBED").get(),m$.var("YFORM").get()))),1));
    //<< 
    //<< ;-----------------------------------
    //<< ; Setup the display order in "DISPLAYLIST"
    //<< ;
    //<< ; Display order is a true linked list - see heading in COMGridEdit31List for an explanation
    //<< ;-----------------------------------
    //<< do CreateDisplayList^COMGridEdit31List(strOrder)    ; SR15739 (testing)
    m$.Cmd.Do("COMGridEdit31List.CreateDisplayList",strOrder.get());
    //<< 
    //<< write $$$GRIDGoToPage(intPage,$$$GRIDNumPages,pstrFocusCell,$$$NO)
    m$.Cmd.Write(include.COMGridEdit31.$$$GRIDGoToPage(m$,intPage,include.COMGridEdit31.$$$GRIDNumPages(m$),pstrFocusCell,include.COMSYS.$$$NO(m$)));
    //<< quit ""
    return "";
  }

//<< 
//<< 
}
