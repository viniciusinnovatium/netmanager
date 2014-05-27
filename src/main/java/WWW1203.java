//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW1203
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:31
//*****************************************************************************

import mLibrary.*;

//<< 
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

//<< WWW1203
public class WWW1203 extends mClass {

  //<< 
  //<< #define SECURITY    "!!!ZZZZZZZZZZZZZZZZ"
  public static Object $$$SECURITY(mContext m$) {
    return ("!!!ZZZZZZZZZZZZZZZZ");
  }

  public void main() {
    _WWW1203();
  }

  public void _WWW1203() {
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; 19-Jun-2009   GRF     Doco; General clean up - old changes, authorisation and
  //<< ;                           order macros
  //<< ;-------------------------------------------------------------------------------
  //<< ACCESS(pidAccessForModule="",pidUsersAccess="")
  public Object ACCESS(Object ... _p) {
    mVar pidAccessForModule = m$.newVarRef("pidAccessForModule",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidUsersAccess = m$.newVarRef("pidUsersAccess",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Overrides the call to WWWACCESS... To prevent System Administrator seeing tabs
    //<< ; that have been hidden with customisation.
    //<< ;
    //<< ; Params:
    //<< ; pidAccessForModule: The modules list
    //<< ; pidUsersAccess    : The user security list
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; A boolean, $$$YES - has access, $$$NO no access
    //<< ;
    //<< ; History:
    //<< ; 25-Oct-2006   RPW     SRBR014072: use new security macro, & added documentation
    //<< ;                           used boolean macros, modified param names to be per
    //<< ;                           coding standard
    //<< ; 25-Jun-2006   shobby  SRBR014072: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnAccess
    mVar blnAccess = m$.var("blnAccess");
    m$.newVar(blnAccess);
    //<< 
    //<< if pidUsersAccess=$$$SECURITY {
    if (mOp.Equal(pidUsersAccess.get(),$$$SECURITY(m$))) {
      //<< set blnAccess = $$$NO
      blnAccess.set(include.COMSYS.$$$NO(m$));
    }
    //<< } else {
    else {
      //<< set blnAccess = $$^WWWACCESS(pidAccessForModule,pidUsersAccess)
      blnAccess.set(m$.fnc$("WWWACCESS.main",pidAccessForModule.get(),pidUsersAccess.get()));
    }
    //<< }
    //<< quit blnAccess
    return blnAccess.get();
  }

  //<< 
  //<< 
  //<< GET(pidForm,pidLanguage,pidTab)
  public Object GET(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLanguage = m$.newVarRef("pidLanguage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidTab = m$.newVarRef("pidTab",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Overrides the get method on WWW1203 to use customisation if there is any.
    //<< ; If the 'Hide' property on WWW1203, simulates not having relevant permissions to see
    //<< ; the tab by giving an 'impossible' AccessForModule.  Done this way to minimise
    //<< ; impact on existing code.
    //<< ;
    //<< ; Params:
    //<< ; pidForm    : The value of YFORM
    //<< ; pidLanguage: The value of SPRACHE
    //<< ; pidTab     : The current tab
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; The Combined WWW1203 and WWW1203D object to get the correct customisation
    //<< ;
    //<< ; History:
    //<< ; 08-Nov-2011   shobby  SR17846: Changed limits.  Core 0-49, Custom 50+
    //<< ; 03-Jul-2007   RPW     SRBR014503: If WWW1203 exists and WWW1203D does not and
    //<< ;                       the id of the tab is > 99 this means we have a customised
    //<< ;                       tab and it is not for this Company.
    //<< ; 25-Oct-2006   RPW     SRBR014072: Enabled handling of all the fields on the
    //<< ;                       Customisation form.  Most were ignored which would create
    //<< ;                       confusion if the values where modified.  Renamed parameters
    //<< ;                       to adhere to coding standards, documented the code.
    //<< ; 16-Oct-2006   HeberB  SRBR014280: If CheckExecuteToHide result $$$YES then HIDE
    //<< ; 25-Jun-2006   shobby  SRBR014072: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW1203,objWWW1203D,strCommand,strResult
    mVar objWWW1203 = m$.var("objWWW1203");
    mVar objWWW1203D = m$.var("objWWW1203D");
    mVar strCommand = m$.var("strCommand");
    mVar strResult = m$.var("strResult");
    m$.newVar(objWWW1203,objWWW1203D,strCommand,strResult);
    //<< 
    //<< set objWWW1203 = $get(^WWW1203(0,pidForm,pidLanguage,pidTab,1))
    objWWW1203.set(m$.Fnc.$get(m$.var("^WWW1203",0,pidForm.get(),pidLanguage.get(),pidTab.get(),1)));
    //<< 
    //<< if $$$WWW1203CheckExecuteToHide(objWWW1203)'="" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW1203CheckExecuteToHide(m$,objWWW1203),"")) {
      //<< set strResult = ""
      strResult.set("");
      //<< set strCommand = "set strResult="_$$$WWW1203CheckExecuteToHide(objWWW1203)       ;   *** EXECUTE ? ***
      strCommand.set(mOp.Concat("set strResult=",include.WWWConst.$$$WWW1203CheckExecuteToHide(m$,objWWW1203)));
      //<< 
      //<< xecute strCommand
      m$.Cmd.Xecute(strCommand.get());
      //<< 
      //<< if strResult {
      if (mOp.Logical(strResult.get())) {
        //<< set $$$WWW1203AccessForModule(objWWW1203) = $$$SECURITY
        include.WWWConst.$$$WWW1203AccessForModuleSet(m$,objWWW1203,$$$SECURITY(m$));
        //<< quit objWWW1203                                                 ; *** EARLY EXIT ***
        return objWWW1203.get();
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set objWWW1203D=$get(^WWW1203D(0,pidForm,pidLanguage,pidTab,YM,1))
    objWWW1203D.set(m$.Fnc.$get(m$.var("^WWW1203D",0,pidForm.get(),pidLanguage.get(),pidTab.get(),m$.var("YM").get(),1)));
    //<< if objWWW1203D'="" {
    if (mOp.NotEqual(objWWW1203D.get(),"")) {
      //<< ; Allow all customizations to work as required.
      //<< 
      //<< if $$$WWW1203DHide(objWWW1203D)=$$$YES {
      if (mOp.Equal(include.WWWConst.$$$WWW1203DHide(m$,objWWW1203D),include.COMSYS.$$$YES(m$))) {
        //<< set $$$WWW1203AccessForModule(objWWW1203) = $$$SECURITY
        include.WWWConst.$$$WWW1203AccessForModuleSet(m$,objWWW1203,$$$SECURITY(m$));
      }
      //<< 
      //<< } else {
      else {
        //<< if $$$WWW1203DAccessForModule(objWWW1203D)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW1203DAccessForModule(m$,objWWW1203D),"")) {
          //<< set $$$WWW1203AccessForModule(objWWW1203) = $$$WWW1203DAccessForModule(objWWW1203D)
          include.WWWConst.$$$WWW1203AccessForModuleSet(m$,objWWW1203,include.WWWConst.$$$WWW1203DAccessForModule(m$,objWWW1203D));
        }
        //<< }
        //<< 
        //<< if $$$WWW1203DUsersAccess(objWWW1203D)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW1203DUsersAccess(m$,objWWW1203D),"")) {
          //<< set $$$WWW1203UsersAccess(objWWW1203) = $$$WWW1203DUsersAccess(objWWW1203D)
          include.WWWConst.$$$WWW1203UsersAccessSet(m$,objWWW1203,include.WWWConst.$$$WWW1203DUsersAccess(m$,objWWW1203D));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if $$$WWW1203PictureFileForPageTag(objWWW1203D)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW1203PictureFileForPageTag(m$,objWWW1203D),"")) {
        //<< set $$$WWW1203PictureFileForPageTag(objWWW1203) = $$$WWW1203DPictureFileForPageTag(objWWW1203D)
        include.WWWConst.$$$WWW1203PictureFileForPageTagSet(m$,objWWW1203,include.WWWConst.$$$WWW1203DPictureFileForPageTag(m$,objWWW1203D));
      }
      //<< }
      //<< 
      //<< if $$$WWW1203DToolTip(objWWW1203D)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW1203DToolTip(m$,objWWW1203D),"")) {
        //<< set $$$WWW1203ToolTip(objWWW1203) = $$$WWW1203DToolTip(objWWW1203D)
        include.WWWConst.$$$WWW1203ToolTipSet(m$,objWWW1203,include.WWWConst.$$$WWW1203DToolTip(m$,objWWW1203D));
      }
      //<< }
      //<< 
      //<< if $$$WWW1203DDataFieldSearchFunction(objWWW1203D)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW1203DDataFieldSearchFunction(m$,objWWW1203D),"")) {
        //<< set $$$WWW1203DataFieldSearchFunction(objWWW1203) = $$$WWW1203DDataFieldSearchFunction(objWWW1203D)
        include.WWWConst.$$$WWW1203DataFieldSearchFunctionSet(m$,objWWW1203,include.WWWConst.$$$WWW1203DDataFieldSearchFunction(m$,objWWW1203D));
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< if pidTab'<$$FirstCustom^WWW1203D() {
      if (mOp.NotLess(pidTab.get(),m$.fnc$("WWW1203D.FirstCustom"))) {
        //<< set $$$WWW1203AccessForModule(objWWW1203) = $$$SECURITY
        include.WWWConst.$$$WWW1203AccessForModuleSet(m$,objWWW1203,$$$SECURITY(m$));
      }
    }
    //<< }
    //<< }
    //<< quit objWWW1203
    return objWWW1203.get();
  }

  //<< 
  //<< 
  //<< FindFirstTab(pidForm,pidLanguage,pidSite)
  public Object FindFirstTab(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLanguage = m$.newVarRef("pidLanguage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidSite = m$.newVarRef("pidSite",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Find the First Visible tab on a form
    //<< ;
    //<< ; Params:
    //<< ; pidForm    : The value of YFORM
    //<< ; pidLanguage: The value of SPRACHE
    //<< ; pidSite    : The current site (tab) (SEITE)
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; The site id that is the first one to be shown, it may not be in the first position.
    //<< ;
    //<< ; History:
    //<< ; 25-Oct-2006   RPW     SRBR014072: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idSite,idTab,objWWW1203
    mVar idSite = m$.var("idSite");
    mVar idTab = m$.var("idTab");
    mVar objWWW1203 = m$.var("objWWW1203");
    m$.newVar(idSite,idTab,objWWW1203);
    //<< 
    //<< set idSite = pidSite
    idSite.set(pidSite.get());
    //<< set idTab = ""
    idTab.set("");
    //<< for {
    for (;true;) {
      //<< set idTab = $order(^WWW1203(0,pidForm,pidLanguage,idTab))
      idTab.set(m$.Fnc.$order(m$.var("^WWW1203",0,pidForm.get(),pidLanguage.get(),idTab.get())));
      //<< quit:idTab=""
      if (mOp.Equal(idTab.get(),"")) {
        break;
      }
      //<< 
      //<< set objWWW1203 = $$GET(pidForm,pidLanguage,idTab)
      objWWW1203.set(m$.fnc$("GET",pidForm.get(),pidLanguage.get(),idTab.get()));
      //<< if $$ACCESS^WWW1203($piece(objWWW1203,Y,6),$piece(objWWW1203,Y,5)) {
      if (mOp.Logical(m$.fnc$("WWW1203.ACCESS",m$.Fnc.$piece(objWWW1203.get(),m$.var("Y").get(),6),m$.Fnc.$piece(objWWW1203.get(),m$.var("Y").get(),5)))) {
        //<< set idSite = idTab
        idSite.set(idTab.get());
        //<< quit
        break;
      }
    }
    //<< }
    //<< }
    //<< quit idSite
    return idSite.get();
  }

  //<< 
  //<< 
  //<< OnBeforeButtonLine()
  public Object OnBeforeButtonLine(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Don't allow any modify in English column when the YBACK(last form) is the
    //<< ; TSUtilityTab form, and when the tab was created by a custom tab.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; History:
    //<< ; 14-Jun-2007   shobby  SRBR014473: Used macro to set readonly.
    //<< ; 13-Jun-2007   GM      SRBR014473: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $piece($get(YBACK),",",$length($get(YBACK),",")-1)="TSUtilityTab" {
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YBACK")),",",mOp.Subtract(m$.Fnc.$length(m$.Fnc.$get(m$.var("YBACK")),","),1)),"TSUtilityTab")) {
      //<< if $$$KEY2(YKEY) = "EN" {
      if (mOp.Equal(include.COMSYSWWW.$$$KEY2(m$,m$.var("YKEY")),"EN")) {
        //<< set $$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly
        include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
      }
    }
    //<< }
    //<< }
    //<< do CheckCustomTabForEditing($$$KEY3(YKEY))
    m$.Cmd.Do("CheckCustomTabForEditing",include.COMSYSWWW.$$$KEY3(m$,m$.var("YKEY")));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CheckCustomTabForEditing(pintPageNumber)
  public Object CheckCustomTabForEditing(Object ... _p) {
    mVar pintPageNumber = m$.newVarRef("pintPageNumber",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set the WWW1203 form to read only if the tab id was created by a custom tab
    //<< ;  (page number 50+).
    //<< ;
    //<< ; Params:
    //<< ;   pintPageNumber - the page id of the tab to be checked.
    //<< ;
    //<< ; History:
    //<< ; 08-Nov-2011   shobby  SR17846:    Changed limits.  Core 0-49, Custom 50+
    //<< ; 27-Jun-2007   FRANK   SRBR014503: Created
    //<< ;-------------------------------------------------------------------------------
    //<< // Tabs with page number 50+ should be read only.
    //<< if pintPageNumber '<$$FirstCustom^WWW1203D() {                      ;SR17846
    if (mOp.NotLess(pintPageNumber.get(),m$.fnc$("WWW1203D.FirstCustom"))) {
      //<< set $$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly
      include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< OnBeforeSaveHook()
  public Object OnBeforeSaveHook(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; On before save hook for WWW1203.
    //<< ;
    //<< ; History:
    //<< ; 27-Jun-2007   FRANK   SRBR014503: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$CheckCustomTab($$$KEY3(YKEY))
    strStatus.set(m$.fnc$("CheckCustomTab",include.COMSYSWWW.$$$KEY3(m$,m$.var("YKEY"))));
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< CheckCustomTab(pintPageNumber)
  public Object CheckCustomTab(Object ... _p) {
    mVar pintPageNumber = m$.newVarRef("pintPageNumber",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check if the tab could be saved.
    //<< ;
    //<< ; Params:
    //<< ;   pintPageNumber - the page id of the tab.
    //<< ;
    //<< ; Returns:
    //<< ;  An error status if the user tries to create a core tab with id 50+.
    //<< ;
    //<< ; History:
    //<< ; 03-Sep-2013   shobby  CORE-241: Improved error message
    //<< ; 08-Nov-2011   shobby  SR17846: Changed limits.  Core 0-49, Custom 50+
    //<< ; 27-Jun-2007   FRANK   SRBR014503: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if pintPageNumber '<$$FirstCustom^WWW1203D() {                  ;SR17846
    if (mOp.NotLess(pintPageNumber.get(),m$.fnc$("WWW1203D.FirstCustom"))) {
      //<< set strStatus = $$$MakeStatus(34454,$$FirstCustom^WWW1203D()-1)
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,34454,mOp.Subtract(m$.fnc$("WWW1203D.FirstCustom"),1)));
    }
    //<< }  ; "Page numbers 50 or greater are reserved for customization tabs only."
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnAfterSave(pYKEY,pYFELD)
  public Object OnAfterSave(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check the permissions of tabs in current form.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2009   GRF     If test did not have parentheses around code block;
    //<< ;                           variables to coding standard
    //<< ; 03-Sep-2007   GM      SRBR014630: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idApp,idForm,idMenu,idTab,objWWW004,objWWW00444,objWWW1203,strStatus
    mVar idApp = m$.var("idApp");
    mVar idForm = m$.var("idForm");
    mVar idMenu = m$.var("idMenu");
    mVar idTab = m$.var("idTab");
    mVar objWWW004 = m$.var("objWWW004");
    mVar objWWW00444 = m$.var("objWWW00444");
    mVar objWWW1203 = m$.var("objWWW1203");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idApp,idForm,idMenu,idTab,objWWW004,objWWW00444,objWWW1203,strStatus);
    //<< 
    //<< set strStatus=""
    strStatus.set("");
    //<< set idApp = ""
    idApp.set("");
    //<< for {
    for (;true;) {
      //<< set idApp = $order(^WWW004(0,idApp))
      idApp.set(m$.Fnc.$order(m$.var("^WWW004",0,idApp.get())));
      //<< quit:idApp=""
      if (mOp.Equal(idApp.get(),"")) {
        break;
      }
      //<< 
      //<< set idMenu = ""
      idMenu.set("");
      //<< for {
      for (;true;) {
        //<< set idMenu = $order(^WWW004(0,idApp,idMenu))
        idMenu.set(m$.Fnc.$order(m$.var("^WWW004",0,idApp.get(),idMenu.get())));
        //<< quit:idMenu=""
        if (mOp.Equal(idMenu.get(),"")) {
          break;
        }
        //<< 
        //<< set objWWW004 = $get(^WWW004(0,idApp,idMenu,1))
        objWWW004.set(m$.Fnc.$get(m$.var("^WWW004",0,idApp.get(),idMenu.get(),1)));
        //<< if objWWW004 '="" {
        if (mOp.NotEqual(objWWW004.get(),"")) {
          //<< set idForm = $$$WWW004FormName(objWWW004)
          idForm.set(include.WWWConst.$$$WWW004FormName(m$,objWWW004));
          //<< 
          //<< if idForm = $$$KEY1(pYKEY) {
          if (mOp.Equal(idForm.get(),include.COMSYSWWW.$$$KEY1(m$,pYKEY))) {
            //<< set idTab = $$$KEY3(pYKEY)
            idTab.set(include.COMSYSWWW.$$$KEY3(m$,pYKEY));
            //<< set objWWW00444 = $get(^WWW00444(0,idApp,idMenu,idTab,1))
            objWWW00444.set(m$.Fnc.$get(m$.var("^WWW00444",0,idApp.get(),idMenu.get(),idTab.get(),1)));
            //<< 
            //<< if ($$$WWW1203AccessForModule(YFELD)'="") || ($$$WWW1203UsersAccess(YFELD)'="") {
            if ((mOp.NotEqual(include.WWWConst.$$$WWW1203AccessForModule(m$,m$.var("YFELD")),"")) || (mOp.NotEqual(include.WWWConst.$$$WWW1203UsersAccess(m$,m$.var("YFELD")),""))) {
              //<< set $$$WWW00444Module1(objWWW00444)     = $$$WWW1203AccessForModule(YFELD)
              include.WWWConst.$$$WWW00444Module1Set(m$,objWWW00444,include.WWWConst.$$$WWW1203AccessForModule(m$,m$.var("YFELD")));
              //<< set $$$WWW00444UserAccess(objWWW00444)  = $$$WWW1203UsersAccess(YFELD)
              include.WWWConst.$$$WWW00444UserAccessSet(m$,objWWW00444,include.WWWConst.$$$WWW1203UsersAccess(m$,m$.var("YFELD")));
              //<< set strStatus = $$$Save("WWW00444",idApp_","_idMenu_","_idTab,objWWW00444,$$$YES)
              strStatus.set(include.COMSYS.$$$Save(m$,"WWW00444",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idApp.get(),","),idMenu.get()),","),idTab.get()),objWWW00444,include.COMSYS.$$$YES(m$)));
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnBeforeDeleteHook(pYKEY)
  public Object OnBeforeDeleteHook(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; On before delete hook for WWW1203.
    //<< ; For pages < 50, delete Customisation tabs for all companies, if Core Tabs are deleted
    //<< ;
    //<< ; pYKEY = return the keys
    //<< ;
    //<< ; Returns:
    //<< ;   strStatus for the delete action.
    //<< ;
    //<< ; History:
    //<< ; 08-Nov-2011   shobby  SR17846: Limit changed from 100 to 50 (FirstCustom)
    //<< ; 19-Jun-2009   GRF     idForm and idLang rather than repeatedly extracting keys
    //<< ; 05-Oct-2007   GM      SR15596: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCompany,idForm,idLang,idPage,strStatus
    mVar idCompany = m$.var("idCompany");
    mVar idForm = m$.var("idForm");
    mVar idLang = m$.var("idLang");
    mVar idPage = m$.var("idPage");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idCompany,idForm,idLang,idPage,strStatus);
    //<< 
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idForm = $$$KEY1(pYKEY)
    idForm.set(include.COMSYSWWW.$$$KEY1(m$,pYKEY));
    //<< set idLang = $$$KEY2(pYKEY)
    idLang.set(include.COMSYSWWW.$$$KEY2(m$,pYKEY));
    //<< set idPage = $$$KEY3(pYKEY)
    idPage.set(include.COMSYSWWW.$$$KEY3(m$,pYKEY));
    //<< 
    //<< if (idPage < $$FirstCustom^WWW1203D()) {                        ;SR17846
    if ((mOp.Less(idPage.get(),m$.fnc$("WWW1203D.FirstCustom")))) {
      //<< set idCompany = ""
      idCompany.set("");
      //<< for {
      for (;true;) {
        //<< set idCompany = $order(^WWW1203D(0,idForm,idLang,idPage,idCompany))
        idCompany.set(m$.Fnc.$order(m$.var("^WWW1203D",0,idForm.get(),idLang.get(),idPage.get(),idCompany.get())));
        //<< quit:idCompany=""
        if (mOp.Equal(idCompany.get(),"")) {
          break;
        }
        //<< 
        //<< set strStatus = $$DeleteCustomisationTab(idForm_$$$COMMA_idLang_$$$COMMA_idPage_$$$COMMA_idCompany)
        strStatus.set(m$.fnc$("DeleteCustomisationTab",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idForm.get(),include.COMSYSString.$$$COMMA(m$)),idLang.get()),include.COMSYSString.$$$COMMA(m$)),idPage.get()),include.COMSYSString.$$$COMMA(m$)),idCompany.get())));
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< DeleteCustomisationTab(pidCustomTab)
  public Object DeleteCustomisationTab(Object ... _p) {
    mVar pidCustomTab = m$.newVarRef("pidCustomTab",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Delete a customisation tab.
    //<< ;
    //<< ;   pidCustomisationTab - the id of the customisation tab to be deleted.
    //<< ;
    //<< ; Returns:
    //<< ;   strStatus for the delete action.
    //<< ;
    //<< ; History:
    //<< ; 05-Oct-2007   GM      SR15596: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$$Kill("WWW1203D",pidCustomTab)
    strStatus.set(include.COMSYS.$$$Kill(m$,"WWW1203D",pidCustomTab));
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
//<< 
}
