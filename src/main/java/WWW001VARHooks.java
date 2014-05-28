//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW001VARHooks
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:04
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

//<< WWW001VARHooks
public class WWW001VARHooks extends mClass {

  public void main() {
    _WWW001VARHooks();
  }

  public void _WWW001VARHooks() {
  }

  //<< 
  //<< ExecuteVARHook(pidClass="",penumEvent,&YKEY="",&YFELD="",YFORM="",YFELDOLD="",YFIELDNAME="")
  public Object ExecuteVARHook(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar penumEvent = m$.newVarRef("penumEvent",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar YFELDOLD = m$.newVarRef("YFELDOLD",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    mVar YFIELDNAME = m$.newVarRef("YFIELDNAME",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks if a VARHook exists for a given form/event, and runs the VARHook code.
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
    //<< ; 26-Aug-2011   shobby  SR17847: Allow non $$ routines.
    //<< ; 26-Oct-2010   GRF     SR17541: Extended byRef YKEY to VARHook processing
    //<< ; 29-Jan-2007   JW      SR15304: Added YFELDOLD
    //<< ; 28-Sep-2006   GRF     Document ByRef argument
    //<< ; 07-Jul-2006   SC      SR14710: Skip VARHook check if no class - ie. Manual Fields.
    //<< ;                           Make pClass, YKEY, YFELD, YFORM default to null.
    //<< ; 10-Apr-2006   SC      SR14414: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objVARHooks,strStatus
    mVar objVARHooks = m$.var("objVARHooks");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objVARHooks,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if (pidClass'="") && ($get(penumEvent)'="") {
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(m$.Fnc.$get(penumEvent),""))) {
      //<< set objVARHooks = $get(^WWW001VARHooks(0,pidClass,penumEvent,1))
      objVARHooks.set(m$.Fnc.$get(m$.var("^WWW001VARHooks",0,pidClass.get(),penumEvent.get(),1)));
      //<< if objVARHooks '= "" {                                  ; *** EXECUTE Kill 2b ***
      if (mOp.NotEqual(objVARHooks.get(),"")) {
        //<< if $extract($$$WWW001VARHooksCode(objVARHooks),1,2)="$$" {
        if (mOp.Equal(m$.Fnc.$extract(include.WWWConst.$$$WWW001VARHooksCode(m$,objVARHooks),1,2),"$$")) {
          //<< xecute "set strStatus="_$$$WWW001VARHooksCode(objVARHooks)
          m$.Cmd.Xecute(mOp.Concat("set strStatus=",include.WWWConst.$$$WWW001VARHooksCode(m$,objVARHooks)));
        }
        //<< } else {
        else {
          //<< xecute "do "_$$$WWW001VARHooksCode(objVARHooks)
          m$.Cmd.Xecute(mOp.Concat("do ",include.WWWConst.$$$WWW001VARHooksCode(m$,objVARHooks)));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
//<< 
}
