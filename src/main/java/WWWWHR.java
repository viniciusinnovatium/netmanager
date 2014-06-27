//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWWHR
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 20:45:00
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWWHR(pidCur) ;WWWWHR;DT;WÄHRUNGEN ANZEIGEN;27.02.2000
public class WWWWHR extends mClass {

  public Object main(Object ... _p) {
    mVar pidCur = m$.newVarRef("pidCur",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWWHR(pidCur);
  }

  public Object _WWWWHR(Object ... _p) {
    mVar pidCur = m$.newVarRef("pidCur",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      WÄHRUNGEN ANZEIGEN - Get the currency symbol
    //<< ;|
    //<< ;| Inputs :
    //<< ;|
    //<< ;|
    //<< ;| ByRef :
    //<< ;|
    //<< ;|
    //<< ;| Returns :
    //<< ;|
    //<< ;|
    //<< ;| History :
    //<< ;| 06-Mar-2007      Steve S     SR15460: Rewrote to proper variable names
    //<< ;| DT   27.02.2000
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< new strCur
    mVar strCur = m$.var("strCur");
    m$.newVar(strCur);
    //<< 
    //<< if $get(pidCur)="" quit ""
    if (mOp.Equal(m$.Fnc.$get(pidCur),"")) {
      return "";
    }
    //<< 
    //<< // Not needed, can never happen
    //<< //IF '$DATA(pidCur) IF $GET(SPRACHE)'="EN" SET pidCur="EUR"
    //<< //IF '$DATA(pidCur) IF $GET(SPRACHE)="EN" SET pidCur="USD"
    //<< 
    //<< set strCur                    = $$$WWWWAESymbol($get(^WWWWAE(0,pidCur,1)))
    strCur.set(include.WWWConst.$$$WWWWAESymbol(m$,m$.Fnc.$get(m$.var("^WWWWAE",0,pidCur.get(),1))));
    //<< if strCur="&euro;" set strCur = $char(128)
    if (mOp.Equal(strCur.get(),"&euro;")) {
      strCur.set(m$.Fnc.$char(128));
    }
    //<< if strCur=""       set strCur = $case(pidCur,"EUR":$char(128),"DEM":"DM","USD":"$","GBP":"&pound;","JPY":"&yen;",:"")
    if (mOp.Equal(strCur.get(),"")) {
      strCur.set(m$.Fnc.$case(pidCur.get(),"EUR",m$.Fnc.$char(128),"DEM","DM","USD","$","GBP","&pound;","JPY","&yen;",""));
    }
    //<< 
    //<< //if strCur="" DO  ;NUR WENN LEER;TYBD;15.4,2004
    //<< //. IF pidCur="EUR" SET strCur=$CHAR(128)
    //<< //. IF pidCur="DEM" SET strCur="DM"
    //<< //. IF pidCur="USD" SET strCur="$"
    //<< //. IF pidCur="GBP" SET strCur="&pound;"
    //<< //. IF pidCur="JPY" SET strCur="&yen;"
    //<< 
    //<< quit strCur
    return strCur.get();
  }

//<< 
}
