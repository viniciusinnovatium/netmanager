package include;
//*****************************************************************************
//** TASC - ALPHALINC - MAC VARAlertaLocalUI
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-01 17:27:35
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

public class VARAlertaLocalUI extends mClass {

  //<< 
  //<< VARAlertaLocalUI
  public Object main() {
    _VARAlertaLocalUI();
    return null;
  }

  public Object _VARAlertaLocalUI() {
    //<< quit
    return null;
  }

  //<< 
  //<< //^VARTempAlertaLocalBuffer(YBED)
  //<< 
  //<< FilterContaContabil(pidItem)
  public Object FilterContaContabil(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new objItem, strCC
    mVar objItem = m$.var("objItem");
    mVar strCC = m$.var("strCC");
    m$.newVar(objItem,strCC);
    //<< set strCC=""
    strCC.set("");
    //<< quit:(pidItem = "") strCC
    if ((mOp.Equal(pidItem.get(),""))) {
      return strCC.get();
    }
    //<< 
    //<< set objItem   = $get(^INART(YM,pidItem,1))
    objItem.set(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),pidItem.get(),1)));
    //<< 
    //<< if (objItem '= "") {
    if ((mOp.NotEqual(objItem.get(),""))) {
      //<< set strCC=$piece(objItem,Y,278)  //Conta Contabil
      strCC.set(m$.Fnc.$piece(objItem.get(),m$.var("Y").get(),278));
    }
    //<< }
    //<< quit strCC
    return strCC.get();
  }

  //<< 
  //<< FilterSugestao(pidItem, pidLocation)
  public Object FilterSugestao(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if pidLocation="Rede" set pidLocation=""
    if (mOp.Equal(pidLocation.get(),"Rede")) {
      pidLocation.set("");
    }
    //<< new fltSugestao
    mVar fltSugestao = m$.var("fltSugestao");
    m$.newVar(fltSugestao);
    //<< set fltSugestao=$$GetSugestao^VARReposicao(pidItem,pidLocation)
    fltSugestao.set(m$.fnc$("VARReposicao.GetSugestao",pidItem.get(),pidLocation.get()));
    //<< if fltSugestao>0 quit $$$YES
    if (mOp.Greater(fltSugestao.get(),0)) {
      return include.COMSYS.$$$YES(m$);
    }
    //<< quit $$$NO
    return include.COMSYS.$$$NO(m$);
  }

  //<< 
  //<< FilterEstoqueLocalZerado(pidItem,pidLocation)
  public Object FilterEstoqueLocalZerado(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if pidLocation="Rede" set pidLocation=""
    if (mOp.Equal(pidLocation.get(),"Rede")) {
      pidLocation.set("");
    }
    //<< new fltEstoqueLocal
    mVar fltEstoqueLocal = m$.var("fltEstoqueLocal");
    m$.newVar(fltEstoqueLocal);
    //<< set fltEstoqueLocal = $$GetEstoqueDisponivel^VARReposicao(pidItem,pidLocation)
    fltEstoqueLocal.set(m$.fnc$("VARReposicao.GetEstoqueDisponivel",pidItem.get(),pidLocation.get()));
    //<< 
    //<< if ( (fltEstoqueLocal = 0) || (fltEstoqueLocal = "") ) {
    if (mOp.Logical(((mOp.Equal(fltEstoqueLocal.get(),0)) || (mOp.Equal(fltEstoqueLocal.get(),""))))) {
      //<< quit $$$YES
      return include.COMSYS.$$$YES(m$);
    }
    //<< }
    //<< 
    //<< quit $$$NO
    return include.COMSYS.$$$NO(m$);
  }

  //<< 
  //<< FilterEstoqueAcimaPR(pidItem,pidLocation)
  public Object FilterEstoqueAcimaPR(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if pidLocation="Rede" set pidLocation=""
    if (mOp.Equal(pidLocation.get(),"Rede")) {
      pidLocation.set("");
    }
    //<< if $get(^VARTempAlertaLocal(YBED,"Visão"))="Programa" q $$FilterEstoqueAcimaPR^VARReposicao(pidItem,pidLocation,1)
    if (mOp.Equal(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão")),"Programa")) {
      return m$.fnc$("VARReposicao.FilterEstoqueAcimaPR",pidItem.get(),pidLocation.get(),1);
    }
    //<< quit $$FilterEstoqueAcimaPR^VARReposicao(pidItem,pidLocation)
    return m$.fnc$("VARReposicao.FilterEstoqueAcimaPR",pidItem.get(),pidLocation.get());
  }

  //<< 
  //<< FilterEstoqueProximoPR(pidItem,pidLocation)
  public Object FilterEstoqueProximoPR(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if pidLocation="Rede" set pidLocation=""
    if (mOp.Equal(pidLocation.get(),"Rede")) {
      pidLocation.set("");
    }
    //<< if $get(^VARTempAlertaLocal(YBED,"Visão"))="Programa" q $$FilterEstoqueProximoPR^VARReposicao(pidItem,pidLocation,1)
    if (mOp.Equal(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão")),"Programa")) {
      return m$.fnc$("VARReposicao.FilterEstoqueProximoPR",pidItem.get(),pidLocation.get(),1);
    }
    //<< quit $$FilterEstoqueProximoPR^VARReposicao(pidItem,pidLocation)
    return m$.fnc$("VARReposicao.FilterEstoqueProximoPR",pidItem.get(),pidLocation.get());
  }

  //<< 
  //<< FilterEstoqueAbaixoPRcomEP(pidItem,pidLocation)
  public Object FilterEstoqueAbaixoPRcomEP(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if pidLocation="Rede" set pidLocation=""
    if (mOp.Equal(pidLocation.get(),"Rede")) {
      pidLocation.set("");
    }
    //<< if $get(^VARTempAlertaLocal(YBED,"Visão"))="Programa" q $$FilterEstoqueAbaixoPRcomEP^VARReposicao(pidItem,pidLocation,1)
    if (mOp.Equal(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão")),"Programa")) {
      return m$.fnc$("VARReposicao.FilterEstoqueAbaixoPRcomEP",pidItem.get(),pidLocation.get(),1);
    }
    //<< quit $$FilterEstoqueAbaixoPRcomEP^VARReposicao(pidItem,pidLocation)
    return m$.fnc$("VARReposicao.FilterEstoqueAbaixoPRcomEP",pidItem.get(),pidLocation.get());
  }

  //<< 
  //<< FilterEstoqueAbaixoPRsemEP(pidItem,pidLocation)
  public Object FilterEstoqueAbaixoPRsemEP(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if pidLocation="Rede" set pidLocation=""
    if (mOp.Equal(pidLocation.get(),"Rede")) {
      pidLocation.set("");
    }
    //<< if $get(^VARTempAlertaLocal(YBED,"Visão"))="Programa" q $$FilterEstoqueAbaixoPRsemEP^VARReposicao(pidItem,pidLocation,1)
    if (mOp.Equal(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão")),"Programa")) {
      return m$.fnc$("VARReposicao.FilterEstoqueAbaixoPRsemEP",pidItem.get(),pidLocation.get(),1);
    }
    //<< quit $$FilterEstoqueAbaixoPRsemEP^VARReposicao(pidItem,pidLocation)
    return m$.fnc$("VARReposicao.FilterEstoqueAbaixoPRsemEP",pidItem.get(),pidLocation.get());
  }

  //<< 
  //<< FilterEstoqueAbaixoPR(pidItem,pidLocation)
  public Object FilterEstoqueAbaixoPR(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if pidLocation="Rede" set pidLocation=""
    if (mOp.Equal(pidLocation.get(),"Rede")) {
      pidLocation.set("");
    }
    //<< if $get(^VARTempAlertaLocal(YBED,"Visão"))="Programa" q $$FilterEstoqueAbaixoPR^VARReposicao(pidItem,pidLocation,1)
    if (mOp.Equal(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão")),"Programa")) {
      return m$.fnc$("VARReposicao.FilterEstoqueAbaixoPR",pidItem.get(),pidLocation.get(),1);
    }
    //<< quit $$FilterEstoqueAbaixoPR^VARReposicao(pidItem,pidLocation)
    return m$.fnc$("VARReposicao.FilterEstoqueAbaixoPR",pidItem.get(),pidLocation.get());
  }

  //<< 
  //<< FilterEstoqueAbaixoPRcomEPAcimaPR(pidItem,pidLocation)
  public Object FilterEstoqueAbaixoPRcomEPAcimaPR(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if pidLocation="Rede" set pidLocation=""
    if (mOp.Equal(pidLocation.get(),"Rede")) {
      pidLocation.set("");
    }
    //<< if $get(^VARTempAlertaLocal(YBED,"Visão"))="Programa" q $$FilterEstoqueAbaixoPRcomEPAcimaPR^VARReposicao(pidItem,pidLocation,1)
    if (mOp.Equal(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão")),"Programa")) {
      return m$.fnc$("VARReposicao.FilterEstoqueAbaixoPRcomEPAcimaPR",pidItem.get(),pidLocation.get(),1);
    }
    //<< quit $$FilterEstoqueAbaixoPRcomEPAcimaPR^VARReposicao(pidItem,pidLocation)
    return m$.fnc$("VARReposicao.FilterEstoqueAbaixoPRcomEPAcimaPR",pidItem.get(),pidLocation.get());
  }

  //<< 
  //<< FilterEstoqueAcimaEM(pidItem,pidLocation)
  public Object FilterEstoqueAcimaEM(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if pidLocation="Rede" set pidLocation=""
    if (mOp.Equal(pidLocation.get(),"Rede")) {
      pidLocation.set("");
    }
    //<< if $get(^VARTempAlertaLocal(YBED,"Visão"))="Programa" q $$FilterEstoqueAcimaEM^VARReposicao(pidItem,pidLocation,1)
    if (mOp.Equal(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão")),"Programa")) {
      return m$.fnc$("VARReposicao.FilterEstoqueAcimaEM",pidItem.get(),pidLocation.get(),1);
    }
    //<< quit $$FilterEstoqueAcimaEM^VARReposicao(pidItem,pidLocation)
    return m$.fnc$("VARReposicao.FilterEstoqueAcimaEM",pidItem.get(),pidLocation.get());
  }

  //<< 
  //<< 
  //<< FilterCoberturaEstoqueLocal(pidItem,pidLocation)
  public Object FilterCoberturaEstoqueLocal(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< if pidLocation="Rede" set pidLocation=""
    if (mOp.Equal(pidLocation.get(),"Rede")) {
      pidLocation.set("");
    }
    //<< new fltCoberturaEstoque
    mVar fltCoberturaEstoque = m$.var("fltCoberturaEstoque");
    m$.newVar(fltCoberturaEstoque);
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< if $get(^VARTempAlertaLocal(YBED,"Visão"))="Programa" q $$GetCoberturaEstoqueProprietario^VARReposicao(pidItem,pidLocation)
    if (mOp.Equal(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão")),"Programa")) {
      return m$.fnc$("VARReposicao.GetCoberturaEstoqueProprietario",pidItem.get(),pidLocation.get());
    }
    //<< set fltCoberturaEstoque = $$GetCoberturaEstoque^VARReposicao(pidItem,pidLocation)
    fltCoberturaEstoque.set(m$.fnc$("VARReposicao.GetCoberturaEstoque",pidItem.get(),pidLocation.get()));
    //<< 
    //<< quit fltCoberturaEstoque
    return fltCoberturaEstoque.get();
  }

  //<< 
  //<< 
  //<< OnAfterDataFields
  public void OnAfterDataFields() {
    //<< new idFiltro
    mVar idFiltro = m$.var("idFiltro");
    m$.newVar(idFiltro);
    //<< set idFiltro = YAUSWAHL
    idFiltro.set(m$.var("YAUSWAHL").get());
    //<< 
    //<< do LoadGrid(YKEY,idFiltro)
    m$.Cmd.Do("LoadGrid",m$.var("YKEY").get(),idFiltro.get());
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< LoadGrid(YKEY,pidFiltro)
  public Object LoadGrid(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFiltro = m$.newVarRef("pidFiltro",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< new idGrupo, visão
    mVar idGrupo = m$.var("idGrupo");
    mVar visão = m$.var("visão");
    m$.newVar(idGrupo,visão);
    //<< set visão="" //Default
    visão.set("");
    //<< set idFilter = $piece(pidFiltro,"-",1)
    mVar idFilter = m$.var("idFilter");
    idFilter.set(m$.Fnc.$piece(pidFiltro.get(),"-",1));
    //<< set idGrupo  = $piece(pidFiltro,"-",2)
    idGrupo.set(m$.Fnc.$piece(pidFiltro.get(),"-",2));
    //<< set visão  = $piece(pidFiltro,"-",3)
    visão.set(m$.Fnc.$piece(pidFiltro.get(),"-",3));
    //<< 
    //<< 
    //<< set $$$COMGridEditParameterSharedForm(YAUSWAHL)          = $$$YES
    include.COMConst.$$$COMGridEditParameterSharedFormSet(m$,m$.var("YAUSWAHL"),include.COMSYS.$$$YES(m$));
    //<< set $$$COMGridEditParameterMaximumHeight(YAUSWAHL)       = 1
    include.COMConst.$$$COMGridEditParameterMaximumHeightSet(m$,m$.var("YAUSWAHL"),1);
    //<< set $$$COMGridEditParameterGridName(YAUSWAHL)            = "VARAlertaLocalLinha"
    include.COMConst.$$$COMGridEditParameterGridNameSet(m$,m$.var("YAUSWAHL"),"VARAlertaLocalLinha");
    //<< set $$$COMGridEditParameterEnabled(YAUSWAHL)             = $$$YES
    include.COMConst.$$$COMGridEditParameterEnabledSet(m$,m$.var("YAUSWAHL"),include.COMSYS.$$$YES(m$));
    //<< set $$$COMGridEditParameterContainer(YAUSWAHL)           = "VARAlertaLocal"
    include.COMConst.$$$COMGridEditParameterContainerSet(m$,m$.var("YAUSWAHL"),"VARAlertaLocal");
    //<< set $$$COMGridEditParameterDontUpdateContainer(YAUSWAHL) = $$$YES
    include.COMConst.$$$COMGridEditParameterDontUpdateContainerSet(m$,m$.var("YAUSWAHL"),include.COMSYS.$$$YES(m$));
    //<< set $$$COMGridEditParameterDontStoreAll(YAUSWAHL)        = $$$YES
    include.COMConst.$$$COMGridEditParameterDontStoreAllSet(m$,m$.var("YAUSWAHL"),include.COMSYS.$$$YES(m$));
    //<< set $$$COMGridEditParameterCOMViewGrid(YAUSWAHL)         = $$$YES
    include.COMConst.$$$COMGridEditParameterCOMViewGridSet(m$,m$.var("YAUSWAHL"),include.COMSYS.$$$YES(m$));
    //<< 
    //<< $$$ClearExternalFilter(YFORM)
    include.COMView.$$$ClearExternalFilter(m$,m$.var("YFORM"));
    //<< 
    //<< //Defining location to display Alerta
    //<< new idLocation
    mVar idLocation = m$.var("idLocation");
    m$.newVar(idLocation);
    //<< if $get(^VARTempAlertaLocal(YBED)) '= "" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get())),"")) {
      //<< set idLocation = $get(^VARTempAlertaLocal(YBED))
      idLocation.set(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get())));
      //<< if visão="" {
      if (mOp.Equal(visão.get(),"")) {
        //<< set visão=$get(^VARTempAlertaLocal(YBED,"Visão"))
        visão.set(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão")));
      }
      //<< } else {
      else {
        //<< set ^VARTempAlertaLocal(YBED,"Visão")=visão
        m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão").set(visão.get());
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set idLocation = YLOCATION
      idLocation.set(m$.var("YLOCATION").get());
    }
    //<< }
    //<< 
    //<< do AddExternalFilter^COMViewFilter(YFORM, "P1", idLocation, $$$EnumCOMVIEWCOMPARATOREquals, $$$NO)
    m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"P1",idLocation.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$),include.COMSYS.$$$NO(m$));
    //<< //do AddExternalFilter^COMViewFilter(YFORM, "C2", "", $$$EnumCOMVIEWCOMPARATORStartsWith, $$$YES)  ;Código do Produto
    //<< do AddExternalFilter^COMViewFilter(YFORM, "C3", "", $$$EnumCOMVIEWCOMPARATORContains, $$$YES)    ;Descrição do Produto
    m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"C3","",include.COMConst.$$$EnumCOMVIEWCOMPARATORContains(m$),include.COMSYS.$$$YES(m$));
    //<< if (idGrupo '= "") {
    if ((mOp.NotEqual(idGrupo.get(),""))) {
      //<< do AddExternalFilter^COMViewFilter(YFORM, "C15", idGrupo, $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
      m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"C15",idGrupo.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$),include.COMSYS.$$$YES(m$));
    }
    //<< } else {
    else {
      //<< do AddExternalFilter^COMViewFilter(YFORM, "C15", "", $$$EnumCOMVIEWCOMPARATORStartsWith, $$$YES)
      m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"C15","",include.COMConst.$$$EnumCOMVIEWCOMPARATORStartsWith(m$),include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< if ($extract(idFilter) = 6) {
    if ((mOp.Equal(m$.Fnc.$extract(idFilter.get()),6))) {
      //<< do AddExternalFilter^COMViewFilter(YFORM, "C18", $extract(idFilter,2,$length(idFilter)), $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
      m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"C18",m$.Fnc.$extract(idFilter.get(),2,m$.Fnc.$length(idFilter.get())),include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$),include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } else {
    else {
    }
    //<< ;do AddExternalFilter^COMViewFilter(YFORM, "C9", "", $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
    //<< }
    //<< //do AddExternalFilter^COMViewFilter(YFORM, "C7", "", $$$EnumCOMVIEWCOMPARATORStartsWith, $$$YES) ;Grupo do Produto
    //<< do AddExternalFilter^COMViewFilter(YFORM, "C5", "", $$$EnumCOMVIEWCOMPARATORStartsWith, $$$YES)   ;Curva ABC
    m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"C5","",include.COMConst.$$$EnumCOMVIEWCOMPARATORStartsWith(m$),include.COMSYS.$$$YES(m$));
    //<< //do AddExternalFilter^COMViewFilter(YFORM, "C6", "", $$$EnumCOMVIEWCOMPARATORStartsWith, $$$YES)   ;Índice de Criticidade
    //<< do AddExternalFilter^COMViewFilter(YFORM, "C14", "", $$$EnumCOMVIEWCOMPARATORStartsWith, $$$YES)  ;Cobertura de Estoque
    m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"C14","",include.COMConst.$$$EnumCOMVIEWCOMPARATORStartsWith(m$),include.COMSYS.$$$YES(m$));
    //<< ;Filtra estoque abaixo do ponto de ressuprimento sem pedido
    //<< if (idFilter = 4) {
    if ((mOp.Equal(idFilter.get(),4))) {
      //<< do AddExternalFilter^COMViewFilter(YFORM, "C16", 1, $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
      m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"C16",1,include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$),include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } else {
    else {
    }
    //<< ;do AddExternalFilter^COMViewFilter(YFORM, "C9", "", $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
    //<< }
    //<< 
    //<< ;Filtra estoque abaixo do ponto de ressuprimento com pedido
    //<< if (idFilter = 3) {
    if ((mOp.Equal(idFilter.get(),3))) {
      //<< do AddExternalFilter^COMViewFilter(YFORM, "C17", 1, $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
      m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"C17",1,include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$),include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } else {
    else {
    }
    //<< ;do AddExternalFilter^COMViewFilter(YFORM, "C10", "", $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
    //<< }
    //<< 
    //<< 
    //<< ;Filtra estoque próximo do ponto de ressuprimento
    //<< if (idFilter = 2) {
    if ((mOp.Equal(idFilter.get(),2))) {
      //<< do AddExternalFilter^COMViewFilter(YFORM, "C11", 1, $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
      m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"C11",1,include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$),include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } else {
    else {
    }
    //<< ;do AddExternalFilter^COMViewFilter(YFORM, "C11", 0, $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
    //<< }
    //<< 
    //<< ;Filtra estoque acima do ponto de ressuprimento
    //<< if (idFilter = 1) {
    if ((mOp.Equal(idFilter.get(),1))) {
      //<< do AddExternalFilter^COMViewFilter(YFORM, "C12", 1, $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
      m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"C12",1,include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$),include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } else {
    else {
    }
    //<< ;do AddExternalFilter^COMViewFilter(YFORM, "C12", "", $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
    //<< }
    //<< 
    //<< ;Filtra estoque acima do estoque máximo
    //<< if (idFilter = 5) {
    if ((mOp.Equal(idFilter.get(),5))) {
      //<< do AddExternalFilter^COMViewFilter(YFORM, "C13", 1, $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
      m$.Cmd.Do("COMViewFilter.AddExternalFilter",m$.var("YFORM").get(),"C13",1,include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$),include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } else {
    else {
    }
    //<< ;do AddExternalFilter^COMViewFilter(YFORM, "C13", "", $$$EnumCOMVIEWCOMPARATOREquals, $$$YES)
    //<< }
    //<< 
    //<< 
    //<< //Customizando a visão do alerta
    //<< 
    //<< if visão="Programa" {
    if (mOp.Equal(visão.get(),"Programa")) {
      //<< set $$$COMGridEditParameterHiddenColumns(YAUSWAHL) = "8;23;24;14;15;16;17;22"
      include.COMConst.$$$COMGridEditParameterHiddenColumnsSet(m$,m$.var("YAUSWAHL"),"8;23;24;14;15;16;17;22");
    }
    //<< }
    //<< 
    //<< if visão="Rede" {
    if (mOp.Equal(visão.get(),"Rede")) {
      //<< set $$$COMGridEditParameterHiddenColumns(YAUSWAHL) = "8;23;24;28;29;30;31;32;33"
      include.COMConst.$$$COMGridEditParameterHiddenColumnsSet(m$,m$.var("YAUSWAHL"),"8;23;24;28;29;30;31;32;33");
    }
    //<< }
    //<< if visão="" {
    if (mOp.Equal(visão.get(),"")) {
      //<< set $$$COMGridEditParameterHiddenColumns(YAUSWAHL) = "1;6;11;12;13;9;21;22;28;29;30;31;32;33"
      include.COMConst.$$$COMGridEditParameterHiddenColumnsSet(m$,m$.var("YAUSWAHL"),"1;6;11;12;13;9;21;22;28;29;30;31;32;33");
    }
    //<< }
    //<< 
    //<< //Habilitar Botão para excluir produtos do alerta, apenas para o perfil Planejamento - ADM
    //<< set objUser=$get(^WWW013(YM,YBED,1))
    mVar objUser = m$.var("objUser");
    objUser.set(m$.Fnc.$get(m$.var("^WWW013",m$.var("YM").get(),m$.var("YBED").get(),1)));
    //<< set showRemoveOption=$$$NO
    mVar showRemoveOption = m$.var("showRemoveOption");
    showRemoveOption.set(include.COMSYS.$$$NO(m$));
    //<< if objUser'="" {
    if (mOp.NotEqual(objUser.get(),"")) {
      //<< set profileList=$piece(objUser,Y,3)
      mVar profileList = m$.var("profileList");
      profileList.set(m$.Fnc.$piece(objUser.get(),m$.var("Y").get(),3));
      //<< set profileList=$LISTFROMSTRING(profileList,";")
      profileList.set(m$.Fnc.$listfromstring(profileList.get(),";"));
      //<< if $LISTFIND(profileList,1)'=0 set showRemoveOption=$$$YES
      if (mOp.NotEqual(m$.Fnc.$listfind(profileList.get(),1),0)) {
        showRemoveOption.set(include.COMSYS.$$$YES(m$));
      }
      //<< if $LISTFIND(profileList,170)'=0 set showRemoveOption=$$$YES
      if (mOp.NotEqual(m$.Fnc.$listfind(profileList.get(),170),0)) {
        showRemoveOption.set(include.COMSYS.$$$YES(m$));
      }
      //<< if $LISTFIND(profileList,"VARAlertaLocal-ADM")'=0 set showRemoveOption=$$$YES
      if (mOp.NotEqual(m$.Fnc.$listfind(profileList.get(),"VARAlertaLocal-ADM"),0)) {
        showRemoveOption.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< 
    //<< if showRemoveOption=$$$NO {
    if (mOp.Equal(showRemoveOption.get(),include.COMSYS.$$$NO(m$))) {
      //<< if $$$COMGridEditParameterHiddenColumns(YAUSWAHL)'="" {
      if (mOp.NotEqual(include.COMConst.$$$COMGridEditParameterHiddenColumns(m$,m$.var("YAUSWAHL")),"")) {
        //<< set $$$COMGridEditParameterHiddenColumns(YAUSWAHL) =$$$COMGridEditParameterHiddenColumns(YAUSWAHL)_";35"
        include.COMConst.$$$COMGridEditParameterHiddenColumnsSet(m$,m$.var("YAUSWAHL"),mOp.Concat(include.COMConst.$$$COMGridEditParameterHiddenColumns(m$,m$.var("YAUSWAHL")),";35"));
      }
      //<< } else {
      else {
        //<< set $$$COMGridEditParameterHiddenColumns(YAUSWAHL) ="35"
        include.COMConst.$$$COMGridEditParameterHiddenColumnsSet(m$,m$.var("YAUSWAHL"),"35");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< $$$GRIDStart("VARAlertaLocalLinha",idLocation)
    include.COMGridEdit31Interface.$$$GRIDStart(m$,"VARAlertaLocalLinha",idLocation);
    //<< do LoadCOMViewGrid^COMViewFilter("VARAlertaLocal", "VARAlertaLocalLinha")
    m$.Cmd.Do("COMViewFilter.LoadCOMViewGrid","VARAlertaLocal","VARAlertaLocalLinha");
    //<< do MostrarLegenda
    m$.Cmd.Do("MostrarLegenda");
    //<< w "<br>"
    m$.Cmd.Write("<br>");
    //<< //do MostrarLegendaContaContabil
    //<< quit
    return null;
  }

  //<< 
  //<< OnBeforeFormConstruction(YKEY)
  public Object OnBeforeFormConstruction(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< kill ^VARTempAlertaLocal(YBED)
    m$.var("^VARTempAlertaLocal",m$.var("YBED").get()).kill();
    //<< kill ^VARTempAlertaLocalCache(YBED)
    m$.var("^VARTempAlertaLocalCache",m$.var("YBED").get()).kill();
    //<< if YPARA="Rede" {
    if (mOp.Equal(m$.var("YPARA").get(),"Rede")) {
      //<< set YKEY="Rede"
      YKEY.set("Rede");
      //<< set ^VARTempAlertaLocal(YBED,"Visão")="Rede"
      m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão").set("Rede");
    }
    //<< }
    //<< if YAUSWAHL="Rede"  {
    if (mOp.Equal(m$.var("YAUSWAHL").get(),"Rede")) {
      //<< set YKEY="Rede"
      YKEY.set("Rede");
      //<< set ^VARTempAlertaLocal(YBED,"Visão")="Rede"
      m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão").set("Rede");
    }
    //<< }
    //<< if YPARA="Programa" {
    if (mOp.Equal(m$.var("YPARA").get(),"Programa")) {
      //<< set YPARA=""
      mVar YPARA = m$.var("YPARA");
      YPARA.set("");
      //<< set ^VARTempAlertaLocal(YBED,"Visão")="Programa"
      m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão").set("Programa");
    }
    //<< }
    //<< if YAUSWAHL="Programa"  {
    if (mOp.Equal(m$.var("YAUSWAHL").get(),"Programa")) {
      //<< set YAUSWAHL=""
      mVar YAUSWAHL = m$.var("YAUSWAHL");
      YAUSWAHL.set("");
      //<< set ^VARTempAlertaLocal(YBED,"Visão")="Programa"
      m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão").set("Programa");
    }
    //<< }
    //<< if ((YKEY="") && (YPARA'=""))   set YKEY=YPARA
    if (mOp.Logical(((mOp.Equal(YKEY.get(),"")) && (mOp.NotEqual(m$.var("YPARA").get(),""))))) {
      YKEY.set(m$.var("YPARA").get());
    }
    //<< if ((YKEY="") && (YAUSWAHL'=""))    set YKEY=YAUSWAHL
    if (mOp.Logical(((mOp.Equal(YKEY.get(),"")) && (mOp.NotEqual(m$.var("YAUSWAHL").get(),""))))) {
      YKEY.set(m$.var("YAUSWAHL").get());
    }
    //<< if YKEY="" set YKEY=YLOCATION
    if (mOp.Equal(YKEY.get(),"")) {
      YKEY.set(m$.var("YLOCATION").get());
    }
    //<< if (YKEY '= "") {
    if ((mOp.NotEqual(YKEY.get(),""))) {
      //<< set ^VARTempAlertaLocal(YBED) = YKEY
      m$.var("^VARTempAlertaLocal",m$.var("YBED").get()).set(YKEY.get());
    }
    //<< } else {
    else {
      //<< set ^VARTempAlertaLocal(YBED) = YLOCATION
      m$.var("^VARTempAlertaLocal",m$.var("YBED").get()).set(m$.var("YLOCATION").get());
    }
    //<< }
    //<< if $GET(YAUSWAHL)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YAUSWAHL")),"")) {
      //<< set ^VARTempAlertaLocal(YBED,"Parameter") = YAUSWAHL
      m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Parameter").set(m$.var("YAUSWAHL").get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< //Changes to allow the creation of purchase orders and transfer requests
  //<< 
  //<< SalvarAlerta(pYKEY)
  public Object SalvarAlerta(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< kill ^CacheTempMultiLock("VARAlertaLocal")
    m$.var("^CacheTempMultiLock","VARAlertaLocal").kill();
    //<< set strStatus=$$$OK
    mVar strStatus = m$.var("strStatus");
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set strStatus=$$$GRIDSave(pYKEY)
    strStatus.set(include.COMGridEdit31Interface.$$$GRIDSave(m$,pYKEY));
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< CriarPedidoCompra(pYKEY)
  public Object CriarPedidoCompra(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< new idLocation, idItem, arrAlertaLinhas, objAlertaLinha, fltQuantidade, strStatus, arrDocs
    mVar idLocation = m$.var("idLocation");
    mVar idItem = m$.var("idItem");
    mVar arrAlertaLinhas = m$.var("arrAlertaLinhas");
    mVar objAlertaLinha = m$.var("objAlertaLinha");
    mVar fltQuantidade = m$.var("fltQuantidade");
    mVar strStatus = m$.var("strStatus");
    mVar arrDocs = m$.var("arrDocs");
    m$.newVar(idLocation,idItem,arrAlertaLinhas,objAlertaLinha,fltQuantidade,strStatus,arrDocs);
    //<< IF pYKEY="" set pYKEY=$get(^VARTempAlertaLocal(YBED))
    if (mOp.Equal(pYKEY.get(),"")) {
      pYKEY.set(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get())));
    }
    //<< set strStatus=$$SalvarAlerta(pYKEY)
    strStatus.set(m$.fnc$("SalvarAlerta",pYKEY.get()));
    //<< 
    //<< IF $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Alert("Não foi possível salvar os dados, por favor tente novamente.")
      include.COMSYS.$$$Alert(m$,"Não foi possível salvar os dados, por favor tente novamente.");
      //<< do ReloadForm^COMUtilForm()
      m$.Cmd.Do("COMUtilForm.ReloadForm");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< //set idLocalPai = $extract(YLOCATION,1,1)
    //<< set idLocalPai = pYKEY
    mVar idLocalPai = m$.var("idLocalPai");
    idLocalPai.set(pYKEY.get());
    //<< $$$Order3(^VARAlertaLocalLinha,YM,idLocalPai,idItem)
    idItem.set("");
    for (;true;) {
      idItem.set(m$.Fnc.$order(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocalPai.get(),idItem.get())));
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< 
      //<< set objAlertaLinha = $get(^VARAlertaLocalLinha(YM, idLocalPai, idItem, 1))
      objAlertaLinha.set(m$.Fnc.$get(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocalPai.get(),idItem.get(),1)));
      //<< set fltQuantidade  = $$$VARAlertaLocalLinhaQuantidade(objAlertaLinha)
      fltQuantidade.set(include.VARConst.$$$VARAlertaLocalLinhaQuantidade(m$,objAlertaLinha));
      //<< if ((fltQuantidade'="") && (fltQuantidade>0)) set arrAlertaLinhas(idLocalPai, idItem) = fltQuantidade
      if (mOp.Logical(((mOp.NotEqual(fltQuantidade.get(),"")) && (mOp.Greater(fltQuantidade.get(),0))))) {
        arrAlertaLinhas.var(idLocalPai.get(),idItem.get()).set(fltQuantidade.get());
      }
    }
    //<< 
    //<< $$$End
    //<< 
    //<< if '$data(arrAlertaLinhas) {
    if (mOp.Not(m$.Fnc.$data(arrAlertaLinhas))) {
      //<< $$$Alert("Nenhuma linha foi selecionada.")
      include.COMSYS.$$$Alert(m$,"Nenhuma linha foi selecionada.");
      //<< do ReloadForm^COMUtilForm()
      m$.Cmd.Do("COMUtilForm.ReloadForm");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< ;for i=1:1:100 hang 1
    //<< 
    //<< set strStatus = $$CriarPedidoCompra^VARAlertaLocalBIZ(.arrAlertaLinhas, .arrDocs)
    strStatus.set(m$.fnc$("VARAlertaLocalBIZ.CriarPedidoCompra",arrAlertaLinhas,arrDocs));
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< 
      //<< do ClearSelectedLines(.arrAlertaLinhas)
      m$.Cmd.Do("ClearSelectedLines",arrAlertaLinhas);
      //<< // A rotina SourceTxn^INReqSource já emitia um alerta. Mas, comentei para evitar duas msgs. Veja SR BR014697
      //<< //$$$StartScript()
      //<< //write "alert('"_$$PrepareMsg^VARSESINReqSource(.arrDocs)_"');"
      //<< //$$$EndScript()
      //<< 
      //<< if ( $data(arrDocs("PurchaseRequest") ) ) {
      if (mOp.Logical((m$.Fnc.$data(arrDocs.var("PurchaseRequest"))))) {
        //<< do GoToForm^COMUtilForm("VARPedidoCompra", $order(arrDocs("PurchaseRequest","")), 1, "")
        m$.Cmd.Do("COMUtilForm.GoToForm","VARPedidoCompra",m$.Fnc.$order(arrDocs.var("PurchaseRequest","")),1,"");
      }
      //<< }
      //<< else {
      else {
        //<< do ReloadForm^COMUtilForm()
        m$.Cmd.Do("COMUtilForm.ReloadForm");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CriarOrdemCompra(pYKEY)
  public Object CriarOrdemCompra(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< new idLocation, idItem, arrAlertaLinhas, objAlertaLinha, fltQuantidade, strStatus, arrDocs
    mVar idLocation = m$.var("idLocation");
    mVar idItem = m$.var("idItem");
    mVar arrAlertaLinhas = m$.var("arrAlertaLinhas");
    mVar objAlertaLinha = m$.var("objAlertaLinha");
    mVar fltQuantidade = m$.var("fltQuantidade");
    mVar strStatus = m$.var("strStatus");
    mVar arrDocs = m$.var("arrDocs");
    m$.newVar(idLocation,idItem,arrAlertaLinhas,objAlertaLinha,fltQuantidade,strStatus,arrDocs);
    //<< IF pYKEY="" set pYKEY=$get(^VARTempAlertaLocal(YBED))
    if (mOp.Equal(pYKEY.get(),"")) {
      pYKEY.set(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get())));
    }
    //<< set strStatus=$$SalvarAlerta(pYKEY)
    strStatus.set(m$.fnc$("SalvarAlerta",pYKEY.get()));
    //<< 
    //<< IF $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Alert("Não foi possível salvar os dados, por favor tente novamente.")
      include.COMSYS.$$$Alert(m$,"Não foi possível salvar os dados, por favor tente novamente.");
      //<< do ReloadForm^COMUtilForm()
      m$.Cmd.Do("COMUtilForm.ReloadForm");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< //set idLocalPai = $extract(YLOCATION,1,1)
    //<< set idLocalPai = pYKEY
    mVar idLocalPai = m$.var("idLocalPai");
    idLocalPai.set(pYKEY.get());
    //<< $$$Order3(^VARAlertaLocalLinha,YM,idLocalPai,idItem)
    idItem.set("");
    for (;true;) {
      idItem.set(m$.Fnc.$order(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocalPai.get(),idItem.get())));
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< 
      //<< set objAlertaLinha = $get(^VARAlertaLocalLinha(YM, idLocalPai, idItem, 1))
      objAlertaLinha.set(m$.Fnc.$get(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocalPai.get(),idItem.get(),1)));
      //<< set fltQuantidade  = $$$VARAlertaLocalLinhaQuantidade(objAlertaLinha)
      fltQuantidade.set(include.VARConst.$$$VARAlertaLocalLinhaQuantidade(m$,objAlertaLinha));
      //<< if ((fltQuantidade'="") && (fltQuantidade>0)) set arrAlertaLinhas(idLocalPai, idItem) = fltQuantidade
      if (mOp.Logical(((mOp.NotEqual(fltQuantidade.get(),"")) && (mOp.Greater(fltQuantidade.get(),0))))) {
        arrAlertaLinhas.var(idLocalPai.get(),idItem.get()).set(fltQuantidade.get());
      }
    }
    //<< 
    //<< $$$End
    //<< 
    //<< if '$data(arrAlertaLinhas) {
    if (mOp.Not(m$.Fnc.$data(arrAlertaLinhas))) {
      //<< $$$Alert("Nenhuma linha foi selecionada.")
      include.COMSYS.$$$Alert(m$,"Nenhuma linha foi selecionada.");
      //<< do ReloadForm^COMUtilForm()
      m$.Cmd.Do("COMUtilForm.ReloadForm");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< ;for i=1:1:100 hang 1
    //<< 
    //<< set strStatus = $$CriarOrdemCompra^VARAlertaLocalBIZ(.arrAlertaLinhas, .arrDocs)
    strStatus.set(m$.fnc$("VARAlertaLocalBIZ.CriarOrdemCompra",arrAlertaLinhas,arrDocs));
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< 
      //<< do ClearSelectedLines(.arrAlertaLinhas)
      m$.Cmd.Do("ClearSelectedLines",arrAlertaLinhas);
      //<< // A rotina SourceTxn^INReqSource já emitia um alerta. Mas, comentei para evitar duas msgs. Veja SR BR014697
      //<< //$$$StartScript()
      //<< //write "alert('"_$$PrepareMsg^VARSESINReqSource(.arrDocs)_"');"
      //<< //$$$EndScript()
      //<< 
      //<< if ( $data(arrDocs("Purchase") ) ) {
      if (mOp.Logical((m$.Fnc.$data(arrDocs.var("Purchase"))))) {
        //<< do GoToForm^COMUtilForm("VARCompra", $order(arrDocs("Purchase","")), 1, "")
        m$.Cmd.Do("COMUtilForm.GoToForm","VARCompra",m$.Fnc.$order(arrDocs.var("Purchase","")),1,"");
      }
      //<< }
      //<< else {
      else {
        //<< do ReloadForm^COMUtilForm()
        m$.Cmd.Do("COMUtilForm.ReloadForm");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CriarRequisicao(pYKEY)
  public Object CriarRequisicao(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< new idLocation, idItem, arrAlertaLinhas, objAlertaLinha, fltQuantidade, strStatus, arrDocs
    mVar idLocation = m$.var("idLocation");
    mVar idItem = m$.var("idItem");
    mVar arrAlertaLinhas = m$.var("arrAlertaLinhas");
    mVar objAlertaLinha = m$.var("objAlertaLinha");
    mVar fltQuantidade = m$.var("fltQuantidade");
    mVar strStatus = m$.var("strStatus");
    mVar arrDocs = m$.var("arrDocs");
    m$.newVar(idLocation,idItem,arrAlertaLinhas,objAlertaLinha,fltQuantidade,strStatus,arrDocs);
    //<< IF pYKEY="" set pYKEY=$get(^VARTempAlertaLocal(YBED))
    if (mOp.Equal(pYKEY.get(),"")) {
      pYKEY.set(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get())));
    }
    //<< set strStatus=$$SalvarAlerta(pYKEY)
    strStatus.set(m$.fnc$("SalvarAlerta",pYKEY.get()));
    //<< 
    //<< IF $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Alert("Não foi possível salvar os dados, por favor tente novamente.")
      include.COMSYS.$$$Alert(m$,"Não foi possível salvar os dados, por favor tente novamente.");
      //<< do ReloadForm^COMUtilForm()
      m$.Cmd.Do("COMUtilForm.ReloadForm");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< //set idLocalPai = $extract(YLOCATION,1,1)
    //<< set idLocalPai = pYKEY
    mVar idLocalPai = m$.var("idLocalPai");
    idLocalPai.set(pYKEY.get());
    //<< $$$Order3(^VARAlertaLocalLinha,YM,idLocalPai,idItem)
    idItem.set("");
    for (;true;) {
      idItem.set(m$.Fnc.$order(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocalPai.get(),idItem.get())));
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< 
      //<< set objAlertaLinha = $get(^VARAlertaLocalLinha(YM, idLocalPai, idItem, 1))
      objAlertaLinha.set(m$.Fnc.$get(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocalPai.get(),idItem.get(),1)));
      //<< set fltQuantidade  = $$$VARAlertaLocalLinhaQuantidade(objAlertaLinha)
      fltQuantidade.set(include.VARConst.$$$VARAlertaLocalLinhaQuantidade(m$,objAlertaLinha));
      //<< if ((fltQuantidade'="") && (fltQuantidade>0)) set arrAlertaLinhas(idLocalPai, idItem) = fltQuantidade
      if (mOp.Logical(((mOp.NotEqual(fltQuantidade.get(),"")) && (mOp.Greater(fltQuantidade.get(),0))))) {
        arrAlertaLinhas.var(idLocalPai.get(),idItem.get()).set(fltQuantidade.get());
      }
    }
    //<< 
    //<< $$$End
    //<< 
    //<< if '$data(arrAlertaLinhas) {
    if (mOp.Not(m$.Fnc.$data(arrAlertaLinhas))) {
      //<< $$$Alert("Nenhuma linha foi selecionada.")
      include.COMSYS.$$$Alert(m$,"Nenhuma linha foi selecionada.");
      //<< do ReloadForm^COMUtilForm()
      m$.Cmd.Do("COMUtilForm.ReloadForm");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< ;for i=1:1:100 hang 1
    //<< 
    //<< set strStatus = $$CriarRequisicao^VARAlertaLocalBIZ(.arrAlertaLinhas, .arrDocs)
    strStatus.set(m$.fnc$("VARAlertaLocalBIZ.CriarRequisicao",arrAlertaLinhas,arrDocs));
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< 
      //<< do ClearSelectedLines(.arrAlertaLinhas)
      m$.Cmd.Do("ClearSelectedLines",arrAlertaLinhas);
      //<< // A rotina SourceTxn^INReqSource já emitia um alerta. Mas, comentei para evitar duas msgs. Veja SR BR014697
      //<< //$$$StartScript()
      //<< //write "alert('"_$$PrepareMsg^VARSESINReqSource(.arrDocs)_"');"
      //<< //$$$EndScript()
      //<< 
      //<< if ( $data(arrDocs("Requisition") ) ) {
      if (mOp.Logical((m$.Fnc.$data(arrDocs.var("Requisition"))))) {
        //<< do GoToForm^COMUtilForm("INReq", $order(arrDocs("Requisition","")), 1, "")
        m$.Cmd.Do("COMUtilForm.GoToForm","INReq",m$.Fnc.$order(arrDocs.var("Requisition","")),1,"");
      }
      //<< }
      //<< else {
      else {
        //<< do ReloadForm^COMUtilForm()
        m$.Cmd.Do("COMUtilForm.ReloadForm");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CriarRequisicaoAutomatica(pYKEY)
  public Object CriarRequisicaoAutomatica(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< new idLocation, idItem, arrAlertaLinhas, objAlertaLinha, fltQuantidade, strStatus, arrDocs
    mVar idLocation = m$.var("idLocation");
    mVar idItem = m$.var("idItem");
    mVar arrAlertaLinhas = m$.var("arrAlertaLinhas");
    mVar objAlertaLinha = m$.var("objAlertaLinha");
    mVar fltQuantidade = m$.var("fltQuantidade");
    mVar strStatus = m$.var("strStatus");
    mVar arrDocs = m$.var("arrDocs");
    m$.newVar(idLocation,idItem,arrAlertaLinhas,objAlertaLinha,fltQuantidade,strStatus,arrDocs);
    //<< IF pYKEY="" set pYKEY=$get(^VARTempAlertaLocal(YBED))
    if (mOp.Equal(pYKEY.get(),"")) {
      pYKEY.set(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get())));
    }
    //<< set strStatus=$$SalvarAlerta(pYKEY)
    strStatus.set(m$.fnc$("SalvarAlerta",pYKEY.get()));
    //<< 
    //<< IF $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Alert("Não foi possível salvar os dados, por favor tente novamente.")
      include.COMSYS.$$$Alert(m$,"Não foi possível salvar os dados, por favor tente novamente.");
      //<< do ReloadForm^COMUtilForm()
      m$.Cmd.Do("COMUtilForm.ReloadForm");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< //set idLocalPai = $extract(YLOCATION,1,1)
    //<< set idLocalPai = pYKEY
    mVar idLocalPai = m$.var("idLocalPai");
    idLocalPai.set(pYKEY.get());
    //<< $$$Order3(^VARAlertaLocalLinha,YM,idLocalPai,idItem)
    idItem.set("");
    for (;true;) {
      idItem.set(m$.Fnc.$order(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocalPai.get(),idItem.get())));
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< 
      //<< set objAlertaLinha = $get(^VARAlertaLocalLinha(YM, idLocalPai, idItem, 1))
      objAlertaLinha.set(m$.Fnc.$get(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocalPai.get(),idItem.get(),1)));
      //<< set fltQuantidade  = $$$VARAlertaLocalLinhaQuantidade(objAlertaLinha)
      fltQuantidade.set(include.VARConst.$$$VARAlertaLocalLinhaQuantidade(m$,objAlertaLinha));
      //<< 
      //<< if ((fltQuantidade'="") && (fltQuantidade>0)) {
      if (mOp.Logical(((mOp.NotEqual(fltQuantidade.get(),"")) && (mOp.Greater(fltQuantidade.get(),0))))) {
        //<< set arrAlertaLinhas(idLocalPai, idItem) = fltQuantidade
        arrAlertaLinhas.var(idLocalPai.get(),idItem.get()).set(fltQuantidade.get());
      }
      //<< }else {
      else {
        //<< if $$FilterEstoqueAbaixoPR(idItem,idLocalPai)=1 {
        if (mOp.Equal(m$.fnc$("FilterEstoqueAbaixoPR",idItem.get(),idLocalPai.get()),1)) {
          //<< set fltQuantidade=$$GetSugestao^VARReposicao(idItem,idLocalPai)
          fltQuantidade.set(m$.fnc$("VARReposicao.GetSugestao",idItem.get(),idLocalPai.get()));
          //<< if ((fltQuantidade'="") && (fltQuantidade>0)) {
          if (mOp.Logical(((mOp.NotEqual(fltQuantidade.get(),"")) && (mOp.Greater(fltQuantidade.get(),0))))) {
            //<< set arrAlertaLinhas(idLocalPai, idItem) = fltQuantidade
            arrAlertaLinhas.var(idLocalPai.get(),idItem.get()).set(fltQuantidade.get());
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
    //<< if '$data(arrAlertaLinhas) {
    if (mOp.Not(m$.Fnc.$data(arrAlertaLinhas))) {
      //<< $$$Alert("Nenhuma linha foi selecionada.")
      include.COMSYS.$$$Alert(m$,"Nenhuma linha foi selecionada.");
      //<< do ReloadForm^COMUtilForm()
      m$.Cmd.Do("COMUtilForm.ReloadForm");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< ;for i=1:1:100 hang 1
    //<< 
    //<< set strStatus = $$CriarRequisicao^VARAlertaLocalBIZ(.arrAlertaLinhas, .arrDocs)
    strStatus.set(m$.fnc$("VARAlertaLocalBIZ.CriarRequisicao",arrAlertaLinhas,arrDocs));
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< 
      //<< do ClearSelectedLines(.arrAlertaLinhas)
      m$.Cmd.Do("ClearSelectedLines",arrAlertaLinhas);
      //<< // A rotina SourceTxn^INReqSource já emitia um alerta. Mas, comentei para evitar duas msgs. Veja SR BR014697
      //<< //$$$StartScript()
      //<< //write "alert('"_$$PrepareMsg^VARSESINReqSource(.arrDocs)_"');"
      //<< //$$$EndScript()
      //<< 
      //<< if ( $data(arrDocs("Requisition") ) ) {
      if (mOp.Logical((m$.Fnc.$data(arrDocs.var("Requisition"))))) {
        //<< do GoToForm^COMUtilForm("INReq", $order(arrDocs("Requisition","")), 1, "")
        m$.Cmd.Do("COMUtilForm.GoToForm","INReq",m$.Fnc.$order(arrDocs.var("Requisition","")),1,"");
      }
      //<< }
      //<< else {
      else {
        //<< do ReloadForm^COMUtilForm()
        m$.Cmd.Do("COMUtilForm.ReloadForm");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< ClearSelectedLines(&parrAlertaLinhas)
  public Object ClearSelectedLines(Object ... _p) {
    mVar parrAlertaLinhas = m$.newVarRef("parrAlertaLinhas",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< new idLocation, idItem, objAlertaLinha, strStatus
    mVar idLocation = m$.var("idLocation");
    mVar idItem = m$.var("idItem");
    mVar objAlertaLinha = m$.var("objAlertaLinha");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idLocation,idItem,objAlertaLinha,strStatus);
    //<< 
    //<< $$$Order1(parrAlertaLinhas,idLocation)
    idLocation.set("");
    for (;true;) {
      idLocation.set(m$.Fnc.$order(parrAlertaLinhas.var(idLocation.get())));
      if (mOp.Equal(idLocation.get(),"")) {
        break;
      }
      //<< 
      //<< $$$Order2(parrAlertaLinhas,idLocation,idItem)
      idItem.set("");
      for (;true;) {
        idItem.set(m$.Fnc.$order(parrAlertaLinhas.var(idLocation.get(),idItem.get())));
        if (mOp.Equal(idItem.get(),"")) {
          break;
        }
        //<< 
        //<< set objAlertaLinha = $get(^VARAlertaLocalLinha(YM, idLocation, idItem, 1))
        objAlertaLinha.set(m$.Fnc.$get(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocation.get(),idItem.get(),1)));
        //<< 
        //<< set $$$VARSESAlertaLinhaQuantidade(objAlertaLinha) = ""
        include.VARConst.$$$VARSESAlertaLinhaQuantidadeSet(m$,objAlertaLinha,"");
        //<< //set $$$VARSESAlertaLinhaOk(objAlertaLinha)           = $$$NO
        //<< set strStatus = $$$Save("VARAlertaLocalLinha",idLocation_$$$COMMA_idItem,objAlertaLinha,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"VARAlertaLocalLinha",mOp.Concat(mOp.Concat(idLocation.get(),include.COMSYSString.$$$COMMA(m$)),idItem.get()),objAlertaLinha,include.COMSYS.$$$YES(m$)));
      }
    }
    //<< 
    //<< $$$End
    //<< $$$End
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< OnAfterSave(pYKEY)
  public Object OnAfterSave(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< set strStatus=$$$OK
    mVar strStatus = m$.var("strStatus");
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< IF pYKEY="" set pYKEY=$get(^VARTempAlertaLocal(YBED))
    if (mOp.Equal(pYKEY.get(),"")) {
      pYKEY.set(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get())));
    }
    //<< set strStatus=$$SalvarAlerta(pYKEY)
    strStatus.set(m$.fnc$("SalvarAlerta",pYKEY.get()));
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< //Remover Linhas do Alerta
      //<< do RemoveAlertLines(pYKEY)
      m$.Cmd.Do("RemoveAlertLines",pYKEY.get());
      //<< do GoToForm^COMUtilForm("VARAlertaLocal",pYKEY)
      m$.Cmd.Do("COMUtilForm.GoToForm","VARAlertaLocal",pYKEY.get());
    }
    //<< }else {
    else {
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< RemoveAlertLines(pYKEY)
  public Object RemoveAlertLines(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< $$$Order3(^VARAlertaLocalLinha,YM,pYKEY,idItem)
    mVar idItem = m$.var("idItem");
    idItem.set("");
    for (;true;) {
      idItem.set(m$.Fnc.$order(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),pYKEY.get(),idItem.get())));
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< 
      //<< set objAlertaLinha = $get(^VARAlertaLocalLinha(YM, pYKEY, idItem, 1))
      mVar objAlertaLinha = m$.var("objAlertaLinha");
      objAlertaLinha.set(m$.Fnc.$get(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),pYKEY.get(),idItem.get(),1)));
      //<< set key=pYKEY_","_idItem
      mVar key = m$.var("key");
      key.set(mOp.Concat(mOp.Concat(pYKEY.get(),","),idItem.get()));
      //<< if $$$VARAlertaLocalLinhaRemoverProduto(objAlertaLinha)=1 set strStatus=$$KILL^COMUtils("VARAlertaLocalLinha",key)
      if (mOp.Equal(include.VARConst.$$$VARAlertaLocalLinhaRemoverProduto(m$,objAlertaLinha),1)) {
        mVar strStatus = m$.var("strStatus");
        strStatus.set(m$.fnc$("COMUtils.KILL","VARAlertaLocalLinha",key.get()));
      }
    }
    //<< 
    //<< $$$End
    //<< q
    return null;
  }

  //<< 
  //<< MostrarLegenda
  public void MostrarLegenda() {
    //<< set lstHeader = ""
    mVar lstHeader = m$.var("lstHeader");
    lstHeader.set("");
    //<< set lstHeader = lstHeader_$listbuild("<font color=black size=4>Legenda</font>")
    lstHeader.set(mOp.Concat(lstHeader.get(),m$.Fnc.$listbuild("<font color=black size=4>Legenda</font>")));
    //<< if $$Start^COMTable(lstHeader,,,,,,3) {
    if (mOp.Logical(m$.fnc$("COMTable.Start",lstHeader.get(),null,null,null,null,null,3))) {
      //<< 
      //<< set strCallBack = "VisualizarItens^VARAlertaLocalUI"
      mVar strCallBack = m$.var("strCallBack");
      strCallBack.set("VisualizarItens^VARAlertaLocalUI");
      //<< set visão=$get(^VARTempAlertaLocal(YBED,"Visão"))
      mVar visão = m$.var("visão");
      visão.set(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão")));
      //<< set strLinkEstoqueAbaixoPRsemEP = "<font color=black size=4>Estoque abaixo do ponto de ressuprimento</font>"
      mVar strLinkEstoqueAbaixoPRsemEP = m$.var("strLinkEstoqueAbaixoPRsemEP");
      strLinkEstoqueAbaixoPRsemEP.set("<font color=black size=4>Estoque abaixo do ponto de ressuprimento</font>");
      //<< 
      //<< do NewLine^COMTable("#e94848")
      m$.Cmd.Do("COMTable.NewLine","#e94848");
      //<< do InsertCellCallback^COMTable(strLinkEstoqueAbaixoPRsemEP,strCallBack,4_",,"_idLocation_","_visão)
      m$.Cmd.Do("COMTable.InsertCellCallback",strLinkEstoqueAbaixoPRsemEP.get(),strCallBack.get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(4,",,"),m$.var("idLocation").get()),","),visão.get()));
      //<< //do InsertCell^COMTable(strLinkEstoqueAbaixoPRsemEP,"",,"","LEFT")
      //<< do EndLine^COMTable()
      m$.Cmd.Do("COMTable.EndLine");
      //<< 
      //<< set strLinkEstoqueAbaixoPRcomEP = "<font color=black size=4>Estoque abaixo do ponto de ressuprimento com encomenda pendente suficiente</font>"
      mVar strLinkEstoqueAbaixoPRcomEP = m$.var("strLinkEstoqueAbaixoPRcomEP");
      strLinkEstoqueAbaixoPRcomEP.set("<font color=black size=4>Estoque abaixo do ponto de ressuprimento com encomenda pendente suficiente</font>");
      //<< 
      //<< do NewLine^COMTable("#f8d08b")
      m$.Cmd.Do("COMTable.NewLine","#f8d08b");
      //<< do InsertCellCallback^COMTable(strLinkEstoqueAbaixoPRcomEP,strCallBack,3_",,"_idLocation_","_visão)
      m$.Cmd.Do("COMTable.InsertCellCallback",strLinkEstoqueAbaixoPRcomEP.get(),strCallBack.get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(3,",,"),m$.var("idLocation").get()),","),visão.get()));
      //<< //do InsertCell^COMTable(strLinkEstoqueAbaixoPRcomEP,"",,"","LEFT")
      //<< do EndLine^COMTable()
      m$.Cmd.Do("COMTable.EndLine");
      //<< 
      //<< set strLinkEstoqueProximoPR = "<font color=black size=4>Estoque próximo do ponto de ressuprimento</font>"
      mVar strLinkEstoqueProximoPR = m$.var("strLinkEstoqueProximoPR");
      strLinkEstoqueProximoPR.set("<font color=black size=4>Estoque próximo do ponto de ressuprimento</font>");
      //<< 
      //<< do NewLine^COMTable("#f3f2b5")
      m$.Cmd.Do("COMTable.NewLine","#f3f2b5");
      //<< do InsertCellCallback^COMTable(strLinkEstoqueProximoPR,strCallBack,2_",,"_idLocation_","_visão)
      m$.Cmd.Do("COMTable.InsertCellCallback",strLinkEstoqueProximoPR.get(),strCallBack.get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(2,",,"),m$.var("idLocation").get()),","),visão.get()));
      //<< //do InsertCell^COMTable(strLinkEstoqueProximoPR,"",,"","LEFT")
      //<< do EndLine^COMTable()
      m$.Cmd.Do("COMTable.EndLine");
      //<< 
      //<< set strLinkEstoqueAcimaPR = "<font color=black size=4>Estoque acima do ponto de ressuprimento</font>"
      mVar strLinkEstoqueAcimaPR = m$.var("strLinkEstoqueAcimaPR");
      strLinkEstoqueAcimaPR.set("<font color=black size=4>Estoque acima do ponto de ressuprimento</font>");
      //<< 
      //<< do NewLine^COMTable("#92d39e")
      m$.Cmd.Do("COMTable.NewLine","#92d39e");
      //<< do InsertCellCallback^COMTable(strLinkEstoqueAcimaPR,strCallBack,1_",,"_idLocation_","_visão)
      m$.Cmd.Do("COMTable.InsertCellCallback",strLinkEstoqueAcimaPR.get(),strCallBack.get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(1,",,"),m$.var("idLocation").get()),","),visão.get()));
      //<< //do InsertCell^COMTable(strLinkEstoqueAcimaPR,"",,"","LEFT")
      //<< do EndLine^COMTable()
      m$.Cmd.Do("COMTable.EndLine");
      //<< 
      //<< set strLinkEstoqueAcimaEM = "<font color=black size=4>Estoque acima do estoque máximo</font>"
      mVar strLinkEstoqueAcimaEM = m$.var("strLinkEstoqueAcimaEM");
      strLinkEstoqueAcimaEM.set("<font color=black size=4>Estoque acima do estoque máximo</font>");
      //<< 
      //<< do NewLine^COMTable("#b5c1d7")
      m$.Cmd.Do("COMTable.NewLine","#b5c1d7");
      //<< do InsertCellCallback^COMTable(strLinkEstoqueAcimaEM,strCallBack,5_",,"_idLocation_","_visão)
      m$.Cmd.Do("COMTable.InsertCellCallback",strLinkEstoqueAcimaEM.get(),strCallBack.get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(5,",,"),m$.var("idLocation").get()),","),visão.get()));
      //<< //do InsertCell^COMTable(strLinkEstoqueAcimaEM,"",,"","LEFT")
      //<< do EndLine^COMTable()
      m$.Cmd.Do("COMTable.EndLine");
    }
    //<< 
    //<< }
    //<< 
    //<< do Stop^COMTable()
    m$.Cmd.Do("COMTable.Stop");
    //<< quit
    return;
  }

  //<< 
  //<< MostrarLegendaContaContabil
  public void MostrarLegendaContaContabil() {
    //<< new idContaContabil,lstHeader,strLinkContaContabil,strCallBack,descContaContabil,strParams
    mVar idContaContabil = m$.var("idContaContabil");
    mVar lstHeader = m$.var("lstHeader");
    mVar strLinkContaContabil = m$.var("strLinkContaContabil");
    mVar strCallBack = m$.var("strCallBack");
    mVar descContaContabil = m$.var("descContaContabil");
    mVar strParams = m$.var("strParams");
    m$.newVar(idContaContabil,lstHeader,strLinkContaContabil,strCallBack,descContaContabil,strParams);
    //<< set lstHeader = ""
    lstHeader.set("");
    //<< set lstHeader = lstHeader_$listbuild("<font color=black size=4>Filtro por Conta Contábil</font>")
    lstHeader.set(mOp.Concat(lstHeader.get(),m$.Fnc.$listbuild("<font color=black size=4>Filtro por Conta Contábil</font>")));
    //<< if $$Start^COMTable(lstHeader,,,,,,3) {
    if (mOp.Logical(m$.fnc$("COMTable.Start",lstHeader.get(),null,null,null,null,null,3))) {
      //<< $$$Order4(^INPARA,YM,"VARTCICONTACONTABIL",SPRACHE,idContaContabil)
      idContaContabil.set("");
      for (;true;) {
        idContaContabil.set(m$.Fnc.$order(m$.var("^INPARA",m$.var("YM").get(),"VARTCICONTACONTABIL",m$.var("SPRACHE").get(),idContaContabil.get())));
        if (mOp.Equal(idContaContabil.get(),"")) {
          break;
        }
        //<< set strCallBack = "VisualizarItens^VARAlertaLocalUI"
        strCallBack.set("VisualizarItens^VARAlertaLocalUI");
        //<< set visão=$get(^VARTempAlertaLocal(YBED,"Visão"))
        mVar visão = m$.var("visão");
        visão.set(m$.Fnc.$get(m$.var("^VARTempAlertaLocal",m$.var("YBED").get(),"Visão")));
        //<< set descContaContabil=$piece($GET(^INPARA(YM,"VARTCICONTACONTABIL",SPRACHE,idContaContabil,1)),Y,1)
        descContaContabil.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INPARA",m$.var("YM").get(),"VARTCICONTACONTABIL",m$.var("SPRACHE").get(),idContaContabil.get(),1)),m$.var("Y").get(),1));
        //<< set strLinkContaContabil = "<font color=black size=4>"_descContaContabil_"</font>"
        strLinkContaContabil.set(mOp.Concat(mOp.Concat("<font color=black size=4>",descContaContabil.get()),"</font>"));
        //<< set strParams=6_idContaContabil_",,"_idLocation_","_visão
        strParams.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(6,idContaContabil.get()),",,"),m$.var("idLocation").get()),","),visão.get()));
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< do InsertCellCallback^COMTable(strLinkContaContabil,strCallBack,strParams)
        m$.Cmd.Do("COMTable.InsertCellCallback",strLinkContaContabil.get(),strCallBack.get(),strParams.get());
        //<< //do InsertCell^COMTable(strLinkEstoqueAbaixoPRsemEP,"",,"","LEFT")
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
      }
    }
    //<< $$$End
    //<< 
    //<< }
    //<< 
    //<< do Stop^COMTable()
    m$.Cmd.Do("COMTable.Stop");
    //<< quit
    return;
  }

  //<< 
  //<< VisualizarItens(pidFiltro,pGrupo,pLocal="",visão="")
  public Object VisualizarItens(Object ... _p) {
    mVar pidFiltro = m$.newVarRef("pidFiltro",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pGrupo = m$.newVarRef("pGrupo",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pLocal = m$.newVarRef("pLocal",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar visão = m$.newVarRef("visão",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< new filterSet,filterKey
    mVar filterSet = m$.var("filterSet");
    mVar filterKey = m$.var("filterKey");
    m$.newVar(filterSet,filterKey);
    //<< 
    //<< //set ^CacheTempToggleView(YUSER,YUCI,"VARAlertaLocal","Height") = "516+objDiv"
    //<< //set ^CacheTempToggleView(YUSER,YUCI,"VARAlertaLocal","Type") = "none"
    //<< set filterSet = pidFiltro_"-"_pGrupo_"-"_visão
    filterSet.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidFiltro.get(),"-"),pGrupo.get()),"-"),visão.get()));
    //<< set filterKey= pLocal
    filterKey.set(pLocal.get());
    //<< 
    //<< do GoToForm^COMUtilForm("VARAlertaLocal",filterKey,,,,,filterSet)
    m$.Cmd.Do("COMUtilForm.GoToForm","VARAlertaLocal",filterKey.get(),null,null,null,null,filterSet.get());
    //<< quit
    return null;
  }

//<< 
}
