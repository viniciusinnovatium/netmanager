//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewColumn
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-13 20:45:32
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; Saving and retrieving column properties
//<< ;-------------------------------------------------------------------------------
//<< #include COMConst
import include.COMConst;
import include.COMSYS;
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

//<< COMViewColumn
public class COMViewColumn extends mClass {

  public void main() {
    _COMViewColumn();
  }

  public void _COMViewColumn() {
  }

  //<< 
  //<< SetColumnsForView(pidClass,pidView)
  public Object SetColumnsForView(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called on new or when changing views to reset what columns are to be displayed.
    //<< ;
    //<< ; History:
    //<< ; 01-Feb-2006   PO      SR13158: Keep sort order, as now able to turn off sorting
    //<< ; 30-Jun-2005   PO      SR12519: Switch off column sorting when loading search
    //<< ;                           results on form load / change of view (favourites)
    //<< ; 30-Dec-2004   PK      Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,objCOMViewColumnUser
    mVar idField = m$.var("idField");
    mVar objCOMViewColumnUser = m$.var("objCOMViewColumnUser");
    m$.newVar(idField,objCOMViewColumnUser);
    //<< 
    //<< if '$data(^COMViewColumn(0,pidClass,pidView)) do SetDefaultColumns(pidClass,pidView)
    if (mOp.Not(m$.Fnc.$data(m$.var("^COMViewColumn",0,pidClass.get(),pidView.get())))) {
      m$.Cmd.Do("SetDefaultColumns",pidClass.get(),pidView.get());
    }
    //<< if '$data(^COMViewColumnUser(0,pidClass,pidView,YBED)) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^COMViewColumnUser",0,pidClass.get(),pidView.get(),m$.var("YBED").get())))) {
      //<< merge ^COMViewColumnUser(0,pidClass,pidView,YBED)=^COMViewColumn(0,pidClass,pidView)
      m$.Cmd.Merge(m$.var("^COMViewColumnUser",0,pidClass.get(),pidView.get(),m$.var("YBED").get()),m$.var("^COMViewColumn",0,pidClass.get(),pidView.get()));
    }
    //<< }
    //<< 
    //<< set idField=""
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField = $order(^COMViewColumnUser(0,pidClass,pidView,YBED,idField))
      idField.set(m$.Fnc.$order(m$.var("^COMViewColumnUser",0,pidClass.get(),pidView.get(),m$.var("YBED").get(),idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< 
      //<< set objCOMViewColumnUser = $get(^COMViewColumnUser(0,pidClass,pidView,YBED,idField))
      objCOMViewColumnUser.set(m$.Fnc.$get(m$.var("^COMViewColumnUser",0,pidClass.get(),pidView.get(),m$.var("YBED").get(),idField.get())));
      //<< ;set $$$COMViewColumnUserSort1(objCOMViewColumnUser) = "" // SR13158
      //<< set ^COMViewColumnUser(0,pidClass,pidView,YBED,idField) = objCOMViewColumnUser
      m$.var("^COMViewColumnUser",0,pidClass.get(),pidView.get(),m$.var("YBED").get(),idField.get()).set(objCOMViewColumnUser.get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< SaveColumns(pidClass,pidView)
  public Object SaveColumns(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Used to save columns to disc.
    //<< ;
    //<< ; History:
    //<< ; 30-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< // FIXME: ^COMViewColumn isn't using the standard @nm global structure
    //<< //        of YM,...Keys...,1, hence can't use WWWKILL / WWWSPEI here.
    //<< 
    //<< kill ^COMViewColumn(0,pidClass,pidView)
    m$.var("^COMViewColumn",0,pidClass.get(),pidView.get()).kill();
    //<< merge ^COMViewColumn(0,pidClass,pidView)=^COMViewColumnUser(0,pidClass,pidView,YBED)
    m$.Cmd.Merge(m$.var("^COMViewColumn",0,pidClass.get(),pidView.get()),m$.var("^COMViewColumnUser",0,pidClass.get(),pidView.get(),m$.var("YBED").get()));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetDefaultColumns(pidClass,pidView)
  public Object SetDefaultColumns(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If no columns are defined yet, make a best guess of what the default
    //<< ; columns should be.
    //<< ;
    //<< ; History:
    //<< ; 09-Sep-2008   PP      SR15866:Update COMView to Objects
    //<< ; 30-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnObj,idColumn,idField,idKey
    mVar blnObj = m$.var("blnObj");
    mVar idColumn = m$.var("idColumn");
    mVar idField = m$.var("idField");
    mVar idKey = m$.var("idKey");
    m$.newVar(blnObj,idColumn,idField,idKey);
    //<< 
    //<< set blnObj   = +$get(^CacheTempObj(YUSER,"Object"))     //SR15866
    blnObj.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object"))));
    //<< set idKey    = ""
    idKey.set("");
    //<< set idColumn = 0
    idColumn.set(0);
    //<< 
    //<< if 'blnObj {
    if (mOp.Not(blnObj.get())) {
      //<< for {
      for (;true;) {
        //<< set idKey=$order(^WWW002(0,pidClass,idKey))
        idKey.set(m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),idKey.get())));
        //<< quit:idKey=""
        if (mOp.Equal(idKey.get(),"")) {
          break;
        }
        //<< 
        //<< set ^COMViewColumn(0,pidClass,pidView,"P"_idKey) = $increment(idColumn)
        m$.var("^COMViewColumn",0,pidClass.get(),pidView.get(),mOp.Concat("P",idKey.get())).set(m$.Fnc.$increment(idColumn));
      }
      //<< }
      //<< set idField = $order(^WWW003(0,pidClass,""))
      idField.set(m$.Fnc.$order(m$.var("^WWW003",0,pidClass.get(),"")));
      //<< if idField'="" {
      if (mOp.NotEqual(idField.get(),"")) {
        //<< set ^COMViewColumn(0,pidClass,pidView,"D"_idField) = $increment(idColumn)
        m$.var("^COMViewColumn",0,pidClass.get(),pidView.get(),mOp.Concat("D",idField.get())).set(m$.Fnc.$increment(idColumn));
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set ^COMViewColumn(0,pidClass,pidView,"ID") = $increment(idColumn)
      m$.var("^COMViewColumn",0,pidClass.get(),pidView.get(),"ID").set(m$.Fnc.$increment(idColumn));
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

//<< 
//<< 
}
