//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMegaMenuFlexible
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-04 15:00:24
//*****************************************************************************

import mLibrary.*;

//<< #include COMConst
import include.COMConst;
import include.COMSYS;

//<< WWWMegaMenuFlexible
public class WWWMegaMenuFlexible extends mClass {

  public void main() {
    _WWWMegaMenuFlexible();
  }

  public void _WWWMegaMenuFlexible() {
  }

  //<< 
  //<< Flexibles()
  public Object Flexibles(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Looks for any Menus under the 'Mega' menu.
    //<< ;
    //<< ; History:
    //<< ; 27-May-2013   shobby  CORE-110.1: MegaMenu application is user defined now.
    //<< ; 17-Apr-2012   shobby  SR17998: Created..
    //<< ;-------------------------------------------------------------------------------
    //<< new idMenu,intCounter,objWWW013,idMega ;CORE-110.1
    mVar idMenu = m$.var("idMenu");
    mVar intCounter = m$.var("intCounter");
    mVar objWWW013 = m$.var("objWWW013");
    mVar idMega = m$.var("idMega");
    m$.newVar(idMenu,intCounter,objWWW013,idMega);
    //<< 
    //<< set intCounter=0
    intCounter.set(0);
    //<< 
    //<< set objWWW013=$get(^WWW013(0,YBED,1))
    objWWW013.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
    //<< set idMega=$$GetMegaMenuApplicationName^WWWMegaMenu()
    idMega.set(m$.fnc$("WWWMegaMenu.GetMegaMenuApplicationName"));
    //<< set idMenu="" for { set idMenu=$order(^WWW004(0,idMega,idMenu)) quit:idMenu=""
    idMenu.set("");
    for (;true;) {
      idMenu.set(m$.Fnc.$order(m$.var("^WWW004",0,idMega.get(),idMenu.get())));
      if (mOp.Equal(idMenu.get(),"")) {
        break;
      }
      //<< continue:$piece(idMenu,".",2)'=""
      if (mOp.NotEqual(m$.Fnc.$piece(idMenu.get(),".",2),"")) {
        continue;
      }
      //<< continue:$piece($order(^WWW004(0,idMega,idMenu)),".",1)'=$piece(idMenu,".",1)
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,idMega.get(),idMenu.get())),".",1),m$.Fnc.$piece(idMenu.get(),".",1))) {
        continue;
      }
      //<< if ((";"_$$$WWW013MegaMenus(objWWW013)_";")[(";"_idMenu_";"))||($$$WWW013MegaMenus(objWWW013)="") {
      if ((mOp.Contains((mOp.Concat(mOp.Concat(";",include.WWWConst.$$$WWW013MegaMenus(m$,objWWW013)),";")),(mOp.Concat(mOp.Concat(";",idMenu.get()),";")))) || (mOp.Equal(include.WWWConst.$$$WWW013MegaMenus(m$,objWWW013),""))) {
        //<< set intCounter=intCounter+1
        intCounter.set(mOp.Add(intCounter.get(),1));
        //<< do Flexible(idMenu,10+intCounter)
        m$.Cmd.Do("Flexible",idMenu.get(),mOp.Add(10,intCounter.get()));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Flexible(pidMenu,pintMenu)
  public Object Flexible(Object ... _p) {
    mVar pidMenu = m$.newVarRef("pidMenu",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintMenu = m$.newVarRef("pintMenu",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Render Menu
    //<< ; TODO: use list of styles isntead of directly writing out background images
    //<< ;
    //<< ; History:
    //<< ; 13-Jun-2013   shobby  CORE-128: Transfer trigger for flexible menu.
    //<< ; 06-Jun-2013   shobby  Adhoc: Removed height:100% on overviewwrapper
    //<< ; 31-May-2013   shobby  CORE-112.7: Improve layout for menus with > or < 3 columns (from Gustavo)
    //<< ; 27-May-2013   shobby  CORE-110.1: MegaMenu application is user defined now.
    //<< ; 22-May-2013   shobby  CORE-107.3: Don't show if no items.
    //<< ; 20-May-2013   shobby  CORE-81.3.2: Fixes icon and item text vertical alignment
    //<< ; 20-May-2013   shobby  CORE-81.3.1: Fixes text vertical alignment
    //<< ; 17-Apr-2012   shobby  SR17998: Based on flexible menu.
    //<< ;-------------------------------------------------------------------------------
    //<< new arrUserMenu,idApplicn,idSection,intColCount
    mVar arrUserMenu = m$.var("arrUserMenu");
    mVar idApplicn = m$.var("idApplicn");
    mVar idSection = m$.var("idSection");
    mVar intColCount = m$.var("intColCount");
    m$.newVar(arrUserMenu,idApplicn,idSection,intColCount);
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
    //<< new strMenuName,strLeft
    mVar strMenuName = m$.var("strMenuName");
    mVar strLeft = m$.var("strLeft");
    m$.newVar(strMenuName,strLeft);
    //<< new numberOfColumns,idColumn,styleNoColumns ;CORE-112.7
    mVar numberOfColumns = m$.var("numberOfColumns");
    mVar idColumn = m$.var("idColumn");
    mVar styleNoColumns = m$.var("styleNoColumns");
    m$.newVar(numberOfColumns,idColumn,styleNoColumns);
    //<< new strTrigger ;CORE-128
    mVar strTrigger = m$.var("strTrigger");
    m$.newVar(strTrigger);
    //<< 
    //<< set idApplicn=$$GetMegaMenuApplicationName^WWWMegaMenu() ;SR17998 ;CORE-110.1
    idApplicn.set(m$.fnc$("WWWMegaMenu.GetMegaMenuApplicationName"));
    //<< do GetMenu(YBED,idApplicn,pidMenu,.arrUserMenu) ;CORE-107.3
    m$.Cmd.Do("GetMenu",m$.var("YBED").get(),idApplicn.get(),pidMenu.get(),arrUserMenu);
    //<< if $data(arrUserMenu) {                         ;CORE-107.3
    if (mOp.Logical(m$.Fnc.$data(arrUserMenu))) {
      //<< //--Count the number of columns under a main folder and define area width    ;CORE-112.7 vvvv
      //<< set numberOfColumns = 0
      numberOfColumns.set(0);
      //<< set idColumn = ""
      idColumn.set("");
      //<< for {
      for (;true;) {
        //<< set idColumn = $order(arrUserMenu(idColumn))
        idColumn.set(m$.Fnc.$order(arrUserMenu.var(idColumn.get())));
        //<< quit:(idColumn = "")
        if ((mOp.Equal(idColumn.get(),""))) {
          break;
        }
        //<< 
        //<< set numberOfColumns = $increment(numberOfColumns)
        numberOfColumns.set(m$.Fnc.$increment(numberOfColumns));
      }
      //<< }
      //<< 
      //<< set styleNoColumns = $case(numberOfColumns,1:"column1",2:"columns2",3:"columns3",4:"columns4")
      styleNoColumns.set(m$.Fnc.$case(numberOfColumns.get(),1,"column1",2,"columns2",3,"columns3",4,"columns4"));
      //<< set:(styleNoColumns > 4) styleNoColumns = "columns4"
      if ((mOp.Greater(styleNoColumns.get(),4))) {
        styleNoColumns.set("columns4");
      }
      //<< set:(styleNoColumns = "") styleNoColumns = "columns3"
      if ((mOp.Equal(styleNoColumns.get(),""))) {
        styleNoColumns.set("columns3");
      }
      //<< 
      //<< //-------                                                                   ;CORE-112.7 ^^^^
      //<< set strMenuName=$$$WWW004MenuDescription($$Get^WWW004(idApplicn,pidMenu))
      strMenuName.set(include.WWWConst.$$$WWW004MenuDescription(m$,m$.fnc$("WWW004.Get",idApplicn.get(),pidMenu.get())));
      //<< 
      //<< set strLeft=""
      strLeft.set("");
      //<< if pintMenu=11 set strLeft="margin-left:0px;"
      if (mOp.Equal(pintMenu.get(),11)) {
        strLeft.set("margin-left:0px;");
      }
      //<< &html<
      //<< <li id='menuLi_#(pintMenu)#' class='li' hclass='lihover' zclass='li' style='#(strLeft)#'><a id='menuA_#(pintMenu)#' href="#" class="drop"><span style='text-align:center;'>#(strMenuName)#</span></a><!-- Begin 4 columns Item -->
      //<< <div id='menuDiv_#(pintMenu)#' class="dropdown_flexible #(styleNoColumns)#"  zclass="dropdown_flexible" ><!-- Begin 4 columns container -->
      //<< >
      m$.Cmd.WriteHtml("","\n");
      m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("        <li id='menuLi_",(pintMenu.get())),"' class='li' hclass='lihover' zclass='li' style='"),(strLeft.get())),"'><a id='menuA_"),(pintMenu.get())),"' href=\"#\" class=\"drop\"><span style='text-align:center;'>"),(strMenuName.get())),"</span></a><!-- Begin 4 columns Item -->"),"\n");
      m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("            <div id='menuDiv_",(pintMenu.get())),"' class=\"dropdown_flexible "),(styleNoColumns.get())),"\"  zclass=\"dropdown_flexible\" ><!-- Begin 4 columns container -->"),"\n");
      m$.Cmd.WriteHtml("        ");
      //<< ;CORE-81
      //<< &html<<div class="OverviewWrapper" onmouseover='window.event.returnValue=false; window.event.cancelBubble=true; return false;'>>
      m$.Cmd.WriteHtml("<div class=\"OverviewWrapper\" onmouseover='window.event.returnValue=false; window.event.cancelBubble=true; return false;'>");
      //<< 
      //<< set intColCount  = 3
      intColCount.set(3);
      //<< set strImageDirectory = $translate($piece($get(^WWW012(0,0,1)),"~",47),"\","/")
      strImageDirectory.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),"~",47),"\\","/"));
      //<< ;CORE-107.3 do GetMenu(YBED,idApplicn,pidMenu,.arrUserMenu)
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
        //<< if strImage="" set strImage="Mega_empty.png" ;CORE-107.3
        if (mOp.Equal(strImage.get(),"")) {
          strImage.set("Mega_empty.png");
        }
        //<< ;CORE-81, CORE-81.3.1
        //<< &html<
        //<< <ul class="Overview" style='padding:5px; padding-right:0px; width:265px; float:left; height:100%; clear:right;'>
        //<< <div class="Section" style="margin-left:0px; left:-15px; margin-right:0px; width:265px; height:65px; background-image: url(#(strImageDirectory)#/#(strImage)#); padding-top:8px; background-repeat:no-repeat;">
        //<< <span>#($$$WWW004MenuDescription(objMenu))#</span>
        //<< </div>
        //<< >
        m$.Cmd.WriteHtml("","\n");
        m$.Cmd.WriteHtml("                <ul class=\"Overview\" style='padding:5px; padding-right:0px; width:265px; float:left; height:100%; clear:right;'>","\n");
        m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                    <div class=\"Section\" style=\"margin-left:0px; left:-15px; margin-right:0px; width:265px; height:65px; background-image: url(",(strImageDirectory.get())),"/"),(strImage.get())),"); padding-top:8px; background-repeat:no-repeat;\">"),"\n");
        m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                        <span>",(include.WWWConst.$$$WWW004MenuDescription(m$,objMenu))),"</span>"),"\n");
        m$.Cmd.WriteHtml("                    </div>","\n");
        m$.Cmd.WriteHtml("            ");
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
          //<< set strTrigger = $piece(objSubmenu,Y,7) ;CORE-128
          strTrigger.set(m$.Fnc.$piece(objSubmenu.get(),m$.var("Y").get(),7));
          //<< ;set strTrigger = $$$WWW004TransferTriggerForForm(objSubMenu) ;CORE-128
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
            //<< ;CORE-128 set strLink = YAKTION_"EP=WWWFORM&YFORM="_strForm_"&YUCI="_YUCI_"&YBED="_YBED_"&YM="_YM_"&YUSER="_YUSER_"&YBACK="_YFORM_","
            //<< set strLink = YAKTION_"EP=WWWFORM&YFORM="_strForm_"&YUCI="_YUCI_"&YBED="_YBED_"&YM="_YM_"&YPARA="_strTrigger_"&YUSER="_YUSER_"&YBACK="_YFORM_"," ;CORE-128
            strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&YFORM="),strForm.get()),"&YUCI="),m$.var("YUCI").get()),"&YBED="),m$.var("YBED").get()),"&YM="),m$.var("YM").get()),"&YPARA="),strTrigger.get()),"&YUSER="),m$.var("YUSER").get()),"&YBACK="),m$.var("YFORM").get()),","));
          }
          //<< 
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
              //<< ;CORE-81.3.2 set strCSSClass = " style=""list-style-type:square; list-style-image:url("_strImageDirectory_"/"_strImage_"); """
              //<< set strCSSClass = " style=""list-style-type:none;list-style-position:outside;padding-left:17px;background-image:url("_strImageDirectory_"/"_strImage_");background-repeat:no-repeat;background-position: left 5px; """ ;CORE-81.3.2
              strCSSClass.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" style=\"list-style-type:none;list-style-position:outside;padding-left:17px;background-image:url(",strImageDirectory.get()),"/"),strImage.get()),");background-repeat:no-repeat;background-position: left 5px; \""));
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
      }
      //<< }
      //<< &html<<hr class="OverviewDivider"/>>
      m$.Cmd.WriteHtml("<hr class=\"OverviewDivider\"/>");
      //<< &html<
      //<< </div>
      //<< </div><!-- End 2 columns container -->
      //<< </li><!-- End Home Item -->
      //<< >
      m$.Cmd.WriteHtml("","\n");
      m$.Cmd.WriteHtml("            </div>","\n");
      m$.Cmd.WriteHtml("            </div><!-- End 2 columns container -->   ","\n");
      m$.Cmd.WriteHtml("        </li><!-- End Home Item -->","\n");
      m$.Cmd.WriteHtml("        ");
    }
    //<< } ;CORE-107.3
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetMenu(pidUser,pidRootNode,pidNode,&arrUserMenu)
  public Object GetMenu(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidRootNode = m$.newVarRef("pidRootNode",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidNode = m$.newVarRef("pidNode",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar arrUserMenu = m$.newVarRef("arrUserMenu",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Retrieves all menus (2 level deep) that are accessable based on a list of
    //<< ; AccessProfiles
    //<< ;
    //<< ; ByRef:
    //<< ;   YM      Company ID
    //<< ; History:
    //<< ; 19-Apr-2012   shobby  SR17998: Based on code from Flexible menu
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
    //<< kill arrUserMenu
    arrUserMenu.kill();
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
          //<< continue:$extract(idMenu,1,$length(pidNode))'=pidNode
          if (mOp.NotEqual(m$.Fnc.$extract(idMenu.get(),1,m$.Fnc.$length(pidNode.get())),pidNode.get())) {
            continue;
          }
          //<< continue:idMenu=pidNode
          if (mOp.Equal(idMenu.get(),pidNode.get())) {
            continue;
          }
          //<< 
          //<< set objMenu = $$Get^WWW004(pidRootNode,idMenu)
          objMenu.set(m$.fnc$("WWW004.Get",pidRootNode.get(),idMenu.get()));
          //<< if ($$^WWWACCESS($$$WWW004UserAccess(objMenu),$$$WWW004Module1(objMenu),pidUser) = $$$OK) {
          if ((mOp.Equal(m$.fnc$("WWWACCESS.main",include.WWWConst.$$$WWW004UserAccess(m$,objMenu),include.WWWConst.$$$WWW004Module1(m$,objMenu),pidUser.get()),include.COMSYS.$$$OK(m$)))) {
            //<< ;break
            //<< if ($data(arrUserMenu($piece(idMenu,".",1,2)_".")) = 0) {
            if ((mOp.Equal(m$.Fnc.$data(arrUserMenu.var(mOp.Concat(m$.Fnc.$piece(idMenu.get(),".",1,2),"."))),0))) {
              //<< set intMenuCount = 1
              intMenuCount.set(1);
            }
            //<< } else {
            else {
              //<< set intMenuCount = $length($get(arrUserMenu($piece(idMenu,".",1,2)_".")),";") + 1
              intMenuCount.set(mOp.Add(m$.Fnc.$length(m$.Fnc.$get(arrUserMenu.var(mOp.Concat(m$.Fnc.$piece(idMenu.get(),".",1,2),"."))),";"),1));
            }
            //<< }
            //<< if ($piece(idMenu,".",3)'="") && ($piece(idMenu,".",4)="") {
            if ((mOp.NotEqual(m$.Fnc.$piece(idMenu.get(),".",3),"")) && (mOp.Equal(m$.Fnc.$piece(idMenu.get(),".",4),""))) {
              //<< set $piece(arrUserMenu($piece(idMenu,".",1,2)_"."),";",intMenuCount) = idMenu
              m$.pieceVar(arrUserMenu.var(mOp.Concat(m$.Fnc.$piece(idMenu.get(),".",1,2),".")),";",intMenuCount.get()).set(idMenu.get());
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
}
