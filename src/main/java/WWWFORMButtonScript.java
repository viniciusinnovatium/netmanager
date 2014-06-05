//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMButtonScript
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:19
//*****************************************************************************

import mLibrary.*;


//<< WWWFORMButtonScript
public class WWWFORMButtonScript extends mClass {

  public void main() {
    _WWWFORMButtonScript();
  }

  public void _WWWFORMButtonScript() {
  }

  //<< 
  //<< Setup()
  public Object Setup(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; FIXME : Note - comments within &js<  ...  >  will be output with code.
    //<< ;         Preferred option is to keep them outside - perhaps restarting &js for
    //<< ;         each function.  (see write commands in .INT version for examples)
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Jul-2012   shobby      SR18053: Changes to support mouseover of new buttons
    //<< ; 27-May-2010   shobby      SR17338: Make highlight of disabled buttons behave.
    //<< ; 30-Apr-2010   shobby      SR17253: Removed MakeGray function.
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< &js<
    //<< ///////////////////////////////////////////////////////////////////////
    //<< //     This Button Script was designed by Erik Arvidsson for WebFX   //
    //<< //                                                                   //
    //<< //     For more info and examples see: http://webfx.eae.net/         //
    //<< //     or send mail to erik@eae.net                                  //
    //<< //                                                                   //
    //<< //     Feel free to use this code as long as this disclaimer is      //
    //<< //     intact.                                                       //
    //<< ///////////////////////////////////////////////////////////////////////
    //<< 
    //<< document.onmouseover = doOver;
    //<< document.onmouseout  = doOut;
    //<< document.onmousedown = doDown;
    //<< document.onmouseup   = doUp;
    //<< 
    //<< var objDown;
    //<< 
    //<< function doOver(e) {                                            //SR17253
    //<< if (!e) e=window.event;
    //<< var toEl = getReal(e.toElement, "className", "coolButton");             //SR17253  //SR17439
    //<< var fromEl = getReal(e.fromElement, "className", "coolButton");         //SR17253  //SR17439
    //<< if (toEl == fromEl) return;
    //<< //alert(toEl.id+'.'+fromEl.id);
    //<< var el = toEl;
    //<< 
    //<< //var cDisabled = el.cDisabled;
    //<< 
    //<< //SR17338 var cDisabled = el.unselectable;          //SR15240
    //<< var cDisabled = el.getAttribute('unselectable');    //SR17338
    //<< cDisabled = (cDisabled != null); // If CDISABLED atribute is present
    //<< 
    //<< if (el.className == "coolButton") {
    //<< el.onselectstart = new Function("return false");
    //<< 
    //<< if (!cDisabled) {
    //<< makeRaised(el);
    //<< //SR17253 makeGray(el,false);
    //<< }
    //<< }
    //<< }
    //<< 
    //<< function doOut(e) {
    //<< if (!e) e=window.event;
    //<< var toEl = getReal(e.toElement, "className", "coolButton");         //SR17253  //SR17439
    //<< var fromEl = getReal(e.fromElement, "className", "coolButton");     //SR17253  //SR17439
    //<< 
    //<< if (toEl == fromEl) return;
    //<< var el = fromEl;
    //<< 
    //<< //var cDisabled = el.cDisabled;
    //<< //SR17338 var cDisabled = el.unselectable;  //SR15240
    //<< var cDisabled = el.getAttribute('unselectable');    //SR17338
    //<< cDisabled = (cDisabled != null); // If CDISABLED atribute is present
    //<< 
    //<< var cToggle = el.cToggle;
    //<< //SRW3C toggle_disabled = (cToggle != null); // If CTOGGLE atribute is present
    //<< 
    //<< if (cToggle && el.value) {
    //<< makePressed(el);
    //<< //SR17253 makeGray(el,true);
    //<< }
    //<< else if ((el.className == "coolButton") && !cDisabled) {
    //<< makeFlat(el);
    //<< //SR17253 makeGray(el,true);
    //<< }
    //<< }
    //<< function doDown(e) {
    //<< if (!e) e=window.event;
    //<< var el = getReal(e.srcElement, "className", "coolButton");  //W3C
    //<< //var cDisabled = el.cDisabled;
    //<< //SR17338 var cDisabled = el.unselectable;  //SR15240
    //<< var cDisabled = el.getAttribute('unselectable');    //SR17338
    //<< cDisabled = (cDisabled != null); // If CDISABLED atribute is present
    //<< 
    //<< if ((el.className == "coolButton") && !cDisabled) {
    //<< objDown=el;                                     //SR17253
    //<< makePressed(el)
    //<< }
    //<< }
    //<< 
    //<< function doUp(e) {
    //<< if (!e) e=window.event;
    //<< if (objDown!=null) {
    //<< //el = getReal(event.srcElement, "className", "coolButton");
    //<< var el=objDown;  //W3C
    //<< //var cDisabled = el.cDisabled;
    //<< //SR17338 var cDisabled = el.unselectable;  //SR15240
    //<< var cDisabled = el.getAttribute('unselectable');    //SR17338
    //<< cDisabled = (cDisabled != null); // If CDISABLED atribute is present
    //<< 
    //<< if ((el.className == "coolButton") && !cDisabled) {
    //<< makeRaised(el);
    //<< objDown=null;
    //<< }
    //<< }
    //<< }
    //<< 
    //<< 
    //<< function getReal(el, type, value) {
    //<< var temp = el;
    //<< 
    //<< while ((temp != null) && (temp.nodeType!=9) && (temp.tagName != "BODY")) {
    //<< if (eval("temp." + type) == value) {
    //<< el = temp;
    //<< return el;
    //<< }
    //<< temp = temp.parentNode;     //SR17253
    //<< }
    //<< return el;
    //<< }
    //<< 
    //<< function findChildren(el, type, value) {
    //<< var children = el.children;
    //<< var tmp = new Array();
    //<< var j=0;
    //<< 
    //<< for (var i=0; i<children.length; i++) {
    //<< if (eval("children[i]." + type + "==\"" + value + "\"")) {
    //<< tmp[tmp.length] = children[i];
    //<< }
    //<< tmp = tmp.concat(findChildren(children[i], type, value));
    //<< }
    //<< 
    //<< return tmp;
    //<< }
    //<< 
    //<< function disable(el) {
    //<< if (document.readyState != "complete") {
    //<< window.setTimeout("disable(" + el.id + ")", 100);   // If document not finished rendered try later.
    //<< return;
    //<< }
    //<< 
    //<< //var cDisabled = el.cDisabled;
    //<< //SR17338 var cDisabled = el.unselectable;  //SR15240
    //<< var cDisabled = el.getAttribute('unselectable');    //SR17338
    //<< cDisabled = (cDisabled != null); // If CDISABLED atribute is present
    //<< 
    //<< if (!cDisabled) {
    //<< //el.cDisabled = true;
    //<< el.unselectable = true;     //SR15240
    //<< el.innerHTML = '<span style="background: buttonshadow; width: 100%; height: 100%; text-align: center;">' +
    //<< '<span style="filter:Mask(Color=buttonface) DropShadow(Color=buttonhighlight, OffX=1, OffY=1,Positive=0); height: 100%; width: 100%%; text-align: center;">' +
    //<< el.innerHTML +
    //<< '</span>' +
    //<< '</span>';
    //<< 
    //<< if (el.onclick != null) {
    //<< el.cDisabled_onclick = el.onclick;
    //<< el.onclick = null;
    //<< }
    //<< }
    //<< }
    //<< 
    //<< function enable(el) {
    //<< //var cDisabled = el.cDisabled;
    //<< //SR17338 var cDisabled = el.unselectable;  //SR15240
    //<< var cDisabled = el.getAttribute('unselectable');    //SR17338
    //<< cDisabled = (cDisabled != null); // If CDISABLED atribute is present
    //<< 
    //<< if (cDisabled) {
    //<< //el.cDisabled = null;
    //<< el.unselectable = false;    //SR15240
    //<< 
    //<< el.innerHTML = el.children[0].children[0].innerHTML;
    //<< 
    //<< if (el.cDisabled_onclick != null) {
    //<< el.onclick = el.cDisabled_onclick;
    //<< el.cDisabled_onclick = null;
    //<< }
    //<< }
    //<< }
    //<< 
    //<< function addToggle(el) {
    //<< //var cDisabled = el.cDisabled;
    //<< //SR17338 var cDisabled = el.unselectable;  //SR15240
    //<< var cDisabled = el.getAttribute('unselectable');    //SR17338
    //<< cDisabled = (cDisabled != null); // If CDISABLED atribute is present
    //<< 
    //<< var cToggle = el.cToggle;
    //<< 
    //<< cToggle = (cToggle != null); // If CTOGGLE atribute is present
    //<< 
    //<< if (!cToggle && !cDisabled) {
    //<< el.cToggle = true;
    //<< 
    //<< if (el.value == null)
    //<< el.value = 0;       // Start as not pressed down
    //<< 
    //<< if (el.onclick != null)
    //<< el.cToggle_onclick = el.onclick;    // Backup the onclick
    //<< else
    //<< el.cToggle_onclick = "";
    //<< 
    //<< el.onclick = new Function("toggle(" + el.id +"); " + el.id + ".cToggle_onclick();");
    //<< }
    //<< }
    //<< 
    //<< function removeToggle(el) {
    //<< //var cDisabled = el.cDisabled;
    //<< //SR17338 var cDisabled = el.unselectable;  //SR15240
    //<< var cDisabled = el.getAttribute('unselectable');    //SR17338
    //<< cDisabled = (cDisabled != null); // If CDISABLED atribute is present
    //<< 
    //<< var cToggle = el.cToggle;
    //<< 
    //<< cToggle = (cToggle != null); // If CTOGGLE atribute is present
    //<< 
    //<< if (cToggle && !cDisabled) {
    //<< el.cToggle = null;
    //<< 
    //<< if (el.value) {
    //<< toggle(el);
    //<< }
    //<< 
    //<< makeFlat(el);
    //<< 
    //<< if (el.cToggle_onclick != null) {
    //<< el.onclick = el.cToggle_onclick;
    //<< el.cToggle_onclick = null;
    //<< }
    //<< }
    //<< }
    //<< 
    //<< function toggle(el) {
    //<< el.value = !el.value;
    //<< 
    //<< if (el.value)
    //<< el.style.background = "URL(/images/tileback.gif)";
    //<< else
    //<< el.style.backgroundImage = "";
    //<< 
    //<< //  doOut(el);
    //<< }
    //<< 
    //<< function makeGetImage(el) {
    //<< while ((el!=null)&&(el.tagName!='IMG')) {
    //<< el=el.children[0];
    //<< }
    //<< return el;
    //<< }
    //<< function makeFlat(el) {
    //<< var obj;
    //<< if (el.tagName!='IMG') {obj=makeGetImage(el);} //SR18053
    //<< if ((obj!=null)&&(obj.getAttribute('_MouseOverImage')==1)) {
    //<< obj.src=obj.getAttribute('_Image')
    //<< } else {
    //<< with (el.style) {
    //<< background = "";
    //<< border = "1px solid buttonface";
    //<< padding      = "1px";
    //<< }
    //<< }
    //<< }
    //<< 
    //<< function makeRaised(el) {                                   //SR18053
    //<< var obj;
    //<< if (el.tagName!='IMG') {obj=makeGetImage(el);} //SR18053
    //<< if ((obj!=null)&&(obj.getAttribute('_MouseOverImage')==1)) {
    //<< obj.src=obj.getAttribute('_ImageMouseOver');
    //<< } else {
    //<< with (el.style) {
    //<< borderLeft   = "1px solid buttonhighlight";
    //<< borderRight  = "1px solid buttonshadow";
    //<< borderTop    = "1px solid buttonhighlight";
    //<< borderBottom = "1px solid buttonshadow";
    //<< padding      = "1px";
    //<< }
    //<< }
    //<< }
    //<< 
    //<< function makePressed(el) {
    //<< with (el.style) {
    //<< borderLeft   = "1px solid buttonshadow";
    //<< borderRight  = "1px solid buttonhighlight";
    //<< borderTop    = "1px solid buttonshadow";
    //<< borderBottom = "1px solid buttonhighlight";
    //<< paddingTop    = "2px";
    //<< paddingLeft   = "2px";
    //<< paddingBottom = "0px";
    //<< paddingRight  = "0px";
    //<< }
    //<< }
    //<< //->>
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("///////////////////////////////////////////////////////////////////////","\n");
    m$.Cmd.WriteJS("//     This Button Script was designed by Erik Arvidsson for WebFX   //","\n");
    m$.Cmd.WriteJS("//                                                                   //","\n");
    m$.Cmd.WriteJS("//     For more info and examples see: http://webfx.eae.net/         //","\n");
    m$.Cmd.WriteJS("//     or send mail to erik@eae.net                                  //","\n");
    m$.Cmd.WriteJS("//                                                                   //","\n");
    m$.Cmd.WriteJS("//     Feel free to use this code as long as this disclaimer is      //","\n");
    m$.Cmd.WriteJS("//     intact.                                                       //","\n");
    m$.Cmd.WriteJS("///////////////////////////////////////////////////////////////////////","\n");
    m$.Cmd.WriteJS("document.onmouseover = doOver;","\n");
    m$.Cmd.WriteJS("document.onmouseout  = doOut;","\n");
    m$.Cmd.WriteJS("document.onmousedown = doDown;","\n");
    m$.Cmd.WriteJS("document.onmouseup   = doUp;","\n");
    m$.Cmd.WriteJS("var objDown;","\n");
    m$.Cmd.WriteJS("function doOver(e) {                                            //SR17253","\n");
    m$.Cmd.WriteJS("    if (!e) e=window.event;","\n");
    m$.Cmd.WriteJS("    var toEl = getReal(e.toElement, \"className\", \"coolButton\");             //SR17253  //SR17439","\n");
    m$.Cmd.WriteJS("    var fromEl = getReal(e.fromElement, \"className\", \"coolButton\");         //SR17253  //SR17439","\n");
    m$.Cmd.WriteJS("    if (toEl == fromEl) return;","\n");
    m$.Cmd.WriteJS("    //alert(toEl.id+'.'+fromEl.id);","\n");
    m$.Cmd.WriteJS("    var el = toEl;","\n");
    m$.Cmd.WriteJS("    //var cDisabled = el.cDisabled;","\n");
    m$.Cmd.WriteJS("    //SR17338 var cDisabled = el.unselectable;          //SR15240","\n");
    m$.Cmd.WriteJS("    var cDisabled = el.getAttribute('unselectable');    //SR17338 ","\n");
    m$.Cmd.WriteJS("    cDisabled = (cDisabled != null); // If CDISABLED atribute is present","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    if (el.className == \"coolButton\") {","\n");
    m$.Cmd.WriteJS("        el.onselectstart = new Function(\"return false\");","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("        if (!cDisabled) {","\n");
    m$.Cmd.WriteJS("            makeRaised(el);","\n");
    m$.Cmd.WriteJS("            //SR17253 makeGray(el,false);","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function doOut(e) {","\n");
    m$.Cmd.WriteJS("    if (!e) e=window.event;","\n");
    m$.Cmd.WriteJS("    var toEl = getReal(e.toElement, \"className\", \"coolButton\");         //SR17253  //SR17439","\n");
    m$.Cmd.WriteJS("    var fromEl = getReal(e.fromElement, \"className\", \"coolButton\");     //SR17253  //SR17439","\n");
    m$.Cmd.WriteJS("    if (toEl == fromEl) return;","\n");
    m$.Cmd.WriteJS("    var el = fromEl;","\n");
    m$.Cmd.WriteJS("    //var cDisabled = el.cDisabled;","\n");
    m$.Cmd.WriteJS("    //SR17338 var cDisabled = el.unselectable;  //SR15240","\n");
    m$.Cmd.WriteJS("    var cDisabled = el.getAttribute('unselectable');    //SR17338","\n");
    m$.Cmd.WriteJS("    cDisabled = (cDisabled != null); // If CDISABLED atribute is present","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    var cToggle = el.cToggle;","\n");
    m$.Cmd.WriteJS("    //SRW3C toggle_disabled = (cToggle != null); // If CTOGGLE atribute is present","\n");
    m$.Cmd.WriteJS("    if (cToggle && el.value) {","\n");
    m$.Cmd.WriteJS("        makePressed(el);","\n");
    m$.Cmd.WriteJS("        //SR17253 makeGray(el,true);","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    else if ((el.className == \"coolButton\") && !cDisabled) {","\n");
    m$.Cmd.WriteJS("        makeFlat(el);","\n");
    m$.Cmd.WriteJS("        //SR17253 makeGray(el,true);","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function doDown(e) {","\n");
    m$.Cmd.WriteJS("    if (!e) e=window.event;","\n");
    m$.Cmd.WriteJS("    var el = getReal(e.srcElement, \"className\", \"coolButton\");  //W3C","\n");
    m$.Cmd.WriteJS("    //var cDisabled = el.cDisabled;","\n");
    m$.Cmd.WriteJS("    //SR17338 var cDisabled = el.unselectable;  //SR15240","\n");
    m$.Cmd.WriteJS("    var cDisabled = el.getAttribute('unselectable');    //SR17338","\n");
    m$.Cmd.WriteJS("    cDisabled = (cDisabled != null); // If CDISABLED atribute is present","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    if ((el.className == \"coolButton\") && !cDisabled) {","\n");
    m$.Cmd.WriteJS("        objDown=el;                                     //SR17253","\n");
    m$.Cmd.WriteJS("        makePressed(el)","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function doUp(e) {","\n");
    m$.Cmd.WriteJS("    if (!e) e=window.event;","\n");
    m$.Cmd.WriteJS("    if (objDown!=null) {","\n");
    m$.Cmd.WriteJS("        //el = getReal(event.srcElement, \"className\", \"coolButton\");","\n");
    m$.Cmd.WriteJS("        var el=objDown;  //W3C","\n");
    m$.Cmd.WriteJS("        //var cDisabled = el.cDisabled;","\n");
    m$.Cmd.WriteJS("        //SR17338 var cDisabled = el.unselectable;  //SR15240","\n");
    m$.Cmd.WriteJS("        var cDisabled = el.getAttribute('unselectable');    //SR17338       ","\n");
    m$.Cmd.WriteJS("        cDisabled = (cDisabled != null); // If CDISABLED atribute is present","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("        if ((el.className == \"coolButton\") && !cDisabled) {","\n");
    m$.Cmd.WriteJS("            makeRaised(el);","\n");
    m$.Cmd.WriteJS("            objDown=null;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function getReal(el, type, value) {","\n");
    m$.Cmd.WriteJS("    var temp = el;","\n");
    m$.Cmd.WriteJS("    while ((temp != null) && (temp.nodeType!=9) && (temp.tagName != \"BODY\")) {","\n");
    m$.Cmd.WriteJS("        if (eval(\"temp.\" + type) == value) {","\n");
    m$.Cmd.WriteJS("            el = temp;","\n");
    m$.Cmd.WriteJS("            return el;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        temp = temp.parentNode;     //SR17253","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    return el;","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function findChildren(el, type, value) {","\n");
    m$.Cmd.WriteJS("    var children = el.children;","\n");
    m$.Cmd.WriteJS("    var tmp = new Array();","\n");
    m$.Cmd.WriteJS("    var j=0;","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    for (var i=0; i<children.length; i++) {","\n");
    m$.Cmd.WriteJS("        if (eval(\"children[i].\" + type + \"==\\\"\" + value + \"\\\"\")) {","\n");
    m$.Cmd.WriteJS("            tmp[tmp.length] = children[i];","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        tmp = tmp.concat(findChildren(children[i], type, value));","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    return tmp;","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function disable(el) {","\n");
    m$.Cmd.WriteJS("    if (document.readyState != \"complete\") {","\n");
    m$.Cmd.WriteJS("        window.setTimeout(\"disable(\" + el.id + \")\", 100);   // If document not finished rendered try later.","\n");
    m$.Cmd.WriteJS("        return;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    //var cDisabled = el.cDisabled;","\n");
    m$.Cmd.WriteJS("    //SR17338 var cDisabled = el.unselectable;  //SR15240","\n");
    m$.Cmd.WriteJS("    var cDisabled = el.getAttribute('unselectable');    //SR17338","\n");
    m$.Cmd.WriteJS("    cDisabled = (cDisabled != null); // If CDISABLED atribute is present","\n");
    m$.Cmd.WriteJS("    if (!cDisabled) {","\n");
    m$.Cmd.WriteJS("        //el.cDisabled = true;","\n");
    m$.Cmd.WriteJS("        el.unselectable = true;     //SR15240","\n");
    m$.Cmd.WriteJS("        el.innerHTML = '<span style=\"background: buttonshadow; width: 100%; height: 100%; text-align: center;\">' +","\n");
    m$.Cmd.WriteJS("                        '<span style=\"filter:Mask(Color=buttonface) DropShadow(Color=buttonhighlight, OffX=1, OffY=1,Positive=0); height: 100%; width: 100%%; text-align: center;\">' +","\n");
    m$.Cmd.WriteJS("                        el.innerHTML +","\n");
    m$.Cmd.WriteJS("                        '</span>' +","\n");
    m$.Cmd.WriteJS("                        '</span>';","\n");
    m$.Cmd.WriteJS("        if (el.onclick != null) {","\n");
    m$.Cmd.WriteJS("            el.cDisabled_onclick = el.onclick;","\n");
    m$.Cmd.WriteJS("            el.onclick = null;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function enable(el) {","\n");
    m$.Cmd.WriteJS("    //var cDisabled = el.cDisabled;","\n");
    m$.Cmd.WriteJS("    //SR17338 var cDisabled = el.unselectable;  //SR15240","\n");
    m$.Cmd.WriteJS("    var cDisabled = el.getAttribute('unselectable');    //SR17338","\n");
    m$.Cmd.WriteJS("    cDisabled = (cDisabled != null); // If CDISABLED atribute is present","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    if (cDisabled) {","\n");
    m$.Cmd.WriteJS("        //el.cDisabled = null;","\n");
    m$.Cmd.WriteJS("        el.unselectable = false;    //SR15240","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        el.innerHTML = el.children[0].children[0].innerHTML;","\n");
    m$.Cmd.WriteJS("        if (el.cDisabled_onclick != null) {","\n");
    m$.Cmd.WriteJS("            el.onclick = el.cDisabled_onclick;","\n");
    m$.Cmd.WriteJS("            el.cDisabled_onclick = null;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function addToggle(el) {","\n");
    m$.Cmd.WriteJS("    //var cDisabled = el.cDisabled;","\n");
    m$.Cmd.WriteJS("    //SR17338 var cDisabled = el.unselectable;  //SR15240","\n");
    m$.Cmd.WriteJS("    var cDisabled = el.getAttribute('unselectable');    //SR17338","\n");
    m$.Cmd.WriteJS("    cDisabled = (cDisabled != null); // If CDISABLED atribute is present","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    var cToggle = el.cToggle;","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    cToggle = (cToggle != null); // If CTOGGLE atribute is present","\n");
    m$.Cmd.WriteJS("    if (!cToggle && !cDisabled) {","\n");
    m$.Cmd.WriteJS("        el.cToggle = true;","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        if (el.value == null)","\n");
    m$.Cmd.WriteJS("            el.value = 0;       // Start as not pressed down","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        if (el.onclick != null)","\n");
    m$.Cmd.WriteJS("            el.cToggle_onclick = el.onclick;    // Backup the onclick","\n");
    m$.Cmd.WriteJS("        else ","\n");
    m$.Cmd.WriteJS("            el.cToggle_onclick = \"\";","\n");
    m$.Cmd.WriteJS("        el.onclick = new Function(\"toggle(\" + el.id +\"); \" + el.id + \".cToggle_onclick();\");","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function removeToggle(el) {","\n");
    m$.Cmd.WriteJS("    //var cDisabled = el.cDisabled;","\n");
    m$.Cmd.WriteJS("    //SR17338 var cDisabled = el.unselectable;  //SR15240","\n");
    m$.Cmd.WriteJS("    var cDisabled = el.getAttribute('unselectable');    //SR17338","\n");
    m$.Cmd.WriteJS("    cDisabled = (cDisabled != null); // If CDISABLED atribute is present","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    var cToggle = el.cToggle;","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    cToggle = (cToggle != null); // If CTOGGLE atribute is present","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    if (cToggle && !cDisabled) {","\n");
    m$.Cmd.WriteJS("        el.cToggle = null;","\n");
    m$.Cmd.WriteJS("        if (el.value) {","\n");
    m$.Cmd.WriteJS("            toggle(el);","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        makeFlat(el);","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        if (el.cToggle_onclick != null) {","\n");
    m$.Cmd.WriteJS("            el.onclick = el.cToggle_onclick;","\n");
    m$.Cmd.WriteJS("            el.cToggle_onclick = null;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function toggle(el) {","\n");
    m$.Cmd.WriteJS("    el.value = !el.value;","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    if (el.value)","\n");
    m$.Cmd.WriteJS("        el.style.background = \"URL(/images/tileback.gif)\";","\n");
    m$.Cmd.WriteJS("    else","\n");
    m$.Cmd.WriteJS("        el.style.backgroundImage = \"\";","\n");
    m$.Cmd.WriteJS("//  doOut(el);  ","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function makeGetImage(el) {","\n");
    m$.Cmd.WriteJS("    while ((el!=null)&&(el.tagName!='IMG')) {","\n");
    m$.Cmd.WriteJS("        el=el.children[0];","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    return el;","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function makeFlat(el) {","\n");
    m$.Cmd.WriteJS("    var obj;","\n");
    m$.Cmd.WriteJS("    if (el.tagName!='IMG') {obj=makeGetImage(el);} //SR18053","\n");
    m$.Cmd.WriteJS("    if ((obj!=null)&&(obj.getAttribute('_MouseOverImage')==1)) {","\n");
    m$.Cmd.WriteJS("        obj.src=obj.getAttribute('_Image')","\n");
    m$.Cmd.WriteJS("    } else {","\n");
    m$.Cmd.WriteJS("        with (el.style) {","\n");
    m$.Cmd.WriteJS("            background = \"\";","\n");
    m$.Cmd.WriteJS("            border = \"1px solid buttonface\";","\n");
    m$.Cmd.WriteJS("            padding      = \"1px\";","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function makeRaised(el) {                                   //SR18053","\n");
    m$.Cmd.WriteJS("    var obj;","\n");
    m$.Cmd.WriteJS("    if (el.tagName!='IMG') {obj=makeGetImage(el);} //SR18053","\n");
    m$.Cmd.WriteJS("    if ((obj!=null)&&(obj.getAttribute('_MouseOverImage')==1)) {","\n");
    m$.Cmd.WriteJS("        obj.src=obj.getAttribute('_ImageMouseOver');","\n");
    m$.Cmd.WriteJS("    } else {","\n");
    m$.Cmd.WriteJS("        with (el.style) {","\n");
    m$.Cmd.WriteJS("            borderLeft   = \"1px solid buttonhighlight\";","\n");
    m$.Cmd.WriteJS("            borderRight  = \"1px solid buttonshadow\";","\n");
    m$.Cmd.WriteJS("            borderTop    = \"1px solid buttonhighlight\";","\n");
    m$.Cmd.WriteJS("            borderBottom = \"1px solid buttonshadow\";","\n");
    m$.Cmd.WriteJS("            padding      = \"1px\";","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("function makePressed(el) {","\n");
    m$.Cmd.WriteJS("    with (el.style) {","\n");
    m$.Cmd.WriteJS("        borderLeft   = \"1px solid buttonshadow\";","\n");
    m$.Cmd.WriteJS("        borderRight  = \"1px solid buttonhighlight\";","\n");
    m$.Cmd.WriteJS("        borderTop    = \"1px solid buttonshadow\";","\n");
    m$.Cmd.WriteJS("        borderBottom = \"1px solid buttonhighlight\";","\n");
    m$.Cmd.WriteJS("        paddingTop    = \"2px\";","\n");
    m$.Cmd.WriteJS("        paddingLeft   = \"2px\";","\n");
    m$.Cmd.WriteJS("        paddingBottom = \"0px\";","\n");
    m$.Cmd.WriteJS("        paddingRight  = \"0px\";","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("}","\n");
    m$.Cmd.WriteJS("    //->");
    return null;
  }

//<< 
//<< //quit
//<< 
}
