//*****************************************************************************
//** TASC - ALPHALINC - MAC VARAlertaLocalLinha
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-01 17:29:02
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
//<< #include COMConst
import include.COMConst;
//<< #include COMView
import include.COMView;
//<< #include INConst
import include.INConst;
//<< #include VARConst
import include.VARConst;

public class VARAlertaLocalLinha extends mClass {

  //<< 
  //<< VARAlertaLocalLinha
  public Object main() {
    _VARAlertaLocalLinha();
    return null;
  }

  public Object _VARAlertaLocalLinha() {
    //<< quit
    return null;
  }

  //<< 
  //<< OnBeforeFormat(pstrYFIELDNAME,pstrText,pobjLine)
  public Object OnBeforeFormat(Object ... _p) {
    mVar pstrYFIELDNAME = m$.newVarRef("pstrYFIELDNAME",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjLine = m$.newVarRef("pobjLine",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< new idField, idKey, idLocation, idItem, blnFilterEstoqueAcimaPR, blnFilterEstoqueProximoPR,
    //<< blnFilterEstoqueAbaixoPRcomEP, blnFilterEstoqueAbaixoPRsemEP, blnFilterEstoqueAcimaEM
    mVar idField = m$.var("idField");
    mVar idKey = m$.var("idKey");
    mVar idLocation = m$.var("idLocation");
    mVar idItem = m$.var("idItem");
    mVar blnFilterEstoqueAcimaPR = m$.var("blnFilterEstoqueAcimaPR");
    mVar blnFilterEstoqueProximoPR = m$.var("blnFilterEstoqueProximoPR");
    mVar blnFilterEstoqueAbaixoPRcomEP = m$.var("blnFilterEstoqueAbaixoPRcomEP");
    mVar blnFilterEstoqueAbaixoPRsemEP = m$.var("blnFilterEstoqueAbaixoPRsemEP");
    mVar blnFilterEstoqueAcimaEM = m$.var("blnFilterEstoqueAcimaEM");
    m$.newVar(idField,idKey,idLocation,idItem,blnFilterEstoqueAcimaPR,blnFilterEstoqueProximoPR,blnFilterEstoqueAbaixoPRcomEP,blnFilterEstoqueAbaixoPRsemEP,blnFilterEstoqueAcimaEM);
    //<< 
    //<< $$$GRIDSplitKey(pstrYFIELDNAME,intRow,intCol)
    include.COMGridEdit31Interface.$$$GRIDSplitKey(m$,pstrYFIELDNAME,m$.var("intRow"),m$.var("intCol"));
    //<< set idField = $$$GetClassField(YFORM,intCol)
    idField.set(include.COMSYSWWW.$$$GetClassField(m$,m$.var("YFORM"),m$.var("intCol")));
    //<< 
    //<< set idKey      = $$ReferenceKey^COMGridEdit31Interface(YFORM,intRow)
    idKey.set(m$.fnc$("COMGridEdit31Interface.ReferenceKey",m$.var("YFORM").get(),m$.var("intRow").get()));
    //<< set idLocation = $$$KEY1(idKey)
    idLocation.set(include.COMSYSWWW.$$$KEY1(m$,idKey));
    //<< set idItem     = $$$KEY2(idKey)
    idItem.set(include.COMSYSWWW.$$$KEY2(m$,idKey));
    //<< if idLocation="Rede" set idLocation=""
    if (mOp.Equal(idLocation.get(),"Rede")) {
      idLocation.set("");
    }
    //<< 
    //<< if intCol=25 quit //No background for field Quantidade
    if (mOp.Equal(m$.var("intCol").get(),25)) {
      return null;
    }
    //<< 
    //<< //Filter Estoque Acima EM
    //<< set blnFilterEstoqueAcimaEM = $$FilterEstoqueAcimaEM^VARAlertaLocalUI(idItem,idLocation)
    blnFilterEstoqueAcimaEM.set(m$.fnc$("VARAlertaLocalUI.FilterEstoqueAcimaEM",idItem.get(),idLocation.get()));
    //<< if (blnFilterEstoqueAcimaEM = $$$YES) {
    if ((mOp.Equal(blnFilterEstoqueAcimaEM.get(),include.COMSYS.$$$YES(m$)))) {
      //<< set YBACKGROUNDCOLOR = "#b5c1d7"
      mVar YBACKGROUNDCOLOR = m$.var("YBACKGROUNDCOLOR");
      YBACKGROUNDCOLOR.set("#b5c1d7");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< //Filter Estoque Acima PR
    //<< set blnFilterEstoqueAcimaPR = $$FilterEstoqueAcimaPR^VARAlertaLocalUI(idItem,idLocation)
    blnFilterEstoqueAcimaPR.set(m$.fnc$("VARAlertaLocalUI.FilterEstoqueAcimaPR",idItem.get(),idLocation.get()));
    //<< if (blnFilterEstoqueAcimaPR = $$$YES) {
    if ((mOp.Equal(blnFilterEstoqueAcimaPR.get(),include.COMSYS.$$$YES(m$)))) {
      //<< set YBACKGROUNDCOLOR = "#92d39e"
      mVar YBACKGROUNDCOLOR = m$.var("YBACKGROUNDCOLOR");
      YBACKGROUNDCOLOR.set("#92d39e");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< //Filter Estoque Proximo PR
    //<< set blnFilterEstoqueProximoPR = $$FilterEstoqueProximoPR^VARAlertaLocalUI(idItem,idLocation)
    blnFilterEstoqueProximoPR.set(m$.fnc$("VARAlertaLocalUI.FilterEstoqueProximoPR",idItem.get(),idLocation.get()));
    //<< if (blnFilterEstoqueProximoPR = $$$YES) {
    if ((mOp.Equal(blnFilterEstoqueProximoPR.get(),include.COMSYS.$$$YES(m$)))) {
      //<< set YBACKGROUNDCOLOR = "#f3f2b5"
      mVar YBACKGROUNDCOLOR = m$.var("YBACKGROUNDCOLOR");
      YBACKGROUNDCOLOR.set("#f3f2b5");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< //Filter Estoque Abaixo PR com EP
    //<< set blnFilterEstoqueAbaixoPRcomEP = $$FilterEstoqueAbaixoPRcomEPAcimaPR^VARAlertaLocalUI(idItem,idLocation)
    blnFilterEstoqueAbaixoPRcomEP.set(m$.fnc$("VARAlertaLocalUI.FilterEstoqueAbaixoPRcomEPAcimaPR",idItem.get(),idLocation.get()));
    //<< if (blnFilterEstoqueAbaixoPRcomEP = $$$YES) {
    if ((mOp.Equal(blnFilterEstoqueAbaixoPRcomEP.get(),include.COMSYS.$$$YES(m$)))) {
      //<< set YBACKGROUNDCOLOR = "#f8d08b"
      mVar YBACKGROUNDCOLOR = m$.var("YBACKGROUNDCOLOR");
      YBACKGROUNDCOLOR.set("#f8d08b");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< //Filter Estoque Abaixo PR sem EP
    //<< set blnFilterEstoqueAbaixoPRsemEP = $$FilterEstoqueAbaixoPR^VARAlertaLocalUI(idItem,idLocation)
    blnFilterEstoqueAbaixoPRsemEP.set(m$.fnc$("VARAlertaLocalUI.FilterEstoqueAbaixoPR",idItem.get(),idLocation.get()));
    //<< if (blnFilterEstoqueAbaixoPRsemEP = $$$YES) {
    if ((mOp.Equal(blnFilterEstoqueAbaixoPRsemEP.get(),include.COMSYS.$$$YES(m$)))) {
      //<< set YBACKGROUNDCOLOR = "#e94848"
      mVar YBACKGROUNDCOLOR = m$.var("YBACKGROUNDCOLOR");
      YBACKGROUNDCOLOR.set("#e94848");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< GetCMML(pidLocal,pidItem)
  public Object GetCMML(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit:( (pidLocal = "") || (pidItem = "") ) ""
    if (mOp.Logical(((mOp.Equal(pidLocal.get(),"")) || (mOp.Equal(pidItem.get(),""))))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< quit $$GetCMM^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetCMM",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetCMM(pidItem)
  public Object GetCMM(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< 
    //<< quit $$GetCMM^VARReposicao(pidItem)
    return m$.fnc$("VARReposicao.GetCMM",pidItem.get());
  }

  //<< 
  //<< GetMOV(pidItem)
  public Object GetMOV(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< 
    //<< quit $$GetMOV^VARReposicao(pidItem)
    return m$.fnc$("VARReposicao.GetMOV",pidItem.get());
  }

  //<< 
  //<< GetDMM(pidItem)
  public Object GetDMM(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< 
    //<< quit $$GetDM^VARReposicao(pidItem)
    return m$.fnc$("VARReposicao.GetDM",pidItem.get());
  }

  //<< 
  //<< GetDMML(pidLocal,pidItem)
  public Object GetDMML(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit:( (pidLocal = "") || (pidItem = "") ) ""
    if (mOp.Logical(((mOp.Equal(pidLocal.get(),"")) || (mOp.Equal(pidItem.get(),""))))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< quit $$GetDM^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetDM",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetMOVL(pidLocal,pidItem)
  public Object GetMOVL(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit:( (pidLocal = "") || (pidItem = "") ) ""
    if (mOp.Logical(((mOp.Equal(pidLocal.get(),"")) || (mOp.Equal(pidItem.get(),""))))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< quit $$GetMOV^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetMOV",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetESLocal(pidLocal,pidItem)
  public Object GetESLocal(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< //ESLocal = Estoque de Segurança do Local
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< quit $$GetEstoqueSeguranca^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetEstoqueSeguranca",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetPRLocal(pidLocal,pidItem)
  public Object GetPRLocal(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< //PRLocal = Ponto de Ressuprimento do Local
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< quit $$GetPontoRessuprimento^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetPontoRessuprimento",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetEMLocal(pidLocal,pidItem)
  public Object GetEMLocal(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< //EMLocal = Estoque Máximo do Local
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< quit $$GetEstoqueMaximo^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetEstoqueMaximo",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetEncomendasPendentesReq(pidLocal,pidItem)
  public Object GetEncomendasPendentesReq(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< new fltQtyReqPendente
    mVar fltQtyReqPendente = m$.var("fltQtyReqPendente");
    m$.newVar(fltQtyReqPendente);
    //<< set fltQtyReqPendente = $$GetQuantidadePendenteReq^VARReposicao(pidItem,pidLocal)
    fltQtyReqPendente.set(m$.fnc$("VARReposicao.GetQuantidadePendenteReq",pidItem.get(),pidLocal.get()));
    //<< set fltQtyReqPendente = fltQtyReqPendente+ $$GetQuantidadePendenteCompra^VARReposicao(pidItem,pidLocal)
    fltQtyReqPendente.set(mOp.Add(fltQtyReqPendente.get(),m$.fnc$("VARReposicao.GetQuantidadePendenteCompra",pidItem.get(),pidLocal.get())));
    //<< 
    //<< quit fltQtyReqPendente
    return fltQtyReqPendente.get();
  }

  //<< 
  //<< GetEncomendasPendentesProprietario(pidLocal,pidItem)
  public Object GetEncomendasPendentesProprietario(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< new fltQtyReqPendente
    mVar fltQtyReqPendente = m$.var("fltQtyReqPendente");
    m$.newVar(fltQtyReqPendente);
    //<< //set fltQtyReqPendente = $$GetQuantidadePendenteReq^VARReposicao(pidItem,pidLocal)
    //<< set fltQtyReqPendente = $$GetQuantidadePendenteCompra^VARReposicao(pidItem,pidLocal)
    fltQtyReqPendente.set(m$.fnc$("VARReposicao.GetQuantidadePendenteCompra",pidItem.get(),pidLocal.get()));
    //<< 
    //<< quit fltQtyReqPendente
    return fltQtyReqPendente.get();
  }

  //<< 
  //<< GetEstoqueVirtualLocal(pidLocal,pidItem)
  public Object GetEstoqueVirtualLocal(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit:( (pidLocal = "") || (pidItem = "") ) ""
    if (mOp.Logical(((mOp.Equal(pidLocal.get(),"")) || (mOp.Equal(pidItem.get(),""))))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< quit $$GetEstoqueVirtual^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetEstoqueVirtual",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetEstoqueVirtualProprietario(pidLocal,pidItem)
  public Object GetEstoqueVirtualProprietario(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit:( (pidLocal = "") || (pidItem = "") ) ""
    if (mOp.Logical(((mOp.Equal(pidLocal.get(),"")) || (mOp.Equal(pidItem.get(),""))))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< if pidLocal="" q ""
    if (mOp.Equal(pidLocal.get(),"")) {
      return "";
    }
    //<< quit $$GetEstoqueVirtualProprietario^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetEstoqueVirtualProprietario",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetSugestaoLocal(pidLocal,pidItem,pAgregada=0)
  public Object GetSugestaoLocal(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pAgregada = m$.newVarRef("pAgregada",(((_p!=null)&&(_p.length>=3))?_p[2]:null),0);
    //<< quit:( (pidLocal = "") || (pidItem = "") ) ""
    if (mOp.Logical(((mOp.Equal(pidLocal.get(),"")) || (mOp.Equal(pidItem.get(),""))))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< quit $$GetSugestao^VARReposicao(pidItem,pidLocal,,pAgregada)
    return m$.fnc$("VARReposicao.GetSugestao",pidItem.get(),pidLocal.get(),null,pAgregada.get());
  }

  //<< 
  //<< GetSugestaoProprietario(pidLocal,pidItem,pAgregada=0)
  public Object GetSugestaoProprietario(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pAgregada = m$.newVarRef("pAgregada",(((_p!=null)&&(_p.length>=3))?_p[2]:null),0);
    //<< quit:( (pidLocal = "") || (pidItem = "") ) ""
    if (mOp.Logical(((mOp.Equal(pidLocal.get(),"")) || (mOp.Equal(pidItem.get(),""))))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< quit $$GetSugestaoProprietario^VARReposicao(pidItem,pidLocal,,pAgregada)
    return m$.fnc$("VARReposicao.GetSugestaoProprietario",pidItem.get(),pidLocal.get(),null,pAgregada.get());
  }

  //<< 
  //<< GetCoberturaEstoqueLocal(pidLocal,pidItem)
  public Object GetCoberturaEstoqueLocal(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit:( (pidLocal = "") || (pidItem = "") ) ""
    if (mOp.Logical(((mOp.Equal(pidLocal.get(),"")) || (mOp.Equal(pidItem.get(),""))))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< quit $$GetCoberturaEstoque^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetCoberturaEstoque",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetCoberturaEstoqueProprietario(pidLocal,pidItem)
  public Object GetCoberturaEstoqueProprietario(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit:( (pidLocal = "") || (pidItem = "") ) ""
    if (mOp.Logical(((mOp.Equal(pidLocal.get(),"")) || (mOp.Equal(pidItem.get(),""))))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< if pidLocal="" q ""
    if (mOp.Equal(pidLocal.get(),"")) {
      return "";
    }
    //<< quit $$GetCoberturaEstoqueProprietario^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetCoberturaEstoqueProprietario",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetEstoqueRede(pidItem)
  public Object GetEstoqueRede(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< quit $$GetEstoqueDisponivel^VARReposicao(pidItem)
    return m$.fnc$("VARReposicao.GetEstoqueDisponivel",pidItem.get());
  }

  //<< 
  //<< GetEstoqueLocal(pidItem,pidLocal="")
  public Object GetEstoqueLocal(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< quit $$GetEstoqueDisponivel^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetEstoqueDisponivel",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetEstoqueProprietario(pidItem,pidLocal="")
  public Object GetEstoqueProprietario(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< if pidLocal="Rede" set pidLocal=""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      pidLocal.set("");
    }
    //<< if pidLocal="" q ""
    if (mOp.Equal(pidLocal.get(),"")) {
      return "";
    }
    //<< quit $$GetEstoqueDisponivelProprietario^VARReposicao(pidItem,pidLocal)
    return m$.fnc$("VARReposicao.GetEstoqueDisponivelProprietario",pidItem.get(),pidLocal.get());
  }

  //<< 
  //<< GetEstoqueCentral(pidItem)
  public Object GetEstoqueCentral(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< 
    //<< new cnt, strLocaisCentrais, idLocal, fltEstoqueLocal, fltEstoqueCentral
    mVar cnt = m$.var("cnt");
    mVar strLocaisCentrais = m$.var("strLocaisCentrais");
    mVar idLocal = m$.var("idLocal");
    mVar fltEstoqueLocal = m$.var("fltEstoqueLocal");
    mVar fltEstoqueCentral = m$.var("fltEstoqueCentral");
    m$.newVar(cnt,strLocaisCentrais,idLocal,fltEstoqueLocal,fltEstoqueCentral);
    //<< 
    //<< set strLocaisCentrais = $$getLocaisCentraisEstoque^VARParametroCliente(YM)
    strLocaisCentrais.set(m$.fnc$("VARParametroCliente.getLocaisCentraisEstoque",m$.var("YM").get()));
    //<< quit:(strLocaisCentrais = "") ""
    if ((mOp.Equal(strLocaisCentrais.get(),""))) {
      return "";
    }
    //<< 
    //<< set fltEstoqueCentral = 0
    fltEstoqueCentral.set(0);
    //<< 
    //<< for cnt = 1:1:$length(strLocaisCentrais,";") {
    for (cnt.set(1);(mOp.LessOrEqual(cnt.get(),m$.Fnc.$length(strLocaisCentrais.get(),";")));cnt.set(mOp.Add(cnt.get(),1))) {
      //<< set idLocal = $piece(strLocaisCentrais,";",cnt)
      idLocal.set(m$.Fnc.$piece(strLocaisCentrais.get(),";",cnt.get()));
      //<< quit:(idLocal = "")
      if ((mOp.Equal(idLocal.get(),""))) {
        break;
      }
      //<< 
      //<< set fltEstoqueLocal = $$GetEstoqueDisponivel^VARReposicao(pidItem,idLocal)
      fltEstoqueLocal.set(m$.fnc$("VARReposicao.GetEstoqueDisponivel",pidItem.get(),idLocal.get()));
      //<< set fltEstoqueCentral = fltEstoqueCentral + fltEstoqueLocal
      fltEstoqueCentral.set(mOp.Add(fltEstoqueCentral.get(),fltEstoqueLocal.get()));
    }
    //<< 
    //<< }
    //<< 
    //<< quit fltEstoqueCentral
    return fltEstoqueCentral.get();
  }

  //<< 
  //<< GetEstoqueCD(pidItem)
  public Object GetEstoqueCD(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< 
    //<< new cnt, strLocaisCentrais, idLocal, fltEstoqueLocal, fltEstoqueCentral
    mVar cnt = m$.var("cnt");
    mVar strLocaisCentrais = m$.var("strLocaisCentrais");
    mVar idLocal = m$.var("idLocal");
    mVar fltEstoqueLocal = m$.var("fltEstoqueLocal");
    mVar fltEstoqueCentral = m$.var("fltEstoqueCentral");
    m$.newVar(cnt,strLocaisCentrais,idLocal,fltEstoqueLocal,fltEstoqueCentral);
    //<< 
    //<< set strLocaisCentrais = 1
    strLocaisCentrais.set(1);
    //<< 
    //<< set fltEstoqueCentral = 0
    fltEstoqueCentral.set(0);
    //<< 
    //<< for cnt = 1:1:$length(strLocaisCentrais,";") {
    for (cnt.set(1);(mOp.LessOrEqual(cnt.get(),m$.Fnc.$length(strLocaisCentrais.get(),";")));cnt.set(mOp.Add(cnt.get(),1))) {
      //<< set idLocal = $piece(strLocaisCentrais,";",cnt)
      idLocal.set(m$.Fnc.$piece(strLocaisCentrais.get(),";",cnt.get()));
      //<< quit:(idLocal = "")
      if ((mOp.Equal(idLocal.get(),""))) {
        break;
      }
      //<< 
      //<< set fltEstoqueLocal = $$GetEstoqueDisponivel^VARReposicao(pidItem,idLocal)
      fltEstoqueLocal.set(m$.fnc$("VARReposicao.GetEstoqueDisponivel",pidItem.get(),idLocal.get()));
      //<< set fltEstoqueCentral = fltEstoqueCentral + fltEstoqueLocal
      fltEstoqueCentral.set(mOp.Add(fltEstoqueCentral.get(),fltEstoqueLocal.get()));
    }
    //<< 
    //<< }
    //<< 
    //<< quit fltEstoqueCentral
    return fltEstoqueCentral.get();
  }

  //<< 
  //<< GetEstoqueProgramaPrincipal(pidItem,pidLocal)
  public Object GetEstoqueProgramaPrincipal(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< quit:(pidItem = "") ""
    if ((mOp.Equal(pidItem.get(),""))) {
      return "";
    }
    //<< if pidLocal="Rede" q ""
    if (mOp.Equal(pidLocal.get(),"Rede")) {
      return "";
    }
    //<< q $$GetEstoqueDisponivelProgramaPrincipal^VARReposicao(pidItem,pidLocal,1)
    return m$.fnc$("VARReposicao.GetEstoqueDisponivelProgramaPrincipal",pidItem.get(),pidLocal.get(),1);
  }

  //<< 
  //<< GetSituacaoQtyItensLocal(pidLocal,pProprietario=0)
  public Object GetSituacaoQtyItensLocal(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pProprietario = m$.newVarRef("pProprietario",(((_p!=null)&&(_p.length>=2))?_p[1]:null),0);
    //<< quit:(pidLocal = "") ""
    if ((mOp.Equal(pidLocal.get(),""))) {
      return "";
    }
    //<< 
    //<< new idItem, objItem, itemStatus
    mVar idItem = m$.var("idItem");
    mVar objItem = m$.var("objItem");
    mVar itemStatus = m$.var("itemStatus");
    m$.newVar(idItem,objItem,itemStatus);
    //<< new strStatus, fltEstoqueLocal, fltPRLocal, fltEMLocal, fltESLocal
    mVar strStatus = m$.var("strStatus");
    mVar fltEstoqueLocal = m$.var("fltEstoqueLocal");
    mVar fltPRLocal = m$.var("fltPRLocal");
    mVar fltEMLocal = m$.var("fltEMLocal");
    mVar fltESLocal = m$.var("fltESLocal");
    m$.newVar(strStatus,fltEstoqueLocal,fltPRLocal,fltEMLocal,fltESLocal);
    //<< 
    //<< set countEstoqueZerado      = 0
    mVar countEstoqueZerado = m$.var("countEstoqueZerado");
    countEstoqueZerado.set(0);
    //<< set countEstoqueAbaixoES    = 0
    mVar countEstoqueAbaixoES = m$.var("countEstoqueAbaixoES");
    countEstoqueAbaixoES.set(0);
    //<< set countEstoqueEntreESPR   = 0
    mVar countEstoqueEntreESPR = m$.var("countEstoqueEntreESPR");
    countEstoqueEntreESPR.set(0);
    //<< set countEstoqueEntrePREM   = 0
    mVar countEstoqueEntrePREM = m$.var("countEstoqueEntrePREM");
    countEstoqueEntrePREM.set(0);
    //<< set countEstoqueAcimaEM     = 0
    mVar countEstoqueAcimaEM = m$.var("countEstoqueAcimaEM");
    countEstoqueAcimaEM.set(0);
    //<< 
    //<< $$$Order3(^VARAlertaLocalLinha,YM,pidLocal,idItem)
    idItem.set("");
    for (;true;) {
      idItem.set(m$.Fnc.$order(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),pidLocal.get(),idItem.get())));
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< 
      //<< set objItem      = $get(^INART(YM, idItem, 1))
      objItem.set(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),idItem.get(),1)));
      //<< set itemStatus = $piece(objItem, Y, 66)
      itemStatus.set(m$.Fnc.$piece(objItem.get(),m$.var("Y").get(),66));
      //<< if pProprietario=1 {
      if (mOp.Equal(pProprietario.get(),1)) {
        //<< set fltEstoqueLocal = $$GetEstoqueProprietario^VARAlertaLocalLinha(idItem,pidLocal)
        fltEstoqueLocal.set(m$.fnc$("VARAlertaLocalLinha.GetEstoqueProprietario",idItem.get(),pidLocal.get()));
      }
      //<< }else {
      else {
        //<< set fltEstoqueLocal = $$GetEstoqueLocal^VARAlertaLocalLinha(idItem,pidLocal)
        fltEstoqueLocal.set(m$.fnc$("VARAlertaLocalLinha.GetEstoqueLocal",idItem.get(),pidLocal.get()));
      }
      //<< }
      //<< set fltESLocal      = $$GetESLocal^VARAlertaLocalLinha(pidLocal,idItem)
      fltESLocal.set(m$.fnc$("VARAlertaLocalLinha.GetESLocal",pidLocal.get(),idItem.get()));
      //<< set fltPRLocal      = $$GetPRLocal^VARAlertaLocalLinha(pidLocal,idItem)
      fltPRLocal.set(m$.fnc$("VARAlertaLocalLinha.GetPRLocal",pidLocal.get(),idItem.get()));
      //<< set fltEMLocal      = $$GetEMLocal^VARAlertaLocalLinha(pidLocal,idItem)
      fltEMLocal.set(m$.fnc$("VARAlertaLocalLinha.GetEMLocal",pidLocal.get(),idItem.get()));
      //<< 
      //<< if (fltEstoqueLocal = 0) {
      if ((mOp.Equal(fltEstoqueLocal.get(),0))) {
        //<< set countEstoqueZerado = $i(countEstoqueZerado)
        countEstoqueZerado.set(m$.Fnc.$increment(countEstoqueZerado));
        //<< continue
        continue;
      }
      //<< }
      //<< if (fltEstoqueLocal < fltESLocal) {
      if ((mOp.Less(fltEstoqueLocal.get(),fltESLocal.get()))) {
        //<< set countEstoqueAbaixoES = $i(countEstoqueAbaixoES)
        countEstoqueAbaixoES.set(m$.Fnc.$increment(countEstoqueAbaixoES));
        //<< continue
        continue;
      }
      //<< }
      //<< if (fltEstoqueLocal >= fltESLocal)&&(fltEstoqueLocal < fltPRLocal) {
      if ((mOp.GreaterOrEqual(fltEstoqueLocal.get(),fltESLocal.get())) && (mOp.Less(fltEstoqueLocal.get(),fltPRLocal.get()))) {
        //<< set countEstoqueEntreESPR = $i(countEstoqueEntreESPR)
        countEstoqueEntreESPR.set(m$.Fnc.$increment(countEstoqueEntreESPR));
        //<< continue
        continue;
      }
      //<< }
      //<< if (fltEstoqueLocal >= fltPRLocal)&&(fltEstoqueLocal < fltEMLocal) {
      if ((mOp.GreaterOrEqual(fltEstoqueLocal.get(),fltPRLocal.get())) && (mOp.Less(fltEstoqueLocal.get(),fltEMLocal.get()))) {
        //<< set countEstoqueEntrePREM = $i(countEstoqueEntrePREM)
        countEstoqueEntrePREM.set(m$.Fnc.$increment(countEstoqueEntrePREM));
        //<< continue
        continue;
      }
      //<< }
      //<< if (fltEstoqueLocal >= fltEMLocal) {
      if ((mOp.GreaterOrEqual(fltEstoqueLocal.get(),fltEMLocal.get()))) {
        //<< set countEstoqueAcimaEM = $i(countEstoqueAcimaEM)
        countEstoqueAcimaEM.set(m$.Fnc.$increment(countEstoqueAcimaEM));
        //<< continue
        continue;
      }
    }
    //<< }
    //<< 
    //<< 
    //<< $$$End
    //<< 
    //<< set countTotal = countEstoqueZerado_Y_countEstoqueAbaixoES_Y_countEstoqueEntreESPR_Y_countEstoqueEntrePREM_Y_countEstoqueAcimaEM
    mVar countTotal = m$.var("countTotal");
    countTotal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(countEstoqueZerado.get(),m$.var("Y").get()),countEstoqueAbaixoES.get()),m$.var("Y").get()),countEstoqueEntreESPR.get()),m$.var("Y").get()),countEstoqueEntrePREM.get()),m$.var("Y").get()),countEstoqueAcimaEM.get()));
    //<< 
    //<< quit countTotal
    return countTotal.get();
  }

  //<< 
  //<< GetCoberturaQtyItensLocal(pidLocal,pProprietario=0)
  public Object GetCoberturaQtyItensLocal(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pProprietario = m$.newVarRef("pProprietario",(((_p!=null)&&(_p.length>=2))?_p[1]:null),0);
    //<< quit:(pidLocal = "") ""
    if ((mOp.Equal(pidLocal.get(),""))) {
      return "";
    }
    //<< 
    //<< new idItem, objItem, itemStatus
    mVar idItem = m$.var("idItem");
    mVar objItem = m$.var("objItem");
    mVar itemStatus = m$.var("itemStatus");
    m$.newVar(idItem,objItem,itemStatus);
    //<< new strStatus, fltCoberturaEstoqueLocal, fltPRLocal, fltEMLocal, fltESLocal
    mVar strStatus = m$.var("strStatus");
    mVar fltCoberturaEstoqueLocal = m$.var("fltCoberturaEstoqueLocal");
    mVar fltPRLocal = m$.var("fltPRLocal");
    mVar fltEMLocal = m$.var("fltEMLocal");
    mVar fltESLocal = m$.var("fltESLocal");
    m$.newVar(strStatus,fltCoberturaEstoqueLocal,fltPRLocal,fltEMLocal,fltESLocal);
    //<< 
    //<< set countEstoqueZerado      = 0
    mVar countEstoqueZerado = m$.var("countEstoqueZerado");
    countEstoqueZerado.set(0);
    //<< set countEstoqueAbaixo7 = 0
    mVar countEstoqueAbaixo7 = m$.var("countEstoqueAbaixo7");
    countEstoqueAbaixo7.set(0);
    //<< set countEstoqueEntre7E15   = 0
    mVar countEstoqueEntre7E15 = m$.var("countEstoqueEntre7E15");
    countEstoqueEntre7E15.set(0);
    //<< set countEstoqueEntre15E30  = 0
    mVar countEstoqueEntre15E30 = m$.var("countEstoqueEntre15E30");
    countEstoqueEntre15E30.set(0);
    //<< set countEstoqueAcima30     = 0
    mVar countEstoqueAcima30 = m$.var("countEstoqueAcima30");
    countEstoqueAcima30.set(0);
    //<< 
    //<< $$$Order3(^VARAlertaLocalLinha,YM,pidLocal,idItem)
    idItem.set("");
    for (;true;) {
      idItem.set(m$.Fnc.$order(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),pidLocal.get(),idItem.get())));
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< 
      //<< set objItem      = $get(^INART(YM, idItem, 1))
      objItem.set(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),idItem.get(),1)));
      //<< set itemStatus = $piece(objItem, Y, 66)
      itemStatus.set(m$.Fnc.$piece(objItem.get(),m$.var("Y").get(),66));
      //<< if pProprietario=1 {
      if (mOp.Equal(pProprietario.get(),1)) {
        //<< set fltCoberturaEstoqueLocal    = $$GetCoberturaEstoqueProprietario^VARAlertaLocalLinha(pidLocal,idItem)
        fltCoberturaEstoqueLocal.set(m$.fnc$("VARAlertaLocalLinha.GetCoberturaEstoqueProprietario",pidLocal.get(),idItem.get()));
      }
      //<< }else {
      else {
        //<< set fltCoberturaEstoqueLocal    = $$GetCoberturaEstoqueLocal^VARAlertaLocalLinha(pidLocal,idItem)
        fltCoberturaEstoqueLocal.set(m$.fnc$("VARAlertaLocalLinha.GetCoberturaEstoqueLocal",pidLocal.get(),idItem.get()));
      }
      //<< }
      //<< set fltESLocal      = $$GetESLocal^VARAlertaLocalLinha(pidLocal,idItem)
      fltESLocal.set(m$.fnc$("VARAlertaLocalLinha.GetESLocal",pidLocal.get(),idItem.get()));
      //<< set fltPRLocal      = $$GetPRLocal^VARAlertaLocalLinha(pidLocal,idItem)
      fltPRLocal.set(m$.fnc$("VARAlertaLocalLinha.GetPRLocal",pidLocal.get(),idItem.get()));
      //<< set fltEMLocal      = $$GetEMLocal^VARAlertaLocalLinha(pidLocal,idItem)
      fltEMLocal.set(m$.fnc$("VARAlertaLocalLinha.GetEMLocal",pidLocal.get(),idItem.get()));
      //<< 
      //<< if (fltCoberturaEstoqueLocal = 0) {
      if ((mOp.Equal(fltCoberturaEstoqueLocal.get(),0))) {
        //<< set countEstoqueZerado = $i(countEstoqueZerado)
        countEstoqueZerado.set(m$.Fnc.$increment(countEstoqueZerado));
        //<< continue
        continue;
      }
      //<< }
      //<< if (fltCoberturaEstoqueLocal < 7) {
      if ((mOp.Less(fltCoberturaEstoqueLocal.get(),7))) {
        //<< set countEstoqueAbaixo7 = $i(countEstoqueAbaixo7)
        countEstoqueAbaixo7.set(m$.Fnc.$increment(countEstoqueAbaixo7));
        //<< continue
        continue;
      }
      //<< }
      //<< if (fltCoberturaEstoqueLocal >= 7)&&(fltCoberturaEstoqueLocal < 15) {
      if ((mOp.GreaterOrEqual(fltCoberturaEstoqueLocal.get(),7)) && (mOp.Less(fltCoberturaEstoqueLocal.get(),15))) {
        //<< set countEstoqueEntre7E15 = $i(countEstoqueEntre7E15)
        countEstoqueEntre7E15.set(m$.Fnc.$increment(countEstoqueEntre7E15));
        //<< continue
        continue;
      }
      //<< }
      //<< if (fltCoberturaEstoqueLocal >= 15)&&(fltCoberturaEstoqueLocal < 30) {
      if ((mOp.GreaterOrEqual(fltCoberturaEstoqueLocal.get(),15)) && (mOp.Less(fltCoberturaEstoqueLocal.get(),30))) {
        //<< set countEstoqueEntre15E30 = $i(countEstoqueEntre15E30)
        countEstoqueEntre15E30.set(m$.Fnc.$increment(countEstoqueEntre15E30));
        //<< continue
        continue;
      }
      //<< }
      //<< if (fltCoberturaEstoqueLocal >= 30) {
      if ((mOp.GreaterOrEqual(fltCoberturaEstoqueLocal.get(),30))) {
        //<< set countEstoqueAcima30 = $i(countEstoqueAcima30)
        countEstoqueAcima30.set(m$.Fnc.$increment(countEstoqueAcima30));
        //<< continue
        continue;
      }
    }
    //<< }
    //<< 
    //<< 
    //<< $$$End
    //<< 
    //<< set countTotal = countEstoqueZerado_Y_countEstoqueAbaixo7_Y_countEstoqueEntre7E15_Y_countEstoqueEntre15E30_Y_countEstoqueAcima30
    mVar countTotal = m$.var("countTotal");
    countTotal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(countEstoqueZerado.get(),m$.var("Y").get()),countEstoqueAbaixo7.get()),m$.var("Y").get()),countEstoqueEntre7E15.get()),m$.var("Y").get()),countEstoqueEntre15E30.get()),m$.var("Y").get()),countEstoqueAcima30.get()));
    //<< 
    //<< quit countTotal
    return countTotal.get();
  }

//<< 
}
