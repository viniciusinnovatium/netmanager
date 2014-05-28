//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW124
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:29
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
//<< #include COMConst
import include.COMConst;

//<< WWW124
public class WWW124 extends mClass {

  public void main() {
    _WWW124();
  }

  public void _WWW124() {
  }

  //<< 
  //<< ;14-Jun-2011    shobby  SR17792:   Class/Form changed (Do Not remove comment)
  //<< ;09-Sep-2008    shobby  SRBR014980 Class/Form changed (Do Not remove comment)
  //<< ;29-Apr-2008    shobby  SRBR014939 Class/Form changed (Do Not remove comment)
  //<< 
  //<< OnBeforeDelete(pYKEY)
  public Object OnBeforeDelete(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Routine to run after deleting a button
    //<< ;
    //<< ; Params: pYKEY : The YKEY
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: strStatus
    //<< ;
    //<< ; History:
    //<< ; 26-May-2009   shobby  SRBR014988: Kill other languages only when the EN button
    //<< ;                           is killed.
    //<< ; 10-Sep-2008   shobby  Removed kill of COMHelp* (temporary data now)
    //<< ; 22-Feb-2007   JW      SR15452: Kill other languages
    //<< ; 08-Nov-2006   SS      SR14915: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,idForm,idLang,idSeq
    mVar strStatus = m$.var("strStatus");
    mVar idForm = m$.var("idForm");
    mVar idLang = m$.var("idLang");
    mVar idSeq = m$.var("idSeq");
    m$.newVar(strStatus,idForm,idLang,idSeq);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< //if $$GetKey^COMUtilClass(pYKEY,3) {
    //<< if $$GetKey^COMUtilClass(pYKEY,3,3,.idForm,.idLang,.idSeq) {        //SR15452 ;BR014988
    if (mOp.Logical(m$.fnc$("COMUtilClass.GetKey",pYKEY.get(),3,3,idForm,idLang,idSeq))) {
      //<< ;set strStatus = $$$Kill("COMHelpButton",pYKEY)  BR014980
      //<< 
      //<< if idLang="EN" {      // SR15452 - Kill other languages
      if (mOp.Equal(idLang.get(),"EN")) {
        //<< if $$$ISOK(strStatus) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
          //<< set idLang = ""
          idLang.set("");
          //<< for {
          for (;true;) {
            //<< set idLang = $order(^WWW124(0,idForm,idLang))
            idLang.set(m$.Fnc.$order(m$.var("^WWW124",0,idForm.get(),idLang.get())));
            //<< quit:idLang=""
            if (mOp.Equal(idLang.get(),"")) {
              break;
            }
            //<< continue:(idLang="EN") ;BR014988
            if ((mOp.Equal(idLang.get(),"EN"))) {
              continue;
            }
            //<< 
            //<< if $data(^WWW124(0,idForm,idLang,idSeq)) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW124",0,idForm.get(),idLang.get(),idSeq.get())))) {
              //<< set strStatus = $$$Kill("WWW124",idForm_$$$COMMA_idLang_$$$COMMA_idSeq)
              strStatus.set(include.COMSYS.$$$Kill(m$,"WWW124",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idForm.get(),include.COMSYSString.$$$COMMA(m$)),idLang.get()),include.COMSYSString.$$$COMMA(m$)),idSeq.get())));
            }
            //<< }
            //<< quit:$$$ISERR(strStatus)
            if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
              break;
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnAfterSave(pYKEY,pobjButton)
  public Object OnAfterSave(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjButton = m$.newVarRef("pobjButton",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Routine to run after saving a button
    //<< ;
    //<< ; Params: pYKEY : The YKEY
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: strStatus
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2011   shobby  SR17829:  New properties added to a button weren't being copied.
    //<< ; 26-May-2009   shobby  SRBR014988: Reworked to only modify other buttons when
    //<< ;                           English button changes.  Include additional fields
    //<< ;                           for preservation.
    //<< ; 10-Sep-2008   shobby  Removed kill of COMHelp* (temporary data now)
    //<< ; 22-Feb-2007   JW      SR15452: Copy to English/Portuguese. Added pobjButton
    //<< ; 08-Nov-2006   SteveS  SR14915: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,idForm,idLang,idSeq,idCopyLang,objOldLangButton,objLangButton,intField
    mVar strStatus = m$.var("strStatus");
    mVar idForm = m$.var("idForm");
    mVar idLang = m$.var("idLang");
    mVar idSeq = m$.var("idSeq");
    mVar idCopyLang = m$.var("idCopyLang");
    mVar objOldLangButton = m$.var("objOldLangButton");
    mVar objLangButton = m$.var("objLangButton");
    mVar intField = m$.var("intField");
    m$.newVar(strStatus,idForm,idLang,idSeq,idCopyLang,objOldLangButton,objLangButton,intField);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if $$GetKey^COMUtilClass(pYKEY,3,3,.idForm,.idLang,.idSeq) {
    if (mOp.Logical(m$.fnc$("COMUtilClass.GetKey",pYKEY.get(),3,3,idForm,idLang,idSeq))) {
      //<< if idLang="EN" {                                // Copy to other languages
      if (mOp.Equal(idLang.get(),"EN")) {
        //<< if $$$ISOK(strStatus) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
          //<< for idCopyLang = "PT","ES" {            // Add other languages when needed
          for (Object _idCopyLang: new Object[] {"PT","ES"}) {
            idCopyLang.set(_idCopyLang);
            //<< set objLangButton = $get(^WWW124(0,idForm,idCopyLang,idSeq,1),pobjButton)
            objLangButton.set(m$.Fnc.$get(m$.var("^WWW124",0,idForm.get(),_idCopyLang,idSeq.get(),1),pobjButton.get()));
            //<< 
            //<< ;for intField=1:1:$length(objLangButton,Y) {            ;SR17829
            //<< for intField=1:1:$length(pobjButton,Y) {                ;SR17829
            for (intField.set(1);(mOp.LessOrEqual(intField.get(),m$.Fnc.$length(pobjButton.get(),m$.var("Y").get())));intField.set(mOp.Add(intField.get(),1))) {
              //<< if '$$Ignore^WWWBUTTONCHECK(intField) {
              if (mOp.Not(m$.fnc$("WWWBUTTONCHECK.Ignore",intField.get()))) {
                //<< set $piece(objLangButton,Y,intField) = $piece(pobjButton,Y,intField)
                m$.pieceVar(objLangButton,m$.var("Y").get(),intField.get()).set(m$.Fnc.$piece(pobjButton.get(),m$.var("Y").get(),intField.get()));
              }
            }
            //<< }
            //<< }
            //<< set strStatus = $$$Save("WWW124",idForm_","_idCopyLang_","_idSeq,objLangButton,$$$YES)
            strStatus.set(include.COMSYS.$$$Save(m$,"WWW124",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idForm.get(),","),_idCopyLang),","),idSeq.get()),objLangButton,include.COMSYS.$$$YES(m$)));
            //<< quit:$$$ISERR(strStatus)
            if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
              break;
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetButtonImage(pidForm,pidLang,pidButton,pblnDisabled)
  public Object GetButtonImage(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidButton = m$.newVarRef("pidButton",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnDisabled = m$.newVarRef("pblnDisabled",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Works out the name of the image to be displayed based on the Id and the disabled condition.
    //<< ; There are a few images that we know exist and can display the disabled version even if none
    //<< ; specified.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Jul-2007   RPW     SRBR014409: pYFORM > pidForm, pSPRACHE > pidLang
    //<< ; 26-Jun-2007   shobby  SRBR014409: Call to standard routine to get the known
    //<< ;                           equivalent disabled image name
    //<< ; 25-Jun-2007   shobby  SRBR014409: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW124,strImage
    mVar objWWW124 = m$.var("objWWW124");
    mVar strImage = m$.var("strImage");
    m$.newVar(objWWW124,strImage);
    //<< 
    //<< set strImage = ""
    strImage.set("");
    //<< if (pidForm'="") && (pidLang'="") && (pidButton'="") {
    if ((mOp.NotEqual(pidForm.get(),"")) && (mOp.NotEqual(pidLang.get(),"")) && (mOp.NotEqual(pidButton.get(),""))) {
      //<< set objWWW124 = $get(^WWW124(0,pidForm,pidLang,pidButton,1))
      objWWW124.set(m$.Fnc.$get(m$.var("^WWW124",0,pidForm.get(),pidLang.get(),pidButton.get(),1)));
      //<< set strImage  = $$$WWW124PictureFileOnButton(objWWW124)
      strImage.set(include.WWWConst.$$$WWW124PictureFileOnButton(m$,objWWW124));
      //<< if strImage="" {
      if (mOp.Equal(strImage.get(),"")) {
        //<< set strImage = $$$LOWER($extract($$$WWW124ButtonDescription(objWWW124)))_".gif"
        strImage.set(mOp.Concat(include.COMSYSString.$$$LOWER(m$,m$.Fnc.$extract(include.WWWConst.$$$WWW124ButtonDescription(m$,objWWW124))),".gif"));
      }
      //<< }
      //<< if pblnDisabled {
      if (mOp.Logical(pblnDisabled.get())) {
        //<< if $$$WWW124ImageFileForDisabledButto(objWWW124)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW124ImageFileForDisabledButto(m$,objWWW124),"")) {
          //<< set strImage = $$$WWW124ImageFileForDisabledButto(objWWW124)
          strImage.set(include.WWWConst.$$$WWW124ImageFileForDisabledButto(m$,objWWW124));
        }
        //<< } else {
        else {
          //<< set strImage = $$Name^WWWIMAGE(strImage,$$$YES)
          strImage.set(m$.fnc$("WWWIMAGE.Name",strImage.get(),include.COMSYS.$$$YES(m$)));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strImage
    return strImage.get();
  }

  //<< 
  //<< 
  //<< GetButtonDescription(pidForm,pidLang,pidButton)
  public Object GetButtonDescription(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidButton = m$.newVarRef("pidButton",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Works out the title description of the button to be displayed in the tooltip.
    //<< ; If the button calls another form gets the form header or image file, if not
    //<< ; get the button description in ^WWW124.
    //<< ;
    //<< ; Called By: ^WWWFORMC, BUTTON^WWWHELP
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:  Button description
    //<< ;
    //<< ; History:
    //<< ; 13-Jul-2009   GRF     SR16691: obj variable
    //<< ; 10-Jul-2007   RPW     SRBR014589: Coding standards
    //<< ; 27-Jun-2007   Karine  SRBR014535: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objButton,strTitle
    mVar objButton = m$.var("objButton");
    mVar strTitle = m$.var("strTitle");
    m$.newVar(objButton,strTitle);
    //<< 
    //<< set objButton = $get(^WWW124(0,pidForm,pidLang,pidButton,1))
    objButton.set(m$.Fnc.$get(m$.var("^WWW124",0,pidForm.get(),pidLang.get(),pidButton.get(),1)));
    //<< 
    //<< if (pidForm'="") && (pidLang'="") && (pidButton'="") {     ; FIXME : we will have already crashed in the previous line - unnecessary? <GRF>
    if ((mOp.NotEqual(pidForm.get(),"")) && (mOp.NotEqual(pidLang.get(),"")) && (mOp.NotEqual(pidButton.get(),""))) {
      //<< if $$$WWW124NewFormOnClick(objButton)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW124NewFormOnClick(m$,objButton),"")) {
        //<< set strTitle = $$^WWWFORMNAME($$$WWW124NewFormOnClick(objButton))
        strTitle.set(m$.fnc$("WWWFORMNAME.main",include.WWWConst.$$$WWW124NewFormOnClick(m$,objButton)));
      }
      //<< } else {
      else {
        //<< set strTitle = $$$WWW124ButtonDescription(objButton)
        strTitle.set(include.WWWConst.$$$WWW124ButtonDescription(m$,objButton));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; set "form header + (form name)" for sysadmin users
    //<< if $get(YBEDBER)=1 {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YBEDBER")),1)) {
      //<< set strTitle = strTitle_" ("_$$$WWW124NewFormOnClick(objButton)_$$$WWW124ExecuteOnClick(objButton)_")"
      strTitle.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strTitle.get()," ("),include.WWWConst.$$$WWW124NewFormOnClick(m$,objButton)),include.WWWConst.$$$WWW124ExecuteOnClick(m$,objButton)),")"));
    }
    //<< }
    //<< 
    //<< quit strTitle
    return strTitle.get();
  }

//<< 
}
