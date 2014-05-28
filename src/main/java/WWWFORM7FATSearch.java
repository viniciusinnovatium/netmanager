//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM7FATSearch
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:24
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
//<< #include INConst
import include.INConst;

//<< WWWFORM7FATSearch
public class WWWFORM7FATSearch extends mClass {

  public void main() {
    _WWWFORM7FATSearch();
  }

  public void _WWWFORM7FATSearch() {
  }

  //<< 
  //<< Javascript()
  public Object Javascript(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Javascript routines to support the FATSearch control are here..aa
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-Jul-2013   shobby  CORE-140: Stop highlight disappearing when pressing down key at end of list.
    //<< ; 26-Jun-2013   shobby  CORE-75:    Fixed javascript error when FATSearch is not in a grid and no results are returned.
    //<< ; 13-Jun-2013   shobby  CORE-79.10: Improved positioning of FATLists.
    //<< ; 30-May-2013   shobby  CORE-102:  FATGetTop to position list above text field in not enough room below.
    //<< ; 15-May-2013   shobby  CORE-79.6: Couldn't click on dropdown when FixedHeader form was scrolled (eg INReq)
    //<< ; 15-May-2013   shobby  CORE-79.5: Positioning of dropdown was covering cell in Firefox.
    //<< ; 15-May-2013   shobby  CORE-79.4: Width of highlight line extended to full width of dropdown.
    //<< ; 14-May-2013   shobby  CORE-79.3: FATListCreate: Improved sizing of drop down list.
    //<< ; 09-Apr-2013   shobby  CORE-75.8: Positioning of dropdown list when form is of type 'fixed header'
    //<< ; 08-Apr-2013   shobby  CORE-75.6: FATListCreate: Make sure drop down is on top of other FATSearch
    //<< ; 08-Apr-2013   shobby  CORE-75.5: FATListSelectLine: Corrected Javascript error.
    //<< ; 08-Apr-2013   shobby  CORE-75.4: FATListCreate: Removed .... from 'more' text.
    //<< ; 05-Apr-2013   shobby  CORE-75.2: FATIsIn needs to take in to account scroll position
    //<< ;                                  of document.
    //<< ; 28-Mar-2013   shobby  CORE-75: Changes to work with Firefox.
    //<< ; 07-Nov-2011   shobby  SR17725: Created.
    //<< ;-------------------------------------------------------------------------------
    //<< &js<
    //<< var YFATTIMEOUT;
    //<< var YHIGHLIGHTLINE;
    //<< var YVALUE;
    //<< var YSTATE;
    //<< var YMANDATORY;
    //<< 
    //<< function FATIsIn(obj) {
    //<< var result=false;
    //<< if (obj!=null) {  //CORE-75
    //<< var left  =FATGetX(obj)-document.body.scrollLeft;   //CORE-75.2
    //<< var top   =FATGetY(obj)-document.body.scrollTop;    //CORE-75.2
    //<< if (document.getElementById('divFixedHeader')!=undefined) {             //CORE-79.6
    //<< left=left-document.getElementById('divFixedHeader').scrollLeft;     //CORE-79.6
    //<< top=top-document.getElementById('divFixedHeader').scrollTop;        //CORE-79.6
    //<< }                                                                       //CORE-79.6
    //<< var right =left+obj.offsetWidth;
    //<< var bottom=top+obj.offsetHeight;
    //<< result= !((event.clientX<left)||(event.clientX>right)||(event.clientY<top)||(event.clientY>bottom));
    //<< //document.getElementById('DEVInfo').value=document.getElementById('DEVInfo').value+'('+left+'-'+event.clientX+'-'+right+','+top+'-'+event.clientY+'-'+bottom+')='+result+':'+document.body.scrollLeft+':'+document.body.scrollTop+':'+document.getElementById('divFixedHeader').scrollTop;
    //<< }
    //<< return result;
    //<< }
    //<< function FATClick(pid,pYFORM,pYART,pYLFN,pYMANDATORY) {
    //<< if (FATListHidden(pid)) {
    //<< FATSearch1(pid,pYFORM,pYART,pYLFN,pYMANDATORY);
    //<< } else {
    //<< FATClose(pid);
    //<< }
    //<< document.getElementById('Y'+pid).focus();
    //<< }
    //<< function FATIsDisabled(pid) {
    //<< return document.getElementById('FATButtonTD'+pid).disabled;
    //<< }
    //<< 
    //<< function FATKeyDown(pid) {
    //<< if (event.keyCode==9) {
    //<< FATClose(pid);
    //<< } else if ((event.keyCode==13)&&(FATListHidden(pid))) {
    //<< } else {
    //<< if (!FATIsDisabled(pid)) {
    //<< if (YHIGHLIGHTLINE==undefined) {
    //<< } else if (event.keyCode==40) {
    //<< if (YHIGHLIGHTLINE.nextSibling!=null) {
    //<< FATListHighlightLine(YHIGHLIGHTLINE.nextSibling);
    //<< } else {
    //<< }
    //<< } else if (event.keyCode==38) {
    //<< if (YHIGHLIGHTLINE.previousSibling!=null) {
    //<< FATListHighlightLine(YHIGHLIGHTLINE.previousSibling);
    //<< }
    //<< } else if (event.keyCode==13) {
    //<< FATListSelectLine(YHIGHLIGHTLINE,pid);
    //<< }
    //<< window.event.cancelBubble=true;
    //<< }
    //<< }
    //<< }
    //<< function FATKeyUp(pid,pYFORM,pYART,pYLFN,pYMANDATORY) {
    //<< if (!FATIsDisabled(pid)) {
    //<< if (event.keyCode==40) {
    //<< if (FATListHidden(pid)) {
    //<< YVALUE=999;
    //<< FATSearch(pid,pYFORM,pYART,pYLFN,pYMANDATORY);
    //<< }
    //<< } else if(event.keyCode==27) {
    //<< FATClose(pid);
    //<< document.getElementById('Y'+pid).value=YVALUE;
    //<< } else if ((event.keyCode!=38)&&(event.keyCode!=13)) {
    //<< FATSearch(pid,pYFORM,pYART,pYLFN,pYMANDATORY);
    //<< }
    //<< window.event.cancelBubble=true;
    //<< }
    //<< }
    //<< //function Control() {
    //<< //  var obj=new Object;
    //<< //  var id;
    //<< 
    //<< //  obj.ListHidden =ListHidden;
    //<< //  obj.id=id;
    //<< 
    //<< //  function ListHidden(pid) {
    //<< //      return document.getElementById('FATList'+pid)==null;
    //<< //  }
    //<< //  return obj;
    //<< //}
    //<< function FATListHidden(pid) {
    //<< return document.getElementById('FATList'+pid)==null;
    //<< }
    //<< function FATOnBlur(pid) {
    //<< if (event.type=='keydown') {  //Firefox
    //<< FATClose(pid);
    //<< return false;
    //<< } else if (FATIsIn(document.getElementById('FATButtonTD'+pid))) {
    //<< return true;
    //<< } else if (FATListHidden(pid)) {
    //<< return false;
    //<< } else if (!FATIsIn(document.getElementById('FATList'+pid))) {
    //<< FATClose(pid);
    //<< return false;
    //<< } else {
    //<< return true;
    //<< }
    //<< }
    //<< 
    //<< function FATDisable(pid) {
    //<< var obj=document.getElementById(pid);
    //<< obj.disabled=true;
    //<< window.setTimeout(function() {obj.disabled=false},1);
    //<< }
    //<< function FATSearch(pid,pYFORM,pYART,pYLFN,pYMANDATORY) {
    //<< if (YVALUE!=document.getElementById('Y'+pid).value) {
    //<< YVALUE=document.getElementById('Y'+pid).value;
    //<< if (YFATTIMEOUT!=null) window.clearTimeout(YFATTIMEOUT);
    //<< YFATTIMEOUT=window.setTimeout(function() {FATSearch1(pid,pYFORM,pYART,pYLFN,pYMANDATORY);},500);
    //<< 
    //<< }
    //<< }
    //<< function FATSearch1(pid,pYFORM,pYART,pYLFN,pYMANDATORY) {
    //<< if (document.getElementById('Y'+pid)!=null) { //CORE-75
    //<< CallBackNow('Populate^WWWFORM7FATSearch',pid,document.getElementById('Y'+pid).value,pYFORM,pYART,pYLFN,pYMANDATORY);
    //<< }
    //<< }
    //<< function FATParent(obj,type) {
    //<< if (obj.tagName!=type) { obj=FATParent(obj.parentNode,type);}
    //<< return obj;
    //<< }
    //<< 
    //<< // --------------------  FATList -------------------------------------
    //<< function FATListOnMouseOver() {
    //<< FATListHighlightLine(FATParent(window.event.srcElement,'TR'));
    //<< }
    //<< function FATListHighlightLine(pobj) {
    //<< if (!pobj.children[0].getAttribute('_ignore')) {  //CORE-140
    //<< if (YHIGHLIGHTLINE!=undefined) {
    //<< YHIGHLIGHTLINE.children[0].style.color='black';
    //<< YHIGHLIGHTLINE.style.backgroundColor='white';
    //<< YHIGHLIGHTLINE=undefined;
    //<< }
    //<< YHIGHLIGHTLINE=pobj;
    //<< YHIGHLIGHTLINE.children[0].style.color='white';
    //<< //YHIGHLIGHTLINE.style.backgroundColor='midnightblue';
    //<< YHIGHLIGHTLINE.style.backgroundColor='#336292';
    //<< }
    //<< }
    //<< 
    //<< function FATListSelectLine(pobj,pid) {
    //<< if ((pobj!=undefined) && (pobj._key!=undefined)) { //CORE-75.5
    //<< var YFORM = document.getElementById('YFORM');
    //<< var YAR   = document.getElementById('YART');
    //<< var YLFN  = document.getElementById('YLFN');
    //<< 
    //<< var objText  = document.getElementById('Y'+pid);
    //<< if (objText!=undefined) {
    //<< objText.value=pobj._key;
    //<< //CORE-75} else {
    //<< //CORE-75   saveData(pid,pobj._key,1);
    //<< }
    //<< FATClose(pid);
    //<< objText.focus();
    //<< objText.select();
    //<< }
    //<< }
    //<< function FATOnClick(pid) {
    //<< if (FATIsIn(document.getElementById('FATList'+pid))) {
    //<< FATListSelectLine(YHIGHLIGHTLINE,pid);
    //<< } else {
    //<< if ((event.srcElement.id!='FATButtonTD'+pid)&&(event.srcElement.id!=('FATSEARCH'+pid+'IMG'))) {
    //<< if (isFF()) {
    //<< if (document.getElementById('FATList'+pid)!=null) {
    //<< if (!FATIsIn(document.getElementById('FATList'+pid).parentNode.parentNode)) {
    //<< FATClose(pid);
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< function FATGetX(obj) {
    //<< var x=0;    //CORE-75
    //<< if (obj!=null) {
    //<< x=obj.offsetLeft;
    //<< if (obj.offsetParent != null) x += FATGetX(obj.offsetParent);
    //<< }
    //<< return x;
    //<< }
    //<< function FATGetY(obj) {
    //<< var y=0;    //CORE-75
    //<< if (obj!=null) {
    //<< y=obj.offsetTop;
    //<< if (obj.offsetParent != null) y += FATGetY(obj.offsetParent);
    //<< }
    //<< return y;
    //<< }
    //<< function FATgetPageOffsetLeft(obj) { //CORE-75.8
    //<< var x=getPageOffsetLeft(obj);
    //<< if (#($get(YFIXHEADER)&&(YUSERAGENT="MSIE"))#) { //CORE-79.5
    //<< x=x-getPageOffsetLeft(document.getElementById('divFixedHeader'));
    //<< }
    //<< return x;
    //<< }
    //<< function FATgetPageOffsetTop(obj) {  //CORE-75.8     //CORE-79.5
    //<< var y=getPageOffsetTop(obj);
    //<< if (#($get(YFIXHEADER)&&(YUSERAGENT="MSIE"))#) {
    //<< y=y-getPageOffsetTop(document.getElementById('divFixedHeader'));
    //<< }
    //<< return y;
    //<< }
    //<< function FATListCreate(pid,parrValues,parrKeys,pstrMore,pintWidth) {
    //<< if (parrValues.length==1) {  //CORE-75.2
    //<< //Close if list is empty.
    //<< FATClose(pid);
    //<< return false;
    //<< } else {
    //<< var  bodyClientHeight=document.body.clientHeight; //CORE-79.10
    //<< var intFontSize=14;
    //<< var obj=document.getElementById('FATList'+pid);
    //<< if (obj!=undefined) {
    //<< obj.parentNode.removeChild(obj);
    //<< }
    //<< obj=document.createElement('DIV');
    //<< var objStyle=obj.style;
    //<< objStyle.overflow='hidden';
    //<< objStyle.cursor='default';
    //<< objStyle.left='0px';
    //<< objStyle.top='24px';
    //<< objStyle.position='absolute';
    //<< objStyle.backgroundColor='white';
    //<< objStyle.border='1px solid black';
    //<< objStyle.MozUserSelect='none';
    //<< obj.id='FATList'+pid;
    //<< 
    //<< objTable=document.createElement('TABLE');
    //<< objTable.cellSpacing=0;
    //<< //CORE-79.4 if (objStyle.width!='') objTable.style.width='100%';
    //<< obj.appendChild(objTable);
    //<< 
    //<< //if (objContainer._container) {
    //<< //if (objContainer.getAttribute('_container')) {
    //<< if (pid.indexOf('_')!=-1) {
    //<< //grid
    //<< var objContainer=document.getElementById('FATContainer'+pid); //CORE-75.6
    //<< document.getElementById('WWW2').appendChild(obj);
    //<< objStyle.position='absolute';
    //<< objStyle.left=FATgetPageOffsetLeft(document.getElementById('FATContainer'+pid))+'px';  //CORE-75.8
    //<< //CORE-75.8 objStyle.top=24+getPageOffsetTop(document.getElementById('FATContainer'+pid))+'px';
    //<< //CORE-102 objStyle.top=24+FATgetPageOffsetTop(document.getElementById('FATContainer'+pid))+'px'; //CORE-75.8
    //<< objStyle.zIndex='10000';
    //<< } else {
    //<< //document.getElementById('FATDIV'+pid).appendChild(obj); //CORE-75.6
    //<< var objContainer=document.getElementById('FATDIV'+pid); //CORE-75.6
    //<< objContainer.appendChild(obj); //CORE-75.6
    //<< }
    //<< 
    //<< var objBody=document.createElement('TBODY'); objTable.appendChild(objBody);
    //<< objContainer.style.zIndex='2000'; //CORE-75.6
    //<< 
    //<< if (pstrMore!='') parrValues[parrValues.length]=pstrMore; //CORE-75.4
    //<< 
    //<< for (var idx = 0; idx &lt; parrValues.length; idx++) {
    //<< var objTR=document.createElement('TR');
    //<< objTR.style.top='0px';
    //<< objTR.style.left='0px';
    //<< objTR.id='FATListTR'+idx;
    //<< 
    //<< objTD=document.createElement('TD');
    //<< objTD.id='FATListTD'+pid;
    //<< objTD.style.fontSize='12px';
    //<< objTD.style.paddingLeft='5px';
    //<< objTD.style.paddingRight='10px';
    //<< objTD.style.paddingTop='4px';
    //<< objTD.style.paddingBottom='4px';
    //<< objTD.unselectable=true;
    //<< objTD.noWrap=true;
    //<< objTD.innerHTML=parrValues[idx].replace(' ','&nbsp');
    //<< objTD.attachEvent('onmouseover',function() {FATListOnMouseOver()});  //CORE-75.1
    //<< //objTD.style.width='100%';
    //<< objTD.style.width='650px';
    //<< objTD._key=parrKeys[idx];
    //<< objTR._key=parrKeys[idx];
    //<< if (objTD._key==undefined) {
    //<< objTD.style.fontSize='11px';
    //<< objTD.style.borderTop='1px solid black';
    //<< objTD.style.backgroundColor='#F0F0F0';
    //<< //objTD.style.fontStyle='italic';
    //<< objTD.setAttribute('_ignore',true); //CORE-75.1
    //<< }
    //<< //objTD.attachEvent('onclick',function() {FATListSelectLine(pid);});
    //<< 
    //<< objTR.appendChild(objTD);
    //<< objBody.appendChild(objTR);
    //<< if (idx==0) FATListHighlightLine(objTR);
    //<< }
    //<< objStyle.width=getDropdownWidth(pintWidth,objTR,document.getElementById('tdY'+pid))+'px'; //CORE-79.3
    //<< objTable.style.width='100%'; //CORE-79.4
    //<< objStyle.top=FATGetTop(pid,bodyClientHeight)+'px'; //CORE-102 //CORE-79.10
    //<< document.attachEvent('onclick',function() {FATOnClick(pid);});
    //<< }
    //<< }
    //<< function FATGetTop(pid,pbodyClientHeight) { //CORE-102 //CORE-79.10
    //<< var result=0;
    //<< var top     = FATgetPageOffsetTop(document.getElementById('FATContainer'+pid));
    //<< //CORE-79.10 var height1 = document.body.clientHeight;
    //<< if (document.getElementById('FATList'+pid)==null) {
    //<< var height2=0;
    //<< } else {
    //<< var height2 = document.getElementById('FATList'+pid).clientHeight;
    //<< }
    //<< var heightFixedHeader=0;
    //<< if (document.getElementById('divFixedHeader')) {
    //<< heightFixedHeader=getPageOffsetTop(document.getElementById('divFixedHeader'))
    //<< }
    //<< if (pid.indexOf('_')==-1) { //In Body
    //<< if ((top+height2+24+heightFixedHeader)&lt;pbodyClientHeight) {
    //<< result=24;
    //<< } else {
    //<< result=-height2-3;
    //<< }
    //<< } else { //In Grid
    //<< if ((top+height2+24+heightFixedHeader)&lt;pbodyClientHeight) {
    //<< result=top+24;
    //<< } else {
    //<< result=top-height2-2;
    //<< }
    //<< }
    //<< return result;
    //<< }
    //<< // --------------------  FATList -------------------------------------
    //<< function getDropdownWidth(pintWidth,pobjTR,pobjCell) { //CORE-79.3
    //<< var intWidth;
    //<< var intWidthCell=0;
    //<< var intWidthRow=0;
    //<< if (pobjCell!=null) intWidthCell=pobjCell.offsetWidth;
    //<< if (pobjTR!=null) intWidthRow=pobjTR.offsetWidth;
    //<< intWidth=Math.max(intWidthCell,intWidthRow);
    //<< if (pintWidth!='') intWidth=Math.min(pintWidth,intWidth);
    //<< return intWidth;
    //<< }
    //<< function FATHighlightLine(pid) {
    //<< if (event.srcElement.id==('Y'+pid)) {
    //<< var obj=document.getElementById('Y'+pid);
    //<< if (obj.size&gt;1) {
    //<< var intLineHeight=obj.offsetHeight/obj.size;
    //<< obj.selectedIndex=(event.offsetY/intLineHeight);
    //<< }
    //<< }
    //<< }
    //<< function FATClose(pid) {
    //<< if (document.activeElement.id!=('FATButton'+pid)) {
    //<< var obj=document.getElementById('FATList'+pid);
    //<< if (obj!=null) {
    //<< obj.parentNode.style.zIndex='200'; //CORE-75.6
    //<< obj.parentNode.removeChild(obj);
    //<< document.detachEvent('onclick',function() {FATOnClick(pid);});
    //<< document.getElementById('Y'+pid).focus();
    //<< }
    //<< }
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("        var YFATTIMEOUT;","\n");
    m$.Cmd.WriteJS("        var YHIGHLIGHTLINE;","\n");
    m$.Cmd.WriteJS("        var YVALUE;","\n");
    m$.Cmd.WriteJS("        var YSTATE;","\n");
    m$.Cmd.WriteJS("        var YMANDATORY;","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        function FATIsIn(obj) {","\n");
    m$.Cmd.WriteJS("            var result=false;","\n");
    m$.Cmd.WriteJS("            if (obj!=null) {  //CORE-75","\n");
    m$.Cmd.WriteJS("                var left  =FATGetX(obj)-document.body.scrollLeft;   //CORE-75.2","\n");
    m$.Cmd.WriteJS("                var top   =FATGetY(obj)-document.body.scrollTop;    //CORE-75.2","\n");
    m$.Cmd.WriteJS("                if (document.getElementById('divFixedHeader')!=undefined) {             //CORE-79.6","\n");
    m$.Cmd.WriteJS("                    left=left-document.getElementById('divFixedHeader').scrollLeft;     //CORE-79.6","\n");
    m$.Cmd.WriteJS("                    top=top-document.getElementById('divFixedHeader').scrollTop;        //CORE-79.6","\n");
    m$.Cmd.WriteJS("                }                                                                       //CORE-79.6","\n");
    m$.Cmd.WriteJS("                var right =left+obj.offsetWidth;","\n");
    m$.Cmd.WriteJS("                var bottom=top+obj.offsetHeight;","\n");
    m$.Cmd.WriteJS("                result= !((event.clientX<left)||(event.clientX>right)||(event.clientY<top)||(event.clientY>bottom));","\n");
    m$.Cmd.WriteJS("                //document.getElementById('DEVInfo').value=document.getElementById('DEVInfo').value+'('+left+'-'+event.clientX+'-'+right+','+top+'-'+event.clientY+'-'+bottom+')='+result+':'+document.body.scrollLeft+':'+document.body.scrollTop+':'+document.getElementById('divFixedHeader').scrollTop;","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            return result;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATClick(pid,pYFORM,pYART,pYLFN,pYMANDATORY) {","\n");
    m$.Cmd.WriteJS("            if (FATListHidden(pid)) {","\n");
    m$.Cmd.WriteJS("                FATSearch1(pid,pYFORM,pYART,pYLFN,pYMANDATORY);","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                FATClose(pid);","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            document.getElementById('Y'+pid).focus();","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATIsDisabled(pid) {","\n");
    m$.Cmd.WriteJS("            return document.getElementById('FATButtonTD'+pid).disabled;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        function FATKeyDown(pid) {","\n");
    m$.Cmd.WriteJS("            if (event.keyCode==9) {","\n");
    m$.Cmd.WriteJS("                FATClose(pid);","\n");
    m$.Cmd.WriteJS("            } else if ((event.keyCode==13)&&(FATListHidden(pid))) {","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                if (!FATIsDisabled(pid)) {","\n");
    m$.Cmd.WriteJS("                    if (YHIGHLIGHTLINE==undefined) {","\n");
    m$.Cmd.WriteJS("                    } else if (event.keyCode==40) {","\n");
    m$.Cmd.WriteJS("                        if (YHIGHLIGHTLINE.nextSibling!=null) {","\n");
    m$.Cmd.WriteJS("                            FATListHighlightLine(YHIGHLIGHTLINE.nextSibling);","\n");
    m$.Cmd.WriteJS("                        } else {","\n");
    m$.Cmd.WriteJS("                        }","\n");
    m$.Cmd.WriteJS("                    } else if (event.keyCode==38) {","\n");
    m$.Cmd.WriteJS("                        if (YHIGHLIGHTLINE.previousSibling!=null) {","\n");
    m$.Cmd.WriteJS("                            FATListHighlightLine(YHIGHLIGHTLINE.previousSibling);","\n");
    m$.Cmd.WriteJS("                        }","\n");
    m$.Cmd.WriteJS("                    } else if (event.keyCode==13) {","\n");
    m$.Cmd.WriteJS("                        FATListSelectLine(YHIGHLIGHTLINE,pid);","\n");
    m$.Cmd.WriteJS("                    }","\n");
    m$.Cmd.WriteJS("                    window.event.cancelBubble=true;","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATKeyUp(pid,pYFORM,pYART,pYLFN,pYMANDATORY) {","\n");
    m$.Cmd.WriteJS("            if (!FATIsDisabled(pid)) {","\n");
    m$.Cmd.WriteJS("                if (event.keyCode==40) {","\n");
    m$.Cmd.WriteJS("                    if (FATListHidden(pid)) {","\n");
    m$.Cmd.WriteJS("                        YVALUE=999;","\n");
    m$.Cmd.WriteJS("                        FATSearch(pid,pYFORM,pYART,pYLFN,pYMANDATORY);","\n");
    m$.Cmd.WriteJS("                    }","\n");
    m$.Cmd.WriteJS("                } else if(event.keyCode==27) {","\n");
    m$.Cmd.WriteJS("                    FATClose(pid);","\n");
    m$.Cmd.WriteJS("                    document.getElementById('Y'+pid).value=YVALUE;","\n");
    m$.Cmd.WriteJS("                } else if ((event.keyCode!=38)&&(event.keyCode!=13)) {","\n");
    m$.Cmd.WriteJS("                    FATSearch(pid,pYFORM,pYART,pYLFN,pYMANDATORY);","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("                window.event.cancelBubble=true;","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        //function Control() {","\n");
    m$.Cmd.WriteJS("        //  var obj=new Object;","\n");
    m$.Cmd.WriteJS("        //  var id;","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("        //  obj.ListHidden =ListHidden;","\n");
    m$.Cmd.WriteJS("        //  obj.id=id;","\n");
    m$.Cmd.WriteJS("        //  function ListHidden(pid) {","\n");
    m$.Cmd.WriteJS("        //      return document.getElementById('FATList'+pid)==null;","\n");
    m$.Cmd.WriteJS("        //  }","\n");
    m$.Cmd.WriteJS("        //  return obj;","\n");
    m$.Cmd.WriteJS("        //}","\n");
    m$.Cmd.WriteJS("        function FATListHidden(pid) {","\n");
    m$.Cmd.WriteJS("            return document.getElementById('FATList'+pid)==null;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATOnBlur(pid) {","\n");
    m$.Cmd.WriteJS("            if (event.type=='keydown') {  //Firefox","\n");
    m$.Cmd.WriteJS("                FATClose(pid);","\n");
    m$.Cmd.WriteJS("                return false;","\n");
    m$.Cmd.WriteJS("            } else if (FATIsIn(document.getElementById('FATButtonTD'+pid))) {","\n");
    m$.Cmd.WriteJS("                return true;","\n");
    m$.Cmd.WriteJS("            } else if (FATListHidden(pid)) {","\n");
    m$.Cmd.WriteJS("                return false;","\n");
    m$.Cmd.WriteJS("            } else if (!FATIsIn(document.getElementById('FATList'+pid))) {","\n");
    m$.Cmd.WriteJS("                FATClose(pid);","\n");
    m$.Cmd.WriteJS("                return false;","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                return true; ","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        function FATDisable(pid) {","\n");
    m$.Cmd.WriteJS("            var obj=document.getElementById(pid);","\n");
    m$.Cmd.WriteJS("            obj.disabled=true;","\n");
    m$.Cmd.WriteJS("            window.setTimeout(function() {obj.disabled=false},1);","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATSearch(pid,pYFORM,pYART,pYLFN,pYMANDATORY) {","\n");
    m$.Cmd.WriteJS("            if (YVALUE!=document.getElementById('Y'+pid).value) {","\n");
    m$.Cmd.WriteJS("                YVALUE=document.getElementById('Y'+pid).value;","\n");
    m$.Cmd.WriteJS("                if (YFATTIMEOUT!=null) window.clearTimeout(YFATTIMEOUT);","\n");
    m$.Cmd.WriteJS("                YFATTIMEOUT=window.setTimeout(function() {FATSearch1(pid,pYFORM,pYART,pYLFN,pYMANDATORY);},500);","\n");
    m$.Cmd.WriteJS("                ","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATSearch1(pid,pYFORM,pYART,pYLFN,pYMANDATORY) {","\n");
    m$.Cmd.WriteJS("            if (document.getElementById('Y'+pid)!=null) { //CORE-75","\n");
    m$.Cmd.WriteJS("                CallBackNow('Populate^WWWFORM7FATSearch',pid,document.getElementById('Y'+pid).value,pYFORM,pYART,pYLFN,pYMANDATORY);","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATParent(obj,type) {","\n");
    m$.Cmd.WriteJS("            if (obj.tagName!=type) { obj=FATParent(obj.parentNode,type);}","\n");
    m$.Cmd.WriteJS("            return obj;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        // --------------------  FATList -------------------------------------","\n");
    m$.Cmd.WriteJS("        function FATListOnMouseOver() {","\n");
    m$.Cmd.WriteJS("            FATListHighlightLine(FATParent(window.event.srcElement,'TR'));","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATListHighlightLine(pobj) {","\n");
    m$.Cmd.WriteJS("            if (!pobj.children[0].getAttribute('_ignore')) {  //CORE-140","\n");
    m$.Cmd.WriteJS("                if (YHIGHLIGHTLINE!=undefined) {","\n");
    m$.Cmd.WriteJS("                    YHIGHLIGHTLINE.children[0].style.color='black';","\n");
    m$.Cmd.WriteJS("                    YHIGHLIGHTLINE.style.backgroundColor='white';","\n");
    m$.Cmd.WriteJS("                    YHIGHLIGHTLINE=undefined;","\n");
    m$.Cmd.WriteJS("                }   ","\n");
    m$.Cmd.WriteJS("                YHIGHLIGHTLINE=pobj;","\n");
    m$.Cmd.WriteJS("                YHIGHLIGHTLINE.children[0].style.color='white';","\n");
    m$.Cmd.WriteJS("                //YHIGHLIGHTLINE.style.backgroundColor='midnightblue';","\n");
    m$.Cmd.WriteJS("                YHIGHLIGHTLINE.style.backgroundColor='#336292';","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATListSelectLine(pobj,pid) {","\n");
    m$.Cmd.WriteJS("            if ((pobj!=undefined) && (pobj._key!=undefined)) { //CORE-75.5","\n");
    m$.Cmd.WriteJS("                var YFORM = document.getElementById('YFORM');","\n");
    m$.Cmd.WriteJS("                var YAR   = document.getElementById('YART');","\n");
    m$.Cmd.WriteJS("                var YLFN  = document.getElementById('YLFN');","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("                var objText  = document.getElementById('Y'+pid);","\n");
    m$.Cmd.WriteJS("                if (objText!=undefined) {","\n");
    m$.Cmd.WriteJS("                    objText.value=pobj._key;","\n");
    m$.Cmd.WriteJS("                //CORE-75} else {","\n");
    m$.Cmd.WriteJS("                //CORE-75   saveData(pid,pobj._key,1);","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("                FATClose(pid);","\n");
    m$.Cmd.WriteJS("                objText.focus();","\n");
    m$.Cmd.WriteJS("                objText.select();","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATOnClick(pid) {","\n");
    m$.Cmd.WriteJS("            if (FATIsIn(document.getElementById('FATList'+pid))) {","\n");
    m$.Cmd.WriteJS("                FATListSelectLine(YHIGHLIGHTLINE,pid);","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                if ((event.srcElement.id!='FATButtonTD'+pid)&&(event.srcElement.id!=('FATSEARCH'+pid+'IMG'))) {","\n");
    m$.Cmd.WriteJS("                    if (isFF()) {","\n");
    m$.Cmd.WriteJS("                        if (document.getElementById('FATList'+pid)!=null) {","\n");
    m$.Cmd.WriteJS("                            if (!FATIsIn(document.getElementById('FATList'+pid).parentNode.parentNode)) {","\n");
    m$.Cmd.WriteJS("                                FATClose(pid);","\n");
    m$.Cmd.WriteJS("                            }","\n");
    m$.Cmd.WriteJS("                        }","\n");
    m$.Cmd.WriteJS("                    }","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATGetX(obj) {","\n");
    m$.Cmd.WriteJS("            var x=0;    //CORE-75","\n");
    m$.Cmd.WriteJS("            if (obj!=null) {","\n");
    m$.Cmd.WriteJS("                x=obj.offsetLeft;","\n");
    m$.Cmd.WriteJS("                if (obj.offsetParent != null) x += FATGetX(obj.offsetParent);","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            return x;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATGetY(obj) {","\n");
    m$.Cmd.WriteJS("            var y=0;    //CORE-75","\n");
    m$.Cmd.WriteJS("            if (obj!=null) {","\n");
    m$.Cmd.WriteJS("                y=obj.offsetTop;","\n");
    m$.Cmd.WriteJS("                if (obj.offsetParent != null) y += FATGetY(obj.offsetParent);","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            return y;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATgetPageOffsetLeft(obj) { //CORE-75.8","\n");
    m$.Cmd.WriteJS("            var x=getPageOffsetLeft(obj);","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("            if (",(mOp.Logical(m$.Fnc.$get(m$.var("YFIXHEADER"))) && (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")))),")) { //CORE-79.5"),"\n");
    m$.Cmd.WriteJS("                x=x-getPageOffsetLeft(document.getElementById('divFixedHeader'));","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            return x;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATgetPageOffsetTop(obj) {  //CORE-75.8     //CORE-79.5","\n");
    m$.Cmd.WriteJS("            var y=getPageOffsetTop(obj);","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("            if (",(mOp.Logical(m$.Fnc.$get(m$.var("YFIXHEADER"))) && (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")))),")) {"),"\n");
    m$.Cmd.WriteJS("                y=y-getPageOffsetTop(document.getElementById('divFixedHeader'));","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            return y;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATListCreate(pid,parrValues,parrKeys,pstrMore,pintWidth) {","\n");
    m$.Cmd.WriteJS("            if (parrValues.length==1) {  //CORE-75.2","\n");
    m$.Cmd.WriteJS("                //Close if list is empty.","\n");
    m$.Cmd.WriteJS("                FATClose(pid);","\n");
    m$.Cmd.WriteJS("                return false;","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                var  bodyClientHeight=document.body.clientHeight; //CORE-79.10","\n");
    m$.Cmd.WriteJS("                var intFontSize=14;","\n");
    m$.Cmd.WriteJS("                var obj=document.getElementById('FATList'+pid);","\n");
    m$.Cmd.WriteJS("                if (obj!=undefined) {","\n");
    m$.Cmd.WriteJS("                    obj.parentNode.removeChild(obj);","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("                obj=document.createElement('DIV');","\n");
    m$.Cmd.WriteJS("                var objStyle=obj.style;","\n");
    m$.Cmd.WriteJS("                objStyle.overflow='hidden';","\n");
    m$.Cmd.WriteJS("                objStyle.cursor='default';","\n");
    m$.Cmd.WriteJS("                objStyle.left='0px';","\n");
    m$.Cmd.WriteJS("                objStyle.top='24px';","\n");
    m$.Cmd.WriteJS("                objStyle.position='absolute';","\n");
    m$.Cmd.WriteJS("                objStyle.backgroundColor='white';","\n");
    m$.Cmd.WriteJS("                objStyle.border='1px solid black';","\n");
    m$.Cmd.WriteJS("                objStyle.MozUserSelect='none';","\n");
    m$.Cmd.WriteJS("                obj.id='FATList'+pid;","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("                objTable=document.createElement('TABLE');","\n");
    m$.Cmd.WriteJS("                objTable.cellSpacing=0;","\n");
    m$.Cmd.WriteJS("                //CORE-79.4 if (objStyle.width!='') objTable.style.width='100%';","\n");
    m$.Cmd.WriteJS("                obj.appendChild(objTable);","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("                //if (objContainer._container) {","\n");
    m$.Cmd.WriteJS("                //if (objContainer.getAttribute('_container')) {","\n");
    m$.Cmd.WriteJS("                if (pid.indexOf('_')!=-1) {","\n");
    m$.Cmd.WriteJS("                    //grid","\n");
    m$.Cmd.WriteJS("                    var objContainer=document.getElementById('FATContainer'+pid); //CORE-75.6","\n");
    m$.Cmd.WriteJS("                    document.getElementById('WWW2').appendChild(obj);","\n");
    m$.Cmd.WriteJS("                    objStyle.position='absolute';","\n");
    m$.Cmd.WriteJS("                    objStyle.left=FATgetPageOffsetLeft(document.getElementById('FATContainer'+pid))+'px';  //CORE-75.8","\n");
    m$.Cmd.WriteJS("                    //CORE-75.8 objStyle.top=24+getPageOffsetTop(document.getElementById('FATContainer'+pid))+'px';","\n");
    m$.Cmd.WriteJS("                    //CORE-102 objStyle.top=24+FATgetPageOffsetTop(document.getElementById('FATContainer'+pid))+'px'; //CORE-75.8 ","\n");
    m$.Cmd.WriteJS("                    objStyle.zIndex='10000';","\n");
    m$.Cmd.WriteJS("                } else {","\n");
    m$.Cmd.WriteJS("                    //document.getElementById('FATDIV'+pid).appendChild(obj); //CORE-75.6","\n");
    m$.Cmd.WriteJS("                    var objContainer=document.getElementById('FATDIV'+pid); //CORE-75.6","\n");
    m$.Cmd.WriteJS("                    objContainer.appendChild(obj); //CORE-75.6","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("                var objBody=document.createElement('TBODY'); objTable.appendChild(objBody);","\n");
    m$.Cmd.WriteJS("                objContainer.style.zIndex='2000'; //CORE-75.6","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("                if (pstrMore!='') parrValues[parrValues.length]=pstrMore; //CORE-75.4","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("                for (var idx = 0; idx &lt; parrValues.length; idx++) {","\n");
    m$.Cmd.WriteJS("                    var objTR=document.createElement('TR');","\n");
    m$.Cmd.WriteJS("                    objTR.style.top='0px';","\n");
    m$.Cmd.WriteJS("                    objTR.style.left='0px';","\n");
    m$.Cmd.WriteJS("                    objTR.id='FATListTR'+idx;","\n");
    m$.Cmd.WriteJS("                    objTD=document.createElement('TD');","\n");
    m$.Cmd.WriteJS("                    objTD.id='FATListTD'+pid;","\n");
    m$.Cmd.WriteJS("                    objTD.style.fontSize='12px';","\n");
    m$.Cmd.WriteJS("                    objTD.style.paddingLeft='5px';","\n");
    m$.Cmd.WriteJS("                    objTD.style.paddingRight='10px';","\n");
    m$.Cmd.WriteJS("                    objTD.style.paddingTop='4px';","\n");
    m$.Cmd.WriteJS("                    objTD.style.paddingBottom='4px';","\n");
    m$.Cmd.WriteJS("                    objTD.unselectable=true;","\n");
    m$.Cmd.WriteJS("                    objTD.noWrap=true;","\n");
    m$.Cmd.WriteJS("                    objTD.innerHTML=parrValues[idx].replace(' ','&nbsp');","\n");
    m$.Cmd.WriteJS("                    objTD.attachEvent('onmouseover',function() {FATListOnMouseOver()});  //CORE-75.1","\n");
    m$.Cmd.WriteJS("                    //objTD.style.width='100%';","\n");
    m$.Cmd.WriteJS("                    objTD.style.width='650px';","\n");
    m$.Cmd.WriteJS("                    objTD._key=parrKeys[idx];","\n");
    m$.Cmd.WriteJS("                    objTR._key=parrKeys[idx];","\n");
    m$.Cmd.WriteJS("                    if (objTD._key==undefined) {","\n");
    m$.Cmd.WriteJS("                        objTD.style.fontSize='11px';","\n");
    m$.Cmd.WriteJS("                        objTD.style.borderTop='1px solid black';","\n");
    m$.Cmd.WriteJS("                        objTD.style.backgroundColor='#F0F0F0';","\n");
    m$.Cmd.WriteJS("                        //objTD.style.fontStyle='italic';","\n");
    m$.Cmd.WriteJS("                        objTD.setAttribute('_ignore',true); //CORE-75.1","\n");
    m$.Cmd.WriteJS("                    }","\n");
    m$.Cmd.WriteJS("                    //objTD.attachEvent('onclick',function() {FATListSelectLine(pid);});","\n");
    m$.Cmd.WriteJS("                ","\n");
    m$.Cmd.WriteJS("                    objTR.appendChild(objTD);","\n");
    m$.Cmd.WriteJS("                    objBody.appendChild(objTR); ","\n");
    m$.Cmd.WriteJS("                    if (idx==0) FATListHighlightLine(objTR);","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("                objStyle.width=getDropdownWidth(pintWidth,objTR,document.getElementById('tdY'+pid))+'px'; //CORE-79.3","\n");
    m$.Cmd.WriteJS("                objTable.style.width='100%'; //CORE-79.4","\n");
    m$.Cmd.WriteJS("                objStyle.top=FATGetTop(pid,bodyClientHeight)+'px'; //CORE-102 //CORE-79.10","\n");
    m$.Cmd.WriteJS("                document.attachEvent('onclick',function() {FATOnClick(pid);});","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATGetTop(pid,pbodyClientHeight) { //CORE-102 //CORE-79.10","\n");
    m$.Cmd.WriteJS("            var result=0;","\n");
    m$.Cmd.WriteJS("            var top     = FATgetPageOffsetTop(document.getElementById('FATContainer'+pid));","\n");
    m$.Cmd.WriteJS("            //CORE-79.10 var height1 = document.body.clientHeight;","\n");
    m$.Cmd.WriteJS("            if (document.getElementById('FATList'+pid)==null) {","\n");
    m$.Cmd.WriteJS("                var height2=0;","\n");
    m$.Cmd.WriteJS("            } else {","\n");
    m$.Cmd.WriteJS("                var height2 = document.getElementById('FATList'+pid).clientHeight;","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            var heightFixedHeader=0;","\n");
    m$.Cmd.WriteJS("            if (document.getElementById('divFixedHeader')) {","\n");
    m$.Cmd.WriteJS("                heightFixedHeader=getPageOffsetTop(document.getElementById('divFixedHeader'))","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            if (pid.indexOf('_')==-1) { //In Body","\n");
    m$.Cmd.WriteJS("                if ((top+height2+24+heightFixedHeader)&lt;pbodyClientHeight) {","\n");
    m$.Cmd.WriteJS("                    result=24;","\n");
    m$.Cmd.WriteJS("                } else {","\n");
    m$.Cmd.WriteJS("                    result=-height2-3;","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            } else { //In Grid","\n");
    m$.Cmd.WriteJS("                if ((top+height2+24+heightFixedHeader)&lt;pbodyClientHeight) {","\n");
    m$.Cmd.WriteJS("                    result=top+24;","\n");
    m$.Cmd.WriteJS("                } else {","\n");
    m$.Cmd.WriteJS("                    result=top-height2-2;","\n");
    m$.Cmd.WriteJS("                }               ","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("            return result;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        // --------------------  FATList -------------------------------------","\n");
    m$.Cmd.WriteJS("        function getDropdownWidth(pintWidth,pobjTR,pobjCell) { //CORE-79.3","\n");
    m$.Cmd.WriteJS("            var intWidth;","\n");
    m$.Cmd.WriteJS("            var intWidthCell=0;","\n");
    m$.Cmd.WriteJS("            var intWidthRow=0;","\n");
    m$.Cmd.WriteJS("            if (pobjCell!=null) intWidthCell=pobjCell.offsetWidth;","\n");
    m$.Cmd.WriteJS("            if (pobjTR!=null) intWidthRow=pobjTR.offsetWidth;","\n");
    m$.Cmd.WriteJS("            intWidth=Math.max(intWidthCell,intWidthRow);","\n");
    m$.Cmd.WriteJS("            if (pintWidth!='') intWidth=Math.min(pintWidth,intWidth);","\n");
    m$.Cmd.WriteJS("            return intWidth;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATHighlightLine(pid) {","\n");
    m$.Cmd.WriteJS("            if (event.srcElement.id==('Y'+pid)) {","\n");
    m$.Cmd.WriteJS("                var obj=document.getElementById('Y'+pid);","\n");
    m$.Cmd.WriteJS("                if (obj.size&gt;1) {","\n");
    m$.Cmd.WriteJS("                    var intLineHeight=obj.offsetHeight/obj.size;","\n");
    m$.Cmd.WriteJS("                    obj.selectedIndex=(event.offsetY/intLineHeight);","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        function FATClose(pid) {","\n");
    m$.Cmd.WriteJS("            if (document.activeElement.id!=('FATButton'+pid)) {","\n");
    m$.Cmd.WriteJS("                var obj=document.getElementById('FATList'+pid);","\n");
    m$.Cmd.WriteJS("                if (obj!=null) {","\n");
    m$.Cmd.WriteJS("                    obj.parentNode.style.zIndex='200'; //CORE-75.6","\n");
    m$.Cmd.WriteJS("                    obj.parentNode.removeChild(obj);","\n");
    m$.Cmd.WriteJS("                    document.detachEvent('onclick',function() {FATOnClick(pid);});","\n");
    m$.Cmd.WriteJS("                    document.getElementById('Y'+pid).focus();","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    ");
    //<< quit
    return null;
  }

  //<< 
  //<< SetState(pYFORM,pYART,pYLFN,pblnReadOnly,pblnMandatory)
  public Object SetState(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYART = m$.newVarRef("pYART",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYLFN = m$.newVarRef("pYLFN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnReadOnly = m$.newVarRef("pblnReadOnly",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnMandatory = m$.newVarRef("pblnMandatory",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set the drop down button to readonly
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Nov-2011   shobby      SR17725: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW122
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(objWWW122);
    //<< set objWWW122=$$Get^WWW122(pYFORM,pYLFN)
    objWWW122.set(m$.fnc$("WWW122.Get",pYFORM.get(),pYLFN.get()));
    //<< if $$$WWW122DataInputType(objWWW122)=18 {
    if (mOp.Equal(include.WWWConst.$$$WWW122DataInputType(m$,objWWW122),18)) {
      //<< write " var obj=document.getElementById('FATButtonTD"_pYFORM_pYART_pYLFN_"');"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" var obj=document.getElementById('FATButtonTD",pYFORM.get()),pYART.get()),pYLFN.get()),"');"));
      //<< write " if (obj!=null) {"
      m$.Cmd.Write(" if (obj!=null) {");
      //<< write "   var blnDisabled="_$select(pblnReadOnly:"true",1:"false")_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("   var blnDisabled=",m$.Fnc.$select(pblnReadOnly.get(),"true",1,"false")),";"));
      //<< write "   obj.disabled=blnDisabled;"
      m$.Cmd.Write("   obj.disabled=blnDisabled;");
      //<< 
      //<< ; *****   the following three lines handle the condition where a 'rule' is set up
      //<< ;         to disable the FATSearch control based on the contents of another field
      //<< ;         and the user has clicked directly from that field to the dropdown button
      //<< ;         on the FATSearch.
      //<< 
      //<< write "   obj.focus();"
      m$.Cmd.Write("   obj.focus();");
      //<< write "   if (blnDisabled) { FATClose('"_pYFORM_pYART_pYLFN_"'); }"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("   if (blnDisabled) { FATClose('",pYFORM.get()),pYART.get()),pYLFN.get()),"'); }"));
      //<< write "   window.setTimeout(function() {obj.disabled=blnDisabled},5);"
      m$.Cmd.Write("   window.setTimeout(function() {obj.disabled=blnDisabled},5);");
      //<< ; *****
      //<< 
      //<< write "}"
      m$.Cmd.Write("}");
      //<< 
      //<< write "  YMANDATORY="_$select(pblnMandatory:"true",1:"false")_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("  YMANDATORY=",m$.Fnc.$select(pblnMandatory.get(),"true",1,"false")),";"));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Display(YFORM,YART,YLFN)
  public Object Display(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display the control on screen.
    //<< ;
    //<< ; <DIV>
    //<< ;    <TABLE>
    //<< ;        <TR>
    //<< ;           <TD>
    //<< ;               <SELECT>
    //<< ;           </TD>
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-May-2013   shobby      CORE-103: Improve alignment of Search buttons.
    //<< ; 15-May-2013   shobby      CORE-79.7: Change images again.
    //<< ; 14-May-2013   shobby      CORE-79.2: Change button image.
    //<< ; 07-May-2013   shobby      CORE-75.11: Include buttons and relation within the same DIV
    //<< ;                                       to prevent buttons displaying on 2nd line.
    //<< ; 08-Apr-2013   shobby      CORE-75.6: Make sure drop down is on top of other FATSearch
    //<< ; 07-Nov-2011   shobby      SR17725: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YMANDATORY,strLeft ;CORE-75.6
    mVar YMANDATORY = m$.var("YMANDATORY");
    mVar strLeft = m$.var("strLeft");
    m$.newVar(YMANDATORY,strLeft);
    //<< 
    //<< set YMANDATORY=(YPFLICHT=1) || (YART="P")
    YMANDATORY.set((mOp.Equal(m$.var("YPFLICHT").get(),1)) || (mOp.Equal(YART.get(),"P")));
    //<< if $get(YWIDTH)="" set YWIDTH=200
    if (mOp.Equal(m$.Fnc.$get(m$.var("YWIDTH")),"")) {
      mVar YWIDTH = m$.var("YWIDTH");
      YWIDTH.set(200);
    }
    //<< 
    //<< write !,"<DIV id='FATDIV"_YFORM_YART_YLFN_"' style='position:relative; z-Index:200; float:left; width:120%;'" ;CORE-75.6
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<DIV id='FATDIV",YFORM.get()),YART.get()),YLFN.get()),"' style='position:relative; z-Index:200; float:left; width:120%;'"));
    //<< if (YSTATUS'="") write !,$$STATHTML^WWWFORM7()
    if ((mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
      m$.Cmd.Write("\n",m$.fnc$("WWWFORM7.STATHTML"));
    }
    //<< write !,">"
    m$.Cmd.Write("\n",">");
    //<< 
    //<< write !,"<DIV id='FATContainer"_YFORM_YART_YLFN_"' style='position:relative; float:left; '>"
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<DIV id='FATContainer",YFORM.get()),YART.get()),YLFN.get()),"' style='position:relative; float:left; '>"));
    //<< do DisplayText()
    m$.Cmd.Do("DisplayText");
    //<< write !,"</DIV>"
    m$.Cmd.Write("\n","</DIV>");
    //<< 
    //<< ; Button for the drop down list vvvvvvvv ------------------------------------------------------
    //<< if YUSERAGENT="MSIE" {
    if (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")) {
      //<< set strLeft="-4px"
      strLeft.set("-4px");
    }
    //<< } else {
    else {
      //<< set strLeft="0px"
      strLeft.set("0px");
    }
    //<< }
    //<< write !,"<DIV id='FATButtonTD"_YFORM_YART_YLFN_"' style='font-size:12px; cursor:pointer; margin-top:0px; width:22px; height:22px; position:relative; _fl_oat:left; display:"_$select(YUSERAGENT="MSIE":"inline",1:"inline-block")_"; left:"_strLeft_";'" ;CORE-75 ;CORE-75.11 ;CORE-79.2
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<DIV id='FATButtonTD",YFORM.get()),YART.get()),YLFN.get()),"' style='font-size:12px; cursor:pointer; margin-top:0px; width:22px; height:22px; position:relative; _fl_oat:left; display:"),m$.Fnc.$select(mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE"),"inline",1,"inline-block")),"; left:"),strLeft.get()),";'"));
    //<< if YHID=2 write !," disabled=true "
    if (mOp.Equal(m$.var("YHID").get(),2)) {
      m$.Cmd.Write("\n"," disabled=true ");
    }
    //<< write !," onclick='FATClick("""_YFORM_YART_YLFN_""","""_YFORM_""","""_YART_""","""_YLFN_""","""_YMANDATORY_""");' "
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onclick='FATClick(\"",YFORM.get()),YART.get()),YLFN.get()),"\",\""),YFORM.get()),"\",\""),YART.get()),"\",\""),YLFN.get()),"\",\""),YMANDATORY.get()),"\");' "));
    //<< write !,">"
    m$.Cmd.Write("\n",">");
    //<< write !,"&nbsp;<IMG id='FATSEARCH"_YFORM_YART_YLFN_"IMG' src="_YGIF_"form_fat_arrow.gif "_$select(YHID=2:"style='"_$$Gray^WWWFORMCrossBrowserSupport(50)_"'",1:"")_">"  ;CORE-79.2 ;CORE-79.7
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&nbsp;<IMG id='FATSEARCH",YFORM.get()),YART.get()),YLFN.get()),"IMG' src="),m$.var("YGIF").get()),"form_fat_arrow.gif "),m$.Fnc.$select(mOp.Equal(m$.var("YHID").get(),2),mOp.Concat(mOp.Concat("style='",m$.fnc$("WWWFORMCrossBrowserSupport.Gray",50)),"'"),1,"")),">"));
    //<< write !,"</DIV>"
    m$.Cmd.Write("\n","</DIV>");
    //<< ; Button for the drop down list ^^^^^^^^ ------------------------------------------------------
    //<< 
    //<< write !,"<DIV style='height:1px; position:relative; display:"_$select(YUSERAGENT="MSIE":"inline",1:"inline-block")_"; vertical-align:top; left:-5px; top:1px;'>" ;CORE-103
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat("<DIV style='height:1px; position:relative; display:",m$.Fnc.$select(mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE"),"inline",1,"inline-block")),"; vertical-align:top; left:-5px; top:1px;'>"));
    //<< do PARASUCH^WWWFORM75   ;CORE-75.11
    m$.Cmd.Do("WWWFORM75.PARASUCH");
    //<< write !,"</DIV>" ;CORE-103
    m$.Cmd.Write("\n","</DIV>");
    //<< do RELATION^WWWFORM7    ;CORE-75.11
    m$.Cmd.Do("WWWFORM7.RELATION");
    //<< write !,"</DIV>"
    m$.Cmd.Write("\n","</DIV>");
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write !,"YVALUE='"_YINHALT_"';"
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat("YVALUE='",m$.var("YINHALT").get()),"';"));
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< if '+$get(^SysSetup("FieldEvents")) if YXTYP=6 do ^WWWFORM73(YFORM,YART,YLFN)  ;SCRIPT SCHREIBEN ;write
    if (mOp.Not(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","FieldEvents"))))) {
      if (mOp.Equal(m$.var("YXTYP").get(),6)) {
        m$.Cmd.Do("WWWFORM73.main",YFORM.get(),YART.get(),YLFN.get());
      }
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DisplayText()
  public Object DisplayText(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Based on code from WWWFORM7 to build the textbox part of the control
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Oct-2012   shobby      SR18066: Call to doBlur
    //<< ; 22-Sep-2011   shobby      SR17725: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set YXTYP=1
    mVar YXTYP = m$.var("YXTYP");
    YXTYP.set(1);
    //<< if +YLANGE=0 set YLANGE=1
    if (mOp.Equal(mOp.Positive(m$.var("YLANGE").get()),0)) {
      mVar YLANGE = m$.var("YLANGE");
      YLANGE.set(1);
    }
    //<< set YLANGE1=YLANGE
    mVar YLANGE1 = m$.var("YLANGE1");
    YLANGE1.set(m$.var("YLANGE").get());
    //<< 
    //<< if (YTYPE'="float") || (YLANGE>12) do  ;FELD VERLÄNGERN ;field prolong
    if ((mOp.NotEqual(m$.var("YTYPE").get(),"float")) || (mOp.Greater(m$.var("YLANGE").get(),12))) {
      //<< . if YLANGE>2 set YLANGE1=YLANGE1+1
      if (mOp.Greater(m$.var("YLANGE").get(),2)) {
        YLANGE1.set(mOp.Add(YLANGE1.get(),1));
      }
      //<< . if YLANGE>6 set YLANGE1=YLANGE1+1
      if (mOp.Greater(m$.var("YLANGE").get(),6)) {
        YLANGE1.set(mOp.Add(YLANGE1.get(),1));
      }
    }
    //<< ;
    //<< if YLANGE1>YLAMX set YLANGE1=YLAMX  ;NICHT GRÖßER ALS ;Not when
    if (mOp.Greater(YLANGE1.get(),m$.var("YLAMX").get())) {
      YLANGE1.set(m$.var("YLAMX").get());
    }
    //<< if YTYPE="FILE" set YLANGE=200
    if (mOp.Equal(m$.var("YTYPE").get(),"FILE")) {
      mVar YLANGE = m$.var("YLANGE");
      YLANGE.set(200);
    }
    //<< if YTYP=8 set YLANGE=30
    if (mOp.Equal(m$.var("YTYP").get(),8)) {
      mVar YLANGE = m$.var("YLANGE");
      YLANGE.set(30);
    }
    //<< if YTYP=7 if SPRACHE'="DE" set YLANGE1=10  ;TYBD;UHRZEIT ZU LANG IN "EN";4,8,2004    ; FIXME : "DE"
    if (mOp.Equal(m$.var("YTYP").get(),7)) {
      if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
        YLANGE1.set(10);
      }
    }
    //<< ;
    //<< ; If we have a customized field size for a Data Field, ignore the 'Modified Field Length' value.
    //<< if (YART = "D") && (+$$$WWW122DFieldLength($get(^WWW122D(0,YFORM,YLFN,YM,1))) = 0) && ($piece(YSATZ,Y,88) > 0) do ;SRBR014471
    if ((mOp.Equal(m$.var("YART").get(),"D")) && (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW122DFieldLength(m$,m$.Fnc.$get(m$.var("^WWW122D",0,m$.var("YFORM").get(),m$.var("YLFN").get(),m$.var("YM").get(),1)))),0)) && (mOp.Greater(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88),0))) {
      //<< . set YLANGE1=+$piece(YSATZ,Y,88)
      YLANGE1.set(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88)));
    }
    //<< ;
    //<< ; If we have a customized field size for a Primary Key, ignore the 'Modified Input Field Length' value.
    //<< if (YART = "P") && (+$$$WWW121DFieldLength($get(^WWW121D(0,YFORM,YLFN,YM,1))) = 0) && ($piece(YSATZ,Y,88) > 0) do ;SRBR014628
    if ((mOp.Equal(m$.var("YART").get(),"P")) && (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW121DFieldLength(m$,m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YLFN").get(),m$.var("YM").get(),1)))),0)) && (mOp.Greater(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88),0))) {
      //<< . set YLANGE1=+$piece(YSATZ,Y,88)
      YLANGE1.set(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88)));
    }
    //<< ;
    //<< write YCR,"<INPUT"
    m$.Cmd.Write(m$.var("YCR").get(),"<INPUT");
    //<< ;IF YHID=2 WRITE " readOnly"
    //<< write YCR," NAME=""Y"_YFORM_YART_YLFN_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" NAME=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
    //<< write YCR," ID=""Y"_YFORM_YART_YLFN_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ID=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
    //<< write YCR," SIZE="""_YLANGE1_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" SIZE=\"",YLANGE1.get()),"\""));
    //<< write YCR," MAXLENGTH="""_YLANGE_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" MAXLENGTH=\"",m$.var("YLANGE").get()),"\""));
    //<< ;
    //<< ; *** EXECUTE ***
    //<< if $piece(YSATZ,Y,99)'="" xecute $piece(YSATZ,Y,99)  ;EXECUTE INNERHALB EINES EINGABEFELDES GUE ;EXECUTE inside
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99),"")) {
      m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99));
    }
    //<< if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onField.OBJ",$get(YUCI)) write YCR xecute "DO ^Y"_YFORM_YART_YLFN_"onField"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
    if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
      m$.Cmd.Write(m$.var("YCR").get());
      m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField"));
    }
    //<< ;
    //<< write YCR," TYPE="""_YTYPE_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TYPE=\"",m$.var("YTYPE").get()),"\""));
    //<< if YINHALT'="" write YCR," VALUE="""_YINHALT_""""
    if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" VALUE=\"",m$.var("YINHALT").get()),"\""));
    }
    //<< set intTabIndex = +$$$WWW122TabIndex(YSATZ)   ; SR17867.1
    mVar intTabIndex = m$.var("intTabIndex");
    intTabIndex.set(mOp.Positive(include.WWWConst.$$$WWW122TabIndex(m$,m$.var("YSATZ"))));
    //<< if intTabIndex=0 if $get(YHID)=2  write YCR," TABINDEX=-1"    ; TAB STOP IN READ ONLY FIELD.14.07.06;FAN
    if (mOp.Equal(intTabIndex.get(),0)) {
      if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
        m$.Cmd.Write(m$.var("YCR").get()," TABINDEX=-1");
      }
    }
    //<< if intTabIndex=0 if $get(YHID)'=2 write YCR," TABINDEX="""_YTABX_""""
    if (mOp.Equal(intTabIndex.get(),0)) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHID")),2)) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",m$.var("YTABX").get()),"\""));
      }
    }
    //<< if intTabIndex'=0                 write YCR," TABINDEX="""_intTabIndex_""""
    if (mOp.NotEqual(intTabIndex.get(),0)) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",intTabIndex.get()),"\""));
    }
    //<< ;
    //<< ;SR17725.awrite YCR," style=""position:relative; left:-30px; width:"_(YWIDTH-4)_"px; "            ;NEUER STYLE;TYBD;26159;28,7,2004
    //<< write YCR," style=""position:relative; left:0px; width:"_(YWIDTH-4)_"px; height:22px; "            ;NEUER STYLE;TYBD;26159;28,7,2004 ;SR17725.a
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" style=\"position:relative; left:0px; width:",(mOp.Subtract(m$.var("YWIDTH").get(),4))),"px; height:22px; "));
    //<< if YUSERAGENT="MSIE" write "top:-1px; "  ;CORE-75
    if (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")) {
      m$.Cmd.Write("top:-1px; ");
    }
    //<< if $piece(YSATZ,Y,91)'="" do     ;SCHRIFTART NEU ;recent
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),"")) {
      //<< . write "font-family: '"_$piece($get(^WWW100(0,"SCHRIFTART",SPRACHE,$piece(YSATZ,Y,91),1)),Y,1)_"'"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("font-family: '",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),1)),m$.var("Y").get(),1)),"'"));
    }
    //<< write "; padding-top:0 ;padding-bottom:0"   ;style
    m$.Cmd.Write("; padding-top:0 ;padding-bottom:0");
    //<< if YTYPE="float" write "; text-align:right"
    if (mOp.Equal(m$.var("YTYPE").get(),"float")) {
      m$.Cmd.Write("; text-align:right");
    }
    //<< if (YART="P") && (YHID=2) /*&& blnBoldKeys*/ write "; font-weight:bold"     ; $$$WWW012PrimaryKeyFatRepresent
    if ((mOp.Equal(m$.var("YART").get(),"P")) && (mOp.Equal(m$.var("YHID").get(),2))) {
      m$.Cmd.Write("; font-weight:bold");
    }
    //<< if $piece(YSATZ,Y,78)'="" write "; "_$piece(YSATZ,Y,78)   ;style
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78),"")) {
      m$.Cmd.Write(mOp.Concat("; ",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78)));
    }
    //<< if YINHALT'="" if YPARA(20)=1 if YPARA(2)'="" set YCOLOR1=YPARA(2) set YPARA(5)=YINHALT do FARBE2^WWWFORM7
    if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
      if (mOp.Equal(m$.var("YPARA").var(20).get(),1)) {
        if (mOp.NotEqual(m$.var("YPARA").var(2).get(),"")) {
          mVar YCOLOR1 = m$.var("YCOLOR1");
          YCOLOR1.set(m$.var("YPARA").var(2).get());
          mVar YPARA = m$.var("YPARA");
          YPARA.var(5).set(m$.var("YINHALT").get());
          m$.Cmd.Do("WWWFORM7.FARBE2");
        }
      }
    }
    //<< if YHID=2 do LESEN1^WWWFORM7                             ; Disabled field
    if (mOp.Equal(m$.var("YHID").get(),2)) {
      m$.Cmd.Do("WWWFORM7.LESEN1");
    }
    //<< if YMANDATORY do PFLICHT^WWWFORM7        ; Mandatory Field
    if (mOp.Logical(m$.var("YMANDATORY").get())) {
      m$.Cmd.Do("WWWFORM7.PFLICHT");
    }
    //<< IF (YHID'=2) && (YPFLICHT'=1) && (YART'="P") write "; background-color:white; "     ;SR17861
    if ((mOp.NotEqual(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YPFLICHT").get(),1)) && (mOp.NotEqual(m$.var("YART").get(),"P"))) {
      m$.Cmd.Write("; background-color:white; ");
    }
    //<< write "; margin-bottom:1px; "                                       ;SR17861
    m$.Cmd.Write("; margin-bottom:1px; ");
    //<< write """"  ;STYLE ENDE ;termination
    m$.Cmd.Write("\"");
    //<< ;
    //<< if YHID=2 do LESEN^WWWFORM7
    if (mOp.Equal(m$.var("YHID").get(),2)) {
      m$.Cmd.Do("WWWFORM7.LESEN");
    }
    //<< if $piece(YSATZ,Y,82)'="" do READONLY^WWWFORM7  ;ANDERE FELDER AUF READ ONLY WENN EINGABE ;upon READ when
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),82),"")) {
      m$.Cmd.Do("WWWFORM7.READONLY");
    }
    //<< if $piece(YSATZ,Y,83)'="" do WRITE^WWWFORM7     ;ANDERE FELDER AUF WRITE WENN EINGABE ;upon when
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),83),"")) {
      m$.Cmd.Do("WWWFORM7.WRITE");
    }
    //<< if YJAVA=1 do JAVA^WWWFORM8
    if (mOp.Equal(m$.var("YJAVA").get(),1)) {
      m$.Cmd.Do("WWWFORM8.JAVA");
    }
    //<< 
    //<< ;do SAVE^WWWFORM7
    //<< if YSTATUS'="" write $$STATHTML^WWWFORM7()
    if (mOp.NotEqual(m$.var("YSTATUS").get(),"")) {
      m$.Cmd.Write(m$.fnc$("WWWFORM7.STATHTML"));
    }
    //<< if YHID'=2 {
    if (mOp.NotEqual(m$.var("YHID").get(),2)) {
      //<< write YCR," onfocus='select();'"
      m$.Cmd.Write(m$.var("YCR").get()," onfocus='select();'");
      //<< write YCR," onkeydown='FATKeyDown("""_YFORM_YART_YLFN_""");' "
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onkeydown='FATKeyDown(\"",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\");' "));
      //<< write YCR," onkeyup='FATKeyUp("""_YFORM_YART_YLFN_""","""_YFORM_""","""_YART_""","""_YLFN_""","""_YMANDATORY_""");' "
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onkeyup='FATKeyUp(\"",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",\""),m$.var("YFORM").get()),"\",\""),m$.var("YART").get()),"\",\""),m$.var("YLFN").get()),"\",\""),m$.var("YMANDATORY").get()),"\");' "));
      //<< ; The following replace the call to SAVE^WWWFORM7
      //<< write YCR," onblur='"
      m$.Cmd.Write(m$.var("YCR").get()," onblur='");
      //<< write YCR," FATOnBlur("""_YFORM_YART_YLFN_"""); "
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" FATOnBlur(\"",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\"); "));
      //<< ;SR18066 write YCR," if (!this.readOnly) { retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""",this.value,""2"","""_$$VariableForEventBroker^WWWFORM7()_""","""_YSEITE_"""); }"
      //<< write YCR," if (doBlur(this)) { retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""",this.value,""2"","""_$$VariableForEventBroker^WWWFORM7()_""","""_YSEITE_"""); }" ;SR18066
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (doBlur(this)) { retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",this.value,\"2\",\""),m$.fnc$("WWWFORM7.VariableForEventBroker")),"\",\""),m$.var("YSEITE").get()),"\"); }"));
      //<< write "'"
      m$.Cmd.Write("'");
    }
    //<< }
    //<< write ">"
    m$.Cmd.Write(">");
    //<< if YPARA(20)=1 set YSHOWRELA = 1
    if (mOp.Equal(m$.var("YPARA").var(20).get(),1)) {
      mVar YSHOWRELA = m$.var("YSHOWRELA");
      YSHOWRELA.set(1);
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Populate(YFIELDNAME,pstrText,YFORM,YART,YLFN,YMANDATORY)
  public Object Populate(Object ... _p) {
    mVar YFIELDNAME = m$.newVarRef("YFIELDNAME",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar YMANDATORY = m$.newVarRef("YMANDATORY",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Obtains the data to be placed in the drop down list.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 14-May-2013   shobby      CORE-79.3: ListWidth changed to MaxListWidth
    //<< ; 24-Apr-2013   shobby      CORE-75.10: Temporary data is subscripted by YUSER
    //<< ; 08-Apr-2013   shobby      CORE-75.7: Correction when relationship is not the first property
    //<< ; 03-Nov-2011   shobby      SR17725: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idINART,intLines,objINART,strText,objWWW122,idClass
    mVar idINART = m$.var("idINART");
    mVar intLines = m$.var("intLines");
    mVar objINART = m$.var("objINART");
    mVar strText = m$.var("strText");
    mVar objWWW122 = m$.var("objWWW122");
    mVar idClass = m$.var("idClass");
    m$.newVar(idINART,intLines,objINART,strText,objWWW122,idClass);
    //<< new idRec,objRec,intRelationalDisplayItem
    mVar idRec = m$.var("idRec");
    mVar objRec = m$.var("objRec");
    mVar intRelationalDisplayItem = m$.var("intRelationalDisplayItem");
    m$.newVar(idRec,objRec,intRelationalDisplayItem);
    //<< new strSoundEx,blnMore,intItem,intItemCount,strField
    mVar strSoundEx = m$.var("strSoundEx");
    mVar blnMore = m$.var("blnMore");
    mVar intItem = m$.var("intItem");
    mVar intItemCount = m$.var("intItemCount");
    mVar strField = m$.var("strField");
    m$.newVar(strSoundEx,blnMore,intItem,intItemCount,strField);
    //<< 
    //<< new YOPTIONWIDTH
    mVar YOPTIONWIDTH = m$.var("YOPTIONWIDTH");
    m$.newVar(YOPTIONWIDTH);
    //<< 
    //<< kill ^CacheTempFATSearch(YM,YUSER) ;CORE-75.10
    m$.var("^CacheTempFATSearch",m$.var("YM").get(),m$.var("YUSER").get()).kill();
    //<< 
    //<< set pstrText=$zcvt(pstrText,"U")
    pstrText.set(m$.Fnc.$zconvert(pstrText.get(),"U"));
    //<< 
    //<< set intLines=0
    intLines.set(0);
    //<< 
    //<< if (YART = "P"){
    if ((mOp.Equal(YART.get(),"P"))) {
      //<< set objWWW121     = $$Get^WWW121(YFORM,YLFN)
      mVar objWWW121 = m$.var("objWWW121");
      objWWW121.set(m$.fnc$("WWW121.Get",YFORM.get(),YLFN.get()));
      //<< set YOPTIONWIDTH  = "" ;Keys don't have this property
      YOPTIONWIDTH.set("");
      //<< set idClass       = $$$WWW121RelationClass(objWWW121)
      idClass.set(include.WWWConst.$$$WWW121RelationClass(m$,objWWW121));
      //<< set intRelationalDisplayItem = $$$WWW121RelationalDisplayItems(objWWW121)
      intRelationalDisplayItem.set(include.WWWConst.$$$WWW121RelationalDisplayItems(m$,objWWW121));
      //<< if intRelationalDisplayItem  = "" set intRelationalDisplayItem=1
      if (mOp.Equal(intRelationalDisplayItem.get(),"")) {
        intRelationalDisplayItem.set(1);
      }
      //<< 
      //<< set blnMore  = $$$NO
      blnMore.set(include.COMSYS.$$$NO(m$));
      //<< set strField = ""
      strField.set("");
      //<< for intItem=1:1:$length(intRelationalDisplayItem,";") {
      for (intItem.set(1);(mOp.LessOrEqual(intItem.get(),m$.Fnc.$length(intRelationalDisplayItem.get(),";")));intItem.set(mOp.Add(intItem.get(),1))) {
        //<< if strField'="" set strField=strField_","
        if (mOp.NotEqual(strField.get(),"")) {
          strField.set(mOp.Concat(strField.get(),","));
        }
        //<< set strField=strField_$$$WWW003PropertyName($get(^WWW003(0,$$$WWW121RelationClass(objWWW121),$piece(intRelationalDisplayItem,";",intItem),1)))
        strField.set(mOp.Concat(strField.get(),include.WWWConst.$$$WWW003PropertyName(m$,m$.Fnc.$get(m$.var("^WWW003",0,include.WWWConst.$$$WWW121RelationClass(m$,objWWW121),m$.Fnc.$piece(intRelationalDisplayItem.get(),";",intItem.get()),1)))));
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set objWWW122=$$Get^WWW122(YFORM,YLFN)
      objWWW122.set(m$.fnc$("WWW122.Get",YFORM.get(),YLFN.get()));
      //<< set YOPTIONWIDTH=$$$WWW122MaxListWidth(objWWW122) ;CORE-79.3
      YOPTIONWIDTH.set(include.WWWConst.$$$WWW122MaxListWidth(m$,objWWW122));
      //<< 
      //<< set idClass=$$$WWW122RelationClass(objWWW122)
      idClass.set(include.WWWConst.$$$WWW122RelationClass(m$,objWWW122));
      //<< ;set idClass="^"_idClass_"("_YM_")"
      //<< set intRelationalDisplayItem=$$$WWW122RelationalDataField(objWWW122)
      intRelationalDisplayItem.set(include.WWWConst.$$$WWW122RelationalDataField(m$,objWWW122));
      //<< if intRelationalDisplayItem="" set intRelationalDisplayItem=1
      if (mOp.Equal(intRelationalDisplayItem.get(),"")) {
        intRelationalDisplayItem.set(1);
      }
      //<< 
      //<< set blnMore=$$$NO
      blnMore.set(include.COMSYS.$$$NO(m$));
      //<< set strField=""
      strField.set("");
      //<< for intItem=1:1:$length(intRelationalDisplayItem,";") {
      for (intItem.set(1);(mOp.LessOrEqual(intItem.get(),m$.Fnc.$length(intRelationalDisplayItem.get(),";")));intItem.set(mOp.Add(intItem.get(),1))) {
        //<< if strField'="" set strField=strField_","
        if (mOp.NotEqual(strField.get(),"")) {
          strField.set(mOp.Concat(strField.get(),","));
        }
        //<< ;CORE-75.6 set strField=strField_$$$WWW003PropertyName($get(^WWW003(0,$$$WWW122RelationClass(objWWW122),intItem,1)))
        //<< set strField=strField_$$$WWW003PropertyName($get(^WWW003(0,$$$WWW122RelationClass(objWWW122),$piece(intRelationalDisplayItem,";",intItem),1))) //CORE-75.7
        strField.set(mOp.Concat(strField.get(),include.WWWConst.$$$WWW003PropertyName(m$,m$.Fnc.$get(m$.var("^WWW003",0,include.WWWConst.$$$WWW122RelationClass(m$,objWWW122),m$.Fnc.$piece(intRelationalDisplayItem.get(),";",intItem.get()),1)))));
      }
    }
    //<< }
    //<< }
    //<< set intLines=$$SQL(idClass,strField,pstrText,.blnMore)
    intLines.set(m$.fnc$("SQL",idClass.get(),strField.get(),pstrText.get(),blnMore));
    //<< 
    //<< do PopulateComboBox(YFIELDNAME,pstrText,"CacheTempFATSearch",YUSER,$$$YES,YOPTIONWIDTH,blnMore,YMANDATORY) ;CORE-75.10
    m$.Cmd.Do("PopulateComboBox",YFIELDNAME.get(),pstrText.get(),"CacheTempFATSearch",m$.var("YUSER").get(),include.COMSYS.$$$YES(m$),YOPTIONWIDTH.get(),blnMore.get(),YMANDATORY.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SQLOrderBy(pidClass)
  public Object SQLOrderBy(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create the 'ORDER BY' clause for the SQL
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Nov-2011   shobby      SR17725: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strOrderBy,idField
    mVar strOrderBy = m$.var("strOrderBy");
    mVar idField = m$.var("idField");
    m$.newVar(strOrderBy,idField);
    //<< 
    //<< set strOrderBy=""
    strOrderBy.set("");
    //<< 
    //<< set idField="" for { set idField=$order(^WWW002(0,pidClass,idField)) quit:idField=""
    idField.set("");
    for (;true;) {
      idField.set(m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),idField.get())));
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< if strOrderBy'="" set strOrderBy=strOrderBy_","
      if (mOp.NotEqual(strOrderBy.get(),"")) {
        strOrderBy.set(mOp.Concat(strOrderBy.get(),","));
      }
      //<< set strOrderBy=strOrderBy_$$$WWW002PropertyName($get(^WWW002(0,pidClass,idField,1)))
      strOrderBy.set(mOp.Concat(strOrderBy.get(),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),idField.get(),1)))));
    }
    //<< }
    //<< if strOrderBy'="" set strOrderBy=" ORDER BY "_strOrderBy
    if (mOp.NotEqual(strOrderBy.get(),"")) {
      strOrderBy.set(mOp.Concat(" ORDER BY ",strOrderBy.get()));
    }
    //<< quit strOrderBy
    return strOrderBy.get();
  }

  //<< 
  //<< 
  //<< SQL(pstrClass,pstrField,pstrText,&pblnMore)
  public Object SQL(Object ... _p) {
    mVar pstrClass = m$.newVarRef("pstrClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnMore = m$.newVarRef("pblnMore",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Use SQL to select records.  This is slower than
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 01-Jul-2013   shobby      CORE-141: Improved search to recognise spaces in search.
    //<< ; 07-May-2013   shobby      CORE-79.1: Improved search.  'CAP' should return 'capsula' but not 'cabeca plastico'
    //<< ; 24-Apr-2013   shobby      CORE-75.10: Temporary data is subscripted by YUSER
    //<< ; 24-Apr-2013   shobby      CORE-75.9: Limit list to 10 items.
    //<< ; 10-Nov-2011   shobby      SR17725: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objResultSet,intLines,strData,strSQL,intMaxLines ;CORE-75.9
    mVar objResultSet = m$.var("objResultSet");
    mVar intLines = m$.var("intLines");
    mVar strData = m$.var("strData");
    mVar strSQL = m$.var("strSQL");
    mVar intMaxLines = m$.var("intMaxLines");
    m$.newVar(objResultSet,intLines,strData,strSQL,intMaxLines);
    //<< 
    //<< set intLines=0
    intLines.set(0);
    //<< set intMaxLines=10 ;CORE-75.9
    intMaxLines.set(10);
    //<< 
    //<< ;CORE-141 set pstrText=$$Index^COMUtils(pstrText)
    //<< 
    //<< ;CORE-79.1 set strSQL = "SELECT DISTINCT TOP("_(intMaxLines+1)_") "_pstrClass_".ID,"_pstrField_" FROM SQLUser."_pstrClass_" WHERE "_pstrClass_".Company="_YM_" AND (($find(%upper(SQLUser."_pstrClass_"."_pstrField_"),"""_pstrText_""")>0) OR ($find(%upper(SQLUser."_pstrClass_"."_$$$WWW002PropertyName($get(^WWW002(0,pstrClass,1,1)))_"),"""_pstrText_""")>0)) "_$$SQLOrderBy(pstrClass)
    //<< set strSQL = "SELECT DISTINCT TOP("_(intMaxLines+1)_") "_pstrClass_".ID,"_pstrField_" FROM SQLUser."_pstrClass_" WHERE "_pstrClass_".Company="_YM_" AND (SQLUser."_pstrClass_"."_pstrField_" LIKE ""%"_pstrText_"%"" OR SQLUser."_pstrClass_"."_$$$WWW002PropertyName($get(^WWW002(0,pstrClass,$order(^WWW002(0,pstrClass,""),-1),1)))_" LIKE ""%"_pstrText_"%"") "_$$SQLOrderBy(pstrClass) ;CORE-79.1
    strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("SELECT DISTINCT TOP(",(mOp.Add(intMaxLines.get(),1))),") "),pstrClass.get()),".ID,"),pstrField.get())," FROM SQLUser."),pstrClass.get())," WHERE "),pstrClass.get()),".Company="),m$.var("YM").get())," AND (SQLUser."),pstrClass.get()),"."),pstrField.get())," LIKE \"%"),pstrText.get()),"%\" OR SQLUser."),pstrClass.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pstrClass.get(),m$.Fnc.$order(m$.var("^WWW002",0,pstrClass.get(),""),mOp.Negative(1)),1))))," LIKE \"%"),pstrText.get()),"%\") "),m$.fnc$("SQLOrderBy",pstrClass.get())));
    //<< 
    //<< set objResultSet = ##class(%Library.ResultSet).%New()
    objResultSet.set(m$.fnc$("$Library.ResultSet.$New"));
    //<< if objResultSet.Prepare(strSQL) {
    if (mOp.Logical(m$.fnc$(objResultSet.getORef(),"Prepare",strSQL.get()))) {
      //<< if objResultSet.Execute() {
      if (mOp.Logical(m$.fnc$(objResultSet.getORef(),"Execute"))) {
        //<< while objResultSet.Next() {
        while (mOp.Logical(m$.fnc$(objResultSet.getORef(),"Next"))) {
          //<< set strData=objResultSet.Data(pstrField)
          strData.set(m$.fnc$(objResultSet.getORef(),"Data",pstrField.get()));
          //<< set strData=$extract(strData,1,300)
          strData.set(m$.Fnc.$extract(strData.get(),1,300));
          //<< set ^CacheTempFATSearch(YM,YUSER,$piece(objResultSet.Data("ID"),"||",2),1)=strData ;CORE-75.9 ;CORE-75.10
          m$.var("^CacheTempFATSearch",m$.var("YM").get(),m$.var("YUSER").get(),m$.Fnc.$piece(m$.fnc$(objResultSet.getORef(),"Data","ID"),"||",2),1).set(strData.get());
          //<< set intLines=intLines+1             ;CORE-75.9
          intLines.set(mOp.Add(intLines.get(),1));
          //<< if intLines=intMaxLines {           ;CORE-75.9
          if (mOp.Equal(intLines.get(),intMaxLines.get())) {
            //<< set intLines=intLines+1         ;CORE-75.9
            intLines.set(mOp.Add(intLines.get(),1));
            //<< set pblnMore=$$$YES
            pblnMore.set(include.COMSYS.$$$YES(m$));
            //<< quit
            break;
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit intLines
    return intLines.get();
  }

  //<< 
  //<< 
  //<< SoundEx(pstrText)
  public Object SoundEx(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Soundex search.  (Unfinished)
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Nov-2011   shobby      SR17725: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Ch, LastCh, i, sx
    mVar Ch = m$.var("Ch");
    mVar LastCh = m$.var("LastCh");
    mVar i = m$.var("i");
    mVar sx = m$.var("sx");
    m$.newVar(Ch,LastCh,i,sx);
    //<< 
    //<< set pstrText=$zcvt($zstrip(pstrText,"<>W"),"U")
    pstrText.set(m$.Fnc.$zconvert(m$.Fnc.$zstrip(pstrText.get(),"<>W"),"U"));
    //<< 
    //<< if $length(pstrText)<1 {
    if (mOp.Less(m$.Fnc.$length(pstrText.get()),1)) {
      //<< set sx=""
      sx.set("");
    }
    //<< } else {
    else {
      //<< set sx=$extract(pstrText)
      sx.set(m$.Fnc.$extract(pstrText.get()));
      //<< set $extract(pstrText,1)=""
      mVar $extract = m$.var("$extract");
      $extract.var(pstrText.get(),1).set("");
      //<< set sx=sx_$translate(pstrText,"BFPVCGJKQSXZDTLMNRAEHIOUWY1234567890 "  ,"111122222222334556")
      sx.set(mOp.Concat(sx.get(),m$.Fnc.$translate(pstrText.get(),"BFPVCGJKQSXZDTLMNRAEHIOUWY1234567890 ","111122222222334556")));
    }
    //<< }
    //<< for i=1:1:$length(sx) {
    for (i.set(1);(mOp.LessOrEqual(i.get(),m$.Fnc.$length(sx.get())));i.set(mOp.Add(i.get(),1))) {
      //<< if $extract(sx,i) = $extract(sx,i+1) {
      if (mOp.Equal(m$.Fnc.$extract(sx.get(),i.get()),m$.Fnc.$extract(sx.get(),mOp.Add(i.get(),1)))) {
        //<< set $extract(sx,i,i+1)=$extract(sx,i)
        mVar $extract = m$.var("$extract");
        $extract.var(sx.get(),i.get(),mOp.Add(i.get(),1)).set(m$.Fnc.$extract(sx.get(),i.get()));
      }
    }
    //<< }
    //<< }
    //<< for i=1:1:4 {
    for (i.set(1);(mOp.LessOrEqual(i.get(),4));i.set(mOp.Add(i.get(),1))) {
      //<< if $length(sx)<4 set sx=sx_"0"
      if (mOp.Less(m$.Fnc.$length(sx.get()),4)) {
        sx.set(mOp.Concat(sx.get(),"0"));
      }
    }
    //<< }
    //<< set sx=$extract(sx,1,4)
    sx.set(m$.Fnc.$extract(sx.get(),1,4));
    //<< quit sx
    return sx.get();
  }

  //<< 
  //<< 
  //<< PopulateComboBox(YFIELDNAME, pstrValue="", pstrRelationClass, pstrRelationKeys="",pblnForce=$$$NO,pintWidth="",pblnMore=$$$NO,YMANDATORY=$$$NO) ;SR17225
  public Object PopulateComboBox(Object ... _p) {
    mVar YFIELDNAME = m$.newVarRef("YFIELDNAME",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrRelationClass = m$.newVarRef("pstrRelationClass",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrRelationKeys = m$.newVarRef("pstrRelationKeys",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pblnForce = m$.newVarRef("pblnForce",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    mVar pintWidth = m$.newVarRef("pintWidth",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    mVar pblnMore = m$.newVarRef("pblnMore",(((_p!=null)&&(_p.length>=7))?_p[6]:null),include.COMSYS.$$$NO(m$));
    mVar YMANDATORY = m$.newVarRef("YMANDATORY",(((_p!=null)&&(_p.length>=8))?_p[7]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; This method is used to change a Datafield into a Combo Box. The options for
    //<< ; the combo box will be based on the relation class and on the relation primary
    //<< ; keys. This works exactly like on the relation of the data field definition.
    //<< ;
    //<< ; Params:   YFORM               - form name
    //<< ;           YLFN                - manual or data field number
    //<< ;           pstrValue           - value to be stored in field
    //<< ;           YART                - field type - "M" or "D"
    //<< ;           pstrRelationClass   - the relation class used to build the combo
    //<< ;           pstrRelationKeys    - the relation primary keys used together with the relation class
    //<< ;
    //<< ; History:
    //<< ; 03-Nov-2011   shobby  SR17725: Based on version in COMUtils
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idCompany,loop,objClass,strClassDef,strClassLoop,strCommand,strData
    mVar idClass = m$.var("idClass");
    mVar idCompany = m$.var("idCompany");
    mVar loop = m$.var("loop");
    mVar objClass = m$.var("objClass");
    mVar strClassDef = m$.var("strClassDef");
    mVar strClassLoop = m$.var("strClassLoop");
    mVar strCommand = m$.var("strCommand");
    mVar strData = m$.var("strData");
    m$.newVar(idClass,idCompany,loop,objClass,strClassDef,strClassLoop,strCommand,strData);
    //<< new strText,strMore,intStart
    mVar strText = m$.var("strText");
    mVar strMore = m$.var("strMore");
    mVar intStart = m$.var("intStart");
    m$.newVar(strText,strMore,intStart);
    //<< 
    //<< set objClass = $get(^WWW001(0,pstrRelationClass,1))
    objClass.set(m$.Fnc.$get(m$.var("^WWW001",0,pstrRelationClass.get(),1)));
    //<< if +$$$WWW001SharedFile(objClass) {
    if (mOp.Logical(mOp.Positive(include.WWWConst.$$$WWW001SharedFile(m$,objClass)))) {
      //<< set idCompany = 0
      idCompany.set(0);
    }
    //<< } else {
    else {
      //<< set idCompany = YM
      idCompany.set(m$.var("YM").get());
    }
    //<< }
    //<< 
    //<< // If the user set the primary keys for the relation database.
    //<< if pstrRelationKeys '= "" {
    if (mOp.NotEqual(pstrRelationKeys.get(),"")) {
      //<< set pstrRelationKeys=$$^WWWKEYBUILD(pstrRelationKeys)
      pstrRelationKeys.set(m$.fnc$("WWWKEYBUILD.main",pstrRelationKeys.get()));
      //<< set strClassDef = "^"_pstrRelationClass_"("_idCompany_","_pstrRelationKeys_",idClass"
      strClassDef.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",pstrRelationClass.get()),"("),idCompany.get()),","),pstrRelationKeys.get()),",idClass"));
    }
    //<< 
    //<< } else {
    else {
      //<< set strClassDef = "^"_pstrRelationClass_"("_idCompany_",idClass"
      strClassDef.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",pstrRelationClass.get()),"("),idCompany.get()),",idClass"));
    }
    //<< }
    //<< set strClassLoop = "set idClass = $order("_strClassDef_"))"
    strClassLoop.set(mOp.Concat(mOp.Concat("set idClass = $order(",strClassDef.get()),"))"));
    //<< 
    //<< // Get the values to be populated.
    //<< write "var arrValues = new Array();"
    m$.Cmd.Write("var arrValues = new Array();");
    //<< write "var arrKeys = new Array();"
    m$.Cmd.Write("var arrKeys = new Array();");
    //<< 
    //<< if YMANDATORY {
    if (mOp.Logical(YMANDATORY.get())) {
      //<< set intStart=1
      intStart.set(1);
      //<< write "arrValues[0]=' ';"
      m$.Cmd.Write("arrValues[0]=' ';");
      //<< write "arrKeys[0]='';"
      m$.Cmd.Write("arrKeys[0]='';");
    }
    //<< } else {
    else {
      //<< set intStart=1
      intStart.set(1);
      //<< ; not mandatory
      //<< write "arrValues[0]=' ';"
      m$.Cmd.Write("arrValues[0]=' ';");
      //<< write "arrKeys[0]='';"
      m$.Cmd.Write("arrKeys[0]='';");
    }
    //<< }
    //<< set idClass = ""
    idClass.set("");
    //<< for loop=intStart:1 {
    for (loop.set(intStart.get());(true);loop.set(mOp.Add(loop.get(),1))) {
      //<< xecute strClassLoop
      m$.Cmd.Xecute(strClassLoop.get());
      //<< quit:idClass=""
      if (mOp.Equal(idClass.get(),"")) {
        break;
      }
      //<< 
      //<< set strData    = ""
      strData.set("");
      //<< set strCommand = "set strData = $piece($get("_strClassDef_",1)),Y,1)"
      strCommand.set(mOp.Concat(mOp.Concat("set strData = $piece($get(",strClassDef.get()),",1)),Y,1)"));
      //<< xecute strCommand
      m$.Cmd.Xecute(strCommand.get());
      //<< 
      //<< set strData=$$Highlight(strData,pstrValue)
      strData.set(m$.fnc$("Highlight",strData.get(),pstrValue.get()));
      //<< 
      //<< ; TODO Don't display primary key if checked off.
      //<< set strText=$$Highlight(idClass,pstrValue)_" - "_strData
      strText.set(mOp.Concat(mOp.Concat(m$.fnc$("Highlight",idClass.get(),pstrValue.get())," - "),strData.get()));
      //<< set strText=$zconvert(" "_strText,"o","JS") ;Doesn't format in blue the first character.
      strText.set(m$.Fnc.$zconvert(mOp.Concat(" ",strText.get()),"o","JS"));
      //<< write "arrValues["_loop_"] = '"_strText_"';"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("arrValues[",loop.get()),"] = '"),strText.get()),"';"));
      //<< write "arrKeys["_loop_"] = '"_idClass_"';"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("arrKeys[",loop.get()),"] = '"),idClass.get()),"';"));
    }
    //<< }
    //<< if pblnMore {
    if (mOp.Logical(pblnMore.get())) {
      //<< set strMore=$$$Text("WWW00153")  ;more
      strMore.set(include.COMSYS.$$$Text(m$,"WWW00153"));
    }
    //<< } else {
    else {
      //<< set strMore=""
      strMore.set("");
    }
    //<< }
    //<< write "FATListCreate('"_YFIELDNAME_"',arrValues,arrKeys,'"_strMore_"','"_pintWidth_"');"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("FATListCreate('",YFIELDNAME.get()),"',arrValues,arrKeys,'"),strMore.get()),"','"),pintWidth.get()),"');"));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Highlight(pstrData,pstrValue)
  public Object Highlight(Object ... _p) {
    mVar pstrData = m$.newVarRef("pstrData",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Puts a blue highlight around the specified value in the longer text.  (Case insensitive)
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Nov-2011   shobby      SR17725: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strText,int,strData,intLast,len
    mVar strText = m$.var("strText");
    mVar _int = m$.var("_int");
    mVar strData = m$.var("strData");
    mVar intLast = m$.var("intLast");
    mVar len = m$.var("len");
    m$.newVar(strText,_int,strData,intLast,len);
    //<< 
    //<< if pstrValue="" {
    if (mOp.Equal(pstrValue.get(),"")) {
      //<< set strText=pstrData
      strText.set(pstrData.get());
    }
    //<< } else {
    else {
      //<< set strText=""
      strText.set("");
      //<< set strData =$$$UPPER($$^WWWUMLAU(pstrData))
      strData.set(include.COMSYSString.$$$UPPER(m$,m$.fnc$("WWWUMLAU.main",pstrData.get())));
      //<< set pstrValue=$$$UPPER($$^WWWUMLAU(pstrValue))
      pstrValue.set(include.COMSYSString.$$$UPPER(m$,m$.fnc$("WWWUMLAU.main",pstrValue.get())));
      //<< set len=$length(pstrValue)
      len.set(m$.Fnc.$length(pstrValue.get()));
      //<< if $find(strData,pstrValue)>0 {
      if (mOp.Greater(m$.Fnc.$find(strData.get(),pstrValue.get()),0)) {
        //<< set int=0
        _int.set(0);
        //<< for {
        for (;true;) {
          //<< set intLast=int
          intLast.set(_int.get());
          //<< set int=$find(strData,pstrValue,int)
          _int.set(m$.Fnc.$find(strData.get(),pstrValue.get(),_int.get()));
          //<< if int=0 {
          if (mOp.Equal(_int.get(),0)) {
            //<< set strText=strText_$extract(pstrData,intLast,$length(pstrData))
            strText.set(mOp.Concat(strText.get(),m$.Fnc.$extract(pstrData.get(),intLast.get(),m$.Fnc.$length(pstrData.get()))));
          }
          //<< } else {
          else {
            //<< set strText=strText_$extract(pstrData,intLast,int-len-1)_"<strong>"_$extract(pstrData,int-len,int-1)_"</strong>"
            strText.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strText.get(),m$.Fnc.$extract(pstrData.get(),intLast.get(),mOp.Subtract(mOp.Subtract(_int.get(),len.get()),1))),"<strong>"),m$.Fnc.$extract(pstrData.get(),mOp.Subtract(_int.get(),len.get()),mOp.Subtract(_int.get(),1))),"</strong>"));
          }
          //<< }
          //<< quit:int=0
          if (mOp.Equal(_int.get(),0)) {
            break;
          }
        }
      }
      //<< }
      //<< } else {
      else {
        //<< set strText=pstrData
        strText.set(pstrData.get());
      }
    }
    //<< }
    //<< }
    //<< quit strText
    return strText.get();
  }

//<< 
}
