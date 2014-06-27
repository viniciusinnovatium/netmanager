//*****************************************************************************
//** TASC - ALPHALINC - MAC VARParametroAtivarTabela
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 17:24:51
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
//<< #include COMConst
import include.COMConst;
//<< #include INConst
import include.INConst;

//<< VARParametroAtivarTabela
public class VARParametroAtivarTabela extends mClass {

  public void main() {
    _VARParametroAtivarTabela();
  }

  public void _VARParametroAtivarTabela() {
    OnBeforeFormConstruction();
  }

  //<< 
  //<< OnBeforeFormConstruction
  public Object OnBeforeFormConstruction() {
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< OnAfterSave
  public void OnAfterSave() {
    //<< 
    //<< kill ^VARTempParamAtivoConfirm(YM,YBED)
    m$.var("^VARTempParamAtivoConfirm",m$.var("YM").get(),m$.var("YBED").get()).kill();
    //<< 
    //<< do VARLogAfterSave^VARUtil(YBED,YFORM)
    m$.Cmd.Do("VARUtil.VARLogAfterSave",m$.var("YBED").get(),m$.var("YFORM").get());
    //<< do GoToForm^COMUtilForm("VARParametroAtivarTabela",1,,,,,)
    m$.Cmd.Do("COMUtilForm.GoToForm","VARParametroAtivarTabela",1,null,null,null,null,null);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< OnAfterDataFields
  public Object OnAfterDataFields() {
    //<< 
    //<< quit:('$$isAfterSaveLogged^VARUtil(YBED,YFORM))
    if ((mOp.Not(m$.fnc$("VARUtil.isAfterSaveLogged",m$.var("YBED").get(),m$.var("YFORM").get())))) {
      return null;
    }
    //<< do ClearVARLogAterSave^VARUtil(YBED,YFORM)
    m$.Cmd.Do("VARUtil.ClearVARLogAterSave",m$.var("YBED").get(),m$.var("YFORM").get());
    //<< 
    //<< set nomeParametro = $get(VORG(1))
    mVar nomeParametro = m$.var("nomeParametro");
    nomeParametro.set(m$.Fnc.$get(m$.var("VORG").var(1)));
    //<< 
    //<< set meuSQL = "SELECT DISTINCT "
    mVar meuSQL = m$.var("meuSQL");
    meuSQL.set("SELECT DISTINCT ");
    //<< set meuSQL = meuSQL_" ParameterDescription, "
    meuSQL.set(mOp.Concat(meuSQL.get()," ParameterDescription, "));
    //<< set meuSQL = meuSQL_" SearchItem,  "
    meuSQL.set(mOp.Concat(meuSQL.get()," SearchItem,  "));
    //<< set meuSQL = meuSQL_" Text "
    meuSQL.set(mOp.Concat(meuSQL.get()," Text "));
    //<< set meuSQL = meuSQL_" FROM WWW101 "
    meuSQL.set(mOp.Concat(meuSQL.get()," FROM WWW101 "));
    //<< set meuSQL = meuSQL_" WHERE ParameterDescription = """_nomeParametro_""" "
    meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," WHERE ParameterDescription = \""),nomeParametro.get()),"\" "));
    //<< 
    //<< set paramList = ##class(%ResultSet).%New()
    mVar paramList = m$.var("paramList");
    paramList.set(m$.fnc$("$ResultSet.$New"));
    //<< do paramList.Prepare(meuSQL)
    m$.Cmd.Do(paramList.getORef(),"Prepare",meuSQL.get());
    //<< do paramList.Execute()
    m$.Cmd.Do(paramList.getORef(),"Execute");
    //<< 
    //<< new lstHeader
    mVar lstHeader = m$.var("lstHeader");
    m$.newVar(lstHeader);
    //<< set lstHeader = $listbuild("Nome do Parâmetro","Código do Parâmetro","Descrição","Ativo","")
    lstHeader.set(m$.Fnc.$listbuild("Nome do Parâmetro","Código do Parâmetro","Descrição","Ativo",""));
    //<< 
    //<< if $$Start^COMTable(lstHeader) {
    if (mOp.Logical(m$.fnc$("COMTable.Start",lstHeader.get()))) {
      //<< 
      //<< set count = 0
      mVar count = m$.var("count");
      count.set(0);
      //<< 
      //<< while (paramList.Next()) {
      while (mOp.Logical((m$.fnc$(paramList.getORef(),"Next")))) {
        //<< 
        //<< set classe          = "WWW101" ; Por enquanto, somente esta classe.
        mVar classe = m$.var("classe");
        classe.set("WWW101");
        //<< set nome            = paramList.Data("ParameterDescription")
        mVar nome = m$.var("nome");
        nome.set(m$.fnc$(paramList.getORef(),"Data","ParameterDescription"));
        //<< set codigo          = paramList.Data("SearchItem")
        mVar codigo = m$.var("codigo");
        codigo.set(m$.fnc$(paramList.getORef(),"Data","SearchItem"));
        //<< set descricao       = paramList.Data("Text")
        mVar descricao = m$.var("descricao");
        descricao.set(m$.fnc$(paramList.getORef(),"Data","Text"));
        //<< 
        //<< set count = $i(count)
        count.set(m$.Fnc.$increment(count));
        //<< 
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< do InsertCell^COMTable(nome,,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell",nome.get(),null,null,null,"CENTER");
        //<< do InsertCell^COMTable(codigo,,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell",codigo.get(),null,null,null,"CENTER");
        //<< do InsertCell^COMTable(descricao,,,,"LEFT")
        m$.Cmd.Do("COMTable.InsertCell",descricao.get(),null,null,null,"LEFT");
        //<< do InsertCellCheckbox^COMTable(classe_$$$COMMA_nome_$$$COMMA_codigo,"GravarAtivoOnClick^VARParametroAtivarTabela",$$GetAtivo(classe,nome,codigo),0)
        m$.Cmd.Do("COMTable.InsertCellCheckbox",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(classe.get(),include.COMSYSString.$$$COMMA(m$)),nome.get()),include.COMSYSString.$$$COMMA(m$)),codigo.get()),"GravarAtivoOnClick^VARParametroAtivarTabela",m$.fnc$("GetAtivo",classe.get(),nome.get(),codigo.get()),0);
        //<< do IconeIndicativo($$GetAtivo(classe,nome,codigo))
        m$.Cmd.Do("IconeIndicativo",m$.fnc$("GetAtivo",classe.get(),nome.get(),codigo.get()));
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
      }
      //<< 
      //<< }
      //<< 
      //<< if (count = 0) {
      if ((mOp.Equal(count.get(),0))) {
        //<< 
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< do InsertCell^COMTable("Nenhum registro encontrado.",,,,,,4)
        m$.Cmd.Do("COMTable.InsertCell","Nenhum registro encontrado.",null,null,null,null,null,4);
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
      }
      //<< 
      //<< }
      //<< 
      //<< do Stop^COMTable()
      m$.Cmd.Do("COMTable.Stop");
    }
    //<< 
    //<< }
    //<< do paramList.Close()
    m$.Cmd.Do(paramList.getORef(),"Close");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< IconeIndicativo(pblnAtivo)
  public Object IconeIndicativo(Object ... _p) {
    mVar pblnAtivo = m$.newVarRef("pblnAtivo",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< if (pblnAtivo > 0) {
    if ((mOp.Greater(pblnAtivo.get(),0))) {
      //<< do InsertCell^COMTable("<img src="_YGIF_"small_check.gif TITLE='Parâmetro ativo.' border=0 align=""CENTER"">",,,,"CENTER")
      m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat("<img src=",m$.var("YGIF").get()),"small_check.gif TITLE='Parâmetro ativo.' border=0 align=\"CENTER\">"),null,null,null,"CENTER");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< else {
    else {
      //<< do InsertCell^COMTable("<img src="_YGIF_"small_x.gif TITLE='Parâmetro inativo.' border=0 align=""CENTER"">",,,,"CENTER")
      m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat("<img src=",m$.var("YGIF").get()),"small_x.gif TITLE='Parâmetro inativo.' border=0 align=\"CENTER\">"),null,null,null,"CENTER");
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< GetAtivo(pClasse,pNome,pCodigo)
  public Object GetAtivo(Object ... _p) {
    mVar pClasse = m$.newVarRef("pClasse",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pNome = m$.newVarRef("pNome",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pCodigo = m$.newVarRef("pCodigo",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< 
    //<< new objVARParametroAtivar, str
    mVar objVARParametroAtivar = m$.var("objVARParametroAtivar");
    mVar str = m$.var("str");
    m$.newVar(objVARParametroAtivar,str);
    //<< 
    //<< if ((pClasse="")||(pNome="")||(pCodigo="")) quit $$$NO
    if (mOp.Logical(((mOp.Equal(pClasse.get(),"")) || (mOp.Equal(pNome.get(),"")) || (mOp.Equal(pCodigo.get(),""))))) {
      return include.COMSYS.$$$NO(m$);
    }
    //<< 
    //<< set str = $$$NO
    str.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set objVARParametroAtivar = $get(^VARParametroAtivar(0,pClasse,pNome,pCodigo,1))
    objVARParametroAtivar.set(m$.Fnc.$get(m$.var("^VARParametroAtivar",0,pClasse.get(),pNome.get(),pCodigo.get(),1)));
    //<< 
    //<< if ($$$VARParametroAtivarAtivo(objVARParametroAtivar) '= ""){
    if ((mOp.NotEqual(include.VARConst.$$$VARParametroAtivarAtivo(m$,objVARParametroAtivar),""))) {
      //<< set str = $$$YES
      str.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< quit str
    return str.get();
  }

  //<< 
  //<< GravarAtivoOnClick(pKey="",checked="")
  public Object GravarAtivoOnClick(Object ... _p) {
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar checked = m$.newVarRef("checked",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< 
    //<< new pClasse, pNome, pCodigo
    mVar pClasse = m$.var("pClasse");
    mVar pNome = m$.var("pNome");
    mVar pCodigo = m$.var("pCodigo");
    m$.newVar(pClasse,pNome,pCodigo);
    //<< 
    //<< set pClasse   = $piece(pKey,$$$COMMA,1)
    pClasse.set(m$.Fnc.$piece(pKey.get(),include.COMSYSString.$$$COMMA(m$),1));
    //<< set pNome     = $piece(pKey,$$$COMMA,2)
    pNome.set(m$.Fnc.$piece(pKey.get(),include.COMSYSString.$$$COMMA(m$),2));
    //<< set pCodigo   = $piece(pKey,$$$COMMA,3)
    pCodigo.set(m$.Fnc.$piece(pKey.get(),include.COMSYSString.$$$COMMA(m$),3));
    //<< if ($$GetAtivo(pClasse,pNome,pCodigo) = $$$YES) {
    if ((mOp.Equal(m$.fnc$("GetAtivo",pClasse.get(),pNome.get(),pCodigo.get()),include.COMSYS.$$$YES(m$)))) {
      //<< if ($$CheckUnidadeEmUso(pCodigo) = $$$YES){
      if ((mOp.Equal(m$.fnc$("CheckUnidadeEmUso",pCodigo.get()),include.COMSYS.$$$YES(m$)))) {
        //<< $$$Alert("Atenção: Você não pode inativar um parâmetro em uso no sistema.")
        include.COMSYS.$$$Alert(m$,"Atenção: Você não pode inativar um parâmetro em uso no sistema.");
        //<< &js< document.getElementById('#($piece(checked,$$$COMMA,2))#').checked = 1 >
        m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(" document.getElementById('",(m$.Fnc.$piece(checked.get(),include.COMSYSString.$$$COMMA(m$),2))),"').checked = 1 "));
        //<< quit $$$NO
        return include.COMSYS.$$$NO(m$);
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if ($piece(checked,",",1) = "true") {
    if ((mOp.Equal(m$.Fnc.$piece(checked.get(),",",1),"true"))) {
      //<< set ^VARTempParamAtivoConfirm(YM,YBED,pClasse,pNome,pCodigo) = 1
      m$.var("^VARTempParamAtivoConfirm",m$.var("YM").get(),m$.var("YBED").get(),pClasse.get(),pNome.get(),pCodigo.get()).set(1);
    }
    //<< }
    //<< elseif ($piece(checked,",",1) = "false") {
    else if ((mOp.Equal(m$.Fnc.$piece(checked.get(),",",1),"false"))) {
      //<< set ^VARTempParamAtivoConfirm(YM,YBED,pClasse,pNome,pCodigo) = ""
      m$.var("^VARTempParamAtivoConfirm",m$.var("YM").get(),m$.var("YBED").get(),pClasse.get(),pNome.get(),pCodigo.get()).set("");
    }
    //<< }
    //<< 
    //<< quit $$$YES
    return include.COMSYS.$$$YES(m$);
  }

  //<< 
  //<< CheckUnidadeEmUso(pUnidade)
  public Object CheckUnidadeEmUso(Object ... _p) {
    mVar pUnidade = m$.newVarRef("pUnidade",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< new found
    mVar found = m$.var("found");
    m$.newVar(found);
    //<< 
    //<< set found = 0
    found.set(0);
    //<< 
    //<< // ---------- UnitofMeasure - INART
    //<< 
    //<< &sql(
    //<< DECLARE UnitofMeasure CURSOR FOR
    //<< select DISTINCT UnitofMeasure
    //<< into :Codigo
    //<< from INART
    //<< where UnitofMeasure = :pUnidade
    //<< )
    m$.Cmd.SQL();
    //<< 
    //<< &sql(OPEN UnitofMeasure)
    m$.Cmd.SQL();
    //<< &sql(FETCH UnitofMeasure)
    m$.Cmd.SQL();
    //<< 
    //<< while (SQLCODE = 0) {
    while ((mOp.Equal(m$.var("SQLCODE").get(),0))) {
      //<< set found = 1
      found.set(1);
      //<< quit
      break;
      //<< 
      //<< &sql(FETCH UnitofMeasure)
      m$.Cmd.SQL();
    }
    //<< }
    //<< &sql(CLOSE UnitofMeasure)
    m$.Cmd.SQL();
    //<< 
    //<< if (found = 0){ ; Só procura no outro campo/tabela se não tiver encontrado na busca anterior.
    if ((mOp.Equal(found.get(),0))) {
      //<< // ---------- BaseUnit - INART
      //<< 
      //<< &sql(
      //<< DECLARE BaseUnit CURSOR FOR
      //<< select DISTINCT BaseUnit
      //<< into :Codigo
      //<< from INART
      //<< where BaseUnit = :pUnidade
      //<< )
      m$.Cmd.SQL();
      //<< 
      //<< &sql(OPEN BaseUnit)
      m$.Cmd.SQL();
      //<< &sql(FETCH BaseUnit)
      m$.Cmd.SQL();
      //<< 
      //<< while (SQLCODE = 0) {
      while ((mOp.Equal(m$.var("SQLCODE").get(),0))) {
        //<< set found = 1
        found.set(1);
        //<< quit
        break;
        //<< 
        //<< &sql(FETCH BaseUnit)
        m$.Cmd.SQL();
      }
      //<< }
      //<< &sql(CLOSE BaseUnit)
      m$.Cmd.SQL();
    }
    //<< 
    //<< }
    //<< 
    //<< if (found = 0){ ; Só procura no outro campo/tabela se não tiver encontrado na busca anterior.
    if ((mOp.Equal(found.get(),0))) {
      //<< // ---------- OuterUnit - INARTPACK
      //<< 
      //<< &sql(
      //<< DECLARE OuterUnit CURSOR FOR
      //<< select DISTINCT OuterUnit
      //<< into :Codigo
      //<< from INARTPACK
      //<< where OuterUnit = :pUnidade
      //<< )
      m$.Cmd.SQL();
      //<< 
      //<< &sql(OPEN OuterUnit)
      m$.Cmd.SQL();
      //<< &sql(FETCH OuterUnit)
      m$.Cmd.SQL();
      //<< 
      //<< while (SQLCODE = 0) {
      while ((mOp.Equal(m$.var("SQLCODE").get(),0))) {
        //<< set found = 1
        found.set(1);
        //<< quit
        break;
        //<< 
        //<< &sql(FETCH OuterUnit)
        m$.Cmd.SQL();
      }
      //<< }
      //<< &sql(CLOSE OuterUnit)
      m$.Cmd.SQL();
    }
    //<< }
    //<< 
    //<< quit found
    return found.get();
  }

  //<< 
  //<< 
  //<< Salvar()
  public Object Salvar() {
    //<< set obj = $order(^VARTempParamAtivoConfirm(YM,YBED))
    mVar obj = m$.var("obj");
    obj.set(m$.Fnc.$order(m$.var("^VARTempParamAtivoConfirm",m$.var("YM").get(),m$.var("YBED").get())));
    //<< 
    //<< if ($data(obj)= 10 || $data(obj) = 1){
    if ((mOp.Equal(mOp.Equal(m$.Fnc.$data(obj),10) || mOp.Logical(m$.Fnc.$data(obj)),1))) {
      //<< do AtualizaAtivo()
      m$.Cmd.Do("AtualizaAtivo");
      //<< kill ^VARTempParamAtivoConfirm(YM,YBED)
      m$.var("^VARTempParamAtivoConfirm",m$.var("YM").get(),m$.var("YBED").get()).kill();
    }
    //<< }
    //<< 
    //<< do VARLogAfterSave^VARUtil(YBED,YFORM)
    m$.Cmd.Do("VARUtil.VARLogAfterSave",m$.var("YBED").get(),m$.var("YFORM").get());
    //<< do GoToForm^COMUtilForm("VARParametroAtivarTabela",1,,,,,)
    m$.Cmd.Do("COMUtilForm.GoToForm","VARParametroAtivarTabela",1,null,null,null,null,null);
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< AtualizaAtivo()
  public Object AtualizaAtivo() {
    //<< 
    //<< new Classe, Nome, Codigo, objTemp
    mVar Classe = m$.var("Classe");
    mVar Nome = m$.var("Nome");
    mVar Codigo = m$.var("Codigo");
    mVar objTemp = m$.var("objTemp");
    m$.newVar(Classe,Nome,Codigo,objTemp);
    //<< 
    //<< set Classe = ""
    Classe.set("");
    //<< 
    //<< for {
    for (;true;) {
      //<< set Classe = $order(^VARTempParamAtivoConfirm(YM,YBED,Classe))
      Classe.set(m$.Fnc.$order(m$.var("^VARTempParamAtivoConfirm",m$.var("YM").get(),m$.var("YBED").get(),Classe.get())));
      //<< quit:(Classe = "")
      if ((mOp.Equal(Classe.get(),""))) {
        break;
      }
      //<< 
      //<< set Nome = ""
      Nome.set("");
      //<< 
      //<< for {
      for (;true;) {
        //<< set Nome = $order(^VARTempParamAtivoConfirm(YM,YBED,Classe,Nome))
        Nome.set(m$.Fnc.$order(m$.var("^VARTempParamAtivoConfirm",m$.var("YM").get(),m$.var("YBED").get(),Classe.get(),Nome.get())));
        //<< quit:(Nome = "")
        if ((mOp.Equal(Nome.get(),""))) {
          break;
        }
        //<< 
        //<< set Codigo = ""
        Codigo.set("");
        //<< 
        //<< for {
        for (;true;) {
          //<< set Codigo = $order(^VARTempParamAtivoConfirm(YM,YBED,Classe,Nome,Codigo))
          Codigo.set(m$.Fnc.$order(m$.var("^VARTempParamAtivoConfirm",m$.var("YM").get(),m$.var("YBED").get(),Classe.get(),Nome.get(),Codigo.get())));
          //<< quit:(Codigo = "")
          if ((mOp.Equal(Codigo.get(),""))) {
            break;
          }
          //<< 
          //<< set objTemp = $get(^VARTempParamAtivoConfirm(YM,YBED,Classe,Nome,Codigo))
          objTemp.set(m$.Fnc.$get(m$.var("^VARTempParamAtivoConfirm",m$.var("YM").get(),m$.var("YBED").get(),Classe.get(),Nome.get(),Codigo.get())));
          //<< set objVARParametroAtivar = $get(^VARParametroAtivar(YM,Classe,Nome,Codigo,1))
          mVar objVARParametroAtivar = m$.var("objVARParametroAtivar");
          objVARParametroAtivar.set(m$.Fnc.$get(m$.var("^VARParametroAtivar",m$.var("YM").get(),Classe.get(),Nome.get(),Codigo.get(),1)));
          //<< 
          //<< if ($piece(objTemp,Y,1) '= ""){
          if ((mOp.NotEqual(m$.Fnc.$piece(objTemp.get(),m$.var("Y").get(),1),""))) {
            //<< if ($$$VARParametroAtivarAtivo(objVARParametroAtivar) '= $piece(objTemp,Y,1)){
            if ((mOp.NotEqual(include.VARConst.$$$VARParametroAtivarAtivo(m$,objVARParametroAtivar),m$.Fnc.$piece(objTemp.get(),m$.var("Y").get(),1)))) {
              //<< set $$$VARParametroAtivarAtivo(objVARParametroAtivar) = $piece(objTemp,Y,1)
              include.VARConst.$$$VARParametroAtivarAtivoSet(m$,objVARParametroAtivar,m$.Fnc.$piece(objTemp.get(),m$.var("Y").get(),1));
            }
            //<< }
            //<< set strStatus = $$$Save("VARParametroAtivar",Classe_$$$COMMA_Nome_$$$COMMA_Codigo,objVARParametroAtivar,1)
            mVar strStatus = m$.var("strStatus");
            strStatus.set(include.COMSYS.$$$Save(m$,"VARParametroAtivar",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(Classe.get(),include.COMSYSString.$$$COMMA(m$)),Nome.get()),include.COMSYSString.$$$COMMA(m$)),Codigo.get()),objVARParametroAtivar,1));
          }
          //<< }
          //<< else {
          else {
            //<< set strStatus = $$$Kill("VARParametroAtivar",Classe_$$$COMMA_Nome_$$$COMMA_Codigo)
            mVar strStatus = m$.var("strStatus");
            strStatus.set(include.COMSYS.$$$Kill(m$,"VARParametroAtivar",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(Classe.get(),include.COMSYSString.$$$COMMA(m$)),Nome.get()),include.COMSYSString.$$$COMMA(m$)),Codigo.get())));
          }
          //<< }
          //<< 
          //<< if $$$ISERR(strStatus) {
          if (mOp.Logical(include.COMSYS.$$$ISERR(m$,m$.var("strStatus")))) {
            //<< $$$Alert("Erro ao atualizar parâmetros: "_$$DecodeError^COMUtilError(strStatus))
            include.COMSYS.$$$Alert(m$,mOp.Concat("Erro ao atualizar parâmetros: ",m$.fnc$("COMUtilError.DecodeError",m$.var("strStatus").get())));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CargaVARParametroAtivar()
  public Object CargaVARParametroAtivar() {
    //<< 
    //<< new Item, objINART, found, Classe, Nome, Codigo, objVARParametroAtivar
    mVar Item = m$.var("Item");
    mVar objINART = m$.var("objINART");
    mVar found = m$.var("found");
    mVar Classe = m$.var("Classe");
    mVar Nome = m$.var("Nome");
    mVar Codigo = m$.var("Codigo");
    mVar objVARParametroAtivar = m$.var("objVARParametroAtivar");
    m$.newVar(Item,objINART,found,Classe,Nome,Codigo,objVARParametroAtivar);
    //<< 
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< 
    //<< set Item = ""
    Item.set("");
    //<< set Classe = "WWW101"
    Classe.set("WWW101");
    //<< set Nome = "EINHEIT"
    Nome.set("EINHEIT");
    //<< set objVARParametroAtivar = ""
    objVARParametroAtivar.set("");
    //<< set $$$VARParametroAtivarAtivo(objVARParametroAtivar) = $$$YES
    include.VARConst.$$$VARParametroAtivarAtivoSet(m$,objVARParametroAtivar,include.COMSYS.$$$YES(m$));
    //<< set Codigo = ""
    Codigo.set("");
    //<< set strStatus = $$$OK
    mVar strStatus = m$.var("strStatus");
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< // ---------- UnitofMeasure - INART
    //<< 
    //<< &sql(
    //<< DECLARE UnitofMeasureCarga CURSOR FOR
    //<< select DISTINCT UnitofMeasure
    //<< into :Codigo
    //<< from INART
    //<< where UnitofMeasure IS NOT NULL
    //<< )
    m$.Cmd.SQL();
    //<< 
    //<< &sql(OPEN UnitofMeasureCarga)
    m$.Cmd.SQL();
    //<< &sql(FETCH UnitofMeasureCarga)
    m$.Cmd.SQL();
    //<< 
    //<< write "Executando carga baseada no campo UnitofMeasure da INART: ",!
    m$.Cmd.Write("Executando carga baseada no campo UnitofMeasure da INART: ","\n");
    //<< hang 1
    m$.Cmd.Hang(1);
    //<< 
    //<< while (SQLCODE = 0) {
    while ((mOp.Equal(m$.var("SQLCODE").get(),0))) {
      //<< write "Código da UnitofMeasure: "_Codigo,!
      m$.Cmd.Write(mOp.Concat("Código da UnitofMeasure: ",Codigo.get()),"\n");
      //<< set strStatus = $$$Save("VARParametroAtivar",Classe_$$$COMMA_Nome_$$$COMMA_Codigo,objVARParametroAtivar,1)
      strStatus.set(include.COMSYS.$$$Save(m$,"VARParametroAtivar",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(Classe.get(),include.COMSYSString.$$$COMMA(m$)),Nome.get()),include.COMSYSString.$$$COMMA(m$)),Codigo.get()),objVARParametroAtivar,1));
      //<< &sql(FETCH UnitofMeasureCarga)
      m$.Cmd.SQL();
    }
    //<< }
    //<< &sql(CLOSE UnitofMeasureCarga)
    m$.Cmd.SQL();
    //<< 
    //<< // ---------- BaseUnit - INART
    //<< 
    //<< &sql(
    //<< DECLARE BaseUnitCarga CURSOR FOR
    //<< select DISTINCT BaseUnit
    //<< into :Codigo
    //<< from INART
    //<< where BaseUnit IS NOT NULL
    //<< )
    m$.Cmd.SQL();
    //<< 
    //<< &sql(OPEN BaseUnitCarga)
    m$.Cmd.SQL();
    //<< &sql(FETCH BaseUnitCarga)
    m$.Cmd.SQL();
    //<< 
    //<< write !,"Executando carga baseada no campo BaseUnit da INART: ",!
    m$.Cmd.Write("\n","Executando carga baseada no campo BaseUnit da INART: ","\n");
    //<< hang 1
    m$.Cmd.Hang(1);
    //<< 
    //<< while (SQLCODE = 0) {
    while ((mOp.Equal(m$.var("SQLCODE").get(),0))) {
      //<< write "Código da BaseUnit: "_Codigo,!
      m$.Cmd.Write(mOp.Concat("Código da BaseUnit: ",Codigo.get()),"\n");
      //<< set strStatus = $$$Save("VARParametroAtivar",Classe_$$$COMMA_Nome_$$$COMMA_Codigo,objVARParametroAtivar,1)
      strStatus.set(include.COMSYS.$$$Save(m$,"VARParametroAtivar",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(Classe.get(),include.COMSYSString.$$$COMMA(m$)),Nome.get()),include.COMSYSString.$$$COMMA(m$)),Codigo.get()),objVARParametroAtivar,1));
      //<< &sql(FETCH BaseUnitCarga)
      m$.Cmd.SQL();
    }
    //<< }
    //<< &sql(CLOSE BaseUnitCarga)
    m$.Cmd.SQL();
    //<< 
    //<< // ---------- OuterUnit - INARTPACK
    //<< 
    //<< &sql(
    //<< DECLARE OuterUnitCarga CURSOR FOR
    //<< select DISTINCT OuterUnit
    //<< into :Codigo
    //<< from INARTPACK
    //<< where OuterUnit IS NOT NULL
    //<< )
    m$.Cmd.SQL();
    //<< 
    //<< &sql(OPEN OuterUnitCarga)
    m$.Cmd.SQL();
    //<< &sql(FETCH OuterUnitCarga)
    m$.Cmd.SQL();
    //<< 
    //<< write !,"Executando carga baseada no campo OuterUnit da INARTPACK: ",!
    m$.Cmd.Write("\n","Executando carga baseada no campo OuterUnit da INARTPACK: ","\n");
    //<< hang 1
    m$.Cmd.Hang(1);
    //<< 
    //<< while (SQLCODE = 0) {
    while ((mOp.Equal(m$.var("SQLCODE").get(),0))) {
      //<< write "Código da OuterUnit: "_Codigo,!
      m$.Cmd.Write(mOp.Concat("Código da OuterUnit: ",Codigo.get()),"\n");
      //<< set strStatus = $$$Save("VARParametroAtivar",Classe_$$$COMMA_Nome_$$$COMMA_Codigo,objVARParametroAtivar,1)
      strStatus.set(include.COMSYS.$$$Save(m$,"VARParametroAtivar",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(Classe.get(),include.COMSYSString.$$$COMMA(m$)),Nome.get()),include.COMSYSString.$$$COMMA(m$)),Codigo.get()),objVARParametroAtivar,1));
      //<< &sql(FETCH OuterUnitCarga)
      m$.Cmd.SQL();
    }
    //<< }
    //<< &sql(CLOSE OuterUnitCarga)
    m$.Cmd.SQL();
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
}
