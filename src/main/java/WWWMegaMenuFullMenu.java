//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMegaMenuFullMenu
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:32
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWMegaMenuFullMenu
public class WWWMegaMenuFullMenu extends mClass {

  public void main() {
    _WWWMegaMenuFullMenu();
  }

  public void _WWWMegaMenuFullMenu() {
  }

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
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< &js<
    //<< function menuexpand() {
    //<< if (event.srcElement.tagName.toLowerCase()=='a') {
    //<< window.location=event.srcElement.href;
    //<< } else {
    //<< var strMenu=getParent(event.srcElement,'div');
    //<< // if (strMenu.id=='MM^@net_Manager^SM^01.01.') return false;
    //<< var obj=document.getElementById(strMenu.id+'^SM');
    //<< if (obj.innerHTML.replace(/\s/g, '')=='') {
    //<< var idSM=strMenu.id.split('^')[3];
    //<< if (idSM==undefined) idSM='';
    //<< var id=strMenu.id.split('^')[1];
    //<< var retval = EventValue('#(YUCI)#','#(YUSER)#','#(YFORM)#','FIX','EVENT^WWWMegaMenu','GETSUBMENU','6',id+":"+idSM);
    //<< obj.innerHTML=retval;
    //<< }
    //<< menuChangeState(strMenu.id);
    //<< setMenuHeight(8);
    //<< //if (e) {
    //<< //e.stopPropagation();
    //<< //e.preventDefault();
    //<< //} else {
    //<< event.cancelBubble=true;
    //<< event.returnValue=false;
    //<< //}
    //<< }
    //<< }
    //<< function menuChangeState(pid) {
    //<< var img1=document.getElementById(pid+'IMG1');
    //<< var img2=document.getElementById(pid+'IMG2');
    //<< var obj=document.getElementById(pid+'^SM');
    //<< if (obj.innerHTML.replace(/ /g,'')!='') {
    //<< if (obj.style.display=='none') {
    //<< obj.style.display='block';
    //<< img1.src=img1.src.replace('plus','minus');
    //<< img2.src='#(YGIF)#oopen.gif';
    //<< var retval = EventValue('#(YUCI)#','#(YUSER)#','#(YFORM)#','FIX','EVENT^WWWMegaMenu','OPENMENU','6',pid);
    //<< } else {
    //<< obj.style.display='none';
    //<< img1.src=img1.src.replace('minus','plus');
    //<< img2.src='#(YGIF)#oclose.gif';
    //<< var retval = EventValue('#(YUCI)#','#(YUSER)#','#(YFORM)#','FIX','EVENT^WWWMegaMenu','CLOSEMENU','6',pid);
    //<< }
    //<< }
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("      function menuexpand() {","\n");
    m$.Cmd.WriteJS("          if (event.srcElement.tagName.toLowerCase()=='a') {","\n");
    m$.Cmd.WriteJS("              window.location=event.srcElement.href;","\n");
    m$.Cmd.WriteJS("          } else {","\n");
    m$.Cmd.WriteJS("              var strMenu=getParent(event.srcElement,'div');","\n");
    m$.Cmd.WriteJS("             // if (strMenu.id=='MM^@net_Manager^SM^01.01.') return false;","\n");
    m$.Cmd.WriteJS("              var obj=document.getElementById(strMenu.id+'^SM');","\n");
    m$.Cmd.WriteJS("              if (obj.innerHTML.replace(/\\s/g, '')=='') {","\n");
    m$.Cmd.WriteJS("                  var idSM=strMenu.id.split('^')[3];","\n");
    m$.Cmd.WriteJS("                  if (idSM==undefined) idSM='';","\n");
    m$.Cmd.WriteJS("                  var id=strMenu.id.split('^')[1];","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                  var retval = EventValue('",(m$.var("YUCI").get())),")','"),(m$.var("YUSER").get())),")','"),(m$.var("YFORM").get())),")','FIX','EVENT^WWWMegaMenu','GETSUBMENU','6',id+\":\"+idSM);"),"\n");
    m$.Cmd.WriteJS("                  obj.innerHTML=retval;","\n");
    m$.Cmd.WriteJS("              }","\n");
    m$.Cmd.WriteJS("              menuChangeState(strMenu.id);","\n");
    m$.Cmd.WriteJS("              setMenuHeight(8);","\n");
    m$.Cmd.WriteJS("              //if (e) {","\n");
    m$.Cmd.WriteJS("                  //e.stopPropagation();","\n");
    m$.Cmd.WriteJS("                  //e.preventDefault();","\n");
    m$.Cmd.WriteJS("              //} else {","\n");
    m$.Cmd.WriteJS("                  event.cancelBubble=true;","\n");
    m$.Cmd.WriteJS("                  event.returnValue=false;","\n");
    m$.Cmd.WriteJS("              //}","\n");
    m$.Cmd.WriteJS("          }","\n");
    m$.Cmd.WriteJS("      }","\n");
    m$.Cmd.WriteJS("      function menuChangeState(pid) {","\n");
    m$.Cmd.WriteJS("          var img1=document.getElementById(pid+'IMG1');","\n");
    m$.Cmd.WriteJS("          var img2=document.getElementById(pid+'IMG2');","\n");
    m$.Cmd.WriteJS("          var obj=document.getElementById(pid+'^SM');","\n");
    m$.Cmd.WriteJS("          if (obj.innerHTML.replace(/ /g,'')!='') {","\n");
    m$.Cmd.WriteJS("              if (obj.style.display=='none') {","\n");
    m$.Cmd.WriteJS("                  obj.style.display='block';","\n");
    m$.Cmd.WriteJS("                  img1.src=img1.src.replace('plus','minus');","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("                  img2.src='",(m$.var("YGIF").get())),")oopen.gif';"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                  var retval = EventValue('",(m$.var("YUCI").get())),")','"),(m$.var("YUSER").get())),")','"),(m$.var("YFORM").get())),")','FIX','EVENT^WWWMegaMenu','OPENMENU','6',pid);"),"\n");
    m$.Cmd.WriteJS("              } else {","\n");
    m$.Cmd.WriteJS("                  obj.style.display='none';","\n");
    m$.Cmd.WriteJS("                  img1.src=img1.src.replace('minus','plus');","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("                  img2.src='",(m$.var("YGIF").get())),")oclose.gif';"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                  var retval = EventValue('",(m$.var("YUCI").get())),")','"),(m$.var("YUSER").get())),")','"),(m$.var("YFORM").get())),")','FIX','EVENT^WWWMegaMenu','CLOSEMENU','6',pid);"),"\n");
    m$.Cmd.WriteJS("              }","\n");
    m$.Cmd.WriteJS("          }","\n");
    m$.Cmd.WriteJS("      }","\n");
    m$.Cmd.WriteJS("    ");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetFullMenu()
  public Object GetFullMenu(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Full Alphalinc Menu
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< new HTML
    mVar HTML = m$.var("HTML");
    m$.newVar(HTML);
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< set HTML=HTML_"<li id='menuLi_8' class='li'  hclass='lihover' zclass='li' "_$$Events^WWWMegaMenu(1)_"><a id='menuA_8' href='#' class='drop'>Alphalinc</a>"
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"<li id='menuLi_8' class='li'  hclass='lihover' zclass='li' "),m$.fnc$("WWWMegaMenu.Events",1)),"><a id='menuA_8' href='#' class='drop'>Alphalinc</a>"));
    //<< set HTML=HTML_"  <div id='menuDiv_8' class='dropdown_1column' zclass='dropdown_1column' _CallBack='GETFULL_INTERNAL'>"
    HTML.set(mOp.Concat(HTML.get(),"  <div id='menuDiv_8' class='dropdown_1column' zclass='dropdown_1column' _CallBack='GETFULL_INTERNAL'>"));
    //<< set HTML=HTML_"  </div>"
    HTML.set(mOp.Concat(HTML.get(),"  </div>"));
    //<< set HTML=HTML_"</li>"
    HTML.set(mOp.Concat(HTML.get(),"</li>"));
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< /*
  //<< GetFullMenuInternal0()
  //<< ;-------------------------------------------------------------------------------
  //<< ; Full Alphalinc Menu
  //<< ;
  //<< ; Inputs:
  //<< ;
  //<< ; Returns:
  //<< ;
  //<< ; History:
  //<< ; 01-May-2012   shobby      SR17998: Created
  //<< ;-------------------------------------------------------------------------------
  //<< ;
  //<< new HTML,idMenu1,idMenu2,objWWW004,strMenu,id,strMenuId,blnOpen,YKEY
  //<< 
  //<< set HTML=""
  //<< set HTML=HTML_"  <div id='menuDiv_8' class='dropdown_1column' zclass='dropdown_1column' _CallBack='GETFULL_INTERNAL'>"
  //<< set HTML=HTML_"    <div>"
  //<< set HTML=HTML_"      <div class='col_3'>"
  //<< set HTML=HTML_"        <h2>Alphalinc Menu</h2>"
  //<< set HTML=HTML_"      </div>"
  //<< set HTML=HTML_"      <div id='menucontents_8' class='col_3' style='overflow-y:auto;' >"
  //<< set id="" for { set id=$order(^WWW004(0,id)) quit:id=""
  //<< set strMenuId="MM^"_id
  //<< set blnOpen=$data(^WWWMegaMenuUser(YUCI,YBED,strMenuId))
  //<< 
  //<< set HTML=HTML_"<div id='"_strMenuId_"' onclick='menuexpand();'>"
  //<< set HTML=HTML_"<p style='color:black; margin:0px; cursor:pointer;'>"
  //<< set HTML=HTML_"<img src='"_YGIF_$$GetImage(id,"",blnOpen)_"'   id='MM^"_id_"IMG1' style='vertical-align:bottom;'>"
  //<< set HTML=HTML_"<img class='menuimg' src='"_YGIF_$select(blnOpen:"oopen.gif",1:"oclose.gif")_"' "
  //<< set HTML=HTML_"id='MM^"_id_"IMG2' title=Main Menu align=top border=0 vspace=0>"
  //<< set HTML=HTML_id
  //<< set HTML=HTML_"</p>"
  //<< set HTML=HTML_"<div id='MM^"_id_"^SM' "
  //<< if blnOpen {
  //<< set HTML=HTML_"style='display:block;'>"
  //<< set HTML=HTML_$$GetSubMenu(id,"")
  //<< } else {
  //<< set HTML=HTML_"style='display:none;'>"
  //<< }
  //<< set HTML=HTML_"</div>"
  //<< set HTML=HTML_"</div>"
  //<< }
  //<< 
  //<< set HTML=HTML_"</div>"
  //<< set HTML=HTML_"</div>"
  //<< set HTML=HTML_"</div>"
  //<< 
  //<< quit HTML
  //<< */
  //<< 
  //<< 
  //<< GetFullMenuInternal()
  public Object GetFullMenuInternal(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Full Alphalinc Menu
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Jun-2013   shobby      CORE-113: Corrected width of Alphalinc menu in Firefox.
    //<< ; 01-May-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< new HTML,idMenu1,idMenu2,objWWW004,strMenu,id,strMenuId,blnOpen,YKEY
    mVar HTML = m$.var("HTML");
    mVar idMenu1 = m$.var("idMenu1");
    mVar idMenu2 = m$.var("idMenu2");
    mVar objWWW004 = m$.var("objWWW004");
    mVar strMenu = m$.var("strMenu");
    mVar id = m$.var("id");
    mVar strMenuId = m$.var("strMenuId");
    mVar blnOpen = m$.var("blnOpen");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(HTML,idMenu1,idMenu2,objWWW004,strMenu,id,strMenuId,blnOpen,YKEY);
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< set HTML=HTML_"  <div id='menuDiv_8' style='width:"_$select(YUSERAGENT="MSIE":"140px",1:"auto")_"' class='dropdown_1column' zclass='dropdown_1column' _CallBack='GETFULL_INTERNAL'>"
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"  <div id='menuDiv_8' style='width:"),m$.Fnc.$select(mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE"),"140px",1,"auto")),"' class='dropdown_1column' zclass='dropdown_1column' _CallBack='GETFULL_INTERNAL'>"));
    //<< set HTML=HTML_"    <div>"
    HTML.set(mOp.Concat(HTML.get(),"    <div>"));
    //<< set HTML=HTML_"      <div class='col_3'>"
    HTML.set(mOp.Concat(HTML.get(),"      <div class='col_3'>"));
    //<< set HTML=HTML_"        <h2>Alphalinc Menu</h2>"
    HTML.set(mOp.Concat(HTML.get(),"        <h2>Alphalinc Menu</h2>"));
    //<< set HTML=HTML_"      </div>"
    HTML.set(mOp.Concat(HTML.get(),"      </div>"));
    //<< set HTML=HTML_"      <div id='menucontents_8' class='col_3' style='overflow-y:auto;' >"
    HTML.set(mOp.Concat(HTML.get(),"      <div id='menucontents_8' class='col_3' style='overflow-y:auto;' >"));
    //<< set id="" for { set id=$order(^WWW004(0,id)) quit:id=""
    id.set("");
    for (;true;) {
      id.set(m$.Fnc.$order(m$.var("^WWW004",0,id.get())));
      if (mOp.Equal(id.get(),"")) {
        break;
      }
      //<< set strMenuId="MM^"_id
      strMenuId.set(mOp.Concat("MM^",id.get()));
      //<< set blnOpen=$data(^WWWMegaMenuUser(YUCI,YBED,strMenuId))
      blnOpen.set(m$.Fnc.$data(m$.var("^WWWMegaMenuUser",m$.var("YUCI").get(),m$.var("YBED").get(),strMenuId.get())));
      //<< 
      //<< set HTML=HTML_"    <div id='"_strMenuId_"' onclick='menuexpand();'>"
      HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"    <div id='"),strMenuId.get()),"' onclick='menuexpand();'>"));
      //<< set HTML=HTML_"      <p style='color:black; margin:0px; cursor:pointer;'>"
      HTML.set(mOp.Concat(HTML.get(),"      <p style='color:black; margin:0px; cursor:pointer;'>"));
      //<< set HTML=HTML_"        <img src='"_YGIF_$$GetImage(id,"",blnOpen)_"'   id='MM^"_id_"IMG1' style='vertical-align:bottom;'>"
      HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"        <img src='"),m$.var("YGIF").get()),m$.fnc$("GetImage",id.get(),"",blnOpen.get())),"'   id='MM^"),id.get()),"IMG1' style='vertical-align:bottom;'>"));
      //<< set HTML=HTML_"        <img class='menuimg' "
      HTML.set(mOp.Concat(HTML.get(),"        <img class='menuimg' "));
      //<< if blnOpen {
      if (mOp.Logical(blnOpen.get())) {
        //<< set HTML=HTML_"             src='"_YGIF_"oopen.gif' "
        HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"             src='"),m$.var("YGIF").get()),"oopen.gif' "));
      }
      //<< } else {
      else {
        //<< set HTML=HTML_"             src='"_YGIF_"oclose.gif' "
        HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"             src='"),m$.var("YGIF").get()),"oclose.gif' "));
      }
      //<< }
      //<< set HTML=HTML_"             id='MM^"_id_"IMG2' title=Main Menu align=top border=0 vspace=0>"
      HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"             id='MM^"),id.get()),"IMG2' title=Main Menu align=top border=0 vspace=0>"));
      //<< set HTML=HTML_id
      HTML.set(mOp.Concat(HTML.get(),id.get()));
      //<< set HTML=HTML_"      </p>"
      HTML.set(mOp.Concat(HTML.get(),"      </p>"));
      //<< set HTML=HTML_"      <div id='MM^"_id_"^SM' "
      HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"      <div id='MM^"),id.get()),"^SM' "));
      //<< if blnOpen {
      if (mOp.Logical(blnOpen.get())) {
        //<< set HTML=HTML_"style='display:block;'>"
        HTML.set(mOp.Concat(HTML.get(),"style='display:block;'>"));
        //<< set HTML=HTML_$$GetSubMenu(id,"")
        HTML.set(mOp.Concat(HTML.get(),m$.fnc$("GetSubMenu",id.get(),"")));
      }
      //<< } else {
      else {
        //<< set HTML=HTML_"style='display:none;'>"
        HTML.set(mOp.Concat(HTML.get(),"style='display:none;'>"));
      }
      //<< }
      //<< set HTML=HTML_"      </div>"
      HTML.set(mOp.Concat(HTML.get(),"      </div>"));
      //<< set HTML=HTML_"    </div>"
      HTML.set(mOp.Concat(HTML.get(),"    </div>"));
    }
    //<< }
    //<< 
    //<< set HTML=HTML_"      </div>"
    HTML.set(mOp.Concat(HTML.get(),"      </div>"));
    //<< set HTML=HTML_"    </div>"
    HTML.set(mOp.Concat(HTML.get(),"    </div>"));
    //<< set HTML=HTML_"  </div>"
    HTML.set(mOp.Concat(HTML.get(),"  </div>"));
    //<< 
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< /*
  //<< GetSubMenu0(pid,pidSubMenu)
  //<< ;-------------------------------------------------------------------------------
  //<< ; Get sub menus.  Not all submenus are loaded initially, only those that were
  //<< ; open from the previous time the form was loaded.  Other sub menus are loaded
  //<< ; as required.
  //<< ;
  //<< ; Inputs:
  //<< ;
  //<< ; Returns:
  //<< ;
  //<< ; History:
  //<< ; 19-Apr-2012   shobby      SR17998: Created
  //<< ;-------------------------------------------------------------------------------
  //<< ;
  //<< new HTML,id,objWWW004,intLevels,strImage,strMenuId,blnOpen,id1,arrUserMenu
  //<< 
  //<< set HTML=""
  //<< 
  //<< do GetMenu^WWWMenuOverview(YBED,pid,.arrUserMenu)
  //<< set id=pidSubMenu for { set id=$order(^WWW004(0,pid,id)) quit:id=""
  //<< set id1=id
  //<< if $extract(id,$length(id))'="." set id1=id_"."
  //<< quit:($extract(id1,1,$length(pidSubMenu))'=pidSubMenu)
  //<< continue:($length(id1,".")>($length(pidSubMenu,".")+1))
  //<< ;continue:'$data(^WWW004(0,pid,$piece(id,".",$length(id,".")-1)_"."))
  //<< set strMenuId="MM^"_pid_"^SM^"_id
  //<< set blnOpen=$data(^WWWMegaMenuUser(YUCI,YBED,strMenuId))
  //<< 
  //<< set HTML=HTML_"<div id='"_strMenuId_"'>"
  //<< set HTML=HTML_"   <p style='color:black; margin:0px; cursor:pointer;' "
  //<< set HTML=HTML_">"
  //<< if $order(^WWW004(0,pid))="" {
  //<< for intLevels=1:1:$length(id1,".")-1 {
  //<< set HTML=HTML_"<img src='"_YGIF_"bplus.gif' style='vertical-align:bottom;'>"
  //<< }
  //<< } else {
  //<< for intLevels=1:1:$length(id1,".")-1 {
  //<< set HTML=HTML_"<img src='"_YGIF_"iplus.gif' style='vertical-align:bottom;'>"
  //<< }
  //<< }
  //<< set HTML=HTML_"<img src='"_YGIF_$$GetImage(pid,id,blnOpen)_"' id='"_strMenuId_"IMG1' style='vertical-align:bottom;'>"
  //<< 
  //<< set strImage=$$GetCloseImage(pid,id,blnOpen)
  //<< set HTML=HTML_"<IMG class='menuimg' src='"_YGIF_strImage_"' id='"_strMenuId_"IMG2' TITLE=Main Menu align=top border=0 vspace=0>"
  //<< set HTML=HTML_$$GetHREF(pid,id)
  //<< set HTML=HTML_"</p>"
  //<< set HTML=HTML_"<div id='MM^"_pid_"^SM^"_id_"^SM' "
  //<< if blnOpen {
  //<< set HTML=HTML_"style='display:block;'>"
  //<< set HTML=HTML_$$GetSubMenu(pid,id)
  //<< } else {
  //<< set HTML=HTML_"style='display:none;'>"
  //<< }
  //<< set HTML=HTML_"</div>"
  //<< set HTML=HTML_"</div>"
  //<< }
  //<< quit HTML
  //<< */
  //<< 
  //<< GetSubMenu(pid,pidSubMenu)
  public Object GetSubMenu(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidSubMenu = m$.newVarRef("pidSubMenu",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get sub menus.  Not all submenus are loaded initially, only those that were
    //<< ; open from the previous time the form was loaded.  Other sub menus are loaded
    //<< ; as required.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< new HTML,id,objWWW004,intLevels,strImage,strMenuId,blnOpen,id1,arrUserMenu
    mVar HTML = m$.var("HTML");
    mVar id = m$.var("id");
    mVar objWWW004 = m$.var("objWWW004");
    mVar intLevels = m$.var("intLevels");
    mVar strImage = m$.var("strImage");
    mVar strMenuId = m$.var("strMenuId");
    mVar blnOpen = m$.var("blnOpen");
    mVar id1 = m$.var("id1");
    mVar arrUserMenu = m$.var("arrUserMenu");
    m$.newVar(HTML,id,objWWW004,intLevels,strImage,strMenuId,blnOpen,id1,arrUserMenu);
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< 
    //<< do GetMenu^WWWMenuOverview(YBED,pid,.arrUserMenu)
    m$.Cmd.Do("WWWMenuOverview.GetMenu",m$.var("YBED").get(),pid.get(),arrUserMenu);
    //<< set id=pidSubMenu for { set id=$order(^WWW004(0,pid,id)) quit:id=""
    id.set(pidSubMenu.get());
    for (;true;) {
      id.set(m$.Fnc.$order(m$.var("^WWW004",0,pid.get(),id.get())));
      if (mOp.Equal(id.get(),"")) {
        break;
      }
      //<< set id1=id
      id1.set(id.get());
      //<< if $extract(id,$length(id))'="." set id1=id_"."
      if (mOp.NotEqual(m$.Fnc.$extract(id.get(),m$.Fnc.$length(id.get())),".")) {
        id1.set(mOp.Concat(id.get(),"."));
      }
      //<< quit:($extract(id1,1,$length(pidSubMenu))'=pidSubMenu)
      if ((mOp.NotEqual(m$.Fnc.$extract(id1.get(),1,m$.Fnc.$length(pidSubMenu.get())),pidSubMenu.get()))) {
        break;
      }
      //<< continue:($length(id1,".")>($length(pidSubMenu,".")+1))
      if ((mOp.Greater(m$.Fnc.$length(id1.get(),"."),(mOp.Add(m$.Fnc.$length(pidSubMenu.get(),"."),1))))) {
        continue;
      }
      //<< ;continue:'$data(^WWW004(0,pid,$piece(id,".",$length(id,".")-1)_"."))
      //<< set strMenuId="MM^"_pid_"^SM^"_id
      strMenuId.set(mOp.Concat(mOp.Concat(mOp.Concat("MM^",pid.get()),"^SM^"),id.get()));
      //<< set blnOpen=$data(^WWWMegaMenuUser(YUCI,YBED,strMenuId))
      blnOpen.set(m$.Fnc.$data(m$.var("^WWWMegaMenuUser",m$.var("YUCI").get(),m$.var("YBED").get(),strMenuId.get())));
      //<< 
      //<< set HTML=HTML_"  <div id='"_strMenuId_"'>"
      HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"  <div id='"),strMenuId.get()),"'>"));
      //<< set HTML=HTML_"    <p class='AlphalincP' >"
      HTML.set(mOp.Concat(HTML.get(),"    <p class='AlphalincP' >"));
      //<< if $order(^WWW004(0,pid))="" {
      if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW004",0,pid.get())),"")) {
        //<< for intLevels=1:1:$length(id1,".")-1 {
        for (intLevels.set(1);(mOp.LessOrEqual(intLevels.get(),mOp.Subtract(m$.Fnc.$length(id1.get(),"."),1)));intLevels.set(mOp.Add(intLevels.get(),1))) {
          //<< set HTML=HTML_"  <img src='"_YGIF_"bplus.gif'>"
          HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"  <img src='"),m$.var("YGIF").get()),"bplus.gif'>"));
        }
      }
      //<< }
      //<< } else {
      else {
        //<< for intLevels=1:1:$length(id1,".")-1 {
        for (intLevels.set(1);(mOp.LessOrEqual(intLevels.get(),mOp.Subtract(m$.Fnc.$length(id1.get(),"."),1)));intLevels.set(mOp.Add(intLevels.get(),1))) {
          //<< set HTML=HTML_"  <img src='"_YGIF_"iplus.gif'>"
          HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"  <img src='"),m$.var("YGIF").get()),"iplus.gif'>"));
        }
      }
      //<< }
      //<< }
      //<< set HTML=HTML_"      <img src='"_YGIF_$$GetImage(pid,id,blnOpen)_"' id='"_strMenuId_"IMG1'>"
      HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"      <img src='"),m$.var("YGIF").get()),m$.fnc$("GetImage",pid.get(),id.get(),blnOpen.get())),"' id='"),strMenuId.get()),"IMG1'>"));
      //<< 
      //<< set strImage=$$GetCloseImage(pid,id,blnOpen)
      strImage.set(m$.fnc$("GetCloseImage",pid.get(),id.get(),blnOpen.get()));
      //<< set HTML=HTML_"      <IMG class='menuimg' src='"_YGIF_strImage_"' id='"_strMenuId_"IMG2' TITLE=Main Menu>"
      HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"      <IMG class='menuimg' src='"),m$.var("YGIF").get()),strImage.get()),"' id='"),strMenuId.get()),"IMG2' TITLE=Main Menu>"));
      //<< set HTML=HTML_$$GetHREF(pid,id)
      HTML.set(mOp.Concat(HTML.get(),m$.fnc$("GetHREF",pid.get(),id.get())));
      //<< set HTML=HTML_"    </p>"
      HTML.set(mOp.Concat(HTML.get(),"    </p>"));
      //<< set HTML=HTML_"    <div id='MM^"_pid_"^SM^"_id_"^SM' "
      HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"    <div id='MM^"),pid.get()),"^SM^"),id.get()),"^SM' "));
      //<< if blnOpen {
      if (mOp.Logical(blnOpen.get())) {
        //<< set HTML=HTML_"style='display:block;'>"
        HTML.set(mOp.Concat(HTML.get(),"style='display:block;'>"));
        //<< set HTML=HTML_$$GetSubMenu(pid,id)
        HTML.set(mOp.Concat(HTML.get(),m$.fnc$("GetSubMenu",pid.get(),id.get())));
      }
      //<< } else {
      else {
        //<< set HTML=HTML_"style='display:none;'>"
        HTML.set(mOp.Concat(HTML.get(),"style='display:none;'>"));
      }
      //<< }
      //<< set HTML=HTML_"    </div>"
      HTML.set(mOp.Concat(HTML.get(),"    </div>"));
      //<< set HTML=HTML_"  </div>"
      HTML.set(mOp.Concat(HTML.get(),"  </div>"));
    }
    //<< }
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< 
  //<< GetHREF(pid,pidSubMenu)
  public Object GetHREF(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidSubMenu = m$.newVarRef("pidSubMenu",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; GetHREF
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-May-2013   shobby      CORE-81.1: Pass in YPARA, YNAME and YANZ
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< new HTML,YA,YPARA,YANZ,YNAME ;CORE-81.1
    mVar HTML = m$.var("HTML");
    mVar YA = m$.var("YA");
    mVar YPARA = m$.var("YPARA");
    mVar YANZ = m$.var("YANZ");
    mVar YNAME = m$.var("YNAME");
    m$.newVar(HTML,YA,YPARA,YANZ,YNAME);
    //<< new YASTART,YTRAKT ;CORE-108
    mVar YASTART = m$.var("YASTART");
    mVar YTRAKT = m$.var("YTRAKT");
    m$.newVar(YASTART,YTRAKT);
    //<< 
    //<< set YASTART=1 ;CORE-108 YLOCKKILL
    YASTART.set(1);
    //<< 
    //<< set YA=$get(^WWW004(0,pid,pidSubMenu,1))
    YA.set(m$.Fnc.$get(m$.var("^WWW004",0,pid.get(),pidSubMenu.get(),1)));
    //<< set YPARA= $$$WWW004TransferTriggerForForm(YA)_Y_ $$$WWW004AccessForChange(YA)  ;CORE-81.1
    YPARA.set(mOp.Concat(mOp.Concat(include.WWWConst.$$$WWW004TransferTriggerForForm(m$,YA),m$.var("Y").get()),include.WWWConst.$$$WWW004AccessForChange(m$,YA)));
    //<< set YNAME= $$^WWWUMLAU( $$$WWW004MenuDescription(YA))                           ;CORE-81.1
    YNAME.set(m$.fnc$("WWWUMLAU.main",include.WWWConst.$$$WWW004MenuDescription(m$,YA)));
    //<< ;CORE-108set YANZ=pid_","_pidSubMenu                                            ;CORE-81.1
    //<< set YANZ=pid_","_$extract(pidSubMenu,1,$length(pidSubMenu,".")-1)_"."           ;CORE-108
    YANZ.set(mOp.Concat(mOp.Concat(mOp.Concat(pid.get(),","),m$.Fnc.$extract(pidSubMenu.get(),1,mOp.Subtract(m$.Fnc.$length(pidSubMenu.get(),"."),1))),"."));
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< if $$$WWW004FormName(YA)'="" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW004FormName(m$,YA),"")) {
      //<< set HTML=HTML_"        <a class='menuitem' "
      HTML.set(mOp.Concat(HTML.get(),"        <a class='menuitem' "));
      //<< if $$$WWW004StartFormWithSearchFuncti(YA) {
      if (mOp.Logical(include.WWWConst.$$$WWW004StartFormWithSearchFuncti(m$,YA))) {
        //<< set HTML=HTML_"HREF='"_YAKTION_"&EP=WWWSEAR&YFORM="_$$$WWW004FormName(YA)
        HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"HREF='"),m$.var("YAKTION").get()),"&EP=WWWSEAR&YFORM="),include.WWWConst.$$$WWW004FormName(m$,YA)));
      }
      //<< } else {
      else {
        //<< set HTML=HTML_"HREF='"_YAKTION_"&EP=WWWFORM&YFORM="_$$$WWW004FormName(YA)
        HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),"HREF='"),m$.var("YAKTION").get()),"&EP=WWWFORM&YFORM="),include.WWWConst.$$$WWW004FormName(m$,YA)));
      }
      //<< }
      //<< ;set HTML=HTML_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")_$$$WWW004FormName(YA)
      //<< set HTML=HTML_$$WWWCGI2^WWWCGI()
      HTML.set(mOp.Concat(HTML.get(),m$.fnc$("WWWCGI.WWWCGI2")));
      //<< set HTML=HTML_"'>"
      HTML.set(mOp.Concat(HTML.get(),"'>"));
    }
    //<< }
    //<< 
    //<< set HTML=HTML_$$$WWW004MenuDescription(($$Get^WWW004(pid,pidSubMenu)))
    HTML.set(mOp.Concat(HTML.get(),include.WWWConst.$$$WWW004MenuDescription(m$,(m$.fnc$("WWW004.Get",pid.get(),pidSubMenu.get())))));
    //<< 
    //<< if $$$WWW004FormName(YA)'="" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW004FormName(m$,YA),"")) {
      //<< set HTML=HTML_"</a>"
      HTML.set(mOp.Concat(HTML.get(),"</a>"));
    }
    //<< }
    //<< 
    //<< ;;set HTML=HTML_$$Get^WWW004(pid,pidSubMenu)
    //<< new YKEY
    mVar YKEY = m$.var("YKEY");
    m$.newVar(YKEY);
    //<< set YKEY=pid_","_pidSubMenu
    YKEY.set(mOp.Concat(mOp.Concat(pid.get(),","),pidSubMenu.get()));
    //<< set HTML=HTML_"<B style='cursor:default;'>&nbsp;&nbsp;&nbsp;&nbsp;</B>"
    HTML.set(mOp.Concat(HTML.get(),"<B style='cursor:default;'>&nbsp;&nbsp;&nbsp;&nbsp;</B>"));
    //<< set HTML=HTML_"<span onclick='window.location="" "
    HTML.set(mOp.Concat(HTML.get(),"<span onclick='window.location=\" "));
    //<< set HTML=HTML_YAKTION_"&EP=WWWFORM&YFORM=WWW004&YBACK="_YBACK_YFORM_","
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),m$.var("YAKTION").get()),"&EP=WWWFORM&YFORM=WWW004&YBACK="),m$.var("YBACK").get()),m$.var("YFORM").get()),","));
    //<< set HTML=HTML_$$WWWCGI2^WWWCGI()
    HTML.set(mOp.Concat(HTML.get(),m$.fnc$("WWWCGI.WWWCGI2")));
    //<< set HTML=HTML_"""; return false; event.cancelBubble=true; event.returnValue=false;'>"
    HTML.set(mOp.Concat(HTML.get(),"\"; return false; event.cancelBubble=true; event.returnValue=false;'>"));
    //<< set HTML=HTML_$zcvt("&#x25cf;","i","HTML") ;Black Circle
    HTML.set(mOp.Concat(HTML.get(),m$.Fnc.$zconvert("&#x25cf;","i","HTML")));
    //<< set HTML=HTML_"</span>"
    HTML.set(mOp.Concat(HTML.get(),"</span>"));
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< GetImage(pid,pidSubMenu,blnOpen)
  public Object GetImage(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidSubMenu = m$.newVarRef("pidSubMenu",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar blnOpen = m$.newVarRef("blnOpen",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< quit $$GetPrefix(pid,pidSubMenu)_$select(blnOpen:"minus",1:"plus")_".gif"
    return mOp.Concat(mOp.Concat(m$.fnc$("GetPrefix",pid.get(),pidSubMenu.get()),m$.Fnc.$select(blnOpen.get(),"minus",1,"plus")),".gif");
  }

  //<< 
  //<< GetPlusImage(pid,pidSubMenu)
  public Object GetPlusImage(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidSubMenu = m$.newVarRef("pidSubMenu",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit $$GetPrefix(pid,pidSubMenu)_"plus.gif"
    return mOp.Concat(m$.fnc$("GetPrefix",pid.get(),pidSubMenu.get()),"plus.gif");
  }

  //<< 
  //<< GetPrefix(pid,pidSubMenu)
  public Object GetPrefix(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidSubMenu = m$.newVarRef("pidSubMenu",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets the prefix of the images used to build the trees
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Apr-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< new idNext,strImage,idLast
    mVar idNext = m$.var("idNext");
    mVar strImage = m$.var("strImage");
    mVar idLast = m$.var("idLast");
    m$.newVar(idNext,strImage,idLast);
    //<< 
    //<< set idNext=$order(^WWW004(0,pid,pidSubMenu))
    idNext.set(m$.Fnc.$order(m$.var("^WWW004",0,pid.get(),pidSubMenu.get())));
    //<< if pidSubMenu="" {
    if (mOp.Equal(pidSubMenu.get(),"")) {
      //<< if $order(^WWW004(0,pid))="" {
      if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW004",0,pid.get())),"")) {
        //<< set strImage="e"
        strImage.set("e");
      }
      //<< } else {
      else {
        //<< set strImage=""
        strImage.set("");
      }
    }
    //<< }
    //<< } else {
    else {
      //<< if $extract(idNext,1,$length(pidSubMenu))'=pidSubMenu {
      if (mOp.NotEqual(m$.Fnc.$extract(idNext.get(),1,m$.Fnc.$length(pidSubMenu.get())),pidSubMenu.get())) {
        //<< if (idNext="")||($piece(idNext,".",$length(pidSubMenu,".")-2)'=$piece(pidSubMenu,".",$length(pidSubMenu,".")-2)) {
        if ((mOp.Equal(idNext.get(),"")) || (mOp.NotEqual(m$.Fnc.$piece(idNext.get(),".",mOp.Subtract(m$.Fnc.$length(pidSubMenu.get(),"."),2)),m$.Fnc.$piece(pidSubMenu.get(),".",mOp.Subtract(m$.Fnc.$length(pidSubMenu.get(),"."),2))))) {
          //<< set strImage="l"
          strImage.set("l");
        }
        //<< } else {
        else {
          //<< set strImage="t"
          strImage.set("t");
        }
      }
      //<< }
      //<< } else {
      else {
        //<< set idLast=$order(^WWW004(0,pid,""),-1)
        idLast.set(m$.Fnc.$order(m$.var("^WWW004",0,pid.get(),""),mOp.Negative(1)));
        //<< if $extract(idLast,1,$length(pidSubMenu))=pidSubMenu {
        if (mOp.Equal(m$.Fnc.$extract(idLast.get(),1,m$.Fnc.$length(pidSubMenu.get())),pidSubMenu.get())) {
          //<< set strImage="e"
          strImage.set("e");
        }
        //<< } else {
        else {
          //<< set strImage=""
          strImage.set("");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strImage
    return strImage.get();
  }

  //<< 
  //<< GetCloseImage(pid,pidSubMenu,pblnOpen)
  public Object GetCloseImage(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidSubMenu = m$.newVarRef("pidSubMenu",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnOpen = m$.newVarRef("pblnOpen",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< new idNext,strImage,objWWW004
    mVar idNext = m$.var("idNext");
    mVar strImage = m$.var("strImage");
    mVar objWWW004 = m$.var("objWWW004");
    m$.newVar(idNext,strImage,objWWW004);
    //<< 
    //<< if pblnOpen {
    if (mOp.Logical(pblnOpen.get())) {
      //<< set strImage="oopen.gif"
      strImage.set("oopen.gif");
    }
    //<< } else {
    else {
      //<< set idNext=$order(^WWW004(0,pid,pidSubMenu))
      idNext.set(m$.Fnc.$order(m$.var("^WWW004",0,pid.get(),pidSubMenu.get())));
      //<< if $extract(idNext,1,$length(pidSubMenu))'=pidSubMenu {
      if (mOp.NotEqual(m$.Fnc.$extract(idNext.get(),1,m$.Fnc.$length(pidSubMenu.get())),pidSubMenu.get())) {
        //<< set objWWW004=$get(^WWW004(0,pid,pidSubMenu,1))
        objWWW004.set(m$.Fnc.$get(m$.var("^WWW004",0,pid.get(),pidSubMenu.get(),1)));
        //<< set strImage=$$$WWW004ImageFilegif(objWWW004)
        strImage.set(include.WWWConst.$$$WWW004ImageFilegif(m$,objWWW004));
        //<< if strImage="" set strImage="html.gif"
        if (mOp.Equal(strImage.get(),"")) {
          strImage.set("html.gif");
        }
      }
      //<< } else {
      else {
        //<< set strImage="oclose.gif"
        strImage.set("oclose.gif");
      }
    }
    //<< }
    //<< }
    //<< quit strImage
    return strImage.get();
  }

  //<< 
  //<< GetDescription(pid,pidSubMenu)
  public Object GetDescription(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidSubMenu = m$.newVarRef("pidSubMenu",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit $$$WWW004MenuDescription($get(^WWW004(0,pid,pidSubMenu,1)))
    return include.WWWConst.$$$WWW004MenuDescription(m$,m$.Fnc.$get(m$.var("^WWW004",0,pid.get(),pidSubMenu.get(),1)));
  }

  //<< 
  //<< OpenMenu(pid)
  public Object OpenMenu(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< set ^WWWMegaMenuUser(YUCI,YBED,pid)=1
    m$.var("^WWWMegaMenuUser",m$.var("YUCI").get(),m$.var("YBED").get(),pid.get()).set(1);
    //<< quit 1
    return 1;
  }

  //<< 
  //<< CloseMenu(pid)
  public Object CloseMenu(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< kill ^WWWMegaMenuUser(YUCI,YBED,pid)
    m$.var("^WWWMegaMenuUser",m$.var("YUCI").get(),m$.var("YBED").get(),pid.get()).kill();
    //<< quit 1
    return 1;
  }

//<< 
}
