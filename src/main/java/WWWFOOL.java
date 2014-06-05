//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFOOL
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:41
//*****************************************************************************

import mLibrary.*;


//<< WWWFOOL(YBED,TEXT) ;WWWFOOL;DT;SPEICHERN ERFOLGLOSE LOGIN;08.01.2002
public class WWWFOOL extends mClass {

  public Object main(Object ... _p) {
    mVar YBED = m$.newVarRef("YBED",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar TEXT = m$.newVarRef("TEXT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _WWWFOOL(YBED,TEXT);
  }

  public Object _WWWFOOL(Object ... _p) {
    mVar YBED = m$.newVarRef("YBED",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar TEXT = m$.newVarRef("TEXT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Record Unsuccessful login
    //<< ;
    //<< ; Params:   YBED    - user trying to log in
    //<< ;           TEXT    - error description
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Oct-2006   JW      Doco
    //<< ; 08.01.2002    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< QUIT:$GET(YBED)=""
    if (mOp.Equal(m$.Fnc.$get(YBED),"")) {
      return null;
    }
    //<< SET ^WWWFOOL(0,+$HOROLOG,$PIECE($HOROLOG,",",2),YBED,1)=$GET(TEXT)_" "_$GET(YIPADDR)
    m$.var("^WWWFOOL",0,mOp.Positive(m$.Fnc.$horolog()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),YBED.get(),1).set(mOp.Concat(mOp.Concat(m$.Fnc.$get(TEXT)," "),m$.Fnc.$get(m$.var("YIPADDR"))));
    //<< QUIT
    return null;
  }

}
