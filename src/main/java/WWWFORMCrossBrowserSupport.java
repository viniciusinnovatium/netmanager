//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMCrossBrowserSupport
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:01
//*****************************************************************************

import mLibrary.*;

//<< 
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

//<< WWWFORMCrossBrowserSupport
public class WWWFORMCrossBrowserSupport extends mClass {

  public void main() {
    _WWWFORMCrossBrowserSupport();
  }

  public void _WWWFORMCrossBrowserSupport() {
  }

  //<< 
  //<< ;  Refer to:  http://www.reloco.com.ar/mozilla/compat.html
  //<< ;  and        https://developer.mozilla.org/en/Migrate_apps_from_Internet_Explorer_to_Mozilla
  //<< ;
  //<< ;                          Differences in the event object properties/methods
  //<< ;
  //<< ;  * - Fixed
  //<< ;----------------------------------------------------------------------------------------------------------------
  //<< ;  In Explorer    |  Description                |  In Firefox (W3C standard)                                    |
  //<< ;-----------------+-----------------------------+----------------------------------------------------------------
  //<< ; srcElement      | The element which fired the | target, but in Firefox the nodes of type text can also fire   |
  //<< ;   (102)         | the event.                  | events, so to keep things working you"ll need to climb up the |
  //<< ;                 |                             | tree until you find a element"s (tag's) node:                 |
  //<< ;                 |                             |       var node = e.target;                                    |
  //<< ;                 |                             |       while(node.nodeType != node.ELEMENT_NODE)               |
  //<< ;                 |                             |          node = node.parentNode;                              |
  //<< ;                 |                             |                                                               |
  //<< ;                 |                             | Change:                                                       |
  //<< ;                 |                             |   New function using getter/setter                            |                                                   |
  //<< ;-----------------+-----------------------------+----------------------------------------------------------------
  //<< ; *fromElement    | The element in which the    | target if the event is onmouseout, relatedTarget if the event |
  //<< ;   (2)           | mouse was before.           | is to onmouseover.                                            |
  //<< ;-----------------+-----------------------------+----------------------------------------------------------------
  //<< ; *toElement      | The element to which the    | relatedTarget if the event is onmouseout,                     |
  //<< ;   (3)           | mouse was moved.            | target if the event is onmouseover.                           |
  //<< ;-----------------+-----------------------------+----------------------------------------------------------------
  //<< ; *parentElement  | Retrieves the parent        | parentNode                                                    |
  //<< ;   (23)          | object in the object        | Retrieves the parent object in the document hierarchy.        |
  //<< ;                 | hierarchy.                  |                                                               |
  //<< ;-----------------+-----------------------------+----------------------------------------------------------------
  //<< ; *font-face      | Doesn't seem to be valid    | Removed all instances                                         |
  //<< ;                 | maybe something left over   |                                                               |
  //<< ;                 | from HTML 3.x               |                                                               |
  //<< ;-----------------+-----------------------------+----------------------------------------------------------------
  //<< ; *z-index='1';   | Should be a number          | z-index=1;                                                    |
  //<< ;-----------------+-----------------------------+----------------------------------------------------------------
  //<< ; *cursor:hand;   | Change will fail for IE5    | cursor:pointer;                                               |
  //<< ;-----------------+-----------------------------+----------------------------------------------------------------
  //<< ; *.gradient      | transition of colours in    | $$ImageTransformGradient has Mozilla and Chrome equivalents   |
  //<< ;                 | headers                     |                                                               |
  //<< ;-----------------+-----------------------------+----------------------------------------------------------------
  //<< ; *backgroundcolor| incorrectly defined in      | backgroundcolor                                               |
  //<< ;                 | Style Sheet.                |                                                               |
  //<< ;-----------------+-----------------------------+----------------------------------------------------------------
  //<< ; *onfocusin      |                             | focusin                                                       |
  //<< ;-----------------+-----------------------------+----------------------------------------------------------------
  //<< 
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Font webdings                     -> Not supported, use unicode charaters up=&#9650, right=&#9658, down=&#9660 and left=&#9668
  //<< ; insertAdjacentElement             ->  doInsertAdjacentElement
  //<< ; createPopup
  //<< ; window.event              (300)   -> Needs the event passed in as a parameter
  //<< ;                                      e.g. function xxx(evt) { var evt = window.event ? window.event : evt; ...
  //<< ;                                      e.g. function xxx(evt) { if (!evt) evt=window.event; ...
  //<< ; event.srcElement                  -> event.Target (Mozilla)
  //<< ; detachEvent               (32)    ->
  //<< ; el=currentHeader().cells  (2)     ->el=currentHeader().rows[0].cells
  //<< ; objDiv                            -> objDIV  (**** Note.  Firefox is case sensitive when using ids of objects IE isn't)
  //<< ;
  //<< ; NAME                              -> Objects should have an ID not just a name.
  //<< ;
  //<< ; getAttribute          ?????       -> Works a bit different IE vs Mozilla (eg object.style returns an object in IE and a string in Firefox)
  //<< ; setAttribute          ?????
  //<< ;
  //<< ; window.frames?
  //<< ;
  //<< ; OuterHTML                 (19)    -> change....   document.getElementById('cgePopup').outerHTML='';
  //<< ;                                       to........  document.getElementById('cgePopup').parentNode.removeChild(document.getElementById('cgePopup'));
  //<< ; InnerHTML         ?               ( also see firstChild)
  //<< ; innertText   ????                 -> TextContent
  //<< ; outerText    ????                 ->
  //<< ;
  //<< ; commonfunctions.js (DynTable functions) ?????
  //<< ; tablelayout-fixed     ?????       -> Doesn't work in Firefox.
  //<< ; VBScript                  (12)    -> ?????
  //<< ; Modal Window ??? - From Andre (Firefox may now support)
  //<< ; setCapture                        SR17286 - doSetCapture     function (here) no longer required
  //<< ; releaseCapture                    SR17286 - doReleaseCapture function (here) no longer required
  //<< ;                                   ->  [ if (el.setCapture) el.setCapture(); ] (ditto releaseCapture)
  //<< ;
  //<< ; eventbrokeren1.js                 -> Changes to pass event as a parameter.
  //<< ;                                   -> Moved a heap of functions into WWWFORMButtonScript.MAC
  //<< ;
  //<< ; expression (e.g. height:expression(gridDIV.clientHeight-gridbodyDIV.offsetTop);)
  //<< ;                                   -> can specify hard-coded value followed by expression.
  //<< ;                                   FF uses hard-coded value and ignores expression
  //<< ;                                   IE over-rides hard-coded walue with expression.
  //<< ;                                   Hard-coded value may give more restricted operation.
  //<< ;
  //<< ; firstChild, lastChild, child[]    IE does not include white space characters between elements as
  //<< ;                                   a text nodes, while other browsers do, and since text nodes are
  //<< ;                                   considered to be children of an element a reference to
  //<< ;                                   firstChild, etc. can be pointing to a different element in FF
  //<< ;                                   to MSIE.  see cgeUpdateValue in CGE31J4 for an example of fix.
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< Gray(pstrValue)
  public Object Gray(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$Gray^WWWFORMCrossBrowserSupportVisual(pstrValue)
    return m$.fnc$("WWWFORMCrossBrowserSupportVisual.Gray",pstrValue.get());
  }

