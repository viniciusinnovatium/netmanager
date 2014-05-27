//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMConst
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:12:38
//*****************************************************************************

package include;

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

//<< ; Enumerated values for Cache Datatypes
//<< ;
public class COMConst extends mInclude {

  //<< #def1arg SaveGlobal(%obj) $$Save^SALUtils(YM,%obj)
  public static Object $$$SaveGlobal(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("SALUtils.Save",m$.var("YM").get(),p$obj.get()));
  }

  //<< #define Index(%obj) $$Index^COMUtilIndex(%obj)
  public static Object $$$Index(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMUtilIndex.Index",p$obj.get()));
  }

  //<< #define COMfwkentityUserFootPrintparameterValue(%obj) $piece(%obj,"~",1)
  public static Object $$$COMfwkentityUserFootPrintparameterValue(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMfwkentityUserFootPrintparameterValueSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMfwkentityUserFootPrintparameterValue 1
  public static Object $$$FldCOMfwkentityUserFootPrintparameterValue(mContext m$) {
    return (1);
  }

  //<< #define StrCOMfwkentityUserFootPrintparameterValue $$GetPropertyName^COMConst("COMfwkentityUserFootPrint",1)
  public static Object $$$StrCOMfwkentityUserFootPrintparameterValue(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMfwkentityUserFootPrint",1));
  }

  //<< #define FldCOMfwkentityUserFootPrintmoduleAbbreviation 1
  public static Object $$$FldCOMfwkentityUserFootPrintmoduleAbbreviation(mContext m$) {
    return (1);
  }

  //<< #define StrCOMfwkentityUserFootPrintmoduleAbbreviation $$GetPropertyName^COMConst("COMfwkentityUserFootPrint",,1)
  public static Object $$$StrCOMfwkentityUserFootPrintmoduleAbbreviation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMfwkentityUserFootPrint",null,1));
  }

  //<< #define FldCOMfwkentityUserFootPrintuserName 2
  public static Object $$$FldCOMfwkentityUserFootPrintuserName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMfwkentityUserFootPrintuserName $$GetPropertyName^COMConst("COMfwkentityUserFootPrint",,2)
  public static Object $$$StrCOMfwkentityUserFootPrintuserName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMfwkentityUserFootPrint",null,2));
  }

  //<< #define FldCOMfwkentityUserFootPrintparameterName 3
  public static Object $$$FldCOMfwkentityUserFootPrintparameterName(mContext m$) {
    return (3);
  }

  //<< #define StrCOMfwkentityUserFootPrintparameterName $$GetPropertyName^COMConst("COMfwkentityUserFootPrint",,3)
  public static Object $$$StrCOMfwkentityUserFootPrintparameterName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMfwkentityUserFootPrint",null,3));
  }

  //<< 
  //<< #define COMAppErrorDescription(%obj) $piece(%obj,"~",1)
  public static Object $$$COMAppErrorDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMAppErrorDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMAppErrorDescription 1
  public static Object $$$FldCOMAppErrorDescription(mContext m$) {
    return (1);
  }

  //<< #define StrCOMAppErrorDescription $$GetPropertyName^COMConst("COMAppError",1)
  public static Object $$$StrCOMAppErrorDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMAppError",1));
  }

  //<< #define FldCOMAppErrorAppErrorID 1
  public static Object $$$FldCOMAppErrorAppErrorID(mContext m$) {
    return (1);
  }

  //<< #define StrCOMAppErrorAppErrorID $$GetPropertyName^COMConst("COMAppError",,1)
  public static Object $$$StrCOMAppErrorAppErrorID(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMAppError",null,1));
  }

  //<< 
  //<< #define COMApplicationListModule1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMApplicationListModule1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMApplicationListModule1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMApplicationListModule1 1
  public static Object $$$FldCOMApplicationListModule1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMApplicationListModule1 $$GetPropertyName^COMConst("COMApplicationList",1)
  public static Object $$$StrCOMApplicationListModule1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMApplicationList",1));
  }

  //<< #define COMApplicationListBuildOrder(%obj) $piece(%obj,"~",2)
  public static Object $$$COMApplicationListBuildOrder(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMApplicationListBuildOrderSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMApplicationListBuildOrder 2
  public static Object $$$FldCOMApplicationListBuildOrder(mContext m$) {
    return (2);
  }

  //<< #define StrCOMApplicationListBuildOrder $$GetPropertyName^COMConst("COMApplicationList",2)
  public static Object $$$StrCOMApplicationListBuildOrder(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMApplicationList",2));
  }

  //<< #define COMApplicationListIncludeInBuild(%obj) $piece(%obj,"~",3)
  public static Object $$$COMApplicationListIncludeInBuild(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMApplicationListIncludeInBuildSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMApplicationListIncludeInBuild 3
  public static Object $$$FldCOMApplicationListIncludeInBuild(mContext m$) {
    return (3);
  }

  //<< #define StrCOMApplicationListIncludeInBuild $$GetPropertyName^COMConst("COMApplicationList",3)
  public static Object $$$StrCOMApplicationListIncludeInBuild(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMApplicationList",3));
  }

  //<< #define COMApplicationListIncludeAllCacheClasses(%obj) $piece(%obj,"~",4)
  public static Object $$$COMApplicationListIncludeAllCacheClasses(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMApplicationListIncludeAllCacheClassesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMApplicationListIncludeAllCacheClasses 4
  public static Object $$$FldCOMApplicationListIncludeAllCacheClasses(mContext m$) {
    return (4);
  }

  //<< #define StrCOMApplicationListIncludeAllCacheClasses $$GetPropertyName^COMConst("COMApplicationList",4)
  public static Object $$$StrCOMApplicationListIncludeAllCacheClasses(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMApplicationList",4));
  }

  //<< #define FldCOMApplicationListApplication 1
  public static Object $$$FldCOMApplicationListApplication(mContext m$) {
    return (1);
  }

  //<< #define StrCOMApplicationListApplication $$GetPropertyName^COMConst("COMApplicationList",,1)
  public static Object $$$StrCOMApplicationListApplication(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMApplicationList",null,1));
  }

  //<< 
  //<< #define COMChangeHistoryData(%obj) $piece(%obj,"~",1)
  public static Object $$$COMChangeHistoryData(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMChangeHistoryDataSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMChangeHistoryData 1
  public static Object $$$FldCOMChangeHistoryData(mContext m$) {
    return (1);
  }

  //<< #define StrCOMChangeHistoryData $$GetPropertyName^COMConst("COMChangeHistory",1)
  public static Object $$$StrCOMChangeHistoryData(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMChangeHistory",1));
  }

  //<< #define FldCOMChangeHistoryClass 1
  public static Object $$$FldCOMChangeHistoryClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMChangeHistoryClass $$GetPropertyName^COMConst("COMChangeHistory",,1)
  public static Object $$$StrCOMChangeHistoryClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMChangeHistory",null,1));
  }

  //<< #define FldCOMChangeHistoryDate1 2
  public static Object $$$FldCOMChangeHistoryDate1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMChangeHistoryDate1 $$GetPropertyName^COMConst("COMChangeHistory",,2)
  public static Object $$$StrCOMChangeHistoryDate1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMChangeHistory",null,2));
  }

  //<< #define FldCOMChangeHistoryTime1 3
  public static Object $$$FldCOMChangeHistoryTime1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMChangeHistoryTime1 $$GetPropertyName^COMConst("COMChangeHistory",,3)
  public static Object $$$StrCOMChangeHistoryTime1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMChangeHistory",null,3));
  }

  //<< #define FldCOMChangeHistoryUser1 4
  public static Object $$$FldCOMChangeHistoryUser1(mContext m$) {
    return (4);
  }

  //<< #define StrCOMChangeHistoryUser1 $$GetPropertyName^COMConst("COMChangeHistory",,4)
  public static Object $$$StrCOMChangeHistoryUser1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMChangeHistory",null,4));
  }

  //<< #define FldCOMChangeHistoryKey1 5
  public static Object $$$FldCOMChangeHistoryKey1(mContext m$) {
    return (5);
  }

  //<< #define StrCOMChangeHistoryKey1 $$GetPropertyName^COMConst("COMChangeHistory",,5)
  public static Object $$$StrCOMChangeHistoryKey1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMChangeHistory",null,5));
  }

  //<< 
  //<< #define COMClearLevel1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMClearLevel1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMClearLevel1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMClearLevel1 1
  public static Object $$$FldCOMClearLevel1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMClearLevel1 $$GetPropertyName^COMConst("COMClear",1)
  public static Object $$$StrCOMClearLevel1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMClear",1));
  }

  //<< #define FldCOMClearClass 1
  public static Object $$$FldCOMClearClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMClearClass $$GetPropertyName^COMConst("COMClear",,1)
  public static Object $$$StrCOMClearClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMClear",null,1));
  }

  //<< 
  //<< #define COMConstGenerate(%obj) $piece(%obj,"~",1)
  public static Object $$$COMConstGenerate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMConstGenerateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMConstGenerate 1
  public static Object $$$FldCOMConstGenerate(mContext m$) {
    return (1);
  }

  //<< #define StrCOMConstGenerate $$GetPropertyName^COMConst("COMConst",1)
  public static Object $$$StrCOMConstGenerate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMConst",1));
  }

  //<< #define COMConstSubClasses(%obj) $piece(%obj,"~",2)
  public static Object $$$COMConstSubClasses(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMConstSubClassesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMConstSubClasses 2
  public static Object $$$FldCOMConstSubClasses(mContext m$) {
    return (2);
  }

  //<< #define StrCOMConstSubClasses $$GetPropertyName^COMConst("COMConst",2)
  public static Object $$$StrCOMConstSubClasses(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMConst",2));
  }

  //<< #define FldCOMConstClass 1
  public static Object $$$FldCOMConstClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMConstClass $$GetPropertyName^COMConst("COMConst",,1)
  public static Object $$$StrCOMConstClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMConst",null,1));
  }

  //<< 
  //<< #define COMConversionPackage(%obj) $piece(%obj,"~",1)
  public static Object $$$COMConversionPackage(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMConversionPackageSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMConversionPackage 1
  public static Object $$$FldCOMConversionPackage(mContext m$) {
    return (1);
  }

  //<< #define StrCOMConversionPackage $$GetPropertyName^COMConst("COMConversion",1)
  public static Object $$$StrCOMConversionPackage(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMConversion",1));
  }

  //<< #define FldCOMConversionOldClass 1
  public static Object $$$FldCOMConversionOldClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMConversionOldClass $$GetPropertyName^COMConst("COMConversion",,1)
  public static Object $$$StrCOMConversionOldClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMConversion",null,1));
  }

  //<< 
  //<< #define COMDCMClassMirrorClass(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMClassMirrorClass(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMClassMirrorClassSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMClassMirrorClass 1
  public static Object $$$FldCOMDCMClassMirrorClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMClassMirrorClass $$GetPropertyName^COMConst("COMDCMClass",1)
  public static Object $$$StrCOMDCMClassMirrorClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMClass",1));
  }

  //<< #define COMDCMClassDistribute(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDCMClassDistribute(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDCMClassDistributeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDCMClassDistribute 2
  public static Object $$$FldCOMDCMClassDistribute(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMClassDistribute $$GetPropertyName^COMConst("COMDCMClass",2)
  public static Object $$$StrCOMDCMClassDistribute(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMClass",2));
  }

  //<< #define COMDCMClassNonDistributionReason(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDCMClassNonDistributionReason(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDCMClassNonDistributionReasonSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDCMClassNonDistributionReason 3
  public static Object $$$FldCOMDCMClassNonDistributionReason(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMClassNonDistributionReason $$GetPropertyName^COMConst("COMDCMClass",3)
  public static Object $$$StrCOMDCMClassNonDistributionReason(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMClass",3));
  }

  //<< #define COMDCMClassDistributionType(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDCMClassDistributionType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDCMClassDistributionTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDCMClassDistributionType 4
  public static Object $$$FldCOMDCMClassDistributionType(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDCMClassDistributionType $$GetPropertyName^COMConst("COMDCMClass",4)
  public static Object $$$StrCOMDCMClassDistributionType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMClass",4));
  }

  //<< #define COMDCMClassRelatedModule(%obj) $piece(%obj,"~",5)
  public static Object $$$COMDCMClassRelatedModule(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMDCMClassRelatedModuleSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMDCMClassRelatedModule 5
  public static Object $$$FldCOMDCMClassRelatedModule(mContext m$) {
    return (5);
  }

  //<< #define StrCOMDCMClassRelatedModule $$GetPropertyName^COMConst("COMDCMClass",5)
  public static Object $$$StrCOMDCMClassRelatedModule(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMClass",5));
  }

  //<< #define FldCOMDCMClassClass 1
  public static Object $$$FldCOMDCMClassClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMClassClass $$GetPropertyName^COMConst("COMDCMClass",,1)
  public static Object $$$StrCOMDCMClassClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMClass",null,1));
  }

  //<< 
  //<< #define COMDCMDTDUsage1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMDTDUsage1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMDTDUsage1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMDTDUsage1 1
  public static Object $$$FldCOMDCMDTDUsage1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMDTDUsage1 $$GetPropertyName^COMConst("COMDCMDTD",1)
  public static Object $$$StrCOMDCMDTDUsage1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMDTD",1));
  }

  //<< #define FldCOMDCMDTDDTDName 1
  public static Object $$$FldCOMDCMDTDDTDName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMDTDDTDName $$GetPropertyName^COMConst("COMDCMDTD",,1)
  public static Object $$$StrCOMDCMDTDDTDName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMDTD",null,1));
  }

  //<< 
  //<< #define COMDCMDTDElementParentElementName(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMDTDElementParentElementName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMDTDElementParentElementNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMDTDElementParentElementName 1
  public static Object $$$FldCOMDCMDTDElementParentElementName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMDTDElementParentElementName $$GetPropertyName^COMConst("COMDCMDTDElement",1)
  public static Object $$$StrCOMDCMDTDElementParentElementName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMDTDElement",1));
  }

  //<< #define COMDCMDTDElementGlobalID(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDCMDTDElementGlobalID(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDCMDTDElementGlobalIDSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDCMDTDElementGlobalID 2
  public static Object $$$FldCOMDCMDTDElementGlobalID(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMDTDElementGlobalID $$GetPropertyName^COMConst("COMDCMDTDElement",2)
  public static Object $$$StrCOMDCMDTDElementGlobalID(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMDTDElement",2));
  }

  //<< #define COMDCMDTDElementRepeatingElement(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDCMDTDElementRepeatingElement(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDCMDTDElementRepeatingElementSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDCMDTDElementRepeatingElement 3
  public static Object $$$FldCOMDCMDTDElementRepeatingElement(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMDTDElementRepeatingElement $$GetPropertyName^COMConst("COMDCMDTDElement",3)
  public static Object $$$StrCOMDCMDTDElementRepeatingElement(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMDTDElement",3));
  }

  //<< #define COMDCMDTDElementMandatory(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDCMDTDElementMandatory(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDCMDTDElementMandatorySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDCMDTDElementMandatory 4
  public static Object $$$FldCOMDCMDTDElementMandatory(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDCMDTDElementMandatory $$GetPropertyName^COMConst("COMDCMDTDElement",4)
  public static Object $$$StrCOMDCMDTDElementMandatory(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMDTDElement",4));
  }

  //<< #define COMDCMDTDElementSequence(%obj) $piece(%obj,"~",5)
  public static Object $$$COMDCMDTDElementSequence(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMDCMDTDElementSequenceSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMDCMDTDElementSequence 5
  public static Object $$$FldCOMDCMDTDElementSequence(mContext m$) {
    return (5);
  }

  //<< #define StrCOMDCMDTDElementSequence $$GetPropertyName^COMConst("COMDCMDTDElement",5)
  public static Object $$$StrCOMDCMDTDElementSequence(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMDTDElement",5));
  }

  //<< #define COMDCMDTDElementDescription(%obj) $piece(%obj,"~",6)
  public static Object $$$COMDCMDTDElementDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMDCMDTDElementDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMDCMDTDElementDescription 6
  public static Object $$$FldCOMDCMDTDElementDescription(mContext m$) {
    return (6);
  }

  //<< #define StrCOMDCMDTDElementDescription $$GetPropertyName^COMConst("COMDCMDTDElement",6)
  public static Object $$$StrCOMDCMDTDElementDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMDTDElement",6));
  }

  //<< #define FldCOMDCMDTDElementDTDName 1
  public static Object $$$FldCOMDCMDTDElementDTDName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMDTDElementDTDName $$GetPropertyName^COMConst("COMDCMDTDElement",,1)
  public static Object $$$StrCOMDCMDTDElementDTDName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMDTDElement",null,1));
  }

  //<< #define FldCOMDCMDTDElementElementName 2
  public static Object $$$FldCOMDCMDTDElementElementName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMDTDElementElementName $$GetPropertyName^COMConst("COMDCMDTDElement",,2)
  public static Object $$$StrCOMDCMDTDElementElementName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMDTDElement",null,2));
  }

  //<< 
  //<< #define COMDCMEventDescription(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMEventDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMEventDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMEventDescription 1
  public static Object $$$FldCOMDCMEventDescription(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventDescription $$GetPropertyName^COMConst("COMDCMEvent",1)
  public static Object $$$StrCOMDCMEventDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEvent",1));
  }

  //<< #define COMDCMEventEventType(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDCMEventEventType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDCMEventEventTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDCMEventEventType 2
  public static Object $$$FldCOMDCMEventEventType(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMEventEventType $$GetPropertyName^COMConst("COMDCMEvent",2)
  public static Object $$$StrCOMDCMEventEventType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEvent",2));
  }

  //<< #define COMDCMEventDataSourceType(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDCMEventDataSourceType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDCMEventDataSourceTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDCMEventDataSourceType 3
  public static Object $$$FldCOMDCMEventDataSourceType(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMEventDataSourceType $$GetPropertyName^COMConst("COMDCMEvent",3)
  public static Object $$$StrCOMDCMEventDataSourceType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEvent",3));
  }

  //<< #define COMDCMEventDataSourceName(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDCMEventDataSourceName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDCMEventDataSourceNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDCMEventDataSourceName 4
  public static Object $$$FldCOMDCMEventDataSourceName(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDCMEventDataSourceName $$GetPropertyName^COMConst("COMDCMEvent",4)
  public static Object $$$StrCOMDCMEventDataSourceName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEvent",4));
  }

  //<< #define COMDCMEventAllowImmediate(%obj) $piece(%obj,"~",5)
  public static Object $$$COMDCMEventAllowImmediate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMDCMEventAllowImmediateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMDCMEventAllowImmediate 5
  public static Object $$$FldCOMDCMEventAllowImmediate(mContext m$) {
    return (5);
  }

  //<< #define StrCOMDCMEventAllowImmediate $$GetPropertyName^COMConst("COMDCMEvent",5)
  public static Object $$$StrCOMDCMEventAllowImmediate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEvent",5));
  }

  //<< #define COMDCMEventOnBeforeDCM(%obj) $piece(%obj,"~",6)
  public static Object $$$COMDCMEventOnBeforeDCM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMDCMEventOnBeforeDCMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMDCMEventOnBeforeDCM 6
  public static Object $$$FldCOMDCMEventOnBeforeDCM(mContext m$) {
    return (6);
  }

  //<< #define StrCOMDCMEventOnBeforeDCM $$GetPropertyName^COMConst("COMDCMEvent",6)
  public static Object $$$StrCOMDCMEventOnBeforeDCM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEvent",6));
  }

  //<< #define FldCOMDCMEventEventName 1
  public static Object $$$FldCOMDCMEventEventName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventEventName $$GetPropertyName^COMConst("COMDCMEvent",,1)
  public static Object $$$StrCOMDCMEventEventName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEvent",null,1));
  }

  //<< 
  //<< #define COMDCMEventFieldsFunctionCall(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDCMEventFieldsFunctionCall(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDCMEventFieldsFunctionCallSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDCMEventFieldsFunctionCall 3
  public static Object $$$FldCOMDCMEventFieldsFunctionCall(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMEventFieldsFunctionCall $$GetPropertyName^COMConst("COMDCMEventFields",3)
  public static Object $$$StrCOMDCMEventFieldsFunctionCall(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventFields",3));
  }

  //<< #define COMDCMEventFieldsDeterminesMethod(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDCMEventFieldsDeterminesMethod(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDCMEventFieldsDeterminesMethodSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDCMEventFieldsDeterminesMethod 4
  public static Object $$$FldCOMDCMEventFieldsDeterminesMethod(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDCMEventFieldsDeterminesMethod $$GetPropertyName^COMConst("COMDCMEventFields",4)
  public static Object $$$StrCOMDCMEventFieldsDeterminesMethod(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventFields",4));
  }

  //<< #define COMDCMEventFieldsUsedByMethod(%obj) $piece(%obj,"~",5)
  public static Object $$$COMDCMEventFieldsUsedByMethod(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMDCMEventFieldsUsedByMethodSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMDCMEventFieldsUsedByMethod 5
  public static Object $$$FldCOMDCMEventFieldsUsedByMethod(mContext m$) {
    return (5);
  }

  //<< #define StrCOMDCMEventFieldsUsedByMethod $$GetPropertyName^COMConst("COMDCMEventFields",5)
  public static Object $$$StrCOMDCMEventFieldsUsedByMethod(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventFields",5));
  }

  //<< #define COMDCMEventFieldsDeterminesTarget(%obj) $piece(%obj,"~",6)
  public static Object $$$COMDCMEventFieldsDeterminesTarget(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMDCMEventFieldsDeterminesTargetSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMDCMEventFieldsDeterminesTarget 6
  public static Object $$$FldCOMDCMEventFieldsDeterminesTarget(mContext m$) {
    return (6);
  }

  //<< #define StrCOMDCMEventFieldsDeterminesTarget $$GetPropertyName^COMConst("COMDCMEventFields",6)
  public static Object $$$StrCOMDCMEventFieldsDeterminesTarget(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventFields",6));
  }

  //<< #define COMDCMEventFieldsDescription(%obj) $piece(%obj,"~",7)
  public static Object $$$COMDCMEventFieldsDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMDCMEventFieldsDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMDCMEventFieldsDescription 7
  public static Object $$$FldCOMDCMEventFieldsDescription(mContext m$) {
    return (7);
  }

  //<< #define StrCOMDCMEventFieldsDescription $$GetPropertyName^COMConst("COMDCMEventFields",7)
  public static Object $$$StrCOMDCMEventFieldsDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventFields",7));
  }

  //<< #define COMDCMEventFieldsComplexData(%obj) $piece(%obj,"~",8)
  public static Object $$$COMDCMEventFieldsComplexData(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMDCMEventFieldsComplexDataSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMDCMEventFieldsComplexData 8
  public static Object $$$FldCOMDCMEventFieldsComplexData(mContext m$) {
    return (8);
  }

  //<< #define StrCOMDCMEventFieldsComplexData $$GetPropertyName^COMConst("COMDCMEventFields",8)
  public static Object $$$StrCOMDCMEventFieldsComplexData(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventFields",8));
  }

  //<< #define COMDCMEventFieldsComplexDTD(%obj) $piece(%obj,"~",9)
  public static Object $$$COMDCMEventFieldsComplexDTD(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMDCMEventFieldsComplexDTDSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMDCMEventFieldsComplexDTD 9
  public static Object $$$FldCOMDCMEventFieldsComplexDTD(mContext m$) {
    return (9);
  }

  //<< #define StrCOMDCMEventFieldsComplexDTD $$GetPropertyName^COMConst("COMDCMEventFields",9)
  public static Object $$$StrCOMDCMEventFieldsComplexDTD(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventFields",9));
  }

  //<< #define FldCOMDCMEventFieldsEventName 1
  public static Object $$$FldCOMDCMEventFieldsEventName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventFieldsEventName $$GetPropertyName^COMConst("COMDCMEventFields",,1)
  public static Object $$$StrCOMDCMEventFieldsEventName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventFields",null,1));
  }

  //<< #define FldCOMDCMEventFieldsFieldName 2
  public static Object $$$FldCOMDCMEventFieldsFieldName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMEventFieldsFieldName $$GetPropertyName^COMConst("COMDCMEventFields",,2)
  public static Object $$$StrCOMDCMEventFieldsFieldName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventFields",null,2));
  }

  //<< 
  //<< #define COMDCMEventsProcessedEventName(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMEventsProcessedEventName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMEventsProcessedEventNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsProcessedEventName 1
  public static Object $$$FldCOMDCMEventsProcessedEventName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventsProcessedEventName $$GetPropertyName^COMConst("COMDCMEventsProcessed",1)
  public static Object $$$StrCOMDCMEventsProcessedEventName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessed",1));
  }

  //<< #define COMDCMEventsProcessedLogDateTime(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDCMEventsProcessedLogDateTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDCMEventsProcessedLogDateTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsProcessedLogDateTime 2
  public static Object $$$FldCOMDCMEventsProcessedLogDateTime(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMEventsProcessedLogDateTime $$GetPropertyName^COMConst("COMDCMEventsProcessed",2)
  public static Object $$$StrCOMDCMEventsProcessedLogDateTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessed",2));
  }

  //<< #define COMDCMEventsProcessedSystemType(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDCMEventsProcessedSystemType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDCMEventsProcessedSystemTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsProcessedSystemType 3
  public static Object $$$FldCOMDCMEventsProcessedSystemType(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMEventsProcessedSystemType $$GetPropertyName^COMConst("COMDCMEventsProcessed",3)
  public static Object $$$StrCOMDCMEventsProcessedSystemType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessed",3));
  }

  //<< #define COMDCMEventsProcessedCompany1(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDCMEventsProcessedCompany1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDCMEventsProcessedCompany1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsProcessedCompany1 4
  public static Object $$$FldCOMDCMEventsProcessedCompany1(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDCMEventsProcessedCompany1 $$GetPropertyName^COMConst("COMDCMEventsProcessed",4)
  public static Object $$$StrCOMDCMEventsProcessedCompany1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessed",4));
  }

  //<< #define COMDCMEventsProcessedProcDateTime(%obj) $piece(%obj,"~",5)
  public static Object $$$COMDCMEventsProcessedProcDateTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMDCMEventsProcessedProcDateTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsProcessedProcDateTime 5
  public static Object $$$FldCOMDCMEventsProcessedProcDateTime(mContext m$) {
    return (5);
  }

  //<< #define StrCOMDCMEventsProcessedProcDateTime $$GetPropertyName^COMConst("COMDCMEventsProcessed",5)
  public static Object $$$StrCOMDCMEventsProcessedProcDateTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessed",5));
  }

  //<< #define COMDCMEventsProcessedProcStatus(%obj) $piece(%obj,"~",6)
  public static Object $$$COMDCMEventsProcessedProcStatus(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMDCMEventsProcessedProcStatusSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsProcessedProcStatus 6
  public static Object $$$FldCOMDCMEventsProcessedProcStatus(mContext m$) {
    return (6);
  }

  //<< #define StrCOMDCMEventsProcessedProcStatus $$GetPropertyName^COMConst("COMDCMEventsProcessed",6)
  public static Object $$$StrCOMDCMEventsProcessedProcStatus(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessed",6));
  }

  //<< #define FldCOMDCMEventsProcessedQueueNo 1
  public static Object $$$FldCOMDCMEventsProcessedQueueNo(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventsProcessedQueueNo $$GetPropertyName^COMConst("COMDCMEventsProcessed",,1)
  public static Object $$$StrCOMDCMEventsProcessedQueueNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessed",null,1));
  }

  //<< 
  //<< #define COMDCMEventsProcessedDataData(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMEventsProcessedDataData(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMEventsProcessedDataDataSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsProcessedDataData 1
  public static Object $$$FldCOMDCMEventsProcessedDataData(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventsProcessedDataData $$GetPropertyName^COMConst("COMDCMEventsProcessedData",1)
  public static Object $$$StrCOMDCMEventsProcessedDataData(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessedData",1));
  }

  //<< #define FldCOMDCMEventsProcessedDataQueueNo 1
  public static Object $$$FldCOMDCMEventsProcessedDataQueueNo(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventsProcessedDataQueueNo $$GetPropertyName^COMConst("COMDCMEventsProcessedData",,1)
  public static Object $$$StrCOMDCMEventsProcessedDataQueueNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessedData",null,1));
  }

  //<< #define FldCOMDCMEventsProcessedDataFieldName 2
  public static Object $$$FldCOMDCMEventsProcessedDataFieldName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMEventsProcessedDataFieldName $$GetPropertyName^COMConst("COMDCMEventsProcessedData",,2)
  public static Object $$$StrCOMDCMEventsProcessedDataFieldName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessedData",null,2));
  }

  //<< 
  //<< #define COMDCMEventsProcessedTargetProcDateTime(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMEventsProcessedTargetProcDateTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMEventsProcessedTargetProcDateTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsProcessedTargetProcDateTime 1
  public static Object $$$FldCOMDCMEventsProcessedTargetProcDateTime(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventsProcessedTargetProcDateTime $$GetPropertyName^COMConst("COMDCMEventsProcessedTarget",1)
  public static Object $$$StrCOMDCMEventsProcessedTargetProcDateTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessedTarget",1));
  }

  //<< #define COMDCMEventsProcessedTargetProcStatus(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDCMEventsProcessedTargetProcStatus(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDCMEventsProcessedTargetProcStatusSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsProcessedTargetProcStatus 2
  public static Object $$$FldCOMDCMEventsProcessedTargetProcStatus(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMEventsProcessedTargetProcStatus $$GetPropertyName^COMConst("COMDCMEventsProcessedTarget",2)
  public static Object $$$StrCOMDCMEventsProcessedTargetProcStatus(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessedTarget",2));
  }

  //<< #define COMDCMEventsProcessedTargetMessage1(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDCMEventsProcessedTargetMessage1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDCMEventsProcessedTargetMessage1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsProcessedTargetMessage1 3
  public static Object $$$FldCOMDCMEventsProcessedTargetMessage1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMEventsProcessedTargetMessage1 $$GetPropertyName^COMConst("COMDCMEventsProcessedTarget",3)
  public static Object $$$StrCOMDCMEventsProcessedTargetMessage1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessedTarget",3));
  }

  //<< #define COMDCMEventsProcessedTargetDuration(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDCMEventsProcessedTargetDuration(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDCMEventsProcessedTargetDurationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsProcessedTargetDuration 4
  public static Object $$$FldCOMDCMEventsProcessedTargetDuration(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDCMEventsProcessedTargetDuration $$GetPropertyName^COMConst("COMDCMEventsProcessedTarget",4)
  public static Object $$$StrCOMDCMEventsProcessedTargetDuration(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessedTarget",4));
  }

  //<< #define FldCOMDCMEventsProcessedTargetQueueNo 1
  public static Object $$$FldCOMDCMEventsProcessedTargetQueueNo(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventsProcessedTargetQueueNo $$GetPropertyName^COMConst("COMDCMEventsProcessedTarget",,1)
  public static Object $$$StrCOMDCMEventsProcessedTargetQueueNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessedTarget",null,1));
  }

  //<< #define FldCOMDCMEventsProcessedTargetMethodName 2
  public static Object $$$FldCOMDCMEventsProcessedTargetMethodName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMEventsProcessedTargetMethodName $$GetPropertyName^COMConst("COMDCMEventsProcessedTarget",,2)
  public static Object $$$StrCOMDCMEventsProcessedTargetMethodName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessedTarget",null,2));
  }

  //<< #define FldCOMDCMEventsProcessedTargetSite 3
  public static Object $$$FldCOMDCMEventsProcessedTargetSite(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMEventsProcessedTargetSite $$GetPropertyName^COMConst("COMDCMEventsProcessedTarget",,3)
  public static Object $$$StrCOMDCMEventsProcessedTargetSite(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsProcessedTarget",null,3));
  }

  //<< 
  //<< #define COMDCMEventsQueueEventName(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMEventsQueueEventName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMEventsQueueEventNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsQueueEventName 1
  public static Object $$$FldCOMDCMEventsQueueEventName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventsQueueEventName $$GetPropertyName^COMConst("COMDCMEventsQueue",1)
  public static Object $$$StrCOMDCMEventsQueueEventName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsQueue",1));
  }

  //<< #define COMDCMEventsQueueLogDateTime(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDCMEventsQueueLogDateTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDCMEventsQueueLogDateTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsQueueLogDateTime 2
  public static Object $$$FldCOMDCMEventsQueueLogDateTime(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMEventsQueueLogDateTime $$GetPropertyName^COMConst("COMDCMEventsQueue",2)
  public static Object $$$StrCOMDCMEventsQueueLogDateTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsQueue",2));
  }

  //<< #define COMDCMEventsQueueSystemType(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDCMEventsQueueSystemType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDCMEventsQueueSystemTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsQueueSystemType 3
  public static Object $$$FldCOMDCMEventsQueueSystemType(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMEventsQueueSystemType $$GetPropertyName^COMConst("COMDCMEventsQueue",3)
  public static Object $$$StrCOMDCMEventsQueueSystemType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsQueue",3));
  }

  //<< #define COMDCMEventsQueueCompany1(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDCMEventsQueueCompany1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDCMEventsQueueCompany1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsQueueCompany1 4
  public static Object $$$FldCOMDCMEventsQueueCompany1(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDCMEventsQueueCompany1 $$GetPropertyName^COMConst("COMDCMEventsQueue",4)
  public static Object $$$StrCOMDCMEventsQueueCompany1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsQueue",4));
  }

  //<< #define FldCOMDCMEventsQueueQueueNo 1
  public static Object $$$FldCOMDCMEventsQueueQueueNo(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventsQueueQueueNo $$GetPropertyName^COMConst("COMDCMEventsQueue",,1)
  public static Object $$$StrCOMDCMEventsQueueQueueNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsQueue",null,1));
  }

  //<< 
  //<< #define COMDCMEventsQueueDataData(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMEventsQueueDataData(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMEventsQueueDataDataSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMEventsQueueDataData 1
  public static Object $$$FldCOMDCMEventsQueueDataData(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventsQueueDataData $$GetPropertyName^COMConst("COMDCMEventsQueueData",1)
  public static Object $$$StrCOMDCMEventsQueueDataData(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsQueueData",1));
  }

  //<< #define FldCOMDCMEventsQueueDataQueueNo 1
  public static Object $$$FldCOMDCMEventsQueueDataQueueNo(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventsQueueDataQueueNo $$GetPropertyName^COMConst("COMDCMEventsQueueData",,1)
  public static Object $$$StrCOMDCMEventsQueueDataQueueNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsQueueData",null,1));
  }

  //<< #define FldCOMDCMEventsQueueDataFieldName 2
  public static Object $$$FldCOMDCMEventsQueueDataFieldName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMEventsQueueDataFieldName $$GetPropertyName^COMConst("COMDCMEventsQueueData",,2)
  public static Object $$$StrCOMDCMEventsQueueDataFieldName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsQueueData",null,2));
  }

  //<< 
  //<< #define FldCOMDCMEventsQueueDataComplexQueueNo 1
  public static Object $$$FldCOMDCMEventsQueueDataComplexQueueNo(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMEventsQueueDataComplexQueueNo $$GetPropertyName^COMConst("COMDCMEventsQueueDataComplex",,1)
  public static Object $$$StrCOMDCMEventsQueueDataComplexQueueNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsQueueDataComplex",null,1));
  }

  //<< #define FldCOMDCMEventsQueueDataComplexFieldName 2
  public static Object $$$FldCOMDCMEventsQueueDataComplexFieldName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMEventsQueueDataComplexFieldName $$GetPropertyName^COMConst("COMDCMEventsQueueDataComplex",,2)
  public static Object $$$StrCOMDCMEventsQueueDataComplexFieldName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMEventsQueueDataComplex",null,2));
  }

  //<< 
  //<< #define COMDCMLocEventPrecedence(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMLocEventPrecedence(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMLocEventPrecedenceSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMLocEventPrecedence 1
  public static Object $$$FldCOMDCMLocEventPrecedence(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMLocEventPrecedence $$GetPropertyName^COMConst("COMDCMLocEvent",1)
  public static Object $$$StrCOMDCMLocEventPrecedence(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocEvent",1));
  }

  //<< #define COMDCMLocEventConditionallyRun(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDCMLocEventConditionallyRun(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDCMLocEventConditionallyRunSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDCMLocEventConditionallyRun 2
  public static Object $$$FldCOMDCMLocEventConditionallyRun(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMLocEventConditionallyRun $$GetPropertyName^COMConst("COMDCMLocEvent",2)
  public static Object $$$StrCOMDCMLocEventConditionallyRun(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocEvent",2));
  }

  //<< #define COMDCMLocEventCondition(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDCMLocEventCondition(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDCMLocEventConditionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDCMLocEventCondition 3
  public static Object $$$FldCOMDCMLocEventCondition(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMLocEventCondition $$GetPropertyName^COMConst("COMDCMLocEvent",3)
  public static Object $$$StrCOMDCMLocEventCondition(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocEvent",3));
  }

  //<< #define COMDCMLocEventTarget(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDCMLocEventTarget(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDCMLocEventTargetSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDCMLocEventTarget 4
  public static Object $$$FldCOMDCMLocEventTarget(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDCMLocEventTarget $$GetPropertyName^COMConst("COMDCMLocEvent",4)
  public static Object $$$StrCOMDCMLocEventTarget(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocEvent",4));
  }

  //<< #define COMDCMLocEventTargetFunction(%obj) $piece(%obj,"~",5)
  public static Object $$$COMDCMLocEventTargetFunction(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMDCMLocEventTargetFunctionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMDCMLocEventTargetFunction 5
  public static Object $$$FldCOMDCMLocEventTargetFunction(mContext m$) {
    return (5);
  }

  //<< #define StrCOMDCMLocEventTargetFunction $$GetPropertyName^COMConst("COMDCMLocEvent",5)
  public static Object $$$StrCOMDCMLocEventTargetFunction(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocEvent",5));
  }

  //<< #define COMDCMLocEventRequestTimeout(%obj) $piece(%obj,"~",6)
  public static Object $$$COMDCMLocEventRequestTimeout(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMDCMLocEventRequestTimeoutSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMDCMLocEventRequestTimeout 6
  public static Object $$$FldCOMDCMLocEventRequestTimeout(mContext m$) {
    return (6);
  }

  //<< #define StrCOMDCMLocEventRequestTimeout $$GetPropertyName^COMConst("COMDCMLocEvent",6)
  public static Object $$$StrCOMDCMLocEventRequestTimeout(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocEvent",6));
  }

  //<< #define FldCOMDCMLocEventSite 1
  public static Object $$$FldCOMDCMLocEventSite(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMLocEventSite $$GetPropertyName^COMConst("COMDCMLocEvent",,1)
  public static Object $$$StrCOMDCMLocEventSite(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocEvent",null,1));
  }

  //<< #define FldCOMDCMLocEventEventName 2
  public static Object $$$FldCOMDCMLocEventEventName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMLocEventEventName $$GetPropertyName^COMConst("COMDCMLocEvent",,2)
  public static Object $$$StrCOMDCMLocEventEventName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocEvent",null,2));
  }

  //<< #define FldCOMDCMLocEventMethodName 3
  public static Object $$$FldCOMDCMLocEventMethodName(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMLocEventMethodName $$GetPropertyName^COMConst("COMDCMLocEvent",,3)
  public static Object $$$StrCOMDCMLocEventMethodName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocEvent",null,3));
  }

  //<< 
  //<< #define COMDCMLocationLocName(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMLocationLocName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMLocationLocNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMLocationLocName 1
  public static Object $$$FldCOMDCMLocationLocName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMLocationLocName $$GetPropertyName^COMConst("COMDCMLocation",1)
  public static Object $$$StrCOMDCMLocationLocName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocation",1));
  }

  //<< #define COMDCMLocationHubLocId(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDCMLocationHubLocId(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDCMLocationHubLocIdSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDCMLocationHubLocId 3
  public static Object $$$FldCOMDCMLocationHubLocId(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMLocationHubLocId $$GetPropertyName^COMConst("COMDCMLocation",3)
  public static Object $$$StrCOMDCMLocationHubLocId(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocation",3));
  }

  //<< #define COMDCMLocationURLPath(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDCMLocationURLPath(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDCMLocationURLPathSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDCMLocationURLPath 4
  public static Object $$$FldCOMDCMLocationURLPath(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDCMLocationURLPath $$GetPropertyName^COMConst("COMDCMLocation",4)
  public static Object $$$StrCOMDCMLocationURLPath(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocation",4));
  }

  //<< #define COMDCMLocationTransportMethod(%obj) $piece(%obj,"~",5)
  public static Object $$$COMDCMLocationTransportMethod(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMDCMLocationTransportMethodSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMDCMLocationTransportMethod 5
  public static Object $$$FldCOMDCMLocationTransportMethod(mContext m$) {
    return (5);
  }

  //<< #define StrCOMDCMLocationTransportMethod $$GetPropertyName^COMConst("COMDCMLocation",5)
  public static Object $$$StrCOMDCMLocationTransportMethod(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocation",5));
  }

  //<< #define COMDCMLocationWSDLDocName(%obj) $piece(%obj,"~",6)
  public static Object $$$COMDCMLocationWSDLDocName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMDCMLocationWSDLDocNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMDCMLocationWSDLDocName 6
  public static Object $$$FldCOMDCMLocationWSDLDocName(mContext m$) {
    return (6);
  }

  //<< #define StrCOMDCMLocationWSDLDocName $$GetPropertyName^COMConst("COMDCMLocation",6)
  public static Object $$$StrCOMDCMLocationWSDLDocName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocation",6));
  }

  //<< #define COMDCMLocationMachineName(%obj) $piece(%obj,"~",7)
  public static Object $$$COMDCMLocationMachineName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMDCMLocationMachineNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMDCMLocationMachineName 7
  public static Object $$$FldCOMDCMLocationMachineName(mContext m$) {
    return (7);
  }

  //<< #define StrCOMDCMLocationMachineName $$GetPropertyName^COMConst("COMDCMLocation",7)
  public static Object $$$StrCOMDCMLocationMachineName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocation",7));
  }

  //<< #define COMDCMLocationNamespace(%obj) $piece(%obj,"~",8)
  public static Object $$$COMDCMLocationNamespace(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMDCMLocationNamespaceSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMDCMLocationNamespace 8
  public static Object $$$FldCOMDCMLocationNamespace(mContext m$) {
    return (8);
  }

  //<< #define StrCOMDCMLocationNamespace $$GetPropertyName^COMConst("COMDCMLocation",8)
  public static Object $$$StrCOMDCMLocationNamespace(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocation",8));
  }

  //<< #define COMDCMLocationActiveServerLimit(%obj) $piece(%obj,"~",9)
  public static Object $$$COMDCMLocationActiveServerLimit(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMDCMLocationActiveServerLimitSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMDCMLocationActiveServerLimit 9
  public static Object $$$FldCOMDCMLocationActiveServerLimit(mContext m$) {
    return (9);
  }

  //<< #define StrCOMDCMLocationActiveServerLimit $$GetPropertyName^COMConst("COMDCMLocation",9)
  public static Object $$$StrCOMDCMLocationActiveServerLimit(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocation",9));
  }

  //<< #define COMDCMLocationLocations(%obj) $piece(%obj,"~",10)
  public static Object $$$COMDCMLocationLocations(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$COMDCMLocationLocationsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldCOMDCMLocationLocations 10
  public static Object $$$FldCOMDCMLocationLocations(mContext m$) {
    return (10);
  }

  //<< #define StrCOMDCMLocationLocations $$GetPropertyName^COMConst("COMDCMLocation",10)
  public static Object $$$StrCOMDCMLocationLocations(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocation",10));
  }

  //<< #define COMDCMLocationCompany1(%obj) $piece(%obj,"~",11)
  public static Object $$$COMDCMLocationCompany1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$COMDCMLocationCompany1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldCOMDCMLocationCompany1 11
  public static Object $$$FldCOMDCMLocationCompany1(mContext m$) {
    return (11);
  }

  //<< #define StrCOMDCMLocationCompany1 $$GetPropertyName^COMConst("COMDCMLocation",11)
  public static Object $$$StrCOMDCMLocationCompany1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocation",11));
  }

  //<< #define FldCOMDCMLocationSite 1
  public static Object $$$FldCOMDCMLocationSite(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMLocationSite $$GetPropertyName^COMConst("COMDCMLocation",,1)
  public static Object $$$StrCOMDCMLocationSite(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocation",null,1));
  }

  //<< 
  //<< #define COMDCMLocnRuleRule(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMLocnRuleRule(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMLocnRuleRuleSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMLocnRuleRule 1
  public static Object $$$FldCOMDCMLocnRuleRule(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMLocnRuleRule $$GetPropertyName^COMConst("COMDCMLocnRule",1)
  public static Object $$$StrCOMDCMLocnRuleRule(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocnRule",1));
  }

  //<< #define FldCOMDCMLocnRuleSite 1
  public static Object $$$FldCOMDCMLocnRuleSite(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMLocnRuleSite $$GetPropertyName^COMConst("COMDCMLocnRule",,1)
  public static Object $$$StrCOMDCMLocnRuleSite(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocnRule",null,1));
  }

  //<< #define FldCOMDCMLocnRuleEvent 2
  public static Object $$$FldCOMDCMLocnRuleEvent(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMLocnRuleEvent $$GetPropertyName^COMConst("COMDCMLocnRule",,2)
  public static Object $$$StrCOMDCMLocnRuleEvent(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocnRule",null,2));
  }

  //<< #define FldCOMDCMLocnRuleMethod 3
  public static Object $$$FldCOMDCMLocnRuleMethod(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMLocnRuleMethod $$GetPropertyName^COMConst("COMDCMLocnRule",,3)
  public static Object $$$StrCOMDCMLocnRuleMethod(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocnRule",null,3));
  }

  //<< #define FldCOMDCMLocnRuleTargetSite 4
  public static Object $$$FldCOMDCMLocnRuleTargetSite(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDCMLocnRuleTargetSite $$GetPropertyName^COMConst("COMDCMLocnRule",,4)
  public static Object $$$StrCOMDCMLocnRuleTargetSite(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocnRule",null,4));
  }

  //<< #define FldCOMDCMLocnRuleRuleNumber 5
  public static Object $$$FldCOMDCMLocnRuleRuleNumber(mContext m$) {
    return (5);
  }

  //<< #define StrCOMDCMLocnRuleRuleNumber $$GetPropertyName^COMConst("COMDCMLocnRule",,5)
  public static Object $$$StrCOMDCMLocnRuleRuleNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMLocnRule",null,5));
  }

  //<< 
  //<< #define COMDCMMethodCacheRoutine(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMMethodCacheRoutine(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMMethodCacheRoutineSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodCacheRoutine 1
  public static Object $$$FldCOMDCMMethodCacheRoutine(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMMethodCacheRoutine $$GetPropertyName^COMConst("COMDCMMethod",1)
  public static Object $$$StrCOMDCMMethodCacheRoutine(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethod",1));
  }

  //<< #define COMDCMMethodDoNotExecuteLocally(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDCMMethodDoNotExecuteLocally(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDCMMethodDoNotExecuteLocallySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodDoNotExecuteLocally 2
  public static Object $$$FldCOMDCMMethodDoNotExecuteLocally(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMMethodDoNotExecuteLocally $$GetPropertyName^COMConst("COMDCMMethod",2)
  public static Object $$$StrCOMDCMMethodDoNotExecuteLocally(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethod",2));
  }

  //<< #define FldCOMDCMMethodEventName 1
  public static Object $$$FldCOMDCMMethodEventName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMMethodEventName $$GetPropertyName^COMConst("COMDCMMethod",,1)
  public static Object $$$StrCOMDCMMethodEventName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethod",null,1));
  }

  //<< #define FldCOMDCMMethodMethodName 2
  public static Object $$$FldCOMDCMMethodMethodName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMMethodMethodName $$GetPropertyName^COMConst("COMDCMMethod",,2)
  public static Object $$$StrCOMDCMMethodMethodName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethod",null,2));
  }

  //<< 
  //<< #define COMDCMMethodParamParamName(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMMethodParamParamName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMMethodParamParamNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodParamParamName 1
  public static Object $$$FldCOMDCMMethodParamParamName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMMethodParamParamName $$GetPropertyName^COMConst("COMDCMMethodParam",1)
  public static Object $$$StrCOMDCMMethodParamParamName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodParam",1));
  }

  //<< #define COMDCMMethodParamFieldName(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDCMMethodParamFieldName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDCMMethodParamFieldNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodParamFieldName 2
  public static Object $$$FldCOMDCMMethodParamFieldName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMMethodParamFieldName $$GetPropertyName^COMConst("COMDCMMethodParam",2)
  public static Object $$$StrCOMDCMMethodParamFieldName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodParam",2));
  }

  //<< #define FldCOMDCMMethodParamEventName 1
  public static Object $$$FldCOMDCMMethodParamEventName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMMethodParamEventName $$GetPropertyName^COMConst("COMDCMMethodParam",,1)
  public static Object $$$StrCOMDCMMethodParamEventName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodParam",null,1));
  }

  //<< #define FldCOMDCMMethodParamMethodName 2
  public static Object $$$FldCOMDCMMethodParamMethodName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMMethodParamMethodName $$GetPropertyName^COMConst("COMDCMMethodParam",,2)
  public static Object $$$StrCOMDCMMethodParamMethodName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodParam",null,2));
  }

  //<< #define FldCOMDCMMethodParamParamNo 3
  public static Object $$$FldCOMDCMMethodParamParamNo(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMMethodParamParamNo $$GetPropertyName^COMConst("COMDCMMethodParam",,3)
  public static Object $$$StrCOMDCMMethodParamParamNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodParam",null,3));
  }

  //<< 
  //<< #define COMDCMMethodsRunSource(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMMethodsRunSource(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMMethodsRunSourceSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodsRunSource 1
  public static Object $$$FldCOMDCMMethodsRunSource(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMMethodsRunSource $$GetPropertyName^COMConst("COMDCMMethodsRun",1)
  public static Object $$$StrCOMDCMMethodsRunSource(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRun",1));
  }

  //<< #define COMDCMMethodsRunCompany1(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDCMMethodsRunCompany1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDCMMethodsRunCompany1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodsRunCompany1 2
  public static Object $$$FldCOMDCMMethodsRunCompany1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMMethodsRunCompany1 $$GetPropertyName^COMConst("COMDCMMethodsRun",2)
  public static Object $$$StrCOMDCMMethodsRunCompany1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRun",2));
  }

  //<< #define COMDCMMethodsRunQueueNo(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDCMMethodsRunQueueNo(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDCMMethodsRunQueueNoSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodsRunQueueNo 3
  public static Object $$$FldCOMDCMMethodsRunQueueNo(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDCMMethodsRunQueueNo $$GetPropertyName^COMConst("COMDCMMethodsRun",3)
  public static Object $$$StrCOMDCMMethodsRunQueueNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRun",3));
  }

  //<< #define COMDCMMethodsRunEventName(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDCMMethodsRunEventName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDCMMethodsRunEventNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodsRunEventName 4
  public static Object $$$FldCOMDCMMethodsRunEventName(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDCMMethodsRunEventName $$GetPropertyName^COMConst("COMDCMMethodsRun",4)
  public static Object $$$StrCOMDCMMethodsRunEventName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRun",4));
  }

  //<< #define COMDCMMethodsRunMethodName(%obj) $piece(%obj,"~",5)
  public static Object $$$COMDCMMethodsRunMethodName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMDCMMethodsRunMethodNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodsRunMethodName 5
  public static Object $$$FldCOMDCMMethodsRunMethodName(mContext m$) {
    return (5);
  }

  //<< #define StrCOMDCMMethodsRunMethodName $$GetPropertyName^COMConst("COMDCMMethodsRun",5)
  public static Object $$$StrCOMDCMMethodsRunMethodName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRun",5));
  }

  //<< #define COMDCMMethodsRunRunDateTime(%obj) $piece(%obj,"~",6)
  public static Object $$$COMDCMMethodsRunRunDateTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMDCMMethodsRunRunDateTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodsRunRunDateTime 6
  public static Object $$$FldCOMDCMMethodsRunRunDateTime(mContext m$) {
    return (6);
  }

  //<< #define StrCOMDCMMethodsRunRunDateTime $$GetPropertyName^COMConst("COMDCMMethodsRun",6)
  public static Object $$$StrCOMDCMMethodsRunRunDateTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRun",6));
  }

  //<< #define COMDCMMethodsRunRunResult(%obj) $piece(%obj,"~",7)
  public static Object $$$COMDCMMethodsRunRunResult(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMDCMMethodsRunRunResultSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodsRunRunResult 7
  public static Object $$$FldCOMDCMMethodsRunRunResult(mContext m$) {
    return (7);
  }

  //<< #define StrCOMDCMMethodsRunRunResult $$GetPropertyName^COMConst("COMDCMMethodsRun",7)
  public static Object $$$StrCOMDCMMethodsRunRunResult(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRun",7));
  }

  //<< #define COMDCMMethodsRunMessage1(%obj) $piece(%obj,"~",8)
  public static Object $$$COMDCMMethodsRunMessage1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMDCMMethodsRunMessage1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodsRunMessage1 8
  public static Object $$$FldCOMDCMMethodsRunMessage1(mContext m$) {
    return (8);
  }

  //<< #define StrCOMDCMMethodsRunMessage1 $$GetPropertyName^COMConst("COMDCMMethodsRun",8)
  public static Object $$$StrCOMDCMMethodsRunMessage1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRun",8));
  }

  //<< #define COMDCMMethodsRunDuration(%obj) $piece(%obj,"~",9)
  public static Object $$$COMDCMMethodsRunDuration(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMDCMMethodsRunDurationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodsRunDuration 9
  public static Object $$$FldCOMDCMMethodsRunDuration(mContext m$) {
    return (9);
  }

  //<< #define StrCOMDCMMethodsRunDuration $$GetPropertyName^COMConst("COMDCMMethodsRun",9)
  public static Object $$$StrCOMDCMMethodsRunDuration(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRun",9));
  }

  //<< #define FldCOMDCMMethodsRunRunNo 1
  public static Object $$$FldCOMDCMMethodsRunRunNo(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMMethodsRunRunNo $$GetPropertyName^COMConst("COMDCMMethodsRun",,1)
  public static Object $$$StrCOMDCMMethodsRunRunNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRun",null,1));
  }

  //<< 
  //<< #define COMDCMMethodsRunDataData(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDCMMethodsRunDataData(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDCMMethodsRunDataDataSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDCMMethodsRunDataData 1
  public static Object $$$FldCOMDCMMethodsRunDataData(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMMethodsRunDataData $$GetPropertyName^COMConst("COMDCMMethodsRunData",1)
  public static Object $$$StrCOMDCMMethodsRunDataData(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRunData",1));
  }

  //<< #define FldCOMDCMMethodsRunDataRunNo 1
  public static Object $$$FldCOMDCMMethodsRunDataRunNo(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDCMMethodsRunDataRunNo $$GetPropertyName^COMConst("COMDCMMethodsRunData",,1)
  public static Object $$$StrCOMDCMMethodsRunDataRunNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRunData",null,1));
  }

  //<< #define FldCOMDCMMethodsRunDataName 2
  public static Object $$$FldCOMDCMMethodsRunDataName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDCMMethodsRunDataName $$GetPropertyName^COMConst("COMDCMMethodsRunData",,2)
  public static Object $$$StrCOMDCMMethodsRunDataName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDCMMethodsRunData",null,2));
  }

  //<< 
  //<< #define COMDirectoryListingSize1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDirectoryListingSize1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDirectoryListingSize1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDirectoryListingSize1 1
  public static Object $$$FldCOMDirectoryListingSize1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDirectoryListingSize1 $$GetPropertyName^COMConst("COMDirectoryListing",1)
  public static Object $$$StrCOMDirectoryListingSize1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDirectoryListing",1));
  }

  //<< #define COMDirectoryListingCreated(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDirectoryListingCreated(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDirectoryListingCreatedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDirectoryListingCreated 2
  public static Object $$$FldCOMDirectoryListingCreated(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDirectoryListingCreated $$GetPropertyName^COMConst("COMDirectoryListing",2)
  public static Object $$$StrCOMDirectoryListingCreated(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDirectoryListing",2));
  }

  //<< #define COMDirectoryListingModified(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDirectoryListingModified(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDirectoryListingModifiedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDirectoryListingModified 3
  public static Object $$$FldCOMDirectoryListingModified(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDirectoryListingModified $$GetPropertyName^COMConst("COMDirectoryListing",3)
  public static Object $$$StrCOMDirectoryListingModified(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDirectoryListing",3));
  }

  //<< #define FldCOMDirectoryListingCurrentUser 1
  public static Object $$$FldCOMDirectoryListingCurrentUser(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDirectoryListingCurrentUser $$GetPropertyName^COMConst("COMDirectoryListing",,1)
  public static Object $$$StrCOMDirectoryListingCurrentUser(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDirectoryListing",null,1));
  }

  //<< #define FldCOMDirectoryListingFilename 2
  public static Object $$$FldCOMDirectoryListingFilename(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDirectoryListingFilename $$GetPropertyName^COMConst("COMDirectoryListing",,2)
  public static Object $$$StrCOMDirectoryListingFilename(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDirectoryListing",null,2));
  }

  //<< 
  //<< #define COMDistOutConfBuildPath(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDistOutConfBuildPath(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDistOutConfBuildPathSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfBuildPath 1
  public static Object $$$FldCOMDistOutConfBuildPath(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDistOutConfBuildPath $$GetPropertyName^COMConst("COMDistOutConf",1)
  public static Object $$$StrCOMDistOutConfBuildPath(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",1));
  }

  //<< #define COMDistOutConfReportPath(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDistOutConfReportPath(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDistOutConfReportPathSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfReportPath 2
  public static Object $$$FldCOMDistOutConfReportPath(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDistOutConfReportPath $$GetPropertyName^COMConst("COMDistOutConf",2)
  public static Object $$$StrCOMDistOutConfReportPath(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",2));
  }

  //<< #define COMDistOutConfDeleteformpictures(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDistOutConfDeleteformpictures(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDistOutConfDeleteformpicturesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfDeleteformpictures 3
  public static Object $$$FldCOMDistOutConfDeleteformpictures(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDistOutConfDeleteformpictures $$GetPropertyName^COMConst("COMDistOutConf",3)
  public static Object $$$StrCOMDistOutConfDeleteformpictures(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",3));
  }

  //<< #define COMDistOutConfDescription(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDistOutConfDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDistOutConfDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfDescription 4
  public static Object $$$FldCOMDistOutConfDescription(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDistOutConfDescription $$GetPropertyName^COMConst("COMDistOutConf",4)
  public static Object $$$StrCOMDistOutConfDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",4));
  }

  //<< #define COMDistOutConfBuildDestination(%obj) $piece(%obj,"~",5)
  public static Object $$$COMDistOutConfBuildDestination(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMDistOutConfBuildDestinationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfBuildDestination 5
  public static Object $$$FldCOMDistOutConfBuildDestination(mContext m$) {
    return (5);
  }

  //<< #define StrCOMDistOutConfBuildDestination $$GetPropertyName^COMConst("COMDistOutConf",5)
  public static Object $$$StrCOMDistOutConfBuildDestination(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",5));
  }

  //<< #define COMDistOutConfFormssubfolder(%obj) $piece(%obj,"~",6)
  public static Object $$$COMDistOutConfFormssubfolder(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMDistOutConfFormssubfolderSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfFormssubfolder 6
  public static Object $$$FldCOMDistOutConfFormssubfolder(mContext m$) {
    return (6);
  }

  //<< #define StrCOMDistOutConfFormssubfolder $$GetPropertyName^COMConst("COMDistOutConf",6)
  public static Object $$$StrCOMDistOutConfFormssubfolder(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",6));
  }

  //<< #define COMDistOutConfReportssubfolder(%obj) $piece(%obj,"~",7)
  public static Object $$$COMDistOutConfReportssubfolder(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMDistOutConfReportssubfolderSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfReportssubfolder 7
  public static Object $$$FldCOMDistOutConfReportssubfolder(mContext m$) {
    return (7);
  }

  //<< #define StrCOMDistOutConfReportssubfolder $$GetPropertyName^COMConst("COMDistOutConf",7)
  public static Object $$$StrCOMDistOutConfReportssubfolder(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",7));
  }

  //<< #define COMDistOutConfGenericbuildfolder(%obj) $piece(%obj,"~",8)
  public static Object $$$COMDistOutConfGenericbuildfolder(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMDistOutConfGenericbuildfolderSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfGenericbuildfolder 8
  public static Object $$$FldCOMDistOutConfGenericbuildfolder(mContext m$) {
    return (8);
  }

  //<< #define StrCOMDistOutConfGenericbuildfolder $$GetPropertyName^COMConst("COMDistOutConf",8)
  public static Object $$$StrCOMDistOutConfGenericbuildfolder(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",8));
  }

  //<< #define COMDistOutConfCreatedBy(%obj) $piece(%obj,"~",9)
  public static Object $$$COMDistOutConfCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMDistOutConfCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfCreatedBy 9
  public static Object $$$FldCOMDistOutConfCreatedBy(mContext m$) {
    return (9);
  }

  //<< #define StrCOMDistOutConfCreatedBy $$GetPropertyName^COMConst("COMDistOutConf",9)
  public static Object $$$StrCOMDistOutConfCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",9));
  }

  //<< #define COMDistOutConfCreateOn(%obj) $piece(%obj,"~",10)
  public static Object $$$COMDistOutConfCreateOn(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$COMDistOutConfCreateOnSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfCreateOn 10
  public static Object $$$FldCOMDistOutConfCreateOn(mContext m$) {
    return (10);
  }

  //<< #define StrCOMDistOutConfCreateOn $$GetPropertyName^COMConst("COMDistOutConf",10)
  public static Object $$$StrCOMDistOutConfCreateOn(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",10));
  }

  //<< #define COMDistOutConfModifiedBy(%obj) $piece(%obj,"~",11)
  public static Object $$$COMDistOutConfModifiedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$COMDistOutConfModifiedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfModifiedBy 11
  public static Object $$$FldCOMDistOutConfModifiedBy(mContext m$) {
    return (11);
  }

  //<< #define StrCOMDistOutConfModifiedBy $$GetPropertyName^COMConst("COMDistOutConf",11)
  public static Object $$$StrCOMDistOutConfModifiedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",11));
  }

  //<< #define COMDistOutConfModifiedAt(%obj) $piece(%obj,"~",12)
  public static Object $$$COMDistOutConfModifiedAt(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$COMDistOutConfModifiedAtSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfModifiedAt 12
  public static Object $$$FldCOMDistOutConfModifiedAt(mContext m$) {
    return (12);
  }

  //<< #define StrCOMDistOutConfModifiedAt $$GetPropertyName^COMConst("COMDistOutConf",12)
  public static Object $$$StrCOMDistOutConfModifiedAt(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",12));
  }

  //<< #define COMDistOutConfSendSource(%obj) $piece(%obj,"~",13)
  public static Object $$$COMDistOutConfSendSource(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$COMDistOutConfSendSourceSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfSendSource 13
  public static Object $$$FldCOMDistOutConfSendSource(mContext m$) {
    return (13);
  }

  //<< #define StrCOMDistOutConfSendSource $$GetPropertyName^COMConst("COMDistOutConf",13)
  public static Object $$$StrCOMDistOutConfSendSource(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",13));
  }

  //<< #define COMDistOutConfIncludeCustomization(%obj) $piece(%obj,"~",14)
  public static Object $$$COMDistOutConfIncludeCustomization(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",14));
  }

  public static void $$$COMDistOutConfIncludeCustomizationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",14).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfIncludeCustomization 14
  public static Object $$$FldCOMDistOutConfIncludeCustomization(mContext m$) {
    return (14);
  }

  //<< #define StrCOMDistOutConfIncludeCustomization $$GetPropertyName^COMConst("COMDistOutConf",14)
  public static Object $$$StrCOMDistOutConfIncludeCustomization(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",14));
  }

  //<< #define COMDistOutConfExportDATfile(%obj) $piece(%obj,"~",15)
  public static Object $$$COMDistOutConfExportDATfile(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",15));
  }

  public static void $$$COMDistOutConfExportDATfileSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",15).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfExportDATfile 15
  public static Object $$$FldCOMDistOutConfExportDATfile(mContext m$) {
    return (15);
  }

  //<< #define StrCOMDistOutConfExportDATfile $$GetPropertyName^COMConst("COMDistOutConf",15)
  public static Object $$$StrCOMDistOutConfExportDATfile(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",15));
  }

  //<< #define FldCOMDistOutConfConfiguration 1
  public static Object $$$FldCOMDistOutConfConfiguration(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDistOutConfConfiguration $$GetPropertyName^COMConst("COMDistOutConf",,1)
  public static Object $$$StrCOMDistOutConfConfiguration(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConf",null,1));
  }

  //<< 
  //<< #define COMDistOutConfDefDefaultconfiguration(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDistOutConfDefDefaultconfiguration(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDistOutConfDefDefaultconfigurationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDistOutConfDefDefaultconfiguration 1
  public static Object $$$FldCOMDistOutConfDefDefaultconfiguration(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDistOutConfDefDefaultconfiguration $$GetPropertyName^COMConst("COMDistOutConfDef",1)
  public static Object $$$StrCOMDistOutConfDefDefaultconfiguration(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConfDef",1));
  }

  //<< #define FldCOMDistOutConfDefKey1 1
  public static Object $$$FldCOMDistOutConfDefKey1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDistOutConfDefKey1 $$GetPropertyName^COMConst("COMDistOutConfDef",,1)
  public static Object $$$StrCOMDistOutConfDefKey1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDistOutConfDef",null,1));
  }

  //<< 
  //<< #define COMDocumentLibrarySetupDescription(%obj) $piece(%obj,"~",1)
  public static Object $$$COMDocumentLibrarySetupDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMDocumentLibrarySetupDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMDocumentLibrarySetupDescription 1
  public static Object $$$FldCOMDocumentLibrarySetupDescription(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDocumentLibrarySetupDescription $$GetPropertyName^COMConst("COMDocumentLibrarySetup",1)
  public static Object $$$StrCOMDocumentLibrarySetupDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDocumentLibrarySetup",1));
  }

  //<< #define COMDocumentLibrarySetupFTPURL(%obj) $piece(%obj,"~",2)
  public static Object $$$COMDocumentLibrarySetupFTPURL(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMDocumentLibrarySetupFTPURLSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMDocumentLibrarySetupFTPURL 2
  public static Object $$$FldCOMDocumentLibrarySetupFTPURL(mContext m$) {
    return (2);
  }

  //<< #define StrCOMDocumentLibrarySetupFTPURL $$GetPropertyName^COMConst("COMDocumentLibrarySetup",2)
  public static Object $$$StrCOMDocumentLibrarySetupFTPURL(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDocumentLibrarySetup",2));
  }

  //<< #define COMDocumentLibrarySetupLocalPath(%obj) $piece(%obj,"~",3)
  public static Object $$$COMDocumentLibrarySetupLocalPath(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMDocumentLibrarySetupLocalPathSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMDocumentLibrarySetupLocalPath 3
  public static Object $$$FldCOMDocumentLibrarySetupLocalPath(mContext m$) {
    return (3);
  }

  //<< #define StrCOMDocumentLibrarySetupLocalPath $$GetPropertyName^COMConst("COMDocumentLibrarySetup",3)
  public static Object $$$StrCOMDocumentLibrarySetupLocalPath(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDocumentLibrarySetup",3));
  }

  //<< #define COMDocumentLibrarySetupUsername(%obj) $piece(%obj,"~",4)
  public static Object $$$COMDocumentLibrarySetupUsername(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMDocumentLibrarySetupUsernameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMDocumentLibrarySetupUsername 4
  public static Object $$$FldCOMDocumentLibrarySetupUsername(mContext m$) {
    return (4);
  }

  //<< #define StrCOMDocumentLibrarySetupUsername $$GetPropertyName^COMConst("COMDocumentLibrarySetup",4)
  public static Object $$$StrCOMDocumentLibrarySetupUsername(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDocumentLibrarySetup",4));
  }

  //<< #define COMDocumentLibrarySetupPassword1(%obj) $piece(%obj,"~",5)
  public static Object $$$COMDocumentLibrarySetupPassword1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMDocumentLibrarySetupPassword1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMDocumentLibrarySetupPassword1 5
  public static Object $$$FldCOMDocumentLibrarySetupPassword1(mContext m$) {
    return (5);
  }

  //<< #define StrCOMDocumentLibrarySetupPassword1 $$GetPropertyName^COMConst("COMDocumentLibrarySetup",5)
  public static Object $$$StrCOMDocumentLibrarySetupPassword1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDocumentLibrarySetup",5));
  }

  //<< #define FldCOMDocumentLibrarySetupConfigurationNumber 1
  public static Object $$$FldCOMDocumentLibrarySetupConfigurationNumber(mContext m$) {
    return (1);
  }

  //<< #define StrCOMDocumentLibrarySetupConfigurationNumber $$GetPropertyName^COMConst("COMDocumentLibrarySetup",,1)
  public static Object $$$StrCOMDocumentLibrarySetupConfigurationNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMDocumentLibrarySetup",null,1));
  }

  //<< 
  //<< #define COMEditorConfigurationToolbarSet(%obj) $piece(%obj,"~",1)
  public static Object $$$COMEditorConfigurationToolbarSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMEditorConfigurationToolbarSetSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMEditorConfigurationToolbarSet 1
  public static Object $$$FldCOMEditorConfigurationToolbarSet(mContext m$) {
    return (1);
  }

  //<< #define StrCOMEditorConfigurationToolbarSet $$GetPropertyName^COMConst("COMEditorConfiguration",1)
  public static Object $$$StrCOMEditorConfigurationToolbarSet(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMEditorConfiguration",1));
  }

  //<< #define COMEditorConfigurationSkin(%obj) $piece(%obj,"~",2)
  public static Object $$$COMEditorConfigurationSkin(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMEditorConfigurationSkinSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMEditorConfigurationSkin 2
  public static Object $$$FldCOMEditorConfigurationSkin(mContext m$) {
    return (2);
  }

  //<< #define StrCOMEditorConfigurationSkin $$GetPropertyName^COMConst("COMEditorConfiguration",2)
  public static Object $$$StrCOMEditorConfigurationSkin(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMEditorConfiguration",2));
  }

  //<< #define COMEditorConfigurationImageDirectory(%obj) $piece(%obj,"~",3)
  public static Object $$$COMEditorConfigurationImageDirectory(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMEditorConfigurationImageDirectorySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMEditorConfigurationImageDirectory 3
  public static Object $$$FldCOMEditorConfigurationImageDirectory(mContext m$) {
    return (3);
  }

  //<< #define StrCOMEditorConfigurationImageDirectory $$GetPropertyName^COMConst("COMEditorConfiguration",3)
  public static Object $$$StrCOMEditorConfigurationImageDirectory(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMEditorConfiguration",3));
  }

  //<< #define COMEditorConfigurationMaximumCharacterCount(%obj) $piece(%obj,"~",4)
  public static Object $$$COMEditorConfigurationMaximumCharacterCount(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMEditorConfigurationMaximumCharacterCountSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMEditorConfigurationMaximumCharacterCount 4
  public static Object $$$FldCOMEditorConfigurationMaximumCharacterCount(mContext m$) {
    return (4);
  }

  //<< #define StrCOMEditorConfigurationMaximumCharacterCount $$GetPropertyName^COMConst("COMEditorConfiguration",4)
  public static Object $$$StrCOMEditorConfigurationMaximumCharacterCount(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMEditorConfiguration",4));
  }

  //<< #define COMEditorConfigurationUseStandardTemplates(%obj) $piece(%obj,"~",5)
  public static Object $$$COMEditorConfigurationUseStandardTemplates(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMEditorConfigurationUseStandardTemplatesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMEditorConfigurationUseStandardTemplates 5
  public static Object $$$FldCOMEditorConfigurationUseStandardTemplates(mContext m$) {
    return (5);
  }

  //<< #define StrCOMEditorConfigurationUseStandardTemplates $$GetPropertyName^COMConst("COMEditorConfiguration",5)
  public static Object $$$StrCOMEditorConfigurationUseStandardTemplates(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMEditorConfiguration",5));
  }

  //<< #define FldCOMEditorConfigurationCompany1 1
  public static Object $$$FldCOMEditorConfigurationCompany1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMEditorConfigurationCompany1 $$GetPropertyName^COMConst("COMEditorConfiguration",,1)
  public static Object $$$StrCOMEditorConfigurationCompany1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMEditorConfiguration",null,1));
  }

  //<< #define FldCOMEditorConfigurationEditorName 2
  public static Object $$$FldCOMEditorConfigurationEditorName(mContext m$) {
    return (2);
  }

  //<< #define StrCOMEditorConfigurationEditorName $$GetPropertyName^COMConst("COMEditorConfiguration",,2)
  public static Object $$$StrCOMEditorConfigurationEditorName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMEditorConfiguration",null,2));
  }

  //<< 
  //<< #define COMEntityName(%obj) $piece(%obj,"~",1)
  public static Object $$$COMEntityName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMEntityNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMEntityName 1
  public static Object $$$FldCOMEntityName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMEntityName $$GetPropertyName^COMConst("COMEntity",1)
  public static Object $$$StrCOMEntityName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMEntity",1));
  }

  //<< #define COMEntityNamespace(%obj) $piece(%obj,"~",2)
  public static Object $$$COMEntityNamespace(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMEntityNamespaceSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMEntityNamespace 2
  public static Object $$$FldCOMEntityNamespace(mContext m$) {
    return (2);
  }

  //<< #define StrCOMEntityNamespace $$GetPropertyName^COMConst("COMEntity",2)
  public static Object $$$StrCOMEntityNamespace(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMEntity",2));
  }

  //<< #define FldCOMEntityID1 1
  public static Object $$$FldCOMEntityID1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMEntityID1 $$GetPropertyName^COMConst("COMEntity",,1)
  public static Object $$$StrCOMEntityID1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMEntity",null,1));
  }

  //<< 
  //<< #define COMFCKEditorDialogHeight(%obj) $piece(%obj,"~",1)
  public static Object $$$COMFCKEditorDialogHeight(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMFCKEditorDialogHeightSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMFCKEditorDialogHeight 1
  public static Object $$$FldCOMFCKEditorDialogHeight(mContext m$) {
    return (1);
  }

  //<< #define StrCOMFCKEditorDialogHeight $$GetPropertyName^COMConst("COMFCKEditor",1)
  public static Object $$$StrCOMFCKEditorDialogHeight(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMFCKEditor",1));
  }

  //<< #define COMFCKEditorDialogWidth(%obj) $piece(%obj,"~",2)
  public static Object $$$COMFCKEditorDialogWidth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMFCKEditorDialogWidthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMFCKEditorDialogWidth 2
  public static Object $$$FldCOMFCKEditorDialogWidth(mContext m$) {
    return (2);
  }

  //<< #define StrCOMFCKEditorDialogWidth $$GetPropertyName^COMConst("COMFCKEditor",2)
  public static Object $$$StrCOMFCKEditorDialogWidth(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMFCKEditor",2));
  }

  //<< #define FldCOMFCKEditorUser1 1
  public static Object $$$FldCOMFCKEditorUser1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMFCKEditorUser1 $$GetPropertyName^COMConst("COMFCKEditor",,1)
  public static Object $$$StrCOMFCKEditorUser1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMFCKEditor",null,1));
  }

  //<< 
  //<< #define COMGridEditLayoutWidth(%obj) $piece(%obj,"~",1)
  public static Object $$$COMGridEditLayoutWidth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMGridEditLayoutWidthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMGridEditLayoutWidth 1
  public static Object $$$FldCOMGridEditLayoutWidth(mContext m$) {
    return (1);
  }

  //<< #define StrCOMGridEditLayoutWidth $$GetPropertyName^COMConst("COMGridEditLayout",1)
  public static Object $$$StrCOMGridEditLayoutWidth(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayout",1));
  }

  //<< #define COMGridEditLayoutColumnOrder(%obj) $piece(%obj,"~",2)
  public static Object $$$COMGridEditLayoutColumnOrder(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMGridEditLayoutColumnOrderSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMGridEditLayoutColumnOrder 2
  public static Object $$$FldCOMGridEditLayoutColumnOrder(mContext m$) {
    return (2);
  }

  //<< #define StrCOMGridEditLayoutColumnOrder $$GetPropertyName^COMConst("COMGridEditLayout",2)
  public static Object $$$StrCOMGridEditLayoutColumnOrder(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayout",2));
  }

  //<< #define COMGridEditLayoutHidden(%obj) $piece(%obj,"~",3)
  public static Object $$$COMGridEditLayoutHidden(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMGridEditLayoutHiddenSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMGridEditLayoutHidden 3
  public static Object $$$FldCOMGridEditLayoutHidden(mContext m$) {
    return (3);
  }

  //<< #define StrCOMGridEditLayoutHidden $$GetPropertyName^COMConst("COMGridEditLayout",3)
  public static Object $$$StrCOMGridEditLayoutHidden(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayout",3));
  }

  //<< #define FldCOMGridEditLayoutUser1 1
  public static Object $$$FldCOMGridEditLayoutUser1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMGridEditLayoutUser1 $$GetPropertyName^COMConst("COMGridEditLayout",,1)
  public static Object $$$StrCOMGridEditLayoutUser1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayout",null,1));
  }

  //<< #define FldCOMGridEditLayoutForm 2
  public static Object $$$FldCOMGridEditLayoutForm(mContext m$) {
    return (2);
  }

  //<< #define StrCOMGridEditLayoutForm $$GetPropertyName^COMConst("COMGridEditLayout",,2)
  public static Object $$$StrCOMGridEditLayoutForm(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayout",null,2));
  }

  //<< #define FldCOMGridEditLayoutColumn1 3
  public static Object $$$FldCOMGridEditLayoutColumn1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMGridEditLayoutColumn1 $$GetPropertyName^COMConst("COMGridEditLayout",,3)
  public static Object $$$StrCOMGridEditLayoutColumn1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayout",null,3));
  }

  //<< 
  //<< #define COMGridEditLayoutPopupLeft1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMGridEditLayoutPopupLeft1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMGridEditLayoutPopupLeft1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMGridEditLayoutPopupLeft1 1
  public static Object $$$FldCOMGridEditLayoutPopupLeft1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMGridEditLayoutPopupLeft1 $$GetPropertyName^COMConst("COMGridEditLayoutPopup",1)
  public static Object $$$StrCOMGridEditLayoutPopupLeft1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayoutPopup",1));
  }

  //<< #define COMGridEditLayoutPopupTop1(%obj) $piece(%obj,"~",2)
  public static Object $$$COMGridEditLayoutPopupTop1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMGridEditLayoutPopupTop1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMGridEditLayoutPopupTop1 2
  public static Object $$$FldCOMGridEditLayoutPopupTop1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMGridEditLayoutPopupTop1 $$GetPropertyName^COMConst("COMGridEditLayoutPopup",2)
  public static Object $$$StrCOMGridEditLayoutPopupTop1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayoutPopup",2));
  }

  //<< #define COMGridEditLayoutPopupHeight(%obj) $piece(%obj,"~",3)
  public static Object $$$COMGridEditLayoutPopupHeight(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMGridEditLayoutPopupHeightSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMGridEditLayoutPopupHeight 3
  public static Object $$$FldCOMGridEditLayoutPopupHeight(mContext m$) {
    return (3);
  }

  //<< #define StrCOMGridEditLayoutPopupHeight $$GetPropertyName^COMConst("COMGridEditLayoutPopup",3)
  public static Object $$$StrCOMGridEditLayoutPopupHeight(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayoutPopup",3));
  }

  //<< #define COMGridEditLayoutPopupWidth(%obj) $piece(%obj,"~",4)
  public static Object $$$COMGridEditLayoutPopupWidth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMGridEditLayoutPopupWidthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMGridEditLayoutPopupWidth 4
  public static Object $$$FldCOMGridEditLayoutPopupWidth(mContext m$) {
    return (4);
  }

  //<< #define StrCOMGridEditLayoutPopupWidth $$GetPropertyName^COMConst("COMGridEditLayoutPopup",4)
  public static Object $$$StrCOMGridEditLayoutPopupWidth(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayoutPopup",4));
  }

  //<< #define COMGridEditLayoutPopupVisible(%obj) $piece(%obj,"~",5)
  public static Object $$$COMGridEditLayoutPopupVisible(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMGridEditLayoutPopupVisibleSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMGridEditLayoutPopupVisible 5
  public static Object $$$FldCOMGridEditLayoutPopupVisible(mContext m$) {
    return (5);
  }

  //<< #define StrCOMGridEditLayoutPopupVisible $$GetPropertyName^COMConst("COMGridEditLayoutPopup",5)
  public static Object $$$StrCOMGridEditLayoutPopupVisible(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayoutPopup",5));
  }

  //<< #define COMGridEditLayoutPopupFontSize(%obj) $piece(%obj,"~",6)
  public static Object $$$COMGridEditLayoutPopupFontSize(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMGridEditLayoutPopupFontSizeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMGridEditLayoutPopupFontSize 6
  public static Object $$$FldCOMGridEditLayoutPopupFontSize(mContext m$) {
    return (6);
  }

  //<< #define StrCOMGridEditLayoutPopupFontSize $$GetPropertyName^COMConst("COMGridEditLayoutPopup",6)
  public static Object $$$StrCOMGridEditLayoutPopupFontSize(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayoutPopup",6));
  }

  //<< #define FldCOMGridEditLayoutPopupUser1 1
  public static Object $$$FldCOMGridEditLayoutPopupUser1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMGridEditLayoutPopupUser1 $$GetPropertyName^COMConst("COMGridEditLayoutPopup",,1)
  public static Object $$$StrCOMGridEditLayoutPopupUser1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayoutPopup",null,1));
  }

  //<< #define FldCOMGridEditLayoutPopupForm 2
  public static Object $$$FldCOMGridEditLayoutPopupForm(mContext m$) {
    return (2);
  }

  //<< #define StrCOMGridEditLayoutPopupForm $$GetPropertyName^COMConst("COMGridEditLayoutPopup",,2)
  public static Object $$$StrCOMGridEditLayoutPopupForm(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditLayoutPopup",null,2));
  }

  //<< 
  //<< #define COMGridEditParameterSharedForm(%obj) $piece(%obj,"~",1)
  public static Object $$$COMGridEditParameterSharedForm(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMGridEditParameterSharedFormSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterSharedForm 1
  public static Object $$$FldCOMGridEditParameterSharedForm(mContext m$) {
    return (1);
  }

  //<< #define StrCOMGridEditParameterSharedForm $$GetPropertyName^COMConst("COMGridEditParameter",1)
  public static Object $$$StrCOMGridEditParameterSharedForm(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",1));
  }

  //<< #define COMGridEditParameterMaximumHeight(%obj) $piece(%obj,"~",2)
  public static Object $$$COMGridEditParameterMaximumHeight(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMGridEditParameterMaximumHeightSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterMaximumHeight 2
  public static Object $$$FldCOMGridEditParameterMaximumHeight(mContext m$) {
    return (2);
  }

  //<< #define StrCOMGridEditParameterMaximumHeight $$GetPropertyName^COMConst("COMGridEditParameter",2)
  public static Object $$$StrCOMGridEditParameterMaximumHeight(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",2));
  }

  //<< #define COMGridEditParameterGridName(%obj) $piece(%obj,"~",3)
  public static Object $$$COMGridEditParameterGridName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMGridEditParameterGridNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterGridName 3
  public static Object $$$FldCOMGridEditParameterGridName(mContext m$) {
    return (3);
  }

  //<< #define StrCOMGridEditParameterGridName $$GetPropertyName^COMConst("COMGridEditParameter",3)
  public static Object $$$StrCOMGridEditParameterGridName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",3));
  }

  //<< #define COMGridEditParameterUpdateFields(%obj) $piece(%obj,"~",4)
  public static Object $$$COMGridEditParameterUpdateFields(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMGridEditParameterUpdateFieldsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterUpdateFields 4
  public static Object $$$FldCOMGridEditParameterUpdateFields(mContext m$) {
    return (4);
  }

  //<< #define StrCOMGridEditParameterUpdateFields $$GetPropertyName^COMConst("COMGridEditParameter",4)
  public static Object $$$StrCOMGridEditParameterUpdateFields(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",4));
  }

  //<< #define COMGridEditParameterClearFields(%obj) $piece(%obj,"~",5)
  public static Object $$$COMGridEditParameterClearFields(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMGridEditParameterClearFieldsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterClearFields 5
  public static Object $$$FldCOMGridEditParameterClearFields(mContext m$) {
    return (5);
  }

  //<< #define StrCOMGridEditParameterClearFields $$GetPropertyName^COMConst("COMGridEditParameter",5)
  public static Object $$$StrCOMGridEditParameterClearFields(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",5));
  }

  //<< #define COMGridEditParameterDefaultFields(%obj) $piece(%obj,"~",6)
  public static Object $$$COMGridEditParameterDefaultFields(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMGridEditParameterDefaultFieldsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterDefaultFields 6
  public static Object $$$FldCOMGridEditParameterDefaultFields(mContext m$) {
    return (6);
  }

  //<< #define StrCOMGridEditParameterDefaultFields $$GetPropertyName^COMConst("COMGridEditParameter",6)
  public static Object $$$StrCOMGridEditParameterDefaultFields(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",6));
  }

  //<< #define COMGridEditParameterEnabled(%obj) $piece(%obj,"~",7)
  public static Object $$$COMGridEditParameterEnabled(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMGridEditParameterEnabledSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterEnabled 7
  public static Object $$$FldCOMGridEditParameterEnabled(mContext m$) {
    return (7);
  }

  //<< #define StrCOMGridEditParameterEnabled $$GetPropertyName^COMConst("COMGridEditParameter",7)
  public static Object $$$StrCOMGridEditParameterEnabled(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",7));
  }

  //<< #define COMGridEditParameterCallBack(%obj) $piece(%obj,"~",8)
  public static Object $$$COMGridEditParameterCallBack(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMGridEditParameterCallBackSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterCallBack 8
  public static Object $$$FldCOMGridEditParameterCallBack(mContext m$) {
    return (8);
  }

  //<< #define StrCOMGridEditParameterCallBack $$GetPropertyName^COMConst("COMGridEditParameter",8)
  public static Object $$$StrCOMGridEditParameterCallBack(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",8));
  }

  //<< #define COMGridEditParameterContainer(%obj) $piece(%obj,"~",9)
  public static Object $$$COMGridEditParameterContainer(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMGridEditParameterContainerSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterContainer 9
  public static Object $$$FldCOMGridEditParameterContainer(mContext m$) {
    return (9);
  }

  //<< #define StrCOMGridEditParameterContainer $$GetPropertyName^COMConst("COMGridEditParameter",9)
  public static Object $$$StrCOMGridEditParameterContainer(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",9));
  }

  //<< #define COMGridEditParameterDontUpdateContainer(%obj) $piece(%obj,"~",10)
  public static Object $$$COMGridEditParameterDontUpdateContainer(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$COMGridEditParameterDontUpdateContainerSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterDontUpdateContainer 10
  public static Object $$$FldCOMGridEditParameterDontUpdateContainer(mContext m$) {
    return (10);
  }

  //<< #define StrCOMGridEditParameterDontUpdateContainer $$GetPropertyName^COMConst("COMGridEditParameter",10)
  public static Object $$$StrCOMGridEditParameterDontUpdateContainer(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",10));
  }

  //<< #define COMGridEditParameterLinks(%obj) $piece(%obj,"~",11)
  public static Object $$$COMGridEditParameterLinks(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$COMGridEditParameterLinksSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterLinks 11
  public static Object $$$FldCOMGridEditParameterLinks(mContext m$) {
    return (11);
  }

  //<< #define StrCOMGridEditParameterLinks $$GetPropertyName^COMConst("COMGridEditParameter",11)
  public static Object $$$StrCOMGridEditParameterLinks(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",11));
  }

  //<< #define COMGridEditParameterAllowDeleteOnLocked(%obj) $piece(%obj,"~",12)
  public static Object $$$COMGridEditParameterAllowDeleteOnLocked(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$COMGridEditParameterAllowDeleteOnLockedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterAllowDeleteOnLocked 12
  public static Object $$$FldCOMGridEditParameterAllowDeleteOnLocked(mContext m$) {
    return (12);
  }

  //<< #define StrCOMGridEditParameterAllowDeleteOnLocked $$GetPropertyName^COMConst("COMGridEditParameter",12)
  public static Object $$$StrCOMGridEditParameterAllowDeleteOnLocked(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",12));
  }

  //<< #define COMGridEditParameterExpandLines(%obj) $piece(%obj,"~",13)
  public static Object $$$COMGridEditParameterExpandLines(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$COMGridEditParameterExpandLinesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterExpandLines 13
  public static Object $$$FldCOMGridEditParameterExpandLines(mContext m$) {
    return (13);
  }

  //<< #define StrCOMGridEditParameterExpandLines $$GetPropertyName^COMConst("COMGridEditParameter",13)
  public static Object $$$StrCOMGridEditParameterExpandLines(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",13));
  }

  //<< #define COMGridEditParameterDontStoreAll(%obj) $piece(%obj,"~",14)
  public static Object $$$COMGridEditParameterDontStoreAll(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",14));
  }

  public static void $$$COMGridEditParameterDontStoreAllSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",14).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterDontStoreAll 14
  public static Object $$$FldCOMGridEditParameterDontStoreAll(mContext m$) {
    return (14);
  }

  //<< #define StrCOMGridEditParameterDontStoreAll $$GetPropertyName^COMConst("COMGridEditParameter",14)
  public static Object $$$StrCOMGridEditParameterDontStoreAll(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",14));
  }

  //<< #define COMGridEditParameterShowHeaderKeys(%obj) $piece(%obj,"~",15)
  public static Object $$$COMGridEditParameterShowHeaderKeys(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",15));
  }

  public static void $$$COMGridEditParameterShowHeaderKeysSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",15).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterShowHeaderKeys 15
  public static Object $$$FldCOMGridEditParameterShowHeaderKeys(mContext m$) {
    return (15);
  }

  //<< #define StrCOMGridEditParameterShowHeaderKeys $$GetPropertyName^COMConst("COMGridEditParameter",15)
  public static Object $$$StrCOMGridEditParameterShowHeaderKeys(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",15));
  }

  //<< #define COMGridEditParameterCOMViewGrid(%obj) $piece(%obj,"~",16)
  public static Object $$$COMGridEditParameterCOMViewGrid(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",16));
  }

  public static void $$$COMGridEditParameterCOMViewGridSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",16).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterCOMViewGrid 16
  public static Object $$$FldCOMGridEditParameterCOMViewGrid(mContext m$) {
    return (16);
  }

  //<< #define StrCOMGridEditParameterCOMViewGrid $$GetPropertyName^COMConst("COMGridEditParameter",16)
  public static Object $$$StrCOMGridEditParameterCOMViewGrid(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",16));
  }

  //<< #define COMGridEditParameterTabs(%obj) $piece(%obj,"~",17)
  public static Object $$$COMGridEditParameterTabs(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",17));
  }

  public static void $$$COMGridEditParameterTabsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",17).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterTabs 17
  public static Object $$$FldCOMGridEditParameterTabs(mContext m$) {
    return (17);
  }

  //<< #define StrCOMGridEditParameterTabs $$GetPropertyName^COMConst("COMGridEditParameter",17)
  public static Object $$$StrCOMGridEditParameterTabs(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",17));
  }

  //<< #define COMGridEditParameterEnabledTest(%obj) $piece(%obj,"~",18)
  public static Object $$$COMGridEditParameterEnabledTest(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",18));
  }

  public static void $$$COMGridEditParameterEnabledTestSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",18).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterEnabledTest 18
  public static Object $$$FldCOMGridEditParameterEnabledTest(mContext m$) {
    return (18);
  }

  //<< #define StrCOMGridEditParameterEnabledTest $$GetPropertyName^COMConst("COMGridEditParameter",18)
  public static Object $$$StrCOMGridEditParameterEnabledTest(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",18));
  }

  //<< #define COMGridEditParameterHiddenColumns(%obj) $piece(%obj,"~",19)
  public static Object $$$COMGridEditParameterHiddenColumns(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",19));
  }

  public static void $$$COMGridEditParameterHiddenColumnsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",19).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterHiddenColumns 19
  public static Object $$$FldCOMGridEditParameterHiddenColumns(mContext m$) {
    return (19);
  }

  //<< #define StrCOMGridEditParameterHiddenColumns $$GetPropertyName^COMConst("COMGridEditParameter",19)
  public static Object $$$StrCOMGridEditParameterHiddenColumns(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",19));
  }

  //<< #define COMGridEditParameterMaxWidth(%obj) $piece(%obj,"~",20)
  public static Object $$$COMGridEditParameterMaxWidth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",20));
  }

  public static void $$$COMGridEditParameterMaxWidthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",20).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterMaxWidth 20
  public static Object $$$FldCOMGridEditParameterMaxWidth(mContext m$) {
    return (20);
  }

  //<< #define StrCOMGridEditParameterMaxWidth $$GetPropertyName^COMConst("COMGridEditParameter",20)
  public static Object $$$StrCOMGridEditParameterMaxWidth(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",20));
  }

  //<< #define COMGridEditParameterNewLine(%obj) $piece(%obj,"~",21)
  public static Object $$$COMGridEditParameterNewLine(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",21));
  }

  public static void $$$COMGridEditParameterNewLineSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",21).set(_setval.get());
  }

  //<< #define FldCOMGridEditParameterNewLine 21
  public static Object $$$FldCOMGridEditParameterNewLine(mContext m$) {
    return (21);
  }

  //<< #define StrCOMGridEditParameterNewLine $$GetPropertyName^COMConst("COMGridEditParameter",21)
  public static Object $$$StrCOMGridEditParameterNewLine(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",21));
  }

  //<< #define FldCOMGridEditParameterForm 1
  public static Object $$$FldCOMGridEditParameterForm(mContext m$) {
    return (1);
  }

  //<< #define StrCOMGridEditParameterForm $$GetPropertyName^COMConst("COMGridEditParameter",,1)
  public static Object $$$StrCOMGridEditParameterForm(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",null,1));
  }

  //<< #define FldCOMGridEditParameterParameter1 2
  public static Object $$$FldCOMGridEditParameterParameter1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMGridEditParameterParameter1 $$GetPropertyName^COMConst("COMGridEditParameter",,2)
  public static Object $$$StrCOMGridEditParameterParameter1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameter",null,2));
  }

  //<< 
  //<< #define FldCOMGridEditParameters 1
  public static Object $$$FldCOMGridEditParameters(mContext m$) {
    return (1);
  }

  //<< #define StrCOMGridEditParameters $$GetPropertyName^COMConst("COMGridEditParameters",,1)
  public static Object $$$StrCOMGridEditParameters(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMGridEditParameters",null,1));
  }

  //<< 
  //<< #define COMHCCalculateMethod(%obj) $piece(%obj,"~",1)
  public static Object $$$COMHCCalculateMethod(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMHCCalculateMethodSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMHCCalculateMethod 1
  public static Object $$$FldCOMHCCalculateMethod(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHCCalculateMethod $$GetPropertyName^COMConst("COMHCCalculate",1)
  public static Object $$$StrCOMHCCalculateMethod(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCCalculate",1));
  }

  //<< #define COMHCCalculateLocation(%obj) $piece(%obj,"~",2)
  public static Object $$$COMHCCalculateLocation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMHCCalculateLocationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMHCCalculateLocation 2
  public static Object $$$FldCOMHCCalculateLocation(mContext m$) {
    return (2);
  }

  //<< #define StrCOMHCCalculateLocation $$GetPropertyName^COMConst("COMHCCalculate",2)
  public static Object $$$StrCOMHCCalculateLocation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCCalculate",2));
  }

  //<< #define COMHCCalculateStart(%obj) $piece(%obj,"~",3)
  public static Object $$$COMHCCalculateStart(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMHCCalculateStartSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMHCCalculateStart 3
  public static Object $$$FldCOMHCCalculateStart(mContext m$) {
    return (3);
  }

  //<< #define StrCOMHCCalculateStart $$GetPropertyName^COMConst("COMHCCalculate",3)
  public static Object $$$StrCOMHCCalculateStart(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCCalculate",3));
  }

  //<< #define COMHCCalculateEnd1(%obj) $piece(%obj,"~",4)
  public static Object $$$COMHCCalculateEnd1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMHCCalculateEnd1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMHCCalculateEnd1 4
  public static Object $$$FldCOMHCCalculateEnd1(mContext m$) {
    return (4);
  }

  //<< #define StrCOMHCCalculateEnd1 $$GetPropertyName^COMConst("COMHCCalculate",4)
  public static Object $$$StrCOMHCCalculateEnd1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCCalculate",4));
  }

  //<< #define COMHCCalculateLevel1(%obj) $piece(%obj,"~",5)
  public static Object $$$COMHCCalculateLevel1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMHCCalculateLevel1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMHCCalculateLevel1 5
  public static Object $$$FldCOMHCCalculateLevel1(mContext m$) {
    return (5);
  }

  //<< #define StrCOMHCCalculateLevel1 $$GetPropertyName^COMConst("COMHCCalculate",5)
  public static Object $$$StrCOMHCCalculateLevel1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCCalculate",5));
  }

  //<< #define COMHCCalculateSchedule(%obj) $piece(%obj,"~",6)
  public static Object $$$COMHCCalculateSchedule(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMHCCalculateScheduleSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMHCCalculateSchedule 6
  public static Object $$$FldCOMHCCalculateSchedule(mContext m$) {
    return (6);
  }

  //<< #define StrCOMHCCalculateSchedule $$GetPropertyName^COMConst("COMHCCalculate",6)
  public static Object $$$StrCOMHCCalculateSchedule(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCCalculate",6));
  }

  //<< #define COMHCCalculateSource(%obj) $piece(%obj,"~",7)
  public static Object $$$COMHCCalculateSource(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMHCCalculateSourceSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMHCCalculateSource 7
  public static Object $$$FldCOMHCCalculateSource(mContext m$) {
    return (7);
  }

  //<< #define StrCOMHCCalculateSource $$GetPropertyName^COMConst("COMHCCalculate",7)
  public static Object $$$StrCOMHCCalculateSource(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCCalculate",7));
  }

  //<< #define COMHCCalculateType(%obj) $piece(%obj,"~",8)
  public static Object $$$COMHCCalculateType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMHCCalculateTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMHCCalculateType 8
  public static Object $$$FldCOMHCCalculateType(mContext m$) {
    return (8);
  }

  //<< #define StrCOMHCCalculateType $$GetPropertyName^COMConst("COMHCCalculate",8)
  public static Object $$$StrCOMHCCalculateType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCCalculate",8));
  }

  //<< #define FldCOMHCCalculateSite 1
  public static Object $$$FldCOMHCCalculateSite(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHCCalculateSite $$GetPropertyName^COMConst("COMHCCalculate",,1)
  public static Object $$$StrCOMHCCalculateSite(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCCalculate",null,1));
  }

  //<< #define FldCOMHCCalculateEntry 2
  public static Object $$$FldCOMHCCalculateEntry(mContext m$) {
    return (2);
  }

  //<< #define StrCOMHCCalculateEntry $$GetPropertyName^COMConst("COMHCCalculate",,2)
  public static Object $$$StrCOMHCCalculateEntry(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCCalculate",null,2));
  }

  //<< 
  //<< #define COMHCMethodDescription(%obj) $piece(%obj,"~",1)
  public static Object $$$COMHCMethodDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMHCMethodDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMHCMethodDescription 1
  public static Object $$$FldCOMHCMethodDescription(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHCMethodDescription $$GetPropertyName^COMConst("COMHCMethod",1)
  public static Object $$$StrCOMHCMethodDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCMethod",1));
  }

  //<< #define COMHCMethodCode(%obj) $piece(%obj,"~",2)
  public static Object $$$COMHCMethodCode(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMHCMethodCodeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMHCMethodCode 2
  public static Object $$$FldCOMHCMethodCode(mContext m$) {
    return (2);
  }

  //<< #define StrCOMHCMethodCode $$GetPropertyName^COMConst("COMHCMethod",2)
  public static Object $$$StrCOMHCMethodCode(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCMethod",2));
  }

  //<< #define COMHCMethodCheckType(%obj) $piece(%obj,"~",3)
  public static Object $$$COMHCMethodCheckType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMHCMethodCheckTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMHCMethodCheckType 3
  public static Object $$$FldCOMHCMethodCheckType(mContext m$) {
    return (3);
  }

  //<< #define StrCOMHCMethodCheckType $$GetPropertyName^COMConst("COMHCMethod",3)
  public static Object $$$StrCOMHCMethodCheckType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCMethod",3));
  }

  //<< #define FldCOMHCMethodMethod 1
  public static Object $$$FldCOMHCMethodMethod(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHCMethodMethod $$GetPropertyName^COMConst("COMHCMethod",,1)
  public static Object $$$StrCOMHCMethodMethod(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCMethod",null,1));
  }

  //<< 
  //<< #define COMHCResultLocation(%obj) $piece(%obj,"~",1)
  public static Object $$$COMHCResultLocation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMHCResultLocationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMHCResultLocation 1
  public static Object $$$FldCOMHCResultLocation(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHCResultLocation $$GetPropertyName^COMConst("COMHCResult",1)
  public static Object $$$StrCOMHCResultLocation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",1));
  }

  //<< #define COMHCResultTotal(%obj) $piece(%obj,"~",2)
  public static Object $$$COMHCResultTotal(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMHCResultTotalSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMHCResultTotal 2
  public static Object $$$FldCOMHCResultTotal(mContext m$) {
    return (2);
  }

  //<< #define StrCOMHCResultTotal $$GetPropertyName^COMConst("COMHCResult",2)
  public static Object $$$StrCOMHCResultTotal(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",2));
  }

  //<< #define COMHCResultHashValue(%obj) $piece(%obj,"~",3)
  public static Object $$$COMHCResultHashValue(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMHCResultHashValueSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMHCResultHashValue 3
  public static Object $$$FldCOMHCResultHashValue(mContext m$) {
    return (3);
  }

  //<< #define StrCOMHCResultHashValue $$GetPropertyName^COMConst("COMHCResult",3)
  public static Object $$$StrCOMHCResultHashValue(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",3));
  }

  //<< #define COMHCResultStart(%obj) $piece(%obj,"~",4)
  public static Object $$$COMHCResultStart(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMHCResultStartSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMHCResultStart 4
  public static Object $$$FldCOMHCResultStart(mContext m$) {
    return (4);
  }

  //<< #define StrCOMHCResultStart $$GetPropertyName^COMConst("COMHCResult",4)
  public static Object $$$StrCOMHCResultStart(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",4));
  }

  //<< #define COMHCResultEnd1(%obj) $piece(%obj,"~",5)
  public static Object $$$COMHCResultEnd1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMHCResultEnd1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMHCResultEnd1 5
  public static Object $$$FldCOMHCResultEnd1(mContext m$) {
    return (5);
  }

  //<< #define StrCOMHCResultEnd1 $$GetPropertyName^COMConst("COMHCResult",5)
  public static Object $$$StrCOMHCResultEnd1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",5));
  }

  //<< #define COMHCResultComplete(%obj) $piece(%obj,"~",6)
  public static Object $$$COMHCResultComplete(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMHCResultCompleteSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMHCResultComplete 6
  public static Object $$$FldCOMHCResultComplete(mContext m$) {
    return (6);
  }

  //<< #define StrCOMHCResultComplete $$GetPropertyName^COMConst("COMHCResult",6)
  public static Object $$$StrCOMHCResultComplete(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",6));
  }

  //<< #define COMHCResultDuration(%obj) $piece(%obj,"~",7)
  public static Object $$$COMHCResultDuration(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMHCResultDurationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMHCResultDuration 7
  public static Object $$$FldCOMHCResultDuration(mContext m$) {
    return (7);
  }

  //<< #define StrCOMHCResultDuration $$GetPropertyName^COMConst("COMHCResult",7)
  public static Object $$$StrCOMHCResultDuration(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",7));
  }

  //<< #define COMHCResultStatus(%obj) $piece(%obj,"~",8)
  public static Object $$$COMHCResultStatus(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMHCResultStatusSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMHCResultStatus 8
  public static Object $$$FldCOMHCResultStatus(mContext m$) {
    return (8);
  }

  //<< #define StrCOMHCResultStatus $$GetPropertyName^COMConst("COMHCResult",8)
  public static Object $$$StrCOMHCResultStatus(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",8));
  }

  //<< #define COMHCResultType1(%obj) $piece(%obj,"~",9)
  public static Object $$$COMHCResultType1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMHCResultType1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMHCResultType1 9
  public static Object $$$FldCOMHCResultType1(mContext m$) {
    return (9);
  }

  //<< #define StrCOMHCResultType1 $$GetPropertyName^COMConst("COMHCResult",9)
  public static Object $$$StrCOMHCResultType1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",9));
  }

  //<< #define COMHCResultMethod1(%obj) $piece(%obj,"~",10)
  public static Object $$$COMHCResultMethod1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$COMHCResultMethod1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldCOMHCResultMethod1 10
  public static Object $$$FldCOMHCResultMethod1(mContext m$) {
    return (10);
  }

  //<< #define StrCOMHCResultMethod1 $$GetPropertyName^COMConst("COMHCResult",10)
  public static Object $$$StrCOMHCResultMethod1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",10));
  }

  //<< #define COMHCResultDate2(%obj) $piece(%obj,"~",11)
  public static Object $$$COMHCResultDate2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$COMHCResultDate2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldCOMHCResultDate2 11
  public static Object $$$FldCOMHCResultDate2(mContext m$) {
    return (11);
  }

  //<< #define StrCOMHCResultDate2 $$GetPropertyName^COMConst("COMHCResult",11)
  public static Object $$$StrCOMHCResultDate2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",11));
  }

  //<< #define COMHCResultSite1(%obj) $piece(%obj,"~",12)
  public static Object $$$COMHCResultSite1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$COMHCResultSite1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldCOMHCResultSite1 12
  public static Object $$$FldCOMHCResultSite1(mContext m$) {
    return (12);
  }

  //<< #define StrCOMHCResultSite1 $$GetPropertyName^COMConst("COMHCResult",12)
  public static Object $$$StrCOMHCResultSite1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",12));
  }

  //<< #define COMHCResultLevel1(%obj) $piece(%obj,"~",13)
  public static Object $$$COMHCResultLevel1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$COMHCResultLevel1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldCOMHCResultLevel1 13
  public static Object $$$FldCOMHCResultLevel1(mContext m$) {
    return (13);
  }

  //<< #define StrCOMHCResultLevel1 $$GetPropertyName^COMConst("COMHCResult",13)
  public static Object $$$StrCOMHCResultLevel1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",13));
  }

  //<< #define COMHCResultSource(%obj) $piece(%obj,"~",14)
  public static Object $$$COMHCResultSource(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",14));
  }

  public static void $$$COMHCResultSourceSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",14).set(_setval.get());
  }

  //<< #define FldCOMHCResultSource 14
  public static Object $$$FldCOMHCResultSource(mContext m$) {
    return (14);
  }

  //<< #define StrCOMHCResultSource $$GetPropertyName^COMConst("COMHCResult",14)
  public static Object $$$StrCOMHCResultSource(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",14));
  }

  //<< #define FldCOMHCResultEntry 1
  public static Object $$$FldCOMHCResultEntry(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHCResultEntry $$GetPropertyName^COMConst("COMHCResult",,1)
  public static Object $$$StrCOMHCResultEntry(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHCResult",null,1));
  }

  //<< 
  //<< #define COMHelpHelpText(%obj) $piece(%obj,"~",1)
  public static Object $$$COMHelpHelpText(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMHelpHelpTextSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMHelpHelpText 1
  public static Object $$$FldCOMHelpHelpText(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHelpHelpText $$GetPropertyName^COMConst("COMHelp",1)
  public static Object $$$StrCOMHelpHelpText(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelp",1));
  }

  //<< #define COMHelpCreatedBy(%obj) $piece(%obj,"~",2)
  public static Object $$$COMHelpCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMHelpCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMHelpCreatedBy 2
  public static Object $$$FldCOMHelpCreatedBy(mContext m$) {
    return (2);
  }

  //<< #define StrCOMHelpCreatedBy $$GetPropertyName^COMConst("COMHelp",2)
  public static Object $$$StrCOMHelpCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelp",2));
  }

  //<< #define COMHelpDateCreated(%obj) $piece(%obj,"~",3)
  public static Object $$$COMHelpDateCreated(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMHelpDateCreatedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMHelpDateCreated 3
  public static Object $$$FldCOMHelpDateCreated(mContext m$) {
    return (3);
  }

  //<< #define StrCOMHelpDateCreated $$GetPropertyName^COMConst("COMHelp",3)
  public static Object $$$StrCOMHelpDateCreated(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelp",3));
  }

  //<< #define COMHelpChangedBy(%obj) $piece(%obj,"~",4)
  public static Object $$$COMHelpChangedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMHelpChangedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMHelpChangedBy 4
  public static Object $$$FldCOMHelpChangedBy(mContext m$) {
    return (4);
  }

  //<< #define StrCOMHelpChangedBy $$GetPropertyName^COMConst("COMHelp",4)
  public static Object $$$StrCOMHelpChangedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelp",4));
  }

  //<< #define COMHelpDateChanged(%obj) $piece(%obj,"~",5)
  public static Object $$$COMHelpDateChanged(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMHelpDateChangedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMHelpDateChanged 5
  public static Object $$$FldCOMHelpDateChanged(mContext m$) {
    return (5);
  }

  //<< #define StrCOMHelpDateChanged $$GetPropertyName^COMConst("COMHelp",5)
  public static Object $$$StrCOMHelpDateChanged(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelp",5));
  }

  //<< #define FldCOMHelpFormName 1
  public static Object $$$FldCOMHelpFormName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHelpFormName $$GetPropertyName^COMConst("COMHelp",,1)
  public static Object $$$StrCOMHelpFormName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelp",null,1));
  }

  //<< #define FldCOMHelpLanguage1 2
  public static Object $$$FldCOMHelpLanguage1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMHelpLanguage1 $$GetPropertyName^COMConst("COMHelp",,2)
  public static Object $$$StrCOMHelpLanguage1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelp",null,2));
  }

  //<< 
  //<< #define COMHelpButtonRank(%obj) $piece(%obj,"~",3)
  public static Object $$$COMHelpButtonRank(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMHelpButtonRankSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMHelpButtonRank 3
  public static Object $$$FldCOMHelpButtonRank(mContext m$) {
    return (3);
  }

  //<< #define StrCOMHelpButtonRank $$GetPropertyName^COMConst("COMHelpButton",3)
  public static Object $$$StrCOMHelpButtonRank(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpButton",3));
  }

  //<< #define COMHelpButtonHelpText(%obj) $piece(%obj,"~",4)
  public static Object $$$COMHelpButtonHelpText(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMHelpButtonHelpTextSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMHelpButtonHelpText 4
  public static Object $$$FldCOMHelpButtonHelpText(mContext m$) {
    return (4);
  }

  //<< #define StrCOMHelpButtonHelpText $$GetPropertyName^COMConst("COMHelpButton",4)
  public static Object $$$StrCOMHelpButtonHelpText(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpButton",4));
  }

  //<< #define COMHelpButtonDateCreated(%obj) $piece(%obj,"~",5)
  public static Object $$$COMHelpButtonDateCreated(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMHelpButtonDateCreatedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMHelpButtonDateCreated 5
  public static Object $$$FldCOMHelpButtonDateCreated(mContext m$) {
    return (5);
  }

  //<< #define StrCOMHelpButtonDateCreated $$GetPropertyName^COMConst("COMHelpButton",5)
  public static Object $$$StrCOMHelpButtonDateCreated(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpButton",5));
  }

  //<< #define COMHelpButtonCreatedBy(%obj) $piece(%obj,"~",6)
  public static Object $$$COMHelpButtonCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMHelpButtonCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMHelpButtonCreatedBy 6
  public static Object $$$FldCOMHelpButtonCreatedBy(mContext m$) {
    return (6);
  }

  //<< #define StrCOMHelpButtonCreatedBy $$GetPropertyName^COMConst("COMHelpButton",6)
  public static Object $$$StrCOMHelpButtonCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpButton",6));
  }

  //<< #define COMHelpButtonDateChanged(%obj) $piece(%obj,"~",7)
  public static Object $$$COMHelpButtonDateChanged(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMHelpButtonDateChangedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMHelpButtonDateChanged 7
  public static Object $$$FldCOMHelpButtonDateChanged(mContext m$) {
    return (7);
  }

  //<< #define StrCOMHelpButtonDateChanged $$GetPropertyName^COMConst("COMHelpButton",7)
  public static Object $$$StrCOMHelpButtonDateChanged(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpButton",7));
  }

  //<< #define COMHelpButtonChangedBy(%obj) $piece(%obj,"~",8)
  public static Object $$$COMHelpButtonChangedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMHelpButtonChangedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMHelpButtonChangedBy 8
  public static Object $$$FldCOMHelpButtonChangedBy(mContext m$) {
    return (8);
  }

  //<< #define StrCOMHelpButtonChangedBy $$GetPropertyName^COMConst("COMHelpButton",8)
  public static Object $$$StrCOMHelpButtonChangedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpButton",8));
  }

  //<< #define FldCOMHelpButtonFormName 1
  public static Object $$$FldCOMHelpButtonFormName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHelpButtonFormName $$GetPropertyName^COMConst("COMHelpButton",,1)
  public static Object $$$StrCOMHelpButtonFormName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpButton",null,1));
  }

  //<< #define FldCOMHelpButtonLanguage1 2
  public static Object $$$FldCOMHelpButtonLanguage1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMHelpButtonLanguage1 $$GetPropertyName^COMConst("COMHelpButton",,2)
  public static Object $$$StrCOMHelpButtonLanguage1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpButton",null,2));
  }

  //<< #define FldCOMHelpButtonNumber 3
  public static Object $$$FldCOMHelpButtonNumber(mContext m$) {
    return (3);
  }

  //<< #define StrCOMHelpButtonNumber $$GetPropertyName^COMConst("COMHelpButton",,3)
  public static Object $$$StrCOMHelpButtonNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpButton",null,3));
  }

  //<< 
  //<< #define COMHelpFieldRank(%obj) $piece(%obj,"~",3)
  public static Object $$$COMHelpFieldRank(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMHelpFieldRankSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMHelpFieldRank 3
  public static Object $$$FldCOMHelpFieldRank(mContext m$) {
    return (3);
  }

  //<< #define StrCOMHelpFieldRank $$GetPropertyName^COMConst("COMHelpField",3)
  public static Object $$$StrCOMHelpFieldRank(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpField",3));
  }

  //<< #define COMHelpFieldHelpText(%obj) $piece(%obj,"~",4)
  public static Object $$$COMHelpFieldHelpText(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMHelpFieldHelpTextSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMHelpFieldHelpText 4
  public static Object $$$FldCOMHelpFieldHelpText(mContext m$) {
    return (4);
  }

  //<< #define StrCOMHelpFieldHelpText $$GetPropertyName^COMConst("COMHelpField",4)
  public static Object $$$StrCOMHelpFieldHelpText(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpField",4));
  }

  //<< #define COMHelpFieldDateCreated(%obj) $piece(%obj,"~",5)
  public static Object $$$COMHelpFieldDateCreated(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMHelpFieldDateCreatedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMHelpFieldDateCreated 5
  public static Object $$$FldCOMHelpFieldDateCreated(mContext m$) {
    return (5);
  }

  //<< #define StrCOMHelpFieldDateCreated $$GetPropertyName^COMConst("COMHelpField",5)
  public static Object $$$StrCOMHelpFieldDateCreated(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpField",5));
  }

  //<< #define COMHelpFieldCreatedBy(%obj) $piece(%obj,"~",6)
  public static Object $$$COMHelpFieldCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMHelpFieldCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMHelpFieldCreatedBy 6
  public static Object $$$FldCOMHelpFieldCreatedBy(mContext m$) {
    return (6);
  }

  //<< #define StrCOMHelpFieldCreatedBy $$GetPropertyName^COMConst("COMHelpField",6)
  public static Object $$$StrCOMHelpFieldCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpField",6));
  }

  //<< #define COMHelpFieldDateChanged(%obj) $piece(%obj,"~",7)
  public static Object $$$COMHelpFieldDateChanged(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMHelpFieldDateChangedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMHelpFieldDateChanged 7
  public static Object $$$FldCOMHelpFieldDateChanged(mContext m$) {
    return (7);
  }

  //<< #define StrCOMHelpFieldDateChanged $$GetPropertyName^COMConst("COMHelpField",7)
  public static Object $$$StrCOMHelpFieldDateChanged(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpField",7));
  }

  //<< #define COMHelpFieldChangedBy(%obj) $piece(%obj,"~",8)
  public static Object $$$COMHelpFieldChangedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMHelpFieldChangedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMHelpFieldChangedBy 8
  public static Object $$$FldCOMHelpFieldChangedBy(mContext m$) {
    return (8);
  }

  //<< #define StrCOMHelpFieldChangedBy $$GetPropertyName^COMConst("COMHelpField",8)
  public static Object $$$StrCOMHelpFieldChangedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpField",8));
  }

  //<< #define COMHelpFieldFieldRef(%obj) $piece(%obj,"~",9)
  public static Object $$$COMHelpFieldFieldRef(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMHelpFieldFieldRefSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMHelpFieldFieldRef 9
  public static Object $$$FldCOMHelpFieldFieldRef(mContext m$) {
    return (9);
  }

  //<< #define StrCOMHelpFieldFieldRef $$GetPropertyName^COMConst("COMHelpField",9)
  public static Object $$$StrCOMHelpFieldFieldRef(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpField",9));
  }

  //<< #define FldCOMHelpFieldFormName 1
  public static Object $$$FldCOMHelpFieldFormName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHelpFieldFormName $$GetPropertyName^COMConst("COMHelpField",,1)
  public static Object $$$StrCOMHelpFieldFormName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpField",null,1));
  }

  //<< #define FldCOMHelpFieldLanguage1 2
  public static Object $$$FldCOMHelpFieldLanguage1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMHelpFieldLanguage1 $$GetPropertyName^COMConst("COMHelpField",,2)
  public static Object $$$StrCOMHelpFieldLanguage1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpField",null,2));
  }

  //<< #define FldCOMHelpFieldNumber 3
  public static Object $$$FldCOMHelpFieldNumber(mContext m$) {
    return (3);
  }

  //<< #define StrCOMHelpFieldNumber $$GetPropertyName^COMConst("COMHelpField",,3)
  public static Object $$$StrCOMHelpFieldNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpField",null,3));
  }

  //<< 
  //<< #define COMHelpModuleHelpText(%obj) $piece(%obj,"~",1)
  public static Object $$$COMHelpModuleHelpText(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMHelpModuleHelpTextSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMHelpModuleHelpText 1
  public static Object $$$FldCOMHelpModuleHelpText(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHelpModuleHelpText $$GetPropertyName^COMConst("COMHelpModule",1)
  public static Object $$$StrCOMHelpModuleHelpText(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpModule",1));
  }

  //<< #define COMHelpModuleCreatedBy(%obj) $piece(%obj,"~",2)
  public static Object $$$COMHelpModuleCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMHelpModuleCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMHelpModuleCreatedBy 2
  public static Object $$$FldCOMHelpModuleCreatedBy(mContext m$) {
    return (2);
  }

  //<< #define StrCOMHelpModuleCreatedBy $$GetPropertyName^COMConst("COMHelpModule",2)
  public static Object $$$StrCOMHelpModuleCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpModule",2));
  }

  //<< #define COMHelpModuleDateCreated(%obj) $piece(%obj,"~",3)
  public static Object $$$COMHelpModuleDateCreated(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMHelpModuleDateCreatedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMHelpModuleDateCreated 3
  public static Object $$$FldCOMHelpModuleDateCreated(mContext m$) {
    return (3);
  }

  //<< #define StrCOMHelpModuleDateCreated $$GetPropertyName^COMConst("COMHelpModule",3)
  public static Object $$$StrCOMHelpModuleDateCreated(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpModule",3));
  }

  //<< #define COMHelpModuleChangedBy(%obj) $piece(%obj,"~",4)
  public static Object $$$COMHelpModuleChangedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMHelpModuleChangedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMHelpModuleChangedBy 4
  public static Object $$$FldCOMHelpModuleChangedBy(mContext m$) {
    return (4);
  }

  //<< #define StrCOMHelpModuleChangedBy $$GetPropertyName^COMConst("COMHelpModule",4)
  public static Object $$$StrCOMHelpModuleChangedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpModule",4));
  }

  //<< #define COMHelpModuleDateChanged(%obj) $piece(%obj,"~",5)
  public static Object $$$COMHelpModuleDateChanged(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMHelpModuleDateChangedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMHelpModuleDateChanged 5
  public static Object $$$FldCOMHelpModuleDateChanged(mContext m$) {
    return (5);
  }

  //<< #define StrCOMHelpModuleDateChanged $$GetPropertyName^COMConst("COMHelpModule",5)
  public static Object $$$StrCOMHelpModuleDateChanged(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpModule",5));
  }

  //<< #define FldCOMHelpModuleModule1 1
  public static Object $$$FldCOMHelpModuleModule1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMHelpModuleModule1 $$GetPropertyName^COMConst("COMHelpModule",,1)
  public static Object $$$StrCOMHelpModuleModule1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpModule",null,1));
  }

  //<< #define FldCOMHelpModuleLanguage1 2
  public static Object $$$FldCOMHelpModuleLanguage1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMHelpModuleLanguage1 $$GetPropertyName^COMConst("COMHelpModule",,2)
  public static Object $$$StrCOMHelpModuleLanguage1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMHelpModule",null,2));
  }

  //<< 
  //<< #define COMIndexLastIndexStartTime(%obj) $piece(%obj,"~",1)
  public static Object $$$COMIndexLastIndexStartTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMIndexLastIndexStartTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMIndexLastIndexStartTime 1
  public static Object $$$FldCOMIndexLastIndexStartTime(mContext m$) {
    return (1);
  }

  //<< #define StrCOMIndexLastIndexStartTime $$GetPropertyName^COMConst("COMIndex",1)
  public static Object $$$StrCOMIndexLastIndexStartTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndex",1));
  }

  //<< #define COMIndexLastIndexEndTime(%obj) $piece(%obj,"~",2)
  public static Object $$$COMIndexLastIndexEndTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMIndexLastIndexEndTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMIndexLastIndexEndTime 2
  public static Object $$$FldCOMIndexLastIndexEndTime(mContext m$) {
    return (2);
  }

  //<< #define StrCOMIndexLastIndexEndTime $$GetPropertyName^COMConst("COMIndex",2)
  public static Object $$$StrCOMIndexLastIndexEndTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndex",2));
  }

  //<< #define COMIndexDurationInSeconds(%obj) $piece(%obj,"~",3)
  public static Object $$$COMIndexDurationInSeconds(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMIndexDurationInSecondsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMIndexDurationInSeconds 3
  public static Object $$$FldCOMIndexDurationInSeconds(mContext m$) {
    return (3);
  }

  //<< #define StrCOMIndexDurationInSeconds $$GetPropertyName^COMConst("COMIndex",3)
  public static Object $$$StrCOMIndexDurationInSeconds(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndex",3));
  }

  //<< #define COMIndexNumberofRecords(%obj) $piece(%obj,"~",4)
  public static Object $$$COMIndexNumberofRecords(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMIndexNumberofRecordsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMIndexNumberofRecords 4
  public static Object $$$FldCOMIndexNumberofRecords(mContext m$) {
    return (4);
  }

  //<< #define StrCOMIndexNumberofRecords $$GetPropertyName^COMConst("COMIndex",4)
  public static Object $$$StrCOMIndexNumberofRecords(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndex",4));
  }

  //<< #define COMIndexStatus(%obj) $piece(%obj,"~",5)
  public static Object $$$COMIndexStatus(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMIndexStatusSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMIndexStatus 5
  public static Object $$$FldCOMIndexStatus(mContext m$) {
    return (5);
  }

  //<< #define StrCOMIndexStatus $$GetPropertyName^COMConst("COMIndex",5)
  public static Object $$$StrCOMIndexStatus(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndex",5));
  }

  //<< #define COMIndexCompiled(%obj) $piece(%obj,"~",6)
  public static Object $$$COMIndexCompiled(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMIndexCompiledSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMIndexCompiled 6
  public static Object $$$FldCOMIndexCompiled(mContext m$) {
    return (6);
  }

  //<< #define StrCOMIndexCompiled $$GetPropertyName^COMConst("COMIndex",6)
  public static Object $$$StrCOMIndexCompiled(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndex",6));
  }

  //<< #define COMIndexTuned(%obj) $piece(%obj,"~",7)
  public static Object $$$COMIndexTuned(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMIndexTunedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMIndexTuned 7
  public static Object $$$FldCOMIndexTuned(mContext m$) {
    return (7);
  }

  //<< #define StrCOMIndexTuned $$GetPropertyName^COMConst("COMIndex",7)
  public static Object $$$StrCOMIndexTuned(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndex",7));
  }

  //<< #define COMIndexIndexDirty(%obj) $piece(%obj,"~",8)
  public static Object $$$COMIndexIndexDirty(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMIndexIndexDirtySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMIndexIndexDirty 8
  public static Object $$$FldCOMIndexIndexDirty(mContext m$) {
    return (8);
  }

  //<< #define StrCOMIndexIndexDirty $$GetPropertyName^COMConst("COMIndex",8)
  public static Object $$$StrCOMIndexIndexDirty(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndex",8));
  }

  //<< #define FldCOMIndexClass 1
  public static Object $$$FldCOMIndexClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMIndexClass $$GetPropertyName^COMConst("COMIndex",,1)
  public static Object $$$StrCOMIndexClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndex",null,1));
  }

  //<< 
  //<< #define COMIndexCheckTimesRun(%obj) $piece(%obj,"~",1)
  public static Object $$$COMIndexCheckTimesRun(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMIndexCheckTimesRunSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckTimesRun 1
  public static Object $$$FldCOMIndexCheckTimesRun(mContext m$) {
    return (1);
  }

  //<< #define StrCOMIndexCheckTimesRun $$GetPropertyName^COMConst("COMIndexCheck",1)
  public static Object $$$StrCOMIndexCheckTimesRun(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheck",1));
  }

  //<< #define COMIndexCheckLastRun(%obj) $piece(%obj,"~",2)
  public static Object $$$COMIndexCheckLastRun(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMIndexCheckLastRunSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckLastRun 2
  public static Object $$$FldCOMIndexCheckLastRun(mContext m$) {
    return (2);
  }

  //<< #define StrCOMIndexCheckLastRun $$GetPropertyName^COMConst("COMIndexCheck",2)
  public static Object $$$StrCOMIndexCheckLastRun(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheck",2));
  }

  //<< #define COMIndexCheckOnOKSkip(%obj) $piece(%obj,"~",3)
  public static Object $$$COMIndexCheckOnOKSkip(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMIndexCheckOnOKSkipSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckOnOKSkip 3
  public static Object $$$FldCOMIndexCheckOnOKSkip(mContext m$) {
    return (3);
  }

  //<< #define StrCOMIndexCheckOnOKSkip $$GetPropertyName^COMConst("COMIndexCheck",3)
  public static Object $$$StrCOMIndexCheckOnOKSkip(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheck",3));
  }

  //<< #define COMIndexCheckSlow(%obj) $piece(%obj,"~",4)
  public static Object $$$COMIndexCheckSlow(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMIndexCheckSlowSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckSlow 4
  public static Object $$$FldCOMIndexCheckSlow(mContext m$) {
    return (4);
  }

  //<< #define StrCOMIndexCheckSlow $$GetPropertyName^COMConst("COMIndexCheck",4)
  public static Object $$$StrCOMIndexCheckSlow(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheck",4));
  }

  //<< #define COMIndexCheckTest(%obj) $piece(%obj,"~",5)
  public static Object $$$COMIndexCheckTest(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMIndexCheckTestSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckTest 5
  public static Object $$$FldCOMIndexCheckTest(mContext m$) {
    return (5);
  }

  //<< #define StrCOMIndexCheckTest $$GetPropertyName^COMConst("COMIndexCheck",5)
  public static Object $$$StrCOMIndexCheckTest(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheck",5));
  }

  //<< #define FldCOMIndexCheckID1 1
  public static Object $$$FldCOMIndexCheckID1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMIndexCheckID1 $$GetPropertyName^COMConst("COMIndexCheck",,1)
  public static Object $$$StrCOMIndexCheckID1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheck",null,1));
  }

  //<< 
  //<< #define COMIndexCheckLineClass(%obj) $piece(%obj,"~",1)
  public static Object $$$COMIndexCheckLineClass(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMIndexCheckLineClassSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckLineClass 1
  public static Object $$$FldCOMIndexCheckLineClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMIndexCheckLineClass $$GetPropertyName^COMConst("COMIndexCheckLine",1)
  public static Object $$$StrCOMIndexCheckLineClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheckLine",1));
  }

  //<< #define COMIndexCheckLineOK(%obj) $piece(%obj,"~",2)
  public static Object $$$COMIndexCheckLineOK(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMIndexCheckLineOKSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckLineOK 2
  public static Object $$$FldCOMIndexCheckLineOK(mContext m$) {
    return (2);
  }

  //<< #define StrCOMIndexCheckLineOK $$GetPropertyName^COMConst("COMIndexCheckLine",2)
  public static Object $$$StrCOMIndexCheckLineOK(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheckLine",2));
  }

  //<< #define COMIndexCheckLineError(%obj) $piece(%obj,"~",3)
  public static Object $$$COMIndexCheckLineError(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMIndexCheckLineErrorSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckLineError 3
  public static Object $$$FldCOMIndexCheckLineError(mContext m$) {
    return (3);
  }

  //<< #define StrCOMIndexCheckLineError $$GetPropertyName^COMConst("COMIndexCheckLine",3)
  public static Object $$$StrCOMIndexCheckLineError(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheckLine",3));
  }

  //<< #define COMIndexCheckLineLast1(%obj) $piece(%obj,"~",4)
  public static Object $$$COMIndexCheckLineLast1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMIndexCheckLineLast1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckLineLast1 4
  public static Object $$$FldCOMIndexCheckLineLast1(mContext m$) {
    return (4);
  }

  //<< #define StrCOMIndexCheckLineLast1 $$GetPropertyName^COMConst("COMIndexCheckLine",4)
  public static Object $$$StrCOMIndexCheckLineLast1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheckLine",4));
  }

  //<< #define COMIndexCheckLineClear(%obj) $piece(%obj,"~",5)
  public static Object $$$COMIndexCheckLineClear(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMIndexCheckLineClearSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckLineClear 5
  public static Object $$$FldCOMIndexCheckLineClear(mContext m$) {
    return (5);
  }

  //<< #define StrCOMIndexCheckLineClear $$GetPropertyName^COMConst("COMIndexCheckLine",5)
  public static Object $$$StrCOMIndexCheckLineClear(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheckLine",5));
  }

  //<< #define COMIndexCheckLineLastRun(%obj) $piece(%obj,"~",6)
  public static Object $$$COMIndexCheckLineLastRun(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMIndexCheckLineLastRunSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckLineLastRun 6
  public static Object $$$FldCOMIndexCheckLineLastRun(mContext m$) {
    return (6);
  }

  //<< #define StrCOMIndexCheckLineLastRun $$GetPropertyName^COMConst("COMIndexCheckLine",6)
  public static Object $$$StrCOMIndexCheckLineLastRun(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheckLine",6));
  }

  //<< #define COMIndexCheckLineLastError(%obj) $piece(%obj,"~",7)
  public static Object $$$COMIndexCheckLineLastError(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMIndexCheckLineLastErrorSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckLineLastError 7
  public static Object $$$FldCOMIndexCheckLineLastError(mContext m$) {
    return (7);
  }

  //<< #define StrCOMIndexCheckLineLastError $$GetPropertyName^COMConst("COMIndexCheckLine",7)
  public static Object $$$StrCOMIndexCheckLineLastError(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheckLine",7));
  }

  //<< #define COMIndexCheckLineTime1(%obj) $piece(%obj,"~",8)
  public static Object $$$COMIndexCheckLineTime1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMIndexCheckLineTime1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMIndexCheckLineTime1 8
  public static Object $$$FldCOMIndexCheckLineTime1(mContext m$) {
    return (8);
  }

  //<< #define StrCOMIndexCheckLineTime1 $$GetPropertyName^COMConst("COMIndexCheckLine",8)
  public static Object $$$StrCOMIndexCheckLineTime1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheckLine",8));
  }

  //<< #define FldCOMIndexCheckLineID1 1
  public static Object $$$FldCOMIndexCheckLineID1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMIndexCheckLineID1 $$GetPropertyName^COMConst("COMIndexCheckLine",,1)
  public static Object $$$StrCOMIndexCheckLineID1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheckLine",null,1));
  }

  //<< #define FldCOMIndexCheckLineLine 2
  public static Object $$$FldCOMIndexCheckLineLine(mContext m$) {
    return (2);
  }

  //<< #define StrCOMIndexCheckLineLine $$GetPropertyName^COMConst("COMIndexCheckLine",,2)
  public static Object $$$StrCOMIndexCheckLineLine(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexCheckLine",null,2));
  }

  //<< 
  //<< #define COMIndexHistStartTime(%obj) $piece(%obj,"~",1)
  public static Object $$$COMIndexHistStartTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMIndexHistStartTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMIndexHistStartTime 1
  public static Object $$$FldCOMIndexHistStartTime(mContext m$) {
    return (1);
  }

  //<< #define StrCOMIndexHistStartTime $$GetPropertyName^COMConst("COMIndexHist",1)
  public static Object $$$StrCOMIndexHistStartTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexHist",1));
  }

  //<< #define COMIndexHistEndTime(%obj) $piece(%obj,"~",2)
  public static Object $$$COMIndexHistEndTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMIndexHistEndTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMIndexHistEndTime 2
  public static Object $$$FldCOMIndexHistEndTime(mContext m$) {
    return (2);
  }

  //<< #define StrCOMIndexHistEndTime $$GetPropertyName^COMConst("COMIndexHist",2)
  public static Object $$$StrCOMIndexHistEndTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexHist",2));
  }

  //<< #define COMIndexHistDurationInSeconds(%obj) $piece(%obj,"~",3)
  public static Object $$$COMIndexHistDurationInSeconds(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMIndexHistDurationInSecondsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMIndexHistDurationInSeconds 3
  public static Object $$$FldCOMIndexHistDurationInSeconds(mContext m$) {
    return (3);
  }

  //<< #define StrCOMIndexHistDurationInSeconds $$GetPropertyName^COMConst("COMIndexHist",3)
  public static Object $$$StrCOMIndexHistDurationInSeconds(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexHist",3));
  }

  //<< #define COMIndexHistNumberofRecords(%obj) $piece(%obj,"~",4)
  public static Object $$$COMIndexHistNumberofRecords(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMIndexHistNumberofRecordsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMIndexHistNumberofRecords 4
  public static Object $$$FldCOMIndexHistNumberofRecords(mContext m$) {
    return (4);
  }

  //<< #define StrCOMIndexHistNumberofRecords $$GetPropertyName^COMConst("COMIndexHist",4)
  public static Object $$$StrCOMIndexHistNumberofRecords(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexHist",4));
  }

  //<< #define COMIndexHistUser1(%obj) $piece(%obj,"~",5)
  public static Object $$$COMIndexHistUser1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMIndexHistUser1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMIndexHistUser1 5
  public static Object $$$FldCOMIndexHistUser1(mContext m$) {
    return (5);
  }

  //<< #define StrCOMIndexHistUser1 $$GetPropertyName^COMConst("COMIndexHist",5)
  public static Object $$$StrCOMIndexHistUser1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexHist",5));
  }

  //<< #define COMIndexHistType(%obj) $piece(%obj,"~",6)
  public static Object $$$COMIndexHistType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMIndexHistTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMIndexHistType 6
  public static Object $$$FldCOMIndexHistType(mContext m$) {
    return (6);
  }

  //<< #define StrCOMIndexHistType $$GetPropertyName^COMConst("COMIndexHist",6)
  public static Object $$$StrCOMIndexHistType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexHist",6));
  }

  //<< #define COMIndexHistStatus(%obj) $piece(%obj,"~",7)
  public static Object $$$COMIndexHistStatus(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMIndexHistStatusSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMIndexHistStatus 7
  public static Object $$$FldCOMIndexHistStatus(mContext m$) {
    return (7);
  }

  //<< #define StrCOMIndexHistStatus $$GetPropertyName^COMConst("COMIndexHist",7)
  public static Object $$$StrCOMIndexHistStatus(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexHist",7));
  }

  //<< #define FldCOMIndexHistClass 1
  public static Object $$$FldCOMIndexHistClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMIndexHistClass $$GetPropertyName^COMConst("COMIndexHist",,1)
  public static Object $$$StrCOMIndexHistClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexHist",null,1));
  }

  //<< #define FldCOMIndexHistEntry 2
  public static Object $$$FldCOMIndexHistEntry(mContext m$) {
    return (2);
  }

  //<< #define StrCOMIndexHistEntry $$GetPropertyName^COMConst("COMIndexHist",,2)
  public static Object $$$StrCOMIndexHistEntry(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMIndexHist",null,2));
  }

  //<< 
  //<< #define COMLanguageConversionSourceClass(%obj) $piece(%obj,"~",1)
  public static Object $$$COMLanguageConversionSourceClass(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMLanguageConversionSourceClassSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMLanguageConversionSourceClass 1
  public static Object $$$FldCOMLanguageConversionSourceClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMLanguageConversionSourceClass $$GetPropertyName^COMConst("COMLanguageConversion",1)
  public static Object $$$StrCOMLanguageConversionSourceClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMLanguageConversion",1));
  }

  //<< #define COMLanguageConversionSourceField(%obj) $piece(%obj,"~",2)
  public static Object $$$COMLanguageConversionSourceField(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMLanguageConversionSourceFieldSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMLanguageConversionSourceField 2
  public static Object $$$FldCOMLanguageConversionSourceField(mContext m$) {
    return (2);
  }

  //<< #define StrCOMLanguageConversionSourceField $$GetPropertyName^COMConst("COMLanguageConversion",2)
  public static Object $$$StrCOMLanguageConversionSourceField(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMLanguageConversion",2));
  }

  //<< #define COMLanguageConversionNoConversionRequired(%obj) $piece(%obj,"~",3)
  public static Object $$$COMLanguageConversionNoConversionRequired(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMLanguageConversionNoConversionRequiredSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMLanguageConversionNoConversionRequired 3
  public static Object $$$FldCOMLanguageConversionNoConversionRequired(mContext m$) {
    return (3);
  }

  //<< #define StrCOMLanguageConversionNoConversionRequired $$GetPropertyName^COMConst("COMLanguageConversion",3)
  public static Object $$$StrCOMLanguageConversionNoConversionRequired(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMLanguageConversion",3));
  }

  //<< #define FldCOMLanguageConversionLangaugeClass 1
  public static Object $$$FldCOMLanguageConversionLangaugeClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMLanguageConversionLangaugeClass $$GetPropertyName^COMConst("COMLanguageConversion",,1)
  public static Object $$$StrCOMLanguageConversionLangaugeClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMLanguageConversion",null,1));
  }

  //<< #define FldCOMLanguageConversionDataField 2
  public static Object $$$FldCOMLanguageConversionDataField(mContext m$) {
    return (2);
  }

  //<< #define StrCOMLanguageConversionDataField $$GetPropertyName^COMConst("COMLanguageConversion",,2)
  public static Object $$$StrCOMLanguageConversionDataField(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMLanguageConversion",null,2));
  }

  //<< 
  //<< #define COMLockLockedClassName(%obj) $piece(%obj,"~",1)
  public static Object $$$COMLockLockedClassName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMLockLockedClassNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMLockLockedClassName 1
  public static Object $$$FldCOMLockLockedClassName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMLockLockedClassName $$GetPropertyName^COMConst("COMLock",1)
  public static Object $$$StrCOMLockLockedClassName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMLock",1));
  }

  //<< #define COMLockLockedClassId(%obj) $piece(%obj,"~",2)
  public static Object $$$COMLockLockedClassId(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMLockLockedClassIdSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMLockLockedClassId 2
  public static Object $$$FldCOMLockLockedClassId(mContext m$) {
    return (2);
  }

  //<< #define StrCOMLockLockedClassId $$GetPropertyName^COMConst("COMLock",2)
  public static Object $$$StrCOMLockLockedClassId(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMLock",2));
  }

  //<< #define COMLockLockingClassName(%obj) $piece(%obj,"~",3)
  public static Object $$$COMLockLockingClassName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMLockLockingClassNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMLockLockingClassName 3
  public static Object $$$FldCOMLockLockingClassName(mContext m$) {
    return (3);
  }

  //<< #define StrCOMLockLockingClassName $$GetPropertyName^COMConst("COMLock",3)
  public static Object $$$StrCOMLockLockingClassName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMLock",3));
  }

  //<< #define COMLockLockingClassId(%obj) $piece(%obj,"~",4)
  public static Object $$$COMLockLockingClassId(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMLockLockingClassIdSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMLockLockingClassId 4
  public static Object $$$FldCOMLockLockingClassId(mContext m$) {
    return (4);
  }

  //<< #define StrCOMLockLockingClassId $$GetPropertyName^COMConst("COMLock",4)
  public static Object $$$StrCOMLockLockingClassId(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMLock",4));
  }

  //<< #define FldCOMLockLockNumber 1
  public static Object $$$FldCOMLockLockNumber(mContext m$) {
    return (1);
  }

  //<< #define StrCOMLockLockNumber $$GetPropertyName^COMConst("COMLock",,1)
  public static Object $$$StrCOMLockLockNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMLock",null,1));
  }

  //<< 
  //<< #define FldCOMLogin 1
  public static Object $$$FldCOMLogin(mContext m$) {
    return (1);
  }

  //<< #define StrCOMLogin $$GetPropertyName^COMConst("COMLogin",,1)
  public static Object $$$StrCOMLogin(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMLogin",null,1));
  }

  //<< 
  //<< #define COMMsgDateTime(%obj) $piece(%obj,"~",1)
  public static Object $$$COMMsgDateTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMMsgDateTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMMsgDateTime 1
  public static Object $$$FldCOMMsgDateTime(mContext m$) {
    return (1);
  }

  //<< #define StrCOMMsgDateTime $$GetPropertyName^COMConst("COMMsg",1)
  public static Object $$$StrCOMMsgDateTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMMsg",1));
  }

  //<< #define COMMsgUser1(%obj) $piece(%obj,"~",2)
  public static Object $$$COMMsgUser1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMMsgUser1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMMsgUser1 2
  public static Object $$$FldCOMMsgUser1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMMsgUser1 $$GetPropertyName^COMConst("COMMsg",2)
  public static Object $$$StrCOMMsgUser1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMMsg",2));
  }

  //<< #define COMMsgFunction1(%obj) $piece(%obj,"~",3)
  public static Object $$$COMMsgFunction1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMMsgFunction1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMMsgFunction1 3
  public static Object $$$FldCOMMsgFunction1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMMsgFunction1 $$GetPropertyName^COMConst("COMMsg",3)
  public static Object $$$StrCOMMsgFunction1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMMsg",3));
  }

  //<< #define COMMsgSession(%obj) $piece(%obj,"~",4)
  public static Object $$$COMMsgSession(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMMsgSessionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMMsgSession 4
  public static Object $$$FldCOMMsgSession(mContext m$) {
    return (4);
  }

  //<< #define StrCOMMsgSession $$GetPropertyName^COMConst("COMMsg",4)
  public static Object $$$StrCOMMsgSession(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMMsg",4));
  }

  //<< #define FldCOMMsgLogNo 1
  public static Object $$$FldCOMMsgLogNo(mContext m$) {
    return (1);
  }

  //<< #define StrCOMMsgLogNo $$GetPropertyName^COMConst("COMMsg",,1)
  public static Object $$$StrCOMMsgLogNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMMsg",null,1));
  }

  //<< 
  //<< #define COMMsgLogDateTime(%obj) $piece(%obj,"~",1)
  public static Object $$$COMMsgLogDateTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMMsgLogDateTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMMsgLogDateTime 1
  public static Object $$$FldCOMMsgLogDateTime(mContext m$) {
    return (1);
  }

  //<< #define StrCOMMsgLogDateTime $$GetPropertyName^COMConst("COMMsgLog",1)
  public static Object $$$StrCOMMsgLogDateTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMMsgLog",1));
  }

  //<< #define COMMsgLogMessage1(%obj) $piece(%obj,"~",2)
  public static Object $$$COMMsgLogMessage1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMMsgLogMessage1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMMsgLogMessage1 2
  public static Object $$$FldCOMMsgLogMessage1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMMsgLogMessage1 $$GetPropertyName^COMConst("COMMsgLog",2)
  public static Object $$$StrCOMMsgLogMessage1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMMsgLog",2));
  }

  //<< #define COMMsgLogFormtoJumpTo(%obj) $piece(%obj,"~",3)
  public static Object $$$COMMsgLogFormtoJumpTo(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMMsgLogFormtoJumpToSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMMsgLogFormtoJumpTo 3
  public static Object $$$FldCOMMsgLogFormtoJumpTo(mContext m$) {
    return (3);
  }

  //<< #define StrCOMMsgLogFormtoJumpTo $$GetPropertyName^COMConst("COMMsgLog",3)
  public static Object $$$StrCOMMsgLogFormtoJumpTo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMMsgLog",3));
  }

  //<< #define COMMsgLogKeytoJumpTo(%obj) $piece(%obj,"~",4)
  public static Object $$$COMMsgLogKeytoJumpTo(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMMsgLogKeytoJumpToSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMMsgLogKeytoJumpTo 4
  public static Object $$$FldCOMMsgLogKeytoJumpTo(mContext m$) {
    return (4);
  }

  //<< #define StrCOMMsgLogKeytoJumpTo $$GetPropertyName^COMConst("COMMsgLog",4)
  public static Object $$$StrCOMMsgLogKeytoJumpTo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMMsgLog",4));
  }

  //<< #define FldCOMMsgLogLogNo 1
  public static Object $$$FldCOMMsgLogLogNo(mContext m$) {
    return (1);
  }

  //<< #define StrCOMMsgLogLogNo $$GetPropertyName^COMConst("COMMsgLog",,1)
  public static Object $$$StrCOMMsgLogLogNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMMsgLog",null,1));
  }

  //<< #define FldCOMMsgLogEntryNo 2
  public static Object $$$FldCOMMsgLogEntryNo(mContext m$) {
    return (2);
  }

  //<< #define StrCOMMsgLogEntryNo $$GetPropertyName^COMConst("COMMsgLog",,2)
  public static Object $$$StrCOMMsgLogEntryNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMMsgLog",null,2));
  }

  //<< 
  //<< #define COMParameterValue1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMParameterValue1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMParameterValue1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMParameterValue1 1
  public static Object $$$FldCOMParameterValue1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMParameterValue1 $$GetPropertyName^COMConst("COMParameter",1)
  public static Object $$$StrCOMParameterValue1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMParameter",1));
  }

  //<< #define FldCOMParameterParameterName 1
  public static Object $$$FldCOMParameterParameterName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMParameterParameterName $$GetPropertyName^COMConst("COMParameter",,1)
  public static Object $$$StrCOMParameterParameterName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMParameter",null,1));
  }

  //<< #define FldCOMParameterKey2 2
  public static Object $$$FldCOMParameterKey2(mContext m$) {
    return (2);
  }

  //<< #define StrCOMParameterKey2 $$GetPropertyName^COMConst("COMParameter",,2)
  public static Object $$$StrCOMParameterKey2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMParameter",null,2));
  }

  //<< 
  //<< #define COMPatchPatchId(%obj) $piece(%obj,"~",1)
  public static Object $$$COMPatchPatchId(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMPatchPatchIdSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMPatchPatchId 1
  public static Object $$$FldCOMPatchPatchId(mContext m$) {
    return (1);
  }

  //<< #define StrCOMPatchPatchId $$GetPropertyName^COMConst("COMPatch",1)
  public static Object $$$StrCOMPatchPatchId(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMPatch",1));
  }

  //<< #define COMPatchAppliedTime(%obj) $piece(%obj,"~",2)
  public static Object $$$COMPatchAppliedTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMPatchAppliedTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMPatchAppliedTime 2
  public static Object $$$FldCOMPatchAppliedTime(mContext m$) {
    return (2);
  }

  //<< #define StrCOMPatchAppliedTime $$GetPropertyName^COMConst("COMPatch",2)
  public static Object $$$StrCOMPatchAppliedTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMPatch",2));
  }

  //<< #define COMPatchSystemChanges(%obj) $piece(%obj,"~",3)
  public static Object $$$COMPatchSystemChanges(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMPatchSystemChangesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMPatchSystemChanges 3
  public static Object $$$FldCOMPatchSystemChanges(mContext m$) {
    return (3);
  }

  //<< #define StrCOMPatchSystemChanges $$GetPropertyName^COMConst("COMPatch",3)
  public static Object $$$StrCOMPatchSystemChanges(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMPatch",3));
  }

  //<< #define COMPatchDataFix(%obj) $piece(%obj,"~",4)
  public static Object $$$COMPatchDataFix(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMPatchDataFixSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMPatchDataFix 4
  public static Object $$$FldCOMPatchDataFix(mContext m$) {
    return (4);
  }

  //<< #define StrCOMPatchDataFix $$GetPropertyName^COMConst("COMPatch",4)
  public static Object $$$StrCOMPatchDataFix(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMPatch",4));
  }

  //<< #define COMPatchParameters(%obj) $piece(%obj,"~",5)
  public static Object $$$COMPatchParameters(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMPatchParametersSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMPatchParameters 5
  public static Object $$$FldCOMPatchParameters(mContext m$) {
    return (5);
  }

  //<< #define StrCOMPatchParameters $$GetPropertyName^COMConst("COMPatch",5)
  public static Object $$$StrCOMPatchParameters(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMPatch",5));
  }

  //<< #define COMPatchCanrerun(%obj) $piece(%obj,"~",6)
  public static Object $$$COMPatchCanrerun(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMPatchCanrerunSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMPatchCanrerun 6
  public static Object $$$FldCOMPatchCanrerun(mContext m$) {
    return (6);
  }

  //<< #define StrCOMPatchCanrerun $$GetPropertyName^COMConst("COMPatch",6)
  public static Object $$$StrCOMPatchCanrerun(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMPatch",6));
  }

  //<< #define FldCOMPatchCounter 1
  public static Object $$$FldCOMPatchCounter(mContext m$) {
    return (1);
  }

  //<< #define StrCOMPatchCounter $$GetPropertyName^COMConst("COMPatch",,1)
  public static Object $$$StrCOMPatchCounter(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMPatch",null,1));
  }

  //<< 
  //<< #define COMQuickSearchItemData(%obj) $piece(%obj,"~",1)
  public static Object $$$COMQuickSearchItemData(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMQuickSearchItemDataSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMQuickSearchItemData 1
  public static Object $$$FldCOMQuickSearchItemData(mContext m$) {
    return (1);
  }

  //<< #define StrCOMQuickSearchItemData $$GetPropertyName^COMConst("COMQuickSearch",1)
  public static Object $$$StrCOMQuickSearchItemData(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMQuickSearch",1));
  }

  //<< #define FldCOMQuickSearchClassName 1
  public static Object $$$FldCOMQuickSearchClassName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMQuickSearchClassName $$GetPropertyName^COMConst("COMQuickSearch",,1)
  public static Object $$$StrCOMQuickSearchClassName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMQuickSearch",null,1));
  }

  //<< #define FldCOMQuickSearchItemIndex 2
  public static Object $$$FldCOMQuickSearchItemIndex(mContext m$) {
    return (2);
  }

  //<< #define StrCOMQuickSearchItemIndex $$GetPropertyName^COMConst("COMQuickSearch",,2)
  public static Object $$$StrCOMQuickSearchItemIndex(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMQuickSearch",null,2));
  }

  //<< #define FldCOMQuickSearchIndex1 3
  public static Object $$$FldCOMQuickSearchIndex1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMQuickSearchIndex1 $$GetPropertyName^COMConst("COMQuickSearch",,3)
  public static Object $$$StrCOMQuickSearchIndex1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMQuickSearch",null,3));
  }

  //<< 
  //<< #define COMQuickSearchSetupUseQuickSearch(%obj) $piece(%obj,"~",1)
  public static Object $$$COMQuickSearchSetupUseQuickSearch(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMQuickSearchSetupUseQuickSearchSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMQuickSearchSetupUseQuickSearch 1
  public static Object $$$FldCOMQuickSearchSetupUseQuickSearch(mContext m$) {
    return (1);
  }

  //<< #define StrCOMQuickSearchSetupUseQuickSearch $$GetPropertyName^COMConst("COMQuickSearchSetup",1)
  public static Object $$$StrCOMQuickSearchSetupUseQuickSearch(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMQuickSearchSetup",1));
  }

  //<< #define COMQuickSearchSetupUseStartsWithSearch(%obj) $piece(%obj,"~",2)
  public static Object $$$COMQuickSearchSetupUseStartsWithSearch(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMQuickSearchSetupUseStartsWithSearchSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMQuickSearchSetupUseStartsWithSearch 2
  public static Object $$$FldCOMQuickSearchSetupUseStartsWithSearch(mContext m$) {
    return (2);
  }

  //<< #define StrCOMQuickSearchSetupUseStartsWithSearch $$GetPropertyName^COMConst("COMQuickSearchSetup",2)
  public static Object $$$StrCOMQuickSearchSetupUseStartsWithSearch(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMQuickSearchSetup",2));
  }

  //<< #define FldCOMQuickSearchSetupSearchClass 1
  public static Object $$$FldCOMQuickSearchSetupSearchClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMQuickSearchSetupSearchClass $$GetPropertyName^COMConst("COMQuickSearchSetup",,1)
  public static Object $$$StrCOMQuickSearchSetupSearchClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMQuickSearchSetup",null,1));
  }

  //<< 
  //<< #define COMRegisteredClassName(%obj) $piece(%obj,"~",1)
  public static Object $$$COMRegisteredClassName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMRegisteredClassNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMRegisteredClassName 1
  public static Object $$$FldCOMRegisteredClassName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMRegisteredClassName $$GetPropertyName^COMConst("COMRegistered",1)
  public static Object $$$StrCOMRegisteredClassName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMRegistered",1));
  }

  //<< #define FldCOMRegisteredNumber 1
  public static Object $$$FldCOMRegisteredNumber(mContext m$) {
    return (1);
  }

  //<< #define StrCOMRegisteredNumber $$GetPropertyName^COMConst("COMRegistered",,1)
  public static Object $$$StrCOMRegisteredNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMRegistered",null,1));
  }

  //<< 
  //<< #define COMRoutineLogMachineName(%obj) $piece(%obj,"~",1)
  public static Object $$$COMRoutineLogMachineName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMRoutineLogMachineNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMRoutineLogMachineName 1
  public static Object $$$FldCOMRoutineLogMachineName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMRoutineLogMachineName $$GetPropertyName^COMConst("COMRoutineLog",1)
  public static Object $$$StrCOMRoutineLogMachineName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMRoutineLog",1));
  }

  //<< #define FldCOMRoutineLogRoutineName 1
  public static Object $$$FldCOMRoutineLogRoutineName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMRoutineLogRoutineName $$GetPropertyName^COMConst("COMRoutineLog",,1)
  public static Object $$$StrCOMRoutineLogRoutineName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMRoutineLog",null,1));
  }

  //<< #define FldCOMRoutineLogDate1 2
  public static Object $$$FldCOMRoutineLogDate1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMRoutineLogDate1 $$GetPropertyName^COMConst("COMRoutineLog",,2)
  public static Object $$$StrCOMRoutineLogDate1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMRoutineLog",null,2));
  }

  //<< #define FldCOMRoutineLogTime1 3
  public static Object $$$FldCOMRoutineLogTime1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMRoutineLogTime1 $$GetPropertyName^COMConst("COMRoutineLog",,3)
  public static Object $$$StrCOMRoutineLogTime1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMRoutineLog",null,3));
  }

  //<< 
  //<< #define COMScheduleClass(%obj) $piece(%obj,"~",1)
  public static Object $$$COMScheduleClass(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMScheduleClassSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMScheduleClass 1
  public static Object $$$FldCOMScheduleClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMScheduleClass $$GetPropertyName^COMConst("COMSchedule",1)
  public static Object $$$StrCOMScheduleClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",1));
  }

  //<< #define COMScheduleTypeReference(%obj) $piece(%obj,"~",2)
  public static Object $$$COMScheduleTypeReference(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMScheduleTypeReferenceSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMScheduleTypeReference 2
  public static Object $$$FldCOMScheduleTypeReference(mContext m$) {
    return (2);
  }

  //<< #define StrCOMScheduleTypeReference $$GetPropertyName^COMConst("COMSchedule",2)
  public static Object $$$StrCOMScheduleTypeReference(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",2));
  }

  //<< #define COMScheduleTimeIncrement(%obj) $piece(%obj,"~",3)
  public static Object $$$COMScheduleTimeIncrement(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMScheduleTimeIncrementSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMScheduleTimeIncrement 3
  public static Object $$$FldCOMScheduleTimeIncrement(mContext m$) {
    return (3);
  }

  //<< #define StrCOMScheduleTimeIncrement $$GetPropertyName^COMConst("COMSchedule",3)
  public static Object $$$StrCOMScheduleTimeIncrement(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",3));
  }

  //<< #define COMScheduleIncrementValue(%obj) $piece(%obj,"~",4)
  public static Object $$$COMScheduleIncrementValue(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMScheduleIncrementValueSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMScheduleIncrementValue 4
  public static Object $$$FldCOMScheduleIncrementValue(mContext m$) {
    return (4);
  }

  //<< #define StrCOMScheduleIncrementValue $$GetPropertyName^COMConst("COMSchedule",4)
  public static Object $$$StrCOMScheduleIncrementValue(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",4));
  }

  //<< #define COMScheduleDaysOfWeek(%obj) $piece(%obj,"~",5)
  public static Object $$$COMScheduleDaysOfWeek(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMScheduleDaysOfWeekSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMScheduleDaysOfWeek 5
  public static Object $$$FldCOMScheduleDaysOfWeek(mContext m$) {
    return (5);
  }

  //<< #define StrCOMScheduleDaysOfWeek $$GetPropertyName^COMConst("COMSchedule",5)
  public static Object $$$StrCOMScheduleDaysOfWeek(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",5));
  }

  //<< #define COMScheduleMultiDaysOfMonth(%obj) $piece(%obj,"~",6)
  public static Object $$$COMScheduleMultiDaysOfMonth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMScheduleMultiDaysOfMonthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMScheduleMultiDaysOfMonth 6
  public static Object $$$FldCOMScheduleMultiDaysOfMonth(mContext m$) {
    return (6);
  }

  //<< #define StrCOMScheduleMultiDaysOfMonth $$GetPropertyName^COMConst("COMSchedule",6)
  public static Object $$$StrCOMScheduleMultiDaysOfMonth(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",6));
  }

  //<< #define COMScheduleMonthsOfYear(%obj) $piece(%obj,"~",7)
  public static Object $$$COMScheduleMonthsOfYear(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMScheduleMonthsOfYearSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMScheduleMonthsOfYear 7
  public static Object $$$FldCOMScheduleMonthsOfYear(mContext m$) {
    return (7);
  }

  //<< #define StrCOMScheduleMonthsOfYear $$GetPropertyName^COMConst("COMSchedule",7)
  public static Object $$$StrCOMScheduleMonthsOfYear(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",7));
  }

  //<< #define COMScheduleTimeToRun(%obj) $piece(%obj,"~",8)
  public static Object $$$COMScheduleTimeToRun(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMScheduleTimeToRunSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMScheduleTimeToRun 8
  public static Object $$$FldCOMScheduleTimeToRun(mContext m$) {
    return (8);
  }

  //<< #define StrCOMScheduleTimeToRun $$GetPropertyName^COMConst("COMSchedule",8)
  public static Object $$$StrCOMScheduleTimeToRun(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",8));
  }

  //<< #define COMScheduleLastTimeRun(%obj) $piece(%obj,"~",9)
  public static Object $$$COMScheduleLastTimeRun(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMScheduleLastTimeRunSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMScheduleLastTimeRun 9
  public static Object $$$FldCOMScheduleLastTimeRun(mContext m$) {
    return (9);
  }

  //<< #define StrCOMScheduleLastTimeRun $$GetPropertyName^COMConst("COMSchedule",9)
  public static Object $$$StrCOMScheduleLastTimeRun(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",9));
  }

  //<< #define COMScheduleNextRunTime(%obj) $piece(%obj,"~",10)
  public static Object $$$COMScheduleNextRunTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$COMScheduleNextRunTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldCOMScheduleNextRunTime 10
  public static Object $$$FldCOMScheduleNextRunTime(mContext m$) {
    return (10);
  }

  //<< #define StrCOMScheduleNextRunTime $$GetPropertyName^COMConst("COMSchedule",10)
  public static Object $$$StrCOMScheduleNextRunTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",10));
  }

  //<< #define COMScheduleSingleDOM(%obj) $piece(%obj,"~",11)
  public static Object $$$COMScheduleSingleDOM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$COMScheduleSingleDOMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldCOMScheduleSingleDOM 11
  public static Object $$$FldCOMScheduleSingleDOM(mContext m$) {
    return (11);
  }

  //<< #define StrCOMScheduleSingleDOM $$GetPropertyName^COMConst("COMSchedule",11)
  public static Object $$$StrCOMScheduleSingleDOM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",11));
  }

  //<< #define COMScheduleDescription(%obj) $piece(%obj,"~",12)
  public static Object $$$COMScheduleDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$COMScheduleDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldCOMScheduleDescription 12
  public static Object $$$FldCOMScheduleDescription(mContext m$) {
    return (12);
  }

  //<< #define StrCOMScheduleDescription $$GetPropertyName^COMConst("COMSchedule",12)
  public static Object $$$StrCOMScheduleDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",12));
  }

  //<< #define COMScheduleCode(%obj) $piece(%obj,"~",13)
  public static Object $$$COMScheduleCode(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$COMScheduleCodeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldCOMScheduleCode 13
  public static Object $$$FldCOMScheduleCode(mContext m$) {
    return (13);
  }

  //<< #define StrCOMScheduleCode $$GetPropertyName^COMConst("COMSchedule",13)
  public static Object $$$StrCOMScheduleCode(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",13));
  }

  //<< #define COMScheduleRunNow(%obj) $piece(%obj,"~",15)
  public static Object $$$COMScheduleRunNow(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",15));
  }

  public static void $$$COMScheduleRunNowSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",15).set(_setval.get());
  }

  //<< #define FldCOMScheduleRunNow 15
  public static Object $$$FldCOMScheduleRunNow(mContext m$) {
    return (15);
  }

  //<< #define StrCOMScheduleRunNow $$GetPropertyName^COMConst("COMSchedule",15)
  public static Object $$$StrCOMScheduleRunNow(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",15));
  }

  //<< #define FldCOMScheduleNumber 1
  public static Object $$$FldCOMScheduleNumber(mContext m$) {
    return (1);
  }

  //<< #define StrCOMScheduleNumber $$GetPropertyName^COMConst("COMSchedule",,1)
  public static Object $$$StrCOMScheduleNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMSchedule",null,1));
  }

  //<< 
  //<< #define COMScheduleMessageMessage1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMScheduleMessageMessage1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMScheduleMessageMessage1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMScheduleMessageMessage1 1
  public static Object $$$FldCOMScheduleMessageMessage1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMScheduleMessageMessage1 $$GetPropertyName^COMConst("COMScheduleMessage",1)
  public static Object $$$StrCOMScheduleMessageMessage1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMScheduleMessage",1));
  }

  //<< #define COMScheduleMessageTimeTaken(%obj) $piece(%obj,"~",2)
  public static Object $$$COMScheduleMessageTimeTaken(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMScheduleMessageTimeTakenSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMScheduleMessageTimeTaken 2
  public static Object $$$FldCOMScheduleMessageTimeTaken(mContext m$) {
    return (2);
  }

  //<< #define StrCOMScheduleMessageTimeTaken $$GetPropertyName^COMConst("COMScheduleMessage",2)
  public static Object $$$StrCOMScheduleMessageTimeTaken(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMScheduleMessage",2));
  }

  //<< #define COMScheduleMessageMessageCreated(%obj) $piece(%obj,"~",3)
  public static Object $$$COMScheduleMessageMessageCreated(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMScheduleMessageMessageCreatedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMScheduleMessageMessageCreated 3
  public static Object $$$FldCOMScheduleMessageMessageCreated(mContext m$) {
    return (3);
  }

  //<< #define StrCOMScheduleMessageMessageCreated $$GetPropertyName^COMConst("COMScheduleMessage",3)
  public static Object $$$StrCOMScheduleMessageMessageCreated(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMScheduleMessage",3));
  }

  //<< #define FldCOMScheduleMessageSchedule 1
  public static Object $$$FldCOMScheduleMessageSchedule(mContext m$) {
    return (1);
  }

  //<< #define StrCOMScheduleMessageSchedule $$GetPropertyName^COMConst("COMScheduleMessage",,1)
  public static Object $$$StrCOMScheduleMessageSchedule(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMScheduleMessage",null,1));
  }

  //<< #define FldCOMScheduleMessageMessageNo 2
  public static Object $$$FldCOMScheduleMessageMessageNo(mContext m$) {
    return (2);
  }

  //<< #define StrCOMScheduleMessageMessageNo $$GetPropertyName^COMConst("COMScheduleMessage",,2)
  public static Object $$$StrCOMScheduleMessageMessageNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMScheduleMessage",null,2));
  }

  //<< 
  //<< #define COMTAXLocationName(%obj) $piece(%obj,"~",1)
  public static Object $$$COMTAXLocationName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMTAXLocationNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMTAXLocationName 1
  public static Object $$$FldCOMTAXLocationName(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTAXLocationName $$GetPropertyName^COMConst("COMTAXLocation",1)
  public static Object $$$StrCOMTAXLocationName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXLocation",1));
  }

  //<< #define COMTAXLocationCountry(%obj) $piece(%obj,"~",2)
  public static Object $$$COMTAXLocationCountry(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMTAXLocationCountrySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMTAXLocationCountry 2
  public static Object $$$FldCOMTAXLocationCountry(mContext m$) {
    return (2);
  }

  //<< #define StrCOMTAXLocationCountry $$GetPropertyName^COMConst("COMTAXLocation",2)
  public static Object $$$StrCOMTAXLocationCountry(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXLocation",2));
  }

  //<< #define COMTAXLocationState(%obj) $piece(%obj,"~",3)
  public static Object $$$COMTAXLocationState(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMTAXLocationStateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMTAXLocationState 3
  public static Object $$$FldCOMTAXLocationState(mContext m$) {
    return (3);
  }

  //<< #define StrCOMTAXLocationState $$GetPropertyName^COMConst("COMTAXLocation",3)
  public static Object $$$StrCOMTAXLocationState(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXLocation",3));
  }

  //<< #define COMTAXLocationZIPCode(%obj) $piece(%obj,"~",4)
  public static Object $$$COMTAXLocationZIPCode(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMTAXLocationZIPCodeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMTAXLocationZIPCode 4
  public static Object $$$FldCOMTAXLocationZIPCode(mContext m$) {
    return (4);
  }

  //<< #define StrCOMTAXLocationZIPCode $$GetPropertyName^COMConst("COMTAXLocation",4)
  public static Object $$$StrCOMTAXLocationZIPCode(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXLocation",4));
  }

  //<< #define COMTAXLocationParentTaxLocation(%obj) $piece(%obj,"~",5)
  public static Object $$$COMTAXLocationParentTaxLocation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMTAXLocationParentTaxLocationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMTAXLocationParentTaxLocation 5
  public static Object $$$FldCOMTAXLocationParentTaxLocation(mContext m$) {
    return (5);
  }

  //<< #define StrCOMTAXLocationParentTaxLocation $$GetPropertyName^COMConst("COMTAXLocation",5)
  public static Object $$$StrCOMTAXLocationParentTaxLocation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXLocation",5));
  }

  //<< #define COMTAXLocationSellingGLAccount(%obj) $piece(%obj,"~",6)
  public static Object $$$COMTAXLocationSellingGLAccount(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMTAXLocationSellingGLAccountSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMTAXLocationSellingGLAccount 6
  public static Object $$$FldCOMTAXLocationSellingGLAccount(mContext m$) {
    return (6);
  }

  //<< #define StrCOMTAXLocationSellingGLAccount $$GetPropertyName^COMConst("COMTAXLocation",6)
  public static Object $$$StrCOMTAXLocationSellingGLAccount(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXLocation",6));
  }

  //<< #define COMTAXLocationBuyingGLAccount(%obj) $piece(%obj,"~",7)
  public static Object $$$COMTAXLocationBuyingGLAccount(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMTAXLocationBuyingGLAccountSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMTAXLocationBuyingGLAccount 7
  public static Object $$$FldCOMTAXLocationBuyingGLAccount(mContext m$) {
    return (7);
  }

  //<< #define StrCOMTAXLocationBuyingGLAccount $$GetPropertyName^COMConst("COMTAXLocation",7)
  public static Object $$$StrCOMTAXLocationBuyingGLAccount(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXLocation",7));
  }

  //<< #define COMTAXLocationTaxCreditClaimable(%obj) $piece(%obj,"~",8)
  public static Object $$$COMTAXLocationTaxCreditClaimable(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMTAXLocationTaxCreditClaimableSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMTAXLocationTaxCreditClaimable 8
  public static Object $$$FldCOMTAXLocationTaxCreditClaimable(mContext m$) {
    return (8);
  }

  //<< #define StrCOMTAXLocationTaxCreditClaimable $$GetPropertyName^COMConst("COMTAXLocation",8)
  public static Object $$$StrCOMTAXLocationTaxCreditClaimable(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXLocation",8));
  }

  //<< #define COMTAXLocationDefaultTaxCode(%obj) $piece(%obj,"~",9)
  public static Object $$$COMTAXLocationDefaultTaxCode(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMTAXLocationDefaultTaxCodeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMTAXLocationDefaultTaxCode 9
  public static Object $$$FldCOMTAXLocationDefaultTaxCode(mContext m$) {
    return (9);
  }

  //<< #define StrCOMTAXLocationDefaultTaxCode $$GetPropertyName^COMConst("COMTAXLocation",9)
  public static Object $$$StrCOMTAXLocationDefaultTaxCode(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXLocation",9));
  }

  //<< #define FldCOMTAXLocationTaxLocationID 1
  public static Object $$$FldCOMTAXLocationTaxLocationID(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTAXLocationTaxLocationID $$GetPropertyName^COMConst("COMTAXLocation",,1)
  public static Object $$$StrCOMTAXLocationTaxLocationID(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXLocation",null,1));
  }

  //<< 
  //<< #define COMTAXTableSellRate(%obj) $piece(%obj,"~",1)
  public static Object $$$COMTAXTableSellRate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMTAXTableSellRateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMTAXTableSellRate 1
  public static Object $$$FldCOMTAXTableSellRate(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTAXTableSellRate $$GetPropertyName^COMConst("COMTAXTable",1)
  public static Object $$$StrCOMTAXTableSellRate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXTable",1));
  }

  //<< #define COMTAXTableSellGLAccount(%obj) $piece(%obj,"~",2)
  public static Object $$$COMTAXTableSellGLAccount(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMTAXTableSellGLAccountSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMTAXTableSellGLAccount 2
  public static Object $$$FldCOMTAXTableSellGLAccount(mContext m$) {
    return (2);
  }

  //<< #define StrCOMTAXTableSellGLAccount $$GetPropertyName^COMConst("COMTAXTable",2)
  public static Object $$$StrCOMTAXTableSellGLAccount(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXTable",2));
  }

  //<< #define COMTAXTableBuyRate(%obj) $piece(%obj,"~",3)
  public static Object $$$COMTAXTableBuyRate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMTAXTableBuyRateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMTAXTableBuyRate 3
  public static Object $$$FldCOMTAXTableBuyRate(mContext m$) {
    return (3);
  }

  //<< #define StrCOMTAXTableBuyRate $$GetPropertyName^COMConst("COMTAXTable",3)
  public static Object $$$StrCOMTAXTableBuyRate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXTable",3));
  }

  //<< #define COMTAXTableBuyGLAccount(%obj) $piece(%obj,"~",4)
  public static Object $$$COMTAXTableBuyGLAccount(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMTAXTableBuyGLAccountSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMTAXTableBuyGLAccount 4
  public static Object $$$FldCOMTAXTableBuyGLAccount(mContext m$) {
    return (4);
  }

  //<< #define StrCOMTAXTableBuyGLAccount $$GetPropertyName^COMConst("COMTAXTable",4)
  public static Object $$$StrCOMTAXTableBuyGLAccount(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXTable",4));
  }

  //<< #define FldCOMTAXTableTaxLocationID 1
  public static Object $$$FldCOMTAXTableTaxLocationID(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTAXTableTaxLocationID $$GetPropertyName^COMConst("COMTAXTable",,1)
  public static Object $$$StrCOMTAXTableTaxLocationID(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXTable",null,1));
  }

  //<< #define FldCOMTAXTableTaxCode 2
  public static Object $$$FldCOMTAXTableTaxCode(mContext m$) {
    return (2);
  }

  //<< #define StrCOMTAXTableTaxCode $$GetPropertyName^COMConst("COMTAXTable",,2)
  public static Object $$$StrCOMTAXTableTaxCode(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXTable",null,2));
  }

  //<< #define FldCOMTAXTableTaxType 3
  public static Object $$$FldCOMTAXTableTaxType(mContext m$) {
    return (3);
  }

  //<< #define StrCOMTAXTableTaxType $$GetPropertyName^COMConst("COMTAXTable",,3)
  public static Object $$$StrCOMTAXTableTaxType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXTable",null,3));
  }

  //<< #define FldCOMTAXTableEffectDate 4
  public static Object $$$FldCOMTAXTableEffectDate(mContext m$) {
    return (4);
  }

  //<< #define StrCOMTAXTableEffectDate $$GetPropertyName^COMConst("COMTAXTable",,4)
  public static Object $$$StrCOMTAXTableEffectDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTAXTable",null,4));
  }

  //<< 
  //<< #define COMTempListField1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMTempListField1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMTempListField1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMTempListField1 1
  public static Object $$$FldCOMTempListField1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTempListField1 $$GetPropertyName^COMConst("COMTempList",1)
  public static Object $$$StrCOMTempListField1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList",1));
  }

  //<< #define COMTempListField2(%obj) $piece(%obj,"~",2)
  public static Object $$$COMTempListField2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMTempListField2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMTempListField2 2
  public static Object $$$FldCOMTempListField2(mContext m$) {
    return (2);
  }

  //<< #define StrCOMTempListField2 $$GetPropertyName^COMConst("COMTempList",2)
  public static Object $$$StrCOMTempListField2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList",2));
  }

  //<< #define COMTempListField3(%obj) $piece(%obj,"~",3)
  public static Object $$$COMTempListField3(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMTempListField3Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMTempListField3 3
  public static Object $$$FldCOMTempListField3(mContext m$) {
    return (3);
  }

  //<< #define StrCOMTempListField3 $$GetPropertyName^COMConst("COMTempList",3)
  public static Object $$$StrCOMTempListField3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList",3));
  }

  //<< #define COMTempListField4(%obj) $piece(%obj,"~",4)
  public static Object $$$COMTempListField4(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMTempListField4Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMTempListField4 4
  public static Object $$$FldCOMTempListField4(mContext m$) {
    return (4);
  }

  //<< #define StrCOMTempListField4 $$GetPropertyName^COMConst("COMTempList",4)
  public static Object $$$StrCOMTempListField4(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList",4));
  }

  //<< #define FldCOMTempListUser1 1
  public static Object $$$FldCOMTempListUser1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTempListUser1 $$GetPropertyName^COMConst("COMTempList",,1)
  public static Object $$$StrCOMTempListUser1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList",null,1));
  }

  //<< #define FldCOMTempListInstance 2
  public static Object $$$FldCOMTempListInstance(mContext m$) {
    return (2);
  }

  //<< #define StrCOMTempListInstance $$GetPropertyName^COMConst("COMTempList",,2)
  public static Object $$$StrCOMTempListInstance(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList",null,2));
  }

  //<< #define FldCOMTempListKey1 3
  public static Object $$$FldCOMTempListKey1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMTempListKey1 $$GetPropertyName^COMConst("COMTempList",,3)
  public static Object $$$StrCOMTempListKey1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList",null,3));
  }

  //<< 
  //<< #define COMTempList1Field1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMTempList1Field1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMTempList1Field1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMTempList1Field1 1
  public static Object $$$FldCOMTempList1Field1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTempList1Field1 $$GetPropertyName^COMConst("COMTempList1",1)
  public static Object $$$StrCOMTempList1Field1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList1",1));
  }

  //<< #define COMTempList1Field2(%obj) $piece(%obj,"~",2)
  public static Object $$$COMTempList1Field2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMTempList1Field2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMTempList1Field2 2
  public static Object $$$FldCOMTempList1Field2(mContext m$) {
    return (2);
  }

  //<< #define StrCOMTempList1Field2 $$GetPropertyName^COMConst("COMTempList1",2)
  public static Object $$$StrCOMTempList1Field2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList1",2));
  }

  //<< #define COMTempList1Field3(%obj) $piece(%obj,"~",3)
  public static Object $$$COMTempList1Field3(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMTempList1Field3Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMTempList1Field3 3
  public static Object $$$FldCOMTempList1Field3(mContext m$) {
    return (3);
  }

  //<< #define StrCOMTempList1Field3 $$GetPropertyName^COMConst("COMTempList1",3)
  public static Object $$$StrCOMTempList1Field3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList1",3));
  }

  //<< #define COMTempList1Field4(%obj) $piece(%obj,"~",4)
  public static Object $$$COMTempList1Field4(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMTempList1Field4Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMTempList1Field4 4
  public static Object $$$FldCOMTempList1Field4(mContext m$) {
    return (4);
  }

  //<< #define StrCOMTempList1Field4 $$GetPropertyName^COMConst("COMTempList1",4)
  public static Object $$$StrCOMTempList1Field4(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList1",4));
  }

  //<< #define FldCOMTempList1User1 1
  public static Object $$$FldCOMTempList1User1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTempList1User1 $$GetPropertyName^COMConst("COMTempList1",,1)
  public static Object $$$StrCOMTempList1User1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList1",null,1));
  }

  //<< #define FldCOMTempList1Instance 2
  public static Object $$$FldCOMTempList1Instance(mContext m$) {
    return (2);
  }

  //<< #define StrCOMTempList1Instance $$GetPropertyName^COMConst("COMTempList1",,2)
  public static Object $$$StrCOMTempList1Instance(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList1",null,2));
  }

  //<< #define FldCOMTempList1Key1 3
  public static Object $$$FldCOMTempList1Key1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMTempList1Key1 $$GetPropertyName^COMConst("COMTempList1",,3)
  public static Object $$$StrCOMTempList1Key1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList1",null,3));
  }

  //<< 
  //<< #define COMTempList2Field1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMTempList2Field1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMTempList2Field1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMTempList2Field1 1
  public static Object $$$FldCOMTempList2Field1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTempList2Field1 $$GetPropertyName^COMConst("COMTempList2",1)
  public static Object $$$StrCOMTempList2Field1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList2",1));
  }

  //<< #define COMTempList2Field2(%obj) $piece(%obj,"~",2)
  public static Object $$$COMTempList2Field2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMTempList2Field2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMTempList2Field2 2
  public static Object $$$FldCOMTempList2Field2(mContext m$) {
    return (2);
  }

  //<< #define StrCOMTempList2Field2 $$GetPropertyName^COMConst("COMTempList2",2)
  public static Object $$$StrCOMTempList2Field2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList2",2));
  }

  //<< #define COMTempList2Field3(%obj) $piece(%obj,"~",3)
  public static Object $$$COMTempList2Field3(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMTempList2Field3Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMTempList2Field3 3
  public static Object $$$FldCOMTempList2Field3(mContext m$) {
    return (3);
  }

  //<< #define StrCOMTempList2Field3 $$GetPropertyName^COMConst("COMTempList2",3)
  public static Object $$$StrCOMTempList2Field3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList2",3));
  }

  //<< #define COMTempList2Field4(%obj) $piece(%obj,"~",4)
  public static Object $$$COMTempList2Field4(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMTempList2Field4Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMTempList2Field4 4
  public static Object $$$FldCOMTempList2Field4(mContext m$) {
    return (4);
  }

  //<< #define StrCOMTempList2Field4 $$GetPropertyName^COMConst("COMTempList2",4)
  public static Object $$$StrCOMTempList2Field4(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList2",4));
  }

  //<< #define FldCOMTempList2User1 1
  public static Object $$$FldCOMTempList2User1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTempList2User1 $$GetPropertyName^COMConst("COMTempList2",,1)
  public static Object $$$StrCOMTempList2User1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList2",null,1));
  }

  //<< #define FldCOMTempList2Instance 2
  public static Object $$$FldCOMTempList2Instance(mContext m$) {
    return (2);
  }

  //<< #define StrCOMTempList2Instance $$GetPropertyName^COMConst("COMTempList2",,2)
  public static Object $$$StrCOMTempList2Instance(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList2",null,2));
  }

  //<< #define FldCOMTempList2Key1 3
  public static Object $$$FldCOMTempList2Key1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMTempList2Key1 $$GetPropertyName^COMConst("COMTempList2",,3)
  public static Object $$$StrCOMTempList2Key1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList2",null,3));
  }

  //<< #define FldCOMTempList2Key2 4
  public static Object $$$FldCOMTempList2Key2(mContext m$) {
    return (4);
  }

  //<< #define StrCOMTempList2Key2 $$GetPropertyName^COMConst("COMTempList2",,4)
  public static Object $$$StrCOMTempList2Key2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList2",null,4));
  }

  //<< 
  //<< #define COMTempList3Field1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMTempList3Field1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMTempList3Field1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMTempList3Field1 1
  public static Object $$$FldCOMTempList3Field1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTempList3Field1 $$GetPropertyName^COMConst("COMTempList3",1)
  public static Object $$$StrCOMTempList3Field1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList3",1));
  }

  //<< #define COMTempList3Field2(%obj) $piece(%obj,"~",2)
  public static Object $$$COMTempList3Field2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMTempList3Field2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMTempList3Field2 2
  public static Object $$$FldCOMTempList3Field2(mContext m$) {
    return (2);
  }

  //<< #define StrCOMTempList3Field2 $$GetPropertyName^COMConst("COMTempList3",2)
  public static Object $$$StrCOMTempList3Field2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList3",2));
  }

  //<< #define COMTempList3Field3(%obj) $piece(%obj,"~",3)
  public static Object $$$COMTempList3Field3(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMTempList3Field3Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMTempList3Field3 3
  public static Object $$$FldCOMTempList3Field3(mContext m$) {
    return (3);
  }

  //<< #define StrCOMTempList3Field3 $$GetPropertyName^COMConst("COMTempList3",3)
  public static Object $$$StrCOMTempList3Field3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList3",3));
  }

  //<< #define COMTempList3Field4(%obj) $piece(%obj,"~",4)
  public static Object $$$COMTempList3Field4(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMTempList3Field4Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMTempList3Field4 4
  public static Object $$$FldCOMTempList3Field4(mContext m$) {
    return (4);
  }

  //<< #define StrCOMTempList3Field4 $$GetPropertyName^COMConst("COMTempList3",4)
  public static Object $$$StrCOMTempList3Field4(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList3",4));
  }

  //<< #define FldCOMTempList3User1 1
  public static Object $$$FldCOMTempList3User1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMTempList3User1 $$GetPropertyName^COMConst("COMTempList3",,1)
  public static Object $$$StrCOMTempList3User1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList3",null,1));
  }

  //<< #define FldCOMTempList3Instance 2
  public static Object $$$FldCOMTempList3Instance(mContext m$) {
    return (2);
  }

  //<< #define StrCOMTempList3Instance $$GetPropertyName^COMConst("COMTempList3",,2)
  public static Object $$$StrCOMTempList3Instance(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList3",null,2));
  }

  //<< #define FldCOMTempList3Key1 3
  public static Object $$$FldCOMTempList3Key1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMTempList3Key1 $$GetPropertyName^COMConst("COMTempList3",,3)
  public static Object $$$StrCOMTempList3Key1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList3",null,3));
  }

  //<< #define FldCOMTempList3Key2 4
  public static Object $$$FldCOMTempList3Key2(mContext m$) {
    return (4);
  }

  //<< #define StrCOMTempList3Key2 $$GetPropertyName^COMConst("COMTempList3",,4)
  public static Object $$$StrCOMTempList3Key2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList3",null,4));
  }

  //<< #define FldCOMTempList3Key3 5
  public static Object $$$FldCOMTempList3Key3(mContext m$) {
    return (5);
  }

  //<< #define StrCOMTempList3Key3 $$GetPropertyName^COMConst("COMTempList3",,5)
  public static Object $$$StrCOMTempList3Key3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMTempList3",null,5));
  }

  //<< 
  //<< #define COMUnitDecimalPlaces(%obj) $piece(%obj,"~",1)
  public static Object $$$COMUnitDecimalPlaces(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMUnitDecimalPlacesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMUnitDecimalPlaces 1
  public static Object $$$FldCOMUnitDecimalPlaces(mContext m$) {
    return (1);
  }

  //<< #define StrCOMUnitDecimalPlaces $$GetPropertyName^COMConst("COMUnit",1)
  public static Object $$$StrCOMUnitDecimalPlaces(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMUnit",1));
  }

  //<< #define FldCOMUnitUnit 1
  public static Object $$$FldCOMUnitUnit(mContext m$) {
    return (1);
  }

  //<< #define StrCOMUnitUnit $$GetPropertyName^COMConst("COMUnit",,1)
  public static Object $$$StrCOMUnitUnit(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMUnit",null,1));
  }

  //<< 
  //<< #define FldCOMUserPreferences 1
  public static Object $$$FldCOMUserPreferences(mContext m$) {
    return (1);
  }

  //<< #define StrCOMUserPreferences $$GetPropertyName^COMConst("COMUserPreferences",,1)
  public static Object $$$StrCOMUserPreferences(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMUserPreferences",null,1));
  }

  //<< 
  //<< #define COMViewDescription(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewDescription 1
  public static Object $$$FldCOMViewDescription(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewDescription $$GetPropertyName^COMConst("COMView",1)
  public static Object $$$StrCOMViewDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMView",1));
  }

  //<< #define COMViewLocation(%obj) $piece(%obj,"~",2)
  public static Object $$$COMViewLocation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMViewLocationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMViewLocation 2
  public static Object $$$FldCOMViewLocation(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewLocation $$GetPropertyName^COMConst("COMView",2)
  public static Object $$$StrCOMViewLocation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMView",2));
  }

  //<< #define COMViewUser1(%obj) $piece(%obj,"~",3)
  public static Object $$$COMViewUser1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMViewUser1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMViewUser1 3
  public static Object $$$FldCOMViewUser1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewUser1 $$GetPropertyName^COMConst("COMView",3)
  public static Object $$$StrCOMViewUser1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMView",3));
  }

  //<< #define COMViewDefaultProperty(%obj) $piece(%obj,"~",4)
  public static Object $$$COMViewDefaultProperty(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMViewDefaultPropertySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMViewDefaultProperty 4
  public static Object $$$FldCOMViewDefaultProperty(mContext m$) {
    return (4);
  }

  //<< #define StrCOMViewDefaultProperty $$GetPropertyName^COMConst("COMView",4)
  public static Object $$$StrCOMViewDefaultProperty(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMView",4));
  }

  //<< #define COMViewDistribute(%obj) $piece(%obj,"~",5)
  public static Object $$$COMViewDistribute(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMViewDistributeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMViewDistribute 5
  public static Object $$$FldCOMViewDistribute(mContext m$) {
    return (5);
  }

  //<< #define StrCOMViewDistribute $$GetPropertyName^COMConst("COMView",5)
  public static Object $$$StrCOMViewDistribute(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMView",5));
  }

  //<< #define COMViewLock(%obj) $piece(%obj,"~",6)
  public static Object $$$COMViewLock(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMViewLockSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMViewLock 6
  public static Object $$$FldCOMViewLock(mContext m$) {
    return (6);
  }

  //<< #define StrCOMViewLock $$GetPropertyName^COMConst("COMView",6)
  public static Object $$$StrCOMViewLock(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMView",6));
  }

  //<< #define COMViewForm(%obj) $piece(%obj,"~",7)
  public static Object $$$COMViewForm(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMViewFormSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMViewForm 7
  public static Object $$$FldCOMViewForm(mContext m$) {
    return (7);
  }

  //<< #define StrCOMViewForm $$GetPropertyName^COMConst("COMView",7)
  public static Object $$$StrCOMViewForm(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMView",7));
  }

  //<< #define COMViewSQL1(%obj) $piece(%obj,"~",8)
  public static Object $$$COMViewSQL1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMViewSQL1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMViewSQL1 8
  public static Object $$$FldCOMViewSQL1(mContext m$) {
    return (8);
  }

  //<< #define StrCOMViewSQL1 $$GetPropertyName^COMConst("COMView",8)
  public static Object $$$StrCOMViewSQL1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMView",8));
  }

  //<< #define COMViewRetrieveAllRecords(%obj) $piece(%obj,"~",9)
  public static Object $$$COMViewRetrieveAllRecords(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMViewRetrieveAllRecordsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMViewRetrieveAllRecords 9
  public static Object $$$FldCOMViewRetrieveAllRecords(mContext m$) {
    return (9);
  }

  //<< #define StrCOMViewRetrieveAllRecords $$GetPropertyName^COMConst("COMView",9)
  public static Object $$$StrCOMViewRetrieveAllRecords(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMView",9));
  }

  //<< #define FldCOMViewClass 1
  public static Object $$$FldCOMViewClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewClass $$GetPropertyName^COMConst("COMView",,1)
  public static Object $$$StrCOMViewClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMView",null,1));
  }

  //<< #define FldCOMViewViewNumber 2
  public static Object $$$FldCOMViewViewNumber(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewViewNumber $$GetPropertyName^COMConst("COMView",,2)
  public static Object $$$StrCOMViewViewNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMView",null,2));
  }

  //<< 
  //<< #define COMViewColumnColumn1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewColumnColumn1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewColumnColumn1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewColumnColumn1 1
  public static Object $$$FldCOMViewColumnColumn1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewColumnColumn1 $$GetPropertyName^COMConst("COMViewColumn",1)
  public static Object $$$StrCOMViewColumnColumn1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumn",1));
  }

  //<< #define COMViewColumnWidth(%obj) $piece(%obj,"~",2)
  public static Object $$$COMViewColumnWidth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMViewColumnWidthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMViewColumnWidth 2
  public static Object $$$FldCOMViewColumnWidth(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewColumnWidth $$GetPropertyName^COMConst("COMViewColumn",2)
  public static Object $$$StrCOMViewColumnWidth(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumn",2));
  }

  //<< #define COMViewColumnSort1(%obj) $piece(%obj,"~",3)
  public static Object $$$COMViewColumnSort1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMViewColumnSort1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMViewColumnSort1 3
  public static Object $$$FldCOMViewColumnSort1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewColumnSort1 $$GetPropertyName^COMConst("COMViewColumn",3)
  public static Object $$$StrCOMViewColumnSort1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumn",3));
  }

  //<< #define COMViewColumnGroup1(%obj) $piece(%obj,"~",4)
  public static Object $$$COMViewColumnGroup1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMViewColumnGroup1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMViewColumnGroup1 4
  public static Object $$$FldCOMViewColumnGroup1(mContext m$) {
    return (4);
  }

  //<< #define StrCOMViewColumnGroup1 $$GetPropertyName^COMConst("COMViewColumn",4)
  public static Object $$$StrCOMViewColumnGroup1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumn",4));
  }

  //<< #define COMViewColumnExpandGroup(%obj) $piece(%obj,"~",5)
  public static Object $$$COMViewColumnExpandGroup(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMViewColumnExpandGroupSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMViewColumnExpandGroup 5
  public static Object $$$FldCOMViewColumnExpandGroup(mContext m$) {
    return (5);
  }

  //<< #define StrCOMViewColumnExpandGroup $$GetPropertyName^COMConst("COMViewColumn",5)
  public static Object $$$StrCOMViewColumnExpandGroup(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumn",5));
  }

  //<< #define FldCOMViewColumnClass 1
  public static Object $$$FldCOMViewColumnClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewColumnClass $$GetPropertyName^COMConst("COMViewColumn",,1)
  public static Object $$$StrCOMViewColumnClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumn",null,1));
  }

  //<< #define FldCOMViewColumnViewNumber 2
  public static Object $$$FldCOMViewColumnViewNumber(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewColumnViewNumber $$GetPropertyName^COMConst("COMViewColumn",,2)
  public static Object $$$StrCOMViewColumnViewNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumn",null,2));
  }

  //<< #define FldCOMViewColumnField 3
  public static Object $$$FldCOMViewColumnField(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewColumnField $$GetPropertyName^COMConst("COMViewColumn",,3)
  public static Object $$$StrCOMViewColumnField(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumn",null,3));
  }

  //<< 
  //<< #define COMViewColumnUserColumn1(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewColumnUserColumn1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewColumnUserColumn1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewColumnUserColumn1 1
  public static Object $$$FldCOMViewColumnUserColumn1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewColumnUserColumn1 $$GetPropertyName^COMConst("COMViewColumnUser",1)
  public static Object $$$StrCOMViewColumnUserColumn1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumnUser",1));
  }

  //<< #define COMViewColumnUserWidth(%obj) $piece(%obj,"~",2)
  public static Object $$$COMViewColumnUserWidth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMViewColumnUserWidthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMViewColumnUserWidth 2
  public static Object $$$FldCOMViewColumnUserWidth(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewColumnUserWidth $$GetPropertyName^COMConst("COMViewColumnUser",2)
  public static Object $$$StrCOMViewColumnUserWidth(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumnUser",2));
  }

  //<< #define COMViewColumnUserSort1(%obj) $piece(%obj,"~",3)
  public static Object $$$COMViewColumnUserSort1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMViewColumnUserSort1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMViewColumnUserSort1 3
  public static Object $$$FldCOMViewColumnUserSort1(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewColumnUserSort1 $$GetPropertyName^COMConst("COMViewColumnUser",3)
  public static Object $$$StrCOMViewColumnUserSort1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumnUser",3));
  }

  //<< #define COMViewColumnUserGroup1(%obj) $piece(%obj,"~",4)
  public static Object $$$COMViewColumnUserGroup1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMViewColumnUserGroup1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMViewColumnUserGroup1 4
  public static Object $$$FldCOMViewColumnUserGroup1(mContext m$) {
    return (4);
  }

  //<< #define StrCOMViewColumnUserGroup1 $$GetPropertyName^COMConst("COMViewColumnUser",4)
  public static Object $$$StrCOMViewColumnUserGroup1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumnUser",4));
  }

  //<< #define COMViewColumnUserExpandGroup(%obj) $piece(%obj,"~",5)
  public static Object $$$COMViewColumnUserExpandGroup(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMViewColumnUserExpandGroupSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMViewColumnUserExpandGroup 5
  public static Object $$$FldCOMViewColumnUserExpandGroup(mContext m$) {
    return (5);
  }

  //<< #define StrCOMViewColumnUserExpandGroup $$GetPropertyName^COMConst("COMViewColumnUser",5)
  public static Object $$$StrCOMViewColumnUserExpandGroup(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumnUser",5));
  }

  //<< #define FldCOMViewColumnUserClass 1
  public static Object $$$FldCOMViewColumnUserClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewColumnUserClass $$GetPropertyName^COMConst("COMViewColumnUser",,1)
  public static Object $$$StrCOMViewColumnUserClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumnUser",null,1));
  }

  //<< #define FldCOMViewColumnUserView 2
  public static Object $$$FldCOMViewColumnUserView(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewColumnUserView $$GetPropertyName^COMConst("COMViewColumnUser",,2)
  public static Object $$$StrCOMViewColumnUserView(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumnUser",null,2));
  }

  //<< #define FldCOMViewColumnUserField 3
  public static Object $$$FldCOMViewColumnUserField(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewColumnUserField $$GetPropertyName^COMConst("COMViewColumnUser",,3)
  public static Object $$$StrCOMViewColumnUserField(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumnUser",null,3));
  }

  //<< #define FldCOMViewColumnUserField1 4
  public static Object $$$FldCOMViewColumnUserField1(mContext m$) {
    return (4);
  }

  //<< #define StrCOMViewColumnUserField1 $$GetPropertyName^COMConst("COMViewColumnUser",,4)
  public static Object $$$StrCOMViewColumnUserField1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewColumnUser",null,4));
  }

  //<< 
  //<< #define COMViewCommandDescription(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewCommandDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewCommandDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewCommandDescription 1
  public static Object $$$FldCOMViewCommandDescription(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewCommandDescription $$GetPropertyName^COMConst("COMViewCommand",1)
  public static Object $$$StrCOMViewCommandDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewCommand",1));
  }

  //<< #define COMViewCommandImage(%obj) $piece(%obj,"~",2)
  public static Object $$$COMViewCommandImage(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMViewCommandImageSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMViewCommandImage 2
  public static Object $$$FldCOMViewCommandImage(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewCommandImage $$GetPropertyName^COMConst("COMViewCommand",2)
  public static Object $$$StrCOMViewCommandImage(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewCommand",2));
  }

  //<< #define COMViewCommandCode(%obj) $piece(%obj,"~",3)
  public static Object $$$COMViewCommandCode(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMViewCommandCodeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMViewCommandCode 3
  public static Object $$$FldCOMViewCommandCode(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewCommandCode $$GetPropertyName^COMConst("COMViewCommand",3)
  public static Object $$$StrCOMViewCommandCode(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewCommand",3));
  }

  //<< #define COMViewCommandConfirmText(%obj) $piece(%obj,"~",4)
  public static Object $$$COMViewCommandConfirmText(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMViewCommandConfirmTextSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMViewCommandConfirmText 4
  public static Object $$$FldCOMViewCommandConfirmText(mContext m$) {
    return (4);
  }

  //<< #define StrCOMViewCommandConfirmText $$GetPropertyName^COMConst("COMViewCommand",4)
  public static Object $$$StrCOMViewCommandConfirmText(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewCommand",4));
  }

  //<< #define FldCOMViewCommandCommand 1
  public static Object $$$FldCOMViewCommandCommand(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewCommandCommand $$GetPropertyName^COMConst("COMViewCommand",,1)
  public static Object $$$StrCOMViewCommandCommand(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewCommand",null,1));
  }

  //<< 
  //<< #define COMViewConfigKeystrokeDelay(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewConfigKeystrokeDelay(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewConfigKeystrokeDelaySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewConfigKeystrokeDelay 1
  public static Object $$$FldCOMViewConfigKeystrokeDelay(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewConfigKeystrokeDelay $$GetPropertyName^COMConst("COMViewConfig",1)
  public static Object $$$StrCOMViewConfigKeystrokeDelay(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",1));
  }

  //<< #define COMViewConfigMinimumSQLLogtime(%obj) $piece(%obj,"~",2)
  public static Object $$$COMViewConfigMinimumSQLLogtime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMViewConfigMinimumSQLLogtimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMViewConfigMinimumSQLLogtime 2
  public static Object $$$FldCOMViewConfigMinimumSQLLogtime(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewConfigMinimumSQLLogtime $$GetPropertyName^COMConst("COMViewConfig",2)
  public static Object $$$StrCOMViewConfigMinimumSQLLogtime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",2));
  }

  //<< #define COMViewConfigHeaderbackgroundcolour(%obj) $piece(%obj,"~",3)
  public static Object $$$COMViewConfigHeaderbackgroundcolour(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMViewConfigHeaderbackgroundcolourSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMViewConfigHeaderbackgroundcolour 3
  public static Object $$$FldCOMViewConfigHeaderbackgroundcolour(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewConfigHeaderbackgroundcolour $$GetPropertyName^COMConst("COMViewConfig",3)
  public static Object $$$StrCOMViewConfigHeaderbackgroundcolour(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",3));
  }

  //<< #define COMViewConfigHeaderforegroundcolour(%obj) $piece(%obj,"~",4)
  public static Object $$$COMViewConfigHeaderforegroundcolour(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMViewConfigHeaderforegroundcolourSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMViewConfigHeaderforegroundcolour 4
  public static Object $$$FldCOMViewConfigHeaderforegroundcolour(mContext m$) {
    return (4);
  }

  //<< #define StrCOMViewConfigHeaderforegroundcolour $$GetPropertyName^COMConst("COMViewConfig",4)
  public static Object $$$StrCOMViewConfigHeaderforegroundcolour(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",4));
  }

  //<< #define COMViewConfigHeaderbordercolour(%obj) $piece(%obj,"~",5)
  public static Object $$$COMViewConfigHeaderbordercolour(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMViewConfigHeaderbordercolourSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMViewConfigHeaderbordercolour 5
  public static Object $$$FldCOMViewConfigHeaderbordercolour(mContext m$) {
    return (5);
  }

  //<< #define StrCOMViewConfigHeaderbordercolour $$GetPropertyName^COMConst("COMViewConfig",5)
  public static Object $$$StrCOMViewConfigHeaderbordercolour(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",5));
  }

  //<< #define COMViewConfigRowSelectedcolour(%obj) $piece(%obj,"~",7)
  public static Object $$$COMViewConfigRowSelectedcolour(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMViewConfigRowSelectedcolourSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMViewConfigRowSelectedcolour 7
  public static Object $$$FldCOMViewConfigRowSelectedcolour(mContext m$) {
    return (7);
  }

  //<< #define StrCOMViewConfigRowSelectedcolour $$GetPropertyName^COMConst("COMViewConfig",7)
  public static Object $$$StrCOMViewConfigRowSelectedcolour(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",7));
  }

  //<< #define COMViewConfigColumnheaderbackgroundcol(%obj) $piece(%obj,"~",8)
  public static Object $$$COMViewConfigColumnheaderbackgroundcol(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMViewConfigColumnheaderbackgroundcolSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMViewConfigColumnheaderbackgroundcol 8
  public static Object $$$FldCOMViewConfigColumnheaderbackgroundcol(mContext m$) {
    return (8);
  }

  //<< #define StrCOMViewConfigColumnheaderbackgroundcol $$GetPropertyName^COMConst("COMViewConfig",8)
  public static Object $$$StrCOMViewConfigColumnheaderbackgroundcol(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",8));
  }

  //<< #define COMViewConfigSearchType(%obj) $piece(%obj,"~",9)
  public static Object $$$COMViewConfigSearchType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMViewConfigSearchTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMViewConfigSearchType 9
  public static Object $$$FldCOMViewConfigSearchType(mContext m$) {
    return (9);
  }

  //<< #define StrCOMViewConfigSearchType $$GetPropertyName^COMConst("COMViewConfig",9)
  public static Object $$$StrCOMViewConfigSearchType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",9));
  }

  //<< #define COMViewConfigDevelopmentMode(%obj) $piece(%obj,"~",10)
  public static Object $$$COMViewConfigDevelopmentMode(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$COMViewConfigDevelopmentModeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldCOMViewConfigDevelopmentMode 10
  public static Object $$$FldCOMViewConfigDevelopmentMode(mContext m$) {
    return (10);
  }

  //<< #define StrCOMViewConfigDevelopmentMode $$GetPropertyName^COMConst("COMViewConfig",10)
  public static Object $$$StrCOMViewConfigDevelopmentMode(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",10));
  }

  //<< #define COMViewConfigModifiedBy(%obj) $piece(%obj,"~",11)
  public static Object $$$COMViewConfigModifiedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$COMViewConfigModifiedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldCOMViewConfigModifiedBy 11
  public static Object $$$FldCOMViewConfigModifiedBy(mContext m$) {
    return (11);
  }

  //<< #define StrCOMViewConfigModifiedBy $$GetPropertyName^COMConst("COMViewConfig",11)
  public static Object $$$StrCOMViewConfigModifiedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",11));
  }

  //<< #define COMViewConfigModifiedDate(%obj) $piece(%obj,"~",12)
  public static Object $$$COMViewConfigModifiedDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$COMViewConfigModifiedDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldCOMViewConfigModifiedDate 12
  public static Object $$$FldCOMViewConfigModifiedDate(mContext m$) {
    return (12);
  }

  //<< #define StrCOMViewConfigModifiedDate $$GetPropertyName^COMConst("COMViewConfig",12)
  public static Object $$$StrCOMViewConfigModifiedDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",12));
  }

  //<< #define COMViewConfigMaxdatalength(%obj) $piece(%obj,"~",13)
  public static Object $$$COMViewConfigMaxdatalength(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$COMViewConfigMaxdatalengthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldCOMViewConfigMaxdatalength 13
  public static Object $$$FldCOMViewConfigMaxdatalength(mContext m$) {
    return (13);
  }

  //<< #define StrCOMViewConfigMaxdatalength $$GetPropertyName^COMConst("COMViewConfig",13)
  public static Object $$$StrCOMViewConfigMaxdatalength(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",13));
  }

  //<< #define COMViewConfigMaxrecords(%obj) $piece(%obj,"~",14)
  public static Object $$$COMViewConfigMaxrecords(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",14));
  }

  public static void $$$COMViewConfigMaxrecordsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",14).set(_setval.get());
  }

  //<< #define FldCOMViewConfigMaxrecords 14
  public static Object $$$FldCOMViewConfigMaxrecords(mContext m$) {
    return (14);
  }

  //<< #define StrCOMViewConfigMaxrecords $$GetPropertyName^COMConst("COMViewConfig",14)
  public static Object $$$StrCOMViewConfigMaxrecords(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",14));
  }

  //<< #define COMViewConfigFastFileCheck(%obj) $piece(%obj,"~",15)
  public static Object $$$COMViewConfigFastFileCheck(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",15));
  }

  public static void $$$COMViewConfigFastFileCheckSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",15).set(_setval.get());
  }

  //<< #define FldCOMViewConfigFastFileCheck 15
  public static Object $$$FldCOMViewConfigFastFileCheck(mContext m$) {
    return (15);
  }

  //<< #define StrCOMViewConfigFastFileCheck $$GetPropertyName^COMConst("COMViewConfig",15)
  public static Object $$$StrCOMViewConfigFastFileCheck(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",15));
  }

  //<< #define COMViewConfigAbletocreateviews(%obj) $piece(%obj,"~",16)
  public static Object $$$COMViewConfigAbletocreateviews(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",16));
  }

  public static void $$$COMViewConfigAbletocreateviewsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",16).set(_setval.get());
  }

  //<< #define FldCOMViewConfigAbletocreateviews 16
  public static Object $$$FldCOMViewConfigAbletocreateviews(mContext m$) {
    return (16);
  }

  //<< #define StrCOMViewConfigAbletocreateviews $$GetPropertyName^COMConst("COMViewConfig",16)
  public static Object $$$StrCOMViewConfigAbletocreateviews(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",16));
  }

  //<< #define COMViewConfigSearchSubmission(%obj) $piece(%obj,"~",17)
  public static Object $$$COMViewConfigSearchSubmission(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",17));
  }

  public static void $$$COMViewConfigSearchSubmissionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",17).set(_setval.get());
  }

  //<< #define FldCOMViewConfigSearchSubmission 17
  public static Object $$$FldCOMViewConfigSearchSubmission(mContext m$) {
    return (17);
  }

  //<< #define StrCOMViewConfigSearchSubmission $$GetPropertyName^COMConst("COMViewConfig",17)
  public static Object $$$StrCOMViewConfigSearchSubmission(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",17));
  }

  //<< #define COMViewConfigMaximumResultsReturned(%obj) $piece(%obj,"~",18)
  public static Object $$$COMViewConfigMaximumResultsReturned(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",18));
  }

  public static void $$$COMViewConfigMaximumResultsReturnedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",18).set(_setval.get());
  }

  //<< #define FldCOMViewConfigMaximumResultsReturned 18
  public static Object $$$FldCOMViewConfigMaximumResultsReturned(mContext m$) {
    return (18);
  }

  //<< #define StrCOMViewConfigMaximumResultsReturned $$GetPropertyName^COMConst("COMViewConfig",18)
  public static Object $$$StrCOMViewConfigMaximumResultsReturned(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",18));
  }

  //<< #define COMViewConfigRowClickedcolour(%obj) $piece(%obj,"~",19)
  public static Object $$$COMViewConfigRowClickedcolour(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",19));
  }

  public static void $$$COMViewConfigRowClickedcolourSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",19).set(_setval.get());
  }

  //<< #define FldCOMViewConfigRowClickedcolour 19
  public static Object $$$FldCOMViewConfigRowClickedcolour(mContext m$) {
    return (19);
  }

  //<< #define StrCOMViewConfigRowClickedcolour $$GetPropertyName^COMConst("COMViewConfig",19)
  public static Object $$$StrCOMViewConfigRowClickedcolour(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",19));
  }

  //<< #define COMViewConfigRowSelectedClickedcolour(%obj) $piece(%obj,"~",20)
  public static Object $$$COMViewConfigRowSelectedClickedcolour(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",20));
  }

  public static void $$$COMViewConfigRowSelectedClickedcolourSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",20).set(_setval.get());
  }

  //<< #define FldCOMViewConfigRowSelectedClickedcolour 20
  public static Object $$$FldCOMViewConfigRowSelectedClickedcolour(mContext m$) {
    return (20);
  }

  //<< #define StrCOMViewConfigRowSelectedClickedcolour $$GetPropertyName^COMConst("COMViewConfig",20)
  public static Object $$$StrCOMViewConfigRowSelectedClickedcolour(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",20));
  }

  //<< #define COMViewConfigMapAccentMark(%obj) $piece(%obj,"~",21)
  public static Object $$$COMViewConfigMapAccentMark(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",21));
  }

  public static void $$$COMViewConfigMapAccentMarkSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",21).set(_setval.get());
  }

  //<< #define FldCOMViewConfigMapAccentMark 21
  public static Object $$$FldCOMViewConfigMapAccentMark(mContext m$) {
    return (21);
  }

  //<< #define StrCOMViewConfigMapAccentMark $$GetPropertyName^COMConst("COMViewConfig",21)
  public static Object $$$StrCOMViewConfigMapAccentMark(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",21));
  }

  //<< #define COMViewConfigHideFilterDescription(%obj) $piece(%obj,"~",22)
  public static Object $$$COMViewConfigHideFilterDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",22));
  }

  public static void $$$COMViewConfigHideFilterDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",22).set(_setval.get());
  }

  //<< #define FldCOMViewConfigHideFilterDescription 22
  public static Object $$$FldCOMViewConfigHideFilterDescription(mContext m$) {
    return (22);
  }

  //<< #define StrCOMViewConfigHideFilterDescription $$GetPropertyName^COMConst("COMViewConfig",22)
  public static Object $$$StrCOMViewConfigHideFilterDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",22));
  }

  //<< #define COMViewConfigAbletoviewfilterdescripti(%obj) $piece(%obj,"~",23)
  public static Object $$$COMViewConfigAbletoviewfilterdescripti(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",23));
  }

  public static void $$$COMViewConfigAbletoviewfilterdescriptiSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",23).set(_setval.get());
  }

  //<< #define FldCOMViewConfigAbletoviewfilterdescripti 23
  public static Object $$$FldCOMViewConfigAbletoviewfilterdescripti(mContext m$) {
    return (23);
  }

  //<< #define StrCOMViewConfigAbletoviewfilterdescripti $$GetPropertyName^COMConst("COMViewConfig",23)
  public static Object $$$StrCOMViewConfigAbletoviewfilterdescripti(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",23));
  }

  //<< #define COMViewConfigDisplayFilterInExcel(%obj) $piece(%obj,"~",24)
  public static Object $$$COMViewConfigDisplayFilterInExcel(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",24));
  }

  public static void $$$COMViewConfigDisplayFilterInExcelSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",24).set(_setval.get());
  }

  //<< #define FldCOMViewConfigDisplayFilterInExcel 24
  public static Object $$$FldCOMViewConfigDisplayFilterInExcel(mContext m$) {
    return (24);
  }

  //<< #define StrCOMViewConfigDisplayFilterInExcel $$GetPropertyName^COMConst("COMViewConfig",24)
  public static Object $$$StrCOMViewConfigDisplayFilterInExcel(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",24));
  }

  //<< #define COMViewConfigFieldDebug(%obj) $piece(%obj,"~",25)
  public static Object $$$COMViewConfigFieldDebug(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",25));
  }

  public static void $$$COMViewConfigFieldDebugSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",25).set(_setval.get());
  }

  //<< #define FldCOMViewConfigFieldDebug 25
  public static Object $$$FldCOMViewConfigFieldDebug(mContext m$) {
    return (25);
  }

  //<< #define StrCOMViewConfigFieldDebug $$GetPropertyName^COMConst("COMViewConfig",25)
  public static Object $$$StrCOMViewConfigFieldDebug(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",25));
  }

  //<< #define COMViewConfigExpandSelection(%obj) $piece(%obj,"~",26)
  public static Object $$$COMViewConfigExpandSelection(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",26));
  }

  public static void $$$COMViewConfigExpandSelectionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",26).set(_setval.get());
  }

  //<< #define FldCOMViewConfigExpandSelection 26
  public static Object $$$FldCOMViewConfigExpandSelection(mContext m$) {
    return (26);
  }

  //<< #define StrCOMViewConfigExpandSelection $$GetPropertyName^COMConst("COMViewConfig",26)
  public static Object $$$StrCOMViewConfigExpandSelection(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",26));
  }

  //<< #define COMViewConfigSuperUser(%obj) $piece(%obj,"~",27)
  public static Object $$$COMViewConfigSuperUser(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",27));
  }

  public static void $$$COMViewConfigSuperUserSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",27).set(_setval.get());
  }

  //<< #define FldCOMViewConfigSuperUser 27
  public static Object $$$FldCOMViewConfigSuperUser(mContext m$) {
    return (27);
  }

  //<< #define StrCOMViewConfigSuperUser $$GetPropertyName^COMConst("COMViewConfig",27)
  public static Object $$$StrCOMViewConfigSuperUser(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",27));
  }

  //<< #define FldCOMViewConfigCompany 1
  public static Object $$$FldCOMViewConfigCompany(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewConfigCompany $$GetPropertyName^COMConst("COMViewConfig",,1)
  public static Object $$$StrCOMViewConfigCompany(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewConfig",null,1));
  }

  //<< 
  //<< #define FldCOMViewDefault 1
  public static Object $$$FldCOMViewDefault(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewDefault $$GetPropertyName^COMConst("COMViewDefault",,1)
  public static Object $$$StrCOMViewDefault(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewDefault",null,1));
  }

  //<< 
  //<< #define COMViewFileModifiedDate(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewFileModifiedDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewFileModifiedDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewFileModifiedDate 1
  public static Object $$$FldCOMViewFileModifiedDate(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewFileModifiedDate $$GetPropertyName^COMConst("COMViewFile",1)
  public static Object $$$StrCOMViewFileModifiedDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFile",1));
  }

  //<< #define FldCOMViewFileFilePath 1
  public static Object $$$FldCOMViewFileFilePath(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewFileFilePath $$GetPropertyName^COMConst("COMViewFile",,1)
  public static Object $$$StrCOMViewFileFilePath(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFile",null,1));
  }

  //<< 
  //<< #define COMViewFilterField(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewFilterField(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewFilterFieldSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewFilterField 1
  public static Object $$$FldCOMViewFilterField(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewFilterField $$GetPropertyName^COMConst("COMViewFilter",1)
  public static Object $$$StrCOMViewFilterField(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFilter",1));
  }

  //<< #define COMViewFilterValue1(%obj) $piece(%obj,"~",2)
  public static Object $$$COMViewFilterValue1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMViewFilterValue1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMViewFilterValue1 2
  public static Object $$$FldCOMViewFilterValue1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewFilterValue1 $$GetPropertyName^COMConst("COMViewFilter",2)
  public static Object $$$StrCOMViewFilterValue1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFilter",2));
  }

  //<< #define COMViewFilterComparator(%obj) $piece(%obj,"~",3)
  public static Object $$$COMViewFilterComparator(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMViewFilterComparatorSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMViewFilterComparator 3
  public static Object $$$FldCOMViewFilterComparator(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewFilterComparator $$GetPropertyName^COMConst("COMViewFilter",3)
  public static Object $$$StrCOMViewFilterComparator(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFilter",3));
  }

  //<< #define COMViewFilterDisplay(%obj) $piece(%obj,"~",5)
  public static Object $$$COMViewFilterDisplay(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMViewFilterDisplaySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMViewFilterDisplay 5
  public static Object $$$FldCOMViewFilterDisplay(mContext m$) {
    return (5);
  }

  //<< #define StrCOMViewFilterDisplay $$GetPropertyName^COMConst("COMViewFilter",5)
  public static Object $$$StrCOMViewFilterDisplay(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFilter",5));
  }

  //<< #define COMViewFilterGroupBy(%obj) $piece(%obj,"~",6)
  public static Object $$$COMViewFilterGroupBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMViewFilterGroupBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMViewFilterGroupBy 6
  public static Object $$$FldCOMViewFilterGroupBy(mContext m$) {
    return (6);
  }

  //<< #define StrCOMViewFilterGroupBy $$GetPropertyName^COMConst("COMViewFilter",6)
  public static Object $$$StrCOMViewFilterGroupBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFilter",6));
  }

  //<< #define COMViewFilterNoconversion(%obj) $piece(%obj,"~",7)
  public static Object $$$COMViewFilterNoconversion(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMViewFilterNoconversionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMViewFilterNoconversion 7
  public static Object $$$FldCOMViewFilterNoconversion(mContext m$) {
    return (7);
  }

  //<< #define StrCOMViewFilterNoconversion $$GetPropertyName^COMConst("COMViewFilter",7)
  public static Object $$$StrCOMViewFilterNoconversion(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFilter",7));
  }

  //<< #define COMViewFilterDataAccess(%obj) $piece(%obj,"~",8)
  public static Object $$$COMViewFilterDataAccess(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMViewFilterDataAccessSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMViewFilterDataAccess 8
  public static Object $$$FldCOMViewFilterDataAccess(mContext m$) {
    return (8);
  }

  //<< #define StrCOMViewFilterDataAccess $$GetPropertyName^COMConst("COMViewFilter",8)
  public static Object $$$StrCOMViewFilterDataAccess(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFilter",8));
  }

  //<< #define COMViewFilterStoreValue(%obj) $piece(%obj,"~",9)
  public static Object $$$COMViewFilterStoreValue(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$COMViewFilterStoreValueSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldCOMViewFilterStoreValue 9
  public static Object $$$FldCOMViewFilterStoreValue(mContext m$) {
    return (9);
  }

  //<< #define StrCOMViewFilterStoreValue $$GetPropertyName^COMConst("COMViewFilter",9)
  public static Object $$$StrCOMViewFilterStoreValue(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFilter",9));
  }

  //<< #define FldCOMViewFilterClass 1
  public static Object $$$FldCOMViewFilterClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewFilterClass $$GetPropertyName^COMConst("COMViewFilter",,1)
  public static Object $$$StrCOMViewFilterClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFilter",null,1));
  }

  //<< #define FldCOMViewFilterViewNumber 2
  public static Object $$$FldCOMViewFilterViewNumber(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewFilterViewNumber $$GetPropertyName^COMConst("COMViewFilter",,2)
  public static Object $$$StrCOMViewFilterViewNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFilter",null,2));
  }

  //<< #define FldCOMViewFilterFilterNumber 3
  public static Object $$$FldCOMViewFilterFilterNumber(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewFilterFilterNumber $$GetPropertyName^COMConst("COMViewFilter",,3)
  public static Object $$$StrCOMViewFilterFilterNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewFilter",null,3));
  }

  //<< 
  //<< #define COMViewLangDescription(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewLangDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewLangDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewLangDescription 1
  public static Object $$$FldCOMViewLangDescription(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewLangDescription $$GetPropertyName^COMConst("COMViewLang",1)
  public static Object $$$StrCOMViewLangDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLang",1));
  }

  //<< #define COMViewLangOriginalText(%obj) $piece(%obj,"~",2)
  public static Object $$$COMViewLangOriginalText(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMViewLangOriginalTextSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMViewLangOriginalText 2
  public static Object $$$FldCOMViewLangOriginalText(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewLangOriginalText $$GetPropertyName^COMConst("COMViewLang",2)
  public static Object $$$StrCOMViewLangOriginalText(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLang",2));
  }

  //<< #define FldCOMViewLangClass 1
  public static Object $$$FldCOMViewLangClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewLangClass $$GetPropertyName^COMConst("COMViewLang",,1)
  public static Object $$$StrCOMViewLangClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLang",null,1));
  }

  //<< #define FldCOMViewLangLanguage1 2
  public static Object $$$FldCOMViewLangLanguage1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewLangLanguage1 $$GetPropertyName^COMConst("COMViewLang",,2)
  public static Object $$$StrCOMViewLangLanguage1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLang",null,2));
  }

  //<< #define FldCOMViewLangViewNumber 3
  public static Object $$$FldCOMViewLangViewNumber(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewLangViewNumber $$GetPropertyName^COMConst("COMViewLang",,3)
  public static Object $$$StrCOMViewLangViewNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLang",null,3));
  }

  //<< 
  //<< #define COMViewLanguageCodeCodes(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewLanguageCodeCodes(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewLanguageCodeCodesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewLanguageCodeCodes 1
  public static Object $$$FldCOMViewLanguageCodeCodes(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewLanguageCodeCodes $$GetPropertyName^COMConst("COMViewLanguageCode",1)
  public static Object $$$StrCOMViewLanguageCodeCodes(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLanguageCode",1));
  }

  //<< #define FldCOMViewLanguageCodeId1 1
  public static Object $$$FldCOMViewLanguageCodeId1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewLanguageCodeId1 $$GetPropertyName^COMConst("COMViewLanguageCode",,1)
  public static Object $$$StrCOMViewLanguageCodeId1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLanguageCode",null,1));
  }

  //<< 
  //<< #define COMViewLanguageTextText(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewLanguageTextText(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewLanguageTextTextSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewLanguageTextText 1
  public static Object $$$FldCOMViewLanguageTextText(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewLanguageTextText $$GetPropertyName^COMConst("COMViewLanguageText",1)
  public static Object $$$StrCOMViewLanguageTextText(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLanguageText",1));
  }

  //<< #define FldCOMViewLanguageTextLanguage1 1
  public static Object $$$FldCOMViewLanguageTextLanguage1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewLanguageTextLanguage1 $$GetPropertyName^COMConst("COMViewLanguageText",,1)
  public static Object $$$StrCOMViewLanguageTextLanguage1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLanguageText",null,1));
  }

  //<< 
  //<< #define COMViewLogNumberofhits(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewLogNumberofhits(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewLogNumberofhitsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewLogNumberofhits 1
  public static Object $$$FldCOMViewLogNumberofhits(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewLogNumberofhits $$GetPropertyName^COMConst("COMViewLog",1)
  public static Object $$$StrCOMViewLogNumberofhits(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLog",1));
  }

  //<< #define COMViewLogTotalTimeTaken(%obj) $piece(%obj,"~",2)
  public static Object $$$COMViewLogTotalTimeTaken(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMViewLogTotalTimeTakenSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMViewLogTotalTimeTaken 2
  public static Object $$$FldCOMViewLogTotalTimeTaken(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewLogTotalTimeTaken $$GetPropertyName^COMConst("COMViewLog",2)
  public static Object $$$StrCOMViewLogTotalTimeTaken(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLog",2));
  }

  //<< #define COMViewLogAverageTimeTaken(%obj) $piece(%obj,"~",3)
  public static Object $$$COMViewLogAverageTimeTaken(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMViewLogAverageTimeTakenSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMViewLogAverageTimeTaken 3
  public static Object $$$FldCOMViewLogAverageTimeTaken(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewLogAverageTimeTaken $$GetPropertyName^COMConst("COMViewLog",3)
  public static Object $$$StrCOMViewLogAverageTimeTaken(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLog",3));
  }

  //<< #define COMViewLogLastTimeTaken(%obj) $piece(%obj,"~",4)
  public static Object $$$COMViewLogLastTimeTaken(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMViewLogLastTimeTakenSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMViewLogLastTimeTaken 4
  public static Object $$$FldCOMViewLogLastTimeTaken(mContext m$) {
    return (4);
  }

  //<< #define StrCOMViewLogLastTimeTaken $$GetPropertyName^COMConst("COMViewLog",4)
  public static Object $$$StrCOMViewLogLastTimeTaken(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLog",4));
  }

  //<< #define COMViewLogLastParams(%obj) $piece(%obj,"~",5)
  public static Object $$$COMViewLogLastParams(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMViewLogLastParamsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMViewLogLastParams 5
  public static Object $$$FldCOMViewLogLastParams(mContext m$) {
    return (5);
  }

  //<< #define StrCOMViewLogLastParams $$GetPropertyName^COMConst("COMViewLog",5)
  public static Object $$$StrCOMViewLogLastParams(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLog",5));
  }

  //<< #define COMViewLogSQLStatement(%obj) $piece(%obj,"~",6)
  public static Object $$$COMViewLogSQLStatement(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMViewLogSQLStatementSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMViewLogSQLStatement 6
  public static Object $$$FldCOMViewLogSQLStatement(mContext m$) {
    return (6);
  }

  //<< #define StrCOMViewLogSQLStatement $$GetPropertyName^COMConst("COMViewLog",6)
  public static Object $$$StrCOMViewLogSQLStatement(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLog",6));
  }

  //<< #define COMViewLogClassesUsed(%obj) $piece(%obj,"~",7)
  public static Object $$$COMViewLogClassesUsed(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMViewLogClassesUsedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMViewLogClassesUsed 7
  public static Object $$$FldCOMViewLogClassesUsed(mContext m$) {
    return (7);
  }

  //<< #define StrCOMViewLogClassesUsed $$GetPropertyName^COMConst("COMViewLog",7)
  public static Object $$$StrCOMViewLogClassesUsed(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLog",7));
  }

  //<< #define COMViewLogLastUsed(%obj) $piece(%obj,"~",8)
  public static Object $$$COMViewLogLastUsed(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$COMViewLogLastUsedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldCOMViewLogLastUsed 8
  public static Object $$$FldCOMViewLogLastUsed(mContext m$) {
    return (8);
  }

  //<< #define StrCOMViewLogLastUsed $$GetPropertyName^COMConst("COMViewLog",8)
  public static Object $$$StrCOMViewLogLastUsed(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLog",8));
  }

  //<< #define FldCOMViewLogLogNumber 1
  public static Object $$$FldCOMViewLogLogNumber(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewLogLogNumber $$GetPropertyName^COMConst("COMViewLog",,1)
  public static Object $$$StrCOMViewLogLogNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewLog",null,1));
  }

  //<< 
  //<< #define FldCOMViewSQL 1
  public static Object $$$FldCOMViewSQL(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewSQL $$GetPropertyName^COMConst("COMViewSQL",,1)
  public static Object $$$StrCOMViewSQL(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewSQL",null,1));
  }

  //<< 
  //<< #define COMViewUserLastView(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewUserLastView(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewUserLastViewSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewUserLastView 1
  public static Object $$$FldCOMViewUserLastView(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewUserLastView $$GetPropertyName^COMConst("COMViewUser",1)
  public static Object $$$StrCOMViewUserLastView(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUser",1));
  }

  //<< #define COMViewUserHeight(%obj) $piece(%obj,"~",2)
  public static Object $$$COMViewUserHeight(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMViewUserHeightSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMViewUserHeight 2
  public static Object $$$FldCOMViewUserHeight(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewUserHeight $$GetPropertyName^COMConst("COMViewUser",2)
  public static Object $$$StrCOMViewUserHeight(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUser",2));
  }

  //<< #define COMViewUserChooserWidth(%obj) $piece(%obj,"~",3)
  public static Object $$$COMViewUserChooserWidth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$COMViewUserChooserWidthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldCOMViewUserChooserWidth 3
  public static Object $$$FldCOMViewUserChooserWidth(mContext m$) {
    return (3);
  }

  //<< #define StrCOMViewUserChooserWidth $$GetPropertyName^COMConst("COMViewUser",3)
  public static Object $$$StrCOMViewUserChooserWidth(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUser",3));
  }

  //<< #define COMViewUserDialogHeight(%obj) $piece(%obj,"~",4)
  public static Object $$$COMViewUserDialogHeight(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$COMViewUserDialogHeightSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldCOMViewUserDialogHeight 4
  public static Object $$$FldCOMViewUserDialogHeight(mContext m$) {
    return (4);
  }

  //<< #define StrCOMViewUserDialogHeight $$GetPropertyName^COMConst("COMViewUser",4)
  public static Object $$$StrCOMViewUserDialogHeight(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUser",4));
  }

  //<< #define COMViewUserDialogWidth(%obj) $piece(%obj,"~",5)
  public static Object $$$COMViewUserDialogWidth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$COMViewUserDialogWidthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldCOMViewUserDialogWidth 5
  public static Object $$$FldCOMViewUserDialogWidth(mContext m$) {
    return (5);
  }

  //<< #define StrCOMViewUserDialogWidth $$GetPropertyName^COMConst("COMViewUser",5)
  public static Object $$$StrCOMViewUserDialogWidth(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUser",5));
  }

  //<< #define COMViewUserDialogTop(%obj) $piece(%obj,"~",6)
  public static Object $$$COMViewUserDialogTop(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$COMViewUserDialogTopSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldCOMViewUserDialogTop 6
  public static Object $$$FldCOMViewUserDialogTop(mContext m$) {
    return (6);
  }

  //<< #define StrCOMViewUserDialogTop $$GetPropertyName^COMConst("COMViewUser",6)
  public static Object $$$StrCOMViewUserDialogTop(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUser",6));
  }

  //<< #define COMViewUserDialogLeft(%obj) $piece(%obj,"~",7)
  public static Object $$$COMViewUserDialogLeft(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$COMViewUserDialogLeftSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldCOMViewUserDialogLeft 7
  public static Object $$$FldCOMViewUserDialogLeft(mContext m$) {
    return (7);
  }

  //<< #define StrCOMViewUserDialogLeft $$GetPropertyName^COMConst("COMViewUser",7)
  public static Object $$$StrCOMViewUserDialogLeft(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUser",7));
  }

  //<< #define FldCOMViewUserClass 1
  public static Object $$$FldCOMViewUserClass(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewUserClass $$GetPropertyName^COMConst("COMViewUser",,1)
  public static Object $$$StrCOMViewUserClass(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUser",null,1));
  }

  //<< #define FldCOMViewUserUser1 2
  public static Object $$$FldCOMViewUserUser1(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewUserUser1 $$GetPropertyName^COMConst("COMViewUser",,2)
  public static Object $$$StrCOMViewUserUser1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUser",null,2));
  }

  //<< 
  //<< #define COMViewUserSizeDialogWidth(%obj) $piece(%obj,"~",1)
  public static Object $$$COMViewUserSizeDialogWidth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$COMViewUserSizeDialogWidthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldCOMViewUserSizeDialogWidth 1
  public static Object $$$FldCOMViewUserSizeDialogWidth(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewUserSizeDialogWidth $$GetPropertyName^COMConst("COMViewUserSize",1)
  public static Object $$$StrCOMViewUserSizeDialogWidth(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUserSize",1));
  }

  //<< #define COMViewUserSizeDialogHeight(%obj) $piece(%obj,"~",2)
  public static Object $$$COMViewUserSizeDialogHeight(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$COMViewUserSizeDialogHeightSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldCOMViewUserSizeDialogHeight 2
  public static Object $$$FldCOMViewUserSizeDialogHeight(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewUserSizeDialogHeight $$GetPropertyName^COMConst("COMViewUserSize",2)
  public static Object $$$StrCOMViewUserSizeDialogHeight(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUserSize",2));
  }

  //<< #define FldCOMViewUserSizeUser1 1
  public static Object $$$FldCOMViewUserSizeUser1(mContext m$) {
    return (1);
  }

  //<< #define StrCOMViewUserSizeUser1 $$GetPropertyName^COMConst("COMViewUserSize",,1)
  public static Object $$$StrCOMViewUserSizeUser1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUserSize",null,1));
  }

  //<< #define FldCOMViewUserSizeFormField 2
  public static Object $$$FldCOMViewUserSizeFormField(mContext m$) {
    return (2);
  }

  //<< #define StrCOMViewUserSizeFormField $$GetPropertyName^COMConst("COMViewUserSize",,2)
  public static Object $$$StrCOMViewUserSizeFormField(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","COMViewUserSize",null,2));
  }

  //<< 
  //<< #define EnumCOMAPPLICATIONLISTnetManager "@net_Manager"
  public static Object $$$EnumCOMAPPLICATIONLISTnetManager(mContext m$) {
    return ("@net_Manager");
  }

  //<< #define EnumCOMAPPLICATIONLISTnetManagerCustomizingTool "@net_Manager_Customizing_Tool"
  public static Object $$$EnumCOMAPPLICATIONLISTnetManagerCustomizingTool(mContext m$) {
    return ("@net_Manager_Customizing_Tool");
  }

  //<< #define EnumCOMAPPLICATIONLISTAdvancedProcurement "Advanced_Procurement"
  public static Object $$$EnumCOMAPPLICATIONLISTAdvancedProcurement(mContext m$) {
    return ("Advanced_Procurement");
  }

  //<< #define EnumCOMAPPLICATIONLISTAlphaLinc "AlphaLinc"
  public static Object $$$EnumCOMAPPLICATIONLISTAlphaLinc(mContext m$) {
    return ("AlphaLinc");
  }

  //<< #define EnumCOMAPPLICATIONLISTApplicationManager "Application_Manager"
  public static Object $$$EnumCOMAPPLICATIONLISTApplicationManager(mContext m$) {
    return ("Application_Manager");
  }

  //<< #define EnumCOMAPPLICATIONLISTCost "Cost"
  public static Object $$$EnumCOMAPPLICATIONLISTCost(mContext m$) {
    return ("Cost");
  }

  //<< #define EnumCOMAPPLICATIONLISTCustomisationTRAK "Customisation_TRAK"
  public static Object $$$EnumCOMAPPLICATIONLISTCustomisationTRAK(mContext m$) {
    return ("Customisation_TRAK");
  }

  //<< #define EnumCOMAPPLICATIONLISTDemo "Demo"
  public static Object $$$EnumCOMAPPLICATIONLISTDemo(mContext m$) {
    return ("Demo");
  }

  //<< #define EnumCOMAPPLICATIONLISTFinance "Finance"
  public static Object $$$EnumCOMAPPLICATIONLISTFinance(mContext m$) {
    return ("Finance");
  }

  //<< #define EnumCOMAPPLICATIONLISTOptionalCoreCode "Optional_Core_Code"
  public static Object $$$EnumCOMAPPLICATIONLISTOptionalCoreCode(mContext m$) {
    return ("Optional_Core_Code");
  }

  //<< #define EnumCOMAPPLICATIONLISTReports "Reports"
  public static Object $$$EnumCOMAPPLICATIONLISTReports(mContext m$) {
    return ("Reports");
  }

  //<< #define EnumCOMAPPLICATIONLISTSale "Sale"
  public static Object $$$EnumCOMAPPLICATIONLISTSale(mContext m$) {
    return ("Sale");
  }

  //<< #define EnumCOMAPPLICATIONLISTStockControl "Stock_Control"
  public static Object $$$EnumCOMAPPLICATIONLISTStockControl(mContext m$) {
    return ("Stock_Control");
  }

  //<< #define EnumCOMAPPLICATIONLISTSystem "System"
  public static Object $$$EnumCOMAPPLICATIONLISTSystem(mContext m$) {
    return ("System");
  }

  //<< #define EnumCOMAPPLICATIONLISTTest "Test"
  public static Object $$$EnumCOMAPPLICATIONLISTTest(mContext m$) {
    return ("Test");
  }

  //<< #define EnumCOMAPPLICATIONLISTTimeManager "Time_Manager"
  public static Object $$$EnumCOMAPPLICATIONLISTTimeManager(mContext m$) {
    return ("Time_Manager");
  }

  //<< #define EnumCOMAPPLICATIONLISTTools "Tools"
  public static Object $$$EnumCOMAPPLICATIONLISTTools(mContext m$) {
    return ("Tools");
  }

  //<< #define EnumCOMAPPLICATIONLISTUnitTestCases "Unit Test Cases"
  public static Object $$$EnumCOMAPPLICATIONLISTUnitTestCases(mContext m$) {
    return ("Unit Test Cases");
  }

  //<< #define EnumCOMAPPLICATIONLISTAlphaLincV2 "al"
  public static Object $$$EnumCOMAPPLICATIONLISTAlphaLincV2(mContext m$) {
    return ("al");
  }

  //<< #define EnumCOMCLEARNoData "0"
  public static Object $$$EnumCOMCLEARNoData(mContext m$) {
    return ("0");
  }

  //<< #define EnumCOMCLEARTransactionalData "1"
  public static Object $$$EnumCOMCLEARTransactionalData(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMCLEARCustomerData "2"
  public static Object $$$EnumCOMCLEARCustomerData(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMCLEARSetupData "3"
  public static Object $$$EnumCOMCLEARSetupData(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMCLEARDonotremove "10"
  public static Object $$$EnumCOMCLEARDonotremove(mContext m$) {
    return ("10");
  }

  //<< #define EnumCOMDAYSOFMONTH1st "1"
  public static Object $$$EnumCOMDAYSOFMONTH1st(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMDAYSOFMONTH2nd "2"
  public static Object $$$EnumCOMDAYSOFMONTH2nd(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMDAYSOFMONTH3rd "3"
  public static Object $$$EnumCOMDAYSOFMONTH3rd(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMDAYSOFMONTH4th "4"
  public static Object $$$EnumCOMDAYSOFMONTH4th(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMDAYSOFMONTH5th "5"
  public static Object $$$EnumCOMDAYSOFMONTH5th(mContext m$) {
    return ("5");
  }

  //<< #define EnumCOMDAYSOFMONTH6th "6"
  public static Object $$$EnumCOMDAYSOFMONTH6th(mContext m$) {
    return ("6");
  }

  //<< #define EnumCOMDAYSOFMONTH7th "7"
  public static Object $$$EnumCOMDAYSOFMONTH7th(mContext m$) {
    return ("7");
  }

  //<< #define EnumCOMDAYSOFMONTH8th "8"
  public static Object $$$EnumCOMDAYSOFMONTH8th(mContext m$) {
    return ("8");
  }

  //<< #define EnumCOMDAYSOFMONTH9th "9"
  public static Object $$$EnumCOMDAYSOFMONTH9th(mContext m$) {
    return ("9");
  }

  //<< #define EnumCOMDAYSOFMONTH10th "10"
  public static Object $$$EnumCOMDAYSOFMONTH10th(mContext m$) {
    return ("10");
  }

  //<< #define EnumCOMDAYSOFMONTH11th "11"
  public static Object $$$EnumCOMDAYSOFMONTH11th(mContext m$) {
    return ("11");
  }

  //<< #define EnumCOMDAYSOFMONTH12th "12"
  public static Object $$$EnumCOMDAYSOFMONTH12th(mContext m$) {
    return ("12");
  }

  //<< #define EnumCOMDAYSOFMONTH13th "13"
  public static Object $$$EnumCOMDAYSOFMONTH13th(mContext m$) {
    return ("13");
  }

  //<< #define EnumCOMDAYSOFMONTH14th "14"
  public static Object $$$EnumCOMDAYSOFMONTH14th(mContext m$) {
    return ("14");
  }

  //<< #define EnumCOMDAYSOFMONTH15th "15"
  public static Object $$$EnumCOMDAYSOFMONTH15th(mContext m$) {
    return ("15");
  }

  //<< #define EnumCOMDAYSOFMONTH16th "16"
  public static Object $$$EnumCOMDAYSOFMONTH16th(mContext m$) {
    return ("16");
  }

  //<< #define EnumCOMDAYSOFMONTH17th "17"
  public static Object $$$EnumCOMDAYSOFMONTH17th(mContext m$) {
    return ("17");
  }

  //<< #define EnumCOMDAYSOFMONTH18th "18"
  public static Object $$$EnumCOMDAYSOFMONTH18th(mContext m$) {
    return ("18");
  }

  //<< #define EnumCOMDAYSOFMONTH19th "19"
  public static Object $$$EnumCOMDAYSOFMONTH19th(mContext m$) {
    return ("19");
  }

  //<< #define EnumCOMDAYSOFMONTH20th "20"
  public static Object $$$EnumCOMDAYSOFMONTH20th(mContext m$) {
    return ("20");
  }

  //<< #define EnumCOMDAYSOFMONTH21st "21"
  public static Object $$$EnumCOMDAYSOFMONTH21st(mContext m$) {
    return ("21");
  }

  //<< #define EnumCOMDAYSOFMONTH22nd "22"
  public static Object $$$EnumCOMDAYSOFMONTH22nd(mContext m$) {
    return ("22");
  }

  //<< #define EnumCOMDAYSOFMONTH23rd "23"
  public static Object $$$EnumCOMDAYSOFMONTH23rd(mContext m$) {
    return ("23");
  }

  //<< #define EnumCOMDAYSOFMONTH24th "24"
  public static Object $$$EnumCOMDAYSOFMONTH24th(mContext m$) {
    return ("24");
  }

  //<< #define EnumCOMDAYSOFMONTH25th "25"
  public static Object $$$EnumCOMDAYSOFMONTH25th(mContext m$) {
    return ("25");
  }

  //<< #define EnumCOMDAYSOFMONTH26th "26"
  public static Object $$$EnumCOMDAYSOFMONTH26th(mContext m$) {
    return ("26");
  }

  //<< #define EnumCOMDAYSOFMONTH27th "27"
  public static Object $$$EnumCOMDAYSOFMONTH27th(mContext m$) {
    return ("27");
  }

  //<< #define EnumCOMDAYSOFMONTH28th "28"
  public static Object $$$EnumCOMDAYSOFMONTH28th(mContext m$) {
    return ("28");
  }

  //<< #define EnumCOMDAYSOFMONTH29th "29"
  public static Object $$$EnumCOMDAYSOFMONTH29th(mContext m$) {
    return ("29");
  }

  //<< #define EnumCOMDAYSOFMONTH30th "30"
  public static Object $$$EnumCOMDAYSOFMONTH30th(mContext m$) {
    return ("30");
  }

  //<< #define EnumCOMDAYSOFMONTH31st "31"
  public static Object $$$EnumCOMDAYSOFMONTH31st(mContext m$) {
    return ("31");
  }

  //<< #define EnumCOMDAYSOFMONTHEndofmonth "32"
  public static Object $$$EnumCOMDAYSOFMONTHEndofmonth(mContext m$) {
    return ("32");
  }

  //<< #define EnumCOMDAYSOFWEEKMonday "1"
  public static Object $$$EnumCOMDAYSOFWEEKMonday(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMDAYSOFWEEKTuesday "2"
  public static Object $$$EnumCOMDAYSOFWEEKTuesday(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMDAYSOFWEEKWednesday "3"
  public static Object $$$EnumCOMDAYSOFWEEKWednesday(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMDAYSOFWEEKThursday "4"
  public static Object $$$EnumCOMDAYSOFWEEKThursday(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMDAYSOFWEEKFriday "5"
  public static Object $$$EnumCOMDAYSOFWEEKFriday(mContext m$) {
    return ("5");
  }

  //<< #define EnumCOMDAYSOFWEEKSaturday "6"
  public static Object $$$EnumCOMDAYSOFWEEKSaturday(mContext m$) {
    return ("6");
  }

  //<< #define EnumCOMDAYSOFWEEKSunday "7"
  public static Object $$$EnumCOMDAYSOFWEEKSunday(mContext m$) {
    return ("7");
  }

  //<< #define EnumCOMDAYSOFWEEKSHORTMo "1"
  public static Object $$$EnumCOMDAYSOFWEEKSHORTMo(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMDAYSOFWEEKSHORTTu "2"
  public static Object $$$EnumCOMDAYSOFWEEKSHORTTu(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMDAYSOFWEEKSHORTWe "3"
  public static Object $$$EnumCOMDAYSOFWEEKSHORTWe(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMDAYSOFWEEKSHORTTh "4"
  public static Object $$$EnumCOMDAYSOFWEEKSHORTTh(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMDAYSOFWEEKSHORTFr "5"
  public static Object $$$EnumCOMDAYSOFWEEKSHORTFr(mContext m$) {
    return ("5");
  }

  //<< #define EnumCOMDAYSOFWEEKSHORTSa "6"
  public static Object $$$EnumCOMDAYSOFWEEKSHORTSa(mContext m$) {
    return ("6");
  }

  //<< #define EnumCOMDAYSOFWEEKSHORTSu "7"
  public static Object $$$EnumCOMDAYSOFWEEKSHORTSu(mContext m$) {
    return ("7");
  }

  //<< #define EnumCOMDCMCLASSDISTTYPELocalDataOnly "-1"
  public static Object $$$EnumCOMDCMCLASSDISTTYPELocalDataOnly(mContext m$) {
    return ("-1");
  }

  //<< #define EnumCOMDCMCLASSDISTTYPELocalDataDefinitionOnly "0"
  public static Object $$$EnumCOMDCMCLASSDISTTYPELocalDataDefinitionOnly(mContext m$) {
    return ("0");
  }

  //<< #define EnumCOMDCMCLASSDISTTYPEDistributedbyBuildCustomCode "1"
  public static Object $$$EnumCOMDCMCLASSDISTTYPEDistributedbyBuildCustomCode(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMDCMCLASSDISTTYPEDistributedbyBuildSubscript "2"
  public static Object $$$EnumCOMDCMCLASSDISTTYPEDistributedbyBuildSubscript(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMDCMCLASSDISTTYPEExternalDataLoad "3"
  public static Object $$$EnumCOMDCMCLASSDISTTYPEExternalDataLoad(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMDCMDATASOURCETYPEClass "Class"
  public static Object $$$EnumCOMDCMDATASOURCETYPEClass(mContext m$) {
    return ("Class");
  }

  //<< #define EnumCOMDCMDATASOURCETYPEGlobal "Global"
  public static Object $$$EnumCOMDCMDATASOURCETYPEGlobal(mContext m$) {
    return ("Global");
  }

  //<< #define EnumCOMDCMEVENTTYPEDelete "Delete"
  public static Object $$$EnumCOMDCMEVENTTYPEDelete(mContext m$) {
    return ("Delete");
  }

  //<< #define EnumCOMDCMEVENTTYPEOther "Other"
  public static Object $$$EnumCOMDCMEVENTTYPEOther(mContext m$) {
    return ("Other");
  }

  //<< #define EnumCOMDCMEVENTTYPESave "Save"
  public static Object $$$EnumCOMDCMEVENTTYPESave(mContext m$) {
    return ("Save");
  }

  //<< #define EnumCOMDCMPROCSTATUSError "0"
  public static Object $$$EnumCOMDCMPROCSTATUSError(mContext m$) {
    return ("0");
  }

  //<< #define EnumCOMDCMPROCSTATUSProcessed "1"
  public static Object $$$EnumCOMDCMPROCSTATUSProcessed(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMDCMPROCSTATUSSkipped "2"
  public static Object $$$EnumCOMDCMPROCSTATUSSkipped(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMDCMPROCSTATUSBlocked "3"
  public static Object $$$EnumCOMDCMPROCSTATUSBlocked(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMDCMRELATEDMODULECosts "Cost"
  public static Object $$$EnumCOMDCMRELATEDMODULECosts(mContext m$) {
    return ("Cost");
  }

  //<< #define EnumCOMDCMRELATEDMODULECustomers "Customer"
  public static Object $$$EnumCOMDCMRELATEDMODULECustomers(mContext m$) {
    return ("Customer");
  }

  //<< #define EnumCOMDCMRELATEDMODULEFinance "Finance"
  public static Object $$$EnumCOMDCMRELATEDMODULEFinance(mContext m$) {
    return ("Finance");
  }

  //<< #define EnumCOMDCMRELATEDMODULEMiscellanous "Misc"
  public static Object $$$EnumCOMDCMRELATEDMODULEMiscellanous(mContext m$) {
    return ("Misc");
  }

  //<< #define EnumCOMDCMRELATEDMODULEOffers "Offer"
  public static Object $$$EnumCOMDCMRELATEDMODULEOffers(mContext m$) {
    return ("Offer");
  }

  //<< #define EnumCOMDCMRELATEDMODULEOrders "Order"
  public static Object $$$EnumCOMDCMRELATEDMODULEOrders(mContext m$) {
    return ("Order");
  }

  //<< #define EnumCOMDCMRELATEDMODULEPricing "Price"
  public static Object $$$EnumCOMDCMRELATEDMODULEPricing(mContext m$) {
    return ("Price");
  }

  //<< #define EnumCOMDCMRELATEDMODULEProducts "Product"
  public static Object $$$EnumCOMDCMRELATEDMODULEProducts(mContext m$) {
    return ("Product");
  }

  //<< #define EnumCOMDCMRELATEDMODULESuppliers "Supplier"
  public static Object $$$EnumCOMDCMRELATEDMODULESuppliers(mContext m$) {
    return ("Supplier");
  }

  //<< #define EnumCOMDCMTARGETFunction "Function"
  public static Object $$$EnumCOMDCMTARGETFunction(mContext m$) {
    return ("Function");
  }

  //<< #define EnumCOMDCMTARGETHub "Hub"
  public static Object $$$EnumCOMDCMTARGETHub(mContext m$) {
    return ("Hub");
  }

  //<< #define EnumCOMDCMTARGETSelf "Self"
  public static Object $$$EnumCOMDCMTARGETSelf(mContext m$) {
    return ("Self");
  }

  //<< #define EnumCOMDCMTARGETSpokes "Spokes"
  public static Object $$$EnumCOMDCMTARGETSpokes(mContext m$) {
    return ("Spokes");
  }

  //<< #define EnumCOMDCMTRANSPORTMETHODWSDLBasedWebServices "SOAP"
  public static Object $$$EnumCOMDCMTRANSPORTMETHODWSDLBasedWebServices(mContext m$) {
    return ("SOAP");
  }

  //<< #define EnumCOMDCMTRANSPORTMETHODWebServiceCollection "WSC"
  public static Object $$$EnumCOMDCMTRANSPORTMETHODWebServiceCollection(mContext m$) {
    return ("WSC");
  }

  //<< #define EnumCOMDCMTRANSPORTMETHODDTDBasedSimpleRPC "XML"
  public static Object $$$EnumCOMDCMTRANSPORTMETHODDTDBasedSimpleRPC(mContext m$) {
    return ("XML");
  }

  //<< #define EnumCOMDELIMITERDoubleQuote "34"
  public static Object $$$EnumCOMDELIMITERDoubleQuote(mContext m$) {
    return ("34");
  }

  //<< #define EnumCOMDELIMITERHash "35"
  public static Object $$$EnumCOMDELIMITERHash(mContext m$) {
    return ("35");
  }

  //<< #define EnumCOMDELIMITERSingleQuote "39"
  public static Object $$$EnumCOMDELIMITERSingleQuote(mContext m$) {
    return ("39");
  }

  //<< #define EnumCOMDELIMITERStar "42"
  public static Object $$$EnumCOMDELIMITERStar(mContext m$) {
    return ("42");
  }

  //<< #define EnumCOMDELIMITERPlus "43"
  public static Object $$$EnumCOMDELIMITERPlus(mContext m$) {
    return ("43");
  }

  //<< #define EnumCOMDELIMITERComma "44"
  public static Object $$$EnumCOMDELIMITERComma(mContext m$) {
    return ("44");
  }

  //<< #define EnumCOMDELIMITERDash "45"
  public static Object $$$EnumCOMDELIMITERDash(mContext m$) {
    return ("45");
  }

  //<< #define EnumCOMDELIMITERFullStop "46"
  public static Object $$$EnumCOMDELIMITERFullStop(mContext m$) {
    return ("46");
  }

  //<< #define EnumCOMDELIMITERForwardSlash "47"
  public static Object $$$EnumCOMDELIMITERForwardSlash(mContext m$) {
    return ("47");
  }

  //<< #define EnumCOMDELIMITERColon "58"
  public static Object $$$EnumCOMDELIMITERColon(mContext m$) {
    return ("58");
  }

  //<< #define EnumCOMDELIMITERSemiColon "59"
  public static Object $$$EnumCOMDELIMITERSemiColon(mContext m$) {
    return ("59");
  }

  //<< #define EnumCOMDELIMITERBackSlash "92"
  public static Object $$$EnumCOMDELIMITERBackSlash(mContext m$) {
    return ("92");
  }

  //<< #define EnumCOMDELIMITERCaret "94"
  public static Object $$$EnumCOMDELIMITERCaret(mContext m$) {
    return ("94");
  }

  //<< #define EnumCOMDELIMITERUnderScore "95"
  public static Object $$$EnumCOMDELIMITERUnderScore(mContext m$) {
    return ("95");
  }

  //<< #define EnumCOMDELIMITERBackQuote "96"
  public static Object $$$EnumCOMDELIMITERBackQuote(mContext m$) {
    return ("96");
  }

  //<< #define EnumCOMDELIMITERPipe "124"
  public static Object $$$EnumCOMDELIMITERPipe(mContext m$) {
    return ("124");
  }

  //<< #define EnumCOMDELIMITERTilde "126"
  public static Object $$$EnumCOMDELIMITERTilde(mContext m$) {
    return ("126");
  }

  //<< #define EnumCOMDOCUMENTOUTPUTPrinter "2"
  public static Object $$$EnumCOMDOCUMENTOUTPUTPrinter(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMDOCUMENTOUTPUTEmail "3"
  public static Object $$$EnumCOMDOCUMENTOUTPUTEmail(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMEDITORFCKeditor "FCKeditor"
  public static Object $$$EnumCOMEDITORFCKeditor(mContext m$) {
    return ("FCKeditor");
  }

  //<< #define EnumCOMFCKEDITORSKINDefault "default"
  public static Object $$$EnumCOMFCKEDITORSKINDefault(mContext m$) {
    return ("default");
  }

  //<< #define EnumCOMFCKEDITORSKINOffice2003 "office2003"
  public static Object $$$EnumCOMFCKEDITORSKINOffice2003(mContext m$) {
    return ("office2003");
  }

  //<< #define EnumCOMFCKEDITORSKINbueno "silver"
  public static Object $$$EnumCOMFCKEDITORSKINbueno(mContext m$) {
    return ("silver");
  }

  //<< #define EnumCOMFCKEDITORTOOLBARDefault "Default"
  public static Object $$$EnumCOMFCKEDITORTOOLBARDefault(mContext m$) {
    return ("Default");
  }

  //<< #define EnumCOMFCKEDITORTOOLBARDisclinc "Disclinc"
  public static Object $$$EnumCOMFCKEDITORTOOLBARDisclinc(mContext m$) {
    return ("Disclinc");
  }

  //<< #define EnumCOMFILETYPEVBScript "1"
  public static Object $$$EnumCOMFILETYPEVBScript(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMFILETYPEJavaScript "2"
  public static Object $$$EnumCOMFILETYPEJavaScript(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMFILETYPEStyleSheet "3"
  public static Object $$$EnumCOMFILETYPEStyleSheet(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMFORMMODULESSystem "COM"
  public static Object $$$EnumCOMFORMMODULESSystem(mContext m$) {
    return ("COM");
  }

  //<< #define EnumCOMFORMMODULESCost "CST"
  public static Object $$$EnumCOMFORMMODULESCost(mContext m$) {
    return ("CST");
  }

  //<< #define EnumCOMFORMMODULESFinance "FIN"
  public static Object $$$EnumCOMFORMMODULESFinance(mContext m$) {
    return ("FIN");
  }

  //<< #define EnumCOMFORMMODULESAlphaLinc "IN"
  public static Object $$$EnumCOMFORMMODULESAlphaLinc(mContext m$) {
    return ("IN");
  }

  //<< #define EnumCOMFORMMODULESReports "REP"
  public static Object $$$EnumCOMFORMMODULESReports(mContext m$) {
    return ("REP");
  }

  //<< #define EnumCOMFORMMODULESSale "SAL"
  public static Object $$$EnumCOMFORMMODULESSale(mContext m$) {
    return ("SAL");
  }

  //<< #define EnumCOMFORMMODULESStockControl "STK"
  public static Object $$$EnumCOMFORMMODULESStockControl(mContext m$) {
    return ("STK");
  }

  //<< #define EnumCOMFORMMODULESTimeManager "TER"
  public static Object $$$EnumCOMFORMMODULESTimeManager(mContext m$) {
    return ("TER");
  }

  //<< #define EnumCOMFORMMODULESnetManager "WWW"
  public static Object $$$EnumCOMFORMMODULESnetManager(mContext m$) {
    return ("WWW");
  }

  //<< #define EnumCOMHCRESULTSTATUSError "0"
  public static Object $$$EnumCOMHCRESULTSTATUSError(mContext m$) {
    return ("0");
  }

  //<< #define EnumCOMHCRESULTSTATUSWaitingforCompare "1"
  public static Object $$$EnumCOMHCRESULTSTATUSWaitingforCompare(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMHCRESULTSTATUSOK "2"
  public static Object $$$EnumCOMHCRESULTSTATUSOK(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMHCRESULTTYPEAgeneralpurposestandalonecheck "COMRelationalCheck"
  public static Object $$$EnumCOMHCRESULTTYPEAgeneralpurposestandalonecheck(mContext m$) {
    return ("COMRelationalCheck");
  }

  //<< #define EnumCOMHCRESULTTYPEATopLevelTaxLocationmusthaveaGLAccount "COMTaxLocationAccount"
  public static Object $$$EnumCOMHCRESULTTYPEATopLevelTaxLocationmusthaveaGLAccount(mContext m$) {
    return ("COMTaxLocationAccount");
  }

  //<< #define EnumCOMHCRESULTTYPECustomerBalance "CustBal"
  public static Object $$$EnumCOMHCRESULTTYPECustomerBalance(mContext m$) {
    return ("CustBal");
  }

  //<< #define EnumCOMHCRESULTTYPECustomerMasterfile "CustMF"
  public static Object $$$EnumCOMHCRESULTTYPECustomerMasterfile(mContext m$) {
    return ("CustMF");
  }

  //<< #define EnumCOMHCRESULTTYPEFinanceAPAdjustmentsmustupdateaPostedInterfaceBatch "FINAPAdjustmentsToBatch"
  public static Object $$$EnumCOMHCRESULTTYPEFinanceAPAdjustmentsmustupdateaPostedInterfaceBatch(mContext m$) {
    return ("FINAPAdjustmentsToBatch");
  }

  //<< #define EnumCOMHCRESULTTYPEAPTypeBatchLinesmusthavevalidParamSourceandRef "FINAPBatchLineDetails"
  public static Object $$$EnumCOMHCRESULTTYPEAPTypeBatchLinesmusthavevalidParamSourceandRef(mContext m$) {
    return ("FINAPBatchLineDetails");
  }

  //<< #define EnumCOMHCRESULTTYPEAllAPPostedPaymentsmustupdatethechequeregister "FINAPChequeBook"
  public static Object $$$EnumCOMHCRESULTTYPEAllAPPostedPaymentsmustupdatethechequeregister(mContext m$) {
    return ("FINAPChequeBook");
  }

  //<< #define EnumCOMHCRESULTTYPEEachAPControlAccountmustequalthesumofitsSuppliers "FINAPControlAccount"
  public static Object $$$EnumCOMHCRESULTTYPEEachAPControlAccountmustequalthesumofitsSuppliers(mContext m$) {
    return ("FINAPControlAccount");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalEachAPControlAccountmustequalsumofSuppliers "FINAPControlAccount_I"
  public static Object $$$EnumCOMHCRESULTTYPEInternalEachAPControlAccountmustequalsumofSuppliers(mContext m$) {
    return ("FINAPControlAccount_I");
  }

  //<< #define EnumCOMHCRESULTTYPECompareFinanceAPInvBalancemustequalInvTrans "FINAPInvoiceTotal_C"
  public static Object $$$EnumCOMHCRESULTTYPECompareFinanceAPInvBalancemustequalInvTrans(mContext m$) {
    return ("FINAPInvoiceTotal_C");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceAPInvBalancemustequalInvTrans "FINAPInvoiceTotal_I"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceAPInvBalancemustequalInvTrans(mContext m$) {
    return ("FINAPInvoiceTotal_I");
  }

  //<< #define EnumCOMHCRESULTTYPECompareFinanceAPBatchLinesmustcreateanInvoiceTrans "FINAPInvoiceTransaction_C"
  public static Object $$$EnumCOMHCRESULTTYPECompareFinanceAPBatchLinesmustcreateanInvoiceTrans(mContext m$) {
    return ("FINAPInvoiceTransaction_C");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceAPBatchLinesmustcreateanInvoiceTrans "FINAPInvoiceTransactions_I"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceAPBatchLinesmustcreateanInvoiceTrans(mContext m$) {
    return ("FINAPInvoiceTransactions_I");
  }

  //<< #define EnumCOMHCRESULTTYPEAPPostedpaymentsmustupdateanInterfaceBatch "FINAPPayments"
  public static Object $$$EnumCOMHCRESULTTYPEAPPostedpaymentsmustupdateanInterfaceBatch(mContext m$) {
    return ("FINAPPayments");
  }

  //<< #define EnumCOMHCRESULTTYPEFinanceARAdjustmentsmustupdateaPostedInterfaceBatch "FINARAdjustmentsToBatch"
  public static Object $$$EnumCOMHCRESULTTYPEFinanceARAdjustmentsmustupdateaPostedInterfaceBatch(mContext m$) {
    return ("FINARAdjustmentsToBatch");
  }

  //<< #define EnumCOMHCRESULTTYPEARTypeBatchLinesmusthavevalidParamSourceandRef "FINARBatchLineDetails"
  public static Object $$$EnumCOMHCRESULTTYPEARTypeBatchLinesmusthavevalidParamSourceandRef(mContext m$) {
    return ("FINARBatchLineDetails");
  }

  //<< #define EnumCOMHCRESULTTYPECompareFinanceARInvBalancemustequalInvTrans "FINARInvoiceTotal_C"
  public static Object $$$EnumCOMHCRESULTTYPECompareFinanceARInvBalancemustequalInvTrans(mContext m$) {
    return ("FINARInvoiceTotal_C");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceARInvBalancemustequalInvTrans "FINARInvoiceTotal_I"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceARInvBalancemustequalInvTrans(mContext m$) {
    return ("FINARInvoiceTotal_I");
  }

  //<< #define EnumCOMHCRESULTTYPECompareFinanceARBatchLinesmustcreateanInvoiceTrans "FINARInvoiceTransaction_C"
  public static Object $$$EnumCOMHCRESULTTYPECompareFinanceARBatchLinesmustcreateanInvoiceTrans(mContext m$) {
    return ("FINARInvoiceTransaction_C");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceARBatchLinesmustcreateanInvoice "FINARInvoiceTransactions_I"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceARBatchLinesmustcreateanInvoice(mContext m$) {
    return ("FINARInvoiceTransactions_I");
  }

  //<< #define EnumCOMHCRESULTTYPEFinanceCustomerMasterfileDetail "FINCustMFD"
  public static Object $$$EnumCOMHCRESULTTYPEFinanceCustomerMasterfileDetail(mContext m$) {
    return ("FINCustMFD");
  }

  //<< #define EnumCOMHCRESULTTYPECompareFinanceGLAccountBalance "FINGLAccountBalance"
  public static Object $$$EnumCOMHCRESULTTYPECompareFinanceGLAccountBalance(mContext m$) {
    return ("FINGLAccountBalance");
  }

  //<< #define EnumCOMHCRESULTTYPECompareFinanceGLAccountPeriodTotal "FINGLAccountPeriodTotal_C"
  public static Object $$$EnumCOMHCRESULTTYPECompareFinanceGLAccountPeriodTotal(mContext m$) {
    return ("FINGLAccountPeriodTotal_C");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceGLAccountPeriodTotal "FINGLAccountPeriodTotal_I"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceGLAccountPeriodTotal(mContext m$) {
    return ("FINGLAccountPeriodTotal_I");
  }

  //<< #define EnumCOMHCRESULTTYPEPostedBankReconciliationsmustupdatePostedTransactions "FINGLBankReconciliation"
  public static Object $$$EnumCOMHCRESULTTYPEPostedBankReconciliationsmustupdatePostedTransactions(mContext m$) {
    return ("FINGLBankReconciliation");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceGLInterfaceBatch "FINGLInterfaceBatch"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceGLInterfaceBatch(mContext m$) {
    return ("FINGLInterfaceBatch");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceGLParentAccountBalance "FINGLParentAccountBalance"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceGLParentAccountBalance(mContext m$) {
    return ("FINGLParentAccountBalance");
  }

  //<< #define EnumCOMHCRESULTTYPECompareFinanceGLPeriodTotalsmustequalsumofTrans "FINGLPeriodTotal_C"
  public static Object $$$EnumCOMHCRESULTTYPECompareFinanceGLPeriodTotalsmustequalsumofTrans(mContext m$) {
    return ("FINGLPeriodTotal_C");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceGLPeriodTotalsmustequalsumofTrans "FINGLPeriodTotal_I"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceGLPeriodTotalsmustequalsumofTrans(mContext m$) {
    return ("FINGLPeriodTotal_I");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceGLTopAccount "FINGLTop"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceGLTopAccount(mContext m$) {
    return ("FINGLTop");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceGLTransactionAccount "FINGLTransactionAccount"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceGLTransactionAccount(mContext m$) {
    return ("FINGLTransactionAccount");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceGLTransactionAccountBalance "FINGLTransactionAccountBalance"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceGLTransactionAccountBalance(mContext m$) {
    return ("FINGLTransactionAccountBalance");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceGLTree "FINGLTree"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceGLTree(mContext m$) {
    return ("FINGLTree");
  }

  //<< #define EnumCOMHCRESULTTYPECheckRelationshipbetweenFININTBatchandFININTBatchLine "FININTBatch"
  public static Object $$$EnumCOMHCRESULTTYPECheckRelationshipbetweenFININTBatchandFININTBatchLine(mContext m$) {
    return ("FININTBatch");
  }

  //<< #define EnumCOMHCRESULTTYPETheSumofeachInterfaceBlockmustequal0 "FININTBatchBlock"
  public static Object $$$EnumCOMHCRESULTTYPETheSumofeachInterfaceBlockmustequal0(mContext m$) {
    return ("FININTBatchBlock");
  }

  //<< #define EnumCOMHCRESULTTYPEThesumofPostedLedgerInterfaceBatchLinesmustbezero "FININTBatchLine"
  public static Object $$$EnumCOMHCRESULTTYPEThesumofPostedLedgerInterfaceBatchLinesmustbezero(mContext m$) {
    return ("FININTBatchLine");
  }

  //<< #define EnumCOMHCRESULTTYPEInternalFinanceINTBatchLinesmustpointtoTransAcc "FININTBatchLineTransactionAcc"
  public static Object $$$EnumCOMHCRESULTTYPEInternalFinanceINTBatchLinesmustpointtoTransAcc(mContext m$) {
    return ("FININTBatchLineTransactionAcc");
  }

  //<< #define EnumCOMHCRESULTTYPEGLAccounts "MODAccount"
  public static Object $$$EnumCOMHCRESULTTYPEGLAccounts(mContext m$) {
    return ("MODAccount");
  }

  //<< #define EnumCOMHCRESULTTYPECreditEntityCustomers "MODCustomer"
  public static Object $$$EnumCOMHCRESULTTYPECreditEntityCustomers(mContext m$) {
    return ("MODCustomer");
  }

  //<< #define EnumCOMHCRESULTTYPESales "MODSale"
  public static Object $$$EnumCOMHCRESULTTYPESales(mContext m$) {
    return ("MODSale");
  }

  //<< #define EnumCOMHCRESULTTYPESupplierMasterfile "MODSupplier"
  public static Object $$$EnumCOMHCRESULTTYPESupplierMasterfile(mContext m$) {
    return ("MODSupplier");
  }

  //<< #define EnumCOMHCRESULTTYPESaleCustomerMasterfileDetail "SALCustMFD"
  public static Object $$$EnumCOMHCRESULTTYPESaleCustomerMasterfileDetail(mContext m$) {
    return ("SALCustMFD");
  }

  //<< #define EnumCOMLOCKLockOwnedBySomeoneelse "0"
  public static Object $$$EnumCOMLOCKLockOwnedBySomeoneelse(mContext m$) {
    return ("0");
  }

  //<< #define EnumCOMLOCKLockOwnedByMe "1"
  public static Object $$$EnumCOMLOCKLockOwnedByMe(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMLOCKLockSuccessful "2"
  public static Object $$$EnumCOMLOCKLockSuccessful(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMLOCKLockSyncFailureRecordExistsnoowner "3"
  public static Object $$$EnumCOMLOCKLockSyncFailureRecordExistsnoowner(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMLOCKLockSyncFailureUnabletoCreateLocksavefailed "4"
  public static Object $$$EnumCOMLOCKLockSyncFailureUnabletoCreateLocksavefailed(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMLOCKLockSyncFailureProcessSwapping "5"
  public static Object $$$EnumCOMLOCKLockSyncFailureProcessSwapping(mContext m$) {
    return ("5");
  }

  //<< #define EnumCOMLOCKLockFailedCacheError "6"
  public static Object $$$EnumCOMLOCKLockFailedCacheError(mContext m$) {
    return ("6");
  }

  //<< #define EnumCOMMODULESAEP "AEP"
  public static Object $$$EnumCOMMODULESAEP(mContext m$) {
    return ("AEP");
  }

  //<< #define EnumCOMMODULESCOM "COM"
  public static Object $$$EnumCOMMODULESCOM(mContext m$) {
    return ("COM");
  }

  //<< #define EnumCOMMODULESCST "CST"
  public static Object $$$EnumCOMMODULESCST(mContext m$) {
    return ("CST");
  }

  //<< #define EnumCOMMODULESFIN "FIN"
  public static Object $$$EnumCOMMODULESFIN(mContext m$) {
    return ("FIN");
  }

  //<< #define EnumCOMMODULESIN "IN"
  public static Object $$$EnumCOMMODULESIN(mContext m$) {
    return ("IN");
  }

  //<< #define EnumCOMMODULESOCC "OCC"
  public static Object $$$EnumCOMMODULESOCC(mContext m$) {
    return ("OCC");
  }

  //<< #define EnumCOMMODULESREP "REP"
  public static Object $$$EnumCOMMODULESREP(mContext m$) {
    return ("REP");
  }

  //<< #define EnumCOMMODULESSAL "SAL"
  public static Object $$$EnumCOMMODULESSAL(mContext m$) {
    return ("SAL");
  }

  //<< #define EnumCOMMODULESSTK "STK"
  public static Object $$$EnumCOMMODULESSTK(mContext m$) {
    return ("STK");
  }

  //<< #define EnumCOMMODULESTER "TER"
  public static Object $$$EnumCOMMODULESTER(mContext m$) {
    return ("TER");
  }

  //<< #define EnumCOMMODULESTS "TS"
  public static Object $$$EnumCOMMODULESTS(mContext m$) {
    return ("TS");
  }

  //<< #define EnumCOMMODULESUPG "UPG"
  public static Object $$$EnumCOMMODULESUPG(mContext m$) {
    return ("UPG");
  }

  //<< #define EnumCOMMODULESUnitTestCases "UTC"
  public static Object $$$EnumCOMMODULESUnitTestCases(mContext m$) {
    return ("UTC");
  }

  //<< #define EnumCOMMODULESVARTRK "VARTRK"
  public static Object $$$EnumCOMMODULESVARTRK(mContext m$) {
    return ("VARTRK");
  }

  //<< #define EnumCOMMODULESWWW "WWW"
  public static Object $$$EnumCOMMODULESWWW(mContext m$) {
    return ("WWW");
  }

  //<< #define EnumCOMMODULESAlphalincV2 "al"
  public static Object $$$EnumCOMMODULESAlphalincV2(mContext m$) {
    return ("al");
  }

  //<< #define EnumCOMMONTHSOFYEARJanuary "1"
  public static Object $$$EnumCOMMONTHSOFYEARJanuary(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMMONTHSOFYEARFebruary "2"
  public static Object $$$EnumCOMMONTHSOFYEARFebruary(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMMONTHSOFYEARMarch "3"
  public static Object $$$EnumCOMMONTHSOFYEARMarch(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMMONTHSOFYEARApril "4"
  public static Object $$$EnumCOMMONTHSOFYEARApril(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMMONTHSOFYEARMay "5"
  public static Object $$$EnumCOMMONTHSOFYEARMay(mContext m$) {
    return ("5");
  }

  //<< #define EnumCOMMONTHSOFYEARJune "6"
  public static Object $$$EnumCOMMONTHSOFYEARJune(mContext m$) {
    return ("6");
  }

  //<< #define EnumCOMMONTHSOFYEARJuly "7"
  public static Object $$$EnumCOMMONTHSOFYEARJuly(mContext m$) {
    return ("7");
  }

  //<< #define EnumCOMMONTHSOFYEARAugust "8"
  public static Object $$$EnumCOMMONTHSOFYEARAugust(mContext m$) {
    return ("8");
  }

  //<< #define EnumCOMMONTHSOFYEARSeptember "9"
  public static Object $$$EnumCOMMONTHSOFYEARSeptember(mContext m$) {
    return ("9");
  }

  //<< #define EnumCOMMONTHSOFYEAROctober "10"
  public static Object $$$EnumCOMMONTHSOFYEAROctober(mContext m$) {
    return ("10");
  }

  //<< #define EnumCOMMONTHSOFYEARNovember "11"
  public static Object $$$EnumCOMMONTHSOFYEARNovember(mContext m$) {
    return ("11");
  }

  //<< #define EnumCOMMONTHSOFYEARDecember "12"
  public static Object $$$EnumCOMMONTHSOFYEARDecember(mContext m$) {
    return ("12");
  }

  //<< #define EnumCOMMSGOKOnly "0"
  public static Object $$$EnumCOMMSGOKOnly(mContext m$) {
    return ("0");
  }

  //<< #define EnumCOMMSGOKCancel "1"
  public static Object $$$EnumCOMMSGOKCancel(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMMSGAbortRetryIgnore "2"
  public static Object $$$EnumCOMMSGAbortRetryIgnore(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMMSGYesNoCancel "3"
  public static Object $$$EnumCOMMSGYesNoCancel(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMMSGYesNo "4"
  public static Object $$$EnumCOMMSGYesNo(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMMSGRetryCancel "5"
  public static Object $$$EnumCOMMSGRetryCancel(mContext m$) {
    return ("5");
  }

  //<< #define EnumCOMMSGCritical "16"
  public static Object $$$EnumCOMMSGCritical(mContext m$) {
    return ("16");
  }

  //<< #define EnumCOMMSGQuestion "32"
  public static Object $$$EnumCOMMSGQuestion(mContext m$) {
    return ("32");
  }

  //<< #define EnumCOMMSGExclamation "48"
  public static Object $$$EnumCOMMSGExclamation(mContext m$) {
    return ("48");
  }

  //<< #define EnumCOMMSGInformation "64"
  public static Object $$$EnumCOMMSGInformation(mContext m$) {
    return ("64");
  }

  //<< #define EnumCOMMSGDefaultButton2 "256"
  public static Object $$$EnumCOMMSGDefaultButton2(mContext m$) {
    return ("256");
  }

  //<< #define EnumCOMMSGDefaultButton3 "512"
  public static Object $$$EnumCOMMSGDefaultButton3(mContext m$) {
    return ("512");
  }

  //<< #define EnumCOMMSGSystemModal "4096"
  public static Object $$$EnumCOMMSGSystemModal(mContext m$) {
    return ("4096");
  }

  //<< #define EnumCOMOUTPUTScreenPrinter "1"
  public static Object $$$EnumCOMOUTPUTScreenPrinter(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMOUTPUTPrinter "2"
  public static Object $$$EnumCOMOUTPUTPrinter(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMOUTPUTEmail "3"
  public static Object $$$EnumCOMOUTPUTEmail(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMOUTPUTFax "4"
  public static Object $$$EnumCOMOUTPUTFax(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMPATHTYPEFTPURL "1"
  public static Object $$$EnumCOMPATHTYPEFTPURL(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMQUARTER1stQuarter "1"
  public static Object $$$EnumCOMQUARTER1stQuarter(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMQUARTER2ndQuarter "2"
  public static Object $$$EnumCOMQUARTER2ndQuarter(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMQUARTER3rdQuarter "3"
  public static Object $$$EnumCOMQUARTER3rdQuarter(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMQUARTER4thQuarter "4"
  public static Object $$$EnumCOMQUARTER4thQuarter(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMSCHEDULETYPEJournal "1"
  public static Object $$$EnumCOMSCHEDULETYPEJournal(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMSCHEDULETYPEInterface "2"
  public static Object $$$EnumCOMSCHEDULETYPEInterface(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMSEARCHTYPEStandardNet "0"
  public static Object $$$EnumCOMSEARCHTYPEStandardNet(mContext m$) {
    return ("0");
  }

  //<< #define EnumCOMSEARCHTYPEPopDown "1"
  public static Object $$$EnumCOMSEARCHTYPEPopDown(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMSHEDULESTATUSRunning "1"
  public static Object $$$EnumCOMSHEDULESTATUSRunning(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMSHEDULESTATUSStopped "2"
  public static Object $$$EnumCOMSHEDULESTATUSStopped(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMSYSSTATUSNew "0"
  public static Object $$$EnumCOMSYSSTATUSNew(mContext m$) {
    return ("0");
  }

  //<< #define EnumCOMSYSSTATUSBuilding "1"
  public static Object $$$EnumCOMSYSSTATUSBuilding(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMSYSSTATUSProcessing "2"
  public static Object $$$EnumCOMSYSSTATUSProcessing(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMSYSSTATUSGenerating "3"
  public static Object $$$EnumCOMSYSSTATUSGenerating(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMSYSSTATUSGenerated "4"
  public static Object $$$EnumCOMSYSSTATUSGenerated(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMSYSSTATUSAwaitingReview "5"
  public static Object $$$EnumCOMSYSSTATUSAwaitingReview(mContext m$) {
    return ("5");
  }

  //<< #define EnumCOMSYSSTATUSApproved "6"
  public static Object $$$EnumCOMSYSSTATUSApproved(mContext m$) {
    return ("6");
  }

  //<< #define EnumCOMSYSSTATUSRejected "7"
  public static Object $$$EnumCOMSYSSTATUSRejected(mContext m$) {
    return ("7");
  }

  //<< #define EnumCOMSYSSTATUSUsed "8"
  public static Object $$$EnumCOMSYSSTATUSUsed(mContext m$) {
    return ("8");
  }

  //<< #define EnumCOMTAXPROVIDERVERATAX "Taxware"
  public static Object $$$EnumCOMTAXPROVIDERVERATAX(mContext m$) {
    return ("Taxware");
  }

  //<< #define EnumCOMTAXTYPESalesTaxState "1"
  public static Object $$$EnumCOMTAXTYPESalesTaxState(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMTAXTYPESalesTaxCity "2"
  public static Object $$$EnumCOMTAXTYPESalesTaxCity(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMTAXTYPESalesTaxCounty "3"
  public static Object $$$EnumCOMTAXTYPESalesTaxCounty(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMTAXTYPETransitTaxCity "4"
  public static Object $$$EnumCOMTAXTYPETransitTaxCity(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMTAXTYPETransitTaxCounty "5"
  public static Object $$$EnumCOMTAXTYPETransitTaxCounty(mContext m$) {
    return ("5");
  }

  //<< #define EnumCOMTIMEINCREMENTSeconds "1"
  public static Object $$$EnumCOMTIMEINCREMENTSeconds(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMTIMEINCREMENTMinutes "2"
  public static Object $$$EnumCOMTIMEINCREMENTMinutes(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMTIMEINCREMENTHours "3"
  public static Object $$$EnumCOMTIMEINCREMENTHours(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMTIMEINCREMENTDaysofWeek "4"
  public static Object $$$EnumCOMTIMEINCREMENTDaysofWeek(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMTIMEINCREMENTDaysofMonth "5"
  public static Object $$$EnumCOMTIMEINCREMENTDaysofMonth(mContext m$) {
    return ("5");
  }

  //<< #define EnumCOMTIMEINCREMENTMonthsofYear "6"
  public static Object $$$EnumCOMTIMEINCREMENTMonthsofYear(mContext m$) {
    return ("6");
  }

  //<< #define EnumCOMVIEWCHOOSERPopularFields "1"
  public static Object $$$EnumCOMVIEWCHOOSERPopularFields(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMVIEWCHOOSERDateTime "2"
  public static Object $$$EnumCOMVIEWCHOOSERDateTime(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMVIEWCHOOSERNumericCurrency "3"
  public static Object $$$EnumCOMVIEWCHOOSERNumericCurrency(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMVIEWCHOOSERTextMemo "4"
  public static Object $$$EnumCOMVIEWCHOOSERTextMemo(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMVIEWCHOOSERYesNo "5"
  public static Object $$$EnumCOMVIEWCHOOSERYesNo(mContext m$) {
    return ("5");
  }

  //<< #define EnumCOMVIEWCHOOSEROtherFields "6"
  public static Object $$$EnumCOMVIEWCHOOSEROtherFields(mContext m$) {
    return ("6");
  }

  //<< #define EnumCOMVIEWCHOOSERRelatedClasses "7"
  public static Object $$$EnumCOMVIEWCHOOSERRelatedClasses(mContext m$) {
    return ("7");
  }

  //<< #define EnumCOMVIEWCHOOSERCalculatedFields "8"
  public static Object $$$EnumCOMVIEWCHOOSERCalculatedFields(mContext m$) {
    return ("8");
  }

  //<< #define EnumCOMVIEWCOMPARATORGreaterThan "1"
  public static Object $$$EnumCOMVIEWCOMPARATORGreaterThan(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMVIEWCOMPARATORLessThan "2"
  public static Object $$$EnumCOMVIEWCOMPARATORLessThan(mContext m$) {
    return ("2");
  }

  //<< #define EnumCOMVIEWCOMPARATOREquals "3"
  public static Object $$$EnumCOMVIEWCOMPARATOREquals(mContext m$) {
    return ("3");
  }

  //<< #define EnumCOMVIEWCOMPARATORNotEquals "4"
  public static Object $$$EnumCOMVIEWCOMPARATORNotEquals(mContext m$) {
    return ("4");
  }

  //<< #define EnumCOMVIEWCOMPARATORStartsWith "5"
  public static Object $$$EnumCOMVIEWCOMPARATORStartsWith(mContext m$) {
    return ("5");
  }

  //<< #define EnumCOMVIEWCOMPARATORContains "6"
  public static Object $$$EnumCOMVIEWCOMPARATORContains(mContext m$) {
    return ("6");
  }

  //<< #define EnumCOMVIEWCOMPARATORWithin "7"
  public static Object $$$EnumCOMVIEWCOMPARATORWithin(mContext m$) {
    return ("7");
  }

  //<< #define EnumCOMVIEWCOMPARATORLike "8"
  public static Object $$$EnumCOMVIEWCOMPARATORLike(mContext m$) {
    return ("8");
  }

  //<< #define EnumCOMVIEWCOMPARATORBetween "9"
  public static Object $$$EnumCOMVIEWCOMPARATORBetween(mContext m$) {
    return ("9");
  }

  //<< #define EnumCOMVIEWCOMPARATORFindIn "10"
  public static Object $$$EnumCOMVIEWCOMPARATORFindIn(mContext m$) {
    return ("10");
  }

  //<< #define EnumCOMVIEWCOUNTMaxCount "1000"
  public static Object $$$EnumCOMVIEWCOUNTMaxCount(mContext m$) {
    return ("1000");
  }

  //<< #define EnumCOMVIEWSEARCHSUBMISSIONKeystrokeDelay "1"
  public static Object $$$EnumCOMVIEWSEARCHSUBMISSIONKeystrokeDelay(mContext m$) {
    return ("1");
  }

  //<< #define EnumCOMVIEWSEARCHSUBMISSIONManual "2"
  public static Object $$$EnumCOMVIEWSEARCHSUBMISSIONManual(mContext m$) {
    return ("2");
  }

}
