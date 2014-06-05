//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWDAY
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:41
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

//<< WWWDAY(YI)
public class WWWDAY extends mClass {

  public Object main(Object ... _p) {
    mVar YI = m$.newVarRef("YI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWDAY(YI);
  }

  public Object _WWWDAY(Object ... _p) {
    mVar YI = m$.newVarRef("YI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANZEIGEN TAG
    //<< ;       Get Day of Week
    //<< ;       based on initial modulus Thurs:0 to Wed:6
    //<< ;
    //<< ; Note: Use the macro instead of this function when possible.
    //<< ;
    //<< ; Inputs :
    //<< ;   YI = $H FORMAT
    //<< ;
    //<< ; Returns :
    //<< ;   YI = 1-7 = MONTAG - SONNTAG ;Monday - Sunday
    //<< ;
    //<< ; History :
    //<< ; 20-Mar-2007   JW      SR15384: Use Macro
    //<< ; 17-May-2006   GRF     Doco; comment out unnecessary step
    //<< ;               DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< IF $GET(YI)="" SET YI=+$HOROLOG
    if (mOp.Equal(m$.Fnc.$get(YI),"")) {
      YI.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< quit $$$DayOfWeek(YI)
    return include.COMSYSDate.$$$DayOfWeek(m$,YI);
  }

//<< //QUIT (YI+3)#7+1       SR15384
//<< 
//<< 
}
