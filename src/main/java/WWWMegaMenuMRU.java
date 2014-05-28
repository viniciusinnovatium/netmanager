//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMegaMenuMRU
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:32
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

//<< WWWMegaMenuMRU
public class WWWMegaMenuMRU extends mClass {

  public void main() {
    _WWWMegaMenuMRU();
  }

  public void _WWWMegaMenuMRU() {
  }

  //<< 
  //<< 
  //<< Javascript()
  public Object Javascript(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Javascript functions to support menu operation
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Jun-2013   shobby      CORE-127: Remove event from MRU List.  Causes Firefox to close MRU menu unexpectedly.
    //<< ; 24-May-2013   shobby      CORE-81.6.b: Position MRU list to the left if it won't fit on the right.
    //<< ; 21-May-2013   shobby      CORE-81.3.11: Decrease MRU secondary box size (doesn?t have to be so big, is causing a scroll)
    //<< ; 01-May-2012   shobby      SR17998: Created.
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< &js<
    //<< function getPageOffsetTopX(Object) {
    //<< var y=Object.offsetTop;
    //<< if ((Object.offsetParent != null)&&(Object.offsetParent.id!='menu')) {
    //<< y += getPageOffsetTop(Object.offsetParent);
    //<< }
    //<< return y;
    //<< }
    //<< 
    //<< function mruDisplayItems(pobj) {
    //<< var obj=getParent(pobj,'p');
    //<< //var obj=getParent(window.event.srcElement,'p');
    //<< var objDiv=document.getElementById('mrulist');
    //<< if (objDiv==null) {
    //<< var objDiv=document.createElement('div');
    //<< //CORE-127 objDiv.attachEvent('onmousemove',function() {window.event.cancelBubble=true; window.event.returnValue=false; return false;});
    //<< document.getElementById('menuLi_4').appendChild(objDiv);
    //<< }
    //<< var retval = EventValue('#(YUCI)#','#(YUSER)#','#(YFORM)#','FIX','EVENT^WWWMegaMenu','GETMRU_ITEMS','6',obj.id.split('_')[1]);
    //<< if (retval=='') {
    //<< objDiv.style.display='none';
    //<< } else {
    //<< objDiv.style.display='block';
    //<< objDiv.innerHTML=retval;
    //<< objDiv.id='mrulist';
    //<< with (objDiv.style) {
    //<< var objMenuDiv=document.getElementById('menuDiv_4');
    //<< width='#($select(YUSERAGENT="MSIE":"100px",1:"auto"))#';
    //<< if ((getPageOffsetLeft(objMenuDiv)+objMenuDiv.offsetWidth+objDiv.offsetWidth-5)&gt;document.body.offsetWidth) {
    //<< left=(-objDiv.clientWidth+5)+'px';
    //<< objDiv.className='mrulist_left';
    //<< } else {
    //<< left=(objMenuDiv.offsetLeft+objMenuDiv.offsetWidth-5)+'px';
    //<< objDiv.className='mrulist';
    //<< }
    //<< top=(getPageOffsetTopX(obj)-10)+'px';
    //<< }
    //<< }
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("    function getPageOffsetTopX(Object) {","\n");
    m$.Cmd.WriteJS("     var y=Object.offsetTop;","\n");
    m$.Cmd.WriteJS("     if ((Object.offsetParent != null)&&(Object.offsetParent.id!='menu')) {","\n");
    m$.Cmd.WriteJS("         y += getPageOffsetTop(Object.offsetParent);","\n");
    m$.Cmd.WriteJS("     }","\n");
    m$.Cmd.WriteJS("     return y;","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    function mruDisplayItems(pobj) {","\n");
    m$.Cmd.WriteJS("        var obj=getParent(pobj,'p');","\n");
    m$.Cmd.WriteJS("        //var obj=getParent(window.event.srcElement,'p');","\n");
    m$.Cmd.WriteJS("        var objDiv=document.getElementById('mrulist');","\n");
    m$.Cmd.WriteJS("        if (objDiv==null) {","\n");
    m$.Cmd.WriteJS("            var objDiv=document.createElement('div');","\n");
    m$.Cmd.WriteJS("            //CORE-127 objDiv.attachEvent('onmousemove',function() {window.event.cancelBubble=true; window.event.returnValue=false; return false;});","\n");
    m$.Cmd.WriteJS("            document.getElementById('menuLi_4').appendChild(objDiv);","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("        var retval = EventValue('",(m$.var("YUCI").get())),")','"),(m$.var("YUSER").get())),")','"),(m$.var("YFORM").get())),")','FIX','EVENT^WWWMegaMenu','GETMRU_ITEMS','6',obj.id.split('_')[1]);"),"\n");
    m$.Cmd.WriteJS("        if (retval=='') {","\n");
    m$.Cmd.WriteJS("            objDiv.style.display='none';","\n");
    m$.Cmd.WriteJS("        } else {","\n");
    m$.Cmd.WriteJS("            objDiv.style.display='block';","\n");
    m$.Cmd.WriteJS("            objDiv.innerHTML=retval;","\n");
    m$.Cmd.WriteJS("            objDiv.id='mrulist';","\n");
    m$.Cmd.WriteJS("            with (objDiv.style) {","\n");
    m$.Cmd.WriteJS("                var objMenuDiv=document.getElementById('menuDiv_4');","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("                width='",(m$.Fnc.$select(mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE"),"100px",1,"auto"))),")';"),"\n");
    m$.Cmd.WriteJS("                if ((getPageOffsetLeft(objMenuDiv)+objMenuDiv.offsetWidth+objDiv.offsetWidth-5)&gt;document.body.offsetWidth) {","\n");
    m$.Cmd.WriteJS("                    left=(-objDiv.clientWidth+5)+'px';","\n");
    m$.Cmd.WriteJS("                    objDiv.className='mrulist_left';","\n");
    m$.Cmd.WriteJS("                } else {","\n");
    m$.Cmd.WriteJS("                    left=(objMenuDiv.offsetLeft+objMenuDiv.offsetWidth-5)+'px';","\n");
    m$.Cmd.WriteJS("                    objDiv.className='mrulist';","\n");
    m$.Cmd.WriteJS("                }","\n");
    m$.Cmd.WriteJS("                top=(getPageOffsetTopX(obj)-10)+'px';","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ");
    //<< quit
    return null;
  }

  //<< 
  //<< GetMRUMenu()
  public Object GetMRUMenu(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the MRU menu
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; Language Texts
    //<< ;   WWW00165:  MRU
    //<< ;
    //<< ; History:
    //<< ; 23-Apr-2012   shobby      SR17998: Language Texts
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new HTML
    mVar HTML = m$.var("HTML");
    m$.newVar(HTML);
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< set HTML=HTML_"<li class='mruSeparator'>|</li>"
    HTML.set(mOp.Concat(HTML.get(),"<li class='mruSeparator'>|</li>"));
    //<< set HTML=HTML_"<li id='menuLi_4' class='li' hclass='lihover' zclass='li' "_$$Events^WWWMegaMenu(1)_"><a id='menuA_4' href='#' class='drop'>"_$$$Text("WWW00165")_"</a>"
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"<li id='menuLi_4' class='li' hclass='lihover' zclass='li' "),m$.fnc$("WWWMegaMenu.Events",1)),"><a id='menuA_4' href='#' class='drop'>"),include.COMSYS.$$$Text(m$,"WWW00165")),"</a>"));
    //<< set HTML=HTML_"<div id='menuDiv_4' _CallBack='GETMRU_INTERNAL'>"
    HTML.set(mOp.Concat(HTML.get(),"<div id='menuDiv_4' _CallBack='GETMRU_INTERNAL'>"));
    //<< set HTML=HTML_"</div>"
    HTML.set(mOp.Concat(HTML.get(),"</div>"));
    //<< set HTML=HTML_"</li>"
    HTML.set(mOp.Concat(HTML.get(),"</li>"));
    //<< set HTML=HTML_"<li class='mruSeparator'>|</li>"
    HTML.set(mOp.Concat(HTML.get(),"<li class='mruSeparator'>|</li>"));
    //<< 
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< 
  //<< GetMRUMenuInternal()
  public Object GetMRUMenuInternal(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the MRU menu
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; Language Texts
    //<< ;   WWW00164:  Most Recently Used
    //<< ;
    //<< ; History:
    //<< ; 11-Jun-2013   shobby      CORE-108.3: Rewrote to use WWW1265 global for MRU
    //<< ; 07-Jun-2013   shobby      CORE-124: Change cursor to inicate no click on 'Search' menu.  Click on submenus.
    //<< ; 28-May-2013   shobby      CORE-81: Remove padding.
    //<< ; 23-May-2013   shobby      CORE-108.1: Don't show the WWWBLANK form in the MRU
    //<< ; 20-May-2013   shobby      CORE-81.3.6: Replace unicode arrow by nicer looking arrow image
    //<< ; 20-May-2013   shobby      CORE-81.3.5: Replace yellow pin by star and fix vertical alignment between image and menu item
    //<< ; 20-May-2013   shobby      CORE-81.3.4: Enhances MRU Menu padding
    //<< ; 23-Apr-2012   shobby      SR17998: Language Texts
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new HTML,intCount,idForm,idxForm,idDate,idTime,idLastForm,arrForms
    mVar HTML = m$.var("HTML");
    mVar intCount = m$.var("intCount");
    mVar idForm = m$.var("idForm");
    mVar idxForm = m$.var("idxForm");
    mVar idDate = m$.var("idDate");
    mVar idTime = m$.var("idTime");
    mVar idLastForm = m$.var("idLastForm");
    mVar arrForms = m$.var("arrForms");
    m$.newVar(HTML,intCount,idForm,idxForm,idDate,idTime,idLastForm,arrForms);
    //<< new blnReindexRequired
    mVar blnReindexRequired = m$.var("blnReindexRequired");
    m$.newVar(blnReindexRequired);
    //<< ;;;;new YPARA,objWWW1265 ;CORE-108.3
    //<< 
    //<< set intCount=0
    intCount.set(0);
    //<< set idLastForm=""
    idLastForm.set("");
    //<< set blnReindexRequired=$$$NO
    blnReindexRequired.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< set HTML=HTML_"  <div id='menuDiv_4' class='dropdown_1column' zclass='dropdown_1column' style='padding:10px; width:275px; -moz-box-sizing:content-box;'>"
    HTML.set(mOp.Concat(HTML.get(),"  <div id='menuDiv_4' class='dropdown_1column' zclass='dropdown_1column' style='padding:10px; width:275px; -moz-box-sizing:content-box;'>"));
    //<< set HTML=HTML_"    <div style=' height:100%; width:100%;'>" ;CORE-81.3.4 ;Required to stop menu hiding when mouse moves over padding.
    HTML.set(mOp.Concat(HTML.get(),"    <div style=' height:100%; width:100%;'>"));
    //<< set HTML=HTML_"    <div class='col_6' style='width:100%;'>"
    HTML.set(mOp.Concat(HTML.get(),"    <div class='col_6' style='width:100%;'>"));
    //<< set HTML=HTML_"      <h2>"_$$$Text("WWW00164")_"</h2>"
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"      <h2>"),include.COMSYS.$$$Text(m$,"WWW00164")),"</h2>"));
    //<< set HTML=HTML_"    </div>"
    HTML.set(mOp.Concat(HTML.get(),"    </div>"));
    //<< set HTML=HTML_"    <div id='menucontents_4' class='col_6' style='overflow-y:auto; overflow-x:hidden; width:100%; '>" ;CORE-81.4
    HTML.set(mOp.Concat(HTML.get(),"    <div id='menucontents_4' class='col_6' style='overflow-y:auto; overflow-x:hidden; width:100%; '>"));
    //<< set HTML=HTML_"      <ul>"
    HTML.set(mOp.Concat(HTML.get(),"      <ul>"));
    //<< 
    //<< set idDate="" for { set idDate=$order(^WWWBENCHs(0,1,YBED,idDate),-1) quit:idDate=""
    idDate.set("");
    for (;true;) {
      idDate.set(m$.Fnc.$order(m$.var("^WWWBENCHs",0,1,m$.var("YBED").get(),idDate.get()),mOp.Negative(1)));
      if (mOp.Equal(idDate.get(),"")) {
        break;
      }
      //<< if (idDate>$h) {
      if ((mOp.Greater(idDate.get(),m$.Fnc.$horolog()))) {
        //<< kill ^WWWBENCHs(YM,1,YBED,idDate)
        m$.var("^WWWBENCHs",m$.var("YM").get(),1,m$.var("YBED").get(),idDate.get()).kill();
        //<< kill ^WWWBENCH(YM,idDate)
        m$.var("^WWWBENCH",m$.var("YM").get(),idDate.get()).kill();
        //<< set blnReindexRequired=$$$YES
        blnReindexRequired.set(include.COMSYS.$$$YES(m$));
      }
      //<< }
      //<< set idTime="" for { set idTime=$order(^WWWBENCHs(0,1,YBED,idDate,idTime),-1) quit:idTime=""
      idTime.set("");
      for (;true;) {
        idTime.set(m$.Fnc.$order(m$.var("^WWWBENCHs",0,1,m$.var("YBED").get(),idDate.get(),idTime.get()),mOp.Negative(1)));
        if (mOp.Equal(idTime.get(),"")) {
          break;
        }
        //<< set idForm="" for { set idForm=$order(^WWWBENCHs(0,1,YBED,idDate,idTime,idForm),-1) quit:idForm=""
        idForm.set("");
        for (;true;) {
          idForm.set(m$.Fnc.$order(m$.var("^WWWBENCHs",0,1,m$.var("YBED").get(),idDate.get(),idTime.get(),idForm.get()),mOp.Negative(1)));
          if (mOp.Equal(idForm.get(),"")) {
            break;
          }
          //<< continue:idForm="WWWBLANK" ;CORE-108.1
          if (mOp.Equal(idForm.get(),"WWWBLANK")) {
            continue;
          }
          //<< if $data(^WWW1265(YM,YBED,idForm)) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1265",m$.var("YM").get(),m$.var("YBED").get(),idForm.get())))) {
            //<< quit:intCount=10
            if (mOp.Equal(intCount.get(),10)) {
              break;
            }
            //<< if '$data(arrForms(idForm)) {
            if (mOp.Not(m$.Fnc.$data(arrForms.var(idForm.get())))) {
              //<< ;set idForm=$$GetFormId($$$Index(YBED),idxForm)
              //<< ;CORE-81.3.5 set HTML=HTML_"    <li style='width:100%;'>"
              //<< set HTML=HTML_" <li style='width:"_$select(YUSERAGENT="MSIE":100,1:95)_"%;list-style-type:none;list-style-position:outside;padding-left:13px;background-image:url("_YGIF_"favorite2.gif);background-repeat:no-repeat;background-position: left center;'>" ;CORE-81.3.5
              HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get()," <li style='width:"),m$.Fnc.$select(mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE"),100,1,95)),"%;list-style-type:none;list-style-position:outside;padding-left:13px;background-image:url("),m$.var("YGIF").get()),"favorite2.gif);background-repeat:no-repeat;background-position: left center;'>"));
              //<< if YUSERAGENT="MSIE" {
              if (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")) {
                //<< set HTML=HTML_"      <p id='mru_"_idForm_"' style='_margin:0px; cursor:pointer;' onmouseover='mruDisplayItems(event.srcElement);'>"
                HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"      <p id='mru_"),idForm.get()),"' style='_margin:0px; cursor:pointer;' onmouseover='mruDisplayItems(event.srcElement);'>"));
              }
              //<< } else {
              else {
                //<< set HTML=HTML_"      <p id='mru_"_idForm_"' style='_margin:0px; cursor:pointer;' onmouseover='mruDisplayItems(this);'>"
                HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"      <p id='mru_"),idForm.get()),"' style='_margin:0px; cursor:pointer;' onmouseover='mruDisplayItems(this);'>"));
              }
              //<< }
              //<< 
              //<< ;CORE-108.3 set HTML=HTML_"        <a class='menuitem' href='"_YAKTION_"&EP=WWWFORM&YFORM="_idForm_$$WWWCGI2^WWWCGI()_"' >"
              //<< set HTML=HTML_"        <a class='menuitem' "
              HTML.set(mOp.Concat(HTML.get(),"        <a class='menuitem' "));
              //<< 
              //<< if idForm="COMViewSearch" {                                                             ;CORE-124
              if (mOp.Equal(idForm.get(),"COMViewSearch")) {
                //<< set HTML=HTML_" style='cursor:default;'"                                            ;CORE-124
                HTML.set(mOp.Concat(HTML.get()," style='cursor:default;'"));
              }
              //<< } else {                                                                                ;CORE-124
              else {
                //<< set HTML=HTML_"href='"_$$GetHREF("WWWFORM",idForm,idForm,$order(^WWW1265(YM,YBED,idForm,"")))_"'" ;CORE-124
                HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"href='"),m$.fnc$("GetHREF","WWWFORM",idForm.get(),idForm.get(),m$.Fnc.$order(m$.var("^WWW1265",m$.var("YM").get(),m$.var("YBED").get(),idForm.get(),"")))),"'"));
              }
              //<< }                                                                                       ;CORE-124
              //<< set HTML=HTML_" >"
              HTML.set(mOp.Concat(HTML.get()," >"));
              //<< 
              //<< 
              //<< ;CORE-81.3.5 set HTML=HTML_"         <img src='"_YGIF_"YellowPin.gif' style='border:none; height:16px; width:8px;'>"
              //<< ;CORE-81.3.5 set HTML=HTML_"          <img src='"_YGIF_$$GetMenuImage^WWWMegaMenu(idForm)_"' style='position:relative; border:none;'>  "
              //<< set HTML=HTML_$$^WWWFORMNAME(idForm)
              HTML.set(mOp.Concat(HTML.get(),m$.fnc$("WWWFORMNAME.main",idForm.get())));
              //<< set HTML=HTML_"        </a>"
              HTML.set(mOp.Concat(HTML.get(),"        </a>"));
              //<< if $data(^WWW1262(0,idForm,YBED))||(idForm="COMViewSearch") {
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1262",0,idForm.get(),m$.var("YBED").get()))) || (mOp.Equal(idForm.get(),"COMViewSearch"))) {
                //<< ;CORE-108.3 if ($data(^WWW1265(YM,YBED,idForm))&&($get(^WWW1265(YM,YBED,idForm,"YKEY"))'="")&&($$ClassUsedInForm^WWW120(idForm)'=""))||(idForm="COMViewSearch") { ;CORE-108.3
                //<< set HTML=HTML_"<font style='position:absolute; float:right; right:0px;padding-top:8px;'>" ;CORE-81.3.6
                HTML.set(mOp.Concat(HTML.get(),"<font style='position:absolute; float:right; right:0px;padding-top:8px;'>"));
                //<< ;set HTML=HTML_$zcvt("&#x"_"25BA;","i","HTML") ;Black Right-Pointing Arrow                ;CORE-81.3.6
                //<< set HTML=HTML_"<img src='"_YGIF_"arrow_right2.gif' border='0' />"                         ;CORE-81.3.6
                HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"<img src='"),m$.var("YGIF").get()),"arrow_right2.gif' border='0' />"));
                //<< set HTML=HTML_"</font>"                                                                   ;CORE-81.3.6
                HTML.set(mOp.Concat(HTML.get(),"</font>"));
              }
              //<< }
              //<< set HTML=HTML_"      </p>"
              HTML.set(mOp.Concat(HTML.get(),"      </p>"));
              //<< set HTML=HTML_"    </li>"
              HTML.set(mOp.Concat(HTML.get(),"    </li>"));
              //<< set intCount=intCount+1
              intCount.set(mOp.Add(intCount.get(),1));
              //<< set arrForms(idForm)=""
              arrForms.var(idForm.get()).set("");
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
    //<< set HTML=HTML_"      </ul>"
    HTML.set(mOp.Concat(HTML.get(),"      </ul>"));
    //<< set HTML=HTML_"    </div>"
    HTML.set(mOp.Concat(HTML.get(),"    </div>"));
    //<< set HTML=HTML_"  </div>"  ;CORE-81.3.4
    HTML.set(mOp.Concat(HTML.get(),"  </div>"));
    //<< set HTML=HTML_"  </div>"
    HTML.set(mOp.Concat(HTML.get(),"  </div>"));
    //<< 
    //<< if blnReindexRequired job ReIndex^COMIndex("WWWBENCH")
    if (mOp.Logical(blnReindexRequired.get())) {
      m$.Cmd.Job("COMIndex.ReIndex","WWWBENCH");
    }
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< GetHREF(EP,idYFORM,YFORM,pid)
  public Object GetHREF(Object ... _p) {
    mVar EP = m$.newVarRef("EP",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar idYFORM = m$.newVarRef("idYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ; also available EP,HYPER,HYPERTEST,XMLHTTPREQ,YBED,YFORM,YM,YUCI,YUSER
    //<< new HREF,objWWW1265,YPARA,YANZ,YTRAKT,YASTART,YNAME,objWWW1265
    mVar HREF = m$.var("HREF");
    mVar objWWW1265 = m$.var("objWWW1265");
    mVar YPARA = m$.var("YPARA");
    mVar YANZ = m$.var("YANZ");
    mVar YTRAKT = m$.var("YTRAKT");
    mVar YASTART = m$.var("YASTART");
    mVar YNAME = m$.var("YNAME");
    m$.newVar(HREF,objWWW1265,YPARA,YANZ,YTRAKT,YASTART,YNAME,objWWW1265);
    //<< 
    //<< set HREF=""
    HREF.set("");
    //<< if pid'="" {
    if (mOp.NotEqual(pid.get(),"")) {
      //<< set objWWW1265=$get(^WWW1265(YM,YBED,YFORM,pid,1))
      objWWW1265.set(m$.Fnc.$get(m$.var("^WWW1265",m$.var("YM").get(),m$.var("YBED").get(),YFORM.get(),pid.get(),1)));
      //<< set YANZ=$piece(objWWW1265,Y,1)
      YANZ.set(m$.Fnc.$piece(objWWW1265.get(),m$.var("Y").get(),1));
      //<< set YASTART=$piece(objWWW1265,Y,2)
      YASTART.set(m$.Fnc.$piece(objWWW1265.get(),m$.var("Y").get(),2));
      //<< set YNAME=$piece(objWWW1265,Y,3)
      YNAME.set(m$.Fnc.$piece(objWWW1265.get(),m$.var("Y").get(),3));
      //<< if YFORM="COMViewSearch" {
      if (mOp.Equal(YFORM.get(),"COMViewSearch")) {
        //<< set YPARA=""
        YPARA.set("");
      }
      //<< } else {
      else {
        //<< set YPARA=$piece(objWWW1265,Y,20,$length(objWWW1265,Y))
        YPARA.set(m$.Fnc.$piece(objWWW1265.get(),m$.var("Y").get(),20,m$.Fnc.$length(objWWW1265.get(),m$.var("Y").get())));
        //<< if $length(YPARA,Y)=1 set YPARA=YPARA_Y
        if (mOp.Equal(m$.Fnc.$length(YPARA.get(),m$.var("Y").get()),1)) {
          YPARA.set(mOp.Concat(YPARA.get(),m$.var("Y").get()));
        }
      }
      //<< }
      //<< set HREF=YAKTION_"&EP="_EP_"&YFORM="_idYFORM_$$WWWCGI2^WWWCGI()
      HREF.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"&EP="),EP.get()),"&YFORM="),idYFORM.get()),m$.fnc$("WWWCGI.WWWCGI2")));
    }
    //<< }
    //<< quit HREF
    return HREF.get();
  }

  //<< 
  //<< GetMRUItems(YFORM)
  public Object GetMRUItems(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; List of MRU items for each form.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Jun-2013   shobby      CORE-108.3: Rewrote to use WWW1265 global for MRU
    //<< ; 11-Jun-2013   shobby      CORE-124.1: Display form header rather than name
    //<< ; 23-May-2013   shobby      CORE-108.2: Changes so that recent forms started as a search will show in MRU.
    //<< ; 21-May-2013   shobby      CORE-81.3.10: Remove menu image on secondary level navigation and decrease padding for secondary (comment line)
    //<< ; 01-May-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new HTML,YSORT,intItems,YVOR,YDATEI,YA,YK,YKEY,YLSTKEY
    mVar HTML = m$.var("HTML");
    mVar YSORT = m$.var("YSORT");
    mVar intItems = m$.var("intItems");
    mVar YVOR = m$.var("YVOR");
    mVar YDATEI = m$.var("YDATEI");
    mVar YA = m$.var("YA");
    mVar YK = m$.var("YK");
    mVar YKEY = m$.var("YKEY");
    mVar YLSTKEY = m$.var("YLSTKEY");
    m$.newVar(HTML,YSORT,intItems,YVOR,YDATEI,YA,YK,YKEY,YLSTKEY);
    //<< new EP,idYFORM ;CORE-108.2
    mVar EP = m$.var("EP");
    mVar idYFORM = m$.var("idYFORM");
    m$.newVar(EP,idYFORM);
    //<< new objWWW1265,YPARA,YANZ ;CORE-108.3
    mVar objWWW1265 = m$.var("objWWW1265");
    mVar YPARA = m$.var("YPARA");
    mVar YANZ = m$.var("YANZ");
    m$.newVar(objWWW1265,YPARA,YANZ);
    //<< 
    //<< set YVOR=$get(^WWW120(0,YFORM,1))
    YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)));
    //<< set YDATEI=$$$WWW120ClassUsedInForm(YVOR)
    YDATEI.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,YVOR));
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< set YSORT=""
    YSORT.set("");
    //<< set YLSTKEY=""
    YLSTKEY.set("");
    //<< 
    //<< for YI=1:1 {
    mVar YI = m$.var("YI");
    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
      //<< set YSORT=$order(^WWW1265(YM,YBED,YFORM,YSORT),-1)
      YSORT.set(m$.Fnc.$order(m$.var("^WWW1265",m$.var("YM").get(),m$.var("YBED").get(),YFORM.get(),YSORT.get()),mOp.Negative(1)));
      //<< quit:YSORT=""                                                                                           ;CORE-108.3
      if (mOp.Equal(YSORT.get(),"")) {
        break;
      }
      //<< set objWWW1265=$get(^WWW1265(YM,YBED,YFORM,YSORT,1))
      objWWW1265.set(m$.Fnc.$get(m$.var("^WWW1265",m$.var("YM").get(),m$.var("YBED").get(),YFORM.get(),YSORT.get(),1)));
      //<< if YDATEI'="" {
      if (mOp.NotEqual(YDATEI.get(),"")) {
        //<< if (YI>$$$WWW120NumberofMRURecordListItem(YVOR))||('$$Exists^WWW1265(YFORM,YBED,YSORT,YDATEI)) {
        if ((mOp.Greater(YI.get(),include.WWWConst.$$$WWW120NumberofMRURecordListItem(m$,YVOR))) || (mOp.Not(m$.fnc$("WWW1265.Exists",YFORM.get(),m$.var("YBED").get(),YSORT.get(),YDATEI.get())))) {
          //<< if $piece(objWWW1265,Y,4)'="" { ;YKEY
          if (mOp.NotEqual(m$.Fnc.$piece(objWWW1265.get(),m$.var("Y").get(),4),"")) {
            //<< kill ^WWW1265(YM,YBED,YFORM,YSORT) continue
            m$.var("^WWW1265",m$.var("YM").get(),m$.var("YBED").get(),YFORM.get(),YSORT.get()).kill();
            continue;
          }
        }
      }
      //<< }
      //<< }
      //<< } else {
      else {
        //<< if YI>1 kill ^WWW1265(YM,YBED,YFORM,YSORT) continue         ;CORE-108.3
        if (mOp.Greater(YI.get(),1)) {
          m$.var("^WWW1265",m$.var("YM").get(),m$.var("YBED").get(),YFORM.get(),YSORT.get()).kill();
          continue;
        }
      }
      //<< }
      //<< set YK=""
      YK.set("");
      //<< if YFORM="COMViewSearch" {
      if (mOp.Equal(YFORM.get(),"COMViewSearch")) {
        //<< set YA=$piece(objWWW1265,Y,20,$length(objWWW1265,Y)) ;YPARA
        YA.set(m$.Fnc.$piece(objWWW1265.get(),m$.var("Y").get(),20,m$.Fnc.$length(objWWW1265.get(),m$.var("Y").get())));
        //<< if $$IsList^COMUtils(YA) {
        if (mOp.Logical(m$.fnc$("COMUtils.IsList",YA.get()))) {
          //<< set YA=$listget(YA)
          YA.set(m$.Fnc.$listget(YA.get()));
        }
      }
      //<< }
      //<< } else {
      else {
        //<< set YA=$piece(objWWW1265,Y,4) ;YKEY
        YA.set(m$.Fnc.$piece(objWWW1265.get(),m$.var("Y").get(),4));
      }
      //<< }
      //<< if YA'="" { ;CORE-108.3
      if (mOp.NotEqual(YA.get(),"")) {
        //<< if YLSTKEY'="" if $listfind(YLSTKEY,YA) kill ^WWW1265(YM,YBED,YFORM,YSORT) set YI=YI-1 continue ;CORE-108.3
        if (mOp.NotEqual(YLSTKEY.get(),"")) {
          if (mOp.Logical(m$.Fnc.$listfind(YLSTKEY.get(),YA.get()))) {
            m$.var("^WWW1265",m$.var("YM").get(),m$.var("YBED").get(),YFORM.get(),YSORT.get()).kill();
            YI.set(mOp.Subtract(YI.get(),1));
            continue;
          }
        }
        //<< set YLSTKEY=YLSTKEY_$listbuild(YA)
        YLSTKEY.set(mOp.Concat(YLSTKEY.get(),m$.Fnc.$listbuild(YA.get())));
        //<< 
        //<< ; CORE-108.2 vvvv
        //<< if $extract(YA)="," set YA=$extract(YA,3,200)
        if (mOp.Equal(m$.Fnc.$extract(YA.get()),",")) {
          YA.set(m$.Fnc.$extract(YA.get(),3,200));
        }
        //<< if YFORM="COMViewSearch" {
        if (mOp.Equal(YFORM.get(),"COMViewSearch")) {
          //<< set EP="WWWSEAR"
          EP.set("WWWSEAR");
          //<< set idYFORM=YA
          idYFORM.set(YA.get());
          //<< set YPARA=Y
          YPARA.set(m$.var("Y").get());
          //<< set YA=$$^WWWFORMNAME(YA) ;CORE-124.2
          YA.set(m$.fnc$("WWWFORMNAME.main",YA.get()));
        }
        //<< } else {
        else {
          //<< set EP="WWWFORM"
          EP.set("WWWFORM");
          //<< set idYFORM=YFORM
          idYFORM.set(YFORM.get());
        }
        //<< }
        //<< set YKEY=YA
        YKEY.set(YA.get());
        //<< set HTML=HTML_"<li><div>"
        HTML.set(mOp.Concat(HTML.get(),"<li><div>"));
        //<< set HTML=HTML_"<a class='menuitem' style='padding-top:0;padding-bottom:0;' href='"_$$GetHREF(EP,idYFORM,YFORM,YSORT)_"' >" ;CORE-81.3.10
        HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"<a class='menuitem' style='padding-top:0;padding-bottom:0;' href='"),m$.fnc$("GetHREF",EP.get(),idYFORM.get(),YFORM.get(),YSORT.get())),"' >"));
        //<< set HTML=HTML_YA ;CORE-124.1
        HTML.set(mOp.Concat(HTML.get(),YA.get()));
        //<< set HTML=HTML_"</a>"
        HTML.set(mOp.Concat(HTML.get(),"</a>"));
        //<< set HTML=HTML_"</div></li>"
        HTML.set(mOp.Concat(HTML.get(),"</div></li>"));
      }
    }
    //<< }
    //<< }
    //<< if HTML'="" set HTML="<div class='col_6' style='width:100%; position:relative'><ul style='margin-top:5px; margin-bottom:5px;'>"_HTML_"</ul></div>"
    if (mOp.NotEqual(HTML.get(),"")) {
      HTML.set(mOp.Concat(mOp.Concat("<div class='col_6' style='width:100%; position:relative'><ul style='margin-top:5px; margin-bottom:5px;'>",HTML.get()),"</ul></div>"));
    }
    //<< quit HTML
    return HTML.get();
  }

//<< 
}
