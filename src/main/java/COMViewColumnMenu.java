//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewColumnMenu
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:05
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ;   Column menu supportCode
//<< ;-------------------------------------------------------------------------------
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
//<< #include WWWConst
import include.WWWConst;

//<< COMViewColumnMenu
public class COMViewColumnMenu extends mClass {

  public void main() {
    _COMViewColumnMenu();
  }

  public void _COMViewColumnMenu() {
  }

  //<< 
  //<< Show(pidKey="",pidField="",pintFlag=0,pidCell="")
  public Object Show(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pintFlag = m$.newVarRef("pintFlag",(((_p!=null)&&(_p.length>=3))?_p[2]:null),0);
    mVar pidCell = m$.newVarRef("pidCell",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Populates the Column menu popup.
    //<< ;
    //<< ; History:
    //<< ; 27-Jul-2011   shobby  SR17788: ColumnName only has one parameter.
    //<< ; 18-Feb-2011   shobby  SR17663: Clipboard data difference in Firefox.
    //<< ; 01-Dec-2009   PPP     SR17025:Added Green Ball Icon if Column already customised
    //<< ; 16-Nov-2009   PPP     SR17025:Add new menu option - Customize Column Name
    //<< ; 11-Dec-2006   shobby  SRBR014286:Corrected GIF names.
    //<< ; 29-Aug-2006   JW      SR14763: Group by does not work - removed
    //<< ; 20-Feb-2006   PO      SR14250: Source security settings from form related to
    //<< ;                           data and not COMViewSearch
    //<< ; 31-Jan-2006   PO      SR14250: Show menu options if user has priviledge to
    //<< ;                           perform action.
    //<< ; 11-Feb-2005   PO      SR10965 Include support for cell context menus.
    //<< ; 17-Jan-2005   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnShowMenuOptions,idClass,idField,idForm,idNestField,imgCustom,strDesc
    mVar blnShowMenuOptions = m$.var("blnShowMenuOptions");
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar idForm = m$.var("idForm");
    mVar idNestField = m$.var("idNestField");
    mVar imgCustom = m$.var("imgCustom");
    mVar strDesc = m$.var("strDesc");
    m$.newVar(blnShowMenuOptions,idClass,idField,idForm,idNestField,imgCustom,strDesc);
    //<< 
    //<< set idForm  = $get(^CacheTempView(YUSER,"Form"))
    idForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Form")));
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set idField = pidField
    idField.set(pidField.get());
    //<< 
    //<< do StartMenu()
    m$.Cmd.Do("StartMenu");
    //<< 
    //<< if pintFlag=0 {
    if (mOp.Equal(pintFlag.get(),0)) {
      //<< set blnShowMenuOptions = $$HasViewAccess^COMView(YBED,idForm,YM)
      blnShowMenuOptions.set(m$.fnc$("COMView.HasViewAccess",m$.var("YBED").get(),idForm.get(),m$.var("YM").get()));
      //<< 
      //<< if idField'="" {
      if (mOp.NotEqual(idField.get(),"")) {
        //<< do AddRow("SortAsc.gif",$$$Text("Com00154"),"SortColumn("""","""_idField_""",1)")    ;Sort Ascending
        m$.Cmd.Do("AddRow","SortAsc.gif",include.COMSYS.$$$Text(m$,"Com00154"),mOp.Concat(mOp.Concat("SortColumn(\"\",\"",idField.get()),"\",1)"));
        //<< do AddRow("SortDsc.gif",$$$Text("Com00155"),"SortColumn("""","""_idField_""",-1)")   ;Sort Descending
        m$.Cmd.Do("AddRow","SortDsc.gif",include.COMSYS.$$$Text(m$,"Com00155"),mOp.Concat(mOp.Concat("SortColumn(\"\",\"",idField.get()),"\",-1)"));
        //<< 
        //<< ; Non @NM classes
        //<< if '$data(^WWW001(0,idClass)) {
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWW001",0,idClass.get())))) {
          //<< set idNestField = $piece(pidField,"->",$length(pidField,"->"))
          idNestField.set(m$.Fnc.$piece(pidField.get(),"->",m$.Fnc.$length(pidField.get(),"->")));
          //<< set strDesc     = $$GetCustomisedText^WWWClassTranslation($$GetClassForNestedField^COMViewFilterColumn(idClass, idField),idNestField)
          strDesc.set(m$.fnc$("WWWClassTranslation.GetCustomisedText",m$.fnc$("COMViewFilterColumn.GetClassForNestedField",idClass.get(),idField.get()),idNestField.get()));
          //<< set imgCustom = "ball_grey.gif"
          imgCustom.set("ball_grey.gif");
          //<< if strDesc'="" {
          if (mOp.NotEqual(strDesc.get(),"")) {
            //<< set imgCustom = "ball_green.gif"
            imgCustom.set("ball_green.gif");
          }
          //<< }
          //<< ;SR17788    do AddRow(imgCustom,$$$Text("Com00329"),"ColumnName("""","""_idField_""")")   ; "Customize Field Name"
          //<< do AddRow(imgCustom,$$$Text("Com00329"),"ColumnName("""_idField_""")")        ; "Customize Field Name"   ;SR17788
          m$.Cmd.Do("AddRow",imgCustom.get(),include.COMSYS.$$$Text(m$,"Com00329"),mOp.Concat(mOp.Concat("ColumnName(\"",idField.get()),"\")"));
        }
        //<< }
        //<< 
        //<< do AddSeparator()
        m$.Cmd.Do("AddSeparator");
        //<< 
        //<< if blnShowMenuOptions do AddRow("xxclose.gif",$$$Text("Com00156"),"ColumnClick("""_idField_""")")        ;Remove This Column
        if (mOp.Logical(blnShowMenuOptions.get())) {
          m$.Cmd.Do("AddRow","xxclose.gif",include.COMSYS.$$$Text(m$,"Com00156"),mOp.Concat(mOp.Concat("ColumnClick(\"",idField.get()),"\")"));
        }
      }
      //<< }
      //<< if blnShowMenuOptions do AddRow("sort.gif",$$$Text("Com00157"),"ChooseShow()")    ; Field Chooser
      if (mOp.Logical(blnShowMenuOptions.get())) {
        m$.Cmd.Do("AddRow","sort.gif",include.COMSYS.$$$Text(m$,"Com00157"),"ChooseShow()");
      }
    }
    //<< 
    //<< } else {
    else {
      //<< ; FIXME : <GRF> GetRelation^COMViewUtils is a function. returns an object??DWR
      //<< do GetRelation^COMViewUtils(.idClass,.idField)
      m$.Cmd.Do("COMViewUtils.GetRelation",idClass,idField);
      //<< if $extract(idField)="D" {
      if (mOp.Equal(m$.Fnc.$extract(idField.get()),"D")) {
        //<< if $zboolean(pintFlag,2,1) do AddRow("clear.gif",$$$Text("Com00164"),"CallBack(""ShowCompleteData^COMViewCellData""(event.pageX ? event.pageX : event.screenX),(event.pageY ? event.pageY : event.screenY),"""_$zconvert(pidKey,"o","JS")_""","""_$zconvert(pidField,"o","JS")_""")")  ;Show complete data
        if (mOp.Logical(m$.Fnc.$zboolean(pintFlag.get(),2,1))) {
          m$.Cmd.Do("AddRow","clear.gif",include.COMSYS.$$$Text(m$,"Com00164"),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CallBack(\"ShowCompleteData^COMViewCellData\"(event.pageX ? event.pageX : event.screenX),(event.pageY ? event.pageY : event.screenY),\"",m$.Fnc.$zconvert(pidKey.get(),"o","JS")),"\",\""),m$.Fnc.$zconvert(pidField.get(),"o","JS")),"\")"));
        }
      }
      //<< }
      //<< if $$$WWW120ModificationsProtocol($get(^WWW120(0,idClass,1))) {
      if (mOp.Logical(include.WWWConst.$$$WWW120ModificationsProtocol(m$,m$.Fnc.$get(m$.var("^WWW120",0,idClass.get(),1))))) {
        //<< if $zboolean(pintFlag,1,1)&&($extract(idField)="D") do AddRow("time.gif",$$$Text("Com00163"),"CallBack(""ShowCompleteHistory^COMViewCellData"",(event.pageX ? event.pageX : event.screenX),(event.pageY ? event.pageY : event.screenY),"""_$zconvert(pidKey,"o","JS")_""","""_$zconvert(pidField,"o","JS")_""")")  ;Show history
        if (mOp.Logical(m$.Fnc.$zboolean(pintFlag.get(),1,1)) && (mOp.Equal(m$.Fnc.$extract(idField.get()),"D"))) {
          m$.Cmd.Do("AddRow","time.gif",include.COMSYS.$$$Text(m$,"Com00163"),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CallBack(\"ShowCompleteHistory^COMViewCellData\",(event.pageX ? event.pageX : event.screenX),(event.pageY ? event.pageY : event.screenY),\"",m$.Fnc.$zconvert(pidKey.get(),"o","JS")),"\",\""),m$.Fnc.$zconvert(pidField.get(),"o","JS")),"\")"));
        }
      }
      //<< }
      //<< if $get(YUSERAGENT)="MSIE" {
      if (mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) {
        //<< if pidCell'="" do AddRow("copy.gif",$$$Text("Com00232"),"window.clipboardData.setData(""Text"",parent."_pidCell_".innerHTML);",1)
        if (mOp.NotEqual(pidCell.get(),"")) {
          m$.Cmd.Do("AddRow","copy.gif",include.COMSYS.$$$Text(m$,"Com00232"),mOp.Concat(mOp.Concat("window.clipboardData.setData(\"Text\",parent.",pidCell.get()),".innerHTML);"),1);
        }
      }
      //<< } else {
      else {
        //<< if pidCell'="" do AddRow("copy.gif",$$$Text("Com00232"),"window.clipboardData.setData(""Text"",document.getElementById("""_pidCell_""").innerHTML); ",0)  ;SR17663 1->0
        if (mOp.NotEqual(pidCell.get(),"")) {
          m$.Cmd.Do("AddRow","copy.gif",include.COMSYS.$$$Text(m$,"Com00232"),mOp.Concat(mOp.Concat("window.clipboardData.setData(\"Text\",document.getElementById(\"",pidCell.get()),"\").innerHTML); "),0);
        }
      }
    }
    //<< }   ; "Copy text to clipboard"
    //<< }
    //<< do EndMenu()
    m$.Cmd.Do("EndMenu");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< StartMenu()
  public Object StartMenu(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Initialises a custom context menu
    //<< ;
    //<< ; History:
    //<< ; 05-Jul-2010   GRF     SR17???: Missing semicolon; split creation for clarity
    //<< ; 09-May-2005   PaulK   Suppress Context menu for table (this table is a context menu)
    //<< ; 21-Jan-2005   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHTML);
    //<< 
    //<< kill ^CacheTempMenu(YUSER)
    m$.var("^CacheTempMenu",m$.var("YUSER").get()).kill();
    //<< ;set ^CacheTempMenu(YUSER)="<TABLE style='border-width:2px;border-style:outset;border-color:slategray;position:relative;width:100%;height:100%table-layout:fixed;' border=0 cellpadding=0 cellspacing=0 oncontextmenu='event.returnValue=false; return false;'>"
    //<< set strHTML = "<TABLE style='border-width:2px;border-style:outset;border-color:slategray;"
    strHTML.set("<TABLE style='border-width:2px;border-style:outset;border-color:slategray;");
    //<< set strHTML = strHTML_"position:relative;width:100%;height:100%;table-layout:fixed;' "
    strHTML.set(mOp.Concat(strHTML.get(),"position:relative;width:100%;height:100%;table-layout:fixed;' "));
    //<< set strHTML = strHTML_"border=0 cellpadding=0 cellspacing=0 oncontextmenu='event.returnValue=false; return false;'"
    strHTML.set(mOp.Concat(strHTML.get(),"border=0 cellpadding=0 cellspacing=0 oncontextmenu='event.returnValue=false; return false;'"));
    //<< set strHTML = strHTML_">"
    strHTML.set(mOp.Concat(strHTML.get(),">"));
    //<< set ^CacheTempMenu(YUSER) = strHTML
    m$.var("^CacheTempMenu",m$.var("YUSER").get()).set(strHTML.get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< EndMenu()
  public Object EndMenu(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Shows a custom context menu.
    //<< ;
    //<< ; History:
    //<< ; 21-Jan-2005   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHTML);
    //<< 
    //<< set strHTML = $get(^CacheTempMenu(YUSER))_"</TABLE>"
    strHTML.set(mOp.Concat(m$.Fnc.$get(m$.var("^CacheTempMenu",m$.var("YUSER").get())),"</TABLE>"));
    //<< if $get(^CacheTempMenu(YUSER,"Concat")) {
    if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempMenu",m$.var("YUSER").get(),"Concat")))) {
      //<< write "Columns.document.body.innerHTML+="""_$zcvt(strHTML,"o","JS")_""";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("Columns.document.body.innerHTML+=\"",m$.Fnc.$zconvert(strHTML.get(),"o","JS")),"\";"));
    }
    //<< 
    //<< } else {
    else {
      //<< write "Columns.document.body.innerHTML="""_$zcvt(strHTML,"o","JS")_""";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("Columns.document.body.innerHTML=\"",m$.Fnc.$zconvert(strHTML.get(),"o","JS")),"\";"));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AddRow(pstrImage,pstrDescription,pstrCallBack="",pblnNotParent=0,pblnEnabled=1)
  public Object AddRow(Object ... _p) {
    mVar pstrImage = m$.newVarRef("pstrImage",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrDescription = m$.newVarRef("pstrDescription",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrCallBack = m$.newVarRef("pstrCallBack",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnNotParent = m$.newVarRef("pblnNotParent",(((_p!=null)&&(_p.length>=4))?_p[3]:null),0);
    mVar pblnEnabled = m$.newVarRef("pblnEnabled",(((_p!=null)&&(_p.length>=5))?_p[4]:null),1);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Adds a row to a custom context menu.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 17-Aug-2010   shobby  SR17445.1: Set width of image column
    //<< ; 11-Aug-2010   shobby  SR17445: onclick doesn't fire in firefox. Using onmouseup
    //<< ;                           Simplification of event.srcElement code.
    //<< ; 01-Sep-2008   shobby  SRBR014976: Set the FontFace as per company settings.
    //<< ; 24-Feb-2005   shobby  pblnEnabled to show the menu option but nothing will happen.
    //<< ; 11-Feb-2005   PO      SR10965 Onclick if no command hide popup.
    //<< ; 21-Jan-2005   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHTML);
    //<< 
    //<< set strHTML="<TR "
    strHTML.set("<TR ");
    //<< if pblnEnabled {
    if (mOp.Logical(pblnEnabled.get())) {
      //<< set strHTML=strHTML_"onmouseover='"
      strHTML.set(mOp.Concat(strHTML.get(),"onmouseover='"));
      //<< ;SR17445 set strHTML=strHTML_" var row= event.target ? event.target.parentNode : event.srcElement.parentNode;"  ;SR17253
      //<< set strHTML=strHTML_" var row=event.srcElement.parentNode;"             ;SR17445
      strHTML.set(mOp.Concat(strHTML.get()," var row=event.srcElement.parentNode;"));
      //<< set strHTML=strHTML_" if (row.tagName==""TD"") {row=row.parentNode;}"   ;SR17253
      strHTML.set(mOp.Concat(strHTML.get()," if (row.tagName==\"TD\") {row=row.parentNode;}"));
      //<< set strHTML=strHTML_" row.parentNode.parentNode.style.backgroundcolor=""lightgrey"";"
      strHTML.set(mOp.Concat(strHTML.get()," row.parentNode.parentNode.style.backgroundcolor=\"lightgrey\";"));
      //<< set strHTML=strHTML_" row.cells[0].style.borderColor=""darkblue"";"
      strHTML.set(mOp.Concat(strHTML.get()," row.cells[0].style.borderColor=\"darkblue\";"));
      //<< set strHTML=strHTML_" row.cells[0].style.backgroundColor=""lightsteelblue"";"
      strHTML.set(mOp.Concat(strHTML.get()," row.cells[0].style.backgroundColor=\"lightsteelblue\";"));
      //<< set strHTML=strHTML_" row.cells[0].style.filter="""";"
      strHTML.set(mOp.Concat(strHTML.get()," row.cells[0].style.filter=\"\";"));
      //<< set strHTML=strHTML_" row.cells[1].style.borderColor=""darkblue"";"
      strHTML.set(mOp.Concat(strHTML.get()," row.cells[1].style.borderColor=\"darkblue\";"));
      //<< set strHTML=strHTML_" row.cells[1].style.backgroundColor=""lightsteelblue"";'"
      strHTML.set(mOp.Concat(strHTML.get()," row.cells[1].style.backgroundColor=\"lightsteelblue\";'"));
      //<< set strHTML=strHTML_" onmouseout='"
      strHTML.set(mOp.Concat(strHTML.get()," onmouseout='"));
      //<< ;SR17445 set strHTML=strHTML_" var row=event.target ? event.target.parentNode : event.srcElement.parentNode;"   ;SR17253
      //<< set strHTML=strHTML_" var row=event.srcElement.parentNode;"             ;SR17445
      strHTML.set(mOp.Concat(strHTML.get()," var row=event.srcElement.parentNode;"));
      //<< set strHTML=strHTML_" if (row.tagName==""TD"") {row=row.parentNode;}"   ;SR17253
      strHTML.set(mOp.Concat(strHTML.get()," if (row.tagName==\"TD\") {row=row.parentNode;}"));
      //<< set strHTML=strHTML_" row.cells[0].style.borderColor=""lightgrey"";"
      strHTML.set(mOp.Concat(strHTML.get()," row.cells[0].style.borderColor=\"lightgrey\";"));
      //<< set strHTML=strHTML_" row.cells[0].style.backgroundColor=""lightgrey"";"
      strHTML.set(mOp.Concat(strHTML.get()," row.cells[0].style.backgroundColor=\"lightgrey\";"));
      //<< set strHTML=strHTML_" row.cells[0].style.filter=""progid:DXImageTransform.Microsoft.Alpha(opacity=60)"";"
      strHTML.set(mOp.Concat(strHTML.get()," row.cells[0].style.filter=\"progid:DXImageTransform.Microsoft.Alpha(opacity=60)\";"));
      //<< set strHTML=strHTML_" row.cells[1].style.borderColor=""whitesmoke"";"
      strHTML.set(mOp.Concat(strHTML.get()," row.cells[1].style.borderColor=\"whitesmoke\";"));
      //<< set strHTML=strHTML_" row.cells[1].style.backgroundColor=""whitesmoke"";'"
      strHTML.set(mOp.Concat(strHTML.get()," row.cells[1].style.backgroundColor=\"whitesmoke\";'"));
      //<< 
      //<< if pstrCallBack="##do nothing##" {
      if (mOp.Equal(pstrCallBack.get(),"##do nothing##")) {
      }
      //<< 
      //<< } elseif pstrCallBack'="" {
      else if (mOp.NotEqual(pstrCallBack.get(),"")) {
        //<< if pblnNotParent {
        if (mOp.Logical(pblnNotParent.get())) {
          //<< set strHTML=strHTML_" onclick='"_pstrCallBack_"; if (parent.Columns) {parent.Columns.hide();} else {Columns.hide();}'"  ;SR17253
          strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get()," onclick='"),pstrCallBack.get()),"; if (parent.Columns) {parent.Columns.hide();} else {Columns.hide();}'"));
        }
        //<< } else {
        else {
          //<< ;SR17445    set strHTML=strHTML_" onclick='if (parent.Columns) {parent."_pstrCallBack_"; parent.Columns.hide();} else {"_pstrCallBack_"; Columns.hide();}'"  ;SR17253
          //<< set strHTML=strHTML_" onmouseup='if (parent.Columns) {parent."_pstrCallBack_"; parent.Columns.hide();} else {"_pstrCallBack_"; Columns.hide();}'"  ;SR17253
          strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get()," onmouseup='if (parent.Columns) {parent."),pstrCallBack.get()),"; parent.Columns.hide();} else {"),pstrCallBack.get()),"; Columns.hide();}'"));
        }
      }
      //<< }
      //<< } else {
      else {
        //<< set strHTML=strHTML_" onclick='if (parent.Columns) {parent.Columns.hide();} else {Columns.hide();}'" ; SR10965  ;SR17253 ;SR17445
        strHTML.set(mOp.Concat(strHTML.get()," onclick='if (parent.Columns) {parent.Columns.hide();} else {Columns.hide();}'"));
      }
    }
    //<< }
    //<< }
    //<< set strHTML=strHTML_">"
    strHTML.set(mOp.Concat(strHTML.get(),">"));
    //<< set strHTML=strHTML_"<TD style='width:25px; filter:progid:DXImageTransform.Microsoft.Alpha(opacity=60);border-style:solid;background-color:lightgrey;border-color:lightgrey;border-bottom-width:1px;border-left-width:1px;border-top-width:1px;border-right-width:0px;'>" ;SR17445.1
    strHTML.set(mOp.Concat(strHTML.get(),"<TD style='width:25px; filter:progid:DXImageTransform.Microsoft.Alpha(opacity=60);border-style:solid;background-color:lightgrey;border-color:lightgrey;border-bottom-width:1px;border-left-width:1px;border-top-width:1px;border-right-width:0px;'>"));
    //<< if (pstrImage'="") {
    if ((mOp.NotEqual(pstrImage.get(),""))) {
      //<< set strHTML=strHTML_"<IMG height=""20px"" width=""20px"" align='absmiddle' SRC='"_YGIF_pstrImage_"'>"
      strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"<IMG height=\"20px\" width=\"20px\" align='absmiddle' SRC='"),m$.var("YGIF").get()),pstrImage.get()),"'>"));
    }
    //<< } else {
    else {
      //<< set strHTML=strHTML_"&nbsp;"
      strHTML.set(mOp.Concat(strHTML.get(),"&nbsp;"));
    }
    //<< }
    //<< set strHTML=strHTML_"</TD>"
    strHTML.set(mOp.Concat(strHTML.get(),"</TD>"));
    //<< set strHTML=strHTML_"<TD style='"
    strHTML.set(mOp.Concat(strHTML.get(),"<TD style='"));
    //<< if 'pblnEnabled set strHTML=strHTML_"color:gray;"
    if (mOp.Not(pblnEnabled.get())) {
      strHTML.set(mOp.Concat(strHTML.get(),"color:gray;"));
    }
    //<< set strHTML=strHTML_"border-style:solid;background-color:whitesmoke;border-color:whitesmoke;border-bottom-width:1px;border-right-width:1px;border-top-width:1px;border-left-width:0px;font-size:12px;font-family:"_$$FontFace^WWW012()_";'>" ;BR014976
    strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"border-style:solid;background-color:whitesmoke;border-color:whitesmoke;border-bottom-width:1px;border-right-width:1px;border-top-width:1px;border-left-width:0px;font-size:12px;font-family:"),m$.fnc$("WWW012.FontFace")),";'>"));
    //<< set strHTML=strHTML_$zcvt(pstrDescription,"o","JS")
    strHTML.set(mOp.Concat(strHTML.get(),m$.Fnc.$zconvert(pstrDescription.get(),"o","JS")));
    //<< set strHTML=strHTML_"</TD>"
    strHTML.set(mOp.Concat(strHTML.get(),"</TD>"));
    //<< set strHTML=strHTML_"</TR>"
    strHTML.set(mOp.Concat(strHTML.get(),"</TR>"));
    //<< set ^CacheTempMenu(YUSER)=$get(^CacheTempMenu(YUSER))_strHTML
    m$.var("^CacheTempMenu",m$.var("YUSER").get()).set(mOp.Concat(m$.Fnc.$get(m$.var("^CacheTempMenu",m$.var("YUSER").get())),strHTML.get()));
    //<< if $length($get(^CacheTempMenu(YUSER)))>30000 {
    if (mOp.Greater(m$.Fnc.$length(m$.Fnc.$get(m$.var("^CacheTempMenu",m$.var("YUSER").get()))),30000)) {
      //<< if '$get(^CacheTempMenu(YUSER,"Concat")) write "Columns.document.body.innerHTML='';"
      if (mOp.Not(m$.Fnc.$get(m$.var("^CacheTempMenu",m$.var("YUSER").get(),"Concat")))) {
        m$.Cmd.Write("Columns.document.body.innerHTML='';");
      }
      //<< set ^CacheTempMenu(YUSER,"Concat")=1
      m$.var("^CacheTempMenu",m$.var("YUSER").get(),"Concat").set(1);
      //<< write "Columns.document.body.innerHTML+="""_$zcvt($get(^CacheTempMenu(YUSER)),"o","JS")_""";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("Columns.document.body.innerHTML+=\"",m$.Fnc.$zconvert(m$.Fnc.$get(m$.var("^CacheTempMenu",m$.var("YUSER").get())),"o","JS")),"\";"));
      //<< set ^CacheTempMenu(YUSER)=""
      m$.var("^CacheTempMenu",m$.var("YUSER").get()).set("");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AddSeparator()
  public Object AddSeparator(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Adds a separator to the custom context menu.
    //<< ;
    //<< ; History:
    //<< ; 12-Apr-2005   PaulK   Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHTML);
    //<< 
    //<< set strHTML=""
    strHTML.set("");
    //<< set strHTML=strHTML_"<TR style='height:5px;'>"
    strHTML.set(mOp.Concat(strHTML.get(),"<TR style='height:5px;'>"));
    //<< set strHTML=strHTML_"<TD style='filter:progid:DXImageTransform.Microsoft.Alpha(opacity=60);height:5px;background-color:lightgrey;border-color:lightgrey;border-bottom-width:1px;border-left-width:1px;border-bottom-top:1px;'>"
    strHTML.set(mOp.Concat(strHTML.get(),"<TD style='filter:progid:DXImageTransform.Microsoft.Alpha(opacity=60);height:5px;background-color:lightgrey;border-color:lightgrey;border-bottom-width:1px;border-left-width:1px;border-bottom-top:1px;'>"));
    //<< set strHTML=strHTML_"&nbsp;</TD>"
    strHTML.set(mOp.Concat(strHTML.get(),"&nbsp;</TD>"));
    //<< set strHTML=strHTML_"<TD style='height:5px;background-color:whitesmoke;border-color:whitesmoke;border-bottom-width:1px;border-right-width:1px;border-bottom-top:1px;'>"
    strHTML.set(mOp.Concat(strHTML.get(),"<TD style='height:5px;background-color:whitesmoke;border-color:whitesmoke;border-bottom-width:1px;border-right-width:1px;border-bottom-top:1px;'>"));
    //<< set strHTML=strHTML_"<HR style='width:95%;left:5%;'>"
    strHTML.set(mOp.Concat(strHTML.get(),"<HR style='width:95%;left:5%;'>"));
    //<< set strHTML=strHTML_"</TD>"
    strHTML.set(mOp.Concat(strHTML.get(),"</TD>"));
    //<< set strHTML=strHTML_"</TR>"
    strHTML.set(mOp.Concat(strHTML.get(),"</TR>"));
    //<< set ^CacheTempMenu(YUSER)=$get(^CacheTempMenu(YUSER))_strHTML
    m$.var("^CacheTempMenu",m$.var("YUSER").get()).set(mOp.Concat(m$.Fnc.$get(m$.var("^CacheTempMenu",m$.var("YUSER").get())),strHTML.get()));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DefaultContext()
  public Object DefaultContext(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Change context menu to only print
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 14-Aug-2006   RPW     SR13836: Use Start/End Script macros and removed YCR.
    //<< ; 11-Aug-2006   JW      SR13836: Created
    //<< ;-------------------------------------------------------------------------------
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write "var Columns=window.createPopup(); function DisplayContext() {"
    m$.Cmd.Write("var Columns=window.createPopup(); function DisplayContext() {");
    //<< do StartMenu^COMViewColumnMenu()
    m$.Cmd.Do("COMViewColumnMenu.StartMenu");
    //<< do AddRow^COMViewColumnMenu("xxprint.gif",$$$Text("Com00170"),"window.print()") ; "Print"
    m$.Cmd.Do("COMViewColumnMenu.AddRow","xxprint.gif",include.COMSYS.$$$Text(m$,"Com00170"),"window.print()");
    //<< do EndMenu^COMViewColumnMenu()
    m$.Cmd.Do("COMViewColumnMenu.EndMenu");
    //<< //write "   Columns.show(event.screenX,event.screenY,200,26); }"  ;SR17253
    //<< write " Columns.show((event.pageX ? event.pageX : event.screenX),(event.pageY ? event.pageY : event.screenY),200,26); }"
    m$.Cmd.Write(" Columns.show((event.pageX ? event.pageX : event.screenX),(event.pageY ? event.pageY : event.screenY),200,26); }");
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< ;---------------------------------------
  //<< ; CreateWindowLocation
  //<< ;---------------------------------------
  //<< 
  //<< OPEN
  public void OPEN() {
    //<< new strImg
    mVar strImg = m$.var("strImg");
    m$.newVar(strImg);
    //<< 
    //<< if YFORM="INWEINVEHeader" {
    if (mOp.Equal(m$.var("YFORM").get(),"INWEINVEHeader")) {
      //<< set strImg = "reset"
      strImg.set("reset");
      //<< set YSTATUS = $$^WWWTEXT(32810)     ; "Refresh"
      mVar YSTATUS = m$.var("YSTATUS");
      YSTATUS.set(m$.fnc$("WWWTEXT.main",32810));
    }
    //<< } else {
    else {
      //<< set strImg  = "open"
      strImg.set("open");
      //<< SET YSTATUS = $$^WWWTEXT(101)       ; "Open"
      mVar YSTATUS = m$.var("YSTATUS");
      YSTATUS.set(m$.fnc$("WWWTEXT.main",101));
    }
    //<< }
    //<< do AddRow^COMViewColumnMenu(strImg_".gif",YSTATUS,"CallBack(""SaveNow^WWWFORMF"",""1"");")
    m$.Cmd.Do("COMViewColumnMenu.AddRow",mOp.Concat(strImg.get(),".gif"),m$.var("YSTATUS").get(),"CallBack(\"SaveNow^WWWFORMF\",\"1\");");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< RREV
  public void RREV() {
    //<< ;DO Direction^WWWFORMF("rrev","FIRST","PAGEL","&lt;&lt;",301)
    //<< new strScript
    mVar strScript = m$.var("strScript");
    m$.newVar(strScript);
    //<< 
    //<< set strScript="CallBack('"
    strScript.set("CallBack('");
    //<< set strScript=strScript="document.WWW.style.cursor = ""wait""; SaveAction(1); "
    strScript.set(mOp.Equal(strScript.get(),"document.WWW.style.cursor = \"wait\"; SaveAction(1); "));
    //<< set strScript=strScript="window.location="""
    strScript.set(mOp.Equal(strScript.get(),"window.location=\""));
    //<< set strScript=strScript_$$DirectionURL2^WWWFORMF("FIRST")
    strScript.set(mOp.Concat(strScript.get(),m$.fnc$("WWWFORMF.DirectionURL2","FIRST")));
    //<< set strScript=strScript_"""')"
    strScript.set(mOp.Concat(strScript.get(),"\"')"));
    //<< do AddRow^COMViewColumnMenu("rrev.gif",$$$Text(301),strScript)
    m$.Cmd.Do("COMViewColumnMenu.AddRow","rrev.gif",include.COMSYS.$$$Text(m$,301),strScript.get());
    //<< quit
    return;
  }

//<< 
//<< 
}
