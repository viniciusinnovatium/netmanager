//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW001Hook
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:45
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

//<< WWW001Hook
public class WWW001Hook extends mClass {

  public void main() {
    _WWW001Hook();
  }

  public void _WWW001Hook() {
  }

  //<< 
  //<< ExecuteHook(pidClass="",penumEvent,&YKEY="",&YFELD="",YFORM="",YFELDOLD="",YFIELDNAME="")  ;SR17847
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
    //<< 
    //<< ; 20-Sep-2011   GRF     SR17847: penumEvent not pintEvent; Check if null
    //<< ; 29-Aug-2011   shobby  SR17847: Pass YFIELDNAME as a parameter.
    //<< ; 26-Aug-2011   shobby  SR17847: Allow non $$ routines.
    //<< ; 26-Oct-2010   GRF     SR17541: Extended byRef YKEY to VARHook processing
    //<< ; 30-Sep-2010   shobby  SR17541: YKEY may be modified here (add &), need to
    //<< ;                           change SCHLUESSEL if it is.
    //<< ; 29-Jan-2007   JW      SR15304: Added YFELDOLD
    //<< ; 14-Dec-2006   SteveS  SR15316: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objHook,strStatus
    mVar objHook = m$.var("objHook");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objHook,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if (pidClass'="") && ($get(penumEvent)'="") {                                         ; *** EXECUTE Kill 2a ***
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(m$.Fnc.$get(penumEvent),""))) {
      //<< set objHook = $get(^WWW001Hook(0,pidClass,penumEvent,1))
      objHook.set(m$.Fnc.$get(m$.var("^WWW001Hook",0,pidClass.get(),penumEvent.get(),1)));
      //<< if (objHook'="") {
      if ((mOp.NotEqual(objHook.get(),""))) {
        //<< if $extract($$$WWW001HookCode(objHook),1,2)="$$" {
        if (mOp.Equal(m$.Fnc.$extract(include.WWWConst.$$$WWW001HookCode(m$,objHook),1,2),"$$")) {
          //<< xecute "set strStatus="_$$$WWW001HookCode(objHook)
          m$.Cmd.Xecute(mOp.Concat("set strStatus=",include.WWWConst.$$$WWW001HookCode(m$,objHook)));
        }
        //<< } else {
        else {
          //<< xecute "do "_$$$WWW001HookCode(objHook)  ;SR17847
          m$.Cmd.Xecute(mOp.Concat("do ",include.WWWConst.$$$WWW001HookCode(m$,objHook)));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if $$$ISOK(strStatus) {                                     ; *** EXECUTE Kill 2b ***
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< set strStatus = $$ExecuteVARHook^WWW001VARHooks(pidClass,penumEvent,.YKEY,.YFELD,YFORM,YFELDOLD) ;SR17847
        strStatus.set(m$.fnc$("WWW001VARHooks.ExecuteVARHook",pidClass.get(),penumEvent.get(),YKEY,YFELD,YFORM.get(),YFELDOLD.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {                                     ; *** EXECUTE ???? 2c, 2d ***
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set strStatus = $$ExecuteHook^WWW120Hook(pidClass,penumEvent,.YKEY,.YFELD,YFORM,YFELDOLD,YFIELDNAME) ;SR17847
      strStatus.set(m$.fnc$("WWW120Hook.ExecuteHook",pidClass.get(),penumEvent.get(),YKEY,YFELD,YFORM.get(),YFELDOLD.get(),YFIELDNAME.get()));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
//<< 
}
