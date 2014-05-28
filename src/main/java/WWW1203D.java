//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW1203D
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:10
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
//<< #include COMConst
import include.COMConst;
//<< #include WWWConst
import include.WWWConst;

//<< WWW1203D
public class WWW1203D extends mClass {

  public void main() {
    _WWW1203D();
  }

  public void _WWW1203D() {
  }

  //<< 
  //<< OnBeforeSave(pYKEY="",YFELD) // This code is currently not in use.
  public Object OnBeforeSave(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Execute before save
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Oct-2006   RPW     SRBR014072: Change $lb to $listbuild
    //<< ; 12-Jul-2006   shobby  SRBR014072: Created.
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,strForm,strLanguage,strPosition
    mVar strStatus = m$.var("strStatus");
    mVar strForm = m$.var("strForm");
    mVar strLanguage = m$.var("strLanguage");
    mVar strPosition = m$.var("strPosition");
    m$.newVar(strStatus,strForm,strLanguage,strPosition);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if $$$WWW1203DHide(YFELD) {
    if (mOp.Logical(include.WWWConst.$$$WWW1203DHide(m$,YFELD))) {
      //<< set strForm     = $$$KEY1(pYKEY)
      strForm.set(include.COMSYSWWW.$$$KEY1(m$,pYKEY));
      //<< set strLanguage = $$$KEY2(pYKEY)
      strLanguage.set(include.COMSYSWWW.$$$KEY2(m$,pYKEY));
      //<< set strPosition = $$$KEY3(pYKEY)
      strPosition.set(include.COMSYSWWW.$$$KEY3(m$,pYKEY));
      //<< if strPosition = $order(^WWW1203(0,strForm,strLanguage,"")) {
      if (mOp.Equal(strPosition.get(),m$.Fnc.$order(m$.var("^WWW1203",0,strForm.get(),strLanguage.get(),"")))) {
        //<< ;First Tab in sequence will show as the 'Primary' or 'Selected' tab when entering a
        //<< ;form even if not the first one in the display sequence.
        //<< set strStatus = $listbuild("34431") ; "Error!!!, Primary tab can not be hidden."
        strStatus.set(m$.Fnc.$listbuild("34431"));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set Q=$$$QSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QSave(m$));
    }
    //<< } else {
    else {
      //<< do ReturnError^COMUtils(strStatus)
      m$.Cmd.Do("COMUtils.ReturnError",strStatus.get());
      //<< set Q=$$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeSaveHook()
  public Object OnBeforeSaveHook(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; On before save hook for WWW1203D.
    //<< ;
    //<< ; Returns:
    //<< ;   strStatus for the save action.
    //<< ;
    //<< ; History:
    //<< ; 27-Jun-2007   FRANK   SRBR014503: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$UpdateCoreTab(YFELD, $$$KEY1(YKEY)_$$$COMMA_$$$KEY2(YKEY)_$$$COMMA_$$$KEY3(YKEY))
    strStatus.set(m$.fnc$("UpdateCoreTab",m$.var("YFELD").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEY")),include.COMSYSString.$$$COMMA(m$)),include.COMSYSWWW.$$$KEY2(m$,m$.var("YKEY"))),include.COMSYSString.$$$COMMA(m$)),include.COMSYSWWW.$$$KEY3(m$,m$.var("YKEY")))));
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< FirstCustom() ; 0-49 core.  50+ Custom ;SR17846
  public Object FirstCustom(Object ... _p) {
    //<< quit 51
    return 51;
  }

  //<< 
  //<< 
  //<< OnBeforeDeleteHook(pYKEY)
  public Object OnBeforeDeleteHook(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; On before delete hook for WWW1203D.
    //<< ;
    //<< ; pYKEY = return the keys
    //<< ;
    //<< ; Returns:
    //<< ;   strStatus for the delete action.
    //<< ;
    //<< ; History:
    //<< ; 08-Nov-2011   shobby  SR17846: Changed limits.  Core 0-49, Custom 50+
    //<< ; 22-Jul-2011   GRF     -: Order macros
    //<< ; 05-Oct-2007   GM      SR15596: Delete only Customisation Tabs
    //<< ; 27-Jun-2007   FRANK   SRBR014503: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus, idCompany, idPage, intCountComp
    mVar strStatus = m$.var("strStatus");
    mVar idCompany = m$.var("idCompany");
    mVar idPage = m$.var("idPage");
    mVar intCountComp = m$.var("intCountComp");
    m$.newVar(strStatus,idCompany,idPage,intCountComp);
    //<< 
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set intCountComp = 0
    intCountComp.set(0);
    //<< set idPage = $$$KEY3(pYKEY)
    idPage.set(include.COMSYSWWW.$$$KEY3(m$,pYKEY));
    //<< 
    //<< ;set strStatus = $$DeleteCoreTab($$$KEY1(YKEY)_$$$COMMA_$$$KEY2(YKEY)_$$$COMMA_$$$KEY3(YKEY))
    //<< ; Frank's code, modified by GM
    //<< 
    //<< if (idPage '< $$FirstCustom()) {                ;SR17846
    if ((mOp.NotLess(idPage.get(),m$.fnc$("FirstCustom")))) {
      //<< ; below 50 this is a core tab
      //<< ; 50+ it's just a customisation
      //<< 
      //<< set idCompany = ""
      idCompany.set("");
      //<< for {
      for (;true;) {
        //<< set idCompany = $order(^WWW1203D(0,$$$KEY1(pYKEY),$$$KEY2(pYKEY),idPage,idCompany))
        idCompany.set(m$.Fnc.$order(m$.var("^WWW1203D",0,include.COMSYSWWW.$$$KEY1(m$,pYKEY),include.COMSYSWWW.$$$KEY2(m$,pYKEY),idPage.get(),idCompany.get())));
        //<< quit:idCompany=""
        if (mOp.Equal(idCompany.get(),"")) {
          break;
        }
        //<< 
        //<< set intCountComp = intCountComp + 1
        intCountComp.set(mOp.Add(intCountComp.get(),1));
      }
      //<< }
      //<< 
      //<< if (intCountComp < 2) {
      if ((mOp.Less(intCountComp.get(),2))) {
        //<< set strStatus = $$DeleteCoreTab($$$KEY1(pYKEY)_$$$COMMA_$$$KEY2(pYKEY)_$$$COMMA_idPage)
        strStatus.set(m$.fnc$("DeleteCoreTab",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYSWWW.$$$KEY1(m$,pYKEY),include.COMSYSString.$$$COMMA(m$)),include.COMSYSWWW.$$$KEY2(m$,pYKEY)),include.COMSYSString.$$$COMMA(m$)),idPage.get())));
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< DeleteCoreTab(pidCoreTab)
  public Object DeleteCoreTab(Object ... _p) {
    mVar pidCoreTab = m$.newVarRef("pidCoreTab",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Delete a core tab.
    //<< ;
    //<< ;   pidCoreTab - the id of the core tab to be deleted.
    //<< ;
    //<< ; Returns:
    //<< ;   strStatus for the delete action.
    //<< ;
    //<< ; History:
    //<< ; 27-Jun-2007   FRANK   SRBR014503: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$$Kill("WWW1203",pidCoreTab)
    strStatus.set(include.COMSYS.$$$Kill(m$,"WWW1203",pidCoreTab));
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< UpdateCoreTab(pobjCustomTab, pidCoreTab)
  public Object UpdateCoreTab(Object ... _p) {
    mVar pobjCustomTab = m$.newVarRef("pobjCustomTab",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidCoreTab = m$.newVarRef("pidCoreTab",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update/create the core tab related to the Custom tab created/updated.
    //<< ;
    //<< ;   pobjCustomTab - the custom tab record.
    //<< ;   pidCoreTab - the id of the core tab to be created/updated.
    //<< ;
    //<< ; Returns:
    //<< ;   strStatus for the save action of the core tab.
    //<< ;
    //<< ; History:
    //<< ; 03-Sep-2013   shobby  CORE-241: Fixed test for existing tab.
    //<< ; 08-Nov-2011   shobby  SR17846: Changed limits.  Core 0-49, Custom 50+
    //<< ; 26-Oct-2007   shobby  SR15596: Cannot use $$$Save here because we want access
    //<< ;                           to the pblnDoOnBeforeSave flag to prevent a recursive
    //<< ;                           call as WWW1203 can update WWW1203D and the reverse
    //<< ;                           also applies.
    //<< ; 05-Oct-2007   GM      SR15596: Save page numbers greater than 99 in WWW1203D
    //<< ; 27-Jun-2007   FRANK   SRBR014503: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objTab, strStatus, intPageNumber
    mVar objTab = m$.var("objTab");
    mVar strStatus = m$.var("strStatus");
    mVar intPageNumber = m$.var("intPageNumber");
    m$.newVar(objTab,strStatus,intPageNumber);
    //<< 
    //<< set strStatus     = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set intPageNumber = $$$KEY3(pidCoreTab)
    intPageNumber.set(include.COMSYSWWW.$$$KEY3(m$,pidCoreTab));
    //<< 
    //<< // If we are saving a custom tab with id 50+, we have to create/update a core tab.
    //<< if intPageNumber '<$$FirstCustom() {                        ;SR17846
    if (mOp.NotLess(intPageNumber.get(),m$.fnc$("FirstCustom"))) {
      //<< set $$$WWW1203PictureFileForPageTag(objTab)   = $$$WWW1203DPictureFileForPageTag(pobjCustomTab)
      include.WWWConst.$$$WWW1203PictureFileForPageTagSet(m$,objTab,include.WWWConst.$$$WWW1203DPictureFileForPageTag(m$,pobjCustomTab));
      //<< set $$$WWW1203NextLine(objTab)                = $$$WWW1203DNextLine(pobjCustomTab)
      include.WWWConst.$$$WWW1203NextLineSet(m$,objTab,include.WWWConst.$$$WWW1203DNextLine(m$,pobjCustomTab));
      //<< set $$$WWW1203ToolTip(objTab)                 = $$$WWW1203DToolTip(pobjCustomTab)
      include.WWWConst.$$$WWW1203ToolTipSet(m$,objTab,include.WWWConst.$$$WWW1203DToolTip(m$,pobjCustomTab));
      //<< set $$$WWW1203DataFieldSearchFunction(objTab) = $$$WWW1203DDataFieldSearchFunction(pobjCustomTab)
      include.WWWConst.$$$WWW1203DataFieldSearchFunctionSet(m$,objTab,include.WWWConst.$$$WWW1203DDataFieldSearchFunction(m$,pobjCustomTab));
      //<< set $$$WWW1203AccessForModule(objTab)         = $$$WWW1203DAccessForModule(pobjCustomTab)
      include.WWWConst.$$$WWW1203AccessForModuleSet(m$,objTab,include.WWWConst.$$$WWW1203DAccessForModule(m$,pobjCustomTab));
      //<< set $$$WWW1203UsersAccess(objTab)             = $$$WWW1203DUsersAccess(pobjCustomTab)
      include.WWWConst.$$$WWW1203UsersAccessSet(m$,objTab,include.WWWConst.$$$WWW1203DUsersAccess(m$,pobjCustomTab));
      //<< set $$$WWW1203DisplayPosition(objTab)         = $$$WWW1203DDisplayPosition(pobjCustomTab)
      include.WWWConst.$$$WWW1203DisplayPositionSet(m$,objTab,include.WWWConst.$$$WWW1203DDisplayPosition(m$,pobjCustomTab));
      //<< 
      //<< ; ******  Do not use $$$Save here!!!! SR15596
      //<< ;set strStatus = $$$Save("WWW1203",pidCoreTab,objTab,$$$YES)
      //<< set strStatus = $$^WWWSPEI("WWW1203",pidCoreTab,objTab,$$$YES,,,,$$$NO)
      strStatus.set(m$.fnc$("WWWSPEI.main","WWW1203",pidCoreTab.get(),objTab.get(),include.COMSYS.$$$YES(m$),null,null,null,include.COMSYS.$$$NO(m$)));
    }
    //<< } else {
    else {
      //<< if '$data(^WWW1203(YM,$$$KEY1(pidCoreTab),$$$KEY2(pidCoreTab),$$$KEY3(pidCoreTab))) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW1203",m$.var("YM").get(),include.COMSYSWWW.$$$KEY1(m$,pidCoreTab),include.COMSYSWWW.$$$KEY2(m$,pidCoreTab),include.COMSYSWWW.$$$KEY3(m$,pidCoreTab))))) {
        //<< set strStatus=$$$MakeStatus(34360,$$FirstCustom()) ;"Page numbers less than %1 must correspond to an existing core tab."
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,34360,m$.fnc$("FirstCustom")));
      }
    }
    //<< }
    //<< }
    //<< ;set strStatus = $$$OK
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< CreateCoreTabs(pidLog)
  public Object CreateCoreTabs(Object ... _p) {
    mVar pidLog = m$.newVarRef("pidLog",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Loops through all the custom tabs, and creates the related core tab.
    //<< ;
    //<< ;   pidLog - the id log of the update process.
    //<< ;
    //<< ; Returns:
    //<< ;   strStatus for the save action of the core tab.
    //<< ;
    //<< ; History:
    //<< ; 08-Nov-2011   shobby  SR17846: Changed limits.  Core 0-49, Custom 50+
    //<< ; 22-Jul-2011   GRF     -: Order macros
    //<< ; 27-Jun-2007   FRANK   SRBR014503: Created
    //<< ;-------------------------------------------------------------------------------
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< new idPage,idForm,idLanguage,objCustomTab,strStatus,idCompany,idCustomTab
    mVar idPage = m$.var("idPage");
    mVar idForm = m$.var("idForm");
    mVar idLanguage = m$.var("idLanguage");
    mVar objCustomTab = m$.var("objCustomTab");
    mVar strStatus = m$.var("strStatus");
    mVar idCompany = m$.var("idCompany");
    mVar idCustomTab = m$.var("idCustomTab");
    m$.newVar(idPage,idForm,idLanguage,objCustomTab,strStatus,idCompany,idCustomTab);
    //<< 
    //<< set idPage = $$FirstCustom()-1                  ;SR17846
    idPage.set(mOp.Subtract(m$.fnc$("FirstCustom"),1));
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< for {
    for (;true;) {
      //<< set idPage = $order(^WWW1203Ds(0,2,idPage))
      idPage.set(m$.Fnc.$order(m$.var("^WWW1203Ds",0,2,idPage.get())));
      //<< quit:idPage=""
      if (mOp.Equal(idPage.get(),"")) {
        break;
      }
      //<< 
      //<< set idForm = ""
      idForm.set("");
      //<< for {
      for (;true;) {
        //<< set idForm = $order(^WWW1203Ds(0,2,idPage,idForm))
        idForm.set(m$.Fnc.$order(m$.var("^WWW1203Ds",0,2,idPage.get(),idForm.get())));
        //<< quit:idForm=""
        if (mOp.Equal(idForm.get(),"")) {
          break;
        }
        //<< 
        //<< set idLanguage = ""
        idLanguage.set("");
        //<< for {
        for (;true;) {
          //<< set idLanguage = $order(^WWW1203Ds(0,2,idPage,idForm,idLanguage))
          idLanguage.set(m$.Fnc.$order(m$.var("^WWW1203Ds",0,2,idPage.get(),idForm.get(),idLanguage.get())));
          //<< quit:idLanguage=""
          if (mOp.Equal(idLanguage.get(),"")) {
            break;
          }
          //<< 
          //<< set idCompany = ""
          idCompany.set("");
          //<< for {
          for (;true;) {
            //<< set idCompany = $order(^WWW1203Ds(0,2,idPage,idForm,idLanguage,idPage,idCompany))
            idCompany.set(m$.Fnc.$order(m$.var("^WWW1203Ds",0,2,idPage.get(),idForm.get(),idLanguage.get(),idPage.get(),idCompany.get())));
            //<< quit:idCompany=""
            if (mOp.Equal(idCompany.get(),"")) {
              break;
            }
            //<< 
            //<< set objCustomTab = $get(^WWW1203D(0,idForm,idLanguage,idPage,idCompany,1))
            objCustomTab.set(m$.Fnc.$get(m$.var("^WWW1203D",0,idForm.get(),idLanguage.get(),idPage.get(),idCompany.get(),1)));
            //<< set idCustomTab  = idForm_$$$COMMA_idLanguage_$$$COMMA_idPage_$$$COMMA_idCompany
            idCustomTab.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idForm.get(),include.COMSYSString.$$$COMMA(m$)),idLanguage.get()),include.COMSYSString.$$$COMMA(m$)),idPage.get()),include.COMSYSString.$$$COMMA(m$)),idCompany.get()));
            //<< set strStatus    = $$$Save("WWW1203D",idCustomTab,objCustomTab,$$$YES)
            strStatus.set(include.COMSYS.$$$Save(m$,"WWW1203D",idCustomTab,objCustomTab,include.COMSYS.$$$YES(m$)));
            //<< 
            //<< if $$$ISERR(strStatus) {
            if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
              //<< do AddMessage^COMLog(pidLog,"Data update failure: "_$$$Text(strStatus))
              m$.Cmd.Do("COMLog.AddMessage",pidLog.get(),mOp.Concat("Data update failure: ",include.COMSYS.$$$Text(m$,strStatus)));
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
}
