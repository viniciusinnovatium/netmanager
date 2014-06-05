//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW120Hook
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:08
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWW120Hook
public class WWW120Hook extends mClass {

  public void main() {
    _WWW120Hook();
  }

  public void _WWW120Hook() {
  }

  //<< 
  //<< ExecuteHook(pidClass="",penumEvent,&YKEY="",&YFELD="",YFORM="",YFELDOLD="",YFIELDNAME="")
  public Object ExecuteHook(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar penumEvent = m$.newVarRef("penumEvent",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar YFELDOLD = m$.newVarRef("YFELDOLD",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    mVar YFIELDNAME = m$.newVarRef("YFIELDNAME",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks if a Hook exists for a given form/event, and runs the Hook code.
    //<< ; If all is ok, goes on to try VAR Hooks.
    //<< ;
    //<< ; Params:   Class Name,
    //<< ;           Event Type : WWW101("WWWEVENTTYPE") enumerator,
    //<< ;           YKEY, YFELD, YFORM are all available as parameters to the function
    //<< ;           YFELDOLD - Record state before event (kept in same format as the other params)
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: none
    //<< ;
    //<< ; History:
    //<< ; 20-Sep-2011   GRF     SR17847: penumEvent not pintEvent; Check if null
    //<< ; 08-Sep-2011   shobby  SR17847: Created (Based on WWW001Hook)
    //<< ;-------------------------------------------------------------------------------
    //<< new objHook,strStatus
    mVar objHook = m$.var("objHook");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objHook,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if (YFORM'="") && ($get(penumEvent)'="") {
    if ((mOp.NotEqual(YFORM.get(),"")) && (mOp.NotEqual(m$.Fnc.$get(penumEvent),""))) {
      //<< set objHook = $get(^WWW120Hook(0,YFORM,penumEvent,1))
      objHook.set(m$.Fnc.$get(m$.var("^WWW120Hook",0,YFORM.get(),penumEvent.get(),1)));
      //<< 
      //<< if (objHook'="") {                                     ; *** EXECUTE ???? 2c ***
      if ((mOp.NotEqual(objHook.get(),""))) {
        //<< if $extract($piece(objHook,Y,1),1,2)="$$" {
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(objHook.get(),m$.var("Y").get(),1),1,2),"$$")) {
          //<< xecute "set strStatus="_$piece(objHook,Y,1)
          m$.Cmd.Xecute(mOp.Concat("set strStatus=",m$.Fnc.$piece(objHook.get(),m$.var("Y").get(),1)));
        }
        //<< } else {
        else {
          //<< xecute "do "_$piece(objHook,Y,1)
          m$.Cmd.Xecute(mOp.Concat("do ",m$.Fnc.$piece(objHook.get(),m$.var("Y").get(),1)));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if $$$ISOK(strStatus) {                                     ; *** EXECUTE ???? 2d ***
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      }
    }
    //<< ;set strStatus = $$ExecuteVARHook^WWW120VARHook(pidClass,penumEvent,.YKEY,.YFELD,YFORM,YFELDOLD,YFIELDNAME)
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
//<< 
}
