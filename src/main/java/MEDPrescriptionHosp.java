//*****************************************************************************
//** TASC - ALPHALINC - MAC MEDPrescriptionHosp
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:12
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
//<< #include MEDConst
import include.MEDConst;
//<< #include INConst
import include.INConst;
//<< #include WWWConst
import include.WWWConst;

//<< MEDPrescriptionHosp
public class MEDPrescriptionHosp extends mClass {

  public void main() {
    _MEDPrescriptionHosp();
  }

  public void _MEDPrescriptionHosp() {
  }

  //<< 
  //<< 
  //<< IsDisabled(YKEY="",pintButton)
  public Object IsDisabled(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintButton = m$.newVarRef("pintButton",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks to see if buttons should be disabled.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Oct-2012   shobby  SR18130.2: Tooltip message
    //<< ; 16-Oct-2012   shobby  SR18130.1: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objPatient
    mVar objPatient = m$.var("objPatient");
    m$.newVar(objPatient);
    //<< 
    //<< if pintButton=4 {  ; New button
    if (mOp.Equal(pintButton.get(),4)) {
      //<< if YKEY="" {
      if (mOp.Equal(YKEY.get(),"")) {
        //<< set YQ=$$$YES
        mVar YQ = m$.var("YQ");
        YQ.set(include.COMSYS.$$$YES(m$));
      }
      //<< } else {
      else {
        //<< if '$$CheckAdmitted^MEDPatient("","",$get(YPARA)) {     ;SR18130.2
        if (mOp.Not(m$.fnc$("MEDPatient.CheckAdmitted","","",m$.Fnc.$get(m$.var("YPARA"))))) {
          //<< set YQ=$$$YQDisable("MED01309")                     ;SR18130.2 ;"Cannot create new prescription as patient does not have an active admission"
          mVar YQ = m$.var("YQ");
          YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"MED01309"));
        }
      }
    }
    //<< }                                                       ;SR18130.2
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< BeforeButtonLine()
  public Object BeforeButtonLine(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Patient and Admission data for manual fields
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 16-Nov-2012   shobby  SR18020: Don't need PatientData here.
    //<< ; 05-Nov-2012   SCR     SR18141: Pass in YKEY to PatientData
    //<< ; 19-Oct-2012   SCR     SR18142: Set To Date to $h+1 & set Duration = 1
    //<< ; 21-Jun-2012   shobby  SR18026: Removed code no longer required.
    //<< ; 14-Jun-2012   SCR     Default Infusion Rate to 1
    //<< ; 19-Apr-2012   SCR     Added objLine for manual fields
    //<< ; 28-Mar-2012   SCR     Added New Rx option
    //<< ; 08-Mar-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< //#dim idADM,idPrescription,idRxLine,objPrescription,idPatient,objLine,idItem,idStatus,idLineStatus As %String
    //<< //#dim blnNewRx As %Boolean
    //<< new idADM,idPrescription,idRxLine,objPrescription,idPatient,blnNewRx,idItem,objLine,idStatus,idLineStatus
    mVar idADM = m$.var("idADM");
    mVar idPrescription = m$.var("idPrescription");
    mVar idRxLine = m$.var("idRxLine");
    mVar objPrescription = m$.var("objPrescription");
    mVar idPatient = m$.var("idPatient");
    mVar blnNewRx = m$.var("blnNewRx");
    mVar idItem = m$.var("idItem");
    mVar objLine = m$.var("objLine");
    mVar idStatus = m$.var("idStatus");
    mVar idLineStatus = m$.var("idLineStatus");
    m$.newVar(idADM,idPrescription,idRxLine,objPrescription,idPatient,blnNewRx,idItem,objLine,idStatus,idLineStatus);
    //<< 
    //<< set gPatient=""
    mVar gPatient = m$.var("gPatient");
    gPatient.set("");
    //<< set gAdmission=""
    mVar gAdmission = m$.var("gAdmission");
    gAdmission.set("");
    //<< kill ^CacheTempMedRx(YUSER,"Line")
    m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"Line").kill();
    //<< set blnNewRx=$$$NO ; Used for forcing a new prescription - Set via YPARA via 'New' function
    blnNewRx.set(include.COMSYS.$$$NO(m$));
    //<< set idPrescription=$piece(YKEY,",",1)
    idPrescription.set(m$.Fnc.$piece(m$.var("YKEY").get(),",",1));
    //<< if $get(YPARA)["GridLine," {
    if (mOp.Contains(m$.Fnc.$get(m$.var("YPARA")),"GridLine,")) {
      //<< set ^CacheTemp(YUSER,"GridLine") = $piece(YPARA,",",2)
      m$.var("^CacheTemp",m$.var("YUSER").get(),"GridLine").set(m$.Fnc.$piece(m$.var("YPARA").get(),",",2));
      //<< set YPARA=""
      mVar YPARA = m$.var("YPARA");
      YPARA.set("");
    }
    //<< }
    //<< if (idPrescription="")&&($get(YPARA)="") {
    if ((mOp.Equal(idPrescription.get(),"")) && (mOp.Equal(m$.Fnc.$get(m$.var("YPARA")),""))) {
      //<< set YPARA=$get(^CacheTempMedRx(YUSER,"PID"))_",New"
      mVar YPARA = m$.var("YPARA");
      YPARA.set(mOp.Concat(m$.Fnc.$get(m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"PID")),",New"));
    }
    //<< }
    //<< 
    //<< if idPrescription'="" {
    if (mOp.NotEqual(idPrescription.get(),"")) {
      //<< set objPrescription=$get(^MEDPrescription(YM,idPrescription,1))
      objPrescription.set(m$.Fnc.$get(m$.var("^MEDPrescription",m$.var("YM").get(),idPrescription.get(),1)));
      //<< set idPatient= $$$MEDPrescriptionPatientID(objPrescription)
      idPatient.set(include.MEDConst.$$$MEDPrescriptionPatientID(m$,objPrescription));
      //<< set YPARA=idPatient
      mVar YPARA = m$.var("YPARA");
      YPARA.set(idPatient.get());
    }
    //<< 
    //<< } elseif $get(YPARA)'="" {
    else if (mOp.NotEqual(m$.Fnc.$get(m$.var("YPARA")),"")) {
      //<< set idPatient=YPARA
      idPatient.set(m$.var("YPARA").get());
      //<< if idPatient[",New" {
      if (mOp.Contains(idPatient.get(),",New")) {
        //<< set blnNewRx=$$$YES
        blnNewRx.set(include.COMSYS.$$$YES(m$));
        //<< set idPatient=$piece(idPatient,",New",1)
        idPatient.set(m$.Fnc.$piece(idPatient.get(),",New",1));
        //<< set YPARA=idPatient
        mVar YPARA = m$.var("YPARA");
        YPARA.set(idPatient.get());
      }
    }
    //<< }
    //<< }
    //<< set $$$MEDPrescriptionPatientID(YFELD)=idPatient
    include.MEDConst.$$$MEDPrescriptionPatientIDSet(m$,m$.var("YFELD"),idPatient.get());
    //<< set ^CacheTempMedRx(YUSER,"PID")=idPatient
    m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"PID").set(idPatient.get());
    //<< 
    //<< ;SR18020 do PatientData(.YMFELD,YKEY) ; SR18141
    //<< ;do PatientData(.YMFELD,YFELD)
    //<< if (YKEY="")&&($get(idPatient)'="")&&(blnNewRx'=$$$YES) {
    if ((mOp.Equal(m$.var("YKEY").get(),"")) && (mOp.NotEqual(m$.Fnc.$get(idPatient),"")) && (mOp.NotEqual(blnNewRx.get(),include.COMSYS.$$$YES(m$)))) {
      //<< set idPrescription=$order(^MEDPrescriptions(YM,1,$$$Index(idPatient),""),-1)
      idPrescription.set(m$.Fnc.$order(m$.var("^MEDPrescriptions",m$.var("YM").get(),1,include.MEDConst.$$$Index(m$,idPatient),""),mOp.Negative(1)));
      //<< if idPrescription'="" {
      if (mOp.NotEqual(idPrescription.get(),"")) {
        //<< set objPrescription=$get(^MEDPrescription(YM,idPrescription,1))
        objPrescription.set(m$.Fnc.$get(m$.var("^MEDPrescription",m$.var("YM").get(),idPrescription.get(),1)));
        //<< set YKEY = idPrescription
        mVar YKEY = m$.var("YKEY");
        YKEY.set(idPrescription.get());
        //<< set idRxLine=$order(^MEDPrescriptionLine(YM,idPrescription,""),-1)
        idRxLine.set(m$.Fnc.$order(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),idPrescription.get(),""),mOp.Negative(1)));
        //<< if idRxLine'="" {
        if (mOp.NotEqual(idRxLine.get(),"")) {
        }
      }
    }
    //<< ;set YKEY=idPrescription_","_idRxLine
    //<< }
    //<< 
    //<< }
    //<< }
    //<< if (YKEY="") && ($get(idPatient)'="") {
    if ((mOp.Equal(m$.var("YKEY").get(),"")) && (mOp.NotEqual(m$.Fnc.$get(idPatient),""))) {
      //<< set YKEY=$$CreateBlankRx(idPatient)
      mVar YKEY = m$.var("YKEY");
      YKEY.set(m$.fnc$("CreateBlankRx",idPatient.get()));
      //<< set idPrescription=YKEY
      idPrescription.set(YKEY.get());
    }
    //<< }
    //<< if ($$$MEDPrescriptionStatus($get(objPrescription))>0) &&('$data(^CacheTemp(YUSER,"GridLine"))) { ; if not open and no line select
    if ((mOp.Greater(include.MEDConst.$$$MEDPrescriptionStatus(m$,m$.Fnc.$get(objPrescription)),0)) && (mOp.Not(m$.Fnc.$data(m$.var("^CacheTemp",m$.var("YUSER").get(),"GridLine"))))) {
      //<< set ^CacheTemp(YUSER,"GridLine")=$order(^MEDPrescriptionLine(YM,$piece(YKEY,","),"")) ; set it 1st line
      m$.var("^CacheTemp",m$.var("YUSER").get(),"GridLine").set(m$.Fnc.$order(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),m$.Fnc.$piece(m$.var("YKEY").get(),","),"")));
      //<< set $piece(YKEY,",",2) = ^CacheTemp(YUSER,"GridLine")
      m$.pieceVar(m$.var("YKEY"),",",2).set(m$.var("^CacheTemp",m$.var("YUSER").get(),"GridLine").get());
    }
    //<< }
    //<< 
    //<< 
    //<< set objLine=""
    objLine.set("");
    //<< if ($piece(YKEY,",",2)'="") {
    if ((mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),",",2),""))) {
      //<< set objLine=$get(^MEDPrescriptionLine(YM,idPrescription,$piece(YKEY,",",2),1)) ; used by manual fields
      objLine.set(m$.Fnc.$get(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),idPrescription.get(),m$.Fnc.$piece(m$.var("YKEY").get(),",",2),1)));
      //<< set ^CacheTempMedRx(YUSER,"Line") = $piece(YKEY,",",2) ; Current Line  , FIXME - need to be checked
      m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"Line").set(m$.Fnc.$piece(m$.var("YKEY").get(),",",2));
      //<< 
      //<< do Solution^MEDPrescriptionSolLine($$$MEDPrescriptionLineSolution(objLine))
      m$.Cmd.Do("MEDPrescriptionSolLine.Solution",include.MEDConst.$$$MEDPrescriptionLineSolution(m$,objLine));
      //<< set idLineStatus =  $$$MEDPrescriptionLineStatus(objLine)
      idLineStatus.set(include.MEDConst.$$$MEDPrescriptionLineStatus(m$,objLine));
    }
    //<< 
    //<< 
    //<< } else {
    else {
      //<< set $piece(YMFELD,Y,19) = "."
      m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),19).set(".");
      //<< set $piece(YMFELD,Y,20) = $ztime($piece($h,",",2),2)
      m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),20).set(m$.Fnc.$ztime(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),2));
      //<< set $piece(YMFELD,Y,21) = 1     ; SR18142
      m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),21).set(1);
      //<< set $piece(YMFELD,Y,22) = $h+1  ; SR18142
      m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),22).set(mOp.Add(m$.Fnc.$horolog(),1));
      //<< ;set $piece(YMFELD,Y,22) = "."
      //<< set $piece(YMFELD,Y,23) = $ztime($piece($h,",",2),2)
      m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),23).set(m$.Fnc.$ztime(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),2));
      //<< set idLineStatus = 0
      idLineStatus.set(0);
    }
    //<< 
    //<< }
    //<< set $piece(YMFELD,Y,1) = $piece(YKEY,",",1)
    m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.var("YKEY").get(),",",1));
    //<< set idStatus= +$$$MEDPrescriptionStatus($get(objPrescription))
    idStatus.set(mOp.Positive(include.MEDConst.$$$MEDPrescriptionStatus(m$,m$.Fnc.$get(objPrescription))));
    //<< set $piece(YMFELD,Y,11) = $$GetDescription^WWWStatus("MEDPrescription",+idStatus,$get(SPRACHE))
    m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),11).set(m$.fnc$("WWWStatus.GetDescription","MEDPrescription",mOp.Positive(idStatus.get()),m$.Fnc.$get(m$.var("SPRACHE"))));
    //<< set $piece(YMFELD,Y,13) = $$GetDescription^WWWStatus("MEDPrescription",+idLineStatus,$get(SPRACHE))
    m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),13).set(m$.fnc$("WWWStatus.GetDescription","MEDPrescription",mOp.Positive(idLineStatus.get()),m$.Fnc.$get(m$.var("SPRACHE"))));
    //<< 
    //<< if $piece(YKEY,",")'="" {
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),","),"")) {
      //<< 
      //<< if '$$Editable^MEDPrescription($piece(YKEY,","),1) {
      if (mOp.Not(m$.fnc$("MEDPrescription.Editable",m$.Fnc.$piece(m$.var("YKEY").get(),","),1))) {
        //<< set $$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly
        include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
      }
    }
    //<< 
    //<< }
    //<< }
    //<< do LoadDiluentList($get(idItem))
    m$.Cmd.Do("LoadDiluentList",m$.Fnc.$get(idItem));
    //<< set:$piece(YMFELD,Y,33)="" $piece(YMFELD,Y,33)=1 ; Default Infussion Rate
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),33),"")) {
      m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),33).set(1);
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CreateBlankRx(pidPatient)
  public Object CreateBlankRx(Object ... _p) {
    mVar pidPatient = m$.newVarRef("pidPatient",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create a Blank Prescription Header and Save, This allow Grid Edit to load
    //<< ;
    //<< ; Params PID
    //<< ;
    //<< ; Returns YKEY
    //<< ;
    //<< ; History:
    //<< ; 22-Jun-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idRx,objRx,strStatus
    mVar idRx = m$.var("idRx");
    mVar objRx = m$.var("objRx");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idRx,objRx,strStatus);
    //<< 
    //<< set objRx=""
    objRx.set("");
    //<< set $$$MEDPrescriptionProviderNumber(objRx) = $$Default^MEDProviderDataAccess()
    include.MEDConst.$$$MEDPrescriptionProviderNumberSet(m$,objRx,m$.fnc$("MEDProviderDataAccess.Default"));
    //<< set $$$MEDPrescriptionPatientID(objRx)  = pidPatient
    include.MEDConst.$$$MEDPrescriptionPatientIDSet(m$,objRx,pidPatient.get());
    //<< set $$$MEDPrescriptionDueDate(objRx)    = +$h
    include.MEDConst.$$$MEDPrescriptionDueDateSet(m$,objRx,mOp.Positive(m$.Fnc.$horolog()));
    //<< set $$$MEDPrescriptionDueTime(objRx)    = $piece($h,",",2)
    include.MEDConst.$$$MEDPrescriptionDueTimeSet(m$,objRx,m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
    //<< set $$$MEDPrescriptionDateCreated(objRx)= +$h
    include.MEDConst.$$$MEDPrescriptionDateCreatedSet(m$,objRx,mOp.Positive(m$.Fnc.$horolog()));
    //<< if $$$MEDPrescriptionStatus(objRx)="" {
    if (mOp.Equal(include.MEDConst.$$$MEDPrescriptionStatus(m$,objRx),"")) {
      //<< set $$$MEDPrescriptionStatus(objRx)=0
      include.MEDConst.$$$MEDPrescriptionStatusSet(m$,objRx,0);
    }
    //<< }
    //<< set idRx=$$^WWWNEXT("MEDPrescription")
    idRx.set(m$.fnc$("WWWNEXT.main","MEDPrescription"));
    //<< set strStatus=$$$Save("MEDPrescription",idRx,objRx,1)
    strStatus.set(include.COMSYS.$$$Save(m$,"MEDPrescription",idRx,objRx,1));
    //<< quit idRx
    return idRx.get();
  }

  //<< 
  //<< New(pidRx)
  public Object New(Object ... _p) {
    mVar pidRx = m$.newVarRef("pidRx",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; New Prescription for current patient
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 25-Oct-2012       shobby  SR18130.2: Check for valid admission.
    //<< ; 08-May-Apr-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objRx,idPatient,strStatus                           ;SR18130.2
    mVar objRx = m$.var("objRx");
    mVar idPatient = m$.var("idPatient");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objRx,idPatient,strStatus);
    //<< 
    //<< set pidRx=$piece(pidRx,",",1)
    pidRx.set(m$.Fnc.$piece(pidRx.get(),",",1));
    //<< 
    //<< set strStatus=$$CheckAdmitted^MEDPatient("",pidRx)      ;SR18130.2
    strStatus.set(m$.fnc$("MEDPatient.CheckAdmitted","",pidRx.get()));
    //<< if $$$ISOK(strStatus) {                                 ;SR18130.2
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set YPARA=$get(^CacheTempMedRx(YUSER,"PID"))_",New"
      mVar YPARA = m$.var("YPARA");
      YPARA.set(mOp.Concat(m$.Fnc.$get(m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"PID")),",New"));
      //<< Do RedirectForm^COMUtilForm("MEDPrescriptionHosp","","MEDPrescriptionHosp,",YPARA,"")
      m$.Cmd.Do("COMUtilForm.RedirectForm","MEDPrescriptionHosp","","MEDPrescriptionHosp,",YPARA.get(),"");
    }
    //<< } else {                                                ;SR18130.2
    else {
      //<< $$$Alert(strStatus)                                 ;SR18130.2
      include.COMSYS.$$$Alert(m$,strStatus);
      //<< do ReloadForm^COMUtilForm()                         ;SR18130.2
      m$.Cmd.Do("COMUtilForm.ReloadForm");
    }
    //<< }                                                       ;SR18130.2
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PatientData(&pstrYMFELD,pidRx)
  public Object PatientData(Object ... _p) {
    mVar pstrYMFELD = m$.newVarRef("pstrYMFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidRx = m$.newVarRef("pidRx",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Patient and Admission data for manual fields
    //<< ;
    //<< ; Inputs:   Manual field data (YMFELD)
    //<< ;           Current ID
    //<< ;
    //<< ; Returns: Data to Display
    //<< ;
    //<< ; History:
    //<< ; 16-Nov-2012   shobby  SR18020: Now redundant?
    //<< ; 05-Nov-2012   SCR     SR18141: Pass in pidRx and use objRx
    //<< ; 05-Nov-2012   SCR     SR18141: Pass CreatedOn for Tracking data & time
    //<< ; 12-Oct-2012   SCR     SR18141: Retain Admission details
    //<< ; 03-Oct-2012   SCR     SR17993: Use Common code
    //<< ; 18-Apr-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< //#dim objPatient,objADM as %String
    //<< new idLoc,strData,idPatient,objPatient,idADM,objADM,objLoc,lstPatData,objRx
    mVar idLoc = m$.var("idLoc");
    mVar strData = m$.var("strData");
    mVar idPatient = m$.var("idPatient");
    mVar objPatient = m$.var("objPatient");
    mVar idADM = m$.var("idADM");
    mVar objADM = m$.var("objADM");
    mVar objLoc = m$.var("objLoc");
    mVar lstPatData = m$.var("lstPatData");
    mVar objRx = m$.var("objRx");
    m$.newVar(idLoc,strData,idPatient,objPatient,idADM,objADM,objLoc,lstPatData,objRx);
    //<< 
    //<< set objRx=""
    objRx.set("");
    //<< set pidRx=$piece(pidRx,",",1)
    pidRx.set(m$.Fnc.$piece(pidRx.get(),",",1));
    //<< set:pidRx'="" objRx=$get(^MEDPrescription(YM,pidRx,1))
    if (mOp.NotEqual(pidRx.get(),"")) {
      objRx.set(m$.Fnc.$get(m$.var("^MEDPrescription",m$.var("YM").get(),pidRx.get(),1)));
    }
    //<< 
    //<< set idPatient = $$$MEDPrescriptionPatientID(objRx)
    idPatient.set(include.MEDConst.$$$MEDPrescriptionPatientID(m$,objRx));
    //<< ;do GetPatientDataViaID^MEDPrescriptionCommon(idPatient, .lstPatData)
    //<< ;do GetPatientDataViaID^MEDPrescriptionCommon(idPatient, .lstPatData, $$$MEDPrescriptionDateCreated(pstrYFELD)) ; SR18141
    //<< do GetPatientDataViaID^MEDPrescriptionCommon(idPatient, .lstPatData, $$$MEDPrescriptionCreatedOn(objRx)) ; SR18141
    m$.Cmd.Do("MEDPrescriptionCommon.GetPatientDataViaID",idPatient.get(),lstPatData,include.MEDConst.$$$MEDPrescriptionCreatedOn(m$,objRx));
    //<< // 1. Admission Location Key
    //<< // 2.
    //<< ;SR18020 // 3. Patient Name
    //<< ;SR18020 // 4. Patient ID
    //<< ;SR18020 // 5. Patient DOB
    //<< ;SR18020 // 6. Admission Location Name
    //<< ;SR18020 // 7. Admission Room
    //<< ;SR18020 // 8. Admission Bed
    //<< ;SR18020 // 9. Admission Date
    //<< ;SR18020 // 10. Patient Allergies
    //<< ;SR18020 set $piece(pstrYMFELD,Y,3) = $lg(lstPatData,3) ; Name
    //<< ;SR18020 set $piece(pstrYMFELD,Y,4) = idPatient  ; PID
    //<< ;SR18020 set $piece(pstrYMFELD,Y,5) = $lg(lstPatData,5)  ;Years Old  Dob + Age
    //<< 
    //<< ;SR18020 set $piece(pstrYMFELD,Y,6) =  $lg(lstPatData,6) ; Admission Location
    //<< ;SR18 020 set $piece(pstrYMFELD,Y,7) =   $lg(lstPatData,7) ; Admission Room
    //<< ;SR18020 set $piece(pstrYMFELD,Y,8) =   $lg(lstPatData,8) ; Admission Bed
    //<< ;SR18020 set $piece(pstrYMFELD,Y,9) =   $lg(lstPatData,9) ; Admission Date & Time
    //<< ;SR18020 set $piece(pstrYMFELD,Y,10) =   $lg(lstPatData,10) ; Allergies
    //<< 
    //<< set $piece(pstrYMFELD,Y,3)=""
    m$.pieceVar(pstrYMFELD,m$.var("Y").get(),3).set("");
    //<< quit
    return null;
  }

  //<< 
  //<< ManualData(pintData)
  public Object ManualData(Object ... _p) {
    mVar pintData = m$.newVarRef("pintData",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Patient and Admission data for manual fields
    //<< ;
    //<< ; Inputs: Input Field
    //<< ;
    //<< ; Returns: Data to Display
    //<< ;
    //<< ; History:
    //<< ; 16-Nov-2012   shobby  SR18020: Most of this dont in MEDPatientDetails now.
    //<< ; 19-May-2012   SCR     SR17993: Added Provider
    //<< ; 13-Mar-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< //#dim strData,objLoc,idLoc,idPrescription,objPrescription As %String
    //<< new strData,objLoc,idLoc,idPrescription,objPrescription
    mVar strData = m$.var("strData");
    mVar objLoc = m$.var("objLoc");
    mVar idLoc = m$.var("idLoc");
    mVar idPrescription = m$.var("idPrescription");
    mVar objPrescription = m$.var("objPrescription");
    m$.newVar(strData,objLoc,idLoc,idPrescription,objPrescription);
    //<< set strData=""
    strData.set("");
    //<< if pintData=9 { ; Provider
    if (mOp.Equal(pintData.get(),9)) {
      //<< set idPrescription=$piece(YKEY,",",1)
      idPrescription.set(m$.Fnc.$piece(m$.var("YKEY").get(),",",1));
      //<< if (idPrescription'="") && (idPrescription'="+") {
      if ((mOp.NotEqual(idPrescription.get(),"")) && (mOp.NotEqual(idPrescription.get(),"+"))) {
        //<< set objPrescription=$get(^MEDPrescription(YM,idPrescription,1))
        objPrescription.set(m$.Fnc.$get(m$.var("^MEDPrescription",m$.var("YM").get(),idPrescription.get(),1)));
        //<< set strData=    $$$MEDPrescriptionProviderNumber(objPrescription)
        strData.set(include.MEDConst.$$$MEDPrescriptionProviderNumber(m$,objPrescription));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< 
    //<< quit strData
    return strData.get();
  }

  //<< 
  //<< OnBeforeSave(&pstrYFELD)
  public Object OnBeforeSave(Object ... _p) {
    mVar pstrYFELD = m$.newVarRef("pstrYFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create / Update Prescription Header
    //<< ;
    //<< ; Inputs: record
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 16-Sep-2013   SCR     CORE-93: Set Create Date Conditionaly
    //<< ; 20-Dec-2012   shobby  HEVA-713: Include time in from date/to date validation
    //<< ; 16-Nov-2012   shobby  SR18020: Not using YMFELD for Patient information
    //<< ; 30-Oct-2012   SCR     SR18142: Date validation
    //<< ; 23-Oct-2012   shobby  SR18130.2 : Can't save if no active admission.
    //<< ; 18-Oct-2012   SCR     SR18142: Prevent From date being back dated & To being before from date
    //<< ; 21-Jun-2012   shobby  SR18026: From/To time handle by 'Field Size' setup.
    //<< ; 17-Jun-2012   SCR     SR17993: Added extra Qty validation (Core Rule/Manual Field/Required Field Bug)
    //<< ; 12-Jun-2012   SCR     SR17993:
    //<< ; 04-Jun-2012   SCR     SR17993: Time Validation
    //<< ; 17-May-2012   SCR     SR17993: Set Created Date
    //<< ; 15-Apr-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< //#dim idPrescription,objPrescription,strStatus,idLine As  %String
    //<< new idPrescription,objPrescription,strStatus
    mVar idPrescription = m$.var("idPrescription");
    mVar objPrescription = m$.var("objPrescription");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idPrescription,objPrescription,strStatus);
    //<< 
    //<< set strStatus=$$$OK                                                                             ;SR18130.2
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< ;SR18020 if '$$CheckAdmitted^MEDPatient("","",$piece(YMFELD,Y,4)) {                             ;SR18130.2
    //<< if '$$CheckAdmitted^MEDPatient("","",$$$MEDPrescriptionPatientID(YFELD)) {                      ;SR18130.2 ;SR18020
    if (mOp.Not(m$.fnc$("MEDPatient.CheckAdmitted","","",include.MEDConst.$$$MEDPrescriptionPatientID(m$,m$.var("YFELD"))))) {
      //<< set strStatus=$$$MakeStatus("MED01310")  ; "Patient does not have an active admission"      ;SR18130.2
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"MED01310"));
      //<< set Q=$$$QDontSave                                                                          ;SR18130.2
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
      //<< do ReturnError^COMUtils(strStatus)                                                          ;SR18130.2
      m$.Cmd.Do("COMUtils.ReturnError",strStatus.get());
    }
    //<< }                                                                                               ;SR18130.2
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< if ($piece(YMFELD,Y,24)'="") && ('$piece(YMFELD,Y,25)) {
      if ((mOp.NotEqual(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),24),"")) && (mOp.Not(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),25)))) {
        //<< set Q=$$$QDontSave
        mVar Q = m$.var("Q");
        Q.set(include.COMSYSWWW.$$$QDontSave(m$));
        //<< do ReturnError^COMUtils("MED01280")  ;Diluent Quantity required
        m$.Cmd.Do("COMUtils.ReturnError","MED01280");
      }
      //<< }
      //<< if ($piece(YMFELD,Y,15)'>0) {
      if ((mOp.NotGreater(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),15),0))) {
        //<< set Q=$$$QDontSave
        mVar Q = m$.var("Q");
        Q.set(include.COMSYSWWW.$$$QDontSave(m$));
        //<< do ReturnError^COMUtils("MED01283")  ;Dose must be greater than 0~
        m$.Cmd.Do("COMUtils.ReturnError","MED01283");
      }
      //<< }
      //<< ; SR18142 vvvv
      //<< if $piece(YMFELD,Y,19)<$h {
      if (mOp.Less(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),19),m$.Fnc.$horolog())) {
        //<< set Q=$$$QDontSave
        mVar Q = m$.var("Q");
        Q.set(include.COMSYSWWW.$$$QDontSave(m$));
        //<< do ReturnError^COMUtils("MED01299")  ;From Date can not be back dated
        m$.Cmd.Do("COMUtils.ReturnError","MED01299");
      }
      //<< }
      //<< ;HEVA-713 if $piece(YMFELD,Y,22)'>$piece(YMFELD,Y,19) {
      //<< if ($piece(YMFELD,Y,22)*86400+$piece(YMFELD,Y,23))'>($piece(YMFELD,Y,19)*86400+$piece(YMFELD,Y,20)) {   ;HEVA-713
      if (mOp.NotGreater((mOp.Add(mOp.Multiply(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),22),86400),m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),23))),(mOp.Add(mOp.Multiply(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),19),86400),m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),20))))) {
        //<< set Q=$$$QDontSave
        mVar Q = m$.var("Q");
        Q.set(include.COMSYSWWW.$$$QDontSave(m$));
        //<< do ReturnError^COMUtils("MED01264")  ;'To' date must be greater than 'From' date~
        m$.Cmd.Do("COMUtils.ReturnError","MED01264");
      }
      //<< }
      //<< ; SR18142 ^^^^
      //<< ;SR18020 set $$$MEDPrescriptionPatientID(pstrYFELD) = $piece(YMFELD,Y,4)
      //<< set $$$MEDPrescriptionDueDate(pstrYFELD)    = $piece(YMFELD,Y,19)
      include.MEDConst.$$$MEDPrescriptionDueDateSet(m$,pstrYFELD,m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),19));
      //<< set $$$MEDPrescriptionDueTime(pstrYFELD)    = $piece(YMFELD,Y,20)
      include.MEDConst.$$$MEDPrescriptionDueTimeSet(m$,pstrYFELD,m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),20));
      //<< set:'$$$MEDPrescriptionDateCreated(pstrYFELD) $$$MEDPrescriptionDateCreated(pstrYFELD)= +$h
      if (mOp.Not(include.MEDConst.$$$MEDPrescriptionDateCreated(m$,pstrYFELD))) {
        include.MEDConst.$$$MEDPrescriptionDateCreatedSet(m$,pstrYFELD,mOp.Positive(m$.Fnc.$horolog()));
      }
      //<< if $$$MEDPrescriptionStatus(pstrYFELD)="" {
      if (mOp.Equal(include.MEDConst.$$$MEDPrescriptionStatus(m$,pstrYFELD),"")) {
        //<< set $$$MEDPrescriptionStatus(pstrYFELD)=0
        include.MEDConst.$$$MEDPrescriptionStatusSet(m$,pstrYFELD,0);
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< OnAfterSave(pidPrescription,&pstrYFELD,pstrMFELD)
  public Object OnAfterSave(Object ... _p) {
    mVar pidPrescription = m$.newVarRef("pidPrescription",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrYFELD = m$.newVarRef("pstrYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrMFELD = m$.newVarRef("pstrMFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create / Update Line
    //<< ;
    //<< ; Inputs: key
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Apr-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< //#dim strStatus,idLine,objLine As  %String
    //<< new strStatus,idLine,objLine
    mVar strStatus = m$.var("strStatus");
    mVar idLine = m$.var("idLine");
    mVar objLine = m$.var("objLine");
    m$.newVar(strStatus,idLine,objLine);
    //<< set idLine=$get(^CacheTempMedRx(YUSER,"Line")) ; Current Line
    idLine.set(m$.Fnc.$get(m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"Line")));
    //<< 
    //<< 
    //<< if 'idLine {
    if (mOp.Not(idLine.get())) {
      //<< set idLine=$order(^MEDPrescriptionLine(YM,pidPrescription,""),-1)+1
      idLine.set(mOp.Add(m$.Fnc.$order(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),pidPrescription.get(),""),mOp.Negative(1)),1));
    }
    //<< }
    //<< ;SR18026 set objLine=$get(^MEDPrescriptionLine(YM,pidPrescription,idLine,1))
    //<< ;SR18026 do SetLine(.objLine,pstrMFELD)
    //<< 
    //<< ;SR18026 set strStatus=$$$Save("MEDPrescriptionLine",pidPrescription_","_idLine,objLine,1)
    //<< 
    //<< do ReNumber^MEDPrescriptionRenum(pidPrescription)
    m$.Cmd.Do("MEDPrescriptionRenum.ReNumber",pidPrescription.get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< SetLine(&pobjLine,pstrMFELD)
  public Object SetLine(Object ... _p) {
    mVar pobjLine = m$.newVarRef("pobjLine",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrMFELD = m$.newVarRef("pstrMFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update Line from manual fields
    //<< ;
    //<< ; Inputs: objLine , Manual Filelds
    //<< ;
    //<< ; Returns: objLine by Ref
    //<< ;
    //<< ; History:
    //<< ; 30-May-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< set $$$MEDPrescriptionLineDoseTotalQuantity(pobjLine) = $$DoseTotal^MEDPrescriptionLine(pobjLine)
    include.MEDConst.$$$MEDPrescriptionLineDoseTotalQuantitySet(m$,pobjLine,m$.fnc$("MEDPrescriptionLine.DoseTotal",pobjLine.get()));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBlurItem(pYKEY, pidGridRow, pidItem,pidUnit,pidFreq,pidRoute,pidDiluent)
  public Object OnBlurItem(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidGridRow = m$.newVarRef("pidGridRow",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidUnit = m$.newVarRef("pidUnit",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pidFreq = m$.newVarRef("pidFreq",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pidRoute = m$.newVarRef("pidRoute",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pidDiluent = m$.newVarRef("pidDiluent",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; On Blur from Item
    //<< ;   Populates Unit dropdown
    //<< ;
    //<< ; Called By : form $MEDPrescriptionLine & MEDPrescriptionHospLine
    //<< ;
    //<< ; Params:   Key,grow,item
    //<< ;           Unit, Fequency,Route, Diluent, Total Dose Quantity (field numbers)
    //<< ;
    //<< ;
    //<< ; ByRefs:   pobjLine    - current line object
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History :
    //<< ; 29-Jan-2013   SCR     HEVA-762: Disabled call to DrugInteraction
    //<< ; 23-Jan-2013   shobby  HEVA-762: Reenable call to DrugInteraction
    //<< ; 24-Oct-2012   SCR     SR18138: Update Volume
    //<< ; 10-Oct-2012   SCR     SR18139: Use Frequency function
    //<< ; 29-Jun-2012   SCR     SR17993: Added Total Dose Quantity update
    //<< ; 25-Jun-2012   SCR     SR17993: Update Grid
    //<< ; 05-Jun-2012   SCR     SR17993: Added Diluent
    //<< ; 16-Apr-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objItem,strLineKey,objLine,intGridLine,arrGrid,idUnit
    mVar objItem = m$.var("objItem");
    mVar strLineKey = m$.var("strLineKey");
    mVar objLine = m$.var("objLine");
    mVar intGridLine = m$.var("intGridLine");
    mVar arrGrid = m$.var("arrGrid");
    mVar idUnit = m$.var("idUnit");
    m$.newVar(objItem,strLineKey,objLine,intGridLine,arrGrid,idUnit);
    //<< 
    //<< //Populate Unit Listing
    //<< set idUnit=$$UpdateUnits^INARTUNIT(pidItem,"Y"_YFORM_pidUnit)
    idUnit.set(m$.fnc$("INARTUNIT.UpdateUnits",pidItem.get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),pidUnit.get())));
    //<< do UpdateDiluent(pidItem,"Y"_YFORM_pidDiluent)
    m$.Cmd.Do("UpdateDiluent",pidItem.get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),pidDiluent.get()));
    //<< if pidItem'="" {
    if (mOp.NotEqual(pidItem.get(),"")) {
      //<< set objItem = $get(^INART(0,pidItem,1))
      objItem.set(m$.Fnc.$get(m$.var("^INART",0,pidItem.get(),1)));
      //<< ;set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_pidFreq_"~"_$$$INARTMedFrequency(objItem)
      //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_pidFreq_"~"_$$Frequency(objItem) ; SR18139
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),pidFreq.get()),"~"),m$.fnc$("Frequency",objItem.get())));
      //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_pidRoute_"~"_$$$INARTMedRouteOfAdministration(objItem)
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),pidRoute.get()),"~"),include.INConst.$$$INARTMedRouteOfAdministration(m$,objItem)));
      //<< do UpdateGrid^COMGridEdit31Links("Y"_YFORM_pidUnit,idUnit,"",1)
      m$.Cmd.Do("COMGridEdit31Links.UpdateGrid",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),pidUnit.get()),idUnit.get(),"",1);
      //<< ;do UpdateGrid^COMGridEdit31Links("Y"_YFORM_pidFreq,$$$INARTMedFrequency(objItem),"",1)
      //<< do UpdateGrid^COMGridEdit31Links("Y"_YFORM_pidFreq,$$Frequency(objItem),"",1)  ; SR18139
      m$.Cmd.Do("COMGridEdit31Links.UpdateGrid",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),pidFreq.get()),m$.fnc$("Frequency",objItem.get()),"",1);
      //<< do UpdateGrid^COMGridEdit31Links("Y"_YFORM_pidRoute,$$$INARTMedRouteOfAdministration(objItem),"",1)
      m$.Cmd.Do("COMGridEdit31Links.UpdateGrid",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),pidRoute.get()),include.INConst.$$$INARTMedRouteOfAdministration(m$,objItem),"",1);
    }
    //<< 
    //<< }
    //<< do VolumeUpdate() ; SR18138
    m$.Cmd.Do("VolumeUpdate");
    //<< ;do DrugInteraction(pYKEY,pidItem,"MEDPrescriptionHospLine") ;HEVA-762
    //<< quit
    return null;
  }

  //<< 
  //<< Frequency(pobjItem)
  public Object Frequency(Object ... _p) {
    mVar pobjItem = m$.newVarRef("pobjItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Defualt Frequency
    //<< ;   1st from item if none use MEDPresciptionSetup
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Oct-2012   SCR     SR18139: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idFreq,objSetup
    mVar idFreq = m$.var("idFreq");
    mVar objSetup = m$.var("objSetup");
    m$.newVar(idFreq,objSetup);
    //<< set idFreq=$$$INARTMedFrequency(pobjItem)
    idFreq.set(include.INConst.$$$INARTMedFrequency(m$,pobjItem));
    //<< if idFreq="" {
    if (mOp.Equal(idFreq.get(),"")) {
      //<< set objSetup=$get(^MEDPrescriptionSetup(0,YM,1))
      objSetup.set(m$.Fnc.$get(m$.var("^MEDPrescriptionSetup",0,m$.var("YM").get(),1)));
      //<< set idFreq  = $$$MEDPrescriptionSetupDefaultFrequency(objSetup)
      idFreq.set(include.MEDConst.$$$MEDPrescriptionSetupDefaultFrequency(m$,objSetup));
    }
    //<< }
    //<< quit idFreq
    return idFreq.get();
  }

  //<< 
  //<< UpdateTDQ(pintItem,pintDose,pintFreq,pintDur,pintTDQ,pintFromDate,pintFromTime,pintToDate,pintToTime)
  public Object UpdateTDQ(Object ... _p) {
    mVar pintItem = m$.newVarRef("pintItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintDose = m$.newVarRef("pintDose",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintFreq = m$.newVarRef("pintFreq",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintDur = m$.newVarRef("pintDur",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pintTDQ = m$.newVarRef("pintTDQ",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pintFromDate = m$.newVarRef("pintFromDate",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pintFromTime = m$.newVarRef("pintFromTime",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pintToDate = m$.newVarRef("pintToDate",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar pintToTime = m$.newVarRef("pintToTime",(((_p!=null)&&(_p.length>=9))?_p[8]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update Total Dose Quantity on blur
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Dec-2012   shobby  HEVA-713: Use date/time in calculation
    //<< ; 29-Jun-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objLine,intTDQ
    mVar objLine = m$.var("objLine");
    mVar intTDQ = m$.var("intTDQ");
    m$.newVar(objLine,intTDQ);
    //<< 
    //<< if pintTDQ {
    if (mOp.Logical(pintTDQ.get())) {
      //<< set objLine=""
      objLine.set("");
      //<< set $$$MEDPrescriptionLineItem(objLine)     = $piece(YMFELD,Y,pintItem)
      include.MEDConst.$$$MEDPrescriptionLineItemSet(m$,objLine,m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),pintItem.get()));
      //<< set $$$MEDPrescriptionLineDoseQty(objLine)  = $piece(YMFELD,Y,pintDose)
      include.MEDConst.$$$MEDPrescriptionLineDoseQtySet(m$,objLine,m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),pintDose.get()));
      //<< set $$$MEDPrescriptionLineFrequency(objLine)= $piece(YMFELD,Y,pintFreq)
      include.MEDConst.$$$MEDPrescriptionLineFrequencySet(m$,objLine,m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),pintFreq.get()));
      //<< set $$$MEDPrescriptionLineDuration(objLine) = $piece(YMFELD,Y,pintDur)
      include.MEDConst.$$$MEDPrescriptionLineDurationSet(m$,objLine,m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),pintDur.get()));
      //<< 
      //<< set $$$MEDPrescriptionLineFromDate(objLine) = $piece(YMFELD,Y,pintFromDate) ;HEVA-713
      include.MEDConst.$$$MEDPrescriptionLineFromDateSet(m$,objLine,m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),pintFromDate.get()));
      //<< set $$$MEDPrescriptionLineFromTime(objLine) = $piece(YMFELD,Y,pintFromTime) ;HEVA-713
      include.MEDConst.$$$MEDPrescriptionLineFromTimeSet(m$,objLine,m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),pintFromTime.get()));
      //<< set $$$MEDPrescriptionLineToDate(objLine) = $piece(YMFELD,Y,pintToDate)     ;HEVA-713
      include.MEDConst.$$$MEDPrescriptionLineToDateSet(m$,objLine,m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),pintToDate.get()));
      //<< set $$$MEDPrescriptionLineToTime(objLine) = $piece(YMFELD,Y,pintToTime)     ;HEVA-713
      include.MEDConst.$$$MEDPrescriptionLineToTimeSet(m$,objLine,m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),pintToTime.get()));
      //<< set intTDQ=$$DoseTotal^MEDPrescriptionLine(objLine)
      intTDQ.set(m$.fnc$("MEDPrescriptionLine.DoseTotal",objLine.get()));
      //<< 
      //<< ;set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M"_pintTDQ_"~"_intTDQ
      //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M"_pintTDQ_"~"_$$UpdateManualField^WWWFORMUtil(YFORM,pintTDQ,intTDQ)  ;HEVA-775
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M"),pintTDQ.get()),"~"),m$.fnc$("WWWFORMUtil.UpdateManualField",m$.var("YFORM").get(),pintTDQ.get(),intTDQ.get())));
      //<< set $piece(YMFELD,Y,pintTDQ)=intTDQ
      m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),pintTDQ.get()).set(intTDQ.get());
      //<< do UpdateGrid^COMGridEdit31Links("Y"_YFORM_"M"_pintTDQ,intTDQ,"",1)
      m$.Cmd.Do("COMGridEdit31Links.UpdateGrid",mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),pintTDQ.get()),intTDQ.get(),"",1);
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< OnBlurDur(&pobjMData,&pintDur,pidTo,pintFrom,pintDurFld,&pstrFrom)
  public Object OnBlurDur(Object ... _p) {
    mVar pobjMData = m$.newVarRef("pobjMData",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintDur = m$.newVarRef("pintDur",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidTo = m$.newVarRef("pidTo",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintFrom = m$.newVarRef("pintFrom",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pintDurFld = m$.newVarRef("pintDurFld",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pstrFrom = m$.newVarRef("pstrFrom",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; On Blur Duration or From Date - Update To Date based on Duration and From Date
    //<< ; Used by MEDPrescriptionHosp & MEDPrescriptionSol
    //<< ;
    //<< ; Inputs: Line , Duration (passback)
    //<< ;       To Date, From Date, Duration, Total Dose Quantity fields
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Jan-2013   shobby  HEVA-713.3: Corrected setting of tmeTo
    //<< ; 20-Dec-2012   shobby  HEVA-713: Rewrote
    //<< ; 31-Oct-2012   SCR     SR18142: Send Back From Date Text
    //<< ; 18-Jul-2012   SCR     SR17993: Update Grid (Required for actual Save)
    //<< ; 29-Jun-2012   SCR     SR17993: Update Total Dose Quantity
    //<< ; 15-May-2012   PPP     SR17993: Convert date from External to Internal
    //<< ; 17-Apr-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< //#dim strText as  %String
    //<< ;#dim intDur as %Integer
    //<< new strText,intDur,dtTo,dtFrom
    mVar strText = m$.var("strText");
    mVar intDur = m$.var("intDur");
    mVar dtTo = m$.var("dtTo");
    mVar dtFrom = m$.var("dtFrom");
    m$.newVar(strText,intDur,dtTo,dtFrom);
    //<< new idToTme
    mVar idToTme = m$.var("idToTme");
    m$.newVar(idToTme);
    //<< 
    //<< set idToTme="M"_($extract(pidTo,2,3)+1)
    idToTme.set(mOp.Concat("M",(mOp.Add(m$.Fnc.$extract(pidTo.get(),2,3),1))));
    //<< set intDur  = $piece(pobjMData,Y,pintDurFld)
    intDur.set(m$.Fnc.$piece(pobjMData.get(),m$.var("Y").get(),pintDurFld.get()));
    //<< if intDur<0 {
    if (mOp.Less(intDur.get(),0)) {
      //<< set intDur=0
      intDur.set(0);
      //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M"_pintDurFld_"~"_intDur
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M"),pintDurFld.get()),"~"),intDur.get()));
      //<< set pintDur=intDur
      pintDur.set(intDur.get());
      //<< set $piece(pobjMData,Y,pintDurFld)=pintDur ; Required
      m$.pieceVar(pobjMData,m$.var("Y").get(),pintDurFld.get()).set(pintDur.get());
    }
    //<< }
    //<< set dtFrom  = $piece(pobjMData,Y,pintFrom)_","_$piece(pobjMData,Y,pintFrom+1)
    dtFrom.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(pobjMData.get(),m$.var("Y").get(),pintFrom.get()),","),m$.Fnc.$piece(pobjMData.get(),m$.var("Y").get(),mOp.Add(pintFrom.get(),1))));
    //<< set strDateTime    = $$$ToSeconds(dtFrom)+(intDur*86400)
    mVar strDateTime = m$.var("strDateTime");
    strDateTime.set(mOp.Add(include.COMSYSDate.$$$ToSeconds(m$,dtFrom),(mOp.Multiply(intDur.get(),86400))));
    //<< set dtTo    = strDateTime\86400
    dtTo.set(mOp.IntegerDivide(strDateTime.get(),86400));
    //<< set tmeTo   = strDateTime-(dtTo*86400)
    mVar tmeTo = m$.var("tmeTo");
    tmeTo.set(mOp.Subtract(strDateTime.get(),(mOp.Multiply(dtTo.get(),86400))));
    //<< set strText = $$^WWWTR(0,1,dtTo)
    strText.set(m$.fnc$("WWWTR.main",0,1,dtTo.get()));
    //<< set %TXT(1) = %TXT(1)_"#"_"Y"_YFORM_pidTo_"~"_strText
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),pidTo.get()),"~"),strText.get()));
    //<< set strText = $$OutTime^WWWTR(tmeTo)
    strText.set(m$.fnc$("WWWTR.OutTime",tmeTo.get()));
    //<< set strText = $extract(strText,1,5)
    strText.set(m$.Fnc.$extract(strText.get(),1,5));
    //<< set %TXT(1) = %TXT(1)_"#"_"Y"_YFORM_idToTme_"~"_strText
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),idToTme.get()),"~"),strText.get()));
    //<< set $piece(pobjMData,Y,22)=dtTo
    m$.pieceVar(pobjMData,m$.var("Y").get(),22).set(dtTo.get());
    //<< set $piece(pobjMData,Y,23)=tmeTo
    m$.pieceVar(pobjMData,m$.var("Y").get(),23).set(tmeTo.get());
    //<< do UpdateGrid^COMGridEdit31Links("Y"_YFORM_pidTo,dtTo,"",1)
    m$.Cmd.Do("COMGridEdit31Links.UpdateGrid",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),pidTo.get()),dtTo.get(),"",1);
    //<< do UpdateGrid^COMGridEdit31Links("Y"_YFORM_idToTme,tmeTo,"",1)
    m$.Cmd.Do("COMGridEdit31Links.UpdateGrid",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),idToTme.get()),tmeTo.get(),"",1);
    //<< if YFORM="MEDPrescriptionHosp" do UpdateTDQ^MEDPrescriptionHosp(14,15,17,21,34,19,20,22,23) ;HEVA-713
    if (mOp.Equal(m$.var("YFORM").get(),"MEDPrescriptionHosp")) {
      m$.Cmd.Do("MEDPrescriptionHosp.UpdateTDQ",14,15,17,21,34,19,20,22,23);
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ;HEVA-713 OnBlurDurOld(&pobjMData,&pintDur,pidTo,pintFrom,pintDurFld,&pstrFrom)
  //<< ;HEVA-713 ;-------------------------------------------------------------------------------
  //<< ;HEVA-713 ; On Blur Duration or From Date - Update To Date based on Duration and From Date
  //<< ;HEVA-713 ; Used by MEDPrescriptionHosp & MEDPrescriptionSol
  //<< ;HEVA-713 ;
  //<< ;HEVA-713 ; Inputs: Line , Duration (passback)
  //<< ;HEVA-713 ;     To Date, From Date, Duration, Total Dose Quantity fields
  //<< ;HEVA-713 ;
  //<< ;HEVA-713 ; Returns:
  //<< ;HEVA-713 ;
  //<< ;HEVA-713 ; History:
  //<< ;HEVA-713 ; 31-Oct-2012 SCR     SR18142: Send Back From Date Text
  //<< ;HEVA-713 ; 18-Jul-2012 SCR     SR17993: Update Grid (Required for actual Save)
  //<< ;HEVA-713 ; 29-Jun-2012 SCR     SR17993: Update Total Dose Quantity
  //<< ;HEVA-713 ; 15-May-2012 PPP     SR17993: Convert date from External to Internal
  //<< ;HEVA-713 ; 17-Apr-2012 SCR     SR17993: Created
  //<< ;HEVA-713 ;-------------------------------------------------------------------------------
  //<< ;HEVA-713 #dim strText as  %String
  //<< ;HEVA-713 #dim intDur as %Integer
  //<< ;HEVA-713 new strText,intDur,dtTo,dtFrom
  //<< 
  //<< ;HEVA-713 set intDur    = $piece(pobjMData,Y,pintDurFld)
  //<< ;HEVA-713 if intDur<0 {
  //<< ;HEVA-713   set intDur=0
  //<< ;HEVA-713   set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M"_pintDurFld_"~"_intDur
  //<< ;HEVA-713   set pintDur=intDur
  //<< ;HEVA-713   set $piece(pobjMData,Y,pintDurFld)=pintDur ; Required
  //<< ;HEVA-713 }
  //<< ;HEVA-713 set dtFrom    = $$^WWWTR(1,1,$piece(pobjMData,Y,pintFrom))    ;SR18142
  //<< ;HEVA-713 set pstrFrom= $$^WWWTR(0,1,dtFrom)                            ;SR18142
  //<< ;HEVA-713 set dtTo  = (dtFrom+intDur)                               ;SR18142
  //<< ;HEVA-713 ;set dtTo = ($$^WWWTR(1,1,$piece(pobjMData,Y,pintFrom))+intDur)
  //<< ;HEVA-713 set strText = $$^WWWTR(0,1,dtTo)
  //<< ;HEVA-713 set %TXT(1)   = %TXT(1)_"#"_"Y"_YFORM_pidTo_"~"_strText
  //<< ;HEVA-713 set $piece(pobjMData,Y,22)=dtTo
  //<< ;HEVA-713 do UpdateGrid^COMGridEdit31Links("Y"_YFORM_pidTo,dtTo,"",1)
  //<< ;HEVA-713 do UpdateTDQ^MEDPrescriptionHosp(14,15,17,21,34) ;HEVA-713
  //<< ;HEVA-713 quit
  //<< 
  //<< 
  //<< OnBlurDiag(pidDiag,pintDescFld)
  public Object OnBlurDiag(Object ... _p) {
    mVar pidDiag = m$.newVarRef("pidDiag",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintDescFld = m$.newVarRef("pintDescFld",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; On Blur Diag, Update Description field
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Jul-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strDesc
    mVar strDesc = m$.var("strDesc");
    m$.newVar(strDesc);
    //<< set strDesc=""
    strDesc.set("");
    //<< if pidDiag'="" {
    if (mOp.NotEqual(pidDiag.get(),"")) {
      //<< set strDesc= $$$MEDICDDescription($get(^MEDICD(YM,pidDiag,1)))
      strDesc.set(include.MEDConst.$$$MEDICDDescription(m$,m$.Fnc.$get(m$.var("^MEDICD",m$.var("YM").get(),pidDiag.get(),1))));
    }
    //<< }
    //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M"_pintDescFld_"~"_strDesc
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M"),pintDescFld.get()),"~"),strDesc.get()));
    //<< quit
    return null;
  }

  //<< 
  //<< OnBlurTime(&YMFELD)
  public Object OnBlurTime(Object ... _p) {
    mVar YMFELD = m$.newVarRef("YMFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Updates the duration field based on a change of any of the date/time fields
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Jan-2013   shobby  HEVA-774: Updated the grid before the value is changed in the header form
    //<< ;                           to reflect the number formatting.
    //<< ; 03-Jan-2013   shobby  HEVA-713.3: Improve accuracy of duration calculations.
    //<< ; 20-Dec-2012   shobby  HEVA-713: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new fltDur,intDurField
    mVar fltDur = m$.var("fltDur");
    mVar intDurField = m$.var("intDurField");
    m$.newVar(fltDur,intDurField);
    //<< if YFORM="MEDPrescriptionHosp" {
    if (mOp.Equal(m$.var("YFORM").get(),"MEDPrescriptionHosp")) {
      //<< set fltDur=$$$DateDiff($piece(YMFELD,Y,19)_","_$piece(YMFELD,Y,20),$piece(YMFELD,Y,22)_","_$piece(YMFELD,Y,23))
      fltDur.set(include.COMSYSDate.$$$DateDiff(m$,mOp.Concat(mOp.Concat(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),19),","),m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),20)),mOp.Concat(mOp.Concat(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),22),","),m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),23))));
      //<< set intDurField=21
      intDurField.set(21);
    }
    //<< } elseif YFORM="MEDPrescriptionSol" {
    else if (mOp.Equal(m$.var("YFORM").get(),"MEDPrescriptionSol")) {
      //<< set fltDur=$$$DateDiff($piece(YMFELD,Y,17)_","_$piece(YMFELD,Y,18),$piece(YMFELD,Y,20)_","_$piece(YMFELD,Y,21))
      fltDur.set(include.COMSYSDate.$$$DateDiff(m$,mOp.Concat(mOp.Concat(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),17),","),m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),18)),mOp.Concat(mOp.Concat(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),20),","),m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),21))));
      //<< set intDurField=19
      intDurField.set(19);
    }
    //<< }
    //<< set fltDur=fltDur/86400
    fltDur.set(mOp.Divide(fltDur.get(),86400));
    //<< set $piece(YMFELD,Y,intDurField)=fltDur
    m$.pieceVar(YMFELD,m$.var("Y").get(),intDurField.get()).set(fltDur.get());
    //<< do UpdateGrid^COMGridEdit31Links("Y"_YFORM_"M"_intDurField,fltDur,"",1) ;HEVA-774
    m$.Cmd.Do("COMGridEdit31Links.UpdateGrid",mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),intDurField.get()),fltDur.get(),"",1);
    //<< set fltDur=$$GetLiteral^WWWTR(12,fltDur)
    fltDur.set(m$.fnc$("WWWTR.GetLiteral",12,fltDur.get()));
    //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M"_intDurField_"~"_fltDur
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M"),intDurField.get()),"~"),fltDur.get()));
    //<< if YFORM="MEDPrescriptionHosp" do UpdateTDQ^MEDPrescriptionHosp(14,15,17,21,34,19,20,22,23) ;HEVA-713
    if (mOp.Equal(m$.var("YFORM").get(),"MEDPrescriptionHosp")) {
      m$.Cmd.Do("MEDPrescriptionHosp.UpdateTDQ",14,15,17,21,34,19,20,22,23);
    }
    //<< ;if YFORM="MEDPrescriptionSol" do UpdateTDQ^MEDPrescriptionHosp(14,15,17,21,34,17,18,20,21) ;HEVA-713
    //<< quit fltDur
    return fltDur.get();
  }

  //<< 
  //<< ;HEVA-713 OnBlurTo(pobjMData,pidDur,pintFrom,pintTo,&pstrDate)
  //<< ;HEVA-713 ;-------------------------------------------------------------------------------
  //<< ;HEVA-713 ; On Blur To Date - Update Duration and From & To Dates
  //<< ;HEVA-713 ; Used by MEDPrescriptionHosp & MEDPrescriptionSol
  //<< ;HEVA-713 ;
  //<< ;HEVA-713 ; Inputs: Line
  //<< ;HEVA-713 ;
  //<< ;HEVA-713 ; Returns:
  //<< ;HEVA-713 ;
  //<< ;HEVA-713 ; History:
  //<< ;HEVA-713 ; 01-Nov-2012 SCR     SR18142: Turn off error message (Stops reformating date)
  //<< ;HEVA-713 ; 31-Oct-2012 SCR     SR18142: Send Back 'To Date' Text
  //<< ;HEVA-713 ; 29-Oct-2012 SCR     SR18142: Update Grid and YMFELD
  //<< ;HEVA-713 ; 24-May-2012 SCR     SR17993: Created
  //<< ;HEVA-713 ;-------------------------------------------------------------------------------
  //<< ;HEVA-713 #dim intDur,intTo,intFrom as  %String
  //<< ;HEVA-713 new intDur,intTo,intFrom
  //<< ;HEVA-713 set intTo=$piece(pobjMData,Y,pintTo)
  //<< ;HEVA-713 set intFrom=$piece(pobjMData,Y,pintFrom)
  //<< ;HEVA-713 if +intTo'=intTo {
  //<< ;HEVA-713   set intTo=$$^WWWTR(1,1,intTo)
  //<< ;HEVA-713 }
  //<< ;HEVA-713 if +intFrom'=intFrom {
  //<< ;HEVA-713   set intFrom=$$^WWWTR(1,1,intFrom)
  //<< ;HEVA-713 }
  //<< ;HEVA-713 set pstrDate=$$^WWWTR(0,1,intTo)  ;SR18142
  //<< ;HEVA-713 set intDur = (intTo-intFrom)
  //<< ;HEVA-713 ;HEVA-713 if intDur<1 {
  //<< ;HEVA-713   ;set %TXT(1)=%TXT(1)_"!"_$$$Text("MED01264")  ;'To' date greater than 'From' date
  //<< ;HEVA-713 ;HEVA-713 } else {
  //<< ;HEVA-713   ;set:+intDur=0 intDur=1
  //<< ;HEVA-713   set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_pidDur_"~"_intDur
  //<< ;HEVA-713   set $piece(pobjMData,Y,+$extract(pidDur,2,4))=intDur            ; SR18142
  //<< ;HEVA-713   do UpdateGrid^COMGridEdit31Links("Y"_YFORM_pidDur,intDur,"",1)  ; SR18142
  //<< ;HEVA-713 ;HEVA-713 }
  //<< ;HEVA-713 do UpdateTDQ^MEDPrescriptionHosp(14,15,17,21,34,17,18,20,21) ;HEVA-713
  //<< ;HEVA-713 quit
  //<< 
  //<< OnBlurDose(&pobjMData,pidDose)
  public Object OnBlurDose(Object ... _p) {
    mVar pobjMData = m$.newVarRef("pobjMData",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidDose = m$.newVarRef("pidDose",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; On Blur Dose - Must be greater than 0
    //<< ; Used by MEDPrescriptionHosp
    //<< ;
    //<< ; Inputs: Line id
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Feb-2013   SCR     HEVA-800: Convert number based on region
    //<< ; 07-Feb-2013   SCR     HEVA-800: Round to 2 dp
    //<< ; 24-Oct-2012   SCR     SR18138: Update Volume
    //<< ; 29-Jun-2012   SCR     SR17993: Update Total Dose Quantity
    //<< ; 20-Jun-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new fltDose
    mVar fltDose = m$.var("fltDose");
    m$.newVar(fltDose);
    //<< set fltDose=$piece(pobjMData,Y,pidDose)
    fltDose.set(m$.Fnc.$piece(pobjMData.get(),m$.var("Y").get(),pidDose.get()));
    //<< set fltDose = $$RoundDose^MEDPrescriptionCommon(fltDose) ; HEVA-800
    fltDose.set(m$.fnc$("MEDPrescriptionCommon.RoundDose",fltDose.get()));
    //<< if (fltDose'>0)&&(fltDose'="") {
    if ((mOp.NotGreater(fltDose.get(),0)) && (mOp.NotEqual(fltDose.get(),""))) {
      //<< set %TXT(1)=%TXT(1)_"!"_$$$Text("MED01283")  ;Dose must be greater than 0~
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"!"),include.COMSYS.$$$Text(m$,"MED01283")));
    }
    //<< } else {
    else {
      //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M"_pidDose_"~"_$$Convert^WWWTR(0,12,fltDose)  ; HEVA-800
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M"),pidDose.get()),"~"),m$.fnc$("WWWTR.Convert",0,12,fltDose.get())));
      //<< ;set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M"_pidDose_"~"_fltDose  ; HEVA-800
      //<< set $piece(pobjMData,Y,pidDose) = fltDose  ; HEVA-800
      m$.pieceVar(pobjMData,m$.var("Y").get(),pidDose.get()).set(fltDose.get());
      //<< do VolumeUpdate() ; SR18138
      m$.Cmd.Do("VolumeUpdate");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< OnBlurDilQty(&pobjMData,pidDose)
  public Object OnBlurDilQty(Object ... _p) {
    mVar pobjMData = m$.newVarRef("pobjMData",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidDose = m$.newVarRef("pidDose",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; On Blur Diluent Qty
    //<< ; Used by MEDPrescriptionHosp
    //<< ;
    //<< ; Inputs: Line id
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Feb-2013   SCR     HEVA-800: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new fltQty
    mVar fltQty = m$.var("fltQty");
    m$.newVar(fltQty);
    //<< set fltQty=$piece(pobjMData,Y,pidDose)
    fltQty.set(m$.Fnc.$piece(pobjMData.get(),m$.var("Y").get(),pidDose.get()));
    //<< set fltQty = $$RoundDose^MEDPrescriptionCommon(fltQty)
    fltQty.set(m$.fnc$("MEDPrescriptionCommon.RoundDose",fltQty.get()));
    //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M"_pidDose_"~"_fltQty
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M"),pidDose.get()),"~"),fltQty.get()));
    //<< set $piece(pobjMData,Y,pidDose) = fltQty
    m$.pieceVar(pobjMData,m$.var("Y").get(),pidDose.get()).set(fltQty.get());
    //<< do VolumeUpdate()
    m$.Cmd.Do("VolumeUpdate");
    //<< quit
    return null;
  }

  //<< 
  //<< VolumeUpdate()
  public Object VolumeUpdate(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update Volume & Infusion Time
    //<< ;
    //<< ; History:
    //<< ; 24-Oct-2012   SCR     SR18138: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idDil,idItem,intDose,intVol,idUnit
    mVar idDil = m$.var("idDil");
    mVar idItem = m$.var("idItem");
    mVar intDose = m$.var("intDose");
    mVar intVol = m$.var("intVol");
    mVar idUnit = m$.var("idUnit");
    m$.newVar(idDil,idItem,intDose,intVol,idUnit);
    //<< set idDil   = $piece(YMFELD,Y,24)
    idDil.set(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),24));
    //<< set idItem  = $piece(YMFELD,Y,14)
    idItem.set(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),14));
    //<< set intDose = $piece(YMFELD,Y,15)
    intDose.set(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),15));
    //<< set idUnit  = $piece(YMFELD,Y,16)
    idUnit.set(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),16));
    //<< set intVol = $$VolumeItem^MEDPrescriptionSolLine(idItem,idUnit) * intDose
    intVol.set(mOp.Multiply(m$.fnc$("MEDPrescriptionSolLine.VolumeItem",idItem.get(),idUnit.get()),intDose.get()));
    //<< if idDil'="" {
    if (mOp.NotEqual(idDil.get(),"")) {
      //<< set intDose = $piece(YMFELD,Y,25)
      intDose.set(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),25));
      //<< set intVol = intVol + ($$VolumeItem^MEDPrescriptionSolLine(idDil) * intDose)
      intVol.set(mOp.Add(intVol.get(),(mOp.Multiply(m$.fnc$("MEDPrescriptionSolLine.VolumeItem",idDil.get()),intDose.get()))));
    }
    //<< }
    //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M43"_"~"_$$^WWWTR(0,12,intVol)
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M43"),"~"),m$.fnc$("WWWTR.main",0,12,intVol.get())));
    //<< set $piece(YMFELD,Y,43) = intVol
    m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),43).set(intVol.get());
    //<< do InfusionTime()
    m$.Cmd.Do("InfusionTime");
    //<< quit
    return null;
  }

  //<< 
  //<< InfusionTime()
  public Object InfusionTime(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update Infusion Time
    //<< ;
    //<< ; History:
    //<< ; 24-Oct-2012   SCR     SR18138: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intVol,intRate,idUnit,intTime,intQPH
    mVar intVol = m$.var("intVol");
    mVar intRate = m$.var("intRate");
    mVar idUnit = m$.var("idUnit");
    mVar intTime = m$.var("intTime");
    mVar intQPH = m$.var("intQPH");
    m$.newVar(intVol,intRate,idUnit,intTime,intQPH);
    //<< set intVol  = $piece(YMFELD,Y,43)
    intVol.set(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),43));
    //<< set intRate = $piece(YMFELD,Y,28)
    intRate.set(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),28));
    //<< set idUnit  = $piece(YMFELD,Y,33)
    idUnit.set(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),33));
    //<< do InfuseTime^MEDPrescriptionSol(intVol,1,intRate,idUnit,.intTime,.intQPH)
    m$.Cmd.Do("MEDPrescriptionSol.InfuseTime",intVol.get(),1,intRate.get(),idUnit.get(),intTime,intQPH);
    //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M29"_"~"_$$^WWWTR(0,12,intTime)
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M29"),"~"),m$.fnc$("WWWTR.main",0,12,intTime.get())));
    //<< set $piece(YMFELD,Y,29) = intTime
    m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),29).set(intTime.get());
    //<< do UpdateGrid^COMGridEdit31Links("Y"_YFORM_"M29",intTime,"",1)
    m$.Cmd.Do("COMGridEdit31Links.UpdateGrid",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M29"),intTime.get(),"",1);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< 
  //<< 
  //<< OnBlurDiluent(pobjMData,pintDiluent,pintUOM)
  public Object OnBlurDiluent(Object ... _p) {
    mVar pobjMData = m$.newVarRef("pobjMData",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintDiluent = m$.newVarRef("pintDiluent",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintUOM = m$.newVarRef("pintUOM",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; On Blur Diluent - Update Diluent UOM
    //<< ; Used by MEDPrescriptionHosp
    //<< ;
    //<< ; Inputs: Manual Data, Diluent Field, UOM Field
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 24-Oct-2012   SCR     SR18138: Update Volume
    //<< ; 19-Oct-2012   shobby  SR18165: Corrected management of data when updating diluent.
    //<< ; 14-Jun-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< //#dim idDuluent as  %String
    //<< new idDiluent,strUOM                                                                ; SR18165
    mVar idDiluent = m$.var("idDiluent");
    mVar strUOM = m$.var("strUOM");
    m$.newVar(idDiluent,strUOM);
    //<< 
    //<< set idDiluent=$piece(pobjMData,Y,pintDiluent)
    idDiluent.set(m$.Fnc.$piece(pobjMData.get(),m$.var("Y").get(),pintDiluent.get()));
    //<< if idDiluent'="" {   ; Diluent
    if (mOp.NotEqual(idDiluent.get(),"")) {
      //<< set strUOM=$$$AppEnum("EINHEIT",$piece($get(^INART(YM,idDiluent,1)),Y,40))      ; SR18165
      strUOM.set(include.COMSYSWWW.$$$AppEnum(m$,"EINHEIT",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),idDiluent.get(),1)),m$.var("Y").get(),40)));
    }
    //<< } else {
    else {
      //<< set strUOM=""                                                                   ; SR18165
      strUOM.set("");
      //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M25~"                                        ; SR18165
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M25~"));
      //<< do UpdateGrid^COMGridEdit31Links("Y"_YFORM_"M25","","",1)                       ; SR18165
      m$.Cmd.Do("COMGridEdit31Links.UpdateGrid",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M25"),"","",1);
    }
    //<< }
    //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M"_pintUOM_"~"_strUOM                            ; SR18165
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M"),pintUOM.get()),"~"),strUOM.get()));
    //<< do UpdateGrid^COMGridEdit31Links("Y"_YFORM_"M35",strUOM,"",1)                       ; SR18165
    m$.Cmd.Do("COMGridEdit31Links.UpdateGrid",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M35"),strUOM.get(),"",1);
    //<< do VolumeUpdate() ; SR18138
    m$.Cmd.Do("VolumeUpdate");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< OnAfterButtonLine(pYPARA)
  public Object OnAfterButtonLine(Object ... _p) {
    mVar pYPARA = m$.newVarRef("pYPARA",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< do Display^MEDPatientDetails($$$MEDPrescriptionPatientID(YFELD))
    m$.Cmd.Do("MEDPatientDetails.Display",include.MEDConst.$$$MEDPrescriptionPatientID(m$,m$.var("YFELD")));
    //<< quit
    return null;
  }

  //<< 
  //<< OnAfterDataFields(pidPatient)
  public Object OnAfterDataFields(Object ... _p) {
    mVar pidPatient = m$.newVarRef("pidPatient",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit
    return null;
  }

  //<< OnAfterDataFields1(YMFELD="")
  public Object OnAfterDataFields1(Object ... _p) {
    mVar YMFELD = m$.newVarRef("YMFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show current lines, Current Drugs & History
    //<< ;
    //<< ; Inputs: Key
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Feb-2013   shobby  SESPE-467: Formatting for firefox.
    //<< ; 16-Nov-2012   shobby  SR18020: TODO Create a new call out from WWWFORM to do this.
    //<< ; 16-Nov-2012   shobby  SR18020: Not using YMFELD for Patient information
    //<< ; 16-Jul-2012   SCR     SR17993: Added Java Script (From Dispense)
    //<< ; 06-Jun-2012   SCR     SR17993: Seperate Divs
    //<< ; 19-Apr-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< //#dim idRx,objRx
    //<< new idPatient
    mVar idPatient = m$.var("idPatient");
    m$.newVar(idPatient);
    //<< ;SR18020 set idPatient=$piece(YMFELD,Y,4)
    //<< set idPatient=$$$MEDPrescriptionPatientID(YFELD) ;SR18020
    idPatient.set(include.MEDConst.$$$MEDPrescriptionPatientID(m$,m$.var("YFELD")));
    //<< if idPatient'="" {
    if (mOp.NotEqual(idPatient.get(),"")) {
      //<< write "<DIV id='MEDDD' style='float:left; position:relative; top:0px;'>"
      m$.Cmd.Write("<DIV id='MEDDD' style='float:left; position:relative; top:0px;'>");
      //<< ;SR18182 write "<DIV style='border:1px ; position:absolute; top:75px; left:850px; width:220px; height:800;'>"
      //<< write "<DIV style='border:none ; top:75px; wid1th:220px; '>"
      m$.Cmd.Write("<DIV style='border:none ; top:75px; wid1th:220px; '>");
      //<< write "<DIV style='border:1px solid black; position:relative; top:0px; left:0px; width:100%; height:auto;'>"
      m$.Cmd.Write("<DIV style='border:1px solid black; position:relative; top:0px; left:0px; width:100%; height:auto;'>");
      //<< do ShowDrugs^MEDPrescriptionHospTable(idPatient)
      m$.Cmd.Do("MEDPrescriptionHospTable.ShowDrugs",idPatient.get());
      //<< write "</DIV>"
      m$.Cmd.Write("</DIV>");
      //<< write "<DIV style='border:1px; position:relative; float:top; left:0px; width:100%; height:10px;'>"
      m$.Cmd.Write("<DIV style='border:1px; position:relative; float:top; left:0px; width:100%; height:10px;'>");
      //<< write "</DIV>"
      m$.Cmd.Write("</DIV>");
      //<< write "<DIV style='border:1px solid black; position:relative; float:top; left:0px; width:100%; height:auto;'>"
      m$.Cmd.Write("<DIV style='border:1px solid black; position:relative; float:top; left:0px; width:100%; height:auto;'>");
      //<< do ShowHist^MEDPrescriptionHospTable(idPatient)
      m$.Cmd.Do("MEDPrescriptionHospTable.ShowHist",idPatient.get());
      //<< write "</DIV>"
      m$.Cmd.Write("</DIV>");
      //<< do SetupJS^MEDDispenseJS(YVOR)
      m$.Cmd.Do("MEDDispenseJS.SetupJS",m$.var("YVOR").get());
      //<< write "</DIV>" ;SR18182
      m$.Cmd.Write("</DIV>");
      //<< write "</DIV>"
      m$.Cmd.Write("</DIV>");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< CanValidate(pidPres, pobjPres)
  public Object CanValidate(Object ... _p) {
    mVar pidPres = m$.newVarRef("pidPres",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjPres = m$.newVarRef("pobjPres",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Validate Prescription in 'MEDDispense'
    //<< ;
    //<< ; Inputs: Key
    //<< ;
    //<< ; Returns: strStatus
    //<< ;
    //<< ; History:
    //<< ; 03-Jan-2013   SCR     HEVA-738: Handle 'Rejected' Status
    //<< ; 23-Oct-2012   shobby  SR18130.2:  Check if patient is admitted.
    //<< ; 09-Jun-2012 SCR   SR17993: Changed Status to include 1
    //<< ; 01-Jun-2012 PPP   SR18002: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idSta
    mVar idSta = m$.var("idSta");
    m$.newVar(idSta);
    //<< new strDispenseStatus
    mVar strDispenseStatus = m$.var("strDispenseStatus");
    m$.newVar(strDispenseStatus);
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if '$$$NoKey(pidPres) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pidPres))) {
      //<< if '$$CheckAdmitted^MEDPatient("","",$$$MEDPrescriptionPatientID(pobjPres)) set strStatus=$$$MakeStatus("MED01310")  ; "Patient does not have an active admission" ;SR18130.2
      if (mOp.Not(m$.fnc$("MEDPatient.CheckAdmitted","","",include.MEDConst.$$$MEDPrescriptionPatientID(m$,pobjPres)))) {
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"MED01310"));
      }
      //<< if $$$ISOK(strStatus) {                                                     ;SR18130.2
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< set idSta = +$$$MEDPrescriptionStatus(pobjPres)
        idSta.set(mOp.Positive(include.MEDConst.$$$MEDPrescriptionStatus(m$,pobjPres)));
        //<< set:idSta=10 idSta=2.5 ; HEVA-738
        if (mOp.Equal(idSta.get(),10)) {
          idSta.set(2.5);
        }
        //<< if (idSta < 1) || (idSta > 5) {     //Open, Administration Complete  ; SR17993
        if ((mOp.Less(idSta.get(),1)) || (mOp.Greater(idSta.get(),5))) {
          //<< ;if (idSta < 2) || (idSta > 5) {        //Open, Administration Complete
          //<< set strDispenseStatus = $$GetDescription^WWWStatus("MEDPrescription",idSta,$get(SPRACHE))
          strDispenseStatus.set(m$.fnc$("WWWStatus.GetDescription","MEDPrescription",idSta.get(),m$.Fnc.$get(m$.var("SPRACHE"))));
          //<< set strStatus = $$$MakeStatus("MED00398",strDispenseStatus)   //Invalid Status (%) for current operation
          strStatus.set(include.COMSYS.$$$MakeStatus(m$,"MED00398",strDispenseStatus));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< $$$YQHandler(strStatus)
    include.COMSYS.$$$YQHandler(m$,strStatus);
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< Validate(pidRx)
  public Object Validate(Object ... _p) {
    mVar pidRx = m$.newVarRef("pidRx",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Validate Prescription in 'MEDDispense'
    //<< ;
    //<< ; Inputs: Key
    //<< ;
    //<< ; Returns: strStatus
    //<< ;
    //<< ; History:
    //<< ; 22-Nov-2012   SCR     SR18211: Create new Dispense if last Dispense is processed
    //<< ; 12-Nov-2012   SCR     SR18199: Force id to prescription number only
    //<< ; 26-Oct-2012   shobby  SR18130.2: Check for valid admission.
    //<< ; 01-Jun-2012   PPP     SR18002.2: Create the Dispense on Validation if one does not exist
    //<< ; 01-Jun-2012   PPP     SR18002.1: not OK if Status > 3
    //<< ; 16-May-2012   PPP     SR18002: Added more logic to display new/old dispense
    //<< ; 16-May-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idDispense
    mVar idDispense = m$.var("idDispense");
    m$.newVar(idDispense);
    //<< new strParam
    mVar strParam = m$.var("strParam");
    m$.newVar(strParam);
    //<< new objDispense
    mVar objDispense = m$.var("objDispense");
    m$.newVar(objDispense);
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< new idSta
    mVar idSta = m$.var("idSta");
    m$.newVar(idSta);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set pidRx=$piece(pidRx,",") ; SR18199
    pidRx.set(m$.Fnc.$piece(pidRx.get(),","));
    //<< set strStatus=$$CheckAdmitted^MEDPatient("",pidRx)                                              ;SR18130.2
    strStatus.set(m$.fnc$("MEDPatient.CheckAdmitted","",pidRx.get()));
    //<< if $$$ISERR(strStatus) {                                                                        ;SR18130.2
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Alert(strStatus)                                                                         ;SR18130.2
      include.COMSYS.$$$Alert(m$,strStatus);
    }
    //<< }                                                                                               ;SR18130.2
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< 
      //<< set strParam = pidRx
      strParam.set(pidRx.get());
      //<< 
      //<< //^MEDDispenses(0,1,"MP0043","PP0000002")=""
      //<< //Get the last Dispense for this Prescription
      //<< set idDispense = $order(^MEDDispenses(0,1,$$$Index(pidRx),""),-1)
      idDispense.set(m$.Fnc.$order(m$.var("^MEDDispenses",0,1,include.MEDConst.$$$Index(m$,pidRx),""),mOp.Negative(1)));
      //<< 
      //<< if idDispense'="" {
      if (mOp.NotEqual(idDispense.get(),"")) {
        //<< set objDispense = $get(^MEDDispense(0,idDispense,1))
        objDispense.set(m$.Fnc.$get(m$.var("^MEDDispense",0,idDispense.get(),1)));
        //<< set idSta = $$$MEDDispenseStatus(objDispense)
        idSta.set(include.MEDConst.$$$MEDDispenseStatus(m$,objDispense));
        //<< //SR18002.1
        //<< if (idSta > 2) {        ; SR18211
        if ((mOp.Greater(idSta.get(),2))) {
          //<< ;if (idSta > 3) {       //Partial Processed, Processed
          //<< set idDispense=""
          idDispense.set("");
        }
      }
      //<< }
      //<< 
      //<< }
      //<< 
      //<< if idDispense = "" {
      if (mOp.Equal(idDispense.get(),"")) {
        //<< set strStatus = $$CreateDispense^MEDDispense(pidRx, .idDispense)
        strStatus.set(m$.fnc$("MEDDispense.CreateDispense",pidRx.get(),idDispense));
      }
      //<< }
      //<< 
      //<< set strParam = ""
      strParam.set("");
      //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
      if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
        //<< do GoToForm^COMUtilForm("MEDDispense",$get(idDispense),1,$get(strParam))
        m$.Cmd.Do("COMUtilForm.GoToForm","MEDDispense",m$.Fnc.$get(idDispense),1,m$.Fnc.$get(strParam));
      }
      //<< } else {
      else {
        //<< do GoToForm^COMUtilForm("MEDDispense",$get(idDispense),"",$get(strParam))
        m$.Cmd.Do("COMUtilForm.GoToForm","MEDDispense",m$.Fnc.$get(idDispense),"",m$.Fnc.$get(strParam));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< do ReloadForm^COMUtilForm()                                                             ;SR18130.2
      m$.Cmd.Do("COMUtilForm.ReloadForm");
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< TimeCheck(&pstrTime)
  public Object TimeCheck(Object ... _p) {
    mVar pstrTime = m$.newVarRef("pstrTime",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Validate Time
    //<< ;
    //<< ; Inputs: Key
    //<< ;
    //<< ; Returns: strStatus
    //<< ;
    //<< ; History:
    //<< ; 04-Jun-2012 SCR  SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit ;SR18026
    return null;
  }

  //<< UpdateDiluent(pidItem,YUPDATE)
  public Object UpdateDiluent(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YUPDATE = m$.newVarRef("YUPDATE",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update the Diluent List (Combo Box) based on the Item Provided
    //<< ;
    //<< ; Inputs:
    //<< ;   pidItem
    //<< ;   YUPDATE in the form  "Y"_YFORM_YART_FIELD
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 24-Jul-2012   SR17993: Limit the size of list (width)
    //<< ; 05-Jun-2012   SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idUnit,idUnitSel,YI,objSetup,idCat,idItem,objItem,intSize,strDesc
    mVar idUnit = m$.var("idUnit");
    mVar idUnitSel = m$.var("idUnitSel");
    mVar YI = m$.var("YI");
    mVar objSetup = m$.var("objSetup");
    mVar idCat = m$.var("idCat");
    mVar idItem = m$.var("idItem");
    mVar objItem = m$.var("objItem");
    mVar intSize = m$.var("intSize");
    mVar strDesc = m$.var("strDesc");
    m$.newVar(idUnit,idUnitSel,YI,objSetup,idCat,idItem,objItem,intSize,strDesc);
    //<< set objSetup=$get(^MEDPrescriptionSetup(0,YM,1))
    objSetup.set(m$.Fnc.$get(m$.var("^MEDPrescriptionSetup",0,m$.var("YM").get(),1)));
    //<< set intSize= $$$MEDPrescriptionSetupDiluentNameSize(objSetup)
    intSize.set(include.MEDConst.$$$MEDPrescriptionSetupDiluentNameSize(m$,objSetup));
    //<< set:intSize<1 intSize=20
    if (mOp.Less(intSize.get(),1)) {
      intSize.set(20);
    }
    //<< 
    //<< set %TXT(1)=$get(%TXT(1))
    m$.var("%TXT",1).set(m$.Fnc.$get(m$.var("%TXT",1)));
    //<< if $get(pidItem)="" {
    if (mOp.Equal(m$.Fnc.$get(pidItem),"")) {
      //<< set %TXT(1) = %TXT(1)_"#"_YUPDATE_"~REMOVE"
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),YUPDATE.get()),"~REMOVE"));
      //<< set %TXT(1) = %TXT(1)_"#"_YUPDATE_"~"_$$$NULLID_"~"_$$$SPACE_"~"_0
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),YUPDATE.get()),"~"),include.COMSYSString.$$$NULLID(m$)),"~"),include.COMSYSString.$$$SPACE(m$)),"~"),0));
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< set YI=0
    YI.set(0);
    //<< set %TXT(1) = %TXT(1)_"#"_YUPDATE_"~REMOVE"
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),YUPDATE.get()),"~REMOVE"));
    //<< set %TXT(1) = %TXT(1)_"#"_YUPDATE_"~"_$$$NULLID_"~"_$$$SPACE_"~"_YI
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),YUPDATE.get()),"~"),include.COMSYSString.$$$NULLID(m$)),"~"),include.COMSYSString.$$$SPACE(m$)),"~"),YI.get()));
    //<< do LoadDiluentList(pidItem)
    m$.Cmd.Do("LoadDiluentList",pidItem.get());
    //<< set idItem = ""
    idItem.set("");
    //<< for YI(1)=1:1 {
    for (m$.var("YI",1).set(1);(true);m$.var("YI",1).set(mOp.Add(m$.var("YI",1).get(),1))) {
      //<< set idItem = $order(^COMTempList(0,YUSER,"Diluent",idItem))
      idItem.set(m$.Fnc.$order(m$.var("^COMTempList",0,m$.var("YUSER").get(),"Diluent",idItem.get())));
      //<< quit:idItem=""
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< set strDesc = $piece($get(^INART(YM,idItem,1)),Y,1)
      strDesc.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),idItem.get(),1)),m$.var("Y").get(),1));
      //<< set strDesc = $extract(strDesc,1,intSize)
      strDesc.set(m$.Fnc.$extract(strDesc.get(),1,intSize.get()));
      //<< set %TXT(1) = %TXT(1)_"#"_YUPDATE_"~"_idItem_"~"_idItem_" - "_strDesc_"~"_YI(1)
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),YUPDATE.get()),"~"),idItem.get()),"~"),idItem.get())," - "),strDesc.get()),"~"),YI.var(1).get()));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< LoadDiluentList(pidItem="")
  public Object LoadDiluentList(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update the Diluent List (COMTempList) based on the Item Provided
    //<< ;
    //<< ; Inputs:
    //<< ;   pidItem
    //<< ;   YUPDATE in the form  "Y"_YFORM_YART_FIELD
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 24-Jul-2012   SR17993: Limit the size of list (width)
    //<< ; 05-Jun-2012   SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idUnit,idUnitSel,YI,objSetup,idCat,idItem,objItem,intSize,strDesc
    mVar idUnit = m$.var("idUnit");
    mVar idUnitSel = m$.var("idUnitSel");
    mVar YI = m$.var("YI");
    mVar objSetup = m$.var("objSetup");
    mVar idCat = m$.var("idCat");
    mVar idItem = m$.var("idItem");
    mVar objItem = m$.var("objItem");
    mVar intSize = m$.var("intSize");
    mVar strDesc = m$.var("strDesc");
    m$.newVar(idUnit,idUnitSel,YI,objSetup,idCat,idItem,objItem,intSize,strDesc);
    //<< 
    //<< set objSetup=$get(^MEDPrescriptionSetup(0,YM,1))
    objSetup.set(m$.Fnc.$get(m$.var("^MEDPrescriptionSetup",0,m$.var("YM").get(),1)));
    //<< set idCat=$$$MEDPrescriptionSetupDiluentCategory(objSetup)
    idCat.set(include.MEDConst.$$$MEDPrescriptionSetupDiluentCategory(m$,objSetup));
    //<< set intSize= $$$MEDPrescriptionSetupDiluentNameSize(objSetup)
    intSize.set(include.MEDConst.$$$MEDPrescriptionSetupDiluentNameSize(m$,objSetup));
    //<< set:intSize<1 intSize=20
    if (mOp.Less(intSize.get(),1)) {
      intSize.set(20);
    }
    //<< kill ^COMTempList(0,YUSER,"Diluent")
    m$.var("^COMTempList",0,m$.var("YUSER").get(),"Diluent").kill();
    //<< if idCat'="" {
    if (mOp.NotEqual(idCat.get(),"")) {
      //<< set idCat=$$$Index(idCat)
      idCat.set(include.MEDConst.$$$Index(m$,idCat));
      //<< set idItem = ""
      idItem.set("");
      //<< for YI(1)=1:1 {
      for (m$.var("YI",1).set(1);(true);m$.var("YI",1).set(mOp.Add(m$.var("YI",1).get(),1))) {
        //<< set idItem = $order(^INARTs(YM,6,idCat,idItem))
        idItem.set(m$.Fnc.$order(m$.var("^INARTs",m$.var("YM").get(),6,idCat.get(),idItem.get())));
        //<< quit:idItem=""
        if (mOp.Equal(idItem.get(),"")) {
          break;
        }
        //<< set strDesc = $piece($get(^INART(YM,idItem,1)),Y,1)
        strDesc.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),idItem.get(),1)),m$.var("Y").get(),1));
        //<< set strDesc = $extract(strDesc,1,intSize)
        strDesc.set(m$.Fnc.$extract(strDesc.get(),1,intSize.get()));
        //<< set ^COMTempList(0,YUSER,"Diluent",idItem,1) = strDesc_"~"_YI(1)
        m$.var("^COMTempList",0,m$.var("YUSER").get(),"Diluent",idItem.get(),1).set(mOp.Concat(mOp.Concat(strDesc.get(),"~"),YI.var(1).get()));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< Process(pidRx)
  public Object Process(Object ... _p) {
    mVar pidRx = m$.newVarRef("pidRx",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create diluent lines and Process the Prescription
    //<< ;
    //<< ; Inputs: id
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Oct-2012   shobby  SR18130.2 : Can't process if no active admission.
    //<< ; 08-Jun-2012   SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus=$$CheckAdmitted^MEDPatient("",pidRx)                          ;SR18130.2
    strStatus.set(m$.fnc$("MEDPatient.CheckAdmitted","",pidRx.get()));
    //<< if $$$ISERR(strStatus) {                                                    ;SR18130.2
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Alert(strStatus)                                                     ;SR18130.2
      include.COMSYS.$$$Alert(m$,strStatus);
      //<< do ReloadForm^COMUtilForm()                                             ;SR18130.2
      m$.Cmd.Do("COMUtilForm.ReloadForm");
    }
    //<< } else {                                                                                            ;SR18130.2
    else {
      //<< set strStatus = $$Transaction^COMTransaction("ProcessTxn^MEDPrescriptionHosp("""_pidRx_""")",$$$NO)
      strStatus.set(m$.fnc$("COMTransaction.Transaction",mOp.Concat(mOp.Concat("ProcessTxn^MEDPrescriptionHosp(\"",pidRx.get()),"\")"),include.COMSYS.$$$NO(m$)));
      //<< if $$$ISOK(strStatus) do Firm^MEDPrescription(pidRx)
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        m$.Cmd.Do("MEDPrescription.Firm",pidRx.get());
      }
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< ProcessTxn(pidRx)
  public Object ProcessTxn(Object ... _p) {
    mVar pidRx = m$.newVarRef("pidRx",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update the Remarks
    //<< ;
    //<< ; Inputs: id
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 24-Jan-2013   SCR     HEVA-781: Correct numeric test
    //<< ; 21-Jan-2013   SCR     HEVA-737: if Urgent & If Needed show 'URGENT and IF NECESSARY'
    //<< ; 10-Jan-2013   shobby  HEVA-756: Additional info
    //<< ; 08-Jun-2012   SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,idLine,objLine,strRemark,strText
    mVar strStatus = m$.var("strStatus");
    mVar idLine = m$.var("idLine");
    mVar objLine = m$.var("objLine");
    mVar strRemark = m$.var("strRemark");
    mVar strText = m$.var("strText");
    m$.newVar(strStatus,idLine,objLine,strRemark,strText);
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set idLine=""
    idLine.set("");
    //<< for {
    for (;true;) {
      //<< set idLine=$order(^MEDPrescriptionLine(YM,pidRx,idLine))
      idLine.set(m$.Fnc.$order(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),pidRx.get(),idLine.get())));
      //<< quit:idLine=""
      if (mOp.Equal(idLine.get(),"")) {
        break;
      }
      //<< quit:strStatus'=$$$OK
      if (mOp.NotEqual(strStatus.get(),include.COMSYS.$$$OK(m$))) {
        break;
      }
      //<< set objLine=$get(^MEDPrescriptionLine(YM,pidRx,idLine,1))
      objLine.set(m$.Fnc.$get(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),pidRx.get(),idLine.get(),1)));
      //<< set strText=""
      strText.set("");
      //<< if $$$MEDPrescriptionLineUrgent(objLine) {
      if (mOp.Logical(include.MEDConst.$$$MEDPrescriptionLineUrgent(m$,objLine))) {
        //<< set strText=$$$Text("MED01284")  ;URGENT
        strText.set(include.COMSYS.$$$Text(m$,"MED01284"));
        //<< ; HEVA-737 vvvv
        //<< if $$$MEDPrescriptionLineIfNeeded(objLine) {
        if (mOp.Logical(include.MEDConst.$$$MEDPrescriptionLineIfNeeded(m$,objLine))) {
          //<< set strText=strText_" "_$$$Text("SALCST0224") ; and
          strText.set(mOp.Concat(mOp.Concat(strText.get()," "),include.COMSYS.$$$Text(m$,"SALCST0224")));
        }
      }
      //<< }
      //<< ; HEVA-737 ^^^^
      //<< 
      //<< }
      //<< if $$$MEDPrescriptionLineIfNeeded(objLine) {
      if (mOp.Logical(include.MEDConst.$$$MEDPrescriptionLineIfNeeded(m$,objLine))) {
        //<< set:strText'="" strText=strText_" "
        if (mOp.NotEqual(strText.get(),"")) {
          strText.set(mOp.Concat(strText.get()," "));
        }
        //<< set strText=strText_$$$Text("MED01285")  ;IF NEEDED
        strText.set(mOp.Concat(strText.get(),include.COMSYS.$$$Text(m$,"MED01285")));
      }
      //<< }
      //<< 
      //<< ;HEVA-756 vvvv
      //<< if $$$MEDPrescriptionLinePRN(objLine) {
      if (mOp.Logical(include.MEDConst.$$$MEDPrescriptionLinePRN(m$,objLine))) {
        //<< set:strText'="" strText=strText_"|"
        if (mOp.NotEqual(strText.get(),"")) {
          strText.set(mOp.Concat(strText.get(),"|"));
        }
        //<< set strText=strText_$$$Text("MED01420")  ;PRN
        strText.set(mOp.Concat(strText.get(),include.COMSYS.$$$Text(m$,"MED01420")));
      }
      //<< }
      //<< if +$$$MEDPrescriptionLineAdministeronly(objLine)>0 { ; HEVA-781
      if (mOp.Greater(mOp.Positive(include.MEDConst.$$$MEDPrescriptionLineAdministeronly(m$,objLine)),0)) {
        //<< ;if $$$MEDPrescriptionLineAdministeronly(objLine)'="" {
        //<< set:strText'="" strText=strText_"|"
        if (mOp.NotEqual(strText.get(),"")) {
          strText.set(mOp.Concat(strText.get(),"|"));
        }
        //<< set strText=strText_$$$Text($lb("MED01421",$$$MEDPrescriptionLineAdministeronly(objLine))) ;Administer Only %1
        strText.set(mOp.Concat(strText.get(),include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("MED01421",include.MEDConst.$$$MEDPrescriptionLineAdministeronly(m$,objLine)))));
      }
      //<< }
      //<< ;HEVA-756^^^^
      //<< 
      //<< set strRemark= $$$MEDPrescriptionLineRemarks(objLine)
      strRemark.set(include.MEDConst.$$$MEDPrescriptionLineRemarks(m$,objLine));
      //<< if $extract(strRemark,1,$length(strText))'=strText {
      if (mOp.NotEqual(m$.Fnc.$extract(strRemark.get(),1,m$.Fnc.$length(strText.get())),strText.get())) {
        //<< set strRemark=strText_$select(strRemark="":"",1:"|"_strRemark)
        strRemark.set(mOp.Concat(strText.get(),m$.Fnc.$select(mOp.Equal(strRemark.get(),""),"",1,mOp.Concat("|",strRemark.get()))));
      }
      //<< }
      //<< if $$$MEDPrescriptionLineRemarks(objLine)'=strRemark {
      if (mOp.NotEqual(include.MEDConst.$$$MEDPrescriptionLineRemarks(m$,objLine),strRemark.get())) {
        //<< set $$$MEDPrescriptionLineRemarks(objLine)=strRemark
        include.MEDConst.$$$MEDPrescriptionLineRemarksSet(m$,objLine,strRemark.get());
        //<< set strStatus=$$$Save("MEDPrescriptionLine",pidRx_","_idLine,objLine,1)
        strStatus.set(include.COMSYS.$$$Save(m$,"MEDPrescriptionLine",mOp.Concat(mOp.Concat(pidRx.get(),","),idLine.get()),objLine,1));
      }
    }
    //<< }
    //<< }
    //<< if (+$$$WWWClientParamCoreChangesHEVA($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesHEVA(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
      //<< if ($$$ISOK(strStatus)) {
      if (mOp.Logical((include.COMSYS.$$$ISOK(m$,strStatus)))) {
        //<< set strStatus = $$CreateDose^VARDose(pidRx)
        strStatus.set(m$.fnc$("VARDose.CreateDose",pidRx.get()));
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< DrugInteraction(pidRx,pidItem,pidGridForm)
  public Object DrugInteraction(Object ... _p) {
    mVar pidRx = m$.newVarRef("pidRx",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidGridForm = m$.newVarRef("pidGridForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check the Drug Interaction
    //<< ;
    //<< ; Params:   pidDispense - Dispense
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Jan-2013   shobby  HEVA-762: Don't test line if it doesn't have an item
    //<< ; 16-Jul-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strMsg,arrGrid,arrDrugs,idLine1,objLine1,idItem1,idDiluent,intCont,intSize,intLines
    mVar strMsg = m$.var("strMsg");
    mVar arrGrid = m$.var("arrGrid");
    mVar arrDrugs = m$.var("arrDrugs");
    mVar idLine1 = m$.var("idLine1");
    mVar objLine1 = m$.var("objLine1");
    mVar idItem1 = m$.var("idItem1");
    mVar idDiluent = m$.var("idDiluent");
    mVar intCont = m$.var("intCont");
    mVar intSize = m$.var("intSize");
    mVar intLines = m$.var("intLines");
    m$.newVar(strMsg,arrGrid,arrDrugs,idLine1,objLine1,idItem1,idDiluent,intCont,intSize,intLines);
    //<< 
    //<< set strMsg=""
    strMsg.set("");
    //<< 
    //<< if '$$$NoKey(pidRx) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pidRx))) {
      //<< $$$GRIDGetContents(.arrGrid,pidGridForm) ;HEVA-762
      include.COMGridEdit31Interface.$$$GRIDGetContents(m$,arrGrid,pidGridForm);
      //<< set:pidItem'="" arrDrugs("l",pidItem)=""
      if (mOp.NotEqual(pidItem.get(),"")) {
        arrDrugs.var("l",pidItem.get()).set("");
      }
      //<< set idLine1 = ""
      idLine1.set("");
      //<< for {
      for (;true;) {
        //<< set idLine1 = $order(arrGrid(pidRx,idLine1))
        idLine1.set(m$.Fnc.$order(arrGrid.var(pidRx.get(),idLine1.get())));
        //<< quit:idLine1=""
        if (mOp.Equal(idLine1.get(),"")) {
          break;
        }
        //<< 
        //<< set objLine1 = $get(arrGrid(pidRx,idLine1))
        objLine1.set(m$.Fnc.$get(arrGrid.var(pidRx.get(),idLine1.get())));
        //<< set idItem1 =  $$$MEDPrescriptionLineItem(objLine1) ;HEVA-762
        idItem1.set(include.MEDConst.$$$MEDPrescriptionLineItem(m$,objLine1));
        //<< if idItem1'="" {
        if (mOp.NotEqual(idItem1.get(),"")) {
          //<< set arrDrugs("l",idItem1)=""
          arrDrugs.var("l",idItem1.get()).set("");
          //<< 
          //<< //SR18002.1
          //<< set idDiluent =  $$$MEDPrescriptionLineDiluent(objLine1)
          idDiluent.set(include.MEDConst.$$$MEDPrescriptionLineDiluent(m$,objLine1));
          //<< if idDiluent'="" {
          if (mOp.NotEqual(idDiluent.get(),"")) {
            //<< ;set arrDrugs("d",idItem1,idDiluent)=""
            //<< set arrDrugs("l",idDiluent)=""
            arrDrugs.var("l",idDiluent.get()).set("");
          }
        }
      }
    }
    //<< 
    //<< }
    //<< }
    //<< 
    //<< }
    //<< }
    //<< set strMsg=$$GetInteractionMessage^MEDDrugInteraction(.arrDrugs,.intCont,pidRx)
    strMsg.set(m$.fnc$("MEDDrugInteraction.GetInteractionMessage",arrDrugs,intCont,pidRx.get()));
    //<< 
    //<< if strMsg'="" {
    if (mOp.NotEqual(strMsg.get(),"")) {
      //<< set intLines = $l(strMsg,"</br>")+2
      intLines.set(mOp.Add(m$.Fnc.$length(strMsg.get(),"</br>"),2));
      //<< set intSize = intLines * 27
      intSize.set(mOp.Multiply(intLines.get(),27));
      //<< 
      //<< if (intSize > 600){
      if ((mOp.Greater(intSize.get(),600))) {
        //<< set intSize = 600
        intSize.set(600);
      }
      //<< }
      //<< set strMsg = $replace(strMsg,"'","`")
      strMsg.set(m$.Fnc.$replace(strMsg.get(),"'","`"));
      //<< set strMsg = $$$Text($lb("MED00416",intCont))_strMsg        //Dispense contains <b>%1</b> Drug Interaction(s)</br>
      strMsg.set(mOp.Concat(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("MED00416",intCont.get())),strMsg.get()));
      //<< 
      //<< $$$JS("ShowMsgInteracao( '"_strMsg_"','"_intSize_"');")
      include.COMSYS.$$$JS(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ShowMsgInteracao( '",strMsg.get()),"','"),intSize.get()),"');"));
    }
    //<< 
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< Suspend(pstrKey)
  public Object Suspend(Object ... _p) {
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Suspend Rx or Rx Line
    //<< ;
    //<< ; Param YKEY = Rx or Rx,Line
    //<< ;
    //<< ; History:
    //<< ; 12-Jul-2012   SCR     SR17979: Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< 
    //<< new strPrompt
    mVar strPrompt = m$.var("strPrompt");
    m$.newVar(strPrompt);
    //<< new strCallback
    mVar strCallback = m$.var("strCallback");
    m$.newVar(strCallback);
    //<< new idRx
    mVar idRx = m$.var("idRx");
    m$.newVar(idRx);
    //<< new strYKEY
    mVar strYKEY = m$.var("strYKEY");
    m$.newVar(strYKEY);
    //<< new strAlert
    mVar strAlert = m$.var("strAlert");
    m$.newVar(strAlert);
    //<< 
    //<< if ($get(pstrKey) '= "") {
    if ((mOp.NotEqual(m$.Fnc.$get(pstrKey),""))) {
      //<< set strYKEY = pstrKey
      strYKEY.set(pstrKey.get());
    }
    //<< } else {
    else {
      //<< set strYKEY = $$GetKey^COMGridEdit31G()
      strYKEY.set(m$.fnc$("COMGridEdit31G.GetKey"));
    }
    //<< }
    //<< 
    //<< set strPrompt   = $$$JSText($$$Text( "MED01289"))  ;Please specify the reason for Suspension
    strPrompt.set(include.COMSYSString.$$$JSText(m$,include.COMSYS.$$$Text(m$,"MED01289")));
    //<< set strCallback = "SuspenseSet^MEDPrescriptionHosp"
    strCallback.set("SuspenseSet^MEDPrescriptionHosp");
    //<< set idRx        = $$$KEY1(strYKEY)
    idRx.set(include.COMSYSWWW.$$$KEY1(m$,strYKEY));
    //<< set strAlert    = $$$JSText($$$Text("MED00415")) //Please enter a Reason
    strAlert.set(include.COMSYSString.$$$JSText(m$,include.COMSYS.$$$Text(m$,"MED00415")));
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< &js<
    //<< //var strResult=prompt('#(strPrompt)#','','');
    //<< 
    //<< var strResult = iePrompt('#(strPrompt)#');
    //<< 
    //<< if (strResult!=false) {
    //<< CallBackNow('#(strCallback)#','#(strYKEY)#',strResult);
    //<< } else {
    //<< CallBackNow('GoToForm^COMUtilForm','MEDPrescriptionHosp','#(idRx)#');
    //<< }
    //<< 
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        //var strResult=prompt('",(strPrompt.get())),")','','');"),"\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        var strResult = iePrompt('",(strPrompt.get())),")');"),"\n");
    m$.Cmd.WriteJS("                ","\n");
    m$.Cmd.WriteJS("        if (strResult!=false) {","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("            CallBackNow('",(strCallback.get())),")','"),(strYKEY.get())),")',strResult);"),"\n");
    m$.Cmd.WriteJS("        } else {","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("            CallBackNow('GoToForm^COMUtilForm','MEDPrescriptionHosp','",(idRx.get())),")');       "),"\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("    ");
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< SuspenseSet(pidRx, pstrReason="xxxx")
  public Object SuspenseSet(Object ... _p) {
    mVar pidRx = m$.newVarRef("pidRx",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrReason = m$.newVarRef("pstrReason",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"xxxx");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set the status and add Reason to Remarks
    //<< ;
    //<< ; Params:   pidRx   - Prescription, Line Key
    //<< ;           Reason
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Jul-2012   SCR     SR17994 : Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,YKEY
    mVar strStatus = m$.var("strStatus");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(strStatus,YKEY);
    //<< set YKEY  = $piece(pidRx,",",1)
    YKEY.set(m$.Fnc.$piece(pidRx.get(),",",1));
    //<< 
    //<< set strStatus = $$Transaction^COMTransaction("SuspendTxn^MEDPrescription("""_YKEY_""","""_pstrReason_""")",$$$YES)
    strStatus.set(m$.fnc$("COMTransaction.Transaction",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("SuspendTxn^MEDPrescription(\"",YKEY.get()),"\",\""),pstrReason.get()),"\")"),include.COMSYS.$$$YES(m$)));
    //<< 
    //<< 
    //<< Do RedirectForm^COMUtilForm("MEDPrescriptionHosp",YKEY,"MEDPrescriptionHosp,",YPARA,"")
    m$.Cmd.Do("COMUtilForm.RedirectForm","MEDPrescriptionHosp",YKEY.get(),"MEDPrescriptionHosp,",m$.var("YPARA").get(),"");
    //<< 
    //<< ;quit strStatus
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< PatientList()
  public Object PatientList(Object ... _p) {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Jump back to Patient list in search mode
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Aug-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< Do RedirectForm^COMUtilForm("MEDPrescriptionPat","","","","",$$$YES)
    m$.Cmd.Do("COMUtilForm.RedirectForm","MEDPrescriptionPat","","","","",include.COMSYS.$$$YES(m$));
    //<< quit
    return null;
  }

//<< 
//<< 
}
