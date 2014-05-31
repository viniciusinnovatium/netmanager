//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWYEAR
//** Innovatium Systems - Code Converter - v1.24
//** 2014-05-30 12:32:56
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
//<< #include WWWConst
import include.WWWConst;


//<< WWWYEAR(pdteDate) ;WWWYEAR;DT;ANZEIGEN JAHR AUS $H;21.01.2000
public class WWWYEAR extends mClass {

  public Object main(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWYEAR(pdteDate);
  }

  public Object _WWWYEAR(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      ANZEIGEN JAHR AUS $H
    //<< ;|      Return the year number of a $horolog date.
    //<< ;|
    //<< ;| Inputs :  pdteDate   (A $horolog date)
    //<< ;|
    //<< ;|
    //<< ;| ByRef :
    //<< ;|
    //<< ;|
    //<< ;| Returns :  The year number
    //<< ;|
    //<< ;|
    //<< ;| History :
    //<< ;| 12-Oct-2006  Steve S     SR BR014112: Re-wrote to use $Zdate functions
    //<< ;| DT   21.01.2000
    //<< ;|
    //<< ;\------------------------------------------------------------------/
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
    //<< quit $$$DateYear(pdteDate)
    return include.COMSYSDate.$$$DateYear(m$,pdteDate);
  }

//<< 
//<< 
//<< 
//<< 
}
