//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWKILL
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:42
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

//<< WWWKILL(YDATEI,YKEY,YEINMAL)
public class WWWKILL extends mClass {

  public Object main(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YEINMAL = m$.newVarRef("YEINMAL",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return _WWWKILL(YDATEI,YKEY,YEINMAL);
  }

  public Object _WWWKILL(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YEINMAL = m$.newVarRef("YEINMAL",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       LOESCHEN SATZ
    //<< ;   D ^WWWKILL(YDATEI,YKEY) ACHTUNG YFORM BEACHTEN GGF NEW
    //<< ;   D SUBKILL^WWWKILL = wenn bei execute nach löschen die sub Formdaten
    //<< ;                       ebenfalls gelöscht werden sollen
    //<< ;
    //<< ; Inputs :
    //<< ;   YDATEI      YDATEI
    //<< ;   YKEY        SCHLUESSEL KEY1,KEY2,KEYn
    //<< ;   YEINMAL=1   UNTERWERFEN SIE NICHT ZU DCM WIEDER
    //<< ;               Once Only - Do not resubmit to DCM  ;GRF;SR11363;10.01.2005
    //<< ;
    //<< ; NOTE : Performs Transaction processing TSTART/TCOMMIT - Take care if
    //<< ;        called from within another such block.
    //<< ;        Deletion failures are currently being logged under the following conditions:
    //<< ;           (1) We entered WWWKILL while inside a transaction
    //<< ;           (2) ^SysSetup(15134) is not 'true'
    //<< ;        To turn off the logging: set ^SysSetup(15134) = 1
    //<< ;
    //<< ;
    //<< ; ByRef :       see new (...)
    //<< ;
    //<< ; Returns :     status
    //<< ;
    //<< ; History :
    //<< ; 30-Sep-2013   shobby  SESPE-556: Prevent the user from trying to delete a modified record from a screen.
    //<< ; 06-Jul-2010   SCR     SR17415: Dont do 'OnBeforeDelete^COMGridEdit31Display' for classed the containing with COMView.
    //<< ;                           This causes a problem with deleting favourites
    //<< ; 28-Apr-2010   GRF     SR17189.1: Must have YVOR even if no form so later
    //<< ;                           processing okay
    //<< ; 17-Feb-2010   GRF     SR17189: Executables may perform other tasks such as
    //<< ;                           deleting associated data rather than just
    //<< ;                           determining whether deletion is possible.  Ownership
    //<< ;                           validation should be performed BEFORE any of these
    //<< ;                           tasks are performed.  Move YVOR/YFELD defn up.
    //<< ; 19-Jun-2009   GRF     Doco; logging
    //<< ; 07-Oct-2008   FIS     SR15947: Transaction Wrapper for "Execute After Delete" implemented
    //<< ;                                Transaction Wrapper for "Execute Before Delete" implemented
    //<< ; 22-Feb-2008   GRF     SR15622: Version 1 => Version 2 conversion for selected classes
    //<< ; 02-Jan-2007   GRF     SR15134: Removed obsolete code per note
    //<< ; 14-Dec-2006   JW      BR014285: Allow for error message from OnBeforeDelete
    //<< ; 14-Dec-2006   Steve S SR15316 Run class hooks
    //<< ; 23-Oct-2006   JW      SR15134: Made transaction smaller. Rewrote in brace syntax.
    //<< ;                       Look at DCM/kill statuses. Logging.
    //<< ; 05-Oct-2006   JW      SR15098: Fixed transaction. Don't always DCM.
    //<< ;                       Reverted incorrect changes of SR14414. Doco.
    //<< ; 24-Aug-2006   GRF     Doco; quits
    //<< ; 07-Jul-2006   RPW     SR12522: Delete any Quick Search if required
    //<< ; 26-Apr-2006   SC      Return strStatus for VARHooks error messages.
    //<< ; 13-Apr-2006   JW      Removed + from user id's in lock check
    //<< ; 10-Apr-2006   SC      SR14414: Check VARHooks for OnBeforeDelete.
    //<< ; 22-Dec-2005   RPW     SR13899: New schluessel
    //<< ; 30-Mar-2005   JW      Copied LC and UC definitions from WWWSKILL - undefined error.
    //<< ; 16-Feb-2005   DT      27239;ALTERNATIVE CLASS
    //<< ; 08.08.1997    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< NEW (SPRACHE,LANGUAGE,YM,YBED,YUSER,YFORM,YDATEI,YKEY,YFELD,YFELD1,YLOCATION,YTIMEFORM,YOPEN,YYFELD,YYKEY,YUCI,YANZ,YHYPER,YEINMAL,%request,%session,%KEY,%,%ZCS,%CGIEVAR)   ;TYBD;22.07.2003; FEHLENDE VARIABLEN FÜR FORM UND CSP...;23959; + YHYPER;FIS;27.05.04;25460
    mVar SPRACHE = m$.var("SPRACHE");
    mVar LANGUAGE = m$.var("LANGUAGE");
    mVar YM = m$.var("YM");
    mVar YBED = m$.var("YBED");
    mVar YUSER = m$.var("YUSER");
    mVar YFORM = m$.var("YFORM");
    mVar YFELD = m$.var("YFELD");
    mVar YFELD1 = m$.var("YFELD1");
    mVar YLOCATION = m$.var("YLOCATION");
    mVar YTIMEFORM = m$.var("YTIMEFORM");
    mVar YOPEN = m$.var("YOPEN");
    mVar YYFELD = m$.var("YYFELD");
    mVar YYKEY = m$.var("YYKEY");
    mVar YUCI = m$.var("YUCI");
    mVar YANZ = m$.var("YANZ");
    mVar YHYPER = m$.var("YHYPER");
    m$.newVarExcept(SPRACHE,LANGUAGE,YM,YBED,YUSER,YFORM,YDATEI,YKEY,YFELD,YFELD1,YLOCATION,YTIMEFORM,YOPEN,YYFELD,YYKEY,YUCI,YANZ,YHYPER,YEINMAL);
    //<< 
    //<< set strStatus=$$$OK
    mVar strStatus = m$.var("strStatus");
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< do ^WWWVORG
    m$.Cmd.Do("WWWVORG.main");
    //<< if ($data(LC)#2=0) set LC="ÜÄÖüäöß][\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/"_$CHAR(128)_""" "
    if ((mOp.Equal(mOp.Modulus(m$.Fnc.$data(m$.var("LC")),2),0))) {
      mVar LC = m$.var("LC");
      LC.set(mOp.Concat(mOp.Concat("ÜÄÖüäöß][\\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\" "));
    }
    //<< if ($data(UC)#2=0) set UC="UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   "
    if ((mOp.Equal(mOp.Modulus(m$.Fnc.$data(m$.var("UC")),2),0))) {
      mVar UC = m$.var("UC");
      UC.set("UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   ");
    }
    //<< 
    //<< if YDATEI'="" {
    if (mOp.NotEqual(YDATEI.get(),"")) {
      //<< set idxYDATEI = $$^WWWUMLAU(YDATEI,1)
      mVar idxYDATEI = m$.var("idxYDATEI");
      idxYDATEI.set(m$.fnc$("WWWUMLAU.main",YDATEI.get(),1));
      //<< if $ORDER(^WWW0011s(0,1,idxYDATEI,""))'="" set YDATEI = $ORDER(^WWW0011s(0,1,idxYDATEI,""))  ;ALTERNATIVE CLASS
      if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW0011s",0,1,idxYDATEI.get(),"")),"")) {
        YDATEI.set(m$.Fnc.$order(m$.var("^WWW0011s",0,1,idxYDATEI.get(),"")));
      }
    }
    //<< }
    //<< if $GET(YUCI)="" set YUCI = $ZUTIL(5)
    if (mOp.Equal(m$.Fnc.$get(YUCI),"")) {
      YUCI.set(m$.Fnc.$zutil(5));
    }
    //<< 
    //<< ;--------------------------------------------------------------------------------------------------------
    //<< ; SCHLUESSEL = "^DATEI(YM,KEY,KEYn,1)"
    //<< 
    //<< if YDATEI'="" {
    if (mOp.NotEqual(YDATEI.get(),"")) {
      //<< set blnOk = $$BuildGlobal(YDATEI,YKEY,.SCHLUESSEL,.YDATA,.MAXYKEY)
      mVar blnOk = m$.var("blnOk");
      blnOk.set(m$.fnc$("BuildGlobal",YDATEI.get(),YKEY.get(),m$.var("SCHLUESSEL"),m$.var("YDATA"),m$.var("MAXYKEY")));
      //<< if blnOk {
      if (mOp.Logical(blnOk.get())) {
        //<< set blnLog = ('$get(^SysSetup(15134)) && ($tlevel>0))       //  Logging
        mVar blnLog = m$.var("blnLog");
        blnLog.set((mOp.Not(m$.Fnc.$get(m$.var("^SysSetup",15134))) && (mOp.Greater(m$.Fnc.$tlevel(),0))));
        //<< 
        //<< ;------- TSTART ------------------------
        //<< set blnTUnit = $$$NO  ;SR15947
        mVar blnTUnit = m$.var("blnTUnit");
        blnTUnit.set(include.COMSYS.$$$NO(m$));
        //<< ;vvvvvvv  ;SR15947 Transaction Units rather manual tstart/tcommit
        //<< if $$$NEVER {  // INACTIVE -> ACTIVATE AFTER THE BUILD !!!   ($$$WWWTransactionActive1($get(^WWWTransaction(0,YFORM,"ExecuteAfterDelete",1)))=$$$YES) {  ;SR15947
        if (mOp.Logical(include.COMSYS.$$$NEVER(m$))) {
          //<< set blnTUnit   = $$$YES
          blnTUnit.set(include.COMSYS.$$$YES(m$));
          //<< set strTZtrap  = $ztrap
          mVar strTZtrap = m$.var("strTZtrap");
          strTZtrap.set(m$.Fnc.$ztrap());
          //<< set $ztrap     = "TransactionUnitError^COMTransaction"                   //change error handler
          mVar $ztrap = m$.var("$ztrap");
          $ztrap.set("TransactionUnitError^COMTransaction");
          //<< set strTStatus = $$StartUnit^COMTransaction(YFORM,"ExecuteAfterDelete")  //start transaction
          mVar strTStatus = m$.var("strTStatus");
          strTStatus.set(m$.fnc$("COMTransaction.StartUnit",YFORM.get(),"ExecuteAfterDelete"));
        }
        //<< } else {
        else {
        }
        //<< tstart  //dflt. transaction control
        //<< }
        //<< ;^^^^^^^^^^
        //<< ;tstart
        //<< ;---------------------------------------
        //<< set Q       = $$$QDelete
        mVar Q = m$.var("Q");
        Q.set(include.COMSYSWWW.$$$QDelete(m$));
        //<< set strForm = $get(YFORM)
        mVar strForm = m$.var("strForm");
        strForm.set(m$.Fnc.$get(YFORM));
        //<< set YVOR = ""                                            ; SR17189.1
        mVar YVOR = m$.var("YVOR");
        YVOR.set("");
        //<< if strForm'="" set YVOR = $get(^WWW120(0,YFORM,1))       ; SR17189 vvv
        if (mOp.NotEqual(strForm.get(),"")) {
          YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)));
        }
        //<< set YFELD = $$^WWWSETL(SCHLUESSEL)
        YFELD.set(m$.fnc$("WWWSETL.main",m$.var("SCHLUESSEL").get()));
        //<< 
        //<< 
        //<< if ($get(YFORM)'="") {  ;
        if ((mOp.NotEqual(m$.Fnc.$get(YFORM),""))) {
          //<< if (($get(^WWWDATEN(0,+$h,YUSER,YFORM,"D",4))'="")&&($get(^WWWDATEN(0,+$h,YUSER,YFORM,"D",4))'=@SCHLUESSEL)) {
          if (mOp.Logical(((mOp.NotEqual(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),YFORM.get(),"D",4)),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),YFORM.get(),"D",4)),m$.indirectVar(m$.var("SCHLUESSEL").get()).get()))))) {
            //<< ; Check that the user is not trying to delete a modified record from a screen.
            //<< set Q = $$$QDontDelete
            Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
            //<< set strStatus=$$$MakeStatus("0 Someone changed the record.") ;SESPE-556
            strStatus.set(include.COMSYS.$$$MakeStatus(m$,"0 Someone changed the record."));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< ;---------------------------------------  SR17189 moved here
        //<< ; Check user access to current location
        //<< ;---------------------------------------
        //<< if (Q=$$$QDelete) && (strForm'="") {    ;
        if ((mOp.Equal(Q.get(),include.COMSYSWWW.$$$QDelete(m$))) && (mOp.NotEqual(strForm.get(),""))) {
          //<< if $$$WWW120DataItemOfLocation(YVOR)'="" {
          if (mOp.NotEqual(include.WWWConst.$$$WWW120DataItemOfLocation(m$,YVOR),"")) {
            //<< if $$^WWWLOCATION($get(YLOCATION),YFORM,YFELD)'=$$$YES {
            if (mOp.NotEqual(m$.fnc$("WWWLOCATION.main",m$.Fnc.$get(YLOCATION),YFORM.get(),YFELD.get()),include.COMSYS.$$$YES(m$))) {
              //<< set Q = $$$QDontDelete   ; No authorisation
              Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
            }
          }
        }
        //<< }
        //<< }
        //<< }                                                        ; SR17189 ^^^
        //<< 
        //<< ;---------------------------------------
        //<< ;  On Before Delete                            *** EXECUTE Kill 1 ***
        //<< ;---------------------------------------
        //<< ;       set YFELD = $$^WWWSETL(SCHLUESSEL)             ; SR17189 vvv move up & add Q test
        //<< ;       if strForm'="" {
        //<< ;           set YVOR = $GET(^WWW120(0,YFORM,1))
        //<< if (Q=$$$QDelete) && (strForm'="") {           ; SR17189 ^^^
        if ((mOp.Equal(Q.get(),include.COMSYSWWW.$$$QDelete(m$))) && (mOp.NotEqual(strForm.get(),""))) {
          //<< set strExec = $$$WWW120ExecuteBeforeDeletionData(YVOR)
          mVar strExec = m$.var("strExec");
          strExec.set(include.WWWConst.$$$WWW120ExecuteBeforeDeletionData(m$,YVOR));
          //<< if ((strExec'="") || ($data(^WWWTransactionLine(0,YFORM,"ExecuteBeforeDelete")))) && ($GET(YTIMEFORM)'=1) {  ;SR15947
          if (mOp.Logical(((mOp.NotEqual(strExec.get(),"")) || mOp.Logical((m$.Fnc.$data(m$.var("^WWWTransactionLine",0,YFORM.get(),"ExecuteBeforeDelete")))))) && (mOp.NotEqual(m$.Fnc.$get(YTIMEFORM),1))) {
            //<< set strStatus=$$$OK         ;SR17245
            strStatus.set(include.COMSYS.$$$OK(m$));
            //<< XECUTE $$$WWW120ExecuteBeforeDeletionData(YVOR)  ;EXECUTE VOR LÖSCHEN WENN NICHT LÖSCHEN, DANN Q=1
            m$.Cmd.Xecute(include.WWWConst.$$$WWW120ExecuteBeforeDeletionData(m$,YVOR));
            //<< if $$$ISOK(strStatus) {     ;SR17245
            if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
              //<< set strStatus = $$TransactionUnit^COMTransaction(YFORM,"ExecuteBeforeDelete",blnTUnit,.strTError,.Q)  ;SR15947
              strStatus.set(m$.fnc$("COMTransaction.TransactionUnit",YFORM.get(),"ExecuteBeforeDelete",blnTUnit.get(),m$.var("strTError"),Q));
            }
            //<< } else {
            else {
              //<< set Q=$$$QDontDelete    ;SR17245
              Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
            }
            //<< }
            //<< // BR014285: Allow for error message
            //<< if $extract(Q,2,999)'="" set strStatus = $extract(Q,2,999)   ; FIXME : Is this a text string rather than a strStatus value? <GRF>
            if (mOp.NotEqual(m$.Fnc.$extract(Q.get(),2,999),"")) {
              strStatus.set(m$.Fnc.$extract(Q.get(),2,999));
            }
            //<< set Q = +Q
            Q.set(mOp.Positive(Q.get()));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< ;---------------------------------------
        //<< ;  On Before Delete Hook                       *** EXECUTE Kill 2 ***
        //<< ;---------------------------------------
        //<< if Q=$$$QDelete {
        if (mOp.Equal(Q.get(),include.COMSYSWWW.$$$QDelete(m$))) {
          //<< //SR15316 Commented: Handled in WWW001Hook
          //<< //set strStatus = $$ExecuteVARHook^WWW001VARHooks(YDATEI,$$$EnumWWWEVENTTYPEOnBeforeDelete,YKEY,YFELD,strForm)  // SR14414
          //<< //if $$$ISOK(strStatus) { //SR15316
          //<< set strStatus = $$ExecuteHook^WWW001Hook(YDATEI,$$$EnumWWWEVENTTYPEOnBeforeDelete,YKEY,YFELD,strForm)   // SR14414
          strStatus.set(m$.fnc$("WWW001Hook.ExecuteHook",YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeDelete(m$),YKEY.get(),YFELD.get(),strForm.get()));
          //<< //}
          //<< if $$$ISERR(strStatus) set Q = $$$QDontDelete
          if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
            Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
          }
        }
        //<< }
        //<< 
        //<< ; SR17189 : Previous EXECs may perform secondary operations - should validate ownership first - Moved up
        //<< ;       if (Q=$$$QDelete) && (strForm'="") {    ;Check user access to current location
        //<< ;           if $$$WWW120DataItemOfLocation(YVOR)'="" {
        //<< ;               if $$^WWWLOCATION($GET(YLOCATION),YFORM,YFELD)'=$$$YES {
        //<< ;                   set Q = $$$QDontDelete   ;No authorisation
        //<< ;               }
        //<< ;           }
        //<< ;       }
        //<< 
        //<< ;if Q=$$$QDelete {   ;SR17245
        //<< if (Q=$$$QDelete) && (YDATEI'["COMView") {   ;SR17415, do not do this for COMView classes SR17245
        if ((mOp.Equal(Q.get(),include.COMSYSWWW.$$$QDelete(m$))) && (mOp.NotContains(YDATEI.get(),"COMView"))) {
          //<< set strStatus = $$OnBeforeDelete^COMGridEdit31Display(YDATEI,strForm,YKEY,YFELD)
          strStatus.set(m$.fnc$("COMGridEdit31Display.OnBeforeDelete",YDATEI.get(),strForm.get(),YKEY.get(),YFELD.get()));
          //<< if $$$ISERR(strStatus) set Q = $$$QDontDelete   ;SR17245
          if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
            Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
          }
        }
        //<< }
        //<< 
        //<< 
        //<< 
        //<< ;-------------------------------
        //<< ; Version 1 => Version 2
        //<< ;-------------------------------
        //<< if Q=$$$QDelete {                                   ;  *** EXECUTE Kill 3 ***
        if (mOp.Equal(Q.get(),include.COMSYSWWW.$$$QDelete(m$))) {
          //<< set strStatus = $$ConvertOnDelete^COMConversion(YDATEI,YKEY)
          strStatus.set(m$.fnc$("COMConversion.ConvertOnDelete",YDATEI.get(),YKEY.get()));
          //<< if $$$ISERR(strStatus) set Q = $$$QDontDelete
          if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
            Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
          }
        }
        //<< }
        //<< 
        //<< if Q=$$$QDontDelete {   // Do not delete !!     SR15098 - cleaned up
        if (mOp.Equal(Q.get(),include.COMSYSWWW.$$$QDontDelete(m$))) {
          //<< if $get(YFORM)=""            set YFORM  = ""
          if (mOp.Equal(m$.Fnc.$get(YFORM),"")) {
            YFORM.set("");
          }
          //<< if $GET(YKEY)'=""            set YYKEY  = $get(YKEY)
          if (mOp.NotEqual(m$.Fnc.$get(YKEY),"")) {
            YYKEY.set(m$.Fnc.$get(YKEY));
          }
          //<< if $GET(YFELD)'=""           set YYFELD = $get(YFELD)
          if (mOp.NotEqual(m$.Fnc.$get(YFELD),"")) {
            YYFELD.set(m$.Fnc.$get(YFELD));
          }
          //<< if (YFELD="") && (YFORM'="") set YYFELD = $get(^WWWUSE(0,YUSER,YFORM,"D",1))
          if ((mOp.Equal(YFELD.get(),"")) && (mOp.NotEqual(YFORM.get(),""))) {
            YYFELD.set(m$.Fnc.$get(m$.var("^WWWUSE",0,YUSER.get(),YFORM.get(),"D",1)));
          }
          //<< set YFELD = YYFELD
          YFELD.set(YYFELD.get());
          //<< set YKEY  = YYKEY
          YKEY.set(YYKEY.get());
          //<< set YOPEN = "OLD"
          YOPEN.set("OLD");
        }
        //<< 
        //<< } else {
        else {
          //<< ;------ DELETE data record  -------------
          //<< set %FELD1 = $$^WWWSETK(SCHLUESSEL)
          m$.var("%FELD1").set(m$.fnc$("WWWSETK.main",m$.var("SCHLUESSEL").get()));
          //<< ;----------------------------------------
          //<< 
          //<< ;BITMAP;18.06.2003;TYBD ;bit map
          //<< if $$$WWW001BitMapIndexActive(YDATA) || ($$$WWW001BitmapXREFClass(YDATA)'="") {
          if (mOp.Logical(include.WWWConst.$$$WWW001BitMapIndexActive(m$,m$.var("YDATA"))) || (mOp.NotEqual(include.WWWConst.$$$WWW001BitmapXREFClass(m$,m$.var("YDATA")),""))) {
            //<< set OK = $$^WWWBITSET(YDATEI,YKEY,0,%FELD1,1,,,,$piece(YDATA,Y,25))   ;BITMAP;18.06.2003;TYBD ;bit map
            mVar OK = m$.var("OK");
            OK.set(m$.fnc$("WWWBITSET.main",YDATEI.get(),YKEY.get(),0,m$.var("%FELD1").get(),1,null,null,null,m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),25)));
          }
          //<< }
          //<< set YFELD = %FELD1
          YFELD.set(m$.var("%FELD1").get());
          //<< if $get(YTIMEFORM)'=1 {  ;NUR ZEITABHÄNGIGE ERFASSUNG ;only logging
          if (mOp.NotEqual(m$.Fnc.$get(YTIMEFORM),1)) {
            //<< if ($get(YFORM)'="") && ($piece($get(^WWW120(0,YFORM,1)),Y,29)=1) {  ;PROTOKOLLDATEI
            if ((mOp.NotEqual(m$.Fnc.$get(YFORM),"")) && (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),29),1))) {
              //<< set YUHR      = $piece($horolog,",",2)
              mVar YUHR = m$.var("YUHR");
              YUHR.set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
              //<< set strKeyPRO = $translate(YKEY,"/",",")
              mVar strKeyPRO = m$.var("strKeyPRO");
              strKeyPRO.set(m$.Fnc.$translate(YKEY.get(),"/",","));
              //<< while ($data(^WWWPRO(YM,YDATEI,+$horolog,YUHR,YBED,strKeyPRO,0,1))) {
              while (mOp.Logical((m$.Fnc.$data(m$.var("^WWWPRO",YM.get(),YDATEI.get(),mOp.Positive(m$.Fnc.$horolog()),YUHR.get(),YBED.get(),strKeyPRO.get(),0,1))))) {
                //<< set YUHR=YUHR+.1
                YUHR.set(mOp.Add(YUHR.get(),.1));
              }
              //<< }
              //<< set ^WWWPRO(YM,YDATEI,+$horolog,YUHR,YBED,strKeyPRO,0,1) = %FELD1
              m$.var("^WWWPRO",YM.get(),YDATEI.get(),mOp.Positive(m$.Fnc.$horolog()),YUHR.get(),YBED.get(),strKeyPRO.get(),0,1).set(m$.var("%FELD1").get());
              //<< set ^WWWPRO(YM,YDATEI,+$horolog,YUHR,YBED,strKeyPRO,1,1) = ""
              m$.var("^WWWPRO",YM.get(),YDATEI.get(),mOp.Positive(m$.Fnc.$horolog()),YUHR.get(),YBED.get(),strKeyPRO.get(),1,1).set("");
            }
          }
          //<< }
          //<< }
          //<< do Indexes()        //SR15134
          m$.Cmd.Do("Indexes");
          //<< 
          //<< 
          //<< if $GET(YTIMEFORM)'=1 {
          if (mOp.NotEqual(m$.Fnc.$get(YTIMEFORM),1)) {
            //<< if strForm'="" {
            if (mOp.NotEqual(strForm.get(),"")) {
              //<< DO ^WWWFORM5
              m$.Cmd.Do("WWWFORM5.main");
              //<< ;---------------------------------------
              //<< ;  On After Delete                            *** EXECUTE Kill 4 ***
              //<< ;---------------------------------------
              //<< set strExec = $$$WWW120ExecuteAfterDataDeleted(YVOR)
              mVar strExec = m$.var("strExec");
              strExec.set(include.WWWConst.$$$WWW120ExecuteAfterDataDeleted(m$,YVOR));
              //<< if strExec'="" {
              if (mOp.NotEqual(strExec.get(),"")) {
                //<< xecute strExec
                m$.Cmd.Xecute(strExec.get());
              }
              //<< }
              //<< if ($data(^WWWTransactionLine(0,YFORM,"ExecuteAfterDelete"))) {  ;SR15947
              if (mOp.Logical((m$.Fnc.$data(m$.var("^WWWTransactionLine",0,YFORM.get(),"ExecuteAfterDelete"))))) {
                //<< set strStatus = $$TransactionUnit^COMTransaction(YFORM,"ExecuteAfterDelete",blnTUnit,.strTError)
                strStatus.set(m$.fnc$("COMTransaction.TransactionUnit",YFORM.get(),"ExecuteAfterDelete",blnTUnit.get(),m$.var("strTError")));
              }
              //<< }
              //<< if (strExec="") || $$$WWW120DeleteSubformsRegardlessO(YVOR) {
              if ((mOp.Equal(strExec.get(),"")) || mOp.Logical(include.WWWConst.$$$WWW120DeleteSubformsRegardlessO(m$,YVOR))) {
                //<< if $$$WWW120DeleteAlsoSubforms(YVOR) {
                if (mOp.Logical(include.WWWConst.$$$WWW120DeleteAlsoSubforms(m$,YVOR))) {
                  //<< DO SUBKILL
                  m$.Cmd.Do("SUBKILL");
                }
                //<< }
                //<< if $$$WWW120DeleteAlsoTheFollowingSub(YVOR)'="" {
                if (mOp.NotEqual(include.WWWConst.$$$WWW120DeleteAlsoTheFollowingSub(m$,YVOR),"")) {
                  //<< DO SUBKILL1
                  m$.Cmd.Do("SUBKILL1");
                }
              }
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< }
        //<< }
        //<< 
        //<< ;--------- DCM ------------------------------ SR15098: Do not always try DCM - check Q (if kill occurred) first.
        //<< 
        //<< if (Q=$$$QDelete) && ($GET(YEINMAL)'=$$$YES) {
        if ((mOp.Equal(Q.get(),include.COMSYSWWW.$$$QDelete(m$))) && (mOp.NotEqual(m$.Fnc.$get(YEINMAL),include.COMSYS.$$$YES(m$)))) {
          //<< set strStatus = $$DeleteIndex^COMQuickSearch(YDATEI,YKEY) // SR12522    SR15134
          strStatus.set(m$.fnc$("COMQuickSearch.DeleteIndex",YDATEI.get(),YKEY.get()));
          //<< 
          //<< if $$$ISOK(strStatus) {
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
            //<< ; Now run function that identifies what, if any, event(s) need to be added to the queue
            //<< 
            //<< set intTlevel = $tlevel             //SR15134 vvvvvvvv Check transaction level
            mVar intTlevel = m$.var("intTlevel");
            intTlevel.set(m$.Fnc.$tlevel());
            //<< set strStatusDCM = $$setRelevantEvents^COMDCMControlModule("INTRAPREND",YDATEI,"delete",YKEY)  ;INTRAPREND=KENNUNG FÜR @-NET MANAGER ;to
            mVar strStatusDCM = m$.var("strStatusDCM");
            strStatusDCM.set(m$.fnc$("COMDCMControlModule.setRelevantEvents","INTRAPREND",YDATEI.get(),"delete",YKEY.get()));
            //<< if (intTlevel '= $tlevel) {         //SR15134 ^^^^^^^^
            if ((mOp.NotEqual(intTlevel.get(),m$.Fnc.$tlevel()))) {
              //<< set strStatus = $listbuild("Com00261",$piece(strStatusDCM,Y,2))  ;Transaction Level not maintained by DCM. Contact Support. Status: %1
              strStatus.set(m$.Fnc.$listbuild("Com00261",m$.Fnc.$piece(strStatusDCM.get(),m$.var("Y").get(),2)));
            }
            //<< 
            //<< } elseif '$piece(strStatusDCM,Y,1) && ($GET(YBED)'="") && ($GET(YFORM)'="") {   // Log only
            else if (mOp.Not(m$.Fnc.$piece(strStatusDCM.get(),m$.var("Y").get(),1)) && (mOp.NotEqual(m$.Fnc.$get(YBED),"")) && (mOp.NotEqual(m$.Fnc.$get(YFORM),""))) {
              //<< set ^WWWWV(YM,YBED,+$horolog,YFORM,YKEY,1) = +$horolog_Y_$piece($horolog,",",2)_Y_YBED_Y_$piece(strStatusDCM,Y,2)
              m$.var("^WWWWV",YM.get(),YBED.get(),mOp.Positive(m$.Fnc.$horolog()),YFORM.get(),YKEY.get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Positive(m$.Fnc.$horolog()),m$.var("Y").get()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2)),m$.var("Y").get()),YBED.get()),m$.var("Y").get()),m$.Fnc.$piece(strStatusDCM.get(),m$.var("Y").get(),2)));
            }
          }
          //<< }
          //<< }
          //<< if $$$ISERR(strStatus) {
          if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
            //<< set Q = $$$QDontDelete
            Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< ;--- COMMIT / ROLLBACK -------------------- SR15098 Do not always tcommit. Check tlevel and Q (if kill occurred).
        //<< 
        //<< if (Q=$$$QDelete) {
        if ((mOp.Equal(Q.get(),include.COMSYSWWW.$$$QDelete(m$)))) {
          //<< ;vvvvvvv  ;SR15947 Transaction Units rather manual tstart/tcommit
          //<< if (blnTUnit =$$$YES) {
          if ((mOp.Equal(blnTUnit.get(),include.COMSYS.$$$YES(m$)))) {
            //<< if $$$ISOK(strTStatus) {
            if (mOp.Logical(include.COMSYS.$$$ISOK(m$,m$.var("strTStatus")))) {
              //<< set strTStatus=$$EndUnit^COMTransaction(YFORM,"ExecuteAfterDelete",strTStatus,$get(strTError))
              mVar strTStatus = m$.var("strTStatus");
              strTStatus.set(m$.fnc$("COMTransaction.EndUnit",YFORM.get(),"ExecuteAfterDelete",m$.var("strTStatus").get(),m$.Fnc.$get(m$.var("strTError"))));
              //<< if '$$$ISOK(strTStatus) set strStatus = $$$NO  ;strTStatus  // set error if rolling back due to strTError
              if (mOp.Not(include.COMSYS.$$$ISOK(m$,strTStatus))) {
                strStatus.set(include.COMSYS.$$$NO(m$));
              }
            }
            //<< }
            //<< set $ztrap=strTZtrap
            mVar $ztrap = m$.var("$ztrap");
            $ztrap.set(m$.var("strTZtrap").get());
          }
          //<< } else {
          else {
            //<< if $tlevel>0 tcommit  //dflt. tcommit
            if (mOp.Greater(m$.Fnc.$tlevel(),0)) {
            }
            //<< //Either deletes the object or exports its parent
            //<< do ##class(SourceControl.Exporter).DeleteArtifactByNameKey(YDATEI,YKEY)
            //m$.Cmd.Do("SourceControl.Exporter.DeleteArtifactByNameKey",YDATEI.get(),YKEY.get());
            //TODO: SourceControl
          }
        }
        //<< }
        //<< ;^^^^^^^^^^
        //<< ;if $tlevel>0 tcommit
        //<< } else {
        else {
          //<< if blnLog do StackDump^COMDebug("WWWKILL","Class: "_YDATEI_", Key: "_YKEY _",Status: "_strStatus)       //SR15134 - logging
          if (mOp.Logical(blnLog.get())) {
            m$.Cmd.Do("COMDebug.StackDump","WWWKILL",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Class: ",YDATEI.get()),", Key: "),YKEY.get()),",Status: "),strStatus.get()));
          }
          //<< ;vvvvvvv  ;SR15947 Transaction Units rather manual tstart/tcommit
          //<< if (blnTUnit =$$$YES) {
          if ((mOp.Equal(blnTUnit.get(),include.COMSYS.$$$YES(m$)))) {
            //<< if $$$ISOK(strTStatus) { set strTStatus=$$EndUnit^COMTransaction(YFORM,"ExecuteAfterDelete",strTStatus,$listbuild("WWW00044",YDATEI,YKEY)) }     ;System deletion failed. Class: %1, Key: %2
            if (mOp.Logical(include.COMSYS.$$$ISOK(m$,m$.var("strTStatus")))) {
              mVar strTStatus = m$.var("strTStatus");
              strTStatus.set(m$.fnc$("COMTransaction.EndUnit",YFORM.get(),"ExecuteAfterDelete",m$.var("strTStatus").get(),m$.Fnc.$listbuild("WWW00044",YDATEI.get(),YKEY.get())));
            }
            //<< set $ztrap=strTZtrap
            mVar $ztrap = m$.var("$ztrap");
            $ztrap.set(m$.var("strTZtrap").get());
          }
          //<< } else {
          else {
          }
          //<< trollback  //dflt. trollback
          //<< }
          //<< ;^^^^^^^^^^
          //<< ;trollback
          //<< if $$$ISOK(strStatus) {     // We are rolling back but don't have an error status, so return default error.
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
            //<< set strStatus = $listbuild("WWW00044",YDATEI,YKEY)   ;System deletion failed. Class: %1, Key: %2
            strStatus.set(m$.Fnc.$listbuild("WWW00044",YDATEI.get(),YKEY.get()));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< ;---------------------------------------
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< BuildGlobal(pidClass,pstrKey,&pstrGlobal,&pobjClass,&pintKeys)
  public Object BuildGlobal(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pobjClass = m$.newVarRef("pobjClass",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pintKeys = m$.newVarRef("pintKeys",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Build the global string
    //<< ;
    //<< ; Params:   pidClass    - WWW001 id
    //<< ;           pstrKey     - key of the class
    //<< ;
    //<< ; ByRefs:   pstrGlobal  - the constructed string
    //<< ;           pobjClass   - WWW001 data
    //<< ;           pintKeys    - number of keys in the class
    //<< ;
    //<< ; Returns:  boolean - whether global could be formed properly
    //<< ;
    //<< ; History:
    //<< ; 23-Feb-2007   JW      SR15452: Quote the company
    //<< ; 23-Oct-2006   JW      SR15134: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intKey,blnOk,idKey
    mVar intKey = m$.var("intKey");
    mVar blnOk = m$.var("blnOk");
    mVar idKey = m$.var("idKey");
    m$.newVar(intKey,blnOk,idKey);
    //<< 
    //<< set blnOk = $$$YES
    blnOk.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< set pobjClass = $get(^WWW001(0,pidClass,1))
    pobjClass.set(m$.Fnc.$get(m$.var("^WWW001",0,pidClass.get(),1)));
    //<< set pintKeys = +$order(^WWW002(0,pidClass,""),-1)
    pintKeys.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),""),mOp.Negative(1))));
    //<< if pintKeys=0 set pintKeys=1
    if (mOp.Equal(pintKeys.get(),0)) {
      pintKeys.set(1);
    }
    //<< 
    //<< set pstrGlobal="^"_pidClass
    pstrGlobal.set(mOp.Concat("^",pidClass.get()));
    //<< 
    //<< if $get(YTIMEFORM)=1 {      // time-dependent change
    if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
      //<< $$$Append(pstrGlobal,"t")
      include.COMSYSString.$$$Append(m$,pstrGlobal,"t");
      //<< set pintKeys = pintKeys+1
      pintKeys.set(mOp.Add(pintKeys.get(),1));
    }
    //<< }
    //<< $$$Append(pstrGlobal,"("_$$$QUOTE($$^WWWYM(pidClass)))  //SR15452
    include.COMSYSString.$$$Append(m$,pstrGlobal,mOp.Concat("(",include.COMSYSString.$$$QUOTE(m$,m$.fnc$("WWWYM.main",pidClass.get()))));
    //<< 
    //<< for intKey = 1:1:pintKeys {
    for (intKey.set(1);(mOp.LessOrEqual(intKey.get(),pintKeys.get()));intKey.set(mOp.Add(intKey.get(),1))) {
      //<< set idKey = $$$DEQUOTE($piece(pstrKey,",",intKey))
      idKey.set(include.COMSYSString.$$$DEQUOTE(m$,m$.Fnc.$piece(pstrKey.get(),",",intKey.get())));
      //<< if idKey="" {
      if (mOp.Equal(idKey.get(),"")) {
        //<< set blnOk = $$$NO
        blnOk.set(include.COMSYS.$$$NO(m$));
      }
      //<< } else {
      else {
        //<< $$$Append(pstrGlobal,","""_idKey_"""")
        include.COMSYSString.$$$Append(m$,pstrGlobal,mOp.Concat(mOp.Concat(",\"",idKey.get()),"\""));
      }
    }
    //<< }
    //<< }
    //<< if blnOk {
    if (mOp.Logical(blnOk.get())) {
      //<< if $$$WWW001AltSaveProcedure(pobjClass)'=4 {
      if (mOp.NotEqual(include.WWWConst.$$$WWW001AltSaveProcedure(m$,pobjClass),4)) {
        //<< $$$Append(pstrGlobal,",1")
        include.COMSYSString.$$$Append(m$,pstrGlobal,",1");
      }
      //<< }
      //<< $$$Append(pstrGlobal,")")
      include.COMSYSString.$$$Append(m$,pstrGlobal,")");
    }
    //<< }
    //<< quit blnOk
    return blnOk.get();
  }

  //<< 
  //<< 
  //<< Indexes()
  public Object Indexes(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Re-index after the deletion       ;SORTKEYS BEARBEITEN
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Oct-2006   JW      SR15134: Created. Encapsulated from main routine
    //<< ;-------------------------------------------------------------------------------
    //<< if $$$WWW001AltSaveProcedure($GET(YDATA))'=4 do     ;NICHT BEI CACHÉ ;next to
    if (mOp.NotEqual(include.WWWConst.$$$WWW001AltSaveProcedure(m$,m$.Fnc.$get(m$.var("YDATA"))),4)) {
      //<< . DO ^WWWSORTKEY(YDATEI)  ;SKEY BESTIMMEN ;ordain
      m$.Cmd.Do("WWWSORTKEY.main",m$.var("YDATEI").get());
      //<< . IF $DATA(YSKEY) DO
      if (mOp.Logical(m$.Fnc.$data(m$.var("YSKEY")))) {
        do {
          //<< . . SET YYYM(0)=$$^WWWYM(YDATEI,0)
          mVar YYYM = m$.var("YYYM");
          YYYM.var(0).set(m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),0));
          //<< . . SET YYYM(1)=$$^WWWYM(YDATEI,1)
          YYYM.var(1).set(m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1));
          //<< . . IF $PIECE($GET(^WWW001(0,YDATEI,1)),Y,8)=7 DO ^WWWKILL7 QUIT  ;SQLSTORAGE
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YDATEI").get(),1)),m$.var("Y").get(),8),7)) {
            m$.Cmd.Do("WWWKILL7.main");
            break;
          }
          //<< . . IF $PIECE($GET(^WWW001(0,YDATEI,1)),Y,8)=6              QUIT  ;ABACUS
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YDATEI").get(),1)),m$.var("Y").get(),8),6)) {
            break;
          }
          //<< . . SET SKEY=""
          mVar SKEY = m$.var("SKEY");
          SKEY.set("");
          //<< . . FOR  SET SKEY=$ORDER(YSKEY(SKEY)) QUIT:SKEY=""  DO
          for (;true;) {
            SKEY.set(m$.Fnc.$order(m$.var("YSKEY").var(SKEY.get())));
            if (mOp.Equal(SKEY.get(),"")) {
              break;
            }
            //<< . . . NEW YQ,YMAX,YMAX1,YMAX2
            mVar YQ = m$.var("YQ");
            mVar YMAX = m$.var("YMAX");
            mVar YMAX1 = m$.var("YMAX1");
            mVar YMAX2 = m$.var("YMAX2");
            m$.newVarBlock(3,YQ,YMAX,YMAX1,YMAX2);
            //<< . . . NEW YFILES
            mVar YFILES = m$.var("YFILES");
            m$.newVarBlock(3,YFILES);
            //<< . . . SET YFILES=YDATEI_"s"
            YFILES.set(mOp.Concat(m$.var("YDATEI").get(),"s"));
            //<< . . . IF $PIECE(YDATA,Y,23)'="" SET YFILES=$PIECE(YDATA,Y,23)  ;ANDERE DATEI ;data file
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),23),"")) {
              YFILES.set(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),23));
            }
            //<< . . . KILL YSFELD,YSDATEI
            m$.var("YSFELD").kill();
            m$.var("YSDATEI").kill();
            //<< . . . SET YSDATEI="^"_YFILES_"("_YYYM(1)_SKEY
            mVar YSDATEI = m$.var("YSDATEI");
            YSDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILES.get()),"("),YYYM.var(1).get()),SKEY.get()));
            //<< . . . IF $PIECE(YDATA,Y,12)'="" IF $PIECE(YDATA,Y,13)'="" DO  ;UCI UND VOL ;UCI And
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),12),"")) {
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),13),"")) {
                //<< . . . . SET YSDATEI="^["_""""_$PIECE(YDATA,Y,12)_""""_","_""""_$PIECE(YDATA,Y,13)_""""_"]"_$PIECE(YSDATEI,"^",2,999)
                YSDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[","\""),m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),12)),"\""),","),"\""),m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),13)),"\""),"]"),m$.Fnc.$piece(YSDATEI.get(),"^",2,999)));
              }
            }
            //<< . . . ;
            //<< . . . SET YMAX=1
            YMAX.set(1);
            //<< . . . SET YSDATEI(YMAX)=YSDATEI
            YSDATEI.var(YMAX.get()).set(YSDATEI.get());
            //<< . . . FOR YI=1:1 SET YLFN=$PIECE(YSKEY(SKEY),",",YI) QUIT:YLFN=""  DO
            mVar YI = m$.var("YI");
            for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
              mVar YLFN = m$.var("YLFN");
              YLFN.set(m$.Fnc.$piece(m$.var("YSKEY").var(SKEY.get()).get(),",",YI.get()));
              if (mOp.Equal(YLFN.get(),"")) {
                break;
              }
              //<< . . . . IF $EXTRACT(YLFN)="F" SET YSFELD(YI)=$PIECE(%FELD1,Y,+$EXTRACT(YLFN,2,9))
              if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                mVar YSFELD = m$.var("YSFELD");
                YSFELD.var(YI.get()).set(m$.Fnc.$piece(m$.var("%FELD1").get(),m$.var("Y").get(),mOp.Positive(m$.Fnc.$extract(YLFN.get(),2,9))));
              }
              //<< . . . . IF $EXTRACT(YLFN)="K" SET YSFELD(YI)=$PIECE(YKEY,",",+$EXTRACT(YLFN,2,9))
              if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                mVar YSFELD = m$.var("YSFELD");
                YSFELD.var(YI.get()).set(m$.Fnc.$piece(m$.var("YKEY").get(),",",mOp.Positive(m$.Fnc.$extract(YLFN.get(),2,9))));
              }
              //<< . . . . IF YI=1 DO   ;WENN ERSTER KEY ;when premier KEY
              if (mOp.Equal(YI.get(),1)) {
                //<< . . . . . FOR  QUIT:$EXTRACT(YSFELD(YI))'=";"  SET YSFELD(YI)=$EXTRACT(YSFELD(YI),2,200)
                for (;true;) {
                  if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YSFELD").var(YI.get()).get()),";")) {
                    break;
                  }
                  mVar YSFELD = m$.var("YSFELD");
                  YSFELD.var(YI.get()).set(m$.Fnc.$extract(m$.var("YSFELD").var(YI.get()).get(),2,200));
                }
                //<< . . . . . IF $EXTRACT($REVERSE(YSFELD(YI)))=";" FOR  QUIT:$EXTRACT($REVERSE(YSFELD(YI)))'=";"  SET YSFELD(YI)=$REVERSE($EXTRACT($REVERSE(YSFELD(YI)),2,200))
                if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YSFELD").var(YI.get()).get())),";")) {
                  for (;true;) {
                    if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YSFELD").var(YI.get()).get())),";")) {
                      break;
                    }
                    mVar YSFELD = m$.var("YSFELD");
                    YSFELD.var(YI.get()).set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YSFELD").var(YI.get()).get()),2,200)));
                  }
                }
                //<< . . . . . SET YMAX=$LENGTH(YSFELD(YI),";")  ;ANZAHL DER ";" FELDER IM FELD
                YMAX.set(m$.Fnc.$length(m$.var("YSFELD").var(YI.get()).get(),";"));
                //<< . . . . . FOR YMAX1=1:1:YMAX SET YSDATEI(YMAX1)=YSDATEI
                for (YMAX1.set(1);(mOp.LessOrEqual(YMAX1.get(),YMAX.get()));YMAX1.set(mOp.Add(YMAX1.get(),1))) {
                  YSDATEI.var(YMAX1.get()).set(YSDATEI.get());
                }
              }
              //<< . . . . ;
              //<< . . . . IF YSFELD(YI)="" SET YSFELD(YI)=" "
              if (mOp.Equal(m$.var("YSFELD").var(YI.get()).get(),"")) {
                mVar YSFELD = m$.var("YSFELD");
                YSFELD.var(YI.get()).set(" ");
              }
              //<< . . . . FOR YMAX1=1:1:YMAX DO
              for (YMAX1.set(1);(mOp.LessOrEqual(YMAX1.get(),YMAX.get()));YMAX1.set(mOp.Add(YMAX1.get(),1))) {
                //<< . . . . . SET YMAX2=YMAX1
                YMAX2.set(YMAX1.get());
                //<< . . . . . IF YMAX=1 SET YMAX2=200  ;ANZAHL DER ";" FELDER IN DATENFELD
                if (mOp.Equal(YMAX.get(),1)) {
                  YMAX2.set(200);
                }
                //<< . . . . . IF YI=1 DO
                if (mOp.Equal(YI.get(),1)) {
                  //<< . . . . . . IF $EXTRACT(YLFN)="F" IF YUMLAU'="" SET YSFELD(YMAX1,YI)=$EXTRACT($$^WWWUMLAU($PIECE(YSFELD(YI),";",YMAX1,YMAX2),1),1,150)     ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                  if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                    if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
                      mVar YSFELD = m$.var("YSFELD");
                      YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(m$.var("YSFELD").var(YI.get()).get(),";",YMAX1.get(),YMAX2.get()),1),1,150));
                    }
                  }
                  //<< . . . . . . IF $EXTRACT(YLFN)="F" IF YUMLAU=""  SET YSFELD(YMAX1,YI)=$EXTRACT($TRANSLATE($PIECE(YSFELD(YI),";",YMAX1,YMAX2),LC,UC),1,150)  ;SPEED UP;TYBD;25.09.2004 ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                  if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                    if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
                      mVar YSFELD = m$.var("YSFELD");
                      YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSFELD").var(YI.get()).get(),";",YMAX1.get(),YMAX2.get()),m$.var("LC").get(),m$.var("UC").get()),1,150));
                    }
                  }
                  //<< . . . . . . IF $EXTRACT(YLFN)="K" IF YUMLAU=""  SET YSFELD(YMAX1,YI)=$EXTRACT($TRANSLATE(YSFELD(YI),LC,UC),1,150)
                  if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                    if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
                      mVar YSFELD = m$.var("YSFELD");
                      YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YSFELD").var(YI.get()).get(),m$.var("LC").get(),m$.var("UC").get()),1,150));
                    }
                  }
                  //<< . . . . . . IF $EXTRACT(YLFN)="K" IF YUMLAU'="" SET YSFELD(YMAX1,YI)=$EXTRACT($$^WWWUMLAU(YSFELD(YI),1),1,150)
                  if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                    if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
                      mVar YSFELD = m$.var("YSFELD");
                      YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.var("YSFELD").var(YI.get()).get(),1),1,150));
                    }
                  }
                  //<< . . . . . . IF YSFELD(YMAX1,YI)="" SET YSFELD(YMAX1,YI)=" "
                  if (mOp.Equal(m$.var("YSFELD").var(YMAX1.get(),YI.get()).get(),"")) {
                    mVar YSFELD = m$.var("YSFELD");
                    YSFELD.var(YMAX1.get(),YI.get()).set(" ");
                  }
                  //<< . . . . . . SET YSDATEI(YMAX1)=YSDATEI(YMAX1)_","_""""_YSFELD(YMAX1,YI)_""""
                  YSDATEI.var(YMAX1.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),","),"\""),m$.var("YSFELD").var(YMAX1.get(),YI.get()).get()),"\""));
                }
                //<< . . . . . ;
                //<< . . . . . IF YI'=1 DO  ;TYBD;NEU WEGEN FEHLER; WENN MEHRFACH UND UNTERSORT, DANN WURDE NUR DAS ERSTE FELD GENOMMEN
                if (mOp.NotEqual(YI.get(),1)) {
                  //<< . . . . . . IF $EXTRACT(YLFN)="F" IF YUMLAU'="" SET YSFELD(YMAX1,YI)=$EXTRACT($$^WWWUMLAU(YSFELD(YI),1),1,150)     ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                  if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                    if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
                      mVar YSFELD = m$.var("YSFELD");
                      YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.var("YSFELD").var(YI.get()).get(),1),1,150));
                    }
                  }
                  //<< . . . . . . IF $EXTRACT(YLFN)="F" IF YUMLAU=""  SET YSFELD(YMAX1,YI)=$EXTRACT($TRANSLATE(YSFELD(YI),LC,UC),1,150)  ;SPEED UP;TYBD;25.09.2004 ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                  if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                    if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
                      mVar YSFELD = m$.var("YSFELD");
                      YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YSFELD").var(YI.get()).get(),m$.var("LC").get(),m$.var("UC").get()),1,150));
                    }
                  }
                  //<< . . . . . . IF $EXTRACT(YLFN)="K" IF YUMLAU=""  SET YSFELD(YMAX1,YI)=$EXTRACT($TRANSLATE(YSFELD(YI),LC,UC),1,150)
                  if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                    if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
                      mVar YSFELD = m$.var("YSFELD");
                      YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YSFELD").var(YI.get()).get(),m$.var("LC").get(),m$.var("UC").get()),1,150));
                    }
                  }
                  //<< . . . . . . IF $EXTRACT(YLFN)="K" IF YUMLAU'="" SET YSFELD(YMAX1,YI)=$EXTRACT($$^WWWUMLAU(YSFELD(YI),1),1,150)
                  if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                    if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
                      mVar YSFELD = m$.var("YSFELD");
                      YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.var("YSFELD").var(YI.get()).get(),1),1,150));
                    }
                  }
                  //<< . . . . . . IF YSFELD(YMAX1,YI)="" SET YSFELD(YMAX1,YI)=" "
                  if (mOp.Equal(m$.var("YSFELD").var(YMAX1.get(),YI.get()).get(),"")) {
                    mVar YSFELD = m$.var("YSFELD");
                    YSFELD.var(YMAX1.get(),YI.get()).set(" ");
                  }
                  //<< . . . . . . SET YSDATEI(YMAX1)=YSDATEI(YMAX1)_","_""""_YSFELD(YMAX1,YI)_""""
                  YSDATEI.var(YMAX1.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),","),"\""),m$.var("YSFELD").var(YMAX1.get(),YI.get()).get()),"\""));
                }
              }
            }
            //<< . . . ;
            //<< . . . FOR YMAX1=1:1:YMAX DO
            for (YMAX1.set(1);(mOp.LessOrEqual(YMAX1.get(),YMAX.get()));YMAX1.set(mOp.Add(YMAX1.get(),1))) {
              do {
                //<< . . . . SET YQ=1
                YQ.set(1);
                //<< . . . . ;FOR YI=1:1:MAXYKEY SET KEY=$PIECE(YKEY,",",YI) SET YSDATEI(YMAX1)=YSDATEI(YMAX1)_","_""""_KEY_"""" IF KEY="" SET YQ=0
                //<< . . . . FOR YI=1:1:MAXYKEY SET KEY=$TRANSLATE($PIECE(YKEY,",",YI),"""") SET YSDATEI(YMAX1)=YSDATEI(YMAX1)_","_""""_KEY_"""" IF KEY="" SET YQ=0  ;FIS;06.08.04;26208; ALPHAN. KEY (IN ANFÜHRUNGSZEICHEN)
                for (YI.set(1);(mOp.LessOrEqual(YI.get(),m$.var("MAXYKEY").get()));YI.set(mOp.Add(YI.get(),1))) {
                  mVar KEY = m$.var("KEY");
                  KEY.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"\""));
                  YSDATEI.var(YMAX1.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),","),"\""),KEY.get()),"\""));
                  if (mOp.Equal(KEY.get(),"")) {
                    YQ.set(0);
                  }
                }
                //<< . . . . SET YSDATEI(YMAX1)=YSDATEI(YMAX1)_")"
                YSDATEI.var(YMAX1.get()).set(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),")"));
                //<< . . . . QUIT:YQ=0
                if (mOp.Equal(YQ.get(),0)) {
                  break;
                }
                //<< . . . . KILL @YSDATEI(YMAX1)
                m$.indirectVar(YSDATEI.var(YMAX1.get()).get()).kill();
              } while (false);
            }
          }
          m$.restoreVarBlock(3);
        } while (false);
      }
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SUBKILL
  public void SUBKILL() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Delete subforms from buttons
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Oct-2006   JW      SR15134: Newed variables
    //<< ;-------------------------------------------------------------------------------
    //<< new YLFN,YXXFORM,YXXDATEI
    mVar YLFN = m$.var("YLFN");
    mVar YXXFORM = m$.var("YXXFORM");
    mVar YXXDATEI = m$.var("YXXDATEI");
    m$.newVar(YLFN,YXXFORM,YXXDATEI);
    //<< 
    //<< set YLFN = ""
    YLFN.set("");
    //<< for {
    for (;true;) {
      //<< set YLFN = $order(^WWW124(0,YFORM,SPRACHE,YLFN))
      YLFN.set(m$.Fnc.$order(m$.var("^WWW124",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),YLFN.get())));
      //<< quit:YLFN=""
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      //<< 
      //<< set YXXFORM = $$$WWW124NewFormOnClick($get(^WWW124(0,YFORM,SPRACHE,YLFN,1)))
      YXXFORM.set(include.WWWConst.$$$WWW124NewFormOnClick(m$,m$.Fnc.$get(m$.var("^WWW124",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),YLFN.get(),1))));
      //<< if YXXFORM'="" {
      if (mOp.NotEqual(YXXFORM.get(),"")) {
        //<< if $$$WWW121FixedInputForHiddenField($get(^WWW121(0,YXXFORM,1,1)))=$$$YES {
        if (mOp.Equal(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,YXXFORM.get(),1,1))),include.COMSYS.$$$YES(m$))) {
          //<< set YXXDATEI=""
          YXXDATEI.set("");
          //<< for YI=1:1:MAXYKEY {
          mVar YI = m$.var("YI");
          for (YI.set(1);(mOp.LessOrEqual(YI.get(),m$.var("MAXYKEY").get()));YI.set(mOp.Add(YI.get(),1))) {
            //<< set KEY = $piece(YKEY,$$$COMMA,YI)
            mVar KEY = m$.var("KEY");
            KEY.set(m$.Fnc.$piece(m$.var("YKEY").get(),include.COMSYSString.$$$COMMA(m$),YI.get()));
            //<< set:KEY'="" YXXDATEI = YXXDATEI_","_""""_KEY_""""
            if (mOp.NotEqual(KEY.get(),"")) {
              YXXDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YXXDATEI.get(),","),"\""),KEY.get()),"\""));
            }
          }
          //<< }
          //<< set YXXDATEI=$extract(YXXDATEI,2,999)
          YXXDATEI.set(m$.Fnc.$extract(YXXDATEI.get(),2,999));
          //<< do ^WWWSKILL($$$WWW120ClassUsedInForm($get(^WWW120(0,YXXFORM,1))),YXXDATEI)
          m$.Cmd.Do("WWWSKILL.main",include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,YXXFORM.get(),1))),YXXDATEI.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< SUBKILL1
  public void SUBKILL1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Delete subforms that are specified on form def
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2009   GRF     field macro
    //<< ; 23-Oct-2006   JW      SR15134: Newed variables
    //<< ;-------------------------------------------------------------------------------
    //<< new YLFN,YXXFORM,YXXDATEI,YF,YI
    mVar YLFN = m$.var("YLFN");
    mVar YXXFORM = m$.var("YXXFORM");
    mVar YXXDATEI = m$.var("YXXDATEI");
    mVar YF = m$.var("YF");
    mVar YI = m$.var("YI");
    m$.newVar(YLFN,YXXFORM,YXXDATEI,YF,YI);
    //<< 
    //<< for YF=1:1 {
    for (YF.set(1);(true);YF.set(mOp.Add(YF.get(),1))) {
      //<< set YXXFORM = $piece($translate($$$WWW120DeleteAlsoTheFollowingSub(YVOR),",",";"),";",YF)
      YXXFORM.set(m$.Fnc.$piece(m$.Fnc.$translate(include.WWWConst.$$$WWW120DeleteAlsoTheFollowingSub(m$,m$.var("YVOR")),",",";"),";",YF.get()));
      //<< quit:YXXFORM=""
      if (mOp.Equal(YXXFORM.get(),"")) {
        break;
      }
      //<< 
      //<< if $$$WWW121FixedInputForHiddenField($get(^WWW121(0,YXXFORM,1,1)))=$$$YES {
      if (mOp.Equal(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,YXXFORM.get(),1,1))),include.COMSYS.$$$YES(m$))) {
        //<< set YXXDATEI=""
        YXXDATEI.set("");
        //<< for YI=1:1:MAXYKEY {
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),m$.var("MAXYKEY").get()));YI.set(mOp.Add(YI.get(),1))) {
          //<< set KEY = $piece(YKEY,$$$COMMA,YI)
          mVar KEY = m$.var("KEY");
          KEY.set(m$.Fnc.$piece(m$.var("YKEY").get(),include.COMSYSString.$$$COMMA(m$),YI.get()));
          //<< if KEY'="" {
          if (mOp.NotEqual(KEY.get(),"")) {
            //<< set:YXXDATEI'="" YXXDATEI = YXXDATEI_","
            if (mOp.NotEqual(YXXDATEI.get(),"")) {
              YXXDATEI.set(mOp.Concat(YXXDATEI.get(),","));
            }
            //<< set YXXDATEI = YXXDATEI_""""_KEY_""""
            YXXDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(YXXDATEI.get(),"\""),KEY.get()),"\""));
          }
        }
        //<< }
        //<< }
        //<< do ^WWWSKILL($$$WWW120ClassUsedInForm($get(^WWW120(0,YXXFORM,1))),YXXDATEI)
        m$.Cmd.Do("WWWSKILL.main",include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,YXXFORM.get(),1))),YXXDATEI.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< QUIT
    return;
  }

//<< 
//<< 
}
