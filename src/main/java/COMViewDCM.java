//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewDCM
//** Innovatium Systems - Code Converter - v1.24
//** 2014-06-03 21:33:32
//*****************************************************************************

import mLibrary.*;

//<< #include COMConst
import include.COMConst;
import include.COMSYS;
//<< #include WWWConst
import include.WWWConst;
//import COMSYS;
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

//<< COMViewDCM
public class COMViewDCM extends mClass {

  public void main() {
    _COMViewDCM();
  }

  public void _COMViewDCM() {
  }

  //<< 
  //<< UpdateCOMViewLanguage(pstrLanguage,pstrKey="")
  public Object UpdateCOMViewLanguage(Object ... _p) {
    mVar pstrLanguage = m$.newVarRef("pstrLanguage",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; If the language text changed is a comview one then set the new checksum.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; Notes:
    //<< ;   Only one COMViewLanguageCodes record.
    //<< ;
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 07-Jul-2005   shobby  SR12754 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objCOMViewLanguageCode,idLanguage,idKey
    mVar objCOMViewLanguageCode = m$.var("objCOMViewLanguageCode");
    mVar idLanguage = m$.var("idLanguage");
    mVar idKey = m$.var("idKey");
    m$.newVar(objCOMViewLanguageCode,idLanguage,idKey);
    //<< 
    //<< set idLanguage = $$$KEY1(pstrKey)
    idLanguage.set(include.COMSYSWWW.$$$KEY1(m$,pstrKey));
    //<< set idKey      = $$$KEY2(pstrKey)
    idKey.set(include.COMSYSWWW.$$$KEY2(m$,pstrKey));
    //<< 
    //<< if (idLanguage'="") && (idKey'="") {
    if ((mOp.NotEqual(idLanguage.get(),"")) && (mOp.NotEqual(idKey.get(),""))) {
      //<< set objCOMViewLanguageCode = $get(^COMViewLanguageCode(0,1,1))
      objCOMViewLanguageCode.set(m$.Fnc.$get(m$.var("^COMViewLanguageCode",0,1,1)));
      //<< if $find(";"_$$$COMViewLanguageCodeCodes(objCOMViewLanguageCode)_";",";"_idKey_";")>0 {
      if (mOp.Greater(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",include.COMConst.$$$COMViewLanguageCodeCodes(m$,objCOMViewLanguageCode)),";"),mOp.Concat(mOp.Concat(";",idKey.get()),";")),0)) {
        //<< do SetCheckSum(idLanguage,$$$COMViewLanguageCodeCodes(objCOMViewLanguageCode))
        m$.Cmd.Do("SetCheckSum",idLanguage.get(),include.COMConst.$$$COMViewLanguageCodeCodes(m$,objCOMViewLanguageCode));
      }
    }
    //<< }
    //<< }
    //<< quit 1
    return 1;
  }

  //<< 
  //<< SetCheckSum(pidLanguage="",plstCodes="")
  public Object SetCheckSum(Object ... _p) {
    mVar pidLanguage = m$.newVarRef("pidLanguage",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar plstCodes = m$.newVarRef("plstCodes",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines a checksum for the language texts embedded in COMView
    //<< ;
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Oct-2009   shobby  SRAdhoc: COMViewLanguage text should not have two keys passed to Save.
    //<< ; 14-Oct-2009   GRF     SR16894: Key macros
    //<< ; 07-Jul-2005   shobby  SR12754 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strCheckSum,idText,i,objWWW009,objCOMViewLanguageText
    mVar strCheckSum = m$.var("strCheckSum");
    mVar idText = m$.var("idText");
    mVar i = m$.var("i");
    mVar objWWW009 = m$.var("objWWW009");
    mVar objCOMViewLanguageText = m$.var("objCOMViewLanguageText");
    m$.newVar(strCheckSum,idText,i,objWWW009,objCOMViewLanguageText);
    //<< 
    //<< set strCheckSum = ""
    strCheckSum.set("");
    //<< set objCOMViewLanguageText=""
    objCOMViewLanguageText.set("");
    //<< for i=1:1:$length(plstCodes,";") {
    for (i.set(1);(mOp.LessOrEqual(i.get(),m$.Fnc.$length(plstCodes.get(),";")));i.set(mOp.Add(i.get(),1))) {
      //<< set idText = $piece(plstCodes,";",i)
      idText.set(m$.Fnc.$piece(plstCodes.get(),";",i.get()));
      //<< if idText'="" {
      if (mOp.NotEqual(idText.get(),"")) {
        //<< set objWWW009   = $get(^WWW009(0,pidLanguage,idText,1))
        objWWW009.set(m$.Fnc.$get(m$.var("^WWW009",0,pidLanguage.get(),idText.get(),1)));
        //<< set strCheckSum = $zcrc(strCheckSum_idText_Y_objWWW009_";",7)
        strCheckSum.set(m$.Fnc.$zcrc(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strCheckSum.get(),idText.get()),m$.var("Y").get()),objWWW009.get()),";"),7));
        //<< set $$$COMViewLanguageTextText(objCOMViewLanguageText) = strCheckSum
        include.COMConst.$$$COMViewLanguageTextTextSet(m$,objCOMViewLanguageText,strCheckSum.get());
      }
    }
    //<< }
    //<< }
    //<< do Save^COMUtils("COMViewLanguageText",pidLanguage,objCOMViewLanguageText,1)
    m$.Cmd.Do("COMUtils.Save","COMViewLanguageText",pidLanguage.get(),objCOMViewLanguageText.get(),1);
    //<< quit strCheckSum
    return strCheckSum.get();
  }

//<< 
}
