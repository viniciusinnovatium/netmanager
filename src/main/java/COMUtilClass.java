//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUtilClass
//** Innovatium Systems - Code Converter - v1.24
//** 2014-06-02 20:07:30
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; Common Utilities for @netManager Classes
//<< ;
//<< ; See also :
//<< ;   COMUtilDate     Date/Time Utilities
//<< ;   COMUtilStr      String Manipulation
//<< ;   COMUtilGlo      Global Manipulation
//<< ;   COMUtilForm     @netManager Form Utilities
//<< ;
//<< ; see also DCMEvent : pidClass_"Save" or pidClass_"Kill"
//<< ;                     associated with WWWSPEI and WWWKILL respectively
//<< ;
//<< ; History:
//<< ; 18-Mar-2005   GRF     SR10478 : convert pLock to pblnLock;
//<< ;                           pOnceOnly to pblnBlockEvent
//<< ; 23-Feb-2005   GRF     Created; moved some routines from COMUtils
//<< ;-------------------------------------------------------------------------------
//<< #include COMConst
import include.COMConst;
import include.COMSYS;
//<< #include WWWConst
import include.WWWConst;
//import COMSYS;
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

//<< COMUtilClass
public class COMUtilClass extends mClass {

  public void main() {
    _COMUtilClass();
  }

  public void _COMUtilClass() {
  }

