//*****************************************************************************
//** TASC - ALPHALINC - MAC VARAlertaLocalConfig
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-01 17:30:34
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

//<< VARAlertaLocalConfig
public class VARAlertaLocalConfig extends mClass {

  public void main() {
    _VARAlertaLocalConfig();
  }

  public void _VARAlertaLocalConfig() {
    quit();
  }

  //<< 
  //<< quit
  public void quit() {
    RunAtaLineLoad();
  }

  //<< 
  //<< RunAtaLineLoad
  public void RunAtaLineLoad() {
    //<< do ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< $$$Order2(^VARAtaLinha,YM,idAta)
    mVar idAta = m$.var("idAta");
    idAta.set("");
    for (;true;) {
      idAta.set(m$.Fnc.$order(m$.var("^VARAtaLinha",m$.var("YM").get(),idAta.get())));
      if (mOp.Equal(idAta.get(),"")) {
        break;
      }
      //<< $$$Order3(^VARAtaLinha,YM,idAta,idLine)
      mVar idLine = m$.var("idLine");
      idLine.set("");
      for (;true;) {
        idLine.set(m$.Fnc.$order(m$.var("^VARAtaLinha",m$.var("YM").get(),idAta.get(),idLine.get())));
        if (mOp.Equal(idLine.get(),"")) {
          break;
        }
        //<< set objATALinha=$get(^VARAtaLinha(YM,idAta,idLine,1))
        mVar objATALinha = m$.var("objATALinha");
        objATALinha.set(m$.Fnc.$get(m$.var("^VARAtaLinha",m$.var("YM").get(),idAta.get(),idLine.get(),1)));
        //<< set $piece(objATALinha,Y,12)=1
        m$.pieceVar(objATALinha,m$.var("Y").get(),12).set(1);
        //<< set key=idAta_","_idLine
        mVar key = m$.var("key");
        key.set(mOp.Concat(mOp.Concat(idAta.get(),","),idLine.get()));
        //<< w $$Save^COMUtils("VARAtaLinha",key,objATALinha,1)
        m$.Cmd.Write(m$.fnc$("COMUtils.Save","VARAtaLinha",key.get(),objATALinha.get(),1));
      }
    }
    //<< $$$End
    //<< $$$End
    //<< q
    return;
  }

