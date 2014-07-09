//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW001CalcFields
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-08 12:58:41
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; Routines relating to Calculated Fields in Classes (used for SQL Projection)
//<< ;-------------------------------------------------------------------------------
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

//<< WWW001CalcFields
public class WWW001CalcFields extends mClass {

  //<< 
  //<< #define BASESTRING "BASE"
  public static Object $$$BASESTRING(mContext m$) {
    return ("BASE");
  }

  //<< #define FCSTRING   "FC"
  public static Object $$$FCSTRING(mContext m$) {
    return ("FC");
  }

  //<< #define RATESTRING "RATE"
  public static Object $$$RATESTRING(mContext m$) {
    return ("RATE");
  }

  //<< #define CURSTRING  "CUR"
  public static Object $$$CURSTRING(mContext m$) {
    return ("CUR");
  }

  //<< #define AUTOGEN    "Auto generated at "_$$^WWWTIME($H)_" "_$$^WWWDATE($H)
  public static Object $$$AUTOGEN(mContext m$) {
    return (mOp.Concat(mOp.Concat(mOp.Concat("Auto generated at ",m$.fnc$("WWWTIME.main",m$.Fnc.$horolog()))," "),m$.fnc$("WWWDATE.main",m$.Fnc.$horolog())));
  }

  public void main() {
    _WWW001CalcFields();
  }

  public void _WWW001CalcFields() {
  }

