//*****************************************************************************
//** TASC - ALPHALINC - MAC VARINARTT1
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 19:26:16
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
//<< #include VARConst
import include.VARConst;

//<< VARINARTT1
public class VARINARTT1 extends mClass {

  public void main() {
    _VARINARTT1();
  }

  public void _VARINARTT1() {
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< OnAfterDataFields(pYKEY)
  public Object OnAfterDataFields(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< 
    //<< if YSEITE = 1 {
    if (mOp.Equal(m$.var("YSEITE").get(),1)) {
      //<< do LoadGrid(pYKEY)
      m$.Cmd.Do("LoadGrid",pYKEY.get());
    }
    //<< }
    //<< 
    //<< if YSEITE = 2 {
    if (mOp.Equal(m$.var("YSEITE").get(),2)) {
      //<< do LoadHistorico(pYKEY)
      m$.Cmd.Do("LoadHistorico",pYKEY.get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< 
  //<< LoadGrid(pid="")
  public Object LoadGrid(Object ... _p) {
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< 
    //<< new YFORM,YKEY,YAUSWAHL
    mVar YFORM = m$.var("YFORM");
    mVar YKEY = m$.var("YKEY");
    mVar YAUSWAHL = m$.var("YAUSWAHL");
    m$.newVar(YFORM,YKEY,YAUSWAHL);
    //<< set YFORM="VARINARTT"
    YFORM.set("VARINARTT");
    //<< set YFELD=""
    mVar YFELD = m$.var("YFELD");
    YFELD.set("");
    //<< set YKEY=$get(pid)
    YKEY.set(m$.Fnc.$get(pid));
    //<< 
    //<< set $$$COMGridEditParameterSharedForm(YAUSWAHL)=1
    include.COMConst.$$$COMGridEditParameterSharedFormSet(m$,YAUSWAHL,1);
    //<< set $$$COMGridEditParameterMaximumHeight(YAUSWAHL)=400
    include.COMConst.$$$COMGridEditParameterMaximumHeightSet(m$,YAUSWAHL,400);
    //<< set $$$COMGridEditParameterGridName(YAUSWAHL)=YFORM
    include.COMConst.$$$COMGridEditParameterGridNameSet(m$,YAUSWAHL,YFORM.get());
    //<< set $$$COMGridEditParameterEnabled(YAUSWAHL)='($$$WWW120AuthorizationToModifyData(YVOR)=5)
    include.COMConst.$$$COMGridEditParameterEnabledSet(m$,YAUSWAHL,mOp.Not((mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),5))));
    //<< set $$$COMGridEditParameterContainer(YAUSWAHL)="VARINARTT1"
    include.COMConst.$$$COMGridEditParameterContainerSet(m$,YAUSWAHL,"VARINARTT1");
    //<< 
    //<< $$$GRIDStart(YFORM,YKEY)
    include.COMGridEdit31Interface.$$$GRIDStart(m$,YFORM,YKEY);
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< 
  //<< OnBeforeSave(pYKEY)
  public Object OnBeforeSave(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< do SalvarHistoricoKitAntes(YKEY)
    m$.Cmd.Do("SalvarHistoricoKitAntes",m$.var("YKEY").get());
    //<< 
    //<< set teste = $$$GRIDPREVYMFELDContainer
    mVar teste = m$.var("teste");
    teste.set(include.COMGridEdit31Interface.$$$GRIDPREVYMFELDContainer(m$));
    //<< 
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< set strStatus = $$$GRIDSave(pYKEY)
    strStatus.set(include.COMGridEdit31Interface.$$$GRIDSave(m$,pYKEY));
    //<< 
    //<< if (strStatus = 1){
    if ((mOp.Equal(strStatus.get(),1))) {
      //<< do SalvarHistoricoKitDepois(YKEY)
      m$.Cmd.Do("SalvarHistoricoKitDepois",m$.var("YKEY").get());
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< PodeCadastrarModelo(pYKEY)
  public Object PodeCadastrarModelo(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;do PodeCadastrarModelo^VARINARTT1(pYKEY)
    //<< ;
    //<< ;Rotina que verifica se o produto é um kit, se for pode cadastrar um modelo.
    //<< 
    //<< quit:pYKEY=""
    if (mOp.Equal(pYKEY.get(),"")) {
      return null;
    }
    //<< 
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< 
      //<< set pYFELD = $get(^INART(YM,pYKEY,1))
      mVar pYFELD = m$.var("pYFELD");
      pYFELD.set(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),pYKEY.get(),1)));
      //<< set Origem = $piece(pYFELD,Y,26)
      mVar Origem = m$.var("Origem");
      Origem.set(m$.Fnc.$piece(pYFELD.get(),m$.var("Y").get(),26));
      //<< 
      //<< if (Origem '= 3){
      if ((mOp.NotEqual(Origem.get(),3))) {
        //<< set strStatus = "Para cadastrar um modelo de Kit, o campo 'Origem' deve ser igual a Produzir."
        strStatus.set("Para cadastrar um modelo de Kit, o campo 'Origem' deve ser igual a Produzir.");
      }
    }
    //<< }
    //<< 
    //<< }
    //<< 
    //<< $$$YQHandler(strStatus)
    include.COMSYS.$$$YQHandler(m$,strStatus);
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PermiteEditarModelo(pYKEY)
  public Object PermiteEditarModelo(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;$$PermiteEditarModelo^VARINARTT1(pYKEY)
    //<< 
    //<< new Result,idProducao,objProducao,CodigoKit
    mVar Result = m$.var("Result");
    mVar idProducao = m$.var("idProducao");
    mVar objProducao = m$.var("objProducao");
    mVar CodigoKit = m$.var("CodigoKit");
    m$.newVar(Result,idProducao,objProducao,CodigoKit);
    //<< 
    //<< set Result = $$$YES
    Result.set(include.COMSYS.$$$YES(m$));
    //<< set idProducao = ""
    idProducao.set("");
    //<< for {
    for (;true;) {
      //<< set idProducao = $order(^INMO(YM,idProducao))
      idProducao.set(m$.Fnc.$order(m$.var("^INMO",m$.var("YM").get(),idProducao.get())));
      //<< quit:(idProducao = "")
      if ((mOp.Equal(idProducao.get(),""))) {
        break;
      }
      //<< 
      //<< set objProducao = $G(^INMO(YM,idProducao,1))
      objProducao.set(m$.Fnc.$get(m$.var("^INMO",m$.var("YM").get(),idProducao.get(),1)));
      //<< set CodigoKit   = $piece(objProducao,Y,2)
      CodigoKit.set(m$.Fnc.$piece(objProducao.get(),m$.var("Y").get(),2));
      //<< if (CodigoKit = pYKEY){
      if ((mOp.Equal(CodigoKit.get(),pYKEY.get()))) {
        //<< set Result = $$$NO
        Result.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< 
    //<< }
    //<< 
    //<< quit Result
    return Result.get();
  }

  //<< 
  //<< 
  //<< 
  //<< OnBeforeEditAccess(pYKEY,pYFORM)
  public Object OnBeforeEditAccess(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;$$OnBeforeEditAccess^VARINARTT1(pYKEY,pYFORM)
    //<< new status
    mVar status = m$.var("status");
    m$.newVar(status);
    //<< 
    //<< set status = $$$OK
    status.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if (pYFORM = "VARINARTT1") {
    if ((mOp.Equal(pYFORM.get(),"VARINARTT1"))) {
      //<< set status = $$PermiteEditarModelo(pYKEY)
      status.set(m$.fnc$("PermiteEditarModelo",pYKEY.get()));
    }
    //<< }
    //<< 
    //<< quit status
    return status.get();
  }

  //<< SalvarHistoricoKitAntes(pYKEY)
  public Object SalvarHistoricoKitAntes(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pYKEY = "")
    if ((mOp.Equal(pYKEY.get(),""))) {
      return null;
    }
    //<< 
    //<< set ItemNumber = pYKEY
    mVar ItemNumber = m$.var("ItemNumber");
    ItemNumber.set(pYKEY.get());
    //<< 
    //<< Set HistoricoAlteracaoSQL = ##class(%ResultSet).%New()  ;Create Result Set Object
    mVar HistoricoAlteracaoSQL = m$.var("HistoricoAlteracaoSQL");
    HistoricoAlteracaoSQL.set(m$.fnc$("$ResultSet.$New"));
    //<< 
    //<< set meuSQL = ""
    mVar meuSQL = m$.var("meuSQL");
    meuSQL.set("");
    //<< set meuSQL = meuSQL _ " SELECT "
    meuSQL.set(mOp.Concat(meuSQL.get()," SELECT "));
    //<< set meuSQL = meuSQL _ " ItemNumber1 as ItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," ItemNumber1 as ItemKit, "));
    //<< set meuSQL = meuSQL _ " Pos as Line, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Pos as Line, "));
    //<< set meuSQL = meuSQL _ " Description as DescricaoItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Description as DescricaoItemKit, "));
    //<< set meuSQL = meuSQL _ " Quantity as QuantItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Quantity as QuantItemKit, "));
    //<< set meuSQL = meuSQL _ " Unit as UnitItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Unit as UnitItemKit, "));
    //<< set meuSQL = meuSQL _ " Value1 as CustoItemKit "
    meuSQL.set(mOp.Concat(meuSQL.get()," Value1 as CustoItemKit "));
    //<< set meuSQL = meuSQL _ " FROM SQLUser.INARTT "
    meuSQL.set(mOp.Concat(meuSQL.get()," FROM SQLUser.INARTT "));
    //<< set meuSQL = meuSQL _ " WHERE ItemNumber = """_ItemNumber_""" "
    meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," WHERE ItemNumber = \""),ItemNumber.get()),"\" "));
    //<< 
    //<< do HistoricoAlteracaoSQL.Prepare(meuSQL)  ;Prepare Query
    m$.Cmd.Do(HistoricoAlteracaoSQL.getORef(),"Prepare",meuSQL.get());
    //<< do HistoricoAlteracaoSQL.Execute()  ;Execute Query
    m$.Cmd.Do(HistoricoAlteracaoSQL.getORef(),"Execute");
    //<< 
    //<< While (HistoricoAlteracaoSQL.Next()) {
    while (mOp.Logical((m$.fnc$(HistoricoAlteracaoSQL.getORef(),"Next")))) {
      //<< set ItemKit          = HistoricoAlteracaoSQL.GetData(1)
      mVar ItemKit = m$.var("ItemKit");
      ItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",1));
      //<< set Line             = HistoricoAlteracaoSQL.GetData(2)
      mVar Line = m$.var("Line");
      Line.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",2));
      //<< set DescricaoItemKit = HistoricoAlteracaoSQL.GetData(3)
      mVar DescricaoItemKit = m$.var("DescricaoItemKit");
      DescricaoItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",3));
      //<< set QuantItemKit     = HistoricoAlteracaoSQL.GetData(4)
      mVar QuantItemKit = m$.var("QuantItemKit");
      QuantItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",4));
      //<< set UnitItemKit      = HistoricoAlteracaoSQL.GetData(5)
      mVar UnitItemKit = m$.var("UnitItemKit");
      UnitItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",5));
      //<< set CustoItemKit     = HistoricoAlteracaoSQL.GetData(6)
      mVar CustoItemKit = m$.var("CustoItemKit");
      CustoItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",6));
      //<< 
      //<< set objHistoricoKit = ""
      mVar objHistoricoKit = m$.var("objHistoricoKit");
      objHistoricoKit.set("");
      //<< set objAntes        =  $get(^VARTempHistoricoINARTT1(0,ItemNumber,Line,ItemKit,QuantItemKit,1))
      mVar objAntes = m$.var("objAntes");
      objAntes.set(m$.Fnc.$get(m$.var("^VARTempHistoricoINARTT1",0,ItemNumber.get(),Line.get(),ItemKit.get(),QuantItemKit.get(),1)));
      //<< 
      //<< set $piece(objHistoricoKit,Y,1) = $$$VARTempHistoricoINARTT1Usuario(objAntes)
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),1).set(include.VARConst.$$$VARTempHistoricoINARTT1Usuario(m$,objAntes));
      //<< set $piece(objHistoricoKit,Y,2) = $$$VARTempHistoricoINARTT1DataAlteracao(objAntes)
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),2).set(include.VARConst.$$$VARTempHistoricoINARTT1DataAlteracao(m$,objAntes));
      //<< set $piece(objHistoricoKit,Y,3) = $$$VARTempHistoricoINARTT1HoraAlteracao(objAntes)
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),3).set(include.VARConst.$$$VARTempHistoricoINARTT1HoraAlteracao(m$,objAntes));
      //<< set $piece(objHistoricoKit,Y,4) = $$$VARTempHistoricoINARTT1DescricaoItemKit(objAntes)
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),4).set(include.VARConst.$$$VARTempHistoricoINARTT1DescricaoItemKit(m$,objAntes));
      //<< set $piece(objHistoricoKit,Y,5) = $$$VARTempHistoricoINARTT1QuantItemKit(objAntes)
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),5).set(include.VARConst.$$$VARTempHistoricoINARTT1QuantItemKit(m$,objAntes));
      //<< set $piece(objHistoricoKit,Y,6) = $$$VARTempHistoricoINARTT1UnitItemKit(objAntes)
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),6).set(include.VARConst.$$$VARTempHistoricoINARTT1UnitItemKit(m$,objAntes));
      //<< set $piece(objHistoricoKit,Y,7) = $$$VARTempHistoricoINARTT1CustoItemKit(objAntes)
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),7).set(include.VARConst.$$$VARTempHistoricoINARTT1CustoItemKit(m$,objAntes));
      //<< set $piece(objHistoricoKit,Y,8) = "ANTES"
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),8).set("ANTES");
      //<< set $piece(objHistoricoKit,Y,9) = 1
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),9).set(1);
      //<< 
      //<< set stKey     = ItemNumber_$$$COMMA_Line_$$$COMMA_ItemKit_$$$COMMA_QuantItemKit
      mVar stKey = m$.var("stKey");
      stKey.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(ItemNumber.get(),include.COMSYSString.$$$COMMA(m$)),Line.get()),include.COMSYSString.$$$COMMA(m$)),ItemKit.get()),include.COMSYSString.$$$COMMA(m$)),QuantItemKit.get()));
      //<< set StrStatus = $$$Save("VARTempHistoricoINARTT1",stKey,objHistoricoKit,1)
      mVar StrStatus = m$.var("StrStatus");
      StrStatus.set(include.COMSYS.$$$Save(m$,"VARTempHistoricoINARTT1",stKey,objHistoricoKit,1));
    }
    //<< }
    //<< 
    //<< do HistoricoAlteracaoSQL.Close()
    m$.Cmd.Do(HistoricoAlteracaoSQL.getORef(),"Close");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SalvarHistoricoKitDepois(pYKEY)
  public Object SalvarHistoricoKitDepois(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pYKEY = "")
    if ((mOp.Equal(pYKEY.get(),""))) {
      return null;
    }
    //<< 
    //<< set ItemNumber = pYKEY
    mVar ItemNumber = m$.var("ItemNumber");
    ItemNumber.set(pYKEY.get());
    //<< 
    //<< Set HistoricoAlteracaoSQL = ##class(%ResultSet).%New()  ;Create Result Set Object
    mVar HistoricoAlteracaoSQL = m$.var("HistoricoAlteracaoSQL");
    HistoricoAlteracaoSQL.set(m$.fnc$("$ResultSet.$New"));
    //<< 
    //<< set meuSQL = ""
    mVar meuSQL = m$.var("meuSQL");
    meuSQL.set("");
    //<< set meuSQL = meuSQL _ " SELECT "
    meuSQL.set(mOp.Concat(meuSQL.get()," SELECT "));
    //<< set meuSQL = meuSQL _ " ItemNumber1 as ItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," ItemNumber1 as ItemKit, "));
    //<< set meuSQL = meuSQL _ " Pos as Line, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Pos as Line, "));
    //<< set meuSQL = meuSQL _ " Description as DescricaoItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Description as DescricaoItemKit, "));
    //<< set meuSQL = meuSQL _ " Quantity as QuantItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Quantity as QuantItemKit, "));
    //<< set meuSQL = meuSQL _ " Unit as UnitItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Unit as UnitItemKit, "));
    //<< set meuSQL = meuSQL _ " Value1 as CustoItemKit "
    meuSQL.set(mOp.Concat(meuSQL.get()," Value1 as CustoItemKit "));
    //<< set meuSQL = meuSQL _ " FROM SQLUser.INARTT "
    meuSQL.set(mOp.Concat(meuSQL.get()," FROM SQLUser.INARTT "));
    //<< set meuSQL = meuSQL _ " WHERE ItemNumber = """_ItemNumber_""" "
    meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," WHERE ItemNumber = \""),ItemNumber.get()),"\" "));
    //<< 
    //<< do HistoricoAlteracaoSQL.Prepare(meuSQL)  ;Prepare Query
    m$.Cmd.Do(HistoricoAlteracaoSQL.getORef(),"Prepare",meuSQL.get());
    //<< do HistoricoAlteracaoSQL.Execute()  ;Execute Query
    m$.Cmd.Do(HistoricoAlteracaoSQL.getORef(),"Execute");
    //<< 
    //<< While (HistoricoAlteracaoSQL.Next()) {
    while (mOp.Logical((m$.fnc$(HistoricoAlteracaoSQL.getORef(),"Next")))) {
      //<< set ItemKit          = HistoricoAlteracaoSQL.GetData(1)
      mVar ItemKit = m$.var("ItemKit");
      ItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",1));
      //<< set Line             = HistoricoAlteracaoSQL.GetData(2)
      mVar Line = m$.var("Line");
      Line.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",2));
      //<< set DescricaoItemKit = HistoricoAlteracaoSQL.GetData(3)
      mVar DescricaoItemKit = m$.var("DescricaoItemKit");
      DescricaoItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",3));
      //<< set QuantItemKit     = HistoricoAlteracaoSQL.GetData(4)
      mVar QuantItemKit = m$.var("QuantItemKit");
      QuantItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",4));
      //<< set UnitItemKit      = HistoricoAlteracaoSQL.GetData(5)
      mVar UnitItemKit = m$.var("UnitItemKit");
      UnitItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",5));
      //<< set CustoItemKit     = HistoricoAlteracaoSQL.GetData(6)
      mVar CustoItemKit = m$.var("CustoItemKit");
      CustoItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",6));
      //<< 
      //<< set objHistoricoKit = ""
      mVar objHistoricoKit = m$.var("objHistoricoKit");
      objHistoricoKit.set("");
      //<< 
      //<< set $piece(objHistoricoKit,Y,1) = YBED
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),1).set(m$.var("YBED").get());
      //<< set $piece(objHistoricoKit,Y,2) = $piece($horolog,$$$COMMA,1)
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),2).set(m$.Fnc.$piece(m$.Fnc.$horolog(),include.COMSYSString.$$$COMMA(m$),1));
      //<< set $piece(objHistoricoKit,Y,3) = $piece($horolog,$$$COMMA,2)
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),3).set(m$.Fnc.$piece(m$.Fnc.$horolog(),include.COMSYSString.$$$COMMA(m$),2));
      //<< set $piece(objHistoricoKit,Y,4) = DescricaoItemKit
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),4).set(DescricaoItemKit.get());
      //<< set $piece(objHistoricoKit,Y,5) = QuantItemKit
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),5).set(QuantItemKit.get());
      //<< set $piece(objHistoricoKit,Y,6) = UnitItemKit
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),6).set(UnitItemKit.get());
      //<< set $piece(objHistoricoKit,Y,7) = CustoItemKit
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),7).set(CustoItemKit.get());
      //<< set $piece(objHistoricoKit,Y,8) = "DEPOIS"
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),8).set("DEPOIS");
      //<< set $piece(objHistoricoKit,Y,9) = 2
      m$.pieceVar(objHistoricoKit,m$.var("Y").get(),9).set(2);
      //<< 
      //<< set stKey     = ItemNumber_$$$COMMA_Line_$$$COMMA_ItemKit_$$$COMMA_QuantItemKit
      mVar stKey = m$.var("stKey");
      stKey.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(ItemNumber.get(),include.COMSYSString.$$$COMMA(m$)),Line.get()),include.COMSYSString.$$$COMMA(m$)),ItemKit.get()),include.COMSYSString.$$$COMMA(m$)),QuantItemKit.get()));
      //<< set StrStatus = $$$Save("VARTempHistoricoINARTT1",stKey,objHistoricoKit,1)
      mVar StrStatus = m$.var("StrStatus");
      StrStatus.set(include.COMSYS.$$$Save(m$,"VARTempHistoricoINARTT1",stKey,objHistoricoKit,1));
    }
    //<< }
    //<< 
    //<< do HistoricoAlteracaoSQL.Close()
    m$.Cmd.Do(HistoricoAlteracaoSQL.getORef(),"Close");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< LoadHistorico(pYKEY)
  public Object LoadHistorico(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pYKEY = "")
    if ((mOp.Equal(pYKEY.get(),""))) {
      return null;
    }
    //<< 
    //<< set ItemNumber = pYKEY
    mVar ItemNumber = m$.var("ItemNumber");
    ItemNumber.set(pYKEY.get());
    //<< 
    //<< Set HistoricoAlteracaoSQL = ##class(%ResultSet).%New()  ;Create Result Set Object
    mVar HistoricoAlteracaoSQL = m$.var("HistoricoAlteracaoSQL");
    HistoricoAlteracaoSQL.set(m$.fnc$("$ResultSet.$New"));
    //<< 
    //<< set meuSQL = ""
    mVar meuSQL = m$.var("meuSQL");
    meuSQL.set("");
    //<< set meuSQL = meuSQL _ " SELECT "
    meuSQL.set(mOp.Concat(meuSQL.get()," SELECT "));
    //<< set meuSQL = meuSQL _ " ItemKit as ItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," ItemKit as ItemKit, "));
    //<< set meuSQL = meuSQL _ " Line as Line, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Line as Line, "));
    //<< set meuSQL = meuSQL _ " DescricaoItemKit as DescricaoItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," DescricaoItemKit as DescricaoItemKit, "));
    //<< set meuSQL = meuSQL _ " QuantItemKit as QuantItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," QuantItemKit as QuantItemKit, "));
    //<< set meuSQL = meuSQL _ " UnitItemKit as UnitItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," UnitItemKit as UnitItemKit, "));
    //<< set meuSQL = meuSQL _ " CustoItemKit as CustoItemKit, "
    meuSQL.set(mOp.Concat(meuSQL.get()," CustoItemKit as CustoItemKit, "));
    //<< set meuSQL = meuSQL _ " HoraAlteracao as HoraAlteracao, "
    meuSQL.set(mOp.Concat(meuSQL.get()," HoraAlteracao as HoraAlteracao, "));
    //<< set meuSQL = meuSQL _ " DataAlteracao as DataAlteracao, "
    meuSQL.set(mOp.Concat(meuSQL.get()," DataAlteracao as DataAlteracao, "));
    //<< set meuSQL = meuSQL _ " Usuario as Usuario, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Usuario as Usuario, "));
    //<< set meuSQL = meuSQL _ " Situacao as Situacao "
    meuSQL.set(mOp.Concat(meuSQL.get()," Situacao as Situacao "));
    //<< set meuSQL = meuSQL _ " FROM SQLUser.VARTempHistoricoINARTT1 "
    meuSQL.set(mOp.Concat(meuSQL.get()," FROM SQLUser.VARTempHistoricoINARTT1 "));
    //<< set meuSQL = meuSQL _ " WHERE ItemNumber = """_ItemNumber_""" "
    meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," WHERE ItemNumber = \""),ItemNumber.get()),"\" "));
    //<< set meuSQL = meuSQL _ " AND ((DataAlteracao >= ( select MAX(DataAlteracao) from VARTempHistoricoINARTT1 where cdSituacao = '2' )) "
    meuSQL.set(mOp.Concat(meuSQL.get()," AND ((DataAlteracao >= ( select MAX(DataAlteracao) from VARTempHistoricoINARTT1 where cdSituacao = '2' )) "));
    //<< set meuSQL = meuSQL _ " OR (DataAlteracao >= ( select MAX(DataAlteracao) from VARTempHistoricoINARTT1 where cdSituacao = '1' )))  "
    meuSQL.set(mOp.Concat(meuSQL.get()," OR (DataAlteracao >= ( select MAX(DataAlteracao) from VARTempHistoricoINARTT1 where cdSituacao = '1' )))  "));
    //<< set meuSQL = meuSQL _ " AND ((HoraAlteracao <= ( select MAX(HoraAlteracao) from VARTempHistoricoINARTT1 where cdSituacao = '2' )) "
    meuSQL.set(mOp.Concat(meuSQL.get()," AND ((HoraAlteracao <= ( select MAX(HoraAlteracao) from VARTempHistoricoINARTT1 where cdSituacao = '2' )) "));
    //<< set meuSQL = meuSQL _ " OR (HoraAlteracao <= ( select MAX(HoraAlteracao) from VARTempHistoricoINARTT1 where cdSituacao = '1' )))  "
    meuSQL.set(mOp.Concat(meuSQL.get()," OR (HoraAlteracao <= ( select MAX(HoraAlteracao) from VARTempHistoricoINARTT1 where cdSituacao = '1' )))  "));
    //<< set meuSQL = meuSQL _ " GROUP BY Line,cdSituacao "
    meuSQL.set(mOp.Concat(meuSQL.get()," GROUP BY Line,cdSituacao "));
    //<< set meuSQL = meuSQL _ " ORDER BY Line,cdSituacao,DataAlteracao,HoraAlteracao DESC "
    meuSQL.set(mOp.Concat(meuSQL.get()," ORDER BY Line,cdSituacao,DataAlteracao,HoraAlteracao DESC "));
    //<< 
    //<< do HistoricoAlteracaoSQL.Prepare(meuSQL)  ;Prepare Query
    m$.Cmd.Do(HistoricoAlteracaoSQL.getORef(),"Prepare",meuSQL.get());
    //<< do HistoricoAlteracaoSQL.Execute()  ;Execute Query
    m$.Cmd.Do(HistoricoAlteracaoSQL.getORef(),"Execute");
    //<< 
    //<< set lstHeader = $listbuild("Seq.","Linha","Data Alteração"," Hora Alteração","Usuário","Cód Produto","Descrição","Quant.","Unidade","Custo Total")
    mVar lstHeader = m$.var("lstHeader");
    lstHeader.set(m$.Fnc.$listbuild("Seq.","Linha","Data Alteração"," Hora Alteração","Usuário","Cód Produto","Descrição","Quant.","Unidade","Custo Total"));
    //<< 
    //<< write "<b><br>Histórico de Alterações:</b>"
    m$.Cmd.Write("<b><br>Histórico de Alterações:</b>");
    //<< 
    //<< if $$Start^COMTable("") {
    if (mOp.Logical(m$.fnc$("COMTable.Start",""))) {
      //<< 
      //<< set count = 0
      mVar count = m$.var("count");
      count.set(0);
      //<< set LineAnterior = ""
      mVar LineAnterior = m$.var("LineAnterior");
      LineAnterior.set("");
      //<< 
      //<< While (HistoricoAlteracaoSQL.Next()) {
      while (mOp.Logical((m$.fnc$(HistoricoAlteracaoSQL.getORef(),"Next")))) {
        //<< set ItemKit          = HistoricoAlteracaoSQL.GetData(1)
        mVar ItemKit = m$.var("ItemKit");
        ItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",1));
        //<< set Line             = HistoricoAlteracaoSQL.GetData(2)
        mVar Line = m$.var("Line");
        Line.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",2));
        //<< set DescricaoItemKit = HistoricoAlteracaoSQL.GetData(3)
        mVar DescricaoItemKit = m$.var("DescricaoItemKit");
        DescricaoItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",3));
        //<< set QuantItemKit     = HistoricoAlteracaoSQL.GetData(4)
        mVar QuantItemKit = m$.var("QuantItemKit");
        QuantItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",4));
        //<< set UnitItemKit      = HistoricoAlteracaoSQL.GetData(5)
        mVar UnitItemKit = m$.var("UnitItemKit");
        UnitItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",5));
        //<< set CustoItemKit     = HistoricoAlteracaoSQL.GetData(6)
        mVar CustoItemKit = m$.var("CustoItemKit");
        CustoItemKit.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",6));
        //<< set HoraAlteracao    = HistoricoAlteracaoSQL.GetData(7)
        mVar HoraAlteracao = m$.var("HoraAlteracao");
        HoraAlteracao.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",7));
        //<< set DataAlteracao    = HistoricoAlteracaoSQL.GetData(8)
        mVar DataAlteracao = m$.var("DataAlteracao");
        DataAlteracao.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",8));
        //<< set Usuario          = HistoricoAlteracaoSQL.GetData(9)
        mVar Usuario = m$.var("Usuario");
        Usuario.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",9));
        //<< set Situacao         = HistoricoAlteracaoSQL.GetData(10)
        mVar Situacao = m$.var("Situacao");
        Situacao.set(m$.fnc$(HistoricoAlteracaoSQL.getORef(),"GetData",10));
        //<< 
        //<< set count = $increment(count)
        count.set(m$.Fnc.$increment(count));
        //<< 
        //<< if (LineAnterior '= Line){
        if ((mOp.NotEqual(LineAnterior.get(),Line.get()))) {
          //<< do NewLine^COMTable("lightsteelblue")
          m$.Cmd.Do("COMTable.NewLine","lightsteelblue");
          //<< do InsertCell^COMTable("<b>Seq: "_Line_"</b>",,,,,,10)
          m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat("<b>Seq: ",Line.get()),"</b>"),null,null,null,null,null,10);
          //<< do EndLine^COMTable()
          m$.Cmd.Do("COMTable.EndLine");
          //<< 
          //<< do NewLine^COMTable("darkgrey")
          m$.Cmd.Do("COMTable.NewLine","darkgrey");
          //<< do InsertCell^COMTable("<b>Situação</b>",,,,"CENTER")
          m$.Cmd.Do("COMTable.InsertCell","<b>Situação</b>",null,null,null,"CENTER");
          //<< do InsertCell^COMTable("<b>Data Alteração</b>",,,,"CENTER")
          m$.Cmd.Do("COMTable.InsertCell","<b>Data Alteração</b>",null,null,null,"CENTER");
          //<< do InsertCell^COMTable("<b>Hora Alteração</b>",,,,"CENTER")
          m$.Cmd.Do("COMTable.InsertCell","<b>Hora Alteração</b>",null,null,null,"CENTER");
          //<< do InsertCell^COMTable("<b>Alterado Por</b>",,,,"CENTER")
          m$.Cmd.Do("COMTable.InsertCell","<b>Alterado Por</b>",null,null,null,"CENTER");
          //<< do InsertCell^COMTable("<b>Cód Produto</b>",,,,"CENTER")
          m$.Cmd.Do("COMTable.InsertCell","<b>Cód Produto</b>",null,null,null,"CENTER");
          //<< do InsertCell^COMTable("<b>Descrição</b>",,,,"CENTER")
          m$.Cmd.Do("COMTable.InsertCell","<b>Descrição</b>",null,null,null,"CENTER");
          //<< do InsertCell^COMTable("<b>Quant.</b>",,,,"CENTER")
          m$.Cmd.Do("COMTable.InsertCell","<b>Quant.</b>",null,null,null,"CENTER");
          //<< do InsertCell^COMTable("<b>Unidade</b>",,,,"CENTER")
          m$.Cmd.Do("COMTable.InsertCell","<b>Unidade</b>",null,null,null,"CENTER");
          //<< do InsertCell^COMTable("<b>Custo Total</b>",,,,"CENTER")
          m$.Cmd.Do("COMTable.InsertCell","<b>Custo Total</b>",null,null,null,"CENTER");
          //<< do EndLine^COMTable()
          m$.Cmd.Do("COMTable.EndLine");
        }
        //<< 
        //<< }
        //<< 
        //<< if (Situacao = "ANTES") {
        if ((mOp.Equal(Situacao.get(),"ANTES"))) {
          //<< set prefixStyle = "<font color=red style=text-decoration:line-through><span title = 'Registro anterior.'>"
          mVar prefixStyle = m$.var("prefixStyle");
          prefixStyle.set("<font color=red style=text-decoration:line-through><span title = 'Registro anterior.'>");
          //<< set posfixStyle = "</span></font>"
          mVar posfixStyle = m$.var("posfixStyle");
          posfixStyle.set("</span></font>");
        }
        //<< }
        //<< else {
        else {
          //<< set prefixStyle = "<span title = 'Registro atual.'><b>"
          mVar prefixStyle = m$.var("prefixStyle");
          prefixStyle.set("<span title = 'Registro atual.'><b>");
          //<< set posfixStyle = "</b></span>"
          mVar posfixStyle = m$.var("posfixStyle");
          posfixStyle.set("</b></span>");
        }
        //<< }
        //<< 
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< do InsertCell^COMTable(prefixStyle_Situacao_posfixStyle,,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat(m$.var("prefixStyle").get(),Situacao.get()),m$.var("posfixStyle").get()),null,null,null,"CENTER");
        //<< do InsertCell^COMTable(prefixStyle_$zdate(DataAlteracao,4)_posfixStyle,,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat(m$.var("prefixStyle").get(),m$.Fnc.$zdate(DataAlteracao.get(),4)),m$.var("posfixStyle").get()),null,null,null,"CENTER");
        //<< do InsertCell^COMTable(prefixStyle_$ztime(HoraAlteracao)_posfixStyle,,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat(m$.var("prefixStyle").get(),m$.Fnc.$ztime(HoraAlteracao.get())),m$.var("posfixStyle").get()),null,null,null,"CENTER");
        //<< do InsertCell^COMTable(prefixStyle_Usuario_posfixStyle,,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat(m$.var("prefixStyle").get(),Usuario.get()),m$.var("posfixStyle").get()),null,null,null,"CENTER");
        //<< do InsertCell^COMTable(prefixStyle_ItemKit_posfixStyle,,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat(m$.var("prefixStyle").get(),ItemKit.get()),m$.var("posfixStyle").get()),null,null,null,"CENTER");
        //<< do InsertCell^COMTable(prefixStyle_DescricaoItemKit_posfixStyle,,,,"LEFT",,,,,1)
        m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat(m$.var("prefixStyle").get(),DescricaoItemKit.get()),m$.var("posfixStyle").get()),null,null,null,"LEFT",null,null,null,null,1);
        //<< do InsertCell^COMTable(prefixStyle_$$^WWWTR(0,12,QuantItemKit)_posfixStyle,,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat(m$.var("prefixStyle").get(),m$.fnc$("WWWTR.main",0,12,QuantItemKit.get())),m$.var("posfixStyle").get()),null,null,null,"CENTER");
        //<< do InsertCell^COMTable(prefixStyle_$$SQLGetSiglaUnit^VARSQL(UnitItemKit)_posfixStyle,,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat(m$.var("prefixStyle").get(),m$.fnc$("VARSQL.SQLGetSiglaUnit",UnitItemKit.get())),m$.var("posfixStyle").get()),null,null,null,"CENTER");
        //<< do InsertCell^COMTable(prefixStyle_$$^WWWTR(0,8,CustoItemKit)_posfixStyle,,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell",mOp.Concat(mOp.Concat(m$.var("prefixStyle").get(),m$.fnc$("WWWTR.main",0,8,CustoItemKit.get())),m$.var("posfixStyle").get()),null,null,null,"CENTER");
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
        //<< 
        //<< set LineAnterior = Line
        LineAnterior.set(Line.get());
      }
      //<< 
      //<< }
      //<< if (count = 0){
      if ((mOp.Equal(count.get(),0))) {
        //<< do NewLine^COMTable("darkgrey")
        m$.Cmd.Do("COMTable.NewLine","darkgrey");
        //<< do InsertCell^COMTable("<b>Seq.</b>",,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell","<b>Seq.</b>",null,null,null,"CENTER");
        //<< do InsertCell^COMTable("<b>Data Alteração</b>",,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell","<b>Data Alteração</b>",null,null,null,"CENTER");
        //<< do InsertCell^COMTable("<b>Hora Alteração</b>",,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell","<b>Hora Alteração</b>",null,null,null,"CENTER");
        //<< do InsertCell^COMTable("<b>Alterado Por</b>",,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell","<b>Alterado Por</b>",null,null,null,"CENTER");
        //<< do InsertCell^COMTable("<b>Cód Produto</b>",,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell","<b>Cód Produto</b>",null,null,null,"CENTER");
        //<< do InsertCell^COMTable("<b>Descrição</b>",,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell","<b>Descrição</b>",null,null,null,"CENTER");
        //<< do InsertCell^COMTable("<b>Quant.</b>",,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell","<b>Quant.</b>",null,null,null,"CENTER");
        //<< do InsertCell^COMTable("<b>Unidade</b>",,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell","<b>Unidade</b>",null,null,null,"CENTER");
        //<< do InsertCell^COMTable("<b>Custo Total</b>",,,,"CENTER")
        m$.Cmd.Do("COMTable.InsertCell","<b>Custo Total</b>",null,null,null,"CENTER");
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
        //<< 
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< do InsertCell^COMTable("Nenhuma alteração encontrada.",,,,,,10)
        m$.Cmd.Do("COMTable.InsertCell","Nenhuma alteração encontrada.",null,null,null,null,null,10);
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
    //<< do HistoricoAlteracaoSQL.Close()
    m$.Cmd.Do(HistoricoAlteracaoSQL.getORef(),"Close");
    //<< 
    //<< quit
    return null;
  }

//<< 
//<< 
//<< 
}
