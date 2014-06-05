//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewFilter
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:09
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;
//<< #include COMConst
import include.COMConst;
//<< #include COMView
import include.COMView;
//<< #include COMGridEdit31
import include.COMGridEdit31;

//<< COMViewFilter ; entry point for COMView
public class COMViewFilter extends mClass {

  //<< 
  //<< ; Set the row limit to MAX(+$get(^SysSetup("COMViewLimit",YM)),59)
  //<< #define RowLimit    $select(+$get(^SysSetup("COMViewLimit",YM))>=59:+$get(^SysSetup("COMViewLimit",YM)),1:59)
  public static Object $$$RowLimit(mContext m$) {
    return (m$.Fnc.$select(mOp.GreaterOrEqual(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","COMViewLimit",m$.var("YM").get()))),59),mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","COMViewLimit",m$.var("YM").get()))),1,59));
  }

  //<< 
  //<< #define Separator   ";:;"
  public static Object $$$Separator(mContext m$) {
    return (";:;");
  }

  public void main() {
    _COMViewFilter();
  }

  public void _COMViewFilter() {
  }

  //<< 
  //<< LoadCOMViewGrid(pstrParentForm,pstrGridForm,pstrTabList="")
  public Object LoadCOMViewGrid(Object ... _p) {
    mVar pstrParentForm = m$.newVarRef("pstrParentForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrGridForm = m$.newVarRef("pstrGridForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrTabList = m$.newVarRef("pstrTabList",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Allow a COMViewGrid to be shown
    //<< ;
    //<< ; Params:
    //<< ;   pstrTabList     Only process if current tab is in comma-delimited list;
    //<< ;                   Empty list means load for all tabs
    //<< ;
    //<< ; ByRef :  YSEITE   Current Tab
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Apr-2010   GRF     -: clarify pidSite => pidTabNo
    //<< ; 09-Feb-2007   RPW     SR15426: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if pstrTabList'="" {
    if (mOp.NotEqual(pstrTabList.get(),"")) {
      //<< quit:'$find($$$COMMA_pstrTabList_$$$COMMA,$$$COMMA_YSEITE_$$$COMMA)
      if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(include.COMSYSString.$$$COMMA(m$),pstrTabList.get()),include.COMSYSString.$$$COMMA(m$)),mOp.Concat(mOp.Concat(include.COMSYSString.$$$COMMA(m$),m$.var("YSEITE").get()),include.COMSYSString.$$$COMMA(m$))))) {
        return null;
      }
    }
    //<< }
    //<< 
    //<< kill ^CacheTempView(YUSER)
    m$.var("^CacheTempView",m$.var("YUSER").get()).kill();
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< do AfterDataFields(pstrParentForm_":"_pstrGridForm,$$$YES,$$$YES)
    m$.Cmd.Do("AfterDataFields",mOp.Concat(mOp.Concat(pstrParentForm.get(),":"),pstrGridForm.get()),include.COMSYS.$$$YES(m$),include.COMSYS.$$$YES(m$));
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AfterDataFields(pstrForm="",pblnHyper=$$$NO,pblnInForm=$$$NO,pblnBackArrow=$$$NO)
  public Object AfterDataFields(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pblnHyper = m$.newVarRef("pblnHyper",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar pblnInForm = m$.newVarRef("pblnInForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    mVar pblnBackArrow = m$.newVarRef("pblnBackArrow",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called from @Net form COMView search. Setups up screen.
    //<< ;
    //<< ; History:
    //<< ; 23-Aug-2013   shobby  CORE-215: COMView created on a manual form (INARTStockHistory) would not show Mega Menu
    //<< ; 23-Aug-2011   shobby  SR17874: Need to be careful to use , or ~ appropriately
    //<< ;                           with Primary Key or Data Field.
    //<< ; 04-Nov-2010   GRF     SR17531: rename idForms and strForm to strFormList and
    //<< ;                           strViewForm to better distinguish from idForm and
    //<< ;                           pstrForm
    //<< ; 13-Aug-2010   shobby  SR17469: In firefox there was a form heading visible when
    //<< ;                           the COMView is supposed to cover the whole screen.
    //<< ; 17-Jul-2010   shobby  SR17418: Can't use setExpression for recalculating height.
    //<< ; 29-Apr-2009   PPP     SR16499: Used ColSel to create new Javascript COMView
    //<< ;                           Global - GLOBALblnColSelect
    //<< ; 27-Apr-2009   shobby  SR16108: Optionally include a back arrow.
    //<< ; 09-Sep-2008   PP      SR15866:Update COMView to Objects
    //<< ; 07-Nov-2007   GRF     SR15610: Make form name dynamic on Help button tooltip
    //<< ; 20-Jun-2007   KARINE  SRBR014541: Make sure that the Default favourite works
    //<< ;                           for non COMViewGrid forms
    //<< ; 22-May-2007   RPW     SR15524: If no views to show, do not show do anywork
    //<< ; 30-Mar-2007   RPW     SRBR014416: Handle the grid when the COMView is hidden
    //<< ;                           from view.
    //<< ; 15-Feb-2007   Steve S SR15431: Use standard alert, not VBConfirm
    //<< ; 09-Feb-2007   RPW     SR15426: Add the ability for a COMView to exist on the
    //<< ;                           main page & sub COMViews to work correctly as well
    //<< ; 11-Dec-2006   JW      SR15299: Check for language translation
    //<< ; 19-Sep-2006   JW      SR14937: Don't show select all button, if not a pop up.
    //<< ; 14-Sep-2006   RPW     SR15001: Set the value of GLOBALblnMultiSelect so that
    //<< ;                           the colourisation of clicked and highlighted lines
    //<< ;                           only shows for multi-select grids
    //<< ; 12-Sep-2006   RPW     SR15029: Fixed so that when the Use Key Stroke is on,
    //<< ;                           then we show more records, otherwise don't show any
    //<< ; 29-Aug-2006   JW      SR14763: Language text
    //<< ; 08-Aug-2006   RPW     SR14896: kill old SQL for this user and form.
    //<< ; 22-Jun-2006   Pablo   SR14221: Removed hard coding 'User' package
    //<< ; 28-Apr-2006   JW      SR14427: Added calling form CacheTemp
    //<< ; 19-Apr-2006   JW      SR14429: Added functionality for views
    //<< ;  7-Oct-2005   JW      SR13637: WWWDATEN is not shared
    //<< ; 28-Sep-2005   JW      SR13447: Store field type and number
    //<< ; 23-Aug-2005   JW      SR12876: Removed appended value
    //<< ; 21-Jun-2005   Paul K  Compile @Net instead of compile class.
    //<< ; 25-May-2005   Paul K  SR12268: Use Grid Value if Not null (don't worry about
    //<< ;                           form type)
    //<< ; 11-May-2005   PO/PK   SR12142: Enabling select all feature
    //<< ; 03-May-2005   PO      SR12268: WWWDATEN approach for grid does not work,
    //<< ;                           adjusted to work correctly.
    //<< ; 14-Apr-2005   PO      If value to filter on not passed in just pull straight
    //<< ;                           out of WWWDATEN
    //<< ; 16-Feb-2005   PO/PK   SR11661: Populate default filter with value
    //<< ;                           from field search being performed upon.
    //<< ; 30-Nov-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new appendValue,FilterLoop,KeyStrokeDelay     ; FIXME : prefixes
    mVar appendValue = m$.var("appendValue");
    mVar FilterLoop = m$.var("FilterLoop");
    mVar KeyStrokeDelay = m$.var("KeyStrokeDelay");
    m$.newVar(appendValue,FilterLoop,KeyStrokeDelay);
    //<< 
    //<< new arrValues,arrViews,blnObj,blnOk,blnUseKeyStroke
    mVar arrValues = m$.var("arrValues");
    mVar arrViews = m$.var("arrViews");
    mVar blnObj = m$.var("blnObj");
    mVar blnOk = m$.var("blnOk");
    mVar blnUseKeyStroke = m$.var("blnUseKeyStroke");
    m$.newVar(arrValues,arrViews,blnObj,blnOk,blnUseKeyStroke);
    //<< new idCallingForm,idClass,idFieldNo,idFieldType,idForm,idGridValue,idKey
    mVar idCallingForm = m$.var("idCallingForm");
    mVar idClass = m$.var("idClass");
    mVar idFieldNo = m$.var("idFieldNo");
    mVar idFieldType = m$.var("idFieldType");
    mVar idForm = m$.var("idForm");
    mVar idGridValue = m$.var("idGridValue");
    mVar idKey = m$.var("idKey");
    m$.newVar(idCallingForm,idClass,idFieldNo,idFieldType,idForm,idGridValue,idKey);
    //<< new idParent,idParentUser,idRelation,idUser,idView,lstFilters
    mVar idParent = m$.var("idParent");
    mVar idParentUser = m$.var("idParentUser");
    mVar idRelation = m$.var("idRelation");
    mVar idUser = m$.var("idUser");
    mVar idView = m$.var("idView");
    mVar lstFilters = m$.var("lstFilters");
    m$.newVar(idParent,idParentUser,idRelation,idUser,idView,lstFilters);
    //<< new objWWW012,objCompiledClass,strFormList,strHeight,strPackage,strValue,strViewForm
    mVar objWWW012 = m$.var("objWWW012");
    mVar objCompiledClass = m$.var("objCompiledClass");
    mVar strFormList = m$.var("strFormList");
    mVar strHeight = m$.var("strHeight");
    mVar strPackage = m$.var("strPackage");
    mVar strValue = m$.var("strValue");
    mVar strViewForm = m$.var("strViewForm");
    m$.newVar(objWWW012,objCompiledClass,strFormList,strHeight,strPackage,strValue,strViewForm);
    //<< 
    //<< ;--------------------------------------- PRESERVE USER
    //<< set idUser = YUSER
    idUser.set(m$.var("YUSER").get());
    //<< 
    //<< if +$get(^CacheTempView(YUSER,YUCI,"InForm")) {   ; We have an In-Form COMView already on the screen.
    if (mOp.Logical(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm"))))) {
      //<< set idUser = $$GetChildUser^WWWUSER(YUSER)
      idUser.set(m$.fnc$("WWWUSER.GetChildUser",m$.var("YUSER").get()));
      //<< merge ^CacheTempFixedField(idUser) = ^CacheTempFixedField(YUSER)
      m$.Cmd.Merge(m$.var("^CacheTempFixedField",idUser.get()),m$.var("^CacheTempFixedField",m$.var("YUSER").get()));
      //<< set idParentUser = YUSER
      idParentUser.set(m$.var("YUSER").get());
    }
    //<< }
    //<< new YUSER
    mVar YUSER = m$.var("YUSER");
    m$.newVar(YUSER);
    //<< set YUSER = idUser
    YUSER.set(idUser.get());
    //<< ;---------------------------------------
    //<< 
    //<< kill ^CacheTempView(YUSER)
    m$.var("^CacheTempView",YUSER.get()).kill();
    //<< kill ^CacheTempSQL($$$SQLID)
    m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$)).kill();
    //<< 
    //<< set ^CacheTempView(YUSER,"BackArrow") = pblnBackArrow
    m$.var("^CacheTempView",YUSER.get(),"BackArrow").set(pblnBackArrow.get());
    //<< 
    //<< set ^CacheTempView(YUSER,"LastSQL")   = 1
    m$.var("^CacheTempView",YUSER.get(),"LastSQL").set(1);
    //<< 
    //<< if $get(idParentUser)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(idParentUser),"")) {
      //<< set ^CacheTempView(idParentUser,YUCI,"YUSER") = YUSER
      m$.var("^CacheTempView",idParentUser.get(),m$.var("YUCI").get(),"YUSER").set(YUSER.get());
    }
    //<< }
    //<< if 'pblnInForm {
    if (mOp.Not(pblnInForm.get())) {
      //<< // This is not based on the value of YNOFOOT, it's based on it the fact the YNOFOOT is defined or not ""
      //<< set YNOFOOT = 1  ; stops showing crap at botton of popup.
      mVar YNOFOOT = m$.var("YNOFOOT");
      YNOFOOT.set(1);
    }
    //<< }
    //<< 
    //<< set idFieldType = ""
    idFieldType.set("");
    //<< set idFieldNo   = ""
    idFieldNo.set("");
    //<< 
    //<< if $$IsList^COMUtils(pstrForm) {
    if (mOp.Logical(m$.fnc$("COMUtils.IsList",pstrForm.get()))) {
      //<< set idForm      = $listget(pstrForm,1)
      idForm.set(m$.Fnc.$listget(pstrForm.get(),1));
      //<< set idRelation  = $listget(pstrForm,2)
      idRelation.set(m$.Fnc.$listget(pstrForm.get(),2));
      //<< set idKey       = $listget(pstrForm,3)
      idKey.set(m$.Fnc.$listget(pstrForm.get(),3));
      //<< set strValue    = $listget(pstrForm,4)
      strValue.set(m$.Fnc.$listget(pstrForm.get(),4));
      //<< set idGridValue = $listget(pstrForm,5)
      idGridValue.set(m$.Fnc.$listget(pstrForm.get(),5));
      //<< 
      //<< set idParent = ""
      idParent.set("");
      //<< do GetFieldDetails^COMUtilForm(idRelation,,.idFieldType,.idFieldNo)
      m$.Cmd.Do("COMUtilForm.GetFieldDetails",idRelation.get(),null,idFieldType,idFieldNo);
      //<< 
      //<< if strValue="" {
      if (mOp.Equal(strValue.get(),"")) {
        //<< ;   do GetFieldDetails^COMUtilForm(idRelation,,.idFieldType,.idFieldNo)
        //<< if idGridValue'="" {
        if (mOp.NotEqual(idGridValue.get(),"")) {
          //<< set strValue = idGridValue
          strValue.set(idGridValue.get());
        }
        //<< } else {
        else {
          //<< if ($get(idForm)'="") && ($get(idFieldType)'="") && ($get(idFieldNo)'="") {
          if ((mOp.NotEqual(m$.Fnc.$get(idForm),"")) && (mOp.NotEqual(m$.Fnc.$get(idFieldType),"")) && (mOp.NotEqual(m$.Fnc.$get(idFieldNo),""))) {
            //<< set strDaten = $get(^WWWDATEN(0,+$horolog,$$$GetParentUser(YUSER),idForm,idFieldType,1))  ;SR17874
            mVar strDaten = m$.var("strDaten");
            strDaten.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),include.COMSYSWWW.$$$GetParentUser(m$,YUSER),idForm.get(),idFieldType.get(),1)));
            //<< ;SR17874        set strValue = $piece(strDaten,Y,idFieldNo)
            //<< if idFieldType="P" {                                                                    ;SR17874
            if (mOp.Equal(idFieldType.get(),"P")) {
              //<< set strValue = $piece(strDaten,",",idFieldNo)                                       ;SR17874
              strValue.set(m$.Fnc.$piece(strDaten.get(),",",idFieldNo.get()));
            }
            //<< } else {                                                                                ;SR17874
            else {
              //<< set strValue = $piece(strDaten,Y,idFieldNo)                                         ;SR17874
              strValue.set(m$.Fnc.$piece(strDaten.get(),m$.var("Y").get(),idFieldNo.get()));
            }
          }
        }
      }
    }
    //<< }                                                                                       ;SR17874
    //<< }
    //<< }
    //<< }
    //<< 
    //<< } else {   ;   [ idParent : ] idForm , idRelation , idKey1 [, idKey2 [, ...] ]
    else {
      //<< set strFormList = $piece(pstrForm,",",1)
      strFormList.set(m$.Fnc.$piece(pstrForm.get(),",",1));
      //<< if pblnInForm {
      if (mOp.Logical(pblnInForm.get())) {
        //<< set idForm   = $piece(strFormList,":",2)
        idForm.set(m$.Fnc.$piece(strFormList.get(),":",2));
        //<< set idParent = $piece(strFormList,":",1)
        idParent.set(m$.Fnc.$piece(strFormList.get(),":",1));
      }
      //<< } else {
      else {
        //<< set idForm   = $piece(strFormList,":",1)
        idForm.set(m$.Fnc.$piece(strFormList.get(),":",1));
        //<< set idParent = ""
        idParent.set("");
      }
      //<< }
      //<< 
      //<< set idRelation = $piece(pstrForm,",",2)
      idRelation.set(m$.Fnc.$piece(pstrForm.get(),",",2));
      //<< set idKey      = $piece(pstrForm,",",3,$length(pstrForm,","))
      idKey.set(m$.Fnc.$piece(pstrForm.get(),",",3,m$.Fnc.$length(pstrForm.get(),",")));
    }
    //<< 
    //<< }
    //<< 
    //<< set idCallingForm = idForm
    idCallingForm.set(idForm.get());
    //<< set idClass = ""
    idClass.set("");
    //<< if $get(idRelation)'="" set idForm = $$GetRelationForm(idRelation,.idClass,idKey)
    if (mOp.NotEqual(m$.Fnc.$get(idRelation),"")) {
      idForm.set(m$.fnc$("GetRelationForm",idRelation.get(),idClass,idKey.get()));
    }
    //<< 
    //<< ; No Form exists - treat as class
    //<< kill ^CacheTempObj(YUSER)
    m$.var("^CacheTempObj",YUSER.get()).kill();
    //<< if (idForm'="") && '$data(^WWW120(0,idForm)) {
    if ((mOp.NotEqual(idForm.get(),"")) && mOp.Not(m$.Fnc.$data(m$.var("^WWW120",0,idForm.get())))) {
      //<< if '$data(^WWW001(0,idForm)) set ^CacheTempObj(YUSER,"Object") = 1  ; Only if no @NM class exists
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW001",0,idForm.get())))) {
        m$.var("^CacheTempObj",YUSER.get(),"Object").set(1);
      }
      //<< set (idClass,idParent) = idForm
      idClass.set(idForm.get());
      idParent.set(idForm.get());
    }
    //<< }
    //<< 
    //<< if (idForm'="") && $data(^WWW120(0,idForm)) || (idClass'="") {
    if ((mOp.NotEqual(idForm.get(),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^WWW120",0,idForm.get()))) || (mOp.NotEqual(idClass.get(),""))) {
      //<< if idClass="" set idClass = $$$WWW120ClassUsedInForm($get(^WWW120(0,idForm,1)))
      if (mOp.Equal(idClass.get(),"")) {
        idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,idForm.get(),1))));
      }
      //<< 
      //<< // SR12876 - Removed appended value
      //<< set appendValue = $get(^CacheTempView(YUSER,"AppendValue"))
      appendValue.set(m$.Fnc.$get(m$.var("^CacheTempView",YUSER.get(),"AppendValue")));
      //<< if (appendValue'="") && ($extract(strValue,1,$length(appendValue))=appendValue) {
      if ((mOp.NotEqual(appendValue.get(),"")) && (mOp.Equal(m$.Fnc.$extract(strValue.get(),1,m$.Fnc.$length(appendValue.get())),appendValue.get()))) {
        //<< set $extract(strValue,1,$length(appendValue)) = ""
        mVar $extract = m$.var("$extract");
        $extract.var(strValue.get(),1,m$.Fnc.$length(appendValue.get())).set("");
      }
      //<< }
      //<< if idKey'="" do SetKeyFields(idClass,idKey)
      if (mOp.NotEqual(idKey.get(),"")) {
        m$.Cmd.Do("SetKeyFields",idClass.get(),idKey.get());
      }
      //<< set ^CacheTempView(YUSER,"Form")            = idForm         ; Relation Form or Calling Form
      m$.var("^CacheTempView",YUSER.get(),"Form").set(idForm.get());
      //<< set ^CacheTempView(YUSER,"Class")           = idClass
      m$.var("^CacheTempView",YUSER.get(),"Class").set(idClass.get());
      //<< set ^CacheTempView(YUSER,"FilterValue")     = $get(strValue)
      m$.var("^CacheTempView",YUSER.get(),"FilterValue").set(m$.Fnc.$get(strValue));
      //<< set ^CacheTempView(YUSER,"FieldType")       = idFieldType
      m$.var("^CacheTempView",YUSER.get(),"FieldType").set(idFieldType.get());
      //<< set ^CacheTempView(YUSER,"FieldNo")         = idFieldNo
      m$.var("^CacheTempView",YUSER.get(),"FieldNo").set(idFieldNo.get());
      //<< set ^CacheTempView(YUSER,"CallingForm")     = idCallingForm  ; Calling Form
      m$.var("^CacheTempView",YUSER.get(),"CallingForm").set(idCallingForm.get());
      //<< set ^CacheTempView(YUSER,YUCI,"ParentForm") = idParent       ; ? Parent Form or Calling Class or Relation Class [ or null? ]
      m$.var("^CacheTempView",YUSER.get(),m$.var("YUCI").get(),"ParentForm").set(idParent.get());
      //<< 
      //<< // SR15299 - set language class details if it exists
      //<< if (idClass'="") && (idFieldNo'="") do SetLangRelation(idClass,idCallingForm,idFieldType,idFieldNo)
      if ((mOp.NotEqual(idClass.get(),"")) && (mOp.NotEqual(idFieldNo.get(),""))) {
        m$.Cmd.Do("SetLangRelation",idClass.get(),idCallingForm.get(),idFieldType.get(),idFieldNo.get());
      }
      //<< 
      //<< if idClass'="" {
      if (mOp.NotEqual(idClass.get(),"")) {
        //<< set blnOk = $$$YES
        blnOk.set(include.COMSYS.$$$YES(m$));
        //<< 
        //<< if $extract(idClass,1,4)="VIEW" {
        if (mOp.Equal(m$.Fnc.$extract(idClass.get(),1,4),"VIEW")) {
          //<< set strPackage = $$$REPFolder
          strPackage.set(include.COMSYS.$$$REPFolder(m$));
          //<< set ^CacheTempView(YUSER,"View") = $$$YES
          m$.var("^CacheTempView",YUSER.get(),"View").set(include.COMSYS.$$$YES(m$));
        }
        //<< 
        //<< } elseif $zconvert($extract(idClass,1,2),"U")="AL" {
        else if (mOp.Equal(m$.Fnc.$zconvert(m$.Fnc.$extract(idClass.get(),1,2),"U"),"AL")) {
          //<< set strPackage = $piece(idClass,".")
          strPackage.set(m$.Fnc.$piece(idClass.get(),"."));
        }
        //<< 
        //<< } else {
        else {
          //<< if $length(idClass, ".") = 1 {
          if (mOp.Equal(m$.Fnc.$length(idClass.get(),"."),1)) {
            //<< set strPackage = "SQLUser"
            strPackage.set("SQLUser");
            //<< if '##Class(%Dictionary.CompiledClass).%ExistsId("User."_idClass) {
            if (mOp.Not(m$.fnc$("$Dictionary.CompiledClass.$ExistsId",mOp.Concat("User.",idClass.get())))) {
              //<< do CompileAtNet^COMViewUtils(idClass)
              m$.Cmd.Do("COMViewUtils.CompileAtNet",idClass.get());
              //<< set blnOk = ##Class(%Dictionary.CompiledClass).%ExistsId("User."_idClass)
              blnOk.set(m$.fnc$("$Dictionary.CompiledClass.$ExistsId",mOp.Concat("User.",idClass.get())));
            }
          }
          //<< }
          //<< 
          //<< } else {
          else {
            //<< if '##Class(%Dictionary.CompiledClass).%ExistsId(idClass) {
            if (mOp.Not(m$.fnc$("$Dictionary.CompiledClass.$ExistsId",idClass.get()))) {
              //<< do CompileAtNet^COMViewUtils(idClass)
              m$.Cmd.Do("COMViewUtils.CompileAtNet",idClass.get());
              //<< set blnOk = ##Class(%Dictionary.CompiledClass).%ExistsId(idClass)
              blnOk.set(m$.fnc$("$Dictionary.CompiledClass.$ExistsId",idClass.get()));
            }
            //<< }
            //<< if ##Class(%Dictionary.CompiledClass).%ExistsId(idClass) {
            if (mOp.Logical(m$.fnc$("$Dictionary.CompiledClass.$ExistsId",idClass.get()))) {
              //<< set objCompiledClass = ##Class(%Dictionary.CompiledClass).%OpenId(idClass)
              objCompiledClass.set(m$.fnc$("$Dictionary.CompiledClass.$OpenId",idClass.get()));
              //<< set strPackage = objCompiledClass.SqlSchemaName
              strPackage.set(m$.prop(objCompiledClass.get(),"SqlSchemaName").get());
              //<< do objCompiledClass.%Close()
              m$.Cmd.Do(objCompiledClass.getORef(),"$Close");
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< set ^CacheTempView(YUSER,"Package")     = strPackage
        m$.var("^CacheTempView",YUSER.get(),"Package").set(strPackage.get());
        //<< set ^CacheTempView(YUSER,YUCI,"InForm") = pblnInForm
        m$.var("^CacheTempView",YUSER.get(),m$.var("YUCI").get(),"InForm").set(pblnInForm.get());
        //<< 
        //<< if blnOk {
        if (mOp.Logical(blnOk.get())) {
          //<< if 'pblnHyper {
          if (mOp.Not(pblnHyper.get())) {
            //<< $$$StartScript()
            include.COMSYS.$$$StartScript(m$);
            //<< if $get(^CacheTempSel(YUSER,"ColSel")) {
            if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempSel",YUSER.get(),"ColSel")))) {
              //<< write "GLOBALblnColSelect=true;"
              m$.Cmd.Write("GLOBALblnColSelect=true;");
            }
            //<< }
            //<< write "GLOBALblnMultiSelect=true;"
            m$.Cmd.Write("GLOBALblnMultiSelect=true;");
            //<< write "document.WWW.YUSER.value='"_YUSER_"';"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("document.WWW.YUSER.value='",YUSER.get()),"';"));
            //<< do CopyParent^WWWUSER(YUSER)
            m$.Cmd.Do("WWWUSER.CopyParent",YUSER.get());
          }
          //<< 
          //<< } else {
          else {
            //<< write "BarHeight="_$$GetSearchHeight^COMView(idClass)_";"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("BarHeight=",m$.fnc$("COMView.GetSearchHeight",idClass.get())),";"));
            //<< write "GLOBALblnMultiSelect=false;"
            m$.Cmd.Write("GLOBALblnMultiSelect=false;");
          }
          //<< }
          //<< 
          //<< set objWWW012 = $get(^WWW012(0,0,1))
          objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
          //<< set KeyStrokeDelay = $$$COMViewConfigKeystrokeDelay($get(^COMViewConfig(0,0,1)))
          KeyStrokeDelay.set(include.COMConst.$$$COMViewConfigKeystrokeDelay(m$,m$.Fnc.$get(m$.var("^COMViewConfig",0,0,1))));
          //<< if KeyStrokeDelay="" set KeyStrokeDelay = 200
          if (mOp.Equal(KeyStrokeDelay.get(),"")) {
            KeyStrokeDelay.set(200);
          }
          //<< set blnUseKeyStroke = $$UseKeyStroke^COMViewConfig()
          blnUseKeyStroke.set(m$.fnc$("COMViewConfig.UseKeyStroke"));
          //<< 
          //<< write "NetBorderColor='"     _($$Colour^COMUtilStr($$$WWW012FrameBodyColor(objWWW012),"LIGHTGREY"))_"';"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("NetBorderColor='",(m$.fnc$("COMUtilStr.Colour",include.WWWConst.$$$WWW012FrameBodyColor(m$,objWWW012),"LIGHTGREY"))),"';"));
          //<< write "NetBorderColorLight='"_($$Colour^COMUtilStr($$$WWW012FrameColorForLight(objWWW012),"LIGHTGREY"))_"';"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("NetBorderColorLight='",(m$.fnc$("COMUtilStr.Colour",include.WWWConst.$$$WWW012FrameColorForLight(m$,objWWW012),"LIGHTGREY"))),"';"));
          //<< write "NetBorderColorDark='" _($$Colour^COMUtilStr($$$WWW012FrameColorForDark(objWWW012),"LIGHTGREY"))_"';"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("NetBorderColorDark='",(m$.fnc$("COMUtilStr.Colour",include.WWWConst.$$$WWW012FrameColorForDark(m$,objWWW012),"LIGHTGREY"))),"';"));
          //<< write "KeyStrokeDelay="_(KeyStrokeDelay)_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("KeyStrokeDelay=",(KeyStrokeDelay.get())),";"));
          //<< write "FilePath='"_($zconvert(YGIF,"o","JS"))_"';"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("FilePath='",(m$.Fnc.$zconvert(m$.var("YGIF").get(),"o","JS"))),"';"));
          //<< 
          //<< if pblnInForm {
          if (mOp.Logical(pblnInForm.get())) {
            //<< do GetViews^COMViewFavourite(idClass,YLOCATION,YBED,.arrViews)
            m$.Cmd.Do("COMViewFavourite.GetViews",idClass.get(),m$.var("YLOCATION").get(),m$.var("YBED").get(),arrViews);
            //<< quit:'$data(arrViews)              ; FIXME : EARLY EXIT ***WITHOUT*** RETURN VALUE - CALLED WITHOUT $$?
            if (mOp.Not(m$.Fnc.$data(arrViews))) {
              return null;
            }
          }
          //<< }
          //<< 
          //<< write "GLOBALstrFormName='",$$$JSText($$^WWWFORMNAME(idForm)),"';"
          m$.Cmd.Write("GLOBALstrFormName='",include.COMSYSString.$$$JSText(m$,m$.fnc$("WWWFORMNAME.main",idForm.get())),"';");
          //<< write "BuildCOMViewStructure('"_pblnInForm_"','"_$$SuperUser^COMViewUtils()_"',"_$select(blnUseKeyStroke:"true",1:"false")_");" // SR15426
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("BuildCOMViewStructure('",pblnInForm.get()),"','"),m$.fnc$("COMViewUtils.SuperUser")),"',"),m$.Fnc.$select(blnUseKeyStroke.get(),"true",1,"false")),");"));
          //<< 
          //<< ; :pblnInForm - Always do the following code otherwise select all button hidden for popups
          //<< write:'pblnInForm "if (window.opener!=null) document.getElementById('SelectAll').style.display='"_($select($get(^CacheTempView(YUSER,"CallBack"))'="":"inline",1:"none"))_"';" // SR15426
          if (mOp.Not(pblnInForm.get())) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat("if (window.opener!=null) document.getElementById('SelectAll').style.display='",(m$.Fnc.$select(mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTempView",YUSER.get(),"CallBack")),""),"inline",1,"none"))),"';"));
          }
          //<< do Setup^COMView(idClass)
          m$.Cmd.Do("COMView.Setup",idClass.get());
          //<< do SetupControls^COMViewFilterControl(idClass)
          m$.Cmd.Do("COMViewFilterControl.SetupControls",idClass.get());
          //<< if 'pblnInForm                   do DisplayHeader^COMViewFilterColumn(idClass)
          if (mOp.Not(pblnInForm.get())) {
            m$.Cmd.Do("COMViewFilterColumn.DisplayHeader",idClass.get());
          }
          //<< if blnUseKeyStroke || pblnInForm do DisplayGrid()
          if (mOp.Logical(blnUseKeyStroke.get()) || mOp.Logical(pblnInForm.get())) {
            m$.Cmd.Do("DisplayGrid");
          }
          //<< do Show^COMViewDescription()
          m$.Cmd.Do("COMViewDescription.Show");
          //<< 
          //<< if 'pblnHyper {
          if (mOp.Not(pblnHyper.get())) {
            //<< write "searchbar.style.display='none';",!
            m$.Cmd.Write("searchbar.style.display='none';","\n");
            //<< write "document.getElementById('WWW').style.display='none';"             //SR17469
            m$.Cmd.Write("document.getElementById('WWW').style.display='none';");
            //<< 
            //<< if (YUSERAGENT'="MSIE") {
            if ((mOp.NotEqual(m$.var("YUSERAGENT").get(),"MSIE"))) {
              //<< write "document.getElementById('objDIV').style.width='98%';"         //SR17469
              m$.Cmd.Write("document.getElementById('objDIV').style.width='98%';");
              //<< write "document.getElementById('objDIV').style.paddingRight='0px';"  //SR17469
              m$.Cmd.Write("document.getElementById('objDIV').style.paddingRight='0px';");
            }
            //<< }
            //<< write "objDIV.style.display='block';",!                                  //SR17253
            m$.Cmd.Write("objDIV.style.display='block';","\n");
            //<< write "bdyDiv.style.height=Math.max(document.body.clientHeight-getPageOffsetTop(bdyDiv),0);",!  //SR17418
            m$.Cmd.Write("bdyDiv.style.height=Math.max(document.body.clientHeight-getPageOffsetTop(bdyDiv),0);","\n");
            //<< //  write "bdyDiv.style.setExpression('height','document.body.clientHeight-getPageOffsetTop(bdyDiv)','JScript');",!  //SR17418
            //<< write "document.body.style.overflow='hidden';",!
            m$.Cmd.Write("document.body.style.overflow='hidden';","\n");
            //<< write:blnUseKeyStroke "AddMore(1);",!
            if (mOp.Logical(blnUseKeyStroke.get())) {
              m$.Cmd.Write("AddMore(1);","\n");
            }
            //<< write "objDIV.focus();",!                                            //SR17253
            m$.Cmd.Write("objDIV.focus();","\n");
            //<< write "window.attachEvent('onresize',SetWindowSize);",!
            m$.Cmd.Write("window.attachEvent('onresize',SetWindowSize);","\n");
            //<< write "window.attachEvent('onload',SearchSetFocus);",!               //SR17378 //SR17430
            m$.Cmd.Write("window.attachEvent('onload',SearchSetFocus);","\n");
            //<< write "document.attachEvent('onbeforeunload',SetWindowPosition);",!  //SR17378
            m$.Cmd.Write("document.attachEvent('onbeforeunload',SetWindowPosition);","\n");
            //<< write "if ((document.getElementById('MegaMenu')) && (document.getElementById('FRAME_Header')!=null)) { document.getElementById('objDIV').insertBefore(document.getElementById('FRAME_Header'),document.getElementById('objDIV').children[0]); }" ;CORE-215
            m$.Cmd.Write("if ((document.getElementById('MegaMenu')) && (document.getElementById('FRAME_Header')!=null)) { document.getElementById('objDIV').insertBefore(document.getElementById('FRAME_Header'),document.getElementById('objDIV').children[0]); }");
            //<< $$$EndScript()
            include.COMSYS.$$$EndScript(m$);
          }
          //<< }
          //<< 
          //<< // If I am not being shown, reset the grids height.
          //<< set strViewForm = $$GetForm()
          strViewForm.set(m$.fnc$("GetForm"));
          //<< if $get(^CacheTempToggleView(YUSER,YUCI,strViewForm,"Type"))="none" {
          if (mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempToggleView",YUSER.get(),m$.var("YUCI").get(),strViewForm.get(),"Type")),"none")) {
            //<< set strHeight = $get(^CacheTempToggleView(YUSER,YUCI,strViewForm,"Height"))
            strHeight.set(m$.Fnc.$get(m$.var("^CacheTempToggleView",YUSER.get(),m$.var("YUCI").get(),strViewForm.get(),"Height")));
            //<< write "SetGridHeight('"_(+strHeight)_"','"_($piece(strHeight,"+",2))_"');"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("SetGridHeight('",(mOp.Positive(strHeight.get()))),"','"),(m$.Fnc.$piece(strHeight.get(),"+",2))),"');"));
          }
          //<< }
          //<< write !
          m$.Cmd.Write("\n");
        }
        //<< 
        //<< } else {  ; "Class %1 cannot be compiled. Contact Support."
        else {
          //<< if 'pblnHyper {
          if (mOp.Not(pblnHyper.get())) {
            //<< write "<font size=3><B>"_$$$Text($listbuild("Com00107",idClass))_"<B></font>"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<font size=3><B>",include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("Com00107",idClass.get()))),"<B></font>"));
          }
          //<< } else {
          else {
            //<< $$$Alert($listbuild("Com00107",idClass))
            include.COMSYS.$$$Alert(m$,m$.Fnc.$listbuild("Com00107",idClass.get()));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< OnBeforeDisplayGrid(penumType=$$$EnumDisplayTypeCOMView,pobjOutput="")
  public Object OnBeforeDisplayGrid(Object ... _p) {
    mVar penumType = m$.newVarRef("penumType",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$EnumDisplayTypeCOMView(m$));
    mVar pobjOutput = m$.newVarRef("pobjOutput",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Kill the temp data before exporting the data.
    //<< ;
    //<< ; Params:
    //<< ; penumType : How this is being output, defaults to COMView.
    //<< ; pobjOutput: Where to store the output.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Feb-2007   RPW     SR15426: Ignore the main form and reget the correct data.
    //<< ; 08-Aug-2006   RPW     SR14896: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnInForm
    mVar blnInForm = m$.var("blnInForm");
    m$.newVar(blnInForm);
    //<< 
    //<< kill ^CacheTempSQL($$$SQLID)
    m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$)).kill();
    //<< set blnInForm = $get(^CacheTempView(YUSER,YUCI,"InForm"))
    blnInForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm")));
    //<< kill ^CacheTempView(YUSER,YUCI,"InForm")
    m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm").kill();
    //<< do DisplayGrid(,$$$YES,,,,penumType,pobjOutput)
    m$.Cmd.Do("DisplayGrid",null,include.COMSYS.$$$YES(m$),null,null,null,penumType.get(),pobjOutput.get());
    //<< set ^CacheTempView(YUSER,YUCI,"InForm") = blnInForm
    m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm").set(blnInForm.get());
    //<< kill ^CacheTempSQL($$$SQLID)
    m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$)).kill();
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetMaximum(pidClass,pidView,pblnLoadAll)
  public Object GetMaximum(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnLoadAll = m$.newVarRef("pblnLoadAll",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Works out the maximum number of records to return in the result set.
    //<< ; Code taken out of DisplayGrid and additional tests to improve performance and reliability
    //<< ; if OnBeforeDataAccess and OnBeforeSQL logic exists.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Apr-2010   GRF     -: Fix pidClass not idClass
    //<< ; 08-Dec-2009   shobby  SR17075: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intMaxCount,YSQL,YODBA,strStatus
    mVar intMaxCount = m$.var("intMaxCount");
    mVar YSQL = m$.var("YSQL");
    mVar YODBA = m$.var("YODBA");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(intMaxCount,YSQL,YODBA,strStatus);
    //<< 
    //<< if $$$COMViewRetrieveAllRecords($get(^COMView(0,pidClass,pidView,1))) {
    if (mOp.Logical(include.COMConst.$$$COMViewRetrieveAllRecords(m$,m$.Fnc.$get(m$.var("^COMView",0,pidClass.get(),pidView.get(),1))))) {
      //<< set intMaxCount = 99999999999999
      intMaxCount.set(99999999999999D);
    }
    //<< 
    //<< } else {
    else {
      //<< set intMaxCount = $$GetMaximum^COMViewConfig(pblnLoadAll)
      intMaxCount.set(m$.fnc$("COMViewConfig.GetMaximum",pblnLoadAll.get()));
      //<< set YSQL = ""
      YSQL.set("");
      //<< set strStatus = $$ExecuteHook^WWW001Hook(pidClass,$$$EnumWWWEVENTTYPEOnBeforeSQL,,,$get(^CacheTempView(YUSER,"CallingForm")))
      strStatus.set(m$.fnc$("WWW001Hook.ExecuteHook",pidClass.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeSQL(m$),null,null,m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallingForm"))));
      //<< if YSQL="" {
      if (mOp.Equal(YSQL.get(),"")) {
        //<< set YODBA = $$$NO
        YODBA.set(include.COMSYS.$$$NO(m$));
        //<< do DataAccess(pidClass," ","")
        m$.Cmd.Do("DataAccess",pidClass.get()," ","");
        //<< if YODBA = $$$YES set intMaxCount = 99999999999999
        if (mOp.Equal(YODBA.get(),include.COMSYS.$$$YES(m$))) {
          intMaxCount.set(99999999999999D);
        }
      }
    }
    //<< }
    //<< }
    //<< quit intMaxCount
    return intMaxCount.get();
  }

  //<< 
  //<< 
  //<< DisplayGrid(pintIgnoreRows=0,pblnLoadAll=$$$NO,pstrKey="",pintLevel="",
  //<< pblnManual=$$$NO,penumType=$$$EnumDisplayTypeCOMView,pobjOutput="")
  public Object DisplayGrid(Object ... _p) {
    mVar pintIgnoreRows = m$.newVarRef("pintIgnoreRows",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    mVar pblnLoadAll = m$.newVarRef("pblnLoadAll",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pintLevel = m$.newVarRef("pintLevel",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pblnManual = m$.newVarRef("pblnManual",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    mVar penumType = m$.newVarRef("penumType",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$EnumDisplayTypeCOMView(m$));
    mVar pobjOutput = m$.newVarRef("pobjOutput",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Refreshed the result grid on the screen. Uses a combination of
    //<< ; sql and global checking for results.
    //<< ;
    //<< ; Parameters:
    //<< ;   penumType : The type of export, -1 = COMView, 0 = Excel, 1 = CSV
    //<< ;   pobjOutput: The file type to output (not used for COMView export)
    //<< ;
    //<< ; Returns: $$$OK
    //<< ;
    //<< ; History:
    //<< ; 23-Sep-2013   shobby  UFH-11.24: Change Row to idRow in 2010 the Library.ResultSet may modify the Row variable
    //<< ; 21-Oct-2010   shobby  SR17532: Refresh screen if COMView CacheTemp data has
    //<< ;                           been deleted by another session.
    //<< ; 19-Nov-2009   shobby  SR17075: Call out to GetMaximum.
    //<< ; 01-Oct-2009   SCR     SR16921: Added Logging
    //<< ; 08-Oct-2008   PPP     SR16016: Flag an error and display it to the user if
    //<< ;                           there is an error executing the SQL query
    //<< ; 09-Sep-2008   PPP     SR15866:Update COMView to Objects
    //<< ; 03-Sep-2008   shobby  SRBR014977  Replaced = with '<. Possible that if rows
    //<< ;                           are ignored the test doesn't trigger because it
    //<< ;                           never returns exactly equal.  Don't remember the
    //<< ;                           exact details but this was an emergency patch made
    //<< ;                           to SES.
    //<< ; 25-Jun-2008   GRF     SRBR014953: $$$COMViewUserLastView may return a view id
    //<< ;                           that is no longer current and this will then report
    //<< ;                           as an undefined COMView record.  Force to default
    //<< ;                           view (0) and use $get to ensure even this can't be
    //<< ;                           missed.
    //<< ; 09-Jun-2008   shobby  SRBR014953: A new field on COMView 'RetrieveAllRecords'.
    //<< ;                           This forces an override of the 'Maximum Results
    //<< ;                           Returned' property of 'COMViewConfig' to handle the
    //<< ;                           case where there is an OnFilter routine to limit the
    //<< ;                           result set, and the returned results may not fall
    //<< ;                           within the TOP x results returned by the query.
    //<< ;                           (Refer to SR for more detailed information on how to
    //<< ;                           configure COMView for best performance)
    //<< ; 05-Feb-2008   shobby  SRBR014892: If a COMView is called with 'Start Form With
    //<< ;                           Search Function' from a menu option then YFORM does
    //<< ;                           not contain the form of the search items but
    //<< ;                           'COMViewSearch
    //<< ; 28-Oct-2007   shobby  SRBR014744: Change previous check to a $data
    //<< ; 23-Oct-2007   shobby  SRBR014744: Don't call the onFilter without finding
    //<< ;                           a data record.
    //<< ; 09-Oct-2007   shobby  SRBR014744: Speed Up OnFilter.  If no callouts found
    //<< ;                           stop doing check.
    //<< ; 02-Oct-2007   shobby  SRBR014726: Allow filtering of which records can be
    //<< ;                           displayed using a call out to core and var routines.
    //<< ; 22-Feb-2007   Steve S SR15440: New routine SaveCache^COMViewSession()
    //<< ; 09-Feb-2007   RPW     SR15426: Do not show the entire data set, just call the
    //<< ;                           code to show the grid.
    //<< ; 04-Sep-2006   RPW     SR15005: Get the maximum number of rows. If we have
    //<< ;                       enough data, add a plus to the rowcount.
    //<< ; 01-Sep-2006   RPW     SR14992: Increase row count from 9 to 19.
    //<< ; 25-Aug-2006   JW      SR14763: Cleanup where clause. Remove row count. Set status.
    //<< ; 25-Aug-2006   RPW     SR14857: Corrected 'where' clause replacement to
    //<< ;                           generate the same sql as before.
    //<< ; 14-Aug-2006   RPW     SR14896: Use a $C(0) delimiter instead of Y, quick fix
    //<< ;                           to make sure showing the plan doesn't crash.
    //<< ; 08-Aug-2006   RPW     SR14896: Made this routine only prepare the data once
    //<< ;                           if the SQL has not changed.
    //<< ; 07-Aug-2006   PO      SR14871: Removed call to RowCount^COMViewSQL - Just don't
    //<< ;                           call if not going to use
    //<< ; 12-Jul-2006   RPW     SR14254: Use the fastest construct first in an if test
    //<< ;                           Added code to handle exporting to Excel and CSV.
    //<< ; 14-Jun-2006   Steve S SR14613: Don't re-construct where clause if no submission
    //<< ; 28-Sep-2005   JW      SR13447: Only increment row if adding (by ref)
    //<< ; 30-May-2005   Paul K  AddMore if first time through. SR:12466
    //<< ; 30-Nov-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnData,blnErrorMsg,blnFinished,blnInForm,blnIsShared,blnMax,blnNewWhere
    mVar blnData = m$.var("blnData");
    mVar blnErrorMsg = m$.var("blnErrorMsg");
    mVar blnFinished = m$.var("blnFinished");
    mVar blnInForm = m$.var("blnInForm");
    mVar blnIsShared = m$.var("blnIsShared");
    mVar blnMax = m$.var("blnMax");
    mVar blnNewWhere = m$.var("blnNewWhere");
    m$.newVar(blnData,blnErrorMsg,blnFinished,blnInForm,blnIsShared,blnMax,blnNewWhere);
    //<< new blnObj,blnOnDataAccess,blnOnFilter,blnView
    mVar blnObj = m$.var("blnObj");
    mVar blnOnDataAccess = m$.var("blnOnDataAccess");
    mVar blnOnFilter = m$.var("blnOnFilter");
    mVar blnView = m$.var("blnView");
    m$.newVar(blnObj,blnOnDataAccess,blnOnFilter,blnView);
    //<< new dteStart,idClass,idKey,idParentForm,idRef,idView
    mVar dteStart = m$.var("dteStart");
    mVar idClass = m$.var("idClass");
    mVar idKey = m$.var("idKey");
    mVar idParentForm = m$.var("idParentForm");
    mVar idRef = m$.var("idRef");
    mVar idView = m$.var("idView");
    m$.newVar(dteStart,idClass,idKey,idParentForm,idRef,idView);
    //<< new intColumn,intDisplayRow,intMaxCount,intRow,intRowCount,KeyLoop,lstColumns
    mVar intColumn = m$.var("intColumn");
    mVar intDisplayRow = m$.var("intDisplayRow");
    mVar intMaxCount = m$.var("intMaxCount");
    mVar intRow = m$.var("intRow");
    mVar intRowCount = m$.var("intRowCount");
    mVar KeyLoop = m$.var("KeyLoop");
    mVar lstColumns = m$.var("lstColumns");
    m$.newVar(intColumn,intDisplayRow,intMaxCount,intRow,intRowCount,KeyLoop,lstColumns);
    //<< new objResult,idRow,sc,strName,strRecordCount,strRef,strSQL
    mVar objResult = m$.var("objResult");
    mVar idRow = m$.var("idRow");
    mVar sc = m$.var("sc");
    mVar strName = m$.var("strName");
    mVar strRecordCount = m$.var("strRecordCount");
    mVar strRef = m$.var("strRef");
    mVar strSQL = m$.var("strSQL");
    m$.newVar(objResult,idRow,sc,strName,strRecordCount,strRef,strSQL);
    //<< 
    //<< if $get(^CacheTempView(YUSER,"Class"))="" {
    if (mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")),"")) {
      //<< do Recover^COMViewDisaster()   ; SR17532
      m$.Cmd.Do("COMViewDisaster.Recover");
    }
    //<< 
    //<< } else {
    else {
      //<< set blnErrorMsg = $$$NO        ; SR17267
      blnErrorMsg.set(include.COMSYS.$$$NO(m$));
      //<< set blnObj      = +$get(^CacheTempObj(YUSER,"Object"))
      blnObj.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object"))));
      //<< 
      //<< if penumType=$$$EnumDisplayTypeCOMView do SaveCache^COMViewSession()
      if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeCOMView(m$))) {
        m$.Cmd.Do("COMViewSession.SaveCache");
      }
      //<< 
      //<< set blnInForm   = $get(^CacheTempView(YUSER,YUCI,"InForm"))
      blnInForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm")));
      //<< set blnNewWhere = (pblnManual || $$UseKeyStroke^COMViewConfig())
      blnNewWhere.set((mOp.Logical(pblnManual.get()) || mOp.Logical(m$.fnc$("COMViewConfig.UseKeyStroke"))));
      //<< 
      //<< set idClass     = $get(^CacheTempView(YUSER,"Class"))
      idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
      //<< set idRow         = 0
      idRow.set(0);
      //<< set dteStart    = $ztimestamp
      dteStart.set(m$.Fnc.$ztimestamp());
      //<< set blnFinished = $$$YES
      blnFinished.set(include.COMSYS.$$$YES(m$));
      //<< 
      //<< if blnInForm set pblnLoadAll = $$$YES
      if (mOp.Logical(blnInForm.get())) {
        pblnLoadAll.set(include.COMSYS.$$$YES(m$));
      }
      //<< 
      //<< set idView = $$$COMViewUserLastView($get(^COMViewUser(0,idClass,YBED,1)))
      idView.set(include.COMConst.$$$COMViewUserLastView(m$,m$.Fnc.$get(m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1))));
      //<< 
      //<< ; User may be set to a deleted favourite - use default
      //<< if idView="" set idView = 0
      if (mOp.Equal(idView.get(),"")) {
        idView.set(0);
      }
      //<< if '$data(^COMView(0,idClass,idView,1)) set idView = 0
      if (mOp.Not(m$.Fnc.$data(m$.var("^COMView",0,idClass.get(),idView.get(),1)))) {
        idView.set(0);
      }
      //<< 
      //<< set intMaxCount = $$GetMaximum(idClass,idView,pblnLoadAll)          ;SR17075
      intMaxCount.set(m$.fnc$("GetMaximum",idClass.get(),idView.get(),pblnLoadAll.get()));
      //<< 
      //<< set lstColumns  = $$GetColumns^COMViewFilterColumn(idClass)
      lstColumns.set(m$.fnc$("COMViewFilterColumn.GetColumns",idClass.get()));
      //<< set strSQL      = $$GenerateSQL^COMViewSQL(idClass,lstColumns,pstrKey,pintLevel,,,,intMaxCount,blnInForm)
      strSQL.set(m$.fnc$("COMViewSQL.GenerateSQL",idClass.get(),lstColumns.get(),pstrKey.get(),pintLevel.get(),null,null,null,intMaxCount.get(),blnInForm.get()));
      //<< set blnView     = +$get(^CacheTempView(YUSER,"View"))
      blnView.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"View"))));
      //<< 
      //<< if blnInForm || ($get(^CacheTempSQL($$$SQLID))'=strSQL) {   // Populate
      if (mOp.Logical(blnInForm.get()) || (mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$))),strSQL.get()))) {
        //<< set ^CacheTempSQL($$$SQLID) = strSQL
        m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$)).set(strSQL.get());
        //<< kill ^CacheTempSQL($$$SQLID,"Data")
        m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data").kill();
        //<< kill ^CacheTempSQL($$$SQLID,"Row")
        m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Row").kill();
        //<< kill ^CacheTempSQL($$$SQLID,"Key")
        m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Key").kill();
        //<< 
        //<< set objResult = ##class(%Library.ResultSet).%New()
        objResult.set(m$.fnc$("$Library.ResultSet.$New"));
        //<< 
        //<< // If we are populating the Query, look through and keep the data
        //<< do objResult.Prepare(strSQL)
        m$.Cmd.Do(objResult.getORef(),"Prepare",strSQL.get());
        //<< set sc      = objResult.Execute()
        sc.set(m$.fnc$(objResult.getORef(),"Execute"));
        //<< set blnData = objResult.Next()
        blnData.set(m$.fnc$(objResult.getORef(),"Next"));
        //<< 
        //<< if $get(%objlasterror)'="" {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("%objlasterror")),"")) {
          //<< set strSQL = $$GenerateSQL^COMViewSQL(idClass,lstColumns,pstrKey,pintLevel,1,,,intMaxCount)
          strSQL.set(m$.fnc$("COMViewSQL.GenerateSQL",idClass.get(),lstColumns.get(),pstrKey.get(),pintLevel.get(),1,null,null,intMaxCount.get()));
          //<< 
          //<< do objResult.Prepare(strSQL)
          m$.Cmd.Do(objResult.getORef(),"Prepare",strSQL.get());
          //<< set sc      = objResult.Execute()
          sc.set(m$.fnc$(objResult.getORef(),"Execute"));
          //<< set blnData = objResult.Next()
          blnData.set(m$.fnc$(objResult.getORef(),"Next"));
        }
        //<< }
        //<< do LogSQL^COMViewLog(strSQL,"",$$DateDiff^COMUtilDate(dteStart,$ztimestamp),$$$YES)  ; SR16921
        m$.Cmd.Do("COMViewLog.LogSQL",strSQL.get(),"",m$.fnc$("COMUtilDate.DateDiff",dteStart.get(),m$.Fnc.$ztimestamp()),include.COMSYS.$$$YES(m$));
        //<< 
        //<< set idKey           = ""
        idKey.set("");
        //<< set blnMax          = $$$NO
        blnMax.set(include.COMSYS.$$$NO(m$));
        //<< set blnOnFilter     = $$$YES
        blnOnFilter.set(include.COMSYS.$$$YES(m$));
        //<< set blnOnDataAccess = $$$YES
        blnOnDataAccess.set(include.COMSYS.$$$YES(m$));
        //<< 
        //<< while blnData {
        while (mOp.Logical(blnData.get())) {
          //<< set blnMax = ((idRow=intMaxCount) && (intMaxCount'=0))
          blnMax.set(((mOp.Equal(idRow.get(),intMaxCount.get())) && (mOp.NotEqual(intMaxCount.get(),0))));
          //<< quit:blnMax
          if (mOp.Logical(blnMax.get())) {
            break;
          }
          //<< 
          //<< if 'blnView {
          if (mOp.Not(blnView.get())) {
            //<< set idRef  = objResult.Data("ID")
            idRef.set(m$.fnc$(objResult.getORef(),"Data","ID"));
            //<< set idKey  = ""
            idKey.set("");
            //<< 
            //<< set strRef = "^"_idClass_"("
            strRef.set(mOp.Concat(mOp.Concat("^",idClass.get()),"("));
            //<< set blnIsShared = ($$$WWW001SharedFile($get(^WWW001(0,idClass,1))))
            blnIsShared.set((include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,idClass.get(),1)))));
            //<< if blnIsShared set strRef = strRef_"0,"
            if (mOp.Logical(blnIsShared.get())) {
              strRef.set(mOp.Concat(strRef.get(),"0,"));
            }
            //<< for KeyLoop=1:1:$length(idRef,"||") {
            for (KeyLoop.set(1);(mOp.LessOrEqual(KeyLoop.get(),m$.Fnc.$length(idRef.get(),"||")));KeyLoop.set(mOp.Add(KeyLoop.get(),1))) {
              //<< set strRef=strRef_""""_$piece(idRef,"||",KeyLoop)_""","
              strRef.set(mOp.Concat(mOp.Concat(mOp.Concat(strRef.get(),"\""),m$.Fnc.$piece(idRef.get(),"||",KeyLoop.get())),"\","));
              //<< if (KeyLoop'=1) || blnIsShared {
              if ((mOp.NotEqual(KeyLoop.get(),1)) || mOp.Logical(blnIsShared.get())) {
                //<< if idKey'="" set idKey = idKey_","
                if (mOp.NotEqual(idKey.get(),"")) {
                  idKey.set(mOp.Concat(idKey.get(),","));
                }
                //<< set idKey = idKey_$translate($piece(idRef,"||",KeyLoop),",","|")
                idKey.set(mOp.Concat(idKey.get(),m$.Fnc.$translate(m$.Fnc.$piece(idRef.get(),"||",KeyLoop.get()),",","|")));
              }
            }
            //<< }
            //<< }
            //<< set strRef = strRef_"1)"
            strRef.set(mOp.Concat(strRef.get(),"1)"));
          }
          //<< }
          //<< 
          //<< if 'blnObj {
          if (mOp.Not(blnObj.get())) {
            //<< if $data(@strRef) && ('blnOnFilter || $$OnFilter(idKey,@strRef,.blnOnFilter)) {
            if (mOp.Logical(m$.Fnc.$data(m$.indirectVar(strRef.get()))) && (mOp.Not(blnOnFilter.get()) || mOp.Logical(m$.fnc$("OnFilter",idKey.get(),m$.indirectVar(strRef.get()).get(),blnOnFilter)))) {
              //<< if ('($data(^CacheTempLockInterest(YUSER)) && $$IsExternallyLocked^COMLock(idClass,idKey)) &&
              //<< ('blnOnDataAccess || $$DataAccess(idClass,idKey,.blnOnDataAccess))                    ) {
              if ((mOp.Not((mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempLockInterest",m$.var("YUSER").get()))) && mOp.Logical(m$.fnc$("COMLock.IsExternallyLocked",idClass.get(),idKey.get())))) && (mOp.Not(blnOnDataAccess.get()) || mOp.Logical(m$.fnc$("DataAccess",idClass.get(),idKey.get(),blnOnDataAccess))))) {
                //<< 
                //<< for intColumn=1:1:objResult.GetColumnCount() {
                for (intColumn.set(1);(mOp.LessOrEqual(intColumn.get(),m$.fnc$(objResult.getORef(),"GetColumnCount")));intColumn.set(mOp.Add(intColumn.get(),1))) {
                  //<< set strName = objResult.GetColumnName(intColumn)
                  strName.set(m$.fnc$(objResult.getORef(),"GetColumnName",intColumn.get()));
                  //<< 
                  //<< if 'blnView && (strName="ID") {
                  if (mOp.Not(blnView.get()) && (mOp.Equal(strName.get(),"ID"))) {
                    //<< set ^CacheTempSQL($$$SQLID,"Data",idRow,strName)    = idKey_$$$NULLCHAR_strRef
                    m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",idRow.get(),strName.get()).set(mOp.Concat(mOp.Concat(idKey.get(),include.COMSYSString.$$$NULLCHAR(m$)),strRef.get()));
                    //<< set ^CacheTempSQL($$$SQLID,"Key",$$$Index(idKey)) = idRow_$$$NULLCHAR_strName
                    m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Key",include.MEDConst.$$$Index(m$,idKey)).set(mOp.Concat(mOp.Concat(idRow.get(),include.COMSYSString.$$$NULLCHAR(m$)),strName.get()));
                  }
                  //<< } else {
                  else {
                    //<< set ^CacheTempSQL($$$SQLID,"Data",idRow,strName)    = objResult.Data(strName)
                    m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",idRow.get(),strName.get()).set(m$.fnc$(objResult.getORef(),"Data",strName.get()));
                  }
                }
                //<< }
                //<< }
                //<< set idRow = $increment(idRow)
                idRow.set(m$.Fnc.$increment(idRow));
              }
            }
          }
          //<< }
          //<< }
          //<< 
          //<< } else {
          else {
            //<< for intColumn=1:1:objResult.GetColumnCount() {
            for (intColumn.set(1);(mOp.LessOrEqual(intColumn.get(),m$.fnc$(objResult.getORef(),"GetColumnCount")));intColumn.set(mOp.Add(intColumn.get(),1))) {
              //<< set strName = objResult.GetColumnName(intColumn)
              strName.set(m$.fnc$(objResult.getORef(),"GetColumnName",intColumn.get()));
              //<< 
              //<< if (strName="ID") {    ; FIXME : without "Key" this test is unnecessary.
              if ((mOp.Equal(strName.get(),"ID"))) {
                //<< set ^CacheTempSQL($$$SQLID,"Data",idRow,strName) = objResult.Data(strName)
                m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",idRow.get(),strName.get()).set(m$.fnc$(objResult.getORef(),"Data",strName.get()));
              }
              //<< //  set ^CacheTempSQL($$$SQLID,"Key",$$$Index(idKey)) = idRow_$$$NULLCHAR_strName
              //<< } else {
              else {
                //<< set ^CacheTempSQL($$$SQLID,"Data",idRow,strName) = objResult.Data(strName)
                m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",idRow.get(),strName.get()).set(m$.fnc$(objResult.getORef(),"Data",strName.get()));
              }
            }
            //<< }
            //<< }
            //<< set idRow = $increment(idRow)
            idRow.set(m$.Fnc.$increment(idRow));
          }
          //<< }
          //<< set blnData = objResult.Next()
          blnData.set(m$.fnc$(objResult.getORef(),"Next"));
        }
        //<< }
        //<< 
        //<< if $$$ISOK(sc) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
          //<< set ^CacheTempSQL($$$SQLID,"RowCount") = idRow_$select(blnMax:"+",1:"")
          m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"RowCount").set(mOp.Concat(idRow.get(),m$.Fnc.$select(blnMax.get(),"+",1,"")));
        }
        //<< } else {
        else {
          //<< set ^CacheTempSQL($$$SQLID,"RowCount") = $$DecodeCacheError^COMUtilError(sc)_" 0"
          m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"RowCount").set(mOp.Concat(m$.fnc$("COMUtilError.DecodeCacheError",sc.get())," 0"));
          //<< set blnErrorMsg = $$$YES
          blnErrorMsg.set(include.COMSYS.$$$YES(m$));
        }
        //<< }
        //<< kill objResult
        objResult.kill();
      }
      //<< }
      //<< 
      //<< if penumType=$$$EnumDisplayTypeCOMView {
      if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeCOMView(m$))) {
        //<< ;SR17267 $$$SetStatus
        //<< write "SetStatus('"_$$$Text($listbuild("Com00255",$$$RowCount))_"');",!
        m$.Cmd.Write(mOp.Concat(mOp.Concat("SetStatus('",include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("Com00255",include.COMView.$$$RowCount(m$)))),"');"),"\n");
        //<< if blnErrorMsg write "SetupWarning(document.getElementById('bdystatus'),'"_$$$JSText($$$Text("Com00331"))_"')",!
        if (mOp.Logical(blnErrorMsg.get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat("SetupWarning(document.getElementById('bdystatus'),'",include.COMSYSString.$$$JSText(m$,include.COMSYS.$$$Text(m$,"Com00331"))),"')"),"\n");
        }
      }
      //<< } ; "Check 'Allow Extrinsic Functions in SQL Statements' settings in Cache ..."
      //<< 
      //<< if 'blnInForm {
      if (mOp.Not(blnInForm.get())) {
        //<< set intRow      = 0
        intRow.set(0);
        //<< set intRowCount = +$get(^CacheTempSQL($$$SQLID,"RowCount"))
        intRowCount.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"RowCount"))));
        //<< 
        //<< if ((pintIgnoreRows=0) || (intRowCount=0)) && (penumType=$$$EnumDisplayTypeCOMView) {
        if (mOp.Logical(((mOp.Equal(pintIgnoreRows.get(),0)) || (mOp.Equal(intRowCount.get(),0)))) && (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeCOMView(m$)))) {
          //<< write "ClearRows(bdy);",!
          m$.Cmd.Write("ClearRows(bdy);","\n");
          //<< write "CurrentRow=null;",!
          m$.Cmd.Write("CurrentRow=null;","\n");
          //<< kill ^CacheTempSQL(YUSER_"-"_YFORM,"Row")
          m$.var("^CacheTempSQL",mOp.Concat(mOp.Concat(m$.var("YUSER").get(),"-"),m$.var("YFORM").get()),"Row").kill();
        }
        //<< }
        //<< 
        //<< if (pintIgnoreRows'=intRowCount) {
        if ((mOp.NotEqual(pintIgnoreRows.get(),intRowCount.get()))) {
          //<< // Loop through and display the new data.
          //<< set blnFinished   = $$$NO
          blnFinished.set(include.COMSYS.$$$NO(m$));
          //<< set idRow           = $get(^CacheTempSQL($$$SQLID,"Row"))
          idRow.set(m$.Fnc.$get(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Row")));
          //<< set intDisplayRow = pintIgnoreRows
          intDisplayRow.set(pintIgnoreRows.get());
          //<< 
          //<< write "document.getElementById('objDIV').style.cursor='wait';",!
          m$.Cmd.Write("document.getElementById('objDIV').style.cursor='wait';","\n");
          //<< 
          //<< for {
          for (;true;) {
            //<< set idRow = $order(^CacheTempSQL($$$SQLID,"Data",idRow))
            idRow.set(m$.Fnc.$order(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",idRow.get())));
            //<< if idRow="" {
            if (mOp.Equal(idRow.get(),"")) {
              //<< set blnFinished = $$$YES
              blnFinished.set(include.COMSYS.$$$YES(m$));
              //<< quit
              break;
            }
            //<< }
            //<< 
            //<< do AddRow(.intDisplayRow,idClass,lstColumns,0,.intRow,penumType,pobjOutput,idRow)
            m$.Cmd.Do("AddRow",intDisplayRow,idClass.get(),lstColumns.get(),0,intRow,penumType.get(),pobjOutput.get(),idRow.get());
            //<< set intRow = 1-intRow
            intRow.set(mOp.Subtract(1,intRow.get()));
            //<< 
            //<< quit:((intDisplayRow-pintIgnoreRows)'<$$$RowLimit)&&('pblnLoadAll)
            if ((mOp.NotLess((mOp.Subtract(intDisplayRow.get(),pintIgnoreRows.get())),$$$RowLimit(m$))) && (mOp.Not(pblnLoadAll.get()))) {
              break;
            }
          }
          //<< }
          //<< write "document.getElementById('objDIV').style.cursor='default';",!
          m$.Cmd.Write("document.getElementById('objDIV').style.cursor='default';","\n");
          //<< 
          //<< // Store the last row used.
          //<< set ^CacheTempSQL($$$SQLID,"Row") = idRow
          m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Row").set(idRow.get());
          //<< 
          //<< if penumType=$$$EnumDisplayTypeCOMView {
          if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeCOMView(m$))) {
            //<< if blnFinished      write "bdy.Finished=true;",!
            if (mOp.Logical(blnFinished.get())) {
              m$.Cmd.Write("bdy.Finished=true;","\n");
            }
            //<< if pintIgnoreRows=0 write "AddMore(1);",! ; If more to display, initiate call to get another lot of records.
            if (mOp.Equal(pintIgnoreRows.get(),0)) {
              m$.Cmd.Write("AddMore(1);","\n");
            }
          }
        }
      }
      //<< }
      //<< }
      //<< } else {
      else {
        //<< do OnChangeData()
        m$.Cmd.Do("OnChangeData");
      }
      //<< }
      //<< do LogSQL^COMViewLog(strSQL,"",$$DateDiff^COMUtilDate(dteStart,$ztimestamp),pblnManual)
      m$.Cmd.Do("COMViewLog.LogSQL",strSQL.get(),"",m$.fnc$("COMUtilDate.DateDiff",dteStart.get(),m$.Fnc.$ztimestamp()),pblnManual.get());
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< OnFilter(YKEY="",YFELD="",&pblnCheck=$$$YES,pidClass="")
  public Object OnFilter(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnCheck = m$.newVarRef("pblnCheck",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$YES(m$));
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; If a COMView is called with 'Start Form With Search Function' from a menu option
    //<< ; then YFORM does not contain the form of the search items but 'COMViewSearch'
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Jul-2011   GRF     SR17751: dot prefix on call to OnFilter was missing
    //<< ; 19-Jun-2008   shobby  SRBR014956: Only get the YFORM from CallingForm if the
    //<< ;                           form is related to the class.  (If not then this is
    //<< ;                           a popup search on a field)
    //<< ; 05-Feb-2008   shobby  SRBR014892: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW120,idForm
    mVar objWWW120 = m$.var("objWWW120");
    mVar idForm = m$.var("idForm");
    m$.newVar(objWWW120,idForm);
    //<< 
    //<< if ($get(YFORM)="") || ($extract($get(YFORM),1,7)="COMView") {
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"")) || (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(m$.var("YFORM")),1,7),"COMView"))) {
      //<< set idForm = $get(^CacheTempView(YUSER,"CallingForm"))
      idForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallingForm")));
      //<< if idForm'="" {
      if (mOp.NotEqual(idForm.get(),"")) {
        //<< set objWWW120 = $get(^WWW120(0,idForm,1))
        objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,idForm.get(),1)));
        //<< if $$$WWW120ClassUsedInForm(objWWW120)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objWWW120),"")) {
          //<< if $$$WWW120ClassUsedInForm(objWWW120)=$get(^CacheTempView(YUSER,"Class")) {
          if (mOp.Equal(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objWWW120),m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")))) {
            //<< new YFORM
            mVar YFORM = m$.var("YFORM");
            m$.newVar(YFORM);
            //<< set YFORM = $get(^CacheTempView(YUSER,"CallingForm"))
            YFORM.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallingForm")));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit $$OnFilter^WWWSOR(YKEY,YFELD,.pblnCheck)    ; SR17751
    return m$.fnc$("WWWSOR.OnFilter",YKEY.get(),YFELD.get(),pblnCheck);
  }

  //<< 
  //<< 
  //<< ManualSubmit()
  public Object ManualSubmit(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Call back from JavaScript when the manual submit button is clicked.
    //<< ;
    //<< ; Called by JS: SubmitQuery()
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 14-Jun-2006   SteveS  SR14613: Created
    //<< ;-------------------------------------------------------------------------------
    //<< do DisplayGrid(,,,,$$$YES)
    m$.Cmd.Do("DisplayGrid",null,null,null,null,include.COMSYS.$$$YES(m$));
    //<< 
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< ExpandRow(pstrRow,pstrSeparator,&pobjRow)
  public Object ExpandRow(Object ... _p) {
    mVar pstrRow = m$.newVarRef("pstrRow",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrSeparator = m$.newVarRef("pstrSeparator",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjRow = m$.newVarRef("pobjRow",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; The result set can now display multiple lines for the same record.  Ie if searching
    //<< ; for all the INREC's that contain a particular item in the INRECLine
    //<< ;
    //<< ; Inputs:   pstrRow:        The current 'single' row.
    //<< ;           pstrSeparator:  The separator used to delineate the rows
    //<< ;           pobjRow         The returned expanded version
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Feb-2008   shobby  SRBR014900: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idxRows,intColumn,intLine,strColumn1,strColumn2,strRow,strRow2
    mVar idxRows = m$.var("idxRows");
    mVar intColumn = m$.var("intColumn");
    mVar intLine = m$.var("intLine");
    mVar strColumn1 = m$.var("strColumn1");
    mVar strColumn2 = m$.var("strColumn2");
    mVar strRow = m$.var("strRow");
    mVar strRow2 = m$.var("strRow2");
    m$.newVar(idxRows,intColumn,intLine,strColumn1,strColumn2,strRow,strRow2);
    //<< 
    //<< kill pobjRow
    pobjRow.kill();
    //<< 
    //<< set pobjRow(1) = pstrRow
    pobjRow.var(1).set(pstrRow.get());
    //<< for intColumn=1:1:$length(pstrRow,Y) {
    for (intColumn.set(1);(mOp.LessOrEqual(intColumn.get(),m$.Fnc.$length(pstrRow.get(),m$.var("Y").get())));intColumn.set(mOp.Add(intColumn.get(),1))) {
      //<< set strColumn1 = $piece(pstrRow,Y,intColumn)
      strColumn1.set(m$.Fnc.$piece(pstrRow.get(),m$.var("Y").get(),intColumn.get()));
      //<< set strColumn2 = $piece(strColumn1,$$$Separator,1)
      strColumn2.set(m$.Fnc.$piece(strColumn1.get(),$$$Separator(m$),1));
      //<< for intLine=2:1:$length(strColumn1,$$$Separator) {
      for (intLine.set(2);(mOp.LessOrEqual(intLine.get(),m$.Fnc.$length(strColumn1.get(),$$$Separator(m$))));intLine.set(mOp.Add(intLine.get(),1))) {
        //<< if $$$NEVER {
        if (mOp.Logical(include.COMSYS.$$$NEVER(m$))) {
          //<< set strColumn2 = strColumn2_pstrSeparator_$piece(strColumn1,$$$Separator,intLine)
          strColumn2.set(mOp.Concat(mOp.Concat(strColumn2.get(),pstrSeparator.get()),m$.Fnc.$piece(strColumn1.get(),$$$Separator(m$),intLine.get())));
        }
        //<< } else {
        else {
          //<< if '$data(pobjRow(intLine)) {
          if (mOp.Not(m$.Fnc.$data(pobjRow.var(intLine.get())))) {
            //<< merge pobjRow(intLine) = pobjRow(intLine-1)
            m$.Cmd.Merge(pobjRow.var(intLine.get()),pobjRow.var(mOp.Subtract(intLine.get(),1)));
          }
          //<< }
          //<< set $piece(pobjRow(intLine),Y,intColumn) = $piece(strColumn1,$$$Separator,intLine)
          m$.pieceVar(pobjRow.var(intLine.get()),m$.var("Y").get(),intColumn.get()).set(m$.Fnc.$piece(strColumn1.get(),$$$Separator(m$),intLine.get()));
        }
      }
      //<< }
      //<< }
      //<< set $piece(pobjRow(1),Y,intColumn) = strColumn2
      m$.pieceVar(pobjRow.var(1),m$.var("Y").get(),intColumn.get()).set(strColumn2.get());
    }
    //<< }
    //<< set idxRows = ""
    idxRows.set("");
    //<< for {
    for (;true;) {
      //<< set idxRows = $order(pobjRow(idxRows))
      idxRows.set(m$.Fnc.$order(pobjRow.var(idxRows.get())));
      //<< quit:idxRows=""
      if (mOp.Equal(idxRows.get(),"")) {
        break;
      }
      //<< 
      //<< if $find(Y_pobjRow(idxRows)_Y,Y_"####################"_Y) {
      if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(m$.var("Y").get(),pobjRow.var(idxRows.get()).get()),m$.var("Y").get()),mOp.Concat(mOp.Concat(m$.var("Y").get(),"####################"),m$.var("Y").get())))) {
        //<< kill pobjRow(idxRows)
        pobjRow.var(idxRows.get()).kill();
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AddRow(Row=0,pidClass,plstColumns,pintLevel,pintRow=0,
  //<< penumType=$$$EnumDisplayTypeCOMView,pobjOutput="",pintLogicalRow)
  public Object AddRow(Object ... _p) {
    mVar Row = m$.newVarRef("Row",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar plstColumns = m$.newVarRef("plstColumns",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintLevel = m$.newVarRef("pintLevel",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pintRow = m$.newVarRef("pintRow",(((_p!=null)&&(_p.length>=5))?_p[4]:null),0);
    mVar penumType = m$.newVarRef("penumType",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$EnumDisplayTypeCOMView(m$));
    mVar pobjOutput = m$.newVarRef("pobjOutput",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    mVar pintLogicalRow = m$.newVarRef("pintLogicalRow",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Adds a row to the grid.
    //<< ;
    //<< ; Params:   Row = LastRow to be added (by Ref)
    //<< ; pintRow
    //<< ; penumType : The type of export, -1 = COMView, 0 = Excel, 1 = CSV
    //<< ; pobjOutput: The file type to output (not used for COMView export)
    //<< ;
    //<< ; History:
    //<< ; 12-Apr-2011   shobby  SR17130: Call out to TwoPart
    //<< ; 28-Apr-2009   PPP     SR16499: Removed code which gets the last part of the ID
    //<< ;                           only for Objects.  Not necessary was corrupting the ID
    //<< ; 07-Oct-2008   PPP     SR15960:Updated the Column Heading to include the Parent Field.
    //<< ; 09-Sep-2008   PPP     SR15866:Update COMView to Objects
    //<< ; 21-Feb-2008   shobby  SRBR014900: For referenced classes need to pass the form id.
    //<< ; 20-Feb-2008   shobby  SRBR014900: Added support for Expand rows in the result
    //<< ;                           set to show for example, one row for each different
    //<< ;                           item in an INREC that has INRECLines with multiple
    //<< ;                           items.
    //<< ; 21-Jan-2008   shobby  SRBR014860: Remove the characters that will cause a new
    //<< ;                           cell when pasted into Excel.
    //<< ; 11-Dec-2006   JW      SR15299: Check for language translation
    //<< ; 04-Sep-2006   RPW     SR15005: We now always do the loop
    //<< ; 11-Aug-2006   RPW     SR14896: Make sure that this is not doing any work to get the data.
    //<< ; 12-Jul-2006   RPW     SR14254: Use the fastest construct first in an if test
    //<< ;                           Added code to handle exporting to Excel and CSV
    //<< ; 18-Jul-2006   RPW     SR14760: If the field type is P, remove any leading and trailing quotes.
    //<< ; 01-Jun-2006   PO      SR14266: Shifted the set of strPiece2 to ensure undefined errors do not occur
    //<< ; 11-May-2006   RW      SR14220: Don't show if locked
    //<< ; 19-Apr-2006   JW      SR14429: Added View support
    //<< ;  POSTPONED 27-Feb-2006    PO      SR14266: set strPiece2 when pobjResult.Data(idField) exists
    //<< ; 28-Sep-2005   JW      SR13447: Data Access for records
    //<< ; 05-May-2005   Paul K  Changed "|"s to space then &nbsp;(SR#11888)
    //<< ; 07-Apr-2005   Paul K  Dont use a <br> bfore the ....s(SR#11888)
    //<< ; 14-Mar-2005   Paul K  Changed pipes ("|") into "&nbsp;"s (SR#11888)
    //<< ; 01-Mar-2005   Paul K  Ensure no "~" in data sent to screen
    //<< ; 07-Feb-2005   PO      SR10965 Adding support for related classes.
    //<< ;-------------------------------------------------------------------------------
    //<< new blnValueShort,blnObj,blnView,idClass,idField,idForm,idKey,idRef
    mVar blnValueShort = m$.var("blnValueShort");
    mVar blnObj = m$.var("blnObj");
    mVar blnView = m$.var("blnView");
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar idForm = m$.var("idForm");
    mVar idKey = m$.var("idKey");
    mVar idRef = m$.var("idRef");
    m$.newVar(blnValueShort,blnObj,blnView,idClass,idField,idForm,idKey,idRef);
    //<< new idxRows,intCount,intField,intLen,loop,lstValue,objRef,objRow
    mVar idxRows = m$.var("idxRows");
    mVar intCount = m$.var("intCount");
    mVar intField = m$.var("intField");
    mVar intLen = m$.var("intLen");
    mVar loop = m$.var("loop");
    mVar lstValue = m$.var("lstValue");
    mVar objRef = m$.var("objRef");
    mVar objRow = m$.var("objRow");
    m$.newVar(idxRows,intCount,intField,intLen,loop,lstValue,objRef,objRow);
    //<< new strAlign,strBlnValuesShort,strCellAlign,strColName,strItem,strLangRef
    mVar strAlign = m$.var("strAlign");
    mVar strBlnValuesShort = m$.var("strBlnValuesShort");
    mVar strCellAlign = m$.var("strCellAlign");
    mVar strColName = m$.var("strColName");
    mVar strItem = m$.var("strItem");
    mVar strLangRef = m$.var("strLangRef");
    m$.newVar(strAlign,strBlnValuesShort,strCellAlign,strColName,strItem,strLangRef);
    //<< new strPiece2,strPiece3,strRef,strRow,strValue
    mVar strPiece2 = m$.var("strPiece2");
    mVar strPiece3 = m$.var("strPiece3");
    mVar strRef = m$.var("strRef");
    mVar strRow = m$.var("strRow");
    mVar strValue = m$.var("strValue");
    m$.newVar(strPiece2,strPiece3,strRef,strRow,strValue);
    //<< 
    //<< if penumType=$$$EnumDisplayTypeCOMView {
    if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeCOMView(m$))) {
      //<< set strRow = $$GetCommands^COMViewCommand()
      strRow.set(m$.fnc$("COMViewCommand.GetCommands"));
      //<< if strRow'="" {
      if (mOp.NotEqual(strRow.get(),"")) {
        //<< set strAlign          = Y
        strAlign.set(m$.var("Y").get());
        //<< set strBlnValuesShort = Y
        strBlnValuesShort.set(m$.var("Y").get());
      }
      //<< } else {
      else {
        //<< set strAlign          = ""
        strAlign.set("");
        //<< set strBlnValuesShort = ""
        strBlnValuesShort.set("");
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set strRow            = ""
      strRow.set("");
      //<< set strAlign          = ""
      strAlign.set("");
      //<< set strBlnValuesShort = ""
      strBlnValuesShort.set("");
    }
    //<< }
    //<< 
    //<< set blnObj = $get(^CacheTempObj(YUSER,"Object"))    //SR15866
    blnObj.set(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object")));
    //<< set blnView = $get(^CacheTempView(YUSER,"View"))
    blnView.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"View")));
    //<< 
    //<< if blnView {
    if (mOp.Logical(blnView.get())) {
      //<< set objRef = ""
      objRef.set("");
      //<< set idKey  = ""
      idKey.set("");
    }
    //<< 
    //<< } elseif blnObj {
    else if (mOp.Logical(blnObj.get())) {
      //<< set objRef = ""
      objRef.set("");
      //<< set idRef  = $get(^CacheTempSQL($$$SQLID,"Data",pintLogicalRow,"ID"))
      idRef.set(m$.Fnc.$get(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",pintLogicalRow.get(),"ID")));
      //<< set idKey  = idRef
      idKey.set(idRef.get());
    }
    //<< 
    //<< } else {
    else {
      //<< set strRef = "^"_pidClass_"("
      strRef.set(mOp.Concat(mOp.Concat("^",pidClass.get()),"("));
      //<< set idRef  = $get(^CacheTempSQL($$$SQLID,"Data",pintLogicalRow,"ID"))
      idRef.set(m$.Fnc.$get(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",pintLogicalRow.get(),"ID")));
      //<< set idKey  = $piece(idRef,$$$NULLCHAR,1)
      idKey.set(m$.Fnc.$piece(idRef.get(),include.COMSYSString.$$$NULLCHAR(m$),1));
      //<< set strRef = $piece(idRef,$$$NULLCHAR,2)
      strRef.set(m$.Fnc.$piece(idRef.get(),include.COMSYSString.$$$NULLCHAR(m$),2));
      //<< set objRef = $get(@strRef)
      objRef.set(m$.Fnc.$get(m$.indirectVar(strRef.get())));
    }
    //<< }
    //<< 
    //<< for loop=1:1:$listlength(plstColumns) {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(plstColumns.get())));loop.set(mOp.Add(loop.get(),1))) {
      //<< set (idField,strColName) = $listget(plstColumns,loop)
      idField.set(m$.Fnc.$listget(plstColumns.get(),loop.get()));
      strColName.set(m$.Fnc.$listget(plstColumns.get(),loop.get()));
      //<< 
      //<< if loop'=1 {
      if (mOp.NotEqual(loop.get(),1)) {
        //<< set strRow            = strRow_Y
        strRow.set(mOp.Concat(strRow.get(),m$.var("Y").get()));
        //<< set strAlign          = strAlign_Y
        strAlign.set(mOp.Concat(strAlign.get(),m$.var("Y").get()));
        //<< set strBlnValuesShort = strAlign_Y
        strBlnValuesShort.set(mOp.Concat(strAlign.get(),m$.var("Y").get()));
      }
      //<< }
      //<< 
      //<< if idField="RowCount" {
      if (mOp.Equal(idField.get(),"RowCount")) {
        //<< if $data(^CacheTempSQL($$$SQLID,"Data",pintLogicalRow,idField)) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",pintLogicalRow.get(),idField.get())))) {
          //<< set strRow = strRow_$get(^CacheTempSQL($$$SQLID,"Data",pintLogicalRow,idField))
          strRow.set(mOp.Concat(strRow.get(),m$.Fnc.$get(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",pintLogicalRow.get(),idField.get()))));
        }
        //<< } else {
        else {
          //<< set strRow = strRow_1
          strRow.set(mOp.Concat(strRow.get(),1));
        }
        //<< }
        //<< set strAlign = strAlign_"right"
        strAlign.set(mOp.Concat(strAlign.get(),"right"));
      }
      //<< 
      //<< } else {
      else {
        //<< set strCellAlign = "left"
        strCellAlign.set("left");
        //<< set idClass      = pidClass
        idClass.set(pidClass.get());
        //<< set strPiece2    = $piece(idField,".",2)
        strPiece2.set(m$.Fnc.$piece(idField.get(),".",2));
        //<< 
        //<< if blnObj {
        if (mOp.Logical(blnObj.get())) {
          //<< set idClass = $$GetClass^COMViewObject(idClass,idField)
          idClass.set(m$.fnc$("COMViewObject.GetClass",idClass.get(),idField.get()));
          //<< // if Item->ItemId  get ItemId
          //<< set strColName = $translate(idField,"->","_")
          strColName.set(m$.Fnc.$translate(idField.get(),"->","_"));
          //<< set idField = $piece(idField,"->",$length(idField,"->"))
          idField.set(m$.Fnc.$piece(idField.get(),"->",m$.Fnc.$length(idField.get(),"->")));
        }
        //<< }
        //<< 
        //<< if $data(^CacheTempSQL($$$SQLID,"Data",pintLogicalRow,strColName)) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",pintLogicalRow.get(),strColName.get())))) {
          //<< set strValue = $get(^CacheTempSQL($$$SQLID,"Data",pintLogicalRow,strColName))
          strValue.set(m$.Fnc.$get(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",pintLogicalRow.get(),strColName.get())));
          //<< if blnObj {
          if (mOp.Logical(blnObj.get())) {
            //<< set idClass = $$GetClass^COMViewObject(idClass,idField)
            idClass.set(m$.fnc$("COMViewObject.GetClass",idClass.get(),idField.get()));
            //<< // if Item->ItemId  get ItemId
            //<< set idField = $piece(idField,"->",$length(idField,"->"))
            idField.set(m$.Fnc.$piece(idField.get(),"->",m$.Fnc.$length(idField.get(),"->")));
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< set strValue  = ""
          strValue.set("");
          //<< set strPiece3 = $piece(idField,".",3)
          strPiece3.set(m$.Fnc.$piece(idField.get(),".",3));
          //<< 
          //<< if $extract(strPiece2)="C" {
          if (mOp.Equal(m$.Fnc.$extract(strPiece2.get()),"C")) {
            //<< set idClass = $extract(strPiece2,2,$length(strPiece2))
            idClass.set(m$.Fnc.$extract(strPiece2.get(),2,m$.Fnc.$length(strPiece2.get())));
            //<< set idField = strPiece3
            idField.set(strPiece3.get());
            //<< set idForm  = idClass
            idForm.set(idClass.get());
          }
          //<< }
          //<< 
          //<< set intField = $piece($extract(idField,2,99),".",1)
          intField.set(m$.Fnc.$piece(m$.Fnc.$extract(idField.get(),2,99),".",1));
          //<< 
          //<< set blnValueShort=$$$NO
          blnValueShort.set(include.COMSYS.$$$NO(m$));
          //<< if $extract(strPiece2)="C" {
          if (mOp.Equal(m$.Fnc.$extract(strPiece2.get()),"C")) {
            //<< set idKey         = $$TwoPart(idClass,idKey,idField)    ;SR17130
            idKey.set(m$.fnc$("TwoPart",idClass.get(),idKey.get(),idField.get()));
            //<< set lstValue      = $$GetData^COMViewCellData(idClass,idKey,idField,.strCellAlign,,$listget(plstColumns,loop),idForm,$$$Separator)
            lstValue.set(m$.fnc$("COMViewCellData.GetData",idClass.get(),idKey.get(),idField.get(),strCellAlign,null,m$.Fnc.$listget(plstColumns.get(),loop.get()),idForm.get(),$$$Separator(m$)));
            //<< set blnValueShort = $listget(lstValue,1)
            blnValueShort.set(m$.Fnc.$listget(lstValue.get(),1));
            //<< set strValue      = $listget(lstValue,2)
            strValue.set(m$.Fnc.$listget(lstValue.get(),2));
          }
          //<< 
          //<< } elseif $find(idField,".") {
          else if (mOp.Logical(m$.Fnc.$find(idField.get(),"."))) {
            //<< set strValue = $$SubClass^COMViewCellData(pidClass,idKey,objRef,idField)
            strValue.set(m$.fnc$("COMViewCellData.SubClass",pidClass.get(),idKey.get(),objRef.get(),idField.get()));
          }
          //<< 
          //<< } elseif $extract(idField)="P" {
          else if (mOp.Equal(m$.Fnc.$extract(idField.get()),"P")) {
            //<< if blnView {
            if (mOp.Logical(blnView.get())) {
              //<< set strValue = $get(^CacheTempSQL($$$SQLID,"Data",pintLogicalRow,$$$WWW002PropertyName($get(^WWW002(0,idClass,intField,1)))))
              strValue.set(m$.Fnc.$get(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",pintLogicalRow.get(),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,idClass.get(),intField.get(),1))))));
            }
            //<< } else {
            else {
              //<< set strValue = $piece(idKey,",",intField)
              strValue.set(m$.Fnc.$piece(idKey.get(),",",intField.get()));
            }
            //<< }
            //<< 
            //<< if $extract(strValue)="""" {
            if (mOp.Equal(m$.Fnc.$extract(strValue.get()),"\"")) {
              //<< set strValue = $extract(strValue,2,$length(strValue)-1)
              strValue.set(m$.Fnc.$extract(strValue.get(),2,mOp.Subtract(m$.Fnc.$length(strValue.get()),1)));
            }
          }
          //<< }
          //<< 
          //<< } elseif $extract(idField)="D" {
          else if (mOp.Equal(m$.Fnc.$extract(idField.get()),"D")) {
            //<< if blnView {
            if (mOp.Logical(blnView.get())) {
              //<< set strValue = $get(^CacheTempSQL($$$SQLID,"Data",pintLogicalRow,$$$WWW002PropertyName($get(^WWW003(0,idClass,intField,1)))))
              strValue.set(m$.Fnc.$get(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",pintLogicalRow.get(),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW003",0,idClass.get(),intField.get(),1))))));
            }
            //<< } else {
            else {
              //<< // If there is a language class AND we have the relational field AND we have the main class,
              //<< // look up the translated relation.  If it doesn't exist, use the default.
              //<< if ($get(^CacheTempView(YUSER,"RelField"))=intField) && ($get(^CacheTempView(YUSER,"Class"))=idClass) {
              if ((mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"RelField")),intField.get())) && (mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")),idClass.get()))) {
                //<< set strLangRef = "^"_$get(^CacheTempView(YUSER,"RelLang"))_"("_$piece(strRef,"(",2)
                strLangRef.set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"RelLang"))),"("),m$.Fnc.$piece(strRef.get(),"(",2)));
                //<< set $piece(strLangRef,",",$length(strLangRef,",")) = "SPRACHE,1)"
                m$.pieceVar(strLangRef,",",m$.Fnc.$length(strLangRef.get(),",")).set("SPRACHE,1)");
                //<< 
                //<< xecute "set strValue = $get("_strLangRef_")"
                m$.Cmd.Xecute(mOp.Concat(mOp.Concat("set strValue = $get(",strLangRef.get()),")"));
              }
              //<< }
              //<< if strValue="" {
              if (mOp.Equal(strValue.get(),"")) {
                //<< set strValue = $piece(objRef,Y,intField)
                strValue.set(m$.Fnc.$piece(objRef.get(),m$.var("Y").get(),intField.get()));
              }
            }
          }
          //<< }
          //<< }
          //<< 
          //<< } elseif $extract(idField)="C" {
          else if (mOp.Equal(m$.Fnc.$extract(idField.get()),"C")) {
            //<< set strValue = $$GetCalculatedValue(pidClass,idField,idKey,objRef,pintLogicalRow) ;SR13213
            strValue.set(m$.fnc$("GetCalculatedValue",pidClass.get(),idField.get(),idKey.get(),objRef.get(),pintLogicalRow.get()));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if $extract(strPiece2)'="C" {
        if (mOp.NotEqual(m$.Fnc.$extract(strPiece2.get()),"C")) {
          //<< if 'blnObj {
          if (mOp.Not(blnObj.get())) {
            //<< set lstValue = $$DisplayValue(idClass,idField,strValue,idKey,.strCellAlign)
            lstValue.set(m$.fnc$("DisplayValue",idClass.get(),idField.get(),strValue.get(),idKey.get(),strCellAlign));
          }
          //<< } else {
          else {
            //<< set lstValue = $$DisplayValueForObject^COMViewObject(idClass,idField,strValue,idKey,.strCellAlign)
            lstValue.set(m$.fnc$("COMViewObject.DisplayValueForObject",idClass.get(),idField.get(),strValue.get(),idKey.get(),strCellAlign));
          }
          //<< }
          //<< set blnValueShort = $listget(lstValue,1)
          blnValueShort.set(m$.Fnc.$listget(lstValue.get(),1));
          //<< set strValue      = $listget(lstValue,2)
          strValue.set(m$.Fnc.$listget(lstValue.get(),2));
          //<< set strValue      = $$Replace^COMUtilStr($listget(lstValue,2),"|"," &nbsp;")
          strValue.set(m$.fnc$("COMUtilStr.Replace",m$.Fnc.$listget(lstValue.get(),2),"|"," &nbsp;"));
          //<< set strRow        = strRow_$translate(strValue,Y,"-")
          strRow.set(mOp.Concat(strRow.get(),m$.Fnc.$translate(strValue.get(),m$.var("Y").get(),"-")));
          //<< if blnValueShort {
          if (mOp.Logical(blnValueShort.get())) {
            //<< set strRow = strRow_"&nbsp;..."
            strRow.set(mOp.Concat(strRow.get(),"&nbsp;..."));
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< set strRow=strRow_$translate(strValue,Y,"-")
          strRow.set(mOp.Concat(strRow.get(),m$.Fnc.$translate(strValue.get(),m$.var("Y").get(),"-")));
        }
        //<< }
        //<< 
        //<< set strAlign          = strAlign_strCellAlign
        strAlign.set(mOp.Concat(strAlign.get(),strCellAlign.get()));
        //<< set strBlnValuesShort = strBlnValuesShort_blnValueShort
        strBlnValuesShort.set(mOp.Concat(strBlnValuesShort.get(),blnValueShort.get()));
      }
    }
    //<< }
    //<< }
    //<< do ExpandRow(strRow,$$$Separator,.objRow)
    m$.Cmd.Do("ExpandRow",strRow.get(),$$$Separator(m$),objRow);
    //<< 
    //<< set idxRows = ""
    idxRows.set("");
    //<< for {
    for (;true;) {
      //<< set idxRows = $order(objRow(idxRows))
      idxRows.set(m$.Fnc.$order(objRow.var(idxRows.get())));
      //<< quit:idxRows=""
      if (mOp.Equal(idxRows.get(),"")) {
        break;
      }
      //<< 
      //<< set strRow = objRow(idxRows)
      strRow.set(objRow.var(idxRows.get()).get());
      //<< if penumType'=$$$EnumDisplayTypeCOMView {
      if (mOp.NotEqual(penumType.get(),include.COMSYS.$$$EnumDisplayTypeCOMView(m$))) {
        //<< set intLen = $length(strRow,Y)
        intLen.set(m$.Fnc.$length(strRow.get(),m$.var("Y").get()));
        //<< do:penumType=$$$EnumDisplayTypeExcel pobjOutput.WriteLine("<tr>")
        if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeExcel(m$))) {
          m$.Cmd.Do(pobjOutput.getORef(),"WriteLine","<tr>");
        }
        //<< for intCount=1:1:intLen {
        for (intCount.set(1);(mOp.LessOrEqual(intCount.get(),intLen.get()));intCount.set(mOp.Add(intCount.get(),1))) {
          //<< set strItem=$piece(strRow,Y,intCount)
          strItem.set(m$.Fnc.$piece(strRow.get(),m$.var("Y").get(),intCount.get()));
          //<< if penumType=$$$EnumDisplayTypeExcel {
          if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeExcel(m$))) {
            //<< do pobjOutput.WriteLine("<td "_$select(pintRow:"class='row'",1:"")_" style='text-align="_$piece(strAlign,Y,intCount)_";'>")
            m$.Cmd.Do(pobjOutput.getORef(),"WriteLine",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<td ",m$.Fnc.$select(pintRow.get(),"class='row'",1,""))," style='text-align="),m$.Fnc.$piece(strAlign.get(),m$.var("Y").get(),intCount.get())),";'>"));
            //<< set strItem = $$FullReplace^COMUtilStr(strItem,"<p />","")
            strItem.set(m$.fnc$("COMUtilStr.FullReplace",strItem.get(),"<p />",""));
            //<< set strItem = $$FullReplace^COMUtilStr(strItem,"<p/>","")
            strItem.set(m$.fnc$("COMUtilStr.FullReplace",strItem.get(),"<p/>",""));
            //<< set strItem = $$FullReplace^COMUtilStr(strItem,"</p>","")
            strItem.set(m$.fnc$("COMUtilStr.FullReplace",strItem.get(),"</p>",""));
            //<< set strItem = $$FullReplace^COMUtilStr(strItem,"<p>","")
            strItem.set(m$.fnc$("COMUtilStr.FullReplace",strItem.get(),"<p>",""));
            //<< set strItem = $$FullReplace^COMUtilStr(strItem,"<br />","")
            strItem.set(m$.fnc$("COMUtilStr.FullReplace",strItem.get(),"<br />",""));
            //<< set strItem = $$FullReplace^COMUtilStr(strItem,"<br>","")
            strItem.set(m$.fnc$("COMUtilStr.FullReplace",strItem.get(),"<br>",""));
            //<< do pobjOutput.WriteLine(strItem)
            m$.Cmd.Do(pobjOutput.getORef(),"WriteLine",strItem.get());
            //<< do pobjOutput.WriteLine("</td>")
            m$.Cmd.Do(pobjOutput.getORef(),"WriteLine","</td>");
          }
          //<< } else {
          else {
            //<< if strItem[","     set strItem = """"_strItem_""""
            if (mOp.Contains(strItem.get(),",")) {
              strItem.set(mOp.Concat(mOp.Concat("\"",strItem.get()),"\""));
            }
            //<< if intCount<intLen set strItem = strItem_","
            if (mOp.Less(intCount.get(),intLen.get())) {
              strItem.set(mOp.Concat(strItem.get(),","));
            }
            //<< do pobjOutput.Write(strItem)
            m$.Cmd.Do(pobjOutput.getORef(),"Write",strItem.get());
          }
        }
        //<< }
        //<< }
        //<< if penumType=$$$EnumDisplayTypeExcel {
        if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeExcel(m$))) {
          //<< do pobjOutput.WriteLine("</tr>")
          m$.Cmd.Do(pobjOutput.getORef(),"WriteLine","</tr>");
        }
        //<< } else {
        else {
          //<< do pobjOutput.WriteLine()
          m$.Cmd.Do(pobjOutput.getORef(),"WriteLine");
        }
        //<< }
        //<< set Row = $increment(Row)
        Row.set(m$.Fnc.$increment(Row));
      }
      //<< } else {
      else {
        //<< write "Add(bdy,"_$increment(Row)_",'"_$zconvert(strRow,"o","JS")_"','"_$zconvert(idKey,"o","JS")_"','"_strAlign_"','"_strBlnValuesShort_"');"       // SR13447
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Add(bdy,",m$.Fnc.$increment(Row)),",'"),m$.Fnc.$zconvert(strRow.get(),"o","JS")),"','"),m$.Fnc.$zconvert(idKey.get(),"o","JS")),"','"),strAlign.get()),"','"),strBlnValuesShort.get()),"');"));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< TwoPart(pidClass,pidKey,pidField)
  public Object TwoPart(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If the class has a two part primary key where the first is related to WWW0121
    //<< ; then assume YLOCATION.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Jun-2011   shobby  SR17130: Removed WWW003 processing.  Don't know why that
    //<< ;                           would have been added.
    //<< ; 12-Apr-2011   shobby  SR17130: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW002,objWWW003
    mVar objWWW002 = m$.var("objWWW002");
    mVar objWWW003 = m$.var("objWWW003");
    m$.newVar(objWWW002,objWWW003);
    //<< 
    //<< if (pidClass'="") {
    if ((mOp.NotEqual(pidClass.get(),""))) {
      //<< set objWWW002 = $get(^WWW002(0,pidClass,1,1))
      objWWW002.set(m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),1,1)));
      //<< if $$$WWW002RelationClass(objWWW002)="WWW0121" {
      if (mOp.Equal(include.WWWConst.$$$WWW002RelationClass(m$,objWWW002),"WWW0121")) {
        //<< if $get(YLOCATION)'="" {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLOCATION")),"")) {
          //<< set pidKey = YLOCATION_","_pidKey
          pidKey.set(mOp.Concat(mOp.Concat(m$.var("YLOCATION").get(),","),pidKey.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit pidKey
    return pidKey.get();
  }

  //<< ;if (pidClass'="") {
  //<< ;   if $extract(pidField)="P" {
  //<< ;       set objWWW002 = $get(^WWW002(0,pidClass,1,1))
  //<< ;       if $$$WWW002RelationClass(objWWW002)="WWW0121" {
  //<< ;           if $get(YLOCATION)'="" {
  //<< ;               set pidKey = YLOCATION_","_pidKey
  //<< ;           }
  //<< ;       }
  //<< ;   } elseif $extract(pidField)="D" {
  //<< ;       set objWWW003 = $get(^WWW003(0,pidClass,1,1))
  //<< ;       if $$$WWW003RelationDatabase(objWWW003)="WWW0121" {
  //<< ;           if $get(YLOCATION)'="" {
  //<< ;               set pidKey = YLOCATION_","_pidKey
  //<< ;           }
  //<< ;       }
  //<< ;   }
  //<< ;}
  //<< ;quit pidKey
  //<< 
  //<< 
  //<< DataAccess(pidClass,pidKey,&pblnCheck=$$$YES)
  public Object DataAccess(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnCheck = m$.newVarRef("pblnCheck",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Call Data Access function on record if there is one AND not on masterdata search
    //<< ;
    //<< ; Params:   pidClass    - class of data
    //<< ;           pidKey      - data key
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Dec-2009   shobby  SR17075: If a single space is passed in as the key we just
    //<< ;                           want to know if a valid test exists and don't care about the result.
    //<< ; 09-Oct-2007   shobby  SRBR014744: If no callouts then don't keep checking.
    //<< ; 09-Oct-2007   shobby  SRBR014744: Pass the class that is being used to
    //<< ;                           populate the list in to the DataAccess call
    //<< ; 28-Apr-2006   JW      SR14427: Corrected form
    //<< ; 28-Sep-2005   JW      SR13447: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnValid,idFieldNo,idFieldType,idForm,strCallBack
    mVar blnValid = m$.var("blnValid");
    mVar idFieldNo = m$.var("idFieldNo");
    mVar idFieldType = m$.var("idFieldType");
    mVar idForm = m$.var("idForm");
    mVar strCallBack = m$.var("strCallBack");
    m$.newVar(blnValid,idFieldNo,idFieldType,idForm,strCallBack);
    //<< 
    //<< set blnValid    = $$$YES
    blnValid.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< set strCallBack = $$$WWW001DataAccess($get(^WWW001(0,pidClass,1)))
    strCallBack.set(include.WWWConst.$$$WWW001DataAccess(m$,m$.Fnc.$get(m$.var("^WWW001",0,pidClass.get(),1))));
    //<< set pblnCheck   = $get(pblnCheck)
    pblnCheck.set(m$.Fnc.$get(pblnCheck));
    //<< 
    //<< if strCallBack'="" {
    if (mOp.NotEqual(strCallBack.get(),"")) {
      //<< set idForm      = $get(^CacheTempView(YUSER,"CallingForm"))
      idForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallingForm")));
      //<< set idFieldType = $get(^CacheTempView(YUSER,"FieldType"))
      idFieldType.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"FieldType")));
      //<< set idFieldNo   = $get(^CacheTempView(YUSER,"FieldNo"))
      idFieldNo.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"FieldNo")));
      //<< 
      //<< ;SR17075vvvv
      //<< if (pidKey=" ")||(idFieldNo'="") || ($$$WWW120ClassUsedInForm($get(^WWW120(0,idForm,1)))'=pidClass) {       // Not on own master data
      if ((mOp.Equal(pidKey.get()," ")) || (mOp.NotEqual(idFieldNo.get(),"")) || (mOp.NotEqual(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,idForm.get(),1))),pidClass.get()))) {
        //<< set blnValid = $$DataAccess^WWWFieldValidation(strCallBack,pidKey,idForm,idFieldType,idFieldNo,,pidClass,.pblnCheck)
        blnValid.set(m$.fnc$("WWWFieldValidation.DataAccess",strCallBack.get(),pidKey.get(),idForm.get(),idFieldType.get(),idFieldNo.get(),null,pidClass.get(),pblnCheck));
      }
    }
    //<< ;   FIXME : <GRF> Parameter 6 is Error code - should we we processing an error
    //<< ;                 condition? (Pre-existing situation)
    //<< }
    //<< }
    //<< quit blnValid
    return blnValid.get();
  }

  //<< 
  //<< 
  //<< GetCalculatedValue(pidClass,pidField,pidKey,pobjRef,pintLogicalRow)
  public Object GetCalculatedValue(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pobjRef = m$.newVarRef("pobjRef",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pintLogicalRow = m$.newVarRef("pintLogicalRow",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the value of a calculated field - Filter type "C"
    //<< ;
    //<< ; Params:
    //<< ;   pinRow (added)        : The row number to be displayed
    //<< ;   pintLogicalrow (added): The logical row to be displayed
    //<< ;
    //<< ; Returns: The result of a function call with substitution of {Parameter} entries.
    //<< ;
    //<< ; History:
    //<< ; 24-Jan-2011   GRF     -: use idxClass rather than idClass; idxParam already set
    //<< ; 03-Sep-2009   PPP     SR16842: Calculated fields within Calculated Fields
    //<< ;                           update fix
    //<< ; 11-Aug-2006   RPW     SR14896: No longer need the result set
    //<< ; 27-Apr-2006   JW      SR14423: Convert date for calc fields.
    //<< ; 19-Apr-2006   JW      SR14429: Added pobjResult param
    //<< ; 03-Jan-2006   SteveS  SR14116: Use $$GetParamString^WWW001CalcFields
    //<< ; 23-Sep-2005   shobby  SR13213: Company is a special case of a property.
    //<< ;                           (Implicitly defined primary key)
    //<< ; 22-Sep-2005   shobby  SR13213: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ; e.g. a calculation with the code string "$$SupplierDetail^INRPAUF({Company},{OrderSupplier},8)"
    //<< ;      might generate "$$SupplierDetail^INRPAUF(0,"ABC123",8)" if the OrderSuppler "ABC123" was part
    //<< ;      of pidKey or pobjRef
    //<< ;      This is then executed to generate strValue which is returned.
    //<< ;---------------------------------------
    //<< new idField,idPiece,idStrField,idxClass,idxParam,loop
    mVar idField = m$.var("idField");
    mVar idPiece = m$.var("idPiece");
    mVar idStrField = m$.var("idStrField");
    mVar idxClass = m$.var("idxClass");
    mVar idxParam = m$.var("idxParam");
    mVar loop = m$.var("loop");
    m$.newVar(idField,idPiece,idStrField,idxClass,idxParam,loop);
    //<< new objWWW003Calc,strCode,strData,strParameter,strParamList,strValue
    mVar objWWW003Calc = m$.var("objWWW003Calc");
    mVar strCode = m$.var("strCode");
    mVar strData = m$.var("strData");
    mVar strParameter = m$.var("strParameter");
    mVar strParamList = m$.var("strParamList");
    mVar strValue = m$.var("strValue");
    m$.newVar(objWWW003Calc,strCode,strData,strParameter,strParamList,strValue);
    //<< 
    //<< set strValue = ""
    strValue.set("");
    //<< set idxClass = $$$Index(pidClass)
    idxClass.set(include.MEDConst.$$$Index(m$,pidClass));
    //<< set idField  = $extract(pidField,2,99)
    idField.set(m$.Fnc.$extract(pidField.get(),2,99));
    //<< 
    //<< if (pidClass'="") && (pidField'="") {
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(pidField.get(),""))) {
      //<< set objWWW003Calc = $get(^WWW003Calc(0,pidClass,idField,1))
      objWWW003Calc.set(m$.Fnc.$get(m$.var("^WWW003Calc",0,pidClass.get(),idField.get(),1)));
      //<< set strCode = $$$WWW003CalcCode(objWWW003Calc)
      strCode.set(include.WWWConst.$$$WWW003CalcCode(m$,objWWW003Calc));
      //<< 
      //<< if strCode'="" {
      if (mOp.NotEqual(strCode.get(),"")) {
        //<< set strParamList = $$GetParamString^WWW001CalcFields(strCode)  ; e.g. "{Company},{OrderSupplier}"
        strParamList.set(m$.fnc$("WWW001CalcFields.GetParamString",strCode.get()));
        //<< set strParameter = ""
        strParameter.set("");
        //<< for loop=2:1:$length(strParamList,"{") {
        for (loop.set(2);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strParamList.get(),"{")));loop.set(mOp.Add(loop.get(),1))) {
          //<< set strParameter = $piece($piece(strParamList,"{",loop),"}",1)
          strParameter.set(m$.Fnc.$piece(m$.Fnc.$piece(strParamList.get(),"{",loop.get()),"}",1));
          //<< set idxParam     = $$$Index(strParameter)
          idxParam.set(include.MEDConst.$$$Index(m$,strParameter));
          //<< 
          //<< if $data(^CacheTempSQL($$$SQLID,"Data",pintLogicalRow,strParameter)) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",pintLogicalRow.get(),strParameter.get())))) {
            //<< set strData = $get(^CacheTempSQL($$$SQLID,"Data",pintLogicalRow,strParameter))
            strData.set(m$.Fnc.$get(m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"Data",pintLogicalRow.get(),strParameter.get())));
          }
          //<< 
          //<< } else {
          else {
            //<< ; Set value
            //<< if strParameter="Company" {
            if (mOp.Equal(strParameter.get(),"Company")) {
              //<< set strData = 0    ;= YM
              strData.set(0);
            }
            //<< 
            //<< ; Parameter is the result of another calculation for this class
            //<< } elseif $data(^WWW003Calcs(0,1,idxParam,pidClass)) {
            else if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW003Calcs",0,1,idxParam.get(),pidClass.get())))) {
              //<< set idStrField = +$order(^WWW003Calcs(0,1,idxParam,pidClass,""))
              idStrField.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW003Calcs",0,1,idxParam.get(),pidClass.get(),""))));
              //<< set strData = $$GetCalculatedValue(pidClass,"C"_idStrField,pidKey,pobjRef,pintLogicalRow)
              strData.set(m$.fnc$("GetCalculatedValue",pidClass.get(),mOp.Concat("C",idStrField.get()),pidKey.get(),pobjRef.get(),pintLogicalRow.get()));
            }
            //<< 
            //<< ; Parameter is key value or a data value
            //<< } else {
            else {
              //<< ;           set idxParam = $$$Index(strParameter)
              //<< set idPiece  = $order(^WWW002s(0,3,idxClass,idxParam,pidClass,""))
              idPiece.set(m$.Fnc.$order(m$.var("^WWW002s",0,3,idxClass.get(),idxParam.get(),pidClass.get(),"")));
              //<< if idPiece'="" {
              if (mOp.NotEqual(idPiece.get(),"")) {
                //<< set strData = $piece(pidKey,",",idPiece)
                strData.set(m$.Fnc.$piece(pidKey.get(),",",idPiece.get()));
              }
              //<< } else {
              else {
                //<< set idPiece = $order(^WWW003s(0,3,idxClass,idxParam,pidClass,""))
                idPiece.set(m$.Fnc.$order(m$.var("^WWW003s",0,3,idxClass.get(),idxParam.get(),pidClass.get(),"")));
                //<< if idPiece'="" {
                if (mOp.NotEqual(idPiece.get(),"")) {
                  //<< set strData = $piece(pobjRef,Y,idPiece)
                  strData.set(m$.Fnc.$piece(pobjRef.get(),m$.var("Y").get(),idPiece.get()));
                }
              }
            }
          }
          //<< }
          //<< }
          //<< }
          //<< }
          //<< set strCode = $$Replace^COMUtilStr(strCode,"{"_strParameter_"}",""""_strData_"""")
          strCode.set(m$.fnc$("COMUtilStr.Replace",strCode.get(),mOp.Concat(mOp.Concat("{",strParameter.get()),"}"),mOp.Concat(mOp.Concat("\"",strData.get()),"\"")));
        }
        //<< }
        //<< xecute "set strValue="_strCode
        m$.Cmd.Xecute(mOp.Concat("set strValue=",strCode.get()));
      }
      //<< }
      //<< if $$$WWW003CalcDataType(objWWW003Calc)="%Date" {
      if (mOp.Equal(include.WWWConst.$$$WWW003CalcDataType(m$,objWWW003Calc),"%Date")) {
        //<< set strValue = $$$FormatDate(strValue)
        strValue.set(include.COMSYSWWW.$$$FormatDate(m$,strValue));
      }
    }
    //<< }
    //<< }
    //<< quit strValue
    return strValue.get();
  }

  //<< 
  //<< 
  //<< DisplayValue(pidClass="",pidField="",pstrValue="",pidKey="",pstrAlign,blnTruncate=$$$YES,pblnIsControl=$$$NO,pidForm="")
  public Object DisplayValue(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pstrAlign = m$.newVarRef("pstrAlign",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar blnTruncate = m$.newVarRef("blnTruncate",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$YES(m$));
    mVar pblnIsControl = m$.newVarRef("pblnIsControl",(((_p!=null)&&(_p.length>=7))?_p[6]:null),include.COMSYS.$$$NO(m$));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=8))?_p[7]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Converts a value for display. If the field has a relation, show it.
    //<< ;
    //<< ;
    //<< ; NOTE re Macros : $$$WWW002* and $$$WWW003* share many matching fields
    //<< ;
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 07-Jan-2011   GRF     SR17579: Use explicit tag for WWWTR calls
    //<< ; 23-Nov-2010   shobby  SR17618: Support COMView searching on formulas
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 17-Nov-2009   GRF     SR16871: convert »CostCentre« into YLOCATION value
    //<< ;                           (allow US spelling as well as English); replace
    //<< ;                           $$$Add with $$$AddQuotes
    //<< ; 02-Jul-2009   PPP     SR16663: Add the Calculated Relation Display Fields
    //<< ; 20-Feb-2008   shobby  SRBR014900: Allow greater intMaxDataLength if we are
    //<< ;                           going to expand the line into multiple lines.
    //<< ; 23-Nov-2007   shobby  SRBR014790: New parameter pidForm, this is passed in to
    //<< ;                           GetRelation to allow translating of cells that belong
    //<< ;                           to referenced classes, not the current class/form
    //<< ;                           that we are looking at.
    //<< ; 11-Dec-2006   JW      SR15299: Check for language translation
    //<< ; 06-Sep-2006   RPW     SRBR014073: Handle type of Date, added parameter
    //<< ;                           pblnIsControl as both data and control come through
    //<< ;                           here and there is no way to tell the difference.
    //<< ;                           Note that a control has a date in display format,
    //<< ;                           whereas data has it in horolog format.
    //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
    //<< ; 19-Jun-2005   Paul K  SR12577: Don't display relations if WWW002RelationDisplayOptions()=2
    //<< ; 09-May-2005   Paul K  Added support for file names being in an applicaction parameter.
    //<< ; 14-Mar-2005   Paul K  SR11888: If data too long, return maxlength characters (not 100)
    //<< ; 10-Feb-2005   PO      SR10965: Changed over to returning list, including
    //<< ;                           whether value cut short
    //<< ; 06-Dec-2004   Paul K  Fixed Bad data error.
    //<< ;-------------------------------------------------------------------------------
    //<< new blnContinue,blnLang,idClass,idInputType,idLangClass,idRelationClass
    mVar blnContinue = m$.var("blnContinue");
    mVar blnLang = m$.var("blnLang");
    mVar idClass = m$.var("idClass");
    mVar idInputType = m$.var("idInputType");
    mVar idLangClass = m$.var("idLangClass");
    mVar idRelationClass = m$.var("idRelationClass");
    m$.newVar(blnContinue,blnLang,idClass,idInputType,idLangClass,idRelationClass);
    //<< new intCompany,intMaxDataLen,Loop,lstValue,objCOMViewConfig,objRef,objWWW003
    mVar intCompany = m$.var("intCompany");
    mVar intMaxDataLen = m$.var("intMaxDataLen");
    mVar Loop = m$.var("Loop");
    mVar lstValue = m$.var("lstValue");
    mVar objCOMViewConfig = m$.var("objCOMViewConfig");
    mVar objRef = m$.var("objRef");
    mVar objWWW003 = m$.var("objWWW003");
    m$.newVar(intCompany,intMaxDataLen,Loop,lstValue,objCOMViewConfig,objRef,objWWW003);
    //<< new strCalcDisplay,strDisplay,strGlobal,strLangGlobal,strRelation,strUCValue,strValue
    mVar strCalcDisplay = m$.var("strCalcDisplay");
    mVar strDisplay = m$.var("strDisplay");
    mVar strGlobal = m$.var("strGlobal");
    mVar strLangGlobal = m$.var("strLangGlobal");
    mVar strRelation = m$.var("strRelation");
    mVar strUCValue = m$.var("strUCValue");
    mVar strValue = m$.var("strValue");
    m$.newVar(strCalcDisplay,strDisplay,strGlobal,strLangGlobal,strRelation,strUCValue,strValue);
    //<< 
    //<< ;=======================================
    //<< ; "»" = $char(187)     "«" = $char(171)
    //<< ;=======================================
    //<< 
    //<< if ($extract(pstrValue)="»") && ($extract($reverse(pstrValue))="«") {  ;Used for things like YUSER,YBED,YLOCATION etc...
    if ((mOp.Equal(m$.Fnc.$extract(pstrValue.get()),"»")) && (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(pstrValue.get())),"«"))) {
      //<< set strValue=$extract(pstrValue,2,$length(pstrValue)-1)
      strValue.set(m$.Fnc.$extract(pstrValue.get(),2,mOp.Subtract(m$.Fnc.$length(pstrValue.get()),1)));
      //<< 
      //<< set strUCValue = $zconvert(strValue,"u")
      strUCValue.set(m$.Fnc.$zconvert(strValue.get(),"u"));
      //<< if ((strUCValue="COSTCENTRE") || (strUCValue="COSTCENTER")) && ($data(YLOCATION)=1) {
      if (mOp.Logical(((mOp.Equal(strUCValue.get(),"COSTCENTRE")) || (mOp.Equal(strUCValue.get(),"COSTCENTER")))) && (mOp.Equal(m$.Fnc.$data(m$.var("YLOCATION")),1))) {
        //<< set pstrValue = $$GetCostCentre^INCostCentre(YLOCATION)
        pstrValue.set(m$.fnc$("INCostCentre.GetCostCentre",m$.var("YLOCATION").get()));
      }
      //<< 
      //<< } elseif (strValue'="") && ($data(@strValue)=1) {
      else if ((mOp.NotEqual(strValue.get(),"")) && (mOp.Equal(m$.Fnc.$data(m$.indirectVar(strValue.get())),1))) {
        //<< set pstrValue = @strValue
        pstrValue.set(m$.indirectVar(strValue.get()).get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set strValue  = ""
    strValue.set("");
    //<< set pstrAlign = "left"
    pstrAlign.set("left");
    //<< 
    //<< set objCOMViewConfig = $get(^COMViewConfig(0,YM,1))
    objCOMViewConfig.set(m$.Fnc.$get(m$.var("^COMViewConfig",0,m$.var("YM").get(),1)));
    //<< 
    //<< if $$ExpandSelection^COMViewConfig() {
    if (mOp.Logical(m$.fnc$("COMViewConfig.ExpandSelection"))) {
      //<< set intMaxDataLen = 10000
      intMaxDataLen.set(10000);
    }
    //<< } else {
    else {
      //<< set intMaxDataLen = $$$COMViewConfigMaxdatalength(objCOMViewConfig)
      intMaxDataLen.set(include.COMConst.$$$COMViewConfigMaxdatalength(m$,objCOMViewConfig));
      //<< if intMaxDataLen'>0 set intMaxDataLen = 100
      if (mOp.NotGreater(intMaxDataLen.get(),0)) {
        intMaxDataLen.set(100);
      }
    }
    //<< }
    //<< 
    //<< if (pidClass'="") && (pidField'="") {
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(pidField.get(),""))) {
      //<< set objWWW003 = $$GetRelation^COMViewUtils(.pidClass,pidField,pidForm,$$$YES)
      objWWW003.set(m$.fnc$("COMViewUtils.GetRelation",pidClass,pidField.get(),pidForm.get(),include.COMSYS.$$$YES(m$)));
      //<< 
      //<< set idInputType     = $$$WWW002InputType(objWWW003)
      idInputType.set(include.WWWConst.$$$WWW002InputType(m$,objWWW003));
      //<< set idRelationClass = $$$WWW002RelationClass(objWWW003)
      idRelationClass.set(include.WWWConst.$$$WWW002RelationClass(m$,objWWW003));
      //<< 
      //<< if $find(",4,8,12,18,",","_$$$WWW002InputType(objWWW003)_",") {
      if (mOp.Logical(m$.Fnc.$find(",4,8,12,18,",mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW002InputType(m$,objWWW003)),",")))) {
        //<< set pstrAlign="right"
        pstrAlign.set("right");
      }
      //<< }
      //<< if idInputType=2 {
      if (mOp.Equal(idInputType.get(),2)) {
        //<< set pstrValue = ''pstrValue
        pstrValue.set(mOp.Not(mOp.Not(pstrValue.get())));
        //<< set strValue  = $$$SysEnum("JA/NEIN",pstrValue)
        strValue.set(include.COMSYSWWW.$$$SysEnum(m$,"JA/NEIN",pstrValue));
      }
      //<< 
      //<< } elseif idInputType=5 {                          ; password
      else if (mOp.Equal(idInputType.get(),5)) {
        //<< set strValue = "*****"
        strValue.set("*****");
      }
      //<< 
      //<< } elseif idInputType=10 {
      else if (mOp.Equal(idInputType.get(),10)) {
        //<< if pstrValue'="" {
        if (mOp.NotEqual(pstrValue.get(),"")) {
          //<< if idRelationClass="WWW101" {    ; idRelationClass = COMDirectoryListing
          if (mOp.Equal(idRelationClass.get(),"WWW101")) {
            //<< set pstrValue = $$GetEnumDescription^COMUtils($piece($$$WWW002RelationalPrimaryKeys(objWWW003),"""",2),pstrValue)
            pstrValue.set(m$.fnc$("COMUtils.GetEnumDescription",m$.Fnc.$piece(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,objWWW003),"\"",2),pstrValue.get()));
          }
          //<< }
          //<< 
          //<< if $extract(pidClass,1,3)="WWW" {  ;not quite sure how to determine if a pic is system or user...
          if (mOp.Equal(m$.Fnc.$extract(pidClass.get(),1,3),"WWW")) {
            //<< set strValue = "<img src='"_YGIF_pstrValue_"' title='"_$zconvert(pstrValue,"o","HTML")_"'>"
            strValue.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<img src='",m$.var("YGIF").get()),pstrValue.get()),"' title='"),m$.Fnc.$zconvert(pstrValue.get(),"o","HTML")),"'>"));
          }
          //<< } else {
          else {
            //<< set strValue = "<img src='"_YGIF1_pstrValue_"' title='"_$zconvert(pstrValue,"o","HTML")_"'>"
            strValue.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<img src='",m$.var("YGIF1").get()),pstrValue.get()),"' title='"),m$.Fnc.$zconvert(pstrValue.get(),"o","HTML")),"'>"));
          }
        }
      }
      //<< }
      //<< }
      //<< 
      //<< } elseif pblnIsControl && (idInputType=1) {                // date types
      else if (mOp.Logical(pblnIsControl.get()) && (mOp.Equal(idInputType.get(),1))) {
        //<< set strValue = pstrValue
        strValue.set(pstrValue.get());
      }
      //<< 
      //<< } else {
      else {
        //<< if (idInputType'=3)       &&  (pstrValue'="")              &&
        //<< (idRelationClass'="")  &&  (idRelationClass'=pidClass)  &&
        //<< ($$$WWW002RelationDisplayOptions(objWWW003)'=2)             {  ; 2 : "Don't Display Relations"
        if ((mOp.NotEqual(idInputType.get(),3)) && (mOp.NotEqual(pstrValue.get(),"")) && (mOp.NotEqual(idRelationClass.get(),"")) && (mOp.NotEqual(idRelationClass.get(),pidClass.get())) && (mOp.NotEqual(include.WWWConst.$$$WWW002RelationDisplayOptions(m$,objWWW003),2))) {
          //<< if ($extract(pstrValue,1,3)="@$$") {
          if ((mOp.Equal(m$.Fnc.$extract(pstrValue.get(),1,3),"@$$"))) {
            //<< xecute "set strValue="_$extract(pstrValue,2,$length(pstrValue))  ;SR17618
            m$.Cmd.Xecute(mOp.Concat("set strValue=",m$.Fnc.$extract(pstrValue.get(),2,m$.Fnc.$length(pstrValue.get()))));
          }
          //<< 
          //<< } else {
          else {
            //<< set blnContinue = $$$YES
            blnContinue.set(include.COMSYS.$$$YES(m$));
            //<< // check for language translation
            //<< set idLangClass = $$$WWW001LanguageClassForRelations($get(^WWW001(0,idRelationClass,1)))
            idLangClass.set(include.WWWConst.$$$WWW001LanguageClassForRelations(m$,m$.Fnc.$get(m$.var("^WWW001",0,idRelationClass.get(),1))));
            //<< set blnLang     = (idLangClass'="")
            blnLang.set((mOp.NotEqual(idLangClass.get(),"")));
            //<< 
            //<< set idClass     = idRelationClass
            idClass.set(idRelationClass.get());
            //<< set intCompany  = $$$WWWYM(idClass)
            intCompany.set(include.COMSYSWWW.$$$WWWYM(m$,idClass));
            //<< set strGlobal   = "("_$$$AddQuotes(intCompany)
            strGlobal.set(mOp.Concat("(",include.COMSYS.$$$AddQuotes(m$,intCompany)));
            //<< 
            //<< if $$$WWW002RelationalPrimaryKeys(objWWW003)'="" {
            if (mOp.NotEqual(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,objWWW003),"")) {
              //<< for Loop=1:1:$length($$$WWW002RelationalPrimaryKeys(objWWW003),",") {
              for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,objWWW003),",")));Loop.set(mOp.Add(Loop.get(),1))) {
                //<< set strRelation = $piece($$$WWW002RelationalPrimaryKeys(objWWW003),",",Loop)
                strRelation.set(m$.Fnc.$piece(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,objWWW003),",",Loop.get()));
                //<< if (+strRelation'=strRelation) && ('$find(strRelation,"""")) {
                if ((mOp.NotEqual(mOp.Positive(strRelation.get()),strRelation.get())) && (mOp.Not(m$.Fnc.$find(strRelation.get(),"\"")))) {
                  //<< if '$data(@strRelation) {
                  if (mOp.Not(m$.Fnc.$data(m$.indirectVar(strRelation.get())))) {
                    //<< do FindRelation^COMViewUtils(pidClass,strRelation,pidKey)
                    m$.Cmd.Do("COMViewUtils.FindRelation",pidClass.get(),strRelation.get(),pidKey.get());
                  }
                  //<< }
                  //<< if $data(@strRelation) {
                  if (mOp.Logical(m$.Fnc.$data(m$.indirectVar(strRelation.get())))) {
                    //<< set strRelation = $$$AddQuotes(@strRelation)
                    strRelation.set(include.COMSYS.$$$AddQuotes(m$,m$.indirectVar(strRelation.get())));
                  }
                  //<< } else {
                  else {
                    //<< set strRelation = ""
                    strRelation.set("");
                  }
                }
                //<< }
                //<< }
                //<< if (strRelation="")||(strRelation="""""") set blnContinue = $$$NO
                if ((mOp.Equal(strRelation.get(),"")) || (mOp.Equal(strRelation.get(),"\"\""))) {
                  blnContinue.set(include.COMSYS.$$$NO(m$));
                }
                //<< set strGlobal=strGlobal_","_strRelation
                strGlobal.set(mOp.Concat(mOp.Concat(strGlobal.get(),","),strRelation.get()));
              }
            }
            //<< }
            //<< }
            //<< for Loop=1:1:$length(pstrValue,",") {
            for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(pstrValue.get(),",")));Loop.set(mOp.Add(Loop.get(),1))) {
              //<< if $piece(pstrValue,",",Loop)=""           set blnContinue = $$$NO
              if (mOp.Equal(m$.Fnc.$piece(pstrValue.get(),",",Loop.get()),"")) {
                blnContinue.set(include.COMSYS.$$$NO(m$));
              }
              //<< if $length($piece(pstrValue,",",Loop))>255 set blnContinue = $$$NO
              if (mOp.Greater(m$.Fnc.$length(m$.Fnc.$piece(pstrValue.get(),",",Loop.get())),255)) {
                blnContinue.set(include.COMSYS.$$$NO(m$));
              }
              //<< set strGlobal=strGlobal_","_$$$AddQuotes($piece(pstrValue,",",Loop))
              strGlobal.set(mOp.Concat(mOp.Concat(strGlobal.get(),","),include.COMSYS.$$$AddQuotes(m$,m$.Fnc.$piece(pstrValue.get(),",",Loop.get()))));
            }
            //<< }
            //<< 
            //<< // SR15299 - check for language translation
            //<< if blnContinue && blnLang {
            if (mOp.Logical(blnContinue.get()) && mOp.Logical(blnLang.get())) {
              //<< set strLangGlobal = "^"_idLangClass_strGlobal_","_$$$QUOTE(SPRACHE)_",1)"
              strLangGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",idLangClass.get()),strGlobal.get()),","),include.COMSYSString.$$$QUOTE(m$,m$.var("SPRACHE"))),",1)"));
              //<< set objRef = $get(@strLangGlobal)
              objRef.set(m$.Fnc.$get(m$.indirectVar(strLangGlobal.get())));
              //<< 
              //<< if objRef'="" {
              if (mOp.NotEqual(objRef.get(),"")) {
                //<< set blnContinue = $$$NO
                blnContinue.set(include.COMSYS.$$$NO(m$));
                //<< set strValue = " - "_$piece(objRef,Y,1)
                strValue.set(mOp.Concat(" - ",m$.Fnc.$piece(objRef.get(),m$.var("Y").get(),1)));
              }
            }
            //<< }
            //<< }
            //<< 
            //<< //set strGlobal=strGlobal_",1)"
            //<< 
            //<< if blnContinue {
            if (mOp.Logical(blnContinue.get())) {
              //<< set strGlobal = "^"_idClass_strGlobal_",1)"
              strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat("^",idClass.get()),strGlobal.get()),",1)"));
              //<< set objRef=$get(@strGlobal)
              objRef.set(m$.Fnc.$get(m$.indirectVar(strGlobal.get())));
              //<< if objRef'="" {
              if (mOp.NotEqual(objRef.get(),"")) {
                //<< set strValue=" -"
                strValue.set(" -");
                //<< //SR16663
                //<< set strDisplay=$$$WWW002RelationalDisplayItems(objWWW003)
                strDisplay.set(include.WWWConst.$$$WWW002RelationalDisplayItems(m$,objWWW003));
                //<< set strCalcDisplay=$$$WWW003CalcRelationalDisplayItems(objWWW003)
                strCalcDisplay.set(include.WWWConst.$$$WWW003CalcRelationalDisplayItems(m$,objWWW003));
                //<< if (strCalcDisplay'="") {
                if ((mOp.NotEqual(strCalcDisplay.get(),""))) {
                  //<< for Loop=1:1:$length(strCalcDisplay,";") {
                  for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(strCalcDisplay.get(),";")));Loop.set(mOp.Add(Loop.get(),1))) {
                    //<< set strValue =strValue_" "_$$GetCalculatedValue^WWWFOR71($$$WWW002RelationClass(objWWW003),$piece(strCalcDisplay,";",Loop),$$$WWW002RelationalPrimaryKeys(objWWW003)_","_pstrValue,objRef)
                    strValue.set(mOp.Concat(mOp.Concat(strValue.get()," "),m$.fnc$("WWWFOR71.GetCalculatedValue",include.WWWConst.$$$WWW002RelationClass(m$,objWWW003),m$.Fnc.$piece(strCalcDisplay.get(),";",Loop.get()),mOp.Concat(mOp.Concat(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,objWWW003),","),pstrValue.get()),objRef.get())));
                  }
                }
                //<< }
                //<< } else {
                else {
                  //<< if (strDisplay="") set strDisplay=1
                  if ((mOp.Equal(strDisplay.get(),""))) {
                    strDisplay.set(1);
                  }
                  //<< for Loop=1:1:$length(strDisplay,";") {
                  for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(strDisplay.get(),";")));Loop.set(mOp.Add(Loop.get(),1))) {
                    //<< set lstValue=$$DisplayValue($$$WWW002RelationClass(objWWW003),"D"_$piece(strDisplay,";",Loop),$piece(objRef,Y,$piece(strDisplay,";",Loop)),,,blnTruncate,,$$$WWW002RelationClass(objWWW003))
                    lstValue.set(m$.fnc$("DisplayValue",include.WWWConst.$$$WWW002RelationClass(m$,objWWW003),mOp.Concat("D",m$.Fnc.$piece(strDisplay.get(),";",Loop.get())),m$.Fnc.$piece(objRef.get(),m$.var("Y").get(),m$.Fnc.$piece(strDisplay.get(),";",Loop.get())),null,null,blnTruncate.get(),null,include.WWWConst.$$$WWW002RelationClass(m$,objWWW003)));
                    //<< set strValue=strValue_" "_$listget(lstValue,2)
                    strValue.set(mOp.Concat(mOp.Concat(strValue.get()," "),m$.Fnc.$listget(lstValue.get(),2)));
                  }
                }
              }
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< }
        //<< }
        //<< }
        //<< set strValue = $$GetLiteral^WWWTR($$$WWW003InputType(objWWW003),pstrValue)_strValue
        strValue.set(mOp.Concat(m$.fnc$("WWWTR.GetLiteral",include.WWWConst.$$$WWW003InputType(m$,objWWW003),pstrValue.get()),strValue.get()));
      }
    }
    //<< }
    //<< }
    //<< if blnTruncate && ($length(strValue)>intMaxDataLen) {
    if (mOp.Logical(blnTruncate.get()) && (mOp.Greater(m$.Fnc.$length(strValue.get()),intMaxDataLen.get()))) {
      //<< set lstValue = $listbuild($$$YES,$extract(strValue,1,intMaxDataLen))
      lstValue.set(m$.Fnc.$listbuild(include.COMSYS.$$$YES(m$),m$.Fnc.$extract(strValue.get(),1,intMaxDataLen.get())));
    }
    //<< } else {
    else {
      //<< set lstValue = $listbuild($$$NO,strValue)
      lstValue.set(m$.Fnc.$listbuild(include.COMSYS.$$$NO(m$),strValue.get()));
    }
    //<< }
    //<< quit lstValue
    return lstValue.get();
  }

  //<< 
  //<< 
  //<< GridClick(pidKey="",YBACK="",pblnJump=0,pidField,pblnBackToSearch=$$$NO)
  public Object GridClick(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YBACK = m$.newVarRef("YBACK",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnJump = m$.newVarRef("pblnJump",(((_p!=null)&&(_p.length>=3))?_p[2]:null),0);
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnBackToSearch = m$.newVarRef("pblnBackToSearch",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Link for Form & Key then open form.
    //<< ;
    //<< ; Called By : CallBack^COMViewCustom [only 3 arguments]
    //<< ;             CallBack functions from JS function GridClick in COMViewSetupJS1
    //<< ;
    //<< ; Returns:1
    //<< ;
    //<< ; History:
    //<< ; 10-Nov-2010   shobby      SR17580: pblnBackToSearch
    //<< ; 29-Oct-2010   shobby      SR17583: window.returnValue needs to be top.window.returnValue
    //<< ;                                   for Firefox. (Same with close)
    //<< ; 28-Apr-2009   PPP         SR16499:1. Added the pidField parameter
    //<< ;                                   2. Added the pidField parameter to Callback
    //<< ; 09-Sep-2008   PPP         SR15866:Update COMView to Objects (If 'V' do nothing)
    //<< ; 13-Dec-2007   shobby      SRBR014844: Only use the 'AppendValue' if the field
    //<< ;                               being populated is of type 10-Filename
    //<< ; 12-Aug-2007   shobby      SRBR014665: Close the window if specified in the
    //<< ;                               parameter regardless of what ever else is happening.
    //<< ; 28-Mar-2006   JW          SR13102: Keep YBACK
    //<< ; 23-Aug-2005   JW          SR12876: Check AppendValue
    //<< ; 20-Dec-2004   Paul K      Only return the last key if popup (SR#11298)
    //<< ; 19-Nov-2004   Paul K/SCR  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strLink,idForm,idClass,idFilter,strCallBack,strRelation,retVal,idCallingForm,objWWW122
    mVar strLink = m$.var("strLink");
    mVar idForm = m$.var("idForm");
    mVar idClass = m$.var("idClass");
    mVar idFilter = m$.var("idFilter");
    mVar strCallBack = m$.var("strCallBack");
    mVar strRelation = m$.var("strRelation");
    mVar retVal = m$.var("retVal");
    mVar idCallingForm = m$.var("idCallingForm");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(strLink,idForm,idClass,idFilter,strCallBack,strRelation,retVal,idCallingForm,objWWW122);
    //<< 
    //<< set idClass       = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set idForm        = $get(^CacheTempView(YUSER,"Form"))
    idForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Form")));
    //<< set strRelation   = $get(^CacheTempView(YUSER,"Relation"))
    strRelation.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Relation")));
    //<< set idCallingForm = $get(^CacheTempView(YUSER,"CallingForm"))
    idCallingForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallingForm")));
    //<< 
    //<< if ($extract(strRelation,1)'="V") {
    if ((mOp.NotEqual(m$.Fnc.$extract(strRelation.get(),1),"V"))) {
      //<< if (strRelation'="") && 'pblnJump {
      if ((mOp.NotEqual(strRelation.get(),"")) && mOp.Not(pblnJump.get())) {
        //<< if $get(^CacheTempView(YUSER,"CallBack"))'="" {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallBack")),"")) {
          //<< //SR16499
          //<< //  write "if (window.opener!=null) {window.opener.CallBack('CallBack^COMViewCustom','"_
          //<< //         $zconvert(pidKey,"o","JS")_
          //<< //         "');} else {window.setTimeout(""CallBack('CallBack^COMViewCustom','"_
          //<< //         $zconvert(pidKey,"o","JS")_"')"",50);}"
          //<< write "if (window.opener!=null) {"
          m$.Cmd.Write("if (window.opener!=null) {");
          //<< write "window.opener.CallBack('CallBack^COMViewCustom','"
          m$.Cmd.Write("window.opener.CallBack('CallBack^COMViewCustom','");
          //<< write $zconvert(pidKey,"o","JS")_"','0','"_$get(pidField)_"');} "
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$zconvert(pidKey.get(),"o","JS"),"','0','"),m$.Fnc.$get(pidField)),"');} "));
          //<< write "else {window.setTimeout(""CallBack('CallBack^COMViewCustom','"
          m$.Cmd.Write("else {window.setTimeout(\"CallBack('CallBack^COMViewCustom','");
          //<< write $zconvert(pidKey,"o","JS")_"','0','"_$get(pidField)_"')"",50);}"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$zconvert(pidKey.get(),"o","JS"),"','0','"),m$.Fnc.$get(pidField)),"')\",50);}"));
        }
        //<< 
        //<< } elseif $get(^CacheTempView(YUSER,"ReturnValue")) {
        else if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"ReturnValue")))) {
          //<< set retVal = $piece(pidKey,",",$length(pidKey,","))
          retVal.set(m$.Fnc.$piece(pidKey.get(),",",m$.Fnc.$length(pidKey.get(),",")));
          //<< 
          //<< if $get(^CacheTempView(YUSER,"AppendValue"))'="" {
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"AppendValue")),"")) {
            //<< set objWWW122 = $$Get^WWW122(idCallingForm,$extract($piece(strRelation,idCallingForm,2),2,9999))
            objWWW122.set(m$.fnc$("WWW122.Get",idCallingForm.get(),m$.Fnc.$extract(m$.Fnc.$piece(strRelation.get(),idCallingForm.get(),2),2,9999)));
            //<< if $$$WWW122InputType(objWWW122)=10 {                              ; FileName
            if (mOp.Equal(include.WWWConst.$$$WWW122InputType(m$,objWWW122),10)) {
              //<< set retVal = $get(^CacheTempView(YUSER,"AppendValue"))_retVal
              retVal.set(mOp.Concat(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"AppendValue")),retVal.get()));
            }
          }
          //<< }
          //<< }
          //<< write "top.window.returnValue='"_$zconvert(retVal,"o","JS")_"';"  ;SR17583
          m$.Cmd.Write(mOp.Concat(mOp.Concat("top.window.returnValue='",m$.Fnc.$zconvert(retVal.get(),"o","JS")),"';"));
        }
        //<< 
        //<< } else {
        else {
          //<< if ($extract(strRelation,1)="S")||($extract(strRelation,1)="J") {
          if ((mOp.Equal(m$.Fnc.$extract(strRelation.get(),1),"S")) || (mOp.Equal(m$.Fnc.$extract(strRelation.get(),1),"J"))) {
            //<< write "window.opener.CallBack('CallBack^COMViewCustom','"_$zconvert(pidKey,"o","JS")_"');"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("window.opener.CallBack('CallBack^COMViewCustom','",m$.Fnc.$zconvert(pidKey.get(),"o","JS")),"');"));
          }
          //<< 
          //<< } else {
          else {
            //<< do RedirectForm(idForm,pidKey,YFORM_",")   // This code never appears to be run...
            m$.Cmd.Do("RedirectForm",idForm.get(),pidKey.get(),mOp.Concat(m$.var("YFORM").get(),","));
          }
        }
      }
      //<< }
      //<< }
      //<< } elseif (idForm'="")&&(pidKey'="") {
      else if ((mOp.NotEqual(idForm.get(),"")) && (mOp.NotEqual(pidKey.get(),""))) {
        //<< do RedirectForm(idForm,pidKey,YBACK,,pblnBackToSearch) ;SR17580
        m$.Cmd.Do("RedirectForm",idForm.get(),pidKey.get(),YBACK.get(),null,pblnBackToSearch.get());
      }
      //<< }
      //<< if $extract(strRelation,1)="Y" {
      if (mOp.Equal(m$.Fnc.$extract(strRelation.get(),1),"Y")) {
        //<< write "top.window.close();"     ; SR17583
        m$.Cmd.Write("top.window.close();");
      }
    }
    //<< }
    //<< }
    //<< quit 1
    return 1;
  }

  //<< 
  //<< 
  //<< RedirectForm(pidForm,pidKey,YBACK,pblnWrite=$$$YES,pblnBackToSearch=$$$NO)
  public Object RedirectForm(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YBACK = m$.newVarRef("YBACK",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnWrite = m$.newVarRef("pblnWrite",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$YES(m$));
    mVar pblnBackToSearch = m$.newVarRef("pblnBackToSearch",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Nov-2010   shobby      SR17580: additional parameter pblnBackToSearch
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< new strLink
    mVar strLink = m$.var("strLink");
    m$.newVar(strLink);
    //<< 
    //<< set strLink = YAKTION_"EP=WWWFORM"
    strLink.set(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM"));
    //<< set strLink = strLink_"&YFORM="_pidForm
    strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YFORM="),pidForm.get()));
    //<< set strLink = strLink_"&YKEY="_pidKey
    strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YKEY="),pidKey.get()));
    //<< 
    //<< if (pblnBackToSearch) {
    if (mOp.Logical((pblnBackToSearch.get()))) {
      //<< set strLink = strLink_"&YBACK=WWWSEAR,"  ;SR17580
      strLink.set(mOp.Concat(strLink.get(),"&YBACK=WWWSEAR,"));
    }
    //<< } else {
    else {
      //<< set strLink = strLink_"&YBACK="_YBACK
      strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YBACK="),YBACK.get()));
    }
    //<< }
    //<< set strLink = strLink_"&YUCI="_YUCI             ; NAMESPACE
    strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YUCI="),m$.var("YUCI").get()));
    //<< set strLink = strLink_"&YBED="_YBED             ; User ID
    strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YBED="),m$.var("YBED").get()));
    //<< set strLink = strLink_"&YM="_YM                 ; Company (0)
    strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YM="),m$.var("YM").get()));
    //<< set strLink = strLink_"&YUSER="_YUSER           ; Session No
    strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YUSER="),m$.var("YUSER").get()));
    //<< set strLink = "document.location='"_strLink_"';"
    strLink.set(mOp.Concat(mOp.Concat("document.location='",strLink.get()),"';"));
    //<< 
    //<< if pblnWrite write strLink
    if (mOp.Logical(pblnWrite.get())) {
      m$.Cmd.Write(strLink.get());
    }
    //<< quit strLink
    return strLink.get();
  }

  //<< 
  //<< 
  //<< GetGroupedProperties()
  public Object GetGroupedProperties(Object ... _p) {
    //<< new strFilterTypes,FilterLoop,strFilterType,idFilter,objFilter,strGroupedProps
    mVar strFilterTypes = m$.var("strFilterTypes");
    mVar FilterLoop = m$.var("FilterLoop");
    mVar strFilterType = m$.var("strFilterType");
    mVar idFilter = m$.var("idFilter");
    mVar objFilter = m$.var("objFilter");
    mVar strGroupedProps = m$.var("strGroupedProps");
    m$.newVar(strFilterTypes,FilterLoop,strFilterType,idFilter,objFilter,strGroupedProps);
    //<< 
    //<< set strGroupedProps = ""
    strGroupedProps.set("");
    //<< set strFilterTypes = "FixedFilter,Filter"
    strFilterTypes.set("FixedFilter,Filter");
    //<< 
    //<< for FilterLoop=1:1:$length(strFilterTypes,",") {
    for (FilterLoop.set(1);(mOp.LessOrEqual(FilterLoop.get(),m$.Fnc.$length(strFilterTypes.get(),",")));FilterLoop.set(mOp.Add(FilterLoop.get(),1))) {
      //<< set strFilterType = $piece(strFilterTypes,",",FilterLoop)
      strFilterType.set(m$.Fnc.$piece(strFilterTypes.get(),",",FilterLoop.get()));
      //<< set idFilter = ""
      idFilter.set("");
      //<< for {
      for (;true;) {
        //<< set idFilter = $order(^CacheTempView(YUSER,strFilterType,idFilter))
        idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),strFilterType.get(),idFilter.get())));
        //<< quit:idFilter=""
        if (mOp.Equal(idFilter.get(),"")) {
          break;
        }
        //<< 
        //<< set objFilter = $get(^CacheTempView(YUSER,strFilterType,idFilter))
        objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),strFilterType.get(),idFilter.get())));
        //<< if $$$COMViewFilterGroupBy(objFilter) {
        if (mOp.Logical(include.COMConst.$$$COMViewFilterGroupBy(m$,objFilter))) {
          //<< if strGroupedProps'="" set strGroupedProps = strGroupedProps_","
          if (mOp.NotEqual(strGroupedProps.get(),"")) {
            strGroupedProps.set(mOp.Concat(strGroupedProps.get(),","));
          }
          //<< set strGroupedProps = strGroupedProps_$$$COMViewFilterField(objFilter)
          strGroupedProps.set(mOp.Concat(strGroupedProps.get(),include.COMConst.$$$COMViewFilterField(m$,objFilter)));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strGroupedProps
    return strGroupedProps.get();
  }

  //<< 
  //<< 
  //<< GetRelationForm(pidRelation="",pidClass,pidKey)
  public Object GetRelationForm(Object ... _p) {
    mVar pidRelation = m$.newVarRef("pidRelation",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Sets relations for a particular field and key.
    //<< ;
    //<< ; For manual field filtering, set the global ^CacheTempFixedField
    //<< ;
    //<< ; Returns:ID (WWW120)
    //<< ;
    //<< ; History:
    //<< ; 21-Apr-2011   GRF     -: Get strSortCodes once
    //<< ; 13-Dec-2007   shobby  SRBR014790: Use the form that corresponds to the class
    //<< ;                           name if available.
    //<< ; 19-Sep-2005   JW      SR13525: Define vars properly.
    //<< ; 10-Jun-2005   PK / PO SR12523: Include support for new WWW0022/WWW0032 filters
    //<< ; 14-Apr-2005   PO      Mod'd to use new GetFieldDetails procedure
    //<< ; 22-Dec-2004   Paul K  Added merge
    //<< ; 02-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idForm,idClass,idField,Loop,char,objField,strSortCodes,intIndex,objFilter
    mVar idForm = m$.var("idForm");
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar Loop = m$.var("Loop");
    mVar _char = m$.var("_char");
    mVar objField = m$.var("objField");
    mVar strSortCodes = m$.var("strSortCodes");
    mVar intIndex = m$.var("intIndex");
    mVar objFilter = m$.var("objFilter");
    m$.newVar(idForm,idClass,idField,Loop,_char,objField,strSortCodes,intIndex,objFilter);
    //<< new idFilter,strRelation,strFieldType,intLoop,idRelFilter,objWWW0022,objWWW0032,idClassField
    mVar idFilter = m$.var("idFilter");
    mVar strRelation = m$.var("strRelation");
    mVar strFieldType = m$.var("strFieldType");
    mVar intLoop = m$.var("intLoop");
    mVar idRelFilter = m$.var("idRelFilter");
    mVar objWWW0022 = m$.var("objWWW0022");
    mVar objWWW0032 = m$.var("objWWW0032");
    mVar idClassField = m$.var("idClassField");
    m$.newVar(idFilter,strRelation,strFieldType,intLoop,idRelFilter,objWWW0022,objWWW0032,idClassField);
    //<< 
    //<< set ^CacheTempView(YUSER,"Relation") = pidRelation
    m$.var("^CacheTempView",m$.var("YUSER").get(),"Relation").set(pidRelation.get());
    //<< 
    //<< if (pidRelation'="") {
    if ((mOp.NotEqual(pidRelation.get(),""))) {
      //<< merge ^CacheTempView(YUSER,"FixedFilter") = ^CacheTempFixedField(YUSER,pidRelation,"Filter")
      m$.Cmd.Merge(m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter"),m$.var("^CacheTempFixedField",m$.var("YUSER").get(),pidRelation.get(),"Filter"));
      //<< merge ^CacheTempView(YUSER,"Command")     = ^CacheTempFixedField(YUSER,"Command")
      m$.Cmd.Merge(m$.var("^CacheTempView",m$.var("YUSER").get(),"Command"),m$.var("^CacheTempFixedField",m$.var("YUSER").get(),"Command"));
      //<< set ^CacheTempView(YUSER,"CallBack")      = $get(^CacheTempFixedField(YUSER,pidRelation,"CallBack"))
      m$.var("^CacheTempView",m$.var("YUSER").get(),"CallBack").set(m$.Fnc.$get(m$.var("^CacheTempFixedField",m$.var("YUSER").get(),pidRelation.get(),"CallBack")));
      //<< set ^CacheTempView(YUSER,"ReturnValue")   = $get(^CacheTempFixedField(YUSER,"ReturnValue"))
      m$.var("^CacheTempView",m$.var("YUSER").get(),"ReturnValue").set(m$.Fnc.$get(m$.var("^CacheTempFixedField",m$.var("YUSER").get(),"ReturnValue")));
    }
    //<< }
    //<< kill ^CacheTempFixedField(YUSER)
    m$.var("^CacheTempFixedField",m$.var("YUSER").get()).kill();
    //<< 
    //<< do GetFieldDetails^COMUtilForm(pidRelation,.idForm,.strFieldType,.idField)
    m$.Cmd.Do("COMUtilForm.GetFieldDetails",pidRelation.get(),idForm,strFieldType,idField);
    //<< set idField = strFieldType_idField
    idField.set(mOp.Concat(strFieldType.get(),idField.get()));
    //<< 
    //<< if (idForm'="") && ($data(^WWW120(0,idForm))) {
    if ((mOp.NotEqual(idForm.get(),"")) && mOp.Logical((m$.Fnc.$data(m$.var("^WWW120",0,idForm.get()))))) {
      //<< if idField'="D0" {  ;special case.
      if (mOp.NotEqual(idField.get(),"D0")) {
        //<< set idClass  = $$$WWW120ClassUsedInForm($get(^WWW120(0,idForm,1)))
        idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,idForm.get(),1))));
        //<< set objField = $$GetRelation^COMViewUtils(idClass,idField,idForm)
        objField.set(m$.fnc$("COMViewUtils.GetRelation",idClass.get(),idField.get(),idForm.get()));
        //<< set pidClass = $$$WWW002RelationClass(objField)
        pidClass.set(include.WWWConst.$$$WWW002RelationClass(m$,objField));
        //<< 
        //<< set strSortCodes = $$$WWW003DisplayIfSortKeyEqual(objField)    ; Index#,$$$Index(Value)
        strSortCodes.set(include.WWWConst.$$$WWW003DisplayIfSortKeyEqual(m$,objField));
        //<< if strSortCodes'="" {
        if (mOp.NotEqual(strSortCodes.get(),"")) {
          //<< set intIndex     = $piece(strSortCodes,",",1)
          intIndex.set(m$.Fnc.$piece(strSortCodes.get(),",",1));
          //<< set strSortCodes = $piece(strSortCodes,",",2,$length(strSortCodes,","))
          strSortCodes.set(m$.Fnc.$piece(strSortCodes.get(),",",2,m$.Fnc.$length(strSortCodes.get(),",")));
          //<< if strSortCodes'="" {
          if (mOp.NotEqual(strSortCodes.get(),"")) {
            //<< for Loop=1:1:$length(strSortCodes,",") {
            for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(strSortCodes.get(),",")));Loop.set(mOp.Add(Loop.get(),1))) {
              //<< set objFilter = ""
              objFilter.set("");
              //<< set $$$COMViewFilterField(objFilter)      = $$GetFieldForIndex(pidClass,intIndex,Loop)
              include.COMConst.$$$COMViewFilterFieldSet(m$,objFilter,m$.fnc$("GetFieldForIndex",pidClass.get(),intIndex.get(),Loop.get()));
              //<< set $$$COMViewFilterValue1(objFilter)     = $piece(strSortCodes,",",Loop)
              include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,m$.Fnc.$piece(strSortCodes.get(),",",Loop.get()));
              //<< set $$$COMViewFilterComparator(objFilter) = $$$EnumCOMVIEWCOMPARATOREquals
              include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$));
              //<< 
              //<< set idFilter = $order(^CacheTempView(YUSER,"FixedFilter",""),-1)+1
              idFilter.set(mOp.Add(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",""),mOp.Negative(1)),1));
              //<< set ^CacheTempView(YUSER,"FixedFilter",idFilter) = objFilter
              m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",idFilter.get()).set(objFilter.get());
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< if (idClass'="") && ($extract(idField)="D") {
        if ((mOp.NotEqual(idClass.get(),"")) && (mOp.Equal(m$.Fnc.$extract(idField.get()),"D"))) {
          //<< set idClassField = $extract(idField,2,99)
          idClassField.set(m$.Fnc.$extract(idField.get(),2,99));
          //<< set idRelFilter  = ""
          idRelFilter.set("");
          //<< for {
          for (;true;) {
            //<< set idRelFilter = $order(^WWW0032(0,idClass,idClassField,idRelFilter))
            idRelFilter.set(m$.Fnc.$order(m$.var("^WWW0032",0,idClass.get(),idClassField.get(),idRelFilter.get())));
            //<< quit:idRelFilter=""
            if (mOp.Equal(idRelFilter.get(),"")) {
              break;
            }
            //<< 
            //<< set objWWW0032 = $get(^WWW0032(0,idClass,idClassField,idRelFilter,1))
            objWWW0032.set(m$.Fnc.$get(m$.var("^WWW0032",0,idClass.get(),idClassField.get(),idRelFilter.get(),1)));
            //<< set objFilter  = ""
            objFilter.set("");
            //<< set $$$COMViewFilterField(objFilter)      = "D"_$$$WWW0032Field(objWWW0032)
            include.COMConst.$$$COMViewFilterFieldSet(m$,objFilter,mOp.Concat("D",include.WWWConst.$$$WWW0032Field(m$,objWWW0032)));
            //<< set $$$COMViewFilterValue1(objFilter)     = $$$WWW0032Value1(objWWW0032)
            include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,include.WWWConst.$$$WWW0032Value1(m$,objWWW0032));
            //<< set $$$COMViewFilterComparator(objFilter) = $$$WWW0032Comparator(objWWW0032)
            include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,include.WWWConst.$$$WWW0032Comparator(m$,objWWW0032));
            //<< 
            //<< set idFilter = $order(^CacheTempView(YUSER,"FixedFilter",""),-1)+1
            idFilter.set(mOp.Add(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",""),mOp.Negative(1)),1));
            //<< set ^CacheTempView(YUSER,"FixedFilter",idFilter) = objFilter
            m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",idFilter.get()).set(objFilter.get());
          }
        }
        //<< }
        //<< }
        //<< if (idClass'="") && ($extract(idField)="P") {
        if ((mOp.NotEqual(idClass.get(),"")) && (mOp.Equal(m$.Fnc.$extract(idField.get()),"P"))) {
          //<< set idClassField = $extract(idField,2,99)
          idClassField.set(m$.Fnc.$extract(idField.get(),2,99));
          //<< set idRelFilter  = ""
          idRelFilter.set("");
          //<< for {
          for (;true;) {
            //<< set idRelFilter = $order(^WWW0022(0,idClass,idClassField,idRelFilter))
            idRelFilter.set(m$.Fnc.$order(m$.var("^WWW0022",0,idClass.get(),idClassField.get(),idRelFilter.get())));
            //<< quit:idRelFilter=""
            if (mOp.Equal(idRelFilter.get(),"")) {
              break;
            }
            //<< 
            //<< set objWWW0022 = $get(^WWW0022(0,idClass,idClassField,idRelFilter,1))
            objWWW0022.set(m$.Fnc.$get(m$.var("^WWW0022",0,idClass.get(),idClassField.get(),idRelFilter.get(),1)));
            //<< set objFilter  = ""
            objFilter.set("");
            //<< set $$$COMViewFilterField(objFilter)      = "D"_$$$WWW0022Field(objWWW0022)
            include.COMConst.$$$COMViewFilterFieldSet(m$,objFilter,mOp.Concat("D",include.WWWConst.$$$WWW0022Field(m$,objWWW0022)));
            //<< set $$$COMViewFilterValue1(objFilter)     = $$$WWW0022Value1(objWWW0022)
            include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,include.WWWConst.$$$WWW0022Value1(m$,objWWW0022));
            //<< set $$$COMViewFilterComparator(objFilter) = $$$WWW0022Comparator(objWWW0022)
            include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,include.WWWConst.$$$WWW0022Comparator(m$,objWWW0022));
            //<< 
            //<< set idFilter = $order(^CacheTempView(YUSER,"FixedFilter",""),-1)+1
            idFilter.set(mOp.Add(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",""),mOp.Negative(1)),1));
            //<< set ^CacheTempView(YUSER,"FixedFilter",idFilter) = objFilter
            m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",idFilter.get()).set(objFilter.get());
          }
        }
        //<< }
        //<< }
        //<< if $$$WWW002RelationalPrimaryKeys(objField)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,objField),"")) {
          //<< for Loop=1:1:$length($$$WWW002RelationalPrimaryKeys(objField),",") {
          for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,objField),",")));Loop.set(mOp.Add(Loop.get(),1))) {
            //<< set strRelation = $piece($$$WWW002RelationalPrimaryKeys(objField),",",Loop)
            strRelation.set(m$.Fnc.$piece(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,objField),",",Loop.get()));
            //<< 
            //<< if (+strRelation'=strRelation) && '$find(strRelation,"""") {
            if ((mOp.NotEqual(mOp.Positive(strRelation.get()),strRelation.get())) && mOp.Not(m$.Fnc.$find(strRelation.get(),"\""))) {
              //<< // SR13525  Add this "correct" function in
              //<< do DefineKeys^WWWFieldValidation(idForm,strRelation)
              m$.Cmd.Do("WWWFieldValidation.DefineKeys",idForm.get(),strRelation.get());
              //<< if '$data(@strRelation) {
              if (mOp.Not(m$.Fnc.$data(m$.indirectVar(strRelation.get())))) {
                //<< do FindRelation^COMViewUtils(idClass,strRelation,$get(^CacheTempView(YUSER,"RelationKey")))
                m$.Cmd.Do("COMViewUtils.FindRelation",idClass.get(),strRelation.get(),m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"RelationKey")));
              }
              //<< }
              //<< 
              //<< set strRelation = $get(@strRelation)
              strRelation.set(m$.Fnc.$get(m$.indirectVar(strRelation.get())));
            }
            //<< 
            //<< } else {
            else {
              //<< set strRelation = $translate(strRelation,"""")
              strRelation.set(m$.Fnc.$translate(strRelation.get(),"\""));
            }
            //<< }
            //<< set objFilter = ""
            objFilter.set("");
            //<< set $$$COMViewFilterField(objFilter)      = "P"_Loop
            include.COMConst.$$$COMViewFilterFieldSet(m$,objFilter,mOp.Concat("P",Loop.get()));
            //<< set $$$COMViewFilterValue1(objFilter)     = strRelation
            include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,strRelation.get());
            //<< set $$$COMViewFilterComparator(objFilter) = $$$EnumCOMVIEWCOMPARATOREquals
            include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$));
            //<< 
            //<< set idFilter = $order(^CacheTempView(YUSER,"FixedFilter",""),-1)+1
            idFilter.set(mOp.Add(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",""),mOp.Negative(1)),1));
            //<< set ^CacheTempView(YUSER,"FixedFilter",idFilter) = objFilter
            m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",idFilter.get()).set(objFilter.get());
          }
        }
        //<< }
        //<< }
        //<< if (pidClass'="") && $data(^WWW120(0,pidClass)) {
        if ((mOp.NotEqual(pidClass.get(),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^WWW120",0,pidClass.get())))) {
          //<< set idForm = pidClass  ; Use the form that corresponds to the class name if available.
          idForm.set(pidClass.get());
        }
        //<< } else {
        else {
          //<< set idForm = $order(^WWW120s(0,1,$$$Index(pidClass),""))
          idForm.set(m$.Fnc.$order(m$.var("^WWW120s",0,1,include.MEDConst.$$$Index(m$,pidClass),"")));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit idForm
    return idForm.get();
  }

  //<< 
  //<< 
  //<< GetFieldForIndex(pidClass,pintIndex,pstrPart)
  public Object GetFieldForIndex(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintIndex = m$.newVarRef("pintIndex",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrPart = m$.newVarRef("pstrPart",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Look through the key and field definitions for the right key
    //<< ;
    //<< ; Returns:Field (D1 or P3 etc...)
    //<< ;
    //<< ; History:
    //<< ; 03-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idKey,objKey,intIndex,Loop
    mVar idField = m$.var("idField");
    mVar idKey = m$.var("idKey");
    mVar objKey = m$.var("objKey");
    mVar intIndex = m$.var("intIndex");
    mVar Loop = m$.var("Loop");
    m$.newVar(idField,idKey,objKey,intIndex,Loop);
    //<< 
    //<< set idField = ""
    idField.set("");
    //<< if pidClass'="" {
    if (mOp.NotEqual(pidClass.get(),"")) {
      //<< set idKey = ""
      idKey.set("");
      //<< for {
      for (;true;) {
        //<< set idKey = $order(^WWW002(0,pidClass,idKey))
        idKey.set(m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),idKey.get())));
        //<< quit:idKey=""
        if (mOp.Equal(idKey.get(),"")) {
          break;
        }
        //<< 
        //<< set objKey   = $get(^WWW002(0,pidClass,idKey,1))
        objKey.set(m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),idKey.get(),1)));
        //<< set intIndex = $$$WWW002IndexKey(objKey)
        intIndex.set(include.WWWConst.$$$WWW002IndexKey(m$,objKey));
        //<< if intIndex'="" {
        if (mOp.NotEqual(intIndex.get(),"")) {
          //<< for Loop=1:1:$length(intIndex) {
          for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(intIndex.get())));Loop.set(mOp.Add(Loop.get(),1))) {
            //<< if pstrPart=1 if $piece(intIndex,",",Loop)=pintIndex  set idField = "P"_idKey
            if (mOp.Equal(pstrPart.get(),1)) {
              if (mOp.Equal(m$.Fnc.$piece(intIndex.get(),",",Loop.get()),pintIndex.get())) {
                idField.set(mOp.Concat("P",idKey.get()));
              }
            }
            //<< if $piece(intIndex,",",Loop)=(pintIndex_"."_pstrPart) set idField = "P"_idKey
            if (mOp.Equal(m$.Fnc.$piece(intIndex.get(),",",Loop.get()),(mOp.Concat(mOp.Concat(pintIndex.get(),"."),pstrPart.get())))) {
              idField.set(mOp.Concat("P",idKey.get()));
            }
            //<< quit:idField'=""
            if (mOp.NotEqual(idField.get(),"")) {
              break;
            }
          }
        }
        //<< }
        //<< }
        //<< quit:idField'=""
        if (mOp.NotEqual(idField.get(),"")) {
          break;
        }
      }
      //<< }
      //<< if idField="" {
      if (mOp.Equal(idField.get(),"")) {
        //<< set idKey = ""
        idKey.set("");
        //<< for {
        for (;true;) {
          //<< set idKey = $order(^WWW003(0,pidClass,idKey))
          idKey.set(m$.Fnc.$order(m$.var("^WWW003",0,pidClass.get(),idKey.get())));
          //<< quit:idKey=""
          if (mOp.Equal(idKey.get(),"")) {
            break;
          }
          //<< 
          //<< set objKey   = $get(^WWW003(0,pidClass,idKey,1))
          objKey.set(m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),idKey.get(),1)));
          //<< set intIndex = $$$WWW003IndexKey(objKey)
          intIndex.set(include.WWWConst.$$$WWW003IndexKey(m$,objKey));
          //<< if intIndex'="" {
          if (mOp.NotEqual(intIndex.get(),"")) {
            //<< for Loop=1:1:$length(intIndex) {
            for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(intIndex.get())));Loop.set(mOp.Add(Loop.get(),1))) {
              //<< if pstrPart=1 if $piece(intIndex,",",Loop)=pintIndex  set idField = "D"_idKey
              if (mOp.Equal(pstrPart.get(),1)) {
                if (mOp.Equal(m$.Fnc.$piece(intIndex.get(),",",Loop.get()),pintIndex.get())) {
                  idField.set(mOp.Concat("D",idKey.get()));
                }
              }
              //<< if $piece(intIndex,",",Loop)=(pintIndex_"."_pstrPart) set idField = "D"_idKey
              if (mOp.Equal(m$.Fnc.$piece(intIndex.get(),",",Loop.get()),(mOp.Concat(mOp.Concat(pintIndex.get(),"."),pstrPart.get())))) {
                idField.set(mOp.Concat("D",idKey.get()));
              }
              //<< quit:idField'=""
              if (mOp.NotEqual(idField.get(),"")) {
                break;
              }
            }
          }
          //<< }
          //<< }
          //<< quit:idField'=""
          if (mOp.NotEqual(idField.get(),"")) {
            break;
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit idField
    return idField.get();
  }

  //<< 
  //<< 
  //<< SetKeyFields(pidClass,pidKey)
  public Object SetKeyFields(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If we are on a "Sub form" add fixed filters of "header" primary keys.
    //<< ;
    //<< ; History:
    //<< ; 15-Mar-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new intNumKeys,idFilter,objFilter,loop
    mVar intNumKeys = m$.var("intNumKeys");
    mVar idFilter = m$.var("idFilter");
    mVar objFilter = m$.var("objFilter");
    mVar loop = m$.var("loop");
    m$.newVar(intNumKeys,idFilter,objFilter,loop);
    //<< 
    //<< set intNumKeys = $order(^WWW002(0,pidClass,""),-1)
    intNumKeys.set(m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),""),mOp.Negative(1)));
    //<< set ^CacheTempView(YUSER,"RelationKey") = pidKey
    m$.var("^CacheTempView",m$.var("YUSER").get(),"RelationKey").set(pidKey.get());
    //<< 
    //<< for loop=1:1:(intNumKeys-1) {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),(mOp.Subtract(intNumKeys.get(),1))));loop.set(mOp.Add(loop.get(),1))) {
      //<< if $piece(pidKey,",",loop)'="" {
      if (mOp.NotEqual(m$.Fnc.$piece(pidKey.get(),",",loop.get()),"")) {
        //<< set objFilter=""
        objFilter.set("");
        //<< set $$$COMViewFilterField(objFilter)      = "P"_loop
        include.COMConst.$$$COMViewFilterFieldSet(m$,objFilter,mOp.Concat("P",loop.get()));
        //<< set $$$COMViewFilterValue1(objFilter)     = $piece(pidKey,",",loop)
        include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,m$.Fnc.$piece(pidKey.get(),",",loop.get()));
        //<< set $$$COMViewFilterComparator(objFilter) = $$$EnumCOMVIEWCOMPARATOREquals
        include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$));
        //<< 
        //<< set idFilter = $order(^CacheTempView(YUSER,"FixedFilter",""),-1)+1
        idFilter.set(mOp.Add(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",""),mOp.Negative(1)),1));
        //<< set ^CacheTempView(YUSER,"FixedFilter",idFilter) = objFilter
        m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",idFilter.get()).set(objFilter.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetLangRelation(pidForm,pidRelClass,pidFieldType,pidFieldNo)
  public Object SetLangRelation(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidRelClass = m$.newVarRef("pidRelClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidFieldType = m$.newVarRef("pidFieldType",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidFieldNo = m$.newVarRef("pidFieldNo",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check for language translation
    //<< ;
    //<< ; Params:   pidRelClass     - class to check for translation
    //<< ;           pidForm         - calling form
    //<< ;           pidFieldType    - calling field type
    //<< ;           pidFieldNo      - calling field num
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Dec-2006   JW      SR15299: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLangClass,idClass,objWWW003,idField
    mVar idLangClass = m$.var("idLangClass");
    mVar idClass = m$.var("idClass");
    mVar objWWW003 = m$.var("objWWW003");
    mVar idField = m$.var("idField");
    m$.newVar(idLangClass,idClass,objWWW003,idField);
    //<< 
    //<< set idLangClass = $$$WWW001LanguageClassForRelations($get(^WWW001(0,pidRelClass,1)))
    idLangClass.set(include.WWWConst.$$$WWW001LanguageClassForRelations(m$,m$.Fnc.$get(m$.var("^WWW001",0,pidRelClass.get(),1))));
    //<< 
    //<< if idLangClass'="" {
    if (mOp.NotEqual(idLangClass.get(),"")) {
      //<< set idClass=$$$WWW120ClassUsedInForm($get(^WWW120(0,pidForm,1)))
      idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1))));
      //<< set objWWW003=$$GetRelation^COMViewUtils(idClass,pidFieldType_pidFieldNo)
      objWWW003.set(m$.fnc$("COMViewUtils.GetRelation",idClass.get(),mOp.Concat(pidFieldType.get(),pidFieldNo.get())));
      //<< 
      //<< set idField = +$$$WWW003RelationalDisplayItems(objWWW003)  // just get first one
      idField.set(mOp.Positive(include.WWWConst.$$$WWW003RelationalDisplayItems(m$,objWWW003)));
      //<< if idField=0 set idField = 1        // default
      if (mOp.Equal(idField.get(),0)) {
        idField.set(1);
      }
      //<< 
      //<< set ^CacheTempView(YUSER,"RelField") = 1
      m$.var("^CacheTempView",m$.var("YUSER").get(),"RelField").set(1);
      //<< set ^CacheTempView(YUSER,"RelLang")  = idLangClass
      m$.var("^CacheTempView",m$.var("YUSER").get(),"RelLang").set(idLangClass.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnChangeData()
  public Object OnChangeData(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Link the COMView data into the COMGridEdit
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 01-Dec-2009   GRF     SR17007: separate tags for multi-lock operations
    //<< ; 06-Mar-2007   PO      SR15466: Support case where header and lines do not relate
    //<< ; 09-Feb-2007   RPW     SR15426: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idContainerKey,idKey,idParentKey,idRootKey,idUser,intLength
    mVar idContainerKey = m$.var("idContainerKey");
    mVar idKey = m$.var("idKey");
    mVar idParentKey = m$.var("idParentKey");
    mVar idRootKey = m$.var("idRootKey");
    mVar idUser = m$.var("idUser");
    mVar intLength = m$.var("intLength");
    m$.newVar(idContainerKey,idKey,idParentKey,idRootKey,idUser,intLength);
    //<< new objData,strData,strForm,strOldStatus,strQuery,strSQLID,strStatus,YFORM
    mVar objData = m$.var("objData");
    mVar strData = m$.var("strData");
    mVar strForm = m$.var("strForm");
    mVar strOldStatus = m$.var("strOldStatus");
    mVar strQuery = m$.var("strQuery");
    mVar strSQLID = m$.var("strSQLID");
    mVar strStatus = m$.var("strStatus");
    mVar YFORM = m$.var("YFORM");
    m$.newVar(objData,strData,strForm,strOldStatus,strQuery,strSQLID,strStatus,YFORM);
    //<< 
    //<< set strForm = $get(^CacheTempView(YUSER,YUCI,"ParentForm"))
    strForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"ParentForm")));
    //<< set YFORM   = $get(^CacheTempView(YUSER,"Form"))
    YFORM.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Form")));
    //<< 
    //<< set idUser  = YUSER
    idUser.set(m$.var("YUSER").get());
    //<< new YUSER
    mVar YUSER = m$.var("YUSER");
    m$.newVar(YUSER);
    //<< set YUSER   = $$$GetParentUser(idUser)
    YUSER.set(include.COMSYSWWW.$$$GetParentUser(m$,idUser));
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< set idContainerKey = $$$GRIDYKEYContainer
    idContainerKey.set(include.COMGridEdit31Interface.$$$GRIDYKEYContainer(m$));
    //<< 
    //<< // Nasty trick here, get the current parent's keys, kill the grid and reset this. Is needed by AddLine and Batch Stop.
    //<< 
    //<< set idParentKey = $get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","REFERENCEKEY"))
    idParentKey.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),YFORM.get(),"V","REFERENCEKEY")));
    //<< do CleanUpPreviousInstance^COMGridEdit31Tools(YFORM,$$$YES)
    m$.Cmd.Do("COMGridEdit31Tools.CleanUpPreviousInstance",YFORM.get(),include.COMSYS.$$$YES(m$));
    //<< set ^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","REFERENCEKEY") = idParentKey
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),YFORM.get(),"V","REFERENCEKEY").set(idParentKey.get());
    //<< 
    //<< do ClearOld^WWWMultiLock(YUSER)
    m$.Cmd.Do("WWWMultiLock.ClearOld",YUSER.get());
    //<< 
    //<< set intLength = $length(idParentKey,$$$COMMA)
    intLength.set(m$.Fnc.$length(idParentKey.get(),include.COMSYSString.$$$COMMA(m$)));
    //<< 
    //<< $$$GRIDAddBatchStart
    include.COMGridEdit31Interface.$$$GRIDAddBatchStart(m$);
    //<< 
    //<< set strSQLID=YUSER_"-"_strForm
    strSQLID.set(mOp.Concat(mOp.Concat(YUSER.get(),"-"),strForm.get()));
    //<< 
    //<< set strQuery="^CacheTempSQL("""_strSQLID_""",""Data"")"
    strQuery.set(mOp.Concat(mOp.Concat("^CacheTempSQL(\"",strSQLID.get()),"\",\"Data\")"));
    //<< set %3 = $qlength(strQuery)
    m$.var("%3").set(m$.Fnc.$qlength(strQuery));
    //<< set %4 = $name(@strQuery,%3)
    m$.var("%4").set(m$.Fnc.$name(m$.indirectVar(strQuery.get()),m$.var("%3").get()));
    //<< for {
    for (;true;) {
      //<< set strQuery = $query(@strQuery)
      strQuery.set(m$.Fnc.$query(m$.indirectVar(strQuery.get())));
      //<< quit:(strQuery="")
      if ((mOp.Equal(strQuery.get(),""))) {
        break;
      }
      //<< quit:($name(@strQuery,%3)'=%4)
      if ((mOp.NotEqual(m$.Fnc.$name(m$.indirectVar(strQuery.get()),m$.var("%3").get()),m$.var("%4").get()))) {
        break;
      }
      //<< 
      //<< set objData   = @strQuery
      objData.set(m$.indirectVar(strQuery.get()).get());
      //<< set idRootKey = $piece(objData,$$$NULLCHAR,1)
      idRootKey.set(m$.Fnc.$piece(objData.get(),include.COMSYSString.$$$NULLCHAR(m$),1));
      //<< set idKey     = $piece(idRootKey,$$$COMMA,intLength+1,$length(idRootKey,$$$COMMA))
      idKey.set(m$.Fnc.$piece(idRootKey.get(),include.COMSYSString.$$$COMMA(m$),mOp.Add(intLength.get(),1),m$.Fnc.$length(idRootKey.get(),include.COMSYSString.$$$COMMA(m$))));
      //<< set strData   = $piece(objData,$$$NULLCHAR,2)
      strData.set(m$.Fnc.$piece(objData.get(),include.COMSYSString.$$$NULLCHAR(m$),2));
      //<< 
      //<< ;   do GetLock^WWWMultiLock(strForm,YFORM,idRootKey)   ; SR17007
      //<< set strStatus = $$LockSet^WWWMultiLock(strForm,YFORM,idRootKey)
      strStatus.set(m$.fnc$("WWWMultiLock.LockSet",strForm.get(),YFORM.get(),idRootKey.get()));
      //<< if idContainerKey = "" {
      if (mOp.Equal(idContainerKey.get(),"")) {
        //<< set idKey = $piece(@strQuery,$$$NULLCHAR,1)
        idKey.set(m$.Fnc.$piece(m$.indirectVar(strQuery.get()).get(),include.COMSYSString.$$$NULLCHAR(m$),1));
        //<< if '($$$NoKey(idKey) || (idKey = " ")) {
        if (mOp.Not((mOp.Logical(include.COMSYS.$$$NoKey(m$,idKey)) || (mOp.Equal(idKey.get()," "))))) {
          //<< do AddLine^COMGridEdit31Add($get(@strData),idKey,YFORM,,,,$$$YES)
          m$.Cmd.Do("COMGridEdit31Add.AddLine",m$.Fnc.$get(m$.indirectVar(strData.get())),idKey.get(),YFORM.get(),null,null,null,include.COMSYS.$$$YES(m$));
        }
      }
      //<< }
      //<< } else {
      else {
        //<< do AddLine^COMGridEdit31Add($get(@strData),idKey,YFORM)
        m$.Cmd.Do("COMGridEdit31Add.AddLine",m$.Fnc.$get(m$.indirectVar(strData.get())),idKey.get(),YFORM.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set strOldStatus = $get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","STATUS",1))
    strOldStatus.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),YFORM.get(),"V","STATUS",1)));
    //<< 
    //<< set ^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","STATUS",1) = 2
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),YFORM.get(),"V","STATUS",1).set(2);
    //<< $$$GRIDAddBatchStopNoDraw
    include.COMGridEdit31Interface.$$$GRIDAddBatchStopNoDraw(m$);
    //<< set ^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","STATUS",1) = strOldStatus
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),YFORM.get(),"V","STATUS",1).set(strOldStatus.get());
    //<< 
    //<< write $$$GRIDGoToPage(1,$$$GRIDNumPages,"T",0)
    m$.Cmd.Write(include.COMGridEdit31.$$$GRIDGoToPage(m$,1,include.COMGridEdit31.$$$GRIDNumPages(m$),"T",0));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CleanupCOMView(pstrForm)
  public Object CleanupCOMView(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If we have changed forms, then kill the COMView data.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Feb-2007   RPW     SR15426: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if (pstrForm'="COMViewSearch") && (pstrForm'="WWWPARA") && (pstrForm'=$get(^CacheTempView(YUSER,YUCI,"ParentForm"))) {
    if ((mOp.NotEqual(pstrForm.get(),"COMViewSearch")) && (mOp.NotEqual(pstrForm.get(),"WWWPARA")) && (mOp.NotEqual(pstrForm.get(),m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"ParentForm"))))) {
      //<< kill ^CacheTempView(YUSER)
      m$.var("^CacheTempView",m$.var("YUSER").get()).kill();
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AddExternalFilter(pidForm,pstrField,pstrValue,penumComparator,pblnDisplay=$$$ANNO,pstrDataAccess="",pstrStoreValue="")
  public Object AddExternalFilter(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar penumComparator = m$.newVarRef("penumComparator",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnDisplay = m$.newVarRef("pblnDisplay",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$ANNO(m$));
    mVar pstrDataAccess = m$.newVarRef("pstrDataAccess",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    mVar pstrStoreValue = m$.newVarRef("pstrStoreValue",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Store the external filter ready to be used.
    //<< ;
    //<< ; Params:
    //<< ; pidForm           - Form with COMView
    //<< ; pstrField         - Field in result area
    //<< ; pstrValue         - Value
    //<< ; penumComparator   - Comparator
    //<< ; pblnDisplay       - Whether or not to display the filter.  NO is represented by null rather than 0
    //<< ; pstrDataAccess    - Routine call from DataAccess
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Sep-2007   shobby  SRBR014677: If a location is defined store a temporary
    //<< ;                           value to repopulate the control with screen redraw
    //<< ; 31-Jul-2007   Karine  SR15548: Data Access filter
    //<< ; 28-May-2007   RPW     SR15513: Allow the caller to determine if the filter
    //<< ;                       should be shown
    //<< ; 16-Feb-2007   RPW     SR15426: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idFilter,objFilter
    mVar idFilter = m$.var("idFilter");
    mVar objFilter = m$.var("objFilter");
    m$.newVar(idFilter,objFilter);
    //<< 
    //<< if 'pblnDisplay set pblnDisplay = $$$ANNO
    if (mOp.Not(pblnDisplay.get())) {
      pblnDisplay.set(include.COMSYS.$$$ANNO(m$));
    }
    //<< 
    //<< set objFilter=""
    objFilter.set("");
    //<< set $$$COMViewFilterField(objFilter)        = pstrField
    include.COMConst.$$$COMViewFilterFieldSet(m$,objFilter,pstrField.get());
    //<< set $$$COMViewFilterValue1(objFilter)       = pstrValue
    include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,pstrValue.get());
    //<< set $$$COMViewFilterComparator(objFilter)   = penumComparator
    include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,penumComparator.get());
    //<< set $$$COMViewFilterDisplay(objFilter)      = pblnDisplay
    include.COMConst.$$$COMViewFilterDisplaySet(m$,objFilter,pblnDisplay.get());
    //<< set $$$COMViewFilterGroupBy(objFilter)      = $$$ANNO
    include.COMConst.$$$COMViewFilterGroupBySet(m$,objFilter,include.COMSYS.$$$ANNO(m$));
    //<< set $$$COMViewFilterNoconversion(objFilter) = $$$ANNO
    include.COMConst.$$$COMViewFilterNoconversionSet(m$,objFilter,include.COMSYS.$$$ANNO(m$));
    //<< set $$$COMViewFilterDataAccess(objFilter)   = pstrDataAccess
    include.COMConst.$$$COMViewFilterDataAccessSet(m$,objFilter,pstrDataAccess.get());
    //<< set $$$COMViewFilterStoreValue(objFilter)   = pstrStoreValue
    include.COMConst.$$$COMViewFilterStoreValueSet(m$,objFilter,pstrStoreValue.get());
    //<< 
    //<< set idFilter = $order(^CacheTempViewExternal(YUSER,YUCI,pidForm,"Filter",""),-1)+1
    idFilter.set(mOp.Add(m$.Fnc.$order(m$.var("^CacheTempViewExternal",m$.var("YUSER").get(),m$.var("YUCI").get(),pidForm.get(),"Filter",""),mOp.Negative(1)),1));
    //<< set ^CacheTempViewExternal(YUSER,YUCI,pidForm,"Filter",idFilter) = objFilter
    m$.var("^CacheTempViewExternal",m$.var("YUSER").get(),m$.var("YUCI").get(),pidForm.get(),"Filter",idFilter.get()).set(objFilter.get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ToggleHeader(pstrType="none",pintHeight)
  public Object ToggleHeader(Object ... _p) {
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"none");
    mVar pintHeight = m$.newVarRef("pintHeight",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; When the header is toggled, store the height of the grid and the view of the COMView
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Mar-2007   RPW     SRBR014416: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strViewForm
    mVar strViewForm = m$.var("strViewForm");
    m$.newVar(strViewForm);
    //<< 
    //<< set strViewForm = $$GetForm()
    strViewForm.set(m$.fnc$("GetForm"));
    //<< set ^CacheTempToggleView(YUSER,YUCI,strViewForm,"Type")   = pstrType
    m$.var("^CacheTempToggleView",m$.var("YUSER").get(),m$.var("YUCI").get(),strViewForm.get(),"Type").set(pstrType.get());
    //<< set ^CacheTempToggleView(YUSER,YUCI,strViewForm,"Height") = pintHeight
    m$.var("^CacheTempToggleView",m$.var("YUSER").get(),m$.var("YUCI").get(),strViewForm.get(),"Height").set(pintHeight.get());
    //<< 
    //<< quit ""
    return "";
  }

  //<< 
  //<< 
  //<< GetForm()
  public Object GetForm(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the correct form. Defaults to ParentForm; if this is blank, use the Form.
    //<< ;
    //<< ; Called By: AfterDataFields^COMViewFilter, ToggleHeader^COMViewFilter
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Sep-2010   PPP     SR17531:If no Form get the CallingForm
    //<< ; 29-Mar-2007   RPW     SRBR014416: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strParent
    mVar strParent = m$.var("strParent");
    m$.newVar(strParent);
    //<< 
    //<< set strParent = $get(^CacheTempView(YUSER,YUCI,"ParentForm"))
    strParent.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"ParentForm")));
    //<< if strParent="" {
    if (mOp.Equal(strParent.get(),"")) {
      //<< set strParent = $get(^CacheTempView(YUSER,"Form"))
      strParent.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Form")));
      //<< if strParent="" {
      if (mOp.Equal(strParent.get(),"")) {
        //<< set strParent = $get(^CacheTempView(YUSER,"CallingForm"))
        strParent.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallingForm")));
      }
    }
    //<< }
    //<< }
    //<< quit strParent
    return strParent.get();
  }

//<< 
//<< 
}
