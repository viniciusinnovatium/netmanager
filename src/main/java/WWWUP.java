//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWUP
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:36
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

//<< WWWUP(pblnStop)
public class WWWUP extends mClass {

  public Object main(Object ... _p) {
    mVar pblnStop = m$.newVarRef("pblnStop",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWUP(pblnStop);
  }

  public Object _WWWUP(Object ... _p) {
    mVar pblnStop = m$.newVarRef("pblnStop",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       UP BUTTON
    //<< ;
    //<< ; Inputs :
    //<< ;   pblnStop        Operation : 0 START
    //<< ;                       1 STOP
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 11-Dec-2009   GRF     SR16871: standardise variables
    //<< ; 07-May-2007   GRF     SR15511: Doco; quits; disabled block
    //<< ; 11.10.1999    DT
    //<< ;-------------------------------------------------------------------------------
    //<< if +$get(pblnStop)=$$$NO {
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(pblnStop)),include.COMSYS.$$$NO(m$))) {
      //<< write "<A NAME=""start""></A>"
      m$.Cmd.Write("<A NAME=\"start\"></A>");
    }
    //<< } else {
    else {
      //<< write "<A HREF=""#start""> <IMG SRC="""_YGIF_"up.gif"" TITLE="""_$$^WWWTEXT(277)_""" border=0></A>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=\"#start\"> <IMG SRC=\"",m$.var("YGIF").get()),"up.gif\" TITLE=\""),m$.fnc$("WWWTEXT.main",277)),"\" border=0></A>"));
    }
    //<< } ; "Start Of Page"
    //<< 
    //<< quit
    return null;
  }

//<< 
}
