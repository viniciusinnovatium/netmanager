//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWEVENT
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:16
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
//<< #include COMConst
import include.COMConst;
//<< #include INConst
import include.INConst;

//<< WWWEVENT
public class WWWEVENT extends mClass {

  //<< 
  //<< #define InternalCurrency(%1) $$GetInternal^WWWTR(8,%1)
  public static Object $$$InternalCurrency(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("WWWTR.GetInternal",8,p$1.get()));
  }

  //<< #define InternalForEx(%1)    $$GetInternal^WWWTR(18,%1)
  public static Object $$$InternalForEx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("WWWTR.GetInternal",18,p$1.get()));
  }

  //<< #define LiteralCurrency(%1)  $$GetLiteral^WWWTR(8,%1)
  public static Object $$$LiteralCurrency(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("WWWTR.GetLiteral",8,p$1.get()));
  }

  //<< 
  //<< #define LogRuser        "xxx"
  public static Object $$$LogRuser(mContext m$) {
    return ("xxx");
  }

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

  //<< #define LogR2(%1,%2)    ;
  public static Object $$$LogR2(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogR2x(%1)      ;
  public static Object $$$LogR2x(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogR3(%1,%2)    ;
  public static Object $$$LogR3(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogR3x(%1)      ;
  public static Object $$$LogR3x(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogR3m(%1)      ;
  public static Object $$$LogR3m(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogR4(%1,%2)    ;
  public static Object $$$LogR4(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogR4x(%1)      ;
  public static Object $$$LogR4x(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _WWWEVENT();
  }

  public void _WWWEVENT() {
    //<< 
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWEVENT("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogR2(%1,%2)   $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWEVENT("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogR2x(%1)     $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogR3(%1,%2)   $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWEVENT("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogR3x(%1)     $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogR3m(%1)     $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogR4(%1,%2)   $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWEVENT("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogR4x(%1)     $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< #; Change LogRuser as required to limit output
    //<< #;define LogRuser       "PAULPPDA"
    //<< #;define LogR2(%1,%2)   if $g(YBED)=$$$LogRuser $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWEVENT("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogR2x(%1)     if $g(YBED)=$$$LogRuser $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogR3(%1,%2)   if $g(YBED)=$$$LogRuser $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWEVENT("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogR3x(%1)     if $g(YBED)=$$$LogRuser $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogR3m(%1)     if $g(YBED)=$$$LogRuser $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogR4(%1,%2)   if $g(YBED)=$$$LogRuser $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWEVENT("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogR4x(%1)     if $g(YBED)=$$$LogRuser $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       EVENTBROKER
    //<< ;
    //<< ; ByRef :
    //<< ;   %REQUEST(1)
    //<< ;
    //<< ; History :
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tags for WWWTR calls
    //<< ; 14-Sep-2010   shobby  SR17544: Firefox and IE handle carriage returns in memo text fields
    //<< ;                   differently.  IE=$char(13,10) and FF=$char(10).  Internal processing of @netManager
    //<< ;                   assumes IE standard.  Put a translation layer in for FF.
    //<< ; 06-Aug-2010   shobby  SR17488: YUSER would always be created if YBED was not defined.
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR;
    //<< ;                           Activate AdjustCurrencyAmount
    //<< ; 19-Aug-2008   FIS     SR15853: re-use session id rather creating new one
    //<< ; 03-Apr-2007   JW      SR15384: Cleaned up. Removed PRIM call.
    //<< ; 12-Oct-2006   RPW     SR14914: Added new micro ops so that the editor can
    //<< ;                       stay on top and "populate" the window on save.
    //<< ; 24-Aug-2006   FrankF  BR014066: Setting the page number into WWWUSER.
    //<< ; 24-Aug-2006   JW      SR14939: Missed a translation
    //<< ; 10-Aug-2006   JW      SR13594: Translate (') to (`)
    //<< ; 02-Jun-2006   GRF     Doco
    //<< ;  9-Dec-2005   JW      SR13195: Created wrapper for FIELD
    //<< ; 30-May-2005   RobertW SR12056: Attempt at Performance Increase
    //<< ; 23.07.2004    FIS
    //<< ; 07.07.2004    BEC     25984
    //<< ; 25.05.2004    FIS     25727
    //<< ; 19.03.2003    FIS
    //<< ; 14.03.2003    FIS
    //<< ;               DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   AlertFollowing      "!"
    //<< ;   AlertAndFocus       "§"
    //<< ;   Confirm             "&"
    //<< ;   Prompt              "?"
    //<< ;   Open                "@"
    //<< ;   Perform             "#"
    //<< ;   ParentPerform       "þ"
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< set %KEY("YUSER") = $piece(%REQUEST,".",2)  ;SR15853;re-use session id rather creating new one
    m$.var("%KEY","YUSER").set(m$.Fnc.$piece(m$.var("%REQUEST").get(),".",2));
    //<< if %KEY("YUSER")'="" set %KEY("YBED") = $piece($get(^WWWUSER(0,%KEY("YUSER"),1)),"~",2) ;SR17488
    if (mOp.NotEqual(m$.var("%KEY","YUSER").get(),"")) {
      m$.var("%KEY","YBED").set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("%KEY","YUSER").get(),1)),"~",2));
    }
    //<< do ^WWWVAR          ; NOTE : Re-establishes the variables every call.  Some may never change.
    m$.Cmd.Do("WWWVAR.main");
    //<< $$$LogR("","")
    $$$LogR(m$,"","");
    //<< $$$LogRm(%REQUEST)
    $$$LogRm(m$,m$.var("%REQUEST"));
    //<< $$$LogRx("------")
    $$$LogRx(m$,"------");
    //<< if YUSERAGENT="GECKO" set %REQUEST(1)=$replace(%REQUEST(1),$char(10),$char(13,10))  ;SR17544
    if (mOp.Equal(m$.var("YUSERAGENT").get(),"GECKO")) {
      m$.var("%REQUEST",1).set(m$.Fnc.$replace(m$.var("%REQUEST",1).get(),m$.Fnc.$char(10),m$.Fnc.$char(13,10)));
    }
    //<< new objSession,YXTEXT,FUNKTION
    mVar objSession = m$.var("objSession");
    mVar YXTEXT = m$.var("YXTEXT");
    mVar FUNKTION = m$.var("FUNKTION");
    m$.newVar(objSession,YXTEXT,FUNKTION);
    //<< 
    //<< set %TXT(1) = ""  ;VORGABE FALSCH ;default wrong
    m$.var("%TXT",1).set("");
    //<< set YXTEXT  = ""  ;EXTRA TEXT
    YXTEXT.set("");
    //<< set $ztrap="ERROR^WWWEVENT"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("ERROR^WWWEVENT");
    //<< 
    //<< ;SR18075 ->%REQUEST="NAMESPACE.USER.FORM.FELDNUMMER.FUNKTION.FIXKEY.VARIABEL"
    //<< ;->%REQUEST="NAMESPACE.USER.FORM.FELDNUMMER.FUNKTION.FIXKEY.SPRACHE.VARIABEL" ;SR18075
    //<< ;->%REQUEST(1)="VALUE"
    //<< if %REQUEST(1)="null"  set %REQUEST(1) = ""         ;FIS;19.03.03  -> nötig nach Installation von Java/ActiveX Applet ;necessary within from
    if (mOp.Equal(m$.var("%REQUEST",1).get(),"null")) {
      m$.var("%REQUEST",1).set("");
    }
    //<< if %REQUEST(1)="true"  set %REQUEST(1) = $$$YES     ;FIS;04.06.03  -> nötig nach Installation von Java 2 v1.4.2 ;necessary within from
    if (mOp.Equal(m$.var("%REQUEST",1).get(),"true")) {
      m$.var("%REQUEST",1).set(include.COMSYS.$$$YES(m$));
    }
    //<< if %REQUEST(1)="false" set %REQUEST(1) = $$$NO      ;FIS;04.06.03  -> nötig nach Installation von Java 2 v1.4.2 ;necessary within from
    if (mOp.Equal(m$.var("%REQUEST",1).get(),"false")) {
      m$.var("%REQUEST",1).set(include.COMSYS.$$$NO(m$));
    }
    //<< ; FIXME <JW> : Note - this is rubbish! piece 7 (now 8. shobby) is already used elsewhere - should not be used for tab.
    //<< ; And it doesn't seem to work either!
    //<< ;SRBR014066
    //<< ;SR18075 if +$piece($get(%REQUEST),".",7) > 0 {
    //<< if +$piece($get(%REQUEST),".",8) > 0 {  ;SR18075
    if (mOp.Greater(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("%REQUEST")),".",8)),0)) {
      //<< set YUSER      = $piece(%REQUEST,".",2)
      mVar YUSER = m$.var("YUSER");
      YUSER.set(m$.Fnc.$piece(m$.var("%REQUEST").get(),".",2));
      //<< set objSession = $get(^WWWUSER(0,YUSER,1))
      objSession.set(m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1)));
      //<< ;SR18075 set $$$WWWUSERLastFormpage(objSession) = $piece(%REQUEST,".",7)
      //<< set $$$WWWUSERLastFormpage(objSession) = $piece(%REQUEST,".",8) ;SR18075
      include.WWWConst.$$$WWWUSERLastFormpageSet(m$,objSession,m$.Fnc.$piece(m$.var("%REQUEST").get(),".",8));
      //<< do Save^COMUtils("WWWUSER", YUSER, objSession)
      m$.Cmd.Do("COMUtils.Save","WWWUSER",YUSER.get(),objSession.get());
    }
    //<< }
    //<< set FUNKTION = $piece($get(%REQUEST),".",5)
    FUNKTION.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("%REQUEST")),".",5));
    //<< 
    //<< if FUNKTION=1 quit    ; deprecated - prev called PRIM                           *** EARLY QUIT ***
    if (mOp.Equal(FUNKTION.get(),1)) {
      return;
    }
    //<< new YCROK                               ;UMBRUCH [|/$C(10,13)] ERLAUBEN  ;FIS,14.03.03
    mVar YCROK = m$.var("YCROK");
    m$.newVar(YCROK);
    //<< if FUNKTION=2 do FIELDWRAPPER                  ;Field validating
    if (mOp.Equal(FUNKTION.get(),2)) {
      m$.Cmd.Do("FIELDWRAPPER");
    }
    //<< if FUNKTION=3 do MSG                           ;FELD FÜR MELDUNGEN ;Field for messages
    if (mOp.Equal(FUNKTION.get(),3)) {
      m$.Cmd.Do("MSG");
    }
    //<< if FUNKTION=4 do SELWRAPPER^WWWEVENT1(1)       ;Add to multi-select field
    if (mOp.Equal(FUNKTION.get(),4)) {
      m$.Cmd.Do("WWWEVENT1.SELWRAPPER",1);
    }
    //<< if FUNKTION=5 do SELWRAPPER^WWWEVENT1(2)       ;Delete from multi-select
    if (mOp.Equal(FUNKTION.get(),5)) {
      m$.Cmd.Do("WWWEVENT1.SELWRAPPER",2);
    }
    //<< if FUNKTION=6 do MANU                          ;MANUELLER AUFRUF EINER ROUTINE ;Manual call of a routine
    if (mOp.Equal(FUNKTION.get(),6)) {
      m$.Cmd.Do("MANU");
    }
    //<< if FUNKTION=7 do SEL^WWWEVENT1(3)              ;MANUELLES SELECTFELD IN WWWDATEN ZUFÜGEN ;within give rise to
    if (mOp.Equal(FUNKTION.get(),7)) {
      m$.Cmd.Do("WWWEVENT1.SEL",3);
    }
    //<< if FUNKTION=8 do ^WWWEVENT3                    ;SAVE + REFRESH data fields < >      TODO JW - look into
    if (mOp.Equal(FUNKTION.get(),8)) {
      m$.Cmd.Do("WWWEVENT3.main");
    }
    //<< if FUNKTION=9 do ^WWWEVENT2                    ;SCHNELLSICHERUNG FASTSAVE           TODO JW - look into
    if (mOp.Equal(FUNKTION.get(),9)) {
      m$.Cmd.Do("WWWEVENT2.main");
    }
    //<< if FUNKTION=0 do VARIABLE                      ;VARIABLEN SICHERN ;safeguard
    if (mOp.Equal(FUNKTION.get(),0)) {
      m$.Cmd.Do("VARIABLE");
    }
    //<< 
    //<< if $get(YXTEXT)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(YXTEXT),"")) {
      //<< if $extract(%TXT(1))=$$$Perform {
      if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$Perform(m$))) {
        //<< set %TXT(1) = %TXT(1)_$$$Perform
        m$.var("%TXT",1).set(mOp.Concat(m$.var("%TXT",1).get(),include.COMSYS.$$$Perform(m$)));
      }
      //<< } elseif ($extract(%TXT(1))'="!") && ($extract(%TXT(1))'="§") && ($extract(%TXT(1))'="þ") {
      else if ((mOp.NotEqual(m$.Fnc.$extract(m$.var("%TXT",1).get()),"!")) && (mOp.NotEqual(m$.Fnc.$extract(m$.var("%TXT",1).get()),"§")) && (mOp.NotEqual(m$.Fnc.$extract(m$.var("%TXT",1).get()),"þ"))) {
        //<< set %TXT(1) = ""
        m$.var("%TXT",1).set("");
      }
      //<< }
      //<< set %TXT(1) = %TXT(1)_"!"_YXTEXT
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"!"),YXTEXT.get()));
    }
    //<< }
    //<< 
    //<< if $translate($$$UPPER(%TXT(1)),"ABCDEFGHIJKLMNOPQRSTUVWXYZÖÄÜß 0123456789*#&-.,+/_()|'"_$$$CRLF)'="" if %TXT(1)=$get(%REQUEST(1)) set %TXT(1) = ""
    if (mOp.NotEqual(m$.Fnc.$translate(include.COMSYSString.$$$UPPER(m$,m$.var("%TXT",1)),mOp.Concat("ABCDEFGHIJKLMNOPQRSTUVWXYZÖÄÜß 0123456789*#&-.,+/_()|'",include.COMSYSString.$$$CRLF(m$))),"")) {
      if (mOp.Equal(m$.var("%TXT",1).get(),m$.Fnc.$get(m$.var("%REQUEST",1)))) {
        m$.var("%TXT",1).set("");
      }
    }
    //<< if $find(%TXT(1),"&#") set %TXT(1) = $piece(%TXT(1),"&#",1)  ;KEINE SONDERZEICHEN VIA EVENT ;no special character via
    if (mOp.Logical(m$.Fnc.$find(m$.var("%TXT",1).get(),"&#"))) {
      m$.var("%TXT",1).set(m$.Fnc.$piece(m$.var("%TXT",1).get(),"&#",1));
    }
    //<< 
    //<< if FUNKTION=2 {
    if (mOp.Equal(FUNKTION.get(),2)) {
      //<< set %TXT(1) = $translate(%TXT(1),"'"_$$$CRLF,"`'")
      m$.var("%TXT",1).set(m$.Fnc.$translate(m$.var("%TXT",1).get(),mOp.Concat("'",include.COMSYSString.$$$CRLF(m$)),"`'"));
    }
    //<< } elseif (FUNKTION'=4) && (FUNKTION'=5) && (FUNKTION'=7) {
    else if ((mOp.NotEqual(FUNKTION.get(),4)) && (mOp.NotEqual(FUNKTION.get(),5)) && (mOp.NotEqual(FUNKTION.get(),7))) {
      //<< set %TXT(1) = $translate(%TXT(1),"'|"_$$$CRLF,"`''")
      m$.var("%TXT",1).set(m$.Fnc.$translate(m$.var("%TXT",1).get(),mOp.Concat("'|",include.COMSYSString.$$$CRLF(m$)),"`''"));
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< SplitRequest(parrRequest,&pstrInput,&pstrNS,&pidUser,&pidForm,&pstrField,&pintFn,&pstrKey,&pstrVar)
  public Object SplitRequest(Object ... _p) {
    mVar parrRequest = m$.newVarRef("parrRequest",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrInput = m$.newVarRef("pstrInput",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrNS = m$.newVarRef("pstrNS",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pintFn = m$.newVarRef("pintFn",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar pstrVar = m$.newVarRef("pstrVar",(((_p!=null)&&(_p.length>=9))?_p[8]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Split the request into its components
    //<< ;
    //<< ; %REQUEST      = "NAMESPACE.USER.FORM.FELDNUMMER.FUNKTION.FIXKEY.VARIABLE"  ;SR18075
    //<< ; %REQUEST      = "NAMESPACE.USER.FORM.FELDNUMMER.FUNKTION.FIXKEY.SPRACHE.VARIABLE"  ;SR18075
    //<< ; %REQUEST(1)   = "VALUE"
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 31-Jul-2012   shobby  SR18075: New field for SPRACHE now uses piece 7
    //<< ; 03-Apr-2007   JW      SR15384: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strRequest
    mVar strRequest = m$.var("strRequest");
    m$.newVar(strRequest);
    //<< 
    //<< set strRequest = $get(parrRequest)
    strRequest.set(m$.Fnc.$get(parrRequest));
    //<< 
    //<< set pstrNS      = $piece(strRequest,".",1)
    pstrNS.set(m$.Fnc.$piece(strRequest.get(),".",1));
    //<< set pidUser     = $piece(strRequest,".",2)
    pidUser.set(m$.Fnc.$piece(strRequest.get(),".",2));
    //<< set pidForm     = $piece(strRequest,".",3)
    pidForm.set(m$.Fnc.$piece(strRequest.get(),".",3));
    //<< set pstrField   = $piece(strRequest,".",4)      ; "Y"_YFORM_YART_YLFN
    pstrField.set(m$.Fnc.$piece(strRequest.get(),".",4));
    //<< set pintFn      = $piece(strRequest,".",5)
    pintFn.set(m$.Fnc.$piece(strRequest.get(),".",5));
    //<< set pstrKey     = $translate($extract($piece(strRequest,".",6),4,99),"~",".")
    pstrKey.set(m$.Fnc.$translate(m$.Fnc.$extract(m$.Fnc.$piece(strRequest.get(),".",6),4,99),"~","."));
    //<< ;SR18075 set pstrVar    = $piece(strRequest,".",7,99)
    //<< set pstrVar     = $piece(strRequest,".",8,99)   ;SR18075
    pstrVar.set(m$.Fnc.$piece(strRequest.get(),".",8,99));
    //<< 
    //<< set pstrInput = parrRequest(1)
    pstrInput.set(parrRequest.var(1).get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Initialise(YUSER,&%REQUEST)
  public Object Initialise(Object ... _p) {
    mVar YUSER = m$.newVarRef("YUSER",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$REQUEST = m$.newVarRef("p$REQUEST",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Initalise @net variables
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 31-Jul-2012   shobby  SR18075: New field for SPRACHE now uses piece 7
    //<< ; 24-May-2007   GRF     SR15525: Use common code
    //<< ; 02-Apr-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new objUser
    mVar objUser = m$.var("objUser");
    m$.newVar(objUser);
    //<< 
    //<< set YBED=""
    mVar YBED = m$.var("YBED");
    YBED.set("");
    //<< 
    //<< if YUSER'="" {
    if (mOp.NotEqual(YUSER.get(),"")) {
      //<< set objUser = $get(^WWWUSER(0,YUSER,1))
      objUser.set(m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1)));
      //<< if objUser="" {
      if (mOp.Equal(objUser.get(),"")) {
        //<< set ^WWWUSER(0,YUSER,1)=1    ;Prevent recursion when closing                        ;SR18075
        m$.var("^WWWUSER",0,YUSER.get(),1).set(1);
        //<< if $piece(%REQUEST,".",7)'="" set SPRACHE=$piece(%REQUEST,".",7)                    ;SR18075
        if (mOp.NotEqual(m$.Fnc.$piece(p$REQUEST.get(),".",7),"")) {
          mVar SPRACHE = m$.var("SPRACHE");
          SPRACHE.set(m$.Fnc.$piece(p$REQUEST.get(),".",7));
        }
        //<< set %TXT(1) = $$$AlertFollowing_$$^WWWTEXT(34359)  ; "Session Expired!"             ;CORE-106
        m$.var("%TXT",1).set(mOp.Concat(include.COMSYS.$$$AlertFollowing(m$),m$.fnc$("WWWTEXT.main",34359)));
        //<< $$$StartScript()                                    ;SR18075
        include.COMSYS.$$$StartScript(m$);
        //<< write "window.parent.location = '"_$$getLoginPage^WWWLogin(1)_"'; " ;SR18075
        m$.Cmd.Write(mOp.Concat(mOp.Concat("window.parent.location = '",m$.fnc$("WWWLogin.getLoginPage",1)),"'; "));
        //<< $$$EndScript()                                      ;SR18075
        include.COMSYS.$$$EndScript(m$);
      }
      //<< } else {
      else {
        //<< set YBED    = $piece(objUser,Y,2)
        YBED.set(m$.Fnc.$piece(objUser.get(),m$.var("Y").get(),2));
        //<< set YM      = $piece(objUser,Y,20)     ; FIXME : Deprecated - always set to 0
        mVar YM = m$.var("YM");
        YM.set(m$.Fnc.$piece(objUser.get(),m$.var("Y").get(),20));
        //<< set SPRACHE = $piece(objUser,Y,19)
        mVar SPRACHE = m$.var("SPRACHE");
        SPRACHE.set(m$.Fnc.$piece(objUser.get(),m$.var("Y").get(),19));
        //<< set YSEITE  = $$$WWWUSERLastFormpage(objUser)
        mVar YSEITE = m$.var("YSEITE");
        YSEITE.set(include.WWWConst.$$$WWWUSERLastFormpage(m$,objUser));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; Note that at this point, YSEITE may not be current...
    //<< 
    //<< ;---------------USER VORGABEN------------------------------------------
    //<< if YBED'="" {
    if (mOp.NotEqual(YBED.get(),"")) {
      //<< set:YM="" YM = $$$WWW013HomeCompany($get(^WWW013(0,YBED,1)))     ; FIXME : Deprecated
      if (mOp.Equal(m$.var("YM").get(),"")) {
        m$.var("YM").set(include.WWWConst.$$$WWW013HomeCompany(m$,m$.Fnc.$get(m$.var("^WWW013",0,YBED.get(),1))));
      }
      //<< set:YM="" YM = 0
      if (mOp.Equal(m$.var("YM").get(),"")) {
        m$.var("YM").set(0);
      }
      //<< set YLOCATION=$piece($get(^WWW013(0,YBED,1)),Y,44)
      mVar YLOCATION = m$.var("YLOCATION");
      YLOCATION.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",0,YBED.get(),1)),m$.var("Y").get(),44));
      //<< set:SPRACHE="" SPRACHE=$$^WWWLANGU(YBED)
      if (mOp.Equal(m$.var("SPRACHE").get(),"")) {
        m$.var("SPRACHE").set(m$.fnc$("WWWLANGU.main",YBED.get()));
      }
      //<< set YVOR1    = $get(^WWW012(0,0,1))
      mVar YVOR1 = m$.var("YVOR1");
      YVOR1.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
      //<< set YWHR     = $$$WWW012StandardCurrency(YVOR1)         ;STANDARD WÄHRUNGSKZ
      mVar YWHR = m$.var("YWHR");
      YWHR.set(include.WWWConst.$$$WWW012StandardCurrency(m$,YVOR1));
      //<< set YMANDANT = $$$WWW012UniqueCompanyIdentifier(YVOR1)  ;VORGABE FÜR MANDANTENKENNUNG ;default to
      mVar YMANDANT = m$.var("YMANDANT");
      YMANDANT.set(include.WWWConst.$$$WWW012UniqueCompanyIdentifier(m$,YVOR1));
      //<< 
      //<< ; SR15525 vvv
      //<< set YDECIMAL = $extract($$GetNumberDelimiters^COMUtilLocale(SPRACHE),2)
      mVar YDECIMAL = m$.var("YDECIMAL");
      YDECIMAL.set(m$.Fnc.$extract(m$.fnc$("COMUtilLocale.GetNumberDelimiters",m$.var("SPRACHE").get()),2));
    }
    //<< ;set YDECIMAL = $$$WWW012DecimalSigns(YVOR1)
    //<< ;if YDECIMAL="" {
    //<< ;   SET YDECIMAL=","
    //<< ;   if SPRACHE="EN" SET YDECIMAL="."        ; TODO - this is inappropriate!
    //<< ;}
    //<< }
    //<< 
    //<< set:YM="" YM=0     ; FIXME : Deprecated - always set to 0
    if (mOp.Equal(m$.var("YM").get(),"")) {
      m$.var("YM").set(0);
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< FIELDWRAPPER
  public void FIELDWRAPPER() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for FIELD. Keep variables so can call CheckStatus.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Mar-2007   JW      SR15384: Append value to Confirm function.
    //<< ; 02-Dec-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YART,YFORM,YINHALT,YLFN,YUSER
    mVar YART = m$.var("YART");
    mVar YFORM = m$.var("YFORM");
    mVar YINHALT = m$.var("YINHALT");
    mVar YLFN = m$.var("YLFN");
    mVar YUSER = m$.var("YUSER");
    m$.newVar(YART,YFORM,YINHALT,YLFN,YUSER);
    //<< 
    //<< do FIELD(.YINHALT)
    m$.Cmd.Do("FIELD",YINHALT);
    //<< 
    //<< if $extract(%TXT(1))=$$$Confirm {
    if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$Confirm(m$))) {
      //<< $$$Append(%TXT(1),Y_YINHALT)    ; Store value
      include.COMSYSString.$$$Append(m$,m$.var("%TXT",1),mOp.Concat(m$.var("Y").get(),YINHALT.get()));
    }
    //<< }
    //<< do CheckStatus^WWWFORMStatus()
    m$.Cmd.Do("WWWFORMStatus.CheckStatus");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< DATEN
  public Object DATEN() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Evaluate additional data to send
    //<< ;
    //<< ; HISTORY:
    //<< ; 03-May-2010   GRF     SR15961: use dteToday for efficiency
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 27-Mar-2007   JW      SR15384: Encapsulated functions. Cleaned up.
    //<< ; 16-Jun-2006   JW      SR12775: Rewritten - simplified / brace syntax
    //<< ; 28-Jul-2005   JW      SR12615: Change colour of cell to red if has relation and doesn't exist.
    //<< ;-------------------------------------------------------------------------------
    //<< quit:$extract(%TXT(1))'=$$$Perform
    if (mOp.NotEqual(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$Perform(m$))) {
      return null;
    }
    //<< 
    //<< $$$LogR4("DATEN","")
    $$$LogR4(m$,"DATEN","");
    //<< 
    //<< new dteToday,strAction,strDelim,strField,strStored,YART,YI,YINHALT,YLFN,YOLDV,YTYP
    mVar dteToday = m$.var("dteToday");
    mVar strAction = m$.var("strAction");
    mVar strDelim = m$.var("strDelim");
    mVar strField = m$.var("strField");
    mVar strStored = m$.var("strStored");
    mVar YART = m$.var("YART");
    mVar YI = m$.var("YI");
    mVar YINHALT = m$.var("YINHALT");
    mVar YLFN = m$.var("YLFN");
    mVar YOLDV = m$.var("YOLDV");
    mVar YTYP = m$.var("YTYP");
    m$.newVar(dteToday,strAction,strDelim,strField,strStored,YART,YI,YINHALT,YLFN,YOLDV,YTYP);
    //<< 
    //<< set dteToday = +$horolog     ; SR15961
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< for YI=2:1 {
    for (YI.set(2);(true);YI.set(mOp.Add(YI.get(),1))) {
      //<< set strAction = $piece(%TXT(1),$$$Perform,YI)
      strAction.set(m$.Fnc.$piece(m$.var("%TXT",1).get(),include.COMSYS.$$$Perform(m$),YI.get()));
      //<< quit:strAction=""
      if (mOp.Equal(strAction.get(),"")) {
        break;
      }
      //<< 
      //<< continue:$piece(strAction,"~",4)'=""  ;MULTISELECT NACHLADEN  ;FIS;23.07.04
      if (mOp.NotEqual(m$.Fnc.$piece(strAction.get(),"~",4),"")) {
        continue;
      }
      //<< 
      //<< set strField = $piece(strAction,"~",1)    ; field
      strField.set(m$.Fnc.$piece(strAction.get(),"~",1));
      //<< set YINHALT  = $piece(strAction,"~",2)    ; value
      YINHALT.set(m$.Fnc.$piece(strAction.get(),"~",2));
      //<< 
      //<< continue:YINHALT="BACKGROUND"
      if (mOp.Equal(YINHALT.get(),"BACKGROUND")) {
        continue;
      }
      //<< continue:strField="FUNCTION"
      if (mOp.Equal(strField.get(),"FUNCTION")) {
        continue;
      }
      //<< continue:YINHALT="WRITE"
      if (mOp.Equal(YINHALT.get(),"WRITE")) {
        continue;
      }
      //<< continue:YINHALT="READ"
      if (mOp.Equal(YINHALT.get(),"READ")) {
        continue;
      }
      //<< continue:(YINHALT="CHECKED")&&($find(strAction,"("))&&($extract($reverse(strField))=")")   ;FIS;13.07.04;26092;RADIOBUTTON IMMER CHECKED
      if ((mOp.Equal(YINHALT.get(),"CHECKED")) && mOp.Logical((m$.Fnc.$find(strAction.get(),"("))) && (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(strField.get())),")"))) {
        continue;
      }
      //<< 
      //<< do SplitID^WWWField(strField,YFORM,.YART,.YLFN)
      m$.Cmd.Do("WWWField.SplitID",strField.get(),m$.var("YFORM").get(),YART,YLFN);
      //<< continue:(YART'="M")&&(YDATEI="")
      if ((mOp.NotEqual(YART.get(),"M")) && (mOp.Equal(m$.var("YDATEI").get(),""))) {
        continue;
      }
      //<< continue:YLFN=""                    ; No number
      if (mOp.Equal(YLFN.get(),"")) {
        continue;
      }
      //<< 
      //<< set strDelim = $select(YART="P":",", 1:Y)
      strDelim.set(m$.Fnc.$select(mOp.Equal(YART.get(),"P"),",",1,m$.var("Y").get()));
      //<< 
      //<< do GetDetails^WWWField(YFORM,YART,YLFN,,,,,,,.YTYP)
      m$.Cmd.Do("WWWField.GetDetails",m$.var("YFORM").get(),YART.get(),YLFN.get(),null,null,null,null,null,null,YTYP);
      //<< 
      //<< if (YINHALT=" ") || (YINHALT="UNCHECKED") || (YINHALT="REMOVE") {
      if ((mOp.Equal(YINHALT.get()," ")) || (mOp.Equal(YINHALT.get(),"UNCHECKED")) || (mOp.Equal(YINHALT.get(),"REMOVE"))) {
        //<< set YINHALT=""
        YINHALT.set("");
      }
      //<< } elseIF (YINHALT="CHECKED") {
      else if ((mOp.Equal(YINHALT.get(),"CHECKED"))) {
        //<< set YINHALT=$$$YES
        YINHALT.set(include.COMSYS.$$$YES(m$));
      }
      //<< }
      //<< 
      //<< set strStored = $$GetInternal^WWWTR(YTYP,YINHALT)
      strStored.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YINHALT.get()));
      //<< if YTYP'=$$$FLDCurrency {
      if (mOp.NotEqual(YTYP.get(),include.COMSYSWWW.$$$FLDCurrency(m$))) {
        //<< set $piece(^WWWDATEN(0,dteToday,YUSER,YFORM,YART,1),strDelim,YLFN)=strStored
        m$.pieceVar(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),YART.get(),1),strDelim.get(),YLFN.get()).set(strStored.get());
        //<< 
        //<< ; SR12615: Change colour of cell if has relation and doesn't exist.
        //<< do ValidRelation^WWWFieldValidation(YART,YDATEI,YFORM,YLFN,strStored)
        m$.Cmd.Do("WWWFieldValidation.ValidRelation",YART.get(),m$.var("YDATEI").get(),m$.var("YFORM").get(),YLFN.get(),strStored.get());
      }
      //<< 
      //<< } else {    ; Foreign Currency
      else {
        //<< set YOLDV=$piece($get(^WWWDATEN(0,dteToday,YUSER,YFORM,YART,1)),strDelim,YLFN)
        YOLDV.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),YART.get(),1)),strDelim.get(),YLFN.get()));
        //<< if '$find(YOLDV,"@") || ($$GetLiteral^WWWTR(YTYP,YOLDV)=YINHALT) {  ;Maintain format
        if (mOp.Not(m$.Fnc.$find(YOLDV.get(),"@")) || (mOp.Equal(m$.fnc$("WWWTR.GetLiteral",YTYP.get(),YOLDV.get()),YINHALT.get()))) {
          //<< set $piece(^WWWDATEN(0,dteToday,YUSER,YFORM,YART,1),strDelim,YLFN)=strStored
          m$.pieceVar(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),YART.get(),1),strDelim.get(),YLFN.get()).set(strStored.get());
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
  //<< PRIMCHK(YKEY,pobjForm,pobjClsKey,pobjCustKey)
  public Object PRIMCHK(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjForm = m$.newVarRef("pobjForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjClsKey = m$.newVarRef("pobjClsKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pobjCustKey = m$.newVarRef("pobjCustKey",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; CHECK PRIMARY KEY
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns: boolean - whether to open key
    //<< ;
    //<< ; History:
    //<< ; 18-Jul-2011   GRF     SR17751: Change strStatus processing to assume
    //<< ;                           $$OnFilter^WWWSOR returns standard error string.
    //<< ; 03-May-2010   GRF     SR15961: use dteToday for efficiency
    //<< ; 07-Feb-2008   shobby  SRBR014892: Reversed previous change.  We can't go mixing
    //<< ;                           $lb with Y.  Improved text handling when message
    //<< ;                           contains a '
    //<< ; 06-Feb-2008   shobby  SRBR014892: use the standard error translation for OnFilter
    //<< ;                           so $$$MakeStatus can be used to build it.
    //<< ; 02-Oct-2007   shobby  SRBR014726: Checks whether a data record should not be
    //<< ;                           displayed as a result of a call back.
    //<< ;                           The OnFilter callback routine can determine whether
    //<< ;                           to display a message, clear the field or optionally
    //<< ;                           display the record in readonly mode.
    //<< ; 27-Mar-2007   PO      SR15442: Return boolean
    //<< ; 01-Feb-2007   JW      SR15384: Cleaned up
    //<< ;-------------------------------------------------------------------------------
    //<< new blnForceNum,blnOpen,dteToday,loop,strResult,strStatus,YFELD,YMAXKEY
    mVar blnForceNum = m$.var("blnForceNum");
    mVar blnOpen = m$.var("blnOpen");
    mVar dteToday = m$.var("dteToday");
    mVar loop = m$.var("loop");
    mVar strResult = m$.var("strResult");
    mVar strStatus = m$.var("strStatus");
    mVar YFELD = m$.var("YFELD");
    mVar YMAXKEY = m$.var("YMAXKEY");
    m$.newVar(blnForceNum,blnOpen,dteToday,loop,strResult,strStatus,YFELD,YMAXKEY);
    //<< 
    //<< set dteToday = +$horolog     ; SR15961
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< set ^WWWDATEN(0,dteToday,YUSER,"RECORDEXISTS",YFORM,1) = 0   ;TYBD;4,2,2004;SAVE UND ÖFFNEN
    m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),"RECORDEXISTS",m$.var("YFORM").get(),1).set(0);
    //<< set ^WWWDATEN(0,dteToday,YUSER,"RECORDEXISTS",YFORM,2) = ""
    m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),"RECORDEXISTS",m$.var("YFORM").get(),2).set("");
    //<< 
    //<< quit:YDATEI="" $$$NO            ; *** EARLY EXIT - No class
    if (mOp.Equal(m$.var("YDATEI").get(),"")) {
      return include.COMSYS.$$$NO(m$);
    }
    //<< 
    //<< set YMAXKEY = +$order(^WWW002(0,YDATEI,""),-1)
    YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),""),mOp.Negative(1))));
    //<< quit:YMAXKEY=0 $$$NO            ; *** EARLY EXIT - No Keys
    if (mOp.Equal(YMAXKEY.get(),0)) {
      return include.COMSYS.$$$NO(m$);
    }
    //<< 
    //<< set YMAXKEY = YMAXKEY+$get(YTIMEFORM)  ;TYBD;3,11,2003;VORABZEITERFASSUNG;24525
    YMAXKEY.set(mOp.Add(YMAXKEY.get(),m$.Fnc.$get(m$.var("YTIMEFORM"))));
    //<< 
    //<< set $piece(YFKEY,",",YLFN1) = YKEY   ;$P(YKEY,",",YLFN1)  ;EINSETZEN KEY IN FIXKEY YLFN1 comes from tag FIELD
    m$.pieceVar(m$.var("YFKEY"),",",m$.var("YLFN1").get()).set(YKEY.get());
    //<< 
    //<< set YKEY = YFKEY
    YKEY.set(m$.var("YFKEY").get());
    //<< if YMAXKEY'=1 set YKEY = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"P",1))  ;kompl. YKEY
    if (mOp.NotEqual(YMAXKEY.get(),1)) {
      YKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1)));
    }
    //<< 
    //<< set blnOpen = $$$YES  ;DATENSATZ VORHANDEN ;data record on hand
    blnOpen.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< ;---------------GRID------------------------------------------
    //<< if (YKEY'="") && (YLFN'=YMAXKEY) && ($$$WWW120FormType(pobjForm)=3) {
    if ((mOp.NotEqual(YKEY.get(),"")) && (mOp.NotEqual(m$.var("YLFN").get(),YMAXKEY.get())) && (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,pobjForm),3))) {
      //<< set ^WWWDATEN(0,dteToday,YUSER,"RECORDEXISTS",YFORM,1) = $$$YES
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),"RECORDEXISTS",m$.var("YFORM").get(),1).set(include.COMSYS.$$$YES(m$));
      //<< set ^WWWDATEN(0,dteToday,YUSER,"RECORDEXISTS",YFORM,2) = $piece($horolog,",",2)
      m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),"RECORDEXISTS",m$.var("YFORM").get(),2).set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
    }
    //<< 
    //<< } else {
    else {
      //<< for loop=1:1:YMAXKEY {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),YMAXKEY.get()));loop.set(mOp.Add(loop.get(),1))) {
        //<< if $piece(YKEY,",",loop)="" {
        if (mOp.Equal(m$.Fnc.$piece(YKEY.get(),",",loop.get()),"")) {
          //<< set blnOpen = $$$NO
          blnOpen.set(include.COMSYS.$$$NO(m$));
          //<< quit
          break;
        }
      }
      //<< }
      //<< }
      //<< if blnOpen {
      if (mOp.Logical(blnOpen.get())) {
        //<< if YDATEI="WWW001" if '$data(^WWW001(0,YKEY,1)) if $data(^oddDEF("User."_YKEY)) kill VORG do ^WWWCDL(YKEY,0,0)  ;KLASSE ÜBERTRAGEN
        if (mOp.Equal(m$.var("YDATEI").get(),"WWW001")) {
          if (mOp.Not(m$.Fnc.$data(m$.var("^WWW001",0,YKEY.get(),1)))) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^oddDEF",mOp.Concat("User.",YKEY.get()))))) {
              m$.var("VORG").kill();
              m$.Cmd.Do("WWWCDL.main",YKEY.get(),0,0);
            }
          }
        }
        //<< 
        //<< do ^WWWLESE(YDATEI,YKEY,1)   ;LESEN DATENSATZ  ;TYBD ;read data record
        m$.Cmd.Do("WWWLESE.main",m$.var("YDATEI").get(),YKEY.get(),1);
        //<< 
        //<< if $get(YFELD)="" set blnOpen = $$$NO  ;NICHT VORHANDEN ;Not on hand
        if (mOp.Equal(m$.Fnc.$get(YFELD),"")) {
          blnOpen.set(include.COMSYS.$$$NO(m$));
        }
        //<< 
        //<< set strStatus = $$$OK
        strStatus.set(include.COMSYS.$$$OK(m$));
        //<< if '$$$NoKey(YKEY) set strStatus = $$OnFilter^WWWSOR(.YINHALT,YFELD)
        if (mOp.Not(include.COMSYS.$$$NoKey(m$,YKEY))) {
          strStatus.set(m$.fnc$("WWWSOR.OnFilter",m$.var("YINHALT"),YFELD.get()));
        }
        //<< 
        //<< ; SR17751 vvv
        //<< ;   if $piece(strStatus,Y,3)=1 set strStatus = $$$OK
        //<< ;   if $$$ISERR(strStatus) {
        //<< ;       set blnOpen   = $$$NO
        //<< ;       set strStatus = $piece($extract(strStatus,3,999999999),Y,1)
        //<< ;       if strStatus'="" write "alert("""_strStatus_""");"
        //<< ;   }
        //<< if $$$ISERR(strStatus) {
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
          //<< set blnOpen   = $$$NO
          blnOpen.set(include.COMSYS.$$$NO(m$));
          //<< set strStatus = $$$Text(strStatus)
          strStatus.set(include.COMSYS.$$$Text(m$,strStatus));
          //<< if strStatus'="" write "alert("""_strStatus_""");"
          if (mOp.NotEqual(strStatus.get(),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat("alert(\"",strStatus.get()),"\");"));
          }
        }
        //<< }
        //<< ; SR17751 ^^^
        //<< set ^WWWDATEN(0,dteToday,YUSER,"RECORDEXISTS",YFORM,1) = blnOpen
        m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),"RECORDEXISTS",m$.var("YFORM").get(),1).set(blnOpen.get());
        //<< set ^WWWDATEN(0,dteToday,YUSER,"RECORDEXISTS",YFORM,2) = $piece($horolog,",",2)
        m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),"RECORDEXISTS",m$.var("YFORM").get(),2).set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
      }
    }
    //<< }
    //<< }
    //<< quit blnOpen
    return blnOpen.get();
  }

  //<< 
  //<< 
  //<< FIELD(&YINHALT)
  public Object FIELD(Object ... _p) {
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;       DATENFELD PRÜFEN ;check data item
    //<< ;
    //<< ; NOTE : Does not appear to be called for COMGridEdit processing
    //<< ;
    //<< ;
    //<< ; ByRef : (do not new) YFORM,YOLDTXT,YSATZ,YUCI,YUSER,%REQUEST
    //<< ;
    //<< ; Returns: YINHALT (ByRef)
    //<< ;
    //<< ; History:
    //<< ;
    //<< ; 31-Jul-2012   shobby  SR18075: Use new field for SPRACHE in initialise
    //<< ; 21-Jun-2012   shobby  SR18026: Translate type 7 for storage and update grid
    //<< ; 25-May-2011   GRF     SR17250: call common function for decimal places
    //<< ; 03-Feb-2011   GRF     SR17579: only adjust dp if assoc. field contains Unit
    //<< ; 06-Jan-2011   GRF     SR17579: use WWW122s Macro
    //<< ; 04-May-2010   GRF     SR15961.1: call SetLock
    //<< ; 30-Apr-2010   GRF     -: use intAutoIdx in string construction
    //<< ; 06-May-2009   PPP     SR16521:Barcode Scanning to identify Item
    //<< ; 10-Feb-2009   shobby  SR16126:Made previous change optional based on a company parameter.
    //<< ; 12-Nov-2008   shobby  SR16126:Simulate commas in a primary key.
    //<< ; 18-Sep-2007   shobby  SRBR014619: Calls to PARAMETER don't need objCustFld any more.
    //<< ; 04-Jun-2007   shobby  SRBR014409: Removed early quits that were preventing
    //<< ;                           rules updating the screen.
    //<< ; 10-Apr-2007   PO      SR15442: Added parameter to GetDetails^WWWField
    //<< ; 09-Apr-2007   shobby  SRBR014409:Changes to support dynamic updating of fields
    //<< ;                           based on custom rules (WWW122D)
    //<< ; 27-Mar-2007   PO      SR15442: Force numerator for primary key
    //<< ; 27-Mar-2007   JW      SR15384: Encapsulated functions. Cleaned up. Fixed %TXT overriding
    //<< ; 16-Mar-2007   GRF     SR12505: Validate on "Don't Allow Chars"; naked references
    //<< ; 15-Jan-2007   JW      SR15380: Update display even if we have on blur code.
    //<< ; 12-Oct-2006   Steve S BR014112: If a field is set to zero dec. places floating,
    //<< ;                           force to integer.
    //<< ; 11-Sep-2006   JW      SR14885: Remove commas from primary keys
    //<< ; 21-Aug-2006   FrankF  BR014066: Setting the YSEITE global variable.
    //<< ; 21-Aug-2006   JW      SR14919: Spaces -> 0 for numeric type
    //<< ; 15-Dec-2005   PO      SR13792: When blurring out of a text field without cache
    //<< ;                           onblur, use EscapeHyperEventData
    //<< ; 09-Dec-2005   JW      SR13195: Primary key redirection removed from here.
    //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
    //<< ; 27-Oct-2005   Steve S SR13745: Display the WWWTR values on the form, NOT the raw values.
    //<< ; 22-Sep-2005   JW      SR13500: Set YKEY
    //<< ; 02-Sep-2005   JW      SR12966: WWW002 is shared. WWWCODE is not shared.
    //<< ; 17-Jun-2005   PO      SR12626 Changed condition under which AdjustCurrencyAmount is called
    //<< ;-------------------------------------------------------------------------------
    //<< new blnIsItem,blnIsUnit,blnTest,idAssocClassFld,idChangeInput,idClassFldNo,idFormFldNo
    mVar blnIsItem = m$.var("blnIsItem");
    mVar blnIsUnit = m$.var("blnIsUnit");
    mVar blnTest = m$.var("blnTest");
    mVar idAssocClassFld = m$.var("idAssocClassFld");
    mVar idChangeInput = m$.var("idChangeInput");
    mVar idClassFldNo = m$.var("idClassFldNo");
    mVar idFormFldNo = m$.var("idFormFldNo");
    m$.newVar(blnIsItem,blnIsUnit,blnTest,idAssocClassFld,idChangeInput,idClassFldNo,idFormFldNo);
    //<< new idItem,idRelation,idUnit,intAutoIdx,intDP,objClsCustFld,objCustFld,objFormFld
    mVar idItem = m$.var("idItem");
    mVar idRelation = m$.var("idRelation");
    mVar idUnit = m$.var("idUnit");
    mVar intAutoIdx = m$.var("intAutoIdx");
    mVar intDP = m$.var("intDP");
    mVar objClsCustFld = m$.var("objClsCustFld");
    mVar objCustFld = m$.var("objCustFld");
    mVar objFormFld = m$.var("objFormFld");
    m$.newVar(idItem,idRelation,idUnit,intAutoIdx,intDP,objClsCustFld,objCustFld,objFormFld);
    //<< new strCode,strExecOnBlur,strField,strGlobal,strOrigInput,strPattern,strReason,strStored
    mVar strCode = m$.var("strCode");
    mVar strExecOnBlur = m$.var("strExecOnBlur");
    mVar strField = m$.var("strField");
    mVar strGlobal = m$.var("strGlobal");
    mVar strOrigInput = m$.var("strOrigInput");
    mVar strPattern = m$.var("strPattern");
    mVar strReason = m$.var("strReason");
    mVar strStored = m$.var("strStored");
    m$.newVar(strCode,strExecOnBlur,strField,strGlobal,strOrigInput,strPattern,strReason,strStored);
    //<< new YBED,YDATA,YDATEI,YFELD,YFKEY,YKEY,YOLDTXT,YPR,YPR1,YSATZ,YVAR
    mVar YBED = m$.var("YBED");
    mVar YDATA = m$.var("YDATA");
    mVar YDATEI = m$.var("YDATEI");
    mVar YFELD = m$.var("YFELD");
    mVar YFKEY = m$.var("YFKEY");
    mVar YKEY = m$.var("YKEY");
    mVar YOLDTXT = m$.var("YOLDTXT");
    mVar YPR = m$.var("YPR");
    mVar YPR1 = m$.var("YPR1");
    mVar YSATZ = m$.var("YSATZ");
    mVar YVAR = m$.var("YVAR");
    m$.newVar(YBED,YDATA,YDATEI,YFELD,YFKEY,YKEY,YOLDTXT,YPR,YPR1,YSATZ,YVAR);
    //<< 
    //<< set YKEY    = ""
    YKEY.set("");
    //<< set YSATZ   = ""   ; Used by FIELDWRAPPER
    YSATZ.set("");
    //<< set YOLDTXT = ""   ; Used by FIELDWRAPPER
    YOLDTXT.set("");
    //<< 
    //<< do SplitRequest(.%REQUEST,.YINHALT,.YUCI,.YUSER,.YFORM,.strField,,.YFKEY,.YVAR) ; Used by FIELDWRAPPER
    m$.Cmd.Do("SplitRequest",m$.var("%REQUEST"),YINHALT,m$.var("YUCI"),m$.var("YUSER"),m$.var("YFORM"),strField,null,YFKEY,YVAR);
    //<< do Initialise(YUSER,.%REQUEST)    ;SR18075 ; sets YBED, SPRACHE et al
    m$.Cmd.Do("Initialise",m$.var("YUSER").get(),m$.var("%REQUEST"));
    //<< 
    //<< $$$LogR4("FIELD",strField)
    $$$LogR4(m$,"FIELD",strField);
    //<< 
    //<< quit:$extract(%TXT(1))=$$$AlertFollowing            ; *** EARLY QUIT - bad user
    if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$AlertFollowing(m$))) {
      return null;
    }
    //<< quit:YFORM=""                                       ; *** EARLY QUIT - NO FORM
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      return null;
    }
    //<< 
    //<< do SplitID^WWWField(strField,YFORM,.YART,.YLFN)     ; e.g. INARTD30 = INART,D,30
    m$.Cmd.Do("WWWField.SplitID",strField.get(),m$.var("YFORM").get(),m$.var("YART"),m$.var("YLFN"));
    //<< quit:YLFN=""                                        ; *** EARLY QUIT - No Field number
    if (mOp.Equal(m$.var("YLFN").get(),"")) {
      return null;
    }
    //<< 
    //<< ; L ?    Field types are normally P, D or M.    Does this ever happen?
    //<< if $extract(YART)="L" {
    if (mOp.Equal(m$.Fnc.$extract(m$.var("YART").get()),"L")) {
      //<< set YART = $extract(YART,2)
      mVar YART = m$.var("YART");
      YART.set(m$.Fnc.$extract(m$.var("YART").get(),2));
      //<< if $length(YLFN)>3  set YLFN =  $extract(YLFN,2,9)  ;2.TAG (BIS)
      if (mOp.Greater(m$.Fnc.$length(m$.var("YLFN").get()),3)) {
        mVar YLFN = m$.var("YLFN");
        YLFN.set(m$.Fnc.$extract(m$.var("YLFN").get(),2,9));
      }
      //<< if $extract(YLFN)=1 set YLFN = +$extract(YLFN,2,9)  ;LISTGENERATOR
      if (mOp.Equal(m$.Fnc.$extract(m$.var("YLFN").get()),1)) {
        mVar YLFN = m$.var("YLFN");
        YLFN.set(mOp.Positive(m$.Fnc.$extract(m$.var("YLFN").get(),2,9)));
      }
    }
    //<< }
    //<< 
    //<< if YUCI="" set YUCI = $zutil(5)
    if (mOp.Equal(m$.var("YUCI").get(),"")) {
      mVar YUCI = m$.var("YUCI");
      YUCI.set(m$.Fnc.$zutil(5));
    }
    //<< 
    //<< do GetDetails^WWWField(YFORM,YART,YLFN,.YDATEI,.YLFN1,.YVOR,.YSATZ,.YDVOR,.objCustFld,.YTYP,.objClsCustFld)
    m$.Cmd.Do("WWWField.GetDetails",m$.var("YFORM").get(),m$.var("YART").get(),m$.var("YLFN").get(),YDATEI,m$.var("YLFN1"),m$.var("YVOR"),YSATZ,m$.var("YDVOR"),objCustFld,m$.var("YTYP"),objClsCustFld);
    //<< ;---------------------------------------
    //<< ; Form,             P/D,        ClassFld#,       idWWW001,
    //<< ; idWWW121/122,     objWWW120,  objWWW121/122*,  objWWW002/003,
    //<< ; objWWW121D/122D,  InputType,  objWWW002D
    //<< ;       YSATZ is based on WWW121 or $$Get^WWW122
    //<< ;---------------------------------------
    //<< 
    //<< if $$$WWW120SaveServerdata(YVOR) set YHTMFORM = "WWW2"
    if (mOp.Logical(include.WWWConst.$$$WWW120SaveServerdata(m$,m$.var("YVOR")))) {
      mVar YHTMFORM = m$.var("YHTMFORM");
      YHTMFORM.set("WWW2");
    }
    //<< do Log(YFORM,YART,YLFN1,YSATZ)
    m$.Cmd.Do("Log",m$.var("YFORM").get(),m$.var("YART").get(),m$.var("YLFN1").get(),YSATZ.get());
    //<< 
    //<< if (YVAR'="PLUS") && (YART="D") {
    if ((mOp.NotEqual(YVAR.get(),"PLUS")) && (mOp.Equal(m$.var("YART").get(),"D"))) {
      //<< quit:'$$IsLockOk(YUSER,YFORM)                       ; *** EARLY QUIT - LOCK NOT OK
      if (mOp.Not(m$.fnc$("IsLockOk",m$.var("YUSER").get(),m$.var("YFORM").get()))) {
        return null;
      }
    }
    //<< }
    //<< ; Open a record from a data field - actually quite useful
    //<< if (YINHALT'="") {
    if ((mOp.NotEqual(YINHALT.get(),""))) {
      //<< set intAutoIdx = $$$WWW122AutomaticDisplayForIndexK(YSATZ)
      intAutoIdx.set(include.WWWConst.$$$WWW122AutomaticDisplayForIndexK(m$,YSATZ));
      //<< if (intAutoIdx'="") {
      if ((mOp.NotEqual(intAutoIdx.get(),""))) {
        //<< set strGlobal    = "^"_YDATEI_"s(0,"""_intAutoIdx_""","""_$$^WWWUMLAU(YINHALT,1)_""","""")"  ; 30-Apr-2010
        strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"s(0,\""),intAutoIdx.get()),"\",\""),m$.fnc$("WWWUMLAU.main",YINHALT.get(),1)),"\",\"\")"));
        //<< set strGlobal(1) = $order(@strGlobal)
        strGlobal.var(1).set(m$.Fnc.$order(m$.indirectVar(strGlobal.get())));
        //<< if strGlobal(1)'="" {
        if (mOp.NotEqual(strGlobal.var(1).get(),"")) {
          //<< set ^WWWSOR("SORTKEY",+$horolog,YUSER,YFORM,1) = strGlobal(1)
          m$.var("^WWWSOR","SORTKEY",mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),1).set(strGlobal.var(1).get());
          //<< set %TXT(1) = $$$Open
          m$.var("%TXT",1).set(include.COMSYS.$$$Open(m$));
          //<< 
          //<< quit                                        ; *** EARLY QUIT - Open record
          return null;
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit:$extract(%TXT(1))=$$$Perform                       ; *** EARLY QUITS - probably redundant
    if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$Perform(m$))) {
      return null;
    }
    //<< quit:$extract(%TXT(1))=$$$AlertFollowing
    if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$AlertFollowing(m$))) {
      return null;
    }
    //<< 
    //<< ; NOTE: At this stage %TXT(1) will be blank.
    //<< 
    //<< set strOrigInput = YINHALT      ; Store original input
    strOrigInput.set(YINHALT.get());
    //<< 
    //<< if YART'="P" {
    if (mOp.NotEqual(m$.var("YART").get(),"P")) {
      //<< set intDP = $$GetDecimalPlaces^COMUtilNum(YFORM,YLFN1,"",^WWWDATEN(0,+$horolog,YUSER,YFORM,"D",1),YSATZ) ; SR17250 2 lines
      intDP.set(m$.fnc$("COMUtilNum.GetDecimalPlaces",m$.var("YFORM").get(),m$.var("YLFN1").get(),"",m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1).get(),YSATZ.get()));
      //<< if intDP'="" set YDECIMALLEN = intDP
      if (mOp.NotEqual(intDP.get(),"")) {
        mVar YDECIMALLEN = m$.var("YDECIMALLEN");
        YDECIMALLEN.set(intDP.get());
      }
    }
    //<< 
    //<< /*  SR17250 replaced code
    //<< set intDP = ""
    //<< 
    //<< ; vvv SRBR014310 SR17579
    //<< 
    //<< if YART = "D" {
    //<< set idClassFldNo = YLFN
    //<< set idFormFldNo = +$$$GetFormField(YFORM,idClassFldNo)
    //<< if idFormFldNo'="" {
    //<< set objFormFld      =  $get(^WWW122(0,YFORM,idFormFldNo,1))  ; FIXME - use YSATZ - based on Get^WWW122?
    //<< set idAssocClassFld = +$$$WWW122AssociatedwithField(objFormFld)
    //<< if idAssocClassFld {
    //<< do CheckRelation^WWWEVENTUtils(YFORM,YDATEI,idFormFldNo,idClassFldNo,idAssocClassFld,.blnIsUnit,.blnIsItem)   ; SR17579
    //<< set idUnit = ""
    //<< if blnIsUnit {
    //<< set idUnit = $piece(^WWWDATEN(0,+$horolog,YUSER,YFORM,"D",1),Y,idAssocClassFld)
    //<< 
    //<< } elseif blnIsItem {
    //<< set idItem = $piece(^WWWDATEN(0,+$horolog,YUSER,YFORM,"D",1),Y,idAssocClassFld)
    //<< if idItem'="" set idUnit = $$$INARTUnitofMeasure($get(^INART(0,idItem,1)))
    //<< }
    //<< if idUnit'="" set intDP = $$$COMUnitDecimalPlaces($get(^COMUnit(0,idUnit,1)))
    //<< }
    //<< }
    //<< }
    //<< 
    //<< ; ^^^ SRBR014310
    //<< 
    //<< set:intDP="" intDP = $$$WWW122DDecimals(objCustFld)
    //<< set:intDP="" intDP = $$$WWW003NoOfDecimals(YDVOR)
    //<< set:intDP'="" YDECIMALLEN = intDP
    //<< */
    //<< 
    //<< } else {
    else {
      //<< ; **** TRANSLATION of YINHALT *****   (So remember, YINHALT is the display value...)
      //<< if $$SimulateCommainPrimaryKey^WWW012() {
      if (mOp.Logical(m$.fnc$("WWW012.SimulateCommainPrimaryKey"))) {
        //<< set YINHALT = $$FullReplace^COMUtilStr(YINHALT,",",$$$FAKECOMMA)   ;SR16126
        YINHALT.set(m$.fnc$("COMUtilStr.FullReplace",YINHALT.get(),",",include.COMSYSString.$$$FAKECOMMA(m$)));
      }
      //<< } else {
      else {
        //<< set YINHALT = $translate(YINHALT,",")                              ;SR16126
        YINHALT.set(m$.Fnc.$translate(YINHALT.get(),","));
      }
      //<< }
      //<< if YINHALT = "" {
      if (mOp.Equal(YINHALT.get(),"")) {
        //<< if $$$WWW002ForceNumerator(YDVOR) || $$$WWW002DForceNumerator(objClsCustFld) {
        if (mOp.Logical(include.WWWConst.$$$WWW002ForceNumerator(m$,m$.var("YDVOR"))) || mOp.Logical(include.WWWConst.$$$WWW002DForceNumerator(m$,objClsCustFld))) {
          //<< set YINHALT = "+"
          YINHALT.set("+");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< $$$LogR2x("F3:"_YDECIMALLEN_"<"_YINHALT_"<")
    $$$LogR2x(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("F3:",m$.var("YDECIMALLEN").get()),"<"),YINHALT.get()),"<"));
    //<< 
    //<< // VVVV SR16521
    //<< ; FIXME : see prior call to GetDetails^WWWField - equivalent to YSATZ? <GRF>  Duplication?  check if different field or form
    //<< 
    //<< ;                       "D" : $$Get^WWW122(YFORM,+$order(^WWW122s(0,4,YLFN,YFORM,""))),   ; SR17579
    //<< 
    //<< set objFormFld = $case(YART,
    //<< "D" : $$Get^WWW122(YFORM,+$$$GetFormField(YFORM,YLFN)),
    //<< "P" : $get(^WWW121(0,YFORM,YLFN,1)),
    //<< "M" : $$Get^WWW122(YFORM,YLFN),
    //<< : "")
    objFormFld.set(m$.Fnc.$case(m$.var("YART").get(),"D",m$.fnc$("WWW122.Get",m$.var("YFORM").get(),mOp.Positive(include.COMSYSWWW.$$$GetFormField(m$,m$.var("YFORM"),m$.var("YLFN")))),"P",m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),m$.var("YLFN").get(),1)),"M",m$.fnc$("WWW122.Get",m$.var("YFORM").get(),m$.var("YLFN").get()),""));
    //<< do GetRelation^WWWFieldValidation(YART,YFORM,YDATEI,YLFN,objFormFld,.blnTest,.idRelation)
    m$.Cmd.Do("WWWFieldValidation.GetRelation",m$.var("YART").get(),m$.var("YFORM").get(),YDATEI.get(),m$.var("YLFN").get(),objFormFld.get(),blnTest,idRelation);
    //<< 
    //<< do GetId^COMQuickSearch(YDATEI,$get(idRelation),.YINHALT,YART)
    m$.Cmd.Do("COMQuickSearch.GetId",YDATEI.get(),m$.Fnc.$get(idRelation),YINHALT,m$.var("YART").get());
    //<< // ^^^^ SR16521
    //<< 
    //<< set strExecOnBlur = $$$WWW122ExecuteOnBlur(YSATZ)
    strExecOnBlur.set(include.WWWConst.$$$WWW122ExecuteOnBlur(m$,YSATZ));
    //<< set strStored     = ""
    strStored.set("");
    //<< ; This should have a YART="D" check.  Where is WWWLAST set?
    //<< if ($extract(YINHALT,1,2)="^^") || ($extract(YINHALT,1,2)="°°") {  ; Get the last version
    if ((mOp.Equal(m$.Fnc.$extract(YINHALT.get(),1,2),"^^")) || (mOp.Equal(m$.Fnc.$extract(YINHALT.get(),1,2),"°°"))) {
      //<< set strStored =  $$GetLast^WWWField(.YINHALT)
      strStored.set(m$.fnc$("WWWField.GetLast",YINHALT));
    }
    //<< }
    //<< 
    //<< ; Fill with zeroes (max 15 leading zeros)
    //<< ; FIXME : Strings with leading digits will get zero fill, those with leading alpha will not <GRF>
    //<< ; FIXME - This does not work whatsoever. Needs to be spec'ed as well <Phil>
    //<< ;---------------------------------------
    //<< if +$$$WWW122ForceStringLengthTo(YSATZ)'=0 set YINHALT = $extract(10000000000+YINHALT,11-$piece(YSATZ,Y,18),10)  ;STRINGLÄNGE MIT 0 ;by means of
    if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW122ForceStringLengthTo(m$,YSATZ)),0)) {
      YINHALT.set(m$.Fnc.$extract(mOp.Add(10000000000D,YINHALT.get()),mOp.Subtract(11,m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),18)),10));
    }
    //<< 
    //<< set idChangeInput = $$$WWW122ChangeInputAs(YSATZ)
    idChangeInput.set(include.WWWConst.$$$WWW122ChangeInputAs(m$,YSATZ));
    //<< do:idChangeInput'="" ChangeInputAs^WWWFieldRules(.YINHALT,idChangeInput)
    if (mOp.NotEqual(idChangeInput.get(),"")) {
      m$.Cmd.Do("WWWFieldRules.ChangeInputAs",YINHALT,idChangeInput.get());
    }
    //<< 
    //<< set strPattern = $$$WWW122DPatternMatch(objCustFld)
    strPattern.set(include.WWWConst.$$$WWW122DPatternMatch(m$,objCustFld));
    //<< do:strPattern'="" CustPattern^WWWFieldRules(YINHALT,strPattern)     ; %TXT(1) may be set
    if (mOp.NotEqual(strPattern.get(),"")) {
      m$.Cmd.Do("WWWFieldRules.CustPattern",YINHALT.get(),strPattern.get());
    }
    //<< 
    //<< ; Dates
    //<< if ((YTYP=1) || (YTYP=17)) && (YINHALT'="") {
    if (mOp.Logical(((mOp.Equal(m$.var("YTYP").get(),1)) || (mOp.Equal(m$.var("YTYP").get(),17)))) && (mOp.NotEqual(YINHALT.get(),""))) {
      //<< set strStored = $$TranslateDate^WWWFieldRules(.YINHALT)         ; %TXT(1) may be set
      strStored.set(m$.fnc$("WWWFieldRules.TranslateDate",YINHALT));
    }
    //<< } elseif (YTYP=7)&&(YINHALT'="") {      ;SR18026
    else if ((mOp.Equal(m$.var("YTYP").get(),7)) && (mOp.NotEqual(YINHALT.get(),""))) {
      //<< set strStored=$$^WWWTIME1(YINHALT)  ;SR18026
      strStored.set(m$.fnc$("WWWTIME1.main",YINHALT.get()));
    }
    //<< }
    //<< 
    //<< ; This does not work very well... needs to be looked at later (OR REMOVED!)
    //<< ; For starters there should be a date check ??
    //<< if (strExecOnBlur'="") && ($find("-,.+",$extract(strExecOnBlur))) {
    if ((mOp.NotEqual(strExecOnBlur.get(),"")) && mOp.Logical((m$.Fnc.$find("-,.+",m$.Fnc.$extract(strExecOnBlur.get()))))) {
      //<< do DateOk^WWWFieldRules(.YINHALT,.strStored,strExecOnBlur)      ; %TXT(1) may be set
      m$.Cmd.Do("WWWFieldRules.DateOk",YINHALT,strStored,strExecOnBlur.get());
      //<< set strExecOnBlur = ""
      strExecOnBlur.set("");
    }
    //<< }
    //<< 
    //<< do InputOk^WWWFieldRules(YINHALT,YSATZ,YVOR)                        ; %TXT(1) may be set
    m$.Cmd.Do("WWWFieldRules.InputOk",YINHALT.get(),YSATZ.get(),m$.var("YVOR").get());
    //<< 
    //<< ; *** STORAGE / OPEN ***
    //<< do Store(.YINHALT,.strStored)
    m$.Cmd.Do("Store",YINHALT,strStored);
    //<< 
    //<< quit:(YART="P")&&$$Open(.YINHALT,.strStored,YVOR,YDVOR,objClsCustFld)           ; *** EARLY QUIT ***  If we are opening a record.
    if ((mOp.Equal(m$.var("YART").get(),"P")) && mOp.Logical(m$.fnc$("Open",YINHALT,strStored,m$.var("YVOR").get(),m$.var("YDVOR").get(),objClsCustFld.get()))) {
      return null;
    }
    //<< if YTYP=7 set YINHALT=$$FieldSize^COMUtils(YFORM,YLFN,YINHALT) ;SR18026
    if (mOp.Equal(m$.var("YTYP").get(),7)) {
      YINHALT.set(m$.fnc$("COMUtils.FieldSize",m$.var("YFORM").get(),m$.var("YLFN").get(),YINHALT.get()));
    }
    //<< 
    //<< do SetLock(YUSER,YFORM,+$horolog)  ; SR15961.1
    m$.Cmd.Do("SetLock",m$.var("YUSER").get(),m$.var("YFORM").get(),mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< 
    //<< ; There is still a conflict between AlertAndFocus/Confirm and other functions
    //<< ; This needs to be looked at.
    //<< ; On blur won't be called for example.
    //<< 
    //<< 
    //<< quit:$extract(%TXT(1))=$$$AlertAndFocus
    if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$AlertAndFocus(m$))) {
      return null;
    }
    //<< quit:$extract(%TXT(1))=$$$Confirm
    if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$Confirm(m$))) {
      return null;
    }
    //<< 
    //<< ; *** DISPLAY ***
    //<< 
    //<< if YART'="P" do ReadWrite^WWWFieldRules(YINHALT,YSATZ,YTYP,YART)
    if (mOp.NotEqual(m$.var("YART").get(),"P")) {
      m$.Cmd.Do("WWWFieldRules.ReadWrite",YINHALT.get(),YSATZ.get(),m$.var("YTYP").get(),m$.var("YART").get());
    }
    //<< 
    //<< if (YTYP=$$$FLDMemo) && (YVAR'="PLUS") {
    if ((mOp.Equal(m$.var("YTYP").get(),include.COMSYSWWW.$$$FLDMemo(m$))) && (mOp.NotEqual(YVAR.get(),"PLUS"))) {
      //<< if '$find(%TXT(1),$$$Perform) {
      if (mOp.Not(m$.Fnc.$find(m$.var("%TXT",1).get(),include.COMSYS.$$$Perform(m$)))) {
        //<< set %TXT(1)=""
        m$.var("%TXT",1).set("");
        //<< do PARAMETER(YSATZ,YDVOR)
        m$.Cmd.Do("PARAMETER",YSATZ.get(),m$.var("YDVOR").get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if (YART="D") || (YART="M") {
    if ((mOp.Equal(m$.var("YART").get(),"D")) || (mOp.Equal(m$.var("YART").get(),"M"))) {
      //<< do CustomWarnings^WWWFieldRules(.YXTEXT,YINHALT,objCustFld)
      m$.Cmd.Do("WWWFieldRules.CustomWarnings",m$.var("YXTEXT"),YINHALT.get(),objCustFld.get());
    }
    //<< }
    //<< 
    //<< if $find($piece(YVAR,".",1),"^") {     ;AUTOMATISCHER START NACH PROGRAMM IN VARIABLEN ;take-off within programme within
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YVAR.get(),".",1),"^"))) {
      //<< xecute "do "_$piece(YVAR,".",1)
      m$.Cmd.Xecute(mOp.Concat("do ",m$.Fnc.$piece(YVAR.get(),".",1)));
    }
    //<< }
    //<< 
    //<< $$$LogR2x("F4:"_YDECIMALLEN_"<"_YINHALT_"<")
    $$$LogR2x(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("F4:",m$.var("YDECIMALLEN").get()),"<"),YINHALT.get()),"<"));
    //<< 
    //<< ; Custom on blur
    //<< do:strExecOnBlur'="" OnBlur(strExecOnBlur,.YINHALT,strField)       ; ***** EXECUTE *****
    if (mOp.NotEqual(strExecOnBlur.get(),"")) {
      m$.Cmd.Do("OnBlur",strExecOnBlur.get(),YINHALT,strField.get());
    }
    //<< do FieldValidation(strField)  ;AUTOMATISCHE FELDVALIDIERUNGSFUNKTIONSAUFRUF
    m$.Cmd.Do("FieldValidation",strField.get());
    //<< 
    //<< $$$LogR2x("F5:"_YDECIMALLEN_"<"_YINHALT_"<"_strOrigInput_"<")
    $$$LogR2x(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("F5:",m$.var("YDECIMALLEN").get()),"<"),YINHALT.get()),"<"),strOrigInput.get()),"<"));
    //<< 
    //<< ; Update display of Current Field - this is very important!! Why doesn't Intraprend think so?
    //<< 
    //<< if YINHALT'=strOrigInput {
    if (mOp.NotEqual(YINHALT.get(),strOrigInput.get())) {
      //<< $$$Append(%TXT(1),$$$Perform_strField_Y_$$$EscapeHyperEventData(YINHALT))
      include.COMSYSString.$$$Append(m$,m$.var("%TXT",1),mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYS.$$$Perform(m$),strField.get()),m$.var("Y").get()),include.COMSYS.$$$EscapeHyperEventData(m$,YINHALT)));
    }
    //<< }
    //<< do UpdateGrid^COMGridEdit31Links(strField,YINHALT,strOrigInput)  ;SR18026
    m$.Cmd.Do("COMGridEdit31Links.UpdateGrid",strField.get(),YINHALT.get(),strOrigInput.get());
    //<< set YCROK = $$$NO
    mVar YCROK = m$.var("YCROK");
    YCROK.set(include.COMSYS.$$$NO(m$));
    //<< if (YTYP=$$$FLDText) && '$find(YINHALT,"|") {
    if ((mOp.Equal(m$.var("YTYP").get(),include.COMSYSWWW.$$$FLDText(m$))) && mOp.Not(m$.Fnc.$find(YINHALT.get(),"|"))) {
      //<< set YCROK = $$$YES  ;| NICHT UMWANDELN ;Not transmute
      YCROK.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< ; Change colour of cell to red if has relation and doesn't exist.
    //<< if '$$ValidRelation^WWWFieldValidation(YART,YDATEI,YFORM,YLFN,strStored,$$$YES,.strReason) {
    if (mOp.Not(m$.fnc$("WWWFieldValidation.ValidRelation",m$.var("YART").get(),YDATEI.get(),m$.var("YFORM").get(),m$.var("YLFN").get(),strStored.get(),include.COMSYS.$$$YES(m$),strReason))) {
      //<< if strReason'="" {
      if (mOp.NotEqual(strReason.get(),"")) {
        //<< set %TXT(1) = %TXT(1)_"#!"_$$$Text(strReason)
        m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#!"),include.COMSYS.$$$Text(m$,strReason)));
      }
    }
    //<< }
    //<< }
    //<< do PARAMETER(YSATZ,YDVOR)
    m$.Cmd.Do("PARAMETER",YSATZ.get(),m$.var("YDVOR").get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< FieldValidation(pstrField)
  public Object FieldValidation(Object ... _p) {
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Execute user validation
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Apr-2011   shobby  SR17701: Use $Get^WWW122 to include customisation.
    //<< ; 03-May-2010   GRF     SR15961: use dteToday for efficiency
    //<< ; 16-Jun-2009   GRF     SR16534: Replace order macro
    //<< ; 28-May-2009   shobby  SR16534: Replaced repeated code with a common routine.
    //<< ; 04-Jan-2008   Heber   SRBR014794: Core masking added
    //<< ; 04-Jul-2007   RPW     SRBR014409: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new dteToday,idField,intPiece,objWWW122,strMask,strMaskVarName
    mVar dteToday = m$.var("dteToday");
    mVar idField = m$.var("idField");
    mVar intPiece = m$.var("intPiece");
    mVar objWWW122 = m$.var("objWWW122");
    mVar strMask = m$.var("strMask");
    mVar strMaskVarName = m$.var("strMaskVarName");
    m$.newVar(dteToday,idField,intPiece,objWWW122,strMask,strMaskVarName);
    //<< new strMaskedFieldName,strToExecute,YFELD,YFELDSAVED,YMFELD,YXTEXT
    mVar strMaskedFieldName = m$.var("strMaskedFieldName");
    mVar strToExecute = m$.var("strToExecute");
    mVar YFELD = m$.var("YFELD");
    mVar YFELDSAVED = m$.var("YFELDSAVED");
    mVar YMFELD = m$.var("YMFELD");
    mVar YXTEXT = m$.var("YXTEXT");
    m$.newVar(strMaskedFieldName,strToExecute,YFELD,YFELDSAVED,YMFELD,YXTEXT);
    //<< 
    //<< $$$LogR2("FieldValidation",pstrField)
    $$$LogR2(m$,"FieldValidation",pstrField);
    //<< 
    //<< set dteToday = +$horolog     ; SR15961
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< if YUSER'="" {
    if (mOp.NotEqual(m$.var("YUSER").get(),"")) {
      //<< set YFELD      = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"D",1))   ;DATENSATZ AKTUELL         ; modified data record
      YFELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1)));
      //<< set YMFELD     = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"M",1))   ;DATENSATZ MANUELL AKTUELL ; up-to-date manual record
      YMFELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"M",1)));
      //<< set YFELDSAVED = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"D",2))   ;DATENSATZ GESPEICHERT     ; original data record
      YFELDSAVED.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",2)));
    }
    //<< }
    //<< ;
    //<< if $data(^ROUTINE(pstrField)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^ROUTINE",pstrField.get())))) {
      //<< set strToExecute="set %TXT(1)=$$^"_pstrField_"(YINHALT)"
      strToExecute.set(mOp.Concat(mOp.Concat("set %TXT(1)=$$^",pstrField.get()),"(YINHALT)"));
      //<< xecute strToExecute                                                ; ***** EXECUTE *****
      m$.Cmd.Xecute(strToExecute.get());
    }
    //<< }
    //<< 
    //<< // APPLY CORE MASKING
    //<< // Applies core mask to each form field if there is not a customized mask
    //<< set idField = ""
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField = $order(^WWW122(0,YFORM,idField))
      idField.set(m$.Fnc.$order(m$.var("^WWW122",0,m$.var("YFORM").get(),idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< 
      //<< set objWWW122 = $$Get^WWW122(YFORM,idField)     ;SR17701
      objWWW122.set(m$.fnc$("WWW122.Get",m$.var("YFORM").get(),idField.get()));
      //<< continue:($$$WWW122Mask(objWWW122) = "")  ; no core mask to be applied to the field
      if ((mOp.Equal(include.WWWConst.$$$WWW122Mask(m$,objWWW122),""))) {
        continue;
      }
      //<< 
      //<< ;SR17701 ; if no custom mask is defined, apply core mask
      //<< if ('$$IsMaskable^WWWFORM8(YFORM,idField,YM)) { ; check if there is a custom mask ;SR17701 (This really checks for rules)
      if ((mOp.Not(m$.fnc$("WWWFORM8.IsMaskable",m$.var("YFORM").get(),idField.get(),m$.var("YM").get())))) {
        //<< ;SR17701 set strMask            = $$GetCoreMask^WWWFORM7(YFELD,YMFELD,objWWW122) ; get Mask
        //<< set strMask            = $$$WWW122Mask(objWWW122)     ;SR17701
        strMask.set(include.WWWConst.$$$WWW122Mask(m$,objWWW122));
        //<< set strMaskVarName     = $$GetMaskVarName^WWWFORM8(YFORM,idField)       ; get mask variable name
        strMaskVarName.set(m$.fnc$("WWWFORM8.GetMaskVarName",m$.var("YFORM").get(),idField.get()));
        //<< set strMaskedFieldName = $$GetFieldName^WWWFORM8(YFORM,idField)         ; get field name to receive mask
        strMaskedFieldName.set(m$.fnc$("WWWFORM8.GetFieldName",m$.var("YFORM").get(),idField.get()));
        //<< write strMaskVarName_"="""_$zconvert(strMask,"O","JS")_""";"            ; loads mask value into mask variable
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(strMaskVarName.get(),"=\""),m$.Fnc.$zconvert(strMask.get(),"O","JS")),"\";"));
        //<< write strMaskedFieldName_".value = doMasking("_strMaskVarName_","_strMaskedFieldName_".value,49);"  ; calls mask function
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strMaskedFieldName.get(),".value = doMasking("),strMaskVarName.get()),","),strMaskedFieldName.get()),".value,49);"));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set %TXT(1) = %TXT(1)_$$CheckRules(YFORM,.YFELD)
    m$.var("%TXT",1).set(mOp.Concat(m$.var("%TXT",1).get(),m$.fnc$("CheckRules",m$.var("YFORM").get(),YFELD)));
    //<< if $extract(%TXT(1))=$$$Perform {
    if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$Perform(m$))) {
      //<< do DATEN  ;AUSWERTEN NEUE FELDER
      m$.Cmd.Do("DATEN");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CheckRules(pYFORM,&pYFELD,pintRow="")
  public Object CheckRules(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintRow = m$.newVarRef("pintRow",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Dynamically applies custom rules to the current screen.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-May-2013   shobby  CORE-114: New 'Filter' field to limit results collected by 'Rules'
    //<< ; 15-May-2013   shobby  CORE-79.7: Remove previous change.
    //<< ; 14-May-2013   shobby  CORE-79.2: Change state of any FATSearch button.
    //<< ; 25-Jun-2012   shobby  SR18026.1: Problem with multiple rules if the second rule
    //<< ;                           doesn't change a value.
    //<< ; 23-May-2012   shobby  SR18016: HideControl for Manual Fields.
    //<< ; 16-Aug-2011   shobby  SR17784: Allow 'Rules' to show/hide controls.
    //<< ; 10-Aug-2011   shobby  SR16704: Allow 'Rules' to modify colour and make readonly
    //<< ;                                for Manual Fields.
    //<< ; 21-Apr-2011   shobby  SR17714: Allow rules to update values of manual fields.
    //<< ; 02-Sep-2009   shobby  SR16511: Only use FontColor if field is readonly.
    //<< ; 26-Aug-2009   shobby  SR16511: Font Color
    //<< ; 12-Aug-2009   shobby  SR16511: Don't try and update a cell that is not on the
    //<< ;                           visible page on a grid.
    //<< ; 09-Jun-2009   shobby  SRBR014955: Changed YFORM to pYFORM
    //<< ; 28-May-2009   shobby  SR16534:    Get rules information from a shared routine.
    //<< ; 25-Jul-2008   GRF     SRBR014794: blnMaskable repeated in new list - corrected;
    //<< ;                           move separately newed variables back into main new.
    //<< ; 19-Jun-2008   shobby  SRBR014955: Don't run the rules if the form is readonly.
    //<< ; 13-Apr-2008   heber   SRBR014932: Apply mask to grid fields
    //<< ; 04-Jan-2008   heber   SRBR014794: Move mask from WWW122D to WWW122D2
    //<< ; 19-Sep-2007   shobby  SRBR014721: Don't use 'disabled' to disable a control.
    //<< ;                           Special conditions are handled in the PrepareUpdate
    //<< ;                           javascript function for controls that don't have readonly.
    //<< ; 17-Aug-2007   shobby  SRBR014624: Call the PopulateDataField with pblnDoEvent
    //<< ;                       set to true (will manage 'show relation after entry' better.
    //<< ; 14-Aug-2007   shobby  SRBR014637: Make selection controls disabled.
    //<< ; 08-Aug-2007   shobby  SRBR014616: If this is in a grid the current row will
    //<< ;                           be passed in.
    //<< ; 26-Jul-2007   GRF     SRBR014575: Use boolean macros; use loop instead of
    //<< ;                       idxButtons; wrap long argument list (5 to line).
    //<< ; 11-Jul-2007   Frank   SRBR014575: Added relation class check.
    //<< ; 05-Jul-2007   shobby  SRBR014409: New variable strReadOnly to contain the text
    //<< ;                       equivalent of blnReadOnly
    //<< ; 25-Jun-2007   shobby  SRBR014409: Use subroutine to work out image to be displayed.
    //<< ; 08-Jun-2007   RPW     SRBR014409: idButton used to stop looking through list twice.
    //<< ; 06-Jun-2007   shobby  SRBR014409: Subroutined Updating of button states.
    //<< ; 05-Jun-2007   shobby  SRBR014409: Date popup buttons now show as disabled when
    //<< ;                       the attached field is disabled.
    //<< ; 31-May-2007   shobby  SRBR014409: Corrected Form name for attached buttons.
    //<< ; 13-Apr-2007   shobby  SRBR014409: Take strNewFieldColor value from CheckRules^WWWFORMD
    //<< ; 12-Apr-2007   shobby  SRBR014409: UpdateFieldFormat requires the class field
    //<< ;                       number not the form field number.
    //<< ; 12-Apr-2007   shobby  SRBR014409: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrRules,blnHidden,blnMandatory,blnMaskable,blnReadOnly,blnUseValueOfDataField
    mVar arrRules = m$.var("arrRules");
    mVar blnHidden = m$.var("blnHidden");
    mVar blnMandatory = m$.var("blnMandatory");
    mVar blnMaskable = m$.var("blnMaskable");
    mVar blnReadOnly = m$.var("blnReadOnly");
    mVar blnUseValueOfDataField = m$.var("blnUseValueOfDataField");
    m$.newVar(arrRules,blnHidden,blnMandatory,blnMaskable,blnReadOnly,blnUseValueOfDataField);
    //<< new idButton,idClassField,idField,idRule,idSeqNumber,intColour
    mVar idButton = m$.var("idButton");
    mVar idClassField = m$.var("idClassField");
    mVar idField = m$.var("idField");
    mVar idRule = m$.var("idRule");
    mVar idSeqNumber = m$.var("idSeqNumber");
    mVar intColour = m$.var("intColour");
    m$.newVar(idButton,idClassField,idField,idRule,idSeqNumber,intColour);
    //<< new loop,lstButtons,objRule,objWWW122,strData,strFontColor,strHidden,strImage
    mVar loop = m$.var("loop");
    mVar lstButtons = m$.var("lstButtons");
    mVar objRule = m$.var("objRule");
    mVar objWWW122 = m$.var("objWWW122");
    mVar strData = m$.var("strData");
    mVar strFontColor = m$.var("strFontColor");
    mVar strHidden = m$.var("strHidden");
    mVar strImage = m$.var("strImage");
    m$.newVar(loop,lstButtons,objRule,objWWW122,strData,strFontColor,strHidden,strImage);
    //<< new strMask,strMaskedFieldName,strMaskVarName,strNewFieldColor
    mVar strMask = m$.var("strMask");
    mVar strMaskedFieldName = m$.var("strMaskedFieldName");
    mVar strMaskVarName = m$.var("strMaskVarName");
    mVar strNewFieldColor = m$.var("strNewFieldColor");
    m$.newVar(strMask,strMaskedFieldName,strMaskVarName,strNewFieldColor);
    //<< new strReadOnly,strRelationClass,strRelationKeys,strRuleField,strValue,YFELDSAVED
    mVar strReadOnly = m$.var("strReadOnly");
    mVar strRelationClass = m$.var("strRelationClass");
    mVar strRelationKeys = m$.var("strRelationKeys");
    mVar strRuleField = m$.var("strRuleField");
    mVar strValue = m$.var("strValue");
    mVar YFELDSAVED = m$.var("YFELDSAVED");
    m$.newVar(strReadOnly,strRelationClass,strRelationKeys,strRuleField,strValue,YFELDSAVED);
    //<< new strFilter ;CORE-114
    mVar strFilter = m$.var("strFilter");
    m$.newVar(strFilter);
    //<< 
    //<< quit:$get(^WWWDATEN(0,+$horolog,YUSER,pYFORM,"V","AUTHORISATION",1))=$$$EnumReadOnly ""
    if (mOp.Equal(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pYFORM.get(),"V","AUTHORISATION",1)),include.COMSYSEnum.$$$EnumReadOnly(m$))) {
      return "";
    }
    //<< 
    //<< $$$LogR3("CheckRules",pYFORM_"<"_pintRow)
    $$$LogR3(m$,"CheckRules",mOp.Concat(mOp.Concat(pYFORM.get(),"<"),pintRow.get()));
    //<< do GetRules^WWWFORMD(.arrRules,pYFORM)
    m$.Cmd.Do("WWWFORMD.GetRules",arrRules,pYFORM.get());
    //<< $$$LogR3m(arrRules)
    $$$LogR3m(m$,arrRules);
    //<< 
    //<< set idField = ""   ; SR16534
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField = $order(arrRules(idField))
      idField.set(m$.Fnc.$order(arrRules.var(idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< set blnHidden              = $$$NO
      blnHidden.set(include.COMSYS.$$$NO(m$));
      //<< set blnMandatory           = $$$NO
      blnMandatory.set(include.COMSYS.$$$NO(m$));
      //<< set blnReadOnly            = $$$NO
      blnReadOnly.set(include.COMSYS.$$$NO(m$));
      //<< set blnUseValueOfDataField = $$$NO
      blnUseValueOfDataField.set(include.COMSYS.$$$NO(m$));
      //<< set intColour              = ""
      intColour.set("");
      //<< set strMask                = ""       // SRBR014794
      strMask.set("");
      //<< set strNewFieldColor       = ""
      strNewFieldColor.set("");
      //<< set strRelationClass       = ""
      strRelationClass.set("");
      //<< set strRelationKeys        = ""
      strRelationKeys.set("");
      //<< set strRuleField           = ""
      strRuleField.set("");
      //<< set YFELDSAVED             = pYFELD
      YFELDSAVED.set(pYFELD.get());
      //<< set strValue               = "" ;SR18026.1
      strValue.set("");
      //<< 
      //<< ; return also the customized mask
      //<< do CheckRules^WWWFORMD(pYFORM,idField,.pYFELD,.blnHidden,.blnReadOnly,
      //<< .intColour,.blnMandatory,$$$YES,.strNewFieldColor,.strRelationClass,
      //<< .strRelationKeys,.blnUseValueOfDataField,.strRuleField,.strMask,.strValue,.strFontColor,.strFilter) ;CORE-114
      m$.Cmd.Do("WWWFORMD.CheckRules",pYFORM.get(),idField.get(),pYFELD,blnHidden,blnReadOnly,intColour,blnMandatory,include.COMSYS.$$$YES(m$),strNewFieldColor,strRelationClass,strRelationKeys,blnUseValueOfDataField,strRuleField,strMask,strValue,strFontColor,strFilter);
      //<< //   .strRelationKeys,.blnUseValueOfDataField,.strRuleField)          //SRBR014794  ;SR16704
      //<< ;if $get(YBACKGROUNDCOLOR)="" set YBACKGROUNDCOLOR=strNewFieldColor     ;15753
      //<< 
      //<< $$$LogR3x("E-CR:"_idField_":"_blnHidden_","_blnReadOnly_","_blnMandatory_"<"_strNewFieldColor)
      $$$LogR3x(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("E-CR:",idField.get()),":"),blnHidden.get()),","),blnReadOnly.get()),","),blnMandatory.get()),"<"),strNewFieldColor.get()));
      //<< ; applies customized mask
      //<< if $$IsMaskable^WWWFORM8(pYFORM,idField,YM) { ; check if there is custom mask apply mask even if empty
      if (mOp.Logical(m$.fnc$("WWWFORM8.IsMaskable",pYFORM.get(),idField.get(),m$.var("YM").get()))) {
        //<< set strMaskVarName     = $$GetMaskVarName^WWWFORM8(pYFORM,idField)
        strMaskVarName.set(m$.fnc$("WWWFORM8.GetMaskVarName",pYFORM.get(),idField.get()));
        //<< set strMaskedFieldName = $$GetFieldName^WWWFORM8(pYFORM,idField)
        strMaskedFieldName.set(m$.fnc$("WWWFORM8.GetFieldName",pYFORM.get(),idField.get()));
        //<< ; apply mask since it is not grid
        //<< if (pintRow="") {
        if ((mOp.Equal(pintRow.get(),""))) {
          //<< write " "_strMaskVarName_"="""_$zconvert(strMask,"O","JS")_""";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ",strMaskVarName.get()),"=\""),m$.Fnc.$zconvert(strMask.get(),"O","JS")),"\";"));
          //<< write strMaskedFieldName_".value = doMasking("_strMaskVarName_","_strMaskedFieldName_".value,49);"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strMaskedFieldName.get(),".value = doMasking("),strMaskVarName.get()),","),strMaskedFieldName.get()),".value,49);"));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< ;SR16704 vvvvv (Moved from inside the else)
      //<< if blnReadOnly {
      if (mOp.Logical(blnReadOnly.get())) {
        //<< set strReadOnly = $$$JStrue
        strReadOnly.set(include.COMSYSJS.$$$JStrue(m$));
        //<< set strHidden   = $$$JShidden
        strHidden.set(include.COMSYSJS.$$$JShidden(m$));
      }
      //<< } else {
      else {
        //<< set strReadOnly = $$$JSfalse
        strReadOnly.set(include.COMSYSJS.$$$JSfalse(m$));
        //<< if blnHidden {
        if (mOp.Logical(blnHidden.get())) {
          //<< set strHidden = $$$JShidden
          strHidden.set(include.COMSYSJS.$$$JShidden(m$));
        }
        //<< } else {
        else {
          //<< set strHidden = $$$JSvisible
          strHidden.set(include.COMSYSJS.$$$JSvisible(m$));
        }
      }
      //<< }
      //<< }
      //<< ;SR16704
      //<< 
      //<< set idClassField = $$$GetClassField(pYFORM,idField)
      idClassField.set(include.COMSYSWWW.$$$GetClassField(m$,pYFORM,idField));
      //<< 
      //<< if idClassField="" {
      if (mOp.Equal(idClassField.get(),"")) {
        //<< if pintRow'="" {
        if (mOp.NotEqual(pintRow.get(),"")) {
          //<< ; grid
          //<< do UpdateManualField^COMGridEdit31Interface(pintRow,idField,strValue)   ;SR16704
          m$.Cmd.Do("COMGridEdit31Interface.UpdateManualField",pintRow.get(),idField.get(),strValue.get());
        }
        //<< } else {                                                                    ;SR17714
        else {
          //<< do PopulateDataField^COMUtils(pYFORM,idField,strValue,"M",,$$$NO)       ;SR17714
          m$.Cmd.Do("COMUtils.PopulateDataField",pYFORM.get(),idField.get(),strValue.get(),"M",null,include.COMSYS.$$$NO(m$));
          //<< do UpdateFieldFormat^COMUtils("Y"_pYFORM_"M"_idField_".style","backgroundColor",strNewFieldColor)   ;SR16704
          m$.Cmd.Do("COMUtils.UpdateFieldFormat",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",pYFORM.get()),"M"),idField.get()),".style"),"backgroundColor",strNewFieldColor.get());
          //<< do UpdateFieldFormat^COMUtils("Y"_pYFORM_"M"_idField,"readOnly",strReadOnly)                        ;SR16704
          m$.Cmd.Do("COMUtils.UpdateFieldFormat",mOp.Concat(mOp.Concat(mOp.Concat("Y",pYFORM.get()),"M"),idField.get()),"readOnly",strReadOnly.get());
          //<< do HideControl^COMUtils(pYFORM,"",idField,blnHidden,"M") ;SR18016
          m$.Cmd.Do("COMUtils.HideControl",pYFORM.get(),"",idField.get(),blnHidden.get(),"M");
        }
      }
      //<< }                                                                           ;SR17714
      //<< 
      //<< } else {       ; TODO :  Check core and customisation for default values.
      else {
        //<< 
        //<< if pintRow'="" {  ; This is a grid row
        if (mOp.NotEqual(pintRow.get(),"")) {
          //<< if (strFontColor'="") && blnReadOnly {  ;SR16511
          if ((mOp.NotEqual(strFontColor.get(),"")) && mOp.Logical(blnReadOnly.get())) {
            //<< do UpdateFieldFormat^COMUtils("tdY"_pintRow_"_"_idField_".style","color",strFontColor)
            m$.Cmd.Do("COMUtils.UpdateFieldFormat",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("tdY",pintRow.get()),"_"),idField.get()),".style"),"color",strFontColor.get());
          }
          //<< }
          //<< do UpdateFieldFormat^COMUtils("tdY"_pintRow_"_"_idField_".style","backgroundColor",strNewFieldColor)
          m$.Cmd.Do("COMUtils.UpdateFieldFormat",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("tdY",pintRow.get()),"_"),idField.get()),".style"),"backgroundColor",strNewFieldColor.get());
          //<< ;   do UpdateFieldFormat^COMUtils("tdY"_pintRow_"_"_idField_".style","color","red")
          //<< write "var element=document.getElementById('tdY"_pintRow_"_"_idField_"');"  ;SR16511
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("var element=document.getElementById('tdY",pintRow.get()),"_"),idField.get()),"');"));
          //<< write "if (element!=null) { element.Locked="_blnReadOnly_";}"               ;SR16511
          m$.Cmd.Write(mOp.Concat(mOp.Concat("if (element!=null) { element.Locked=",blnReadOnly.get()),";}"));
          //<< ;   write "document.getElementById('tdY"_pintRow_"_"_idField_"').Locked="_blnReadOnly_";" ;SR16511
          //<< 
          //<< //  testing
          //<< if $$IsMaskable^WWWFORM8(pYFORM,idField,YM) {  ;shobby ADHOC
          if (mOp.Logical(m$.fnc$("WWWFORM8.IsMaskable",pYFORM.get(),idField.get(),m$.var("YM").get()))) {
            //<< set objWWW122   = $get(^WWW122(0,pYFORM,idField,1))
            objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,pYFORM.get(),idField.get(),1)));
            //<< set idSeqNumber = $$$WWW122SequenceNumber(objWWW122)
            idSeqNumber.set(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122));
            //<< set $piece(pYFELD,Y,idSeqNumber) = $$ApplyMask^WWWFORM8($piece(pYFELD,Y,idSeqNumber),strMask)
            m$.pieceVar(pYFELD,m$.var("Y").get(),idSeqNumber.get()).set(m$.fnc$("WWWFORM8.ApplyMask",m$.Fnc.$piece(pYFELD.get(),m$.var("Y").get(),idSeqNumber.get()),strMask.get()));
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< if strRelationClass '= "" {
          if (mOp.NotEqual(strRelationClass.get(),"")) {
            //<< ;if $get(YKEY)="" {
            //<< ;   ;SR16890
            //<< ;   new YKEY,YFORM
            //<< ;   set YFORM=pYFORM
            //<< ;   set YKEY = $$GetYKEY^WWWFORMD()
            //<< ;}
            //<< set strData = $piece(pYFELD,Y,strRuleField)
            strData.set(m$.Fnc.$piece(pYFELD.get(),m$.var("Y").get(),strRuleField.get()));
            //<< if blnUseValueOfDataField && (strData '= "") {
            if (mOp.Logical(blnUseValueOfDataField.get()) && (mOp.NotEqual(strData.get(),""))) {
              //<< if strRelationKeys '= "" set strRelationKeys = strRelationKeys_","
              if (mOp.NotEqual(strRelationKeys.get(),"")) {
                strRelationKeys.set(mOp.Concat(strRelationKeys.get(),","));
              }
              //<< set strRelationKeys = strRelationKeys_""""_strData_""""
              strRelationKeys.set(mOp.Concat(mOp.Concat(mOp.Concat(strRelationKeys.get(),"\""),strData.get()),"\""));
            }
            //<< }
            //<< ;set strRelationKeys=$replace(strRelationKeys,"SPRACHE",SPRACHE) ;SR16890
            //<< ;set strRelationKeys=$replace(strRelationKeys,"YKEY",YKEY)       ;SR16890
            //<< do PopulateComboBox^COMUtils(pYFORM,idClassField,$piece(pYFELD,Y,idClassField),"D",strRelationClass,strRelationKeys,strFilter)  ;CORE-114
            m$.Cmd.Do("COMUtils.PopulateComboBox",pYFORM.get(),idClassField.get(),m$.Fnc.$piece(pYFELD.get(),m$.var("Y").get(),idClassField.get()),"D",strRelationClass.get(),strRelationKeys.get(),strFilter.get());
          }
          //<< }
          //<< 
          //<< if pYFELD'=YFELDSAVED {
          if (mOp.NotEqual(pYFELD.get(),YFELDSAVED.get())) {
            //<< do PopulateDataField^COMUtils(pYFORM,idClassField,$piece(pYFELD,Y,idClassField),,,$$$YES) ;BR014624
            m$.Cmd.Do("COMUtils.PopulateDataField",pYFORM.get(),idClassField.get(),m$.Fnc.$piece(pYFELD.get(),m$.var("Y").get(),idClassField.get()),null,null,include.COMSYS.$$$YES(m$));
          }
          //<< }
          //<< do UpdateFieldFormat^COMUtils("Y"_pYFORM_"D"_idClassField_".style","backgroundColor",strNewFieldColor)
          m$.Cmd.Do("COMUtils.UpdateFieldFormat",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",pYFORM.get()),"D"),idClassField.get()),".style"),"backgroundColor",strNewFieldColor.get());
          //<< do UpdateFieldFormat^COMUtils("Y"_pYFORM_"D"_idClassField,"readOnly",strReadOnly)
          m$.Cmd.Do("COMUtils.UpdateFieldFormat",mOp.Concat(mOp.Concat(mOp.Concat("Y",pYFORM.get()),"D"),idClassField.get()),"readOnly",strReadOnly.get());
          //<< 
          //<< do HideControl^COMUtils(pYFORM,idClassField,idField,blnHidden,"D") ;SR17784 ;SR18016
          m$.Cmd.Do("COMUtils.HideControl",pYFORM.get(),idClassField.get(),idField.get(),blnHidden.get(),"D");
          //<< 
          //<< do UpdateFieldFormatButton("CalendarButtonD"_idClassField,blnReadOnly,"date.gif")
          m$.Cmd.Do("UpdateFieldFormatButton",mOp.Concat("CalendarButtonD",idClassField.get()),blnReadOnly.get(),"date.gif");
          //<< do UpdateFieldFormatButton("BUTTON_SEARCH"_idClassField,blnReadOnly,"search1.gif")
          m$.Cmd.Do("UpdateFieldFormatButton",mOp.Concat("BUTTON_SEARCH",idClassField.get()),blnReadOnly.get(),"search1.gif");
          //<< do SetState^WWWFORM7FATSearch(pYFORM,"D",idClassField,blnReadOnly,blnMandatory)   ;SR17725
          m$.Cmd.Do("WWWFORM7FATSearch.SetState",pYFORM.get(),"D",idClassField.get(),blnReadOnly.get(),blnMandatory.get());
          //<< ;   do UpdateFieldFormatButton("Y"_pYFORM_"D"_idClassField_"MEMOLINK",blnReadOnly,"text.gif")
          //<< ; loop through buttons that are attached to fields.
          //<< set objWWW122 = $get(^WWW122(0,pYFORM,idField,1))
          objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,pYFORM.get(),idField.get(),1)));
          //<< if objWWW122'="" {
          if (mOp.NotEqual(objWWW122.get(),"")) {
            //<< set lstButtons = $$$WWW122ButtonBehindInputField(objWWW122)
            lstButtons.set(include.WWWConst.$$$WWW122ButtonBehindInputField(m$,objWWW122));
            //<< for loop=1:1:$length(lstButtons,";") {
            for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(lstButtons.get(),";")));loop.set(mOp.Add(loop.get(),1))) {
              //<< set idButton = $piece(lstButtons,";",loop)
              idButton.set(m$.Fnc.$piece(lstButtons.get(),";",loop.get()));
              //<< if idButton'="" {
              if (mOp.NotEqual(idButton.get(),"")) {
                //<< set strImage = $$GetButtonImage^WWW124(pYFORM,SPRACHE,idButton,blnReadOnly)
                strImage.set(m$.fnc$("WWW124.GetButtonImage",pYFORM.get(),m$.var("SPRACHE").get(),idButton.get(),blnReadOnly.get()));
                //<< do UpdateFieldFormatButton("Y"_pYFORM_"D"_idClassField_"_"_idButton,blnReadOnly,strImage,$$$YES)
                m$.Cmd.Do("UpdateFieldFormatButton",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",pYFORM.get()),"D"),idClassField.get()),"_"),idButton.get()),blnReadOnly.get(),strImage.get(),include.COMSYS.$$$YES(m$));
              }
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
    //<< }
    //<< quit ""
    return "";
  }

  //<< 
  //<< 
  //<< UpdateFieldFormatButton(pidField,pblnReadOnly,pstrImage,pblnImageAlreadyCalcd=$$$NO)
  public Object UpdateFieldFormatButton(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnReadOnly = m$.newVarRef("pblnReadOnly",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrImage = m$.newVarRef("pstrImage",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnImageAlreadyCalcd = m$.newVarRef("pblnImageAlreadyCalcd",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Code to update the state of a button
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Jan-2010   shobby  SR17131: translate YGIF
    //<< ; 05-Jul-2007   shobby  SRBR014490: Better management of the readonly flag.
    //<< ; 26-Jun-2007   shobby  SRBR014490: Use standard routine to get disabled name of
    //<< ;                           an image when there is a known counterpart.
    //<< ; 25-Jun-2007   shobby  SRBR014409: If image has not already been determined in
    //<< ;                           $$GetButtonImage then display disabled equivalent.
    //<< ; 07-Jun-2007   shobby  SRBR014409: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if ('pblnImageAlreadyCalcd) {
    if ((mOp.Not(pblnImageAlreadyCalcd.get()))) {
      //<< set pstrImage = $$Name^WWWIMAGE(pstrImage,pblnReadOnly)
      pstrImage.set(m$.fnc$("WWWIMAGE.Name",pstrImage.get(),pblnReadOnly.get()));
    }
    //<< }
    //<< ;do UpdateFieldFormat^COMUtils(pidField_".style","disabled",pblnReadOnly)
    //<< do UpdateFieldFormat^COMUtils(pidField,"readOnly",$select(pblnReadOnly:$$$JStrue,1:$$$JSfalse))
    m$.Cmd.Do("COMUtils.UpdateFieldFormat",pidField.get(),"readOnly",m$.Fnc.$select(pblnReadOnly.get(),include.COMSYSJS.$$$JStrue(m$),1,include.COMSYSJS.$$$JSfalse(m$)));
    //<< do UpdateFieldFormat^COMUtils(pidField_"IMG","src",$translate(YGIF,"\","/")_pstrImage)           ;SR17131
    m$.Cmd.Do("COMUtils.UpdateFieldFormat",mOp.Concat(pidField.get(),"IMG"),"src",mOp.Concat(m$.Fnc.$translate(m$.var("YGIF").get(),"\\","/"),pstrImage.get()));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBlur(pstrExecOnBlur,&YINHALT,pstrField)
  public Object OnBlur(Object ... _p) {
    mVar pstrExecOnBlur = m$.newVarRef("pstrExecOnBlur",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Execute on blur code of a field
    //<< ; NOTE: YINHALT is the DISPLAY value
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-May-2010   GRF     SR15961: use dteToday for efficiency
    //<< ; 13-Jan-2009   shobby  SR15753: Update YFELD if any fields have been changed.
    //<< ; 27-Mar-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new dteToday,loop
    mVar dteToday = m$.var("dteToday");
    mVar loop = m$.var("loop");
    m$.newVar(dteToday,loop);
    //<< new YXTEXT,YFELD,YMFELD,YKEY,YFELDBEFORE,YFELDSAVED
    mVar YXTEXT = m$.var("YXTEXT");
    mVar YFELD = m$.var("YFELD");
    mVar YMFELD = m$.var("YMFELD");
    mVar YKEY = m$.var("YKEY");
    mVar YFELDBEFORE = m$.var("YFELDBEFORE");
    mVar YFELDSAVED = m$.var("YFELDSAVED");
    m$.newVar(YXTEXT,YFELD,YMFELD,YKEY,YFELDBEFORE,YFELDSAVED);
    //<< 
    //<< set dteToday   = +$horolog     ; SR15961
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< set YKEY       = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"P",1))
    YKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1)));
    //<< set YFELD      = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"D",1))   ;DATENSATZ AKTUELL         ; modified class data record
    YFELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1)));
    //<< set YMFELD     = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"M",1))   ;DATENSATZ MANUELL AKTUELL ; manual fields data record
    YMFELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"M",1)));
    //<< set YFELDSAVED = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"D",2))   ;DATENSATZ GESPEICHERT     ; original class data record
    YFELDSAVED.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",2)));
    //<< 
    //<< $$$LogR2("OnBlur",pstrExecOnBlur_"<"_$get(YINHALT)_"<"_$get(pstrField)_"<")
    $$$LogR2(m$,"OnBlur",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrExecOnBlur.get(),"<"),m$.Fnc.$get(YINHALT)),"<"),m$.Fnc.$get(pstrField)),"<"));
    //<< $$$LogR2x("OB:1:"_YKEY_"<"_YMFELD_"<")
    $$$LogR2x(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("OB:1:",YKEY.get()),"<"),YMFELD.get()),"<"));
    //<< $$$LogR2x("OB:2:"_YFELD_"<")
    $$$LogR2x(m$,mOp.Concat(mOp.Concat("OB:2:",YFELD.get()),"<"));
    //<< $$$LogR2x("OB:3:"_YFELDSAVED_"<")
    $$$LogR2x(m$,mOp.Concat(mOp.Concat("OB:3:",YFELDSAVED.get()),"<"));
    //<< 
    //<< set YFELDBEFORE = YFELD
    YFELDBEFORE.set(YFELD.get());
    //<< xecute pstrExecOnBlur                                              ; ***** EXECUTE *****
    m$.Cmd.Xecute(pstrExecOnBlur.get());
    //<< 
    //<< for loop=1:1:$length(YFELD) {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(YFELD.get())));loop.set(mOp.Add(loop.get(),1))) {
      //<< if $piece(YFELD,Y,loop)'=$piece(YFELDBEFORE,Y,loop) {
      if (mOp.NotEqual(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),loop.get()),m$.Fnc.$piece(YFELDBEFORE.get(),m$.var("Y").get(),loop.get()))) {
        //<< do PopulateDataField^COMUtils(YFORM,loop,$piece(YFELD,Y,loop))
        m$.Cmd.Do("COMUtils.PopulateDataField",m$.var("YFORM").get(),loop.get(),m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),loop.get()));
        //<< if loop=YLFN set YINHALT = $piece(YFELD,Y,loop)
        if (mOp.Equal(loop.get(),m$.var("YLFN").get())) {
          YINHALT.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),loop.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"D",1)=YFELD
    m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1).set(YFELD.get());
    //<< 
    //<< ;WENN DATUM UND PRÜFUNG UND ERGEBNISS, DANN WAR DATUMSUMSETZTUNG FALSCH, ZEILE SOLL DIES BEHEBEN: TYBD; 18,08,2003
    //<< if %TXT(1)'="" if YTYP=1 if $extract(%TXT(1))=$$$Perform if YART="D" if $piece(YFELD,Y,YLFN)'="" if '$find(%TXT(1),$$$Perform_pstrField_"~") set %TXT(1)=%TXT(1)_$$$Perform_pstrField_"~"_$$^WWWDATE($piece(YFELD,Y,YLFN))  ;'$F EINGESETZT ;TYBD;30,4,2004
    if (mOp.NotEqual(m$.var("%TXT",1).get(),"")) {
      if (mOp.Equal(m$.var("YTYP").get(),1)) {
        if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$Perform(m$))) {
          if (mOp.Equal(m$.var("YART").get(),"D")) {
            if (mOp.NotEqual(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.var("YLFN").get()),"")) {
              if (mOp.Not(m$.Fnc.$find(m$.var("%TXT",1).get(),mOp.Concat(mOp.Concat(include.COMSYS.$$$Perform(m$),pstrField.get()),"~")))) {
                m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),include.COMSYS.$$$Perform(m$)),pstrField.get()),"~"),m$.fnc$("WWWDATE.main",m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.var("YLFN").get()))));
              }
            }
          }
        }
      }
    }
    //<< 
    //<< if $extract(%TXT(1))=$$$Perform do DATEN
    if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$Perform(m$))) {
      m$.Cmd.Do("DATEN");
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AdjustCurrencyAmount(&pstrYINHALT,pstrYDECIMAL="")
  public Object AdjustCurrencyAmount(Object ... _p) {
    mVar pstrYINHALT = m$.newVarRef("pstrYINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrYDECIMAL = m$.newVarRef("pstrYDECIMAL",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Simple Currency            : "12.34"  or  "22.35"
    //<< ;   Foreign Currency Structure : "12.34@USD22.35@.562"
    //<< ;                                 BBBBB CCCFFFFF RRRR
    //<< ;                        BaseAmt  Currency  ForeignAmt  Rate
    //<< ;
    //<< ;   Alternative  "USD22.35@1.779"
    //<< ;        - Determine the base value from a foreign currency and rate.
    //<< ;
    //<< ; ***********************
    //<< ; Much of this code involves returning the value as a locale-based literal format
    //<< ; (sometimes as 2 pieces CCCFFFF@RRRR) so that the subsequent call to WWWTR can
    //<< ; convert it back to an internal value (calculating the Base Amt if necessary)
    //<< ; and then reconvert THAT to the final displayed value.
    //<< ; ***********************
    //<< ;
    //<< ; ByRef :
    //<< ;   pstrYINHALT     Value (Initial and return) : literal appearance with *LOCALE*
    //<< ;                   settings for thousands-decimal.
    //<< ;   pstrYDECIMAL    Character used as the decimal point (dot or comma)
    //<< ;
    //<< ; (implicit)
    //<< ;   YOLDV           WWWDATEN value  -  always in Internal format
    //<< ;                       Old Value = Base@CURForeign@Rate
    //<< ;                           or    = Base      (where Foreign Currency doesn't apply)
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 05-Jan-2010   GRF     SR15525: Activate AdjustCurrencyAmount
    //<< ; 28-May-2007   GRF     SR15525: major re-write due to numerous errors
    //<< ; 16-Mar-2007   GRF     SR12505: naked references
    //<< ; 03-Mar-2006   JW      SR14226: Moved check for "X@Y" outside check for form
    //<< ;                           type. Need for both.
    //<< ; 15-Nov-2005   JW      SR13865: Compare internal base values, not display values
    //<< ; 28-Oct-2005   JW      SR13074: Translate exchange rate if entered.
    //<< ; 16-Jun-2005   PO      SR12626: Made coins buttons on currency fields work again,
    //<< ;                           save would not save
    //<< ; 09-Jun-2005   PO      Created SR11349
    //<< ;-------------------------------------------------------------------------------
    //<< new fltBaseAmt,fltFCAmt,fltRate,fltYINHALT,intDecimalPlaces,strAmt,strFCCode
    mVar fltBaseAmt = m$.var("fltBaseAmt");
    mVar fltFCAmt = m$.var("fltFCAmt");
    mVar fltRate = m$.var("fltRate");
    mVar fltYINHALT = m$.var("fltYINHALT");
    mVar intDecimalPlaces = m$.var("intDecimalPlaces");
    mVar strAmt = m$.var("strAmt");
    mVar strFCCode = m$.var("strFCCode");
    m$.newVar(fltBaseAmt,fltFCAmt,fltRate,fltYINHALT,intDecimalPlaces,strAmt,strFCCode);
    //<< 
    //<< set:pstrYDECIMAL="" pstrYDECIMAL = $extract($$GetNumberDelimiters^COMUtilLocale(SPRACHE),2)
    if (mOp.Equal(pstrYDECIMAL.get(),"")) {
      pstrYDECIMAL.set(m$.Fnc.$extract(m$.fnc$("COMUtilLocale.GetNumberDelimiters",m$.var("SPRACHE").get()),2));
    }
    //<< 
    //<< if $length(pstrYINHALT,"@")=2 {
    if (mOp.Equal(m$.Fnc.$length(pstrYINHALT.get(),"@"),2)) {
      //<< ;-----------------------------------
      //<< ; Take a foreign currency and external exchange rate;
      //<< ; invert the exchange rate before returning to the
      //<< ; calling routine which adds calculated base value.
      //<< ;-----------------------------------
      //<< ;        *LOCALE*              English (,.)        European (.,)
      //<< ;        input                "USD20.50@1.25"     "USD20,50@1,25"
      //<< ;        returned as          "USD20.5@.8"        "USD20,5@,8"
      //<< ; $$GetInternal^WWWTR(8,...)  <--      "16.4@USD20.5@.8"      -->
      //<< ; $$GetLiteral^WWWTR(8,...)      "16.40"             "16,40"
      //<< ;-----------------------------------
      //<< set fltRate = $$$InternalForEx($piece(pstrYINHALT,"@",2))
      fltRate.set($$$InternalForEx(m$,m$.Fnc.$piece(pstrYINHALT.get(),"@",2)));
      //<< set:pstrYDECIMAL="," fltRate = $translate(fltRate,".",",")
      if (mOp.Equal(pstrYDECIMAL.get(),",")) {
        fltRate.set(m$.Fnc.$translate(fltRate.get(),".",","));
      }
      //<< set $piece(pstrYINHALT,"@",2) = fltRate
      m$.pieceVar(pstrYINHALT,"@",2).set(fltRate.get());
    }
    //<< 
    //<< } else {
    else {
      //<< if $get(^CacheTemp(YUSER,YFORM,"Toggles","Currency"))'="Foreign" {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Toggles","Currency")),"Foreign")) {
        //<< ;-----------------------------------
        //<< ; *** VIEWING THE BASE CURRENCY ***
        //<< ; includes forms where foreign currency is not applicable.
        //<< ;
        //<< ; Where showing a foreign currency amount and the base value hasn't changed;
        //<< ;    strip down to the original "CURForeign@Rate" and convert to *LOCALE* format
        //<< ;    (only decimal point changed - no thousands delimiter used)
        //<< ;-----------------------------------
        //<< if $find(YOLDV,"@") && (+$piece(YOLDV,"@",1)=+$$$InternalCurrency(pstrYINHALT)) {
        if (mOp.Logical(m$.Fnc.$find(m$.var("YOLDV").get(),"@")) && (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YOLDV").get(),"@",1)),mOp.Positive($$$InternalCurrency(m$,pstrYINHALT))))) {
          //<< set pstrYINHALT = $piece(YOLDV,"@",2,99)
          pstrYINHALT.set(m$.Fnc.$piece(m$.var("YOLDV").get(),"@",2,99));
          //<< set:pstrYDECIMAL="," pstrYINHALT = $translate(pstrYINHALT,".",",")
          if (mOp.Equal(pstrYDECIMAL.get(),",")) {
            pstrYINHALT.set(m$.Fnc.$translate(pstrYINHALT.get(),".",","));
          }
        }
      }
      //<< }
      //<< 
      //<< } else {
      else {
        //<< ;-----------------------------------
        //<< ; *** VIEWING THE FOREIGN CURRENCY ***     ;(...,"Toggles","Currency"))="Foreign"
        //<< ;
        //<< ; 1.  Zero is Zero                  - No Further Action
        //<< ; 2.  Old Value without FC (new entry?)
        //<< ;     a.  New Value with FC         - use new value as is
        //<< ;     b.  New Value without FC      - new value is FCAmt; get FCCode and Rate from master; calc BaseAmt
        //<< ; 3.  Old Value has FC
        //<< ;     a.  New Value with FC         - 3 pieces;   get Rate from new value
        //<< ;     b.  New Value without FC      - FCAmt only; get Rate from old value
        //<< ;     Then
        //<< ;         Return old FCCode @ new FCAmt @ Rate
        //<< ;-----------------------------------
        //<< quit:+pstrYINHALT=0
        if (mOp.Equal(mOp.Positive(pstrYINHALT.get()),0)) {
          return null;
        }
        //<< 
        //<< if (YOLDV'["@") {
        if ((mOp.NotContains(m$.var("YOLDV").get(),"@"))) {
          //<< if (pstrYINHALT'["@") {
          if ((mOp.NotContains(pstrYINHALT.get(),"@"))) {
            //<< ;-----------------------------------
            //<< ; Case 2b
            //<< ;-----------------------------------
            //<< set strFCCode   = $get(^CacheTemp(YUSER,YFORM,"Display Currency"))
            strFCCode.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Display Currency")));
            //<< set fltRate     = $get(^CacheTemp(YUSER,YFORM,"Exchange Rate"))
            fltRate.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Exchange Rate")));
            //<< if +fltRate=0 set fltRate = $$FindConversionRate^WWWZAHL(strFCCode,$horolog)
            if (mOp.Equal(mOp.Positive(fltRate.get()),0)) {
              fltRate.set(m$.fnc$("WWWZAHL.FindConversionRate",strFCCode.get(),m$.Fnc.$horolog()));
            }
            //<< if strFCCode'="" set intDecimalPlaces = $$$WWWWAEDecimalPoints($get(^WWWWAE(0,strFCCode,1)))
            if (mOp.NotEqual(strFCCode.get(),"")) {
              intDecimalPlaces.set(include.WWWConst.$$$WWWWAEDecimalPoints(m$,m$.Fnc.$get(m$.var("^WWWWAE",0,strFCCode.get(),1))));
            }
            //<< if $get(intDecimalPlaces)="" set intDecimalPlaces = 2     ; must explicitly set to zero
            if (mOp.Equal(m$.Fnc.$get(intDecimalPlaces),"")) {
              intDecimalPlaces.set(2);
            }
            //<< set fltFCAmt     = $$$InternalCurrency(pstrYINHALT)
            fltFCAmt.set($$$InternalCurrency(m$,pstrYINHALT));
            //<< set fltBaseAmt   = +$justify(fltFCAmt * fltRate,0,intDecimalPlaces)
            fltBaseAmt.set(mOp.Positive(m$.Fnc.$justify(mOp.Multiply(fltFCAmt.get(),fltRate.get()),0,intDecimalPlaces.get())));
            //<< set pstrYINHALT  = fltBaseAmt_"@"_strFCCode_fltFCAmt_"@"_fltRate
            pstrYINHALT.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(fltBaseAmt.get(),"@"),strFCCode.get()),fltFCAmt.get()),"@"),fltRate.get()));
            //<< set:pstrYDECIMAL="," pstrYINHALT = $translate(pstrYINHALT,".",",")
            if (mOp.Equal(pstrYDECIMAL.get(),",")) {
              pstrYINHALT.set(m$.Fnc.$translate(pstrYINHALT.get(),".",","));
            }
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< ;-----------------------------------
          //<< ; Case 3a/b - remove *LOCALE* format first
          //<< ;  "16.4@USD20.5@.8"  or  "20.5"
          //<< ;-----------------------------------
          //<< set:pstrYDECIMAL="," pstrYINHALT = $translate(pstrYINHALT,",.",".")
          if (mOp.Equal(pstrYDECIMAL.get(),",")) {
            pstrYINHALT.set(m$.Fnc.$translate(pstrYINHALT.get(),",.","."));
          }
          //<< 
          //<< if pstrYINHALT["@" {    ; 3a
          if (mOp.Contains(pstrYINHALT.get(),"@")) {
            //<< set fltFCAmt = +$$FCAmount^WWWTR(pstrYINHALT)
            fltFCAmt.set(mOp.Positive(m$.fnc$("WWWTR.FCAmount",pstrYINHALT.get())));
            //<< set fltRate  = $piece(pstrYINHALT,"@",3)
            fltRate.set(m$.Fnc.$piece(pstrYINHALT.get(),"@",3));
          }
          //<< 
          //<< } else {                ; 3b
          else {
            //<< set fltFCAmt = +pstrYINHALT
            fltFCAmt.set(mOp.Positive(pstrYINHALT.get()));
            //<< set fltRate = $piece(YOLDV,"@",3)       ; "16.4@USD20.5@.8"
            fltRate.set(m$.Fnc.$piece(m$.var("YOLDV").get(),"@",3));
          }
          //<< }
          //<< 
          //<< set pstrYINHALT = $$Cur^WWWTR(YOLDV)_fltFCAmt_"@"_fltRate
          pstrYINHALT.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWTR.Cur",m$.var("YOLDV").get()),fltFCAmt.get()),"@"),fltRate.get()));
          //<< set:pstrYDECIMAL="," pstrYINHALT = $translate(pstrYINHALT,".",",")
          if (mOp.Equal(pstrYDECIMAL.get(),",")) {
            pstrYINHALT.set(m$.Fnc.$translate(pstrYINHALT.get(),".",","));
          }
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
  //<< PARAMETER(YSATZ,YDVOR)
  public Object PARAMETER(Object ... _p) {
    mVar YSATZ = m$.newVarRef("YSATZ",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDVOR = m$.newVarRef("YDVOR",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Inputs:
    //<< ;   YSATZ           objWWW122   Form Data Field
    //<< ;   YDVOR           objWWW003   Class Data Field
    //<< ;   objCustFld      objWWW122D  Customisation Data Field   ****BR014619 no longer necessary
    //<< ;
    //<< ; History:
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 29-Jun-2009   PPP     SR16663: Add the Calculated Relation Display Fields
    //<< ; 10-Oct-2007   GRF     SR15563: Macro change
    //<< ; 18-Sep-2007   shobby  SRBR014619: Customisations are considered when YSATZ is
    //<< ;                           obtained in GetDetails so 3rd parameter objCustFld
    //<< ;                           is no longer necessary.
    //<< ; 23-Jan-2007   JW      SR15384: Encapsulated functionality. Rewrote to append to %TXT(1)
    //<< ; 16-Mar-2007   GRF     SR12505: naked references
    //<< ; 12-Oct-2006   JW      SR15115: Check customisation for relational display options
    //<< ; 27-Jan-2006   PO      SR14130: Unescape data when it is stored in the database
    //<< ; 15-Dec-2005   PO      SR13792: When blurring out of a relation field, use EscapeHyperEventData
    //<< ; 22-Jul-2005   JW      SR12615: Added macros. Removed "test relation on edit"
    //<< ; 19.05.2003    TYBD
    //<< ;-------------------------------------------------------------------------------
    //<< ;SET $ZTRAP="ERROR1^WWWEVENT"
    //<< new idField,idRelClass,idSendFld,intDisplay,intField,intType
    mVar idField = m$.var("idField");
    mVar idRelClass = m$.var("idRelClass");
    mVar idSendFld = m$.var("idSendFld");
    mVar intDisplay = m$.var("intDisplay");
    mVar intField = m$.var("intField");
    mVar intType = m$.var("intType");
    m$.newVar(idField,idRelClass,idSendFld,intDisplay,intField,intType);
    //<< new strCalcRelFields,strField,strGlobal,strMsg,strRelFields,strRelKeys,strTmp,strValue
    mVar strCalcRelFields = m$.var("strCalcRelFields");
    mVar strField = m$.var("strField");
    mVar strGlobal = m$.var("strGlobal");
    mVar strMsg = m$.var("strMsg");
    mVar strRelFields = m$.var("strRelFields");
    mVar strRelKeys = m$.var("strRelKeys");
    mVar strTmp = m$.var("strTmp");
    mVar strValue = m$.var("strValue");
    m$.newVar(strCalcRelFields,strField,strGlobal,strMsg,strRelFields,strRelKeys,strTmp,strValue);
    //<< new YDATA,YSORT,YI
    mVar YDATA = m$.var("YDATA");
    mVar YSORT = m$.var("YSORT");
    mVar YI = m$.var("YI");
    m$.newVar(YDATA,YSORT,YI);
    //<< 
    //<< set strMsg     = ""
    strMsg.set("");
    //<< set strValue   = ""
    strValue.set("");
    //<< set intDisplay = ""
    intDisplay.set("");
    //<< 
    //<< set strRelFields = $$$WWW122RelationFieldSequence(YSATZ)
    strRelFields.set(include.WWWConst.$$$WWW122RelationFieldSequence(m$,YSATZ));
    //<< set strCalcRelFields = ""   //SR16663
    strCalcRelFields.set("");
    //<< 
    //<< set idRelClass = $$$WWW122RelationClass(YSATZ)
    idRelClass.set(include.WWWConst.$$$WWW122RelationClass(m$,YSATZ));
    //<< 
    //<< if idRelClass'="" {
    if (mOp.NotEqual(idRelClass.get(),"")) {
      //<< set strRelKeys = $$$WWW122RelationalPrimaryKey(YSATZ)  ;KEY F. RELATION
      strRelKeys.set(include.WWWConst.$$$WWW122RelationalPrimaryKey(m$,YSATZ));
      //<< set:strRelFields="" strRelFields = $$$WWW122RelationalDataField(YSATZ)
      if (mOp.Equal(strRelFields.get(),"")) {
        strRelFields.set(include.WWWConst.$$$WWW122RelationalDataField(m$,YSATZ));
      }
      //<< set intDisplay       = $$$WWW122RelationDisplayOptions(YSATZ)  ;always set display
      intDisplay.set(include.WWWConst.$$$WWW122RelationDisplayOptions(m$,YSATZ));
      //<< set strCalcRelFields = $$$WWW122CalcRelationalDataField(YSATZ)
      strCalcRelFields.set(include.WWWConst.$$$WWW122CalcRelationalDataField(m$,YSATZ));
    }
    //<< 
    //<< } elseif YDVOR'="" {
    else if (mOp.NotEqual(YDVOR.get(),"")) {
      //<< set idRelClass = $$$WWW003RelationDatabase(YDVOR)
      idRelClass.set(include.WWWConst.$$$WWW003RelationDatabase(m$,YDVOR));
      //<< set strRelKeys = $$$WWW003RelationalPrimaryKeys(YDVOR)
      strRelKeys.set(include.WWWConst.$$$WWW003RelationalPrimaryKeys(m$,YDVOR));
      //<< if strRelFields=""     set strRelFields     = $$$WWW003RelationalDisplayItems(YDVOR)
      if (mOp.Equal(strRelFields.get(),"")) {
        strRelFields.set(include.WWWConst.$$$WWW003RelationalDisplayItems(m$,YDVOR));
      }
      //<< if strCalcRelFields="" set strCalcRelFields = $$$WWW003CalcRelationalDisplayItems(YDVOR)
      if (mOp.Equal(strCalcRelFields.get(),"")) {
        strCalcRelFields.set(include.WWWConst.$$$WWW003CalcRelationalDisplayItems(m$,YDVOR));
      }
      //<< if intDisplay=""       set intDisplay       = $$$WWW003RelationDisplayOptions(YDVOR)   ;ERST SPÄTER ANZEIGEN ;only subsequent display
      if (mOp.Equal(intDisplay.get(),"")) {
        intDisplay.set(include.WWWConst.$$$WWW003RelationDisplayOptions(m$,YDVOR));
      }
    }
    //<< }
    //<< if (strRelFields="") && (strCalcRelFields="") set strRelFields = 1
    if ((mOp.Equal(strRelFields.get(),"")) && (mOp.Equal(strCalcRelFields.get(),""))) {
      strRelFields.set(1);
    }
    //<< 
    //<< set idSendFld = $$$WWW122RelationSendToField(YSATZ)
    idSendFld.set(include.WWWConst.$$$WWW122RelationSendToField(m$,YSATZ));
    //<< 
    //<< if idRelClass="" && (idSendFld'="") {
    if (mOp.Equal(idRelClass.get(),"") && (mOp.NotEqual(idSendFld.get(),""))) {
      //<< set strField = $$GetID^WWWField(YFORM,idSendFld,.intType,.intField)     ;SR15384
      strField.set(m$.fnc$("WWWField.GetID",m$.var("YFORM").get(),idSendFld.get(),intType,intField));
      //<< set strMsg = strField_Y_YINHALT
      strMsg.set(mOp.Concat(mOp.Concat(strField.get(),m$.var("Y").get()),m$.var("YINHALT").get()));
      //<< set $piece(^WWWDATEN(0,+$horolog,YUSER,YFORM,intType,1),Y,intField)=$translate($$$UnEscapeHyperEventData(YINHALT),Y,"-") ;IN ANDERES FELD UMLENKEN ;TYBD;20.3.03 NUR WENN NICHT LEER ;within field only when Not void
      m$.pieceVar(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),intType.get(),1),m$.var("Y").get(),intField.get()).set(m$.Fnc.$translate(include.COMSYS.$$$UnEscapeHyperEventData(m$,m$.var("YINHALT")),m$.var("Y").get(),"-"));
      //<< 
      //<< $$$Append(%TXT(1),$$$Perform_strMsg)
      include.COMSYSString.$$$Append(m$,m$.var("%TXT",1),mOp.Concat(include.COMSYS.$$$Perform(m$),strMsg.get()));
    }
    //<< }
    //<< 
    //<< ;--------------------------------------- *** EARLY EXITS ***
    //<< quit:idRelClass=""
    if (mOp.Equal(idRelClass.get(),"")) {
      return null;
    }
    //<< quit:(idSendFld="")&&(intDisplay'=1)
    if ((mOp.Equal(idSendFld.get(),"")) && (mOp.NotEqual(intDisplay.get(),1))) {
      return null;
    }
    //<< ; search field
    //<< if YTYP=$$$FLDBoolean if %TXT(1)'=""                              if intDisplay=2  quit   ;TYBD;15.5.2003;23638;CHECKFELD MIT FUNKTION ABER KEIN PARAMETER
    if (mOp.Equal(m$.var("YTYP").get(),include.COMSYSWWW.$$$FLDBoolean(m$))) {
      if (mOp.NotEqual(m$.var("%TXT",1).get(),"")) {
        if (mOp.Equal(intDisplay.get(),2)) {
          return null;
        }
      }
    }
    //<< if %TXT(1)'="" if $find(%TXT(1),"READ")||($find(%TXT(1),"WRITE")) if +intDisplay=0 quit   ;DATEN IMMER ANZEIGEN DAHER KEINE RELATION;TYBD;8,07,2003;23886;
    if (mOp.NotEqual(m$.var("%TXT",1).get(),"")) {
      if (mOp.Logical(m$.Fnc.$find(m$.var("%TXT",1).get(),"READ")) || mOp.Logical((m$.Fnc.$find(m$.var("%TXT",1).get(),"WRITE")))) {
        if (mOp.Equal(mOp.Positive(intDisplay.get()),0)) {
          return null;
        }
      }
    }
    //<< if $find(idRelClass,"PLZ") if $get(YOLDV)=YINHALT                                  quit   ;GLEICHE plz ;same
    if (mOp.Logical(m$.Fnc.$find(idRelClass.get(),"PLZ"))) {
      if (mOp.Equal(m$.Fnc.$get(m$.var("YOLDV")),m$.var("YINHALT").get())) {
        return null;
      }
    }
    //<< ;---------------------------------------
    //<< 
    //<< if YTYP'=$$$FLDMemo set strValue=" "
    if (mOp.NotEqual(m$.var("YTYP").get(),include.COMSYSWWW.$$$FLDMemo(m$))) {
      strValue.set(" ");
    }
    //<< set strGlobal="^"_idRelClass_"("_$$^WWWYM(idRelClass,1)  ;Key assembling
    strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat("^",idRelClass.get()),"("),m$.fnc$("WWWYM.main",idRelClass.get(),1)));
    do {
      //<< 
      //<< do
      //<< . set YDATA=$get(^WWW001(0,idRelClass,1))
      YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,idRelClass.get(),1)));
      //<< . if $piece(YDATA,Y,12)'="" if $piece(YDATA,Y,13)'="" do  ;UCI UND VOL ;UCI And
      if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
          do {
            //<< . . quit:$find(strGlobal,"^[")
            if (mOp.Logical(m$.Fnc.$find(strGlobal.get(),"^["))) {
              break;
            }
            //<< . . set strGlobal="^["""_$piece(YDATA,Y,12)_""","""_$piece(YDATA,Y,13)_"""]"_$piece(strGlobal,"^",2,999)
            strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[\"",m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\",\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\"]"),m$.Fnc.$piece(strGlobal.get(),"^",2,999)));
          } while (false);
        }
      }
    } while(false);
    //<< 
    //<< set Q=0
    mVar Q = m$.var("Q");
    Q.set(0);
    //<< if idRelClass'="" set YDATA=$get(^WWW001(0,idRelClass,1))
    if (mOp.NotEqual(idRelClass.get(),"")) {
      YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,idRelClass.get(),1)));
    }
    //<< for YI=1:1 set YPARA(9)=$piece(strRelKeys,",",YI) quit:YPARA(9)=""  set strGlobal=strGlobal_YPARA(9)_"," if $extract(YPARA(9))'="""" if $get(@(YPARA(9)))="" set Q=1 quit   ;WEITERE SCHLÜSSEL ;wrench
    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
      mVar YPARA = m$.var("YPARA");
      YPARA.var(9).set(m$.Fnc.$piece(strRelKeys.get(),",",YI.get()));
      if (mOp.Equal(YPARA.var(9).get(),"")) {
        break;
      }
      strGlobal.set(mOp.Concat(mOp.Concat(strGlobal.get(),YPARA.var(9).get()),","));
      if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(9).get()),"\"")) {
        if (mOp.Equal(m$.Fnc.$get(m$.indirectVar((YPARA.var(9).get()))),"")) {
          Q.set(1);
          break;
        }
      }
    }
    //<< 
    //<< if Q=1 set Q=0 quit                     ;  *** EARLY EXIT ***
    if (mOp.Equal(Q.get(),1)) {
      Q.set(0);
      return null;
    }
    //<< 
    //<< if $piece(YDATA,Y,8)'=4 set YPARA(6)=strGlobal_""""_$extract($translate(YINHALT,$char(13,10)_"""| "),1,100)_""",1)"
    if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
      mVar YPARA = m$.var("YPARA");
      YPARA.var(6).set(mOp.Concat(mOp.Concat(mOp.Concat(strGlobal.get(),"\""),m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YINHALT").get(),mOp.Concat(m$.Fnc.$char(13,10),"\"| ")),1,100)),"\",1)"));
    }
    //<< if $piece(YDATA,Y,8)=4  set YPARA(6)=strGlobal_""""_$extract($translate(YINHALT,$char(13,10)_"""| "),1,100)_""")"    ;ALTERNATIVE ;option
    if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
      mVar YPARA = m$.var("YPARA");
      YPARA.var(6).set(mOp.Concat(mOp.Concat(mOp.Concat(strGlobal.get(),"\""),m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YINHALT").get(),mOp.Concat(m$.Fnc.$char(13,10),"\"| ")),1,100)),"\")"));
    }
    //<< set YSORT=$translate($$^WWWSETL(YPARA(6)),"|",$char(13))
    YSORT.set(m$.Fnc.$translate(m$.fnc$("WWWSETL.main",m$.var("YPARA").var(6).get()),"|",m$.Fnc.$char(13)));
    //<< 
    //<< if YSORT'="" do
    if (mOp.NotEqual(YSORT.get(),"")) {
      //<< . new idFieldNum
      mVar idFieldNum = m$.var("idFieldNum");
      m$.newVarBlock(1,idFieldNum);
      //<< . set strValue=""
      strValue.set("");
      //<< . ;
      //<< . ; Calculated Fields
      //<< . if $data(strCalcRelFields)    do
      if (mOp.Logical(m$.Fnc.$data(strCalcRelFields))) {
        //<< . . for YI=1:1 set YI(1)=$piece(strCalcRelFields,";",YI) quit:YI(1)=""  do
        for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
          YI.var(1).set(m$.Fnc.$piece(strCalcRelFields.get(),";",YI.get()));
          if (mOp.Equal(YI.var(1).get(),"")) {
            break;
          }
          //<< . . . set idField = $piece(strCalcRelFields,";",YI(1))
          idField.set(m$.Fnc.$piece(strCalcRelFields.get(),";",YI.var(1).get()));
          //<< . . . if idField set strValue=strValue_$$GetCalculatedValue^WWWFOR71(idRelClass,idField,strRelKeys_","_YINHALT,YSORT)
          if (mOp.Logical(idField.get())) {
            strValue.set(mOp.Concat(strValue.get(),m$.fnc$("WWWFOR71.GetCalculatedValue",idRelClass.get(),idField.get(),mOp.Concat(mOp.Concat(strRelKeys.get(),","),m$.var("YINHALT").get()),YSORT.get())));
          }
        }
      }
      //<< . ;
      //<< . for YI=1:1 set YI(1)=$piece(strRelFields,";",YI) quit:YI(1)=""  do
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        YI.var(1).set(m$.Fnc.$piece(strRelFields.get(),";",YI.get()));
        if (mOp.Equal(YI.var(1).get(),"")) {
          break;
        }
        //<< . . if YI'=1 if strValue'="" set strValue=strValue_","
        if (mOp.NotEqual(YI.get(),1)) {
          if (mOp.NotEqual(strValue.get(),"")) {
            strValue.set(mOp.Concat(strValue.get(),","));
          }
        }
        //<< . . set idFieldNum = +$piece(strRelFields,";",YI)
        idFieldNum.set(mOp.Positive(m$.Fnc.$piece(strRelFields.get(),";",YI.get())));
        //<< . . if $piece(YSORT,Y,idFieldNum)'="" if $data(^WWW003(0,idRelClass,idFieldNum,1)) do
        if (mOp.NotEqual(m$.Fnc.$piece(YSORT.get(),m$.var("Y").get(),idFieldNum.get()),"")) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW003",0,idRelClass.get(),idFieldNum.get(),1)))) {
            //<< . . . new YART
            mVar YART = m$.var("YART");
            m$.newVarBlock(3,YART);
            //<< . . . set YART=$piece($get(^WWW003(0,idRelClass,idFieldNum,1)),Y,3)
            YART.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,idRelClass.get(),idFieldNum.get(),1)),m$.var("Y").get(),3));
            //<< . . . if YART'="" if YART'=6 set $piece(YSORT,Y,idFieldNum)=$$GetLiteral^WWWTR(YART,$piece(YSORT,Y,idFieldNum))  ;FEHLER IN ANZEIGE DER RELATION
            if (mOp.NotEqual(YART.get(),"")) {
              if (mOp.NotEqual(YART.get(),6)) {
                m$.pieceVar(YSORT,m$.var("Y").get(),idFieldNum.get()).set(m$.fnc$("WWWTR.GetLiteral",YART.get(),m$.Fnc.$piece(YSORT.get(),m$.var("Y").get(),idFieldNum.get())));
              }
            }
          }
          m$.restoreVarBlock(3);
        }
        //<< . . ;
        //<< . . set strTmp = $piece(YSORT,Y,idFieldNum)
        strTmp.set(m$.Fnc.$piece(YSORT.get(),m$.var("Y").get(),idFieldNum.get()));
        //<< . . set strValue=strValue_$$$EscapeHyperEventData(strTmp)
        strValue.set(mOp.Concat(strValue.get(),include.COMSYS.$$$EscapeHyperEventData(m$,strTmp)));
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< if idRelClass="WWW013" if $translate(strValue," ,")="" do
    if (mOp.Equal(idRelClass.get(),"WWW013")) {
      if (mOp.Equal(m$.Fnc.$translate(strValue.get()," ,"),"")) {
        //<< . if YINHALT'="" if '$data(^WWW013(0,YINHALT,1)) if $data(^WWW013s(0,3,YINHALT)) do
        if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
          if (mOp.Not(m$.Fnc.$data(m$.var("^WWW013",0,m$.var("YINHALT").get(),1)))) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW013s",0,3,m$.var("YINHALT").get())))) {
              //<< . . new YINHALT1
              mVar YINHALT1 = m$.var("YINHALT1");
              m$.newVarBlock(2,YINHALT1);
              //<< . . set YINHALT1=$order(^WWW013s(0,3,YINHALT,""))
              YINHALT1.set(m$.Fnc.$order(m$.var("^WWW013s",0,3,m$.var("YINHALT").get(),"")));
              //<< . . if YINHALT1'="" do
              if (mOp.NotEqual(YINHALT1.get(),"")) {
                //<< . . . set strValue=$piece($get(^WWW013(0,YINHALT1,1)),Y,+strRelFields)
                strValue.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",0,YINHALT1.get(),1)),m$.var("Y").get(),mOp.Positive(strRelFields.get())));
              }
            }
            m$.restoreVarBlock(2);
          }
        }
      }
    }
    //<< 
    //<< if YTYP=$$$FLDMemo if $extract($translate(strValue,$char(13,10)_"|"),1,10)=$extract($translate(YINHALT,$char(13,10)_"|"),1,10) set strValue=""
    if (mOp.Equal(m$.var("YTYP").get(),include.COMSYSWWW.$$$FLDMemo(m$))) {
      if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$translate(strValue.get(),mOp.Concat(m$.Fnc.$char(13,10),"|")),1,10),m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YINHALT").get(),mOp.Concat(m$.Fnc.$char(13,10),"|")),1,10))) {
        strValue.set("");
      }
    }
    //<< if $extract(strValue)=" " set strValue = $extract(strValue,2,999)   ;BLANK
    if (mOp.Equal(m$.Fnc.$extract(strValue.get())," ")) {
      strValue.set(m$.Fnc.$extract(strValue.get(),2,999));
    }
    //<< 
    //<< if idSendFld'="" {
    if (mOp.NotEqual(idSendFld.get(),"")) {
      //<< if (strValue'=YINHALT) && (strValue'=" ") && (strValue'="") {
      if ((mOp.NotEqual(strValue.get(),m$.var("YINHALT").get())) && (mOp.NotEqual(strValue.get()," ")) && (mOp.NotEqual(strValue.get(),""))) {
        //<< set strField = $$GetID^WWWField(YFORM,idSendFld,.intType,.intField)
        strField.set(m$.fnc$("WWWField.GetID",m$.var("YFORM").get(),idSendFld.get(),intType,intField));
        //<< set strMsg = strField_Y_strValue
        strMsg.set(mOp.Concat(mOp.Concat(strField.get(),m$.var("Y").get()),strValue.get()));
        //<< set $piece(^WWWDATEN(0,+$horolog,YUSER,YFORM,intType,1),Y,intField)=$translate(strValue,Y,"-") ;IN ANDERES FELD UMLENKEN ;NUR WENN NICHT LEER ;within field only when Not void
        m$.pieceVar(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),intType.get(),1),m$.var("Y").get(),intField.get()).set(m$.Fnc.$translate(strValue.get(),m$.var("Y").get(),"-"));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set strMsg = "DUMMY"_YART_YLFN_Y_strValue
      strMsg.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DUMMY",m$.var("YART").get()),m$.var("YLFN").get()),m$.var("Y").get()),strValue.get()));
    }
    //<< }
    //<< if strMsg'="" $$$Append(%TXT(1),$$$Perform_strMsg)
    if (mOp.NotEqual(strMsg.get(),"")) {
      include.COMSYSString.$$$Append(m$,m$.var("%TXT",1),mOp.Concat(include.COMSYS.$$$Perform(m$),strMsg.get()));
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< MSG ;
  public void MSG() {
    //<< set %TXT(1)=""
    m$.var("%TXT",1).set("");
    HELP();
  }

  //<< 
  //<< HELP
  public void HELP() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 31-Jul-2012   shobby  SR18075: Use new field for SPRACHE in initialise
    //<< ; 27-May-2011   shobby  SR16925.2: Call out to common code in WWWHELP
    //<< ; 25-May-2011   shobby  SR16925.2: IndividualHelpText->CustomHelpText
    //<< ; 18-Apr-2011   shobby  SR17705: Display a record if the last change made the
    //<< ;                           value an empty string.
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 02-Dec-2009   shobby  SR16943.3: Sometimes the 'last changes' message wouldn't show.
    //<< ; 19-Nov-2009   shobby  SR16943:  Reworked to display the F1 help text in a popup html div.
    //<< ; 18-Sep-2008   shobby  BR014966: Support language texts for customisation help text.
    //<< ; 23-Jan-2007   JW      SR15384: Encapsulated functionality. Removed redundant code.
    //<< ; 06-Nov-2006   Steve S SR14915: Unescape special characters
    //<< ; 27-Sep-2006   HEBER   SRBR014272: F1 help text for fields default to english
    //<< ;-------------------------------------------------------------------------------
    //<< new objCustFld,strField,strTempValue,strUpper
    mVar objCustFld = m$.var("objCustFld");
    mVar strField = m$.var("strField");
    mVar strTempValue = m$.var("strTempValue");
    mVar strUpper = m$.var("strUpper");
    m$.newVar(objCustFld,strField,strTempValue,strUpper);
    //<< new YBED,YDATEI,YEART,YFELD,YFKEY,YFORM,YKEY,YI,YI1,YINHALT,YLFN1,YSATZ,YUSER
    mVar YBED = m$.var("YBED");
    mVar YDATEI = m$.var("YDATEI");
    mVar YEART = m$.var("YEART");
    mVar YFELD = m$.var("YFELD");
    mVar YFKEY = m$.var("YFKEY");
    mVar YFORM = m$.var("YFORM");
    mVar YKEY = m$.var("YKEY");
    mVar YI = m$.var("YI");
    mVar YI1 = m$.var("YI1");
    mVar YINHALT = m$.var("YINHALT");
    mVar YLFN1 = m$.var("YLFN1");
    mVar YSATZ = m$.var("YSATZ");
    mVar YUSER = m$.var("YUSER");
    m$.newVar(YBED,YDATEI,YEART,YFELD,YFKEY,YFORM,YKEY,YI,YI1,YINHALT,YLFN1,YSATZ,YUSER);
    //<< 
    //<< set YKEY = ""
    YKEY.set("");
    //<< do SplitRequest(.%REQUEST,,,.YUSER,.YFORM,.strField)
    m$.Cmd.Do("SplitRequest",m$.var("%REQUEST"),null,null,YUSER,YFORM,strField);
    //<< 
    //<< do Initialise(YUSER,.%REQUEST)    ;SR18075
    m$.Cmd.Do("Initialise",YUSER.get(),m$.var("%REQUEST"));
    //<< quit:$extract(%TXT(1))=$$$AlertFollowing            ; *** EARLY QUIT - bad user
    if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$AlertFollowing(m$))) {
      return;
    }
    //<< quit:YFORM=""  ;FORMULAR NICHT VORHANDEN ;form Not on hand
    if (mOp.Equal(YFORM.get(),"")) {
      return;
    }
    //<< 
    //<< do SplitID^WWWField(strField,YFORM,.YI,.YLFN)
    m$.Cmd.Do("WWWField.SplitID",strField.get(),YFORM.get(),YI,m$.var("YLFN"));
    //<< quit:(YLFN="")||(YI="")
    if ((mOp.Equal(m$.var("YLFN").get(),"")) || (mOp.Equal(YI.get(),""))) {
      return;
    }
    //<< 
    //<< if $extract(YI)="L" set YLFN = 1,YI = "M"  ;TYBD;HILFE BEI LISTGENERATOREN ;succour next to
    if (mOp.Equal(m$.Fnc.$extract(YI.get()),"L")) {
      mVar YLFN = m$.var("YLFN");
      YLFN.set(1);
      YI.set("M");
    }
    //<< 
    //<< do GetDetails^WWWField(YFORM,YI,YLFN,.YDATEI,.YLFN1,.YVOR,,,.objCustFld,.YEART)
    m$.Cmd.Do("WWWField.GetDetails",YFORM.get(),YI.get(),m$.var("YLFN").get(),YDATEI,YLFN1,m$.var("YVOR"),null,null,objCustFld,YEART);
    //<< 
    //<< set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""","""_YI_""","""_YLFN_""","""_$$^WWWLANGU(YBED)_""",1)")
    mVar YTEXT = m$.var("YTEXT");
    YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,\"",YFORM.get()),"\",\""),YI.get()),"\",\""),m$.var("YLFN").get()),"\",\""),m$.fnc$("WWWLANGU.main",YBED.get())),"\",1)")));
    //<< 
    //<< if YTEXT=""           set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""","""_YI_""","""_YLFN_""",""EN"",1)")
    if (mOp.Equal(YTEXT.get(),"")) {
      YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,\"",YFORM.get()),"\",\""),YI.get()),"\",\""),m$.var("YLFN").get()),"\",\"EN\",1)")));
    }
    //<< if YI="M" if YTEXT="" set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""","""_YI_""",1,"""_$$^WWWLANGU(YBED)_""",1)")
    if (mOp.Equal(YI.get(),"M")) {
      if (mOp.Equal(YTEXT.get(),"")) {
        YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,\"",YFORM.get()),"\",\""),YI.get()),"\",1,\""),m$.fnc$("WWWLANGU.main",YBED.get())),"\",1)")));
      }
    }
    //<< 
    //<< if YI="P" {
    if (mOp.Equal(YI.get(),"P")) {
      //<< set YTEXT = $$GetPrimaryKeyText^WWWHELP(YTEXT,$$$NO,YLFN1)
      YTEXT.set(m$.fnc$("WWWHELP.GetPrimaryKeyText",YTEXT.get(),include.COMSYS.$$$NO(m$),YLFN1.get()));
    }
    //<< 
    //<< } elseif (YI="D") || (YI="M") {
    else if ((mOp.Equal(YI.get(),"D")) || (mOp.Equal(YI.get(),"M"))) {
      //<< set YTEXT = $$GetDataFieldText^WWWHELP(YTEXT,$$$NO,YLFN1)
      YTEXT.set(m$.fnc$("WWWHELP.GetDataFieldText",YTEXT.get(),include.COMSYS.$$$NO(m$),YLFN1.get()));
    }
    //<< 
    //<< ;SR16925.2 } else {
    //<< ;SR16925.2 set YTEXT=$piece(YTEXT,"~",1)  ;NUR DER NORMALHILFE TEXT ;only the Text
    //<< 
    //<< ;SR16925.2 if objCustFld'="" {
    //<< ;SR16925.2  if $$$WWW122DHideAlphalincHelpText(objCustFld) set YTEXT = ""  ;SR16925.2
    //<< ;SR16925.2  if YTEXT'="" set YTEXT = YTEXT_"|"
    //<< ;SR16925.2  set YTEXT = YTEXT_"|"_$$CustomHelpText^WWW122D(objCustFld) ;BR014966 ;SR16925.2
    //<< ;SR16925.2 }
    //<< 
    //<< ;SR16925.2 if YI'="M" if YTEXT="" set YTEXT = $$^WWWTEXT(28)        ; "No help text available"
    //<< }
    //<< 
    //<< if (YTEXT'="") && ($zconvert($extract(YTEXT,$length(YTEXT)-5,$length(YTEXT)),"L")'="<br />") set YTEXT = YTEXT_"<br />"  ;SR16943.3
    if ((mOp.NotEqual(YTEXT.get(),"")) && (mOp.NotEqual(m$.Fnc.$zconvert(m$.Fnc.$extract(YTEXT.get(),mOp.Subtract(m$.Fnc.$length(YTEXT.get()),5),m$.Fnc.$length(YTEXT.get())),"L"),"<br />"))) {
      YTEXT.set(mOp.Concat(YTEXT.get(),"<br />"));
    }
    do {
      //<< 
      //<< do
      //<< . set %TXT(1) = YTEXT_"<strong><small>"
      m$.var("%TXT",1).set(mOp.Concat(YTEXT.get(),"<strong><small>"));
      //<< . new YA,YKEY,YLAST,YII,blnHeader       ;SR16943.3
      mVar YA = m$.var("YA");
      mVar YLAST = m$.var("YLAST");
      mVar YII = m$.var("YII");
      mVar blnHeader = m$.var("blnHeader");
      m$.newVarBlock(1,YA,YKEY,YLAST,YII,blnHeader);
      //<< . quit:YDATEI=""
      if (mOp.Equal(YDATEI.get(),"")) {
        break;
      }
      //<< . set YKEY = $get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"P",1))
      YKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),YFORM.get(),"P",1)));
      //<< . quit:YKEY=""
      if (mOp.Equal(YKEY.get(),"")) {
        break;
      }
      //<< . ;
      //<< . set blnHeader = $$$NO
      blnHeader.set(include.COMSYS.$$$NO(m$));
      //<< . set YA    = ""
      YA.set("");
      //<< . set YA(1) = "^WWWLAST("""_YM_""","""_YDATEI_""","""_YKEY_""",YA)"
      YA.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWWLAST(\"",m$.var("YM").get()),"\",\""),YDATEI.get()),"\",\""),YKEY.get()),"\",YA)"));
      //<< . set YA(2) = "^WWWLAST("""_YM_""","""_YDATEI_""","""_YKEY_""",YA,1)"
      YA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWWLAST(\"",m$.var("YM").get()),"\",\""),YDATEI.get()),"\",\""),YKEY.get()),"\",YA,1)"));
      //<< . ;SR17705 set YLAST = ""
      //<< . set YLAST = $char(0) ;SR17705
      YLAST.set(m$.Fnc.$char(0));
      //<< . for YII=1:1:8 set YA = $order(@(YA(1)),-1) quit:YA=""  do
      for (YII.set(1);(mOp.LessOrEqual(YII.get(),8));YII.set(mOp.Add(YII.get(),1))) {
        YA.set(m$.Fnc.$order(m$.indirectVar((YA.var(1).get())),mOp.Negative(1)));
        if (mOp.Equal(YA.get(),"")) {
          break;
        }
        do {
          //<< . . quit:YLAST=$piece($get(@(YA(2))),Y,YLFN)
          if (mOp.Equal(YLAST.get(),m$.Fnc.$piece(m$.Fnc.$get(m$.indirectVar((YA.var(2).get()))),m$.var("Y").get(),m$.var("YLFN").get()))) {
            break;
          }
          //<< . . ;
          //<< . . if 'blnHeader set %TXT(1) = %TXT(1)_$char(13)_$$^WWWTEXT(390,,1)_$char(13) set blnHeader = $$$YES  ; "Last Changes:"  ;SR16943.3
          if (mOp.Not(blnHeader.get())) {
            m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),m$.Fnc.$char(13)),m$.fnc$("WWWTEXT.main",390,null,1)),m$.Fnc.$char(13)));
            blnHeader.set(include.COMSYS.$$$YES(m$));
          }
          //<< . . set YLAST = $piece($get(@(YA(2))),Y,YLFN)
          YLAST.set(m$.Fnc.$piece(m$.Fnc.$get(m$.indirectVar((YA.var(2).get()))),m$.var("Y").get(),m$.var("YLFN").get()));
          //<< . . ; vvv SR15525
          //<< . . set %TXT(1) = %TXT(1)_"("_$$^WWWDATE(YA)_" "_$$^WWWTIME(YA)_") "
          m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"("),m$.fnc$("WWWDATE.main",YA.get()))," "),m$.fnc$("WWWTIME.main",YA.get())),") "));
          //<< . . set strTempValue = $extract($translate($$GetLiteral^WWWTR(YEART,$piece($get(@(YA(2))),Y,YLFN)),"|'#?&"," "),1,40)
          strTempValue.set(m$.Fnc.$extract(m$.Fnc.$translate(m$.fnc$("WWWTR.GetLiteral",YEART.get(),m$.Fnc.$piece(m$.Fnc.$get(m$.indirectVar((YA.var(2).get()))),m$.var("Y").get(),m$.var("YLFN").get())),"|'#?&"," "),1,40));
          //<< . . if YEART=$$$FLDBoolean  set %TXT(1) = %TXT(1)_$piece($get(^WWW100(0,"JA/NEIN",SPRACHE,+strTempValue,1)),Y,1)_$char(13)
          if (mOp.Equal(YEART.get(),include.COMSYSWWW.$$$FLDBoolean(m$))) {
            m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"JA/NEIN",m$.var("SPRACHE").get(),mOp.Positive(strTempValue.get()),1)),m$.var("Y").get(),1)),m$.Fnc.$char(13)));
          }
          //<< . . if YEART'=$$$FLDBoolean set %TXT(1) = %TXT(1)_strTempValue_$char(13)
          if (mOp.NotEqual(YEART.get(),include.COMSYSWWW.$$$FLDBoolean(m$))) {
            m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),strTempValue.get()),m$.Fnc.$char(13)));
          }
        } while (false);
      }
      //<< . set %TXT(1) = %TXT(1)_"</small></strong>"
      m$.var("%TXT",1).set(mOp.Concat(m$.var("%TXT",1).get(),"</small></strong>"));
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< set %TXT(1) = $$Replace^COMUtilStr(%TXT(1),$char(13),"<br />")
    m$.var("%TXT",1).set(m$.fnc$("COMUtilStr.Replace",m$.var("%TXT",1).get(),m$.Fnc.$char(13),"<br />"));
    //<< do Show^WWWPopupMessage(%TXT(1),$$^WWWFELDNAME(YFORM,YI,YLFN),"Y"_YFORM_YI_YLFN)
    m$.Cmd.Do("WWWPopupMessage.Show",m$.var("%TXT",1).get(),m$.fnc$("WWWFELDNAME.main",YFORM.get(),YI.get(),m$.var("YLFN").get()),mOp.Concat(mOp.Concat(mOp.Concat("Y",YFORM.get()),YI.get()),m$.var("YLFN").get()));
    //<< set %TXT(1) = ""
    m$.var("%TXT",1).set("");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< MANU
  public void MANU() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   MANUELLE ROUTINE
    //<< ;
    //<< ; History:
    //<< ; 31-Jul-2012   shobby  SR18075: Use new field for SPRACHE in initialise
    //<< ; 23-Jan-2007   JW      SR15384: Encapsulated functionality
    //<< ; 10-Aug-2006   FrankF  BR014066: Setting the YSEITE global variable.
    //<< ;-------------------------------------------------------------------------------
    //<< new YFKEY,YKEY,YUSER,YFORM,YDATEI,YFELD,YSATZ,YINHALT,YBED,YVAR,YART,YDATA,YPR,YPR1,YUCI
    mVar YFKEY = m$.var("YFKEY");
    mVar YKEY = m$.var("YKEY");
    mVar YUSER = m$.var("YUSER");
    mVar YFORM = m$.var("YFORM");
    mVar YDATEI = m$.var("YDATEI");
    mVar YFELD = m$.var("YFELD");
    mVar YSATZ = m$.var("YSATZ");
    mVar YINHALT = m$.var("YINHALT");
    mVar YBED = m$.var("YBED");
    mVar YVAR = m$.var("YVAR");
    mVar YART = m$.var("YART");
    mVar YDATA = m$.var("YDATA");
    mVar YPR = m$.var("YPR");
    mVar YPR1 = m$.var("YPR1");
    mVar YUCI = m$.var("YUCI");
    m$.newVar(YFKEY,YKEY,YUSER,YFORM,YDATEI,YFELD,YSATZ,YINHALT,YBED,YVAR,YART,YDATA,YPR,YPR1,YUCI);
    //<< new YROUTINE,YLABEL,YSEITE,YA
    mVar YROUTINE = m$.var("YROUTINE");
    mVar YLABEL = m$.var("YLABEL");
    mVar YSEITE = m$.var("YSEITE");
    mVar YA = m$.var("YA");
    m$.newVar(YROUTINE,YLABEL,YSEITE,YA);
    //<< 
    //<< set YKEY = ""
    YKEY.set("");
    //<< do SplitRequest(.%REQUEST,.YINHALT,.YUCI,.YUSER,.YFORM,.YROUTINE,,,.YVAR)
    m$.Cmd.Do("SplitRequest",m$.var("%REQUEST"),YINHALT,YUCI,YUSER,YFORM,YROUTINE,null,null,YVAR);
    //<< 
    //<< do Initialise(YUSER,.%REQUEST)    ;SR18075
    m$.Cmd.Do("Initialise",YUSER.get(),m$.var("%REQUEST"));
    //<< quit:$extract(%TXT(1))=$$$AlertFollowing            ; *** EARLY QUIT - bad user
    if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$AlertFollowing(m$))) {
      return;
    }
    //<< 
    //<< if YFORM'="" if $$$WWW120SaveServerdata($get(^WWW120(0,YFORM,1))) set YHTMFORM = "WWW2"
    if (mOp.NotEqual(YFORM.get(),"")) {
      if (mOp.Logical(include.WWWConst.$$$WWW120SaveServerdata(m$,m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1))))) {
        mVar YHTMFORM = m$.var("YHTMFORM");
        YHTMFORM.set("WWW2");
      }
    }
    //<< if YVAR="LOCKSTART" set ^WWWDATEN(0,+$horolog,YUSER,YFORM,"LOCK",2) = $horolog   ;SETZEN DES FELDLOCKS
    if (mOp.Equal(YVAR.get(),"LOCKSTART")) {
      m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),YFORM.get(),"LOCK",2).set(m$.Fnc.$horolog());
    }
    //<< if YVAR="LOCKEND"  kill ^WWWDATEN(0,+$horolog,YUSER,YFORM,"LOCK",2)              ;LÖSCHEN DES FELDLOCKS
    if (mOp.Equal(YVAR.get(),"LOCKEND")) {
      m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),YFORM.get(),"LOCK",2).kill();
    }
    //<< 
    //<< set YLABEL = ""
    YLABEL.set("");
    //<< if $extract(YROUTINE,1,2)="**" do  quit                                           ;FIS;26222;23.08.04;KLASSENMETHODE AUFRUFEN
    if (mOp.Equal(m$.Fnc.$extract(YROUTINE.get(),1,2),"**")) {
      //<< . set YA = "SET %TXT(1)=##"_$piece($extract(YROUTINE,3,999),"(",1,2)_"(YINHALT,YVAR)"
      YA.set(mOp.Concat(mOp.Concat("SET %TXT(1)=##",m$.Fnc.$piece(m$.Fnc.$extract(YROUTINE.get(),3,999),"(",1,2)),"(YINHALT,YVAR)"));
      //<< . xecute YA
      m$.Cmd.Xecute(YA.get());
      return;
    }
    //<< 
    //<< if $find(YROUTINE,"^") set YLABEL = $piece(YROUTINE,"^",1),YROUTINE = $piece(YROUTINE,"^",2)     ;FIS;26222;20.08.04;LABEL AUFRUFEN
    if (mOp.Logical(m$.Fnc.$find(YROUTINE.get(),"^"))) {
      YLABEL.set(m$.Fnc.$piece(YROUTINE.get(),"^",1));
      YROUTINE.set(m$.Fnc.$piece(YROUTINE.get(),"^",2));
    }
    //<< if $translate(YROUTINE,"""'")'=""  if $$EXIST^%R(YROUTINE_".OBJ",YUCI) do  quit:%TXT(1)'=""      ;Bec;05.12.03;24774;CHECK IF COMPLED ROUTINE EXIST.
    if (mOp.NotEqual(m$.Fnc.$translate(YROUTINE.get(),"\"'"),"")) {
      if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(YROUTINE.get(),".OBJ"),YUCI.get()))) {
        //<< . set YA = "SET %TXT(1)=$$"_YLABEL_"^"_YROUTINE_"(YINHALT,YVAR)"
        YA.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("SET %TXT(1)=$$",YLABEL.get()),"^"),YROUTINE.get()),"(YINHALT,YVAR)"));
        //<< . xecute YA
        m$.Cmd.Xecute(YA.get());
        if (mOp.NotEqual(m$.var("%TXT",1).get(),"")) {
          return;
        }
      }
    }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< VARIABLE
  public void VARIABLE() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;       VARIABLE SICHERN ;safeguard
    //<< ;
    //<< ;   %REQUEST            ="NAMESPACE.USER.FORM..0..YVARIABLE"   ;
    //<< ;   %REQUEST(1)         ="VALUE"
    //<< ;   $P(%REQUEST,".",6)  =FIXKEY (VALIDIERUNG MIT FIXVALID_FELDTYP)
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 31-Jul-2012   shobby  SR18075: Use new field for SPRACHE in initialise
    //<< ; 03-May-2010   GRF     SR15961: use dteToday for efficiency
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR;
    //<< ;                           Activate AdjustCurrencyAmount
    //<< ; 23-Jan-2007   JW      SR15384: Encapsulated functionality
    //<< ; 16-Mar-2007   GRF     SR12505: naked references
    //<< ; 28-Oct-2005   JW      SR13074: Call AdjustCurrencyAmount
    //<< ; 10-Jun-2005   PO      SR12050: Allowing header to be in base while grid is in FC
    //<< ;-------------------------------------------------------------------------------
    //<< new YFKEY,YKEY,YUSER,YFORM,YDATEI,YFELD,YSATZ,YINHALT,YBED,YVAR,YART,YDATA,YPR,YPR1,YOLDV
    mVar YFKEY = m$.var("YFKEY");
    mVar YKEY = m$.var("YKEY");
    mVar YUSER = m$.var("YUSER");
    mVar YFORM = m$.var("YFORM");
    mVar YDATEI = m$.var("YDATEI");
    mVar YFELD = m$.var("YFELD");
    mVar YSATZ = m$.var("YSATZ");
    mVar YINHALT = m$.var("YINHALT");
    mVar YBED = m$.var("YBED");
    mVar YVAR = m$.var("YVAR");
    mVar YART = m$.var("YART");
    mVar YDATA = m$.var("YDATA");
    mVar YPR = m$.var("YPR");
    mVar YPR1 = m$.var("YPR1");
    mVar YOLDV = m$.var("YOLDV");
    m$.newVar(YFKEY,YKEY,YUSER,YFORM,YDATEI,YFELD,YSATZ,YINHALT,YBED,YVAR,YART,YDATA,YPR,YPR1,YOLDV);
    //<< new dteToday,strStored
    mVar dteToday = m$.var("dteToday");
    mVar strStored = m$.var("strStored");
    m$.newVar(dteToday,strStored);
    //<< 
    //<< set YKEY  = ""
    YKEY.set("");
    //<< set YSATZ = ""
    YSATZ.set("");
    //<< 
    //<< do SplitRequest(.%REQUEST,.YINHALT,,.YUSER,.YFORM,,,.YFKEY,.YVAR)
    m$.Cmd.Do("SplitRequest",m$.var("%REQUEST"),YINHALT,null,YUSER,YFORM,null,null,YFKEY,YVAR);
    //<< do Initialise(YUSER,.%REQUEST)    ;SR18075
    m$.Cmd.Do("Initialise",YUSER.get(),m$.var("%REQUEST"));
    //<< quit:$extract(%TXT(1))=$$$AlertFollowing            ; *** EARLY QUIT - bad user
    if (mOp.Equal(m$.Fnc.$extract(m$.var("%TXT",1).get()),include.COMSYS.$$$AlertFollowing(m$))) {
      return;
    }
    //<< quit:(YFORM="")||(YVAR="")
    if ((mOp.Equal(YFORM.get(),"")) || (mOp.Equal(YVAR.get(),""))) {
      return;
    }
    //<< 
    //<< set dteToday = +$horolog   ; SR15961
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< set YOLDV    = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,"V",YVAR,1))
    YOLDV.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),YUSER.get(),YFORM.get(),"V",YVAR.get(),1)));
    //<< 
    //<< if '(($extract(YFKEY,6,99)=$$$FLDCurrency) && ($get(^CacheTemp(YUSER,$get(^CacheTemp(YUSER,"Grid","Container")," "),"Toggles","Currency"))="Foreign")) {
    if (mOp.Not(((mOp.Equal(m$.Fnc.$extract(YFKEY.get(),6,99),include.COMSYSWWW.$$$FLDCurrency(m$))) && (mOp.Equal(m$.Fnc.$get(m$.var("^CacheTemp",YUSER.get(),m$.Fnc.$get(m$.var("^CacheTemp",YUSER.get(),"Grid","Container")," "),"Toggles","Currency")),"Foreign"))))) {
      //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"V",YVAR,1)=YINHALT  ;DATEN ZUR PRUEFUNG
      m$.var("^WWWDATEN",0,dteToday.get(),YUSER.get(),YFORM.get(),"V",YVAR.get(),1).set(YINHALT.get());
    }
    //<< 
    //<< } else {
    else {
      //<< new curFCAmount,curBase1,curForeign1,strCurrency1,fltRate1,curBase2,curForeign2,strCurrency2,fltRate2
      mVar curFCAmount = m$.var("curFCAmount");
      mVar curBase1 = m$.var("curBase1");
      mVar curForeign1 = m$.var("curForeign1");
      mVar strCurrency1 = m$.var("strCurrency1");
      mVar fltRate1 = m$.var("fltRate1");
      mVar curBase2 = m$.var("curBase2");
      mVar curForeign2 = m$.var("curForeign2");
      mVar strCurrency2 = m$.var("strCurrency2");
      mVar fltRate2 = m$.var("fltRate2");
      m$.newVar(curFCAmount,curBase1,curForeign1,strCurrency1,fltRate1,curBase2,curForeign2,strCurrency2,fltRate2);
      //<< 
      //<< if +YINHALT=0 {     ; JW fixed
      if (mOp.Equal(mOp.Positive(YINHALT.get()),0)) {
        //<< if YINHALT'="" set YINHALT=0
        if (mOp.NotEqual(YINHALT.get(),"")) {
          YINHALT.set(0);
        }
        //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"V",YVAR,1)=YINHALT
        m$.var("^WWWDATEN",0,dteToday.get(),YUSER.get(),YFORM.get(),"V",YVAR.get(),1).set(YINHALT.get());
      }
      //<< } else {
      else {
        //<< do Split^WWWTR($get(^WWWDATEN(0,dteToday,YUSER,YFORM,"V",YVAR,1)),.curBase1,.curForeign1,.strCurrency1,.fltRate1)
        m$.Cmd.Do("WWWTR.Split",m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),YUSER.get(),YFORM.get(),"V",YVAR.get(),1)),curBase1,curForeign1,strCurrency1,fltRate1);
        //<< if YINHALT["@" {
        if (mOp.Contains(YINHALT.get(),"@")) {
          //<< set curFCAmount = $$GetInternal^WWWTR($$$FLDCurrency,YINHALT)
          curFCAmount.set(m$.fnc$("WWWTR.GetInternal",include.COMSYSWWW.$$$FLDCurrency(m$),YINHALT.get()));
        }
        //<< } else {
        else {
          //<< set curFCAmount = $$GetInternal^WWWTR($$$FLDCurrency,$get(^CacheTemp(YUSER,$get(^CacheTemp(YUSER,"Grid","Container")," "),"Display Currency"))_YINHALT_"@"_fltRate1)
          curFCAmount.set(m$.fnc$("WWWTR.GetInternal",include.COMSYSWWW.$$$FLDCurrency(m$),mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("^CacheTemp",YUSER.get(),m$.Fnc.$get(m$.var("^CacheTemp",YUSER.get(),"Grid","Container")," "),"Display Currency")),YINHALT.get()),"@"),fltRate1.get())));
        }
        //<< }
        //<< do Split^WWWTR(curFCAmount,.curBase2,.curForeign2,.strCurrency2,.fltRate2)
        m$.Cmd.Do("WWWTR.Split",curFCAmount.get(),curBase2,curForeign2,strCurrency2,fltRate2);
        //<< ;       if '((curForeign1=curForeign2)&&(fltRate1=fltRate2)) {
        //<< if (curForeign1'=curForeign2) || (fltRate1'=fltRate2) {
        if ((mOp.NotEqual(curForeign1.get(),curForeign2.get())) || (mOp.NotEqual(fltRate1.get(),fltRate2.get()))) {
          //<< set ^WWWDATEN(0,dteToday,YUSER,YFORM,"V",YVAR,1) = curFCAmount
          m$.var("^WWWDATEN",0,dteToday.get(),YUSER.get(),YFORM.get(),"V",YVAR.get(),1).set(curFCAmount.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if $extract(YFKEY,1,5)="VALID" do  ;RÜCKGABE FORMATIEREN ;format
    if (mOp.Equal(m$.Fnc.$extract(YFKEY.get(),1,5),"VALID")) {
      //<< . new YTYP
      mVar YTYP = m$.var("YTYP");
      m$.newVarBlock(1,YTYP);
      //<< . set YTYP = $extract(YFKEY,6,99)                                 ;FELDTYP
      YTYP.set(m$.Fnc.$extract(YFKEY.get(),6,99));
      //<< . if +YTYP'=0 do
      if (mOp.NotEqual(mOp.Positive(YTYP.get()),0)) {
        //<< . . if YTYP=$$$FLDNumeric set YINHALT = $justify(YINHALT,0,0)     ; NUR GANZE ZAHLEN ;only
        if (mOp.Equal(YTYP.get(),include.COMSYSWWW.$$$FLDNumeric(m$))) {
          YINHALT.set(m$.Fnc.$justify(YINHALT.get(),0,0));
        }
        //<< . . if YTYP=$$$FLDDate do                                         ; Date
        if (mOp.Equal(YTYP.get(),include.COMSYSWWW.$$$FLDDate(m$))) {
          //<< . . . set strStored = $$TranslateDate^WWWFieldRules(.YINHALT)     ; %TXT(1) may be set
          strStored.set(m$.fnc$("WWWFieldRules.TranslateDate",YINHALT));
          //<< . . . if +$$^WWWDATE1(strStored)=0 set YINHALT=""                 ; NUR GÜLTIGES DATUM ;only Date
          if (mOp.Equal(mOp.Positive(m$.fnc$("WWWDATE1.main",strStored.get())),0)) {
            YINHALT.set("");
          }
        }
        //<< . . ;
        //<< . . if ($get(^CacheTemp(YUSER,"Grid","Name")) = YFORM) set YDECIMALLEN = 9 ; SR11824 Set decimal points for Grid. (used by WWWTR)
        if ((mOp.Equal(m$.Fnc.$get(m$.var("^CacheTemp",YUSER.get(),"Grid","Name")),YFORM.get()))) {
          mVar YDECIMALLEN = m$.var("YDECIMALLEN");
          YDECIMALLEN.set(9);
        }
        //<< . . if YTYP=$$$FLDCurrency do AdjustCurrencyAmount(.YINHALT,$get(YDECIMAL))
        if (mOp.Equal(YTYP.get(),include.COMSYSWWW.$$$FLDCurrency(m$))) {
          m$.Cmd.Do("AdjustCurrencyAmount",YINHALT,m$.Fnc.$get(m$.var("YDECIMAL")));
        }
        //<< . . ;
        //<< . . set YINHALT = $$GetInternal^WWWTR(YTYP,YINHALT)
        YINHALT.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YINHALT.get()));
        //<< . . if '((YTYP=$$$FLDCurrency) && ($get(^CacheTemp(YUSER,$get(^CacheTemp(YUSER,"Grid","Container")," "),"Toggles","Currency"))="Foreign")) do
        if (mOp.Not(((mOp.Equal(YTYP.get(),include.COMSYSWWW.$$$FLDCurrency(m$))) && (mOp.Equal(m$.Fnc.$get(m$.var("^CacheTemp",YUSER.get(),m$.Fnc.$get(m$.var("^CacheTemp",YUSER.get(),"Grid","Container")," "),"Toggles","Currency")),"Foreign"))))) {
          //<< . . . set ^WWWDATEN(0,dteToday,YUSER,YFORM,"V",YVAR,1) = YINHALT
          m$.var("^WWWDATEN",0,dteToday.get(),YUSER.get(),YFORM.get(),"V",YVAR.get(),1).set(YINHALT.get());
        }
        //<< . . set YINHALT = $$GetLiteral^WWWTR(YTYP,YINHALT)  ;ANZEIGEFORMAT
        YINHALT.set(m$.fnc$("WWWTR.GetLiteral",YTYP.get(),YINHALT.get()));
      }
      //<< . ;
      //<< . set %TXT(1) = $$$Perform_YVAR_"~"_YINHALT
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYS.$$$Perform(m$),YVAR.get()),"~"),YINHALT.get()));
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< ERROR
  public void ERROR() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;                   ERROR HANDLER
    //<< ; History:
    //<< ; 27-Mar-2008   GRF     SR15647: Add a second's delay to ensure not being over-written
    //<< ;-------------------------------------------------------------------------------
    //<< ; "An Internal ERROR Has Occurred In Your Application."
    //<< set %TXT(1) = "!"_$$^WWWTEXT(387)_" "_$char(13)_"EventBroker: "_$zerror
    m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("!",m$.fnc$("WWWTEXT.main",387))," "),m$.Fnc.$char(13)),"EventBroker: "),m$.Fnc.$zerror()));
    //<< if $find($zerror,"<MAXSTRING>")   set %TXT(1) = "!"_$$^WWWTEXT(401)_"!"    ; "Data Record is too long!"  DATENSATZ ZU LANG
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$zerror(),"<MAXSTRING>"))) {
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat("!",m$.fnc$("WWWTEXT.main",401)),"!"));
    }
    //<< if $find($zerror,"<STRINGSTACK>") set %TXT(1) = "!"_$$^WWWTEXT(401)_" !"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$zerror(),"<STRINGSTACK>"))) {
      m$.var("%TXT",1).set(mOp.Concat(mOp.Concat("!",m$.fnc$("WWWTEXT.main",401))," !"));
    }
    //<< set ^WWWERROR(0,+$horolog,$piece($horolog,",",2),+$get(YUSER),1) = $zerror_" / Event"
    m$.var("^WWWERROR",0,mOp.Positive(m$.Fnc.$horolog()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),mOp.Positive(m$.Fnc.$get(m$.var("YUSER"))),1).set(mOp.Concat(m$.Fnc.$zerror()," / Event"));
    //<< hang 1
    m$.Cmd.Hang(1);
    //<< if +$get(YHYPER)=1     set %TXT(1) = $translate(%TXT(1),$char(13,10),"'") quit  ;SEND ANSWER TXT(1)
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),1)) {
      m$.var("%TXT",1).set(m$.Fnc.$translate(m$.var("%TXT",1).get(),m$.Fnc.$char(13,10),"'"));
      return;
    }
    //<< if $find(%TXT(1),"&#") set %TXT(1) = $piece(%TXT(1),"&#",1)              ;KEINE SONDERZEICHEN VIA EVENT ;no special character via
    if (mOp.Logical(m$.Fnc.$find(m$.var("%TXT",1).get(),"&#"))) {
      m$.var("%TXT",1).set(m$.Fnc.$piece(m$.var("%TXT",1).get(),"&#",1));
    }
    //<< if $get(YHYPER)=0 do sendline^%mgwj("")                                  ;SEND ANSWER
    if (mOp.Equal(m$.Fnc.$get(m$.var("YHYPER")),0)) {
      m$.Cmd.Do("$mgwj.sendline","");
    }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< ERROR1 ;ERROR HANDLER
  public void ERROR1() {
    //<< set %TXT(1)=""
    m$.var("%TXT",1).set("");
    //<< if +$get(YHYPER)=1     set %TXT(1) = $translate(%TXT(1),$char(13,10),"'") quit  ;SEND ANSWER TXT(1)
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),1)) {
      m$.var("%TXT",1).set(m$.Fnc.$translate(m$.var("%TXT",1).get(),m$.Fnc.$char(13,10),"'"));
      return;
    }
    //<< if $find(%TXT(1),"&#") set %TXT(1) = $piece(%TXT(1),"&#",1)  ;KEINE SONDERZEICHEN VIA EVENT ;no special character via
    if (mOp.Logical(m$.Fnc.$find(m$.var("%TXT",1).get(),"&#"))) {
      m$.var("%TXT",1).set(m$.Fnc.$piece(m$.var("%TXT",1).get(),"&#",1));
    }
    //<< if $get(YHYPER)=0 do sendline^%mgwj("")                    ;SEND ANSWER
    if (mOp.Equal(m$.Fnc.$get(m$.var("YHYPER")),0)) {
      m$.Cmd.Do("$mgwj.sendline","");
    }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< IsLockOkTest(YUSER,YFORM,pdteToday="")
  public Object IsLockOkTest(Object ... _p) {
    mVar YUSER = m$.newVarRef("YUSER",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pdteToday = m$.newVarRef("pdteToday",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Do we need a lock, and if so, do we have it ?
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Jun-2008   shobby  SRBR014952: Separated logic from error message.
    //<< ; 23-Jan-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new strLock,blnOk
    mVar strLock = m$.var("strLock");
    mVar blnOk = m$.var("blnOk");
    m$.newVar(strLock,blnOk);
    //<< 
    //<< set blnOk = $$$YES
    blnOk.set(include.COMSYS.$$$YES(m$));
    //<< if pdteToday="" set pdteToday = +$horolog
    if (mOp.Equal(pdteToday.get(),"")) {
      pdteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; 1. Get ^WWW006 data path from WWWDATEN("LOCK")
    //<< ; 2. If the ^WWW006 entry for the form record is not defined
    //<< ;       Return NO
    //<< ;    else it exists
    //<< ;       if it is held by a different user
    //<< ;          Return No
    //<< ;---------------------------------------
    //<< ;   SR15961 looks at how to refresh the lock so that another user cannot gain
    //<< ;           ownership just because user hasn't saved or changed tabs but is
    //<< ;           still working on the data - still may not be able to detect when
    //<< ;           working WITHIN a memo field but not blurring.
    //<< ;---------------------------------------
    //<< set strLock = $get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"LOCK",1))
    strLock.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),YFORM.get(),"LOCK",1)));
    //<< ; Contents of LOCK: ^WWW006(0,+$H,"^{Global Name}/{Shared/Co. ID}.{Record key(s)}.1/",1) - check for "+" is a issue if key includes "+"
    //<< if (strLock'="") && '$find(strLock,"+") {
    if ((mOp.NotEqual(strLock.get(),"")) && mOp.Not(m$.Fnc.$find(strLock.get(),"+"))) {
      //<< if '$data(@strLock) {
      if (mOp.Not(m$.Fnc.$data(m$.indirectVar(strLock.get())))) {
        //<< set blnOk = $$$NO
        blnOk.set(include.COMSYS.$$$NO(m$));
      }
      //<< 
      //<< } elseif ($$$WWW006User1(@strLock)'=YUSER) {  ; FIXME: will block record where lock has expired - see IsLocked^WWW006
      else if ((mOp.NotEqual(include.WWWConst.$$$WWW006User1(m$,m$.indirectVar(strLock.get())),YUSER.get()))) {
        //<< set blnOk = $$$NO
        blnOk.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnOk
    return blnOk.get();
  }

  //<< 
  //<< 
  //<< IsLockOk(YUSER,YFORM,pdteToday="")
  public Object IsLockOk(Object ... _p) {
    mVar YUSER = m$.newVarRef("YUSER",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pdteToday = m$.newVarRef("pdteToday",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Do we need a lock, and if so, do we have it ?
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Jun-2008   shobby  SRBR014952: Separated logic from error message.
    //<< ;-------------------------------------------------------------------------------
    //<< new blnOk
    mVar blnOk = m$.var("blnOk");
    m$.newVar(blnOk);
    //<< 
    //<< set blnOk = $$IsLockOkTest(YUSER,YFORM,pdteToday)
    blnOk.set(m$.fnc$("IsLockOkTest",YUSER.get(),YFORM.get(),pdteToday.get()));
    //<< set:'blnOk %TXT(1) = $$$AlertFollowing_$$^WWWTEXT(392,,1)
    if (mOp.Not(blnOk.get())) {
      m$.var("%TXT",1).set(mOp.Concat(include.COMSYS.$$$AlertFollowing(m$),m$.fnc$("WWWTEXT.main",392,null,1)));
    }
    //<< ; "Another User has changed the data record. Please Refresh This Page. Save is not possible."
    //<< 
    //<< quit blnOk
    return blnOk.get();
  }

  //<< ; FIXME : message is not quite accurate - user may not have actually made a
  //<< ;         change - he has simply gotten control of the lock. <GRF>
  //<< 
  //<< 
  //<< SetLock(pidUser,pidForm,pdteToday="")
  public Object SetLock(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pdteToday = m$.newVarRef("pdteToday",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Refresh Record Lock
    //<< ;
    //<< ; History:
    //<< ; 04-May-2010   GRF     SR15961: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objLock,strLock
    mVar objLock = m$.var("objLock");
    mVar strLock = m$.var("strLock");
    m$.newVar(objLock,strLock);
    //<< 
    //<< quit  ; DISABLED FOR NOW
    return null;
  }

  //<< 
  //<< /*
  //<< if pdteToday="" set pdteToday = +$horolog
  //<< set strLock = $get(^WWWDATEN(0,pdteToday,pidUser,pidForm,"LOCK",1))
  //<< if strLock'="" {
  //<< set objLock = @strLock
  //<< if $$$WWW006User1(objLock)=pidUser {
  //<< set @strLock = pidUser_Y_$piece($horolog,$$$COMMA,2)
  //<< }
  //<< }
  //<< quit
  //<< */
  //<< 
  //<< 
  //<< Store(&YINHALT,&pstrStored)
  public Object Store(Object ... _p) {
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrStored = m$.newVarRef("pstrStored",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Store the translated value in WWWDATEN
    //<< ;
    //<< ; Params:   YINHALT - entered value
    //<< ;           pstrStored - stored value
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-May-2010   GRF     SR15961: use dteToday for efficiency
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR;
    //<< ;                           Activate AdjustCurrencyAmount
    //<< ; 01-Feb-2007   JW      SR15384: Encapsulated, cleaned up.
    //<< ;-------------------------------------------------------------------------------
    //<< new blnDone,blnFullKey,dteToday,intLast,strCur,strKeys,FIELD,strVar
    mVar blnDone = m$.var("blnDone");
    mVar blnFullKey = m$.var("blnFullKey");
    mVar dteToday = m$.var("dteToday");
    mVar intLast = m$.var("intLast");
    mVar strCur = m$.var("strCur");
    mVar strKeys = m$.var("strKeys");
    mVar FIELD = m$.var("FIELD");
    mVar strVar = m$.var("strVar");
    m$.newVar(blnDone,blnFullKey,dteToday,intLast,strCur,strKeys,FIELD,strVar);
    //<< 
    //<< set YOLDV      = ""  ; Old value
    mVar YOLDV = m$.var("YOLDV");
    YOLDV.set("");
    //<< set pstrStored = ""
    pstrStored.set("");
    //<< set dteToday   = +$horolog   ; SR15961
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< if YART'="P" {
    if (mOp.NotEqual(m$.var("YART").get(),"P")) {
      //<< set FIELD = $get(^WWWDATEN(0,dteToday,YUSER,YFORM,YART,1))
      FIELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),m$.var("YART").get(),1)));
      //<< set YOLDV = $piece(FIELD,Y,YLFN)
      YOLDV.set(m$.Fnc.$piece(FIELD.get(),m$.var("Y").get(),m$.var("YLFN").get()));
      //<< if '$data(YDECIMAL) new YDECIMAL        ; Is this ok here?
      if (mOp.Not(m$.Fnc.$data(m$.var("YDECIMAL")))) {
        mVar YDECIMAL = m$.var("YDECIMAL");
        m$.newVar(YDECIMAL);
      }
      //<< 
      //<< if (YTYP=$$$FLDMemo) && (YVAR="PLUS") {    ;SONDER SAVE TEXT>1000
      if ((mOp.Equal(m$.var("YTYP").get(),include.COMSYSWWW.$$$FLDMemo(m$))) && (mOp.Equal(m$.var("YVAR").get(),"PLUS"))) {
        //<< if ($length(FIELD)+$length(YINHALT))>32000 {
        if (mOp.Greater((mOp.Add(m$.Fnc.$length(FIELD.get()),m$.Fnc.$length(YINHALT.get()))),32000)) {
          //<< set YINHALT = $extract(YINHALT,1,32000-$length(FIELD))
          YINHALT.set(m$.Fnc.$extract(YINHALT.get(),1,mOp.Subtract(32000,m$.Fnc.$length(FIELD.get()))));
          //<< if $length(YOLDV)<1200 {
          if (mOp.Less(m$.Fnc.$length(YOLDV.get()),1200)) {
            //<< set %TXT(1) = $$$AlertFollowing_$$^WWWTEXT(401)  ; "Data Record is too long!"
            m$.var("%TXT",1).set(mOp.Concat(include.COMSYS.$$$AlertFollowing(m$),m$.fnc$("WWWTEXT.main",401)));
          }
        }
        //<< }
        //<< }
        //<< set pstrStored = YOLDV_$$GetInternal^WWWTR(YTYP,YINHALT)
        pstrStored.set(mOp.Concat(YOLDV.get(),m$.fnc$("WWWTR.GetInternal",m$.var("YTYP").get(),YINHALT.get())));
        //<< set $piece(^WWWDATEN(0,dteToday,YUSER,YFORM,YART,1),Y,YLFN) = pstrStored
        m$.pieceVar(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),m$.var("YART").get(),1),m$.var("Y").get(),m$.var("YLFN").get()).set(pstrStored.get());
      }
      //<< 
      //<< } else {
      else {
        //<< if YTYP=$$$FLDCurrency do AdjustCurrencyAmount(.YINHALT,$get(YDECIMAL))
        if (mOp.Equal(m$.var("YTYP").get(),include.COMSYSWWW.$$$FLDCurrency(m$))) {
          m$.Cmd.Do("AdjustCurrencyAmount",YINHALT,m$.Fnc.$get(m$.var("YDECIMAL")));
        }
        //<< 
        //<< ; SR12236: Form ---> WWWTR ----> WWWDATEN (NOT FORM UPDATE!!!)
        //<< if '$find(YINHALT,";") {
        if (mOp.Not(m$.Fnc.$find(YINHALT.get(),";"))) {
          //<< if pstrStored="" set pstrStored = $$GetInternal^WWWTR(YTYP,YINHALT,YDECIMALLEN)  ;DATEN ZUR PRUEFUNG
          if (mOp.Equal(pstrStored.get(),"")) {
            pstrStored.set(m$.fnc$("WWWTR.GetInternal",m$.var("YTYP").get(),YINHALT.get(),m$.var("YDECIMALLEN").get()));
          }
          //<< set YINHALT = $$GetLiteral^WWWTR(YTYP,pstrStored,YDECIMALLEN)
          YINHALT.set(m$.fnc$("WWWTR.GetLiteral",m$.var("YTYP").get(),pstrStored.get(),m$.var("YDECIMALLEN").get()));
        }
        //<< 
        //<< } else {
        else {
          //<< set pstrStored = $translate(YINHALT,Y,"-")  ;DATEN ZUR PRUEFUNG
          pstrStored.set(m$.Fnc.$translate(YINHALT.get(),m$.var("Y").get(),"-"));
        }
        //<< }
        //<< 
        //<< if (YTYP=$$$FLDCurrency) {
        if ((mOp.Equal(m$.var("YTYP").get(),include.COMSYSWWW.$$$FLDCurrency(m$)))) {
          //<< if $find(pstrStored,"@") {      ; SR11349
          if (mOp.Logical(m$.Fnc.$find(pstrStored.get(),"@"))) {
            //<< set strCur=$get(^CacheTemp(YUSER,YFORM,"Toggles","Currency"))
            strCur.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Toggles","Currency")));
            //<< if strCur="Foreign" {
            if (mOp.Equal(strCur.get(),"Foreign")) {
              //<< if $get(^CacheTemp(YUSER,YFORM,"Display Currency"))'=$$Cur^WWWTR(pstrStored) {
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Display Currency")),m$.fnc$("WWWTR.Cur",pstrStored.get()))) {
                //<< set pstrStored=0
                pstrStored.set(0);
                //<< set YINHALT = " "       ; Space is necessary
                YINHALT.set(" ");
              }
              //<< } else {
              else {
                //<< set YINHALT = $$GetLiteral^WWWTR(YTYP,$$FCAmount^WWWTR(pstrStored),YDECIMALLEN)
                YINHALT.set(m$.fnc$("WWWTR.GetLiteral",m$.var("YTYP").get(),m$.fnc$("WWWTR.FCAmount",pstrStored.get()),m$.var("YDECIMALLEN").get()));
              }
            }
            //<< }
            //<< } else {
            else {
              //<< set YINHALT = $$GetLiteral^WWWTR(YTYP,$piece(pstrStored,"@",1))  ;FIS;25727;FREMDWÄHRUNG;24.05.04
              YINHALT.set(m$.fnc$("WWWTR.GetLiteral",m$.var("YTYP").get(),m$.Fnc.$piece(pstrStored.get(),"@",1)));
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< 
        //<< ; STORED BACK INTO WWWDATEN
        //<< set $piece(^WWWDATEN(0,dteToday,YUSER,YFORM,YART,1),Y,YLFN) = pstrStored
        m$.pieceVar(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),m$.var("YART").get(),1),m$.var("Y").get(),m$.var("YLFN").get()).set(pstrStored.get());
        //<< 
        //<< ; No idea what this code is supposed to be doing.  Putting values in other fields?
        //<< set strVar = $$$WWW122VariableForEventBroker(YSATZ)
        strVar.set(include.WWWConst.$$$WWW122VariableForEventBroker(m$,m$.var("YSATZ")));
        //<< if ($extract(strVar)="@") && ($extract(YVAR,1,4)="MORE") {
        if ((mOp.Equal(m$.Fnc.$extract(strVar.get()),"@")) && (mOp.Equal(m$.Fnc.$extract(m$.var("YVAR").get(),1,4),"MORE"))) {
          //<< new MFIELD,MVALUE,MEART
          mVar MFIELD = m$.var("MFIELD");
          mVar MVALUE = m$.var("MVALUE");
          mVar MEART = m$.var("MEART");
          m$.newVar(MFIELD,MVALUE,MEART);
          //<< set MFIELD = $extract(strVar,2,99)  ;WEITERES FELD ZUR SPEICHERUNG ;field
          MFIELD.set(m$.Fnc.$extract(strVar.get(),2,99));
          //<< set MVALUE = $extract(YVAR,5,99)    ;FELDINHALT
          MVALUE.set(m$.Fnc.$extract(m$.var("YVAR").get(),5,99));
          //<< 
          //<< for MFIELD(1)=1:1 {
          for (m$.var("MFIELD",1).set(1);(true);m$.var("MFIELD",1).set(mOp.Add(m$.var("MFIELD",1).get(),1))) {
            //<< set MFIELD(2) = $piece(MFIELD,",",MFIELD(1))
            MFIELD.var(2).set(m$.Fnc.$piece(MFIELD.get(),",",MFIELD.var(1).get()));
            //<< quit:MFIELD(2)=""
            if (mOp.Equal(MFIELD.var(2).get(),"")) {
              break;
            }
            //<< 
            //<< set MVALUE(2) = $piece(MVALUE,Y,MFIELD(1))
            MVALUE.var(2).set(m$.Fnc.$piece(MVALUE.get(),m$.var("Y").get(),MFIELD.var(1).get()));
            //<< 
            //<< set MEART    = 6
            MEART.set(6);
            //<< set MEART(1) = $get(^WWW122(0,YFORM,MFIELD(2),1))
            MEART.var(1).set(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),MFIELD.var(2).get(),1)));
            //<< set MEART(2) = $piece(MEART(1),Y,1)
            MEART.var(2).set(m$.Fnc.$piece(MEART.var(1).get(),m$.var("Y").get(),1));
            //<< if MEART(2)'="" if YDATEI'="" set MEART = $piece($get(^WWW003(0,YDATEI,MEART(2),1)),Y,3)
            if (mOp.NotEqual(MEART.var(2).get(),"")) {
              if (mOp.NotEqual(m$.var("YDATEI").get(),"")) {
                MEART.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),MEART.var(2).get(),1)),m$.var("Y").get(),3));
              }
            }
            //<< if '$find(MVALUE(2),";") set $piece(^WWWDATEN(0,dteToday,YUSER,YFORM,YART,1),Y,MFIELD(2)) = $$GetInternal^WWWTR(MEART,MVALUE(2))  ;DATEN ZUR PRUEFUNG
            if (mOp.Not(m$.Fnc.$find(MVALUE.var(2).get(),";"))) {
              m$.pieceVar(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),m$.var("YART").get(),1),m$.var("Y").get(),MFIELD.var(2).get()).set(m$.fnc$("WWWTR.GetInternal",MEART.get(),MVALUE.var(2).get()));
            }
            //<< if $find(MVALUE(2),";")  set $piece(^WWWDATEN(0,dteToday,YUSER,YFORM,YART,1),Y,MFIELD(2)) = $translate(MVALUE(2),Y,"-")  ;DATEN ZUR PRUEFUNG
            if (mOp.Logical(m$.Fnc.$find(MVALUE.var(2).get(),";"))) {
              m$.pieceVar(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),m$.var("YART").get(),1),m$.var("Y").get(),MFIELD.var(2).get()).set(m$.Fnc.$translate(MVALUE.var(2).get(),m$.var("Y").get(),"-"));
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< if pstrStored="" set pstrStored = $$GetInternal^WWWTR(YTYP,YINHALT,YDECIMALLEN)
      if (mOp.Equal(pstrStored.get(),"")) {
        pstrStored.set(m$.fnc$("WWWTR.GetInternal",m$.var("YTYP").get(),YINHALT.get(),m$.var("YDECIMALLEN").get()));
      }
      //<< set $piece(^WWWDATEN(0,dteToday,YUSER,YFORM,YART,1),",",YLFN) = pstrStored  ;DATEN ZUR PRUEFUNG
      m$.pieceVar(m$.var("^WWWDATEN",0,dteToday.get(),m$.var("YUSER").get(),m$.var("YFORM").get(),m$.var("YART").get(),1),",",m$.var("YLFN").get()).set(pstrStored.get());
      //<< set YINHALT = $$GetLiteral^WWWTR(YTYP,pstrStored,YDECIMALLEN)
      YINHALT.set(m$.fnc$("WWWTR.GetLiteral",m$.var("YTYP").get(),pstrStored.get(),m$.var("YDECIMALLEN").get()));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Open(&YINHALT,&pstrStored,pobjForm,pobjClsFld,pobjCustFld)
  public Object Open(Object ... _p) {
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrStored = m$.newVarRef("pstrStored",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjForm = m$.newVarRef("pobjForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pobjClsFld = m$.newVarRef("pobjClsFld",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pobjCustFld = m$.newVarRef("pobjCustFld",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Can we open the record - via entering an existing key ?
    //<< ;
    //<< ; Params:
    //<< ;   YINHALT
    //<< ;   pstrStored      value of current key
    //<< ;   pobjForm        Form record                 WWW120
    //<< ;   pobjClsFld      Class Field record          WWW002      Class Key
    //<< ;   pobjCustFld     Customised Field record     WWW002D
    //<< ;
    //<< ; Returns:  boolean
    //<< ;
    //<< ; History:
    //<< ; 10-May-2007   RPW     SR15516: If this is a forced numerator and it's a
    //<< ;                           non-existent value and not +, let the user know with
    //<< ;                           the same message as validation
    //<< ; 10-Apr-2007   PO      SR15442: Force numerator
    //<< ; 28-Mar-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new blnOpen
    mVar blnOpen = m$.var("blnOpen");
    m$.newVar(blnOpen);
    //<< 
    //<< set blnOpen = $$$NO
    blnOpen.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if $$$WWW120FormType(pobjForm)'=7 {                    ; 7 - Search Engine
    if (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,pobjForm),7)) {
      //<< if '$$$NoKey(YINHALT) {
      if (mOp.Not(include.COMSYS.$$$NoKey(m$,YINHALT))) {
        //<< if $$PRIMCHK(pstrStored,pobjForm) {
        if (mOp.Logical(m$.fnc$("PRIMCHK",pstrStored.get(),pobjForm.get()))) {
          //<< if ($get(^WWWDATEN(0,+$horolog,YUSER,"RECORDEXISTS",YFORM,1)) = 1) {
          if ((mOp.Equal(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),"RECORDEXISTS",m$.var("YFORM").get(),1)),1))) {
            //<< set %TXT(1) = $$$Open
            m$.var("%TXT",1).set(include.COMSYS.$$$Open(m$));
          }
        }
        //<< }
        //<< 
        //<< } elseif $$$WWW002ForceNumerator(pobjClsFld) || $$$WWW002DForceNumerator(pobjCustFld) {
        else if (mOp.Logical(include.WWWConst.$$$WWW002ForceNumerator(m$,pobjClsFld)) || mOp.Logical(include.WWWConst.$$$WWW002DForceNumerator(m$,pobjCustFld))) {
          //<< $$$Alert($listbuild("WWW00028",YINHALT))        ; "´%1´ is invalid"
          include.COMSYS.$$$Alert(m$,m$.Fnc.$listbuild("WWW00028",YINHALT.get()));
          //<< set YINHALT = "+"
          YINHALT.set("+");
          //<< do Store(.YINHALT,.pstrStored)
          m$.Cmd.Do("Store",YINHALT,pstrStored);
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnOpen
    return blnOpen.get();
  }

  //<< 
  //<< 
  //<< Log(YFORM,YART,YLFN1,YSATZ)
  public Object Log(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLFN1 = m$.newVarRef("YLFN1",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YSATZ = m$.newVarRef("YSATZ",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Log aspects of event
    //<< ;
    //<< ; SURELY the following should not be done every time through WWWEVENT
    //<< ; Page and form should be done on form paint ?
    //<< ; Page is incorrect as field could be customised to be on another page.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Mar-2007   JW      SR15384: Encapsualted
    //<< ;-------------------------------------------------------------------------------
    //<< new intPage
    mVar intPage = m$.var("intPage");
    m$.newVar(intPage);
    //<< 
    //<< set $$$WWWUSERLastForm(^WWWUSER(0,YUSER,1)) = YFORM  ;LETZTES FORMULAR ;last form
    include.WWWConst.$$$WWWUSERLastFormSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),YFORM.get());
    //<< if (YART'="D") || (YLFN1="") {
    if ((mOp.NotEqual(YART.get(),"D")) || (mOp.Equal(YLFN1.get(),""))) {
      //<< set $$$WWWUSERLastFormfield(^WWWUSER(0,YUSER,1)) = ""
      include.WWWConst.$$$WWWUSERLastFormfieldSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
    }
    //<< 
    //<< } else {
    else {
      //<< set $$$WWWUSERLastFormfield(^WWWUSER(0,YUSER,1)) = YLFN1
      include.WWWConst.$$$WWWUSERLastFormfieldSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),YLFN1.get());
      //<< set intPage = $$$WWW122DisplayOnPageNumber(YSATZ)
      intPage.set(include.WWWConst.$$$WWW122DisplayOnPageNumber(m$,YSATZ));
      //<< set:intPage="" intPage = 1
      if (mOp.Equal(intPage.get(),"")) {
        intPage.set(1);
      }
      //<< set $$$WWWUSERLastFormpage(^WWWUSER(0,YUSER,1)) = intPage
      include.WWWConst.$$$WWWUSERLastFormpageSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),intPage.get());
    }
    //<< }
    //<< quit
    return null;
  }

//<< 
}
