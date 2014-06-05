//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMONTH
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:44
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

//<< WWWMONTH(pdteDate)
public class WWWMONTH extends mClass {

  public Object main(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWMONTH(pdteDate);
  }

  public Object _WWWMONTH(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANZEIGEN MONAT AUS $H
    //<< ;       Return the month number (1-12) for a $horolog date.
    //<< ;
    //<< ; Inputs :  pdteDate    (A $horolog date)
    //<< ;
    //<< ; Returns : The month number (1 = January, 2 = February, etc.)
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 12-Oct-2006   SteveS  SRBR014112: Re-wrote to use $zdate functions
    //<< ; 21.01.2000    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< set pdteDate = $get(pdteDate)
    pdteDate.set(m$.Fnc.$get(pdteDate));
    //<< if (pdteDate = "") set pdteDate = +$horolog
    if ((mOp.Equal(pdteDate.get(),""))) {
      pdteDate.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< set pdteDate = +pdteDate
    pdteDate.set(mOp.Positive(pdteDate.get()));
    //<< if pdteDate=0 quit ""
    if (mOp.Equal(pdteDate.get(),0)) {
      return "";
    }
    //<< 
    //<< quit $$$DateMonth(pdteDate)
    return include.COMSYSDate.$$$DateMonth(m$,pdteDate);
  }

//<< 
//<< 
}
