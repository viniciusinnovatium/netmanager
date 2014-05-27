//*****************************************************************************
//** TASC - ALPHALINC - MAC VARWWW101
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:30
//*****************************************************************************

import mLibrary.*;

//<< #include COMConst
import include.COMConst;
import include.COMSYS;
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

//<< VARWWW001
public class VARWWW101 extends mClass {

  public void main() {
    VARWWW001();
  }

  public void VARWWW001() {
  }

  //<< 
  //<< OnBeforeDataAccess(YKEY,YFELD,YFORM,YDATEI)
  public Object OnBeforeDataAccess(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< new objWWW101,blnShow
    mVar objWWW101 = m$.var("objWWW101");
    mVar blnShow = m$.var("blnShow");
    m$.newVar(objWWW101,blnShow);
    //<< 
    //<< set blnShow=$$$NO
    blnShow.set(include.COMSYS.$$$NO(m$));
    //<< if $$$KEY1(YKEY)="EINHEIT" {
    if (mOp.Equal(include.COMSYSWWW.$$$KEY1(m$,YKEY),"EINHEIT")) {
      //<< set objWWW101=$get(^WWW101(0,$$$KEY1(YKEY),$$$KEY2(YKEY),$$$KEY3(YKEY),1))
      objWWW101.set(m$.Fnc.$get(m$.var("^WWW101",0,include.COMSYSWWW.$$$KEY1(m$,YKEY),include.COMSYSWWW.$$$KEY2(m$,YKEY),include.COMSYSWWW.$$$KEY3(m$,YKEY),1)));
      //<< set blnShow=objWWW101["c"
      blnShow.set(mOp.Contains(objWWW101.get(),"c"));
    }
    //<< }
    //<< quit blnShow
    return blnShow.get();
  }

  //<< 
  //<< OnBeforeDataAccess1(YFORM="",YKEY="",YFELD="")
  public Object OnBeforeDataAccess1(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if $$$KEY1(YKEY)="EINHEIT" {
    if (mOp.Equal(include.COMSYSWWW.$$$KEY1(m$,YKEY),"EINHEIT")) {
      //<< if ('$$GetAtivo^VARParametroAtivarTabela("WWW101",$$$KEY1(YKEY),$$$KEY3(YKEY))) {
      if ((mOp.Not(m$.fnc$("VARParametroAtivarTabela.GetAtivo","WWW101",include.COMSYSWWW.$$$KEY1(m$,YKEY),include.COMSYSWWW.$$$KEY3(m$,YKEY))))) {
        //<< set strStatus = $$$NO
        strStatus.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
}
