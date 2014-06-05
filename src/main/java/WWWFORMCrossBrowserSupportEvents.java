//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMCrossBrowserSupportEvents
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:02
//*****************************************************************************

import mLibrary.*;


//<< WWWFORMCrossBrowserSupportEvents
public class WWWFORMCrossBrowserSupportEvents extends mClass {

  public void main() {
    _WWWFORMCrossBrowserSupportEvents();
  }

  public void _WWWFORMCrossBrowserSupportEvents() {
  }

  //<< 
  //<< Setup()
  public Object Setup(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Code broken out of WWWFORMCrossBrowserSupport
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Sep-2011   shobby      SR17853: Created
    //<< ;-------------------------------------------------------------------------------
    //<< &js<
    //<< HTMLElement.prototype.fireEvent = function (peventName,pParam1) {  //SR17448
    //<< peventName=peventName.toLowerCase();
    //<< var eventType='unknown';
    //<< switch (peventName) {
    //<< case 'onclick'    : eventType= 'MouseEvent'; break;
    //<< case 'ondragstart': eventType= 'MouseEvent'; break;
    //<< case 'onkeyup'    : eventType= 'KeyboardEvent'; break;
    //<< case 'onkeydown'  : eventType= 'KeyboardEvent'; break;  //SR17449
    //<< case 'onkeypress' : eventType= 'KeyboardEvent'; break;  //SR17449
    //<< case 'onblur'     : eventType= 'HTMLEvents'; break;
    //<< case 'onfocusout' : eventType= 'HTMLEvents'; break;   //Valid ???
    //<< case 'onchange'   : eventType= 'HTMLEvents'; break;
    //<< default: result = 'unknown';
    //<< }
    //<< peventName=peventName.replace(/on/, "");
    //<< var evt = document.createEvent(eventType);
    //<< 
    //<< if (eventType=='KeyboardEvent') {
    //<< var type       = peventName;
    //<< var bubbles    = true;
    //<< var cancelable = true;
    //<< var view       = null;
    //<< var ctrlKey    = 0;
    //<< var altKey     = 0;
    //<< var shiftKey   = 0;
    //<< var metaKey    = 0;
    //<< var keyCode    = pParam1;
    //<< var charCode   = 0;
    //<< evt.initKeyEvent(type,bubbles,cancelable,view,ctrlKey,altKey,shiftKey,metaKey,keyCode,charCode)
    //<< //evt.initKeyEvent(peventName,true,true,window,0,0,0,0,0,false,false,false,false,0,,null);
    //<< } else if (eventType=='MouseEvent') {
    //<< evt.initMouseEvent(peventName, true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
    //<< } else if (eventType=='HTMLEvents') {
    //<< evt.initEvent(peventName, true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
    //<< } else {
    //<< alert('event '+peventName+' not known. Add to "HTMLElement.prototype.fireEvent" in WWWFORMCrossBrowserSupport.');
    //<< }
    //<< var canceled = !this.dispatchEvent(evt);
    //<< return canceled;
    //<< };
    //<< 
    //<< //attachEvent
    //<< var Capture;
    //<< 
    //<< window.attachEvent= function (sType, fHandler) {  //SR17430
    //<< var shortTypeName = sType.replace(/on/, "");
    //<< //  window.addEventListener(shortTypeName, fHandler._ieEmuEventHandler, false);
    //<< window.addEventListener(shortTypeName, fHandler, false);
    //<< }
    //<< window.detachEvent= function (sType, fHandler) {  //SR17430
    //<< var shortTypeName = sType.replace(/on/, "");
    //<< if (typeof fHandler._ieEmuEventHandler == "function") {
    //<< window.removeEventListener(shortTypeName, fHandler._ieEmuEventHandler, false);
    //<< } else {   // we can always try :-)
    //<< window.removeEventListener(shortTypeName, fHandler, true);
    //<< }
    //<< }
    //<< HTMLDocument.prototype.attachEvent =
    //<< HTMLElement.prototype.attachEvent = function (sType, fHandler) {
    //<< var shortTypeName = sType.replace(/on/, "");
    //<< var blnQuit=false;
    //<< fHandler._ieEmuEventHandler = function (e) {
    //<< window.event = e;
    //<< return fHandler();
    //<< };
    //<< if (shortTypeName=='losecapture') {
    //<< shortTypeName='blur';
    //<< var obj=document;
    //<< } else if (shortTypeName=='resize') {
    //<< //SR17362
    //<< var strFunction=String(fHandler);
    //<< if (strFunction.indexOf('function ()')==-1) {    //SR17430
    //<< cvResizeFunction[this.id]=strFunction       //SR17430
    //<< } else {
    //<< cvResizeFunction[this.id]=String(fHandler).split('{')[1].split('}')[0];
    //<< }
    //<< window.setTimeout('simulatedonresize('+this.id+');',1);
    //<< blnQuit=true;
    //<< } else {
    //<< var obj=Capture? document:this;
    //<< }
    //<< if (!blnQuit) obj.addEventListener(shortTypeName, fHandler._ieEmuEventHandler, false);
    //<< };
    //<< 
    //<< //detachEvent
    //<< Window.prototype.detachEvent=
    //<< HTMLDocument.prototype.detachEvent =
    //<< HTMLElement.prototype.detachEvent = function (sType, fHandler) {
    //<< var shortTypeName = sType.replace(/on/, "");
    //<< var blnQuit=false;
    //<< 
    //<< if (shortTypeName=='losecapture') {
    //<< shortTypeName='blur';
    //<< var obj=document;
    //<< } else if (shortTypeName=='resize') {
    //<< //SR17362
    //<< cvResizeFunction[this.id]=null;
    //<< blnQuit=true;
    //<< } else {
    //<< var obj=Capture? document:this;
    //<< }
    //<< 
    //<< if (!blnQuit && typeof fHandler._ieEmuEventHandler == "function") {
    //<< obj.removeEventListener(shortTypeName, fHandler._ieEmuEventHandler, false);
    //<< } else {   // we can always try :-)
    //<< obj.removeEventListener(shortTypeName, fHandler, true);
    //<< }
    //<< };
    //<< //setCapture
    //<< HTMLDocument.prototype.setCapture =
    //<< HTMLElement.prototype.setCapture = function () {
    //<< Capture=true;
    //<< };
    //<< //releaseCapture
    //<< HTMLDocument.prototype.releaseCapture =
    //<< HTMLElement.prototype.releaseCapture = function () {
    //<< Capture=false;
    //<< };
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.fireEvent = function (peventName,pParam1) {  //SR17448","\n");
    m$.Cmd.WriteJS("            peventName=peventName.toLowerCase();","\n");
    m$.Cmd.WriteJS("            var eventType='unknown';","\n");
    m$.Cmd.WriteJS("            switch (peventName) {","\n");
    m$.Cmd.WriteJS("                case 'onclick'    : eventType= 'MouseEvent'; break;","\n");
    m$.Cmd.WriteJS("                case 'ondragstart': eventType= 'MouseEvent'; break;","\n");
    m$.Cmd.WriteJS("                case 'onkeyup'    : eventType= 'KeyboardEvent'; break;","\n");
    m$.Cmd.WriteJS("                case 'onkeydown'  : eventType= 'KeyboardEvent'; break;  //SR17449","\n");
    m$.Cmd.WriteJS("                case 'onkeypress' : eventType= 'KeyboardEvent'; break;  //SR17449","\n");
    m$.Cmd.WriteJS("                case 'onblur'     : eventType= 'HTMLEvents'; break;","\n");
    m$.Cmd.WriteJS("                case 'onfocusout' : eventType= 'HTMLEvents'; break;   //Valid ???","\n");
    m$.Cmd.WriteJS("                case 'onchange'   : eventType= 'HTMLEvents'; break;","\n");
    m$.Cmd.WriteJS("                default: result = 'unknown';","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            peventName=peventName.replace(/on/, \"\");","\n");
    m$.Cmd.WriteJS("            var evt = document.createEvent(eventType);","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("            if (eventType=='KeyboardEvent') {","\n");
    m$.Cmd.WriteJS("                var type       = peventName;","\n");
    m$.Cmd.WriteJS("                var bubbles    = true;","\n");
    m$.Cmd.WriteJS("                var cancelable = true;","\n");
    m$.Cmd.WriteJS("                var view       = null;","\n");
    m$.Cmd.WriteJS("                var ctrlKey    = 0;","\n");
    m$.Cmd.WriteJS("                var altKey     = 0;","\n");
    m$.Cmd.WriteJS("                var shiftKey   = 0;","\n");
    m$.Cmd.WriteJS("                var metaKey    = 0;","\n");
    m$.Cmd.WriteJS("                var keyCode    = pParam1;","\n");
    m$.Cmd.WriteJS("                var charCode   = 0;","\n");
    m$.Cmd.WriteJS("                evt.initKeyEvent(type,bubbles,cancelable,view,ctrlKey,altKey,shiftKey,metaKey,keyCode,charCode)","\n");
    m$.Cmd.WriteJS("                //evt.initKeyEvent(peventName,true,true,window,0,0,0,0,0,false,false,false,false,0,,null);","\n");
    m$.Cmd.WriteJS("            } else if (eventType=='MouseEvent') {","\n");
    m$.Cmd.WriteJS("                evt.initMouseEvent(peventName, true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);","\n");
    m$.Cmd.WriteJS("            } else if (eventType=='HTMLEvents') {","\n");
    m$.Cmd.WriteJS("                evt.initEvent(peventName, true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                alert('event '+peventName+' not known. Add to \"HTMLElement.prototype.fireEvent\" in WWWFORMCrossBrowserSupport.');","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            var canceled = !this.dispatchEvent(evt);","\n");
    m$.Cmd.WriteJS("            return canceled;","\n");
    m$.Cmd.WriteJS("        };","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        //attachEvent","\n");
    m$.Cmd.WriteJS("        var Capture;","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        window.attachEvent= function (sType, fHandler) {  //SR17430","\n");
    m$.Cmd.WriteJS("            var shortTypeName = sType.replace(/on/, \"\");","\n");
    m$.Cmd.WriteJS("        //  window.addEventListener(shortTypeName, fHandler._ieEmuEventHandler, false);","\n");
    m$.Cmd.WriteJS("            window.addEventListener(shortTypeName, fHandler, false);","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        window.detachEvent= function (sType, fHandler) {  //SR17430","\n");
    m$.Cmd.WriteJS("            var shortTypeName = sType.replace(/on/, \"\");","\n");
    m$.Cmd.WriteJS("            if (typeof fHandler._ieEmuEventHandler == \"function\") {","\n");
    m$.Cmd.WriteJS("                window.removeEventListener(shortTypeName, fHandler._ieEmuEventHandler, false);","\n");
    m$.Cmd.WriteJS("            } else {   // we can always try :-)","\n");
    m$.Cmd.WriteJS("                window.removeEventListener(shortTypeName, fHandler, true);","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        HTMLDocument.prototype.attachEvent =","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.attachEvent = function (sType, fHandler) {","\n");
    m$.Cmd.WriteJS("            var shortTypeName = sType.replace(/on/, \"\");","\n");
    m$.Cmd.WriteJS("            var blnQuit=false;","\n");
    m$.Cmd.WriteJS("            fHandler._ieEmuEventHandler = function (e) {","\n");
    m$.Cmd.WriteJS("                window.event = e;","\n");
    m$.Cmd.WriteJS("                return fHandler();","\n");
    m$.Cmd.WriteJS("            };","\n");
    m$.Cmd.WriteJS("            if (shortTypeName=='losecapture') {","\n");
    m$.Cmd.WriteJS("                shortTypeName='blur';","\n");
    m$.Cmd.WriteJS("                var obj=document;","\n");
    m$.Cmd.WriteJS("            } else if (shortTypeName=='resize') {","\n");
    m$.Cmd.WriteJS("                //SR17362","\n");
    m$.Cmd.WriteJS("                var strFunction=String(fHandler);","\n");
    m$.Cmd.WriteJS("                if (strFunction.indexOf('function ()')==-1) {    //SR17430","\n");
    m$.Cmd.WriteJS("                    cvResizeFunction[this.id]=strFunction       //SR17430","\n");
    m$.Cmd.WriteJS("                } else {","\n");
    m$.Cmd.WriteJS("                    cvResizeFunction[this.id]=String(fHandler).split('{')[1].split('}')[0];","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("                window.setTimeout('simulatedonresize('+this.id+');',1);","\n");
    m$.Cmd.WriteJS("                blnQuit=true;","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                var obj=Capture? document:this;","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("                if (!blnQuit) obj.addEventListener(shortTypeName, fHandler._ieEmuEventHandler, false);","\n");
    m$.Cmd.WriteJS("        };","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        //detachEvent","\n");
    m$.Cmd.WriteJS("        Window.prototype.detachEvent=","\n");
    m$.Cmd.WriteJS("        HTMLDocument.prototype.detachEvent =","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.detachEvent = function (sType, fHandler) {","\n");
    m$.Cmd.WriteJS("            var shortTypeName = sType.replace(/on/, \"\");","\n");
    m$.Cmd.WriteJS("            var blnQuit=false;","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("            if (shortTypeName=='losecapture') {","\n");
    m$.Cmd.WriteJS("                shortTypeName='blur';","\n");
    m$.Cmd.WriteJS("                var obj=document;","\n");
    m$.Cmd.WriteJS("            } else if (shortTypeName=='resize') {","\n");
    m$.Cmd.WriteJS("                //SR17362","\n");
    m$.Cmd.WriteJS("                cvResizeFunction[this.id]=null;","\n");
    m$.Cmd.WriteJS("                blnQuit=true;","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                var obj=Capture? document:this;","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("            if (!blnQuit && typeof fHandler._ieEmuEventHandler == \"function\") {","\n");
    m$.Cmd.WriteJS("                obj.removeEventListener(shortTypeName, fHandler._ieEmuEventHandler, false);","\n");
    m$.Cmd.WriteJS("            } else {   // we can always try :-)","\n");
    m$.Cmd.WriteJS("                obj.removeEventListener(shortTypeName, fHandler, true);","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        };","\n");
    m$.Cmd.WriteJS("        //setCapture","\n");
    m$.Cmd.WriteJS("        HTMLDocument.prototype.setCapture =","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.setCapture = function () {","\n");
    m$.Cmd.WriteJS("            Capture=true;","\n");
    m$.Cmd.WriteJS("        };","\n");
    m$.Cmd.WriteJS("        //releaseCapture","\n");
    m$.Cmd.WriteJS("        HTMLDocument.prototype.releaseCapture =","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.releaseCapture = function () {","\n");
    m$.Cmd.WriteJS("            Capture=false;","\n");
    m$.Cmd.WriteJS("        };","\n");
    m$.Cmd.WriteJS("    ");
    //<< quit
    return null;
  }

//<< 
}