  //<< 
  //<< Check()
  public Object Check() {
    //<< /*-------------------------------------------------------------------------------
    //<< ; Finds calculated fields that are too long to project to XML
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Apr-2006   shobby  SRBR014013: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< new idx,objWWW003Calc,intField,strName
    mVar idx = m$.var("idx");
    mVar objWWW003Calc = m$.var("objWWW003Calc");
    mVar intField = m$.var("intField");
    mVar strName = m$.var("strName");
    m$.newVar(idx,objWWW003Calc,intField,strName);
    //<< 
    //<< set idx=""
    idx.set("");
    //<< for {
    for (;true;) {
      //<< set idx=$order(^WWW003Calc(0,idx))
      idx.set(m$.Fnc.$order(m$.var("^WWW003Calc",0,idx.get())));
      //<< quit:idx=""
      if (mOp.Equal(idx.get(),"")) {
        break;
      }
      //<< 
      //<< set intField=""
      intField.set("");
      //<< for {
      for (;true;) {
        //<< set intField=$order(^WWW003Calc(0,idx,intField))
        intField.set(m$.Fnc.$order(m$.var("^WWW003Calc",0,idx.get(),intField.get())));
        //<< quit:intField=""
        if (mOp.Equal(intField.get(),"")) {
          break;
        }
        //<< 
        //<< set objWWW003Calc=$get(^WWW003Calc(0,idx,intField,1))
        objWWW003Calc.set(m$.Fnc.$get(m$.var("^WWW003Calc",0,idx.get(),intField.get(),1)));
        //<< set strName=$$$WWW003CalcFieldName(objWWW003Calc)
        strName.set(include.WWWConst.$$$WWW003CalcFieldName(m$,objWWW003Calc));
        //<< if $length(strName)>28 {
        if (mOp.Greater(m$.Fnc.$length(strName.get()),28)) {
          //<< write !,$extract(idx_"                   ",1,20)_" : "_strName_":"_$length(strName)
          m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(mOp.Concat(idx.get(),"                   "),1,20)," : "),strName.get()),":"),m$.Fnc.$length(strName.get())));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CalcFields(iClass="",pobjClass="")
  public Object CalcFields(Object ... _p) {
    mVar iClass = m$.newVarRef("iClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pobjClass = m$.newVarRef("pobjClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add Calculated Fields to the class
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Jun-2008   PPP     SRAdhoc:Updated the Version to Cache 2008
    //<< ; 02-Dec-2008   shobby  SR16094: Removed a line that was saving after each calc
    //<< ;                           field was added.  This paradoxically caused the
    //<< ;                           calculated fields not to be saved properly.
    //<< ; 02-Nov-2008   shobby  BR014985: Reintroduced method generation for calc fields
    //<< ; 30-Mar-2007   RPW     SR15488: Check for 2007 for compilation of parameters.
    //<< ; 25-Jul-2005   Steve S Clean up
    //<< ; 07-Jul-2005   Steve S Moved from WWW001OO
    //<< ; 22-Jun-2005   SCR     Created SR12755
    //<< ;-------------------------------------------------------------------------------
    //<< new blnIs2007,idCalcField,objCalcField,objMethod,objProp
    mVar blnIs2007 = m$.var("blnIs2007");
    mVar idCalcField = m$.var("idCalcField");
    mVar objCalcField = m$.var("objCalcField");
    mVar objMethod = m$.var("objMethod");
    mVar objProp = m$.var("objProp");
    m$.newVar(blnIs2007,idCalcField,objCalcField,objMethod,objProp);
    //<< new strCaption,strCode,strName,strType
    mVar strCaption = m$.var("strCaption");
    mVar strCode = m$.var("strCode");
    mVar strName = m$.var("strName");
    mVar strType = m$.var("strType");
    m$.newVar(strCaption,strCode,strName,strType);
    //<< 
    //<< if (iClass'="") && (pobjClass'="") {
    if ((mOp.NotEqual(iClass.get(),"")) && (mOp.NotEqual(pobjClass.get(),""))) {
      //<< set blnIs2007 = ($System.Version.GetMajor()>"2007")
      blnIs2007.set((mOp.Greater(m$.getSystem().getVersion().GetMajor(),"2007")));
      //<< 
      //<< set idCalcField = ""
      idCalcField.set("");
      //<< for {
      for (;true;) {
        //<< set idCalcField = $order(^WWW003Calc(0,iClass,idCalcField))
        idCalcField.set(m$.Fnc.$order(m$.var("^WWW003Calc",0,iClass.get(),idCalcField.get())));
        //<< quit:idCalcField=""
        if (mOp.Equal(idCalcField.get(),"")) {
          break;
        }
        //<< 
        //<< set objCalcField = $get(^WWW003Calc(0,iClass,idCalcField,1))
        objCalcField.set(m$.Fnc.$get(m$.var("^WWW003Calc",0,iClass.get(),idCalcField.get(),1)));
        //<< 
        //<< set strName    = $$$WWW003CalcFieldName(objCalcField)
        strName.set(include.WWWConst.$$$WWW003CalcFieldName(m$,objCalcField));
        //<< set strCode    = $$$WWW003CalcCode(objCalcField)
        strCode.set(include.WWWConst.$$$WWW003CalcCode(m$,objCalcField));
        //<< set strType    = $$$WWW003CalcDataType(objCalcField)
        strType.set(include.WWWConst.$$$WWW003CalcDataType(m$,objCalcField));
        //<< set strCaption = $$$WWW003CalcCaption(objCalcField)
        strCaption.set(include.WWWConst.$$$WWW003CalcCaption(m$,objCalcField));
        //<< 
        //<< if strType=""    set strType    = "%String"
        if (mOp.Equal(strType.get(),"")) {
          strType.set("%String");
        }
        //<< if strCaption="" set strCaption = strName
        if (mOp.Equal(strCaption.get(),"")) {
          strCaption.set(strName.get());
        }
        //<< 
        //<< set objProp=##class(%Dictionary.PropertyDefinition).%New()
        objProp.set(m$.fnc$("$Dictionary.PropertyDefinition.$New"));
        //<< do pobjClass.Properties.Insert(objProp)
        m$.Cmd.Do(pobjClass.getORef(),"Properties.Insert",objProp.get());
        //<< 
        //<< set objProp.Name = strName
        m$.prop(objProp.get(),"Name").set(strName.get());
        //<< set objProp.Type = strType
        m$.prop(objProp.get(),"Type").set(strType.get());
        //<< if blnIs2007 {
        if (mOp.Logical(blnIs2007.get())) {
          //<< do objProp.Parameters.SetAt(strCaption,"CAPTION")
          m$.Cmd.Do(objProp.getORef(),"Parameters.SetAt",strCaption.get(),"CAPTION");
        }
        //<< } else {
        else {
          //<< set objProp.Parameters.Data("CAPTION") = strCaption
          m$.prop(objProp.get(),"Parameters.Data").var("CAPTION").set(strCaption.get());
        }
        //<< }
        //<< set objProp.SqlComputeCode = " set {"_strName_"}="_strCode
        m$.prop(objProp.get(),"SqlComputeCode").set(mOp.Concat(mOp.Concat(mOp.Concat(" set {",strName.get()),"}="),strCode.get()));
        //<< set objProp.Calculated     = $$$YES
        m$.prop(objProp.get(),"Calculated").set(include.COMSYS.$$$YES(m$));
        //<< set objProp.SqlComputed    = $$$YES
        m$.prop(objProp.get(),"SqlComputed").set(include.COMSYS.$$$YES(m$));
        //<< 
        //<< 
        //<< ;SR16094 (commented the following line)
        //<< ;   if $get(YNOFORM)=1 set e = CLASS.%Save() if 'e { write !,"WWW003Calc"_"::"_iClass_":"_objProp.Name_" "_idCalcField do DisplayError^%apiOBJ(e) quit}
        //<< 
        //<< ;;SR14395 ;BR014985 VVV
        //<< if $length(strName)>28 set strName = $extract(strName,1,28)
        if (mOp.Greater(m$.Fnc.$length(strName.get()),28)) {
          strName.set(m$.Fnc.$extract(strName.get(),1,28));
        }
        //<< set objMethod = ##class(%Dictionary.MethodDefinition).%New()
        objMethod.set(m$.fnc$("$Dictionary.MethodDefinition.$New"));
        //<< set objMethod.Name       = strName_"Get"
        m$.prop(objMethod.get(),"Name").set(mOp.Concat(strName.get(),"Get"));
        //<< set objMethod.ReturnType = strType
        m$.prop(objMethod.get(),"ReturnType").set(strType.get());
        //<< set objMethod.CodeMode   = "expression"
        m$.prop(objMethod.get(),"CodeMode").set("expression");
        //<< 
        //<< do objMethod.Implementation.Write($$TOSTREAM^WWWMEMO($translate($$FullReplace^COMUtilStr(strCode,"{",".."),"}")))
        m$.Cmd.Do(objMethod.getORef(),"Implementation.Write",m$.fnc$("WWWMEMO.TOSTREAM",m$.Fnc.$translate(m$.fnc$("COMUtilStr.FullReplace",strCode.get(),"{",".."),"}")));
        //<< do pobjClass.Methods.Insert(objMethod)
        m$.Cmd.Do(pobjClass.getORef(),"Methods.Insert",objMethod.get());
        //<< do objMethod.%Close()
        m$.Cmd.Do(objMethod.getORef(),"$Close");
      }
    }
    //<< ;BR014985 ^^^
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ClearAutoGen(pidCalcField="")
  public Object ClearAutoGen(Object ... _p) {
    mVar pidCalcField = m$.newVarRef("pidCalcField",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Clear all auto-generated fields for a class
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Jun-2006   RPW     SRBR014013: Call ReloadForm instead of ^WWWFORM
    //<< ; 22-Jul-2005   SteveS  SR13059: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCalcProp,idClass,objCalcProp
    mVar idCalcProp = m$.var("idCalcProp");
    mVar idClass = m$.var("idClass");
    mVar objCalcProp = m$.var("objCalcProp");
    m$.newVar(idCalcProp,idClass,objCalcProp);
    //<< 
    //<< set idClass=$piece(pidCalcField,",",1)
    idClass.set(m$.Fnc.$piece(pidCalcField.get(),",",1));
    //<< set idCalcProp=""
    idCalcProp.set("");
    //<< 
    //<< if idClass'="" {
    if (mOp.NotEqual(idClass.get(),"")) {
      //<< for {
      for (;true;) {
        //<< set idCalcProp=$order(^WWW003Calc(0,idClass,idCalcProp))
        idCalcProp.set(m$.Fnc.$order(m$.var("^WWW003Calc",0,idClass.get(),idCalcProp.get())));
        //<< quit:idCalcProp=""
        if (mOp.Equal(idCalcProp.get(),"")) {
          break;
        }
        //<< 
        //<< set objCalcProp=$get(^WWW003Calc(0,idClass,idCalcProp,1))
        objCalcProp.set(m$.Fnc.$get(m$.var("^WWW003Calc",0,idClass.get(),idCalcProp.get(),1)));
        //<< if $$$WWW003CalcAutoGenerated(objCalcProp) {
        if (mOp.Logical(include.WWWConst.$$$WWW003CalcAutoGenerated(m$,objCalcProp))) {
          //<< do KILL^COMUtils("WWW003Calc",idClass_","_idCalcProp)
          m$.Cmd.Do("COMUtils.KILL","WWW003Calc",mOp.Concat(mOp.Concat(idClass.get(),","),idCalcProp.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< do ReloadForm^COMUtilForm() // SRBR014013
    m$.Cmd.Do("COMUtilForm.ReloadForm");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CalcCurrencyFields(pidClass="")
  public Object CalcCurrencyFields(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Compute calculated currency fields
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Jun-2006   RPW     SRBR014013: Get the shortened name. If two names shorten
    //<< ;                           to the same, the second subsequently gets a number
    //<< ;                           attached
    //<< ; 07-Jul-2005   SteveS  SR12854: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idProperty,objProperty,strPropName,arrProps,strRealName
    mVar idProperty = m$.var("idProperty");
    mVar objProperty = m$.var("objProperty");
    mVar strPropName = m$.var("strPropName");
    mVar arrProps = m$.var("arrProps");
    mVar strRealName = m$.var("strRealName");
    m$.newVar(idProperty,objProperty,strPropName,arrProps,strRealName);
    //<< 
    //<< if pidClass'="" {
    if (mOp.NotEqual(pidClass.get(),"")) {
      //<< set idProperty=""
      idProperty.set("");
      //<< for {
      for (;true;) {
        //<< set idProperty=$order(^WWW003(0,pidClass,idProperty))
        idProperty.set(m$.Fnc.$order(m$.var("^WWW003",0,pidClass.get(),idProperty.get())));
        //<< quit:idProperty=""
        if (mOp.Equal(idProperty.get(),"")) {
          break;
        }
        //<< 
        //<< set objProperty=$get(^WWW003(0,pidClass,idProperty,1))
        objProperty.set(m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),idProperty.get(),1)));
        //<< 
        //<< // Calculate the new name
        //<< 
        //<< set strPropName=$$$WWW003PropertyName(objProperty) // SRBR014013
        strPropName.set(include.WWWConst.$$$WWW003PropertyName(m$,objProperty));
        //<< set strRealName=strPropName
        strRealName.set(strPropName.get());
        //<< 
        //<< if $length(strPropName)>20 {
        if (mOp.Greater(m$.Fnc.$length(strPropName.get()),20)) {
          //<< set strPropName=$extract(strPropName,1,20)
          strPropName.set(m$.Fnc.$extract(strPropName.get(),1,20));
          //<< if '$data(arrProps(strPropName)) {
          if (mOp.Not(m$.Fnc.$data(arrProps.var(strPropName.get())))) {
            //<< set arrProps(strPropName)=""
            arrProps.var(strPropName.get()).set("");
            //<< set arrProps(strPropName,"Count")=0
            arrProps.var(strPropName.get(),"Count").set(0);
          }
          //<< } else {
          else {
            //<< set strPropName=$extract(strPropName,1,19)
            strPropName.set(m$.Fnc.$extract(strPropName.get(),1,19));
            //<< set strPropName=strPropName_($increment(arrProps(strPropName,"Count")))
            strPropName.set(mOp.Concat(strPropName.get(),(m$.Fnc.$increment(arrProps.var(strPropName.get(),"Count")))));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if $$$WWW003InputType(objProperty)=8 { ;Currency
        if (mOp.Equal(include.WWWConst.$$$WWW003InputType(m$,objProperty),8)) {
          //<< do AddBaseCalcField(pidClass,strRealName,strPropName) // SRBR014013
          m$.Cmd.Do("AddBaseCalcField",pidClass.get(),strRealName.get(),strPropName.get());
          //<< if $$$WWW003GenerateFCFields(objProperty) {
          if (mOp.Logical(include.WWWConst.$$$WWW003GenerateFCFields(m$,objProperty))) {
            //<< do AddFCCalcFields(pidClass,strRealName,strPropName) // SRBR014013
            m$.Cmd.Do("AddFCCalcFields",pidClass.get(),strRealName.get(),strPropName.get());
          }
          //<< } else {
          else {
            //<< do RemoveFCCalcFields(pidClass,strPropName,$$$YES) // SRBR014013
            m$.Cmd.Do("RemoveFCCalcFields",pidClass.get(),strPropName.get(),include.COMSYS.$$$YES(m$));
          }
        }
        //<< }
        //<< } else {
        else {
          //<< do RemoveFCCalcFields(pidClass,strPropName,$$$NO) // SRBR014013
          m$.Cmd.Do("RemoveFCCalcFields",pidClass.get(),strPropName.get(),include.COMSYS.$$$NO(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetCalcIndex(pidClass="",pstrPropName="")
  public Object GetCalcIndex(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrPropName = m$.newVarRef("pstrPropName",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; See if a field already has an auto-generated calc field.
    //<< ; If so, return its calc field number.
    //<< ; Else, return blank.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Jul-2005   SteveS  SR13059: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idx,idCalcProp,objCalcProp,strPropName
    mVar idx = m$.var("idx");
    mVar idCalcProp = m$.var("idCalcProp");
    mVar objCalcProp = m$.var("objCalcProp");
    mVar strPropName = m$.var("strPropName");
    m$.newVar(idx,idCalcProp,objCalcProp,strPropName);
    //<< 
    //<< set idx=""
    idx.set("");
    //<< 
    //<< if pidClass'="" {
    if (mOp.NotEqual(pidClass.get(),"")) {
      //<< set idCalcProp=""
      idCalcProp.set("");
      //<< for {
      for (;true;) {
        //<< set idCalcProp=$order(^WWW003Calc(0,pidClass,idCalcProp))
        idCalcProp.set(m$.Fnc.$order(m$.var("^WWW003Calc",0,pidClass.get(),idCalcProp.get())));
        //<< quit:idCalcProp=""
        if (mOp.Equal(idCalcProp.get(),"")) {
          break;
        }
        //<< quit:idx'=""
        if (mOp.NotEqual(idx.get(),"")) {
          break;
        }
        //<< 
        //<< set objCalcProp=$get(^WWW003Calc(0,pidClass,idCalcProp,1))
        objCalcProp.set(m$.Fnc.$get(m$.var("^WWW003Calc",0,pidClass.get(),idCalcProp.get(),1)));
        //<< 
        //<< if $$$WWW003CalcAutoGenerated(objCalcProp) {
        if (mOp.Logical(include.WWWConst.$$$WWW003CalcAutoGenerated(m$,objCalcProp))) {
          //<< set strPropName=$$$WWW003CalcFieldName(objCalcProp)
          strPropName.set(include.WWWConst.$$$WWW003CalcFieldName(m$,objCalcProp));
          //<< if (strPropName=pstrPropName) {
          if ((mOp.Equal(strPropName.get(),pstrPropName.get()))) {
            //<< set idx=idCalcProp
            idx.set(idCalcProp.get());
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit idx
    return idx.get();
  }

  //<< 
  //<< 
  //<< RemoveFCCalcFields(pidClass,pstrPropName,pblnKeepBase=$$$NO)
  public Object RemoveFCCalcFields(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrPropName = m$.newVarRef("pstrPropName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnKeepBase = m$.newVarRef("pblnKeepBase",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Remove auto generated calc fields
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Jun-2006   RPW     SRBR014013: Use the correct property name
    //<< ; 22-Jul-2005   SteveS  SR13059: Use GetCalcIndex, do not use an index
    //<< ; 07-Jul-2005   SteveS  SR12854: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objProperty,strPropName,strBaseName,strFCName,strRateName,strCurName
    mVar objProperty = m$.var("objProperty");
    mVar strPropName = m$.var("strPropName");
    mVar strBaseName = m$.var("strBaseName");
    mVar strFCName = m$.var("strFCName");
    mVar strRateName = m$.var("strRateName");
    mVar strCurName = m$.var("strCurName");
    m$.newVar(objProperty,strPropName,strBaseName,strFCName,strRateName,strCurName);
    //<< new idBaseCalc,idFCCalc,idRateCalc,idCurCalc
    mVar idBaseCalc = m$.var("idBaseCalc");
    mVar idFCCalc = m$.var("idFCCalc");
    mVar idRateCalc = m$.var("idRateCalc");
    mVar idCurCalc = m$.var("idCurCalc");
    m$.newVar(idBaseCalc,idFCCalc,idRateCalc,idCurCalc);
    //<< 
    //<< if (pidClass'="")&&(pstrPropName'="") {
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(pstrPropName.get(),""))) {
      //<< 
      //<< set strBaseName =pstrPropName_$$$BASESTRING // SRBR014013
      strBaseName.set(mOp.Concat(pstrPropName.get(),$$$BASESTRING(m$)));
      //<< set strFCName   =pstrPropName_$$$FCSTRING // SRBR014013
      strFCName.set(mOp.Concat(pstrPropName.get(),$$$FCSTRING(m$)));
      //<< set strRateName =pstrPropName_$$$RATESTRING // SRBR014013
      strRateName.set(mOp.Concat(pstrPropName.get(),$$$RATESTRING(m$)));
      //<< set strCurName  =pstrPropName_$$$CURSTRING // SRBR014013
      strCurName.set(mOp.Concat(pstrPropName.get(),$$$CURSTRING(m$)));
      //<< 
      //<< if ('pblnKeepBase) {
      if ((mOp.Not(pblnKeepBase.get()))) {
        //<< set idBaseCalc=$$GetCalcIndex(pidClass,strBaseName)
        idBaseCalc.set(m$.fnc$("GetCalcIndex",pidClass.get(),strBaseName.get()));
        //<< if idBaseCalc'="" do KILL^COMUtils("WWW003Calc",pidClass_","_idBaseCalc)
        if (mOp.NotEqual(idBaseCalc.get(),"")) {
          m$.Cmd.Do("COMUtils.KILL","WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idBaseCalc.get()));
        }
      }
      //<< }
      //<< 
      //<< set idFCCalc=$$GetCalcIndex(pidClass,strFCName)
      idFCCalc.set(m$.fnc$("GetCalcIndex",pidClass.get(),strFCName.get()));
      //<< if idFCCalc'="" do KILL^COMUtils("WWW003Calc",pidClass_","_idFCCalc)
      if (mOp.NotEqual(idFCCalc.get(),"")) {
        m$.Cmd.Do("COMUtils.KILL","WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idFCCalc.get()));
      }
      //<< 
      //<< set idRateCalc=$$GetCalcIndex(pidClass,strRateName)
      idRateCalc.set(m$.fnc$("GetCalcIndex",pidClass.get(),strRateName.get()));
      //<< if idRateCalc'="" do KILL^COMUtils("WWW003Calc",pidClass_","_idRateCalc)
      if (mOp.NotEqual(idRateCalc.get(),"")) {
        m$.Cmd.Do("COMUtils.KILL","WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idRateCalc.get()));
      }
      //<< 
      //<< set idCurCalc=$$GetCalcIndex(pidClass,strCurName)
      idCurCalc.set(m$.fnc$("GetCalcIndex",pidClass.get(),strCurName.get()));
      //<< if idCurCalc'="" do KILL^COMUtils("WWW003Calc",pidClass_","_idCurCalc)
      if (mOp.NotEqual(idCurCalc.get(),"")) {
        m$.Cmd.Do("COMUtils.KILL","WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idCurCalc.get()));
      }
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AddBaseCalcField(pidClass,pstrRealName,pstrPropName)
  public Object AddBaseCalcField(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrRealName = m$.newVarRef("pstrRealName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrPropName = m$.newVarRef("pstrPropName",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add the "BASE" calculated field to a class
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Jun-2006   RPW     SRBR014013: Added pstrPropName as pstrRealName
    //<< ; 22-Jul-2005   SteveS  SR13059: Use GetCalcIndex, do not use an index
    //<< ; 07-Jul-2005   SteveS  SR12854: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCalc,objCalc,strNewName
    mVar idCalc = m$.var("idCalc");
    mVar objCalc = m$.var("objCalc");
    mVar strNewName = m$.var("strNewName");
    m$.newVar(idCalc,objCalc,strNewName);
    //<< 
    //<< if (pidClass'="") && (pstrPropName'="") {
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(pstrPropName.get(),""))) {
      //<< set strNewName = pstrPropName_$$$BASESTRING     // SRBR014013
      strNewName.set(mOp.Concat(pstrPropName.get(),$$$BASESTRING(m$)));
      //<< 
      //<< set idCalc = $$GetCalcIndex(pidClass,strNewName)
      idCalc.set(m$.fnc$("GetCalcIndex",pidClass.get(),strNewName.get()));
      //<< 
      //<< if idCalc="" { ;Create new
      if (mOp.Equal(idCalc.get(),"")) {
        //<< set idCalc  = $order(^WWW003Calc(0,pidClass,""),-1)+1
        idCalc.set(mOp.Add(m$.Fnc.$order(m$.var("^WWW003Calc",0,pidClass.get(),""),mOp.Negative(1)),1));
        //<< set objCalc = ""
        objCalc.set("");
        //<< 
        //<< set $$$WWW003CalcFieldName(objCalc)     = strNewName
        include.WWWConst.$$$WWW003CalcFieldNameSet(m$,objCalc,strNewName.get());
        //<< set $$$WWW003CalcCode(objCalc)          = "$$FCBase^COMSYSFC({"_pstrRealName_"})" // BR014013
        include.WWWConst.$$$WWW003CalcCodeSet(m$,objCalc,mOp.Concat(mOp.Concat("$$FCBase^COMSYSFC({",pstrRealName.get()),"})"));
        //<< set $$$WWW003CalcDataType(objCalc)      = "%Float"
        include.WWWConst.$$$WWW003CalcDataTypeSet(m$,objCalc,"%Float");
        //<< set $$$WWW003CalcAutoGenerated(objCalc) = $$$YES
        include.WWWConst.$$$WWW003CalcAutoGeneratedSet(m$,objCalc,include.COMSYS.$$$YES(m$));
        //<< set $$$WWW003CalcCaption(objCalc)       = strNewName
        include.WWWConst.$$$WWW003CalcCaptionSet(m$,objCalc,strNewName.get());
        //<< set $$$WWW003CalcComment(objCalc)       = $$$AUTOGEN
        include.WWWConst.$$$WWW003CalcCommentSet(m$,objCalc,$$$AUTOGEN(m$));
        //<< 
        //<< do Save^COMUtils("WWW003Calc",pidClass_","_idCalc,objCalc,1)
        m$.Cmd.Do("COMUtils.Save","WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idCalc.get()),objCalc.get(),1);
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AddFCCalcFields(pidClass,pstrRealName,pstrPropName)
  public Object AddFCCalcFields(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrRealName = m$.newVarRef("pstrRealName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrPropName = m$.newVarRef("pstrPropName",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add the FC calculated field to a class
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Jun-2006   SteveS  SRBR014013: (Peer Review) Use pstrRealName
    //<< ; 20-Jun-2006   RPW     SRBR014013: Added pstrPropName as pstrRealName
    //<< ; 22-Jul-2005   SteveS  SR13059: Use GetCalcIndex, do not use an index
    //<< ; 07-Jul-2005   SteveS  SR12854: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objProperty,strFCName,strRateName,strCurName
    mVar objProperty = m$.var("objProperty");
    mVar strFCName = m$.var("strFCName");
    mVar strRateName = m$.var("strRateName");
    mVar strCurName = m$.var("strCurName");
    m$.newVar(objProperty,strFCName,strRateName,strCurName);
    //<< new idFCCalc,objFCCalc,idRateCalc,objRateCalc,objFCName,idFCName
    mVar idFCCalc = m$.var("idFCCalc");
    mVar objFCCalc = m$.var("objFCCalc");
    mVar idRateCalc = m$.var("idRateCalc");
    mVar objRateCalc = m$.var("objRateCalc");
    mVar objFCName = m$.var("objFCName");
    mVar idFCName = m$.var("idFCName");
    m$.newVar(idFCCalc,objFCCalc,idRateCalc,objRateCalc,objFCName,idFCName);
    //<< 
    //<< if (pidClass'="") && (pstrPropName'="") {
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(pstrPropName.get(),""))) {
      //<< set strFCName   = pstrPropName_$$$FCSTRING    // SRBR014013
      strFCName.set(mOp.Concat(pstrPropName.get(),$$$FCSTRING(m$)));
      //<< set strRateName = pstrPropName_$$$RATESTRING  // SRBR014013
      strRateName.set(mOp.Concat(pstrPropName.get(),$$$RATESTRING(m$)));
      //<< set strCurName  = pstrPropName_$$$CURSTRING   // SRBR014013
      strCurName.set(mOp.Concat(pstrPropName.get(),$$$CURSTRING(m$)));
      //<< 
      //<< ; Store FC Amount
      //<< set idFCCalc = $$GetCalcIndex(pidClass,strFCName)
      idFCCalc.set(m$.fnc$("GetCalcIndex",pidClass.get(),strFCName.get()));
      //<< if idFCCalc="" {
      if (mOp.Equal(idFCCalc.get(),"")) {
        //<< set idFCCalc = $order(^WWW003Calc(0,pidClass,""),-1)+1
        idFCCalc.set(mOp.Add(m$.Fnc.$order(m$.var("^WWW003Calc",0,pidClass.get(),""),mOp.Negative(1)),1));
        //<< set objFCCalc = ""
        objFCCalc.set("");
        //<< 
        //<< set $$$WWW003CalcFieldName(objFCCalc)     = strFCName
        include.WWWConst.$$$WWW003CalcFieldNameSet(m$,objFCCalc,strFCName.get());
        //<< set $$$WWW003CalcCode(objFCCalc)          = "$$FCAmount^COMSYSFC({"_pstrRealName_"})" // SRBR014013
        include.WWWConst.$$$WWW003CalcCodeSet(m$,objFCCalc,mOp.Concat(mOp.Concat("$$FCAmount^COMSYSFC({",pstrRealName.get()),"})"));
        //<< set $$$WWW003CalcDataType(objFCCalc)      = "%Float"
        include.WWWConst.$$$WWW003CalcDataTypeSet(m$,objFCCalc,"%Float");
        //<< set $$$WWW003CalcAutoGenerated(objFCCalc) = $$$YES
        include.WWWConst.$$$WWW003CalcAutoGeneratedSet(m$,objFCCalc,include.COMSYS.$$$YES(m$));
        //<< set $$$WWW003CalcCaption(objFCCalc)       = strFCName
        include.WWWConst.$$$WWW003CalcCaptionSet(m$,objFCCalc,strFCName.get());
        //<< set $$$WWW003CalcComment(objFCCalc)       = $$$AUTOGEN
        include.WWWConst.$$$WWW003CalcCommentSet(m$,objFCCalc,$$$AUTOGEN(m$));
        //<< 
        //<< do Save^COMUtils("WWW003Calc",pidClass_","_idFCCalc,objFCCalc,1)
        m$.Cmd.Do("COMUtils.Save","WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idFCCalc.get()),objFCCalc.get(),1);
      }
      //<< }
      //<< 
      //<< ;Store FC Rate
      //<< set idRateCalc = $$GetCalcIndex(pidClass,strRateName)
      idRateCalc.set(m$.fnc$("GetCalcIndex",pidClass.get(),strRateName.get()));
      //<< if idRateCalc="" {
      if (mOp.Equal(idRateCalc.get(),"")) {
        //<< set idRateCalc  = $order(^WWW003Calc(0,pidClass,""),-1)+1
        idRateCalc.set(mOp.Add(m$.Fnc.$order(m$.var("^WWW003Calc",0,pidClass.get(),""),mOp.Negative(1)),1));
        //<< set objRateCalc = ""
        objRateCalc.set("");
        //<< 
        //<< set $$$WWW003CalcFieldName(objRateCalc)     = strRateName
        include.WWWConst.$$$WWW003CalcFieldNameSet(m$,objRateCalc,strRateName.get());
        //<< set $$$WWW003CalcCode(objRateCalc)          = "$$FCRate^COMSYSFC({"_pstrRealName_"})"
        include.WWWConst.$$$WWW003CalcCodeSet(m$,objRateCalc,mOp.Concat(mOp.Concat("$$FCRate^COMSYSFC({",pstrRealName.get()),"})"));
        //<< set $$$WWW003CalcDataType(objRateCalc)      = "%Float"
        include.WWWConst.$$$WWW003CalcDataTypeSet(m$,objRateCalc,"%Float");
        //<< set $$$WWW003CalcAutoGenerated(objRateCalc) = $$$YES
        include.WWWConst.$$$WWW003CalcAutoGeneratedSet(m$,objRateCalc,include.COMSYS.$$$YES(m$));
        //<< set $$$WWW003CalcCaption(objRateCalc)       = strRateName
        include.WWWConst.$$$WWW003CalcCaptionSet(m$,objRateCalc,strRateName.get());
        //<< set $$$WWW003CalcComment(objRateCalc)       = $$$AUTOGEN
        include.WWWConst.$$$WWW003CalcCommentSet(m$,objRateCalc,$$$AUTOGEN(m$));
        //<< 
        //<< do Save^COMUtils("WWW003Calc",pidClass_","_idRateCalc,objRateCalc,1)
        m$.Cmd.Do("COMUtils.Save","WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idRateCalc.get()),objRateCalc.get(),1);
      }
      //<< }
      //<< 
      //<< ;Store FC Name
      //<< set idFCName = $$GetCalcIndex(pidClass,strCurName)
      idFCName.set(m$.fnc$("GetCalcIndex",pidClass.get(),strCurName.get()));
      //<< if idFCName="" {
      if (mOp.Equal(idFCName.get(),"")) {
        //<< set idFCName  = $order(^WWW003Calc(0,pidClass,""),-1)+1
        idFCName.set(mOp.Add(m$.Fnc.$order(m$.var("^WWW003Calc",0,pidClass.get(),""),mOp.Negative(1)),1));
        //<< set objFCName = ""
        objFCName.set("");
        //<< 
        //<< set $$$WWW003CalcFieldName(objFCName)     = strCurName
        include.WWWConst.$$$WWW003CalcFieldNameSet(m$,objFCName,strCurName.get());
        //<< set $$$WWW003CalcCode(objFCName)          = "$$Cur^COMSYSFC({"_pstrRealName_"})"
        include.WWWConst.$$$WWW003CalcCodeSet(m$,objFCName,mOp.Concat(mOp.Concat("$$Cur^COMSYSFC({",pstrRealName.get()),"})"));
        //<< set $$$WWW003CalcDataType(objFCName)      = "%String"
        include.WWWConst.$$$WWW003CalcDataTypeSet(m$,objFCName,"%String");
        //<< set $$$WWW003CalcAutoGenerated(objFCName) = $$$YES
        include.WWWConst.$$$WWW003CalcAutoGeneratedSet(m$,objFCName,include.COMSYS.$$$YES(m$));
        //<< set $$$WWW003CalcCaption(objFCName)       = strCurName
        include.WWWConst.$$$WWW003CalcCaptionSet(m$,objFCName,strCurName.get());
        //<< set $$$WWW003CalcComment(objFCName)       = $$$AUTOGEN
        include.WWWConst.$$$WWW003CalcCommentSet(m$,objFCName,$$$AUTOGEN(m$));
        //<< 
        //<< do Save^COMUtils("WWW003Calc",pidClass_","_idFCName,objFCName,1)
        m$.Cmd.Do("COMUtils.Save","WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idFCName.get()),objFCName.get(),1);
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ShowCalcFields(pidClass="")
  public Object ShowCalcFields(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the calc fields for a class
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jul-2005   SteveS  SR12854: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHeader,lstHeader,idProp,objCalcProp
    mVar strHeader = m$.var("strHeader");
    mVar lstHeader = m$.var("lstHeader");
    mVar idProp = m$.var("idProp");
    mVar objCalcProp = m$.var("objCalcProp");
    m$.newVar(strHeader,lstHeader,idProp,objCalcProp);
    //<< 
    //<< if (pidClass'="") && ($data(^WWW003Calc(0,pidClass))) {
    if ((mOp.NotEqual(pidClass.get(),"")) && mOp.Logical((m$.Fnc.$data(m$.var("^WWW003Calc",0,pidClass.get()))))) {
      //<< set strHeader = $listbuild("WWW00026")  ;Calculated fields
      strHeader.set(m$.Fnc.$listbuild("WWW00026"));
      //<< 
      //<< set lstHeader = ""
      lstHeader.set("");
      //<< set lstHeader = lstHeader_$listbuild($$$StrWWW003CalcPropertyNumber)
      lstHeader.set(mOp.Concat(lstHeader.get(),m$.Fnc.$listbuild(include.WWWConst.$$$StrWWW003CalcPropertyNumber(m$))));
      //<< set lstHeader = lstHeader_$listbuild($$$StrWWW003CalcFieldName)
      lstHeader.set(mOp.Concat(lstHeader.get(),m$.Fnc.$listbuild(include.WWWConst.$$$StrWWW003CalcFieldName(m$))));
      //<< set lstHeader = lstHeader_$listbuild($$$StrWWW003CalcDataType)
      lstHeader.set(mOp.Concat(lstHeader.get(),m$.Fnc.$listbuild(include.WWWConst.$$$StrWWW003CalcDataType(m$))));
      //<< set lstHeader = lstHeader_$listbuild($$$StrWWW003CalcCode)
      lstHeader.set(mOp.Concat(lstHeader.get(),m$.Fnc.$listbuild(include.WWWConst.$$$StrWWW003CalcCode(m$))));
      //<< set lstHeader = lstHeader_$listbuild($$$StrWWW003CalcAutoGenerated)
      lstHeader.set(mOp.Concat(lstHeader.get(),m$.Fnc.$listbuild(include.WWWConst.$$$StrWWW003CalcAutoGenerated(m$))));
      //<< 
      //<< do Start^COMTable(lstHeader,strHeader)
      m$.Cmd.Do("COMTable.Start",lstHeader.get(),strHeader.get());
      //<< 
      //<< set idProp=""
      idProp.set("");
      //<< 
      //<< for {
      for (;true;) {
        //<< set idProp=$order(^WWW003Calc(0,pidClass,idProp))
        idProp.set(m$.Fnc.$order(m$.var("^WWW003Calc",0,pidClass.get(),idProp.get())));
        //<< quit:idProp=""
        if (mOp.Equal(idProp.get(),"")) {
          break;
        }
        //<< 
        //<< set objCalcProp=$get(^WWW003Calc(0,pidClass,idProp,1))
        objCalcProp.set(m$.Fnc.$get(m$.var("^WWW003Calc",0,pidClass.get(),idProp.get(),1)));
        //<< 
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< 
        //<< do InsertCell^COMTable(idProp,                             "WWW003Calc",pidClass_","_idProp)
        m$.Cmd.Do("COMTable.InsertCell",idProp.get(),"WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idProp.get()));
        //<< do InsertCell^COMTable($$$WWW003CalcFieldName(objCalcProp),"WWW003Calc",pidClass_","_idProp)
        m$.Cmd.Do("COMTable.InsertCell",include.WWWConst.$$$WWW003CalcFieldName(m$,objCalcProp),"WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idProp.get()));
        //<< do InsertCell^COMTable($$$WWW003CalcDataType(objCalcProp), "WWW003Calc",pidClass_","_idProp)
        m$.Cmd.Do("COMTable.InsertCell",include.WWWConst.$$$WWW003CalcDataType(m$,objCalcProp),"WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idProp.get()));
        //<< do InsertCell^COMTable($$$WWW003CalcCode(objCalcProp),     "WWW003Calc",pidClass_","_idProp)
        m$.Cmd.Do("COMTable.InsertCell",include.WWWConst.$$$WWW003CalcCode(m$,objCalcProp),"WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idProp.get()));
        //<< do InsertCell^COMTable($$$SysEnum("JA/NEIN",+$$$WWW003CalcAutoGenerated(objCalcProp)),"WWW003Calc",pidClass_","_idProp)
        m$.Cmd.Do("COMTable.InsertCell",include.COMSYSWWW.$$$SysEnum(m$,"JA/NEIN",mOp.Positive(include.WWWConst.$$$WWW003CalcAutoGenerated(m$,objCalcProp))),"WWW003Calc",mOp.Concat(mOp.Concat(pidClass.get(),","),idProp.get()));
        //<< 
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
      }
      //<< }
      //<< 
      //<< do Stop^COMTable()
      m$.Cmd.Do("COMTable.Stop");
    }
    //<< 
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetParamString(pstrCode="")
  public Object GetParamString(Object ... _p) {
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Given a Caché callback for a calculated field, return a comma-delimited
    //<< ; list of the parameters required.
    //<< ;
    //<< ; NOTE: Cannot simply check for Tag^Routine({param_1},...,{param_n}) syntax, since
    //<< ; we may have a combination of intrinsic/extrinsic function calls which don't
    //<< ; necessarily follow this syntax.
    //<< ;
    //<< ; Params: pstrCode  - The Caché callback
    //<< ;
    //<< ; Returns: string
    //<< ;
    //<< ; History:
    //<< ; 03-Jan-2006   SteveS  SR14116: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ; e.g. ^WWW003Calc(0,"INWEAUF",16,1) : pstrCode = $$SupplierDetail^INRPAUF({Company},{OrderSupplier},8)
    //<< ;      Returns strParams = {Company},{OrderSupplier}
    //<< ;---------------------------------------
    //<< new strParams,idx,subIdx,strName
    mVar strParams = m$.var("strParams");
    mVar idx = m$.var("idx");
    mVar subIdx = m$.var("subIdx");
    mVar strName = m$.var("strName");
    m$.newVar(strParams,idx,subIdx,strName);
    //<< 
    //<< set strParams=""
    strParams.set("");
    //<< 
    //<< for idx=1:1:$length(pstrCode) {
    for (idx.set(1);(mOp.LessOrEqual(idx.get(),m$.Fnc.$length(pstrCode.get())));idx.set(mOp.Add(idx.get(),1))) {
      //<< if $extract(pstrCode,idx)="{" {               //found opening
      if (mOp.Equal(m$.Fnc.$extract(pstrCode.get(),idx.get()),"{")) {
        //<< set subIdx = idx
        subIdx.set(idx.get());
        //<< while ($extract(pstrCode,subIdx)'="}") {  //find ending
        while ((mOp.NotEqual(m$.Fnc.$extract(pstrCode.get(),subIdx.get()),"}"))) {
          //<< set subIdx = subIdx+1
          subIdx.set(mOp.Add(subIdx.get(),1));
        }
        //<< }
        //<< 
        //<< set strName = $extract(pstrCode,idx,subIdx)
        strName.set(m$.Fnc.$extract(pstrCode.get(),idx.get(),subIdx.get()));
        //<< 
        //<< if '$find(strParams,strName) {
        if (mOp.Not(m$.Fnc.$find(strParams.get(),strName.get()))) {
          //<< if strParams="" {
          if (mOp.Equal(strParams.get(),"")) {
            //<< set strParams = strName
            strParams.set(strName.get());
          }
          //<< } else {
          else {
            //<< set strParams = strParams_","_strName
            strParams.set(mOp.Concat(mOp.Concat(strParams.get(),","),strName.get()));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit strParams
    return strParams.get();
  }

  //<< 
  //<< 
  //<< GetCalculatedValue(pidClass,pidField,pidKey,pobjRef)
  public Object GetCalculatedValue(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pobjRef = m$.newVarRef("pobjRef",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the value of a calculated field - Filter type "C"
    //<< ;
    //<< ; Params:
    //<< ; pinRow (added)        : The row number to be displayed
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Aug-2006   RPW         SR14896: No longer need the result set
    //<< ; 27-Apr-2006   JW          SR14423: Convert date for calc fields.
    //<< ; 19-Apr-2006   JW          SR14429: Added pobjResult param
    //<< ; 03-Jan-2006   Steve S     SR14116: Use $$GetParamString^WWW001CalcFields
    //<< ; 23-Sep-2005   shobby      SR13213: Company is a special case of a property.
    //<< ;                               (Implicitly defined primary key)
    //<< ; 22-Sep-2005   shobby      SR13213: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strValue,objWWW003Calc,idField,strCode,strParameters,strParameter,idxParameter
    mVar strValue = m$.var("strValue");
    mVar objWWW003Calc = m$.var("objWWW003Calc");
    mVar idField = m$.var("idField");
    mVar strCode = m$.var("strCode");
    mVar strParameters = m$.var("strParameters");
    mVar strParameter = m$.var("strParameter");
    mVar idxParameter = m$.var("idxParameter");
    m$.newVar(strValue,objWWW003Calc,idField,strCode,strParameters,strParameter,idxParameter);
    //<< new idClass,idPiece,strData,idxstrParameter
    mVar idClass = m$.var("idClass");
    mVar idPiece = m$.var("idPiece");
    mVar strData = m$.var("strData");
    mVar idxstrParameter = m$.var("idxstrParameter");
    m$.newVar(idClass,idPiece,strData,idxstrParameter);
    //<< 
    //<< set strValue=""
    strValue.set("");
    //<< set idClass=$$$Index(pidClass)
    idClass.set(include.MEDConst.$$$Index(m$,pidClass));
    //<< set idField=$extract(pidField,2,99)
    idField.set(m$.Fnc.$extract(pidField.get(),2,99));
    //<< 
    //<< if (pidClass'="")&&(pidField'="") {
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(pidField.get(),""))) {
      //<< set objWWW003Calc=$get(^WWW003Calc(0,pidClass,idField,1))
      objWWW003Calc.set(m$.Fnc.$get(m$.var("^WWW003Calc",0,pidClass.get(),idField.get(),1)));
      //<< set strCode=$$$WWW003CalcCode(objWWW003Calc)
      strCode.set(include.WWWConst.$$$WWW003CalcCode(m$,objWWW003Calc));
      //<< if strCode'="" {
      if (mOp.NotEqual(strCode.get(),"")) {
        //<< set strParameters=$$GetParamString^WWW001CalcFields(strCode)
        strParameters.set(m$.fnc$("WWW001CalcFields.GetParamString",strCode.get()));
        //<< set strParameter=""
        strParameter.set("");
        //<< for idxParameter=2:1:$length(strParameters,"{") {
        for (idxParameter.set(2);(mOp.LessOrEqual(idxParameter.get(),m$.Fnc.$length(strParameters.get(),"{")));idxParameter.set(mOp.Add(idxParameter.get(),1))) {
          //<< set strParameter=$piece($piece(strParameters,"{",idxParameter),"}",1)
          strParameter.set(m$.Fnc.$piece(m$.Fnc.$piece(strParameters.get(),"{",idxParameter.get()),"}",1));
          //<< 
          //<< if strParameter="Company" {
          if (mOp.Equal(strParameter.get(),"Company")) {
            //<< set strData=YM
            strData.set(m$.var("YM").get());
          }
          //<< 
          //<< } else {
          else {
            //<< set idxstrParameter=$$$Index(strParameter)
            idxstrParameter.set(include.MEDConst.$$$Index(m$,strParameter));
            //<< set idPiece=$order(^WWW002s(0,3,idClass,idxstrParameter,pidClass,""))
            idPiece.set(m$.Fnc.$order(m$.var("^WWW002s",0,3,idClass.get(),idxstrParameter.get(),pidClass.get(),"")));
            //<< if idPiece'="" {
            if (mOp.NotEqual(idPiece.get(),"")) {
              //<< set strData=$piece(pidKey,",",idPiece)
              strData.set(m$.Fnc.$piece(pidKey.get(),",",idPiece.get()));
            }
            //<< } else {
            else {
              //<< set idPiece=$order(^WWW003s(0,3,idClass,idxstrParameter,pidClass,""))
              idPiece.set(m$.Fnc.$order(m$.var("^WWW003s",0,3,idClass.get(),idxstrParameter.get(),pidClass.get(),"")));
              //<< if idPiece'="" {
              if (mOp.NotEqual(idPiece.get(),"")) {
                //<< set strData=$piece(pobjRef,Y,idPiece)
                strData.set(m$.Fnc.$piece(pobjRef.get(),m$.var("Y").get(),idPiece.get()));
              }
            }
          }
          //<< }
          //<< }
          //<< }
          //<< set strCode=$$Replace^COMUtilStr(strCode,"{"_strParameter_"}",""""_strData_"""")
          strCode.set(m$.fnc$("COMUtilStr.Replace",strCode.get(),mOp.Concat(mOp.Concat("{",strParameter.get()),"}"),mOp.Concat(mOp.Concat("\"",strData.get()),"\"")));
        }
        //<< }
        //<< xecute "set strValue="_strCode
        m$.Cmd.Xecute(mOp.Concat("set strValue=",strCode.get()));
        //<< write !,strCode_"="_$get(strValue)
        m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(strCode.get(),"="),m$.Fnc.$get(strValue)));
      }
      //<< }
      //<< if $$$WWW003CalcDataType(objWWW003Calc)="%Date" {
      if (mOp.Equal(include.WWWConst.$$$WWW003CalcDataType(m$,objWWW003Calc),"%Date")) {
        //<< set strValue = $$$FormatDate(strValue)
        strValue.set(include.COMSYSWWW.$$$FormatDate(m$,strValue));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strValue
    return strValue.get();
  }

//<< 
//<< 
}
