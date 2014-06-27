//*****************************************************************************
//** TASC - ALPHALINC - MAC VARPacienteAutorizacao
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 17:44:11
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

public class VARPacienteAutorizacao extends mClass {

  //<< 
  //<< VARPacienteAutorizacao
  public Object main() {
    _VARPacienteAutorizacao();
    return null;
  }

  public Object _VARPacienteAutorizacao() {
    //<< quit
    return null;
  }

  //<< 
  //<< OnBeforeSave
  public void OnBeforeSave() {
    //<< new CPF, strStatus
    mVar CPF = m$.var("CPF");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(CPF,strStatus);
    //<< 
    //<< set CPF = $piece(YFELD,Y,4)
    CPF.set(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),4));
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if (($find(CPF,".")'=5) || ($find(CPF,".",5)'=9) || ($find(CPF,"-")'=13) || ($length(CPF)'=14)) {
    if (mOp.Logical(((mOp.NotEqual(m$.Fnc.$find(CPF.get(),"."),5)) || (mOp.NotEqual(m$.Fnc.$find(CPF.get(),".",5),9)) || (mOp.NotEqual(m$.Fnc.$find(CPF.get(),"-"),13)) || (mOp.NotEqual(m$.Fnc.$length(CPF.get()),14))))) {
      //<< set strStatus = "O formato do CPF deve ser do tipo xxx.xxx.xxx-xx. Favor verificar."
      strStatus.set("O formato do CPF deve ser do tipo xxx.xxx.xxx-xx. Favor verificar.");
    }
    //<< }
    //<< //not ok strStatus
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set Q = $$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
      //<< do ^WWWINFO(strStatus)
      m$.Cmd.Do("WWWINFO.main",strStatus.get());
    }
    //<< }
    //<< 
    //<< quit
    return;
  }

//<< 
}
