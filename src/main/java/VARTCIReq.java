//*****************************************************************************
//** TASC - ALPHALINC - MAC VARTCIReq
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-03 15:19:33
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
//<< #include %occInclude
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;

//<< VARTCIReq
public class VARTCIReq extends mClass {

  public void main() {
    _VARTCIReq();
  }

  public void _VARTCIReq() {
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< CanConfirm(pYKEY)
  public Object CanConfirm(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pYKEY = "")
    if ((mOp.Equal(pYKEY.get(),""))) {
      return null;
    }
    //<< 
    //<< new isConfirmed
    mVar isConfirmed = m$.var("isConfirmed");
    m$.newVar(isConfirmed);
    //<< set isConfirmed = $piece($get(^INReq(YM,pYKEY,1)),Y,19)
    isConfirmed.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INReq",m$.var("YM").get(),pYKEY.get(),1)),m$.var("Y").get(),19));
    //<< 
    //<< if (isConfirmed = 1) {
    if ((mOp.Equal(isConfirmed.get(),1))) {
      //<< set YQ = $$$YQDisable("Esta requisição já está confirmada.")
      mVar YQ = m$.var("YQ");
      YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"Esta requisição já está confirmada."));
    }
    //<< } elseif ($order(^INReqLine(YM,pYKEY,"")) = "") {
    else if ((mOp.Equal(m$.Fnc.$order(m$.var("^INReqLine",m$.var("YM").get(),pYKEY.get(),"")),""))) {
      //<< set YQ = $$$YQDisable("Não existem produtos na requisição.")
      mVar YQ = m$.var("YQ");
      YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"Não existem produtos na requisição."));
    }
    //<< } else {
    else {
      //<< set YQ = $$$YQEnable
      mVar YQ = m$.var("YQ");
      YQ.set(include.COMSYSWWW.$$$YQEnable(m$));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< Confirm(pYKEY)
  public Object Confirm(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pYKEY = "")
    if ((mOp.Equal(pYKEY.get(),""))) {
      return null;
    }
    //<< 
    //<< new strStatus, objReq
    mVar strStatus = m$.var("strStatus");
    mVar objReq = m$.var("objReq");
    m$.newVar(strStatus,objReq);
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set objReq = $get(^INReq(YM,pYKEY,1))
    objReq.set(m$.Fnc.$get(m$.var("^INReq",m$.var("YM").get(),pYKEY.get(),1)));
    //<< 
    //<< if $piece(objReq,Y,19) = "" {
    if (mOp.Equal(m$.Fnc.$piece(objReq.get(),m$.var("Y").get(),19),"")) {
      //<< set $piece(objReq,Y,19) = 1
      m$.pieceVar(objReq,m$.var("Y").get(),19).set(1);
      //<< set strStatus = $$$Save("INReq",pYKEY,objReq,1)
      strStatus.set(include.COMSYS.$$$Save(m$,"INReq",pYKEY,objReq,1));
      //<< if $$$ISERR(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        //<< $$$StartScript()
        include.COMSYS.$$$StartScript(m$);
        //<< w "alert('Não foi possível confirmar a requisição. Favor verificar.');"
        m$.Cmd.Write("alert('Não foi possível confirmar a requisição. Favor verificar.');");
        //<< $$$EndScript()
        include.COMSYS.$$$EndScript(m$);
      }
      //<< }
      //<< do GoToForm^COMUtilForm("INReq",pYKEY)
      m$.Cmd.Do("COMUtilForm.GoToForm","INReq",pYKEY.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CheckReadOnly()
  public Object CheckReadOnly() {
    //<< if ($piece($get(^WWW013(YM,YBED,1)),Y,3) = 211) quit $$$YES  //Perfil 211 = ME-REQUISITANTE
    if ((mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",m$.var("YM").get(),m$.var("YBED").get(),1)),m$.var("Y").get(),3),211))) {
      return include.COMSYS.$$$YES(m$);
    }
    //<< quit $$$NO
    return include.COMSYS.$$$NO(m$);
  }

  //<< 
  //<< QtyReadOnly(pYKEY)
  public Object QtyReadOnly(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< if ($piece($get(^INReq(YM,$$$KEY1(pYKEY),1)),Y,19) = 1) quit $$$YES  //Campo 19 = QTDE REQUISITADA
    if ((mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INReq",m$.var("YM").get(),include.COMSYSWWW.$$$KEY1(m$,pYKEY),1)),m$.var("Y").get(),19),1))) {
      return include.COMSYS.$$$YES(m$);
    }
    //<< quit $$$NO
    return include.COMSYS.$$$NO(m$);
  }

  //<< 
  //<< OnBlurVARQtyRequired(GROW,YINHALT,YFELD)
  public Object OnBlurVARQtyRequired(Object ... _p) {
    mVar GROW = m$.newVarRef("GROW",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------
    //<< ;19-Jul-2010    Karine  SESAU-81:Alterado para pegar o novo parâmetro de cliente
    //<< ;-------------------------------------------------------------------------
    //<< 
    //<< new isValidating
    mVar isValidating = m$.var("isValidating");
    m$.newVar(isValidating);
    //<< set isValidating = $$$NO
    isValidating.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if (YINHALT '= $$$NULLOREF) {
    if ((mOp.NotEqual(YINHALT.get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< 
      //<< set isValidating = $$getValidaQtdReq^VARParametroCliente(YM)
      isValidating.set(m$.fnc$("VARParametroCliente.getValidaQtdReq",m$.var("YM").get()));
      //<< 
      //<< if ((isValidating = $$$OK) || (isValidating = "")) {
      if (mOp.Logical(((mOp.Equal(isValidating.get(),include.COMSYS.$$$OK(m$))) || (mOp.Equal(isValidating.get(),""))))) {
        //<< 
        //<< ;Verifica se tem estoque para o Item,Local
        //<< new idRequisition, objRequisition, idLocation
        mVar idRequisition = m$.var("idRequisition");
        mVar objRequisition = m$.var("objRequisition");
        mVar idLocation = m$.var("idLocation");
        m$.newVar(idRequisition,objRequisition,idLocation);
        //<< set idRequisition  = $$$KEY1(YKEY)
        idRequisition.set(include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEY")));
        //<< set objRequisition = $get(^INReq(YM,idRequisition,1))
        objRequisition.set(m$.Fnc.$get(m$.var("^INReq",m$.var("YM").get(),idRequisition.get(),1)));
        //<< set idLocation     = $$$INReqFromLocn(objRequisition)
        idLocation.set(include.INConst.$$$INReqFromLocn(m$,objRequisition));
        //<< 
        //<< new vItem
        mVar vItem = m$.var("vItem");
        m$.newVar(vItem);
        //<< set vItem = $piece(YFELD,Y,1)
        vItem.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),1));
        //<< if vItem '= "" {
        if (mOp.NotEqual(vItem.get(),"")) {
          //<< if $$GetSOHItem(vItem,idLocation) < YINHALT {
          if (mOp.Less(m$.fnc$("GetSOHItem",vItem.get(),idLocation.get()),YINHALT.get())) {
            //<< set strMessage = "Não há estoque suficiente do produto "_vItem_" no local "_idLocation_"."
            mVar strMessage = m$.var("strMessage");
            strMessage.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Não há estoque suficiente do produto ",vItem.get())," no local "),idLocation.get()),"."));
            //<< &js<
            //<< alert("<%=strMessage%>");
            //<< >
            m$.Cmd.WriteJS("","\n");
            m$.Cmd.WriteJS("                        alert(\"<%=strMessage%>\");","\n");
            m$.Cmd.WriteJS("                    ");
            //<< ;Limpa o campo Produto
            //<< //set $piece(YFELD,Y,1)  = ""
            //<< ;Limpa o campo Qtde Solicitada
            //<< set $piece(YFELD,Y,21) = ""
            m$.pieceVar(YFELD,m$.var("Y").get(),21).set("");
            //<< ;set YFELD = ""
            //<< 
            //<< quit
            return null;
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< ;setando o campo qty ordered
      //<< do OnBlurQtyRequisitada(GROW,YINHALT,YFELD)
      m$.Cmd.Do("OnBlurQtyRequisitada",GROW.get(),YINHALT.get(),YFELD.get());
      //<< 
      //<< ;Setando o campo qty required
      //<< do OnBlurQtyOrdered^INReqLine(GROW,YINHALT,.YFELD)
      m$.Cmd.Do("INReqLine.OnBlurQtyOrdered",GROW.get(),YINHALT.get(),YFELD);
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< OnBlurQtyRequisitada(pintGridRow,pstrFieldValue,&pstrFieldData)
  public Object OnBlurQtyRequisitada(Object ... _p) {
    mVar pintGridRow = m$.newVarRef("pintGridRow",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrFieldValue = m$.newVarRef("pstrFieldValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrFieldData = m$.newVarRef("pstrFieldData",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< new fltQuantity,idItem,idUnit
    mVar fltQuantity = m$.var("fltQuantity");
    mVar idItem = m$.var("idItem");
    mVar idUnit = m$.var("idUnit");
    m$.newVar(fltQuantity,idItem,idUnit);
    //<< do UpdateManualField^COMGridEdit31Interface(pintGridRow,8,pstrFieldValue)
    m$.Cmd.Do("COMGridEdit31Interface.UpdateManualField",pintGridRow.get(),8,pstrFieldValue.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetSOHItem(pItem="",pLocation="")
  public Object GetSOHItem(Object ... _p) {
    mVar pItem = m$.newVarRef("pItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pLocation = m$.newVarRef("pLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;$$GetSOHItem^VARTCIReq(Item,Location)
    //<< 
    //<< new StockOnHand
    mVar StockOnHand = m$.var("StockOnHand");
    m$.newVar(StockOnHand);
    //<< set StockOnHand = 0
    StockOnHand.set(0);
    //<< 
    //<< if pItem '= "" {
    if (mOp.NotEqual(pItem.get(),"")) {
      //<< 
      //<< &sql(SELECT nvl( sum(alSOH.dBundleStock.QtyOnHand),0)
      //<< INTO :StockOnHand
      //<< FROM alSOH.dBundleStock
      //<< WHERE item = :pItem
      //<< AND (Storage->Location = :pLocation)
      //<< AND ((Storage->StorageIsBlocked = 0) OR (Storage->StorageIsBlocked is null))
      //<< 
      //<< )
      m$.Cmd.SQL();
      //<< 
      //<< if (SQLCODE '= 0) {
      if ((mOp.NotEqual(m$.var("SQLCODE").get(),0))) {
        //<< quit 0
        return 0;
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit StockOnHand
    return StockOnHand.get();
  }

  //<< 
  //<< 
  //<< GetQtyBlockedItem(pItem="",pLocation="")
  public Object GetQtyBlockedItem(Object ... _p) {
    mVar pItem = m$.newVarRef("pItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pLocation = m$.newVarRef("pLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;$$GetQtyBlockedItem^VARTCIReq(Item,Location)
    //<< 
    //<< new QtyBlocked
    mVar QtyBlocked = m$.var("QtyBlocked");
    m$.newVar(QtyBlocked);
    //<< set QtyBlocked = 0
    QtyBlocked.set(0);
    //<< 
    //<< if pItem '= "" {
    if (mOp.NotEqual(pItem.get(),"")) {
      //<< 
      //<< &sql(SELECT nvl( sum(alSOH.dBundleStock.QtyOnHand),0)
      //<< INTO :QtyBlocked
      //<< FROM alSOH.dBundleStock
      //<< WHERE item = :pItem
      //<< AND (Storage->Location = :pLocation)
      //<< AND ( (Storage->StorageIsBlocked = 1) OR (Storage->Physical->StorageIsBlocked = 1) )
      //<< )
      m$.Cmd.SQL();
      //<< 
      //<< if (SQLCODE '= 0) {
      if ((mOp.NotEqual(m$.var("SQLCODE").get(),0))) {
        //<< quit 0
        return 0;
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit QtyBlocked
    return QtyBlocked.get();
  }

  //<< 
  //<< 
  //<< 
  //<< 
  //<< OnFilterHook(pYKEY,pFORM,pintTypeOfTest=1)
  public Object OnFilterHook(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pFORM = m$.newVarRef("pFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintTypeOfTest = m$.newVarRef("pintTypeOfTest",(((_p!=null)&&(_p.length>=3))?_p[2]:null),1);
    //<< ;$$OnFilterHook^VARTCIReq(.YKEY,YFORM,1)
    //<< ;
    //<< ;19/05/2011 SLV     Adicionada nova regra de locais de aprovação e limpeza
    //<< ;10/05/2011 SLV     Retirada a verificação de perfis
    //<< ;05/10/2009 Petik   Filtra para que o usuário consulte apenas as requisições de seu Local.
    //<< 
    //<< new blnFilter, perfilUsuario, strLocaisApr, lstLocaisApr, objRequisicao, idLocalDestino,
    //<< idLocalOrigem, idLocalUsuario
    mVar blnFilter = m$.var("blnFilter");
    mVar perfilUsuario = m$.var("perfilUsuario");
    mVar strLocaisApr = m$.var("strLocaisApr");
    mVar lstLocaisApr = m$.var("lstLocaisApr");
    mVar objRequisicao = m$.var("objRequisicao");
    mVar idLocalDestino = m$.var("idLocalDestino");
    mVar idLocalOrigem = m$.var("idLocalOrigem");
    mVar idLocalUsuario = m$.var("idLocalUsuario");
    m$.newVar(blnFilter,perfilUsuario,strLocaisApr,lstLocaisApr,objRequisicao,idLocalDestino,idLocalOrigem,idLocalUsuario);
    //<< 
    //<< set blnFilter      = $$$NO
    blnFilter.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set perfilUsuario  = $piece($get(^WWW013(YM,YBED,1)),Y,3)
    perfilUsuario.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",m$.var("YM").get(),m$.var("YBED").get(),1)),m$.var("Y").get(),3));
    //<< quit:(perfilUsuario= 1) $$$YES //Filtro não aplicado aos usuários Administradores.
    if ((mOp.Equal(perfilUsuario.get(),1))) {
      return include.COMSYS.$$$YES(m$);
    }
    //<< 
    //<< if pFORM ="" set pForm  = $get(YFORM)
    if (mOp.Equal(pFORM.get(),"")) {
      mVar pForm = m$.var("pForm");
      pForm.set(m$.Fnc.$get(m$.var("YFORM")));
    }
    //<< 
    //<< set strLocaisApr   = $piece($get(^VARParametroCliente(0,YM,1)),Y,12) //Locais de aprovação
    strLocaisApr.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARParametroCliente",0,m$.var("YM").get(),1)),m$.var("Y").get(),12));
    //<< set lstLocaisApr   = $listfromstring(strLocaisApr,";") // Converte a string de locais em uma lista
    lstLocaisApr.set(m$.Fnc.$listfromstring(strLocaisApr.get(),";"));
    //<< 
    //<< set objRequisicao  = $get(^INReq(YM,pYKEY,1))
    objRequisicao.set(m$.Fnc.$get(m$.var("^INReq",m$.var("YM").get(),pYKEY.get(),1)));
    //<< set idLocalDestino = $piece(objRequisicao,Y,3)
    idLocalDestino.set(m$.Fnc.$piece(objRequisicao.get(),m$.var("Y").get(),3));
    //<< set idLocalOrigem  = $piece(objRequisicao,Y,4)
    idLocalOrigem.set(m$.Fnc.$piece(objRequisicao.get(),m$.var("Y").get(),4));
    //<< set idLocalUsuario = YLOCATION
    idLocalUsuario.set(m$.var("YLOCATION").get());
    //<< 
    //<< //Somente visualizando as requisições do mesmo local do usuário se
    //<< // o mesmo não estiver cadastrado em um dos locais de aprovação.
    //<< if (pintTypeOfTest = 1) {
    if ((mOp.Equal(pintTypeOfTest.get(),1))) {
      //<< 
      //<< if ((strLocaisApr '= "") && ($listfind(lstLocaisApr,idLocalUsuario)) || (strLocaisApr = "") ||
      //<< (idLocalDestino = idLocalUsuario)) {
      if (mOp.Logical(((mOp.NotEqual(strLocaisApr.get(),"")) && mOp.Logical((m$.Fnc.$listfind(lstLocaisApr.get(),idLocalUsuario.get()))) || (mOp.Equal(strLocaisApr.get(),"")) || (mOp.Equal(idLocalDestino.get(),idLocalUsuario.get()))))) {
        //<< set blnFilter = $$$YES
        blnFilter.set(include.COMSYS.$$$YES(m$));
      }
      //<< }
      //<< else {
      else {
        //<< set YKEY = ""
        mVar YKEY = m$.var("YKEY");
        YKEY.set("");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit blnFilter
    return blnFilter.get();
  }

  //<< 
  //<< ShowItems(pidEvent,pidParameters)
  public Object ShowItems(Object ... _p) {
    mVar pidEvent = m$.newVarRef("pidEvent",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidParameters = m$.newVarRef("pidParameters",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< // DESCONTINUADO
  //<< // 27-Jan-2011  Karine: As alterações foram feitas diretamente no código core:ShowItems^INReqTable
  //<< // Upgrade 1.66         Isso por causa da chamada no metadado: ^WWW120DynTable(0,"INReq",1,1)="3~~1~ShowItems^INReqTable~~~INReqLine~1~1~1~"
  //<< //                      Esse metadado do form INReq, imposibilita o rastreamento pelo ASDE.
  //<< //                      Decisão sugerida e feita pelo Pablo. Adaptação de versão 1.66 feitas por mim.
  //<< /*
  //<< ;do ShowItems^VARTCIReq(1, "INReq"_$$$DELIM_"INReqLine"_$$$DELIM_1_$$$DELIM_1)
  //<< ;Petik 05/10/2009
  //<< ;Copiado do método CORE ShowItems^INReqTable
  //<< ;Gustavo 03/11/2009
  //<< ;Re-copiado e adaptado do método CORE ShowItems^INReqTable
  //<< ;Esse método está sendo chamado no método CORE OnBlurItem^INReqLine
  //<< ;e também é usado na Tabela Dinâmica da INReq abaixo
  //<< ;^WWW120DynTable(0,"INReq",1,1)="3~~1~ShowItems^INReqTable~~~INReqLine~1~1~1~"
  //<< ;
  //<< 
  //<< set blnIsRequisitante = $$CheckReadOnly^VARTCIReq()
  //<< quit:(blnIsRequisitante = 1)
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Description :
  //<< ;
  //<< ; Called By :
  //<< ;
  //<< ; Inputs :
  //<< ;
  //<< ; Params:
  //<< ;
  //<< ; Returns:
  //<< ;
  //<< ; History:
  //<< ; 10-Jul-2009   PPP     SR16688:If Kit Requisition do not show the Table
  //<< ; 29-Jun-2009   PPP     SR16688: Corrected usage, gets YFELDContainer instead or YMFELDContainer
  //<< ;                       Updated the return parameters with the ATP
  //<< ; 01-Jun-2009   PPP     SR16599: Add Row highlight & click functionality
  //<< ; 12-Mar-2009   HQN     SR16417: Don't assume YLOCATION is the ToLocn, explicitly
  //<< ;                           take from Header
  //<< ; 23-Nov-2007   PPP     SR15339: Creation
  //<< ;-------------------------------------------------------------------------------
  //<< new arrLocations,blnHide,dteDate,fltATP,fltBOH,fltQty
  //<< new idCurLoc,idGrid,idItem,idKey,idLine,idLocn,idToLocn,idRequisition,idxItem,lstColTypes,lstHeaders
  //<< new objLine,objLocn,objRequisition,strStatus,strFunction
  //<< 
  //<< set blnHide = +$$$WWW012HideRelationClassIDs($get(^WWW012(0,YM,1)))
  //<< set idGrid  =  $$$DYNTABLEGridLineFocusGrid(pidParameters)            // SR15339
  //<< 
  //<< set lstHeaders=""
  //<< set lstColTypes=""
  //<< 
  //<< //kill ^CacheTempDynamicTable(YUCI,YUSER,1)     //SR16599
  //<< kill ^CacheTempDynamicTable(YUCI,YUSER)     //SR16599
  //<< 
  //<< set idKey         = $$ReferenceKey^COMGridEdit31Interface(idGrid,$$$DYNTABLEGridLineFocusRow(pidParameters)) // SR15339
  //<< set idRequisition = $$$KEY1(idKey)
  //<< set idLine        = $$$KEY2(idKey)
  //<< 
  //<< if '$$Editable^INReq(idRequisition) quit
  //<< //if '$$Editable^INReqKit()         quit                    ; *** EARLY EXIT ***
  //<< 
  //<< set objRequisition = $$GetYFELDContainer^COMGridEdit31G()   //SR16688
  //<< set objLine        = $$$GRIDGetYFELD(idLine)
  //<< if $$$INReqType(objRequisition)=4   quit                     ; *** EARLY EXIT ***   //SR16688
  //<< 
  //<< set strStatus      = $$GetLock^WWWMultiLock("INReq",idGrid,idRequisition_$$$COMMA_idLine,$$$NO)      // SR15339
  //<< 
  //<< set strFunction = "FillLine"
  //<< 
  //<< set idToLocn = $$$INReqToLocn(objRequisition)               ; SR16417
  //<< set idItem   = $$$INReqLineItem(objLine)
  //<< set idxItem  = $$$Index(idItem)
  //<< set fltQty   = $$$INReqLineQtyRequired(objLine)
  //<< set idCurLoc = $$$INReqLineFromStockLocn(objLine)
  //<< set dteDate  = $$$INReqLineDueDate(objLine)        if dteDate = "" set dteDate = +$horolog
  //<< 
  //<< set idFromLocn = $$$INReqFromLocn(objRequisition)
  //<< 
  //<< set QtdeRequisitada = $$$INReqLineFREE10(objLine)
  //<< 
  //<< ;Petik 26/08/2010
  //<< ;Essas variáveis precisam receber 0 (zero) para quando não existir estoque
  //<< ;imprimir uma linha em branco (zerada).
  //<< ;Também movi essas linhas para dentro do for, pois quando existia mais de um local
  //<< ;de estoque com o mesmo produto as quantidades estavam aparecendo iguais em todas as linhas.
  //<< ;vvvvv
  //<< ;set QtdeDisponivel  = $$GetSOHItem^VARTCIReq(idItem,idFromLocn)
  //<< ;set QtdeBloqueada   = $$GetQtyBlockedItem^VARTCIReq(idItem,idFromLocn)
  //<< ;set QtdeTotal       = QtdeDisponivel + QtdeBloqueada
  //<< 
  //<< set QtdeDisponivel  = 0
  //<< set QtdeBloqueada   = 0
  //<< set QtdeTotal       = 0
  //<< 
  //<< 
  //<< if $$$ISERR(strStatus) {
  //<< write "function "_strFunction_"() {"
  //<< write "alert('"_$$$JSText($$$Text(strStatus))_"');"
  //<< write "}"
  //<< } else {
  //<< write "function "_strFunction_"() {"
  //<< write "CallBack(""WarehouseLine^INReqTable"", getRowNum(getFocusField()), this.DiscData[0]);"
  //<< write "}"
  //<< }
  //<< 
  //<< ;set lstHeaders  = $listbuild($$^WWWFELDNAME("INReqLine","D",$$$FldINReqLineFromStockLocn),
  //<< ;                            $$^WWWTEXT("IN00694"),                            ;BOH   (Balance On Hand)
  //<< ;                            $$^WWWTEXT(32483))
  //<< 
  //<< set lstHeaders  = $listbuild($$^WWWFELDNAME("INReqLine","D",$$$FldINReqLineFromStockLocn),
  //<< "Quant. Requisitada",
  //<< "Quant. Disponível",
  //<< "Quant. Bloq.",
  //<< "Quant. Total")
  //<< 
  //<< 
  //<< //set lstColTypes = $listbuild($listbuild("left","link"),
  //<< //                           $listbuild("right","link"),
  //<< //                           $listbuild("right","link"))
  //<< 
  //<< ;set lstColTypes = $listbuild($listbuild("left","display"),
  //<< ;                            $listbuild("right","display"),
  //<< ;                            $listbuild("right","display"))
  //<< 
  //<< set lstColTypes = $listbuild($listbuild("left","link"),
  //<< $listbuild("right","link"),
  //<< $listbuild("right","link"),
  //<< $listbuild("right","link"),
  //<< $listbuild("right","link"))
  //<< 
  //<< 
  //<< do GetWarehouseLocations^INReqTable(.arrLocations,idItem,dteDate,fltQty)
  //<< set idLocn=""
  //<< 
  //<< set Passou = $$$NO
  //<< 
  //<< for {
  //<< set idLocn=$order(arrLocations(idLocn))
  //<< quit:idLocn=""
  //<< 
  //<< set Passou = $$$YES
  //<< 
  //<< continue:idLocn=idToLocn ; SR16417
  //<< 
  //<< ;Petik 26/08/2010
  //<< ;Adicionadas essas linhas dentro do for
  //<< ;Pois quando existia mais de um local de estoque com o mesmo produto
  //<< ;As quantidades estavam aparecendo iguais em todas as linhas.
  //<< ;vvvvvvvvvv
  //<< set QtdeDisponivel  = $$GetSOHItem^VARTCIReq(idItem,idLocn)
  //<< set QtdeBloqueada   = $$GetQtyBlockedItem^VARTCIReq(idItem,idLocn)
  //<< set QtdeTotal       = QtdeDisponivel + QtdeBloqueada
  //<< 
  //<< set fltBOH = $piece(arrLocations(idLocn),Y,1)
  //<< set fltATP = $piece(arrLocations(idLocn),Y,2)
  //<< set ^CacheTempDynamicTable(YUCI,YUSER,1,$increment(idLine),"data") = idLocn_Y_fltATP        //SR16688
  //<< set objLocn = $get(^WWW0121(0,YM,idLocn,1))
  //<< ;set ^CacheTempDynamicTable(YUCI,YUSER,1,idLine) = $select(blnHide:"",1:"("_idLocn_") ")_$$$WWW0121LocationName(objLocn)_Y_
  //<< ;                                                 fltBOH_Y_
  //<< ;                                                 fltATP
  //<< 
  //<< set ^CacheTempDynamicTable(YUCI,YUSER,1,idLine) = $select(blnHide:"",1:"("_idLocn_") ")_$$$WWW0121LocationName(objLocn)_Y_
  //<< QtdeRequisitada_Y_
  //<< QtdeDisponivel_Y_
  //<< QtdeBloqueada_Y_
  //<< QtdeTotal
  //<< }
  //<< 
  //<< ;Desenha uma linha com qtdes zeradas se não entrou no for acima
  //<< if (idLocn="") && (Passou=$$$NO) {
  //<< set Local = idFromLocn
  //<< set objLocn = $get(^WWW0121(0,YM,Local,1))
  //<< set ^CacheTempDynamicTable(YUCI,YUSER,1,$increment(idLine),"data") = Local
  //<< set ^CacheTempDynamicTable(YUCI,YUSER,1,idLine) = $select(blnHide:"",1:"("_Local_") ")_
  //<< $$$WWW0121LocationName(objLocn)_Y_
  //<< QtdeRequisitada_Y_
  //<< QtdeDisponivel_Y_
  //<< QtdeBloqueada_Y_
  //<< QtdeTotal
  //<< 
  //<< }
  //<< 
  //<< //SR16599
  //<< //The last paramater (after pidEvent) needs to be set for the RowClick event, will be used by RowClick^WWW120DynTable
  //<< //  e.g. "WarehouseLine^INReqTable"
  //<< //  will be called with the following parameters
  //<< //  1. Row ID
  //<< //  2. Each entry in ^CacheTempDynamicTable(...,data) seperated by "~" will be a new parameter
  //<< //          in this routines case : do WarehouseLine^INReqTable(pidRow,idLocn) will be executed on Row click
  //<< do DrawTable^WWW120DynTable(lstHeaders,1,lstColTypes,pidParameters,strFunction,pidEvent,"WarehouseLine^INReqTable")
  //<< 
  //<< //kill ^CacheTempDynamicTable(YUCI,YUSER,1)
  //<< kill ^CacheTempDynamicTable(YUCI,YUSER)     //SR16599
  //<< 
  //<< quit
  //<< */
  //<< 
  //<< OldShowItems(pidEvent,pidParameters)
  public Object OldShowItems(Object ... _p) {
    mVar pidEvent = m$.newVarRef("pidEvent",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidParameters = m$.newVarRef("pidParameters",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;do ShowItems^VARTCIReq(1, "INReq"_$$$DELIM_"INReqLine"_$$$DELIM_1_$$$DELIM_1)
    //<< ;Petik 05/10/2009
    //<< ;Copiado do método CORE ShowItems^INReqTable
    //<< ;Esse método está sendo chamado no método CORE OnBlurItem^INReqLine
    //<< ;e também é usado na Tabela Dinâmica da INReq abaixo
    //<< ;^WWW120DynTable(0,"INReq",1,1)="3~~1~ShowItems^INReqTable~~~INReqLine~1~1~1~"
    //<< ;
    //<< 
    //<< set blnIsRequisitante = $$CheckReadOnly^VARTCIReq()
    mVar blnIsRequisitante = m$.var("blnIsRequisitante");
    blnIsRequisitante.set(m$.fnc$("VARTCIReq.CheckReadOnly"));
    //<< quit:(blnIsRequisitante = 1)
    if ((mOp.Equal(blnIsRequisitante.get(),1))) {
      return null;
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description :
    //<< ;
    //<< ; Called By :
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 12-Mar-2009   HQN     SR16417: Don't assume YLOCATION is the ToLocn, explicitly
    //<< ;                           take from Header
    //<< ; 23-Nov-2007   PPP     SR15339: Creation
    //<< ;-------------------------------------------------------------------------------
    //<< new arrLocations,blnHide,dteDate,fltATP,fltBOH,fltQty
    mVar arrLocations = m$.var("arrLocations");
    mVar blnHide = m$.var("blnHide");
    mVar dteDate = m$.var("dteDate");
    mVar fltATP = m$.var("fltATP");
    mVar fltBOH = m$.var("fltBOH");
    mVar fltQty = m$.var("fltQty");
    m$.newVar(arrLocations,blnHide,dteDate,fltATP,fltBOH,fltQty);
    //<< new idCurLoc,idGrid,idItem,idKey,idLine,idLocn,idToLocn,idRequisition,idxItem,lstColTypes,lstHeaders
    mVar idCurLoc = m$.var("idCurLoc");
    mVar idGrid = m$.var("idGrid");
    mVar idItem = m$.var("idItem");
    mVar idKey = m$.var("idKey");
    mVar idLine = m$.var("idLine");
    mVar idLocn = m$.var("idLocn");
    mVar idToLocn = m$.var("idToLocn");
    mVar idRequisition = m$.var("idRequisition");
    mVar idxItem = m$.var("idxItem");
    mVar lstColTypes = m$.var("lstColTypes");
    mVar lstHeaders = m$.var("lstHeaders");
    m$.newVar(idCurLoc,idGrid,idItem,idKey,idLine,idLocn,idToLocn,idRequisition,idxItem,lstColTypes,lstHeaders);
    //<< new objLine,objLocn,objRequisition,strStatus,strFunction
    mVar objLine = m$.var("objLine");
    mVar objLocn = m$.var("objLocn");
    mVar objRequisition = m$.var("objRequisition");
    mVar strStatus = m$.var("strStatus");
    mVar strFunction = m$.var("strFunction");
    m$.newVar(objLine,objLocn,objRequisition,strStatus,strFunction);
    //<< 
    //<< set blnHide = +$$$WWW012HideRelationClassIDs($get(^WWW012(0,YM,1)))
    blnHide.set(mOp.Positive(include.WWWConst.$$$WWW012HideRelationClassIDs(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)))));
    //<< set idGrid  =  $$$DYNTABLEGridLineFocusGrid(pidParameters)            // SR15339
    idGrid.set(include.COMSYSWWW.$$$DYNTABLEGridLineFocusGrid(m$,pidParameters));
    //<< 
    //<< set lstHeaders=""
    lstHeaders.set("");
    //<< set lstColTypes=""
    lstColTypes.set("");
    //<< 
    //<< 
    //<< kill ^CacheTempDynamicTable(YUCI,YUSER,1)
    m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),1).kill();
    //<< 
    //<< set idKey         = $$ReferenceKey^COMGridEdit31Interface(idGrid,$$$DYNTABLEGridLineFocusRow(pidParameters)) // SR15339
    idKey.set(m$.fnc$("COMGridEdit31Interface.ReferenceKey",idGrid.get(),include.COMSYSWWW.$$$DYNTABLEGridLineFocusRow(m$,pidParameters)));
    //<< set idRequisition = $$$KEY1(idKey)
    idRequisition.set(include.COMSYSWWW.$$$KEY1(m$,idKey));
    //<< set idLine        = $$$KEY2(idKey)
    idLine.set(include.COMSYSWWW.$$$KEY2(m$,idKey));
    //<< 
    //<< if '$$Editable^INReq(idRequisition) quit                       ; *** EARLY EXIT ***
    if (mOp.Not(m$.fnc$("INReq.Editable",idRequisition.get()))) {
      return null;
    }
    //<< 
    //<< set objRequisition = $$GetYMFELDContainer^COMGridEdit31G()
    objRequisition.set(m$.fnc$("COMGridEdit31G.GetYMFELDContainer"));
    //<< set objLine        = $$$GRIDGetYFELD(idLine)
    objLine.set(include.COMGridEdit31Interface.$$$GRIDGetYFELD(m$,idLine));
    //<< set strStatus      = $$GetLock^WWWMultiLock("INReq",idGrid,idRequisition_$$$COMMA_idLine,$$$NO)      // SR15339
    strStatus.set(m$.fnc$("WWWMultiLock.GetLock","INReq",idGrid.get(),mOp.Concat(mOp.Concat(idRequisition.get(),include.COMSYSString.$$$COMMA(m$)),idLine.get()),include.COMSYS.$$$NO(m$)));
    //<< 
    //<< set strFunction = "FillLine"
    strFunction.set("FillLine");
    //<< 
    //<< set idToLocn = $$$INReqToLocn(objRequisition)               ; SR16417
    idToLocn.set(include.INConst.$$$INReqToLocn(m$,objRequisition));
    //<< set idItem   = $$$INReqLineItem(objLine)
    idItem.set(include.INConst.$$$INReqLineItem(m$,objLine));
    //<< set idxItem  = $$$Index(idItem)
    idxItem.set(include.MEDConst.$$$Index(m$,idItem));
    //<< set fltQty   = $$$INReqLineQtyRequired(objLine)
    fltQty.set(include.INConst.$$$INReqLineQtyRequired(m$,objLine));
    //<< set idCurLoc = $$$INReqLineFromStockLocn(objLine)
    idCurLoc.set(include.INConst.$$$INReqLineFromStockLocn(m$,objLine));
    //<< set dteDate  = $$$INReqLineDueDate(objLine)        if dteDate = "" set dteDate = +$horolog
    dteDate.set(include.INConst.$$$INReqLineDueDate(m$,objLine));
    if (mOp.Equal(dteDate.get(),"")) {
      dteDate.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< 
    //<< set idFromLocn = $$$INReqFromLocn(objRequisition)
    mVar idFromLocn = m$.var("idFromLocn");
    idFromLocn.set(include.INConst.$$$INReqFromLocn(m$,objRequisition));
    //<< 
    //<< set QtdeRequisitada = $$$INReqLineFREE10(objLine)
    mVar QtdeRequisitada = m$.var("QtdeRequisitada");
    QtdeRequisitada.set(include.INConst.$$$INReqLineFREE10(m$,objLine));
    //<< set QtdeDisponivel  = $$GetSOHItem^VARTCIReq(idItem,idFromLocn)
    mVar QtdeDisponivel = m$.var("QtdeDisponivel");
    QtdeDisponivel.set(m$.fnc$("VARTCIReq.GetSOHItem",idItem.get(),idFromLocn.get()));
    //<< set QtdeBloqueada   = $$GetQtyBlockedItem^VARTCIReq(idItem,idFromLocn)
    mVar QtdeBloqueada = m$.var("QtdeBloqueada");
    QtdeBloqueada.set(m$.fnc$("VARTCIReq.GetQtyBlockedItem",idItem.get(),idFromLocn.get()));
    //<< set QtdeTotal       = QtdeDisponivel + QtdeBloqueada
    mVar QtdeTotal = m$.var("QtdeTotal");
    QtdeTotal.set(mOp.Add(QtdeDisponivel.get(),QtdeBloqueada.get()));
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< write "function "_strFunction_"() {"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("function ",strFunction.get()),"() {"));
      //<< write "alert('"_$$$JSText($$$Text(strStatus))_"');"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('",include.COMSYSString.$$$JSText(m$,include.COMSYS.$$$Text(m$,strStatus))),"');"));
      //<< write "}"
      m$.Cmd.Write("}");
    }
    //<< } else {
    else {
      //<< write "function "_strFunction_"() {"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("function ",strFunction.get()),"() {"));
      //<< write "CallBack(""WarehouseLine^INReqTable"", getRowNum(getFocusField()), this.DiscData[0]);"
      m$.Cmd.Write("CallBack(\"WarehouseLine^INReqTable\", getRowNum(getFocusField()), this.DiscData[0]);");
      //<< write "}"
      m$.Cmd.Write("}");
    }
    //<< }
    //<< 
    //<< ;set lstHeaders  = $listbuild($$^WWWFELDNAME("INReqLine","D",$$$FldINReqLineFromStockLocn),
    //<< ;                            $$^WWWTEXT("IN00694"),                            ;BOH   (Balance On Hand)
    //<< ;                            $$^WWWTEXT(32483))
    //<< 
    //<< set lstHeaders  = $listbuild($$^WWWFELDNAME("INReqLine","D",$$$FldINReqLineFromStockLocn),
    //<< "Quant. Requisitada",
    //<< "Quant. Disponível",
    //<< "Quant. Bloq.",
    //<< "Quant. Total")
    lstHeaders.set(m$.Fnc.$listbuild(m$.fnc$("WWWFELDNAME.main","INReqLine","D",include.INConst.$$$FldINReqLineFromStockLocn(m$)),"Quant. Requisitada","Quant. Disponível","Quant. Bloq.","Quant. Total"));
    //<< 
    //<< 
    //<< 
    //<< ;set lstColTypes = $listbuild($listbuild("left","link"),
    //<< ;                            $listbuild("right","link"),
    //<< ;                            $listbuild("right","link"))
    //<< 
    //<< set lstColTypes = $listbuild($listbuild("left","link"),
    //<< $listbuild("right","link"),
    //<< $listbuild("right","link"),
    //<< $listbuild("right","link"),
    //<< $listbuild("right","link"))
    lstColTypes.set(m$.Fnc.$listbuild(m$.Fnc.$listbuild("left","link"),m$.Fnc.$listbuild("right","link"),m$.Fnc.$listbuild("right","link"),m$.Fnc.$listbuild("right","link"),m$.Fnc.$listbuild("right","link")));
    //<< 
    //<< do GetWarehouseLocations^INReqTable(.arrLocations,idItem,dteDate,fltQty)
    m$.Cmd.Do("INReqTable.GetWarehouseLocations",arrLocations,idItem.get(),dteDate.get(),fltQty.get());
    //<< set idLocn=""
    idLocn.set("");
    //<< set Passou = $$$NO
    mVar Passou = m$.var("Passou");
    Passou.set(include.COMSYS.$$$NO(m$));
    //<< for {
    for (;true;) {
      //<< set idLocn=$order(arrLocations(idLocn))
      idLocn.set(m$.Fnc.$order(arrLocations.var(idLocn.get())));
      //<< quit:idLocn=""
      if (mOp.Equal(idLocn.get(),"")) {
        break;
      }
      //<< 
      //<< set Passou = $$$YES
      Passou.set(include.COMSYS.$$$YES(m$));
      //<< 
      //<< ;   continue:idLocn=YLOCATION
      //<< //  continue:idLocn=idCurLoc                    ; Exclude if the Loc is currently defined on the line
      //<< continue:idLocn=idToLocn ; SR16417
      if (mOp.Equal(idLocn.get(),idToLocn.get())) {
        continue;
      }
      //<< 
      //<< set fltBOH = $piece(arrLocations(idLocn),Y,1)
      fltBOH.set(m$.Fnc.$piece(arrLocations.var(idLocn.get()).get(),m$.var("Y").get(),1));
      //<< set fltATP = $piece(arrLocations(idLocn),Y,2)
      fltATP.set(m$.Fnc.$piece(arrLocations.var(idLocn.get()).get(),m$.var("Y").get(),2));
      //<< //  if (fltBOH'=0) && (fltATP'=0) {
      //<< set ^CacheTempDynamicTable(YUCI,YUSER,1,$increment(idLine),"data") = idLocn
      m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),1,m$.Fnc.$increment(idLine),"data").set(idLocn.get());
      //<< set objLocn = $get(^WWW0121(0,YM,idLocn,1))
      objLocn.set(m$.Fnc.$get(m$.var("^WWW0121",0,m$.var("YM").get(),idLocn.get(),1)));
      //<< 
      //<< ;set ^CacheTempDynamicTable(YUCI,YUSER,1,idLine) = $select(blnHide:"",1:"("_idLocn_") ")_$$$WWW0121LocationName(objLocn)_Y_
      //<< ;                                                 fltBOH_Y_
      //<< ;                                                 fltATP
      //<< 
      //<< set ^CacheTempDynamicTable(YUCI,YUSER,1,idLine) = $select(blnHide:"",1:"("_idLocn_") ")_$$$WWW0121LocationName(objLocn)_Y_
      //<< QtdeRequisitada_Y_
      //<< QtdeDisponivel_Y_
      //<< QtdeBloqueada_Y_
      //<< QtdeTotal
      m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),1,idLine.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$select(blnHide.get(),"",1,mOp.Concat(mOp.Concat("(",idLocn.get()),") ")),include.WWWConst.$$$WWW0121LocationName(m$,objLocn)),m$.var("Y").get()),QtdeRequisitada.get()),m$.var("Y").get()),QtdeDisponivel.get()),m$.var("Y").get()),QtdeBloqueada.get()),m$.var("Y").get()),QtdeTotal.get()));
    }
    //<< 
    //<< 
    //<< //  }
    //<< }
    //<< 
    //<< ;Desenha uma linha com qtdes zeradas se não entrou no for acima
    //<< if (idLocn="") && (Passou=$$$NO) {
    if ((mOp.Equal(idLocn.get(),"")) && (mOp.Equal(Passou.get(),include.COMSYS.$$$NO(m$)))) {
      //<< set Local = idFromLocn
      mVar Local = m$.var("Local");
      Local.set(idFromLocn.get());
      //<< set objLocn = $get(^WWW0121(0,YM,Local,1))
      objLocn.set(m$.Fnc.$get(m$.var("^WWW0121",0,m$.var("YM").get(),Local.get(),1)));
      //<< set ^CacheTempDynamicTable(YUCI,YUSER,1,$increment(idLine),"data") = Local
      m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),1,m$.Fnc.$increment(idLine),"data").set(Local.get());
      //<< set ^CacheTempDynamicTable(YUCI,YUSER,1,idLine) = $select(blnHide:"",1:"("_Local_") ")_
      //<< $$$WWW0121LocationName(objLocn)_Y_
      //<< QtdeRequisitada_Y_
      //<< QtdeDisponivel_Y_
      //<< QtdeBloqueada_Y_
      //<< QtdeTotal
      m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),1,idLine.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$select(blnHide.get(),"",1,mOp.Concat(mOp.Concat("(",Local.get()),") ")),include.WWWConst.$$$WWW0121LocationName(m$,objLocn)),m$.var("Y").get()),QtdeRequisitada.get()),m$.var("Y").get()),QtdeDisponivel.get()),m$.var("Y").get()),QtdeBloqueada.get()),m$.var("Y").get()),QtdeTotal.get()));
    }
    //<< 
    //<< }
    //<< 
    //<< 
    //<< do DrawTable^WWW120DynTable(lstHeaders,1,lstColTypes,pidParameters,strFunction,pidEvent)
    m$.Cmd.Do("WWW120DynTable.DrawTable",lstHeaders.get(),1,lstColTypes.get(),pidParameters.get(),strFunction.get(),pidEvent.get());
    //<< 
    //<< kill ^CacheTempDynamicTable(YUCI,YUSER,1)
    m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),1).kill();
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CanViewReportComprovante(pYKEY)
  public Object CanViewReportComprovante(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;19-Oct-2009    Karine  Criado
    //<< 
    //<< quit:pYKEY=""
    if (mOp.Equal(pYKEY.get(),"")) {
      return null;
    }
    //<< set objReq = $get(^INIssue(0,pYKEY,1))
    mVar objReq = m$.var("objReq");
    objReq.set(m$.Fnc.$get(m$.var("^INIssue",0,pYKEY.get(),1)));
    //<< 
    //<< set vStatus = $piece(objReq,Y,1)
    mVar vStatus = m$.var("vStatus");
    vStatus.set(m$.Fnc.$piece(objReq.get(),m$.var("Y").get(),1));
    //<< 
    //<< if vStatus '= 9 {
    if (mOp.NotEqual(vStatus.get(),9)) {
      //<< new strStatus
      mVar strStatus = m$.var("strStatus");
      m$.newVar(strStatus);
      //<< set strStatus = "Não é possível gerar Comprovante de Entrega."
      strStatus.set("Não é possível gerar Comprovante de Entrega.");
      //<< $$$YQHandler(strStatus)
      include.COMSYS.$$$YQHandler(m$,strStatus);
    }
    //<< 
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< CanViewListaSeparacao(pYKEY)
  public Object CanViewListaSeparacao(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;19-Oct-2009    Karine  Criado
    //<< 
    //<< quit:pYKEY=""
    if (mOp.Equal(pYKEY.get(),"")) {
      return null;
    }
    //<< set objReq = $get(^INIssue(0,pYKEY,1))
    mVar objReq = m$.var("objReq");
    objReq.set(m$.Fnc.$get(m$.var("^INIssue",0,pYKEY.get(),1)));
    //<< 
    //<< set vStatus = $piece(objReq,Y,1)
    mVar vStatus = m$.var("vStatus");
    vStatus.set(m$.Fnc.$piece(objReq.get(),m$.var("Y").get(),1));
    //<< 
    //<< if vStatus = 9 {
    if (mOp.Equal(vStatus.get(),9)) {
      //<< new strStatus
      mVar strStatus = m$.var("strStatus");
      m$.newVar(strStatus);
      //<< set strStatus = "Não é possível gerar Lista de Separação."
      strStatus.set("Não é possível gerar Lista de Separação.");
      //<< $$$YQHandler(strStatus)
      include.COMSYS.$$$YQHandler(m$,strStatus);
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< CheckIfHasSOHForApproval(pidReq)
  public Object CheckIfHasSOHForApproval(Object ... _p) {
    mVar pidReq = m$.newVarRef("pidReq",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Bloqueia a aprovação de itens que não tenham quantidade suficiente em estoque.
    //<< ; Inputs: pidReq - ID Req
    //<< ;         pidType (as defined above)
    //<< ;
    //<< ; Returns: YQ = 0 Enable, YQ = 1 Disable
    //<< ;
    //<< ; History:
    //<< ; 06-Abr-2011   Karine  Created: JIRA -> TCI-81
    //<< ;-------------------------------------------------------------------------------
    //<< new arrCount,fltAvail,fltReq,idItem,idType,intLine,objReqLine, strStatus
    mVar arrCount = m$.var("arrCount");
    mVar fltAvail = m$.var("fltAvail");
    mVar fltReq = m$.var("fltReq");
    mVar idItem = m$.var("idItem");
    mVar idType = m$.var("idType");
    mVar intLine = m$.var("intLine");
    mVar objReqLine = m$.var("objReqLine");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(arrCount,fltAvail,fltReq,idItem,idType,intLine,objReqLine,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< //New register
    //<< if pidReq'="" {
    if (mOp.NotEqual(pidReq.get(),"")) {
      //<< //No Lines
      //<< if $data(^INReqLine(0,pidReq)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^INReqLine",0,pidReq.get())))) {
        //<< 
        //<< set strStatus = $$$OK
        strStatus.set(include.COMSYS.$$$OK(m$));
        //<< 
        //<< set isValidating = $$getValidaQtdReq^VARParametroCliente(YM)
        mVar isValidating = m$.var("isValidating");
        isValidating.set(m$.fnc$("VARParametroCliente.getValidaQtdReq",m$.var("YM").get()));
        //<< 
        //<< if isValidating '= $$$OK {   ;deixa requisitar produtos com estoque zerado
        if (mOp.NotEqual(isValidating.get(),include.COMSYS.$$$OK(m$))) {
          //<< 
          //<< set intLine = ""
          intLine.set("");
          //<< for {
          for (;true;) {
            //<< set intLine = $order(^INReqLine(0,pidReq,intLine))
            intLine.set(m$.Fnc.$order(m$.var("^INReqLine",0,pidReq.get(),intLine.get())));
            //<< quit:intLine=""
            if (mOp.Equal(intLine.get(),"")) {
              break;
            }
            //<< 
            //<< set objReqLine = $get(^INReqLine(0,pidReq,intLine,1))
            objReqLine.set(m$.Fnc.$get(m$.var("^INReqLine",0,pidReq.get(),intLine.get(),1)));
            //<< 
            //<< set idItem     = $$$INReqLineItem(objReqLine)
            idItem.set(include.INConst.$$$INReqLineItem(m$,objReqLine));
            //<< set fltReq     = $$$INReqLineFREE10(objReqLine) ;quantidade requisitada
            fltReq.set(include.INConst.$$$INReqLineFREE10(m$,objReqLine));
            //<< set fltOrd     = $$$INReqLineQtyOrdered(objReqLine)  ; quantidade aprovada
            mVar fltOrd = m$.var("fltOrd");
            fltOrd.set(include.INConst.$$$INReqLineQtyOrdered(m$,objReqLine));
            //<< set fltAvail = $$GetQuantityOnHand^INARTMENGE(idItem,$$$INReqLineFromStockLocn(objReqLine))
            fltAvail.set(m$.fnc$("INARTMENGE.GetQuantityOnHand",idItem.get(),include.INConst.$$$INReqLineFromStockLocn(m$,objReqLine)));
            //<< 
            //<< if fltOrd > fltAvail {
            if (mOp.Greater(fltOrd.get(),fltAvail.get())) {
              //<< 
              //<< set strStatus = "0 O item "_idItem_" não tem estoque suficiente para ser aprovado. "
              strStatus.set(mOp.Concat(mOp.Concat("0 O item ",idItem.get())," não tem estoque suficiente para ser aprovado. "));
            }
          }
        }
      }
    }
    //<< 
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
}
