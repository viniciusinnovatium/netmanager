//*****************************************************************************
//** TASC - ALPHALINC - MAC COMGridEdit31Tools
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:08
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include COMGridEdit31
import include.COMGridEdit31;
import include.COMSYS;
//<< #include WWWConst
import include.WWWConst;

//<< COMGridEdit31Tools
public class COMGridEdit31Tools extends mClass {

  public void main() {
    _COMGridEdit31Tools();
  }

  public void _COMGridEdit31Tools() {
  }

  //<< 
  //<< CleanUpPreviousInstance(YFORM,pblnSameRecord=$$$NO)
  public Object CleanUpPreviousInstance(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnSameRecord = m$.newVarRef("pblnSameRecord",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Removes data storage from the previous instance when a grid was displayed.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Mar-2009   GRF     Replace single character variable "i"
    //<< ; 24-Oct-2005   JW      SR13685: Pass in YFORM. Stay on same page.
    //<< ; 21-Mar-2005   shobby  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLink,idPage,lstLinks,loop
    mVar idLink = m$.var("idLink");
    mVar idPage = m$.var("idPage");
    mVar lstLinks = m$.var("lstLinks");
    mVar loop = m$.var("loop");
    m$.newVar(idLink,idPage,lstLinks,loop);
    //<< 
    //<< if YFORM'="" {
    if (mOp.NotEqual(YFORM.get(),"")) {
      //<< if pblnSameRecord {
      if (mOp.Logical(pblnSameRecord.get())) {
        //<< set idPage = $get($$$GRIDPage)
        idPage.set(m$.Fnc.$get(include.COMGridEdit31.$$$GRIDPageVar(m$)));
      }
      //<< }
      //<< 
      //<< set lstLinks = $get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","LINKS"))
      lstLinks.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V","LINKS")));
      //<< for loop=1:1:$length(lstLinks,";") {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(lstLinks.get(),";")));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idLink = $piece(lstLinks,";",loop)
        idLink.set(m$.Fnc.$piece(lstLinks.get(),";",loop.get()));
        //<< if idLink'="" {
        if (mOp.NotEqual(idLink.get(),"")) {
          //<< kill ^WWWDATEN(YM,+$horolog,YUSER,idLink)
          m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),idLink.get()).kill();
        }
      }
      //<< }
      //<< }
      //<< kill ^WWWDATEN(YM,+$horolog,YUSER,YFORM)
      m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get()).kill();
      //<< 
      //<< if pblnSameRecord {
      if (mOp.Logical(pblnSameRecord.get())) {
        //<< if idPage'="" set $$$GRIDPage = idPage
        if (mOp.NotEqual(idPage.get(),"")) {
          include.COMGridEdit31.$$$GRIDPageVar(m$).set(idPage.get());
        }
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

//<< 
//<< 
//<< ;HEVA-694 GetCellHeight(pYFORM,pYLFN="")
//<< ;HEVA-694 ;-------------------------------------------------------------------------------
//<< ;HEVA-694 ; Get the required height of a cell
//<< ;HEVA-694 ;
//<< ;HEVA-694 ; Params: pYFORM      : The form id
//<< ;HEVA-694 ;             pYLFN       : (Optional) This field only
//<< ;HEVA-694 ;
//<< ;HEVA-694 ; ByRefs:
//<< ;HEVA-694 ;
//<< ;HEVA-694 ; Returns: intHeight
//<< ;HEVA-694 ;
//<< ;HEVA-694 ; History:
//<< ;HEVA-694 ; 06-Dec-2012 shobby  HEVA-694: Redundant
//<< ;HEVA-694 ; 05-Jul-2007 shobby  SRBR014553: Consider customisation of the form
//<< ;HEVA-694 ; 24-Oct-2006 SS      SR14915: Created
//<< ;HEVA-694 ;-------------------------------------------------------------------------------
//<< ;HEVA-694 new intHeight,idClass,idClassFld,idFormFld,objWWW122,objWWW003
//<< 
//<< ;HEVA-694 set intHeight = 16 // original hard-coded value for all cells
//<< 
//<< ;HEVA-694 if $get(pYFORM)'="" {
//<< ;HEVA-694   set idClass = $$$GRIDClass(pYFORM)
//<< ;HEVA-694   if pYLFN'="" {
//<< ;HEVA-694       if $$$WWW003InputType($get(^WWW003(0,idClass,pYLFN,1))) = 10 { //filename
//<< ;HEVA-694           set intHeight = 20
//<< ;HEVA-694       }
//<< 
//<< ;HEVA-694   } else {
//<< ;HEVA-694       set idFormFld = ""
//<< ;HEVA-694       for {
//<< ;HEVA-694           set idFormFld = $order(^WWW122(0,pYFORM,idFormFld))
//<< ;HEVA-694           quit:(idFormFld="")
//<< ;HEVA-694           quit:(intHeight'=16)                            // change made
//<< ;HEVA-694
//<< ;HEVA-694           set objWWW122  = $$Get^WWW122(pYFORM,idFormFld)
//<< ;HEVA-694           set idClassFld = $$$WWW122SequenceNumber(objWWW122)
//<< 
//<< ;HEVA-694           if (idClassFld'="") {                           // check class
//<< ;HEVA-694               set objWWW003 = $get(^WWW003(0,idClass,idClassFld,1))
//<< ;HEVA-694               if ($$$WWW003InputType(objWWW003)=10) {     // filename
//<< ;HEVA-694                   set intHeight = 20
//<< ;HEVA-694               }
//<< ;HEVA-694           } else {                                        // manual field, check form
//<< ;HEVA-694               if $$$WWW122InputType(objWWW122)=10 {       // filename
//<< ;HEVA-694                   set intHeight = 20
//<< ;HEVA-694               }
//<< ;HEVA-694           }
//<< ;HEVA-694       }
//<< ;HEVA-694   }
//<< ;HEVA-694 }
//<< ;HEVA-694 quit intHeight
//<< 
//<< 
}
