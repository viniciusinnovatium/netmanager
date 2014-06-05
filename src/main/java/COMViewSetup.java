//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewSetup
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:12
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; Sets up screen for COM View Use.
//<< ;-------------------------------------------------------------------------------
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;
//<< #include COMConst
import include.COMConst;
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

//<< COMViewSetup
public class COMViewSetup extends mClass {

  public void main() {
    _COMViewSetup();
  }

  public void _COMViewSetup() {
  }

  //<< 
  //<< Setup()
  public Object Setup(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Aug-2006   JW      SR14763: Added YM to JS file. (Temp fix)
    //<< ; 15-Jul-2005   shobby  SR12754: Replaced LANGUAGE global (not always reliable)
    //<< ; 11-Feb-2005   PK & PO SR10965: Changed over to handle JS being sourced from
    //<< ;                           multiple routines.
    //<< ;-------------------------------------------------------------------------------
    //<< new dteDate,strLanguageCheckSum
    mVar dteDate = m$.var("dteDate");
    mVar strLanguageCheckSum = m$.var("strLanguageCheckSum");
    m$.newVar(dteDate,strLanguageCheckSum);
    //<< 
    //<< set dteDate = $get(^rMAC("COMViewSetupJS",0))
    dteDate.set(m$.Fnc.$get(m$.var("^rMAC","COMViewSetupJS",0)));
    //<< set dteDate = $$Max^COMUtilDate(dteDate,$get(^rMAC("COMViewSetupJS1",0)))
    dteDate.set(m$.fnc$("COMUtilDate.Max",dteDate.get(),m$.Fnc.$get(m$.var("^rMAC","COMViewSetupJS1",0))));
    //<< set dteDate = $$Max^COMUtilDate(dteDate,$get(^rMAC("COMViewSetupJS2",0)))
    dteDate.set(m$.fnc$("COMUtilDate.Max",dteDate.get(),m$.Fnc.$get(m$.var("^rMAC","COMViewSetupJS2",0))));
    //<< set dteDate = $$Max^COMUtilDate(dteDate,$get(^rMAC("COMViewSetupJS3",0)))
    dteDate.set(m$.fnc$("COMUtilDate.Max",dteDate.get(),m$.Fnc.$get(m$.var("^rMAC","COMViewSetupJS3",0))));
    //<< set dteDate = $$Max^COMUtilDate(dteDate,$get(^rMAC("COMViewSetupJS4",0)))
    dteDate.set(m$.fnc$("COMUtilDate.Max",dteDate.get(),m$.Fnc.$get(m$.var("^rMAC","COMViewSetupJS4",0))));
    //<< set dteDate = $$Max^COMUtilDate(dteDate,$get(^rMAC("COMViewStructure",0)))
    dteDate.set(m$.fnc$("COMUtilDate.Max",dteDate.get(),m$.Fnc.$get(m$.var("^rMAC","COMViewStructure",0))));
    //<< 
    //<< set strLanguageCheckSum = $$$COMViewLanguageTextText($get(^COMViewLanguageText(0,SPRACHE,1)))
    strLanguageCheckSum.set(include.COMConst.$$$COMViewLanguageTextText(m$,m$.Fnc.$get(m$.var("^COMViewLanguageText",0,m$.var("SPRACHE").get(),1))));
    //<< 
    //<< //do CreateFile("COMView"_SPRACHE,"do Setup^COMViewSetupJS()",$$$EnumCOMFILETYPEJavaScript,dteDate,strLanguageCheckSum)     SR14763
    //<< do CreateFile("COMView"_SPRACHE_"_"_YM,"do Setup^COMViewSetupJS()",$$$EnumCOMFILETYPEJavaScript,dteDate,strLanguageCheckSum)
    m$.Cmd.Do("CreateFile",mOp.Concat(mOp.Concat(mOp.Concat("COMView",m$.var("SPRACHE").get()),"_"),m$.var("YM").get()),"do Setup^COMViewSetupJS()",include.COMConst.$$$EnumCOMFILETYPEJavaScript(m$),dteDate.get(),strLanguageCheckSum.get());
    //<< do CreateFile("COMView"_YM,"do Setup^COMViewSetupStyle()",$$$EnumCOMFILETYPEStyleSheet,)
    m$.Cmd.Do("CreateFile",mOp.Concat("COMView",m$.var("YM").get()),"do Setup^COMViewSetupStyle()",include.COMConst.$$$EnumCOMFILETYPEStyleSheet(m$),null);
    //<< do Setup^COMViewSetupVB()
    m$.Cmd.Do("COMViewSetupVB.Setup");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateFile(pstrFile,pstrCodeToPopulate,pstrType=$$$EnumCOMFILETYPEJavaScript,pdteRefresh="",pstrLanguageText="")
  public Object CreateFile(Object ... _p) {
    mVar pstrFile = m$.newVarRef("pstrFile",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrCodeToPopulate = m$.newVarRef("pstrCodeToPopulate",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMConst.$$$EnumCOMFILETYPEJavaScript(m$));
    mVar pdteRefresh = m$.newVarRef("pdteRefresh",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pstrLanguageText = m$.newVarRef("pstrLanguageText",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Sets links to files in @Net screens, potentially refreshes the file if it is the incorrect age.
    //<< ;
    //<< ; History:
    //<< ; 17-Mar-2011   shobby  SR17249: put 16677 changes back in.
    //<< ; 10-Aug-2010   shobby  SR17489: As a result of SR17483, header lines of js/css files not
    //<< ;                           being interpreted correctly, leading to crash.
    //<< ; 02-Aug-2010   shobby  SR17483: Corrected invalid comment tag syntax.
    //<< ; 14-Oct-2009   GRF     SR16894: Clear old commented code
    //<< ; 22-Sep-2009   shobby  SR16894: When charset is UTF8 write the js files in UTF8.
    //<< ;                           Removed changes from 16677.
    //<< ; 26-Jun-2009   shobby  SR16677: Add iso charset direction to Script language
    //<< ; 02-Feb-2006   RPW     SR14093: Do not use !, it causes issues with Debugging this code!
    //<< ; 29-Aug-2005   sh/rw   SR13356:More robust handling of missing or incomplete js files.
    //<< ; 29-Aug-2005   shobby  SR13356:Put $get around strLanguageText
    //<< ; 14-Jul-2005   shobby  SR12754:Changes to determine if Language texts have changed.
    //<< ; 17-Jun-2005   RPW     Fixed status check so in line with coding standards, ie
    //<< ;                           $$$ISOK(strStatus), $$$ISERR(strStatus), $$$ISOK.
    //<< ;                           Also do not $$$Text a value that is already $$$Texted.
    //<< ; 01-Jun-2005   PK      Added Status to check for file able to be created.
    //<< ; 09-Mar-2005   PK      Added Fast file check
    //<< ; 09-Mar-2005   PK      Modifed to look at the first line of the file for a
    //<< ;                           modified date. (ST#11847) && SR#11850)
    //<< ;-------------------------------------------------------------------------------
    //<< new blnError,blnGenerate,io,ipio,objCompany,objConfig
    mVar blnError = m$.var("blnError");
    mVar blnGenerate = m$.var("blnGenerate");
    mVar io = m$.var("io");
    mVar ipio = m$.var("ipio");
    mVar objCompany = m$.var("objCompany");
    mVar objConfig = m$.var("objConfig");
    m$.newVar(blnError,blnGenerate,io,ipio,objCompany,objConfig);
    //<< new strDate,strEnd,strEnd1,strFile,strLanguageText,strMAC,strStart,strStart1,strStatus
    mVar strDate = m$.var("strDate");
    mVar strEnd = m$.var("strEnd");
    mVar strEnd1 = m$.var("strEnd1");
    mVar strFile = m$.var("strFile");
    mVar strLanguageText = m$.var("strLanguageText");
    mVar strMAC = m$.var("strMAC");
    mVar strStart = m$.var("strStart");
    mVar strStart1 = m$.var("strStart1");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strDate,strEnd,strEnd1,strFile,strLanguageText,strMAC,strStart,strStart1,strStatus);
    //<< 
    //<< set objConfig  = $get(^COMViewConfig(0,YM,1))
    objConfig.set(m$.Fnc.$get(m$.var("^COMViewConfig",0,m$.var("YM").get(),1)));
    //<< set objCompany = $get(^WWW012(0,YM,1))
    objCompany.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< set strStart   = ""
    strStart.set("");
    //<< set strMAC     = $piece($piece(pstrCodeToPopulate,"^",2),"(",1)
    strMAC.set(m$.Fnc.$piece(m$.Fnc.$piece(pstrCodeToPopulate.get(),"^",2),"(",1));
    //<< set strStatus  = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set pdteRefresh = $$Max^COMUtilDate(pdteRefresh,$get(^rMAC(strMAC,0)))
    pdteRefresh.set(m$.fnc$("COMUtilDate.Max",pdteRefresh.get(),m$.Fnc.$get(m$.var("^rMAC",strMAC.get(),0))));
    //<< set pdteRefresh = $$Max^COMUtilDate(pdteRefresh,$$$COMViewConfigModifiedDate(objConfig))
    pdteRefresh.set(m$.fnc$("COMUtilDate.Max",pdteRefresh.get(),include.COMConst.$$$COMViewConfigModifiedDate(m$,objConfig)));
    //<< 
    //<< if pstrType=$$$EnumCOMFILETYPEJavaScript {
    if (mOp.Equal(pstrType.get(),include.COMConst.$$$EnumCOMFILETYPEJavaScript(m$))) {
      //<< set pstrFile  = pstrFile_".js"
      pstrFile.set(mOp.Concat(pstrFile.get(),".js"));
      //<< set strStart="<script language=javascript charset='iso-8859-1' type='text/javascript' SRC="""_$$$WWW012PictureDirectorySystem(objCompany)_pstrFile_""">" ;SR17249
      strStart.set(mOp.Concat(mOp.Concat(mOp.Concat("<script language=javascript charset='iso-8859-1' type='text/javascript' SRC=\"",include.WWWConst.$$$WWW012PictureDirectorySystem(m$,objCompany)),pstrFile.get()),"\">"));
      //<< ;SR17249 set strStart  = "<script language=javascript type='text/javascript' SRC="""_$$$WWW012PictureDirectorySystem(objCompany)_pstrFile_""">"  ; SR16677
      //<< set strEnd    = "</script>"
      strEnd.set("</script>");
      //<< set strStart1 = "<script>"
      strStart1.set("<script>");
      //<< set strEnd1   = "</script>"
      strEnd1.set("</script>");
    }
    //<< 
    //<< } elseif pstrType=$$$EnumCOMFILETYPEStyleSheet {
    else if (mOp.Equal(pstrType.get(),include.COMConst.$$$EnumCOMFILETYPEStyleSheet(m$))) {
      //<< set pstrFile  = pstrFile_".css"
      pstrFile.set(mOp.Concat(pstrFile.get(),".css"));
      //<< set strStart  = "<LINK REL=""stylesheet"" TYPE=""text/css"" HREF="""_$$$WWW012PictureDirectorySystem(objCompany)_pstrFile_""">"
      strStart.set(mOp.Concat(mOp.Concat(mOp.Concat("<LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"",include.WWWConst.$$$WWW012PictureDirectorySystem(m$,objCompany)),pstrFile.get()),"\">"));
      //<< set strEnd    = ""
      strEnd.set("");
      //<< set strStart1 = "<style>"
      strStart1.set("<style>");
      //<< set strEnd1   = "</style>"
      strEnd1.set("</style>");
    }
    //<< 
    //<< } elseif pstrType=$$$EnumCOMFILETYPEVBScript {
    else if (mOp.Equal(pstrType.get(),include.COMConst.$$$EnumCOMFILETYPEVBScript(m$))) {
      //<< set pstrFile  = pstrFile_".vbs"
      pstrFile.set(mOp.Concat(pstrFile.get(),".vbs"));
      //<< set strStart  = "<script language=vbscript SRC="""_$$$WWW012PictureDirectorySystem(objCompany)_pstrFile_""">"
      strStart.set(mOp.Concat(mOp.Concat(mOp.Concat("<script language=vbscript SRC=\"",include.WWWConst.$$$WWW012PictureDirectorySystem(m$,objCompany)),pstrFile.get()),"\">"));
      //<< set strEnd    = "</script>"
      strEnd.set("</script>");
      //<< set strStart1 = "<script>"
      strStart1.set("<script>");
      //<< set strEnd1   = "</script>"
      strEnd1.set("</script>");
    }
    //<< }
    //<< 
    //<< if strStart'="" {
    if (mOp.NotEqual(strStart.get(),"")) {
      //<< if $$$COMViewConfigDevelopmentMode(objConfig) {
      if (mOp.Logical(include.COMConst.$$$COMViewConfigDevelopmentMode(m$,objConfig))) {
        //<< write YCR,strStart1,YCR
        m$.Cmd.Write(m$.var("YCR").get(),strStart1.get(),m$.var("YCR").get());
        //<< xecute pstrCodeToPopulate
        m$.Cmd.Xecute(pstrCodeToPopulate.get());
        //<< write strEnd1,YCR
        m$.Cmd.Write(strEnd1.get(),m$.var("YCR").get());
      }
      //<< 
      //<< } else {
      else {
        //<< write YCR,strStart,YCR
        m$.Cmd.Write(m$.var("YCR").get(),strStart.get(),m$.var("YCR").get());
        //<< 
        //<< set io = ##Class(%File).NormalizeDirectory($$$WWW012PhysicalWWWDirectory(objCompany))_pstrFile
        io.set(mOp.Concat(m$.fnc$("$File.NormalizeDirectory",include.WWWConst.$$$WWW012PhysicalWWWDirectory(m$,objCompany)),pstrFile.get()));
        //<< set blnGenerate = $$$NO
        blnGenerate.set(include.COMSYS.$$$NO(m$));
        //<< //
        //<< 
        //<< if '##Class(%Library.File).Exists(io) {
        if (mOp.Not(m$.fnc$("$Library.File.Exists",io.get()))) {
          //<< set blnGenerate     = $$$YES
          blnGenerate.set(include.COMSYS.$$$YES(m$));
          //<< set strLanguageText = $$UpdateLanguageText^COMViewSetupJS()
          strLanguageText.set(m$.fnc$("COMViewSetupJS.UpdateLanguageText"));
        }
        //<< 
        //<< } elseif $$$COMViewConfigFastFileCheck(objConfig) {
        else if (mOp.Logical(include.COMConst.$$$COMViewConfigFastFileCheck(m$,objConfig))) {
          //<< if $$$COMViewFileModifiedDate($get(^COMViewFile(0,io,1)))'=pdteRefresh set blnGenerate = $$$YES
          if (mOp.NotEqual(include.COMConst.$$$COMViewFileModifiedDate(m$,m$.Fnc.$get(m$.var("^COMViewFile",0,io.get(),1))),pdteRefresh.get())) {
            blnGenerate.set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< 
        //<< } else {
        else {
          //<< set ipio = $io
          ipio.set(m$.Fnc.$io());
          //<< open io:"rs":0
          m$.Cmd.Open(io.get(),"rs",0);
          //<< use io
          m$.Cmd.Use(io.get());
          //<< read strDate
          m$.Cmd.Read(strDate);
          //<< set strDate = $piece(strDate,": ",2)
          strDate.set(m$.Fnc.$piece(strDate.get(),": ",2));
          //<< set strDate = $$ConvertDate(strDate)
          strDate.set(m$.fnc$("ConvertDate",strDate.get()));
          //<< 
          //<< if strDate'=pdteRefresh {       // SR13913 - these are not matching
          if (mOp.NotEqual(strDate.get(),pdteRefresh.get())) {
            //<< set blnGenerate     = $$$YES
            blnGenerate.set(include.COMSYS.$$$YES(m$));
            //<< set strLanguageText = $$UpdateLanguageText^COMViewSetupJS()
            strLanguageText.set(m$.fnc$("COMViewSetupJS.UpdateLanguageText"));
            //<< if strLanguageText="" {
            if (mOp.Equal(strLanguageText.get(),"")) {
              //<< set strLanguageText = pstrLanguageText
              strLanguageText.set(pstrLanguageText.get());
            }
          }
          //<< }
          //<< }
          //<< if $get(strLanguageText)="" {
          if (mOp.Equal(m$.Fnc.$get(strLanguageText),"")) {
            //<< set blnError = $$ReadFile(.strLanguageText)
            blnError.set(m$.fnc$("ReadFile",strLanguageText));
            //<< if blnError {
            if (mOp.Logical(blnError.get())) {
              //<< set blnGenerate     = $$$YES
              blnGenerate.set(include.COMSYS.$$$YES(m$));
              //<< set strLanguageText = $$UpdateLanguageText^COMViewSetupJS()
              strLanguageText.set(m$.fnc$("COMViewSetupJS.UpdateLanguageText"));
            }
            //<< } else {
            else {
              //<< if ($piece(strLanguageText,": ",2)'=pstrLanguageText) && (pstrLanguageText'="") {
              if ((mOp.NotEqual(m$.Fnc.$piece(strLanguageText.get(),": ",2),pstrLanguageText.get())) && (mOp.NotEqual(pstrLanguageText.get(),""))) {
                //<< set blnGenerate     = $$$YES
                blnGenerate.set(include.COMSYS.$$$YES(m$));
                //<< set strLanguageText = pstrLanguageText
                strLanguageText.set(pstrLanguageText.get());
              }
            }
          }
          //<< }
          //<< }
          //<< }
          //<< use ipio
          m$.Cmd.Use(ipio.get());
          //<< close io
          m$.Cmd.Close(io.get());
        }
        //<< ;if YBED["SHOBBY" for l=1:1:2 hang 1 ;SR17669
        //<< }
        //<< 
        //<< if blnGenerate {
        if (mOp.Logical(blnGenerate.get())) {
          //<< set $$$COMViewFileModifiedDate(^COMViewFile(0,io,1)) = pdteRefresh
          include.COMConst.$$$COMViewFileModifiedDateSet(m$,m$.var("^COMViewFile",0,io.get(),1),pdteRefresh.get());
          //<< set ipio = $io
          ipio.set(m$.Fnc.$io());
          //<< ; SR16894 VVVV
          //<< 
          //<< if $$$WWW012CharacterSet(objCompany)=7 {  ;UTF8
          if (mOp.Equal(include.WWWConst.$$$WWW012CharacterSet(m$,objCompany),7)) {
            //<< //open io:("wns":/IOTABLE="UTF8"):1  else  set strStatus = $listbuild("Com00190",io)  ; "Unable to Create File %1. Check Setup."
            //<< open io:("wns":/IOTABLE="UTF8"):1
            m$.Cmd.Open(io.get(),"wns",mOp.Concat("/IOTABLE=","UTF8"),1);
            //<< if $test set strStatus = $listbuild("Com00190",io)  ; "Unable to Create File %1. Check Setup."
            if (mOp.Logical(m$.Fnc.$test())) {
              strStatus.set(m$.Fnc.$listbuild("Com00190",io.get()));
            }
          }
          //<< } else {
          else {
            //<< //open io:"wns":1  else  set strStatus = $listbuild("Com00190",io)  ; "Unable to Create File %1. Check Setup."
            //<< open io:"wns":1
            m$.Cmd.Open(io.get(),"wns",1);
            //<< if $test set strStatus = $listbuild("Com00190",io)  ; "Unable to Create File %1. Check Setup."
            if (mOp.Logical(m$.Fnc.$test())) {
              strStatus.set(m$.Fnc.$listbuild("Com00190",io.get()));
            }
          }
          //<< }
          //<< ; SR16894 ^^^^
          //<< if $$$ISOK(strStatus) {
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
            //<< use io
            m$.Cmd.Use(io.get());
            //<< write "/* Modified Date: "_$zdt(pdteRefresh,3)_": */"                   ;SR17483 ;SR17489
            m$.Cmd.Write(mOp.Concat(mOp.Concat("/* Modified Date: ",m$.Fnc.$zdatetime(pdteRefresh.get(),3)),": */"));
            //<< write $c(13,10)_"/* Modified Language: "_$get(strLanguageText)_": */"   ;SR17483 ;SR17489
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$char(13,10),"/* Modified Language: "),m$.Fnc.$get(strLanguageText)),": */"));
            //<< xecute pstrCodeToPopulate
            m$.Cmd.Xecute(pstrCodeToPopulate.get());
            //<< use ipio
            m$.Cmd.Use(ipio.get());
            //<< close io
            m$.Cmd.Close(io.get());
          }
        }
        //<< }
        //<< }
        //<< write strEnd,YCR
        m$.Cmd.Write(strEnd.get(),m$.var("YCR").get());
      }
    }
    //<< }
    //<< }
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< write "<br>"_$$$Text(strStatus)
      m$.Cmd.Write(mOp.Concat("<br>",include.COMSYS.$$$Text(m$,strStatus)));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ReadFile(pstrText="")
  public Object ReadFile(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< new blnError
    mVar blnError = m$.var("blnError");
    m$.newVar(blnError);
    //<< 
    //<< set blnError = $$$NO
    blnError.set(include.COMSYS.$$$NO(m$));
    //<< set $ztrap   = "ReadFileError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("ReadFileError");
    //<< read pstrText
    m$.Cmd.Read(pstrText);
    //<< quit blnError
    return blnError.get();
  }

  //<< 
  //<< ///ReadFileError ; Internal Tag
  //<< ReadFileError() ; Internal Tag
  public Object ReadFileError(Object ... _p) {
    //<< set $ztrap   = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< set blnError = $$$YES
    mVar blnError = m$.var("blnError");
    blnError.set(include.COMSYS.$$$YES(m$));
    //<< quit blnError
    return blnError.get();
  }

  //<< 
  //<< ConvertDate(pstrDate)
  public Object ConvertDate(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< set $ztrap   = "ConvertDateError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("ConvertDateError");
    //<< set pstrDate = $zdth(pstrDate,3)
    pstrDate.set(m$.Fnc.$zdatetimeh(pstrDate.get(),3));
    //<< quit pstrDate
    return pstrDate.get();
  }

  //<< 
  //<< ///ConvertDateError
  //<< ConvertDateError()
  public Object ConvertDateError(Object ... _p) {
    //<< set $ztrap = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< quit ""
    return "";
  }

//<< 
//<< 
}
