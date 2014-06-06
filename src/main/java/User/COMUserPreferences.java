//*****************************************************************************
//** TASC - ALPHALINC - CLASS User.COMUserPreferences
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-05 19:31:04
//*****************************************************************************

package User;

import mLibrary.*;

//<< Include (WWWConst, COMSYS)
import include.WWWConst;
//import COMSYS;
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
//<< {
//<< ;-------------------------------------------------------------------------------
//<< ; Method Usage
//<< ;
//<< ; Params:
//<< ;
//<< ; Returns:
//<< ;
//<< ; History:
//<< ; 15-Oct-2008   SCR     SR15550: Added License Allocation
//<< ; 13-Feb-2008   Luis Soeiro:    Change the fullscreen function to be more user friendly
//<< ; 19-Mar-2006   shobby  BR014275: Log a cookie with each successful login.
//<< ; 19-Dec-2006   JW      BR014262: Go through @net code.
//<< ; 02-Nov-2006   shobby  BR014210: If a company is specified in the URL log in to that
//<< ;                       company only if user is entitled, otherwise, it will revert
//<< ;                       to users default company.
//<< ;-------------------------------------------------------------------------------
//<< ;
//<< #include WWWConst
import include.WWWConst;

//<< 
//<< Class User.COMUserPreferences Extends %CSP.Page [ ClassType = "", Not ProcedureBlock ]
public class COMUserPreferences extends mPage {

