//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWACCESS
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:38
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
//<< #include WWWConst
import include.WWWConst;

//<< WWWACCESS(pstrChkAccess,pstrChkModule,pidUser,pblnNoAdmin)
public class WWWACCESS extends mClass {

  public Object main(Object ... _p) {
    mVar pstrChkAccess = m$.newVarRef("pstrChkAccess",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrChkModule = m$.newVarRef("pstrChkModule",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnNoAdmin = m$.newVarRef("pblnNoAdmin",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    return _WWWACCESS(pstrChkAccess,pstrChkModule,pidUser,pblnNoAdmin);
  }

  public Object _WWWACCESS(Object ... _p) {
    mVar pstrChkAccess = m$.newVarRef("pstrChkAccess",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrChkModule = m$.newVarRef("pstrChkModule",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnNoAdmin = m$.newVarRef("pblnNoAdmin",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ZUGANG ERLAUBT ODER NICHT - Access permissions
    //<< ;   Does the user have authorisation to access X and Y
    //<< ;
    //<< ;   Q:$$^WWWACCESS(BERECHTIGUNG,MODULLISTE,MITARBEITER)'=1
    //<< ;
    //<< ; Inputs :
    //<< ;   pstrChkAccess       Authorisation list to check
    //<< ;   pstrChkModule       Module list to check
    //<< ;   pidUser             User (optional) defaults to YBED
    //<< ;   pblnNoAdmin         Normally sys-admin has special access. If this option is set
    //<< ;                       to yes - they do not.
    //<< ;                       NOTE: This special access only applies if the user is a
    //<< ;                       SysAdmin and nothing else!
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :     boolean - whether user has access
    //<< ;
    //<< ; History :
    //<< ; 24-Jun-2008   shobby  SRAdhoc:    Put $get around check of pstrChkAccess
    //<< ; 14-Aug-2007   shobby  SRBR014321: System Administrators who also have other permissions would lose the sysadmin priveleges
    //<< ; 02-Aug-2007   GM      SRBR014601: Created condition for new user access level("0 - Not Available").
    //<< ; 12-Jul-2007   shobby  SRBR014604: ReducedModuleAuthorisation would fail if nothing selected.
    //<< ;                                   <space> does not equal empty string.
    //<< ; 28-Feb-2007   JW      SR15457: Fixed rewrite error.
    //<< ; 29-Nov-2006   JW      SR15205: Doco. Rewritten
    //<< ; 26-Aug-2005   GRF     Doco
    //<< ; 17-APR-2005   TYBD    NEW PARAMETER "NOADMIN" TO OVERWRITE THE ADMINRIGHTS FOR ALL OK
    //<< ; 15.11.2000    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new blnAccess,strUserAccess,strUserModules,strCompanyModule
    mVar blnAccess = m$.var("blnAccess");
    mVar strUserAccess = m$.var("strUserAccess");
    mVar strUserModules = m$.var("strUserModules");
    mVar strCompanyModule = m$.var("strCompanyModule");
    m$.newVar(blnAccess,strUserAccess,strUserModules,strCompanyModule);
    //<< 
    //<< quit:($get(pstrChkAccess)=0) $$$NO
    if ((mOp.Equal(m$.Fnc.$get(pstrChkAccess),0))) {
      return include.COMSYS.$$$NO(m$);
    }
    //<< 
    //<< set blnAccess = $$$YES
    blnAccess.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< // Check version validity
    //<< if $data(^WWW012V(0)) set blnAccess = $$CheckValidity()
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW012V",0)))) {
      blnAccess.set(m$.fnc$("CheckValidity"));
    }
    //<< 
    //<< if blnAccess {
    if (mOp.Logical(blnAccess.get())) {
      //<< set pstrChkAccess = $translate($get(pstrChkAccess),";",",")   ;Access levels check
      pstrChkAccess.set(m$.Fnc.$translate(m$.Fnc.$get(pstrChkAccess),";",","));
      //<< set pstrChkModule = $translate($get(pstrChkModule),";",",")     ;Module access check
      pstrChkModule.set(m$.Fnc.$translate(m$.Fnc.$get(pstrChkModule),";",","));
      //<< 
      //<< if $translate(pstrChkAccess,",")="" set pstrChkAccess = ""
      if (mOp.Equal(m$.Fnc.$translate(pstrChkAccess.get(),","),"")) {
        pstrChkAccess.set("");
      }
      //<< if $translate(pstrChkModule,",")="" set pstrChkModule = ""
      if (mOp.Equal(m$.Fnc.$translate(pstrChkModule.get(),","),"")) {
        pstrChkModule.set("");
      }
      //<< 
      //<< if $get(pidUser)="" set pidUser = YBED
      if (mOp.Equal(m$.Fnc.$get(pidUser),"")) {
        pidUser.set(m$.var("YBED").get());
      }
      //<< 
      //<< if (pstrChkAccess'="") || (pstrChkModule'="") {     // Something to check
      if ((mOp.NotEqual(pstrChkAccess.get(),"")) || (mOp.NotEqual(pstrChkModule.get(),""))) {
        //<< set strUserAccess = $$^WWWBEDBER(pidUser)       // Get user access levels
        strUserAccess.set(m$.fnc$("WWWBEDBER.main",pidUser.get()));
        //<< 
        //<< if '$get(pblnNoAdmin) && (+strUserAccess=1) {   // Sys Admin override
        if (mOp.Not(m$.Fnc.$get(pblnNoAdmin)) && (mOp.Equal(mOp.Positive(strUserAccess.get()),1))) {
          //<< set blnAccess = $$$YES
          blnAccess.set(include.COMSYS.$$$YES(m$));
        }
        //<< 
        //<< } else { // Check module authorisation
        else {
          //<< if (pstrChkModule'="") {    // For company
          if ((mOp.NotEqual(pstrChkModule.get(),""))) {
            //<< set strCompanyModule = $$$TRIMWS($translate($$$WWW012ReducedModuleAuthorizatio($get(^WWW012(0,YM,1))),";",","))
            strCompanyModule.set(include.COMSYSString.$$$TRIMWS(m$,m$.Fnc.$translate(include.WWWConst.$$$WWW012ReducedModuleAuthorizatio(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))),";",",")));
            //<< if (strCompanyModule'="") {
            if ((mOp.NotEqual(strCompanyModule.get(),""))) {
              //<< set blnAccess = $$MultiFind^COMUtilStr(pstrChkModule,strCompanyModule,",",",")
              blnAccess.set(m$.fnc$("COMUtilStr.MultiFind",pstrChkModule.get(),strCompanyModule.get(),",",","));
            }
            //<< }
            //<< if blnAccess {          // For user
            if (mOp.Logical(blnAccess.get())) {
              //<< set strUserModules=$$^WWWBEDMOD(pidUser)   ;Get user module access
              strUserModules.set(m$.fnc$("WWWBEDMOD.main",pidUser.get()));
              //<< set blnAccess = $$MultiFind^COMUtilStr(pstrChkModule,strUserModules,",",",")
              blnAccess.set(m$.fnc$("COMUtilStr.MultiFind",pstrChkModule.get(),strUserModules.get(),",",","));
            }
          }
          //<< }
          //<< }
          //<< 
          //<< // Check user access level authorisation
          //<< if blnAccess && (pstrChkAccess'="") && ($translate(pstrChkAccess,",")'=99) {
          if (mOp.Logical(blnAccess.get()) && (mOp.NotEqual(pstrChkAccess.get(),"")) && (mOp.NotEqual(m$.Fnc.$translate(pstrChkAccess.get(),","),99))) {
            //<< set blnAccess = $$MultiFind^COMUtilStr(pstrChkAccess,strUserAccess,",",",")
            blnAccess.set(m$.fnc$("COMUtilStr.MultiFind",pstrChkAccess.get(),strUserAccess.get(),",",","));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit blnAccess
    return blnAccess.get();
  }

  //<< 
  //<< 
  //<< CheckValidity()
  public Object CheckValidity(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check whether the current company's version has expired
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  boolean
    //<< ;
    //<< ; History:
    //<< ; 01-Dec-2006   JW      SR15205: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new blnAccess,dteValidUntil,objVersion
    mVar blnAccess = m$.var("blnAccess");
    mVar dteValidUntil = m$.var("dteValidUntil");
    mVar objVersion = m$.var("objVersion");
    m$.newVar(blnAccess,dteValidUntil,objVersion);
    //<< 
    //<< set blnAccess  = $$$YES
    blnAccess.set(include.COMSYS.$$$YES(m$));
    //<< set objVersion = $get(^WWW012V(0,YM,1))
    objVersion.set(m$.Fnc.$get(m$.var("^WWW012V",0,m$.var("YM").get(),1)));
    //<< 
    //<< if $$$WWW012VActive1(objVersion) {                          // Company has invalid version
    if (mOp.Logical(include.WWWConst.$$$WWW012VActive1(m$,objVersion))) {
      //<< set blnAccess = $$$NO
      blnAccess.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } else {
    else {
      //<< set dteValidUntil = $$$WWW012VValidUntil(objVersion)
      dteValidUntil.set(include.WWWConst.$$$WWW012VValidUntil(m$,objVersion));
      //<< if (dteValidUntil'="") && (dteValidUntil<$horolog) {    // Company's version has expired
      if ((mOp.NotEqual(dteValidUntil.get(),"")) && (mOp.Less(dteValidUntil.get(),m$.Fnc.$horolog()))) {
        //<< set blnAccess                           = $$$NO
        blnAccess.set(include.COMSYS.$$$NO(m$));
        //<< set $$$WWW012VActive1(^WWW012V(0,YM,1)) = $$$YES    // Set to invalid
        include.WWWConst.$$$WWW012VActive1Set(m$,m$.var("^WWW012V",0,m$.var("YM").get(),1),include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnAccess
    return blnAccess.get();
  }

//<< 
//<< 
}
