//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSAVE
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:30
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

//<< WWWSAVE
public class WWWSAVE extends mClass {

  public void main() {
    _WWWSAVE();
  }

  public void _WWWSAVE() {
    START();
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Description of Function :
  //<< ;       SPEICHERN FORMULAR
  //<< ;
  //<< ; JW - Note: A manual form does not run OnBeforeSave code.
  //<< ;
  //<< ; Called by : User.www.cls based on entry point in form.
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< ; -----  Entry point drops through to START  -----
  //<< 
  //<< START
  public void START() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History :
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
    //<< ; 04-Nov-2009   shobby  SR16935: Restrictions on 'Demo' User are now determined by
    //<< ;                           whether 'User Acess' as 33-Demo User.  Rather than
    //<< ;                           being hardcoded to the user DEMO.
    //<< ; 06-Nov-2008   shobby  SR16123: Standardised routine to determine InputType
    //<< ; 16-Oct-2008   FIS     SR15947: UNDEF problem corrected; Re-done changes for
    //<< ;                           readabilty as $ztrap must be in same line; Turned
    //<< ;                           logic around to wrap Save and AfterSave as one
    //<< ;                           unit by default
    //<< ; 16-Oct-2008   GRF     SR15947: $get added around strTStatus since getting
    //<< ;                           UNDEFINED error (Not setting when form switch is
    //<< ;                           off); break up multi-set for readability.
    //<< ; 02-Oct-2008   FIS     SR15947: Use DoNotPrepareHTMLSkeleton flag for old
    //<< ;                           execute as well
    //<< ; 30-Sep-2008   FIS     SR15947: Changed WWWTransactionTable into
    //<< ;                           WWWTransactionLine
    //<< ; 29-Sep-2008   FIS     SR15947: Option to Trigger OnSave and OnAfterSave as one
    //<< ;                           Transaction Unit
    //<< ; 26-Sep-2008   FIS     SR15947: Transaction Wrapper for "Execute After Save"
    //<< ;                           implemented
    //<< ; 07-Aug-2008   FIS     SR15828: compare stored data with WWWDATEN2 to stop save
    //<< ;                           if data has been changed by a different process.
    //<< ;                           Not activated yet because it also gets checked in
    //<< ;                           BeforeSave^WWWFORMValidation (might be enough)
    //<< ; 04-Aug-2008   FIS     SR15824: keep record as readonly even when the lock
    //<< ;                           has been released (data may be not up to date)
    //<< ; 12-Dec-2007   shobby  SRBR014737: If idType can't be found from the form
    //<< ;                           use the class.
    //<< ; 26-Nov-2007   GM/Shobby   SRBR014737: Get values from $$get^WWW122()
    //<< ; 05-Nov-2007   shobby  SRBR014748: Use standard routine to validate password.
    //<< ; 22-May-2007   RGB     SRBR014456: Added the pblnDoOnBeforeSave parameter
    //<< ;                           for the WWWSPEI call
    //<< ; 13-Mar-2007   GRF     SR12505: Doco
    //<< ; 21-Sep-2006   JW      SR15062: Removed FINGLBankRecon exception
    //<< ; 08-Aug-2006   JW      SR13594: Cleaned up. Brace syntax
    //<< ; 07-Feb-2006   JW      SR13305: FINGLBankRecon exception.
    //<< ; 18-Jul-2006   JW      SR14862: Decode VARHooks status
    //<< ; 13-Apr-2006   SC      SR14414: Moved VARHooks to WWWSPEI. Pass strStatus to
    //<< ;                           SPEI byref, allows VARCode to return an error msg.
    //<< ;                           Display error if returned.
    //<< ; 09-Dec-2005   JW      SR13195: Quit if trying to overwrite stored data
    //<< ; 31-Oct-2005   GRF     SR13627: Doco
    //<< ; 02-Sep-2005   JW      SR12966: Fixed WWWUSER locks
    //<< ; 16-Aug-2005   JW      SR12290: Get old YFELD to compare against.
    //<< ; 07-Jul-2005   shobby  SR12892: WWW126,WWW1261,WWW1262 are no longer shared.
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 05.08.1997    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< new (%request,%session,%KEY,%,%ZCS,%CGIEVAR)
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ; YVOR      objWWW120       Form Definition ^WWW120(0,YFORM,1)
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< DO ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< 
    //<< SET $ZTRAP="^WWWERROR"
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("^WWWERROR");
    //<< IF YUSER'="" DO
    if (mOp.NotEqual(m$.var("YUSER").get(),"")) {
      //<< . SET $$$WWWUSERHTMLStarted(^WWWUSER(0,YUSER,1))=""
      include.WWWConst.$$$WWWUSERHTMLStartedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
      //<< . SET $$$WWWUSERBODYStarted(^WWWUSER(0,YUSER,1))=""
      include.WWWConst.$$$WWWUSERBODYStartedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
      //<< . SET $$$WWWUSERFormStarted(^WWWUSER(0,YUSER,1))=""
      include.WWWConst.$$$WWWUSERFormStartedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
      //<< . SET $$$WWWUSERFormHeaderDisplayed(^WWWUSER(0,YUSER,1))=""
      include.WWWConst.$$$WWWUSERFormHeaderDisplayedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
    }
    //<< 
    //<< IF $GET(YHYPER)'=1 IF $GET(%(YQUERY,"YEND"))'=1 DO  DO ^WWWFORM QUIT  ;UNVOLLSTAENDIG!KEIN SAVE
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHYPER")),1)) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YEND")),1)) {
        //<< . IF YFORM'="" KILL ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"D")
        if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
          m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D").kill();
        }
        m$.Cmd.Do("WWWFORM.main");
        return;
      }
    }
    //<< 
    //<< IF YTRAKT0=1 KILL ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"D") DO ^WWWFORM QUIT  ;FALSCHE TRANSAKTIONSNR
    if (mOp.Equal(m$.var("YTRAKT0").get(),1)) {
      m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D").kill();
      m$.Cmd.Do("WWWFORM.main");
      return;
    }
    //<< 
    //<< IF $GET(YSCREENM)=1 KILL ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"D") DO ^WWWFORM QUIT  ;SCREEN EDIT FUNKTION
    if (mOp.Equal(m$.Fnc.$get(m$.var("YSCREENM")),1)) {
      m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D").kill();
      m$.Cmd.Do("WWWFORM.main");
      return;
    }
    //<< 
    //<< ;OPTIONEN SICHERN UND NEUSTART ;safeguard And
    //<< IF YFORM'="" IF YOPTION="" IF $DATA(%(YQUERY,"Y"_YFORM_"O1")) IF $EXTRACT(YOPEN,5,8)="HELP" SET %("VAR","EP")="WWWHELP" DO ^WWWHELP QUIT  ;HILFE BEI OPTION;TYBD;8,7,2004;26060;
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      if (mOp.Equal(m$.var("YOPTION").get(),"")) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"O1"))))) {
          if (mOp.Equal(m$.Fnc.$extract(m$.var("YOPEN").get(),5,8),"HELP")) {
            m$.var("%","VAR","EP").set("WWWHELP");
            m$.Cmd.Do("WWWHELP.main");
            return;
          }
        }
      }
    }
    //<< 
    //<< IF YFORM'="" IF YOPTION="" IF $DATA(%(YQUERY,"Y"_YFORM_"O1")) SET YOPTION=%(YQUERY,"Y"_YFORM_"O1") DO  DO ^WWWFORM QUIT
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      if (mOp.Equal(m$.var("YOPTION").get(),"")) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"O1"))))) {
          mVar YOPTION = m$.var("YOPTION");
          YOPTION.set(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"O1")).get());
          //<< . KILL ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"D")
          m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D").kill();
          //<< . SET YI=""
          mVar YI = m$.var("YI");
          YI.set("");
          //<< . FOR  SET YI=$ORDER(%(YQUERY,"Y"_YFORM_"O1",YI)) QUIT:YI=""  DO
          for (;true;) {
            YI.set(m$.Fnc.$order(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"O1"),YI.get())));
            if (mOp.Equal(YI.get(),"")) {
              break;
            }
            //<< . . SET:YOPTION'="" YOPTION=YOPTION_";"
            if (mOp.NotEqual(YOPTION.get(),"")) {
              YOPTION.set(mOp.Concat(YOPTION.get(),";"));
            }
            //<< . . IF $GET(%(YQUERY,"Y"_YFORM_"O1",YI))'="" SET YOPTION=YOPTION_$GET(%(YQUERY,"Y"_YFORM_"O1",YI))
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"O1"),YI.get())),"")) {
              YOPTION.set(mOp.Concat(YOPTION.get(),m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"O1"),YI.get()))));
            }
          }
          //<< . ;
          //<< . SET %("VAR","YOPTION")=YOPTION
          m$.var("%","VAR","YOPTION").set(YOPTION.get());
          m$.Cmd.Do("WWWFORM.main");
          return;
        }
      }
    }
    //<< 
    //<< SET YTIMEFORM = $GET(%(YQUERY,"YTIMEFORM"))  ;SAVE EINER ZEITABHÄNGIGEN ERFASSUNG      ;unit logging
    mVar YTIMEFORM = m$.var("YTIMEFORM");
    YTIMEFORM.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YTIMEFORM")));
    //<< SET YOPEN     = $GET(%(YQUERY,"YOPEN"))      ;OPEN ODER SAVE                       <-- Setting of YOPEN
    mVar YOPEN = m$.var("YOPEN");
    YOPEN.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YOPEN")));
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ;YOPEN=0  = SAVE
    //<< ;YOPEN=1  = OPEN
    //<< ;YOPEN=1x = Open the last record
    //<< ;YOPEN=2  = SAVE SEITENWECHSEL - save page overflows
    //<< ;YOPEN="SAVE"_XXXXX = Special save with function
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< IF $EXTRACT(YOPEN)=1 SET YOPEN1 = $EXTRACT(YOPEN,2,99) SET YOPEN=1  ;VORLETZTER DATENSATZ ;data record
    if (mOp.Equal(m$.Fnc.$extract(YOPEN.get()),1)) {
      mVar YOPEN1 = m$.var("YOPEN1");
      YOPEN1.set(m$.Fnc.$extract(YOPEN.get(),2,99));
      YOPEN.set(1);
    }
    //<< 
    //<< IF YFORM=""                   DO ^WWWINFO($$^WWWTEXT(35))         quit    ; "No Form Default"
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",35));
      return;
    }
    //<< IF '$DATA(^WWW120(0,YFORM,1)) DO ^WWWINFO($$^WWWTEXT(35))         quit    ; "No Form Default"
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW120",0,m$.var("YFORM").get(),1)))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",35));
      return;
    }
    //<< SET YKFEHL=0
    mVar YKFEHL = m$.var("YKFEHL");
    YKFEHL.set(0);
    //<< DO ^WWWSAVV  ;VORGABEN AUS CGI ;out of
    m$.Cmd.Do("WWWSAVV.main");
    //<< if YOPEN="X"                  DO ^WWWINFO($$^WWWTEXT("WWW00035")) quit    ; "Cannot save, record already exists."
    if (mOp.Equal(YOPEN.get(),"X")) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main","WWW00035"));
      return;
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ; sets
    //<< ;   YALLKEY
    //<< ;   YVOR
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< IF $EXTRACT(YOPEN,1,6)="SAVEWV" DO   ;WIEDERVORLAGEN
    if (mOp.Equal(m$.Fnc.$extract(YOPEN.get(),1,6),"SAVEWV")) {
      //<< . NEW DATE,HW,YDATEI,YBED1
      mVar DATE = m$.var("DATE");
      mVar HW = m$.var("HW");
      mVar YDATEI = m$.var("YDATEI");
      mVar YBED1 = m$.var("YBED1");
      m$.newVarBlock(1,DATE,HW,YDATEI,YBED1);
      //<< . SET YBED1=YBED
      YBED1.set(m$.var("YBED").get());
      //<< . SET HW=$PIECE(YOPEN," ",2,99)
      HW.set(m$.Fnc.$piece(YOPEN.get()," ",2,99));
      //<< . IF $PIECE(HW," ",1)'="" IF $DATA(^WWW013(0,$PIECE(HW," ",1),1)) SET YBED1=$PIECE(HW," ",1) SET HW=$PIECE(HW," ",2,99)  ;WIEDERVORLAGE AND JEMANDEN ANDERES
      if (mOp.NotEqual(m$.Fnc.$piece(HW.get()," ",1),"")) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW013",0,m$.Fnc.$piece(HW.get()," ",1),1)))) {
          YBED1.set(m$.Fnc.$piece(HW.get()," ",1));
          HW.set(m$.Fnc.$piece(HW.get()," ",2,99));
        }
      }
      //<< . SET DATE = $$^WWWDATE1($EXTRACT($PIECE(YOPEN," ",1),7,20))
      DATE.set(m$.fnc$("WWWDATE1.main",m$.Fnc.$extract(m$.Fnc.$piece(YOPEN.get()," ",1),7,20)));
      //<< . IF +DATE=0 SET DATE = +$HOROLOG
      if (mOp.Equal(mOp.Positive(DATE.get()),0)) {
        DATE.set(mOp.Positive(m$.Fnc.$horolog()));
      }
      //<< . IF +DATE'=0 DO
      if (mOp.NotEqual(mOp.Positive(DATE.get()),0)) {
        //<< . . SET YDATEI=$$$WWW120ClassUsedInForm(YVOR)
        YDATEI.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.var("YVOR")));
        //<< . . SET YMAXKEY=0
        mVar YMAXKEY = m$.var("YMAXKEY");
        YMAXKEY.set(0);
        //<< . . IF YDATEI'="" SET YMAXKEY=+$ORDER(^WWW002(0,YDATEI,""),-1)
        if (mOp.NotEqual(YDATEI.get(),"")) {
          YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
        }
        //<< . . SET YKEY=""
        mVar YKEY = m$.var("YKEY");
        YKEY.set("");
        //<< . . FOR YI=1:1:YMAXKEY QUIT:'$DATA(YKEY(1))  SET YKEY=YKEY_YKEY(YI) IF YI'=YMAXKEY IF $GET(YKEY(YI+1))'="" SET YKEY=YKEY_","
        mVar YI = m$.var("YI");
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
          if (mOp.Not(m$.Fnc.$data(YKEY.var(1)))) {
            break;
          }
          YKEY.set(mOp.Concat(YKEY.get(),YKEY.var(YI.get()).get()));
          if (mOp.NotEqual(YI.get(),YMAXKEY.get())) {
            if (mOp.NotEqual(m$.Fnc.$get(YKEY.var(mOp.Add(YI.get(),1))),"")) {
              YKEY.set(mOp.Concat(YKEY.get(),","));
            }
          }
        }
        //<< . . SET ^WWWWV(YM,YBED1,DATE,YFORM,$TRANSLATE(YKEY,",","/"),1)=+$HOROLOG_Y_$PIECE($HOROLOG,",",2)_Y_YBED_Y_HW
        m$.var("^WWWWV",m$.var("YM").get(),YBED1.get(),DATE.get(),m$.var("YFORM").get(),m$.Fnc.$translate(YKEY.get(),",","/"),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Positive(m$.Fnc.$horolog()),m$.var("Y").get()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2)),m$.var("Y").get()),m$.var("YBED").get()),m$.var("Y").get()),HW.get()));
      }
      //<< . ;
      //<< . SET YOPEN=2
      YOPEN.set(2);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< 
    //<< ;SPECIAL VARIABLE
    //<< IF $ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V",""))'="" DO
    if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","")),"")) {
      //<< . NEW YVAR
      mVar YVAR = m$.var("YVAR");
      m$.newVarBlock(1,YVAR);
      //<< . SET YVAR=""
      YVAR.set("");
      //<< . FOR  SET YVAR=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V",YVAR)) QUIT:YVAR=""  DO
      for (;true;) {
        YVAR.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",YVAR.get())));
        if (mOp.Equal(YVAR.get(),"")) {
          break;
        }
        //<< . . SET %(YQUERY,YVAR)=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V",YVAR,1))
        m$.var("%",m$.var("YQUERY").get(),YVAR.get()).set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",YVAR.get(),1)));
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< KILL ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V")
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V").kill();
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Form Type 8  : WIZARD
    //<< ;-------------------------------------------------------------------------------
    //<< IF $$$WWW120FormType(YVOR)=8 DO  QUIT
    if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),8)) {
      //<< . do Wizard()
      m$.Cmd.Do("Wizard");
      return;
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Form Type 6  : MENU INPUT TYPE
    //<< ;-------------------------------------------------------------------------------
    //<< IF $$$WWW120FormType(YVOR)=6 DO  QUIT
    if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),6)) {
      //<< . IF $EXTRACT(YOPEN,5,8)="HELP" SET %("VAR","EP")="WWWHELP" DO ^WWWHELP       ;ZUM HILFETEXT
      if (mOp.Equal(m$.Fnc.$extract(YOPEN.get(),5,8),"HELP")) {
        m$.var("%","VAR","EP").set("WWWHELP");
        m$.Cmd.Do("WWWHELP.main");
      }
      return;
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Form Type 7  : SEARCH ENGINE
    //<< ;-------------------------------------------------------------------------------
    //<< IF $$$WWW120FormType(YVOR)=7 DO  QUIT
    if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),7)) {
      do {
        //<< . IF $EXTRACT(YOPEN,5,8)="HELP" SET %("VAR","EP")="WWWHELP" DO ^WWWHELP QUIT  ;ZUM HILFETEXT
        if (mOp.Equal(m$.Fnc.$extract(YOPEN.get(),5,8),"HELP")) {
          m$.var("%","VAR","EP").set("WWWHELP");
          m$.Cmd.Do("WWWHELP.main");
          break;
        }
        //<< . DO ^WWWFORM   ;SUCHMASCHINE
        m$.Cmd.Do("WWWFORM.main");
      } while (false);
      return;
    }
    //<< 
    //<< ;--------------
    //<< 
    //<< SET YDATEI = $$$WWW120ClassUsedInForm(YVOR)
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.var("YVOR")));
    //<< 
    //<< ;-------------------
    //<< ;New Tab
    //<< ;-------------------
    //<< IF YOPEN=2 SET YQ=0 DO  KILL ^WWWDUMMY(YUSER) QUIT:YQ=1   ;NUR SEITENWECHSEL ;only
    if (mOp.Equal(YOPEN.get(),2)) {
      mVar YQ = m$.var("YQ");
      YQ.set(0);
      //<< . SET YABBR=0
      mVar YABBR = m$.var("YABBR");
      YABBR.set(0);
      //<< . IF YDATEI'="" SET YI="" FOR  SET YI=$ORDER(^WWW002(0,YDATEI,YI)) QUIT:YI=""  DO  QUIT:YABBR=1   ;PRIMÄRSCHL.
      if (mOp.NotEqual(YDATEI.get(),"")) {
        mVar YI = m$.var("YI");
        YI.set("");
        for (;true;) {
          YI.set(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),YI.get())));
          if (mOp.Equal(YI.get(),"")) {
            break;
          }
          do {
            //<< . . SET YTYP=$PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)
            mVar YTYP = m$.var("YTYP");
            YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),YI.get(),1)),m$.var("Y").get(),3));
            //<< . . ;DO PRUEFP^WWWSAVP  ;PRUEFEN KEY
            //<< . . IF '$DATA(YKEY(YI)) SET YABBR=1 QUIT
            if (mOp.Not(m$.Fnc.$data(m$.var("YKEY").var(YI.get())))) {
              YABBR.set(1);
              break;
            }
            //<< . . IF YKEY(YI)="" SET YABBR=1 QUIT
            if (mOp.Equal(m$.var("YKEY").var(YI.get()).get(),"")) {
              YABBR.set(1);
              break;
            }
            //<< . . SET YKEY(YI)=$$GetInternal^WWWTR(YTYP,YKEY(YI))
            mVar YKEY = m$.var("YKEY");
            YKEY.var(YI.get()).set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),m$.var("YKEY").var(YI.get()).get()));
          } while (false);
          if (mOp.Equal(YABBR.get(),1)) {
            break;
          }
        }
      }
      //<< . ;
      //<< . IF YDATEI'="" SET YI="" FOR  SET YI=$ORDER(^WWW003(0,YDATEI,YI)) QUIT:YI=""  DO
      if (mOp.NotEqual(YDATEI.get(),"")) {
        mVar YI = m$.var("YI");
        YI.set("");
        for (;true;) {
          YI.set(m$.Fnc.$order(m$.var("^WWW003",0,YDATEI.get(),YI.get())));
          if (mOp.Equal(YI.get(),"")) {
            break;
          }
          //<< . . set YTYP = $$GetInputType(YDATEI,YI,YFORM)
          mVar YTYP = m$.var("YTYP");
          YTYP.set(m$.fnc$("GetInputType",YDATEI.get(),YI.get(),m$.var("YFORM").get()));
          //<< . . SET $PIECE(YFELD,Y,YI)=$$GetInternal^WWWTR(YTYP,$PIECE(YFELD,Y,YI))
          m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),YI.get()).set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),YI.get())));
        }
      }
      //<< . ;
      //<< . SET ^WWWDUMMY(YUSER,"P") = $GET(YKEY(1))_","_$GET(YKEY(2))_","_$GET(YKEY(3))_","_$GET(YKEY(4))_","_$GET(YKEY(5))_","_$GET(YKEY(6))_","_$GET(YKEY(7))_","_$GET(YKEY(8))
      m$.var("^WWWDUMMY",m$.var("YUSER").get(),"P").set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YKEY").var(1)),","),m$.Fnc.$get(m$.var("YKEY").var(2))),","),m$.Fnc.$get(m$.var("YKEY").var(3))),","),m$.Fnc.$get(m$.var("YKEY").var(4))),","),m$.Fnc.$get(m$.var("YKEY").var(5))),","),m$.Fnc.$get(m$.var("YKEY").var(6))),","),m$.Fnc.$get(m$.var("YKEY").var(7))),","),m$.Fnc.$get(m$.var("YKEY").var(8))));
      //<< . SET ^WWWDUMMY(YUSER,"D") = YFELD
      m$.var("^WWWDUMMY",m$.var("YUSER").get(),"D").set(m$.var("YFELD").get());
      //<< . SET ^WWWDUMMY(YUSER,"M") = YMFELD
      m$.var("^WWWDUMMY",m$.var("YUSER").get(),"M").set(m$.var("YMFELD").get());
      //<< . IF $GET(YTIMEFORM)=1 DO
      if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),1)) {
        //<< . . SET %("VAR","YFORM")=YFORM_"t"  ;ZEITABHÄNGIGE VORGABE ;default
        m$.var("%","VAR","YFORM").set(mOp.Concat(m$.var("YFORM").get(),"t"));
        //<< . . IF YDATEI'="" DO                ;SICHER DATEN FÜR SEITENWECHSEL ;sure to
        if (mOp.NotEqual(YDATEI.get(),"")) {
          //<< . . . SET YMAXKEY=+$ORDER(^WWW002(0,YDATEI,""),-1)
          mVar YMAXKEY = m$.var("YMAXKEY");
          YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
          //<< . . . SET $PIECE(^WWWDUMMY(YUSER,"P"),",",YMAXKEY+1) = $$^WWWDATE1($GET(%(YQUERY,"Y"_YFORM_"P"_(YMAXKEY+1))))
          m$.pieceVar(m$.var("^WWWDUMMY",m$.var("YUSER").get(),"P"),",",mOp.Add(YMAXKEY.get(),1)).set(m$.fnc$("WWWDATE1.main",m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P"),(mOp.Add(YMAXKEY.get(),1)))))));
        }
      }
      //<< . ;
      //<< . DO ^WWWFORM SET YQ=1
      m$.Cmd.Do("WWWFORM.main");
      YQ.set(1);
      m$.var("^WWWDUMMY",m$.var("YUSER").get()).kill();
      if (mOp.Equal(YQ.get(),1)) {
        return;
      }
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Form Type 1  : STANDARD FORM
    //<< ; Form Type 3  : GRID FORM
    //<< ;-------------------------------------------------------------------------------
    //<< IF $$$WWW120SaveAlsoWithoutDataFields(YVOR)'=1 IF $$$WWW120FormType(YVOR)=1||($$$WWW120FormType(YVOR)=3) IF YOPEN=0||(YOPEN=2) IF YFELD=$GET(^WWW1261(YM,YFORM,1)) DO
    if (mOp.NotEqual(include.WWWConst.$$$WWW120SaveAlsoWithoutDataFields(m$,m$.var("YVOR")),1)) {
      if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),1) || (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),3))) {
        if (mOp.Equal(YOPEN.get(),0) || (mOp.Equal(YOPEN.get(),2))) {
          if (mOp.Equal(m$.var("YFELD").get(),m$.Fnc.$get(m$.var("^WWW1261",m$.var("YM").get(),m$.var("YFORM").get(),1)))) {
            do {
              //<< . IF $$$WWW120FormType(YVOR)=3 IF $GET(YMAXKEY)=1 QUIT  ;NICHT;TYBD;13,10,2004
              if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),3)) {
                if (mOp.Equal(m$.Fnc.$get(m$.var("YMAXKEY")),1)) {
                  break;
                }
              }
              //<< . SET YOPEN=1    ;NEUER DATENSATZ OHNE WERTE SPEICHERN ODER NICHT ;data record without Save Or Not
              YOPEN.set(1);
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< ;ALTE VORGABE SCHLUESSEL UND ÖFFNEN ALTEN DATENSATZ ;default And unclose data record
    //<< IF $GET(YOPEN1)'="" IF (YALLKEY=1) || (YALLKEY=2) SET YI="",YKEY="" FOR  SET YI=$ORDER(^WWW126(YM,YFORM,YBED,YI)) QUIT:YI=""  DO
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YOPEN1")),"")) {
      if ((mOp.Equal(m$.var("YALLKEY").get(),1)) || (mOp.Equal(m$.var("YALLKEY").get(),2))) {
        mVar YI = m$.var("YI");
        YI.set("");
        mVar YKEY = m$.var("YKEY");
        YKEY.set("");
        for (;true;) {
          YI.set(m$.Fnc.$order(m$.var("^WWW126",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YBED").get(),YI.get())));
          if (mOp.Equal(YI.get(),"")) {
            break;
          }
          //<< . SET YKEY(YI)=$GET(^WWW126(YM,YFORM,YBED,YI,1))  ;LETZTER DATENSATZ ;last data record
          YKEY.var(YI.get()).set(m$.Fnc.$get(m$.var("^WWW126",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YBED").get(),YI.get(),1)));
          //<< . IF $GET(YOPEN1)'="" SET YKEY(YI)=$GET(^WWW1262(YM,YFORM,YBED,YOPEN1,YI,1))   ;VORLETZTER DATENSATZ ;data record
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YOPEN1")),"")) {
            YKEY.var(YI.get()).set(m$.Fnc.$get(m$.var("^WWW1262",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YBED").get(),m$.var("YOPEN1").get(),YI.get(),1)));
          }
          //<< . IF YKEY(YI)'="" SET:YKEY'="" YKEY=YKEY_"," SET YKEY=YKEY_YKEY(YI)
          if (mOp.NotEqual(YKEY.var(YI.get()).get(),"")) {
            if (mOp.NotEqual(YKEY.get(),"")) {
              YKEY.set(mOp.Concat(YKEY.get(),","));
            }
            YKEY.set(mOp.Concat(YKEY.get(),YKEY.var(YI.get()).get()));
          }
          //<< . SET YALLKEY=9
          mVar YALLKEY = m$.var("YALLKEY");
          YALLKEY.set(9);
        }
      }
    }
    //<< 
    //<< ; shobby ---------------------------  SR12442
    //<< ; The previous section may have failed because an item has just been deleted meaning that it is no longer
    //<< ; in WWW126, although WWW1262 is still valid.
    //<< IF $GET(YOPEN1)'="" IF (YALLKEY=1) || (YALLKEY=2) SET YI="",YKEY="" FOR  SET YI=$ORDER(^WWW1262(YM,YFORM,YBED,YOPEN1,YI)) QUIT:YI=""  DO
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YOPEN1")),"")) {
      if ((mOp.Equal(m$.var("YALLKEY").get(),1)) || (mOp.Equal(m$.var("YALLKEY").get(),2))) {
        mVar YI = m$.var("YI");
        YI.set("");
        mVar YKEY = m$.var("YKEY");
        YKEY.set("");
        for (;true;) {
          YI.set(m$.Fnc.$order(m$.var("^WWW1262",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YBED").get(),m$.var("YOPEN1").get(),YI.get())));
          if (mOp.Equal(YI.get(),"")) {
            break;
          }
          //<< . SET YKEY(YI)=$GET(^WWW1262(YM,YFORM,YBED,YOPEN1,YI,1))  ;LETZTER DATENSATZ ;last data record
          YKEY.var(YI.get()).set(m$.Fnc.$get(m$.var("^WWW1262",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YBED").get(),m$.var("YOPEN1").get(),YI.get(),1)));
          //<< . IF YKEY(YI)'="" SET:YKEY'="" YKEY=YKEY_"," SET YKEY=YKEY_YKEY(YI)
          if (mOp.NotEqual(YKEY.var(YI.get()).get(),"")) {
            if (mOp.NotEqual(YKEY.get(),"")) {
              YKEY.set(mOp.Concat(YKEY.get(),","));
            }
            YKEY.set(mOp.Concat(YKEY.get(),YKEY.var(YI.get()).get()));
          }
          //<< . SET YALLKEY=9
          mVar YALLKEY = m$.var("YALLKEY");
          YALLKEY.set(9);
        }
      }
    }
    //<< ; shobby ---------------------------
    //<< 
    //<< ;ALTE VORGABE SCHLUESSEL UND ÖFFNEN ALTEN DATENSATZ ;default And unclose data record
    //<< IF YOPEN=1 IF $DATA(YKEY(1)) IF (YKEY(1)="") || (YKEY(1)="+") IF $TRANSLATE(YKEY,",+"_"""")="" IF ($TRANSLATE(YFELD,Y_"0 ,.")=$TRANSLATE($GET(^WWW1261(YM,YFORM,1)),Y_"0 ,.")) || ($TRANSLATE($GET(^WWW1261(YM,YFORM,1)),Y_"0 ,.")="") IF YALLKEY=1 SET YI="",YKEY="" FOR  SET YI=$ORDER(^WWW126(YM,YFORM,YBED,YI)) QUIT:YI=""  DO
    if (mOp.Equal(YOPEN.get(),1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("YKEY").var(1)))) {
        if ((mOp.Equal(m$.var("YKEY").var(1).get(),"")) || (mOp.Equal(m$.var("YKEY").var(1).get(),"+"))) {
          if (mOp.Equal(m$.Fnc.$translate(m$.var("YKEY").get(),mOp.Concat(",+","\"")),"")) {
            if ((mOp.Equal(m$.Fnc.$translate(m$.var("YFELD").get(),mOp.Concat(m$.var("Y").get(),"0 ,.")),m$.Fnc.$translate(m$.Fnc.$get(m$.var("^WWW1261",m$.var("YM").get(),m$.var("YFORM").get(),1)),mOp.Concat(m$.var("Y").get(),"0 ,.")))) || (mOp.Equal(m$.Fnc.$translate(m$.Fnc.$get(m$.var("^WWW1261",m$.var("YM").get(),m$.var("YFORM").get(),1)),mOp.Concat(m$.var("Y").get(),"0 ,.")),""))) {
              if (mOp.Equal(m$.var("YALLKEY").get(),1)) {
                mVar YI = m$.var("YI");
                YI.set("");
                mVar YKEY = m$.var("YKEY");
                YKEY.set("");
                for (;true;) {
                  YI.set(m$.Fnc.$order(m$.var("^WWW126",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YBED").get(),YI.get())));
                  if (mOp.Equal(YI.get(),"")) {
                    break;
                  }
                  //<< . SET YKEY(YI) = $GET(^WWW126(YM,YFORM,YBED,YI,1))  ;LETZTER DATENSATZ ;last data record
                  YKEY.var(YI.get()).set(m$.Fnc.$get(m$.var("^WWW126",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YBED").get(),YI.get(),1)));
                  //<< . IF $GET(YOPEN1)'="" SET YKEY(YI) = $GET(^WWW1262(YM,YFORM,YBED,YOPEN1,YI,1))  ;VORLEZTER DATENSATZ ;data record
                  if (mOp.NotEqual(m$.Fnc.$get(m$.var("YOPEN1")),"")) {
                    YKEY.var(YI.get()).set(m$.Fnc.$get(m$.var("^WWW1262",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YBED").get(),m$.var("YOPEN1").get(),YI.get(),1)));
                  }
                  //<< . IF YKEY(YI)'="" SET:YKEY'="" YKEY=YKEY_"," SET YKEY = YKEY_YKEY(YI)
                  if (mOp.NotEqual(YKEY.var(YI.get()).get(),"")) {
                    if (mOp.NotEqual(YKEY.get(),"")) {
                      YKEY.set(mOp.Concat(YKEY.get(),","));
                    }
                    YKEY.set(mOp.Concat(YKEY.get(),YKEY.var(YI.get()).get()));
                  }
                  //<< . SET YALLKEY=9
                  mVar YALLKEY = m$.var("YALLKEY");
                  YALLKEY.set(9);
                }
              }
            }
          }
        }
      }
    }
    //<< 
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ;SUCHEN SCHLÜSSEL OHNE PRIMÄRSCHL ;seek key without
    //<< IF YALLKEY=1 IF $GET(YKEY(1))="" IF $TRANSLATE(YFELD,Y)'="" IF '$DATA(^WWW002(0,YDATEI)) DO PRIM^WWWLOOK IF YKEY'="" SET YALLKEY=9
    if (mOp.Equal(m$.var("YALLKEY").get(),1)) {
      if (mOp.Equal(m$.Fnc.$get(m$.var("YKEY").var(1)),"")) {
        if (mOp.NotEqual(m$.Fnc.$translate(m$.var("YFELD").get(),m$.var("Y").get()),"")) {
          if (mOp.Not(m$.Fnc.$data(m$.var("^WWW002",0,YDATEI.get())))) {
            m$.Cmd.Do("WWWLOOK.PRIM");
            if (mOp.NotEqual(m$.var("YKEY").get(),"")) {
              mVar YALLKEY = m$.var("YALLKEY");
              YALLKEY.set(9);
            }
          }
        }
      }
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Form Type 3  : GRID FORM
    //<< ;-------------------------------------------------------------------------------
    //<< IF $GET(YOPEN)=1 IF $$$WWW120FormType(YVOR)=3 IF (YALLKEY=1) || (YALLKEY=2) DO  IF YALLKEY=0 QUIT  ;DATEN AUS GRID GEFUNDEN;TYBD;10,04,2003
    if (mOp.Equal(m$.Fnc.$get(YOPEN),1)) {
      if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),3)) {
        if ((mOp.Equal(m$.var("YALLKEY").get(),1)) || (mOp.Equal(m$.var("YALLKEY").get(),2))) {
          do {
            //<< . QUIT:YDATEI=""
            if (mOp.Equal(YDATEI.get(),"")) {
              break;
            }
            //<< . SET YMAXKEY=+$ORDER(^WWW002(0,YDATEI,""),-1)
            mVar YMAXKEY = m$.var("YMAXKEY");
            YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
            //<< . QUIT:YMAXKEY<2  ;KEIN GRID MIT MEHR ;no by means of more
            if (mOp.Less(YMAXKEY.get(),2)) {
              break;
            }
            //<< . IF YALLKEY=2 IF $GET(YKEY(YMAXKEY))'="+" QUIT  ;LETZTE KEY NICHT + ABER VOLLSTÄNDIG ;last KEY Not yet integral
            if (mOp.Equal(m$.var("YALLKEY").get(),2)) {
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY").var(YMAXKEY.get())),"+")) {
                break;
              }
            }
            //<< . SET YKEY=""
            mVar YKEY = m$.var("YKEY");
            YKEY.set("");
            //<< . FOR YI=1:1:YMAXKEY-1 SET YKEY=YKEY_$GET(YKEY(YI)) IF YI'=YMAXKEY SET YKEY=YKEY_","
            mVar YI = m$.var("YI");
            for (YI.set(1);(mOp.LessOrEqual(YI.get(),mOp.Subtract(YMAXKEY.get(),1)));YI.set(mOp.Add(YI.get(),1))) {
              YKEY.set(mOp.Concat(YKEY.get(),m$.Fnc.$get(YKEY.var(YI.get()))));
              if (mOp.NotEqual(YI.get(),YMAXKEY.get())) {
                YKEY.set(mOp.Concat(YKEY.get(),","));
              }
            }
            //<< . SET %("VAR","YKEY")=YKEY
            m$.var("%","VAR","YKEY").set(YKEY.get());
            //<< . SET %("VAR","YNEW")=1
            m$.var("%","VAR","YNEW").set(1);
            //<< . DO ^WWWFORM
            m$.Cmd.Do("WWWFORM.main");
            //<< . SET YALLKEY=0
            mVar YALLKEY = m$.var("YALLKEY");
            YALLKEY.set(0);
          } while (false);
          if (mOp.Equal(m$.var("YALLKEY").get(),0)) {
            return;
          }
        }
      }
    }
    //<< 
    //<< 
    //<< ;SUCHEN KEYVORGABE MIT ANZEIGE AUSWAHL KEY ;seek by means of Show Selection KEY
    //<< IF $GET(YKEY(1))'="+" IF $GET(YKEY(2))'="+" IF $GET(YKEY(3))'="+" IF $GET(YKEY(4))'="+" IF $GET(YKEY(5))'="+" IF YRICHT="" IF YALLKEY=2 IF $EXTRACT(YOPEN,1,4)'="SAVE" DO
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY").var(1)),"+")) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY").var(2)),"+")) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY").var(3)),"+")) {
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY").var(4)),"+")) {
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY").var(5)),"+")) {
              if (mOp.Equal(m$.var("YRICHT").get(),"")) {
                if (mOp.Equal(m$.var("YALLKEY").get(),2)) {
                  if (mOp.NotEqual(m$.Fnc.$extract(YOPEN.get(),1,4),"SAVE")) {
                    do {
                      //<< . QUIT:'$DATA(^WWW121(0,YFORM))  ;KEINE PRIMÄRSCHL ;no
                      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YFORM").get())))) {
                        break;
                      }
                      //<< . DO KEY^WWWLOOK
                      m$.Cmd.Do("WWWLOOK.KEY");
                      //<< . SET YALLKEY=1
                      mVar YALLKEY = m$.var("YALLKEY");
                      YALLKEY.set(1);
                      //<< . IF YKEY'="" SET YALLKEY=9    ;SUCHEN PASSENDEN DATENSATZ ;seek data record
                      if (mOp.NotEqual(m$.var("YKEY").get(),"")) {
                        YALLKEY.set(9);
                      }
                    } while (false);
                  }
                }
              }
            }
          }
        }
      }
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< IF YFORM="WWW120" SET $$$WWW013LastFormUsed(^WWW013(0,YBED,1)) = $GET(YKEY(1))  ;VORGABE TEST ;default Test
    if (mOp.Equal(m$.var("YFORM").get(),"WWW120")) {
      include.WWWConst.$$$WWW013LastFormUsedSet(m$,m$.var("^WWW013",0,m$.var("YBED").get(),1),m$.Fnc.$get(m$.var("YKEY").var(1)));
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Form Type 1  : STANDARD FORM
    //<< ; Form Type 3  : GRID FORM
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;AUSWAHL DATENSATZ AUS FELDERN ;Selection data record out of
    //<< if YRICHT="" IF $$$WWW120FormType(YVOR)=1||($$$WWW120FormType(YVOR)=3) IF YALLKEY=1 IF $EXTRACT(YOPEN,1,4)'="SAVE" DO  QUIT
    if (mOp.Equal(m$.var("YRICHT").get(),"")) {
      if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),1) || (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),3))) {
        if (mOp.Equal(m$.var("YALLKEY").get(),1)) {
          if (mOp.NotEqual(m$.Fnc.$extract(YOPEN.get(),1,4),"SAVE")) {
            //<< . DO ^WWWINFO($GET(YKEY(1))_" "_$GET(YKEY(2))_" "_$GET(YKEY(3))_" "_$GET(YKEY(4))_" "_$$^WWWTEXT(86))  ;TYBD;4,2,2004;NICHT VORHANDEN
            m$.Cmd.Do("WWWINFO.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YKEY").var(1))," "),m$.Fnc.$get(m$.var("YKEY").var(2)))," "),m$.Fnc.$get(m$.var("YKEY").var(3)))," "),m$.Fnc.$get(m$.var("YKEY").var(4)))," "),m$.fnc$("WWWTEXT.main",86)));
            return;
          }
        }
      }
    }
    //<< . ;DO ANZEIGE^WWWLOOK QUIT  ;MIT ANZEIGE;TYBD;4,2,2004
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< IF YRICHT="" IF ($$$WWW120FormType(YVOR)=3) || ($$$WWW120FormType(YVOR)=1) IF $EXTRACT(YOPEN,1,4)'="SAVE" IF $TRANSLATE(YFELD,Y)="" IF (YKEY(1)="") || ($GET(YKEY(1))="+") || ($GET(YKEY(2))="+") || ($GET(YKEY(3))="+") || ($GET(YKEY(4))="+") || ($GET(YKEY(5))="+") DO ANZEIGE^WWWLOOK QUIT  ;MIT ANZEIGE ;by means of Show
    if (mOp.Equal(m$.var("YRICHT").get(),"")) {
      if ((mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),3)) || (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),1))) {
        if (mOp.NotEqual(m$.Fnc.$extract(YOPEN.get(),1,4),"SAVE")) {
          if (mOp.Equal(m$.Fnc.$translate(m$.var("YFELD").get(),m$.var("Y").get()),"")) {
            if ((mOp.Equal(m$.var("YKEY").var(1).get(),"")) || (mOp.Equal(m$.Fnc.$get(m$.var("YKEY").var(1)),"+")) || (mOp.Equal(m$.Fnc.$get(m$.var("YKEY").var(2)),"+")) || (mOp.Equal(m$.Fnc.$get(m$.var("YKEY").var(3)),"+")) || (mOp.Equal(m$.Fnc.$get(m$.var("YKEY").var(4)),"+")) || (mOp.Equal(m$.Fnc.$get(m$.var("YKEY").var(5)),"+"))) {
              m$.Cmd.Do("WWWLOOK.ANZEIGE");
              return;
            }
          }
        }
      }
    }
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;NÄCHSER DATENSATZ ;data record
    //<< IF $EXTRACT(YOPEN,1,4)'="SAVE" IF YRICHT'="" SET YKEY="" IF (YKEY(1)="") || ($GET(YKEY(1))="+") || ($GET(YKEY(2))="+") || ($GET(YKEY(3))="+") || ($GET(YKEY(4))="+") || ($GET(YKEY(5))="+") SET $PIECE(^WWWUSER(0,YUSER,1),Y,15)="" DO ^WWWFORM QUIT
    if (mOp.NotEqual(m$.Fnc.$extract(YOPEN.get(),1,4),"SAVE")) {
      if (mOp.NotEqual(m$.var("YRICHT").get(),"")) {
        mVar YKEY = m$.var("YKEY");
        YKEY.set("");
        if ((mOp.Equal(YKEY.var(1).get(),"")) || (mOp.Equal(m$.Fnc.$get(YKEY.var(1)),"+")) || (mOp.Equal(m$.Fnc.$get(YKEY.var(2)),"+")) || (mOp.Equal(m$.Fnc.$get(YKEY.var(3)),"+")) || (mOp.Equal(m$.Fnc.$get(YKEY.var(4)),"+")) || (mOp.Equal(m$.Fnc.$get(YKEY.var(5)),"+"))) {
          m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),15).set("");
          m$.Cmd.Do("WWWFORM.main");
          return;
        }
      }
    }
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;DATENSATZ ÖFFNEN ;data record unclose
    //<< IF $EXTRACT(YOPEN,1,4)'="SAVE" IF YALLKEY=9 DO  DO ^WWWFORM QUIT
    if (mOp.NotEqual(m$.Fnc.$extract(YOPEN.get(),1,4),"SAVE")) {
      if (mOp.Equal(m$.var("YALLKEY").get(),9)) {
        //<< . IF $GET(YTIMEFORM)=1 DO
        if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),1)) {
          //<< . . SET %("VAR","YFORM")=YFORM_"t"  ;ZEITABHÄNGIGE VORGABE ;default
          m$.var("%","VAR","YFORM").set(mOp.Concat(m$.var("YFORM").get(),"t"));
          //<< . . IF $GET(YDATEI)'="" DO   ;SICHER DATEN FÜR SEITENWECHSEL ;sure to
          if (mOp.NotEqual(m$.Fnc.$get(YDATEI),"")) {
            //<< . . . SET YMAXKEY=+$ORDER(^WWW002(0,YDATEI,""),-1)
            mVar YMAXKEY = m$.var("YMAXKEY");
            YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
            //<< . . . SET $PIECE(YKEY,",",YMAXKEY+1)=$$^WWWDATE1($GET(%(YQUERY,"Y"_YFORM_"P"_(YMAXKEY+1))))
            m$.pieceVar(m$.var("YKEY"),",",mOp.Add(YMAXKEY.get(),1)).set(m$.fnc$("WWWDATE1.main",m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P"),(mOp.Add(YMAXKEY.get(),1)))))));
            //<< . . . SET $PIECE(^WWWDUMMY(YUSER,"P"),",",YMAXKEY+1)=$$^WWWDATE1($GET(%(YQUERY,"Y"_YFORM_"P"_(YMAXKEY+1))))
            m$.pieceVar(m$.var("^WWWDUMMY",m$.var("YUSER").get(),"P"),",",mOp.Add(YMAXKEY.get(),1)).set(m$.fnc$("WWWDATE1.main",m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P"),(mOp.Add(YMAXKEY.get(),1)))))));
          }
        }
        //<< . ;
        //<< . SET %("VAR","YKEY")=YKEY
        m$.var("%","VAR","YKEY").set(m$.var("YKEY").get());
        m$.Cmd.Do("WWWFORM.main");
        return;
      }
    }
    //<< 
    //<< ; OPEN ;
    //<< IF (YRICHT="") && (YOPEN=1) DO  QUIT  ;WENN ÖFFNEN DURCH SEITENWECHSEL ;when unclose trans-
    if ((mOp.Equal(m$.var("YRICHT").get(),"")) && (mOp.Equal(YOPEN.get(),1))) {
      //<< . SET %("VAR","YKEY")=""
      m$.var("%","VAR","YKEY").set("");
      //<< . SET %("VAR","YSEITE")=""
      m$.var("%","VAR","YSEITE").set("");
      //<< . SET YSEITE=1
      mVar YSEITE = m$.var("YSEITE");
      YSEITE.set(1);
      //<< . DO ^WWWFORM
      m$.Cmd.Do("WWWFORM.main");
      return;
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Form Type 2  : LIST GENERATOR     LISTEN FELDDEFINITIONEN - LISTEN VORGABEN
    //<< ;-------------------------------------------------------------------------------
    //<< SET Q=0
    mVar Q = m$.var("Q");
    Q.set(0);
    //<< IF $$$WWW120FormType(YVOR)=2 DO
    if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),2)) {
      //<< . FOR YI=1:1:5 SET YA=$GET(%(YQUERY,"Y"_YFORM_"LR"_YI_"")) IF YA'="" SET YLR(YI)=YA  ;RICHTUNG LISTGENERATORFILES ;trend
      mVar YI = m$.var("YI");
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),5));YI.set(mOp.Add(YI.get(),1))) {
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"LR"),YI.get()),""))));
        if (mOp.NotEqual(YA.get(),"")) {
          mVar YLR = m$.var("YLR");
          YLR.var(YI.get()).set(YA.get());
        }
      }
      //<< . FOR YI1=1:1:5 FOR YI=1:1:10 SET YA=$GET(%(YQUERY,"Y"_YFORM_"LP"_YI1_$EXTRACT(100+YI,2,3)_""))  DO MULTL^WWWSAVV("Y"_YFORM_"LP"_YI1_$EXTRACT(100+YI,2,3)) IF YA'="" SET YLP(YI1,$EXTRACT(100+YI,2,3))=YA  ;LISTGENERATOR PRIMÄRSCHL
      mVar YI1 = m$.var("YI1");
      for (YI1.set(1);(mOp.LessOrEqual(YI1.get(),5));YI1.set(mOp.Add(YI1.get(),1))) {
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),10));YI.set(mOp.Add(YI.get(),1))) {
          mVar YA = m$.var("YA");
          YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"LP"),YI1.get()),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)),""))));
          m$.Cmd.Do("WWWSAVV.MULTL",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"LP"),YI1.get()),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)));
          if (mOp.NotEqual(YA.get(),"")) {
            mVar YLP = m$.var("YLP");
            YLP.var(YI1.get(),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)).set(YA.get());
          }
        }
      }
      //<< . FOR YI1=1:1:5 FOR YI=1:1:10 SET YA=$GET(%(YQUERY,"Y"_YFORM_"LP1"_YI1_$EXTRACT(100+YI,2,3)_"")) DO MULTL^WWWSAVV("Y"_YFORM_"LP1"_YI1_$EXTRACT(100+YI,2,3)) IF YA'="" SET YLP1(YI1,$EXTRACT(100+YI,2,3))=YA  ;LISTGENERATOR PRIMÄRSCHL BIS ;until
      for (YI1.set(1);(mOp.LessOrEqual(YI1.get(),5));YI1.set(mOp.Add(YI1.get(),1))) {
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),10));YI.set(mOp.Add(YI.get(),1))) {
          mVar YA = m$.var("YA");
          YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"LP1"),YI1.get()),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)),""))));
          m$.Cmd.Do("WWWSAVV.MULTL",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"LP1"),YI1.get()),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)));
          if (mOp.NotEqual(YA.get(),"")) {
            mVar YLP1 = m$.var("YLP1");
            YLP1.var(YI1.get(),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)).set(YA.get());
          }
        }
      }
      //<< . FOR YI1=1:1:5 FOR YI=1:1:99 SET YA=$GET(%(YQUERY,"Y"_YFORM_"LD"_YI1_$EXTRACT(100+YI,2,3)_""))  DO MULTL^WWWSAVV("Y"_YFORM_"LD"_YI1_$EXTRACT(100+YI,2,3)) IF YA'="" SET YLD(YI1,$EXTRACT(100+YI,2,3))=YA  ;LISTGENERATOR DATENFELDER
      for (YI1.set(1);(mOp.LessOrEqual(YI1.get(),5));YI1.set(mOp.Add(YI1.get(),1))) {
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),99));YI.set(mOp.Add(YI.get(),1))) {
          mVar YA = m$.var("YA");
          YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"LD"),YI1.get()),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)),""))));
          m$.Cmd.Do("WWWSAVV.MULTL",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"LD"),YI1.get()),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)));
          if (mOp.NotEqual(YA.get(),"")) {
            mVar YLD = m$.var("YLD");
            YLD.var(YI1.get(),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)).set(YA.get());
          }
        }
      }
      //<< . FOR YI1=1:1:5 FOR YI=1:1:99 SET YA=$GET(%(YQUERY,"Y"_YFORM_"LD1"_YI1_$EXTRACT(100+YI,2,3)_"")) DO MULTL^WWWSAVV("Y"_YFORM_"LD1"_YI1_$EXTRACT(100+YI,2,3)) IF YA'="" SET YLD1(YI1,$EXTRACT(100+YI,2,3))=YA  ;LISTGENERATOR DATENFELDER BIS ;until
      for (YI1.set(1);(mOp.LessOrEqual(YI1.get(),5));YI1.set(mOp.Add(YI1.get(),1))) {
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),99));YI.set(mOp.Add(YI.get(),1))) {
          mVar YA = m$.var("YA");
          YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"LD1"),YI1.get()),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)),""))));
          m$.Cmd.Do("WWWSAVV.MULTL",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"LD1"),YI1.get()),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)));
          if (mOp.NotEqual(YA.get(),"")) {
            mVar YLD1 = m$.var("YLD1");
            YLD1.var(YI1.get(),m$.Fnc.$extract(mOp.Add(100,YI.get()),2,3)).set(YA.get());
          }
        }
      }
      //<< . FOR YI=1:1:5 SET YA=$GET(%(YQUERY,"Y"_YFORM_"S"_YI_""))  IF YA'="" SET YS(YI)=YA,SORT(YI)=YA,SORT=YA  ;SORTIERUNGEN
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),5));YI.set(mOp.Add(YI.get(),1))) {
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"S"),YI.get()),""))));
        if (mOp.NotEqual(YA.get(),"")) {
          mVar YS = m$.var("YS");
          YS.var(YI.get()).set(YA.get());
          mVar SORT = m$.var("SORT");
          SORT.var(YI.get()).set(YA.get());
          SORT.set(YA.get());
        }
      }
      //<< . FOR YI=1:1:20 SET YA=$GET(%(YQUERY,"Y"_YFORM_"M"_YI_"")) IF YA'="" SET YM(YI)=YA  ;MANUELLE IN EINER LISTE ;within unit list
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),20));YI.set(mOp.Add(YI.get(),1))) {
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),YI.get()),""))));
        if (mOp.NotEqual(YA.get(),"")) {
          mVar YM = m$.var("YM");
          YM.var(YI.get()).set(YA.get());
        }
      }
    }
    //<< 
    //<< IF '$DATA(^WWWSOR(YUSER,"BIT")) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),"BIT")))) {
      //<< KILL ^WWWSOR(YUSER)
      m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
    }
    //<< } ELSE {
    else {
      //<< KILL ^WWWSOR(YUSER,1)
      m$.var("^WWWSOR",m$.var("YUSER").get(),1).kill();
      //<< KILL ^WWWSOR(YUSER,2)
      m$.var("^WWWSOR",m$.var("YUSER").get(),2).kill();
      //<< KILL ^WWWSOR(YUSER,"PAGE")
      m$.var("^WWWSOR",m$.var("YUSER").get(),"PAGE").kill();
    }
    //<< }
    //<< 
    //<< IF $EXTRACT(YOPEN,1,4)="SAVE" DO  QUIT   ;DATEN ZWISCHENSPEICHERN WEGEN SUCHE/HILFE/BUTTON ;quibble
    if (mOp.Equal(m$.Fnc.$extract(YOPEN.get(),1,4),"SAVE")) {
      //<< . do BufferSave()
      m$.Cmd.Do("BufferSave");
      return;
    }
    //<< 
    //<< KILL ^WWWSOR(YUSER)
    m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
    //<< 
    //<< ; Check User
    //<< SET YBED=$$$UPPER(YBED)
    mVar YBED = m$.var("YBED");
    YBED.set(include.COMSYSString.$$$UPPER(m$,m$.var("YBED")));
    //<< IF '$DATA(^WWW013(0,YBED)) DO ^WWWINFO($$^WWWTEXT(5)) QUIT
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW013",0,YBED.get())))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< SET YVORM=^WWW013(0,YBED,1)
    mVar YVORM = m$.var("YVORM");
    YVORM.set(m$.var("^WWW013",0,YBED.get(),1).get());
    //<< IF '$$CHECK^WWWPWDCHECK($$$WWW013Password1(YVORM),YPWD) DO ^WWWINFO($$^WWWTEXT(5)) QUIT
    if (mOp.Not(m$.fnc$("WWWPWDCHECK.CHECK",include.WWWConst.$$$WWW013Password1(m$,YVORM),m$.var("YPWD").get()))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< SET YBER=$$$WWW013UserAccess(YVORM)
    mVar YBER = m$.var("YBER");
    YBER.set(include.WWWConst.$$$WWW013UserAccess(m$,YVORM));
    //<< SET YMOD=$$$WWW013Module1(YVORM)
    mVar YMOD = m$.var("YMOD");
    YMOD.set(include.WWWConst.$$$WWW013Module1(m$,YVORM));
    //<< 
    //<< DO ^WWWFORMX  ;VORGABEN
    m$.Cmd.Do("WWWFORMX.main");
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;       D22     $$$WWW120UserAccess()
    //<< ;       D23     $$$WWW120AuthorizationToModifyData()
    //<< ;       D24     $$$WWW120Modules()
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< IF ($$$WWW120UserAccess(YVOR)'="") || ($$$WWW120Modules(YVOR)'="") IF $$^WWWACCESS($$$WWW120UserAccess(YVOR),$$$WWW120Modules(YVOR))'=1 SET Q=0 DO  IF Q=0 DO ^WWWINFO($$^WWWTEXT(5)) QUIT  ;BERECHTIGUNGEN;AUCH ERLAUBT WENN MITARBEITERMENÜ;FIS;26637;27.10.04
    if ((mOp.NotEqual(include.WWWConst.$$$WWW120UserAccess(m$,m$.var("YVOR")),"")) || (mOp.NotEqual(include.WWWConst.$$$WWW120Modules(m$,m$.var("YVOR")),""))) {
      if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",include.WWWConst.$$$WWW120UserAccess(m$,m$.var("YVOR")),include.WWWConst.$$$WWW120Modules(m$,m$.var("YVOR"))),1)) {
        Q.set(0);
        do {
          //<< . NEW SONDERMENU
          mVar SONDERMENU = m$.var("SONDERMENU");
          m$.newVarBlock(1,SONDERMENU);
          //<< . IF ($PIECE($GET(YANZ),",",1)="") || ($PIECE($GET(YANZ),",",2)="") QUIT
          if ((mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YANZ")),",",1),"")) || (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YANZ")),",",2),""))) {
            break;
          }
          //<< . SET SONDERMENU=$PIECE($GET(^WWW0132(0,YBED,YM,$PIECE(YANZ,",",1),1)),Y,1)
          SONDERMENU.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,YBED.get(),m$.var("YM").get(),m$.Fnc.$piece(m$.var("YANZ").get(),",",1),1)),m$.var("Y").get(),1));
          //<< . IF SONDERMENU'="" IF $FIND(";"_SONDERMENU_";",";"_$PIECE(YANZ,",",2)_";") SET Q=1  ;ACHTUNG ! NUR PRÜFUNG DES OBER-MENÜPUNKTES
          if (mOp.NotEqual(SONDERMENU.get(),"")) {
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",SONDERMENU.get()),";"),mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.var("YANZ").get(),",",2)),";")))) {
              Q.set(1);
            }
          }
        } while (false);
        if (mOp.Equal(Q.get(),0)) {
          m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
          return;
        }
      }
      m$.restoreVarBlock(1);
    }
    //<< 
    //<< IF $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly DO  QUIT
    if (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$))) {
      //<< . SET $$$WWWUSERLastFormfield(^WWWUSER(0,YUSER,1))=""
      include.WWWConst.$$$WWWUSERLastFormfieldSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
      //<< . SET YKEY=""
      mVar YKEY = m$.var("YKEY");
      YKEY.set("");
      //<< . FOR YI=1:1:YMAXKEY QUIT:'$DATA(YKEY(YI))  SET YKEY=YKEY_YKEY(YI) IF YI'=YMAXKEY IF $GET(YKEY(YI+1))'="" SET YKEY=YKEY_","
      mVar YI = m$.var("YI");
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),m$.var("YMAXKEY").get()));YI.set(mOp.Add(YI.get(),1))) {
        if (mOp.Not(m$.Fnc.$data(YKEY.var(YI.get())))) {
          break;
        }
        YKEY.set(mOp.Concat(YKEY.get(),YKEY.var(YI.get()).get()));
        if (mOp.NotEqual(YI.get(),m$.var("YMAXKEY").get())) {
          if (mOp.NotEqual(m$.Fnc.$get(YKEY.var(mOp.Add(YI.get(),1))),"")) {
            YKEY.set(mOp.Concat(YKEY.get(),","));
          }
        }
      }
      //<< . SET %("VAR","YKEY")=YKEY  ;KEY
      m$.var("%","VAR","YKEY").set(YKEY.get());
      //<< . DO ^WWWFORM
      m$.Cmd.Do("WWWFORM.main");
      return;
    }
    //<< 
    //<< IF $EXTRACT(YFORM,1,3)="WWW" if (","_$$^WWWBEDBER(YBED)_",")[(",33,") DO ^WWWINFO($$^WWWTEXT(12)) QUIT  ;"DEMO" ; "Attention! Access Denied!"
    if (mOp.Equal(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
      if (mOp.Contains((mOp.Concat(mOp.Concat(",",m$.fnc$("WWWBEDBER.main",YBED.get())),",")),(",33,"))) {
        m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",12));
        return;
      }
    }
    //<< 
    //<< SET Q=0
    Q.set(0);
    //<< IF $DATA(^WWW122s(0,4," ",YFORM)) DO ^WWWSAVM IF Q=1 QUIT  ;MANUELLE
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,4," ",m$.var("YFORM").get())))) {
      m$.Cmd.Do("WWWSAVM.main");
      if (mOp.Equal(Q.get(),1)) {
        return;
      }
    }
    //<< 
    //<< ;NORMALER DATENSATZ SPEICHERN ;data record Save
    //<< KILL ^WWWSOR(YUSER,"PAGE")  ;TYBD;10,2,2004
    m$.var("^WWWSOR",m$.var("YUSER").get(),"PAGE").kill();
    //<< LOCK +^WWWUSER(0,YUSER):3  ;SICHERN FÜR 2 CLICKS TYBD;30.12.2002 ;safeguard to
    m$.Cmd.LockInc(m$.var("^WWWUSER",0,m$.var("YUSER").get()),3);
    //<< SET YFELD=$TRANSLATE(YFELD,$CHAR(13,10),"|")  ;TEXTE
    mVar YFELD = m$.var("YFELD");
    YFELD.set(m$.Fnc.$translate(m$.var("YFELD").get(),m$.Fnc.$char(13,10),"|"));
    //<< IF $EXTRACT(YFELD,$LENGTH(YFELD))="|" SET YFELD=$EXTRACT(YFELD,1,$LENGTH(YFELD)-1)
    if (mOp.Equal(m$.Fnc.$extract(YFELD.get(),m$.Fnc.$length(YFELD.get())),"|")) {
      YFELD.set(m$.Fnc.$extract(YFELD.get(),1,mOp.Subtract(m$.Fnc.$length(YFELD.get()),1)));
    }
    //<< SET YABBR=0
    mVar YABBR = m$.var("YABBR");
    YABBR.set(0);
    //<< SET YDATEI=$PIECE(YVOR,Y,11)
    YDATEI.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11));
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Forms other than
    //<< ;   Form Type 2  : LIST GENERATOR
    //<< ;   Form Type 4  : MANUAL INPUT (WITH BUTTON)
    //<< ;-------------------------------------------------------------------------------
    //<< IF $$$WWW120FormType(YVOR)'=4 IF $$$WWW120FormType(YVOR)'=2 IF YDATEI'="" DO  LOCK -^WWWUSER(0,YUSER) QUIT
    if (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),4)) {
      if (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),2)) {
        if (mOp.NotEqual(YDATEI.get(),"")) {
          do {
            //<< . NEW Q,YLINK
            mVar YLINK = m$.var("YLINK");
            m$.newVarBlock(1,Q,YLINK);
            //<< . SET YOK=1
            mVar YOK = m$.var("YOK");
            YOK.set(1);
            //<< . SET YLFZ=0
            mVar YLFZ = m$.var("YLFZ");
            YLFZ.set(0);
            //<< . ;
            //<< . ;-------------------------------------
            //<< . ;  Key Validation
            //<< . ;-------------------------------------
            //<< . SET YI=""
            mVar YI = m$.var("YI");
            YI.set("");
            //<< . FOR  SET YI=$ORDER(^WWW002(0,YDATEI,YI)) QUIT:YI=""  DO  QUIT:YABBR=1   ;PRIMÄRSCHL.
            for (;true;) {
              YI.set(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),YI.get())));
              if (mOp.Equal(YI.get(),"")) {
                break;
              }
              do {
                //<< . . IF $GET(YKEY(YI))'="" IF YBED'="" SET ^WWW126(YM,YFORM,YBED,YI,1)=$GET(YKEY(YI)) SET ^WWW126(YM,YFORM,YUSER,YI,1)=$GET(YKEY(YI)) ;SPEICH DFLT
                if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY").var(YI.get())),"")) {
                  if (mOp.NotEqual(YBED.get(),"")) {
                    m$.var("^WWW126",m$.var("YM").get(),m$.var("YFORM").get(),YBED.get(),YI.get(),1).set(m$.Fnc.$get(m$.var("YKEY").var(YI.get())));
                    m$.var("^WWW126",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YUSER").get(),YI.get(),1).set(m$.Fnc.$get(m$.var("YKEY").var(YI.get())));
                  }
                }
                //<< . . SET YTYP=$PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)
                mVar YTYP = m$.var("YTYP");
                YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),YI.get(),1)),m$.var("Y").get(),3));
                //<< . . DO PRUEFP^WWWSAVP
                m$.Cmd.Do("WWWSAVP.PRUEFP");
                //<< . . IF '$DATA(YKEY(YI)) SET YABBR=1 SET YOK=0 QUIT
                if (mOp.Not(m$.Fnc.$data(m$.var("YKEY").var(YI.get())))) {
                  YABBR.set(1);
                  YOK.set(0);
                  break;
                }
                //<< . . IF YKEY(YI)=""      SET YABBR=1 SET YOK=0 QUIT
                if (mOp.Equal(m$.var("YKEY").var(YI.get()).get(),"")) {
                  YABBR.set(1);
                  YOK.set(0);
                  break;
                }
                //<< . . SET YKEY(YI)=$$GetInternal^WWWTR(YTYP,YKEY(YI))
                mVar YKEY = m$.var("YKEY");
                YKEY.var(YI.get()).set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),m$.var("YKEY").var(YI.get()).get()));
              } while (false);
              if (mOp.Equal(YABBR.get(),1)) {
                break;
              }
            }
            //<< . ;
            //<< . IF YOK=0 IF YRICHT'="" SET $PIECE(^WWWUSER(0,YUSER,1),Y,15)="" DO ^WWWFORM QUIT    ;DATENFELDER DURCHGEHEN ;peruse data fields
            if (mOp.Equal(YOK.get(),0)) {
              if (mOp.NotEqual(m$.var("YRICHT").get(),"")) {
                m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),15).set("");
                m$.Cmd.Do("WWWFORM.main");
                break;
              }
            }
            //<< . IF YOK=0 DO ^WWWINFO($$^WWWTEXT(59)_" "_$$^WWWTEXT(86))                    QUIT    ; "Primary Key Not Available!"
            if (mOp.Equal(YOK.get(),0)) {
              m$.Cmd.Do("WWWINFO.main",mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",59)," "),m$.fnc$("WWWTEXT.main",86)));
              break;
            }
            //<< . ;
            //<< . ;-------------------------------------
            //<< . ;
            //<< . ; Set oldYFELD to stored record.
            //<< . SET YMAXKEY=+$ORDER(^WWW002(0,YDATEI,""),-1)
            mVar YMAXKEY = m$.var("YMAXKEY");
            YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
            //<< . IF YMAXKEY=0 SET YMAXKEY=1  ;AUTOMATISCH LFD NUMMER ;automatic numeral
            if (mOp.Equal(YMAXKEY.get(),0)) {
              YMAXKEY.set(1);
            }
            //<< . SET myYKEY=""
            mVar myYKEY = m$.var("myYKEY");
            myYKEY.set("");
            //<< . FOR YI=1:1:YMAXKEY QUIT:'$DATA(YKEY(YI))  SET myYKEY=myYKEY_YKEY(YI) IF YI'=YMAXKEY IF $GET(YKEY(YI+1))'="" SET myYKEY=myYKEY_","
            for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
              if (mOp.Not(m$.Fnc.$data(m$.var("YKEY").var(YI.get())))) {
                break;
              }
              myYKEY.set(mOp.Concat(myYKEY.get(),m$.var("YKEY").var(YI.get()).get()));
              if (mOp.NotEqual(YI.get(),YMAXKEY.get())) {
                if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY").var(mOp.Add(YI.get(),1))),"")) {
                  myYKEY.set(mOp.Concat(myYKEY.get(),","));
                }
              }
            }
            //<< . set oldYFELD = ""
            mVar oldYFELD = m$.var("oldYFELD");
            oldYFELD.set("");
            //<< . if myYKEY'="" set oldYFELD = $$^WWWSETL("^"_YDATEI_"("_$$^WWWYM(YDATEI,1)_$$^WWWKEYBUILD(myYKEY)_",1)",1)
            if (mOp.NotEqual(myYKEY.get(),"")) {
              oldYFELD.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get(),1)),m$.fnc$("WWWKEYBUILD.main",myYKEY.get())),",1)"),1));
            }
            //<< . ;
            //<< . ;-------------------------------------
            //<< . ;  Data Validation
            //<< . ;-------------------------------------
            //<< . SET YI=""
            YI.set("");
            //<< . FOR  SET YI=$ORDER(^WWW003(0,YDATEI,YI)) QUIT:YI=""  DO
            for (;true;) {
              YI.set(m$.Fnc.$order(m$.var("^WWW003",0,YDATEI.get(),YI.get())));
              if (mOp.Equal(YI.get(),"")) {
                break;
              }
              //<< . . set YTYP = $$GetInputType(YDATEI,YI,YFORM) ;16123
              mVar YTYP = m$.var("YTYP");
              YTYP.set(m$.fnc$("GetInputType",YDATEI.get(),YI.get(),m$.var("YFORM").get()));
              //<< . . SET YSPX = $PIECE($GET(^WWW003(0,YDATEI,YI,1)),Y,17)
              mVar YSPX = m$.var("YSPX");
              YSPX.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),YI.get(),1)),m$.var("Y").get(),17));
              //<< . . DO PRUEFD^WWWSAVD(oldYFELD)
              m$.Cmd.Do("WWWSAVD.PRUEFD",oldYFELD.get());
              //<< . . IF YSPX=1 SET ^WWWDLF(0,YDATEI,YI,YBED,1)=$PIECE(YFELD,Y,YI)
              if (mOp.Equal(YSPX.get(),1)) {
                m$.var("^WWWDLF",0,YDATEI.get(),YI.get(),YBED.get(),1).set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get()));
              }
            }
            //<< . ;
            //<< . IF YOK=0 DO ^WWWINFO($$^WWWTEXT(59)_" "_$$^WWWTEXT(86)) QUIT  ;FEHLER ; error  ; "Primary Key Not Available!" - FIXME: data error not "Primary Key" <GRF>
            if (mOp.Equal(YOK.get(),0)) {
              m$.Cmd.Do("WWWINFO.main",mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",59)," "),m$.fnc$("WWWTEXT.main",86)));
              break;
            }
            //<< . ;
            //<< . ;-------------------------------------
            //<< . set YKEY = myYKEY
            mVar YKEY = m$.var("YKEY");
            YKEY.set(myYKEY.get());
            //<< . SET KEYKEY=$TRANSLATE(YKEY,"""")
            mVar KEYKEY = m$.var("KEYKEY");
            KEYKEY.set(m$.Fnc.$translate(YKEY.get(),"\""));
            //<< . SET FELDFELD=YFELD
            mVar FELDFELD = m$.var("FELDFELD");
            FELDFELD.set(YFELD.get());
            //<< . ;
            //<< . ;OPEN
            //<< . IF YALLKEY=9 SET YOK=9
            if (mOp.Equal(m$.var("YALLKEY").get(),9)) {
              YOK.set(9);
            }
            //<< . ;
            //<< . ;+++++++++++++++++++++++++++++++++++++
            //<< . ;  YVOR   D16     $$$WWW120ExecuteOnAfterSaveData()
            //<< . ;         D18     $$$WWW120ExecuteAfterDataModified()
            //<< . ;         D23     $$$WWW120AuthorizationToModifyData()
            //<< . ;         D89     $$$WWW120ExecuteOnBeforeSaveData()
            //<< . ;+++++++++++++++++++++++++++++++++++++
            //<< . ;
            //<< . ;SAVE
            //<< . SET YAEND=1  ;=ÄNDERUNG
            mVar YAEND = m$.var("YAEND");
            YAEND.set(1);
            //<< . IF $FIND(YFELD,"() Error: URL Problem: SendRequest: java") SET ^WWWSOR(YUSER,1)="Explorer: () Error: URL Problem: SendRequest: java|"  ;FEHLER ;shortcoming
            if (mOp.Logical(m$.Fnc.$find(YFELD.get(),"() Error: URL Problem: SendRequest: java"))) {
              m$.var("^WWWSOR",m$.var("YUSER").get(),1).set("Explorer: () Error: URL Problem: SendRequest: java|");
            }
            //<< . ;
            //<< . quit:$$OnBeforeSave()
            if (mOp.Logical(m$.fnc$("OnBeforeSave"))) {
              break;
            }
            //<< . ;
            //<< . set strStatus = $$$OK
            mVar strStatus = m$.var("strStatus");
            strStatus.set(include.COMSYS.$$$OK(m$));
            //<< . ;
            //<< . ;********* Save *************
            //<< . ;
            //<< . ;#### Start Transaction Unit ################################  ; SR15947
            //<< . ;#### if Save and Execute After Save gets processed as 1 unit
            //<< . ;#### 1 - remember current error handler
            //<< . ;#### 2 - change $ztrap to Transaction Error Handler
            //<< . ;#### 3 - start transaction and try to lock tables
            //<< . ;#### strTStatus = 1 -> Transaction Started, Locks set
            //<< . ;#### strTStatus = 0 -> Transaction NOT Started, NO Locks set
            //<< . if ($$$WWW120ExclAfterSave(YVOR)'=$$$YES) set strTZtrap=$ztrap,$ztrap="TransactionUnitError^COMTransaction" do  ;!!!! "set $ztrap..." MUST BE IN SAME LINE TO BE IN SAME FRAMESTACK !!!
            if ((mOp.NotEqual(include.WWWConst.$$$WWW120ExclAfterSave(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$)))) {
              mVar strTZtrap = m$.var("strTZtrap");
              strTZtrap.set(m$.Fnc.$ztrap());
              mVar $ztrap = m$.var("$ztrap");
              $ztrap.set("TransactionUnitError^COMTransaction");
              //<< . . set strTStatus = $$StartUnit^COMTransaction(YFORM,"ExecuteAfterSave")
              mVar strTStatus = m$.var("strTStatus");
              strTStatus.set(m$.fnc$("COMTransaction.StartUnit",m$.var("YFORM").get(),"ExecuteAfterSave"));
            }
            //<< . ;############################################################
            //<< . ;############################################################
            //<< . ;
            //<< . new pblnDoOnBeforeSave
            mVar pblnDoOnBeforeSave = m$.var("pblnDoOnBeforeSave");
            m$.newVarBlock(1,pblnDoOnBeforeSave);
            //<< . set pblnDoOnBeforeSave = $$$NO
            pblnDoOnBeforeSave.set(include.COMSYS.$$$NO(m$));
            //<< . IF '$DATA(^WWWSOR(YUSER,1))#10=1 IF YALLKEY'=9 SET YOK=$$^WWWSPEI(YDATEI,YKEY,YFELD,0,,,.strStatus,pblnDoOnBeforeSave) SET $PIECE(^WWWUSER(0,YUSER,1),Y,22)=YOK   ;KOPF AUS ;SAVE DES DATENSATZES
            if (mOp.Equal(mOp.Modulus(mOp.Not(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),1))),10),1)) {
              if (mOp.NotEqual(m$.var("YALLKEY").get(),9)) {
                YOK.set(m$.fnc$("WWWSPEI.main",YDATEI.get(),YKEY.get(),YFELD.get(),0,null,null,strStatus,pblnDoOnBeforeSave.get()));
                m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),22).set(YOK.get());
              }
            }
            //<< . IF YOK=0 DO  QUIT
            if (mOp.Equal(YOK.get(),0)) {
              //<< . . ;#### End Transaction Unit - EARLY QUIT ###########
              //<< . . ;#### If Save failed (Soft/- or Hardfail):
              //<< . . ;#### 1 - Commit the Transaction (only if started)
              //<< . . ;#### 2 - Change the Error Handler back to default
              //<< . . if ($$$WWW120ExclAfterSave(YVOR)'=$$$YES) do
              if ((mOp.NotEqual(include.WWWConst.$$$WWW120ExclAfterSave(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$)))) {
                //<< . . . set:$$$ISOK(strTStatus) strTStatus=$$EndUnit^COMTransaction(YFORM,"ExecuteAfterSave",strTStatus,"")
                if (mOp.Logical(include.COMSYS.$$$ISOK(m$,m$.var("strTStatus")))) {
                  m$.var("strTStatus").set(m$.fnc$("COMTransaction.EndUnit",m$.var("YFORM").get(),"ExecuteAfterSave",m$.var("strTStatus").get(),""));
                }
              }
              //<< . . ;##################################################
              //<< . . if $$$ISERR(strStatus) DO ^WWWINFO($$$Text(strStatus)) //VARCode has set an error message.
              if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
                m$.Cmd.Do("WWWINFO.main",include.COMSYS.$$$Text(m$,strStatus));
              }
              //<< . . if $$$ISOK(strStatus)  DO ^WWWINFO($$^WWWTEXT(141))    //Otherwise, use default - "In Use"
              if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
                m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",141));
              }
              break;
            }
            //<< . ;
            //<< . IF YOK'=9 IF YOK'=1 SET YCHANGE=1 IF $PIECE(YVOR,Y,18)'="" IF '$DATA(^WWWSOR(YUSER,1))#10=1 DO ^WWWFORM5 XECUTE $PIECE(YVOR,Y,18) ;EXECUTE BEI AENDERUNG ;EXECUTE next to
            if (mOp.NotEqual(YOK.get(),9)) {
              if (mOp.NotEqual(YOK.get(),1)) {
                mVar YCHANGE = m$.var("YCHANGE");
                YCHANGE.set(1);
                if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),18),"")) {
                  if (mOp.Equal(mOp.Modulus(mOp.Not(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),1))),10),1)) {
                    m$.Cmd.Do("WWWFORM5.main");
                    m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),18));
                  }
                }
              }
            }
            //<< . ;
            //<< . ;**** Execute After Save *****
            //<< . IF YOK'=9 IF $PIECE(YVOR,Y,23)'=3 IF '$DATA(^WWWSOR(YUSER,1))#10=1 DO
            if (mOp.NotEqual(YOK.get(),9)) {
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),23),3)) {
                if (mOp.Equal(mOp.Modulus(mOp.Not(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),1))),10),1)) {
                  //<< . . ;
                  //<< . . IF $GET(YTIMEFORM)'=1 && (($PIECE(YVOR,Y,16)'="") || ($data(^WWWTransactionLine(0,YFORM,"ExecuteAfterSave")))) DO
                  if (mOp.NotEqual(m$.Fnc.$get(YTIMEFORM),1) && mOp.Logical(((mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16),"")) || mOp.Logical((m$.Fnc.$data(m$.var("^WWWTransactionLine",0,m$.var("YFORM").get(),"ExecuteAfterSave"))))))) {
                    //<< . . . SET:$EXTRACT($PIECE(YVOR,Y,16))="#" $PIECE(YVOR,Y,16)=$EXTRACT($PIECE(YVOR,Y,16),2,99)
                    if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16)),"#")) {
                      m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),16).set(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16),2,99));
                    }
                    //<< . . . DO ^WWWFORM5
                    m$.Cmd.Do("WWWFORM5.main");
                    //<< . . . DO ^WWWLESE(YDATEI,YKEY)  ;LESEN WERTE ;read
                    m$.Cmd.Do("WWWLESE.main",YDATEI.get(),YKEY.get());
                    //<< . . . IF $PIECE(YVOR,Y,16)'="" XECUTE $PIECE(YVOR,Y,16)  ;EXECUTE NACH SPEICHERN Q=1 = FORM NICHT MEHR ANZEIGEN ;EXECUTE AFTER SAVE ; Q=1: do not display form
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16),"")) {
                      m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16));
                    }
                    //<< . . . ;
                    //<< . . . ;### Execute Transaction Unit ###
                    //<< . . . do
                    do {
                      //<< . . . . if $$$WWW120ExclAfterSave(YVOR)'=$$$YES quit:'$$$ISOK(strTStatus)  ;expects strTStatus form StartUnit
                      if (mOp.NotEqual(include.WWWConst.$$$WWW120ExclAfterSave(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$))) {
                        if (mOp.Not(include.COMSYS.$$$ISOK(m$,m$.var("strTStatus")))) {
                          break;
                        }
                      }
                      //<< . . . . set strTStatus = $$TransactionUnit^COMTransaction(YFORM,"ExecuteAfterSave",'$$$WWW120ExclAfterSave(YVOR),.strTError,.Q)
                      mVar strTStatus = m$.var("strTStatus");
                      strTStatus.set(m$.fnc$("COMTransaction.TransactionUnit",m$.var("YFORM").get(),"ExecuteAfterSave",mOp.Not(include.WWWConst.$$$WWW120ExclAfterSave(m$,m$.var("YVOR"))),m$.var("strTError"),Q));
                    } while(false);
                    //<< . . . ;
                    //<< . . . IF $$EXIST^%R("Y"_YFORM_"onSave.OBJ",$GET(YUCI)) XECUTE "DO ^Y"_YFORM_"onSave"  ;CUSTOMIZED EXECUTE;FIS;24947;03.02.04
                    if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"onSave.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
                      m$.Cmd.Xecute(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),"onSave"));
                    }
                  }
                }
              }
            }
            //<< . ;
            //<< . ;#### End Transaction Unit - STANDARD QUIT ####
            //<< . ;#### 1 - Commit or Rollback the Transaction (depending on strTStatus / strTError)
            //<< . ;#### 2 - Change the Error Handler back to defeult
            //<< . ;#### 3 - In case of Rollback: Change Save Flag to Hardfail and Quit
            //<< . if ($$$WWW120ExclAfterSave(YVOR)'=$$$YES) do  set $ztrap = strTZtrap    ;!!!! "set $ztrap..." MUST BE IN SAME LINE TO BE IN SAME FRAMESTACK !!!
            if ((mOp.NotEqual(include.WWWConst.$$$WWW120ExclAfterSave(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$)))) {
              //<< . . set strTStatus = $$EndUnit^COMTransaction(YFORM,"ExecuteAfterSave",strTStatus,$get(strTError))
              mVar strTStatus = m$.var("strTStatus");
              strTStatus.set(m$.fnc$("COMTransaction.EndUnit",m$.var("YFORM").get(),"ExecuteAfterSave",m$.var("strTStatus").get(),m$.Fnc.$get(m$.var("strTError"))));
              //<< . . if '$$$ISOK(strTStatus) set YOK = 0
              if (mOp.Not(include.COMSYS.$$$ISOK(m$,strTStatus))) {
                YOK.set(0);
              }
              m$.var("$ztrap").set(m$.var("strTZtrap").get());
            }
            //<< . ;##############################
            //<< . ;
            //<< . IF YOK'=9 IF YRICHT="" IF $PIECE(YVOR,Y,23)<2 IF $$$WWW120FormType(YVOR)=1 IF $TRANSLATE($GET(YFKEY),","_"""")'=$TRANSLATE(YKEY,","_"""") IF $PIECE($GET(^WWW012(0,YM,1)),Y,149)=1 SET YKEY=$PIECE(YKEY,",",1,$LENGTH(YKEY,",")-1)   ;TYBD;WENN VORGABE = 1 IMMER NEUE DATENERFASSUNG  ;when default constantly data gathering
            if (mOp.NotEqual(YOK.get(),9)) {
              if (mOp.Equal(m$.var("YRICHT").get(),"")) {
                if (mOp.Less(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),23),2)) {
                  if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),1)) {
                    if (mOp.NotEqual(m$.Fnc.$translate(m$.Fnc.$get(m$.var("YFKEY")),mOp.Concat(",","\"")),m$.Fnc.$translate(YKEY.get(),mOp.Concat(",","\"")))) {
                      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),149),1)) {
                        YKEY.set(m$.Fnc.$piece(YKEY.get(),",",1,mOp.Subtract(m$.Fnc.$length(YKEY.get(),","),1)));
                      }
                    }
                  }
                }
              }
            }
            //<< . ;
            //<< . SET %("VAR","YKEY")=YKEY  ;KEY
            m$.var("%","VAR","YKEY").set(YKEY.get());
            //<< . IF YKFEHL=0 IF YOPEN=2 SET YOK=9 KILL ^WWWSOR(YUSER)  ;2.SEITE KEINE PRÜF ;no
            if (mOp.Equal(YKFEHL.get(),0)) {
              if (mOp.Equal(YOPEN.get(),2)) {
                YOK.set(9);
                m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
              }
            }
            //<< . ;-------------------------------------------------------------------------------
            //<< . ; Form Type 3  : GRID FORM
            //<< . ; WENN GRID ODER OHNE PRIM KEY DANN DATENSATZ LÖSCHEN ;when Or without PRIM KEY data record Delete
            //<< . ;-------------------------------------------------------------------------------
            //<< . IF $$$WWW120FormType(YVOR)=3 SET $PIECE(YKEY,",",YMAXKEY)="" SET %(YQUERY,"YKEY")=YKEY SET %("VAR","YKEY")=YKEY  ;LÖSCHEN LETZTER KEY BEI GRIDFELDER=NUR ANZEIGE IN GRID FÜR NEUERFASSUNG ;Delete last KEY next to Show within to
            if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),3)) {
              m$.pieceVar(YKEY,",",YMAXKEY.get()).set("");
              m$.var("%",m$.var("YQUERY").get(),"YKEY").set(YKEY.get());
              m$.var("%","VAR","YKEY").set(YKEY.get());
            }
            //<< . ;
            //<< . ;WENN ERFOLGREICH ;when successful
            //<< . IF $GET(YTIMEFORM)=1 DO
            if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),1)) {
              //<< . . SET %("VAR","YFORM")=YFORM_"t"  ;ZEITABHÄNGIGE VORGABE ;default
              m$.var("%","VAR","YFORM").set(mOp.Concat(m$.var("YFORM").get(),"t"));
              //<< . . SET %("VAR","YKEY")=YKEY_","_$$^WWWDATE1($GET(%(YQUERY,"Y"_YFORM_"P"_(YMAXKEY+1))))
              m$.var("%","VAR","YKEY").set(mOp.Concat(mOp.Concat(YKEY.get(),","),m$.fnc$("WWWDATE1.main",m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P"),(mOp.Add(YMAXKEY.get(),1))))))));
            }
            //<< . ;
            //<< . IF $GET(Q)'=1 IF YOK=9||('$DATA(^WWWSOR(YUSER,1))#10=1) DO ^WWWFORM QUIT  ;ANZEIGE FORM NACH ERFOLGREICHEM SAVE ;Show shape within
            if (mOp.NotEqual(m$.Fnc.$get(Q),1)) {
              if (mOp.Equal(YOK.get(),9) || (mOp.Equal(mOp.Modulus(mOp.Not(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),1))),10),1))) {
                m$.Cmd.Do("WWWFORM.main");
                break;
              }
            }
            //<< . ;
            //<< . ;WENN MELDUNG (Z.B. FEHLER) ;when status signal
            //<< . SET ^WWWUSE(0,YUSER,YFORM,"D",1)=YFELD
            m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1).set(YFELD.get());
            //<< . SET YA="",YI=""
            mVar YA = m$.var("YA");
            YA.set("");
            YI.set("");
            //<< . FOR  SET YI=$ORDER(^WWWSOR(YUSER,YI)) QUIT:YI=""  IF +YI'=0 DO
            for (;true;) {
              YI.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),YI.get())));
              if (mOp.Equal(YI.get(),"")) {
                break;
              }
              if (mOp.NotEqual(mOp.Positive(YI.get()),0)) {
                //<< . . SET YA=YA_$GET(^WWWSOR(YUSER,YI))
                YA.set(mOp.Concat(YA.get(),m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),YI.get()))));
                //<< . . SET YKILL=2                         ;BERICHTIGUNG NOETIG ;correction
                mVar YKILL = m$.var("YKILL");
                YKILL.set(2);
                //<< . . IF $GET(YAEND)=1 SET YKILL=3
                if (mOp.Equal(m$.Fnc.$get(YAEND),1)) {
                  YKILL.set(3);
                }
                //<< . . SET %("VAR","YKILL")=YKILL
                m$.var("%","VAR","YKILL").set(YKILL.get());
              }
            }
            //<< . ;
            //<< . IF $DATA(^WWWSOR(YUSER,1))#10=1 IF YA="" SET YA=$$^WWWTEXT(391)         ; "Not Saved!"   ;NICHT GESPEICHERT;TYBD;10,2,2004
            if (mOp.Equal(mOp.Modulus(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),1)),10),1)) {
              if (mOp.Equal(YA.get(),"")) {
                YA.set(m$.fnc$("WWWTEXT.main",391));
              }
            }
            //<< . if '$data(@("^"_YDATEI_"("_$$^WWWYM(YDATEI,1)_$$^WWWKEYBUILD(YKEY)_",1)")) do
            if (mOp.Not(m$.Fnc.$data(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get(),1)),m$.fnc$("WWWKEYBUILD.main",YKEY.get())),",1)")))))) {
              //<< . . SET %("VAR","YKEY") = ""
              m$.var("%","VAR","YKEY").set("");
              //<< . . SET YKEY  = ""
              YKEY.set("");
              //<< . . set YFELD = ""
              YFELD.set("");
            }
            //<< . DO ^WWWINFO(YA,,$GET(YLINK))
            m$.Cmd.Do("WWWINFO.main",YA.get(),null,m$.Fnc.$get(YLINK));
            //<< . WRITE " "                             ;RETURN SOME DATA;TYBD;4,2,2004
            m$.Cmd.Write(" ");
          } while (false);
          m$.Cmd.Unlock(m$.var("^WWWUSER",0,m$.var("YUSER").get()));
          return;
        }
        m$.restoreVarBlock(1);
      }
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Forms from type
    //<< ;   Form Type 2  : LIST GENERATOR
    //<< ;   Form Type 4  : MANUAL INPUT (WITH BUTTON)
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   D16     $$$WWW120ExecuteOnAfterSaveData()
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< IF $PIECE(YVOR,Y,16)'="" && ($extract($PIECE(YVOR,Y,16),1)'=";") DO
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16),"") && (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16),1),";"))) {
      //<< . SET YEXEC=$PIECE(YVOR,Y,16)
      mVar YEXEC = m$.var("YEXEC");
      YEXEC.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16));
      //<< . if $$$WWW120DoNotPrepareHTMLSkeleton(YVOR) = $$$YES set YEXEC = "#"_YEXEC  //Do Not Prepare HTML Skeleton
      if (mOp.Equal(include.WWWConst.$$$WWW120DoNotPrepareHTMLSkeleton(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$))) {
        YEXEC.set(mOp.Concat("#",YEXEC.get()));
      }
      //<< . DO PGMSTART^WWWMANU  ;MANUELLE ;WENN YNOLIST=1 DANN SOLL DIE LISTE NICHT ANGEZEIGT WERDEN ;when who list Not will
      m$.Cmd.Do("WWWMANU.PGMSTART");
    }
    //<< 
    //<< if $data(^WWWTransactionLine(0,YFORM,"ExecuteAfterSave")){
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWTransactionLine",0,m$.var("YFORM").get(),"ExecuteAfterSave")))) {
      //<< set YEXEC = "set strTStatus = $$TransactionUnit^COMTransaction(YFORM,""ExecuteAfterSave"",,.strTError)"
      mVar YEXEC = m$.var("YEXEC");
      YEXEC.set("set strTStatus = $$TransactionUnit^COMTransaction(YFORM,\"ExecuteAfterSave\",,.strTError)");
      //<< if $$$WWW120DoNotPrepareHTMLSkeleton(YVOR) = $$$YES set YEXEC = "#"_YEXEC  //Do Not Prepare HTML Skeleton
      if (mOp.Equal(include.WWWConst.$$$WWW120DoNotPrepareHTMLSkeleton(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$))) {
        YEXEC.set(mOp.Concat("#",YEXEC.get()));
      }
      //<< if ($piece(YVOR,Y,16)'="") && ($extract($PIECE(YVOR,Y,16),1)'=";") set YEXEC = "#"_YEXEC set YNOFOOT=1   //HTML already prepared
      if ((mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16),"")) && (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16),1),";"))) {
        YEXEC.set(mOp.Concat("#",YEXEC.get()));
        mVar YNOFOOT = m$.var("YNOFOOT");
        YNOFOOT.set(1);
      }
      //<< do PGMSTART^WWWMANU
      m$.Cmd.Do("WWWMANU.PGMSTART");
    }
    //<< }
    //<< 
    //<< IF $$EXIST^%R("Y"_YFORM_"onSave.OBJ",$GET(YUCI)) XECUTE "DO ^Y"_YFORM_"onSave"  ;CUSTOMIZED EXECUTE;FIS;24947;03.02.04
    if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"onSave.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
      m$.Cmd.Xecute(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),"onSave"));
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Form Type 2  : LIST GENERATOR
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< IF $$$WWW120FormType(YVOR)=2 DO
    if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),2)) {
      do {
        //<< . QUIT:$GET(YNOLIST)=1  ;LISTE NICHTMEHR ANZEIGEN NACH MANUELLEM EXECUTE;TYBD;23,6,2004;25978
        if (mOp.Equal(m$.Fnc.$get(m$.var("YNOLIST")),1)) {
          break;
        }
        //<< . DO ^WWWLIST0          ;LISTGENERATOR
        m$.Cmd.Do("WWWLIST0.main");
      } while (false);
    }
    //<< 
    //<< LOCK -^WWWUSER(0,YUSER)
    m$.Cmd.Unlock(m$.var("^WWWUSER",0,m$.var("YUSER").get()));
    //<< QUIT
    return;
  }

  //<< 
  //<< OnBeforeSave()
  public Object OnBeforeSave(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Run OnBeforeSave code (if not doing hyper validation)
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  boolean - whether to stop save happening
    //<< ;
    //<< ; History:
    //<< ; 27-Sep-2007   GRF     SR15603: Macro change
    //<< ; 10-Aug-2006   JW      SR13594: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnStop,strExec
    mVar blnStop = m$.var("blnStop");
    mVar strExec = m$.var("strExec");
    m$.newVar(blnStop,strExec);
    //<< 
    //<< if '$$$HYPERValidation(YFORM) do
    if (mOp.Not(include.COMSYS.$$$HYPERValidation(m$,m$.var("YFORM")))) {
      do {
        //<< . ;
        //<< . set strExec = $$$WWW120ExecuteOnBeforeSaveData(YVOR)
        strExec.set(include.WWWConst.$$$WWW120ExecuteOnBeforeSaveData(m$,m$.var("YVOR")));
        //<< . IF '$DATA(^WWWSOR(YUSER,1))#10=1 IF strExec'="" SET:$EXTRACT(strExec)="#" strExec=$EXTRACT(strExec,2,99) DO ^WWWFORM5 XECUTE strExec IF $GET(Q)=1 DO  QUIT  ;;EXECUTE VOR SPEICHERN Q:FORMULAR FERTIG ;EXECUTE pre- Save ready-made
        if (mOp.Equal(mOp.Modulus(mOp.Not(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),1))),10),1)) {
          if (mOp.NotEqual(strExec.get(),"")) {
            if (mOp.Equal(m$.Fnc.$extract(strExec.get()),"#")) {
              strExec.set(m$.Fnc.$extract(strExec.get(),2,99));
            }
            m$.Cmd.Do("WWWFORM5.main");
            m$.Cmd.Xecute(strExec.get());
            if (mOp.Equal(m$.Fnc.$get(m$.var("Q")),1)) {
              //<< . . IF $$$WWWUSERHTMLStarted(^WWWUSER(0,YUSER,1))="" DO    ;TYBD;ALTE WERTE ANZEIGEN BEI FEHLER ;display next to shortcoming
              if (mOp.Equal(include.WWWConst.$$$WWWUSERHTMLStarted(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),"")) {
                //<< . . . SET %("VAR","YKEY")=$GET(YKEY)  ;KEY
                m$.var("%","VAR","YKEY").set(m$.Fnc.$get(m$.var("YKEY")));
                //<< . . . SET ^WWWUSE(0,YUSER,YFORM,"D",1)=YFELD
                m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1).set(m$.var("YFELD").get());
                //<< . . . SET YKILL=2
                mVar YKILL = m$.var("YKILL");
                YKILL.set(2);
                //<< . . . IF $GET(YAEND)=1 SET YKILL=3
                if (mOp.Equal(m$.Fnc.$get(m$.var("YAEND")),1)) {
                  YKILL.set(3);
                }
                //<< . . . SET %("VAR","YKILL")=YKILL
                m$.var("%","VAR","YKILL").set(YKILL.get());
                //<< . . . DO ^WWWFORM
                m$.Cmd.Do("WWWFORM.main");
              }
              break;
            }
          }
        }
        //<< . ;
        //<< . IF '$DATA(^WWWSOR(YUSER,1))#10=1 IF $$EXIST^%R("Y"_YFORM_"onBeforeSave.OBJ",$GET(YUCI)) DO ^WWWFORM5 XECUTE "DO ^Y"_YFORM_"onBeforeSave" IF $GET(Q)=1 DO  QUIT  ;CUSTOMIZING EXECUTE VOR SPEICHERN Q:FORMULAR FERTIG;FIS;11.03.04;25316
        if (mOp.Equal(mOp.Modulus(mOp.Not(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),1))),10),1)) {
          if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"onBeforeSave.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
            m$.Cmd.Do("WWWFORM5.main");
            m$.Cmd.Xecute(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),"onBeforeSave"));
            if (mOp.Equal(m$.Fnc.$get(m$.var("Q")),1)) {
              //<< . . IF $$$WWWUSERHTMLStarted(^WWWUSER(0,YUSER,1))="" DO    ;TYBD;ALTE WERTE ANZEIGEN BEI FEHLER ;display next to shortcoming
              if (mOp.Equal(include.WWWConst.$$$WWWUSERHTMLStarted(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),"")) {
                //<< . . . SET %("VAR","YKEY")=$GET(YKEY)                       ;KEY
                m$.var("%","VAR","YKEY").set(m$.Fnc.$get(m$.var("YKEY")));
                //<< . . . SET ^WWWUSE(0,YUSER,YFORM,"D",1)=YFELD
                m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1).set(m$.var("YFELD").get());
                //<< . . . SET YKILL=2
                mVar YKILL = m$.var("YKILL");
                YKILL.set(2);
                //<< . . . IF $GET(YAEND)=1 SET YKILL=3
                if (mOp.Equal(m$.Fnc.$get(m$.var("YAEND")),1)) {
                  YKILL.set(3);
                }
                //<< . . . SET %("VAR","YKILL")=YKILL
                m$.var("%","VAR","YKILL").set(YKILL.get());
                //<< . . . DO ^WWWFORM
                m$.Cmd.Do("WWWFORM.main");
              }
              break;
            }
          }
        }
      } while (false);
    }
    //<< 
    //<< set blnStop = ($GET(Q)=1)
    blnStop.set((mOp.Equal(m$.Fnc.$get(m$.var("Q")),1)));
    //<< quit blnStop
    return blnStop.get();
  }

  //<< 
  //<< 
  //<< Wizard()
  public Object Wizard(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wizard form type
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Aug-2006   JW      SR13594: Created (encapsulated)
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YI,YBBN
    mVar YI = m$.var("YI");
    mVar YBBN = m$.var("YBBN");
    m$.newVar(YI,YBBN);
    do {
      //<< 
      //<< DO
      //<< . IF $GET(YOPTION)="" SET YOPTION=$GET(%(YQUERY,"YOPTION"))
      if (mOp.Equal(m$.Fnc.$get(m$.var("YOPTION")),"")) {
        mVar YOPTION = m$.var("YOPTION");
        YOPTION.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YOPTION")));
      }
      //<< . SET $PIECE(YOPTION,"#",10)=$PIECE($GET(YOPTION),"#",10)+1
      m$.pieceVar(m$.var("YOPTION"),"#",10).set(mOp.Add(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YOPTION")),"#",10),1));
      //<< . FOR YI=1:1:9  IF $GET(YKEY(YI))'=""     SET $PIECE(YOPTION,"#",YI)=$GET(YKEY(YI))   SET $PIECE(YOPTION,"#",10)=""  ;PRIMÄRSCHLÜSSEL SICHERN ;safeguard
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),9));YI.set(mOp.Add(YI.get(),1))) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY").var(YI.get())),"")) {
          m$.pieceVar(m$.var("YOPTION"),"#",YI.get()).set(m$.Fnc.$get(m$.var("YKEY").var(YI.get())));
          m$.pieceVar(m$.var("YOPTION"),"#",10).set("");
        }
      }
      //<< . FOR YI=1:1:70 IF $PIECE(YFELD,Y,YI)'="" SET $PIECE(YPARA,"#",YI)=$PIECE(YFELD,Y,YI) SET $PIECE(YOPTION,"#",10)=YI  ;DATENFELDER UND MERKER FÜR LFD FELD ;And to field
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),70));YI.set(mOp.Add(YI.get(),1))) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),YI.get()),"")) {
          m$.pieceVar(m$.var("YPARA"),"#",YI.get()).set(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),YI.get()));
          m$.pieceVar(m$.var("YOPTION"),"#",10).set(YI.get());
        }
      }
      //<< . IF $GET(YOPTION)'="" SET %("VAR","YOPTION")=YOPTION
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YOPTION")),"")) {
        m$.var("%","VAR","YOPTION").set(m$.var("YOPTION").get());
      }
      //<< . IF $GET(YPARA)'=""   SET %("VAR","YPARA")  =YPARA
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YPARA")),"")) {
        m$.var("%","VAR","YPARA").set(m$.var("YPARA").get());
      }
      //<< . ;
      //<< . SET YBBN=$PIECE($GET(YOPTION),"#",10)
      YBBN.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YOPTION")),"#",10));
      //<< . SET YBBN=$ORDER(^WWW122s(0,5,$$^WWWUMLAU(YFORM,1),YBBN))
      YBBN.set(m$.Fnc.$order(m$.var("^WWW122s",0,5,m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1),YBBN.get())));
      //<< . IF YBBN'="" DO ^WWWFORM QUIT       ;WEITERER FELDER
      if (mOp.NotEqual(YBBN.get(),"")) {
        m$.Cmd.Do("WWWFORM.main");
        break;
      }
      //<< . SET YVOR=$GET(^WWW120(0,YFORM,1))  ;PRUEFEN EXECUTE
      mVar YVOR = m$.var("YVOR");
      YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
      //<< . KILL %("VAR","YPARA")
      m$.var("%","VAR","YPARA").kill();
      //<< . KILL %("VAR","YOPTION")
      m$.var("%","VAR","YOPTION").kill();
      //<< . KILL %(YQUERY,"YPARA")
      m$.var("%",m$.var("YQUERY").get(),"YPARA").kill();
      //<< . KILL %(YQUERY,"YOPTION")
      m$.var("%",m$.var("YQUERY").get(),"YOPTION").kill();
      //<< . IF $PIECE(YVOR,Y,59)'="" DO
      if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),59),"")) {
        //<< . . IF $EXTRACT($PIECE(YVOR,Y,59))="#" SET $PIECE(YVOR,Y,59)=$EXTRACT($PIECE(YVOR,Y,59),2,99)
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),59)),"#")) {
          m$.pieceVar(YVOR,m$.var("Y").get(),59).set(m$.Fnc.$extract(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),59),2,99));
        }
        //<< . . XECUTE $PIECE(YVOR,Y,59)  ;EXE NACH DATENFELD ;within data item
        m$.Cmd.Xecute(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),59));
      }
      //<< . ;
      //<< . IF $PIECE(YVOR,Y,16)'="" DO
      if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),16),"")) {
        //<< . . IF $EXTRACT($PIECE(YVOR,Y,16))="#" SET $PIECE(YVOR,Y,16)=$EXTRACT($PIECE(YVOR,Y,16),2,99)
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),16)),"#")) {
          m$.pieceVar(YVOR,m$.var("Y").get(),16).set(m$.Fnc.$extract(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),16),2,99));
        }
        //<< . . XECUTE $PIECE(YVOR,Y,16)  ;EXE NACH DATENFELD ;within data item
        m$.Cmd.Xecute(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),16));
      }
    } while(false);
    //<< 
    //<< QUIT
    return null;
  }

  //<< 
  //<< 
  //<< BufferSave()
  public Object BufferSave(Object ... _p) {
    do {
      //<< ;-------------------------------------------------------------------------------
      //<< ; Fast Save ?
      //<< ;
      //<< ; Params:
      //<< ;
      //<< ; ByRefs:
      //<< ;
      //<< ; Returns:
      //<< ;
      //<< ; History:
      //<< ; 08-Aug-2006   JW      SR13594: Created (encapsulated)
      //<< ;-------------------------------------------------------------------------------
      //<< do
      //<< . SET YMAXKEY = 0
      mVar YMAXKEY = m$.var("YMAXKEY");
      YMAXKEY.set(0);
      //<< . IF YDATEI'="" SET YMAXKEY = +$ORDER(^WWW002(0,YDATEI,""),-1)
      if (mOp.NotEqual(m$.var("YDATEI").get(),"")) {
        YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),""),mOp.Negative(1))));
      }
      //<< . SET YKEY = ""
      mVar YKEY = m$.var("YKEY");
      YKEY.set("");
      //<< . FOR YI=1:1:YMAXKEY SET YKEY = YKEY_$GET(YKEY(YI)) IF YI'=YMAXKEY SET YKEY=YKEY_","
      mVar YI = m$.var("YI");
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
        YKEY.set(mOp.Concat(YKEY.get(),m$.Fnc.$get(YKEY.var(YI.get()))));
        if (mOp.NotEqual(YI.get(),YMAXKEY.get())) {
          YKEY.set(mOp.Concat(YKEY.get(),","));
        }
      }
      //<< . SET FFFELD = $TRANSLATE(YFELD,$CHAR(13,10),"|")
      mVar FFFELD = m$.var("FFFELD");
      FFFELD.set(m$.Fnc.$translate(m$.var("YFELD").get(),m$.Fnc.$char(13,10),"|"));
      //<< . SET FMFELD = $TRANSLATE(YMFELD,$CHAR(13,10),"|")
      mVar FMFELD = m$.var("FMFELD");
      FMFELD.set(m$.Fnc.$translate(m$.var("YMFELD").get(),m$.Fnc.$char(13,10),"|"));
      //<< . SET FFKEY  = YKEY
      mVar FFKEY = m$.var("FFKEY");
      FFKEY.set(YKEY.get());
      //<< . SET FFFORM = YFORM
      mVar FFFORM = m$.var("FFFORM");
      FFFORM.set(m$.var("YFORM").get());
      //<< . DO ^WWWFORM2  ;SPEICHERN ;Save
      m$.Cmd.Do("WWWFORM2.main");
      //<< . IF $EXTRACT(YOPEN,5,8)="HELP" SET %("VAR","EP")="WWWHELP"      DO ^WWWHELP  QUIT  ;HILFE ;help
      if (mOp.Equal(m$.Fnc.$extract(m$.var("YOPEN").get(),5,8),"HELP")) {
        m$.var("%","VAR","EP").set("WWWHELP");
        m$.Cmd.Do("WWWHELP.main");
        break;
      }
      //<< . IF $FIND(YOPEN,"^") SET YEXEC=$PIECE(YOPEN,"#",2) IF YEXEC'="" XECUTE YEXEC QUIT  ;SONDER EXECUTE
      if (mOp.Logical(m$.Fnc.$find(m$.var("YOPEN").get(),"^"))) {
        mVar YEXEC = m$.var("YEXEC");
        YEXEC.set(m$.Fnc.$piece(m$.var("YOPEN").get(),"#",2));
        if (mOp.NotEqual(YEXEC.get(),"")) {
          m$.Cmd.Xecute(YEXEC.get());
          break;
        }
      }
      //<< . IF $EXTRACT(YOPEN,5,8)="SEAR" DO ^WWWSEAR                                   QUIT  ;SUCHEN ;search
      if (mOp.Equal(m$.Fnc.$extract(m$.var("YOPEN").get(),5,8),"SEAR")) {
        m$.Cmd.Do("WWWSEAR.main");
        break;
      }
      //<< . IF $EXTRACT(YOPEN,5,8)="FORM" DO  QUIT
      if (mOp.Equal(m$.Fnc.$extract(m$.var("YOPEN").get(),5,8),"FORM")) {
        //<< . . NEW YFORM1
        mVar YFORM1 = m$.var("YFORM1");
        m$.newVarBlock(2,YFORM1);
        //<< . . SET YFORM1=YFORM
        YFORM1.set(m$.var("YFORM").get());
        //<< . . SET YFORM=$EXTRACT(YOPEN,9,99)
        mVar YFORM = m$.var("YFORM");
        YFORM.set(m$.Fnc.$extract(m$.var("YOPEN").get(),9,99));
        //<< . . SET %("VAR","YFORM")=$PIECE(YFORM,"|",1)
        m$.var("%","VAR","YFORM").set(m$.Fnc.$piece(YFORM.get(),"|",1));
        //<< . . IF $PIECE(YFORM,"|",1)'="" IF +$PIECE($GET(^WWW121(0,$PIECE(YFORM,"|",1),1,1)),Y,16)'=0 SET %("VAR","YKEY")=YKEY  ;WENN VORGABE BENÖTIGT ;when default
        if (mOp.NotEqual(m$.Fnc.$piece(YFORM.get(),"|",1),"")) {
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.Fnc.$piece(YFORM.get(),"|",1),1,1)),m$.var("Y").get(),16)),0)) {
            m$.var("%","VAR","YKEY").set(YKEY.get());
          }
        }
        //<< . . ;SET YMAP=$PIECE(YFORM,"|",2)
        //<< . . SET YMAP=$$^WWWTRANSLATE($PIECE(YFORM,"|",2),"&quot;","""")  ;FIS;13.01.04;ANFÜHRUNGSZEICHEN ÜBERGEBEN
        mVar YMAP = m$.var("YMAP");
        YMAP.set(m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YFORM.get(),"|",2),"&quot;","\""));
        //<< . . IF YMAP'="" DO
        if (mOp.NotEqual(YMAP.get(),"")) {
          //<< . . . DO
          do {
            //<< . . . . IF $EXTRACT($PIECE(YMAP,"=",1))="""" SET $PIECE(YKEY,",",+$PIECE(YMAP,"=",2)) = $TRANSLATE($PIECE(YMAP,"=",1),"""")                  QUIT  ;FIS;13.01.04;FESTER WERT ;worthy
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YMAP.get(),"=",1)),"\"")) {
              m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(YMAP.get(),"=",2))).set(m$.Fnc.$translate(m$.Fnc.$piece(YMAP.get(),"=",1),"\""));
              break;
            }
            //<< . . . . IF $EXTRACT($PIECE(YMAP,"=",1))="P"  SET $PIECE(YKEY,",",+$PIECE(YMAP,"=",2)) = $PIECE(FFKEY,",",+$EXTRACT($PIECE(YMAP,"=",1),2,99)) QUIT  ;FIS;27.09.04;26416;AUS PRIMÄRSCHLÜSSEL
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YMAP.get(),"=",1)),"P")) {
              m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(YMAP.get(),"=",2))).set(m$.Fnc.$piece(FFKEY.get(),",",mOp.Positive(m$.Fnc.$extract(m$.Fnc.$piece(YMAP.get(),"=",1),2,99))));
              break;
            }
            //<< . . . . SET $PIECE(YKEY,",",+$PIECE(YMAP,"=",2)) = $PIECE(FFFELD,Y,+$PIECE(YMAP,"=",1))  ;AUS DATENFELD ;out of data item
            m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(YMAP.get(),"=",2))).set(m$.Fnc.$piece(FFFELD.get(),m$.var("Y").get(),mOp.Positive(m$.Fnc.$piece(YMAP.get(),"=",1))));
          } while(false);
          //<< . . . ;
          //<< . . . SET %("VAR","YKEY") = YKEY
          m$.var("%","VAR","YKEY").set(YKEY.get());
          //<< . . . SET ^WWWUSE(0,YUSER,YFORM1,"D",1) = FFFELD
          m$.var("^WWWUSE",0,m$.var("YUSER").get(),YFORM1.get(),"D",1).set(FFFELD.get());
          //<< . . . SET ^WWWUSE(0,YUSER,YFORM1,"M",1) = FMFELD
          m$.var("^WWWUSE",0,m$.var("YUSER").get(),YFORM1.get(),"M",1).set(FMFELD.get());
          //<< . . . SET ^WWWUSE(0,YUSER,YFORM1,"P",1) = FFKEY
          m$.var("^WWWUSE",0,m$.var("YUSER").get(),YFORM1.get(),"P",1).set(FFKEY.get());
        }
        //<< . . ;
        //<< . . DO ^WWWFORM
        m$.Cmd.Do("WWWFORM.main");
        break;
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . IF $EXTRACT(YOPEN,5,8)="EXEC" SET YEXEC=$EXTRACT(YOPEN,9,99) SET %("VAR","YEXEC")=YEXEC SET:$TRANSLATE($GET(YKEY),"+")'="" %("VAR","YKEY")=YKEY DO ^WWWMANU
      if (mOp.Equal(m$.Fnc.$extract(m$.var("YOPEN").get(),5,8),"EXEC")) {
        mVar YEXEC = m$.var("YEXEC");
        YEXEC.set(m$.Fnc.$extract(m$.var("YOPEN").get(),9,99));
        m$.var("%","VAR","YEXEC").set(YEXEC.get());
        if (mOp.NotEqual(m$.Fnc.$translate(m$.Fnc.$get(YKEY),"+"),"")) {
          m$.var("%","VAR","YKEY").set(YKEY.get());
        }
        m$.Cmd.Do("WWWMANU.main");
      }
      //<< . IF $EXTRACT(YOPEN,5,8)="MANU" SET YEXEC=$EXTRACT(YOPEN,9,99) SET %("VAR","YEXEC")=YEXEC SET:$TRANSLATE($GET(YKEY),"+")'="" %("VAR","YKEY")=YKEY DO ^WWWMANU1
      if (mOp.Equal(m$.Fnc.$extract(m$.var("YOPEN").get(),5,8),"MANU")) {
        mVar YEXEC = m$.var("YEXEC");
        YEXEC.set(m$.Fnc.$extract(m$.var("YOPEN").get(),9,99));
        m$.var("%","VAR","YEXEC").set(YEXEC.get());
        if (mOp.NotEqual(m$.Fnc.$translate(m$.Fnc.$get(YKEY),"+"),"")) {
          m$.var("%","VAR","YKEY").set(YKEY.get());
        }
        m$.Cmd.Do("WWWMANU1.main");
      }
    } while(false);
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetInputType(pidClass,pintField,pidForm)
  public Object GetInputType(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintField = m$.newVarRef("pintField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines the InputType, including customisation if YFORM is defined
    //<< ;
    //<< ; Called By: Validate^WWWSAVED, START^WWWSAVE (2), ^WWWSAVV, START^WWWSAVE
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Dec-2008   GRF     SR16123: InputType need not be "int".
    //<< ; 06-Nov-2008   shobby  SR16123
    //<< ;-------------------------------------------------------------------------------
    //<< new enumInputType
    mVar enumInputType = m$.var("enumInputType");
    m$.newVar(enumInputType);
    //<< 
    //<< set enumInputType = $$$WWW003InputType($GET(^WWW003(0,pidClass,pintField,1)))
    enumInputType.set(include.WWWConst.$$$WWW003InputType(m$,m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),pintField.get(),1))));
    //<< if (pidForm'="") && ($order(^WWW122s(0,4,pintField,pidForm,""))'="") {
    if ((mOp.NotEqual(pidForm.get(),"")) && (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW122s",0,4,pintField.get(),pidForm.get(),"")),""))) {
      //<< set enumInputType = $$$WWW122InputType($$Get^WWW122(pidForm,$order(^WWW122s(0,4,pintField,pidForm,""))))
      enumInputType.set(include.WWWConst.$$$WWW122InputType(m$,m$.fnc$("WWW122.Get",pidForm.get(),m$.Fnc.$order(m$.var("^WWW122s",0,4,pintField.get(),pidForm.get(),"")))));
    }
    //<< }
    //<< quit enumInputType
    return enumInputType.get();
  }

//<< 
//<< 
}
