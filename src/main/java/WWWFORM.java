//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:18
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

//<< WWWFORM
public class WWWFORM extends mClass {

  //<< 
  //<< #define LOGWWWBENCH(%i)
  public static Object $$$LOGWWWBENCH(mContext m$, Object ... _p) {
    mVar p$i = m$.varRef("p$i",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #;define LOGWWWBENCH(%i) if ($get(^SysSetup(14864,1)))&&($get(YSTARTTIME)'="")&&($get(YSTARTTIME1)'="")&&($get(YFORM)'="")&&($get(YBED)'="") set ^LogWWWBENCH(0,+$horolog,YSTARTTIME1,YFORM,YBED,$increment(^LogWWWBENCH(0,+$horolog,YSTARTTIME1,YFORM,YBED)),%i,1) = ($zhorolog - YSTARTTIME)_"~"_##class(alSYS.SYSTEM.Process).LinesExecuted($job)_"~"_$get(YDATEI)_"~"_$get(YUSER)_"~"_$get(YKEY)_"~"_$job_"~"_$select($stack(-1)>=0:$stack($stack(-1),"PLACE"),1:"")_"~"_$select($stack(-1)>=1:$stack($stack(-1)-1,"PLACE"),1:"")_"~"_$select($stack(-1)>=2:$stack($stack(-1)-2,"PLACE"),1:"")_"~"_$select($stack(-1)>=3:$stack($stack(-1)-3,"PLACE"),1:"")
  //<< 
  //<< #define jsMarker(%1)
  public static Object $$$jsMarker(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #;define jsMarker(%1)   write YCR,YCR,"<!-- ************************* ",%1," (WWWFORM)************************* -->",YCR,YCR
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
    _WWWFORM();
  }

  public void _WWWFORM() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORM("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       AUFRUF FORMULARE    - FORM CALLS  ;
    //<< ;   THIS ROUTINE IS THE MAIN ROUTINE, WHICH STEERS IN THE STRUCTURE OF FORMS.
    //<< ;            The CALL TAKES PLACE VIA URL WITH THE VARIABLES
    //<< ;   DIESE ROUTINE IST DIE HAUPTROUTINE, DIE IN DEN AUFBAU VON FORMULAREN STEUERT.
    //<< ;            DER AUFRUF ERFOLGT VIA URL MIT DEN VARIABLEN
    //<< ;
    //<< ; Inputs :
    //<< ;    EP     = WWWFORM     ;STARTET DIESE ROUTIENE
    //<< ;    YFORM  = FORMULANAME
    //<< ;    YKEY   = SCHLUESSEL
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 03-Sep-2013   shobby  CORE-86: Until this has proven reliable it is restricted to only the INReceipt form.
    //<< ; 21-Aug-2013   shobby  CORE-86: Clean out all WWWDATEN when changing tabs.
    //<< ; 13-Nov-2012   shobby  SR18183: Previous change extended to MEDPrescriptionSol form.
    //<< ; 08-Nov-2012   shobby  SR18182: Various changes to try and fix malformed HTML particularly
    //<< ;                                nested FORM to better control positioning of objects.
    //<< ;                                Bit risky so initially it is limited to only the
    //<< ;                                MEDPrescriptionHosp form.
    //<< ; 12-Apr-2012   shobby  SR17998: WWWBENCH now has an index.
    //<< ; 03-May-2010   GRF     SR15961: use dteToday for efficiency; Old comments cleanup
    //<< ; 23-Dec-2009   GRF     SR17095: Allow
    //<< ; 19-Nov-2009   shobby  SR17032: Disabled 'NumberOfHits' functionality.
    //<< ; 15-Jan-2009   GRF     SR15853: Pass audit string to NewUserSession
    //<< ; 20-Oct-2008   FIS     SR15824: force lock kill when form gets called from menu
    //<< ; 08-Oct-2008   FIS     SR15947: load old record after delete failed
    //<< ; 30-Sep-2008   FIS     SR15947: Changed WWWTransactionTable into WWWTransactionLine
    //<< ; 26-Sep-2008   FIS     SR15947: Implement Transaction Wrappers for "Execute
    //<< ;                           After Save" (form type 5), "Execute After Data
    //<< ;                           Fields", and "Execute After Primary Key"
    //<< ; 18-Sep-2008   shobby  BR014966: Use standard method to get form name
    //<< ; 27-Aug-2008   FIS     SR15824: if record is in-use, don't set lock at paging
    //<< ; 22-Aug-2008   FIS     SR15828: new WWWDATEN record (,4) (snapshot after form
    //<< ;                           creation) to compare before save WWWDATEN ,3
    //<< ;                           inactivated as it might not be required (only
    //<< ;                           commented out - just in case)
    //<< ; 19-Aug-2008   FIS     SR15853: create session in common routine
    //<< ; 12-Aug-2008   FIS     SR15828: new WWWDATEN record (,3) (snapshot before form
    //<< ;                           creation) to compare before save
    //<< ; 25-Jul-2008   GRF     SRBR014954: Doco only - renumber execute sequence;
    //<< ;                           remove 'new' entries from START
    //<< ; 19-Jun-2008   shobby  SRBR014955: Leave a bread crumb if the form was found to
    //<< ;                           be readonly so that customisation rules will be
    //<< ;                           prevented from running.
    //<< ; 18-Jun-2008   shobby  SRBR014954: Moved the OnBeforeEditAccess call to before
    //<< ;                           the call to WWWFORM8.  Otherwise if a form is
    //<< ;                           disabled here then the F12 key will still be active
    //<< ;                           (and records can still be saved)
    //<< ; 22-Jan-2008   GRF     SR15624: disable logging code - data location is being
    //<< ;                           repeatedly checked for need to log, probably slowing
    //<< ;                           form operation.
    //<< ; 07-Nov-2007   shobby  SRBR014769: New callout to OnBeforeFormConstruction to
    //<< ;                           adjust variables such as YKOPF and YVOR i.e. INWEINVD
    //<< ;                           can be changed from a 'Manual Form' to a 'Standard
    //<< ;                           Form' based on the condition of YPARA.
    //<< ; 01-Nov-2007   shobby  SRBR014748: Standard password check - $$CHECK^WWWPWDCHECK
    //<< ; 25-Oct-2007   FIS     SRBR014734: removed change into WWW0131WB
    //<< ; 04-Oct-2007   shobby  SRBR014734: If opening a new record clear the last
    //<< ;                           opened record key WWW126
    //<< ; 05-Jul-2007   GRF     Doco; once know WWW120 record has a non-null value don't
    //<< ;                           need $get; reuese macro
    //<< ; 02-May-2007   GRF     SR15509: YVOR will not be defined if YFORM is null; YEXEC
    //<< ;                           being newed incorrectly - move code to ExecButton.
    //<< ; 03-Apr-2007   GRF     SR15492: TerminationBy => TerminationOn
    //<< ; 13-Mar-2007   GRF     SR12505: Naked references
    //<< ; 09-Mar-2007   GRF     SR12505: use objFormKey; doco
    //<< ; 13-Nov-2006   GM      BR014107: Form name changes with customisation on Form screen
    //<< ; 13-Nov-2006   JW      SR14550: Pass in form to CalculateString
    //<< ; 19-Oct-2006   Steve S BR014293: Construct redirect data/macro usage
    //<< ; 18-Sep-2006   PO      SR14864: Added greater detail to log
    //<< ; 13-Sep-2006   PO      SR14864: Added logging
    //<< ; 26-Apr-2006   SC      SR14414: Check for VARHooks error msg, and display if found.
    //<< ; 13-Apr-2006   JW      Removed + from user id's in lock check
    //<< ; 29-Nov-2005   JW      SR13195: Keep data if only changing tabs
    //<< ; 21-Nov-2005   GRF     Correct dot levels
    //<< ; 16-Nov-2005   GRF     SR12505 : Doco
    //<< ; 19-Oct-2005   JW      SR13581 : If just changing tabs, keep grid info
    //<< ; 07-Jul-2005   shobby  SR12892 : WWW126 is no longer shared.
    //<< ; 30-May-2005   RobertW SR12056 : Attempt at Performance Increase
    //<< ; 05.Aug.1997   DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< new (%request,%session,%KEY,%,%ZCS,%CGIEVAR,NOKILL)
    mVar NOKILL = m$.var("NOKILL");
    m$.newVarExcept(NOKILL);
    //<< 
    //<< $$$LogR("","")
    $$$LogR(m$,"","");
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   YVORB       objWWW013   Users
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< set YSTARTTIME  = $zhorolog   ;STARTZEIT DES FORMULARS
    mVar YSTARTTIME = m$.var("YSTARTTIME");
    YSTARTTIME.set(m$.Fnc.$zhorolog());
    //<< set YSTARTTIME1 = $piece($horolog,",",2)
    mVar YSTARTTIME1 = m$.var("YSTARTTIME1");
    YSTARTTIME1.set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
    //<< do ^WWWVAR                    ;VORGABEN SETZEN ; set default values
    m$.Cmd.Do("WWWVAR.main");
    //<< 
    //<< ;if YOPEN'=2 if YFORM'="WWWPARA" if YFORM'="COMViewSearch" kill ^WWWDATEN(YM,+$h,YUSER) ;CORE-86
    //<< if YOPEN'=2 if YFORM="INReceipt" kill ^WWWDATEN(YM,+$h,YUSER) ;CORE-86
    if (mOp.NotEqual(m$.var("YOPEN").get(),2)) {
      if (mOp.Equal(m$.var("YFORM").get(),"INReceipt")) {
        m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get()).kill();
      }
    }
    //<< 
    //<< if +$get(%(YQUERY,"YFORMWAIT"))'=0 hang %(YQUERY,"YFORMWAIT")  ;TYBD;WARTEN VOR DEM START  ;wait for pre- take-off
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YFORMWAIT"))),0)) {
      m$.Cmd.Hang(m$.var("%",m$.var("YQUERY").get(),"YFORMWAIT").get());
    }
    //<< if $get(%(YQUERY,"YSTARTFORM"))'="" if YFORM="WWWBLANK" set YFORM = %(YQUERY,"YSTARTFORM")  ;FIS;08.07.04;VORGEBEN STARTFORMULAR ;purport
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YSTARTFORM")),"")) {
      if (mOp.Equal(m$.var("YFORM").get(),"WWWBLANK")) {
        mVar YFORM = m$.var("YFORM");
        YFORM.set(m$.var("%",m$.var("YQUERY").get(),"YSTARTFORM").get());
      }
    }
    //<< 
    //<< set YTABLEANZ = 0
    mVar YTABLEANZ = m$.var("YTABLEANZ");
    YTABLEANZ.set(0);
    //<< set YHTMFORM  = "WWW"
    mVar YHTMFORM = m$.var("YHTMFORM");
    YHTMFORM.set("WWW");
    //<< 
    //<< $$$LOGWWWBENCH(1)
    $$$LOGWWWBENCH(m$,1);
    //<< set dteToday = +$horolog    ; SR15961
    mVar dteToday = m$.var("dteToday");
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  Form Substitution   *** EXECUTE 1 ***
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if ($get(YFORM)'="") && ($$$WWW120AlternativeFormName($get(^WWW120(0,YFORM,1)))'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW120AlternativeFormName(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1))),""))) {
      //<< if $$$WWW120WhenTermInTrue(^WWW120(0,YFORM,1))'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW120WhenTermInTrue(m$,m$.var("^WWW120",0,m$.var("YFORM").get(),1)),"")) {
        //<< xecute $$$WWW120WhenTermInTrue(^WWW120(0,YFORM,1))
        m$.Cmd.Xecute(include.WWWConst.$$$WWW120WhenTermInTrue(m$,m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
        //<< if $test set YFORM=$$$WWW120AlternativeFormName(^WWW120(0,YFORM,1)) set %(YQUERY,"YFORM")=YFORM
        if (mOp.Logical(m$.Fnc.$test())) {
          mVar YFORM = m$.var("YFORM");
          YFORM.set(include.WWWConst.$$$WWW120AlternativeFormName(m$,m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
          m$.var("%",m$.var("YQUERY").get(),"YFORM").set(YFORM.get());
        }
      }
    }
    //<< }
    //<< }
    //<< ;SR17998 if ($get(YBED)'="") && ($get(YFORM)'="") set ^WWWBENCH(0,dteToday,YSTARTTIME1,YFORM,YBED,1)=""  ;SAVE BENCHMARK
    //<< if ($get(YBED)'="") && (YFORM'="") new strStatus set strStatus=$$Save^COMUtils("WWWBENCH",dteToday_","_YSTARTTIME1_","_YFORM_","_YBED,"",1)  ;SAVE BENCHMARK ;SR17998
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) && (mOp.NotEqual(m$.var("YFORM").get(),""))) {
      mVar strStatus = m$.var("strStatus");
      m$.newVar(strStatus);
      //TODO REVISAR SAVE strStatus.set(m$.fnc$("COMUtils.Save","WWWBENCH",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(dteToday.get(),","),YSTARTTIME1.get()),","),m$.var("YFORM").get()),","),m$.var("YBED").get()),"",1));
    }
    //<< ;START EINSPRUNG VON AUSSEN ;take-off
    //<< set $ztrap="^WWWERROR"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("^WWWERROR");
    //<< if $get(SPRACHE)="" set SPRACHE="DE"                ; FIXME : "EN" ?
    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"")) {
      mVar SPRACHE = m$.var("SPRACHE");
      SPRACHE.set("DE");
    }
    //<< ;------------------------------------------------------------------------
    //<< ;WENN ZEITABHÄNGIGE ERFASSUNG ;when logging
    //<< set YTIMEFORM=""
    mVar YTIMEFORM = m$.var("YTIMEFORM");
    YTIMEFORM.set("");
    //<< if (YKILL=1) || (YKILL=2) if $get(%(YQUERY,"YTIMEFORM"))=1 set YTIMEFORM = 1  ;KILL IN TIMEFORMULAR;FIS:19.08.04 ;within
    if ((mOp.Equal(m$.var("YKILL").get(),1)) || (mOp.Equal(m$.var("YKILL").get(),2))) {
      if (mOp.Equal(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YTIMEFORM")),1)) {
        YTIMEFORM.set(1);
      }
    }
    //<< if ($get(YFORM)'="") && ($extract(YFORM,$length(YFORM))="t") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.Equal(m$.Fnc.$extract(m$.var("YFORM").get(),m$.Fnc.$length(m$.var("YFORM").get())),"t"))) {
      //<< if $data(^WWW120(0,$extract(YFORM,1,$length(YFORM)-1))) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW120",0,m$.Fnc.$extract(m$.var("YFORM").get(),1,mOp.Subtract(m$.Fnc.$length(m$.var("YFORM").get()),1)))))) {
        //<< set YFORM     = $extract(YFORM,1,$length(YFORM)-1)
        mVar YFORM = m$.var("YFORM");
        YFORM.set(m$.Fnc.$extract(m$.var("YFORM").get(),1,mOp.Subtract(m$.Fnc.$length(m$.var("YFORM").get()),1)));
        //<< set YTIMEFORM = 1
        YTIMEFORM.set(1);
      }
    }
    //<< }
    //<< }
    //<< ;------------------------------------------------------------------------
    //<< ;WENN MENUESTRUKTUR ;when
    //<< if $get(YFORM)="WWWEXPLORER" do  quit                                ; ***   EARLY EXIT   ***
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"WWWEXPLORER")) {
      do {
        //<< . new YVOR
        mVar YVOR = m$.var("YVOR");
        m$.newVar(YVOR);
        //<< . set YFORM = $get(%(YQUERY,"YFORM"))
        mVar YFORM = m$.var("YFORM");
        YFORM.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YFORM")));
        //<< . quit:YFORM=""                                         ; YVOR will not be defined if YFORM is null.
        if (mOp.Equal(YFORM.get(),"")) {
          break;
        }
        //<< . ;
        //<< . if YFORM'="" set YVOR = $get(^WWW120(0,YFORM,1))
        if (mOp.NotEqual(YFORM.get(),"")) {
          YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)));
        }
        //<< . set %(YQUERY,"FIX")     = $get(%(YQUERY,"YFORM"))                  ;MENUENAME
        m$.var("%",m$.var("YQUERY").get(),"FIX").set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YFORM")));
        //<< . set %(YQUERY,"OFFSET1") = $get(%(YQUERY,"YFORM"))                  ;MENUENAME
        m$.var("%",m$.var("YQUERY").get(),"OFFSET1").set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YFORM")));
        //<< . set %(YQUERY,"PWD")     = $translate($get(%(YQUERY,"YPARA")),"~")  ;PARAMETER AUS MENU=PASSWORT ;parameter out of
        m$.var("%",m$.var("YQUERY").get(),"PWD").set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YPARA")),"~"));
        //<< . set %(YQUERY,"FILE")    = "WWWEXPLORE"                             ;VERZEICHNIS NAME ;tabulation Name
        m$.var("%",m$.var("YQUERY").get(),"FILE").set("WWWEXPLORE");
        //<< . set %(YQUERY,"HEAD")    = $$$WWW120FormHeaderOrImageFile(YVOR)     ;NAME DES VERZEICHNISSES
        m$.var("%",m$.var("YQUERY").get(),"HEAD").set(include.WWWConst.$$$WWW120FormHeaderOrImageFile(m$,YVOR));
        //<< . set %(YQUERY,"TARGET")  = $$$WWW120TargetNameForOutput(YVOR)       ;TARGET
        m$.var("%",m$.var("YQUERY").get(),"TARGET").set(include.WWWConst.$$$WWW120TargetNameForOutput(m$,YVOR));
        //<< . do ^WWWEXPLORER  ;EXPLORER MENUESTRUKTUR
        m$.Cmd.Do("WWWEXPLORER.main");
      } while (false);
      return;
    }
    //<< ;------------------------------------------------------------------------
    //<< if (YKILL=1) && ($get(NOKILL)=1) set YKILL="" kill NOKILL  ;KEIN LÖSCHEN ;no Delete
    if ((mOp.Equal(m$.var("YKILL").get(),1)) && (mOp.Equal(m$.Fnc.$get(NOKILL),1))) {
      mVar YKILL = m$.var("YKILL");
      YKILL.set("");
      NOKILL.kill();
    }
    //<< 
    //<< do ExecButton(YFORM,$get(YBUTTON),YOPEN)        ; *** EXECUTE 2 ***
    m$.Cmd.Do("ExecButton",m$.var("YFORM").get(),m$.Fnc.$get(m$.var("YBUTTON")),m$.var("YOPEN").get());
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ; NEUER USER NACH ANMELDUNG ;within registration
    //<< set (YBUTTON,YNUMMER,YMAXKEY) = ""
    mVar YBUTTON = m$.var("YBUTTON");
    YBUTTON.set("");
    mVar YNUMMER = m$.var("YNUMMER");
    YNUMMER.set("");
    mVar YMAXKEY = m$.var("YMAXKEY");
    YMAXKEY.set("");
    //<< if (YUSER="") && (YBED'="") {
    if ((mOp.Equal(m$.var("YUSER").get(),"")) && (mOp.NotEqual(m$.var("YBED").get(),""))) {
      //<< set YUSER = $$NewUserSession^WWWUSER("WWWFORM")
      mVar YUSER = m$.var("YUSER");
      YUSER.set(m$.fnc$("WWWUSER.NewUserSession","WWWFORM"));
      //<< set ^WWWUSER(0,YUSER,1) = $$$UPPER(YPWD)_Y_YBED_Y_dteToday_Y_$piece($horolog,",",2)
      m$.var("^WWWUSER",0,YUSER.get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYSString.$$$UPPER(m$,m$.var("YPWD")),m$.var("Y").get()),m$.var("YBED").get()),m$.var("Y").get()),dteToday.get()),m$.var("Y").get()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2)));
      //<< set %("VAR","YUSER")    = YUSER
      m$.var("%","VAR","YUSER").set(YUSER.get());
    }
    //<< }
    //<< ;------------------------------------------------------------------------
    //<< ; ALTEN DATENSATZ ZURÜCKHOLEN ;data record
    //<< if (YUSER'="") && (YFORM'="") && ($data(^WWWUSE(0,YUSER,YFORM,"P",1))) {
    if ((mOp.NotEqual(m$.var("YUSER").get(),"")) && (mOp.NotEqual(m$.var("YFORM").get(),"")) && mOp.Logical((m$.Fnc.$data(m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1))))) {
      //<< set FFKEY  = $get(^WWWUSE(0,YUSER,YFORM,"P",1))
      mVar FFKEY = m$.var("FFKEY");
      FFKEY.set(m$.Fnc.$get(m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1)));
      //<< set YKEY   = FFKEY
      mVar YKEY = m$.var("YKEY");
      YKEY.set(FFKEY.get());
      //<< set FMFELD = $get(^WWWUSE(0,YUSER,YFORM,"M",1))
      mVar FMFELD = m$.var("FMFELD");
      FMFELD.set(m$.Fnc.$get(m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),"M",1)));
      //<< set FFFELD = $get(^WWWUSE(0,YUSER,YFORM,"D",1))
      mVar FFFELD = m$.var("FFFELD");
      FFFELD.set(m$.Fnc.$get(m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1)));
      //<< set FFFORM = YFORM                               ;TYBD;24.11.2003; WACH: MANUELLER EINPRUNG
      mVar FFFORM = m$.var("FFFORM");
      FFFORM.set(m$.var("YFORM").get());
      //<< set YOPEN  = "OLD"
      mVar YOPEN = m$.var("YOPEN");
      YOPEN.set("OLD");
      //<< kill ^WWWUSE(0,YUSER)
      m$.var("^WWWUSE",0,m$.var("YUSER").get()).kill();
    }
    //<< }
    //<< ;------------------------------------------------------------------------
    //<< ;VORGABEN AUS ALTEM DATENSATZ ;out of data record
    //<< if YOPEN="OLD" {
    if (mOp.Equal(m$.var("YOPEN").get(),"OLD")) {
      //<< set YYFELD = "",YYKEY = "",YMFELD = ""
      mVar YYFELD = m$.var("YYFELD");
      YYFELD.set("");
      mVar YYKEY = m$.var("YYKEY");
      YYKEY.set("");
      mVar YMFELD = m$.var("YMFELD");
      YMFELD.set("");
      //<< if ($get(FFFORM)'="") && (FFFORM=YFORM) {
      if ((mOp.NotEqual(m$.Fnc.$get(m$.var("FFFORM")),"")) && (mOp.Equal(m$.var("FFFORM").get(),m$.var("YFORM").get()))) {
        //<< set YYFELD = $get(FFFELD)
        YYFELD.set(m$.Fnc.$get(m$.var("FFFELD")));
        //<< set YYKEY  = $get(FFKEY)
        YYKEY.set(m$.Fnc.$get(m$.var("FFKEY")));
        //<< set YMFELD = $get(FMFELD)
        YMFELD.set(m$.Fnc.$get(m$.var("FMFELD")));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ; Fixed Inputs for Hidden Keys
    //<< ; - Load Keys for sub-form from calling form
    //<< ; - Set to specified value
    //<< ; - Set to value of @variable
    //<< ;---------------------------------------
    //<< set YII = 1
    mVar YII = m$.var("YII");
    YII.set(1);
    //<< if (YFORM'="") && ($$$WWW121FixedInputForHiddenField($get(^WWW121(0,YFORM,2,1)))'="") {
    if ((mOp.NotEqual(m$.var("YFORM").get(),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),2,1))),""))) {
      //<< set YII = 2    ; Find number of primary keys YII
      YII.set(2);
      //<< if $$$WWW121FixedInputForHiddenField($get(^WWW121(0,YFORM,3,1)))'="" set YII=3
      if (mOp.NotEqual(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),3,1))),"")) {
        YII.set(3);
      }
      //<< if $$$WWW121FixedInputForHiddenField($get(^WWW121(0,YFORM,4,1)))'="" set YII=4
      if (mOp.NotEqual(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),4,1))),"")) {
        YII.set(4);
      }
      //<< if $$$WWW121FixedInputForHiddenField($get(^WWW121(0,YFORM,5,1)))'="" set YII=5
      if (mOp.NotEqual(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),5,1))),"")) {
        YII.set(5);
      }
      //<< if $$$WWW121FixedInputForHiddenField($get(^WWW121(0,YFORM,6,1)))'="" set YII=6
      if (mOp.NotEqual(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),6,1))),"")) {
        YII.set(6);
      }
      //<< if $$$WWW121FixedInputForHiddenField($get(^WWW121(0,YFORM,7,1)))'="" set YII=7
      if (mOp.NotEqual(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),7,1))),"")) {
        YII.set(7);
      }
    }
    //<< }
    //<< 
    //<< for YI=1:1:YII if (YKILL="") && (YRICHT="") && (YFORM'="") do  ;PRUEFEN PRIM-KEY, WENN KEIN PRIM DANN ALTES PROGRAMM LADEN  ;TYBD 14.02.2002/20.02.2002
    mVar YI = m$.var("YI");
    for (YI.set(1);(mOp.LessOrEqual(YI.get(),YII.get()));YI.set(mOp.Add(YI.get(),1))) {
      if ((mOp.Equal(m$.var("YKILL").get(),"")) && (mOp.Equal(m$.var("YRICHT").get(),"")) && (mOp.NotEqual(m$.var("YFORM").get(),""))) {
        do {
          //<< . new fixedInput,objFormKey
          mVar fixedInput = m$.var("fixedInput");
          mVar objFormKey = m$.var("objFormKey");
          m$.newVar(fixedInput,objFormKey);
          //<< . set objFormKey = $get(^WWW121(0,YFORM,YI,1))
          objFormKey.set(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YI.get(),1)));
          //<< . set fixedInput = $$$WWW121FixedInputForHiddenField(objFormKey)
          fixedInput.set(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,objFormKey));
          //<< . quit:fixedInput=""         ;KEIN FIXKEY ;no
          if (mOp.Equal(fixedInput.get(),"")) {
            break;
          }
          //<< . ;
          //<< . ;------------------------------------- When YKEY has a non-null value for this key
          //<< . ;
          //<< . if ($piece(YKEY,",",YI)'="") && (fixedInput=0) && ($piece(YFKEY,",",$$$WWW121DefaultVariableInput(objFormKey))="") do  quit
          if ((mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) && (mOp.Equal(fixedInput.get(),0)) && (mOp.Equal(m$.Fnc.$piece(m$.var("YFKEY").get(),",",include.WWWConst.$$$WWW121DefaultVariableInput(m$,objFormKey)),""))) {
            //<< . . set $piece(YFKEY,",",fixedInput) = $piece(YKEY,",",YI)
            m$.pieceVar(m$.var("YFKEY"),",",fixedInput.get()).set(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()));
            break;
          }
          //<< . . ; FIXME : fixedInput=0 !!! Should this be copying the YI piece to the YI piece? <GRF>
          //<< . ;
          //<< . if ($piece(YKEY,",",YI)'="") && (+fixedInput'=0) do  quit
          if ((mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) && (mOp.NotEqual(mOp.Positive(fixedInput.get()),0))) {
            //<< . . if $piece(YFKEY,",",fixedInput)="" set $piece(YFKEY,",",fixedInput) = $piece(YKEY,",",YI)
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YFKEY").get(),",",fixedInput.get()),"")) {
              m$.pieceVar(m$.var("YFKEY"),",",fixedInput.get()).set(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()));
            }
            break;
          }
          //<< . ;
          //<< . quit:$piece(YFKEY,",",YI)'=""
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get()),"")) {
            break;
          }
          //<< . ;
          //<< . ;------------------------------------- When YKEY has a null value for this key
          //<< . ;
          //<< . if $$$WWW121DefaultVariableInput(objFormKey)'="" do  quit  ;SETZEN FIXKEY ;typeset
          if (mOp.NotEqual(include.WWWConst.$$$WWW121DefaultVariableInput(m$,objFormKey),"")) {
            //<< . . new YINHALT
            mVar YINHALT = m$.var("YINHALT");
            m$.newVar(YINHALT);
            //<< . . set YINHALT = $$$WWW121DefaultVariableInput(objFormKey)    ;VORGABE ;default
            YINHALT.set(include.WWWConst.$$$WWW121DefaultVariableInput(m$,objFormKey));
            //<< . . set $piece(YFKEY,",",YI) = YINHALT
            m$.pieceVar(m$.var("YFKEY"),",",YI.get()).set(YINHALT.get());
            //<< . . if +YINHALT=0 do
            if (mOp.Equal(mOp.Positive(YINHALT.get()),0)) {
              //<< . . . set $piece(YFKEY,",",YI)=YINHALT
              m$.pieceVar(m$.var("YFKEY"),",",YI.get()).set(YINHALT.get());
              //<< . . . ; FIXME JW - this will cause a syntax error. Should be calling CalculateString^WWWFORMD
              //<< . . . if ($extract(YINHALT)="@") && $data(@($extract(YINHALT,2,99))) do
              if ((mOp.Equal(m$.Fnc.$extract(YINHALT.get()),"@")) && mOp.Logical(m$.Fnc.$data(m$.indirectVar((m$.Fnc.$extract(YINHALT.get(),2,99)))))) {
                //<< . . . . set YINHALT = @($extract(YINHALT,2,99))
                YINHALT.set(m$.indirectVar((m$.Fnc.$extract(YINHALT.get(),2,99))).get());
                //<< . . . . set $piece(YFKEY,",",YI) = YINHALT
                m$.pieceVar(m$.var("YFKEY"),",",YI.get()).set(YINHALT.get());
                //<< . . . . set $piece(YKEY,",",YI)  = YINHALT
                m$.pieceVar(m$.var("YKEY"),",",YI.get()).set(YINHALT.get());
              }
            }
            break;
          }
          //<< . ;
          //<< . ;------------------------------------- ELSE case for previous IF test
          //<< . ;
          //<< . ;AUFBAU RÜCKBUTTON NUR BEIM 1. ;only
          //<< . set YBACK1 = $piece(YBACK,",",$length(YBACK,",")-1)
          mVar YBACK1 = m$.var("YBACK1");
          YBACK1.set(m$.Fnc.$piece(m$.var("YBACK").get(),",",mOp.Subtract(m$.Fnc.$length(m$.var("YBACK").get(),","),1)));
          //<< . set YBACK2 = $piece(YBACK,",",1,$length(YBACK,",")-2)_","
          mVar YBACK2 = m$.var("YBACK2");
          YBACK2.set(mOp.Concat(m$.Fnc.$piece(m$.var("YBACK").get(),",",1,mOp.Subtract(m$.Fnc.$length(m$.var("YBACK").get(),","),2)),","));
          //<< . set %("VAR","YFORM") = YBACK1
          m$.var("%","VAR","YFORM").set(YBACK1.get());
          //<< . set %("VAR","YBACK") = YBACK2
          m$.var("%","VAR","YBACK").set(YBACK2.get());
          //<< . set YFORM = YBACK1
          mVar YFORM = m$.var("YFORM");
          YFORM.set(YBACK1.get());
          //<< . set YBACK = YBACK2
          mVar YBACK = m$.var("YBACK");
          YBACK.set(YBACK2.get());
        } while (false);
      }
    }
    //<< 
    //<< ;--------------------------------------- vvvvv  EARLY EXIT BLOCK
    //<< ; User Validation
    //<< ;---------------------------------------
    //<< if YUSER=""                                         do ^WWWINFO($$^WWWTEXT(5)) quit   ; "Access Denied!"   FALSCHER USER
    if (mOp.Equal(m$.var("YUSER").get(),"")) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< if $$$WWWUSERUser1($get(^WWWUSER(0,YUSER,1)))'=YBED do ^WWWINFO($$^WWWTEXT(5)) quit
    if (mOp.NotEqual(include.WWWConst.$$$WWWUSERUser1(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1))),m$.var("YBED").get())) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< if '$data(^WWW013(0,YBED)) set YUSER=""             do ^WWWINFO($$^WWWTEXT(5)) quit
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW013",0,m$.var("YBED").get())))) {
      mVar YUSER = m$.var("YUSER");
      YUSER.set("");
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< 
    //<< set YVORB = $get(^WWW013(0,YBED,1))   ;User Defaults
    mVar YVORB = m$.var("YVORB");
    YVORB.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
    //<< if '$$CHECK^WWWPWDCHECK($$$WWWUSERUser1(YVORB),YPWD) set YUSER="" do ^WWWINFO($$^WWWTEXT(5)) quit
    if (mOp.Not(m$.fnc$("WWWPWDCHECK.CHECK",include.WWWConst.$$$WWWUSERUser1(m$,YVORB),m$.var("YPWD").get()))) {
      mVar YUSER = m$.var("YUSER");
      YUSER.set("");
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< if $$$WWW013TerminationOn(YVORB)'="" if $$$WWW013EmployeeCategory(YVORB)'=999 if $horolog>$$$WWW013TerminationOn(YVORB) do ^WWWINFO($$^WWWTEXT(5)) quit  ;GEKÜNDIGT  ;TYBD;3,12,2003 ; SR15492
    if (mOp.NotEqual(include.WWWConst.$$$WWW013TerminationOn(m$,YVORB),"")) {
      if (mOp.NotEqual(include.WWWConst.$$$WWW013EmployeeCategory(m$,YVORB),999)) {
        if (mOp.Greater(m$.Fnc.$horolog(),include.WWWConst.$$$WWW013TerminationOn(m$,YVORB))) {
          m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
          return;
        }
      }
    }
    //<< if YUSER="" do ^WWWINFO($$^WWWTEXT(5)) quit
    if (mOp.Equal(m$.var("YUSER").get(),"")) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;USER @net Manager
    //<< if $extract(YFORM,1,3)="WWW" if YFORM'="WWW128" if $find("WWW00,WWW12,WWW13",$extract(YFORM,1,5)) if $$^WWWKEY($get(YIPADDR))=0 do ^WWWINFO($$^WWWTEXT(412)) quit  ;KEINE LIZENZ ;no licence
    if (mOp.Equal(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
      if (mOp.NotEqual(m$.var("YFORM").get(),"WWW128")) {
        if (mOp.Logical(m$.Fnc.$find("WWW00,WWW12,WWW13",m$.Fnc.$extract(m$.var("YFORM").get(),1,5)))) {
          if (mOp.Equal(m$.fnc$("WWWKEY.main",m$.Fnc.$get(m$.var("YIPADDR"))),0)) {
            m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",412));
            return;
          }
        }
      }
    }
    //<< 
    //<< ;--------------------------------------- ^^^^^  EARLY EXIT BLOCK
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< 
    //<< set YBER  = $$$WWW013UserAccess(YVORB)
    mVar YBER = m$.var("YBER");
    YBER.set(include.WWWConst.$$$WWW013UserAccess(m$,YVORB));
    //<< set YMOD  = $$$WWW013Module1(YVORB)
    mVar YMOD = m$.var("YMOD");
    YMOD.set(include.WWWConst.$$$WWW013Module1(m$,YVORB));
    //<< 
    //<< ; Use or update last form used by user     ;LETZTE FORM DES USER
    //<< if YFORM="" set YFORM = $$$WWW013LastFormUsed(YVORB)
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      mVar YFORM = m$.var("YFORM");
      YFORM.set(include.WWWConst.$$$WWW013LastFormUsed(m$,YVORB));
    }
    //<< 
    //<< if YFORM="WWW120" {      ; FIXME : Should not be updating user masterfile with Audit log details <GRF>
    if (mOp.Equal(m$.var("YFORM").get(),"WWW120")) {
      //<< set $$$WWW013LastFormUsed(^WWW013(0,YBED,1)) = $piece($get(YKEY),",",1)
      include.WWWConst.$$$WWW013LastFormUsedSet(m$,m$.var("^WWW013",0,m$.var("YBED").get(),1),m$.Fnc.$piece(m$.Fnc.$get(m$.var("YKEY")),",",1));
    }
    //<< } else {
    else {
      //<< set $$$WWW013LastFormUsed(^WWW013(0,YBED,1)) = YFORM
      include.WWWConst.$$$WWW013LastFormUsedSet(m$,m$.var("^WWW013",0,m$.var("YBED").get(),1),m$.var("YFORM").get());
    }
    //<< }
    //<< 
    //<< if YFORM=""                 do ^WWWINFO($$^WWWTEXT(35)_"()")           quit    ;KEINE FORM   ; "No Form Default"
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      m$.Cmd.Do("WWWINFO.main",mOp.Concat(m$.fnc$("WWWTEXT.main",35),"()"));
      return;
    }
    //<< if '$data(^WWW120(0,YFORM)) do ^WWWINFO($$^WWWTEXT(35)_" ("_YFORM_")") quit    ;FALSCHE FORM ; bad form
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW120",0,m$.var("YFORM").get())))) {
      m$.Cmd.Do("WWWINFO.main",mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",35)," ("),m$.var("YFORM").get()),")"));
      return;
    }
    //<< 
    //<< set YI = $get(^WWW1205(0,YFORM,dteToday,1))+1
    YI.set(mOp.Add(m$.Fnc.$get(m$.var("^WWW1205",0,m$.var("YFORM").get(),dteToday.get(),1)),1));
    //<< set ^WWW1205(0,YFORM,dteToday,1) = YI                           ;ANZAHL DER ZUGRIFFE PER DATUM ;Number the Date
    m$.var("^WWW1205",0,m$.var("YFORM").get(),dteToday.get(),1).set(YI.get());
    //<< 
    //<< ;BEC;24415;28.10.03;SETZTEN ZUGRIFF PRO USER
    //<< set YI = $get(^WWW1205B(0,YFORM,YBED,dteToday,1))+1
    YI.set(mOp.Add(m$.Fnc.$get(m$.var("^WWW1205B",0,m$.var("YFORM").get(),m$.var("YBED").get(),dteToday.get(),1)),1));
    //<< set ^WWW1205B(0,YFORM,YBED,dteToday,1) = YI  ;ANZAHL DER ZUGRIFFE PER DATUM/YBED ;Number the
    m$.var("^WWW1205B",0,m$.var("YFORM").get(),m$.var("YBED").get(),dteToday.get(),1).set(YI.get());
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< do ^WWWFORMX        ; Set Form Values from Company Defaults
    m$.Cmd.Do("WWWFORMX.main");
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ; Returns
    //<< ;   YVOR        objWWW120       Form details (with Company Defaults)
    //<< ;   YVOR1       objWWW012       Company details
    //<< ;   YVORB       objWWW013       Users
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< if $data(YAENBER) if +YAENBER'=0 set $$$WWW120AuthorizationToModifyData(YVOR) = YAENBER  ;AENDERUNGSBERECHTIGUNG
    if (mOp.Logical(m$.Fnc.$data(m$.var("YAENBER")))) {
      if (mOp.NotEqual(mOp.Positive(m$.var("YAENBER").get()),0)) {
        include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),m$.var("YAENBER").get());
      }
    }
    //<< 
    //<< ;SPEZIALVARIABLE ZUGANG FÜR BETRIEBE;TYBD;23957;28.07.2003
    //<< ;   D104    $$$WWW013AllowedLocations()
    //<< ;   D32     $$$WWW012VariableNameForLocationCh() [eck]
    //<< if $$$WWW012VariableNameForLocationCh(YVOR1)'="" if $translate($piece(YVORB,Y,104),";,")'="" if $get(@($piece(YVOR1,Y,32)))'="" if $data(^WWW0121(0,0,@($piece(YVOR1,Y,32)))) if '$find(","_$translate($piece(YVORB,Y,104),";",",")_",",","_@($piece(YVOR1,Y,32))_",") do ^WWWINFO($$^WWWTEXT(5)) quit
    if (mOp.NotEqual(include.WWWConst.$$$WWW012VariableNameForLocationCh(m$,m$.var("YVOR1")),"")) {
      if (mOp.NotEqual(m$.Fnc.$translate(m$.Fnc.$piece(YVORB.get(),m$.var("Y").get(),104),";,"),"")) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),32)))),"")) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0121",0,0,m$.indirectVar((m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),32))).get())))) {
            if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YVORB.get(),m$.var("Y").get(),104),";",",")),","),mOp.Concat(mOp.Concat(",",m$.indirectVar((m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),32))).get()),",")))) {
              m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
              return;
            }
          }
        }
      }
    }
    //<< ; "Access Denied!"
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;MODULE/BERECHTIGUNG
    //<< if $$^WWWACCESS($$$WWW120UserAccess(YVOR),$$$WWW120Modules(YVOR))'=1 if '$data(^WWWUSE(0,YUSER,YFORM,"A",1)) do ^WWWINFO($$^WWWTEXT(5)) quit
    if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",include.WWWConst.$$$WWW120UserAccess(m$,m$.var("YVOR")),include.WWWConst.$$$WWW120Modules(m$,m$.var("YVOR"))),1)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),"A",1)))) {
        m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
        return;
      }
    }
    //<< ; "Access Denied!"
    //<< ;------------------------------------------------------------------------
    //<< 
    //<< // Definition of: YKOPF, YNAME, YFOART, YDATEI
    //<< 
    //<< set YKOPF = $$^WWWFORMNAME(YFORM)
    mVar YKOPF = m$.var("YKOPF");
    YKOPF.set(m$.fnc$("WWWFORMNAME.main",m$.var("YFORM").get()));
    //<< 
    //<< set YNAME = YKOPF
    mVar YNAME = m$.var("YNAME");
    YNAME.set(YKOPF.get());
    //<< set objWWW120D = $get(^WWW120D(0,YFORM,0,1))
    mVar objWWW120D = m$.var("objWWW120D");
    objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",0,m$.var("YFORM").get(),0,1)));
    //<< if $$$WWW120OnBeforeFormConstruction(YVOR)'="" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW120OnBeforeFormConstruction(m$,m$.var("YVOR")),"")) {
      //<< xecute $$$WWW120OnBeforeFormConstruction(YVOR)          ;*** EXECUTE 2a ***
      m$.Cmd.Xecute(include.WWWConst.$$$WWW120OnBeforeFormConstruction(m$,m$.var("YVOR")));
      //<< set YNAME = YKOPF
      YNAME.set(YKOPF.get());
    }
    //<< }
    //<< if $$$WWW120DOnBeforeFormConstruction(objWWW120D)'="" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW120DOnBeforeFormConstruction(m$,objWWW120D),"")) {
      //<< xecute $$$WWW120DOnBeforeFormConstruction(objWWW120D)   ;*** EXECUTE 2b ***
      m$.Cmd.Xecute(include.WWWConst.$$$WWW120DOnBeforeFormConstruction(m$,objWWW120D));
      //<< set YNAME = YKOPF
      YNAME.set(YKOPF.get());
    }
    //<< }
    //<< if YNAME="" set YNAME = YKOPF
    if (mOp.Equal(YNAME.get(),"")) {
      YNAME.set(YKOPF.get());
    }
    //<< 
    //<< set YFOART = $$$WWW120FormType(YVOR)         ;FORMULARART
    mVar YFOART = m$.var("YFOART");
    YFOART.set(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")));
    //<< if YFOART="" set YFOART=2                  ;DFLT
    if (mOp.Equal(YFOART.get(),"")) {
      YFOART.set(2);
    }
    //<< 
    //<< set YDATEI = $$$WWW120ClassUsedInForm(YVOR)
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.var("YVOR")));
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ; YFOART    Form Type       (SysApp "FORMULARART")
    //<< ;
    //<< ;   1 : Standard Form                   *Class
    //<< ;   2 : List Generator
    //<< ;   3 : Grid Form                       *Class
    //<< ;   4 : Manual Input (with Button)
    //<< ;   5 : Manual Input (without Button)
    //<< ;   6 : Menu Input Type
    //<< ;   7 : Search Engine
    //<< ;   8 : Wizard
    //<< ;   9 : BitMap Search
    //<< ;  10 : Gantt Chart
    //<< ;  11 : Edit Table
    //<< ;  12 : Grid Edit Only                  ?Class?
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< ; FIXME : Should test type 12 too?
    //<< if (YFOART=1) || (YFOART=3) if YDATEI="" do ^WWWINFO($$^WWWTEXT(33)) quit  ; "No Class Defined"   FALSCHE FORGABE
    if ((mOp.Equal(YFOART.get(),1)) || (mOp.Equal(YFOART.get(),3))) {
      if (mOp.Equal(YDATEI.get(),"")) {
        m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",33));
        return;
      }
    }
    //<< 
    //<< set YFELD = ""
    mVar YFELD = m$.var("YFELD");
    YFELD.set("");
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;WENN LOESCHEN EINES DATENSATZES ;when deleting a record
    //<< set strStatus  = $$$OK
    mVar strStatus = m$.var("strStatus");
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set strOldYKEY = YKEY
    mVar strOldYKEY = m$.var("strOldYKEY");
    strOldYKEY.set(m$.var("YKEY").get());
    //<< 
    //<< if YDATEI'="" {
    if (mOp.NotEqual(YDATEI.get(),"")) {
      //<< set YMAXKEY = +$order(^WWW002(0,YDATEI,""),-1)
      YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
      //<< if YMAXKEY=0 set YMAXKEY = 1
      if (mOp.Equal(YMAXKEY.get(),0)) {
        YMAXKEY.set(1);
      }
      //<< 
      //<< if (YKILL=1) && (YKEY'="") {
      if ((mOp.Equal(m$.var("YKILL").get(),1)) && (mOp.NotEqual(m$.var("YKEY").get(),""))) {
        //<< set strStatus = $$^WWWKILL(YDATEI,YKEY)
        strStatus.set(m$.fnc$("WWWKILL.main",YDATEI.get(),m$.var("YKEY").get()));
        //<< if $get(YTIMEFORM)'=1 {
        if (mOp.NotEqual(m$.Fnc.$get(YTIMEFORM),1)) {
          //<< if YFOART'=3 {
          if (mOp.NotEqual(YFOART.get(),3)) {
            //<< set YKEY  = ""
            mVar YKEY = m$.var("YKEY");
            YKEY.set("");
            //<< set YFELD = ""
            YFELD.set("");
            //<< if YFKEY'="" {
            if (mOp.NotEqual(m$.var("YFKEY").get(),"")) {
              //<< set YKEY=YFKEY
              YKEY.set(m$.var("YFKEY").get());
            }
          }
          //<< }
          //<< } else {             ; Grid Form
          else {
            //<< new YXKEY               ; note: this works differently to NEW in original dot syntax - should be as subroutine to match
            mVar YXKEY = m$.var("YXKEY");
            m$.newVar(YXKEY);
            //<< set YXKEY = YKEY
            YXKEY.set(m$.var("YKEY").get());
            //<< set YKEY  = ""
            mVar YKEY = m$.var("YKEY");
            YKEY.set("");
            //<< set YFELD = ""
            YFELD.set("");
            //<< if YFKEY'="" set YKEY = YFKEY
            if (mOp.NotEqual(m$.var("YFKEY").get(),"")) {
              YKEY.set(m$.var("YFKEY").get());
            }
            //<< if $piece(YXKEY,",",YMAXKEY)'="" set YKEY = $piece(YXKEY,",",1,YMAXKEY-1)
            if (mOp.NotEqual(m$.Fnc.$piece(YXKEY.get(),",",YMAXKEY.get()),"")) {
              YKEY.set(m$.Fnc.$piece(YXKEY.get(),",",1,mOp.Subtract(YMAXKEY.get(),1)));
            }
          }
          //<< }
          //<< kill ^WWW126(0,YFORM,YBED)
          m$.var("^WWW126",0,m$.var("YFORM").get(),m$.var("YBED").get()).kill();
          //<< kill ^WWW126(0,YFORM,YUSER)
          m$.var("^WWW126",0,m$.var("YFORM").get(),m$.var("YUSER").get()).kill();
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< if (strStatus = $$$NO) {  //no error text
      if ((mOp.Equal(strStatus.get(),include.COMSYS.$$$NO(m$)))) {
        //<< set YKEY = strOldYKEY
        mVar YKEY = m$.var("YKEY");
        YKEY.set(strOldYKEY.get());
      }
      //<< } else {
      else {
        //<< $$$Error(strStatus)
        include.COMSYS.$$$Error(m$,strStatus);
        //<< quit                                 ; *** EARLY EXIT ***
        return;
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; New Form On Deletion -> Quit
    //<< if ($get(YFORM)'="") && (YKILL=1) {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.Equal(m$.var("YKILL").get(),1))) {
      //<< set objWWW120 = $get(^WWW120(0,YFORM,1))
      mVar objWWW120 = m$.var("objWWW120");
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
      //<< set idNewForm = $$$WWW120NewFormOnDeletion(objWWW120)
      mVar idNewForm = m$.var("idNewForm");
      idNewForm.set(include.WWWConst.$$$WWW120NewFormOnDeletion(m$,objWWW120));
      //<< if (idNewForm'="") {
      if ((mOp.NotEqual(idNewForm.get(),""))) {
        //<< if $$$WWW120NewFormKey(objWWW120)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW120NewFormKey(m$,objWWW120),"")) {
          //<< set strNewKey = $$CalculateString^WWWFORMD($$$WWW120NewFormKey(objWWW120),YFORM)
          mVar strNewKey = m$.var("strNewKey");
          strNewKey.set(m$.fnc$("WWWFORMD.CalculateString",include.WWWConst.$$$WWW120NewFormKey(m$,objWWW120),m$.var("YFORM").get()));
        }
        //<< } else {
        else {
          //<< set strNewKey = ""
          mVar strNewKey = m$.var("strNewKey");
          strNewKey.set("");
        }
        //<< }
        //<< set NOKILL = $$$YES
        NOKILL.set(include.COMSYS.$$$YES(m$));
        //<< set YFORM  = ""
        mVar YFORM = m$.var("YFORM");
        YFORM.set("");
        //<< do GoToForm^COMUtilForm(idNewForm,strNewKey)
        m$.Cmd.Do("COMUtilForm.GoToForm",idNewForm.get(),m$.var("strNewKey").get());
        //<< quit                                 ; *** EARLY EXIT ***
        return;
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;WENN NEUE RICHTUNG (NEXT,LAST, FIRST,...)
    //<< if (YKILL'=1) && (YRICHT'="") {
    if ((mOp.NotEqual(m$.var("YKILL").get(),1)) && (mOp.NotEqual(m$.var("YRICHT").get(),""))) {
      //<< set $$$WWWUSERLastFormfield(^WWWUSER(0,YUSER,1))=""
      include.WWWConst.$$$WWWUSERLastFormfieldSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
      //<< do ^WWWFORMS  ;NEXT DATENSATZ ;data record
      m$.Cmd.Do("WWWFORMS.main");
    }
    //<< }
    //<< 
    //<< 
    //<< $$$LOGWWWBENCH(2)
    $$$LOGWWWBENCH(m$,2);
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;ALTE LOCK DATEIEN AUFHEBEN  WENN KEINE UNTERFORM ;repeal when no
    //<< ;
    //<< ;  Form WWWPARA : Parameter Selection - calls Routine ^WWWPARA and from there
    //<< ;  can access form COMViewSearch and subroutine AfterDataFields^COMViewFilter.
    //<< ;------------------------------------------------------------------------
    //<< 
    //<< if ($extract(YFORM,1,7)'="WWWPARA") && (YFKEY="") set YA = "" for  set YA = $order(^WWW006(0,YA)) quit:YA=""  do
    if ((mOp.NotEqual(m$.Fnc.$extract(m$.var("YFORM").get(),1,7),"WWWPARA")) && (mOp.Equal(m$.var("YFKEY").get(),""))) {
      mVar YA = m$.var("YA");
      YA.set("");
      for (;true;) {
        YA.set(m$.Fnc.$order(m$.var("^WWW006",0,YA.get())));
        if (mOp.Equal(YA.get(),"")) {
          break;
        }
        do {
          //<< . if +YA'=dteToday kill ^WWW006(0,YA) kill ^WWW0061(0,YA) quit  ;LÖSCHEN ALTE LOCKFILE;FIS;19.04.04;LÖSCHEN LOCK RÜCKHOLINFO
          if (mOp.NotEqual(mOp.Positive(YA.get()),dteToday.get())) {
            m$.var("^WWW006",0,YA.get()).kill();
            m$.var("^WWW0061",0,YA.get()).kill();
            break;
          }
          //<< . new YA1  ;LOSCHEN ALLE EINTRÄGE WENN LEERES FELD ;when field
          mVar YA1 = m$.var("YA1");
          m$.newVar(YA1);
          //<< . if $get(YDATEI)'="" do
          if (mOp.NotEqual(m$.Fnc.$get(YDATEI),"")) {
          }
          //<< . if $get(YDATEI)'="" || ($get(YLOCKKILL)=1) do  ;SR15824 ;force lock kill
          if (mOp.NotEqual(m$.Fnc.$get(YDATEI),"") || (mOp.Equal(m$.Fnc.$get(m$.var("YLOCKKILL")),1))) {
            //<< . . set YA1 = ""
            YA1.set("");
            //<< . . for  set YA1 = $order(^WWW006(0,dteToday,YA1)) quit:YA1=""  set YA(1) = $get(^WWW006(0,dteToday,YA1,1)) do
            for (;true;) {
              YA1.set(m$.Fnc.$order(m$.var("^WWW006",0,dteToday.get(),YA1.get())));
              if (mOp.Equal(YA1.get(),"")) {
                break;
              }
              YA.var(1).set(m$.Fnc.$get(m$.var("^WWW006",0,dteToday.get(),YA1.get(),1)));
              //<< . . . if $piece(YA(1),Y,1)=YUSER do
              if (mOp.Equal(m$.Fnc.$piece(YA.var(1).get(),m$.var("Y").get(),1),m$.var("YUSER").get())) {
                //<< . . . . if $piece($get(^WWWUSER(0,YUSER,1)),Y,25)'="" set ^WWW0061(0,dteToday,YA1,$piece($get(^WWWUSER(0,YUSER,1)),Y,25),1) = $get(^WWW006(0,dteToday,YA1,1))
                if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),m$.var("Y").get(),25),"")) {
                  m$.var("^WWW0061",0,dteToday.get(),YA1.get(),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),m$.var("Y").get(),25),1).set(m$.Fnc.$get(m$.var("^WWW006",0,dteToday.get(),YA1.get(),1)));
                }
                //<< . . . . kill ^WWW006(0,dteToday,YA1)
                m$.var("^WWW006",0,dteToday.get(),YA1.get()).kill();
              }
            }
          }
        } while (false);
      }
    }
    //<< 
    //<< if $piece($get(^WWWUSER(0,YUSER,1)),Y,25)'="" do  ;RÜCKHOLEN LETZTER LOCK;FIS;19.04.04;25534
    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),m$.var("Y").get(),25),"")) {
      //<< . new YTRAKTOLD,YA1,YA
      mVar YTRAKTOLD = m$.var("YTRAKTOLD");
      mVar YA1 = m$.var("YA1");
      mVar YA = m$.var("YA");
      m$.newVar(YTRAKTOLD,YA1,YA);
      //<< . set YTRAKTOLD = $piece($get(^WWWUSER(0,YUSER,1)),Y,25)
      YTRAKTOLD.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),m$.var("Y").get(),25));
      //<< . ;SPEICHERN LOCK FALLS NICHT OBEN PASSIERT (WENN YFKEY'="")
      //<< . set YA1 = ""
      YA1.set("");
      //<< . for  set YA1 = $order(^WWW006(0,dteToday,YA1)) quit:YA1=""  set YA(1) = $get(^WWW006(0,dteToday,YA1,1)) do
      for (;true;) {
        YA1.set(m$.Fnc.$order(m$.var("^WWW006",0,dteToday.get(),YA1.get())));
        if (mOp.Equal(YA1.get(),"")) {
          break;
        }
        YA.var(1).set(m$.Fnc.$get(m$.var("^WWW006",0,dteToday.get(),YA1.get(),1)));
        //<< . . if $piece(YA(1),Y,1)=YUSER set ^WWW0061(0,dteToday,YA1,YTRAKTOLD,1) = $get(^WWW006(0,dteToday,YA1,1))
        if (mOp.Equal(m$.Fnc.$piece(YA.var(1).get(),m$.var("Y").get(),1),m$.var("YUSER").get())) {
          m$.var("^WWW0061",0,dteToday.get(),YA1.get(),YTRAKTOLD.get(),1).set(m$.Fnc.$get(m$.var("^WWW006",0,dteToday.get(),YA1.get(),1)));
        }
      }
      //<< . ;
      //<< . set YA1 = ""
      YA1.set("");
      //<< . for  set YA1 = $order(^WWW0061(0,dteToday,YA1)) quit:YA1=""  do
      for (;true;) {
        YA1.set(m$.Fnc.$order(m$.var("^WWW0061",0,dteToday.get(),YA1.get())));
        if (mOp.Equal(YA1.get(),"")) {
          break;
        }
        //<< . . if $data(^WWW0061(0,dteToday,YA1,YTRAKTOLD)) do
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0061",0,dteToday.get(),YA1.get(),YTRAKTOLD.get())))) {
          do {
            //<< . . . set YA(1) = $get(^WWW0061(0,dteToday,YA1,YTRAKTOLD,1))
            YA.var(1).set(m$.Fnc.$get(m$.var("^WWW0061",0,dteToday.get(),YA1.get(),YTRAKTOLD.get(),1)));
            //<< . . . if $piece(YA(1),Y,1)=YUSER if ($piece(YA(1),Y,2)+300)>$piece($horolog,",",2) do  quit  ;PRÜFEN OB NOCH GÜLTIG (MAX. 5 MINUTEN) ;sift whether yet valuable
            if (mOp.Equal(m$.Fnc.$piece(YA.var(1).get(),m$.var("Y").get(),1),m$.var("YUSER").get())) {
              if (mOp.Greater((mOp.Add(m$.Fnc.$piece(YA.var(1).get(),m$.var("Y").get(),2),300)),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2))) {
                //<< . . . . if '$data(^WWW006(0,dteToday,YA1)) set ^WWW006(0,dteToday,YA1,1) = $get(^WWW0061(0,dteToday,YA1,YTRAKTOLD,1))  ;LOCK ZURÜCKSETZTEN
                if (mOp.Not(m$.Fnc.$data(m$.var("^WWW006",0,dteToday.get(),YA1.get())))) {
                  m$.var("^WWW006",0,dteToday.get(),YA1.get(),1).set(m$.Fnc.$get(m$.var("^WWW0061",0,dteToday.get(),YA1.get(),YTRAKTOLD.get(),1)));
                }
                break;
              }
            }
            //<< . . . ;
            //<< . . . kill ^WWW0061(0,dteToday)  ;LÖSCHEN WENN UNGÜLTIG ;Delete when
            m$.var("^WWW0061",0,dteToday.get()).kill();
            //<< . . . set $piece(^WWWUSER(0,YUSER,1),Y,25) = ""
            m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),25).set("");
          } while (false);
        }
      }
    }
    //<< 
    //<< $$$LOGWWWBENCH(3)
    $$$LOGWWWBENCH(m$,3);
    //<< 
    //<< ;------------------------------------------------------------------------   SETS YBEARB -------
    //<< set YBEARB=1  ;BEARBEITUNGSTATUS NEUER DATENSATZ ;data record
    mVar YBEARB = m$.var("YBEARB");
    YBEARB.set(1);
    //<< if YTRAKT0=1 set YBEARB=7   ;UNERLAUBTER RUECKSPRUNG
    if (mOp.Equal(m$.var("YTRAKT0").get(),1)) {
      YBEARB.set(7);
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;   Manage Keys
    //<< ;---------------------------------------
    //<< 
    //<< ;------------------------------------------------------------------------   *** EXECUTE 3 ***
    //<< ;DATENSATZ LESEN/PRUEFEN U. LOESCHEN WENN FEHLERERFASSUNG ;data record when
    //<< if YOPEN'="OLD" if $$$WWW121DefaultVariableInput($get(^WWW121(0,YFORM,1,1)))'="" do   ;VORGABE DES KEY ;default KEY
    if (mOp.NotEqual(m$.var("YOPEN").get(),"OLD")) {
      if (mOp.NotEqual(include.WWWConst.$$$WWW121DefaultVariableInput(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),1,1))),"")) {
        //<< . if '$data(^WWW121(0,YFORM,2,1)) do
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YFORM").get(),2,1)))) {
          do {
            //<< . . quit:+$$$WWW121FixedInputForHiddenField($get(^WWW121(0,YFORM,1,1)))'=0
            if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),1,1)))),0)) {
              break;
            }
            //<< . . set YKEY = $$$WWW121DefaultVariableInput($get(^WWW121(0,YFORM,1,1)))
            mVar YKEY = m$.var("YKEY");
            YKEY.set(include.WWWConst.$$$WWW121DefaultVariableInput(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),1,1))));
            //<< . . if $extract(YKEY)="@" if $extract(YKEY,2)'="$" set YKEY = $get(@($extract($$$WWW121DefaultVariableInput($get(^WWW121(0,YFORM,1,1))),2,99)))
            if (mOp.Equal(m$.Fnc.$extract(YKEY.get()),"@")) {
              if (mOp.NotEqual(m$.Fnc.$extract(YKEY.get(),2),"$")) {
                YKEY.set(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$extract(include.WWWConst.$$$WWW121DefaultVariableInput(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),1,1))),2,99)))));
              }
            }
            //<< . . if $extract(YKEY)="@" if $extract(YKEY,2)="$"  xecute "SET YKEY="_$extract(YKEY,2,99)
            if (mOp.Equal(m$.Fnc.$extract(YKEY.get()),"@")) {
              if (mOp.Equal(m$.Fnc.$extract(YKEY.get(),2),"$")) {
                m$.Cmd.Xecute(mOp.Concat("SET YKEY=",m$.Fnc.$extract(YKEY.get(),2,99)));
              }
            }
          } while (false);
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;WER AUS SORTKEYSUCHE MANUELLES DATENFELD; SUCHE IN DATENFELD, SAVE UND NEUE ANZEIGE
    //<< if $data(^WWWSOR("SORTKEY",dteToday,YUSER,YFORM,1)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWSOR","SORTKEY",dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),1)))) {
      //<< set YKEY = ^WWWSOR("SORTKEY",dteToday,YUSER,YFORM,1)
      mVar YKEY = m$.var("YKEY");
      YKEY.set(m$.var("^WWWSOR","SORTKEY",dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),1).get());
      //<< kill ^WWWSOR("SORTKEY",dteToday,YUSER,YFORM,1)            ;VORGABE AUS WWWEVENT ;default out of
      m$.var("^WWWSOR","SORTKEY",dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),1).kill();
    }
    //<< }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;WERTE VON VORHERIGER  - Previous Values
    //<< if YMAXKEY'=0 if YDATEI'="" if YRICHT="" if $get(YRETURN)=1 if $data(^WWW126(0,YFORM,YUSER)) do
    if (mOp.NotEqual(YMAXKEY.get(),0)) {
      if (mOp.NotEqual(YDATEI.get(),"")) {
        if (mOp.Equal(m$.var("YRICHT").get(),"")) {
          if (mOp.Equal(m$.Fnc.$get(m$.var("YRETURN")),1)) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW126",0,m$.var("YFORM").get(),m$.var("YUSER").get())))) {
              //<< . new YI
              m$.newVar(YI);
              //<< . for YI=1:1:YMAXKEY if $get(^WWW126(0,YFORM,YUSER,YI,1))'="" set $piece(YKEY,",",YI) = ^WWW126(0,YFORM,YUSER,YI,1)
              for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
                if (mOp.NotEqual(m$.Fnc.$get(m$.var("^WWW126",0,m$.var("YFORM").get(),m$.var("YUSER").get(),YI.get(),1)),"")) {
                  m$.pieceVar(m$.var("YKEY"),",",YI.get()).set(m$.var("^WWW126",0,m$.var("YFORM").get(),m$.var("YUSER").get(),YI.get(),1).get());
                }
              }
            }
          }
        }
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;   Record Storage (WWWDATEN)
    //<< ;---------------------------------------
    //<< 
    //<< ;---------------------------------------
    //<< ; FIXME : <GRF> Should the second $h test be (YI+1)'=+$h or YI'=($h-1) instead?
    //<< ;         If a record is created shortly before midnight on 60001 then it will be
    //<< ;         ^WWWDATEN(0,60001).  Comparing against $h will check firstly when
    //<< ;         60001'=60001 before midnight and 60001'=60002 after midnight.
    //<< ;         In the latter case we might also wish to check it hasn't got yesterday's
    //<< ;         date i.e. 60001'=(60002-1), instead we are looking at 60000'=60002.
    //<< ;         This is a general clean up.
    //<< ;---------------------------------------
    //<< 
    //<< set YI = $order(^WWWDATEN(0,"")) if (YI'="") && (YI'=dteToday) && (YI-1'=dteToday) kill ^WWWDATEN(0,YI)
    YI.set(m$.Fnc.$order(m$.var("^WWWDATEN",0,"")));
    if ((mOp.NotEqual(YI.get(),"")) && (mOp.NotEqual(YI.get(),dteToday.get())) && (mOp.NotEqual(mOp.Subtract(YI.get(),1),dteToday.get()))) {
      m$.var("^WWWDATEN",0,YI.get()).kill();
    }
    //<< 
    //<< ; Save all data if only changing tabs
    //<< if YOPEN'=2 {
    if (mOp.NotEqual(m$.var("YOPEN").get(),2)) {
      //<< new objMSave
      mVar objMSave = m$.var("objMSave");
      m$.newVar(objMSave);
      //<< set objMSave = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"M",2))
      objMSave.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"M",2)));
      //<< kill ^WWWDATEN(0,dteToday,YUSER,YFORM)
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get()).kill();
      //<< kill ^WWWDATEN(0,dteToday,YUSER,"RECORDEXIST")  ;TYBD;5,8,2004
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),"RECORDEXIST").kill();
      //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"M",2) = objMSave
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"M",2).set(objMSave.get());
      //<< kill ^WWWSOR(YUSER,dteToday,"M","SAVE",2)
      m$.var("^WWWSOR",m$.var("YUSER").get(),dteToday.get(),"M","SAVE",2).kill();
      //<< set ^WWWDATEN(0,dteToday,YUSER,"RECORDEXISTS",YFORM,1)=0   //SR13195
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),"RECORDEXISTS",m$.var("YFORM").get(),1).set(0);
    }
    //<< } else {
    else {
      //<< kill ^WWWDATEN(0,dteToday,YUSER,YFORM,"LOCK")
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"LOCK").kill();
    }
    //<< }
    //<< 
    //<< if YTIMEFORM=1 set ^WWWDATEN(0,dteToday,YUSER,YFORM,"V","YTIMEFORM",1) = YTIMEFORM  ;DATEN ZUR PRUEFUNG;TYBD;3,11,2003;
    if (mOp.Equal(YTIMEFORM.get(),1)) {
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","YTIMEFORM",1).set(YTIMEFORM.get());
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   YFELD       objWWWUSE       form backward step class
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< if (YDATEI'="") && (YKEY'="") && (+YMAXKEY'=0) do   ;WENN DATEN VORHANDEN ABER KEINE OLD WERTE VORHANDEN;WAC;NUR WENN NEU NICHT WENN OPEN=OLD;28.11.2001
    if ((mOp.NotEqual(YDATEI.get(),"")) && (mOp.NotEqual(m$.var("YKEY").get(),"")) && (mOp.NotEqual(mOp.Positive(YMAXKEY.get()),0))) {
      do {
        //<< . if $get(YTIMEFORM)'=1            set YKEY = $piece(YKEY,",",1,YMAXKEY)
        if (mOp.NotEqual(m$.Fnc.$get(YTIMEFORM),1)) {
          mVar YKEY = m$.var("YKEY");
          YKEY.set(m$.Fnc.$piece(m$.var("YKEY").get(),",",1,YMAXKEY.get()));
        }
        //<< . if $get(YTIMEFORM)=1 if YKILL=1  set YKEY = $piece(YKEY,",",1,YMAXKEY)  ;LÖSCHEN ZEITABHÄNGIGES FORMULAR;26751;FIS;15.02.05
        if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),1)) {
          if (mOp.Equal(m$.var("YKILL").get(),1)) {
            mVar YKEY = m$.var("YKEY");
            YKEY.set(m$.Fnc.$piece(m$.var("YKEY").get(),",",1,YMAXKEY.get()));
          }
        }
        //<< . if $get(YTIMEFORM)=1 if YKILL'=1 set YKEY = $piece(YKEY,",",1,YMAXKEY+1)
        if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),1)) {
          if (mOp.NotEqual(m$.var("YKILL").get(),1)) {
            mVar YKEY = m$.var("YKEY");
            YKEY.set(m$.Fnc.$piece(m$.var("YKEY").get(),",",1,mOp.Add(YMAXKEY.get(),1)));
          }
        }
        //<< . do ^WWWLESE(YDATEI,YKEY,1)   ;MIT TEST;TYBD;30.04.2003 ;by means of Test
        m$.Cmd.Do("WWWLESE.main",YDATEI.get(),m$.var("YKEY").get(),1);
        //<< . if $data(^WWWUSETMP(0,YUSER,YFORM)) do  ;DATEN AUS TEMP FILE ANSTELLE ORIGINAL DATEN;FIS;03.03.05;TEL.HERR WACH
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWUSETMP",0,m$.var("YUSER").get(),m$.var("YFORM").get())))) {
          //<< . . new YTEMP,YI
          mVar YTEMP = m$.var("YTEMP");
          m$.newVar(YTEMP,YI);
          //<< . . set YTEMP = "^WWWUSETMP(0,"""_YUSER_""","""_YFORM_""""
          YTEMP.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWWUSETMP(0,\"",m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\""));
          //<< . . for YI=1:1  quit:$piece(YKEY,",",YI,99)=""  set YTEMP = YTEMP_","""_$translate($piece(YKEY,",",YI),"""")_""""
          for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get(),99),"")) {
              break;
            }
            YTEMP.set(mOp.Concat(mOp.Concat(mOp.Concat(YTEMP.get(),",\""),m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"\"")),"\""));
          }
          //<< . . set YTEMP = YTEMP_")"
          YTEMP.set(mOp.Concat(YTEMP.get(),")"));
          //<< . . if $data(@YTEMP) set YFELD = @YTEMP,YYFELD = YFELD kill @YTEMP
          if (mOp.Logical(m$.Fnc.$data(m$.indirectVar(YTEMP.get())))) {
            YFELD.set(m$.indirectVar(YTEMP.get()).get());
            mVar YYFELD = m$.var("YYFELD");
            YYFELD.set(YFELD.get());
            m$.indirectVar(YTEMP.get()).kill();
          }
        }
        //<< . ;
        //<< . if (YKILL=2) || (YKILL=3) if YFELD="" do  quit
        if ((mOp.Equal(m$.var("YKILL").get(),2)) || (mOp.Equal(m$.var("YKILL").get(),3))) {
          if (mOp.Equal(YFELD.get(),"")) {
            //<< . . set YFELD = $get(^WWWUSE(0,YUSER,YFORM,"D",1))
            YFELD.set(m$.Fnc.$get(m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1)));
            //<< . . set YYFELD = YFELD,YYKEY = YKEY
            mVar YYFELD = m$.var("YYFELD");
            YYFELD.set(YFELD.get());
            mVar YYKEY = m$.var("YYKEY");
            YYKEY.set(m$.var("YKEY").get());
            //<< . . set YOPEN  = "OLD"
            mVar YOPEN = m$.var("YOPEN");
            YOPEN.set("OLD");
            //<< . . set YBEARB = 5
            YBEARB.set(5);
            break;
          }
        }
        //<< . ;
        //<< . if YFELD="" set YBEARB = 1 quit   ;WENN KEIN DATENSATZ VORHANDEN;DIETMAR WACH ;when no data record on hand open-eyed
        if (mOp.Equal(YFELD.get(),"")) {
          YBEARB.set(1);
          break;
        }
        //<< . ;
        //<< . set FFFELD = $get(YFELD),FFKEY = $get(YKEY),FMFELD = "",FFFORM = YFORM   ;TYBD;05.12.2001;16.05.2002
        mVar FFFELD = m$.var("FFFELD");
        FFFELD.set(m$.Fnc.$get(YFELD));
        mVar FFKEY = m$.var("FFKEY");
        FFKEY.set(m$.Fnc.$get(m$.var("YKEY")));
        mVar FMFELD = m$.var("FMFELD");
        FMFELD.set("");
        mVar FFFORM = m$.var("FFFORM");
        FFFORM.set(m$.var("YFORM").get());
        //<< . set YSAVEDDATA = 1  ;FLAGG = DATENDATZ GESPEICHERT
        mVar YSAVEDDATA = m$.var("YSAVEDDATA");
        YSAVEDDATA.set(1);
        //<< . if YKILL'=1 do  ;WEIL DATEN NUR HALB ERFASST ;since only semi-
        if (mOp.NotEqual(m$.var("YKILL").get(),1)) {
          //<< . . if YKILL=2 do ^WWWKILL(YDATEI,YKEY)
          if (mOp.Equal(m$.var("YKILL").get(),2)) {
            m$.Cmd.Do("WWWKILL.main",YDATEI.get(),m$.var("YKEY").get());
          }
          //<< . . set YYKEY = YKEY,YYFELD=YFELD
          mVar YYKEY = m$.var("YYKEY");
          YYKEY.set(m$.var("YKEY").get());
          mVar YYFELD = m$.var("YYFELD");
          YYFELD.set(YFELD.get());
          //<< . . if YKILL=2 set YBEARB = 5  ;FALSCHE ERFASSUNG ;logging
          if (mOp.Equal(m$.var("YKILL").get(),2)) {
            YBEARB.set(5);
          }
        }
      } while (false);
    }
    //<< 
    //<< kill ^WWWUSETMP(0,YUSER)  ;TEMP FILE LÖSCHEN;FIS;25.06.04;25998
    m$.var("^WWWUSETMP",0,m$.var("YUSER").get()).kill();
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;;SEITENWECHSEL
    //<< if $data(^WWWDUMMY(YUSER,"D")) || $data(^WWWDUMMY(YUSER,"M")) do
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDUMMY",m$.var("YUSER").get(),"D"))) || mOp.Logical(m$.Fnc.$data(m$.var("^WWWDUMMY",m$.var("YUSER").get(),"M")))) {
      //<< . new YI,oldStatus
      mVar oldStatus = m$.var("oldStatus");
      m$.newVar(YI,oldStatus);
      //<< . set YBEARB = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"STATUS",1),YBEARB)
      YBEARB.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"STATUS",1),YBEARB.get()));
      //<< . ;
      //<< . set YFELD  = $get(^WWWDUMMY(YUSER,"D"))  ;ZWISCHENDATEI BEI SEITEWECHSEL OHNE SCHLÜSSEL ;BUFFER FILE WITH PAGE CHANGE WITHOUT KEYS
      YFELD.set(m$.Fnc.$get(m$.var("^WWWDUMMY",m$.var("YUSER").get(),"D")));
      //<< . set YMFELD = $get(^WWWDUMMY(YUSER,"M"))
      mVar YMFELD = m$.var("YMFELD");
      YMFELD.set(m$.Fnc.$get(m$.var("^WWWDUMMY",m$.var("YUSER").get(),"M")));
      //<< . set YI     = $get(^WWWDUMMY(YUSER,"P"))
      YI.set(m$.Fnc.$get(m$.var("^WWWDUMMY",m$.var("YUSER").get(),"P")));
      //<< . set YKEY   = ""
      mVar YKEY = m$.var("YKEY");
      YKEY.set("");
      //<< . for YI(1)=1:1 quit:$piece(YI,",",YI(1))=""  set:YKEY'="" YKEY = YKEY_"," set YKEY = $get(YKEY)_$piece(YI,",",YI(1))
      for (m$.var("YI",1).set(1);(true);m$.var("YI",1).set(mOp.Add(m$.var("YI",1).get(),1))) {
        if (mOp.Equal(m$.Fnc.$piece(YI.get(),",",YI.var(1).get()),"")) {
          break;
        }
        if (mOp.NotEqual(YKEY.get(),"")) {
          YKEY.set(mOp.Concat(YKEY.get(),","));
        }
        YKEY.set(mOp.Concat(m$.Fnc.$get(YKEY),m$.Fnc.$piece(YI.get(),",",YI.var(1).get())));
      }
      //<< . new SCHLUESSEL,MAXYKEY,Q
      mVar SCHLUESSEL = m$.var("SCHLUESSEL");
      mVar MAXYKEY = m$.var("MAXYKEY");
      mVar Q = m$.var("Q");
      m$.newVar(SCHLUESSEL,MAXYKEY,Q);
      //<< . set SCHLUESSEL = ""
      SCHLUESSEL.set("");
      //<< . if YDATEI'="" do
      if (mOp.NotEqual(YDATEI.get(),"")) {
        //<< . . set MAXYKEY = +$order(^WWW002(0,YDATEI,""),-1)
        MAXYKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
        //<< . . if MAXYKEY'=0 do
        if (mOp.NotEqual(MAXYKEY.get(),0)) {
          //<< . . . set Q = 0
          Q.set(0);
          //<< . . . if +$get(YTIMEFORM)'=1 set YKEY = $piece(YKEY,",",1,YMAXKEY)   set SCHLUESSEL = "^"_YDATEI_"("_$$^WWWYM(YDATEI,1)   ;tybd 01.11.01
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(YTIMEFORM)),1)) {
            YKEY.set(m$.Fnc.$piece(YKEY.get(),",",1,YMAXKEY.get()));
            SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get(),1)));
          }
          //<< . . . if +$get(YTIMEFORM)=1  set YKEY = $piece(YKEY,",",1,YMAXKEY+1) set SCHLUESSEL = "^"_YDATEI_"t("_$$^WWWYM(YDATEI,1)  ;tybd 01.11.01
          if (mOp.Equal(mOp.Positive(m$.Fnc.$get(YTIMEFORM)),1)) {
            YKEY.set(m$.Fnc.$piece(YKEY.get(),",",1,mOp.Add(YMAXKEY.get(),1)));
            SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"t("),m$.fnc$("WWWYM.main",YDATEI.get(),1)));
          }
          //<< . . . ;
          //<< . . . set YDATA = $get(^WWW001(0,YDATEI,1))
          mVar YDATA = m$.var("YDATA");
          YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)));
          //<< . . . if $piece(YDATA,Y,12)'="" if $piece(YDATA,Y,13)'="" do  ;UCI UND VOL ;UCI And
          if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
              do {
                //<< . . . . quit:$find(SCHLUESSEL,"^[")
                if (mOp.Logical(m$.Fnc.$find(SCHLUESSEL.get(),"^["))) {
                  break;
                }
                //<< . . . . set SCHLUESSEL = "^["""_$piece(YDATA,Y,12)_""","""_$piece(YDATA,Y,13)_"""]"_$piece(SCHLUESSEL,"^",2,999)
                SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[\"",m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\",\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\"]"),m$.Fnc.$piece(SCHLUESSEL.get(),"^",2,999)));
              } while (false);
            }
          }
          //<< . . . ;
          //<< . . . for I=1:1:MAXYKEY set XYKEY=$translate($piece(YKEY,",",I),"""") set SCHLUESSEL = SCHLUESSEL_""""_XYKEY_"""," if (XYKEY="") || (XYKEY="+") set Q = 1 quit
          mVar I = m$.var("I");
          for (I.set(1);(mOp.LessOrEqual(I.get(),MAXYKEY.get()));I.set(mOp.Add(I.get(),1))) {
            mVar XYKEY = m$.var("XYKEY");
            XYKEY.set(m$.Fnc.$translate(m$.Fnc.$piece(YKEY.get(),",",I.get()),"\""));
            SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat(SCHLUESSEL.get(),"\""),XYKEY.get()),"\","));
            if ((mOp.Equal(XYKEY.get(),"")) || (mOp.Equal(XYKEY.get(),"+"))) {
              Q.set(1);
              break;
            }
          }
          //<< . . . if $piece(YDATA,Y,8)'=4 set SCHLUESSEL=SCHLUESSEL_"1"
          if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
            SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),"1"));
          }
          //<< . . . if $piece(YDATA,Y,8)=4 if $extract(SCHLUESSEL,$length(SCHLUESSEL))="," set SCHLUESSEL=$extract(SCHLUESSEL,1,$length(SCHLUESSEL)-1)
          if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
            if (mOp.Equal(m$.Fnc.$extract(SCHLUESSEL.get(),m$.Fnc.$length(SCHLUESSEL.get())),",")) {
              SCHLUESSEL.set(m$.Fnc.$extract(SCHLUESSEL.get(),1,mOp.Subtract(m$.Fnc.$length(SCHLUESSEL.get()),1)));
            }
          }
          //<< . . . set SCHLUESSEL=SCHLUESSEL_")"
          SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),")"));
          //<< . . . if Q=0 if $data(@(SCHLUESSEL)) set YSAVEDDATA=1
          if (mOp.Equal(Q.get(),0)) {
            if (mOp.Logical(m$.Fnc.$data(m$.indirectVar((SCHLUESSEL.get()))))) {
              mVar YSAVEDDATA = m$.var("YSAVEDDATA");
              YSAVEDDATA.set(1);
            }
          }
          //<< . . . if Q=0 do
          if (mOp.Equal(Q.get(),0)) {
            //<< . . . . new strKEY
            mVar strKEY = m$.var("strKEY");
            m$.newVar(strKEY);
            //<< . . . . set YLOCK=+$piece($get(^WWW001(0,YDATEI,1)),Y,6)
            mVar YLOCK = m$.var("YLOCK");
            YLOCK.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)),m$.var("Y").get(),6)));
            //<< . . . . set strKEY = $translate(SCHLUESSEL,",()""",".//")
            strKEY.set(m$.Fnc.$translate(SCHLUESSEL.get(),",()\"",".//"));
            //<< . . . . if YLOCK'=0 if $data(^WWW006(0,dteToday,strKEY,1)) do
            if (mOp.NotEqual(YLOCK.get(),0)) {
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW006",0,dteToday.get(),strKEY.get(),1)))) {
                //<< . . . . . set YA(1)=^WWW006(0,dteToday,strKEY,1)
                mVar YA = m$.var("YA");
                YA.var(1).set(m$.var("^WWW006",0,dteToday.get(),strKEY.get(),1).get());
                //<< . . . . . if YUSER'=$piece(YA(1),Y,1) if ($piece(YA(1),Y,2)+YLOCK)>$piece($horolog,",",2) set Q=1 set YBEARB=4  ;IN USE  ;W $$^WWWTEXT(256)  ;UNERLAUBE AENDER
                if (mOp.NotEqual(m$.var("YUSER").get(),m$.Fnc.$piece(YA.var(1).get(),m$.var("Y").get(),1))) {
                  if (mOp.Greater((mOp.Add(m$.Fnc.$piece(YA.var(1).get(),m$.var("Y").get(),2),YLOCK.get())),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2))) {
                    Q.set(1);
                    YBEARB.set(4);
                  }
                }
              }
            }
            //<< . . . . ;
            //<< . . . . if Q=0 set ^WWW006(0,dteToday,strKEY,1)=YUSER_Y_$piece($horolog,",",2)
            if (mOp.Equal(Q.get(),0)) {
              m$.var("^WWW006",0,dteToday.get(),strKEY.get(),1).set(mOp.Concat(mOp.Concat(m$.var("YUSER").get(),m$.var("Y").get()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2)));
            }
            //<< . . . . if YBEARB'=4 set ^WWWDATEN(0,dteToday,YUSER,YFORM,"LOCK",1)="^WWW006(0,"_dteToday_","""_strKEY_""",1)"  ; (YBEARB could be 4 from previous page -> stay readonly, don't lock)
            if (mOp.NotEqual(YBEARB.get(),4)) {
              m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"LOCK",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW006(0,",dteToday.get()),",\""),strKEY.get()),"\",1)"));
            }
          }
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;NEU ;recent
    //<< if $get(YKEY)="" kill ^WWWPAGE(0,YUSER)
    if (mOp.Equal(m$.Fnc.$get(m$.var("YKEY")),"")) {
      m$.var("^WWWPAGE",0,m$.var("YUSER").get()).kill();
    }
    //<< if +YSEITE=0 if YFELD'="" if $data(^WWWPAGE(0,YUSER,YFORM,1)) do     ;WERTE AUS VORHERIGEN DATEN ;out of
    if (mOp.Equal(mOp.Positive(m$.var("YSEITE").get()),0)) {
      if (mOp.NotEqual(YFELD.get(),"")) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWPAGE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),1)))) {
          //<< . set YSEITE   = $piece($get(^WWWPAGE(0,YUSER,YFORM,1)),Y,1)         ;SEITE ;tab
          mVar YSEITE = m$.var("YSEITE");
          YSEITE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWPAGE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),1)),m$.var("Y").get(),1));
          //<< . set YINSEITE = $piece($get(^WWWPAGE(0,YUSER,YFORM,1)),Y,2)         ;UNTERSEITE
          mVar YINSEITE = m$.var("YINSEITE");
          YINSEITE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWPAGE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),1)),m$.var("Y").get(),2));
        }
      }
    }
    //<< 
    //<< if +YSEITE=0 set YSEITE=1    ;MINDESTENS DIE SEITE 1 ;who side
    if (mOp.Equal(mOp.Positive(m$.var("YSEITE").get()),0)) {
      mVar YSEITE = m$.var("YSEITE");
      YSEITE.set(1);
    }
    //<< if $data(^WWW122(0,YFORM)) if '$data(^WWW122s(0,1,YSEITE,YFORM)) if '$data(^WWW1203(0,YFORM,SPRACHE,YSEITE)) set YSEITE=1   ;WENN SEITE AUS VORDATEI GRÖßER DANN ERSTE SEITE  ;ODER WWW1203(0,YFORM,... TYBD; 16,12,2003
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122s",0,1,m$.var("YSEITE").get(),m$.var("YFORM").get())))) {
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),m$.var("YSEITE").get())))) {
          mVar YSEITE = m$.var("YSEITE");
          YSEITE.set(1);
        }
      }
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   YDATA       objWWW001       Data Dictionary
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;------------------------------------------------------------------------
    //<< ;NUR LESEBERECHTIGUNG ;only
    //<< if $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly set YBEARB=8
    if (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$))) {
      YBEARB.set(8);
    }
    //<< set YKILL=""
    mVar YKILL = m$.var("YKILL");
    YKILL.set("");
    //<< if YOPEN="OLD" set YKEY=YYKEY,YFELD=YYFELD do  ;ALTE WERTE
    if (mOp.Equal(m$.var("YOPEN").get(),"OLD")) {
      mVar YKEY = m$.var("YKEY");
      YKEY.set(m$.var("YYKEY").get());
      YFELD.set(m$.var("YYFELD").get());
      //<< . new SCHLUESSEL,MAXYKEY,Q
      mVar SCHLUESSEL = m$.var("SCHLUESSEL");
      mVar MAXYKEY = m$.var("MAXYKEY");
      mVar Q = m$.var("Q");
      m$.newVar(SCHLUESSEL,MAXYKEY,Q);
      //<< . set SCHLUESSEL=""
      SCHLUESSEL.set("");
      //<< . if YDATEI'="" do
      if (mOp.NotEqual(YDATEI.get(),"")) {
        //<< . . set MAXYKEY = +$order(^WWW002(0,YDATEI,""),-1)
        MAXYKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
        //<< . . if MAXYKEY'=0 do
        if (mOp.NotEqual(MAXYKEY.get(),0)) {
          //<< . . . set Q=0
          Q.set(0);
          //<< . . . set SCHLUESSEL="^"_YDATEI_"("_$$^WWWYM(YDATEI,1)
          SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get(),1)));
          //<< . . . set YDATA=$get(^WWW001(0,YDATEI,1))
          mVar YDATA = m$.var("YDATA");
          YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)));
          //<< . . . if $piece(YDATA,Y,12)'="" if $piece(YDATA,Y,13)'="" do  ;UCI UND VOL ;UCI And
          if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
              do {
                //<< . . . . quit:$find(SCHLUESSEL,"^[")
                if (mOp.Logical(m$.Fnc.$find(SCHLUESSEL.get(),"^["))) {
                  break;
                }
                //<< . . . . set SCHLUESSEL="^["""_$piece(YDATA,Y,12)_""","""_$piece(YDATA,Y,13)_"""]"_$piece(SCHLUESSEL,"^",2,999)
                SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[\"",m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\",\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\"]"),m$.Fnc.$piece(SCHLUESSEL.get(),"^",2,999)));
              } while (false);
            }
          }
          //<< . . . ;
          //<< . . . for I=1:1:MAXYKEY set XYKEY=$translate($piece(YKEY,",",I),"""") set SCHLUESSEL=SCHLUESSEL_""""_XYKEY_"""," if XYKEY="" set Q=1 quit
          mVar I = m$.var("I");
          for (I.set(1);(mOp.LessOrEqual(I.get(),MAXYKEY.get()));I.set(mOp.Add(I.get(),1))) {
            mVar XYKEY = m$.var("XYKEY");
            XYKEY.set(m$.Fnc.$translate(m$.Fnc.$piece(YKEY.get(),",",I.get()),"\""));
            SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat(SCHLUESSEL.get(),"\""),XYKEY.get()),"\","));
            if (mOp.Equal(XYKEY.get(),"")) {
              Q.set(1);
              break;
            }
          }
          //<< . . . if $piece(YDATA,Y,8)'=4 set SCHLUESSEL=SCHLUESSEL_"1"
          if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
            SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),"1"));
          }
          //<< . . . if $piece(YDATA,Y,8)=4 if $extract(SCHLUESSEL,$length(SCHLUESSEL))="," set SCHLUESSEL=$extract(SCHLUESSEL,1,$length(SCHLUESSEL)-1)
          if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
            if (mOp.Equal(m$.Fnc.$extract(SCHLUESSEL.get(),m$.Fnc.$length(SCHLUESSEL.get())),",")) {
              SCHLUESSEL.set(m$.Fnc.$extract(SCHLUESSEL.get(),1,mOp.Subtract(m$.Fnc.$length(SCHLUESSEL.get()),1)));
            }
          }
          //<< . . . set SCHLUESSEL=SCHLUESSEL_")"
          SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),")"));
          //<< . . . if Q=0 if $data(@(SCHLUESSEL)) set YSAVEDDATA=1
          if (mOp.Equal(Q.get(),0)) {
            if (mOp.Logical(m$.Fnc.$data(m$.indirectVar((SCHLUESSEL.get()))))) {
              mVar YSAVEDDATA = m$.var("YSAVEDDATA");
              YSAVEDDATA.set(1);
            }
          }
          //<< . . . if Q=0 do
          if (mOp.Equal(Q.get(),0)) {
            //<< . . . . new strKEY
            mVar strKEY = m$.var("strKEY");
            m$.newVar(strKEY);
            //<< . . . . set YLOCK=+$piece($get(^WWW001(0,YDATEI,1)),Y,6)
            mVar YLOCK = m$.var("YLOCK");
            YLOCK.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)),m$.var("Y").get(),6)));
            //<< . . . . set strKEY = $translate(SCHLUESSEL,",()""",".//")
            strKEY.set(m$.Fnc.$translate(SCHLUESSEL.get(),",()\"",".//"));
            //<< . . . . if YLOCK'=0 if $data(^WWW006(0,dteToday,strKEY,1)) do
            if (mOp.NotEqual(YLOCK.get(),0)) {
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW006",0,dteToday.get(),strKEY.get(),1)))) {
                //<< . . . . . set YA(1)=^WWW006(0,dteToday,strKEY,1)
                mVar YA = m$.var("YA");
                YA.var(1).set(m$.var("^WWW006",0,dteToday.get(),strKEY.get(),1).get());
                //<< . . . . . if YUSER'=$piece(YA(1),Y,1) if ($piece(YA(1),Y,2)+YLOCK)>$piece($horolog,",",2) set Q=1 set YBEARB=4
                if (mOp.NotEqual(m$.var("YUSER").get(),m$.Fnc.$piece(YA.var(1).get(),m$.var("Y").get(),1))) {
                  if (mOp.Greater((mOp.Add(m$.Fnc.$piece(YA.var(1).get(),m$.var("Y").get(),2),YLOCK.get())),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2))) {
                    Q.set(1);
                    YBEARB.set(4);
                  }
                }
              }
            }
            //<< . . . . ;
            //<< . . . . if Q=0 set ^WWW006(0,dteToday,strKEY,1) = YUSER_Y_$piece($horolog,",",2)
            if (mOp.Equal(Q.get(),0)) {
              m$.var("^WWW006",0,dteToday.get(),strKEY.get(),1).set(mOp.Concat(mOp.Concat(m$.var("YUSER").get(),m$.var("Y").get()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2)));
            }
            //<< . . . . set ^WWWDATEN(0,dteToday,YUSER,YFORM,"LOCK",1) = "^WWW006(0,"_dteToday_","""_strKEY_""",1)"
            m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"LOCK",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW006(0,",dteToday.get()),",\""),strKEY.get()),"\",1)"));
          }
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< // WWWDATEN is populated - if not changing tabs
    //<< 
    //<< set KEYKEY   = $translate(YKEY,"""")
    mVar KEYKEY = m$.var("KEYKEY");
    KEYKEY.set(m$.Fnc.$translate(m$.var("YKEY").get(),"\""));
    //<< set FELDFELD = YFELD
    mVar FELDFELD = m$.var("FELDFELD");
    FELDFELD.set(YFELD.get());
    //<< 
    //<< if (YOPEN'=2) { //SR13195
    if ((mOp.NotEqual(m$.var("YOPEN").get(),2))) {
      //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"P",1) = $get(YKEY)   ;Defaults
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1).set(m$.Fnc.$get(m$.var("YKEY")));
      //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"P",2) = $get(YKEY)
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",2).set(m$.Fnc.$get(m$.var("YKEY")));
      //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"D",1) = $get(YFELD)  ;snapshot of data (working record to save any user or program changes before saving)
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1).set(m$.Fnc.$get(YFELD));
      //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"D",2) = $get(YFELD)  ;snapshot of data (backup record to undo changes. Caution: gets changed in WWWFORM9 to include default data changes during form load)
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",2).set(m$.Fnc.$get(YFELD));
      //<< ;   set ^WWWDATEN(0,dteToday,YUSER,YFORM,"D",3) = $get(objStoredData,$get(YFELD))  ;SR15828: snapshot of data before form load and before any executes (calls)
      //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"M",1) = $get(YMFELD)
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"M",1).set(m$.Fnc.$get(m$.var("YMFELD")));
    }
    //<< }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;AUFRUF KEINE ÄNDERUNG, WENN DATENFELD BELEGT (RECHNUNGSNUMMER=KEINE ÄNDERUNG MEHR)
    //<< if $$$WWW120ReadOnlyWhenDataFieldIsIn(YVOR)'="" do
    if (mOp.NotEqual(include.WWWConst.$$$WWW120ReadOnlyWhenDataFieldIsIn(m$,m$.var("YVOR")),"")) {
      //<< . new NICHTFELD,YI
      mVar NICHTFELD = m$.var("NICHTFELD");
      m$.newVar(NICHTFELD,YI);
      //<< . set NICHTFELD = $translate($$$WWW120ReadOnlyWhenDataFieldIsIn(YVOR),";",",")
      NICHTFELD.set(m$.Fnc.$translate(include.WWWConst.$$$WWW120ReadOnlyWhenDataFieldIsIn(m$,m$.var("YVOR")),";",","));
      //<< . for YI=1:1 quit:$piece(NICHTFELD,",",YI)=""  do
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        if (mOp.Equal(m$.Fnc.$piece(NICHTFELD.get(),",",YI.get()),"")) {
          break;
        }
        do {
          //<< . . quit:$translate($piece(YFELD,Y,$piece(NICHTFELD,",",YI))," "_$char(0))=""  ;DATENFELD=LEER;TYBD;4,2,2005
          if (mOp.Equal(m$.Fnc.$translate(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.Fnc.$piece(NICHTFELD.get(),",",YI.get())),mOp.Concat(" ",m$.Fnc.$char(0))),"")) {
            break;
          }
          //<< . . set $$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly
          include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
        } while (false);
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;AUFRUF KEINE ÄNDERUNG, WENN MITARBEITER EIN BESTIMMTES MODUL HAT
    //<< set objWWW120D = $get(^WWW120D(0,YFORM,0,1))
    objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",0,m$.var("YFORM").get(),0,1)));
    //<< 
    //<< if $$$WWW120ReadOnlyAccessForModules(YVOR)'="" && $length($$$WWW120DReadOnlyAccessForModules(objWWW120D))=0 do
    if (mOp.Equal(mOp.NotEqual(include.WWWConst.$$$WWW120ReadOnlyAccessForModules(m$,m$.var("YVOR")),"") && mOp.Logical(m$.Fnc.$length(include.WWWConst.$$$WWW120DReadOnlyAccessForModules(m$,objWWW120D))),0)) {
      do {
        //<< . new MODUL,MODUL1,YI
        mVar MODUL = m$.var("MODUL");
        mVar MODUL1 = m$.var("MODUL1");
        m$.newVar(MODUL,MODUL1,YI);
        //<< . set MODUL = $$^WWWBEDMOD(YBED)
        MODUL.set(m$.fnc$("WWWBEDMOD.main",m$.var("YBED").get()));
        //<< . quit:MODUL=""
        if (mOp.Equal(MODUL.get(),"")) {
          break;
        }
        //<< . quit:+$$^WWWBEDBER(YBED)=1
        if (mOp.Equal(mOp.Positive(m$.fnc$("WWWBEDBER.main",m$.var("YBED").get())),1)) {
          break;
        }
        //<< . set MODUL1 = $translate($$$WWW120ReadOnlyAccessForModules(YVOR),";",",")
        MODUL1.set(m$.Fnc.$translate(include.WWWConst.$$$WWW120ReadOnlyAccessForModules(m$,m$.var("YVOR")),";",","));
        //<< . if $extract(MODUL1)="," set MODUL1 = $extract(MODUL1,2,999)  ;tybd;1.9.2003
        if (mOp.Equal(m$.Fnc.$extract(MODUL1.get()),",")) {
          MODUL1.set(m$.Fnc.$extract(MODUL1.get(),2,999));
        }
        //<< . if $extract(MODUL1)="," set MODUL1 = $extract(MODUL1,2,999)
        if (mOp.Equal(m$.Fnc.$extract(MODUL1.get()),",")) {
          MODUL1.set(m$.Fnc.$extract(MODUL1.get(),2,999));
        }
        //<< . for YI=1:1 quit:$piece(MODUL1,",",YI)=""  do
        for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
          if (mOp.Equal(m$.Fnc.$piece(MODUL1.get(),",",YI.get()),"")) {
            break;
          }
          do {
            //<< . . quit:$piece(MODUL1,",",YI)=""
            if (mOp.Equal(m$.Fnc.$piece(MODUL1.get(),",",YI.get()),"")) {
              break;
            }
            //<< . . if $find(","_MODUL_",",","_$piece(MODUL1,",",YI)_",") set $$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",MODUL.get()),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(MODUL1.get(),",",YI.get())),",")))) {
              include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
            }
          } while (false);
        }
      } while (false);
    }
    //<< 
    //<< if $$$WWW120DReadOnlyAccessForModules(objWWW120D)'="" do
    if (mOp.NotEqual(include.WWWConst.$$$WWW120DReadOnlyAccessForModules(m$,objWWW120D),"")) {
      do {
        //<< . new MODUL,MODUL1,YI
        mVar MODUL = m$.var("MODUL");
        mVar MODUL1 = m$.var("MODUL1");
        m$.newVar(MODUL,MODUL1,YI);
        //<< . set MODUL = $$^WWWBEDMOD(YBED)
        MODUL.set(m$.fnc$("WWWBEDMOD.main",m$.var("YBED").get()));
        //<< . quit:MODUL=""
        if (mOp.Equal(MODUL.get(),"")) {
          break;
        }
        //<< . quit:+$$^WWWBEDBER(YBED)=1
        if (mOp.Equal(mOp.Positive(m$.fnc$("WWWBEDBER.main",m$.var("YBED").get())),1)) {
          break;
        }
        //<< . set MODUL1 = $translate($$$WWW120DReadOnlyAccessForModules(objWWW120D),";",",")
        MODUL1.set(m$.Fnc.$translate(include.WWWConst.$$$WWW120DReadOnlyAccessForModules(m$,objWWW120D),";",","));
        //<< . if $extract(MODUL1)="," set MODUL1 = $extract(MODUL1,2,999)
        if (mOp.Equal(m$.Fnc.$extract(MODUL1.get()),",")) {
          MODUL1.set(m$.Fnc.$extract(MODUL1.get(),2,999));
        }
        //<< . if $extract(MODUL1)="," set MODUL1 = $extract(MODUL1,2,999)
        if (mOp.Equal(m$.Fnc.$extract(MODUL1.get()),",")) {
          MODUL1.set(m$.Fnc.$extract(MODUL1.get(),2,999));
        }
        //<< . for YI=1:1 quit:$piece(MODUL1,",",YI)=""  do
        for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
          if (mOp.Equal(m$.Fnc.$piece(MODUL1.get(),",",YI.get()),"")) {
            break;
          }
          do {
            //<< . . quit:$piece(MODUL1,",",YI)=""
            if (mOp.Equal(m$.Fnc.$piece(MODUL1.get(),",",YI.get()),"")) {
              break;
            }
            //<< . . if $find(","_MODUL_",",","_$piece(MODUL1,",",YI)_",") set $$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",MODUL.get()),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(MODUL1.get(),",",YI.get())),",")))) {
              include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
            }
          } while (false);
        }
      } while (false);
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   SONDERFUNKTION EXECUTE ANSTELLE FORMULARAUFBAU   *** EXECUTE 4 ***
    //<< ;
    //<< ;   Execute special function instead of normal form layout
    //<< ;------------------------------------------------------------------------
    //<< set strExec = $$$WWW120ExecuteAfterButtonLine(YVOR)
    mVar strExec = m$.var("strExec");
    strExec.set(include.WWWConst.$$$WWW120ExecuteAfterButtonLine(m$,m$.var("YVOR")));
    //<< 
    //<< if $extract(strExec)="#" do  quit  ;Manual call
    if (mOp.Equal(m$.Fnc.$extract(strExec.get()),"#")) {
      //<< . xecute $extract(strExec,2,99)  ;EXECUTE VOR FORMULAR ;EXECUTE pre- form
      m$.Cmd.Xecute(m$.Fnc.$extract(strExec.get(),2,99));
      return;
    }
    //<< 
    //<< ;   SONDERFUNKTION EXECUTE FOR FORMULARAUFBAU  ;FIS;27442;03.03.05
    //<< ;------------------------------------------------------------------------
    //<< if $extract(strExec)="*" new Q do  quit:$get(Q)=1      ;MANUELLER AUFRUF
    if (mOp.Equal(m$.Fnc.$extract(strExec.get()),"*")) {
      mVar Q = m$.var("Q");
      m$.newVar(Q);
      //<< . xecute $extract(strExec,2,99)                        ;EXECUTE VOR FORMULAR
      m$.Cmd.Xecute(m$.Fnc.$extract(strExec.get(),2,99));
      //<< . if $get(Q)=1 set %("VAR","YKEY")="" do ^WWWFORM      ;NEU LADEN
      if (mOp.Equal(m$.Fnc.$get(Q),1)) {
        m$.var("%","VAR","YKEY").set("");
        m$.Cmd.Do("WWWFORM.main");
      }
      if (mOp.Equal(m$.Fnc.$get(Q),1)) {
        return;
      }
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ; Form Type *NOT*
    //<< ;  2 : List Generator
    //<< ;  5 : Manual Input (without Button)
    //<< ;  8 : Wizard
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   D66     $$$WWW120PositioningOfButtonLine()
    //<< ;   D123    $$$WWW120SaveServerdata()
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;START HTML ;take-off HTML
    //<< ;------------------------------------------------------------------------
    //<< if (YFOART'=2) && (YFOART'=6) && (YFOART'=8) && (+$$$WWW120SaveServerdata(YVOR)=$$$YES) do
    if ((mOp.NotEqual(YFOART.get(),2)) && (mOp.NotEqual(YFOART.get(),6)) && (mOp.NotEqual(YFOART.get(),8)) && (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120SaveServerdata(m$,m$.var("YVOR"))),include.COMSYS.$$$YES(m$)))) {
      //<< . if +$$$WWW120PositioningOfButtonLine(YVOR)'=1 set YHTMFORM="WWW2"  ;2. FORM FÜR FAST SAVE  NUR WENNKEIN BUTTON UNTEN ;shape to next only underneath
      if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW120PositioningOfButtonLine(m$,m$.var("YVOR"))),1)) {
        YHTMFORM.set("WWW2");
      }
    }
    //<< 
    //<< $$$LOGWWWBENCH(4)
    $$$LOGWWWBENCH(m$,4);
    //<< 
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ; 10 : GANTT CHART
    //<< ;+++++++++++++++++++++++++++++++++++++++    ; ***   EARLY EXIT   ***
    //<< if YFOART=10 do  quit
    if (mOp.Equal(YFOART.get(),10)) {
      //<< . do ^WWWDRAGDROP(YFORM)
      m$.Cmd.Do("WWWDRAGDROP.main",m$.var("YFORM").get());
      //<< . do OPEN^WWWSTART
      m$.Cmd.Do("WWWSTART.OPEN");
      //<< . write "</FONT>",YCR
      m$.Cmd.Write("</FONT>",m$.var("YCR").get());
      //<< . do ^WWWSTOP
      m$.Cmd.Do("WWWSTOP.main");
      return;
    }
    //<< 
    //<< set ^WWWSOR(YUSER)=""
    m$.var("^WWWSOR",m$.var("YUSER").get()).set("");
    //<< ;***************************************
    //<< lock +^WWWSOR(YUSER):3           ;NUR EIN JOB ;only uni-
    m$.Cmd.LockInc(m$.var("^WWWSOR",m$.var("YUSER").get()),3);
    //<< ;***************************************
    //<< do ^WWWSTART(YNAME,1,$$$WWW120RefreshSeconds(YVOR))
    m$.Cmd.Do("WWWSTART.main",YNAME.get(),1,include.WWWConst.$$$WWW120RefreshSeconds(m$,m$.var("YVOR")));
    //<< 
    //<< ;---------------------------------------
    //<< ;   *** EXECUTE 5ab - 6ab ***
    //<< ;---------------------------------------
    //<< set strHookStatus = $$ExecuteHook^WWW001Hook(YDATEI,$$$EnumWWWEVENTTYPEOnBeforeEditAccess,YKEY,$get(YFELD),YFORM)
    mVar strHookStatus = m$.var("strHookStatus");
    strHookStatus.set(m$.fnc$("WWW001Hook.ExecuteHook",YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeEditAccess(m$),m$.var("YKEY").get(),m$.Fnc.$get(YFELD),m$.var("YFORM").get()));
    //<< if $$$ISOK(strHookStatus) if '$$$NoKey(YKEY) set strHookStatus = $$ExecuteHook^WWW001Hook(YDATEI,$$$EnumWWWEVENTTYPEOnFilter,YKEY,$get(YFELD),YFORM)  ;BR014726
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strHookStatus))) {
      if (mOp.Not(include.COMSYS.$$$NoKey(m$,m$.var("YKEY")))) {
        strHookStatus.set(m$.fnc$("WWW001Hook.ExecuteHook",YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnFilter(m$),m$.var("YKEY").get(),m$.Fnc.$get(YFELD),m$.var("YFORM").get()));
      }
    }
    //<< if $$$ISERR(strHookStatus) set $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strHookStatus))) {
      include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
    }
    //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"V","AUTHORISATION",1) = $$$WWW120AuthorizationToModifyData(YVOR) ;BR014955
    m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","AUTHORISATION",1).set(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")));
    //<< 
    //<< do ^WWWFORM8                ;JAVA
    m$.Cmd.Do("WWWFORM8.main");
    //<< do ^WWWBODY(1,"NOPRINT")    ;BODY TAG
    m$.Cmd.Do("WWWBODY.main",1,"NOPRINT");
    //<< set YREFRKEY = $get(YKEY)   ;KEY FÜR REFRESH PRÜFUNG;FIS;24.08.04 ;KEY to REFRESH check
    mVar YREFRKEY = m$.var("YREFRKEY");
    YREFRKEY.set(m$.Fnc.$get(m$.var("YKEY")));
    //<< do START                                ; *** EXECUTES ***
    m$.Cmd.Do("START");
    //<< 
    //<< ;***************************************
    //<< lock -^WWWSOR(YUSER)
    m$.Cmd.Unlock(m$.var("^WWWSOR",m$.var("YUSER").get()));
    //<< ;***************************************
    //<< do STOP
    m$.Cmd.Do("STOP");
    //<< ; snapshot of saved data after form load and after all executes (calls)
    //<< if ($get(YDATEI)'="") && ($get(YKEY)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(YDATEI),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY")),""))) {
      //<< xecute "set objStoredData=$get(^"_YDATEI_"("""_$$^WWWYM(YDATEI)_""","_$$^WWWKEYBUILD(YKEY)_",1))"
      m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("set objStoredData=$get(^",YDATEI.get()),"(\""),m$.fnc$("WWWYM.main",YDATEI.get())),"\","),m$.fnc$("WWWKEYBUILD.main",m$.var("YKEY").get())),",1))"));
    }
    //<< }
    //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"D",4) = $get(objStoredData,$get(YFELD))
    m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",4).set(m$.Fnc.$get(m$.var("objStoredData"),m$.Fnc.$get(YFELD)));
    //<< 
    //<< if $get(YMOUSETR)=$$$YES do BODY^WWWTRAIL
    if (mOp.Equal(m$.Fnc.$get(m$.var("YMOUSETR")),include.COMSYS.$$$YES(m$))) {
      m$.Cmd.Do("WWWTRAIL.BODY");
    }
    //<< 
    //<< $$$LOGWWWBENCH(5)
    $$$LOGWWWBENCH(m$,5);
    //<< 
    //<< ;SR17998 if ($get(YBED)'="") && (YFORM'="") set ^WWWBENCH(0,dteToday,YSTARTTIME1,YFORM,YBED,1) = $zhorolog-YSTARTTIME  ;SAVE BENCHMARK
    //<< if ($get(YBED)'="") && (YFORM'="") new strStatus set strStatus=$$Save^COMUtils("WWWBENCH",dteToday_","_YSTARTTIME1_","_YFORM_","_YBED,$zhorolog-YSTARTTIME,0)  ;SAVE BENCHMARK ;SR17998
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) && (mOp.NotEqual(m$.var("YFORM").get(),""))) {
      m$.newVar(strStatus);
      //TODO REVISAR SAVE strStatus.set(m$.fnc$("COMUtils.Save","WWWBENCH",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(dteToday.get(),","),YSTARTTIME1.get()),","),m$.var("YFORM").get()),","),m$.var("YBED").get()),mOp.Subtract(m$.Fnc.$zhorolog(),YSTARTTIME.get()),0));
    }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< ExecButton(YFORM,YBUTTON,YOPEN) private
  public Object ExecButton(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YBUTTON = m$.newVarRef("YBUTTON",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YOPEN = m$.newVarRef("YOPEN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; History:
    //<< ; 05-Jul-2007   GRF     YEXEC *must* be non-null so no need to re-test.
    //<< ; 02-May-2007   GRF     SR15509: YEXEC being newed incorrectly - move code to
    //<< ;                           ExecButton.
    //<< ;-------------------------------------------------------------------------------
    //<< new YEXEC
    mVar YEXEC = m$.var("YEXEC");
    m$.newVar(YEXEC);
    //<< 
    //<< ;   *** EXECUTE 2 ***
    //<< 
    //<< if (YFORM'="") && (YBUTTON'="") {
    if ((mOp.NotEqual(YFORM.get(),"")) && (mOp.NotEqual(YBUTTON.get(),""))) {
      //<< set YEXEC = $$$WWW124ExecuteAfterBackwardStep($get(^WWW124(0,YFORM,SPRACHE,YBUTTON,1)))
      YEXEC.set(include.WWWConst.$$$WWW124ExecuteAfterBackwardStep(m$,m$.Fnc.$get(m$.var("^WWW124",0,YFORM.get(),m$.var("SPRACHE").get(),YBUTTON.get(),1))));
      //<< if YEXEC="" set YEXEC = "d ^WWWSBUR"                       ;AUTORÜCKSPRUNG    ;AutoReturn
      if (mOp.Equal(YEXEC.get(),"")) {
        YEXEC.set("d ^WWWSBUR");
      }
      //<< if YOPEN'="OLD" xecute YEXEC               ;05-Jul-2007
      if (mOp.NotEqual(YOPEN.get(),"OLD")) {
        m$.Cmd.Xecute(YEXEC.get());
      }
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< START
  public void START() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; START FORM  (ACHTUNG EINSPRUNG) ;take-off shape
    //<< ;              ANZEIGEN DES FORMS ERST NACH DEM ENDE
    //<< ;
    //<< ; Called By: ^WWWFORM, FORM^WWWHPR, FORM^WWWHPR1
    //<< ;
    //<< ; History:
    //<< ; 11-Jun-2013   shobby  CORE-108.3: Save data into WWW1265
    //<< ; 07-Jun-2013   shobby  CORE-116.3: Scrollbar fix suggested by Thiago and Lucas
    //<< ; 29-May-2013   shobby  CORE-115: Can't get Opacity working in IE8
    //<< ; 28-May-2013   shobby  CORE-115: Animated GIF will SaveLayer is active.
    //<< ; 02-Dec-2009   shobby  SR16943: Give an id to the div used with the FixedHeader
    //<< ;                           so it can be used later to determine the position of
    //<< ;                           the popup help message.
    //<< ; 01-Dec-2009   shobby  SR17065: If there are no fields on the form don't call
    //<< ;                           out to WWWFORMH.  This just screws up the
    //<< ;                           positioning of any forms drawn in OnAfterDataFields
    //<< ;                           as a table is closed without being opened.
    //<< ; 23-Oct-2008   shobby  SR15878: Removed DEVMODE condition
    //<< ; 01-Sep-2008   FIS     SR15878: layer to disable form after save click
    //<< ; 18-Jan-2008   GRF     SR15619: boolean macros and tidy parentheses
    //<< ; 14-Jan-2008   FIS     SR15619: replaced it again -> new: set grid form always
    //<< ;                           to "show frame"
    //<< ; 14-Jan-2008   GRF     SR15619: brace rather than dot syntax
    //<< ; 10-Jan-2008   FIS     SR15619: also start table if "framed forms" is set to NO
    //<< ; 02-Oct-2007   shobby  SRBR014726: Callback OnFilter may optionally either
    //<< ;                           specify that 1) a record can not be viewed.
    //<< ;                           Or 2) That it can be viewed but readonly.
    //<< ;                           When opening it from the normal form.
    //<< ; 27-Sep-2007   GRF     SR15603: Macro change
    //<< ; 02-May-2007   GRF     SR15509: Consider null & zero when testing for Boolean.
    //<< ; 22-Mar-2007   JW      SR15453: Cache YOPTION, YOPTION1
    //<< ; 14-Dec-2006   Steve S SR15316: Hook Status Check
    //<< ; 05-Dec-2006   Steve S BR014333: If a record's in use, lock the entire form.
    //<< ; 09-Nov-2006   Steve S SR14710: Pass in YFELD/YKEY to var hooks
    //<< ; 26-Sep-2006   PO      SR14864: Added logging
    //<< ; 11-Sep-2006   Steve S SR14286: Use $$DrawTabs, not subscript "2" check.
    //<< ; 06-Jul-2006   SC      SR14710: Added OnBeforeEditAccess VARHook check.
    //<< ; 05.Aug.1997   DT      DITMAR TYBUSSEK: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strExec
    mVar strExec = m$.var("strExec");
    m$.newVar(strExec);
    //<< 
    //<< $$$LogR("START",$get(YFORM)_"<"_$get(YPARA)_"<")
    $$$LogR(m$,"START",mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YFORM")),"<"),m$.Fnc.$get(m$.var("YPARA"))),"<"));
    //<< 
    //<< ;#######################################
    //<< ;if $get(YFIXHEADER)'=1 do
    //<< ;. write "<TABLE BORDER=0 cellspacing=0 cellpadding=0 WIDTH=""100%""><TR><TD>"
    //<< ;. set YTABLEANZ=$get(YTABLEANZ)+1
    //<< 
    //<< if $get(YFIXHEADER)=$$$YES {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFIXHEADER")),include.COMSYS.$$$YES(m$))) {
      //<< set YTABLEANZ = $get(YTABLEANZ)+1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
      //<< write "<TABLE id='xxx' BORDER=0 cellspacing=0 cellpadding=0 height=""99%"" WIDTH=""100%""><TR height=""4px"" width=""100%""><TD>"
      m$.Cmd.Write("<TABLE id='xxx' BORDER=0 cellspacing=0 cellpadding=0 height=\"99%\" WIDTH=\"100%\"><TR height=\"4px\" width=\"100%\"><TD>");
    }
    //<< }
    //<< ;#######################################
    //<< 
    //<< if YKEY'="" set YFKEY = "" set YLFN = "" for  set YLFN = $order(^WWW121(0,YFORM,YLFN)) quit:YLFN=""  do   ;DEF FIXKEY
    if (mOp.NotEqual(m$.var("YKEY").get(),"")) {
      mVar YFKEY = m$.var("YFKEY");
      YFKEY.set("");
      mVar YLFN = m$.var("YLFN");
      YLFN.set("");
      for (;true;) {
        YLFN.set(m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN.get())));
        if (mOp.Equal(YLFN.get(),"")) {
          break;
        }
        do {
          //<< . if $piece($get(^WWW121(0,YFORM,YLFN,1)),Y,16)="" set YLFN="ZZZZZ" quit
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN.get(),1)),m$.var("Y").get(),16),"")) {
            YLFN.set("ZZZZZ");
            break;
          }
          //<< . set $piece(YFKEY,",",YLFN) = $translate($piece(YKEY,",",YLFN),"""")
          m$.pieceVar(YFKEY,",",YLFN.get()).set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YKEY").get(),",",YLFN.get()),"\""));
        } while (false);
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< do ^WWWHIDD   ; Start <FORM> & preserve variables as hidden <INPUT> fields
    m$.Cmd.Do("WWWHIDD.main");
    //<< 
    //<< $$$LOGWWWBENCH(10)
    $$$LOGWWWBENCH(m$,10);
    //<< 
    //<< if (+$$$WWW120PicturesAsButtons(YVOR)=$$$YES) {  //SR15878; layer to disable form  D45
    if ((mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.var("YVOR"))),include.COMSYS.$$$YES(m$)))) {
      //<< ;CORE-115 vvvvvv
      //<< write "<div id='HideButtons' style='"
      m$.Cmd.Write("<div id='HideButtons' style='");
      //<< write " top:-100px;"
      m$.Cmd.Write(" top:-100px;");
      //<< write "width:100%; position:absolute; overflow:none; z-index:9999999999999999; visibility:hidden; "
      m$.Cmd.Write("width:100%; position:absolute; overflow:none; z-index:9999999999999999; visibility:hidden; ");
      //<< write "'>"
      m$.Cmd.Write("'>");
      //<< 
      //<< write "<DIV style='"
      m$.Cmd.Write("<DIV style='");
      //<< write "width:100%; height:100%; position:absolute; "  ;SR17481 ****
      m$.Cmd.Write("width:100%; height:100%; position:absolute; ");
      //<< if $get(%CGIEVAR("HTTP_USER_AGENT"))'["MSIE 8.0" {
      if (mOp.NotContains(m$.Fnc.$get(m$.var("%CGIEVAR","HTTP_USER_AGENT")),"MSIE 8.0")) {
        //<< write " background-color:darkgray; "_$$Opacity^WWWFORMCrossBrowserSupportVisual(50)_" "
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" background-color:darkgray; ",m$.fnc$("WWWFORMCrossBrowserSupportVisual.Opacity",50))," "));
      }
      //<< }
      //<< write "'>"
      m$.Cmd.Write("'>");
      //<< write "</div>"
      m$.Cmd.Write("</div>");
      //<< 
      //<< write "<DIV style='"
      m$.Cmd.Write("<DIV style='");
      //<< write "width:100%; height:100%; position:absolute; "  ;SR17481 ****
      m$.Cmd.Write("width:100%; height:100%; position:absolute; ");
      //<< ;write " background:url("_YGIF_"loading2.gif); "
      //<< write " background:url("_YGIF_"circle_loading1.gif); "
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" background:url(",m$.var("YGIF").get()),"circle_loading1.gif); "));
      //<< write " background-position:center; background-repeat:no-repeat;"
      m$.Cmd.Write(" background-position:center; background-repeat:no-repeat;");
      //<< write "'>"
      m$.Cmd.Write("'>");
      //<< write "</DIV>" ;SRAAAAA
      m$.Cmd.Write("</DIV>");
      //<< 
      //<< write "</div>"
      m$.Cmd.Write("</div>");
    }
    //<< ;CORE-115 ^^^^^
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ; Display Heading
    //<< ;---------------------------------------
    //<< 
    //<< ;##### vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    //<< if $$$WWW120FormCentered(YVOR)=$$$YES write "<CENTER>"
    if (mOp.Equal(include.WWWConst.$$$WWW120FormCentered(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$))) {
      m$.Cmd.Write("<CENTER>");
    }
    //<< ;##### ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    //<< 
    //<< if '$find($translate(YKOPF,"gif","GIF"),".GIF") do
    if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(m$.var("YKOPF").get(),"gif","GIF"),".GIF"))) {
      //<< . if $data(^WWW00441s(0,3,YFORM)) do  ;NEUER Name
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW00441s",0,3,m$.var("YFORM").get())))) {
        do {
          //<< . . new YBER,YPROG
          mVar YBER = m$.var("YBER");
          mVar YPROG = m$.var("YPROG");
          m$.newVar(YBER,YPROG);
          //<< . . set YBER  = $order(^WWW00441s(0,3,YFORM,""))       quit:YBER=""
          YBER.set(m$.Fnc.$order(m$.var("^WWW00441s",0,3,m$.var("YFORM").get(),"")));
          if (mOp.Equal(YBER.get(),"")) {
            break;
          }
          //<< . . set YPROG = $order(^WWW00441s(0,3,YFORM,YBER,""))  quit:YPROG=""
          YPROG.set(m$.Fnc.$order(m$.var("^WWW00441s",0,3,m$.var("YFORM").get(),YBER.get(),"")));
          if (mOp.Equal(YPROG.get(),"")) {
            break;
          }
          //<< . . if $piece($get(^WWW00441(0,YBER,YPROG,1)),Y,1)'="" set YKOPF = $piece($get(^WWW00441(0,YBER,YPROG,1)),Y,1) set YNAME=YKOPF
          if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW00441",0,YBER.get(),YPROG.get(),1)),m$.var("Y").get(),1),"")) {
            mVar YKOPF = m$.var("YKOPF");
            YKOPF.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW00441",0,YBER.get(),YPROG.get(),1)),m$.var("Y").get(),1));
            mVar YNAME = m$.var("YNAME");
            YNAME.set(YKOPF.get());
          }
        } while (false);
      }
      //<< . ;
      //<< . do ^WWWKOPF(YKOPF)
      m$.Cmd.Do("WWWKOPF.main",m$.var("YKOPF").get());
    }
    //<< 
    //<< ; SET START ANCHOR
    //<< ;---------------------------------------
    //<< if $$$WWW120DoNOTDisplayFormHeader(YVOR)=$$$YES do ^WWWUP($$$NO)     ; FIXME : also in WWWKOPF?
    if (mOp.Equal(include.WWWConst.$$$WWW120DoNOTDisplayFormHeader(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$))) {
      m$.Cmd.Do("WWWUP.main",include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< ; IMAGE RATHER THAN FORM NAME IN HEADING
    //<< ;---------------------------------------
    //<< if (YKOPF'="") && $find($translate(YKOPF,"gif","GIF"),".GIF") do
    if ((mOp.NotEqual(m$.var("YKOPF").get(),"")) && mOp.Logical(m$.Fnc.$find(m$.Fnc.$translate(m$.var("YKOPF").get(),"gif","GIF"),".GIF"))) {
      //<< . new YI,YKOPF1
      mVar YI = m$.var("YI");
      mVar YKOPF1 = m$.var("YKOPF1");
      m$.newVar(YI,YKOPF1);
      //<< .;write "<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0><TR>"
      //<< . write "<TABLE id=""wfimage"" BORDER=0 CELLSPACING=0 CELLPADDING=0><TR>"
      m$.Cmd.Write("<TABLE id=\"wfimage\" BORDER=0 CELLSPACING=0 CELLPADDING=0><TR>");
      //<< . set YTABLEANZ = $get(YTABLEANZ)+1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
      //<< . for YI=1:1 set YKOPF1=$piece(YKOPF,";",YI) quit:YKOPF1=""  do
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        YKOPF1.set(m$.Fnc.$piece(m$.var("YKOPF").get(),";",YI.get()));
        if (mOp.Equal(YKOPF1.get(),"")) {
          break;
        }
        //<< . . write YCR,"<TD><IMG SRC="""_YGIF_YKOPF1_""" hspace=0 TITLE="""_YKOPF1_""" border=0></A></TD>"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD><IMG SRC=\"",m$.var("YGIF").get()),YKOPF1.get()),"\" hspace=0 TITLE=\""),YKOPF1.get()),"\" border=0></A></TD>"));
      }
      //<< . ;
      //<< . write "</TR></TABLE>"
      m$.Cmd.Write("</TR></TABLE>");
      //<< . set YTABLEANZ = $get(YTABLEANZ)-1
      YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(YTABLEANZ),1));
    }
    //<< 
    //<< ;##### vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    //<< if $$$WWW120FormCentered(YVOR)=$$$YES write "</CENTER>"
    if (mOp.Equal(include.WWWConst.$$$WWW120FormCentered(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$))) {
      m$.Cmd.Write("</CENTER>");
    }
    //<< ;##### ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    //<< 
    //<< ;------------------------------------------------------------------------ On FORM CONSTRUCTION   *** EXECUTE 7 ***
    //<< ; SR15603 vvv
    //<< set strExec = $$$WWW012ExecuteOnFormConstruct($get(^WWW012(0,0,1)))
    strExec.set(include.WWWConst.$$$WWW012ExecuteOnFormConstruct(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))));
    //<< if strExec'="" {
    if (mOp.NotEqual(strExec.get(),"")) {
      //<< $$$jsMarker("Execute On Form Construction :"_strExec)
      $$$jsMarker(m$,mOp.Concat("Execute On Form Construction :",strExec.get()));
      //<< 
      //<< xecute strExec
      m$.Cmd.Xecute(strExec.get());
      //<< 
      //<< $$$jsMarker("End Execute On Form Construction")
      $$$jsMarker(m$,"End Execute On Form Construction");
    }
    //<< }
    //<< 
    //<< $$$LOGWWWBENCH(11)
    $$$LOGWWWBENCH(m$,11);
    //<< 
    //<< ;------------------------------------------------------------------------ BEFORE BUTTONLINE      *** EXECUTE 8 ***
    //<< set strExec = $$$WWW120ExecuteBeforeButtonline(YVOR)
    strExec.set(include.WWWConst.$$$WWW120ExecuteBeforeButtonline(m$,m$.var("YVOR")));
    //<< if (strExec'="") || ($$EXIST^%R("Y"_YFORM_"onPageLoad.OBJ",$get(YUCI))) {
    if ((mOp.NotEqual(strExec.get(),"")) || mOp.Logical((m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"onPageLoad.OBJ"),m$.Fnc.$get(m$.var("YUCI")))))) {
      //<< $$$jsMarker("Execute Before Button Line :"_strExec)
      $$$jsMarker(m$,mOp.Concat("Execute Before Button Line :",strExec.get()));
      //<< 
      //<< if ($$$WWW120FontFace(YVOR)="") || ($$$WWW120PreFormatted(YVOR)=1) write "<PRE>"
      if ((mOp.Equal(include.WWWConst.$$$WWW120FontFace(m$,m$.var("YVOR")),"")) || (mOp.Equal(include.WWWConst.$$$WWW120PreFormatted(m$,m$.var("YVOR")),1))) {
        m$.Cmd.Write("<PRE>");
      }
      //<< if $extract(strExec)="#" set $extract(strExec)=""
      if (mOp.Equal(m$.Fnc.$extract(strExec.get()),"#")) {
        mVar $extract = m$.var("$extract");
        $extract.var(strExec.get()).set("");
      }
      //<< if strExec'="" xecute strExec
      if (mOp.NotEqual(strExec.get(),"")) {
        m$.Cmd.Xecute(strExec.get());
      }
      //<< 
      //<< ;   *** EXECUTE 9 ***
      //<< if $$EXIST^%R("Y"_YFORM_"onPageLoad.OBJ",$get(YUCI)) xecute "do ^Y"_YFORM_"onPageLoad"
      if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"onPageLoad.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat("do ^Y",m$.var("YFORM").get()),"onPageLoad"));
      }
      //<< if $get(YOPTION1)'="" write YCR,"<INPUT TYPE=HIDDEN NAME=""YOPTION1"" VALUE="""_YOPTION1_""">"
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YOPTION1")),"")) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YOPTION1\" VALUE=\"",m$.var("YOPTION1").get()),"\">"));
      }
      //<< if ($$$WWW120FontFace(YVOR)="") || ($$$WWW120PreFormatted(YVOR)=1) write "</PRE>"
      if ((mOp.Equal(include.WWWConst.$$$WWW120FontFace(m$,m$.var("YVOR")),"")) || (mOp.Equal(include.WWWConst.$$$WWW120PreFormatted(m$,m$.var("YVOR")),1))) {
        m$.Cmd.Write("</PRE>");
      }
      //<< 
      //<< $$$jsMarker("End Execute Before Button Line")
      $$$jsMarker(m$,"End Execute Before Button Line");
    }
    //<< }
    //<< 
    //<< if $get(YBEARB)=4 { // in use
    if (mOp.Equal(m$.Fnc.$get(m$.var("YBEARB")),4)) {
      //<< set $$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly
      include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
    }
    //<< }
    //<< 
    //<< if (YUSER'="") && ($$$WWWUSERHTMLStarted(^WWWUSER(0,YUSER,1))=$$$NO) quit  ;STOP DURCH SONDERPROGRAMM ; *** EARLY EXIT *** <<<<<
    if ((mOp.NotEqual(m$.var("YUSER").get(),"")) && (mOp.Equal(include.WWWConst.$$$WWWUSERHTMLStarted(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),include.COMSYS.$$$NO(m$)))) {
      return;
    }
    //<< 
    //<< if (YANZ="") && ($$$WWW012MenuType($get(^WWW012(0,0,1)))=6) {
    if ((mOp.Equal(m$.var("YANZ").get(),"")) && (mOp.Equal(include.WWWConst.$$$WWW012MenuType(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))),6))) {
      //<< do ^WWWMENU7  ;MENUEART MENUE ANZEIGEN ;display
      m$.Cmd.Do("WWWMENU7.main");
    }
    //<< }
    //<< 
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ; 0 Buttons Above   1 Button Down   2 Text Border Left   3 Selection
    //<< ;------------------------------------------------------------------------
    //<< if $$$Contains((0,2,3),+$$$WWW120PositioningOfButtonLine(YVOR)) {
    if (true || mOp.Logical(include.COMSYS.$$$Contains(m$,(0),mOp.Positive(include.WWWConst.$$$WWW120PositioningOfButtonLine(m$,m$.var("YVOR")))))) {
      //<< 
      //<< do ^WWWFORM1    ;BUTTONS                                     ; *** EXECUTE 10-13 ***
      m$.Cmd.Do("WWWFORM1.main");
    }
    //<< }
    //<< 
    //<< $$$LOGWWWBENCH(12)
    $$$LOGWWWBENCH(m$,12);
    //<< 
    //<< ;#######################################
    //<< if $get(YFIXHEADER)=$$$YES {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFIXHEADER")),include.COMSYS.$$$YES(m$))) {
      //<< write "</td></tr><tr><td>"
      m$.Cmd.Write("</td></tr><tr><td>");
      //<< ;CORE-116.3 write "<div id='divFixedHeader' style=""width: 100%; height: 100%; overflow: auto; "">"     ;SR16943
      //<< write "<div id='divFixedHeader' style=""width: 100%; height: 100%; float:left; overflow: auto; "">"         ;CORE-116.3
      m$.Cmd.Write("<div id='divFixedHeader' style=\"width: 100%; height: 100%; float:left; overflow: auto; \">");
    }
    //<< }
    //<< ;#######################################
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< $$$jsMarker("Button Line")
    $$$jsMarker(m$,"Button Line");
    //<< if +$$$WWW120PositioningOfButtonLine(YVOR)=2 {   ;BUTTON AN DER LINKEN SEITE ;upon the side
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120PositioningOfButtonLine(m$,m$.var("YVOR"))),2)) {
      //<< ;   write "<TABLE BORDER=0>"
      //<< write "<TABLE id=""wfsidebut"" BORDER=0>"
      m$.Cmd.Write("<TABLE id=\"wfsidebut\" BORDER=0>");
      //<< set YTABLEANZ = $get(YTABLEANZ)+1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
      //<< write "<TR><TD NOWRAP ALIGN=LEFT VALIGN=TOP BGCOLOR="_YWHITE_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TR><TD NOWRAP ALIGN=LEFT VALIGN=TOP BGCOLOR=",m$.var("YWHITE").get()),">"));
      //<< do ^WWWFORMC1   ;BUTTONS AN DER SEITE ;upon the side           ; *** EXECUTE 14 ***
      m$.Cmd.Do("WWWFORMC1.main");
      //<< write "</TD><TD ALIGN=LEFT VALIGN=TOP>"
      m$.Cmd.Write("</TD><TD ALIGN=LEFT VALIGN=TOP>");
    }
    //<< }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  7 : Search Engine
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if YFOART=7 set $$$WWW120DisplayFrames(YVOR) = $$$YES  ;IMMER FORMATIERT/RAHMEN ;constantly
    if (mOp.Equal(m$.var("YFOART").get(),7)) {
      include.WWWConst.$$$WWW120DisplayFramesSet(m$,m$.var("YVOR"),include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< set YTABX  = 100  ;TABINDEX
    mVar YTABX = m$.var("YTABX");
    YTABX.set(100);
    //<< set YZEIPO = 1    ;IST ZEILE-POSITION
    mVar YZEIPO = m$.var("YZEIPO");
    YZEIPO.set(1);
    //<< set YZEILE = 0    ;SOLL ZEILE
    mVar YZEILE = m$.var("YZEILE");
    YZEILE.set(0);
    //<< 
    //<< ;---------------------------------------   Index 6 = P1 Form Name, D80 Header Position
    //<< ;                                             Displays fields above button line so can be
    //<< ;                                             seen over multiple tabs without repeating.
    //<< ; FIXME : Note - Doesn't distinguish between forms INABC and INAbc
    //<< ; SR17065 vvvv
    //<< if $data(^WWW122(0,YFORM))                                          &&
    //<< ($order(^WWW122s(0,6,$$^WWWUMLAU(YFORM,1),""))'=" ")             &&
    //<< ((YOPTION'="") || ( (YOPTION="") && '$data(^WWW1210(0,YFORM)) ))    {  ;DATENFELDER ALS HEADER ;when
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get()))) && (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW122s",0,6,m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1),""))," ")) && mOp.Logical(((mOp.NotEqual(m$.var("YOPTION").get(),"")) || mOp.Logical(((mOp.Equal(m$.var("YOPTION").get(),"")) && mOp.Not(m$.Fnc.$data(m$.var("^WWW1210",0,m$.var("YFORM").get())))))))) {
      //<< 
      //<< do ^WWWFORMH   ;HEADER MIT DATEN ;by means of                  ; *** EXECUTE 15-20 ***
      m$.Cmd.Do("WWWFORMH.main");
    }
    //<< }
    //<< 
    //<< $$$LOGWWWBENCH(13)
    $$$LOGWWWBENCH(m$,13);
    //<< 
    //<< ;if $get(^SysSetup("FieldEvents")) && $$$DevLowPhil {
    //<< ;   if $piece($get(^WWW120(0,YFORM,1)),Y,123)=1 {
    //<< ;      write "<input type=hidden name='YEND' value=1>",!,
    //<< ;            "</form><form name='WWW2' id='WWW2'>",!
    //<< ;   }
    //<< ;}
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  1 : Standard Form
    //<< ;  4 : Manual Input (with Button)
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;IF YFOART=1||(YFOART=4) IF $DATA(^WWW122s(0,1,2,YFORM))||($DATA(^WWW1203(0,YFORM,SPRACHE,2))) IF (YOPTION'="") || ((YOPTION=""&('$DATA(^WWW1210(0,YFORM))))) DO    ;TYBD;16,12,2003; WWW1203(0,YFORM...
    //<< //  SR14286: Can't simply check for subscript "2".
    //<< if (YFOART=1) || (YFOART=4) if $data(^WWW122s(0,1,2,YFORM)) || $$DrawTabs(YFORM) if (YOPTION'="") || ( (YOPTION="") && '$data(^WWW1210(0,YFORM)) ) do    ;TYBD;16,12,2003; WWW1203(0,YFORM...
    if ((mOp.Equal(m$.var("YFOART").get(),1)) || (mOp.Equal(m$.var("YFOART").get(),4))) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,1,2,m$.var("YFORM").get()))) || mOp.Logical(m$.fnc$("DrawTabs",m$.var("YFORM").get()))) {
        if ((mOp.NotEqual(m$.var("YOPTION").get(),"")) || mOp.Logical(((mOp.Equal(m$.var("YOPTION").get(),"")) && mOp.Not(m$.Fnc.$data(m$.var("^WWW1210",0,m$.var("YFORM").get())))))) {
          //<< . if +$$$WWW120DisplayFrames(YVOR)=$$$YES do
          if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120DisplayFrames(m$,m$.var("YVOR"))),include.COMSYS.$$$YES(m$))) {
            //<< . .;write YCR,"<TABLE BORDER=0"
            //<< . . write YCR,"<TABLE id=""wffrtab"" BORDER=0"
            m$.Cmd.Write(m$.var("YCR").get(),"<TABLE id=\"wffrtab\" BORDER=0");
            //<< . . if ($$$WWW120InnerFrameSize(YVOR)=0) || ($$$WWW120InnerFrameSize(YVOR)=100) write " width=100%"
            if ((mOp.Equal(include.WWWConst.$$$WWW120InnerFrameSize(m$,m$.var("YVOR")),0)) || (mOp.Equal(include.WWWConst.$$$WWW120InnerFrameSize(m$,m$.var("YVOR")),100))) {
              m$.Cmd.Write(" width=100%");
            }
            //<< . . write " cellspacing=0><TR><TD>"  ;GERAHMT
            m$.Cmd.Write(" cellspacing=0><TR><TD>");
            //<< . . set YTABLEANZ = $get(YTABLEANZ)+1
            mVar YTABLEANZ = m$.var("YTABLEANZ");
            YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
          }
          //<< . ;
          //<< . do ^WWWFORM6  ;SEITENREITER                               ; *** EXECUTE 21 ***
          m$.Cmd.Do("WWWFORM6.main");
          //<< . write YCR
          m$.Cmd.Write(m$.var("YCR").get());
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< if YFORM="WWWBLANK" set $$$WWW120DisplayFrames(YVOR) = $$$NO
    if (mOp.Equal(m$.var("YFORM").get(),"WWWBLANK")) {
      include.WWWConst.$$$WWW120DisplayFramesSet(m$,m$.var("YVOR"),include.COMSYS.$$$NO(m$));
    }
    //<< if YFOART=3         set $$$WWW120DisplayFrames(YVOR) = $$$YES  ; always start a new table for Grid Form ;SR15619
    if (mOp.Equal(m$.var("YFOART").get(),3)) {
      include.WWWConst.$$$WWW120DisplayFramesSet(m$,m$.var("YVOR"),include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< if +$$$WWW120DisplayFrames(YVOR)=$$$YES do  ;RAHMEN INNEN ;framework
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120DisplayFrames(m$,m$.var("YVOR"))),include.COMSYS.$$$YES(m$))) {
      //<< . new YFRBR
      mVar YFRBR = m$.var("YFRBR");
      m$.newVar(YFRBR);
      //<< . set YFRBR=2
      YFRBR.set(2);
      //<< . ;SR17862 do ^WWWFRAME(YFRBR,,1)  ;INNEN FRAME OHNE % ;without      ; 0 or 2 or 3 => START^WWWFRAME opens <TABLE>  ; FIXME : add param 4 YID?
      //<< . ;SR17871 TODO
      //<< . if $$$WWW120InnerFrameSize(YVOR)'="" set YFRBR = $$$WWW120InnerFrameSize(YVOR)
      if (mOp.NotEqual(include.WWWConst.$$$WWW120InnerFrameSize(m$,m$.var("YVOR")),"")) {
        YFRBR.set(include.WWWConst.$$$WWW120InnerFrameSize(m$,m$.var("YVOR")));
      }
      //<< . if YFRBR'=0 if +YFRBR=0  set YFRBR=2
      if (mOp.NotEqual(YFRBR.get(),0)) {
        if (mOp.Equal(mOp.Positive(YFRBR.get()),0)) {
          YFRBR.set(2);
        }
      }
      //<< . do ^WWWFRAME(YFRBR,,1,,,$$$NO)  ;INNEN FRAME OHNE % ;without      ; 0 or 2 or 3 => START^WWWFRAME opens <TABLE>  ; FIXME : add param 4 YID?
      m$.Cmd.Do("WWWFRAME.main",YFRBR.get(),null,1,null,null,include.COMSYS.$$$NO(m$));
      //<< . write "<TR><TD style='vertical-align:top;'>" ;SR18182
      m$.Cmd.Write("<TR><TD style='vertical-align:top;'>");
    }
    //<< 
    //<< $$$LOGWWWBENCH(14)
    $$$LOGWWWBENCH(m$,14);
    //<< 
    //<< ;------------------------------------------------------------------------  AFTER BUTTONLINE   *** EXECUTE 22a ***
    //<< set $$$WWWUSERHTMLStarted(^WWWUSER(0,YUSER,1))=$$$YES
    include.WWWConst.$$$WWWUSERHTMLStartedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),include.COMSYS.$$$YES(m$));
    //<< set strExec = $$$WWW120ExecuteAfterButtonLine(YVOR)
    strExec.set(include.WWWConst.$$$WWW120ExecuteAfterButtonLine(m$,m$.var("YVOR")));
    //<< set blnTUnit = $$$NO
    mVar blnTUnit = m$.var("blnTUnit");
    blnTUnit.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++                    ; *** EXECUTE 22b ***
    //<< ;  5 : Manual Input (without Button)  -  On After Save Data
    //<< ;+++++++++++++++++++++++++++++++++++++++        ; SR15603 vvv
    //<< if (YFOART=5) && (strExec="") && '$data(^WWW122(0,YFORM)) {
    if ((mOp.Equal(m$.var("YFOART").get(),5)) && (mOp.Equal(strExec.get(),"")) && mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
      //<< if ($$$WWW120ExecuteOnAfterSaveData(YVOR)'="") {
      if ((mOp.NotEqual(include.WWWConst.$$$WWW120ExecuteOnAfterSaveData(m$,m$.var("YVOR")),""))) {
        //<< set strExec = $$$WWW120ExecuteOnAfterSaveData(YVOR)  ;VORGABE FELD ;default field
        strExec.set(include.WWWConst.$$$WWW120ExecuteOnAfterSaveData(m$,m$.var("YVOR")));
      }
      //<< }
      //<< if ($data(^WWWTransactionLine(0,YFORM,"ExecuteAfterSave"))) {  ;SR15947
      if (mOp.Logical((m$.Fnc.$data(m$.var("^WWWTransactionLine",0,m$.var("YFORM").get(),"ExecuteAfterSave"))))) {
        //<< set blnTUnit = $$$YES
        blnTUnit.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< ;IF (strExec'="") || ($$EXIST^%R("Y"_YFORM_"onPageStart.OBJ",$get(YUCI))) DO
    //<< if (strExec'="") || (blnTUnit=$$$YES) || ($$EXIST^%R("Y"_YFORM_"onPageStart.OBJ",$get(YUCI))) do  ;SR15947
    if ((mOp.NotEqual(strExec.get(),"")) || (mOp.Equal(blnTUnit.get(),include.COMSYS.$$$YES(m$))) || mOp.Logical((m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"onPageStart.OBJ"),m$.Fnc.$get(m$.var("YUCI")))))) {
      do {
        //<< . if ($$$WWW120FontFace(YVOR)="") || ($$$WWW120PreFormatted(YVOR)=$$$YES) write "<PRE>"
        if ((mOp.Equal(include.WWWConst.$$$WWW120FontFace(m$,m$.var("YVOR")),"")) || (mOp.Equal(include.WWWConst.$$$WWW120PreFormatted(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$)))) {
          m$.Cmd.Write("<PRE>");
        }
        //<< . $$$jsMarker("After Save or After Button Line :"_strExec)
        $$$jsMarker(m$,mOp.Concat("After Save or After Button Line :",strExec.get()));
        //<< . if $extract(strExec)="#" set strExec = $extract(strExec,2,999)
        if (mOp.Equal(m$.Fnc.$extract(strExec.get()),"#")) {
          strExec.set(m$.Fnc.$extract(strExec.get(),2,999));
        }
        //<< . ;
        //<< . ; FIXME : <GRF> Should we NOT perform onPageStart routine if
        //<< . ;               the ExecuteAfterSavingData starts with "*"? (What does "*" mean here anyway?)
        //<< . ;               Will also leave opening <PRE> without a closing </PRE>
        //<< . if $extract(strExec)="*" quit                                       ;FIS;27442;03.03.05
        if (mOp.Equal(m$.Fnc.$extract(strExec.get()),"*")) {
          break;
        }
        //<< . if strExec'="" xecute strExec                                       ;EXECUTE VOR FORMULAR ;EXECUTE pre- form
        if (mOp.NotEqual(strExec.get(),"")) {
          m$.Cmd.Xecute(strExec.get());
        }
        //<< . ;
        //<< . if blnTUnit=$$$YES set strTStatus = $$TransactionUnit^COMTransaction(YFORM,"ExecuteAfterSave")  ;SR15947
        if (mOp.Equal(blnTUnit.get(),include.COMSYS.$$$YES(m$))) {
          mVar strTStatus = m$.var("strTStatus");
          strTStatus.set(m$.fnc$("COMTransaction.TransactionUnit",m$.var("YFORM").get(),"ExecuteAfterSave"));
        }
        //<< . ;
        //<< . ;   *** EXECUTE 23 ***
        //<< . ;
        //<< . if $$EXIST^%R("Y"_YFORM_"onPageStart.OBJ",$get(YUCI)) xecute "DO ^Y"_YFORM_"onPageStart"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
        if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"onPageStart.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
          m$.Cmd.Xecute(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),"onPageStart"));
        }
        //<< . if ($$$WWW120FontFace(YVOR)="") || ($$$WWW120PreFormatted(YVOR)=$$$YES) write "</PRE>"
        if ((mOp.Equal(include.WWWConst.$$$WWW120FontFace(m$,m$.var("YVOR")),"")) || (mOp.Equal(include.WWWConst.$$$WWW120PreFormatted(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$)))) {
          m$.Cmd.Write("</PRE>");
        }
        //<< . $$$jsMarker("End After Save or After Button Line")
        $$$jsMarker(m$,"End After Save or After Button Line");
      } while (false);
    }
    //<< 
    //<< if YUSER'="" if +$$$WWWUSERHTMLStarted(^WWWUSER(0,YUSER,1))=$$$NO quit  ; ***   EARLY EXIT   ***   ; STOP DURCH SONDERPROGRAMM ;SR15509
    if (mOp.NotEqual(m$.var("YUSER").get(),"")) {
      if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWWUSERHTMLStarted(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1))),include.COMSYS.$$$NO(m$))) {
        return;
      }
    }
    //<< 
    //<< $$$LOGWWWBENCH(15)
    $$$LOGWWWBENCH(m$,15);
    //<< set ^CacheTempForm(YUCI,YUSER,YFORM,"YOPTION")  = $get(YOPTION)     //SR15453
    m$.var("^CacheTempForm",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"YOPTION").set(m$.Fnc.$get(m$.var("YOPTION")));
    //<< set ^CacheTempForm(YUCI,YUSER,YFORM,"YOPTION1") = $get(YOPTION1)
    m$.var("^CacheTempForm",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"YOPTION1").set(m$.Fnc.$get(m$.var("YOPTION1")));
    //<< set ^CacheTempForm(YUCI,YUSER,YFORM,"YPARA")    = $get(YPARA)  ; Can be used by the OnFilter CallBack
    m$.var("^CacheTempForm",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"YPARA").set(m$.Fnc.$get(m$.var("YPARA")));
    do {
      //<< do
      //<< . new YNUMM,objWWW1265,strURL
      mVar YNUMM = m$.var("YNUMM");
      mVar objWWW1265 = m$.var("objWWW1265");
      mVar strURL = m$.var("strURL");
      m$.newVar(YNUMM,objWWW1265,strURL);
      //<< . set YNUMM=$$^WWWNEXT("WWW1265")
      YNUMM.set(m$.fnc$("WWWNEXT.main","WWW1265"));
      //<< . set $piece(objWWW1265,Y,1)=$get(YANZ)
      m$.pieceVar(objWWW1265,m$.var("Y").get(),1).set(m$.Fnc.$get(m$.var("YANZ")));
      //<< . set $piece(objWWW1265,Y,2)=$get(YLOCKKILL)
      m$.pieceVar(objWWW1265,m$.var("Y").get(),2).set(m$.Fnc.$get(m$.var("YLOCKKILL")));
      //<< . set $piece(objWWW1265,Y,3)=$get(YNAME)
      m$.pieceVar(objWWW1265,m$.var("Y").get(),3).set(m$.Fnc.$get(m$.var("YNAME")));
      //<< . set $piece(objWWW1265,Y,4)=$get(YKEY)
      m$.pieceVar(objWWW1265,m$.var("Y").get(),4).set(m$.Fnc.$get(m$.var("YKEY")));
      //<< . set $piece(objWWW1265,Y,20)=$get(%KEY("YPARA")) ;Carefull! YPARA may have multiple pieces. YPARA variable seems to be one screen behind.
      m$.pieceVar(objWWW1265,m$.var("Y").get(),20).set(m$.Fnc.$get(m$.var("%KEY","YPARA")));
      //<< . set ^WWW1265(YM,YBED,YFORM,YNUMM,1)=objWWW1265
      m$.var("^WWW1265",m$.var("YM").get(),m$.var("YBED").get(),m$.var("YFORM").get(),YNUMM.get(),1).set(objWWW1265.get());
    } while(false);
    //<< do RUECK
    m$.Cmd.Do("RUECK");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< RUECK
  public void RUECK() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; RUECKSPRUNG AUS EXECUTE NACH BUTTONLEISTE AUS MANUELLEN PROGRAMM
    //<< ; Return to execute off button bar of manual program
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Mar-2013   shobby  HEVA-885: Removed a change from SR18182 which could fail in Firefox.
    //<< ; 16-Jun-2008   GRF     Doco only
    //<< ; 03-Aug-2007   GRF     SR15509: handle leading spaces in pieces (strSearchClass)
    //<< ; 02-May-2007   GRF     SR15509: create and call DisplayTables.
    //<< ; 05-Jan-2006   PO      SR15351: Dynamic Table hook
    //<< ; 13-Sep-2006   PO      SR14864: Changed logging
    //<< ; 11-Sep-2006   PO      SR14864: LOGGING
    //<< ; 25-Jun-2006   shobby  SRBR014072: Consider customisations when looking at tabs.
    //<< ;-------------------------------------------------------------------------------
    //<< new strSearchFunction
    mVar strSearchFunction = m$.var("strSearchFunction");
    m$.newVar(strSearchFunction);
    //<< 
    //<< $$$LogR("RUECK",$get(YFORM)_"<"_$get(YFOART))
    $$$LogR(m$,"RUECK",mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YFORM")),"<"),m$.Fnc.$get(m$.var("YFOART"))));
    //<< 
    //<< 
    //<< ; FIXME : <GRF> A problem can be seen in the HTML source for form INCALL2 where
    //<< ;               the following structures overlap.  Similar problems may exist for
    //<< ;               other forms and only be obscured by MSIE leniency.
    //<< ;
    //<< ;   FORM
    //<< ;   ...
    //<< ;
    //<< ;           FONT + CENTER                   Data Point 1 (RUECK)
    //<< ;                   TABLE + TR + TD         Data Point 2 (RUECK)
    //<< ;   /FORM                                   Data Point 3 (RUECK)
    //<< ;   FORM
    //<< ;                   /TD + /TR + /TABLE      Data Point 4 (RUECK) - possibly 3 levels
    //<< ;           /CENTER + /FONT                 Data Point 5 (RUECK)
    //<< ;                   /TD + /TR + /TABLE      Data Point 6 (STOP)
    //<< ;   /FORM                                   Data Point 7 (STOP)
    //<< ;           [  /div /TD + /TR + /TABLE ]
    //<< ;           [       /TD + /TR + /TABLE ]
    //<< 
    //<< 
    //<< ;%%%%%
    //<< ;
    //<< ; Data Point 1 <FONT><CENTRE>
    //<< ;
    //<< ;%%%%%
    //<< 
    //<< if SPRACHE="" set SPRACHE="DE"
    if (mOp.Equal(m$.var("SPRACHE").get(),"")) {
      mVar SPRACHE = m$.var("SPRACHE");
      SPRACHE.set("DE");
    }
    //<< 
    //<< $$$jsMarker("Data Point 1")
    $$$jsMarker(m$,"Data Point 1");
    //<< 
    //<< write "<FONT"
    m$.Cmd.Write("<FONT");
    //<< if $$$WWW120FontFace(YVOR)'="" write " FACE="""_$piece($get(^WWW100(0,"SCHRIFTART",SPRACHE,$$$WWW120FontFace(YVOR),1)),Y,1)_""""
    if (mOp.NotEqual(include.WWWConst.$$$WWW120FontFace(m$,m$.var("YVOR")),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" FACE=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),include.WWWConst.$$$WWW120FontFace(m$,m$.var("YVOR")),1)),m$.var("Y").get(),1)),"\""));
    }
    //<< if $$$WWW120FontSize(YVOR)'="" write " SIZE="""_$$$WWW120FontSize(YVOR)_""""
    if (mOp.NotEqual(include.WWWConst.$$$WWW120FontSize(m$,m$.var("YVOR")),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" SIZE=\"",include.WWWConst.$$$WWW120FontSize(m$,m$.var("YVOR"))),"\""));
    }
    //<< if $$$WWW120FontColor(YVOR)'=""  {
    if (mOp.NotEqual(include.WWWConst.$$$WWW120FontColor(m$,m$.var("YVOR")),"")) {
      //<< ;   IF $LENGTH($piece(YVOR,Y,6))=6 write " COLOR=""#"_$piece(YVOR,Y,6)_""""
      //<< write " COLOR="""_$piece($get(^WWW100(0,"FARBE",SPRACHE,$$$WWW120FontColor(YVOR),1)),Y,1)_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" COLOR=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),include.WWWConst.$$$WWW120FontColor(m$,m$.var("YVOR")),1)),m$.var("Y").get(),1)),"\""));
    }
    //<< }
    //<< write ">"
    m$.Cmd.Write(">");
    //<< 
    //<< $$$LOGWWWBENCH(6)
    $$$LOGWWWBENCH(m$,6);
    //<< 
    //<< if ($$$WWW120FontFace(YVOR)="") || ($$$WWW120PreFormatted(YVOR)=$$$YES) write "<PRE>"
    if ((mOp.Equal(include.WWWConst.$$$WWW120FontFace(m$,m$.var("YVOR")),"")) || (mOp.Equal(include.WWWConst.$$$WWW120PreFormatted(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$)))) {
      m$.Cmd.Write("<PRE>");
    }
    //<< if $find($$$WWW120FontStyle(YVOR),1)   write "<B>"
    if (mOp.Logical(m$.Fnc.$find(include.WWWConst.$$$WWW120FontStyle(m$,m$.var("YVOR")),1))) {
      m$.Cmd.Write("<B>");
    }
    //<< if $find($$$WWW120FontStyle(YVOR),2)   write "<U>"
    if (mOp.Logical(m$.Fnc.$find(include.WWWConst.$$$WWW120FontStyle(m$,m$.var("YVOR")),2))) {
      m$.Cmd.Write("<U>");
    }
    //<< if $find($$$WWW120FontStyle(YVOR),3)   write "<I>"
    if (mOp.Logical(m$.Fnc.$find(include.WWWConst.$$$WWW120FontStyle(m$,m$.var("YVOR")),3))) {
      m$.Cmd.Write("<I>");
    }
    //<< if $find($$$WWW120FontStyle(YVOR),4)   write "<STRIKE>"
    if (mOp.Logical(m$.Fnc.$find(include.WWWConst.$$$WWW120FontStyle(m$,m$.var("YVOR")),4))) {
      m$.Cmd.Write("<STRIKE>");
    }
    //<< if $find($$$WWW120FontStyle(YVOR),5)   write "<BLINK>"
    if (mOp.Logical(m$.Fnc.$find(include.WWWConst.$$$WWW120FontStyle(m$,m$.var("YVOR")),5))) {
      m$.Cmd.Write("<BLINK>");
    }
    //<< if $$$WWW120FormCentered(YVOR)=$$$YES  write "<CENTER>"
    if (mOp.Equal(include.WWWConst.$$$WWW120FormCentered(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$))) {
      m$.Cmd.Write("<CENTER>");
    }
    //<< 
    //<< 
    //<< 
    //<< 
    //<< ;%%%%%
    //<< ;
    //<< ; Data Point 2 <TABLE><TR><TD>
    //<< ; This is the wrapper table around the Keys and Data Fields of a single tab page for a form.
    //<< ;
    //<< ;%%%%%
    //<< 
    //<< if (YFOART'=3) && (YFOART'=6) {    ; Not (old) Grid and not Menu
    if ((mOp.NotEqual(m$.var("YFOART").get(),3)) && (mOp.NotEqual(m$.var("YFOART").get(),6))) {
      //<< $$$jsMarker("Data Point 2")
      $$$jsMarker(m$,"Data Point 2");
      //<< 
      //<< ;   write YCR,"<TABLE cellspacing=0 BORDER=0>"
      //<< write YCR,"<TABLE id=""wfdp2"" cellspacing=0 BORDER=0>"
      m$.Cmd.Write(m$.var("YCR").get(),"<TABLE id=\"wfdp2\" cellspacing=0 BORDER=0>");
      //<< set YTABLEANZ = $get(YTABLEANZ)+1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
      //<< write "<TR><TD>"                    ;Immer tr und td für mozilla;TYBD;26,7,2004;26159;
      m$.Cmd.Write("<TR><TD>");
    }
    //<< }
    //<< 
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< set YSPALTE = 1  ;FORMULARSPALTE
    mVar YSPALTE = m$.var("YSPALTE");
    YSPALTE.set(1);
    //<< set YHIDDSE = 0  ;HIDDEN MERKER FÜR SEITENWEISE VORGANG  ;to
    mVar YHIDDSE = m$.var("YHIDDSE");
    YHIDDSE.set(0);
    //<< set YZEIPO  = 1  ;IST ZEILE-POSITION
    mVar YZEIPO = m$.var("YZEIPO");
    YZEIPO.set(1);
    //<< set YZEILE  = 0  ;SOLL ZEILE
    mVar YZEILE = m$.var("YZEILE");
    YZEILE.set(0);
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  8 : WIZARD                  HELP^WWWFORMW includes </TABLE>
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if YFOART=8 do ^WWWFORMW if +$$$WWW120PositioningOfButtonLine(YVOR)'=0 do ^WWWFORM1
    if (mOp.Equal(m$.var("YFOART").get(),8)) {
      m$.Cmd.Do("WWWFORMW.main");
      if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW120PositioningOfButtonLine(m$,m$.var("YVOR"))),0)) {
        m$.Cmd.Do("WWWFORM1.main");
      }
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< ; Option List Class  (e.g. INReq : Edit/Cancel/Reject/...)
    //<< ;---------------------------------------
    //<< if (YOPTION="") && $data(^WWW1210(0,YFORM)) do
    if ((mOp.Equal(m$.var("YOPTION").get(),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^WWW1210",0,m$.var("YFORM").get())))) {
      //<< . new YHTMFORM
      mVar YHTMFORM = m$.var("YHTMFORM");
      m$.newVar(YHTMFORM);
      //<< . set YHTMFORM="WWW"
      YHTMFORM.set("WWW");
      //<< . do ^WWWFORMO
      m$.Cmd.Do("WWWFORMO.main");
    }
    //<< 
    //<< 
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;%%%%%
    //<< ;
    //<< ; Data Point 3 </FORM><FORM>
    //<< ;
    //<< ;%%%%%
    //<< if YHTMFORM="WWW2" {  ;FAST SAVE ;next
    if (mOp.Equal(m$.var("YHTMFORM").get(),"WWW2")) {
      //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YEND"" VALUE=1>",YCR  ;ENDE WENN OK ;termination when     ; FIXME : Also in Data Point 4
      m$.Cmd.Write(m$.var("YCR").get(),"<INPUT TYPE=HIDDEN NAME=\"YEND\" VALUE=1>",m$.var("YCR").get());
      //<< write "</FORM>",YCR
      m$.Cmd.Write("</FORM>",m$.var("YCR").get());
      //<< 
      //<< $$$jsMarker("Data Point 3")
      $$$jsMarker(m$,"Data Point 3");
      //<< ;HEVA-885if ((YFORM="MEDPrescriptionHosp")||(YFORM="MEDPrescriptionSol"))&&(YSEITE=1) {
      //<< ;HEVA-885   write "<DIV NAME="""_YHTMFORM_""" id="""_YHTMFORM_""">",YCR
      //<< ;HEVA-885} else {
      //<< write "<FORM NAME="""_YHTMFORM_""" id="""_YHTMFORM_""">",YCR
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FORM NAME=\"",m$.var("YHTMFORM").get()),"\" id=\""),m$.var("YHTMFORM").get()),"\">"),m$.var("YCR").get());
    }
    //<< ;HEVA-885}
    //<< }
    //<< 
    //<< ;FELD FÜR COMBO-BOXEN;FIS;05.01.04 ;field to
    //<< write YCR,"<input name=""COMBO"_YFORM_""" type=""hidden"" value=""""/>"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<input name=\"COMBO",m$.var("YFORM").get()),"\" type=\"hidden\" value=\"\"/>"));
    //<< 
    //<< // FORM - Main form - keys and fields.
    //<< 
    //<< $$$LOGWWWBENCH(7)
    $$$LOGWWWBENCH(m$,7);
    //<< 
    //<< if (YOPTION'="") || ((YOPTION="") && '$data(^WWW1210(0,YFORM))) {
    if ((mOp.NotEqual(m$.var("YOPTION").get(),"")) || mOp.Logical(((mOp.Equal(m$.var("YOPTION").get(),"")) && mOp.Not(m$.Fnc.$data(m$.var("^WWW1210",0,m$.var("YFORM").get())))))) {
      //<< ;
      //<< ;   *** EXECUTE ? ***
      //<< ;
      //<< set strExec = $$$WWW120ExecuteAfterPrimaryKey(YVOR)
      mVar strExec = m$.var("strExec");
      strExec.set(include.WWWConst.$$$WWW120ExecuteAfterPrimaryKey(m$,m$.var("YVOR")));
      //<< if (YFOART=1) || (YFOART=3) {
      if ((mOp.Equal(m$.var("YFOART").get(),1)) || (mOp.Equal(m$.var("YFOART").get(),3))) {
        //<< if $data(^WWW121(0,YFORM)) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YFORM").get())))) {
          //<< $$$LOGWWWBENCH(7.1)
          $$$LOGWWWBENCH(m$,7.1);
          //<< do ^WWWFORMP                      ;PRIMÄRSCHLÜSSEL
          m$.Cmd.Do("WWWFORMP.main");
          //<< $$$LOGWWWBENCH(7.2)
          $$$LOGWWWBENCH(m$,7.2);
        }
        //<< }
        //<< //  if ((strExec'="") && '$find(strExec,",,,") && ($get(YTIMEFORM)'=1) {  ;SR15947
        //<< if ( $data(^WWWTransactionLine(0,YFORM,"ExecuteAfterPrimaryKey")) || ((strExec'="") && '$find(strExec,",,,")) ) && ($get(YTIMEFORM)'=1) {
        if ((mOp.Logical(m$.Fnc.$data(m$.var("^WWWTransactionLine",0,m$.var("YFORM").get(),"ExecuteAfterPrimaryKey"))) || mOp.Logical(((mOp.NotEqual(strExec.get(),"")) && mOp.Not(m$.Fnc.$find(strExec.get(),",,,"))))) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YTIMEFORM")),1))) {
          //<< $$$LOGWWWBENCH(7.3)
          $$$LOGWWWBENCH(m$,7.3);
          //<< xecute strExec                    ;EXE NACH KEY ;within KEY
          m$.Cmd.Xecute(strExec.get());
          //<< set strTStatus = $$TransactionUnit^COMTransaction(YFORM,"ExecuteAfterPrimaryKey")  ;SR15947
          mVar strTStatus = m$.var("strTStatus");
          strTStatus.set(m$.fnc$("COMTransaction.TransactionUnit",m$.var("YFORM").get(),"ExecuteAfterPrimaryKey"));
          //<< $$$LOGWWWBENCH(7.4)
          $$$LOGWWWBENCH(m$,7.4);
        }
      }
      //<< }
      //<< }
      //<< 
      //<< set YZEIPO=0 ;ZEILE-POSITION
      YZEIPO.set(0);
      //<< 
      //<< //IF (YFOART=5) && ($LENGTH($translate(strExec," ,-.|"))>3) {  ;SR15947
      //<< if (YFOART=5) && (($length($translate(strExec," ,-.|"))>3) || $data(^WWWTransactionLine(0,YFORM,"ExecuteAfterPrimaryKey"))) {
      if ((mOp.Equal(m$.var("YFOART").get(),5)) && mOp.Logical(((mOp.Greater(m$.Fnc.$length(m$.Fnc.$translate(strExec.get()," ,-.|")),3)) || mOp.Logical(m$.Fnc.$data(m$.var("^WWWTransactionLine",0,m$.var("YFORM").get(),"ExecuteAfterPrimaryKey")))))) {
        //<< $$$LOGWWWBENCH(7.5)
        $$$LOGWWWBENCH(m$,7.5);
        //<< xecute strExec                      ;EXECUTE NACH KEY WENN OHNE BUTTON ;EXECUTE within KEY when without
        m$.Cmd.Xecute(strExec.get());
        //<< set strTStatus = $$TransactionUnit^COMTransaction(YFORM,"ExecuteAfterPrimaryKey")  ;SR15947
        mVar strTStatus = m$.var("strTStatus");
        strTStatus.set(m$.fnc$("COMTransaction.TransactionUnit",m$.var("YFORM").get(),"ExecuteAfterPrimaryKey"));
        //<< $$$LOGWWWBENCH(7.6)
        $$$LOGWWWBENCH(m$,7.6);
      }
      //<< }
      //<< 
      //<< if (YFOART'=6) && (YFOART'=8) {
      if ((mOp.NotEqual(m$.var("YFOART").get(),6)) && (mOp.NotEqual(m$.var("YFOART").get(),8))) {
        //<< $$$LOGWWWBENCH(7.7)
        $$$LOGWWWBENCH(m$,7.7);
        //<< do ^WWWFORMD                        ; Manual and Data Fields
        m$.Cmd.Do("WWWFORMD.main");
        //<< $$$LOGWWWBENCH(7.8)
        $$$LOGWWWBENCH(m$,7.8);
      }
      //<< }
      //<< 
      //<< if (YFOART=2) {
      if ((mOp.Equal(m$.var("YFOART").get(),2))) {
        //<< $$$LOGWWWBENCH(7.9)
        $$$LOGWWWBENCH(m$,7.9);
        //<< do ^WWWFORML                        ; LISTGENERATOR
        m$.Cmd.Do("WWWFORML.main");
        //<< $$$LOGWWWBENCH(7.10)
        $$$LOGWWWBENCH(m$,7.10);
      }
      //<< }
      //<< 
      //<< //IF YFOART=4 && ($translate(strExec," ")'="") {
      //<< if (YFOART=4) && (($translate(strExec," ")'="") || $data(^WWWTransactionLine(0,YFORM,"ExecuteAfterPrimaryKey"))) {  ;SR15947
      if ((mOp.Equal(m$.var("YFOART").get(),4)) && mOp.Logical(((mOp.NotEqual(m$.Fnc.$translate(strExec.get()," "),"")) || mOp.Logical(m$.Fnc.$data(m$.var("^WWWTransactionLine",0,m$.var("YFORM").get(),"ExecuteAfterPrimaryKey")))))) {
        //<< $$$LOGWWWBENCH(7.11)
        $$$LOGWWWBENCH(m$,7.11);
        //<< xecute strExec                      ;EXECUTE NACH KEY WENN MIT BUTTON ;EXECUTE within KEY when by means of
        m$.Cmd.Xecute(strExec.get());
        //<< set strTStatus = $$TransactionUnit^COMTransaction(YFORM,"ExecuteAfterPrimaryKey")  ;SR15947
        mVar strTStatus = m$.var("strTStatus");
        strTStatus.set(m$.fnc$("COMTransaction.TransactionUnit",m$.var("YFORM").get(),"ExecuteAfterPrimaryKey"));
        //<< $$$LOGWWWBENCH(7.12)
        $$$LOGWWWBENCH(m$,7.12);
      }
      //<< }
      //<< 
      //<< if YFOART=6 {
      if (mOp.Equal(m$.var("YFOART").get(),6)) {
        //<< $$$LOGWWWBENCH(7.13)
        $$$LOGWWWBENCH(m$,7.13);
        //<< do ^WWWGEDT                         ;FOLDER MENU
        m$.Cmd.Do("WWWGEDT.main");
        //<< $$$LOGWWWBENCH(7.14)
        $$$LOGWWWBENCH(m$,7.14);
      }
      //<< }
      //<< 
      //<< if YFOART=7 {
      if (mOp.Equal(m$.var("YFOART").get(),7)) {
        //<< $$$LOGWWWBENCH(7.15)
        $$$LOGWWWBENCH(m$,7.15);
        //<< do ^WWWSMA                          ;SUCHMASCHINE
        m$.Cmd.Do("WWWSMA.main");
        //<< $$$LOGWWWBENCH(7.16)
        $$$LOGWWWBENCH(m$,7.16);
      }
      //<< }
      //<< 
      //<< if YFOART=9 {
      if (mOp.Equal(m$.var("YFOART").get(),9)) {
        //<< $$$LOGWWWBENCH(7.17)
        $$$LOGWWWBENCH(m$,7.17);
        //<< do ^WWWFORMBIT                      ;BITMAP SUCHFORMULAR;FIS;24502;14.04.04
        m$.Cmd.Do("WWWFORMBIT.main");
        //<< $$$LOGWWWBENCH(7.18)
        $$$LOGWWWBENCH(m$,7.18);
      }
    }
    //<< }
    //<< }
    //<< 
    //<< $$$LOGWWWBENCH(8)
    $$$LOGWWWBENCH(m$,8);
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;%%%%%
    //<< ;
    //<< ; Data Point 4 </TABLE>  -  Possibly 3 levels?
    //<< ;
    //<< ;%%%%%
    //<< 
    //<< 
    //<< if ((YFORM="MEDPrescriptionHosp")||(YFORM="MEDPrescriptionSol"))&&(YSEITE=1) goto label
    if (mOp.Logical(((mOp.Equal(m$.var("YFORM").get(),"MEDPrescriptionHosp")) || (mOp.Equal(m$.var("YFORM").get(),"MEDPrescriptionSol")))) && (mOp.Equal(m$.var("YSEITE").get(),1))) {
      m$.Cmd.Goto("label");
      return;
    }
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< if +$$$WWW120DisplayFrames(YVOR)=$$$YES {
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120DisplayFrames(m$,m$.var("YVOR"))),include.COMSYS.$$$YES(m$))) {
      //<< write "</TD></TR>"
      m$.Cmd.Write("</TD></TR>");
      //<< write "</TABLE>"  ;ENDE INNEN RAHMEN ;termination framework
      m$.Cmd.Write("</TABLE>");
      //<< set YTABLEANZ = $get(YTABLEANZ)-1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
      //<< 
      //<< $$$jsMarker("Data Point 4")
      $$$jsMarker(m$,"Data Point 4");
    }
    //<< }
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  1 : Standard Form
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< if (YFOART=1) && ($data(^WWW122s(0,1,2,YFORM)) || $data(^WWW1203(0,YFORM,SPRACHE,2))) do   ;TYBD;16,12,2003     ;SEITENREITER
    if ((mOp.Equal(m$.var("YFOART").get(),1)) && (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,1,2,m$.var("YFORM").get()))) || mOp.Logical(m$.Fnc.$data(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),2))))) {
      //<< . if +$$$WWW120DisplayFrames(YVOR)=$$$YES do
      if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120DisplayFrames(m$,m$.var("YVOR"))),include.COMSYS.$$$YES(m$))) {
        //<< . . write "</TD></TR>"
        m$.Cmd.Write("</TD></TR>");
        //<< . . do ^WWWFRAME(1)    ; => STOP^WWWFRAME </TABLE> & YTABLEANZ-1
        m$.Cmd.Do("WWWFRAME.main",1);
      }
      //<< . write YCR
      m$.Cmd.Write(m$.var("YCR").get());
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< if +$$$WWW120PositioningOfButtonLine(YVOR)=2 do   ;ENDE BUTTON AN DER LINKEN SEITE ;termination upon the side
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120PositioningOfButtonLine(m$,m$.var("YVOR"))),2)) {
      //<< . write YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . write "</TD></TR></TABLE>"
      m$.Cmd.Write("</TD></TR></TABLE>");
      //<< . set YTABLEANZ = $get(YTABLEANZ)-1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
    }
    label();
  }

  //<< label
  public void label() {
    //<< 
    //<< ; --- AFTER DATA FIELDS ---
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ; *NOT*
    //<< ;  8 : Wizard
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if (YFOART'=8) && (+$$$WWW120PositioningOfButtonLine(YVOR)=1) do ^WWWFORM1   ;BUTTONS
    if ((mOp.NotEqual(m$.var("YFOART").get(),8)) && (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120PositioningOfButtonLine(m$,m$.var("YVOR"))),1))) {
      m$.Cmd.Do("WWWFORM1.main");
    }
    //<< 
    //<< ;   *** EXECUTE ? ***
    //<< set strExec = $$$WWW120ExecuteAfterDataFields(YVOR)
    mVar strExec = m$.var("strExec");
    strExec.set(include.WWWConst.$$$WWW120ExecuteAfterDataFields(m$,m$.var("YVOR")));
    //<< 
    //<< if (YFOART'=8) && (YTIMEFORM'=1) do OnAfterDataFields^COMGridEdit31Display(YFORM,$get(YKEY),$get(YFELD)) ;SR17245
    if ((mOp.NotEqual(m$.var("YFOART").get(),8)) && (mOp.NotEqual(m$.var("YTIMEFORM").get(),1))) {
      m$.Cmd.Do("COMGridEdit31Display.OnAfterDataFields",m$.var("YFORM").get(),m$.Fnc.$get(m$.var("YKEY")),m$.Fnc.$get(m$.var("YFELD")));
    }
    //<< 
    //<< if (YFOART'=8) && ((strExec'="") || $$EXIST^%R("Y"_YFORM_"onPageEnd.OBJ",$get(YUCI)) || $data(^WWWTransactionLine(0,YFORM,"ExecuteAfterDataFields"))) do
    if ((mOp.NotEqual(m$.var("YFOART").get(),8)) && mOp.Logical(((mOp.NotEqual(strExec.get(),"")) || mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"onPageEnd.OBJ"),m$.Fnc.$get(m$.var("YUCI")))) || mOp.Logical(m$.Fnc.$data(m$.var("^WWWTransactionLine",0,m$.var("YFORM").get(),"ExecuteAfterDataFields")))))) {
      //<< . $$$jsMarker("Execute After Data Field :"_strExec)
      $$$jsMarker(m$,mOp.Concat("Execute After Data Field :",strExec.get()));
      //<< . new YSTOP                                                              ;SR18091
      mVar YSTOP = m$.var("YSTOP");
      m$.newVar(YSTOP);
      //<< . set YSTOP=0                                                            ;SR18091
      YSTOP.set(0);
      //<< . do ExecuteAfterDataFields^WWW120D(YFORM,$get(YKEY),$get(YFELD),.YSTOP) ;SR18091
      m$.Cmd.Do("WWW120D.ExecuteAfterDataFields",m$.var("YFORM").get(),m$.Fnc.$get(m$.var("YKEY")),m$.Fnc.$get(m$.var("YFELD")),YSTOP);
      //<< . if 'YSTOP do
      if (mOp.Not(YSTOP.get())) {
        //<< . . if $get(YTIMEFORM)'=1 do
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
          //<< . . . if strExec'="" xecute strExec                                ;EXE NACH DATENFELD ;within data item
          if (mOp.NotEqual(strExec.get(),"")) {
            m$.Cmd.Xecute(strExec.get());
          }
          //<< . . . set strTStatus = $$TransactionUnit^COMTransaction(YFORM,"ExecuteAfterDataFields")
          mVar strTStatus = m$.var("strTStatus");
          strTStatus.set(m$.fnc$("COMTransaction.TransactionUnit",m$.var("YFORM").get(),"ExecuteAfterDataFields"));
          //<< . . . ;
          //<< . . . ;   *** EXECUTE ? ***
          //<< . . . if $$EXIST^%R("Y"_YFORM_"onPageEnd.OBJ",$get(YUCI)) xecute "DO ^Y"_YFORM_"onPageEnd" write "<br>" ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
          if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"onPageEnd.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
            m$.Cmd.Xecute(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),"onPageEnd"));
            m$.Cmd.Write("<br>");
          }
        }
      }
      //<< . $$$jsMarker("End Execute After Data Field")
      $$$jsMarker(m$,"End Execute After Data Field");
    }
    //<< 
    //<< do DynamicTableHook(YFORM,YSEITE,YKEY) // SR15351
    m$.Cmd.Do("DynamicTableHook",m$.var("YFORM").get(),m$.var("YSEITE").get(),m$.var("YKEY").get());
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ; Search Function for Data Field       ; SUCHE NACH DATENFELDER
    //<< ;   D4      $$$WWW1203DataFieldSearchFunction()
    //<< ;               $$$WWW1203DDataFieldSearchFunction()
    //<< ;   D58     $$$WWW120DataFieldSearchFunction()
    //<< ;
    //<< ;   D7      $$$WWW124NewFormOnClick()
    //<< ;
    //<< ; Function merges Tab Customisation with Tab - if the Tab has search forms
    //<< ; defined, over-ride the form setting.
    //<< ; If Search Forms are now specified for the form, check to see if any of the
    //<< ; form's buttons link to that form and if the user does not have access to that
    //<< ; new form remove it from the Search Forms so it is not displayed.
    //<< ;
    //<< ; FIXME : <GRF> Shouldn't call function twice - combines WWW1203/WWW1203D twice.
    //<< ;               May have similar situations with WWW122
    //<< ;------------------------------------------------------------------------
    //<< ;IF YFORM'="" IF $piece($get(^WWW1203(0,YFORM,SPRACHE,+YSEITE,1)),Y,4)'="" SET $piece(YVOR,Y,58)=$piece(^(1),Y,4)  ;WENN SEITENBEZOGENE ANZEIGE  ;when Show
    //<< if YFORM'="" if $piece($$GET^WWW1203(YFORM,SPRACHE,+YSEITE),Y,4)'="" set $piece(YVOR,Y,58)=$piece($$GET^WWW1203(YFORM,SPRACHE,+YSEITE),Y,4)  ;WENN SEITENBEZOGENE ANZEIGE  ;when Show ;SRBR014072
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.fnc$("WWW1203.GET",m$.var("YFORM").get(),m$.var("SPRACHE").get(),mOp.Positive(m$.var("YSEITE").get())),m$.var("Y").get(),4),"")) {
        m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),58).set(m$.Fnc.$piece(m$.fnc$("WWW1203.GET",m$.var("YFORM").get(),m$.var("SPRACHE").get(),mOp.Positive(m$.var("YSEITE").get())),m$.var("Y").get(),4));
      }
    }
    //<< if YFORM'="" if $piece(YVOR,Y,58)'="" if $data(^WWW124(0,YFORM,SPRACHE)) do  ;FIS;31.08.04;BUTTONBERECHTIGUNG FÜR SUCHANZEIGE PRÜFEN;26349
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58),"")) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW124",0,m$.var("YFORM").get(),m$.var("SPRACHE").get())))) {
          //<< . new YNR,YA
          mVar YNR = m$.var("YNR");
          mVar YA = m$.var("YA");
          m$.newVar(YNR,YA);
          //<< . set YNR=""
          YNR.set("");
          //<< . for  set YNR = $order(^WWW124(0,YFORM,SPRACHE,YNR)) quit:YNR=""  do  quit:$piece(YVOR,Y,58)=""
          for (;true;) {
            YNR.set(m$.Fnc.$order(m$.var("^WWW124",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),YNR.get())));
            if (mOp.Equal(YNR.get(),"")) {
              break;
            }
            //<< . . set YA=$get(^WWW124(0,YFORM,SPRACHE,YNR,1))
            YA.set(m$.Fnc.$get(m$.var("^WWW124",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),YNR.get(),1)));
            //<< . . if $piece(YA,Y,7)=$piece(YVOR,Y,58) if $$^WWWACCESS($piece(YA,Y,22),$piece(YA,Y,23))'=1 set $piece(YVOR,Y,58)=""  ;KEIN ZUGANG ;no
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58))) {
              if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),22),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),23)),1)) {
                m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),58).set("");
              }
            }
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58),"")) {
              break;
            }
          }
        }
      }
    }
    //<< 
    //<< ; TODO : <GRF> The following line of code                           vvvvv
    //<< ;do DisplayTables($$$WWW120DataFieldSearchFunction(YVOR),$get(YKEY),$get(YMAXKEY))     ; SR15509
    //<< 
    //<< ; was developed to replace this block of code but not implemented   vvvvv
    //<< 
    //<< if $$$WWW120DataFieldSearchFunction(YVOR)'="" do
    if (mOp.NotEqual(include.WWWConst.$$$WWW120DataFieldSearchFunction(m$,m$.var("YVOR")),"")) {
      do {
        //<< . quit:$get(YTIMEFORM)=1  ;NICHT, WENN DATEN IN ZUKUNFT ERFASST WERDEN
        if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
          break;
        }
        //<< . if +$piece($piece(YVOR,Y,58),",",1)'=0 set:+YSEITE=0 YSEITE=1 quit:+YSEITE'=+$piece($piece(YVOR,Y,58),",",1)  set $piece(YVOR,Y,58)=$piece($piece(YVOR,Y,58),",",2,99)
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58),",",1)),0)) {
          if (mOp.Equal(mOp.Positive(m$.var("YSEITE").get()),0)) {
            m$.var("YSEITE").set(1);
          }
          if (mOp.NotEqual(mOp.Positive(m$.var("YSEITE").get()),mOp.Positive(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58),",",1)))) {
            break;
          }
          m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),58).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58),",",2,99));
        }
        //<< . new YA,YYYMAXKEY,YYYKEY,YTOOLTIP,YPRINT,strSearchClass
        mVar YA = m$.var("YA");
        mVar YYYMAXKEY = m$.var("YYYMAXKEY");
        mVar YYYKEY = m$.var("YYYKEY");
        mVar YTOOLTIP = m$.var("YTOOLTIP");
        mVar YPRINT = m$.var("YPRINT");
        mVar strSearchClass = m$.var("strSearchClass");
        m$.newVar(YA,YYYMAXKEY,YYYKEY,YTOOLTIP,YPRINT,strSearchClass);
        //<< . set YYYMAXKEY = $get(YMAXKEY)
        YYYMAXKEY.set(m$.Fnc.$get(m$.var("YMAXKEY")));
        //<< . set YYYKEY    = $get(YKEY)
        YYYKEY.set(m$.Fnc.$get(m$.var("YKEY")));
        //<< . set YTOOLTIP  = $piece($piece(YVOR,Y,58),";",2)  ;INFO FÜR ANZEIGE
        YTOOLTIP.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58),";",2));
        //<< . set YA(1)=$piece($piece(YVOR,Y,58),";",1)
        YA.var(1).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58),";",1));
        //<< . ;FOR YA=1:1 quit:$piece(YA(1),",",YA)=""  SET $piece(YVOR,Y,58)=$piece($piece(YA(1),",",YA)," ",1) DO   ; SR15509 vvv
        //<< . for YA=1:1 quit:$piece(YA(1),",",YA)=""  do
        for (YA.set(1);(true);YA.set(mOp.Add(YA.get(),1))) {
          if (mOp.Equal(m$.Fnc.$piece(YA.var(1).get(),",",YA.get()),"")) {
            break;
          }
          //<< . . set strSearchClass = $zstrip($piece(YA(1),",",YA),"<W")
          strSearchClass.set(m$.Fnc.$zstrip(m$.Fnc.$piece(YA.var(1).get(),",",YA.get()),"<W"));
          //<< . . set $piece(YVOR,Y,58) = $piece(strSearchClass," ",1)
          m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),58).set(m$.Fnc.$piece(strSearchClass.get()," ",1));
          //<< . . ;                                                                                                       SR15509 ^^^
          //<< . . new YA,YHEADONLY,YWSAVE
          mVar YHEADONLY = m$.var("YHEADONLY");
          mVar YWSAVE = m$.var("YWSAVE");
          m$.newVar(YA,YHEADONLY,YWSAVE);
          //<< . . set YMAXKEY=YYYMAXKEY
          mVar YMAXKEY = m$.var("YMAXKEY");
          YMAXKEY.set(YYYMAXKEY.get());
          //<< . . set YKEY=YYYKEY
          mVar YKEY = m$.var("YKEY");
          YKEY.set(YYYKEY.get());
          //<< . . if YFORM'=$piece(YVOR,Y,58) if +YMAXKEY'=0 if $piece(YKEY,",",YMAXKEY)="" set YHEADONLY = $$$YES   ;WENN KEIN KEY ERFASST DANN NUR HEADER; TYBD 6.2.2003
          if (mOp.NotEqual(m$.var("YFORM").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58))) {
            if (mOp.NotEqual(mOp.Positive(YMAXKEY.get()),0)) {
              if (mOp.Equal(m$.Fnc.$piece(YKEY.get(),",",YMAXKEY.get()),"")) {
                YHEADONLY.set(include.COMSYS.$$$YES(m$));
              }
            }
          }
          //<< . . do  ;PRUEFEN O ;oh
          do {
            //<< . . . new YSUCH
            mVar YSUCH = m$.var("YSUCH");
            m$.newVar(YSUCH);
            //<< . . . set YSUCH=""
            YSUCH.set("");
            //<< . . . if $data(^WWW123(0,$piece(YVOR,Y,58),1,1)) set YSUCH=$get(^WWW123(0,$piece(YVOR,Y,58),1,1))
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW123",0,m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58),1,1)))) {
              YSUCH.set(m$.Fnc.$get(m$.var("^WWW123",0,m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58),1,1)));
            }
            //<< . . . quit:YSUCH=""
            if (mOp.Equal(YSUCH.get(),"")) {
              break;
            }
            //<< . . . set YWSAVE=""
            YWSAVE.set("");
            //<< . . . if $piece(YSUCH,Y,23)=1 set YWSAVE=YFORM_Y_YKEY  ;MIT SAVE;TYBD;20,10,2003;
            if (mOp.Equal(m$.Fnc.$piece(YSUCH.get(),m$.var("Y").get(),23),1)) {
              YWSAVE.set(mOp.Concat(mOp.Concat(m$.var("YFORM").get(),m$.var("Y").get()),YKEY.get()));
            }
            //<< . . . if YFORM=$piece(YVOR,Y,58) if $piece(YSUCH,Y,3)'="" if $piece(YSUCH,Y,17)'="" do
            if (mOp.Equal(m$.var("YFORM").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58))) {
              if (mOp.NotEqual(m$.Fnc.$piece(YSUCH.get(),m$.var("Y").get(),3),"")) {
                if (mOp.NotEqual(m$.Fnc.$piece(YSUCH.get(),m$.var("Y").get(),17),"")) {
                  //<< . . . . if +YMAXKEY'=0 if $piece(YKEY,",",YMAXKEY)="" set YHEADONLY = $$$YES  ;KEINE ANZEIGE , DA KEIN KEY
                  if (mOp.NotEqual(mOp.Positive(YMAXKEY.get()),0)) {
                    if (mOp.Equal(m$.Fnc.$piece(YKEY.get(),",",YMAXKEY.get()),"")) {
                      YHEADONLY.set(include.COMSYS.$$$YES(m$));
                    }
                  }
                }
              }
            }
          } while(false);
          //<< . . ;
          //<< . . set YNOSORT=1  ;KEIN SORT / SONST ANZEIGE IN SUCHFUNKTION ;no otherwise Show within
          mVar YNOSORT = m$.var("YNOSORT");
          YNOSORT.set(1);
          //<< . . do ^WWWSUCH9                               ; *** EXECUTE (see) ***
          m$.Cmd.Do("WWWSUCH9.main");
        }
        //<< . ;
        //<< . set $piece(YVOR,Y,58) = YA(1)
        m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),58).set(YA.var(1).get());
        //<< . set YMAXKEY = YYYMAXKEY
        mVar YMAXKEY = m$.var("YMAXKEY");
        YMAXKEY.set(YYYMAXKEY.get());
        //<< . set YKEY    = YYYKEY
        mVar YKEY = m$.var("YKEY");
        YKEY.set(YYYKEY.get());
      } while (false);
    }
    //<< 
    //<< ; end block SR15509                                    ^^^^^
    //<< 
    //<< ; SR15509 ^^^
    //<< 
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;QUERY NACH DATENFELDER ;within
    //<< if $$$WWW120QueryForDataFields(YVOR)'="" do
    if (mOp.NotEqual(include.WWWConst.$$$WWW120QueryForDataFields(m$,m$.var("YVOR")),"")) {
      do {
        //<< . quit:$get(YTIMEFORM)=1  ;NICHT, WENN DATEN IN ZUKUNFT ERFASST WERDEN
        if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
          break;
        }
        //<< . if +$piece($piece(YVOR,Y,111),",",1)'=0 set:+YSEITE=0 YSEITE=1 quit:+YSEITE'=+$piece($piece(YVOR,Y,111),",",1)  set $piece(YVOR,Y,111)=$piece($piece(YVOR,Y,111),",",2,99)
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),111),",",1)),0)) {
          if (mOp.Equal(mOp.Positive(m$.var("YSEITE").get()),0)) {
            m$.var("YSEITE").set(1);
          }
          if (mOp.NotEqual(mOp.Positive(m$.var("YSEITE").get()),mOp.Positive(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),111),",",1)))) {
            break;
          }
          m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),111).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),111),",",2,99));
        }
        //<< . new YA,YYYMAXKEY,YYYKEY,YTOOLTIP,YPRINT,YCLASS,YQUERY,YPARAX,intPos,strD111
        mVar YA = m$.var("YA");
        mVar YYYMAXKEY = m$.var("YYYMAXKEY");
        mVar YYYKEY = m$.var("YYYKEY");
        mVar YTOOLTIP = m$.var("YTOOLTIP");
        mVar YPRINT = m$.var("YPRINT");
        mVar YCLASS = m$.var("YCLASS");
        mVar YQUERY = m$.var("YQUERY");
        mVar YPARAX = m$.var("YPARAX");
        mVar intPos = m$.var("intPos");
        mVar strD111 = m$.var("strD111");
        m$.newVar(YA,YYYMAXKEY,YYYKEY,YTOOLTIP,YPRINT,YCLASS,YQUERY,YPARAX,intPos,strD111);
        //<< . set YYYMAXKEY = YMAXKEY
        YYYMAXKEY.set(m$.var("YMAXKEY").get());
        //<< . set YYYKEY    = YKEY
        YYYKEY.set(m$.var("YKEY").get());
        //<< . set strD111   = $piece(YVOR,Y,111)
        strD111.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),111));
        //<< . set YCLASS    = $piece(strD111,",",1)
        YCLASS.set(m$.Fnc.$piece(strD111.get(),",",1));
        //<< . set YQUERY    = $piece(strD111,",",2)
        YQUERY.set(m$.Fnc.$piece(strD111.get(),",",2));
        //<< . set YPARAX    = $piece(strD111,",",3,999)
        YPARAX.set(m$.Fnc.$piece(strD111.get(),",",3,999));
        //<< . set intPos    = $find($zconvert(strD111,"U"),"SELECT")
        intPos.set(m$.Fnc.$find(m$.Fnc.$zconvert(strD111.get(),"U"),"SELECT"));
        //<< . if 'intPos quit:(YCLASS="")||(YQUERY="")                  ;KEIN QUERY ;no
        if (mOp.Not(intPos.get())) {
          if ((mOp.Equal(YCLASS.get(),"")) || (mOp.Equal(YQUERY.get(),""))) {
            break;
          }
        }
        //<< . if intPos  set YQUERY = $translate($piece(YVOR,Y,111),"|"," ") set YCLASS="",YPARAX=""  ;MANUELLES QUERY
        if (mOp.Logical(intPos.get())) {
          YQUERY.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),111),"|"," "));
          YCLASS.set("");
          YPARAX.set("");
        }
        //<< . do ^WWWQUERY(YCLASS,YQUERY,YPARAX)                        ;QUERY STARTEN ;launching
        m$.Cmd.Do("WWWQUERY.main",YCLASS.get(),YQUERY.get(),YPARAX.get());
        //<< . ;
        //<< . set YMAXKEY = YYYMAXKEY
        mVar YMAXKEY = m$.var("YMAXKEY");
        YMAXKEY.set(YYYMAXKEY.get());
        //<< . set YKEY    = YYYKEY
        mVar YKEY = m$.var("YKEY");
        YKEY.set(YYYKEY.get());
      } while (false);
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  7 : Search Engine       ;SUCHMASCHINE
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if YFOART=7 do
    if (mOp.Equal(m$.var("YFOART").get(),7)) {
      //<< . do SUCH^WWWSMA
      m$.Cmd.Do("WWWSMA.SUCH");
      //<< . ;SONDERPROGRAMM AUFRUF NACH SUCHMASCHINE WUNSCH WACH;TYBD;26,11,2003
      //<< . ;
      //<< . ;   *** EXECUTE ? ***
      //<< . if $$EXIST^%R("Y"_YFORM_".OBJ",$get(YUCI)) xecute "DO ^Y"_YFORM      ;Bec;05.12.03;24774;CHECK IF COMPLED ROUTINE EXIST.
      if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),".OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
        m$.Cmd.Xecute(mOp.Concat("DO ^Y",m$.var("YFORM").get()));
      }
      //<< . ;
      //<< . ;   *** EXECUTE ? ***
      //<< . if $$EXIST^%R("Y"_YFORM_"onSearch.OBJ",$get(YUCI)) xecute "DO ^Y"_YFORM_"onSearch"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
      if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"onSearch.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),"onSearch"));
      }
    }
    //<< 
    //<< $$$jsMarker("Final Format")
    $$$jsMarker(m$,"Final Format");
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  3 : Grid Form
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< 
    //<< 
    //<< ;%%%%%
    //<< ;
    //<< ; Data Point 5 </CENTER></FONT>
    //<< ;
    //<< ;%%%%%
    //<< if ($$$WWW120FormCentered(YVOR)=$$$YES) || (YFOART=3) write YCR,"</CENTER>"
    if ((mOp.Equal(include.WWWConst.$$$WWW120FormCentered(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$))) || (mOp.Equal(m$.var("YFOART").get(),3))) {
      m$.Cmd.Write(m$.var("YCR").get(),"</CENTER>");
    }
    //<< if $find($$$WWW120FontStyle(YVOR),5) write "</BLINK>"
    if (mOp.Logical(m$.Fnc.$find(include.WWWConst.$$$WWW120FontStyle(m$,m$.var("YVOR")),5))) {
      m$.Cmd.Write("</BLINK>");
    }
    //<< if $find($$$WWW120FontStyle(YVOR),4) write "</STRIKE>"
    if (mOp.Logical(m$.Fnc.$find(include.WWWConst.$$$WWW120FontStyle(m$,m$.var("YVOR")),4))) {
      m$.Cmd.Write("</STRIKE>");
    }
    //<< if $find($$$WWW120FontStyle(YVOR),3) write "</I>"
    if (mOp.Logical(m$.Fnc.$find(include.WWWConst.$$$WWW120FontStyle(m$,m$.var("YVOR")),3))) {
      m$.Cmd.Write("</I>");
    }
    //<< if $find($$$WWW120FontStyle(YVOR),2) write "</U>"
    if (mOp.Logical(m$.Fnc.$find(include.WWWConst.$$$WWW120FontStyle(m$,m$.var("YVOR")),2))) {
      m$.Cmd.Write("</U>");
    }
    //<< if $find($$$WWW120FontStyle(YVOR),1) write "</B>"
    if (mOp.Logical(m$.Fnc.$find(include.WWWConst.$$$WWW120FontStyle(m$,m$.var("YVOR")),1))) {
      m$.Cmd.Write("</B>");
    }
    //<< if ($$$WWW120FontFace(YVOR)="") || ($$$WWW120PreFormatted(YVOR)=1) write "</PRE>"
    if ((mOp.Equal(include.WWWConst.$$$WWW120FontFace(m$,m$.var("YVOR")),"")) || (mOp.Equal(include.WWWConst.$$$WWW120PreFormatted(m$,m$.var("YVOR")),1))) {
      m$.Cmd.Write("</PRE>");
    }
    //<< 
    //<< if ((YFORM'="MEDPrescriptionHosp")&&(YFORM'="MEDPrescriptionSol"))||(YSEITE'=1) {           ;SR18182
    if (mOp.Logical(((mOp.NotEqual(m$.var("YFORM").get(),"MEDPrescriptionHosp")) && (mOp.NotEqual(m$.var("YFORM").get(),"MEDPrescriptionSol")))) || (mOp.NotEqual(m$.var("YSEITE").get(),1))) {
      //<< write "</FONT>",YCR
      m$.Cmd.Write("</FONT>",m$.var("YCR").get());
    }
    //<< }                                                           ;SR18182
    //<< 
    //<< $$$jsMarker("Data Point 5")
    $$$jsMarker(m$,"Data Point 5");
    //<< write "<INPUT TYPE=HIDDEN NAME=""YEND"" VALUE=1>"  ;ENDE WENN OK ;termination when     ; FIXME : Also in Data Point 3
    m$.Cmd.Write("<INPUT TYPE=HIDDEN NAME=\"YEND\" VALUE=1>");
    //<< 
    //<< if $$$WWW120FormInformation(YVOR)'="" write YCR,"<FONT SIZE=2><B>",$$$WWW120FormInformation(YVOR),"</B></FONT>"
    if (mOp.NotEqual(include.WWWConst.$$$WWW120FormInformation(m$,m$.var("YVOR")),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=2><B>",include.WWWConst.$$$WWW120FormInformation(m$,m$.var("YVOR")),"</B></FONT>");
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  4 : Manual Input (with Button)
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if YFOART=4 {
    if (mOp.Equal(m$.var("YFOART").get(),4)) {
      //<< write YCR,"</TD></TR></TABLE>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
      //<< set YTABLEANZ=$get(YTABLEANZ)+1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
    }
    //<< }
    //<< if (YSEITE=1) {                                                 ;SR18183
    if ((mOp.Equal(m$.var("YSEITE").get(),1))) {
      //<< if (YFORM="MEDPrescriptionHosp") {
      if ((mOp.Equal(m$.var("YFORM").get(),"MEDPrescriptionHosp"))) {
        //<< write "</DIV></TD></TR></TBODY></TABLE></FONT></TD>"    ;SR18182
        m$.Cmd.Write("</DIV></TD></TR></TBODY></TABLE></FONT></TD>");
        //<< set YTABLEANZ=$get(YTABLEANZ)+1                         ;SR18182
        mVar YTABLEANZ = m$.var("YTABLEANZ");
        YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
        //<< write "<TD style='vertical-align:top;'>"                ;SR18182
        m$.Cmd.Write("<TD style='vertical-align:top;'>");
        //<< do OnAfterDataFields1^MEDPrescriptionHosp(YMFELD)       ;SR18182
        m$.Cmd.Do("MEDPrescriptionHosp.OnAfterDataFields1",m$.var("YMFELD").get());
        //<< write "</TD>"                                           ;SR18182
        m$.Cmd.Write("</TD>");
      }
      //<< } elseif (YFORM="MEDPrescriptionSol") {                     ;SR18182
      else if ((mOp.Equal(m$.var("YFORM").get(),"MEDPrescriptionSol"))) {
        //<< write "</DIV></TD></TR></TBODY></TABLE></FONT></TD>"    ;SR18183
        m$.Cmd.Write("</DIV></TD></TR></TBODY></TABLE></FONT></TD>");
        //<< set YTABLEANZ=$get(YTABLEANZ)+1                         ;SR18183
        mVar YTABLEANZ = m$.var("YTABLEANZ");
        YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
        //<< write "<TD style='vertical-align:top;'>"                ;SR18183
        m$.Cmd.Write("<TD style='vertical-align:top;'>");
        //<< do OnAfterDataFields1^MEDPrescriptionSol(YKEY,YFELD)    ;SR18183
        m$.Cmd.Do("MEDPrescriptionSol.OnAfterDataFields1",m$.var("YKEY").get(),m$.var("YFELD").get());
        //<< write "</TD>"                                           ;SR18183
        m$.Cmd.Write("</TD>");
      }
    }
    //<< }                                                           ;SR18182
    //<< }
    //<< $$$LOGWWWBENCH(9)
    $$$LOGWWWBENCH(m$,9);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ;  NOT IMPLEMENTED - Brace version of dot syntax code in RUECK
  //<< ;-------------------------------------------------------------------------------
  //<< DisplayTables(pstrTableInfo,pidKEY,pidMAXKEY) private
  public Object DisplayTables(Object ... _p) {
    mVar pstrTableInfo = m$.newVarRef("pstrTableInfo",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKEY = m$.newVarRef("pidKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidMAXKEY = m$.newVarRef("pidMAXKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display table of data below form
    //<< ;
    //<< ; [Tab#,]Form[,Form...][;ToolTip]
    //<< ;
    //<< ; 1.  If initial characters are numeric - assumed to be Tab# followed by comma and data.
    //<< ;   a.  Tab# present :
    //<< ;         If current tab doesn't match Tab# in this case, table is not displayed.
    //<< ;         If current tab does match Tab#, Tab# is stripped from string.
    //<< ;   b.  Tab# not present, Continue
    //<< ; 2.  Extract each form to be displayed in turn
    //<< ; 3.  Check if all keys have data
    //<< ;   a.  If not, flag to only show header
    //<< ;
    //<< ; ByRef :
    //<< ;   YSEITE      Current Tab Number
    //<< ;   YTIMEFORM
    //<< ;
    //<< ; History:
    //<< ; 02-May-2007   GRF     SR15509: Extracted from RUECK to fix subscript error
    //<< ;                           with brace format and variable cleanup.
    //<< ;-------------------------------------------------------------------------------
    //<< new idForm,idTabNo,loop,objSearch,strFormList,YHEADONLY,YKEY,YMAXKEY,YPRINT,YTOOLTIP,YWSAVE,YNOSORT
    mVar idForm = m$.var("idForm");
    mVar idTabNo = m$.var("idTabNo");
    mVar loop = m$.var("loop");
    mVar objSearch = m$.var("objSearch");
    mVar strFormList = m$.var("strFormList");
    mVar YHEADONLY = m$.var("YHEADONLY");
    mVar YKEY = m$.var("YKEY");
    mVar YMAXKEY = m$.var("YMAXKEY");
    mVar YPRINT = m$.var("YPRINT");
    mVar YTOOLTIP = m$.var("YTOOLTIP");
    mVar YWSAVE = m$.var("YWSAVE");
    mVar YNOSORT = m$.var("YNOSORT");
    m$.newVar(idForm,idTabNo,loop,objSearch,strFormList,YHEADONLY,YKEY,YMAXKEY,YPRINT,YTOOLTIP,YWSAVE,YNOSORT);
    //<< 
    //<< quit:pstrTableInfo=""
    if (mOp.Equal(pstrTableInfo.get(),"")) {
      return null;
    }
    //<< quit:$get(YTIMEFORM)=1                   ;NICHT, WENN DATEN IN ZUKUNFT ERFASST WERDEN
    if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
      return null;
    }
    //<< 
    //<< set:+$get(YSEITE)=0 YSEITE=1
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YSEITE"))),0)) {
      m$.var("YSEITE").set(1);
    }
    //<< set idTabNo = +pstrTableInfo
    idTabNo.set(mOp.Positive(pstrTableInfo.get()));
    //<< if idTabNo {
    if (mOp.Logical(idTabNo.get())) {
      //<< set pstrTableInfo = $piece(pstrTableInfo,",",2,99)
      pstrTableInfo.set(m$.Fnc.$piece(pstrTableInfo.get(),",",2,99));
    }
    //<< }
    //<< 
    //<< if (idTabNo=0) || (YSEITE=idTabNo) {
    if ((mOp.Equal(idTabNo.get(),0)) || (mOp.Equal(m$.var("YSEITE").get(),idTabNo.get()))) {
      //<< set YTOOLTIP    = $piece(pstrTableInfo,";",2)  ;INFO FÜR ANZEIGE
      YTOOLTIP.set(m$.Fnc.$piece(pstrTableInfo.get(),";",2));
      //<< set strFormList = $piece(pstrTableInfo,";",1)
      strFormList.set(m$.Fnc.$piece(pstrTableInfo.get(),";",1));
      //<< for loop=1:1:$length(strFormList,$$$COMMA) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strFormList.get(),include.COMSYSString.$$$COMMA(m$))));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idForm = $piece(strFormList,$$$COMMA,loop)
        idForm.set(m$.Fnc.$piece(strFormList.get(),include.COMSYSString.$$$COMMA(m$),loop.get()));
        //<< set idForm = $piece(idForm," ",1)                    ; ignore anything after a space
        idForm.set(m$.Fnc.$piece(idForm.get()," ",1));
        //<< 
        //<< if idForm'="" {
        if (mOp.NotEqual(idForm.get(),"")) {
          //<< set YKEY      = pidKEY
          YKEY.set(pidKEY.get());
          //<< set YMAXKEY   = pidMAXKEY
          YMAXKEY.set(pidMAXKEY.get());
          //<< set YHEADONLY = $$$NO
          YHEADONLY.set(include.COMSYS.$$$NO(m$));
          //<< if YFORM'=idForm {
          if (mOp.NotEqual(m$.var("YFORM").get(),idForm.get())) {
            //<< if (+YMAXKEY'=0) && ($piece(YKEY,",",YMAXKEY)="") set YHEADONLY = $$$YES
            if ((mOp.NotEqual(mOp.Positive(YMAXKEY.get()),0)) && (mOp.Equal(m$.Fnc.$piece(YKEY.get(),",",YMAXKEY.get()),""))) {
              YHEADONLY.set(include.COMSYS.$$$YES(m$));
            }
          }
          //<< }
          //<< set objSearch=$get(^WWW123(0,idForm,1,1))
          objSearch.set(m$.Fnc.$get(m$.var("^WWW123",0,idForm.get(),1,1)));
          //<< if objSearch'="" {
          if (mOp.NotEqual(objSearch.get(),"")) {
            //<< set YWSAVE=""
            YWSAVE.set("");
            //<< if $piece(objSearch,Y,23)=$$$YES set YWSAVE = YFORM_Y_YKEY    ; With Automatic Storing
            if (mOp.Equal(m$.Fnc.$piece(objSearch.get(),m$.var("Y").get(),23),include.COMSYS.$$$YES(m$))) {
              YWSAVE.set(mOp.Concat(mOp.Concat(m$.var("YFORM").get(),m$.var("Y").get()),YKEY.get()));
            }
            //<< ;  3 : Fixed Index Key
            //<< ; 17 : Fixed Specification For Sort Keys
            //<< if (YFORM=idForm) && ($piece(objSearch,Y,3)'="") && ($piece(objSearch,Y,17)'="") {
            if ((mOp.Equal(m$.var("YFORM").get(),idForm.get())) && (mOp.NotEqual(m$.Fnc.$piece(objSearch.get(),m$.var("Y").get(),3),"")) && (mOp.NotEqual(m$.Fnc.$piece(objSearch.get(),m$.var("Y").get(),17),""))) {
              //<< if (+YMAXKEY'=0) && ($piece(YKEY,",",YMAXKEY)="") set YHEADONLY = $$$YES
              if ((mOp.NotEqual(mOp.Positive(YMAXKEY.get()),0)) && (mOp.Equal(m$.Fnc.$piece(YKEY.get(),",",YMAXKEY.get()),""))) {
                YHEADONLY.set(include.COMSYS.$$$YES(m$));
              }
            }
          }
          //<< }
          //<< }
          //<< set YNOSORT = $$$YES
          YNOSORT.set(include.COMSYS.$$$YES(m$));
          //<< set $piece(YVOR,Y,58) = idForm             ; required for ^WWWSUCH9
          m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),58).set(idForm.get());
          //<< do ^WWWSUCH9                               ; *** EXECUTE ***
          m$.Cmd.Do("WWWSUCH9.main");
        }
      }
    }
    //<< ;           ByRef ? YFORM, YVOR, YTOOLTIP, YHEADONLY, YWSAVE, YNOSORT, [YKEY, YMAXKEY]
    //<< }
    //<< }
    //<< ;   set $piece(YVOR,Y,58) = strFormList
    //<< ;   set YMAXKEY=YYYMAXKEY
    //<< ;   set YKEY=YYYKEY
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< STOP
  public void STOP() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   ENDE FORM (ACHTUNG EINSPRUNG) ;termination shape
    //<< ;
    //<< ; History:
    //<< ; 03-May-2010   GRF     -: Old comment cleanup; dots to braces
    //<< ; 09-Dec-2005   JW      SR13195: Use IsNewRecord to determine.
    //<< ; 07-Jul-2005   shobby  SR12892: WWW1261 is no longer shared.
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< $$$LogR("STOP",$get(YFORM))
    $$$LogR(m$,"STOP",m$.Fnc.$get(m$.var("YFORM")));
    //<< 
    //<< ;%%%%%
    //<< ;
    //<< ; Data Point 6 </TD></TR></TABLE>
    //<< ;
    //<< ;%%%%%
    //<< if $get(YFIXHEADER)'=$$$YES {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFIXHEADER")),include.COMSYS.$$$YES(m$))) {
      //<< write YCR,"</TD></TR></TABLE>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
      //<< set YTABLEANZ=$get(YTABLEANZ)-1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
    }
    //<< }
    //<< 
    //<< $$$jsMarker("Data Point 6")
    $$$jsMarker(m$,"Data Point 6");
    //<< 
    //<< if $get(YGJUMP)'="" write "<A NAME="""_YGJUMP_""">"
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YGJUMP")),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<A NAME=\"",m$.var("YGJUMP").get()),"\">"));
    }
    //<< 
    //<< if (YFIXHEADER'=$$$YES) && (YFOART'=5) do ^WWWUP($$$YES)
    if ((mOp.NotEqual(m$.var("YFIXHEADER").get(),include.COMSYS.$$$YES(m$))) && (mOp.NotEqual(m$.var("YFOART").get(),5))) {
      m$.Cmd.Do("WWWUP.main",include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< if YFIXHEADER'=$$$YES if YHTMFORM'="WWW2" if $get(YFORM)'="" if $get(YFOART)=1 if +$$$WWW120SaveButtonAtTheBottomFrom($get(YVOR))'=0 if $get(YZEIPO)>$$$WWW120SaveButtonAtTheBottomFrom($get(YVOR)) do
    if (mOp.NotEqual(m$.var("YFIXHEADER").get(),include.COMSYS.$$$YES(m$))) {
      if (mOp.NotEqual(m$.var("YHTMFORM").get(),"WWW2")) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
          if (mOp.Equal(m$.Fnc.$get(m$.var("YFOART")),1)) {
            if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW120SaveButtonAtTheBottomFrom(m$,m$.Fnc.$get(m$.var("YVOR")))),0)) {
              if (mOp.Greater(m$.Fnc.$get(m$.var("YZEIPO")),include.WWWConst.$$$WWW120SaveButtonAtTheBottomFrom(m$,m$.Fnc.$get(m$.var("YVOR"))))) {
                //<< . if $get(YBEARB)'=4 if $get(YBEARB)'=8 if ($$$WWW120AuthorizationToModifyData(YVOR)'=$$$EnumReadOnly)  if +$$$WWW120PicturesAsButtons($get(YVOR))=1 do
                if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBEARB")),4)) {
                  if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBEARB")),8)) {
                    if ((mOp.NotEqual(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$)))) {
                      if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.Fnc.$get(m$.var("YVOR")))),1)) {
                        //<< . . write "&nbsp;"
                        m$.Cmd.Write("&nbsp;");
                        //<< . . write "<INPUT TYPE=""IMAGE"""
                        m$.Cmd.Write("<INPUT TYPE=\"IMAGE\"");
                        //<< . . if $$$WWW120AuthorizationToModifyData($get(YVOR))<4 write " SRC="""_YGIF_"save.gif"" "_YWIDTH_" "_YHEIGHT_" TITLE="""_$$^WWWUML($$^WWWTEXT(165))  ; "Save"
                        if (mOp.Less(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.Fnc.$get(m$.var("YVOR"))),4)) {
                          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" SRC=\"",m$.var("YGIF").get()),"save.gif\" "),m$.var("YWIDTH").get())," "),m$.var("YHEIGHT").get())," TITLE=\""),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",165))));
                        }
                        //<< . . if $$$WWW120AuthorizationToModifyData($get(YVOR))>3 write " SRC="""_YGIF_"save.gif"" "_YWIDTH_" "_YHEIGHT_" TITLE=""OK"
                        if (mOp.Greater(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.Fnc.$get(m$.var("YVOR"))),3)) {
                          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" SRC=\"",m$.var("YGIF").get()),"save.gif\" "),m$.var("YWIDTH").get())," "),m$.var("YHEIGHT").get())," TITLE=\"OK"));
                        }
                        //<< . . write """ border=0>" ; SPEICHERN ;Save
                        m$.Cmd.Write("\" border=0>");
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< do EVENT
    m$.Cmd.Do("EVENT");
    //<< do EVENTCHECKUP  ;EVENT PRÜFUNG;25774;FIS;16.07.04
    m$.Cmd.Do("EVENTCHECKUP");
    //<< ;------------------------------------------------------------------------
    //<< ;%%%%%
    //<< ;
    //<< ; Data Point 7 </FORM>
    //<< ;
    //<< ;%%%%%
    //<< write "</FORM>"
    m$.Cmd.Write("</FORM>");
    //<< 
    //<< $$$jsMarker("Data Point 7")
    $$$jsMarker(m$,"Data Point 7");
    //<< 
    //<< ;ENDE=ANZEIGEN DES FORMS
    //<< if $get(YFIXHEADER)=$$$YES {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFIXHEADER")),include.COMSYS.$$$YES(m$))) {
      //<< write "</div><!-- end divFixedHeader -->"
      m$.Cmd.Write("</div><!-- end divFixedHeader -->");
      //<< write YCR,"</TD></TR></TABLE>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
      //<< set YTABLEANZ = $get(YTABLEANZ)-1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
    }
    //<< }
    //<< if $get(YTABLEANZ)>0 {   ; FIXME : Should we repeat until YTABLEANZ is zero?
    if (mOp.Greater(m$.Fnc.$get(m$.var("YTABLEANZ")),0)) {
      //<< write YCR,"</TD></TR></TABLE>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
      //<< set YTABLEANZ = $get(YTABLEANZ)-1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
    }
    //<< }
    //<< if YFORM="WWWCHAT" {
    if (mOp.Equal(m$.var("YFORM").get(),"WWWCHAT")) {
      //<< $$$StartScript()
      include.COMSYS.$$$StartScript(m$);
      //<< write YCR,"window.setTimeout(""chat()"",2000);"
      m$.Cmd.Write(m$.var("YCR").get(),"window.setTimeout(\"chat()\",2000);");
      //<< $$$EndScript()
      include.COMSYS.$$$EndScript(m$);
    }
    //<< }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< set %KEY = YKEY
    m$.var("%KEY").set(m$.var("YKEY").get());
    //<< 
    //<< if $$IsNewRecord^WWWFORMStatus() {
    if (mOp.Logical(m$.fnc$("WWWFORMStatus.IsNewRecord"))) {
      //<< if '$data(^WWWDUMMY(YUSER)) set ^WWW1261(0,YFORM,1) = $get(YFELD)
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWWDUMMY",m$.var("YUSER").get())))) {
        m$.var("^WWW1261",0,m$.var("YFORM").get(),1).set(m$.Fnc.$get(m$.var("YFELD")));
      }
    }
    //<< }  ;DATENSATZ BEI NEU ZUR PRÜFUNG OB SAVE ERLAUBT ;data record next to recent query whether permissive
    //<< 
    //<< kill ^WWWDUMMY(YUSER)
    m$.var("^WWWDUMMY",m$.var("YUSER").get()).kill();
    //<< do ^WWWFORM2
    m$.Cmd.Do("WWWFORM2.main");
    //<< do ^WWWSTOP
    m$.Cmd.Do("WWWSTOP.main");
    //<< set $$$WWWUSERHTMLStarted(^WWWUSER(0,YUSER,1)) = $$$NO  ;HTML AUS ;HTML out of
    include.WWWConst.$$$WWWUSERHTMLStartedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),include.COMSYS.$$$NO(m$));
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< EVENT
  public void EVENT() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   EVENTBROKER LADEN  (ACHTUNG EINSPRUNG ZB AUS WWWMENU) ;charge out of
    //<< ;-------------------------------------------------------------------------------
    //<< if +$get(YHYPER)=0 do
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),0)) {
      //<< . $$$jsMarker("Applet Eventbroker")
      $$$jsMarker(m$,"Applet Eventbroker");
      //<< . new TCP
      mVar TCP = m$.var("TCP");
      m$.newVar(TCP);
      //<< . set TCP = $get(%CGIEVAR("SERVER_NAME"))
      TCP.set(m$.Fnc.$get(m$.var("%CGIEVAR","SERVER_NAME")));
      //<< . if $get(%KEY("MGWEBP"))="" set %KEY("MGWEBP") = 7001
      if (mOp.Equal(m$.Fnc.$get(m$.var("%KEY","MGWEBP")),"")) {
        m$.var("%KEY","MGWEBP").set(7001);
      }
      //<< . write YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . write YCR_"<div style=""display:none; visibility:hidden;"">"
      m$.Cmd.Write(mOp.Concat(m$.var("YCR").get(),"<div style=\"display:none; visibility:hidden;\">"));
      //<< . write YCR,"<APPLET NAME=WebLink CODEBASE=/ CODE=mgw.class WIDTH=2 HEIGHT=2>"
      m$.Cmd.Write(m$.var("YCR").get(),"<APPLET NAME=WebLink CODEBASE=/ CODE=mgw.class WIDTH=2 HEIGHT=2>");
      //<< . write YCR,"<PARAM NAME=WebEventBrokerPort VALUE="""_$get(%KEY("MGWEBP"))_""">"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<PARAM NAME=WebEventBrokerPort VALUE=\"",m$.Fnc.$get(m$.var("%KEY","MGWEBP"))),"\">"));
      //<< . if TCP'="" write YCR,"<PARAM NAME=WebServerIPAddress VALUE="""_TCP_""">"
      if (mOp.NotEqual(TCP.get(),"")) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<PARAM NAME=WebServerIPAddress VALUE=\"",TCP.get()),"\">"));
      }
      //<< . ;
      //<< . if $get(%KEY("MGWLIB"))'="" do
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("%KEY","MGWLIB")),"")) {
        //<< . . write YCR,"<PARAM NAME=Mode VALUE=10>"
        m$.Cmd.Write(m$.var("YCR").get(),"<PARAM NAME=Mode VALUE=10>");
        //<< . . write YCR,"<PARAM NAME=ScriptName VALUE="""_$get(%KEY("MGWLIB"))_""">"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<PARAM NAME=ScriptName VALUE=\"",m$.Fnc.$get(m$.var("%KEY","MGWLIB"))),"\">"));
      }
      //<< . write YCR,"</APPLET>"
      m$.Cmd.Write(m$.var("YCR").get(),"</APPLET>");
      //<< . write YCR_"</div>",YCR
      m$.Cmd.Write(mOp.Concat(m$.var("YCR").get(),"</div>"),m$.var("YCR").get());
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< 
    //<< if (+$get(YHYPER)=1) && '$get(%(YQUERY,"XMLHTTPREQ")) {
    if ((mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),1)) && mOp.Not(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"XMLHTTPREQ")))) {
      //<< $$$jsMarker("Applet Hyperevent")
      $$$jsMarker(m$,"Applet Hyperevent");
      //<< write "<APPLET NAME=""CacheCSPBroker"" ARCHIVE=""cspbroker.jar"" CODEBASE=""/csp/broker"" CODE=""cspbroker.class"" WIDTH=0 HEIGHT=0 ALIGN=RIGHT>"
      m$.Cmd.Write("<APPLET NAME=\"CacheCSPBroker\" ARCHIVE=\"cspbroker.jar\" CODEBASE=\"/csp/broker\" CODE=\"cspbroker.class\" WIDTH=0 HEIGHT=0 ALIGN=RIGHT>");
      //<< write YCR,"</APPLET>",YCR
      m$.Cmd.Write(m$.var("YCR").get(),"</APPLET>",m$.var("YCR").get());
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< EVENTCHECKUP  ;EVENT PRÜFUNG;25774;FIS;16.07.04
  public void EVENTCHECKUP() {
    //<< ;if +$get(^SysSetup("FieldEvents")) {     ; PJOSAVE no longer exists SR17515
    //<< ;   do EVENTCHECKUP^PJOSAVE
    //<< ;} else {
    //<< ;   do EVENTCHECKUPORIG
    //<< ;}
    //<< ;quit
    //<< 
    //<< ;EVENTCHECKUPORIG
    //<< new LOCKCHCK,TIMEOUT,YKEY
    mVar LOCKCHCK = m$.var("LOCKCHCK");
    mVar TIMEOUT = m$.var("TIMEOUT");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(LOCKCHCK,TIMEOUT,YKEY);
    //<< 
    //<< ;   D162    $$$WWW012AutoEventRequestInBackgro()
    //<< ;               "Disable Auto Event Request In Background" - disabled or enabled? Check timeout if set
    //<< ;   D163    $$$WWW012RequestEverySeconds()
    //<< if +$piece(YVOR1,Y,162)=$$$YES do
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),162)),include.COMSYS.$$$YES(m$))) {
      //<< . set TIMEOUT = +$piece(YVOR1,Y,163)  ;ALLE WIEVIEL SEKUNDEN ;how much
      TIMEOUT.set(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),163)));
      //<< . if +TIMEOUT<5 set TIMEOUT = 20      ;DFLT. 20
      if (mOp.Less(mOp.Positive(TIMEOUT.get()),5)) {
        TIMEOUT.set(20);
      }
      //<< . set LOCKCHCK = 1
      LOCKCHCK.set(1);
      //<< . set YKEY     = $get(YREFRKEY)
      YKEY.set(m$.Fnc.$get(m$.var("YREFRKEY")));
      //<< . if YKEY="" set YKEY = $get(%(YQUERY,"YKEY"))
      if (mOp.Equal(YKEY.get(),"")) {
        YKEY.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YKEY")));
      }
      //<< . do  //INKL. LOCKPRÜFUNG JA/NEIN
      do {
        //<< . . if YFOART'=1           set LOCKCHCK = 0  ;NUR STD. FORMULAR ;only form
        if (mOp.NotEqual(m$.var("YFOART").get(),1)) {
          LOCKCHCK.set(0);
        }
        //<< . . if $get(YBEARB)=4      set LOCKCHCK = 0  ;READONLY
        if (mOp.Equal(m$.Fnc.$get(m$.var("YBEARB")),4)) {
          LOCKCHCK.set(0);
        }
        //<< . . if ($$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly) set LOCKCHCK = 0
        if ((mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$)))) {
          LOCKCHCK.set(0);
        }
      } while(false);
      //<< . ;
      //<< . $$$StartScript()
      include.COMSYS.$$$StartScript(m$);
      //<< . if (LOCKCHCK=1) && (YBEARB'=1) && ($get(YKEY)'="") && '$find(YKEY,"+") write YCR,"window.setTimeout(""RefreshCheck()"",200);"
      if ((mOp.Equal(LOCKCHCK.get(),1)) && (mOp.NotEqual(m$.var("YBEARB").get(),1)) && (mOp.NotEqual(m$.Fnc.$get(YKEY),"")) && mOp.Not(m$.Fnc.$find(YKEY.get(),"+"))) {
        m$.Cmd.Write(m$.var("YCR").get(),"window.setTimeout(\"RefreshCheck()\",200);");
      }
      //<< . write YCR,"window.setTimeout(""EventCheckup()"","_(30*1000)_");"  ; Check Every Minute  (30 sec?)
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("window.setTimeout(\"EventCheckup()\",",(mOp.Multiply(30,1000))),");"));
      //<< . ;
      //<< . write YCR,"function EventCheckup() {"
      m$.Cmd.Write(m$.var("YCR").get(),"function EventCheckup() {");
      //<< . write YCR,"  retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"",""WWWEVENT4"","""_LOCKCHCK_""",""6"",""EventRequest"");"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX\",\"WWWEVENT4\",\""),LOCKCHCK.get()),"\",\"6\",\"EventRequest\");"));
      //<< . write YCR,"  if (retval == 'REFRESH') { "
      m$.Cmd.Write(m$.var("YCR").get(),"  if (retval == 'REFRESH') { ");
      //<< . write YCR,"    window.history.go(0);"
      m$.Cmd.Write(m$.var("YCR").get(),"    window.history.go(0);");
      //<< . write YCR,"  }"
      m$.Cmd.Write(m$.var("YCR").get(),"  }");
      //<< . ;
      //<< . write YCR,"  else if (retval == 'RELOAD') {"
      m$.Cmd.Write(m$.var("YCR").get(),"  else if (retval == 'RELOAD') {");
      //<< . write YCR,"    if (confirm('"_$$^WWWTEXT(33931,,1)_"')) {"  ; "Another user has changed this record. Do you want to load the new version?"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("    if (confirm('",m$.fnc$("WWWTEXT.main",33931,null,1)),"')) {"));
      //<< . write YCR,"      retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"",""WWWEVENT4"","""_LOCKCHCK_""",""6"",""DataRequest"");"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("      retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX\",\"WWWEVENT4\",\""),LOCKCHCK.get()),"\",\"6\",\"DataRequest\");"));
      //<< . write YCR,"    }"
      m$.Cmd.Write(m$.var("YCR").get(),"    }");
      //<< . write YCR,"    else {"
      m$.Cmd.Write(m$.var("YCR").get(),"    else {");
      //<< . write YCR,"      alert('"_$$^WWWTEXT(33932,,1)_"');"        ; "Info! Changed Data Will Not Been Saved."
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("      alert('",m$.fnc$("WWWTEXT.main",33932,null,1)),"');"));
      //<< . write YCR,"      retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"",""WWWEVENT4"","""_LOCKCHCK_""",""6"",""DeleteLock"");"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("      retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX\",\"WWWEVENT4\",\""),LOCKCHCK.get()),"\",\"6\",\"DeleteLock\");"));
      //<< . write YCR,"    }"
      m$.Cmd.Write(m$.var("YCR").get(),"    }");
      //<< . write YCR,"    window.setTimeout(""EventCheckup()"","_(TIMEOUT*1000)_");"  ; Check Again every x seconds
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("    window.setTimeout(\"EventCheckup()\",",(mOp.Multiply(TIMEOUT.get(),1000))),");"));
      //<< . write YCR,"  }"
      m$.Cmd.Write(m$.var("YCR").get(),"  }");
      //<< . ;
      //<< . write YCR,"  else if (retval == 'INVALID') { "
      m$.Cmd.Write(m$.var("YCR").get(),"  else if (retval == 'INVALID') { ");
      //<< . ;            "Another User has changed the data record. Please Refresh This Page. Save is not possible."
      //<< . write YCR,"    if (confirm('"_$$^WWWTEXT(392,,1)_"')) {"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("    if (confirm('",m$.fnc$("WWWTEXT.main",392,null,1)),"')) {"));
      //<< . write YCR,"      window.history.go(0);"
      m$.Cmd.Write(m$.var("YCR").get(),"      window.history.go(0);");
      //<< . write YCR,"    }"
      m$.Cmd.Write(m$.var("YCR").get(),"    }");
      //<< . write YCR,"  }"
      m$.Cmd.Write(m$.var("YCR").get(),"  }");
      //<< . ;
      //<< . write YCR,"  else {"
      m$.Cmd.Write(m$.var("YCR").get(),"  else {");
      //<< . write YCR,"   window.setTimeout(""EventCheckup()"","_(TIMEOUT*1000)_");"  ; Check Again every x seconds
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("   window.setTimeout(\"EventCheckup()\",",(mOp.Multiply(TIMEOUT.get(),1000))),");"));
      //<< . write YCR,"  }"
      m$.Cmd.Write(m$.var("YCR").get(),"  }");
      //<< . write YCR,"}"
      m$.Cmd.Write(m$.var("YCR").get(),"}");
      //<< . ;
      //<< . if (LOCKCHCK=1) && (YBEARB'=1) && ($get(YKEY)'="") && '$find(YKEY,"+") do
      if ((mOp.Equal(LOCKCHCK.get(),1)) && (mOp.NotEqual(m$.var("YBEARB").get(),1)) && (mOp.NotEqual(m$.Fnc.$get(YKEY),"")) && mOp.Not(m$.Fnc.$find(YKEY.get(),"+"))) {
        //<< . . write YCR,"function RefreshCheck() {"
        m$.Cmd.Write(m$.var("YCR").get(),"function RefreshCheck() {");
        //<< . . write YCR,"  var dkey = '"_$translate(YKEY,"][\}{|~ ,;:'()@#$%^&*_=+<>?/"_$char(128)_"""")_"';" ;W3C
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("  var dkey = '",m$.Fnc.$translate(YKEY.get(),mOp.Concat(mOp.Concat("][\\}{|~ ,;:'()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\""))),"';"));
        //<< . . write YCR,"  var retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"",""WWWEVENT4"",dkey,""6"",""RefreshCheck"");" ;W3C
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  var retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX\",\"WWWEVENT4\",dkey,\"6\",\"RefreshCheck\");"));
        //<< . . write YCR,"  if (retval !='' && retval == dkey) { "   ; Check Key Again - Changed during event call?
        m$.Cmd.Write(m$.var("YCR").get(),"  if (retval !='' && retval == dkey) { ");
        //<< . . write YCR,"      alert('"_$$^WWWTEXT(33960,,1)_"');"  ; "This Page Is No Longer Valid!"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("      alert('",m$.fnc$("WWWTEXT.main",33960,null,1)),"');"));
        //<< . . write YCR,"      window.history.go(0);"
        m$.Cmd.Write(m$.var("YCR").get(),"      window.history.go(0);");
        //<< . . write YCR,"  }"
        m$.Cmd.Write(m$.var("YCR").get(),"  }");
        //<< . . write YCR,"}"
        m$.Cmd.Write(m$.var("YCR").get(),"}");
      }
      //<< . ;
      //<< . $$$EndScript()
      include.COMSYS.$$$EndScript(m$);
    }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< DrawTabs(pidForm)
  public Object DrawTabs(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines whether or not we are drawing tabs for this form.
    //<< ; (Original code was just doing $data check on subscript "2", which doesn't
    //<< ; always work if you have "holes" in the tab numbering).
    //<< ;
    //<< ; Params: pidForm       : The form ID.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: blnDrawTabs
    //<< ;
    //<< ; History:
    //<< ; 11-Sep-2006   SteveS  SR14286: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnDrawTabs,intCount,idTab
    mVar blnDrawTabs = m$.var("blnDrawTabs");
    mVar intCount = m$.var("intCount");
    mVar idTab = m$.var("idTab");
    m$.newVar(blnDrawTabs,intCount,idTab);
    //<< 
    //<< set blnDrawTabs = $$$NO
    blnDrawTabs.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if ($get(pidForm)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(pidForm),""))) {
      //<< set intCount = 0
      intCount.set(0);
      //<< set idTab    = ""
      idTab.set("");
      //<< for {
      for (;true;) {
        //<< set idTab = $order(^WWW1203(0,pidForm,SPRACHE,idTab))
        idTab.set(m$.Fnc.$order(m$.var("^WWW1203",0,pidForm.get(),m$.var("SPRACHE").get(),idTab.get())));
        //<< quit:(idTab="")||(intCount>=2)
        if ((mOp.Equal(idTab.get(),"")) || (mOp.GreaterOrEqual(intCount.get(),2))) {
          break;
        }
        //<< 
        //<< set intCount = intCount+1
        intCount.set(mOp.Add(intCount.get(),1));
      }
      //<< }
      //<< set blnDrawTabs = (intCount>=2)
      blnDrawTabs.set((mOp.GreaterOrEqual(intCount.get(),2)));
    }
    //<< }
    //<< quit blnDrawTabs
    return blnDrawTabs.get();
  }

  //<< 
  //<< 
  //<< DynamicTableHook(pidForm,pintPage,pidKey)
  public Object DynamicTableHook(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintPage = m$.newVarRef("pintPage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create Dynamic Table function and call it if AfterDataFields function created
    //<< ;
    //<< ; Params:
    //<< ; pidForm - Form Id
    //<< ; pintPage - Page Id
    //<< ; pidKey - Key
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 05-Jan-2007   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idGridForm,blnCompleteKey,idKeyPart,arrTables,idTable,loop
    mVar idGridForm = m$.var("idGridForm");
    mVar blnCompleteKey = m$.var("blnCompleteKey");
    mVar idKeyPart = m$.var("idKeyPart");
    mVar arrTables = m$.var("arrTables");
    mVar idTable = m$.var("idTable");
    mVar loop = m$.var("loop");
    m$.newVar(idGridForm,blnCompleteKey,idKeyPart,arrTables,idTable,loop);
    //<< 
    //<< if $data(^WWW120DynTable(0,YFORM)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW120DynTable",0,m$.var("YFORM").get())))) {
      //<< set idGridForm     = $$$GRIDName
      idGridForm.set(include.COMGridEdit31Interface.$$$GRIDName(m$));
      //<< set blnCompleteKey = $$$YES
      blnCompleteKey.set(include.COMSYS.$$$YES(m$));
      //<< 
      //<< if idGridForm = "" {
      if (mOp.Equal(idGridForm.get(),"")) {
        //<< write "<div id='DynamicArea'></div>"
        m$.Cmd.Write("<div id='DynamicArea'></div>");
        //<< do CreateDynTableCall^WWW120DynTable(pidForm,idGridForm,pintPage,.arrTables)           ; *** EXECUTE ??? ***
        m$.Cmd.Do("WWW120DynTable.CreateDynTableCall",pidForm.get(),idGridForm.get(),pintPage.get(),arrTables);
      }
      //<< }
      //<< 
      //<< for loop=1:1:$length(pidKey,$$$COMMA) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(pidKey.get(),include.COMSYSString.$$$COMMA(m$))));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idKeyPart = $piece(pidKey,$$$COMMA,loop)
        idKeyPart.set(m$.Fnc.$piece(pidKey.get(),include.COMSYSString.$$$COMMA(m$),loop.get()));
        //<< if $$$NoKey(idKeyPart) set blnCompleteKey = $$$NO
        if (mOp.Logical(include.COMSYS.$$$NoKey(m$,idKeyPart))) {
          blnCompleteKey.set(include.COMSYS.$$$NO(m$));
        }
      }
      //<< }
      //<< 
      //<< set idTable = ""
      idTable.set("");
      //<< for {
      for (;true;) {
        //<< set idTable = $order(arrTables(idTable))
        idTable.set(m$.Fnc.$order(arrTables.var(idTable.get())));
        //<< quit:idTable=""
        if (mOp.Equal(idTable.get(),"")) {
          break;
        }
        //<< 
        //<< if blnCompleteKey || '$$$WWW120DynTableRequireRecord(arrTables(idTable)) {
        if (mOp.Logical(blnCompleteKey.get()) || mOp.Not(include.WWWConst.$$$WWW120DynTableRequireRecord(m$,arrTables.var(idTable.get())))) {
          //<< $$$StartScript()
          include.COMSYS.$$$StartScript(m$);
          //<< write "if (typeof(DrawDynTable_AfterDataFields) != 'undefined') DrawDynTable_AfterDataFields('"_$$$EnumWWWDYNTABLEAfterDataFields_"','"_pidKey_"');"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("if (typeof(DrawDynTable_AfterDataFields) != 'undefined') DrawDynTable_AfterDataFields('",include.WWWConst.$$$EnumWWWDYNTABLEAfterDataFields(m$)),"','"),pidKey.get()),"');"));
          //<< $$$EndScript()
          include.COMSYS.$$$EndScript(m$);
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ReadOnly(pstrBack)
  public Object ReadOnly(Object ... _p) {
    mVar pstrBack = m$.newVarRef("pstrBack",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Users are not allowed to modify data in EN
    //<< ;
    //<< ; Params: strBack = name of the last form
    //<< ;
    //<< ; ByRefs: YBACK, YKEY
    //<< ;
    //<< ; History:
    //<< ; 06-Jul-2007   GM      SRBR014572: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $piece($get(YBACK),",",$length($get(YBACK),",")-1)=pstrBack {
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YBACK")),",",mOp.Subtract(m$.Fnc.$length(m$.Fnc.$get(m$.var("YBACK")),","),1)),pstrBack.get())) {
      //<< if $$$KEY2(YKEY) = "EN" {
      if (mOp.Equal(include.COMSYSWWW.$$$KEY2(m$,m$.var("YKEY")),"EN")) {
        //<< set $$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly
        include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

//<< 
}
