//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMCrossBrowserSupportClipboard
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:17
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

//<< WWWFORMCrossBrowserSupportClipboard
public class WWWFORMCrossBrowserSupportClipboard extends mClass {

  public void main() {
    _WWWFORMCrossBrowserSupportClipboard();
  }

  public void _WWWFORMCrossBrowserSupportClipboard() {
  }

  //<< 
  //<< Setup()
  public Object Setup(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Only for Firefox and Gecko based browsers - You must go to about:config and
    //<< ; set "signed.applets.codebase_principal_support" to true to make this work.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Feb-2011   shobby      SR17663: Before removal of unnecessary code (18:33)
    //<< ; 18-Feb-2011   shobby      SR17663: Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< 
    //<< &js<
    //<< var shift = false
    //<< 
    //<< var buffer = "";
    //<< 
    //<< var SetClipboardData = function(text) {
    //<< if(!window.netscape || !netscape.security) return; // Browsers that don't use the Gecko engine
    //<< try {
    //<< netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
    //<< var comp_classes = Components.classes;
    //<< } catch(e) {
    //<< var strMessage='#($$$JSText($$$Text("WWW00136")))#';
    //<< //signed.applets.codebase_principal_support must be set to true to allow clipboard access in Firefox.  Contact your System Administrator.
    //<< alert(strMessage);
    //<< 
    //<< return;
    //<< } // When "signed.applets.codebase_principal_support" is set to false
    //<< 
    //<< var type = "text/unicode";
    //<< var comp_interf = Components.interfaces;
    //<< var clipboard           = comp_interf.nsIClipboard;
    //<< var clipboard_inst      = comp_classes["@mozilla.org/widget/clipboard;1"].createInstance(clipboard);
    //<< var transferable        = comp_interf.nsITransferable;
    //<< var transferable_inst   = comp_classes["@mozilla.org/widget/transferable;1"].createInstance(transferable);
    //<< var supportsstring      = comp_interf.nsISupportsString;
    //<< var supportsstring_inst = comp_classes["@mozilla.org/supports-string;1"].createInstance(supportsstring);
    //<< if(!clipboard_inst || !transferable_inst || !supportsstring_inst) return;
    //<< 
    //<< transferable_inst.addDataFlavor(type);
    //<< supportsstring_inst.data = text;
    //<< transferable_inst.setTransferData(type, supportsstring_inst, text.length*2);
    //<< clipboard_inst.setData(transferable_inst, null, clipboard.kGlobalClipboard);
    //<< };
    //<< 
    //<< window.clipboardData=new Object();
    //<< 
    //<< window.clipboardData.getData = function(sDataFormat) {
    //<< var strText='';
    //<< 
    //<< sDataFormat = sDataFormat.toLowerCase();
    //<< if ((sDataFormat != "text") && (sDataFormat != "url")) {
    //<< alert("window.clipboardData.getData: The parameter sDataFormat is incorrect");
    //<< } else {
    //<< try {
    //<< if (netscape.security.PrivilegeManager.enablePrivilege) {
    //<< netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
    //<< } else {
    //<< return "";
    //<< }
    //<< } catch (ex) {
    //<< return "";
    //<< }
    //<< 
    //<< var clip = Components.classes["@mozilla.org/widget/clipboard;1"].getService(Components.interfaces.nsIClipboard);
    //<< if (clip) {
    //<< var trans = Components.classes["@mozilla.org/widget/transferable;1"].createInstance(Components.interfaces.nsITransferable);
    //<< if (trans) {
    //<< trans.addDataFlavor("text/unicode");
    //<< clip.getData(trans, clip.kGlobalClipboard);
    //<< 
    //<< var str       = new Object();
    //<< var strLength = new Object();
    //<< 
    //<< trans.getTransferData("text/unicode", str, strLength);
    //<< if (str) {
    //<< str  = str.value.QueryInterface(Components.interfaces.nsISupportsString);
    //<< strText = str.data.substring(0, strLength.value / 2);
    //<< }
    //<< }
    //<< }
    //<< }
    //<< return strText;
    //<< };
    //<< 
    //<< window.clipboardData.setData = function(sDataFormat, sData) {
    //<< var evt = null;
    //<< 
    //<< if(window.event && event.type == "click") {
    //<< // Opera - Google Chrome - Internet Explorer
    //<< evt = event;
    //<< } else if(arguments.callee.caller) {
    //<< // Firefox - Netscape
    //<< if(typeof arguments.callee.caller.arguments[0] == "object" && arguments.callee.caller.arguments[0].type == "click") {
    //<< evt = arguments.callee.caller.arguments[0];
    //<< } else if(arguments.callee.caller.caller && typeof arguments.callee.caller.caller.arguments[0] == "object" && arguments.callee.caller.caller.arguments[0].type == "click") {
    //<< evt = arguments.callee.caller.caller.arguments[0];
    //<< }
    //<< }
    //<< 
    //<< if(evt) {
    //<< var target = evt.target || evt.srcElement;
    //<< if(target.nodeType == 3) target = target.parentNode; // Defeat Safari bug
    //<< if(target == "[object HTMLFontElement]") target = target.parentNode;
    //<< 
    //<< if(target.toString().indexOf(location.href) != -1) {
    //<< // Opera - Firefox - Google Chrome
    //<< if(evt.preventDefault) {
    //<< evt.preventDefault();
    //<< } else {
    //<< evt.returnValue = false;
    //<< }
    //<< }
    //<< }
    //<< 
    //<< sDataFormat = sDataFormat.toLowerCase();
    //<< if ((sDataFormat != "text") && (sDataFormat != "url")) {
    //<< alert('window.clipboardData.setData: The parameter sDataFormat is incorrect');
    //<< } else {
    //<< setTimeout("("+SetClipboardData+")('"+sData+"');",0);
    //<< if(shift) {
    //<< buffer += sData + "\r\n";
    //<< return true;
    //<< } else if(buffer != "") {
    //<< sData = buffer + sData;
    //<< buffer = "";
    //<< }
    //<< }
    //<< 
    //<< return true;
    //<< };
    //<< 
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("        var shift = false","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        var buffer = \"\";","\n");
    m$.Cmd.WriteJS("        var SetClipboardData = function(text) {","\n");
    m$.Cmd.WriteJS("            if(!window.netscape || !netscape.security) return; // Browsers that don't use the Gecko engine","\n");
    m$.Cmd.WriteJS("            try {","\n");
    m$.Cmd.WriteJS("                netscape.security.PrivilegeManager.enablePrivilege(\"UniversalXPConnect\");","\n");
    m$.Cmd.WriteJS("                var comp_classes = Components.classes;","\n");
    m$.Cmd.WriteJS("            } catch(e) {","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("                var strMessage='",(include.COMSYSString.$$$JSText(m$,include.COMSYS.$$$Text(m$,"WWW00136")))),")';"),"\n");
    m$.Cmd.WriteJS("                //signed.applets.codebase_principal_support must be set to true to allow clipboard access in Firefox.  Contact your System Administrator.","\n");
    m$.Cmd.WriteJS("                alert(strMessage);","\n");
    m$.Cmd.WriteJS("                return;","\n");
    m$.Cmd.WriteJS("            } // When \"signed.applets.codebase_principal_support\" is set to false","\n");
    m$.Cmd.WriteJS("            var type = \"text/unicode\";","\n");
    m$.Cmd.WriteJS("            var comp_interf = Components.interfaces;","\n");
    m$.Cmd.WriteJS("            var clipboard           = comp_interf.nsIClipboard;","\n");
    m$.Cmd.WriteJS("            var clipboard_inst      = comp_classes[\"@mozilla.org/widget/clipboard;1\"].createInstance(clipboard);","\n");
    m$.Cmd.WriteJS("            var transferable        = comp_interf.nsITransferable;","\n");
    m$.Cmd.WriteJS("            var transferable_inst   = comp_classes[\"@mozilla.org/widget/transferable;1\"].createInstance(transferable);","\n");
    m$.Cmd.WriteJS("            var supportsstring      = comp_interf.nsISupportsString;","\n");
    m$.Cmd.WriteJS("            var supportsstring_inst = comp_classes[\"@mozilla.org/supports-string;1\"].createInstance(supportsstring);","\n");
    m$.Cmd.WriteJS("            if(!clipboard_inst || !transferable_inst || !supportsstring_inst) return;","\n");
    m$.Cmd.WriteJS("            transferable_inst.addDataFlavor(type);","\n");
    m$.Cmd.WriteJS("            supportsstring_inst.data = text;","\n");
    m$.Cmd.WriteJS("            transferable_inst.setTransferData(type, supportsstring_inst, text.length*2);","\n");
    m$.Cmd.WriteJS("            clipboard_inst.setData(transferable_inst, null, clipboard.kGlobalClipboard);","\n");
    m$.Cmd.WriteJS("        };","\n");
    m$.Cmd.WriteJS("        window.clipboardData=new Object();","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        window.clipboardData.getData = function(sDataFormat) {","\n");
    m$.Cmd.WriteJS("            var strText='';","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("            sDataFormat = sDataFormat.toLowerCase();","\n");
    m$.Cmd.WriteJS("            if ((sDataFormat != \"text\") && (sDataFormat != \"url\")) {","\n");
    m$.Cmd.WriteJS("                alert(\"window.clipboardData.getData: The parameter sDataFormat is incorrect\");","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                try { ","\n");
    m$.Cmd.WriteJS("                    if (netscape.security.PrivilegeManager.enablePrivilege) { ","\n");
    m$.Cmd.WriteJS("                        netscape.security.PrivilegeManager.enablePrivilege(\"UniversalXPConnect\"); ","\n");
    m$.Cmd.WriteJS("                    } else { ","\n");
    m$.Cmd.WriteJS("                        return \"\"; ","\n");
    m$.Cmd.WriteJS("                    } ","\n");
    m$.Cmd.WriteJS("                } catch (ex) { ","\n");
    m$.Cmd.WriteJS("                    return \"\"; ","\n");
    m$.Cmd.WriteJS("                } ","\n");
    m$.Cmd.WriteJS("                var clip = Components.classes[\"@mozilla.org/widget/clipboard;1\"].getService(Components.interfaces.nsIClipboard); ","\n");
    m$.Cmd.WriteJS("                if (clip) { ","\n");
    m$.Cmd.WriteJS("                    var trans = Components.classes[\"@mozilla.org/widget/transferable;1\"].createInstance(Components.interfaces.nsITransferable); ","\n");
    m$.Cmd.WriteJS("                    if (trans) {","\n");
    m$.Cmd.WriteJS("                        trans.addDataFlavor(\"text/unicode\"); ","\n");
    m$.Cmd.WriteJS("                        clip.getData(trans, clip.kGlobalClipboard); ","\n");
    m$.Cmd.WriteJS("                        var str       = new Object(); ","\n");
    m$.Cmd.WriteJS("                        var strLength = new Object(); ","\n");
    m$.Cmd.WriteJS("                        trans.getTransferData(\"text/unicode\", str, strLength); ","\n");
    m$.Cmd.WriteJS("                        if (str) {","\n");
    m$.Cmd.WriteJS("                            str  = str.value.QueryInterface(Components.interfaces.nsISupportsString); ","\n");
    m$.Cmd.WriteJS("                            strText = str.data.substring(0, strLength.value / 2); ","\n");
    m$.Cmd.WriteJS("                        }","\n");
    m$.Cmd.WriteJS("                    }","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            return strText; ","\n");
    m$.Cmd.WriteJS("        };","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        window.clipboardData.setData = function(sDataFormat, sData) {","\n");
    m$.Cmd.WriteJS("            var evt = null;","\n");
    m$.Cmd.WriteJS("            if(window.event && event.type == \"click\") {","\n");
    m$.Cmd.WriteJS("                // Opera - Google Chrome - Internet Explorer","\n");
    m$.Cmd.WriteJS("                evt = event;","\n");
    m$.Cmd.WriteJS("            } else if(arguments.callee.caller) {","\n");
    m$.Cmd.WriteJS("                // Firefox - Netscape","\n");
    m$.Cmd.WriteJS("                if(typeof arguments.callee.caller.arguments[0] == \"object\" && arguments.callee.caller.arguments[0].type == \"click\") {","\n");
    m$.Cmd.WriteJS("                    evt = arguments.callee.caller.arguments[0];","\n");
    m$.Cmd.WriteJS("                } else if(arguments.callee.caller.caller && typeof arguments.callee.caller.caller.arguments[0] == \"object\" && arguments.callee.caller.caller.arguments[0].type == \"click\") {","\n");
    m$.Cmd.WriteJS("                    evt = arguments.callee.caller.caller.arguments[0];","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            if(evt) {","\n");
    m$.Cmd.WriteJS("                var target = evt.target || evt.srcElement;","\n");
    m$.Cmd.WriteJS("                if(target.nodeType == 3) target = target.parentNode; // Defeat Safari bug","\n");
    m$.Cmd.WriteJS("                if(target == \"[object HTMLFontElement]\") target = target.parentNode;","\n");
    m$.Cmd.WriteJS("                if(target.toString().indexOf(location.href) != -1) {","\n");
    m$.Cmd.WriteJS("                     // Opera - Firefox - Google Chrome","\n");
    m$.Cmd.WriteJS("                    if(evt.preventDefault) {","\n");
    m$.Cmd.WriteJS("                        evt.preventDefault();","\n");
    m$.Cmd.WriteJS("                    } else {","\n");
    m$.Cmd.WriteJS("                        evt.returnValue = false;","\n");
    m$.Cmd.WriteJS("                    }","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("            sDataFormat = sDataFormat.toLowerCase();","\n");
    m$.Cmd.WriteJS("            if ((sDataFormat != \"text\") && (sDataFormat != \"url\")) {","\n");
    m$.Cmd.WriteJS("                alert('window.clipboardData.setData: The parameter sDataFormat is incorrect');","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                setTimeout(\"(\"+SetClipboardData+\")('\"+sData+\"');\",0);","\n");
    m$.Cmd.WriteJS("                if(shift) {","\n");
    m$.Cmd.WriteJS("                    buffer += sData + \"\\r\\n\";","\n");
    m$.Cmd.WriteJS("                    return true;","\n");
    m$.Cmd.WriteJS("                } else if(buffer != \"\") {","\n");
    m$.Cmd.WriteJS("                    sData = buffer + sData;","\n");
    m$.Cmd.WriteJS("                    buffer = \"\";","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            return true;","\n");
    m$.Cmd.WriteJS("        };","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("    ");
    //<< 
    //<< quit
    return null;
  }

//<< 
}
