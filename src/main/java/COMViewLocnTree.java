//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewLocnTree
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-13 20:46:36
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

//<< COMViewLocnTree
public class COMViewLocnTree extends mClass {

  public void main() {
    _COMViewLocnTree();
  }

  public void _COMViewLocnTree() {
  }

  //<< ;-------------------------------------------------------------------------------
  //<< ; History:
  //<< ; 14-Nov-2007   GRF     SR15612: Created
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< ;write " obj2=cvCreateButton(obj,'text.gif','"_$$$JSText($$^WWWTEXT(33844))_"',TranslateFavourite,'TranslateFavourite');",!
  //<< 
  //<< ;function TranslateFavourite() {
  //<< ;   var CurrentView = GetCurrentView();
  //<< ;   CallBack('TranslateFavourite^COMView', CurrentView);
  //<< ;}
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< Show()
  public Object Show() {
    //<< ;function ShowLocnTree() {
    //<< ;    CallBack('Show^COMViewLocnTree');
    //<< ;}
    //<< ;write " obj2=cvCreateButton(obj,'searchtree.gif','"    _$$$JSText($$^WWWTEXT(34335))_"',ShowLocnTree,'ShowLocnTree');",!   ; "Show Location Tree"
    //<< 
    //<< 
    //<< 
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< /*
  //<< ViewChanged(pidView="")
  //<< ;-------------------------------------------------------------------------------
  //<< ; A user selected another view, refresh column header, controls and result grid.
  //<< ;
  //<< ; Called By JS: ViewChanged()
  //<< ;-------------------------------------------------------------------------------
  //<< new idClass,objViewUser
  //<< 
  //<< do ClearCache^COMViewSession()
  //<< 
  //<< kill ^CacheTempView(YUSER,"EditMode")
  //<< set idClass=$get(^CacheTempView(YUSER,"Class"))
  //<< 
  //<< set objViewUser=$get(^COMViewUser(0,idClass,YBED,1))
  //<< set $$$COMViewUserLastView(objViewUser)=pidView
  //<< set ^COMViewUser(0,idClass,YBED,1)=objViewUser
  //<< 
  //<< do SetFiltersForView(idClass,pidView)
  //<< do SetColumnsForView^COMViewColumn(idClass,pidView)
  //<< 
  //<< do:'$get(^CacheTempView(YUSER,YUCI,"InForm")) DisplayHeader^COMViewFilterColumn(idClass)
  //<< do DisplayControls^COMViewFilterControl(idClass)
  //<< do DisplayGrid^COMViewFilter()
  //<< 
  //<< do HideDisabledButtons(idClass,pidView) // SR1315
  //<< 
  //<< quit $$$OK
  //<< */
  //<< 
  //<< Hide()
  public Object Hide() {
    //<< ;function ShowNormalGrid() {
    //<< ;   CallBack('Hide^COMViewLocnTree');
    //<< ;}
    //<< ;write " obj2=cvCreateButton(obj,'searchtree_dis.gif','"_$$$JSText($$^WWWTEXT(34336))_"',ShowNormalGrid,'HideLocnTree');",! ; "Hide Location Tree"
    //<< 
    //<< 
    //<< 
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Display()
  public Object Display() {
    //<< new blnDisplayHide,blnDisplayShow,strValue
    mVar blnDisplayHide = m$.var("blnDisplayHide");
    mVar blnDisplayShow = m$.var("blnDisplayShow");
    mVar strValue = m$.var("strValue");
    m$.newVar(blnDisplayHide,blnDisplayShow,strValue);
    //<< 
    //<< ; *** DUMMY RULES                           TEMP TESTING
    //<< if $extract($get(YFORM),1,3)="WWW" {
    if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(m$.var("YFORM")),1,3),"WWW")) {
      //<< set blnDisplayShow = $$$YES
      blnDisplayShow.set(include.COMSYS.$$$YES(m$));
      //<< set blnDisplayHide = $$$YES
      blnDisplayHide.set(include.COMSYS.$$$YES(m$));
    }
    //<< } elseif $extract($get(YFORM),1,3)="COM" {
    else if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(m$.var("YFORM")),1,3),"COM")) {
      //<< set blnDisplayShow = $$$YES
      blnDisplayShow.set(include.COMSYS.$$$YES(m$));
      //<< set blnDisplayHide = $$$NO
      blnDisplayHide.set(include.COMSYS.$$$NO(m$));
    }
    //<< } elseif $extract($get(YFORM),1,3)="INA" {
    else if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(m$.var("YFORM")),1,3),"INA")) {
      //<< set blnDisplayShow = $$$NO
      blnDisplayShow.set(include.COMSYS.$$$NO(m$));
      //<< set blnDisplayHide = $$$YES
      blnDisplayHide.set(include.COMSYS.$$$YES(m$));
    }
    //<< } else {
    else {
      //<< set blnDisplayShow = $$$NO
      blnDisplayShow.set(include.COMSYS.$$$NO(m$));
      //<< set blnDisplayHide = $$$NO
      blnDisplayHide.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< ; *** ^^^^^^^^^^^
    //<< 
    //<< if blnDisplayShow {
    if (mOp.Logical(blnDisplayShow.get())) {
      //<< set strValue=""
      strValue.set("");
    }
    //<< } else {
    else {
      //<< set strValue="none"
      strValue.set("none");
    }
    //<< }
    //<< ;***************************************   TEMP
    //<< set strValue="none"
    strValue.set("none");
    //<< ;***************************************
    //<< write "if (document.getElementById('ShowLocnTree') != null) {  document.getElementById('ShowLocnTree').style.display = '"_strValue_"'  };"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("if (document.getElementById('ShowLocnTree') != null) {  document.getElementById('ShowLocnTree').style.display = '",strValue.get()),"'  };"));
    //<< 
    //<< if blnDisplayHide {
    if (mOp.Logical(blnDisplayHide.get())) {
      //<< set strValue=""
      strValue.set("");
    }
    //<< } else {
    else {
      //<< set strValue="none"
      strValue.set("none");
    }
    //<< }
    //<< ;***************************************   TEMP
    //<< set strValue="none"
    strValue.set("none");
    //<< ;***************************************
    //<< write "if (document.getElementById('HideLocnTree') != null) {  document.getElementById('HideLocnTree').style.display = '"_strValue_"'  };"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("if (document.getElementById('HideLocnTree') != null) {  document.getElementById('HideLocnTree').style.display = '",strValue.get()),"'  };"));
    //<< quit
    return null;
  }

//<< 
//<< 
}
