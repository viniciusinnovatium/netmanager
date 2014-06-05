//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMCrossBrowserSupportProperties
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:02
//*****************************************************************************

import mLibrary.*;


//<< WWWFORMCrossBrowserSupportProperties
public class WWWFORMCrossBrowserSupportProperties extends mClass {

  public void main() {
    _WWWFORMCrossBrowserSupportProperties();
  }

  public void _WWWFORMCrossBrowserSupportProperties() {
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
    //<< ; 03-Sep-2013   shobby      CORE-213.6: Strip extract Firefox tabs from the innerTEXT string.
    //<< ; 28-Oct-2011   shobby      SR17725: Bring the FF activeElement behaviour in to line
    //<< ;                               with IE.
    //<< ; 27-Sep-2011   shobby      SR17853: Created
    //<< ;-------------------------------------------------------------------------------
    //<< &js<
    //<< //If browser doesn't have an outerHTML property (firefox) then let's create a whole
    //<< //heap of things to make firefox accept IE specific syntax.
    //<< var _emptyTags = {
    //<< "IMG":   true,
    //<< "BR":    true,
    //<< "INPUT": true,
    //<< "META":  true,
    //<< "LINK":  true,
    //<< "PARAM": true,
    //<< "HR":    true
    //<< };
    //<< HTMLElement.prototype.__defineSetter__("oldWidth", function (sText) {
    //<< this.setAttribute("oldWidth",sText);
    //<< });
    //<< HTMLElement.prototype.__defineGetter__("oldWidth", tmpGet = function () {
    //<< return this.getAttribute("oldWidth");
    //<< });
    //<< HTMLElement.prototype.__defineSetter__("innerText", function (sText) {
    //<< this.innerHTML = convertTextToHTML(sText);
    //<< return sText;
    //<< });
    //<< 
    //<< var tmpGet;
    //<< HTMLElement.prototype.__defineGetter__("innerText", tmpGet = function () {
    //<< var r = this.ownerDocument.createRange();
    //<< r.selectNodeContents(this);
    //<< r=r.toString();             //CORE-233.6
    //<< return r.replace('\n',' '); //CORE-233.6
    //<< });
    //<< 
    //<< HTMLElement.prototype.__defineSetter__("outerText", function (sText) {
    //<< this.outerHTML = convertTextToHTML(sText);
    //<< return sText;
    //<< });
    //<< HTMLElement.prototype.__defineGetter__("outerText", tmpGet);
    //<< 
    //<< HTMLElement.prototype.insertAdjacentText = function (sWhere, sText) {
    //<< this.insertAdjacentHTML(sWhere, convertTextToHTML(sText));
    //<< };
    //<< HTMLElement.prototype.__defineGetter__("outerHTML", function () {
    //<< var attrs = this.attributes;
    //<< var str = "<" + this.tagName;
    //<< for (var i = 0; i < attrs.length; i++)
    //<< str += " " + attrs[i].name + "=\"" + attrs[i].value + "\"";
    //<< 
    //<< if (_emptyTags[this.tagName])
    //<< return str + ">";
    //<< 
    //<< return str + ">" + this.innerHTML + "</" + this.tagName + ">";
    //<< });
    //<< HTMLElement.prototype.__defineSetter__("outerHTML", function (sHTML) {
    //<< var r = this.ownerDocument.createRange();
    //<< //  alert(this.innerHTML);
    //<< r.setStartBefore(this);
    //<< var df = r.createContextualFragment(sHTML);
    //<< this.parentNode.replaceChild(df, this);
    //<< });
    //<< Event.prototype.__defineSetter__("cancelBubble", function (b) {
    //<< if (b) this.stopPropagation();
    //<< });
    //<< Event.prototype.__defineSetter__("returnValue", function (b) {
    //<< if (!b) this.preventDefault();
    //<< });
    //<< Event.prototype.__defineGetter__("srcElement", function () {
    //<< var node = this.target;
    //<< while (node.nodeType != 1) node = node.parentNode;
    //<< return node;
    //<< });
    //<< Event.prototype.__defineGetter__("toElement", function () {  //SR17439
    //<< if (this.type=='mouseout') {
    //<< return this.relatedTarget;
    //<< } else if (this.type=='mouseover') {
    //<< return this.target;
    //<< }
    //<< });
    //<< //Event.prototype=window.event;
    //<< Event.prototype.__defineGetter__("fromElement", function () {  //SR17439
    //<< if (this.type=='mouseout') {
    //<< return this.target;
    //<< } else if (this.type=='mouseover') {
    //<< return this.relatedTarget;
    //<< }
    //<< });
    //<< Event.prototype.__defineGetter__("x", function() {
    //<< return this.pageX;
    //<< });
    //<< Event.prototype.__defineGetter__("y", function() {
    //<< return this.pageY;
    //<< });
    //<< 
    //<< Event.prototype.__defineGetter__("offsetX", function() {
    //<< return this.layerX;
    //<< });
    //<< Event.prototype.__defineGetter__("offsetY", function() {
    //<< return this.layerY;
    //<< });
    //<< 
    //<< //Event.prototype.__defineGetter__("screenX", function(a) { //SR17454
    //<< //Don't appear to be able to override built in properties.
    //<< //  return 'X';
    //<< //});
    //<< 
    //<< //Event.prototype._screenX=Event.screenX;
    //<< //Event.prototype.__defineGetter__("screenX", function() { //SR17454
    //<< //  alert(1);
    //<< //  return 1;
    //<< //});
    //<< //Object.defineProperty(Event.prototype, 'target', {
    //<< //  get: function() {
    //<< //      return this.srcElement;
    //<< //  }
    //<< //});
    //<< 
    //<< var allGetter = function () {  //SR17425
    //<< var a = this.getElementsByTagName("*");
    //<< var node = this;
    //<< a.tags = function (sTagName) {
    //<< return node.getElementsByTagName(sTagName);
    //<< };
    //<< return a;
    //<< };
    //<< HTMLDocument.prototype.__defineGetter__("all", allGetter);
    //<< HTMLElement.prototype.__defineGetter__("all", allGetter);
    //<< 
    //<< HTMLDocument.prototype.__defineGetter__("frames", function() {  //SR17454
    //<< return document.getElementsByTagName('FRAME');
    //<< });
    //<< 
    //<< HTMLDocument.prototype.__defineGetter__("activeElement", function() {
    //<< return window.event.srcElement; //SR17725
    //<< });
    //<< 
    //<< 
    //<< HTMLFrameElement.prototype._location=HTMLFrameElement.location;
    //<< HTMLFrameElement.prototype.__defineSetter__("location", function(locn) { //SR17454
    //<< this._location=locn;
    //<< this._location.href=locn.href;
    //<< });
    //<< HTMLFrameElement.prototype.__defineGetter__("location", function() {
    //<< return this;
    //<< });
    //<< 
    //<< event=Event; //CORE-81
    //<< //Event.prototype.__defineGetter__("KeyCode", function() {
    //<< //  //alert(event.keyCode);
    //<< //  return event.keyCode;
    //<< //});
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("        //If browser doesn't have an outerHTML property (firefox) then let's create a whole","\n");
    m$.Cmd.WriteJS("        //heap of things to make firefox accept IE specific syntax.","\n");
    m$.Cmd.WriteJS("        var _emptyTags = {","\n");
    m$.Cmd.WriteJS("           \"IMG\":   true,","\n");
    m$.Cmd.WriteJS("           \"BR\":    true,","\n");
    m$.Cmd.WriteJS("           \"INPUT\": true,","\n");
    m$.Cmd.WriteJS("           \"META\":  true,","\n");
    m$.Cmd.WriteJS("           \"LINK\":  true,","\n");
    m$.Cmd.WriteJS("           \"PARAM\": true,","\n");
    m$.Cmd.WriteJS("           \"HR\":    true","\n");
    m$.Cmd.WriteJS("        };","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.__defineSetter__(\"oldWidth\", function (sText) {","\n");
    m$.Cmd.WriteJS("            this.setAttribute(\"oldWidth\",sText);","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.__defineGetter__(\"oldWidth\", tmpGet = function () {","\n");
    m$.Cmd.WriteJS("            return this.getAttribute(\"oldWidth\");","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.__defineSetter__(\"innerText\", function (sText) {","\n");
    m$.Cmd.WriteJS("            this.innerHTML = convertTextToHTML(sText);","\n");
    m$.Cmd.WriteJS("            return sText;","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        var tmpGet;","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.__defineGetter__(\"innerText\", tmpGet = function () {","\n");
    m$.Cmd.WriteJS("            var r = this.ownerDocument.createRange();","\n");
    m$.Cmd.WriteJS("            r.selectNodeContents(this);","\n");
    m$.Cmd.WriteJS("            r=r.toString();             //CORE-233.6","\n");
    m$.Cmd.WriteJS("            return r.replace('\\n',' '); //CORE-233.6","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.__defineSetter__(\"outerText\", function (sText) {","\n");
    m$.Cmd.WriteJS("            this.outerHTML = convertTextToHTML(sText);","\n");
    m$.Cmd.WriteJS("            return sText;","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.__defineGetter__(\"outerText\", tmpGet);","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.insertAdjacentText = function (sWhere, sText) {","\n");
    m$.Cmd.WriteJS("            this.insertAdjacentHTML(sWhere, convertTextToHTML(sText));","\n");
    m$.Cmd.WriteJS("        };","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.__defineGetter__(\"outerHTML\", function () {","\n");
    m$.Cmd.WriteJS("            var attrs = this.attributes;","\n");
    m$.Cmd.WriteJS("            var str = \"<\" + this.tagName;","\n");
    m$.Cmd.WriteJS("            for (var i = 0; i < attrs.length; i++)","\n");
    m$.Cmd.WriteJS("                str += \" \" + attrs[i].name + \"=\\\"\" + attrs[i].value + \"\\\"\";","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("            if (_emptyTags[this.tagName])","\n");
    m$.Cmd.WriteJS("                return str + \">\";","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("            return str + \">\" + this.innerHTML + \"</\" + this.tagName + \">\";","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.__defineSetter__(\"outerHTML\", function (sHTML) {","\n");
    m$.Cmd.WriteJS("            var r = this.ownerDocument.createRange();","\n");
    m$.Cmd.WriteJS("        //  alert(this.innerHTML);","\n");
    m$.Cmd.WriteJS("            r.setStartBefore(this);","\n");
    m$.Cmd.WriteJS("            var df = r.createContextualFragment(sHTML);","\n");
    m$.Cmd.WriteJS("            this.parentNode.replaceChild(df, this);","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        Event.prototype.__defineSetter__(\"cancelBubble\", function (b) {","\n");
    m$.Cmd.WriteJS("            if (b) this.stopPropagation();","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        Event.prototype.__defineSetter__(\"returnValue\", function (b) {","\n");
    m$.Cmd.WriteJS("            if (!b) this.preventDefault();","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        Event.prototype.__defineGetter__(\"srcElement\", function () {","\n");
    m$.Cmd.WriteJS("            var node = this.target;","\n");
    m$.Cmd.WriteJS("            while (node.nodeType != 1) node = node.parentNode;","\n");
    m$.Cmd.WriteJS("            return node;","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        Event.prototype.__defineGetter__(\"toElement\", function () {  //SR17439","\n");
    m$.Cmd.WriteJS("            if (this.type=='mouseout') {","\n");
    m$.Cmd.WriteJS("                return this.relatedTarget;","\n");
    m$.Cmd.WriteJS("            } else if (this.type=='mouseover') {","\n");
    m$.Cmd.WriteJS("                return this.target;","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        //Event.prototype=window.event;","\n");
    m$.Cmd.WriteJS("        Event.prototype.__defineGetter__(\"fromElement\", function () {  //SR17439","\n");
    m$.Cmd.WriteJS("            if (this.type=='mouseout') {","\n");
    m$.Cmd.WriteJS("                return this.target;","\n");
    m$.Cmd.WriteJS("            } else if (this.type=='mouseover') {","\n");
    m$.Cmd.WriteJS("                return this.relatedTarget;","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        Event.prototype.__defineGetter__(\"x\", function() {","\n");
    m$.Cmd.WriteJS("            return this.pageX;","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        Event.prototype.__defineGetter__(\"y\", function() {","\n");
    m$.Cmd.WriteJS("            return this.pageY;","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        Event.prototype.__defineGetter__(\"offsetX\", function() {","\n");
    m$.Cmd.WriteJS("            return this.layerX;","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        Event.prototype.__defineGetter__(\"offsetY\", function() {","\n");
    m$.Cmd.WriteJS("            return this.layerY;","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        //Event.prototype.__defineGetter__(\"screenX\", function(a) { //SR17454","\n");
    m$.Cmd.WriteJS("            //Don't appear to be able to override built in properties.","\n");
    m$.Cmd.WriteJS("        //  return 'X';","\n");
    m$.Cmd.WriteJS("        //});","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        //Event.prototype._screenX=Event.screenX;","\n");
    m$.Cmd.WriteJS("        //Event.prototype.__defineGetter__(\"screenX\", function() { //SR17454","\n");
    m$.Cmd.WriteJS("        //  alert(1);","\n");
    m$.Cmd.WriteJS("        //  return 1;","\n");
    m$.Cmd.WriteJS("        //});","\n");
    m$.Cmd.WriteJS("        //Object.defineProperty(Event.prototype, 'target', {","\n");
    m$.Cmd.WriteJS("        //  get: function() {","\n");
    m$.Cmd.WriteJS("        //      return this.srcElement;","\n");
    m$.Cmd.WriteJS("        //  }","\n");
    m$.Cmd.WriteJS("        //});","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        var allGetter = function () {  //SR17425","\n");
    m$.Cmd.WriteJS("            var a = this.getElementsByTagName(\"*\");","\n");
    m$.Cmd.WriteJS("            var node = this;","\n");
    m$.Cmd.WriteJS("            a.tags = function (sTagName) {","\n");
    m$.Cmd.WriteJS("                return node.getElementsByTagName(sTagName);","\n");
    m$.Cmd.WriteJS("            };","\n");
    m$.Cmd.WriteJS("            return a;","\n");
    m$.Cmd.WriteJS("        };","\n");
    m$.Cmd.WriteJS("        HTMLDocument.prototype.__defineGetter__(\"all\", allGetter);","\n");
    m$.Cmd.WriteJS("        HTMLElement.prototype.__defineGetter__(\"all\", allGetter);","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        HTMLDocument.prototype.__defineGetter__(\"frames\", function() {  //SR17454","\n");
    m$.Cmd.WriteJS("            return document.getElementsByTagName('FRAME');","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        HTMLDocument.prototype.__defineGetter__(\"activeElement\", function() {","\n");
    m$.Cmd.WriteJS("            return window.event.srcElement; //SR17725","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        HTMLFrameElement.prototype._location=HTMLFrameElement.location;","\n");
    m$.Cmd.WriteJS("        HTMLFrameElement.prototype.__defineSetter__(\"location\", function(locn) { //SR17454","\n");
    m$.Cmd.WriteJS("            this._location=locn;","\n");
    m$.Cmd.WriteJS("            this._location.href=locn.href;","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        HTMLFrameElement.prototype.__defineGetter__(\"location\", function() {","\n");
    m$.Cmd.WriteJS("            return this;","\n");
    m$.Cmd.WriteJS("        });","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        event=Event; //CORE-81","\n");
    m$.Cmd.WriteJS("        //Event.prototype.__defineGetter__(\"KeyCode\", function() {","\n");
    m$.Cmd.WriteJS("        //  //alert(event.keyCode);","\n");
    m$.Cmd.WriteJS("        //  return event.keyCode;","\n");
    m$.Cmd.WriteJS("        //});","\n");
    m$.Cmd.WriteJS("    ");
    //<< quit
    return null;
  }

//<< 
}
