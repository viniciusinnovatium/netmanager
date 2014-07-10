//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewCalculatedField
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-10 13:08:00
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< COMViewCalculatedField
public class COMViewCalculatedField extends mClass {

  public void main() {
    _COMViewCalculatedField();
  }

  public void _COMViewCalculatedField() {
  }

  //<< 
  //<< GetDescription(pidClass,pidField,pstrLanguage="EN")
  public Object GetDescription(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrLanguage = m$.newVarRef("pstrLanguage",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"EN");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets the description of the Calculated Field
    //<< ;
    //<< ; History:
    //<< ; 11-Nov-2008   shobby      SR16132:    Corrected variable usage of pidField
    //<< ; 23-Jun-2008   shobby      BR014958:   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strDescription,objWWW003Calc
    mVar strDescription = m$.var("strDescription");
    mVar objWWW003Calc = m$.var("objWWW003Calc");
    m$.newVar(strDescription,objWWW003Calc);
    //<< 
    //<< set strDescription=$$$WWW003CalcLangDescription($get(^WWW003CalcLang(0,pidClass,pidField,pstrLanguage,1)))
    strDescription.set(include.WWWConst.$$$WWW003CalcLangDescription(m$,m$.Fnc.$get(m$.var("^WWW003CalcLang",0,pidClass.get(),pidField.get(),pstrLanguage.get(),1))));
    //<< if strDescription="" {
    if (mOp.Equal(strDescription.get(),"")) {
      //<< set objWWW003Calc=$get(^WWW003Calc(0,pidClass,pidField,1)) ;16132
      objWWW003Calc.set(m$.Fnc.$get(m$.var("^WWW003Calc",0,pidClass.get(),pidField.get(),1)));
      //<< set strDescription=$$$WWW003CalcCaption(objWWW003Calc)
      strDescription.set(include.WWWConst.$$$WWW003CalcCaption(m$,objWWW003Calc));
      //<< if strDescription="" set strDescription=$$$WWW003CalcFieldName(objWWW003Calc)
      if (mOp.Equal(strDescription.get(),"")) {
        strDescription.set(include.WWWConst.$$$WWW003CalcFieldName(m$,objWWW003Calc));
      }
    }
    //<< }
    //<< 
    //<< quit strDescription
    return strDescription.get();
  }

//<< 
}
