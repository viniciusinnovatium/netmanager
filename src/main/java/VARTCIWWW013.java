//*****************************************************************************
//** TASC - ALPHALINC - MAC VARTCIWWW013
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-02 14:54:11
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

//<< VARTCIWWW013
public class VARTCIWWW013 extends mClass {

  public void main() {
    _VARTCIWWW013();
  }

  public void _VARTCIWWW013() {
    OnBeforeFormConstruction();
  }

  //<< 
  //<< OnBeforeFormConstruction
  public void OnBeforeFormConstruction() {
    //<< if YSEITE = 0 set YSEITE = 50
    if (mOp.Equal(m$.var("YSEITE").get(),0)) {
      mVar YSEITE = m$.var("YSEITE");
      YSEITE.set(50);
    }
    //<< do ListAuthorizedProfiles
    m$.Cmd.Do("ListAuthorizedProfiles");
  }

  //<< 
  //<< UnitOfMeasureOnBlur(YKEY)
  public Object UnitOfMeasureOnBlur(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< set strStatus=1
    mVar strStatus = m$.var("strStatus");
    strStatus.set(1);
    //<< if $get(YKEY)="" Q 0
    if (mOp.Equal(m$.Fnc.$get(YKEY),"")) {
      return 0;
    }
    //<< if $get(YKEY)="+" Q 0
    if (mOp.Equal(m$.Fnc.$get(YKEY),"+")) {
      return 0;
    }
    //<< IF (##class(alSOH.iStockHistory).ItemHasTransactions(YKEY))=0 Q 0
    if (mOp.Equal((m$.fnc$("alSOH.iStockHistory.ItemHasTransactions",YKEY.get())),0)) {
      return 0;
    }
    //<< set usrObj=$get(^WWW013(YM,YBED,1))
    mVar usrObj = m$.var("usrObj");
    usrObj.set(m$.Fnc.$get(m$.var("^WWW013",m$.var("YM").get(),m$.var("YBED").get(),1)));
    //<< if usrObj="" q strStatus
    if (mOp.Equal(usrObj.get(),"")) {
      return strStatus.get();
    }
    //<< if $piece(usrObj,Y,129)'="0002" {
    if (mOp.NotEqual(m$.Fnc.$piece(usrObj.get(),m$.var("Y").get(),129),"0002")) {
      //<< if $piece(usrObj,Y,3)'=1 q strStatus
      if (mOp.NotEqual(m$.Fnc.$piece(usrObj.get(),m$.var("Y").get(),3),1)) {
        return strStatus.get();
      }
    }
    //<< }
    //<< if $$GetEstoqueOnHand^VARReposicao(YKEY)>0 q strStatus
    if (mOp.Greater(m$.fnc$("VARReposicao.GetEstoqueOnHand",YKEY.get()),0)) {
      return strStatus.get();
    }
    //<< Q 0
    return 0;
  }

