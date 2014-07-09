//*****************************************************************************
//** TASC - ALPHALINC - MAC VARINReq
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-08 12:36:38
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

//<< VARINReq
public class VARINReq extends mClass {

  public void main() {
    _VARINReq();
  }

  public void _VARINReq() {
    //<< quit
    return;
  }

  //<< 
  //<< PrintJS(pobjForm)
  public Object PrintJS(Object ... _p) {
    mVar pobjForm = m$.newVarRef("pobjForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
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
    //<< 
    //<< &js<
    //<< var req = document.#(YHTMFORM)#.#(strP1Name)#.value;
    //<< 
    //<< function confirmPrompt() {
    //<< var settings = "dialogWidth: 420px; dialogHeight: 110px; center: yes; " +
    //<< "edge: sunked; scroll: yes; status: no";
    //<< eval('var url ="#(YAKTION)#EP=WWWFORM&YFORM=VAREncerrarRequisicao&YKEY='+req+'&YUSER=#(YUSER)#&YBED=#(YBED)#"');
    //<< if(window.showModalDialog) {
    //<< return window.showModalDialog(url,"name",settings);
    //<< }
    //<< }
    //<< 
    //<< function encerrarReq() {
    //<< CallBackNow("EncerrarOnClickJS^VARINReq", req);
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("        var req = document.",(m$.var("YHTMFORM").get())),"."),(strP1Name.get())),".value;"),"\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        function confirmPrompt() {","\n");
    m$.Cmd.WriteJS("            var settings = \"dialogWidth: 420px; dialogHeight: 110px; center: yes; \" +","\n");
    m$.Cmd.WriteJS("                \"edge: sunked; scroll: yes; status: no\";","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("            eval('var url =\"",(m$.var("YAKTION").get())),"EP=WWWFORM&YFORM=VAREncerrarRequisicao&YKEY='+req+'&YUSER="),(m$.var("YUSER").get())),"&YBED="),(m$.var("YBED").get())),"\"');"),"\n");
    m$.Cmd.WriteJS("            if(window.showModalDialog) {","\n");
    m$.Cmd.WriteJS("                return window.showModalDialog(url,\"name\",settings);","\n");
    m$.Cmd.WriteJS("            }","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        ","\n");
    m$.Cmd.WriteJS("        function encerrarReq() {","\n");
    m$.Cmd.WriteJS("            CallBackNow(\"EncerrarOnClickJS^VARINReq\", req);","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    ");
    //<< 
    //<< write !, "</script>"
    m$.Cmd.Write("\n","</script>");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< EncerrarOnClickJS(idReq)
  public Object EncerrarOnClickJS(Object ... _p) {
    mVar idReq = m$.newVarRef("idReq",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< &js<
    //<< var value = confirmPrompt();
    //<< if (value) {
    //<< CallBackNow("EncerrarOnClick^VARINReq", '#(idReq)#');
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("        var value = confirmPrompt();","\n");
    m$.Cmd.WriteJS("        if (value) {","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("            CallBackNow(\"EncerrarOnClick^VARINReq\", '",(idReq.get())),"');"),"\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    ");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< EncerrarOnClick(pidReq)
  public Object EncerrarOnClick(Object ... _p) {
    mVar pidReq = m$.newVarRef("pidReq",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< do ManuallyClose^INReq($g(YM),$g(YFORM),pidReq,$g(YFELD))
    m$.Cmd.Do("INReq.ManuallyClose",m$.Fnc.$get(m$.var("YM")),m$.Fnc.$get(m$.var("YFORM")),pidReq.get(),m$.Fnc.$get(m$.var("YFELD")));
    //<< quit
    return null;
  }

  //<< 
  //<< OnAfterButtonLine()
  public Object OnAfterButtonLine() {
    //<< //utilizado no form modal VAREncerrarRequisicao
    //<< 
    //<< &html<
    //<< <script type='text/javascript'>
    //<< function SetFocus(){
    //<< var inputYes = document.getElementById("buttonYes");
    //<< var inputNo  = document.getElementById("buttonNo");
    //<< inputYes.blur();
    //<< inputNo.focus();
    //<< }
    //<< function yesConfirm(){
    //<< window.returnValue = 1;
    //<< window.close();
    //<< return false;
    //<< }
    //<< function noConfirm(){
    //<< window.returnValue = 0;
    //<< window.close();
    //<< return false;
    //<< }
    //<< </script>
    //<< <body>
    //<< <blockquote style="font-size:12px;font-weight:bold;margin-top:10px;text-align:center;">Tem certeza que deseja encerrar esta requisição ?</blockquote>
    //<< <div style="width:396px;text-align:center;">
    //<< <input id="buttonYes" type="button" value="    SIM    " onclick="yesConfirm();" style="font-weight:bold;margin-right:10px;cursor:pointer;">
    //<< <input id="buttonNo"  type="button" value="    NÃO    " onclick="noConfirm(); " style="font-weight:bold;margin-left:10px;cursor:pointer;">
    //<< </div>
    //<< <script type='text/javascript'>
    //<< SetFocus();
    //<< </script>
    //<< </body>
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("        <script type='text/javascript'>","\n");
    m$.Cmd.WriteHtml("            function SetFocus(){","\n");
    m$.Cmd.WriteHtml("                var inputYes = document.getElementById(\"buttonYes\");","\n");
    m$.Cmd.WriteHtml("                var inputNo  = document.getElementById(\"buttonNo\");","\n");
    m$.Cmd.WriteHtml("                inputYes.blur();","\n");
    m$.Cmd.WriteHtml("                inputNo.focus();","\n");
    m$.Cmd.WriteHtml("            }","\n");
    m$.Cmd.WriteHtml("            function yesConfirm(){","\n");
    m$.Cmd.WriteHtml("                window.returnValue = 1;","\n");
    m$.Cmd.WriteHtml("                window.close();","\n");
    m$.Cmd.WriteHtml("                return false;","\n");
    m$.Cmd.WriteHtml("            }","\n");
    m$.Cmd.WriteHtml("            function noConfirm(){","\n");
    m$.Cmd.WriteHtml("                window.returnValue = 0;","\n");
    m$.Cmd.WriteHtml("                window.close();","\n");
    m$.Cmd.WriteHtml("                return false;","\n");
    m$.Cmd.WriteHtml("            }","\n");
    m$.Cmd.WriteHtml("        </script>","\n");
    m$.Cmd.WriteHtml("        <body>","\n");
    m$.Cmd.WriteHtml("            <blockquote style=\"font-size:12px;font-weight:bold;margin-top:10px;text-align:center;\">Tem certeza que deseja encerrar esta requisição ?</blockquote>","\n");
    m$.Cmd.WriteHtml("            <div style=\"width:396px;text-align:center;\">","\n");
    m$.Cmd.WriteHtml("                <input id=\"buttonYes\" type=\"button\" value=\"    SIM    \" onclick=\"yesConfirm();\" style=\"font-weight:bold;margin-right:10px;cursor:pointer;\">","\n");
    m$.Cmd.WriteHtml("                <input id=\"buttonNo\"  type=\"button\" value=\"    NÃO    \" onclick=\"noConfirm(); \" style=\"font-weight:bold;margin-left:10px;cursor:pointer;\">","\n");
    m$.Cmd.WriteHtml("            </div>","\n");
    m$.Cmd.WriteHtml("            <script type='text/javascript'>","\n");
    m$.Cmd.WriteHtml("                SetFocus();","\n");
    m$.Cmd.WriteHtml("            </script>","\n");
    m$.Cmd.WriteHtml("        </body>","\n");
    m$.Cmd.WriteHtml("    ");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< getPAMs(pidItem, pidLocation, &parrPAMs)
  public Object getPAMs(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar parrPAMs = m$.newVarRef("parrPAMs",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< 
    //<< new strPAMs, idPAM, rsPam, rsPamAfm, meuSQL
    mVar strPAMs = m$.var("strPAMs");
    mVar idPAM = m$.var("idPAM");
    mVar rsPam = m$.var("rsPam");
    mVar rsPamAfm = m$.var("rsPamAfm");
    mVar meuSQL = m$.var("meuSQL");
    m$.newVar(strPAMs,idPAM,rsPam,rsPamAfm,meuSQL);
    //<< 
    //<< // Para todos os PAMs.
    //<< set strPAMs = ""
    strPAMs.set("");
    //<< set rsPam = ##class(%ResultSet).%New()
    rsPam.set(m$.fnc$("$ResultSet.$New"));
    //<< 
    //<< set meuSQL = ""
    meuSQL.set("");
    //<< set meuSQL = meuSQL_" SELECT  pedido.NoPedido AS PAM"
    meuSQL.set(mOp.Concat(meuSQL.get()," SELECT  pedido.NoPedido AS PAM"));
    //<< set meuSQL = meuSQL_" FROM VARPedidoCompra pedido "
    meuSQL.set(mOp.Concat(meuSQL.get()," FROM VARPedidoCompra pedido "));
    //<< set meuSQL = meuSQL_" JOIN VARPedidoCompraLinha linha ON pedido.NoPedido = linha.NoPedido "
    meuSQL.set(mOp.Concat(meuSQL.get()," JOIN VARPedidoCompraLinha linha ON pedido.NoPedido = linha.NoPedido "));
    //<< set meuSQL = meuSQL_" WHERE pedido.Company = 0 "
    meuSQL.set(mOp.Concat(meuSQL.get()," WHERE pedido.Company = 0 "));
    //<< set meuSQL = meuSQL_" AND  linha.Produto = """_pidItem_""" "
    meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," AND  linha.Produto = \""),pidItem.get()),"\" "));
    //<< if (pidLocation '= ""){
    if ((mOp.NotEqual(pidLocation.get(),""))) {
      //<< set meuSQL = meuSQL_" AND pedido.LocaldeEntrega = "_pidLocation_""
      meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," AND pedido.LocaldeEntrega = "),pidLocation.get()),""));
    }
    //<< }
    //<< set meuSQL = meuSQL_" AND linha.Quantidade > 0 "
    meuSQL.set(mOp.Concat(meuSQL.get()," AND linha.Quantidade > 0 "));
    //<< set meuSQL = meuSQL_" AND pedido.Status = 1 "
    meuSQL.set(mOp.Concat(meuSQL.get()," AND pedido.Status = 1 "));
    //<< 
    //<< do rsPam.Prepare(meuSQL)
    m$.Cmd.Do(rsPam.getORef(),"Prepare",meuSQL.get());
    //<< do rsPam.Execute()
    m$.Cmd.Do(rsPam.getORef(),"Execute");
    //<< 
    //<< while (rsPam.Next()) {
    while (mOp.Logical((m$.fnc$(rsPam.getORef(),"Next")))) {
      //<< set idPAM = rsPam.GetDataByName("PAM")
      idPAM.set(m$.fnc$(rsPam.getORef(),"GetDataByName","PAM"));
      //<< set parrPAMs(idPAM) = ""
      parrPAMs.var(idPAM.get()).set("");
    }
    //<< }
    //<< 
    //<< // Pegar agora os PAMs que estão associados com alguma AFM cujo item ainda não foi
    //<< // totalmente recebido.
    //<< set rsPamAfm = ##class(%ResultSet).%New()
    rsPamAfm.set(m$.fnc$("$ResultSet.$New"));
    //<< 
    //<< set meuSQL = ""
    meuSQL.set("");
    //<< set meuSQL = meuSQL_" SELECT compra.FREE20 AS PAM "
    meuSQL.set(mOp.Concat(meuSQL.get()," SELECT compra.FREE20 AS PAM "));
    //<< set meuSQL = meuSQL_" FROM INAUF compra "
    meuSQL.set(mOp.Concat(meuSQL.get()," FROM INAUF compra "));
    //<< set meuSQL = meuSQL_" JOIN INAUFP linha ON compra.OrderNumber = linha.OrderNo "
    meuSQL.set(mOp.Concat(meuSQL.get()," JOIN INAUFP linha ON compra.OrderNumber = linha.OrderNo "));
    //<< set meuSQL = meuSQL_" WHERE compra.Company = 0 "
    meuSQL.set(mOp.Concat(meuSQL.get()," WHERE compra.Company = 0 "));
    //<< if (pidLocation '= ""){
    if ((mOp.NotEqual(pidLocation.get(),""))) {
      //<< set meuSQL = meuSQL_" AND compra.Location = "_pidLocation_""
      meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," AND compra.Location = "),pidLocation.get()),""));
    }
    //<< }
    //<< set meuSQL = meuSQL_" AND linha.ItemNumber  = """_pidItem_""" "
    meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," AND linha.ItemNumber  = \""),pidItem.get()),"\" "));
    //<< set meuSQL = meuSQL_" AND compra.FREE14 < 3 "
    meuSQL.set(mOp.Concat(meuSQL.get()," AND compra.FREE14 < 3 "));
    //<< 
    //<< do rsPamAfm.Prepare(meuSQL)
    m$.Cmd.Do(rsPamAfm.getORef(),"Prepare",meuSQL.get());
    //<< do rsPamAfm.Execute()
    m$.Cmd.Do(rsPamAfm.getORef(),"Execute");
    //<< 
    //<< while (rsPamAfm.Next()) {
    while (mOp.Logical((m$.fnc$(rsPamAfm.getORef(),"Next")))) {
      //<< set idPAM = rsPamAfm.GetDataByName("PAM")
      idPAM.set(m$.fnc$(rsPamAfm.getORef(),"GetDataByName","PAM"));
      //<< set parrPAMs(idPAM) = ""
      parrPAMs.var(idPAM.get()).set("");
    }
    //<< }
    //<< 
    //<< // Montando a lista de PAMs.
    //<< set idPAM = ""
    idPAM.set("");
    //<< for {
    for (;true;) {
      //<< set idPAM = $order(parrPAMs(idPAM))
      idPAM.set(m$.Fnc.$order(parrPAMs.var(idPAM.get())));
      //<< quit:(idPAM = "")
      if ((mOp.Equal(idPAM.get(),""))) {
        break;
      }
      //<< 
      //<< if strPAMs = "" {
      if (mOp.Equal(strPAMs.get(),"")) {
        //<< set strPAMs = idPAM
        strPAMs.set(idPAM.get());
      }
      //<< } else {
      else {
        //<< set strPAMs = strPAMs_";"_idPAM
        strPAMs.set(mOp.Concat(mOp.Concat(strPAMs.get(),";"),idPAM.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strPAMs
    return strPAMs.get();
  }

  //<< 
  //<< getAFMs(pidItem, pidLocation, &parrOpenAFMs)
  public Object getAFMs(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar parrOpenAFMs = m$.newVarRef("parrOpenAFMs",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< new rsAfm, meuSQL, idAFM, strAFMs
    mVar rsAfm = m$.var("rsAfm");
    mVar meuSQL = m$.var("meuSQL");
    mVar idAFM = m$.var("idAFM");
    mVar strAFMs = m$.var("strAFMs");
    m$.newVar(rsAfm,meuSQL,idAFM,strAFMs);
    //<< set strAFMs=""
    strAFMs.set("");
    //<< 
    //<< // Verificar todas as AFMLines que ainda não foram totalmente recebidas.
    //<< // Apenas para o local em questão.
    //<< set rsAfm = ##class(%ResultSet).%New()
    rsAfm.set(m$.fnc$("$ResultSet.$New"));
    //<< 
    //<< set meuSQL = ""
    meuSQL.set("");
    //<< set meuSQL = meuSQL_" SELECT compra.OrderNumber AS AFM "
    meuSQL.set(mOp.Concat(meuSQL.get()," SELECT compra.OrderNumber AS AFM "));
    //<< set meuSQL = meuSQL_" FROM INAUF compra "
    meuSQL.set(mOp.Concat(meuSQL.get()," FROM INAUF compra "));
    //<< set meuSQL = meuSQL_" JOIN INAUFP linha ON compra.OrderNumber = linha.OrderNo "
    meuSQL.set(mOp.Concat(meuSQL.get()," JOIN INAUFP linha ON compra.OrderNumber = linha.OrderNo "));
    //<< set meuSQL = meuSQL_" WHERE compra.Company = 0 "
    meuSQL.set(mOp.Concat(meuSQL.get()," WHERE compra.Company = 0 "));
    //<< if (pidLocation '= ""){
    if ((mOp.NotEqual(pidLocation.get(),""))) {
      //<< set meuSQL = meuSQL_" AND compra.Location = "_pidLocation_""
      meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," AND compra.Location = "),pidLocation.get()),""));
    }
    //<< }
    //<< set meuSQL = meuSQL_" AND linha.ItemNumber  = """_pidItem_""" "
    meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," AND linha.ItemNumber  = \""),pidItem.get()),"\" "));
    //<< set meuSQL = meuSQL_" AND compra.FREE14 < 3 "
    meuSQL.set(mOp.Concat(meuSQL.get()," AND compra.FREE14 < 3 "));
    //<< 
    //<< do rsAfm.Prepare(meuSQL)
    m$.Cmd.Do(rsAfm.getORef(),"Prepare",meuSQL.get());
    //<< do rsAfm.Execute()
    m$.Cmd.Do(rsAfm.getORef(),"Execute");
    //<< 
    //<< while (rsAfm.Next()) {
    while (mOp.Logical((m$.fnc$(rsAfm.getORef(),"Next")))) {
      //<< set idAFM = rsAfm.GetDataByName("AFM")
      idAFM.set(m$.fnc$(rsAfm.getORef(),"GetDataByName","AFM"));
      //<< set parrOpenAFMs(idAFM) = ""
      parrOpenAFMs.var(idAFM.get()).set("");
    }
    //<< }
    //<< 
    //<< // Montar a String de retorno
    //<< set idAFM = ""
    idAFM.set("");
    //<< for {
    for (;true;) {
      //<< set idAFM = $order(parrOpenAFMs(idAFM))
      idAFM.set(m$.Fnc.$order(parrOpenAFMs.var(idAFM.get())));
      //<< quit:(idAFM = "")
      if ((mOp.Equal(idAFM.get(),""))) {
        break;
      }
      //<< 
      //<< if strAFMs = "" {
      if (mOp.Equal(strAFMs.get(),"")) {
        //<< set strAFMs = idAFM
        strAFMs.set(idAFM.get());
      }
      //<< } else {
      else {
        //<< set strAFMs = strAFMs_";"_idAFM
        strAFMs.set(mOp.Concat(mOp.Concat(strAFMs.get(),";"),idAFM.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strAFMs
    return strAFMs.get();
  }

  //<< 
  //<< getProcessos(idItem, Local, &parrProcessos)
  public Object getProcessos(Object ... _p) {
    mVar idItem = m$.newVarRef("idItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Local = m$.newVarRef("Local",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar parrProcessos = m$.newVarRef("parrProcessos",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< new arrPAMs, idPAM, objPAM, idProcesso, strProcessos
    mVar arrPAMs = m$.var("arrPAMs");
    mVar idPAM = m$.var("idPAM");
    mVar objPAM = m$.var("objPAM");
    mVar idProcesso = m$.var("idProcesso");
    mVar strProcessos = m$.var("strProcessos");
    m$.newVar(arrPAMs,idPAM,objPAM,idProcesso,strProcessos);
    //<< 
    //<< do getPAMs(idItem, Local, .arrPAMs)
    m$.Cmd.Do("getPAMs",idItem.get(),Local.get(),arrPAMs);
    //<< 
    //<< $$$Order1(arrPAMs,idPAM)
    idPAM.set("");
    for (;true;) {
      idPAM.set(m$.Fnc.$order(arrPAMs.var(idPAM.get())));
      if (mOp.Equal(idPAM.get(),"")) {
        break;
      }
      //<< 
      //<< set objPAM = $get(^VARPedidoCompra(YM, idPAM, 1))
      objPAM.set(m$.Fnc.$get(m$.var("^VARPedidoCompra",m$.var("YM").get(),idPAM.get(),1)));
      //<< set idProcesso = $$$VARPedidoCompraProcessoSICOP(objPAM)
      idProcesso.set(include.VARConst.$$$VARPedidoCompraProcessoSICOP(m$,objPAM));
      //<< set parrProcessos(idPAM) = idProcesso
      parrProcessos.var(idPAM.get()).set(idProcesso.get());
    }
    //<< 
    //<< $$$End
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< getEmpenhos(pItem, pLocation, &parrEmpenhos)
  public Object getEmpenhos(Object ... _p) {
    mVar pItem = m$.newVarRef("pItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pLocation = m$.newVarRef("pLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar parrEmpenhos = m$.newVarRef("parrEmpenhos",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< 
    //<< new arrAFMs, idAFM, objAFM, idEmpenho,strEmpenhos
    mVar arrAFMs = m$.var("arrAFMs");
    mVar idAFM = m$.var("idAFM");
    mVar objAFM = m$.var("objAFM");
    mVar idEmpenho = m$.var("idEmpenho");
    mVar strEmpenhos = m$.var("strEmpenhos");
    m$.newVar(arrAFMs,idAFM,objAFM,idEmpenho,strEmpenhos);
    //<< set strEmpenhos=""
    strEmpenhos.set("");
    //<< 
    //<< do getAFMs(pItem, pLocation, .arrAFMs)
    m$.Cmd.Do("getAFMs",pItem.get(),pLocation.get(),arrAFMs);
    //<< 
    //<< $$$Order1(arrAFMs,idAFM)
    idAFM.set("");
    for (;true;) {
      idAFM.set(m$.Fnc.$order(arrAFMs.var(idAFM.get())));
      if (mOp.Equal(idAFM.get(),"")) {
        break;
      }
      //<< 
      //<< set objAFM    = $get(^INAUF(YM, idAFM, 1))
      objAFM.set(m$.Fnc.$get(m$.var("^INAUF",m$.var("YM").get(),idAFM.get(),1)));
      //<< set idEmpenho = $$$INAUFApproval1(objAFM)
      idEmpenho.set(include.INConst.$$$INAUFApproval1(m$,objAFM));
      //<< set parrEmpenhos(idAFM) = idEmpenho
      parrEmpenhos.var(idAFM.get()).set(idEmpenho.get());
      //<< if strEmpenhos'="" {
      if (mOp.NotEqual(strEmpenhos.get(),"")) {
        //<< set strEmpenhos=strEmpenhos_";"_idAFM_"||"_idEmpenho
        strEmpenhos.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strEmpenhos.get(),";"),idAFM.get()),"||"),idEmpenho.get()));
      }
      //<< }else {
      else {
        //<< set strEmpenhos=idAFM_"||"_idEmpenho
        strEmpenhos.set(mOp.Concat(mOp.Concat(idAFM.get(),"||"),idEmpenho.get()));
      }
    }
    //<< }
    //<< 
    //<< $$$End
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< getFornecedores(pItem, pLocation, &parrFornecedores)
  public Object getFornecedores(Object ... _p) {
    mVar pItem = m$.newVarRef("pItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pLocation = m$.newVarRef("pLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar parrFornecedores = m$.newVarRef("parrFornecedores",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< 
    //<< new arrAFMs, idAFM, objAFM, idaFornecedor, idFornecedor
    mVar arrAFMs = m$.var("arrAFMs");
    mVar idAFM = m$.var("idAFM");
    mVar objAFM = m$.var("objAFM");
    mVar idaFornecedor = m$.var("idaFornecedor");
    mVar idFornecedor = m$.var("idFornecedor");
    m$.newVar(arrAFMs,idAFM,objAFM,idaFornecedor,idFornecedor);
    //<< 
    //<< do getAFMs(pItem, pLocation, .arrAFMs)
    m$.Cmd.Do("getAFMs",pItem.get(),pLocation.get(),arrAFMs);
    //<< 
    //<< $$$Order1(arrAFMs,idAFM)
    idAFM.set("");
    for (;true;) {
      idAFM.set(m$.Fnc.$order(arrAFMs.var(idAFM.get())));
      if (mOp.Equal(idAFM.get(),"")) {
        break;
      }
      //<< 
      //<< set objAFM    = $get(^INAUF(YM, idAFM, 1))
      objAFM.set(m$.Fnc.$get(m$.var("^INAUF",m$.var("YM").get(),idAFM.get(),1)));
      //<< set idaFornecedor = $$$INAUFSupplierNumber(objAFM)
      idaFornecedor.set(include.INConst.$$$INAUFSupplierNumber(m$,objAFM));
      //<< set idFornecedor  = $extract($$$INLIEFName1($get(^INLIEF(YM,idaFornecedor,1))),1,12)
      idFornecedor.set(m$.Fnc.$extract(include.INConst.$$$INLIEFName1(m$,m$.Fnc.$get(m$.var("^INLIEF",m$.var("YM").get(),idaFornecedor.get(),1))),1,12));
      //<< set parrFornecedores(idAFM) = idFornecedor
      parrFornecedores.var(idAFM.get()).set(idFornecedor.get());
    }
    //<< 
    //<< $$$End
    //<< 
    //<< quit
    return null;
  }

//<< 
}
