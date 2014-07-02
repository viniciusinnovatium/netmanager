//*****************************************************************************
//** TASC - ALPHALINC - MAC VARAlertaLocalBIZ
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-01 17:29:24
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
//<< #include VARConst
import include.VARConst;
//<< #include INConst
import include.INConst;
//<< #include VARSESConst
import VARSESConst;

public class VARAlertaLocalBIZ extends mClass {

  //<< 
  //<< VARAlertaLocalBIZ
  public Object main() {
    _VARAlertaLocalBIZ();
    return null;
  }

  public Object _VARAlertaLocalBIZ() {
    //<< quit
    return null;
  }

  //<< 
  //<< CriarOrdemCompra(&parrAlertaLinhas, &parrDocs)
  public Object CriarOrdemCompra(Object ... _p) {
    mVar parrAlertaLinhas = m$.newVarRef("parrAlertaLinhas",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar parrDocs = m$.newVarRef("parrDocs",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< new strStatus, arrDocs
    mVar strStatus = m$.var("strStatus");
    mVar arrDocs = m$.var("arrDocs");
    m$.newVar(strStatus,arrDocs);
    //<< 
    //<< set strStatus = $$Transaction^COMTransaction("CriarOrdemCompraTxn^VARAlertaLocalBIZ(.parrAlertaLinhas,.parrDocs)", $$$YES)
    strStatus.set(m$.fnc$("COMTransaction.Transaction","CriarOrdemCompraTxn^VARAlertaLocalBIZ(.parrAlertaLinhas,.parrDocs)",include.COMSYS.$$$YES(m$)));
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< CriarPedidoCompra(&parrAlertaLinhas, &parrDocs)
  public Object CriarPedidoCompra(Object ... _p) {
    mVar parrAlertaLinhas = m$.newVarRef("parrAlertaLinhas",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar parrDocs = m$.newVarRef("parrDocs",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< new strStatus, arrDocs
    mVar strStatus = m$.var("strStatus");
    mVar arrDocs = m$.var("arrDocs");
    m$.newVar(strStatus,arrDocs);
    //<< 
    //<< set strStatus = $$Transaction^COMTransaction("CriarPedidoCompraTxn^VARAlertaLocalBIZ(.parrAlertaLinhas,.parrDocs)", $$$YES)
    strStatus.set(m$.fnc$("COMTransaction.Transaction","CriarPedidoCompraTxn^VARAlertaLocalBIZ(.parrAlertaLinhas,.parrDocs)",include.COMSYS.$$$YES(m$)));
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< CriarRequisicao(&parrAlertaLinhas, &parrDocs)
  public Object CriarRequisicao(Object ... _p) {
    mVar parrAlertaLinhas = m$.newVarRef("parrAlertaLinhas",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar parrDocs = m$.newVarRef("parrDocs",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< new strStatus, arrDocs
    mVar strStatus = m$.var("strStatus");
    mVar arrDocs = m$.var("arrDocs");
    m$.newVar(strStatus,arrDocs);
    //<< 
    //<< set strStatus = $$Transaction^COMTransaction("CriarRequisicaoTxn^VARAlertaLocalBIZ(.parrAlertaLinhas,.parrDocs)", $$$YES)
    strStatus.set(m$.fnc$("COMTransaction.Transaction","CriarRequisicaoTxn^VARAlertaLocalBIZ(.parrAlertaLinhas,.parrDocs)",include.COMSYS.$$$YES(m$)));
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< CriarOrdemCompraTxn(&parrAlertaLinhas,&pListOfDocs)
  public Object CriarOrdemCompraTxn(Object ... _p) {
    mVar parrAlertaLinhas = m$.newVarRef("parrAlertaLinhas",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pListOfDocs = m$.newVarRef("pListOfDocs",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< new objCompra, idCompra, strStatus, idItem, idLocation, objCompraLinha, fltQuantity, parrPurchases
    mVar objCompra = m$.var("objCompra");
    mVar idCompra = m$.var("idCompra");
    mVar strStatus = m$.var("strStatus");
    mVar idItem = m$.var("idItem");
    mVar idLocation = m$.var("idLocation");
    mVar objCompraLinha = m$.var("objCompraLinha");
    mVar fltQuantity = m$.var("fltQuantity");
    mVar parrPurchases = m$.var("parrPurchases");
    m$.newVar(objCompra,idCompra,strStatus,idItem,idLocation,objCompraLinha,fltQuantity,parrPurchases);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< $$$Order1(parrAlertaLinhas,Location)
    mVar Location = m$.var("Location");
    Location.set("");
    for (;true;) {
      Location.set(m$.Fnc.$order(parrAlertaLinhas.var(Location.get())));
      if (mOp.Equal(Location.get(),"")) {
        break;
      }
      //<< set idLocation=Location
      idLocation.set(Location.get());
      //<< $$$Order2(parrAlertaLinhas,Location,idItem)
      idItem.set("");
      for (;true;) {
        idItem.set(m$.Fnc.$order(parrAlertaLinhas.var(Location.get(),idItem.get())));
        if (mOp.Equal(idItem.get(),"")) {
          break;
        }
        //<< 
        //<< set fltQuantity        = parrAlertaLinhas(Location, idItem)
        fltQuantity.set(parrAlertaLinhas.var(Location.get(),idItem.get()).get());
        //<< 
        //<< set parrPurchases(idItem, Location) = fltQuantity
        parrPurchases.var(idItem.get(),Location.get()).set(fltQuantity.get());
      }
    }
    //<< 
    //<< $$$End
    //<< $$$End
    //<< set objCompra = ""
    objCompra.set("");
    //<< set $piece(objCompra,Y,6)=idLocation
    m$.pieceVar(objCompra,m$.var("Y").get(),6).set(idLocation.get());
    //<< set $piece(objCompra,Y,2)=2
    m$.pieceVar(objCompra,m$.var("Y").get(),2).set(2);
    //<< set $piece(objCompra,Y,348)=0
    m$.pieceVar(objCompra,m$.var("Y").get(),348).set(0);
    //<< 
    //<< 
    //<< set idCompra = $$^WWWNEXT("INAUF")
    idCompra.set(m$.fnc$("WWWNEXT.main","INAUF"));
    //<< if (idCompra = "") {
    if ((mOp.Equal(idCompra.get(),""))) {
      //<< quit "0~Erro ao criar Ordem de Compra"
      return "0~Erro ao criar Ordem de Compra";
    }
    //<< }
    //<< set pListOfDocs("Purchase",idCompra)=""
    pListOfDocs.var("Purchase",idCompra.get()).set("");
    //<< set strStatus = $$$Save("INAUF",idCompra,objCompra,1)
    strStatus.set(include.COMSYS.$$$Save(m$,"INAUF",idCompra,objCompra,1));
    //<< if (strStatus '= $$$OK) {
    if ((mOp.NotEqual(strStatus.get(),include.COMSYS.$$$OK(m$)))) {
      //<< quit strStatus // if error, quit.
      return strStatus.get();
    }
    //<< }
    //<< 
    //<< // Agora, cria as linhas da PAM:
    //<< // setar os campos 1,54; 2,55; 4,56; 16,57;
    //<< set intCounter = 1
    mVar intCounter = m$.var("intCounter");
    intCounter.set(1);
    //<< $$$Order1(parrPurchases,idItem)
    idItem.set("");
    for (;true;) {
      idItem.set(m$.Fnc.$order(parrPurchases.var(idItem.get())));
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< 
      //<< $$$Order2(parrPurchases,idItem,idLocation)
      idLocation.set("");
      for (;true;) {
        idLocation.set(m$.Fnc.$order(parrPurchases.var(idItem.get(),idLocation.get())));
        if (mOp.Equal(idLocation.get(),"")) {
          break;
        }
        //<< 
        //<< set objCompraLinha  = ""
        objCompraLinha.set("");
        //<< set fltQuantity = parrPurchases(idItem, idLocation)
        fltQuantity.set(parrPurchases.var(idItem.get(),idLocation.get()).get());
        //<< set $piece(objCompraLinha,Y,1)=$piece(^INART(YM,idItem,1),Y,1)
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.var("^INART",m$.var("YM").get(),idItem.get(),1).get(),m$.var("Y").get(),1));
        //<< set $piece(objCompraLinha,Y,4)=idItem
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),4).set(idItem.get());
        //<< set $piece(objCompraLinha,Y,5)=fltQuantity
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),5).set(fltQuantity.get());
        //<< set $piece(objCompraLinha,Y,448)=fltQuantity //Why twice?
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),448).set(fltQuantity.get());
        //<< set $piece(objCompraLinha,Y,292)=1 //Do we need this?
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),292).set(1);
        //<< set $piece(objCompraLinha,Y,7)=1 //Do we need this?
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),7).set(1);
        //<< set $piece(objCompraLinha,Y,12)="" //No supplier at this time - CHECK THIS LATER
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),12).set("");
        //<< set $piece(objCompraLinha,Y,40)=$piece(^INART(YM,idItem,1),Y,40)
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),40).set(m$.Fnc.$piece(m$.var("^INART",m$.var("YM").get(),idItem.get(),1).get(),m$.var("Y").get(),40));
        //<< set $piece(objCompraLinha,Y,449)=$piece(^INART(YM,idItem,1),Y,40) //Why twice?
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),449).set(m$.Fnc.$piece(m$.var("^INART",m$.var("YM").get(),idItem.get(),1).get(),m$.var("Y").get(),40));
        //<< 
        //<< set strStatus = $$$Save("INAUFP",idCompra_$$$COMMA_intCounter,objCompraLinha,1)
        strStatus.set(include.COMSYS.$$$Save(m$,"INAUFP",mOp.Concat(mOp.Concat(idCompra.get(),include.COMSYSString.$$$COMMA(m$)),intCounter.get()),objCompraLinha,1));
        //<< set intCounter = intCounter + 1
        intCounter.set(mOp.Add(intCounter.get(),1));
        //<< do:'$$$ISOK(strStatus) RaiseError(strStatus)
        if (mOp.Not(include.COMSYS.$$$ISOK(m$,strStatus))) {
          m$.Cmd.Do("RaiseError",strStatus.get());
        }
      }
    }
    //<< $$$End
    //<< $$$End
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< CriarRequisicaoTxn(&parrAlertaLinhas,&pListOfDocs)
  public Object CriarRequisicaoTxn(Object ... _p) {
    mVar parrAlertaLinhas = m$.newVarRef("parrAlertaLinhas",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pListOfDocs = m$.newVarRef("pListOfDocs",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< new objReq, idTransfer, strStatus, idItem, idLocation, objReqLinha, fltQuantity, parrPurchases
    mVar objReq = m$.var("objReq");
    mVar idTransfer = m$.var("idTransfer");
    mVar strStatus = m$.var("strStatus");
    mVar idItem = m$.var("idItem");
    mVar idLocation = m$.var("idLocation");
    mVar objReqLinha = m$.var("objReqLinha");
    mVar fltQuantity = m$.var("fltQuantity");
    mVar parrPurchases = m$.var("parrPurchases");
    m$.newVar(objReq,idTransfer,strStatus,idItem,idLocation,objReqLinha,fltQuantity,parrPurchases);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< $$$Order1(parrAlertaLinhas,Location)
    mVar Location = m$.var("Location");
    Location.set("");
    for (;true;) {
      Location.set(m$.Fnc.$order(parrAlertaLinhas.var(Location.get())));
      if (mOp.Equal(Location.get(),"")) {
        break;
      }
      //<< set idLocation=Location
      idLocation.set(Location.get());
      //<< $$$Order2(parrAlertaLinhas,Location,idItem)
      idItem.set("");
      for (;true;) {
        idItem.set(m$.Fnc.$order(parrAlertaLinhas.var(Location.get(),idItem.get())));
        if (mOp.Equal(idItem.get(),"")) {
          break;
        }
        //<< 
        //<< set fltQuantity        = parrAlertaLinhas(Location, idItem)
        fltQuantity.set(parrAlertaLinhas.var(Location.get(),idItem.get()).get());
        //<< 
        //<< set parrReqs(idItem, Location) = fltQuantity
        mVar parrReqs = m$.var("parrReqs");
        parrReqs.var(idItem.get(),Location.get()).set(fltQuantity.get());
      }
    }
    //<< 
    //<< $$$End
    //<< $$$End
    //<< 
    //<< set objReq = ""
    objReq.set("");
    //<< 
    //<< set $piece(objReq,Y,1)=1
    m$.pieceVar(objReq,m$.var("Y").get(),1).set(1);
    //<< set $piece(objReq,Y,2)=$piece($H,",",1)
    m$.pieceVar(objReq,m$.var("Y").get(),2).set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",1));
    //<< set $piece(objReq,Y,3)=idLocation
    m$.pieceVar(objReq,m$.var("Y").get(),3).set(idLocation.get());
    //<< set $piece(objReq,Y,4)=""
    m$.pieceVar(objReq,m$.var("Y").get(),4).set("");
    //<< set $piece(objReq,Y,7)=2 //Tipo de requisição
    m$.pieceVar(objReq,m$.var("Y").get(),7).set(2);
    //<< 
    //<< set idTransfer = $$^WWWNEXT("INReq")
    idTransfer.set(m$.fnc$("WWWNEXT.main","INReq"));
    //<< if (idTransfer = "") {
    if ((mOp.Equal(idTransfer.get(),""))) {
      //<< quit "0~Erro ao criar requisição"
      return "0~Erro ao criar requisição";
    }
    //<< }
    //<< set pListOfDocs("Requisition",idTransfer)=""
    pListOfDocs.var("Requisition",idTransfer.get()).set("");
    //<< set strStatus = $$$Save("INReq",idTransfer,objReq,1)
    strStatus.set(include.COMSYS.$$$Save(m$,"INReq",idTransfer,objReq,1));
    //<< if (strStatus '= $$$OK) {
    if ((mOp.NotEqual(strStatus.get(),include.COMSYS.$$$OK(m$)))) {
      //<< quit strStatus // if error, quit.
      return strStatus.get();
    }
    //<< }
    //<< 
    //<< set intCounter = 1
    mVar intCounter = m$.var("intCounter");
    intCounter.set(1);
    //<< $$$Order1(parrReqs,idItem)
    idItem.set("");
    for (;true;) {
      idItem.set(m$.Fnc.$order(m$.var("parrReqs").var(idItem.get())));
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< 
      //<< $$$Order2(parrReqs,idItem,idLocation)
      idLocation.set("");
      for (;true;) {
        idLocation.set(m$.Fnc.$order(m$.var("parrReqs").var(idItem.get(),idLocation.get())));
        if (mOp.Equal(idLocation.get(),"")) {
          break;
        }
        //<< 
        //<< set objReqLinha  = ""
        objReqLinha.set("");
        //<< set fltQuantity = parrReqs(idItem, idLocation)
        fltQuantity.set(m$.var("parrReqs").var(idItem.get(),idLocation.get()).get());
        //<< set $piece(objReqLinha,Y,1)=idItem
        m$.pieceVar(objReqLinha,m$.var("Y").get(),1).set(idItem.get());
        //<< set $piece(objReqLinha,Y,2)=$piece(^INART(YM,idItem,1),Y,40)
        m$.pieceVar(objReqLinha,m$.var("Y").get(),2).set(m$.Fnc.$piece(m$.var("^INART",m$.var("YM").get(),idItem.get(),1).get(),m$.var("Y").get(),40));
        //<< set $piece(objReqLinha,Y,3)=fltQuantity
        m$.pieceVar(objReqLinha,m$.var("Y").get(),3).set(fltQuantity.get());
        //<< set $piece(objReqLinha,Y,4)=fltQuantity
        m$.pieceVar(objReqLinha,m$.var("Y").get(),4).set(fltQuantity.get());
        //<< 
        //<< //set $piece(objReqLinha,Y,9)= //Local abastecedor não pode ser salvo pois ainda não foi definido
        //<< set $piece(objReqLinha,Y,10)=1 //Status
        m$.pieceVar(objReqLinha,m$.var("Y").get(),10).set(1);
        //<< //set $piece(objReqLinha,Y,12)=fltQuantity //Consumo Mensal
        //<< //set $piece(objReqLinha,Y,31)=fltQuantity //Preço Unitário
        //<< 
        //<< set strStatus = $$$Save("INReqLine",idTransfer_$$$COMMA_intCounter,objReqLinha,1)
        strStatus.set(include.COMSYS.$$$Save(m$,"INReqLine",mOp.Concat(mOp.Concat(idTransfer.get(),include.COMSYSString.$$$COMMA(m$)),intCounter.get()),objReqLinha,1));
        //<< set intCounter = intCounter + 1
        intCounter.set(mOp.Add(intCounter.get(),1));
        //<< do:'$$$ISOK(strStatus) RaiseError(strStatus)
        if (mOp.Not(include.COMSYS.$$$ISOK(m$,strStatus))) {
          m$.Cmd.Do("RaiseError",strStatus.get());
        }
      }
    }
    //<< $$$End
    //<< $$$End
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< CriarPedidoCompraTxn(&parrAlertaLinhas,&pListOfDocs)
  public Object CriarPedidoCompraTxn(Object ... _p) {
    mVar parrAlertaLinhas = m$.newVarRef("parrAlertaLinhas",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pListOfDocs = m$.newVarRef("pListOfDocs",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< new objCompra, idCompra, strStatus, idItem, idLocation, objCompraLinha, fltQuantity, parrPurchases
    mVar objCompra = m$.var("objCompra");
    mVar idCompra = m$.var("idCompra");
    mVar strStatus = m$.var("strStatus");
    mVar idItem = m$.var("idItem");
    mVar idLocation = m$.var("idLocation");
    mVar objCompraLinha = m$.var("objCompraLinha");
    mVar fltQuantity = m$.var("fltQuantity");
    mVar parrPurchases = m$.var("parrPurchases");
    m$.newVar(objCompra,idCompra,strStatus,idItem,idLocation,objCompraLinha,fltQuantity,parrPurchases);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< $$$Order1(parrAlertaLinhas,Location)
    mVar Location = m$.var("Location");
    Location.set("");
    for (;true;) {
      Location.set(m$.Fnc.$order(parrAlertaLinhas.var(Location.get())));
      if (mOp.Equal(Location.get(),"")) {
        break;
      }
      //<< set idLocation=Location
      idLocation.set(Location.get());
      //<< $$$Order2(parrAlertaLinhas,Location,idItem)
      idItem.set("");
      for (;true;) {
        idItem.set(m$.Fnc.$order(parrAlertaLinhas.var(Location.get(),idItem.get())));
        if (mOp.Equal(idItem.get(),"")) {
          break;
        }
        //<< 
        //<< set fltQuantity        = parrAlertaLinhas(Location, idItem)
        fltQuantity.set(parrAlertaLinhas.var(Location.get(),idItem.get()).get());
        //<< 
        //<< set parrPurchases(idItem, Location) = fltQuantity
        parrPurchases.var(idItem.get(),Location.get()).set(fltQuantity.get());
      }
    }
    //<< 
    //<< $$$End
    //<< $$$End
    //<< set objCompra = ""
    objCompra.set("");
    //<< set $piece(objCompra,Y,3)=idLocation
    m$.pieceVar(objCompra,m$.var("Y").get(),3).set(idLocation.get());
    //<< set $piece(objCompra,Y,6)=0
    m$.pieceVar(objCompra,m$.var("Y").get(),6).set(0);
    //<< set $piece(objCompra,Y,8)=$piece($H,",",1)
    m$.pieceVar(objCompra,m$.var("Y").get(),8).set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",1));
    //<< set $piece(objCompra,Y,9)=YBED
    m$.pieceVar(objCompra,m$.var("Y").get(),9).set(m$.var("YBED").get());
    //<< 
    //<< 
    //<< set idCompra = $$^WWWNEXT("VARPedidoCompra")
    idCompra.set(m$.fnc$("WWWNEXT.main","VARPedidoCompra"));
    //<< if (idCompra = "") {
    if ((mOp.Equal(idCompra.get(),""))) {
      //<< quit "0~Erro ao criar Pedido de Compra"
      return "0~Erro ao criar Pedido de Compra";
    }
    //<< }
    //<< set pListOfDocs("PurchaseRequest",idCompra)=""
    pListOfDocs.var("PurchaseRequest",idCompra.get()).set("");
    //<< set strStatus = $$$Save("VARPedidoCompra",idCompra,objCompra,1)
    strStatus.set(include.COMSYS.$$$Save(m$,"VARPedidoCompra",idCompra,objCompra,1));
    //<< if (strStatus '= $$$OK) {
    if ((mOp.NotEqual(strStatus.get(),include.COMSYS.$$$OK(m$)))) {
      //<< quit strStatus // if error, quit.
      return strStatus.get();
    }
    //<< }
    //<< 
    //<< set intCounter = 1
    mVar intCounter = m$.var("intCounter");
    intCounter.set(1);
    //<< $$$Order1(parrPurchases,idItem)
    idItem.set("");
    for (;true;) {
      idItem.set(m$.Fnc.$order(parrPurchases.var(idItem.get())));
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< 
      //<< $$$Order2(parrPurchases,idItem,idLocation)
      idLocation.set("");
      for (;true;) {
        idLocation.set(m$.Fnc.$order(parrPurchases.var(idItem.get(),idLocation.get())));
        if (mOp.Equal(idLocation.get(),"")) {
          break;
        }
        //<< 
        //<< set objCompraLinha  = ""
        objCompraLinha.set("");
        //<< set fltQuantity = parrPurchases(idItem, idLocation)
        fltQuantity.set(parrPurchases.var(idItem.get(),idLocation.get()).get());
        //<< set $piece(objCompraLinha,Y,3)=$piece(^INART(YM,idItem,1),Y,30)
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),3).set(m$.Fnc.$piece(m$.var("^INART",m$.var("YM").get(),idItem.get(),1).get(),m$.var("Y").get(),30));
        //<< set $piece(objCompraLinha,Y,1)=idItem
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),1).set(idItem.get());
        //<< set $piece(objCompraLinha,Y,4)=fltQuantity
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),4).set(fltQuantity.get());
        //<< set $piece(objCompraLinha,Y,5)=0
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),5).set(0);
        //<< set $piece(objCompraLinha,Y,6)=0
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),6).set(0);
        //<< set $piece(objCompraLinha,Y,11)=0
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),11).set(0);
        //<< set $piece(objCompraLinha,Y,2)=$piece(^INART(YM,idItem,1),Y,40)
        m$.pieceVar(objCompraLinha,m$.var("Y").get(),2).set(m$.Fnc.$piece(m$.var("^INART",m$.var("YM").get(),idItem.get(),1).get(),m$.var("Y").get(),40));
        //<< 
        //<< set strStatus = $$$Save("VARPedidoCompraLinha",idCompra_$$$COMMA_intCounter,objCompraLinha,1)
        strStatus.set(include.COMSYS.$$$Save(m$,"VARPedidoCompraLinha",mOp.Concat(mOp.Concat(idCompra.get(),include.COMSYSString.$$$COMMA(m$)),intCounter.get()),objCompraLinha,1));
        //<< set intCounter = intCounter + 1
        intCounter.set(mOp.Add(intCounter.get(),1));
        //<< do:'$$$ISOK(strStatus) RaiseError(strStatus)
        if (mOp.Not(include.COMSYS.$$$ISOK(m$,strStatus))) {
          m$.Cmd.Do("RaiseError",strStatus.get());
        }
      }
    }
    //<< $$$End
    //<< $$$End
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< RaiseError(pstrStatus)
  public Object RaiseError(Object ... _p) {
    mVar pstrStatus = m$.newVarRef("pstrStatus",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< set ^CacheTempAlertaLocalError(YBED,$horolog) = $$$Text(pstrStatus)
    m$.var("^CacheTempAlertaLocalError",m$.var("YBED").get(),m$.Fnc.$horolog()).set(include.COMSYS.$$$Text(m$,pstrStatus));
    return null;
  }

//<< ztrap
//<< 
//<< quit
//<< 
//<< 
//<< 
}