  //<< {
  //<< 
  //<< ClassMethod OnPage() As %Status
  public Object OnPage() {
    //<< 
    //<< new objWWW013,idCompany
    mVar objWWW013 = m$.var("objWWW013");
    mVar idCompany = m$.var("idCompany");
    m$.newVar(objWWW013,idCompany);
    //<< 
    //<< do ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< 
    //<< set blnSessionLoginOK=$$^WWWLicenseAllocation()   //SCR SR15550 15-Oct-2008
    mVar blnSessionLoginOK = m$.var("blnSessionLoginOK");
    blnSessionLoginOK.set(m$.fnc$("WWWLicenseAllocation.main"));
    //<< 
    //<< if $get(YUSER)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      //<< ;BR014210: If the user exists, company exists and user has entitlements to that company go to that company
      //<< set idCompany=$get(%request.Data("YM",1))
      idCompany.set(m$.Fnc.$get(m$.getRequest().varData("YM",1)));
      //<< if idCompany'="" {
      if (mOp.NotEqual(idCompany.get(),"")) {
        //<< if $data(^WWW012(0,idCompany,1)) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW012",0,idCompany.get(),1)))) {
          //<< if YBED'="" {
          if (mOp.NotEqual(m$.var("YBED").get(),"")) {
            //<< set objWWW013=$get(^WWW013(0,YBED,1))
            objWWW013.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
            //<< if (";"_$$$WWW013EntitledCompany(objWWW013)_";")[(";"_idCompany_";") {
            if (mOp.Contains((mOp.Concat(mOp.Concat(";",include.WWWConst.$$$WWW013EntitledCompany(m$,objWWW013)),";")),(mOp.Concat(mOp.Concat(";",idCompany.get()),";")))) {
              //<< set $$$WWWUSERLastCompany(^WWWUSER(0,YUSER,1))=idCompany
              include.WWWConst.$$$WWWUSERLastCompanySet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),idCompany.get());
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
    //<< do saveLoginPage^WWWLogin()
    m$.Cmd.Do("WWWLogin.saveLoginPage");
    //<< 
    //<< if ..isLoginRight() {
    if (mOp.Logical(m$.fnc$(this,"isLoginRight"))) {
      //<< if ((+$$$WWWClientParamCoreChangesSESPE($get(^WWWClientParam(YM,YM,1)))) ||
      //<< (+$$$WWWClientParamCoreChangesSESDF($get(^WWWClientParam(YM,YM,1)))) ||
      //<< (+$$$WWWClientParamCoreChangesHEVA($get(^WWWClientParam(YM,YM,1))))) {
      if ((mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESPE(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESDF(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesHEVA(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))))) {
        //<< if (('##class(VAR.infra.shadow.ShadowRunner).IsFunctional()) && (YBED'="SHADOW")) {
        if (mOp.Logical(((mOp.Not(m$.fnc$("VAR.infra.shadow.ShadowRunner.IsFunctional"))) && (mOp.NotEqual(m$.var("YBED").get(),"SHADOW"))))) {
          //<< do ##class(User.www).ShowError($$$ERROR($$$UserNotAuthorizedOnSystem,YBED))
          //m$.Cmd.Do("User.www.ShowError",$$$include.$$$ERROR(m$,$$$include.$$$UserNotAuthorizedOnSystem(m$),m$.var("YBED")));
        }
      }
      //<< }
      //<< }
      //<< ;set $piece(^zzUsers(%request.CgiEnvs("REMOTE_ADDR"),$zcvt(%request.Data("YBED",1),"u")),"~",1)=$h
      //<< do AddCookie^COMUtilCookie(%session.SessionId)  ;SRBR014275
      m$.Cmd.Do("COMUtilCookie.AddCookie",m$.getSession().getSessionId());
      //<< if $$$WWW013useFullScreenandHeader($get(^WWW013(0,YBED,1))) {
      if (mOp.Logical(include.WWWConst.$$$WWW013useFullScreenandHeader(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))))) {
        //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
        if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
          //<< do ##class(User.www).Page()
          m$.Cmd.Do("User.www.Page");
        }
        //<< }
        //<< else {
        else {
          //<< do ##class(User.COMLogin).OnPage()
          m$.Cmd.Do("User.COMLogin.OnPage");
          //<< write "<script language=""JavaScript"">",!
          m$.Cmd.Write("<script language=\"JavaScript\">","\n");
          //<< write "var mainWindow;",!
          m$.Cmd.Write("var mainWindow;","\n");
          //<< write "function manualFocus() {",!
          m$.Cmd.Write("function manualFocus() {","\n");
          //<< write "mainWindow.focus();",!
          m$.Cmd.Write("mainWindow.focus();","\n");
          //<< write "}",!
          m$.Cmd.Write("}","\n");
          //<< 
          //<< do ..insertJsFunctionMaximizeWindow()
          m$.Cmd.Do(this,"insertJsFunctionMaximizeWindow");
          //<< 
          //<< write "function openMainWindow(theURL,winName,features) { ",!
          m$.Cmd.Write("function openMainWindow(theURL,winName,features) { ","\n");
          //<< write "mainWindow=window.open(theURL,winName,features);",!
          m$.Cmd.Write("mainWindow=window.open(theURL,winName,features);","\n");
          //<< write "}",!
          m$.Cmd.Write("}","\n");
          //<< //write "openMainWindow('COMParent.cls?EP=WWWFORM&YFORM=WWWPARA"    //BR014262
          //<< write "openMainWindow('www.cls?EP="_$GET(%request.Data("EP",1))
          m$.Cmd.Write(mOp.Concat("openMainWindow('www.cls?EP=",m$.Fnc.$get(m$.getRequest().varData("EP",1))));
          //<< do ^WWWCGI
          m$.Cmd.Do("WWWCGI.main");
          //<< //Do NOT change the features (fullscreen=0,...)!
          //<< write "','5818649','fullscreen=0,resizable=1,titlebar=1,menubar=0,toolbar=0,location=0');",!
          m$.Cmd.Write("','5818649','fullscreen=0,resizable=1,titlebar=1,menubar=0,toolbar=0,location=0');","\n");
          //<< 
          //<< //Call the js code that maximizes and places the new window in the correct position
          //<< write "maximizeWindow(mainWindow);",!
          m$.Cmd.Write("maximizeWindow(mainWindow);","\n");
          //<< 
          //<< write "setTimeout(""manualFocus()"",500);",!
          m$.Cmd.Write("setTimeout(\"manualFocus()\",500);","\n");
          //<< write "var parent = window.self;"
          m$.Cmd.Write("var parent = window.self;");
          //<< write "parent.opener = window.self;"
          m$.Cmd.Write("parent.opener = window.self;");
          //<< ;write "parent.close();"  //karine
          //<< write "parent.window.close();"
          m$.Cmd.Write("parent.window.close();");
          //<< 
          //<< /* Old code
          //<< write "setTimeout(""manualFocus()"",500);",!
          //<< write "var parent = window.self;"
          //<< write "parent.opener = window.self;"
          //<< ;write "parent.close();"  //karine
          //<< write "parent.window.close();"
          //<< */
          //<< 
          //<< write "</script>"
          m$.Cmd.Write("</script>");
        }
      }
      //<< }
      //<< } else {
      else {
        //<< do ##class(User.www).Page()
        m$.Cmd.Do("User.www.Page");
      }
    }
    //<< }
    //<< } else {
    else {
      //<< do ##class(User.www).Page()
      m$.Cmd.Do("User.www.Page");
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  //<< }
  }

  //<< 
  //<< ClassMethod insertJsFunctionMaximizeWindow()
  public Object insertJsFunctionMaximizeWindow() {
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; This method writes to the current output (the new html page) a new javascript
    //<< ; function that maximizes the window specified as a parameter and also puts it
    //<< ; in the position 0,0.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Dec-2006   Luis Soeiro:    Created
    //<< ;-------------------------------------------------------------------------------
    //<< ; FIXME : see http://www-archive.mozilla.org/docs/web-developer/csspapi/csspapi.html
    //<< ;         document.layers[] are obsolete proprietory extensions supported by Navigator 4 - not in mozilla or netscape 6
    //<< 
    //<< write !
    m$.Cmd.Write("\n");
    //<< write !,"function maximizeWindow(refWindow) {"
    m$.Cmd.Write("\n","function maximizeWindow(refWindow) {");
    //<< write !,"  refWindow.top.window.moveTo(0,0);"
    m$.Cmd.Write("\n","  refWindow.top.window.moveTo(0,0);");
    //<< write !,"  if (refWindow.document.all) {"
    m$.Cmd.Write("\n","  if (refWindow.document.all) {");
    //<< write !,"  refWindow.top.window.resizeTo(screen.availWidth,screen.availHeight);"
    m$.Cmd.Write("\n","  refWindow.top.window.resizeTo(screen.availWidth,screen.availHeight);");
    //<< write !,"  }"
    m$.Cmd.Write("\n","  }");
    //<< write !,"  else"
    m$.Cmd.Write("\n","  else");
    //<< write !,"   if (refWindow.document.layers||refWindow.document.getElementById) {"
    m$.Cmd.Write("\n","   if (refWindow.document.layers||refWindow.document.getElementById) {");
    //<< write !,"      if (refWindow.top.window.outerHeight<screen.availHeight||"
    m$.Cmd.Write("\n","      if (refWindow.top.window.outerHeight<screen.availHeight||");
    //<< write !,"      refWindow.top.window.outerWidth<screen.availWidth) {"
    m$.Cmd.Write("\n","      refWindow.top.window.outerWidth<screen.availWidth) {");
    //<< write !,"      refWindow.top.window.outerHeight = screen.availHeight;"
    m$.Cmd.Write("\n","      refWindow.top.window.outerHeight = screen.availHeight;");
    //<< write !,"      refWindow.top.window.outerWidth = screen.availWidth;"
    m$.Cmd.Write("\n","      refWindow.top.window.outerWidth = screen.availWidth;");
    //<< write !,"    }"
    m$.Cmd.Write("\n","    }");
    //<< write !,"  }"
    m$.Cmd.Write("\n","  }");
    //<< write !,"}",!
    m$.Cmd.Write("\n","}","\n");
    return null;
  //<< }
  }

  //<< 
  //<< ClassMethod isLoginRight() As %Boolean
  public Object isLoginRight() {
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Method Usage
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Dec-2006   JW      BR014262: Cleaned up.
    //<< ;-------------------------------------------------------------------------------
    //<< new blnOK
    mVar blnOK = m$.var("blnOK");
    m$.newVar(blnOK);
    //<< 
    //<< set blnOK = $$$YES
    blnOK.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< if (YBED="") || ('$data(^WWW013(0,YBED,1))) {
    if ((mOp.Equal(m$.var("YBED").get(),"")) || (mOp.Not(m$.Fnc.$data(m$.var("^WWW013",0,m$.var("YBED").get(),1))))) {
      //<< set blnOK = $$$NO
      blnOK.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif $$$UPPER($$^WWWPWDCHECK($$$WWW013Password1($get(^WWW013(0,YBED,1)))))'=$$$UPPER(YPWD) {
    else if (mOp.NotEqual(include.COMSYSString.$$$UPPER(m$,m$.fnc$("WWWPWDCHECK.main",include.WWWConst.$$$WWW013Password1(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))))),include.COMSYSString.$$$UPPER(m$,m$.var("YPWD")))) {
      //<< set blnOK = $$$NO
      blnOK.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< elseif ((+$$$WWWClientParamCoreChangesIPIRANGA($get(^WWWClientParam(YM, YM, 1)))) &&
    //<< (+$$^WWWBEDBER(YBED) '= 1)) {
    else if ((mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesIPIRANGA(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) && (mOp.NotEqual(mOp.Positive(m$.fnc$("WWWBEDBER.main",m$.var("YBED").get())),1)))) {
      //<< set blnOK = $$$NO
      blnOK.set(include.COMSYS.$$$NO(m$));
      //<< 
      //<< // Clear password value, as this block is different from the normal
      //<< set %request.Data("YPWD", 1) = ""
      m$.getRequest().setData("YPWD",1,"");
      //<< set %(YQUERY, "YPWD") = ""
      m$.var("%",m$.var("YQUERY").get(),"YPWD").set("");
      //<< if ($data(^WWWUSER(0, YUSER, 1))) {
      if (mOp.Logical((m$.Fnc.$data(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1))))) {
        //<< set $$$WWWUSERPassword1(^WWWUSER(0, YUSER, 1)) = ""
        include.WWWConst.$$$WWWUSERPassword1Set(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit blnOK
    return blnOK.get();
  //<< }
  }

//<< 
//<< }
}
