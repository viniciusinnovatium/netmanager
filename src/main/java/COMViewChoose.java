//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewChoose
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-01 19:19:31
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
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
//<< #include COMConst
import include.COMConst;
//<< #include %occInclude
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;

//<< COMViewChoose ; functions relating to the field chooser.
public class COMViewChoose extends mClass {

  public void main() {
    _COMViewChoose();
  }

  public void _COMViewChoose() {
  }

  //<< 
  //<< Select(pidField="",pstrControl="")
  public Object Select(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrControl = m$.newVarRef("pstrControl",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Callback from when a user drags a property to the field selection or result grid.
    //<< ;
    //<< ; History:
    //<< ; 24-Jun-2005   Paul K  Defaulted variables.
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new blnControl,intPosition
    mVar blnControl = m$.var("blnControl");
    mVar intPosition = m$.var("intPosition");
    m$.newVar(blnControl,intPosition);
    //<< 
    //<< set blnControl  = $$$NO
    blnControl.set(include.COMSYS.$$$NO(m$));
    //<< set intPosition = ""
    intPosition.set("");
    //<< if (pstrControl'="") && (pidField'="") {
    if ((mOp.NotEqual(pstrControl.get(),"")) && (mOp.NotEqual(pidField.get(),""))) {
      //<< if $extract(pstrControl,1,3)="bdy" {
      if (mOp.Equal(m$.Fnc.$extract(pstrControl.get(),1,3),"bdy")) {
        //<< set intPosition = $piece($piece(pstrControl,"bdy",2),"_",1)
        intPosition.set(m$.Fnc.$piece(m$.Fnc.$piece(pstrControl.get(),"bdy",2),"_",1));
      }
      //<< 
      //<< } elseif $extract(pstrControl,1,6)="select" {
      else if (mOp.Equal(m$.Fnc.$extract(pstrControl.get(),1,6),"select")) {
        //<< set blnControl  = $$$YES
        blnControl.set(include.COMSYS.$$$YES(m$));
        //<< set intPosition = $piece(pstrControl,"select",2)
        intPosition.set(m$.Fnc.$piece(pstrControl.get(),"select",2));
      }
      //<< 
      //<< } elseif $extract(pstrControl,1,4)="comp" {
      else if (mOp.Equal(m$.Fnc.$extract(pstrControl.get(),1,4),"comp")) {
        //<< set blnControl  = $$$YES
        blnControl.set(include.COMSYS.$$$YES(m$));
        //<< set intPosition = $piece(pstrControl,"comp",2)
        intPosition.set(m$.Fnc.$piece(pstrControl.get(),"comp",2));
      }
      //<< 
      //<< } elseif $extract(pstrControl,1,5)="value" {
      else if (mOp.Equal(m$.Fnc.$extract(pstrControl.get(),1,5),"value")) {
        //<< set blnControl  = $$$YES
        blnControl.set(include.COMSYS.$$$YES(m$));
        //<< set intPosition = $piece(pstrControl,"value",2)
        intPosition.set(m$.Fnc.$piece(pstrControl.get(),"value",2));
      }
      //<< 
      //<< } elseif $extract(pstrControl,1,4)="ctrl" {
      else if (mOp.Equal(m$.Fnc.$extract(pstrControl.get(),1,4),"ctrl")) {
        //<< set blnControl  = $$$YES
        blnControl.set(include.COMSYS.$$$YES(m$));
        //<< set intPosition = $piece($piece(pstrControl,"ctrl",2),"_",1)
        intPosition.set(m$.Fnc.$piece(m$.Fnc.$piece(pstrControl.get(),"ctrl",2),"_",1));
      }
      //<< }
      //<< if blnControl {
      if (mOp.Logical(blnControl.get())) {
        //<< do SelectControl^COMViewFilterControl(pidField,intPosition)
        m$.Cmd.Do("COMViewFilterControl.SelectControl",pidField.get(),intPosition.get());
      }
      //<< } else {
      else {
        //<< do SelectColumn^COMViewFilterColumn(pidField,intPosition)
        m$.Cmd.Do("COMViewFilterColumn.SelectColumn",pidField.get(),intPosition.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetWidth(pstrWidth)
  public Object SetWidth(Object ... _p) {
    mVar pstrWidth = m$.newVarRef("pstrWidth",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Sets the width of the "Chooser Bar"
    //<< ;
    //<< ; History:
    //<< ; 21-Oct-2010   shobby  SR17540 Reload the form if CacheTemp variables have been lost.
    //<< ; 21-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,objUser
    mVar idClass = m$.var("idClass");
    mVar objUser = m$.var("objUser");
    m$.newVar(idClass,objUser);
    //<< 
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< if idClass="" {
    if (mOp.Equal(idClass.get(),"")) {
      //<< do Recover^COMViewDisaster()    ;SR17540
      m$.Cmd.Do("COMViewDisaster.Recover");
    }
    //<< } else {
    else {
      //<< set objUser = $get(^COMViewUser(0,idClass,YBED,1))
      objUser.set(m$.Fnc.$get(m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1)));
      //<< set $$$COMViewUserChooserWidth(objUser) = pstrWidth
      include.COMConst.$$$COMViewUserChooserWidthSet(m$,objUser,pstrWidth.get());
      //<< set ^COMViewUser(0,idClass,YBED,1)      = objUser
      m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1).set(objUser.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Show()
  public Object Show() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Shows the Field Chooser control if the user hasn't been into that control yet.
    //<< ;
    //<< ; Structure:
    //<< ; +--------------------------+
    //<< ; |td - fldChoose            |
    //<< ; |+-------------------------+
    //<< ; ||div                      |
    //<< ; |+-------------------------+
    //<< ; ||select - ChooserType     |
    //<< ; |+-------------------------+
    //<< ; ||table  - ChooserSub0Field|
    //<< ; |+-------------------------+
    //<< ; ||div    - ChooserSub1     |
    //<< ; ||+------------------------+
    //<< ; |||span                    |
    //<< ; ||+------------------------+
    //<< ; |||select- ChooserSub1Type |
    //<< ; ||+------------------------+
    //<< ; |||table - ChooserSub1Field|
    //<< ; ||+------------------------+
    //<< ; |+-------------------------+
    //<< ; +--------------------------+
    //<< ;
    //<< ; History:
    //<< ; 24-Oct-2010   shobby  SR17477: Renamed some elements to be more generic.
    //<< ; 21-Oct-2010   shobby  SR17540: Reload the form if CacheTemp variables have been lost.
    //<< ; 14-Apr-2010   shobby  SR17253: objDiv -> objDIV
    //<< ; 13-Nov-2009   DWR     SR17024: Pass top level "0" to PopulateChoose method and
    //<< ;                           loadChooserType method
    //<< ; 19-Jul-2006   JW      SR14832: Add form parameter
    //<< ; 21-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,objUser,intWidth,idForm
    mVar idClass = m$.var("idClass");
    mVar objUser = m$.var("objUser");
    mVar intWidth = m$.var("intWidth");
    mVar idForm = m$.var("idForm");
    m$.newVar(idClass,objUser,intWidth,idForm);
    //<< 
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set idForm  = $get(^CacheTempView(YUSER,"Form"))        //SR14832
    idForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Form")));
    //<< 
    //<< if idClass="" {
    if (mOp.Equal(idClass.get(),"")) {
      //<< do Recover^COMViewDisaster() ;SR17540
      m$.Cmd.Do("COMViewDisaster.Recover");
    }
    //<< } else {
    else {
      //<< kill ^CacheTempChoose(YUSER)
      m$.var("^CacheTempChoose",m$.var("YUSER").get()).kill();
      //<< do PopulateChoose(idClass,,idForm,0)           //SR14832 // SR17024
      m$.Cmd.Do("PopulateChoose",idClass.get(),null,idForm.get(),0);
      //<< 
      //<< &js<
      //<< var objDIV=document.createElement('div');fldChoose.appendChild(objDIV);     //SR17253
      //<< objDIV.style.height='100%';                                                 //SR17253
      //<< objDIV.style.width='100%';                                                  //SR17253
      //<< objDIV.style.overflowY='auto';                                              //SR17253
      //<< objDIV.id='fldChooseDiv';                                                   //SR17362
      //<< var objType=document.createElement('select');objDIV.appendChild(objType);   //SR17253
      //<< objType.attachEvent("onchange",ChooserTypeChanged);
      //<< objType.id="ChooserType";
      //<< objType.style.width='100%';
      //<< var objField=document.createElement('table');objDIV.appendChild(objField);  //SR17253
      //<< objField.style.width='100%';
      //<< var objBody=document.createElement('tbody');objField.appendChild(objBody);
      //<< objBody.id="ChooserSub0Field";
      //<< var objSub=document.createElement('div');objDIV.appendChild(objSub);        //SR17253
      //<< objSub.id="ChooserSub1";
      //<< >
      m$.Cmd.WriteJS("","\n");
      m$.Cmd.WriteJS("        var objDIV=document.createElement('div');fldChoose.appendChild(objDIV);     //SR17253","\n");
      m$.Cmd.WriteJS("        objDIV.style.height='100%';                                                 //SR17253","\n");
      m$.Cmd.WriteJS("        objDIV.style.width='100%';                                                  //SR17253","\n");
      m$.Cmd.WriteJS("        objDIV.style.overflowY='auto';                                              //SR17253","\n");
      m$.Cmd.WriteJS("        objDIV.id='fldChooseDiv';                                                   //SR17362","\n");
      m$.Cmd.WriteJS("        var objType=document.createElement('select');objDIV.appendChild(objType);   //SR17253","\n");
      m$.Cmd.WriteJS("        objType.attachEvent(\"onchange\",ChooserTypeChanged);","\n");
      m$.Cmd.WriteJS("        objType.id=\"ChooserType\";","\n");
      m$.Cmd.WriteJS("        objType.style.width='100%';","\n");
      m$.Cmd.WriteJS("        var objField=document.createElement('table');objDIV.appendChild(objField);  //SR17253","\n");
      m$.Cmd.WriteJS("        objField.style.width='100%';","\n");
      m$.Cmd.WriteJS("        var objBody=document.createElement('tbody');objField.appendChild(objBody);","\n");
      m$.Cmd.WriteJS("        objBody.id=\"ChooserSub0Field\";","\n");
      m$.Cmd.WriteJS("        var objSub=document.createElement('div');objDIV.appendChild(objSub);        //SR17253","\n");
      m$.Cmd.WriteJS("        objSub.id=\"ChooserSub1\";","\n");
      m$.Cmd.WriteJS("        ");
      //<< 
      //<< do LoadChooserType(idClass,"ChooserType","ChooserSub0Field",0)
      m$.Cmd.Do("LoadChooserType",idClass.get(),"ChooserType","ChooserSub0Field",0);
      //<< 
      //<< set objUser  = $get(^COMViewUser(0,idClass,YBED,1))
      objUser.set(m$.Fnc.$get(m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1)));
      //<< set intWidth = $$$COMViewUserChooserWidth(objUser)
      intWidth.set(include.COMConst.$$$COMViewUserChooserWidth(m$,objUser));
      //<< if intWidth<100 set intWidth = 100
      if (mOp.Less(intWidth.get(),100)) {
        intWidth.set(100);
      }
      //<< write "fldChoose.style.width="_intWidth_";",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("fldChoose.style.width=",intWidth.get()),";"),"\n");
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< LoadSubClass(pidClass="",pidField="",pintLevel)
  public Object LoadSubClass(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pintLevel = m$.newVarRef("pintLevel",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Runs if a user selects a field based on another class.
    //<< ;
    //<< ; History:
    //<< ; 24-Nov-2010   shobby  SR17477: Replaces LoadSubClass/LoadSubClass2/LoadSubClass3
    //<< ; 17-Sep-2010   shobby  SR17477: Simplified.
    //<< ; 13-Nov-2009   DWR     SR17024: Pass Sub level "1" to various methods to ensure
    //<< ;                           only related to this sublevel.
    //<< ;                           Create the next level down.
    //<< ; 19-Apr-2006   JW      SR14429: Remove for views. Unnecessary
    //<< ; 21-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit:$get(^CacheTempView(YUSER,"View"))
    if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"View")))) {
      return null;
    }
    //<< 
    //<< if '$data(^CacheTempChoose(YUSER,pidClass,pintLevel)) do PopulateChoose(pidClass,pidField,,pintLevel)   ;SR17024
    if (mOp.Not(m$.Fnc.$data(m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get())))) {
      m$.Cmd.Do("PopulateChoose",pidClass.get(),pidField.get(),null,pintLevel.get());
    }
    //<< 
    //<< &js<
    //<< var objChooser=document.getElementById('ChooserSub'+#(pintLevel)#);
    //<< 
    //<< var objSpan=document.createElement('span');objChooser.appendChild(objSpan);
    //<< objSpan.style.width='100%';
    //<< objSpan.innerHTML='#($zcvt($$GetClassDescription^COMViewDescription(pidClass),"o","JS"))#';
    //<< objSpan.title='#(pidClass)#';
    //<< objSpan.style.fontSize=12;
    //<< var objType=document.createElement('select');objChooser.appendChild(objType);
    //<< 
    //<< objType.attachEvent("onchange",function() { ChooserSubTypeChanged(#(pintLevel)#) });
    //<< objType.id="ChooserSub"+#(pintLevel)#+"Type";
    //<< objType.style.width='100%';
    //<< var objField=document.createElement('table');objChooser.appendChild(objField);
    //<< objField.style.width='100%';
    //<< var objBody=document.createElement('tbody');objField.appendChild(objBody);
    //<< objBody.id="ChooserSub"+#(pintLevel)#+"Field";
    //<< var objSub=document.createElement('div');objChooser.appendChild(objSub);
    //<< objSub.id="ChooserSub"+#(pintLevel+1)#;
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        var objChooser=document.getElementById('ChooserSub'+",(pintLevel.get())),");"),"\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        var objSpan=document.createElement('span');objChooser.appendChild(objSpan);","\n");
    m$.Cmd.WriteJS("        objSpan.style.width='100%';","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        objSpan.innerHTML='",(m$.Fnc.$zconvert(m$.fnc$("COMViewDescription.GetClassDescription",pidClass.get()),"o","JS"))),"';"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        objSpan.title='",(pidClass.get())),"';"),"\n");
    m$.Cmd.WriteJS("        objSpan.style.fontSize=12;","\n");
    m$.Cmd.WriteJS("        var objType=document.createElement('select');objChooser.appendChild(objType);","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        objType.attachEvent(\"onchange\",function() { ChooserSubTypeChanged(",(pintLevel.get())),") });"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        objType.id=\"ChooserSub\"+",(pintLevel.get())),"+\"Type\";"),"\n");
    m$.Cmd.WriteJS("        objType.style.width='100%';","\n");
    m$.Cmd.WriteJS("        var objField=document.createElement('table');objChooser.appendChild(objField);","\n");
    m$.Cmd.WriteJS("        objField.style.width='100%';","\n");
    m$.Cmd.WriteJS("        var objBody=document.createElement('tbody');objField.appendChild(objBody);","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        objBody.id=\"ChooserSub\"+",(pintLevel.get())),"+\"Field\";"),"\n");
    m$.Cmd.WriteJS("        var objSub=document.createElement('div');objChooser.appendChild(objSub);","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        objSub.id=\"ChooserSub\"+",(mOp.Add(pintLevel.get(),1))),";"),"\n");
    m$.Cmd.WriteJS("    ");
    //<< 
    //<< do LoadChooserType(pidClass,"ChooserSub"_pintLevel_"Type","ChooserSub"_pintLevel_"Field",pintLevel)  ;SR17024
    m$.Cmd.Do("LoadChooserType",pidClass.get(),mOp.Concat(mOp.Concat("ChooserSub",pintLevel.get()),"Type"),mOp.Concat(mOp.Concat("ChooserSub",pintLevel.get()),"Field"),pintLevel.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< LoadChooserType(pidClass,pidDOMSelect,pidDOMTable,pintLevel)
  public Object LoadChooserType(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidDOMSelect = m$.newVarRef("pidDOMSelect",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidDOMTable = m$.newVarRef("pidDOMTable",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintLevel = m$.newVarRef("pintLevel",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Populates the select box for the Chooser or SubChooser
    //<< ;
    //<< ; History:
    //<< ; 12-Nov-2009   DWR     SR17024: Add pintLevel
    //<< ; 21-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strType
    mVar strType = m$.var("strType");
    m$.newVar(strType);
    //<< 
    //<< do StartCombo^COMCombo(pidDOMSelect,$$$EnumCOMVIEWCHOOSERPopularFields,$$$YES,$$$YES)
    m$.Cmd.Do("COMCombo.StartCombo",pidDOMSelect.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERPopularFields(m$),include.COMSYS.$$$YES(m$),include.COMSYS.$$$YES(m$));
    //<< set strType = ""
    strType.set("");
    //<< for {
    for (;true;) {
      //<< set strType = $order(^CacheTempChoose(YUSER,pidClass,pintLevel,strType))
      strType.set(m$.Fnc.$order(m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),strType.get())));
      //<< quit:strType=""
      if (mOp.Equal(strType.get(),"")) {
        break;
      }
      //<< 
      //<< do AddOption^COMCombo(strType,$zconvert($$GetEnumDescription^COMUtils("COMVIEWCHOOSER",strType),"o","JS"))
      m$.Cmd.Do("COMCombo.AddOption",strType.get(),m$.Fnc.$zconvert(m$.fnc$("COMUtils.GetEnumDescription","COMVIEWCHOOSER",strType.get()),"o","JS"));
    }
    //<< }
    //<< do StopCombo^COMCombo()
    m$.Cmd.Do("COMCombo.StopCombo");
    //<< do LoadFields(pidClass,$$$EnumCOMVIEWCHOOSERPopularFields,pidDOMTable,pintLevel)
    m$.Cmd.Do("LoadFields",pidClass.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERPopularFields(m$),pidDOMTable.get(),pintLevel.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< LoadFields(pidClass,pstrType,pidDOMTable,pintLevel)
  public Object LoadFields(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidDOMTable = m$.newVarRef("pidDOMTable",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintLevel = m$.newVarRef("pintLevel",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Populates the field table for the Chooser or SubChooser
    //<< ;
    //<< ; History:
    //<< ; 12-Nov-2009   DWR     SR17024: Add pintLevel
    //<< ; 15-Mar-2005   Paul K  SR11899: Don't "Drag/Drop" related class fields.
    //<< ; 21-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,strField,strRelation
    mVar idField = m$.var("idField");
    mVar strField = m$.var("strField");
    mVar strRelation = m$.var("strRelation");
    m$.newVar(idField,strField,strRelation);
    //<< 
    //<< if pidClass="" set pidClass = $get(^CacheTempView(YUSER,"Class"))
    if (mOp.Equal(pidClass.get(),"")) {
      pidClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    }
    //<< write "ClearRows("_pidDOMTable_");",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("ClearRows(",pidDOMTable.get()),");"),"\n");
    //<< set strField = ""
    strField.set("");
    //<< for {
    for (;true;) {
      //<< set strField = $order(^CacheTempChoose(YUSER,pidClass,pintLevel,pstrType,strField))
      strField.set(m$.Fnc.$order(m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),pstrType.get(),strField.get())));
      //<< quit:strField=""
      if (mOp.Equal(strField.get(),"")) {
        break;
      }
      //<< 
      //<< set idField = ""
      idField.set("");
      //<< for {
      for (;true;) {
        //<< set idField = $order(^CacheTempChoose(YUSER,pidClass,pintLevel,pstrType,strField,idField))
        idField.set(m$.Fnc.$order(m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),pstrType.get(),strField.get(),idField.get())));
        //<< quit:idField=""
        if (mOp.Equal(idField.get(),"")) {
          break;
        }
        //<< 
        //<< set strRelation = $get(^CacheTempChoose(YUSER,pidClass,pintLevel,pstrType,strField,idField))
        strRelation.set(m$.Fnc.$get(m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),pstrType.get(),strField.get(),idField.get())));
        //<< ;_"','"_$zconvert($$GetDescription^COMViewDescription(pidClass),"o","JS") ;BR014900
        //<< write "AddChooseField("_pidDOMTable_",'"_$zcvt(idField,"o","JS")_"','"_$zcvt(strField,"o","JS")_"','"_$zcvt(strRelation,"o","JS")_"','"_(pstrType'=$$$EnumCOMVIEWCHOOSERRelatedClasses)_"');"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("AddChooseField(",pidDOMTable.get()),",'"),m$.Fnc.$zconvert(idField.get(),"o","JS")),"','"),m$.Fnc.$zconvert(strField.get(),"o","JS")),"','"),m$.Fnc.$zconvert(strRelation.get(),"o","JS")),"','"),(mOp.NotEqual(pstrType.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERRelatedClasses(m$)))),"');"));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PopulateChoose(pidClass,pidField="",pidForm="",pintLevel)
  public Object PopulateChoose(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pintLevel = m$.newVarRef("pintLevel",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Populates a global(^CacheTempChoose) representing field types used to
    //<< ; determine fields in Chooser Table and Select boxes.
    //<< ;
    //<< ; History:
    //<< ; 12-Nov-2009   DWR     SR17024: Add pintLevel
    //<< ; 07-Apr-2009   PPP     SR16468: Header details - Object Properties to go through
    //<< ;                           language translation before display
    //<< ;                           (WWWClassTranslation)
    //<< ; 23-Feb-2009   shobby  SR16386:Calculated fields on related classes were not
    //<< ;                           getting the ID formed properly.
    //<< ; 07-Oct-2008   PP      SR15960:Added Index fields as Popular Fields
    //<< ; 26-Sep-2008   PP      SR15960:Update to cater for alSYS.dt (datatype) classes
    //<< ; 09-Sep-2008   PP      SR15866:Update COMView to Objects
    //<< ; 24-Jun-2008   shobby  SRBR014958: std routine to get calculated field description
    //<< ; 19-Dec-2007   shobby  Redirect property name calculation to GetDescription,
    //<< ;                           Use the GetRelation to find out more precise
    //<< ;                           information on the property relation from the form.
    //<< ; 13-Dec-2007   GRF     Doco
    //<< ; 07-Sep-2006   GRF     SRBR014020; reverted _FREE test
    //<< ; 19-Jul-2006   JW      SR14832: Add form parameter, call WWWFELDNAME correctly
    //<< ; 19-Apr-2006   shobby  SRBR014020:Allow free fields to be included.
    //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
    //<< ; 08-Feb-2005   PO      SR10965 Adding support for related classes.
    //<< ; 21-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrIndexProperties,blnObj,idClass,idField,idGlobal
    mVar arrIndexProperties = m$.var("arrIndexProperties");
    mVar blnObj = m$.var("blnObj");
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar idGlobal = m$.var("idGlobal");
    m$.newVar(arrIndexProperties,blnObj,idClass,idField,idGlobal);
    //<< new intCnt,intMaxCnt,loop,objClass,objField,objIndex,objProp
    mVar intCnt = m$.var("intCnt");
    mVar intMaxCnt = m$.var("intMaxCnt");
    mVar loop = m$.var("loop");
    mVar objClass = m$.var("objClass");
    mVar objField = m$.var("objField");
    mVar objIndex = m$.var("objIndex");
    mVar objProp = m$.var("objProp");
    m$.newVar(intCnt,intMaxCnt,loop,objClass,objField,objIndex,objProp);
    //<< new strClass,strDesc,strField,strProperties,strRef,strRelationClass,strType
    mVar strClass = m$.var("strClass");
    mVar strDesc = m$.var("strDesc");
    mVar strField = m$.var("strField");
    mVar strProperties = m$.var("strProperties");
    mVar strRef = m$.var("strRef");
    mVar strRelationClass = m$.var("strRelationClass");
    mVar strType = m$.var("strType");
    m$.newVar(strClass,strDesc,strField,strProperties,strRef,strRelationClass,strType);
    //<< 
    //<< if pidForm="" set pidForm = pidClass        // This is a default if form is unknown
    if (mOp.Equal(pidForm.get(),"")) {
      pidForm.set(pidClass.get());
    }
    //<< set blnObj = $get(^CacheTempObj(YUSER,"Object"))    //SR15866
    blnObj.set(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object")));
    //<< 
    //<< if 'blnObj {
    if (mOp.Not(blnObj.get())) {
      //<< set idGlobal=""
      idGlobal.set("");
      //<< for {
      for (;true;) {
        //<< set idGlobal=$order(^WWW001(0,idGlobal))
        idGlobal.set(m$.Fnc.$order(m$.var("^WWW001",0,idGlobal.get())));
        //<< quit:idGlobal=""
        if (mOp.Equal(idGlobal.get(),"")) {
          break;
        }
        //<< 
        //<< //Exclude if marked for Delete
        //<< continue:$$$WWW001ClassType($get(^WWW001(0,idGlobal,1)))=99     //SR17372
        if (mOp.Equal(include.WWWConst.$$$WWW001ClassType(m$,m$.Fnc.$get(m$.var("^WWW001",0,idGlobal.get(),1))),99)) {
          continue;
        }
        //<< 
        //<< 
        //<< ; FIXME : the following if test should simply be -
        //<< ;   continue:idGlobal=pidClass            ; don't search base class for relations of itself
        //<< if pidClass'=idGlobal {
        if (mOp.NotEqual(pidClass.get(),idGlobal.get())) {
          //<< set idField=""
          idField.set("");
          //<< for {
          for (;true;) {
            //<< set idField=$order(^WWW002(0,idGlobal,idField))
            idField.set(m$.Fnc.$order(m$.var("^WWW002",0,idGlobal.get(),idField.get())));
            //<< quit:idField=""
            if (mOp.Equal(idField.get(),"")) {
              break;
            }
            //<< 
            //<< set objField=$get(^WWW002(0,idGlobal,idField,1))
            objField.set(m$.Fnc.$get(m$.var("^WWW002",0,idGlobal.get(),idField.get(),1)));
            //<< 
            //<< set strRelationClass=$$$WWW002RelationClass(objField)
            strRelationClass.set(include.WWWConst.$$$WWW002RelationClass(m$,objField));
            //<< if $extract(strRelationClass,1,5)="WWW10" set strRelationClass=""
            if (mOp.Equal(m$.Fnc.$extract(strRelationClass.get(),1,5),"WWW10")) {
              strRelationClass.set("");
            }
            //<< if strRelationClass="INPARA" set strRelationClass=""
            if (mOp.Equal(strRelationClass.get(),"INPARA")) {
              strRelationClass.set("");
            }
            //<< 
            //<< ;-----------------------------------
            //<< ;   If the primary key has the base class as a relation, add the using
            //<< ;   class to the list.
            //<< ;   Once one primary key has been found with the link, skip remaining
            //<< ;   keys for the using class and continue with the next using class.
            //<< ;-----------------------------------
            //<< 
            //<< if pidClass=strRelationClass {
            if (mOp.Equal(pidClass.get(),strRelationClass.get())) {
              //<< //if pidClass=strRelationClass & (idField = 1) {
              //<< set strDesc  = $$GetDescription^COMViewDescription(idGlobal)  ; class name ;BR014900
              strDesc.set(m$.fnc$("COMViewDescription.GetDescription",idGlobal.get()));
              //<< set strField = "P"_idField_".C"_idGlobal
              strField.set(mOp.Concat(mOp.Concat(mOp.Concat("P",idField.get()),".C"),idGlobal.get()));
              //<< set strRef   = "^"_idGlobal
              strRef.set(mOp.Concat("^",idGlobal.get()));
              //<< 
              //<< if ($get(strField)'="") && (strDesc'="") && ($data(@strRef)>1) {
              if ((mOp.NotEqual(m$.Fnc.$get(strField),"")) && (mOp.NotEqual(strDesc.get(),"")) && (mOp.Greater(m$.Fnc.$data(m$.indirectVar(strRef.get())),1))) {
                //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERRelatedClasses,strDesc,strField)=idGlobal
                m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERRelatedClasses(m$),strDesc.get(),strField.get()).set(idGlobal.get());
              }
              //<< }
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
      //<< for strClass="^WWW002","^WWW003" {
      for (Object _strClass: new Object[] {"^WWW002","^WWW003"}) {
        strClass.set(_strClass);
        //<< set idField=""
        idField.set("");
        //<< for {
        for (;true;) {
          //<< set idField=$order(@strClass@(0,pidClass,idField))
          idField.set(m$.Fnc.$order(m$.indirectVar(_strClass).var(0,pidClass.get(),idField.get())));
          //<< quit:idField=""
          if (mOp.Equal(idField.get(),"")) {
            break;
          }
          //<< 
          //<< set objField=$get(@strClass@(0,pidClass,idField,1))
          objField.set(m$.Fnc.$get(m$.indirectVar(_strClass).var(0,pidClass.get(),idField.get(),1)));
          //<< set strField=$select(strClass="^WWW002":"P",1:"D")_idField
          strField.set(mOp.Concat(m$.Fnc.$select(mOp.Equal(_strClass,"^WWW002"),"P",1,"D"),idField.get()));
          //<< 
          //<< ; FIXME : Why build the string and then pull it apart!
          //<< 
          //<< //  set strDesc = $$^WWWFELDNAME(pidClass,$extract(strField,1),$extract(strField,2,99))
          //<< set strDesc = $$GetDescription^COMViewDescription(pidClass,$extract(strField,1),$extract(strField,2,99))        //SR14832 ;BR014751 ;BR014900
          strDesc.set(m$.fnc$("COMViewDescription.GetDescription",pidClass.get(),m$.Fnc.$extract(strField.get(),1),m$.Fnc.$extract(strField.get(),2,99)));
          //<< 
          //<< if strClass="^WWW003" set objField=$$GetRelation^COMViewUtils(.pidClass,strField,.pidForm,$extract(strField,1))     ;BR014751
          if (mOp.Equal(_strClass,"^WWW003")) {
            objField.set(m$.fnc$("COMViewUtils.GetRelation",pidClass,strField.get(),pidForm,m$.Fnc.$extract(strField.get(),1)));
          }
          //<< 
          //<< if $extract(strDesc,1,5)'="_FREE" {      ;SRBR014020  ; reverted 07-Sep-2006
          if (mOp.NotEqual(m$.Fnc.$extract(strDesc.get(),1,5),"_FREE")) {
            //<< 
            //<< set strRelationClass=$$$WWW002RelationClass(objField)
            strRelationClass.set(include.WWWConst.$$$WWW002RelationClass(m$,objField));
            //<< 
            //<< if $extract(strRelationClass,1,5)="WWW10" set strRelationClass=""
            if (mOp.Equal(m$.Fnc.$extract(strRelationClass.get(),1,5),"WWW10")) {
              strRelationClass.set("");
            }
            //<< if strRelationClass="INPARA" set strRelationClass=""
            if (mOp.Equal(strRelationClass.get(),"INPARA")) {
              strRelationClass.set("");
            }
            //<< if strRelationClass=pidClass set strRelationClass="" ;shobby 17-Apr-2009
            if (mOp.Equal(strRelationClass.get(),pidClass.get())) {
              strRelationClass.set("");
            }
            //<< 
            //<< if pidField'="" set strField=pidField_"."_strField
            if (mOp.NotEqual(pidField.get(),"")) {
              strField.set(mOp.Concat(mOp.Concat(pidField.get(),"."),strField.get()));
            }
            //<< 
            //<< if (strClass="^WWW002")||($$$WWW002IndexKey(objField)'="") {  ;popular fields
            if ((mOp.Equal(_strClass,"^WWW002")) || (mOp.NotEqual(include.WWWConst.$$$WWW002IndexKey(m$,objField),""))) {
              //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERPopularFields,strDesc,strField)=strRelationClass
              m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERPopularFields(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
            }
            //<< }
            //<< if $find(",1,7,14,",","_$$$WWW002InputType(objField)_",") {
            if (mOp.Logical(m$.Fnc.$find(",1,7,14,",mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW002InputType(m$,objField)),",")))) {
              //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERDateTime,strDesc,strField)=strRelationClass
              m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERDateTime(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
            }
            //<< 
            //<< } elseif $find(",4,8,12,18,",","_$$$WWW002InputType(objField)_",") {        //SR13074
            else if (mOp.Logical(m$.Fnc.$find(",4,8,12,18,",mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW002InputType(m$,objField)),",")))) {
              //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERNumericCurrency,strDesc,strField)=strRelationClass
              m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERNumericCurrency(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
            }
            //<< 
            //<< } elseif $find(",3,6,9,10,13,",","_$$$WWW002InputType(objField)_",") {
            else if (mOp.Logical(m$.Fnc.$find(",3,6,9,10,13,",mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW002InputType(m$,objField)),",")))) {
              //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERTextMemo,strDesc,strField)=strRelationClass
              m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERTextMemo(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
            }
            //<< 
            //<< } elseif $$$WWW002InputType(objField)=2 {
            else if (mOp.Equal(include.WWWConst.$$$WWW002InputType(m$,objField),2)) {
              //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERYesNo,strDesc,strField)=strRelationClass
              m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERYesNo(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
            }
            //<< 
            //<< } elseif $find(",3,6,9,",","_$$$WWW002InputType(objField)_",") {
            else if (mOp.Logical(m$.Fnc.$find(",3,6,9,",mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW002InputType(m$,objField)),",")))) {
              //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSEROtherFields,strDesc,strField)=strRelationClass
              m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSEROtherFields(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< ;SR13213
      //<< set strClass = "^WWW003Calc"
      strClass.set("^WWW003Calc");
      //<< set idField  = ""
      idField.set("");
      //<< for {
      for (;true;) {
        //<< set idField = $order(^WWW003Calc(0,pidClass,idField))
        idField.set(m$.Fnc.$order(m$.var("^WWW003Calc",0,pidClass.get(),idField.get())));
        //<< quit:idField=""
        if (mOp.Equal(idField.get(),"")) {
          break;
        }
        //<< 
        //<< set strDesc = $$GetDescription^COMViewCalculatedField(pidClass,idField,SPRACHE) ;BR014958
        strDesc.set(m$.fnc$("COMViewCalculatedField.GetDescription",pidClass.get(),idField.get(),m$.var("SPRACHE").get()));
        //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERCalculatedFields,strDesc,pidField_$select(pidField="":"",1:".")_"C"_idField) = strRelationClass
        m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERCalculatedFields(m$),strDesc.get(),mOp.Concat(mOp.Concat(mOp.Concat(pidField.get(),m$.Fnc.$select(mOp.Equal(pidField.get(),""),"",1,".")),"C"),idField.get())).set(strRelationClass.get());
      }
    }
    //<< ;   set ^CacheTempChoose(YUSER,pidClass,$$$EnumCOMVIEWCHOOSERCalculatedFields,strDesc,"C"_idField) = strRelationClass  ;SR16386
    //<< }
    //<< }
    //<< 
    //<< if blnObj {    //SR15866
    if (mOp.Logical(blnObj.get())) {
      //<< set objClass = ##class(%Library.ClassDefinition).%OpenId(pidClass)
      objClass.set(m$.fnc$("$Library.ClassDefinition.$OpenId",pidClass.get()));
      //<< 
      //<< if objClass '= $$$NULLOREF {
      if (mOp.NotEqual(objClass.get(),include.$occConstant.$$$NULLOREF(m$))) {
        //<< kill arrIndexProperties
        arrIndexProperties.kill();
        //<< 
        //<< //Get Properties with Indexes
        //<< set intMaxCnt = objClass.Indices.Count()
        intMaxCnt.set(m$.fnc$(objClass.getORef(),"Indices.Count"));
        //<< for intCnt = 1:1:intMaxCnt {
        for (intCnt.set(1);(mOp.LessOrEqual(intCnt.get(),intMaxCnt.get()));intCnt.set(mOp.Add(intCnt.get(),1))) {
          //<< set objIndex = objClass.Indices.GetAt(intCnt)
          objIndex.set(m$.fnc$(objClass.getORef(),"Indices.GetAt",intCnt.get()));
          //<< set strProperties = objIndex.Properties
          strProperties.set(m$.prop(objIndex.get(),"Properties").get());
          //<< 
          //<< for loop=1:1:$length(strProperties,",") {
          for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strProperties.get(),",")));loop.set(mOp.Add(loop.get(),1))) {
            //<< set arrIndexProperties($piece(strProperties,",",loop))=""
            arrIndexProperties.var(m$.Fnc.$piece(strProperties.get(),",",loop.get())).set("");
          }
        }
        //<< }
        //<< }
        //<< 
        //<< set intMaxCnt = objClass.Properties.Count()
        intMaxCnt.set(m$.fnc$(objClass.getORef(),"Properties.Count"));
        //<< for intCnt = 1:1:intMaxCnt {
        for (intCnt.set(1);(mOp.LessOrEqual(intCnt.get(),intMaxCnt.get()));intCnt.set(mOp.Add(intCnt.get(),1))) {
          //<< set objProp = objClass.Properties.GetAt(intCnt)
          objProp.set(m$.fnc$(objClass.getORef(),"Properties.GetAt",intCnt.get()));
          //<< set (strDesc,strField) = objProp.Name       //$select(strClass="^WWW002":"P",1:"D")_idField
          strDesc.set(m$.prop(objProp.get(),"Name").get());
          strField.set(m$.prop(objProp.get(),"Name").get());
          //<< set strDesc = $$GetTextRelated^WWWClassTranslation(pidClass,strField,$get(SPRACHE))     //SR16468
          strDesc.set(m$.fnc$("WWWClassTranslation.GetTextRelated",pidClass.get(),strField.get(),m$.Fnc.$get(m$.var("SPRACHE"))));
          //<< set strType = objProp.Type
          strType.set(m$.prop(objProp.get(),"Type").get());
          //<< 
          //<< if ($extract(strType,1,8)'="alSYS.dt") && ($piece(strType,".",2)="") {
          if ((mOp.NotEqual(m$.Fnc.$extract(strType.get(),1,8),"alSYS.dt")) && (mOp.Equal(m$.Fnc.$piece(strType.get(),".",2),""))) {
            //<< set strType = $piece(pidClass,".",1,$length(pidClass,".")-1)_"."_strType
            strType.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(pidClass.get(),".",1,mOp.Subtract(m$.Fnc.$length(pidClass.get(),"."),1)),"."),strType.get()));
          }
          //<< }
          //<< 
          //<< if pidField'="" {
          if (mOp.NotEqual(pidField.get(),"")) {
            //<< set strField = pidField_"->"_strField
            strField.set(mOp.Concat(mOp.Concat(pidField.get(),"->"),strField.get()));
          }
          //<< }
          //<< 
          //<< set strRelationClass = ""
          strRelationClass.set("");
          //<< if ##class(%Library.ClassDefinition).%ExistsId(strType) {
          if (mOp.Logical(m$.fnc$("$Library.ClassDefinition.$ExistsId",strType.get()))) {
            //<< if $extract(strType,1,8)'="alSYS.dt" set strRelationClass = strType
            if (mOp.NotEqual(m$.Fnc.$extract(strType.get(),1,8),"alSYS.dt")) {
              strRelationClass.set(strType.get());
            }
          }
          //<< }
          //<< 
          //<< //Properties with indices are defined as Popular Fields
          //<< if $data(arrIndexProperties(strField))          ||
          //<< $data(arrIndexProperties(strDesc))           ||
          //<< ('$data(arrIndexProperties) && (intCnt = 1))    {
          if (mOp.Logical(m$.Fnc.$data(arrIndexProperties.var(strField.get()))) || mOp.Logical(m$.Fnc.$data(arrIndexProperties.var(strDesc.get()))) || (mOp.Not(m$.Fnc.$data(arrIndexProperties)) && (mOp.Equal(intCnt.get(),1)))) {
            //<< 
            //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERPopularFields,strDesc,strField)   = strRelationClass
            m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERPopularFields(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
          }
          //<< }
          //<< 
          //<< if (strType = "alSYS.dt.dtDate")      ||
          //<< (strType = "alSYS.dt.dtTime")      ||
          //<< (strType = "alSYS.dt.dtTimeStamp")    {
          if ((mOp.Equal(strType.get(),"alSYS.dt.dtDate")) || (mOp.Equal(strType.get(),"alSYS.dt.dtTime")) || (mOp.Equal(strType.get(),"alSYS.dt.dtTimeStamp"))) {
            //<< 
            //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERDateTime,strDesc,strField)        = strRelationClass
            m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERDateTime(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
          }
          //<< 
          //<< } elseif strType = "alSYS.dt.dtFloat" {
          else if (mOp.Equal(strType.get(),"alSYS.dt.dtFloat")) {
            //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERNumericCurrency,strDesc,strField) = strRelationClass
            m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERNumericCurrency(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
          }
          //<< 
          //<< } elseif (strType = "alSYS.dt.dtInteger") ||
          //<< (strType = "alSYS.dt.dtNumeric")    {
          else if ((mOp.Equal(strType.get(),"alSYS.dt.dtInteger")) || (mOp.Equal(strType.get(),"alSYS.dt.dtNumeric"))) {
            //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERNumericCurrency,strDesc,strField) = strRelationClass
            m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERNumericCurrency(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
          }
          //<< 
          //<< } elseif strType = "alSYS.dt.dtCurrency" {
          else if (mOp.Equal(strType.get(),"alSYS.dt.dtCurrency")) {
            //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERNumericCurrency,strDesc,strField) = strRelationClass
            m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERNumericCurrency(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
          }
          //<< 
          //<< } elseif strType = "alSYS.dt.dtString" {
          else if (mOp.Equal(strType.get(),"alSYS.dt.dtString")) {
            //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERTextMemo,strDesc,strField)        = strRelationClass
            m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERTextMemo(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
          }
          //<< 
          //<< } elseif strType = "alSYS.dt.dtBoolean" {
          else if (mOp.Equal(strType.get(),"alSYS.dt.dtBoolean")) {
            //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERYesNo,strDesc,strField)           = strRelationClass
            m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERYesNo(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
          }
          //<< 
          //<< } else {
          else {
            //<< if strRelationClass'="" {
            if (mOp.NotEqual(strRelationClass.get(),"")) {
              //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSERRelatedClasses,strDesc,strField) = strRelationClass
              m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSERRelatedClasses(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
            }
            //<< 
            //<< } else {
            else {
              //<< set ^CacheTempChoose(YUSER,pidClass,pintLevel,$$$EnumCOMVIEWCHOOSEROtherFields,strDesc,strField)    = strRelationClass
              m$.var("^CacheTempChoose",m$.var("YUSER").get(),pidClass.get(),pintLevel.get(),include.COMConst.$$$EnumCOMVIEWCHOOSEROtherFields(m$),strDesc.get(),strField.get()).set(strRelationClass.get());
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
    //<< quit
    return null;
  }

//<< 
//<< 
}
