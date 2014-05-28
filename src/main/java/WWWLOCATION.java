//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWLOCATION
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:30
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

//<< WWWLOCATION(YLOCATION,YFORM,YFELD)
public class WWWLOCATION extends mClass {

  public Object main(Object ... _p) {
    mVar YLOCATION = m$.newVarRef("YLOCATION",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return _WWWLOCATION(YLOCATION,YFORM,YFELD);
  }

  public Object _WWWLOCATION(Object ... _p) {
    mVar YLOCATION = m$.newVarRef("YLOCATION",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       PRUEFEN DER AENDERBARKEIT DER DATEN
    //<< ;
    //<< ; Inputs :
    //<< ;   YLOCATION   CURRENT LOCATION OF USER
    //<< ;   YFORM       CURRENT FORMNAME
    //<< ;   YFELD       DATARECORD CONTAINING  LOCATION
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;   boolean - was the data record created at the current location if matching is required?
    //<< ;
    //<< ; History :
    //<< ; 02-Jan-2007   GRF     SR15336: variable fix; brace format Doco
    //<< ; 09.04.2003    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new blnLocnMatch,intLocnField,objCompany,strDataLocn
    mVar blnLocnMatch = m$.var("blnLocnMatch");
    mVar intLocnField = m$.var("intLocnField");
    mVar objCompany = m$.var("objCompany");
    mVar strDataLocn = m$.var("strDataLocn");
    m$.newVar(blnLocnMatch,intLocnField,objCompany,strDataLocn);
    //<< 
    //<< set blnLocnMatch = $$$YES           ;OK TO SAVE/KILL
    blnLocnMatch.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< if $get(YLOCATION)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(YLOCATION),"")) {
      //<< set objCompany = $get(^WWW012(0,YM,1))  ;COMPANY PARAMETERS
      objCompany.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
      //<< 
      //<< if $$$WWW012LocationisOwnerOfDataReco(objCompany) && ($get(YFORM)'="") {
      if (mOp.Logical(include.WWWConst.$$$WWW012LocationisOwnerOfDataReco(m$,objCompany)) && (mOp.NotEqual(m$.Fnc.$get(YFORM),""))) {
        //<< set intLocnField = +$$$WWW120DataItemOfLocation($get(^WWW120(0,YFORM,1)))
        intLocnField.set(mOp.Positive(include.WWWConst.$$$WWW120DataItemOfLocation(m$,m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)))));
        //<< if intLocnField {
        if (mOp.Logical(intLocnField.get())) {
          //<< set strDataLocn = $piece(YFELD,Y,intLocnField)
          strDataLocn.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),intLocnField.get()));
          //<< if strDataLocn'="" set blnLocnMatch = (YLOCATION=strDataLocn)
          if (mOp.NotEqual(strDataLocn.get(),"")) {
            blnLocnMatch.set((mOp.Equal(YLOCATION.get(),strDataLocn.get())));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnLocnMatch
    return blnLocnMatch.get();
  }

//<< 
//<< /* replaced code - YVORG2 cf YVORG(2)
//<< NEW YRETURN,YVORG,YVORG1,YVORG2
//<< 
//<< SET YRETURN = 1           ;OK TO SAVE/KILL
//<< 
//<< SET YVORG   = ""
//<< IF $GET(YLOCATION)'="" SET YVORG=$GET(^WWW012(0,YM,1))  ;COMPANY PARAMETERS
//<< 
//<< ;   D131        $$$WWW012LocationisOwnerOfDataReco()
//<< ;   D132        $$$WWW120DataItemOfLocation()
//<< 
//<< IF $PIECE(YVORG,Y,131)=1 DO  ;LOCATION SWITCH ON
//<< . SET YVORG(2)=""
//<< . IF $GET(YFORM)'="" SET YVORG2=$PIECE($GET(^WWW120(0,YFORM,1)),Y,132)  ;FIELD FOR THE LOCATION
//<< . IF +YVORG(2)=0                              QUIT    ;NO field number set for LOCATION storage
//<< . IF $PIECE(YFELD,Y,YVORG(2))=""              QUIT    ;NO ENTRY in that field
//<< . IF $GET(YLOCATION)=$PIECE(YFELD,Y,YVORG(2)) QUIT    ;SAME = OK
//<< . SET YRETURN=0                                       ;NOT THE SAME
//<< 
//<< QUIT YRETURN    */
//<< 
}
