//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWLogin
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:31
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWLogin
public class WWWLogin extends mClass {

  public void main() {
    _WWWLogin();
  }

  public void _WWWLogin() {
    //<< quit
    return;
  }

  //<< 
  //<< saveLoginPage()
  public Object saveLoginPage(Object ... _p) {
    //<< // http://[SERVER]:[PORT]/ensemble/csp/[NAMESPACE]/[LOGIN_PAGE].cls or
    //<< // http://[SERVER]:[PORT]/csp/[NAMESPACE]/[LOGIN_PAGE].cls
    //<< set loginPage = $get(%request.CgiEnvs("HTTP_REFERER"))
    mVar loginPage = m$.var("loginPage");
    loginPage.set(m$.Fnc.$get(m$.getRequest().getCgiEnvs("HTTP_REFERER")));
    //<< 
    //<< if ($length(loginPage) > 0) {
    if ((mOp.Greater(m$.Fnc.$length(loginPage.get()),0))) {
      //<< // [SERVER]:[PORT]/ensemble/csp/[NAMESPACE]/[LOGIN_PAGE].cls or
      //<< // [SERVER]:[PORT]/csp/[NAMESPACE]/[LOGIN_PAGE].cls
      //<< set loginPage = $piece(loginPage, "http://", 2, $length(loginPage, "http://"))
      loginPage.set(m$.Fnc.$piece(loginPage.get(),"http://",2,m$.Fnc.$length(loginPage.get(),"http://")));
    }
    //<< }
    //<< 
    //<< if ($length(loginPage) > 0) {
    if ((mOp.Greater(m$.Fnc.$length(loginPage.get()),0))) {
      //<< // /ensemble/csp/[NAMESPACE]/[LOGIN_PAGE].cls or
      //<< // /csp/[NAMESPACE]/[LOGIN_PAGE].cls
      //<< set loginPage = "/"_$piece(loginPage, "/", 2, $length(loginPage, "/"))
      loginPage.set(mOp.Concat("/",m$.Fnc.$piece(loginPage.get(),"/",2,m$.Fnc.$length(loginPage.get(),"/"))));
    }
    //<< }
    //<< 
    //<< set ^COMLogin(0, YUSER, 1) = loginPage
    m$.var("^COMLogin",0,m$.var("YUSER").get(),1).set(loginPage.get());
    //<< quit
    return null;
  }

  //<< 
  //<< getLoginPage(pstrPageOnly=0)
  public Object getLoginPage(Object ... _p) {
    mVar pstrPageOnly = m$.newVarRef("pstrPageOnly",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< if ($length($get(YUSER)) > 0) {
    if ((mOp.Greater(m$.Fnc.$length(m$.Fnc.$get(m$.var("YUSER"))),0))) {
      //<< set loginPage = $get(^COMLogin(0, YUSER, 1))
      mVar loginPage = m$.var("loginPage");
      loginPage.set(m$.Fnc.$get(m$.var("^COMLogin",0,m$.var("YUSER").get(),1)));
    }
    //<< }
    //<< else {
    else {
      //<< if ($length($get(YM)) = 0) {
      if ((mOp.Equal(m$.Fnc.$length(m$.Fnc.$get(m$.var("YM"))),0))) {
        //<< set YM = "0"
        mVar YM = m$.var("YM");
        YM.set("0");
      }
      //<< }
      //<< if ($length($get(YUCI)) > 0) {
      if ((mOp.Greater(m$.Fnc.$length(m$.Fnc.$get(m$.var("YUCI"))),0))) {
        //<< set nspace = YUCI
        mVar nspace = m$.var("nspace");
        nspace.set(m$.var("YUCI").get());
      }
      //<< }
      //<< else {
      else {
        //<< set nspace = $zutil(5)
        mVar nspace = m$.var("nspace");
        nspace.set(m$.Fnc.$zutil(5));
      }
      //<< }
      //<< 
      //<< if (+$$$WWWClientParamCoreChangesIPIRANGA($get(^WWWClientParam(YM, YM, 1)))) {
      if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesIPIRANGA(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
        //<< set loginPage = "/csp/"_nspace_"/COMLogin.cls"
        mVar loginPage = m$.var("loginPage");
        loginPage.set(mOp.Concat(mOp.Concat("/csp/",m$.var("nspace").get()),"/COMLogin.cls"));
      }
      //<< }
      //<< else {
      else {
        //<< set loginPage = "/csp/"_nspace_"/VARLoginSAA.cls"
        mVar loginPage = m$.var("loginPage");
        loginPage.set(mOp.Concat(mOp.Concat("/csp/",m$.var("nspace").get()),"/VARLoginSAA.cls"));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if (pstrPageOnly) {
    if (mOp.Logical((pstrPageOnly.get()))) {
      //<< set loginPage = $piece(loginPage, "/", $length(loginPage, "/"))
      mVar loginPage = m$.var("loginPage");
      loginPage.set(m$.Fnc.$piece(m$.var("loginPage").get(),"/",m$.Fnc.$length(m$.var("loginPage").get(),"/")));
    }
    //<< }
    //<< 
    //<< quit loginPage
    return m$.var("loginPage").get();
  }

//<< 
//<< 
}
