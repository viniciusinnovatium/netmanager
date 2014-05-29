//*****************************************************************************
//** TASC - ALPHALINC - CLASS User.COMLogin
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:26:02
//*****************************************************************************

package User;

import mLibrary.*;

//<< Class User.COMLogin Extends %CSP.Page [ ClassType = "", Not ProcedureBlock ]
public class COMLogin extends mPage {
  //<< {
  //<< 
  //<< Parameter LOGINSUBMIT As %String = "COMUserPreferences.cls";
  public static String p_LOGINSUBMIT = "COMUserPreferences.cls";
  //<< 
  //<< Parameter EXTRAWELCOMEMESSAGE As %String;
  public static String p_EXTRAWELCOMEMESSAGE;

  //<< 
  //<< ClassMethod OnPage() As %Status
  public Object OnPage() {
    //<< ;------------------------------------------------------------------------------
    //<< ; 05-Sep-2012   shobby      SR18106: Login image is now configurable.
    //<< ; 30-Aug-2012   shobby      SR18073: Browser title is now configurable.
    //<< ; 15-Jun-2011   shobby      SR17793: Add Hide Logo Spacer switch
    //<< ; 24-Nov-2010   shobby      SR17247: Allow changing the welcome message at a company
    //<< ;                               level.
    //<< ; 03-May-2010   shobby      SR17253 (1.7.1) Invalid syntax
    //<< ; 16-Oct-2009   shobby      SR16948: Can't use $job as a subscript to preserve
    //<< ;                               URL in CacheTempURL. Passed in to variable on
    //<< ;                               the form.
    //<< ; 02-Dec-2008   FIS         SR16205: Simple Login screen for PDA's
    //<< ; 09-Sep-2008   shobby      BR014979: Reverted on-site change to hardcode login
    //<< ;                               screen to Portuguese
    //<< ; 11-Sep-2007   shobby      BR014713: If invalid company passed as parameter
    //<< ;                               reset to company 0
    //<< ; 09-Aug-2007   shobby      BR014237: Store the calling URL so that it can be
    //<< ;                               used if pressing the X button to return to the
    //<< ;                               login screen.  Stores the URL and any parameters
    //<< ;                               that were passed in (such as YM or LANGUAGE)
    //<< ; 21-Jun-2007   FIS         SR15550: License Allocation Added
    //<< ; 02-Apr-2007   RPW         Refactored usage of $get(^WWW012)
    //<< ; 15-Feb-2006   shobby      BR014393: shobby... Merged changes from Gustavo F
    //<< ; 02-Nov-2006   shobby      BR014210: Store YM in a hidden field in passed as a
    //<< ;                               parameter from the URL.
    //<< ; 31-Oct-2006  GM           BR014210: Call ^WWWVAR as first step, before "set YM"
    //<< ; 18-Oct-2006   shobby      BR014234: Allow passing in of language from the URL
    //<< ;                               to enable language translation of the welcome.
    //<< ; 01-Feb-2006   PO          SR14047:  Keep track of "sessions"
    //<< ; 24-Oct-2005   shobby      SR12338:  Code changes for colours and logo pictures as required in Brazil.
    //<< ;------------------------------------------------------------------------------
    //<< new bkgColor,blnSessionLoginOK,ColorCodeForHeaderLeft,ImageDirectory,logoPicture
    mVar bkgColor = m$.var("bkgColor");
    mVar blnSessionLoginOK = m$.var("blnSessionLoginOK");
    mVar ColorCodeForHeaderLeft = m$.var("ColorCodeForHeaderLeft");
    mVar ImageDirectory = m$.var("ImageDirectory");
    mVar logoPicture = m$.var("logoPicture");
    m$.newVar(bkgColor,blnSessionLoginOK,ColorCodeForHeaderLeft,ImageDirectory,logoPicture);
    //<< new objWWW012,SPRACHE,strLanguage,strLoginError,strLoop,strURLParameters,YM
    mVar objWWW012 = m$.var("objWWW012");
    mVar SPRACHE = m$.var("SPRACHE");
    mVar strLanguage = m$.var("strLanguage");
    mVar strLoginError = m$.var("strLoginError");
    mVar strLoop = m$.var("strLoop");
    mVar strURLParameters = m$.var("strURLParameters");
    mVar YM = m$.var("YM");
    m$.newVar(objWWW012,SPRACHE,strLanguage,strLoginError,strLoop,strURLParameters,YM);
    //<< 
    //<< set blnSessionLoginOK = $$^WWWLicenseAllocation()
    blnSessionLoginOK.set(m$.fnc$("WWWLicenseAllocation.main"));
    //<< 
    //<< do ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< 
    //<< set blnIsMobile = $$$NO
    mVar blnIsMobile = m$.var("blnIsMobile");
    blnIsMobile.set(include.COMSYS.$$$NO(m$));
    //<< if ($get(%request) '= "") && $find($get(%request.CgiEnvs("HTTP_USER_AGENT")),"Windows CE") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),"")) && mOp.Logical(m$.Fnc.$find(m$.Fnc.$get(m$.getRequest().getCgiEnvs("HTTP_USER_AGENT")),"Windows CE"))) {
      //<< set blnIsMobile = $$$YES
      blnIsMobile.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< ;--------------------------------------
    //<< ; Company
    //<< ;  - If no company nominated or the company doesn't exist, then uses the default zero company.
    //<< ;  - Deprecated since now only zero
    //<< ;--------------------------------------
    //<< set YM = $get(%request.Data("YM",1))
    YM.set(m$.Fnc.$get(m$.getRequest().varData("YM",1)));
    //<< set:YM="" YM = 0
    if (mOp.Equal(YM.get(),"")) {
      YM.set(0);
    }
    //<< set objWWW012 = $get(^WWW012(0,YM,1))
    objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,YM.get(),1)));
    //<< if (objWWW012="") {
    if ((mOp.Equal(objWWW012.get(),""))) {
      //<< set YM = 0
      YM.set(0);
      //<< set objWWW012 = $get(^WWW012(0,YM,1))
      objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,YM.get(),1)));
    }
    //<< }
    //<< set SPRACHE = $get(%request.Data("LANGUAGE",1))
    SPRACHE.set(m$.Fnc.$get(m$.getRequest().varData("LANGUAGE",1)));
    //<< 
    //<< ;--------------------------------------
    //<< ; Parameters
    //<< ;--------------------------------------
    //<< set strURLParameters=""
    strURLParameters.set("");
    //<< set strLoop=""
    strLoop.set("");
    //<< for {
    for (;true;) {
      //<< set strLoop = $order(%request.Data(strLoop))
      strLoop.set(m$.Fnc.$order(m$.getRequest().varData(strLoop.get())));
      //<< quit:strLoop=""
      if (mOp.Equal(strLoop.get(),"")) {
        break;
      }
      //<< 
      //<< if strURLParameters'="" set strURLParameters = strURLParameters_"&"
      if (mOp.NotEqual(strURLParameters.get(),"")) {
        strURLParameters.set(mOp.Concat(strURLParameters.get(),"&"));
      }
      //<< set strURLParameters = strURLParameters_strLoop_"="_%request.Data(strLoop,1)
      strURLParameters.set(mOp.Concat(mOp.Concat(mOp.Concat(strURLParameters.get(),strLoop.get()),"="),m$.getRequest().getData(strLoop.get(),1)));
    }
    //<< }
    //<< if strURLParameters'="" set strURLParameters = %request.URL_"?"_strURLParameters
    if (mOp.NotEqual(strURLParameters.get(),"")) {
      strURLParameters.set(mOp.Concat(mOp.Concat(m$.getRequest().getURL(),"?"),strURLParameters.get()));
    }
    //<< 
    //<< ;--------------------------------------
    //<< ; Colours
    //<< ;--------------------------------------
    //<< set ColorCodeForHeaderLeft = $$$WWW012ColorCodeForHeaderLeft(objWWW012)
    ColorCodeForHeaderLeft.set(include.WWWConst.$$$WWW012ColorCodeForHeaderLeft(m$,objWWW012));
    //<< 
    //<< set bkgColor = ""
    bkgColor.set("");
    //<< set:ColorCodeForHeaderLeft'="" bkgColor = $piece($get(^WWW100(0,"FARBE","EN",ColorCodeForHeaderLeft,1)),"~",1)
    if (mOp.NotEqual(ColorCodeForHeaderLeft.get(),"")) {
      bkgColor.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",ColorCodeForHeaderLeft.get(),1)),"~",1));
    }
    //<< set:bkgColor="" bkgColor = "darkblue"
    if (mOp.Equal(bkgColor.get(),"")) {
      bkgColor.set("darkblue");
    }
    //<< 
    //<< ;--------------------------------------
    //<< 
    //<< set logoPicture = $$$WWW012LogoPicture(objWWW012)
    logoPicture.set(include.WWWConst.$$$WWW012LogoPicture(m$,objWWW012));
    //<< set:logoPicture="" logoPicture = "disclinc.gif"
    if (mOp.Equal(logoPicture.get(),"")) {
      logoPicture.set("disclinc.gif");
    }
    //<< 
    //<< set ImageDirectory = $translate($$$WWW012PictureDirectorySystem(objWWW012),"\","/") // New line for service
    ImageDirectory.set(m$.Fnc.$translate(include.WWWConst.$$$WWW012PictureDirectorySystem(m$,objWWW012),"\\","/"));
    //<< 
    //<< ; %session.Language
    //<< if SPRACHE="" set SPRACHE = $zconvert($piece(%request.GetCgiEnv("HTTP_ACCEPT_LANGUAGE","EN"),"-",1),"U")
    if (mOp.Equal(SPRACHE.get(),"")) {
      SPRACHE.set(m$.Fnc.$zconvert(m$.Fnc.$piece(m$.getRequest().getCgiEnv("HTTP_ACCEPT_LANGUAGE","EN"),"-",1),"U"));
    }
    //<< 
    //<< set strLoginError = $$$Text("Com00240",,SPRACHE)
    strLoginError.set(include.COMSYS.$$$Text(m$,"Com00240",null,SPRACHE));
    //<< 
    //<< write "<html>",!
    m$.Cmd.Write("<html>","\n");
    //<< write "<head>",!
    m$.Cmd.Write("<head>","\n");
    //<< write "<meta http-equiv=""Content-Type"">",!
    m$.Cmd.Write("<meta http-equiv=\"Content-Type\">","\n");
    //<< write "<meta http-equiv=""expires"" content=0>",!
    m$.Cmd.Write("<meta http-equiv=\"expires\" content=0>","\n");
    //<< write "<meta http-equiv=""Content-Type"" content=""text/html; charset=iso-8859_1"">"
    m$.Cmd.Write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859_1\">");
    //<< write "<STYLE >",!
    m$.Cmd.Write("<STYLE >","\n");
    //<< write "<!--",!
    m$.Cmd.Write("<!--","\n");
    //<< write " a:hover{color:blue}",!
    m$.Cmd.Write(" a:hover{color:blue}","\n");
    //<< write " A  {text-decoration:none}",!
    m$.Cmd.Write(" A  {text-decoration:none}","\n");
    //<< write " a   { color:darkblue}",!
    m$.Cmd.Write(" a   { color:darkblue}","\n");
    //<< write " a:active{color:darkblue}",!
    m$.Cmd.Write(" a:active{color:darkblue}","\n");
    //<< write "-->",!
    m$.Cmd.Write("-->","\n");
    //<< 
    //<< write ".estilom1 {",!
    m$.Cmd.Write(".estilom1 {","\n");
    //<< write " border: none;",!
    m$.Cmd.Write(" border: none;","\n");
    //<< write " height: 256px;",!
    m$.Cmd.Write(" height: 256px;","\n");
    //<< write " width: 399px;",!
    m$.Cmd.Write(" width: 399px;","\n");
    //<< write " background-image: url("_ImageDirectory_$$LoginImage^WWW012()_");",! ;SR18106
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" background-image: url(",ImageDirectory.get()),m$.fnc$("WWW012.LoginImage")),");"),"\n");
    //<< write " background-repeat: no-repeat;",!
    m$.Cmd.Write(" background-repeat: no-repeat;","\n");
    //<< write " }",!
    m$.Cmd.Write(" }","\n");
    //<< 
    //<< write ".estilom2 {",!
    m$.Cmd.Write(".estilom2 {","\n");
    //<< write " font-family: Arial;",!
    m$.Cmd.Write(" font-family: Arial;","\n");
    //<< write " font-size: 12px;",!
    m$.Cmd.Write(" font-size: 12px;","\n");
    //<< write " font-weight: bold;",!
    m$.Cmd.Write(" font-weight: bold;","\n");
    //<< write " line-height: 25px;",!
    m$.Cmd.Write(" line-height: 25px;","\n");
    //<< write " color: #333333;",!
    m$.Cmd.Write(" color: #333333;","\n");
    //<< write "}",!
    m$.Cmd.Write("}","\n");
    //<< 
    //<< write ".estilom3 {",!
    m$.Cmd.Write(".estilom3 {","\n");
    //<< write " font-family: Arial;",!
    m$.Cmd.Write(" font-family: Arial;","\n");
    //<< write " font-size: 12px;",!
    m$.Cmd.Write(" font-size: 12px;","\n");
    //<< write " height: 20px;",!
    m$.Cmd.Write(" height: 20px;","\n");
    //<< write " font-weight: bold;",!
    m$.Cmd.Write(" font-weight: bold;","\n");
    //<< write " color: #333333;",!
    m$.Cmd.Write(" color: #333333;","\n");
    //<< write " border: 1px solid #999999;",!
    m$.Cmd.Write(" border: 1px solid #999999;","\n");
    //<< write " padding-left: 3px;",!
    m$.Cmd.Write(" padding-left: 3px;","\n");
    //<< write " padding-right: 3px;",!
    m$.Cmd.Write(" padding-right: 3px;","\n");
    //<< write "}",!
    m$.Cmd.Write("}","\n");
    //<< write "",!
    m$.Cmd.Write("","\n");
    //<< 
    //<< write ".acesso {    font-family: Arial;",!
    m$.Cmd.Write(".acesso {    font-family: Arial;","\n");
    //<< write " font-size: 12px;",!
    m$.Cmd.Write(" font-size: 12px;","\n");
    //<< write " padding-top: 10px;",!
    m$.Cmd.Write(" padding-top: 10px;","\n");
    //<< write " padding-bottom: 10px;",!
    m$.Cmd.Write(" padding-bottom: 10px;","\n");
    //<< write " color: #333333;",!
    m$.Cmd.Write(" color: #333333;","\n");
    //<< write " text-decoration: none;",!
    m$.Cmd.Write(" text-decoration: none;","\n");
    //<< write "}",!
    m$.Cmd.Write("}","\n");
    //<< 
    //<< write ".userandpass {   font-family: Arial;",!
    m$.Cmd.Write(".userandpass {   font-family: Arial;","\n");
    //<< write " font-size: 12px;",!
    m$.Cmd.Write(" font-size: 12px;","\n");
    //<< write " color: #3F4F82;",!
    m$.Cmd.Write(" color: #3F4F82;","\n");
    //<< write " font-weight: bold;",!
    m$.Cmd.Write(" font-weight: bold;","\n");
    //<< write "}",!
    m$.Cmd.Write("}","\n");
    //<< write "</STYLE>",!
    m$.Cmd.Write("</STYLE>","\n");
    //<< 
    //<< if $$$WWW012BrowserTitle(objWWW012)'="" {                           ;SR18073
    if (mOp.NotEqual(include.WWWConst.$$$WWW012BrowserTitle(m$,objWWW012),"")) {
      //<< write "<title>"_$$$WWW012BrowserTitle(objWWW012)_"</title>",!   ;SR18073
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<title>",include.WWWConst.$$$WWW012BrowserTitle(m$,objWWW012)),"</title>"),"\n");
    }
    //<< } else {                                                            ;SR18073
    else {
      //<< write "<title>DISCLINC</title>",!                               ;SR18073
      m$.Cmd.Write("<title>DISCLINC</title>","\n");
    }
    //<< }                                                                   ;SR18073
    //<< write "<script type='text/javascript'> <!--",!
    m$.Cmd.Write("<script type='text/javascript'> <!--","\n");
    //<< write "function getCookie(pstrName) {",!
    m$.Cmd.Write("function getCookie(pstrName) {","\n");
    //<< write "   var objCookie = document.cookie,",!
    m$.Cmd.Write("   var objCookie = document.cookie,","\n");
    //<< write "       prefix = pstrName + '=',",!
    m$.Cmd.Write("       prefix = pstrName + '=',","\n");
    //<< write "       begin = objCookie.indexOf('; ' + prefix);",!
    m$.Cmd.Write("       begin = objCookie.indexOf('; ' + prefix);","\n");
    //<< write "   if (begin == -1) {",!
    m$.Cmd.Write("   if (begin == -1) {","\n");
    //<< write "       begin = objCookie.indexOf(prefix);",!
    m$.Cmd.Write("       begin = objCookie.indexOf(prefix);","\n");
    //<< write "       if (begin != 0) return null;",!
    m$.Cmd.Write("       if (begin != 0) return null;","\n");
    //<< write "   } else {",!
    m$.Cmd.Write("   } else {","\n");
    //<< write "       begin += 2;",!
    m$.Cmd.Write("       begin += 2;","\n");
    //<< write "   }",!
    m$.Cmd.Write("   }","\n");
    //<< write "   var end = document.cookie.indexOf(';', begin);",!
    m$.Cmd.Write("   var end = document.cookie.indexOf(';', begin);","\n");
    //<< write "   if (end == -1) {",!
    m$.Cmd.Write("   if (end == -1) {","\n");
    //<< write "       end = objCookie.length;",!
    m$.Cmd.Write("       end = objCookie.length;","\n");
    //<< write "   }",!
    m$.Cmd.Write("   }","\n");
    //<< write "   return unescape(objCookie.substring(begin + prefix.length, end));",!
    m$.Cmd.Write("   return unescape(objCookie.substring(begin + prefix.length, end));","\n");
    //<< write "}",!
    m$.Cmd.Write("}","\n");
    //<< 
    //<< write "function incrementWindowCount(pstrName) {",!
    m$.Cmd.Write("function incrementWindowCount(pstrName) {","\n");
    //<< write "   var strCookieValue = getCookie(pstrName);",!
    m$.Cmd.Write("   var strCookieValue = getCookie(pstrName);","\n");
    //<< write "   if (strCookieValue == null) strCookieValue = '0:' + document.location.href;",!
    m$.Cmd.Write("   if (strCookieValue == null) strCookieValue = '0:' + document.location.href;","\n");
    //<< write "   document.cookie = pstrName + ' = ' + (parseInt(strCookieValue) + 1) + strCookieValue.substring(strCookieValue.indexOf(':'),strCookieValue.length);",!
    m$.Cmd.Write("   document.cookie = pstrName + ' = ' + (parseInt(strCookieValue) + 1) + strCookieValue.substring(strCookieValue.indexOf(':'),strCookieValue.length);","\n");
    //<< write "}",!
    m$.Cmd.Write("}","\n");
    //<< 
    //<< write "function decrementWindowCount(pstrName) {",!
    m$.Cmd.Write("function decrementWindowCount(pstrName) {","\n");
    //<< write "   var strCookieValue = getCookie(pstrName),",!
    m$.Cmd.Write("   var strCookieValue = getCookie(pstrName),","\n");
    //<< write "       intCount;",!
    m$.Cmd.Write("       intCount;","\n");
    //<< write "   if (strCookieValue != null) {",!
    m$.Cmd.Write("   if (strCookieValue != null) {","\n");
    //<< write "      intCount = parseInt(strCookieValue) - 1;",!
    m$.Cmd.Write("      intCount = parseInt(strCookieValue) - 1;","\n");
    //<< write "      strCookieValue = intCount + strCookieValue.substring(strCookieValue.indexOf(':'),strCookieValue.length);",!
    m$.Cmd.Write("      strCookieValue = intCount + strCookieValue.substring(strCookieValue.indexOf(':'),strCookieValue.length);","\n");
    //<< write "      document.cookie = pstrName + ' = ' + strCookieValue;",!
    m$.Cmd.Write("      document.cookie = pstrName + ' = ' + strCookieValue;","\n");
    //<< write "   } else {",!
    m$.Cmd.Write("   } else {","\n");
    //<< write "      strCookieValue = 0;",!
    m$.Cmd.Write("      strCookieValue = 0;","\n");
    //<< write "   }",!
    m$.Cmd.Write("   }","\n");
    //<< write "   return parseInt(strCookieValue);",!
    m$.Cmd.Write("   return parseInt(strCookieValue);","\n");
    //<< write "}",!
    m$.Cmd.Write("}","\n");
    //<< 
    //<< write "function preventLogin(pstrName) {",!
    m$.Cmd.Write("function preventLogin(pstrName) {","\n");
    //<< write "   var strCookieValue = getCookie(pstrName);",!
    m$.Cmd.Write("   var strCookieValue = getCookie(pstrName);","\n");
    //<< write "   if (strCookieValue == null) strCookieValue = ':' + document.location.href;",!
    m$.Cmd.Write("   if (strCookieValue == null) strCookieValue = ':' + document.location.href;","\n");
    //<< write "   if (document.location.href == strCookieValue.substring(strCookieValue.indexOf(':')+1,strCookieValue.length)) {",!
    m$.Cmd.Write("   if (document.location.href == strCookieValue.substring(strCookieValue.indexOf(':')+1,strCookieValue.length)) {","\n");
    //<< write "      incrementWindowCount(pstrName);",!
    m$.Cmd.Write("      incrementWindowCount(pstrName);","\n");
    //<< write "   } else {",!
    m$.Cmd.Write("   } else {","\n");
    //<< write "      document.www.action = 'javascript:alert(\'"_strLoginError_"\');';",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("      document.www.action = 'javascript:alert(\\'",strLoginError.get()),"\\');';"),"\n");
    //<< write "   }",!
    m$.Cmd.Write("   }","\n");
    //<< write "}",!
    m$.Cmd.Write("}","\n");
    //<< 
    //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",YM.get(),YM.get(),1))))))) {
      //<< write "function checkBrowser() {", !
      m$.Cmd.Write("function checkBrowser() {","\n");
      //<< write "  var agent = navigator.userAgent.toLowerCase();", !
      m$.Cmd.Write("  var agent = navigator.userAgent.toLowerCase();","\n");
      //<< write "  var isFirefox3_6 = (agent.indexOf('firefox/3.6.') != -1);", !
      m$.Cmd.Write("  var isFirefox3_6 = (agent.indexOf('firefox/3.6.') != -1);","\n");
      //<< write "  var isIE8 = (agent.indexOf('msie 8.') != -1);", !
      m$.Cmd.Write("  var isIE8 = (agent.indexOf('msie 8.') != -1);","\n");
      //<< write "", !
      m$.Cmd.Write("","\n");
      //<< write "  if ((!isFirefox3_6) && (!isIE8)) {", !
      m$.Cmd.Write("  if ((!isFirefox3_6) && (!isIE8)) {","\n");
      //<< write "    document.write('<tr>\n');", !
      m$.Cmd.Write("    document.write('<tr>\\n');","\n");
      //<< write "    document.write('  <td colspan=""3"" align=""center"">\n');", !
      m$.Cmd.Write("    document.write('  <td colspan=\"3\" align=\"center\">\\n');","\n");
      //<< write "    document.write('    <p>&nbsp;</p>\n');", !
      m$.Cmd.Write("    document.write('    <p>&nbsp;</p>\\n');","\n");
      //<< write "    document.write('    <img src="""_ImageDirectory_"/aviso_versao.png"">\n');", !
      m$.Cmd.Write(mOp.Concat(mOp.Concat("    document.write('    <img src=\"",ImageDirectory.get()),"/aviso_versao.png\">\\n');"),"\n");
      //<< write "    document.write('  </td>\n');", !
      m$.Cmd.Write("    document.write('  </td>\\n');","\n");
      //<< write "    document.write('</tr>\n');", !
      m$.Cmd.Write("    document.write('</tr>\\n');","\n");
      //<< write "  }", !
      m$.Cmd.Write("  }","\n");
      //<< write "}", !
      m$.Cmd.Write("}","\n");
    }
    //<< }
    //<< 
    //<< write "// -->",!
    m$.Cmd.Write("// -->","\n");
    //<< write "</script>",!
    m$.Cmd.Write("</script>","\n");
    //<< write "</head>",!
    m$.Cmd.Write("</head>","\n");
    //<< 
    //<< write "<body onLoad='document.www.YBED.focus();'",!
    m$.Cmd.Write("<body onLoad='document.www.YBED.focus();'","\n");
    //<< write " BGCOLOR=#C0C0C0 vlink=black link=black topmargin=1 leftmargin=1>",!
    m$.Cmd.Write(" BGCOLOR=#C0C0C0 vlink=black link=black topmargin=1 leftmargin=1>","\n");
    //<< 
    //<< if (blnIsMobile = $$$YES) {
    if ((mOp.Equal(blnIsMobile.get(),include.COMSYS.$$$YES(m$)))) {
      //<< write "  <table border=1 bgcolor=white bordercolordark=gainsboro bordercolorlight=black cellspacing=0 cellpadding=4 width=100% height=100%>",!
      m$.Cmd.Write("  <table border=1 bgcolor=white bordercolordark=gainsboro bordercolorlight=black cellspacing=0 cellpadding=4 width=100% height=100%>","\n");
      //<< write "    <tr>",!
      m$.Cmd.Write("    <tr>","\n");
      //<< write "    <td>",!
      m$.Cmd.Write("    <td>","\n");
      //<< write "     <form name=""www"" action=""COMUserPreferences.cls"" METHOD=""POST"" >",!
      m$.Cmd.Write("     <form name=\"www\" action=\"COMUserPreferences.cls\" METHOD=\"POST\" >","\n");
      //<< write "       <input type=hidden name=YUCI value="""_$znspace_""">",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("       <input type=hidden name=YUCI value=\"",m$.Fnc.$znspace()),"\">"),"\n");
      //<< write "       <input type=hidden name=YXURL value="""_strURLParameters_""">",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("       <input type=hidden name=YXURL value=\"",strURLParameters.get()),"\">"),"\n");
      //<< 
      //<< ; SRBR014210 - Only set this if the parameter is passed in from the icon.
      //<< ;              Not 100% confident that this will have no impact on existing
      //<< ;              functionality when no value is passed in from the URL.
      //<< if $get(%request.Data("YM",1))'=""  write " <input type=hidden name=YM value="_""""_YM_""""_">",!
      if (mOp.NotEqual(m$.Fnc.$get(m$.getRequest().varData("YM",1)),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" <input type=hidden name=YM value=","\""),YM.get()),"\""),">"),"\n");
      }
      //<< 
      //<< write "       <input type=hidden name=EP value=""WWWMENU"">",!
      m$.Cmd.Write("       <input type=hidden name=EP value=\"WWWMENU\">","\n");
      //<< write "       <input type=hidden name=YRANDOM value=0>",!
      m$.Cmd.Write("       <input type=hidden name=YRANDOM value=0>","\n");
      //<< write "       <img src="_ImageDirectory_"/"_logoPicture_" border=0><br><br>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("       <img src=",ImageDirectory.get()),"/"),logoPicture.get())," border=0><br><br>"));
      //<< write "          <span class=""userandpass"">"_$$$Text(414,,SPRACHE)_"</span>",!               ;Username
      m$.Cmd.Write(mOp.Concat(mOp.Concat("          <span class=\"userandpass\">",include.COMSYS.$$$Text(m$,414,null,SPRACHE)),"</span>"),"\n");
      //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
      if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",YM.get(),YM.get(),1))))))) {
        //<< write "          <input name="_""""_"YBED"_""""_" type=text class=""estilom3"" size=18 maxlength=30><br>",!
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("          <input name=","\""),"YBED"),"\"")," type=text class=\"estilom3\" size=18 maxlength=30><br>"),"\n");
      }
      //<< }
      //<< else {
      else {
        //<< write "          <input name="_""""_"YBED"_""""_" type=text class=""estilom3"" size=18 maxlength=20><br>",!
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("          <input name=","\""),"YBED"),"\"")," type=text class=\"estilom3\" size=18 maxlength=20><br>"),"\n");
      }
      //<< }
      //<< write "          <span class=""userandpass"">"_$$$Text("3",,SPRACHE)_"</span>",!                ; "Password"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("          <span class=\"userandpass\">",include.COMSYS.$$$Text(m$,"3",null,SPRACHE)),"</span>"),"\n");
      //<< write "          <input name=YPWD type=password class=""estilom3"" size=18 maxlength=""20"" maxlenth=20><br>",!
      m$.Cmd.Write("          <input name=YPWD type=password class=\"estilom3\" size=18 maxlength=\"20\" maxlenth=20><br>","\n");
      //<< write "          <input type=""submit"" name=""Submit"" value=""&nbsp;"_$$$Text("67",,SPRACHE)_"&nbsp;"">&nbsp;&nbsp;&nbsp;",!                ; "Start"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("          <input type=\"submit\" name=\"Submit\" value=\"&nbsp;",include.COMSYS.$$$Text(m$,"67",null,SPRACHE)),"&nbsp;\">&nbsp;&nbsp;&nbsp;"),"\n");
      //<< write "          <input type=""reset"" name=""New"" onClick='document.www.YBED.focus();' value=""&nbsp;"_$$$Text("58",,SPRACHE)_"&nbsp;"">",! ; "New"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("          <input type=\"reset\" name=\"New\" onClick='document.www.YBED.focus();' value=\"&nbsp;",include.COMSYS.$$$Text(m$,"58",null,SPRACHE)),"&nbsp;\">"),"\n");
      //<< write "      </td>",!
      m$.Cmd.Write("      </td>","\n");
      //<< write "    </tr>",!
      m$.Cmd.Write("    </tr>","\n");
      //<< write "  </table>",!
      m$.Cmd.Write("  </table>","\n");
    }
    //<< 
    //<< } else {
    else {
      //<< ; TABLE 1
      //<< ;---------------------------------------
      //<< write "  <table border=1 bordercolordark=gainsboro bordercolorlight=black cellspacing=0 width=100% height=100%>",!
      m$.Cmd.Write("  <table border=1 bordercolordark=gainsboro bordercolorlight=black cellspacing=0 width=100% height=100%>","\n");
      //<< write "    <tr>",!
      m$.Cmd.Write("    <tr>","\n");
      //<< write "   <td width=214 height=446 align=middle valign=top bgcolor=#FFFFFF>",!
      m$.Cmd.Write("   <td width=214 height=446 align=middle valign=top bgcolor=#FFFFFF>","\n");
      //<< if '$$$WWW012HideLogoSpacer(objWWW012) write "         <br>",!                      ; SR17793
      if (mOp.Not(include.WWWConst.$$$WWW012HideLogoSpacer(m$,objWWW012))) {
        m$.Cmd.Write("         <br>","\n");
      }
      //<< write "         <img src="_ImageDirectory_"/"_logoPicture_" border=0>",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("         <img src=",ImageDirectory.get()),"/"),logoPicture.get())," border=0>"),"\n");
      //<< write "      </td>",!
      m$.Cmd.Write("      </td>","\n");
      //<< write "   <td align=middle bgcolor="""_bkgColor_"""><br><br>",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("   <td align=middle bgcolor=\"",bkgColor.get()),"\"><br><br>"),"\n");
      //<< write "     <form name=""www"" action="""_..#LOGINSUBMIT_""" METHOD=""POST"" >",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("     <form name=\"www\" action=\"",m$.param(this,"p_LOGINSUBMIT").get()),"\" METHOD=\"POST\" >"),"\n");
      //<< write "       <input type=hidden name=YUCI value="""_$znspace_""">",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("       <input type=hidden name=YUCI value=\"",m$.Fnc.$znspace()),"\">"),"\n");
      //<< write "       <input type=hidden name=YXURL value="""_strURLParameters_""">",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("       <input type=hidden name=YXURL value=\"",strURLParameters.get()),"\">"),"\n");
      //<< 
      //<< ; SRBR014210 - Only set this if the parameter is passed in from the icon.
      //<< ;              Not 100% confident that this will have no impact on existing
      //<< ;              functionality when no value is passed in from the URL.
      //<< if $get(%request.Data("YM",1))'=""  write " <input type=hidden name=YM value="_""""_YM_""""_">",!
      if (mOp.NotEqual(m$.Fnc.$get(m$.getRequest().varData("YM",1)),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" <input type=hidden name=YM value=","\""),YM.get()),"\""),">"),"\n");
      }
      //<< write "       <input type=hidden name=EP value=""WWWMENU"">",!
      m$.Cmd.Write("       <input type=hidden name=EP value=\"WWWMENU\">","\n");
      //<< write "       <input type=hidden name=YRANDOM value=0>",!
      m$.Cmd.Write("       <input type=hidden name=YRANDOM value=0>","\n");
      //<< 
      //<< ; TABLE 2
      //<< ;---------------------------------------
      //<< write "       <table border=0>",!
      m$.Cmd.Write("       <table border=0>","\n");
      //<< write "         <tr>",!
      m$.Cmd.Write("         <tr>","\n");
      //<< write "           <td width=46 height=256>&nbsp;</td>",!
      m$.Cmd.Write("           <td width=46 height=256>&nbsp;</td>","\n");
      //<< write "           <td width=399 valign=top>",!                     ; [START TD ?]
      m$.Cmd.Write("           <td width=399 valign=top>","\n");
      //<< 
      //<< ; TABLE 3
      //<< ;---------------------------------------
      //<< write "             <table width=""100%"" border=""0"" cellpadding=""0"" cellspacing=""0"" class=""estilom1"">",!
      m$.Cmd.Write("             <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"estilom1\">","\n");
      //<< write "             <tr>",!
      m$.Cmd.Write("             <tr>","\n");
      //<< write "               <td width=""9"" height=""90"">&nbsp;</td>",!
      m$.Cmd.Write("               <td width=\"9\" height=\"90\">&nbsp;</td>","\n");
      //<< write "               <td width=""84"">&nbsp;</td>",!
      m$.Cmd.Write("               <td width=\"84\">&nbsp;</td>","\n");
      //<< write "               <td width=""273"">&nbsp;</td>",!
      m$.Cmd.Write("               <td width=\"273\">&nbsp;</td>","\n");
      //<< write "               <td width=""42"">&nbsp;</td>",!
      m$.Cmd.Write("               <td width=\"42\">&nbsp;</td>","\n");
      //<< write "               <td width=""8"">&nbsp;</td>",!
      m$.Cmd.Write("               <td width=\"8\">&nbsp;</td>","\n");
      //<< write "             </tr>",!
      m$.Cmd.Write("             </tr>","\n");
      //<< write "             <tr>",!
      m$.Cmd.Write("             <tr>","\n");
      //<< write "               <td height=""25"">&nbsp;</td>",!
      m$.Cmd.Write("               <td height=\"25\">&nbsp;</td>","\n");
      //<< //SR17247 write "                 <td colspan=""3"" valign=""top"" class=""estilom2""><div align=""center"">"_$$$Text("413",,SPRACHE)_" "_$$$WWW012CompanyName(objWWW012)_"</div></td>",!  ;Welcome To ;BR014979
      //<< write "               <td colspan=""3"" valign=""top"" class=""estilom2""><div align=""center"">"_$$WelcomeMessage^WWW012(SPRACHE)_..#EXTRAWELCOMEMESSAGE_"</div></td>",!  ;Welcome To ;BR014979
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("               <td colspan=\"3\" valign=\"top\" class=\"estilom2\"><div align=\"center\">",m$.fnc$("WWW012.WelcomeMessage",SPRACHE.get())),m$.param(this,"p_EXTRAWELCOMEMESSAGE").get()),"</div></td>"),"\n");
      //<< write "               <td>&nbsp;</td>",!
      m$.Cmd.Write("               <td>&nbsp;</td>","\n");
      //<< write "             </tr>",!
      m$.Cmd.Write("             </tr>","\n");
      //<< write "             <tr>",!
      m$.Cmd.Write("             <tr>","\n");
      //<< write "               <td height=""19"">&nbsp;</td>",!
      m$.Cmd.Write("               <td height=\"19\">&nbsp;</td>","\n");
      //<< write "               <td colspan=""3""></td>",!
      m$.Cmd.Write("               <td colspan=\"3\"></td>","\n");
      //<< write "               <td>&nbsp;</td>",!
      m$.Cmd.Write("               <td>&nbsp;</td>","\n");
      //<< write "             </tr>",!
      m$.Cmd.Write("             </tr>","\n");
      //<< ; FIXME : Missing <TR>?
      //<< write "             <td height=""100"">&nbsp;</td>",!
      m$.Cmd.Write("             <td height=\"100\">&nbsp;</td>","\n");
      //<< write "             <td>&nbsp;</td>",!
      m$.Cmd.Write("             <td>&nbsp;</td>","\n");
      //<< write "             <td valign=""top"">",!
      m$.Cmd.Write("             <td valign=\"top\">","\n");
      //<< 
      //<< ; TABLE 4
      //<< ;---------------------------------------
      //<< write "                  <table width=""100%"" border=""0"" cellpadding=""0"" cellspacing=""0"">",!
      m$.Cmd.Write("                  <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">","\n");
      //<< write "                 <tr>",!
      m$.Cmd.Write("                 <tr>","\n");
      //<< write "                   <td width=""270"" height=""86"" valign=""top"">",!
      m$.Cmd.Write("                   <td width=\"270\" height=\"86\" valign=\"top\">","\n");
      //<< 
      //<< ; TABLE 5
      //<< ;---------------------------------------
      //<< write "                        <table width=""273"" height=""100"" border=""0"">",!
      m$.Cmd.Write("                        <table width=\"273\" height=\"100\" border=\"0\">","\n");
      //<< write "                          <tr>",!
      m$.Cmd.Write("                          <tr>","\n");
      //<< write "                            <td width=""61"" height=""22""><div align=""right""><span class=""userandpass"">"_$$$Text(414,,SPRACHE)_"</span></div></td>",!               ;Username
      m$.Cmd.Write(mOp.Concat(mOp.Concat("                            <td width=\"61\" height=\"22\"><div align=\"right\"><span class=\"userandpass\">",include.COMSYS.$$$Text(m$,414,null,SPRACHE)),"</span></div></td>"),"\n");
      //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
      if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",YM.get(),YM.get(),1))))))) {
        //<< write "                            <td width=""202""><font face=Arial><b>&nbsp; <input name="_""""_"YBED"_""""_" type=text class=""estilom3"" size=18 maxlength=30></b></font></td>",!
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                            <td width=\"202\"><font face=Arial><b>&nbsp; <input name=","\""),"YBED"),"\"")," type=text class=\"estilom3\" size=18 maxlength=30></b></font></td>"),"\n");
      }
      //<< }
      //<< else {
      else {
        //<< write "                            <td width=""202""><font face=Arial><b>&nbsp; <input name="_""""_"YBED"_""""_" type=text class=""estilom3"" size=18 maxlength=20></b></font></td>",!
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                            <td width=\"202\"><font face=Arial><b>&nbsp; <input name=","\""),"YBED"),"\"")," type=text class=\"estilom3\" size=18 maxlength=20></b></font></td>"),"\n");
      }
      //<< }
      //<< write "                          </tr>",!
      m$.Cmd.Write("                          </tr>","\n");
      //<< write "                          <tr>",!
      m$.Cmd.Write("                          <tr>","\n");
      //<< write "                            <td height=""22""><div align=""right""><span class=""userandpass"">"_$$$Text("3",,SPRACHE)_"</span></div></td>",!                            ;Password
      m$.Cmd.Write(mOp.Concat(mOp.Concat("                            <td height=\"22\"><div align=\"right\"><span class=\"userandpass\">",include.COMSYS.$$$Text(m$,"3",null,SPRACHE)),"</span></div></td>"),"\n");
      //<< write "                            <td><font face=Arial><b>&nbsp; <input name=YPWD type=password class=""estilom3"" size=18 maxlength=""20"" maxlenth=20></b></font></td>",!
      m$.Cmd.Write("                            <td><font face=Arial><b>&nbsp; <input name=YPWD type=password class=\"estilom3\" size=18 maxlength=\"20\" maxlenth=20></b></font></td>","\n");
      //<< write "                          </tr>",!
      m$.Cmd.Write("                          </tr>","\n");
      //<< write "                          <tr>",!
      m$.Cmd.Write("                          <tr>","\n");
      //<< write "                            <td height=""48"" colspan=""2"">",!
      m$.Cmd.Write("                            <td height=\"48\" colspan=\"2\">","\n");
      //<< write "                              <div align=""center"">",!
      m$.Cmd.Write("                              <div align=\"center\">","\n");
      //<< write "                                <input type=""submit"" name=""Submit"" value=""&nbsp;"_$$$Text("67",,SPRACHE)_"&nbsp;"">",!  ;Start
      m$.Cmd.Write(mOp.Concat(mOp.Concat("                                <input type=\"submit\" name=\"Submit\" value=\"&nbsp;",include.COMSYS.$$$Text(m$,"67",null,SPRACHE)),"&nbsp;\">"),"\n");
      //<< write "                                <input type=""reset"" name=""New"" value=""&nbsp;"_$$$Text("58",,SPRACHE)_"&nbsp;"">",!      ;New
      m$.Cmd.Write(mOp.Concat(mOp.Concat("                                <input type=\"reset\" name=\"New\" value=\"&nbsp;",include.COMSYS.$$$Text(m$,"58",null,SPRACHE)),"&nbsp;\">"),"\n");
      //<< write "                              </div>",!
      m$.Cmd.Write("                              </div>","\n");
      //<< write "                            </td>",!
      m$.Cmd.Write("                            </td>","\n");
      //<< write "                          </tr>",!
      m$.Cmd.Write("                          </tr>","\n");
      //<< write "                         </table>",!
      m$.Cmd.Write("                         </table>","\n");
      //<< ;--------------------------------------- (5)
      //<< 
      //<< write "                   </td>",!
      m$.Cmd.Write("                   </td>","\n");
      //<< write "                    </tr>",!
      m$.Cmd.Write("                    </tr>","\n");
      //<< write "                 <tr>",!
      m$.Cmd.Write("                 <tr>","\n");
      //<< write "                   <td>&nbsp;</td>",!
      m$.Cmd.Write("                   <td>&nbsp;</td>","\n");
      //<< write "                   <td>&nbsp;</td>",!
      m$.Cmd.Write("                   <td>&nbsp;</td>","\n");
      //<< write "                 </tr>",!
      m$.Cmd.Write("                 </tr>","\n");
      //<< write "                  </table>",!
      m$.Cmd.Write("                  </table>","\n");
      //<< ;--------------------------------------- (4)
      //<< 
      //<< write "                </td>",!
      m$.Cmd.Write("                </td>","\n");
      //<< ; FIXME : missing /TR /TABLE
      //<< write "              </td>",!                               ; [END TD?]
      m$.Cmd.Write("              </td>","\n");
      //<< write "              <td width=43>&nbsp;</td>",!
      m$.Cmd.Write("              <td width=43>&nbsp;</td>","\n");
      //<< write "            </tr>",!
      m$.Cmd.Write("            </tr>","\n");
      //<< write "            <tr>",!
      m$.Cmd.Write("            <tr>","\n");
      //<< write "              <td height=""2""></td>",!
      m$.Cmd.Write("              <td height=\"2\"></td>","\n");
      //<< write "              <td></td>",!
      m$.Cmd.Write("              <td></td>","\n");
      //<< write "              <td></td>",!
      m$.Cmd.Write("              <td></td>","\n");
      //<< write "            </tr>",!
      m$.Cmd.Write("            </tr>","\n");
      //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
      if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",YM.get(),YM.get(),1))))))) {
        //<< write "                    <script language='javascript'>", !
        m$.Cmd.Write("                    <script language='javascript'>","\n");
        //<< write "                    checkBrowser();", !
        m$.Cmd.Write("                    checkBrowser();","\n");
        //<< write "                    </script>", !
        m$.Cmd.Write("                    </script>","\n");
      }
      //<< }
      //<< write "          </TABLE>",!
      m$.Cmd.Write("          </TABLE>","\n");
      //<< ;--------------------------------------- (2)
      //<< 
      //<< write "     </form>",!
      m$.Cmd.Write("     </form>","\n");
      //<< write "      </td>",!
      m$.Cmd.Write("      </td>","\n");
      //<< write "    </tr>",!
      m$.Cmd.Write("    </tr>","\n");
      //<< write "  </table>",!
      m$.Cmd.Write("  </table>","\n");
    }
    //<< ;--------------------------------------- (1)
    //<< }
    //<< 
    //<< ;write "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sistema de Materiais em Manutenção. O sistema voltará a funcionar normalmente no dia 01/02/2008 (Sexta-feira), à partir das 10:30!",!
    //<< write "</body>",!
    m$.Cmd.Write("</body>","\n");
    //<< write "</html>",!
    m$.Cmd.Write("</html>","\n");
    //<< 
    //<< quit $$$OK    ; </table
    return include.COMSYS.$$$OK(m$);
  //<< }
  }

//<< 
//<< }
}