  //<< 
  //<< AlternativeSave(YKEY)
  public Object AlternativeSave(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< //kill ^CacheTempMultiLock("VARAlertaLocalLinha")
    //<< if ($data(^VARAlertaLocalLinha(YM,$$$KEY1(YKEY),$$$KEY2(YKEY),1))'=1) {
    if ((mOp.NotEqual(m$.Fnc.$data(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),include.COMSYSWWW.$$$KEY1(m$,YKEY),include.COMSYSWWW.$$$KEY2(m$,YKEY),1)),1))) {
      //<< //set string="entrei com chave 1="_$$$KEY1(YKEY)_" e chave 2="_$$$KEY2(YKEY)
      //<< //$$$Alert(string)
      //<< set obj=""
      mVar obj = m$.var("obj");
      obj.set("");
      //<< set strStatus=$$Save^COMUtils("VARAlertaLocalLinha",YKEY,obj,1)
      mVar strStatus = m$.var("strStatus");
      strStatus.set(m$.fnc$("COMUtils.Save","VARAlertaLocalLinha",YKEY.get(),obj.get(),1));
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< do GoToForm^COMUtilForm("VARAlertaLocalConfig",YKEY)
        m$.Cmd.Do("COMUtilForm.GoToForm","VARAlertaLocalConfig",YKEY.get());
      }
      //<< }else {
      else {
        //<< $$$Alert(strStatus)
        include.COMSYS.$$$Alert(m$,strStatus);
      }
    }
    //<< }
    //<< }
    //<< q
    return null;
  }

  //<< 
  //<< LoadItemData
  public void LoadItemData() {
    //<< do ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< $$$Order2(^VARAlertaLocalLinha,YM,idLocation)
    mVar idLocation = m$.var("idLocation");
    idLocation.set("");
    for (;true;) {
      idLocation.set(m$.Fnc.$order(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocation.get())));
      if (mOp.Equal(idLocation.get(),"")) {
        break;
      }
      //<< $$$Order3(^VARAlertaLocalLinha,YM,idLocation,idProduct)
      mVar idProduct = m$.var("idProduct");
      idProduct.set("");
      for (;true;) {
        idProduct.set(m$.Fnc.$order(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocation.get(),idProduct.get())));
        if (mOp.Equal(idProduct.get(),"")) {
          break;
        }
        //<< set objAlerta=$get(^VARAlertaLocalLinha(YM,idLocation,idProduct,1))
        mVar objAlerta = m$.var("objAlerta");
        objAlerta.set(m$.Fnc.$get(m$.var("^VARAlertaLocalLinha",m$.var("YM").get(),idLocation.get(),idProduct.get(),1)));
        //<< set $piece(objAlerta,Y,3)=$$SQLGetDescricaoProduto^VARSQL(idProduct)
        m$.pieceVar(objAlerta,m$.var("Y").get(),3).set(m$.fnc$("VARSQL.SQLGetDescricaoProduto",idProduct.get()));
        //<< set $piece(objAlerta,Y,4)=$$GetLastPrograms(idProduct,idLocation)
        m$.pieceVar(objAlerta,m$.var("Y").get(),4).set(m$.fnc$("GetLastPrograms",idProduct.get(),idLocation.get()));
        //<< set key=idLocation_","_idProduct
        mVar key = m$.var("key");
        key.set(mOp.Concat(mOp.Concat(idLocation.get(),","),idProduct.get()));
        //<< W $$Save^COMUtils("VARAlertaLocalLinha",key,objAlerta,1)
        m$.Cmd.Write(m$.fnc$("COMUtils.Save","VARAlertaLocalLinha",key.get(),objAlerta.get(),1));
      }
    }
    //<< $$$End
    //<< $$$End
    //<< q
    return;
  }

  //<< 
  //<< GetLastPrograms(idProduct,idLocation="")
  public Object GetLastPrograms(Object ... _p) {
    mVar idProduct = m$.newVarRef("idProduct",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar idLocation = m$.newVarRef("idLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< set date=$piece($H,",",1)-90
    mVar date = m$.var("date");
    date.set(mOp.Subtract(m$.Fnc.$piece(m$.Fnc.$horolog(),",",1),90));
    //<< set ListPrograma=""
    mVar ListPrograma = m$.var("ListPrograma");
    ListPrograma.set("");
    //<< if idLocation="Rede" {
    if (mOp.Equal(idLocation.get(),"Rede")) {
      //<< Set tSQL  = "select distinct(Bundle->Program) as Programa from alSOH.dStockHistory where DateConfirmed>"_date_" and Location=101.504 and Item='"_idProduct_"'"
      mVar tSQL = m$.var("tSQL");
      tSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("select distinct(Bundle->Program) as Programa from alSOH.dStockHistory where DateConfirmed>",date.get())," and Location=101.504 and Item='"),idProduct.get()),"'"));
    }
    //<< }else {
    else {
      //<< Set tSQL  = "select distinct(Bundle->Program) as Programa from alSOH.dStockHistory where DateConfirmed>"_date_" and Location='"_idLocation_"' and Item='"_idProduct_"'"
      mVar tSQL = m$.var("tSQL");
      tSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("select distinct(Bundle->Program) as Programa from alSOH.dStockHistory where DateConfirmed>",date.get())," and Location='"),idLocation.get()),"' and Item='"),idProduct.get()),"'"));
    }
    //<< }
    //<< Set tRs = ##class(%Library.ResultSet).%New()
    mVar tRs = m$.var("tRs");
    tRs.set(m$.fnc$("$Library.ResultSet.$New"));
    //<< Set tRs.RuntimeMode = "0"
    m$.prop(tRs.get(),"RuntimeMode").set("0");
    //<< Do tRs.Prepare(tSQL)
    m$.Cmd.Do(tRs.getORef(),"Prepare",m$.var("tSQL").get());
    //<< Do tRs.Execute()
    m$.Cmd.Do(tRs.getORef(),"Execute");
    //<< While tRs.Next()
    //<< {
    while (mOp.Logical(m$.fnc$(tRs.getORef(),"Next"))) {
      //<< // Limpa variaveis
      //<< set tPrograma=""
      mVar tPrograma = m$.var("tPrograma");
      tPrograma.set("");
      //<< SET tPrograma=tRs.Data("Programa")
      tPrograma.set(m$.fnc$(tRs.getORef(),"Data","Programa"));
      //<< if ListPrograma'="" {
      if (mOp.NotEqual(ListPrograma.get(),"")) {
        //<< set ListPrograma=ListPrograma_";"_tPrograma
        ListPrograma.set(mOp.Concat(mOp.Concat(ListPrograma.get(),";"),tPrograma.get()));
      }
      //<< }else {
      else {
        //<< set ListPrograma=tPrograma
        ListPrograma.set(tPrograma.get());
      }
    }
    //<< }
    //<< 
    //<< }
    //<< If $IsObject(tRs)
    //<< {
    if (mOp.Logical(m$.Fnc.$isobject(tRs.get()))) {
      //<< Do tRs.Close()
      m$.Cmd.Do(tRs.getORef(),"Close");
    }
    //<< }
    //<< q ListPrograma
    return ListPrograma.get();
  }

//<< 
}
