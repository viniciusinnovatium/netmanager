//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW012
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:30
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

//<< WWW012
public class WWW012 extends mClass {

  public void main() {
    _WWW012();
  }

  public void _WWW012() {
  }

  //<< 
  //<< WelcomeMessage(SPRACHE)
  public Object WelcomeMessage(Object ... _p) {
    mVar SPRACHE = m$.newVarRef("SPRACHE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets the welcome message
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 24-Nov-2010   shobby      SR17247: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW012,strMessage
    mVar objWWW012 = m$.var("objWWW012");
    mVar strMessage = m$.var("strMessage");
    m$.newVar(objWWW012,strMessage);
    //<< 
    //<< set objWWW012 = $get(^WWW012(0,0,1))
    objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
    //<< if $$$WWW012WelcomeMessage(objWWW012)'="" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW012WelcomeMessage(m$,objWWW012),"")) {
      //<< set strMessage = $$$Text($listbuild($$$WWW012WelcomeMessage(objWWW012),$$$WWW012CompanyName(objWWW012)))
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild(include.WWWConst.$$$WWW012WelcomeMessage(m$,objWWW012),include.WWWConst.$$$WWW012CompanyName(m$,objWWW012))));
    }
    //<< 
    //<< } else {
    else {
      //<< set strMessage = $$$Text($listbuild("413",$$$WWW012CompanyName(objWWW012)),,SPRACHE)
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("413",include.WWWConst.$$$WWW012CompanyName(m$,objWWW012)),null,SPRACHE));
    }
    //<< } ; "Welcome to %1"
    //<< quit strMessage
    return strMessage.get();
  }

  //<< 
  //<< FullScreenHeaderImage()
  public Object FullScreenHeaderImage(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 05-Sep-2012   shobby      SR18104: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW012,strImage
    mVar objWWW012 = m$.var("objWWW012");
    mVar strImage = m$.var("strImage");
    m$.newVar(objWWW012,strImage);
    //<< 
    //<< set objWWW012=$get(^WWW012(0,YM,1))
    objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< set strImage=$$$WWW012FullScreenHeaderImage(objWWW012)
    strImage.set(include.WWWConst.$$$WWW012FullScreenHeaderImage(m$,objWWW012));
    //<< if strImage="" set strImage="COMtopleft.gif"
    if (mOp.Equal(strImage.get(),"")) {
      strImage.set("COMtopleft.gif");
    }
    //<< quit strImage
    return strImage.get();
  }

  //<< 
  //<< 
  //<< LoginImage()
  public Object LoginImage(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Sep-2012   shobby      SR18106: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW012,strImage
    mVar objWWW012 = m$.var("objWWW012");
    mVar strImage = m$.var("strImage");
    m$.newVar(objWWW012,strImage);
    //<< 
    //<< set objWWW012=$get(^WWW012(0,YM,1))
    objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< set strImage=$$$WWW012LoginImage(objWWW012)
    strImage.set(include.WWWConst.$$$WWW012LoginImage(m$,objWWW012));
    //<< if strImage="" set strImage="elem4.gif"
    if (mOp.Equal(strImage.get(),"")) {
      strImage.set("elem4.gif");
    }
    //<< quit strImage
    return strImage.get();
  }

  //<< 
  //<< 
  //<< GetMaxSelectRecords()
  public Object GetMaxSelectRecords(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 05-Dec-2006   JW      SR???: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intMax
    mVar intMax = m$.var("intMax");
    m$.newVar(intMax);
    //<< 
    //<< set intMax = $$$WWW012MaximumNumberOfRecordsOnS($get(^WWW012(0,0,1)))
    intMax.set(include.WWWConst.$$$WWW012MaximumNumberOfRecordsOnS(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))));
    //<< 
    //<< if (intMax<0) || (intMax="") || (intMax>100) {
    if ((mOp.Less(intMax.get(),0)) || (mOp.Equal(intMax.get(),"")) || (mOp.Greater(intMax.get(),100))) {
      //<< set intMax = 100
      intMax.set(100);
    }
    //<< }
    //<< quit intMax
    return intMax.get();
  }

  //<< 
  //<< 
  //<< ModificationLogRetention(pYM) ;BR014891
  public Object ModificationLogRetention(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$$WWW012ModificationLogRetention($get(^WWW012(0,pYM,1)))
    return include.WWWConst.$$$WWW012ModificationLogRetention(m$,m$.Fnc.$get(m$.var("^WWW012",0,pYM.get(),1)));
  }

  //<< 
  //<< 
  //<< FontFace(pYM)
  public Object FontFace(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the FontFace setting
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 01-Sep-2008   shobby  SRBR014976: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intFont
    mVar intFont = m$.var("intFont");
    m$.newVar(intFont);
    //<< 
    //<< if $get(pYM)="" set pYM = $get(YM,0)
    if (mOp.Equal(m$.Fnc.$get(pYM),"")) {
      pYM.set(m$.Fnc.$get(m$.var("YM"),0));
    }
    //<< set intFont = $$$WWW012FontFace($get(^WWW012(0,pYM,1)))
    intFont.set(include.WWWConst.$$$WWW012FontFace(m$,m$.Fnc.$get(m$.var("^WWW012",0,pYM.get(),1))));
    //<< quit $$$SysEnum("SCHRIFTART",intFont)
    return include.COMSYSWWW.$$$SysEnum(m$,"SCHRIFTART",intFont);
  }

  //<< 
  //<< 
  //<< OnBeforeSave(&YFELD)
  public Object OnBeforeSave(Object ... _p) {
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Process before Save - files are rebuilt if not found - character set should
    //<< ; not be changing once set as a rule so little impact on live system.
    //<< ;
    //<< ; Params: YFELD (ByRef) onscreen copy of objWWW012 (?)
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Aug-2011   shobby  SR17873: Moved block of code to COMUpgradeHandler
    //<< ; 22-Sep-2009   shobby  SR16894: Remove javascript files when there has been a
    //<< ;                           change in character set.
    //<< ; 10-Jan-2008   FIS     SR15619: set "framed form" in WWW012 always to YES
    //<< ;-------------------------------------------------------------------------------
    //<< new idLanguage,strDirectory,strStatus
    mVar idLanguage = m$.var("idLanguage");
    mVar strDirectory = m$.var("strDirectory");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idLanguage,strDirectory,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if $$$WWW012FormsFramed(YFELD)'=$$$YES {
    if (mOp.NotEqual(include.WWWConst.$$$WWW012FormsFramed(m$,YFELD),include.COMSYS.$$$YES(m$))) {
      //<< set $$$WWW012FormsFramed(YFELD) = $$$YES
      include.WWWConst.$$$WWW012FormsFramedSet(m$,YFELD,include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< if $$$WWW012CharacterSet(YFELD)'=$$$WWW012CharacterSet($get(^WWW012(0,0,1))) {
    if (mOp.NotEqual(include.WWWConst.$$$WWW012CharacterSet(m$,YFELD),include.WWWConst.$$$WWW012CharacterSet(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))))) {
      //<< set strStatus=$$DeleteJSFiles^COMUpgradeHandler()       ;SR17873
      strStatus.set(m$.fnc$("COMUpgradeHandler.DeleteJSFiles"));
    }
    //<< ;SR17873 set strDirectory = ##Class(%File).NormalizeDirectory($$$WWW012PhysicalWWWDirectory(YFELD))
    //<< ;SR17873 set strStatus    = $$Delete^COMDistOut6(strDirectory_"COMView"_YKEY_".css")
    //<< ;SR17873 if $$$ISOK(strStatus) set strStatus = $$Delete^COMDistOut6(strDirectory_"griden1.js")
    //<< ;SR17873 if $$$ISOK(strStatus) set strStatus = $$Delete^COMDistOut6(strDirectory_"GridEdit.css")
    //<< ;SR17873 set idLanguage = ""
    //<< ;SR17873 for {
    //<< ;SR17873    set idLanguage = $order(^WWW100(0,"SPRACHE",idLanguage))
    //<< ;SR17873    quit:idLanguage=""
    //<< ;SR17873
    //<< ;SR17873    if $$$ISOK(strStatus) set strStatus = $$Delete^COMDistOut6(strDirectory_"COMView"_idLanguage_"_"_YKEY_".js")
    //<< ;SR17873 }
    //<< }
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
      //<< set Q = $$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< Get(pYM) ; 19-Jan-1011 - no calls found to this tag - use $get(^WWW012(0,0,1)) directly
  public Object Get(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 19-Jan-2011   GRF     -: remove unneeded $data and set to null
    //<< ; 22-Dec-2008   HQN     SR16255: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW012
    mVar objWWW012 = m$.var("objWWW012");
    m$.newVar(objWWW012);
    //<< 
    //<< set objWWW012 = $get(^WWW012(0,pYM,1))
    objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,pYM.get(),1)));
    //<< quit objWWW012
    return objWWW012.get();
  }

  //<< 
  //<< 
  //<< SimulateCommainPrimaryKey(pYM=0)
  public Object SimulateCommainPrimaryKey(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Simulate Comma *in* Primary Key  ; FIXME : Rename for clarification
    //<< ;
    //<< ; History:
    //<< ; 10-Feb-2009   shobby  SR16126: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit +$$$WWW012SimulateCommainPrimaryKey($get(^WWW012(0,pYM,1)))
    return mOp.Positive(include.WWWConst.$$$WWW012SimulateCommainPrimaryKey(m$,m$.Fnc.$get(m$.var("^WWW012",0,pYM.get(),1))));
  }

  //<< 
  //<< 
  //<< CoolbarBackgroundColor(pYM=0)
  public Object CoolbarBackgroundColor(Object ... _p) {
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 20-Apr-2009   shobby  SR16455: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intColor
    mVar intColor = m$.var("intColor");
    m$.newVar(intColor);
    //<< 
    //<< set intColor = $$$WWW012CoolbarBackgroundColor($get(^WWW012(0,pYM,1)))
    intColor.set(include.WWWConst.$$$WWW012CoolbarBackgroundColor(m$,m$.Fnc.$get(m$.var("^WWW012",0,pYM.get(),1))));
    //<< if intColor=""  set intColor = $$$WWW012BackgroundColor($get(^WWW012(0,pYM,1)))
    if (mOp.Equal(intColor.get(),"")) {
      intColor.set(include.WWWConst.$$$WWW012BackgroundColor(m$,m$.Fnc.$get(m$.var("^WWW012",0,pYM.get(),1))));
    }
    //<< if intColor'="" set intColor = $$$SysEnum("FARBE",intColor)
    if (mOp.NotEqual(intColor.get(),"")) {
      intColor.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",intColor));
    }
    //<< quit intColor
    return intColor.get();
  }

  //<< 
  //<< HideRelationClassIDs() ;SR17840
  public Object HideRelationClassIDs(Object ... _p) {
    //<< quit +$$$WWW012HideRelationClassIDs($get(^WWW012(0,YM,1)))
    return mOp.Positive(include.WWWConst.$$$WWW012HideRelationClassIDs(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))));
  }

  //<< 
  //<< FixedColumns() ;CORE-254
  public Object FixedColumns(Object ... _p) {
    //<< quit +$$$WWW012FixedColumns($get(^WWW012(0,YM,1)))
    return mOp.Positive(include.WWWConst.$$$WWW012FixedColumns(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))));
  }

//<< 
//<< 
}
