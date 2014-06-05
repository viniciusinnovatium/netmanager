//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMenuOverview
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-04 15:00:25
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
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

//<< WWWMenuOverview
public class WWWMenuOverview extends mClass {

  public void main() {
    _WWWMenuOverview();
  }

  public void _WWWMenuOverview() {
  }

  //<< 
  //<< OnBeforeFormConstruction()
  public Object OnBeforeFormConstruction(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; This form cannot work correctly unless FormType is set to Manual Input (without Button)
    //<< ;-------------------------------------------------------------------------------
    //<< ;set $$$WWW120FormType(YVOR) = 5
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeButtonLine()
  public Object OnBeforeButtonLine(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Make sure this form is set to "No Button Line" then manually build one to look the same
    //<< ;
    //<< ; History:
    //<< ; 12-Dec-2008   HQN     SR16240: Created
    //<< ;-------------------------------------------------------------------------------
    //<< do DisplayStyle()
    m$.Cmd.Do("DisplayStyle");
    //<< ;do DisplayButtonLine()
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterDataFields()
  public Object OnAfterDataFields(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Render Menu
    //<< ; TODO: use list of styles isntead of directly writing out background images
    //<< ;
    //<< ; History:
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
    //<< do DisplayUser()
    m$.Cmd.Do("DisplayUser");
    //<< do DisplayLocation()
    m$.Cmd.Do("DisplayLocation");
    //<< 
    //<< &html<<div class="MenuOverviewWrapper">>
    m$.Cmd.WriteHtml("<div class=\"MenuOverviewWrapper\">");
    //<< 
    //<< set intMenuCount = 0
    intMenuCount.set(0);
    //<< set intColCount  = 3
    intColCount.set(3);
    //<< set idApplicn    = $$$WWW013FlexibleMenuApplicationNa($get(^WWW013(0,YBED,1)))
    idApplicn.set(include.WWWConst.$$$WWW013FlexibleMenuApplicationNa(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))));
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
    //<< &html<<hr class="MenuOverviewDivider"/>>
    m$.Cmd.WriteHtml("<hr class=\"MenuOverviewDivider\"/>");
    //<< &html<</div>>
    m$.Cmd.WriteHtml("</div>");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DisplayUser()
  public Object DisplayUser(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 12-Dec-2008   HQN     SR16240: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW013
    mVar objWWW013 = m$.var("objWWW013");
    m$.newVar(objWWW013);
    //<< 
    //<< set objWWW013 = $get(^WWW013(0,YBED,1))                ; "User"
    objWWW013.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
    //<< &html<<div class="UserDetails">#($$$Text(232))#:#($$$WWW013Name(objWWW013))#(#(YBED)#)</div>>
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<div class=\"UserDetails\">",(include.COMSYS.$$$Text(m$,232))),":"),(include.WWWConst.$$$WWW013Name(m$,objWWW013))),"("),(m$.var("YBED").get())),")</div>"));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DisplayLocation()
  public Object DisplayLocation(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 12-Dec-2008   HQN     SR16240: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW0121
    mVar objWWW0121 = m$.var("objWWW0121");
    m$.newVar(objWWW0121);
    //<< 
    //<< set objWWW0121 = $get(^WWW0121(0,0,YLOCATION,1))      ;  "Location"
    objWWW0121.set(m$.Fnc.$get(m$.var("^WWW0121",0,0,m$.var("YLOCATION").get(),1)));
    //<< &html<<div class="LocationDetails">#($$$Text(388))#:#(YLOCATION)# - #($$$WWW0121LocationName(objWWW0121))#</div>>
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<div class=\"LocationDetails\">",(include.COMSYS.$$$Text(m$,388))),":"),(m$.var("YLOCATION").get()))," - "),(include.WWWConst.$$$WWW0121LocationName(m$,objWWW0121))),"</div>"));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DisplayStyle()
  public Object DisplayStyle(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 22-Apr-2010   shobby  SR17253: Cross-Browser Support
    //<< ; 12-Dec-2008   HQN     SR16240: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW012,strColourLeft,strColourRight,strImageDirectory
    mVar objWWW012 = m$.var("objWWW012");
    mVar strColourLeft = m$.var("strColourLeft");
    mVar strColourRight = m$.var("strColourRight");
    mVar strImageDirectory = m$.var("strImageDirectory");
    m$.newVar(objWWW012,strColourLeft,strColourRight,strImageDirectory);
    //<< 
    //<< set objWWW012 = $get(^WWW012(0,0,1))
    objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
    //<< ; $$$SysEnum("FARBE",$$$WWW012ColorforWarnings(objCompany))
    //<< set strColourLeft     = $$$SysEnum("FARBE",$$$WWW012ColorCodeForHeaderLeft(objWWW012))
    strColourLeft.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012ColorCodeForHeaderLeft(m$,objWWW012)));
    //<< set strColourRight    = $$$SysEnum("FARBE",$$$WWW012ColorCodeForHeaderRight(objWWW012))
    strColourRight.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012ColorCodeForHeaderRight(m$,objWWW012)));
    //<< set strImageDirectory = $translate($$$WWW012PictureDirectorySystem(objWWW012),"\","/")
    strImageDirectory.set(m$.Fnc.$translate(include.WWWConst.$$$WWW012PictureDirectorySystem(m$,objWWW012),"\\","/"));
    //<< &html<
    //<< <style>
    //<< .UserDetails {
    //<< text-align:center;
    //<< background-color:#FFFFFF;
    //<< font-weight:bold;
    //<< color:#333333;
    //<< }
    //<< .LocationDetails {
    //<< text-align:center;
    //<< background-color:#FFFFFF;
    //<< color:#333333;
    //<< }
    //<< .MenuOverviewWrapper {
    //<< color:#000000;
    //<< background-color:#FFFFFF;
    //<< }
    //<< UL.MenuOverview {
    //<< list-style:none;
    //<< width:265px;
    //<< float:left;
    //<< padding:0px;
    //<< margin:0px;
    //<< background-color:#(YWHITE)#;
    //<< }
    //<< UL.MenuOverview DIV.Section {
    //<< height:45px;color:#0B48AE;
    //<< line-height:65px;
    //<< font-weight:bold;
    //<< text-indent: 26px;
    //<< font-size:14px;
    //<< }
    //<< UL.MenuOverview DIV.Section SPAN.Title {
    //<< position:relative;
    //<< top:10px;
    //<< }
    //<< UL.MenuOverview LI A{
    //<< color:#000000;
    //<< text-decoration:underline;
    //<< padding-left:5px;
    //<< }
    //<< UL.MenuOverview A:Hover {
    //<< color: #000000;
    //<< background-color: #E0E0E0;
    //<< }
    //<< UL.MenuOverview LI {
    //<< margin-left:20px;
    //<< list-style-position: inside;
    //<< }
    //<< HR.MenuOverviewDivider {
    //<< clear:left;
    //<< width:795px;
    //<< visibility:hidden;
    //<< }
    //<< .SystemToolbar .Title {
    //<< font-size:medium;
    //<< font-weight:bold;
    //<< color:#(YWHITE)#;
    //<< float:left;
    //<< }
    //<< .Title A:Hover {
    //<< color:#(YWHITE)#;
    //<< }
    //<< .Title .SystemInformation {
    //<< font-size:10px;
    //<< font-style:normal;
    //<< color:#(YWHITE)#;
    //<< }
    //<< .SystemToolbar .NavButton {
    //<< position:relative;
    //<< right:0px;
    //<< top:2px;
    //<< border-width:0;
    //<< vertical-align:middle;
    //<< float:right;
    //<< }
    //<< 
    //<< .SystemToolbar {
    //<< position:relative;
    //<< width:100%;
    //<< border:2px outset;
    //<< background-color:#(strColourLeft)#;
    //<< #($$ImageTransformGradient^WWWFORMCrossBrowserSupportVisual(strColourLeft,strColourRight))#;
    //<< border-right:none;
    //<< }
    //<< LI.default {
    //<< list-style-image:url(#(strImageDirectory)#/html.gif);
    //<< list-style-position:inside;
    //<< }
    //<< </style>
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("        <style>","\n");
    m$.Cmd.WriteHtml("        .UserDetails {","\n");
    m$.Cmd.WriteHtml("            text-align:center;","\n");
    m$.Cmd.WriteHtml("            background-color:#FFFFFF;","\n");
    m$.Cmd.WriteHtml("            font-weight:bold;","\n");
    m$.Cmd.WriteHtml("            color:#333333;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        .LocationDetails {","\n");
    m$.Cmd.WriteHtml("            text-align:center;","\n");
    m$.Cmd.WriteHtml("            background-color:#FFFFFF;","\n");
    m$.Cmd.WriteHtml("            color:#333333;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        .MenuOverviewWrapper {","\n");
    m$.Cmd.WriteHtml("            color:#000000;","\n");
    m$.Cmd.WriteHtml("            background-color:#FFFFFF;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        UL.MenuOverview {","\n");
    m$.Cmd.WriteHtml("            list-style:none;","\n");
    m$.Cmd.WriteHtml("            width:265px;","\n");
    m$.Cmd.WriteHtml("            float:left;","\n");
    m$.Cmd.WriteHtml("            padding:0px;","\n");
    m$.Cmd.WriteHtml("            margin:0px;","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            background-color:",(m$.var("YWHITE").get())),";"),"\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        UL.MenuOverview DIV.Section {","\n");
    m$.Cmd.WriteHtml("            height:45px;color:#0B48AE;","\n");
    m$.Cmd.WriteHtml("            line-height:65px;","\n");
    m$.Cmd.WriteHtml("            font-weight:bold;","\n");
    m$.Cmd.WriteHtml("            text-indent: 26px;","\n");
    m$.Cmd.WriteHtml("            font-size:14px;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        UL.MenuOverview DIV.Section SPAN.Title {","\n");
    m$.Cmd.WriteHtml("            position:relative;","\n");
    m$.Cmd.WriteHtml("            top:10px;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        UL.MenuOverview LI A{","\n");
    m$.Cmd.WriteHtml("            color:#000000;","\n");
    m$.Cmd.WriteHtml("            text-decoration:underline;","\n");
    m$.Cmd.WriteHtml("            padding-left:5px;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        UL.MenuOverview A:Hover {","\n");
    m$.Cmd.WriteHtml("            color: #000000;","\n");
    m$.Cmd.WriteHtml("            background-color: #E0E0E0;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        UL.MenuOverview LI {","\n");
    m$.Cmd.WriteHtml("            margin-left:20px;","\n");
    m$.Cmd.WriteHtml("            list-style-position: inside;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        HR.MenuOverviewDivider {","\n");
    m$.Cmd.WriteHtml("            clear:left;","\n");
    m$.Cmd.WriteHtml("            width:795px;","\n");
    m$.Cmd.WriteHtml("            visibility:hidden;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        .SystemToolbar .Title {","\n");
    m$.Cmd.WriteHtml("            font-size:medium;","\n");
    m$.Cmd.WriteHtml("            font-weight:bold;","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            color:",(m$.var("YWHITE").get())),";"),"\n");
    m$.Cmd.WriteHtml("            float:left;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        .Title A:Hover {","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            color:",(m$.var("YWHITE").get())),";"),"\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        .Title .SystemInformation {","\n");
    m$.Cmd.WriteHtml("            font-size:10px;","\n");
    m$.Cmd.WriteHtml("            font-style:normal;","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            color:",(m$.var("YWHITE").get())),";"),"\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        .SystemToolbar .NavButton {","\n");
    m$.Cmd.WriteHtml("            position:relative;","\n");
    m$.Cmd.WriteHtml("            right:0px;","\n");
    m$.Cmd.WriteHtml("            top:2px;","\n");
    m$.Cmd.WriteHtml("            border-width:0;","\n");
    m$.Cmd.WriteHtml("            vertical-align:middle;","\n");
    m$.Cmd.WriteHtml("            float:right;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        .SystemToolbar {","\n");
    m$.Cmd.WriteHtml("            position:relative;","\n");
    m$.Cmd.WriteHtml("            width:100%;","\n");
    m$.Cmd.WriteHtml("            border:2px outset;","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            background-color:",(strColourLeft.get())),";"),"\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            ",(m$.fnc$("WWWFORMCrossBrowserSupportVisual.ImageTransformGradient",strColourLeft.get(),strColourRight.get()))),";"),"\n");
    m$.Cmd.WriteHtml("            border-right:none;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        LI.default {","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            list-style-image:url(",(strImageDirectory.get())),"/html.gif);"),"\n");
    m$.Cmd.WriteHtml("            list-style-position:inside;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        </style>","\n");
    m$.Cmd.WriteHtml("    ");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DisplayButtonLine()
  public Object DisplayButtonLine(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; NOTE: Not used
    //<< ;
    //<< ; ByRef:
    //<< ;   YAKTION
    //<< ;   YGIF
    //<< ;   YUCI
    //<< ;   YBED
    //<< ;   YFORM
    //<< ;
    //<< ; History:
    //<< ; 12-Dec-2008   HQN     SR16240: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strTitle,objWWW012,strCGI
    mVar strTitle = m$.var("strTitle");
    mVar objWWW012 = m$.var("objWWW012");
    mVar strCGI = m$.var("strCGI");
    m$.newVar(strTitle,objWWW012,strCGI);
    //<< 
    //<< set strTitle  = ""
    strTitle.set("");
    //<< set objWWW012 = $get(^WWW012(0,0,1))
    objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
    //<< set strCGI    = $$WWWCGI2^WWWCGI($$$NO)
    strCGI.set(m$.fnc$("WWWCGI.WWWCGI2",include.COMSYS.$$$NO(m$)));
    //<< &html<
    //<< <style>
    //<< A.MenuButton {
    //<< width:84px;
    //<< height:27px;
    //<< background-image:url(#(YGIF)#MenuOff.gif);
    //<< float:right;
    //<< }
    //<< A.MenuButton:hover{
    //<< background-image:url(#(YGIF)#MenuOn.gif);
    //<< }
    //<< A.OverviewButton {
    //<< width:84px;
    //<< height:27px;
    //<< background-image:url(#(YGIF)#StartOff.gif);
    //<< float:right;
    //<< }
    //<< A.OverviewButton:hover {
    //<< background-image:url(#(YGIF)#StartOn.gif);
    //<< }
    //<< </style>
    //<< <DIV class="SystemToolbar"><A NAME="start"/><span class="Title">#(strTitle)#<a href="#" class="SystemInformation" title="#($$GetSystemInfoTooltip^WWWKOPF())#">(#(YM)#/#(YBED)#)</a></span>
    //<< <IMG class="NavButton" SRC="#(YGIF)#exit.gif" TITLE="#($$^WWWTEXT(33980))#" onClick="top.document.location.href='#($$getLoginPage^WWWLogin())#';"/>
    //<< <a href="#(YAKTION)#EP=WWWFORM&YFORM=#(YFORM)#&YKEY=#(strCGI)#" class="OverviewButton" title="Overview"></a>
    //<< <a href="#(YAKTION)#EP=WWWMENU#(strCGI)#" target="FRAME3#(YUSER)#" onclick="parent.showMenu(1);return false;" class="MenuButton" title="Menu"></a>
    //<< </DIV>
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("    <style>","\n");
    m$.Cmd.WriteHtml("        A.MenuButton {","\n");
    m$.Cmd.WriteHtml("            width:84px;","\n");
    m$.Cmd.WriteHtml("            height:27px;","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            background-image:url(",(m$.var("YGIF").get())),"MenuOff.gif);"),"\n");
    m$.Cmd.WriteHtml("            float:right;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        A.MenuButton:hover{","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            background-image:url(",(m$.var("YGIF").get())),"MenuOn.gif);"),"\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        A.OverviewButton {","\n");
    m$.Cmd.WriteHtml("            width:84px;","\n");
    m$.Cmd.WriteHtml("            height:27px;","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            background-image:url(",(m$.var("YGIF").get())),"StartOff.gif);"),"\n");
    m$.Cmd.WriteHtml("            float:right;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        A.OverviewButton:hover {","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            background-image:url(",(m$.var("YGIF").get())),"StartOn.gif);"),"\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("    </style>","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("    <DIV class=\"SystemToolbar\"><A NAME=\"start\"/><span class=\"Title\">",(strTitle.get())),"<a href=\"#\" class=\"SystemInformation\" title=\""),(m$.fnc$("WWWKOPF.GetSystemInfoTooltip"))),"\">("),(m$.var("YM").get())),"/"),(m$.var("YBED").get())),")</a></span>"),"\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("    <IMG class=\"NavButton\" SRC=\"",(m$.var("YGIF").get())),"exit.gif\" TITLE=\""),(m$.fnc$("WWWTEXT.main",33980))),"\" onClick=\"top.document.location.href='"),(m$.fnc$("WWWLogin.getLoginPage"))),"';\"/>"),"\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("    <a href=\"",(m$.var("YAKTION").get())),"EP=WWWFORM&YFORM="),(m$.var("YFORM").get())),"&YKEY="),(strCGI.get())),"\" class=\"OverviewButton\" title=\"Overview\"></a>"),"\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("    <a href=\"",(m$.var("YAKTION").get())),"EP=WWWMENU"),(strCGI.get())),"\" target=\"FRAME3"),(m$.var("YUSER").get())),"\" onclick=\"parent.showMenu(1);return false;\" class=\"MenuButton\" title=\"Menu\"></a>"),"\n");
    m$.Cmd.WriteHtml("    </DIV>","\n");
    m$.Cmd.WriteHtml("    ");
    //<< ;&html<<TABLE><TR><TD></TD>>
    //<< ;                                                      ; 33980 "Logout"
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetMenu(pidUser,pidRootNode,&arrUserMenu)
  public Object GetMenu(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidRootNode = m$.newVarRef("pidRootNode",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar arrUserMenu = m$.newVarRef("arrUserMenu",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Retrieves all menus (1 level deep) that are accessable based on a list of
    //<< ; AccessProfiles
    //<< ;
    //<< ; ByRef:
    //<< ;   YM      Company ID
    //<< ; History:
    //<< ; 15-Nov-2010   PPP     SR17614: Include items that have only the link to defined and not delete it
    //<< ; 27-Apr-2010   GRF     SR16402: Don't pass YM to Get^WWW004 - always 0;
    //<< ;                           variables not newed
    //<< ; 28-Feb-2009   HQN     SR16402: Use $$Get^WWW004 to obtain localised record
    //<< ; 28-Jan-2009   SCR     SR16240: Changed WWWACCESS useage
    //<< ; 12-Dec-2008   HQN     SR16240: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnOK,idMenu,intMenuCount,loopMenu,objMenu,strUser
    mVar blnOK = m$.var("blnOK");
    mVar idMenu = m$.var("idMenu");
    mVar intMenuCount = m$.var("intMenuCount");
    mVar loopMenu = m$.var("loopMenu");
    mVar objMenu = m$.var("objMenu");
    mVar strUser = m$.var("strUser");
    m$.newVar(blnOK,idMenu,intMenuCount,loopMenu,objMenu,strUser);
    //<< 
    //<< set arrUserMenu = ""
    arrUserMenu.set("");
    //<< 
    //<< set strUser = $get(^WWW013(0,pidUser,1))
    strUser.set(m$.Fnc.$get(m$.var("^WWW013",0,pidUser.get(),1)));
    //<< if strUser '= "" {
    if (mOp.NotEqual(strUser.get(),"")) {
      //<< set idMenu = ""
      idMenu.set("");
      //<< if ($data(^WWW004(0,pidRootNode)) '= 0) {
      if ((mOp.NotEqual(m$.Fnc.$data(m$.var("^WWW004",0,pidRootNode.get())),0))) {
        //<< for {
        for (;true;) {
          //<< set idMenu = $order(^WWW004(0,pidRootNode,idMenu))
          idMenu.set(m$.Fnc.$order(m$.var("^WWW004",0,pidRootNode.get(),idMenu.get())));
          //<< quit:idMenu=""
          if (mOp.Equal(idMenu.get(),"")) {
            break;
          }
          //<< 
          //<< set objMenu = $$Get^WWW004(pidRootNode,idMenu)
          objMenu.set(m$.fnc$("WWW004.Get",pidRootNode.get(),idMenu.get()));
          //<< if ($$^WWWACCESS($$$WWW004UserAccess(objMenu),$$$WWW004Module1(objMenu),pidUser) = $$$OK) {
          if ((mOp.Equal(m$.fnc$("WWWACCESS.main",include.WWWConst.$$$WWW004UserAccess(m$,objMenu),include.WWWConst.$$$WWW004Module1(m$,objMenu),pidUser.get()),include.COMSYS.$$$OK(m$)))) {
            //<< if ($data(arrUserMenu($piece(idMenu,".",1)_".")) = 0) {
            if ((mOp.Equal(m$.Fnc.$data(arrUserMenu.var(mOp.Concat(m$.Fnc.$piece(idMenu.get(),".",1),"."))),0))) {
              //<< set intMenuCount = 1
              intMenuCount.set(1);
            }
            //<< } else {
            else {
              //<< set intMenuCount = $length($get(arrUserMenu($piece(idMenu,".",1)_".")),";") + 1
              intMenuCount.set(mOp.Add(m$.Fnc.$length(m$.Fnc.$get(arrUserMenu.var(mOp.Concat(m$.Fnc.$piece(idMenu.get(),".",1),"."))),";"),1));
            }
            //<< }
            //<< if ($piece(idMenu,".",2)'="") && ($piece(idMenu,".",3)="") {
            if ((mOp.NotEqual(m$.Fnc.$piece(idMenu.get(),".",2),"")) && (mOp.Equal(m$.Fnc.$piece(idMenu.get(),".",3),""))) {
              //<< set $piece(arrUserMenu($piece(idMenu,".",1)_"."),";",intMenuCount) = idMenu
              m$.pieceVar(arrUserMenu.var(mOp.Concat(m$.Fnc.$piece(idMenu.get(),".",1),".")),";",intMenuCount.get()).set(idMenu.get());
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
    //<< 
    //<< ; Remove invalid entries for this menu type...
    //<< ; No leaf nodes, remove
    //<< ; No sub entries allowed
    //<< set idMenu = ""
    idMenu.set("");
    //<< for {
    for (;true;) {
      //<< set idMenu = $order(arrUserMenu(idMenu))
      idMenu.set(m$.Fnc.$order(arrUserMenu.var(idMenu.get())));
      //<< quit:idMenu=""
      if (mOp.Equal(idMenu.get(),"")) {
        break;
      }
      //<< 
      //<< set blnOK = $$$NO
      blnOK.set(include.COMSYS.$$$NO(m$));
      //<< for loopMenu=1:1:$length(arrUserMenu(idMenu),";") {
      for (loopMenu.set(1);(mOp.LessOrEqual(loopMenu.get(),m$.Fnc.$length(arrUserMenu.var(idMenu.get()).get(),";")));loopMenu.set(mOp.Add(loopMenu.get(),1))) {
        //<< //SR17614
        //<< set objMenu = $$Get^WWW004(pidRootNode,$piece(arrUserMenu(idMenu),";",loopMenu))
        objMenu.set(m$.fnc$("WWW004.Get",pidRootNode.get(),m$.Fnc.$piece(arrUserMenu.var(idMenu.get()).get(),";",loopMenu.get())));
        //<< if ($$$WWW004FormName(objMenu) '= "") || ($$$WWW004LinkWith(objMenu) '= "") {
        if ((mOp.NotEqual(include.WWWConst.$$$WWW004FormName(m$,objMenu),"")) || (mOp.NotEqual(include.WWWConst.$$$WWW004LinkWith(m$,objMenu),""))) {
          //<< set blnOK = $$$YES
          blnOK.set(include.COMSYS.$$$YES(m$));
          //<< quit
          break;
        }
      }
      //<< }
      //<< }
      //<< if (blnOK = $$$NO) kill arrUserMenu(idMenu)
      if ((mOp.Equal(blnOK.get(),include.COMSYS.$$$NO(m$)))) {
        arrUserMenu.var(idMenu.get()).kill();
      }
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetMenuDescription(pidApplicn,pidSection) ; NOT USED
  public Object GetMenuDescription(Object ... _p) {
    mVar pidApplicn = m$.newVarRef("pidApplicn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidSection = m$.newVarRef("pidSection",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit
    return null;
  }

//<< 
//<< 
}
