//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMValidation
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-10 14:40:36
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
//<< #include WWWConst
import include.WWWConst;
//import COMSYS;

//<< WWWFORMValidation
public class WWWFORMValidation extends mClass {

  //<< 
  //<< #define FormData(%form,%type)       ^WWWDATEN(0,+$horolog,YUSER,%form,%type,1)
  public static Object $$$FormData(mContext m$, Object ... _p) {
    mVar p$form = m$.varRef("p$form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$type = m$.varRef("p$type",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),p$form.get(),p$type.get(),1).get());
  }

  public static mVar $$$FormDataVar(mContext m$, Object ... _p) {
    mVar p$form = m$.varRef("p$form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$type = m$.varRef("p$type",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),p$form.get(),p$type.get(),1));
  }

  //<< #define FormDataOld(%form,%type)    ^WWWDATEN(0,+$horolog,YUSER,%form,%type,2)
  public static Object $$$FormDataOld(mContext m$, Object ... _p) {
    mVar p$form = m$.varRef("p$form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$type = m$.varRef("p$type",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),p$form.get(),p$type.get(),2).get());
  }

  public static mVar $$$FormDataOldVar(mContext m$, Object ... _p) {
    mVar p$form = m$.varRef("p$form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$type = m$.varRef("p$type",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),p$form.get(),p$type.get(),2));
  }

  //<< #define FormDataOldGet(%form,%type) $get(^WWWDATEN(0,+$horolog,YUSER,%form,%type,2))
  public static Object $$$FormDataOldGet(mContext m$, Object ... _p) {
    mVar p$form = m$.varRef("p$form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$type = m$.varRef("p$type",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),p$form.get(),p$type.get(),2)));
  }

  public void main() {
    _WWWFORMValidation();
  }

  public void _WWWFORMValidation() {
  }

  //<< 
  //<< BeforeSave(pintPage,pnull)
  public Object BeforeSave(Object ... _p) {
    mVar pintPage = m$.newVarRef("pintPage",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pnull = m$.newVarRef("pnull",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Validate during hyper event
    //<< ;
    //<< ; Params:   pintPage - current page (YSEITE)
    //<< ;           pnull - not used
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  for eventvalue - alert error or submit form
    //<< ;
    //<< ; History:
    //<< ; 30-May-2011   GRF     Replace $$^WWWYM with 0
    //<< ; 27-Jan-2011   GRF     SR17579: replace $$$Order macros; stsField => strStatus;
    //<< ;                           use dteToday
    //<< ; 22-Aug-2008   FIS     SR15828: Correction to compare with new WWWDATEN(4)
    //<< ;                           record (orig. data after WWWFORM)
    //<< ; 12-Aug-2008   FIS     SR15828: Compare with new WWWDATEN(3) record (orig. data before WWWFORM)
    //<< ; 05-Aug-2008   FIS     SR15828: Compare saved data with loaded data before allow saving
    //<< ; 27-Sep-2007   GRF     SR15603: Macro change
    //<< ; 23-May-2007   RGB     SRBR014456: VARHOOK onbeforsave call is running here now
    //<< ;                       for fixing a bug. Added FormDataOld definition.
    //<< ; 27-Mar-2007   PO      SR15442: If valid key, don't perform field check
    //<< ; 22-Mar-2007   JW      SR15453: Get YOPTION, YOPTION1 from cache
    //<< ; 24-Jan-2006   JW      Don't check primary keys for search engine type.
    //<< ; 08-Aug-2006   JW      SR13594: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnContinue,blnValidKey,dteToday,idClass,idField,intCount
    mVar blnContinue = m$.var("blnContinue");
    mVar blnValidKey = m$.var("blnValidKey");
    mVar dteToday = m$.var("dteToday");
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar intCount = m$.var("intCount");
    m$.newVar(blnContinue,blnValidKey,dteToday,idClass,idField,intCount);
    //<< new objDispData,objForm,objLoadData,objOrigData,objSrcData,strData,strExec
    mVar objDispData = m$.var("objDispData");
    mVar objForm = m$.var("objForm");
    mVar objLoadData = m$.var("objLoadData");
    mVar objOrigData = m$.var("objOrigData");
    mVar objSrcData = m$.var("objSrcData");
    mVar strData = m$.var("strData");
    mVar strExec = m$.var("strExec");
    m$.newVar(objDispData,objForm,objLoadData,objOrigData,objSrcData,strData,strExec);
    //<< new strKey,strKeys,strManual,strPerform,strReturn,strSrcClass,strStatus,strValue
    mVar strKey = m$.var("strKey");
    mVar strKeys = m$.var("strKeys");
    mVar strManual = m$.var("strManual");
    mVar strPerform = m$.var("strPerform");
    mVar strReturn = m$.var("strReturn");
    mVar strSrcClass = m$.var("strSrcClass");
    mVar strStatus = m$.var("strStatus");
    mVar strValue = m$.var("strValue");
    m$.newVar(strKey,strKeys,strManual,strPerform,strReturn,strSrcClass,strStatus,strValue);
    //<< 
    //<< set blnContinue = $$$YES
    blnContinue.set(include.COMSYS.$$$YES(m$));
    //<< set strReturn   = ""
    strReturn.set("");
    //<< set strPerform  = ""
    strPerform.set("");
    //<< set dteToday    = +$horolog
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< set objForm = $get(^WWW120(0,YFORM,1))
    objForm.set(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
    //<< set idClass = $$$WWW120ClassUsedInForm(objForm)
    idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objForm));
    //<< set strKeys = $$$GetFormData(YFORM,"P")
    strKeys.set(include.COMSYSWWW.$$$GetFormData(m$,m$.var("YFORM"),"P"));
    //<< 
    //<< if $$IsNewRecord^WWWFORMStatus() {
    if (mOp.Logical(m$.fnc$("WWWFORMStatus.IsNewRecord"))) {
      //<< set blnValidKey = $$$YES
      blnValidKey.set(include.COMSYS.$$$YES(m$));
      //<< for intCount = 1:1:$length(strKeys,$$$COMMA) {
      for (intCount.set(1);(mOp.LessOrEqual(intCount.get(),m$.Fnc.$length(strKeys.get(),include.COMSYSString.$$$COMMA(m$))));intCount.set(mOp.Add(intCount.get(),1))) {
        //<< set strKey      = $piece(strKeys,$$$COMMA,intCount)
        strKey.set(m$.Fnc.$piece(strKeys.get(),include.COMSYSString.$$$COMMA(m$),intCount.get()));
        //<< set blnValidKey = (blnValidKey && '$$$NoKey(strKey))
        blnValidKey.set((mOp.Logical(blnValidKey.get()) && mOp.Not(include.COMSYS.$$$NoKey(m$,strKey))));
        //<< quit:'blnValidKey
        if (mOp.Not(blnValidKey.get())) {
          break;
        }
      }
      //<< }
      //<< if blnValidKey {
      if (mOp.Logical(blnValidKey.get())) {
        //<< if $$$ISOK($$GetRecord^COMUtilClass(idClass,strKeys)) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,m$.fnc$("COMUtilClass.GetRecord",idClass.get(),strKeys.get())))) {
          //<< set blnContinue = $$$NO
          blnContinue.set(include.COMSYS.$$$NO(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< } elseif (idClass'="") && ($translate(strKeys,"+")'="") {
    else if ((mOp.NotEqual(idClass.get(),"")) && (mOp.NotEqual(m$.Fnc.$translate(strKeys.get(),"+"),""))) {
      //<< set strSrcClass = "^"_idClass_"(0,"_$$^WWWKEYBUILD(strKeys)_",1)"   ; 20-May-2011
      strSrcClass.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",idClass.get()),"(0,"),m$.fnc$("WWWKEYBUILD.main",strKeys.get())),",1)"));
      //<< set objSrcData  = $get(@strSrcClass)
      objSrcData.set(m$.Fnc.$get(m$.indirectVar(strSrcClass.get())));
      //<< ;   set objLoadData = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"D",2))  ;data snapshot before form load, modified by default data changes
      //<< ;   set objOrigData = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"D",3))  ;data snapshot before form load (-> inactivated in WWWFORM)
      //<< set objDispData = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"D",4))  ;data snapshot after form load (and after all executes that may changed the data)
      objDispData.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",4)));
      //<< 
      //<< if (objSrcData '= "") && (objDispData '= "") && ($translate(objSrcData,Y) '= $translate(objDispData,Y)) {  //saved data '= loaded data
      if ((mOp.NotEqual(objSrcData.get(),"")) && (mOp.NotEqual(objDispData.get(),"")) && (mOp.NotEqual(m$.Fnc.$translate(objSrcData.get(),m$.var("Y").get()),m$.Fnc.$translate(objDispData.get(),m$.var("Y").get())))) {
        //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"D",2) = ""
        m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",2).set("");
        //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"D",1) = objSrcData
        m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1).set(objSrcData.get());
        //<< set strPerform = $$^WWWREFRESH(YUSER,YFORM)
        strPerform.set(m$.fnc$("WWWREFRESH.main",m$.var("YUSER").get(),m$.var("YFORM").get()));
        //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"D",2) = objSrcData
        m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",2).set(objSrcData.get());
        //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"D",4) = objSrcData
        m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",4).set(objSrcData.get());
        //<< set strPerform = strPerform_"#"_$$$AlertFollowing_$$$Text("WWW00090")
        strPerform.set(mOp.Concat(mOp.Concat(mOp.Concat(strPerform.get(),"#"),include.COMSYS.$$$AlertFollowing(m$)),include.COMSYS.$$$Text(m$,"WWW00090")));
        //<< set blnContinue = $$$NO
        blnContinue.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< } ; "The data has been changed by a different User. The Form will get updated. Please re-enter your changes."
    //<< }
    //<< 
    //<< if blnContinue && $$$HYPERValidation(YFORM) {
    if (mOp.Logical(blnContinue.get()) && mOp.Logical(include.COMSYS.$$$HYPERValidation(m$,m$.var("YFORM")))) {
      //<< set strManual = $$$GetFormData(YFORM,"M")                    ; Manual fields
      strManual.set(include.COMSYSWWW.$$$GetFormData(m$,m$.var("YFORM"),"M"));
      //<< set idField   = ""
      idField.set("");
      //<< for {
      for (;true;) {
        //<< set idField = $order(^WWW122s(0,4," ",YFORM,idField))
        idField.set(m$.Fnc.$order(m$.var("^WWW122s",0,4," ",m$.var("YFORM").get(),idField.get())));
        //<< quit:idField=""
        if (mOp.Equal(idField.get(),"")) {
          break;
        }
        //<< continue:'$data(^WWW122s(0,1,pintPage,YFORM,idField))   ; Only this page for manual fields
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122s",0,1,pintPage.get(),m$.var("YFORM").get(),idField.get())))) {
          continue;
        }
        //<< 
        //<< set strStatus = $$Validate^WWWSAVM(YFORM,idField,$piece(strManual,Y,idField))
        strStatus.set(m$.fnc$("WWWSAVM.Validate",m$.var("YFORM").get(),idField.get(),m$.Fnc.$piece(strManual.get(),m$.var("Y").get(),idField.get())));
        //<< if $$$ISERR(strStatus) {
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
          //<< set strReturn = strReturn_$$$FieldName(YFORM,"M",idField)_": "_$$$Text(strStatus)_"|"
          strReturn.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strReturn.get(),include.COMSYSWWW.$$$FieldName(m$,m$.var("YFORM"),"M",idField)),": "),include.COMSYS.$$$Text(m$,strStatus)),"|"));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< // Only keys, data, Before Save for standard forms (from WWWSAVE)
      //<< set objForm = $get(^WWW120(0,YFORM,1))
      objForm.set(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
      //<< set idClass = $$$WWW120ClassUsedInForm(objForm)
      idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objForm));
      //<< 
      //<< if (idClass'="") && '$$$Contains((2,4,7),$$$WWW120FormType(objForm)) {
      if ((mOp.NotEqual(idClass.get(),"")) && mOp.Not(m$.Fnc.$listfind(m$.Fnc.$listbuild(2,4,7),include.WWWConst.$$$WWW120FormType(m$,objForm)))) {
        //<< set strKeys = $$$GetFormData(YFORM,"P")                  ; Primary Keys
        strKeys.set(include.COMSYSWWW.$$$GetFormData(m$,m$.var("YFORM"),"P"));
        //<< set idField = ""
        idField.set("");
        //<< for {
        for (;true;) {
          //<< set idField = $order(^WWW002(0,idClass,idField))
          idField.set(m$.Fnc.$order(m$.var("^WWW002",0,idClass.get(),idField.get())));
          //<< quit:idField=""
          if (mOp.Equal(idField.get(),"")) {
            break;
          }
          //<< 
          //<< set strStatus = $$Validate^WWWSAVP(idClass,YFORM,idField,$piece(strKeys,",",idField))
          strStatus.set(m$.fnc$("WWWSAVP.Validate",idClass.get(),m$.var("YFORM").get(),idField.get(),m$.Fnc.$piece(strKeys.get(),",",idField.get())));
          //<< if $$$ISERR(strStatus) {
          if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
            //<< set strReturn = strReturn_$$$FieldName(YFORM,"P",idField)_": "_$$$Text(strStatus)_"|"
            strReturn.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strReturn.get(),include.COMSYSWWW.$$$FieldName(m$,m$.var("YFORM"),"P",idField)),": "),include.COMSYS.$$$Text(m$,strStatus)),"|"));
          }
        }
        //<< }
        //<< }
        //<< // Data Fields
        //<< set YOPTION  = $get(^CacheTempForm(YUCI,YUSER,YFORM,"YOPTION"))
        mVar YOPTION = m$.var("YOPTION");
        YOPTION.set(m$.Fnc.$get(m$.var("^CacheTempForm",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"YOPTION")));
        //<< set YOPTION1 = $get(^CacheTempForm(YUCI,YUSER,YFORM,"YOPTION1"))
        mVar YOPTION1 = m$.var("YOPTION1");
        YOPTION1.set(m$.Fnc.$get(m$.var("^CacheTempForm",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"YOPTION1")));
        //<< 
        //<< set strData = $$$GetFormData(YFORM,"D")
        strData.set(include.COMSYSWWW.$$$GetFormData(m$,m$.var("YFORM"),"D"));
        //<< 
        //<< set strReturn = strReturn_$$DataFields(idClass,YFORM,.strData)
        strReturn.set(mOp.Concat(strReturn.get(),m$.fnc$("DataFields",idClass.get(),m$.var("YFORM").get(),strData)));
        //<< if strReturn'="" {
        if (mOp.NotEqual(strReturn.get(),"")) {
          //<< set blnContinue = $$$NO
          blnContinue.set(include.COMSYS.$$$NO(m$));
        }
        //<< } else {
        else {
          //<< ;           On Before Save                                  ; *** EXECUTE ? ***
          //<< set strExec = $$$WWW120ExecuteOnBeforeSaveData($get(^WWW120(0,YFORM,1)))
          strExec.set(include.WWWConst.$$$WWW120ExecuteOnBeforeSaveData(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1))));
          //<< if strExec'="" {
          if (mOp.NotEqual(strExec.get(),"")) {
            //<< if $extract(strExec)="#" {
            if (mOp.Equal(m$.Fnc.$extract(strExec.get()),"#")) {
              //<< set $extract(strExec) = ""
              mVar $extract = m$.var("$extract");
              $extract.var(strExec.get()).set("");
            }
            //<< }
            //<< set blnContinue = $$Execute(strExec,strKeys,.strData,strManual)   ; FIXME : see next call to $$Execute
            blnContinue.set(m$.fnc$("Execute",strExec.get(),strKeys.get(),strData,strManual.get()));
          }
          //<< }
          //<< if blnContinue {                                         ;SR17245
          if (mOp.Logical(blnContinue.get())) {
            //<< set strStatus = $$OnBeforeSave^COMGridEdit31Display(strKeys,strData)  ;SR17245
            strStatus.set(m$.fnc$("COMGridEdit31Display.OnBeforeSave",strKeys.get(),strData.get()));
            //<< if $$$ISERR(strStatus) {                             ;SR17245
            if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
              //<< set blnContinue = $$$NO                          ;SR17245
              blnContinue.set(include.COMSYS.$$$NO(m$));
              //<< set strReturn   = $$$Text(strStatus)             ;SR17245
              strReturn.set(include.COMSYS.$$$Text(m$,strStatus));
            }
          }
          //<< }                                                    ;SR17245
          //<< }                                                        ;SR17245
          //<< ;                                                           ; *** EXECUTE ? ***
          //<< if blnContinue {
          if (mOp.Logical(blnContinue.get())) {
            //<< if $$EXIST^%R("Y"_YFORM_"onBeforeSave.OBJ",$get(YUCI)) {    // CUSTOMIZING EXECUTE VOR SPEICHERN Q:FORMULAR FERTIG
            if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"onBeforeSave.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
              //<< set strExec = "DO ^Y"_YFORM_"onBeforeSave"
              strExec.set(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),"onBeforeSave"));
              //<< set blnContinue = $$Execute(strExec,strKeys,.strData,strManual)   ; FIXME : Will repeat the WWWFORM5 processing - variable setup?
              blnContinue.set(m$.fnc$("Execute",strExec.get(),strKeys.get(),strData,strManual.get()));
            }
          }
          //<< }
          //<< }
          //<< ;                                                           ; *** EXECUTE ? ***
          //<< if blnContinue { // RGB - Added the varhook on before call
          if (mOp.Logical(blnContinue.get())) {
            //<< //  set strDataOld = $$$FormDataOld(YFORM,"D")  //undefined if not exists
            //<< set strDataOld = $$$FormDataOldGet(YFORM,"D")
            mVar strDataOld = m$.var("strDataOld");
            strDataOld.set($$$FormDataOldGet(m$,m$.var("YFORM"),"D"));
            //<< set strStatus  = $$ExecuteHook^WWW001Hook(idClass,$$$EnumWWWEVENTTYPEOnBeforeSave,strKeys,.strData,YFORM,strDataOld)
            strStatus.set(m$.fnc$("WWW001Hook.ExecuteHook",idClass.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeSave(m$),strKeys.get(),strData,m$.var("YFORM").get(),strDataOld.get()));
            //<< if $$$ISERR(strStatus) {
            if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
              //<< set blnContinue = $$$NO
              blnContinue.set(include.COMSYS.$$$NO(m$));
              //<< set strReturn   = $$$Text(strStatus)
              strReturn.set(include.COMSYS.$$$Text(m$,strStatus));
            }
          }
          //<< }
          //<< }
          //<< if blnContinue {
          if (mOp.Logical(blnContinue.get())) {
            //<< set $$$FormData(YFORM,"D") = strData        // Reset WWWDATEN. Ok ? :)
            $$$FormDataVar(m$,m$.var("YFORM"),"D").set(strData.get());
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if strReturn '= "" {
    if (mOp.NotEqual(strReturn.get(),"")) {
      //<< set strReturn = $$$AlertFollowing_strReturn
      strReturn.set(mOp.Concat(include.COMSYS.$$$AlertFollowing(m$),strReturn.get()));
    }
    //<< 
    //<< } elseif strPerform '= "" {
    else if (mOp.NotEqual(strPerform.get(),"")) {
      //<< set strReturn = strPerform
      strReturn.set(strPerform.get());
    }
    //<< 
    //<< } elseif blnContinue {
    else if (mOp.Logical(blnContinue.get())) {
      //<< set strReturn = $$$Perform_"FUNCTION~DefaultSubmit(0)"
      strReturn.set(mOp.Concat(include.COMSYS.$$$Perform(m$),"FUNCTION~DefaultSubmit(0)"));
    }
    //<< }
    //<< quit strReturn
    return strReturn.get();
  }

  //<< 
  //<< 
  //<< DataFields(pidClass,pidForm,&pstrData)
  public Object DataFields(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrData = m$.newVarRef("pstrData",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Validate data fields before save
    //<< ;
    //<< ; Params:   pidClass    - class id
    //<< ;           pidForm     - current form (YFORM)
    //<< ;
    //<< ; ByRefs:   pstrData    - data record (YFELD)
    //<< ;
    //<< ; Returns:  error message or null if fine
    //<< ;
    //<< ; History:
    //<< ; 11-May-2009   GRF     stsField => strStatus
    //<< ; 29-Mar-2008   heber   BR014919: Pattern match on grid fields
    //<< ; 29-Sep-2006   HeberB  BR014265: Add YFELD as param to Validate
    //<< ; 09-Aug-2006   JW      SR13594: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idFormField,idxFormField,objField
    mVar idField = m$.var("idField");
    mVar idFormField = m$.var("idFormField");
    mVar idxFormField = m$.var("idxFormField");
    mVar objField = m$.var("objField");
    m$.newVar(idField,idFormField,idxFormField,objField);
    //<< new strStatus,strPattern,strReturn,strValue
    mVar strStatus = m$.var("strStatus");
    mVar strPattern = m$.var("strPattern");
    mVar strReturn = m$.var("strReturn");
    mVar strValue = m$.var("strValue");
    m$.newVar(strStatus,strPattern,strReturn,strValue);
    //<< 
    //<< set strReturn = ""
    strReturn.set("");
    //<< set idField   = ""
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField = $order(^WWW003(0,pidClass,idField))
      idField.set(m$.Fnc.$order(m$.var("^WWW003",0,pidClass.get(),idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< 
      //<< set strValue  = $piece(pstrData,Y,idField)
      strValue.set(m$.Fnc.$piece(pstrData.get(),m$.var("Y").get(),idField.get()));
      //<< set strStatus = $$Validate^WWWSAVD(pidClass,pidForm,idField,.strValue,,pstrData)
      strStatus.set(m$.fnc$("WWWSAVD.Validate",pidClass.get(),pidForm.get(),idField.get(),strValue,null,pstrData.get()));
      //<< 
      //<< // BR014919
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< set idxFormField = $$$Index(idField)
        idxFormField.set(include.COMConst.$$$Index(m$,idField));
        //<< set idFormField  = $order(^WWW122s(0,4,idxFormField,pidForm,""))
        idFormField.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,idxFormField.get(),pidForm.get(),"")));
        //<< if (idFormField '= "") {
        if ((mOp.NotEqual(idFormField.get(),""))) {
          //<< set objField = $$Get^WWW122(pidForm,idFormField)
          objField.set(m$.fnc$("WWW122.Get",pidForm.get(),idFormField.get()));
          //<< set strPattern = $$$WWW122PatternMatch(objField)
          strPattern.set(include.WWWConst.$$$WWW122PatternMatch(m$,objField));
          //<< if (strPattern '= "") && (strValue '= "") {
          if ((mOp.NotEqual(strPattern.get(),"")) && (mOp.NotEqual(strValue.get(),""))) {
            //<< if '(strValue?@strPattern) {
            if (mOp.Not((mOp.Match(strValue.get(),m$.indirectVar("strPattern").get())))) {
              //<< set strStatus = $$$MakeStatus("WWW00089",strPattern)
              strStatus.set(include.COMSYS.$$$MakeStatus(m$,"WWW00089",strPattern));
            }
          }
        }
      }
      //<< } ; "Wrong Input Format, correct pattern: %1"
      //<< }
      //<< }
      //<< }
      //<< //^^^^^^^^^^^^^^
      //<< 
      //<< set $piece(pstrData,Y,idField) = strValue
      m$.pieceVar(pstrData,m$.var("Y").get(),idField.get()).set(strValue.get());
      //<< if $$$ISERR(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        //<< set strReturn = strReturn_$$$FieldName(pidForm,"D",idField)_": "_$$$Text(strStatus)_"|"
        strReturn.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strReturn.get(),include.COMSYSWWW.$$$FieldName(m$,pidForm,"D",idField)),": "),include.COMSYS.$$$Text(m$,strStatus)),"|"));
      }
    }
    //<< }
    //<< }
    //<< quit strReturn
    return strReturn.get();
  }

  //<< 
  //<< 
  //<< Execute(pstrExec,YKEY,&YFELD,YMFELD)
  public Object Execute(Object ... _p) {
    mVar pstrExec = m$.newVarRef("pstrExec",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YMFELD = m$.newVarRef("YMFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for On Before Save execution
    //<< ;
    //<< ; Params:   pstrExec - string to execute
    //<< ;           YKEY - current key
    //<< ;           YMFELD - manual field record
    //<< ;
    //<< ; ByRefs:   YFELD - data field record
    //<< ;
    //<< ; Returns:  boolean - whether save is ok
    //<< ;
    //<< ; History:
    //<< ; 09-Aug-2006   JW      SR13594: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnOk
    mVar blnOk = m$.var("blnOk");
    m$.newVar(blnOk);
    //<< 
    //<< do ^WWWFORM5
    m$.Cmd.Do("WWWFORM5.main");
    //<< xecute pstrExec
    m$.Cmd.Xecute(pstrExec.get());
    //<< set blnOk = ($get(Q)'=1)        ;EXECUTE VOR SPEICHERN Q:FORMULAR FERTIG ;EXECUTE pre- Save ready-made
    blnOk.set((mOp.NotEqual(m$.Fnc.$get(m$.var("Q")),1)));
    //<< 
    //<< quit blnOk
    return blnOk.get();
  }

//<< 
//<< 
//<< 
}
