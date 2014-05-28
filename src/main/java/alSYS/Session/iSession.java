//*****************************************************************************
//** TASC - ALPHALINC - CLASS alSYS.Session.iSession
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:59
//*****************************************************************************

package alSYS.Session;

import mLibrary.*;

//<< Class alSYS.Session.iSession [ Abstract, ClassType = "", Not ProcedureBlock ]
public class iSession extends mAbstract {

  //<< {
  //<< 
  //<< /// Create a New Session and Capture all the Session variables
  //<< ClassMethod Create(ByRef pSC As %Status) As Session
  public Object Create(Object ... _p) {
    mVar pSC = m$.newVarRef("pSC",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 26-Oct-2007   SCR     SR15606: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Session
    mVar Session = m$.var("Session");
    m$.newVar(Session);
    //<< 
    //<< set Session = ##class(Session).%New()
    Session.set(m$.fnc$("Session.$New"));
    //<< set pSC = Session.Capture()
    pSC.set(m$.fnc$(Session.getORef(),"Capture"));
    //<< quit Session
    return Session.get();
  //<< }
  }

//<< 
//<< }
}
