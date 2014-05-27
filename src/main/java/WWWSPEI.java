//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSPEI
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:28
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
//<< #include INConst
import include.INConst;
//<< #include COMDebug
import include.COMDebug;

//<< 
public class WWWSPEI extends mClass {

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

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWSPEI("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< WWWSPEI(YDATEI,YKEY,YFELD,YFIX,YNEWSORT,YEINMAL,&strStatus,pblnDoOnBeforeSave=$$$YES)
  public Object main(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YFIX = m$.newVarRef("YFIX",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YNEWSORT = m$.newVarRef("YNEWSORT",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar YEINMAL = m$.newVarRef("YEINMAL",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar strStatus = m$.newVarRef("strStatus",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pblnDoOnBeforeSave = m$.newVarRef("pblnDoOnBeforeSave",(((_p!=null)&&(_p.length>=8))?_p[7]:null),include.COMSYS.$$$YES(m$));
    return _WWWSPEI(YDATEI,YKEY,YFELD,YFIX,YNEWSORT,YEINMAL,strStatus,pblnDoOnBeforeSave);
  }

  public Object _WWWSPEI(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YFIX = m$.newVarRef("YFIX",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YNEWSORT = m$.newVarRef("YNEWSORT",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar YEINMAL = m$.newVarRef("YEINMAL",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar strStatus = m$.newVarRef("strStatus",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pblnDoOnBeforeSave = m$.newVarRef("pblnDoOnBeforeSave",(((_p!=null)&&(_p.length>=8))?_p[7]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SPEICHERN DATENSATZ
    //<< ;       "Save Data Record"
    //<< ; S YOK=$$^WWWSPEI(YDATEI,YKEY,YFELD,1) ;     ACHTUNG YFORM UND YVOR BEACHTEN
    //<< ;
    //<< ; Inputs :
    //<< ;   YDATEI      DATEI                          ; Class
    //<< ;   YKEY        SCHLUESSEL                     ; KEY1,KEY2,KEYn
    //<< ;   YFELD       DATENSATZ                      ; data record XX~XX~XX~
    //<< ;   YFIX        =1 IMMER SPEICHERN             ; Always Save
    //<< ;   YNEWSORT    =1 SORTKEY IMMER NEU AUFBAUEN  ; Always recent construct
    //<< ;   YEINMAL     =1 Once Only - Do not resubmit to DCM         FIS;31.01.05;GRF;SR11363;10.01.2005
    //<< ;   strStatus   (byref) Optional status str for VARHook routines to return an error msg.
    //<< ; ByRef :
    //<< ;   YVOR        objWWW120
    //<< ;   YTIMEFORM   =1 DANN WIRD IN DATEI_"t" gespeichert
    //<< ;
    //<< ; Returns :
    //<< ;     0= NOT OK ;$$$HardFail
    //<< ;     9= NOT OK ;$$$SoftFail  - still save if YFIX = $$$YES
    //<< ;     1= OK     ;$$$SaveOkay
    //<< ;
    //<< ;---------------------
    //<< ; FIXME : SORTCHANGE never anything but $$$YES so can remove all tests? <GRF>
    //<< ;---------------------
    //<< ;
    //<< ; History :
    //<< ; 30-Apr-2010   GRF     SR15961: WWW006 macros
    //<< ; 04-Aug-2009   shobby  SR16808: Common routine to remove lock.
    //<< ; 30-Sep-2008   GRF     SR15947: reversion of FIS change and correction
    //<< ; 17-Sep-2008   Luke    SR15833: Corrected the TCOMMIT to check fot TLevel
    //<< ; 08-Aug-2008   FIS     SR15835: implement tx process control for save transaction
    //<< ; 06-Aug-2008   FIS     SR15828: Two correction for softfail
    //<< ; 30-Jun-2008   shobby  SRBR014960: Save should fail if OnBeforeSave returns an error.
    //<< ; 25-Feb-2008   GRF     SRBR014901: bypass logging if class or userid (YBED) are null.
    //<< ; 22-Feb-2008   GRF     SR15622: Version 1 => Version 2 conversion for selected classes
    //<< ; 13-Jul-2007   RPW     SR15571: Get the status in case there is a Cache error.
    //<< ; 31-May-2007   HeberB  SRBR014465:Add new characters
    //<< ; 23-May-2007   RGB     SRBR014456: Added a check to see if the call was made
    //<< ;                           from a form so it wouldn't run the varhook onbefore
    //<< ;                           save call twice.
    //<< ; 16-May-2007   shobby  SR14365: WWWSPEI was passing checksum in on the wrong
    //<< ;                           parameter in to the HandleRelevantEvents routine.
    //<< ; 23-Feb-2007   JW      SR15452: Quote the company
    //<< ; 29-Jan-2007   JW      SR15304: Added old record parameter to class hooks
    //<< ; 02-Jan-2007   GRF     SR15337: Doco; single calculation of key translation and
    //<< ;                           today's date; comment out impossible combination;
    //<< ;                           boolean macros; use blnCreated rather than %FELD1="";
    //<< ;                           replace data field locn lookups with fldEntryDate,
    //<< ;                           fldDateModified, fldModifiedBy, fldEnteredBy,
    //<< ;                           fldCreateLocn; ineffective block commented; sort new
    //<< ;                           list; use idClassTR; use DO so don't repeat F/K tests
    //<< ; 14-Dec-2006   Steve S SR15316 Run Class Hook
    //<< ; 13-Dec-2006   JW      SR15308: Fixed SR14599 errors - dot level, wrong piece.
    //<< ; 24-Nov-2006   HeberB  BR014334: VarHook on After Save
    //<< ; 23-Nov-2006   RPW     SR15245: If not going to save because there are no
    //<< ;                           changes, then set YCHANGED to 0 so DCM is not called
    //<< ; 11-Oct-2006   GRF     SR15110: Removed unnecessary NEW; parenthesis in if tests
    //<< ; 22-Sep-2006   PO      SR15069: Added logging for demands
    //<< ; 19-Sep-2006   shobby  SR14365: Call to GetChecksum routine.
    //<< ; 12-Jul-2006   FIS     SR14834: If unknown form, try using classname as formname
    //<< ; 07-Jul-2006   RPW     SR12522: Save any Quick Search if required
    //<< ; 08-Jun-2006   shobby  SR14365: Pass a checksum for the previous value into
    //<< ;                           the setRelevantEvents routine.  This can be used to
    //<< ;                           determine if the record at both sites was the same
    //<< ;                           before modification.
    //<< ; 08-Jun-2006   GRF     Doco
    //<< ; 09-May-2006   SteveS  SR14508: Only perform a lock check for appropriate classes
    //<< ; 03-May-2006   RPW     SR14599: If the field is a %Date, use +$h not $h.
    //<< ; 01-May-2006   shobby  SRBR014015: Pass YFELD into VARHook routine by reference
    //<< ;                           so it can be modified.
    //<< ; 26-Apr-2006   SC      SR14414: Check for and run VARHooks routines. Added
    //<< ;                           strStatus byref.
    //<< ; 12-Jan-2006   Steve S SR14114: Return YOK=9 (error) if no set occurs
    //<< ; 22-Dec-2005   RPW     SR13899: New schluessel
    //<< ; 07-Jul-2005   shobby  SR12892: WWW1261 is no longer shared.
    //<< ; 07-Jun-2005   SCR     Removed ^COMLOG entry
    //<< ; 31.07.1997    DT
    //<< ;-----------------------------------------------------------------------------*/
    //<< NEW (%,%FELD,%SCHLUESSEL,LANGUAGE,SPRACHE,strStatus,Y,YAEND,YBED,YDATEI,YEINMAL,YFELD,YFIX,YFORM,YKEY,YKOMMA,YLOCATION,YM,YMANDANT,YNEWSORT,YOPEN,YSKEY,YTIMEFORM,YUMLAU,YURL,YUSER,YVOR,pblnDoOnBeforeSave)
    mVar LANGUAGE = m$.var("LANGUAGE");
    mVar SPRACHE = m$.var("SPRACHE");
    mVar Y = m$.var("Y");
    mVar YAEND = m$.var("YAEND");
    mVar YBED = m$.var("YBED");
    mVar YFORM = m$.var("YFORM");
    mVar YKOMMA = m$.var("YKOMMA");
    mVar YLOCATION = m$.var("YLOCATION");
    mVar YM = m$.var("YM");
    mVar YMANDANT = m$.var("YMANDANT");
    mVar YOPEN = m$.var("YOPEN");
    mVar YSKEY = m$.var("YSKEY");
    mVar YTIMEFORM = m$.var("YTIMEFORM");
    mVar YUMLAU = m$.var("YUMLAU");
    mVar YURL = m$.var("YURL");
    mVar YUSER = m$.var("YUSER");
    mVar YVOR = m$.var("YVOR");
    m$.newVarExcept(LANGUAGE,SPRACHE,strStatus,Y,YAEND,YBED,YDATEI,YEINMAL,YFELD,YFIX,YFORM,YKEY,YKOMMA,YLOCATION,YM,YMANDANT,YNEWSORT,YOPEN,YSKEY,YTIMEFORM,YUMLAU,YURL,YUSER,YVOR,pblnDoOnBeforeSave);
    //<< ;if YUSER=10010821540 f i=1:1:100 h 1
    //<< $$$LogR("Main",YDATEI_"<"_YKEY_"<"_YFELD_"<")
    $$$LogR(m$,"Main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YDATEI.get(),"<"),YKEY.get()),"<"),YFELD.get()),"<"));
    //<< 
    //<< ; UMLAUTE IN $TR
    //<< SET LC="·‡„‚ÈËÍÌÏÓÛÚıÙ˙˘˚Á‹ƒ÷¸‰ˆﬂ][\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/"_$CHAR(128)_""" "
    mVar LC = m$.var("LC");
    LC.set(mOp.Concat(mOp.Concat("·‡„‚ÈËÍÌÏÓÛÚıÙ˙˘˚Á‹ƒ÷¸‰ˆﬂ][\\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\" "));
    //<< SET UC="¡¿√¬…» ÕÃŒ”“’‘⁄Ÿ€«UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   "
    mVar UC = m$.var("UC");
    UC.set("¡¿√¬…» ÕÃŒ”“’‘⁄Ÿ€«UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   ");
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< ;--------------------------------------------------------------------------------------------------------
    //<< IF $GET(YUCI)="" SET YUCI = $ZUTIL(5)  ; namespace
    if (mOp.Equal(m$.Fnc.$get(m$.var("YUCI")),"")) {
      mVar YUCI = m$.var("YUCI");
      YUCI.set(m$.Fnc.$zutil(5));
    }
    //<< ;IF $DATA(^COMLogM) DO SAVE^COMLOG     ;CHECK IF COMPILED ROUTINE EXISTS. ;Bec;05.12.03;24774
    //<< SET YVOR   = $GET(YVOR)
    YVOR.set(m$.Fnc.$get(YVOR));
    //<< SET YUMLAU = $GET(YUMLAU)
    YUMLAU.set(m$.Fnc.$get(YUMLAU));
    //<< SET YAEND  = $$$NO
    YAEND.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set idxYDATEI = " "
    mVar idxYDATEI = m$.var("idxYDATEI");
    idxYDATEI.set(" ");
    //<< IF YDATEI'="" {
    if (mOp.NotEqual(YDATEI.get(),"")) {
      //<< set idxYDATEI = $$^WWWUMLAU(YDATEI,1)
      idxYDATEI.set(m$.fnc$("WWWUMLAU.main",YDATEI.get(),1));
      //<< IF $ORDER(^WWW0011s(0,1,idxYDATEI,""))'="" {
      if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW0011s",0,1,idxYDATEI.get(),"")),"")) {
        //<< SET YDATEI=$ORDER(^WWW0011s(0,1,idxYDATEI,""))  ; ALTERNATIVE CLASS
        YDATEI.set(m$.Fnc.$order(m$.var("^WWW0011s",0,1,idxYDATEI.get(),"")));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< IF '$DATA(%SCHLUESSEL) SET %SCHLUESSEL = ""
    if (mOp.Not(m$.Fnc.$data(m$.var("%SCHLUESSEL")))) {
      m$.var("%SCHLUESSEL").set("");
    }
    //<< IF '$DATA(YFIX)        SET YFIX        = 0    ;NICHT FIX SPEICHERN ;Not forced Save
    if (mOp.Not(m$.Fnc.$data(YFIX))) {
      YFIX.set(0);
    }
    //<< SET YKEY   = $TRANSLATE(YKEY,"""")
    YKEY.set(m$.Fnc.$translate(YKEY.get(),"\""));
    //<< 
    //<< SET YFORM1 = $GET(YFORM)
    mVar YFORM1 = m$.var("YFORM1");
    YFORM1.set(m$.Fnc.$get(YFORM));
    //<< SET YVOR1  = $GET(YVOR)       ; this is tmpYVOR or tmpobjWWW120, not YVOR1 = objWWW012
    mVar YVOR1 = m$.var("YVOR1");
    YVOR1.set(m$.Fnc.$get(YVOR));
    //<< 
    //<< NEW YFORM,YVOR
    m$.newVar(YFORM,YVOR);
    //<< SET YFORM  = YFORM1
    YFORM.set(YFORM1.get());
    //<< SET YVOR   = YVOR1
    YVOR.set(YVOR1.get());
    //<< 
    //<< if YFORM="" set YVOR=""  ;WENN KEINE FORMUALR, DANN AUCH KEINE ƒNDERUNG;TYBD;16,12,2003;
    if (mOp.Equal(YFORM.get(),"")) {
      YVOR.set("");
    }
    //<< 
    //<< ;PRUEFEN OB DATEI MIT FORM RICHTIG IST ;check whether class matches form
    //<< if $get(YFORM)="" set YFORM = $get(YDATEI)  ; IF UNKNOWN TRY SAME AS CLASS
    if (mOp.Equal(m$.Fnc.$get(YFORM),"")) {
      YFORM.set(m$.Fnc.$get(YDATEI));
    }
    //<< if YFORM'="" do
    if (mOp.NotEqual(YFORM.get(),"")) {
      //<< . if $get(YDATEI)'="" do
      if (mOp.NotEqual(m$.Fnc.$get(YDATEI),"")) {
        //<< . . if $$$WWW120ClassUsedInForm($get(^WWW120(0,YFORM,1)))'=YDATEI do
        if (mOp.NotEqual(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1))),YDATEI.get())) {
          do {
            //<< . . . if $data(^WWW120(0,YDATEI,1)) set YFORM=YDATEI,YVOR="" quit
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW120",0,YDATEI.get(),1)))) {
              YFORM.set(YDATEI.get());
              YVOR.set("");
              break;
            }
            //<< . . . set YFORM=""
            YFORM.set("");
            //<< . . . set YVOR=""
            YVOR.set("");
          } while (false);
        }
      }
    }
    //<< 
    //<< set YOK      = $$$HardFail   ;SPEICHERUNG NICHT OK ;Not
    mVar YOK = m$.var("YOK");
    YOK.set(include.COMSYS.$$$HardFail(m$));
    //<< set YCHANGED = $$$YES        ;CHANGES IN FIELDS; TYBD;12,2,2004
    mVar YCHANGED = m$.var("YCHANGED");
    YCHANGED.set(include.COMSYS.$$$YES(m$));
    //<< if '$data(%FELD1) set %FELD1=""
    if (mOp.Not(m$.Fnc.$data(m$.var("%FELD1")))) {
      m$.var("%FELD1").set("");
    }
    //<< 
    //<< ; Start save transaction
    //<< ;---------------------------------------
    //<< set strZTRAP=$ZTRAP
    mVar strZTRAP = m$.var("strZTRAP");
    strZTRAP.set(m$.Fnc.$ztrap());
    //<< set $ZTRAP="OnSaveError"
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("OnSaveError");
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< TSTART  ;start save transaction
    //<< $$$LogRx("TS:")
    $$$LogRx(m$,"TS:");
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< 
    //<< IF YDATEI'="" DO
    if (mOp.NotEqual(YDATEI.get(),"")) {
      do {
        //<< . set WWWYM = $$^WWWYM(YDATEI)
        mVar WWWYM = m$.var("WWWYM");
        WWWYM.set(m$.fnc$("WWWYM.main",YDATEI.get()));
        //<< . set strYM = $$$QUOTE(WWWYM)_","
        mVar strYM = m$.var("strYM");
        strYM.set(mOp.Concat(include.COMSYSString.$$$QUOTE(m$,WWWYM),","));
        //<< . set WWWYM = WWWYM_","
        WWWYM.set(mOp.Concat(WWWYM.get(),","));
        //<< . ;
        //<< . set YDATA  = $GET(^WWW001(0,YDATEI,1))          ; objClass
        mVar YDATA = m$.var("YDATA");
        YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)));
        //<< . set MAXKEY = +$ORDER(^WWW002(0,YDATEI,""),-1)
        mVar MAXKEY = m$.var("MAXKEY");
        MAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
        //<< . IF MAXKEY=0 set MAXKEY=1                        ;KEIN KEY = AUTOMATISCH LFN ;no KEY automatic
        if (mOp.Equal(MAXKEY.get(),0)) {
          MAXKEY.set(1);
        }
        //<< . ;
        //<< . set SCHLUESSEL="^"_YDATEI_"("_strYM                             ;NORMALER SAVE
        mVar SCHLUESSEL = m$.var("SCHLUESSEL");
        SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"("),strYM.get()));
        //<< . IF $GET(YTIMEFORM)=$$$YES set SCHLUESSEL="^"_YDATEI_"t("_strYM  ;ZEITABHƒNGIGER SAVE
        if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),include.COMSYS.$$$YES(m$))) {
          SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"t("),strYM.get()));
        }
        //<< . ;
        //<< . FOR YI=1:1:MAXKEY set KEY=$PIECE(YKEY,",",YI) SET SCHLUESSEL=SCHLUESSEL_""""_KEY_""","
        mVar YI = m$.var("YI");
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),MAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
          mVar KEY = m$.var("KEY");
          KEY.set(m$.Fnc.$piece(YKEY.get(),",",YI.get()));
          SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat(SCHLUESSEL.get(),"\""),KEY.get()),"\","));
        }
        //<< . IF $GET(YTIMEFORM)=$$$YES DO
        if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),include.COMSYS.$$$YES(m$))) {
          //<< . . NEW YABDATE
          mVar YABDATE = m$.var("YABDATE");
          m$.newVar(YABDATE);
          //<< . . IF $GET(YQUERY)="" SET YQUERY="%KEY"
          if (mOp.Equal(m$.Fnc.$get(m$.var("YQUERY")),"")) {
            mVar YQUERY = m$.var("YQUERY");
            YQUERY.set("%KEY");
          }
          //<< . . SET YABDATE=$GET(%(YQUERY,"Y"_$GET(YFORM)_"P"_(MAXKEY+1)))
          YABDATE.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.Fnc.$get(YFORM)),"P"),(mOp.Add(MAXKEY.get(),1))))));
          //<< . . IF YABDATE="" SET YABDATE=$$^WWWDATE($HOROLOG+1)
          if (mOp.Equal(YABDATE.get(),"")) {
            YABDATE.set(m$.fnc$("WWWDATE.main",mOp.Add(m$.Fnc.$horolog(),1)));
          }
          //<< . . SET SCHLUESSEL=SCHLUESSEL_+$$^WWWDATE1(YABDATE)_","
          SCHLUESSEL.set(mOp.Concat(mOp.Concat(SCHLUESSEL.get(),mOp.Positive(m$.fnc$("WWWDATE1.main",YABDATE.get()))),","));
          //<< . . SET YFIX=$$$YES                                            ;IMMER SPEICHERN ;Always Save
          YFIX.set(include.COMSYS.$$$YES(m$));
          //<< . . ;
          //<< . . DO  ;SAVE SATZ2 BEI ZEITABHƒNGIGER ERFASSUNG = ^DATEIt(0,key,2)=alter datensatz
          do {
            //<< . . . NEW SCHLUESSEL2,YDATEI,YTIMEFORM,YFELD
            mVar SCHLUESSEL2 = m$.var("SCHLUESSEL2");
            YDATEI = m$.var("YDATEI");
            YFELD = m$.var("YFELD");
            m$.newVar(SCHLUESSEL2,YDATEI,YTIMEFORM,YFELD);
            //<< . . . SET YDATEI=$PIECE($PIECE(SCHLUESSEL,"^",2),"t(",1)
            YDATEI.set(m$.Fnc.$piece(m$.Fnc.$piece(SCHLUESSEL.get(),"^",2),"t(",1));
            //<< . . . QUIT:YDATEI=""
            if (mOp.Equal(YDATEI.get(),"")) {
              break;
            }
            //<< . . . SET YFELD=""
            YFELD.set("");
            //<< . . . DO ^WWWLESE(YDATEI,YKEY)
            m$.Cmd.Do("WWWLESE.main",YDATEI.get(),YKEY.get());
            //<< . . . QUIT:YFELD=""
            if (mOp.Equal(YFELD.get(),"")) {
              break;
            }
            //<< . . . SET SCHLUESSEL2=SCHLUESSEL_"2)"
            SCHLUESSEL2.set(mOp.Concat(SCHLUESSEL.get(),"2)"));
            //<< . . . SET YFELD=$$^WWWSETS(SCHLUESSEL2,YFELD)
            YFELD.set(m$.fnc$("WWWSETS.main",SCHLUESSEL2.get(),YFELD.get()));
          } while(false);
        }
        //<< . ;
        //<< . ; WWW001 : D8 : Alternate Save Procedure : 4="CachÈ Object"
        //<< . IF $PIECE(YDATA,Y,8)'=4 SET SCHLUESSEL=SCHLUESSEL_"1"
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),Y.get(),8),4)) {
          SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),"1"));
        }
        //<< . IF $PIECE(YDATA,Y,8)=4 IF $EXTRACT(SCHLUESSEL,$LENGTH(SCHLUESSEL))="," SET SCHLUESSEL = $EXTRACT(SCHLUESSEL,1,$LENGTH(SCHLUESSEL)-1)
        if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),Y.get(),8),4)) {
          if (mOp.Equal(m$.Fnc.$extract(SCHLUESSEL.get(),m$.Fnc.$length(SCHLUESSEL.get())),",")) {
            SCHLUESSEL.set(m$.Fnc.$extract(SCHLUESSEL.get(),1,mOp.Subtract(m$.Fnc.$length(SCHLUESSEL.get()),1)));
          }
        }
        //<< . SET SCHLUESSEL=SCHLUESSEL_")"
        SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),")"));
        //<< . ;
        //<< . SET NEU=0,YOK=$$$SaveOkay                    ;NEUER SATZ+SPEICHERN OK
        mVar NEU = m$.var("NEU");
        NEU.set(0);
        YOK.set(include.COMSYS.$$$SaveOkay(m$));
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ; Get original record and check if trying to create
        //<< . ; If only permitted to modify, and not in Fix mode ...
        //<< . ;
        //<< . ; YVOD D23    $$$WWW120AuthorizationToModifyData()  3 = "Create Only", 4 = "Modify Only"
        //<< . ;-------------------------------------
        //<< . SET %FELD1 = $$^WWWSETL(SCHLUESSEL)          ; SUCHEN ALTEN WERT ; retrieve old value
        m$.var("%FELD1").set(m$.fnc$("WWWSETL.main",SCHLUESSEL.get()));
        //<< . set blnCreated = (%FELD1="")                 ; if not created then has been modified     ; 02-Jan-2007
        mVar blnCreated = m$.var("blnCreated");
        blnCreated.set((mOp.Equal(m$.var("%FELD1").get(),"")));
        //<< . IF YFIX'=$$$YES IF blnCreated IF $PIECE(YVOR,Y,23)=4 SET NEU=9,YOK=$$$SoftFail QUIT  ;NUR AENDERUNG ERLAUBT ! SATZ NICHT VORHANDEN!  ;FIS;05-Aug-2008:YOK=$$$SoftFail added;SR15828
        if (mOp.NotEqual(YFIX.get(),include.COMSYS.$$$YES(m$))) {
          if (mOp.Logical(blnCreated.get())) {
            if (mOp.Equal(m$.Fnc.$piece(YVOR.get(),Y.get(),23),4)) {
              NEU.set(9);
              YOK.set(include.COMSYS.$$$SoftFail(m$));
              break;
            }
          }
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ; Modifying record;                    ;DATENSATZ VORHANDEN
        //<< . ; 1. If location matching in use, check if match occurs.
        //<< . ; 2. If only permitted to create returns soft fail
        //<< . ; 3. Lock management (WWW006)
        //<< . ; 4. Lock timeout (Number of seconds) - not functional
        //<< . ;-------------------------------------
        //<< . if 'blnCreated do
        if (mOp.Not(blnCreated.get())) {
          do {
            //<< . . new dteToday,strKeyTR
            mVar dteToday = m$.var("dteToday");
            mVar strKeyTR = m$.var("strKeyTR");
            m$.newVar(dteToday,strKeyTR);
            //<< . . set YAEND = $$$YES
            YAEND.set(include.COMSYS.$$$YES(m$));
            //<< . . if (YFIX'=$$$YES) && ($get(YFORM)'="") && ($$^WWWLOCATION($get(YLOCATION),YFORM,YFELD)'=$$$YES) set YOK=$$$SoftFail quit   ;KEINE BERECHTIGUNG, DA FALSCHER BETRIEB;9.4.2003;TYBD
            if ((mOp.NotEqual(YFIX.get(),include.COMSYS.$$$YES(m$))) && (mOp.NotEqual(m$.Fnc.$get(YFORM),"")) && (mOp.NotEqual(m$.fnc$("WWWLOCATION.main",m$.Fnc.$get(YLOCATION),YFORM.get(),YFELD.get()),include.COMSYS.$$$YES(m$)))) {
              YOK.set(include.COMSYS.$$$SoftFail(m$));
              break;
            }
            //<< . . if $PIECE(YVOR,Y,23)=3 set NEU=9,YOK=$$$SoftFail quit   ;AENDERUNG NICHT ERLAUBT  ;FIS;05-Aug-2008:YOK=$$$SoftFail added;SR15828
            if (mOp.Equal(m$.Fnc.$piece(YVOR.get(),Y.get(),23),3)) {
              NEU.set(9);
              YOK.set(include.COMSYS.$$$SoftFail(m$));
              break;
            }
            //<< . . ;
            //<< . . set strKeyTR = $translate(SCHLUESSEL,",()""",".//")
            strKeyTR.set(m$.Fnc.$translate(SCHLUESSEL.get(),",()\"",".//"));
            //<< . . set dteToday = +$horolog
            dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
            //<< . . ;-----------------------------------
            //<< . . ;  if Forced Save :
            //<< . . ;       kill ^WWW006 record regardless of who owns it
            //<< . . ;  else :
            //<< . . ;       if Lock Required and no lock exists - SOFT FAIL    SR14508  ; FIXME - if saving secondary data update (e.g. Receipt of Goods updates Order) may not have lock - why fail? (prob forced save in this case)
            //<< . . ;       if Lock Exists for someone else     - SOFT FAIL
            //<< . . ;-----------------------------------
            //<< . . if YFIX=$$$YES do KillLock^WWWFORMLocking(dteToday,strKeyTR)
            if (mOp.Equal(YFIX.get(),include.COMSYS.$$$YES(m$))) {
              m$.Cmd.Do("WWWFORMLocking.KillLock",dteToday.get(),strKeyTR.get());
            }
            //<< . . if (YFIX'=$$$YES) && '$$$WWW001NoLocking(YDATA) && '$data(^WWW006(0,dteToday,strKeyTR))                                     set YOK = $$$SoftFail quit  ;KEIN EIGENT‹MER DES SATZES
            if ((mOp.NotEqual(YFIX.get(),include.COMSYS.$$$YES(m$))) && mOp.Not(include.WWWConst.$$$WWW001NoLocking(m$,YDATA)) && mOp.Not(m$.Fnc.$data(m$.var("^WWW006",0,dteToday.get(),strKeyTR.get())))) {
              YOK.set(include.COMSYS.$$$SoftFail(m$));
              break;
            }
            //<< . . if (YFIX'=$$$YES) && $data(^WWW006(0,dteToday,strKeyTR,1)) && ($$$WWW006User1(^WWW006(0,dteToday,strKeyTR,1))'=$get(YUSER)) set YOK = $$$SoftFail quit  ;NICHT DER EIGENT‹MER
            if ((mOp.NotEqual(YFIX.get(),include.COMSYS.$$$YES(m$))) && mOp.Logical(m$.Fnc.$data(m$.var("^WWW006",0,dteToday.get(),strKeyTR.get(),1))) && (mOp.NotEqual(include.WWWConst.$$$WWW006User1(m$,m$.var("^WWW006",0,dteToday.get(),strKeyTR.get(),1)),m$.Fnc.$get(YUSER)))) {
              YOK.set(include.COMSYS.$$$SoftFail(m$));
              break;
            }
            //<< . . set NEU = 1
            NEU.set(1);
          } while (false);
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ; Quit if attempting to modify/change inappropriately
        //<< . ; Quit if Hard Fail or if Soft Fail and not in Forced Save Mode
        //<< . ; Quit if Soft Fail on create
        //<< . ;-------------------------------------
        //<< . quit:NEU=9
        if (mOp.Equal(NEU.get(),9)) {
          break;
        }
        //<< . quit:(YOK=$$$HardFail)
        if ((mOp.Equal(YOK.get(),include.COMSYS.$$$HardFail(m$)))) {
          break;
        }
        //<< . quit:((YFIX'=$$$YES) && (YOK=$$$SoftFail))
        if (mOp.Logical(((mOp.NotEqual(YFIX.get(),include.COMSYS.$$$YES(m$))) && (mOp.Equal(YOK.get(),include.COMSYS.$$$SoftFail(m$)))))) {
          break;
        }
        //<< . ;
        //<< . if pblnDoOnBeforeSave do
        if (mOp.Logical(pblnDoOnBeforeSave.get())) {
          //<< . . set strStatus = $$ExecuteHook^WWW001Hook(YDATEI,$$$EnumWWWEVENTTYPEOnBeforeSave,.YKEY,.YFELD,YFORM,%FELD1) ;SR17541
          strStatus.set(m$.fnc$("WWW001Hook.ExecuteHook",YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeSave(m$),YKEY,YFELD,YFORM.get(),m$.var("%FELD1").get()));
          //<< . . for intPiece=1:1:$length(YKEY,",") do
          mVar intPiece = m$.var("intPiece");
          for (intPiece.set(1);(mOp.LessOrEqual(intPiece.get(),m$.Fnc.$length(YKEY.get(),",")));intPiece.set(mOp.Add(intPiece.get(),1))) {
            //<< . . . set $piece(SCHLUESSEL,",",intPiece+1) = $$^WWWKEYBUILD($piece(YKEY,",",intPiece))        ;SR17541
            m$.pieceVar(SCHLUESSEL,",",mOp.Add(intPiece.get(),1)).set(m$.fnc$("WWWKEYBUILD.main",m$.Fnc.$piece(YKEY.get(),",",intPiece.get())));
          }
        }
        //<< . if $$$ISERR(strStatus) set YOK = $$$HardFail  quit    ;BR014960 (remove dot level so quit is to outer level)
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
          YOK.set(include.COMSYS.$$$HardFail(m$));
          break;
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ; Update Creation/Modification details
        //<< . ;
        //<< . ; YVOR D11    $$$WWW120ClassUsedInForm()
        //<< . ;      D25    $$$WWW120DataFieldEntryDate
        //<< . ;      D26    $$$WWW120DataFieldEnteredBy
        //<< . ;      D27    $$$WWW120DataFieldForDateModified
        //<< . ;      D28    $$$WWW120DataFieldForModifiedBy
        //<< . ;-------------------------------------
        //<< . if $data(YFORM) && (YFORM'="") set YVOR = $get(^WWW120(0,YFORM,1)) do  ;ERFASSUNGSDATUM/MITARBEITER
        if (mOp.Logical(m$.Fnc.$data(YFORM)) && (mOp.NotEqual(YFORM.get(),""))) {
          YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)));
          do {
            //<< . . quit:$PIECE(YVOR,Y,11)'=YDATEI                     ;FALSCHE VORGABE DER DATEI;TYBD;31,1,2004;
            if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),Y.get(),11),YDATEI.get())) {
              break;
            }
            //<< . . if $get(YQUERY)="" new YQUERY set YQUERY = "%KEY"  ;FIS;15.02.05;26751
            if (mOp.Equal(m$.Fnc.$get(m$.var("YQUERY")),"")) {
              mVar YQUERY = m$.var("YQUERY");
              m$.newVar(YQUERY);
              YQUERY.set("%KEY");
            }
            //<< . . set dteDate = $horolog
            mVar dteDate = m$.var("dteDate");
            dteDate.set(m$.Fnc.$horolog());
            //<< . . if $GET(%(YQUERY,"YTIMEFORM"))=$$$YES do  quit   ;KEIN NEUER DATENSATZ, SONDERN ZEITABHƒNGIGE ƒNDERUNG;FIS;15.02.05;26751
            if (mOp.Equal(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YTIMEFORM")),include.COMSYS.$$$YES(m$))) {
              //<< . . . set fldDateModified = +$piece(YVOR,Y,27)
              mVar fldDateModified = m$.var("fldDateModified");
              fldDateModified.set(mOp.Positive(m$.Fnc.$piece(YVOR.get(),Y.get(),27)));
              //<< . . . set fldModifiedBy   = +$piece(YVOR,Y,28)
              mVar fldModifiedBy = m$.var("fldModifiedBy");
              fldModifiedBy.set(mOp.Positive(m$.Fnc.$piece(YVOR.get(),Y.get(),28)));
              //<< . . . if fldDateModified do
              if (mOp.Logical(fldDateModified.get())) {
                //<< . . . . if $piece($get(^WWW003(0,YDATEI,fldDateModified,1)),Y,3)=1 set dteDate=+dteDate
                if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),fldDateModified.get(),1)),Y.get(),3),1)) {
                  dteDate.set(mOp.Positive(dteDate.get()));
                }
                //<< . . . . set $piece(YFELD,Y,fldDateModified)=dteDate
                m$.pieceVar(YFELD,Y.get(),fldDateModified.get()).set(dteDate.get());
              }
              //<< . . . if fldModifiedBy set $piece(YFELD,Y,fldModifiedBy)=$get(YBED)
              if (mOp.Logical(fldModifiedBy.get())) {
                m$.pieceVar(YFELD,Y.get(),fldModifiedBy.get()).set(m$.Fnc.$get(YBED));
              }
              break;
            }
            //<< . . ;
            //<< . . set fldEntryDate  = +$piece(YVOR,Y,25)
            mVar fldEntryDate = m$.var("fldEntryDate");
            fldEntryDate.set(mOp.Positive(m$.Fnc.$piece(YVOR.get(),Y.get(),25)));
            //<< . . set fldEnteredBy  = +$piece(YVOR,Y,26)
            mVar fldEnteredBy = m$.var("fldEnteredBy");
            fldEnteredBy.set(mOp.Positive(m$.Fnc.$piece(YVOR.get(),Y.get(),26)));
            //<< . . set fldCreateLocn = +$piece(YVOR,Y,132)
            mVar fldCreateLocn = m$.var("fldCreateLocn");
            fldCreateLocn.set(mOp.Positive(m$.Fnc.$piece(YVOR.get(),Y.get(),132)));
            //<< . . if fldEntryDate if ($piece(YFELD,Y,fldEntryDate)="") || blnCreated do
            if (mOp.Logical(fldEntryDate.get())) {
              if ((mOp.Equal(m$.Fnc.$piece(YFELD.get(),Y.get(),fldEntryDate.get()),"")) || mOp.Logical(blnCreated.get())) {
                //<< . . . set dteDate=$horolog
                dteDate.set(m$.Fnc.$horolog());
                //<< . . . if $piece($get(^WWW003(0,YDATEI,fldEntryDate,1)),Y,3)=1 set dteDate=+dteDate
                if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),fldEntryDate.get(),1)),Y.get(),3),1)) {
                  dteDate.set(mOp.Positive(dteDate.get()));
                }
                //<< . . . set $piece(YFELD,Y,fldEntryDate)=dteDate
                m$.pieceVar(YFELD,Y.get(),fldEntryDate.get()).set(dteDate.get());
              }
            }
            //<< . . if fldEnteredBy  if ($piece(YFELD,Y,fldEnteredBy)="")  || blnCreated set $piece(YFELD,Y,fldEnteredBy)  = $get(YBED)       ;TYBD 07.05.2002
            if (mOp.Logical(fldEnteredBy.get())) {
              if ((mOp.Equal(m$.Fnc.$piece(YFELD.get(),Y.get(),fldEnteredBy.get()),"")) || mOp.Logical(blnCreated.get())) {
                m$.pieceVar(YFELD,Y.get(),fldEnteredBy.get()).set(m$.Fnc.$get(YBED));
              }
            }
            //<< . . if fldCreateLocn if ($piece(YFELD,Y,fldCreateLocn)="") || blnCreated set $piece(YFELD,Y,fldCreateLocn) = $get(YLOCATION)  ;TYBD;09.04.2003;23440;Speichern Betrieb
            if (mOp.Logical(fldCreateLocn.get())) {
              if ((mOp.Equal(m$.Fnc.$piece(YFELD.get(),Y.get(),fldCreateLocn.get()),"")) || mOp.Logical(blnCreated.get())) {
                m$.pieceVar(YFELD,Y.get(),fldCreateLocn.get()).set(m$.Fnc.$get(YLOCATION));
              }
            }
          } while (false);
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ;FALSCHER DATENSATZ; LEERER DATENSATZ AUF GESPEICHERTE DATEIN --> Wrong datarecord; or empty
        //<< . ; Save Without Data; FormType = Standard or Grid; Empty...
        //<< . IF YFIX'=$$$YES IF $GET(YFORM)'="" IF $PIECE(YVOR,Y,80)'=$$$YES IF $PIECE(YVOR,Y,2)=1||($PIECE(YVOR,Y,2)=3) IF ($TRANSLATE(YFELD,Y)="")||($TRANSLATE(YFELD,Y)=$GET(^WWW1261(YM,YFORM,1))) IF $TRANSLATE(%FELD1,Y)'="" IF $TRANSLATE(%FELD1,Y)'=$GET(^WWW1261(YM,YFORM,1)) set YCHANGED=$$$NO QUIT  ;NICHT ;GEƒNDERT (80)
        if (mOp.NotEqual(YFIX.get(),include.COMSYS.$$$YES(m$))) {
          if (mOp.NotEqual(m$.Fnc.$get(YFORM),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),Y.get(),80),include.COMSYS.$$$YES(m$))) {
              if (mOp.Equal(m$.Fnc.$piece(YVOR.get(),Y.get(),2),1) || (mOp.Equal(m$.Fnc.$piece(YVOR.get(),Y.get(),2),3))) {
                if ((mOp.Equal(m$.Fnc.$translate(YFELD.get(),Y.get()),"")) || (mOp.Equal(m$.Fnc.$translate(YFELD.get(),Y.get()),m$.Fnc.$get(m$.var("^WWW1261",YM.get(),YFORM.get(),1))))) {
                  if (mOp.NotEqual(m$.Fnc.$translate(m$.var("%FELD1").get(),Y.get()),"")) {
                    if (mOp.NotEqual(m$.Fnc.$translate(m$.var("%FELD1").get(),Y.get()),m$.Fnc.$get(m$.var("^WWW1261",YM.get(),YFORM.get(),1)))) {
                      YCHANGED.set(include.COMSYS.$$$NO(m$));
                      break;
                    }
                  }
                }
              }
            }
          }
        }
        //<< . IF YFIX'=$$$YES IF $GET(YNEWSORT)'=1 IF $TRANSLATE(YFELD,".|;,"_Y_"""")'="" QUIT:$GET(YFELD)=$GET(%FELD1)
        if (mOp.NotEqual(YFIX.get(),include.COMSYS.$$$YES(m$))) {
          if (mOp.NotEqual(m$.Fnc.$get(YNEWSORT),1)) {
            if (mOp.NotEqual(m$.Fnc.$translate(YFELD.get(),mOp.Concat(mOp.Concat(".|;,",Y.get()),"\"")),"")) {
              if (mOp.Equal(m$.Fnc.$get(YFELD),m$.Fnc.$get(m$.var("%FELD1")))) {
                break;
              }
            }
          }
        }
        //<< . ;
        //<< . IF YDATEI="WWW013" IF $PIECE(YFELD,Y,2)'="" SET $PIECE(YFELD,Y,2) = $$SET^WWWPWDCHECK($PIECE(YFELD,Y,2))  ;TYBD;7,1,2004;VERSCHLUESSSELN PASSWORT
        if (mOp.Equal(YDATEI.get(),"WWW013")) {
          if (mOp.NotEqual(m$.Fnc.$piece(YFELD.get(),Y.get(),2),"")) {
            m$.pieceVar(YFELD,Y.get(),2).set(m$.fnc$("WWWPWDCHECK.SET",m$.Fnc.$piece(YFELD.get(),Y.get(),2)));
          }
        }
        //<< . ;
        //<< . ;
        //<< . ;W SCHLUESSEL,"/",KEY,"/",YFELD
        //<< . ;ONLY NEW IF SORTKEY;TYBD;28,10,2004
        //<< . IF $GET(YUMLAU)'="" IF $GET(YSKEY)'=YDATEI IF $DATA(^WWW002s(0,4,idxYDATEI))||($DATA(^WWW003s(0,4,idxYDATEI))) DO ^WWWSORTKEY(YDATEI)   ;SORTKEY SUCHEN ;seek
        if (mOp.NotEqual(m$.Fnc.$get(YUMLAU),"")) {
          if (mOp.NotEqual(m$.Fnc.$get(YSKEY),YDATEI.get())) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW002s",0,4,idxYDATEI.get()))) || mOp.Logical((m$.Fnc.$data(m$.var("^WWW003s",0,4,idxYDATEI.get()))))) {
              m$.Cmd.Do("WWWSORTKEY.main",YDATEI.get());
            }
          }
        }
        //<< . IF $GET(YUMLAU)=""  IF $GET(YSKEY)'=YDATEI DO
        if (mOp.Equal(m$.Fnc.$get(YUMLAU),"")) {
          if (mOp.NotEqual(m$.Fnc.$get(YSKEY),YDATEI.get())) {
            //<< . . set idClassTR = $translate(YDATEI,LC,UC)
            mVar idClassTR = m$.var("idClassTR");
            idClassTR.set(m$.Fnc.$translate(YDATEI.get(),LC.get(),UC.get()));
            //<< . . IF $DATA(^WWW002s(0,4,idClassTR)) || ($DATA(^WWW003s(0,4,idClassTR))) DO ^WWWSORTKEY(YDATEI)   ;SORTKEY SUCHEN ;seek
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW002s",0,4,idClassTR.get()))) || mOp.Logical((m$.Fnc.$data(m$.var("^WWW003s",0,4,idClassTR.get()))))) {
              m$.Cmd.Do("WWWSORTKEY.main",YDATEI.get());
            }
          }
        }
        //<< . ;
        //<< . SET SORTCHANGE=$$$YES    ;IMMER SAVE ;always save
        mVar SORTCHANGE = m$.var("SORTCHANGE");
        SORTCHANGE.set(include.COMSYS.$$$YES(m$));
        //<< . ;IF %FELD1="" SET SORTCHANGE=$$$YES  ;NEU
        //<< . ;IF SORTCHANGE=$$$NO SET SKEY="" FOR  SET SKEY=$ORDER(YSKEY(SKEY)) QUIT:SKEY=""  DO  QUIT:SORTCHANGE=$$$YES
        //<< . ;. FOR YI=1:1 SET YLFN=$PIECE(YSKEY(SKEY),",",YI) QUIT:YLFN=""  DO  QUIT:SORTCHANGE=$$$YES
        //<< . ;. . IF $EXTRACT(YLFN)="F" IF $PIECE(YFELD,Y,+$EXTRACT(YLFN,2,9))'=$PIECE(%FELD1,Y,+$EXTRACT(YLFN,2,9)) SET SORTCHANGE=$$$YES  ;TYBD;21,11,2003
        //<< . ;IF SORTCHANGE=$$$NO  DO       ;TYBD;24,11,2003;NUR BESTIMMTE BITS
        //<< . ;. SET YLFN=""
        //<< . ;. FOR  SET YLFN=$ORDER(^WWW001B(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
        //<< . ;. . IF $PIECE(YFELD,Y,YLFN)'=$PIECE(%FELD1,Y,YLFN) DO
        //<< . ;. . . SET SORTCHANGE=$$$YES
        //<< . ;. . . SET YBITLIST=$GET(YBITLIST)_YLFN_","
        //<< . ;-------------------------------------
        //<< . ;BITMAP - Kill for old record
        //<< . ; WWW001 : D12 : Other UCI                       D13 : Other Volume
        //<< . ; (YDATA)  D23 : Save Index Key In File          D24 : Bit Map Index Active (bln)          D25 : Bitmap XREF Class
        //<< . ;-------------------------------------
        //<< . IF SORTCHANGE=$$$YES IF (+$PIECE(YDATA,Y,24)=$$$YES) || ($DATA(^WWW001B(0,YDATEI))) || ($PIECE(YDATA,Y,25)'="") DO
        if (mOp.Equal(SORTCHANGE.get(),include.COMSYS.$$$YES(m$))) {
          if ((mOp.Equal(mOp.Positive(m$.Fnc.$piece(YDATA.get(),Y.get(),24)),include.COMSYS.$$$YES(m$))) || mOp.Logical((m$.Fnc.$data(m$.var("^WWW001B",0,YDATEI.get())))) || (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),Y.get(),25),""))) {
            //<< . . SET OK = $$^WWWBITSET(YDATEI,YKEY,$$$BitMapKill,%FELD1,,$GET(YBITLIST),,WWWYM,$PIECE(YDATA,Y,25))   ;BITMAP;18.06.2003;TYBD ;bit map
            mVar OK = m$.var("OK");
            OK.set(m$.fnc$("WWWBITSET.main",YDATEI.get(),YKEY.get(),include.COMSYS.$$$BitMapKill(m$),m$.var("%FELD1").get(),null,m$.Fnc.$get(m$.var("YBITLIST")),null,WWWYM.get(),m$.Fnc.$piece(YDATA.get(),Y.get(),25)));
          }
        }
        //<< . ;
        //<< . IF SORTCHANGE=$$$YES IF $PIECE($GET(YDATA),Y,8)'=4 DO  ;ALTEN SORTKEY L÷SCHEN  ;WENN NICHT CACH… ;when net using cache object
        if (mOp.Equal(SORTCHANGE.get(),include.COMSYS.$$$YES(m$))) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(YDATA),Y.get(),8),4)) {
            do {
              //<< . . QUIT:$GET(YTIMEFORM)=$$$YES     ;ZEITABHƒNIGE
              if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),include.COMSYS.$$$YES(m$))) {
                break;
              }
              //<< . . IF $DATA(YSKEY) DO              ;SORTKEY SETZEN
              if (mOp.Logical(m$.Fnc.$data(YSKEY))) {
                do {
                  //<< . . . quit:$piece(YDATA,Y,8)=6      ;ABACUS
                  if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),Y.get(),8),6)) {
                    break;
                  }
                  //<< . . . SET SKEY = ""
                  mVar SKEY = m$.var("SKEY");
                  SKEY.set("");
                  //<< . . . FOR  SET SKEY = $ORDER(YSKEY(SKEY)) QUIT:SKEY=""  DO
                  for (;true;) {
                    SKEY.set(m$.Fnc.$order(YSKEY.var(SKEY.get())));
                    if (mOp.Equal(SKEY.get(),"")) {
                      break;
                    }
                    //<< . . . . KILL YSFELD
                    m$.var("YSFELD").kill();
                    //<< . . . . KILL YSDATEI
                    m$.var("YSDATEI").kill();
                    //<< . . . . NEW YMAX,YMAX1,YMAX2,YFILES
                    mVar YMAX = m$.var("YMAX");
                    mVar YMAX1 = m$.var("YMAX1");
                    mVar YMAX2 = m$.var("YMAX2");
                    mVar YFILES = m$.var("YFILES");
                    m$.newVar(YMAX,YMAX1,YMAX2,YFILES);
                    //<< . . . . SET YFILES=YDATEI_"s"
                    YFILES.set(mOp.Concat(YDATEI.get(),"s"));
                    //<< . . . . IF $PIECE(YDATA,Y,23)'="" SET YFILES=$PIECE(YDATA,Y,23)  ;ANDERE DATEI ;data file
                    if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),Y.get(),23),"")) {
                      YFILES.set(m$.Fnc.$piece(YDATA.get(),Y.get(),23));
                    }
                    //<< . . . . //SET YSDATEI="^"_YFILES_"("_WWWYM_SKEY     SR15452
                    //<< . . . . SET YSDATEI="^"_YFILES_"("_strYM_SKEY
                    mVar YSDATEI = m$.var("YSDATEI");
                    YSDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILES.get()),"("),strYM.get()),SKEY.get()));
                    //<< . . . . IF $PIECE(YDATA,Y,12)'="" IF $PIECE(YDATA,Y,13)'="" DO  ;UCI UND VOL ;UCI And
                    if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),Y.get(),12),"")) {
                      if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),Y.get(),13),"")) {
                        //<< . . . . . SET YSDATEI="^["""_$PIECE(YDATA,Y,12)_""","""_$PIECE(YDATA,Y,13)_"""]"_$PIECE(YSDATEI,"^",2,999)
                        YSDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[\"",m$.Fnc.$piece(YDATA.get(),Y.get(),12)),"\",\""),m$.Fnc.$piece(YDATA.get(),Y.get(),13)),"\"]"),m$.Fnc.$piece(YSDATEI.get(),"^",2,999)));
                      }
                    }
                    //<< . . . . SET YMAX=1
                    YMAX.set(1);
                    //<< . . . . SET YSDATEI(YMAX)=YSDATEI
                    YSDATEI.var(YMAX.get()).set(YSDATEI.get());
                    //<< . . . . FOR YI=1:1 SET YLFN=$PIECE(YSKEY(SKEY),",",YI) QUIT:YLFN=""  DO
                    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                      mVar YLFN = m$.var("YLFN");
                      YLFN.set(m$.Fnc.$piece(YSKEY.var(SKEY.get()).get(),",",YI.get()));
                      if (mOp.Equal(YLFN.get(),"")) {
                        break;
                      }
                      //<< . . . . . ;IF $EXTRACT(YLFN)="F" I $PIECE(YFELD,Y,+$EXTRACT(YLFN,2,9))=$PIECE(%FELD1,Y,+$EXTRACT(YLFN,2,9)) Q  ;TYBD;21,11,2003
                      //<< . . . . . IF $EXTRACT(YLFN)="F" SET YSFELD(YI)=$PIECE(%FELD1,Y,+$EXTRACT(YLFN,2,9))
                      if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                        mVar YSFELD = m$.var("YSFELD");
                        YSFELD.var(YI.get()).set(m$.Fnc.$piece(m$.var("%FELD1").get(),Y.get(),mOp.Positive(m$.Fnc.$extract(YLFN.get(),2,9))));
                      }
                      //<< . . . . . IF $EXTRACT(YLFN)="K" SET YSFELD(YI)=$PIECE(YKEY,",",+$EXTRACT(YLFN,2,9))
                      if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                        mVar YSFELD = m$.var("YSFELD");
                        YSFELD.var(YI.get()).set(m$.Fnc.$piece(YKEY.get(),",",mOp.Positive(m$.Fnc.$extract(YLFN.get(),2,9))));
                      }
                      //<< . . . . . IF YI=1 DO   ;WENN ERSTER KEY ;when premier KEY
                      if (mOp.Equal(YI.get(),1)) {
                        //<< . . . . . . FOR  QUIT:$EXTRACT(YSFELD(YI))'=";"  SET YSFELD(YI) = $EXTRACT(YSFELD(YI),2,200)
                        for (;true;) {
                          if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YSFELD").var(YI.get()).get()),";")) {
                            break;
                          }
                          mVar YSFELD = m$.var("YSFELD");
                          YSFELD.var(YI.get()).set(m$.Fnc.$extract(m$.var("YSFELD").var(YI.get()).get(),2,200));
                        }
                        //<< . . . . . . IF $EXTRACT($REVERSE(YSFELD(YI)))=";" FOR  QUIT:$EXTRACT($REVERSE(YSFELD(YI)))'=";"  SET YSFELD(YI) = $RE($EXTRACT($RE(YSFELD(YI)),2,200))  ;TYBD;23,10,2004
                        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YSFELD").var(YI.get()).get())),";")) {
                          for (;true;) {
                            if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YSFELD").var(YI.get()).get())),";")) {
                              break;
                            }
                            mVar YSFELD = m$.var("YSFELD");
                            YSFELD.var(YI.get()).set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YSFELD").var(YI.get()).get()),2,200)));
                          }
                        }
                        //<< . . . . . . SET YMAX=$LENGTH(YSFELD(YI),";")  ;ANZAHL DER ";" FELDER IM FELD
                        YMAX.set(m$.Fnc.$length(m$.var("YSFELD").var(YI.get()).get(),";"));
                        //<< . . . . . . FOR YMAX1=1:1:YMAX SET YSDATEI(YMAX1)=YSDATEI
                        for (YMAX1.set(1);(mOp.LessOrEqual(YMAX1.get(),YMAX.get()));YMAX1.set(mOp.Add(YMAX1.get(),1))) {
                          YSDATEI.var(YMAX1.get()).set(YSDATEI.get());
                        }
                      }
                      //<< . . . . . IF YSFELD(YI)="" SET YSFELD(YI)=" "
                      if (mOp.Equal(m$.var("YSFELD").var(YI.get()).get(),"")) {
                        mVar YSFELD = m$.var("YSFELD");
                        YSFELD.var(YI.get()).set(" ");
                      }
                      //<< . . . . . FOR YMAX1=1:1:YMAX DO
                      for (YMAX1.set(1);(mOp.LessOrEqual(YMAX1.get(),YMAX.get()));YMAX1.set(mOp.Add(YMAX1.get(),1))) {
                        //<< . . . . . . SET YMAX2=YMAX1
                        YMAX2.set(YMAX1.get());
                        //<< . . . . . . IF YMAX=1 SET YMAX2=200  ;ANZAHL DER ";" FELDER IN DATENFELD
                        if (mOp.Equal(YMAX.get(),1)) {
                          YMAX2.set(200);
                        }
                        //<< . . . . . . IF YI=1 DO
                        if (mOp.Equal(YI.get(),1)) {
                          //<< . . . . . . . IF $EXTRACT(YLFN)="F" IF YUMLAU'="" SET YSFELD(YMAX1,YI) = $EXTRACT($$^WWWUMLAU($PIECE(YSFELD(YI),";",YMAX1,YMAX2),1),1,150)  ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                          if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                            if (mOp.NotEqual(YUMLAU.get(),"")) {
                              mVar YSFELD = m$.var("YSFELD");
                              YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(m$.var("YSFELD").var(YI.get()).get(),";",YMAX1.get(),YMAX2.get()),1),1,150));
                            }
                          }
                          //<< . . . . . . . IF $EXTRACT(YLFN)="F" IF YUMLAU=""  SET YSFELD(YMAX1,YI) = $EXTRACT($TRANSLATE($PIECE(YSFELD(YI),";",YMAX1,YMAX2),LC,UC),1,150)  ;SPEED UP;TYBD;25.09.2004 ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                          if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                            if (mOp.Equal(YUMLAU.get(),"")) {
                              mVar YSFELD = m$.var("YSFELD");
                              YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSFELD").var(YI.get()).get(),";",YMAX1.get(),YMAX2.get()),LC.get(),UC.get()),1,150));
                            }
                          }
                          //<< . . . . . . . IF $EXTRACT(YLFN)="K" IF YUMLAU=""  SET YSFELD(YMAX1,YI) = $EXTRACT($TRANSLATE(YSFELD(YI),LC,UC),1,150)
                          if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                            if (mOp.Equal(YUMLAU.get(),"")) {
                              mVar YSFELD = m$.var("YSFELD");
                              YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YSFELD").var(YI.get()).get(),LC.get(),UC.get()),1,150));
                            }
                          }
                          //<< . . . . . . . IF $EXTRACT(YLFN)="K" IF YUMLAU'="" SET YSFELD(YMAX1,YI) = $EXTRACT($$^WWWUMLAU(YSFELD(YI),1),1,150)
                          if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                            if (mOp.NotEqual(YUMLAU.get(),"")) {
                              mVar YSFELD = m$.var("YSFELD");
                              YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.var("YSFELD").var(YI.get()).get(),1),1,150));
                            }
                          }
                          //<< . . . . . . . IF YSFELD(YMAX1,YI)="" SET YSFELD(YMAX1,YI)=" "
                          if (mOp.Equal(m$.var("YSFELD").var(YMAX1.get(),YI.get()).get(),"")) {
                            mVar YSFELD = m$.var("YSFELD");
                            YSFELD.var(YMAX1.get(),YI.get()).set(" ");
                          }
                          //<< . . . . . . . SET YSDATEI(YMAX1)=YSDATEI(YMAX1)_","""_YSFELD(YMAX1,YI)_""""
                          YSDATEI.var(YMAX1.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),",\""),m$.var("YSFELD").var(YMAX1.get(),YI.get()).get()),"\""));
                        }
                        //<< . . . . . . IF YI'=1 DO  ;TYBD;NEU WEGEN FEHLER; WENN MEHRFACH UND UNTERSORT, DANN WURDE NUR DAS ERSTE FELD GENOMMEN
                        if (mOp.NotEqual(YI.get(),1)) {
                          //<< . . . . . . . IF $EXTRACT(YLFN)="F" IF YUMLAU'="" SET YSFELD(YMAX1,YI) = $EXTRACT($$^WWWUMLAU(YSFELD(YI),1),1,150)  ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                          if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                            if (mOp.NotEqual(YUMLAU.get(),"")) {
                              mVar YSFELD = m$.var("YSFELD");
                              YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.var("YSFELD").var(YI.get()).get(),1),1,150));
                            }
                          }
                          //<< . . . . . . . IF $EXTRACT(YLFN)="F" IF YUMLAU=""  SET YSFELD(YMAX1,YI) = $EXTRACT($TRANSLATE(YSFELD(YI),LC,UC),1,150)  ;SPEED UP;TYBD;25.09.2004 ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                          if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                            if (mOp.Equal(YUMLAU.get(),"")) {
                              mVar YSFELD = m$.var("YSFELD");
                              YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YSFELD").var(YI.get()).get(),LC.get(),UC.get()),1,150));
                            }
                          }
                          //<< . . . . . . . IF $EXTRACT(YLFN)="K" IF YUMLAU=""  SET YSFELD(YMAX1,YI) = $EXTRACT($TRANSLATE(YSFELD(YI),LC,UC),1,150)
                          if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                            if (mOp.Equal(YUMLAU.get(),"")) {
                              mVar YSFELD = m$.var("YSFELD");
                              YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YSFELD").var(YI.get()).get(),LC.get(),UC.get()),1,150));
                            }
                          }
                          //<< . . . . . . . IF $EXTRACT(YLFN)="K" IF YUMLAU'="" SET YSFELD(YMAX1,YI) = $EXTRACT($$^WWWUMLAU(YSFELD(YI),1),1,150)
                          if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                            if (mOp.NotEqual(YUMLAU.get(),"")) {
                              mVar YSFELD = m$.var("YSFELD");
                              YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.var("YSFELD").var(YI.get()).get(),1),1,150));
                            }
                          }
                          //<< . . . . . . . IF YSFELD(YMAX1,YI)="" SET YSFELD(YMAX1,YI)=" "
                          if (mOp.Equal(m$.var("YSFELD").var(YMAX1.get(),YI.get()).get(),"")) {
                            mVar YSFELD = m$.var("YSFELD");
                            YSFELD.var(YMAX1.get(),YI.get()).set(" ");
                          }
                          //<< . . . . . . . SET YSDATEI(YMAX1) = YSDATEI(YMAX1)_","""_YSFELD(YMAX1,YI)_""""
                          YSDATEI.var(YMAX1.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),",\""),m$.var("YSFELD").var(YMAX1.get(),YI.get()).get()),"\""));
                        }
                      }
                    }
                    //<< . . . . FOR YMAX1=1:1:YMAX DO
                    for (YMAX1.set(1);(mOp.LessOrEqual(YMAX1.get(),YMAX.get()));YMAX1.set(mOp.Add(YMAX1.get(),1))) {
                      do {
                        //<< . . . . . SET YQ=1
                        mVar YQ = m$.var("YQ");
                        YQ.set(1);
                        //<< . . . . . FOR YI=1:1:MAXKEY SET KEY = $PIECE(YKEY,",",YI) SET YSDATEI(YMAX1) = YSDATEI(YMAX1)_","""_KEY_"""" IF KEY="" SET YQ=0
                        for (YI.set(1);(mOp.LessOrEqual(YI.get(),MAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
                          mVar KEY = m$.var("KEY");
                          KEY.set(m$.Fnc.$piece(YKEY.get(),",",YI.get()));
                          YSDATEI.var(YMAX1.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),",\""),KEY.get()),"\""));
                          if (mOp.Equal(KEY.get(),"")) {
                            YQ.set(0);
                          }
                        }
                        //<< . . . . . SET YSDATEI(YMAX1)=YSDATEI(YMAX1)_")"
                        YSDATEI.var(YMAX1.get()).set(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),")"));
                        //<< . . . . . QUIT:YQ=0
                        if (mOp.Equal(YQ.get(),0)) {
                          break;
                        }
                        //<< . . . . . KILL @YSDATEI(YMAX1)
                        m$.indirectVar(YSDATEI.var(YMAX1.get()).get()).kill();
                      } while (false);
                    }
                  }
                } while (false);
              }
            } while (false);
          }
        }
        //<< . ;-------------------------------------
        //<< . ;IF $GET(%FELD1)'="" IF $GET(YFORM)'=""  SET YVOR=$GET(^WWW120(0,YFORM,1)) DO   ;Change Date
        //<< . SET $PIECE(YVOR,Y,29)=$$$YES  ;When no YFORM, always log changes ; TYBD;18,11,2003
        m$.pieceVar(YVOR,Y.get(),29).set(include.COMSYS.$$$YES(m$));
        //<< . IF $GET(YFORM)'=""  SET YVOR=$GET(^WWW120(0,YFORM,1))
        if (mOp.NotEqual(m$.Fnc.$get(YFORM),"")) {
          YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)));
        }
        //<< . DO                            ;Change Date ;FIS;14.11.03;24627
        do {
          //<< . . NEW YI,YCHECK
          mVar YCHECK = m$.var("YCHECK");
          m$.newVar(YI,YCHECK);
          //<< . . SET YCHANGED = $$$NO  ;NICHT GEƒNDERT ;Not
          YCHANGED.set(include.COMSYS.$$$NO(m$));
          //<< . . QUIT:$GET(YFELD)=$GET(%FELD1)  ;KEINE ƒNDERUNG;FIS;20.07.04 ;no alteration
          if (mOp.Equal(m$.Fnc.$get(YFELD),m$.Fnc.$get(m$.var("%FELD1")))) {
            break;
          }
          //<< . . SET YCHANGED = $$$YES  ;GEƒNDERT
          YCHANGED.set(include.COMSYS.$$$YES(m$));
          //<< . . SET YCHECK(1)=$TRANSLATE($GET(YFELD),".|, """)
          YCHECK.var(1).set(m$.Fnc.$translate(m$.Fnc.$get(YFELD),".|, \""));
          //<< . . SET YCHECK(2)=$TRANSLATE($GET(%FELD1),".|, """)
          YCHECK.var(2).set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("%FELD1")),".|, \""));
          //<< . . ;
          //<< . . set fldDateModified = +$piece(YVOR,Y,27)
          mVar fldDateModified = m$.var("fldDateModified");
          fldDateModified.set(mOp.Positive(m$.Fnc.$piece(YVOR.get(),Y.get(),27)));
          //<< . . set fldModifiedBy   = +$piece(YVOR,Y,28)
          mVar fldModifiedBy = m$.var("fldModifiedBy");
          fldModifiedBy.set(mOp.Positive(m$.Fnc.$piece(YVOR.get(),Y.get(),28)));
          //<< . . FOR YI=1,2 IF fldDateModified SET $PIECE(YCHECK(YI),Y,fldDateModified)=""  ;PR‹FUNG OHNE ƒNDERUNGSDATUM, DA MEISTENS $H -> +$H GEWANDELT ;FIS;27.08.04;26327
          for (Object _YI: new Object[] {1,2}) {
            YI.set(_YI);
            if (mOp.Logical(fldDateModified.get())) {
              m$.pieceVar(YCHECK.var(_YI),Y.get(),fldDateModified.get()).set("");
            }
          }
          //<< . . QUIT:YCHECK(1)=YCHECK(2)  ;UNWESENTLICHE ƒNDERUNG;FIS;27.08.04;26327
          if (mOp.Equal(YCHECK.var(1).get(),YCHECK.var(2).get())) {
            break;
          }
          //<< . . QUIT:$PIECE(YVOR,Y,11)'=YDATEI  ;FALSCHE VORGABE DER DATEI;TYBD;31,1,2004;
          if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),Y.get(),11),YDATEI.get())) {
            break;
          }
          //<< . . IF $GET(%FELD1)'="" IF fldDateModified SET $PIECE(YFELD,Y,fldDateModified) = $HOROLOG
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("%FELD1")),"")) {
            if (mOp.Logical(fldDateModified.get())) {
              m$.pieceVar(YFELD,Y.get(),fldDateModified.get()).set(m$.Fnc.$horolog());
            }
          }
          //<< . . IF $GET(%FELD1)'="" IF fldModifiedBy   SET $PIECE(YFELD,Y,fldModifiedBy)   = $GET(YBED)
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("%FELD1")),"")) {
            if (mOp.Logical(fldModifiedBy.get())) {
              m$.pieceVar(YFELD,Y.get(),fldModifiedBy.get()).set(m$.Fnc.$get(YBED));
            }
          }
          //<< . . ;
          //<< . . if $get(^SysSetup(15069)) && ($get(YDATEI)="INDRPDEMAND") && $$$INDRPDEMANDDemandClosed(YFELD) && '$$$INDRPDEMANDDemandClosed(%FELD1) do StackDump^COMDebug(+$h_" Demand closed",YKEY)
          if (mOp.Logical(m$.Fnc.$get(m$.var("^SysSetup",15069))) && (mOp.Equal(m$.Fnc.$get(YDATEI),"INDRPDEMAND")) && mOp.Logical(include.INConst.$$$INDRPDEMANDDemandClosed(m$,YFELD)) && mOp.Not(include.INConst.$$$INDRPDEMANDDemandClosed(m$,m$.var("%FELD1")))) {
            m$.Cmd.Do("COMDebug.StackDump",mOp.Concat(mOp.Positive(m$.Fnc.$horolog())," Demand closed"),YKEY.get());
          }
          //<< . . if $get(YUSER)'="" if $data(^mtempRecordFile("Record",YUSER)) do MacroRecordData^WWWRECORD(YM,YDATEI,YKEY,YFELD)  ; PPP
          if (mOp.NotEqual(m$.Fnc.$get(YUSER),"")) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^mtempRecordFile","Record",YUSER.get())))) {
              m$.Cmd.Do("WWWRECORD.MacroRecordData",YM.get(),YDATEI.get(),YKEY.get(),YFELD.get());
            }
          }
          //<< . . ;
          //<< . . if $piece(YVOR,Y,29)=$$$YES do  ;PROTOKOLLDATEI   ; $$$WWW120ModificationsProtocol
          if (mOp.Equal(m$.Fnc.$piece(YVOR.get(),Y.get(),29),include.COMSYS.$$$YES(m$))) {
            do {
              //<< . . . quit:YKEY=""
              if (mOp.Equal(YKEY.get(),"")) {
                break;
              }
              //<< . . . quit:YDATEI=""
              if (mOp.Equal(YDATEI.get(),"")) {
                break;
              }
              //<< . . . quit:$get(YBED)=""
              if (mOp.Equal(m$.Fnc.$get(YBED),"")) {
                break;
              }
              //<< . . . new dteToday,strKeyTR,tmeToday
              mVar dteToday = m$.var("dteToday");
              mVar strKeyTR = m$.var("strKeyTR");
              mVar tmeToday = m$.var("tmeToday");
              m$.newVar(dteToday,strKeyTR,tmeToday);
              //<< . . . set dteToday = $horolog                              ; 02-Jan-2007
              dteToday.set(m$.Fnc.$horolog());
              //<< . . . set tmeToday = $piece(dteToday,",",2),dteToday = +dteToday
              tmeToday.set(m$.Fnc.$piece(dteToday.get(),",",2));
              dteToday.set(mOp.Positive(dteToday.get()));
              //<< . . . set strKeyTR = $translate(YKEY,"/",",")
              strKeyTR.set(m$.Fnc.$translate(YKEY.get(),"/",","));
              //<< . . . for  quit:'$data(^WWWPRO(YM,YDATEI,dteToday,tmeToday,YBED,strKeyTR,0,1))  set tmeToday=tmeToday+.1
              for (;true;) {
                if (mOp.Not(m$.Fnc.$data(m$.var("^WWWPRO",YM.get(),YDATEI.get(),dteToday.get(),tmeToday.get(),YBED.get(),strKeyTR.get(),0,1)))) {
                  break;
                }
                tmeToday.set(mOp.Add(tmeToday.get(),.1));
              }
              //<< . . . set ^WWWPRO(YM,YDATEI,dteToday,tmeToday,YBED,strKeyTR,0,1) = $get(%FELD1)   ; old version
              m$.var("^WWWPRO",YM.get(),YDATEI.get(),dteToday.get(),tmeToday.get(),YBED.get(),strKeyTR.get(),0,1).set(m$.Fnc.$get(m$.var("%FELD1")));
              //<< . . . set ^WWWPRO(YM,YDATEI,dteToday,tmeToday,YBED,strKeyTR,1,1) = YFELD          ; new version
              m$.var("^WWWPRO",YM.get(),YDATEI.get(),dteToday.get(),tmeToday.get(),YBED.get(),strKeyTR.get(),1,1).set(YFELD.get());
              //<< . . . set ^WWWLAST(YM,YDATEI,strKeyTR,$horolog,1)                = YFELD
              m$.var("^WWWLAST",YM.get(),YDATEI.get(),strKeyTR.get(),m$.Fnc.$horolog(),1).set(YFELD.get());
            } while (false);
          }
        } while(false);
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ;  ACTUAL SAVE
        //<< . ;-------------------------------------
        //<< . SET YA=$$^WWWSETS(SCHLUESSEL,YFELD,.strStatus)                ;SPEICHERN DATENSATZ ;Save data record  ; SR15571
        mVar YA = m$.var("YA");
        YA.set(m$.fnc$("WWWSETS.main",SCHLUESSEL.get(),YFELD.get(),strStatus));
        //<< . if $$$ISERR(strStatus) || (YA'=$$$QSave) set YOK = $$$HardFail QUIT                                   ; SR15571, SR14114
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus)) || (mOp.NotEqual(YA.get(),include.COMSYSWWW.$$$QSave(m$)))) {
          YOK.set(include.COMSYS.$$$HardFail(m$));
          break;
        }
        //<< . set strStatus = $$ConvertOnSave^COMConversion(YDATEI,YKEY)   ; SR15622 Version 1 => Version 2
        strStatus.set(m$.fnc$("COMConversion.ConvertOnSave",YDATEI.get(),YKEY.get()));
        //<< . if $$$ISERR(strStatus) set YOK = $$$HardFail QUIT
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
          YOK.set(include.COMSYS.$$$HardFail(m$));
          break;
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ;
        //<< . ;BITMAP - Save for new record      ;18.06.2003;TYBD
        //<< . ; WWW001 (YDATA) : D24 : Bit Map Index Active (bln)          D25 : Bitmap XREF Class
        //<< . ;-------------------------------------
        //<< . IF SORTCHANGE=$$$YES IF (+$PIECE(YDATA,Y,24)=$$$YES) || ($DATA(^WWW001B(0,YDATEI))) || ($PIECE(YDATA,Y,25)'="") DO
        if (mOp.Equal(SORTCHANGE.get(),include.COMSYS.$$$YES(m$))) {
          if ((mOp.Equal(mOp.Positive(m$.Fnc.$piece(YDATA.get(),Y.get(),24)),include.COMSYS.$$$YES(m$))) || mOp.Logical((m$.Fnc.$data(m$.var("^WWW001B",0,YDATEI.get())))) || (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),Y.get(),25),""))) {
            //<< . . SET OK=$$^WWWBITSET(YDATEI,YKEY,$$$BitMapSet,YFELD,,$GET(YBITLIST),,WWWYM,$PIECE(YDATA,Y,25))   ;BITMAP;18.06.2003;TYBD ;bit map
            mVar OK = m$.var("OK");
            OK.set(m$.fnc$("WWWBITSET.main",YDATEI.get(),YKEY.get(),include.COMSYS.$$$BitMapSet(m$),YFELD.get(),null,m$.Fnc.$get(m$.var("YBITLIST")),null,WWWYM.get(),m$.Fnc.$piece(YDATA.get(),Y.get(),25)));
          }
        }
        //<< . ;-------------------------------------
        //<< . ; Prepare record lock if not forced save
        //<< . ;-------------------------------------
        //<< . IF $GET(YUSER)'="" IF $GET(YFIX)'=1 SET ^WWW006(0,+$HOROLOG,$TRANSLATE(SCHLUESSEL,",()""",".//"),1)=YUSER_Y_$PIECE($HOROLOG,",",2)
        if (mOp.NotEqual(m$.Fnc.$get(YUSER),"")) {
          if (mOp.NotEqual(m$.Fnc.$get(YFIX),1)) {
            m$.var("^WWW006",0,mOp.Positive(m$.Fnc.$horolog()),m$.Fnc.$translate(SCHLUESSEL.get(),",()\"",".//"),1).set(mOp.Concat(mOp.Concat(YUSER.get(),Y.get()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2)));
          }
        }
        //<< . ;-------------------------------------
        //<< . SET YOK = $$$SaveOkay
        YOK.set(include.COMSYS.$$$SaveOkay(m$));
        //<< . IF NEU'=0 SET YOK = NEU  ;KEINE AENDERUNG DES DATENSATZES   ; record not changed
        if (mOp.NotEqual(NEU.get(),0)) {
          YOK.set(NEU.get());
        }
        //<< . IF SORTCHANGE=$$$YES IF $PIECE($GET(YDATA),Y,8)'=4 DO  ;NICHT BEI CACH… ;Not next to
        if (mOp.Equal(SORTCHANGE.get(),include.COMSYS.$$$YES(m$))) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(YDATA),Y.get(),8),4)) {
            do {
              //<< . . QUIT:$GET(YTIMEFORM)=$$$YES                      ;ZEITABHƒNIGE
              if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),include.COMSYS.$$$YES(m$))) {
                break;
              }
              //<< . . IF $PIECE($GET(^WWW001(0,YDATEI,1)),Y,8)=6 QUIT  ;ABACUS
              if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)),Y.get(),8),6)) {
                break;
              }
              //<< . . ;
              //<< . . SET SKEY = ""
              mVar SKEY = m$.var("SKEY");
              SKEY.set("");
              //<< . . FOR  SET SKEY = $ORDER(YSKEY(SKEY)) QUIT:SKEY=""  DO
              for (;true;) {
                SKEY.set(m$.Fnc.$order(YSKEY.var(SKEY.get())));
                if (mOp.Equal(SKEY.get(),"")) {
                  break;
                }
                //<< . . . KILL YSFELD
                m$.var("YSFELD").kill();
                //<< . . . KILL YSDATEI
                m$.var("YSDATEI").kill();
                //<< . . . NEW YMAX,YMAX1,YMAX2,YFILES
                mVar YMAX = m$.var("YMAX");
                mVar YMAX1 = m$.var("YMAX1");
                mVar YMAX2 = m$.var("YMAX2");
                mVar YFILES = m$.var("YFILES");
                m$.newVar(YMAX,YMAX1,YMAX2,YFILES);
                //<< . . . SET YFILES = YDATEI_"s"
                YFILES.set(mOp.Concat(YDATEI.get(),"s"));
                //<< . . . IF $PIECE(YDATA,Y,23)'="" SET YFILES = $PIECE(YDATA,Y,23)  ;ANDERE DATEI ;data file
                if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),Y.get(),23),"")) {
                  YFILES.set(m$.Fnc.$piece(YDATA.get(),Y.get(),23));
                }
                //<< . . . SET YSDATEI = "^"_YFILES_"("_strYM_SKEY
                mVar YSDATEI = m$.var("YSDATEI");
                YSDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILES.get()),"("),strYM.get()),SKEY.get()));
                //<< . . . IF $PIECE(YDATA,Y,12)'="" IF $PIECE(YDATA,Y,13)'="" DO  ;UCI UND VOL ;UCI And
                if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),Y.get(),12),"")) {
                  if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),Y.get(),13),"")) {
                    //<< . . . . SET YSDATEI="^["""_$PIECE(YDATA,Y,12)_""","""_$PIECE(YDATA,Y,13)_"""]"_$PIECE(YSDATEI,"^",2,999)
                    YSDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[\"",m$.Fnc.$piece(YDATA.get(),Y.get(),12)),"\",\""),m$.Fnc.$piece(YDATA.get(),Y.get(),13)),"\"]"),m$.Fnc.$piece(YSDATEI.get(),"^",2,999)));
                  }
                }
                //<< . . . SET YMAX=1
                YMAX.set(1);
                //<< . . . SET YSDATEI(YMAX)=YSDATEI
                YSDATEI.var(YMAX.get()).set(YSDATEI.get());
                //<< . . . FOR YI=1:1 SET YLFN=$PIECE(YSKEY(SKEY),",",YI) QUIT:YLFN=""  DO
                for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                  mVar YLFN = m$.var("YLFN");
                  YLFN.set(m$.Fnc.$piece(YSKEY.var(SKEY.get()).get(),",",YI.get()));
                  if (mOp.Equal(YLFN.get(),"")) {
                    break;
                  }
                  //<< . . . . IF $EXTRACT(YLFN)="F" SET YSFELD(YI) = $PIECE(YFELD,Y,+$EXTRACT(YLFN,2,9))  ;TYBD;JETZT YFELD ;presently
                  if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                    mVar YSFELD = m$.var("YSFELD");
                    YSFELD.var(YI.get()).set(m$.Fnc.$piece(YFELD.get(),Y.get(),mOp.Positive(m$.Fnc.$extract(YLFN.get(),2,9))));
                  }
                  //<< . . . . IF $EXTRACT(YLFN)="K" SET YSFELD(YI) = $PIECE(YKEY,",",+$EXTRACT(YLFN,2,9))
                  if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                    mVar YSFELD = m$.var("YSFELD");
                    YSFELD.var(YI.get()).set(m$.Fnc.$piece(YKEY.get(),",",mOp.Positive(m$.Fnc.$extract(YLFN.get(),2,9))));
                  }
                  //<< . . . . IF YI=1 DO                                          ;WENN ERSTER KEY ;when first KEY
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
                    //<< . . . . . SET YMAX=$LENGTH(YSFELD(YI),";")                  ;ANZAHL DER ";" FELDER IM FELD
                    YMAX.set(m$.Fnc.$length(m$.var("YSFELD").var(YI.get()).get(),";"));
                    //<< . . . . . FOR YMAX1=1:1:YMAX SET YSDATEI(YMAX1)=YSDATEI
                    for (YMAX1.set(1);(mOp.LessOrEqual(YMAX1.get(),YMAX.get()));YMAX1.set(mOp.Add(YMAX1.get(),1))) {
                      YSDATEI.var(YMAX1.get()).set(YSDATEI.get());
                    }
                  }
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
                      //<< . . . . . . IF $EXTRACT(YLFN)="F" DO
                      if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                        //<< . . . . . . . IF YUMLAU'="" SET YSFELD(YMAX1,YI) = $EXTRACT($$^WWWUMLAU($PIECE(YSFELD(YI),";",YMAX1,YMAX2),1),1,150)     ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                        if (mOp.NotEqual(YUMLAU.get(),"")) {
                          mVar YSFELD = m$.var("YSFELD");
                          YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(m$.var("YSFELD").var(YI.get()).get(),";",YMAX1.get(),YMAX2.get()),1),1,150));
                        }
                        //<< . . . . . . . IF YUMLAU=""  SET YSFELD(YMAX1,YI) = $EXTRACT($TRANSLATE($PIECE(YSFELD(YI),";",YMAX1,YMAX2),LC,UC),1,150)  ;SPEED UP;TYBD;25.09.2004 ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                        if (mOp.Equal(YUMLAU.get(),"")) {
                          mVar YSFELD = m$.var("YSFELD");
                          YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSFELD").var(YI.get()).get(),";",YMAX1.get(),YMAX2.get()),LC.get(),UC.get()),1,150));
                        }
                      }
                      //<< . . . . . . IF $EXTRACT(YLFN)="K" DO
                      if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                        //<< . . . . . . . IF YUMLAU=""  SET YSFELD(YMAX1,YI) = $EXTRACT($TRANSLATE(YSFELD(YI),LC,UC),1,150)
                        if (mOp.Equal(YUMLAU.get(),"")) {
                          mVar YSFELD = m$.var("YSFELD");
                          YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YSFELD").var(YI.get()).get(),LC.get(),UC.get()),1,150));
                        }
                        //<< . . . . . . . IF YUMLAU'="" SET YSFELD(YMAX1,YI) = $EXTRACT($$^WWWUMLAU(YSFELD(YI),1),1,150)
                        if (mOp.NotEqual(YUMLAU.get(),"")) {
                          mVar YSFELD = m$.var("YSFELD");
                          YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.var("YSFELD").var(YI.get()).get(),1),1,150));
                        }
                      }
                      //<< . . . . . . IF YSFELD(YMAX1,YI)="" SET YSFELD(YMAX1,YI) = " "
                      if (mOp.Equal(m$.var("YSFELD").var(YMAX1.get(),YI.get()).get(),"")) {
                        mVar YSFELD = m$.var("YSFELD");
                        YSFELD.var(YMAX1.get(),YI.get()).set(" ");
                      }
                      //<< . . . . . . SET YSDATEI(YMAX1) = YSDATEI(YMAX1)_","""_YSFELD(YMAX1,YI)_""""
                      YSDATEI.var(YMAX1.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),",\""),m$.var("YSFELD").var(YMAX1.get(),YI.get()).get()),"\""));
                    }
                    //<< . . . . . ;
                    //<< . . . . . IF YI'=1 DO  ;TYBD;NEU WEGEN FEHLER; WENN MEHRFACH UND UNTERSORT, DANN WURDE NUR DAS ERSTE FELD GENOMMEN
                    if (mOp.NotEqual(YI.get(),1)) {
                      //<< . . . . . . IF $EXTRACT(YLFN)="F" DO
                      if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"F")) {
                        //<< . . . . . . . IF YUMLAU'="" SET YSFELD(YMAX1,YI) = $EXTRACT($$^WWWUMLAU(YSFELD(YI),1),1,150)     ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                        if (mOp.NotEqual(YUMLAU.get(),"")) {
                          mVar YSFELD = m$.var("YSFELD");
                          YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.var("YSFELD").var(YI.get()).get(),1),1,150));
                        }
                        //<< . . . . . . . IF YUMLAU=""  SET YSFELD(YMAX1,YI) = $EXTRACT($TRANSLATE(YSFELD(YI),LC,UC),1,150)  ;SPEED UP;TYBD;25.09.2004 ;KEINE UMLAUTE;TYBD;6,10,2004;26526
                        if (mOp.Equal(YUMLAU.get(),"")) {
                          mVar YSFELD = m$.var("YSFELD");
                          YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YSFELD").var(YI.get()).get(),LC.get(),UC.get()),1,150));
                        }
                      }
                      //<< . . . . . . IF $EXTRACT(YLFN)="K" DO
                      if (mOp.Equal(m$.Fnc.$extract(YLFN.get()),"K")) {
                        //<< . . . . . . . IF YUMLAU=""  SET YSFELD(YMAX1,YI) = $EXTRACT($TRANSLATE(YSFELD(YI),LC,UC),1,150)
                        if (mOp.Equal(YUMLAU.get(),"")) {
                          mVar YSFELD = m$.var("YSFELD");
                          YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YSFELD").var(YI.get()).get(),LC.get(),UC.get()),1,150));
                        }
                        //<< . . . . . . . IF YUMLAU'="" SET YSFELD(YMAX1,YI) = $EXTRACT($$^WWWUMLAU(YSFELD(YI),1),1,150)
                        if (mOp.NotEqual(YUMLAU.get(),"")) {
                          mVar YSFELD = m$.var("YSFELD");
                          YSFELD.var(YMAX1.get(),YI.get()).set(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.var("YSFELD").var(YI.get()).get(),1),1,150));
                        }
                      }
                      //<< . . . . . . IF YSFELD(YMAX1,YI)="" SET YSFELD(YMAX1,YI) = " "
                      if (mOp.Equal(m$.var("YSFELD").var(YMAX1.get(),YI.get()).get(),"")) {
                        mVar YSFELD = m$.var("YSFELD");
                        YSFELD.var(YMAX1.get(),YI.get()).set(" ");
                      }
                      //<< . . . . . . SET YSDATEI(YMAX1) = YSDATEI(YMAX1)_","""_YSFELD(YMAX1,YI)_""""
                      YSDATEI.var(YMAX1.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),",\""),m$.var("YSFELD").var(YMAX1.get(),YI.get()).get()),"\""));
                    }
                  }
                }
                //<< . . . ;
                //<< . . . FOR YMAX1=1:1:YMAX DO
                for (YMAX1.set(1);(mOp.LessOrEqual(YMAX1.get(),YMAX.get()));YMAX1.set(mOp.Add(YMAX1.get(),1))) {
                  do {
                    //<< . . . . SET YQ = 1
                    mVar YQ = m$.var("YQ");
                    YQ.set(1);
                    //<< . . . . FOR YI=1:1:MAXKEY DO
                    for (YI.set(1);(mOp.LessOrEqual(YI.get(),MAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
                      //<< . . . . . SET KEY            = $PIECE(YKEY,",",YI)
                      mVar KEY = m$.var("KEY");
                      KEY.set(m$.Fnc.$piece(YKEY.get(),",",YI.get()));
                      //<< . . . . . SET YSDATEI(YMAX1) = YSDATEI(YMAX1)_","""_KEY_""""
                      YSDATEI.var(YMAX1.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),",\""),KEY.get()),"\""));
                      //<< . . . . . IF KEY="" SET YQ = 0
                      if (mOp.Equal(KEY.get(),"")) {
                        YQ.set(0);
                      }
                    }
                    //<< . . . . SET YSDATEI(YMAX1) = YSDATEI(YMAX1)_")"
                    YSDATEI.var(YMAX1.get()).set(mOp.Concat(YSDATEI.var(YMAX1.get()).get(),")"));
                    //<< . . . . QUIT:YQ=0
                    if (mOp.Equal(YQ.get(),0)) {
                      break;
                    }
                    //<< . . . . SET @YSDATEI(YMAX1) = ""
                    m$.indirectVar(YSDATEI.var(YMAX1.get()).get()).set("");
                  } while (false);
                }
              }
            } while (false);
          }
        }
      } while (false);
    }
    //<< 
    //<< ; End save transaction
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if $$$ISERR(strStatus) && (YOK = $$$HardFail) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus)) && (mOp.Equal(YOK.get(),include.COMSYS.$$$HardFail(m$)))) {
      //<< do ForceRollBack(.strStatus)
      m$.Cmd.Do("ForceRollBack",strStatus);
    }
    //<< } else {
    else {
      //<< if $TLEVEL>0 TCOMMIT
      if (mOp.Greater(m$.Fnc.$tlevel(),0)) {
      }
      //<< $$$LogRx("TC:")
      $$$LogRx(m$,"TC:");
    }
    //<< }
    //<< set $ZTRAP=strZTRAP
    $ZTRAP.set(strZTRAP.get());
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< ;---------------------------------------
    //<< ; Post-Save Processing
    //<< ;---------------------------------------
    //<< 
    //<< if YOK=$$$SaveOkay {
    if (mOp.Equal(YOK.get(),include.COMSYS.$$$SaveOkay(m$))) {
      //<< if (YCHANGED=$$$YES) && ($get(YEINMAL)'=1) {
      if ((mOp.Equal(YCHANGED.get(),include.COMSYS.$$$YES(m$))) && (mOp.NotEqual(m$.Fnc.$get(YEINMAL),1))) {
        //<< do PopulateIndex^COMQuickSearch(YDATEI,YKEY) // SR12522
        m$.Cmd.Do("COMQuickSearch.PopulateIndex",YDATEI.get(),YKEY.get());
        //<< 
        //<< SET OK = $$handleRelevantEvents^COMDCMControlModule("INTRAPREND",YDATEI,"save",YKEY,YFELD,,$$GetCheckSum^COMDCMUtilities($get(%FELD1),YVOR))  ;INTRAPREND=KENNUNG F‹R @-NET MANAGER
        mVar OK = m$.var("OK");
        OK.set(m$.fnc$("COMDCMControlModule.handleRelevantEvents","INTRAPREND",YDATEI.get(),"save",YKEY.get(),YFELD.get(),null,m$.fnc$("COMDCMUtilities.GetCheckSum",m$.Fnc.$get(m$.var("%FELD1")),YVOR.get())));
        //<< IF '$PIECE(OK,Y,1) IF $GET(YBED)'="" IF $GET(YFORM)'="" SET ^WWWWV(YM,YBED,$PIECE($HOROLOG,",",1),YFORM,YKEY,1)=$PIECE($HOROLOG,",",1)_Y_$PIECE($HOROLOG,",",2)_Y_YBED_Y_$PIECE(OK,Y,2)
        if (mOp.Not(m$.Fnc.$piece(OK.get(),Y.get(),1))) {
          if (mOp.NotEqual(m$.Fnc.$get(YBED),"")) {
            if (mOp.NotEqual(m$.Fnc.$get(YFORM),"")) {
              m$.var("^WWWWV",YM.get(),YBED.get(),m$.Fnc.$piece(m$.Fnc.$horolog(),",",1),YFORM.get(),YKEY.get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$horolog(),",",1),Y.get()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2)),Y.get()),YBED.get()),Y.get()),m$.Fnc.$piece(OK.get(),Y.get(),2)));
            }
          }
        }
      }
      //<< }
      //<< 
      //<< //Exports the current @NM artifact, if necessary (YDATEI=global name)
      //<< //do ##class(SourceControl.Exporter).TagNMArtifactByNameKey(YDATEI,YKEY)
      //<< 
      //<< set strStatus = $$ExecuteHook^WWW001Hook(YDATEI,$$$EnumWWWEVENTTYPEOnAfterSave,YKEY,.YFELD,YFORM,%FELD1)
      strStatus.set(m$.fnc$("WWW001Hook.ExecuteHook",YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnAfterSave(m$),YKEY.get(),YFELD,YFORM.get(),m$.var("%FELD1").get()));
    }
    //<< // FIXME : should postprocessing failure lead to rollback of save? (We are after TCOMMIT/TROLLBACK here)
    //<< //         How do we resubmit post-processing in the event of a failure?
    //<< }
    //<< quit YOK
    return YOK.get();
  }

  //<< 
  //<< 
  //<< ForceRollBack(&strStatus) ; Manual rollback enty point
  public Object ForceRollBack(Object ... _p) {
    mVar strStatus = m$.newVarRef("strStatus",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 30-Sep-2008   GRF     SR15947: reset $zerror
    //<< ; 17-Sep-2008   Luke    SR15833: created
    //<< ;-------------------------------------------------------------------------------
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< TROLLBACK
    //<< $$$LogRx("TR:1")
    $$$LogRx(m$,"TR:1");
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< set $ZERROR = strStatus
    mVar $ZERROR = m$.var("$ZERROR");
    $ZERROR.set(strStatus.get());
    //<< do BACKGROUND^WWWERROR  ;save error log
    m$.Cmd.Do("WWWERROR.BACKGROUND");
    //<< set $ZERROR = ""
    $ZERROR.set("");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnSaveError()
  public Object OnSaveError(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;  Handle Syntax Error during Save Transaction
    //<< ;
    //<< ; ByRefs:  strStatus (Error Text to handle in WWWSAVE)
    //<< ;          strZTRAP  (Original Error Handling)
    //<< ;
    //<< ; Returns: $$$HardFail
    //<< ;
    //<< ; History:
    //<< ; 08-Aug-2008   FIS     SR15835: created
    //<< ;-------------------------------------------------------------------------------
    //<< new strError
    mVar strError = m$.var("strError");
    m$.newVar(strError);
    //<< 
    //<< set strError = $ZERROR
    strError.set(m$.Fnc.$zerror());
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< TROLLBACK
    //<< $$$LogRx("TR:2")
    $$$LogRx(m$,"TR:2");
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if (strError = "") {  //save failed without real error
    if ((mOp.Equal(strError.get(),""))) {
      //<< quit $$$SoftFail          ; FIXME : <GRF> Is this reasonable?  May be syntax error or similar in ExecuteOn... command.
      return include.COMSYS.$$$SoftFail(m$);
    }
    //<< }
    //<< set $ZERROR = strError
    mVar $ZERROR = m$.var("$ZERROR");
    $ZERROR.set(strError.get());
    //<< do BACKGROUND^WWWERROR  ;save error log
    m$.Cmd.Do("WWWERROR.BACKGROUND");
    //<< ; "An Internal ERROR Has Occurred In Your Application."
    //<< set strStatus = $$$MakeStatus($$^WWWTEXT(387)_"|Info : "_$piece($piece($ZERROR,"<",2),">",1)_"|Prog.: "_$piece($ZERROR,">",2,9))  ;display error message in WWWSAVE
    mVar strStatus = m$.var("strStatus");
    strStatus.set(include.COMSYS.$$$MakeStatus(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",387),"|Info : "),m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$zerror(),"<",2),">",1)),"|Prog.: "),m$.Fnc.$piece(m$.Fnc.$zerror(),">",2,9))));
    //<< set $ZERROR = ""
    $ZERROR.set("");
    //<< quit $$$HardFail
    return include.COMSYS.$$$HardFail(m$);
  }

  //<< 
  //<< 
  //<< SAVE(YDATEI,YKEY,YFELD,YFIX,YNEWSORT,YEINMAL)
  public Object SAVE(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YFIX = m$.newVarRef("YFIX",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YNEWSORT = m$.newVarRef("YNEWSORT",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar YEINMAL = m$.newVarRef("YEINMAL",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   same as normal
    //<< ;
    //<< ; Params:
    //<< ; FIXME : Should this have strStatus as well? <GRF>
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Aug-2006   JW      SR14803: Return YOK
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YFORM,YVOR,YOK,YSKEY
    mVar YFORM = m$.var("YFORM");
    mVar YVOR = m$.var("YVOR");
    mVar YOK = m$.var("YOK");
    mVar YSKEY = m$.var("YSKEY");
    m$.newVar(YFORM,YVOR,YOK,YSKEY);
    //<< 
    //<< SET YOK = $$WWWSPEI($GET(YDATEI),$GET(YKEY),$GET(YFELD),$GET(YFIX),$GET(YNEWSORT),$GET(YEINMAL))
    YOK.set(m$.fnc$("_WWWSPEI",m$.Fnc.$get(YDATEI),m$.Fnc.$get(YKEY),m$.Fnc.$get(YFELD),m$.Fnc.$get(YFIX),m$.Fnc.$get(YNEWSORT),m$.Fnc.$get(YEINMAL)));
    //<< QUIT YOK
    return YOK.get();
  }

//<< 
}
