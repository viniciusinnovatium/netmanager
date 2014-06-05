//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMNAME
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:41
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;
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

//<< WWWFORMNAME(pidForm)
public class WWWFORMNAME extends mClass {

  public Object main(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWFORMNAME(pidForm);
  }

  public Object _WWWFORMNAME(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;   S FORMNAME=$$^WWWFORMNAME("WWW013")
    //<< ;
    //<< ; Inputs :
    //<< ;   pidForm     Form Id
    //<< ;
    //<< ; ByRef :
    //<< ;   SPRACHE     user language
    //<< ;
    //<< ; Returns : the name of the form
    //<< ;
    //<< ; History :
    //<< ; 19-Sep-2008   shobby  BR014966: disregard function callouts (starting with @)
    //<< ; 18-Sep-2008   shobby  BR014966: Support language texts for form names (works
    //<< ;                           already when building form names but other places
    //<< ;                           that use this routine will need it).
    //<< ; 25-Sep-2007   GRF     SR15602: NAME not newed; changed vars to meet coding stds
    //<< ; 24-Nov-2006   GM      SRBR014107: Include WWW120D condition to change form and
    //<< ;                           help name with customisation
    //<< ; 27-Oct-2006   PO      SR15143: Only get WWW120 if not getting WWW1201
    //<< ; 02-May-2006   Steve S Brace Syntax/macro usage
    //<< ; 12.10.2004    BEC     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strNAME
    mVar strNAME = m$.var("strNAME");
    m$.newVar(strNAME);
    //<< 
    //<< set strNAME=""
    strNAME.set("");
    //<< 
    //<< if $get(pidForm)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidForm),"")) {
      //<< set strNAME = $$PreProcessText^WWWFORMCOMMON($get(^WWW120D(0,pidForm,0,1)),$$$FldWWW120DFormHeaderOrImageFile)
      strNAME.set(m$.fnc$("WWWFORMCOMMON.PreProcessText",m$.Fnc.$get(m$.var("^WWW120D",0,pidForm.get(),0,1)),include.WWWConst.$$$FldWWW120DFormHeaderOrImageFile(m$)));
      //<< if (strNAME="") || ($extract(strNAME)="@") set strNAME = $$$WWW1201Text($get(^WWW1201(0,pidForm,SPRACHE,1)))
      if ((mOp.Equal(strNAME.get(),"")) || (mOp.Equal(m$.Fnc.$extract(strNAME.get()),"@"))) {
        strNAME.set(include.WWWConst.$$$WWW1201Text(m$,m$.Fnc.$get(m$.var("^WWW1201",0,pidForm.get(),m$.var("SPRACHE").get(),1))));
      }
      //<< if strNAME="" set strNAME = $$$WWW120FormHeaderOrImageFile($get(^WWW120(0,pidForm,1)))
      if (mOp.Equal(strNAME.get(),"")) {
        strNAME.set(include.WWWConst.$$$WWW120FormHeaderOrImageFile(m$,m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1))));
      }
    }
    //<< }
    //<< quit strNAME
    return strNAME.get();
  }

//<< 
//<< 
}
