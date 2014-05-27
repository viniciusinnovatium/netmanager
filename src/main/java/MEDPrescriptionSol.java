//*****************************************************************************
//** TASC - ALPHALINC - MAC MEDPrescriptionSol
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:13
//*****************************************************************************

import mLibrary.*;

//<< #include COMConst
import include.COMConst;
import include.COMSYS;
//<< #include INConst
import include.INConst;
//<< #include COMGridEdit31
import include.COMGridEdit31;
//<< #include MEDConst
import include.MEDConst;

//<< MEDPrescriptionSol
public class MEDPrescriptionSol extends mClass {

  public void main() {
    _MEDPrescriptionSol();
  }

  public void _MEDPrescriptionSol() {
  }

  //<< 
  //<< OnBeforeFormConstruction(&pstrYMFELD,pstrYFELD,pstrPARA)
  public Object OnBeforeFormConstruction(Object ... _p) {
    mVar pstrYMFELD = m$.newVarRef("pstrYMFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrYFELD = m$.newVarRef("pstrYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrPARA = m$.newVarRef("pstrPARA",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Manuals for patient
    //<< ;
    //<< ; History :
    //<< ; 30-May-2012   SCR     SR17993 Created
    //<< ;-------------------------------------------------------------------------------
    //<< //#dim objLine As %String
    //<< //#dim intSol,idStatus As %Integer
    //<< new objLine,intSol,idStatus,idPatient,objPrescription
    mVar objLine = m$.var("objLine");
    mVar intSol = m$.var("intSol");
    mVar idStatus = m$.var("idStatus");
    mVar idPatient = m$.var("idPatient");
    mVar objPrescription = m$.var("objPrescription");
    m$.newVar(objLine,intSol,idStatus,idPatient,objPrescription);
    //<< 
    //<< if $get(^CacheTempMedRx(YUSER,"SOL-Reload"))'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"SOL-Reload")),"")) {
      //<< set YKEY=$get(^CacheTempMedRx(YUSER,"SOL-Reload"))
      mVar YKEY = m$.var("YKEY");
      YKEY.set(m$.Fnc.$get(m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"SOL-Reload")));
      //<< kill ^CacheTempMedRx(YUSER,"SOL-Reload")
      m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"SOL-Reload").kill();
    }
    //<< }
    //<< set YKEY=$translate(YKEY,"""")
    mVar YKEY = m$.var("YKEY");
    YKEY.set(m$.Fnc.$translate(m$.var("YKEY").get(),"\""));
    //<< if $piece(YKEY,",",2)'="" {  ; Direct line link
    if (mOp.NotEqual(m$.Fnc.$piece(YKEY.get(),",",2),"")) {
      //<< set pstrPARA=$piece(YKEY,",",2)
      pstrPARA.set(m$.Fnc.$piece(YKEY.get(),",",2));
      //<< set objLine=$get(^MEDPrescriptionLine(YM,$piece(YKEY,",",1),pstrPARA,1))
      objLine.set(m$.Fnc.$get(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),m$.Fnc.$piece(YKEY.get(),",",1),pstrPARA.get(),1)));
      //<< set ^CacheTempMedRx(YUSER,"SOL-CUR")=$$Solution^MEDPrescriptionSolLine(,$$$MEDPrescriptionLineSolution(objLine))
      m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"SOL-CUR").set(m$.fnc$("MEDPrescriptionSolLine.Solution",null,include.MEDConst.$$$MEDPrescriptionLineSolution(m$,objLine)));
    }
    //<< } else {
    else {
      //<< set ^CacheTempMedRx(YUSER,"SOL-CUR")=$$Solution^MEDPrescriptionSolLine($$$YES)
      m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"SOL-CUR").set(m$.fnc$("MEDPrescriptionSolLine.Solution",include.COMSYS.$$$YES(m$)));
    }
    //<< }
    //<< 
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< OnBeforeButtonLine(&pstrYMFELD,pstrYFELD,pstrPARA)
  public Object OnBeforeButtonLine(Object ... _p) {
    mVar pstrYMFELD = m$.newVarRef("pstrYMFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrYFELD = m$.newVarRef("pstrYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrPARA = m$.newVarRef("pstrPARA",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Manuals for patient
    //<< ;
    //<< ; History :
    //<< ; 08-Apr-2013   SCR     HEVA-875: Flag Read Only for core rules
    //<< ; 26-Feb-2013   SCR     HEVA-866: Add PRN Field
    //<< ; 15-Jan-2013   SCR     HEVA-751: Use Solution Status function
    //<< ; 10-Jan-2013   SCR     HEVA-754: Infusion Unit not being showed in the Solution Prescription form
    //<< ; 29-Nov-2012   SCR     SR18214: Added Administer only & Corrected Infusion pump
    //<< ; 08-Nov-2012   SCR     SR18188: Corrected From Date fomatting
    //<< ; 05-Nov-2012   SCR     SR18141: Pass in YKEY to PatientData
    //<< ; 18-Oct-2012   SCR     SR18142: Default Dates and Duration
    //<< ; 18-Oct-2012   SCR     SR18139: Default frequency
    //<< ; 11-Oct-2012   SCR     SR18143: Dont default values from previous line
    //<< ; 30-May-2012   SCR     SR17993: Moved code to Form Construction
    //<< ; 23-May-2012   SCR     SR17993: set solution when direct line link is uded ie YKEY=PM234,3
    //<< ; 09-May-2012   SCR     SR18993: Get 1st Line of the of the Solution if no line is provided
    //<< ; 26-Apr-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< //#dim objLine As %String
    //<< //#dim intSol,idStatus As %Integer
    //<< new objLine,intSol,idStatus,idPatient,objPrescription,idPrescription,blnNewRx,objSetup,idFreq
    mVar objLine = m$.var("objLine");
    mVar intSol = m$.var("intSol");
    mVar idStatus = m$.var("idStatus");
    mVar idPatient = m$.var("idPatient");
    mVar objPrescription = m$.var("objPrescription");
    mVar idPrescription = m$.var("idPrescription");
    mVar blnNewRx = m$.var("blnNewRx");
    mVar objSetup = m$.var("objSetup");
    mVar idFreq = m$.var("idFreq");
    m$.newVar(objLine,intSol,idStatus,idPatient,objPrescription,idPrescription,blnNewRx,objSetup,idFreq);
    //<< new idLineStatus
    mVar idLineStatus = m$.var("idLineStatus");
    m$.newVar(idLineStatus);
    //<< set objSetup=$get(^MEDPrescriptionSetup(0,YM,1)) ; HEVA-754
    objSetup.set(m$.Fnc.$get(m$.var("^MEDPrescriptionSetup",0,m$.var("YM").get(),1)));
    //<< if $get(pstrPARA)["GridLine," {
    if (mOp.Contains(m$.Fnc.$get(pstrPARA),"GridLine,")) {
      //<< set ^CacheTemp(YUSER,"GridLine") = $piece(pstrPARA,",",2)
      m$.var("^CacheTemp",m$.var("YUSER").get(),"GridLine").set(m$.Fnc.$piece(pstrPARA.get(),",",2));
      //<< set pstrPARA=""
      pstrPARA.set("");
    }
    //<< }
    //<< 
    //<< set idPrescription=$piece(YKEY,",",1)
    idPrescription.set(m$.Fnc.$piece(m$.var("YKEY").get(),",",1));
    //<< if idPrescription'="" {
    if (mOp.NotEqual(idPrescription.get(),"")) {
      //<< set objPrescription=$get(^MEDPrescription(YM,idPrescription,1))
      objPrescription.set(m$.Fnc.$get(m$.var("^MEDPrescription",m$.var("YM").get(),idPrescription.get(),1)));
      //<< set idPatient= $$$MEDPrescriptionPatientID(objPrescription)
      idPatient.set(include.MEDConst.$$$MEDPrescriptionPatientID(m$,objPrescription));
    }
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
    //<< 
    //<< set $$$MEDPrescriptionPatientID(pstrYFELD)=idPatient
    include.MEDConst.$$$MEDPrescriptionPatientIDSet(m$,pstrYFELD,idPatient.get());
    //<< if $get(pstrPARA)="" {
    if (mOp.Equal(m$.Fnc.$get(pstrPARA),"")) {
      //<< set intSol=$$Solution^MEDPrescriptionSolLine()
      intSol.set(m$.fnc$("MEDPrescriptionSolLine.Solution"));
      //<< for {
      for (;true;) {
        //<< set pstrPARA=$order(^MEDPrescriptionLine(YM,$piece(YKEY,",",1),pstrPARA))
        pstrPARA.set(m$.Fnc.$order(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),m$.Fnc.$piece(m$.var("YKEY").get(),",",1),pstrPARA.get())));
        //<< quit:pstrPARA=""
        if (mOp.Equal(pstrPARA.get(),"")) {
          break;
        }
        //<< set objLine=$get(^MEDPrescriptionLine(YM,$piece(YKEY,",",1),pstrPARA,1))
        objLine.set(m$.Fnc.$get(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),m$.Fnc.$piece(m$.var("YKEY").get(),",",1),pstrPARA.get(),1)));
        //<< quit:$$$MEDPrescriptionLineSolution(objLine)=intSol
        if (mOp.Equal(include.MEDConst.$$$MEDPrescriptionLineSolution(m$,objLine),intSol.get())) {
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< if $get(pstrPARA)="" {
    if (mOp.Equal(m$.Fnc.$get(pstrPARA),"")) {
    }
    //<< ;set pstrPARA=$order(^MEDPrescriptionLine(YM,$piece(YKEY,",",1),"")) ; SR18143
    //<< }
    //<< do PatientData^MEDPrescriptionHosp(.pstrYMFELD,YKEY)
    m$.Cmd.Do("MEDPrescriptionHosp.PatientData",pstrYMFELD,m$.var("YKEY").get());
    //<< ;do PatientData^MEDPrescriptionHosp(.pstrYMFELD,pstrYFELD)
    //<< if $get(pstrPARA)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pstrPARA),"")) {
      //<< set objLine=$get(^MEDPrescriptionLine(YM,$piece(YKEY,",",1),pstrPARA,1))
      objLine.set(m$.Fnc.$get(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),m$.Fnc.$piece(m$.var("YKEY").get(),",",1),pstrPARA.get(),1)));
      //<< 
      //<< set $piece(pstrYMFELD,Y,17) = $$$MEDPrescriptionLineFromDate(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),17).set(include.MEDConst.$$$MEDPrescriptionLineFromDate(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,18) = $$$MEDPrescriptionLineFromTime(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),18).set(include.MEDConst.$$$MEDPrescriptionLineFromTime(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,19) = $$$MEDPrescriptionLineDuration(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),19).set(include.MEDConst.$$$MEDPrescriptionLineDuration(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,20) = $$$MEDPrescriptionLineToDate(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),20).set(include.MEDConst.$$$MEDPrescriptionLineToDate(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,21) = $$$MEDPrescriptionLineToTime(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),21).set(include.MEDConst.$$$MEDPrescriptionLineToTime(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,22) = $$$MEDPrescriptionLineFrequency(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),22).set(include.MEDConst.$$$MEDPrescriptionLineFrequency(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,23) = $$$MEDPrescriptionLineRouteOfAdministration(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),23).set(include.MEDConst.$$$MEDPrescriptionLineRouteOfAdministration(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,24) = $$$MEDPrescriptionLineInfusionSpeed(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),24).set(include.MEDConst.$$$MEDPrescriptionLineInfusionSpeed(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,25) = $$$MEDPrescriptionLineInfusionUOM(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),25).set(include.MEDConst.$$$MEDPrescriptionLineInfusionUOM(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,26) = $$$MEDPrescriptionLineContinuous(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),26).set(include.MEDConst.$$$MEDPrescriptionLineContinuous(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,27) = $$$MEDPrescriptionLineInfusionTime(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),27).set(include.MEDConst.$$$MEDPrescriptionLineInfusionTime(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,28) = $$$MEDPrescriptionLineIfNeeded(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),28).set(include.MEDConst.$$$MEDPrescriptionLineIfNeeded(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,29) = $$$MEDPrescriptionLineUrgent(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),29).set(include.MEDConst.$$$MEDPrescriptionLineUrgent(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,30) = $$$MEDPrescriptionLineDiluentQty(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),30).set(include.MEDConst.$$$MEDPrescriptionLineDiluentQty(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,32) = $$$MEDPrescriptionLineInfusionPump(objLine) ; SR18214
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),32).set(include.MEDConst.$$$MEDPrescriptionLineInfusionPump(m$,objLine));
      //<< ;set $piece(pstrYMFELD,Y,32) = $$$MEDPrescriptionLineInfusionUOM(objLine)
      //<< set $piece(pstrYMFELD,Y,33) = $$$MEDPrescriptionLineRemarks(objLine)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),33).set(include.MEDConst.$$$MEDPrescriptionLineRemarks(m$,objLine));
      //<< if $$$MEDPrescriptionLineDiluentQty(objLine) && $$$MEDPrescriptionLineInfusionTime(objLine) {
      if (mOp.Logical(include.MEDConst.$$$MEDPrescriptionLineDiluentQty(m$,objLine)) && mOp.Logical(include.MEDConst.$$$MEDPrescriptionLineInfusionTime(m$,objLine))) {
        //<< set $piece(pstrYMFELD,Y,31) = +$justify($$$MEDPrescriptionLineDiluentQty(objLine) / $$$MEDPrescriptionLineInfusionTime(objLine),0,2)
        m$.pieceVar(pstrYMFELD,m$.var("Y").get(),31).set(mOp.Positive(m$.Fnc.$justify(mOp.Divide(include.MEDConst.$$$MEDPrescriptionLineDiluentQty(m$,objLine),include.MEDConst.$$$MEDPrescriptionLineInfusionTime(m$,objLine)),0,2)));
      }
      //<< }
      //<< set $piece(pstrYMFELD,Y,34) = $$UpdateVolume^MEDPrescriptionSolLine($$$YES,$$$YES)
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),34).set(m$.fnc$("MEDPrescriptionSolLine.UpdateVolume",include.COMSYS.$$$YES(m$),include.COMSYS.$$$YES(m$)));
      //<< set $piece(pstrYMFELD,Y,35) = $$$MEDPrescriptionLineAdministeronly(objLine) ; SR18214
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),35).set(include.MEDConst.$$$MEDPrescriptionLineAdministeronly(m$,objLine));
      //<< set $piece(pstrYMFELD,Y,36) = $$$MEDPrescriptionLinePRN(objLine) ; HEVA-866
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),36).set(include.MEDConst.$$$MEDPrescriptionLinePRN(m$,objLine));
    }
    //<< 
    //<< }
    //<< if $piece(pstrYMFELD,Y,17)="" set $piece(pstrYMFELD,Y,17)=+$h   ; SR18188
    if (mOp.Equal(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),17),"")) {
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),17).set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< ;if $piece(pstrYMFELD,Y,17)="" set $piece(pstrYMFELD,Y,17)="."
    //<< if $piece(pstrYMFELD,Y,18)="" set $piece(pstrYMFELD,Y,18)=$piece($h,",",2)
    if (mOp.Equal(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),18),"")) {
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),18).set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
    }
    //<< if $piece(pstrYMFELD,Y,19)="" set $piece(pstrYMFELD,Y,19)=1     ; SR18142
    if (mOp.Equal(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),19),"")) {
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),19).set(1);
    }
    //<< if $piece(pstrYMFELD,Y,20)="" set $piece(pstrYMFELD,Y,20)=$h+1  ; SR18142
    if (mOp.Equal(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),20),"")) {
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),20).set(mOp.Add(m$.Fnc.$horolog(),1));
    }
    //<< ;if $piece(pstrYMFELD,Y,20)="" set $piece(pstrYMFELD,Y,20)="."
    //<< if $piece(pstrYMFELD,Y,21)="" set $piece(pstrYMFELD,Y,21)=$piece($h,",",2) ;
    if (mOp.Equal(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),21),"")) {
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),21).set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
    }
    //<< if $piece(pstrYMFELD,Y,25)="" set $piece(pstrYMFELD,Y,25)= $$$MEDPrescriptionSetupDefaultInfusionUnit(objSetup) ; HEVA-754
    if (mOp.Equal(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),25),"")) {
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),25).set(include.MEDConst.$$$MEDPrescriptionSetupDefaultInfusionUnit(m$,objSetup));
    }
    //<< ;if $piece(pstrYMFELD,Y,25)="" set $piece(pstrYMFELD,Y,25)="1"  ; Drops per min
    //<< 
    //<< ; SR18139 vvvv
    //<< if $piece(pstrYMFELD,Y,22)="" {
    if (mOp.Equal(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),22),"")) {
      //<< ;set objSetup=$get(^MEDPrescriptionSetup(0,YM,1))
      //<< set idFreq  = $$$MEDPrescriptionSetupDefaultFrequency(objSetup)
      idFreq.set(include.MEDConst.$$$MEDPrescriptionSetupDefaultFrequency(m$,objSetup));
      //<< set $piece(pstrYMFELD,Y,22)=idFreq
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),22).set(idFreq.get());
    }
    //<< }
    //<< ; SR18139 ^^^^
    //<< 
    //<< set $piece(YMFELD,Y,13) = $piece(YKEY,",",1)
    m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),13).set(m$.Fnc.$piece(m$.var("YKEY").get(),",",1));
    //<< 
    //<< set idStatus= +$$$MEDPrescriptionStatus($get(objPrescription))
    idStatus.set(mOp.Positive(include.MEDConst.$$$MEDPrescriptionStatus(m$,m$.Fnc.$get(objPrescription))));
    //<< set idLineStatus= +$$SolutionStatus^MEDPrescriptionAutoClose(idPrescription,intSol) ; HEVA-751
    idLineStatus.set(mOp.Positive(m$.fnc$("MEDPrescriptionAutoClose.SolutionStatus",idPrescription.get(),intSol.get())));
    //<< ;set idLineStatus= +$$$MEDPrescriptionLineStatus($get(objLine))
    //<< 
    //<< set $piece(YMFELD,Y,11) = $$GetDescription^WWWStatus("MEDPrescription",idStatus,$get(SPRACHE))
    m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),11).set(m$.fnc$("WWWStatus.GetDescription","MEDPrescription",idStatus.get(),m$.Fnc.$get(m$.var("SPRACHE"))));
    //<< set $piece(YMFELD,Y,14) = $$GetDescription^WWWStatus("MEDPrescription",idLineStatus,$get(SPRACHE))
    m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),14).set(m$.fnc$("WWWStatus.GetDescription","MEDPrescription",idLineStatus.get(),m$.Fnc.$get(m$.var("SPRACHE"))));
    //<< 
    //<< 
    //<< 
    //<< set $piece(YMFELD,Y,37) = "" ; HEVA-875
    m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),37).set("");
    //<< if $piece(YKEY,",")'="" {
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),","),"")) {
      //<< if '$$Editable^MEDPrescription($piece(YKEY,","),1) {
      if (mOp.Not(m$.fnc$("MEDPrescription.Editable",m$.Fnc.$piece(m$.var("YKEY").get(),","),1))) {
        //<< set $$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly
        include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
        //<< set $piece(YMFELD,Y,37) = "x" ; HEVA-875
        m$.pieceVar(m$.var("YMFELD"),m$.var("Y").get(),37).set("x");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< StartForm(pKey)
  public Object StartForm(Object ... _p) {
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Start the form based prescription number in the key
    //<< ; Called By : Form MEDPrescriptionHospLine
    //<< ;
    //<< ; History :
    //<< ; 29-Mar-2012   SCR     SR17993 Created
    //<< ;-------------------------------------------------------------------------------
    //<< do Solution^MEDPrescriptionSolLine(1)
    m$.Cmd.Do("MEDPrescriptionSolLine.Solution",1);
    //<< do GoToForm^COMUtilForm("MEDPrescriptionSol",$piece(pKey,",",1))
    m$.Cmd.Do("COMUtilForm.GoToForm","MEDPrescriptionSol",m$.Fnc.$piece(pKey.get(),",",1));
    //<< quit
    return null;
  }

  //<< 
  //<< OnAfterDataFields(pidPres,pobjPres)
  public Object OnAfterDataFields(Object ... _p) {
    mVar pidPres = m$.newVarRef("pidPres",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjPres = m$.newVarRef("pobjPres",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; History :
    //<< ; 16-Jan-2012   shobby  HEVA-762: Included Javascript call
    //<< ;-------------------------------------------------------------------------------
    //<< do SetupJS^MEDDispenseJS(YVOR) ;HEVA-762
    m$.Cmd.Do("MEDDispenseJS.SetupJS",m$.var("YVOR").get());
    //<< quit 1
    return 1;
  }

  //<< 
  //<< 
  //<< OnAfterDataFields1(pidPres,pobjPres)
  public Object OnAfterDataFields1(Object ... _p) {
    mVar pidPres = m$.newVarRef("pidPres",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjPres = m$.newVarRef("pobjPres",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Code to run when called by the AfterDataField event on the @netManager form.
    //<< ;
    //<< ; History:
    //<< ; 13-Mar-2013   shobby  HEVA-883: Width of side panel
    //<< ; 13-Nov-2012   shobby  SR18183: Improved position of side panel.
    //<< ; 16-Jul-2012   SCR     SR17993: Added Java Script (From Dispense)
    //<< ; 29-Mar-2012   SCR     SR17993 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idPatient
    mVar idPatient = m$.var("idPatient");
    m$.newVar(idPatient);
    //<< set idPatient= $$$MEDPrescriptionPatientID(pobjPres)
    idPatient.set(include.MEDConst.$$$MEDPrescriptionPatientID(m$,pobjPres));
    //<< 
    //<< ;SR18183 write "<DIV style='border:1px solid black; position:absolute; top:91px; left:720px; width:220px; height:500px;'>"
    //<< write "<DIV id='MEDDD2' style='float:left; position:relative; top:42px;'>"
    m$.Cmd.Write("<DIV id='MEDDD2' style='float:left; position:relative; top:42px;'>");
    //<< write "<DIV style='border:1px ; top:75px; width:100%; '>"  ;HEVA-883
    m$.Cmd.Write("<DIV style='border:1px ; top:75px; width:100%; '>");
    //<< write "<DIV style='border:1px solid black; position:relative; top:0px; left:0px; width:100%; height:auto;'>"
    m$.Cmd.Write("<DIV style='border:1px solid black; position:relative; top:0px; left:0px; width:100%; height:auto;'>");
    //<< do ShowDrugs^MEDPrescriptionHospTable(idPatient)
    m$.Cmd.Do("MEDPrescriptionHospTable.ShowDrugs",idPatient.get());
    //<< write "</DIV>"
    m$.Cmd.Write("</DIV>");
    //<< write "</DIV>"
    m$.Cmd.Write("</DIV>");
    //<< write "</DIV>"
    m$.Cmd.Write("</DIV>");
    //<< 
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< LoadGrid(pYKEY,pobjPres)
  public Object LoadGrid(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjPres = m$.newVarRef("pobjPres",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Code for Grid Edit , depending on Prescription Type Hide / columns that are not
    //<< ; required.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Mar-2012   SCR     SR17993 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new enumPresType
    mVar enumPresType = m$.var("enumPresType");
    m$.newVar(enumPresType);
    //<< 
    //<< set enumPresType = $$$MEDPrescriptionPrescriptionType(pobjPres)
    enumPresType.set(include.MEDConst.$$$MEDPrescriptionPrescriptionType(m$,pobjPres));
    //<< ;set ^CacheTemp(YUSER,"Grid","MaxWidth")=500
    //<< 
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< OnBeforeSave(pstrYMFELD)
  public Object OnBeforeSave(Object ... _p) {
    mVar pstrYMFELD = m$.newVarRef("pstrYMFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Prepare manual field for adding to the line
    //<< ; required.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Dec-2012   shobby  HEVA-713: Include time in from date/to date validation
    //<< ; 05-Nov-2012   SCR     SR18188: Default Date & Time
    //<< ; 30-Oct-2012   SCR     SR18142: Date validation
    //<< ; 04-Jun-2012   SCR     SR17993: Time Validation
    //<< ; 26-Apr-2012   SCR     SR17993 Created
    //<< ;-------------------------------------------------------------------------------
    //<< //#dim arrLines As %ArrayOfDataTypes
    //<< //#dim idLine,objLine,strStatus As %String
    //<< //#dim intSol As %Integer
    //<< new arrLines,idLine,objLine,intSol,strStatus
    mVar arrLines = m$.var("arrLines");
    mVar idLine = m$.var("idLine");
    mVar objLine = m$.var("objLine");
    mVar intSol = m$.var("intSol");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(arrLines,idLine,objLine,intSol,strStatus);
    //<< 
    //<< ; FIXME handle status
    //<< do GetGridContents^COMGridEdit31G(.arrLines,"MEDPrescriptionSolLine")
    m$.Cmd.Do("COMGridEdit31G.GetGridContents",arrLines,"MEDPrescriptionSolLine");
    //<< ; SR18188 vvvv
    //<< set:'$piece(pstrYMFELD,Y,17) $piece(pstrYMFELD,Y,17)=+$h
    if (mOp.Not(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),17))) {
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),17).set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< set:'$piece(pstrYMFELD,Y,18) $piece(pstrYMFELD,Y,18)=$piece($h,",",2)
    if (mOp.Not(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),18))) {
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),18).set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
    }
    //<< set:'$piece(pstrYMFELD,Y,20) $piece(pstrYMFELD,Y,20)=$piece(pstrYMFELD,Y,17)+$piece(pstrYMFELD,Y,19)
    if (mOp.Not(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),20))) {
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),20).set(mOp.Add(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),17),m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),19)));
    }
    //<< set:'$piece(pstrYMFELD,Y,21) $piece(pstrYMFELD,Y,21)=$piece($h,",",2)
    if (mOp.Not(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),21))) {
      m$.pieceVar(pstrYMFELD,m$.var("Y").get(),21).set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
    }
    //<< 
    //<< ; SR18188 ^^^^
    //<< ; SR18142 vvvv
    //<< if $piece(pstrYMFELD,Y,17)<$h {
    if (mOp.Less(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),17),m$.Fnc.$horolog())) {
      //<< set Q=$$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
      //<< do ReturnError^COMUtils("MED01299")  ;From Date can not be back dated
      m$.Cmd.Do("COMUtils.ReturnError","MED01299");
    }
    //<< }
    //<< ;HEVA-713 if $piece(pstrYMFELD,Y,20)'>$piece(pstrYMFELD,Y,17) {
    //<< if ($piece(YMFELD,Y,20)*86400+$piece(YMFELD,Y,21))'>($piece(YMFELD,Y,17)*86400+$piece(YMFELD,Y,18)) {   ;HEVA-713
    if (mOp.NotGreater((mOp.Add(mOp.Multiply(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),20),86400),m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),21))),(mOp.Add(mOp.Multiply(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),17),86400),m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),18))))) {
      //<< set Q=$$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
      //<< do ReturnError^COMUtils("MED01264")  ;'To' date must be greater than 'From' date~
      m$.Cmd.Do("COMUtils.ReturnError","MED01264");
    }
    //<< }
    //<< ; SR18142 ^^^^
    //<< 
    //<< quit:$get(Q)=$$$QDontSave
    if (mOp.Equal(m$.Fnc.$get(m$.var("Q")),include.COMSYSWWW.$$$QDontSave(m$))) {
      return null;
    }
    //<< set idLine=""
    idLine.set("");
    //<< set intSol=$$Solution^MEDPrescriptionSolLine()
    intSol.set(m$.fnc$("MEDPrescriptionSolLine.Solution"));
    //<< for {
    for (;true;) {
      //<< set idLine=$order(arrLines(YKEY,idLine))
      idLine.set(m$.Fnc.$order(arrLines.var(m$.var("YKEY").get(),idLine.get())));
      //<< quit:idLine=""
      if (mOp.Equal(idLine.get(),"")) {
        break;
      }
      //<< set objLine=$get(arrLines(YKEY,idLine))
      objLine.set(m$.Fnc.$get(arrLines.var(m$.var("YKEY").get(),idLine.get())));
      //<< 
      //<< if $$$MEDPrescriptionLineSolution(objLine)'=intSol continue
      if (mOp.NotEqual(include.MEDConst.$$$MEDPrescriptionLineSolution(m$,objLine),intSol.get())) {
        continue;
      }
      //<< 
      //<< do UpdateLine^MEDPrescriptionSolLine(pstrYMFELD,.objLine)
      m$.Cmd.Do("MEDPrescriptionSolLine.UpdateLine",pstrYMFELD.get(),objLine);
      //<< 
      //<< set arrLines(YKEY,idLine) = objLine
      arrLines.var(m$.var("YKEY").get(),idLine.get()).set(objLine.get());
    }
    //<< 
    //<< 
    //<< }
    //<< do SetGridContents^COMGridEdit31G(.arrLines,1,"MEDPrescriptionSolLine")
    m$.Cmd.Do("COMGridEdit31G.SetGridContents",arrLines,1,"MEDPrescriptionSolLine");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< OnBlur(pstrYMFELD)
  public Object OnBlur(Object ... _p) {
    mVar pstrYMFELD = m$.newVarRef("pstrYMFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set the Infuse Time and Qty per Hour
    //<< ; required.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jan-2013   SCR     HEVA-753: Continuous Solution Dose Calculation
    //<< ; 30-Nov-2012   SCR     SR18216: Calculate Qty if Continuous is Set
    //<< ; 24-Oct-2012   SCR     SR18138: Convert Volume
    //<< ; 10-Oct-2012   SCR     SR18138: Pass in Unit
    //<< ; 21-Jun-2012   SCR     SR17993: Update Total Volume
    //<< ; 17-May-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intVolume,intRate,intTime,intQty,intQPH,idUnit,blnCont,objSetup,fltDays,fltHours
    mVar intVolume = m$.var("intVolume");
    mVar intRate = m$.var("intRate");
    mVar intTime = m$.var("intTime");
    mVar intQty = m$.var("intQty");
    mVar intQPH = m$.var("intQPH");
    mVar idUnit = m$.var("idUnit");
    mVar blnCont = m$.var("blnCont");
    mVar objSetup = m$.var("objSetup");
    mVar fltDays = m$.var("fltDays");
    mVar fltHours = m$.var("fltHours");
    m$.newVar(intVolume,intRate,intTime,intQty,intQPH,idUnit,blnCont,objSetup,fltDays,fltHours);
    //<< 
    //<< set intVolume   = $$UpdateVolume^MEDPrescriptionSolLine($$$YES)
    intVolume.set(m$.fnc$("MEDPrescriptionSolLine.UpdateVolume",include.COMSYS.$$$YES(m$)));
    //<< set idUnit      = $piece(pstrYMFELD,Y,25)   ;SR18138
    idUnit.set(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),25));
    //<< set intQty      = $piece(pstrYMFELD,Y,30)
    intQty.set(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),30));
    //<< set intRate     = $piece(pstrYMFELD,Y,24)
    intRate.set(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),24));
    //<< set blnCont     = $piece(pstrYMFELD,Y,26)   ;SR18216
    blnCont.set(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),26));
    //<< 
    //<< ; HEVA-753 vvvv
    //<< set fltDays     = (($piece(pstrYMFELD,Y,20)*86400)+$piece(pstrYMFELD,Y,21))-(($piece(pstrYMFELD,Y,17)*86400)+($piece(pstrYMFELD,Y,18)))
    fltDays.set(mOp.Subtract((mOp.Add((mOp.Multiply(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),20),86400)),m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),21))),(mOp.Add((mOp.Multiply(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),17),86400)),(m$.Fnc.$piece(pstrYMFELD.get(),m$.var("Y").get(),18))))));
    //<< set fltDays     = fltDays/86400
    fltDays.set(mOp.Divide(fltDays.get(),86400));
    //<< set fltHours    = fltDays*24
    fltHours.set(mOp.Multiply(fltDays.get(),24));
    //<< do InfuseTime^MEDPrescriptionSol(intVolume,.intQty,intRate,idUnit,.intTime,.intQPH,blnCont,fltHours)
    m$.Cmd.Do("MEDPrescriptionSol.InfuseTime",intVolume.get(),intQty,intRate.get(),idUnit.get(),intTime,intQPH,blnCont.get(),fltHours.get());
    //<< ; HEVA-753 ^^^^
    //<< ;do InfuseTime^MEDPrescriptionSol(intVolume,intQty,intRate,idUnit,.intTime,.intQPH) ; SR18138
    //<< 
    //<< set %TXT(1)=""
    m$.var("%TXT",1).set("");
    //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M27"_"~"_intTime
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M27"),"~"),intTime.get()));
    //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M31"_"~"_intQPH
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M31"),"~"),intQPH.get()));
    //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M34"_"~"_$$^WWWTR(0,12,intVolume) ;SR18138
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M34"),"~"),m$.fnc$("WWWTR.main",0,12,intVolume.get())));
    //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M30"_"~"_intQty  ;SR18216
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M30"),"~"),intQty.get()));
    //<< ;set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M34"_"~"_intVolume
    //<< ; HEVA-753 vvvv
    //<< if +blnCont {
    if (mOp.Logical(mOp.Positive(blnCont.get()))) {
      //<< set objSetup=$get(^MEDPrescriptionSetup(0,YM,1))
      objSetup.set(m$.Fnc.$get(m$.var("^MEDPrescriptionSetup",0,m$.var("YM").get(),1)));
      //<< set %TXT(1)=%TXT(1)_"#"_"Y"_YFORM_"M22"_"~"_$$$MEDPrescriptionSetupContinuousFrequency(objSetup)
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#"),"Y"),m$.var("YFORM").get()),"M22"),"~"),include.MEDConst.$$$MEDPrescriptionSetupContinuousFrequency(m$,objSetup)));
    }
    //<< }
    //<< 
    //<< ; HEVA-753 ^^^^
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< InfuseTime(pintVolume,&pintQty,pintRate,pidUnit,&pintTime=0,&pintQPH=0,pblnCont=0,pfltHours=0)
  public Object InfuseTime(Object ... _p) {
    mVar pintVolume = m$.newVarRef("pintVolume",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintQty = m$.newVarRef("pintQty",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintRate = m$.newVarRef("pintRate",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidUnit = m$.newVarRef("pidUnit",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pintTime = m$.newVarRef("pintTime",(((_p!=null)&&(_p.length>=5))?_p[4]:null),0);
    mVar pintQPH = m$.newVarRef("pintQPH",(((_p!=null)&&(_p.length>=6))?_p[5]:null),0);
    mVar pblnCont = m$.newVarRef("pblnCont",(((_p!=null)&&(_p.length>=7))?_p[6]:null),0);
    mVar pfltHours = m$.newVarRef("pfltHours",(((_p!=null)&&(_p.length>=8))?_p[7]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Calc the Infuse Time and Qty per Hour
    //<< ; required.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Jan-2013   SCR     HEVA-753: Use pintQty if not continuous
    //<< ; 10-Jan-2013   SCR     HEVA-753: Continuous Solution Dose Calculation
    //<< ; 30-Nov-2012   SCR     SR18216: Calculate Qty if Continuous is Set
    //<< ; 10-Oct-2012   SCR     SR18138: Use UnfuseTime data
    //<< ; 17-May-2012   SCR     SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intTotalDrops,objInfuseTime,intPerML,intPerHour
    mVar intTotalDrops = m$.var("intTotalDrops");
    mVar objInfuseTime = m$.var("objInfuseTime");
    mVar intPerML = m$.var("intPerML");
    mVar intPerHour = m$.var("intPerHour");
    m$.newVar(intTotalDrops,objInfuseTime,intPerML,intPerHour);
    //<< new blnCont,intCurQty
    mVar blnCont = m$.var("blnCont");
    mVar intCurQty = m$.var("intCurQty");
    m$.newVar(blnCont,intCurQty);
    //<< ; SR18216 vvvvvv
    //<< if pblnCont {
    if (mOp.Logical(pblnCont.get())) {
      //<< set intCurQty=1
      intCurQty.set(1);
    }
    //<< } else {
    else {
      //<< set intCurQty=pintQty
      intCurQty.set(pintQty.get());
    }
    //<< }
    //<< ; SR18216 ^^^^^^
    //<< ; SR18138 vvvvvv
    //<< if pidUnit'="" {
    if (mOp.NotEqual(pidUnit.get(),"")) {
      //<< set objInfuseTime=$get(^MEDInfuseTime(YM,pidUnit,1))
      objInfuseTime.set(m$.Fnc.$get(m$.var("^MEDInfuseTime",m$.var("YM").get(),pidUnit.get(),1)));
      //<< set intPerML = $$$MEDInfuseTimeUnitspermL(objInfuseTime)
      intPerML.set(include.MEDConst.$$$MEDInfuseTimeUnitspermL(m$,objInfuseTime));
      //<< set intPerHour = $$$MEDInfuseTimeUnitsperHour(objInfuseTime)
      intPerHour.set(include.MEDConst.$$$MEDInfuseTimeUnitsperHour(m$,objInfuseTime));
    }
    //<< }
    //<< set:'$get(intPerML) intPerML=20     ; Defualt
    if (mOp.Not(m$.Fnc.$get(intPerML))) {
      intPerML.set(20);
    }
    //<< set:'$get(intPerHour) intPerHour=60 ; Default
    if (mOp.Not(m$.Fnc.$get(intPerHour))) {
      intPerHour.set(60);
    }
    //<< if pblnCont {
    if (mOp.Logical(pblnCont.get())) {
      //<< set intTotalDrops=pintVolume*intPerML*intCurQty
      intTotalDrops.set(mOp.Multiply(mOp.Multiply(pintVolume.get(),intPerML.get()),intCurQty.get()));
    }
    //<< }
    //<< else {
    else {
      //<< set intTotalDrops=pintVolume*intPerML ; HEVA-753
      intTotalDrops.set(mOp.Multiply(pintVolume.get(),intPerML.get()));
    }
    //<< }
    //<< ;set intTotalDrops=pintVolume*intPerML ; HEVA-753
    //<< ;set intTotalDrops=pintVolume*intPerML*intCurQty ; SR18216
    //<< ;set intTotalDrops=pintVolume*intPerML*pintQty
    //<< if pintRate&intTotalDrops {
    if (mOp.Logical(mOp.And(pintRate.get(),intTotalDrops.get()))) {
      //<< set pintTime = intTotalDrops / (pintRate*intPerHour)
      pintTime.set(mOp.Divide(intTotalDrops.get(),(mOp.Multiply(pintRate.get(),intPerHour.get()))));
      //<< ; SR18138 ^^^^^^
      //<< ;set intTotalDrops=pintVolume*20*pintQty
      //<< ;if pintRate&intTotalDrops {
      //<< ;   set pintTime = intTotalDrops / (pintRate*60)
      //<< 
      //<< set pintQPH  = pintQty / pintTime
      pintQPH.set(mOp.Divide(pintQty.get(),pintTime.get()));
    }
    //<< }
    //<< set pintTime = +$justify(pintTime,0,2)
    pintTime.set(mOp.Positive(m$.Fnc.$justify(pintTime.get(),0,2)));
    //<< set pintQPH  = +$justify(pintQPH,0,2)
    pintQPH.set(mOp.Positive(m$.Fnc.$justify(pintQPH.get(),0,2)));
    //<< ; HEVA-753 vvvvvv
    //<< if pblnCont && pintTime && pfltHours {
    if (mOp.Logical(pblnCont.get()) && mOp.Logical(pintTime.get()) && mOp.Logical(pfltHours.get())) {
      //<< set pintQty=pfltHours/pintTime
      pintQty.set(mOp.Divide(pfltHours.get(),pintTime.get()));
      //<< set:pintQty\1'=pintQty pintQty=pintQty\1+1
      if (mOp.NotEqual(mOp.IntegerDivide(pintQty.get(),1),pintQty.get())) {
        pintQty.set(mOp.Add(mOp.IntegerDivide(pintQty.get(),1),1));
      }
    }
    //<< }
    //<< ; HEVA-753 ^^^^^^
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterSave(pidRx)
  public Object OnAfterSave(Object ... _p) {
    mVar pidRx = m$.newVarRef("pidRx",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Re-Number Lines
    //<< ; required.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jan-2013   SCR     HEVA-753: Continuous Solution Dose Calculation
    //<< ; 17-May-2012   SCR     SR17993 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intSol,idLine,objLine
    mVar intSol = m$.var("intSol");
    mVar idLine = m$.var("idLine");
    mVar objLine = m$.var("objLine");
    m$.newVar(intSol,idLine,objLine);
    //<< do ReNumber^MEDPrescriptionRenum(pidRx)
    m$.Cmd.Do("MEDPrescriptionRenum.ReNumber",pidRx.get());
    //<< set intSol=$get(^CacheTempMedRx(YUSER,"SOL-CUR"))
    intSol.set(m$.Fnc.$get(m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"SOL-CUR")));
    //<< set idLine=""
    idLine.set("");
    //<< for {
    for (;true;) {
      //<< set idLine=$order(^MEDPrescriptionLine(YM,pidRx ,idLine))
      idLine.set(m$.Fnc.$order(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),pidRx.get(),idLine.get())));
      //<< quit:idLine=""
      if (mOp.Equal(idLine.get(),"")) {
        break;
      }
      //<< set objLine=$get(^MEDPrescriptionLine(YM,pidRx,idLine,1))
      objLine.set(m$.Fnc.$get(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),pidRx.get(),idLine.get(),1)));
      //<< if $$$MEDPrescriptionLineSolution(objLine)=intSol {
      if (mOp.Equal(include.MEDConst.$$$MEDPrescriptionLineSolution(m$,objLine),intSol.get())) {
        //<< set $piece(pidRx,",",2)=idLine
        m$.pieceVar(pidRx,",",2).set(idLine.get());
        //<< quit
        break;
      }
    }
    //<< }
    //<< }
    //<< set ^CacheTempMedRx(YUSER,"SOL-Reload")=pidRx
    m$.var("^CacheTempMedRx",m$.var("YUSER").get(),"SOL-Reload").set(pidRx.get());
    //<< do UpdateAllSolutions($$$KEY1(pidRx)) ; HEVA-753
    m$.Cmd.Do("UpdateAllSolutions",include.COMSYSWWW.$$$KEY1(m$,pidRx));
    //<< quit
    return null;
  }

  //<< 
  //<< UpdateAllSolutions(pidRx)
  public Object UpdateAllSolutions(Object ... _p) {
    mVar pidRx = m$.newVarRef("pidRx",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update all Solutions for the Prescription
    //<< ; required.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jan-2013   SCR     HEVA-753: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLine,arrSol,intSol,objLine
    mVar idLine = m$.var("idLine");
    mVar arrSol = m$.var("arrSol");
    mVar intSol = m$.var("intSol");
    mVar objLine = m$.var("objLine");
    m$.newVar(idLine,arrSol,intSol,objLine);
    //<< set pidRx   = $$$KEY1(pidRx)
    pidRx.set(include.COMSYSWWW.$$$KEY1(m$,pidRx));
    //<< set idLine  = ""
    idLine.set("");
    //<< for {
    for (;true;) {
      //<< set idLine  = $order(^MEDPrescriptionLine(YM,pidRx,idLine))
      idLine.set(m$.Fnc.$order(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),pidRx.get(),idLine.get())));
      //<< quit:idLine=""
      if (mOp.Equal(idLine.get(),"")) {
        break;
      }
      //<< set objLine = $get(^MEDPrescriptionLine(YM,pidRx,idLine,1))
      objLine.set(m$.Fnc.$get(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),pidRx.get(),idLine.get(),1)));
      //<< set intSol  = $$$MEDPrescriptionLineSolution(objLine)
      intSol.set(include.MEDConst.$$$MEDPrescriptionLineSolution(m$,objLine));
      //<< set:intSol arrSol(intSol)=""
      if (mOp.Logical(intSol.get())) {
        arrSol.var(intSol.get()).set("");
      }
    }
    //<< }
    //<< set intSol=""
    intSol.set("");
    //<< for {
    for (;true;) {
      //<< set intSol  = $order(arrSol(intSol))
      intSol.set(m$.Fnc.$order(arrSol.var(intSol.get())));
      //<< quit:intSol=""
      if (mOp.Equal(intSol.get(),"")) {
        break;
      }
      //<< do UpdateSolution(pidRx,intSol)
      m$.Cmd.Do("UpdateSolution",pidRx.get(),intSol.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< UpdateSolution(pidRx,pintSol)
  public Object UpdateSolution(Object ... _p) {
    mVar pidRx = m$.newVarRef("pidRx",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintSol = m$.newVarRef("pintSol",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update Solution Infuse time and Qty for the Prescription
    //<< ; required.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jan-2013   SCR     HEVA-753: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intSaveSol,intVolume,idLine,objLine,idUnit,intQty,intRate,blnCont,strStatus,intSol,intQPH,intTime,fltDays,fltHours
    mVar intSaveSol = m$.var("intSaveSol");
    mVar intVolume = m$.var("intVolume");
    mVar idLine = m$.var("idLine");
    mVar objLine = m$.var("objLine");
    mVar idUnit = m$.var("idUnit");
    mVar intQty = m$.var("intQty");
    mVar intRate = m$.var("intRate");
    mVar blnCont = m$.var("blnCont");
    mVar strStatus = m$.var("strStatus");
    mVar intSol = m$.var("intSol");
    mVar intQPH = m$.var("intQPH");
    mVar intTime = m$.var("intTime");
    mVar fltDays = m$.var("fltDays");
    mVar fltHours = m$.var("fltHours");
    m$.newVar(intSaveSol,intVolume,idLine,objLine,idUnit,intQty,intRate,blnCont,strStatus,intSol,intQPH,intTime,fltDays,fltHours);
    //<< 
    //<< ; Get 1st line of the solution
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
      //<< set objLine = $get(^MEDPrescriptionLine(YM,pidRx,idLine,1))
      objLine.set(m$.Fnc.$get(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),pidRx.get(),idLine.get(),1)));
      //<< set intSol  = $$$MEDPrescriptionLineSolution(objLine)
      intSol.set(include.MEDConst.$$$MEDPrescriptionLineSolution(m$,objLine));
      //<< quit:intSol=pintSol
      if (mOp.Equal(intSol.get(),pintSol.get())) {
        break;
      }
    }
    //<< }
    //<< quit:idLine="" ; Early Exit, no line found for the solution
    if (mOp.Equal(idLine.get(),"")) {
      return null;
    }
    //<< 
    //<< 
    //<< set intSaveSol  = $$Solution^MEDPrescriptionSolLine(,pintSol) ; Save current Solution ;HEVA-799
    intSaveSol.set(m$.fnc$("MEDPrescriptionSolLine.Solution",null,pintSol.get()));
    //<< 
    //<< set intVolume   = $$UpdateVolume^MEDPrescriptionSolLine($$$YES,$$$YES,pidRx)
    intVolume.set(m$.fnc$("MEDPrescriptionSolLine.UpdateVolume",include.COMSYS.$$$YES(m$),include.COMSYS.$$$YES(m$),pidRx.get()));
    //<< 
    //<< set idUnit      = $$$MEDPrescriptionLineInfusionUOM(objLine)
    idUnit.set(include.MEDConst.$$$MEDPrescriptionLineInfusionUOM(m$,objLine));
    //<< set intQty      = $$$MEDPrescriptionLineDiluentQty(objLine)
    intQty.set(include.MEDConst.$$$MEDPrescriptionLineDiluentQty(m$,objLine));
    //<< set intRate     = $$$MEDPrescriptionLineInfusionSpeed(objLine)
    intRate.set(include.MEDConst.$$$MEDPrescriptionLineInfusionSpeed(m$,objLine));
    //<< set blnCont     = $$$MEDPrescriptionLineContinuous(objLine)
    blnCont.set(include.MEDConst.$$$MEDPrescriptionLineContinuous(m$,objLine));
    //<< 
    //<< set fltDays     = (($$$MEDPrescriptionLineToDate(objLine)*86400)+$$$MEDPrescriptionLineToTime(objLine))-(($$$MEDPrescriptionLineFromDate(objLine)*86400)+($$$MEDPrescriptionLineFromTime(objLine))) ;HEVA-713
    fltDays.set(mOp.Subtract((mOp.Add((mOp.Multiply(include.MEDConst.$$$MEDPrescriptionLineToDate(m$,objLine),86400)),include.MEDConst.$$$MEDPrescriptionLineToTime(m$,objLine))),(mOp.Add((mOp.Multiply(include.MEDConst.$$$MEDPrescriptionLineFromDate(m$,objLine),86400)),(include.MEDConst.$$$MEDPrescriptionLineFromTime(m$,objLine))))));
    //<< set fltDays     = fltDays/86400
    fltDays.set(mOp.Divide(fltDays.get(),86400));
    //<< set fltHours    = fltDays*24
    fltHours.set(mOp.Multiply(fltDays.get(),24));
    //<< do InfuseTime^MEDPrescriptionSol(intVolume,.intQty,intRate,idUnit,.intTime,.intQPH,blnCont,fltHours)
    m$.Cmd.Do("MEDPrescriptionSol.InfuseTime",intVolume.get(),intQty,intRate.get(),idUnit.get(),intTime,intQPH,blnCont.get(),fltHours.get());
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
      //<< set objLine = $get(^MEDPrescriptionLine(YM,pidRx,idLine,1))
      objLine.set(m$.Fnc.$get(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),pidRx.get(),idLine.get(),1)));
      //<< set intSol  = $$$MEDPrescriptionLineSolution(objLine)
      intSol.set(include.MEDConst.$$$MEDPrescriptionLineSolution(m$,objLine));
      //<< if intSol=pintSol {
      if (mOp.Equal(intSol.get(),pintSol.get())) {
        //<< set $$$MEDPrescriptionLineInfusionTime(objLine)         = intTime
        include.MEDConst.$$$MEDPrescriptionLineInfusionTimeSet(m$,objLine,intTime.get());
        //<< set $$$MEDPrescriptionLineDiluentQty(objLine)           = intQty
        include.MEDConst.$$$MEDPrescriptionLineDiluentQtySet(m$,objLine,intQty.get());
        //<< set $$$MEDPrescriptionLineDoseTotalQuantity(objLine)    = $$DoseTotal^MEDPrescriptionLine(objLine)
        include.MEDConst.$$$MEDPrescriptionLineDoseTotalQuantitySet(m$,objLine,m$.fnc$("MEDPrescriptionLine.DoseTotal",objLine.get()));
        //<< set strStatus = $$$Save("MEDPrescriptionLine",pidRx_","_idLine,objLine,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"MEDPrescriptionLine",mOp.Concat(mOp.Concat(pidRx.get(),","),idLine.get()),objLine,include.COMSYS.$$$YES(m$)));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< do Solution^MEDPrescriptionSolLine(,intSaveSol) ; Restore Current Solution ;HEVA-799
    m$.Cmd.Do("MEDPrescriptionSolLine.Solution",null,intSaveSol.get());
    //<< quit
    return null;
  }

  //<< 
  //<< OnAfterButtonLine(YFELD) ;SR18020
  public Object OnAfterButtonLine(Object ... _p) {
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< do Display^MEDPatientDetails($$$MEDPrescriptionPatientID(YFELD))
    m$.Cmd.Do("MEDPatientDetails.Display",include.MEDConst.$$$MEDPrescriptionPatientID(m$,YFELD));
    //<< quit
    return null;
  }

//<< 
}
