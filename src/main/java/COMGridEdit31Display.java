//*****************************************************************************
//** TASC - ALPHALINC - MAC COMGridEdit31Display
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:24
//*****************************************************************************

import mLibrary.*;

//<< 
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
//<< #include WWWConst
import include.WWWConst;

//<< COMGridEdit31Display
public class COMGridEdit31Display extends mClass {

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogR2(%1,%2)    ;
  public static Object $$$LogR2(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogRx(%1)       ;
  public static Object $$$LogRx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogRm(%1)       ;
  public static Object $$$LogRm(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _COMGridEdit31Display();
  }

  public void _COMGridEdit31Display() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^COMGridEdit31Display("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogR2(%1,%2)   $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^COMGridEdit31Display("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< OnBeforeDelete(YDATEI="",YFORM="",YKEY="",YFELD="")
  public Object OnBeforeDelete(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Automatically remove any attached grid data
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-May-2011   shobby  SR17245: Wasn't deleting multiple grids correctly.
    //<< ; 24-Aug-2010   shobby  SR17508: Corrections when killing child forms.
    //<< ; 09-Aug-2010   shobby  SR17415: Only delete grid if it is related to deleted record.
    //<< ; 30-Apr-2010   shobby  SR17267: Is this still failing?  (checked YKEY & YFORM)
    //<< ; 28-Apr-2010   shobby  SR17267: YVOR may not exist (eg during an upgrade)
    //<< ;                           (code change in WWWKILL should ensure it is here GRF)
    //<< ; 22-Apr-2010   shobby  SR17267: Don't do this DELETE for grid lines. (eg a grid
    //<< ;                           line can't have grid lines)
    //<< ; 22-Mar-2010   shobby  SR17245: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,objCOMGridEditParameter,idClass,objWWW120,idForm ;SR17508
    mVar strStatus = m$.var("strStatus");
    mVar objCOMGridEditParameter = m$.var("objCOMGridEditParameter");
    mVar idClass = m$.var("idClass");
    mVar objWWW120 = m$.var("objWWW120");
    mVar idForm = m$.var("idForm");
    m$.newVar(strStatus,objCOMGridEditParameter,idClass,objWWW120,idForm);
    //<< 
    //<< $$$LogR("OnBeforeDelete",YFORM_"<"_YKEY)
    $$$LogR(m$,"OnBeforeDelete",mOp.Concat(mOp.Concat(YFORM.get(),"<"),YKEY.get()));
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if (YKEY'="")&&(YFORM'="") {
    if ((mOp.NotEqual(YKEY.get(),"")) && (mOp.NotEqual(YFORM.get(),""))) {
      //<< ;SR17245 vvvvv
      //<< set strStatus=$$DeleteGrids(YFORM,YKEY) ;
      strStatus.set(m$.fnc$("DeleteGrids",YFORM.get(),YKEY.get()));
      //<< ;SR17245if $$Relevant(YFORM,.objCOMGridEditParameter) {
      //<< ;SR17245    ;SR17508 set idClass   = $$$COMGridEditParameterGridName(objCOMGridEditParameter)
      //<< ;SR17245    set idForm   = $$$COMGridEditParameterGridName(objCOMGridEditParameter)         ;SR17508
      //<< ;SR17245    set objWWW120 = $get(^WWW120(0,idForm,1))                                       ;SR17508
      //<< ;SR17245    set idClass=$$$WWW120ClassUsedInForm(objWWW120)                                 ;SR17508
      //<< ;SR17245    if idClass'="" {                                                                ;SR17508
      //<< ;SR17245        set strStatus = $$KillChildren^COMUtils(idClass,YKEY)                       ;SR17508
      //<< ;SR17245    }                                                                               ;SR17508
      //<< ;SR17245}
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< if YFORM=$get(^CacheTemp(YUSER,"Grid","Container")) {  ;SR17415
        if (mOp.Equal(YFORM.get(),m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")))) {
          //<< set objWWW120 = $get(^WWW120(0,YFORM,1))
          objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)));
          //<< if objWWW120'="" {
          if (mOp.NotEqual(objWWW120.get(),"")) {
            //<< ;   if $$$WWW120FormType(YVOR)'=12 do DELETE^COMGridEdit31R()       ;SR17267
            //<< if $$$WWW120FormType(objWWW120)'=12 do DELETE^COMGridEdit31R()
            if (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,objWWW120),12)) {
              m$.Cmd.Do("COMGridEdit31R.DELETE");
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< DeleteGrids(YFORM,YKEY)
  public Object DeleteGrids(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Deletes all grids related to this form in the metadata setup.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-May-2011   shobby      SR17245: Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< new idGrid,objCOMGridEditParameter,idForm,objWWW120
    mVar idGrid = m$.var("idGrid");
    mVar objCOMGridEditParameter = m$.var("objCOMGridEditParameter");
    mVar idForm = m$.var("idForm");
    mVar objWWW120 = m$.var("objWWW120");
    m$.newVar(idGrid,objCOMGridEditParameter,idForm,objWWW120);
    //<< 
    //<< set idGrid="" for { set idGrid=$order(^COMGridEditParameter(0,YFORM,idGrid)) quit:idGrid=""
    idGrid.set("");
    for (;true;) {
      idGrid.set(m$.Fnc.$order(m$.var("^COMGridEditParameter",0,YFORM.get(),idGrid.get())));
      if (mOp.Equal(idGrid.get(),"")) {
        break;
      }
      //<< quit:$$$ISERR(strStatus)
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,m$.var("strStatus")))) {
        break;
      }
      //<< set objCOMGridEditParameter = $get(^COMGridEditParameter(0,YFORM,idGrid,1))
      objCOMGridEditParameter.set(m$.Fnc.$get(m$.var("^COMGridEditParameter",0,YFORM.get(),idGrid.get(),1)));
      //<< set idForm   = $$$COMGridEditParameterGridName(objCOMGridEditParameter)
      idForm.set(include.COMConst.$$$COMGridEditParameterGridName(m$,objCOMGridEditParameter));
      //<< set objWWW120 = $get(^WWW120(0,idForm,1))
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,idForm.get(),1)));
      //<< set idClass=$$$WWW120ClassUsedInForm(objWWW120)
      mVar idClass = m$.var("idClass");
      idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objWWW120));
      //<< if idClass'="" {
      if (mOp.NotEqual(idClass.get(),"")) {
        //<< set strStatus = $$KillChildren^COMUtils(idClass,YKEY)
        mVar strStatus = m$.var("strStatus");
        strStatus.set(m$.fnc$("COMUtils.KillChildren",idClass.get(),YKEY.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strStatus
    return m$.var("strStatus").get();
  }

  //<< 
  //<< 
  //<< OnAfterDataFields(pYFORM="",pYKEY="",pYFELD="")
  public Object OnAfterDataFields(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Sep-2012   shobby  SR18128: Forced YKEY back in to a valid form.
    //<< ;                           MEDPrescriptionHosp is an example of a form
    //<< ;                           that may manipulate YKEY during loading.
    //<< ; 22-Mar-2010   shobby  SR17245: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objCOMGridEditParameter,YAUSWAHL,YFORM,YKEY,YFELD
    mVar objCOMGridEditParameter = m$.var("objCOMGridEditParameter");
    mVar YAUSWAHL = m$.var("YAUSWAHL");
    mVar YFORM = m$.var("YFORM");
    mVar YKEY = m$.var("YKEY");
    mVar YFELD = m$.var("YFELD");
    m$.newVar(objCOMGridEditParameter,YAUSWAHL,YFORM,YKEY,YFELD);
    //<< 
    //<< $$$LogR("OnAfterDataFields",pYFORM_"<"_pYKEY)
    $$$LogR(m$,"OnAfterDataFields",mOp.Concat(mOp.Concat(pYFORM.get(),"<"),pYKEY.get()));
    //<< 
    //<< if $$Relevant(pYFORM,.YAUSWAHL) {
    if (mOp.Logical(m$.fnc$("Relevant",pYFORM.get(),YAUSWAHL))) {
      //<< if ($$$COMGridEditParameterTabs(YAUSWAHL)="") || ((";"_$$$COMGridEditParameterTabs(YAUSWAHL)_";")[(";"_YSEITE_";")) {
      if ((mOp.Equal(include.COMConst.$$$COMGridEditParameterTabs(m$,YAUSWAHL),"")) || (mOp.Contains((mOp.Concat(mOp.Concat(";",include.COMConst.$$$COMGridEditParameterTabs(m$,YAUSWAHL)),";")),(mOp.Concat(mOp.Concat(";",m$.var("YSEITE").get()),";"))))) {
        //<< set YKEY  = $piece(pYKEY,",",1,YMAXKEY) ;SR18124
        YKEY.set(m$.Fnc.$piece(pYKEY.get(),",",1,m$.var("YMAXKEY").get()));
        //<< set YFELD = pYFELD
        YFELD.set(pYFELD.get());
        //<< set YFORM = $$$COMGridEditParameterGridName(YAUSWAHL)
        YFORM.set(include.COMConst.$$$COMGridEditParameterGridName(m$,YAUSWAHL));
        //<< set $$$COMGridEditParameterContainer(YAUSWAHL) = pYFORM
        include.COMConst.$$$COMGridEditParameterContainerSet(m$,YAUSWAHL,pYFORM.get());
        //<< set $$$COMGridEditParameterEnabled(YAUSWAHL)   = $$EnabledTest($$$COMGridEditParameterEnabledTest(YAUSWAHL),pYFELD)
        include.COMConst.$$$COMGridEditParameterEnabledSet(m$,YAUSWAHL,m$.fnc$("EnabledTest",include.COMConst.$$$COMGridEditParameterEnabledTest(m$,YAUSWAHL),pYFELD.get()));
        //<< if $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly set $$$COMGridEditParameterEnabled(YAUSWAHL) = $$$NO
        if (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$))) {
          include.COMConst.$$$COMGridEditParameterEnabledSet(m$,YAUSWAHL,include.COMSYS.$$$NO(m$));
        }
        //<< do ^COMGridEdit31
        m$.Cmd.Do("COMGridEdit31.main");
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< EnabledTest(pstrExpression,YFELD)
  public Object EnabledTest(Object ... _p) {
    mVar pstrExpression = m$.newVarRef("pstrExpression",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< $$$LogR("EnabledTest",pstrExpression_"<")
    $$$LogR(m$,"EnabledTest",mOp.Concat(pstrExpression.get(),"<"));
    //<< 
    //<< quit:(pstrExpression="") $$$YES
    if ((mOp.Equal(pstrExpression.get(),""))) {
      return include.COMSYS.$$$YES(m$);
    }
    //<< quit @pstrExpression
    return m$.indirectVar(pstrExpression.get()).get();
  }

  //<< 
  //<< 
  //<< OnBeforeSave(YKEY,YFELD)
  public Object OnBeforeSave(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-May-2011   shobby  SR17245: Some troubles with multiple grids.
    //<< ; 22-Mar-2010   shobby  SR17245: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< $$$LogR("OnBeforeSave",YKEY)
    $$$LogR(m$,"OnBeforeSave",YKEY);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if $data(^COMGridEditParameter(0,YFORM)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^COMGridEditParameter",0,m$.var("YFORM").get())))) {
      //<< set strStatus = $$SAVE^COMGridEdit31Save($get(YKEY))
      strStatus.set(m$.fnc$("COMGridEdit31Save.SAVE",m$.Fnc.$get(YKEY)));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< Relevant(pYFORM,&pobjCOMGridEditParameter="")
  public Object Relevant(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjCOMGridEditParameter = m$.newVarRef("pobjCOMGridEditParameter",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; If this grid is defined by metadata then we do the processing automatically not
    //<< ; through custom code.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Mar-2010   shobby  SR17245: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnRelevant,idGrid,blnFound
    mVar blnRelevant = m$.var("blnRelevant");
    mVar idGrid = m$.var("idGrid");
    mVar blnFound = m$.var("blnFound");
    m$.newVar(blnRelevant,idGrid,blnFound);
    //<< 
    //<< $$$LogR("Relevant",pYFORM)
    $$$LogR(m$,"Relevant",pYFORM);
    //<< 
    //<< set blnRelevant = $$$NO
    blnRelevant.set(include.COMSYS.$$$NO(m$));
    //<< set blnFound=$$$NO
    blnFound.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if (pYFORM'="") {
    if ((mOp.NotEqual(pYFORM.get(),""))) {
      //<< set idGrid="" for { set idGrid=$order(^COMGridEditParameter(0,pYFORM,idGrid)) quit:idGrid=""
      idGrid.set("");
      for (;true;) {
        idGrid.set(m$.Fnc.$order(m$.var("^COMGridEditParameter",0,pYFORM.get(),idGrid.get())));
        if (mOp.Equal(idGrid.get(),"")) {
          break;
        }
        //<< set pobjCOMGridEditParameter = $get(^COMGridEditParameter(0,pYFORM,idGrid,1))
        pobjCOMGridEditParameter.set(m$.Fnc.$get(m$.var("^COMGridEditParameter",0,pYFORM.get(),idGrid.get(),1)));
        //<< if (pYFORM="WWW120")||($$$COMGridEditParameterTabs(pobjCOMGridEditParameter)=$get(YSEITE))||($$$COMGridEditParameterTabs(pobjCOMGridEditParameter)="") {
        if ((mOp.Equal(pYFORM.get(),"WWW120")) || (mOp.Equal(include.COMConst.$$$COMGridEditParameterTabs(m$,pobjCOMGridEditParameter),m$.Fnc.$get(m$.var("YSEITE")))) || (mOp.Equal(include.COMConst.$$$COMGridEditParameterTabs(m$,pobjCOMGridEditParameter),""))) {
          //<< set blnRelevant=$$$YES
          blnRelevant.set(include.COMSYS.$$$YES(m$));
          //<< quit
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnRelevant
    return blnRelevant.get();
  }

//<< 
//<< 
}
