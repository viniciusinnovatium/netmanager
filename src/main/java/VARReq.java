//*****************************************************************************
//** TASC - ALPHALINC - MAC VARReq
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-08 11:56:42
//*****************************************************************************

import mLibrary.*;

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
//<< #include INConst
import include.INConst;
//<< #include VARConst
import include.VARConst;

//<< VARReq
public class VARReq extends mClass {

  public void main() {
    _VARReq();
  }

  public void _VARReq() {
  }

  //<< 
  //<< VarHookOnBeforeSave(YFELD)
  public Object VarHookOnBeforeSave(Object ... _p) {
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new strStatus, objVARParametroCliente, intPrazoMinimoEntrega, objINReq
    mVar strStatus = m$.var("strStatus");
    mVar objVARParametroCliente = m$.var("objVARParametroCliente");
    mVar intPrazoMinimoEntrega = m$.var("intPrazoMinimoEntrega");
    mVar objINReq = m$.var("objINReq");
    m$.newVar(strStatus,objVARParametroCliente,intPrazoMinimoEntrega,objINReq);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if $GET(YKEY)'=""{
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY")),"")) {
      //<< $$$Order3(^INReqLine,YM,YKEY,idLine)
      mVar idLine = m$.var("idLine");
      idLine.set("");
      for (;true;) {
        idLine.set(m$.Fnc.$order(m$.var("^INReqLine",m$.var("YM").get(),m$.var("YKEY").get(),idLine.get())));
        if (mOp.Equal(idLine.get(),"")) {
          break;
        }
        //<< set objLine=$get(^INReqLine(YM,YKEY,idLine,1))
        mVar objLine = m$.var("objLine");
        objLine.set(m$.Fnc.$get(m$.var("^INReqLine",m$.var("YM").get(),m$.var("YKEY").get(),idLine.get(),1)));
        //<< if YFELD'="" {
        if (mOp.NotEqual(YFELD.get(),"")) {
          //<< set $$$INReqLineFromStockLocn(objLine)=$$$INReqFromLocn(YFELD)
          include.INConst.$$$INReqLineFromStockLocnSet(m$,objLine,include.INConst.$$$INReqFromLocn(m$,YFELD));
          //<< set key=YKEY_","_idLine
          mVar key = m$.var("key");
          key.set(mOp.Concat(mOp.Concat(m$.var("YKEY").get(),","),idLine.get()));
          //<< set status=$$Save^COMUtils("INReqLine",key,objLine,1)
          mVar status = m$.var("status");
          status.set(m$.fnc$("COMUtils.Save","INReqLine",key.get(),objLine.get(),1));
        }
      }
    }
    //<< }
    //<< $$$End
    //<< }
    //<< set objVARParametroCliente = $get(^VARParametroCliente(YM,YM,1))
    objVARParametroCliente.set(m$.Fnc.$get(m$.var("^VARParametroCliente",m$.var("YM").get(),m$.var("YM").get(),1)));
    //<< set intPrazoMinimoEntrega = +$$$VARParametroClientePrazoMinimoEntregaReq(objVARParametroCliente)
    intPrazoMinimoEntrega.set(mOp.Positive(include.VARConst.$$$VARParametroClientePrazoMinimoEntregaReq(m$,objVARParametroCliente)));
    //<< 
    //<< if ((YFORM = "INReq") && (YFELD '= "")) {
    if (mOp.Logical(((mOp.Equal(m$.var("YFORM").get(),"INReq")) && (mOp.NotEqual(YFELD.get(),""))))) {
      //<< if (($$$INReqStatus(YFELD) = 1) && ($$$INReqDueDate(YFELD) < ($horolog + intPrazoMinimoEntrega))) {
      if (mOp.Logical(((mOp.Equal(include.INConst.$$$INReqStatus(m$,YFELD),1)) && (mOp.Less(include.INConst.$$$INReqDueDate(m$,YFELD),(mOp.Add(m$.Fnc.$horolog(),intPrazoMinimoEntrega.get()))))))) {
        //<< do StartScript^COMUtiljavascript()
        m$.Cmd.Do("COMUtiljavascript.StartScript");
        //<< if (intPrazoMinimoEntrega > 0) {
        if ((mOp.Greater(intPrazoMinimoEntrega.get(),0))) {
          //<< if (intPrazoMinimoEntrega = 1) {
          if ((mOp.Equal(intPrazoMinimoEntrega.get(),1))) {
            //<< write "alert('Atenção: a data de entrega mínima é de 1 dia útil.'); "
            m$.Cmd.Write("alert('Atenção: a data de entrega mínima é de 1 dia útil.'); ");
          }
          //<< } else {
          else {
            //<< write "alert('Atenção: a data de entrega mínima é de "_intPrazoMinimoEntrega_" dias úteis.'); "
            m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('Atenção: a data de entrega mínima é de ",intPrazoMinimoEntrega.get())," dias úteis.'); "));
          }
        }
        //<< }
        //<< } else {
        else {
          //<< write "alert('Atenção: a data de entrega deveria ser posterior à data atual.'); "
          m$.Cmd.Write("alert('Atenção: a data de entrega deveria ser posterior à data atual.'); ");
        }
        //<< }
        //<< do EndScript^COMUtiljavascript()
        m$.Cmd.Do("COMUtiljavascript.EndScript");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< CanViewReport(pKEY)
  public Object CanViewReport(Object ... _p) {
    mVar pKEY = m$.newVarRef("pKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new objINReq
    mVar objINReq = m$.var("objINReq");
    m$.newVar(objINReq);
    //<< if $$$NoKey(pKEY) {
    if (mOp.Logical(include.COMSYS.$$$NoKey(m$,pKEY))) {
      //<< set YQ = $$$YQDisable("Selecione um registro.")
      mVar YQ = m$.var("YQ");
      YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"Selecione um registro."));
    }
    //<< }else{
    else {
      //<< set objINReq = $get(^INReq(0,pKEY,1))
      objINReq.set(m$.Fnc.$get(m$.var("^INReq",0,pKEY.get(),1)));
      //<< if objINReq="" {
      if (mOp.Equal(objINReq.get(),"")) {
        //<< set YQ = $$$YQDisable("Selecione um registro.")
        mVar YQ = m$.var("YQ");
        YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"Selecione um registro."));
      }
      //<< }else {
      else {
        //<< if $$$INReqStatus(objINReq) > 1 {
        if (mOp.Greater(include.INConst.$$$INReqStatus(m$,objINReq),1)) {
          //<< set YQ = $$$YQEnable
          mVar YQ = m$.var("YQ");
          YQ.set(include.COMSYSWWW.$$$YQEnable(m$));
        }
        //<< }else{
        else {
          //<< set YQ = $$$YQDisable("A requisição precisa ter sido confirmada para poder gerar o relatório.")
          mVar YQ = m$.var("YQ");
          YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"A requisição precisa ter sido confirmada para poder gerar o relatório."));
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
  //<< ImprimeRelatorio(YKEY)
  public Object ImprimeRelatorio(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< do RunReportRequisicao^VARJasperRunReport(YKEY)
    m$.Cmd.Do("VARJasperRunReport.RunReportRequisicao",YKEY.get());
    //<< 
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CanConfirmPrinting(pidSolic)
  public Object CanConfirmPrinting(Object ... _p) {
    mVar pidSolic = m$.newVarRef("pidSolic",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< //Marcelo, 16/10/2011 -- Copiado da VARSESSolicTransf.mac
    //<< //Desabilita o botão de confirmação de impressão caso a solicitação ainda não tenha sido processada.
    //<< 
    //<< if (YKEY) {
    if (mOp.Logical((m$.var("YKEY").get()))) {
      //<< 
      //<< set objSolicTransf = $get(^INReq(YM, pidSolic, 1))
      mVar objSolicTransf = m$.var("objSolicTransf");
      objSolicTransf.set(m$.Fnc.$get(m$.var("^INReq",m$.var("YM").get(),pidSolic.get(),1)));
      //<< 
      //<< if '$$$INReqProcessDate(YFELD) {
      if (mOp.Not(include.INConst.$$$INReqProcessDate(m$,m$.var("YFELD")))) {
        //<< set YQ = $$$YQDisable($$$Text("MED01172"))  ;Só é possível confirmar a impressão depois que a solicitação tiver sido processada ;use text macro;15-Sep-2008
        mVar YQ = m$.var("YQ");
        YQ.set(include.COMSYSWWW.$$$YQDisable(m$,include.COMSYS.$$$Text(m$,"MED01172")));
      }
      //<< }
      //<< elseif ($$$INReqFromLocn(YFELD) '= YLOCATION) {
      else if ((mOp.NotEqual(include.INConst.$$$INReqFromLocn(m$,m$.var("YFELD")),m$.var("YLOCATION").get()))) {
        //<< set YQ = $$$YQDisable($$$Text("MED01173"))  ;Só os usuários do local abastecedor podem confirmar que a solicitação já foi impressa ;use text macro;15-Sep-2008
        mVar YQ = m$.var("YQ");
        YQ.set(include.COMSYSWWW.$$$YQDisable(m$,include.COMSYS.$$$Text(m$,"MED01173")));
      }
    }
    //<< 
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ConfirmPrinting(pidSolic)
  public Object ConfirmPrinting(Object ... _p) {
    mVar pidSolic = m$.newVarRef("pidSolic",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< //Marcelo, 16/10/2011 -- Copiado da VARSESSolicTransf.mac
    //<< //Seta o campo de Impresso para sim e não conforme se clica no botão de Confirmar/Desconfirmar Impressão.
    //<< 
    //<< if $get(pidSolic) = "" { quit }
    if (mOp.Equal(m$.Fnc.$get(pidSolic),"")) {
      return null;
    }
    //<< 
    //<< set objSolic = $get(^INReq(YM, pidSolic, 1))
    mVar objSolic = m$.var("objSolic");
    objSolic.set(m$.Fnc.$get(m$.var("^INReq",m$.var("YM").get(),pidSolic.get(),1)));
    //<< if $get(objSolic) = "" { quit }
    if (mOp.Equal(m$.Fnc.$get(objSolic),"")) {
      return null;
    }
    //<< 
    //<< if $$$INReqFREE6(objSolic) '= 1 {
    if (mOp.NotEqual(include.INConst.$$$INReqFREE6(m$,objSolic),1)) {
      //<< set $$$INReqFREE6(objSolic) = 1
      include.INConst.$$$INReqFREE6Set(m$,objSolic,1);
    }
    //<< }
    //<< 
    //<< else {
    else {
      //<< set $$$INReqFREE6(objSolic) = 0
      include.INConst.$$$INReqFREE6Set(m$,objSolic,0);
    }
    //<< }
    //<< 
    //<< set status = $$$Save("INReq",pidSolic,objSolic,1)
    mVar status = m$.var("status");
    status.set(include.COMSYS.$$$Save(m$,"INReq",pidSolic,objSolic,1));
    //<< 
    //<< if $$$ISERR(status) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,status))) {
      //<< $$$StartScript()
      include.COMSYS.$$$StartScript(m$);
      //<< write "alert('"_$$$Text("MED01175")_"'); "  ;Não foi possível confirmar a impressão. Erro ao salvar. ;use text macro;15-Sep-2008
      m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('",include.COMSYS.$$$Text(m$,"MED01175")),"'); "));
      //<< $$$EndScript()
      include.COMSYS.$$$EndScript(m$);
    }
    //<< }
    //<< 
    //<< do GoToForm^COMUtilForm("INReq", pidSolic)
    m$.Cmd.Do("COMUtilForm.GoToForm","INReq",pidSolic.get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< EditarObservacoes(YKEY)
  public Object EditarObservacoes(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< do GoToForm^COMUtilForm("VARINReqObservacoes", YKEY)
    m$.Cmd.Do("COMUtilForm.GoToForm","VARINReqObservacoes",YKEY.get());
    //<< 
    //<< quit
    return null;
  }

//<< 
}
