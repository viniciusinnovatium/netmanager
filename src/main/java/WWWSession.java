//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSession
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:54
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
//<< #include COMGridEdit31
import include.COMGridEdit31;

//<< WWWSession
public class WWWSession extends mClass {

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogRx(%1)       ;
  public static Object $$$LogRx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogRm(%1)       ;
  public static Object $$$LogRm(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _WWWSession();
  }

  public void _WWWSession() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWSession("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< StartFrameSet(pintFormFrame,pstrExtra="",pstrOnload="")
  public Object StartFrameSet(Object ... _p) {
    mVar pintFormFrame = m$.newVarRef("pintFormFrame",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrExtra = m$.newVarRef("pstrExtra",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrOnload = m$.newVarRef("pstrOnload",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Write out the frame set
    //<< ;
    //<< ; Called By : [$$$StartFrameSet(%args)]     User.www::OnPage, Framed^WWWMENU, Separate^WWWMENU
    //<< ;
    //<< ; Params:   pintFormFrame   - frame that the @net forms will be displayed in
    //<< ;           pstrExtra       - extra attributes for the frameset
    //<< ;           pstrOnload      - js to execute on load
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Jul-2010   shobby  SR17457:  strHTML no functional changed used for testing.
    //<< ; 31-May-2010   FIS     SR17343:  No document.frames in firefox
    //<< ; 23-Mar-2009   shobby  SR16427:  When unloading call out to the WWWEND routine to clean up using a
    //<< ;                                 Direct call rather than going through a temporary form.
    //<< ; 18-Dec-2006   JW      BR014262: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHeader,strHTML
    mVar strHeader = m$.var("strHeader");
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHeader,strHTML);
    //<< 
    //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(0,0,1)))) {
    if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",0,0,1))))))) {
      //<< if (($$$WWWUSERUser1($get(^WWWUSER(0,YUSER,1))) = "UNKNOWN")
      //<< ||($$$WWWUSERUser1($get(^WWWUSER(0,YUSER,1))) = "")) {
      if (mOp.Logical(((mOp.Equal(include.WWWConst.$$$WWWUSERUser1(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1))),"UNKNOWN")) || (mOp.Equal(include.WWWConst.$$$WWWUSERUser1(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1))),""))))) {
        //<< set SPRACHE = "PT"
        mVar SPRACHE = m$.var("SPRACHE");
        SPRACHE.set("PT");
        //<< $$$Alert($$^WWWTEXT(34359))  ; "Session expired!"
        include.COMSYS.$$$Alert(m$,m$.fnc$("WWWTEXT.main",34359));
        //<< $$$StartScript()
        include.COMSYS.$$$StartScript(m$);
        //<< write "window.parent.location = '"_$$getLoginPage^WWWLogin(1)_"';"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("window.parent.location = '",m$.fnc$("WWWLogin.getLoginPage",1)),"';"));
        //<< $$$EndScript()
        include.COMSYS.$$$EndScript(m$);
      }
    }
    //<< }
    //<< }
    //<< 
    //<< $$$LogR("StartFrameSet",$get(YTARGET)_":"_pstrOnload)
    $$$LogR(m$,"StartFrameSet",mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YTARGET")),":"),pstrOnload.get()));
    //<< 
    //<< set $$$WWWUSERFrameFormed(^WWWUSER(0,YUSER,1)) = $select($get(YTARGET)'="":YTARGET,1:"FRAME2")              // Direct set
    include.WWWConst.$$$WWWUSERFrameFormedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.Fnc.$select(mOp.NotEqual(m$.Fnc.$get(m$.var("YTARGET")),""),m$.var("YTARGET").get(),1,"FRAME2"));
    //<< 
    //<< set strHeader = $piece($$$WWW012CompanyName($GET(^WWW012(0,YM,1))),",",1)
    strHeader.set(m$.Fnc.$piece(include.WWWConst.$$$WWW012CompanyName(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))),",",1));
    //<< 
    //<< do Title^WWWSTART(strHeader)
    m$.Cmd.Do("WWWSTART.Title",strHeader.get());
    //<< 
    //<< ; Note: PLACING THE JS HERE WILL RESULT IN A MALFORMED DOCUMENT, BUT PAGE STILL FUNCTIONS AND DESIRED EFFECT IS ACQUIRED
    //<< ; - Can't see any problem with putting code in ^WWWSTART, child frames will simply not call the code.
    //<< do WriteJS()
    m$.Cmd.Do("WriteJS");
    //<< 
    //<< set strHTML="<frameset framespacing=4 "_pstrExtra
    strHTML.set(mOp.Concat("<frameset framespacing=4 ",pstrExtra.get()));
    //<< if pstrOnload'="" {
    if (mOp.NotEqual(pstrOnload.get(),"")) {
      //<< set strHTML=strHTML_" onload="
      strHTML.set(mOp.Concat(strHTML.get()," onload="));
      //<< set strHTML=strHTML_"'"
      strHTML.set(mOp.Concat(strHTML.get(),"'"));
      //<< set strHTML=strHTML_" "_pstrOnload_"  "
      strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get()," "),pstrOnload.get()),"  "));
      //<< set strHTML=strHTML_"'"
      strHTML.set(mOp.Concat(strHTML.get(),"'"));
    }
    //<< }
    //<< // SR14047
    //<< ;write " onload=""var cookieValue = getCookie('AlphaLinc'); document.cookie = 'AlphaLinc = ' + (parseInt(cookieValue != null ? cookieValue: 0) + 1);"""
    //<< ;write " onload=""javascript:incrementWindowCount('AlphaLinc');"""
    //<< ;write " onunload=""var cookieValue = getCookie('AlphaLinc'); cookieValue = parseInt(cookieValue != null ? cookieValue: 0) - 1; document.cookie = 'AlphaLinc = ' + cookieValue; if (cookieValue == 0) window.open('"_YAKTION_"EP=WWWMANU&amp;YEXEC=*D|^WWWEND&amp;YUCI="_YUCI_"&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"','','HEIGHT=60,WIDTH=80')"""
    //<< ;write " onunload=""javascript:if (decrementWindowCount('AlphaLinc') == 0) window.open('"_YAKTION_"EP=WWWMANU&amp;YEXEC=*D|^WWWEND&amp;YUCI="_YUCI_"&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"','','HEIGHT=60,WIDTH=80');"""
    //<< 
    //<< set strHTML=strHTML_" onunload="" "
    strHTML.set(mOp.Concat(strHTML.get()," onunload=\" "));
    //<< ;SR17454
    //<< if ($$GetType^WWWMENU()'=11) if $$SR16427^WWWFORMJavascript() set strHTML=strHTML_"EventValue('"_YUCI_"','"_YUSER_"','"_$get(YFORM)_"','FIX','End^WWWEND','"_YM_"','6','"_YUSER_"'); "  ;16427
    if ((mOp.NotEqual(m$.fnc$("WWWMENU.GetType"),11))) {
      if (mOp.Logical(m$.fnc$("WWWFORMJavascript.SR16427"))) {
        strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"EventValue('"),m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.Fnc.$get(m$.var("YFORM"))),"','FIX','End^WWWEND','"),m$.var("YM").get()),"','6','"),m$.var("YUSER").get()),"'); "));
      }
    }
    //<< set strHTML=strHTML_" closeWindows(); "
    strHTML.set(mOp.Concat(strHTML.get()," closeWindows(); "));
    //<< set strHTML=strHTML_"               var frameForm = document.frames ? document.frames["_pintFormFrame_"] : null;"  //SR17343
    strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"               var frameForm = document.frames ? document.frames["),pintFormFrame.get()),"] : null;"));
    //<< set strHTML=strHTML_"           if (frameForm && typeof(frameForm.UnloadEvent) != 'undefined') { frameForm.UnloadEvent(frameForm); }"  //SR17343
    strHTML.set(mOp.Concat(strHTML.get(),"           if (frameForm && typeof(frameForm.UnloadEvent) != 'undefined') { frameForm.UnloadEvent(frameForm); }"));
    //<< if '$$SR16427^WWWFORMJavascript() set strHTML=strHTML_"             window.open('"_YAKTION_"EP=WWWMANU&YEXEC=*D|^WWWEND&amp;YUCI="_YUCI_"&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"','','HEIGHT=60,WIDTH=80')"
    if (mOp.Not(m$.fnc$("WWWFORMJavascript.SR16427"))) {
      strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"             window.open('"),m$.var("YAKTION").get()),"EP=WWWMANU&YEXEC=*D|^WWWEND&amp;YUCI="),m$.var("YUCI").get()),"&amp;YUSER="),m$.var("YUSER").get()),"&amp;YBED="),m$.var("YBED").get()),"','','HEIGHT=60,WIDTH=80')"));
    }
    //<< set strHTML=strHTML_""""
    strHTML.set(mOp.Concat(strHTML.get(),"\""));
    //<< set strHTML=strHTML_">"
    strHTML.set(mOp.Concat(strHTML.get(),">"));
    //<< write strHTML
    m$.Cmd.Write(strHTML.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< WriteJS()
  public Object WriteJS(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Write some JS
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-Jan-2007   GRF     Ensure functions at least start on new line to make
    //<< ;                       debugging easier.
    //<< ; 19-Dec-2006   JW      SR14235:  Added addWindow, closeWindows.
    //<< ; 26-Oct-2006   JW      BR014262: Created (Encapsulated). Added showMenu - moved from WWWFORM1
    //<< ;-------------------------------------------------------------------------------
    //<< new strURL,strDimensions,strID
    mVar strURL = m$.var("strURL");
    mVar strDimensions = m$.var("strDimensions");
    mVar strID = m$.var("strID");
    m$.newVar(strURL,strDimensions,strID);
    //<< 
    //<< set strURL=YAKTION_"EP=WWWMENU&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM
    strURL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWMENU&amp;YUSER="),m$.var("YUSER").get()),"&amp;YBED="),m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()));
    //<< set strDimensions="HEIGHT=500,WIDTH=300,SCROLLBARS=YES,RESIZEABLE=YES"
    strDimensions.set("HEIGHT=500,WIDTH=300,SCROLLBARS=YES,RESIZEABLE=YES");
    //<< set strID="MENUE"_YUSER
    strID.set(mOp.Concat("MENUE",m$.var("YUSER").get()));
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< 
    //<< // BR014262 - show the menu window. If already exists, just gain focus.
    //<< write !,"function showMenu(pintFrame) {"
    m$.Cmd.Write("\n","function showMenu(pintFrame) {");
    //<< write !,"   var strWindow = window.open('','"_strID_"','"_strDimensions_"');"
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("   var strWindow = window.open('','",strID.get()),"','"),strDimensions.get()),"');"));
    //<< write !,"   if (strWindow.location.href == 'about:blank') {"
    m$.Cmd.Write("\n","   if (strWindow.location.href == 'about:blank') {");
    //<< write !,"       window.open('"_strURL_"','"_strID_"','"_strDimensions_"');"
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("       window.open('",strURL.get()),"','"),strID.get()),"','"),strDimensions.get()),"');"));
    //<< write !,"           strWindow.opener=window.frames[pintFrame]; "
    m$.Cmd.Write("\n","           strWindow.opener=window.frames[pintFrame]; ");
    //<< write !,"           addWindow(strWindow); "
    m$.Cmd.Write("\n","           addWindow(strWindow); ");
    //<< write !,"   } else {"
    m$.Cmd.Write("\n","   } else {");
    //<< write !,"       strWindow.focus();"
    m$.Cmd.Write("\n","       strWindow.focus();");
    //<< write !,"   }"
    m$.Cmd.Write("\n","   }");
    //<< write !,"}",!                ; 02-Jan-2007
    m$.Cmd.Write("\n","}","\n");
    //<< 
    //<< // SR14235 - store a reference of a sub window for the parent window
    //<< write !,"function addWindow(pobjWindow) {"
    m$.Cmd.Write("\n","function addWindow(pobjWindow) {");
    //<< write !,"    try { "
    m$.Cmd.Write("\n","    try { ");
    //<< write !,"       var intLen = 0; "
    m$.Cmd.Write("\n","       var intLen = 0; ");
    //<< write !,"       if (window.subWindows!=undefined) {"
    m$.Cmd.Write("\n","       if (window.subWindows!=undefined) {");
    //<< write !,"           intLen = window.subWindows.length "
    m$.Cmd.Write("\n","           intLen = window.subWindows.length ");
    //<< write !,"       } else { "
    m$.Cmd.Write("\n","       } else { ");
    //<< write !,"           window.subWindows = new Array();"
    m$.Cmd.Write("\n","           window.subWindows = new Array();");
    //<< write !,"       } "
    m$.Cmd.Write("\n","       } ");
    //<< write !,"       window.subWindows[intLen] = pobjWindow; "
    m$.Cmd.Write("\n","       window.subWindows[intLen] = pobjWindow; ");
    //<< write !,"  } catch(e) { } "
    m$.Cmd.Write("\n","  } catch(e) { } ");
    //<< write !,"}",!                ; 02-Jan-2007
    m$.Cmd.Write("\n","}","\n");
    //<< 
    //<< // SR14235 - close all referenced sub windows for the current parent window
    //<< write !,"function closeWindows() {"
    m$.Cmd.Write("\n","function closeWindows() {");
    //<< write !,"       if (window.subWindows!=undefined) {"
    m$.Cmd.Write("\n","       if (window.subWindows!=undefined) {");
    //<< write !,"           var strWindow; "
    m$.Cmd.Write("\n","           var strWindow; ");
    //<< write !,"           for(var i=0;i<window.subWindows.length;i++) { "
    m$.Cmd.Write("\n","           for(var i=0;i<window.subWindows.length;i++) { ");
    //<< write !,"               with (window.subWindows[i]) {"
    m$.Cmd.Write("\n","               with (window.subWindows[i]) {");
    //<< write !,"                   if (!closed) { "
    m$.Cmd.Write("\n","                   if (!closed) { ");
    //<< write !,"                       changes = false; "
    m$.Cmd.Write("\n","                       changes = false; ");
    //<< write !,"                       close(); "
    m$.Cmd.Write("\n","                       close(); ");
    //<< write !,"                   }"
    m$.Cmd.Write("\n","                   }");
    //<< write !,"               }"
    m$.Cmd.Write("\n","               }");
    //<< write !,"           }"
    m$.Cmd.Write("\n","           }");
    //<< write !,"       }"
    m$.Cmd.Write("\n","       }");
    //<< write !,"}",!                ; 02-Jan-2007
    m$.Cmd.Write("\n","}","\n");
    //<< 
    //<< /*
    //<< write !,"function closeAllConfirm() {"
    //<< write !,"       var blnChanged = false; "
    //<< write !,"       if (window.subWindows!=undefined) {"
    //<< write !,"           for(var i=0;i<window.subWindows.length;i++) { "
    //<< write !,"               var win = window.subWindows[i]; "
    //<< write !,"               if (win.changes) { "
    //<< write !,"                   win.frames[0].UnloadConfirm(event); "  ;SR17253
    //<< write !,"                   break; "
    //<< write !,"               } "
    //<< write !,"           }"
    //<< write !,"       }"
    //<< write !,"}",!                ; 02-Jan-2007
    //<< */
    //<< 
    //<< write !,"function getCookie(pstrName) {",!
    m$.Cmd.Write("\n","function getCookie(pstrName) {","\n");
    //<< write !,"   var objCookie = document.cookie,",!
    m$.Cmd.Write("\n","   var objCookie = document.cookie,","\n");
    //<< write !,"       prefix = pstrName + '=',",!
    m$.Cmd.Write("\n","       prefix = pstrName + '=',","\n");
    //<< write !,"       begin = objCookie.indexOf('; ' + prefix);",!
    m$.Cmd.Write("\n","       begin = objCookie.indexOf('; ' + prefix);","\n");
    //<< write !,"   if (begin == -1) {",!
    m$.Cmd.Write("\n","   if (begin == -1) {","\n");
    //<< write !,"       begin = objCookie.indexOf(prefix);",!
    m$.Cmd.Write("\n","       begin = objCookie.indexOf(prefix);","\n");
    //<< write !,"       if (begin != 0) return null;",!
    m$.Cmd.Write("\n","       if (begin != 0) return null;","\n");
    //<< write !,"   } else {",!
    m$.Cmd.Write("\n","   } else {","\n");
    //<< write !,"       begin += 2;",!
    m$.Cmd.Write("\n","       begin += 2;","\n");
    //<< write !,"   }",!
    m$.Cmd.Write("\n","   }","\n");
    //<< write !,"   var end = document.cookie.indexOf(';', begin);",!
    m$.Cmd.Write("\n","   var end = document.cookie.indexOf(';', begin);","\n");
    //<< write !,"   if (end == -1) {",!
    m$.Cmd.Write("\n","   if (end == -1) {","\n");
    //<< write !,"       end = objCookie.length;",!
    m$.Cmd.Write("\n","       end = objCookie.length;","\n");
    //<< write !,"   }",!
    m$.Cmd.Write("\n","   }","\n");
    //<< write !,"   return unescape(objCookie.substring(begin + prefix.length, end));",!
    m$.Cmd.Write("\n","   return unescape(objCookie.substring(begin + prefix.length, end));","\n");
    //<< write !,"}",!
    m$.Cmd.Write("\n","}","\n");
    //<< 
    //<< write !,"function incrementWindowCount(pstrName) {",!
    m$.Cmd.Write("\n","function incrementWindowCount(pstrName) {","\n");
    //<< write !,"   var strCookieValue = getCookie(pstrName);",!
    m$.Cmd.Write("\n","   var strCookieValue = getCookie(pstrName);","\n");
    //<< write !,"   if (strCookieValue == null) strCookieValue = '0:' + document.location.href;" // Should never need this
    m$.Cmd.Write("\n","   if (strCookieValue == null) strCookieValue = '0:' + document.location.href;");
    //<< write !,"   document.cookie = pstrName + ' = ' + (parseInt(strCookieValue) + 1) + strCookieValue.substring(strCookieValue.indexOf(':'),strCookieValue.length);",!
    m$.Cmd.Write("\n","   document.cookie = pstrName + ' = ' + (parseInt(strCookieValue) + 1) + strCookieValue.substring(strCookieValue.indexOf(':'),strCookieValue.length);","\n");
    //<< write !,"}",!
    m$.Cmd.Write("\n","}","\n");
    //<< 
    //<< write !,"function decrementWindowCount(pstrName) {",!
    m$.Cmd.Write("\n","function decrementWindowCount(pstrName) {","\n");
    //<< write !,"   var strCookieValue = getCookie(pstrName),",!
    m$.Cmd.Write("\n","   var strCookieValue = getCookie(pstrName),","\n");
    //<< write !,"       intCount;",!
    m$.Cmd.Write("\n","       intCount;","\n");
    //<< write !,"   if (strCookieValue != null) {",!
    m$.Cmd.Write("\n","   if (strCookieValue != null) {","\n");
    //<< write !,"      intCount = parseInt(strCookieValue) - 1;",!
    m$.Cmd.Write("\n","      intCount = parseInt(strCookieValue) - 1;","\n");
    //<< write !,"      strCookieValue = intCount + strCookieValue.substring(strCookieValue.indexOf(':'),strCookieValue.length);",!
    m$.Cmd.Write("\n","      strCookieValue = intCount + strCookieValue.substring(strCookieValue.indexOf(':'),strCookieValue.length);","\n");
    //<< write !,"      document.cookie = pstrName + ' = ' + strCookieValue;",!
    m$.Cmd.Write("\n","      document.cookie = pstrName + ' = ' + strCookieValue;","\n");
    //<< write !,"   } else {",!
    m$.Cmd.Write("\n","   } else {","\n");
    //<< write !,"      strCookieValue = 0;",!
    m$.Cmd.Write("\n","      strCookieValue = 0;","\n");
    //<< write !,"   }",!
    m$.Cmd.Write("\n","   }","\n");
    //<< write !,"   return parseInt(strCookieValue);",!
    m$.Cmd.Write("\n","   return parseInt(strCookieValue);","\n");
    //<< write !,"}",!
    m$.Cmd.Write("\n","}","\n");
    //<< 
    //<< if $$SR16427^WWWFORMJavascript() do EventValue^WWWFORMJavascript()
    if (mOp.Logical(m$.fnc$("WWWFORMJavascript.SR16427"))) {
      m$.Cmd.Do("WWWFORMJavascript.EventValue");
    }
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< if $$SR16427^WWWFORMJavascript() do Event^WWWMENU5()
    if (mOp.Logical(m$.fnc$("WWWFORMJavascript.SR16427"))) {
      m$.Cmd.Do("WWWMENU5.Event");
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ClearOnLoad(pidUser, pidForm)
  public Object ClearOnLoad(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Clear off old content
    //<< ;
    //<< ; Called By: BODY^WWWBODY
    //<< ; Params:
    //<< ;   pidUser - User Id
    //<< ;   pidForm - Form Id
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 09-Feb-2007   RPW     SR15426: Kill COMView details when changing forms.
    //<< ; 25-Jan-2007   PO      SR15280: Don't delete the Edit Grid cache if form is either header OR line
    //<< ; 05-Jan-2007   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLastFormWithGrid,objForm,idLastGrid
    mVar idLastFormWithGrid = m$.var("idLastFormWithGrid");
    mVar objForm = m$.var("objForm");
    mVar idLastGrid = m$.var("idLastGrid");
    m$.newVar(idLastFormWithGrid,objForm,idLastGrid);
    //<< 
    //<< if (pidUser '= "") && (pidForm '= "") {
    if ((mOp.NotEqual(pidUser.get(),"")) && (mOp.NotEqual(pidForm.get(),""))) {
      //<< 
      //<< set objForm = $get(^WWW120(0,pidForm,1))
      objForm.set(m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1)));
      //<< 
      //<< ; TODO: This check may be too simplistic
      //<< if $$$WWW120FormType(objForm) '= 5 { ; Type 5 is Manual Form without Button, seems to be preventing clear when it should eg. COMView, Calendar...
      if (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,objForm),5)) {
        //<< ; these are popups that have the same YUSER as the parent window.
        //<< ; The only known issue is that there are type 5 forms accessable via the LHS menu which means the Grid cache
        //<< ; will not be cleared until navigating to a non type 5 form.
        //<< set idLastFormWithGrid = $$$GRIDContainer
        idLastFormWithGrid.set(include.COMGridEdit31Interface.$$$GRIDContainer(m$));
        //<< set idLastGrid = $$$GRIDName
        idLastGrid.set(include.COMGridEdit31Interface.$$$GRIDName(m$));
        //<< 
        //<< if (idLastFormWithGrid '= "") && (idLastGrid '= "") && (idLastFormWithGrid '= pidForm) && (idLastGrid '= pidForm) { // SR15280
        if ((mOp.NotEqual(idLastFormWithGrid.get(),"")) && (mOp.NotEqual(idLastGrid.get(),"")) && (mOp.NotEqual(idLastFormWithGrid.get(),pidForm.get())) && (mOp.NotEqual(idLastGrid.get(),pidForm.get()))) {
          //<< //if (idLastFormWithGrid '= "") && (idLastFormWithGrid '= pidForm) { // SR15280
          //<< do DELETE^COMGridEdit31R()
          m$.Cmd.Do("COMGridEdit31R.DELETE");
        }
        //<< }
        //<< 
        //<< do ClearOld^WWWMultiLock(pidUser,pidForm)
        m$.Cmd.Do("WWWMultiLock.ClearOld",pidUser.get(),pidForm.get());
        //<< do CleanupCOMView^COMViewFilter(pidForm) // SR15426: Cleanup COMView is we have changed forms. This is needed to remove extra details for inform COMViews
        m$.Cmd.Do("COMViewFilter.CleanupCOMView",pidForm.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

//<< 
}