  //<< 
  //<< ListAuthorizedProfiles
  public void ListAuthorizedProfiles() {
    //<< kill ^COMTempList(YM,YBED,"VARTCIAuthorizedProfiles")
    m$.var("^COMTempList",m$.var("YM").get(),m$.var("YBED").get(),"VARTCIAuthorizedProfiles").kill();
    //<< 
    //<< new userProfile, idProfile
    mVar userProfile = m$.var("userProfile");
    mVar idProfile = m$.var("idProfile");
    m$.newVar(userProfile,idProfile);
    //<< set userProfile = $piece($get(^WWW013(YM,YBED,1)),Y,3)
    userProfile.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",m$.var("YM").get(),m$.var("YBED").get(),1)),m$.var("Y").get(),3));
    //<< 
    //<< $$$Order4(^WWW101,YM,"BERECHTIGUNG",SPRACHE,idProfile)
    idProfile.set("");
    for (;true;) {
      idProfile.set(m$.Fnc.$order(m$.var("^WWW101",m$.var("YM").get(),"BERECHTIGUNG",m$.var("SPRACHE").get(),idProfile.get())));
      if (mOp.Equal(idProfile.get(),"")) {
        break;
      }
      //<< 
      //<< if userProfile = 1 {
      if (mOp.Equal(userProfile.get(),1)) {
        //<< set ^COMTempList(YM,YBED,"VARTCIAuthorizedProfiles",1,1) = $$GetProfileDescription(1)
        m$.var("^COMTempList",m$.var("YM").get(),m$.var("YBED").get(),"VARTCIAuthorizedProfiles",1,1).set(m$.fnc$("GetProfileDescription",1));
      }
      //<< }
      //<< 
      //<< if (idProfile >= 100) {
      if ((mOp.GreaterOrEqual(idProfile.get(),100))) {
        //<< set ^COMTempList(YM,YBED,"VARTCIAuthorizedProfiles",idProfile,1) = $$GetProfileDescription(idProfile)
        m$.var("^COMTempList",m$.var("YM").get(),m$.var("YBED").get(),"VARTCIAuthorizedProfiles",idProfile.get(),1).set(m$.fnc$("GetProfileDescription",idProfile.get()));
      }
    }
    //<< }
    //<< 
    //<< $$$End
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< GetProfileDescription(pidProfile)
  public Object GetProfileDescription(Object ... _p) {
    mVar pidProfile = m$.newVarRef("pidProfile",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< if pidProfile = "" quit ""
    if (mOp.Equal(pidProfile.get(),"")) {
      return "";
    }
    //<< quit $piece($get(^WWW101(YM,"BERECHTIGUNG",SPRACHE,pidProfile,1)),Y,1)
    return m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",m$.var("YM").get(),"BERECHTIGUNG",m$.var("SPRACHE").get(),pidProfile.get(),1)),m$.var("Y").get(),1);
  }

  //<< 
  //<< 
  //<< OnBeforeSaveHook(&YFELD)
  public Object OnBeforeSaveHook(Object ... _p) {
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new codModelo, strPerfil
    mVar codModelo = m$.var("codModelo");
    mVar strPerfil = m$.var("strPerfil");
    m$.newVar(codModelo,strPerfil);
    //<< 
    //<< set codModelo = $piece(YFELD,Y,129)
    codModelo.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),129));
    //<< if codModelo = "" quit $$$YES
    if (mOp.Equal(codModelo.get(),"")) {
      return include.COMSYS.$$$YES(m$);
    }
    //<< 
    //<< set strPerfil = $piece($get(^VARPerfilModelo(YM,codModelo,1)),Y,2)
    strPerfil.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARPerfilModelo",m$.var("YM").get(),codModelo.get(),1)),m$.var("Y").get(),2));
    //<< 
    //<< if (strPerfil '= "") {
    if ((mOp.NotEqual(strPerfil.get(),""))) {
      //<< set $piece(YFELD,Y,3) = strPerfil
      m$.pieceVar(YFELD,m$.var("Y").get(),3).set(strPerfil.get());
      //<< 
      //<< if strPerfil '= 1 {
      if (mOp.NotEqual(strPerfil.get(),1)) {
        //<< set $piece(YFELD,Y,4) = strPerfil
        m$.pieceVar(YFELD,m$.var("Y").get(),4).set(strPerfil.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; Código temporário que não permite salvar o usuário com mais de 15 caracteres.
    //<< ; Provavelmente a partir da versão 1.64 esse código pode ser removido.
    //<< ; ps: o código bloqueia somente a criação de novos usuários, usuários existentes com mais
    //<< ;     de 15 caracteres podem continuar existindo e serem editados.
    //<< new keyLength
    mVar keyLength = m$.var("keyLength");
    m$.newVar(keyLength);
    //<< set keyLength = $length(YKEY)
    keyLength.set(m$.Fnc.$length(m$.var("YKEY").get()));
    //<< if (keyLength > 15) && ('$data(^WWW013(YM,YKEY))) {
    if ((mOp.Greater(keyLength.get(),15)) && (mOp.Not(m$.Fnc.$data(m$.var("^WWW013",m$.var("YM").get(),m$.var("YKEY").get()))))) {
      //<< w "javascript:alert('O login do usuário não deve ter mais do que 15 caracteres.');"
      m$.Cmd.Write("javascript:alert('O login do usuário não deve ter mais do que 15 caracteres.');");
      //<< quit $$$NO
      return include.COMSYS.$$$NO(m$);
    }
    //<< }
    //<< //Fim do código temporário
    //<< 
    //<< 
    //<< quit $$$YES
    return include.COMSYS.$$$YES(m$);
  }

//<< 
}
