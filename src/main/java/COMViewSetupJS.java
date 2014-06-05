//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewSetupJS
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 22:05:46
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include %occInclude
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;
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
//<< #include COMConst
import include.COMConst;

//<< COMFilterJS   ; Javascript files for COMViewSearch
public class COMViewSetupJS extends mClass {

  public void main() {
    COMFilterJS();
  }

  public void COMFilterJS() {
  }

  //<< 
  //<< Setup()
  public Object Setup(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Writes the static javascript out to the screen.
    //<< ; Note. This code may be pushed out to an external file at some point.
    //<< ;
    //<< ; History:
    //<< ; 10-Feb-2005   PO      SR10965 JS moved out into separate routines.
    //<< ; 30-Nov-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< do Setup^COMViewSetupJS1()
    m$.Cmd.Do("COMViewSetupJS1.Setup");
    //<< do Setup^COMViewSetupJS2()
    m$.Cmd.Do("COMViewSetupJS2.Setup");
    //<< do Setup^COMViewSetupJS3()
    m$.Cmd.Do("COMViewSetupJS3.Setup");
    //<< do Setup^COMViewSetupJS4()
    m$.Cmd.Do("COMViewSetupJS4.Setup");
    //<< do Setup^COMViewStructure()
    m$.Cmd.Do("COMViewStructure.Setup");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< UpdateLanguageText()
  public Object UpdateLanguageText(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update any language texts found in COMView Javascript.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 14-Jul-2005   shobby  SR12754 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrCodes,idCode,objCVLangCode,strCheckSum,strLangCodes
    mVar arrCodes = m$.var("arrCodes");
    mVar idCode = m$.var("idCode");
    mVar objCVLangCode = m$.var("objCVLangCode");
    mVar strCheckSum = m$.var("strCheckSum");
    mVar strLangCodes = m$.var("strLangCodes");
    m$.newVar(arrCodes,idCode,objCVLangCode,strCheckSum,strLangCodes);
    //<< 
    //<< set strCheckSum   = ""
    strCheckSum.set("");
    //<< set objCVLangCode = $get(^COMViewLanguageCode(0,1,1))
    objCVLangCode.set(m$.Fnc.$get(m$.var("^COMViewLanguageCode",0,1,1)));
    //<< set strLangCodes  = ""
    strLangCodes.set("");
    //<< do CheckForLanguageText("COMViewSetupJS1",.arrCodes)
    m$.Cmd.Do("CheckForLanguageText","COMViewSetupJS1",arrCodes);
    //<< do CheckForLanguageText("COMViewSetupJS2",.arrCodes)
    m$.Cmd.Do("CheckForLanguageText","COMViewSetupJS2",arrCodes);
    //<< do CheckForLanguageText("COMViewSetupJS3",.arrCodes)
    m$.Cmd.Do("CheckForLanguageText","COMViewSetupJS3",arrCodes);
    //<< do CheckForLanguageText("COMViewSetupJS4",.arrCodes)
    m$.Cmd.Do("CheckForLanguageText","COMViewSetupJS4",arrCodes);
    //<< do CheckForLanguageText("COMViewStructure",.arrCodes)
    m$.Cmd.Do("CheckForLanguageText","COMViewStructure",arrCodes);
    //<< do CheckForLanguageText("COMViewSetupJSGroup",.arrCodes)
    m$.Cmd.Do("CheckForLanguageText","COMViewSetupJSGroup",arrCodes);
    //<< set idCode=""
    idCode.set("");
    //<< for {
    for (;true;) {
      //<< set idCode=$order(arrCodes(idCode))
      idCode.set(m$.Fnc.$order(arrCodes.var(idCode.get())));
      //<< quit:idCode=""
      if (mOp.Equal(idCode.get(),"")) {
        break;
      }
      //<< 
      //<< set strLangCodes = strLangCodes_idCode_";"
      strLangCodes.set(mOp.Concat(mOp.Concat(strLangCodes.get(),idCode.get()),";"));
    }
    //<< }
    //<< set $$$COMViewLanguageCodeCodes(objCVLangCode) = strLangCodes
    include.COMConst.$$$COMViewLanguageCodeCodesSet(m$,objCVLangCode,strLangCodes.get());
    //<< do Save^COMUtils("COMViewLanguageCode",1,objCVLangCode,$$$YES)
    m$.Cmd.Do("COMUtils.Save","COMViewLanguageCode",1,objCVLangCode.get(),include.COMSYS.$$$YES(m$));
    //<< set strCheckSum = $$SetCheckSum^COMViewDCM(SPRACHE,$$$COMViewLanguageCodeCodes(objCVLangCode))
    strCheckSum.set(m$.fnc$("COMViewDCM.SetCheckSum",m$.var("SPRACHE").get(),include.COMConst.$$$COMViewLanguageCodeCodes(m$,objCVLangCode)));
    //<< quit strCheckSum
    return strCheckSum.get();
  }

  //<< 
  //<< 
  //<< CheckForLanguageText(pstrRoutine,parrCodes)
  public Object CheckForLanguageText(Object ... _p) {
    mVar pstrRoutine = m$.newVarRef("pstrRoutine",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar parrCodes = m$.newVarRef("parrCodes",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Looks through the routine to find if there are any language texts that need translating.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Jul-2005   shobby  SR12754 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLine,objLine,strPiece
    mVar idLine = m$.var("idLine");
    mVar objLine = m$.var("objLine");
    mVar strPiece = m$.var("strPiece");
    m$.newVar(idLine,objLine,strPiece);
    //<< 
    //<< set idLine = ""
    idLine.set("");
    //<< for {
    for (;true;) {
      //<< set idLine = $order(^rMAC(pstrRoutine,0,idLine))
      idLine.set(m$.Fnc.$order(m$.var("^rMAC",pstrRoutine.get(),0,idLine.get())));
      //<< quit:idLine=""
      if (mOp.Equal(idLine.get(),"")) {
        break;
      }
      //<< 
      //<< set objLine = $get(^rMAC(pstrRoutine,0,idLine))
      objLine.set(m$.Fnc.$get(m$.var("^rMAC",pstrRoutine.get(),0,idLine.get())));
      //<< for {      ; FIXME : What about $$$Text($listbuild("Message#",value))?
      for (;true;) {
        //<< set objLine = $piece(objLine,"$$$Text(""",2,99)
        objLine.set(m$.Fnc.$piece(objLine.get(),"$$$Text(\"",2,99));
        //<< quit:objLine=""
        if (mOp.Equal(objLine.get(),"")) {
          break;
        }
        //<< 
        //<< if $find(objLine,"""")>0 {
        if (mOp.Greater(m$.Fnc.$find(objLine.get(),"\""),0)) {
          //<< set strPiece = $piece(objLine,"""",1)
          strPiece.set(m$.Fnc.$piece(objLine.get(),"\"",1));
          //<< set parrCodes(strPiece) = ""
          parrCodes.var(strPiece.get()).set("");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< LookAtFile(pstrFile)
  public Object LookAtFile(Object ... _p) {
    mVar pstrFile = m$.newVarRef("pstrFile",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Looks through the file.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Jul-2005   shobby  Not Used.  ******   Leave here as an example of how to read a file.
    //<< ; 13-Jul-2005   shobby  SR12754 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new ipio,io,objCompany,objFile,strLine
    mVar ipio = m$.var("ipio");
    mVar io = m$.var("io");
    mVar objCompany = m$.var("objCompany");
    mVar objFile = m$.var("objFile");
    mVar strLine = m$.var("strLine");
    m$.newVar(ipio,io,objCompany,objFile,strLine);
    //<< 
    //<< set objCompany = $get(^WWW012(0,YM,1))
    objCompany.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< set io      = ##Class(%File).NormalizeDirectory($$$WWW012PhysicalWWWDirectory(objCompany))_pstrFile
    io.set(mOp.Concat(m$.fnc$("$File.NormalizeDirectory",include.WWWConst.$$$WWW012PhysicalWWWDirectory(m$,objCompany)),pstrFile.get()));
    //<< set objFile = ##class(%Library.FileCharacterStream).%New()
    objFile.set(m$.fnc$("$Library.FileCharacterStream.$New"));
    //<< if objFile'=$$$NULLOREF {
    if (mOp.NotEqual(objFile.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< set objFile.Filename = io
      m$.prop(objFile.get(),"Filename").set(io.get());
      //<< while 'objFile.AtEnd {
      while (mOp.Not(m$.prop(objFile.get(),"AtEnd").get())) {
        //<< set strLine = objFile.ReadLine()
        strLine.set(m$.fnc$(objFile.getORef(),"ReadLine"));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

//<< 
//<< 
}
