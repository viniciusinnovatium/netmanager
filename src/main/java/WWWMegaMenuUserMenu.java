//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMegaMenuUserMenu
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-04 15:00:25
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

//<< WWWMegaMenuUserMenu
public class WWWMegaMenuUserMenu extends mClass {

  public void main() {
    _WWWMegaMenuUserMenu();
  }

  public void _WWWMegaMenuUserMenu() {
  }

  //<< 
  //<< GetUserMenu()
  public Object GetUserMenu(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Right most menu on screen.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Jun-2013   shobby      CORE-123: Additonal options for Home Page and User Guide.
    //<< ; 31-May-2013   shobby      CORE-110.2: Allow user defined additions to the User Menu.
    //<< ; 21-May-2013   shobby      CORE-81.3.19: Add user email details in the User Menu section
    //<< ; 21-May-2013   shobby      CORE-81.3.18: Change Logout Button layout and remove unnecessary <li>
    //<< ; 21-May-2013   shobby      CORE-81.3.17: Enhance vertical alignment for menu items and change from language text to form name
    //<< ; 21-May-2013   shobby      CORE-81.3.16: Remove Preferences from User Menu (comment out)
    //<< ; 21-May-2013   shobby      CORE-81.3.14. Add <strong> tag to user ID in mega top right
    //<< ; 20-May-2013   shobby      CORE-81.3.3: Enhances User Menu padding
    //<< ; 04-Jul-2012   shobby      SR17998: Back button functionality.
    //<< ; 07-May-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new HTML,YKEY,YYBACK
    mVar HTML = m$.var("HTML");
    mVar YKEY = m$.var("YKEY");
    mVar YYBACK = m$.var("YYBACK");
    m$.newVar(HTML,YKEY,YYBACK);
    //<< new idForm,objWWW013,lstForms,intLoop,objWWW120,startForm ;CORE-110.2
    mVar idForm = m$.var("idForm");
    mVar objWWW013 = m$.var("objWWW013");
    mVar lstForms = m$.var("lstForms");
    mVar intLoop = m$.var("intLoop");
    mVar objWWW120 = m$.var("objWWW120");
    mVar startForm = m$.var("startForm");
    m$.newVar(idForm,objWWW013,lstForms,intLoop,objWWW120,startForm);
    //<< 
    //<< set YYBACK=YBACK
    YYBACK.set(m$.var("YBACK").get());
    //<< 
    //<< new YBACK
    mVar YBACK = m$.var("YBACK");
    m$.newVar(YBACK);
    //<< set YBACK=YYBACK_YFORM_","
    YBACK.set(mOp.Concat(mOp.Concat(YYBACK.get(),m$.var("YFORM").get()),","));
    //<< 
    //<< new YFORM
    mVar YFORM = m$.var("YFORM");
    m$.newVar(YFORM);
    //<< set YFORM="WWW013"
    YFORM.set("WWW013");
    //<< set YKEY=YBED
    YKEY.set(m$.var("YBED").get());
    //<< 
    //<< set objWWW013=$get(^WWW013(YM,YBED,1))
    objWWW013.set(m$.Fnc.$get(m$.var("^WWW013",m$.var("YM").get(),m$.var("YBED").get(),1)));
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< &html<
    //<< <li id='menuLi_3' class='menu_right' hclass='lihover_right' zclass='menu_right'  #($$Events^WWWMegaMenu())#><a id='menuA_3' href="#" class='drop' zclass='drop'> <strong>#(YBED)#</strong> </a><!-- Begin User -->
    //<< <div id='menuDiv_3' class='dropdown_right' zclass='dropdown_right' style="padding:15px; float:right; margin-right:0px;">
    //<< <div id='menuDivCol_3' class="col_2">
    //<< <h2 id='menuH2_3' style="border: 0;margin-bottom:0;padding-bottom:2px">#($$$WWW013Name(objWWW013))#</h2>
    //<< <div style="font-size:12px;border-bottom: 1px solid #666666;margin-bottom:10px;padding-bottom:6px">Email: #($$$WWW013EMailAddress(objWWW013))#
    //<< </div>
    //<< </div>
    //<< <div class="col_2" style='width:250px;'>
    //<< <ul>
    //<< <!--<li style='width:100%'>
    //<< <p style='margin:0px; cursor:pointer;'>
    //<< <a class='menuitem' href='#(YAKTION)#&EP=WWWFORM&YFORM=#(YFORM_$$WWWCGI2^WWWCGI())#' >
    //<< <img src='#(YGIF_$$GetMenuImage^WWWMegaMenu(YFORM))#' style='position:relative; border:none;'>
    //<< #($$DecodeError^COMUtilError("WWW00176"))#
    //<< </a>
    //<< </p>
    //<< </li>-->
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("    <li id='menuLi_3' class='menu_right' hclass='lihover_right' zclass='menu_right'  ",(m$.fnc$("WWWMegaMenu.Events"))),"><a id='menuA_3' href=\"#\" class='drop' zclass='drop'> <strong>"),(m$.var("YBED").get())),"</strong> </a><!-- Begin User -->"),"\n");
    m$.Cmd.WriteHtml("        <div id='menuDiv_3' class='dropdown_right' zclass='dropdown_right' style=\"padding:15px; float:right; margin-right:0px;\">","\n");
    m$.Cmd.WriteHtml("           <div id='menuDivCol_3' class=\"col_2\">","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                <h2 id='menuH2_3' style=\"border: 0;margin-bottom:0;padding-bottom:2px\">",(include.WWWConst.$$$WWW013Name(m$,objWWW013))),"</h2>"),"\n");
    m$.Cmd.WriteHtml(mOp.Concat("                <div style=\"font-size:12px;border-bottom: 1px solid #666666;margin-bottom:10px;padding-bottom:6px\">Email: ",(include.WWWConst.$$$WWW013EMailAddress(m$,objWWW013))),"\n");
    m$.Cmd.WriteHtml("                </div>","\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("            <div class=\"col_2\" style='width:250px;'>","\n");
    m$.Cmd.WriteHtml("                <ul>","\n");
    m$.Cmd.WriteHtml("                    <!--<li style='width:100%'>","\n");
    m$.Cmd.WriteHtml("                        <p style='margin:0px; cursor:pointer;'>","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                            <a class='menuitem' href='",(m$.var("YAKTION").get())),"&EP=WWWFORM&YFORM="),(mOp.Concat(YFORM.get(),m$.fnc$("WWWCGI.WWWCGI2")))),"' >"),"\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                                <img src='",(mOp.Concat(m$.var("YGIF").get(),m$.fnc$("WWWMegaMenu.GetMenuImage",YFORM.get())))),"' style='position:relative; border:none;'>"),"\n");
    m$.Cmd.WriteHtml(mOp.Concat("                                 ",(m$.fnc$("COMUtilError.DecodeError","WWW00176"))),"\n");
    m$.Cmd.WriteHtml("                            </a>","\n");
    m$.Cmd.WriteHtml("                        </p>","\n");
    m$.Cmd.WriteHtml("                    </li>-->","\n");
    m$.Cmd.WriteHtml("     ");
    //<< 
    //<< set startForm = $$$WWW013StartForm(objWWW013)
    startForm.set(include.WWWConst.$$$WWW013StartForm(m$,objWWW013));
    //<< 
    //<< if (startForm '= "") {
    if ((mOp.NotEqual(startForm.get(),""))) {
      //<< &html<
      //<< <li style='width:100%;list-style-type:none;list-style-position:outside;padding-left:17px;background-image:url(#(YGIF)#homeform.png);background-repeat:no-repeat;background-position: left 5px; height:20px;'>
      //<< <p style='margin:0px; cursor:pointer;'>
      //<< <a class='menuitem' style='padding-left:5px' href='#(YAKTION)#&EP=WWWFORM&YFORM=#(startForm_$$WWWCGI2^WWWCGI())#&YKEY=""' >
      //<< #($$DecodeError^COMUtilError("WWW00182"))#
      //<< </a>
      //<< </p>
      //<< </li>
      //<< >
      m$.Cmd.WriteHtml("","\n");
      m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            <li style='width:100%;list-style-type:none;list-style-position:outside;padding-left:17px;background-image:url(",(m$.var("YGIF").get())),"homeform.png);background-repeat:no-repeat;background-position: left 5px; height:20px;'>"),"\n");
      m$.Cmd.WriteHtml("                  <p style='margin:0px; cursor:pointer;'>","\n");
      m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                        <a class='menuitem' style='padding-left:5px' href='",(m$.var("YAKTION").get())),"&EP=WWWFORM&YFORM="),(mOp.Concat(startForm.get(),m$.fnc$("WWWCGI.WWWCGI2")))),"&YKEY=\"\"' >"),"\n");
      m$.Cmd.WriteHtml(mOp.Concat("                              ",(m$.fnc$("COMUtilError.DecodeError","WWW00182"))),"\n");
      m$.Cmd.WriteHtml("                        </a>","\n");
      m$.Cmd.WriteHtml("                  </p>","\n");
      m$.Cmd.WriteHtml("            </li>","\n");
      m$.Cmd.WriteHtml("      ");
    }
    //<< }
    //<< 
    //<< 
    //<< set lstForms="WWWPWD;WWW0131B;"_$$$WWW013UserMegaMenuOptions(objWWW013)
    lstForms.set(mOp.Concat("WWWPWD;WWW0131B;",include.WWWConst.$$$WWW013UserMegaMenuOptions(m$,objWWW013)));
    //<< for intLoop=1:1:$length(lstForms,";") {
    for (intLoop.set(1);(mOp.LessOrEqual(intLoop.get(),m$.Fnc.$length(lstForms.get(),";")));intLoop.set(mOp.Add(intLoop.get(),1))) {
      //<< set idForm=$piece(lstForms,";",intLoop)
      idForm.set(m$.Fnc.$piece(lstForms.get(),";",intLoop.get()));
      //<< if $translate(idForm," ")'="" {
      if (mOp.NotEqual(m$.Fnc.$translate(idForm.get()," "),"")) {
        //<< set objWWW120=$get(^WWW120(0,idForm,1))
        objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,idForm.get(),1)));
        //<< if $$^WWWACCESS($$$WWW120UserAccess(objWWW120),$$$WWW120Modules(objWWW120),YBED) {
        if (mOp.Logical(m$.fnc$("WWWACCESS.main",include.WWWConst.$$$WWW120UserAccess(m$,objWWW120),include.WWWConst.$$$WWW120Modules(m$,objWWW120),m$.var("YBED").get()))) {
          //<< &html<
          //<< <li style='width:100%;list-style-type:none;list-style-position:outside;padding-left:17px;background-image:url(#(YGIF_$$GetMenuImage^WWWMegaMenu(idForm))#);background-repeat:no-repeat;background-position: left 5px; height:20px;'>
          //<< <p style='margin:0px; cursor:pointer;'>
          //<< <a class='menuitem' style='padding-left:5px' href='#(YAKTION)#&EP=WWWFORM&YFORM=#(idForm_$$WWWCGI2^WWWCGI())#' TITLE='#($$GetLocation^WWWMegaMenu(YLOCATION))#' >
          //<< <!--<img src='#(YGIF_$$GetMenuImage^WWWMegaMenu(idForm))#' style='position:relative; border:none;'>
          //<< #($$DecodeError^COMUtilError("WWW00178"))#-->
          //<< #($$^WWWFORMNAME(idForm))#
          //<< </a>
          //<< </p>
          //<< </li>
          //<< >
          m$.Cmd.WriteHtml("","\n");
          m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                        <li style='width:100%;list-style-type:none;list-style-position:outside;padding-left:17px;background-image:url(",(mOp.Concat(m$.var("YGIF").get(),m$.fnc$("WWWMegaMenu.GetMenuImage",idForm.get())))),");background-repeat:no-repeat;background-position: left 5px; height:20px;'>"),"\n");
          m$.Cmd.WriteHtml("                            <p style='margin:0px; cursor:pointer;'>","\n");
          m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                                <a class='menuitem' style='padding-left:5px' href='",(m$.var("YAKTION").get())),"&EP=WWWFORM&YFORM="),(mOp.Concat(idForm.get(),m$.fnc$("WWWCGI.WWWCGI2")))),"' TITLE='"),(m$.fnc$("WWWMegaMenu.GetLocation",m$.var("YLOCATION").get()))),"' >"),"\n");
          m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                                    <!--<img src='",(mOp.Concat(m$.var("YGIF").get(),m$.fnc$("WWWMegaMenu.GetMenuImage",idForm.get())))),"' style='position:relative; border:none;'>"),"\n");
          m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                                    ",(m$.fnc$("COMUtilError.DecodeError","WWW00178"))),"-->"),"\n");
          m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                                    ",(m$.fnc$("WWWFORMNAME.main",idForm.get())))," "),"\n");
          m$.Cmd.WriteHtml("                                </a>","\n");
          m$.Cmd.WriteHtml("                            </p>","\n");
          m$.Cmd.WriteHtml("                        </li>","\n");
          m$.Cmd.WriteHtml("                    ");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< ;Alphalinc User Guide
    //<< &html<
    //<< <li style='width:100%;list-style-type:none;list-style-position:outside;padding-left:17px;background-image:url(#(YGIF)#help.png);background-repeat:no-repeat;background-position: left 5px; height:20px;'>
    //<< <p style='margin:0px; cursor:pointer;'>
    //<< <a class='menuitem' style='padding-left:5px' target='_blank' href='../../../ensemble/csp/#(YUCI)#/manual/index.csp?User=#(YUSER)#' >
    //<< #($$DecodeError^COMUtilError("WWW00181"))#
    //<< </a>
    //<< </p>
    //<< </li>
    //<< <li style="margin-top:5px;">
    //<< <p style='margin:0px; cursor:pointer;float:right;'>
    //<< <a href="#" class='drop actionButton' style='color:red;width:auto;float:right;padding-right:20px;padding-left:20px;background-color:#E0E0E0;' #($$Logout^WWWMegaMenu())#>#($$DecodeError^COMUtilError(33980))#</a>
    //<< </p>
    //<< 
    //<< </li>
    //<< </ul>
    //<< </div>
    //<< </div>
    //<< </li><!-- End User -->
    //<< 
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                    <li style='width:100%;list-style-type:none;list-style-position:outside;padding-left:17px;background-image:url(",(m$.var("YGIF").get())),"help.png);background-repeat:no-repeat;background-position: left 5px; height:20px;'>"),"\n");
    m$.Cmd.WriteHtml("                          <p style='margin:0px; cursor:pointer;'>","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                                <a class='menuitem' style='padding-left:5px' target='_blank' href='../../../ensemble/csp/",(m$.var("YUCI").get())),"/manual/index.csp?User="),(m$.var("YUSER").get())),"' >"),"\n");
    m$.Cmd.WriteHtml(mOp.Concat("                                      ",(m$.fnc$("COMUtilError.DecodeError","WWW00181"))),"\n");
    m$.Cmd.WriteHtml("                                </a>","\n");
    m$.Cmd.WriteHtml("                          </p>","\n");
    m$.Cmd.WriteHtml("                    </li>","\n");
    m$.Cmd.WriteHtml("                    <li style=\"margin-top:5px;\">","\n");
    m$.Cmd.WriteHtml("                        <p style='margin:0px; cursor:pointer;float:right;'>","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                            <a href=\"#\" class='drop actionButton' style='color:red;width:auto;float:right;padding-right:20px;padding-left:20px;background-color:#E0E0E0;' ",(m$.fnc$("WWWMegaMenu.Logout"))),">"),(m$.fnc$("COMUtilError.DecodeError",33980))),"</a>"),"\n");
    m$.Cmd.WriteHtml("                        </p>","\n");
    m$.Cmd.WriteHtml("                    </li>","\n");
    m$.Cmd.WriteHtml("                </ul>","\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("        </div>","\n");
    m$.Cmd.WriteHtml("    </li><!-- End User -->","\n");
    m$.Cmd.WriteHtml("    ");
    //<< quit HTML
    return HTML.get();
  }

//<< 
//<< 
//<< 
//<< 
//<< 
}
