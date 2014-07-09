//*****************************************************************************
//** TASC - ALPHALINC - MAC COMGridEdit31Save
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-02 13:07:57
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
//<< #include WWWConst
import include.WWWConst;
//<< #include COMGridEdit31
import include.COMGridEdit31;

//<< COMGridEdit31Save
public class COMGridEdit31Save extends mClass {

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogRx(%1)       ;
  public static Object $$$LogRx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogRm(%1)       ;
  public static Object $$$LogRm(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _COMGridEdit31Save();
  }

  public void _COMGridEdit31Save() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^COMGridEdit31Save("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< SAVE(pYKEY,pYFORM="",pblnForceValidate=$$$NO) ;SR17910
  public Object SAVE(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnForceValidate = m$.newVarRef("pblnForceValidate",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Save the lines of the grid, needs to report a status if the saves fail.
    //<< ;
    //<< ; Call as : $$$GRIDSave(%args)
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Feb-2012   GRF     SR17910.1: get today once; use loop
    //<< ; 15-Nov-2011   shobby  SR17910: pblnForceValidate causes record to be validated
    //<< ;                           during save even if unchanged.
    //<< ; 01-Dec-2009   GRF     SR17007: separate tags for multi-lock operations
    //<< ; 11-Mar-2009   HQN     AdHoc: Validate against specified grid not active grid
    //<< ; 15-Oct-2008   GRF     SR15810: Purge older change comments from code
    //<< ; 06-Mar-2007   PO      SR15466: Support case where header does not relate to lines
    //<< ; 03-Jan-2007   RPW     SR15340: Do not pass functions into macros, this one bad.
    //<< ; 19-Oct-2006   JW      SR15134: Look at kill status
    //<< ; 26-Jun-2006   JW      SR12775: Pass YFELD into Validate
    //<< ; 15-May-2006   JW      SR14433: Make sure same key! (Bank Rec stuffed it)
    //<< ; 08-May-2006   Steve S SR14508: Check multi-locking
    //<< ; 31-Oct-2005   JW      SR13207: Changed save check
    //<< ; 19-Oct-2005   JW      SR13581: Save all grids
    //<< ; 30-Sep-2005   JW      SR11573: Just pass in line, not field.
    //<< ; 26-Jul-2005   shobby  SR13054: Treats a line with only default values as if it
    //<< ;                           was blank and removes when saving.
    //<< ; 04-Jul-2005   RobertW SR12527: Fixed Status usage for ReturnError
    //<< ; 24-Jun-2005   JW      SR12409: But only if key is a counter.
    //<< ; 21-Jun-2005   shobby  Ignore any blank lines. SR12409.
    //<< ; 31-Mar-2005   shobby  Proper use of YFORM and YDATEI
    //<< ; 28-Feb-2005   JW      Added . to YFELD in OnBeforeSave call. Check objDisc for
    //<< ;                           undefined.
    //<< ; 01-Feb-2005   JW      Delete "KILLEDRECORD's now
    //<< ; 02-Dec-2004   PO      SR11074 Enable save for composite key
    //<< ; 02-Dec-2004   PO      SR11067 Enable save for more than just parent/child
    //<< ;                           forms ie. grandparent...
    //<< ; 30-Nov-2004   shobby  Moved OnBeforeSave before Validate.
    //<< ; 22-Nov-2004   Shobby  Created (SR10468)
    //<< ;-------------------------------------------------------------------------------
    //<< new dteToday,idCell,idColumn,idContainer,idForm,idKey,idLine,loop,lstLinks
    mVar dteToday = m$.var("dteToday");
    mVar idCell = m$.var("idCell");
    mVar idColumn = m$.var("idColumn");
    mVar idContainer = m$.var("idContainer");
    mVar idForm = m$.var("idForm");
    mVar idKey = m$.var("idKey");
    mVar idLine = m$.var("idLine");
    mVar loop = m$.var("loop");
    mVar lstLinks = m$.var("lstLinks");
    m$.newVar(dteToday,idCell,idColumn,idContainer,idForm,idKey,idLine,loop,lstLinks);
    //<< new origYFELD,strKey,strLockStatus,strStatus,Q,YDATEI,YFELD,YFORM,YKEY,YVOR
    mVar origYFELD = m$.var("origYFELD");
    mVar strKey = m$.var("strKey");
    mVar strLockStatus = m$.var("strLockStatus");
    mVar strStatus = m$.var("strStatus");
    mVar Q = m$.var("Q");
    mVar YDATEI = m$.var("YDATEI");
    mVar YFELD = m$.var("YFELD");
    mVar YFORM = m$.var("YFORM");
    mVar YKEY = m$.var("YKEY");
    mVar YVOR = m$.var("YVOR");
    m$.newVar(origYFELD,strKey,strLockStatus,strStatus,Q,YDATEI,YFELD,YFORM,YKEY,YVOR);
    //<< 
    //<< $$$LogR("SAVE",pYKEY_","_pYFORM)
    $$$LogR(m$,"SAVE",mOp.Concat(mOp.Concat(pYKEY.get(),","),pYFORM.get()));
    //<< 
    //<< quit:pYKEY'=$$$GRIDYKEYContainer $$$OK      ; Make sure same key
    if (mOp.NotEqual(pYKEY.get(),include.COMGridEdit31Interface.$$$GRIDYKEYContainer(m$))) {
      return include.COMSYS.$$$OK(m$);
    }
    //<< 
    //<< set dteToday    = +$horolog   ; SR17910.1
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< set Q           = 0
    Q.set(0);
    //<< set strStatus   = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idContainer = $$$GRIDContainer
    idContainer.set(include.COMGridEdit31Interface.$$$GRIDContainer(m$));
    //<< 
    //<< if pYFORM="" {
    if (mOp.Equal(pYFORM.get(),"")) {
      //<< if idContainer'="" {
      if (mOp.NotEqual(idContainer.get(),"")) {
        //<< set idForm = ""
        idForm.set("");
        //<< for {
        for (;true;) {
          //<< set idForm = $order(^WWWDATEN(0,dteToday,YUSER,idContainer,"Grid",idForm))
          idForm.set(m$.Fnc.$order(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),idContainer.get(),"Grid",idForm.get())));
          //<< quit:idForm=""
          if (mOp.Equal(idForm.get(),"")) {
            break;
          }
          //<< 
          //<< set strStatus = $$SAVE(pYKEY,idForm,pblnForceValidate) ;SR17910
          strStatus.set(m$.fnc$("SAVE",pYKEY.get(),idForm.get(),pblnForceValidate.get()));
          //<< quit:$$$ISERR(strStatus)
          if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
            break;
          }
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set YFORM = pYFORM
      YFORM.set(pYFORM.get());
      //<< 
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< tstart
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< 
      //<< set YDATEI = $$$GRIDClass(YFORM)
      YDATEI.set(include.COMGridEdit31.$$$GRIDClass(m$,YFORM));
      //<< if YDATEI'="" {
      if (mOp.NotEqual(YDATEI.get(),"")) {
        //<< set idKey = ""
        idKey.set("");
        //<< for {
        for (;true;) {
          //<< set idKey = $order(^WWWDATEN(0,dteToday,YUSER,YFORM,"V","REFERENCEKEY",idKey))
          idKey.set(m$.Fnc.$order(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),YFORM.get(),"V","REFERENCEKEY",idKey.get())));
          //<< quit:(idKey="")||$$$ISERR(strStatus)
          if ((mOp.Equal(idKey.get(),"")) || mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
            break;
          }
          //<< 
          //<< set strKey = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"V","REFERENCEKEY",idKey,1))
          strKey.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),YFORM.get(),"V","REFERENCEKEY",idKey.get(),1)));
          //<< set idLine = $piece(strKey,",",$length(pYKEY,",")+1,$length(strKey,","))
          idLine.set(m$.Fnc.$piece(strKey.get(),",",mOp.Add(m$.Fnc.$length(pYKEY.get(),","),1),m$.Fnc.$length(strKey.get(),",")));
          //<< if idLine = "" {
          if (mOp.Equal(idLine.get(),"")) {
            //<< set idLine = $piece(strKey,",",$length(strKey,","))
            idLine.set(m$.Fnc.$piece(strKey.get(),",",m$.Fnc.$length(strKey.get(),",")));
            //<< set YKEY   = idLine
            YKEY.set(idLine.get());
          }
          //<< 
          //<< } else {
          else {
            //<< set YKEY   = pYKEY_","_idLine
            YKEY.set(mOp.Concat(mOp.Concat(pYKEY.get(),","),idLine.get()));
          }
          //<< }
          //<< 
          //<< ; Skip this line if we don't "own" it
          //<< if pYKEY = "" {
          if (mOp.Equal(pYKEY.get(),"")) {
            //<< set strKey = $$Key(idContainer)
            strKey.set(m$.fnc$("Key",idContainer.get()));
            //<< if strKey = "" {
            if (mOp.Equal(strKey.get(),"")) {
            }
            //<< ztrap "EGER"  ; Header class is not a structure that is supported.
            //<< ; TODO : Document where error trapping is redirected.
            //<< } else {
            else {
              //<< set strLockStatus = $$GetLock^WWWMultiLock(idContainer,YFORM,strKey_","_YKEY)
              strLockStatus.set(m$.fnc$("WWWMultiLock.GetLock",idContainer.get(),YFORM.get(),mOp.Concat(mOp.Concat(strKey.get(),","),YKEY.get())));
            }
          }
          //<< }
          //<< 
          //<< } else {
          else {
            //<< set strLockStatus = $$GetLock^WWWMultiLock(idContainer,YFORM,YKEY)
            strLockStatus.set(m$.fnc$("WWWMultiLock.GetLock",idContainer.get(),YFORM.get(),YKEY.get()));
          }
          //<< }
          //<< continue:$$$ISERR(strLockStatus)
          if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strLockStatus))) {
            continue;
          }
          //<< 
          //<< set YFELD = $$GetYFELD^COMGridEdit31G(YFORM,idKey,$$$YES,.origYFELD)
          YFELD.set(m$.fnc$("COMGridEdit31G.GetYFELD",YFORM.get(),idKey.get(),include.COMSYS.$$$YES(m$),origYFELD));
          //<< 
          //<< $$$LogRx("SAVE:1:"_$get(origYFELD)_"<"_idKey)
          $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat("SAVE:1:",m$.Fnc.$get(origYFELD)),"<"),idKey.get()));
          //<< $$$LogRx("SAVE:2:"_YFELD)
          $$$LogRx(m$,mOp.Concat("SAVE:2:",YFELD.get()));
          //<< 
          //<< if '$$$KilledRecord(idKey,YFORM) {
          if (mOp.Not(include.COMGridEdit31.$$$KilledRecord(m$,idKey,YFORM))) {
            //<< if pblnForceValidate || '$data(origYFELD) || (YFELD'=origYFELD) { ;SR17910
            if (mOp.Logical(pblnForceValidate.get()) || mOp.Not(m$.Fnc.$data(origYFELD)) || (mOp.NotEqual(YFELD.get(),origYFELD.get()))) {
              //<< set YVOR = $$$GRIDYVOR(YFORM)
              YVOR.set(include.COMGridEdit31.$$$GRIDYVOR(m$,YFORM));
              //<< $$$LogRx("SAVE:3:"_YVOR)
              $$$LogRx(m$,mOp.Concat("SAVE:3:",YVOR.get()));
              //<< set strStatus = $$OnBeforeSave^COMGridEdit31Events(YKEY,.YFELD,YVOR)                        ; *** EXECUTE *** (from Form)
              strStatus.set(m$.fnc$("COMGridEdit31Events.OnBeforeSave",YKEY.get(),YFELD,YVOR.get()));
              //<< $$$LogRx("SAVE:4:"_YFELD)
              $$$LogRx(m$,mOp.Concat("SAVE:4:",YFELD.get()));
              //<< 
              //<< if $$$ISOK(strStatus) {
              if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
                //<< ; if pYFORM specified different from active grid, Validate assumes trigger is on first grid,
                //<< ; will fail SPEI check since it really already has been saved
                //<< set strStatus = $$Validate("Y"_idKey,.YFELD,$$$NO,YFORM)
                strStatus.set(m$.fnc$("Validate",mOp.Concat("Y",idKey.get()),YFELD,include.COMSYS.$$$NO(m$),YFORM.get()));
                //<< $$$LogRx("SAVE:5:"_YFELD)
                $$$LogRx(m$,mOp.Concat("SAVE:5:",YFELD.get()));
                //<< if $$$ISOK(strStatus) {
                if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
                  //<< if Q=$$$QSave {
                  if (mOp.Equal(Q.get(),include.COMSYSWWW.$$$QSave(m$))) {
                    //<< set strStatus = $$^WWWSPEI(YDATEI,YKEY,YFELD,$$$YES)                          ; *** EXECUTE *** (Class Save Hooks)
                    strStatus.set(m$.fnc$("WWWSPEI.main",YDATEI.get(),YKEY.get(),YFELD.get(),include.COMSYS.$$$YES(m$)));
                    //<< if $$$ISOK(strStatus) do OnAfterSave^COMGridEdit31Events(YKEY,YFELD,YVOR)     ; *** EXECUTE *** (from Form)
                    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
                      m$.Cmd.Do("COMGridEdit31Events.OnAfterSave",YKEY.get(),YFELD.get(),YVOR.get());
                    }
                  }
                  //<< } else {
                  else {
                    //<< set strStatus = $listbuild("Com00206","tdY"_idKey_"_1")
                    strStatus.set(m$.Fnc.$listbuild("Com00206",mOp.Concat(mOp.Concat("tdY",idKey.get()),"_1")));
                  }
                }
              }
            }
          }
          //<< } ; "Validation Failed for %1."  ; FIXME : MakeStatus?
          //<< }
          //<< }
          //<< }
          //<< } else {
          else {
            //<< set strStatus = $$$Kill(YDATEI,YKEY)
            strStatus.set(include.COMSYS.$$$Kill(m$,YDATEI,YKEY));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if $$$ISOK(strStatus) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
          //<< set lstLinks = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"V","LINKS"))
          lstLinks.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),YFORM.get(),"V","LINKS")));
          //<< for loop=1:1:$length(lstLinks,";") {
          for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(lstLinks.get(),";")));loop.set(mOp.Add(loop.get(),1))) {
            //<< quit:$$$ISERR(strStatus)
            if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
              break;
            }
            //<< 
            //<< set YFORM = $piece(lstLinks,";",loop)
            YFORM.set(m$.Fnc.$piece(lstLinks.get(),";",loop.get()));
            //<< if YFORM'="" {
            if (mOp.NotEqual(YFORM.get(),"")) {
              //<< set strStatus = $$SAVE(pYKEY,YFORM)
              strStatus.set(m$.fnc$("SAVE",pYKEY.get(),YFORM.get()));
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< if $tlevel>0 tcommit
        if (mOp.Greater(m$.Fnc.$tlevel(),0)) {
        }
      }
      //<< } else {
      else {
      }
    }
    //<< trollback
    //<< }
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< Validate(pYLFDAT,&YFELD,pblnRunOnBeforeSave=$$$NO,pYFORM="")
  public Object Validate(Object ... _p) {
    mVar pYLFDAT = m$.newVarRef("pYLFDAT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnRunOnBeforeSave = m$.newVarRef("pblnRunOnBeforeSave",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Validate the grid.
    //<< ;
    //<< ; Called By : SAVE^COMGridEdit31Save, ^COMGridEdit31R
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Jun-2012   SCR     SR17993 Added On Before Validation hook
    //<< ; 11-Mar-2009   HQN     AdHoc: Added 4th parameter, checks the specified grid
    //<< ;                           instead of the active grid. This is required when
    //<< ;                           called from SAVE^COMGridEdit31Save() when validating
    //<< ;                           all grids for a header.
    //<< ; 14-Oct-2008   GRF     SR15810: unused variable cleanup in new list
    //<< ; 13-Oct-2008   GRF     SR15810: Don't apply validation to INWEINVELINE since
    //<< ;                           "Original" WWWDATEN record is modified to blank out
    //<< ;                           one of the quantities - special processing.
    //<< ; 29-Aug-2008   FIS     SR15828: Compare loaded data with disc data and cancel
    //<< ;                           save if not equal
    //<< ; 10-Aug-2006   JW      SR13594: Clean up. Use encapsulated code.
    //<< ; 27-Jun-2006   JW      SR13755: Rewrote (removed obsolete code). Add line
    //<< ;                           number to msg
    //<< ; 26-Jun-2006   JW      SR12775: Added YFELD param. Removed single cell check.
    //<< ; 08-Nov-2005   shobby  SR13804: For an additional charge line, get the linked
    //<< ;                           YFORM
    //<< ; 08-Nov-2005   shobby/JW   SR13804: Don't attempt validation on additional
    //<< ;                           charge lines.  Not yet supported; can lead to errors
    //<< ; 31-Oct-2005   JW      SR13207: Check is done outside routine
    //<< ; 30-Sep-2005   JW      SR11573: Only validate single field if appropriate
    //<< ; 04-Jul-2005   RPW     SR12527: Fixed Status usage for ReturnError
    //<< ; 24-Jun-2005   JW      SR12409: But only if key is a counter.
    //<< ; 21-Jun-2005   shobby  Ignore any blank lines. SR12409.
    //<< ; 14-Apr-2005   PK      SR12136: Un-commented onbeforesave code and added param
    //<< ;                           to run it conditionally
    //<< ; 17-Feb-2005   JW      Don't return strStatus if have message
    //<< ; 25-Nov-2004   Shobby  Created (SR10468)
    //<< ;-------------------------------------------------------------------------------
    //<< new idLine,intLast,objOrgData,objSrcData,objTempData
    mVar idLine = m$.var("idLine");
    mVar intLast = m$.var("intLast");
    mVar objOrgData = m$.var("objOrgData");
    mVar objSrcData = m$.var("objSrcData");
    mVar objTempData = m$.var("objTempData");
    m$.newVar(idLine,intLast,objOrgData,objSrcData,objTempData);
    //<< new strMessage,strStatus,YDATEI,YFORM,YI,YKEY,YRETVAL,YVOR
    mVar strMessage = m$.var("strMessage");
    mVar strStatus = m$.var("strStatus");
    mVar YDATEI = m$.var("YDATEI");
    mVar YFORM = m$.var("YFORM");
    mVar YI = m$.var("YI");
    mVar YKEY = m$.var("YKEY");
    mVar YRETVAL = m$.var("YRETVAL");
    mVar YVOR = m$.var("YVOR");
    m$.newVar(strMessage,strStatus,YDATEI,YFORM,YI,YKEY,YRETVAL,YVOR);
    //<< 
    //<< $$$LogR("Validate",pYFORM_","_pYLFDAT)
    $$$LogR(m$,"Validate",mOp.Concat(mOp.Concat(pYFORM.get(),","),pYLFDAT.get()));
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idLine    = $piece($piece(pYLFDAT,"Y",2),"_",1)
    idLine.set(m$.Fnc.$piece(m$.Fnc.$piece(pYLFDAT.get(),"Y",2),"_",1));
    //<< 
    //<< if pYFORM'="" {
    if (mOp.NotEqual(pYFORM.get(),"")) {
      //<< set YFORM = pYFORM
      YFORM.set(pYFORM.get());
    }
    //<< } else {
    else {
      //<< set YFORM = $get(^CacheTemp(YUSER,"Grid","Name"))
      YFORM.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    }
    //<< }
    //<< set YFORM = $$GetYFORMFromLine^COMGridEdit31Interface(YFORM,idLine)
    YFORM.set(m$.fnc$("COMGridEdit31Interface.GetYFORMFromLine",YFORM.get(),idLine.get()));
    //<< 
    //<< if YFORM'="" {
    if (mOp.NotEqual(YFORM.get(),"")) {
      //<< set YDATEI = $$$GRIDClass(YFORM)
      YDATEI.set(include.COMGridEdit31.$$$GRIDClass(m$,YFORM));
      //<< set YKEY   = $translate($get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"V","REFERENCEKEY",idLine,1)),$$$DBLQUOTE)
      YKEY.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V","REFERENCEKEY",idLine.get(),1)),include.COMSYSString.$$$DBLQUOTE(m$)));
      //<< if YKEY'="" {
      if (mOp.NotEqual(YKEY.get(),"")) {
        //<< $$$SetFocusField(pYLFDAT)       // To get the correct line in focus for validation
        include.COMGridEdit31.$$$SetFocusField(m$,pYLFDAT);
        //<< 
        //<< set YVOR = $$$GRIDYVOR(YFORM)
        YVOR.set(include.COMGridEdit31.$$$GRIDYVOR(m$,YFORM));
        //<< set strMessage = ""
        strMessage.set("");
        //<< 
        //<< ; FIXME : $translate should be replaced with "set both to number of
        //<< ;         pieces in longest and then compare without $tr" since
        //<< ;         "...~a~1~~~~b~..." and "...~a~~~~1~b~..." (e.g. YES/NO
        //<< ;         switches that have been reset by another user) would
        //<< ;         appear to be the same.  "...a1b...")               <GRF>
        //<< 
        //<< // vvvv  ;compare loaded data with saved data //SR15828
        //<< set objTempData = $$GetYFELD^COMGridEdit31G(YFORM,idLine,$$$YES,.objOrgData,$$$YES,.objSrcData)
        objTempData.set(m$.fnc$("COMGridEdit31G.GetYFELD",YFORM.get(),idLine.get(),include.COMSYS.$$$YES(m$),objOrgData,include.COMSYS.$$$YES(m$),objSrcData));
        //<< ; FIXME.  Some issues with decimal places related with SR16478
        //<< if ($get(objSrcData) '= "")                               &&
        //<< ($get(objOrgData) '= "")                               &&
        //<< ($translate(objSrcData,Y) '= $translate(objOrgData,Y))    {  //saved data '= loaded data
        if ((mOp.NotEqual(m$.Fnc.$get(objSrcData),"")) && (mOp.NotEqual(m$.Fnc.$get(objOrgData),"")) && (mOp.NotEqual(m$.Fnc.$translate(objSrcData.get(),m$.var("Y").get()),m$.Fnc.$translate(objOrgData.get(),m$.var("Y").get())))) {
          //<< 
          //<< $$$LogR("Validate::",YFORM_","_idLine_","_YKEY)
          $$$LogR(m$,"Validate::",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YFORM.get(),","),idLine.get()),","),YKEY.get()));
          //<< $$$LogR("Validate:onDisk:",objSrcData)
          $$$LogR(m$,"Validate:onDisk:",objSrcData);
          //<< $$$LogR("Validate:before:",objOrgData)
          $$$LogR(m$,"Validate:before:",objOrgData);
          //<< $$$LogR("Validate:after :",objTempData)
          $$$LogR(m$,"Validate:after :",objTempData);
          //<< set strMessage = $$$Text("Com00318")  ;The data has been changed by another user. Please re-load the form.
          strMessage.set(include.COMSYS.$$$Text(m$,"Com00318"));
        }
        //<< }
        //<< //^^^^
        //<< if YFORM = "INWEINVELINE" set strMessage = ""      ; SR15810 TEMPORARY EXCEPTION TO SR15828 - reset even if different
        if (mOp.Equal(YFORM.get(),"INWEINVELINE")) {
          strMessage.set("");
        }
        //<< 
        //<< do ExecuteHook^WWW001Hook($$$GetClass(YFORM),$$$EnumWWWEVENTTYPEOnBeforeValidation,.YKEY,.YFELD,YFORM)   ; SR17993
        m$.Cmd.Do("WWW001Hook.ExecuteHook",include.COMSYSWWW.$$$GetClass(m$,YFORM),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeValidation(m$),YKEY,YFELD,YFORM.get());
        //<< 
        //<< 
        //<< if (strMessage = "") {  //SR15828
        if ((mOp.Equal(strMessage.get(),""))) {
          //<< $$$LogRx("Validate:DataFields:1:"_YFELD)
          $$$LogRx(m$,mOp.Concat("Validate:DataFields:1:",YFELD.get()));
          //<< set strMessage = $$DataFields^WWWFORMValidation(YDATEI,YFORM,.YFELD)
          strMessage.set(m$.fnc$("WWWFORMValidation.DataFields",YDATEI.get(),YFORM.get(),YFELD));
          //<< $$$LogRx("Validate:DataFields:2:"_YFELD_"<"_strMessage)
          $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat("Validate:DataFields:2:",YFELD.get()),"<"),strMessage.get()));
          //<< 
          //<< if pblnRunOnBeforeSave {
          if (mOp.Logical(pblnRunOnBeforeSave.get())) {
            //<< set strStatus = $$OnBeforeSave^COMGridEdit31Events(YKEY,YFELD,YVOR)
            strStatus.set(m$.fnc$("COMGridEdit31Events.OnBeforeSave",YKEY.get(),YFELD.get(),YVOR.get()));
            //<< if $$$ISERR(strStatus) {
            if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
              //<< set strMessage = strMessage_$$$Text(strStatus)
              strMessage.set(mOp.Concat(strMessage.get(),include.COMSYS.$$$Text(m$,strStatus)));
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< 
        //<< if strMessage'="" {   ; Get the last key name so can say which "line" has failed.
        if (mOp.NotEqual(strMessage.get(),"")) {
          //<< set intLast   = $length(YKEY,",")
          intLast.set(m$.Fnc.$length(YKEY.get(),","));
          //<< set strStatus = $listbuild("Com00205",
          //<< $get(^CacheTemp(YUSER,"Grid","KeyName",intLast))_" "_$piece(YKEY,",",intLast),
          //<< $$$CRLF_strMessage)     ; "%1 - Cannot Save %2"      ; eg. Line 1
          strStatus.set(m$.Fnc.$listbuild("Com00205",mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","KeyName",intLast.get()))," "),m$.Fnc.$piece(YKEY.get(),",",intLast.get())),mOp.Concat(include.COMSYSString.$$$CRLF(m$),strMessage.get())));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< Key(pidForm="",pidClass="")
  public Object Key(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Given a form or class return a key for the current state. At the moment can only
    //<< ; think of company and site location that is able to be used.
    //<< ;
    //<< ; If class includes keys that can not be handled returned value is blank
    //<< ;
    //<< ; Params:
    //<< ; pidForm - Form Id
    //<< ; pidClass - Class Id
    //<< ;
    //<< ; Returns: Either key string or blank.
    //<< ;
    //<< ; History:
    //<< ; 08-Mar-2007   PO      SR15466: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnClear,idClass,idKey,idRelationClass,objForm,objKey,strKey
    mVar blnClear = m$.var("blnClear");
    mVar idClass = m$.var("idClass");
    mVar idKey = m$.var("idKey");
    mVar idRelationClass = m$.var("idRelationClass");
    mVar objForm = m$.var("objForm");
    mVar objKey = m$.var("objKey");
    mVar strKey = m$.var("strKey");
    m$.newVar(blnClear,idClass,idKey,idRelationClass,objForm,objKey,strKey);
    //<< 
    //<< quit:(pidForm="")&&(pidClass="") ""
    if ((mOp.Equal(pidForm.get(),"")) && (mOp.Equal(pidClass.get(),""))) {
      return "";
    }
    //<< 
    //<< if pidClass = "" {
    if (mOp.Equal(pidClass.get(),"")) {
      //<< set objForm = $get(^WWW120(0,pidForm,1))
      objForm.set(m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1)));
      //<< set idClass = $$$WWW120ClassUsedInForm(objForm)
      idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objForm));
    }
    //<< 
    //<< } else {
    else {
      //<< set idClass = pidClass
      idClass.set(pidClass.get());
    }
    //<< }
    //<< 
    //<< set strKey   = ""
    strKey.set("");
    //<< set blnClear = $$$NO
    blnClear.set(include.COMSYS.$$$NO(m$));
    //<< set idKey    = ""
    idKey.set("");
    //<< for {
    for (;true;) {
      //<< set idKey = $order(^WWW002(0,idClass,idKey))
      idKey.set(m$.Fnc.$order(m$.var("^WWW002",0,idClass.get(),idKey.get())));
      //<< quit:idKey=""
      if (mOp.Equal(idKey.get(),"")) {
        break;
      }
      //<< 
      //<< set objKey = $get(^WWW002(0,idClass,idKey,1))
      objKey.set(m$.Fnc.$get(m$.var("^WWW002",0,idClass.get(),idKey.get(),1)));
      //<< set idRelationClass = $$$WWW002RelationClass(objKey)
      idRelationClass.set(include.WWWConst.$$$WWW002RelationClass(m$,objKey));
      //<< if idRelationClass = "WWW012" {
      if (mOp.Equal(idRelationClass.get(),"WWW012")) {
        //<< set strKey = strKey_"0,"
        strKey.set(mOp.Concat(strKey.get(),"0,"));
      }
      //<< 
      //<< } elseif idRelationClass = "WWW0121" {
      else if (mOp.Equal(idRelationClass.get(),"WWW0121")) {
        //<< set strKey = strKey_YLOCATION_$$$COMMA
        strKey.set(mOp.Concat(mOp.Concat(strKey.get(),m$.var("YLOCATION").get()),include.COMSYSString.$$$COMMA(m$)));
      }
      //<< 
      //<< } else {
      else {
        //<< set blnClear = $$$YES
        blnClear.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if blnClear {
    if (mOp.Logical(blnClear.get())) {
      //<< set strKey = ""
      strKey.set("");
    }
    //<< } else {
    else {
      //<< set strKey = $extract(strKey,1,$length(strKey)-1)
      strKey.set(m$.Fnc.$extract(strKey.get(),1,mOp.Subtract(m$.Fnc.$length(strKey.get()),1)));
    }
    //<< }
    //<< quit strKey
    return strKey.get();
  }

//<< 
//<< 
}
