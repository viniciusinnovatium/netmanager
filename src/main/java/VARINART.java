//*****************************************************************************
//** TASC - ALPHALINC - MAC VARINART
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 17:30:12
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
//<< #include WWWConst
import include.WWWConst;

//<< VARINART
public class VARINART extends mClass {

  public void main() {
    _VARINART();
  }

  public void _VARINART() {
  }

  //<< 
  //<< OnAfterDataFieldsCustom(pidItem)
  public Object OnAfterDataFieldsCustom(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new strListaFornecedores, count, idFornecedor, objFornecedor, nomeFantasia, cnpjcpf,
    //<< telefone, fax
    mVar strListaFornecedores = m$.var("strListaFornecedores");
    mVar count = m$.var("count");
    mVar idFornecedor = m$.var("idFornecedor");
    mVar objFornecedor = m$.var("objFornecedor");
    mVar nomeFantasia = m$.var("nomeFantasia");
    mVar cnpjcpf = m$.var("cnpjcpf");
    mVar telefone = m$.var("telefone");
    mVar fax = m$.var("fax");
    m$.newVar(strListaFornecedores,count,idFornecedor,objFornecedor,nomeFantasia,cnpjcpf,telefone,fax);
    //<< 
    //<< ;Preservar a execução do OnAfterDataFields do formulário, e incluir o da customização
    //<< set YSTOP = $$$NO
    mVar YSTOP = m$.var("YSTOP");
    YSTOP.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< quit:($$$NoKey(pidItem))
    if (mOp.Logical((include.COMSYS.$$$NoKey(m$,pidItem)))) {
      return null;
    }
    //<< 
    //<< if (($get(YSEITE)) = 51) {          // Aba Fornecedores
    if ((mOp.Equal((m$.Fnc.$get(m$.var("YSEITE"))),51))) {
      //<< do PrintFornecedores(pidItem)
      m$.Cmd.Do("PrintFornecedores",pidItem.get());
    }
    //<< 
    //<< } elseif (($get(YSEITE) = 53)) {    // Aba Histórico
    else if (mOp.Logical(((mOp.Equal(m$.Fnc.$get(m$.var("YSEITE")),53))))) {
      //<< do PrintHistoricoItem(pidItem)
      m$.Cmd.Do("PrintHistoricoItem",pidItem.get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PrintFornecedores(pidItem)
  public Object PrintFornecedores(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pidItem = "")
    if ((mOp.Equal(pidItem.get(),""))) {
      return null;
    }
    //<< 
    //<< new strListaFornecedores, count, lstHeader, idFornecedor, objFornecedor, nomeFantasia, cnpjcpf,
    //<< email, telefone, fax
    mVar strListaFornecedores = m$.var("strListaFornecedores");
    mVar count = m$.var("count");
    mVar lstHeader = m$.var("lstHeader");
    mVar idFornecedor = m$.var("idFornecedor");
    mVar objFornecedor = m$.var("objFornecedor");
    mVar nomeFantasia = m$.var("nomeFantasia");
    mVar cnpjcpf = m$.var("cnpjcpf");
    mVar email = m$.var("email");
    mVar telefone = m$.var("telefone");
    mVar fax = m$.var("fax");
    m$.newVar(strListaFornecedores,count,lstHeader,idFornecedor,objFornecedor,nomeFantasia,cnpjcpf,email,telefone,fax);
    //<< 
    //<< set strListaFornecedores = $$GetFornecedores(pidItem)
    strListaFornecedores.set(m$.fnc$("GetFornecedores",pidItem.get()));
    //<< set count = 0
    count.set(0);
    //<< 
    //<< //Monta cabeçalho da tabela
    //<< set lstHeader=""
    lstHeader.set("");
    //<< set lstHeader=lstHeader_$listbuild("Seq.","Cód.","Fornecedor","CNPJ/CPF","Email","Telefone 1","Fax")
    lstHeader.set(mOp.Concat(lstHeader.get(),m$.Fnc.$listbuild("Seq.","Cód.","Fornecedor","CNPJ/CPF","Email","Telefone 1","Fax")));
    //<< 
    //<< if $$Start^COMTable(lstHeader,"<div style=margin:3px;>Fornecedores identificados para o produto</div>",,,$$$NO) {
    if (mOp.Logical(m$.fnc$("COMTable.Start",lstHeader.get(),"<div style=margin:3px;>Fornecedores identificados para o produto</div>",null,null,include.COMSYS.$$$NO(m$)))) {
      //<< 
      //<< for cnt = 1:1:$length(strListaFornecedores,";") {
      mVar cnt = m$.var("cnt");
      for (cnt.set(1);(mOp.LessOrEqual(cnt.get(),m$.Fnc.$length(strListaFornecedores.get(),";")));cnt.set(mOp.Add(cnt.get(),1))) {
        //<< set idFornecedor = $piece(strListaFornecedores,";",cnt)
        idFornecedor.set(m$.Fnc.$piece(strListaFornecedores.get(),";",cnt.get()));
        //<< 
        //<< continue:(idFornecedor = "")
        if ((mOp.Equal(idFornecedor.get(),""))) {
          continue;
        }
        //<< continue:(idFornecedor = 0)  ;Não mostrar o fornecedor 0-Própria Empresa
        if ((mOp.Equal(idFornecedor.get(),0))) {
          continue;
        }
        //<< set count = $i(count)
        count.set(m$.Fnc.$increment(count));
        //<< 
        //<< set objFornecedor = $get(^INLIEF(YM,idFornecedor,1))
        objFornecedor.set(m$.Fnc.$get(m$.var("^INLIEF",m$.var("YM").get(),idFornecedor.get(),1)));
        //<< set nomeFantasia  = $piece(objFornecedor,Y,8)
        nomeFantasia.set(m$.Fnc.$piece(objFornecedor.get(),m$.var("Y").get(),8));
        //<< set cnpjcpf       = $piece(objFornecedor,Y,201)
        cnpjcpf.set(m$.Fnc.$piece(objFornecedor.get(),m$.var("Y").get(),201));
        //<< set email         = $piece(objFornecedor,Y,24)
        email.set(m$.Fnc.$piece(objFornecedor.get(),m$.var("Y").get(),24));
        //<< set telefone      = $piece(objFornecedor,Y,208)
        telefone.set(m$.Fnc.$piece(objFornecedor.get(),m$.var("Y").get(),208));
        //<< set fax           = $piece(objFornecedor,Y,22)
        fax.set(m$.Fnc.$piece(objFornecedor.get(),m$.var("Y").get(),22));
        //<< 
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< do InsertCell^COMTable(count,"INLIEF",idFornecedor)
        m$.Cmd.Do("COMTable.InsertCell",count.get(),"INLIEF",idFornecedor.get());
        //<< do InsertCell^COMTable(idFornecedor,"INLIEF",idFornecedor)
        m$.Cmd.Do("COMTable.InsertCell",idFornecedor.get(),"INLIEF",idFornecedor.get());
        //<< do InsertCell^COMTable(nomeFantasia,"INLIEF",idFornecedor)
        m$.Cmd.Do("COMTable.InsertCell",nomeFantasia.get(),"INLIEF",idFornecedor.get());
        //<< do InsertCell^COMTable(cnpjcpf,"INLIEF",idFornecedor)
        m$.Cmd.Do("COMTable.InsertCell",cnpjcpf.get(),"INLIEF",idFornecedor.get());
        //<< do InsertCell^COMTable(email,"INLIEF",idFornecedor)
        m$.Cmd.Do("COMTable.InsertCell",email.get(),"INLIEF",idFornecedor.get());
        //<< do InsertCell^COMTable(telefone,"INLIEF",idFornecedor)
        m$.Cmd.Do("COMTable.InsertCell",telefone.get(),"INLIEF",idFornecedor.get());
        //<< do InsertCell^COMTable(fax,"INLIEF",idFornecedor)
        m$.Cmd.Do("COMTable.InsertCell",fax.get(),"INLIEF",idFornecedor.get());
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
      }
      //<< }
      //<< 
      //<< if (count = 0) {
      if ((mOp.Equal(count.get(),0))) {
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< do InsertCell^COMTable("Nenhum fornecedor identificado para o produto.",,,,,,7)
        m$.Cmd.Do("COMTable.InsertCell","Nenhum fornecedor identificado para o produto.",null,null,null,null,null,7);
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
      }
      //<< }
      //<< 
      //<< if ((YKEY = "") || (YKEY = "+")) {
      if (mOp.Logical(((mOp.Equal(m$.var("YKEY").get(),"")) || (mOp.Equal(m$.var("YKEY").get(),"+"))))) {
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< do InsertCell^COMTable("Favor selecionar um produto.",,,,,,7)
        m$.Cmd.Do("COMTable.InsertCell","Favor selecionar um produto.",null,null,null,null,null,7);
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
      }
      //<< }
      //<< 
      //<< do Stop^COMTable()
      m$.Cmd.Do("COMTable.Stop");
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetFornecedores(pListItems)
  public Object GetFornecedores(Object ... _p) {
    mVar pListItems = m$.newVarRef("pListItems",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pListItems = "") ""
    if ((mOp.Equal(pListItems.get(),""))) {
      return "";
    }
    //<< 
    //<< new strListaFornecedores, cnt, idItem
    mVar strListaFornecedores = m$.var("strListaFornecedores");
    mVar cnt = m$.var("cnt");
    mVar idItem = m$.var("idItem");
    m$.newVar(strListaFornecedores,cnt,idItem);
    //<< set strListaFornecedores = ""
    strListaFornecedores.set("");
    //<< 
    //<< for cnt = 1:1:$length(pListItems,";") {
    for (cnt.set(1);(mOp.LessOrEqual(cnt.get(),m$.Fnc.$length(pListItems.get(),";")));cnt.set(mOp.Add(cnt.get(),1))) {
      //<< 
      //<< set idItem = $piece(pListItems,";",cnt)
      idItem.set(m$.Fnc.$piece(pListItems.get(),";",cnt.get()));
      //<< 
      //<< continue:(idItem = "")
      if ((mOp.Equal(idItem.get(),""))) {
        continue;
      }
      //<< continue:('$data(^INART(YM,idItem)))
      if ((mOp.Not(m$.Fnc.$data(m$.var("^INART",m$.var("YM").get(),idItem.get()))))) {
        continue;
      }
      //<< 
      //<< // 1. Busca a lista com as empresas que fornecem determinado produto, conforme relacionamento definido na INART
      //<< new idFornecedor, objFornecedor, strGroups, strItems, strItemsFind, itemFind, idGroup, groupFind, strGroupsFind,
      //<< idFornecedorFind
      mVar idFornecedor = m$.var("idFornecedor");
      mVar objFornecedor = m$.var("objFornecedor");
      mVar strGroups = m$.var("strGroups");
      mVar strItems = m$.var("strItems");
      mVar strItemsFind = m$.var("strItemsFind");
      mVar itemFind = m$.var("itemFind");
      mVar idGroup = m$.var("idGroup");
      mVar groupFind = m$.var("groupFind");
      mVar strGroupsFind = m$.var("strGroupsFind");
      mVar idFornecedorFind = m$.var("idFornecedorFind");
      m$.newVar(idFornecedor,objFornecedor,strGroups,strItems,strItemsFind,itemFind,idGroup,groupFind,strGroupsFind,idFornecedorFind);
      //<< 
      //<< $$$Order2(^INLIEF,YM,idFornecedor)
      idFornecedor.set("");
      for (;true;) {
        idFornecedor.set(m$.Fnc.$order(m$.var("^INLIEF",m$.var("YM").get(),idFornecedor.get())));
        if (mOp.Equal(idFornecedor.get(),"")) {
          break;
        }
        //<< set objFornecedor = $get(^INLIEF(YM,idFornecedor,1))
        objFornecedor.set(m$.Fnc.$get(m$.var("^INLIEF",m$.var("YM").get(),idFornecedor.get(),1)));
        //<< 
        //<< //Verifica se o fornecedor já foi selecionado
        //<< set idFornecedorFind = ";"_idFornecedor_";"
        idFornecedorFind.set(mOp.Concat(mOp.Concat(";",idFornecedor.get()),";"));
        //<< continue:($find(strListaFornecedores,idFornecedorFind))
        if (mOp.Logical((m$.Fnc.$find(strListaFornecedores.get(),idFornecedorFind.get())))) {
          continue;
        }
        //<< 
        //<< set strItems  = $piece(objFornecedor,Y,229)
        strItems.set(m$.Fnc.$piece(objFornecedor.get(),m$.var("Y").get(),229));
        //<< set strGroups = $piece(objFornecedor,Y,246)
        strGroups.set(m$.Fnc.$piece(objFornecedor.get(),m$.var("Y").get(),246));
        //<< 
        //<< if (strItems '= "") {
        if ((mOp.NotEqual(strItems.get(),""))) {
          //<< set strItemsFind = ";"_strItems_";"
          strItemsFind.set(mOp.Concat(mOp.Concat(";",strItems.get()),";"));
          //<< set itemFind = ";"_idItem_";"
          itemFind.set(mOp.Concat(mOp.Concat(";",idItem.get()),";"));
          //<< 
          //<< if $find(strItemsFind,itemFind) {
          if (mOp.Logical(m$.Fnc.$find(strItemsFind.get(),itemFind.get()))) {
            //<< 
            //<< if (strListaFornecedores = "") {
            if ((mOp.Equal(strListaFornecedores.get(),""))) {
              //<< set strListaFornecedores = strListaFornecedores_";"_idFornecedor_";"
              strListaFornecedores.set(mOp.Concat(mOp.Concat(mOp.Concat(strListaFornecedores.get(),";"),idFornecedor.get()),";"));
            }
            //<< } else {
            else {
              //<< set strListaFornecedores = strListaFornecedores_idFornecedor_";"
              strListaFornecedores.set(mOp.Concat(mOp.Concat(strListaFornecedores.get(),idFornecedor.get()),";"));
            }
            //<< }
            //<< 
            //<< continue ;se já encontrou o produto individualmente, não há porque verificar se o grupo está lá também
            continue;
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if (strGroups '= "") {
        if ((mOp.NotEqual(strGroups.get(),""))) {
          //<< set strGroupsFind = ";"_strGroups_";"
          strGroupsFind.set(mOp.Concat(mOp.Concat(";",strGroups.get()),";"));
          //<< 
          //<< set idGroup = $piece($get(^INART(YM,idItem,1)),Y,30)
          idGroup.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),idItem.get(),1)),m$.var("Y").get(),30));
          //<< set groupFind = ";"_idGroup_";"
          groupFind.set(mOp.Concat(mOp.Concat(";",idGroup.get()),";"));
          //<< 
          //<< if $find(strGroupsFind,groupFind) {
          if (mOp.Logical(m$.Fnc.$find(strGroupsFind.get(),groupFind.get()))) {
            //<< if (strListaFornecedores = "") {
            if ((mOp.Equal(strListaFornecedores.get(),""))) {
              //<< set strListaFornecedores = strListaFornecedores_";"_idFornecedor_";"
              strListaFornecedores.set(mOp.Concat(mOp.Concat(mOp.Concat(strListaFornecedores.get(),";"),idFornecedor.get()),";"));
            }
            //<< } else {
            else {
              //<< set strListaFornecedores = strListaFornecedores_idFornecedor_";"
              strListaFornecedores.set(mOp.Concat(mOp.Concat(strListaFornecedores.get(),idFornecedor.get()),";"));
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< $$$End
      //<< 
      //<< // 2. Busca a lista com as empresas que já forneceram determinado produto conforme relacionamento na INAUF
      //<< new idCompra, idFornecedorCompra, idFornecedorCompraFind, objCompra
      mVar idCompra = m$.var("idCompra");
      mVar idFornecedorCompra = m$.var("idFornecedorCompra");
      mVar idFornecedorCompraFind = m$.var("idFornecedorCompraFind");
      mVar objCompra = m$.var("objCompra");
      m$.newVar(idCompra,idFornecedorCompra,idFornecedorCompraFind,objCompra);
      //<< $$$Order4(^INAUFPs,YM,8,idItem,idCompra)
      idCompra.set("");
      for (;true;) {
        idCompra.set(m$.Fnc.$order(m$.var("^INAUFPs",m$.var("YM").get(),8,idItem.get(),idCompra.get())));
        if (mOp.Equal(idCompra.get(),"")) {
          break;
        }
        //<< 
        //<< set objCompra = $get(^INAUF(YM,idCompra,1))
        objCompra.set(m$.Fnc.$get(m$.var("^INAUF",m$.var("YM").get(),idCompra.get(),1)));
        //<< set idFornecedorCompra = $piece(objCompra,Y,12)
        idFornecedorCompra.set(m$.Fnc.$piece(objCompra.get(),m$.var("Y").get(),12));
        //<< continue:(idFornecedorCompra = "")
        if ((mOp.Equal(idFornecedorCompra.get(),""))) {
          continue;
        }
        //<< 
        //<< set idFornecedorCompraFind = ";"_idFornecedorCompra_";"
        idFornecedorCompraFind.set(mOp.Concat(mOp.Concat(";",idFornecedorCompra.get()),";"));
        //<< 
        //<< if '$find(strListaFornecedores,idFornecedorCompraFind) {
        if (mOp.Not(m$.Fnc.$find(strListaFornecedores.get(),idFornecedorCompraFind.get()))) {
          //<< if (strListaFornecedores = "") {
          if ((mOp.Equal(strListaFornecedores.get(),""))) {
            //<< set strListaFornecedores = strListaFornecedores_";"_idFornecedorCompra_";"
            strListaFornecedores.set(mOp.Concat(mOp.Concat(mOp.Concat(strListaFornecedores.get(),";"),idFornecedorCompra.get()),";"));
          }
          //<< } else {
          else {
            //<< set strListaFornecedores = strListaFornecedores_idFornecedorCompra_";"
            strListaFornecedores.set(mOp.Concat(mOp.Concat(strListaFornecedores.get(),idFornecedorCompra.get()),";"));
          }
        }
      }
      //<< }
      //<< }
      //<< 
      //<< $$$End
      //<< 
      //<< 
      //<< // 3. Busca a lista com as empresas que possuem de preço registrado no catálogo do banco de preços
      //<< new idLinha, idFornecedorCatalogo, idFornecedorCatalogoFind, objBancoPrecoLinha
      mVar idLinha = m$.var("idLinha");
      mVar idFornecedorCatalogo = m$.var("idFornecedorCatalogo");
      mVar idFornecedorCatalogoFind = m$.var("idFornecedorCatalogoFind");
      mVar objBancoPrecoLinha = m$.var("objBancoPrecoLinha");
      m$.newVar(idLinha,idFornecedorCatalogo,idFornecedorCatalogoFind,objBancoPrecoLinha);
      //<< $$$Order3(^VARBancoPrecoLinha,YM,idItem,idLinha)
      idLinha.set("");
      for (;true;) {
        idLinha.set(m$.Fnc.$order(m$.var("^VARBancoPrecoLinha",m$.var("YM").get(),idItem.get(),idLinha.get())));
        if (mOp.Equal(idLinha.get(),"")) {
          break;
        }
        //<< 
        //<< set objBancoPrecoLinha = $get(^VARBancoPrecoLinha(YM,idItem,idLinha,1))
        objBancoPrecoLinha.set(m$.Fnc.$get(m$.var("^VARBancoPrecoLinha",m$.var("YM").get(),idItem.get(),idLinha.get(),1)));
        //<< set idFornecedorCatalogo = $piece(objBancoPrecoLinha,Y,1)
        idFornecedorCatalogo.set(m$.Fnc.$piece(objBancoPrecoLinha.get(),m$.var("Y").get(),1));
        //<< continue:(idFornecedorCatalogo = "")
        if ((mOp.Equal(idFornecedorCatalogo.get(),""))) {
          continue;
        }
        //<< 
        //<< set idFornecedorCatalogoFind = ";"_idFornecedorCatalogo_";"
        idFornecedorCatalogoFind.set(mOp.Concat(mOp.Concat(";",idFornecedorCatalogo.get()),";"));
        //<< 
        //<< if '$find(strListaFornecedores,idFornecedorCatalogoFind) {
        if (mOp.Not(m$.Fnc.$find(strListaFornecedores.get(),idFornecedorCatalogoFind.get()))) {
          //<< if (strListaFornecedores = "") {
          if ((mOp.Equal(strListaFornecedores.get(),""))) {
            //<< set strListaFornecedores = strListaFornecedores_";"_idFornecedorCatalogo_";"
            strListaFornecedores.set(mOp.Concat(mOp.Concat(mOp.Concat(strListaFornecedores.get(),";"),idFornecedorCatalogo.get()),";"));
          }
          //<< } else {
          else {
            //<< set strListaFornecedores = strListaFornecedores_idFornecedorCatalogo_";"
            strListaFornecedores.set(mOp.Concat(mOp.Concat(strListaFornecedores.get(),idFornecedorCatalogo.get()),";"));
          }
        }
      }
      //<< }
      //<< }
      //<< 
      //<< $$$End
      //<< 
      //<< // 4. Busca a lista das empresas que foram participantes em estimativa de preços
      //<< new idFornecedor, idParticipante, idParticipanteFind
      mVar idParticipante = m$.var("idParticipante");
      mVar idParticipanteFind = m$.var("idParticipanteFind");
      m$.newVar(idFornecedor,idParticipante,idParticipanteFind);
      //<< $$$Order3(^VARBancoPrecoEstimativaForns,YM,1,idParticipante)
      idParticipante.set("");
      for (;true;) {
        idParticipante.set(m$.Fnc.$order(m$.var("^VARBancoPrecoEstimativaForns",m$.var("YM").get(),1,idParticipante.get())));
        if (mOp.Equal(idParticipante.get(),"")) {
          break;
        }
        //<< continue:(idParticipante = "")
        if ((mOp.Equal(idParticipante.get(),""))) {
          continue;
        }
        //<< 
        //<< set idParticipanteFind = ";"_idParticipante_";"
        idParticipanteFind.set(mOp.Concat(mOp.Concat(";",idParticipante.get()),";"));
        //<< 
        //<< if '$find(strListaFornecedores,idParticipanteFind) {
        if (mOp.Not(m$.Fnc.$find(strListaFornecedores.get(),idParticipanteFind.get()))) {
          //<< if (strListaFornecedores = "") {
          if ((mOp.Equal(strListaFornecedores.get(),""))) {
            //<< set strListaFornecedores = strListaFornecedores_";"_idParticipante_";"
            strListaFornecedores.set(mOp.Concat(mOp.Concat(mOp.Concat(strListaFornecedores.get(),";"),idParticipante.get()),";"));
          }
          //<< } else {
          else {
            //<< set strListaFornecedores = strListaFornecedores_idParticipante_";"
            strListaFornecedores.set(mOp.Concat(mOp.Concat(strListaFornecedores.get(),idParticipante.get()),";"));
          }
        }
      }
      //<< }
      //<< }
      //<< $$$End
      //<< 
      //<< 
      //<< // 5. Busca a lista das empresas que possuem cotação registrada (preço) em estimativas de preços
      //<< new idFornecedor, idFornecedorEstimativaFind
      mVar idFornecedorEstimativaFind = m$.var("idFornecedorEstimativaFind");
      m$.newVar(idFornecedor,idFornecedorEstimativaFind);
      //<< $$$Order3(^VARBancoPrecoEstimativaProps,YM,1,idFornecedor)
      idFornecedor.set("");
      for (;true;) {
        idFornecedor.set(m$.Fnc.$order(m$.var("^VARBancoPrecoEstimativaProps",m$.var("YM").get(),1,idFornecedor.get())));
        if (mOp.Equal(idFornecedor.get(),"")) {
          break;
        }
        //<< continue:(idFornecedor = "")
        if ((mOp.Equal(idFornecedor.get(),""))) {
          continue;
        }
        //<< 
        //<< set idFornecedorEstimativaFind = ";"_idFornecedor_";"
        idFornecedorEstimativaFind.set(mOp.Concat(mOp.Concat(";",idFornecedor.get()),";"));
        //<< 
        //<< if '$find(strListaFornecedores,idFornecedorEstimativaFind) {
        if (mOp.Not(m$.Fnc.$find(strListaFornecedores.get(),idFornecedorEstimativaFind.get()))) {
          //<< if (strListaFornecedores = "") {
          if ((mOp.Equal(strListaFornecedores.get(),""))) {
            //<< set strListaFornecedores = strListaFornecedores_";"_idFornecedor_";"
            strListaFornecedores.set(mOp.Concat(mOp.Concat(mOp.Concat(strListaFornecedores.get(),";"),idFornecedor.get()),";"));
          }
          //<< } else {
          else {
            //<< set strListaFornecedores = strListaFornecedores_idFornecedor_";"
            strListaFornecedores.set(mOp.Concat(mOp.Concat(strListaFornecedores.get(),idFornecedor.get()),";"));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< $$$End
    //<< 
    //<< }
    //<< 
    //<< quit strListaFornecedores
    return strListaFornecedores.get();
  }

  //<< 
  //<< GerarChaveINART(pYKEY, pYFELD)
  public Object GerarChaveINART(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;do GerarChaveINART^VARINART(YKEY, YFELD)
    //<< 
    //<< if (pYKEY = 0) || (pYKEY = "") || (pYKEY = "+") {
    if ((mOp.Equal(pYKEY.get(),0)) || (mOp.Equal(pYKEY.get(),"")) || (mOp.Equal(pYKEY.get(),"+"))) {
      //<< 
      //<< new eFisco, unidadeEFisco, novoCodigo, eFiscoFormat
      mVar eFisco = m$.var("eFisco");
      mVar unidadeEFisco = m$.var("unidadeEFisco");
      mVar novoCodigo = m$.var("novoCodigo");
      mVar eFiscoFormat = m$.var("eFiscoFormat");
      m$.newVar(eFisco,unidadeEFisco,novoCodigo,eFiscoFormat);
      //<< 
      //<< set strStatus = $$$OK
      mVar strStatus = m$.var("strStatus");
      strStatus.set(include.COMSYS.$$$OK(m$));
      //<< 
      //<< set eFisco        = $piece(pYFELD,Y,340)
      eFisco.set(m$.Fnc.$piece(pYFELD.get(),m$.var("Y").get(),340));
      //<< set unidadeEFisco = $piece(pYFELD,Y,341)
      unidadeEFisco.set(m$.Fnc.$piece(pYFELD.get(),m$.var("Y").get(),341));
      //<< 
      //<< ;Formata o código e-Fisco
      //<< set eFiscoFormat  = $translate($piece(eFisco,".",1),"-")
      eFiscoFormat.set(m$.Fnc.$translate(m$.Fnc.$piece(eFisco.get(),".",1),"-"));
      //<< 
      //<< set novoCodigo = eFiscoFormat_"."_unidadeEFisco
      novoCodigo.set(mOp.Concat(mOp.Concat(eFiscoFormat.get(),"."),unidadeEFisco.get()));
      //<< 
      //<< if $D(^INART(YM,novoCodigo)){
      if (mOp.Logical(m$.Fnc.$data(m$.var("^INART",m$.var("YM").get(),novoCodigo.get())))) {
        //<< set strStatus = "O produto "_novoCodigo_" não pôde ser cadastrado."
        strStatus.set(mOp.Concat(mOp.Concat("O produto ",novoCodigo.get())," não pôde ser cadastrado."));
      }
      //<< }
      //<< else{
      else {
        //<< ;Insere os dados na Classe(Classe,Chave Primária,Valores,Always Save)
        //<< set strStatus = $$$Save("INART",novoCodigo,pYFELD,1)
        strStatus.set(include.COMSYS.$$$Save(m$,"INART",novoCodigo,pYFELD,1));
      }
      //<< }
      //<< 
      //<< if strStatus'=$$$OK {
      if (mOp.NotEqual(strStatus.get(),include.COMSYS.$$$OK(m$))) {
        //<< set Q = $$$QDontSave
        mVar Q = m$.var("Q");
        Q.set(include.COMSYSWWW.$$$QDontSave(m$));
        //<< do ^WWWINFO(strStatus)
        m$.Cmd.Do("WWWINFO.main",strStatus.get());
      }
      //<< }
      //<< else{
      else {
        //<< 
        //<< $$$StartScript()
        include.COMSYS.$$$StartScript(m$);
        //<< write "BEARB('Salvo',1); "
        m$.Cmd.Write("BEARB('Salvo',1); ");
        //<< $$$EndScript()
        include.COMSYS.$$$EndScript(m$);
        //<< 
        //<< 
        //<< ;Altera a aba para 50-Principal, que é customizada
        //<< ;Pois estava abrindo na aba 1-Geral
        //<< set YSEITE = 50
        mVar YSEITE = m$.var("YSEITE");
        YSEITE.set(50);
        //<< do RedirectForm^COMUtilForm("INART",novoCodigo,YBACK,YPARA,YSEITE)
        m$.Cmd.Do("COMUtilForm.RedirectForm","INART",novoCodigo.get(),m$.var("YBACK").get(),m$.var("YPARA").get(),YSEITE.get());
        //<< //do GoToForm^COMUtilForm("INART", novoCodigo, 1)
        //<< 
        //<< set Q = $$$QDontSave
        mVar Q = m$.var("Q");
        Q.set(include.COMSYSWWW.$$$QDontSave(m$));
      }
    }
    //<< 
    //<< }
    //<< 
    //<< }
    //<< 
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PopularContador()
  public Object PopularContador() {
    //<< ;do PopularContador^VARINART()
    //<< 
    //<< if $G(YM) = ""{
    if (mOp.Equal(m$.Fnc.$get(m$.var("YM")),"")) {
      //<< do ^WWWVAR
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< }
    //<< 
    //<< 
    //<< ;Limpa global
    //<< kill ^VARINARTContador
    m$.var("^VARINARTContador").kill();
    //<< 
    //<< ;Para cada produto
    //<< set codItem = ""
    mVar codItem = m$.var("codItem");
    codItem.set("");
    //<< for {
    for (;true;) {
      //<< set codItem = $order(^INART(0,codItem))
      codItem.set(m$.Fnc.$order(m$.var("^INART",0,codItem.get())));
      //<< quit:(codItem = "")
      if ((mOp.Equal(codItem.get(),""))) {
        break;
      }
      //<< 
      //<< set objITEM = $get(^INART(0,codItem,1))
      mVar objITEM = m$.var("objITEM");
      objITEM.set(m$.Fnc.$get(m$.var("^INART",0,codItem.get(),1)));
      //<< if objITEM = ""{
      if (mOp.Equal(objITEM.get(),"")) {
        //<< W "Dados não encontrados: "_codItem ,!
        m$.Cmd.Write(mOp.Concat("Dados não encontrados: ",codItem.get()),"\n");
        //<< continue
        continue;
      }
      //<< }
      //<< 
      //<< set codSubGrupoCad = $piece(objITEM,Y,30)
      mVar codSubGrupoCad = m$.var("codSubGrupoCad");
      codSubGrupoCad.set(m$.Fnc.$piece(objITEM.get(),m$.var("Y").get(),30));
      //<< if codSubGrupoCad = ""{
      if (mOp.Equal(codSubGrupoCad.get(),"")) {
        //<< W "Sub-Grupo em branco: "_codItem ,!
        m$.Cmd.Write(mOp.Concat("Sub-Grupo em branco: ",codItem.get()),"\n");
        //<< continue
        continue;
      }
      //<< }
      //<< 
      //<< set codGrupoCad = $piece(codSubGrupoCad,".",1)
      mVar codGrupoCad = m$.var("codGrupoCad");
      codGrupoCad.set(m$.Fnc.$piece(codSubGrupoCad.get(),".",1));
      //<< if codGrupoCad = ""{
      if (mOp.Equal(codGrupoCad.get(),"")) {
        //<< W "Grupo em branco: "_codItem ,!
        m$.Cmd.Write(mOp.Concat("Grupo em branco: ",codItem.get()),"\n");
        //<< continue
        continue;
      }
      //<< }
      //<< 
      //<< 
      //<< set tamGrupo   = $length(codItem)-4
      mVar tamGrupo = m$.var("tamGrupo");
      tamGrupo.set(mOp.Subtract(m$.Fnc.$length(codItem.get()),4));
      //<< set codGrupo   = $extract(codItem,1,tamGrupo)
      mVar codGrupo = m$.var("codGrupo");
      codGrupo.set(m$.Fnc.$extract(codItem.get(),1,tamGrupo.get()));
      //<< set codProduto = $extract(codItem,tamGrupo+1,$length(codItem))
      mVar codProduto = m$.var("codProduto");
      codProduto.set(m$.Fnc.$extract(codItem.get(),mOp.Add(tamGrupo.get(),1),m$.Fnc.$length(codItem.get())));
      //<< 
      //<< if (codGrupoCad'=codGrupo) {
      if ((mOp.NotEqual(codGrupoCad.get(),codGrupo.get()))) {
        //<< W "Grupo cadastrado diferente do código do produto: "_codItem_" Grupo Cadastrado: "_codGrupoCad ,!
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("Grupo cadastrado diferente do código do produto: ",codItem.get())," Grupo Cadastrado: "),codGrupoCad.get()),"\n");
        //<< continue
        continue;
      }
      //<< }
      //<< ;W codItem_": "_codGrupo_"-"_codProduto_"#"
      //<< 
      //<< ;Remove zeros a esquerda e grava no contador
      //<< set ^VARINARTContador(codGrupo) = $zstrip($fnumber(codProduto,"T"),"<>W")
      m$.var("^VARINARTContador",codGrupo.get()).set(m$.Fnc.$zstrip(m$.Fnc.$fnumber(codProduto.get(),"T"),"<>W"));
    }
    //<< 
    //<< }
    //<< 
    //<< W "Contadores gerados:" ,!
    m$.Cmd.Write("Contadores gerados:","\n");
    //<< set codContador = ""
    mVar codContador = m$.var("codContador");
    codContador.set("");
    //<< for {
    for (;true;) {
      //<< set codContador = $order(^VARINARTContador(codContador))
      codContador.set(m$.Fnc.$order(m$.var("^VARINARTContador",codContador.get())));
      //<< quit:(codContador = "")
      if ((mOp.Equal(codContador.get(),""))) {
        break;
      }
      //<< 
      //<< W "Grupo: "_codContador_" = "_$G(^VARINARTContador(codContador)) ,!
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("Grupo: ",codContador.get())," = "),m$.Fnc.$get(m$.var("^VARINARTContador",codContador.get()))),"\n");
    }
    //<< 
    //<< }
    //<< 
    //<< 
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CheckItemPolicyHasProgram(pidItem)
  public Object CheckItemPolicyHasProgram(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;Gustavo - 01/Set/2011 - Verifica se a política do produto contempla programa ou não
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< 
    //<< new objItem, idItemPolicy, objPolicy, ProgramPolicy, blnItemPolicyHasProgram
    mVar objItem = m$.var("objItem");
    mVar idItemPolicy = m$.var("idItemPolicy");
    mVar objPolicy = m$.var("objPolicy");
    mVar ProgramPolicy = m$.var("ProgramPolicy");
    mVar blnItemPolicyHasProgram = m$.var("blnItemPolicyHasProgram");
    m$.newVar(objItem,idItemPolicy,objPolicy,ProgramPolicy,blnItemPolicyHasProgram);
    //<< 
    //<< set objItem = $get(^INART(YM,pidItem,1))
    objItem.set(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),pidItem.get(),1)));
    //<< set idItemPolicy = $$$INARTItemPolicy(objItem)
    idItemPolicy.set(include.INConst.$$$INARTItemPolicy(m$,objItem));
    //<< 
    //<< if (idItemPolicy '= "") {
    if ((mOp.NotEqual(idItemPolicy.get(),""))) {
      //<< set objPolicy = $get(^INItemPolicy(YM,idItemPolicy,1))
      objPolicy.set(m$.Fnc.$get(m$.var("^INItemPolicy",m$.var("YM").get(),idItemPolicy.get(),1)));
      //<< set ProgramPolicy = $$$INItemPolicyProgram1(objPolicy)
      ProgramPolicy.set(include.INConst.$$$INItemPolicyProgram1(m$,objPolicy));
      //<< 
      //<< if ( (ProgramPolicy = 1) || (ProgramPolicy = 3) ) { //1=Sim ou 3=Opcional
      if (mOp.Logical(((mOp.Equal(ProgramPolicy.get(),1)) || (mOp.Equal(ProgramPolicy.get(),3))))) {
        //<< set blnItemPolicyHasProgram = $$$YES
        blnItemPolicyHasProgram.set(include.COMSYS.$$$YES(m$));
      }
      //<< } else {
      else {
        //<< set blnItemPolicyHasProgram = $$$NO
        blnItemPolicyHasProgram.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit blnItemPolicyHasProgram
    return blnItemPolicyHasProgram.get();
  }

  //<< 
  //<< 
  //<< CheckItemPolicyHasBrand(pidItem)
  public Object CheckItemPolicyHasBrand(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;Gustavo - 01/Set/2011 - Verifica se a política do produto contempla marca ou não
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< 
    //<< new objItem, idItemPolicy, objPolicy, ProgramPolicy, blnItemPolicyHasBrand
    mVar objItem = m$.var("objItem");
    mVar idItemPolicy = m$.var("idItemPolicy");
    mVar objPolicy = m$.var("objPolicy");
    mVar ProgramPolicy = m$.var("ProgramPolicy");
    mVar blnItemPolicyHasBrand = m$.var("blnItemPolicyHasBrand");
    m$.newVar(objItem,idItemPolicy,objPolicy,ProgramPolicy,blnItemPolicyHasBrand);
    //<< 
    //<< set objItem = $get(^INART(YM,pidItem,1))
    objItem.set(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),pidItem.get(),1)));
    //<< set idItemPolicy = $$$INARTItemPolicy(objItem)
    idItemPolicy.set(include.INConst.$$$INARTItemPolicy(m$,objItem));
    //<< 
    //<< if (idItemPolicy '= "") {
    if ((mOp.NotEqual(idItemPolicy.get(),""))) {
      //<< set objPolicy = $get(^INItemPolicy(YM,idItemPolicy,1))
      objPolicy.set(m$.Fnc.$get(m$.var("^INItemPolicy",m$.var("YM").get(),idItemPolicy.get(),1)));
      //<< set ProgramPolicy = $$$INItemPolicyBrand(objPolicy)
      ProgramPolicy.set(include.INConst.$$$INItemPolicyBrand(m$,objPolicy));
      //<< 
      //<< if ( (ProgramPolicy = 1) || (ProgramPolicy = 3) ) { //1=Sim ou 3=Opcional
      if (mOp.Logical(((mOp.Equal(ProgramPolicy.get(),1)) || (mOp.Equal(ProgramPolicy.get(),3))))) {
        //<< set blnItemPolicyHasBrand = $$$YES
        blnItemPolicyHasBrand.set(include.COMSYS.$$$YES(m$));
      }
      //<< } else {
      else {
        //<< set blnItemPolicyHasBrand = $$$NO
        blnItemPolicyHasBrand.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit blnItemPolicyHasBrand
    return blnItemPolicyHasBrand.get();
  }

  //<< 
  //<< 
  //<< PrintHistoricoItem(pidItem)
  public Object PrintHistoricoItem(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Exibe tabela com o histórico de alterações do item.
    //<< ;
    //<< ; Histórico:
    //<< ; 16-Out-2011   RGB                 Alterações para pegar a ultima hora e usuários que alteraram.
    //<< ;                                   Por causa de outro salvamento realizado pela ^INART, ignoro alterações feitos pelo mesmo usuário em um espaço de 2 segundos.
    //<< ; 14-Set-2011   Gustavo Fiuza       Criado
    //<< ;-------------------------------------------------------------------------------
    //<< quit:(pidItem = "")
    if ((mOp.Equal(pidItem.get(),""))) {
      return null;
    }
    //<< 
    //<< new count, lstHeader, date, hour, idUsuario, objWWWPROAntes, objWWWPRODepois, acao, formatPre, formatPos,
    //<< ADescResumida, DDescResumida, ADescCompleta, DDescCompleta, AUnidade, DUnidade, DGrupo, AGrupo,
    //<< APadrao, DPadrao, ACurvaABC, DCurvaABC, AClassXYZ, DClassXYZ, AStatus, DStatus, lastTimeChange,lastUserChange,lastDateChange
    mVar count = m$.var("count");
    mVar lstHeader = m$.var("lstHeader");
    mVar date = m$.var("date");
    mVar hour = m$.var("hour");
    mVar idUsuario = m$.var("idUsuario");
    mVar objWWWPROAntes = m$.var("objWWWPROAntes");
    mVar objWWWPRODepois = m$.var("objWWWPRODepois");
    mVar acao = m$.var("acao");
    mVar formatPre = m$.var("formatPre");
    mVar formatPos = m$.var("formatPos");
    mVar ADescResumida = m$.var("ADescResumida");
    mVar DDescResumida = m$.var("DDescResumida");
    mVar ADescCompleta = m$.var("ADescCompleta");
    mVar DDescCompleta = m$.var("DDescCompleta");
    mVar AUnidade = m$.var("AUnidade");
    mVar DUnidade = m$.var("DUnidade");
    mVar DGrupo = m$.var("DGrupo");
    mVar AGrupo = m$.var("AGrupo");
    mVar APadrao = m$.var("APadrao");
    mVar DPadrao = m$.var("DPadrao");
    mVar ACurvaABC = m$.var("ACurvaABC");
    mVar DCurvaABC = m$.var("DCurvaABC");
    mVar AClassXYZ = m$.var("AClassXYZ");
    mVar DClassXYZ = m$.var("DClassXYZ");
    mVar AStatus = m$.var("AStatus");
    mVar DStatus = m$.var("DStatus");
    mVar lastTimeChange = m$.var("lastTimeChange");
    mVar lastUserChange = m$.var("lastUserChange");
    mVar lastDateChange = m$.var("lastDateChange");
    m$.newVar(count,lstHeader,date,hour,idUsuario,objWWWPROAntes,objWWWPRODepois,acao,formatPre,formatPos,ADescResumida,DDescResumida,ADescCompleta,DDescCompleta,AUnidade,DUnidade,DGrupo,AGrupo,APadrao,DPadrao,ACurvaABC,DCurvaABC,AClassXYZ,DClassXYZ,AStatus,DStatus,lastTimeChange,lastUserChange,lastDateChange);
    //<< 
    //<< set formatPre = "<font color=red>"
    formatPre.set("<font color=red>");
    //<< set formatPos = "</font>"
    formatPos.set("</font>");
    //<< set lastDateChange=""
    lastDateChange.set("");
    //<< set lastTimeChange=""
    lastTimeChange.set("");
    //<< set lastUserChange=""
    lastUserChange.set("");
    //<< set count = 0
    count.set(0);
    //<< set lstHeader = ""
    lstHeader.set("");
    //<< set lstHeader = lstHeader_$listbuild("Seq.","Ação","Data","Hora","Usuário","Descrição Resumida","Descrição Completa","UN","Grupo","Status","Padrão","ABC","XYZ")
    lstHeader.set(mOp.Concat(lstHeader.get(),m$.Fnc.$listbuild("Seq.","Ação","Data","Hora","Usuário","Descrição Resumida","Descrição Completa","UN","Grupo","Status","Padrão","ABC","XYZ")));
    //<< 
    //<< if $$Start^COMTable(lstHeader,"&nbsp;Histórico de Alterações do Produto",,,$$$NO) {
    if (mOp.Logical(m$.fnc$("COMTable.Start",lstHeader.get(),"&nbsp;Histórico de Alterações do Produto",null,null,include.COMSYS.$$$NO(m$)))) {
      //<< 
      //<< $$$Order3(^WWWPRO,YM,"INART",date)
      date.set("");
      for (;true;) {
        date.set(m$.Fnc.$order(m$.var("^WWWPRO",m$.var("YM").get(),"INART",date.get())));
        if (mOp.Equal(date.get(),"")) {
          break;
        }
        //<< $$$Order4(^WWWPRO,YM,"INART",date,hour)
        hour.set("");
        for (;true;) {
          hour.set(m$.Fnc.$order(m$.var("^WWWPRO",m$.var("YM").get(),"INART",date.get(),hour.get())));
          if (mOp.Equal(hour.get(),"")) {
            break;
          }
          //<< $$$Order5(^WWWPRO,YM,"INART",date,hour,idUsuario)
          idUsuario.set("");
          for (;true;) {
            idUsuario.set(m$.Fnc.$order(m$.var("^WWWPRO",m$.var("YM").get(),"INART",date.get(),hour.get(),idUsuario.get())));
            if (mOp.Equal(idUsuario.get(),"")) {
              break;
            }
            //<< $$$Order7(^WWWPRO,YM,"INART",date,hour,idUsuario,pidItem,idEstado)
            mVar idEstado = m$.var("idEstado");
            idEstado.set("");
            for (;true;) {
              idEstado.set(m$.Fnc.$order(m$.var("^WWWPRO",m$.var("YM").get(),"INART",date.get(),hour.get(),idUsuario.get(),pidItem.get(),idEstado.get())));
              if (mOp.Equal(idEstado.get(),"")) {
                break;
              }
              //<< 
              //<< //Rodando somente no estado 1 (melhor performance)
              //<< continue:(idEstado = 0)
              if ((mOp.Equal(idEstado.get(),0))) {
                continue;
              }
              //<< continue:((idUsuario=lastUserChange) && (lastDateChange=date) && (hour-lastTimeChange<2))
              if (mOp.Logical(((mOp.Equal(idUsuario.get(),lastUserChange.get())) && (mOp.Equal(lastDateChange.get(),date.get())) && (mOp.Less(mOp.Subtract(hour.get(),lastTimeChange.get()),2))))) {
                continue;
              }
              //<< set objWWWPROAntes  = $get(^WWWPRO(YM,"INART",date,hour,idUsuario,YKEY,0,1)) //Antes
              objWWWPROAntes.set(m$.Fnc.$get(m$.var("^WWWPRO",m$.var("YM").get(),"INART",date.get(),hour.get(),idUsuario.get(),m$.var("YKEY").get(),0,1)));
              //<< set objWWWPRODepois = $get(^WWWPRO(YM,"INART",date,hour,idUsuario,YKEY,1,1)) //Depois
              objWWWPRODepois.set(m$.Fnc.$get(m$.var("^WWWPRO",m$.var("YM").get(),"INART",date.get(),hour.get(),idUsuario.get(),m$.var("YKEY").get(),1,1)));
              //<< 
              //<< if ( (objWWWPROAntes = "") && (objWWWPRODepois '= "") ) {
              if (mOp.Logical(((mOp.Equal(objWWWPROAntes.get(),"")) && (mOp.NotEqual(objWWWPRODepois.get(),""))))) {
                //<< set acao = "Criado"
                acao.set("Criado");
              }
              //<< 
              //<< } elseif ( (objWWWPROAntes '= "") && (objWWWPRODepois = "") ) {
              else if (mOp.Logical(((mOp.NotEqual(objWWWPROAntes.get(),"")) && (mOp.Equal(objWWWPRODepois.get(),""))))) {
                //<< set acao = "Excluído"
                acao.set("Excluído");
              }
              //<< 
              //<< } else {
              else {
                //<< set acao = "Alterado"
                acao.set("Alterado");
              }
              //<< }
              //<< 
              //<< set ADescResumida    = $piece(objWWWPROAntes,Y,1)
              ADescResumida.set(m$.Fnc.$piece(objWWWPROAntes.get(),m$.var("Y").get(),1));
              //<< set ADescCompleta    = $piece(objWWWPROAntes,Y,10)
              ADescCompleta.set(m$.Fnc.$piece(objWWWPROAntes.get(),m$.var("Y").get(),10));
              //<< set AGrupo           = $piece(objWWWPROAntes,Y,30)
              AGrupo.set(m$.Fnc.$piece(objWWWPROAntes.get(),m$.var("Y").get(),30));
              //<< set AUnidade         = $piece(objWWWPROAntes,Y,40)
              AUnidade.set(m$.Fnc.$piece(objWWWPROAntes.get(),m$.var("Y").get(),40));
              //<< set AStatus          = $piece(objWWWPROAntes,Y,66)
              AStatus.set(m$.Fnc.$piece(objWWWPROAntes.get(),m$.var("Y").get(),66));
              //<< set ACurvaABC        = $piece(objWWWPROAntes,Y,166)
              ACurvaABC.set(m$.Fnc.$piece(objWWWPROAntes.get(),m$.var("Y").get(),166));
              //<< set AClassXYZ        = $piece(objWWWPROAntes,Y,277)
              AClassXYZ.set(m$.Fnc.$piece(objWWWPROAntes.get(),m$.var("Y").get(),277));
              //<< set APadrao          = $piece(objWWWPROAntes,Y,280)
              APadrao.set(m$.Fnc.$piece(objWWWPROAntes.get(),m$.var("Y").get(),280));
              //<< 
              //<< set DDescResumida    = $piece(objWWWPRODepois,Y,1)
              DDescResumida.set(m$.Fnc.$piece(objWWWPRODepois.get(),m$.var("Y").get(),1));
              //<< set DDescCompleta    = $piece(objWWWPRODepois,Y,10)
              DDescCompleta.set(m$.Fnc.$piece(objWWWPRODepois.get(),m$.var("Y").get(),10));
              //<< set DGrupo           = $piece(objWWWPRODepois,Y,30)
              DGrupo.set(m$.Fnc.$piece(objWWWPRODepois.get(),m$.var("Y").get(),30));
              //<< set DUnidade         = $piece(objWWWPRODepois,Y,40)
              DUnidade.set(m$.Fnc.$piece(objWWWPRODepois.get(),m$.var("Y").get(),40));
              //<< set DStatus          = $piece(objWWWPRODepois,Y,66)
              DStatus.set(m$.Fnc.$piece(objWWWPRODepois.get(),m$.var("Y").get(),66));
              //<< set DCurvaABC        = $piece(objWWWPRODepois,Y,166)
              DCurvaABC.set(m$.Fnc.$piece(objWWWPRODepois.get(),m$.var("Y").get(),166));
              //<< set DClassXYZ        = $piece(objWWWPRODepois,Y,277)
              DClassXYZ.set(m$.Fnc.$piece(objWWWPRODepois.get(),m$.var("Y").get(),277));
              //<< set DPadrao          = $piece(objWWWPRODepois,Y,280)
              DPadrao.set(m$.Fnc.$piece(objWWWPRODepois.get(),m$.var("Y").get(),280));
              //<< 
              //<< //Formatting data...
              //<< if ( (ADescResumida '= DDescResumida) && (acao '= "Criado") ) {
              if (mOp.Logical(((mOp.NotEqual(ADescResumida.get(),DDescResumida.get())) && (mOp.NotEqual(acao.get(),"Criado"))))) {
                //<< set DDescResumida = formatPre_DDescResumida_formatPos
                DDescResumida.set(mOp.Concat(mOp.Concat(formatPre.get(),DDescResumida.get()),formatPos.get()));
              }
              //<< }
              //<< 
              //<< if ( (ADescCompleta '= DDescCompleta) && (acao '= "Criado") ) {
              if (mOp.Logical(((mOp.NotEqual(ADescCompleta.get(),DDescCompleta.get())) && (mOp.NotEqual(acao.get(),"Criado"))))) {
                //<< set DDescCompleta = formatPre_DDescCompleta_formatPos
                DDescCompleta.set(mOp.Concat(mOp.Concat(formatPre.get(),DDescCompleta.get()),formatPos.get()));
              }
              //<< }
              //<< 
              //<< if ( (AGrupo '= DGrupo) && (acao '= "Criado") ) {
              if (mOp.Logical(((mOp.NotEqual(AGrupo.get(),DGrupo.get())) && (mOp.NotEqual(acao.get(),"Criado"))))) {
                //<< set DGrupo = formatPre_DGrupo_formatPos
                DGrupo.set(mOp.Concat(mOp.Concat(formatPre.get(),DGrupo.get()),formatPos.get()));
              }
              //<< }
              //<< 
              //<< if ( (AUnidade '= DUnidade) && (acao '= "Criado") ) {
              if (mOp.Logical(((mOp.NotEqual(AUnidade.get(),DUnidade.get())) && (mOp.NotEqual(acao.get(),"Criado"))))) {
                //<< set DUnidade = formatPre_$$SQLGetSiglaUnit^VARSQL(DUnidade)_formatPos
                DUnidade.set(mOp.Concat(mOp.Concat(formatPre.get(),m$.fnc$("VARSQL.SQLGetSiglaUnit",DUnidade.get())),formatPos.get()));
              }
              //<< } else {
              else {
                //<< set DUnidade = $$SQLGetSiglaUnit^VARSQL(DUnidade)
                DUnidade.set(m$.fnc$("VARSQL.SQLGetSiglaUnit",DUnidade.get()));
              }
              //<< }
              //<< 
              //<< if ( (AStatus '= DStatus) && (acao '= "Criado") ) {
              if (mOp.Logical(((mOp.NotEqual(AStatus.get(),DStatus.get())) && (mOp.NotEqual(acao.get(),"Criado"))))) {
                //<< set DStatus = formatPre_$piece($get(^INItemStatus(YM,DStatus,1)),Y,1)_formatPos
                DStatus.set(mOp.Concat(mOp.Concat(formatPre.get(),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INItemStatus",m$.var("YM").get(),DStatus.get(),1)),m$.var("Y").get(),1)),formatPos.get()));
              }
              //<< } else {
              else {
                //<< set DStatus = $piece($get(^INItemStatus(YM,DStatus,1)),Y,1)
                DStatus.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INItemStatus",m$.var("YM").get(),DStatus.get(),1)),m$.var("Y").get(),1));
              }
              //<< }
              //<< 
              //<< if ( (ACurvaABC '= DCurvaABC) && (acao '= "Criado") ) {
              if (mOp.Logical(((mOp.NotEqual(ACurvaABC.get(),DCurvaABC.get())) && (mOp.NotEqual(acao.get(),"Criado"))))) {
                //<< set DCurvaABC = formatPre_DCurvaABC_formatPos
                DCurvaABC.set(mOp.Concat(mOp.Concat(formatPre.get(),DCurvaABC.get()),formatPos.get()));
              }
              //<< }
              //<< 
              //<< if ( (AClassXYZ '= DClassXYZ) && (acao '= "Criado") ) {
              if (mOp.Logical(((mOp.NotEqual(AClassXYZ.get(),DClassXYZ.get())) && (mOp.NotEqual(acao.get(),"Criado"))))) {
                //<< set DClassXYZ = formatPre_DClassXYZ_formatPos
                DClassXYZ.set(mOp.Concat(mOp.Concat(formatPre.get(),DClassXYZ.get()),formatPos.get()));
              }
              //<< }
              //<< 
              //<< if ( (APadrao '= DPadrao) && (acao '= "Criado") ) {
              if (mOp.Logical(((mOp.NotEqual(APadrao.get(),DPadrao.get())) && (mOp.NotEqual(acao.get(),"Criado"))))) {
                //<< set DPadrao = formatPre_$$SQLGetYesOrNo^VARSQL(DPadrao)_formatPos
                DPadrao.set(mOp.Concat(mOp.Concat(formatPre.get(),m$.fnc$("VARSQL.SQLGetYesOrNo",DPadrao.get())),formatPos.get()));
              }
              //<< } else {
              else {
                //<< set DPadrao = $$SQLGetYesOrNo^VARSQL(DPadrao)
                DPadrao.set(m$.fnc$("VARSQL.SQLGetYesOrNo",DPadrao.get()));
              }
              //<< }
              //<< 
              //<< set count = $i(count)
              count.set(m$.Fnc.$increment(count));
              //<< 
              //<< do NewLine^COMTable()
              m$.Cmd.Do("COMTable.NewLine");
              //<< do InsertCell^COMTable(count)
              m$.Cmd.Do("COMTable.InsertCell",count.get());
              //<< do InsertCell^COMTable(acao)
              m$.Cmd.Do("COMTable.InsertCell",acao.get());
              //<< do InsertCell^COMTable($zdate(date,4))
              m$.Cmd.Do("COMTable.InsertCell",m$.Fnc.$zdate(date.get(),4));
              //<< do InsertCell^COMTable($ztime(hour))
              m$.Cmd.Do("COMTable.InsertCell",m$.Fnc.$ztime(hour.get()));
              //<< do InsertCell^COMTable(idUsuario)
              m$.Cmd.Do("COMTable.InsertCell",idUsuario.get());
              //<< do InsertCell^COMTable(DDescResumida,,,,,,,,,$$$YES)
              m$.Cmd.Do("COMTable.InsertCell",DDescResumida.get(),null,null,null,null,null,null,null,null,include.COMSYS.$$$YES(m$));
              //<< do InsertCell^COMTable(DDescCompleta,,,,,,,,,$$$YES)
              m$.Cmd.Do("COMTable.InsertCell",DDescCompleta.get(),null,null,null,null,null,null,null,null,include.COMSYS.$$$YES(m$));
              //<< do InsertCell^COMTable(DUnidade)
              m$.Cmd.Do("COMTable.InsertCell",DUnidade.get());
              //<< do InsertCell^COMTable(DGrupo)
              m$.Cmd.Do("COMTable.InsertCell",DGrupo.get());
              //<< do InsertCell^COMTable(DStatus,,,,,,,,,$$$YES)
              m$.Cmd.Do("COMTable.InsertCell",DStatus.get(),null,null,null,null,null,null,null,null,include.COMSYS.$$$YES(m$));
              //<< do InsertCell^COMTable(DPadrao)
              m$.Cmd.Do("COMTable.InsertCell",DPadrao.get());
              //<< do InsertCell^COMTable(DCurvaABC)
              m$.Cmd.Do("COMTable.InsertCell",DCurvaABC.get());
              //<< do InsertCell^COMTable(DClassXYZ)
              m$.Cmd.Do("COMTable.InsertCell",DClassXYZ.get());
              //<< do EndLine^COMTable()
              m$.Cmd.Do("COMTable.EndLine");
              //<< set lastDateChange=date
              lastDateChange.set(date.get());
              //<< set lastTimeChange=hour
              lastTimeChange.set(hour.get());
              //<< set lastUserChange=idUsuario
              lastUserChange.set(idUsuario.get());
            }
          }
        }
      }
    }
    //<< $$$End
    //<< $$$End
    //<< $$$End
    //<< $$$End
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< OnAfterSaveHook(YKEY,YFELD)
  public Object OnAfterSaveHook(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< job LoadINARTLOCPAR^VARINART(YKEY)
    m$.Cmd.Job("VARINART.LoadINARTLOCPAR",YKEY.get());
    //<< 
    //<< if ($$$INARTAverageCost(YFELD) '= $$$INARTAverageCost(YFELDOLD)) {
    if ((mOp.NotEqual(include.INConst.$$$INARTAverageCost(m$,YFELD),include.INConst.$$$INARTAverageCost(m$,m$.var("YFELDOLD"))))) {
      //<< new objINARTT, idINARTT1, idINARTT2
      mVar objINARTT = m$.var("objINARTT");
      mVar idINARTT1 = m$.var("idINARTT1");
      mVar idINARTT2 = m$.var("idINARTT2");
      m$.newVar(objINARTT,idINARTT1,idINARTT2);
      //<< set idINARTT1 = ""
      idINARTT1.set("");
      //<< for {
      for (;true;) {
        //<< set idINARTT1 = $order(^INARTTs(0,1,YKEY,idINARTT1))
        idINARTT1.set(m$.Fnc.$order(m$.var("^INARTTs",0,1,YKEY.get(),idINARTT1.get())));
        //<< if (idINARTT1 = "") quit
        if ((mOp.Equal(idINARTT1.get(),""))) {
          break;
        }
        //<< set idINARTT2 = ""
        idINARTT2.set("");
        //<< for {
        for (;true;) {
          //<< set idINARTT2 = $order(^INARTT(0,idINARTT1,idINARTT2))
          idINARTT2.set(m$.Fnc.$order(m$.var("^INARTT",0,idINARTT1.get(),idINARTT2.get())));
          //<< if (idINARTT2 = "") quit
          if ((mOp.Equal(idINARTT2.get(),""))) {
            break;
          }
          //<< set objINARTT = ^INARTT(0,idINARTT1,idINARTT2,1)
          objINARTT.set(m$.var("^INARTT",0,idINARTT1.get(),idINARTT2.get(),1).get());
          //<< if ($$$INARTTItemNumber1(objINARTT) = YKEY) {
          if ((mOp.Equal(include.INConst.$$$INARTTItemNumber1(m$,objINARTT),YKEY.get()))) {
            //<< set $$$INARTTValue1(objINARTT) = $$$INARTAverageCost(YFELD) * $$$INARTTQuantity(objINARTT)
            include.INConst.$$$INARTTValue1Set(m$,objINARTT,mOp.Multiply(include.INConst.$$$INARTAverageCost(m$,YFELD),include.INConst.$$$INARTTQuantity(m$,objINARTT)));
            //<< set strStatus = $$$Save("INARTT",idINARTT1_$$$COMMA_idINARTT2,objINARTT,$$$YES)
            mVar strStatus = m$.var("strStatus");
            strStatus.set(include.COMSYS.$$$Save(m$,"INARTT",mOp.Concat(mOp.Concat(idINARTT1.get(),include.COMSYSString.$$$COMMA(m$)),idINARTT2.get()),objINARTT,include.COMSYS.$$$YES(m$)));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< LoadINARTLOCPAR(Product)
  public Object LoadINARTLOCPAR(Object ... _p) {
    mVar Product = m$.newVarRef("Product",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< set Location=""
    mVar Location = m$.var("Location");
    Location.set("");
    //<< set Location=$order(^WWW0121(YM,YM,Location))
    Location.set(m$.Fnc.$order(m$.var("^WWW0121",m$.var("YM").get(),m$.var("YM").get(),Location.get())));
    //<< while Location'="" {
    while (mOp.NotEqual(Location.get(),"")) {
      //<< set objLocation=""
      mVar objLocation = m$.var("objLocation");
      objLocation.set("");
      //<< set objLocation=$get(^WWW0121(YM,YM,Location,1))
      objLocation.set(m$.Fnc.$get(m$.var("^WWW0121",m$.var("YM").get(),m$.var("YM").get(),Location.get(),1)));
      //<< // Consumo automático para o local
      //<< if $$$WWW0121FREE8(objLocation)=1 {
      if (mOp.Equal(include.WWWConst.$$$WWW0121FREE8(m$,objLocation),1)) {
        //<< set objPar=""
        mVar objPar = m$.var("objPar");
        objPar.set("");
        //<< set objPar=$get(^INARTLOCPAR(YM,Product,Location,1))
        objPar.set(m$.Fnc.$get(m$.var("^INARTLOCPAR",m$.var("YM").get(),Product.get(),Location.get(),1)));
        //<< set $piece(objPar,Y,1)=1
        m$.pieceVar(objPar,m$.var("Y").get(),1).set(1);
        //<< set key=Product_","_Location
        mVar key = m$.var("key");
        key.set(mOp.Concat(mOp.Concat(Product.get(),","),Location.get()));
        //<< set strStatus=$$Save^COMUtils("INARTLOCPAR",key,objPar,1)
        mVar strStatus = m$.var("strStatus");
        strStatus.set(m$.fnc$("COMUtils.Save","INARTLOCPAR",key.get(),objPar.get(),1));
        //<< if strStatus'=1 {
        if (mOp.NotEqual(strStatus.get(),1)) {
        }
      }
      //<< //set errorstring="Erro ao salvar INARTLOCPAR "_key_" . Erro->"_strStatus
      //<< //$$$Alert(errorstring)
      //<< }
      //<< }
      //<< set Location=$order(^WWW0121(YM,YM,Location))
      Location.set(m$.Fnc.$order(m$.var("^WWW0121",m$.var("YM").get(),m$.var("YM").get(),Location.get())));
    }
    //<< }
    //<< quit
    return null;
  }

//<< 
}
