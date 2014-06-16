//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewFilterControl
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-13 20:48:02
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; Builds and maintains the filter control for COMView.
//<< ;-------------------------------------------------------------------------------
//<< #include COMConst
import include.COMConst;
import include.COMSYS;
//<< #include WWWConst
import include.WWWConst;
//<< #include COMView
import include.COMView;
//<< #include %occInclude
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;

//<< COMViewFilterControl
public class COMViewFilterControl extends mClass {

  //<< 
  //<< #define FirstFilter(%1) ($order(^CacheTempView(YUSER,"Filter",%1),-1)="")
  public static Object $$$FirstFilter(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",p$1.get()),mOp.Negative(1)),"")));
  }

  public void main() {
    _COMViewFilterControl();
  }

  public void _COMViewFilterControl() {
  }

  //<< 
  //<< SetupControls(pidClass)
  public Object SetupControls(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create comparator select object
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Nov-2007   GRF     Doco
    //<< ; 15-Jul-2005   shobby  SR12754: LANGUAGE var changed to SPRACHE (not always reliable)
    //<< ;-------------------------------------------------------------------------------
    //<< new idComp,strComp
    mVar idComp = m$.var("idComp");
    mVar strComp = m$.var("strComp");
    m$.newVar(idComp,strComp);
    //<< 
    //<< set idComp  = ""
    idComp.set("");
    //<< set strComp = ""
    strComp.set("");
    //<< for {
    for (;true;) {
      //<< set idComp = $order(^WWW101(0,"COMVIEWCOMPARATOR",SPRACHE,idComp))
      idComp.set(m$.Fnc.$order(m$.var("^WWW101",0,"COMVIEWCOMPARATOR",m$.var("SPRACHE").get(),idComp.get())));
      //<< quit:(idComp="")
      if ((mOp.Equal(idComp.get(),""))) {
        break;
      }
      //<< 
      //<< if (strComp'="") set strComp = strComp_","
      if ((mOp.NotEqual(strComp.get(),""))) {
        strComp.set(mOp.Concat(strComp.get(),","));
      }
      //<< set strComp = strComp_"'"_$$$AppEnum("COMVIEWCOMPARATOR",idComp)_"'"
      strComp.set(mOp.Concat(mOp.Concat(mOp.Concat(strComp.get(),"'"),include.COMSYSWWW.$$$AppEnum(m$,"COMVIEWCOMPARATOR",idComp)),"'"));
    }
    //<< }
    //<< 
    //<< if (pidClass'="") {
    if ((mOp.NotEqual(pidClass.get(),""))) {
      //<< &js<
      //<< objDIV.CreateComp = function(SelectObject,pList) {
      //<< var arrOpt=new Array(#(strComp)#);
      //<< var arrList=pList.split(',');
      //<< while (arrList.length!=0) {
      //<< var o = document.createElement('option');
      //<< var value=arrList.shift();
      //<< o.value=value;
      //<< o.innerHTML=arrOpt[value-1];
      //<< SelectObject.appendChild(o);
      //<< }
      //<< };
      //<< >
      m$.Cmd.WriteJS("","\n");
      m$.Cmd.WriteJS(" objDIV.CreateComp = function(SelectObject,pList) {","\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(" var arrOpt=new Array(",(strComp.get())),");"),"\n");
      m$.Cmd.WriteJS(" var arrList=pList.split(',');","\n");
      m$.Cmd.WriteJS(" while (arrList.length!=0) {","\n");
      m$.Cmd.WriteJS(" var o = document.createElement('option');","\n");
      m$.Cmd.WriteJS(" var value=arrList.shift();","\n");
      m$.Cmd.WriteJS(" o.value=value;","\n");
      m$.Cmd.WriteJS(" o.innerHTML=arrOpt[value-1];","\n");
      m$.Cmd.WriteJS(" SelectObject.appendChild(o);","\n");
      m$.Cmd.WriteJS(" }","\n");
      m$.Cmd.WriteJS(" };");
      //<< do DisplayControls(pidClass)
      m$.Cmd.Do("DisplayControls",pidClass.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DisplayControls(pidClass)
  public Object DisplayControls(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Shows the controls for favourites
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Jan-2008   shobby  SRBR014551: Don't allow adding of selection controls if
    //<< ;                           this favourite is based on direct SQL
    //<< ; 09-Feb-2007   RPW     SR15426: Use correct W3C syntax for getting DOM elements.
    //<< ; 24-Nov-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idFilter,lstFilters,objFilter
    mVar idField = m$.var("idField");
    mVar idFilter = m$.var("idFilter");
    mVar lstFilters = m$.var("lstFilters");
    mVar objFilter = m$.var("objFilter");
    m$.newVar(idField,idFilter,lstFilters,objFilter);
    //<< 
    //<< if pidClass'="" {
    if (mOp.NotEqual(pidClass.get(),"")) {
      //<< write "ClearRows(ctrl);",!
      m$.Cmd.Write("ClearRows(ctrl);","\n");
      //<< 
      //<< if $$GetCurrentSQL^COMView(pidClass)="" {  ;BR014551
      if (mOp.Equal(m$.fnc$("COMView.GetCurrentSQL",pidClass.get()),"")) {
        //<< if $get(^CacheTempView(YUSER,"EditMode")) {
        if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode")))) {
          //<< do CreateFavouriteControl^COMView()
          m$.Cmd.Do("COMView.CreateFavouriteControl");
        }
        //<< } else {
        else {
          //<< write "document.getElementById('hdrctrl').style.display='none';",! // SR15426
          m$.Cmd.Write("document.getElementById('hdrctrl').style.display='none';","\n");
        }
        //<< }
        //<< 
        //<< set idFilter = ""
        idFilter.set("");
        //<< for {
        for (;true;) {
          //<< set idFilter = $order(^CacheTempView(YUSER,"Filter",idFilter))
          idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
          //<< quit:idFilter=""
          if (mOp.Equal(idFilter.get(),"")) {
            break;
          }
          //<< 
          //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",idFilter))
          objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
          //<< set idField   = $$$COMViewFilterField(objFilter)
          idField.set(include.COMConst.$$$COMViewFilterField(m$,objFilter));
          //<< 
          //<< if $get(^CacheTempView(YUSER,"EditMode")) || $$$COMViewFilterDisplay(objFilter) {
          if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode"))) || mOp.Logical(include.COMConst.$$$COMViewFilterDisplay(m$,objFilter))) {
            //<< do CreateControl(pidClass,idFilter)
            m$.Cmd.Do("CreateControl",pidClass.get(),idFilter.get());
          }
        }
        //<< }
        //<< }
        //<< do SetInitialFocus(pidClass)
        m$.Cmd.Do("SetInitialFocus",pidClass.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetInitialFocus(pidClass)
  public Object SetInitialFocus(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 14-Apr-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idView,objView,idFilter,objFilter
    mVar idView = m$.var("idView");
    mVar objView = m$.var("objView");
    mVar idFilter = m$.var("idFilter");
    mVar objFilter = m$.var("objFilter");
    m$.newVar(idView,objView,idFilter,objFilter);
    //<< 
    //<< set idView = $$GetCurrentView^COMView(pidClass)
    idView.set(m$.fnc$("COMView.GetCurrentView",pidClass.get()));
    //<< if idView'="" {
    if (mOp.NotEqual(idView.get(),"")) {
      //<< set objView = $get(^COMView(0,pidClass,idView,1))
      objView.set(m$.Fnc.$get(m$.var("^COMView",0,pidClass.get(),idView.get(),1)));
      //<< 
      //<< set idFilter = ""
      idFilter.set("");
      //<< for {
      for (;true;) {
        //<< set idFilter = $order(^CacheTempView(YUSER,"Filter",idFilter))
        idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
        //<< quit:idFilter=""
        if (mOp.Equal(idFilter.get(),"")) {
          break;
        }
        //<< 
        //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",idFilter))
        objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
        //<< quit:$$$COMViewDefaultProperty(objView)=$$$COMViewFilterField(objFilter)
        if (mOp.Equal(include.COMConst.$$$COMViewDefaultProperty(m$,objView),include.COMConst.$$$COMViewFilterField(m$,objFilter))) {
          break;
        }
      }
      //<< }
      //<< 
      //<< if idFilter="" {
      if (mOp.Equal(idFilter.get(),"")) {
        //<< set idFilter = ""
        idFilter.set("");
        //<< for {
        for (;true;) {
          //<< set idFilter = $order(^CacheTempView(YUSER,"Filter",idFilter),-1)
          idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get()),mOp.Negative(1)));
          //<< quit:idFilter=""
          if (mOp.Equal(idFilter.get(),"")) {
            break;
          }
          //<< 
          //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",idFilter))
          objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
          //<< quit:$get(^CacheTempView(YUSER,"EditMode"))||$$$COMViewFilterDisplay(objFilter)
          if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode"))) || mOp.Logical(include.COMConst.$$$COMViewFilterDisplay(m$,objFilter))) {
            break;
          }
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if idFilter'="" write "FirstFocus='value"_idFilter_"';"
      if (mOp.NotEqual(idFilter.get(),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat("FirstFocus='value",idFilter.get()),"';"));
      }
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateControl(pidClass,pidFilter,blnRefresh=$$$NO)
  public Object CreateControl(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar blnRefresh = m$.newVarRef("blnRefresh",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params: pidClass, pidFilter, blnRefresh
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 17-Sep-2009   shobby  SR16708: Removed useEventBlur logic from 16521
    //<< ; 06-May-2009   PPP     SR16521: Barcode Scanning to identify Item,
    //<< ;                       1. If a Quick Search class CreateText uses OnBlur Event
    //<< ; 07-Apr-2009   PPP     SR16468: Header details - Object Properties to go
    //<< ;                           through language translation before display
    //<< ;                           (WWWClassTranslation)
    //<< ; 09-Sep-2008   PP      SR15866: Update COMView to Objects
    //<< ; 21-Feb-2008   shobby  SRBR014900: GetDescription^COMUtilClass moved to COMViewDescription
    //<< ; 19-Dec-2007   shobby  SRBR014751: Use the form to find relation information.
    //<< ; 24-Sep-2007   Karine  SR15237: Get the right field description from "GetDescription^COMUtilClass"
    //<< ;                           GetDescription^COMUtilClass - handle all possibilities
    //<< ;                           to get the right field name
    //<< ;                           $$^WWWFELDNAME - does not get the right name if there
    //<< ;                           is customized names.
    //<< ; 09-Feb-2007   RPW     SR15426: If this is a In Form COMView, check if the user
    //<< ;                           has the priviliges to remove a filter.
    //<< ;                           Use standard W3C syntax for getting DOM elements
    //<< ; 20-Feb-2006   PO      SR14250: Source security settings from form related to
    //<< ;                           data and not COMViewSearch
    //<< ; 31-Jan-2006   PO      SR14250: Allow filter removal based on priviledge
    //<< ;-------------------------------------------------------------------------------
    //<< new blnAllowFieldRemoval,blnFocussed,blnInForm,blnObj,blnUseEventBlur
    mVar blnAllowFieldRemoval = m$.var("blnAllowFieldRemoval");
    mVar blnFocussed = m$.var("blnFocussed");
    mVar blnInForm = m$.var("blnInForm");
    mVar blnObj = m$.var("blnObj");
    mVar blnUseEventBlur = m$.var("blnUseEventBlur");
    m$.newVar(blnAllowFieldRemoval,blnFocussed,blnInForm,blnObj,blnUseEventBlur);
    //<< new idClass,idField,idForm,idInputType,idRelationClass,idView
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar idForm = m$.var("idForm");
    mVar idInputType = m$.var("idInputType");
    mVar idRelationClass = m$.var("idRelationClass");
    mVar idView = m$.var("idView");
    m$.newVar(idClass,idField,idForm,idInputType,idRelationClass,idView);
    //<< new objFilter,objProperty,objRelation,objView,strDescription
    mVar objFilter = m$.var("objFilter");
    mVar objProperty = m$.var("objProperty");
    mVar objRelation = m$.var("objRelation");
    mVar objView = m$.var("objView");
    mVar strDescription = m$.var("strDescription");
    m$.newVar(objFilter,objProperty,objRelation,objView,strDescription);
    //<< 
    //<< set blnObj = $get(^CacheTempObj(YUSER,"Object"))    //SR15866
    blnObj.set(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object")));
    //<< if (pidClass'="") && (pidFilter'="") {
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(pidFilter.get(),""))) {
      //<< set idForm      = $get(^CacheTempView(YUSER,"Form")) // SR14250
      idForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Form")));
      //<< set blnFocussed = 0
      blnFocussed.set(0);
      //<< set objFilter   = $get(^CacheTempView(YUSER,"Filter",pidFilter))
      objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get())));
      //<< set idField     = $$$COMViewFilterField(objFilter)
      idField.set(include.COMConst.$$$COMViewFilterField(m$,objFilter));
      //<< 
      //<< if 'blnRefresh {
      if (mOp.Not(blnRefresh.get())) {
        //<< set blnInForm = $get(^CacheTempView(YUSER,YUCI,"InForm"))
        blnInForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm")));
        //<< set blnAllowFieldRemoval = ( $$HasViewAccess^COMView(YBED,idForm,YM) &&
        //<< ('blnInForm || (blnInForm && $$SuperUser^COMViewUtils())) )
        blnAllowFieldRemoval.set((mOp.Logical(m$.fnc$("COMView.HasViewAccess",m$.var("YBED").get(),idForm.get(),m$.var("YM").get())) && (mOp.Not(blnInForm.get()) || (mOp.Logical(blnInForm.get()) && mOp.Logical(m$.fnc$("COMViewUtils.SuperUser"))))));
        //<< //write "window.status=window.status+'."_pidFilter_":"_idField_"';  "
        //<< write "CreateControl('"_pidFilter_"','"_idField_"',"_$select(blnAllowFieldRemoval:"true",1:"false")_");"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CreateControl('",pidFilter.get()),"','"),idField.get()),"',"),m$.Fnc.$select(blnAllowFieldRemoval.get(),"true",1,"false")),");"));
      }
      //<< }
      //<< 
      //<< write "document.getElementById('ctrl"_pidFilter_"_3').innerHTML='';"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("document.getElementById('ctrl",pidFilter.get()),"_3').innerHTML='';"));
      //<< 
      //<< if idField'="Custom" {
      if (mOp.NotEqual(idField.get(),"Custom")) {
        //<< if 'blnObj {        //SR15866
        if (mOp.Not(blnObj.get())) {
          //<< set objRelation=$$GetRelation^COMViewUtils(.pidClass,$$$COMViewFilterField(objFilter),.idForm)
          objRelation.set(m$.fnc$("COMViewUtils.GetRelation",pidClass,include.COMConst.$$$COMViewFilterField(m$,objFilter),idForm));
          //<< set idField=$piece(idField,".",$length(idField,"."))
          idField.set(m$.Fnc.$piece(idField.get(),".",m$.Fnc.$length(idField.get(),".")));
          //<< write "document.getElementById('ctrl"_pidFilter_"_1').innerHTML='"_$zconvert($$GetDescription^COMViewDescription(pidClass,$extract(idField,1),$extract(idField,2,99)),"o","JS")_"';" ;BR014900
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('ctrl",pidFilter.get()),"_1').innerHTML='"),m$.Fnc.$zconvert(m$.fnc$("COMViewDescription.GetDescription",pidClass.get(),m$.Fnc.$extract(idField.get(),1),m$.Fnc.$extract(idField.get(),2,99)),"o","JS")),"';"));
          //<< 
          //<< if $$$WWW002InputType(objRelation)=2 {
          if (mOp.Equal(include.WWWConst.$$$WWW002InputType(m$,objRelation),2)) {
            //<< do CreateCheckBox(pidFilter)
            m$.Cmd.Do("CreateCheckBox",pidFilter.get());
          }
          //<< 
          //<< } else {
          else {
            //<< if ($$$WWW002RelationClass(objRelation)'="")&&(($$$WWW002RelationClass(objRelation)'=pidClass)||'$find($$$COMViewFilterField(objFilter),"P"))&&($$$WWW002InputType(objRelation)'=3) {
            if ((mOp.NotEqual(include.WWWConst.$$$WWW002RelationClass(m$,objRelation),"")) && mOp.Logical(((mOp.NotEqual(include.WWWConst.$$$WWW002RelationClass(m$,objRelation),pidClass.get())) || mOp.Not(m$.Fnc.$find(include.COMConst.$$$COMViewFilterField(m$,objFilter),"P")))) && (mOp.NotEqual(include.WWWConst.$$$WWW002InputType(m$,objRelation),3))) {
              //<< do CreateCombo^COMViewFilterCombo(pidClass,pidFilter,objRelation)
              m$.Cmd.Do("COMViewFilterCombo.CreateCombo",pidClass.get(),pidFilter.get(),objRelation.get());
            }
            //<< } elseif $find(",1,14,",","_$$$WWW002InputType(objRelation)_",") {  ;date or time stamp.
            else if (mOp.Logical(m$.Fnc.$find(",1,14,",mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW002InputType(m$,objRelation)),",")))) {
              //<< do CreateDate(pidClass,pidFilter)
              m$.Cmd.Do("CreateDate",pidClass.get(),pidFilter.get());
            }
            //<< } else {
            else {
              //<< //SR16521
              //<< ;set blnUseEventBlur = $$IsSearchClass^COMQuickSearch(pidClass)  ;16708
              //<< do CreateText(pidClass,pidFilter)                                ;16708
              m$.Cmd.Do("CreateText",pidClass.get(),pidFilter.get());
            }
            //<< }
            //<< do CreateComparitor(pidClass,pidFilter,objRelation,$$$COMViewFilterField(objFilter))
            m$.Cmd.Do("CreateComparitor",pidClass.get(),pidFilter.get(),objRelation.get(),include.COMConst.$$$COMViewFilterField(m$,objFilter));
          }
        }
        //<< }
        //<< 
        //<< } else {        //SR15866
        else {
          //<< set strDescription = $$GetTextRelated^WWWClassTranslation(pidClass,idField,$get(SPRACHE))       //SR16468
          strDescription.set(m$.fnc$("WWWClassTranslation.GetTextRelated",pidClass.get(),idField.get(),m$.Fnc.$get(m$.var("SPRACHE"))));
          //<< //write "document.getElementById('ctrl"_pidFilter_"_1').innerHTML='"_idField_"';"
          //<< write "document.getElementById('ctrl"_pidFilter_"_1').innerHTML='"_strDescription_"';"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('ctrl",pidFilter.get()),"_1').innerHTML='"),strDescription.get()),"';"));
          //<< 
          //<< set idInputType = $$GetFinalInputType(pidClass,idField)
          idInputType.set(m$.fnc$("GetFinalInputType",pidClass.get(),idField.get()));
          //<< 
          //<< if 1 {  //objProperty '= $$$NULLOREF {             ; FIXME : Remove test
          if (mOp.Logical(1)) {
            //<< //set idInputType = objProperty.Type
            //<< 
            //<< if $extract(idInputType,1,8)'="alSYS.dt" {
            if (mOp.NotEqual(m$.Fnc.$extract(idInputType.get(),1,8),"alSYS.dt")) {
              //<< set idRelationClass = idInputType
              idRelationClass.set(idInputType.get());
            }
            //<< }
            //<< 
            //<< if idInputType = "alSYS.dt.dtBoolean" {
            if (mOp.Equal(idInputType.get(),"alSYS.dt.dtBoolean")) {
              //<< do CreateCheckBox(pidFilter)
              m$.Cmd.Do("CreateCheckBox",pidFilter.get());
            }
            //<< 
            //<< } elseif (idInputType = "alSYS.dt.dtDate") || (idInputType = "alSYS.dt.dtTimeStamp") {
            else if ((mOp.Equal(idInputType.get(),"alSYS.dt.dtDate")) || (mOp.Equal(idInputType.get(),"alSYS.dt.dtTimeStamp"))) {
              //<< do CreateDate(pidClass,pidFilter)
              m$.Cmd.Do("CreateDate",pidClass.get(),pidFilter.get());
            }
            //<< 
            //<< } else {
            else {
              //<< if (idInputType'=$$$NULLOREF) && ($extract(idInputType,1,8)'="alSYS.dt") {
              if ((mOp.NotEqual(idInputType.get(),include.$occConstant.$$$NULLOREF(m$))) && (mOp.NotEqual(m$.Fnc.$extract(idInputType.get(),1,8),"alSYS.dt"))) {
                //<< do CreateCombo^COMViewObject(pidClass,pidFilter,idInputType)    //SR16521
                m$.Cmd.Do("COMViewObject.CreateCombo",pidClass.get(),pidFilter.get(),idInputType.get());
              }
              //<< }  else {
              else {
                //<< ;set blnUseEventBlur = $$IsSearchClass^COMQuickSearch(pidClass) ;16708
                //<< do CreateText(pidClass,pidFilter)                               ;16708
                m$.Cmd.Do("CreateText",pidClass.get(),pidFilter.get());
              }
            }
            //<< }
            //<< }
            //<< do CreateComparitor(pidClass,pidFilter,"",$$$COMViewFilterField(objFilter))
            m$.Cmd.Do("CreateComparitor",pidClass.get(),pidFilter.get(),"",include.COMConst.$$$COMViewFilterField(m$,objFilter));
          }
        }
      }
      //<< }
      //<< }
      //<< 
      //<< } else {
      else {
        //<< do CreateCustom(pidClass,pidFilter)
        m$.Cmd.Do("CreateCustom",pidClass.get(),pidFilter.get());
        //<< write "document.getElementById('ctrl"_pidFilter_"_1').innerHTML='"_"Custom"_"';"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('ctrl",pidFilter.get()),"_1').innerHTML='"),"Custom"),"';"));
      }
      //<< }
      //<< set idView  = $$GetCurrentView^COMView(pidClass)
      idView.set(m$.fnc$("COMView.GetCurrentView",pidClass.get()));
      //<< set objView = $get(^COMView(0,pidClass,idView,1))
      objView.set(m$.Fnc.$get(m$.var("^COMView",0,pidClass.get(),idView.get(),1)));
      //<< 
      //<< write "document.getElementById('display"_pidFilter_"').checked="_$select($$$COMViewFilterDisplay(objFilter):"true",1:"false")_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('display",pidFilter.get()),"').checked="),m$.Fnc.$select(include.COMConst.$$$COMViewFilterDisplay(m$,objFilter),"true",1,"false")),";"));
      //<< write "document.getElementById('group"_pidFilter_"').checked="_$select($$$COMViewFilterGroupBy(objFilter):"true",1:"false")_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('group",pidFilter.get()),"').checked="),m$.Fnc.$select(include.COMConst.$$$COMViewFilterGroupBy(m$,objFilter),"true",1,"false")),";"));
      //<< write "document.getElementById('default"_pidFilter_"').checked="_$select(idField=$$$COMViewDefaultProperty(objView):"true",1:"false")_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('default",pidFilter.get()),"').checked="),m$.Fnc.$select(mOp.Equal(idField.get(),include.COMConst.$$$COMViewDefaultProperty(m$,objView)),"true",1,"false")),";"));
      //<< write "document.getElementById('ctrl"_pidFilter_"_4').style.display='"_$select($get(^CacheTempView(YUSER,"EditMode")):"inline",1:"none")_"';"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('ctrl",pidFilter.get()),"_4').style.display='"),m$.Fnc.$select(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode")),"inline",1,"none")),"';"));
    }
    //<< }
    //<< 
    //<< write !
    m$.Cmd.Write("\n");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetFinalInputType(pidClass,pidField)
  public Object GetFinalInputType(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Sep-2008   PP      SR15866:Update COMView to Objects
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass2,idField1,idField2,idInputType1,idInputType2
    mVar idClass2 = m$.var("idClass2");
    mVar idField1 = m$.var("idField1");
    mVar idField2 = m$.var("idField2");
    mVar idInputType1 = m$.var("idInputType1");
    mVar idInputType2 = m$.var("idInputType2");
    m$.newVar(idClass2,idField1,idField2,idInputType1,idInputType2);
    //<< new objProperty1,objProperty2,strType
    mVar objProperty1 = m$.var("objProperty1");
    mVar objProperty2 = m$.var("objProperty2");
    mVar strType = m$.var("strType");
    m$.newVar(objProperty1,objProperty2,strType);
    //<< 
    //<< set (idInputType1,idInputType2) = ""
    idInputType1.set("");
    idInputType2.set("");
    //<< 
    //<< set idField1     = $piece(pidField,"->",1)      //$length(idField,"->"))
    idField1.set(m$.Fnc.$piece(pidField.get(),"->",1));
    //<< set objProperty1 = ##class(%Library.PropertyDefinition).%OpenId(pidClass_":"_idField1)
    objProperty1.set(m$.fnc$("$Library.PropertyDefinition.$OpenId",mOp.Concat(mOp.Concat(pidClass.get(),":"),idField1.get())));
    //<< if objProperty1 '= $$$NULLOREF {
    if (mOp.NotEqual(objProperty1.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< set idInputType1 = objProperty1.Type
      idInputType1.set(m$.prop(objProperty1.get(),"Type").get());
    }
    //<< }
    //<< 
    //<< set idClass2 = $$GetClass^COMViewObject(pidClass,pidField)
    idClass2.set(m$.fnc$("COMViewObject.GetClass",pidClass.get(),pidField.get()));
    //<< set idField2 = $piece(pidField,"->",$length(pidField,"->"))      ; FIXME : Getting piece 1 and piece n - do we need to consider intermediate values?  <GRF>
    idField2.set(m$.Fnc.$piece(pidField.get(),"->",m$.Fnc.$length(pidField.get(),"->")));
    //<< set objProperty2 = ##class(%Library.PropertyDefinition).%OpenId(idClass2_":"_idField2)
    objProperty2.set(m$.fnc$("$Library.PropertyDefinition.$OpenId",mOp.Concat(mOp.Concat(idClass2.get(),":"),idField2.get())));
    //<< if objProperty2 '= $$$NULLOREF {
    if (mOp.NotEqual(objProperty2.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< set idInputType2 = objProperty2.Type
      idInputType2.set(m$.prop(objProperty2.get(),"Type").get());
    }
    //<< }
    //<< 
    //<< set strType = ""
    strType.set("");
    //<< 
    //<< if idInputType1 = idInputType2 {
    if (mOp.Equal(idInputType1.get(),idInputType2.get())) {
      //<< set strType = idInputType1
      strType.set(idInputType1.get());
    }
    //<< 
    //<< } elseif (idInputType1="alSYS.dt.dtDate") || (idInputType2="alSYS.dt.dtDate") {
    else if ((mOp.Equal(idInputType1.get(),"alSYS.dt.dtDate")) || (mOp.Equal(idInputType2.get(),"alSYS.dt.dtDate"))) {
      //<< set strType = "alSYS.dt.dtDate"
      strType.set("alSYS.dt.dtDate");
    }
    //<< 
    //<< } elseif (idInputType1="alSYS.dt.dtBoolean") || (idInputType2="alSYS.dt.dtBoolean") {
    else if ((mOp.Equal(idInputType1.get(),"alSYS.dt.dtBoolean")) || (mOp.Equal(idInputType2.get(),"alSYS.dt.dtBoolean"))) {
      //<< set strType = "alSYS.dt.dtBoolean"
      strType.set("alSYS.dt.dtBoolean");
    }
    //<< 
    //<< } else {
    else {
      //<< set strType = idInputType1
      strType.set(idInputType1.get());
    }
    //<< }
    //<< 
    //<< quit strType
    return strType.get();
  }

  //<< 
  //<< 
  //<< CreateText(pidClass,pidFilter,pblnIsDate=$$$NO)
  public Object CreateText(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnIsDate = m$.newVarRef("pblnIsDate",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Sep-2009   shobby  SR16708: Removed pblnUseEventBlur
    //<< ; 18-May-2009   PPP     SR16545: As date filter can be a numeric, check if
    //<< ;                           is <1000 and add $h
    //<< ; 01-Sep-2008   shobby  SRBR014976: Set the FontFace as per company settings.
    //<< ; 20-Feb-2008   shobby  SRBR014900: Only display the search value in text boxes.
    //<< ; 22-Feb-2007   Steve S SR15440: pblnIsDate parameter
    //<< ; 09-Feb-2007   RPW     SR15426: Use correct W3C syntax for getting DOM elements.
    //<< ; 06-Sep-2006   RPW     SRBR014073: Distinguish this as a control instead of data.
    //<< ; 12-Jul-2006   Pablo   SRBR014073: Display saved dates in favourites
    //<< ; 30-Jan-2006   PO      SR14245: Enable paste to trigger search
    //<< ; 10-Feb-2005   PO      SR10965: Changed to handle new return value of DisplayValue.
    //<< ;-------------------------------------------------------------------------------
    //<< new lstValue,objFilter,strValue
    mVar lstValue = m$.var("lstValue");
    mVar objFilter = m$.var("objFilter");
    mVar strValue = m$.var("strValue");
    m$.newVar(lstValue,objFilter,strValue);
    //<< 
    //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",pidFilter))
    objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get())));
    //<< 
    //<< ;BR014900 vvv
    //<< ;This is a text box why do we want to add relationship details here?
    //<< ;set lstValue  = $$DisplayValue^COMViewFilter(pidClass,$$$COMViewFilterField(objFilter),$$$COMViewFilterValue1(objFilter),,,,$$$YES) ; SR10965 // SRBR014073
    //<< ;set strValue  = $listget(lstValue,2)
    //<< set strValue = $$$COMViewFilterValue1(objFilter)
    strValue.set(include.COMConst.$$$COMViewFilterValue1(m$,objFilter));
    //<< ;BR014900 ^^^
    //<< 
    //<< if pblnIsDate && (strValue'="") {
    if (mOp.Logical(pblnIsDate.get()) && (mOp.NotEqual(strValue.get(),""))) {
      //<< if strValue<10000 set strValue = ($horolog + strValue)  //SR16545
      if (mOp.Less(strValue.get(),10000)) {
        strValue.set((mOp.Add(m$.Fnc.$horolog(),strValue.get())));
      }
      //<< set strValue=$$$FormatDate(strValue) //SR15440
      strValue.set(include.COMSYSWWW.$$$FormatDate(m$,strValue));
    }
    //<< }
    //<< write "",!
    m$.Cmd.Write("","\n");
    //<< 
    //<< write $char(9)_"var objText = document.createElement('input');",!
    m$.Cmd.Write(mOp.Concat(m$.Fnc.$char(9),"var objText = document.createElement('input');"),"\n");
    //<< 
    //<< write $char(9)_"objText.style.fontFamily='"_$$FontFace^WWW012()_"';",!  ; BR014976
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$char(9),"objText.style.fontFamily='"),m$.fnc$("WWW012.FontFace")),"';"),"\n");
    //<< write $char(9)_"objText.style.verticalAlign='middle';" ;SR17583
    m$.Cmd.Write(mOp.Concat(m$.Fnc.$char(9),"objText.style.verticalAlign='middle';"));
    //<< 
    //<< write $char(9)_"objText.attachEvent(""onkeyup"",ControlChanged);",!
    m$.Cmd.Write(mOp.Concat(m$.Fnc.$char(9),"objText.attachEvent(\"onkeyup\",ControlChanged);"),"\n");
    //<< write $char(9)_"objText.attachEvent(""onpaste"",ControlChanged);",!
    m$.Cmd.Write(mOp.Concat(m$.Fnc.$char(9),"objText.attachEvent(\"onpaste\",ControlChanged);"),"\n");
    //<< write $char(9)_"objText.attachEvent(""onfocus"",SearchSetFocus);",!
    m$.Cmd.Write(mOp.Concat(m$.Fnc.$char(9),"objText.attachEvent(\"onfocus\",SearchSetFocus);"),"\n");
    //<< //if pblnUseEventBlur write $char(9)_"objText.attachEvent(""onblur"",ControlBlur);",!  ;16708
    //<< write $char(9)_"objText.id='value'+'"_pidFilter_"';",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$char(9),"objText.id='value'+'"),pidFilter.get()),"';"),"\n");
    //<< write $char(9)_"objText.value='"_$$$JSText(strValue)_"';",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$char(9),"objText.value='"),include.COMSYSString.$$$JSText(m$,strValue)),"';"),"\n");
    //<< write $char(9)_"objText.initialValue='"_$$$JSText(strValue)_"';",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$char(9),"objText.initialValue='"),include.COMSYSString.$$$JSText(m$,strValue)),"';"),"\n");
    //<< write $char(9)_"document.getElementById('ctrl"_pidFilter_"_3').appendChild(objText);",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$char(9),"document.getElementById('ctrl"),pidFilter.get()),"_3').appendChild(objText);"),"\n");
    //<< write $char(9),!
    m$.Cmd.Write(m$.Fnc.$char(9),"\n");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CreateDate(pidClass,pidFilter)
  public Object CreateDate(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create a Date control. Note. probably won't finish in time!!
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 17-Sep-2009   shobby  SR16708:Removed third parameter. (pblnUseEventBlur)
    //<< ; 12-May-2009   PPP     SR16521:Barcode Scanning to identify Item; Removed
    //<< ;                           ControlBlur function, always present, setup in
    //<< ;                           COMViewSetupJS1 was previously only for a Date.
    //<< ; 09-Feb-2007   RPW     SR15426: Use correct W3C syntax for getting DOM elements.
    //<< ; 12-Jul-2006   Pablo   SRBR014073: Display saved dates in favourites
    //<< ; 25-Nov-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< do CreateText(pidClass,pidFilter,$$$YES)
    m$.Cmd.Do("CreateText",pidClass.get(),pidFilter.get(),include.COMSYS.$$$YES(m$));
    //<< /* //SR16521  ;16708 can remove this commented code.
    //<< function ControlBlur() {
    //<< var el = event.srcElement;
    //<< var value = el.value;
    //<< if (event.type == 'paste') { // SR14245
    //<< value = clipboardData.getData('Text');
    //<< el.value = value;
    //<< }
    //<< alert(event.type + " " + "Date CB")
    //<< CallBack('ControlBlur^COMViewFilterControl', el.id, value);
    //<< return true;
    //<< }
    //<< */
    //<< // SRBR014073
    //<< &js<
    //<< function ShowDate() {
    //<< var objText=event.srcElement.parentNode.children[0];
    //<< CallBack("ShowDatePicker^COMViewFilterControl",objText.id,objText.value);
    //<< }
    //<< var objDate=document.createElement('img');
    //<< objDate.src='#(YGIF)#date.gif';
    //<< objDate.attachEvent("onclick",ShowDate);
    //<< objDate.align='absbottom';
    //<< document.getElementById('ctrl#(pidFilter)#_3').appendChild(objDate);
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS(" function ShowDate() {","\n");
    m$.Cmd.WriteJS(" var objText=event.srcElement.parentNode.children[0];","\n");
    m$.Cmd.WriteJS(" CallBack(\"ShowDatePicker^COMViewFilterControl\",objText.id,objText.value);","\n");
    m$.Cmd.WriteJS(" }","\n");
    m$.Cmd.WriteJS(" var objDate=document.createElement('img');","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(" objDate.src='",(m$.var("YGIF").get())),"date.gif';"),"\n");
    m$.Cmd.WriteJS(" objDate.attachEvent(\"onclick\",ShowDate);","\n");
    m$.Cmd.WriteJS(" objDate.align='absbottom';","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(" document.getElementById('ctrl",(pidFilter.get())),"_3').appendChild(objDate);"),"\n");
    m$.Cmd.WriteJS(" ");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ShowDatePicker(pidDate,pstrValue)
  public Object ShowDatePicker(Object ... _p) {
    mVar pidDate = m$.newVarRef("pidDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ; pidDate   - HTML Id of the date field
    //<< ; pstrValue - Value / Content of the date field
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Feb-2007   PO      SR15435: Use getElementById for the date field
    //<< ;-------------------------------------------------------------------------------
    //<< new strLink
    mVar strLink = m$.var("strLink");
    m$.newVar(strLink);
    //<< 
    //<< if YBED["SHOBBY" { //SR17460
    if (mOp.Contains(m$.var("YBED").get(),"SHOBBY")) {
      //<< &js<
      //<< objCalendar= new discCalendar();
      //<< objCalendar.weekend='#($$GetWeekend^WWWCalendar(YLOCATION))#';
      //<< objCalendar.monthsLong='#($$GetMonthsLong^WWWCalendar())#';
      //<< objCalendar.daysShort ='#($$GetDaysShort^WWWCalendar())#';
      //<< 
      //<< objCalendar.holidays.add('19/09');
      //<< objCalendar.holidays.add('24/09');
      //<< var result=objCalendar.displayDatePicker('#(pidDate)#');
      //<< //var objText=document.getElementById('#(pidDate)#');
      //<< 
      //<< // if (result != null ) {
      //<< // objText.value=result;
      //<< //  objText.fireEvent('onkeyup');
      //<< // }
      //<< // objText.focus();
      //<< return 1;  //SR17460
      //<< >
      m$.Cmd.WriteJS("","\n");
      m$.Cmd.WriteJS("            objCalendar= new discCalendar();","\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("            objCalendar.weekend='",(m$.fnc$("WWWCalendar.GetWeekend",m$.var("YLOCATION").get()))),"';"),"\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("            objCalendar.monthsLong='",(m$.fnc$("WWWCalendar.GetMonthsLong"))),"';"),"\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("            objCalendar.daysShort ='",(m$.fnc$("WWWCalendar.GetDaysShort"))),"';"),"\n");
      m$.Cmd.WriteJS("            ","\n");
      m$.Cmd.WriteJS("            objCalendar.holidays.add('19/09');","\n");
      m$.Cmd.WriteJS("            objCalendar.holidays.add('24/09');","\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("            var result=objCalendar.displayDatePicker('",(pidDate.get())),"');"),"\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("            //var objText=document.getElementById('",(pidDate.get())),"');"),"\n");
      m$.Cmd.WriteJS("            // if (result != null ) {","\n");
      m$.Cmd.WriteJS("             // objText.value=result;","\n");
      m$.Cmd.WriteJS("            //  objText.fireEvent('onkeyup');","\n");
      m$.Cmd.WriteJS("            // }","\n");
      m$.Cmd.WriteJS("            // objText.focus();","\n");
      m$.Cmd.WriteJS("            return 1;  //SR17460","\n");
      m$.Cmd.WriteJS("        ");
      //<< quit
      return null;
    }
    //<< }
    //<< set strLink = YAKTION_"EP=WWWFORM&YFORM=WWWCAL2&YUSER="_YUSER_"&YBED="_YBED_"&YUCI="_YUCI_"&YM="_YM_"&YLFDAT="_pidDate
    strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&YFORM=WWWCAL2&YUSER="),m$.var("YUSER").get()),"&YBED="),m$.var("YBED").get()),"&YUCI="),m$.var("YUCI").get()),"&YM="),m$.var("YM").get()),"&YLFDAT="),pidDate.get()));
    //<< 
    //<< &js<
    //<< var result = window.showModalDialog('#(strLink)#','Calendar','DialogWidth: 290px; DialogHeight: 330px; resizable: no; status: no; scrollbar: no;');
    //<< var objText=document.getElementById('#(pidDate)#');
    //<< 
    //<< if (result != null ) {
    //<< objText.value=result;
    //<< objText.fireEvent('onkeyup');
    //<< }
    //<< objText.focus();
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("    var result = window.showModalDialog('",(strLink.get())),"','Calendar','DialogWidth: 290px; DialogHeight: 330px; resizable: no; status: no; scrollbar: no;');"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("    var objText=document.getElementById('",(pidDate.get())),"');"),"\n");
    m$.Cmd.WriteJS("     if (result != null ) {","\n");
    m$.Cmd.WriteJS("        objText.value=result;","\n");
    m$.Cmd.WriteJS("        objText.fireEvent('onkeyup');","\n");
    m$.Cmd.WriteJS("     }","\n");
    m$.Cmd.WriteJS("     objText.focus();","\n");
    m$.Cmd.WriteJS(" ");
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< CreateCheckBox(pidFilter)
  public Object CreateCheckBox(Object ... _p) {
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Aug-2012   shobby  SR18080: Corrected actions of checkboxes.
    //<< ; 19-Jul-2010   GRF     SR17253: function chkDisabled reverted - ctrlPressed is
    //<< ;                            deprecated in WWWFORMCrossBrowserSupport
    //<< ; 21-Oct-2008   shobby  BR014967: Included lastState property on checkbox so
    //<< ;                           that it will immediately move to the 'ShowAll' when
    //<< ;                           control key is held down when clicking regardless of
    //<< ;                           current state of checkbox.
    //<< ; 26-Aug-2008   shobby  BR014967: Allow the option of 'ShowAll' on checkbox selectors.
    //<< ; 26-Oct-2005   PO      SR12957: Use defaultChecked instead of checked attr.
    //<< ;                           Reason: On addition of the object into the DOM the
    //<< ;                           object is manipulated so the checked value is false
    //<< ;                           instead of true. This is odd but issue has at least
    //<< ;                           been resolved for IE6.
    //<< ;-------------------------------------------------------------------------------
    //<< new objFilter
    mVar objFilter = m$.var("objFilter");
    m$.newVar(objFilter);
    //<< 
    //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",pidFilter))
    objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get())));
    //<< set $$$COMViewFilterComparator(objFilter) = $$$EnumCOMVIEWCOMPARATOREquals
    include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$));
    //<< 
    //<< set ^CacheTempView(YUSER,"Filter",pidFilter) = objFilter
    m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get()).set(objFilter.get());
    //<< 
    //<< &js<
    //<< 
    //<< var objCheck= document.createElement('input');
    //<< objCheck.type='checkbox';
    //<< objCheck.checkbox='tristate'; //BR014967
    //<< objCheck.id='value'+'#(pidFilter)#';
    //<< objCheck.defaultChecked=#(+$$$COMViewFilterValue1(objFilter))#;
    //<< 
    //<< var objDisabledCheck=document.createElement('TD');
    //<< objDisabledCheck.id=objCheck.id+'container';
    //<< //objDisabledCheck.attachEvent('onclick',ControlChanged);
    //<< objDisabledCheck.attachEvent('onmousedown',function() { chkDisabled('value'+'#(pidFilter)#')});  //SR18080
    //<< objDisabledCheck.ctrlKey=false;
    //<< 
    //<< if (#(+$$$COMViewFilterValue1(objFilter))#==2) {
    //<< objCheck.disabled=true;
    //<< objDisabledCheck.ctrlKey=true;
    //<< }
    //<< document.getElementById('ctrl#(pidFilter)#_3').appendChild(objDisabledCheck);  //SR17396
    //<< objDisabledCheck.appendChild(objCheck);
    //<< 
    //<< function chkDisabled(pid) { //BR014967              //SR18080
    //<< var chk     = document.getElementById(pid)      //SR18080
    //<< var chkcon  = chk.parentNode;
    //<< 
    //<< //if ((window.event && window.event.ctrlKey) || ctrlPressed) {  //SR17253
    //<< 
    //<< if (window.event && window.event.ctrlKey) {  //SR17253
    //<< if ((chk.checked==true) || (chkcon.lastState!=true)) {
    //<< chk.disabled=!chk.disabled;
    //<< }
    //<< if (chk.disabled==true) {
    //<< chk.checked=true;
    //<< chkcon.checked=2;
    //<< } else {
    //<< chk.checked==!chkcon.ctrlKey
    //<< chkcon.checked=+!chk.checked;
    //<< }
    //<< } else {
    //<< chkcon.checked=+!chk.checked;
    //<< chk.disabled=false;
    //<< }
    //<< //chkcon.lastState = window.event ? window.event.ctrlKey : ctrlPressed;  //SR17253   REVERTED
    //<< chkcon.lastState = window.event.ctrlKey
    //<< ControlChanged();
    //<< //chkcon.ctrlKey = window.event ? window.event.ctrlKey : ctrlPressed;  //SR17253   REVERTED
    //<< chkcon.ctrlKey = window.event.ctrlKey
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS(" ","\n");
    m$.Cmd.WriteJS(" var objCheck= document.createElement('input');","\n");
    m$.Cmd.WriteJS(" objCheck.type='checkbox';","\n");
    m$.Cmd.WriteJS(" objCheck.checkbox='tristate'; //BR014967","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(" objCheck.id='value'+'",(pidFilter.get())),"';"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(" objCheck.defaultChecked=",(mOp.Positive(include.COMConst.$$$COMViewFilterValue1(m$,objFilter)))),";"),"\n");
    m$.Cmd.WriteJS(" ","\n");
    m$.Cmd.WriteJS(" var objDisabledCheck=document.createElement('TD');","\n");
    m$.Cmd.WriteJS(" objDisabledCheck.id=objCheck.id+'container';","\n");
    m$.Cmd.WriteJS(" //objDisabledCheck.attachEvent('onclick',ControlChanged);","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(" objDisabledCheck.attachEvent('onmousedown',function() { chkDisabled('value'+'",(pidFilter.get())),"')});  //SR18080"),"\n");
    m$.Cmd.WriteJS(" objDisabledCheck.ctrlKey=false;","\n");
    m$.Cmd.WriteJS(" ","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(" if (",(mOp.Positive(include.COMConst.$$$COMViewFilterValue1(m$,objFilter)))),"==2) {"),"\n");
    m$.Cmd.WriteJS("    objCheck.disabled=true;","\n");
    m$.Cmd.WriteJS("    objDisabledCheck.ctrlKey=true;","\n");
    m$.Cmd.WriteJS(" }","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(" document.getElementById('ctrl",(pidFilter.get())),"_3').appendChild(objDisabledCheck);  //SR17396"),"\n");
    m$.Cmd.WriteJS(" objDisabledCheck.appendChild(objCheck);","\n");
    m$.Cmd.WriteJS(" ","\n");
    m$.Cmd.WriteJS("function chkDisabled(pid) { //BR014967              //SR18080","\n");
    m$.Cmd.WriteJS("    var chk     = document.getElementById(pid)      //SR18080","\n");
    m$.Cmd.WriteJS("    var chkcon  = chk.parentNode;","\n");
    m$.Cmd.WriteJS("    //if ((window.event && window.event.ctrlKey) || ctrlPressed) {  //SR17253","\n");
    m$.Cmd.WriteJS("    if (window.event && window.event.ctrlKey) {  //SR17253","\n");
    m$.Cmd.WriteJS("        if ((chk.checked==true) || (chkcon.lastState!=true)) {","\n");
    m$.Cmd.WriteJS("            chk.disabled=!chk.disabled;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        if (chk.disabled==true) {","\n");
    m$.Cmd.WriteJS("            chk.checked=true;","\n");
    m$.Cmd.WriteJS("            chkcon.checked=2;","\n");
    m$.Cmd.WriteJS("        } else {","\n");
    m$.Cmd.WriteJS("            chk.checked==!chkcon.ctrlKey","\n");
    m$.Cmd.WriteJS("            chkcon.checked=+!chk.checked;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    } else {","\n");
    m$.Cmd.WriteJS("        chkcon.checked=+!chk.checked;","\n");
    m$.Cmd.WriteJS("        chk.disabled=false;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    //chkcon.lastState = window.event ? window.event.ctrlKey : ctrlPressed;  //SR17253   REVERTED","\n");
    m$.Cmd.WriteJS("    chkcon.lastState = window.event.ctrlKey","\n");
    m$.Cmd.WriteJS("    ControlChanged();","\n");
    m$.Cmd.WriteJS("    //chkcon.ctrlKey = window.event ? window.event.ctrlKey : ctrlPressed;  //SR17253   REVERTED","\n");
    m$.Cmd.WriteJS("    chkcon.ctrlKey = window.event.ctrlKey","\n");
    m$.Cmd.WriteJS(" }");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ControlChanged(idFilter,strValue,pJSblnSubmit,pblnEnter=$$$NO) ;16708B
  public Object ControlChanged(Object ... _p) {
    mVar idFilter = m$.newVarRef("idFilter",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar strValue = m$.newVarRef("strValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pJSblnSubmit = m$.newVarRef("pJSblnSubmit",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnEnter = m$.newVarRef("pblnEnter",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called by JS: ControlChanged()
    //<< ;
    //<< ; Params:   idFilter
    //<< ;           strValue
    //<< ;           pJSblnSubmit    - whether to redisplay the grid
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  $$$OK
    //<< ;
    //<< ; History:
    //<< ; 06-Apr-2009   shobby  SR16443: Update the display of the favourite text depending on the value of
    //<< ;                           the 'Distribute' flag.  (ie Distribute favourites are black others are darkblue)
    //<< ; 04-Sep-2007   shobby  SRBR014677: Cache a temporary change value
    //<< ; 22-May-2007   RPW     SR?:
    //<< ; 09-Feb-2007   RPW     SR15426: Handle the new Lock field for creating locked
    //<< ;                           favourites. These are used for InForm COMViews,
    //<< ;                           ie Fixed Filters.
    //<< ; 30-Nov-2006   RPW     SR14709: Fixed & usage to handle each piece correctly.
    //<< ; 25-Oct-2006   PO      SR15143: Reinstated code commented out by SR14709
    //<< ; 25-Oct-2006   RPW     SR14709: Make sure type 14's (timestamp) are converted
    //<< ;                           to horolog format.
    //<< ; 24-Aug-2006   JW      SR14763: Changed 3rd param.
    //<< ; 14-Jun-2006   Steve S SR14613: Only submit if using keystroke/enter key pushed
    //<< ; 16-Feb-2005   PK & PO SR11661 Added Support for default type.
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCreateNew,blnSubmit,enumInputType,idClass,idField,idView,intCount
    mVar blnCreateNew = m$.var("blnCreateNew");
    mVar blnSubmit = m$.var("blnSubmit");
    mVar enumInputType = m$.var("enumInputType");
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar idView = m$.var("idView");
    mVar intCount = m$.var("intCount");
    m$.newVar(blnCreateNew,blnSubmit,enumInputType,idClass,idField,idView,intCount);
    //<< new objField,objFilter,objView
    mVar objField = m$.var("objField");
    mVar objFilter = m$.var("objFilter");
    mVar objView = m$.var("objView");
    m$.newVar(objField,objFilter,objView);
    //<< new strDate,strDelimiter,strQuery,strStatus,strValueUnformatted
    mVar strDate = m$.var("strDate");
    mVar strDelimiter = m$.var("strDelimiter");
    mVar strQuery = m$.var("strQuery");
    mVar strStatus = m$.var("strStatus");
    mVar strValueUnformatted = m$.var("strValueUnformatted");
    m$.newVar(strDate,strDelimiter,strQuery,strStatus,strValueUnformatted);
    //<< 
    //<< set blnSubmit = $$$JSBoolean(pJSblnSubmit)
    blnSubmit.set(include.COMSYS.$$$JSBoolean(m$,pJSblnSubmit));
    //<< set strValue  = $zconvert(strValue,"i","URL")
    strValue.set(m$.Fnc.$zconvert(strValue.get(),"i","URL"));
    //<< set idClass   = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set pblnEnter = $$$JSBoolean(pblnEnter)
    pblnEnter.set(include.COMSYS.$$$JSBoolean(m$,pblnEnter));
    //<< 
    //<< if (idClass'="") {
    if ((mOp.NotEqual(idClass.get(),""))) {
      //<< if $find(idFilter,"value") {
      if (mOp.Logical(m$.Fnc.$find(idFilter.get(),"value"))) {
        //<< set idFilter=$piece(idFilter,"value",2)
        idFilter.set(m$.Fnc.$piece(idFilter.get(),"value",2));
        //<< set objFilter=$get(^CacheTempView(YUSER,"Filter",idFilter))
        objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
        //<< 
        //<< if $$$COMViewFilterStoreValue(objFilter)'="" {
        if (mOp.NotEqual(include.COMConst.$$$COMViewFilterStoreValue(m$,objFilter),"")) {
          //<< xecute "set "_ $$$COMViewFilterStoreValue(objFilter)_"="""_strValue_Y_YLOCATION_""""
          m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("set ",include.COMConst.$$$COMViewFilterStoreValue(m$,objFilter)),"=\""),strValue.get()),m$.var("Y").get()),m$.var("YLOCATION").get()),"\""));
        }
        //<< }
        //<< 
        //<< set idField  = $$$COMViewFilterField(objFilter)
        idField.set(include.COMConst.$$$COMViewFilterField(m$,objFilter));
        //<< set objField = $$GetRelation^COMViewUtils(idClass,.idField)
        objField.set(m$.fnc$("COMViewUtils.GetRelation",idClass.get(),idField));
        //<< 
        //<< // Make sure the date is changed to horolog format.
        //<< set enumInputType  = $$$WWW002InputType(objField)
        enumInputType.set(include.WWWConst.$$$WWW002InputType(m$,objField));
        //<< 
        //<< if (enumInputType=14) || (enumInputType=1) {                  // date / time
        if ((mOp.Equal(enumInputType.get(),14)) || (mOp.Equal(enumInputType.get(),1))) {
          //<< do ConvertDateToHorolog(strValue,idFilter,objFilter,,pblnEnter) ;16708B
          m$.Cmd.Do("ConvertDateToHorolog",strValue.get(),idFilter.get(),objFilter.get(),null,pblnEnter.get());
        }
        //<< } else {
        else {
          //<< set $$$COMViewFilterValue1(objFilter)       = strValue
          include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,strValue.get());
          //<< set ^CacheTempView(YUSER,"Filter",idFilter) = objFilter
          m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get()).set(objFilter.get());
        }
        //<< }
        //<< 
        //<< do:blnSubmit DisplayGrid^COMViewFilter(,,,,blnSubmit)
        if (mOp.Logical(blnSubmit.get())) {
          m$.Cmd.Do("COMViewFilter.DisplayGrid",null,null,null,null,blnSubmit.get());
        }
        //<< 
        //<< ; Put the old value back as this is necessary.
        //<< if $find(strValue,"&") {
        if (mOp.Logical(m$.Fnc.$find(strValue.get(),"&"))) {
          //<< set $$$COMViewFilterValue1(objFilter)       = strValue
          include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,strValue.get());
          //<< set ^CacheTempView(YUSER,"Filter",idFilter) = objFilter
          m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get()).set(objFilter.get());
        }
      }
      //<< }
      //<< 
      //<< } elseif $find(idFilter,"comp") {
      else if (mOp.Logical(m$.Fnc.$find(idFilter.get(),"comp"))) {
        //<< set idFilter  = $piece(idFilter,"comp",2)
        idFilter.set(m$.Fnc.$piece(idFilter.get(),"comp",2));
        //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",idFilter))
        objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
        //<< 
        //<< if (strValue'=$$$COMViewFilterComparator(objFilter)) {
        if ((mOp.NotEqual(strValue.get(),include.COMConst.$$$COMViewFilterComparator(m$,objFilter)))) {
          //<< if (strValue                             =$$$EnumCOMVIEWCOMPARATORWithin) ||
          //<< ($$$COMViewFilterComparator(objFilter)=$$$EnumCOMVIEWCOMPARATORWithin)   {
          if ((mOp.Equal(strValue.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORWithin(m$))) || (mOp.Equal(include.COMConst.$$$COMViewFilterComparator(m$,objFilter),include.COMConst.$$$EnumCOMVIEWCOMPARATORWithin(m$)))) {
            //<< set $$$COMViewFilterComparator(objFilter)   = strValue
            include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,strValue.get());
            //<< set ^CacheTempView(YUSER,"Filter",idFilter) = objFilter
            m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get()).set(objFilter.get());
            //<< do CreateControl(idClass,idFilter,1)
            m$.Cmd.Do("CreateControl",idClass.get(),idFilter.get(),1);
          }
        }
        //<< }
        //<< }
        //<< set $$$COMViewFilterComparator(objFilter)   = strValue
        include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,strValue.get());
        //<< set ^CacheTempView(YUSER,"Filter",idFilter) = objFilter
        m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get()).set(objFilter.get());
        //<< do:blnSubmit DisplayGrid^COMViewFilter(,,,,blnSubmit)
        if (mOp.Logical(blnSubmit.get())) {
          m$.Cmd.Do("COMViewFilter.DisplayGrid",null,null,null,null,blnSubmit.get());
        }
      }
      //<< 
      //<< } elseif $find(idFilter,"display") {
      else if (mOp.Logical(m$.Fnc.$find(idFilter.get(),"display"))) {
        //<< set idFilter = $piece(idFilter,"display",2)
        idFilter.set(m$.Fnc.$piece(idFilter.get(),"display",2));
        //<< set $$$COMViewFilterDisplay(^CacheTempView(YUSER,"Filter",idFilter)) = strValue
        include.COMConst.$$$COMViewFilterDisplaySet(m$,m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get()),strValue.get());
      }
      //<< 
      //<< } elseif $find(idFilter,"group") {
      else if (mOp.Logical(m$.Fnc.$find(idFilter.get(),"group"))) {
        //<< set idFilter = $piece(idFilter,"group",2)
        idFilter.set(m$.Fnc.$piece(idFilter.get(),"group",2));
        //<< set $$$COMViewFilterGroupBy(^CacheTempView(YUSER,"Filter",idFilter)) = strValue
        include.COMConst.$$$COMViewFilterGroupBySet(m$,m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get()),strValue.get());
        //<< do:blnSubmit DisplayGrid^COMViewFilter(,,,,blnSubmit)
        if (mOp.Logical(blnSubmit.get())) {
          m$.Cmd.Do("COMViewFilter.DisplayGrid",null,null,null,null,blnSubmit.get());
        }
      }
      //<< 
      //<< } elseif $find(idFilter,"description") {
      else if (mOp.Logical(m$.Fnc.$find(idFilter.get(),"description"))) {
        //<< set idView  = $$GetCurrentView^COMView(idClass)
        idView.set(m$.fnc$("COMView.GetCurrentView",idClass.get()));
        //<< set objView = $get(^COMView(0,idClass,idView,1))
        objView.set(m$.Fnc.$get(m$.var("^COMView",0,idClass.get(),idView.get(),1)));
        //<< set $$$COMViewDescription(objView) = strValue
        include.COMConst.$$$COMViewDescriptionSet(m$,objView,strValue.get());
        //<< set strStatus = $$$Save("COMView",idClass_$$$COMMA_idView,objView,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"COMView",mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),idView.get()),objView,include.COMSYS.$$$YES(m$)));
        //<< do DisplayView^COMView(idClass,idView)
        m$.Cmd.Do("COMView.DisplayView",idClass.get(),idView.get());
      }
      //<< 
      //<< } elseif $find(idFilter,"Location") {
      else if (mOp.Logical(m$.Fnc.$find(idFilter.get(),"Location"))) {
        //<< set idView  = $$GetCurrentView^COMView(idClass)
        idView.set(m$.fnc$("COMView.GetCurrentView",idClass.get()));
        //<< set objView = $get(^COMView(0,idClass,idView,1))
        objView.set(m$.Fnc.$get(m$.var("^COMView",0,idClass.get(),idView.get(),1)));
        //<< set $$$COMViewLocation(objView) = strValue
        include.COMConst.$$$COMViewLocationSet(m$,objView,strValue.get());
        //<< set strStatus = $$$Save("COMView",idClass_$$$COMMA_idView,objView,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"COMView",mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),idView.get()),objView,include.COMSYS.$$$YES(m$)));
      }
      //<< 
      //<< } elseif $find(idFilter,"user") {
      else if (mOp.Logical(m$.Fnc.$find(idFilter.get(),"user"))) {
        //<< set idView=$$GetCurrentView^COMView(idClass)
        idView.set(m$.fnc$("COMView.GetCurrentView",idClass.get()));
        //<< set objView=$get(^COMView(0,idClass,idView,1))
        objView.set(m$.Fnc.$get(m$.var("^COMView",0,idClass.get(),idView.get(),1)));
        //<< set $$$COMViewUser1(objView) = strValue
        include.COMConst.$$$COMViewUser1Set(m$,objView,strValue.get());
        //<< set strStatus=$$$Save("COMView",idClass_$$$COMMA_idView,objView,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"COMView",mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),idView.get()),objView,include.COMSYS.$$$YES(m$)));
      }
      //<< 
      //<< } elseif $find(idFilter,"distribute") {
      else if (mOp.Logical(m$.Fnc.$find(idFilter.get(),"distribute"))) {
        //<< set idView  = $$GetCurrentView^COMView(idClass)
        idView.set(m$.fnc$("COMView.GetCurrentView",idClass.get()));
        //<< set objView = $get(^COMView(0,idClass,idView,1))
        objView.set(m$.Fnc.$get(m$.var("^COMView",0,idClass.get(),idView.get(),1)));
        //<< set $$$COMViewDistribute(objView) = strValue
        include.COMConst.$$$COMViewDistributeSet(m$,objView,strValue.get());
        //<< set strStatus = $$$Save("COMView",idClass_$$$COMMA_idView,objView,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"COMView",mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),idView.get()),objView,include.COMSYS.$$$YES(m$)));
        //<< do DisplayView^COMView(idClass,idView)
        m$.Cmd.Do("COMView.DisplayView",idClass.get(),idView.get());
      }
      //<< 
      //<< } elseif $find(idFilter,"default") {
      else if (mOp.Logical(m$.Fnc.$find(idFilter.get(),"default"))) {
        //<< set idView  = $$GetCurrentView^COMView(idClass)
        idView.set(m$.fnc$("COMView.GetCurrentView",idClass.get()));
        //<< set objView = $get(^COMView(0,idClass,idView,1))
        objView.set(m$.Fnc.$get(m$.var("^COMView",0,idClass.get(),idView.get(),1)));
        //<< set $$$COMViewDefaultProperty(objView) = strValue
        include.COMConst.$$$COMViewDefaultPropertySet(m$,objView,strValue.get());
        //<< set strStatus = $$$Save("COMView",idClass_$$$COMMA_idView,objView,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"COMView",mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),idView.get()),objView,include.COMSYS.$$$YES(m$)));
      }
      //<< 
      //<< } elseif $find(idFilter,"lock") {
      else if (mOp.Logical(m$.Fnc.$find(idFilter.get(),"lock"))) {
        //<< set idView  = $$GetCurrentView^COMView(idClass)
        idView.set(m$.fnc$("COMView.GetCurrentView",idClass.get()));
        //<< set objView = $get(^COMView(0,idClass,idView,1))
        objView.set(m$.Fnc.$get(m$.var("^COMView",0,idClass.get(),idView.get(),1)));
        //<< set $$$COMViewLock(objView) = strValue
        include.COMConst.$$$COMViewLockSet(m$,objView,strValue.get());
        //<< set strStatus = $$$Save("COMView",idClass_$$$COMMA_idView,objView,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"COMView",mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),idView.get()),objView,include.COMSYS.$$$YES(m$)));
      }
    }
    //<< }
    //<< }
    //<< if (+$$$WWWClientParamCoreChangesHEVA($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesHEVA(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
      //<< if (($get(objFilter) '= "") && (YFORM = "VARDispensacaoViaPrescricao")){
      if (mOp.Logical(((mOp.NotEqual(m$.Fnc.$get(objFilter),"")) && (mOp.Equal(m$.var("YFORM").get(),"VARDispensacaoViaPrescricao"))))) {
        //<< set ^VARTempDispesacaoViaPrescricao(YBED,$piece(objFilter,Y,1)) = $piece(objFilter,Y,2)
        m$.var("^VARTempDispesacaoViaPrescricao",m$.var("YBED").get(),m$.Fnc.$piece(objFilter.get(),m$.var("Y").get(),1)).set(m$.Fnc.$piece(objFilter.get(),m$.var("Y").get(),2));
      }
    }
    //<< }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< ConvertDate(pstrDate,pstrFormat)
  public Object ConvertDate(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrFormat = m$.newVarRef("pstrFormat",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Converts a date to a horolog based on the specified format.
    //<< ;
    //<< ; Inputs:
    //<< ;   pstrDate    : 25/02/2000 or 02.25.2000 or 20000225 etc.
    //<< ;   pstrFormat  : DD/MM/YYYY or MM.DD.YYYY or YYYYMMDD etc.
    //<< ;
    //<< ; Returns: +$horolog of date
    //<< ;
    //<< ; History:
    //<< ; 27-Apr-2010   GRF     SR17263.1: Translate "A" to "Y" as well; doco
    //<< ; 01-Apr-2010   shobby  SR17263: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrDate,loop,intDay,intMonth,intYear,strChar,strDate
    mVar arrDate = m$.var("arrDate");
    mVar loop = m$.var("loop");
    mVar intDay = m$.var("intDay");
    mVar intMonth = m$.var("intMonth");
    mVar intYear = m$.var("intYear");
    mVar strChar = m$.var("strChar");
    mVar strDate = m$.var("strDate");
    m$.newVar(arrDate,loop,intDay,intMonth,intYear,strChar,strDate);
    //<< 
    //<< set $ztrap = "ConvertDateError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("ConvertDateError");
    //<< 
    //<< ;---------------------------------------
    //<< ; 25/02/2000 for DD/MM/YYYY
    //<< ; --->           --->    process character by character   ; FIXME : what if 25/2/2000 instead?
    //<< ;
    //<< ;   arrDate("D") = 25
    //<< ;   arrDate("M") = 2
    //<< ;   arrDate("Y") = 2000
    //<< ;   arrDate("/") = 0
    //<< ;   strDate = "20000225" => 58129
    //<< ;---------------------------------------
    //<< 
    //<< set pstrFormat = $translate(pstrFormat,"TJA","DYY")   ; SR17263.1
    pstrFormat.set(m$.Fnc.$translate(pstrFormat.get(),"TJA","DYY"));
    //<< set strDate = ""
    strDate.set("");
    //<< for loop=1:1:$length(pstrFormat) {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(pstrFormat.get())));loop.set(mOp.Add(loop.get(),1))) {
      //<< set strChar = $extract(pstrFormat,loop)
      strChar.set(m$.Fnc.$extract(pstrFormat.get(),loop.get()));
      //<< set arrDate(strChar) = $get(arrDate(strChar))*10+$extract(pstrDate,loop)
      arrDate.var(strChar.get()).set(mOp.Add(mOp.Multiply(m$.Fnc.$get(arrDate.var(strChar.get())),10),m$.Fnc.$extract(pstrDate.get(),loop.get())));
    }
    //<< }
    //<< if $length(arrDate("Y"))<3 set arrDate("Y") = $$GETYEAR^WWWDATE1(arrDate("Y"))
    if (mOp.Less(m$.Fnc.$length(arrDate.var("Y").get()),3)) {
      arrDate.var("Y").set(m$.fnc$("WWWDATE1.GETYEAR",arrDate.var("Y").get()));
    }
    //<< 
    //<< set strDate = $translate($justify($get(arrDate("Y")),4)," ",0)_$translate($justify($get(arrDate("M")),2)," ",0)_$translate($justify($get(arrDate("D")),2)," ",0)
    strDate.set(mOp.Concat(mOp.Concat(m$.Fnc.$translate(m$.Fnc.$justify(m$.Fnc.$get(arrDate.var("Y")),4)," ",0),m$.Fnc.$translate(m$.Fnc.$justify(m$.Fnc.$get(arrDate.var("M")),2)," ",0)),m$.Fnc.$translate(m$.Fnc.$justify(m$.Fnc.$get(arrDate.var("D")),2)," ",0)));
    //<< set strDate = $zdateh(strDate,8)
    strDate.set(m$.Fnc.$zdateh(strDate.get(),8));
    //<< quit strDate
    return strDate.get();
  }

  //<< 
  //<< ConvertDateError ; Internal Tag
  public Object ConvertDateError() {
    //<< ; FIXME : if 02/25/2000 submitted for "DD/MM/YYYY" then exit here
    //<< ;         returns "02/25/2000" which may cause problems elsewhere
    //<< ; FIXME : if pstrDate not defined will get error diversion here then second undefined error
    //<< set $ztrap=""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< quit pstrDate
    return m$.var("pstrDate").get();//TODO REVISAR RETURN ESTAVA VOID;
  }

  //<< 
  //<< 
  //<< ConvertDateToHorolog(ptmsValue,pidFilter,pobjFilter,pstrSubmit="",pblnEnter) ;16708B
  public Object ConvertDateToHorolog(Object ... _p) {
    mVar ptmsValue = m$.newVarRef("ptmsValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjFilter = m$.newVarRef("pobjFilter",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrSubmit = m$.newVarRef("pstrSubmit",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pblnEnter = m$.newVarRef("pblnEnter",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert the timestamp details to horolog format is required.
    //<< ;
    //<< ; This was in ControlBlur but has been moved here.
    //<< ;
    //<< ; NOTE : WWWDATE = Internal To Literal   WWWDATE1 = Literal to Internal
    //<< ;
    //<< ; Called By : ControlChanged, ControlBlur, self - RECURSIVE, 2 instances 1 level
    //<< ;
    //<< ; Params:
    //<< ;   ptmsValue  : The timestamp to be converted (DD/MM/YYYY, etc. or intOffset
    //<< ;                   or two entries with "&" delimiter)
    //<< ;   pidFilter  : The id of the filter being manipulated
    //<< ;   pobjFilter : The filter details
    //<< ;   pstrSubmit : Whether to submit.  Note we only do this for the blur as this
    //<< ;                is handled differently than pressing enter.
    //<< ;                If the ptmsValue contains a "&", ControlBlur will call with pstrSubmit
    //<< ;                also set to the contents of ptmsValue.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: nothing - updates ^CacheTempView(YUSER,"Filter",pidFilter)
    //<< ;
    //<< ; History:
    //<< ; 09-Aug-2011   shobby  SR17807: GetFormat has moved.
    //<< ; 01-Apr-2010   shobby  SR17263: Call out to ConvertDate
    //<< ; 18-May-2009   PPP     SR16545: Store the values entered for the Date for
    //<< ;                           recalculation in the raw format ie 60, -60 etc
    //<< ;                           when displayed will be changed to the literal format
    //<< ; 30-Nov-2006   RPW     SR14709: Fixed & usage to handle each piece correctly.
    //<< ; 20-Nov-2006   RPW     SR14709: Fixed delimiter requirements so that 'incorrect'
    //<< ;                           delimiters did not cause the value to vanish. Also
    //<< ;                           translate them to /.
    //<< ; 25-Oct-2006   RPW     SR14709: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strDate,strDelimiter,dteNow,strValueUnformatted,objFilter,strDate1,strDate2
    mVar strDate = m$.var("strDate");
    mVar strDelimiter = m$.var("strDelimiter");
    mVar dteNow = m$.var("dteNow");
    mVar strValueUnformatted = m$.var("strValueUnformatted");
    mVar objFilter = m$.var("objFilter");
    mVar strDate1 = m$.var("strDate1");
    mVar strDate2 = m$.var("strDate2");
    m$.newVar(strDate,strDelimiter,dteNow,strValueUnformatted,objFilter,strDate1,strDate2);
    //<< 
    //<< set dteNow = +$horolog
    dteNow.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< // SR14709: If we are an & do this nasty hack to get each date piece.
    //<< if (ptmsValue="") {
    if ((mOp.Equal(ptmsValue.get(),""))) {
      //<< set $$$COMViewFilterValue1(pobjFilter)=""
      include.COMConst.$$$COMViewFilterValue1Set(m$,pobjFilter,"");
      //<< set ^CacheTempView(YUSER,"Filter",pidFilter) = pobjFilter
      m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get()).set(pobjFilter.get());
    }
    //<< 
    //<< } elseif $find(ptmsValue,"&") {
    else if (mOp.Logical(m$.Fnc.$find(ptmsValue.get(),"&"))) {
      //<< set strDate1 = $piece(ptmsValue,"&",1)
      strDate1.set(m$.Fnc.$piece(ptmsValue.get(),"&",1));
      //<< set strDate2 = $piece(ptmsValue,"&",2)
      strDate2.set(m$.Fnc.$piece(ptmsValue.get(),"&",2));
      //<< 
      //<< quit:strDate2=""                                           ; EARLY QUIT
      if (mOp.Equal(strDate2.get(),"")) {
        return null;
      }
      //<< 
      //<< do ConvertDateToHorolog(strDate1,pidFilter,pobjFilter)
      m$.Cmd.Do("ConvertDateToHorolog",strDate1.get(),pidFilter.get(),pobjFilter.get());
      //<< set ptmsValue = $$GetFilterValue1(pidFilter)
      ptmsValue.set(m$.fnc$("GetFilterValue1",pidFilter.get()));
      //<< 
      //<< if strDate2'="" {                                          ; FIXME : see quit ^^^ <GRF>
      if (mOp.NotEqual(strDate2.get(),"")) {
        //<< do ConvertDateToHorolog(strDate2,pidFilter,pobjFilter)
        m$.Cmd.Do("ConvertDateToHorolog",strDate2.get(),pidFilter.get(),pobjFilter.get());
        //<< set ptmsValue = ptmsValue_"&"_$$GetFilterValue1(pidFilter)
        ptmsValue.set(mOp.Concat(mOp.Concat(ptmsValue.get(),"&"),m$.fnc$("GetFilterValue1",pidFilter.get())));
      }
      //<< }
      //<< 
      //<< set $$$COMViewFilterValue1(pobjFilter)       = ptmsValue
      include.COMConst.$$$COMViewFilterValue1Set(m$,pobjFilter,ptmsValue.get());
      //<< set ^CacheTempView(YUSER,"Filter",pidFilter) = pobjFilter
      m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get()).set(pobjFilter.get());
      //<< 
      //<< if pstrSubmit'="" {
      if (mOp.NotEqual(pstrSubmit.get(),"")) {
        //<< do SubmitDateToScreen(pidFilter,pstrSubmit)
        m$.Cmd.Do("SubmitDateToScreen",pidFilter.get(),pstrSubmit.get());
      }
    }
    //<< }
    //<< 
    //<< //Store Date in unformatted view if + or - are used //SR16545
    //<< } elseif '$find(ptmsValue,"&") && (+$translate(ptmsValue," ")=$translate(ptmsValue," ")) && pblnEnter { ;16708B
    else if (mOp.Not(m$.Fnc.$find(ptmsValue.get(),"&")) && (mOp.Equal(mOp.Positive(m$.Fnc.$translate(ptmsValue.get()," ")),m$.Fnc.$translate(ptmsValue.get()," "))) && mOp.Logical(pblnEnter.get())) {
      //<< ; FIXME : '$find is superfluous
      //<< set $$$COMViewFilterValue1(pobjFilter) = $translate(ptmsValue," ")
      include.COMConst.$$$COMViewFilterValue1Set(m$,pobjFilter,m$.Fnc.$translate(ptmsValue.get()," "));
      //<< set ^CacheTempView(YUSER,"Filter",pidFilter) = pobjFilter
      m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get()).set(pobjFilter.get());
      //<< set ptmsValue  = $horolog + $translate(ptmsValue," ")
      ptmsValue.set(mOp.Add(m$.Fnc.$horolog(),m$.Fnc.$translate(ptmsValue.get()," ")));
      //<< set pstrSubmit = $$^WWWDATE(ptmsValue)
      pstrSubmit.set(m$.fnc$("WWWDATE.main",ptmsValue.get()));
      //<< if pstrSubmit'="" {
      if (mOp.NotEqual(pstrSubmit.get(),"")) {
        //<< do SubmitDateToScreen(pidFilter,pstrSubmit)
        m$.Cmd.Do("SubmitDateToScreen",pidFilter.get(),pstrSubmit.get());
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< ;SR17807 set strValueUnformatted = $$ConvertDate(ptmsValue,$$GetFormat^INPARA(1))
      //<< set strValueUnformatted = $$ConvertDate(ptmsValue,$$GetFormat^WWW100(1))    ;SR17807
      strValueUnformatted.set(m$.fnc$("ConvertDate",ptmsValue.get(),m$.fnc$("WWW100.GetFormat",1)));
      //<< set $$$COMViewFilterValue1(pobjFilter)       = strValueUnformatted
      include.COMConst.$$$COMViewFilterValue1Set(m$,pobjFilter,strValueUnformatted.get());
      //<< set ^CacheTempView(YUSER,"Filter",pidFilter) = pobjFilter
      m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get()).set(pobjFilter.get());
      //<< 
      //<< ;SR17263 if ($length(ptmsValue,",")=1) &&
      //<< ;SR17263   (($$^WWWDATE($piece(ptmsValue," ",1)) = "") || (ptmsValue<=31)) { // formatted date
      //<< ;SR17263    // Correct date not containing month and/or year
      //<< ;SR17263    set strDate      = $piece(ptmsValue," ",1)
      //<< ;SR17263    set strDelimiter = $extract($zstrip(strDate,"*AN"))
      //<< ;SR17263    if (strDelimiter = "") set strDelimiter = "/"
      //<< ;SR17263    if strDelimiter'="/" {
      //<< ;SR17263        set strDate      = $translate(strDate,strDelimiter,"/")
      //<< ;SR17263        set strDelimiter = "/"
      //<< ;SR17263    }
      //<< 
      //<< ;SR17263    if ($piece(strDate,strDelimiter,2) = "") set $piece(strDate,strDelimiter,2) = $$^WWWMONTH(dteNow)
      //<< ;SR17263    if ($piece(strDate,strDelimiter,3) = "") set $piece(strDate,strDelimiter,3) = $$^WWWYEAR(dteNow)
      //<< ;SR17263    set $piece(ptmsValue," ",1) = $$^WWWDATE($$^WWWDATE1(strDate))
      //<< 
      //<< ;SR17263    if ($$^WWWDATE1($piece(ptmsValue," ",1)) '= "") {
      //<< ;SR17263        // change to horolog format
      //<< ;SR17263        if $length(ptmsValue, " ") > 1 {
      //<< ;SR17263            set strValueUnformatted = $$^WWWDATE1($piece(ptmsValue," ",1))_","_$$^WWWTIME1($piece(ptmsValue, " ", 2))
      //<< ;SR17263        } else {
      //<< ;SR17263            set strValueUnformatted = $$^WWWDATE1(ptmsValue)
      //<< ;SR17263        }
      //<< 
      //<< ;SR17263        set $$$COMViewFilterValue1(pobjFilter)       = strValueUnformatted
      //<< ;SR17263        set ^CacheTempView(YUSER,"Filter",pidFilter) = pobjFilter
      //<< ;SR17263    }
      //<< if pstrSubmit'="" {        ; FIXME : since only set when ptmsValue contains "&" will never execute <GRF>
      if (mOp.NotEqual(pstrSubmit.get(),"")) {
        //<< do SubmitDateToScreen(pidFilter,pstrSubmit)
        m$.Cmd.Do("SubmitDateToScreen",pidFilter.get(),pstrSubmit.get());
      }
    }
    //<< }
    //<< ;SR17263 }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetFilterValue1(pidFilter)
  public Object GetFilterValue1(Object ... _p) {
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Value 1 from the filter
    //<< ;
    //<< ; Params:
    //<< ; pidFilter : Which filter to read
    //<< ;
    //<< ; Returns:
    //<< ; The value of the filter value 1
    //<< ;
    //<< ; History:
    //<< ; 01-Dec-2006   RPW     SR14709: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objFilter
    mVar objFilter = m$.var("objFilter");
    m$.newVar(objFilter);
    //<< 
    //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",pidFilter))
    objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get())));
    //<< quit $$$COMViewFilterValue1(objFilter)
    return include.COMConst.$$$COMViewFilterValue1(m$,objFilter);
  }

  //<< 
  //<< 
  //<< SubmitDateToScreen(pidFilter,pstrSubmit)
  public Object SubmitDateToScreen(Object ... _p) {
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrSubmit = m$.newVarRef("pstrSubmit",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Write out the filter information to the screen
    //<< ;
    //<< ; Params:
    //<< ; pidFilter : Which filter to change
    //<< ; pstrSubmit: The value to write to the filter.
    //<< ;
    //<< ; History:
    //<< ; 01-Dec-2006   RPW     SR14709: Created
    //<< ;-------------------------------------------------------------------------------
    //<< write "if (document.getElementById('value"_pidFilter_"') != null) {"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("if (document.getElementById('value",pidFilter.get()),"') != null) {"));
    //<< write "    document.getElementById('value"_pidFilter_"').value = '"_pstrSubmit_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("    document.getElementById('value",pidFilter.get()),"').value = '"),pstrSubmit.get()),"';"));
    //<< write "}"
    m$.Cmd.Write("}");
    //<< do:$$UseKeyStroke^COMViewConfig() DisplayGrid^COMViewFilter() // BR014073
    if (mOp.Logical(m$.fnc$("COMViewConfig.UseKeyStroke"))) {
      m$.Cmd.Do("COMViewFilter.DisplayGrid");
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< /*
  //<< ControlBlur(pidFilter, pstrValue) // SRBR014073  ;16708 removed VVVVVV
  //<< ;-------------------------------------------------------------------------------
  //<< ; Display saved dates in favourites
  //<< ;
  //<< ; Called by JS: ControlBlur()
  //<< ;
  //<< ; Params:
  //<< ;
  //<< ; ByRefs:
  //<< ;
  //<< ; Returns:
  //<< ;
  //<< ; History:
  //<< ; 19-Sep-2009   shobby  SR16708: This appears to be redundant.
  //<< ; 06-May-2009   PPP     SR16521: Barcode Scanning to identify Item; if Current
  //<< ;                           or Relation class is a Quick Search find if there is an
  //<< ;                           alternate ID
  //<< ; 30-Nov-2006   RPW     SR14709: Fixed & usage to handle each piece correctly.
  //<< ; 25-Oct-2006   RPW     SR14709: Moved timestamp conversion to ConvertDateToHorolog routine.
  //<< ; 21-Sep-2006   PO      BR014073: Only call DisplayGrid if using key stroke delay search
  //<< ; 12-Jul-2006   Pablo   SRBR014073: Created
  //<< ;-------------------------------------------------------------------------------
  //<< new blnObj,enumInputType,idClass,idField,idInputType,objFilter,objWWW003
  //<< new strDate,strDelimiter,strValueUnformatted
  //<< 
  //<< set pstrValue = $zconvert(pstrValue,"i","URL")
  //<< set idClass   = $get(^CacheTempView(YUSER,"Class"))
  //<< set blnObj    = $get(^CacheTempObj(YUSER,"Object")) //SR15866
  //<< 
  //<< if (idClass '= "") {
  //<< if $find(pidFilter,"value") {
  //<< set pidFilter = $piece(pidFilter,"value",2)
  //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",pidFilter))
  //<< 
  //<< //SR16521
  //<< if 'blnObj {
  //<< set objWWW003 = $$GetRelation^COMViewUtils(.idClass,$$$COMViewFilterField(objFilter))
  //<< 
  //<< set enumInputType = $$$WWW002InputType(objWWW003)
  //<< 
  //<< if (enumInputType = 14) || (enumInputType=1) {            // date / time
  //<< do ConvertDateToHorolog(pstrValue,pidFilter,objFilter,$select($find(pstrValue,"&"):pstrValue,1:""))
  //<< }
  //<< 
  //<< //SR16521
  //<< if $$GetId^COMQuickSearch(idClass,$$$WWW002RelationClass(objWWW003),.pstrValue) {
  //<< set $$$COMViewFilterValue1(objFilter)        = pstrValue
  //<< set ^CacheTempView(YUSER,"Filter",pidFilter) = objFilter
  //<< do SubmitDateToScreen(pidFilter,pstrValue)
  //<< }
  //<< 
  //<< } else {
  //<< set idField = $$$COMViewFilterField(objFilter)
  //<< set idInputType = $$GetFinalInputType(idClass,idField)
  //<< if (idInputType = "alSYS.dt.dtDate") {                    // date / time
  //<< do ConvertDateToHorolog(pstrValue,pidFilter,objFilter,$select($find(pstrValue,"&"):pstrValue,1:""))
  //<< }
  //<< 
  //<< //SR16521
  //<< set idField = $$$COMViewFilterField(objFilter)
  //<< if $$GetId^COMQuickSearch(idInputType,,.pstrValue) {
  //<< set $$$COMViewFilterValue1(objFilter) = pstrValue
  //<< set ^CacheTempView(YUSER,"Filter",pidFilter) = objFilter
  //<< do SubmitDateToScreen(pidFilter,pstrValue)
  //<< }
  //<< }
  //<< }
  //<< }
  //<< 
  //<< quit $$$OK // SRBR014073   ;16708 removed ^^^^^^^
  //<< */
  //<< 
  //<< CreateComparitorFuntion()       // NOT IN USE ???  FIXME Fun_ c _tion
  public Object CreateComparitorFuntion() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2005   shobby  SR12754: LANGUAGE changed to SPRACHE (not always reliable)
    //<< ;-------------------------------------------------------------------------------
    //<< new idComp,strComp
    mVar idComp = m$.var("idComp");
    mVar strComp = m$.var("strComp");
    m$.newVar(idComp,strComp);
    //<< 
    //<< set idComp  = ""
    idComp.set("");
    //<< set strComp = ""
    strComp.set("");
    //<< for {
    for (;true;) {
      //<< set idComp = $order(^WWW101(0,"COMVIEWCOMPARATOR",SPRACHE,idComp))
      idComp.set(m$.Fnc.$order(m$.var("^WWW101",0,"COMVIEWCOMPARATOR",m$.var("SPRACHE").get(),idComp.get())));
      //<< quit:idComp=""
      if (mOp.Equal(idComp.get(),"")) {
        break;
      }
      //<< 
      //<< if strComp'="" set strComp=strComp_","
      if (mOp.NotEqual(strComp.get(),"")) {
        strComp.set(mOp.Concat(strComp.get(),","));
      }
      //<< set strComp=strComp_"'"_$$$WWW101Text($get(^WWW101(0,"COMVIEWCOMPARATOR",SPRACHE,idComp,1)))_"'"
      strComp.set(mOp.Concat(mOp.Concat(mOp.Concat(strComp.get(),"'"),include.WWWConst.$$$WWW101Text(m$,m$.Fnc.$get(m$.var("^WWW101",0,"COMVIEWCOMPARATOR",m$.var("SPRACHE").get(),idComp.get(),1)))),"'"));
    }
    //<< }
    //<< 
    //<< &js<
    //<< var arrOpt=new Array(#(strComp)#);
    //<< var arrList=pList.split(',');
    //<< while (arrList.length!=0) {
    //<< var o = document.createElement('option');
    //<< var value=arrList.shift();
    //<< o.value=value;
    //<< o.innerHTML=arrOpt[value-1];
    //<< SelectObject.appendChild(o);
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(" var arrOpt=new Array(",(strComp.get())),");"),"\n");
    m$.Cmd.WriteJS(" var arrList=pList.split(',');","\n");
    m$.Cmd.WriteJS(" while (arrList.length!=0) {","\n");
    m$.Cmd.WriteJS(" var o = document.createElement('option');","\n");
    m$.Cmd.WriteJS(" var value=arrList.shift();","\n");
    m$.Cmd.WriteJS(" o.value=value;","\n");
    m$.Cmd.WriteJS(" o.innerHTML=arrOpt[value-1];","\n");
    m$.Cmd.WriteJS(" SelectObject.appendChild(o);","\n");
    m$.Cmd.WriteJS(" }","\n");
    m$.Cmd.WriteJS(" ");
    //<< quit ""
    return "";
  }

  //<< 
  //<< SelectControl(pidField,pidFilter)
  public Object SelectControl(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Jan-2008   shobby  SRBR014551: Don't create a control if this favourite is based on SQL
    //<< ; 09-Jun-2006   Steve S SR14613: Only re-display if using keystroke
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idFilter,objFilter
    mVar idClass = m$.var("idClass");
    mVar idFilter = m$.var("idFilter");
    mVar objFilter = m$.var("objFilter");
    m$.newVar(idClass,idFilter,objFilter);
    //<< 
    //<< set idFilter  = ""
    idFilter.set("");
    //<< set pidFilter = ""
    pidFilter.set("");
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< 
    //<< if pidFilter="" set pidFilter=$order(^CacheTempView(YUSER,"Filter",""),-1)+1
    if (mOp.Equal(pidFilter.get(),"")) {
      pidFilter.set(mOp.Add(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",""),mOp.Negative(1)),1));
    }
    //<< set idFilter=""
    idFilter.set("");
    //<< 
    //<< for {
    for (;true;) {
      //<< set idFilter=$order(^CacheTempView(YUSER,"Filter",idFilter))
      idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
      //<< quit:idFilter<pidFilter
      if (mOp.Less(idFilter.get(),pidFilter.get())) {
        break;
      }
      //<< 
      //<< set ^CacheTempView(YUSER,"Filter",idFilter+1)=$get(^CacheTempView(YUSER,"Filter",idFilter))
      m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",mOp.Add(idFilter.get(),1)).set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
    }
    //<< }
    //<< 
    //<< set objFilter=""
    objFilter.set("");
    //<< set $$$COMViewFilterField(objFilter)   = pidField
    include.COMConst.$$$COMViewFilterFieldSet(m$,objFilter,pidField.get());
    //<< set $$$COMViewFilterValue1(objFilter)  = ""
    include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,"");
    //<< set $$$COMViewFilterDisplay(objFilter) = 1
    include.COMConst.$$$COMViewFilterDisplaySet(m$,objFilter,1);
    //<< set ^CacheTempView(YUSER,"Filter",pidFilter) = objFilter
    m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get()).set(objFilter.get());
    //<< if $$GetCurrentSQL^COMView(idClass)=""  do CreateControl(idClass,pidFilter) ;BR014551
    if (mOp.Equal(m$.fnc$("COMView.GetCurrentSQL",idClass.get()),"")) {
      m$.Cmd.Do("CreateControl",idClass.get(),pidFilter.get());
    }
    //<< do:$$UseKeyStroke^COMViewConfig() DisplayGrid^COMViewFilter() //SR14613
    if (mOp.Logical(m$.fnc$("COMViewConfig.UseKeyStroke"))) {
      m$.Cmd.Do("COMViewFilter.DisplayGrid");
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< RemoveControl(pidFilter)
  public Object RemoveControl(Object ... _p) {
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called by JS: RemoveControl()
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   HeberB  SRBR014579: Update External filter on CacheTempView
    //<< ; 15-Feb-2007   Steve S SR15431: Use standard alert, not VBConfirm
    //<< ; 09-Jun-2006   Steve S SR14613: Only re-display if using keystroke
    //<< ;-------------------------------------------------------------------------------
    //<< new idFilter,idFilterExternal,idLastFilter
    mVar idFilter = m$.var("idFilter");
    mVar idFilterExternal = m$.var("idFilterExternal");
    mVar idLastFilter = m$.var("idLastFilter");
    m$.newVar(idFilter,idFilterExternal,idLastFilter);
    //<< 
    //<< set pidFilter = $piece($piece(pidFilter,"ctrl",2),"_",1)
    pidFilter.set(m$.Fnc.$piece(m$.Fnc.$piece(pidFilter.get(),"ctrl",2),"_",1));
    //<< 
    //<< if ($order(^CacheTempView(YUSER,"Filter",pidFilter))="")    &&
    //<< ($order(^CacheTempView(YUSER,"Filter",pidFilter),-1)="")    {
    if ((mOp.Equal(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get())),"")) && (mOp.Equal(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get()),mOp.Negative(1)),""))) {
      //<< 
      //<< $$$Alert("Com00252") ; "Can not remove all entries from the Field Selection"
      include.COMSYS.$$$Alert(m$,"Com00252");
    }
    //<< 
    //<< } else {
    else {
      //<< set idFilter = pidFilter
      idFilter.set(pidFilter.get());
      //<< for {
      for (;true;) {
        //<< set idLastFilter = idFilter
        idLastFilter.set(idFilter.get());
        //<< set idFilter = $order(^CacheTempView(YUSER,"Filter",idFilter))
        idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
        //<< quit:idFilter=""
        if (mOp.Equal(idFilter.get(),"")) {
          break;
        }
        //<< 
        //<< set ^CacheTempView(YUSER,"Filter",idLastFilter) = $get(^CacheTempView(YUSER,"Filter",idFilter))
        m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idLastFilter.get()).set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
        //<< set idFilterExternal = $$GetIdExternalFilter^COMView(idLastFilter)
        idFilterExternal.set(m$.fnc$("COMView.GetIdExternalFilter",idLastFilter.get()));
        //<< if (idFilterExternal'="") {                             // the one removed is external
        if ((mOp.NotEqual(idFilterExternal.get(),""))) {
          //<< kill ^CacheTempView(YUSER,YUCI,"External",idFilterExternal)
          m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"External",idFilterExternal.get()).kill();
        }
        //<< }
        //<< set idFilterExternal = $$GetIdExternalFilter^COMView(idFilter)
        idFilterExternal.set(m$.fnc$("COMView.GetIdExternalFilter",idFilter.get()));
        //<< if (idFilterExternal) {                                 // the one moved is external
        if (mOp.Logical((idFilterExternal.get()))) {
          //<< set ^CacheTempView(YUSER,YUCI,"External",idFilterExternal) = idLastFilter
          m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"External",idFilterExternal.get()).set(idLastFilter.get());
        }
      }
      //<< }
      //<< }
      //<< kill ^CacheTempView(YUSER,"Filter",idLastFilter)
      m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idLastFilter.get()).kill();
      //<< do DisplayControls($get(^CacheTempView(YUSER,"Class")))
      m$.Cmd.Do("DisplayControls",m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
      //<< do:$$UseKeyStroke^COMViewConfig() DisplayGrid^COMViewFilter() //SR14613
      if (mOp.Logical(m$.fnc$("COMViewConfig.UseKeyStroke"))) {
        m$.Cmd.Do("COMViewFilter.DisplayGrid");
      }
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< FormOnlyChecked(pblnChecked)
  public Object FormOnlyChecked(Object ... _p) {
    mVar pblnChecked = m$.newVarRef("pblnChecked",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Callback when the 'form only' checkbox is ticked for a favourite
    //<< ;
    //<< ; Params:   pblnChecked : Whether the box is ticked or not
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 14-Feb-2007   Steve S     SR15431: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idView,objCOMView,strStatus,idClass
    mVar idView = m$.var("idView");
    mVar objCOMView = m$.var("objCOMView");
    mVar strStatus = m$.var("strStatus");
    mVar idClass = m$.var("idClass");
    m$.newVar(idView,objCOMView,strStatus,idClass);
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;
    //<< tstart
    //<< ;
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set idView  = $get(^CacheTempView(YUSER,"EditMode","ViewName"))
    idView.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode","ViewName")));
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< 
    //<< if (idView="") {
    if ((mOp.Equal(idView.get(),""))) {
      //<< set strStatus = $$$MakeStatus("Com00111")         ; "No favourite selected"
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"Com00111"));
    }
    //<< } elseif (idClass="") {
    else if ((mOp.Equal(idClass.get(),""))) {
      //<< set strStatus = $$$MakeStatus("Com00113")         ; "No class selected."
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"Com00113"));
    }
    //<< } elseif '$data(^COMView(0,idClass,idView)) {
    else if (mOp.Not(m$.Fnc.$data(m$.var("^COMView",0,idClass.get(),idView.get())))) {
      //<< set strStatus = $$$MakeStatus("Com00114",idView)  ; "Favourite %1 does not exist."
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"Com00114",idView));
    }
    //<< } else {
    else {
      //<< set objCOMView = $get(^COMView(0,idClass,idView,1))
      objCOMView.set(m$.Fnc.$get(m$.var("^COMView",0,idClass.get(),idView.get(),1)));
      //<< set $$$COMViewForm(objCOMView)=$select(pblnChecked:$$$CallingForm,$$$YES:"")
      include.COMConst.$$$COMViewFormSet(m$,objCOMView,m$.Fnc.$select(pblnChecked.get(),include.COMView.$$$CallingForm(m$),include.COMSYS.$$$YES(m$),""));
      //<< set strStatus = $$$Save("COMView",idClass_","_idView,objCOMView,$$$YES)
      strStatus.set(include.COMSYS.$$$Save(m$,"COMView",mOp.Concat(mOp.Concat(idClass.get(),","),idView.get()),objCOMView,include.COMSYS.$$$YES(m$)));
    }
    //<< }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< if $tlevel>0 tcommit
      if (mOp.Greater(m$.Fnc.$tlevel(),0)) {
      }
    }
    //<< } else {
    else {
      //<< trollback
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
    }
    //<< }
    //<< ;
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateComparitor(pidClass,pidFilter,pobjRelation,pstrField)
  public Object CreateComparitor(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjRelation = m$.newVarRef("pobjRelation",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 12-Jul-2010   shobby  SR17396: use document.getElementById
    //<< ; 26-Sep-2008   shobby  SRBR014982: Include the 'within' selection criteria on all
    //<< ;                                   texts (not just those with a relationship to another class)
    //<< ; 01-Sep-2008   shobby  SRBR014978: Support changes in fonts.
    //<< ; 19-Jul-2006   JW      SR14832: Support 'between' clause
    //<< ; 29-May-2006   Steve S SR14675: Support 'like' filter
    //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
    //<< ;-------------------------------------------------------------------------------
    //<< new strList,strDefault,objFilter
    mVar strList = m$.var("strList");
    mVar strDefault = m$.var("strDefault");
    mVar objFilter = m$.var("objFilter");
    m$.newVar(strList,strDefault,objFilter);
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ;                 WWW002/WWW003                     ||   COMViewFilter
    //<< ;                   InputType                       ||    Comparator
    //<< ;-------------------------------------------------------------------------------
    //<< ;   0   Hidden              10  File Name           ||
    //<< ;   1   Date                11  Draw                ||  1   Greater Than
    //<< ;   2   Yes/No              12  Floating            ||  2   Less Than
    //<< ;   3   Memo                13  IP-format           ||  3   Equals
    //<< ;   4   Integer             14  Timestamp           ||  4   Not Equals
    //<< ;   5   Password            15  Collection          ||  5   Starts With
    //<< ;   6   Text                16  Embedded            ||  6   Contains
    //<< ;   7   Time                17  Date CCYYMMDD       ||  7   Within
    //<< ;   8   Currency            18  Exchange Rate       ||  8   Like
    //<< ;   9   Counter                                     ||  9   Between
    //<< ;                                                   ||  10  Find In
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;---------------------------------------
    //<< ; Numeric Fields
    //<< ;---------------------------------------
    //<< if $find(",1,4,7,8,12,14,17,18,",","_$$$WWW002InputType(pobjRelation)_",") {  //SR13074
    if (mOp.Logical(m$.Fnc.$find(",1,4,7,8,12,14,17,18,",mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW002InputType(m$,pobjRelation)),",")))) {
      //<< set strList    = "1,2,3,4,9"
      strList.set("1,2,3,4,9");
      //<< set strDefault = 1
      strDefault.set(1);
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; Boolean Field
    //<< ;---------------------------------------
    //<< } elseif $$$WWW002InputType(pobjRelation)=2 {
    else if (mOp.Equal(include.WWWConst.$$$WWW002InputType(m$,pobjRelation),2)) {
      //<< set strList    = "3"
      strList.set("3");
      //<< set strDefault = 3
      strDefault.set(3);
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; Other (Test, Date)
    //<< ;---------------------------------------
    //<< } else {
    else {
      //<< set strList = "1,2,3,4,5,6,7,8,9,10"
      strList.set("1,2,3,4,5,6,7,8,9,10");
      //<< if ($$$WWW002RelationClass(pobjRelation)'="")       &&
      //<< ($$$WWW002RelationClass(pobjRelation)'=pidClass) &&
      //<< ($$$WWW002InputType(pobjRelation)'=3)               {
      if ((mOp.NotEqual(include.WWWConst.$$$WWW002RelationClass(m$,pobjRelation),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW002RelationClass(m$,pobjRelation),pidClass.get())) && (mOp.NotEqual(include.WWWConst.$$$WWW002InputType(m$,pobjRelation),3))) {
        //<< 
        //<< set strDefault = 3
        strDefault.set(3);
      }
      //<< } else {
      else {
        //<< set strDefault = 5
        strDefault.set(5);
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",pidFilter))
    objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get())));
    //<< 
    //<< if $find(","_strList_",",","_$$$COMViewFilterComparator(objFilter)_",") {
    if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",strList.get()),","),mOp.Concat(mOp.Concat(",",include.COMConst.$$$COMViewFilterComparator(m$,objFilter)),",")))) {
      //<< set strDefault=$$$COMViewFilterComparator(objFilter)
      strDefault.set(include.COMConst.$$$COMViewFilterComparator(m$,objFilter));
    }
    //<< } else {
    else {
      //<< set $$$COMViewFilterComparator(objFilter)    = strDefault
      include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,strDefault.get());
      //<< set ^CacheTempView(YUSER,"Filter",pidFilter) = objFilter
      m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get()).set(objFilter.get());
    }
    //<< }
    //<< 
    //<< /*
    //<< &js<
    //<< ctrl#(pidFilter)#_2.innerHTML='';
    //<< var s = document.createElement('select');
    //<< s.style.fontFamily='#($$FontFace^WWW012())#'; //BR014976
    //<< s.attachEvent("onchange",ControlChanged);
    //<< 
    //<< s.id='comp'+#(pidFilter)#;
    //<< objDIV.CreateComp(s,'#(strList)#');
    //<< s.value=#(strDefault)#;
    //<< s.initialValue=#(strDefault)#;
    //<< ctrl#(pidFilter)#_2.appendChild(s);
    //<< >
    //<< 
    //<< */
    //<< ;if pidClass["FINGL" write "debugger;"
    //<< 
    //<< write "ctrl"_pidFilter_"_2.innerHTML='';",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("ctrl",pidFilter.get()),"_2.innerHTML='';"),"\n");
    //<< write "var s = document.createElement('select');",!
    m$.Cmd.Write("var s = document.createElement('select');","\n");
    //<< write "s.style.fontFamily='"_$$FontFace^WWW012()_"';",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("s.style.fontFamily='",m$.fnc$("WWW012.FontFace")),"';"),"\n");
    //<< write "s.attachEvent(""onchange"",ControlChanged);",!
    m$.Cmd.Write("s.attachEvent(\"onchange\",ControlChanged);","\n");
    //<< write "s.id='comp'+"_pidFilter_";",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("s.id='comp'+",pidFilter.get()),";"),"\n");
    //<< write "objDIV.CreateComp(s,'"_strList_"')",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("objDIV.CreateComp(s,'",strList.get()),"')"),"\n");
    //<< write "s.value="_strDefault_";",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("s.value=",strDefault.get()),";"),"\n");
    //<< write "s.initialValue="_strDefault_";",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("s.initialValue=",strDefault.get()),";"),"\n");
    //<< //SR17396 write "ctrl"_pidFilter_"_2.appendChild(s);",!
    //<< write "document.getElementById('ctrl"_pidFilter_"_2').appendChild(s);",!    //SR17396
    m$.Cmd.Write(mOp.Concat(mOp.Concat("document.getElementById('ctrl",pidFilter.get()),"_2').appendChild(s);"),"\n");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateCustom(pidClass,pidFilter)
  public Object CreateCustom(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< do CreateText(pidClass,pidFilter)
    m$.Cmd.Do("CreateText",pidClass.get(),pidFilter.get());
    //<< write "objText.size=50;",!
    m$.Cmd.Write("objText.size=50;","\n");
    //<< quit
    return null;
  }

//<< 
//<< 
}
