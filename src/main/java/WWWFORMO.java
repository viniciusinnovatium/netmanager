//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMO
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:53
//*****************************************************************************

import mLibrary.*;


//<< WWWFORMO
public class WWWFORMO extends mClass {

  public void main() {
    _WWWFORMO();
  }

  public void _WWWFORMO() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       OPTION ERFASSUNG   /   Option Acquisition
    //<< ;
    //<< ;  Option List Class  (e.g. INReq : Edit/Cancel/Reject/...)
    //<< ;
    //<< ; Called By : RUECK^WWWFORM
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
    //<< ; 03.06.1998    DT      Created GEAENDERT=57899,36607
    //<< ;-------------------------------------------------------------------------------
    //<< new YI,YPRIM,YA,YLFN
    mVar YI = m$.var("YI");
    mVar YPRIM = m$.var("YPRIM");
    mVar YA = m$.var("YA");
    mVar YLFN = m$.var("YLFN");
    m$.newVar(YI,YPRIM,YA,YLFN);
    //<< 
    //<< quit:YFORM=""
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      return;
    }
    //<< quit:$order(^WWW1210(0,YFORM,""))=""
    if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW1210",0,m$.var("YFORM").get(),"")),"")) {
      return;
    }
    //<< 
    //<< set YART  = "O"  ;O=OPTION,P=PRIMÄR,D=DATENFELD,M=MANUELLE,L=LISTGENERATOR
    mVar YART = m$.var("YART");
    YART.set("O");
    //<< set YLFN  = 1
    YLFN.set(1);
    //<< set YSATZ = ""
    mVar YSATZ = m$.var("YSATZ");
    YSATZ.set("");
    //<< do ^WWWFORM9
    m$.Cmd.Do("WWWFORM9.main");
    //<< quit
    return;
  }

//<< 
//<< 
}
