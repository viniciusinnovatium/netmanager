//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWEVENTUtils
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-13 19:05:15
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

//<< WWWEVENTUtils
public class WWWEVENTUtils extends mClass {

  public void main() {
    _WWWEVENTUtils();
  }

  public void _WWWEVENTUtils() {
  }

  //<< 
  //<< ForceToInteger(pYFORM,pYART,pYLFN)
  public Object ForceToInteger(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYART = m$.newVarRef("pYART",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYLFN = m$.newVarRef("pYLFN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines whether a field should be forced to integer or not
    //<< ; (ie, zero decimal places)
    //<< ;
    //<< ; Called By : NOT CURRENTLY IN USE
    //<< ;
    //<< ; Params:   pYFORM      : The form we're on
    //<< ;           pYART       : Field type (must be D)
    //<< ;           pYLFN       : Field number
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: blnForce
    //<< ;
    //<< ; History:
    //<< ; 28-Mar-2007   JW      SR15384: No longer in use
    //<< ; 12-Oct-2006   SteveS  SR BR014112: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnForce,objWWW120,idClass,objWWW003,intDecPlaces
    mVar blnForce = m$.var("blnForce");
    mVar objWWW120 = m$.var("objWWW120");
    mVar idClass = m$.var("idClass");
    mVar objWWW003 = m$.var("objWWW003");
    mVar intDecPlaces = m$.var("intDecPlaces");
    m$.newVar(blnForce,objWWW120,idClass,objWWW003,intDecPlaces);
    //<< 
    //<< set blnForce = $$$NO
    blnForce.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if ($get(pYFORM)'="") && (pYART="D") {
    if ((mOp.NotEqual(m$.Fnc.$get(pYFORM),"")) && (mOp.Equal(pYART.get(),"D"))) {
      //<< set objWWW120 = $get(^WWW120(0,pYFORM,1))
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,pYFORM.get(),1)));
      //<< set idClass = $$$WWW120ClassUsedInForm(objWWW120)
      idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objWWW120));
      //<< 
      //<< if (idClass'="")&&($get(pYLFN)'="") {
      if ((mOp.NotEqual(idClass.get(),"")) && (mOp.NotEqual(m$.Fnc.$get(pYLFN),""))) {
        //<< set objWWW003 = $get(^WWW003(0,idClass,pYLFN,1))
        objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,idClass.get(),pYLFN.get(),1)));
        //<< set intDecPlaces = $$$WWW003NoOfDecimals(objWWW003)
        intDecPlaces.set(include.WWWConst.$$$WWW003NoOfDecimals(m$,objWWW003));
        //<< if (intDecPlaces=0) set blnForce = $$$YES
        if ((mOp.Equal(intDecPlaces.get(),0))) {
          blnForce.set(include.COMSYS.$$$YES(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< quit blnForce
    return blnForce.get();
  }

  //<< 
  //<< 
  //<< AllowExecution(pstrRoutine,pstrParams)
  public Object AllowExecution(Object ... _p) {
    mVar pstrRoutine = m$.newVarRef("pstrRoutine",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrParams = m$.newVarRef("pstrParams",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Examine pstrRoutine and try to ensure it is either a TAG^ROUTINE (not starting with $$)
    //<< ; or a class method.
    //<< ;
    //<< ; Params:
    //<< ; pstrRoutine - Code to run
    //<< ; pstrParams - Parameters to pass to code
    //<< ;
    //<< ; Returns: blnValid - $$$YES if code good to run, if $$$NO parameters are logged
    //<< ;                     and an alert is displayed to the user
    //<< ;
    //<< ; History:
    //<< ; 21-Mar-2007   PO      SR15483: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnValid,strFirstChr,idLog
    mVar blnValid = m$.var("blnValid");
    mVar strFirstChr = m$.var("strFirstChr");
    mVar idLog = m$.var("idLog");
    m$.newVar(blnValid,strFirstChr,idLog);
    //<< 
    //<< set blnValid = $$$YES
    blnValid.set(include.COMSYS.$$$YES(m$));
    //<< set strFirstChr = $extract(pstrRoutine,1)
    strFirstChr.set(m$.Fnc.$extract(pstrRoutine.get(),1));
    //<< 
    //<< if strFirstChr = "$" {                       // Prevent intrinsic commands from being executed
    if (mOp.Equal(strFirstChr.get(),"$")) {
      //<< set blnValid = $$$NO
      blnValid.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif strFirstChr = "{" {                 // Prevent do while loops
    else if (mOp.Equal(strFirstChr.get(),"{")) {
      //<< set blnValid = $$$NO
      blnValid.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif pstrRoutine [ " " {                 // Ensure either performing a TAG^ROUTINE or ##class method
    else if (mOp.Contains(pstrRoutine.get()," ")) {
      //<< set blnValid = $$$NO
      blnValid.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } else {
    else {
      //<< if strFirstChr = "#" {                   // Is ##class
      if (mOp.Equal(strFirstChr.get(),"#")) {
        //<< if $extract($piece($$$LOWER(pstrRoutine),"##class(",2),1) = "%" { // Must not be an intrinsic class
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(include.COMSYSString.$$$LOWER(m$,pstrRoutine),"##class(",2),1),"%")) {
          //<< set blnValid = $$$NO
          blnValid.set(include.COMSYS.$$$NO(m$));
        }
        //<< 
        //<< } elseif pstrRoutine [ ",##class" {  // Must be just one method call
        else if (mOp.Contains(pstrRoutine.get(),",##class")) {
          //<< set blnValid = $$$NO
          blnValid.set(include.COMSYS.$$$NO(m$));
        }
      }
      //<< }
      //<< 
      //<< } elseif pstrRoutine '[ "^" {            // Not a ##class, there must be a caret
      else if (mOp.NotContains(pstrRoutine.get(),"^")) {
        //<< set blnValid = $$$NO
        blnValid.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if 'blnValid { // Log rejected callbacks vvv
    if (mOp.Not(blnValid.get())) {
      //<< $$$JournalOff
      include.COMDebug.$$$JournalOff(m$);
      //<< set idLog = $increment(^LogCapturedSecurityBreach)
      idLog.set(m$.Fnc.$increment(m$.var("^LogCapturedSecurityBreach")));
      //<< set ^LogCapturedSecurityBreach(idLog,"pstrRoutine") = pstrRoutine
      m$.var("^LogCapturedSecurityBreach",idLog.get(),"pstrRoutine").set(pstrRoutine.get());
      //<< set ^LogCapturedSecurityBreach(idLog,"pstrParams")  = pstrParams
      m$.var("^LogCapturedSecurityBreach",idLog.get(),"pstrParams").set(pstrParams.get());
      //<< $$$JournalOn
      include.COMDebug.$$$JournalOn(m$);
      //<< $$$Alert($listbuild("WWW00066",pstrRoutine,pstrParams))
      include.COMSYS.$$$Alert(m$,m$.Fnc.$listbuild("WWW00066",pstrRoutine.get(),pstrParams.get()));
    }
    //<< } ; "The CallBack with parameters %1, %2 is rejected as it is considered a security breach."
    //<< quit blnValid
    return blnValid.get();
  }

  //<< 
  //<< 
  //<< CheckRelation(pidForm,pidClass,pidFormFld,pidClassFld,pidAssocClassFld,&pblnIsUnit=$$$NO,&pblnIsItem=$$$NO)
  public Object CheckRelation(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidFormFld = m$.newVarRef("pidFormFld",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidClassFld = m$.newVarRef("pidClassFld",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pidAssocClassFld = m$.newVarRef("pidAssocClassFld",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pblnIsUnit = m$.newVarRef("pblnIsUnit",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$NO(m$));
    mVar pblnIsItem = m$.newVarRef("pblnIsItem",(((_p!=null)&&(_p.length>=7))?_p[6]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine if the field contains a unit of measure enum or a stock item.
    //<< ; Used to consider whether to modify the number of decimal places for quantity
    //<< ; data.
    //<< ;
    //<< ; Called By : FIELD^WWWEVENT, GetDecimalPointNum^COMGridEdit31Body
    //<< ;
    //<< ; Procedure : A quantity field on a form is linked to its associated unit or,
    //<< ;             if it is solely based on the Inventory Unit for an item and the
    //<< ;             class for the form does not specify the Inventory Unit, the
    //<< ;             quantity field is linked directly to the item field.
    //<< ;
    //<< ;             Code to find the matching unit for the quantity field then uses
    //<< ;             the associated unit directly or retrieves the inventory unit from
    //<< ;             the INART record.
    //<< ;
    //<< ; History:
    //<< ; 03-Feb-2011   GRF     SR17579: created
    //<< ;-------------------------------------------------------------------------------
    //<< new idAssocFormFld,idRelClass,objClassFld,objFormFld,strRelKeys
    mVar idAssocFormFld = m$.var("idAssocFormFld");
    mVar idRelClass = m$.var("idRelClass");
    mVar objClassFld = m$.var("objClassFld");
    mVar objFormFld = m$.var("objFormFld");
    mVar strRelKeys = m$.var("strRelKeys");
    m$.newVar(idAssocFormFld,idRelClass,objClassFld,objFormFld,strRelKeys);
    //<< 
    //<< set pblnIsUnit  = $$$NO
    pblnIsUnit.set(include.COMSYS.$$$NO(m$));
    //<< set pblnIsItem  = $$$NO
    pblnIsItem.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set idAssocFormFld = +$$$GetFormField(pidForm,pidAssocClassFld)
    idAssocFormFld.set(mOp.Positive(include.COMSYSWWW.$$$GetFormField(m$,pidForm,pidAssocClassFld)));
    //<< 
    //<< do GetRelationFlds(pidForm,pidClass,idAssocFormFld,pidAssocClassFld,.idRelClass,.strRelKeys)
    m$.Cmd.Do("GetRelationFlds",pidForm.get(),pidClass.get(),idAssocFormFld.get(),pidAssocClassFld.get(),idRelClass,strRelKeys);
    //<< if (idRelClass="WWW101") && (strRelKeys["""EINHEIT""") {
    if ((mOp.Equal(idRelClass.get(),"WWW101")) && (mOp.Contains(strRelKeys.get(),"\"EINHEIT\""))) {
      //<< set pblnIsUnit = $$$YES
      pblnIsUnit.set(include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } elseif idRelClass="INART" {
    else if (mOp.Equal(idRelClass.get(),"INART")) {
      //<< ; When a Unit field links to an Item field, *** DON'T *** indicate the associated field is an Item.
      //<< ; Re-use Relation variables for field containing "Associated with Field" link.
      //<< do GetRelationFlds(pidForm,pidClass,pidFormFld,pidClassFld,.idRelClass,.strRelKeys)
      m$.Cmd.Do("GetRelationFlds",pidForm.get(),pidClass.get(),pidFormFld.get(),pidClassFld.get(),idRelClass,strRelKeys);
      //<< if (idRelClass'="WWW101") || (strRelKeys'["""EINHEIT""") {
      if ((mOp.NotEqual(idRelClass.get(),"WWW101")) || (mOp.NotContains(strRelKeys.get(),"\"EINHEIT\""))) {
        //<< set pblnIsItem  = $$$YES
        pblnIsItem.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetRelationFlds(pidForm,pidClass,pidFormFld,pidClassFld,&pidRelClass="",&pstrRelKeys="")
  public Object GetRelationFlds(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidFormFld = m$.newVarRef("pidFormFld",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidClassFld = m$.newVarRef("pidClassFld",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pidRelClass = m$.newVarRef("pidRelClass",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pstrRelKeys = m$.newVarRef("pstrRelKeys",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; History:
    //<< ; 03-Feb-2011   GRF     SR17579: created
    //<< ;-------------------------------------------------------------------------------
    //<< new objClassFld,objFormFld
    mVar objClassFld = m$.var("objClassFld");
    mVar objFormFld = m$.var("objFormFld");
    m$.newVar(objClassFld,objFormFld);
    //<< 
    //<< set objFormFld  = $get(^WWW122(0,pidForm,pidFormFld,1))
    objFormFld.set(m$.Fnc.$get(m$.var("^WWW122",0,pidForm.get(),pidFormFld.get(),1)));
    //<< set pidRelClass = $$$WWW122RelationClass(objFormFld)
    pidRelClass.set(include.WWWConst.$$$WWW122RelationClass(m$,objFormFld));
    //<< if pidRelClass'="" {
    if (mOp.NotEqual(pidRelClass.get(),"")) {
      //<< set pstrRelKeys = $$$WWW122RelationalPrimaryKey(objFormFld)
      pstrRelKeys.set(include.WWWConst.$$$WWW122RelationalPrimaryKey(m$,objFormFld));
    }
    //<< 
    //<< } elseif pidClassFld'="" {
    else if (mOp.NotEqual(pidClassFld.get(),"")) {
      //<< set objClassFld = $get(^WWW003(0,pidClass,pidClassFld,1))
      objClassFld.set(m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),pidClassFld.get(),1)));
      //<< set pidRelClass = $$$WWW003RelationDatabase(objClassFld)
      pidRelClass.set(include.WWWConst.$$$WWW003RelationDatabase(m$,objClassFld));
      //<< set pstrRelKeys = $$$WWW003RelationalPrimaryKeys(objClassFld)
      pstrRelKeys.set(include.WWWConst.$$$WWW003RelationalPrimaryKeys(m$,objClassFld));
    }
    //<< }
    //<< quit
    return null;
  }

//<< 
//<< 
}
