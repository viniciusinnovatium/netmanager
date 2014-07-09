//*****************************************************************************
//** TASC - ALPHALINC - MAC VARWWW0121
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-02 15:27:58
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

//<< VARWWW0121
public class VARWWW0121 extends mClass {

  public void main() {
    _VARWWW0121();
  }

  public void _VARWWW0121() {
  }

  //<< 
  //<< VarHookOnAfterSave()
  public Object VarHookOnAfterSave() {
    //<< new strStatus, LocationCompany, LocationCode
    mVar strStatus = m$.var("strStatus");
    mVar LocationCompany = m$.var("LocationCompany");
    mVar LocationCode = m$.var("LocationCode");
    m$.newVar(strStatus,LocationCompany,LocationCode);
    //<< 
    //<< set LocationCompany = $piece(YKEY,YKOMMA,1)
    LocationCompany.set(m$.Fnc.$piece(m$.var("YKEY").get(),m$.var("YKOMMA").get(),1));
    //<< set LocationCode = $piece(YKEY,YKOMMA,2)
    LocationCode.set(m$.Fnc.$piece(m$.var("YKEY").get(),m$.var("YKOMMA").get(),2));
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< //Cria somente para locais do tipo Departamento
    //<< if $$$WWW0121LocationType(YFELD) '= 2 {
    if (mOp.NotEqual(include.WWWConst.$$$WWW0121LocationType(m$,m$.var("YFELD")),2)) {
      //<< quit strStatus
      return strStatus.get();
    }
    //<< }
    //<< 
    //<< //Cria somente para locais do tipo armazenagem
    //<< if $$$WWW0121StorageLocn(YFELD) '= 1 {
    if (mOp.NotEqual(include.WWWConst.$$$WWW0121StorageLocn(m$,m$.var("YFELD")),1)) {
      //<< quit strStatus
      return strStatus.get();
    }
    //<< }
    //<< 
    //<< // Cria Endereço EmTransito
    //<< set strStatus = $$CreateInTransitStorage(LocationCode,YFELD)
    strStatus.set(m$.fnc$("CreateInTransitStorage",LocationCode.get(),m$.var("YFELD").get()));
    //<< quit:('strStatus) strStatus
    if ((mOp.Not(strStatus.get()))) {
      return strStatus.get();
    }
    //<< 
    //<< // Cria Transporte para o Local:
    //<< set strStatus = $$CreateTransport(LocationCode)
    strStatus.set(m$.fnc$("CreateTransport",LocationCode.get()));
    //<< 
    //<< //Have to run this in background
    //<< //Create INARTLOCPAR
    //<< if $$$WWW0121FREE8(YFELD)=1 {
    if (mOp.Equal(include.WWWConst.$$$WWW0121FREE8(m$,m$.var("YFELD")),1)) {
      //<< job LoadINARTLOCPAR^VARWWW0121(LocationCode)
      m$.Cmd.Job("VARWWW0121.LoadINARTLOCPAR",LocationCode.get());
    }
    //<< }ELSE {
    else {
      //<< job UnLoadINARTLOCPAR^VARWWW0121(LocationCode)
      m$.Cmd.Job("VARWWW0121.UnLoadINARTLOCPAR",LocationCode.get());
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< CreateInTransitStorage(pSiteLocation,pSiteLocationRecord)
  public Object CreateInTransitStorage(Object ... _p) {
    mVar pSiteLocation = m$.newVarRef("pSiteLocation",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pSiteLocationRecord = m$.newVarRef("pSiteLocationRecord",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< // Para um site-location, cria a InTransit necessária
    //<< // Esta rotina é chamada por VarHookOnBeforeSave^VARWWW0121
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< // Cria o stock-location EmTransito (bloqueado):
    //<< if ('$data(^INLP(YM,pSiteLocation,"EmTransito",1))) {
    if ((mOp.Not(m$.Fnc.$data(m$.var("^INLP",m$.var("YM").get(),pSiteLocation.get(),"EmTransito",1))))) {
      //<< set newINLPRecord = ""
      mVar newINLPRecord = m$.var("newINLPRecord");
      newINLPRecord.set("");
      //<< set $$$INLPLocationHeight(newINLPRecord) = 0
      include.INConst.$$$INLPLocationHeightSet(m$,newINLPRecord,0);
      //<< set $$$INLPFieldWithMultipleLoads(newINLPRecord) = 1
      include.INConst.$$$INLPFieldWithMultipleLoadsSet(m$,newINLPRecord,1);
      //<< set $$$INLPStockLocationIsLocked(newINLPRecord) = 1
      include.INConst.$$$INLPStockLocationIsLockedSet(m$,newINLPRecord,1);
      //<< set strStatus = $$Save^COMUtils("INLP",pSiteLocation_YKOMMA_"EmTransito",newINLPRecord,1)
      strStatus.set(m$.fnc$("COMUtils.Save","INLP",mOp.Concat(mOp.Concat(pSiteLocation.get(),m$.var("YKOMMA").get()),"EmTransito"),newINLPRecord.get(),1));
      //<< quit:('strStatus) strStatus
      if ((mOp.Not(strStatus.get()))) {
        return strStatus.get();
      }
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< CreateTransport(pSiteLocation)
  public Object CreateTransport(Object ... _p) {
    mVar pSiteLocation = m$.newVarRef("pSiteLocation",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< // Cria transporte, se ainda não existe.
    //<< // Esta rotina é chamada por VarHookOnBeforeSave^VARWWW0121
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if ($data(^INDRPUMLKWs(YM,1,$$^WWWUMLAU(pSiteLocation,1))) '= 10) {
    if ((mOp.NotEqual(m$.Fnc.$data(m$.var("^INDRPUMLKWs",m$.var("YM").get(),1,m$.fnc$("WWWUMLAU.main",pSiteLocation.get(),1))),10))) {
      //<< set recordData = $$$Text("MED01234")_" "_pSiteLocation_"~~~"_pSiteLocation_"~EmTransito~~"  ;Transporte ;use text macro;15-Sep-2008
      mVar recordData = m$.var("recordData");
      recordData.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYS.$$$Text(m$,"MED01234")," "),pSiteLocation.get()),"~~~"),pSiteLocation.get()),"~EmTransito~~"));
      //<< set idNovoTransporte=$$^WWWNEXT("INDRPUMLKW")
      mVar idNovoTransporte = m$.var("idNovoTransporte");
      idNovoTransporte.set(m$.fnc$("WWWNEXT.main","INDRPUMLKW"));
      //<< set strStatus = $$Save^COMUtils("INDRPUMLKW",idNovoTransporte,recordData,1)
      strStatus.set(m$.fnc$("COMUtils.Save","INDRPUMLKW",idNovoTransporte.get(),recordData.get(),1));
      //<< quit:('strStatus) strStatus
      if ((mOp.Not(strStatus.get()))) {
        return strStatus.get();
      }
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< OnBeforeFormConstructionCustom
  public void OnBeforeFormConstructionCustom() {
    //<< //OnBeforeFormConstruction na customização do form WWW0121C
    //<< if (YSEITE = 0) {
    if ((mOp.Equal(m$.var("YSEITE").get(),0))) {
      //<< set YSEITE = 50
      mVar YSEITE = m$.var("YSEITE");
      YSEITE.set(50);
      //<< set YOPTION = YPARA
      mVar YOPTION = m$.var("YOPTION");
      YOPTION.set(m$.var("YPARA").get());
    }
    //<< }
    //<< 
    //<< do LoadListaUnidades
    m$.Cmd.Do("LoadListaUnidades");
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< LoadListaUnidades
  public void LoadListaUnidades() {
    //<< //Popula COMTempList apenas com Unidades (ex: hospitais, clínicas, etc.)
    //<< 
    //<< new idLocal, NomeLocal, unidadeLocal, unidadesPermitidasUsuario
    mVar idLocal = m$.var("idLocal");
    mVar NomeLocal = m$.var("NomeLocal");
    mVar unidadeLocal = m$.var("unidadeLocal");
    mVar unidadesPermitidasUsuario = m$.var("unidadesPermitidasUsuario");
    m$.newVar(idLocal,NomeLocal,unidadeLocal,unidadesPermitidasUsuario);
    //<< 
    //<< kill ^COMTempList(YM,YBED,"VARUnidades")
    m$.var("^COMTempList",m$.var("YM").get(),m$.var("YBED").get(),"VARUnidades").kill();
    //<< set unidadesPermitidasUsuario = $$GetUnidadesPermitidasUsuario(YBED)
    unidadesPermitidasUsuario.set(m$.fnc$("GetUnidadesPermitidasUsuario",m$.var("YBED").get()));
    //<< 
    //<< &sql(
    //<< DECLARE CursorUnidades CURSOR FOR
    //<< SELECT Location, LocationName
    //<< INTO :idLocal, :NomeLocal
    //<< FROM WWW0121
    //<< WHERE COMPANY = :YM
    //<< AND FREE12 = 1
    //<< ORDER BY to_number(Location) )
    m$.Cmd.SQL();
    //<< 
    //<< 
    //<< &sql(OPEN CursorUnidades)
    m$.Cmd.SQL();
    //<< IF (SQLCODE) {
    if (mOp.Logical((m$.var("SQLCODE").get()))) {
      //<< QUIT
      return;
    }
    //<< }
    //<< 
    //<< FOR { &sql(FETCH CursorUnidades)
    for (;true;) {
      m$.Cmd.SQL();
      //<< QUIT:SQLCODE
      if (mOp.Logical(m$.var("SQLCODE").get())) {
        break;
      }
      //<< 
      //<< /* Esconde os locais não permitidos caso não esteja na tela de cadastro de usuários.
      //<< Proteção de acesso em outras telas, como VAREstoquePosicao, para que o usuário não
      //<< veja o estoque de uma unidade a qual não tem acesso.  */
      //<< if ( (YFORM '= "WWW0121") && (YFORM '= "WWW0121C") ) {
      if (mOp.Logical(((mOp.NotEqual(m$.var("YFORM").get(),"WWW0121")) && (mOp.NotEqual(m$.var("YFORM").get(),"WWW0121C"))))) {
        //<< continue:( '$find(";"_unidadesPermitidasUsuario_";",";"_idLocal_";") )
        if ((mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",unidadesPermitidasUsuario.get()),";"),mOp.Concat(mOp.Concat(";",idLocal.get()),";"))))) {
          continue;
        }
      }
      //<< }
      //<< 
      //<< set ^COMTempList(YM,YBED,"VARUnidades",idLocal,1) = NomeLocal
      m$.var("^COMTempList",m$.var("YM").get(),m$.var("YBED").get(),"VARUnidades",idLocal.get(),1).set(NomeLocal.get());
    }
    //<< }
    //<< 
    //<< &sql(CLOSE CursorUnidades)
    m$.Cmd.SQL();
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< GetUnidadedoLocal(pidLocal)
  public Object GetUnidadedoLocal(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< //Retorna a unidade do local
    //<< quit:(pidLocal = "") ""
    if ((mOp.Equal(pidLocal.get(),""))) {
      return "";
    }
    //<< quit $piece($get(^WWW0121(YM,YM,pidLocal,1)),Y,80)
    return m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0121",m$.var("YM").get(),m$.var("YM").get(),pidLocal.get(),1)),m$.var("Y").get(),80);
  }

  //<< 
  //<< GetUnidadesPermitidasUsuario(pidUsuario)
  public Object GetUnidadesPermitidasUsuario(Object ... _p) {
    mVar pidUsuario = m$.newVarRef("pidUsuario",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pidUsuario = "") ""
    if ((mOp.Equal(pidUsuario.get(),""))) {
      return "";
    }
    //<< 
    //<< new objUsuario, strLocaisPermitidos, cnt, idLocal, codUnidade, strUnidadesPermitidas
    mVar objUsuario = m$.var("objUsuario");
    mVar strLocaisPermitidos = m$.var("strLocaisPermitidos");
    mVar cnt = m$.var("cnt");
    mVar idLocal = m$.var("idLocal");
    mVar codUnidade = m$.var("codUnidade");
    mVar strUnidadesPermitidas = m$.var("strUnidadesPermitidas");
    m$.newVar(objUsuario,strLocaisPermitidos,cnt,idLocal,codUnidade,strUnidadesPermitidas);
    //<< 
    //<< set objUsuario = $get(^WWW013(YM,pidUsuario,1))
    objUsuario.set(m$.Fnc.$get(m$.var("^WWW013",m$.var("YM").get(),pidUsuario.get(),1)));
    //<< set strLocaisPermitidos = $$$WWW013AllowedLocations(objUsuario)
    strLocaisPermitidos.set(include.WWWConst.$$$WWW013AllowedLocations(m$,objUsuario));
    //<< 
    //<< set strUnidadesPermitidas = ""
    strUnidadesPermitidas.set("");
    //<< 
    //<< for cnt = 1:1:$length(strLocaisPermitidos,";") {
    for (cnt.set(1);(mOp.LessOrEqual(cnt.get(),m$.Fnc.$length(strLocaisPermitidos.get(),";")));cnt.set(mOp.Add(cnt.get(),1))) {
      //<< set idLocal = $piece(strLocaisPermitidos,";",cnt)
      idLocal.set(m$.Fnc.$piece(strLocaisPermitidos.get(),";",cnt.get()));
      //<< quit:(idLocal = "")
      if ((mOp.Equal(idLocal.get(),""))) {
        break;
      }
      //<< 
      //<< set strUnidadesPermitidas = strUnidadesPermitidas_";"_idLocal
      strUnidadesPermitidas.set(mOp.Concat(mOp.Concat(strUnidadesPermitidas.get(),";"),idLocal.get()));
    }
    //<< }
    //<< 
    //<< quit strUnidadesPermitidas
    return strUnidadesPermitidas.get();
  }

  //<< 
  //<< 
  //<< GetLocaisdeEstoqueUnidade(pidUnidade)
  public Object GetLocaisdeEstoqueUnidade(Object ... _p) {
    mVar pidUnidade = m$.newVarRef("pidUnidade",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< // Retorna os locais de estoque que pertencem a uma determinada unidade,
    //<< // onde unidade é representada por um local que tem o FREE12 = 1 (É Unidade de Saúde?),
    //<< // e os locais de estoque são aqueles em que o FREE13 apontam para o local que é unidade.
    //<< quit:(pidUnidade = "") ""
    if ((mOp.Equal(pidUnidade.get(),""))) {
      return "";
    }
    //<< 
    //<< new CodLocal, NomeLocal, UnidadedoLocal, strLocaisEstoque
    mVar CodLocal = m$.var("CodLocal");
    mVar NomeLocal = m$.var("NomeLocal");
    mVar UnidadedoLocal = m$.var("UnidadedoLocal");
    mVar strLocaisEstoque = m$.var("strLocaisEstoque");
    m$.newVar(CodLocal,NomeLocal,UnidadedoLocal,strLocaisEstoque);
    //<< 
    //<< &sql(
    //<< DECLARE CursorLocaisEstoque CURSOR FOR
    //<< SELECT Location, LocationName, FREE13
    //<< INTO :CodLocal, :NomeLocal, :UnidadedoLocal
    //<< FROM WWW0121
    //<< WHERE COMPANY = :YM
    //<< AND FREE13 = :pidUnidade
    //<< AND UPPER(StorageLocn) = 1
    //<< ORDER BY to_number(Location) )
    m$.Cmd.SQL();
    //<< 
    //<< &sql(open CursorLocaisEstoque)
    m$.Cmd.SQL();
    //<< if (SQLCODE) {
    if (mOp.Logical((m$.var("SQLCODE").get()))) {
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< set strLocaisEstoque = ""
    strLocaisEstoque.set("");
    //<< 
    //<< for { &sql(fetch CursorLocaisEstoque)
    for (;true;) {
      m$.Cmd.SQL();
      //<< QUIT:SQLCODE
      if (mOp.Logical(m$.var("SQLCODE").get())) {
        break;
      }
      //<< 
      //<< ;;Caso o local não esteja na lista de locais permitidos ao usuário, não popula
      //<< 
      //<< if (strLocaisEstoque = "") {
      if ((mOp.Equal(strLocaisEstoque.get(),""))) {
        //<< set strLocaisEstoque = CodLocal
        strLocaisEstoque.set(CodLocal.get());
      }
      //<< } else {
      else {
        //<< set strLocaisEstoque = strLocaisEstoque_";"_CodLocal
        strLocaisEstoque.set(mOp.Concat(mOp.Concat(strLocaisEstoque.get(),";"),CodLocal.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< &sql(close CursorLocaisEstoque)
    m$.Cmd.SQL();
    //<< 
    //<< quit strLocaisEstoque
    return strLocaisEstoque.get();
  }

  //<< 
  //<< PrintMsgEstoquesDaUnidade(pidUnidade)
  public Object PrintMsgEstoquesDaUnidade(Object ... _p) {
    mVar pidUnidade = m$.newVarRef("pidUnidade",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;Exibe caixa com a mensagem de quais locais de estoque estão sendo considerados em uma determinada unidade
    //<< quit:(pidUnidade = "")
    if ((mOp.Equal(pidUnidade.get(),""))) {
      return null;
    }
    //<< 
    //<< new strLocaisEstoque, cnt, idLocal
    mVar strLocaisEstoque = m$.var("strLocaisEstoque");
    mVar cnt = m$.var("cnt");
    mVar idLocal = m$.var("idLocal");
    m$.newVar(strLocaisEstoque,cnt,idLocal);
    //<< 
    //<< w "<br />"
    m$.Cmd.Write("<br />");
    //<< w "<div style=border-color:999999;border-width:1px;border-style=solid;background-color:#E0E0E0;margin-top:6px;margin-bottom:5px;padding-top:4px;padding-right:12px;padding-bottom:4px;padding-left:10px>"
    m$.Cmd.Write("<div style=border-color:999999;border-width:1px;border-style=solid;background-color:#E0E0E0;margin-top:6px;margin-bottom:5px;padding-top:4px;padding-right:12px;padding-bottom:4px;padding-left:10px>");
    //<< w " <font size=2>"
    m$.Cmd.Write(" <font size=2>");
    //<< w "   <strong>Observação:</strong> as informações de estoque da unidade selecionada correspondem à somatória do estoque do(s) local(ais) "
    m$.Cmd.Write("   <strong>Observação:</strong> as informações de estoque da unidade selecionada correspondem à somatória do estoque do(s) local(ais) ");
    //<< 
    //<< set strLocaisEstoque = $$GetLocaisdeEstoqueUnidade(pidUnidade)
    strLocaisEstoque.set(m$.fnc$("GetLocaisdeEstoqueUnidade",pidUnidade.get()));
    //<< 
    //<< for cnt = 1:1:$length(strLocaisEstoque,";") {
    for (cnt.set(1);(mOp.LessOrEqual(cnt.get(),m$.Fnc.$length(strLocaisEstoque.get(),";")));cnt.set(mOp.Add(cnt.get(),1))) {
      //<< set idLocal = $piece(strLocaisEstoque,";",cnt)
      idLocal.set(m$.Fnc.$piece(strLocaisEstoque.get(),";",cnt.get()));
      //<< quit:(idLocal = "")
      if ((mOp.Equal(idLocal.get(),""))) {
        break;
      }
      //<< 
      //<< if (cnt > 1) w ", "
      if ((mOp.Greater(cnt.get(),1))) {
        m$.Cmd.Write(", ");
      }
      //<< w $$SQLGetLocationName^VARTRKSQL(idLocal)
      m$.Cmd.Write(m$.fnc$("VARTRKSQL.SQLGetLocationName",idLocal.get()));
    }
    //<< }
    //<< 
    //<< w "."
    m$.Cmd.Write(".");
    //<< w " </font>"
    m$.Cmd.Write(" </font>");
    //<< w "</div>"
    m$.Cmd.Write("</div>");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< OnDataAccess(pYKEY,pYFORM)
  public Object OnDataAccess(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< new objWWW0121
    mVar objWWW0121 = m$.var("objWWW0121");
    m$.newVar(objWWW0121);
    //<< set pYKEY=$$$KEY2(pYKEY)
    pYKEY.set(include.COMSYSWWW.$$$KEY2(m$,pYKEY));
    //<< set strStatus=$$$YES
    mVar strStatus = m$.var("strStatus");
    strStatus.set(include.COMSYS.$$$YES(m$));
    //<< if ((pYFORM'="WWW0121C") && (pYKEY'="")) {
    if (mOp.Logical(((mOp.NotEqual(pYFORM.get(),"WWW0121C")) && (mOp.NotEqual(pYKEY.get(),""))))) {
      //<< set objWWW0121=$get(^WWW0121(YM,YM,pYKEY,1))
      objWWW0121.set(m$.Fnc.$get(m$.var("^WWW0121",m$.var("YM").get(),m$.var("YM").get(),pYKEY.get(),1)));
      //<< if $$$WWW0121FREE7(objWWW0121)=1 set strStatus=$$$NO
      if (mOp.Equal(include.WWWConst.$$$WWW0121FREE7(m$,objWWW0121),1)) {
        strStatus.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< GetEndUnitarizacao(pidLocal)
  public Object GetEndUnitarizacao(Object ... _p) {
    mVar pidLocal = m$.newVarRef("pidLocal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit:(pidLocal = "") ""
    if ((mOp.Equal(pidLocal.get(),""))) {
      return "";
    }
    //<< quit $piece($get(^WWW0121(YM,YM,pidLocal,1)),Y,81)
    return m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0121",m$.var("YM").get(),m$.var("YM").get(),pidLocal.get(),1)),m$.var("Y").get(),81);
  }

  //<< 
  //<< LoadINARTLOCPAR(Location)
  public Object LoadINARTLOCPAR(Object ... _p) {
    mVar Location = m$.newVarRef("Location",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< if $GET(YM)="" {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YM")),"")) {
      //<< do ^WWWVAR
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< }
    //<< set data=""
    mVar data = m$.var("data");
    data.set("");
    //<< set data=$order(^INART(YM,data))
    data.set(m$.Fnc.$order(m$.var("^INART",m$.var("YM").get(),data.get())));
    //<< while data'="" {
    while (mOp.NotEqual(data.get(),"")) {
      //<< set objPar=""
      mVar objPar = m$.var("objPar");
      objPar.set("");
      //<< set objPar=$get(^INARTLOCPAR(YM,data,Location,1))
      objPar.set(m$.Fnc.$get(m$.var("^INARTLOCPAR",m$.var("YM").get(),data.get(),Location.get(),1)));
      //<< set $piece(objPar,Y,1)=1
      m$.pieceVar(objPar,m$.var("Y").get(),1).set(1);
      //<< set key=data_","_Location
      mVar key = m$.var("key");
      key.set(mOp.Concat(mOp.Concat(data.get(),","),Location.get()));
      //<< set strStatus=$$Save^COMUtils("INARTLOCPAR",key,objPar,1)
      mVar strStatus = m$.var("strStatus");
      strStatus.set(m$.fnc$("COMUtils.Save","INARTLOCPAR",key.get(),objPar.get(),1));
      //<< if strStatus'=1 {
      if (mOp.NotEqual(strStatus.get(),1)) {
      }
      //<< //set errorstring="Erro ao salvar INARTLOCPAR "_key_" . Erro->"_strStatus
      //<< //$$$Alert(errorstring)
      //<< }
      //<< set data=$order(^INART(YM,data))
      data.set(m$.Fnc.$order(m$.var("^INART",m$.var("YM").get(),data.get())));
    }
    //<< }
    //<< q
    return null;
  }

  //<< 
  //<< UnLoadINARTLOCPAR(Location)
  public Object UnLoadINARTLOCPAR(Object ... _p) {
    mVar Location = m$.newVarRef("Location",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< if $GET(YM)="" {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YM")),"")) {
      //<< do ^WWWVAR
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< }
    //<< set data=""
    mVar data = m$.var("data");
    data.set("");
    //<< set data=$order(^INART(YM,data))
    data.set(m$.Fnc.$order(m$.var("^INART",m$.var("YM").get(),data.get())));
    //<< while data'="" {
    while (mOp.NotEqual(data.get(),"")) {
      //<< set objPar=""
      mVar objPar = m$.var("objPar");
      objPar.set("");
      //<< set objPar=$get(^INARTLOCPAR(YM,data,Location,1))
      objPar.set(m$.Fnc.$get(m$.var("^INARTLOCPAR",m$.var("YM").get(),data.get(),Location.get(),1)));
      //<< if objPar'="" {
      if (mOp.NotEqual(objPar.get(),"")) {
        //<< ;;set $piece(objPar,Y,1)=1
        //<< set key=data_","_Location
        mVar key = m$.var("key");
        key.set(mOp.Concat(mOp.Concat(data.get(),","),Location.get()));
        //<< set strStatus=$$KILL^COMUtils("INARTLOCPAR",key)
        mVar strStatus = m$.var("strStatus");
        strStatus.set(m$.fnc$("COMUtils.KILL","INARTLOCPAR",key.get()));
        //<< if strStatus'=1 {
        if (mOp.NotEqual(strStatus.get(),1)) {
        }
      }
      //<< //set errorstring="Erro ao apagar INARTLOCPAR "_key_" . Erro->"_strStatus
      //<< //$$$Alert(errorstring)
      //<< }
      //<< }
      //<< set data=$order(^INART(YM,data))
      data.set(m$.Fnc.$order(m$.var("^INART",m$.var("YM").get(),data.get())));
    }
    //<< }
    //<< q
    return null;
  }

//<< 
}
