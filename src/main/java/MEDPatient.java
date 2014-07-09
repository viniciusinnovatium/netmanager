//*****************************************************************************
//** TASC - ALPHALINC - MAC MEDPatient
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-01 19:03:59
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include MEDConst
import include.MEDConst;
import include.COMSYS;

//<< MEDPatient
public class MEDPatient extends mClass {

  public void main() {
    _MEDPatient();
  }

  public void _MEDPatient() {
  }

  //<< 
  //<< GetPatientDetails(pidPatient)
  public Object GetPatientDetails(Object ... _p) {
    mVar pidPatient = m$.newVarRef("pidPatient",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Patient Details (Name,DOB,ROOM,etc.) as a String
    //<< ;
    //<< ; Inputs: Patient
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Jun-2009   SCR     SR16546: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objPatient,strText
    mVar objPatient = m$.var("objPatient");
    mVar strText = m$.var("strText");
    m$.newVar(objPatient,strText);
    //<< 
    //<< set strText = ""
    strText.set("");
    //<< if pidPatient'="" {
    if (mOp.NotEqual(pidPatient.get(),"")) {
      //<< set objPatient = $get(^MEDPatient(0,pidPatient,1))
      objPatient.set(m$.Fnc.$get(m$.var("^MEDPatient",0,pidPatient.get(),1)));
      //<< if objPatient'="" {
      if (mOp.NotEqual(objPatient.get(),"")) {
        //<< set strText = strText_$$$MEDPatientSurname(objPatient)_", "_$$$MEDPatientOtherNames(objPatient)
        strText.set(mOp.Concat(mOp.Concat(mOp.Concat(strText.get(),include.MEDConst.$$$MEDPatientSurname(m$,objPatient)),", "),include.MEDConst.$$$MEDPatientOtherNames(m$,objPatient)));
      }
    }
    //<< }
    //<< }
    //<< quit strText
    return strText.get();
  }

  //<< 
  //<< 
  //<< Admission(YM,pidPatient,pintField)
  public Object Admission(Object ... _p) {
    mVar YM = m$.newVarRef("YM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidPatient = m$.newVarRef("pidPatient",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintField = m$.newVarRef("pintField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Patient Admission Details for calculated fields
    //<< ;
    //<< ; Inputs: Patient
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Mar-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< #dim idAdmission,objAdmission,strData
    //<< new idAdmission,objAdmission,strData
    mVar idAdmission = m$.var("idAdmission");
    mVar objAdmission = m$.var("objAdmission");
    mVar strData = m$.var("strData");
    m$.newVar(idAdmission,objAdmission,strData);
    //<< set strData=""
    strData.set("");
    //<< if $get(pidPatient)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidPatient),"")) {
      //<< set idAdmission=$$GetAdmission^MEDAdmission(pidPatient)
      idAdmission.set(m$.fnc$("MEDAdmission.GetAdmission",pidPatient.get()));
      //<< if idAdmission'="" {
      if (mOp.NotEqual(idAdmission.get(),"")) {
        //<< set objAdmission=$get(^MEDAdmission(YM,idAdmission,1))
        objAdmission.set(m$.Fnc.$get(m$.var("^MEDAdmission",YM.get(),idAdmission.get(),1)));
        //<< set strData=$piece(objAdmission,Y,+$get(pintField))
        strData.set(m$.Fnc.$piece(objAdmission.get(),m$.var("Y").get(),mOp.Positive(m$.Fnc.$get(pintField))));
      }
    }
    //<< }
    //<< }
    //<< quit strData
    return strData.get();
  }

  //<< 
  //<< IsAdmitted(pidPatient="")
  public Object IsAdmitted(Object ... _p) {
    mVar pidPatient = m$.newVarRef("pidPatient",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check if the patient is currently admitted.
    //<< ;
    //<< ; Inputs: Patient
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Oct-2012   shobby      SR18130.2 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objPatient,blnAdmitted
    mVar objPatient = m$.var("objPatient");
    mVar blnAdmitted = m$.var("blnAdmitted");
    m$.newVar(objPatient,blnAdmitted);
    //<< 
    //<< set blnAdmitted=$$$NO
    blnAdmitted.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if pidPatient'="" {
    if (mOp.NotEqual(pidPatient.get(),"")) {
      //<< set objPatient=$get(^MEDPatient(YM,pidPatient,1))
      objPatient.set(m$.Fnc.$get(m$.var("^MEDPatient",m$.var("YM").get(),pidPatient.get(),1)));
      //<< set blnAdmitted=$$$MEDPatientCurrentlyAdmitted(objPatient)
      blnAdmitted.set(include.MEDConst.$$$MEDPatientCurrentlyAdmitted(m$,objPatient));
    }
    //<< }
    //<< quit blnAdmitted
    return blnAdmitted.get();
  }

  //<< 
  //<< 
  //<< CheckAdmitted(pidDispense="",pidPrescription="",pidPatient="")
  public Object CheckAdmitted(Object ... _p) {
    mVar pidDispense = m$.newVarRef("pidDispense",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidPrescription = m$.newVarRef("pidPrescription",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pidPatient = m$.newVarRef("pidPatient",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check if the patient is currently admitted.
    //<< ;
    //<< ; Inputs: Patient
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Oct-2012   shobby      SR18130.2 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idPatient,strStatus
    mVar idPatient = m$.var("idPatient");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idPatient,strStatus);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if pidDispense'="" {
    if (mOp.NotEqual(pidDispense.get(),"")) {
      //<< set pidPrescription=$$$MEDDispensePrescription($get(^MEDDispense(YM,pidDispense,1)))
      pidPrescription.set(include.MEDConst.$$$MEDDispensePrescription(m$,m$.Fnc.$get(m$.var("^MEDDispense",m$.var("YM").get(),pidDispense.get(),1))));
    }
    //<< }
    //<< if pidPrescription'="" {
    if (mOp.NotEqual(pidPrescription.get(),"")) {
      //<< set pidPatient=$$$MEDPrescriptionPatientID($get(^MEDPrescription(YM,pidPrescription,1)))
      pidPatient.set(include.MEDConst.$$$MEDPrescriptionPatientID(m$,m$.Fnc.$get(m$.var("^MEDPrescription",m$.var("YM").get(),pidPrescription.get(),1))));
    }
    //<< }
    //<< if pidPatient'="" {
    if (mOp.NotEqual(pidPatient.get(),"")) {
      //<< if '$$IsAdmitted(pidPatient) set strStatus=$$$MakeStatus("MED01310") ;"Patient does not have an active admission"
      if (mOp.Not(m$.fnc$("IsAdmitted",pidPatient.get()))) {
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"MED01310"));
      }
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
//<< 
}
