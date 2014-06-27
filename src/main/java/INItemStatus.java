//*****************************************************************************
//** TASC - ALPHALINC - MAC INItemStatus
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 17:22:50
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

//<< INItemStatus
public class INItemStatus extends mClass {

  public void main() {
    _INItemStatus();
  }

  public void _INItemStatus() {
  }

  //<< #include INItemStatus
  //<< 
  //<< GetColorCode(pintValue)
  public Object GetColorCode(Object ... _p) {
    mVar pintValue = m$.newVarRef("pintValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called By: FARBE1^WWWFORM7
    //<< ;
    //<< ; Returns: The user-defined colour code associated with an Item Status code
    //<< ;
    //<< ; History:
    //<< ; 09-Mar-2011   shobby  SR17680: created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $select(pintValue="":"",1:$$$INItemStatusColorCode($get(^INItemStatus(0,pintValue,1))))
    return m$.Fnc.$select(mOp.Equal(pintValue.get(),""),"",1,include.INConst.$$$INItemStatusColorCode(m$,m$.Fnc.$get(m$.var("^INItemStatus",0,pintValue.get(),1))));
  }

  //<< 
  //<< 
  //<< OnBeforeSave(pidStatus,pobjStatus)
  public Object OnBeforeSave(Object ... _p) {
    mVar pidStatus = m$.newVarRef("pidStatus",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjStatus = m$.newVarRef("pobjStatus",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If changing default, update current default
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 18-Oct-2010   GRF     SR17309: Boolean macros
    //<< ; 26-May-2010   PPP     SR17309: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idDefault,idGroup,idParent,objDefault,objGroup,strStatus
    mVar idDefault = m$.var("idDefault");
    mVar idGroup = m$.var("idGroup");
    mVar idParent = m$.var("idParent");
    mVar objDefault = m$.var("objDefault");
    mVar objGroup = m$.var("objGroup");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idDefault,idGroup,idParent,objDefault,objGroup,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if $$$INItemStatusDefault1(pobjStatus) {
    if (mOp.Logical(include.INConst.$$$INItemStatusDefault1(m$,pobjStatus))) {
      //<< // Can only have one default, so if we have just made this one default,
      //<< // remove check from old default
      //<< set idDefault = $$$DefaultStatus
      //TODO REVISAR INCLUDE FALTANDO idDefault.set($$$include.$$$DefaultStatus(m$));
      //<< if (idDefault'="") && (idDefault'=pidStatus) {
      if ((mOp.NotEqual(idDefault.get(),"")) && (mOp.NotEqual(idDefault.get(),pidStatus.get()))) {
        //<< set objDefault = $get(^INItemStatus(0,idDefault,1))
        objDefault.set(m$.Fnc.$get(m$.var("^INItemStatus",0,idDefault.get(),1)));
        //<< set $$$INItemStatusDefault1(objDefault) = $$$NO
        include.INConst.$$$INItemStatusDefault1Set(m$,objDefault,include.COMSYS.$$$NO(m$));
        //<< set strStatus = $$$Save("INItemStatus",idDefault,objDefault,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"INItemStatus",idDefault,objDefault,include.COMSYS.$$$YES(m$)));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Error(strStatus)
      include.COMSYS.$$$Error(m$,strStatus);
      //<< set Q = $$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnBeforeDelete(pidStatus,pobjStatus)
  public Object OnBeforeDelete(Object ... _p) {
    mVar pidStatus = m$.newVarRef("pidStatus",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjStatus = m$.newVarRef("pobjStatus",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Can we delete?  ie is it the default, or on a supplier?
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 26-May-2010   PPP     SR17309: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idxStatus,strStatus
    mVar idxStatus = m$.var("idxStatus");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idxStatus,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if $$$INItemStatusDefault1(pobjStatus) {
    if (mOp.Logical(include.INConst.$$$INItemStatusDefault1(m$,pobjStatus))) {
      //<< set strStatus = $listbuild("IN00663")                   ; "The default status cannot be deleted."
      strStatus.set(m$.Fnc.$listbuild("IN00663"));
    }
    //<< 
    //<< } else {
    else {
      //<< set idxStatus = $$$Index(pidStatus)
      idxStatus.set(include.MEDConst.$$$Index(m$,pidStatus));
    }
    //<< 
    //<< //  if $data(^INARTs(0,2,idxStatus)) || $data(^FINAPSuppliers(0,3,idxStatus)) {
    //<< //      set strStatus = $listbuild("IN00587",pidStatus)     ; "This record (%1) is in use. It cannot be deleted."
    //<< //  }
    //<< }
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set Q = $$$QDontDelete_strStatus
      mVar Q = m$.var("Q");
      Q.set(mOp.Concat(include.COMSYSWWW.$$$QDontDelete(m$),strStatus.get()));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
//<< 
}
