//*****************************************************************************
//** TASC - ALPHALINC - MAC VARMEDPrescription
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 21:00:55
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

//<< VARMEDPrescription
public class VARMEDPrescription extends mClass {

  public void main() {
    _VARMEDPrescription();
  }

  public void _VARMEDPrescription() {
  }

  //<< 
  //<< OnAfterDataFieldsCustom(pidPres,pobjPres)
  public Object OnAfterDataFieldsCustom(Object ... _p) {
    mVar pidPres = m$.newVarRef("pidPres",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjPres = m$.newVarRef("pobjPres",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Code to run when called by the AfterDataField event on the @netManager form.
    //<< ;
    //<< ; History:
    //<< ; 15-Sep-2010   PPP     SR16642: Added the List of Issues COMTable
    //<< ; 25-Jun-2009   DWR     SR16642: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idIssue
    mVar idIssue = m$.var("idIssue");
    m$.newVar(idIssue);
    //<< 
    //<< set YSTOP = $$$YES
    mVar YSTOP = m$.var("YSTOP");
    YSTOP.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< set YVOR = $get(^WWW120(0,YFORM,1))
    mVar YVOR = m$.var("YVOR");
    YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
    //<< do PrintJS^VARMEDPrescriptionLine(YVOR)
    m$.Cmd.Do("VARMEDPrescriptionLine.PrintJS",YVOR.get());
    //<< do PrintJS^VARMEDPrescription(YVOR)
    m$.Cmd.Do("VARMEDPrescription.PrintJS",YVOR.get());
    //<< 
    //<< if '$$$NoKey(pidPres) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pidPres))) {
      //<< do LoadGrid^MEDPrescription(pidPres,pobjPres)
      m$.Cmd.Do("MEDPrescription.LoadGrid",pidPres.get(),pobjPres.get());
      //<< 
      //<< if ($order(^INIssues(0,7,$$$Index(pidPres),""))'="") {   // SR16642:Issues/Dispenses
      if ((mOp.NotEqual(m$.Fnc.$order(m$.var("^INIssues",0,7,include.MEDConst.$$$Index(m$,pidPres),"")),""))) {
        //<< quit:($$$MEDPrescriptionStatus(pobjPres)=8)
        if ((mOp.Equal(include.MEDConst.$$$MEDPrescriptionStatus(m$,pobjPres),8))) {
          return null;
        }
        //<< 
        //<< do ShowIssue^MEDPrescriptionShow(pidPres)
        m$.Cmd.Do("MEDPrescriptionShow.ShowIssue",pidPres.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< OnBlurPaciente(pYFELD="")
  public Object OnBlurPaciente(Object ... _p) {
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : Form MEDPrescription - F2
    //<< ;                                      do OnBlurPaciente^VARMEDPrescription(YFELD)
    //<< ; Load COMTempList with Authorized person by Patient ID
    //<< ;
    //<< ; History:
    //<< ; 23-MaR-2011   Karine      Creates: Customization for Prescription
    //<< ;                           Created by Natalias's demand
    //<< ;--------------------------------------------------------------------------------
    //<< 
    //<< new idPaciente, noResponsavel, noPaciente, objAutorizacao, idInternacao, dtAlta, dtAdmission, objAdmission, tpDispensacao
    mVar idPaciente = m$.var("idPaciente");
    mVar noResponsavel = m$.var("noResponsavel");
    mVar noPaciente = m$.var("noPaciente");
    mVar objAutorizacao = m$.var("objAutorizacao");
    mVar idInternacao = m$.var("idInternacao");
    mVar dtAlta = m$.var("dtAlta");
    mVar dtAdmission = m$.var("dtAdmission");
    mVar objAdmission = m$.var("objAdmission");
    mVar tpDispensacao = m$.var("tpDispensacao");
    m$.newVar(idPaciente,noResponsavel,noPaciente,objAutorizacao,idInternacao,dtAlta,dtAdmission,objAdmission,tpDispensacao);
    //<< 
    //<< set objAutorizacao = ""
    objAutorizacao.set("");
    //<< if pYFELD '= "" {
    if (mOp.NotEqual(pYFELD.get(),"")) {
      //<< 
      //<< set %TXT(1) = ""
      m$.var("%TXT",1).set("");
      //<< 
      //<< kill ^COMTempList(YM,YBED,"ResponsavelPeloPaciente")
      m$.var("^COMTempList",m$.var("YM").get(),m$.var("YBED").get(),"ResponsavelPeloPaciente").kill();
      //<< 
      //<< set idPaciente = $$$MEDPrescriptionPatientID(pYFELD)
      idPaciente.set(include.MEDConst.$$$MEDPrescriptionPatientID(m$,pYFELD));
      //<< set tpDispensacao = $$$MEDPrescriptionIssueType(pYFELD)
      tpDispensacao.set(include.MEDConst.$$$MEDPrescriptionIssueType(m$,pYFELD));
      //<< 
      //<< if idPaciente '= "" {
      if (mOp.NotEqual(idPaciente.get(),"")) {
        //<< if ((tpDispensacao '= "E") && (tpDispensacao '= "I")) {
        if (mOp.Logical(((mOp.NotEqual(tpDispensacao.get(),"E")) && (mOp.NotEqual(tpDispensacao.get(),"I"))))) {
          //<< set %TXT(1)=%TXT(1)_"#YMEDPrescriptionD31~REMOVE"    ;MEDAuthorize
          m$.var("%TXT",1).set(mOp.Concat(m$.var("%TXT",1).get(),"#YMEDPrescriptionD31~REMOVE"));
          //<< set %TXT(1)=%TXT(1)_"#YMEDPrescriptionD20~REMOVE"    ;MEDAdmission
          m$.var("%TXT",1).set(mOp.Concat(m$.var("%TXT",1).get(),"#YMEDPrescriptionD20~REMOVE"));
          //<< set %TXT(1)=%TXT(1)_"#YMEDPrescriptionD13~REMOVE"   ;Local Disp
          m$.var("%TXT",1).set(mOp.Concat(m$.var("%TXT",1).get(),"#YMEDPrescriptionD13~REMOVE"));
          //<< set position = 0
          mVar position = m$.var("position");
          position.set(0);
          //<< 
          //<< // Relação da Autorização por paciente
          //<< $$$Order4(^MEDAuthorizes,YM,100,idPaciente,idAutorizacao)
          mVar idAutorizacao = m$.var("idAutorizacao");
          idAutorizacao.set("");
          for (;true;) {
            idAutorizacao.set(m$.Fnc.$order(m$.var("^MEDAuthorizes",m$.var("YM").get(),100,idPaciente.get(),idAutorizacao.get())));
            if (mOp.Equal(idAutorizacao.get(),"")) {
              break;
            }
            //<< set objAutorizacao=$get(^MEDAuthorize(0,idAutorizacao,1))
            objAutorizacao.set(m$.Fnc.$get(m$.var("^MEDAuthorize",0,idAutorizacao.get(),1)));
            //<< set noResponsavel  = $piece(objAutorizacao,Y,2)
            noResponsavel.set(m$.Fnc.$piece(objAutorizacao.get(),m$.var("Y").get(),2));
            //<< 
            //<< set position = $i(position)
            position.set(m$.Fnc.$increment(position));
            //<< set %TXT(1) = %TXT(1)_"#YMEDPrescriptionD31"_"~"_idAutorizacao_"~"_noResponsavel_"~"_position
            m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#YMEDPrescriptionD31"),"~"),idAutorizacao.get()),"~"),noResponsavel.get()),"~"),position.get()));
            //<< set ^COMTempList(YM,YBED,"ResponsavelPeloPaciente",idAutorizacao,1) = idPaciente_Y_noResponsavel
            m$.var("^COMTempList",m$.var("YM").get(),m$.var("YBED").get(),"ResponsavelPeloPaciente",idAutorizacao.get(),1).set(mOp.Concat(mOp.Concat(idPaciente.get(),m$.var("Y").get()),noResponsavel.get()));
          }
          //<< $$$End
          //<< 
          //<< set position = 0
          position.set(0);
        }
      }
      //<< }
      //<< }
      //<< if objAutorizacao = "" {
      if (mOp.Equal(objAutorizacao.get(),"")) {
        //<< set %TXT(1)=%TXT(1)_"#YMEDPrescriptionD20~REMOVE"    ;MEDAdmission
        m$.var("%TXT",1).set(mOp.Concat(m$.var("%TXT",1).get(),"#YMEDPrescriptionD20~REMOVE"));
        //<< set %TXT(1)=%TXT(1)_"#YMEDPrescriptionD13~REMOVE"   ;Local Disp
        m$.var("%TXT",1).set(mOp.Concat(m$.var("%TXT",1).get(),"#YMEDPrescriptionD13~REMOVE"));
      }
    }
    //<< }
    //<< 
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< OnBlurDueDate(pYINHALT)
  public Object OnBlurDueDate(Object ... _p) {
    mVar pYINHALT = m$.newVarRef("pYINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : Form MEDPrescription F12
    //<< ;
    //<< ; History :
    //<< ; 24-Mar-2011   Karine  Created
    //<< ;-------------------------------------------------------------------------------
    //<< if ($zdateh(pYINHALT,4) < $horolog) {
    if ((mOp.Less(m$.Fnc.$zdateh(pYINHALT.get(),4),m$.Fnc.$horolog()))) {
      //<< $$$Alert("A data desejada não pode ser menor que a data atual.")
      include.COMSYS.$$$Alert(m$,"A data desejada não pode ser menor que a data atual.");
      //<< set %TXT(1)=%TXT(1)_"#Y"_YFORM_"D14~"_""
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#Y"),m$.var("YFORM").get()),"D14~"),""));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< getRegistroInternacao(pYKEY, pYFELD="")
  public Object getRegistroInternacao(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : Form MEDPrescription D20/F5 - ReasonForAdmission - VARRules
    //<< ;
    //<< ; History :
    //<< ; 05-Jul-2011   Karine  Created
    //<< ; @$$getRegistroInternacao^VARMEDPrescription(YKEY,YFELD)
    //<< ;-------------------------------------------------------------------------------
    //<< new idPaciente, idInternacao, objAdmission, dtAdmission, dtAlta, vLocalIn, position, setIDinternacao
    mVar idPaciente = m$.var("idPaciente");
    mVar idInternacao = m$.var("idInternacao");
    mVar objAdmission = m$.var("objAdmission");
    mVar dtAdmission = m$.var("dtAdmission");
    mVar dtAlta = m$.var("dtAlta");
    mVar vLocalIn = m$.var("vLocalIn");
    mVar position = m$.var("position");
    mVar setIDinternacao = m$.var("setIDinternacao");
    m$.newVar(idPaciente,idInternacao,objAdmission,dtAdmission,dtAlta,vLocalIn,position,setIDinternacao);
    //<< 
    //<< set setIDinternacao = ""
    setIDinternacao.set("");
    //<< 
    //<< if '$$$NoKey(pYKEY) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pYKEY))) {
      //<< 
      //<< set idPaciente = $$$MEDPrescriptionPatientID(pYFELD)
      idPaciente.set(include.MEDConst.$$$MEDPrescriptionPatientID(m$,pYFELD));
      //<< set tpDispensacao = $$$MEDPrescriptionIssueType(pYFELD)
      mVar tpDispensacao = m$.var("tpDispensacao");
      tpDispensacao.set(include.MEDConst.$$$MEDPrescriptionIssueType(m$,pYFELD));
      //<< 
      //<< if idPaciente '= ""{
      if (mOp.NotEqual(idPaciente.get(),"")) {
        //<< if (tpDispensacao = "E") || (tpDispensacao = "I") {
        if ((mOp.Equal(tpDispensacao.get(),"E")) || (mOp.Equal(tpDispensacao.get(),"I"))) {
          //<< set setIDinternacao = $$getRegInternacaoValida^VARMEDAdmission(idPaciente)
          setIDinternacao.set(m$.fnc$("VARMEDAdmission.getRegInternacaoValida",idPaciente.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit setIDinternacao
    return setIDinternacao.get();
  }

  //<< 
  //<< 
  //<< 
  //<< getRegistroLocalInternacao(pYFELD="")
  public Object getRegistroLocalInternacao(Object ... _p) {
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : Form MEDPrescription D20/F5 - ReasonForAdmission - VARRules
    //<< ;
    //<< ; History :
    //<< ; 05-Jul-2011   Karine  Created
    //<< ; @$$getRegistroLocalInternacao^VARMEDPrescription(YKEY,YFELD)
    //<< ;-------------------------------------------------------------------------------
    //<< new idPaciente, idInternacao, objAdmission, dtAdmission, dtAlta, vLocalIn, position, setIDinternacao
    mVar idPaciente = m$.var("idPaciente");
    mVar idInternacao = m$.var("idInternacao");
    mVar objAdmission = m$.var("objAdmission");
    mVar dtAdmission = m$.var("dtAdmission");
    mVar dtAlta = m$.var("dtAlta");
    mVar vLocalIn = m$.var("vLocalIn");
    mVar position = m$.var("position");
    mVar setIDinternacao = m$.var("setIDinternacao");
    m$.newVar(idPaciente,idInternacao,objAdmission,dtAdmission,dtAlta,vLocalIn,position,setIDinternacao);
    //<< 
    //<< set setLocalinternacao = ""
    mVar setLocalinternacao = m$.var("setLocalinternacao");
    setLocalinternacao.set("");
    //<< 
    //<< 
    //<< if pYFELD '= "" {
    if (mOp.NotEqual(pYFELD.get(),"")) {
      //<< 
      //<< set idInternacao = $$$MEDPrescriptionReasonForAdmission(pYFELD)
      idInternacao.set(include.MEDConst.$$$MEDPrescriptionReasonForAdmission(m$,pYFELD));
      //<< 
      //<< if (idInternacao '= "") {
      if ((mOp.NotEqual(idInternacao.get(),""))) {
        //<< set tpDispensacao = $$$MEDPrescriptionIssueType(pYFELD)
        mVar tpDispensacao = m$.var("tpDispensacao");
        tpDispensacao.set(include.MEDConst.$$$MEDPrescriptionIssueType(m$,pYFELD));
        //<< 
        //<< if ((tpDispensacao = "E") || (tpDispensacao = "I")) {
        if (mOp.Logical(((mOp.Equal(tpDispensacao.get(),"E")) || (mOp.Equal(tpDispensacao.get(),"I"))))) {
          //<< 
          //<< set objAdmission=$get(^MEDAdmission(YM,idInternacao,1))
          objAdmission.set(m$.Fnc.$get(m$.var("^MEDAdmission",m$.var("YM").get(),idInternacao.get(),1)));
          //<< set setLocalinternacao = $piece(objAdmission,Y,2)
          setLocalinternacao.set(m$.Fnc.$piece(objAdmission.get(),m$.var("Y").get(),2));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit setLocalinternacao
    return setLocalinternacao.get();
  }

  //<< 
  //<< 
  //<< OnBeforeDataAccess(pYKEY,pYFELD,pYFORM)
  public Object OnBeforeDataAccess(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Chamada em VARHooks da CLASSE INPARA : OnBeforeDataAccess^VARMEDPrescription(.YKEY,YFELD,YFORM)
    //<< ; Filtra os dados da INPARA, para o parâmetro : ISSUETYPE
    //<< ;                                               Não apresentar o "W" - Venda
    //<< ;                                                                "H" - Programas de saúde
    //<< ;
    //<< ; History:
    //<< ; 06-Jul-2011   Karine      Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnFilter, perfilUsuario, keyParam, keyLang, keyType
    mVar blnFilter = m$.var("blnFilter");
    mVar perfilUsuario = m$.var("perfilUsuario");
    mVar keyParam = m$.var("keyParam");
    mVar keyLang = m$.var("keyLang");
    mVar keyType = m$.var("keyType");
    m$.newVar(blnFilter,perfilUsuario,keyParam,keyLang,keyType);
    //<< set blnFilter = $$$YES
    blnFilter.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< set keyType = ""
    keyType.set("");
    //<< if '$$$NoKey(pYKEY) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pYKEY))) {
      //<< if (pYFORM = "MEDPrescription") || (pYFORM = "INARTPACK")  {
      if ((mOp.Equal(pYFORM.get(),"MEDPrescription")) || (mOp.Equal(pYFORM.get(),"INARTPACK"))) {
        //<< 
        //<< //Não aplicar filtros ao administrador do sistema
        //<< set perfilUsuario = $piece($get(^WWW013(YM,YBED,1)),Y,3)
        perfilUsuario.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",m$.var("YM").get(),m$.var("YBED").get(),1)),m$.var("Y").get(),3));
        //<< quit:(perfilUsuario = 1) $$$YES
        if ((mOp.Equal(perfilUsuario.get(),1))) {
          return include.COMSYS.$$$YES(m$);
        }
        //<< 
        //<< set keyParam = $piece(pYKEY,",",1)  ; ISSUETYPE
        keyParam.set(m$.Fnc.$piece(pYKEY.get(),",",1));
        //<< set keyLang = $piece(pYKEY,",",2)   ; PT
        keyLang.set(m$.Fnc.$piece(pYKEY.get(),",",2));
        //<< set keyType = $piece(pYKEY,",",3)   ; se W e H, não mostrar
        keyType.set(m$.Fnc.$piece(pYKEY.get(),",",3));
        //<< 
        //<< quit:(keyParam '= "ISSUETYPE") $$$YES
        if ((mOp.NotEqual(keyParam.get(),"ISSUETYPE"))) {
          return include.COMSYS.$$$YES(m$);
        }
        //<< 
        //<< if (keyType = "W") || (keyType = "H") {
        if ((mOp.Equal(keyType.get(),"W")) || (mOp.Equal(keyType.get(),"H"))) {
          //<< set blnFilter = $$$NO
          blnFilter.set(include.COMSYS.$$$NO(m$));
          //<< set YKEY = ""
          mVar YKEY = m$.var("YKEY");
          YKEY.set("");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnFilter
    return blnFilter.get();
  }

  //<< 
  //<< 
  //<< CanCreateReq(pYKEY)
  public Object CanCreateReq(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:($$$NoKey(pYKEY))
    if (mOp.Logical((include.COMSYS.$$$NoKey(m$,pYKEY)))) {
      return null;
    }
    //<< 
    //<< //Movimentação de abastecimento
    //<< 
    //<< new strStatus, objPrescricao, blnValidFarmaceutica, tipoDispensacao, blnValidFarmaceutica,
    //<< status, DispensingLocn, statusAbastecimento
    mVar strStatus = m$.var("strStatus");
    mVar objPrescricao = m$.var("objPrescricao");
    mVar blnValidFarmaceutica = m$.var("blnValidFarmaceutica");
    mVar tipoDispensacao = m$.var("tipoDispensacao");
    mVar status = m$.var("status");
    mVar DispensingLocn = m$.var("DispensingLocn");
    mVar statusAbastecimento = m$.var("statusAbastecimento");
    m$.newVar(strStatus,objPrescricao,blnValidFarmaceutica,tipoDispensacao,blnValidFarmaceutica,status,DispensingLocn,statusAbastecimento);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set objPrescricao = $get(^MEDPrescription(YM,pYKEY,1))
    objPrescricao.set(m$.Fnc.$get(m$.var("^MEDPrescription",m$.var("YM").get(),pYKEY.get(),1)));
    //<< 
    //<< set YQ = $$$YQEnable
    mVar YQ = m$.var("YQ");
    YQ.set(include.COMSYSWWW.$$$YQEnable(m$));
    //<< 
    //<< set tipoDispensacao = $$$MEDPrescriptionIssueType(objPrescricao)
    tipoDispensacao.set(include.MEDConst.$$$MEDPrescriptionIssueType(m$,objPrescricao));
    //<< if (tipoDispensacao '= "I") {
    if ((mOp.NotEqual(tipoDispensacao.get(),"I"))) {
      //<< set YQ = $$$YQDisable("A prescrição não é do tipo internado.")
      YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"A prescrição não é do tipo internado."));
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< set blnValidFarmaceutica = $$$MEDPrescriptionFREE2(objPrescricao)
    blnValidFarmaceutica.set(include.MEDConst.$$$MEDPrescriptionFREE2(m$,objPrescricao));
    //<< if (blnValidFarmaceutica '= $$$YES) {
    if ((mOp.NotEqual(blnValidFarmaceutica.get(),include.COMSYS.$$$YES(m$)))) {
      //<< set YQ = $$$YQDisable("A prescrição não exige validação farmacêutica.")
      YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"A prescrição não exige validação farmacêutica."));
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< set status = $$$MEDPrescriptionStatus(objPrescricao)
    status.set(include.MEDConst.$$$MEDPrescriptionStatus(m$,objPrescricao));
    //<< if (status = 1) {
    if ((mOp.Equal(status.get(),1))) {
      //<< set YQ = $$$YQDisable("A prescrição não está confirmada.")
      YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"A prescrição não está confirmada."));
      //<< quit
      return null;
    }
    //<< 
    //<< } elseif (status > 3) {
    else if ((mOp.Greater(status.get(),3))) {
      //<< set YQ = $$$YQDisable("A prescrição não está mais em atendimento.")
      YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"A prescrição não está mais em atendimento."));
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< set DispensingLocn = $$$MEDPrescriptionDispensingLocn(objPrescricao)
    DispensingLocn.set(include.MEDConst.$$$MEDPrescriptionDispensingLocn(m$,objPrescricao));
    //<< if (DispensingLocn = "") {
    if ((mOp.Equal(DispensingLocn.get(),""))) {
      //<< set YQ = $$$YQDisable("O local de dispensação precisa estar preenchido.")
      YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"O local de dispensação precisa estar preenchido."));
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< set statusAbastecimento = $$GetStatusAbastecimento(pYKEY)
    statusAbastecimento.set(m$.fnc$("GetStatusAbastecimento",pYKEY.get()));
    //<< if (statusAbastecimento > 1) {
    if ((mOp.Greater(statusAbastecimento.get(),1))) {
      //<< set YQ = $$$YQDisable("A dispensação já foi realizada.")
      YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"A dispensação já foi realizada."));
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CreateReq(pYKEY)
  public Object CreateReq(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:($$$NoKey(pYKEY))
    if (mOp.Logical((include.COMSYS.$$$NoKey(m$,pYKEY)))) {
      return null;
    }
    //<< 
    //<< new strStatus, idRequisicao, idUnfirmedReq
    mVar strStatus = m$.var("strStatus");
    mVar idRequisicao = m$.var("idRequisicao");
    mVar idUnfirmedReq = m$.var("idUnfirmedReq");
    m$.newVar(strStatus,idRequisicao,idUnfirmedReq);
    //<< 
    //<< set strStatus    = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< //Verifica se já abriu uma requisição para a prescrição
    //<< set idUnfirmedReq = $$GetUnfirmedReq(pYKEY)
    idUnfirmedReq.set(m$.fnc$("GetUnfirmedReq",pYKEY.get()));
    //<< 
    //<< if (idUnfirmedReq) {
    if (mOp.Logical((idUnfirmedReq.get()))) {
      //<< do GoToForm^COMUtilForm("INReq",idUnfirmedReq)
      m$.Cmd.Do("COMUtilForm.GoToForm","INReq",idUnfirmedReq.get());
      //<< quit
      return null;
    }
    //<< 
    //<< } else {
    else {
      //<< set idRequisicao = $$^WWWNEXT("INReq")
      idRequisicao.set(m$.fnc$("WWWNEXT.main","INReq"));
      //<< set strStatus = $$Transaction^COMTransaction("CreateReqFromPrescription^VARMEDPrescription("""_pYKEY_""","""_idRequisicao_""")")
      strStatus.set(m$.fnc$("COMTransaction.Transaction",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CreateReqFromPrescription^VARMEDPrescription(\"",pYKEY.get()),"\",\""),idRequisicao.get()),"\")")));
    }
    //<< }
    //<< 
    //<< //Redireciona para a tela de requisição
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< do GoToForm^COMUtilForm("INReq",idRequisicao)
      m$.Cmd.Do("COMUtilForm.GoToForm","INReq",idRequisicao.get());
    }
    //<< } else {
    else {
      //<< do ReturnError^COMUtilError(strStatus)
      m$.Cmd.Do("COMUtilError.ReturnError",strStatus.get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CreateReqFromPrescription(pYKEY,pidRequisicao)
  public Object CreateReqFromPrescription(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidRequisicao = m$.newVarRef("pidRequisicao",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit:($$$NoKey(pYKEY))
    if (mOp.Logical((include.COMSYS.$$$NoKey(m$,pYKEY)))) {
      return null;
    }
    //<< 
    //<< new objPrescricao, strStatus, objRequisicao, idPaciente, idRequisicaoLinha,
    //<< objRequisicaoLinha, key, idPrescricaoLinha, objPrescricaoLinha
    mVar objPrescricao = m$.var("objPrescricao");
    mVar strStatus = m$.var("strStatus");
    mVar objRequisicao = m$.var("objRequisicao");
    mVar idPaciente = m$.var("idPaciente");
    mVar idRequisicaoLinha = m$.var("idRequisicaoLinha");
    mVar objRequisicaoLinha = m$.var("objRequisicaoLinha");
    mVar key = m$.var("key");
    mVar idPrescricaoLinha = m$.var("idPrescricaoLinha");
    mVar objPrescricaoLinha = m$.var("objPrescricaoLinha");
    m$.newVar(objPrescricao,strStatus,objRequisicao,idPaciente,idRequisicaoLinha,objRequisicaoLinha,key,idPrescricaoLinha,objPrescricaoLinha);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set objPrescricao = $get(^MEDPrescription(YM,pYKEY,1))
    objPrescricao.set(m$.Fnc.$get(m$.var("^MEDPrescription",m$.var("YM").get(),pYKEY.get(),1)));
    //<< quit:(objPrescricao = "")
    if ((mOp.Equal(objPrescricao.get(),""))) {
      return null;
    }
    //<< 
    //<< set idPaciente = $$$MEDPrescriptionPatientID(objPrescricao)
    idPaciente.set(include.MEDConst.$$$MEDPrescriptionPatientID(m$,objPrescricao));
    //<< 
    //<< set strStatus    = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set objRequisicao = ""
    objRequisicao.set("");
    //<< 
    //<< set $$$INReqStatus(objRequisicao)   = 1           //Criada
    include.INConst.$$$INReqStatusSet(m$,objRequisicao,1);
    //<< set $$$INReqDate1(objRequisicao)    = $piece($horolog,",",1)
    include.INConst.$$$INReqDate1Set(m$,objRequisicao,m$.Fnc.$piece(m$.Fnc.$horolog(),",",1));
    //<< set $$$INReqToLocn(objRequisicao)   = $$$MEDPrescriptionDispensingLocn(objPrescricao)
    include.INConst.$$$INReqToLocnSet(m$,objRequisicao,include.MEDConst.$$$MEDPrescriptionDispensingLocn(m$,objPrescricao));
    //<< set $$$INReqFromLocn(objRequisicao) = YLOCATION
    include.INConst.$$$INReqFromLocnSet(m$,objRequisicao,m$.var("YLOCATION").get());
    //<< set $$$INReqDueDate(objRequisicao)  = $piece($horolog,",",1)
    include.INConst.$$$INReqDueDateSet(m$,objRequisicao,m$.Fnc.$piece(m$.Fnc.$horolog(),",",1));
    //<< set $$$INReqPriority(objRequisicao) = 2
    include.INConst.$$$INReqPrioritySet(m$,objRequisicao,2);
    //<< set $$$INReqType(objRequisicao)     = 1           //Entre Departamentos
    include.INConst.$$$INReqTypeSet(m$,objRequisicao,1);
    //<< set $$$INReqFREE8(objRequisicao)    = pYKEY       //No. da Prescrição, para utilizar como referência
    include.INConst.$$$INReqFREE8Set(m$,objRequisicao,pYKEY.get());
    //<< set $$$INReqFREE11(objRequisicao)   = "Movimentação de abastecimento para o núcleo de enfermagem criada para atender a prescrição nº "_YKEY_", paciente "_idPaciente_" - "_$piece($get(^MEDPatient(YM,idPaciente,1)),Y,23)_"."
    include.INConst.$$$INReqFREE11Set(m$,objRequisicao,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Movimentação de abastecimento para o núcleo de enfermagem criada para atender a prescrição nº ",m$.var("YKEY").get()),", paciente "),idPaciente.get())," - "),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^MEDPatient",m$.var("YM").get(),idPaciente.get(),1)),m$.var("Y").get(),23)),"."));
    //<< 
    //<< set strStatus = $$$Save("INReq",pidRequisicao,objRequisicao,$$$YES)
    strStatus.set(include.COMSYS.$$$Save(m$,"INReq",pidRequisicao,objRequisicao,include.COMSYS.$$$YES(m$)));
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< 
      //<< set idRequisicaoLinha = 0
      idRequisicaoLinha.set(0);
      //<< 
      //<< $$$Order3(^MEDPrescriptionLine,YM,pYKEY,idPrescricaoLinha)
      idPrescricaoLinha.set("");
      for (;true;) {
        idPrescricaoLinha.set(m$.Fnc.$order(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),pYKEY.get(),idPrescricaoLinha.get())));
        if (mOp.Equal(idPrescricaoLinha.get(),"")) {
          break;
        }
        //<< 
        //<< set idRequisicaoLinha = $increment(idRequisicaoLinha)
        idRequisicaoLinha.set(m$.Fnc.$increment(idRequisicaoLinha));
        //<< 
        //<< set objPrescricaoLinha = $get(^MEDPrescriptionLine(YM,pYKEY,idPrescricaoLinha,1))
        objPrescricaoLinha.set(m$.Fnc.$get(m$.var("^MEDPrescriptionLine",m$.var("YM").get(),pYKEY.get(),idPrescricaoLinha.get(),1)));
        //<< continue:(objPrescricaoLinha = "")
        if ((mOp.Equal(objPrescricaoLinha.get(),""))) {
          continue;
        }
        //<< 
        //<< set objRequisicaoLinha = ""
        objRequisicaoLinha.set("");
        //<< set $$$INReqLineItem(objRequisicaoLinha)          = $$$MEDPrescriptionLineItem(objPrescricaoLinha)
        include.INConst.$$$INReqLineItemSet(m$,objRequisicaoLinha,include.MEDConst.$$$MEDPrescriptionLineItem(m$,objPrescricaoLinha));
        //<< set $$$INReqLineUnit(objRequisicaoLinha)          = $$$MEDPrescriptionLineDispenseUOM(objPrescricaoLinha)
        include.INConst.$$$INReqLineUnitSet(m$,objRequisicaoLinha,include.MEDConst.$$$MEDPrescriptionLineDispenseUOM(m$,objPrescricaoLinha));
        //<< set $$$INReqLineStatus(objRequisicaoLinha)        = 1
        include.INConst.$$$INReqLineStatusSet(m$,objRequisicaoLinha,1);
        //<< set $$$INReqLineFromStockLocn(objRequisicaoLinha) = YLOCATION
        include.INConst.$$$INReqLineFromStockLocnSet(m$,objRequisicaoLinha,m$.var("YLOCATION").get());
        //<< set $$$INReqLineQtyOrdered(objRequisicaoLinha)    = $$$MEDPrescriptionLineDispenseQuantity(objPrescricaoLinha)
        include.INConst.$$$INReqLineQtyOrderedSet(m$,objRequisicaoLinha,include.MEDConst.$$$MEDPrescriptionLineDispenseQuantity(m$,objPrescricaoLinha));
        //<< set $$$INReqLineQtyRequired(objRequisicaoLinha)   = $$$MEDPrescriptionLineDispenseQuantity(objPrescricaoLinha)
        include.INConst.$$$INReqLineQtyRequiredSet(m$,objRequisicaoLinha,include.MEDConst.$$$MEDPrescriptionLineDispenseQuantity(m$,objPrescricaoLinha));
        //<< set $$$INReqLineUnitPrice(objRequisicaoLinha)     = 0 //Mesmo comportamento quando utilizada a tela
        include.INConst.$$$INReqLineUnitPriceSet(m$,objRequisicaoLinha,0);
        //<< 
        //<< set key = pidRequisicao_$$$COMMA_idRequisicaoLinha
        key.set(mOp.Concat(mOp.Concat(pidRequisicao.get(),include.COMSYSString.$$$COMMA(m$)),idRequisicaoLinha.get()));
        //<< 
        //<< set strStatus = $$$Save("INReqLine",key,objRequisicaoLinha,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"INReqLine",key,objRequisicaoLinha,include.COMSYS.$$$YES(m$)));
      }
    }
    //<< 
    //<< $$$End
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetStatusAbastecimento(pYKEY)
  public Object GetStatusAbastecimento(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:($$$NoKey(pYKEY)) 0
    if (mOp.Logical((include.COMSYS.$$$NoKey(m$,pYKEY)))) {
      return 0;
    }
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< 
    //<< new objPrescricao, statusAbastecimento, idRequisicao, objRequisicao
    mVar objPrescricao = m$.var("objPrescricao");
    mVar statusAbastecimento = m$.var("statusAbastecimento");
    mVar idRequisicao = m$.var("idRequisicao");
    mVar objRequisicao = m$.var("objRequisicao");
    m$.newVar(objPrescricao,statusAbastecimento,idRequisicao,objRequisicao);
    //<< set objPrescricao = $get(^MEDPrescription(YM,pYKEY,1))
    objPrescricao.set(m$.Fnc.$get(m$.var("^MEDPrescription",m$.var("YM").get(),pYKEY.get(),1)));
    //<< 
    //<< set statusAbastecimento = 0
    statusAbastecimento.set(0);
    //<< 
    //<< if ($$$MEDPrescriptionIssueType(objPrescricao) '= "I") {
    if ((mOp.NotEqual(include.MEDConst.$$$MEDPrescriptionIssueType(m$,objPrescricao),"I"))) {
      //<< set statusAbastecimento = "NA"
      statusAbastecimento.set("NA");
    }
    //<< 
    //<< } else {
    else {
      //<< 
      //<< $$$Order4(^INReqs,YM,200,$$$Index(pYKEY),idRequisicao)
      idRequisicao.set("");
      for (;true;) {
        idRequisicao.set(m$.Fnc.$order(m$.var("^INReqs",m$.var("YM").get(),200,include.MEDConst.$$$Index(m$,pYKEY),idRequisicao.get())));
        if (mOp.Equal(idRequisicao.get(),"")) {
          break;
        }
        //<< 
        //<< set objRequisicao = $get(^INReq(YM,idRequisicao,1))
        objRequisicao.set(m$.Fnc.$get(m$.var("^INReq",m$.var("YM").get(),idRequisicao.get(),1)));
        //<< 
        //<< if $$$INReqStatus(objRequisicao) = 9 {
        if (mOp.Equal(include.INConst.$$$INReqStatus(m$,objRequisicao),9)) {
          //<< set statusAbastecimento = 2
          statusAbastecimento.set(2);
        }
        //<< } else {
        else {
          //<< set statusAbastecimento = 1
          statusAbastecimento.set(1);
        }
      }
    }
    //<< }
    //<< $$$End
    //<< }
    //<< 
    //<< quit statusAbastecimento
    return statusAbastecimento.get();
  }

  //<< 
  //<< GetUnfirmedReq(pYKEY)
  public Object GetUnfirmedReq(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:($$$NoKey(pYKEY)) 0
    if (mOp.Logical((include.COMSYS.$$$NoKey(m$,pYKEY)))) {
      return 0;
    }
    //<< 
    //<< new idReq, idRequisicao, objRequisicao
    mVar idReq = m$.var("idReq");
    mVar idRequisicao = m$.var("idRequisicao");
    mVar objRequisicao = m$.var("objRequisicao");
    m$.newVar(idReq,idRequisicao,objRequisicao);
    //<< 
    //<< set idReq = ""
    idReq.set("");
    //<< $$$Order4(^INReqs,YM,200,$$$Index(pYKEY),idRequisicao)
    idRequisicao.set("");
    for (;true;) {
      idRequisicao.set(m$.Fnc.$order(m$.var("^INReqs",m$.var("YM").get(),200,include.MEDConst.$$$Index(m$,pYKEY),idRequisicao.get())));
      if (mOp.Equal(idRequisicao.get(),"")) {
        break;
      }
      //<< set objRequisicao = $get(^INReq(YM,idRequisicao,1))
      objRequisicao.set(m$.Fnc.$get(m$.var("^INReq",m$.var("YM").get(),idRequisicao.get(),1)));
      //<< 
      //<< if ($$$INReqStatus(objRequisicao) <= 2) {
      if ((mOp.LessOrEqual(include.INConst.$$$INReqStatus(m$,objRequisicao),2))) {
        //<< set idReq = idRequisicao
        idReq.set(idRequisicao.get());
        //<< quit
        break;
      }
    }
    //<< }
    //<< $$$End
    //<< 
    //<< quit idReq
    return idReq.get();
  }

  //<< 
  //<< PrintJS(pobjForm)
  public Object PrintJS(Object ... _p) {
    mVar pobjForm = m$.newVarRef("pobjForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Chamado por:
    //<< ;   Função OnAfterDataFields^MEDPrescription.mac
    //<< ;
    //<< ; Histórico:
    //<< ;   26-Jan-2012     Criado
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass, strP1Name
    mVar idClass = m$.var("idClass");
    mVar strP1Name = m$.var("strP1Name");
    m$.newVar(idClass,strP1Name);
    //<< 
    //<< set idClass = $$$WWW120ClassUsedInForm(pobjForm)
    idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,pobjForm));
    //<< set strP1Name = "Y"_idClass_"P1"
    strP1Name.set(mOp.Concat(mOp.Concat("Y",idClass.get()),"P1"));
    //<< 
    //<< write !, "<script language=""javascript"">"
    m$.Cmd.Write("\n","<script language=\"javascript\">");
    //<< &js<
    //<< // metodo personalizado para abrir a janela centralizada no firefox
    //<< // quando passar h = 0 a função fará um calculo aproximado da altura da janela pelo tamanho da msg
    //<< function showModalDialogCenter(url, msg, w, h) {
    //<< var width = screen.availWidth;
    //<< var height = screen.availHeight;
    //<< var altura = msg.length;
    //<< if (h==0){
    //<< h = altura / 1.5;
    //<< }
    //<< var dialogLeft = ((width - w) / 2);
    //<< var dialogTop = ((height - h) / 2);
    //<< var settings = " center: yes; " +
    //<< "edge: raised; scroll: yes; status: no; ";
    //<< var screenSize = " dialogWidth:"+w+"px; dialogHeight:"+h+"px;";
    //<< var centerScreen = " dialogTop="+dialogTop+"; dialogLeft=" +dialogLeft+ ";";
    //<< var setting =settings+screenSize+centerScreen;
    //<< return window.showModalDialog(url,msg,setting);
    //<< }
    //<< var pIdPrescription = document.#(YHTMFORM)#.#(strP1Name)#.value;
    //<< 
    //<< function iePrompt(message) {
    //<< var settings = "dialogWidth: 420px; dialogHeight: 200px; center: yes; " +
    //<< "edge: raised; scroll: no; status: no";
    //<< return showModalDialogCenter("#(YGIF)#VARPromptSize.html", message,420,170);
    //<< }
    //<< function motivoRecusa() {
    //<< CallBackNow("InsertMotiveOnClickJS^VARMEDPrescription", pIdPrescription);
    //<< }
    //<< function VerificarInteracao(){
    //<< CallBackNow("ShowMessageClickJS^VARMEDPrescription", pIdPrescription);
    //<< }
    //<< function mostrarInteracoes(){
    //<< CallBackNow("ShowMessageInteracao^VARInteracoesMedicamentosas", pIdPrescription);
    //<< }
    //<< function mostraAvisoConfirmacao(){
    //<< var settings = "dialogWidth: 400px; dialogHeight: 120px; center: yes; " +
    //<< "edge: raised; scroll: no; status: no";
    //<< var message = "Você tem certeza que deseja concluir o documento?</br>Todas as interações medicamentosas foram avaliadas?"
    //<< var retorno = showModalDialogCenter("#(YGIF)#VARConfirmMessageShow.html", message,320,0);
    //<< if (retorno){
    //<< CallBackNow("ConfirmaPrescricao^VARMEDPrescription", pIdPrescription);
    //<< }
    //<< }
    //<< function ShowMsgInteracao(message,height) {
    //<< return showModalDialogCenter("#(YGIF)#VARMessageShow.html", message,600,height);
    //<< }
    //<< 
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("    // metodo personalizado para abrir a janela centralizada no firefox","\n");
    m$.Cmd.WriteJS("    // quando passar h = 0 a função fará um calculo aproximado da altura da janela pelo tamanho da msg","\n");
    m$.Cmd.WriteJS("    function showModalDialogCenter(url, msg, w, h) {","\n");
    m$.Cmd.WriteJS("        var width = screen.availWidth;","\n");
    m$.Cmd.WriteJS("        var height = screen.availHeight;","\n");
    m$.Cmd.WriteJS("        var altura = msg.length;","\n");
    m$.Cmd.WriteJS("        if (h==0){  ","\n");
    m$.Cmd.WriteJS("            h = altura / 1.5;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        var dialogLeft = ((width - w) / 2);","\n");
    m$.Cmd.WriteJS("        var dialogTop = ((height - h) / 2);","\n");
    m$.Cmd.WriteJS("        var settings = \" center: yes; \" +","\n");
    m$.Cmd.WriteJS("        \"edge: raised; scroll: yes; status: no; \";","\n");
    m$.Cmd.WriteJS("        var screenSize = \" dialogWidth:\"+w+\"px; dialogHeight:\"+h+\"px;\";","\n");
    m$.Cmd.WriteJS("        var centerScreen = \" dialogTop=\"+dialogTop+\"; dialogLeft=\" +dialogLeft+ \";\";","\n");
    m$.Cmd.WriteJS("        var setting =settings+screenSize+centerScreen;","\n");
    m$.Cmd.WriteJS("        return window.showModalDialog(url,msg,setting);","\n");
    m$.Cmd.WriteJS("    }   ","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("    var pIdPrescription = document.",(m$.var("YHTMFORM").get())),"."),(strP1Name.get())),".value;"),"\n");
    m$.Cmd.WriteJS(" ","\n");
    m$.Cmd.WriteJS("    function iePrompt(message) {","\n");
    m$.Cmd.WriteJS("        var settings = \"dialogWidth: 420px; dialogHeight: 200px; center: yes; \" +","\n");
    m$.Cmd.WriteJS("            \"edge: raised; scroll: no; status: no\";     ","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        return showModalDialogCenter(\"",(m$.var("YGIF").get())),"VARPromptSize.html\", message,420,170);"),"\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function motivoRecusa() {","\n");
    m$.Cmd.WriteJS("        CallBackNow(\"InsertMotiveOnClickJS^VARMEDPrescription\", pIdPrescription);","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function VerificarInteracao(){","\n");
    m$.Cmd.WriteJS("        CallBackNow(\"ShowMessageClickJS^VARMEDPrescription\", pIdPrescription);","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function mostrarInteracoes(){","\n");
    m$.Cmd.WriteJS("        CallBackNow(\"ShowMessageInteracao^VARInteracoesMedicamentosas\", pIdPrescription);","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function mostraAvisoConfirmacao(){","\n");
    m$.Cmd.WriteJS("        var settings = \"dialogWidth: 400px; dialogHeight: 120px; center: yes; \" +","\n");
    m$.Cmd.WriteJS("        \"edge: raised; scroll: no; status: no\";","\n");
    m$.Cmd.WriteJS("        var message = \"Você tem certeza que deseja concluir o documento?</br>Todas as interações medicamentosas foram avaliadas?\"","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        var retorno = showModalDialogCenter(\"",(m$.var("YGIF").get())),"VARConfirmMessageShow.html\", message,320,0);"),"\n");
    m$.Cmd.WriteJS("        if (retorno){           ","\n");
    m$.Cmd.WriteJS("            CallBackNow(\"ConfirmaPrescricao^VARMEDPrescription\", pIdPrescription);","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    function ShowMsgInteracao(message,height) {      ","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        return showModalDialogCenter(\"",(m$.var("YGIF").get())),"VARMessageShow.html\", message,600,height);"),"\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    ");
    //<< write !, "</script>"
    m$.Cmd.Write("\n","</script>");
    //<< quit
    return null;
  }

  //<< 
  //<< InsertMotiveOnClickJS(pIdPrescription)
  public Object InsertMotiveOnClickJS(Object ... _p) {
    mVar pIdPrescription = m$.newVarRef("pIdPrescription",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Chamado por:
    //<< ;   Função PrintJS^VARMEDPrescription.mac
    //<< ;
    //<< ; Histórico:
    //<< ;   26-Jan-2012     Criado
    //<< ;-------------------------------------------------------------------------------
    //<< new objPrescription
    mVar objPrescription = m$.var("objPrescription");
    m$.newVar(objPrescription);
    //<< 
    //<< if ($length($get(pIdPrescription)) = 0) {
    if ((mOp.Equal(m$.Fnc.$length(m$.Fnc.$get(pIdPrescription)),0))) {
      //<< set objPrescription = ""
      objPrescription.set("");
    }
    //<< }
    //<< else {
    else {
      //<< set objPrescription = $get(^MEDPrescription(0,pIdPrescription,1))
      objPrescription.set(m$.Fnc.$get(m$.var("^MEDPrescription",0,pIdPrescription.get(),1)));
    }
    //<< }
    //<< &js<
    //<< var motivo = iePrompt('Por favor, insira o motivo para a recusa/cancelamento da prescrição');
    //<< if (motivo) {
    //<< CallBackNow("InsertMotiveOnClick^VARMEDPrescription", '#(pIdPrescription)#', motivo);
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("        var motivo = iePrompt('Por favor, insira o motivo para a recusa/cancelamento da prescrição');","\n");
    m$.Cmd.WriteJS("        if (motivo) {","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("            CallBackNow(\"InsertMotiveOnClick^VARMEDPrescription\", '",(pIdPrescription.get())),"', motivo);"),"\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    ");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< InsertMotiveOnClick(pIdPrescription,strMotivoRecusa)
  public Object InsertMotiveOnClick(Object ... _p) {
    mVar pIdPrescription = m$.newVarRef("pIdPrescription",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar strMotivoRecusa = m$.newVarRef("strMotivoRecusa",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Chamado por:
    //<< ;   Função InsertMotiveOnClickJS^VARMEDPrescription.mac
    //<< ;
    //<< ; Histórico:
    //<< ;   26-Jan-2012     Criado
    //<< ;-------------------------------------------------------------------------------
    //<< new objPrescription,strMotivoRecusaFormatado,i,strStatus,YSEITE
    mVar objPrescription = m$.var("objPrescription");
    mVar strMotivoRecusaFormatado = m$.var("strMotivoRecusaFormatado");
    mVar i = m$.var("i");
    mVar strStatus = m$.var("strStatus");
    mVar YSEITE = m$.var("YSEITE");
    m$.newVar(objPrescription,strMotivoRecusaFormatado,i,strStatus,YSEITE);
    //<< 
    //<< //set objPrescription = $$GetFormData^COMUtilForm(YFORM)
    //<< 
    //<< 
    //<< if ($length(strMotivoRecusa) = 0) {
    if ((mOp.Equal(m$.Fnc.$length(strMotivoRecusa.get()),0))) {
      //<< $$$StartScript()
      include.COMSYS.$$$StartScript(m$);
      //<< write "alert('Favor inserir o motivo da recusa.');"
      m$.Cmd.Write("alert('Favor inserir o motivo da recusa.');");
      //<< $$$EndScript()
      include.COMSYS.$$$EndScript(m$);
    }
    //<< }
    //<< else {
    else {
      //<< if ($length(strMotivoRecusa, """") = 1) {
      if ((mOp.Equal(m$.Fnc.$length(strMotivoRecusa.get(),"\""),1))) {
        //<< set strMotivoRecusaFormatado = strMotivoRecusa
        strMotivoRecusaFormatado.set(strMotivoRecusa.get());
      }
      //<< }
      //<< else {
      else {
        //<< set strMotivoRecusaFormatado = ""
        strMotivoRecusaFormatado.set("");
        //<< for i = 1:1:$length(strMotivoRecusa, """") {
        for (i.set(1);(mOp.LessOrEqual(i.get(),m$.Fnc.$length(strMotivoRecusa.get(),"\"")));i.set(mOp.Add(i.get(),1))) {
          //<< set strMotivoRecusaFormatado = strMotivoRecusaFormatado_
          //<< $piece(strMotivoRecusa, """", i)_""""""
          strMotivoRecusaFormatado.set(mOp.Concat(mOp.Concat(strMotivoRecusaFormatado.get(),m$.Fnc.$piece(strMotivoRecusa.get(),"\"",i.get())),"\"\""));
        }
      }
      //<< }
      //<< }
      //<< set strMotivoRecusaFormatado = "Motivo da recusa/cancelamento da prescrição: "_strMotivoRecusaFormatado
      strMotivoRecusaFormatado.set(mOp.Concat("Motivo da recusa/cancelamento da prescrição: ",strMotivoRecusaFormatado.get()));
      //<< set strStatus = $$Transaction^COMTransaction("InsertMotive^VARMEDPrescription("""_pIdPrescription_""","""_strMotivoRecusaFormatado_""")", $$$YES)
      strStatus.set(m$.fnc$("COMTransaction.Transaction",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("InsertMotive^VARMEDPrescription(\"",pIdPrescription.get()),"\",\""),strMotivoRecusaFormatado.get()),"\")"),include.COMSYS.$$$YES(m$)));
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< $$$StartScript()
        include.COMSYS.$$$StartScript(m$);
        //<< write "alert('Prescrição recusada com sucesso!');"
        m$.Cmd.Write("alert('Prescrição recusada com sucesso!');");
        //<< $$$EndScript()
        include.COMSYS.$$$EndScript(m$);
        //<< set YSEITE = 3
        YSEITE.set(3);
        //<< //do GoToForm^COMUtilForm(YFORM, pIdPrescription, 4,, $$$NO)
        //<< do RedirectForm^COMUtilForm(YFORM,pIdPrescription,YBACK,YPARA,YSEITE)
        m$.Cmd.Do("COMUtilForm.RedirectForm",m$.var("YFORM").get(),pIdPrescription.get(),m$.var("YBACK").get(),m$.var("YPARA").get(),YSEITE.get());
      }
      //<< }
      //<< else {
      else {
        //<< $$$StartScript()
        include.COMSYS.$$$StartScript(m$);
        //<< write "alert('Erro ao recusar a prescrição. => "_$$DecodeError^COMUtilError(strStatus)_"');"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('Erro ao recusar a prescrição. => ",m$.fnc$("COMUtilError.DecodeError",strStatus.get())),"');"));
        //<< $$$EndScript()
        include.COMSYS.$$$EndScript(m$);
      }
    }
    //<< }
    //<< }
    //<< quit ""
    return "";
  }

  //<< 
  //<< InsertMotive(pIdPrescription,pStrMotivo)
  public Object InsertMotive(Object ... _p) {
    mVar pIdPrescription = m$.newVarRef("pIdPrescription",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pStrMotivo = m$.newVarRef("pStrMotivo",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Chamado por:
    //<< ;   Função InsertMotiveOnClick^VARMEDPrescription.mac
    //<< ;
    //<< ; Histórico:
    //<< ;   26-Jan-2012     Criado
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCancelar, strStatus, objPrescription
    mVar blnCancelar = m$.var("blnCancelar");
    mVar strStatus = m$.var("strStatus");
    mVar objPrescription = m$.var("objPrescription");
    m$.newVar(blnCancelar,strStatus,objPrescription);
    //<< 
    //<< set objPrescription = $get(^MEDPrescription(YM,pIdPrescription,1))
    objPrescription.set(m$.Fnc.$get(m$.var("^MEDPrescription",m$.var("YM").get(),pIdPrescription.get(),1)));
    //<< if ($length($$$MEDPrescriptionNotes(objPrescription)) > 2){
    if ((mOp.Greater(m$.Fnc.$length(include.MEDConst.$$$MEDPrescriptionNotes(m$,objPrescription)),2))) {
      //<< set $$$MEDPrescriptionNotes(objPrescription) =$$$MEDPrescriptionNotes(objPrescription)_$CHAR(10,13)_pStrMotivo
      include.MEDConst.$$$MEDPrescriptionNotesSet(m$,objPrescription,mOp.Concat(mOp.Concat(include.MEDConst.$$$MEDPrescriptionNotes(m$,objPrescription),m$.Fnc.$char(10,13)),pStrMotivo.get()));
    }
    //<< }else{
    else {
      //<< set $$$MEDPrescriptionNotes(objPrescription) =$$$MEDPrescriptionNotes(objPrescription)_pStrMotivo
      include.MEDConst.$$$MEDPrescriptionNotesSet(m$,objPrescription,mOp.Concat(include.MEDConst.$$$MEDPrescriptionNotes(m$,objPrescription),pStrMotivo.get()));
    }
    //<< }
    //<< set $$$MEDPrescriptionStatus(objPrescription) = 8    ; M-Close
    include.MEDConst.$$$MEDPrescriptionStatusSet(m$,objPrescription,8);
    //<< set strStatus = $$$Save("MEDPrescription",pIdPrescription,objPrescription,1)
    strStatus.set(include.COMSYS.$$$Save(m$,"MEDPrescription",pIdPrescription,objPrescription,1));
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set $zerror = "Erro ao recusar a prescrição. => "_$$DecodeError^COMUtilError(strStatus)
      mVar $zerror = m$.var("$zerror");
      $zerror.set(mOp.Concat("Erro ao recusar a prescrição. => ",m$.fnc$("COMUtilError.DecodeError",strStatus.get())));
      //<< zquit 1 GOTO @$ZTRAP
      m$.Cmd.Goto(m$.Fnc.$ztrap());
      return null;
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< ShowMessageClickJS(pIdPrescription)
  public Object ShowMessageClickJS(Object ... _p) {
    mVar pIdPrescription = m$.newVarRef("pIdPrescription",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Chamado por:
    //<< ;   Função PrintJS^VARMEDPrescription.mac
    //<< ;
    //<< ; Histórico:
    //<< ;   26-Jan-2012     Criado
    //<< ;-------------------------------------------------------------------------------
    //<< set exist = $$ExisteInteracoes^VARInteracoesMedicamentosas(pIdPrescription)
    mVar exist = m$.var("exist");
    exist.set(m$.fnc$("VARInteracoesMedicamentosas.ExisteInteracoes",pIdPrescription.get()));
    //<< if (exist){
    if (mOp.Logical((exist.get()))) {
      //<< &js<
      //<< mostraAvisoConfirmacao();
      //<< >
      m$.Cmd.WriteJS("","\n");
      m$.Cmd.WriteJS("            mostraAvisoConfirmacao();","\n");
      m$.Cmd.WriteJS("        ");
    }
    //<< }else{
    else {
      //<< do ConfirmaPrescricao^VARMEDPrescription(pIdPrescription)
      m$.Cmd.Do("VARMEDPrescription.ConfirmaPrescricao",pIdPrescription.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< ConfirmaPrescricao(id)
  public Object ConfirmaPrescricao(Object ... _p) {
    mVar id = m$.newVarRef("id",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;teste
    //<< set sc = $$Firm^MEDPrescription(id)
    mVar sc = m$.var("sc");
    sc.set(m$.fnc$("MEDPrescription.Firm",id.get()));
    //<< set YSEITE = 3
    mVar YSEITE = m$.var("YSEITE");
    YSEITE.set(3);
    //<< do RedirectForm^COMUtilForm(YFORM,id,YBACK,YPARA,YSEITE)
    m$.Cmd.Do("COMUtilForm.RedirectForm",m$.var("YFORM").get(),id.get(),m$.var("YBACK").get(),m$.var("YPARA").get(),YSEITE.get());
    //<< quit
    return null;
  }

//<< 
}
