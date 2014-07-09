//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWStatus
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-08 13:08:29
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWStatus
public class WWWStatus extends mClass {

  public void main() {
    _WWWStatus();
  }

  public void _WWWStatus() {
  }

  //<< GetDescription(pidClass,pidStatus,SPRACHE="EN")
  public Object GetDescription(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidStatus = m$.newVarRef("pidStatus",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar SPRACHE = m$.newVarRef("SPRACHE",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"EN");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the DEscription for WWWStatus (inc Language Text)
    //<< ;
    //<< ; Params:   pidStatus       Status id
    //<< ;           pidClass        Class Id
    //<< ;           SPRACHE         Language
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 16-May-2012   SCR     SR17993: Use Description Field
    //<< ; 29-Jun-2009   PPP     SR16663: Add the Calculated Relation Display Fields
    //<< ;------------------------------------------------------------------------------
    //<< //^WWWStatus(0,"INIssue",1,1)="Open"
    //<< new idText,strDesc
    mVar idText = m$.var("idText");
    mVar strDesc = m$.var("strDesc");
    m$.newVar(idText,strDesc);
    //<< set:'$get(YM) YM=0
    if (mOp.Not(m$.Fnc.$get(m$.var("YM")))) {
      m$.var("YM").set(0);
    }
    //<< 
    //<< set idText =  $$$WWWStatusDescription($get(^WWWStatus(YM,pidClass,pidStatus,1))) ; SR17993
    idText.set(include.WWWConst.$$$WWWStatusDescription(m$,m$.Fnc.$get(m$.var("^WWWStatus",m$.var("YM").get(),pidClass.get(),pidStatus.get(),1))));
    //<< ;set idText = $get(^WWWStatus(YM,pidClass,pidStatus,1))
    //<< 
    //<< //if 'idText || (idText && (idText > ($order(^WWWStatus(YM,pidClass,""),-1)) )) {
    //<< set strDesc = $$^WWWTEXT(idText,,,SPRACHE)
    strDesc.set(m$.fnc$("WWWTEXT.main",idText.get(),null,null,SPRACHE.get()));
    //<< 
    //<< if strDesc="" {
    if (mOp.Equal(strDesc.get(),"")) {
      //<< set strDesc = idText
      strDesc.set(idText.get());
    }
    //<< }
    //<< 
    //<< quit strDesc
    return strDesc.get();
  }

//<< 
//<< 
}
