//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewDescription
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-13 20:50:13
//*****************************************************************************

import mLibrary.*;

//<< #include COMConst
import include.COMConst;
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
//<< #include WWWConst
import include.WWWConst;
//<< #include %occInclude
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;

//<< COMViewDescription ; plays with the description of the search grid.
public class COMViewDescription extends mClass {

  public void main() {
    _COMViewDescription();
  }

  public void _COMViewDescription() {
  }

  //<< 
  //<< Show()
  public Object Show() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Re-displays the menu header for a COMViewSearch
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Apr-2011   shobby  SR17707: Highlight the link on the WindowTitle.
    //<< ; 21-Mar-2011   shobby  SR17258: Get the COMView title from the form name rather than
    //<< ;                           the class name.
    //<< ; 03-Mar-2010   GRF     -: true boolean value; clear old commented code
    //<< ; 03-Dec-2009   PPP     SR17069: Add the 'Start' & 'Menu' buttons for Flexible Menu (10)
    //<< ;                           when there is no @NM class defined for the COMView class
    //<< ; 09-Sep-2008   PP      SR15866: Update COMView to Objects
    //<< ; 12-Sep-2006   RPW     SR15029: Don't show plan unless you are DBAdmin or SysAdmin
    //<< ; 29-Aug-2006   JW      SR14763: add in call to JS:Search
    //<< ; 19-Jul-2006   JW      SR14832: Support 'between' clause
    //<< ; 29-May-2006   Steve S SR14675: Support 'LIKE' clause
    //<< ; 11-May-2006   RPW     SR14420: Finished checking for calculated fields so that
    //<< ;                           the header gets the description correctly.
    //<< ; 13-Feb-2006   SC & JW SR14250: Set form passed to HasViewAccess. COMViewSearch
    //<< ;                           was not checking correct form's access.
    //<< ; 31-Jan-2006   PO      SR14250: If user doesn't have View Access then disallow
    //<< ;                           condition removal
    //<< ; 15-Jul-2005   PO & JW Added language text
    //<< ; 11-May-2005   PO & PK SR12142 Enabling select all feature
    //<< ; 29-Mar-2005   Paul K  Modified for related classes
    //<< ; 10-Feb-2005   PO      SR10965 Switched over to using new list form of DisplayValue.
    //<< ; 06-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCanRemoveCondition,blnObj,COLOR,COLORR
    mVar blnCanRemoveCondition = m$.var("blnCanRemoveCondition");
    mVar blnObj = m$.var("blnObj");
    mVar COLOR = m$.var("COLOR");
    mVar COLORR = m$.var("COLORR");
    m$.newVar(blnCanRemoveCondition,blnObj,COLOR,COLORR);
    //<< new idClass,idField,idFilter,idForm,idRealClass,lstValue,objFilter
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar idFilter = m$.var("idFilter");
    mVar idForm = m$.var("idForm");
    mVar idRealClass = m$.var("idRealClass");
    mVar lstValue = m$.var("lstValue");
    mVar objFilter = m$.var("objFilter");
    m$.newVar(idClass,idField,idFilter,idForm,idRealClass,lstValue,objFilter);
    //<< new strAccess,strCaption,strComp,strFilterDescription,strHTML,strShowPlan,strText
    mVar strAccess = m$.var("strAccess");
    mVar strCaption = m$.var("strCaption");
    mVar strComp = m$.var("strComp");
    mVar strFilterDescription = m$.var("strFilterDescription");
    mVar strHTML = m$.var("strHTML");
    mVar strShowPlan = m$.var("strShowPlan");
    mVar strText = m$.var("strText");
    m$.newVar(strAccess,strCaption,strComp,strFilterDescription,strHTML,strShowPlan,strText);
    //<< 
    //<< set blnObj = ''$get(^CacheTempObj(YUSER,"Object"))
    blnObj.set(mOp.Not(mOp.Not(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object")))));
    //<< 
    //<< quit:+$get(^CacheTempView(YUSER,YUCI,"InForm"))
    if (mOp.Logical(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm"))))) {
      return null;
    }
    //<< 
    //<< set idForm = $get(^CacheTempView(YUSER,"Form"))
    idForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Form")));
    //<< set blnCanRemoveCondition = $$HasViewAccess^COMView(YBED,idForm,YM) //SR14250
    blnCanRemoveCondition.set(m$.fnc$("COMView.HasViewAccess",m$.var("YBED").get(),idForm.get(),m$.var("YM").get()));
    //<< 
    //<< set strHTML = ""
    strHTML.set("");
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< if idClass'="" {
    if (mOp.NotEqual(idClass.get(),"")) {
      //<< set strText = $$$Text($select($get(^CacheTempView(YUSER,"CallBack"))="":"Com00122",1:"Com00189"))
      strText.set(include.COMSYS.$$$Text(m$,m$.Fnc.$select(mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallBack")),""),"Com00122",1,"Com00189")));
      //<< ;       "Search : "   "Select : "
      //<< //SR17069
      //<< set strHTML=strHTML_"<table border=0 nowrap width=100%> <tr> <td> <b> <font size=3 color=white>" ;SR17707
      strHTML.set(mOp.Concat(strHTML.get(),"<table border=0 nowrap width=100%> <tr> <td> <b> <font size=3 color=white>"));
      //<< 
      //<< set strAccess=","_$$^WWWBEDBER(YBED)_","
      strAccess.set(mOp.Concat(mOp.Concat(",",m$.fnc$("WWWBEDBER.main",m$.var("YBED").get())),","));
      //<< set strShowPlan=""
      strShowPlan.set("");
      //<< if ($find(strAccess,",1,"))||($find(strAccess,",2,")) {
      if (mOp.Logical((m$.Fnc.$find(strAccess.get(),",1,"))) || mOp.Logical((m$.Fnc.$find(strAccess.get(),",2,")))) {
        //<< set strShowPlan="onclick='ShowPlan();'"
        strShowPlan.set("onclick='ShowPlan();'");
        //<< ;SR17707 vvvvvv
        //<< set strShowPlan=strShowPlan_" onmouseover='"
        strShowPlan.set(mOp.Concat(strShowPlan.get()," onmouseover='"));
        //<< set strShowPlan=strShowPlan_"document.getElementById(""WindowTitle"").style.cursor=""pointer"";"
        strShowPlan.set(mOp.Concat(strShowPlan.get(),"document.getElementById(\"WindowTitle\").style.cursor=\"pointer\";"));
        //<< set strShowPlan=strShowPlan_"document.getElementById(""WindowTitle"").style.color=""wheat"";"
        strShowPlan.set(mOp.Concat(strShowPlan.get(),"document.getElementById(\"WindowTitle\").style.color=\"wheat\";"));
        //<< set strShowPlan=strShowPlan_"'"
        strShowPlan.set(mOp.Concat(strShowPlan.get(),"'"));
        //<< set strShowPlan=strShowPlan_" onmouseout='"
        strShowPlan.set(mOp.Concat(strShowPlan.get()," onmouseout='"));
        //<< set strShowPlan=strShowPlan_"document.getElementById(""WindowTitle"").style.color=""white"";"
        strShowPlan.set(mOp.Concat(strShowPlan.get(),"document.getElementById(\"WindowTitle\").style.color=\"white\";"));
        //<< set strShowPlan=strShowPlan_"'"
        strShowPlan.set(mOp.Concat(strShowPlan.get(),"'"));
      }
      //<< ;SR17707 ^^^^^^^
      //<< }
      //<< 
      //<< set strHTML = strHTML_"<span "_strShowPlan_" id='WindowTitle'>"_strText_"</span>"  ; "Search : " / "Select : "
      strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"<span "),strShowPlan.get())," id='WindowTitle'>"),strText.get()),"</span>"));
      //<< 
      //<< set strText=$$^WWWFORMNAME(idForm)                       ;SR17258
      strText.set(m$.fnc$("WWWFORMNAME.main",idForm.get()));
      //<< if strText="" set strText=$$GetClassDescription(idClass) ;SR17258 Just in case
      if (mOp.Equal(strText.get(),"")) {
        strText.set(m$.fnc$("GetClassDescription",idClass.get()));
      }
      //<< set strHTML = strHTML_strText                            ;SR17258
      strHTML.set(mOp.Concat(strHTML.get(),strText.get()));
      //<< 
      //<< set strFilterDescription = ""
      strFilterDescription.set("");
      //<< if $order(^CacheTempView(YUSER,"FixedFilter",""))'="" {
      if (mOp.NotEqual(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter","")),"")) {
        //<< set strFilterDescription = strFilterDescription_" "_$$$Text("Com00219")_" ("   ; "where"
        strFilterDescription.set(mOp.Concat(mOp.Concat(mOp.Concat(strFilterDescription.get()," "),include.COMSYS.$$$Text(m$,"Com00219"))," ("));
        //<< 
        //<< set idFilter = ""
        idFilter.set("");
        //<< for {
        for (;true;) {
          //<< set idFilter = $order(^CacheTempView(YUSER,"FixedFilter",idFilter))
          idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",idFilter.get())));
          //<< quit:idFilter=""
          if (mOp.Equal(idFilter.get(),"")) {
            break;
          }
          //<< 
          //<< if $extract(strFilterDescription,$length(strFilterDescription))'="(" set strFilterDescription = strFilterDescription_", "
          if (mOp.NotEqual(m$.Fnc.$extract(strFilterDescription.get(),m$.Fnc.$length(strFilterDescription.get())),"(")) {
            strFilterDescription.set(mOp.Concat(strFilterDescription.get(),", "));
          }
          //<< 
          //<< set objFilter = $get(^CacheTempView(YUSER,"FixedFilter",idFilter))
          objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",idFilter.get())));
          //<< set idField   = $$$COMViewFilterField(objFilter)
          idField.set(include.COMConst.$$$COMViewFilterField(m$,objFilter));
          //<< 
          //<< if blnCanRemoveCondition set strFilterDescription = strFilterDescription_"<span ondblclick='Searching(); CallBack(""RemoveFixedFilter^COMViewDescription"","_idFilter_");'>"
          if (mOp.Logical(blnCanRemoveCondition.get())) {
            strFilterDescription.set(mOp.Concat(mOp.Concat(mOp.Concat(strFilterDescription.get(),"<span ondblclick='Searching(); CallBack(\"RemoveFixedFilter^COMViewDescription\","),idFilter.get()),");'>"));
          }
          //<< 
          //<< set idRealClass=idClass
          idRealClass.set(idClass.get());
          //<< if $$$COMViewFilterGroupBy(objFilter) {
          if (mOp.Logical(include.COMConst.$$$COMViewFilterGroupBy(m$,objFilter))) {
            //<< set strFilterDescription=strFilterDescription_" "_$$$StrCOMViewFilterGroupBy_" "
            strFilterDescription.set(mOp.Concat(mOp.Concat(mOp.Concat(strFilterDescription.get()," "),include.COMConst.$$$StrCOMViewFilterGroupBy(m$))," "));
          }
          //<< }
          //<< 
          //<< if 'blnObj {
          if (mOp.Not(blnObj.get())) {
            //<< ; FIXME : <GRF> GetRelation^COMViewUtils is a function.
            //<< do GetRelation^COMViewUtils(.idRealClass,.idField)
            m$.Cmd.Do("COMViewUtils.GetRelation",idRealClass,idField);
            //<< 
            //<< if $extract(idField,1)'="C" {
            if (mOp.NotEqual(m$.Fnc.$extract(idField.get(),1),"C")) {
              //<< set strFilterDescription = strFilterDescription_$$^WWWFELDNAME(idRealClass,$extract(idField,1),$extract(idField,2,99))
              strFilterDescription.set(mOp.Concat(strFilterDescription.get(),m$.fnc$("WWWFELDNAME.main",idRealClass.get(),m$.Fnc.$extract(idField.get(),1),m$.Fnc.$extract(idField.get(),2,99))));
            }
            //<< } else {
            else {
              //<< set strCaption = $$$WWW003CalcLangDescription($get(^WWW003CalcLang(0,idRealClass,$extract(idField,2,99),SPRACHE,1)))
              strCaption.set(include.WWWConst.$$$WWW003CalcLangDescription(m$,m$.Fnc.$get(m$.var("^WWW003CalcLang",0,idRealClass.get(),m$.Fnc.$extract(idField.get(),2,99),m$.var("SPRACHE").get(),1))));
              //<< if strCaption = "" {
              if (mOp.Equal(strCaption.get(),"")) {
                //<< set strCaption = $$$WWW003CalcCaption($get(^WWW003Calc(0,idRealClass,$extract(idField,2,99),1)))
                strCaption.set(include.WWWConst.$$$WWW003CalcCaption(m$,m$.Fnc.$get(m$.var("^WWW003Calc",0,idRealClass.get(),m$.Fnc.$extract(idField.get(),2,99),1))));
              }
              //<< }
              //<< set strFilterDescription = strFilterDescription_strCaption
              strFilterDescription.set(mOp.Concat(strFilterDescription.get(),strCaption.get()));
            }
          }
          //<< }
          //<< 
          //<< } else {
          else {
            //<< set strFilterDescription = strFilterDescription_idField
            strFilterDescription.set(mOp.Concat(strFilterDescription.get(),idField.get()));
          }
          //<< }
          //<< 
          //<< set strComp = $$$COMViewFilterComparator(objFilter)
          strComp.set(include.COMConst.$$$COMViewFilterComparator(m$,objFilter));
          //<< if strComp="" {
          if (mOp.Equal(strComp.get(),"")) {
          }
          //<< // Do nothing
          //<< 
          //<< } elseif $$$Contains(($$$EnumCOMVIEWCOMPARATORStartsWith,$$$EnumCOMVIEWCOMPARATORLike,$$$EnumCOMVIEWCOMPARATORBetween),strComp) {
          else if (mOp.Logical(m$.Fnc.$listfind(m$.Fnc.$listbuild(include.COMConst.$$$EnumCOMVIEWCOMPARATORStartsWith(m$),include.COMConst.$$$EnumCOMVIEWCOMPARATORLike(m$),include.COMConst.$$$EnumCOMVIEWCOMPARATORBetween(m$)),strComp.get()))) {
            //<< set strFilterDescription = strFilterDescription_" "_$$$AppEnum("COMVIEWCOMPARATOR",strComp)_" "
            strFilterDescription.set(mOp.Concat(mOp.Concat(mOp.Concat(strFilterDescription.get()," "),include.COMSYSWWW.$$$AppEnum(m$,"COMVIEWCOMPARATOR",strComp))," "));
          }
          //<< 
          //<< } else {
          else {
            //<< set strFilterDescription = strFilterDescription_$case(strComp,
            //<< $$$EnumCOMVIEWCOMPARATORNotEquals   :" not = ",
            //<< $$$EnumCOMVIEWCOMPARATORGreaterThan :" > ",
            //<< $$$EnumCOMVIEWCOMPARATORLessThan    :" < ",
            //<< :" = "  )
            strFilterDescription.set(mOp.Concat(strFilterDescription.get(),m$.Fnc.$case(strComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORNotEquals(m$)," not = ",include.COMConst.$$$EnumCOMVIEWCOMPARATORGreaterThan(m$)," > ",include.COMConst.$$$EnumCOMVIEWCOMPARATORLessThan(m$)," < "," = ")));
          }
          //<< }
          //<< 
          //<< if $$$COMViewFilterValue1(objFilter)="" {
          if (mOp.Equal(include.COMConst.$$$COMViewFilterValue1(m$,objFilter),"")) {
            //<< set strFilterDescription = strFilterDescription_$$$Text("Com00149")  ; "Nothing"
            strFilterDescription.set(mOp.Concat(strFilterDescription.get(),include.COMSYS.$$$Text(m$,"Com00149")));
          }
          //<< 
          //<< } else {
          else {
            //<< set lstValue = $$DisplayValue^COMViewFilter(idRealClass,idField,$$$COMViewFilterValue1(objFilter))
            lstValue.set(m$.fnc$("COMViewFilter.DisplayValue",idRealClass.get(),idField.get(),include.COMConst.$$$COMViewFilterValue1(m$,objFilter)));
            //<< set strFilterDescription = strFilterDescription_$listget(lstValue,2)_" "
            strFilterDescription.set(mOp.Concat(mOp.Concat(strFilterDescription.get(),m$.Fnc.$listget(lstValue.get(),2))," "));
          }
          //<< }
          //<< if blnCanRemoveCondition set strFilterDescription = strFilterDescription_"</span>"
          if (mOp.Logical(blnCanRemoveCondition.get())) {
            strFilterDescription.set(mOp.Concat(strFilterDescription.get(),"</span>"));
          }
        }
        //<< }
        //<< set strFilterDescription = strFilterDescription_" )"
        strFilterDescription.set(mOp.Concat(strFilterDescription.get()," )"));
      }
    }
    //<< }
    //<< }
    //<< set strHTML=strHTML_$$CreateFilterDescriptionButton(strFilterDescription)
    strHTML.set(mOp.Concat(strHTML.get(),m$.fnc$("CreateFilterDescriptionButton",strFilterDescription.get())));
    //<< 
    //<< //SR17069
    //<< set objWWW013 = $get(^WWW013(0,YBED,1))
    mVar objWWW013 = m$.var("objWWW013");
    objWWW013.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
    //<< if ($$$WWW013MenuType(objWWW013) = 10) {
    if ((mOp.Equal(include.WWWConst.$$$WWW013MenuType(m$,objWWW013),10))) {
      //<< // if not @NM class (alSOH.dPeriodBalance) of the Form does not have a class defined e.g.INAUFRELEASEORDER)
      //<< if '$data(^WWW001(0,idClass)) || ($$GetClassForForm($get(YFORM))="") {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW001",0,idClass.get()))) || (mOp.Equal(m$.fnc$("GetClassForForm",m$.Fnc.$get(m$.var("YFORM"))),""))) {
        //<< do GetCOMViewHeaderColors(.COLOR,.COLORR)
        m$.Cmd.Do("GetCOMViewHeaderColors",COLOR,COLORR);
        //<< set strHTML = strHTML_"</b></td>"
        strHTML.set(mOp.Concat(strHTML.get(),"</b></td>"));
        //<< set strHTML = strHTML_"<td width=5% style=""""background-color:"_COLORR_";text-align:right;width:20px;"""">"_$$GetButtonStyle^WWWKOPF()_$$GetOverviewButton^WWWKOPF()_"</td>"
        strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"<td width=5% style=\"\"background-color:"),COLORR.get()),";text-align:right;width:20px;\"\">"),m$.fnc$("WWWKOPF.GetButtonStyle")),m$.fnc$("WWWKOPF.GetOverviewButton")),"</td>"));
        //<< set strHTML = strHTML_"<td width=5% style=""""background-color:"_COLORR_";text-align:right;width:20px"""">"_$$GetMenuButton^WWWKOPF()_"</td>"
        strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"<td width=5% style=\"\"background-color:"),COLORR.get()),";text-align:right;width:20px\"\">"),m$.fnc$("WWWKOPF.GetMenuButton")),"</td>"));
        //<< set strHTML = strHTML_"</tr></table>"
        strHTML.set(mOp.Concat(strHTML.get(),"</tr></table>"));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< write "desc.innerHTML='"_$zcvt(strHTML,"o","JS")_"';",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("desc.innerHTML='",m$.Fnc.$zconvert(strHTML.get(),"o","JS")),"';"),"\n");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateFilterDescriptionButton(pstrFilterDescription)
  public Object CreateFilterDescriptionButton(Object ... _p) {
    mVar pstrFilterDescription = m$.newVarRef("pstrFilterDescription",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Creates a +/- button to show or hide the selection filter details
    //<< ; Default date is defined by the 'Hide Filter Description' in
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Sep-2007   shobby  SRBR014666: The ability to view the filter description
    //<< ;                           can now be limited by permissions in the
    //<< ;                           COMViewConfig screen.
    //<< ; 20-Sep-2007   shobby  SRBR014666: Remember the current users state when
    //<< ;                           refreshing the filter description (after double
    //<< ;                           clicking to remove conditions).
    //<< ; 01-Sep-2007   shobby  SRBR014666: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML,objCOMViewConfig,strTitle,blnCanAccess
    mVar strHTML = m$.var("strHTML");
    mVar objCOMViewConfig = m$.var("objCOMViewConfig");
    mVar strTitle = m$.var("strTitle");
    mVar blnCanAccess = m$.var("blnCanAccess");
    m$.newVar(strHTML,objCOMViewConfig,strTitle,blnCanAccess);
    //<< 
    //<< set strHTML=""
    strHTML.set("");
    //<< if pstrFilterDescription'="" {
    if (mOp.NotEqual(pstrFilterDescription.get(),"")) {
      //<< set objCOMViewConfig=$get(^COMViewConfig(0,YM,1))
      objCOMViewConfig.set(m$.Fnc.$get(m$.var("^COMViewConfig",0,m$.var("YM").get(),1)));
      //<< set blnCanAccess=$$^WWWACCESS($$$COMViewConfigAbletoviewfilterdescripti(objCOMViewConfig))
      blnCanAccess.set(m$.fnc$("WWWACCESS.main",include.COMConst.$$$COMViewConfigAbletoviewfilterdescripti(m$,objCOMViewConfig)));
      //<< if blnCanAccess {
      if (mOp.Logical(blnCanAccess.get())) {
        //<< set strHTML=strHTML_"<IMG  id='COMViewFilterButton' "
        strHTML.set(mOp.Concat(strHTML.get(),"<IMG  id='COMViewFilterButton' "));
        //<< 
        //<< if '$data(^CacheTempHideFilterDescription(YUCI,YUSER,YFORM)) { ;BR014666
        if (mOp.Not(m$.Fnc.$data(m$.var("^CacheTempHideFilterDescription",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.var("YFORM").get())))) {
          //<< set ^CacheTempHideFilterDescription(YUCI,YUSER,YFORM)=$$$COMViewConfigHideFilterDescription(objCOMViewConfig)
          m$.var("^CacheTempHideFilterDescription",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.var("YFORM").get()).set(include.COMConst.$$$COMViewConfigHideFilterDescription(m$,objCOMViewConfig));
        }
        //<< }
        //<< if $get(^CacheTempHideFilterDescription(YUCI,YUSER,YFORM)) {
        if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempHideFilterDescription",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.var("YFORM").get())))) {
          //<< set strHTML=strHTML_"SRC='"_YGIF_"COAexpand.gif' "
          strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"SRC='"),m$.var("YGIF").get()),"COAexpand.gif' "));
          //<< set strTitle=$$$TextSimple("Com00299")                  ;Expand
          strTitle.set(include.COMSYS.$$$TextSimple(m$,"Com00299"));
        }
        //<< } else {
        else {
          //<< set strHTML=strHTML_"SRC='"_YGIF_"COAcollapse.gif' "
          strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"SRC='"),m$.var("YGIF").get()),"COAcollapse.gif' "));
          //<< set strTitle=$$$TextSimple("Com00300")                  ;Collapse
          strTitle.set(include.COMSYS.$$$TextSimple(m$,"Com00300"));
        }
        //<< }
        //<< set strHTML=strHTML_"ALIGN=ABSMIDDLE TITLE="_strTitle_" border=0 "
        strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"ALIGN=ABSMIDDLE TITLE="),strTitle.get())," border=0 "));
        //<< set strHTML=strHTML_"onclick='if (document.getElementById(""COMViewFilter"").style.display==""none"") {"
        strHTML.set(mOp.Concat(strHTML.get(),"onclick='if (document.getElementById(\"COMViewFilter\").style.display==\"none\") {"));
        //<< set strHTML=strHTML_"  document.getElementById(""COMViewFilter"").style.display=""inline"";"
        strHTML.set(mOp.Concat(strHTML.get(),"  document.getElementById(\"COMViewFilter\").style.display=\"inline\";"));
        //<< set strHTML=strHTML_"  with (document.getElementById(""COMViewFilterButton"")) {"
        strHTML.set(mOp.Concat(strHTML.get(),"  with (document.getElementById(\"COMViewFilterButton\")) {"));
        //<< set strHTML=strHTML_"      src="""_YGIF_"COAcollapse.gif"";"
        strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"      src=\""),m$.var("YGIF").get()),"COAcollapse.gif\";"));
        //<< set strHTML=strHTML_"      title="""_$$$TextSimple("Com00300")_""";"   ;Collapse
        strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"      title=\""),include.COMSYS.$$$TextSimple(m$,"Com00300")),"\";"));
        //<< set strHTML=strHTML_"  }"
        strHTML.set(mOp.Concat(strHTML.get(),"  }"));
        //<< set strHTML=strHTML_"  CallBackNow(""SetFilterDescription^COMViewDescription"",document.WWW.YUCI.value,document.WWW.YUSER.value,document.WWW.YFORM.value,""0"");"   ;BR014666
        strHTML.set(mOp.Concat(strHTML.get(),"  CallBackNow(\"SetFilterDescription^COMViewDescription\",document.WWW.YUCI.value,document.WWW.YUSER.value,document.WWW.YFORM.value,\"0\");"));
        //<< set strHTML=strHTML_"} else {"
        strHTML.set(mOp.Concat(strHTML.get(),"} else {"));
        //<< set strHTML=strHTML_"  document.getElementById(""COMViewFilter"").style.display=""none"";"
        strHTML.set(mOp.Concat(strHTML.get(),"  document.getElementById(\"COMViewFilter\").style.display=\"none\";"));
        //<< set strHTML=strHTML_"  with (document.getElementById(""COMViewFilterButton"")) {"
        strHTML.set(mOp.Concat(strHTML.get(),"  with (document.getElementById(\"COMViewFilterButton\")) {"));
        //<< set strHTML=strHTML_"      src="""_YGIF_"COAexpand.gif"";"
        strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"      src=\""),m$.var("YGIF").get()),"COAexpand.gif\";"));
        //<< set strHTML=strHTML_"      title="""_$$$TextSimple("Com00299")_""";"   ;Expand
        strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"      title=\""),include.COMSYS.$$$TextSimple(m$,"Com00299")),"\";"));
        //<< set strHTML=strHTML_"  }"
        strHTML.set(mOp.Concat(strHTML.get(),"  }"));
        //<< set strHTML=strHTML_"  CallBackNow(""SetFilterDescription^COMViewDescription"",document.WWW.YUCI.value,document.WWW.YUSER.value,document.WWW.YFORM.value,""1"");"   ;BR014666
        strHTML.set(mOp.Concat(strHTML.get(),"  CallBackNow(\"SetFilterDescription^COMViewDescription\",document.WWW.YUCI.value,document.WWW.YUSER.value,document.WWW.YFORM.value,\"1\");"));
        //<< set strHTML=strHTML_"}'"
        strHTML.set(mOp.Concat(strHTML.get(),"}'"));
        //<< set strHTML=strHTML_">"
        strHTML.set(mOp.Concat(strHTML.get(),">"));
        //<< set strHTML=strHTML_"<span id='COMViewFilter'"
        strHTML.set(mOp.Concat(strHTML.get(),"<span id='COMViewFilter'"));
        //<< if $get(^CacheTempHideFilterDescription(YUCI,YUSER,YFORM)) {
        if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempHideFilterDescription",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.var("YFORM").get())))) {
          //<< set strHTML=strHTML_"STYLE='DISPLAY:NONE;'"
          strHTML.set(mOp.Concat(strHTML.get(),"STYLE='DISPLAY:NONE;'"));
        }
        //<< }
        //<< set strHTML=strHTML_">"_pstrFilterDescription_"</span>"
        strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),">"),pstrFilterDescription.get()),"</span>"));
      }
    }
    //<< }
    //<< }
    //<< quit strHTML
    return strHTML.get();
  }

  //<< 
  //<< SetFilterDescription(pYUCI,pYUSER,pYFORM,pintValue)
  public Object SetFilterDescription(Object ... _p) {
    mVar pYUCI = m$.newVarRef("pYUCI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYUSER = m$.newVarRef("pYUSER",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintValue = m$.newVarRef("pintValue",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Remember the current users state when refreshing the filter description
    //<< ; (after double clicking to remove conditions)..
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Sep-2007   shobby  SRBR014666: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set ^CacheTempHideFilterDescription(YUCI,YUSER,YFORM)=pintValue
    m$.var("^CacheTempHideFilterDescription",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.var("YFORM").get()).set(pintValue.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< RemoveFixedFilter(pidFilter)
  public Object RemoveFixedFilter(Object ... _p) {
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called to remove a filter from the fixed filters.
    //<< ;
    //<< ; Returns:1
    //<< ;
    //<< ; History:
    //<< ; 06-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< if pidFilter'="" {
    if (mOp.NotEqual(pidFilter.get(),"")) {
      //<< kill ^CacheTempView(YUSER,"FixedFilter",pidFilter)
      m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",pidFilter.get()).kill();
      //<< do Show()
      m$.Cmd.Do("Show");
      //<< do DisplayHeader^COMViewFilterColumn()
      m$.Cmd.Do("COMViewFilterColumn.DisplayHeader");
      //<< do DisplayGrid^COMViewFilter()
      m$.Cmd.Do("COMViewFilter.DisplayGrid");
    }
    //<< }
    //<< quit 1
    return 1;
  }

  //<< 
  //<< 
  //<< GetClassDescription(pidClass="")
  public Object GetClassDescription(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets a class description
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 09-Sep-2008   PP      SR15866:Update COMView to Objects
    //<< ; 15-Jul-2005   shobby  SR12754:Replaced LANGUAGE global (not always reliable)
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new objClass,strDescription
    mVar objClass = m$.var("objClass");
    mVar strDescription = m$.var("strDescription");
    m$.newVar(objClass,strDescription);
    //<< 
    //<< set strDescription = ""
    strDescription.set("");
    //<< if pidClass'="" {
    if (mOp.NotEqual(pidClass.get(),"")) {
      //<< set strDescription = $$$WWW0011ClassDescription($get(^WWW0011(0,pidClass,SPRACHE,1)))
      strDescription.set(include.WWWConst.$$$WWW0011ClassDescription(m$,m$.Fnc.$get(m$.var("^WWW0011",0,pidClass.get(),m$.var("SPRACHE").get(),1))));
      //<< if strDescription="" set strDescription = $$$WWW001ClassDescription($get(^WWW001(0,pidClass,1)))
      if (mOp.Equal(strDescription.get(),"")) {
        strDescription.set(include.WWWConst.$$$WWW001ClassDescription(m$,m$.Fnc.$get(m$.var("^WWW001",0,pidClass.get(),1))));
      }
      //<< 
      //<< //SR15866
      //<< if strDescription="" {
      if (mOp.Equal(strDescription.get(),"")) {
        //<< set objClass = ##class(%Library.ClassDefinition).%OpenId(pidClass)
        objClass.set(m$.fnc$("$Library.ClassDefinition.$OpenId",pidClass.get()));
        //<< if objClass'=$$$NULLOREF {
        if (mOp.NotEqual(objClass.get(),include.$occConstant.$$$NULLOREF(m$))) {
          //<< set strDescription = $translate(objClass.Description,$char(13,10)," ")
          strDescription.set(m$.Fnc.$translate(m$.prop(objClass.get(),"Description").get(),m$.Fnc.$char(13,10)," "));
          //<< if strDescription = "" {
          if (mOp.Equal(strDescription.get(),"")) {
            //<< set strDescription = objClass.Name
            strDescription.set(m$.prop(objClass.get(),"Name").get());
          }
          //<< }
          //<< do objClass.%Close()
          m$.Cmd.Do(objClass.getORef(),"$Close");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strDescription
    return strDescription.get();
  }

  //<< 
  //<< 
  //<< GetDescription(pidClass,pstrFieldType="",pintClassField="")
  public Object GetDescription(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrFieldType = m$.newVarRef("pstrFieldType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pintClassField = m$.newVarRef("pintClassField",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Rewrite of GetDescription
    //<< ;
    //<< ; This procedure is designed to return the relevant field description given a
    //<< ; class and field, source the description from the form definition. This is
    //<< ; since form defs get updated but classes generally will not be.
    //<< ;
    //<< ; Called By:
    //<< ;   COMViewChoose           (case 1)
    //<< ;   COMViewFilterColumn     (case 1 & case 2/3)
    //<< ;   COMViewFilterControl    (case 2/3)
    //<< ;
    //<< ; Inputs:                         case   1)          2)          3)
    //<< ;                                       Form       Field       Calc'n
    //<< ;   pidGlobal       Class ID             *           *           *
    //<< ;   pstrFldTyp      Field Type           -          P/D           C
    //<< ;   pintFldNo       Field Number         -       ClassFld#     CalcNo
    //<< ;
    //<< ; Returns:
    //<< ; case  1)          Form Name (Language based) if field type & number are omitted
    //<< ;       2)          Form or Class name for field (Type "P" or "D")
    //<< ;       3)          Calculated Field Name (Type "C")
    //<< ;
    //<< ; History:
    //<< ; 24-Jun-2008   shobby  SRBR014958: Use standard routine to get calculated field description.
    //<< ; 21-Feb-2008   shobby  SRBR014900: Moved from COMUtilClass.  Keep all the COMView stuff together.
    //<< ; 11-Jan-2008   shobby  SRBR014869: Make sure idForm is not empty before attempting to use it to find form information.
    //<< ; 10-Jan-2008   shobby  SRBR014790: Renamed to avoid the double call.
    //<< ; 10-Jan-2008   GRF     SRBR014790: Added parameter defaults so not missed if
    //<< ;                           renamed
    //<< ; 20-Dec-2007   shobby  SRBR014751: Parameter pidForm no longer required.
    //<< ; 20-Dec-2007   shobby  SRBR014751: Corrected issue referencing WWW003Calc
    //<< ; 19-Dec-2007   shobby  SRBR014751: Rewrite of GetDescription
    //<< ;-------------------------------------------------------------------------------
    //<< new strDescription,intFormField,idClass,idForm
    mVar strDescription = m$.var("strDescription");
    mVar intFormField = m$.var("intFormField");
    mVar idClass = m$.var("idClass");
    mVar idForm = m$.var("idForm");
    m$.newVar(strDescription,intFormField,idClass,idForm);
    //<< 
    //<< set strDescription=""
    strDescription.set("");
    //<< 
    //<< ;---------------------------------------
    //<< ; Try to determine which form should be used to get the description of the field.
    //<< ; Normally this is held in the CacheTempView global.
    //<< ; But if not, try looking in YFORM or assume that the form is the same name as the class.
    //<< ; If we find a valid idForm that still doesn't guarantee that we will find the description
    //<< ; of the field.  So we check various places where it might exist in decreasing order of likely
    //<< ; accuracy.
    //<< ; This may be reviewed later to determine if it is appropriate to just find a value from
    //<< ; anywhere and we may decide that if the value is not found on the 'known' form.
    //<< ;---------------------------------------
    //<< 
    //<< set idForm=$get(^CacheTempView(YUSER,"Form"))
    idForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Form")));
    //<< 
    //<< if (idForm="") || ($$$WWW120ClassUsedInForm($get(^WWW120(0,idForm,1)))'=pidClass) {
    if ((mOp.Equal(idForm.get(),"")) || (mOp.NotEqual(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,idForm.get(),1))),pidClass.get()))) {
      //<< set idForm=$get(YFORM)
      idForm.set(m$.Fnc.$get(m$.var("YFORM")));
      //<< if idForm="" {
      if (mOp.Equal(idForm.get(),"")) {
        //<< set idForm=pidClass
        idForm.set(pidClass.get());
      }
      //<< } elseif $$$WWW120ClassUsedInForm($get(^WWW120(0,idForm,1)))'=pidClass {
      else if (mOp.NotEqual(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,idForm.get(),1))),pidClass.get())) {
        //<< set idForm=pidClass
        idForm.set(pidClass.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< if pstrFieldType      = "M" {                                              ; Case 2 (M)
    if (mOp.Equal(pstrFieldType.get(),"M")) {
      //<< set strDescription = $$^WWWFELDNAME(idForm,pstrFieldType,pintClassField)
      strDescription.set(m$.fnc$("WWWFELDNAME.main",idForm.get(),pstrFieldType.get(),pintClassField.get()));
    }
    //<< 
    //<< 
    //<< } elseif pstrFieldType = "" {                                              ; Case 1
    else if (mOp.Equal(pstrFieldType.get(),"")) {
      //<< set strDescription = $$^WWWFORMNAME(idForm)
      strDescription.set(m$.fnc$("WWWFORMNAME.main",idForm.get()));
    }
    //<< 
    //<< 
    //<< } elseif pstrFieldType = "C" {                                             ; Case 3
    else if (mOp.Equal(pstrFieldType.get(),"C")) {
      //<< set strDescription = $$GetDescription^COMViewCalculatedField(pidClass,pintClassField,SPRACHE)
      strDescription.set(m$.fnc$("COMViewCalculatedField.GetDescription",pidClass.get(),pintClassField.get(),m$.var("SPRACHE").get()));
    }
    //<< 
    //<< } elseif pstrFieldType = "D" {                                             ; Case 2 (D)
    else if (mOp.Equal(pstrFieldType.get(),"D")) {
      //<< ;if idForm'="" {
      //<< ; Look first in the form that we are using.
      //<< set strDescription = $$GetFromWWWFELDNAME^COMUtilClass(pidClass,.idForm,pintClassField,.intFormField,$$$NO)
      strDescription.set(m$.fnc$("COMUtilClass.GetFromWWWFELDNAME",pidClass.get(),idForm,pintClassField.get(),intFormField,include.COMSYS.$$$NO(m$)));
      //<< 
      //<< if ($extract(strDescription,1,5)="_FREE") || (strDescription="") {
      if ((mOp.Equal(m$.Fnc.$extract(strDescription.get(),1,5),"_FREE")) || (mOp.Equal(strDescription.get(),""))) {
        //<< ; If not look in the form that matches the class name
        //<< set idForm         = pidClass
        idForm.set(pidClass.get());
        //<< set strDescription = $$GetFromWWWFELDNAME^COMUtilClass(pidClass,.idForm,pintClassField,.intFormField,$$$NO)
        strDescription.set(m$.fnc$("COMUtilClass.GetFromWWWFELDNAME",pidClass.get(),idForm,pintClassField.get(),intFormField,include.COMSYS.$$$NO(m$)));
      }
      //<< }
      //<< 
      //<< if ($extract(strDescription,1,5)="_FREE") || (strDescription="") {
      if ((mOp.Equal(m$.Fnc.$extract(strDescription.get(),1,5),"_FREE")) || (mOp.Equal(strDescription.get(),""))) {
        //<< ; If not then look in first form that relates to this class
        //<< set idForm         = ""
        idForm.set("");
        //<< set strDescription = $$GetFromWWWFELDNAME^COMUtilClass(pidClass,.idForm,pintClassField,.intFormField,$$$YES)
        strDescription.set(m$.fnc$("COMUtilClass.GetFromWWWFELDNAME",pidClass.get(),idForm,pintClassField.get(),intFormField,include.COMSYS.$$$YES(m$)));
      }
      //<< }
      //<< 
      //<< if ($extract(strDescription,1,5)="_FREE") || (strDescription="") {
      if ((mOp.Equal(m$.Fnc.$extract(strDescription.get(),1,5),"_FREE")) || (mOp.Equal(strDescription.get(),""))) {
        //<< ; Ok.  We didn't find anything useful so lets go back to the form that matches the class name
        //<< ; and we will accept _FREE at this point.
        //<< ; Not sure whether it is better to show _FREE fields that haven't been customised or just
        //<< ; leave them hidden.
        //<< set idForm       = pidClass
        idForm.set(pidClass.get());
        //<< set intFormField = $order(^WWW122s(0,4,pintClassField,idForm,""))
        intFormField.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,pintClassField.get(),idForm.get(),"")));
        //<< if intFormField'="" {
        if (mOp.NotEqual(intFormField.get(),"")) {
          //<< set strDescription = $$^WWWFELDNAME(idForm,"D",pintClassField)
          strDescription.set(m$.fnc$("WWWFELDNAME.main",idForm.get(),"D",pintClassField.get()));
        }
        //<< 
        //<< } else {  ; If not then let's just get something from the class.
        else {
          //<< set idForm         = "*none*"
          idForm.set("*none*");
          //<< set strDescription = $get(^WWW0031(0,pidClass,pintClassField,SPRACHE,1))
          strDescription.set(m$.Fnc.$get(m$.var("^WWW0031",0,pidClass.get(),pintClassField.get(),m$.var("SPRACHE").get(),1)));
          //<< if strDescription="" set strDescription = $$$WWW003PropertyDescription($get(^WWW003(0,pidClass,pintClassField,1)))
          if (mOp.Equal(strDescription.get(),"")) {
            strDescription.set(include.WWWConst.$$$WWW003PropertyDescription(m$,m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),pintClassField.get(),1))));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< ;  First attempt.  A lot shorter but the code above does a more detailed search.
    //<< ;  Not sure if we do really want to go searching all over the place.
    //<< ;
    //<< ;set intFormField=""
    //<< ;set intFormField=$order(^WWW122s(0,4,pintClassField,idForm,""))
    //<< ;if intFormField="" {
    //<< ;   set idForm=idClass
    //<< ;   set intFormField=$order(^WWW122s(0,4,pintClassField,idForm,""))
    //<< ;}
    //<< ;if intFormField'="" {
    //<< ;   set strDescription=$$^WWWFELDNAME(idForm,"D",pintClassField)
    //<< ;} else {
    //<< ;   ; Get it from the class
    //<< ;   set strDescription=$get(^WWW0031(0,idClass,pintClassField,SPRACHE,1))
    //<< ;   if strDescription="" set strDescription=$$$WWW003PropertyDescription($get(^WWW003(0,idClass,pintClassField,1)))
    //<< ;}
    //<< ;}
    //<< 
    //<< 
    //<< } elseif pstrFieldType="P" {                                               ; Case 2 (P)
    else if (mOp.Equal(pstrFieldType.get(),"P")) {
      //<< ;Primary key.  Form field and classfield always the same
      //<< if idForm'="" {
      if (mOp.NotEqual(idForm.get(),"")) {
        //<< set intFormField   = pintClassField
        intFormField.set(pintClassField.get());
        //<< set strDescription = $$^WWWFELDNAME(idForm,"P",pintClassField)
        strDescription.set(m$.fnc$("WWWFELDNAME.main",idForm.get(),"P",pintClassField.get()));
      }
    }
    //<< 
    //<< }
    //<< }
    //<< if $$$COMViewConfigFieldDebug($get(^COMViewConfig(0,YM,1))) {
    if (mOp.Logical(include.COMConst.$$$COMViewConfigFieldDebug(m$,m$.Fnc.$get(m$.var("^COMViewConfig",0,m$.var("YM").get(),1))))) {
      //<< ; Some debugging information if we are trying to work out where the text came from
      //<< set strDescription = idForm_"/"_pidClass_"("_$get(pstrFieldType)_":C"_$get(pintClassField)_":F"_$get(intFormField)_"):"_strDescription
      strDescription.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idForm.get(),"/"),pidClass.get()),"("),m$.Fnc.$get(pstrFieldType)),":C"),m$.Fnc.$get(pintClassField)),":F"),m$.Fnc.$get(intFormField)),"):"),strDescription.get()));
    }
    //<< }
    //<< 
    //<< quit strDescription
    return strDescription.get();
  }

  //<< 
  //<< 
  //<< GetCOMViewHeaderColors(&COLOR,&COLORR)
  public Object GetCOMViewHeaderColors(Object ... _p) {
    mVar COLOR = m$.newVarRef("COLOR",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar COLORR = m$.newVarRef("COLORR",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the Colors for the Header Line
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Dec-2009   PPP     SR17069: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $get(YVOR1) = "" set YVOR1 = $get(^WWW012(0,0,1))
    if (mOp.Equal(m$.Fnc.$get(m$.var("YVOR1")),"")) {
      mVar YVOR1 = m$.var("YVOR1");
      YVOR1.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
    }
    //<< 
    //<< set COLOR  = $$$SysEnum("FARBE",$$$WWW012ColorCodeForHeaderLeft(YVOR1))
    COLOR.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012ColorCodeForHeaderLeft(m$,m$.var("YVOR1"))));
    //<< if COLOR="" set COLOR = "DIMGRAY"
    if (mOp.Equal(COLOR.get(),"")) {
      COLOR.set("DIMGRAY");
    }
    //<< 
    //<< set COLORR = $$$SysEnum("FARBE",$$$WWW012ColorCodeForHeaderRight(YVOR1))
    COLORR.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012ColorCodeForHeaderRight(m$,m$.var("YVOR1"))));
    //<< if COLORR="" set COLORR = COLOR
    if (mOp.Equal(COLORR.get(),"")) {
      COLORR.set(COLOR.get());
    }
    //<< 
    //<< if $get(YLOCATION)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLOCATION")),"")) {
      //<< set objLocn = $get(^WWW0121(0,0,YLOCATION,1))
      mVar objLocn = m$.var("objLocn");
      objLocn.set(m$.Fnc.$get(m$.var("^WWW0121",0,0,m$.var("YLOCATION").get(),1)));
      //<< if +$$$WWW0121ColorTableHeader(objLocn)'=0 {
      if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW0121ColorTableHeader(m$,objLocn)),0)) {
        //<< set (COLOR,COLORR)  = $$$SysEnum("FARBE",+$$$WWW0121ColorTableHeader(objLocn))
        COLOR.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",mOp.Positive(include.WWWConst.$$$WWW0121ColorTableHeader(m$,objLocn))));
        COLORR.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",mOp.Positive(include.WWWConst.$$$WWW0121ColorTableHeader(m$,objLocn))));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetClassForForm(pidForm="")
  public Object GetClassForForm(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the Colors for the Header Line
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Dec-2009   PPP     SR17069: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set idClass=""
    mVar idClass = m$.var("idClass");
    idClass.set("");
    //<< 
    //<< if $get(pidForm)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidForm),"")) {
      //<< set idClass = $$$WWW120ClassUsedInForm($get(^WWW120(0,pidForm,1)))
      idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1))));
    }
    //<< }
    //<< 
    //<< quit idClass
    return idClass.get();
  }

//<< 
//<< 
}
