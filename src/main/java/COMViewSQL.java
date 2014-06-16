//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewSQL
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-16 12:56:11
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; Code generating/supporting SQL strings.
//<< ;-------------------------------------------------------------------------------
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;
//<< #include COMConst
import include.COMConst;
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
//<< #include COMView
import include.COMView;

//<< COMViewSQL
public class COMViewSQL extends mClass {

  //<< 
  //<< #define Where(%1)       $select($increment(%1)=1:"where ",1:" and ")
  public static Object $$$Where(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Equal(m$.Fnc.$increment(p$1),1),"where ",1," and "));
  }

  //<< #define MapAccentMark   +$$$COMViewConfigMapAccentMark($get(^COMViewConfig(0,YM,1)))
  public static Object $$$MapAccentMark(mContext m$) {
    return (mOp.Positive(include.COMConst.$$$COMViewConfigMapAccentMark(m$,m$.Fnc.$get(m$.var("^COMViewConfig",0,m$.var("YM").get(),1)))));
  }

  public void main() {
    _COMViewSQL();
  }

  public void _COMViewSQL() {
  }

  //<< 
  //<< GenerateSQLForFilter(pidClass,pidField="")
  public Object GenerateSQLForFilter(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; This procedure generates an SQL string that can then be used by GenerateSQL as a filter
    //<< ;
    //<< ; Params: Class and Field ID
    //<< ;
    //<< ; Returns: An SQL string
    //<< ;
    //<< ; History:
    //<< ; 04-Sep-2006   RPW     SR15005: Incidental to SR, removed ^COMViewSQL from
    //<< ;                           GenerateSQL call
    //<< ; 22-Jun-2006   Pablo   SR14221: Removed hard coding 'User' package
    //<< ; 20-Jul-2005   PO      SR12682: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strSQL
    mVar strSQL = m$.var("strSQL");
    m$.newVar(strSQL);
    //<< 
    //<< set strSQL = ""
    strSQL.set("");
    //<< 
    //<< kill ^CacheTempView(YUSER)
    m$.var("^CacheTempView",m$.var("YUSER").get()).kill();
    //<< merge ^CacheTempView(YUSER) = ^CacheTempFixedField(YUSER,$get(^CacheTempFixedField(YUSER,"CurrentField")," "))
    m$.Cmd.Merge(m$.var("^CacheTempView",m$.var("YUSER").get()),m$.var("^CacheTempFixedField",m$.var("YUSER").get(),m$.Fnc.$get(m$.var("^CacheTempFixedField",m$.var("YUSER").get(),"CurrentField")," ")));
    //<< 
    //<< if $get(pidClass)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidClass),"")) {
      //<< set strSQL = $translate($$GenerateSQL(pidClass,,,,,,pidField),"""","'")
      strSQL.set(m$.Fnc.$translate(m$.fnc$("GenerateSQL",pidClass.get(),null,null,null,null,null,pidField.get()),"\"","'"));
    }
    //<< }
    //<< quit strSQL
    return strSQL.get();
  }

  //<< 
  //<< 
  //<< GenerateSQL(pidClass,plstColumns="",pstrRef="",pblnGroupLevel=$$$NO,pstrSafeMode=$$$NO,
  //<< pblnSelectAll=$$$NO,pidField="",pintMaxCount=0,pblnInForm=$$$NO)
  public Object GenerateSQL(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar plstColumns = m$.newVarRef("plstColumns",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrRef = m$.newVarRef("pstrRef",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnGroupLevel = m$.newVarRef("pblnGroupLevel",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    mVar pstrSafeMode = m$.newVarRef("pstrSafeMode",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    mVar pblnSelectAll = m$.newVarRef("pblnSelectAll",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$NO(m$));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    mVar pintMaxCount = m$.newVarRef("pintMaxCount",(((_p!=null)&&(_p.length>=8))?_p[7]:null),0);
    mVar pblnInForm = m$.newVarRef("pblnInForm",(((_p!=null)&&(_p.length>=9))?_p[8]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Generates a String of SQL code to passed into the result set. based
    //<< ; on fixed primary keys,readonly hidden filters and user filters.
    //<< ;
    //<< ; Params:   pintMaxCount - what is the maximum count of rows, 0 = all
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 04-Oct-2012   shobby  SR18119: Bug in 'between' search.
    //<< ; 08-Sep-2010   shobby  SR17346: Removed $$Index from startswith and contains.
    //<< ; 12-May-2010   shobby  SR17283: strValue may be changed in call to ConvertField
    //<< ; 03-Mar-2010   GRF     SR17214: $$$EnumCOMVIEWCOMPARATORWithin - Remove
    //<< ;                           duplicated call to WWWKEYBUILD from SR17023; Test
    //<< ;                           for SQL query rather than actual values in strValue;
    //<< ;                           Commented code cleanup; if + if not merged into if/else
    //<< ; 08-Dec-2009   shobby  SR17075: Call out to OnBeforeSQL
    //<< ; 11-Nov-2009   PPP     SR17023: When creating SQL, check if the property class
    //<< ;                           is serial to use _ (underscore)
    //<< ; 15-Oct-2009   shobby  SR16944: Corrected an issue where strField variable was
    //<< ;                           used incorrectly, should have been strProperty.
    //<< ; 28-Sep-2009   shobby  SR16708: Reworked how the condition of the SQL is
    //<< ;                           created to allow for 'or' conditions when a value
    //<< ;                           such as a barcode is translated to an item number
    //<< ;                           but we also want to return item numbers that match
    //<< ;                           the actual entered text.
    //<< ; 10-Feb-2009   shobby  SR16126: Made previous change optional based on a
    //<< ;                           company parameter.
    //<< ; 12-Nov-2008   shobby  SR16126: Simulate commas in a primary key.
    //<< ; 07-Oct-2008   PPP     SR15960: Updated Column Heading to include Parent Field.
    //<< ; 02-Oct-2008   HQN     SR15915: Correcting cases which do null value comparisons
    //<< ;                           SQL building logic moved from ConvertField into here.
    //<< ; 26-Sep-2008   shobby  SRBR014982: Include the 'within' selection criteria on
    //<< ;                           all texts (not just those with a relationship to
    //<< ;                           another class)
    //<< ; 09-Sep-2008   PP      SR15866:Update COMView to Objects
    //<< ; 20-Feb-2008   shobby  SRBR014900: RelationFilter
    //<< ; 29-Jan-2008   shobby  SRBR014551: Support direct SQL
    //<< ; 13-Mar-2007   HeberB  BR014367: Translate to characters with no accent mark
    //<< ; 09-Feb-2007   RPW     SR15426: If we are in form only order in one direction
    //<< ;                           and by the last primary key
    //<< ; 25-Oct-2006   RPW     SR14709: Removed #define and modified $$$Where calls
    //<< ; 04-Sep-2006   RPW     SR15005: Limit the count if pintMaxCount<>0 and added
    //<< ;                           pintMaxCount, removed all code in regards to
    //<< ;                           pblnNewWhere as this is no longer needed.
    //<< ; 29-Aug-2006   JW      SR14763: Added pblnNewWhere to encapsulate keeping the
    //<< ;                           last where clause
    //<< ; 19-Jul-2006   JW      SR14832: Support 'between' clause
    //<< ; 22-Jun-2006   Pablo   SR14221: Removed hard coding 'User' package
    //<< ; 29-May-2006   Steve S SR14675: Support 'like' clause
    //<< ; 19-Apr-2006   JW      SR14429: Support for views
    //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
    //<< ; 20-Jul-2005   PO      SR12682: Made which value is selected in the SQL
    //<< ;                           statement configurable ie. no longer hard coded to
    //<< ;                           always include the SQL key "ID", also not converting
    //<< ;                           values that are flagged to not be converted.
    //<< ; 11-Mar-2004   Paul K  Fixed for groups. (SR#11478)
    //<< ; 30-Nov-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new ClassLoop,FieldLoop,FilterLoop,ValueLoop,pstrExecute
    mVar ClassLoop = m$.var("ClassLoop");
    mVar FieldLoop = m$.var("FieldLoop");
    mVar FilterLoop = m$.var("FilterLoop");
    mVar ValueLoop = m$.var("ValueLoop");
    mVar pstrExecute = m$.var("pstrExecute");
    m$.newVar(ClassLoop,FieldLoop,FilterLoop,ValueLoop,pstrExecute);
    //<< ; FIXME : names too similar
    //<< ;         strField/strFieldN,
    //<< ;         idClass/idClassN,
    //<< ;         strProperty/strProperties,
    //<< ;         strFilterType/strFilterTypes
    //<< new blnNoConversion,blnObj,blnWhereUsed,idClass,idClassN,idFieldClass
    mVar blnNoConversion = m$.var("blnNoConversion");
    mVar blnObj = m$.var("blnObj");
    mVar blnWhereUsed = m$.var("blnWhereUsed");
    mVar idClass = m$.var("idClass");
    mVar idClassN = m$.var("idClassN");
    mVar idFieldClass = m$.var("idFieldClass");
    m$.newVar(blnNoConversion,blnObj,blnWhereUsed,idClass,idClassN,idFieldClass);
    //<< new idFilter,idFirstField,idKey,idLastField,idOrigField,idSortField,idSortFieldClass
    mVar idFilter = m$.var("idFilter");
    mVar idFirstField = m$.var("idFirstField");
    mVar idKey = m$.var("idKey");
    mVar idLastField = m$.var("idLastField");
    mVar idOrigField = m$.var("idOrigField");
    mVar idSortField = m$.var("idSortField");
    mVar idSortFieldClass = m$.var("idSortFieldClass");
    m$.newVar(idFilter,idFirstField,idKey,idLastField,idOrigField,idSortField,idSortFieldClass);
    //<< new intType,loop,lstClasses,lstProps,objCompiledClass,objFilter
    mVar intType = m$.var("intType");
    mVar loop = m$.var("loop");
    mVar lstClasses = m$.var("lstClasses");
    mVar lstProps = m$.var("lstProps");
    mVar objCompiledClass = m$.var("objCompiledClass");
    mVar objFilter = m$.var("objFilter");
    m$.newVar(intType,loop,lstClasses,lstProps,objCompiledClass,objFilter);
    //<< new strAddField,strClasses,strComp,strCondition,strDirection,strField
    mVar strAddField = m$.var("strAddField");
    mVar strClasses = m$.var("strClasses");
    mVar strComp = m$.var("strComp");
    mVar strCondition = m$.var("strCondition");
    mVar strDirection = m$.var("strDirection");
    mVar strField = m$.var("strField");
    m$.newVar(strAddField,strClasses,strComp,strCondition,strDirection,strField);
    //<< new strFieldDesc,strFieldN,strFilterType,strFilterTypes
    mVar strFieldDesc = m$.var("strFieldDesc");
    mVar strFieldN = m$.var("strFieldN");
    mVar strFilterType = m$.var("strFilterType");
    mVar strFilterTypes = m$.var("strFilterTypes");
    m$.newVar(strFieldDesc,strFieldN,strFilterType,strFilterTypes);
    //<< new strGroupBy,strGrpProperties,strProperty,strProperties,strRefValue
    mVar strGroupBy = m$.var("strGroupBy");
    mVar strGrpProperties = m$.var("strGrpProperties");
    mVar strProperty = m$.var("strProperty");
    mVar strProperties = m$.var("strProperties");
    mVar strRefValue = m$.var("strRefValue");
    m$.newVar(strGroupBy,strGrpProperties,strProperty,strProperties,strRefValue);
    //<< new strSelectProperties,strSQL,strTableName,strValue,strValue3,strWhere
    mVar strSelectProperties = m$.var("strSelectProperties");
    mVar strSQL = m$.var("strSQL");
    mVar strTableName = m$.var("strTableName");
    mVar strValue = m$.var("strValue");
    mVar strValue3 = m$.var("strValue3");
    mVar strWhere = m$.var("strWhere");
    m$.newVar(strSelectProperties,strSQL,strTableName,strValue,strValue3,strWhere);
    //<< 
    //<< set blnObj = +$get(^CacheTempObj(YUSER,"Object"))
    blnObj.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object"))));
    //<< set strSQL = $$GetCurrentSQL^COMView(pidClass)
    strSQL.set(m$.fnc$("COMView.GetCurrentSQL",pidClass.get()));
    //<< 
    //<< if strSQL="" {
    if (mOp.Equal(strSQL.get(),"")) {
      //<< set pintMaxCount = pintMaxCount+1
      pintMaxCount.set(mOp.Add(pintMaxCount.get(),1));
      //<< set blnWhereUsed = 0
      blnWhereUsed.set(0);
      //<< 
      //<< if pidField = "" {
      if (mOp.Equal(pidField.get(),"")) {
        //<< set pidField = "ID"
        pidField.set("ID");
      }
      //<< } else {
      else {
        //<< set pidField = $$$WWW002PropertyName($$GetRelation^COMViewUtils(pidClass,pidField))
        pidField.set(include.WWWConst.$$$WWW002PropertyName(m$,m$.fnc$("COMViewUtils.GetRelation",pidClass.get(),pidField.get())));
      }
      //<< }
      //<< set strGroupBy  = ""
      strGroupBy.set("");
      //<< set pstrExecute = ""     ; FIXME : Not used in this routine (byref elsewhere?) <GRF>
      pstrExecute.set("");
      //<< set lstProps    = ""
      lstProps.set("");
      //<< set lstClasses  = $listbuild($$SQLClass(pidClass))
      lstClasses.set(m$.Fnc.$listbuild(m$.fnc$("SQLClass",pidClass.get())));
      //<< 
      //<< set strSelectProperties = ""
      strSelectProperties.set("");
      //<< set strGrpProperties    = ""
      strGrpProperties.set("");
      //<< 
      //<< for FieldLoop=1:1:$listlength(plstColumns) {
      for (FieldLoop.set(1);(mOp.LessOrEqual(FieldLoop.get(),m$.Fnc.$listlength(plstColumns.get())));FieldLoop.set(mOp.Add(FieldLoop.get(),1))) {
        //<< set strField = $listget(plstColumns,FieldLoop)
        strField.set(m$.Fnc.$listget(plstColumns.get(),FieldLoop.get()));
        //<< kill ^CacheTempSQL($$$SQLID,"RelationFilter",strField)
        m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"RelationFilter",strField.get()).kill();
        //<< do ConvertField(pidClass,.strField,"","",.intType,pstrSafeMode)
        m$.Cmd.Do("ConvertField",pidClass.get(),strField,"","",intType,pstrSafeMode.get());
        //<< 
        //<< if 'blnObj {
        if (mOp.Not(blnObj.get())) {
          //<< if $find(",4,8,11,12,18,",","_intType_",") {
          if (mOp.Logical(m$.Fnc.$find(",4,8,11,12,18,",mOp.Concat(mOp.Concat(",",intType.get()),",")))) {
            //<< set strSelectProperties=strSelectProperties_",SUM("_strField_") AS "_$listget(plstColumns,FieldLoop)
            strSelectProperties.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strSelectProperties.get(),",SUM("),strField.get()),") AS "),m$.Fnc.$listget(plstColumns.get(),FieldLoop.get())));
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< set idOrigField  = $listget(plstColumns,FieldLoop)                       //Storage->Code
          idOrigField.set(m$.Fnc.$listget(plstColumns.get(),FieldLoop.get()));
          //<< set idFieldClass = $$GetClass^COMViewObject(pidClass,idOrigField)        //alLOC.dStorage
          idFieldClass.set(m$.fnc$("COMViewObject.GetClass",pidClass.get(),idOrigField.get()));
          //<< set idFirstField = $piece(idOrigField,"->")                              //Storage
          idFirstField.set(m$.Fnc.$piece(idOrigField.get(),"->"));
          //<< set idLastField  = $piece(idOrigField,"->",$length(idOrigField,"->"))    //Code
          idLastField.set(m$.Fnc.$piece(idOrigField.get(),"->",m$.Fnc.$length(idOrigField.get(),"->")));
          //<< set strFieldDesc = $translate(idOrigField,"->","_")         //15960
          strFieldDesc.set(m$.Fnc.$translate(idOrigField.get(),"->","_"));
          //<< 
          //<< //SR17023
          //<< if $$IsClassSerial^COMViewObject(idFieldClass) {
          if (mOp.Logical(m$.fnc$("COMViewObject.IsClassSerial",idFieldClass.get()))) {
            //<< set strField = $translate(strField,"->","_")
            strField.set(m$.Fnc.$translate(strField.get(),"->","_"));
          }
          //<< }
          //<< 
          //<< //Only if a relation class
          //<< if pidClass'=idFieldClass {
          if (mOp.NotEqual(pidClass.get(),idFieldClass.get())) {
            //<< set strAddField = $$GetRelation^COMViewObject(idFieldClass,idLastField)  //alLOC.dStorage,Code
            strAddField.set(m$.fnc$("COMViewObject.GetRelation",idFieldClass.get(),idLastField.get()));
            //<< if strAddField '= "" {
            if (mOp.NotEqual(strAddField.get(),"")) {
              //<< set strAddField = idFirstField_"->"_strAddField                      //Storage->Remarks
              strAddField.set(mOp.Concat(mOp.Concat(idFirstField.get(),"->"),strAddField.get()));
              //<< do ConvertField(pidClass,.strAddField,"","",.intType,pstrSafeMode)         //%upper(alSOH.dBundleStock.Storage->Remarks)
              m$.Cmd.Do("ConvertField",pidClass.get(),strAddField,"","",intType,pstrSafeMode.get());
              //<< set strField = strField _" || ' - ' || COALESCE("_ strAddField_","""")"    //%upper(alSOH.dBundleStock.Storage->Code) || '-' || %upper(alSOH.dBundleStock.Storage->Remarks)
              strField.set(mOp.Concat(mOp.Concat(mOp.Concat(strField.get()," || ' - ' || COALESCE("),strAddField.get()),",\"\")"));
            }
          }
          //<< }
          //<< }
          //<< 
          //<< if $find(",alSYS.dt.dtInteger,alSYS.dt.dtFloat,alSYS.dt.dtCurrency,",","_intType_",") {
          if (mOp.Logical(m$.Fnc.$find(",alSYS.dt.dtInteger,alSYS.dt.dtFloat,alSYS.dt.dtCurrency,",mOp.Concat(mOp.Concat(",",intType.get()),",")))) {
            //<< set strGrpProperties = strGrpProperties_", SUM("_strField_") AS "_strFieldDesc
            strGrpProperties.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strGrpProperties.get(),", SUM("),strField.get()),") AS "),strFieldDesc.get()));
          }
          //<< }  else {
          else {
            //<< set strGrpProperties = strGrpProperties_", "_strField_" AS "_strFieldDesc
            strGrpProperties.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strGrpProperties.get(),", "),strField.get())," AS "),strFieldDesc.get()));
          }
          //<< }
          //<< set strSelectProperties  = strSelectProperties_", "_strField_" AS "_strFieldDesc
          strSelectProperties.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strSelectProperties.get(),", "),strField.get())," AS "),strFieldDesc.get()));
        }
      }
      //<< }
      //<< }
      //<< if pidClass'="" {
      if (mOp.NotEqual(pidClass.get(),"")) {
        //<< set strTableName = pidClass
        strTableName.set(pidClass.get());
        //<< if ($length(strTableName, ".") > 1) {
        if ((mOp.Greater(m$.Fnc.$length(strTableName.get(),"."),1))) {
          //<< if ##Class(%Dictionary.CompiledClass).%ExistsId(strTableName) {
          if (mOp.Logical(m$.fnc$("$Dictionary.CompiledClass.$ExistsId",strTableName.get()))) {
            //<< set objCompiledClass = ##Class(%Dictionary.CompiledClass).%OpenId(strTableName)
            objCompiledClass.set(m$.fnc$("$Dictionary.CompiledClass.$OpenId",strTableName.get()));
            //<< set strTableName     = objCompiledClass.SqlSchemaName_"."_objCompiledClass.SqlTableName
            strTableName.set(mOp.Concat(mOp.Concat(m$.prop(objCompiledClass.get(),"SqlSchemaName").get(),"."),m$.prop(objCompiledClass.get(),"SqlTableName").get()));
            //<< do objCompiledClass.%Close()
            m$.Cmd.Do(objCompiledClass.getORef(),"$Close");
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if $get(^CacheTempView(YUSER,"View")) {
        if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"View")))) {
          //<< set strSQL = strSQL_"select * "
          strSQL.set(mOp.Concat(strSQL.get(),"select * "));
        }
        //<< } else {
        else {
          //<< if pintMaxCount>1 {
          if (mOp.Greater(pintMaxCount.get(),1)) {
            //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
            if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
              //<< set strSQL = strSQL_"select DISTINCT top "_pintMaxCount_" %upper("_strTableName_"."_pidField_") AS ID"
              strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strSQL.get(),"select DISTINCT top "),pintMaxCount.get())," %upper("),strTableName.get()),"."),pidField.get()),") AS ID"));
            }
            //<< } else {
            else {
              //<< set strSQL = strSQL_"select DISTINCT top "_pintMaxCount_" "_strTableName_"."_pidField
              strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strSQL.get(),"select DISTINCT top "),pintMaxCount.get())," "),strTableName.get()),"."),pidField.get()));
            }
          }
          //<< }
          //<< } else {
          else {
            //<< set strSQL = strSQL_"select DISTINCT "_strTableName_"."_pidField
            strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strSQL.get(),"select DISTINCT "),strTableName.get()),"."),pidField.get()));
          }
        }
        //<< }
        //<< }
        //<< set strSQL = strSQL_"#### from **** "
        strSQL.set(mOp.Concat(strSQL.get(),"#### from **** "));
        //<< 
        //<< if 'blnObj {
        if (mOp.Not(blnObj.get())) {
          //<< if '$$$WWW001SharedFile($get(^WWW001(0,pidClass,1))) set strSQL = strSQL_$$$Where(blnWhereUsed)_strTableName_".company = "_YM_" "
          if (mOp.Not(include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,pidClass.get(),1))))) {
            strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strSQL.get(),$$$Where(m$,blnWhereUsed)),strTableName.get()),".company = "),m$.var("YM").get())," "));
          }
        }
        //<< }
        //<< 
        //<< if (+$$$WWWClientParamCoreChangesHEVA($get(^WWWClientParam(YM,YM,1)))) {
        if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesHEVA(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
          //<< set idView = $$GetCurrentView^COMView(pidClass)
          mVar idView = m$.var("idView");
          idView.set(m$.fnc$("COMView.GetCurrentView",pidClass.get()));
          //<< set objView = $get(^COMView(0,pidClass,idView,1))
          mVar objView = m$.var("objView");
          objView.set(m$.Fnc.$get(m$.var("^COMView",0,pidClass.get(),idView.get(),1)));
          //<< set favorito = $$GetTextForFavourite^COMView(pidClass, idView, objView)
          mVar favorito = m$.var("favorito");
          favorito.set(m$.fnc$("COMView.GetTextForFavourite",pidClass.get(),idView.get(),objView.get()));
          //<< 
          //<< if (favorito = "Admissões Disponíveis"){
          if ((mOp.Equal(favorito.get(),"Admissões Disponíveis"))) {
            //<< set newFilter = ""
            mVar newFilter = m$.var("newFilter");
            newFilter.set("");
            //<< if ($$CheckVincularPacAdmAtivas^VARINDispenseToPatient()){
            if (mOp.Logical((m$.fnc$("VARINDispenseToPatient.CheckVincularPacAdmAtivas")))) {
              //<< set newFilter = " and %upper(DateDischarged) = ' ' "
              newFilter.set(" and %upper(DateDischarged) = ' ' ");
            }
            //<< }
            //<< else {
            else {
              //<< set newFilter = " and ((CAST(DateDischarged as VARCHAR) IS NULL) or (DateAdmitted >= (CURRENT_DATE-3))) "
              newFilter.set(" and ((CAST(DateDischarged as VARCHAR) IS NULL) or (DateAdmitted >= (CURRENT_DATE-3))) ");
            }
            //<< }
            //<< set strSQL = strSQL_newFilter
            strSQL.set(mOp.Concat(strSQL.get(),newFilter.get()));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if ( (+$$$WWWClientParamCoreChangesHEVA($get(^WWWClientParam(YM,YM,1)))) ||
        //<< (+$$$WWWClientParamCoreChangesSESDF($get(^WWWClientParam(YM,YM,1))))  ||
        //<< (+$$$WWWClientParamCoreChangesSESPE($get(^WWWClientParam(YM,YM,1)))) ) {
        if ((mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesHEVA(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESDF(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESPE(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))))) {
          //<< 
          //<< set produtosP       = ""
          mVar produtosP = m$.var("produtosP");
          produtosP.set("");
          //<< set idParentForm    = ""
          mVar idParentForm = m$.var("idParentForm");
          idParentForm.set("");
          //<< 
          //<< set produtosP   = $piece(^VARParametroCliente(YM,YM,1),Y,76)
          produtosP.set(m$.Fnc.$piece(m$.var("^VARParametroCliente",m$.var("YM").get(),m$.var("YM").get(),1).get(),m$.var("Y").get(),76));
          //<< 
          //<< if ($get(^CacheTempView(YUSER,"CallingForm")) = "INReqLine") {
          if ((mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallingForm")),"INReqLine"))) {
            //<< if (produtosP = 1) {
            if ((mOp.Equal(produtosP.get(),1))) {
              //<< set strSQL = strSQL_" and INART.FREE5 = 1 "
              strSQL.set(mOp.Concat(strSQL.get()," and INART.FREE5 = 1 "));
            }
          }
        }
        //<< }
        //<< }
        //<< 
        //<< }
        //<< 
        //<< set strFilterTypes = "FixedFilter,Filter"
        strFilterTypes.set("FixedFilter,Filter");
        //<< for FilterLoop=1:1:$length(strFilterTypes,",") {
        for (FilterLoop.set(1);(mOp.LessOrEqual(FilterLoop.get(),m$.Fnc.$length(strFilterTypes.get(),",")));FilterLoop.set(mOp.Add(FilterLoop.get(),1))) {
          //<< set strFilterType = $piece(strFilterTypes,",",FilterLoop)
          strFilterType.set(m$.Fnc.$piece(strFilterTypes.get(),",",FilterLoop.get()));
          //<< 
          //<< set idFilter = ""
          idFilter.set("");
          //<< for {
          for (;true;) {
            //<< set idFilter = $order(^CacheTempView(YUSER,strFilterType,idFilter))
            idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),strFilterType.get(),idFilter.get())));
            //<< quit:idFilter=""
            if (mOp.Equal(idFilter.get(),"")) {
              break;
            }
            //<< 
            //<< set strCondition = "" ;16708A
            strCondition.set("");
            //<< set strValue3    = "" ;16708A
            strValue3.set("");
            //<< 
            //<< set objFilter = $get(^CacheTempView(YUSER,strFilterType,idFilter))
            objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),strFilterType.get(),idFilter.get())));
            //<< set strField  = $$$COMViewFilterField(objFilter)
            strField.set(include.COMConst.$$$COMViewFilterField(m$,objFilter));
            //<< set strComp   = $$$COMViewFilterComparator(objFilter)
            strComp.set(include.COMConst.$$$COMViewFilterComparator(m$,objFilter));
            //<< set strValue  = $$$COMViewFilterValue1(objFilter)
            strValue.set(include.COMConst.$$$COMViewFilterValue1(m$,objFilter));
            //<< if ($extract(strField)="P") && $$SimulateCommainPrimaryKey^WWW012() {
            if ((mOp.Equal(m$.Fnc.$extract(strField.get()),"P")) && mOp.Logical(m$.fnc$("WWW012.SimulateCommainPrimaryKey"))) {
              //<< set strValue = $translate(strValue,",",$$$FAKECOMMA)
              strValue.set(m$.Fnc.$translate(strValue.get(),",",include.COMSYSString.$$$FAKECOMMA(m$)));
            }
            //<< }
            //<< set blnNoConversion = +$$$COMViewFilterNoconversion(objFilter) ; Do not convert filter value
            blnNoConversion.set(mOp.Positive(include.COMConst.$$$COMViewFilterNoconversion(m$,objFilter)));
            //<< 
            //<< if $$$COMViewFilterGroupBy(objFilter) {
            if (mOp.Logical(include.COMConst.$$$COMViewFilterGroupBy(m$,objFilter))) {
              //<< set strProperty = strField
              strProperty.set(strField.get());
              //<< if 'pblnSelectAll {
              if (mOp.Not(pblnSelectAll.get())) {
                //<< if pstrRef="" {
                if (mOp.Equal(pstrRef.get(),"")) {
                  //<< set idClass = pidClass
                  idClass.set(pidClass.get());
                  //<< do ConvertField(.idClass,.strProperty,"","","",pstrSafeMode,,$$$COMViewFilterDisplay(objFilter))
                  m$.Cmd.Do("ConvertField",idClass,strProperty,"","","",pstrSafeMode.get(),null,include.COMConst.$$$COMViewFilterDisplay(m$,objFilter));
                  //<< if strGroupBy'="" set strGroupBy = strGroupBy_","
                  if (mOp.NotEqual(strGroupBy.get(),"")) {
                    strGroupBy.set(mOp.Concat(strGroupBy.get(),","));
                  }
                  //<< set strGroupBy = strGroupBy_strProperty
                  strGroupBy.set(mOp.Concat(strGroupBy.get(),strProperty.get()));
                  //<< 
                  //<< if '$listfind(lstClasses,idClass) {
                  if (mOp.Not(m$.Fnc.$listfind(lstClasses.get(),idClass.get()))) {
                    //<< set lstClasses = lstClasses_$listbuild(idClass)
                    lstClasses.set(mOp.Concat(lstClasses.get(),m$.Fnc.$listbuild(idClass.get())));
                  }
                  //<< }
                  //<< 
                  //<< if $find(strField,".") set lstProps = lstProps_$listbuild(strField)
                  if (mOp.Logical(m$.Fnc.$find(strField.get(),"."))) {
                    lstProps.set(mOp.Concat(lstProps.get(),m$.Fnc.$listbuild(strField.get())));
                  }
                }
                //<< 
                //<< } else {
                else {
                  //<< set strValue = $$GetValue(pidClass,strProperty,pstrRef) ;SR16944
                  strValue.set(m$.fnc$("GetValue",pidClass.get(),strProperty.get(),pstrRef.get()));
                  //<< 
                  //<< do ConvertField(pidClass,.strProperty,.strValue,"","",pstrSafeMode,,$$$COMViewFilterDisplay(objFilter)) ;SR16944
                  m$.Cmd.Do("ConvertField",pidClass.get(),strProperty,strValue,"","",pstrSafeMode.get(),null,include.COMConst.$$$COMViewFilterDisplay(m$,objFilter));
                  //<< 
                  //<< if strValue="" {
                  if (mOp.Equal(strValue.get(),"")) {
                    //<< set strCondition = "(%1 in ("""","" "") or %1 is null) "   ;SR16708
                    strCondition.set("(%1 in (\"\",\" \") or %1 is null) ");
                  }
                  //<< ;   set strSQLPiece  = $$$Where(blnWhereUsed)_"("_strField_" in ("""","" "") or "_strField_" is null) " ;SR16708
                  //<< } else {
                  else {
                    //<< set strCondition = "%1 = %2"    ;SR16708
                    strCondition.set("%1 = %2");
                  }
                }
              }
            }
            //<< ;   set strSQLPiece  = $$$Where(blnWhereUsed)_strField_" = "_$$$AddQuotes(strRefValue)_" "  ;SR16708
            //<< }
            //<< }
            //<< }
            //<< }
            //<< 
            //<< if strField="Custom" {
            if (mOp.Equal(strField.get(),"Custom")) {
              //<< set strCondition = "%2 "    ;SR16708
              strCondition.set("%2 ");
            }
            //<< ;   set strSQLPiece  = $$$Where(blnWhereUsed)_strValue_" "  ;SR16708
            //<< 
            //<< } elseif (strField'="") && ((strValue'="") || $find(",3,4,",","_strComp_",")) {
            else if ((mOp.NotEqual(strField.get(),"")) && mOp.Logical(((mOp.NotEqual(strValue.get(),"")) || mOp.Logical(m$.Fnc.$find(",3,4,",mOp.Concat(mOp.Concat(",",strComp.get()),",")))))) {
              //<< ;   set strSQLPiece  = $$$Where(blnWhereUsed)   ;SR16708
              //<< set idClass = pidClass
              idClass.set(pidClass.get());
              //<< ;SR17283    set strValue3 = $zcvt(strValue,"U")     ;SR17225
              //<< if $find(strField,".") {
              if (mOp.Logical(m$.Fnc.$find(strField.get(),"."))) {
                //<< set lstProps = lstProps_$listbuild(strField)
                lstProps.set(mOp.Concat(lstProps.get(),m$.Fnc.$listbuild(strField.get())));
                //<< set ^CacheTempSQL($$$SQLID,"RelationFilter",strField,strFilterType) = idFilter
                m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$),"RelationFilter",strField.get(),strFilterType.get()).set(idFilter.get());
              }
              //<< }
              //<< 
              //<< if blnNoConversion { ; Do not convert filter value
              if (mOp.Logical(blnNoConversion.get())) {
                //<< do ConvertField(.idClass,.strField,"",.strComp,"",pstrSafeMode,,$$$COMViewFilterDisplay(objFilter))
                m$.Cmd.Do("ConvertField",idClass,strField,"",strComp,"",pstrSafeMode.get(),null,include.COMConst.$$$COMViewFilterDisplay(m$,objFilter));
              }
              //<< 
              //<< } else {
              else {
                //<< if blnObj {     //SR15866
                if (mOp.Logical(blnObj.get())) {
                  //<< set idClassN  = $$GetClass^COMViewObject(idClass,.strField)
                  idClassN.set(m$.fnc$("COMViewObject.GetClass",idClass.get(),strField));
                  //<< set strFieldN = $piece(strField,"->",$length(strField,"->"))
                  strFieldN.set(m$.Fnc.$piece(strField.get(),"->",m$.Fnc.$length(strField.get(),"->")));
                  //<< do ConvertField(idClassN,strFieldN,.strValue,.strComp,"",pstrSafeMode,,$$$COMViewFilterDisplay(objFilter))
                  m$.Cmd.Do("ConvertField",idClassN.get(),strFieldN.get(),strValue,strComp,"",pstrSafeMode.get(),null,include.COMConst.$$$COMViewFilterDisplay(m$,objFilter));
                }
                //<< }
                //<< 
                //<< do ConvertField(.idClass,.strField,.strValue,.strComp,"",pstrSafeMode,,$$$COMViewFilterDisplay(objFilter))
                m$.Cmd.Do("ConvertField",idClass,strField,strValue,strComp,"",pstrSafeMode.get(),null,include.COMConst.$$$COMViewFilterDisplay(m$,objFilter));
              }
              //<< }
              //<< set strValue3 = $zcvt(strValue,"U")     ;SR17225 ;SR17283
              strValue3.set(m$.Fnc.$zconvert(strValue.get(),"U"));
              //<< if '$listfind(lstClasses,idClass) {
              if (mOp.Not(m$.Fnc.$listfind(lstClasses.get(),idClass.get()))) {
                //<< set lstClasses = lstClasses_$listbuild(idClass)
                lstClasses.set(mOp.Concat(lstClasses.get(),m$.Fnc.$listbuild(idClass.get())));
              }
              //<< }
              //<< 
              //<< if strComp=$$$EnumCOMVIEWCOMPARATORGreaterThan {
              if (mOp.Equal(strComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORGreaterThan(m$))) {
                //<< set strCondition = "%1 > %2"    ;SR16708
                strCondition.set("%1 > %2");
              }
              //<< ;   set strSQLPiece  = strField_" > "_strValue_" "  ;SR16708
              //<< 
              //<< } elseif strComp=$$$EnumCOMVIEWCOMPARATORLessThan {
              else if (mOp.Equal(strComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORLessThan(m$))) {
                //<< set strCondition ="%1 < %2" ;SR16708
                strCondition.set("%1 < %2");
              }
              //<< ;   set strSQLPiece  = strField_" < "_strValue_" "  ;SR16708
              //<< 
              //<< } elseif strComp=$$$EnumCOMVIEWCOMPARATOREquals {
              else if (mOp.Equal(strComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$))) {
                //<< ; strValue gets quoted, so a null is 2*$$$DBLQUOTE
                //<< if ($translate(strValue," ")="""") || ($translate(strValue,$$$DBLQUOTE) = "") {
                if ((mOp.Equal(m$.Fnc.$translate(strValue.get()," "),"\"")) || (mOp.Equal(m$.Fnc.$translate(strValue.get(),include.COMSYSString.$$$DBLQUOTE(m$)),""))) {
                  //<< ; alternative?      ; if $translate($translate(strValue," "),$$$DBLQUOTE) = "" {
                  //<< set strCondition = "(%1 is null or %1 in ("" "",%2)) "  ;SR16708
                  strCondition.set("(%1 is null or %1 in (\" \",%2)) ");
                }
                //<< ;   set strSQLPiece  = "("_strField_" is null or "_strField_" in ("" "","_strValue_")) "    ;SR16708
                //<< } else {
                else {
                  //<< set strCondition = "%1 = %2"    ;SR16708
                  strCondition.set("%1 = %2");
                }
              }
              //<< ;   set strSQLPiece  = strField_" = "_strValue_" "  ;SR16708
              //<< }
              //<< 
              //<< } elseif strComp=$$$EnumCOMVIEWCOMPARATORNotEquals {
              else if (mOp.Equal(strComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORNotEquals(m$))) {
                //<< if $translate($translate(strValue," "),$$$DBLQUOTE) = "" {
                if (mOp.Equal(m$.Fnc.$translate(m$.Fnc.$translate(strValue.get()," "),include.COMSYSString.$$$DBLQUOTE(m$)),"")) {
                  //<< if ((((+$$$WWWClientParamCoreChangesSESPE($get(^WWWClientParam(YM,YM,1)))) ||
                  //<< (+$$$WWWClientParamCoreChangesHCB($get(^WWWClientParam(YM,YM,1))))  ||
                  //<< (+$$$WWWClientParamCoreChangesSESDF($get(^WWWClientParam(YM,YM,1)))))) &&
                  //<< (pidClass = "INReq")) {
                  if ((mOp.Logical(((mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESPE(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesHCB(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESDF(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))))) && (mOp.Equal(pidClass.get(),"INReq")))) {
                    //<< set strCondition = "(1=1) "
                    strCondition.set("(1=1) ");
                  }
                  //<< }
                  //<< else {
                  else {
                    //<< set strCondition = "%1 is not null AND %1 not in ("" "",%2) "  ;SR16708
                    strCondition.set("%1 is not null AND %1 not in (\" \",%2) ");
                  }
                }
                //<< }
                //<< ;   set strSQLPiece  = strField_" is not null AND "_strField_" not in ("" "","_strValue_") "  ;SR16708
                //<< 
                //<< } else {
                else {
                  //<< if $translate(strValue,"""")=$translate(strValue3,"""") {   ;SR17225
                  if (mOp.Equal(m$.Fnc.$translate(strValue.get(),"\""),m$.Fnc.$translate(strValue3.get(),"\""))) {
                    //<< set strCondition = "(%1 <> %2 OR %1 IS NULL) "          ;SR16708  ;SR17225
                    strCondition.set("(%1 <> %2 OR %1 IS NULL) ");
                  }
                  //<< } else {
                  else {
                    //<< set strCondition = "((%1 IS NULL) OR ((%1 <> %2) and (%1 <> %3))) "  ;SR16708 ;SR17225
                    strCondition.set("((%1 IS NULL) OR ((%1 <> %2) and (%1 <> %3))) ");
                  }
                }
              }
              //<< }
              //<< ;   set strSQLPiece  = "("_strField_" <> "_strValue_" OR "_strField_" IS NULL) "  ;SR16708
              //<< }
              //<< 
              //<< } elseif strComp=$$$EnumCOMVIEWCOMPARATORStartsWith {
              else if (mOp.Equal(strComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORStartsWith(m$))) {
                //<< set strCondition = "%1 %startswith %2 "                     ;SR16708 ;SR17225 ;SR17346
                strCondition.set("%1 %startswith %2 ");
              }
              //<< ;SR17346    set strCondition = "%UPPER(%1) %startswith %UPPER(%2) "     ;SR16708 ;SR17225
              //<< ;   set strCondition = "$$Index^COMUtils(%1) %startswith %2 "   ;SR16708 ;SR17225
              //<< ;   set strCondition = "$$Index^COMUtils(%1) %startswith $$Index^COMUtils(%2) "    ;SR16708 ;SR17225
              //<< ;   set strSQLPiece = strField_" %startswith "_strValue_" "     ;SR16708
              //<< 
              //<< } elseif strComp=$$$EnumCOMVIEWCOMPARATORContains {
              else if (mOp.Equal(strComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORContains(m$))) {
                //<< set strCondition = "$find(%1,%2) > 1 "                      ;SR16708 ;SR17225 ;SR17346
                strCondition.set("$find(%1,%2) > 1 ");
              }
              //<< ;;SR17346   set strCondition = "$find($$Index^COMUtils(%1),%2) > 1 "    ;SR16708 ;SR17225
              //<< ;   set strSQLPiece = "$find("_strField_","_strValue_") > 1 "   ;SR16708
              //<< 
              //<< //SR17023
              //<< } elseif strComp=$$$EnumCOMVIEWCOMPARATORFindIn {
              else if (mOp.Equal(strComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORFindIn(m$))) {
                //<< set strCondition = "$find(%2,%1) > 1 "
                strCondition.set("$find(%2,%1) > 1 ");
              }
              //<< 
              //<< // FIXME JW - Within does not work for multiple values entered...
              //<< } elseif strComp=$$$EnumCOMVIEWCOMPARATORWithin {
              else if (mOp.Equal(strComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORWithin(m$))) {
                //<< if '$find($$$UPPER(strValue),"SELECT ") &&
                //<< '$find($$$UPPER(strValue)," FROM ")     {         ; SR17214 add test for other SQL Query
                if (mOp.Not(m$.Fnc.$find(include.COMSYSString.$$$UPPER(m$,strValue),"SELECT ")) && mOp.Not(m$.Fnc.$find(include.COMSYSString.$$$UPPER(m$,strValue)," FROM "))) {
                  //<< 
                  //<< set strValue = $$^WWWKEYBUILD($translate(strValue,""""))
                  strValue.set(m$.fnc$("WWWKEYBUILD.main",m$.Fnc.$translate(strValue.get(),"\"")));
                }
                //<< }
                //<< ;   set strSQLPiece  = strField_" in ("_$$^WWWKEYBUILD($translate(strValue,""""))_")" ;BR014982 ;SR16708
                //<< //  set strCondition = "%1 in (%2)" ;BR014982   ;SR16708
                //<< //SR17023  - Comma separated list
                //<< ;           set strCondition = strField_" in ("_$$^WWWKEYBUILD($translate(strValue,""""))_")"  ; SR17214/SR17023
                //<< set strCondition = strField_" in ("_strValue_")"
                strCondition.set(mOp.Concat(mOp.Concat(mOp.Concat(strField.get()," in ("),strValue.get()),")"));
              }
              //<< 
              //<< } elseif strComp=$$$EnumCOMVIEWCOMPARATORLike {
              else if (mOp.Equal(strComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORLike(m$))) {
                //<< set strCondition = "%1 like %2" ;SR16708
                strCondition.set("%1 like %2");
              }
              //<< ;   set strSQLPiece  = strField_" like "_strValue   ;SR16708
              //<< 
              //<< } elseif strComp=$$$EnumCOMVIEWCOMPARATORBetween {      //SR14832
              else if (mOp.Equal(strComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORBetween(m$))) {
                //<< if $extract(strValue)=$$$DBLQUOTE {     // Remove quotes
                if (mOp.Equal(m$.Fnc.$extract(strValue.get()),include.COMSYSString.$$$DBLQUOTE(m$))) {
                  //<< set strValue = $extract(strValue,2,$length(strValue)-1)
                  strValue.set(m$.Fnc.$extract(strValue.get(),2,mOp.Subtract(m$.Fnc.$length(strValue.get()),1)));
                }
                //<< }
                //<< if $piece(strValue,"&",1) = "" {        // If only one value, use >= or <=
                if (mOp.Equal(m$.Fnc.$piece(strValue.get(),"&",1),"")) {
                  //<< set strValue = $$$QUOTE($piece(strValue,"&",2))
                  strValue.set(include.COMSYSString.$$$QUOTE(m$,m$.Fnc.$piece(strValue.get(),"&",2)));
                  //<< set strCondition = "%1 <= %2"   ;SR16708
                  strCondition.set("%1 <= %2");
                }
                //<< ;   set strSQLPiece  = strField_" <= "_$$$QUOTE($piece(strValue,"&",2)) ;SR16708
                //<< 
                //<< } elseif $piece(strValue,"&",2) = "" {
                else if (mOp.Equal(m$.Fnc.$piece(strValue.get(),"&",2),"")) {
                  //<< set strValue=$$$QUOTE($piece(strValue,"&",1))
                  strValue.set(include.COMSYSString.$$$QUOTE(m$,m$.Fnc.$piece(strValue.get(),"&",1)));
                  //<< ;   set strSQLPiece  = strField_" >= "_$$$QUOTE($piece(strValue,"&",1)) ;SR16708
                  //<< set strCondition = "%1 >= %2"   ;SR16708
                  strCondition.set("%1 >= %2");
                }
                //<< 
                //<< } else {
                else {
                  //<< ;   set strSQLPiece = strField_" between "_$$$QUOTE($piece(strValue,"&",1))_" and "_$$$QUOTE($piece(strValue,"&",2))  ;SR16708
                  //<< set strValue3    = $$$QUOTE($piece(strValue,"&",2)) ;SR16708 ;SR18119
                  strValue3.set(include.COMSYSString.$$$QUOTE(m$,m$.Fnc.$piece(strValue.get(),"&",2)));
                  //<< set strValue     = $$$QUOTE($piece(strValue,"&",1)) ;SR16708 ;SR18119
                  strValue.set(include.COMSYSString.$$$QUOTE(m$,m$.Fnc.$piece(strValue.get(),"&",1)));
                  //<< set strCondition = "%1 between %2 and %3"           ;SR16708
                  strCondition.set("%1 between %2 and %3");
                }
              }
            }
            //<< }
            //<< }
            //<< }
            //<< set strSQL = strSQL_$$AddSQL(strCondition,strValue,strValue3,pidClass,strField,.blnWhereUsed)   ;SR16708
            strSQL.set(mOp.Concat(strSQL.get(),m$.fnc$("AddSQL",strCondition.get(),strValue.get(),strValue3.get(),pidClass.get(),strField.get(),blnWhereUsed)));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if pblnInForm {
        if (mOp.Logical(pblnInForm.get())) {
          //<< // Always order by the last primary key
          //<< set idSortField = "P"_$order(^WWW002(0,pidClass,""),-1)
          idSortField.set(mOp.Concat("P",m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),""),mOp.Negative(1))));
          //<< do ConvertField(pidClass,.idSortField,"","","",pstrSafeMode,1,$$$COMViewFilterDisplay(objFilter))
          m$.Cmd.Do("ConvertField",pidClass.get(),idSortField,"","","",pstrSafeMode.get(),1,include.COMConst.$$$COMViewFilterDisplay(m$,objFilter));
          //<< set strDirection = 1
          strDirection.set(1);
        }
        //<< 
        //<< } else {
        else {
          //<< set idSortField = $$GetSort^COMViewFilterColumn(pidClass,.strDirection)
          idSortField.set(m$.fnc$("COMViewFilterColumn.GetSort",pidClass.get(),strDirection));
          //<< 
          //<< if 'blnObj {
          if (mOp.Not(blnObj.get())) {
            //<< if $find(idSortField,".") {
            if (mOp.Logical(m$.Fnc.$find(idSortField.get(),"."))) {
              //<< set idClass  = pidClass
              idClass.set(pidClass.get());
              //<< set lstProps = lstProps_$listbuild(idSortField)
              lstProps.set(mOp.Concat(lstProps.get(),m$.Fnc.$listbuild(idSortField.get())));
              //<< do ConvertField(.idClass,.idSortField,"","","",pstrSafeMode,1,$$$COMViewFilterDisplay(objFilter))
              m$.Cmd.Do("ConvertField",idClass,idSortField,"","","",pstrSafeMode.get(),1,include.COMConst.$$$COMViewFilterDisplay(m$,objFilter));
              //<< if '$listfind(lstClasses,idClass) set lstClasses = lstClasses_$listbuild(idClass)
              if (mOp.Not(m$.Fnc.$listfind(lstClasses.get(),idClass.get()))) {
                lstClasses.set(mOp.Concat(lstClasses.get(),m$.Fnc.$listbuild(idClass.get())));
              }
            }
            //<< } elseif idSortField'=""  {
            else if (mOp.NotEqual(idSortField.get(),"")) {
              //<< do ConvertField(pidClass,.idSortField,"","","",pstrSafeMode,1,$$$COMViewFilterDisplay(objFilter))
              m$.Cmd.Do("ConvertField",pidClass.get(),idSortField,"","","",pstrSafeMode.get(),1,include.COMConst.$$$COMViewFilterDisplay(m$,objFilter));
            }
          }
          //<< }
          //<< } else {
          else {
            //<< set idSortFieldClass = $$GetClass^COMViewObject(pidClass,idSortField)       //"alSOH.dPeriodBalance","QtySubType->QtyFree1" = alSOH.dPeriodSubType
            idSortFieldClass.set(m$.fnc$("COMViewObject.GetClass",pidClass.get(),idSortField.get()));
            //<< if idSortField'="" set idSortField = pidClass_"."_idSortField
            if (mOp.NotEqual(idSortField.get(),"")) {
              idSortField.set(mOp.Concat(mOp.Concat(pidClass.get(),"."),idSortField.get()));
            }
            //<< 
            //<< if $$IsClassSerial^COMViewObject(idSortFieldClass) {   //SR17023
            if (mOp.Logical(m$.fnc$("COMViewObject.IsClassSerial",idSortFieldClass.get()))) {
              //<< set idSortField = $translate(idSortField,"->","_")
              idSortField.set(m$.Fnc.$translate(idSortField.get(),"->","_"));
            }
          }
        }
        //<< }
        //<< 
        //<< }
        //<< 
        //<< }
        //<< set strSQL = strSQL_$$MatchClasses(pidClass,lstProps,pstrSafeMode,.blnWhereUsed)
        strSQL.set(mOp.Concat(strSQL.get(),m$.fnc$("MatchClasses",pidClass.get(),lstProps.get(),pstrSafeMode.get(),blnWhereUsed)));
        //<< set strSQL = $$OnBeforeSQL(pidClass,strSQL,.blnWhereUsed)  ;SR17075
        strSQL.set(m$.fnc$("OnBeforeSQL",pidClass.get(),strSQL.get(),blnWhereUsed));
        //<< 
        //<< set strClasses = ""
        strClasses.set("");
        //<< for ClassLoop=1:1:$listlength(lstClasses) {
        for (ClassLoop.set(1);(mOp.LessOrEqual(ClassLoop.get(),m$.Fnc.$listlength(lstClasses.get())));ClassLoop.set(mOp.Add(ClassLoop.get(),1))) {
          //<< if ClassLoop'=1 set strClasses = strClasses_","
          if (mOp.NotEqual(ClassLoop.get(),1)) {
            strClasses.set(mOp.Concat(strClasses.get(),","));
          }
          //<< set strClasses = strClasses_$listget(lstClasses,ClassLoop)
          strClasses.set(mOp.Concat(strClasses.get(),m$.Fnc.$listget(lstClasses.get(),ClassLoop.get())));
        }
        //<< }
        //<< set strSQL = $$Replace^COMUtilStr(strSQL,"****",strClasses)
        strSQL.set(m$.fnc$("COMUtilStr.Replace",strSQL.get(),"****",strClasses.get()));
        //<< 
        //<< if $listfind(plstColumns,"RowCount") {
        if (mOp.Logical(m$.Fnc.$listfind(plstColumns.get(),"RowCount"))) {
          //<< set strSelectProperties = strSelectProperties_",COUNT("_pidClass_".ID) AS RowCount"
          strSelectProperties.set(mOp.Concat(mOp.Concat(mOp.Concat(strSelectProperties.get(),",COUNT("),pidClass.get()),".ID) AS RowCount"));
        }
        //<< }
        //<< 
        //<< if blnObj {   ; SR17214
        if (mOp.Logical(blnObj.get())) {
          //<< if strGroupBy'="" set strSelectProperties = strGrpProperties
          if (mOp.NotEqual(strGroupBy.get(),"")) {
            strSelectProperties.set(strGrpProperties.get());
          }
          //<< set strSQL = $$Replace^COMUtilStr(strSQL,"####",strSelectProperties)
          strSQL.set(m$.fnc$("COMUtilStr.Replace",strSQL.get(),"####",strSelectProperties.get()));
        }
        //<< 
        //<< } else {
        else {
          //<< if strGroupBy="" set strSelectProperties = ""
          if (mOp.Equal(strGroupBy.get(),"")) {
            strSelectProperties.set("");
          }
          //<< set strSQL = $$Replace^COMUtilStr(strSQL,"####",strSelectProperties)
          strSQL.set(m$.fnc$("COMUtilStr.Replace",strSQL.get(),"####",strSelectProperties.get()));
        }
        //<< }
        //<< 
        //<< if strGroupBy'="" {
        if (mOp.NotEqual(strGroupBy.get(),"")) {
          //<< set strSQL = strSQL_" group by "_strGroupBy_" "
          strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(strSQL.get()," group by "),strGroupBy.get())," "));
        }
        //<< }
        //<< if idSortField'="" {
        if (mOp.NotEqual(idSortField.get(),"")) {
          //<< set strSQL = strSQL_" order by "_idSortField_" "
          strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(strSQL.get()," order by "),idSortField.get())," "));
          //<< if strDirection=-1 {
          if (mOp.Equal(strDirection.get(),mOp.Negative(1))) {
            //<< set strSQL = strSQL_"desc"
            strSQL.set(mOp.Concat(strSQL.get(),"desc"));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< set strSQL = $$RemoveMark(strSQL)
    strSQL.set(m$.fnc$("RemoveMark",strSQL.get()));
    //<< if (+$$$WWWClientParamCoreChangesHEVA($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesHEVA(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
      //<< set idView = $$GetCurrentView^COMView(pidClass)
      mVar idView = m$.var("idView");
      idView.set(m$.fnc$("COMView.GetCurrentView",pidClass.get()));
      //<< set objView = $get(^COMView(0,pidClass,idView,1))
      mVar objView = m$.var("objView");
      objView.set(m$.Fnc.$get(m$.var("^COMView",0,pidClass.get(),idView.get(),1)));
      //<< set favorito = $$GetTextForFavourite^COMView(pidClass, idView, objView)
      mVar favorito = m$.var("favorito");
      favorito.set(m$.fnc$("COMView.GetTextForFavourite",pidClass.get(),idView.get(),objView.get()));
      //<< if ( favorito = "Por Produto/Paciente") ||
      //<< ( favorito = "Por Produto")
      //<< {
      if ((mOp.Equal(favorito.get(),"Por Produto/Paciente")) || (mOp.Equal(favorito.get(),"Por Produto"))) {
        //<< set strSQL = $Replace(strSQL,"$$Index^COMUtils"," ")
        strSQL.set(m$.Fnc.$replace(strSQL.get(),"$$Index^COMUtils"," "));
      }
      //<< }
      //<< 
      //<< elseif (favorito = "Presc. Aguard. Dispensação"){
      else if ((mOp.Equal(favorito.get(),"Presc. Aguard. Dispensação"))) {
        //<< set newOrder =  " $$CheckUrgent^VARDispensacaoViaPrescricaoLinha(SQLUser.MEDPrescription.PrescriptionNumber) desc, "_
        //<< " SQLUser.MEDPrescription.FREE6 asc, "_
        //<< " SQLUser.MEDPrescription.PrescriptionNumber "
        mVar newOrder = m$.var("newOrder");
        newOrder.set(mOp.Concat(mOp.Concat(" $$CheckUrgent^VARDispensacaoViaPrescricaoLinha(SQLUser.MEDPrescription.PrescriptionNumber) desc, "," SQLUser.MEDPrescription.FREE6 asc, ")," SQLUser.MEDPrescription.PrescriptionNumber "));
        //<< set $piece(strSQL,"order by",2) = newOrder
        m$.pieceVar(strSQL,"order by",2).set(newOrder.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strSQL
    return strSQL.get();
  }

  //<< 
  //<< 
  //<< OnBeforeSQL(pidClass,pstrSQL,&pblnWhereUsed)
  public Object OnBeforeSQL(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrSQL = m$.newVarRef("pstrSQL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnWhereUsed = m$.newVarRef("pblnWhereUsed",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Adds additional filter conditions.
    //<< ;
    //<< ; YSQL : set by ExecuteHook (?)
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Dec-2009   shobby  SR17075: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,YSQL
    mVar strStatus = m$.var("strStatus");
    mVar YSQL = m$.var("YSQL");
    m$.newVar(strStatus,YSQL);
    //<< 
    //<< set strStatus = $$ExecuteHook^WWW001Hook(pidClass,$$$EnumWWWEVENTTYPEOnBeforeSQL,,,$get(^CacheTempView(YUSER,"CallingForm")))
    strStatus.set(m$.fnc$("WWW001Hook.ExecuteHook",pidClass.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeSQL(m$),null,null,m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallingForm"))));
    //<< if $get(YSQL)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(YSQL),"")) {
      //<< set pstrSQL = pstrSQL_$$$Where(pblnWhereUsed)_" ID IN ("_YSQL_")"
      pstrSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrSQL.get(),$$$Where(m$,pblnWhereUsed))," ID IN ("),YSQL.get()),")"));
    }
    //<< }
    //<< quit pstrSQL
    return pstrSQL.get();
  }

  //<< 
  //<< 
  //<< AddSQL(pstrCondition,pstrValue,pstrValue3,pidClass,pstrField,&pblnWhereUsed)
  public Object AddSQL(Object ... _p) {
    mVar pstrCondition = m$.newVarRef("pstrCondition",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrValue3 = m$.newVarRef("pstrValue3",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pblnWhereUsed = m$.newVarRef("pblnWhereUsed",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add the new condition to the SQL
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Oct-2012   shobby      SR18119: Bug in 'between' search.
    //<< ; 28-Sep-2009   shobby      SR16708: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strSQL,strSQLPiece,strSQLPiece2,strValueMod,strValue3Mod
    mVar strSQL = m$.var("strSQL");
    mVar strSQLPiece = m$.var("strSQLPiece");
    mVar strSQLPiece2 = m$.var("strSQLPiece2");
    mVar strValueMod = m$.var("strValueMod");
    mVar strValue3Mod = m$.var("strValue3Mod");
    m$.newVar(strSQL,strSQLPiece,strSQLPiece2,strValueMod,strValue3Mod);
    //<< 
    //<< set strSQL=""
    strSQL.set("");
    //<< if pstrCondition'="" {
    if (mOp.NotEqual(pstrCondition.get(),"")) {
      //<< if $extract(pstrValue)="""" set pstrValue = $piece(pstrValue,"""",2)
      if (mOp.Equal(m$.Fnc.$extract(pstrValue.get()),"\"")) {
        pstrValue.set(m$.Fnc.$piece(pstrValue.get(),"\"",2));
      }
      //<< if $extract(pstrValue3)="""" set pstrValue3 = $piece(pstrValue3,"""",2) ;SR18119
      if (mOp.Equal(m$.Fnc.$extract(pstrValue3.get()),"\"")) {
        pstrValue3.set(m$.Fnc.$piece(pstrValue3.get(),"\"",2));
      }
      //<< set strSQLPiece2=""
      strSQLPiece2.set("");
      //<< 
      //<< if ($$IsSearchClass^COMQuickSearch(pidClass)) {        ;16708A
      if (mOp.Logical((m$.fnc$("COMQuickSearch.IsSearchClass",pidClass.get())))) {
        //<< set strValueMod  = $$GetCode^INARTCode(pstrValue)  ;16708
        strValueMod.set(m$.fnc$("INARTCode.GetCode",pstrValue.get()));
        //<< set strValue3Mod = $$GetCode^INARTCode(pstrValue3) ;16708
        strValue3Mod.set(m$.fnc$("INARTCode.GetCode",pstrValue3.get()));
        //<< if (pstrValue'=strValueMod) || (pstrValue3'=strValue3Mod) {
        if ((mOp.NotEqual(pstrValue.get(),strValueMod.get())) || (mOp.NotEqual(pstrValue3.get(),strValue3Mod.get()))) {
          //<< set strSQLPiece2 = $$DecodeString(pstrCondition,pstrField,$$$AddQuotes(strValueMod),$$$AddQuotes(strValue3Mod))
          strSQLPiece2.set(m$.fnc$("DecodeString",pstrCondition.get(),pstrField.get(),include.COMSYS.$$$AddQuotes(m$,strValueMod),include.COMSYS.$$$AddQuotes(m$,strValue3Mod)));
        }
      }
      //<< }
      //<< }
      //<< set strSQLPiece = $$DecodeString(pstrCondition,pstrField,$$$AddQuotes(pstrValue),$$$AddQuotes(pstrValue3))
      strSQLPiece.set(m$.fnc$("DecodeString",pstrCondition.get(),pstrField.get(),include.COMSYS.$$$AddQuotes(m$,pstrValue),include.COMSYS.$$$AddQuotes(m$,pstrValue3)));
      //<< if strSQLPiece2'="" {
      if (mOp.NotEqual(strSQLPiece2.get(),"")) {
        //<< set strSQL = $$$Where(pblnWhereUsed)_"("_strSQLPiece_" or "_strSQLPiece2_")"
        strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat($$$Where(m$,pblnWhereUsed),"("),strSQLPiece.get())," or "),strSQLPiece2.get()),")"));
      }
      //<< } else {
      else {
        //<< set strSQL = $$$Where(pblnWhereUsed)_strSQLPiece
        strSQL.set(mOp.Concat($$$Where(m$,pblnWhereUsed),strSQLPiece.get()));
      }
    }
    //<< }
    //<< }
    //<< quit strSQL
    return strSQL.get();
  }

  //<< 
  //<< 
  //<< DecodeString(pstrString,pstr1="",pstr2="",pstr3="",pstr4="")
  public Object DecodeString(Object ... _p) {
    mVar pstrString = m$.newVarRef("pstrString",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstr1 = m$.newVarRef("pstr1",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstr2 = m$.newVarRef("pstr2",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstr3 = m$.newVarRef("pstr3",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pstr4 = m$.newVarRef("pstr4",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; DecodeError^COMUtilStr doesn't like the input string to contain spaces when not a code.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Sep-2009   shobby  SR16708: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if pstr1'="" set pstrString = $$FullReplace^COMUtilStr(pstrString,"%1",pstr1)
    if (mOp.NotEqual(pstr1.get(),"")) {
      pstrString.set(m$.fnc$("COMUtilStr.FullReplace",pstrString.get(),"%1",pstr1.get()));
    }
    //<< if pstr2'="" set pstrString = $$FullReplace^COMUtilStr(pstrString,"%2",pstr2)
    if (mOp.NotEqual(pstr2.get(),"")) {
      pstrString.set(m$.fnc$("COMUtilStr.FullReplace",pstrString.get(),"%2",pstr2.get()));
    }
    //<< if pstr3'="" set pstrString = $$FullReplace^COMUtilStr(pstrString,"%3",pstr3)
    if (mOp.NotEqual(pstr3.get(),"")) {
      pstrString.set(m$.fnc$("COMUtilStr.FullReplace",pstrString.get(),"%3",pstr3.get()));
    }
    //<< if pstr4'="" set pstrString = $$FullReplace^COMUtilStr(pstrString,"%4",pstr4)
    if (mOp.NotEqual(pstr4.get(),"")) {
      pstrString.set(m$.fnc$("COMUtilStr.FullReplace",pstrString.get(),"%4",pstr4.get()));
    }
    //<< quit pstrString
    return pstrString.get();
  }

  //<< 
  //<< 
  //<< GetValue(pidClass,pidField,pidKey)
  public Object GetValue(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< new loop,strRef,strValue
    mVar loop = m$.var("loop");
    mVar strRef = m$.var("strRef");
    mVar strValue = m$.var("strValue");
    m$.newVar(loop,strRef,strValue);
    //<< 
    //<< set strValue = ""
    strValue.set("");
    //<< if $extract(pidField)="P" {
    if (mOp.Equal(m$.Fnc.$extract(pidField.get()),"P")) {
      //<< set strValue = $piece(pidKey,",",$extract(pidField,2,99))
      strValue.set(m$.Fnc.$piece(pidKey.get(),",",m$.Fnc.$extract(pidField.get(),2,99)));
    }
    //<< 
    //<< } elseif $extract(pidField)="D" {
    else if (mOp.Equal(m$.Fnc.$extract(pidField.get()),"D")) {
      //<< set strRef = "^"_pidClass_"("_$select($$$WWW001SharedFile($get(^WWW001(0,pidClass,1))):0,1:YM)_","
      strRef.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",pidClass.get()),"("),m$.Fnc.$select(include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,pidClass.get(),1))),0,1,m$.var("YM").get())),","));
      //<< for loop=1:1:$length(pidKey,",") {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(pidKey.get(),",")));loop.set(mOp.Add(loop.get(),1))) {
        //<< set strRef = strRef_$$$AddQuotes($piece(pidKey,",",loop))_","
        strRef.set(mOp.Concat(mOp.Concat(strRef.get(),include.COMSYS.$$$AddQuotes(m$,m$.Fnc.$piece(pidKey.get(),",",loop.get()))),","));
      }
      //<< }
      //<< set strRef   = strRef_"1)"
      strRef.set(mOp.Concat(strRef.get(),"1)"));
      //<< set strValue = $piece($get(@strRef),Y,$extract(pidField,2,99))
      strValue.set(m$.Fnc.$piece(m$.Fnc.$get(m$.indirectVar(strRef.get())),m$.var("Y").get(),m$.Fnc.$extract(pidField.get(),2,99)));
    }
    //<< }
    //<< quit strValue
    return strValue.get();
  }

  //<< 
  //<< 
  //<< MatchClasses(pidClass,plstProperties,pstrSafeMode=0,pblnWhereUsed=$$$NO)
  public Object MatchClasses(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar plstProperties = m$.newVarRef("plstProperties",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrSafeMode = m$.newVarRef("pstrSafeMode",(((_p!=null)&&(_p.length>=3))?_p[2]:null),0);
    mVar pblnWhereUsed = m$.newVarRef("pblnWhereUsed",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Matches properties from other classes for the sql statement
    //<< ;
    //<< ; Example
    //<< ; pidClass: "INAUFP"
    //<< ; property: "P1.CINAUFPA.D61"
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 27-Oct-2006   JW      SR15152: Initialise idKey inside loop
    //<< ; 25-Oct-2006   RPW     SR14709: Removed #define and modified $$$Where calls
    //<< ; 13-Oct-2006   Steve S SR15085: Only use indirection for non-string literals
    //<< ;                           and non-pure numerics
    //<< ; 07-Apr-2005   Paul K  Classes with multi-primary keys are now matched properly.
    //<< ; 14-Mar-2005   Paul K  Need to use $$$Where instead of hardcoded and
    //<< ; 09-Feb-2005   PO      SR10965 Adding support for related classes.
    //<< ;-------------------------------------------------------------------------------
    //<< new arrClasses,idClass,idField,idKey,idKey2,loop,objField,objField2
    mVar arrClasses = m$.var("arrClasses");
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar idKey = m$.var("idKey");
    mVar idKey2 = m$.var("idKey2");
    mVar loop = m$.var("loop");
    mVar objField = m$.var("objField");
    mVar objField2 = m$.var("objField2");
    m$.newVar(arrClasses,idClass,idField,idKey,idKey2,loop,objField,objField2);
    //<< new strRef,strRefVal,strSQL
    mVar strRef = m$.var("strRef");
    mVar strRefVal = m$.var("strRefVal");
    mVar strSQL = m$.var("strSQL");
    m$.newVar(strRef,strRefVal,strSQL);
    //<< 
    //<< set strSQL=""
    strSQL.set("");
    //<< 
    //<< for loop=1:1:$listlength(plstProperties) {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(plstProperties.get())));loop.set(mOp.Add(loop.get(),1))) {
      //<< set idClass = pidClass
      idClass.set(pidClass.get());
      //<< set idField = $listget(plstProperties,loop)
      idField.set(m$.Fnc.$listget(plstProperties.get(),loop.get()));
      //<< 
      //<< ; FIXME : <GRF> GetRelation^COMViewUtils is a function.
      //<< do GetRelation^COMViewUtils(.idClass,idField)
      m$.Cmd.Do("COMViewUtils.GetRelation",idClass,idField.get());
      //<< if (idClass'="") && '$data(arrClasses(idClass)) {
      if ((mOp.NotEqual(idClass.get(),"")) && mOp.Not(m$.Fnc.$data(arrClasses.var(idClass.get())))) {
        //<< set arrClasses(idClass)=""
        arrClasses.var(idClass.get()).set("");
        //<< if '$$$WWW001SharedFile($get(^WWW001(0,idClass,1))) set strSQL=strSQL_$$$Where(pblnWhereUsed)_idClass_".company = "_YM_" "
        if (mOp.Not(include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,idClass.get(),1))))) {
          strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strSQL.get(),$$$Where(m$,pblnWhereUsed)),idClass.get()),".company = "),m$.var("YM").get())," "));
        }
        //<< 
        //<< if $find(idField,".C") {
        if (mOp.Logical(m$.Fnc.$find(idField.get(),".C"))) {
          //<< ;for each primary key on the related class, find a matching property on the passed in class.
          //<< for idKey=1:1:$order(^WWW002(0,idClass,""),-1) {
          for (idKey.set(1);(mOp.LessOrEqual(idKey.get(),m$.Fnc.$order(m$.var("^WWW002",0,idClass.get(),""),mOp.Negative(1))));idKey.set(mOp.Add(idKey.get(),1))) {
            //<< set objField = $get(^WWW002(0,idClass,idKey,1))
            objField.set(m$.Fnc.$get(m$.var("^WWW002",0,idClass.get(),idKey.get(),1)));
            //<< if $$$WWW002RelationClass(objField)'="" {
            if (mOp.NotEqual(include.WWWConst.$$$WWW002RelationClass(m$,objField),"")) {
              //<< if $$$WWW002RelationClass(objField)=pidClass {  ;use last primary key on main class
              if (mOp.Equal(include.WWWConst.$$$WWW002RelationClass(m$,objField),pidClass.get())) {
                //<< set strSQL = strSQL_$$LinkClass(idClass,idKey,pidClass,$order(^WWW002(0,pidClass,""),-1),.pblnWhereUsed)
                strSQL.set(mOp.Concat(strSQL.get(),m$.fnc$("LinkClass",idClass.get(),idKey.get(),pidClass.get(),m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),""),mOp.Negative(1)),pblnWhereUsed)));
              }
              //<< 
              //<< } else {  ;look on main class for this class
              else {
                //<< for idKey2=1:1:$order(^WWW002(0,pidClass,""),-1) {
                for (idKey2.set(1);(mOp.LessOrEqual(idKey2.get(),m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),""),mOp.Negative(1))));idKey2.set(mOp.Add(idKey2.get(),1))) {
                  //<< set objField2 = $get(^WWW002(0,pidClass,idKey2,1))
                  objField2.set(m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),idKey2.get(),1)));
                  //<< if $$$WWW002RelationClass(objField2)=$$$WWW002RelationClass(objField) {
                  if (mOp.Equal(include.WWWConst.$$$WWW002RelationClass(m$,objField2),include.WWWConst.$$$WWW002RelationClass(m$,objField))) {
                    //<< set strSQL = strSQL_$$LinkClass(idClass,idKey,pidClass,idKey2,.pblnWhereUsed)
                    strSQL.set(mOp.Concat(strSQL.get(),m$.fnc$("LinkClass",idClass.get(),idKey.get(),pidClass.get(),idKey2.get(),pblnWhereUsed)));
                  }
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
        //<< } elseif $extract(idField)="P" {
        else if (mOp.Equal(m$.Fnc.$extract(idField.get()),"P")) {
          //<< for idKey=1:1:$order(^WWW002(0,pidClass,""),-1) {
          for (idKey.set(1);(mOp.LessOrEqual(idKey.get(),m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),""),mOp.Negative(1))));idKey.set(mOp.Add(idKey.get(),1))) {
            //<< set objField = $get(^WWW002(0,pidClass,idKey,1))
            objField.set(m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),idKey.get(),1)));
            //<< if $$$WWW002RelationClass(objField)'="" {
            if (mOp.NotEqual(include.WWWConst.$$$WWW002RelationClass(m$,objField),"")) {
              //<< if $$$WWW002RelationClass(objField)=idClass {  ;use last primary key on main class
              if (mOp.Equal(include.WWWConst.$$$WWW002RelationClass(m$,objField),idClass.get())) {
                //<< set strSQL = strSQL_$$LinkClass(idClass,$order(^WWW002(0,idClass,""),-1),pidClass,idKey,.pblnWhereUsed)
                strSQL.set(mOp.Concat(strSQL.get(),m$.fnc$("LinkClass",idClass.get(),m$.Fnc.$order(m$.var("^WWW002",0,idClass.get(),""),mOp.Negative(1)),pidClass.get(),idKey.get(),pblnWhereUsed)));
              }
              //<< } else {  ;look on main class for this class
              else {
                //<< for idKey2=1:1:$order(^WWW002(0,idClass,""),-1) {
                for (idKey2.set(1);(mOp.LessOrEqual(idKey2.get(),m$.Fnc.$order(m$.var("^WWW002",0,idClass.get(),""),mOp.Negative(1))));idKey2.set(mOp.Add(idKey2.get(),1))) {
                  //<< set objField2 = $get(^WWW002(0,idClass,idKey2,1))
                  objField2.set(m$.Fnc.$get(m$.var("^WWW002",0,idClass.get(),idKey2.get(),1)));
                  //<< if $$$WWW002RelationClass(objField2)=$$$WWW002RelationClass(objField) {
                  if (mOp.Equal(include.WWWConst.$$$WWW002RelationClass(m$,objField2),include.WWWConst.$$$WWW002RelationClass(m$,objField))) {
                    //<< set strSQL = strSQL_$$LinkClass(idClass,idKey2,pidClass,idKey,.pblnWhereUsed)
                    strSQL.set(mOp.Concat(strSQL.get(),m$.fnc$("LinkClass",idClass.get(),idKey2.get(),pidClass.get(),idKey.get(),pblnWhereUsed)));
                  }
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
        //<< } else {
        else {
          //<< set objField = $$GetRelation^COMViewUtils(pidClass,$piece(idField,".",1))
          objField.set(m$.fnc$("COMViewUtils.GetRelation",pidClass.get(),m$.Fnc.$piece(idField.get(),".",1)));
          //<< set idKey = 0
          idKey.set(0);
          //<< if $$$WWW003RelationalPrimaryKeys(objField)'="" {
          if (mOp.NotEqual(include.WWWConst.$$$WWW003RelationalPrimaryKeys(m$,objField),"")) {
            //<< for idKey=1:1:$length($$$WWW003RelationalPrimaryKeys(objField),",") {
            for (idKey.set(1);(mOp.LessOrEqual(idKey.get(),m$.Fnc.$length(include.WWWConst.$$$WWW003RelationalPrimaryKeys(m$,objField),",")));idKey.set(mOp.Add(idKey.get(),1))) {
              //<< set strRef    = $piece($$$WWW003RelationalPrimaryKeys(objField),",")
              strRef.set(m$.Fnc.$piece(include.WWWConst.$$$WWW003RelationalPrimaryKeys(m$,objField),","));
              //<< set strRefVal = $select(((strRef [ $$$DBLQUOTE)||$ISVALIDNUM(strRef)):strRef,$$$YES:@strRef)
              strRefVal.set(m$.Fnc.$select(((mOp.Contains(strRef.get(),include.COMSYSString.$$$DBLQUOTE(m$))) || mOp.Logical(m$.Fnc.$isvalidnum(strRef.get()))),strRef.get(),include.COMSYS.$$$YES(m$),m$.indirectVar(strRef.get()).get()));
              //<< set strSQL    = strSQL_$$$Where(pblnWhereUsed)_idClass_"."_$$$WWW002PropertyName($get(^WWW002(0,idClass,idKey,1)))_" = "_strRefVal_" "
              strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strSQL.get(),$$$Where(m$,pblnWhereUsed)),idClass.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,idClass.get(),idKey.get(),1))))," = "),strRefVal.get())," "));
            }
          }
          //<< }
          //<< }
          //<< if $data(^WWW002(0,idClass,$increment(idKey),1)) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW002",0,idClass.get(),m$.Fnc.$increment(idKey),1)))) {
            //<< set strSQL = strSQL_$$$Where(pblnWhereUsed)_pidClass_"."_$$$WWW002PropertyName(objField)_" = "_idClass_"."_$$$WWW002PropertyName($get(^WWW002(0,idClass,idKey,1)))_" "
            strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strSQL.get(),$$$Where(m$,pblnWhereUsed)),pidClass.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,objField))," = "),idClass.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,idClass.get(),idKey.get(),1))))," "));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit strSQL
    return strSQL.get();
  }

  //<< 
  //<< 
  //<< LinkClass(pidClass,pidKey,pidClass2,pidKey2,pblnWhereUsed)
  public Object LinkClass(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidClass2 = m$.newVarRef("pidClass2",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidKey2 = m$.newVarRef("pidKey2",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnWhereUsed = m$.newVarRef("pblnWhereUsed",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 25-Oct-2006   RPW     SR14709: Removed #define and modified $$$Where calls
    //<< ;-------------------------------------------------------------------------------
    //<< new strSQL
    mVar strSQL = m$.var("strSQL");
    m$.newVar(strSQL);
    //<< 
    //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
      //<< if ((pidClass  = "INReqLine") && (pidKey  = "1") &&
      //<< (pidClass2 = "INReq"    ) && (pidKey2 = "1")) {
      if (mOp.Logical(((mOp.Equal(pidClass.get(),"INReqLine")) && (mOp.Equal(pidKey.get(),"1")) && (mOp.Equal(pidClass2.get(),"INReq")) && (mOp.Equal(pidKey2.get(),"1"))))) {
        //<< set strSQL = $$$Where(pblnWhereUsed)_pidClass_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass,pidKey,1)))_" = "_pidClass2_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass2,pidKey2,1)))_" "
        strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat($$$Where(m$,pblnWhereUsed),pidClass.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),pidKey.get(),1))))," = "),pidClass2.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass2.get(),pidKey2.get(),1))))," "));
      }
      //<< }elseif (pidClass2  = "VARAlertaLocalLinha"){
      else if ((mOp.Equal(pidClass2.get(),"VARAlertaLocalLinha"))) {
        //<< set strSQL = $$$Where(pblnWhereUsed)_pidClass_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass,pidKey,1)))_" = "_pidClass2_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass2,pidKey2,1)))_" "
        strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat($$$Where(m$,pblnWhereUsed),pidClass.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),pidKey.get(),1))))," = "),pidClass2.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass2.get(),pidKey2.get(),1))))," "));
      }
      //<< }elseif ((pidClass  = "INRECLine") && (pidClass2 = "INREC")) {
      else if (mOp.Logical(((mOp.Equal(pidClass.get(),"INRECLine")) && (mOp.Equal(pidClass2.get(),"INREC"))))) {
        //<< set strSQL = $$$Where(pblnWhereUsed)_pidClass_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass,pidKey,1)))_" = "_pidClass2_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass2,pidKey2,1)))_" "
        strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat($$$Where(m$,pblnWhereUsed),pidClass.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),pidKey.get(),1))))," = "),pidClass2.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass2.get(),pidKey2.get(),1))))," "));
      }
      //<< }elseif ((pidClass  = "INAUFP") && (pidClass2 = "INAUF" )) {
      else if (mOp.Logical(((mOp.Equal(pidClass.get(),"INAUFP")) && (mOp.Equal(pidClass2.get(),"INAUF"))))) {
        //<< set strSQL = $$$Where(pblnWhereUsed)_pidClass_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass,pidKey,1)))_" = "_pidClass2_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass2,pidKey2,1)))_" "
        strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat($$$Where(m$,pblnWhereUsed),pidClass.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),pidKey.get(),1))))," = "),pidClass2.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass2.get(),pidKey2.get(),1))))," "));
      }
      //<< }else {
      else {
        //<< set strSQL = $$$Where(pblnWhereUsed)_"$$Index^COMUtils("_pidClass_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass,pidKey,1)))_") = $$Index^COMUtils("_pidClass2_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass2,pidKey2,1)))_") "  ;SR17225
        strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat($$$Where(m$,pblnWhereUsed),"$$Index^COMUtils("),pidClass.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),pidKey.get(),1)))),") = $$Index^COMUtils("),pidClass2.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass2.get(),pidKey2.get(),1)))),") "));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set strSQL = $$$Where(pblnWhereUsed)_pidClass_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass,pidKey,1)))_" = "_pidClass2_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass2,pidKey2,1)))_" "
      strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat($$$Where(m$,pblnWhereUsed),pidClass.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),pidKey.get(),1))))," = "),pidClass2.get()),"."),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass2.get(),pidKey2.get(),1))))," "));
    }
    //<< }
    //<< ;SR17225 set strSQL = $$$Where(pblnWhereUsed)_"$$Index^COMUtils("_pidClass_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass,pidKey,1)))_") = $$Index^COMUtils("_pidClass2_"."_$$$WWW002PropertyName($get(^WWW002(0,pidClass2,pidKey2,1)))_") "  ;SR17225
    //<< 
    //<< quit strSQL
    return strSQL.get();
  }

  //<< 
  //<< 
  //<< SQLClass(pidClass)
  public Object SQLClass(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert class into sql class. Supports Views
    //<< ;
    //<< ; Params:   Class id
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  sql id
    //<< ;
    //<< ; History:
    //<< ; 09-Sep-2008   PP      SR15866: Update COMView to Objects
    //<< ; 22-Jun-2006   Pablo   SR14221: Removed hard coding 'User' package
    //<< ; 17-May-2006   Steve S SR14649: Only add package if it's available
    //<< ; 19-Apr-2006   JW      SR14429: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objCompiledClass,strPackage
    mVar objCompiledClass = m$.var("objCompiledClass");
    mVar strPackage = m$.var("strPackage");
    m$.newVar(objCompiledClass,strPackage);
    //<< 
    //<< if $extract(pidClass,1,4)="VIEW" {
    if (mOp.Equal(m$.Fnc.$extract(pidClass.get(),1,4),"VIEW")) {
      //<< set $extract(pidClass,1,4) = ""
      mVar $extract = m$.var("$extract");
      $extract.var(pidClass.get(),1,4).set("");
    }
    //<< }
    //<< 
    //<< if +$get(^CacheTempObj(YUSER,"Object")) quit pidClass
    if (mOp.Logical(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object"))))) {
      return pidClass.get();
    }
    //<< 
    //<< set strPackage = $get(^CacheTempView(YUSER,"Package"))
    strPackage.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Package")));
    //<< 
    //<< if ($length(pidClass, ".") > 1) {
    if ((mOp.Greater(m$.Fnc.$length(pidClass.get(),"."),1))) {
      //<< if ##Class(%Dictionary.CompiledClass).%ExistsId(pidClass) {
      if (mOp.Logical(m$.fnc$("$Dictionary.CompiledClass.$ExistsId",pidClass.get()))) {
        //<< set objCompiledClass = ##Class(%Dictionary.CompiledClass).%OpenId(pidClass)
        objCompiledClass.set(m$.fnc$("$Dictionary.CompiledClass.$OpenId",pidClass.get()));
        //<< set pidClass         = objCompiledClass.SqlTableName
        pidClass.set(m$.prop(objCompiledClass.get(),"SqlTableName").get());
        //<< do objCompiledClass.%Close()
        m$.Cmd.Do(objCompiledClass.getORef(),"$Close");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if strPackage'="" set pidClass = strPackage_"."_pidClass
    if (mOp.NotEqual(strPackage.get(),"")) {
      pidClass.set(mOp.Concat(mOp.Concat(strPackage.get(),"."),pidClass.get()));
    }
    //<< 
    //<< quit pidClass
    return pidClass.get();
  }

  //<< 
  //<< 
  //<< ; FIXME : Inconsistencies in which parameters are ByRef when ConvertField is called - review and correct. <GRF>
  //<< 
  //<< ConvertField(pidClass,pstrField,pstrValue="",pstrComp="",
  //<< penumInputType="",pstrSafeMode=$$$NO,pblnOrderBy=$$$NO,
  //<< pblnDisplay=$$$YES)
  public Object ConvertField(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstrComp = m$.newVarRef("pstrComp",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar penumInputType = m$.newVarRef("penumInputType",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pstrSafeMode = m$.newVarRef("pstrSafeMode",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$NO(m$));
    mVar pblnOrderBy = m$.newVarRef("pblnOrderBy",(((_p!=null)&&(_p.length>=7))?_p[6]:null),include.COMSYS.$$$NO(m$));
    mVar pblnDisplay = m$.newVarRef("pblnDisplay",(((_p!=null)&&(_p.length>=8))?_p[7]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; This method attempts to optimise SQL searching by adding %upper and other
    //<< ; functions so that indexes are used correctly.
    //<< ;
    //<< ; History:
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag for WWWTR calls
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 17-Nov-2009   GRF     SR16871: convert »CostCentre« into YLOCATION value
    //<< ;                           (allow US spelling as well as English); replace
    //<< ;                           $$$Add with $$$AddQuotes
    //<< ; 17-Sep-2009   shobby  SR16708: Translate the entered value if searching on barcodes.
    //<< ; 30-Jun-2009   shobby  SR16696: Get 'Within' working.
    //<< ; 12-Mar-2009   PPP     SR16397: converted time to internal for SQL queries
    //<< ; 18-Feb-2009   HQN     SR16359: Removed null case for dates, now handled in
    //<< ;                           ^GenerateSQL()
    //<< ; 02-Oct-2008   HQN     SR15915: removing SQL building logic for null value
    //<< ;                           checks, now done inside GenerateSQL
    //<< ;                           Side Effect of:
    //<< ;                               $$$EnumCOMVIEWCOMPARATORNotEquals
    //<< ;                               $$$EnumCOMVIEWCOMPARATOREquals
    //<< ;                           Now built correctly in GenerateSQL no longer need
    //<< ;                           boolean translates
    //<< ; 09-Sep-2008   PP      SR15866:Update COMView to Objects
    //<< ; 26-Aug-2008   shobby  BR014967: Allow the option of 'ShowAll' on checkbox selectors.
    //<< ; 13-Mar-2007   HeberB  BR014367: Add call to translate chars no accent mark, if required
    //<< ; 05-Mar-2007   PO      SR15466: For date fields instead of just %upper(+$p({Field},".",1))=""
    //<< ;                           ... (%upper(+$p({Field},".",1)) = "" or {Field} is null)
    //<< ; 30-Nov-2006   RPW     SR14709: Type 1 works like type 14.
    //<< ; 01-Nov-2006   JW      SR15166: Use less likely characters for variable indirection.
    //<< ; 25-Oct-2006   RPW     SR14709: Cleaned up multi use of commands, and put them into variables.
    //<< ;                           Also made = work correctly on date handling.
    //<< ; 29-May-2006   Steve S SR14675: Support 'like' clause
    //<< ; 19-Apr-2006   JW      SR14429: Support for views
    //<< ; 24-Mar-2006   JW      SR14422: Override for date (counter)
    //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
    //<< ; 11-May-2005   Paul K  SR12199: Added Case insensitivity to everything but
    //<< ;                           primary key fields that don't have an index on them
    //<< ;                           and don't have Input type as BIG or BIGANDNOSPACE
    //<< ; 10-May-2005   Paul K  SR12199: Added "Change Input Type As" support.
    //<< ; 09-Mar-2005   Paul K  SR11860: Fixed error when ordering by memo fields that
    //<< ;                           are larger than 255 characters.
    //<< ; 28-Feb-2005   Paul K  SR11802: Better handle dates; null comparison.
    //<< ; 20-Dec-2004   Paul K  Added "%" values
    //<< ; 30-Nov-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnObj,idIndexKey,idInputAs,loop,objField,objProperty
    mVar blnObj = m$.var("blnObj");
    mVar idIndexKey = m$.var("idIndexKey");
    mVar idInputAs = m$.var("idInputAs");
    mVar loop = m$.var("loop");
    mVar objField = m$.var("objField");
    mVar objProperty = m$.var("objProperty");
    m$.newVar(blnObj,idIndexKey,idInputAs,loop,objField,objProperty);
    //<< new strField,strKeyCode,strPackage,strPlus,strUCValue,strValue
    mVar strField = m$.var("strField");
    mVar strKeyCode = m$.var("strKeyCode");
    mVar strPackage = m$.var("strPackage");
    mVar strPlus = m$.var("strPlus");
    mVar strUCValue = m$.var("strUCValue");
    mVar strValue = m$.var("strValue");
    m$.newVar(strField,strKeyCode,strPackage,strPlus,strUCValue,strValue);
    //<< 
    //<< set blnObj = +$get(^CacheTempObj(YUSER,"Object"))
    blnObj.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object"))));
    //<< 
    //<< ;if $$IsSearchClass^COMQuickSearch(pidClass) { ;16708
    //<< ;       set pstrValue=$$GetCode^INARTCode(pstrValue) ;16708
    //<< ;} ;16708
    //<< if 'blnObj {
    if (mOp.Not(blnObj.get())) {
      //<< set strKeyCode     = ""
      strKeyCode.set("");
      //<< set objField       = $$GetRelation^COMViewUtils(.pidClass,.pstrField,,.strKeyCode) ; Should this pass 2nd parm for changing
      objField.set(m$.fnc$("COMViewUtils.GetRelation",pidClass,pstrField,null,strKeyCode));
      //<< set penumInputType = $$$WWW002InputType(objField)
      penumInputType.set(include.WWWConst.$$$WWW002InputType(m$,objField));
      //<< 
      //<< // Only use the % check for non-display filters
      //<< if ($extract(pstrValue)="»") && ($extract($reverse(pstrValue))="«") {  ; Used for things like YUSER,YBED,YLOCATION etc...
      if ((mOp.Equal(m$.Fnc.$extract(pstrValue.get()),"»")) && (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(pstrValue.get())),"«"))) {
        //<< set strValue = $extract(pstrValue,2,$length(pstrValue)-1)
        strValue.set(m$.Fnc.$extract(pstrValue.get(),2,mOp.Subtract(m$.Fnc.$length(pstrValue.get()),1)));
        //<< 
        //<< set strUCValue = $zconvert(strValue,"u")                     ; SR16871 vvv
        strUCValue.set(m$.Fnc.$zconvert(strValue.get(),"u"));
        //<< if ((strUCValue="COSTCENTRE") || (strUCValue="COSTCENTER")) && ($data(YLOCATION)=1) {
        if (mOp.Logical(((mOp.Equal(strUCValue.get(),"COSTCENTRE")) || (mOp.Equal(strUCValue.get(),"COSTCENTER")))) && (mOp.Equal(m$.Fnc.$data(m$.var("YLOCATION")),1))) {
          //<< set pstrValue = $$GetCostCentre^INCostCentre(YLOCATION)
          pstrValue.set(m$.fnc$("INCostCentre.GetCostCentre",m$.var("YLOCATION").get()));
        }
        //<< 
        //<< } elseif (strValue'="") && ($data(@strValue)=1) {
        else if ((mOp.NotEqual(strValue.get(),"")) && (mOp.Equal(m$.Fnc.$data(m$.indirectVar(strValue.get())),1))) {
          //<< ;   if (strValue'="") && ($data(@strValue)=1) {              ; SR16871 ^^^
          //<< set pstrValue = @strValue
          pstrValue.set(m$.indirectVar(strValue.get()).get());
        }
      }
      //<< }
      //<< }
      //<< 
      //<< set pidClass  = $$SQLClass(pidClass)
      pidClass.set(m$.fnc$("SQLClass",pidClass.get()));
      //<< set strField  = pidClass_"."_$$$WWW002PropertyName(objField)
      strField.set(mOp.Concat(mOp.Concat(pidClass.get(),"."),include.WWWConst.$$$WWW002PropertyName(m$,objField)));
      //<< set pstrField = strField
      pstrField.set(strField.get());
      //<< 
      //<< set idIndexKey = $$$WWW002IndexKey(objField)
      idIndexKey.set(include.WWWConst.$$$WWW002IndexKey(m$,objField));
      //<< 
      //<< if penumInputType=1 {
      if (mOp.Equal(penumInputType.get(),1)) {
        //<< set pstrField = "$piece("_pstrField_",""."",1)"
        pstrField.set(mOp.Concat(mOp.Concat("$piece(",pstrField.get()),",\".\",1)"));
      }
      //<< }
      //<< 
      //<< if (idIndexKey="") && ($find(",4,8,12,18,",","_penumInputType_",")) {  ;numeric fields
      if ((mOp.Equal(idIndexKey.get(),"")) && mOp.Logical((m$.Fnc.$find(",4,8,12,18,",mOp.Concat(mOp.Concat(",",penumInputType.get()),","))))) {
        //<< set pstrField = "+"_pstrField
        pstrField.set(mOp.Concat("+",pstrField.get()));
      }
      //<< 
      //<< ; FIXME - should first OR be an AND with subsequent clauses being grouped? <GRF>
      //<< ; e.g.          if A && B && (C || D || E || F) {
      //<< ; rather than   if A && B || C || D || E || F {
      //<< ;  C,D,E,F  =  Date/Timestamp or Memo Data field or Text Data field
      //<< } elseif (idIndexKey'="")   && 'pstrSafeMode       ||
      //<< (penumInputType=1) || (penumInputType=14) ||
      //<< ((strKeyCode="D")  && (penumInputType=3)) ||
      //<< ((strKeyCode="D")  && (penumInputType=6))    {
      else if ((mOp.NotEqual(idIndexKey.get(),"")) && mOp.Not(pstrSafeMode.get()) || (mOp.Equal(penumInputType.get(),1)) || (mOp.Equal(penumInputType.get(),14)) || mOp.Logical(((mOp.Equal(strKeyCode.get(),"D")) && (mOp.Equal(penumInputType.get(),3)))) || mOp.Logical(((mOp.Equal(strKeyCode.get(),"D")) && (mOp.Equal(penumInputType.get(),6))))) {
        //<< // The logic is as follows :
        //<< //   if the $horolog format is full format, then just add the field
        //<< //   otherwise do a plus on the field name
        //<< set strPlus=""
        strPlus.set("");
        //<< if (penumInputType=14) || (penumInputType=1) {
        if ((mOp.Equal(penumInputType.get(),14)) || (mOp.Equal(penumInputType.get(),1))) {
          //<< if '$find(pstrValue,",") {
          if (mOp.Not(m$.Fnc.$find(pstrValue.get(),","))) {
            //<< set strPlus = "+"
            strPlus.set("+");
          }
        }
        //<< }
        //<< }
        //<< set pstrField = "%upper("_strPlus_pstrField_")"
        pstrField.set(mOp.Concat(mOp.Concat(mOp.Concat("%upper(",strPlus.get()),pstrField.get()),")"));
      }
      //<< }
      //<< if pblnOrderBy {
      if (mOp.Logical(pblnOrderBy.get())) {
        //<< if penumInputType=3 {
        if (mOp.Equal(penumInputType.get(),3)) {
          //<< set pstrField = "$extract("_pstrField_",1,50)"
          pstrField.set(mOp.Concat(mOp.Concat("$extract(",pstrField.get()),",1,50)"));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if (penumInputType=6) || (penumInputType=3) {                     ; Text/Memo
      if ((mOp.Equal(penumInputType.get(),6)) || (mOp.Equal(penumInputType.get(),3))) {
        //<< set pstrField = $$ToRemoveAccentMark(pstrField)
        pstrField.set(m$.fnc$("ToRemoveAccentMark",pstrField.get()));
        //<< if ((+$$$WWWClientParamCoreChangesSESPE($get(^WWWClientParam(YM,YM,1)))) ||
        //<< (+$$$WWWClientParamCoreChangesSESDF($get(^WWWClientParam(YM,YM,1))))) {
        if ((mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESPE(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESDF(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))))) {
          //<< if strKeyCode="C" set pstrValue = $zconvert(pstrValue,"U")
          if (mOp.Equal(strKeyCode.get(),"C")) {
            pstrValue.set(m$.Fnc.$zconvert(pstrValue.get(),"U"));
          }
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if (pstrComp'="") {
      if ((mOp.NotEqual(pstrComp.get(),""))) {
        //<< if (penumInputType=1) && ($translate(pstrValue," ")'="") {    ; Date   // FIXME JW - temp fix!
        if ((mOp.Equal(penumInputType.get(),1)) && (mOp.NotEqual(m$.Fnc.$translate(pstrValue.get()," "),""))) {
          //<< set pstrValue = $$ConvertDate(pstrValue)
          pstrValue.set(m$.fnc$("ConvertDate",pstrValue.get()));
        }
        //<< 
        //<< } elseif penumInputType=7 {                                   ; Time    ;SR16397
        else if (mOp.Equal(penumInputType.get(),7)) {
          //<< set pstrValue = $$GetInternal^WWWTR(7,pstrValue)
          pstrValue.set(m$.fnc$("WWWTR.GetInternal",7,pstrValue.get()));
        }
        //<< 
        //<< } elseif penumInputType=2 {                                   ; Boolean
        else if (mOp.Equal(penumInputType.get(),2)) {
          //<< if (pstrValue=2) {
          if ((mOp.Equal(pstrValue.get(),2))) {
            //<< set pstrComp  = $$$EnumCOMVIEWCOMPARATORNotEquals
            pstrComp.set(include.COMConst.$$$EnumCOMVIEWCOMPARATORNotEquals(m$));
          }
          //<< 
          //<< } elseif (pstrValue && (pstrComp=$$$EnumCOMVIEWCOMPARATOREquals))    ||
          //<< ('pstrValue && (pstrComp=$$$EnumCOMVIEWCOMPARATORNotEquals))    {
          else if ((mOp.Logical(pstrValue.get()) && (mOp.Equal(pstrComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$)))) || (mOp.Not(pstrValue.get()) && (mOp.Equal(pstrComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORNotEquals(m$))))) {
            //<< set pstrComp  = $$$EnumCOMVIEWCOMPARATOREquals
            pstrComp.set(include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$));
            //<< set pstrValue = 1
            pstrValue.set(1);
          }
          //<< 
          //<< } else {
          else {
            //<< set pstrComp  = $$$EnumCOMVIEWCOMPARATORNotEquals
            pstrComp.set(include.COMConst.$$$EnumCOMVIEWCOMPARATORNotEquals(m$));
            //<< if ((((+$$$WWWClientParamCoreChangesSESPE($get(^WWWClientParam(YM,YM,1)))) ||
            //<< (+$$$WWWClientParamCoreChangesHCB($get(^WWWClientParam(YM,YM,1))))  ||
            //<< (+$$$WWWClientParamCoreChangesSESDF($get(^WWWClientParam(YM,YM,1)))))) &&
            //<< (pidClass = "SQLUser.INReq")) {
            if ((mOp.Logical(((mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESPE(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesHCB(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESDF(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))))) && (mOp.Equal(pidClass.get(),"SQLUser.INReq")))) {
              //<< set pstrValue = ""
              pstrValue.set("");
            }
            //<< }
            //<< else {
            else {
              //<< set pstrValue = 1
              pstrValue.set(1);
            }
          }
        }
        //<< }
        //<< }
        //<< 
        //<< } elseif (penumInputType=14) || (penumInputType=1) {          ; Timestamp or Date ; FIXME : see Date ^^^ <GRF>
        else if ((mOp.Equal(penumInputType.get(),14)) || (mOp.Equal(penumInputType.get(),1))) {
          //<< set pstrValue = """"_$$ConvertDate(pstrValue)_""""
          pstrValue.set(mOp.Concat(mOp.Concat("\"",m$.fnc$("ConvertDate",pstrValue.get())),"\""));
        }
        //<< 
        //<< } else {
        else {
          //<< if $translate(pstrValue," ")="" {
          if (mOp.Equal(m$.Fnc.$translate(pstrValue.get()," "),"")) {
            //<< set pstrValue = $$$AddQuotes(pstrValue)
            pstrValue.set(include.COMSYS.$$$AddQuotes(m$,pstrValue));
          }
          //<< 
          //<< } else {
          else {
            //<< // No index conversion for 'like' clause
            //<< if (idIndexKey'="") && 'pstrSafeMode && (pstrComp'=$$$EnumCOMVIEWCOMPARATORLike) {
            if ((mOp.NotEqual(idIndexKey.get(),"")) && mOp.Not(pstrSafeMode.get()) && (mOp.NotEqual(pstrComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORLike(m$)))) {
              //<< if pstrComp=$$$EnumCOMVIEWCOMPARATORWithin {  ;SR16696
              if (mOp.Equal(pstrComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORWithin(m$))) {
                //<< for loop=1:1:$length(pstrValue,",") {
                for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(pstrValue.get(),",")));loop.set(mOp.Add(loop.get(),1))) {
                  //<< set $piece(pstrValue,",",loop) = $$Index^COMUtils($piece(pstrValue,",",loop))
                  m$.pieceVar(pstrValue,",",loop.get()).set(m$.fnc$("COMUtils.Index",m$.Fnc.$piece(pstrValue.get(),",",loop.get())));
                }
              }
              //<< }
              //<< } else {
              else {
                //<< set pstrValue = $$Index^COMUtils(pstrValue)
                pstrValue.set(m$.fnc$("COMUtils.Index",pstrValue.get()));
              }
            }
            //<< }
            //<< }
            //<< 
            //<< set idInputAs = $$$WWW122ChangeInputAs(objField)
            idInputAs.set(include.WWWConst.$$$WWW122ChangeInputAs(m$,objField));
            //<< 
            //<< if (idInputAs=1) || (strKeyCode="D") {                ; BIG
            if ((mOp.Equal(idInputAs.get(),1)) || (mOp.Equal(strKeyCode.get(),"D"))) {
              //<< set pstrValue = $zconvert(pstrValue,"U")
              pstrValue.set(m$.Fnc.$zconvert(pstrValue.get(),"U"));
            }
            //<< 
            //<< } elseif idInputAs=2 {                                ; small
            else if (mOp.Equal(idInputAs.get(),2)) {
              //<< set pstrValue = $zconvert(pstrValue,"L")
              pstrValue.set(m$.Fnc.$zconvert(pstrValue.get(),"L"));
            }
            //<< 
            //<< } elseif idInputAs=6 {                                ; BIGNOSPACE
            else if (mOp.Equal(idInputAs.get(),6)) {
              //<< set pstrValue = $translate($zconvert(pstrValue,"U")," ","")
              pstrValue.set(m$.Fnc.$translate(m$.Fnc.$zconvert(pstrValue.get(),"U")," ",""));
            }
            //<< }
            //<< if pstrComp'=$$$EnumCOMVIEWCOMPARATORWithin if $find(pstrValue,"""") set pstrValue = $$DoubleQuotes^COMUtilStr(pstrValue) ;SR16696
            if (mOp.NotEqual(pstrComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORWithin(m$))) {
              if (mOp.Logical(m$.Fnc.$find(pstrValue.get(),"\""))) {
                pstrValue.set(m$.fnc$("COMUtilStr.DoubleQuotes",pstrValue.get()));
              }
            }
            //<< set pstrValue = $$$AddQuotes(pstrValue)
            pstrValue.set(include.COMSYS.$$$AddQuotes(m$,pstrValue));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< 
    //<< 
    //<< if blnObj {
    if (mOp.Logical(blnObj.get())) {
      //<< if ($extract(pstrValue)="»") && ($extract($reverse(pstrValue))="«") {  ;Used for things like YUSER,YBED,YLOCATION etc...
      if ((mOp.Equal(m$.Fnc.$extract(pstrValue.get()),"»")) && (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(pstrValue.get())),"«"))) {
        //<< set strValue = $extract(pstrValue,2,$length(pstrValue)-1)
        strValue.set(m$.Fnc.$extract(pstrValue.get(),2,mOp.Subtract(m$.Fnc.$length(pstrValue.get()),1)));
        //<< 
        //<< set strUCValue = $zconvert(strValue,"u")                     ; SR16871 vvv
        strUCValue.set(m$.Fnc.$zconvert(strValue.get(),"u"));
        //<< if ((strUCValue="COSTCENTRE") || (strUCValue="COSTCENTER")) && ($data(YLOCATION)=1) {
        if (mOp.Logical(((mOp.Equal(strUCValue.get(),"COSTCENTRE")) || (mOp.Equal(strUCValue.get(),"COSTCENTER")))) && (mOp.Equal(m$.Fnc.$data(m$.var("YLOCATION")),1))) {
          //<< set pstrValue = $$GetCostCentre^INCostCentre(YLOCATION)
          pstrValue.set(m$.fnc$("INCostCentre.GetCostCentre",m$.var("YLOCATION").get()));
        }
        //<< 
        //<< } elseif (strValue'="") && ($data(@strValue)=1) {
        else if ((mOp.NotEqual(strValue.get(),"")) && (mOp.Equal(m$.Fnc.$data(m$.indirectVar(strValue.get())),1))) {
          //<< ;   if (strValue'="") && ($data(@strValue)=1) {              ; SR16871 ^^^
          //<< set pstrValue = @strValue
          pstrValue.set(m$.indirectVar(strValue.get()).get());
        }
      }
      //<< }
      //<< }
      //<< 
      //<< set objProperty    = ##class(%Library.PropertyDefinition).%OpenId(pidClass_":"_pstrField)
      objProperty.set(m$.fnc$("$Library.PropertyDefinition.$OpenId",mOp.Concat(mOp.Concat(pidClass.get(),":"),pstrField.get())));
      //<< set penumInputType = objProperty.Type
      penumInputType.set(m$.prop(objProperty.get(),"Type").get());
      //<< 
      //<< set pidClass  = $$SQLClass^COMViewSQL(pidClass)
      pidClass.set(m$.fnc$("COMViewSQL.SQLClass",pidClass.get()));
      //<< set strField  = pidClass_"."_pstrField
      strField.set(mOp.Concat(mOp.Concat(pidClass.get(),"."),pstrField.get()));
      //<< set pstrField = strField
      pstrField.set(strField.get());
      //<< 
      //<< if penumInputType="alSYS.dt.dtDate" {
      if (mOp.Equal(penumInputType.get(),"alSYS.dt.dtDate")) {
        //<< set pstrField = pstrField
        pstrField.set(pstrField.get());
      }
      //<< }
      //<< 
      //<< if $find(",alSYS.dt.dtFloat,alSYS.dt.dtCurrency,alSYS.dt.dtInteger,",","_penumInputType_",") {  //numeric fields
      if (mOp.Logical(m$.Fnc.$find(",alSYS.dt.dtFloat,alSYS.dt.dtCurrency,alSYS.dt.dtInteger,",mOp.Concat(mOp.Concat(",",penumInputType.get()),",")))) {
        //<< set pstrField = "+"_pstrField
        pstrField.set(mOp.Concat("+",pstrField.get()));
      }
      //<< 
      //<< } elseif ('pstrSafeMode)||$find(",alSYS.dt.dtDate, alSYS.dt.dtTimeStamp, alSYS.dt.dtTime, alSYS.dt.dtString,",","_penumInputType_",") {
      else if ((mOp.Not(pstrSafeMode.get())) || mOp.Logical(m$.Fnc.$find(",alSYS.dt.dtDate, alSYS.dt.dtTimeStamp, alSYS.dt.dtTime, alSYS.dt.dtString,",mOp.Concat(mOp.Concat(",",penumInputType.get()),",")))) {
        //<< set strPlus = ""
        strPlus.set("");
        //<< if $find(",alSYS.dt.dtDate, alSYS.dt.dtTimeStamp,alSYS.dt.dtTime,",","_penumInputType_",") {
        if (mOp.Logical(m$.Fnc.$find(",alSYS.dt.dtDate, alSYS.dt.dtTimeStamp,alSYS.dt.dtTime,",mOp.Concat(mOp.Concat(",",penumInputType.get()),",")))) {
          //<< if '$find(pstrValue,",") {
          if (mOp.Not(m$.Fnc.$find(pstrValue.get(),","))) {
            //<< set strPlus = ""
            strPlus.set("");
          }
        }
        //<< }
        //<< }
        //<< //  set pstrField = "%upper("_strPlus_pstrField_")"
        //<< set pstrField = strPlus_pstrField
        pstrField.set(mOp.Concat(strPlus.get(),pstrField.get()));
      }
      //<< }
      //<< 
      //<< if pblnOrderBy {    //Truncate if Order By
      if (mOp.Logical(pblnOrderBy.get())) {
        //<< if penumInputType = "alSYS.dt.dtString" {
        if (mOp.Equal(penumInputType.get(),"alSYS.dt.dtString")) {
          //<< set pstrField = "$extract("_pstrField_",1,50)"
          pstrField.set(mOp.Concat(mOp.Concat("$extract(",pstrField.get()),",1,50)"));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if penumInputType = "alSYS.dt.dtString" {
      if (mOp.Equal(penumInputType.get(),"alSYS.dt.dtString")) {
        //<< set pstrField = $$ToRemoveAccentMark^COMViewSQL(pstrField)
        pstrField.set(m$.fnc$("COMViewSQL.ToRemoveAccentMark",pstrField.get()));
      }
      //<< }
      //<< 
      //<< if (pstrComp'="") {
      if ((mOp.NotEqual(pstrComp.get(),""))) {
        //<< if penumInputType = "alSYS.dt.dtDate" && ($translate(pstrValue," ")'="") {       // Date
        if (mOp.Equal(penumInputType.get(),"alSYS.dt.dtDate") && (mOp.NotEqual(m$.Fnc.$translate(pstrValue.get()," "),""))) {
          //<< set pstrValue = $$ConvertDate^COMViewSQL(pstrValue)
          pstrValue.set(m$.fnc$("COMViewSQL.ConvertDate",pstrValue.get()));
        }
        //<< 
        //<< } elseif penumInputType = "alSYS.dt.dtTime" && ($translate(pstrValue," ")'="") { // Time
        else if (mOp.Equal(penumInputType.get(),"alSYS.dt.dtTime") && (mOp.NotEqual(m$.Fnc.$translate(pstrValue.get()," "),""))) {
          //<< set pstrValue = $$ConvertTime^COMViewObject(pstrValue)
          pstrValue.set(m$.fnc$("COMViewObject.ConvertTime",pstrValue.get()));
        }
        //<< 
        //<< } elseif penumInputType = "alSYS.dt.dtBoolean" {                                 // Boolean
        else if (mOp.Equal(penumInputType.get(),"alSYS.dt.dtBoolean")) {
          //<< if (pstrValue=2) {
          if ((mOp.Equal(pstrValue.get(),2))) {
            //<< set pstrComp  = $$$EnumCOMVIEWCOMPARATORNotEquals
            pstrComp.set(include.COMConst.$$$EnumCOMVIEWCOMPARATORNotEquals(m$));
          }
          //<< 
          //<< } elseif (pstrValue && (pstrComp=$$$EnumCOMVIEWCOMPARATOREquals))    ||
          //<< ('pstrValue && (pstrComp=$$$EnumCOMVIEWCOMPARATORNotEquals))    {
          else if ((mOp.Logical(pstrValue.get()) && (mOp.Equal(pstrComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$)))) || (mOp.Not(pstrValue.get()) && (mOp.Equal(pstrComp.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORNotEquals(m$))))) {
            //<< set pstrComp  = $$$EnumCOMVIEWCOMPARATOREquals
            pstrComp.set(include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$));
            //<< set pstrValue = 1
            pstrValue.set(1);
          }
          //<< 
          //<< } else {
          else {
            //<< set pstrComp  = $$$EnumCOMVIEWCOMPARATORNotEquals
            pstrComp.set(include.COMConst.$$$EnumCOMVIEWCOMPARATORNotEquals(m$));
            //<< set pstrValue = 1
            pstrValue.set(1);
          }
        }
        //<< }
        //<< 
        //<< } elseif (penumInputType="alSYS.dt.dtDate") || (penumInputType="alSYS.dt.dtTimeStamp") {    //Timestamp
        else if ((mOp.Equal(penumInputType.get(),"alSYS.dt.dtDate")) || (mOp.Equal(penumInputType.get(),"alSYS.dt.dtTimeStamp"))) {
          //<< set pstrValue = """"_$$ConvertDate^COMViewSQL(pstrValue)_""""
          pstrValue.set(mOp.Concat(mOp.Concat("\"",m$.fnc$("COMViewSQL.ConvertDate",pstrValue.get())),"\""));
          //<< if pstrValue="""""" {
          if (mOp.Equal(pstrValue.get(),"\"\"")) {
            //<< set pstrField = "("_pstrField
            pstrField.set(mOp.Concat("(",pstrField.get()));
            //<< set pstrValue = pstrValue_" or "_strField_" is null)"
            pstrValue.set(mOp.Concat(mOp.Concat(mOp.Concat(pstrValue.get()," or "),strField.get())," is null)"));
          }
        }
        //<< }
        //<< 
        //<< } elseif (penumInputType="alSYS.dt.dtTime") {   //Time
        else if ((mOp.Equal(penumInputType.get(),"alSYS.dt.dtTime"))) {
          //<< set pstrValue = """"_$$ConvertTime^COMViewObject(pstrValue)_""""
          pstrValue.set(mOp.Concat(mOp.Concat("\"",m$.fnc$("COMViewObject.ConvertTime",pstrValue.get())),"\""));
          //<< if pstrValue = """""" {
          if (mOp.Equal(pstrValue.get(),"\"\"")) {
            //<< set pstrField = "("_pstrField
            pstrField.set(mOp.Concat("(",pstrField.get()));
            //<< set pstrValue = pstrValue_" or "_strField_" is null)"
            pstrValue.set(mOp.Concat(mOp.Concat(mOp.Concat(pstrValue.get()," or "),strField.get())," is null)"));
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< if $translate(pstrValue," ")="" {
          if (mOp.Equal(m$.Fnc.$translate(pstrValue.get()," "),"")) {
            //<< set pstrValue = $$$AddQuotes(pstrValue)
            pstrValue.set(include.COMSYS.$$$AddQuotes(m$,pstrValue));
          }
          //<< 
          //<< } else {
          else {
            //<< if $find(pstrValue,"""") set pstrValue = $$DoubleQuotes^COMUtilStr(pstrValue)
            if (mOp.Logical(m$.Fnc.$find(pstrValue.get(),"\""))) {
              pstrValue.set(m$.fnc$("COMUtilStr.DoubleQuotes",pstrValue.get()));
            }
            //<< set pstrValue = $translate(pstrValue,$$$DBLQUOTE)
            pstrValue.set(m$.Fnc.$translate(pstrValue.get(),include.COMSYSString.$$$DBLQUOTE(m$)));
            //<< set pstrValue = $$$AddQuotes(pstrValue)
            pstrValue.set(include.COMSYS.$$$AddQuotes(m$,pstrValue));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ConvertDate(pstrDate="")
  public Object ConvertDate(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;----------------------------------------------------------------------------
    //<< ; Convert a date
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag for WWWTR calls
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 18-May-2009   GRF     SR16545: use strOffset
    //<< ; 18-May-2009   PPP     SR16545: As date filter can be a numeric, check if
    //<< ;                           is <1000 and add $h
    //<< ; 30-Nov-2006   RPW     SR14709: Don't touch dates with & in them
    //<< ;-------------------------------------------------------------------------------
    //<< new strOffset
    mVar strOffset = m$.var("strOffset");
    m$.newVar(strOffset);
    //<< 
    //<< set pstrDate  = $zconvert(pstrDate,"U")
    pstrDate.set(m$.Fnc.$zconvert(pstrDate.get(),"U"));
    //<< set strOffset = $translate(pstrDate," ")
    strOffset.set(m$.Fnc.$translate(pstrDate.get()," "));
    //<< 
    //<< if $find(pstrDate,"W") {
    if (mOp.Logical(m$.Fnc.$find(pstrDate.get(),"W"))) {
      //<< set pstrDate = $$AddWeek^COMUtilDate(+$horolog,$piece(pstrDate,"W",1),$piece(pstrDate,"W",2))
      pstrDate.set(m$.fnc$("COMUtilDate.AddWeek",mOp.Positive(m$.Fnc.$horolog()),m$.Fnc.$piece(pstrDate.get(),"W",1),m$.Fnc.$piece(pstrDate.get(),"W",2)));
    }
    //<< 
    //<< } elseif $find(pstrDate,"M") {
    else if (mOp.Logical(m$.Fnc.$find(pstrDate.get(),"M"))) {
      //<< set pstrDate = $$AddMonth^COMUtilDate(+$horolog,$piece(pstrDate,"M",1),$piece(pstrDate,"M",2))
      pstrDate.set(m$.fnc$("COMUtilDate.AddMonth",mOp.Positive(m$.Fnc.$horolog()),m$.Fnc.$piece(pstrDate.get(),"M",1),m$.Fnc.$piece(pstrDate.get(),"M",2)));
    }
    //<< 
    //<< } elseif '$find(pstrDate,"&") && (+strOffset=strOffset) {
    else if (mOp.Not(m$.Fnc.$find(pstrDate.get(),"&")) && (mOp.Equal(mOp.Positive(strOffset.get()),strOffset.get()))) {
      //<< set:strOffset<10000 pstrDate = $$GetInternal^WWWTR(1,$horolog+strOffset)
      if (mOp.Less(strOffset.get(),10000)) {
        pstrDate.set(m$.fnc$("WWWTR.GetInternal",1,mOp.Add(m$.Fnc.$horolog(),strOffset.get())));
      }
    }
    //<< 
    //<< } elseif '$find(pstrDate,"&") {
    else if (mOp.Not(m$.Fnc.$find(pstrDate.get(),"&"))) {
      //<< set pstrDate = $$GetInternal^WWWTR(1,pstrDate)
      pstrDate.set(m$.fnc$("WWWTR.GetInternal",1,pstrDate.get()));
    }
    //<< }
    //<< quit pstrDate
    return pstrDate.get();
  }

  //<< 
  //<< 
  //<< Group()
  public Object Group() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines whether the SQL statement is grouping on a property, if it is
    //<< ; then return true.
    //<< ;
    //<< ; Returns:Boolean
    //<< ;
    //<< ; History:
    //<< ; 17-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idFilter,loop,strFilterType
    mVar idFilter = m$.var("idFilter");
    mVar loop = m$.var("loop");
    mVar strFilterType = m$.var("strFilterType");
    m$.newVar(idFilter,loop,strFilterType);
    //<< 
    //<< set idFilter = ""
    idFilter.set("");
    //<< for loop=1:1:$length("FixedFilter,Filter",",") {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length("FixedFilter,Filter",",")));loop.set(mOp.Add(loop.get(),1))) {
      //<< set strFilterType = $piece("FixedFilter,Filter",",",loop)
      strFilterType.set(m$.Fnc.$piece("FixedFilter,Filter",",",loop.get()));
      //<< for {
      for (;true;) {
        //<< set idFilter = $order(^CacheTempView(YUSER,strFilterType,idFilter))
        idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),strFilterType.get(),idFilter.get())));
        //<< quit:idFilter=""
        if (mOp.Equal(idFilter.get(),"")) {
          break;
        }
        //<< quit:$$$COMViewFilterGroupBy($get(^CacheTempView(YUSER,strFilterType,idFilter)))
        if (mOp.Logical(include.COMConst.$$$COMViewFilterGroupBy(m$,m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),strFilterType.get(),idFilter.get()))))) {
          break;
        }
      }
      //<< }
      //<< quit:idFilter'=""
      if (mOp.NotEqual(idFilter.get(),"")) {
        break;
      }
    }
    //<< }
    //<< quit idFilter'=""
    return mOp.NotEqual(idFilter.get(),"");
  }

  //<< 
  //<< 
  //<< LastWhereClause(&pstrWhere)
  public Object LastWhereClause(Object ... _p) {
    mVar pstrWhere = m$.newVarRef("pstrWhere",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns the last where claused used, if there has been a search
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:   pstrWhere (the clause)
    //<< ;
    //<< ; Returns:  boolean - whether there was a previous SQL search at all
    //<< ;
    //<< ; History:
    //<< ; 25-Aug-2006   JW      SR14763: Moved from COMViewFilterColumn, rewrote, added group by.
    //<< ; 13-Jun-2006   Steve S SR14613: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnSQL,idx,strSQL
    mVar blnSQL = m$.var("blnSQL");
    mVar idx = m$.var("idx");
    mVar strSQL = m$.var("strSQL");
    m$.newVar(blnSQL,idx,strSQL);
    //<< 
    //<< set blnSQL    = $$$NO
    blnSQL.set(include.COMSYS.$$$NO(m$));
    //<< set pstrWhere = ""
    pstrWhere.set("");
    //<< 
    //<< set idx = $get(^CacheTempView(YUSER,"LastSQL"))
    idx.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"LastSQL")));
    //<< if (idx'="") {
    if ((mOp.NotEqual(idx.get(),""))) {
      //<< set strSQL = $get(^CacheTempView(YUSER,"History",idx,"SQL"))
      strSQL.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"History",idx.get(),"SQL")));
      //<< if strSQL'="" {
      if (mOp.NotEqual(strSQL.get(),"")) {
        //<< set blnSQL = $$$YES
        blnSQL.set(include.COMSYS.$$$YES(m$));
        //<< 
        //<< set pstrWhere = $piece(strSQL," where ",2)
        pstrWhere.set(m$.Fnc.$piece(strSQL.get()," where ",2));
        //<< set pstrWhere = $piece(pstrWhere," order by ",1)
        pstrWhere.set(m$.Fnc.$piece(pstrWhere.get()," order by ",1));
        //<< set pstrWhere = $piece(pstrWhere," group by ",1)
        pstrWhere.set(m$.Fnc.$piece(pstrWhere.get()," group by ",1));
      }
    }
    //<< }
    //<< }
    //<< quit blnSQL
    return blnSQL.get();
  }

  //<< 
  //<< 
  //<< RemoveMark(pstrValue,pidCompany=0,pstrNamespace="")
  public Object RemoveMark(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=2))?_p[1]:null),0);
    mVar pstrNamespace = m$.newVarRef("pstrNamespace",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns string with no accent marks
    //<< ;
    //<< ; Params: pstrValue
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  string
    //<< ;
    //<< ; History:
    //<< ; 20-Apr-2007   HeberB  BR014367: Added YUCI subscript to CacheTempWWWUMLAU
    //<< ; 03-Apr-2007   HeberB  BR014367: improve performance
    //<< ; 27-Mar-2007   HeberB  BR014367: use of CacheTempWWWUMLAU
    //<< ; 21-Mar-2007   HeberB  BR014367: fix boolean usage - stop using floating vars
    //<< ; 09-Mar-2007   HeberB  BR014367: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idWWWUMLAU,objWWWUMLAU,strAccentMark,strNoAccentMark,strResult
    mVar idWWWUMLAU = m$.var("idWWWUMLAU");
    mVar objWWWUMLAU = m$.var("objWWWUMLAU");
    mVar strAccentMark = m$.var("strAccentMark");
    mVar strNoAccentMark = m$.var("strNoAccentMark");
    mVar strResult = m$.var("strResult");
    m$.newVar(idWWWUMLAU,objWWWUMLAU,strAccentMark,strNoAccentMark,strResult);
    //<< 
    //<< set strResult = pstrValue
    strResult.set(pstrValue.get());
    //<< set strAccentMark   = ""
    strAccentMark.set("");
    //<< set strNoAccentMark = ""
    strNoAccentMark.set("");
    //<< 
    //<< if $get(YM)=""   set YM   = pidCompany
    if (mOp.Equal(m$.Fnc.$get(m$.var("YM")),"")) {
      mVar YM = m$.var("YM");
      YM.set(pidCompany.get());
    }
    //<< if $get(YUCI)="" set YUCI = pstrNamespace
    if (mOp.Equal(m$.Fnc.$get(m$.var("YUCI")),"")) {
      mVar YUCI = m$.var("YUCI");
      YUCI.set(pstrNamespace.get());
    }
    //<< 
    //<< ; to remove accent marks
    //<< if ($$$MapAccentMark) {
    if (mOp.Logical(($$$MapAccentMark(m$)))) {
      //<< if ($get(pstrValue) '= "") {
      if ((mOp.NotEqual(m$.Fnc.$get(pstrValue),""))) {
        //<< if '$data(^CacheTempWWWUMLAU(YUCI)) {
        if (mOp.Not(m$.Fnc.$data(m$.var("^CacheTempWWWUMLAU",m$.var("YUCI").get())))) {
          //<< merge ^CacheTempWWWUMLAU(YUCI)=^WWWUMLAU
          m$.Cmd.Merge(m$.var("^CacheTempWWWUMLAU",m$.var("YUCI").get()),m$.var("^WWWUMLAU"));
        }
        //<< }
        //<< 
        //<< if ($get(^CacheTempWWWUMLAU(YUCI,0))="") ||
        //<< ($get(^CacheTempWWWUMLAU(YUCI,1))="")    {
        if ((mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempWWWUMLAU",m$.var("YUCI").get(),0)),"")) || (mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempWWWUMLAU",m$.var("YUCI").get(),1)),""))) {
          //<< 
          //<< set idWWWUMLAU = ""
          idWWWUMLAU.set("");
          //<< ; load mapping from WWWUMLAU
          //<< for {
          for (;true;) {
            //<< set idWWWUMLAU = $order(^CacheTempWWWUMLAU(YUCI,0,idWWWUMLAU))
            idWWWUMLAU.set(m$.Fnc.$order(m$.var("^CacheTempWWWUMLAU",m$.var("YUCI").get(),0,idWWWUMLAU.get())));
            //<< quit:(idWWWUMLAU="")
            if ((mOp.Equal(idWWWUMLAU.get(),""))) {
              break;
            }
            //<< 
            //<< set objWWWUMLAU = $get(^CacheTempWWWUMLAU(YUCI,0,idWWWUMLAU,1))
            objWWWUMLAU.set(m$.Fnc.$get(m$.var("^CacheTempWWWUMLAU",m$.var("YUCI").get(),0,idWWWUMLAU.get(),1)));
            //<< ; check whether fields are defined (not empty)
            //<< if ($$$WWWUMLAUCharacter1(objWWWUMLAU)'= "") && ($$$WWWUMLAUNoAccentMark(objWWWUMLAU)'= "") {
            if ((mOp.NotEqual(include.WWWConst.$$$WWWUMLAUCharacter1(m$,objWWWUMLAU),"")) && (mOp.NotEqual(include.WWWConst.$$$WWWUMLAUNoAccentMark(m$,objWWWUMLAU),""))) {
              //<< set strAccentMark   = strAccentMark _ $$$WWWUMLAUCharacter1(objWWWUMLAU)
              strAccentMark.set(mOp.Concat(strAccentMark.get(),include.WWWConst.$$$WWWUMLAUCharacter1(m$,objWWWUMLAU)));
              //<< set strNoAccentMark = strNoAccentMark _ $$$WWWUMLAUNoAccentMark(objWWWUMLAU)
              strNoAccentMark.set(mOp.Concat(strNoAccentMark.get(),include.WWWConst.$$$WWWUMLAUNoAccentMark(m$,objWWWUMLAU)));
            }
          }
          //<< }
          //<< }
          //<< ; CacheTempWWWUMLAU is killed when WWWUMLAU is updated
          //<< set ^CacheTempWWWUMLAU(YUCI,0) = strAccentMark
          m$.var("^CacheTempWWWUMLAU",m$.var("YUCI").get(),0).set(strAccentMark.get());
          //<< set ^CacheTempWWWUMLAU(YUCI,1) = strNoAccentMark
          m$.var("^CacheTempWWWUMLAU",m$.var("YUCI").get(),1).set(strNoAccentMark.get());
        }
        //<< }
        //<< set strResult = $TRANSLATE(pstrValue,$get(^CacheTempWWWUMLAU(YUCI,0)),$get(^CacheTempWWWUMLAU(YUCI,1)))
        strResult.set(m$.Fnc.$translate(pstrValue.get(),m$.Fnc.$get(m$.var("^CacheTempWWWUMLAU",m$.var("YUCI").get(),0)),m$.Fnc.$get(m$.var("^CacheTempWWWUMLAU",m$.var("YUCI").get(),1))));
      }
      //<< 
      //<< } else {
      else {
        //<< ; When this subroutine is called from a sql query and pstrValue is null, the null is returned making the
        //<< ; query return invalid rows, since the query has filters: <> "" .. or ..!= " ". So, when pstrValue is "",
        //<< ; a " " is returned for the second filter to be valid.
        //<< set strResult = " "
        strResult.set(" ");
      }
    }
    //<< }
    //<< }
    //<< quit strResult
    return strResult.get();
  }

  //<< 
  //<< 
  //<< ToRemoveAccentMark(pstrValue)
  public Object ToRemoveAccentMark(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns string to be added to SQL query with call to remove accent marks
    //<< ;
    //<< ; Params: pstrValue
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  empty if user doesn´t required translation
    //<< ;
    //<< ; History:
    //<< ; 17-Oct-2012   SVL     SR18152:  Excluding some fields from MEDPatient
    //<< ; 20-Apr-2007   HeberB  BR014367: Added YUCI to call
    //<< ; 27-Mar-2007   HeberB  BR014367: use macro
    //<< ; 21-Mar-2007   HeberB  BR014367: fix bollean usage - stop using floating vars
    //<< ; 09-Mar-2007   HeberB  BR014367: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
      //<< if (($piece(pstrValue,".",2) = "MEDPatient") && (($piece($replace(pstrValue,")",""),".",3) = "SSN") ||
      //<< ($piece($replace(pstrValue,")",""),".",3) = "PatientID")))  {
      if (mOp.Logical(((mOp.Equal(m$.Fnc.$piece(pstrValue.get(),".",2),"MEDPatient")) && mOp.Logical(((mOp.Equal(m$.Fnc.$piece(m$.Fnc.$replace(pstrValue.get(),")",""),".",3),"SSN")) || (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$replace(pstrValue.get(),")",""),".",3),"PatientID"))))))) {
        //<< quit pstrValue
        return pstrValue.get();
      }
    }
    //<< }
    //<< }
    //<< if ((+$$$WWWClientParamCoreChangesSESPE($get(^WWWClientParam(YM,YM,1)))) ||
    //<< (+$$$WWWClientParamCoreChangesSESDF($get(^WWWClientParam(YM,YM,1))))) {
    if ((mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESPE(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) || mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesSESDF(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))))) {
      //<< if (($piece(pstrValue,".",2) = "INREC") && (($piece($replace(pstrValue,")",""),".",3) = "Status"))) {
      if (mOp.Logical(((mOp.Equal(m$.Fnc.$piece(pstrValue.get(),".",2),"INREC")) && mOp.Logical(((mOp.Equal(m$.Fnc.$piece(m$.Fnc.$replace(pstrValue.get(),")",""),".",3),"Status"))))))) {
        //<< quit $piece(pstrValue,"%upper",2)
        return m$.Fnc.$piece(pstrValue.get(),"%upper",2);
      }
    }
    //<< }
    //<< }
    //<< quit $select($$$MapAccentMark:" $$RemoveMark^COMViewSQL("_pstrValue_","""_YM_""","""_YUCI_""") ",1:pstrValue)
    return m$.Fnc.$select($$$MapAccentMark(m$),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" $$RemoveMark^COMViewSQL(",pstrValue.get()),",\""),m$.var("YM").get()),"\",\""),m$.var("YUCI").get()),"\") "),1,pstrValue.get());
  }

  //<< 
  //<< 
  //<< RemoveAccentMarkFunc(pstrValue)
  public Object RemoveAccentMarkFunc(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Remove the $$RemoveMark function from a string to avoid slow searches.
    //<< ;   Ex: Order by $$RemoveMark^COMViewSQL(SQLUser.MEDPatient.PatientID,"0","CORE-V1_70_4_BR")
    //<< ;
    //<< ; Params: pstrValue
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  converted value
    //<< ;
    //<< ; History:
    //<< ; 11-Oct-2012   SLV     SR18152: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit:(pstrValue="") ""
    if ((mOp.Equal(pstrValue.get(),""))) {
      return "";
    }
    //<< 
    //<< new strConvertedValue
    mVar strConvertedValue = m$.var("strConvertedValue");
    m$.newVar(strConvertedValue);
    //<< 
    //<< set strConvertedValue = pstrValue
    strConvertedValue.set(pstrValue.get());
    //<< 
    //<< if $find(pstrValue,"SQLUser") {
    if (mOp.Logical(m$.Fnc.$find(pstrValue.get(),"SQLUser"))) {
      //<< if $find(pstrValue,"%upper") {
      if (mOp.Logical(m$.Fnc.$find(pstrValue.get(),"%upper"))) {
        //<< set strConvertedValue = $extract(pstrValue,(($find(pstrValue,"SQLUser"))-7),($find(pstrValue,",")-3))
        strConvertedValue.set(m$.Fnc.$extract(pstrValue.get(),(mOp.Subtract((m$.Fnc.$find(pstrValue.get(),"SQLUser")),7)),(mOp.Subtract(m$.Fnc.$find(pstrValue.get(),","),3))));
      }
      //<< }
      //<< else {
      else {
        //<< set strConvertedValue = $extract(pstrValue,(($find(pstrValue,"SQLUser"))-7),($find(pstrValue,",")-2))
        strConvertedValue.set(m$.Fnc.$extract(pstrValue.get(),(mOp.Subtract((m$.Fnc.$find(pstrValue.get(),"SQLUser")),7)),(mOp.Subtract(m$.Fnc.$find(pstrValue.get(),","),2))));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strConvertedValue
    return strConvertedValue.get();
  }

//<< 
}