  //<< 
  //<< Kill(pidClass,pstrKey,pidForm)  ; DO NOT USE YET - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
  public Object Kill(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for WWWKILL
    //<< ; Calling WWWKILL within a WWWKILL will fail because YFORM is not scoped without
    //<< ; being newed here.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 12-Aug-2010   GRF     Pass form id in as well as class id since they won't
    //<< ;                           always be identical. (implicit pass to WWWKILL)
    //<< ; 01-Jul-2004   shobby  Creation (Copied from FINSYS)
    //<< ;-------------------------------------------------------------------------------
    //<< new YFORM
    mVar YFORM = m$.var("YFORM");
    m$.newVar(YFORM);
    //<< 
    //<< if $get(pidForm)="" set pidForm = pidClass
    if (mOp.Equal(m$.Fnc.$get(pidForm),"")) {
      pidForm.set(pidClass.get());
    }
    //<< set YFORM = pidForm
    YFORM.set(pidForm.get());
    //<< do ^WWWKILL(pidClass,pstrKey)
    m$.Cmd.Do("WWWKILL.main",pidClass.get(),pstrKey.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< COMUtilsKILL(pClass,pKey)
  public Object COMUtilsKILL(Object ... _p) {
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< ; DO NOT USE - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for WWWKILL
    //<< ; Calling WWWKILL within a WWWKILL will fail because YFORM is not scoped
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; NOTE : Updates have been made to KILL^COMUtils
    //<< ; 01-Jul-2004   shobby  Creation (Copied from FINSYS)
    //<< ;-------------------------------------------------------------------------------
    //<< new YFORM
    mVar YFORM = m$.var("YFORM");
    m$.newVar(YFORM);
    //<< set YFORM=pClass
    YFORM.set(pClass.get());
    //<< do ^WWWKILL(pClass,pKey)
    m$.Cmd.Do("WWWKILL.main",pClass.get(),pKey.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< FINSYSKILL(pClass,pKey)
  public Object FINSYSKILL(Object ... _p) {
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< ; DO NOT USE - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
    //<< ; 36 calls to KILL^FINSYS
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 02-Dec-2003   shobby  Creation (TR006513)
    //<< ;-------------------------------------------------------------------------------
    //<< new strYFORM
    mVar strYFORM = m$.var("strYFORM");
    m$.newVar(strYFORM);
    //<< 
    //<< set strYFORM = $get(YFORM)
    strYFORM.set(m$.Fnc.$get(m$.var("YFORM")));
    //<< set YFORM    = pClass
    mVar YFORM = m$.var("YFORM");
    YFORM.set(pClass.get());
    //<< do ^WWWKILL(pClass,pKey)
    m$.Cmd.Do("WWWKILL.main",pClass.get(),pKey.get());
    //<< set YFORM    = strYFORM
    YFORM.set(strYFORM.get());
    //<< quit
    return null;
  }

  //<< 
  //<< SALUtilsKill(pClass,pKey)
  public Object SALUtilsKill(Object ... _p) {
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< ; DO NOT USE - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for Kill. Used by $$$Kill
    //<< ;
    //<< ; Returns:Status
    //<< ;
    //<< ; History:
    //<< ; 02-Feb-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,YFORM
    mVar strStatus = m$.var("strStatus");
    mVar YFORM = m$.var("YFORM");
    m$.newVar(strStatus,YFORM);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if pClass'="" {
    if (mOp.NotEqual(pClass.get(),"")) {
      //<< if '$data(^WWW001(0,pClass,1)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW001",0,pClass.get(),1)))) {
        //<< set strStatus=$listbuild("SALCST0266",pClass)  ; "Class '%1' does not exist."
        strStatus.set(m$.Fnc.$listbuild("SALCST0266",pClass.get()));
      }
      //<< 
      //<< } else {
      else {
        //<< set YFORM=pClass
        YFORM.set(pClass.get());
        //<< do ^WWWKILL(pClass,pKey)
        m$.Cmd.Do("WWWKILL.main",pClass.get(),pKey.get());
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set strStatus = $listbuild("SALCST0267")  ; "No class for kill."  ; FIXME : $$$MakeStatus
      strStatus.set(m$.Fnc.$listbuild("SALCST0267"));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< COMDCMUtilitiesIntraprendDelete(pClass,pKey)
  public Object COMDCMUtilitiesIntraprendDelete(Object ... _p) {
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< ; DO NOT USE - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ;This routine simulates the @NetManager routine to delete a global
    //<< ;
    //<< ;pClass  This is the global name
    //<< ;pKey    This is the key values in a comma separated string, e.g. KEY1,KEY2,KEYn
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< do ^WWWKILL(pClass,pKey)
    m$.Cmd.Do("WWWKILL.main",pClass.get(),pKey.get());
    //<< set strStatus = $$$OK_Y_$$^WWWTEXT("Com00076")  ; "Delete performed"
    strStatus.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$OK(m$),m$.var("Y").get()),m$.fnc$("WWWTEXT.main","Com00076")));
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< SALWWWCommonOnDelete(pGlobal,pKey)
  public Object SALWWWCommonOnDelete(Object ... _p) {
    mVar pGlobal = m$.newVarRef("pGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< ; DO NOT USE - THIS IS HERE TO COMPARE WITH OTHER VERSIONS - note SKILL not KILL
    //<< ;                                                            ===================
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Calls WWWSKILL to delete inwards DCM record
    //<< ;   Fourth argument : 1 = Don't put the entry back on the DCM queue
    //<< ;
    //<< ; History:
    //<< ; 10-Jan-2004   GRF     SR11363 : New piece 4 in WWWSKILL
    //<< ; 23-Dec-2004   PO      SR11363 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< do ^WWWSKILL(pGlobal,pKey,,$$$YES)
    m$.Cmd.Do("WWWSKILL.main",pGlobal.get(),pKey.get(),null,include.COMSYS.$$$YES(m$));
    //<< set strStatus = $$$OK_Y_$$^WWWTEXT($$$Text("SALCST1037"))  ; "Delete performed"
    strStatus.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$OK(m$),m$.var("Y").get()),m$.fnc$("WWWTEXT.main",include.COMSYS.$$$Text(m$,"SALCST1037"))));
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< 
  //<< ;********************************************
  //<< 
  //<< SaveParams(pCompany,pidClass,pidKey1,pidKey2,pidKey3,pidKey4,pidKey5,pidKey6,pidKey7)
  public Object SaveParams(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidKey1 = m$.newVarRef("pidKey1",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidKey2 = m$.newVarRef("pidKey2",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pidKey3 = m$.newVarRef("pidKey3",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pidKey4 = m$.newVarRef("pidKey4",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pidKey5 = m$.newVarRef("pidKey5",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pidKey6 = m$.newVarRef("pidKey6",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar pidKey7 = m$.newVarRef("pidKey7",(((_p!=null)&&(_p.length>=9))?_p[8]:null));
    //<< 
    //<< ; DO NOT USE YET - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
    //<< 
    //<< ; This was Save^SALUtils - All calls are to specific classes so should
    //<< ; build keylist before call to Save rather than this convoluted need to
    //<< ; check right number of keys.
    //<< 
    //<< ; FIXME : pidClass will not necessarily match pidForm - should have both and
    //<< ;         assign YFORM to pidForm.
    //<< ;         WWW001/WWW002 and call to $$Save should be based on pidClass
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for WWWSPEI. Also checks the Class exists, and the correct number
    //<< ; of primary keys are passed in.
    //<< ;
    //<< ; The last pidKey# position used is the data, all earlier positions represent the
    //<< ;
    //<< ; example : Use set status=$$Save("FINGLAccount","123.003.4","Sale Account")
    //<< ;
    //<< ; Note : Used via $$$SaveGlobal
    //<< ;
    //<< ; History:
    //<< ; 03-May-2004   shobby  Replaced YKOMMA with ","
    //<< ; 01-Dec-2003   Paul K  Added Note
    //<< ; 24-Jun-2003   Paul K  If intraprend doesn't return a success, set
    //<< ;                       status to listbuild.
    //<< ; 16-Jun-2003   Paul K  Logic error looking to see if class existed.
    //<< ;-------------------------------------------------------------------------------
    //<< new idKey,Key,lngDataPiece,lngKey,lngKeysForClass,lngNumPrimaryKeys,strData
    mVar idKey = m$.var("idKey");
    mVar Key = m$.var("Key");
    mVar lngDataPiece = m$.var("lngDataPiece");
    mVar lngKey = m$.var("lngKey");
    mVar lngKeysForClass = m$.var("lngKeysForClass");
    mVar lngNumPrimaryKeys = m$.var("lngNumPrimaryKeys");
    mVar strData = m$.var("strData");
    m$.newVar(idKey,Key,lngDataPiece,lngKey,lngKeysForClass,lngNumPrimaryKeys,strData);
    //<< new strStatus,YFORM,YM
    mVar strStatus = m$.var("strStatus");
    mVar YFORM = m$.var("YFORM");
    mVar YM = m$.var("YM");
    m$.newVar(strStatus,YFORM,YM);
    //<< 
    //<< if pidClass'="" {
    if (mOp.NotEqual(pidClass.get(),"")) {
      //<< set YM    = pCompany
      YM.set(pCompany.get());
      //<< set YFORM = pidClass
      YFORM.set(pidClass.get());
      //<< if $data(^WWW001(0,YFORM,1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW001",0,YFORM.get(),1)))) {
        //<< ;look throught the passed in variables and use indirection to determine the last passed in one.
        //<< for lngDataPiece=1:1 {
        for (lngDataPiece.set(1);(true);lngDataPiece.set(mOp.Add(lngDataPiece.get(),1))) {
          //<< set idKey="pidKey"_lngDataPiece
          idKey.set(mOp.Concat("pidKey",lngDataPiece.get()));
          //<< quit:'$data(@idKey)
          if (mOp.Not(m$.Fnc.$data(m$.indirectVar(idKey.get())))) {
            break;
          }
        }
        //<< }
        //<< 
        //<< ; we found out the piece that doesn't exist, so the previous piece contains the data.
        //<< set lngDataPiece      = lngDataPiece-1
        lngDataPiece.set(mOp.Subtract(lngDataPiece.get(),1));
        //<< set lngNumPrimaryKeys = lngDataPiece-1
        lngNumPrimaryKeys.set(mOp.Subtract(lngDataPiece.get(),1));
        //<< set lngKeysForClass   = $order(^WWW002(0,YFORM,""),-1)
        lngKeysForClass.set(m$.Fnc.$order(m$.var("^WWW002",0,YFORM.get(),""),mOp.Negative(1)));
        //<< if lngKeysForClass=lngNumPrimaryKeys {  ;check with class to make sure correct number of primary keys.
        if (mOp.Equal(lngKeysForClass.get(),lngNumPrimaryKeys.get())) {
          //<< set Key=pidKey1
          Key.set(pidKey1.get());
          //<< for lngKey=2:1:lngNumPrimaryKeys {  ;build up the primary key
          for (lngKey.set(2);(mOp.LessOrEqual(lngKey.get(),lngNumPrimaryKeys.get()));lngKey.set(mOp.Add(lngKey.get(),1))) {
            //<< set idKey = "pidKey"_lngKey
            idKey.set(mOp.Concat("pidKey",lngKey.get()));
            //<< set Key   = Key_","_@idKey
            Key.set(mOp.Concat(mOp.Concat(Key.get(),","),m$.indirectVar(idKey.get()).get()));
          }
          //<< }
          //<< set idKey     = "pidKey"_lngDataPiece   ;get the data
          idKey.set(mOp.Concat("pidKey",lngDataPiece.get()));
          //<< set strData   = @idKey
          strData.set(m$.indirectVar(idKey.get()).get());
          //<< ;   set strStatus = $$^WWWSPEI(YFORM,Key,strData,1)
          //<< set strStatus = $$Save(YFORM,Key,strData,$$$YES)
          strStatus.set(m$.fnc$("Save",YFORM.get(),Key.get(),strData.get(),include.COMSYS.$$$YES(m$)));
        }
        //<< 
        //<< ;   if strStatus'=$$$OK set strStatus = $listbuild("Com00078",YFORM,strStatus)
        //<< ;   ; "Save failed for class %1. Intraprend returned status %2"
        //<< 
        //<< } else {
        else {
          //<< set strStatus = $listbuild("Com00069",YFORM,lngKeysForClass,lngNumPrimaryKeys)
          strStatus.set(m$.Fnc.$listbuild("Com00069",YFORM.get(),lngKeysForClass.get(),lngNumPrimaryKeys.get()));
        }
      }
      //<< } ; "Save failed. Class %1 has %2 primary keys, Save passed in %3"
      //<< 
      //<< } else {
      else {
        //<< set strStatus = $listbuild("Com00068",YFORM)
        strStatus.set(m$.Fnc.$listbuild("Com00068",YFORM.get()));
      }
    }
    //<< } ; "Save failed. Class %1 does not exist"
    //<< 
    //<< } else {
    else {
      //<< set strStatus = $listbuild("Com00067")
      strStatus.set(m$.Fnc.$listbuild("Com00067"));
    }
    //<< } ; "Save failed. No Class."
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< SaveOnce(pClass="",pKey="",pData="",pblnLock="")
  public Object SaveOnce(Object ... _p) {
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pData = m$.newVarRef("pData",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnLock = m$.newVarRef("pblnLock",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< 
    //<< ; DO NOT USE YET - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
    //<< ; ----------------------------------------------------------------------------
    //<< ; WWWSPEI Wrapper for DCM processes that can end up as recursive entries
    //<< ; (i.e.   Event => WWWSPEI => Event => WWWSPEI => ...)
    //<< ;
    //<< ; History:
    //<< ; 25-Feb-2005   GRF     SR11499 : Standard calls
    //<< ; ----------------------------------------------------------------------------
    //<< 
    //<< quit $$Save(pClass,pKey,pData,pblnLock,$$$YES)
    return m$.fnc$("Save",pClass.get(),pKey.get(),pData.get(),pblnLock.get(),include.COMSYS.$$$YES(m$));
  }

  //<< 
  //<< ; ----------------------------------------------------------------------------
  //<< ;   Com00067    :   Save failed. No Class.
  //<< ;   Com00068    :   Save failed. Class %1 does not exist
  //<< ;   Com00069    :   Save failed. Class %1 has %2 primary keys, Save passed in %3
  //<< ;   Com00072    :   Error returned from WWWSPEI
  //<< ;   Com00073    : 1 Save performed correctly
  //<< ;   Com00074    :   Unable to save - not owner
  //<< ;   Com00075    :   Unknown response(%1) from WWWSPEI
  //<< ;   Com00078    :   Save failed for class %1. Intraprend returned status %2   => Fin00212 ?
  //<< ; x SALCST1033  : 1 Saved performed correctly
  //<< ; x SALCST1034  :   Error returned from WWWSPEI
  //<< ; x SALCST1035  :   Unable to save - not owner
  //<< ; x SALCST1036  :   Unknown response (%1) from WWWSPEI
  //<< ;   Fin00212    :   System save failed, Class:%1 Key:2 Error%3
  //<< ; ----------------------------------------------------------------------------
  //<< 
  //<< Save(pidClass="",pKey="",pData="",pblnLock="",pblnBlockEvent=$$$NO)
  public Object Save(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pData = m$.newVarRef("pData",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnLock = m$.newVarRef("pblnLock",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pblnBlockEvent = m$.newVarRef("pblnBlockEvent",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    //<< 
    //<< ; FIXME : pidClass will not always match pidForm - calling routine should
    //<< ;         pass both pidClass and pidForm - this routine should new YFORM and
    //<< ;         set it to pidForm.
    //<< ;         Test of $$$WWW120ClassUsedInForm = YFORM is logically inverted
    //<< 
    //<< ; DO NOT USE YET - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
    //<< 
    //<< ; TODO : <GRF> Add extra parameter to pass pblnDoOnBeforeSave to WWWSPEI as
    //<< ;              Argument 8 (Default $$$YES) - may have separate calling tags
    //<< ;              for with/without
    //<< 
    //<< ; ----------------------------------------------------------------------------
    //<< ; WWWSPEI Wrapper
    //<< ;
    //<< ; History:
    //<< ; 15-Mar-2005   Paul K  Use Macros instead of $piece(x,Y,n)
    //<< ; 19-Jan-2005   Steve S Added $$$OK macro usage for Status
    //<< ; 19-Aug-2004   SCR     Copied from FINSYS
    //<< ; 27-Feb-2004   shobby  Set default locking to 0 but not allow locking of 1 when Class=YFORM
    //<< ; 26-Feb-2004   shobby  Returned default locking to 1 but override with 0 when Class=YFORM
    //<< ;                       (Awaiting SR discussion with Germany before finalising this)
    //<< ; 09-Jan-2004   lwaugh  Ensured Lock flag is passed to WWWSPEI
    //<< ; 07-Jul-2003   SCR     Added Lock Option , New YVOR
    //<< ; ----------------------------------------------------------------------------
    //<< new strStatus,YVOR
    mVar strStatus = m$.var("strStatus");
    mVar YVOR = m$.var("YVOR");
    m$.newVar(strStatus,YVOR);
    //<< 
    //<< if $get(pblnLock)'=$$$YES {
    if (mOp.NotEqual(m$.Fnc.$get(pblnLock),include.COMSYS.$$$YES(m$))) {
      //<< set pblnLock = $$$NO
      pblnLock.set(include.COMSYS.$$$NO(m$));
    }
    //<< } else {
    else {
      //<< if pKey=YKEY {
      if (mOp.Equal(pKey.get(),m$.var("YKEY").get())) {
        //<< if ($get(YFORM)'="") && ($$$WWW120ClassUsedInForm($get(^WWW120(0,pidClass,1)))=YFORM) {
        if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.Equal(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,pidClass.get(),1))),m$.var("YFORM").get()))) {
          //<< set pblnLock = $$$NO
          pblnLock.set(include.COMSYS.$$$NO(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< new YFORM  ;*** Must be after the test that we are not saving to the currently displayed record
    mVar YFORM = m$.var("YFORM");
    m$.newVar(YFORM);
    //<< 
    //<< set YFORM = pidClass
    YFORM.set(pidClass.get());
    //<< set strStatus = $$^WWWSPEI(pidClass,pKey,pData,pblnLock,pblnBlockEvent)
    strStatus.set(m$.fnc$("WWWSPEI.main",pidClass.get(),pKey.get(),pData.get(),pblnLock.get(),pblnBlockEvent.get()));
    //<< 
    //<< if (strStatus=$$$NO) {
    if ((mOp.Equal(strStatus.get(),include.COMSYS.$$$NO(m$)))) {
      //<< ; Error returned from WWWSPEI
      //<< set strStatus  = $$$NO_Y_$$DecodeError^COMUtilError($listbuild($$$Text("Com00072"),pidClass,pKey))
      strStatus.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$NO(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild(include.COMSYS.$$$Text(m$,"Com00072"),pidClass.get(),pKey.get()))));
    }
    //<< ;   set strStatus = $listbuild("Com00078",pidClass,strStatus)       ; "Save failed for class %1. Intraprend returned status %2"
    //<< ;   set strStatus = $listbuild("Fin00212",pidClass,pKey,strStatus)  ; "System save failed, Class:%1 Key:2 Error%3"
    //<< 
    //<< } elseif (strStatus=$$$OK) {
    else if ((mOp.Equal(strStatus.get(),include.COMSYS.$$$OK(m$)))) {
      //<< set strStatus  = $$$OK_Y_$$DecodeError^COMUtilError($listbuild($$$Text("Com00073")))
      strStatus.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$OK(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild(include.COMSYS.$$$Text(m$,"Com00073")))));
    }
    //<< ; "Saved performed correctly"
    //<< 
    //<< } elseif (strStatus=$$$SPEINotOwned) {
    else if ((mOp.Equal(strStatus.get(),include.COMSYS.$$$SPEINotOwned(m$)))) {
      //<< set strStatus  = $$$NO_Y_$$DecodeError^COMUtilError($listbuild($$$Text("Com00074"),pidClass,pKey))
      strStatus.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$NO(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild(include.COMSYS.$$$Text(m$,"Com00074"),pidClass.get(),pKey.get()))));
    }
    //<< ; "Unable to save - not owner"
    //<< 
    //<< } else {
    else {
      //<< set strStatus  = $$$NO_Y_$$DecodeError^COMUtilError($listbuild($$$Text($listbuild("Com00075",)),strStatus,pidClass,pKey))
      strStatus.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$NO(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("Com00075")),strStatus.get(),pidClass.get(),pKey.get()))));
    }
    //<< } ; "Unknown response (%1) from WWWSPEI"
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< COMUtilsSave(pidClass,pKey,pData,pblnLock)  ; DO NOT USE YET - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
  public Object COMUtilsSave(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pData = m$.newVarRef("pData",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnLock = m$.newVarRef("pblnLock",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ; ----------------------------------------------------------------------------
    //<< ; WWWSPEI Wrapper
    //<< ;
    //<< ; History:
    //<< ; NOTE : Updates have been made to Save^COMUtils
    //<< ; 15-Mar-2005   Paul K  Use Macros instead of $piece(x,Y,n)
    //<< ; 19-Jan-2005   Steve S Added $$$OK macro usage for Status
    //<< ; 19-Aug-2004   SCR     Copied from FINSYS
    //<< ; 27-Feb-2004   shobby  Set default locking to 0 but not allow locking of 1 when Class=YFORM
    //<< ; 26-Feb-2004   shobby  Returned default locking to 1 but override with 0 when Class=YFORM
    //<< ;                       (Awaiting SR discussion with Germany before finalising this)
    //<< ; 09-Jan-2004   lwaugh  Ensured Lock flag is passed to WWWSPEI
    //<< ; 07-Jul-2003   SCR     Added Lock Option , New YVOR
    //<< ; ----------------------------------------------------------------------------
    //<< new strStatus,YVOR
    mVar strStatus = m$.var("strStatus");
    mVar YVOR = m$.var("YVOR");
    m$.newVar(strStatus,YVOR);
    //<< 
    //<< if $get(pblnLock)'=$$$YES {
    if (mOp.NotEqual(m$.Fnc.$get(pblnLock),include.COMSYS.$$$YES(m$))) {
      //<< set pblnLock = $$$NO
      pblnLock.set(include.COMSYS.$$$NO(m$));
    }
    //<< } else {
    else {
      //<< if pKey=YKEY {
      if (mOp.Equal(pKey.get(),m$.var("YKEY").get())) {
        //<< if ($get(YFORM)'="") && ($$$WWW120ClassUsedInForm($get(^WWW120(0,pidClass,1)))=$get(YFORM)) {
        if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.Equal(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,pidClass.get(),1))),m$.Fnc.$get(m$.var("YFORM"))))) {
          //<< set pblnLock = $$$NO
          pblnLock.set(include.COMSYS.$$$NO(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< new YFORM  ;*** Must be after the test that we are not saving to the currently displayed record
    mVar YFORM = m$.var("YFORM");
    m$.newVar(YFORM);
    //<< 
    //<< ;set:($g(Lock)'=1) Lock=0
    //<< set YFORM     = pidClass
    YFORM.set(pidClass.get());
    //<< set strStatus = $$^WWWSPEI(pidClass,pKey,pData,pblnLock)
    strStatus.set(m$.fnc$("WWWSPEI.main",pidClass.get(),pKey.get(),pData.get(),pblnLock.get()));
    //<< 
    //<< if strStatus'=$$$OK {
    if (mOp.NotEqual(strStatus.get(),include.COMSYS.$$$OK(m$))) {
      //<< set strStatus = $listbuild("Fin00212",pidClass,pKey,strStatus)
      strStatus.set(m$.Fnc.$listbuild("Fin00212",pidClass.get(),pKey.get(),strStatus.get()));
    }
    //<< } ; "System save failed, Class:%1 Key:2 Error%3"
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< SALUtilsSave(pCompany,pClass,pidKey1,pidKey2,pidKey3,pidKey4,pidKey5,pidKey6,pidKey7)
  public Object SALUtilsSave(Object ... _p) {
    mVar pCompany = m$.newVarRef("pCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidKey1 = m$.newVarRef("pidKey1",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidKey2 = m$.newVarRef("pidKey2",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pidKey3 = m$.newVarRef("pidKey3",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pidKey4 = m$.newVarRef("pidKey4",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pidKey5 = m$.newVarRef("pidKey5",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pidKey6 = m$.newVarRef("pidKey6",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar pidKey7 = m$.newVarRef("pidKey7",(((_p!=null)&&(_p.length>=9))?_p[8]:null));
    //<< 
    //<< ; DO NOT USE - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
    //<< ; approx 125 incl .INC re-definitions
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for WWWSPEI. Also checks the Class exists, and the correct number
    //<< ; of primary keys are passed in.
    //<< ;
    //<< ; example : Use set status=$$Save("FINGLAccount","123.003.4","Sale Account")
    //<< ;
    //<< ; Note : Used via $$$SaveGlobal
    //<< ;
    //<< ; History:
    //<< ; 03-May-2004   shobby  Replaced YKOMMA with ","
    //<< ; 01-Dec-2003   Paul K  Added Note
    //<< ; 24-Jun-2003   Paul K  If intraprend doesn't return a success, set
    //<< ;                       status to listbuild.
    //<< ; 16-Jun-2003   Paul K  Logic error looking to see if class existed.
    //<< ;-------------------------------------------------------------------------------
    //<< new idKey,Key,lngDataPiece,lngKey,lngKeysForClass,lngNumPrimaryKeys,strData
    mVar idKey = m$.var("idKey");
    mVar Key = m$.var("Key");
    mVar lngDataPiece = m$.var("lngDataPiece");
    mVar lngKey = m$.var("lngKey");
    mVar lngKeysForClass = m$.var("lngKeysForClass");
    mVar lngNumPrimaryKeys = m$.var("lngNumPrimaryKeys");
    mVar strData = m$.var("strData");
    m$.newVar(idKey,Key,lngDataPiece,lngKey,lngKeysForClass,lngNumPrimaryKeys,strData);
    //<< new strStatus,YFORM,YM
    mVar strStatus = m$.var("strStatus");
    mVar YFORM = m$.var("YFORM");
    mVar YM = m$.var("YM");
    m$.newVar(strStatus,YFORM,YM);
    //<< 
    //<< if pClass'="" {
    if (mOp.NotEqual(pClass.get(),"")) {
      //<< set YM    = pCompany
      YM.set(pCompany.get());
      //<< set YFORM = pClass
      YFORM.set(pClass.get());
      //<< if $data(^WWW001(0,YFORM,1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW001",0,YFORM.get(),1)))) {
        //<< ;look throught the passed in variables and use indirection to determine the last passed in one.
        //<< for lngDataPiece=1:1 {
        for (lngDataPiece.set(1);(true);lngDataPiece.set(mOp.Add(lngDataPiece.get(),1))) {
          //<< set idKey="pidKey"_lngDataPiece
          idKey.set(mOp.Concat("pidKey",lngDataPiece.get()));
          //<< quit:'$data(@idKey)
          if (mOp.Not(m$.Fnc.$data(m$.indirectVar(idKey.get())))) {
            break;
          }
        }
        //<< }
        //<< 
        //<< ; we found out the piece that doesn't exist, so the previous piece contains the data.
        //<< set lngDataPiece      = lngDataPiece-1
        lngDataPiece.set(mOp.Subtract(lngDataPiece.get(),1));
        //<< set lngNumPrimaryKeys = lngDataPiece-1
        lngNumPrimaryKeys.set(mOp.Subtract(lngDataPiece.get(),1));
        //<< set lngKeysForClass   = $order(^WWW002(0,YFORM,""),-1)
        lngKeysForClass.set(m$.Fnc.$order(m$.var("^WWW002",0,YFORM.get(),""),mOp.Negative(1)));
        //<< if lngKeysForClass=lngNumPrimaryKeys {  ;check with class to make sure correct number of primary keys.
        if (mOp.Equal(lngKeysForClass.get(),lngNumPrimaryKeys.get())) {
          //<< set Key=pidKey1
          Key.set(pidKey1.get());
          //<< for lngKey=2:1:lngNumPrimaryKeys {  ;build up the primary key
          for (lngKey.set(2);(mOp.LessOrEqual(lngKey.get(),lngNumPrimaryKeys.get()));lngKey.set(mOp.Add(lngKey.get(),1))) {
            //<< set idKey = "pidKey"_lngKey
            idKey.set(mOp.Concat("pidKey",lngKey.get()));
            //<< set Key   = Key_","_@idKey
            Key.set(mOp.Concat(mOp.Concat(Key.get(),","),m$.indirectVar(idKey.get()).get()));
          }
          //<< }
          //<< set idKey     = "pidKey"_lngDataPiece   ;get the data
          idKey.set(mOp.Concat("pidKey",lngDataPiece.get()));
          //<< set strData   = @idKey
          strData.set(m$.indirectVar(idKey.get()).get());
          //<< set strStatus = $$^WWWSPEI(YFORM,Key,strData,1)
          strStatus.set(m$.fnc$("WWWSPEI.main",YFORM.get(),Key.get(),strData.get(),1));
          //<< if strStatus'=$$$OK set strStatus=$listbuild("Com00078",YFORM,strStatus)
          if (mOp.NotEqual(strStatus.get(),include.COMSYS.$$$OK(m$))) {
            strStatus.set(m$.Fnc.$listbuild("Com00078",YFORM.get(),strStatus.get()));
          }
        }
        //<< ; "Save failed for class %1. Intraprend returned status %2"
        //<< } else {
        else {
          //<< set strStatus = $listbuild("Com00069",YFORM,lngKeysForClass,lngNumPrimaryKeys)
          strStatus.set(m$.Fnc.$listbuild("Com00069",YFORM.get(),lngKeysForClass.get(),lngNumPrimaryKeys.get()));
        }
      }
      //<< } ; "Save failed. Class %1 has %2 primary keys, Save passed in %3"
      //<< 
      //<< } else {
      else {
        //<< set strStatus = $listbuild("Com00068",YFORM)
        strStatus.set(m$.Fnc.$listbuild("Com00068",YFORM.get()));
      }
    }
    //<< } ; "Save failed. Class %1 does not exist"
    //<< 
    //<< } else {
    else {
      //<< set strStatus = $listbuild("Com00067")
      strStatus.set(m$.Fnc.$listbuild("Com00067"));
    }
    //<< } ; "Save failed. No Class."
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< SALCSTIntANMSave(pClass,pKey,pData,pblnLock=$$$YES)
  public Object SALCSTIntANMSave(Object ... _p) {
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pData = m$.newVarRef("pData",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnLock = m$.newVarRef("pblnLock",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$YES(m$));
    //<< 
    //<< ; DO NOT USE - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; WWWSPEI Wrapper.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Dec-2003   Paul K  Passed in Lock and Set default.
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,YFORM,YVOR
    mVar strStatus = m$.var("strStatus");
    mVar YFORM = m$.var("YFORM");
    mVar YVOR = m$.var("YVOR");
    m$.newVar(strStatus,YFORM,YVOR);
    //<< 
    //<< set YFORM = pClass
    YFORM.set(pClass.get());
    //<< set strStatus = $$^WWWSPEI(pClass,pKey,pData,pblnLock)
    strStatus.set(m$.fnc$("WWWSPEI.main",pClass.get(),pKey.get(),pData.get(),pblnLock.get()));
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< COMHCCalculateSave(pClass,pKey,pData,pblnLock)
  public Object COMHCCalculateSave(Object ... _p) {
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pData = m$.newVarRef("pData",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnLock = m$.newVarRef("pblnLock",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; WWWSPEI Wrapper
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,YFORM,YVOR
    mVar strStatus = m$.var("strStatus");
    mVar YFORM = m$.var("YFORM");
    mVar YVOR = m$.var("YVOR");
    m$.newVar(strStatus,YFORM,YVOR);
    //<< 
    //<< set:($get(pblnLock)'=$$$YES) pblnLock = $$$NO
    if ((mOp.NotEqual(m$.Fnc.$get(pblnLock),include.COMSYS.$$$YES(m$)))) {
      pblnLock.set(include.COMSYS.$$$NO(m$));
    }
    //<< set YFORM     = pClass
    YFORM.set(pClass.get());
    //<< set strStatus = $$^WWWSPEI(pClass,pKey,pData,pblnLock)
    strStatus.set(m$.fnc$("WWWSPEI.main",pClass.get(),pKey.get(),pData.get(),pblnLock.get()));
    //<< if strStatus'=$$$OK {
    if (mOp.NotEqual(strStatus.get(),include.COMSYS.$$$OK(m$))) {
      //<< set strStatus = $listbuild("Fin00212",pClass,pKey,strStatus)
      strStatus.set(m$.Fnc.$listbuild("Fin00212",pClass.get(),pKey.get(),strStatus.get()));
    }
    //<< } ; "System save failed, Class:%1 Key:2 Error%3"
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< COMDCMUtilitiesIntraprendSave(pClass,pKey,pData)
  public Object COMDCMUtilitiesIntraprendSave(Object ... _p) {
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pData = m$.newVarRef("pData",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;This routine simulates the @NetManager routine to save a global
    //<< ;
    //<< ;pClass  This is the global name
    //<< ;pKey    This is the key values in a comma separated string, e.g. KEY1,KEY2,KEYn
    //<< ;pData   This is the data values in a tilde separated string, e.g. XX~XX~XX~
    //<< ;
    //<< ; 05-Feb-2003   SCR     New YFORM,YVOR
    //<< ;-------------------------------------------------------------------------------
    //<< new ok,result,txtlist,YFORM,YVOR
    mVar ok = m$.var("ok");
    mVar result = m$.var("result");
    mVar txtlist = m$.var("txtlist");
    mVar YFORM = m$.var("YFORM");
    mVar YVOR = m$.var("YVOR");
    m$.newVar(ok,result,txtlist,YFORM,YVOR);
    //<< 
    //<< set ok = $$^WWWSPEI(pClass,pKey,pData,$$$YES)
    ok.set(m$.fnc$("WWWSPEI.main",pClass.get(),pKey.get(),pData.get(),include.COMSYS.$$$YES(m$)));
    //<< 
    //<< if (ok=$$$NO) {
    if ((mOp.Equal(ok.get(),include.COMSYS.$$$NO(m$)))) {
      //<< set txtlist = $listbuild("Com00072",pClass,pKey)     ; Error returned from WWWSPEI
      txtlist.set(m$.Fnc.$listbuild("Com00072",pClass.get(),pKey.get()));
      //<< set result  = $$$NO_Y_$$DecodeError^COMUtilError(txtlist)
      result.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$NO(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
    }
    //<< } elseif (ok=$$$YES) {
    else if ((mOp.Equal(ok.get(),include.COMSYS.$$$YES(m$)))) {
      //<< set txtlist = $listbuild("Com00073")                 ; Save performed correctly
      txtlist.set(m$.Fnc.$listbuild("Com00073"));
      //<< set result  = $$$OK_Y_$$DecodeError^COMUtilError(txtlist)
      result.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$OK(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
    }
    //<< } elseif (ok=$$$SPEINotOwned) {
    else if ((mOp.Equal(ok.get(),include.COMSYS.$$$SPEINotOwned(m$)))) {
      //<< set txtlist = $listbuild("Com00074",pClass,pKey)     ; Unable to save - not owner
      txtlist.set(m$.Fnc.$listbuild("Com00074",pClass.get(),pKey.get()));
      //<< set result  = $$$NO_Y_$$DecodeError^COMUtilError(txtlist)
      result.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$NO(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
    }
    //<< } else {
    else {
      //<< set txtlist = $listbuild("Com00075",ok,pClass,pKey) ; Unknown response(%1) from WWWSPEI
      txtlist.set(m$.Fnc.$listbuild("Com00075",ok.get(),pClass.get(),pKey.get()));
      //<< set result  = $$$NO_Y_$$DecodeError^COMUtilError(txtlist)
      result.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$NO(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
    }
    //<< }
    //<< 
    //<< if (($piece(result,Y,1)) && (pClass="COMDCMLocation")) {
    if ((mOp.Logical((m$.Fnc.$piece(result.get(),m$.var("Y").get(),1))) && (mOp.Equal(pClass.get(),"COMDCMLocation")))) {
      //<< ; Handle WSDL loading on Location Saves
      //<< set result=$$LoadLocationWSDL^COMDCMLocation(pKey)
      result.set(m$.fnc$("COMDCMLocation.LoadLocationWSDL",pKey.get()));
    }
    //<< }
    //<< 
    //<< quit result
    return result.get();
  }

  //<< 
  //<< 
  //<< SALWWWCommonOnSave(pClass,pKey,pData)
  public Object SALWWWCommonOnSave(Object ... _p) {
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pData = m$.newVarRef("pData",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< 
    //<< ; DO NOT USE - THIS IS HERE TO COMPARE WITH OTHER VERSIONS
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Calls WWWSPEI to save inwards DCM record
    //<< ;   Fourth argument : 1 = Ignore location ownership testing
    //<< ;   Sixth argument  : 1 = Don't put the entry back on the DCM queue
    //<< ;
    //<< ; History:
    //<< ; 10-Jan-2004   GRF     SR11363 : New piece 6 in WWWSPEI
    //<< ; 23-Dec-2004   PO      SR11363 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$^WWWSPEI(pClass,pKey,pData,$$$YES,,$$$YES)
    strStatus.set(m$.fnc$("WWWSPEI.main",pClass.get(),pKey.get(),pData.get(),include.COMSYS.$$$YES(m$),null,include.COMSYS.$$$YES(m$)));
    //<< 
    //<< if (strStatus=$$$NO) {
    if ((mOp.Equal(strStatus.get(),include.COMSYS.$$$NO(m$)))) {
      //<< set strStatus  = $$$NO_Y_$$DecodeError^COMUtilError($listbuild($$$Text("SALCST1034"),pClass,pKey))
      strStatus.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$NO(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild(include.COMSYS.$$$Text(m$,"SALCST1034"),pClass.get(),pKey.get()))));
    }
    //<< ; "Error returned from WWWSPEI"
    //<< 
    //<< } elseif (strStatus=$$$OK) {
    else if ((mOp.Equal(strStatus.get(),include.COMSYS.$$$OK(m$)))) {
      //<< set strStatus  = $$$OK_Y_$$DecodeError^COMUtilError($listbuild($$$Text("SALCST1033")))
      strStatus.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$OK(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild(include.COMSYS.$$$Text(m$,"SALCST1033")))));
    }
    //<< ; "Saved performed correctly"
    //<< 
    //<< } elseif (strStatus=$$$SPEINotOwned) {
    else if ((mOp.Equal(strStatus.get(),include.COMSYS.$$$SPEINotOwned(m$)))) {
      //<< set strStatus  = $$$NO_Y_$$DecodeError^COMUtilError($listbuild($$$Text("SALCST1035"),pClass,pKey))
      strStatus.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$NO(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild(include.COMSYS.$$$Text(m$,"SALCST1035"),pClass.get(),pKey.get()))));
    }
    //<< ; "Unable to save - not owner"
    //<< 
    //<< } else {
    else {
      //<< set strStatus  = $$$NO_Y_$$DecodeError^COMUtilError($listbuild($$$Text($listbuild("SALCST1036",)),strStatus,pClass,pKey))
      strStatus.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$NO(m$),m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("SALCST1036")),strStatus.get(),pClass.get(),pKey.get()))));
    }
    //<< } ; "Unknown response (%1) from WWWSPEI"
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< ;********************************************
  //<< /*
  //<< clsFldNoGivenfrmFldNo(pstrFormName,pintNo,pstrFldType="D")  // NOT IN USE
  //<< ;-------------------------------------------------------------------------------
  //<< ; Given a form, a field number and its type, return its related field number
  //<< ; on the class
  //<< ;
  //<< ; History:
  //<< ; 04-Feb-2005   PO      SR10965 Enhanced to handle types of fields.
  //<< ; 24-Dec-2004   PO      SR11348 Created.
  //<< ;-------------------------------------------------------------------------------
  //<< new intClassFldNo
  //<< 
  //<< set intClassFldNo=""
  //<< 
  //<< if ($get(pstrFormName)'="")&&($get(pintNo)'="") {
  //<< if pstrFldType="P" {
  //<< ;set intClassFldNo = $$$WWW121SequenceNumber($get(^WWW121(YM,pstrFormName,pintNo,1)))
  //<< set intClassFldNo = pintNo ; unsure what to do with primary keys
  //<< } elseif pstrFldType="D" {
  //<< set intClassFldNo = $$$WWW122SequenceNumber($get(^WWW122(0,pstrFormName,pintNo,1)))
  //<< }
  //<< }
  //<< 
  //<< quit intClassFldNo
  //<< */
  //<< 
  //<< CompileAll(pblnSeparate=$$$YES)
  public Object CompileAll(Object ... _p) {
    mVar pblnSeparate = m$.newVarRef("pblnSeparate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Compile all the @NetManager classes into Caché Classes.
    //<< ;
    //<< ; History:
    //<< ; 05-Jan-2011   shobby  SR17646: Include VAR as requested by Pablo.
    //<< ; 28-May-2007   RPW     SRadhoc: Allow single pass compilation
    //<< ; 15-Jul-2005   RPW     SR12981: Don't new VORGX; changed VORGX into strClass
    //<< ; 02-Mar-2005   PK      Reduce incidence of calling WWWVAR (SR#11305)
    //<< ; 22-Feb-2005   RPW     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strPrefix,strShort,strList
    mVar strPrefix = m$.var("strPrefix");
    mVar strShort = m$.var("strShort");
    mVar strList = m$.var("strList");
    m$.newVar(strPrefix,strShort,strList);
    //<< 
    //<< if 'pblnSeparate {
    if (mOp.Not(pblnSeparate.get())) {
      //<< set strList  =",WWW,COM,IN,TER,FIN,CST,SAL,STK,AEP,TS,REP,VAR,"
      strList.set(",WWW,COM,IN,TER,FIN,CST,SAL,STK,AEP,TS,REP,VAR,");
    }
    //<< } else {
    else {
      //<< set strList = ",COM,FIN,CST,SAL,STK,AEP,TS,REP,VAR,"
      strList.set(",COM,FIN,CST,SAL,STK,AEP,TS,REP,VAR,");
      //<< do COMPILEALL^WWW001O()   ; ONLY compiles WWW/IN/TE.  strList is used below
      m$.Cmd.Do("WWW001O.COMPILEALL");
    }
    //<< }
    //<< 
    //<< if $get(Y)="" do ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< set SPRACHE="EN"
    mVar SPRACHE = m$.var("SPRACHE");
    SPRACHE.set("EN");
    do {
      //<< do
      //<< . new strClass
      mVar strClass = m$.var("strClass");
      m$.newVar(strClass);
      //<< . set strClass=""
      strClass.set("");
      //<< . for  set strClass=$order(^WWW001(0,strClass)) quit:strClass=""  do
      for (;true;) {
        strClass.set(m$.Fnc.$order(m$.var("^WWW001",0,strClass.get())));
        if (mOp.Equal(strClass.get(),"")) {
          break;
        }
        do {
          //<< . . ;quit:$extract(VORGX,1,3)="WWW"
          //<< . . set strPrefix = $extract(strClass,1,3)
          strPrefix.set(m$.Fnc.$extract(strClass.get(),1,3));
          //<< . . set strShort  = $extract(strPrefix,1,2)
          strShort.set(m$.Fnc.$extract(strPrefix.get(),1,2));
          //<< . . if (strShort="IN") || (strShort="TS") set strPrefix = strShort
          if ((mOp.Equal(strShort.get(),"IN")) || (mOp.Equal(strShort.get(),"TS"))) {
            strPrefix.set(strShort.get());
          }
          //<< . . if '$find(strList,","_strPrefix) quit
          if (mOp.Not(m$.Fnc.$find(strList.get(),mOp.Concat(",",strPrefix.get())))) {
            break;
          }
          //<< . . ;if strPrefix'="CST" if strPrefix'="SAL" if strPrefix'="FIN" if strPrefix'="STK" if strPrefix'="COM" if strPrefix'="VAR" if strPrefix'="AEP" if strPrefix'="TS" quit
          //<< . . set VORG(1) = strClass
          mVar VORG = m$.var("VORG");
          VORG.var(1).set(strClass.get());
          //<< . . set VORG(3) = 1
          VORG.var(3).set(1);
          //<< . . ;do NEU1
          //<< . . write !,strClass
          m$.Cmd.Write("\n",strClass.get());
          //<< . . do
          do {
            //<< . . . set YKEY=strClass
            mVar YKEY = m$.var("YKEY");
            YKEY.set(strClass.get());
            //<< . . . ;new VORGX
            //<< . . . do COMPILE^WWW001O(YKEY,1)
            m$.Cmd.Do("WWW001O.COMPILE",YKEY.get(),1);
          } while(false);
        } while (false);
      }
    } while(false);
    //<< 
    //<< ;do $system.OBJ.CompileAll()
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetFieldType(strFormName,strFormFieldNo)
  public Object GetFieldType(Object ... _p) {
    mVar strFormName = m$.newVarRef("strFormName",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar strFormFieldNo = m$.newVarRef("strFormFieldNo",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Given a form and one of its fields determine field type
    //<< ;
    //<< ; Called By : OnBlur^COMGridEdit31Events, OnSortGrid^COMGridEdit31Events,
    //<< ;             UpdateContainer^COMGridEdit31G, OnBeforeFormat^FINAPInvLineDisplay  ; Some already use Get^WWW122
    //<< ;
    //<< ; Returns: Field type
    //<< ;
    //<< ; History:
    //<< ; 19-Nov-2007   shobby  BR014790:Use standard routine to get InputType.
    //<< ; 29-Jun-2005   JW      We already have sequence number!
    //<< ; 18-Mar-2005   PO      SR11349 Created
    //<< ;-------------------------------------------------------------------------------
    //<< ; NOT SURE THAT WAY IN WHICH TYPE IS DETERMINED IS CORRECT 18-Mar-2005
    //<< new objWWW120,objWWW122,objWWW003,strFieldNo,strFieldType,strCur,strValue,strClass
    mVar objWWW120 = m$.var("objWWW120");
    mVar objWWW122 = m$.var("objWWW122");
    mVar objWWW003 = m$.var("objWWW003");
    mVar strFieldNo = m$.var("strFieldNo");
    mVar strFieldType = m$.var("strFieldType");
    mVar strCur = m$.var("strCur");
    mVar strValue = m$.var("strValue");
    mVar strClass = m$.var("strClass");
    m$.newVar(objWWW120,objWWW122,objWWW003,strFieldNo,strFieldType,strCur,strValue,strClass);
    //<< 
    //<< set objWWW122 = $$Get^WWW122(strFormName,strFormFieldNo)
    objWWW122.set(m$.fnc$("WWW122.Get",strFormName.get(),strFormFieldNo.get()));
    //<< quit $$$WWW122InputType(objWWW122)
    return include.WWWConst.$$$WWW122InputType(m$,objWWW122);
  }

  //<< 
  //<< 
  //<< GetDescription(pidClass,pstrFieldType="",pintClassField="")
  public Object GetDescription(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrFieldType = m$.newVarRef("pstrFieldType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pintClassField = m$.newVarRef("pintClassField",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Previous code has been moved to GetDescription^COMViewDescription
    //<< ; This routine only maintained in case there are any calls missed.
    //<< ; OldGetDescription deleted.  Can be recovered from SourceLogging if required.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Feb-2008   shobby      SRBR014900: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$GetDescription^COMViewDescription(pidClass,pstrFieldType,pintClassField)
    return m$.fnc$("COMViewDescription.GetDescription",pidClass.get(),pstrFieldType.get(),pintClassField.get());
  }

  //<< 
  //<< 
  //<< GetFromWWWFELDNAME(pidClass,&pidForm,pintClassField,&pintFormField="",pblnRecurse=$$$NO)
  public Object GetFromWWWFELDNAME(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintClassField = m$.newVarRef("pintClassField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintFormField = m$.newVarRef("pintFormField",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pblnRecurse = m$.newVarRef("pblnRecurse",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Only get information from WWWFELDNAME if there is a form field which matches this class field.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Dec-2007   GRF     SRBR014751: Should be WWW120s not WWW120
    //<< ; 19-Dec-2007   shobby  SRBR014751: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strDescription
    mVar strDescription = m$.var("strDescription");
    m$.newVar(strDescription);
    //<< 
    //<< set strDescription=""
    strDescription.set("");
    //<< if pblnRecurse {
    if (mOp.Logical(pblnRecurse.get())) {
      //<< set pidForm=$order(^WWW120s(0,1,$$$Index(pidClass),pidForm))
      pidForm.set(m$.Fnc.$order(m$.var("^WWW120s",0,1,include.COMConst.$$$Index(m$,pidClass),pidForm.get())));
    }
    //<< }
    //<< if pidForm'="" {
    if (mOp.NotEqual(pidForm.get(),"")) {
      //<< set pintFormField=""
      pintFormField.set("");
      //<< set pintFormField=$order(^WWW122s(0,4,pintClassField,pidForm,""))
      pintFormField.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,pintClassField.get(),pidForm.get(),"")));
      //<< if pintFormField'="" {
      if (mOp.NotEqual(pintFormField.get(),"")) {
        //<< set strDescription=$$^WWWFELDNAME(pidForm,"D",pintClassField)
        strDescription.set(m$.fnc$("WWWFELDNAME.main",pidForm.get(),"D",pintClassField.get()));
      }
    }
    //<< }
    //<< }
    //<< quit strDescription
    return strDescription.get();
  }

  //<< 
  //<< 
  //<< GetKey(pKey="",pNumToCheck,pNumToHave,&pidKeyPart1,&pidKeyPart2,&pidKeyPart3,&pidKeyPart4,&pidKeyPart5,&pidKeyPart6)
  public Object GetKey(Object ... _p) {
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pNumToCheck = m$.newVarRef("pNumToCheck",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pNumToHave = m$.newVarRef("pNumToHave",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidKeyPart1 = m$.newVarRef("pidKeyPart1",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pidKeyPart2 = m$.newVarRef("pidKeyPart2",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pidKeyPart3 = m$.newVarRef("pidKeyPart3",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pidKeyPart4 = m$.newVarRef("pidKeyPart4",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pidKeyPart5 = m$.newVarRef("pidKeyPart5",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar pidKeyPart6 = m$.newVarRef("pidKeyPart6",(((_p!=null)&&(_p.length>=9))?_p[8]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get / separate and verify key.
    //<< ;
    //<< ; Use pNumToCheck to inform procedure how many keys to validate
    //<< ;
    //<< ; Returns: $$$YES if all parts of key are valid, else $$$NO & subscript 0 is $$$YES if left over parts are valid else $$$NO
    //<< ;
    //<< ; History:
    //<< ; 26-Aug-2010   GRF     -: Show & for ByRef
    //<< ; 11-Jul-2005   PO      SR12881: included a third argument, make sure no more
    //<< ;                           than X key values (pNumToHave); also now
    //<< ;                           reporting error if pNumToCheck > intNumOfParts
    //<< ; 04-Jul-2005   PO      Switched over to use $$$NoKey
    //<< ; 30-Jun-2005   PO      Made pKey optional, added new arg - pNumToCheck and
    //<< ;                           result is now an array
    //<< ; 21-Jun-2005   PO      SR12595: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnExists,intCounter,intNumOfParts,tmp
    mVar blnExists = m$.var("blnExists");
    mVar intCounter = m$.var("intCounter");
    mVar intNumOfParts = m$.var("intNumOfParts");
    mVar tmp = m$.var("tmp");
    m$.newVar(blnExists,intCounter,intNumOfParts,tmp);
    //<< 
    //<< set blnExists    = $$$YES
    blnExists.set(include.COMSYS.$$$YES(m$));
    //<< set blnExists(0) = $$$YES
    blnExists.var(0).set(include.COMSYS.$$$YES(m$));
    //<< set intNumOfParts = $length(pKey,",")
    intNumOfParts.set(m$.Fnc.$length(pKey.get(),","));
    //<< if '$data(pNumToCheck) {
    if (mOp.Not(m$.Fnc.$data(pNumToCheck))) {
      //<< set pNumToCheck = intNumOfParts
      pNumToCheck.set(intNumOfParts.get());
    }
    //<< 
    //<< } else {
    else {
      //<< set pNumToCheck = +pNumToCheck
      pNumToCheck.set(mOp.Positive(pNumToCheck.get()));
      //<< if pNumToCheck > intNumOfParts set blnExists = $$$NO
      if (mOp.Greater(pNumToCheck.get(),intNumOfParts.get())) {
        blnExists.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< if $data(pNumToHave) {
    if (mOp.Logical(m$.Fnc.$data(pNumToHave))) {
      //<< if pNumToHave '= intNumOfParts set blnExists = $$$NO
      if (mOp.NotEqual(pNumToHave.get(),intNumOfParts.get())) {
        blnExists.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< 
    //<< for intCounter=1:1:intNumOfParts {
    for (intCounter.set(1);(mOp.LessOrEqual(intCounter.get(),intNumOfParts.get()));intCounter.set(mOp.Add(intCounter.get(),1))) {
      //<< set tmp = $piece(pKey,",",intCounter)
      tmp.set(m$.Fnc.$piece(pKey.get(),",",intCounter.get()));
      //<< if $$$NoKey(tmp) {
      if (mOp.Logical(include.COMSYS.$$$NoKey(m$,tmp))) {
        //<< set @("pidKeyPart"_intCounter) = ""
        m$.indirectVar((mOp.Concat("pidKeyPart",intCounter.get()))).set("");
        //<< set @("pidKeyPart"_intCounter_"(0)") = tmp
        m$.indirectVar((mOp.Concat(mOp.Concat("pidKeyPart",intCounter.get()),"(0)"))).set(tmp.get());
      }
      //<< 
      //<< } else {
      else {
        //<< set @("pidKeyPart"_intCounter) = tmp
        m$.indirectVar((mOp.Concat("pidKeyPart",intCounter.get()))).set(tmp.get());
      }
      //<< }
      //<< if (intCounter<=pNumToCheck) {
      if ((mOp.LessOrEqual(intCounter.get(),pNumToCheck.get()))) {
        //<< if $$$NoKey(tmp) set blnExists = $$$NO
        if (mOp.Logical(include.COMSYS.$$$NoKey(m$,tmp))) {
          blnExists.set(include.COMSYS.$$$NO(m$));
        }
      }
      //<< 
      //<< } else {
      else {
        //<< if $$$NoKey(tmp) set blnExists(0) = $$$NO
        if (mOp.Logical(include.COMSYS.$$$NoKey(m$,tmp))) {
          blnExists.var(0).set(include.COMSYS.$$$NO(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< quit blnExists
    return blnExists.get();
  }

  //<< 
  //<< 
  //<< GetRecord(strClass="",pidKey="",pobjRecord)
  public Object GetRecord(Object ... _p) {
    mVar strClass = m$.newVarRef("strClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pobjRecord = m$.newVarRef("pobjRecord",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets and validates a particular record.
    //<< ;
    //<< ; Returns: strStatus
    //<< ;
    //<< ; History:
    //<< ; 29-Jul-2005   PO      SR12850: Changed NoKey to $$GetKey as don't know number
    //<< ;                           of key values.
    //<< ; 26-Jul-2005   JW      SR13090: Added call to WWWKEYBUILD
    //<< ; 06-Jul-2005   PO      SR12881: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,strBaseKeyValue
    mVar strStatus = m$.var("strStatus");
    mVar strBaseKeyValue = m$.var("strBaseKeyValue");
    m$.newVar(strStatus,strBaseKeyValue);
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if '$$GetKey(pidKey,,$length(pidKey,",")) { ; $$$NoKey(pidKey)
    if (mOp.Not(m$.fnc$("GetKey",pidKey.get(),null,m$.Fnc.$length(pidKey.get(),",")))) {
      //<< set strStatus = $listbuild("Com00207")
      strStatus.set(m$.Fnc.$listbuild("Com00207"));
    }
    //<< ; "Please Select A Data Record First."
    //<< 
    //<< } elseif strClass="" {
    else if (mOp.Equal(strClass.get(),"")) {
      //<< set strStatus = $listbuild("Com00208")
      strStatus.set(m$.Fnc.$listbuild("Com00208"));
    }
    //<< ; "Must Specify Source To Retrieve Record From."
    //<< 
    //<< } else {
    else {
      //<< if '$$$WWW001SharedFile($get(^WWW001(0,strClass,1))) {
      if (mOp.Not(include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,strClass.get(),1))))) {
        //<< set strBaseKeyValue = "YM"
        strBaseKeyValue.set("YM");
      }
      //<< } else {
      else {
        //<< set strBaseKeyValue = "0"
        strBaseKeyValue.set("0");
      }
      //<< }
      //<< set pobjRecord = $get(@("^"_strClass_"("_strBaseKeyValue_","_$$^WWWKEYBUILD(pidKey)_",1)"))
      pobjRecord.set(m$.Fnc.$get(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",strClass.get()),"("),strBaseKeyValue.get()),","),m$.fnc$("WWWKEYBUILD.main",pidKey.get())),",1)")))));
      //<< if pobjRecord="" set strStatus = $listbuild("Com00209",pidKey)
      if (mOp.Equal(pobjRecord.get(),"")) {
        strStatus.set(m$.Fnc.$listbuild("Com00209",pidKey.get()));
      }
    }
    //<< } ; "Record ´%1´ is not defined."
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< Delete(pidClass)
  public Object Delete(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for DEL^WWWDLOE. @Net class deletion.
    //<< ;
    //<< ; Params:   pidClass - (mandatory) class to delete
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Apr-2006   JW      SR14429: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new VORGX,VORG,YQ
    mVar VORGX = m$.var("VORGX");
    mVar VORG = m$.var("VORG");
    mVar YQ = m$.var("YQ");
    m$.newVar(VORGX,VORG,YQ);
    //<< 
    //<< if $data(^WWW001(0,pidClass,1)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW001",0,pidClass.get(),1)))) {
      //<< set VORGX = pidClass
      VORGX.set(pidClass.get());
      //<< set VORG(2) = $$$YES
      VORG.var(2).set(include.COMSYS.$$$YES(m$));
      //<< set VORG(3) = $$$YES
      VORG.var(3).set(include.COMSYS.$$$YES(m$));
      //<< set YQ=1
      YQ.set(1);
      //<< do DEL^WWWDLOE
      m$.Cmd.Do("WWWDLOE.DEL");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< FindFieldType(pintDataType)
  public Object FindFieldType(Object ... _p) {
    mVar pintDataType = m$.newVarRef("pintDataType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Find class fields matching a particular data type (e.g. 4 = Integer)
    //<< ;
    //<< ;   CAVEAT : Doesn't consider form reassignment or Manual fields
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2007   GRF     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new count,idClass,intFldNo,intFldType,objClass,tab
    mVar count = m$.var("count");
    mVar idClass = m$.var("idClass");
    mVar intFldNo = m$.var("intFldNo");
    mVar intFldType = m$.var("intFldType");
    mVar objClass = m$.var("objClass");
    mVar tab = m$.var("tab");
    m$.newVar(count,idClass,intFldNo,intFldType,objClass,tab);
    //<< 
    //<< set pintDataType = +$get(pintDataType)
    pintDataType.set(mOp.Positive(m$.Fnc.$get(pintDataType)));
    //<< kill ^CacheTempCOMUtilClass("Type")
    m$.var("^CacheTempCOMUtilClass","Type").kill();
    //<< 
    //<< set tab = $char(9)
    tab.set(m$.Fnc.$char(9));
    //<< 
    //<< set idClass = ""
    idClass.set("");
    //<< for count=1:1 {
    for (count.set(1);(true);count.set(mOp.Add(count.get(),1))) {
      //<< set idClass = $order(^WWW001(0,idClass))
      idClass.set(m$.Fnc.$order(m$.var("^WWW001",0,idClass.get())));
      //<< quit:idClass=""
      if (mOp.Equal(idClass.get(),"")) {
        break;
      }
      //<< 
      //<< write:count#50=0 !,idClass
      if (mOp.Equal(mOp.Modulus(count.get(),50),0)) {
        m$.Cmd.Write("\n",idClass.get());
      }
      //<< 
      //<< set intFldNo = ""
      intFldNo.set("");
      //<< for {
      for (;true;) {
        //<< set intFldNo = $order(^WWW002(0,idClass,intFldNo))
        intFldNo.set(m$.Fnc.$order(m$.var("^WWW002",0,idClass.get(),intFldNo.get())));
        //<< quit:intFldNo=""
        if (mOp.Equal(intFldNo.get(),"")) {
          break;
        }
        //<< 
        //<< set objClass   = $get(^WWW002(0,idClass,intFldNo,1))
        objClass.set(m$.Fnc.$get(m$.var("^WWW002",0,idClass.get(),intFldNo.get(),1)));
        //<< set intFldType = $$$WWW002InputType(objClass)
        intFldType.set(include.WWWConst.$$$WWW002InputType(m$,objClass));
        //<< if intFldType = pintDataType {
        if (mOp.Equal(intFldType.get(),pintDataType.get())) {
          //<< set ^CacheTempCOMUtilClass("Type",idClass,2,intFldNo) = $$$WWW002PropertyDescription(objClass)_tab_$$$WWW002RelationClass(objClass)
          m$.var("^CacheTempCOMUtilClass","Type",idClass.get(),2,intFldNo.get()).set(mOp.Concat(mOp.Concat(include.WWWConst.$$$WWW002PropertyDescription(m$,objClass),tab.get()),include.WWWConst.$$$WWW002RelationClass(m$,objClass)));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< set intFldNo = ""
      intFldNo.set("");
      //<< for {
      for (;true;) {
        //<< set intFldNo = $order(^WWW003(0,idClass,intFldNo))
        intFldNo.set(m$.Fnc.$order(m$.var("^WWW003",0,idClass.get(),intFldNo.get())));
        //<< quit:intFldNo=""
        if (mOp.Equal(intFldNo.get(),"")) {
          break;
        }
        //<< 
        //<< set objClass   = $get(^WWW003(0,idClass,intFldNo,1))
        objClass.set(m$.Fnc.$get(m$.var("^WWW003",0,idClass.get(),intFldNo.get(),1)));
        //<< set intFldType = $$$WWW003InputType(objClass)
        intFldType.set(include.WWWConst.$$$WWW003InputType(m$,objClass));
        //<< if intFldType = pintDataType {
        if (mOp.Equal(intFldType.get(),pintDataType.get())) {
          //<< set ^CacheTempCOMUtilClass("Type",idClass,3,intFldNo) = $$$WWW003PropertyDescription(objClass)_tab_$$$WWW003RelationDatabase(objClass)
          m$.var("^CacheTempCOMUtilClass","Type",idClass.get(),3,intFldNo.get()).set(mOp.Concat(mOp.Concat(include.WWWConst.$$$WWW003PropertyDescription(m$,objClass),tab.get()),include.WWWConst.$$$WWW003RelationDatabase(m$,objClass)));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< write !!
    m$.Cmd.Write("\n","\n");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DisplayFieldType
  public void DisplayFieldType() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; 1.    d FindFieldType^COMUtilClass(4)        ; e.g. if checking for integers
    //<< ; 2.    Open logging file
    //<< ; 3.    d DisplayFieldType^COMUtilClass
    //<< ; 4.    Close logging file
    //<< ; 5.    Open Logging file in Word/Excel/etc.
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2007   GRF     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,intDataType,intFldNo,strDataType,tab
    mVar idClass = m$.var("idClass");
    mVar intDataType = m$.var("intDataType");
    mVar intFldNo = m$.var("intFldNo");
    mVar strDataType = m$.var("strDataType");
    mVar tab = m$.var("tab");
    m$.newVar(idClass,intDataType,intFldNo,strDataType,tab);
    //<< 
    //<< set tab = $char(9)
    tab.set(m$.Fnc.$char(9));
    //<< 
    //<< set idClass = ""
    idClass.set("");
    //<< for {
    for (;true;) {
      //<< set idClass = $order(^CacheTempCOMUtilClass("Type",idClass))
      idClass.set(m$.Fnc.$order(m$.var("^CacheTempCOMUtilClass","Type",idClass.get())));
      //<< quit:idClass=""
      if (mOp.Equal(idClass.get(),"")) {
        break;
      }
      //<< 
      //<< set intDataType = ""
      intDataType.set("");
      //<< for {
      for (;true;) {
        //<< set intDataType = $order(^CacheTempCOMUtilClass("Type",idClass,intDataType))
        intDataType.set(m$.Fnc.$order(m$.var("^CacheTempCOMUtilClass","Type",idClass.get(),intDataType.get())));
        //<< quit:intDataType=""
        if (mOp.Equal(intDataType.get(),"")) {
          break;
        }
        //<< 
        //<< set strDataType = $select(intDataType=2:"P",1:"D")
        strDataType.set(m$.Fnc.$select(mOp.Equal(intDataType.get(),2),"P",1,"D"));
        //<< set intFldNo = ""
        intFldNo.set("");
        //<< for {
        for (;true;) {
          //<< set intFldNo = $order(^CacheTempCOMUtilClass("Type",idClass,intDataType,intFldNo))
          intFldNo.set(m$.Fnc.$order(m$.var("^CacheTempCOMUtilClass","Type",idClass.get(),intDataType.get(),intFldNo.get())));
          //<< quit:intFldNo=""
          if (mOp.Equal(intFldNo.get(),"")) {
            break;
          }
          //<< 
          //<< write !,idClass,tab,strDataType,intFldNo,tab,^CacheTempCOMUtilClass("Type",idClass,intDataType,intFldNo)
          m$.Cmd.Write("\n",idClass.get(),tab.get(),strDataType.get(),intFldNo.get(),tab.get(),m$.var("^CacheTempCOMUtilClass","Type",idClass.get(),intDataType.get(),intFldNo.get()).get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return;
  }

//<< 
//<< 
}
