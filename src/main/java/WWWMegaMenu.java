//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMegaMenu
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-04 15:00:23
//*****************************************************************************

import mLibrary.*;
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

//<< WWWMegaMenu
public class WWWMegaMenu extends mClass {

  public void main() {
    _WWWMegaMenu();
  }

  public void _WWWMegaMenu() {
  }

  //<< 
  //<< ; Notes
  //<< ;   - Refer to WWWMENU4
  //<< ;   - aplatz.gif
  //<< 
  //<< EVENT(YINHALT,YVAR)
  public Object EVENT(Object ... _p) {
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YVAR = m$.newVarRef("YVAR",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Entry point for events called from the front end.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< if YINHALT="GETSUBMENU"        quit $$GetSubMenu^WWWMegaMenuFullMenu($piece(YVAR,":",1),$piece(YVAR,":",2))
    if (mOp.Equal(YINHALT.get(),"GETSUBMENU")) {
      return m$.fnc$("WWWMegaMenuFullMenu.GetSubMenu",m$.Fnc.$piece(YVAR.get(),":",1),m$.Fnc.$piece(YVAR.get(),":",2));
    }
    //<< if YINHALT="OPENMENU"          quit $$OpenMenu^WWWMegaMenuFullMenu(YVAR)
    if (mOp.Equal(YINHALT.get(),"OPENMENU")) {
      return m$.fnc$("WWWMegaMenuFullMenu.OpenMenu",YVAR.get());
    }
    //<< if YINHALT="CLOSEMENU"         quit $$CloseMenu^WWWMegaMenuFullMenu(YVAR)
    if (mOp.Equal(YINHALT.get(),"CLOSEMENU")) {
      return m$.fnc$("WWWMegaMenuFullMenu.CloseMenu",YVAR.get());
    }
    //<< if YINHALT="GETMRU_INTERNAL"   quit $$GetMRUMenuInternal^WWWMegaMenuMRU()
    if (mOp.Equal(YINHALT.get(),"GETMRU_INTERNAL")) {
      return m$.fnc$("WWWMegaMenuMRU.GetMRUMenuInternal");
    }
    //<< if YINHALT="GETMRU_ITEMS"      quit $$GetMRUItems^WWWMegaMenuMRU(YVAR)
    if (mOp.Equal(YINHALT.get(),"GETMRU_ITEMS")) {
      return m$.fnc$("WWWMegaMenuMRU.GetMRUItems",YVAR.get());
    }
    //<< if YINHALT="GETFULL_INTERNAL"  quit $$GetFullMenuInternal^WWWMegaMenuFullMenu()
    if (mOp.Equal(YINHALT.get(),"GETFULL_INTERNAL")) {
      return m$.fnc$("WWWMegaMenuFullMenu.GetFullMenuInternal");
    }
    
    throw new IllegalArgumentException("Default value was not implemented.");
  }

  //<< 
  //<< GetMegaMenu(YKOPF,pblnCreateJavascript=$$$NO) ;SR17998
  public Object GetMegaMenu(Object ... _p) {
    mVar YKOPF = m$.newVarRef("YKOPF",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnCreateJavascript = m$.newVarRef("pblnCreateJavascript",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Displays the MegaMenu
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-May-2013   shobby  CORE-107.2: Include javascript for MANU forms.
    //<< ; 22-May-2013   shobby  CORE-107.4: Rewrote to put form and MenuType test inside routine. Moved from WWWKOPF
    //<< ;-------------------------------------------------------------------------------
    //<< if ($$$WWW013MenuType($get(^WWW013(0,YBED,1)))=13)&&(YFORM'="")&&($$$WWW120FormType($get(^WWW120(0,YFORM,1)))'=12) {
    if ((mOp.Equal(include.WWWConst.$$$WWW013MenuType(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))),13)) && (mOp.NotEqual(m$.var("YFORM").get(),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1))),12))) {
      //<< if (($get(YPOPUP)'=1)||(YFORM'="COMViewSearch"))&&(YFORM'="WWWPARA")&&(YFORM'="WWWCAL2") {
      if (mOp.Logical(((mOp.NotEqual(m$.Fnc.$get(m$.var("YPOPUP")),1)) || (mOp.NotEqual(m$.var("YFORM").get(),"COMViewSearch")))) && (mOp.NotEqual(m$.var("YFORM").get(),"WWWPARA")) && (mOp.NotEqual(m$.var("YFORM").get(),"WWWCAL2"))) {
        //<< if pblnCreateJavascript do ^WWWFORM8 ; some forms don't have the javascript yet.  eg MANU^WWWBODY ;CORE-107.2
        if (mOp.Logical(pblnCreateJavascript.get())) {
          m$.Cmd.Do("WWWFORM8.main");
        }
        //<< do Create^WWWMegaMenu(YKOPF)
        m$.Cmd.Do("WWWMegaMenu.Create",YKOPF.get());
      }
    }
    //<< }
    //<< }
    //<< quit ""
    return "";
  }

  //<< 
  //<< Create(YKOPF)
  public Object Create(Object ... _p) {
    mVar YKOPF = m$.newVarRef("YKOPF",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Entry point for creating Mega Menu
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-May-2012   shobby      CORE-81: Remove blinking menu.  There is another indicator for this now.
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;write "<!DOCTYPE html PUBLIC ""-//W3C//DTD XHTML 1.0 Transitional//EN"" ""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"">"
    //<< write "<style type='text/css'>"
    m$.Cmd.Write("<style type='text/css'>");
    //<< ;write "body {behavior: url("""_YGIF_"csshover3.htc"");}"
    //<< write "menu li .drop {background:url(""img/drop.gif"") no-repeat right 8px; "
    m$.Cmd.Write("menu li .drop {background:url(\"img/drop.gif\") no-repeat right 8px; ");
    //<< write "</style>"
    m$.Cmd.Write("</style>");
    //<< do DisplayStyle^WWWMenuOverview()
    m$.Cmd.Do("WWWMenuOverview.DisplayStyle");
    //<< ;new YEVENT
    //<< ;set YEVENT=1
    //<< ;do EVENTCALL^WWWFORM8
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< 
    //<< ;CORE-81 ;if YUSERAGENT="MSIE" {
    //<< ;CORE-81    if '$$AllChecks^WWWDASHBOARD() {
    //<< ;CORE-81        write "function menustartblink() {"
    //<< ;CORE-81        write "  var obj=document.getElementById('menublink');"
    //<< ;CORE-81        write "  if (obj.style.color!='red') {"
    //<< ;CORE-81        write "    obj.style.color='red';"
    //<< ;CORE-81        write "  } else {"
    //<< ;CORE-81        write "    obj.style.color='white';"
    //<< ;CORE-81        write "  }"
    //<< ;CORE-81        write "  window.setTimeout('menustartblink()',1000);"
    //<< ;CORE-81        write "}"
    //<< ;CORE-81        write "window.setTimeout('menustartblink()',1000);;"
    //<< ;CORE-81    }
    //<< ;CORE-81 ;}
    //<< 
    //<< write "var GMENU='';"
    m$.Cmd.Write("var GMENU='';");
    //<< do Javascript()
    m$.Cmd.Do("Javascript");
    //<< do Javascript^WWWMegaMenuFullMenu()
    m$.Cmd.Do("WWWMegaMenuFullMenu.Javascript");
    //<< do Javascript^WWWMegaMenuMRU()
    m$.Cmd.Do("WWWMegaMenuMRU.Javascript");
    //<< 
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< do Body(YKOPF)
    m$.Cmd.Do("Body",YKOPF.get());
    //<< quit
    return null;
  }

  //<< 
  //<< EventValue()
  public Object EventValue(Object ... _p) {
    //<< ; 31-Jul-2012   shobby  SR18075: Preserve SPRACHE in new field
    //<< 
    //<< write "function EventValue(Namespace,User,Form,Fixkey,Field,Value,Funct,LocalVar,Tab) {",YCR
    m$.Cmd.Write("function EventValue(Namespace,User,Form,Fixkey,Field,Value,Funct,LocalVar,Tab) {",m$.var("YCR").get());
    //<< ;---------------------------------------
    //<< ; FIXME : check validity of the following nesting
    //<< ;         YEVENT = 1
    //<< ;               function EventValue() {
    //<< ;                   ...  ; version 1
    //<< ;                   function UpdateFieldFormat, PrepareUpdate, ResetFieldFormat
    //<< ;               }
    //<< ;
    //<< ;         YEVENT = 0
    //<< ;               function EventValue() {
    //<< ;                   ...  ; version 0
    //<< ;               }
    //<< ;               function UpdateFieldFormat, PrepareUpdate, ResetFieldFormat
    //<< ;
    //<< ;         should YEVENT = 0 case be an else with the other 3 functions also positioned
    //<< ;         outside the EventValue function?  <GRF>
    //<< ;---------------------------------------
    //<< 
    //<< ;======================================= vvv
    //<< ;if $get(YEVENT)=1 {  ;FUNKTION FÜR EVENTBROKER ;to
    //<< write "  var retval;"
    m$.Cmd.Write("  var retval;");
    //<< if $find($zversion,"Windows") {               ;only for Windows, not for LINUX
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$zversion(),"Windows"))) {
      //<< write "  var von = /"_$char(128)_"/g;"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("  var von = /",m$.Fnc.$char(128)),"/g;"));
      //<< write "  var nach = ""&euro;"";"        ; euro in eurozeichen umwandeln bei csp
      m$.Cmd.Write("  var nach = \"&euro;\";");
      //<< write "  if (Value != false) { if (Value != true) Value=Value.replace(von,nach);}"
      m$.Cmd.Write("  if (Value != false) { if (Value != true) Value=Value.replace(von,nach);}");
    }
    //<< }
    //<< if +$get(YHYPER)=0 {           ; eventbroker
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),0)) {
      //<< ;SR18075 write "  retval = document.WebLink.CacheMethod("""_$get(%KEY("MGWCHD"))_""", Namespace + ""."" + User + ""."" + Form + ""."" + Field + ""."" + Funct + ""."" + Fixkey +""."" + LocalVar, Value);"
      //<< write "  retval = document.WebLink.CacheMethod("""_$get(%KEY("MGWCHD"))_""", Namespace + ""."" + User + ""."" + Form + ""."" + Field + ""."" + Funct + ""."" + Fixkey + "".""  + """_SPRACHE_""" + ""."" + LocalVar, Value);"  ;SR18075
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  retval = document.WebLink.CacheMethod(\"",m$.Fnc.$get(m$.var("%KEY","MGWCHD"))),"\", Namespace + \".\" + User + \".\" + Form + \".\" + Field + \".\" + Funct + \".\" + Fixkey + \".\"  + \""),m$.var("SPRACHE").get()),"\" + \".\" + LocalVar, Value);"));
    }
    //<< } elseif +$get(YHYPER)=1 {     ; HyperEvent
    else if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),1)) {
      //<< ;SR18075 write "  Para=Namespace + ""."" + User + ""."" + Form + ""."" + Field + ""."" + Funct + ""."" + Fixkey + ""."" + LocalVar +""."" ;"  ;SR18075
      //<< write "  Para=Namespace + ""."" + User + ""."" + Form + ""."" + Field + ""."" + Funct + ""."" + Fixkey + ""."" + """_SPRACHE_""" +""."" + LocalVar  ;"  ;SR18075
      m$.Cmd.Write(mOp.Concat(mOp.Concat("  Para=Namespace + \".\" + User + \".\" + Form + \".\" + Field + \".\" + Funct + \".\" + Fixkey + \".\" + \"",m$.var("SPRACHE").get()),"\" +\".\" + LocalVar  ;"));
      //<< write "  retval = "_$get(%(YQUERY,"HYPER"))_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("  retval = ",m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"HYPER"))),";"));
    }
    //<< }
    //<< write "  if (retval != null) { "
    m$.Cmd.Write("  if (retval != null) { ");
    //<< write "    retval=retval.replace(/'/g,String.fromCharCode(10,13));"
    m$.Cmd.Write("    retval=retval.replace(/'/g,String.fromCharCode(10,13));");
    //<< write "    retval=retval.replace(/`/g,'\'');"
    m$.Cmd.Write("    retval=retval.replace(/`/g,'\\'');");
    //<< write "  } "
    m$.Cmd.Write("  } ");
    //<< 
    //<< write "  var htmform = '"_YHTMFORM_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("  var htmform = '",m$.var("YHTMFORM").get()),"';"));
    //<< write "  if (retval != null) retval=retvalcheck(retval,Value,Funct,Field,htmform);"
    m$.Cmd.Write("  if (retval != null) retval=retvalcheck(retval,Value,Funct,Field,htmform);");
    //<< write "  return(retval);"
    m$.Cmd.Write("  return(retval);");
    //<< write "}"
    m$.Cmd.Write("}");
    //<< ;}
    //<< quit
    return null;
  }

  //<< 
  //<< Javascript()
  public Object Javascript(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Javascript functions to support menu operation
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Jun-2013   shobby      CORE-113: Firefox now uses code to show and hide menus rather than CSS file.
    //<< ;                                     Code allows greater control over positioning.
    //<< ; 07-Jun-2013   shobby      CORE-123: Hide and Show report when MegaMenu is displayed.
    //<< ; 07-Jun-2013   shobby      CORE-123: Removed class change to 'drop lia'
    //<< ; 27-May-2013   shobby      CORE-81: Removed some text shadowing.
    //<< ; 13-May-2013   shobby      CORE-100: Prevent displaying two mega menus.
    //<< ; 28-Aug-2012   shobby      SR17998: Don't popup menu if user has already moved out. (menumouseout)
    //<< ; 20-Jun-2012   shobby      SR17998: Introduced a small delay so menus don't keeping
    //<< ;                               popping up while mouse is heading towards buttons etc.
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< do EventValue()
    m$.Cmd.Do("EventValue");
    //<< ;&html<
    //<< ;   <style>
    //<< ;   </style>
    //<< ;>
    //<< 
    //<< ;CORE-100 vvv
    //<< &js<
    //<< var objMenu=document.getElementById('MegaMenu');
    //<< if (objMenu!=null) {
    //<< var objParent=objMenu.parentNode;
    //<< if (objParent!=null) {
    //<< objParent.removeChild(objMenu);
    //<< }
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("    var objMenu=document.getElementById('MegaMenu');","\n");
    m$.Cmd.WriteJS("    if (objMenu!=null) {","\n");
    m$.Cmd.WriteJS("        var objParent=objMenu.parentNode;","\n");
    m$.Cmd.WriteJS("        if (objParent!=null) {","\n");
    m$.Cmd.WriteJS("            objParent.removeChild(objMenu);","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ");
    //<< ;CORE-100 ^^^
    //<< 
    //<< 
    //<< &js<
    //<< var menustart=false;
    //<< var menutimeout;
    //<< 
    //<< function menumouseout(pobj) {
    //<< //menustart=false;
    //<< window.clearTimeout(menutimeout);
    //<< }
    //<< function menuOpen(pobj) {
    //<< if (pobj==null) {
    //<< var e=e||window.event;
    //<< var obj=e.target||e.srcElement;
    //<< } else {
    //<< var obj=pobj;
    //<< }
    //<< //alert('open='+obj.id+':'+window.event.target);
    //<< menustart=obj.id;
    //<< window.clearTimeout(menutimeout);
    //<< menutimeout=window.setTimeout(function() {menuOpenEx(obj);},200);
    //<< window.event.cancelBubble=true;
    //<< window.event.returnValue=false;
    //<< return false;
    //<< }
    //<< 
    //<< function menuOpenEx(obj) {
    //<< if (obj!=null) {
    //<< if (obj.id=='menu') {
    //<< menustart=false;
    //<< //menuclose();
    //<< } else {
    //<< //window.clearTimeout(menutimeout);
    //<< //if (menustart==obj.id) {
    //<< if (obj.tagName.toLowerCase()!='li') { obj=getParent(obj,'li');}
    //<< if (obj!=null) {
    //<< var id=obj.id;
    //<< var i=id.split('_')[1];
    //<< if (i!=undefined) {
    //<< var obj1=document.getElementById('menuDiv_'+i);
    //<< if (obj1!=null) {
    //<< if (GMENU!=i) menuclose();
    //<< GMENU=i;
    //<< if (obj1.innerHTML.replace(/ /g,'')=='') {
    //<< //var retval = EventValue('#(YUCI)#','#(YUSER)#','#(YFORM)#','FIX','EVENT^WWWMegaMenu','GETMRU_INTERNAL','6',i);
    //<< var retval = EventValue('#(YUCI)#','#(YUSER)#','#(YFORM)#','FIX','EVENT^WWWMegaMenu',obj1.getAttribute('_CallBack'),'6',i);
    //<< if (retval!='') {
    //<< document.getElementById('menuDiv_'+i).outerHTML=retval;
    //<< setMenuHeight(i);
    //<< //following works but gives an error.
    //<< obj1=document.getElementById('menuDiv_'+i);
    //<< //obj1.parentNode=document.getElementById('menuLi_'+i);
    //<< document.getElementById('menuLi_'+i).appendChild(obj1);
    //<< 
    //<< }
    //<< }
    //<< setMenuHeight(i);
    //<< if ( document.getElementById('iFrameReport') != null ) {                    //CORE-123
    //<< //VAR report temporary solution                                         //CORE-123
    //<< document.getElementById('iFrameReport').style.visibility = 'hidden'; //CORE-123
    //<< }                                                                           //CORE-123
    //<< obj1.style.left=menuPosition(obj1);
    //<< obj1.style.left=menuPosition(obj1);
    //<< document.getElementById('menuA_'+i).style.color='#161616';
    //<< document.getElementById('menuLi_'+i).className=document.getElementById('menuLi_'+i).getAttribute('hclass');
    //<< }
    //<< }
    //<< }
    //<< //}
    //<< }
    //<< }
    //<< collector(false);
    //<< //if (e) {
    //<< //    e.stopPropagation();
    //<< //    e.preventDefault();
    //<< //} else {
    //<< //  window.event.cancelBubble=true;
    //<< //window.event.returnValue=false;
    //<< //}
    //<< return false;
    //<< }
    //<< function setMenuHeight(i) {
    //<< var objMenuContents=document.getElementById('menucontents_'+i);
    //<< if (objMenuContents!=null) {
    //<< if (isIE()) {
    //<< objMenuContents.style.height=Math.max(0,Math.min(objMenuContents.scrollHeight,document.body.offsetHeight-150));
    //<< } else {
    //<< objMenuContents.style.height=Math.max(0,Math.min(objMenuContents.scrollHeight,window.innerHeight-150));
    //<< }
    //<< }
    //<< }
    //<< 
    //<< function getParent(el, pTagName) {
    //<< if (el == null) return null;
    //<< else if (el.nodeType == 1 && el.tagName.toLowerCase() == pTagName.toLowerCase())
    //<< return el;
    //<< else
    //<< return getParent(el.parentNode, pTagName);
    //<< }
    //<< 
    //<< function IsIn(obj) {
    //<< function GetX(obj) {
    //<< var x=obj.offsetLeft;
    //<< if (obj.offsetParent != null) x += GetX(obj.offsetParent);
    //<< return x;
    //<< }
    //<< function GetY(obj) {
    //<< var y=obj.offsetTop;
    //<< if (obj.offsetParent != null) y += GetY(obj.offsetParent);
    //<< return y;
    //<< }
    //<< 
    //<< var result=false;
    //<< if (obj!=undefined) {
    //<< var left  =GetX(obj);
    //<< var top   =GetY(obj);
    //<< var right =left+obj.offsetWidth;
    //<< var bottom=top+obj.offsetHeight;
    //<< 
    //<< result= !((event.clientX<left)||(event.clientX>right)||(event.clientY<top)||(event.clientY>bottom));
    //<< }
    //<< return result;
    //<< }
    //<< 
    //<< function getPageOffsetLeft(Object) {
    //<< var x=Object.offsetLeft;
    //<< if ((Object.offsetParent != null)&&(Object.style.position !='absolute')) x += getPageOffsetLeft(Object.offsetParent);
    //<< return x;
    //<< }
    //<< function getPageOffsetTop(Object) {
    //<< var y=Object.offsetTop;
    //<< if ((Object.offsetParent != null)&&(Object.style.position !='absolute')) y += getPageOffsetTop(Object.offsetParent);
    //<< return y;
    //<< }
    //<< function menuPosition(pobj) {
    //<< var intOverhang=document.getElementById('menu').offsetWidth-(getPageOffsetLeft(pobj.parentNode)+pobj.offsetWidth);
    //<< //alert(document.getElementById('menu').offsetWidth+':'+getPageOffsetLeft(pobj.parentNode)+':'+pobj.offsetWidth+':'+pobj.clientWidth+'::'+pobj.id+'::'+pobj.style.display+'::'+pobj.width);
    //<< if (intOverhang&gt;-1) {
    //<< intOverhang=-1;
    //<< }
    //<< return intOverhang+'px' ;
    //<< }
    //<< function collector(pHide) {
    //<< var obj=document.getElementById('eventcollector');
    //<< 
    //<< if (obj!=undefined) {
    //<< if (pHide) {
    //<< obj.style.top='-100000px';
    //<< obj.style.width='0px';
    //<< obj.style.height='0px';
    //<< } else {
    //<< obj.style.top='43px';
    //<< obj.style.width=(document.body.clientWidth)+'px';
    //<< obj.style.height=(document.body.clientHeight-3-obj.offsetTop)+'px';
    //<< //obj.style.border='3px solid yellow';
    //<< }
    //<< }
    //<< }
    //<< 
    //<< function menuclose() {
    //<< if ( document.getElementById('iFrameReport') != null ) {                  //CORE-123
    //<< //VAR report temporary solution                                         //CORE-123
    //<< document.getElementById('iFrameReport').style.visibility = 'visible';   //CORE-123
    //<< }                                                                         //CORE-123
    //<< var i=GMENU;
    //<< if (document.getElementById('mrulist')!=null) document.getElementById('mrulist').style.display='none';
    //<< if (i!=undefined) {
    //<< //document.getElementById('menuDiv_'+i).releaseCapture();
    //<< if (document.getElementById('menuDiv_'+i)!=null) {
    //<< document.getElementById('menuDiv_'+i).style.left='-100000px';
    //<< // document.getElementById('menuLi_'+i).className='';
    //<< document.getElementById('menuLi_'+i).className=document.getElementById('menuLi_'+i).getAttribute('zclass');
    //<< with (document.getElementById('menuA_'+i).style) {
    //<< color='#EEEEEE';
    //<< }
    //<< //document.getElementById('menuLi_'+i).className='li';
    //<< //document.getElementById('menuLi_'+i).className=document.getElementById('menuLi_'+i).getAttribute('zclass');
    //<< //CORE-81 with (document.getElementById('menuLi_'+i).style) {
    //<< //CORE-81      padding='4px 10px 4px 10px';
    //<< //CORE-81    border='none';
    //<< //CORE-81        background='';
    //<< //CORE-81 }
    //<< }
    //<< }
    //<< collector(true);
    //<< return false;
    //<< }
    //<< 
    //<< 
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("    var menustart=false;","\n");
    m$.Cmd.WriteJS("    var menutimeout;","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    function menumouseout(pobj) {","\n");
    m$.Cmd.WriteJS("        //menustart=false;","\n");
    m$.Cmd.WriteJS("        window.clearTimeout(menutimeout);","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function menuOpen(pobj) {","\n");
    m$.Cmd.WriteJS("        if (pobj==null) {           ","\n");
    m$.Cmd.WriteJS("            var e=e||window.event;","\n");
    m$.Cmd.WriteJS("            var obj=e.target||e.srcElement;","\n");
    m$.Cmd.WriteJS("        } else {","\n");
    m$.Cmd.WriteJS("            var obj=pobj;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        //alert('open='+obj.id+':'+window.event.target);","\n");
    m$.Cmd.WriteJS("        menustart=obj.id;","\n");
    m$.Cmd.WriteJS("        window.clearTimeout(menutimeout);","\n");
    m$.Cmd.WriteJS("        menutimeout=window.setTimeout(function() {menuOpenEx(obj);},200);","\n");
    m$.Cmd.WriteJS("        window.event.cancelBubble=true;","\n");
    m$.Cmd.WriteJS("        window.event.returnValue=false;","\n");
    m$.Cmd.WriteJS("        return false;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function menuOpenEx(obj) {","\n");
    m$.Cmd.WriteJS("        if (obj!=null) {","\n");
    m$.Cmd.WriteJS("            if (obj.id=='menu') {","\n");
    m$.Cmd.WriteJS("                menustart=false;","\n");
    m$.Cmd.WriteJS("                //menuclose();","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                //window.clearTimeout(menutimeout);","\n");
    m$.Cmd.WriteJS("                //if (menustart==obj.id) {","\n");
    m$.Cmd.WriteJS("                    if (obj.tagName.toLowerCase()!='li') { obj=getParent(obj,'li');}","\n");
    m$.Cmd.WriteJS("                    if (obj!=null) {","\n");
    m$.Cmd.WriteJS("                        var id=obj.id;","\n");
    m$.Cmd.WriteJS("                        var i=id.split('_')[1];","\n");
    m$.Cmd.WriteJS("                        if (i!=undefined) {","\n");
    m$.Cmd.WriteJS("                            var obj1=document.getElementById('menuDiv_'+i);","\n");
    m$.Cmd.WriteJS("                            if (obj1!=null) {","\n");
    m$.Cmd.WriteJS("                                if (GMENU!=i) menuclose();","\n");
    m$.Cmd.WriteJS("                                GMENU=i;","\n");
    m$.Cmd.WriteJS("                                if (obj1.innerHTML.replace(/ /g,'')=='') {","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                                    //var retval = EventValue('",(m$.var("YUCI").get())),"','"),(m$.var("YUSER").get())),"','"),(m$.var("YFORM").get())),"','FIX','EVENT^WWWMegaMenu','GETMRU_INTERNAL','6',i);"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                                    var retval = EventValue('",(m$.var("YUCI").get())),"','"),(m$.var("YUSER").get())),"','"),(m$.var("YFORM").get())),"','FIX','EVENT^WWWMegaMenu',obj1.getAttribute('_CallBack'),'6',i);"),"\n");
    m$.Cmd.WriteJS("                                    if (retval!='') {","\n");
    m$.Cmd.WriteJS("                                        document.getElementById('menuDiv_'+i).outerHTML=retval;","\n");
    m$.Cmd.WriteJS("                                        setMenuHeight(i);","\n");
    m$.Cmd.WriteJS("                                        //following works but gives an error.","\n");
    m$.Cmd.WriteJS("                                        obj1=document.getElementById('menuDiv_'+i);","\n");
    m$.Cmd.WriteJS("                                        //obj1.parentNode=document.getElementById('menuLi_'+i);","\n");
    m$.Cmd.WriteJS("                                        document.getElementById('menuLi_'+i).appendChild(obj1);","\n");
    m$.Cmd.WriteJS("                                    ","\n");
    m$.Cmd.WriteJS("                                    }","\n");
    m$.Cmd.WriteJS("                                }","\n");
    m$.Cmd.WriteJS("                                setMenuHeight(i);","\n");
    m$.Cmd.WriteJS("                                if ( document.getElementById('iFrameReport') != null ) {                    //CORE-123","\n");
    m$.Cmd.WriteJS("                                    //VAR report temporary solution                                         //CORE-123","\n");
    m$.Cmd.WriteJS("                                    document.getElementById('iFrameReport').style.visibility = 'hidden'; //CORE-123","\n");
    m$.Cmd.WriteJS("                                }                                                                           //CORE-123","\n");
    m$.Cmd.WriteJS("                                obj1.style.left=menuPosition(obj1);","\n");
    m$.Cmd.WriteJS("                                obj1.style.left=menuPosition(obj1);","\n");
    m$.Cmd.WriteJS("                                document.getElementById('menuA_'+i).style.color='#161616';","\n");
    m$.Cmd.WriteJS("                                document.getElementById('menuLi_'+i).className=document.getElementById('menuLi_'+i).getAttribute('hclass');","\n");
    m$.Cmd.WriteJS("                            }","\n");
    m$.Cmd.WriteJS("                        }","\n");
    m$.Cmd.WriteJS("                    }","\n");
    m$.Cmd.WriteJS("                //}","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("          collector(false);","\n");
    m$.Cmd.WriteJS("          //if (e) {","\n");
    m$.Cmd.WriteJS("        //    e.stopPropagation();","\n");
    m$.Cmd.WriteJS("        //    e.preventDefault();","\n");
    m$.Cmd.WriteJS("          //} else {","\n");
    m$.Cmd.WriteJS("            //  window.event.cancelBubble=true;","\n");
    m$.Cmd.WriteJS("              //window.event.returnValue=false;","\n");
    m$.Cmd.WriteJS("          //}","\n");
    m$.Cmd.WriteJS("          return false;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function setMenuHeight(i) {","\n");
    m$.Cmd.WriteJS("      var objMenuContents=document.getElementById('menucontents_'+i);","\n");
    m$.Cmd.WriteJS("      if (objMenuContents!=null) {","\n");
    m$.Cmd.WriteJS("          if (isIE()) {","\n");
    m$.Cmd.WriteJS("              objMenuContents.style.height=Math.max(0,Math.min(objMenuContents.scrollHeight,document.body.offsetHeight-150));","\n");
    m$.Cmd.WriteJS("          } else {","\n");
    m$.Cmd.WriteJS("              objMenuContents.style.height=Math.max(0,Math.min(objMenuContents.scrollHeight,window.innerHeight-150));","\n");
    m$.Cmd.WriteJS("          }","\n");
    m$.Cmd.WriteJS("      }","\n");
    m$.Cmd.WriteJS("    } ","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("    function getParent(el, pTagName) {","\n");
    m$.Cmd.WriteJS("        if (el == null) return null;","\n");
    m$.Cmd.WriteJS("        else if (el.nodeType == 1 && el.tagName.toLowerCase() == pTagName.toLowerCase())","\n");
    m$.Cmd.WriteJS("            return el;","\n");
    m$.Cmd.WriteJS("        else","\n");
    m$.Cmd.WriteJS("            return getParent(el.parentNode, pTagName);","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function IsIn(obj) {","\n");
    m$.Cmd.WriteJS("        function GetX(obj) {","\n");
    m$.Cmd.WriteJS("            var x=obj.offsetLeft;","\n");
    m$.Cmd.WriteJS("            if (obj.offsetParent != null) x += GetX(obj.offsetParent);","\n");
    m$.Cmd.WriteJS("            return x;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function GetY(obj) {","\n");
    m$.Cmd.WriteJS("            var y=obj.offsetTop;","\n");
    m$.Cmd.WriteJS("            if (obj.offsetParent != null) y += GetY(obj.offsetParent);","\n");
    m$.Cmd.WriteJS("            return y;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        var result=false;","\n");
    m$.Cmd.WriteJS("        if (obj!=undefined) {","\n");
    m$.Cmd.WriteJS("            var left  =GetX(obj);","\n");
    m$.Cmd.WriteJS("            var top   =GetY(obj);","\n");
    m$.Cmd.WriteJS("            var right =left+obj.offsetWidth;","\n");
    m$.Cmd.WriteJS("            var bottom=top+obj.offsetHeight;","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("            result= !((event.clientX<left)||(event.clientX>right)||(event.clientY<top)||(event.clientY>bottom));","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        return result;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function getPageOffsetLeft(Object) {  ","\n");
    m$.Cmd.WriteJS("     var x=Object.offsetLeft;","\n");
    m$.Cmd.WriteJS("     if ((Object.offsetParent != null)&&(Object.style.position !='absolute')) x += getPageOffsetLeft(Object.offsetParent);","\n");
    m$.Cmd.WriteJS("     return x;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function getPageOffsetTop(Object) {","\n");
    m$.Cmd.WriteJS("     var y=Object.offsetTop;","\n");
    m$.Cmd.WriteJS("     if ((Object.offsetParent != null)&&(Object.style.position !='absolute')) y += getPageOffsetTop(Object.offsetParent);","\n");
    m$.Cmd.WriteJS("     return y;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function menuPosition(pobj) {","\n");
    m$.Cmd.WriteJS("        var intOverhang=document.getElementById('menu').offsetWidth-(getPageOffsetLeft(pobj.parentNode)+pobj.offsetWidth);","\n");
    m$.Cmd.WriteJS("        //alert(document.getElementById('menu').offsetWidth+':'+getPageOffsetLeft(pobj.parentNode)+':'+pobj.offsetWidth+':'+pobj.clientWidth+'::'+pobj.id+'::'+pobj.style.display+'::'+pobj.width);","\n");
    m$.Cmd.WriteJS("        if (intOverhang&gt;-1) {","\n");
    m$.Cmd.WriteJS("            intOverhang=-1;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        return intOverhang+'px' ;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function collector(pHide) {","\n");
    m$.Cmd.WriteJS("        var obj=document.getElementById('eventcollector');","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        if (obj!=undefined) {","\n");
    m$.Cmd.WriteJS("            if (pHide) {","\n");
    m$.Cmd.WriteJS("                obj.style.top='-100000px';","\n");
    m$.Cmd.WriteJS("                obj.style.width='0px';","\n");
    m$.Cmd.WriteJS("                obj.style.height='0px';","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                obj.style.top='43px';","\n");
    m$.Cmd.WriteJS("                obj.style.width=(document.body.clientWidth)+'px';","\n");
    m$.Cmd.WriteJS("                obj.style.height=(document.body.clientHeight-3-obj.offsetTop)+'px';","\n");
    m$.Cmd.WriteJS("                //obj.style.border='3px solid yellow';","\n");
    m$.Cmd.WriteJS("            }   ","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function menuclose() {","\n");
    m$.Cmd.WriteJS("      if ( document.getElementById('iFrameReport') != null ) {                  //CORE-123","\n");
    m$.Cmd.WriteJS("        //VAR report temporary solution                                         //CORE-123","\n");
    m$.Cmd.WriteJS("        document.getElementById('iFrameReport').style.visibility = 'visible';   //CORE-123","\n");
    m$.Cmd.WriteJS("      }                                                                         //CORE-123","\n");
    m$.Cmd.WriteJS("      var i=GMENU;","\n");
    m$.Cmd.WriteJS("      if (document.getElementById('mrulist')!=null) document.getElementById('mrulist').style.display='none';","\n");
    m$.Cmd.WriteJS("      if (i!=undefined) {","\n");
    m$.Cmd.WriteJS("        //document.getElementById('menuDiv_'+i).releaseCapture();","\n");
    m$.Cmd.WriteJS("        if (document.getElementById('menuDiv_'+i)!=null) {","\n");
    m$.Cmd.WriteJS("            document.getElementById('menuDiv_'+i).style.left='-100000px';","\n");
    m$.Cmd.WriteJS("           // document.getElementById('menuLi_'+i).className='';","\n");
    m$.Cmd.WriteJS("            document.getElementById('menuLi_'+i).className=document.getElementById('menuLi_'+i).getAttribute('zclass');","\n");
    m$.Cmd.WriteJS("            with (document.getElementById('menuA_'+i).style) {","\n");
    m$.Cmd.WriteJS("                 color='#EEEEEE';","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            //document.getElementById('menuLi_'+i).className='li';","\n");
    m$.Cmd.WriteJS("            //document.getElementById('menuLi_'+i).className=document.getElementById('menuLi_'+i).getAttribute('zclass');","\n");
    m$.Cmd.WriteJS("            //CORE-81 with (document.getElementById('menuLi_'+i).style) {","\n");
    m$.Cmd.WriteJS("            //CORE-81      padding='4px 10px 4px 10px';","\n");
    m$.Cmd.WriteJS("            //CORE-81    border='none';","\n");
    m$.Cmd.WriteJS("            //CORE-81        background='';","\n");
    m$.Cmd.WriteJS("            //CORE-81 }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("      }","\n");
    m$.Cmd.WriteJS("      collector(true);","\n");
    m$.Cmd.WriteJS("      return false;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    ");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Warning()
  public Object Warning(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Build the warning link.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new HTML,YYBACK,strStatus,strMessage
    mVar HTML = m$.var("HTML");
    mVar YYBACK = m$.var("YYBACK");
    mVar strStatus = m$.var("strStatus");
    mVar strMessage = m$.var("strMessage");
    m$.newVar(HTML,YYBACK,strStatus,strMessage);
    //<< 
    //<< if $piece(YBACK,",",$length(YBACK,",")-1)'=YFORM set YYBACK=YBACK_YFORM_","
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YBACK").get(),",",mOp.Subtract(m$.Fnc.$length(m$.var("YBACK").get(),","),1)),m$.var("YFORM").get())) {
      YYBACK.set(mOp.Concat(mOp.Concat(m$.var("YBACK").get(),m$.var("YFORM").get()),","));
    }
    //<< 
    //<< new YBACK
    mVar YBACK = m$.var("YBACK");
    m$.newVar(YBACK);
    //<< set YBACK=$get(YYBACK)
    YBACK.set(m$.Fnc.$get(YYBACK));
    //<< 
    //<< if $$AllChecks^WWWDASHBOARD() {
    if (mOp.Logical(m$.fnc$("WWWDASHBOARD.AllChecks"))) {
      //<< set strStatus="statusOK"
      strStatus.set("statusOK");
      //<< set strMessage=$$$Text("Com00183") ;OK
      strMessage.set(include.COMSYS.$$$Text(m$,"Com00183"));
    }
    //<< } else {
    else {
      //<< set strStatus="statusWarning"
      strStatus.set("statusWarning");
      //<< set strMessage=$$$Text("Com00179") ;Warning
      strMessage.set(include.COMSYS.$$$Text(m$,"Com00179"));
    }
    //<< }
    //<< set HTML="<a class="_strStatus_" href='"_YAKTION_"EP=WWWFORM&amp;YFORM=WWWDASHBOARD"_$$WWWCGI2^WWWCGI()_"""' >"_strMessage_"</a>"
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<a class=",strStatus.get())," href='"),m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWWDASHBOARD"),m$.fnc$("WWWCGI.WWWCGI2")),"\"' >"),strMessage.get()),"</a>"));
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< Logout()
  public Object Logout(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Build the Logout link.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new HTML,strURL
    mVar HTML = m$.var("HTML");
    mVar strURL = m$.var("strURL");
    m$.newVar(HTML,strURL);
    //<< 
    //<< set strURL = $get(^CacheTempURL(YUCI,YUSER))
    strURL.set(m$.Fnc.$get(m$.var("^CacheTempURL",m$.var("YUCI").get(),m$.var("YUSER").get())));
    //<< 
    //<< if strURL="" set strURL = $$getLoginPage^WWWLogin()
    if (mOp.Equal(strURL.get(),"")) {
      strURL.set(m$.fnc$("WWWLogin.getLoginPage"));
    }
    //<< set HTML=" onclick='try { window.top.location.href="""_strURL_"""; } catch (e) { }'"
    HTML.set(mOp.Concat(mOp.Concat(" onclick='try { window.top.location.href=\"",strURL.get()),"\"; } catch (e) { }'"));
    //<< 
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< 
  //<< Events(pintType="")
  public Object Events(Object ... _p) {
    mVar pintType = m$.newVarRef("pintType",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Menu events
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Jun-2012   shobby      CORE-127: Removed onmousemove event.
    //<< ; 20-Jun-2013   shobby      CORE-113: Do IE and FF with the same code.
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strEvents
    mVar strEvents = m$.var("strEvents");
    m$.newVar(strEvents);
    //<< set strEvents=""
    strEvents.set("");
    //<< set strEvents=" onmouseover='menuOpen(event.srcElement); ' onmouseout='menumouseout(event.srcElement);' "
    strEvents.set(" onmouseover='menuOpen(event.srcElement); ' onmouseout='menumouseout(event.srcElement);' ");
    //<< quit strEvents
    return strEvents.get();
  }

  //<< 
  //<< 
  //<< HelpFragment(pYPARA) ;CORE-107.1
  public Object HelpFragment(Object ... _p) {
    mVar pYPARA = m$.newVarRef("pYPARA",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the first sentence of the help text, stripping out some html
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; Language Texts
    //<< ;    WWW00160   :   More...
    //<< ;
    //<< ; History:
    //<< ; 23-May-2013   shobby      CORE-107.1: Changed.  Sometimes YPARA is not a list.
    //<< ; 23-May-2013   shobby      CORE-107.1: Scope YPARA variable as we only want the first $lg part.
    //<< ; 23-May-2013   shobby      CORE-107: Javascript error on WWW0121C when shown as a search function.
    //<< ; 23-Apr-2012   shobby      SR17998: Language Texts
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW127,strHelp,YPARA ;CORE-107.1
    mVar objWWW127 = m$.var("objWWW127");
    mVar strHelp = m$.var("strHelp");
    mVar YPARA = m$.var("YPARA");
    m$.newVar(objWWW127,strHelp,YPARA);
    //<< 
    //<< if $$IsList^COMUtils(pYPARA) {
    if (mOp.Logical(m$.fnc$("COMUtils.IsList",pYPARA.get()))) {
      //<< set YPARA=$listget(pYPARA)
      YPARA.set(m$.Fnc.$listget(pYPARA.get()));
    }
    //<< } else {
    else {
      //<< set YPARA=pYPARA
      YPARA.set(pYPARA.get());
    }
    //<< }
    //<< set objWWW127=$get(^WWW127(0,YFORM,"M",0,SPRACHE,1))
    objWWW127.set(m$.Fnc.$get(m$.var("^WWW127",0,m$.var("YFORM").get(),"M",0,m$.var("SPRACHE").get(),1)));
    //<< set strHelp=$$GetFormText^WWWHELP(objWWW127)
    strHelp.set(m$.fnc$("WWWHELP.GetFormText",objWWW127.get()));
    //<< set strHelp=$piece(strHelp,".",1)_"."
    strHelp.set(mOp.Concat(m$.Fnc.$piece(strHelp.get(),".",1),"."));
    //<< set strHelp=$replace(strHelp,"<b>","")
    strHelp.set(m$.Fnc.$replace(strHelp.get(),"<b>",""));
    //<< set strHelp=$replace(strHelp,"<","")
    strHelp.set(m$.Fnc.$replace(strHelp.get(),"<",""));
    //<< set strHelp=$replace(strHelp,">","")
    strHelp.set(m$.Fnc.$replace(strHelp.get(),">",""));
    //<< set strHelp=strHelp_"<A href=""#"" style='cursor:help; color:gray;' onmouseover='this.style.cursor=""help"";' onmouseout='this.style.cursor=""default"";' onClick=""subWindow('"_YAKTION_"EP=WWWHELP&amp;YFORM="_YFORM_$$WWWCGI2^WWWCGI(1)_"&amp;YSEITE="_YSEITE_"','HELP"_YTARGET_"');"">"_$$$Text("WWW00160")_"</A>"
    strHelp.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHelp.get(),"<A href=\"#\" style='cursor:help; color:gray;' onmouseover='this.style.cursor=\"help\";' onmouseout='this.style.cursor=\"default\";' onClick=\"subWindow('"),m$.var("YAKTION").get()),"EP=WWWHELP&amp;YFORM="),m$.var("YFORM").get()),m$.fnc$("WWWCGI.WWWCGI2",1)),"&amp;YSEITE="),m$.var("YSEITE").get()),"','HELP"),m$.var("YTARGET").get()),"');\">"),include.COMSYS.$$$Text(m$,"WWW00160")),"</A>"));
    //<< quit strHelp
    return strHelp.get();
  }

  //<< 
  //<< 
  //<< GetImage(pid,pidSubMenu)
  public Object GetImage(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidSubMenu = m$.newVarRef("pidSubMenu",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the image
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strImage,objWWW004
    mVar strImage = m$.var("strImage");
    mVar objWWW004 = m$.var("objWWW004");
    m$.newVar(strImage,objWWW004);
    //<< 
    //<< set objWWW004=$get(^WWW004(0,pid,pidSubMenu,1))
    objWWW004.set(m$.Fnc.$get(m$.var("^WWW004",0,pid.get(),pidSubMenu.get(),1)));
    //<< set strImage=$$$WWW004ImageFilegif(objWWW004)
    strImage.set(include.WWWConst.$$$WWW004ImageFilegif(m$,objWWW004));
    //<< if strImage="" set strImage="html.gif"
    if (mOp.Equal(strImage.get(),"")) {
      strImage.set("html.gif");
    }
    //<< quit strImage
    return strImage.get();
  }

  //<< 
  //<< 
  //<< GetMenuImage(pidForm)
  public Object GetMenuImage(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the image for the menu
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-May-2013   shobby      CORE-110.1: MegaMenu application is user defined now.
    //<< ; 22-May-2013   shobby      CORE-81.4: Line incorrectly commented out.
    //<< ; 21-May-2013   shobby      CORE-81.3.9: Get menu image for MRU, but use MEGA definition, instead of any given menu
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new id,idSubMenu
    mVar id = m$.var("id");
    mVar idSubMenu = m$.var("idSubMenu");
    m$.newVar(id,idSubMenu);
    //<< 
    //<< set idSubMenu=""
    idSubMenu.set("");
    //<< 
    //<< ;set id=$order(^WWW004s(0,2,$$$Index(pidForm),""))
    //<< ;if id'=""
    //<< ;CORE-110.1 set id="Mega" ;fix-me - get parameter for mega
    //<< set id=$$GetMegaMenuApplicationName() ;CORE-110.1
    id.set(m$.fnc$("GetMegaMenuApplicationName"));
    //<< if id'="" set idSubMenu=$order(^WWW004s(0,2,$$$Index(pidForm),id,"")) ;CORE-81.4
    if (mOp.NotEqual(id.get(),"")) {
      idSubMenu.set(m$.Fnc.$order(m$.var("^WWW004s",0,2,include.MEDConst.$$$Index(m$,pidForm),id.get(),"")));
    }
    //<< if idSubMenu="" set idSubMenu=" "
    if (mOp.Equal(idSubMenu.get(),"")) {
      idSubMenu.set(" ");
    }
    //<< quit $$GetImage(id,idSubMenu)
    return m$.fnc$("GetImage",id.get(),idSubMenu.get());
  }

  //<< 
  //<< GetMegaMenuApplicationName() ;CORE-110.1
  public Object GetMegaMenuApplicationName(Object ... _p) {
    //<< new idApplication
    mVar idApplication = m$.var("idApplication");
    m$.newVar(idApplication);
    //<< 
    //<< set idApplication=$$$WWW013MegaMenuApplicationName($get(^WWW013(0,YBED,1))) ;CORE-110.1
    idApplication.set(include.WWWConst.$$$WWW013MegaMenuApplicationName(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))));
    //<< if idApplication="" set idApplication=" "
    if (mOp.Equal(idApplication.get(),"")) {
      idApplication.set(" ");
    }
    //<< quit idApplication
    return idApplication.get();
  }

  //<< 
  //<< Body(YKOPF)
  public Object Body(Object ... _p) {
    mVar YKOPF = m$.newVarRef("YKOPF",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper to build the menu structure
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-May-2013   shobby      CORE-81: Remove extra scrollbar in FF.
    //<< ; 27-May-2013   shobby      CORE-81.3.21: Remove for now the option of showing contents on mouseover the form title.
    //<< ; 20-May-2013   shobby      CORE-81.3.13: Remove warning indicator
    //<< ; 20-May-2013   shobby      CORE-81.3.12: Show Alphalinc Full Menu only for System Administrators
    //<< ; 13-May-2013   shobby      CORE-100: Give the MegaMenu an id.
    //<< ; 30-Apr-2013   shobby      CORE-81: Located Status menu in separate area.
    //<< ; 30-Apr-2013   shobby      CORE-81: Moved MRU menu to the right.
    //<< ; 02-Jul-2012   shobby      SR17998: Moved MRU menu to the left.
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< &html<<div id="MegaMenu" style="width:99.9%"><ul id="menu" class="menu" style='z-Index:20000;' #($$Events(2))#>>
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("<div id=\"MegaMenu\" style=\"width:99.9%\"><ul id=\"menu\" class=\"menu\" style='z-Index:20000;' ",(m$.fnc$("Events",2))),">"));
    //<< ;write $$GetMenu("@net_Manager")
    //<< ;do FlexibleBig()
    //<< do Flexibles^WWWMegaMenuFlexible()
    m$.Cmd.Do("WWWMegaMenuFlexible.Flexibles");
    //<< write $$GetMRUMenu^WWWMegaMenuMRU()
    m$.Cmd.Write(m$.fnc$("WWWMegaMenuMRU.GetMRUMenu"));
    //<< if ($$SuperUser^COMViewUtils = $$$YES) {        ;CORE-81.3.12
    if ((mOp.Equal(m$.fnc$("COMViewUtils.SuperUser"),include.COMSYS.$$$YES(m$)))) {
      //<< write $$GetFullMenu^WWWMegaMenuFullMenu()
      m$.Cmd.Write(m$.fnc$("WWWMegaMenuFullMenu.GetFullMenu"));
    }
    //<< }
    //<< 
    //<< ; The following are right aligned and appear in reverse order.
    //<< do GetWarningIndicator()
    m$.Cmd.Do("GetWarningIndicator");
    //<< write $$GetUserMenu^WWWMegaMenuUserMenu()
    m$.Cmd.Write(m$.fnc$("WWWMegaMenuUserMenu.GetUserMenu"));
    //<< &html<
    //<< <li class='menu_right' style='color:white;'><div id='menuTimeout' >...</div></a><!-- Begin Timeout -->
    //<< </li>
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("        <li class='menu_right' style='color:white;'><div id='menuTimeout' >...</div></a><!-- Begin Timeout -->","\n");
    m$.Cmd.WriteHtml("        </li>","\n");
    m$.Cmd.WriteHtml("    ");
    //<< ;CORE-81
    //<< &html<
    //<< </ul>
    //<< <div id='eventcollector' onmouseover='menuclose();' style='z-Index:5000; position:absolute; width:0px; border:none; left:0px; height:0px; top:-10000px;'>
    //<< </div>
    //<< 
    //<< >
    m$.Cmd.WriteHtml("    ","\n");
    m$.Cmd.WriteHtml("    </ul>","\n");
    m$.Cmd.WriteHtml("    <div id='eventcollector' onmouseover='menuclose();' style='z-Index:5000; position:absolute; width:0px; border:none; left:0px; height:0px; top:-10000px;'>","\n");
    m$.Cmd.WriteHtml("    </div>","\n");
    m$.Cmd.WriteHtml("    ");
    //<< /*
    //<< &html<<ul id="menu2" class="menu" style='z-Index:21000;' #($$Events(2))#>>
    //<< do GetStatusMenu(YKOPF)
    //<< do GetLocationDetails()
    //<< &html<</ul></div>>
    //<< */
    //<< &html<<div id="menu2" class="menu">>
    m$.Cmd.WriteHtml("<div id=\"menu2\" class=\"menu\">");
    //<< &html<<div class="formname2">#(YKOPF)#</div>>
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("<div class=\"formname2\">",(YKOPF.get())),"</div>"));
    //<< do GetLocationDetails()
    m$.Cmd.Do("GetLocationDetails");
    //<< &html<</div></div>>
    m$.Cmd.WriteHtml("</div></div>");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetWarningIndicator()
  public Object GetWarningIndicator(Object ... _p) {
    //<< new strHREF,strText
    mVar strHREF = m$.var("strHREF");
    mVar strText = m$.var("strText");
    m$.newVar(strHREF,strText);
    //<< 
    //<< set strText=""
    strText.set("");
    //<< if YBED["SHOBBY" { ;Temporarily disabled until decided what to do with this
    if (mOp.Contains(m$.var("YBED").get(),"SHOBBY")) {
      //<< if '$$AllChecks^WWWDASHBOARD(.strText) {
      if (mOp.Not(m$.fnc$("WWWDASHBOARD.AllChecks",strText))) {
        //<< set strHREF="href='"_YAKTION_"EP=WWWFORM&amp;YFORM=WWWDASHBOARD"_$$WWWCGI2^WWWCGI()_"""'"
        strHREF.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("href='",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWWDASHBOARD"),m$.fnc$("WWWCGI.WWWCGI2")),"\"'"));
        //<< 
        //<< &html<
        //<< <li class='menu_right' id='menuLi_6' style='margin-left:0px;'>
        //<< <a #(strHREF)# id='menuA_6' href="#" class='alert' style='margin-left:0px; width:15px; height:15px; font-size:12px; font-weight:normal; color:red; background-color:#EEEEEE'>
        //<< #(strText)#
        //<< </a>
        //<< </li>
        //<< >
        m$.Cmd.WriteHtml("","\n");
        m$.Cmd.WriteHtml("                <li class='menu_right' id='menuLi_6' style='margin-left:0px;'>","\n");
        m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                    <a ",(strHREF.get()))," id='menuA_6' href=\"#\" class='alert' style='margin-left:0px; width:15px; height:15px; font-size:12px; font-weight:normal; color:red; background-color:#EEEEEE'>"),"\n");
        m$.Cmd.WriteHtml(mOp.Concat("                        ",(strText.get())),"\n");
        m$.Cmd.WriteHtml("                    </a>","\n");
        m$.Cmd.WriteHtml("                </li>","\n");
        m$.Cmd.WriteHtml("            ");
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< GetLocationDetails()
  public Object GetLocationDetails(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Location Details
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-May-2013   shobby      CORE-81.3.21.2: Remove for now the option of showing contents on mouseover the form title.
    //<< ;-------------------------------------------------------------------------------
    //<< new strText,strHREF,strTitle
    mVar strText = m$.var("strText");
    mVar strHREF = m$.var("strHREF");
    mVar strTitle = m$.var("strTitle");
    m$.newVar(strText,strHREF,strTitle);
    //<< 
    //<< set strText="("_YM
    strText.set(mOp.Concat("(",m$.var("YM").get()));
    //<< if $get(YLOCATION)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLOCATION")),"")) {
      //<< set strText=strText_"/"_YLOCATION
      strText.set(mOp.Concat(mOp.Concat(strText.get(),"/"),m$.var("YLOCATION").get()));
      //<< set strText=strText_"/"_$piece($get(^WWW0121(0,0,YLOCATION,1)),Y,1)
      strText.set(mOp.Concat(mOp.Concat(strText.get(),"/"),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0121",0,0,m$.var("YLOCATION").get(),1)),m$.var("Y").get(),1)));
    }
    //<< }
    //<< set strText=strText_")"
    strText.set(mOp.Concat(strText.get(),")"));
    //<< 
    //<< if $get(YFORM)="" || $get(blnPDA)  {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"") || mOp.Logical(m$.Fnc.$get(m$.var("blnPDA")))) {
      //<< set strHREF = " HREF=""#"""
      strHREF.set(" HREF=\"#\"");
    }
    //<< } else {   ; Quick Location Change
    else {
      //<< set strHREF = "HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM=WWW0131B&amp;YBACK="_YFORM_","_$$VAR1^WWWCGI(1)_""""
      strHREF.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWW0131B&amp;YBACK="),m$.var("YFORM").get()),","),m$.fnc$("WWWCGI.VAR1",1)),"\""));
    }
    //<< }
    //<< 
    //<< set strTitle = " TITLE="""_$$GetSystemInfoTooltip^WWWKOPF()_""""
    strTitle.set(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWKOPF.GetSystemInfoTooltip")),"\""));
    //<< 
    //<< &html<
    //<< <!--<li class='menu_right' id='menuLi_5' style='border:0px;'>
    //<< <a #(strHREF)# id='menuA_5' href="#" class='drop' style='font-size:12px; font-weight:normal;' #(strTitle)#>
    //<< #(strText)#
    //<< </a>
    //<< </li>-->
    //<< <div class='menu_rightLocation'>
    //<< <a #(strHREF)# href="#" #(strTitle)#>
    //<< #(strText)#
    //<< </a>
    //<< </div>
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("        <!--<li class='menu_right' id='menuLi_5' style='border:0px;'>","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("            <a ",(strHREF.get()))," id='menuA_5' href=\"#\" class='drop' style='font-size:12px; font-weight:normal;' "),(strTitle.get())),">"),"\n");
    m$.Cmd.WriteHtml(mOp.Concat("                ",(strText.get())),"\n");
    m$.Cmd.WriteHtml("            </a>","\n");
    m$.Cmd.WriteHtml("        </li>-->","\n");
    m$.Cmd.WriteHtml("        <div class='menu_rightLocation'>","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("              <a ",(strHREF.get()))," href=\"#\" "),(strTitle.get())),">"),"\n");
    m$.Cmd.WriteHtml(mOp.Concat("                    ",(strText.get())),"\n");
    m$.Cmd.WriteHtml("              </a>","\n");
    m$.Cmd.WriteHtml("        </div>","\n");
    m$.Cmd.WriteHtml("    ");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetLogoutMenu()
  public Object GetLogoutMenu(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Right most menu on screen.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-May-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new HTML
    mVar HTML = m$.var("HTML");
    m$.newVar(HTML);
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< set HTML=HTML_"<li class='menu_right' id='menuLi_9'><a id='menuA_9' href="#" class='drop' style='color:red;' "_$$Logout()_">Logout</a>"
    HTML.set(mOp.Concat(mOp.Concat(mOp.Modulus(mOp.Concat(HTML.get(),"<li class='menu_right' id='menuLi_9'><a id='menuA_9' href=")," class='drop' style='color:red;' "),m$.fnc$("Logout")),">Logout</a>"));
    //<< set HTML=HTML_"</li>"
    HTML.set(mOp.Concat(HTML.get(),"</li>"));
    //<< 
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< 
  //<< GetStatusMenu(YKOPF)
  public Object GetStatusMenu(Object ... _p) {
    mVar YKOPF = m$.newVarRef("YKOPF",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create the Status Menu.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; Language texts
    //<< ;   WWW00157: Welcome!
    //<< ;   WWW00158: Cross Browser Support
    //<< ;   WWW00159: For Alphalinc to function correctly it is necessary that one of these browsers is installed on your computer.
    //<< ;   WWW00161: System Configuration:
    //<< ;   WWW00162: Dashboard
    //<< ;   WWW00163: System Information
    //<< ;
    //<< ; History:
    //<< ; 23-Apr-2012   shobby      SR17998: Language Texts.
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< &html<
    //<< <li id='menuLi_1' class='li' zclass='li' hclass='lihover' style='margin-left:0px; z-index:2000;'><a id='menuA_1' href="#" class='drop' zclass='drop'><span class='formname' id='menublink' >#(YKOPF)#</span></a><!-- Begin Status -->
    //<< <div id='menuDiv_1' class='dropdown_2columns' zclass='dropdown_2columns'>
    //<< <div id='menuDivCol_1' class="col_2">
    //<< <h2 id='menuH2_1'>#($$$Text("WWW00157"))#</h2>
    //<< </div>
    //<< <div class="col_2">
    //<< <p>#($$HelpFragment(YPARA))#</p>
    //<< <p>&nbsp</p>
    //<< </div>
    //<< <div class="col_2">
    //<< <h2>#($$$Text("WWW00158"))#</h2>
    //<< </div>
    //<< <div class="col_2">
    //<< <img src="#(YGIF)#/supportedbrowsers.png" alt="" height="49" width="103">
    //<< </div>
    //<< <div class="col_2">
    //<< <p>#($$$Text("WWW00159"))#</p>
    //<< <p>&nbsp</p>
    //<< </div>
    //<< <div class="col_2">
    //<< <h2>#($$$Text("WWW00162"))#</h2>
    //<< </div>
    //<< <div class="col_2">
    //<< <p>#($$$Text("WWW00161"))##($$Warning())#</p>
    //<< <p>&nbsp</p>
    //<< </div>
    //<< <div class="col_2">
    //<< <h2>#($$$Text("WWW00163"))#</h2>
    //<< </div>
    //<< <div class="col_2">
    //<< #($$GetSystemInfoTooltip())#
    //<< </div>
    //<< </div>
    //<< </li><!-- End Status -->
    //<< 
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("    <li id='menuLi_1' class='li' zclass='li' hclass='lihover' style='margin-left:0px; z-index:2000;'><a id='menuA_1' href=\"#\" class='drop' zclass='drop'><span class='formname' id='menublink' >",(YKOPF.get())),"</span></a><!-- Begin Status -->"),"\n");
    m$.Cmd.WriteHtml("        <div id='menuDiv_1' class='dropdown_2columns' zclass='dropdown_2columns'>","\n");
    m$.Cmd.WriteHtml("            <div id='menuDivCol_1' class=\"col_2\">","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                <h2 id='menuH2_1'>",(include.COMSYS.$$$Text(m$,"WWW00157"))),"</h2>"),"\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("            <div class=\"col_2\">","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                <p>",(m$.fnc$("HelpFragment",m$.var("YPARA").get()))),"</p>"),"\n");
    m$.Cmd.WriteHtml("                <p>&nbsp</p>","\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("            <div class=\"col_2\">","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                <h2>",(include.COMSYS.$$$Text(m$,"WWW00158"))),"</h2>"),"\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("            <div class=\"col_2\">","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                <img src=\"",(m$.var("YGIF").get())),"/supportedbrowsers.png\" alt=\"\" height=\"49\" width=\"103\">"),"\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("            <div class=\"col_2\">","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                <p>",(include.COMSYS.$$$Text(m$,"WWW00159"))),"</p>"),"\n");
    m$.Cmd.WriteHtml("                <p>&nbsp</p>","\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("            <div class=\"col_2\">","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                <h2>",(include.COMSYS.$$$Text(m$,"WWW00162"))),"</h2>"),"\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("            <div class=\"col_2\">","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat("                <p>",(include.COMSYS.$$$Text(m$,"WWW00161"))),(m$.fnc$("Warning"))),"</p>"),"\n");
    m$.Cmd.WriteHtml("                <p>&nbsp</p>","\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("            <div class=\"col_2\">","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                <h2>",(include.COMSYS.$$$Text(m$,"WWW00163"))),"</h2>"),"\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("            <div class=\"col_2\">","\n");
    m$.Cmd.WriteHtml(mOp.Concat("                ",(m$.fnc$("GetSystemInfoTooltip"))),"\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("        </div>","\n");
    m$.Cmd.WriteHtml("    </li><!-- End Status -->","\n");
    m$.Cmd.WriteHtml("    ");
    //<< quit
    return null;
  }

  //<< 
  //<< GetLocation(YLOCATION)
  public Object GetLocation(Object ... _p) {
    mVar YLOCATION = m$.newVarRef("YLOCATION",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new strLocation
    mVar strLocation = m$.var("strLocation");
    m$.newVar(strLocation);
    //<< 
    //<< set strLocation=YLOCATION
    strLocation.set(YLOCATION.get());
    //<< if strLocation'="" {
    if (mOp.NotEqual(strLocation.get(),"")) {
      //<< set strLocation= strLocation_" ("_$extract($$$WWW0121LocationName($get(^WWW0121(0,0,YLOCATION,1))),1,80)_")"
      strLocation.set(mOp.Concat(mOp.Concat(mOp.Concat(strLocation.get()," ("),m$.Fnc.$extract(include.WWWConst.$$$WWW0121LocationName(m$,m$.Fnc.$get(m$.var("^WWW0121",0,0,YLOCATION.get(),1))),1,80)),")"));
    }
    //<< }
    //<< 
    //<< quit strLocation
    return strLocation.get();
  }

  //<< 
  //<< 
  //<< GetSystemInfoTooltip()
  public Object GetSystemInfoTooltip(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns a string containing correctly formatted string to be inserted into an
    //<< ; <A TITLE="">  construct
    //<< ;---------------------------------------
    //<< ;   System Information
    //<< ;   Company 0 (ALPHALINC)    [deprecated information - reference removed]
    //<< ;   Location 1 (Locn1)
    //<< ;   Cost Centre CC (CostCentre)
    //<< ;   User USER (User Name)
    //<< ;   Language EN (English)
    //<< ;   IP 000.000.000.000
    //<< ;   Form INFormName
    //<< ;   Job 1234
    //<< ;---------------------------------------
    //<< ;
    //<< ; ByRefs:
    //<< ;   YM          Company ID
    //<< ;   YLOCATION   Location ID
    //<< ;   YCR         Newline Character
    //<< ;   SPRACHE     Language ID
    //<< ;   YBED        User ID
    //<< ;   YIPADDR     IP Address of current user
    //<< ;   YFORM       FORM ID
    //<< ;
    //<< ; History:
    //<< ; 11-Apr-2012   shobby  SR17998: Based on WWWKOPF version.
    //<< ; 11-Dec-2009   GRF     SR16871: Add Cost Centre; skip deprecated YM; macros
    //<< ; 12-Dec-2008   HQN     SR16240: Rewrote to return instead of direct write,
    //<< ;                           reusable in outside routines
    //<< ;-------------------------------------------------------------------------------
    //<< new idCostCentre,HTML,strLocation,strCostCentre,strUserName,strLanguage
    mVar idCostCentre = m$.var("idCostCentre");
    mVar HTML = m$.var("HTML");
    mVar strLocation = m$.var("strLocation");
    mVar strCostCentre = m$.var("strCostCentre");
    mVar strUserName = m$.var("strUserName");
    mVar strLanguage = m$.var("strLanguage");
    m$.newVar(idCostCentre,HTML,strLocation,strCostCentre,strUserName,strLanguage);
    //<< 
    //<< set strLocation   = $$GetLocation(YLOCATION)
    strLocation.set(m$.fnc$("GetLocation",m$.var("YLOCATION").get()));
    //<< set strCostCentre = ""
    strCostCentre.set("");
    //<< set strUserName   = YBED
    strUserName.set(m$.var("YBED").get());
    //<< set strLanguage   = SPRACHE
    strLanguage.set(m$.var("SPRACHE").get());
    //<< 
    //<< if YLOCATION'="" {
    if (mOp.NotEqual(m$.var("YLOCATION").get(),"")) {
      //<< set idCostCentre = $$GetCostCentre^INCostCentre(YLOCATION)
      idCostCentre.set(m$.fnc$("INCostCentre.GetCostCentre",m$.var("YLOCATION").get()));
      //<< set strCostCentre= $$^WWWTEXT(33860,,1)_" "_idCostCentre  ; Cost Centre
      strCostCentre.set(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",33860,null,1)," "),idCostCentre.get()));
      //<< if idCostCentre'="" {
      if (mOp.NotEqual(idCostCentre.get(),"")) {
        //<< set strCostCentre = strCostCentre_" ("_$extract($$$INKOSTLDesignation($get(^INKOSTL(0,idCostCentre,1))),1,80)_")"
        strCostCentre.set(mOp.Concat(mOp.Concat(mOp.Concat(strCostCentre.get()," ("),m$.Fnc.$extract(include.INConst.$$$INKOSTLDesignation(m$,m$.Fnc.$get(m$.var("^INKOSTL",0,idCostCentre.get(),1))),1,80)),")"));
      }
    }
    //<< }
    //<< }
    //<< if YBED'=""    set strUserName = strUserName_" ("_$extract($$$WWW013Name($get(^WWW013(0,YBED,1))),1,80)_")"
    if (mOp.NotEqual(m$.var("YBED").get(),"")) {
      strUserName.set(mOp.Concat(mOp.Concat(mOp.Concat(strUserName.get()," ("),m$.Fnc.$extract(include.WWWConst.$$$WWW013Name(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))),1,80)),")"));
    }
    //<< if SPRACHE'="" set strLanguage = strLanguage_" ("_$extract($$$WWW100Text($get(^WWW100(0,"SPRACHE",SPRACHE,SPRACHE,1))),1,80)_")"
    if (mOp.NotEqual(m$.var("SPRACHE").get(),"")) {
      strLanguage.set(mOp.Concat(mOp.Concat(mOp.Concat(strLanguage.get()," ("),m$.Fnc.$extract(include.WWWConst.$$$WWW100Text(m$,m$.Fnc.$get(m$.var("^WWW100",0,"SPRACHE",m$.var("SPRACHE").get(),m$.var("SPRACHE").get(),1))),1,80)),")"));
    }
    //<< 
    //<< 
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< 
    //<< set HTML=HTML_"<table>"
    HTML.set(mOp.Concat(HTML.get(),"<table>"));
    //<< set HTML=HTML_"  <tr><td>"_$$^WWWTEXT(388,,1)  _":</td><td style='color:darkblue;'>"_strLocation  _"</td></tr>" ; Location
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"  <tr><td>"),m$.fnc$("WWWTEXT.main",388,null,1)),":</td><td style='color:darkblue;'>"),strLocation.get()),"</td></tr>"));
    //<< set HTML=HTML_"  <tr><td>"_$$^WWWTEXT(33860,,1)_":</td><td style='color:darkblue;'>"_strCostCentre_"</td></tr>" ; Cost Centre
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"  <tr><td>"),m$.fnc$("WWWTEXT.main",33860,null,1)),":</td><td style='color:darkblue;'>"),strCostCentre.get()),"</td></tr>"));
    //<< set HTML=HTML_"  <tr><td>"_$$^WWWTEXT(232,,1)  _":</td><td style='color:darkblue;'>"_strUserName  _"</td></tr>" ; Username
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"  <tr><td>"),m$.fnc$("WWWTEXT.main",232,null,1)),":</td><td style='color:darkblue;'>"),strUserName.get()),"</td></tr>"));
    //<< set HTML=HTML_"  <tr><td>"_$$^WWWTEXT(300,,1)  _":</td><td style='color:darkblue;'>"_strLanguage  _"</td></tr>" ; Language
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"  <tr><td>"),m$.fnc$("WWWTEXT.main",300,null,1)),":</td><td style='color:darkblue;'>"),strLanguage.get()),"</td></tr>"));
    //<< set HTML=HTML_"  <tr><td>"_$$^WWWTEXT(33776,,1)_":</td><td style='color:darkblue;'>"_$get(YIPADDR)_"</td></tr>" ; IP
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"  <tr><td>"),m$.fnc$("WWWTEXT.main",33776,null,1)),":</td><td style='color:darkblue;'>"),m$.Fnc.$get(m$.var("YIPADDR"))),"</td></tr>"));
    //<< set HTML=HTML_"  <tr><td>"_$$^WWWTEXT(93,,1)   _":</td><td style='color:darkblue;'>"_$get(YFORM)  _"</td></tr>" ; Form
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"  <tr><td>"),m$.fnc$("WWWTEXT.main",93,null,1)),":</td><td style='color:darkblue;'>"),m$.Fnc.$get(m$.var("YFORM"))),"</td></tr>"));
    //<< set HTML=HTML_"  <tr><td>"_$$^WWWTEXT(34165,,1)_":</td><td style='color:darkblue;'>"_$job         _"</td></tr>" ; Job
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"  <tr><td>"),m$.fnc$("WWWTEXT.main",34165,null,1)),":</td><td style='color:darkblue;'>"),m$.Fnc.$job()),"</td></tr>"));
    //<< 
    //<< 
    //<< set HTML=HTML_"</table>"
    HTML.set(mOp.Concat(HTML.get(),"</table>"));
    //<< 
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< FlexibleBig()
  public Object FlexibleBig(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Render Menu
    //<< ; TODO: use list of styles isntead of directly writing out background images
    //<< ;
    //<< ; History:
    //<< ; 17-Apr-2012   shobby  SR17998: Based on flexible menu.
    //<< ; 16-Nov-2010   PPP     SR17614: 1. Include items that have only the 'link to' defined
    //<< ;                       2. Include 'Target for Output'  if defined
    //<< ; 27-Apr-2010   GRF     SR16402: Don't pass YM to Get^WWW004 - always 0
    //<< ; 28-Feb-2009   HQN     SR16402: Use $$Get^WWW004 to obtain localised record
    //<< ; 12-Dec-2008   HQN     SR16240: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrUserMenu,idApplicn,idSection,intColCount,intMenuCount
    mVar arrUserMenu = m$.var("arrUserMenu");
    mVar idApplicn = m$.var("idApplicn");
    mVar idSection = m$.var("idSection");
    mVar intColCount = m$.var("intColCount");
    mVar intMenuCount = m$.var("intMenuCount");
    m$.newVar(arrUserMenu,idApplicn,idSection,intColCount,intMenuCount);
    //<< new loopSubmenus,objMenu,objSubmenu
    mVar loopSubmenus = m$.var("loopSubmenus");
    mVar objMenu = m$.var("objMenu");
    mVar objSubmenu = m$.var("objSubmenu");
    m$.newVar(loopSubmenus,objMenu,objSubmenu);
    //<< new strLink,strForm,strCSSClass,strImage,strImageDirectory,strLinkWith,strTarget
    mVar strLink = m$.var("strLink");
    mVar strForm = m$.var("strForm");
    mVar strCSSClass = m$.var("strCSSClass");
    mVar strImage = m$.var("strImage");
    mVar strImageDirectory = m$.var("strImageDirectory");
    mVar strLinkWith = m$.var("strLinkWith");
    mVar strTarget = m$.var("strTarget");
    m$.newVar(strLink,strForm,strCSSClass,strImage,strImageDirectory,strLinkWith,strTarget);
    //<< 
    //<< set idApplicn    = $$$WWW013FlexibleMenuApplicationNa($get(^WWW013(0,YBED,1)))
    idApplicn.set(include.WWWConst.$$$WWW013FlexibleMenuApplicationNa(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))));
    //<< set idApplicn="Demo" ;SR17998
    idApplicn.set("Demo");
    //<< 
    //<< &html<
    //<< <li id='menuLi_2' class='li'><a id='menuA_2' href="#" class="drop">#(idApplicn)#</a><!-- Begin 4 columns Item -->
    //<< <div id='menuDiv_2' class="dropdown_flexible" zclass="dropdown_flexible"><!-- Begin 4 columns container -->
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("    <li id='menuLi_2' class='li'><a id='menuA_2' href=\"#\" class=\"drop\">",(idApplicn.get())),"</a><!-- Begin 4 columns Item -->"),"\n");
    m$.Cmd.WriteHtml("        <div id='menuDiv_2' class=\"dropdown_flexible\" zclass=\"dropdown_flexible\"><!-- Begin 4 columns container -->","\n");
    m$.Cmd.WriteHtml("    ");
    //<< &html<<div class="MenuOverviewWrapper">>
    m$.Cmd.WriteHtml("<div class=\"MenuOverviewWrapper\">");
    //<< 
    //<< set intMenuCount = 0
    intMenuCount.set(0);
    //<< set intColCount  = 3
    intColCount.set(3);
    //<< set strImageDirectory = $translate($piece($get(^WWW012(0,0,1)),"~",47),"\","/")
    strImageDirectory.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),"~",47),"\\","/"));
    //<< do GetMenu^WWWMenuOverview(YBED,idApplicn,.arrUserMenu)
    m$.Cmd.Do("WWWMenuOverview.GetMenu",m$.var("YBED").get(),idApplicn.get(),arrUserMenu);
    //<< set idSection = ""
    idSection.set("");
    //<< for {
    for (;true;) {
      //<< set idSection = $order(arrUserMenu(idSection))
      idSection.set(m$.Fnc.$order(arrUserMenu.var(idSection.get())));
      //<< quit:idSection=""
      if (mOp.Equal(idSection.get(),"")) {
        break;
      }
      //<< 
      //<< set objMenu = $$Get^WWW004(idApplicn,idSection)
      objMenu.set(m$.fnc$("WWW004.Get",idApplicn.get(),idSection.get()));
      //<< set strImage = $$$WWW004ImageFilegif(objMenu)
      strImage.set(include.WWWConst.$$$WWW004ImageFilegif(m$,objMenu));
      //<< 
      //<< &html<
      //<< <ul class="MenuOverview">
      //<< <div class="Section" style="background-image: url(#(strImageDirectory)#/#(strImage)#);">
      //<< <span class="Title">#($$$WWW004MenuDescription(objMenu))#</span>
      //<< </div>
      //<< >
      m$.Cmd.WriteHtml("","\n");
      m$.Cmd.WriteHtml("            <ul class=\"MenuOverview\">","\n");
      m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("            <div class=\"Section\" style=\"background-image: url(",(strImageDirectory.get())),"/"),(strImage.get())),");\">"),"\n");
      m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                <span class=\"Title\">",(include.WWWConst.$$$WWW004MenuDescription(m$,objMenu))),"</span>"),"\n");
      m$.Cmd.WriteHtml("            </div>","\n");
      m$.Cmd.WriteHtml("        ");
      //<< for loopSubmenus=1:1:$length($get(arrUserMenu(idSection)),";") {
      for (loopSubmenus.set(1);(mOp.LessOrEqual(loopSubmenus.get(),m$.Fnc.$length(m$.Fnc.$get(arrUserMenu.var(idSection.get())),";")));loopSubmenus.set(mOp.Add(loopSubmenus.get(),1))) {
        //<< if ($data(^WWW004(0,idApplicn,$piece(arrUserMenu(idSection),";",loopSubmenus)))){
        if (mOp.Logical((m$.Fnc.$data(m$.var("^WWW004",0,idApplicn.get(),m$.Fnc.$piece(arrUserMenu.var(idSection.get()).get(),";",loopSubmenus.get())))))) {
          //<< set objSubmenu = $$Get^WWW004(idApplicn,$piece(arrUserMenu(idSection),";",loopSubmenus))
          objSubmenu.set(m$.fnc$("WWW004.Get",idApplicn.get(),m$.Fnc.$piece(arrUserMenu.var(idSection.get()).get(),";",loopSubmenus.get())));
        }
        //<< } else {
        else {
          //<< set objSubmenu = ""
          objSubmenu.set("");
        }
        //<< }
        //<< set strForm = $$$WWW004FormName(objSubmenu)
        strForm.set(include.WWWConst.$$$WWW004FormName(m$,objSubmenu));
        //<< set strImage = "html.gif"
        strImage.set("html.gif");
        //<< 
        //<< //SR17614
        //<< set strLinkWith = $$$WWW004LinkWith(objSubmenu)
        strLinkWith.set(include.WWWConst.$$$WWW004LinkWith(m$,objSubmenu));
        //<< set strTarget   = $$$WWW004TargetNameForOutput(objSubmenu)
        strTarget.set(include.WWWConst.$$$WWW004TargetNameForOutput(m$,objSubmenu));
        //<< 
        //<< set:($$$WWW004ImageFilegif(objSubmenu)'="") strImage = $$$WWW004ImageFilegif(objSubmenu)
        if ((mOp.NotEqual(include.WWWConst.$$$WWW004ImageFilegif(m$,objSubmenu),""))) {
          strImage.set(include.WWWConst.$$$WWW004ImageFilegif(m$,objSubmenu));
        }
        //<< 
        //<< if ($$$WWW004StartFormWithSearchFuncti(objSubmenu) = 1){
        if ((mOp.Equal(include.WWWConst.$$$WWW004StartFormWithSearchFuncti(m$,objSubmenu),1))) {
          //<< set strLink = YAKTION_"EP=WWWSEAR&YFORM="_strForm_"&YUCI="_YUCI_"&YBED="_YBED_"&YM="_YM_"&YUSER="_YUSER
          strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWSEAR&YFORM="),strForm.get()),"&YUCI="),m$.var("YUCI").get()),"&YBED="),m$.var("YBED").get()),"&YM="),m$.var("YM").get()),"&YUSER="),m$.var("YUSER").get()));
        }
        //<< 
        //<< } elseif(strForm'="") {
        else if ((mOp.NotEqual(strForm.get(),""))) {
          //<< set strLink = YAKTION_"EP=WWWFORM&YFORM="_strForm_"&YUCI="_YUCI_"&YBED="_YBED_"&YM="_YM_"&YUSER="_YUSER_"&YBACK="_YFORM_","
          strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&YFORM="),strForm.get()),"&YUCI="),m$.var("YUCI").get()),"&YBED="),m$.var("YBED").get()),"&YM="),m$.var("YM").get()),"&YUSER="),m$.var("YUSER").get()),"&YBACK="),m$.var("YFORM").get()),","));
        }
        //<< //SR17614
        //<< } elseif(strLinkWith'="") {
        else if ((mOp.NotEqual(strLinkWith.get(),""))) {
          //<< set strLink = strLinkWith
          strLink.set(strLinkWith.get());
        }
        //<< 
        //<< } else {
        else {
          //<< continue ; Don't bother to display submenu
          continue;
        }
        //<< ;   set strLink = "#"
        //<< }
        //<< 
        //<< if ($piece(arrUserMenu(idSection),".",2) = "") {
        if ((mOp.Equal(m$.Fnc.$piece(arrUserMenu.var(idSection.get()).get(),".",2),""))) {
        }
        //<< } else {
        else {
          //<< if strImage = "html.gif" {
          if (mOp.Equal(strImage.get(),"html.gif")) {
            //<< set strCSSClass = " class=""default"""
            strCSSClass.set(" class=\"default\"");
          }
          //<< } else {
          else {
            //<< set strCSSClass = " style=""list-style-image:url("_strImageDirectory_"/"_strImage_");"""
            strCSSClass.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" style=\"list-style-image:url(",strImageDirectory.get()),"/"),strImage.get()),");\""));
          }
          //<< }
          //<< if strTarget '= "" {
          if (mOp.NotEqual(strTarget.get(),"")) {
            //<< &html<<li#(strCSSClass)#><a href="#(strLink)#" target="#(strTarget)#">#($$$WWW004MenuDescription(objSubmenu))#</a></li>>
            m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<li",(strCSSClass.get())),"><a href=\""),(strLink.get())),"\" target=\""),(strTarget.get())),"\">"),(include.WWWConst.$$$WWW004MenuDescription(m$,objSubmenu))),"</a></li>"));
          }
          //<< } else {
          else {
            //<< &html<<li#(strCSSClass)#><a href="#(strLink)#">#($$$WWW004MenuDescription(objSubmenu))#</a></li>>
            m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<li",(strCSSClass.get())),"><a href=\""),(strLink.get())),"\">"),(include.WWWConst.$$$WWW004MenuDescription(m$,objSubmenu))),"</a></li>"));
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< &html<</ul>>
      m$.Cmd.WriteHtml("</ul>");
      //<< set intMenuCount = intMenuCount + 1
      intMenuCount.set(mOp.Add(intMenuCount.get(),1));
      //<< if (intMenuCount#intColCount=0) {
      if ((mOp.Equal(mOp.Modulus(intMenuCount.get(),intColCount.get()),0))) {
        //<< &html<<hr class="MenuOverviewDivider"/>>
        m$.Cmd.WriteHtml("<hr class=\"MenuOverviewDivider\"/>");
      }
    }
    //<< }
    //<< }
    //<< &html<
    //<< <hr class="MenuOverviewDivider"/>
    //<< </div>
    //<< </div><!-- End 2 columns container -->
    //<< </li><!-- End Home Item -->
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("            <hr class=\"MenuOverviewDivider\"/>","\n");
    m$.Cmd.WriteHtml("        </div>","\n");
    m$.Cmd.WriteHtml("        </div><!-- End 2 columns container -->   ","\n");
    m$.Cmd.WriteHtml("    </li><!-- End Home Item -->","\n");
    m$.Cmd.WriteHtml("    ");
    //<< quit
    return null;
  }

//<< 
//<< 
//<< 
}
