//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM8
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:04
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWFORM8
public class WWWFORM8 extends mClass {

  public void main() {
    _WWWFORM8();
  }

  public void _WWWFORM8() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; BUILD JAVASCRIPT/VBSCRIPT      ; EINBAUEN
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-May-2013   shobby  CORE-70.2: Some forms such as WWWPARA and COMViewSearch will react badly
    //<< ;                                  to this redirection, but can generally be assumed that they were
    //<< ;                                   called from a button press rather than a right-click/new window.
    //<< ; 23-Apr-2013   shobby  CORE-80.1: Use $$$JSText to convert the href before assigning.
    //<< ; 10-Apr-2013   shobby  CORE-70: Function NewSession, creates a new YUSER if the screen is loaded
    //<< ;                                by right clicking on a tab. CORE-70
    //<< ; 18-Oct-2012   shobby  SR18145: Only setfocus to a control if it is present.
    //<< ; 17-Oct-2012   shobby  SR18066: doBlur function
    //<< ; 28-Jun-2012   shobby  SR17790: Removed the 900 sec minimum, let cache settings determine
    //<< ;                           the minimum.
    //<< ; 27-Jun-2012   shobby  SR17790: Ensure that Alphalinc times out before cache session.
    //<< ; 19-Jun-2012   shobby  SR17790: Changes so that logout won't be stopped if a
    //<< ;                           modal form is present.
    //<< ; 03-Nov-2011   shobby  SR17725: New type of control FATSearch
    //<< ; 27-Jan-2011   shobby  SR17086: Called out to WWWFORMHOTKEY to allow
    //<< ;                           configuration of hot keys.
    //<< ; 07-Oct-2010   shobby  SR17564: Create javascript for inheritable checkboxes.
    //<< ; 23-Apr-2010   shobby  SR17267: Script to support popup warning messages.
    //<< ; 13-Apr-2010   shobby  Function pruef wasn't being found by KeyEvent probably
    //<< ;                           because of different scoping of $$$StartScript/
    //<< ;                           $$$EndScript
    //<< ; 24-Jun-2009   GRF     Doco
    //<< ; 30-Mar-2009   shobby  SR16459: SRBR014794 code restoration from SES/DEV merge
    //<< ; 30-Mar-2009   GRF     Doco
    //<< ; 07-Feb-2008   shobby  SRBR014794: Check YFELD exists before calling JSInitializingMasking
    //<< ; 04-Jan-2008   heber   SRBR014794: Add call new funtion which loads mask variables
    //<< ; 19-Sep-2007   shobby  SRBR014721: Don't use disabled for textarea controls,
    //<< ;                           they become hard to read.
    //<< ; 16-Jul-2007   HeberB  SRBR014502:Add JS for masking
    //<< ; 07-May-2007   GRF     SRBR014310: Doco; quits
    //<< ; 23-Aug-2006   shobby  SR14969: Redirect to the specified form (could be login)
    //<< ;                           on timeout.
    //<< ; 06-Jul-2006   FIS     SR14800: Use XMLHttpRequest only
    //<< ; 02-May-2006   SS      SR14592: NewPage function
    //<< ; 01-Jun-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 30-May-2005   shobby  SR11027: Enabled faster piece function.
    //<< ; 12-May-2005   FIS     SR11027: new version - function piece
    //<< ; 22-Mar-2005   Paul K  Changed to check for existance of COMViewSetup routine
    //<< ;                           before calling COMView (SR#11912)
    //<< ; 13.11.1997    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new YLF,YON,YFU,YTX,YI,YTX1
    mVar YLF = m$.var("YLF");
    mVar YON = m$.var("YON");
    mVar YFU = m$.var("YFU");
    mVar YTX = m$.var("YTX");
    mVar YI = m$.var("YI");
    mVar YTX1 = m$.var("YTX1");
    m$.newVar(YLF,YON,YFU,YTX,YI,YTX1);
    //<< 
    //<< do JSMaskFunction() ; always print the code to apply mask
    m$.Cmd.Do("JSMaskFunction");
    //<< 
    //<< ; need to check YFELD here it may not exist in such forms as INTOURCHART
    //<< if $data(YFELD) do JSInitializingMasking(YFELD,YFORM) ; create mask variables and load into initial mask values
    if (mOp.Logical(m$.Fnc.$data(m$.var("YFELD")))) {
      m$.Cmd.Do("JSInitializingMasking",m$.var("YFELD").get(),m$.var("YFORM").get());
    }
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write "function NewPage(pobjForm) {"
    m$.Cmd.Write("function NewPage(pobjForm) {");
    //<< write "     document.getElementById('MASTER').style.display=""none"";"
    m$.Cmd.Write("     document.getElementById('MASTER').style.display=\"none\";");
    //<< write "}"
    m$.Cmd.Write("}");
    //<< write !
    m$.Cmd.Write("\n");
    //<< do Setup^WWWFORMCrossBrowserSupport()           ;SR17253
    m$.Cmd.Do("WWWFORMCrossBrowserSupport.Setup");
    //<< do Setup^WWWFORMButtonScript()                  ;SR17253
    m$.Cmd.Do("WWWFORMButtonScript.Setup");
    //<< do Javascript^WWWFORM7InheritableCheckBox()     ;SR17564
    m$.Cmd.Do("WWWFORM7InheritableCheckBox.Javascript");
    //<< do Javascript^WWWFORM7FATSearch()               ;SR17725
    m$.Cmd.Do("WWWFORM7FATSearch.Javascript");
    //<< 
    //<< ;SR17267 vvvvvv
    //<< write "var Warning;",!
    m$.Cmd.Write("var Warning;","\n");
    //<< write "function SetupWarning(pObject,pstrWarning) {",!
    m$.Cmd.Write("function SetupWarning(pObject,pstrWarning) {","\n");
    //<< write "  Warning=pstrWarning;",!
    m$.Cmd.Write("  Warning=pstrWarning;","\n");
    //<< write "  var obj = document.createElement('img');",!
    m$.Cmd.Write("  var obj = document.createElement('img');","\n");
    //<< write "  obj.src=FilePath+'warning.ico';",!
    m$.Cmd.Write("  obj.src=FilePath+'warning.ico';","\n");
    //<< write "  obj.style.cursor='pointer';",!
    m$.Cmd.Write("  obj.style.cursor='pointer';","\n");
    //<< write "  obj.attachEvent('onclick',ShowWarning);",!
    m$.Cmd.Write("  obj.attachEvent('onclick',ShowWarning);","\n");
    //<< write "  doInsertAdjacentElement(pObject,'AfterEnd',obj);",!
    m$.Cmd.Write("  doInsertAdjacentElement(pObject,'AfterEnd',obj);","\n");
    //<< write " }",!
    m$.Cmd.Write(" }","\n");
    //<< write "function ShowWarning() {",!
    m$.Cmd.Write("function ShowWarning() {","\n");
    //<< write "  CallBackNow('Show^WWWPopupMessage',Warning,'"_$$$JSText($$$Text("Com00179"))_"');"  ; "Warning"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("  CallBackNow('Show^WWWPopupMessage',Warning,'",include.COMSYSString.$$$JSText(m$,include.COMSYS.$$$Text(m$,"Com00179"))),"');"));
    //<< write "}"
    m$.Cmd.Write("}");
    //<< ;SR17267 ^^^^^
    //<< 
    //<< ;SR18145 vvvvv
    //<< &js<
    //<< function ControlSetFocus(pidControl) {
    //<< var objcontrol=document.getElementById(pidControl);
    //<< if (objcontrol!=undefined) {
    //<< if(!objcontrol.readOnly && objcontrol.type!='hidden' && !objcontrol.disabled) {objcontrol.focus();}
    //<< } else {
    //<< //alert(pidControl+' is missing');
    //<< }
    //<< }
    //<< function doBlur(pthis,selval) {     //18066
    //<< var value;
    //<< if (selval==undefined) {
    //<< value=pthis.value;
    //<< } else {
    //<< value=selval
    //<< }
    //<< if (!pthis.readOnly)
    //<< if (value!=pthis.getAttribute('_oldValue')) {
    //<< pthis.setAttribute('_oldValue',value);
    //<< return true;
    //<< }
    //<< return false
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("        function ControlSetFocus(pidControl) {","\n");
    m$.Cmd.WriteJS("            var objcontrol=document.getElementById(pidControl);","\n");
    m$.Cmd.WriteJS("            if (objcontrol!=undefined) {","\n");
    m$.Cmd.WriteJS("                if(!objcontrol.readOnly && objcontrol.type!='hidden' && !objcontrol.disabled) {objcontrol.focus();}","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                //alert(pidControl+' is missing');","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function doBlur(pthis,selval) {     //18066            ","\n");
    m$.Cmd.WriteJS("            var value;","\n");
    m$.Cmd.WriteJS("            if (selval==undefined) {","\n");
    m$.Cmd.WriteJS("                value=pthis.value;","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                value=selval","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            if (!pthis.readOnly)","\n");
    m$.Cmd.WriteJS("                if (value!=pthis.getAttribute('_oldValue')) {","\n");
    m$.Cmd.WriteJS("                    pthis.setAttribute('_oldValue',value);","\n");
    m$.Cmd.WriteJS("                    return true;","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            return false","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    ");
    //<< Write "     function newSession() { //CORE-70",!
    m$.Cmd.Write("     function newSession() { //CORE-70","\n");
    //<< 
    //<< if 1 {
    if (mOp.Logical(1)) {
      //<< ; If the user has opened a page by right-clicking then the YUSER will be the same as the original window.  Here we
      //<< ; detect if there was a previous window and redirect to the same form but using a different YUSER.
      //<< ;new YUSER1
      //<< ;set YUSER1=YUSER
      //<< new YUSER
      mVar YUSER = m$.var("YUSER");
      m$.newVar(YUSER);
      //<< set YUSER=""
      YUSER.set("");
      //<< Write "         var YUSER",!
      m$.Cmd.Write("         var YUSER","\n");
      //<< Write "         if ((window.opener!=undefined)&&(document.getElementById('YFORM').value!='WWWPARA')&&(document.getElementById('YFORM').value!='COMViewSearch')) {",! ;CORE-70.2
      m$.Cmd.Write("         if ((window.opener!=undefined)&&(document.getElementById('YFORM').value!='WWWPARA')&&(document.getElementById('YFORM').value!='COMViewSearch')) {","\n");
      //<< Write "             var href=window.location.href;",!
      m$.Cmd.Write("             var href=window.location.href;","\n");
      //<< Write "             var YUSER=href.split('&YUSER=')[1].split('&')[0];",!
      m$.Cmd.Write("             var YUSER=href.split('&YUSER=')[1].split('&')[0];","\n");
      //<< ;Write "            retval=EventValue('"_(YUCI)_"',YUSER,'"_(YFORM)_"','FIX','CreateChildUser^WWWUSER',YUSER,'6',YUSER);",!
      //<< Write "             retval=EventValue('"_(YUCI)_"',YUSER,'"_(YFORM)_"','FIX','NewUser^WWWUSER',YUSER,6,YUSER);",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("             retval=EventValue('",(m$.var("YUCI").get())),"',YUSER,'"),(m$.var("YFORM").get())),"','FIX','NewUser^WWWUSER',YUSER,6,YUSER);"),"\n");
      //<< Write "             if (retval!='') {",!
      m$.Cmd.Write("             if (retval!='') {","\n");
      //<< Write "                 var href='"_$$$JSText((YAKTION_"&EP=WWWFORM&YFORM="_YFORM_$$WWWCGI2^WWWCGI()_"&YUSER="))_"'+retval;",! ;CORE-70.1
      m$.Cmd.Write(mOp.Concat(mOp.Concat("                 var href='",include.COMSYSString.$$$JSText(m$,(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"&EP=WWWFORM&YFORM="),m$.var("YFORM").get()),m$.fnc$("WWWCGI.WWWCGI2")),"&YUSER=")))),"'+retval;"),"\n");
      //<< write "                 window.opener=null;"
      m$.Cmd.Write("                 window.opener=null;");
      //<< Write "                 window.location.href=href;",!
      m$.Cmd.Write("                 window.location.href=href;","\n");
      //<< Write "             }",!
      m$.Cmd.Write("             }","\n");
      //<< Write "         }",!
      m$.Cmd.Write("         }","\n");
    }
    //<< }
    //<< Write "     }   ",!
    m$.Cmd.Write("     }   ","\n");
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< if $get(YMOUSETR)=1 do SCRIPT^WWWTRAIL   ;MOUSETRAIL START
    if (mOp.Equal(m$.Fnc.$get(m$.var("YMOUSETR")),1)) {
      m$.Cmd.Do("WWWTRAIL.SCRIPT");
    }
    //<< set YTX=""
    YTX.set("");
    //<< if YFORM'="" set YTX=$piece($get(^WWW120(0,YFORM,1)),Y,92)  ;MANUELLER SCRIPT
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      YTX.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),92));
    }
    //<< if +$get(^SysSetup("js debug"))'=0 do jsDebugFunction()
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","js debug"))),0)) {
      m$.Cmd.Do("jsDebugFunction");
    }
    //<< if YTX'="" {
    if (mOp.NotEqual(YTX.get(),"")) {
      //<< ;   IF YBEDBER=1 WRITE YCR,YCR,",<!-- ************************* EVENT BROKER (WWWFORM8)************************* -->",YCR,YCR
      //<< for YLF=1:1 {
      for (YLF.set(1);(true);YLF.set(mOp.Add(YLF.get(),1))) {
        //<< quit:$piece(YTX,"|",YLF,999)=""
        if (mOp.Equal(m$.Fnc.$piece(YTX.get(),"|",YLF.get(),999),"")) {
          break;
        }
        //<< 
        //<< write $piece(YTX,"|",YLF)
        m$.Cmd.Write(m$.Fnc.$piece(YTX.get(),"|",YLF.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; SR17086 vvvvvvvvvvvvvvvvvvvvvvvv
    //<< do JS^WWWFORMHOTKEY()
    m$.Cmd.Do("WWWFORMHOTKEY.JS");
    //<< /*
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   YVOR            objWWW120
    //<< ;       D2              $$$WWW120FormType()
    //<< ;       D94             $$$WWW120DoNOTDisplayStandardButto()
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< ; js : pruef()  : Check certain key presses - includes testing for disabled Standard Buttons
    //<< ;---------------------------------------
    //<< ;   Button         Key  wert
    //<< ;                   F5  (116)  Note : IE refresh overrides
    //<< ;                   F6  (117)  Note : Also performs IE operation (shift between frames and URL field)
    //<< ;  11 Prev Record   F7  (118)
    //<< ;  12 Next Record   F8  (119)
    //<< ;   9 Search        F9  (120)
    //<< ;   3 Save          F12 (123)  Note : Conflict with IE8
    //<< ;---------------------------------------
    //<< ;MIT DIESER FUNKTION RUF DIE FUNKTIONSTASTE F12 DEN SUBMIT AUF ;by means of this rumour who function key upon
    //<< ;IF $GET(YNOEVENTKEY)'=1 DO  ;FIS;19.09.03;AUSSCHALTEN ONKEY-PRÜFUNG FÜR MANUELLE HTML-DATEIEN
    //<< IF $GET(YNOEVENTKEY)'=1 IF $PIECE($GET(YVOR),Y,2)'=11 IF $PIECE($GET(YVOR),Y,2)'=9 DO  ;24502;FIS;20.04.04;NICHT BEI FORMULARARTEN EDIT TABLE/BITMAP
    //<< . IF YFORM'="" IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,134) = $$$YES QUIT   ; NO EVENTKEY - Form      ;BEC;26976;10.12.04
    //<< . IF $PIECE($GET(^WWW012(0,0,1)),Y,169) = $$$YES                  QUIT   ; NO EVENTKEY - General   ;BEC;26976;10.12.04
    //<< . ;
    //<< . $$$StartScript("for=document event='onkeyup()'")
    //<< . ;
    //<< . ; SR17086
    //<< . ;WRITE "if (navigator.appName.indexOf('Microsoft Internet Explorer') != -1)"  ;tybd;26,07,2004;26159;mozilla
    //<< . WRITE "if (document.all)"                    ;bec;28,07,2004;26159;mozilla
    //<< . WRITE "{"
    //<< . WRITE " {pruef(window.event.keyCode)}"       ;bec;28,07,2004;26159;mozilla
    //<< . WRITE "}"
    //<< . WRITE " function pruef(wert)"
    //<< . WRITE " { "
    //<< . WRITE "  if (wert == 117) {window.history.back();}"
    //<< . ;WRITE "    if (wert == 116) {document.WWW.YOPEN.value='SAVEHELP'; SAVENOW();}"
    //<< . ;WRITE "    if (wert == 116) {document.WWW.YOPEN.value='SAVEHELP'; window.setTimeout('SAVENOW()',100);}"  ;FIS;25245;F12 SAVE ZU SCHNELL FÜR FIELDVALIDATION
    //<< . WRITE "    if (wert == 116) { window.setTimeout('SAVENOW(""SAVEHELP"");',100); }"  // SR13195 - JW FIXME - this doesn't actually work. Refresh overrides it.
    //<< . ;
    //<< . IF $GET(YBEARB)'=4 IF ($$$WWW120AuthorizationToModifyData(YVOR)'=$$$EnumReadOnly) IF '$FIND(","_$TRANSLATE($PIECE($GET(YVOR),Y,94),";",",")_",",",3,") DO
    //<< . .;WRITE "    if (wert == 123) {window.focus();document.WWW.YBUTTON.value='';document.WWW.YOPEN.value='0'; SAVENOW();}"  ;TYBD;4,2,2004;YBUTTON
    //<< . . WRITE "    if (wert == 123) {window.focus();document.WWW.YBUTTON.value='';document.WWW.YOPEN.value='0'; window.setTimeout('SAVENOW()',100);}" QUIT  ;FIS;25245;F12 SAVE ZU SCHNELL FÜR FIELDVALIDATION
    //<< . IF ($GET(YBEARB)=4) || ($$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly) || ($FIND(","_$TRANSLATE($PIECE($GET(YVOR),Y,94),";",",")_",",",3,")) DO
    //<< . . WRITE "    if (wert == 123) {window.alert(""F12 "_$$^WWWTEXT(144,,1)_"!"");}"   ; "Not Possible"   ; NICHT MÖGLICH
    //<< . ;
    //<< . IF YFORM'="" IF ($$$WWW120FormType($GET(YVOR))=1) || ($$$WWW120FormType($GET(YVOR))=3) DO
    //<< . . ;IF '$FIND(","_$TRANSLATE($PIECE(YVOR,Y,94),";",",")_",",",9,") WRITE "    if (wert == 120) {document.WWW.YOPEN.value=""SAVESEAR""; SAVENOW();}"
    //<< . . ;IF $$$WWW120FormType($GET(YVOR))=1 DO
    //<< . . ;. IF '$FIND(","_$TRANSLATE($PIECE(YVOR,Y,94),";",",")_",",",12,") IF +$GET(YTIMEFORM)=0 WRITE "    if (wert == 118) {document.WWW.YRICHT1.value=""BACK"";document.WWW.YBUTTON.value='';document.WWW.YOPEN.value='0';SAVENOW();}"  ;TYBD,4,2,2004
    //<< . . ;. IF '$FIND(","_$TRANSLATE($PIECE(YVOR,Y,94),";",",")_",",",11,") IF +$GET(YTIMEFORM)=0 WRITE "    if (wert == 119) {document.WWW.YRICHT1.value=""NEXT"";document.WWW.YBUTTON.value='';document.WWW.YOPEN.value='0';SAVENOW();}"  ;TYBD,4,2,2004
    //<< . . ;
    //<< . . IF '$FIND(","_$TRANSLATE($PIECE(YVOR,Y,94),";",",")_",",",9,") WRITE "    if (wert == 120) { ShowSearch(); }"       // COMView now always used.
    //<< . . IF $$$WWW120FormType($GET(YVOR))=1 DO    ; Standard Form
    //<< . . . IF '$FIND(","_$TRANSLATE($PIECE(YVOR,Y,94),";",",")_",",",12,") IF +$GET(YTIMEFORM)=0 WRITE "    if (wert == 118) { window.location='" do DirectionURL^WWWFORMF("BACK") write "'; }"  ;TYBD,4,2,2004
    //<< . . . IF '$FIND(","_$TRANSLATE($PIECE(YVOR,Y,94),";",",")_",",",11,") IF +$GET(YTIMEFORM)=0 WRITE "    if (wert == 119) { window.location='" do DirectionURL^WWWFORMF("NEXT") write "'; }"  ;TYBD,4,2,2004
    //<< . ;
    //<< . WRITE " }"
    //<< . ;WRITE "}"           ;BEC;28,07,2004;26159;mozilla
    //<< . ;SR17253 $$$EndScript()
    //<< 
    //<< 
    //<< . ;SR17253 ; js : keyEvent()
    //<< . ;SR17253 ;---------------------------------------
    //<< . ;SR17253 IF $GET(YNOEVENTKEY)'=1 IF $PIECE($GET(YVOR),Y,2)'=11 IF $PIECE($GET(YVOR),Y,2)'=9 DO   ;BEC;28,07,2004;26159;mozilla
    //<< . ;SR17253 $$$StartScript()
    //<< . WRITE " function keyEvent(e) {"
    //<< . WRITE "   if (!(document.all)) {pruef(e.which)}"
    //<< . WRITE "   return true;"
    //<< . WRITE " }"
    //<< . WRITE " document.onkeyup = keyEvent;"
    //<< . $$$EndScript()
    //<< */
    //<< ; SR17086 ^^^^^^^^^^^^^^^^^^^^^^^^^^
    //<< 
    //<< ; js : CSPstartClock()
    //<< ;---------------------------------------
    //<< if +$get(YHYPER)=1 do                       ;TIMEOUT ;SR14969 VVV
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),1)) {
      do {
        //<< . new TIMEOUT,objWWW012,strHTM
        mVar TIMEOUT = m$.var("TIMEOUT");
        mVar objWWW012 = m$.var("objWWW012");
        mVar strHTM = m$.var("strHTM");
        m$.newVar(TIMEOUT,objWWW012,strHTM);
        //<< . set objWWW012 = $get(^WWW012(0,0,1))
        objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
        //<< . $$$StartScript()              ;CORE-70
        include.COMSYS.$$$StartScript(m$);
        //<< . write "var CSPEnding=false;"  ;CORE-70
        m$.Cmd.Write("var CSPEnding=false;");
        //<< . $$$EndScript()                ;CORE-70
        include.COMSYS.$$$EndScript(m$);
        //<< . if +$$$WWW012AutoEventRequestInBackgro(objWWW012)=1 quit  ;NO TIMEOUT;TYBD;14,11,2004
        if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW012AutoEventRequestInBackgro(m$,objWWW012)),1)) {
          break;
        }
        //<< . set TIMEOUT=$select($isobject(%session):%session.AppTimeout,1:900)
        TIMEOUT.set(m$.Fnc.$select(m$.Fnc.$isobject(m$.getSession()),m$.getSession().getAppTimeout(),1,900));
        //<< . ;if TIMEOUT<900 set TIMEOUT=900
        //<< . do
        do {
          //<< . . ;SR17790 This ensures that cache session hasn't timed out before Alphalinc timeout.
          //<< . . ;set TIMEOUT=TIMEOUT-(1.5*$$$WWW012RequestEverySeconds(objWWW012))
          //<< . . set TIMEOUT=TIMEOUT-10
          TIMEOUT.set(mOp.Subtract(TIMEOUT.get(),10));
        } while(false);
        //<< . $$$StartScript()
        include.COMSYS.$$$StartScript(m$);
        //<< . ; SR17790 vvvvvvv
        //<< . write "var mycounter=0;"
        m$.Cmd.Write("var mycounter=0;");
        //<< . ;
        //<< . write "function CSPstartClock(timeout,towhere,whatdoc) { "
        m$.Cmd.Write("function CSPstartClock(timeout,towhere,whatdoc) { ");
        //<< . write " if(mycounter!=0) { clearTimeout(mycounter);}"
        m$.Cmd.Write(" if(mycounter!=0) { clearTimeout(mycounter);}");
        //<< . write " if(timeout==null) { timeout="_TIMEOUT_"}"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" if(timeout==null) { timeout=",TIMEOUT.get()),"}"));
        //<< . write " mycounter = setTimeout(function() { CSPCallLogout()}, (timeout*1000)); "
        m$.Cmd.Write(" mycounter = setTimeout(function() { CSPCallLogout()}, (timeout*1000)); ");
        //<< . write "}"
        m$.Cmd.Write("}");
        //<< . write "function CSPLogout() {"
        m$.Cmd.Write("function CSPLogout() {");
        //<< . write " CSPEnding=true;"
        m$.Cmd.Write(" CSPEnding=true;");
        //<< . write " var whatdoc='"_$select(+$$$WWW012RedirectToFullScreen(objWWW012):"top.",1:"")_"document.location.href';"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" var whatdoc='",m$.Fnc.$select(mOp.Positive(include.WWWConst.$$$WWW012RedirectToFullScreen(m$,objWWW012)),"top.",1,"")),"document.location.href';"));
        //<< . set strHTM=$$$WWW012RedirectToOnTimeout(objWWW012)
        strHTM.set(include.WWWConst.$$$WWW012RedirectToOnTimeout(m$,objWWW012));
        //<< . if strHTM="" set strHTM="BLANK.HTM"
        if (mOp.Equal(strHTM.get(),"")) {
          strHTM.set("BLANK.HTM");
        }
        //<< . if $extract($reverse(strHTM),1,3)="MTH" set strHTM=YGIF_"/"_strHTM
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(strHTM.get()),1,3),"MTH")) {
          strHTM.set(mOp.Concat(mOp.Concat(m$.var("YGIF").get(),"/"),strHTM.get()));
        }
        //<< . write " var towhere='"_strHTM_"';"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" var towhere='",strHTM.get()),"';"));
        //<< . write " eval(whatdoc+'=""'+towhere+'""');"
        m$.Cmd.Write(" eval(whatdoc+'=\"'+towhere+'\"');");
        //<< . write "}"
        m$.Cmd.Write("}");
        //<< . ;
        //<< . write "CSPstartClock();"
        m$.Cmd.Write("CSPstartClock();");
        //<< . write "function CSPCallLogout() {"
        m$.Cmd.Write("function CSPCallLogout() {");
        //<< . write "   CSPEnding=true;"
        m$.Cmd.Write("   CSPEnding=true;");
        //<< . write "   top.window.returnValue='## timeout ##';"
        m$.Cmd.Write("   top.window.returnValue='## timeout ##';");
        //<< . write "   window.close();"
        m$.Cmd.Write("   window.close();");
        //<< . write "   window.setTimeout('CSPLogout()',1000);"
        m$.Cmd.Write("   window.setTimeout('CSPLogout()',1000);");
        //<< . write "}"
        m$.Cmd.Write("}");
        //<< . ; SR17790 ^^^^^^
        //<< . $$$EndScript()
        include.COMSYS.$$$EndScript(m$);
      } while (false);
    }
    //<< 
    //<< set YEVENT = $piece($get(^WWW012(0,0,1)),Y,82)  ;flag für eventbroker ; $$$WWW012EventBrokerOn()
    mVar YEVENT = m$.var("YEVENT");
    YEVENT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),m$.var("Y").get(),82));
    //<< if YHTMFORM="WWW2" set YEVENT = $$$YES           ;IMMER EINGESCHALTET ;constantly
    if (mOp.Equal(m$.var("YHTMFORM").get(),"WWW2")) {
      YEVENT.set(include.COMSYS.$$$YES(m$));
    }
    EVENTCALL();
  }

  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< ;  Drop Through to EVENTCALL
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< EVENTCALL  ;EINSPRUNG AUS WWWTABLE1 ;out of
  public void EVENTCALL() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 31-Jul-2012   shobby  SR18075: Preserve SPRACHE in new field
    //<< ; 16-Aug-2011   shobby  SR17784: getParent moved from COMGridEdit31JSort.
    //<< ; 24-Aug-2010   shobby  SR17518: Corrected a problem with making fields readonly.
    //<< ; 11-May-2010   shobby  SR17291: Another attempt at an update of UpdateFieldFormat
    //<< ; 10-May-2010   shobby  SR17291: Reverted UpdateFieldFormat javascript function.
    //<< ; 05-May-2010   GRF     SR17286: dot to brace with optimisation (if/else);
    //<< ;                           activate SR17253 change
    //<< ; 28-Jul-2009   shobby  SR16751: Define the retval variable
    //<< ; 23-Mar-2009   shobby  SR16427:    Subroutined setup of cspxmlhttp
    //<< ; 31-May-2007   shobby  SRBR014409: Same thing for checkboxes
    //<< ; 31-May-2007   shobby  SRBR014409: workaround to disable textarea controls
    //<< ;                           because readOnly property doesn't seem to work.
    //<< ; 14-May-2007   GRF     Check ^Development as macro not ^DEVELOPMENT
    //<< ; 08-May-2007   RPW     SR15513: Rewrote the *Format routines to nicely start
    //<< ;                           to handle the grid.
    //<< ; 07-May-2007   RPW     SRBR014310: Fixed the boolean level javascript.
    //<< ; 02-May-2007   GRF     SR15508: Make sure showing js errors doesn't cause an error.
    //<< ; 27-Apr-2007   RPW     SRBR014310: Make the updating of fields totally client based
    //<< ; 19-Dec-2006   JW      BR014262: Use EndScript. Was causing errors.
    //<< ; 08-Dec-2006   PO      SR15276: Changed name of EventBroker to JSLibraries
    //<< ; 24-Aug-2006   JW      SR14939: Translate for linux as well.
    //<< ; 21-Aug-2006   FrankF  SRBR014066: Passing the page number to the server.
    //<< ; 10-Aug-2006   JW      SR13594: Translate ` to '
    //<< ; 02-Jun-2006   JW      SR14697: Always use eventbrokeren1.js
    //<< ; 22-Jul-2005   JW      SR12615: Added UpdateFieldFormat / ResetFieldFormat
    //<< ; 31-Oct-2003   FIS     JavaScript Error Handlers
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< 
    //<< if '$$$DEVMODE {
    if (mOp.Not(include.COMSYS.$$$DEVMODE(m$))) {
      //<< write "window.onerror=eventfehler;"  ;JAVASCRIPT ERRORHANDLER (INTERNET EXPLORER)
      m$.Cmd.Write("window.onerror=eventfehler;");
      //<< write "window.onError=eventfehler;"  ;JAVASCRIPT ERRORHANDLER (NETSCAPE)
      m$.Cmd.Write("window.onError=eventfehler;");
    }
    //<< }
    //<< 
    //<< write "function EventValue(Namespace,User,Form,Fixkey,Field,Value,Funct,LocalVar,Tab) {",YCR
    m$.Cmd.Write("function EventValue(Namespace,User,Form,Fixkey,Field,Value,Funct,LocalVar,Tab) {",m$.var("YCR").get());
    //<< 
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
    //<< if $get(YEVENT)=1 {  ;FUNKTION FÜR EVENTBROKER ;to
    if (mOp.Equal(m$.Fnc.$get(m$.var("YEVENT")),1)) {
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
    }
    //<< }
    //<< 
    //<< ;======================================= ^^^ vvv
    //<< 
    //<< ;; SR17253 vvv
    //<< ;write "function UpdateFieldFormat(pstrObject,pstrPropertyName,pstrValue) {"
    //<< ;write "   if (pstrValue=='true' || pstrValue=='false') {"
    //<< ;write "     pstrValue=pstrValue==""true""?true:false;"
    //<< ;write "   }"
    //<< ;write "   eval(pstrObject+'.'+pstrPropertyName+""='""+pstrValue+""'"");"
    //<< ;write "}"
    //<< 
    //<< ;SR17XXX
    //<< ;write "window.CSSHover=(function(){var m=/(^|\s)((([^a]([^ ]+)?)|(a([^#.][^ ]+)+)):(hover|active|focus))/i;var n=/(.*?)\:(hover|active|focus)/i;var o=/[^:]+:([a-z\-]+).*/i;var p=/(\.([a-z0-9_\-]+):[a-z]+)|(:[a-z]+)/gi;var q=/\.([a-z0-9_\-]*on(hover|active|focus))/i;var s=/msie (5|6|7)/i;var t=/backcompat/i;var u={index:0,list:['text-kashida','text-kashida-space','text-justify'],get:function(){return this.list[(this.index++)%this.list.length]}};var v=function(c){return c.replace(/-(.)/mg,function(a,b){return b.toUpperCase()})};var w={elements:[],callbacks:{},init:function(){if(!s.test(navigator.userAgent)&&!t.test(window.document.compatMode)){return}var a=window.document.styleSheets,l=a.length;for(var i=0;i<l;i++){this.parseStylesheet(a[i])}},parseStylesheet:function(a){if(a.imports){try{var b=a.imports;var l=b.length;for(var i=0;i<l;i++){this.parseStylesheet(a.imports[i])}}catch(securityException){}}try{var c=a.rules;var r=c.length;for(var j=0;j<r;j++){this.parseCSSRule(c[j],a)}}catch(someException){}},parseCSSRule:function(a,b){var c=a.selectorText;if(m.test(c)){var d=a.style.cssText;var e=n.exec(c)[1];var f=c.replace(o,'on$1');var g=c.replace(p,'.$2'+f);var h=q.exec(g)[1];var i=e+h;if(!this.callbacks[i]){var j=u.get();var k=v(j);b.addRule(e,j+':expression(CSSHover(this, ""'+f+'"", ""'+h+'"", ""'+k+'""))');this.callbacks[i]=true}b.addRule(g,d)}},patch:function(a,b,c,d){try{var f=a.parentNode.currentStyle[d];a.style[d]=f}catch(e){a.runtimeStyle[d]=''}if(!a.csshover){a.csshover=[]}if(!a.csshover[c]){a.csshover[c]=true;var g=new CSSHoverElement(a,b,c);this.elements.push(g)}return b},unload:function(){try{var l=this.elements.length;for(var i=0;i<l;i++){this.elements[i].unload()}this.elements=[];this.callbacks={}}catch(e){}}};var x={onhover:{activator:'onmouseenter',deactivator:'onmouseleave'},onactive:{activator:'onmousedown',deactivator:'onmouseup'},onfocus:{activator:'onfocus',deactivator:'onblur'}};function CSSHoverElement(a,b,c){this.node=a;this.type=b;var d=new RegExp('(^|\\s)'+c+'(\\s|$)','g');this.activator=function(){a.className+=' '+c};this.deactivator=function(){a.className=a.className.replace(d,' ')};a.attachEvent(x[b].activator,this.activator);a.attachEvent(x[b].deactivator,this.deactivator)}CSSHoverElement.prototype={unload:function(){this.node.detachEvent(x[this.type].activator,this.activator);this.node.detachEvent(x[this.type].deactivator,this.deactivator);this.activator=null;this.deactivator=null;this.node=null;this.type=null}};window.attachEvent('onbeforeunload',function(){w.unload()});return function(a,b,c,d){if(a){return w.patch(a,b,c,d)}else{w.init()}}})();"
    //<< 
    //<< ;SR17784 vvvvvv
    //<< write "function getParent(el, pTagName) {",YCR
    m$.Cmd.Write("function getParent(el, pTagName) {",m$.var("YCR").get());
    //<< write " if (el == null) return null;",YCR
    m$.Cmd.Write(" if (el == null) return null;",m$.var("YCR").get());
    //<< write " else if (el.nodeType == 1 && el.tagName.toLowerCase() == pTagName.toLowerCase())"_" // Gecko bug, supposed to be uppercase",YCR
    m$.Cmd.Write(mOp.Concat(" else if (el.nodeType == 1 && el.tagName.toLowerCase() == pTagName.toLowerCase())"," // Gecko bug, supposed to be uppercase"),m$.var("YCR").get());
    //<< write "  return el;",YCR
    m$.Cmd.Write("  return el;",m$.var("YCR").get());
    //<< write " else",YCR
    m$.Cmd.Write(" else",m$.var("YCR").get());
    //<< write "  return getParent(el.parentNode, pTagName);",YCR
    m$.Cmd.Write("  return getParent(el.parentNode, pTagName);",m$.var("YCR").get());
    //<< write "}",YCR
    m$.Cmd.Write("}",m$.var("YCR").get());
    //<< ;SR17784 ^^^^^^^
    //<< 
    //<< ; SR17291 rewrite vvvvvv
    //<< write "function UpdateFieldFormat(pstrObject,pstrPropertyName,pstrValue) {"
    m$.Cmd.Write("function UpdateFieldFormat(pstrObject,pstrPropertyName,pstrValue) {");
    //<< write "  var arrObject=pstrObject.split('.');"
    m$.Cmd.Write("  var arrObject=pstrObject.split('.');");
    //<< write "  var intLength=arrObject.length;"
    m$.Cmd.Write("  var intLength=arrObject.length;");
    //<< write "  var strObjectName=arrObject[intLength-1];"
    m$.Cmd.Write("  var strObjectName=arrObject[intLength-1];");
    //<< write "  var strType='';"
    m$.Cmd.Write("  var strType='';");
    //<< write "  var strEval;"
    m$.Cmd.Write("  var strEval;");
    //<< write "  if (strObjectName=='style') {"
    m$.Cmd.Write("  if (strObjectName=='style') {");
    //<< write "    strType=strObjectName;"
    m$.Cmd.Write("    strType=strObjectName;");
    //<< write "    strObjectName=arrObject[intLength-2];"
    m$.Cmd.Write("    strObjectName=arrObject[intLength-2];");
    //<< write "  }"
    m$.Cmd.Write("  }");
    //<< write "  if (document.getElementById(strObjectName)) {"
    m$.Cmd.Write("  if (document.getElementById(strObjectName)) {");
    //<< write "    strEval='document.getElementById(""'+strObjectName+'"")';"
    m$.Cmd.Write("    strEval='document.getElementById(\"'+strObjectName+'\")';");
    //<< write "    if (strType!='') strEval=strEval+'.'+strType;"
    m$.Cmd.Write("    if (strType!='') strEval=strEval+'.'+strType;");
    //<< write "    strEval=strEval+'.'+pstrPropertyName;"
    m$.Cmd.Write("    strEval=strEval+'.'+pstrPropertyName;");
    //<< write "    eval(strEval+""='""+pstrValue+""'"");"
    m$.Cmd.Write("    eval(strEval+\"='\"+pstrValue+\"'\");");
    //<< write "  }"
    m$.Cmd.Write("  }");
    //<< write "}"
    m$.Cmd.Write("}");
    //<< 
    //<< ; SR17291 removed vvvvvv
    //<< ;write "function UpdateFieldFormat(pstrObject,pstrPropertyName,pstrValue) {"
    //<< ;write "  var arrObject=pstrObject.split('.');"
    //<< ;write "  var intLength=arrObject.length;"
    //<< ;write "  var strObjectName=arrObject[intLength-1];"
    //<< ;write "  var strType;"
    //<< ;write "  if (strObjectName=='style') {"
    //<< ;write "    strType=strObjectName;"
    //<< ;write "    strObjectName=arrObject[intLength-2];"
    //<< ;write "  }"
    //<< ;write "  var strOldProperty=pstrPropertyName+'old';"
    //<< ;write "  var objCurrent = document.getElementById(strObjectName);"
    //<< ;write "  if (objCurrent) {"
    //<< ;write "    if (strType) {"
    //<< ;write "      objCurrent=objCurrent.getAttribute(strType);"
    //<< ;write "    };"
    //<< ;write "    if (objCurrent) {"
    //<< ;write "      if (objCurrent.getAttribute(strOldProperty)==null) {"
    //<< ;write "        objCurrent.setAttribute(strOldProperty,objCurrent.getAttribute(pstrPropertyName));"
    //<< ;write "      }"
    //<< ;write "      if (pstrValue=='true' || pstrValue=='false') {"
    //<< ;write "        pstrValue=pstrValue==""true""?true:false;"
    //<< ;write "      }"
    //<< ;write "      objCurrent.setAttribute(pstrPropertyName,pstrValue);"
    //<< ;write "      if (pstrValue=='white') {pstrValue=''} ;"
    //<< ;;  write "      eval(pstrObject+'.'+pstrPropertyName+""='""+pstrValue+""'"");"
    //<< ;write "    }"
    //<< ;write "  }"
    //<< ;write "}"
    //<< ; SR17253 ^^^
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< write "function PrepareUpdate(pstrForm,pstrObjectName,pstrPropertyName,pstrValue) {"
    m$.Cmd.Write("function PrepareUpdate(pstrForm,pstrObjectName,pstrPropertyName,pstrValue) {");
    //<< write "  var objField=document.getElementById(pstrObjectName.split('.')[0]);"
    m$.Cmd.Write("  var objField=document.getElementById(pstrObjectName.split('.')[0]);");
    //<< write "  if (objField) {"
    m$.Cmd.Write("  if (objField) {");
    //<< write "    if (pstrValue=='true' || pstrValue=='false') {"
    m$.Cmd.Write("    if (pstrValue=='true' || pstrValue=='false') {");
    //<< write "      eval(objField+'.'+pstrPropertyName+'='+pstrValue==""true""?true:false);"
    m$.Cmd.Write("      eval(objField+'.'+pstrPropertyName+'='+pstrValue==\"true\"?true:false);");
    //<< 
    //<< ;   **** Work Around IE bug.  Something happening where setting the readOnly property
    //<< ;        on a text area control oesn't seem to work
    //<< write "      if (pstrPropertyName=='readOnly') {"
    m$.Cmd.Write("      if (pstrPropertyName=='readOnly') {");
    //<< write "        document.getElementById(objField.id).readOnly=(pstrValue==""true""?true:false);"  ;SR17518
    m$.Cmd.Write("        document.getElementById(objField.id).readOnly=(pstrValue==\"true\"?true:false);");
    //<< write "        if ((objField.type=='checkbox')||(objField.type=='select-one')) {"
    m$.Cmd.Write("        if ((objField.type=='checkbox')||(objField.type=='select-one')) {");
    //<< write "           objField.disabled=(pstrValue==""true""?true:false);"
    m$.Cmd.Write("           objField.disabled=(pstrValue==\"true\"?true:false);");
    //<< write "        } else if (objField.type=='textarea') {"
    m$.Cmd.Write("        } else if (objField.type=='textarea') {");
    //<< write "           objField.readOnly=(pstrValue==""true""?true:false);"
    m$.Cmd.Write("           objField.readOnly=(pstrValue==\"true\"?true:false);");
    //<< write "        }"
    m$.Cmd.Write("        }");
    //<< write "      }"
    m$.Cmd.Write("      }");
    //<< 
    //<< write "    } else {"
    m$.Cmd.Write("    } else {");
    //<< ; Why was the following commands put here?  It will give checkboxes a white halo.
    //<< ;write "      if (pstrPropertyName=='backgroundColor') {"
    //<< ;write "        if (pstrValue=='') {"
    //<< ;write "          pstrValue='white';"               ;SR17291
    //<< ;write "        }"
    //<< ;write "      }"
    //<< write "      UpdateFieldFormat('document.'+pstrForm+'.'+pstrObjectName,pstrPropertyName,pstrValue);"
    m$.Cmd.Write("      UpdateFieldFormat('document.'+pstrForm+'.'+pstrObjectName,pstrPropertyName,pstrValue);");
    //<< write "    }"
    m$.Cmd.Write("    }");
    //<< write "  }"
    m$.Cmd.Write("  }");
    //<< write "}"
    m$.Cmd.Write("}");
    //<< 
    //<< ;write "function PrepareUpdate(pstrForm,pstrObjectName,pstrPropertyName,pstrValue) {"
    //<< ;write "  var objField=document.getElementById(pstrObjectName.split('.')[0]);"
    //<< ;write "  if (objField) {"
    //<< ;write "    if (pstrValue=='true' || pstrValue=='false') {"
    //<< ;write "      objField.setAttribute(pstrPropertyName,pstrValue==""true""?true:false);"
    //<< ;;              **** Work Around IE bug.  Something happening where setting the readOnly property on a text area control
    //<< ;;              Doesn't seem to work
    //<< ;write "      if (pstrPropertyName=='readOnly') {"
    //<< ;write "        if ((objField.type=='checkbox')||(objField.type=='select-one')) {"
    //<< ;write "          objField.setAttribute('disabled',pstrValue==""true""?true:false);"
    //<< ;write "        } else if (objField.type=='textarea') {"
    //<< ;write "          objField.setAttribute('readOnly',pstrValue==""true""?true:false);"
    //<< ;write "        }"
    //<< ;write "      }"
    //<< ;write "    } else {"
    //<< ;write "      UpdateFieldFormat('document.'+pstrForm+'.'+pstrObjectName,pstrPropertyName,pstrValue);"
    //<< ;write "    }"
    //<< ;write "  }"
    //<< ;write "}"
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called by COMUtils with pstrObject = document."_YHTMFORM_"."_pstrObjectName
    //<< ; Other calls may differ.
    //<< ;-------------------------------------------------------------------------------
    //<< write !!,"function ResetFieldFormat(pstrObject,pstrPropertyName) {"
    m$.Cmd.Write("\n","\n","function ResetFieldFormat(pstrObject,pstrPropertyName) {");
    //<< write "  var arrObject=pstrObject.split('.');"
    m$.Cmd.Write("  var arrObject=pstrObject.split('.');");
    //<< write "  var intLength=arrObject.length;"
    m$.Cmd.Write("  var intLength=arrObject.length;");
    //<< write "  var strObjectName=arrObject[intLength-1];"
    m$.Cmd.Write("  var strObjectName=arrObject[intLength-1];");
    //<< write "  var strType;"
    m$.Cmd.Write("  var strType;");
    //<< 
    //<< write "  if (strObjectName=='style') {"
    m$.Cmd.Write("  if (strObjectName=='style') {");
    //<< write "    strType=strObjectName;"
    m$.Cmd.Write("    strType=strObjectName;");
    //<< write "    strObjectName=arrObject[intLength-2];"
    m$.Cmd.Write("    strObjectName=arrObject[intLength-2];");
    //<< write "  }"
    m$.Cmd.Write("  }");
    //<< 
    //<< write !,"  var strOldProperty=pstrPropertyName+'old';"
    m$.Cmd.Write("\n","  var strOldProperty=pstrPropertyName+'old';");
    //<< write !,"  var objCurrent = document.getElementById(strObjectName);"
    m$.Cmd.Write("\n","  var objCurrent = document.getElementById(strObjectName);");
    //<< write !,"  if (strType) {"
    m$.Cmd.Write("\n","  if (strType) {");
    //<< write "    objCurrent=objCurrent.getAttribute(strType);"
    m$.Cmd.Write("    objCurrent=objCurrent.getAttribute(strType);");
    //<< write "  };"
    m$.Cmd.Write("  };");
    //<< 
    //<< write !,"  if (objCurrent) {"
    m$.Cmd.Write("\n","  if (objCurrent) {");
    //<< write "    if (objCurrent.getAttribute(strOldProperty)!=null) {"
    m$.Cmd.Write("    if (objCurrent.getAttribute(strOldProperty)!=null) {");
    //<< write "       objCurrent.setAttribute(pstrPropertyName,objCurrent.getAttribute(strOldProperty));"
    m$.Cmd.Write("       objCurrent.setAttribute(pstrPropertyName,objCurrent.getAttribute(strOldProperty));");
    //<< write "    }"
    m$.Cmd.Write("    }");
    //<< write "  }"
    m$.Cmd.Write("  }");
    //<< write "}",!!
    m$.Cmd.Write("}","\n","\n");
    //<< 
    //<< 
    //<< ;write "function ResetFieldFormat(pstrObject,pstrPropertyName) {"
    //<< ;write "  if (eval('typeof '+pstrObject)!='undefined') { "
    //<< ;write "    var pstrPropertyName = pstrObject+'.'+pstrPropertyName; "
    //<< ;write "    var strOldProperty = pstrPropertyName+'old' ; "
    //<< ;write "    if (eval('typeof '+strOldProperty)!='undefined') { "
    //<< ;write "      eval(pstrPropertyName+' = '+strOldProperty);"
    //<< ;write "    } "
    //<< ;write "  } "
    //<< ;write "}"
    //<< 
    //<< ;======================================= ^^^ vvv
    //<< 
    //<< ; Function EventValue - alternative
    //<< if $get(YEVENT)'=1 {  ;FUNKTION Kein EVENTBROKER
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YEVENT")),1)) {
      //<< write "  retval = """";"
      m$.Cmd.Write("  retval = \"\";");
      //<< write "  return(retval);"
      m$.Cmd.Write("  return(retval);");
      //<< write "}"
      m$.Cmd.Write("}");
    }
    //<< }
    //<< 
    //<< ;======================================= ^^^
    //<< 
    //<< if YFORM="WWWCHAT" {
    if (mOp.Equal(m$.var("YFORM").get(),"WWWCHAT")) {
      //<< write "function chat() {"
      m$.Cmd.Write("function chat() {");
      //<< write "  retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"",""Y"_YFORM_"M1"","""_1_""","""_2_""",""NOVALUE"");"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX\",\"Y"),m$.var("YFORM").get()),"M1\",\""),1),"\",\""),2),"\",\"NOVALUE\");"));
      //<< write "  if (retval != """") document."_YHTMFORM_".Y"_YFORM_"M1.value = retval;"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  if (retval != \"\") document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),"M1.value = retval;"));
      //<< write "  window.setTimeout(""chat()"",10000);"
      m$.Cmd.Write("  window.setTimeout(\"chat()\",10000);");
      //<< write "}"
      m$.Cmd.Write("}");
    }
    //<< }
    //<< 
    //<< ;JAVASCRIPT ERROR HANDLER
    //<< write "function eventfehler(msg, url, line) {"
    m$.Cmd.Write("function eventfehler(msg, url, line) {");
    //<< if ($$$WWW012DisplayJavaScriptError($get(^WWW012(0,0,1)))=$$$YES) || (+$$^WWWBEDBER()=1) {
    if ((mOp.Equal(include.WWWConst.$$$WWW012DisplayJavaScriptError(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))),include.COMSYS.$$$YES(m$))) || (mOp.Equal(mOp.Positive(m$.fnc$("WWWBEDBER.main")),1))) {
      //<< ;   write "  if (navigator.appName.indexOf('Microsoft Internet Explorer') != -1)"  ;tybd;26,07,2004;26159;mozilla
      //<< write "  if (document.all) {"
      m$.Cmd.Write("  if (document.all) {");
      //<< write "    var code;"
      m$.Cmd.Write("    var code;");
      //<< ; INTERNAL ERROR - Make sure showing js errors doesn't cause an error.
      //<< write "    code="""_$$^WWWTEXT(387)_""";"                  ; "An INTERNAL Error Has Occurred In Your Application."
      m$.Cmd.Write(mOp.Concat(mOp.Concat("    code=\"",m$.fnc$("WWWTEXT.main",387)),"\";"));
      //<< write "    code+=""\n\n("_$$^WWWTEXT(179)_": ""+line;"     ; "Line"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("    code+=\"\\n\\n(",m$.fnc$("WWWTEXT.main",179)),": \"+line;"));
      //<< write "    code+="") ""+msg;"
      m$.Cmd.Write("    code+=\") \"+msg;");
      //<< ;   write "    code+=""\n\nUrl:\n""+url;"
      //<< write "    alert(code);"
      m$.Cmd.Write("    alert(code);");
      //<< write "  }"
      m$.Cmd.Write("  }");
    }
    //<< }
    //<< write "  return true;"
    m$.Cmd.Write("  return true;");
    //<< write "}"
    m$.Cmd.Write("}");
    //<< 
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< quit:$get(YEINSPRUNG)=1
    if (mOp.Equal(m$.Fnc.$get(m$.var("YEINSPRUNG")),1)) {
      return;
    }
    //<< 
    //<< if $$SR16427^WWWFORMJavascript() {
    if (mOp.Logical(m$.fnc$("WWWFORMJavascript.SR16427"))) {
      //<< write $$Cspxml^WWWFORMJavascript(YQUERY)
      m$.Cmd.Write(m$.fnc$("WWWFORMJavascript.Cspxml",m$.var("YQUERY").get()));
    }
    //<< 
    //<< } else {
    else {
      //<< if $get(%(YQUERY,"XMLHTTPREQ"))=1 {
      if (mOp.Equal(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"XMLHTTPREQ")),1)) {
        //<< if +$get(^SysSetup("FieldEvents")) {
        if (mOp.Logical(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","FieldEvents"))))) {
          //<< write "<script type='text/javascript' src=""/cspxmlhttp.js""></script>"
          m$.Cmd.Write("<script type='text/javascript' src=\"/cspxmlhttp.js\"></script>");
        }
        //<< } else {
        else {
          //<< write "<script type='text/javascript' src=""/csp/broker/cspxmlhttp.js""></script>"
          m$.Cmd.Write("<script type='text/javascript' src=\"/csp/broker/cspxmlhttp.js\"></script>");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< do JSLibraries()
    m$.Cmd.Do("JSLibraries");
    //<< 
    //<< if $get(YHYPER)=1 {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YHYPER")),1)) {
      //<< write "<SCRIPT LANGUAGE=JavaScript SRC=""/csp/broker/cspbroker.js""></SCRIPT>"
      m$.Cmd.Write("<SCRIPT LANGUAGE=JavaScript SRC=\"/csp/broker/cspbroker.js\"></SCRIPT>");
    }
    //<< }
    //<< 
    //<< if ($piece($get(^COMViewConfig(0,0,1)),Y,9)=1) && '$get(YTIMEFORM) {
    if ((mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^COMViewConfig",0,0,1)),m$.var("Y").get(),9),1)) && mOp.Not(m$.Fnc.$get(m$.var("YTIMEFORM")))) {
      //<< do Setup^COMViewSetup()
      m$.Cmd.Do("COMViewSetup.Setup");
    }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< ;IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* JAVASCRIPT (WWWFORM8)************************* -->",YCR,YCR
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< 
    //<< ; Popup Menu - set at either the system or the user level
    //<< ;---------------------------------------
    //<< ; FIXME : are we unable to over-ride a system POPUP setting with some other user setting?
    //<< 
    //<< if $$$WWW012MenuType($get(^WWW012(0,0,1)))=7 {   ; System setting
    if (mOp.Equal(include.WWWConst.$$$WWW012MenuType(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))),7)) {
      //<< write "function formHandler(form) {"
      m$.Cmd.Write("function formHandler(form) {");
      //<< write "  var URL = document.WWW.site.options[document.WWW.site.selectedIndex].value;"
      m$.Cmd.Write("  var URL = document.WWW.site.options[document.WWW.site.selectedIndex].value;");
      //<< write "  if (URL != """") window.location.href = URL;"
      m$.Cmd.Write("  if (URL != \"\") window.location.href = URL;");
      //<< write "}"
      m$.Cmd.Write("}");
    }
    //<< 
    //<< } elseif ($get(YBED)'="") && (+$$$WWW013MenuType($get(^WWW013(0,YBED,1)))=7) {   ; User setting
    else if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) && (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW013MenuType(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)))),7))) {
      //<< write "function formHandler(form) {"
      m$.Cmd.Write("function formHandler(form) {");
      //<< write "  var URL = document.WWW.site.options[document.WWW.site.selectedIndex].value;"
      m$.Cmd.Write("  var URL = document.WWW.site.options[document.WWW.site.selectedIndex].value;");
      //<< write "  if (URL != """") window.location.href = URL;"
      m$.Cmd.Write("  if (URL != \"\") window.location.href = URL;");
      //<< write "}"
      m$.Cmd.Write("}");
    }
    //<< }
    //<< 
    //<< if $get(YFORM)="" $$$EndScript() quit                             ; *** EARLY EXIT ***
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"")) {
      include.COMSYS.$$$EndScript(m$);
      return;
    }
    //<< 
    //<< ; JavaScript in Meta-data
    //<< ;---------------------------------------
    //<< 
    //<< ;FUNKTIONEN AUS DEN PRIMÄRSCHLÜSSELFELDERN ;out of
    //<< set YLF = ""
    mVar YLF = m$.var("YLF");
    YLF.set("");
    //<< for  set YLF = $order(^WWW129(0,YFORM,YLF)) quit:YLF=""  do
    for (;true;) {
      YLF.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get())));
      if (mOp.Equal(YLF.get(),"")) {
        break;
      }
      //<< . set YON=""
      mVar YON = m$.var("YON");
      YON.set("");
      //<< . for  set YON = $order(^WWW129(0,YFORM,YLF,YON)) quit:YON=""  do
      for (;true;) {
        YON.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get(),YON.get())));
        if (mOp.Equal(YON.get(),"")) {
          break;
        }
        //<< . . set YFU=""
        mVar YFU = m$.var("YFU");
        YFU.set("");
        //<< . . for  set YFU = $order(^WWW129(0,YFORM,YLF,YON,YFU)) quit:YFU=""  do
        for (;true;) {
          YFU.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get(),YON.get(),YFU.get())));
          if (mOp.Equal(YFU.get(),"")) {
            break;
          }
          //<< . . . set YTX = $piece($$^WWWSETL("^WWW129(0,"""_YFORM_""","""_YLF_""","""_YON_""","""_YFU_""",1)"),Y,1)
          mVar YTX = m$.var("YTX");
          YTX.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW129(0,\"",m$.var("YFORM").get()),"\",\""),YLF.get()),"\",\""),YON.get()),"\",\""),YFU.get()),"\",1)")),m$.var("Y").get(),1));
          //<< . . . if $translate(YTX,"| ")'="" do
          if (mOp.NotEqual(m$.Fnc.$translate(YTX.get(),"| "),"")) {
            do {
              //<< . . . . write "function "_$piece(YFU,".",1)_"("_$translate($piece(YFU,".",2,99),".",",")_")"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("function ",m$.Fnc.$piece(YFU.get(),".",1)),"("),m$.Fnc.$translate(m$.Fnc.$piece(YFU.get(),".",2,99),".",",")),")"));
              //<< . . . . write " {"
              m$.Cmd.Write(" {");
              //<< . . . . if $extract(YTX,1,3)="D ^" set YTX = $translate(YTX,"|") xecute YTX write "    }" quit
              if (mOp.Equal(m$.Fnc.$extract(YTX.get(),1,3),"D ^")) {
                YTX.set(m$.Fnc.$translate(YTX.get(),"|"));
                m$.Cmd.Xecute(YTX.get());
                m$.Cmd.Write("    }");
                break;
              }
              //<< . . . . for YI=1:1 set YTX1 = $piece(YTX,"|",YI) quit:$piece(YTX,"|",YI,99999)=""  do
              mVar YI = m$.var("YI");
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                mVar YTX1 = m$.var("YTX1");
                YTX1.set(m$.Fnc.$piece(YTX.get(),"|",YI.get()));
                if (mOp.Equal(m$.Fnc.$piece(YTX.get(),"|",YI.get(),99999),"")) {
                  break;
                }
                do {
                  //<< . . . . . quit:$translate(YTX1," ")=""
                  if (mOp.Equal(m$.Fnc.$translate(YTX1.get()," "),"")) {
                    break;
                  }
                  //<< . . . . . write "   "_$translate(YTX1,Y,";")
                  m$.Cmd.Write(mOp.Concat("   ",m$.Fnc.$translate(YTX1.get(),m$.var("Y").get(),";")));
                } while (false);
              }
              //<< . . . . ;
              //<< . . . . write " }"
              m$.Cmd.Write(" }");
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< ;FUNKTIONEN AUS DEN DATENFELDER ;out of
    //<< set YLF = ""
    YLF.set("");
    //<< for  set YLF = $order(^WWW1291(0,YFORM,YLF)) quit:YLF=""  do
    for (;true;) {
      YLF.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get())));
      if (mOp.Equal(YLF.get(),"")) {
        break;
      }
      //<< . set YON = ""
      mVar YON = m$.var("YON");
      YON.set("");
      //<< . for  set YON = $order(^WWW1291(0,YFORM,YLF,YON)) quit:YON=""  do
      for (;true;) {
        YON.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get(),YON.get())));
        if (mOp.Equal(YON.get(),"")) {
          break;
        }
        //<< . . set YFU = ""
        mVar YFU = m$.var("YFU");
        YFU.set("");
        //<< . . for  set YFU = $order(^WWW1291(0,YFORM,YLF,YON,YFU)) quit:YFU=""  do
        for (;true;) {
          YFU.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get(),YON.get(),YFU.get())));
          if (mOp.Equal(YFU.get(),"")) {
            break;
          }
          //<< . . . set YTX = $piece($$^WWWSETL("^WWW1291(0,"""_YFORM_""","""_YLF_""","""_YON_""","""_YFU_""",1)"),Y,1)
          mVar YTX = m$.var("YTX");
          YTX.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW1291(0,\"",m$.var("YFORM").get()),"\",\""),YLF.get()),"\",\""),YON.get()),"\",\""),YFU.get()),"\",1)")),m$.var("Y").get(),1));
          //<< . . . if $translate(YTX,"| ")'="" do
          if (mOp.NotEqual(m$.Fnc.$translate(YTX.get(),"| "),"")) {
            do {
              //<< . . . . write "function "_$piece(YFU,".",1)_"("_$translate($piece(YFU,".",2,99),".",",")_")"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("function ",m$.Fnc.$piece(YFU.get(),".",1)),"("),m$.Fnc.$translate(m$.Fnc.$piece(YFU.get(),".",2,99),".",",")),")"));
              //<< . . . . write " {"
              m$.Cmd.Write(" {");
              //<< . . . . if $extract(YTX,1,3)="D ^" set YTX = $translate(YTX,"|"," ") xecute YTX write "    }" quit    ; if/else
              if (mOp.Equal(m$.Fnc.$extract(YTX.get(),1,3),"D ^")) {
                YTX.set(m$.Fnc.$translate(YTX.get(),"|"," "));
                m$.Cmd.Xecute(YTX.get());
                m$.Cmd.Write("    }");
                break;
              }
              //<< . . . . for YI=1:1 set YTX1 = $piece(YTX,"|",YI) quit:$piece(YTX,"|",YI,99999)=""  do
              mVar YI = m$.var("YI");
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                mVar YTX1 = m$.var("YTX1");
                YTX1.set(m$.Fnc.$piece(YTX.get(),"|",YI.get()));
                if (mOp.Equal(m$.Fnc.$piece(YTX.get(),"|",YI.get(),99999),"")) {
                  break;
                }
                do {
                  //<< . . . . . quit:$translate(YTX1," ")=""
                  if (mOp.Equal(m$.Fnc.$translate(YTX1.get()," "),"")) {
                    break;
                  }
                  //<< . . . . . write "  "_$translate(YTX1,Y,";")
                  m$.Cmd.Write(mOp.Concat("  ",m$.Fnc.$translate(YTX1.get(),m$.var("Y").get(),";")));
                } while (false);
              }
              //<< . . . . ;
              //<< . . . . write " }"
              m$.Cmd.Write(" }");
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< write "<SCRIPT LANGUAGE=VBScript>"
    m$.Cmd.Write("<SCRIPT LANGUAGE=VBScript>");
    //<< write "<!--"
    m$.Cmd.Write("<!--");
    //<< 
    //<< ;VB AUS PRIMÄRSCHLÜSSELN ;out of
    //<< set YLF = ""
    YLF.set("");
    //<< for  set YLF = $order(^WWW129(0,YFORM,YLF)) quit:YLF=""  do
    for (;true;) {
      YLF.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get())));
      if (mOp.Equal(YLF.get(),"")) {
        break;
      }
      //<< . set YON = ""
      mVar YON = m$.var("YON");
      YON.set("");
      //<< . for  set YON = $order(^WWW129(0,YFORM,YLF,YON)) quit:YON=""  do
      for (;true;) {
        YON.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get(),YON.get())));
        if (mOp.Equal(YON.get(),"")) {
          break;
        }
        //<< . . set YFU = ""
        mVar YFU = m$.var("YFU");
        YFU.set("");
        //<< . . for  set YFU = $order(^WWW129(0,YFORM,YLF,YON,YFU)) quit:YFU=""  do
        for (;true;) {
          YFU.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get(),YON.get(),YFU.get())));
          if (mOp.Equal(YFU.get(),"")) {
            break;
          }
          //<< . . . set YTX = $piece($$^WWWSETL("^WWW129(0,"""_YFORM_""","""_YLF_""","""_YON_""","""_YFU_""",1)"),Y,2)
          mVar YTX = m$.var("YTX");
          YTX.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW129(0,\"",m$.var("YFORM").get()),"\",\""),YLF.get()),"\",\""),YON.get()),"\",\""),YFU.get()),"\",1)")),m$.var("Y").get(),2));
          //<< . . . if $translate(YTX,"| ")'="" do
          if (mOp.NotEqual(m$.Fnc.$translate(YTX.get(),"| "),"")) {
            do {
              //<< . . . . write " function "_$piece(YFU,".",1)_"("_$translate($piece(YFU,".",2,99),".",",")_")"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" function ",m$.Fnc.$piece(YFU.get(),".",1)),"("),m$.Fnc.$translate(m$.Fnc.$piece(YFU.get(),".",2,99),".",",")),")"));
              //<< . . . . if $extract(YTX,1,3)="D ^" set YTX = $translate(YTX,"|"," ") xecute YTX quit
              if (mOp.Equal(m$.Fnc.$extract(YTX.get(),1,3),"D ^")) {
                YTX.set(m$.Fnc.$translate(YTX.get(),"|"," "));
                m$.Cmd.Xecute(YTX.get());
                break;
              }
              //<< . . . . for YI=1:1 set YTX1 = $piece(YTX,"|",YI) quit:$piece(YTX,"|",YI,99999)=""  do
              mVar YI = m$.var("YI");
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                mVar YTX1 = m$.var("YTX1");
                YTX1.set(m$.Fnc.$piece(YTX.get(),"|",YI.get()));
                if (mOp.Equal(m$.Fnc.$piece(YTX.get(),"|",YI.get(),99999),"")) {
                  break;
                }
                do {
                  //<< . . . . . quit:$translate(YTX1," ")=""
                  if (mOp.Equal(m$.Fnc.$translate(YTX1.get()," "),"")) {
                    break;
                  }
                  //<< . . . . . write " "_$translate(YTX1,Y,";")
                  m$.Cmd.Write(mOp.Concat(" ",m$.Fnc.$translate(YTX1.get(),m$.var("Y").get(),";")));
                } while (false);
              }
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< ;VB AUS DATENFELDERN ;out of
    //<< set YLF = ""
    YLF.set("");
    //<< for  set YLF = $order(^WWW1291(0,YFORM,YLF)) quit:YLF=""  do
    for (;true;) {
      YLF.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get())));
      if (mOp.Equal(YLF.get(),"")) {
        break;
      }
      //<< . set YON = ""
      mVar YON = m$.var("YON");
      YON.set("");
      //<< . for  set YON = $order(^WWW1291(0,YFORM,YLF,YON)) quit:YON=""  do
      for (;true;) {
        YON.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get(),YON.get())));
        if (mOp.Equal(YON.get(),"")) {
          break;
        }
        //<< . . set YFU = ""
        mVar YFU = m$.var("YFU");
        YFU.set("");
        //<< . . for  set YFU = $order(^WWW1291(0,YFORM,YLF,YON,YFU)) quit:YFU=""  do
        for (;true;) {
          YFU.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get(),YON.get(),YFU.get())));
          if (mOp.Equal(YFU.get(),"")) {
            break;
          }
          //<< . . . set YTX = $piece($$^WWWSETL("^WWW1291(0,"""_YFORM_""","""_YLF_""","""_YON_""","""_YFU_""",1)"),Y,2)
          mVar YTX = m$.var("YTX");
          YTX.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW1291(0,\"",m$.var("YFORM").get()),"\",\""),YLF.get()),"\",\""),YON.get()),"\",\""),YFU.get()),"\",1)")),m$.var("Y").get(),2));
          //<< . . . if $translate(YTX,"| ")'="" do
          if (mOp.NotEqual(m$.Fnc.$translate(YTX.get(),"| "),"")) {
            do {
              //<< . . . . write " function "_$piece(YFU,".",1)_"("_$translate($piece(YFU,".",2,99),".",",")_")"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" function ",m$.Fnc.$piece(YFU.get(),".",1)),"("),m$.Fnc.$translate(m$.Fnc.$piece(YFU.get(),".",2,99),".",",")),")"));
              //<< . . . . if $extract(YTX,1,3)="D ^" set YTX = $translate(YTX,"|"," ") xecute YTX quit
              if (mOp.Equal(m$.Fnc.$extract(YTX.get(),1,3),"D ^")) {
                YTX.set(m$.Fnc.$translate(YTX.get(),"|"," "));
                m$.Cmd.Xecute(YTX.get());
                break;
              }
              //<< . . . . for YI=1:1 set YTX1 = $piece(YTX,"|",YI) quit:$piece(YTX,"|",YI,99999)=""  do
              mVar YI = m$.var("YI");
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                mVar YTX1 = m$.var("YTX1");
                YTX1.set(m$.Fnc.$piece(YTX.get(),"|",YI.get()));
                if (mOp.Equal(m$.Fnc.$piece(YTX.get(),"|",YI.get(),99999),"")) {
                  break;
                }
                do {
                  //<< . . . . . quit:$translate(YTX1," ")=""
                  if (mOp.Equal(m$.Fnc.$translate(YTX1.get()," "),"")) {
                    break;
                  }
                  //<< . . . . . write "  "_$translate(YTX1,Y,";")
                  m$.Cmd.Write(mOp.Concat("  ",m$.Fnc.$translate(YTX1.get(),m$.var("Y").get(),";")));
                } while (false);
              }
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< write "//-->"
    m$.Cmd.Write("//-->");
    //<< write "</SCRIPT>"
    m$.Cmd.Write("</SCRIPT>");
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< OldEVENTCALL  ; preserved for SR17286
  public void OldEVENTCALL() {
    do {
      //<< do
      //<< . $$$StartScript()
      include.COMSYS.$$$StartScript(m$);
      //<< . ;
      //<< . if '$$$DEVMODE do
      if (mOp.Not(include.COMSYS.$$$DEVMODE(m$))) {
        //<< . . write "window.onerror=eventfehler;"  ;FIS:31.10.03;JAVASCRIPT ERRORHANDLER (INTERNET EXPLORER)
        m$.Cmd.Write("window.onerror=eventfehler;");
        //<< . . write "window.onError=eventfehler;"  ;FIS:31.10.03;JAVASCRIPT ERRORHANDLER (NETSCAPE)
        m$.Cmd.Write("window.onError=eventfehler;");
      }
      //<< . ;
      //<< . write "function EventValue(Namespace,User,Form,Fixkey,Field,Value,Funct,LocalVar,Tab)" ; SRBR014066
      m$.Cmd.Write("function EventValue(Namespace,User,Form,Fixkey,Field,Value,Funct,LocalVar,Tab)");
      //<< . if $get(YEVENT)=1 do  ;FUNKTION FÜR EVENTBROKER ;to
      if (mOp.Equal(m$.Fnc.$get(m$.var("YEVENT")),1)) {
        //<< . . write "  { "
        m$.Cmd.Write("  { ");
        //<< . . write YCR,"   var retval;" ; 16751
        m$.Cmd.Write(m$.var("YCR").get(),"   var retval;");
        //<< . . if $find($zversion,"Windows") do           ;NUR FÜR WINDOWS NICHT FÜR LINUX;TYBD;23.08.2003 ;only to Not to LINUX
        if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$zversion(),"Windows"))) {
          //<< . . . write "   var von = /"_$char(128)_"/g;"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("   var von = /",m$.Fnc.$char(128)),"/g;"));
          //<< . . . write "   var nach = ""&euro;"";"        ; euro in eurozeichen umwandeln bei csp
          m$.Cmd.Write("   var nach = \"&euro;\";");
          //<< . . . write "   if (Value != false) { if (Value != true) Value=Value.replace(von,nach);}"
          m$.Cmd.Write("   if (Value != false) { if (Value != true) Value=Value.replace(von,nach);}");
        }
        //<< . . ;
        //<< . . if +$get(YHYPER)=0 do  ;eventbroker
        if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),0)) {
          //<< . . . write "   retval = document.WebLink.CacheMethod("""_$get(%KEY("MGWCHD"))_""", Namespace + ""."" + User + ""."" + Form + ""."" + Field + ""."" + Funct + ""."" + Fixkey + ""."" + LocalVar, Value);"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("   retval = document.WebLink.CacheMethod(\"",m$.Fnc.$get(m$.var("%KEY","MGWCHD"))),"\", Namespace + \".\" + User + \".\" + Form + \".\" + Field + \".\" + Funct + \".\" + Fixkey + \".\" + LocalVar, Value);"));
        }
        //<< . . ;
        //<< . . if +$get(YHYPER)=1 do  ;IF '$FIND($ZVERSION,"4.0") DO  ;HyperEvent neu
        if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),1)) {
          //<< . . . write "   Para=Namespace + ""."" + User + ""."" + Form + ""."" + Field + ""."" + Funct + ""."" + Fixkey + ""."" + LocalVar ;"
          m$.Cmd.Write("   Para=Namespace + \".\" + User + \".\" + Form + \".\" + Field + \".\" + Funct + \".\" + Fixkey + \".\" + LocalVar ;");
          //<< . . . write "   retval = "_$get(%(YQUERY,"HYPER"))_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("   retval = ",m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"HYPER"))),";"));
        }
        //<< . . ;
        //<< . . ;       //SR14939
        //<< . . write "   if (retval != null) { "
        m$.Cmd.Write("   if (retval != null) { ");
        //<< . . write "     retval=retval.replace(/'/g,String.fromCharCode(10,13));"
        m$.Cmd.Write("     retval=retval.replace(/'/g,String.fromCharCode(10,13));");
        //<< . . write "     retval=retval.replace(/`/g,'\'');"
        m$.Cmd.Write("     retval=retval.replace(/`/g,'\\'');");
        //<< . . write " } "
        m$.Cmd.Write(" } ");
        //<< . . ;
        //<< . . write "   var htmform = '"_YHTMFORM_"';"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("   var htmform = '",m$.var("YHTMFORM").get()),"';"));
        //<< . . write "   if (retval != null) retval=retvalcheck(retval,Value,Funct,Field,htmform);"
        m$.Cmd.Write("   if (retval != null) retval=retvalcheck(retval,Value,Funct,Field,htmform);");
        //<< . . write "   return(retval);"
        m$.Cmd.Write("   return(retval);");
        //<< . . write "  }"
        m$.Cmd.Write("  }");
      }
      //<< . ;
      //<< . // SR15513
      //<< . if 1 do
      if (mOp.Logical(1)) {
        //<< . . write "function UpdateFieldFormat(pstrObject,pstrPropertyName,pstrValue) {"
        m$.Cmd.Write("function UpdateFieldFormat(pstrObject,pstrPropertyName,pstrValue) {");
        //<< . . write " var arrObject=pstrObject.split('.');"
        m$.Cmd.Write(" var arrObject=pstrObject.split('.');");
        //<< . . write " var intLength=arrObject.length;"
        m$.Cmd.Write(" var intLength=arrObject.length;");
        //<< . . write " var strObjectName=arrObject[intLength-1];"
        m$.Cmd.Write(" var strObjectName=arrObject[intLength-1];");
        //<< . . write " var strType;"
        m$.Cmd.Write(" var strType;");
        //<< . . write " if (strObjectName=='style') {"
        m$.Cmd.Write(" if (strObjectName=='style') {");
        //<< . . write "  strType=strObjectName;"
        m$.Cmd.Write("  strType=strObjectName;");
        //<< . . write "  strObjectName=arrObject[intLength-2];"
        m$.Cmd.Write("  strObjectName=arrObject[intLength-2];");
        //<< . . write " }"
        m$.Cmd.Write(" }");
        //<< . . write " var strOldProperty=pstrPropertyName+'old';"
        m$.Cmd.Write(" var strOldProperty=pstrPropertyName+'old';");
        //<< . . write " var objCurrent = document.getElementById(strObjectName);"
        m$.Cmd.Write(" var objCurrent = document.getElementById(strObjectName);");
        //<< . . write " if (objCurrent) {"
        m$.Cmd.Write(" if (objCurrent) {");
        //<< . . write "  if (strType) {"
        m$.Cmd.Write("  if (strType) {");
        //<< . . write "   objCurrent=objCurrent.getAttribute(strType);"
        m$.Cmd.Write("   objCurrent=objCurrent.getAttribute(strType);");
        //<< . . write "  };"
        m$.Cmd.Write("  };");
        //<< . . write "  if (objCurrent) {"
        m$.Cmd.Write("  if (objCurrent) {");
        //<< . . write "   if (objCurrent.getAttribute(strOldProperty)==null) {"
        m$.Cmd.Write("   if (objCurrent.getAttribute(strOldProperty)==null) {");
        //<< . . write "    objCurrent.setAttribute(strOldProperty,objCurrent.getAttribute(pstrPropertyName));"
        m$.Cmd.Write("    objCurrent.setAttribute(strOldProperty,objCurrent.getAttribute(pstrPropertyName));");
        //<< . . write "   }"
        m$.Cmd.Write("   }");
        //<< . . write "   if (pstrValue=='true' || pstrValue=='false') {"
        m$.Cmd.Write("   if (pstrValue=='true' || pstrValue=='false') {");
        //<< . . write "    pstrValue=pstrValue==""true""?true:false;"
        m$.Cmd.Write("    pstrValue=pstrValue==\"true\"?true:false;");
        //<< . . write "   }"
        m$.Cmd.Write("   }");
        //<< . . write "   objCurrent.setAttribute(pstrPropertyName,pstrValue);"
        m$.Cmd.Write("   objCurrent.setAttribute(pstrPropertyName,pstrValue);");
        //<< . . write "    if (pstrValue=='white') {pstrValue=''} ;"
        m$.Cmd.Write("    if (pstrValue=='white') {pstrValue=''} ;");
        //<< . .;write "    eval(pstrObject+'.'+pstrPropertyName+""='""+pstrValue+""'"");"
        //<< . . write "  }"
        m$.Cmd.Write("  }");
        //<< . . write " }"
        m$.Cmd.Write(" }");
        //<< . . write "}"
        m$.Cmd.Write("}");
      }
      //<< . ;
      //<< . ;write "function UpdateFieldFormat(pstrObject,pstrPropertyName,pstrValue) {"
      //<< . ;write "  var pstrPropertyName = pstrObject+'.'+pstrPropertyName; "
      //<< . ;write "  var strOldProperty = pstrPropertyName+'old' ; "
      //<< . ;write "  if (eval('typeof '+pstrPropertyName)!='undefined') {"
      //<< . ;write "      if (eval('typeof '+strOldProperty)=='undefined') {"
      //<< . ;write "          eval(strOldProperty+' = '+pstrPropertyName); "
      //<< . ;write "      } "
      //<< . ;write "  } "
      //<< . ;write "  eval(pstrPropertyName+"" = '""+pstrValue+""'"");"
      //<< . ;write "}"
      //<< . ;
      //<< . // SRBR014310
      //<< . write "function PrepareUpdate(pstrForm,pstrObjectName,pstrPropertyName,pstrValue)"
      m$.Cmd.Write("function PrepareUpdate(pstrForm,pstrObjectName,pstrPropertyName,pstrValue)");
      //<< . write "{"
      m$.Cmd.Write("{");
      //<< . write "   var objField=document.getElementById(pstrObjectName.split('.')[0]);"
      m$.Cmd.Write("   var objField=document.getElementById(pstrObjectName.split('.')[0]);");
      //<< . write "   if (objField) {"
      m$.Cmd.Write("   if (objField) {");
      //<< . write "       if (pstrValue=='true' || pstrValue=='false') {"
      m$.Cmd.Write("       if (pstrValue=='true' || pstrValue=='false') {");
      //<< . write "           objField.setAttribute(pstrPropertyName,pstrValue==""true""?true:false);"
      m$.Cmd.Write("           objField.setAttribute(pstrPropertyName,pstrValue==\"true\"?true:false);");
      //<< . ; vvv BR014409 ;BR014721
      //<< . ;                 **** Work Around IE bug.  Something happening where setting the readOnly property on a text area control
      //<< . ;                 Doesn't seem to work
      //<< . write "           if (pstrPropertyName=='readOnly') {"
      m$.Cmd.Write("           if (pstrPropertyName=='readOnly') {");
      //<< . write "               if ((objField.type=='checkbox')||(objField.type=='select-one')) {"
      m$.Cmd.Write("               if ((objField.type=='checkbox')||(objField.type=='select-one')) {");
      //<< . write "                   objField.setAttribute('disabled',pstrValue==""true""?true:false);"
      m$.Cmd.Write("                   objField.setAttribute('disabled',pstrValue==\"true\"?true:false);");
      //<< . write "               } else if (objField.type=='textarea') {"
      m$.Cmd.Write("               } else if (objField.type=='textarea') {");
      //<< . write "                   objField.setAttribute('readOnly',pstrValue==""true""?true:false);"
      m$.Cmd.Write("                   objField.setAttribute('readOnly',pstrValue==\"true\"?true:false);");
      //<< . write "               }"
      m$.Cmd.Write("               }");
      //<< . write "           }"
      m$.Cmd.Write("           }");
      //<< . ; ^^^ BR014409  ;BR014721
      //<< . write "       } else {"
      m$.Cmd.Write("       } else {");
      //<< . write "           UpdateFieldFormat('document.'+pstrForm+'.'+pstrObjectName,pstrPropertyName,pstrValue);"
      m$.Cmd.Write("           UpdateFieldFormat('document.'+pstrForm+'.'+pstrObjectName,pstrPropertyName,pstrValue);");
      //<< . write "       }"
      m$.Cmd.Write("       }");
      //<< . write "   }"
      m$.Cmd.Write("   }");
      //<< . write "}"
      m$.Cmd.Write("}");
      //<< . ;
      //<< . // SR15513
      //<< . write "function ResetFieldFormat(pstrObject,pstrPropertyName) {"
      m$.Cmd.Write("function ResetFieldFormat(pstrObject,pstrPropertyName) {");
      //<< . write " var arrObject=pstrObject.split('.');"
      m$.Cmd.Write(" var arrObject=pstrObject.split('.');");
      //<< . write " var intLength=arrObject.length;"
      m$.Cmd.Write(" var intLength=arrObject.length;");
      //<< . write " var strObjectName=arrObject[intLength-1];"
      m$.Cmd.Write(" var strObjectName=arrObject[intLength-1];");
      //<< . write " var strType;"
      m$.Cmd.Write(" var strType;");
      //<< . write " if (strObjectName=='style') {"
      m$.Cmd.Write(" if (strObjectName=='style') {");
      //<< . write "  strType=strObjectName;"
      m$.Cmd.Write("  strType=strObjectName;");
      //<< . write "  strObjectName=arrObject[intLength-2];"
      m$.Cmd.Write("  strObjectName=arrObject[intLength-2];");
      //<< . write " }"
      m$.Cmd.Write(" }");
      //<< . write " var strOldProperty=pstrPropertyName+'old';"
      m$.Cmd.Write(" var strOldProperty=pstrPropertyName+'old';");
      //<< . write " var objCurrent = document.getElementById(strObjectName);"
      m$.Cmd.Write(" var objCurrent = document.getElementById(strObjectName);");
      //<< . write " if (strType) {"
      m$.Cmd.Write(" if (strType) {");
      //<< . write "  objCurrent=objCurrent.getAttribute(strType);"
      m$.Cmd.Write("  objCurrent=objCurrent.getAttribute(strType);");
      //<< . write " };"
      m$.Cmd.Write(" };");
      //<< . write " if (objCurrent) {"
      m$.Cmd.Write(" if (objCurrent) {");
      //<< . write "  if (objCurrent.getAttribute(strOldProperty)!=null) {"
      m$.Cmd.Write("  if (objCurrent.getAttribute(strOldProperty)!=null) {");
      //<< . write "   objCurrent.setAttribute(pstrPropertyName,objCurrent.getAttribute(strOldProperty));"
      m$.Cmd.Write("   objCurrent.setAttribute(pstrPropertyName,objCurrent.getAttribute(strOldProperty));");
      //<< . write "  }"
      m$.Cmd.Write("  }");
      //<< . write " }"
      m$.Cmd.Write(" }");
      //<< . write "}"
      m$.Cmd.Write("}");
      //<< . ;
      //<< . ;write "function ResetFieldFormat(pstrObject,pstrPropertyName) {"
      //<< . ;write "  if (eval('typeof '+pstrObject)!='undefined') { "
      //<< . ;write "  var pstrPropertyName = pstrObject+'.'+pstrPropertyName; "
      //<< . ;write "  var strOldProperty = pstrPropertyName+'old' ; "
      //<< . ;write "      if (eval('typeof '+strOldProperty)!='undefined') { "
      //<< . ;write "          eval(pstrPropertyName+' = '+strOldProperty);"
      //<< . ;write "      } "
      //<< . ;write "  } "
      //<< . ;write "}"
      //<< . ;
      //<< . if $get(YEVENT)'=1 do  ;FUNKTION Kein EVENTBROKER
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YEVENT")),1)) {
        //<< . . write "  {retval = """";"
        m$.Cmd.Write("  {retval = \"\";");
        //<< . . write "  return(retval);"
        m$.Cmd.Write("  return(retval);");
        //<< . . write "  }"
        m$.Cmd.Write("  }");
      }
      //<< . if YFORM="WWWCHAT" do
      if (mOp.Equal(m$.var("YFORM").get(),"WWWCHAT")) {
        //<< . . write "function chat()"
        m$.Cmd.Write("function chat()");
        //<< . . write " {"
        m$.Cmd.Write(" {");
        //<< . . write "   retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"",""Y"_YFORM_"M1"","""_1_""","""_2_""",""NOVALUE"");"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("   retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX\",\"Y"),m$.var("YFORM").get()),"M1\",\""),1),"\",\""),2),"\",\"NOVALUE\");"));
        //<< . . write "   if (retval != """") document."_YHTMFORM_".Y"_YFORM_"M1.value = retval;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("   if (retval != \"\") document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),"M1.value = retval;"));
        //<< . . write "   window.setTimeout(""chat()"",10000);"
        m$.Cmd.Write("   window.setTimeout(\"chat()\",10000);");
        //<< . . write " }"
        m$.Cmd.Write(" }");
      }
      //<< . ;
      //<< . do  ;FIS:31.10.03;JAVASCRIPT ERRORHANDLER
      do {
        //<< . . write "function eventfehler(msg, url, line)"
        m$.Cmd.Write("function eventfehler(msg, url, line)");
        //<< . . write " {"
        m$.Cmd.Write(" {");
        //<< . . if ($piece($get(^WWW012(0,0,1)),Y,146)=1) || (+$$^WWWBEDBER()=1)  do       ; $$$WWW012DisplayJavaScriptError
        if ((mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),m$.var("Y").get(),146),1)) || (mOp.Equal(mOp.Positive(m$.fnc$("WWWBEDBER.main")),1))) {
          //<< . . . ;WRITE " if (navigator.appName.indexOf('Microsoft Internet Explorer') != -1)"  ;tybd;26,07,2004;26159;mozilla
          //<< . . . write "  if (document.all)"
          m$.Cmd.Write("  if (document.all)");
          //<< . . . write "  {"
          m$.Cmd.Write("  {");
          //<< . . . write "   var code;"
          m$.Cmd.Write("   var code;");
          //<< . . . ;INTERNER FEHLER ;shortcoming // SR15508: Make sure showing js errors doesn't cause an error.
          //<< . . . write "   code="""_$$^WWWTEXT(387)_""";"                  ; "An INTERNAL Error Has Occurred In Your Application."
          m$.Cmd.Write(mOp.Concat(mOp.Concat("   code=\"",m$.fnc$("WWWTEXT.main",387)),"\";"));
          //<< . . . write "   code+=""\n\n("_$$^WWWTEXT(179)_": ""+line;"     ; "Line"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("   code+=\"\\n\\n(",m$.fnc$("WWWTEXT.main",179)),": \"+line;"));
          //<< . . . write "   code+="") ""+msg;"
          m$.Cmd.Write("   code+=\") \"+msg;");
          //<< . . . ;WRITE "   code+=""\n\nUrl:\n""+url;"
          //<< . . . write "   alert(code);"
          m$.Cmd.Write("   alert(code);");
          //<< . . . write "  }"
          m$.Cmd.Write("  }");
        }
        //<< . . write "   return true;"
        m$.Cmd.Write("   return true;");
        //<< . . write " }"
        m$.Cmd.Write(" }");
      } while(false);
      //<< . ;
      //<< . $$$EndScript()
      include.COMSYS.$$$EndScript(m$);
    } while(false);
    //<< 
    //<< 
    //<< quit:$get(YEINSPRUNG)=1
    if (mOp.Equal(m$.Fnc.$get(m$.var("YEINSPRUNG")),1)) {
      return;
    }
    //<< 
    //<< if $$SR16427^WWWFORMJavascript() {
    if (mOp.Logical(m$.fnc$("WWWFORMJavascript.SR16427"))) {
      //<< write $$Cspxml^WWWFORMJavascript(YQUERY)   ;SR16427
      m$.Cmd.Write(m$.fnc$("WWWFORMJavascript.Cspxml",m$.var("YQUERY").get()));
    }
    //<< 
    //<< } else {
    else {
      //<< if $get(%(YQUERY,"XMLHTTPREQ"))=1 {
      if (mOp.Equal(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"XMLHTTPREQ")),1)) {
        //<< if +$get(^SysSetup("FieldEvents")) {
        if (mOp.Logical(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","FieldEvents"))))) {
          //<< write "<script type='text/javascript' src=""/cspxmlhttp.js""></script>"
          m$.Cmd.Write("<script type='text/javascript' src=\"/cspxmlhttp.js\"></script>");
        }
        //<< } else {
        else {
          //<< write "<script type='text/javascript' src=""/csp/broker/cspxmlhttp.js""></script>"
          m$.Cmd.Write("<script type='text/javascript' src=\"/csp/broker/cspxmlhttp.js\"></script>");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< do JSLibraries()
    m$.Cmd.Do("JSLibraries");
    //<< 
    //<< if $get(YHYPER)=1 {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YHYPER")),1)) {
      //<< write "<SCRIPT LANGUAGE=JavaScript SRC=""/csp/broker/cspbroker.js""></SCRIPT>"
      m$.Cmd.Write("<SCRIPT LANGUAGE=JavaScript SRC=\"/csp/broker/cspbroker.js\"></SCRIPT>");
    }
    //<< }
    //<< 
    //<< if ($piece($get(^COMViewConfig(0,0,1)),Y,9)=1) && '$get(YTIMEFORM)  {
    if ((mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^COMViewConfig",0,0,1)),m$.var("Y").get(),9),1)) && mOp.Not(m$.Fnc.$get(m$.var("YTIMEFORM")))) {
      //<< do Setup^COMViewSetup()
      m$.Cmd.Do("COMViewSetup.Setup");
    }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< ;IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* JAVASCRIPT (WWWFORM8)************************* -->",YCR,YCR
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< 
    //<< if $piece($get(^WWW012(0,0,1)),Y,31)=7 do   ;POPUP MENU
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),m$.var("Y").get(),31),7)) {
      //<< . write "function formHandler(form)"
      m$.Cmd.Write("function formHandler(form)");
      //<< . write "{ "
      m$.Cmd.Write("{ ");
      //<< . write " {"
      m$.Cmd.Write(" {");
      //<< . write "  var URL = document.WWW.site.options[document.WWW.site.selectedIndex].value;"
      m$.Cmd.Write("  var URL = document.WWW.site.options[document.WWW.site.selectedIndex].value;");
      //<< . write "  if (URL != """") window.location.href = URL;"
      m$.Cmd.Write("  if (URL != \"\") window.location.href = URL;");
      //<< . write "  }"
      m$.Cmd.Write("  }");
      //<< . write "}"
      m$.Cmd.Write("}");
    }
    //<< 
    //<< ; FIXME : Should this only be within the else condition of the previous test?  <GRF>
    //<< 
    //<< if $get(YBED)'="" if +$piece($get(^WWW013(0,YBED,1)),Y,11)=7 do   ;POPUP MENU
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)),m$.var("Y").get(),11)),7)) {
        //<< . write "function formHandler(form)"
        m$.Cmd.Write("function formHandler(form)");
        //<< . write "{"
        m$.Cmd.Write("{");
        //<< . write "  {"
        m$.Cmd.Write("  {");
        //<< . write "  var URL = document.WWW.site.options[document.WWW.site.selectedIndex].value;"
        m$.Cmd.Write("  var URL = document.WWW.site.options[document.WWW.site.selectedIndex].value;");
        //<< . write "  if (URL != """") window.location.href = URL;"
        m$.Cmd.Write("  if (URL != \"\") window.location.href = URL;");
        //<< . write "  }"
        m$.Cmd.Write("  }");
        //<< . write "}"
        m$.Cmd.Write("}");
      }
    }
    //<< 
    //<< if $get(YFORM)="" $$$EndScript() quit
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"")) {
      include.COMSYS.$$$EndScript(m$);
      return;
    }
    //<< 
    //<< ; JavaScript in Meta-data
    //<< ;---------------------------------------
    //<< 
    //<< ;FUNKTIONEN AUS DEN PRIMÄRSCHLÜSSELFELDERN ;out of
    //<< set YLF = ""
    mVar YLF = m$.var("YLF");
    YLF.set("");
    //<< for  set YLF = $order(^WWW129(0,YFORM,YLF)) quit:YLF=""  do
    for (;true;) {
      YLF.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get())));
      if (mOp.Equal(YLF.get(),"")) {
        break;
      }
      //<< . set YON = ""
      mVar YON = m$.var("YON");
      YON.set("");
      //<< . for  set YON = $order(^WWW129(0,YFORM,YLF,YON)) quit:YON=""  do
      for (;true;) {
        YON.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get(),YON.get())));
        if (mOp.Equal(YON.get(),"")) {
          break;
        }
        //<< . . set YFU = ""
        mVar YFU = m$.var("YFU");
        YFU.set("");
        //<< . . for  set YFU = $order(^WWW129(0,YFORM,YLF,YON,YFU)) quit:YFU=""  do
        for (;true;) {
          YFU.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get(),YON.get(),YFU.get())));
          if (mOp.Equal(YFU.get(),"")) {
            break;
          }
          //<< . . . set YTX = $piece($$^WWWSETL("^WWW129(0,"""_YFORM_""","""_YLF_""","""_YON_""","""_YFU_""",1)"),Y,1)
          mVar YTX = m$.var("YTX");
          YTX.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW129(0,\"",m$.var("YFORM").get()),"\",\""),YLF.get()),"\",\""),YON.get()),"\",\""),YFU.get()),"\",1)")),m$.var("Y").get(),1));
          //<< . . . if $translate(YTX,"| ")'="" do
          if (mOp.NotEqual(m$.Fnc.$translate(YTX.get(),"| "),"")) {
            do {
              //<< . . . . write "function "_$piece(YFU,".",1)_"("_$translate($piece(YFU,".",2,99),".",",")_")"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("function ",m$.Fnc.$piece(YFU.get(),".",1)),"("),m$.Fnc.$translate(m$.Fnc.$piece(YFU.get(),".",2,99),".",",")),")"));
              //<< . . . . write " {"
              m$.Cmd.Write(" {");
              //<< . . . . if $extract(YTX,1,3)="D ^" set YTX = $translate(YTX,"|") xecute YTX write "    }" quit
              if (mOp.Equal(m$.Fnc.$extract(YTX.get(),1,3),"D ^")) {
                YTX.set(m$.Fnc.$translate(YTX.get(),"|"));
                m$.Cmd.Xecute(YTX.get());
                m$.Cmd.Write("    }");
                break;
              }
              //<< . . . . for YI=1:1 set YTX1 = $piece(YTX,"|",YI) quit:$piece(YTX,"|",YI,99999)=""  do
              mVar YI = m$.var("YI");
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                mVar YTX1 = m$.var("YTX1");
                YTX1.set(m$.Fnc.$piece(YTX.get(),"|",YI.get()));
                if (mOp.Equal(m$.Fnc.$piece(YTX.get(),"|",YI.get(),99999),"")) {
                  break;
                }
                do {
                  //<< . . . . . quit:$translate(YTX1," ")=""
                  if (mOp.Equal(m$.Fnc.$translate(YTX1.get()," "),"")) {
                    break;
                  }
                  //<< . . . . . write "   "_$translate(YTX1,Y,";")
                  m$.Cmd.Write(mOp.Concat("   ",m$.Fnc.$translate(YTX1.get(),m$.var("Y").get(),";")));
                } while (false);
              }
              //<< . . . . ;
              //<< . . . . write " }"
              m$.Cmd.Write(" }");
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< ;FUNKTIONEN AUS DEN DATENFELDER ;out of
    //<< set YLF = ""
    YLF.set("");
    //<< for  set YLF = $order(^WWW1291(0,YFORM,YLF)) quit:YLF=""  do
    for (;true;) {
      YLF.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get())));
      if (mOp.Equal(YLF.get(),"")) {
        break;
      }
      //<< . set YON = ""
      mVar YON = m$.var("YON");
      YON.set("");
      //<< . for  set YON = $order(^WWW1291(0,YFORM,YLF,YON)) quit:YON=""  do
      for (;true;) {
        YON.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get(),YON.get())));
        if (mOp.Equal(YON.get(),"")) {
          break;
        }
        //<< . . set YFU = ""
        mVar YFU = m$.var("YFU");
        YFU.set("");
        //<< . . for  set YFU = $order(^WWW1291(0,YFORM,YLF,YON,YFU)) quit:YFU=""  do
        for (;true;) {
          YFU.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get(),YON.get(),YFU.get())));
          if (mOp.Equal(YFU.get(),"")) {
            break;
          }
          //<< . . . set YTX = $piece($$^WWWSETL("^WWW1291(0,"""_YFORM_""","""_YLF_""","""_YON_""","""_YFU_""",1)"),Y,1)
          mVar YTX = m$.var("YTX");
          YTX.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW1291(0,\"",m$.var("YFORM").get()),"\",\""),YLF.get()),"\",\""),YON.get()),"\",\""),YFU.get()),"\",1)")),m$.var("Y").get(),1));
          //<< . . . if $translate(YTX,"| ")'="" do
          if (mOp.NotEqual(m$.Fnc.$translate(YTX.get(),"| "),"")) {
            do {
              //<< . . . . write "function "_$piece(YFU,".",1)_"("_$translate($piece(YFU,".",2,99),".",",")_")"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("function ",m$.Fnc.$piece(YFU.get(),".",1)),"("),m$.Fnc.$translate(m$.Fnc.$piece(YFU.get(),".",2,99),".",",")),")"));
              //<< . . . . write " {"
              m$.Cmd.Write(" {");
              //<< . . . . if $extract(YTX,1,3)="D ^" set YTX = $translate(YTX,"|"," ") xecute YTX write "    }" quit
              if (mOp.Equal(m$.Fnc.$extract(YTX.get(),1,3),"D ^")) {
                YTX.set(m$.Fnc.$translate(YTX.get(),"|"," "));
                m$.Cmd.Xecute(YTX.get());
                m$.Cmd.Write("    }");
                break;
              }
              //<< . . . . for YI=1:1 set YTX1 = $piece(YTX,"|",YI) quit:$piece(YTX,"|",YI,99999)=""  do
              mVar YI = m$.var("YI");
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                mVar YTX1 = m$.var("YTX1");
                YTX1.set(m$.Fnc.$piece(YTX.get(),"|",YI.get()));
                if (mOp.Equal(m$.Fnc.$piece(YTX.get(),"|",YI.get(),99999),"")) {
                  break;
                }
                do {
                  //<< . . . . . quit:$translate(YTX1," ")=""
                  if (mOp.Equal(m$.Fnc.$translate(YTX1.get()," "),"")) {
                    break;
                  }
                  //<< . . . . . write "  "_$translate(YTX1,Y,";")
                  m$.Cmd.Write(mOp.Concat("  ",m$.Fnc.$translate(YTX1.get(),m$.var("Y").get(),";")));
                } while (false);
              }
              //<< . . . . ;
              //<< . . . . write " }"
              m$.Cmd.Write(" }");
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< write "<SCRIPT LANGUAGE=VBScript>"
    m$.Cmd.Write("<SCRIPT LANGUAGE=VBScript>");
    //<< write "<!--"
    m$.Cmd.Write("<!--");
    //<< 
    //<< ;VB AUS PRIMÄRSCHLÜSSELN ;out of
    //<< set YLF=""
    YLF.set("");
    //<< for  set YLF=$order(^WWW129(0,YFORM,YLF)) quit:YLF=""  do
    for (;true;) {
      YLF.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get())));
      if (mOp.Equal(YLF.get(),"")) {
        break;
      }
      //<< . set YON=""
      mVar YON = m$.var("YON");
      YON.set("");
      //<< . for  set YON=$order(^WWW129(0,YFORM,YLF,YON)) quit:YON=""  do
      for (;true;) {
        YON.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get(),YON.get())));
        if (mOp.Equal(YON.get(),"")) {
          break;
        }
        //<< . . set YFU=""
        mVar YFU = m$.var("YFU");
        YFU.set("");
        //<< . . for  set YFU=$order(^WWW129(0,YFORM,YLF,YON,YFU)) quit:YFU=""  do
        for (;true;) {
          YFU.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),YLF.get(),YON.get(),YFU.get())));
          if (mOp.Equal(YFU.get(),"")) {
            break;
          }
          //<< . . . set YTX=$piece($$^WWWSETL("^WWW129(0,"""_YFORM_""","""_YLF_""","""_YON_""","""_YFU_""",1)"),Y,2)
          mVar YTX = m$.var("YTX");
          YTX.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW129(0,\"",m$.var("YFORM").get()),"\",\""),YLF.get()),"\",\""),YON.get()),"\",\""),YFU.get()),"\",1)")),m$.var("Y").get(),2));
          //<< . . . if $translate(YTX,"| ")'="" do
          if (mOp.NotEqual(m$.Fnc.$translate(YTX.get(),"| "),"")) {
            do {
              //<< . . . . write " function "_$piece(YFU,".",1)_"("_$translate($piece(YFU,".",2,99),".",",")_")"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" function ",m$.Fnc.$piece(YFU.get(),".",1)),"("),m$.Fnc.$translate(m$.Fnc.$piece(YFU.get(),".",2,99),".",",")),")"));
              //<< . . . . ;WRITE "    {"
              //<< . . . . if $extract(YTX,1,3)="D ^" set YTX=$translate(YTX,"|"," ") xecute YTX quit
              if (mOp.Equal(m$.Fnc.$extract(YTX.get(),1,3),"D ^")) {
                YTX.set(m$.Fnc.$translate(YTX.get(),"|"," "));
                m$.Cmd.Xecute(YTX.get());
                break;
              }
              //<< . . . . for YI=1:1 set YTX1=$piece(YTX,"|",YI) quit:$piece(YTX,"|",YI,99999)=""  do
              mVar YI = m$.var("YI");
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                mVar YTX1 = m$.var("YTX1");
                YTX1.set(m$.Fnc.$piece(YTX.get(),"|",YI.get()));
                if (mOp.Equal(m$.Fnc.$piece(YTX.get(),"|",YI.get(),99999),"")) {
                  break;
                }
                do {
                  //<< . . . . . quit:$translate(YTX1," ")=""
                  if (mOp.Equal(m$.Fnc.$translate(YTX1.get()," "),"")) {
                    break;
                  }
                  //<< . . . . . write " "_$translate(YTX1,Y,";")
                  m$.Cmd.Write(mOp.Concat(" ",m$.Fnc.$translate(YTX1.get(),m$.var("Y").get(),";")));
                } while (false);
              }
            } while (false);
          }
        }
      }
    }
    //<< . . . . ;
    //<< . . . . ;WRITE " }"
    //<< 
    //<< ;VB AUS DATENFELDERN ;out of
    //<< set YLF=""
    YLF.set("");
    //<< for  set YLF=$order(^WWW1291(0,YFORM,YLF)) quit:YLF=""  do
    for (;true;) {
      YLF.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get())));
      if (mOp.Equal(YLF.get(),"")) {
        break;
      }
      //<< . set YON=""
      mVar YON = m$.var("YON");
      YON.set("");
      //<< . for  set YON=$order(^WWW1291(0,YFORM,YLF,YON)) quit:YON=""  do
      for (;true;) {
        YON.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get(),YON.get())));
        if (mOp.Equal(YON.get(),"")) {
          break;
        }
        //<< . . set YFU=""
        mVar YFU = m$.var("YFU");
        YFU.set("");
        //<< . . for  set YFU=$order(^WWW1291(0,YFORM,YLF,YON,YFU)) quit:YFU=""  do
        for (;true;) {
          YFU.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),YLF.get(),YON.get(),YFU.get())));
          if (mOp.Equal(YFU.get(),"")) {
            break;
          }
          //<< . . . set YTX=$piece($$^WWWSETL("^WWW1291(0,"""_YFORM_""","""_YLF_""","""_YON_""","""_YFU_""",1)"),Y,2)
          mVar YTX = m$.var("YTX");
          YTX.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW1291(0,\"",m$.var("YFORM").get()),"\",\""),YLF.get()),"\",\""),YON.get()),"\",\""),YFU.get()),"\",1)")),m$.var("Y").get(),2));
          //<< . . . if $translate(YTX,"| ")'="" do
          if (mOp.NotEqual(m$.Fnc.$translate(YTX.get(),"| "),"")) {
            do {
              //<< . . . . write " function "_$piece(YFU,".",1)_"("_$translate($piece(YFU,".",2,99),".",",")_")"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" function ",m$.Fnc.$piece(YFU.get(),".",1)),"("),m$.Fnc.$translate(m$.Fnc.$piece(YFU.get(),".",2,99),".",",")),")"));
              //<< . . . . ;WRITE "    {"
              //<< . . . . if $extract(YTX,1,3)="D ^" set YTX=$translate(YTX,"|"," ") xecute YTX quit
              if (mOp.Equal(m$.Fnc.$extract(YTX.get(),1,3),"D ^")) {
                YTX.set(m$.Fnc.$translate(YTX.get(),"|"," "));
                m$.Cmd.Xecute(YTX.get());
                break;
              }
              //<< . . . . for YI=1:1 set YTX1=$piece(YTX,"|",YI) quit:$piece(YTX,"|",YI,99999)=""  do
              mVar YI = m$.var("YI");
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                mVar YTX1 = m$.var("YTX1");
                YTX1.set(m$.Fnc.$piece(YTX.get(),"|",YI.get()));
                if (mOp.Equal(m$.Fnc.$piece(YTX.get(),"|",YI.get(),99999),"")) {
                  break;
                }
                do {
                  //<< . . . . . quit:$translate(YTX1," ")=""
                  if (mOp.Equal(m$.Fnc.$translate(YTX1.get()," "),"")) {
                    break;
                  }
                  //<< . . . . . write "  "_$translate(YTX1,Y,";")
                  m$.Cmd.Write(mOp.Concat("  ",m$.Fnc.$translate(YTX1.get(),m$.var("Y").get(),";")));
                } while (false);
              }
            } while (false);
          }
        }
      }
    }
    //<< . . . . ;
    //<< . . . . ;WRITE " }"
    //<< 
    //<< write "//-->"
    m$.Cmd.Write("//-->");
    //<< write "</SCRIPT>"
    m$.Cmd.Write("</SCRIPT>");
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< JSLibraries()
  public Object JSLibraries(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Encapsulate EventBroker Call
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-Aug-2010   shobby  SR17481: gradient.js redundant.
    //<< ; 21-Apr-2010   shobby  SR17253: Some support for cross browser color transition.
    //<< ; 08-Dec-2006   PO      SR15276: Renamed function to JSLibaries, was EventBroker.
    //<< ;                           Added commonfunctions.js
    //<< ; 02-Jun-2006   JW      SR14697: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if ($get(YHYPER)=0) || ($get(YHYPER)=1) { // Don't believe YHYPER is anything other than 0 or 1, so will not need this check
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YHYPER")),0)) || (mOp.Equal(m$.Fnc.$get(m$.var("YHYPER")),1))) {
      //<< write "<SCRIPT type='text/javascript' SRC="""_YGIF_"eventbrokeren1.js""></SCRIPT>",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<SCRIPT type='text/javascript' SRC=\"",m$.var("YGIF").get()),"eventbrokeren1.js\"></SCRIPT>"),"\n");
      //<< write "<script type='text/javascript' src='"_YGIF_"commonfunctions.js'></script>",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<script type='text/javascript' src='",m$.var("YGIF").get()),"commonfunctions.js'></script>"),"\n");
      //<< ;SR17481 write "<script type='text/javascript' src='"_YGIF_"gradient.js'></script>",!     ; SR17253
      //<< if +$get(^SysSetup("FieldEvents")) write !,"<script type='text/javascript' src='"_YGIF_"eventfunctions.js'></script>"
      if (mOp.Logical(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","FieldEvents"))))) {
        m$.Cmd.Write("\n",mOp.Concat(mOp.Concat("<script type='text/javascript' src='",m$.var("YGIF").get()),"eventfunctions.js'></script>"));
      }
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< JAVA ;FUNKTIONSAUFRUFE DER EINZELFELDER ;the
  public void JAVA() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ;  9-Dec-2005   JW      SR13195: Don't call BEARB here.
    //<< ; 16-Aug-2005   JW      SR12290: Added check for readonly
    //<< ;-------------------------------------------------------------------------------
    //<< new BEARB
    mVar BEARB = m$.var("BEARB");
    m$.newVar(BEARB);
    //<< 
    //<< if YBBN="" set YBBN=YLFN
    if (mOp.Equal(m$.var("YBBN").get(),"")) {
      mVar YBBN = m$.var("YBBN");
      YBBN.set(m$.var("YLFN").get());
    }
    //<< quit:$$$WWW120StandardSubmit(YVOR)'=""      // This is only used for form WWWBARCODE
    if (mOp.NotEqual(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),"")) {
      return;
    }
    //<< 
    //<< if YART="D" || (YART="M") {
    if (mOp.Equal(m$.var("YART").get(),"D") || (mOp.Equal(m$.var("YART").get(),"M"))) {
      //<< set YON = ""
      mVar YON = m$.var("YON");
      YON.set("");
      //<< for {
      for (;true;) {
        //<< set YON = $order(^WWW1291(0,YFORM,YBBN,YON))
        YON.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),m$.var("YBBN").get(),YON.get())));
        //<< quit:YON=""
        if (mOp.Equal(YON.get(),"")) {
          break;
        }
        //<< 
        //<< set YFU = ""
        mVar YFU = m$.var("YFU");
        YFU.set("");
        //<< for {
        for (;true;) {
          //<< set YFU = $order(^WWW1291(0,YFORM,YBBN,YON,YFU))
          YFU.set(m$.Fnc.$order(m$.var("^WWW1291",0,m$.var("YFORM").get(),m$.var("YBBN").get(),YON.get(),YFU.get())));
          //<< quit:YFU=""
          if (mOp.Equal(YFU.get(),"")) {
            break;
          }
          //<< 
          //<< write " "_$$$WWW100Text($get(^WWW100(0,"EVENT",SPRACHE,YON,1)))_"='"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" ",include.WWWConst.$$$WWW100Text(m$,m$.Fnc.$get(m$.var("^WWW100",0,"EVENT",m$.var("SPRACHE").get(),YON.get(),1)))),"='"));
          //<< write $piece(YFU,".",1)_"("_$translate($piece(YFU,".",2,99),".",",")_");'"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YFU.get(),".",1),"("),m$.Fnc.$translate(m$.Fnc.$piece(YFU.get(),".",2,99),".",",")),");'"));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< } elseif YART="P" {
    else if (mOp.Equal(m$.var("YART").get(),"P")) {
      //<< set YON = ""
      mVar YON = m$.var("YON");
      YON.set("");
      //<< for {
      for (;true;) {
        //<< set YON = $order(^WWW129(0,YFORM,YBBN,YON))
        YON.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),m$.var("YBBN").get(),YON.get())));
        //<< quit:YON=""
        if (mOp.Equal(YON.get(),"")) {
          break;
        }
        //<< 
        //<< set YFU = ""
        mVar YFU = m$.var("YFU");
        YFU.set("");
        //<< for {
        for (;true;) {
          //<< set YFU = $order(^WWW129(0,YFORM,YBBN,YON,YFU))
          YFU.set(m$.Fnc.$order(m$.var("^WWW129",0,m$.var("YFORM").get(),m$.var("YBBN").get(),YON.get(),YFU.get())));
          //<< quit:YFU=""
          if (mOp.Equal(YFU.get(),"")) {
            break;
          }
          //<< 
          //<< write " "_$$$WWW100Text($get(^WWW100(0,"EVENT",SPRACHE,YON,1)))_"='"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" ",include.WWWConst.$$$WWW100Text(m$,m$.Fnc.$get(m$.var("^WWW100",0,"EVENT",m$.var("SPRACHE").get(),YON.get(),1)))),"='"));
          //<< write $piece(YFU,".",1)_"("_$translate($piece(YFU,".",2,99),".",",")_");'"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YFU.get(),".",1),"("),m$.Fnc.$translate(m$.Fnc.$piece(YFU.get(),".",2,99),".",",")),");'"));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< PIECE ;$P
  public void PIECE() {
    //<< ;IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* DATUMSPRÜFUNG (WWWFORM8)************************* -->",YCR,YCR
    //<< write "<SCRIPT LANGUAGE=JavaScript>"
    m$.Cmd.Write("<SCRIPT LANGUAGE=JavaScript>");
    //<< write "<!--"
    m$.Cmd.Write("<!--");
    //<< 
    //<< write " function piece(txt,tr,nr)"
    m$.Cmd.Write(" function piece(txt,tr,nr)");
    //<< write "  {"
    m$.Cmd.Write("  {");
    //<< write "   txt = txt + tr;"
    m$.Cmd.Write("   txt = txt + tr;");
    //<< write "   var array = txt.split(tr);"
    m$.Cmd.Write("   var array = txt.split(tr);");
    //<< write "   fpiece=array[nr-1];"
    m$.Cmd.Write("   fpiece=array[nr-1];");
    //<< write "   if (!(fpiece)) return('');"
    m$.Cmd.Write("   if (!(fpiece)) return('');");
    //<< write "   return(fpiece);"
    m$.Cmd.Write("   return(fpiece);");
    //<< write " }"
    m$.Cmd.Write(" }");
    //<< 
    //<< write "//-->"
    m$.Cmd.Write("//-->");
    //<< write "</SCRIPT>"
    m$.Cmd.Write("</SCRIPT>");
    //<< quit
    return;
  }

  //<< 
  //<< DATE
  public void DATE() {
    //<< write "<SCRIPT LANGUAGE=JavaScript>"
    m$.Cmd.Write("<SCRIPT LANGUAGE=JavaScript>");
    //<< if SPRACHE="DE" do
    if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
      //<< . write "<!--"
      m$.Cmd.Write("<!--");
      //<< . write "  function checkdate1(input)"
      m$.Cmd.Write("  function checkdate1(input)");
      //<< . write "    {"
      m$.Cmd.Write("    {");
      //<< . write "      dd = piece(input,""."",1);"
      m$.Cmd.Write("      dd = piece(input,\".\",1);");
      //<< . write "      mm = piece(input,""."",2);"
      m$.Cmd.Write("      mm = piece(input,\".\",2);");
      //<< . write "      yy = piece(input,""."",3);"
      m$.Cmd.Write("      yy = piece(input,\".\",3);");
      //<< . write "      if (dd.length > 2 || !dd.length) return false;"
      m$.Cmd.Write("      if (dd.length > 2 || !dd.length) return false;");
      //<< . write "      if (mm.length > 2 || !mm.length) return false;"
      m$.Cmd.Write("      if (mm.length > 2 || !mm.length) return false;");
      //<< . write "      if (yy.length > 4 || !yy.length) return false;"
      m$.Cmd.Write("      if (yy.length > 4 || !yy.length) return false;");
      //<< . write "      if (yy.length < 2 || !yy.length) return false;"
      m$.Cmd.Write("      if (yy.length < 2 || !yy.length) return false;");
      //<< . write "      if (dd>31) return false;"
      m$.Cmd.Write("      if (dd>31) return false;");
      //<< . write "      if (mm>12) return false;"
      m$.Cmd.Write("      if (mm>12) return false;");
      //<< . write "      if (mm==2 && dd>29) return false;"
      m$.Cmd.Write("      if (mm==2 && dd>29) return false;");
      //<< . write "      if (dd==31 && ((mm==4) || (mm==6) || (mm==9) || (mm==11))) return false;"
      m$.Cmd.Write("      if (dd==31 && ((mm==4) || (mm==6) || (mm==9) || (mm==11))) return false;");
      //<< . write "      datum = new Date(yy,mm-1,dd);"
      m$.Cmd.Write("      datum = new Date(yy,mm-1,dd);");
      //<< . write "      return true;"
      m$.Cmd.Write("      return true;");
      //<< . write " }"
      m$.Cmd.Write(" }");
    }
    //<< 
    //<< if SPRACHE'="DE" do
    if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
      //<< . write "<!--"
      m$.Cmd.Write("<!--");
      //<< . write "  function checkdate1(input)"
      m$.Cmd.Write("  function checkdate1(input)");
      //<< . write "    {"
      m$.Cmd.Write("    {");
      //<< . write "      dd = piece(input,""/"",2);"
      m$.Cmd.Write("      dd = piece(input,\"/\",2);");
      //<< . write "      mm = piece(input,""/"",1);"
      m$.Cmd.Write("      mm = piece(input,\"/\",1);");
      //<< . write "      yy = piece(input,""/"",3);"
      m$.Cmd.Write("      yy = piece(input,\"/\",3);");
      //<< . write "      if (dd.length > 2 || !dd.length) return false;"
      m$.Cmd.Write("      if (dd.length > 2 || !dd.length) return false;");
      //<< . write "      if (mm.length > 2 || !mm.length) return false;"
      m$.Cmd.Write("      if (mm.length > 2 || !mm.length) return false;");
      //<< . write "      if (yy.length > 4 || !yy.length) return false;"
      m$.Cmd.Write("      if (yy.length > 4 || !yy.length) return false;");
      //<< . write "      if (yy.length < 2 || !yy.length) return false;"
      m$.Cmd.Write("      if (yy.length < 2 || !yy.length) return false;");
      //<< . write "      if (dd>31) return false;"
      m$.Cmd.Write("      if (dd>31) return false;");
      //<< . write "      if (mm>12) return false;"
      m$.Cmd.Write("      if (mm>12) return false;");
      //<< . write "      if (mm==2 && dd>29) return false;"
      m$.Cmd.Write("      if (mm==2 && dd>29) return false;");
      //<< . write "      if (dd==31 && ((mm==4) || (mm==6) || (mm==9) || (mm==11))) return false;"
      m$.Cmd.Write("      if (dd==31 && ((mm==4) || (mm==6) || (mm==9) || (mm==11))) return false;");
      //<< . write "      datum = new Date(yy,mm-1,dd);"
      m$.Cmd.Write("      datum = new Date(yy,mm-1,dd);");
      //<< . write "      return true;"
      m$.Cmd.Write("      return true;");
      //<< . write " }"
      m$.Cmd.Write(" }");
    }
    //<< 
    //<< ; FIXME : Base on date format, not language
    //<< write "function checkdate(input)"
    m$.Cmd.Write("function checkdate(input)");
    //<< write "{"
    m$.Cmd.Write("{");
    //<< write "             OK = true;"
    m$.Cmd.Write("             OK = true;");
    //<< write "             heute = new Date();"
    m$.Cmd.Write("             heute = new Date();");
    //<< write "             if (input == """") return input;"
    m$.Cmd.Write("             if (input == \"\") return input;");
    //<< if SPRACHE="DE" do
    if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
      //<< . write "             if (input == ""."" || input== "","" )"
      m$.Cmd.Write("             if (input == \".\" || input== \",\" )");
      //<< . write "                           input=heute.getDate() + ""."" + (heute.getMonth()+1) + ""."" + heute.getYear();"
      m$.Cmd.Write("                           input=heute.getDate() + \".\" + (heute.getMonth()+1) + \".\" + heute.getYear();");
      //<< . write "             if (piece(input,""."",2)=="""")"
      m$.Cmd.Write("             if (piece(input,\".\",2)==\"\")");
      //<< . write "                            input=piece(input,""."",1)+"".""+(heute.getMonth()+1);"
      m$.Cmd.Write("                            input=piece(input,\".\",1)+\".\"+(heute.getMonth()+1);");
      //<< . write "             if (piece(input,""."",3)=="""")"
      m$.Cmd.Write("             if (piece(input,\".\",3)==\"\")");
      //<< . write "                            input=piece(input,""."",1)+"".""+piece(input,""."",2)+"".""+(heute.getYear());"
      m$.Cmd.Write("                            input=piece(input,\".\",1)+\".\"+piece(input,\".\",2)+\".\"+(heute.getYear());");
    }
    //<< 
    //<< if SPRACHE'="DE" do
    if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
      //<< . write "             if (input == ""."")"
      m$.Cmd.Write("             if (input == \".\")");
      //<< . write "                           input=(heute.getMonth()+1) + ""/"" + heute.getDate() + ""/"" + heute.getYear();"
      m$.Cmd.Write("                           input=(heute.getMonth()+1) + \"/\" + heute.getDate() + \"/\" + heute.getYear();");
      //<< . write "             if (piece(input,""/"",2)=="""")"
      m$.Cmd.Write("             if (piece(input,\"/\",2)==\"\")");
      //<< . write "                            input=+(heute.getMonth()+1)+""/""+piece(input,""/"",1);"
      m$.Cmd.Write("                            input=+(heute.getMonth()+1)+\"/\"+piece(input,\"/\",1);");
      //<< . write "             if (piece(input,""/"",3)=="""")"
      m$.Cmd.Write("             if (piece(input,\"/\",3)==\"\")");
      //<< . write "                            input=piece(input,""/"",1)+""/""+piece(input,""/"",2)+""/""+(heute.getYear());"
      m$.Cmd.Write("                            input=piece(input,\"/\",1)+\"/\"+piece(input,\"/\",2)+\"/\"+(heute.getYear());");
    }
    //<< 
    //<< write "             OK = checkdate1(input);"
    m$.Cmd.Write("             OK = checkdate1(input);");
    //<< write "             if (!OK) alert("""_$$^WWWTEXT(272)_" (""+input+"")"");"        ; "Wrong Date Format"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("             if (!OK) alert(\"",m$.fnc$("WWWTEXT.main",272))," (\"+input+\")\");"));
    //<< write "             return input;"
    m$.Cmd.Write("             return input;");
    //<< write "    }"
    m$.Cmd.Write("    }");
    //<< write "//-->"
    m$.Cmd.Write("//-->");
    //<< write "</SCRIPT>"
    m$.Cmd.Write("</SCRIPT>");
    //<< quit
    return;
  }

  //<< 
  //<< VISABLE ;UNTESCHIEDLICHE HELLIGKEITEN
  public void VISABLE() {
    //<< write "<SCRIPT LANGUAGE=JavaScript>"
    m$.Cmd.Write("<SCRIPT LANGUAGE=JavaScript>");
    do {
      //<< do
      //<< . write "  function makevisible(cur,which)"
      m$.Cmd.Write("  function makevisible(cur,which)");
      //<< . write "    {"
      m$.Cmd.Write("    {");
      //<< . write "      if (which==0)"
      m$.Cmd.Write("      if (which==0)");
      //<< . write "      cur.filters.alpha.opacity=100"
      m$.Cmd.Write("      cur.filters.alpha.opacity=100");
      //<< . write "      else "
      m$.Cmd.Write("      else ");
      //<< . write "      cur.filters.alpha.opacity=60"
      m$.Cmd.Write("      cur.filters.alpha.opacity=60");
      //<< . write " }"
      m$.Cmd.Write(" }");
    } while(false);
    //<< 
    //<< write "</SCRIPT>"
    m$.Cmd.Write("</SCRIPT>");
    //<< ;in den forms: ;within
    //<< ;I +$P(YVOR,Y,45)=1 W YCR,"<IMG SRC="""_YGIF_"new.gif"" style=""filter:alpha(opacity=80)"" onMouseover=""makevisible(this,0)""onMouseout=""makevisible(this,1)"" "_YHEIGHT_" "_YWIDTH_" ALT="""_$$^WWWTEXT(130)_""" border=0></A>"
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< HYPER ; STARTEN MANUELLE HYPEREVENT FÜR FORMS
  public void HYPER() {
    //<< set %KEY("XMLHTTPREQ") = 1
    m$.var("%KEY","XMLHTTPREQ").set(1);
    //<< set %KEY("HYPER") = ##class(User.www).HyperEventCall("User.www.HyperEvent","Para,Value",0)
    m$.var("%KEY","HYPER").set(m$.fnc$("User.www.HyperEventCall","User.www.HyperEvent","Para,Value",0));
    //<< set YHYPEREVENT   = %KEY("HYPER")
    mVar YHYPEREVENT = m$.var("YHYPEREVENT");
    YHYPEREVENT.set(m$.var("%KEY","HYPER").get());
    //<< set YXMLHTTPREQ   = %KEY("XMLHTTPREQ")
    mVar YXMLHTTPREQ = m$.var("YXMLHTTPREQ");
    YXMLHTTPREQ.set(m$.var("%KEY","XMLHTTPREQ").get());
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< jsDebugFunction()
  public Object jsDebugFunction(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; javascript debug function used to call function actual function that writes content into debug frame.
    //<< ;
    //<< ; Note: This could all be made part of the debugMsg macro.
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 23-Jun-2005   PO      Created SR12765
    //<< ;-------------------------------------------------------------------------------
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write "function debugMsg(strDebugMessage) {"
    m$.Cmd.Write("function debugMsg(strDebugMessage) {");
    //<< write "if (document.frames && typeof(document.frames.top)=='object' && typeof(document.frames.top.writeDebugMessage)=='function' && typeof(strDebugMessage)=='string') {"
    m$.Cmd.Write("if (document.frames && typeof(document.frames.top)=='object' && typeof(document.frames.top.writeDebugMessage)=='function' && typeof(strDebugMessage)=='string') {");
    //<< write "document.frames.top.writeDebugMessage(strDebugMessage);"
    m$.Cmd.Write("document.frames.top.writeDebugMessage(strDebugMessage);");
    //<< 
    //<< write "}"
    m$.Cmd.Write("}");
    //<< write "}"
    m$.Cmd.Write("}");
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< JSMaskFunction()
  public Object JSMaskFunction(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Javascript masking function, parses the mask and applies it to the field
    //<< ; Chars out of range are removed (controls, special chars, symbols..)
    //<< ; Chars valid but not compliant to Mask, are ignored
    //<< ; Follows a subset of Cache Pattern Match Syntax
    //<< ; <number of occurrences><code>
    //<< ; <number of occurrences>"<string>"
    //<< ;
    //<< ; code:
    //<< ; A(characters)          : "A-ZÁÀÃÂÉÈÊÍÌÎÓÒÕÔÚÙÛÇa-záàãâéèêíìîóòõôúùûç"
    //<< ; N(numbers)             : "0-9"
    //<< ; E(characters & numbers): "A-ZÁÀÃÂÉÈÊÍÌÎÓÒÕÔÚÙÛÇa-záàãâéèêíìîóòõôúùûç0-9"
    //<< ; <string> between ""    : any characters
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 30-Mar-2009   shobby  SR16459: SRBR014794 code restoration from SES/DEV merge
    //<< ; 07-Apr-2008   heber   SRBR014794b: Fied mask algorithm
    //<< ; 04-Jan-2008   heber   SRBR014794: Changed doMasking, field value comparison
    //<< ;                           not here anymore
    //<< ; 27-Jul-2007   HeberB  SRBR014502: Fixed if = clauses; Fixed wrong JS substr;
    //<< ;                           Applied coding standards to JS var names;
    //<< ;                           Changed from 334008 to WWW00074
    //<< ; 12-Jul-2007   HeberB  SRBR014502:Created
    //<< ;-------------------------------------------------------------------------------
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write "function applyMask(_m,_v) {"
    m$.Cmd.Write("function applyMask(_m,_v) {");
    //<< write "  var strValue = _v, strMask = _m;"
    m$.Cmd.Write("  var strValue = _v, strMask = _m;");
    //<< write "  var loop, loop2, loop3, strNumberToken, strStringToken, intState, blnError;"
    m$.Cmd.Write("  var loop, loop2, loop3, strNumberToken, strStringToken, intState, blnError;");
    //<< write "  var strRule = ""ANE"", arrRuleTest = [], arrMaskTable = [],"
    m$.Cmd.Write("  var strRule = \"ANE\", arrRuleTest = [], arrMaskTable = [],");
    //<< write "      arrRegexDef = {""A"": ""A-ZÁÀÃÂÉÈÊÍÌÎÓÒÕÔÚÙÛÇa-záàãâéèêíìîóòõôúùûç"", ""N"": ""0-9"", ""E"": ""A-ZÁÀÃÂÉÈÊÍÌÎÓÒÕÔÚÙÛÇa-záàãâéèêíìîóòõôúùûç0-9"" },"
    m$.Cmd.Write("      arrRegexDef = {\"A\": \"A-ZÁÀÃÂÉÈÊÍÌÎÓÒÕÔÚÙÛÇa-záàãâéèêíìîóòõôúùûç\", \"N\": \"0-9\", \"E\": \"A-ZÁÀÃÂÉÈÊÍÌÎÓÒÕÔÚÙÛÇa-záàãâéèêíìîóòõôúùûç0-9\" },");
    //<< write "     strNewValue = """", blnIsRule , strMaskChar, intValueBegin = 0, intMaskTableSize = 0;"
    m$.Cmd.Write("     strNewValue = \"\", blnIsRule , strMaskChar, intValueBegin = 0, intMaskTableSize = 0;");
    //<< 
    //<< write "  strValue = strValue.replace(new RegExp(""[^"" + arrRegexDef[""E""] + ""]"", ""gi""), """");"
    m$.Cmd.Write("  strValue = strValue.replace(new RegExp(\"[^\" + arrRegexDef[\"E\"] + \"]\", \"gi\"), \"\");");
    //<< write "  intState = 1;"
    m$.Cmd.Write("  intState = 1;");
    //<< write "  blnError = 0;"
    m$.Cmd.Write("  blnError = 0;");
    //<< write "  for(loop=0; loop < strMask.length; loop++ ){"
    m$.Cmd.Write("  for(loop=0; loop < strMask.length; loop++ ){");
    //<< write "     strMaskChar = strMask.charAt(loop);"
    m$.Cmd.Write("     strMaskChar = strMask.charAt(loop);");
    //<< write "     switch(intState) {"
    m$.Cmd.Write("     switch(intState) {");
    //<< write "         case 1:"
    m$.Cmd.Write("         case 1:");
    //<< write "               if ((strMaskChar >= ""0"")&&(strMaskChar <= ""9"")) {"
    m$.Cmd.Write("               if ((strMaskChar >= \"0\")&&(strMaskChar <= \"9\")) {");
    //<< write "                 strNumberToken = strMaskChar;"
    m$.Cmd.Write("                 strNumberToken = strMaskChar;");
    //<< write "                 intState = 2;"
    m$.Cmd.Write("                 intState = 2;");
    //<< write "               } else {"
    m$.Cmd.Write("               } else {");
    //<< write "                 blnError =1;"
    m$.Cmd.Write("                 blnError =1;");
    //<< write "               }"
    m$.Cmd.Write("               }");
    //<< write "             break;"
    m$.Cmd.Write("             break;");
    //<< 
    //<< write "         case 2:"
    m$.Cmd.Write("         case 2:");
    //<< write "             if ((strMaskChar >= ""0"")&&(strMaskChar <= ""9"")) {"
    m$.Cmd.Write("             if ((strMaskChar >= \"0\")&&(strMaskChar <= \"9\")) {");
    //<< write "                 strNumberToken += strMaskChar;"
    m$.Cmd.Write("                 strNumberToken += strMaskChar;");
    //<< write "             } else {"
    m$.Cmd.Write("             } else {");
    //<< write "                 if (strRule.indexOf(strMaskChar) > -1) {"
    m$.Cmd.Write("                 if (strRule.indexOf(strMaskChar) > -1) {");
    //<< write "                     intState = 1;"
    m$.Cmd.Write("                     intState = 1;");
    //<< write "                     for(loop2=0;loop2<strNumberToken;loop2++) {"
    m$.Cmd.Write("                     for(loop2=0;loop2<strNumberToken;loop2++) {");
    //<< write "                         arrRuleTest[arrRuleTest.length] = ""["" + arrRegexDef[strMaskChar] + ""]"";"
    m$.Cmd.Write("                         arrRuleTest[arrRuleTest.length] = \"[\" + arrRegexDef[strMaskChar] + \"]\";");
    //<< write "                         arrMaskTable[arrMaskTable.length] = { ""chr"": strMaskChar, ""mask"": 1 };"
    m$.Cmd.Write("                         arrMaskTable[arrMaskTable.length] = { \"chr\": strMaskChar, \"mask\": 1 };");
    //<< write "                     }"
    m$.Cmd.Write("                     }");
    //<< write "                 } else { "
    m$.Cmd.Write("                 } else { ");
    //<< write "                     if (strMaskChar == '""') {"
    m$.Cmd.Write("                     if (strMaskChar == '\"') {");
    //<< write "                         strStringToken = '';"
    m$.Cmd.Write("                         strStringToken = '';");
    //<< write "                         intState = 4;"
    m$.Cmd.Write("                         intState = 4;");
    //<< write "                     } else {"
    m$.Cmd.Write("                     } else {");
    //<< write "                         blnError =1;"
    m$.Cmd.Write("                         blnError =1;");
    //<< write "                     }"
    m$.Cmd.Write("                     }");
    //<< write "                 }"
    m$.Cmd.Write("                 }");
    //<< write "             }"
    m$.Cmd.Write("             }");
    //<< write "             break;"
    m$.Cmd.Write("             break;");
    //<< 
    //<< write "         case 3:"
    m$.Cmd.Write("         case 3:");
    //<< write "             if (strMaskChar == '""') {"
    m$.Cmd.Write("             if (strMaskChar == '\"') {");
    //<< write "                 intState = 1;"
    m$.Cmd.Write("                 intState = 1;");
    //<< write "                 for(loop2=0;loop2<strNumberToken;loop2++) {"
    m$.Cmd.Write("                 for(loop2=0;loop2<strNumberToken;loop2++) {");
    //<< write "                     for (loop3=0;loop3<strStringToken.length;loop3++) {"
    m$.Cmd.Write("                     for (loop3=0;loop3<strStringToken.length;loop3++) {");
    //<< write "                         arrMaskTable[arrMaskTable.length] = { ""chr"": strStringToken.substring(loop3,loop3+1), ""mask"": 0 };"
    m$.Cmd.Write("                         arrMaskTable[arrMaskTable.length] = { \"chr\": strStringToken.substring(loop3,loop3+1), \"mask\": 0 };");
    //<< write "                         arrRuleTest[arrRuleTest.length] = ""["" + arrRegexDef[strMaskChar] + ""]"";"
    m$.Cmd.Write("                         arrRuleTest[arrRuleTest.length] = \"[\" + arrRegexDef[strMaskChar] + \"]\";");
    //<< write "                     }"
    m$.Cmd.Write("                     }");
    //<< write "                 }"
    m$.Cmd.Write("                 }");
    //<< write "             } else {"
    m$.Cmd.Write("             } else {");
    //<< write "                 strStringToken += strMaskChar;"
    m$.Cmd.Write("                 strStringToken += strMaskChar;");
    //<< write "             }"
    m$.Cmd.Write("             }");
    //<< write "             break;"
    m$.Cmd.Write("             break;");
    //<< 
    //<< write "         case 4:"
    m$.Cmd.Write("         case 4:");
    //<< write "             strStringToken = strMaskChar;"
    m$.Cmd.Write("             strStringToken = strMaskChar;");
    //<< write "             intState = 3;"
    m$.Cmd.Write("             intState = 3;");
    //<< write "             break;"
    m$.Cmd.Write("             break;");
    //<< write "     }"
    m$.Cmd.Write("     }");
    //<< write "     if (blnError==1) {"
    m$.Cmd.Write("     if (blnError==1) {");
    //<< write "         loop=99999;"
    m$.Cmd.Write("         loop=99999;");
    //<< write "     }"
    m$.Cmd.Write("     }");
    //<< write "  }"
    m$.Cmd.Write("  }");
    //<< write "  strNewValue = """";"
    m$.Cmd.Write("  strNewValue = \"\";");
    //<< write "  intValueBegin = 0;"
    m$.Cmd.Write("  intValueBegin = 0;");
    //<< write "  if (blnError==1) {"
    m$.Cmd.Write("  if (blnError==1) {");
    //<< write "     alert("""_$$^WWWTEXT("WWW00074")_""");"              ; "Invalid Mask"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("     alert(\"",m$.fnc$("WWWTEXT.main","WWW00074")),"\");"));
    //<< write "     strNewValue = strValue;"
    m$.Cmd.Write("     strNewValue = strValue;");
    //<< write "  } else {"
    m$.Cmd.Write("  } else {");
    //<< write "      if( strValue.length > 0) {"
    m$.Cmd.Write("      if( strValue.length > 0) {");
    //<< write "         loop=0;"
    m$.Cmd.Write("         loop=0;");
    //<< write "         while(loop < arrMaskTable.length){"
    m$.Cmd.Write("         while(loop < arrMaskTable.length){");
    //<< write "             if( arrMaskTable[loop].mask ){"
    m$.Cmd.Write("             if( arrMaskTable[loop].mask ){");
    //<< write "                 while( strValue.length > 0 && !(new RegExp(arrRuleTest[loop])).test(strValue.charAt(intValueBegin)) ) strValue = (strValue.length == 1) ? '' : strValue.substring(1);"
    m$.Cmd.Write("                 while( strValue.length > 0 && !(new RegExp(arrRuleTest[loop])).test(strValue.charAt(intValueBegin)) ) strValue = (strValue.length == 1) ? '' : strValue.substring(1);");
    //<< write "                 if( strValue.length > 0 ){"
    m$.Cmd.Write("                 if( strValue.length > 0 ){");
    //<< write "                     strNewValue += strValue.charAt(intValueBegin);"
    m$.Cmd.Write("                     strNewValue += strValue.charAt(intValueBegin);");
    //<< write "                     loop++;"
    m$.Cmd.Write("                     loop++;");
    //<< write "                     intValueBegin++;"
    m$.Cmd.Write("                     intValueBegin++;");
    //<< write "                 }"
    m$.Cmd.Write("                 }");
    //<< write "             } else {"
    m$.Cmd.Write("             } else {");
    //<< write "                 strNewValue += arrMaskTable[loop].chr;"
    m$.Cmd.Write("                 strNewValue += arrMaskTable[loop].chr;");
    //<< write "                 if( strValue.charAt(intValueBegin)==arrMaskTable[loop].chr ){"
    m$.Cmd.Write("                 if( strValue.charAt(intValueBegin)==arrMaskTable[loop].chr ){");
    //<< write "                     intValueBegin++;"
    m$.Cmd.Write("                     intValueBegin++;");
    //<< write "                 }"
    m$.Cmd.Write("                 }");
    //<< write "                 loop++;"
    m$.Cmd.Write("                 loop++;");
    //<< write "             }"
    m$.Cmd.Write("             }");
    //<< write "             if (intValueBegin > strValue.length) break;"
    m$.Cmd.Write("             if (intValueBegin > strValue.length) break;");
    //<< write "             if (strValue.length == 0) break;"
    m$.Cmd.Write("             if (strValue.length == 0) break;");
    //<< write "         }"
    m$.Cmd.Write("         }");
    //<< write "      }"
    m$.Cmd.Write("      }");
    //<< write " }"
    m$.Cmd.Write(" }");
    //<< write " return strNewValue;"
    m$.Cmd.Write(" return strNewValue;");
    //<< write "}"
    m$.Cmd.Write("}");
    //<< 
    //<< write "function doMasking(pstrMask, pstrThisValue, pintEventKeyCode) {"
    m$.Cmd.Write("function doMasking(pstrMask, pstrThisValue, pintEventKeyCode) {");
    //<< write "     var strResult;"
    m$.Cmd.Write("     var strResult;");
    //<< write "     strResult = pstrThisValue;"
    m$.Cmd.Write("     strResult = pstrThisValue;");
    //<< write "     if (pstrMask != '') {"
    m$.Cmd.Write("     if (pstrMask != '') {");
    //<< write "         if (pintEventKeyCode > 47) {"
    m$.Cmd.Write("         if (pintEventKeyCode > 47) {");
    //<< write "                 strResult = applyMask(pstrMask,pstrThisValue);"
    m$.Cmd.Write("                 strResult = applyMask(pstrMask,pstrThisValue);");
    //<< write "         }"
    m$.Cmd.Write("         }");
    //<< write "     }"
    m$.Cmd.Write("     }");
    //<< write "     return strResult;"
    m$.Cmd.Write("     return strResult;");
    //<< write "}"
    m$.Cmd.Write("}");
    //<< 
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< ;********************************************************
  //<< 
  //<< ApplyMask(pstrValue, pstrMask)
  public Object ApplyMask(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrMask = m$.newVarRef("pstrMask",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Cache equivalent of ApplyMask Javascript masking function above
    //<< ;
    //<< ; Returns: strValue after mask applied
    //<< ;
    //<< ; History:
    //<< ; 13-Apr-2008   HeberB  SRBR014932: Created based on JSMaskingFunction
    //<< ;-------------------------------------------------------------------------------
    //<< new arrRuleTest,arrMaskTable,arrRegexDef,blnError,blnIsRule,intArrMaskTableLength
    mVar arrRuleTest = m$.var("arrRuleTest");
    mVar arrMaskTable = m$.var("arrMaskTable");
    mVar arrRegexDef = m$.var("arrRegexDef");
    mVar blnError = m$.var("blnError");
    mVar blnIsRule = m$.var("blnIsRule");
    mVar intArrMaskTableLength = m$.var("intArrMaskTableLength");
    m$.newVar(arrRuleTest,arrMaskTable,arrRegexDef,blnError,blnIsRule,intArrMaskTableLength);
    //<< new intArrRuleTestLength,intMaskLength,intState,intStringTokenLength,intValueBegin
    mVar intArrRuleTestLength = m$.var("intArrRuleTestLength");
    mVar intMaskLength = m$.var("intMaskLength");
    mVar intState = m$.var("intState");
    mVar intStringTokenLength = m$.var("intStringTokenLength");
    mVar intValueBegin = m$.var("intValueBegin");
    m$.newVar(intArrRuleTestLength,intMaskLength,intState,intStringTokenLength,intValueBegin);
    //<< new loop,loop2,loop3,strMaskChar,strNewValue,strNumberToken,strRule,strStringToken
    mVar loop = m$.var("loop");
    mVar loop2 = m$.var("loop2");
    mVar loop3 = m$.var("loop3");
    mVar strMaskChar = m$.var("strMaskChar");
    mVar strNewValue = m$.var("strNewValue");
    mVar strNumberToken = m$.var("strNumberToken");
    mVar strRule = m$.var("strRule");
    mVar strStringToken = m$.var("strStringToken");
    m$.newVar(loop,loop2,loop3,strMaskChar,strNewValue,strNumberToken,strRule,strStringToken);
    //<< 
    //<< quit:(pstrMask = "") pstrValue
    if ((mOp.Equal(pstrMask.get(),""))) {
      return pstrValue.get();
    }
    //<< 
    //<< set strRule = "ANE"
    strRule.set("ANE");
    //<< set arrRegexDef("A") = "ABCDEFGHIJKLMNOPQRSTUVXYWZÁÀÃÂÉÈÊÍÌÎÓÒÕÔÚÙÛÇabcdefghijklmnopqrstuvxywzáàãâéèêíìîóòõôúùûç"
    arrRegexDef.var("A").set("ABCDEFGHIJKLMNOPQRSTUVXYWZÁÀÃÂÉÈÊÍÌÎÓÒÕÔÚÙÛÇabcdefghijklmnopqrstuvxywzáàãâéèêíìîóòõôúùûç");
    //<< set arrRegexDef("N") = "0123456789"
    arrRegexDef.var("N").set("0123456789");
    //<< set arrRegexDef("E") = arrRegexDef("A") _ arrRegexDef("N")
    arrRegexDef.var("E").set(mOp.Concat(arrRegexDef.var("A").get(),arrRegexDef.var("N").get()));
    //<< 
    //<< set strNewValue   = ""
    strNewValue.set("");
    //<< set intValueBegin = 0
    intValueBegin.set(0);
    //<< 
    //<< set intArrRuleTestLength  = 0
    intArrRuleTestLength.set(0);
    //<< set intArrMaskTableLength = 0
    intArrMaskTableLength.set(0);
    //<< 
    //<< set intState = 1
    intState.set(1);
    //<< set blnError = $$$NO
    blnError.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set intMaskLength = $length(pstrMask)
    intMaskLength.set(m$.Fnc.$length(pstrMask.get()));
    //<< 
    //<< for loop=1:1:intMaskLength {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),intMaskLength.get()));loop.set(mOp.Add(loop.get(),1))) {
      //<< set strMaskChar = $extract(pstrMask,loop)
      strMaskChar.set(m$.Fnc.$extract(pstrMask.get(),loop.get()));
      //<< if (intState = 1) {
      if ((mOp.Equal(intState.get(),1))) {
        //<< if ($isvalidnum(strMaskChar)) {
        if (mOp.Logical((m$.Fnc.$isvalidnum(strMaskChar.get())))) {
          //<< set strNumberToken = strMaskChar
          strNumberToken.set(strMaskChar.get());
          //<< set intState = 2
          intState.set(2);
        }
        //<< } else {
        else {
          //<< set blnError = $$$YES
          blnError.set(include.COMSYS.$$$YES(m$));
        }
      }
      //<< }
      //<< 
      //<< } elseif (intState = 2) {
      else if ((mOp.Equal(intState.get(),2))) {
        //<< if ($isvalidnum(strMaskChar)) {
        if (mOp.Logical((m$.Fnc.$isvalidnum(strMaskChar.get())))) {
          //<< set strNumberToken = strNumberToken _ strMaskChar
          strNumberToken.set(mOp.Concat(strNumberToken.get(),strMaskChar.get()));
        }
        //<< } else {
        else {
          //<< if ($find(strRule,strMaskChar)) {
          if (mOp.Logical((m$.Fnc.$find(strRule.get(),strMaskChar.get())))) {
            //<< set intState = 1
            intState.set(1);
            //<< for loop2=1:1:strNumberToken {
            for (loop2.set(1);(mOp.LessOrEqual(loop2.get(),strNumberToken.get()));loop2.set(mOp.Add(loop2.get(),1))) {
              //<< set intArrRuleTestLength = intArrRuleTestLength + 1
              intArrRuleTestLength.set(mOp.Add(intArrRuleTestLength.get(),1));
              //<< set arrRuleTest(intArrRuleTestLength) = arrRegexDef(strMaskChar)
              arrRuleTest.var(intArrRuleTestLength.get()).set(arrRegexDef.var(strMaskChar.get()).get());
              //<< 
              //<< set intArrMaskTableLength = intArrMaskTableLength + 1
              intArrMaskTableLength.set(mOp.Add(intArrMaskTableLength.get(),1));
              //<< set arrMaskTable(intArrMaskTableLength, "chr" ) = strMaskChar
              arrMaskTable.var(intArrMaskTableLength.get(),"chr").set(strMaskChar.get());
              //<< set arrMaskTable(intArrMaskTableLength, "mask" )  = 1
              arrMaskTable.var(intArrMaskTableLength.get(),"mask").set(1);
            }
          }
          //<< 
          //<< }
          //<< } else {
          else {
            //<< if (strMaskChar = """") {
            if ((mOp.Equal(strMaskChar.get(),"\""))) {
              //<< set strStringToken = ""
              strStringToken.set("");
              //<< set intState = 4
              intState.set(4);
            }
            //<< } else {
            else {
              //<< set blnError = $$$YES
              blnError.set(include.COMSYS.$$$YES(m$));
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< } elseif (intState = 3) {
      else if ((mOp.Equal(intState.get(),3))) {
        //<< if (strMaskChar = """") {
        if ((mOp.Equal(strMaskChar.get(),"\""))) {
          //<< set intState = 1
          intState.set(1);
          //<< set intStringTokenLength = $length(strStringToken)
          intStringTokenLength.set(m$.Fnc.$length(strStringToken.get()));
          //<< for loop2=1:1:strNumberToken {
          for (loop2.set(1);(mOp.LessOrEqual(loop2.get(),strNumberToken.get()));loop2.set(mOp.Add(loop2.get(),1))) {
            //<< for loop3=1:1:intStringTokenLength {
            for (loop3.set(1);(mOp.LessOrEqual(loop3.get(),intStringTokenLength.get()));loop3.set(mOp.Add(loop3.get(),1))) {
              //<< set intArrMaskTableLength = intArrMaskTableLength + 1
              intArrMaskTableLength.set(mOp.Add(intArrMaskTableLength.get(),1));
              //<< set arrMaskTable(intArrMaskTableLength, "chr") = $extract(strStringToken,loop3)
              arrMaskTable.var(intArrMaskTableLength.get(),"chr").set(m$.Fnc.$extract(strStringToken.get(),loop3.get()));
              //<< set arrMaskTable(intArrMaskTableLength, "mask") = 0
              arrMaskTable.var(intArrMaskTableLength.get(),"mask").set(0);
              //<< 
              //<< set intArrRuleTestLength = intArrRuleTestLength + 1
              intArrRuleTestLength.set(mOp.Add(intArrRuleTestLength.get(),1));
              //<< set arrRuleTest(intArrRuleTestLength) = ""
              arrRuleTest.var(intArrRuleTestLength.get()).set("");
            }
          }
        }
        //<< 
        //<< }
        //<< }
        //<< } else {
        else {
          //<< set strStringToken = strStringToken _ strMaskChar
          strStringToken.set(mOp.Concat(strStringToken.get(),strMaskChar.get()));
        }
      }
      //<< }
      //<< 
      //<< } elseif (intState = 4) {
      else if ((mOp.Equal(intState.get(),4))) {
        //<< set strStringToken = strMaskChar
        strStringToken.set(strMaskChar.get());
        //<< set intState = 3
        intState.set(3);
      }
      //<< }
      //<< 
      //<< if (blnError=$$$YES) {
      if ((mOp.Equal(blnError.get(),include.COMSYS.$$$YES(m$)))) {
        //<< set loop = 99999
        loop.set(99999);
      }
    }
    //<< }
    //<< }
    //<< set strNewValue = ""
    strNewValue.set("");
    //<< set intValueBegin = 1
    intValueBegin.set(1);
    //<< if (blnError=$$$YES) {
    if ((mOp.Equal(blnError.get(),include.COMSYS.$$$YES(m$)))) {
      //<< quit pstrValue                       ; *** EARLY EXIT ***
      return pstrValue.get();
    }
    //<< }
    //<< 
    //<< quit:($length(pstrValue)<=0) pstrValue
    if ((mOp.LessOrEqual(m$.Fnc.$length(pstrValue.get()),0))) {
      return pstrValue.get();
    }
    //<< 
    //<< for loop=1:1:intArrMaskTableLength {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),intArrMaskTableLength.get()));loop.set(mOp.Add(loop.get(),1))) {
      //<< if (arrMaskTable(loop,"mask") = 1 ) {
      if ((mOp.Equal(arrMaskTable.var(loop.get(),"mask").get(),1))) {
        //<< while( ($length(pstrValue) > 0) && '( $find( arrRuleTest(loop),$extract(pstrValue,intValueBegin)) ) ) {
        while (mOp.Logical(((mOp.Greater(m$.Fnc.$length(pstrValue.get()),0)) && mOp.Not((m$.Fnc.$find(arrRuleTest.var(loop.get()).get(),m$.Fnc.$extract(pstrValue.get(),intValueBegin.get()))))))) {
          //<< set pstrValue = $select( ($length(pstrValue) = 0):"",1:$extract(pstrValue,2,999))
          pstrValue.set(m$.Fnc.$select((mOp.Equal(m$.Fnc.$length(pstrValue.get()),0)),"",1,m$.Fnc.$extract(pstrValue.get(),2,999)));
        }
        //<< }
        //<< if ( $length(pstrValue) > 0 ) {
        if ((mOp.Greater(m$.Fnc.$length(pstrValue.get()),0))) {
          //<< set strNewValue = strNewValue _ $extract(pstrValue,intValueBegin)
          strNewValue.set(mOp.Concat(strNewValue.get(),m$.Fnc.$extract(pstrValue.get(),intValueBegin.get())));
          //<< set intValueBegin = intValueBegin + 1
          intValueBegin.set(mOp.Add(intValueBegin.get(),1));
        }
      }
      //<< }
      //<< } else {
      else {
        //<< set strNewValue = strNewValue _ arrMaskTable(loop,"chr")
        strNewValue.set(mOp.Concat(strNewValue.get(),arrMaskTable.var(loop.get(),"chr").get()));
        //<< if ( $extract(pstrValue,intValueBegin) = arrMaskTable(loop,"chr") ) {
        if ((mOp.Equal(m$.Fnc.$extract(pstrValue.get(),intValueBegin.get()),arrMaskTable.var(loop.get(),"chr").get()))) {
          //<< set intValueBegin = intValueBegin + 1
          intValueBegin.set(mOp.Add(intValueBegin.get(),1));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if (intValueBegin > $length(pstrValue)) quit
      if ((mOp.Greater(intValueBegin.get(),m$.Fnc.$length(pstrValue.get())))) {
        break;
      }
      //<< if ($length(pstrValue) = 0) quit
      if ((mOp.Equal(m$.Fnc.$length(pstrValue.get()),0))) {
        break;
      }
    }
    //<< }
    //<< quit strNewValue
    return strNewValue.get();
  }

  //<< 
  //<< 
  //<< ApplyCoreMasking(pintRow,pYFORM,&pYFELD)
  public Object ApplyCoreMasking(Object ... _p) {
    mVar pintRow = m$.newVarRef("pintRow",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;
    //<< ; FIXME : Doesn't permit a custom mask if no core mask exists - See CheckRules^WWWEVENT as well though for custom masks
    //<< ;         ? May be generated separately as part of Core Rules & Custom Rules ?
    //<< ;-------------------------------------------------------------------------------
    //<< ; Apply core masking to grid fields.
    //<< ;
    //<< ; Params:
    //<< ; pintRow: selected Row number
    //<< ; pYFORM : form id.
    //<< ; pYFELD:  data contents.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-May-2009   shobby  SR16534:    Replaced repeated code with a common routine.
    //<< ; 13-Apr-2008   heber   SRBR014932: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idSeqNumber,objWWW122,strMask
    mVar idField = m$.var("idField");
    mVar idSeqNumber = m$.var("idSeqNumber");
    mVar objWWW122 = m$.var("objWWW122");
    mVar strMask = m$.var("strMask");
    m$.newVar(idField,idSeqNumber,objWWW122,strMask);
    //<< 
    //<< // Applies core mask to each form field
    //<< // if there is not a customized mask
    //<< set idField = ""
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField = $order(^WWW122(0,pYFORM,idField))
      idField.set(m$.Fnc.$order(m$.var("^WWW122",0,pYFORM.get(),idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< 
      //<< ;SR17701 set objWWW122=$get(^WWW122(0,pYFORM,idField,1))
      //<< set objWWW122 = $$Get^WWW122(pYFORM,idField)                 ;SR17701
      objWWW122.set(m$.fnc$("WWW122.Get",pYFORM.get(),idField.get()));
      //<< continue:($$$WWW122Mask(objWWW122) = "")  ; no core mask to be applied to the field
      if ((mOp.Equal(include.WWWConst.$$$WWW122Mask(m$,objWWW122),""))) {
        continue;
      }
      //<< ; SR17701 ... or customisation mask.
      //<< 
      //<< ; if no custom mask is defined, apply core mask (SR17701 Actually if no 'rules')
      //<< if ('$$IsMaskable(pYFORM,idField,YM)) { ; check if there is a custom mask
      if ((mOp.Not(m$.fnc$("IsMaskable",pYFORM.get(),idField.get(),m$.var("YM").get())))) {
        //<< set idSeqNumber = $$$WWW122SequenceNumber(objWWW122)
        idSeqNumber.set(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122));
        //<< ;SR17701 set strMask    = $$GetCoreMask^WWWFORM7(pYFELD,"",objWWW122)
        //<< set strMask     = $$$WWW122Mask(objWWW122)               ;SR17701
        strMask.set(include.WWWConst.$$$WWW122Mask(m$,objWWW122));
        //<< set $piece(pYFELD,Y,idSeqNumber) = $$ApplyMask^WWWFORM8($piece(pYFELD,Y,idSeqNumber),strMask)
        m$.pieceVar(pYFELD,m$.var("Y").get(),idSeqNumber.get()).set(m$.fnc$("WWWFORM8.ApplyMask",m$.Fnc.$piece(pYFELD.get(),m$.var("Y").get(),idSeqNumber.get()),strMask.get()));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< JSInitializingMasking(pstrYFELD,pidYFORM)
  public Object JSInitializingMasking(Object ... _p) {
    mVar pstrYFELD = m$.newVarRef("pstrYFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidYFORM = m$.newVarRef("pidYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create and load initial mask variables using javascript.
    //<< ; If a field can eventually be maskable, the mask variable is created.
    //<< ;
    //<< ; Parameters:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Apr-2011   shobby  SR17701: Use $$Get^WWW122 to include customisation.
    //<< ; 22-Oct-2010   GRF     SR17514: Incorrect parentheses placement in IF test
    //<< ; 28-May-2009   shobby  SR16534: Replaced repeated code with a common routine.
    //<< ; 30-May-2008   heber   SRBR014945: enable date masking on manual forms
    //<< ; 22-Jan-2008   heber   SRBR014794: test whether general date masking is to be
    //<< ;                           applied, get obj WWW012
    //<< ; 21-Jan-2008   GRF     SRBR014794:date issue; newed variables
    //<< ; 04-Jan-2008   HeberB  SRBR014794:Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnHidden,blnMandatory,blnReadOnly,blnToMask,blnUseValueOfDataField
    mVar blnHidden = m$.var("blnHidden");
    mVar blnMandatory = m$.var("blnMandatory");
    mVar blnReadOnly = m$.var("blnReadOnly");
    mVar blnToMask = m$.var("blnToMask");
    mVar blnUseValueOfDataField = m$.var("blnUseValueOfDataField");
    m$.newVar(blnHidden,blnMandatory,blnReadOnly,blnToMask,blnUseValueOfDataField);
    //<< new idClass,idData,idYBBN,ind,intColour,objWWW003,objWWW012,objWWW122
    mVar idClass = m$.var("idClass");
    mVar idData = m$.var("idData");
    mVar idYBBN = m$.var("idYBBN");
    mVar ind = m$.var("ind");
    mVar intColour = m$.var("intColour");
    mVar objWWW003 = m$.var("objWWW003");
    mVar objWWW012 = m$.var("objWWW012");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(idClass,idData,idYBBN,ind,intColour,objWWW003,objWWW012,objWWW122);
    //<< new strChar,strDate,strDateMask,strJSMaskedFieldName,strMask
    mVar strChar = m$.var("strChar");
    mVar strDate = m$.var("strDate");
    mVar strDateMask = m$.var("strDateMask");
    mVar strJSMaskedFieldName = m$.var("strJSMaskedFieldName");
    mVar strMask = m$.var("strMask");
    m$.newVar(strChar,strDate,strDateMask,strJSMaskedFieldName,strMask);
    //<< new strNewFieldColor,strRelationClass,strRelationKeys,strRuleField
    mVar strNewFieldColor = m$.var("strNewFieldColor");
    mVar strRelationClass = m$.var("strRelationClass");
    mVar strRelationKeys = m$.var("strRelationKeys");
    mVar strRuleField = m$.var("strRuleField");
    m$.newVar(strNewFieldColor,strRelationClass,strRelationKeys,strRuleField);
    //<< 
    //<< set objWWW012 = $get(^WWW012(0,0,1))
    objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
    //<< 
    //<< ; Use this temp global to hold which fields are maskable. Later is
    //<< ; used to include call to doMasking javascript function on OnKeyUp event
    //<< kill ^CacheTempMasking(YUSER,YUCI,pidYFORM)
    m$.var("^CacheTempMasking",m$.var("YUSER").get(),m$.var("YUCI").get(),pidYFORM.get()).kill();
    //<< 
    //<< set intColour = ""
    intColour.set("");
    //<< set idClass = $$$WWW120ClassUsedInForm($get(^WWW120(0,pidYFORM,1)))
    idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,pidYFORM.get(),1))));
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< set idYBBN = ""
    idYBBN.set("");
    //<< 
    //<< for {
    for (;true;) {
      //<< set idYBBN = $order(^WWW122(0,pidYFORM,idYBBN))
      idYBBN.set(m$.Fnc.$order(m$.var("^WWW122",0,pidYFORM.get(),idYBBN.get())));
      //<< quit:idYBBN=""
      if (mOp.Equal(idYBBN.get(),"")) {
        break;
      }
      //<< 
      //<< set ^CacheTempMasking(YUSER,YUCI,pidYFORM,idYBBN)= $$$NO
      m$.var("^CacheTempMasking",m$.var("YUSER").get(),m$.var("YUCI").get(),pidYFORM.get(),idYBBN.get()).set(include.COMSYS.$$$NO(m$));
      //<< 
      //<< ;-----------------------------------
      //<< ;  Only mask...
      //<< ;    "D" fields     if Text or Date type
      //<< ;    "M" fields     if Text or Date type
      //<< ;-----------------------------------
      //<< set objWWW003 = ""
      objWWW003.set("");
      //<< ; SR17701 set objWWW122 = $get(^WWW122(0,pidYFORM,idYBBN,1))
      //<< set objWWW122=$$Get^WWW122(pidYFORM,idYBBN)     ;SR17701
      objWWW122.set(m$.fnc$("WWW122.Get",pidYFORM.get(),idYBBN.get()));
      //<< set blnToMask = $$$NO
      blnToMask.set(include.COMSYS.$$$NO(m$));
      //<< set idData    = $$$WWW122SequenceNumber(objWWW122)
      idData.set(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122));
      //<< 
      //<< if (idData '= "") {
      if ((mOp.NotEqual(idData.get(),""))) {
        //<< set objWWW003 = $get(^WWW003(0,idClass,idData,1))
        objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,idClass.get(),idData.get(),1)));
        //<< set blnToMask = $$$IsToMask("D",$$$WWW003InputType(objWWW003))
        blnToMask.set(include.COMSYSWWW.$$$IsToMask(m$,"D",include.WWWConst.$$$WWW003InputType(m$,objWWW003)));
      }
      //<< 
      //<< } else {
      else {
        //<< set blnToMask = ($$$WWW122DataInputType(objWWW122) = 1)
        blnToMask.set((mOp.Equal(include.WWWConst.$$$WWW122DataInputType(m$,objWWW122),1)));
        //<< ; apply mask also if date or text manual field
        //<< if 'blnToMask && ($$$WWW122InputType(objWWW122) '= "") {
        if (mOp.Not(blnToMask.get()) && (mOp.NotEqual(include.WWWConst.$$$WWW122InputType(m$,objWWW122),""))) {
          //<< set blnToMask = (($$$WWW122InputType(objWWW122) = 1) || ($$$WWW122InputType(objWWW122) = 6))
          blnToMask.set(((mOp.Equal(include.WWWConst.$$$WWW122InputType(m$,objWWW122),1)) || (mOp.Equal(include.WWWConst.$$$WWW122InputType(m$,objWWW122),6))));
        }
      }
      //<< }
      //<< }
      //<< continue:'(blnToMask)
      if (mOp.Not((blnToMask.get()))) {
        continue;
      }
      //<< 
      //<< ;-----------------------------------
      //<< 
      //<< ; A field is maskable if is date type or has fields WWW122Mask or WWW122D2ApplyMask filled
      //<< 
      //<< ;-----------------------------------
      //<< ; Check if masked on form : WWW122
      //<< ;-----------------------------------
      //<< set strMask   = ""
      strMask.set("");
      //<< ;SR17701 set blnToMask = $$$NO
      //<< 
      //<< set strMask   = $$$WWW122Mask(objWWW122)      ;SR17701
      strMask.set(include.WWWConst.$$$WWW122Mask(m$,objWWW122));
      //<< set blnToMask = (strMask'="")                 ;SR17701
      blnToMask.set((mOp.NotEqual(strMask.get(),"")));
      //<< ;SR17701 if ($$$WWW122Mask(objWWW122) '= "") {
      //<< ;SR17701 ; 2nd parameter blank since this is initial form loading, so there
      //<< ;SR17701 ; is no values on manual fields....except if default loading
      //<< ;SR17701 set strMask   = $$GetCoreMask^WWWFORM7(pstrYFELD,"",objWWW122)
      //<< ;SR17701 set blnToMask = $$$YES
      //<< ;SR17701 }
      //<< 
      //<< ; Get 'rules' mask ;SR17701
      //<< if ($$IsMaskable(pidYFORM,idYBBN,YM)) {
      if (mOp.Logical((m$.fnc$("IsMaskable",pidYFORM.get(),idYBBN.get(),m$.var("YM").get())))) {
        //<< set strMask = ""
        strMask.set("");
        //<< do CheckRules^WWWFORMD(pidYFORM,idYBBN,.pstrYFELD,.blnHidden,.blnReadOnly,
        //<< .intColour,.blnMandatory,$$$YES,.strNewFieldColor,.strRelationClass,
        //<< .strRelationKeys,.blnUseValueOfDataField,.strRuleField,.strMask)
        m$.Cmd.Do("WWWFORMD.CheckRules",pidYFORM.get(),idYBBN.get(),pstrYFELD,blnHidden,blnReadOnly,intColour,blnMandatory,include.COMSYS.$$$YES(m$),strNewFieldColor,strRelationClass,strRelationKeys,blnUseValueOfDataField,strRuleField,strMask);
        //<< set blnToMask = $$$YES
        blnToMask.set(include.COMSYS.$$$YES(m$));
      }
      //<< }
      //<< 
      //<< ;-----------------------------------
      //<< ;  1. Do we have an explicit mask for DATE data?
      //<< ;       - use specified mask.
      //<< ;  2. If not, is the Apply General Date Masking switch set?
      //<< ;       - will apply a mask based on the user's literal format.
      //<< ;  3. If still not,
      //<< ;       - interpret special codes such as "." for today, "+int" and "-int"
      //<< ;         and the ability to skip leading zeros in the day or month or the
      //<< ;         ability to enter a two digit date.  (e.g. 1/5/08 => 01/05/2008)
      //<< ;-----------------------------------
      //<< ; testing date mask on manual forms
      //<< ;   if (('blnToMask) && ($$$WWW003InputType(objWWW003) = 1)) {
      //<< ;   if (('blnToMask) && ( ($$$WWW003InputType(objWWW003) = 1))||($$$WWW122InputType(objWWW122) = 1) ) {  ; SR17514
      //<< if 'blnToMask &&
      //<< (($$$WWW003InputType(objWWW003) = 1) || ($$$WWW122InputType(objWWW122) = 1)) {
      if (mOp.Not(blnToMask.get()) && mOp.Logical(((mOp.Equal(include.WWWConst.$$$WWW003InputType(m$,objWWW003),1)) || (mOp.Equal(include.WWWConst.$$$WWW122InputType(m$,objWWW122),1))))) {
        //<< 
        //<< if ($$$WWW012ApplyGeneralDateMasking(objWWW012)) {
        if (mOp.Logical((include.WWWConst.$$$WWW012ApplyGeneralDateMasking(m$,objWWW012)))) {
          //<< set blnToMask = $$$YES
          blnToMask.set(include.COMSYS.$$$YES(m$));
          //<< set strMask = $$GetDateMask()
          strMask.set(m$.fnc$("GetDateMask"));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< // If a defined mask was found
      //<< if blnToMask {
      if (mOp.Logical(blnToMask.get())) {
        //<< set strJSMaskedFieldName = $$GetMaskVarName(pidYFORM, idYBBN)
        strJSMaskedFieldName.set(m$.fnc$("GetMaskVarName",pidYFORM.get(),idYBBN.get()));
        //<< ; if there field is maskable, its var mask must be declared, even if current mask is empty
        //<< write "var "_strJSMaskedFieldName_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("var ",strJSMaskedFieldName.get()),";"));
        //<< write strJSMaskedFieldName_" = """_$zconvert(strMask,"O","JS")_""";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(strJSMaskedFieldName.get()," = \""),m$.Fnc.$zconvert(strMask.get(),"O","JS")),"\";"));
        //<< ; hold field information to later use - include call to do masking onKeyUp
        //<< set ^CacheTempMasking(YUSER,YUCI,pidYFORM,idYBBN)= $$$YES
        m$.var("^CacheTempMasking",m$.var("YUSER").get(),m$.var("YUCI").get(),pidYFORM.get(),idYBBN.get()).set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< IsMaskable(pYFORM,pidField,pYM)
  public Object IsMaskable(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Replaced repeated code with a common routine.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-May-2009   shobby  SR16534: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrRules,blnMaskable,idRule,objRule
    mVar arrRules = m$.var("arrRules");
    mVar blnMaskable = m$.var("blnMaskable");
    mVar idRule = m$.var("idRule");
    mVar objRule = m$.var("objRule");
    m$.newVar(arrRules,blnMaskable,idRule,objRule);
    //<< 
    //<< do GetRules^WWWFORMD(.arrRules,pYFORM,pidField,pYM)
    m$.Cmd.Do("WWWFORMD.GetRules",arrRules,pYFORM.get(),pidField.get(),pYM.get());
    //<< set blnMaskable = $$$NO
    blnMaskable.set(include.COMSYS.$$$NO(m$));
    //<< set idRule = ""
    idRule.set("");
    //<< for {
    for (;true;) {
      //<< set idRule = $order(arrRules(idRule))
      idRule.set(m$.Fnc.$order(arrRules.var(idRule.get())));
      //<< quit:idRule=""
      if (mOp.Equal(idRule.get(),"")) {
        break;
      }
      //<< 
      //<< set objRule = $get(arrRules(idRule,1))
      objRule.set(m$.Fnc.$get(arrRules.var(idRule.get(),1)));
      //<< if ($$$WWW122D2ApplyMask(objRule) '= "") {
      if ((mOp.NotEqual(include.WWWConst.$$$WWW122D2ApplyMask(m$,objRule),""))) {
        //<< set blnMaskable = $$$YES
        blnMaskable.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnMaskable
    return blnMaskable.get();
  }

  //<< 
  //<< 
  //<< GetDateMask()
  public Object GetDateMask(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return date format as a mask
    //<< ;
    //<< ; Parameters:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 30-May-2008   heber   SRBR014945: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new loop,strChar,strDate,strDateMask
    mVar loop = m$.var("loop");
    mVar strChar = m$.var("strChar");
    mVar strDate = m$.var("strDate");
    mVar strDateMask = m$.var("strDateMask");
    m$.newVar(loop,strChar,strDate,strDateMask);
    //<< 
    //<< set strDateMask = ""
    strDateMask.set("");
    //<< set strDate = $$^WWWDATE("1")   ; get example date
    strDate.set(m$.fnc$("WWWDATE.main","1"));
    //<< for loop = 1:1 {
    for (loop.set(1);(true);loop.set(mOp.Add(loop.get(),1))) {
      //<< set strChar = $extract(strDate,loop)
      strChar.set(m$.Fnc.$extract(strDate.get(),loop.get()));
      //<< quit:(strChar = "")
      if ((mOp.Equal(strChar.get(),""))) {
        break;
      }
      //<< 
      //<< // add a number
      //<< if ($find("0123456789",strChar) > 0) {
      if ((mOp.Greater(m$.Fnc.$find("0123456789",strChar.get()),0))) {
        //<< set strDateMask = strDateMask _ "1N"
        strDateMask.set(mOp.Concat(strDateMask.get(),"1N"));
      }
      //<< // add a fixed char
      //<< } else {
      else {
        //<< set strDateMask = strDateMask_"1"_""""_strChar_""""
        strDateMask.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strDateMask.get(),"1"),"\""),strChar.get()),"\""));
      }
    }
    //<< }
    //<< }
    //<< quit strDateMask
    return strDateMask.get();
  }

  //<< 
  //<< 
  //<< GetMaskVarName(pidYFORM,pidYBBN)
  public Object GetMaskVarName(Object ... _p) {
    mVar pidYFORM = m$.newVarRef("pidYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidYBBN = m$.newVarRef("pidYBBN",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return mask variable name based on field definition
    //<< ;
    //<< ; Parameters:
    //<< ;
    //<< ; Returns: mask variable name
    //<< ;
    //<< ; History:
    //<< ; 04-Jan-2008   HeberB  SRBR014794: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW122,strVarName
    mVar objWWW122 = m$.var("objWWW122");
    mVar strVarName = m$.var("strVarName");
    m$.newVar(objWWW122,strVarName);
    //<< 
    //<< set objWWW122 = $get(^WWW122(0,pidYFORM,pidYBBN,1))
    objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,pidYFORM.get(),pidYBBN.get(),1)));
    //<< 
    //<< if ($$$WWW122SequenceNumber(objWWW122) = "") {         ; manual field
    if ((mOp.Equal(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122),""))) {
      //<< set strVarName = "Y"_pidYFORM_"M"_pidYBBN_"mask"
      strVarName.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",pidYFORM.get()),"M"),pidYBBN.get()),"mask"));
    }
    //<< 
    //<< } else {                                               ; data field
    else {
      //<< set strVarName = "Y"_pidYFORM_"D"_pidYBBN_"mask"
      strVarName.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",pidYFORM.get()),"D"),pidYBBN.get()),"mask"));
    }
    //<< }
    //<< quit strVarName
    return strVarName.get();
  }

  //<< 
  //<< 
  //<< GetFieldName(pidYFORM,pidYBBN)
  public Object GetFieldName(Object ... _p) {
    mVar pidYFORM = m$.newVarRef("pidYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidYBBN = m$.newVarRef("pidYBBN",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return field name based on field definition
    //<< ;
    //<< ; Parameters:
    //<< ;
    //<< ; Returns: Bollean indicating the JS Masking code is to be added
    //<< ;
    //<< ; History:
    //<< ; 29-Jun-2008   shobby  SRBR014794:For data fields should use the SequenceNumber
    //<< ; 04-Jan-2008   HeberB  SRBR014794:Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW122,strVarName
    mVar objWWW122 = m$.var("objWWW122");
    mVar strVarName = m$.var("strVarName");
    m$.newVar(objWWW122,strVarName);
    //<< 
    //<< set objWWW122 = $get(^WWW122(0,pidYFORM,pidYBBN,1))
    objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,pidYFORM.get(),pidYBBN.get(),1)));
    //<< 
    //<< if ($$$WWW122SequenceNumber(objWWW122) = "") {              ; manual field
    if ((mOp.Equal(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122),""))) {
      //<< set strVarName = "document.WWW2.Y"_pidYFORM_"M"_pidYBBN
      strVarName.set(mOp.Concat(mOp.Concat(mOp.Concat("document.WWW2.Y",pidYFORM.get()),"M"),pidYBBN.get()));
    }
    //<< 
    //<< } else {                                                    ; data field
    else {
      //<< set strVarName = "document.WWW2.Y"_pidYFORM_"D"_$$$WWW122SequenceNumber(objWWW122)
      strVarName.set(mOp.Concat(mOp.Concat(mOp.Concat("document.WWW2.Y",pidYFORM.get()),"D"),include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122)));
    }
    //<< }
    //<< quit strVarName
    return strVarName.get();
  }

//<< 
//<< 
}
