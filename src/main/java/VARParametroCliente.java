//*****************************************************************************
//** TASC - ALPHALINC - MAC VARParametroCliente
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-30 12:00:04
//*****************************************************************************

import mLibrary.*;


//<< VARParametroCliente
public class VARParametroCliente extends mClass {

  public void main() {
    _VARParametroCliente();
  }

  public void _VARParametroCliente() {
    //<< quit
    return;
  }

  //<< 
  //<< OnAfterPrimaryKey()
  public Object OnAfterPrimaryKey() {
    //<< kill ^COMTempList(YM, YUSER, "ParticoesAmbiente")
    m$.var("^COMTempList",m$.var("YM").get(),m$.var("YUSER").get(),"ParticoesAmbiente").kill();
    //<< 
    //<< if ($isObject(##class(Api).GetInstance())) {
    if (mOp.Logical((m$.Fnc.$isobject(m$.fnc$("Api.GetInstance"))))) {
      //<< set count = ##class(Api).GetInstance().GetPartitionCount()
      mVar count = m$.var("count");
      count.set(m$.fnc$("Api.GetInstance"));
      //<< for i = 1:1:count {
      mVar i = m$.var("i");
      for (i.set(1);(mOp.LessOrEqual(i.get(),count.get()));i.set(mOp.Add(i.get(),1))) {
        //<< set id = ##class(Api).GetInstance().GetPartitionIdFromSeq(i)
        mVar id = m$.var("id");
        id.set(m$.fnc$("Api.GetInstance"));
        //<< if ($length(id) = 0) continue
        if ((mOp.Equal(m$.Fnc.$length(id.get()),0))) {
          continue;
        }
        //<< 
        //<< set ^COMTempList(YM, YUSER, "ParticoesAmbiente", id, 1) = id
        m$.var("^COMTempList",m$.var("YM").get(),m$.var("YUSER").get(),"ParticoesAmbiente",id.get(),1).set(id.get());
      }
      //<< }
      //<< do ##class(Api).GetInstance().Clear()
      m$.Cmd.Do("Api.GetInstance");
    }
    //<< }
    //<< 
    //<< kill ^COMTempList(YM, YUSER, "PercentuaisAmbiente")
    m$.var("^COMTempList",m$.var("YM").get(),m$.var("YUSER").get(),"PercentuaisAmbiente").kill();
    //<< for i = 5:5:95 {
    mVar i = m$.var("i");
    for (i.set(5);(mOp.LessOrEqual(i.get(),95));i.set(mOp.Add(i.get(),5))) {
      //<< set ^COMTempList(YM, YUSER, "PercentuaisAmbiente", i, 1) = i
      m$.var("^COMTempList",m$.var("YM").get(),m$.var("YUSER").get(),"PercentuaisAmbiente",i.get(),1).set(i.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< getFarmaciaAcoesJudiciais(pCompany=0)
  public Object getFarmaciaAcoesJudiciais(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< 
    //<< if ($get(YM)=""){
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YM")),""))) {
      //<< do ^WWWVAR
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< }
    //<< new codFarmaciaAJ
    mVar codFarmaciaAJ = m$.var("codFarmaciaAJ");
    m$.newVar(codFarmaciaAJ);
    //<< set codFarmaciaAJ = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,2)
    codFarmaciaAJ.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),2));
    //<< 
    //<< quit codFarmaciaAJ
    return codFarmaciaAJ.get();
  }

  //<< 
  //<< getValidaQtdReq(pCompany=0)
  public Object getValidaQtdReq(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;--------------------------------------------------------------------------------------
    //<< ;  Valida se será possível requisitar uma quantidade maior que a disponível em estoque ou não
    //<< ;
    //<< ;
    //<< ;19-Jul-2010    Karine  Created
    //<< ;--------------------------------------------------------------------------------------
    //<< 
    //<< new pValidate
    mVar pValidate = m$.var("pValidate");
    m$.newVar(pValidate);
    //<< 
    //<< set pValidate=$$$NO
    pValidate.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set pValidate=$piece($get(^VARParametroCliente(YM,pCompany,1)),Y,3)
    pValidate.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),3));
    //<< 
    //<< quit pValidate
    return pValidate.get();
  }

  //<< 
  //<< 
  //<< getDiasAlertaValidade(pCompany=0)
  public Object getDiasAlertaValidade(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;--------------------------------------------------------------------------------------
    //<< ;  Retorna o número de dias que será usado no e-mail de Alerta de Validade.
    //<< ;  Serão enviados nesse e-mail os produtos que estão para vencer nos próximos X dias.
    //<< ;  Onde X é o que estiver cadastro nesse parâmetro
    //<< ;
    //<< ;04-Ago-2010    Petik   Created
    //<< ;--------------------------------------------------------------------------------------
    //<< 
    //<< if ($get(YM)=""){
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YM")),""))) {
      //<< do ^WWWVAR
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< }
    //<< new DiasAlerta
    mVar DiasAlerta = m$.var("DiasAlerta");
    m$.newVar(DiasAlerta);
    //<< set DiasAlerta = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,4)
    DiasAlerta.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),4));
    //<< 
    //<< quit DiasAlerta
    return DiasAlerta.get();
  }

  //<< 
  //<< getDiasAlertaValidadeAta(pCompany=0)
  public Object getDiasAlertaValidadeAta(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;--------------------------------------------------------------------------------------
    //<< ;  Retorna o número de dias que será usado no e-mail de Alerta de Validade de Ata.
    //<< ;  Serão enviados nesse e-mail as atas que estão para vencer nos próximos X dias.
    //<< ;  Onde X é o que estiver cadastro nesse parâmetro
    //<< ;
    //<< ;08-Fev-2012    RGB Created
    //<< ;--------------------------------------------------------------------------------------
    //<< 
    //<< if ($get(YM)=""){
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YM")),""))) {
      //<< do ^WWWVAR
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< }
    //<< new DiasAlerta
    mVar DiasAlerta = m$.var("DiasAlerta");
    m$.newVar(DiasAlerta);
    //<< set DiasAlerta = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,21)
    DiasAlerta.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),21));
    //<< 
    //<< quit DiasAlerta
    return DiasAlerta.get();
  }

  //<< 
  //<< getUsuariosAlertaValidadeAta(pCompany=0)
  public Object getUsuariosAlertaValidadeAta(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;--------------------------------------------------------------------------------------
    //<< ;  Retorna os usuários que serão usados para enviar o e-mail de Alerta de Validade de Ata.
    //<< ;  Será enviado um e-mail para cada usuário com as atas que estão para vencer nos
    //<< ;  próximos X dias. Onde X é o que estiver cadastro no parâmetro DiasEmailAlertaValidadeAta.
    //<< ;
    //<< ;08-Fev-2012    RGB Created
    //<< ;--------------------------------------------------------------------------------------
    //<< 
    //<< if ($get(YM)=""){
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YM")),""))) {
      //<< do ^WWWVAR
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< }
    //<< new ListaUsuarios
    mVar ListaUsuarios = m$.var("ListaUsuarios");
    m$.newVar(ListaUsuarios);
    //<< set ListaUsuarios = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,22)
    ListaUsuarios.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),22));
    //<< 
    //<< quit ListaUsuarios
    return ListaUsuarios.get();
  }

  //<< 
  //<< getUsuariosAlertaValidade(pCompany=0)
  public Object getUsuariosAlertaValidade(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;--------------------------------------------------------------------------------------
    //<< ;  Retorna os usuários que serão usados para enviar o e-mail de Alerta de Validade.
    //<< ;  Será enviado um e-mail para cada usuário com os produtos que estão para vencer nos
    //<< ;  próximos X dias. Onde X é o que estiver cadastro no parâmetro DiasEmailAlertaValidade.
    //<< ;
    //<< ;04-Ago-2010    Petik   Created
    //<< ;--------------------------------------------------------------------------------------
    //<< 
    //<< if ($get(YM)=""){
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YM")),""))) {
      //<< do ^WWWVAR
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< }
    //<< new ListaUsuarios
    mVar ListaUsuarios = m$.var("ListaUsuarios");
    m$.newVar(ListaUsuarios);
    //<< set ListaUsuarios = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,5)
    ListaUsuarios.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),5));
    //<< 
    //<< quit ListaUsuarios
    return ListaUsuarios.get();
  }

  //<< 
  //<< 
  //<< getMostrarValorAlertaValidade(pCompany=0)
  public Object getMostrarValorAlertaValidade(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;--------------------------------------------------------------------------------------
    //<< ;  Retorna se é para mostrar ou não o Valor (Custo Médio) no relatório de Alerta de Validade.
    //<< ;
    //<< ;05-Ago-2010    Petik   Created
    //<< ;--------------------------------------------------------------------------------------
    //<< 
    //<< if ($get(YM)=""){
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YM")),""))) {
      //<< do ^WWWVAR
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< }
    //<< new MostrarValor
    mVar MostrarValor = m$.var("MostrarValor");
    m$.newVar(MostrarValor);
    //<< set MostrarValor = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,6)
    MostrarValor.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),6));
    //<< if (MostrarValor = ""){
    if ((mOp.Equal(MostrarValor.get(),""))) {
      //<< set MostrarValor = $$$NO
      MostrarValor.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< 
    //<< quit MostrarValor
    return MostrarValor.get();
  }

  //<< 
  //<< getFaxSetorCompra(pCompany=0)
  public Object getFaxSetorCompra(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< new faxSetorCompra
    mVar faxSetorCompra = m$.var("faxSetorCompra");
    m$.newVar(faxSetorCompra);
    //<< set faxSetorCompra = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,7)
    faxSetorCompra.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),7));
    //<< 
    //<< quit faxSetorCompra
    return faxSetorCompra.get();
  }

  //<< 
  //<< getLocaisCentraisEstoque(pCompany=0)
  public Object getLocaisCentraisEstoque(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< if ($get(YM)=""){
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YM")),""))) {
      //<< do ^WWWVAR
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< }
    //<< 
    //<< new strLocaisCentrais
    mVar strLocaisCentrais = m$.var("strLocaisCentrais");
    m$.newVar(strLocaisCentrais);
    //<< set strLocaisCentrais = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,8)
    strLocaisCentrais.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),8));
    //<< 
    //<< quit strLocaisCentrais
    return strLocaisCentrais.get();
  }

  //<< 
  //<< getLocaisVinculadosCentral(pCompany=0)
  public Object getLocaisVinculadosCentral(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< if ($get(YM)=""){
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YM")),""))) {
      //<< do ^WWWVAR
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< }
    //<< 
    //<< new LocaisVinculadosCentral
    mVar LocaisVinculadosCentral = m$.var("LocaisVinculadosCentral");
    m$.newVar(LocaisVinculadosCentral);
    //<< set LocaisVinculadosCentral = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,15)
    LocaisVinculadosCentral.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),15));
    //<< 
    //<< quit LocaisVinculadosCentral
    return LocaisVinculadosCentral.get();
  }

  //<< 
  //<< getPermiteProcessoMultiplosPedidos(pCompany=0)
  public Object getPermiteProcessoMultiplosPedidos(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< new blnPermiteProcessoMultiplosPedidos
    mVar blnPermiteProcessoMultiplosPedidos = m$.var("blnPermiteProcessoMultiplosPedidos");
    m$.newVar(blnPermiteProcessoMultiplosPedidos);
    //<< set blnPermiteProcessoMultiplosPedidos = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,9)
    blnPermiteProcessoMultiplosPedidos.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),9));
    //<< 
    //<< quit blnPermiteProcessoMultiplosPedidos
    return blnPermiteProcessoMultiplosPedidos.get();
  }

  //<< 
  //<< getValidaFiltrosRelatorio(pCompany=0)
  public Object getValidaFiltrosRelatorio(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;--------------------------------------------------------------------------------------
    //<< ;  Valida se será aberta ou não a tela VARFiltrosRelatorio na geração de um relatório.
    //<< ;
    //<< ;
    //<< ;20-Apr-2011    Thiago  Created
    //<< ;--------------------------------------------------------------------------------------
    //<< 
    //<< new pValidate, pValidadeEmpresa
    mVar pValidate = m$.var("pValidate");
    mVar pValidadeEmpresa = m$.var("pValidadeEmpresa");
    m$.newVar(pValidate,pValidadeEmpresa);
    //<< 
    //<< set pValidateEmpresa=$piece($get(^VARParametroCliente(YM,pCompany,1)),Y,11)
    mVar pValidateEmpresa = m$.var("pValidateEmpresa");
    pValidateEmpresa.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),11));
    //<< 
    //<< set pValidate=$piece($get(^VARPreferenciasUsuario(YM,YBED,1)),Y,1)
    pValidate.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARPreferenciasUsuario",m$.var("YM").get(),m$.var("YBED").get(),1)),m$.var("Y").get(),1));
    //<< 
    //<< if (pValidate= 2){
    if ((mOp.Equal(pValidate.get(),2))) {
      //<< set pValidate = pValidateEmpresa
      pValidate.set(pValidateEmpresa.get());
      //<< quit pValidate
      return pValidate.get();
    }
    //<< }else{
    else {
      //<< quit pValidate
      return pValidate.get();
    }
  }

  //<< }
  //<< 
  //<< getPedidoCompraOpcional(pCompany=0)
  public Object getPedidoCompraOpcional(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< new blnPedidoCompraOpcional
    mVar blnPedidoCompraOpcional = m$.var("blnPedidoCompraOpcional");
    m$.newVar(blnPedidoCompraOpcional);
    //<< set blnPedidoCompraOpcional = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,16)
    blnPedidoCompraOpcional.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),16));
    //<< 
    //<< quit blnPedidoCompraOpcional
    return blnPedidoCompraOpcional.get();
  }

  //<< 
  //<< 
  //<< getEnviarEmailRecebimentoProdReq(pCompany=0)
  public Object getEnviarEmailRecebimentoProdReq(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;--------------------------------------------------------------------------------------
    //<< ;  Retorna se é para enviar email de alerta de recebimento de produtos com requisições
    //<< ;  pendentes.
    //<< ;
    //<< ;   21-Mar-2012 Gustavo     Created
    //<< ;--------------------------------------------------------------------------------------
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< 
    //<< new blnEnviaEmailRecProdReq
    mVar blnEnviaEmailRecProdReq = m$.var("blnEnviaEmailRecProdReq");
    m$.newVar(blnEnviaEmailRecProdReq);
    //<< set blnEnviaEmailRecProdReq = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,25)
    blnEnviaEmailRecProdReq.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),25));
    //<< if (blnEnviaEmailRecProdReq = ""){
    if ((mOp.Equal(blnEnviaEmailRecProdReq.get(),""))) {
      //<< set blnEnviaEmailRecProdReq = $$$NO
      blnEnviaEmailRecProdReq.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< 
    //<< quit blnEnviaEmailRecProdReq
    return blnEnviaEmailRecProdReq.get();
  }

  //<< 
  //<< 
  //<< getUsuariosAlertaRecebimentoProdReq(pCompany=0)
  public Object getUsuariosAlertaRecebimentoProdReq(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;--------------------------------------------------------------------------------------
    //<< ;  Retorna os usuários que serão usados para enviar o e-mail de Alerta de Recebimento
    //<< ;  de Produtos com Requisições Pendentes e que não havia estoque
    //<< ;
    //<< ;  21-Mar-2012  Gustavo     Created
    //<< ;--------------------------------------------------------------------------------------
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< new ListaUsuarios
    mVar ListaUsuarios = m$.var("ListaUsuarios");
    m$.newVar(ListaUsuarios);
    //<< set ListaUsuarios = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,26)
    ListaUsuarios.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),26));
    //<< 
    //<< quit ListaUsuarios
    return ListaUsuarios.get();
  }

  //<< 
  //<< getControlarValidadeAtaLinha(pCompany=0)
  public Object getControlarValidadeAtaLinha(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;--------------------------------------------------------------------------------------
    //<< ;  Retorna se a validade da ata está sendo controlada na linha ou não (quando não,
    //<< ;  ela é controlada no cabeçalho).
    //<< ;
    //<< ;  21-Mar-2012  Gustavo     Created
    //<< ;--------------------------------------------------------------------------------------
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< new blnControlarValidadeAtaLinha
    mVar blnControlarValidadeAtaLinha = m$.var("blnControlarValidadeAtaLinha");
    m$.newVar(blnControlarValidadeAtaLinha);
    //<< set blnControlarValidadeAtaLinha = $piece($get(^VARParametroCliente(YM,pCompany,1)),Y,30)
    blnControlarValidadeAtaLinha.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)),m$.var("Y").get(),30));
    //<< 
    //<< quit blnControlarValidadeAtaLinha
    return blnControlarValidadeAtaLinha.get();
  }

  //<< 
  //<< getParticoesAMonitorar(pCompany=0)
  public Object getParticoesAMonitorar(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< new strParticoesAMonitorar
    mVar strParticoesAMonitorar = m$.var("strParticoesAMonitorar");
    m$.newVar(strParticoesAMonitorar);
    //<< set strParticoesAMonitorar = $$$VARParametroClienteParticoesAMonitorar($get(^VARParametroCliente(YM, pCompany, 1)))
    strParticoesAMonitorar.set(include.VARConst.$$$VARParametroClienteParticoesAMonitorar(m$,m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1))));
    //<< 
    //<< quit strParticoesAMonitorar
    return strParticoesAMonitorar.get();
  }

  //<< 
  //<< getPercMaxAceitUsoParticao(pCompany=0)
  public Object getPercMaxAceitUsoParticao(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< new fltPercMaxAceitUsoParticao
    mVar fltPercMaxAceitUsoParticao = m$.var("fltPercMaxAceitUsoParticao");
    m$.newVar(fltPercMaxAceitUsoParticao);
    //<< set fltPercMaxAceitUsoParticao = +$$$VARParametroClientePercMaxAceitUsoParticao($get(^VARParametroCliente(YM, pCompany, 1)))
    fltPercMaxAceitUsoParticao.set(mOp.Positive(include.VARConst.$$$VARParametroClientePercMaxAceitUsoParticao(m$,m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1)))));
    //<< 
    //<< quit fltPercMaxAceitUsoParticao
    return fltPercMaxAceitUsoParticao.get();
  }

  //<< 
  //<< getUsuariosAlertaDisco(pCompany=0)
  public Object getUsuariosAlertaDisco(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< new strUsuariosAlertaDisco
    mVar strUsuariosAlertaDisco = m$.var("strUsuariosAlertaDisco");
    m$.newVar(strUsuariosAlertaDisco);
    //<< set strUsuariosAlertaDisco = $$$VARParametroClienteUsuariosAlertaDisco($get(^VARParametroCliente(YM, pCompany, 1)))
    strUsuariosAlertaDisco.set(include.VARConst.$$$VARParametroClienteUsuariosAlertaDisco(m$,m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),pCompany.get(),1))));
    //<< 
    //<< quit strUsuariosAlertaDisco
    return strUsuariosAlertaDisco.get();
  }

  //<< 
  //<< OnAfterSave()
  public Object OnAfterSave() {
    //<< set objParametroCliente = $get(^VARParametroCliente(YM,YM,1))
    mVar objParametroCliente = m$.var("objParametroCliente");
    objParametroCliente.set(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),m$.var("YM").get(),1)));
    //<< 
    //<< set valorAntigoFlagLicencas = +$$isExplicitLicenseUserIdentification^COMSTARTZstart()
    mVar valorAntigoFlagLicencas = m$.var("valorAntigoFlagLicencas");
    valorAntigoFlagLicencas.set(mOp.Positive(m$.fnc$("COMSTARTZstart.isExplicitLicenseUserIdentification")));
    //<< set novoValorFlagLicencas = +$get(VORG(1))
    mVar novoValorFlagLicencas = m$.var("novoValorFlagLicencas");
    novoValorFlagLicencas.set(mOp.Positive(m$.Fnc.$get(m$.var("VORG").var(1))));
    //<< 
    //<< if (novoValorFlagLicencas '= valorAntigoFlagLicencas) {
    if ((mOp.NotEqual(novoValorFlagLicencas.get(),valorAntigoFlagLicencas.get()))) {
      //<< do setLicenseUserIdentification^COMSTARTZstart(novoValorFlagLicencas)
      m$.Cmd.Do("COMSTARTZstart.setLicenseUserIdentification",novoValorFlagLicencas.get());
    }
    //<< }
    //<< 
    //<< set antigoLicenseUserIDs = $$$VARParametroClienteIDsUsuariosPadraoLicencas(objParametroCliente)
    mVar antigoLicenseUserIDs = m$.var("antigoLicenseUserIDs");
    antigoLicenseUserIDs.set(include.VARConst.$$$VARParametroClienteIDsUsuariosPadraoLicencas(m$,objParametroCliente));
    //<< set novoLicenseUserIDs = $$$VARParametroClienteIDsUsuariosPadraoLicencas($get(YFELD))
    mVar novoLicenseUserIDs = m$.var("novoLicenseUserIDs");
    novoLicenseUserIDs.set(include.VARConst.$$$VARParametroClienteIDsUsuariosPadraoLicencas(m$,m$.Fnc.$get(m$.var("YFELD"))));
    //<< 
    //<< if (novoLicenseUserIDs '= antigoLicenseUserIDs) {
    if ((mOp.NotEqual(novoLicenseUserIDs.get(),antigoLicenseUserIDs.get()))) {
      //<< do setDefaultLicenseUserIds^COMSTARTZstart(novoLicenseUserIDs)
      m$.Cmd.Do("COMSTARTZstart.setDefaultLicenseUserIds",novoLicenseUserIDs.get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

//<< 
}
