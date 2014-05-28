//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMLocking
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:11
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
//<< #include WWWConst
import include.WWWConst;
//<< #include MEDConst
import include.MEDConst;

//<< WWWFORMLocking
public class WWWFORMLocking extends mClass {

  public void main() {
    _WWWFORMLocking();
  }

  public void _WWWFORMLocking() {
  }

  //<< 
  //<< CanLock(pidForm)
  public Object CanLock(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine whether a form should allow locking onto its appropriate
    //<< ; data structure.
    //<< ;
    //<< ; Called By: ^WWWLESE, GetNextLine^COMGridEdit31Add
    //<< ;
    //<< ; Params: pidForm       : The form id
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: blnFlag
    //<< ;
    //<< ; History:
    //<< ; 05-May-2006   SteveS  SR14508: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnFlag,objWWW120,idClass,objWWW001
    mVar blnFlag = m$.var("blnFlag");
    mVar objWWW120 = m$.var("objWWW120");
    mVar idClass = m$.var("idClass");
    mVar objWWW001 = m$.var("objWWW001");
    m$.newVar(blnFlag,objWWW120,idClass,objWWW001);
    //<< 
    //<< set blnFlag = $$$NO
    blnFlag.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if $get(pidForm)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidForm),"")) {
      //<< set objWWW120 = $get(^WWW120(0,pidForm,1))
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1)));
      //<< set idClass   = $$$WWW120ClassUsedInForm(objWWW120)
      idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objWWW120));
      //<< 
      //<< if (idClass'="") {
      if ((mOp.NotEqual(idClass.get(),""))) {
        //<< set objWWW001 = $get(^WWW001(0,idClass,1))
        objWWW001.set(m$.Fnc.$get(m$.var("^WWW001",0,idClass.get(),1)));
        //<< set blnFlag   = '$$$WWW001NoLocking(objWWW001)
        blnFlag.set(mOp.Not(include.WWWConst.$$$WWW001NoLocking(m$,objWWW001)));
      }
    }
    //<< }
    //<< }
    //<< quit blnFlag
    return blnFlag.get();
  }

  //<< 
  //<< 
  //<< CreateLock(pstrKey,pidUser,pdtsLocked,pidForm)
  public Object CreateLock(Object ... _p) {
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pdtsLocked = m$.newVarRef("pdtsLocked",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Construct Lock references as a matched pair
    //<< ;
    //<< ;  do CreateLock^WWWFORMLocking(%SCHLUESSEL,YUSER,$horolog,YFORM)
    //<< ;  Calling routine to ensure all parameters are defined.
    //<< ;
    //<< ; Called By: ^WWWLESE
    //<< ;
    //<< ; Params:
    //<< ;   pstrKey         Formalised Key string e.g. pass in "^WWW003(0,INART,24,1)
    //<< ;                       which is converted to "^WWW003/0.INART.24.1/" for saving,
    //<< ;                       thus locking class field 24 for class "INART"
    //<< ;   pidUser         YUSER
    //<< ;   pdtsLocked      $horolog
    //<< ;   pidForm         Form Name
    //<< ;
    //<< ; History:
    //<< ; 20-Feb-2009   GRF     SR16356: Created as common function
    //<< ;-------------------------------------------------------------------------------
    //<< new dteLocked,tmeLocked
    mVar dteLocked = m$.var("dteLocked");
    mVar tmeLocked = m$.var("tmeLocked");
    m$.newVar(dteLocked,tmeLocked);
    //<< 
    //<< ; FIXME : If a server is accessed across midnight a lock created just before
    //<< ;         midnight will not be found when the date changes.  <GRF>
    //<< set dteLocked = +pdtsLocked
    dteLocked.set(mOp.Positive(pdtsLocked.get()));
    //<< set tmeLocked = $piece(pdtsLocked,$$$COMMA,2)
    tmeLocked.set(m$.Fnc.$piece(pdtsLocked.get(),include.COMSYSString.$$$COMMA(m$),2));
    //<< set pstrKey   = $translate(pstrKey,",()"_$$$DBLQUOTE,".//")
    pstrKey.set(m$.Fnc.$translate(pstrKey.get(),mOp.Concat(",()",include.COMSYSString.$$$DBLQUOTE(m$)),".//"));
    //<< 
    //<< set ^WWW006(0,dteLocked,pstrKey,1) = pidUser_Y_tmeLocked
    m$.var("^WWW006",0,dteLocked.get(),pstrKey.get(),1).set(mOp.Concat(mOp.Concat(pidUser.get(),m$.var("Y").get()),tmeLocked.get()));
    //<< if pidForm'="" {
    if (mOp.NotEqual(pidForm.get(),"")) {
      //<< set ^WWWDATEN(YM,dteLocked,pidUser,pidForm,"LOCK",1) = "^WWW006(0,"_dteLocked_","_$$$DBLQUOTE_pstrKey_$$$DBLQUOTE_",1)"
      m$.var("^WWWDATEN",m$.var("YM").get(),dteLocked.get(),pidUser.get(),pidForm.get(),"LOCK",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW006(0,",dteLocked.get()),","),include.COMSYSString.$$$DBLQUOTE(m$)),pstrKey.get()),include.COMSYSString.$$$DBLQUOTE(m$)),",1)"));
    }
    //<< }
    //<< if ($replace($piece(pstrKey,"/",1),"^","") = "MEDPrescription"){
    if ((mOp.Equal(m$.Fnc.$replace(m$.Fnc.$piece(pstrKey.get(),"/",1),"^",""),"MEDPrescription"))) {
      //<< if ($$$MEDPrescriptionStatus($get(^MEDPrescription(YM,$piece(pstrKey,".",2),1))) > 1){
      if ((mOp.Greater(include.MEDConst.$$$MEDPrescriptionStatus(m$,m$.Fnc.$get(m$.var("^MEDPrescription",m$.var("YM").get(),m$.Fnc.$piece(pstrKey.get(),".",2),1))),1))) {
        //<< do KillLock(dteLocked,pstrKey)
        m$.Cmd.Do("KillLock",dteLocked.get(),pstrKey.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< KillLock(dteToday,pstrKey)
  public Object KillLock(Object ... _p) {
    mVar dteToday = m$.newVarRef("dteToday",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Common method to remove locks.  Use to track down when locks are being created
    //<< ; and destroyed.
    //<< ;
    //<< ; Called By: ^WWWSPEI
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Aug-2009   shobby  SR16808: Created
    //<< ;-------------------------------------------------------------------------------
    //<< kill ^WWW006(0,dteToday,pstrKey)
    m$.var("^WWW006",0,dteToday.get(),pstrKey.get()).kill();
    //<< quit
    return null;
  }

//<< 
//<< 
}