  //<< 
  //<< SetupStyle()
  public Object SetupStyle(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Here various styles can be inserted that override the various defaults that are
    //<< ; in different browsers so that the same visual appearance can be achieved.
    //<< ; eg.  default padding for IE is 0px but for FF is 1px.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-May-2013   shobby      CORE-81: MegaMenu only for -moz-box-sizing
    //<< ; 19-Mar-2013   shobby      CORE-75: default sizing in FF to same as IE
    //<< ; 18-Aug-2011   shobby      SR17871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;SR17898
    //<< 
    //<< &html<
    //<< <style>
    //<< input,th,td,tr,tbody {
    //<< padding:0px;
    //<< margin:0px;
    //<< }
    //<< tbody {
    //<< border:1px inset white;
    //<< }
    //<< </style>
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("        <style>","\n");
    m$.Cmd.WriteHtml("        input,th,td,tr,tbody {","\n");
    m$.Cmd.WriteHtml("            padding:0px;","\n");
    m$.Cmd.WriteHtml("            margin:0px;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        tbody {","\n");
    m$.Cmd.WriteHtml("            border:1px inset white;","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        </style>","\n");
    m$.Cmd.WriteHtml("    ");
    //<< if ($$$WWW013MenuType($get(^WWW013(0,YBED,1)))'=13) { ;MegaMenu
    if ((mOp.NotEqual(include.WWWConst.$$$WWW013MenuType(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))),13))) {
      //<< &html<
      //<< <style>
      //<< div {
      //<< -moz-box-sizing:border-box;
      //<< }
      //<< </style>
      //<< >
      m$.Cmd.WriteHtml("","\n");
      m$.Cmd.WriteHtml("            <style>","\n");
      m$.Cmd.WriteHtml("            div {","\n");
      m$.Cmd.WriteHtml("                -moz-box-sizing:border-box;","\n");
      m$.Cmd.WriteHtml("            }","\n");
      m$.Cmd.WriteHtml("            </style>","\n");
      m$.Cmd.WriteHtml("        ");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< Setup()
  public Object Setup(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; FIXME : Note - comments within &js<  ...  >  will be output with code.
    //<< ;         Preferred option is to keep them outside - perhaps restarting &js for
    //<< ;         each function.  (see write commands in .INT version for examples)
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Mar-2011   shobby  SR17678.2: changed doSetDisplay to remove table-cell
    //<< ; 09-Mar-2011   GRF     SR17678: extend getBrowser to optionally include
    //<< ;                           IE version; use in doSetDisplay
    //<< ; 18-Feb-2011   shobby  SR17663: New function isFF. Call out to Clipboard
    //<< ; 09-Dec-2010   shobby  SR17521: Corrected an issue where 'select' controls
    //<< ;                           would be skipped in TabToNextField.
    //<< ; 06-Sep-2010   shobby  SR17449: Changes to make enter key work like tab in FF.
    //<< ; 11-Aug-2010   shobby  SR17445: Need a Columns property on the popup menu.
    //<< ; 04-Aug-2010   shobby  SR17361: DataTransfer and DragDrop additions no longer
    //<< ;                           required.
    //<< ; 27-Jul-2010   shobby  SR17457: Created a document.frames functionality.
    //<< ; 26-Jul-2010   shobby  SR17447: If the passed in control name doesn't exist,
    //<< ;                           just use the standard showModalDialog.  Looks like
    //<< ;                           the special managing of the return value is only
    //<< ;                           necessary when the popup comes from COMView.
    //<< ; 22-Jul-2010   shobby  SR17448: FireEvent.
    //<< ; 21-Jul-2010   shobby  SR17447: Wrapper for window.showModalDialog.
    //<< ;   http://cdmckay.org/blog/2009/07/07/how-to-kinda-fix-firefoxs-showmodaldialog/
    //<< ;                           in firefox doesn't support all parameters
    //<< ;                           (resizable/scrollbar/etc)
    //<< ; 21-Jul-2010   shobby  SR17322: Wrapper for getElementById
    //<< ; 19-Jul-2010   shobby  SR17425: getter/setter for document.all
    //<< ; 19-Jul-2010   shobby  SR17329: relocated the window.createPopup function.
    //<< ; 19-Jul-2010   shobby  SR17430: Corrections in attachEvent for the resize event.
    //<< ; 16-Jul-2010   shobby  SR17322: Removed onhelp hack in attachEvent/detachEvent.
    //<< ; 16-Jul-2010   shobby  SR17439: Removed eventsrcElement.
    //<< ; 13-Jul-2010   shobby  SR17340: Looks like in Firefox onresize only works when
    //<< ;                           the object size changes whereas in IE position will
    //<< ;                           trigger the event as well.
    //<< ; 12-Jul-2010   shobby  SR17411: Remove setInnerText/getInnerText
    //<< ; 29-Jun-2010   FIS     SR17389: window createpopup js error fix
    //<< ; 24-Jun-2010   shobby  SR17362: Created an onresize event to allow firefox to place
    //<< ;                           and size controls based on resizing screen and elements.
    //<< ; 08-Jun-2010   shobby  SR17354: Simulate a losecapture type event for Firefox.
    //<< ; 04-Jun-2010   shobby  SR17339: Removed doClearOuterHTML function and replaced
    //<< ;                           with new getter/setter for outerHTML
    //<< ; 24-May-2010   FIS     SR17322: catch onhelp in firefox
    //<< ; 20-May-2010   FIS     SR17253: bugfix in doInsertAdjacentElement
    //<< ; 18-May-2010   GRF     SR17286.2: deprecated functions commented - doSetCapture,
    //<< ;                           doReleaseCapture, doMouseMoveCapture
    //<< ; 17-May-2010   shobby  SR17253: setInnerText
    //<< ; 14-May-2010   FIS     SR17253: createPopup function
    //<< ; 14-May-2010   shobby  SR17253: doGetMouseButton received in email from Carlos.
    //<< ; 06-May-2010   GRF     SR17286.1: Don't repeat original object when processing
    //<< ;                           parent objects; set up different setCapture and
    //<< ;                           releaseCapture code for different calls.
    //<< ; 05-May-2010   GRF     SR17286: edit doMouseMoveCapture to call gridDoResize &
    //<< ;                           comment .style.top line
    //<< ; 09-Apr-2010   shobby  SR17253: Created
    //<< ;-------------------------------------------------------------------------------
    //<< &js<
    //<< var capturing;
    //<< var objMoving;
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("    var capturing;","\n");
    m$.Cmd.WriteJS("    var objMoving;","\n");
    m$.Cmd.WriteJS("    ");
    //<< 
    //<< ;---------------------------------------
    //<< ; Capturable Events
    //<< ;   MSIE : attachEvent, detachEvent (requires "on" prefix to event name)
    //<< ;   FireFox, Opera, Safari : addEventListener, removeEventListener
    //<< ;
    //<< ; click, dblclick, mousedown, mouseup, mousemove, mouseout, mouseover, losecapture
    //<< ;---------------------------------------
    //<< 
    //<< &js<
    //<< // ************************ Element *************************************
    //<< function doInsertAdjacentElement(pObject,pstrWhere,pInsert) {
    //<< if (pObject.insertAdjacentElement) {
    //<< pObject.insertAdjacentElement(pstrWhere,pInsert)
    //<< } else {
    //<< switch(pstrWhere) {
    //<< case "BeforeBegin":
    //<< //  TODO. Why doesnt the following work (possibly needed document.getElementById for pObject when called)
    //<< pObject.parentNode.insertBefore(pInsert, pObject);
    //<< break;
    //<< case "AfterEnd":            //SR17267
    //<< pObject.parentNode.insertBefore(pInsert, pObject.nextSibling);
    //<< }
    //<< }
    //<< }
    //<< 
    //<< function windowclosePopup() {  //SR17389
    //<< if (document.getElementById('popup-div')) document.getElementById('popup-div').hide();
    //<< }
    //<< 
    //<< function doGetAttribute(pobject,pstrType) {
    //<< alert(typename(pobject.getAttribute(pstrType)));
    //<< }
    //<< 
    //<< function doSetDisplay(pObject,pstrDisplay) {
    //<< if (getBrowser(true)!='IE7') {       //SR17678
    //<< if (pstrDisplay=='inline') {
    //<< pstrDisplay='inline-table';  //SR17678.2 (was table-cell for FF and inline-table for IE8)
    //<< }
    //<< }
    //<< pObject.style.display=pstrDisplay;
    //<< }
    //<< 
    //<< 
    //<< function doGetMouseButton(event) {
    //<< var button;
    //<< if (event.which == null) {
    //<< // IE
    //<< button=(event.button == 1) ? "LEFT" :
    //<< ((event.button == 4) ? "MIDDLE" : "RIGHT");
    //<< } else {
    //<< // Other browsers
    //<< button=(event.which == 1) ? "LEFT" :
    //<< ((event.which == 2) ? "MIDDLE" : "RIGHT");
    //<< }
    //<< return button;
    //<< }
    //<< 
    //<< function isIE() { return #(YUSERAGENT="MSIE")#; }
    //<< function isFF() { return #(YUSERAGENT="GECKO")#; } //SR17663
    //<< function isCH() { return #(YUSERAGENT="CHROME")#; } //SR17663
    //<< 
    //<< function getBrowser(blnAddVersion) {
    //<< if (#($get(YUSERAGENT)="MSIE")#) {
    //<< if (blnAddVersion) {
    //<< if (navigator.userAgent.indexOf("MSIE 7")!=-1) {
    //<< return 'IE7';
    //<< } else if (navigator.userAgent.indexOf("MSIE 8")!=-1) {
    //<< return 'IE8';
    //<< } else if (navigator.userAgent.indexOf("MSIE 9")!=-1) {
    //<< return 'IE9';
    //<< } else {
    //<< return 'IE';
    //<< }
    //<< } else {
    //<< return 'IE';
    //<< }
    //<< } else {
    //<< return '';
    //<< }
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("    // ************************ Element *************************************","\n");
    m$.Cmd.WriteJS("    function doInsertAdjacentElement(pObject,pstrWhere,pInsert) {","\n");
    m$.Cmd.WriteJS("        if (pObject.insertAdjacentElement) {","\n");
    m$.Cmd.WriteJS("            pObject.insertAdjacentElement(pstrWhere,pInsert)","\n");
    m$.Cmd.WriteJS("        } else {","\n");
    m$.Cmd.WriteJS("            switch(pstrWhere) {","\n");
    m$.Cmd.WriteJS("                case \"BeforeBegin\":","\n");
    m$.Cmd.WriteJS("            //  TODO. Why doesnt the following work (possibly needed document.getElementById for pObject when called)","\n");
    m$.Cmd.WriteJS("                    pObject.parentNode.insertBefore(pInsert, pObject);","\n");
    m$.Cmd.WriteJS("                    break;","\n");
    m$.Cmd.WriteJS("                case \"AfterEnd\":            //SR17267","\n");
    m$.Cmd.WriteJS("                    pObject.parentNode.insertBefore(pInsert, pObject.nextSibling);","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    function windowclosePopup() {  //SR17389","\n");
    m$.Cmd.WriteJS("        if (document.getElementById('popup-div')) document.getElementById('popup-div').hide();","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("    function doGetAttribute(pobject,pstrType) {","\n");
    m$.Cmd.WriteJS("        alert(typename(pobject.getAttribute(pstrType)));","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    function doSetDisplay(pObject,pstrDisplay) {","\n");
    m$.Cmd.WriteJS("        if (getBrowser(true)!='IE7') {       //SR17678","\n");
    m$.Cmd.WriteJS("            if (pstrDisplay=='inline') {","\n");
    m$.Cmd.WriteJS("                pstrDisplay='inline-table';  //SR17678.2 (was table-cell for FF and inline-table for IE8)","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        pObject.style.display=pstrDisplay;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    function doGetMouseButton(event) {","\n");
    m$.Cmd.WriteJS("        var button;","\n");
    m$.Cmd.WriteJS("        if (event.which == null) {","\n");
    m$.Cmd.WriteJS("            // IE","\n");
    m$.Cmd.WriteJS("            button=(event.button == 1) ? \"LEFT\" :","\n");
    m$.Cmd.WriteJS("            ((event.button == 4) ? \"MIDDLE\" : \"RIGHT\");","\n");
    m$.Cmd.WriteJS("        } else {","\n");
    m$.Cmd.WriteJS("            // Other browsers","\n");
    m$.Cmd.WriteJS("            button=(event.which == 1) ? \"LEFT\" :","\n");
    m$.Cmd.WriteJS("            ((event.which == 2) ? \"MIDDLE\" : \"RIGHT\");","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        return button;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("    function isIE() { return ",(mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE"))),"); }"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("    function isFF() { return ",(mOp.Equal(m$.var("YUSERAGENT").get(),"GECKO"))),"); } //SR17663"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("    function isCH() { return ",(mOp.Equal(m$.var("YUSERAGENT").get(),"CHROME"))),"); } //SR17663"),"\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    function getBrowser(blnAddVersion) {","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        if (",(mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE"))),")) {"),"\n");
    m$.Cmd.WriteJS("            if (blnAddVersion) {","\n");
    m$.Cmd.WriteJS("                if (navigator.userAgent.indexOf(\"MSIE 7\")!=-1) {","\n");
    m$.Cmd.WriteJS("                    return 'IE7';","\n");
    m$.Cmd.WriteJS("                } else if (navigator.userAgent.indexOf(\"MSIE 8\")!=-1) {","\n");
    m$.Cmd.WriteJS("                    return 'IE8';","\n");
    m$.Cmd.WriteJS("                } else if (navigator.userAgent.indexOf(\"MSIE 9\")!=-1) {","\n");
    m$.Cmd.WriteJS("                    return 'IE9';","\n");
    m$.Cmd.WriteJS("                } else {","\n");
    m$.Cmd.WriteJS("                    return 'IE';","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                return 'IE';","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        } else {","\n");
    m$.Cmd.WriteJS("            return '';","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ");
    //<< if YUSERAGENT'="MSIE" do EmulateIE()
    if (mOp.NotEqual(m$.var("YUSERAGENT").get(),"MSIE")) {
      m$.Cmd.Do("EmulateIE");
    }
    //<< 
    //<< 
    //<< &js<
    //<< //SR17322 var fnSimulatedOnHelp = new Array();
    //<< var cvResizeFunction = new Array();
    //<< var cvResizeWidth = new Array();
    //<< var cvResizeHeight = new Array();
    //<< var cvResizeLeft = new Array();
    //<< var cvResizeTop = new Array();
    //<< 
    //<< function simulatedonresize(elem) {      //SR17362
    //<< var blnResize=true;
    //<< 
    //<< if ((elem!=null) && (elem.id!=null) && (cvResizeFunction[elem.id]!=null)) {
    //<< if (elem.offsetWidth!=cvResizeWidth[elem.id]) {
    //<< } else if (elem.offsetHeight!=cvResizeHeight[elem.id]) {
    //<< } else if (elem.offsetLeft!=cvResizeLeft[elem.id]) {
    //<< } else if (elem.offsetTop!=cvResizeTop[elem.id]) {
    //<< } else {
    //<< blnResize=false;
    //<< }
    //<< if (blnResize) {
    //<< eval(cvResizeFunction[elem.id]);
    //<< cvResizeWidth[elem.id]=elem.offsetWidth;
    //<< cvResizeHeight[elem.id]=elem.offsetHeight;
    //<< cvResizeLeft[elem.id]=elem.offsetLeft;
    //<< cvResizeTop[elem.id]=elem.offsetTop;
    //<< }
    //<< window.setTimeout('simulatedonresize('+elem.id+');',10000);
    //<< }
    //<< }
    //<< 
    //<< function emulateEventHandlers(eventNames) {
    //<< document.addEventListener("click", function(e) {window.event=e;},true);
    //<< document.addEventListener("keydown", function(e) {eventOnKeyDown(e);},true);
    //<< }
    //<< function switchKey(pKey1,pKey2) {           //SR17449
    //<< if (event.keyCode==pKey1) {
    //<< if (isIE()) {
    //<< event.keyCode=pKey2;
    //<< } else {
    //<< //event.srcElement.fireEvent('onKeyDown',pKey2);  //Why doesn't this work?
    //<< if (pKey2==9) tabToNextField();
    //<< }
    //<< }
    //<< }
    //<< var returnKeyHack;
    //<< 
    //<< function tabToNextField() {
    //<< function isDisabled(pobj) {
    //<< returnKeyHack=false;
    //<< var blnDisabled;
    //<< if (pobj.tagName=='SELECT') {
    //<< blnDisabled=pobj.disabled;
    //<< } else if (pobj.tagName=='TEXTAREA') {
    //<< blnDisabled=pobj.readOnly;
    //<< aaaa=true;
    //<< } else {
    //<< blnDisabled=pobj.readOnly;
    //<< }
    //<< return blnDisabled;
    //<< }
    //<< 
    //<< //SR17449
    //<< var el=event.srcElement;
    //<< var els = el.form.elements;
    //<< var intStart=-1;
    //<< var blnFound=false;
    //<< 
    //<< event.cancelBubble=true;
    //<< 
    //<< for (var i=0,len=els.length; i&lt;len; i++){
    //<< if (intStart&gt;-1) {
    //<< //alert(els[i].id+'.'+els[i].tagName+'.'+els[i].disabled+'.'+els[i].readOnly+'::'+!isDisabled(els[i]));
    //<< if ((els[i].id!='')&&(els[i].tabIndex&gt;el.tabIndex)) {
    //<< if ((els[i].focus)&&(!isDisabled(els[i]))) {
    //<< blnFound=true;
    //<< els[i].focus();
    //<< break;
    //<< //i=els.length;
    //<< }
    //<< }
    //<< }
    //<< if (el == els[i]) {
    //<< intStart=i;
    //<< }
    //<< }
    //<< }
    //<< function eventOnKeyDown(e) {
    //<< window.event=e;
    //<< if (e.keyCode==112) {
    //<< e.cancelBubble=true;
    //<< e.returnValue=false;
    //<< if (e.srcElement.id!='') {
    //<< retval = EventValue("#($zu(5))#","#($g(YUSER))#","#($g(YFORM))#","FIX",e.srcElement.id, " ","3","NOVALUE");
    //<< }
    //<< }
    //<< if (typeof(pruef) == 'function') pruef(window.event.keyCode);
    //<< }
    //<< 
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("    //SR17322 var fnSimulatedOnHelp = new Array();","\n");
    m$.Cmd.WriteJS("    var cvResizeFunction = new Array();","\n");
    m$.Cmd.WriteJS("    var cvResizeWidth = new Array();","\n");
    m$.Cmd.WriteJS("    var cvResizeHeight = new Array();","\n");
    m$.Cmd.WriteJS("    var cvResizeLeft = new Array();","\n");
    m$.Cmd.WriteJS("    var cvResizeTop = new Array();","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    function simulatedonresize(elem) {      //SR17362","\n");
    m$.Cmd.WriteJS("        var blnResize=true;","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        if ((elem!=null) && (elem.id!=null) && (cvResizeFunction[elem.id]!=null)) {","\n");
    m$.Cmd.WriteJS("            if (elem.offsetWidth!=cvResizeWidth[elem.id]) {","\n");
    m$.Cmd.WriteJS("            } else if (elem.offsetHeight!=cvResizeHeight[elem.id]) {","\n");
    m$.Cmd.WriteJS("            } else if (elem.offsetLeft!=cvResizeLeft[elem.id]) {","\n");
    m$.Cmd.WriteJS("            } else if (elem.offsetTop!=cvResizeTop[elem.id]) {","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                blnResize=false;","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            if (blnResize) {","\n");
    m$.Cmd.WriteJS("                eval(cvResizeFunction[elem.id]);","\n");
    m$.Cmd.WriteJS("                cvResizeWidth[elem.id]=elem.offsetWidth;","\n");
    m$.Cmd.WriteJS("                cvResizeHeight[elem.id]=elem.offsetHeight;","\n");
    m$.Cmd.WriteJS("                cvResizeLeft[elem.id]=elem.offsetLeft;","\n");
    m$.Cmd.WriteJS("                cvResizeTop[elem.id]=elem.offsetTop;","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            window.setTimeout('simulatedonresize('+elem.id+');',10000);","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    function emulateEventHandlers(eventNames) {","\n");
    m$.Cmd.WriteJS("        document.addEventListener(\"click\", function(e) {window.event=e;},true);","\n");
    m$.Cmd.WriteJS("        document.addEventListener(\"keydown\", function(e) {eventOnKeyDown(e);},true);","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function switchKey(pKey1,pKey2) {           //SR17449","\n");
    m$.Cmd.WriteJS("        if (event.keyCode==pKey1) {","\n");
    m$.Cmd.WriteJS("            if (isIE()) {","\n");
    m$.Cmd.WriteJS("                event.keyCode=pKey2;    ","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                //event.srcElement.fireEvent('onKeyDown',pKey2);  //Why doesn't this work?","\n");
    m$.Cmd.WriteJS("                if (pKey2==9) tabToNextField();","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    var returnKeyHack;","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    function tabToNextField() {","\n");
    m$.Cmd.WriteJS("        function isDisabled(pobj) {","\n");
    m$.Cmd.WriteJS("            returnKeyHack=false;","\n");
    m$.Cmd.WriteJS("            var blnDisabled;","\n");
    m$.Cmd.WriteJS("            if (pobj.tagName=='SELECT') {","\n");
    m$.Cmd.WriteJS("                blnDisabled=pobj.disabled;","\n");
    m$.Cmd.WriteJS("            } else if (pobj.tagName=='TEXTAREA') {","\n");
    m$.Cmd.WriteJS("                blnDisabled=pobj.readOnly;","\n");
    m$.Cmd.WriteJS("                aaaa=true;","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                blnDisabled=pobj.readOnly;","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            return blnDisabled;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        //SR17449","\n");
    m$.Cmd.WriteJS("        var el=event.srcElement;","\n");
    m$.Cmd.WriteJS("        var els = el.form.elements;","\n");
    m$.Cmd.WriteJS("        var intStart=-1;","\n");
    m$.Cmd.WriteJS("        var blnFound=false;","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        event.cancelBubble=true;","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        for (var i=0,len=els.length; i&lt;len; i++){","\n");
    m$.Cmd.WriteJS("            if (intStart&gt;-1) {","\n");
    m$.Cmd.WriteJS("            //alert(els[i].id+'.'+els[i].tagName+'.'+els[i].disabled+'.'+els[i].readOnly+'::'+!isDisabled(els[i]));","\n");
    m$.Cmd.WriteJS("                if ((els[i].id!='')&&(els[i].tabIndex&gt;el.tabIndex)) {","\n");
    m$.Cmd.WriteJS("                    if ((els[i].focus)&&(!isDisabled(els[i]))) {","\n");
    m$.Cmd.WriteJS("                        blnFound=true;","\n");
    m$.Cmd.WriteJS("                        els[i].focus();","\n");
    m$.Cmd.WriteJS("                        break;","\n");
    m$.Cmd.WriteJS("                        //i=els.length;","\n");
    m$.Cmd.WriteJS("                    }","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            if (el == els[i]) {","\n");
    m$.Cmd.WriteJS("                intStart=i;","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }   ","\n");
    m$.Cmd.WriteJS("    function eventOnKeyDown(e) {","\n");
    m$.Cmd.WriteJS("        window.event=e;","\n");
    m$.Cmd.WriteJS("        if (e.keyCode==112) {","\n");
    m$.Cmd.WriteJS("            e.cancelBubble=true;","\n");
    m$.Cmd.WriteJS("            e.returnValue=false;","\n");
    m$.Cmd.WriteJS("            if (e.srcElement.id!='') {","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                retval = EventValue(\"",(m$.Fnc.$zutil(5))),")\",\""),(m$.Fnc.$get(m$.var("YUSER")))),")\",\""),(m$.Fnc.$get(m$.var("YFORM")))),")\",\"FIX\",e.srcElement.id, \" \",\"3\",\"NOVALUE\");"),"\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        if (typeof(pruef) == 'function') pruef(window.event.keyCode);","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    ");
    //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
      //<< &js<
      //<< 
      //<< // if the form has a scan input field, then it should get the focus
      //<< function setFocusScanField() {
      //<< if(document.getElementById('inputdata')) {
      //<< document.getElementById('inputdata').focus();
      //<< }
      //<< }
      //<< window.attachEvent("onload", setFocusScanField);
      //<< 
      //<< >
      m$.Cmd.WriteJS("","\n");
      m$.Cmd.WriteJS("    ","\n");
      m$.Cmd.WriteJS("    // if the form has a scan input field, then it should get the focus","\n");
      m$.Cmd.WriteJS("    function setFocusScanField() {","\n");
      m$.Cmd.WriteJS("        if(document.getElementById('inputdata')) {","\n");
      m$.Cmd.WriteJS("            document.getElementById('inputdata').focus();","\n");
      m$.Cmd.WriteJS("        }","\n");
      m$.Cmd.WriteJS("    }","\n");
      m$.Cmd.WriteJS("    window.attachEvent(\"onload\", setFocusScanField);","\n");
      m$.Cmd.WriteJS("    ","\n");
      m$.Cmd.WriteJS("    ");
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< //>>>>>><<<<<<<<<<
  //<< 
  //<< EmulateIE()
  public Object EmulateIE(Object ... _p) {
    //<< ;   27-Sep-2011     shobby      SR17853: Moved some code to another routine.
    //<< do Setup^WWWFORMCrossBrowserSupportClipboard()  ;SR17663
    m$.Cmd.Do("WWWFORMCrossBrowserSupportClipboard.Setup");
    //<< do Setup^WWWFORMCrossBrowserSupportProperties() ;SR17853
    m$.Cmd.Do("WWWFORMCrossBrowserSupportProperties.Setup");
    //<< do Setup^WWWFORMCrossBrowserSupportEvents()     ;SR17853
    m$.Cmd.Do("WWWFORMCrossBrowserSupportEvents.Setup");
    //<< &js<
    //<< parent.cgeSortColumnAscending = function (a,b) {
    //<< alert('cge');
    //<< }
    //<< 
    //<< window.createPopup=function() {
    //<< var pObject; //SR17329
    //<< 
    //<< pObject=document.createElement('div');
    //<< pObject.setAttribute('id', 'popup-div');
    //<< //pObject.setAttribute('name', 'popup-div');
    //<< pObject.document = new Object();
    //<< pObject.document['body'] = new Object();
    //<< pObject.document.body['style'] = new Object();
    //<< pObject.document.body['innerHTML'] = '';
    //<< pObject.document.body['children'] = new Object();
    //<< pObject.document.body.children[0] = new Object();
    //<< pObject.show = function(x,y,w,h) {
    //<< this.style.left = x ? x : 0;
    //<< this.style.top = y ? y : 0;
    //<< this.style.width = w ? w : 0;
    //<< this.style.height = h ? h : 0;
    //<< this.style.visibility = "visible";
    //<< this.style.position = "absolute";
    //<< //this.style.overflow = "auto";
    //<< this.style.backgroundColor = '#fff';
    //<< this.style.backgroundColor = 'lightgrey'; //SR17445
    //<< this.style.height = -1; //SR17445
    //<< this.style.zIndex = "99999";
    //<< var style = '';
    //<< for(var css in this.document.body['style']) {
    //<< style += css + ':' + this.document.body['style'][css] + '; ';
    //<< }
    //<< this.innerHTML = "<div style='" + style + "'>" + this.document.body['innerHTML'] + "</div>";
    //<< document.body.appendChild(this);
    //<< 
    //<< window.mouseListener = window.mouseListener ? window.mouseListener : document.onmouseup;
    //<< if (window.mouseListener) {
    //<< document.onmouseup = new Function("window.mouseListener(); windowclosePopup(); document.onmouseup = window.mouseListener;");  //SR17389
    //<< }
    //<< else {
    //<< document.onmouseup = windowclosePopup();  //SR17389
    //<< }
    //<< };
    //<< pObject.Columns = pObject; //SR17445
    //<< pObject.hide = function() {
    //<< this.style.visibility = "hidden";
    //<< //document.body.removeChild(this);
    //<< // SR17413 suggested change Carlos 15-Jun : comment window.setTimeout... and uncomment if (document.getElementById('popup-div'))...
    //<< // tried without noticed effect and reverted for now
    //<< //window.setTimeout("if (document.getElementById('popup-div')) document.body.removeChild(document.getElementById('popup-div'))",100);
    //<< if (document.getElementById('popup-div')) document.body.removeChild(document.getElementById('popup-div')); //SR17253
    //<< };
    //<< return pObject;
    //<< }
    //<< 
    //<< //SR17322/SR17455 vvvvv
    //<< document._getElementById = document.getElementById;
    //<< document.getElementById = function(id) {
    //<< var obj=null;
    //<< var obj=document._getElementById(id);
    //<< if (obj==null) obj=document.getElementsByName(id)[0];
    //<< return obj;
    //<< }
    //<< //SR17322/SR17455 ^^^^^
    //<< 
    //<< //SR17447 vvvvv
    //<< window._showModalDialog = window.showModalDialog;
    //<< window.showModalDialog=function(uri,arguments,options) {
    //<< if (uri!=null) {
    //<< var control=uri.split('YLFDAT=')[1];
    //<< }
    //<< if ((control!=null) && (control.split('&')[0]!=null)) control=control.split('&')[0];
    //<< if (document.getElementById(control)!=null) {
    //<< var strInitValue=document.getElementById(control).value;
    //<< var retval=window._showModalDialog(uri,arguments,options);
    //<< if (retval==null) retval=document.getElementById(control).value;
    //<< if (retval==strInitValue) retval=null;
    //<< } else {
    //<< var retval=window._showModalDialog(uri,arguments,options);
    //<< }
    //<< return retval;
    //<< }
    //<< //SR17447 ^^^^^
    //<< 
    //<< var blnClosingWindow=false;
    //<< 
    //<< window._close = window.close;
    //<< window.close1 = function () { //SR17447
    //<< if (this.length==1) top.close();
    //<< return 1;
    //<< }
    //<< 
    //<< 
    //<< //HTMLDocument.prototype.createTextRange = function() {
    //<< //  alert('range');
    //<< //    return this.createRange();
    //<< //};
    //<< //HTMLDocument.prototype.moveToElementText = function(srcObj) {
    //<< //  alert(1);
    //<< //    rangeObj.selectNodeContents(srcObj);
    //<< //};
    //<< emulateEventHandlers(["click"]);
    //<< 
    //<< //>
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("        parent.cgeSortColumnAscending = function (a,b) {","\n");
    m$.Cmd.WriteJS("            alert('cge');","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        window.createPopup=function() {","\n");
    m$.Cmd.WriteJS("            var pObject; //SR17329","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("            pObject=document.createElement('div');","\n");
    m$.Cmd.WriteJS("            pObject.setAttribute('id', 'popup-div');","\n");
    m$.Cmd.WriteJS("            //pObject.setAttribute('name', 'popup-div');","\n");
    m$.Cmd.WriteJS("            pObject.document = new Object();","\n");
    m$.Cmd.WriteJS("            pObject.document['body'] = new Object();","\n");
    m$.Cmd.WriteJS("            pObject.document.body['style'] = new Object();","\n");
    m$.Cmd.WriteJS("            pObject.document.body['innerHTML'] = '';","\n");
    m$.Cmd.WriteJS("            pObject.document.body['children'] = new Object();","\n");
    m$.Cmd.WriteJS("            pObject.document.body.children[0] = new Object();","\n");
    m$.Cmd.WriteJS("            pObject.show = function(x,y,w,h) {","\n");
    m$.Cmd.WriteJS("                this.style.left = x ? x : 0;","\n");
    m$.Cmd.WriteJS("                this.style.top = y ? y : 0;","\n");
    m$.Cmd.WriteJS("                this.style.width = w ? w : 0;","\n");
    m$.Cmd.WriteJS("                this.style.height = h ? h : 0;","\n");
    m$.Cmd.WriteJS("                this.style.visibility = \"visible\";","\n");
    m$.Cmd.WriteJS("                this.style.position = \"absolute\";","\n");
    m$.Cmd.WriteJS("                //this.style.overflow = \"auto\";","\n");
    m$.Cmd.WriteJS("                this.style.backgroundColor = '#fff';","\n");
    m$.Cmd.WriteJS("                this.style.backgroundColor = 'lightgrey'; //SR17445","\n");
    m$.Cmd.WriteJS("                this.style.height = -1; //SR17445","\n");
    m$.Cmd.WriteJS("                this.style.zIndex = \"99999\";","\n");
    m$.Cmd.WriteJS("                var style = '';","\n");
    m$.Cmd.WriteJS("                for(var css in this.document.body['style']) {","\n");
    m$.Cmd.WriteJS("                    style += css + ':' + this.document.body['style'][css] + '; ';","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("                this.innerHTML = \"<div style='\" + style + \"'>\" + this.document.body['innerHTML'] + \"</div>\";","\n");
    m$.Cmd.WriteJS("                document.body.appendChild(this);","\n");
    m$.Cmd.WriteJS("                ","\n");
    m$.Cmd.WriteJS("                window.mouseListener = window.mouseListener ? window.mouseListener : document.onmouseup;","\n");
    m$.Cmd.WriteJS("                if (window.mouseListener) {","\n");
    m$.Cmd.WriteJS("                    document.onmouseup = new Function(\"window.mouseListener(); windowclosePopup(); document.onmouseup = window.mouseListener;\");  //SR17389","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("                else {","\n");
    m$.Cmd.WriteJS("                    document.onmouseup = windowclosePopup();  //SR17389","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            };","\n");
    m$.Cmd.WriteJS("            pObject.Columns = pObject; //SR17445","\n");
    m$.Cmd.WriteJS("            pObject.hide = function() {","\n");
    m$.Cmd.WriteJS("                this.style.visibility = \"hidden\";","\n");
    m$.Cmd.WriteJS("                //document.body.removeChild(this);","\n");
    m$.Cmd.WriteJS("    // SR17413 suggested change Carlos 15-Jun : comment window.setTimeout... and uncomment if (document.getElementById('popup-div'))...","\n");
    m$.Cmd.WriteJS("    // tried without noticed effect and reverted for now","\n");
    m$.Cmd.WriteJS("                //window.setTimeout(\"if (document.getElementById('popup-div')) document.body.removeChild(document.getElementById('popup-div'))\",100);","\n");
    m$.Cmd.WriteJS("                if (document.getElementById('popup-div')) document.body.removeChild(document.getElementById('popup-div')); //SR17253","\n");
    m$.Cmd.WriteJS("            };","\n");
    m$.Cmd.WriteJS("        return pObject;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        //SR17322/SR17455 vvvvv","\n");
    m$.Cmd.WriteJS("        document._getElementById = document.getElementById;","\n");
    m$.Cmd.WriteJS("        document.getElementById = function(id) {","\n");
    m$.Cmd.WriteJS("            var obj=null;","\n");
    m$.Cmd.WriteJS("            var obj=document._getElementById(id);","\n");
    m$.Cmd.WriteJS("            if (obj==null) obj=document.getElementsByName(id)[0];","\n");
    m$.Cmd.WriteJS("            return obj;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        //SR17322/SR17455 ^^^^^","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        //SR17447 vvvvv","\n");
    m$.Cmd.WriteJS("        window._showModalDialog = window.showModalDialog;","\n");
    m$.Cmd.WriteJS("        window.showModalDialog=function(uri,arguments,options) {        ","\n");
    m$.Cmd.WriteJS("            if (uri!=null) {","\n");
    m$.Cmd.WriteJS("                var control=uri.split('YLFDAT=')[1];","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            if ((control!=null) && (control.split('&')[0]!=null)) control=control.split('&')[0];","\n");
    m$.Cmd.WriteJS("            if (document.getElementById(control)!=null) {","\n");
    m$.Cmd.WriteJS("                var strInitValue=document.getElementById(control).value;","\n");
    m$.Cmd.WriteJS("                var retval=window._showModalDialog(uri,arguments,options);","\n");
    m$.Cmd.WriteJS("                if (retval==null) retval=document.getElementById(control).value;","\n");
    m$.Cmd.WriteJS("                if (retval==strInitValue) retval=null;","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                var retval=window._showModalDialog(uri,arguments,options);","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            return retval;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        //SR17447 ^^^^^","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        var blnClosingWindow=false;","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        window._close = window.close;","\n");
    m$.Cmd.WriteJS("        window.close1 = function () { //SR17447","\n");
    m$.Cmd.WriteJS("            if (this.length==1) top.close();","\n");
    m$.Cmd.WriteJS("            return 1;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        //HTMLDocument.prototype.createTextRange = function() {   ","\n");
    m$.Cmd.WriteJS("        //  alert('range');      ","\n");
    m$.Cmd.WriteJS("        //    return this.createRange();","\n");
    m$.Cmd.WriteJS("        //};","\n");
    m$.Cmd.WriteJS("        //HTMLDocument.prototype.moveToElementText = function(srcObj) {      ","\n");
    m$.Cmd.WriteJS("        //  alert(1);        ","\n");
    m$.Cmd.WriteJS("        //    rangeObj.selectNodeContents(srcObj);","\n");
    m$.Cmd.WriteJS("        //};","\n");
    m$.Cmd.WriteJS("        emulateEventHandlers([\"click\"]);","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("    //");
    //<< //>
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< NastyAmpersandHack()
  public Object NastyAmpersandHack(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Firefox doesn't seem to like URL of the form
    //<< ;       http://orion/csp/DEV/COMLogin.cls?YBED=SHOBBY&amp;LANGUAGE=PT
    //<< ; preferring
    //<< ;       http://orion/csp/DEV/COMLogin.cls?YBED=SHOBBY&LANGUAGE=PT
    //<< ; But it appears someone has gone to a lot of trouble to modify alphalinc to
    //<< ; use &amp;
    //<< ; Rather than charge in and wind back those changes, first just hack the
    //<< ; %request.Data to put it in the correct format.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 12-Apr-2010   shobby  SR17427: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strKey
    mVar strKey = m$.var("strKey");
    m$.newVar(strKey);
    //<< 
    //<< set strKey = ""
    strKey.set("");
    //<< for {
    for (;true;) {
      //<< set strKey = $order(%request.Data(strKey))
      strKey.set(m$.Fnc.$order(m$.getRequest().varData(strKey.get())));
      //<< quit:strKey=""
      if (mOp.Equal(strKey.get(),"")) {
        break;
      }
      //<< 
      //<< if strKey["amp;" {
      if (mOp.Contains(strKey.get(),"amp;")) {
        //<< if $data(%request.Data(strKey,1)) {
        if (mOp.Logical(m$.Fnc.$data(m$.getRequest().varData(strKey.get(),1)))) {
          //<< set %request.Data($piece(strKey,"amp;",2),1) = %request.Data(strKey,1)
          m$.getRequest().setData(m$.Fnc.$piece(strKey.get(),"amp;",2),1,m$.getRequest().getData(strKey.get(),1));
          //<< kill %request.Data(strKey,1)
          m$.getRequest().killData(strKey.get(),1);
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Event(pstrEvent) ;SR17253
  public Object Event(Object ... _p) {
    mVar pstrEvent = m$.newVarRef("pstrEvent",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< if pstrEvent="onfocusin" {
    if (mOp.Equal(pstrEvent.get(),"onfocusin")) {
      //<< if $get(YUSERAGENT)'="MSIE" {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) {
        //<< set pstrEvent = "onfocus"
        pstrEvent.set("onfocus");
      }
    }
    //<< }
    //<< }
    //<< quit pstrEvent
    return pstrEvent.get();
  }

//<< 
}
