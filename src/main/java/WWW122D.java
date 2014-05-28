//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW122D
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:15
//*****************************************************************************

import mLibrary.*;

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

public class WWW122D extends mClass {

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; 22-Oct-2009   shobby  SR16969 Class/Form changed (Do Not remove comment)
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< WWW122D(YKEY)
  public Object main(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWW122D(YKEY);
  }

  public Object _WWW122D(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       LÖSCHEN DER CUSTOMIZINGDATEN
    //<< ;   D ^WWW122D("FORMNAME,4")
    //<< ;
    //<< ; Inputs : YKEY   : Form,FormField
    //<< ;
    //<< ; Returns : Nothing
    //<< ;
    //<< ; History :
    //<< ; 07-Jul-2011   GRF     SR16925: get keys once
    //<< ; 20.06.2003    TYBD
    //<< ; 27.09.2002    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new idForm,idFormField
    mVar idForm = m$.var("idForm");
    mVar idFormField = m$.var("idFormField");
    m$.newVar(idForm,idFormField);
    //<< 
    //<< quit:$get(YKEY)=""
    if (mOp.Equal(m$.Fnc.$get(YKEY),"")) {
      return null;
    }
    //<< set idForm      = $$$KEY1(YKEY)
    idForm.set(include.COMSYSWWW.$$$KEY1(m$,YKEY));
    //<< set idFormField = $$$KEY2(YKEY)
    idFormField.set(include.COMSYSWWW.$$$KEY2(m$,YKEY));
    //<< quit:idForm=""
    if (mOp.Equal(idForm.get(),"")) {
      return null;
    }
    //<< quit:idFormField=""
    if (mOp.Equal(idFormField.get(),"")) {
      return null;
    }
    //<< 
    //<< if $data(^WWW122D(0,idForm,idFormField))    kill ^WWW122D(0,idForm,idFormField)
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122D",0,idForm.get(),idFormField.get())))) {
      m$.var("^WWW122D",0,idForm.get(),idFormField.get()).kill();
    }
    //<< if $data(^WWW127(0,idForm,"D",idFormField)) kill ^WWW127(0,idForm,"D",idFormField)  ;LÖSCHEN HILFETEXT
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW127",0,idForm.get(),"D",idFormField.get())))) {
      m$.var("^WWW127",0,idForm.get(),"D",idFormField.get()).kill();
    }
    //<< if $data(^WWW127(0,idForm,"M",idFormField)) kill ^WWW127(0,idForm,"M",idFormField)  ;LÖSCHEN HILFETEXT
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW127",0,idForm.get(),"M",idFormField.get())))) {
      m$.var("^WWW127",0,idForm.get(),"M",idFormField.get()).kill();
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ListUsedFreeFields(pidForm)
  public Object ListUsedFreeFields(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create a COMTempList of customised free fields for a given form.
    //<< ;
    //<< ; Params:   pidForm - the id of the form with the free fields
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Nov-2010   GRF     SRBR0414837: Replace Order macro
    //<< ; 01-Nov-2006   shobby  SRBR014196: Prepend the word Form_ as part of the key
    //<< ;                           on COMTempList
    //<< ; 17-Jul-2006   JW      SR14832: Created (modified SetResultFields^INForeLine)
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,objField,strDesc,idClassField
    mVar idField = m$.var("idField");
    mVar objField = m$.var("objField");
    mVar strDesc = m$.var("strDesc");
    mVar idClassField = m$.var("idClassField");
    m$.newVar(idField,objField,strDesc,idClassField);
    //<< 
    //<< quit:$get(pidForm)=""
    if (mOp.Equal(m$.Fnc.$get(pidForm),"")) {
      return null;
    }
    //<< 
    //<< kill ^COMTempList(0,YUSER,pidForm)
    m$.var("^COMTempList",0,m$.var("YUSER").get(),pidForm.get()).kill();
    //<< 
    //<< set idField = ""
    idField.set("");
    //<< for {                   // Loop through all customised fields
    for (;true;) {
      //<< set idField = $order(^WWW122D(0,pidForm,idField))
      idField.set(m$.Fnc.$order(m$.var("^WWW122D",0,pidForm.get(),idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< 
      //<< set objField = $get(^WWW122(0,pidForm,idField,1))
      objField.set(m$.Fnc.$get(m$.var("^WWW122",0,pidForm.get(),idField.get(),1)));
      //<< if $extract($$$WWW122ManualCaption(objField),1,5) = "_FREE" {       // Which are free fields
      if (mOp.Equal(m$.Fnc.$extract(include.WWWConst.$$$WWW122ManualCaption(m$,objField),1,5),"_FREE")) {
        //<< set strDesc = $$$WWW122DFieldDescription($get(^WWW122D(0,pidForm,idField,0,1)))
        strDesc.set(include.WWWConst.$$$WWW122DFieldDescription(m$,m$.Fnc.$get(m$.var("^WWW122D",0,pidForm.get(),idField.get(),0,1))));
        //<< if strDesc'="" {
        if (mOp.NotEqual(strDesc.get(),"")) {
          //<< set idClassField = +$$$WWW122SequenceNumber(objField)       // Which have a description
          idClassField.set(mOp.Positive(include.WWWConst.$$$WWW122SequenceNumber(m$,objField)));
          //<< set ^COMTempList(0,YUSER,"Form_"_pidForm,idClassField,1) = strDesc
          m$.var("^COMTempList",0,m$.var("YUSER").get(),mOp.Concat("Form_",pidForm.get()),idClassField.get(),1).set(strDesc.get());
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
  //<< CustomHelpText(pobjWWW122D)
  public Object CustomHelpText(Object ... _p) {
    mVar pobjWWW122D = m$.newVarRef("pobjWWW122D",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If Help Text is a WWW009 reference, return that Text string rather than
    //<< ; the Text ID.
    //<< ;
    //<< ; 25-May-2011   shobby  SR16925.2: IndividualHelpText->CustomHelpText
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$PreProcessText^WWWFORMCOMMON(pobjWWW122D,$$$FldWWW122DCustomHelpText)     ;SR16925.2
    return m$.fnc$("WWWFORMCOMMON.PreProcessText",pobjWWW122D.get(),include.WWWConst.$$$FldWWW122DCustomHelpText(m$));
  }

  //<< 
  //<< 
  //<< CustomTrainingText(pobjWWW122D)
  public Object CustomTrainingText(Object ... _p) {
    mVar pobjWWW122D = m$.newVarRef("pobjWWW122D",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If Training Text is a WWW009 reference, return that Text string rather than
    //<< ; the Text ID.
    //<< ;
    //<< ; 25-May-2011   shobby  SR16925.2: IndividualTrainingText->CustomTrainingText
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$PreProcessText^WWWFORMCOMMON(pobjWWW122D,$$$FldWWW122DCustomTrainingText) ;SR16925.2
    return m$.fnc$("WWWFORMCOMMON.PreProcessText",pobjWWW122D.get(),include.WWWConst.$$$FldWWW122DCustomTrainingText(m$));
  }

  //<< 
  //<< 
  //<< RelationWithSearchFunction(YKEY)
  public Object RelationWithSearchFunction(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; This routine determines what the 'Inherited' value of the 'Relation With Search
    //<< ;   Function' checkbox will be when viewed from the Form Field customisation screen.
    //<< ;
    //<< ; Called By: Form WWW122D F127 - Inherited From
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Nov-2010   shobby  SR17612:    $$$INHERIT is now ""
    //<< ; 12-Oct-2010   shobby  SRBR014837: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idForm,intValue,objWWW122
    mVar idField = m$.var("idField");
    mVar idForm = m$.var("idForm");
    mVar intValue = m$.var("intValue");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(idField,idForm,intValue,objWWW122);
    //<< 
    //<< set idForm   = $$$KEY1(YKEY)
    idForm.set(include.COMSYSWWW.$$$KEY1(m$,YKEY));
    //<< set idField  = $$$KEY2(YKEY)
    idField.set(include.COMSYSWWW.$$$KEY2(m$,YKEY));
    //<< set intValue = 0
    intValue.set(0);
    //<< 
    //<< if (idForm'="") && (idField'="") {
    if ((mOp.NotEqual(idForm.get(),"")) && (mOp.NotEqual(idField.get(),""))) {
      //<< set objWWW122 = $get(^WWW122(0,idForm,idField,1))
      objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,idForm.get(),idField.get(),1)));
      //<< if objWWW122'="" {
      if (mOp.NotEqual(objWWW122.get(),"")) {
        //<< set intValue = $$$WWW122RelationWithSearchFuncti(objWWW122)                             ;SR17612
        intValue.set(include.WWWConst.$$$WWW122RelationWithSearchFuncti(m$,objWWW122));
        //<< if intValue="" set intValue = $$RelationWithSearchFunction^WWW122(idForm_","_idField)   ;SR17612
        if (mOp.Equal(intValue.get(),"")) {
          intValue.set(m$.fnc$("WWW122.RelationWithSearchFunction",mOp.Concat(mOp.Concat(idForm.get(),","),idField.get())));
        }
      }
    }
    //<< }
    //<< }
    //<< quit intValue
    return intValue.get();
  }

  //<< 
  //<< FlatControls(pYKEY)
  public Object FlatControls(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; This routine determines what the 'Inherited' value of the 'Flat Controls' checkbox
    //<< ; will be when viewed from the Form Field screen.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Oct-2013   shobby  CORE-281: New'd objWWW122
    //<< ; 12-Oct-2010   shobby  CORE-281: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idForm,idField,objWWW122,intValue
    mVar idForm = m$.var("idForm");
    mVar idField = m$.var("idField");
    mVar objWWW122 = m$.var("objWWW122");
    mVar intValue = m$.var("intValue");
    m$.newVar(idForm,idField,objWWW122,intValue);
    //<< 
    //<< 
    //<< set intValue = 0
    intValue.set(0);
    //<< 
    //<< set idForm=$$$KEY1(pYKEY)
    idForm.set(include.COMSYSWWW.$$$KEY1(m$,pYKEY));
    //<< set idField=$$$KEY2(pYKEY)
    idField.set(include.COMSYSWWW.$$$KEY2(m$,pYKEY));
    //<< if (idForm'="") && (idField'="") {
    if ((mOp.NotEqual(idForm.get(),"")) && (mOp.NotEqual(idField.get(),""))) {
      //<< set objWWW122 = $get(^WWW122(0,idForm,idField,1))
      objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,idForm.get(),idField.get(),1)));
      //<< if objWWW122'="" {
      if (mOp.NotEqual(objWWW122.get(),"")) {
        //<< set intValue = $$$WWW122FlatControls(objWWW122)                             ;SR17612
        intValue.set(include.WWWConst.$$$WWW122FlatControls(m$,objWWW122));
        //<< if intValue="" set intValue = $$FlatControls^WWW122(idForm_","_idField) ;SR17612
        if (mOp.Equal(intValue.get(),"")) {
          intValue.set(m$.fnc$("WWW122.FlatControls",mOp.Concat(mOp.Concat(idForm.get(),","),idField.get())));
        }
      }
    }
    //<< }
    //<< }
    //<< quit intValue
    return intValue.get();
  }

//<< 
}
