//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWERROR
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:20
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

//<< WWWERROR
public class WWWERROR extends mClass {

  public void main() {
    _WWWERROR();
  }

  public void _WWWERROR() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ERRORHANDLING
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 20-Jul-2009   GRF     Data & boolean macros; doco
    //<< ; 27-Mar-2008   GRF     SR15647: Add a second's delay to ensure not being over-written
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 11.10.2000    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< NEW INFO,ERRNUM
    mVar INFO = m$.var("INFO");
    mVar ERRNUM = m$.var("ERRNUM");
    m$.newVar(INFO,ERRNUM);
    //<< 
    //<< ; D113  $$$WWW012ErrorTrappingWithVariable()
    //<< ; D114  $$$WWW012ExecuteErrorTrapping()
    //<< 
    //<< SET YERROR=$ZERROR
    mVar YERROR = m$.var("YERROR");
    YERROR.set(m$.Fnc.$zerror());
    //<< SET $ZTRAP=""  ;TYBD;25,11,2004;BEWIDATA REQUEST
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("");
    //<< 
    //<< ;---------------------------------------
    //<< ; *** EXECUTE # ***
    //<< ;---------------------------------------
    //<< 
    //<< IF '$FIND(YERROR,"<WRITE>") IF $GET(YM)'="" IF $GET(Y)'="" IF $$$WWW012ExecuteErrorTrapping($GET(^WWW012(0,YM,1)))'="" DO  QUIT  ; MANDANTENSPEZIFISCHE ERROR TRAPPING
    if (mOp.Not(m$.Fnc.$find(YERROR.get(),"<WRITE>"))) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YM")),"")) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("Y")),"")) {
          if (mOp.NotEqual(include.WWWConst.$$$WWW012ExecuteErrorTrapping(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))),"")) {
            //<< . IF $$$WWW012ErrorTrappingWithVariable(^WWW012(0,YM,1))=$$$YES DO BACK^%ETN  ;ERRORTRAP CACHE
            if (mOp.Equal(include.WWWConst.$$$WWW012ErrorTrappingWithVariable(m$,m$.var("^WWW012",0,m$.var("YM").get(),1)),include.COMSYS.$$$YES(m$))) {
              m$.Cmd.Do("$ETN.BACK");
            }
            //<< . XECUTE $$$WWW012ExecuteErrorTrapping(^WWW012(0,YM,1))
            m$.Cmd.Xecute(include.WWWConst.$$$WWW012ExecuteErrorTrapping(m$,m$.var("^WWW012",0,m$.var("YM").get(),1)));
            return;
          }
        }
      }
    }
    //<< 
    //<< ;LOOP  SICHERUNG WEGEN ERROR IN ERROR ;TYBD;19.05.2003 ;quibble within
    //<< IF $GET(YUSER)'="" IF +$GET(YTRAKT)'=0 DO
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("YTRAKT"))),0)) {
        //<< . IF YTRAKT>10000                                           DO CLOSE^WWWSTART HALT  ;ENDE ;termination
        if (mOp.Greater(m$.var("YTRAKT").get(),10000)) {
          m$.Cmd.Do("WWWSTART.CLOSE");
        }
        //<< . IF $GET(^WWWZWS(0,+$HOROLOG,YUSER,"X","YTRAKT",1))=YTRAKT DO CLOSE^WWWSTART HALT  ;ENDE ;termination
        if (mOp.Equal(m$.Fnc.$get(m$.var("^WWWZWS",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),"X","YTRAKT",1)),m$.var("YTRAKT").get())) {
          m$.Cmd.Do("WWWSTART.CLOSE");
        }
      }
    }
    //<< ;. SET ^WWWZWS(0,+$H,YUSER,"X","YTRAKT",1)=YTRAKT
    //<< 
    //<< SET ERRNUM=""
    ERRNUM.set("");
    //<< IF ($GET(YM)'="") && ($GET(Y)'="") && ($$$WWW012ErrorTrappingWithVariable($GET(^WWW012(0,YM,1)))=$$$YES) {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YM")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("Y")),"")) && (mOp.Equal(include.WWWConst.$$$WWW012ErrorTrappingWithVariable(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))),include.COMSYS.$$$YES(m$)))) {
      //<< SET ERRNUM = " / Error #"_(+$GET(^ERRORS(+$HOROLOG))+1) ;FIS;21.05.04;25690;NUMMER IN ^ERRORS
      ERRNUM.set(mOp.Concat(" / Error #",(mOp.Add(mOp.Positive(m$.Fnc.$get(m$.var("^ERRORS",mOp.Positive(m$.Fnc.$horolog())))),1))));
    }
    //<< }
    //<< LOCK -^WWWSOR(+$GET(YUSER))       ;FREE JOB
    m$.Cmd.Unlock(m$.var("^WWWSOR",mOp.Positive(m$.Fnc.$get(m$.var("YUSER")))));
    //<< DO OPEN^WWWSTART                  ;GGF DEVICE FALSCH ;wrong
    m$.Cmd.Do("WWWSTART.OPEN");
    //<< IF '$FIND(YERROR,"<WRITE>") {
    if (mOp.Not(m$.Fnc.$find(YERROR.get(),"<WRITE>"))) {
      //<< SET ^WWWERROR(0,+$HOROLOG,$PIECE($HOROLOG,",",2),+$GET(YUSER),1)=YERROR_" / http:"_ERRNUM_" / "_$GET(YBED)
      m$.var("^WWWERROR",0,mOp.Positive(m$.Fnc.$horolog()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),mOp.Positive(m$.Fnc.$get(m$.var("YUSER"))),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YERROR.get()," / http:"),ERRNUM.get())," / "),m$.Fnc.$get(m$.var("YBED"))));
      //<< hang 1       ; SR15647
      m$.Cmd.Hang(1);
    }
    //<< }
    //<< SET INFO = $$^WWWTEXT(387)_"|Info : "_$PIECE($PIECE(YERROR,"<",2),">",1)_"|Prog.: "_$PIECE(YERROR,">",2,9)
    INFO.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",387),"|Info : "),m$.Fnc.$piece(m$.Fnc.$piece(YERROR.get(),"<",2),">",1)),"|Prog.: "),m$.Fnc.$piece(YERROR.get(),">",2,9)));
    //<< ; "An Internal ERROR Has Occurred In Your Application."
    //<< 
    //<< if ($get(YBED)'="")                  &&
    //<< (+$$^WWWBEDBER(YBED)=1)           &&
    //<< ($get(YMANDANT)="Development")    &&
    //<< ($$^WWWACCESS(,"WWW")=1)          &&
    //<< $find($piece(YERROR,">",2,9),"^")    {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) && (mOp.Equal(mOp.Positive(m$.fnc$("WWWBEDBER.main",m$.var("YBED").get())),1)) && (mOp.Equal(m$.Fnc.$get(m$.var("YMANDANT")),"Development")) && (mOp.Equal(m$.fnc$("WWWACCESS.main",null,"WWW"),1)) && mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YERROR.get(),">",2,9),"^"))) {
      //<< 
      //<< SET INFO=INFO_"|Code: "_$TEXT(@$PIECE(YERROR,">",2,9))
      INFO.set(mOp.Concat(mOp.Concat(INFO.get(),"|Code: "),m$.Fnc.$text(m$.indirectVar(m$.Fnc.$piece(YERROR.get(),">",2,9)).get())));
    }
    //<< }
    //<< 
    //<< IF $FIND(YERROR,"<EDITED>") SET INFO = "Update Is In Process."  ;tybd;edited;30,9,2004;26492    ; FIXME : WWW009 text <GRF>
    if (mOp.Logical(m$.Fnc.$find(YERROR.get(),"<EDITED>"))) {
      INFO.set("Update Is In Process.");
    }
    //<< 
    //<< DO ^WWWINFO(INFO)
    m$.Cmd.Do("WWWINFO.main",INFO.get());
    //<< IF $GET(YUSER)'="" DO
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      do {
        //<< . QUIT:$GET(Y)=""
        if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
          break;
        }
        //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,5)  = $$$NO    ;HTML AUS ;HTML out of     ; $$$WWWUSERHTMLStarted
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),5).set(include.COMSYS.$$$NO(m$));
        //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,6)  = $$$NO    ;BODY AUS ;out of
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),6).set(include.COMSYS.$$$NO(m$));
        //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,9)  = $$$NO    ;FORMULAR AUS ;form out of
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),9).set(include.COMSYS.$$$NO(m$));
        //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,10) = $$$NO    ;KOPF AUS ;pate out of
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),10).set(include.COMSYS.$$$NO(m$));
        //<< . LOCK +^WWWSOR(YUSER,"PAGE"):2                   ;CHECK AUF SEITE;TYBD;19,12,2003
        m$.Cmd.LockInc(m$.var("^WWWSOR",m$.var("YUSER").get(),"PAGE"),2);
        //<< . LOCK -^WWWSOR(YUSER,"PAGE")
        m$.Cmd.Unlock(m$.var("^WWWSOR",m$.var("YUSER").get(),"PAGE"));
        //<< . KILL ^WWWSOR(YUSER)
        m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
      } while (false);
    }
    //<< 
    //<< IF $GET(YM)'="" IF $GET(Y)'="" IF $$$WWW012ErrorTrappingWithVariable($GET(^WWW012(0,YM,1)))=$$$YES DO BACK^%ETN  ;ERRORTRAP CACHE
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YM")),"")) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("Y")),"")) {
        if (mOp.Equal(include.WWWConst.$$$WWW012ErrorTrappingWithVariable(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))),include.COMSYS.$$$YES(m$))) {
          m$.Cmd.Do("$ETN.BACK");
        }
      }
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< XML ;XMLERROR
  public void XML() {
    //<< ;SET $ZE="XML^WWWERROR"
    //<< SET YERROR=$ZERROR
    mVar YERROR = m$.var("YERROR");
    YERROR.set(m$.Fnc.$zerror());
    //<< SET $ZTRAP=""
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("");
    //<< LOCK -^WWWSOR(+$GET(YUSER))  ;FREE JOB
    m$.Cmd.Unlock(m$.var("^WWWSOR",mOp.Positive(m$.Fnc.$get(m$.var("YUSER")))));
    //<< DO OPEN^WWWSTART             ;GGF DEVICE FALSCH ;wrong
    m$.Cmd.Do("WWWSTART.OPEN");
    //<< SET ^WWWERROR(0,+$HOROLOG,$PIECE($HOROLOG,",",2),+$GET(YUSER),1) = YERROR_" / xml / "_$GET(YBED)
    m$.var("^WWWERROR",0,mOp.Positive(m$.Fnc.$horolog()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),mOp.Positive(m$.Fnc.$get(m$.var("YUSER"))),1).set(mOp.Concat(mOp.Concat(YERROR.get()," / xml / "),m$.Fnc.$get(m$.var("YBED"))));
    //<< hang 1       ; SR15647
    m$.Cmd.Hang(1);
    //<< 
    //<< DO ^WWWXMLMSG(387,$TRANSLATE(YERROR,"><","  "))
    m$.Cmd.Do("WWWXMLMSG.main",387,m$.Fnc.$translate(YERROR.get(),"><","  "));
    //<< IF $GET(YUSER)'="" DO
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      //<< . LOCK +^WWWSOR(YUSER,"PAGE"):2   ;CHECK AUF SEITE;TYBD;19,12,2003
      m$.Cmd.LockInc(m$.var("^WWWSOR",m$.var("YUSER").get(),"PAGE"),2);
      //<< . LOCK -^WWWSOR(YUSER,"PAGE")
      m$.Cmd.Unlock(m$.var("^WWWSOR",m$.var("YUSER").get(),"PAGE"));
      //<< . KILL ^WWWSOR(YUSER)
      m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
    }
    //<< 
    //<< IF $GET(YM)'="" IF $GET(Y)'="" IF $$$WWW012ErrorTrappingWithVariable($GET(^WWW012(0,YM,1)))=$$$YES DO BACK^%ETN  ;ERRORTRAP CACHE
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YM")),"")) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("Y")),"")) {
        if (mOp.Equal(include.WWWConst.$$$WWW012ErrorTrappingWithVariable(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))),include.COMSYS.$$$YES(m$))) {
          m$.Cmd.Do("$ETN.BACK");
        }
      }
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< BACKGROUND ;BACKGROUND
  public void BACKGROUND() {
    //<< ;SET $ZE="BACKGROUND^WWWERROR"
    //<< 
    //<< $$$JournalOff
    include.COMDebug.$$$JournalOff(m$);
    //<< 
    //<< set YERROR=$ZERROR
    mVar YERROR = m$.var("YERROR");
    YERROR.set(m$.Fnc.$zerror());
    //<< set $ZTRAP=""
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("");
    //<< LOCK -^WWWSOR(+$GET(YUSER))  ;FREE JOB
    m$.Cmd.Unlock(m$.var("^WWWSOR",mOp.Positive(m$.Fnc.$get(m$.var("YUSER")))));
    //<< set ^WWWERROR(0,+$HOROLOG,$PIECE($HOROLOG,",",2),+$GET(YUSER),1) = YERROR_" / Background / "_$GET(YBED)
    m$.var("^WWWERROR",0,mOp.Positive(m$.Fnc.$horolog()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),mOp.Positive(m$.Fnc.$get(m$.var("YUSER"))),1).set(mOp.Concat(mOp.Concat(YERROR.get()," / Background / "),m$.Fnc.$get(m$.var("YBED"))));
    //<< hang 1       ; SR15647
    m$.Cmd.Hang(1);
    //<< 
    //<< IF $GET(YM)'="" IF $GET(Y)'="" IF $$$WWW012ErrorTrappingWithVariable($GET(^WWW012(0,YM,1)))=$$$YES DO BACK^%ETN  ;ERRORTRAP CACHE
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YM")),"")) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("Y")),"")) {
        if (mOp.Equal(include.WWWConst.$$$WWW012ErrorTrappingWithVariable(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))),include.COMSYS.$$$YES(m$))) {
          m$.Cmd.Do("$ETN.BACK");
        }
      }
    }
    //<< 
    //<< $$$JournalOn
    include.COMDebug.$$$JournalOn(m$);
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< SetError(pstrErrorText) ;create manual error entry
  public Object SetError(Object ... _p) {
    mVar pstrErrorText = m$.newVarRef("pstrErrorText",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function : create manual error entry
    //<< ;
    //<< ; History :
    //<< ; 27-Mar-2008   GRF     SR15647: Add a second's delay to ensure not being over-written
    //<< ; 15-Jan-2008   FIS     SRBR014564: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set ^WWWERROR(0,+$HOROLOG,$PIECE($HOROLOG,",",2),+$GET(YUSER),1) = pstrErrorText_" / MANUAL ENTRY / "_$GET(YBED)
    m$.var("^WWWERROR",0,mOp.Positive(m$.Fnc.$horolog()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),mOp.Positive(m$.Fnc.$get(m$.var("YUSER"))),1).set(mOp.Concat(mOp.Concat(pstrErrorText.get()," / MANUAL ENTRY / "),m$.Fnc.$get(m$.var("YBED"))));
    //<< hang 1       ; SR15647
    m$.Cmd.Hang(1);
    //<< quit
    return null;
  }

//<< 
//<< 
}
