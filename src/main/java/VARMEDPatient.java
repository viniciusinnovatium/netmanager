//*****************************************************************************
//** TASC - ALPHALINC - MAC VARMEDPatient
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-10 15:39:50
//*****************************************************************************

import mLibrary.*;

//<< #include COMConst
import include.COMConst;
import include.COMSYS;
//<< #include INConst
import include.INConst;
import COMSYS;
//<< #include COMGridEdit31
import include.COMGridEdit31;
//<< #include MEDConst
import MEDConst;

//<< VARMEDPatient
public class VARMEDPatient extends mClass {

  public void main() {
    _VARMEDPatient();
  }

  public void _VARMEDPatient() {
  }

  //<< 
  //<< 
  //<< OnBeforeSave(pYFELD)
  public Object OnBeforeSave(Object ... _p) {
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : Form MEDPatient
    //<< ;
    //<< ; History :
    //<< ; 30-Jun-2011   Karine  Created
    //<< ; $$OnBeforeSave^VARMEDPatient(.YFELD)
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< new vCPF, getCPF, status, dteNascimento, dteNascimentoMae, idPaciente, tpDispensacao, nomeMae, nomePaciente
    mVar vCPF = m$.var("vCPF");
    mVar getCPF = m$.var("getCPF");
    mVar status = m$.var("status");
    mVar dteNascimento = m$.var("dteNascimento");
    mVar dteNascimentoMae = m$.var("dteNascimentoMae");
    mVar idPaciente = m$.var("idPaciente");
    mVar tpDispensacao = m$.var("tpDispensacao");
    mVar nomeMae = m$.var("nomeMae");
    mVar nomePaciente = m$.var("nomePaciente");
    m$.newVar(vCPF,getCPF,status,dteNascimento,dteNascimentoMae,idPaciente,tpDispensacao,nomeMae,nomePaciente);
    //<< 
    //<< set status = $$$OK
    status.set(include.COMSYS.$$$OK(m$));
    //<< set nomeMae = ""
    nomeMae.set("");
    //<< set dteNascimentoMae = ""
    dteNascimentoMae.set("");
    //<< 
    //<< if pYFELD '= "" {
    if (mOp.NotEqual(pYFELD.get(),"")) {
      //<< set vCPF             = $$$MEDPatientSSN(pYFELD)
    	vCPF.set(m$.Fnc.$piece(m$.var("YFELD"),"~",11));//TODO REVISAR SEM INCLUDE vCPF.set($$$include.$$$MEDPatientSSN(m$,pYFELD));
      //<< set dteNascimento    = $$$MEDPatientDOB(YFELD)
    	 dteNascimento.set(m$.Fnc.$piece(m$.var("YFELD"),"~",4));//TODO REVISAR SEM INCLUDE dteNascimento.set($$$include.$$$MEDPatientDOB(m$,m$.var("YFELD")));
      //<< set dteNascimentoMae = $$$MEDPatientMothersDOB(YFELD)
    	dteNascimentoMae.set(m$.Fnc.$piece(m$.var("YFELD"),"~",10));//TODO REVISAR SEM INCLUDE dteNascimentoMae.set($$$include.$$$MEDPatientMothersDOB(m$,m$.var("YFELD")));
      //<< set nomeMae          = $$$MEDPatientMothersName(YFELD)
    	nomeMae.set(m$.Fnc.$piece(m$.var("YFELD"),"~",9));//TODO REVISAR SEM INCLUDE nomeMae.set($$$include.$$$MEDPatientMothersName(m$,m$.var("YFELD")));
      //<< 
      //<< set strCompanyNumber = $translate(vCPF,".-/")
      mVar strCompanyNumber = m$.var("strCompanyNumber");
      strCompanyNumber.set(m$.Fnc.$translate(vCPF.get(),".-/"));
      //<< 
      //<< if (dteNascimento > $h) {
      if ((mOp.Greater(dteNascimento.get(),m$.Fnc.$horolog()))) {
        //<< set status = "Não é possível salvar."_$c(10)_"A data de nascimento não pode ser maior do que a data de hoje."_$char(10)_"Favor verificar."
        status.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Não é possível salvar.",m$.Fnc.$char(10)),"A data de nascimento não pode ser maior do que a data de hoje."),m$.Fnc.$char(10)),"Favor verificar."));
      }
      //<< 
      //<< } elseif nomeMae = "" { ; o CPF do paciente é obrigatório
      else if (mOp.Equal(nomeMae.get(),"")) {
        //<< if vCPF '= "" {
        if (mOp.NotEqual(vCPF.get(),"")) {
          //<< if ($length(vCPF)'=14) {
          if ((mOp.NotEqual(m$.Fnc.$length(vCPF.get()),14))) {
            //<< 
            //<< set status = "O CPF está incompleto. Favor verificar."
            status.set("O CPF está incompleto. Favor verificar.");
          }
          //<< 
          //<< } elseif '$$ValidateCPF^COMValidation(strCompanyNumber) {
          else if (mOp.Not(m$.fnc$("COMValidation.ValidateCPF",strCompanyNumber.get()))) {
            //<< 
            //<< set status = "Não é possível salvar."_$c(10)_"CPF inválido."
            status.set(mOp.Concat(mOp.Concat("Não é possível salvar.",m$.Fnc.$char(10)),"CPF inválido."));
          }
          //<< }
          //<< 
          //<< if $$$ISOK(status) {
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,status))) {
            //<< 
            //<< $$$Order3(^MEDPatients,YM,100,getCPF)
            getCPF.set("");
            for (;true;) {
              getCPF.set(m$.Fnc.$order(m$.var("^MEDPatients",m$.var("YM").get(),100,getCPF.get())));
              if (mOp.Equal(getCPF.get(),"")) {
                break;
              }
              //<< quit:$$$ISERR(status)
              if (mOp.Logical(include.COMSYS.$$$ISERR(m$,status))) {
                break;
              }
              //<< 
              //<< if $translate(getCPF,".-/")=strCompanyNumber {
              if (mOp.Equal(m$.Fnc.$translate(getCPF.get(),".-/"),strCompanyNumber.get())) {
                //<< 
                //<< $$$Order4(^MEDPatients,YM,100,getCPF,idPaciente)
                idPaciente.set("");
                for (;true;) {
                  idPaciente.set(m$.Fnc.$order(m$.var("^MEDPatients",m$.var("YM").get(),100,getCPF.get(),idPaciente.get())));
                  if (mOp.Equal(idPaciente.get(),"")) {
                    break;
                  }
                  //<< quit:$$$ISERR(status)
                  if (mOp.Logical(include.COMSYS.$$$ISERR(m$,status))) {
                    break;
                  }
                  //<< 
                  //<< if '$$$NoKey(YKEY) {
                  if (mOp.Not(include.COMSYS.$$$NoKey(m$,m$.var("YKEY")))) {
                    //<< if YKEY '= idPaciente {  ;Pode ser que seja uma correção do registro atual.
                    if (mOp.NotEqual(m$.var("YKEY").get(),idPaciente.get())) {
                      //<< set nomePaciente = $$SQLGetPatientName^VARSQL(idPaciente)
                      nomePaciente.set(m$.fnc$("VARSQL.SQLGetPatientName",idPaciente.get()));
                      //<< set status="Não é possível salvar."_$c(10)_"Já existe um paciente cadastrado com esse CPF."_$char(10)_"Paciente: "_idPaciente_"-"_nomePaciente
                      status.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Não é possível salvar.",m$.Fnc.$char(10)),"Já existe um paciente cadastrado com esse CPF."),m$.Fnc.$char(10)),"Paciente: "),idPaciente.get()),"-"),nomePaciente.get()));
                    }
                  }
                  //<< }
                  //<< } else {
                  else {
                    //<< set status="Não é possível salvar."_$c(10) ;_"Já existe um paciente cadastrado com esse CPF."_$char(10)_"Paciente: "_idPaciente_"-"_$$SQLGetPatientName^VARSQL(idPaciente)
                    status.set(mOp.Concat("Não é possível salvar.",m$.Fnc.$char(10)));
                  }
                }
              }
            }
          }
        }
      }
      //<< }
      //<< 
      //<< $$$End
      //<< }
      //<< $$$End
      //<< }
      //<< }
      //<< 
      //<< }
      //<< 
      //<< elseif (nomeMae '= "") && (vCPF '= "") { ;Existe o registro do nome da mãe  = CPF não obrigatório
      else if ((mOp.NotEqual(nomeMae.get(),"")) && (mOp.NotEqual(vCPF.get(),""))) {
        //<< ; mas se existe o CPF, ele precisa ser validado
        //<< if ($length(vCPF)'=14) {
        if ((mOp.NotEqual(m$.Fnc.$length(vCPF.get()),14))) {
          //<< 
          //<< set status = "O CPF está incompleto. Favor verificar."
          status.set("O CPF está incompleto. Favor verificar.");
        }
        //<< 
        //<< } elseif '$$ValidateCPF^COMValidation(strCompanyNumber) {
        else if (mOp.Not(m$.fnc$("COMValidation.ValidateCPF",strCompanyNumber.get()))) {
          //<< 
          //<< set status = "Não é possível salvar."_$c(10)_"CPF inválido."
          status.set(mOp.Concat(mOp.Concat("Não é possível salvar.",m$.Fnc.$char(10)),"CPF inválido."));
        }
        //<< }
        //<< 
        //<< if $$$ISOK(status) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,status))) {
          //<< 
          //<< $$$Order3(^MEDPatients,YM,100,getCPF)
          getCPF.set("");
          for (;true;) {
            getCPF.set(m$.Fnc.$order(m$.var("^MEDPatients",m$.var("YM").get(),100,getCPF.get())));
            if (mOp.Equal(getCPF.get(),"")) {
              break;
            }
            //<< quit:$$$ISERR(status)
            if (mOp.Logical(include.COMSYS.$$$ISERR(m$,status))) {
              break;
            }
            //<< 
            //<< if $translate(getCPF,".-/")=strCompanyNumber {
            if (mOp.Equal(m$.Fnc.$translate(getCPF.get(),".-/"),strCompanyNumber.get())) {
              //<< 
              //<< $$$Order4(^MEDPatients,YM,100,getCPF,idPaciente)
              idPaciente.set("");
              for (;true;) {
                idPaciente.set(m$.Fnc.$order(m$.var("^MEDPatients",m$.var("YM").get(),100,getCPF.get(),idPaciente.get())));
                if (mOp.Equal(idPaciente.get(),"")) {
                  break;
                }
                //<< quit:$$$ISERR(status)
                if (mOp.Logical(include.COMSYS.$$$ISERR(m$,status))) {
                  break;
                }
                //<< 
                //<< if '$$$NoKey(YKEY) {
                if (mOp.Not(include.COMSYS.$$$NoKey(m$,m$.var("YKEY")))) {
                  //<< if YKEY '= idPaciente {  ;Pode ser que seja uma correção do registro atual.
                  if (mOp.NotEqual(m$.var("YKEY").get(),idPaciente.get())) {
                    //<< set nomePaciente = $$SQLGetPatientName^VARSQL(idPaciente)
                    nomePaciente.set(m$.fnc$("VARSQL.SQLGetPatientName",idPaciente.get()));
                    //<< set status="Não é possível salvar."_$c(10)_"Já existe um paciente cadastrado com esse CPF."_$char(10)_"Paciente: "_idPaciente_"-"_nomePaciente
                    status.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Não é possível salvar.",m$.Fnc.$char(10)),"Já existe um paciente cadastrado com esse CPF."),m$.Fnc.$char(10)),"Paciente: "),idPaciente.get()),"-"),nomePaciente.get()));
                  }
                }
                //<< }
                //<< } else {
                else {
                  //<< set status="Não é possível salvar."_$c(10) ;_"Já existe um paciente cadastrado com esse CPF."_$char(10)_"Paciente: "_idPaciente_"-"_$$SQLGetPatientName^VARSQL(idPaciente)
                  status.set(mOp.Concat("Não é possível salvar.",m$.Fnc.$char(10)));
                }
              }
            }
          }
        }
      }
      //<< }
      //<< 
      //<< $$$End
      //<< }
      //<< $$$End
      //<< }
      //<< 
      //<< }
      //<< 
      //<< 
      //<< if $$$ISOK(status) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,status))) {
        //<< if dteNascimentoMae '= "" {
        if (mOp.NotEqual(dteNascimentoMae.get(),"")) {
          //<< if (dteNascimentoMae > $piece($h,",",1)) {
          if ((mOp.Greater(dteNascimentoMae.get(),m$.Fnc.$piece(m$.Fnc.$horolog(),",",1)))) {
            //<< set status = "A data de nascimento da mãe do paciente não pode ser maior do que a data de hoje. Favor verificar."
            status.set("A data de nascimento da mãe do paciente não pode ser maior do que a data de hoje. Favor verificar.");
          }
          //<< }
          //<< elseif dteNascimentoMae < dteNascimento {
          else if (mOp.Less(dteNascimentoMae.get(),dteNascimento.get())) {
            //<< set status = "A data de nascimento da mãe do paciente não pode ser menor do que a data de nascimento do paciente. Favor verificar."
            status.set("A data de nascimento da mãe do paciente não pode ser menor do que a data de nascimento do paciente. Favor verificar.");
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISERR(status) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,status))) {
      //<< set Q=$$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
      //<< $$$Alert(status)
      include.COMSYS.$$$Alert(m$,status);
    }
    //<< ;do ^WWWINFO(status)
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< OnAfterSave(pidPaciente,pobjPaciente)
  public Object OnAfterSave(Object ... _p) {
    mVar pidPaciente = m$.newVarRef("pidPaciente",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjPaciente = m$.newVarRef("pobjPaciente",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : Form MEDPatient no VARHook !  WWW001VARHook
    //<< ;
    //<< ; History :
    //<< ; 30-Jun-2011   Karine  Copied from VARPaciente, e alterado para pegar o piece
    //<< ;                       do blnPacienteComAcaoJud corretamente.
    //<< ; $$OnAfterSave^VARMEDPatient(YKEY,YFELD)
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< new strStatus, codFarmaciaAcoesJud, blnPacienteComAcaoJud
    mVar strStatus = m$.var("strStatus");
    mVar codFarmaciaAcoesJud = m$.var("codFarmaciaAcoesJud");
    mVar blnPacienteComAcaoJud = m$.var("blnPacienteComAcaoJud");
    m$.newVar(strStatus,codFarmaciaAcoesJud,blnPacienteComAcaoJud);
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< //Criando o endereço de armazenagem do paciente na farmácia de ação judicial
    //<< set codFarmaciaAcoesJud   = $$getFarmaciaAcoesJudiciais^VARParametroCliente(0)
    codFarmaciaAcoesJud.set(m$.fnc$("VARParametroCliente.getFarmaciaAcoesJudiciais",0));
    //<< quit:(codFarmaciaAcoesJud  = "") strStatus
    if ((mOp.Equal(codFarmaciaAcoesJud.get(),""))) {
      return strStatus.get();
    }
    //<< 
    //<< set blnPacienteComAcaoJud = $$$MEDPatientFREE5(YFELD)
    blnPacienteComAcaoJud.set($piece(m$.var("YFELD"),"~",35)) //TODO REVISAR blnPacienteComAcaoJud.set($$$include.$$$MEDPatientFREE5(m$,m$.var("YFELD")));
    //<< 
    //<< if blnPacienteComAcaoJud = $$$YES {
    if (mOp.Equal(blnPacienteComAcaoJud.get(),include.COMSYS.$$$YES(m$))) {
      //<< //Verifica se o endereço já foi criado
      //<< if '$data(^INLP(YM,codFarmaciaAcoesJud,pidPaciente)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^INLP",m$.var("YM").get(),codFarmaciaAcoesJud.get(),pidPaciente.get())))) {
        //<< // Cria Endereço do paciente
        //<< set strStatus = $$CreatePatientStorage(codFarmaciaAcoesJud,pidPaciente)
        strStatus.set(m$.fnc$("CreatePatientStorage",codFarmaciaAcoesJud.get(),pidPaciente.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< CreatePatientStorage(pCodFarmaciaAcoesJud,pidPaciente)
  public Object CreatePatientStorage(Object ... _p) {
    mVar pCodFarmaciaAcoesJud = m$.newVarRef("pCodFarmaciaAcoesJud",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidPaciente = m$.newVarRef("pidPaciente",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : Form OnAfterSave^MEDPatient
    //<< ;
    //<< ; History :
    //<< ; 30-Jun-2011   Karine  Copied from VARPaciente
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< // Para a farmácia de ação judicial, cria o storage do paciente
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< // Cria o stock-location com id = nome do paciente
    //<< if ('$data(^INLP(YM,pCodFarmaciaAcoesJud,pidPaciente,1))) {
    if ((mOp.Not(m$.Fnc.$data(m$.var("^INLP",m$.var("YM").get(),pCodFarmaciaAcoesJud.get(),pidPaciente.get(),1))))) {
      //<< set newINLPRecord = ""
      mVar newINLPRecord = m$.var("newINLPRecord");
      newINLPRecord.set("");
      //<< set $$$INLPLocationHeight(newINLPRecord) = 0
      include.INConst.$$$INLPLocationHeightSet(m$,newINLPRecord,0);
      //<< set $$$INLPFieldWithMultipleLoads(newINLPRecord) = 1
      include.INConst.$$$INLPFieldWithMultipleLoadsSet(m$,newINLPRecord,1);
      //<< set strStatus = $$Save^COMUtils("INLP",pCodFarmaciaAcoesJud_YKOMMA_pidPaciente,newINLPRecord,1)
      strStatus.set(m$.fnc$("COMUtils.Save","INLP",mOp.Concat(mOp.Concat(pCodFarmaciaAcoesJud.get(),m$.var("YKOMMA").get()),pidPaciente.get()),newINLPRecord.get(),1));
      //<< quit:('strStatus) strStatus
      if ((mOp.Not(strStatus.get()))) {
        return strStatus.get();
      }
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< getDataNascimento(pidPaciente)
  public Object getDataNascimento(Object ... _p) {
    mVar pidPaciente = m$.newVarRef("pidPaciente",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : Form VARPedidoCompraPaciente.mac
    //<< ;
    //<< ; History :
    //<< ; 27-Jul-2011   Karine  Copied from VARPaciente
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< new dteNascimento, objPaciente
    mVar dteNascimento = m$.var("dteNascimento");
    mVar objPaciente = m$.var("objPaciente");
    m$.newVar(dteNascimento,objPaciente);
    //<< set dteNascimento = ""
    dteNascimento.set("");
    //<< 
    //<< if pidPaciente '= "" {
    if (mOp.NotEqual(pidPaciente.get(),"")) {
      //<< 
      //<< set objPaciente = $get(^MEDPatient(YM,pidPaciente,1))
      objPaciente.set(m$.Fnc.$get(m$.var("^MEDPatient",m$.var("YM").get(),pidPaciente.get(),1)));
      //<< set dteNascimento =$$$MEDPatientDOB(objPaciente)
      dteNascimento.set($$$include.$$$MEDPatientDOB(m$,objPaciente));
    }
    //<< }
    //<< quit dteNascimento
    return dteNascimento.get();
  }

  //<< 
  //<< getCPF(pidPaciente)
  public Object getCPF(Object ... _p) {
    mVar pidPaciente = m$.newVarRef("pidPaciente",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : Form VARPedidoCompraPaciente.mac
    //<< ;
    //<< ; History :
    //<< ; 27-Jul-2011   Karine  Copied from VARPaciente
    //<< ;-------------------------------------------------------------------------------
    //<< new CPF, objPaciente
    mVar CPF = m$.var("CPF");
    mVar objPaciente = m$.var("objPaciente");
    m$.newVar(CPF,objPaciente);
    //<< set CPF = ""
    CPF.set("");
    //<< 
    //<< if pidPaciente '= "" {
    if (mOp.NotEqual(pidPaciente.get(),"")) {
      //<< set objPaciente = $get(^MEDPatient(YM,pidPaciente,1))
      objPaciente.set(m$.Fnc.$get(m$.var("^MEDPatient",m$.var("YM").get(),pidPaciente.get(),1)));
      //<< set CPF = $$$MEDPatientSSN(objPaciente)
      CPF.set($$$include.$$$MEDPatientSSN(m$,objPaciente));
    }
    //<< }
    //<< quit CPF
    return CPF.get();
  }

  //<< 
  //<< GetNomePaciente(pLocal,pEndereco)
  public Object GetNomePaciente(Object ... _p) {
    mVar pLocal = m$.newVarRef("pLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pEndereco = m$.newVarRef("pEndereco",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : INLP Calculated field 50
    //<< ;             $$GetNomePaciente^VARMEDPatient({LocationName},{StockLocation})
    //<< ;
    //<< ; History :
    //<< ; 27-Jul-2011   Karine  Copied from VARPaciente
    //<< ;                       Função para retornar o nome do Paciente como campo calculado na classe INLP
    //<< ;                       Onde pYKEY é a chave da classe INLP composta por Local,Endereço
    //<< ;                       Esse campo será usado para buscas quando o local de recebimento for
    //<< ;                     uma Farmácia de Ações Judiciais
    //<< ;-------------------------------------------------------------------------------
    //<< new Result,pidPaciente
    mVar Result = m$.var("Result");
    mVar pidPaciente = m$.var("pidPaciente");
    m$.newVar(Result,pidPaciente);
    //<< 
    //<< if (pLocal '= "")||(pEndereco '= ""){
    if ((mOp.NotEqual(pLocal.get(),"")) || (mOp.NotEqual(pEndereco.get(),""))) {
      //<< 
      //<< set Result      = ""
      Result.set("");
      //<< set pidPaciente = pEndereco
      pidPaciente.set(pEndereco.get());
      //<< 
      //<< ;O local tem que ser igual ao de ações judiciais
      //<< if (pLocal = $$getFarmaciaAcoesJudiciais^VARParametroCliente(YM)){
      if ((mOp.Equal(pLocal.get(),m$.fnc$("VARParametroCliente.getFarmaciaAcoesJudiciais",m$.var("YM").get())))) {
        //<< if $get(YM) = "" { do ^WWWVAR }
        if (mOp.Equal(m$.Fnc.$get(m$.var("YM")),"")) {
          m$.Cmd.Do("WWWVAR.main");
        }
        //<< 
        //<< ;Se existir um registro no cadastro de paciente com o mesmo código, traz o nome dele.
        //<< if $Data(^MEDPatient(YM,pidPaciente)){
        if (mOp.Logical(m$.Fnc.$data(m$.var("^MEDPatient",m$.var("YM").get(),pidPaciente.get())))) {
          //<< set objPaciente = $get(^MEDPatient(YM,pidPaciente,1))
          mVar objPaciente = m$.var("objPaciente");
          objPaciente.set(m$.Fnc.$get(m$.var("^MEDPatient",m$.var("YM").get(),pidPaciente.get(),1)));
          //<< 
          //<< ;Se o campo "Paciente possui ação judicial?" for 1-Sim retorna o nome
          //<< if $$$MEDPatientFREE5(objPaciente) = $$$YES {
          if (mOp.Equal($$$include.$$$MEDPatientFREE5(m$,objPaciente),include.COMSYS.$$$YES(m$))) {
            //<< set Result = $$$MEDPatientName(objPaciente)
            Result.set($$$include.$$$MEDPatientName(m$,objPaciente));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit Result
    return Result.get();
  }

  //<< 
  //<< LoadPicture(pYKEY,&strDirectory="", &strFile="", &idGender="")
  public Object LoadPicture(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar strDirectory = m$.newVarRef("strDirectory",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar strFile = m$.newVarRef("strFile",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar idGender = m$.newVarRef("idGender",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< if '($$$NoKey(pYKEY)){
    if (mOp.Not((include.COMSYS.$$$NoKey(m$,pYKEY)))) {
      //<< set strDirectory = "/"_YUCI_"/"_$translate($$GetDiretorioVirtual^VARBRDiretorios(YM,5),"\","/")_"/"
      strDirectory.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("/",m$.var("YUCI").get()),"/"),m$.Fnc.$translate(m$.fnc$("VARBRDiretorios.GetDiretorioVirtual",m$.var("YM").get(),5),"\\","/")),"/"));
      //<< set idGender = $$$MEDPatientGender(^MEDPatient(YM,pYKEY,1))
      idGender.set($$$include.$$$MEDPatientGender(m$,m$.var("^MEDPatient",m$.var("YM").get(),pYKEY.get(),1)));
      //<< if (##class(%File).Exists($$GetDiretorioFisico^VARBRDiretorios(YM,5)_"\"_pYKEY_".jpg")){
      if (mOp.Logical((m$.fnc$("$File.Exists",mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("VARBRDiretorios.GetDiretorioFisico",m$.var("YM").get(),5),"\\"),pYKEY.get()),".jpg"))))) {
        //<< set strFile = pYKEY_".jpg?id="_$piece($horolog,",",2)
        strFile.set(mOp.Concat(mOp.Concat(pYKEY.get(),".jpg?id="),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2)));
      }
      //<< }else{
      else {
        //<< if (idGender = 1){
        if ((mOp.Equal(idGender.get(),1))) {
          //<< set strFile = "avatar_masculino.jpg"
          strFile.set("avatar_masculino.jpg");
        }
        //<< }else{
        else {
          //<< set strFile = "avatar_feminino.jpg"
          strFile.set("avatar_feminino.jpg");
        }
      }
      //<< }
      //<< }
      //<< quit strDirectory_strFile
      return mOp.Concat(strDirectory.get(),strFile.get());
    }
    //<< }
    //<< quit ""
    return "";
  }

  //<< 
  //<< UploadPicture(pYKEY)
  public Object UploadPicture(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new strDirectory, strFile, idGender, urlFile
    mVar strDirectory = m$.var("strDirectory");
    mVar strFile = m$.var("strFile");
    mVar idGender = m$.var("idGender");
    mVar urlFile = m$.var("urlFile");
    m$.newVar(strDirectory,strFile,idGender,urlFile);
    //<< 
    //<< if ('($$$NoKey(pYKEY)))&&(YSEITE=1){
    if ((mOp.Not((include.COMSYS.$$$NoKey(m$,pYKEY)))) && (mOp.Equal(m$.var("YSEITE").get(),1))) {
      //<< write "<BR><BR>"
      m$.Cmd.Write("<BR><BR>");
      //<< set urlFile = $$LoadPicture(pYKEY,.strDirectory, .strFile, .idGender)
      urlFile.set(m$.fnc$("LoadPicture",pYKEY.get(),strDirectory,strFile,idGender));
      //<< 
      //<< write "<script type='text/javascript'> ",!
      m$.Cmd.Write("<script type='text/javascript'> ","\n");
      //<< write " function uploadPrompt(message) { ",!
      m$.Cmd.Write(" function uploadPrompt(message) { ","\n");
      //<< write "     var settings = ""dialogWidth: 410px; dialogHeight: 290px; center: yes; edge: raised; scroll: no; status: no"";",!
      m$.Cmd.Write("     var settings = \"dialogWidth: 410px; dialogHeight: 290px; center: yes; edge: raised; scroll: no; status: no\";","\n");
      //<< write "     return window.showModalDialog(""VARBRUpload.csp?YM=0&modulo=5&id="_pYKEY_"&campo="", window,settings); ",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("     return window.showModalDialog(\"VARBRUpload.csp?YM=0&modulo=5&id=",pYKEY.get()),"&campo=\", window,settings); "),"\n");
      //<< write " } ",!
      m$.Cmd.Write(" } ","\n");
      //<< 
      //<< write " function recarregaFoto(gender) { ",!
      m$.Cmd.Write(" function recarregaFoto(gender) { ","\n");
      //<< write "     var date = new Date(); ",!
      m$.Cmd.Write("     var date = new Date(); ","\n");
      //<< write "     var id = date.getMilliseconds(); ",!
      m$.Cmd.Write("     var id = date.getMilliseconds(); ","\n");
      //<< write "     var fileName = '"_strDirectory_pYKEY_".jpg?id='+id ",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("     var fileName = '",strDirectory.get()),pYKEY.get()),".jpg?id='+id "),"\n");
      //<< write "     if (gender==0) { ",!
      m$.Cmd.Write("     if (gender==0) { ","\n");
      //<< write "         document.getElementById(""fotoPaciente"").innerHTML = eval('\'<IMG SRC=""'+fileName+'"" width=""80"" height=""100"" >\''); ",!
      m$.Cmd.Write("         document.getElementById(\"fotoPaciente\").innerHTML = eval('\\'<IMG SRC=\"'+fileName+'\" width=\"80\" height=\"100\" >\\''); ","\n");
      //<< write "     } else if (gender==1) { ",!
      m$.Cmd.Write("     } else if (gender==1) { ","\n");
      //<< write "         document.getElementById(""fotoPaciente"").innerHTML = '<IMG SRC="""_strDirectory_"avatar_masculino.jpg"" width=""80"" height=""100"" >'; ",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("         document.getElementById(\"fotoPaciente\").innerHTML = '<IMG SRC=\"",strDirectory.get()),"avatar_masculino.jpg\" width=\"80\" height=\"100\" >'; "),"\n");
      //<< write "     } else if (gender==2) { ",!
      m$.Cmd.Write("     } else if (gender==2) { ","\n");
      //<< write "         document.getElementById(""fotoPaciente"").innerHTML = '<IMG SRC="""_strDirectory_"avatar_feminino.jpg"" width=""80"" height=""100"" >'; ",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("         document.getElementById(\"fotoPaciente\").innerHTML = '<IMG SRC=\"",strDirectory.get()),"avatar_feminino.jpg\" width=\"80\" height=\"100\" >'; "),"\n");
      //<< write "     } ",!
      m$.Cmd.Write("     } ","\n");
      //<< write " } ",!
      m$.Cmd.Write(" } ","\n");
      //<< 
      //<< write " function removerFoto() { ",!
      m$.Cmd.Write(" function removerFoto() { ","\n");
      //<< write "     if (confirm('Deseja excluir definitivamente esta foto?')) {",!
      m$.Cmd.Write("     if (confirm('Deseja excluir definitivamente esta foto?')) {","\n");
      //<< write "         recarregaFoto("_$get(idGender)_");",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("         recarregaFoto(",m$.Fnc.$get(idGender)),");"),"\n");
      //<< write "         CallBack('RemovePicture^VARMEDPatient','"_pYKEY_"');",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("         CallBack('RemovePicture^VARMEDPatient','",pYKEY.get()),"');"),"\n");
      //<< write "     }"
      m$.Cmd.Write("     }");
      //<< write " } ",!
      m$.Cmd.Write(" } ","\n");
      //<< 
      //<< write "</" _ "script> ",!
      m$.Cmd.Write(mOp.Concat("</","script> "),"\n");
      //<< 
      //<< write "<div>"
      m$.Cmd.Write("<div>");
      //<< write "<div id=""fotoPaciente"" style=""float:left;"">"
      m$.Cmd.Write("<div id=\"fotoPaciente\" style=\"float:left;\">");
      //<< write "<IMG SRC="""_urlFile_""" width=""80"" height=""100"" >"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<IMG SRC=\"",urlFile.get()),"\" width=\"80\" height=\"100\" >"));
      //<< write "</div>"
      m$.Cmd.Write("</div>");
      //<< 
      //<< write "<A class=link style=""text-decoration: none;"" onclick=""uploadPrompt();"">"
      m$.Cmd.Write("<A class=link style=\"text-decoration: none;\" onclick=\"uploadPrompt();\">");
      //<< write " <IMG SRC="""_YGIF_"up_photo.gif"" align=""bottom"" vspace=1 TITLE=""Carregar Foto"" border=0 id=""BUTTON_UPLOADE""> "
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" <IMG SRC=\"",m$.var("YGIF").get()),"up_photo.gif\" align=\"bottom\" vspace=1 TITLE=\"Carregar Foto\" border=0 id=\"BUTTON_UPLOADE\"> "));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
      //<< 
      //<< write "<A class=link style=""text-decoration: none;"" onclick=""removerFoto()"">"
      m$.Cmd.Write("<A class=link style=\"text-decoration: none;\" onclick=\"removerFoto()\">");
      //<< write "<IMG SRC="""_YGIF_"excluir.gif"" align=""bottom"" vspace=1 TITLE=""Excluir Foto"""_
      //<< " border=0 id=""BUTTON_UPLOADEEY"">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"excluir.gif\" align=\"bottom\" vspace=1 TITLE=\"Excluir Foto\"")," border=0 id=\"BUTTON_UPLOADEEY\">"));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
      //<< write "</div>"
      m$.Cmd.Write("</div>");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< RemovePicture(pYKEY)
  public Object RemovePicture(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< do ##class(%File).Delete($$GetDiretorioFisico^VARBRDiretorios(YM,5)_"\"_pYKEY_".jpg")
    m$.Cmd.Do("$File.Delete",mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("VARBRDiretorios.GetDiretorioFisico",m$.var("YM").get(),5),"\\"),pYKEY.get()),".jpg"));
    //<< 
    //<< quit
    return null;
  }

//<< 
}
