//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW100
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:03
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
//<< #include COMConst
import include.COMConst;
//<< ;SR17807
//<< #include INConst
import include.INConst;

//<< WWW100
public class WWW100 extends mClass {

  public void main() {
    _WWW100();
  }

  public void _WWW100() {
  }

  //<< 
  //<< OnBeforeDataAccess()
  public Object OnBeforeDataAccess(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check standard buttons in WWW120 and show changes in WWW120D
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; History:
    //<< ; 21-Oct-2009   shobby  SRBR016969: Don't show the 17-Grid layout button if this
    //<< ;                           is not a grid form.
    //<< ; 07-Apr-2008   shobby  SRBR014446: corrected previous change on form
    //<< ;                           customising. (WWW120D)
    //<< ; 25-Feb-2007   shobby  SRBR014446: Only display 'Export To Excel' button on
    //<< ;                           'Edit Grid' forms.
    //<< ; 11-Dez-2007   GM      SRBR014601: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW120,strStatus
    mVar objWWW120 = m$.var("objWWW120");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objWWW120,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if $$$KEY1(YKEY)="BUTTON" {
    if (mOp.Equal(include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEY")),"BUTTON")) {
      //<< if ($get(YFORM)="WWW120") || ($get(YFORM)="WWW120D") {
      if ((mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"WWW120")) || (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"WWW120D"))) {
        //<< if $get(YKEYCONTAINER)'="" {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEYCONTAINER")),"")) {
          //<< set objWWW120 = $get(^WWW120(0,$$$KEY1(YKEYCONTAINER),1))
          objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEYCONTAINER")),1)));
          //<< if ($$$WWW120FormType(objWWW120)'=12)         &&
          //<< (($$$KEY3(YKEY)=16) || ($$$KEY3(YKEY)=17))    {
          if ((mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,objWWW120),12)) && mOp.Logical(((mOp.Equal(include.COMSYSWWW.$$$KEY3(m$,m$.var("YKEY")),16)) || (mOp.Equal(include.COMSYSWWW.$$$KEY3(m$,m$.var("YKEY")),17))))) {
            //<< ; 16-Export To Excel
            //<< ; 17-Grid Layout
            //<< ; do this test for both form types (07-Apr-2008)
            //<< 
            //<< set strStatus='$$$OK
            strStatus.set(mOp.Not(include.COMSYS.$$$OK(m$)));
          }
          //<< 
          //<< } elseif $get(YFORM)="WWW120D"  {
          else if (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"WWW120D")) {
            //<< set strStatus = ((";"_$$$WWW120DoNOTDisplayStandardButto(objWWW120)_";")'[(";"_$$$KEY3(YKEY)_";"))
            strStatus.set((mOp.NotContains((mOp.Concat(mOp.Concat(";",include.WWWConst.$$$WWW120DoNOTDisplayStandardButto(m$,objWWW120)),";")),(mOp.Concat(mOp.Concat(";",include.COMSYSWWW.$$$KEY3(m$,m$.var("YKEY"))),";")))));
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
  //<< GetFormat(pstrValue,pstrDefaultValue="",pSPRACHE="")
  public Object GetFormat(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrDefaultValue = m$.newVarRef("pstrDefaultValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pSPRACHE = m$.newVarRef("pSPRACHE",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check if "FELDFORMAT" parameter exists in INPARA, WWW101 and WWW100 classes.
    //<< ;
    //<< ; Params: pstrValue         : The value we're after (assumed to be non-null)
    //<< ;         pstrDefaultValue  : The default value
    //<< ;
    //<< ; Note: Required when patching SR17724 to 1.70-1.72
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: strFormat
    //<< ;           e.g. for date     MM/DD/AAAA, TT.MM.YYYY, DD-MM-YYYY, YYYYMMDD, etc.
    //<< ;                for numbers  NN,NNN.NN   or NN.NNN,NN
    //<< ;
    //<< ; History:
    //<< ; 20-Jul-2011   shobby  SR17807: Moved from INPARA
    //<< ; 27-Aug-2007   shobby  SR13729: Only default pSPRACHE to SPRACHE if it is not
    //<< ;                           passed in as a parameter.
    //<< ; 23-Aug-2007   GM      SR13729: Included "pSPRACHE" parameter
    //<< ; 20-Aug-2007   GM      SR13729: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objINPARA,objWWW100,objWWW101,strFormat
    mVar objINPARA = m$.var("objINPARA");
    mVar objWWW100 = m$.var("objWWW100");
    mVar objWWW101 = m$.var("objWWW101");
    mVar strFormat = m$.var("strFormat");
    m$.newVar(objINPARA,objWWW100,objWWW101,strFormat);
    //<< 
    //<< set strFormat = ""
    strFormat.set("");
    //<< if pSPRACHE="" set pSPRACHE = $get(SPRACHE)
    if (mOp.Equal(pSPRACHE.get(),"")) {
      pSPRACHE.set(m$.Fnc.$get(m$.var("SPRACHE")));
    }
    //<< 
    //<< if (pSPRACHE'="") {
    if ((mOp.NotEqual(pSPRACHE.get(),""))) {
      //<< if $get(YM)'="" {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YM")),"")) {
        //<< set objINPARA = $get(^INPARA(YM,"FELDFORMAT",pSPRACHE,pstrValue,1))
        objINPARA.set(m$.Fnc.$get(m$.var("^INPARA",m$.var("YM").get(),"FELDFORMAT",pSPRACHE.get(),pstrValue.get(),1)));
        //<< set strFormat = $$$INPARAText(objINPARA)
        strFormat.set(include.INConst.$$$INPARAText(m$,objINPARA));
      }
      //<< }
      //<< if strFormat="" {
      if (mOp.Equal(strFormat.get(),"")) {
        //<< set objWWW101 = $get(^WWW101(0,"FELDFORMAT",pSPRACHE,pstrValue,1))
        objWWW101.set(m$.Fnc.$get(m$.var("^WWW101",0,"FELDFORMAT",pSPRACHE.get(),pstrValue.get(),1)));
        //<< set strFormat = $$$WWW101Text(objWWW101)
        strFormat.set(include.WWWConst.$$$WWW101Text(m$,objWWW101));
      }
      //<< }
      //<< if strFormat="" {
      if (mOp.Equal(strFormat.get(),"")) {
        //<< set objWWW100 = $get(^WWW100(0,"FELDFORMAT",pSPRACHE,pstrValue,1))
        objWWW100.set(m$.Fnc.$get(m$.var("^WWW100",0,"FELDFORMAT",pSPRACHE.get(),pstrValue.get(),1)));
        //<< set strFormat = $$$WWW100Text(objWWW100)
        strFormat.set(include.WWWConst.$$$WWW100Text(m$,objWWW100));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if strFormat="" {
    if (mOp.Equal(strFormat.get(),"")) {
      //<< set strFormat = pstrDefaultValue
      strFormat.set(pstrDefaultValue.get());
    }
    //<< }
    //<< quit strFormat
    return strFormat.get();
  }

//<< 
}
