//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW120D
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:56
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ;09-Sep-2008    shobby  SRBR014980 Class/Form changed (Do Not remove comment)
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

//<< WWW120D
public class WWW120D extends mClass {

  public void main() {
    _WWW120D();
  }

  public void _WWW120D() {
  }

  //<< 
  //<< CustomHelpText(pobjWWW120D)
  public Object CustomHelpText(Object ... _p) {
    mVar pobjWWW120D = m$.newVarRef("pobjWWW120D",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If Help Text is a WWW009 reference, return that Text string rather than
    //<< ; the Text ID.
    //<< ;
    //<< ; 25-May-2011   shobby      SR16925.2: IndividualHelpText->CustomHelpText
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$PreProcessText^WWWFORMCOMMON(pobjWWW120D,$$$FldWWW120DCustomHelpText) ;BR014966 ;16925 ;SR16925.2
    return m$.fnc$("WWWFORMCOMMON.PreProcessText",pobjWWW120D.get(),include.WWWConst.$$$FldWWW120DCustomHelpText(m$));
  }

  //<< 
  //<< 
  //<< CustomTrainingText(pobjWWW120D)
  public Object CustomTrainingText(Object ... _p) {
    mVar pobjWWW120D = m$.newVarRef("pobjWWW120D",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If Training Text is a WWW009 reference, return that Text string rather than
    //<< ; the Text ID.
    //<< ;
    //<< ; 25-May-2011   shobby      SR16925.2: IndividualTrainingText->CustomTrainingText
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$PreProcessText^WWWFORMCOMMON(pobjWWW120D,$$$FldWWW120DCustomTrainingText) ;BR014966 ;16925 ;SR16925.2
    return m$.fnc$("WWWFORMCOMMON.PreProcessText",pobjWWW120D.get(),include.WWWConst.$$$FldWWW120DCustomTrainingText(m$));
  }

  //<< 
  //<< IsNotStandardFormType(YKEY)
  public Object IsNotStandardFormType(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine the form type for 'rules' processing.
    //<< ;
    //<< ; 22-Apr-2012   shobby      SR18021: YFORM not newed causing a grid to appear
    //<< ;                               when editing the form field of a form.
    //<< ; 13-Apr-2012   shobby      SR18000: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YFORM   ;SR18021
    mVar YFORM = m$.var("YFORM");
    m$.newVar(YFORM);
    //<< set YFORM=$piece(YKEY,",",1)
    YFORM.set(m$.Fnc.$piece(YKEY.get(),",",1));
    //<< if $get(YFORM)="" set YFORM=" "
    if (mOp.Equal(m$.Fnc.$get(YFORM),"")) {
      YFORM.set(" ");
    }
    //<< quit $$$WWW120FormType($get(^WWW120(0,YFORM,1)))'=1
    return mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1))),1);
  }

  //<< 
  //<< ExecuteAfterDataFields(YFORM,YKEY,YFELD,&YSTOP)
  public Object ExecuteAfterDataFields(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YSTOP = m$.newVarRef("YSTOP",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 24-Aug-2012   shobby      SR18091: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW120D,strExec
    mVar objWWW120D = m$.var("objWWW120D");
    mVar strExec = m$.var("strExec");
    m$.newVar(objWWW120D,strExec);
    //<< 
    //<< set objWWW120D=$get(^WWW120D(0,YFORM,YM,1))
    objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",0,YFORM.get(),m$.var("YM").get(),1)));
    //<< set strExec=$$$WWW120DExecuteAfterDataFields(objWWW120D)
    strExec.set(include.WWWConst.$$$WWW120DExecuteAfterDataFields(m$,objWWW120D));
    //<< if strExec'= "" {
    if (mOp.NotEqual(strExec.get(),"")) {
      //<< xecute strExec
      m$.Cmd.Xecute(strExec.get());
    }
    //<< ; CAUTION: setting YSTOP=1 will prevent the core ExecuteAfterDataFields
    //<< ;          from running.
    //<< }
    //<< ;SR18091
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ReplaceCore(YFORM="")
  public Object ReplaceCore(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Flag to determine if the customisation of ExecuteAfterDataFields runs after
    //<< ; the core version or instead of.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Aug-2013   shobby      CORE-182: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW120D,blnBlock
    mVar objWWW120D = m$.var("objWWW120D");
    mVar blnBlock = m$.var("blnBlock");
    m$.newVar(objWWW120D,blnBlock);
    //<< 
    //<< set blnBlock=$$$NO
    blnBlock.set(include.COMSYS.$$$NO(m$));
    //<< if YFORM'="" {
    if (mOp.NotEqual(YFORM.get(),"")) {
      //<< set objWWW120D=$get(^WWW120D(0,YFORM,YM,1))
      objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",0,YFORM.get(),m$.var("YM").get(),1)));
      //<< set blnBlock=+$$$WWW120DExecuteAfterDataFieldsRep(objWWW120D)
      blnBlock.set(mOp.Positive(include.WWWConst.$$$WWW120DExecuteAfterDataFieldsRep(m$,objWWW120D)));
    }
    //<< }
    //<< quit blnBlock
    return blnBlock.get();
  }

  //<< 
  //<< FixedColumns()
  public Object FixedColumns(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine the fixed columns
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Sep-2013   shobby  CORE-254: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strFixedColumns
    mVar strFixedColumns = m$.var("strFixedColumns");
    m$.newVar(strFixedColumns);
    //<< set strFixedColumns=""
    strFixedColumns.set("");
    //<< if YFORM'="" {
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      //<< set strFixedColumns=$$$WWW120DFixedColumns($get(^WWW120D(0,YFORM,YM,1)))
      strFixedColumns.set(include.WWWConst.$$$WWW120DFixedColumns(m$,m$.Fnc.$get(m$.var("^WWW120D",0,m$.var("YFORM").get(),m$.var("YM").get(),1))));
      //<< if strFixedColumns="" set strFixedColumns=$$$WWW120FixedColumns($get(^WWW120(0,YFORM,1)))
      if (mOp.Equal(strFixedColumns.get(),"")) {
        strFixedColumns.set(include.WWWConst.$$$WWW120FixedColumns(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1))));
      }
      //<< if strFixedColumns="" set strFixedColumns=$$$WWW012FixedColumns($get(^WWW012(0,YM,1)))
      if (mOp.Equal(strFixedColumns.get(),"")) {
        strFixedColumns.set(include.WWWConst.$$$WWW012FixedColumns(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))));
      }
    }
    //<< }
    //<< quit strFixedColumns
    return strFixedColumns.get();
  }

  //<< 
  //<< FlatControls(YFORM)
  public Object FlatControls(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine the Flat Controls
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Dec-2013   shobby  CORE-281: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strFlatControls
    mVar strFlatControls = m$.var("strFlatControls");
    m$.newVar(strFlatControls);
    //<< set strFlatControls=""
    strFlatControls.set("");
    //<< if YFORM'="" {
    if (mOp.NotEqual(YFORM.get(),"")) {
      //<< set strFlatControls=$$$WWW120FlatControls($get(^WWW120(0,YFORM,1)))
      strFlatControls.set(include.WWWConst.$$$WWW120FlatControls(m$,m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1))));
    }
    //<< }
    //<< quit strFlatControls
    return strFlatControls.get();
  }

//<< 
}
