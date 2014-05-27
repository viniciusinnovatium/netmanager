//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWTRAKT
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:15
//*****************************************************************************

import mLibrary.*;


//<< WWWTRAKT(YUSER)
public class WWWTRAKT extends mClass {

  public Object main(Object ... _p) {
    mVar YUSER = m$.newVarRef("YUSER",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWTRAKT(YUSER);
  }

  public Object _WWWTRAKT(Object ... _p) {
    mVar YUSER = m$.newVarRef("YUSER",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       LFD TRANSAKTION
    //<< ;       Maintain a session sequence number
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 23.06.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW TRAKT   ;TRANSAKTIONSNUMMER
    mVar TRAKT = m$.var("TRAKT");
    m$.newVar(TRAKT);
    //<< 
    //<< SET TRAKT=""
    TRAKT.set("");
    //<< IF YUSER'="" SET TRAKT=$PIECE($GET(^WWWUSER(0,YUSER,1)),Y,7)+1,$PIECE(^WWWUSER(0,YUSER,1),Y,7)=TRAKT
    if (mOp.NotEqual(YUSER.get(),"")) {
      TRAKT.set(mOp.Add(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1)),m$.var("Y").get(),7),1));
      m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),7).set(TRAKT.get());
    }
    //<< ;IF $GET(YTRAKT)>0 MERGE ^WWWZWS(0,+$HOROLOG,YUSER,TRAKT)=^WWWZWS(0,+$HOROLOG,YUSER,YTRAKT)  ;RÜCKHOLEN VARIABLEN
    //<< QUIT TRAKT
    return TRAKT.get();
  }

//<< 
}
