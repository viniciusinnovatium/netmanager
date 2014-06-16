//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewConfig
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-13 20:19:31
//*****************************************************************************

import mLibrary.*;

//<< 
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

//<< COMViewConfig
public class COMViewConfig extends mClass {

  public void main() {
    _COMViewConfig();
  }

  public void _COMViewConfig() {
  }

  //<< 
  //<< UseKeyStroke()
  public Object UseKeyStroke() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines whether we are using keystroke or not
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: boolean
    //<< ;
    //<< ; History:
    //<< ; 09-Feb-2007   RPW         SR15426: If this is an In Form COMView, alway shows
    //<< ;                               the tick button for manual submission
    //<< ; 08-Jun-2006   Steve S     SR14613: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new enumSubmission
    mVar enumSubmission = m$.var("enumSubmission");
    m$.newVar(enumSubmission);
    //<< 
    //<< set enumSubmission = $$$COMViewConfigSearchSubmission($get(^COMViewConfig(0,0,1)))
    enumSubmission.set(include.COMConst.$$$COMViewConfigSearchSubmission(m$,m$.Fnc.$get(m$.var("^COMViewConfig",0,0,1))));
    //<< if enumSubmission="" set enumSubmission = $$$EnumCOMVIEWSEARCHSUBMISSIONKeystrokeDelay
    if (mOp.Equal(enumSubmission.get(),"")) {
      enumSubmission.set(include.COMConst.$$$EnumCOMVIEWSEARCHSUBMISSIONKeystrokeDelay(m$));
    }
    //<< 
    //<< if $get(^CacheTempView(YUSER,YUCI,"InForm")) {
    if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm")))) {
      //<< set enumSubmission = $$$EnumCOMVIEWSEARCHSUBMISSIONManual
      enumSubmission.set(include.COMConst.$$$EnumCOMVIEWSEARCHSUBMISSIONManual(m$));
    }
    //<< }
    //<< quit (enumSubmission=$$$EnumCOMVIEWSEARCHSUBMISSIONKeystrokeDelay)
    return (mOp.Equal(enumSubmission.get(),include.COMConst.$$$EnumCOMVIEWSEARCHSUBMISSIONKeystrokeDelay(m$)));
  }

  //<< 
  //<< 
  //<< GetMaximum(pblnLoadAll)
  public Object GetMaximum(Object ... _p) {
    mVar pblnLoadAll = m$.newVarRef("pblnLoadAll",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the Maximum Results Returned from COMViewConfig.
    //<< ; If this is blank get the default from the COMVIEWCOUNT application parameter.
    //<< ;
    //<< ; Params:
    //<< ; pblnLoadAll: If this is true, then always return 0.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; 0,1000 or the number entered by the user.
    //<< ;
    //<< ; History:
    //<< ; 04-Sep-2006   RPW     SR15005: Created.  JW - changed enum to 1000.
    //<< ;-------------------------------------------------------------------------------
    //<< new intMaxCount
    mVar intMaxCount = m$.var("intMaxCount");
    m$.newVar(intMaxCount);
    //<< 
    //<< set intMaxCount = 0
    intMaxCount.set(0);
    //<< if 'pblnLoadAll {
    if (mOp.Not(pblnLoadAll.get())) {
      //<< set intMaxCount = $$$COMViewConfigMaximumResultsReturned($get(^COMViewConfig(0,0,1)))
      intMaxCount.set(include.COMConst.$$$COMViewConfigMaximumResultsReturned(m$,m$.Fnc.$get(m$.var("^COMViewConfig",0,0,1))));
      //<< if intMaxCount="" set intMaxCount = 1000
      if (mOp.Equal(intMaxCount.get(),"")) {
        intMaxCount.set(1000);
      }
    }
    //<< }
    //<< quit intMaxCount
    return intMaxCount.get();
  }

  //<< 
  //<< 
  //<< OnBlur(pidField,pobjConfig)
  public Object OnBlur(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjConfig = m$.newVarRef("pobjConfig",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If the value is negative make it blank
    //<< ;
    //<< ; Params:
    //<< ; pidField  : Which field was changed
    //<< ; pobjConfig: The COMViewConfig Object
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Dec-2010   shobby  SR15753: Removed redundant call.
    //<< ; 04-Sep-2006   RPW     SR15005: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if pidField=$$$FldCOMViewConfigMaximumResultsReturned {
    if (mOp.Equal(pidField.get(),include.COMConst.$$$FldCOMViewConfigMaximumResultsReturned(m$))) {
      //<< if $$$COMViewConfigMaximumResultsReturned(pobjConfig)<0 {
      if (mOp.Less(include.COMConst.$$$COMViewConfigMaximumResultsReturned(m$,pobjConfig),0)) {
        //<< set $$$COMViewConfigMaximumResultsReturned(pobjConfig) = ""
        include.COMConst.$$$COMViewConfigMaximumResultsReturnedSet(m$,pobjConfig,"");
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ExpandSelection()
  public Object ExpandSelection() {
    //<< quit $$$COMViewConfigExpandSelection($get(^COMViewConfig(0,0,1)))
    return include.COMConst.$$$COMViewConfigExpandSelection(m$,m$.Fnc.$get(m$.var("^COMViewConfig",0,0,1)));
  }

//<< 
//<< 
}
