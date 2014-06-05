//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWVAR
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:02
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

//<< WWWVAR
public class WWWVAR extends mClass {

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
    _WWWVAR();
  }

  public void _WWWVAR() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWVAR("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       LADEN VARIABLEN
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
    //<< ; 22-May-2013   shobby  CORE-107.1: Additional YPOPUP so that Menu is not shown on a search function within a popup.
    //<< ; 27-Jul-2012   SCR     SR18070: Record IP Address
    //<< ; 06-Aug-2010   shobby  SR17488: call to SET^WWWUSERAGENT
    //<< ; 27-Jul-2010   shobby  SR17457: YUSERAGENT if form is a popup window.
    //<< ; 18-Nov-2009   GRF     SR16871: Default to top level location rather than first
    //<< ;                           in order; clear out old comment code blocks
    //<< ; 21-Oct-2009   shobby  SR16948: Retrieve value of original URL (YXURL) for
    //<< ;                           storage in CacheTempURL
    //<< ; 02-Mar-2009   GRF     SR16065: Reverted change - breaks Help button
    //<< ; 27-Feb-2009   FIS     SR16065: force new YUSER after Cache re-start
    //<< ; 15-Jan-2009   GRF     SR15853: Pass audit string to NewUserSession
    //<< ; 20-Oct-2008   FIS     SR15824: pass flag YLOCKKILL to kill any lock during
    //<< ;                           form load
    //<< ; 19-Aug-2008   FIS     SR15853: create session in common routine
    //<< ; 01-Nov-2007   SCR     SR15606: Moved Session creation to a function.
    //<< ; 26-Oct-2007   SCR     SR15606: Added new Session Variable/Object %alSession
    //<< ;                           used for V2 code
    //<< ; 28-Jun-2006   GRF     Naked reference; quits; Doco; !=>||
    //<< ; 10-Nov-2005   JW      SR13817: Enable child users
    //<< ; 30-May-2005   RobertW SR12056: Attempt at Performance Increase
    //<< ; 25.11.2004    FIS     BROWSER TYP
    //<< ; 08.04.2004    FIS     25459;IMMER ALLE VARIABLEN LADEN
    //<< ; 10.03.2004    FIS     CUSTOMIZING;25301
    //<< ; 03.06.1998    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< do ^WWWVORG                              ; set standard variables
    m$.Cmd.Do("WWWVORG.main");
    //<< new idCountry,tmsNow,dteNow,tmeNow
    mVar idCountry = m$.var("idCountry");
    mVar tmsNow = m$.var("tmsNow");
    mVar dteNow = m$.var("dteNow");
    mVar tmeNow = m$.var("tmeNow");
    m$.newVar(idCountry,tmsNow,dteNow,tmeNow);
    //<< 
    //<< set tmsNow = $horolog
    tmsNow.set(m$.Fnc.$horolog());
    //<< set dteNow = +tmsNow
    dteNow.set(mOp.Positive(tmsNow.get()));
    //<< set tmeNow = $piece(tmsNow,$$$COMMA,2)
    tmeNow.set(m$.Fnc.$piece(tmsNow.get(),include.COMSYSString.$$$COMMA(m$),2));
    //<< 
    //<< SET YBED  = $GET(%(YQUERY,"YBED"))   ;BEDIENER
    mVar YBED = m$.var("YBED");
    YBED.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YBED")));
    //<< SET YUSER = $GET(%(YQUERY,"YUSER"))  ;USER NUMMER ;numeral
    mVar YUSER = m$.var("YUSER");
    YUSER.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YUSER")));
    //<< SET YPWD  = $GET(%(YQUERY,"YPWD"))   ;PASSWORD
    mVar YPWD = m$.var("YPWD");
    YPWD.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YPWD")));
    //<< SET YXURL = $GET(%(YQUERY,"YXURL"))  ;SR16948 (required)
    mVar YXURL = m$.var("YXURL");
    YXURL.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YXURL")));
    //<< set YPOPUP= $get(%(YQUERY,"YPOPUP")) ;CORE-107.1
    mVar YPOPUP = m$.var("YPOPUP");
    YPOPUP.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YPOPUP")));
    //<< 
    //<< IF $GET(%("env","REMOTE_PASSWD"))'="" SET YPWD=$GET(%("env","REMOTE_USER"))
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("%","env","REMOTE_PASSWD")),"")) {
      YPWD.set(m$.Fnc.$get(m$.var("%","env","REMOTE_USER")));
    }
    //<< 
    //<< 
    //<< ; FIXME:
    //<< ; For appropriate license count the User should request a new Session Id (YUSER) after Cache restart.
    //<< ; Because not all SessionId's are logged in CacheTemp (child users !) this test causes trouble in sub-windows (endless loop)
    //<< ;if ((YUSER '= "") && ('$data(^CacheTempSession(YUSER)))) set YUSER = ""  //after Cache re-start SR16065 - reverted
    //<< 
    //<< set YBED=$$$UPPER(YBED)
    YBED.set(include.COMSYSString.$$$UPPER(m$,YBED));
    //<< if YBED="" {
    if (mOp.Equal(YBED.get(),"")) {
      //<< set YBED="UNKNOWN"
      YBED.set("UNKNOWN");
      //<< set YUSER = $$NewUserSession^WWWUSER("WWWVAR:1")
      YUSER.set(m$.fnc$("WWWUSER.NewUserSession","WWWVAR:1"));
      //<< set %(YQUERY,"YUSER")=YUSER
      m$.var("%",m$.var("YQUERY").get(),"YUSER").set(YUSER.get());
      //<< set ^WWWUSER(0,YUSER,1)=Y_YBED
      m$.var("^WWWUSER",0,YUSER.get(),1).set(mOp.Concat(m$.var("Y").get(),YBED.get()));
    }
    //<< }
    //<< 
    //<< IF YBED="" SET YBED = "^^^"
    if (mOp.Equal(YBED.get(),"")) {
      YBED.set("^^^");
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  YBEX     objWWW013       personnel
    //<< ;  YUSER1   objWWWUSER
    //<< ;  YVOR1    objWWW012
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< IF $GET(YUSER)="" IF YBED'="" DO  ;NEUER USER ; new user
    if (mOp.Equal(m$.Fnc.$get(YUSER),"")) {
      if (mOp.NotEqual(YBED.get(),"")) {
        //<< . set YUSER = $$NewUserSession^WWWUSER("WWWVAR:2")
        YUSER.set(m$.fnc$("WWWUSER.NewUserSession","WWWVAR:2"));
        //<< . SET %(YQUERY,"YUSER")=YUSER
        m$.var("%",m$.var("YQUERY").get(),"YUSER").set(YUSER.get());
        //<< . SET ^WWWLOGIN(0,dteNow,tmeNow,YBED,1)=YUSER_Y_$$IPAddress()   ;LOGIN FILE ;SR18070
        m$.var("^WWWLOGIN",0,dteNow.get(),tmeNow.get(),YBED.get(),1).set(mOp.Concat(mOp.Concat(YUSER.get(),m$.var("Y").get()),m$.fnc$("IPAddress")));
        //<< . SET ^WWWUSER(0,YUSER,1)=$zconvert($GET(YPWD),"U")_Y_YBED_Y_dteNow_Y_tmeNow
        m$.var("^WWWUSER",0,YUSER.get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$zconvert(m$.Fnc.$get(YPWD),"U"),m$.var("Y").get()),YBED.get()),m$.var("Y").get()),dteNow.get()),m$.var("Y").get()),tmeNow.get()));
        //<< . IF $DATA(^WWW013(0,YBED,1)) DO
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW013",0,YBED.get(),1)))) {
          //<< . . NEW YBEX,YDH
          mVar YBEX = m$.var("YBEX");
          mVar YDH = m$.var("YDH");
          m$.newVarBlock(2,YBEX,YDH);
          //<< . . SET YBEX = ^WWW013(0,YBED,1)
          YBEX.set(m$.var("^WWW013",0,YBED.get(),1).get());
          //<< . . SET $PIECE(^WWWUSER(0,YUSER,1),Y,20) = $PIECE(YBEX,Y,5)
          m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),20).set(m$.Fnc.$piece(YBEX.get(),m$.var("Y").get(),5));
          //<< . . SET $PIECE(^WWWUSER(0,YUSER,1),Y,19) = $$^WWWLANGU(YBED)
          m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),19).set(m$.fnc$("WWWLANGU.main",YBED.get()));
          //<< . . SET $PIECE(^WWWUSER(0,YUSER,1),Y,35) = $$^WWWUSERAGENT()  ; BROWSER TYPE (MSIE, NETSCAPE, ...)
          m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),35).set(m$.fnc$("WWWUSERAGENT.main"));
          //<< . . SET YMENU = $PIECE(YBEX,Y,11)
          mVar YMENU = m$.var("YMENU");
          YMENU.set(m$.Fnc.$piece(YBEX.get(),m$.var("Y").get(),11));
          //<< . . SET YMFA  = $PIECE(YBEX,Y,10)
          mVar YMFA = m$.var("YMFA");
          YMFA.set(m$.Fnc.$piece(YBEX.get(),m$.var("Y").get(),10));
          //<< . . SET YA    = $PIECE(YBEX,Y,13)+1
          mVar YA = m$.var("YA");
          YA.set(mOp.Add(m$.Fnc.$piece(YBEX.get(),m$.var("Y").get(),13),1));
          //<< . . ;
          //<< . . ; FIXME : usage log should not kept withing employee master data. Should move to separate structure. <GRF>
          //<< . . ;
          //<< . . SET $PIECE(YBEX,Y,13) = YA
          m$.pieceVar(YBEX,m$.var("Y").get(),13).set(YA.get());
          //<< . . ;  "Your Visit No.: ##,  Last Visit: ##/##/##,##:##:##"
          //<< . . SET $PIECE(YBEX,Y,16) = $$^WWWTEXT(290)_" "_YA_",  "_$$^WWWTEXT(291)_" "_$$^WWWDATE($PIECE(YBEX,Y,14))_", "_$$^WWWTIME($PIECE(YBEX,Y,15))
          m$.pieceVar(YBEX,m$.var("Y").get(),16).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",290)," "),YA.get()),",  "),m$.fnc$("WWWTEXT.main",291))," "),m$.fnc$("WWWDATE.main",m$.Fnc.$piece(YBEX.get(),m$.var("Y").get(),14))),", "),m$.fnc$("WWWTIME.main",m$.Fnc.$piece(YBEX.get(),m$.var("Y").get(),15))));
          //<< . . SET $PIECE(YBEX,Y,14) = dteNow
          m$.pieceVar(YBEX,m$.var("Y").get(),14).set(dteNow.get());
          //<< . . SET $PIECE(YBEX,Y,15) = tmeNow
          m$.pieceVar(YBEX,m$.var("Y").get(),15).set(tmeNow.get());
          //<< . . SET ^WWW013(0,YBED,1) = YBEX
          m$.var("^WWW013",0,YBED.get(),1).set(YBEX.get());
          //<< . . SET YDH = $ORDER(^WWWZWS(0,""))    IF YDH'="" IF +YDH'=dteNow KILL ^WWWZWS(0,YDH)
          YDH.set(m$.Fnc.$order(m$.var("^WWWZWS",0,"")));
          if (mOp.NotEqual(YDH.get(),"")) {
            if (mOp.NotEqual(mOp.Positive(YDH.get()),dteNow.get())) {
              m$.var("^WWWZWS",0,YDH.get()).kill();
            }
          }
          //<< . . SET YDH = $ORDER(^WWWZWS(0,""),-1) IF YDH'="" IF +YDH'=dteNow KILL ^WWWZWS(0,YDH)
          YDH.set(m$.Fnc.$order(m$.var("^WWWZWS",0,""),mOp.Negative(1)));
          if (mOp.NotEqual(YDH.get(),"")) {
            if (mOp.NotEqual(mOp.Positive(YDH.get()),dteNow.get())) {
              m$.var("^WWWZWS",0,YDH.get()).kill();
            }
          }
        }
        m$.restoreVarBlock(2);
        //<< . ;
        //<< . SET YA=""
        mVar YA = m$.var("YA");
        YA.set("");
        //<< . FOR  SET YA=$ORDER(^WWWUSER(0,YA)) QUIT:YA=""  DO
        for (;true;) {
          YA.set(m$.Fnc.$order(m$.var("^WWWUSER",0,YA.get())));
          if (mOp.Equal(YA.get(),"")) {
            break;
          }
          do {
            //<< . . IF $GET(YMFA)'=0 QUIT:YA=YUSER
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YMFA")),0)) {
              if (mOp.Equal(YA.get(),YUSER.get())) {
                break;
              }
            }
            //<< . . IF $GET(YMFA)=1 IF $PIECE($GET(^WWWUSER(0,YA,1)),Y,2)=YBED KILL ^WWWUSER(0,YA) KILL ^WWWUSER1(0,YA) QUIT  ;FIS;06.05.04;NEU:WWWUSER1
            if (mOp.Equal(m$.Fnc.$get(m$.var("YMFA")),1)) {
              if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,YA.get(),1)),m$.var("Y").get(),2),YBED.get())) {
                m$.var("^WWWUSER",0,YA.get()).kill();
                m$.var("^WWWUSER1",0,YA.get()).kill();
                break;
              }
            }
            //<< . . IF ($PIECE($GET(^WWWUSER(0,YA,1)),Y,3)+1)<dteNow           KILL ^WWWUSER(0,YA) KILL ^WWWUSER1(0,YA) QUIT  ;FIS;06.05.04;NEU:WWWUSER1
            if (mOp.Less((mOp.Add(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,YA.get(),1)),m$.var("Y").get(),3),1)),dteNow.get())) {
              m$.var("^WWWUSER",0,YA.get()).kill();
              m$.var("^WWWUSER1",0,YA.get()).kill();
              break;
            }
          } while (false);
        }
      }
    }
    //<< 
    //<< ;SAVE USER VORGABEN;FIS;06.05.04;25460
    //<< ;WIRD EINE ROUTINE MIT JOB AUFGERUFEN, SIND DIE CSP-OBJEKTE NICHT MEHR VORHANDEN. IN DIESEM FALL
    //<< ;KANN ES WÜNSCHENSWERT SEIN, DIE CGI-VARIABLEN ZURPÜCKZUHOLEN (IN WWWVORG)
    //<< IF YHYPER'=0 IF $GET(YUSER)'="" DO
    if (mOp.NotEqual(m$.var("YHYPER").get(),0)) {
      if (mOp.NotEqual(m$.Fnc.$get(YUSER),"")) {
        //<< . NEW YVAR
        mVar YVAR = m$.var("YVAR");
        m$.newVarBlock(1,YVAR);
        //<< . IF '$DATA(^WWWUSER1(0,YUSER,"%KEY")) DO  ;IF NEW USER ONLY !
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWWUSER1",0,YUSER.get(),"%KEY")))) {
          //<< . . SET YVAR(1) = ""
          YVAR.var(1).set("");
          //<< . . FOR  SET YVAR(1) = $ORDER(%KEY(YVAR(1))) QUIT:YVAR(1)=""  DO
          for (;true;) {
            YVAR.var(1).set(m$.Fnc.$order(m$.var("%KEY",YVAR.var(1).get())));
            if (mOp.Equal(YVAR.var(1).get(),"")) {
              break;
            }
            do {
              //<< . . . IF $GET(%KEY(YVAR(1)))'=""     SET ^WWWUSER1(0,YUSER,"%KEY",YVAR(1)) = %KEY(YVAR(1)) QUIT  ;NUR EIN TEIL ;only uni- part
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("%KEY",YVAR.var(1).get())),"")) {
                m$.var("^WWWUSER1",0,YUSER.get(),"%KEY",YVAR.var(1).get()).set(m$.var("%KEY",YVAR.var(1).get()).get());
                break;
              }
              //<< . . . IF $ORDER(%KEY(YVAR(1),""))="" SET ^WWWUSER1(0,YUSER,"%KEY",YVAR(1)) = %KEY(YVAR(1)) QUIT  ;NUR EIN TEIL ;only uni- part
              if (mOp.Equal(m$.Fnc.$order(m$.var("%KEY",YVAR.var(1).get(),"")),"")) {
                m$.var("^WWWUSER1",0,YUSER.get(),"%KEY",YVAR.var(1).get()).set(m$.var("%KEY",YVAR.var(1).get()).get());
                break;
              }
              //<< . . . SET YVAR(2) = ""
              YVAR.var(2).set("");
              //<< . . . FOR  SET YVAR(2) = $ORDER(%KEY(YVAR(1),YVAR(2))) QUIT:YVAR(2)=""  DO
              for (;true;) {
                YVAR.var(2).set(m$.Fnc.$order(m$.var("%KEY",YVAR.var(1).get(),YVAR.var(2).get())));
                if (mOp.Equal(YVAR.var(2).get(),"")) {
                  break;
                }
                //<< . . . . SET ^WWWUSER1(0,YUSER,"%KEY",YVAR(1),YVAR(2)) = %KEY(YVAR(1),YVAR(2))
                m$.var("^WWWUSER1",0,YUSER.get(),"%KEY",YVAR.var(1).get(),YVAR.var(2).get()).set(m$.var("%KEY",YVAR.var(1).get(),YVAR.var(2).get()).get());
              }
            } while (false);
          }
        }
        //<< . ;
        //<< . IF '$DATA(^WWWUSER1(0,YUSER,"%CGIEVAR")) DO  ;IF NEW USER ONLY !
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWWUSER1",0,YUSER.get(),"%CGIEVAR")))) {
          //<< . . SET YVAR(1) = ""
          YVAR.var(1).set("");
          //<< . . FOR  SET YVAR(1)=$ORDER(%CGIEVAR(YVAR(1))) QUIT:YVAR(1)=""  DO
          for (;true;) {
            YVAR.var(1).set(m$.Fnc.$order(m$.var("%CGIEVAR",YVAR.var(1).get())));
            if (mOp.Equal(YVAR.var(1).get(),"")) {
              break;
            }
            do {
              //<< . . . IF $GET(%CGIEVAR(YVAR(1)))'=""     SET ^WWWUSER1(0,YUSER,"%CGIEVAR",YVAR(1)) = %CGIEVAR(YVAR(1)) QUIT  ;NUR EIN TEIL ;only uni- part
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("%CGIEVAR",YVAR.var(1).get())),"")) {
                m$.var("^WWWUSER1",0,YUSER.get(),"%CGIEVAR",YVAR.var(1).get()).set(m$.var("%CGIEVAR",YVAR.var(1).get()).get());
                break;
              }
              //<< . . . IF $ORDER(%CGIEVAR(YVAR(1),""))="" SET ^WWWUSER1(0,YUSER,"%CGIEVAR",YVAR(1)) = %CGIEVAR(YVAR(1)) QUIT  ;NUR EIN TEIL ;only uni- part
              if (mOp.Equal(m$.Fnc.$order(m$.var("%CGIEVAR",YVAR.var(1).get(),"")),"")) {
                m$.var("^WWWUSER1",0,YUSER.get(),"%CGIEVAR",YVAR.var(1).get()).set(m$.var("%CGIEVAR",YVAR.var(1).get()).get());
                break;
              }
              //<< . . . SET YVAR(2) = ""
              YVAR.var(2).set("");
              //<< . . . FOR  SET YVAR(2) = $ORDER(%CGIEVAR(YVAR(1),YVAR(2))) QUIT:YVAR(2)=""  DO
              for (;true;) {
                YVAR.var(2).set(m$.Fnc.$order(m$.var("%CGIEVAR",YVAR.var(1).get(),YVAR.var(2).get())));
                if (mOp.Equal(YVAR.var(2).get(),"")) {
                  break;
                }
                //<< . . . . SET ^WWWUSER1(0,YUSER,"%CGIEVAR",YVAR(1),YVAR(2)) = %CGIEVAR(YVAR(1),YVAR(2))
                m$.var("^WWWUSER1",0,YUSER.get(),"%CGIEVAR",YVAR.var(1).get(),YVAR.var(2).get()).set(m$.var("%CGIEVAR",YVAR.var(1).get(),YVAR.var(2).get()).get());
              }
            } while (false);
          }
        }
      }
      m$.restoreVarBlock(1);
    }
    //<< 
    //<< // FIXME : How much of the following is really necessary
    //<< SET YM = $GET(%(YQUERY,"YM"))  ;Company
    mVar YM = m$.var("YM");
    YM.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YM")));
    //<< IF YM="" SET YM = 0
    if (mOp.Equal(YM.get(),"")) {
      YM.set(0);
    }
    //<< 
    //<< set YLOCATION = $order(^WWW0121s(0,2,0," ",0,""))  ; Top Level
    mVar YLOCATION = m$.var("YLOCATION");
    YLOCATION.set(m$.Fnc.$order(m$.var("^WWW0121s",0,2,0," ",0,"")));
    //<< if YLOCATION="" set YLOCATION = 1                  ; FIXME : May not exist - see "get top level entity" logic elsewhere
    if (mOp.Equal(YLOCATION.get(),"")) {
      YLOCATION.set(1);
    }
    //<< 
    //<< if $piece($get(^WWWUSER(0,YUSER,1)),Y,35)'="" { ;SR17488
    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1)),m$.var("Y").get(),35),"")) {
      //<< do SET^WWWUSERAGENT($piece($get(^WWWUSER(0,YUSER,1)),Y,35))
      m$.Cmd.Do("WWWUSERAGENT.SET",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1)),m$.var("Y").get(),35));
    }
    //<< 
    //<< } else {
    else {
      //<< do SET^WWWUSERAGENT($piece($get(^WWWUSER(0,$piece(YUSER,"x",1),1)),Y,35))
      m$.Cmd.Do("WWWUSERAGENT.SET",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.Fnc.$piece(YUSER.get(),"x",1),1)),m$.var("Y").get(),35));
    }
    //<< }
    //<< ;SR17488SET YUSERAGENT = $PIECE($GET(^WWWUSER(0,YUSER,1)),Y,35)  ;FIS;25.11.2004;BROWSER TYP
    //<< ;SR17488if YUSERAGENT="" SET YUSERAGENT = $PIECE($GET(^WWWUSER(0,$piece(YUSER,"x",1),1)),Y,35) ;SR17454
    //<< 
    //<< ;SR17488IF YUSERAGENT="" SET YUSERAGENT = "MSIE"
    //<< 
    //<< if $get(YBED)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(YBED),"")) {
      //<< ; FIXME : Change YM to be always 0  - remove from WWWUSER and WWW013 once deprecated <GRF>
      //<< if YUSER'="" set YM = $$$WWWUSERLastCompany($get(^WWWUSER(0,YUSER,1)))
      if (mOp.NotEqual(YUSER.get(),"")) {
        YM.set(include.WWWConst.$$$WWWUSERLastCompany(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1))));
      }
      //<< if YM'=""    set YM = $$$WWW013HomeCompany($get(^WWW013(0,YBED,1)))
      if (mOp.NotEqual(YM.get(),"")) {
        YM.set(include.WWWConst.$$$WWW013HomeCompany(m$,m$.Fnc.$get(m$.var("^WWW013",0,YBED.get(),1))));
      }
      //<< if YM=""     set YM = 0
      if (mOp.Equal(YM.get(),"")) {
        YM.set(0);
      }
      //<< 
      //<< set YLOCATION = $$$WWW013HomeLocation($get(^WWW013(0,YBED,1)))
      YLOCATION.set(include.WWWConst.$$$WWW013HomeLocation(m$,m$.Fnc.$get(m$.var("^WWW013",0,YBED.get(),1))));
      //<< ;   if YLOCATION="" set YLOCATION = $order(^WWW0121(0,YM,""))          ; SR16871
      //<< if YLOCATION="" set YLOCATION = $order(^WWW0121s(0,2,0," ",0,""))  ; Top Level
      if (mOp.Equal(YLOCATION.get(),"")) {
        YLOCATION.set(m$.Fnc.$order(m$.var("^WWW0121s",0,2,0," ",0,"")));
      }
      //<< if YLOCATION="" set YLOCATION = 1
      if (mOp.Equal(YLOCATION.get(),"")) {
        YLOCATION.set(1);
      }
      //<< 
      //<< if $get(%(YQUERY,"YM"))'="" set YM = %(YQUERY,"YM")
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YM")),"")) {
        YM.set(m$.var("%",m$.var("YQUERY").get(),"YM").get());
      }
      //<< set SPRACHE = $$^WWWLANGU(YBED)
      mVar SPRACHE = m$.var("SPRACHE");
      SPRACHE.set(m$.fnc$("WWWLANGU.main",YBED.get()));
      //<< if $get(%(YQUERY,"YLOCATION"))'="" set YLOCATION = $get(%(YQUERY,"YLOCATION"))
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YLOCATION")),"")) {
        YLOCATION.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YLOCATION")));
      }
    }
    //<< }
    //<< 
    //<< set YUSER = $get(%(YQUERY,"YUSER"))
    YUSER.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YUSER")));
    //<< 
    //<< do CopyParent^WWWUSER(YUSER) //SR13942
    m$.Cmd.Do("WWWUSER.CopyParent",YUSER.get());
    //<< 
    //<< ;IF ($GET(YFORM)="") || ($EXTRACT($GET(EP),1,7)="WWWMANU") I $G(YUSER)'="" SET $PIECE(^WWWUSER(0,YUSER,1),Y,5)="",$PIECE(^WWWUSER(0,YUSER,1),Y,6)="",$PIECE(^WWWUSER(0,YUSER,1),Y,10)=""  ;NEUE SEITE
    //<< ;IF $GET(YFORM)="" I $G(YUSER)'="" SET $PIECE(^WWWUSER(0,YUSER,1),Y,5)="",$PIECE(^WWWUSER(0,YUSER,1),Y,6)="",$PIECE(^WWWUSER(0,YUSER,1),Y,10)=""  ;NEUE SEITE
    //<< SET YFORM = $GET(%(YQUERY,"YFORM"))        ;FORMULAR ;form
    mVar YFORM = m$.var("YFORM");
    YFORM.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YFORM")));
    //<< IF $GET(YHTMFORM)="" SET YHTMFORM = "WWW"  ;KEIN SAVE ;no
    if (mOp.Equal(m$.Fnc.$get(m$.var("YHTMFORM")),"")) {
      mVar YHTMFORM = m$.var("YHTMFORM");
      YHTMFORM.set("WWW");
    }
    //<< if (YHTMFORM="WWW") && (YFORM'="") && ($$$WWW120SaveServerdata($get(^WWW120(0,YFORM,1)))) set YHTMFORM="WWW2"
    if ((mOp.Equal(m$.var("YHTMFORM").get(),"WWW")) && (mOp.NotEqual(YFORM.get(),"")) && mOp.Logical((include.WWWConst.$$$WWW120SaveServerdata(m$,m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)))))) {
      mVar YHTMFORM = m$.var("YHTMFORM");
      YHTMFORM.set("WWW2");
    }
    //<< 
    //<< IF YUSER'="" DO                          ;SUCHEN ALTE VARIABLEN ;seek
    if (mOp.NotEqual(YUSER.get(),"")) {
      //<< . NEW YUSER1
      mVar YUSER1 = m$.var("YUSER1");
      m$.newVarBlock(1,YUSER1);
      //<< . SET YUSER1 = $GET(^WWWUSER(0,YUSER,1))
      YUSER1.set(m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1)));
      //<< . SET YPWD   = $PIECE(YUSER1,Y,1)
      YPWD.set(m$.Fnc.$piece(YUSER1.get(),m$.var("Y").get(),1));
      //<< . IF $PIECE(YUSER1,Y,20)'="" SET YM        = $PIECE(YUSER1,Y,20)
      if (mOp.NotEqual(m$.Fnc.$piece(YUSER1.get(),m$.var("Y").get(),20),"")) {
        YM.set(m$.Fnc.$piece(YUSER1.get(),m$.var("Y").get(),20));
      }
      //<< . IF $PIECE(YUSER1,Y,21)'="" SET YLOCATION = $PIECE(YUSER1,Y,21)
      if (mOp.NotEqual(m$.Fnc.$piece(YUSER1.get(),m$.var("Y").get(),21),"")) {
        YLOCATION.set(m$.Fnc.$piece(YUSER1.get(),m$.var("Y").get(),21));
      }
      //<< . SET YBSZ   = ""
      mVar YBSZ = m$.var("YBSZ");
      YBSZ.set("");
      //<< . SET YTRAKT = +$GET(%(YQUERY,"YTRAKT"))
      mVar YTRAKT = m$.var("YTRAKT");
      YTRAKT.set(mOp.Positive(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YTRAKT"))));
      //<< . ; NOTE : No class structure for ^WWWZWS
      //<< . IF '$DATA(^WWWZWS(0,dteNow,YUSER,YTRAKT)) SET YTRAKT = 0  ; VARIABLEN AUS SICHERHEITSKOPIE  ;FIS,06.03.03
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWWZWS",0,dteNow.get(),YUSER.get(),YTRAKT.get())))) {
        YTRAKT.set(0);
      }
      //<< . ;IF $PIECE($GET(^WWW012(0,YM,1)),Y,159)=1 SET YTRAKT = 0  ; IMMER ALLE VARIABLEN LADEN      ;FIS;25459;08.04.04
      //<< . IF $PIECE(YVOR1,Y,159)=1                  SET YTRAKT = 0  ; IMMER ALLE VARIABLEN LADEN
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),159),1)) {
        YTRAKT.set(0);
      }
      //<< . FOR YBSI=1:1 SET YBSZ=$ORDER(^WWWZWS(0,dteNow,YUSER,YTRAKT,YBSZ)) QUIT:YBSZ=""  DO
      mVar YBSI = m$.var("YBSI");
      for (YBSI.set(1);(true);YBSI.set(mOp.Add(YBSI.get(),1))) {
        YBSZ.set(m$.Fnc.$order(m$.var("^WWWZWS",0,dteNow.get(),YUSER.get(),YTRAKT.get(),YBSZ.get())));
        if (mOp.Equal(YBSZ.get(),"")) {
          break;
        }
        do {
          //<< . . QUIT:YBSZ="YBSZ"
          if (mOp.Equal(YBSZ.get(),"YBSZ")) {
            break;
          }
          //<< . . IF $EXTRACT(YBSZ)="V" IF $GET(LASTUSEDFORM)'="" IF $GET(YFORM)'=$GET(LASTUSEDFORM) QUIT   ;WENN FORMULARTAUSCH, DANN NICHT X VARIABLEN ÜBERTRAGEN
          if (mOp.Equal(m$.Fnc.$extract(YBSZ.get()),"V")) {
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("LASTUSEDFORM")),"")) {
              if (mOp.NotEqual(m$.Fnc.$get(YFORM),m$.Fnc.$get(m$.var("LASTUSEDFORM")))) {
                break;
              }
            }
          }
          //<< . . QUIT:YBSZ="SPRACHE"
          if (mOp.Equal(YBSZ.get(),"SPRACHE")) {
            break;
          }
          //<< . . QUIT:YBSZ="LANGUAGE"
          if (mOp.Equal(YBSZ.get(),"LANGUAGE")) {
            break;
          }
          //<< . . QUIT:$FIND(YBSZ," ")
          if (mOp.Logical(m$.Fnc.$find(YBSZ.get()," "))) {
            break;
          }
          //<< . . QUIT:$FIND(YBSZ,YQUERY)
          if (mOp.Logical(m$.Fnc.$find(YBSZ.get(),m$.var("YQUERY").get()))) {
            break;
          }
          //<< . . QUIT:$FIND(YBSZ,$CHAR(9))
          if (mOp.Logical(m$.Fnc.$find(YBSZ.get(),m$.Fnc.$char(9)))) {
            break;
          }
          //<< . . IF $DATA(^WWWZWS(0,dteNow,YUSER,YTRAKT,YBSZ,1)) SET @YBSZ = ^WWWZWS(0,dteNow,YUSER,YTRAKT,YBSZ,1)  ;USER VARIABLEN ZURÜCKHOLEN  ;FIS, 06.03.03
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWZWS",0,dteNow.get(),YUSER.get(),YTRAKT.get(),YBSZ.get(),1)))) {
            m$.indirectVar(YBSZ.get()).set(m$.var("^WWWZWS",0,dteNow.get(),YUSER.get(),YTRAKT.get(),YBSZ.get(),1).get());
          }
        } while (false);
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< if (+YM=0) && (YM'=0) set @YM=YM   ; VARIABLE=MANDANTENNAME, WENN NUMERISCH ;ACHTUNG, WENN YM GLEICH WICHTIGER NAME
    if ((mOp.Equal(mOp.Positive(YM.get()),0)) && (mOp.NotEqual(YM.get(),0))) {
      m$.indirectVar(YM.get()).set(YM.get());
    }
    //<< 
    //<< SET YCOUNTRY   = "DE"
    mVar YCOUNTRY = m$.var("YCOUNTRY");
    YCOUNTRY.set("DE");
    //<< set objWWW0121 = $get(^WWW0121(0,YM,YLOCATION,1))
    mVar objWWW0121 = m$.var("objWWW0121");
    objWWW0121.set(m$.Fnc.$get(m$.var("^WWW0121",0,YM.get(),YLOCATION.get(),1)));
    //<< set idCountry  = $$$WWW0121Country(objWWW0121)
    idCountry.set(include.WWWConst.$$$WWW0121Country(m$,objWWW0121));
    //<< if idCountry'=""    set YCOUNTRY = idCountry
    if (mOp.NotEqual(idCountry.get(),"")) {
      YCOUNTRY.set(idCountry.get());
    }
    //<< IF $GET(COUNTRY)="" SET COUNTRY  = YCOUNTRY     ;TYBD;19,2,2004;UNDEF IN LISTEN IN DENEN BUNDESLAND GENUZTZ WIRD
    if (mOp.Equal(m$.Fnc.$get(m$.var("COUNTRY")),"")) {
      mVar COUNTRY = m$.var("COUNTRY");
      COUNTRY.set(YCOUNTRY.get());
    }
    //<< 
    //<< SET YTARGET  = $PIECE($PIECE(YVOR1,Y,19),"/",1)_YUSER
    mVar YTARGET = m$.var("YTARGET");
    YTARGET.set(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),19),"/",1),YUSER.get()));
    //<< SET YTARGET2 = $PIECE($PIECE(YVOR1,Y,19),"/",2)
    mVar YTARGET2 = m$.var("YTARGET2");
    YTARGET2.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),19),"/",2));
    //<< 
    //<< ;=======================================
    //<< ;  Extract Variables from %("%KEY")
    //<< ;=======================================
    //<< 
    //<< SET YPARA    = $GET(%(YQUERY,"YPARA"))    ; PARAMETER - (Can be set by button definition)
    mVar YPARA = m$.var("YPARA");
    YPARA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YPARA")));
    //<< 
    //<< $$$LogRx("WWWVAR-YPARA"_YPARA)
    $$$LogRx(m$,mOp.Concat("WWWVAR-YPARA",YPARA.get()));
    //<< 
    //<< SET YAENBER  = $GET(%(YQUERY,"YAENBER"))  ; PARAMETER     ; 23883;TYBD;04,07,2003
    mVar YAENBER = m$.var("YAENBER");
    YAENBER.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YAENBER")));
    //<< IF $PIECE(YPARA,Y,2)'="" SET YAENBER = $PIECE(YPARA,Y,2)  ; Change Permission AUS NEUEM MENUPUNKT;23883;TYBD;04,07,2003
    if (mOp.NotEqual(m$.Fnc.$piece(YPARA.get(),m$.var("Y").get(),2),"")) {
      YAENBER.set(m$.Fnc.$piece(YPARA.get(),m$.var("Y").get(),2));
    }
    //<< SET YPARA    = $PIECE(YPARA,Y,1)          ; PARAMETER
    YPARA.set(m$.Fnc.$piece(YPARA.get(),m$.var("Y").get(),1));
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< SET YANZ     = $GET(%(YQUERY,"YANZ"))      ; Previous MENU Item
    mVar YANZ = m$.var("YANZ");
    YANZ.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YANZ")));
    //<< SET YAUSWAHL = $TRANSLATE($GET(%(YQUERY,"YAUSWAHL")),"|"," ")                  ; Search Value
    mVar YAUSWAHL = m$.var("YAUSWAHL");
    YAUSWAHL.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YAUSWAHL")),"|"," "));
    //<< SET YBACK    = $GET(%(YQUERY,"YBACK"))     ; List of Back forms
    mVar YBACK = m$.var("YBACK");
    YBACK.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YBACK")));
    //<< SET YBUTTON  = $GET(%(YQUERY,"YBUTTON"))   ; Last Button ;charge Button
    mVar YBUTTON = m$.var("YBUTTON");
    YBUTTON.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YBUTTON")));
    //<< SET YEXEC    = $TRANSLATE($GET(%(YQUERY,"YEXEC")),"'`|°"_$CHAR(194),""""_""""_" %") ; EXECUTE
    mVar YEXEC = m$.var("YEXEC");
    YEXEC.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YEXEC")),mOp.Concat("'`|°",m$.Fnc.$char(194)),mOp.Concat(mOp.Concat("\"","\"")," %")));
    //<< SET YFKEY    = $TRANSLATE($GET(%(YQUERY,"YFKEY")),"~|","# ")                   ; FIX KEY'S  XX,XXX,XX
    mVar YFKEY = m$.var("YFKEY");
    YFKEY.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YFKEY")),"~|","# "));
    //<< SET YFORM    = $GET(%(YQUERY,"YFORM"))     ; form
    YFORM.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YFORM")));
    //<< SET YINSEITE =+$GET(%(YQUERY,"YINSEITE"))  ; Inner page of a form
    mVar YINSEITE = m$.var("YINSEITE");
    YINSEITE.set(mOp.Positive(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YINSEITE"))));
    //<< ;---------------------------------------
    //<< SET YKEY     = $TRANSLATE($GET(%(YQUERY,"YKEY")),"~|"_$CHAR(194),"# ")         ; KEY'S  XX,XXX,XX
    mVar YKEY = m$.var("YKEY");
    YKEY.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YKEY")),mOp.Concat("~|",m$.Fnc.$char(194)),"# "));
    //<< ;SET YKEY=$$^WWWTRANSLATE(YKEY,"CHARACTERPLUS","+")
    //<< IF $EXTRACT(YKEY,$LENGTH(YKEY))="," SET YKEY=$EXTRACT(YKEY,1,$LENGTH(YKEY)-1)  ; Correct Key
    if (mOp.Equal(m$.Fnc.$extract(YKEY.get(),m$.Fnc.$length(YKEY.get())),",")) {
      YKEY.set(m$.Fnc.$extract(YKEY.get(),1,mOp.Subtract(m$.Fnc.$length(YKEY.get()),1)));
    }
    //<< SET YKEY1    = $TRANSLATE($GET(%(YQUERY,"YKEY1")),"|"_$CHAR(194)," ")          ; KEY1'S  XX,XXX,XX ; 8 Bit checking
    mVar YKEY1 = m$.var("YKEY1");
    YKEY1.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YKEY1")),mOp.Concat("|",m$.Fnc.$char(194))," "));
    //<< IF $EXTRACT(YKEY1,$LENGTH(YKEY1))="," SET YKEY1=$EXTRACT(YKEY1,1,$LENGTH(YKEY1)-1)  ; More Correction
    if (mOp.Equal(m$.Fnc.$extract(YKEY1.get(),m$.Fnc.$length(YKEY1.get())),",")) {
      YKEY1.set(m$.Fnc.$extract(YKEY1.get(),1,mOp.Subtract(m$.Fnc.$length(YKEY1.get()),1)));
    }
    //<< ;---------------------------------------
    //<< SET YKILL    = $GET(%(YQUERY,"YKILL"))     ; 1=Kill it ;2=Delete after Showing it (Half Kill)
    mVar YKILL = m$.var("YKILL");
    YKILL.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YKILL")));
    //<< SET YMOUSETR = $GET(%(YQUERY,"YMOUSETR"))  ; MOUSE TRAIL
    mVar YMOUSETR = m$.var("YMOUSETR");
    YMOUSETR.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YMOUSETR")));
    //<< SET YNAME    = $TRANSLATE($GET(%(YQUERY,"YNAME")),"|"," ")  ; Header
    mVar YNAME = m$.var("YNAME");
    YNAME.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YNAME")),"|"," "));
    //<< SET YNEW     =+$GET(%(YQUERY,"YNEW"))      ; 1=NEW BUTTON Pressed
    mVar YNEW = m$.var("YNEW");
    YNEW.set(mOp.Positive(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YNEW"))));
    //<< SET YNOKEY   = $GET(%(YQUERY,"YNOKEY"))    ; Back jump with no keys
    mVar YNOKEY = m$.var("YNOKEY");
    YNOKEY.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YNOKEY")));
    //<< SET YNUMMER  = $GET(%(YQUERY,"YNUMMER"))   ; Last used Number  ;charge Number
    mVar YNUMMER = m$.var("YNUMMER");
    YNUMMER.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YNUMMER")));
    //<< ;SET YOLDVAL = $GET(%(YQUERY,"YOLDVAL"))   ; ALTER VALUE; old value
    //<< SET YOPEN    = $GET(%(YQUERY,"YOPEN"))     ; 1=OPEN OLD Record
    mVar YOPEN = m$.var("YOPEN");
    YOPEN.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YOPEN")));
    //<< SET YOPTION  = $GET(%(YQUERY,"YOPTION"))   ; PARAMETER
    mVar YOPTION = m$.var("YOPTION");
    YOPTION.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YOPTION")));
    //<< SET YOPTION1 = $GET(%(YQUERY,"YOPTION1"))  ; PARAMETER
    mVar YOPTION1 = m$.var("YOPTION1");
    YOPTION1.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YOPTION1")));
    //<< SET YORIENT  = $GET(%(YQUERY,"YORIENT"))   ; Orientation
    mVar YORIENT = m$.var("YORIENT");
    YORIENT.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YORIENT")));
    //<< SET YPRINT   = $GET(%(YQUERY,"YPRINT"))    ; 1=WINDOW.PRINT()
    mVar YPRINT = m$.var("YPRINT");
    YPRINT.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YPRINT")));
    //<< SET YRETURN  = $GET(%(YQUERY,"YRETURN"))   ; 1=Back from a previous form
    mVar YRETURN = m$.var("YRETURN");
    YRETURN.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YRETURN")));
    //<< SET YLOCKKILL= $GET(%(YQUERY,"YLOCKKILL")) ; 1=Kill any lock when loading form ;SR15824
    mVar YLOCKKILL = m$.var("YLOCKKILL");
    YLOCKKILL.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YLOCKKILL")));
    //<< ;---------------------------------------
    //<< SET YRICHT   = $GET(%(YQUERY,"YRICHT"))    ; Next / Last Key ;charge Key
    mVar YRICHT = m$.var("YRICHT");
    YRICHT.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YRICHT")));
    //<< IF $GET(%(YQUERY,"YRICHT1"))'="" SET YRICHT = $GET(%(YQUERY,"YRICHT1")) SET %(YQUERY,"YRICHT")=YRICHT
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YRICHT1")),"")) {
      YRICHT.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YRICHT1")));
      m$.var("%",m$.var("YQUERY").get(),"YRICHT").set(YRICHT.get());
    }
    //<< ;---------------------------------------
    //<< SET YSCREENM = $GET(%(YQUERY,"YSCREENM"))  ; Test Mode
    mVar YSCREENM = m$.var("YSCREENM");
    YSCREENM.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YSCREENM")));
    //<< IF YSCREENM="" SET YSCREENM = $GET(%(YQUERY,"YSCREENM",1))  ;SCREEN MOVEMENT TEST
    if (mOp.Equal(YSCREENM.get(),"")) {
      YSCREENM.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YSCREENM",1)));
    }
    //<< ;---------------------------------------
    //<< SET YSEITE   =+$GET(%(YQUERY,"YSEITE"))    ; Tab Number
    mVar YSEITE = m$.var("YSEITE");
    YSEITE.set(mOp.Positive(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YSEITE"))));
    //<< ;IF YSEITE=0 SET YSEITE = 1                ; MINDESTENS DIE SEITE 1 ;table-mat who side
    //<< ;---------------------------------------
    //<< SET YSIZE    = $GET(%(YQUERY,"YSIZE"))     ; Text Size
    mVar YSIZE = m$.var("YSIZE");
    YSIZE.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YSIZE")));
    //<< SET YSUCH    = $GET(%(YQUERY,"YSUCH"))     ; Search Number
    mVar YSUCH = m$.var("YSUCH");
    YSUCH.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YSUCH")));
    //<< ;---------------------------------------
    //<< SET YUCI     = $GET(%(YQUERY,"YUCI"))      ; NAMESPACE
    mVar YUCI = m$.var("YUCI");
    YUCI.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YUCI")));
    //<< IF YUCI="" SET YUCI = $ZUTIL(5)            ; EIGENER NAMESPACE; TYBD;18,12,2003
    if (mOp.Equal(YUCI.get(),"")) {
      YUCI.set(m$.Fnc.$zutil(5));
    }
    //<< IF YUCI="" SET YUCI = "USER"               ; DFLT NAMESPACE
    if (mOp.Equal(YUCI.get(),"")) {
      YUCI.set("USER");
    }
    //<< ;---------------------------------------
    //<< SET YUSERPROFILE = $GET(%(YQUERY,"YUSERPROFILE"))
    mVar YUSERPROFILE = m$.var("YUSERPROFILE");
    YUSERPROFILE.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YUSERPROFILE")));
    //<< SET YVORGABE     = $TRANSLATE($GET(%(YQUERY,"YVORGABE")),"|"," ")  ;Hidden Search Value
    mVar YVORGABE = m$.var("YVORGABE");
    YVORGABE.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YVORGABE")),"|"," "));
    //<< 
    //<< ;=======================================
    //<< 
    //<< IF SPRACHE="" SET SPRACHE = "EN"
    if (mOp.Equal(m$.var("SPRACHE").get(),"")) {
      mVar SPRACHE = m$.var("SPRACHE");
      SPRACHE.set("EN");
    }
    //<< SET LANGUAGE = SPRACHE
    mVar LANGUAGE = m$.var("LANGUAGE");
    LANGUAGE.set(m$.var("SPRACHE").get());
    //<< 
    //<< ;Test for back jump KEY´S
    //<< IF YNOKEY'="" IF YFORM=YNOKEY SET YKEY="" SET %(YQUERY,"YKEY")="",%KEY("YKEY")="" KILL YNOKEY  ; If a back with other vars, change the back key
    if (mOp.NotEqual(YNOKEY.get(),"")) {
      if (mOp.Equal(YFORM.get(),YNOKEY.get())) {
        YKEY.set("");
        m$.var("%",m$.var("YQUERY").get(),"YKEY").set("");
        m$.var("%KEY","YKEY").set("");
        YNOKEY.kill();
      }
    }
    //<< IF (+YSCREENM=1) || (+YSCREENM=3)  DO      ;Change Screen Position ;FIS;CUSTOMIZING;10.03.04;25301
    if ((mOp.Equal(mOp.Positive(YSCREENM.get()),1)) || (mOp.Equal(mOp.Positive(YSCREENM.get()),3))) {
      //<< . SET YSCR   = $GET(%(YQUERY,"YSCR"))      ;Screen Mode
      mVar YSCR = m$.var("YSCR");
      YSCR.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YSCR")));
      //<< . IF YSCR="" SET YSCR=$GET(%(YQUERY,"YSCR",1))  ;
      if (mOp.Equal(YSCR.get(),"")) {
        YSCR.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YSCR",1)));
      }
      //<< . IF YSCR'="" IF $EXTRACT(YSCR,1,4)'="CUST" DO ^WWWSCRA   ; Edit Field Positions
      if (mOp.NotEqual(YSCR.get(),"")) {
        if (mOp.NotEqual(m$.Fnc.$extract(YSCR.get(),1,4),"CUST")) {
          m$.Cmd.Do("WWWSCRA.main");
        }
      }
      //<< . IF YSCR'="" IF $EXTRACT(YSCR,1,4)="CUST"  DO ^WWWSCRAD  ; Edit Field Positions CUSTOMIZING
      if (mOp.NotEqual(YSCR.get(),"")) {
        if (mOp.Equal(m$.Fnc.$extract(YSCR.get(),1,4),"CUST")) {
          m$.Cmd.Do("WWWSCRAD.main");
        }
      }
      //<< . SET %("VAR","YSCR")=""
      m$.var("%","VAR","YSCR").set("");
    }
    //<< 
    //<< SET YANZAHL = $GET(%(YQUERY,"YANZAHL"))    ;Number of items shown on search
    mVar YANZAHL = m$.var("YANZAHL");
    YANZAHL.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YANZAHL")));
    //<< SET YSORT   = $GET(%(YQUERY,"YSORT"))      ;Sort Index
    mVar YSORT = m$.var("YSORT");
    YSORT.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YSORT")));
    //<< IF YSORT<0 SET YSORT=0
    if (mOp.Less(YSORT.get(),0)) {
      YSORT.set(0);
    }
    //<< IF YSORT'="" IF YSORT'=0 SET YAUSWAHL=$$^WWWUMLAU(YAUSWAHL,2),YVORGABE=$$^WWWUMLAU(YVORGABE,2)
    if (mOp.NotEqual(YSORT.get(),"")) {
      if (mOp.NotEqual(YSORT.get(),0)) {
        YAUSWAHL.set(m$.fnc$("WWWUMLAU.main",YAUSWAHL.get(),2));
        YVORGABE.set(m$.fnc$("WWWUMLAU.main",YVORGABE.get(),2));
      }
    }
    //<< IF $TRANSLATE(YBACK,",")="" SET YBACK=""
    if (mOp.Equal(m$.Fnc.$translate(YBACK.get(),","),"")) {
      YBACK.set("");
    }
    //<< IF YUSER'="" SET $PIECE(^WWWUSER(0,YUSER,1),Y,20) = YM
    if (mOp.NotEqual(YUSER.get(),"")) {
      m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),20).set(YM.get());
    }
    //<< IF YUSER'="" SET $PIECE(^WWWUSER(0,YUSER,1),Y,21) = YLOCATION
    if (mOp.NotEqual(YUSER.get(),"")) {
      m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),21).set(YLOCATION.get());
    }
    //<< IF $GET(%(YQUERY,"YLOCKBACK"))'="" SET $PIECE(^WWWUSER(0,YUSER,1),Y,25)=$GET(%(YQUERY,"YLOCKBACK"))  ;FIS;19.04.04;TRAKTNR. FÜR RÜCKHOLEN LOCK BEI SCHLIESSEN;25534
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YLOCKBACK")),"")) {
      m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),25).set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YLOCKBACK")));
    }
    //<< 
    //<< ; Transaction Tracking
    //<< SET YTRAKT    = $GET(%(YQUERY,"YTRAKT"))
    mVar YTRAKT = m$.var("YTRAKT");
    YTRAKT.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YTRAKT")));
    //<< SET YTRAKTOLD = YTRAKT
    mVar YTRAKTOLD = m$.var("YTRAKTOLD");
    YTRAKTOLD.set(YTRAKT.get());
    //<< IF (YUSER'="") && (+YTRAKT=0) {       ;if new option, start at top
    if ((mOp.NotEqual(YUSER.get(),"")) && (mOp.Equal(mOp.Positive(YTRAKT.get()),0))) {
      //<< set $PIECE(^WWWUSER(0,YUSER,1),Y,5)  = 0     ; $$$WWWUSERHTMLStarted
      m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),5).set(0);
      //<< set $PIECE(^WWWUSER(0,YUSER,1),Y,6)  = 0
      m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),6).set(0);
      //<< set $PIECE(^WWWUSER(0,YUSER,1),Y,9)  = 0
      m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),9).set(0);
      //<< set $PIECE(^WWWUSER(0,YUSER,1),Y,10) = 0
      m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),10).set(0);
    }
    //<< }
    //<< set $piece(^WWWUSER(0,YUSER,1),Y,36)=$$IPAddress() ;SR18070
    m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),36).set(m$.fnc$("IPAddress"));
    //<< SET YTRAKT0 = 0
    mVar YTRAKT0 = m$.var("YTRAKT0");
    YTRAKT0.set(0);
    //<< ;I +YTRAKT'=0 I YUSER'="" I (YTRAKT+12)<$P($G(^WWWUSER(0,YUSER,1)),Y,7) S YTRAKT0=1  ;NUR WENN RÜCK VERBOTEN
    //<< IF YUSER'="" IF '$FIND($GET(YOPEN),"^") SET YTRAKT=$$^WWWTRAKT(YUSER)  ; Next Session sequence number (transaction number)
    if (mOp.NotEqual(YUSER.get(),"")) {
      if (mOp.Not(m$.Fnc.$find(m$.Fnc.$get(YOPEN),"^"))) {
        YTRAKT.set(m$.fnc$("WWWTRAKT.main",YUSER.get()));
      }
    }
    //<< IF $GET(YBED)'="" SET SPRACHE=$$^WWWLANGU(YBED)
    if (mOp.NotEqual(m$.Fnc.$get(YBED),"")) {
      mVar SPRACHE = m$.var("SPRACHE");
      SPRACHE.set(m$.fnc$("WWWLANGU.main",YBED.get()));
    }
    //<< ;K %(YQUERY,"YTRAKT")
    //<< ;S %("VAR","YTRAKT")=0
    //<< 
    //<< do Session
    m$.Cmd.Do("Session");
    //<< quit
    return;
  }

  //<< 
  //<< IPAddress()
  public Object IPAddress(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return IP Address if available
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 27-Jul-2012   SCR     SR18070: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strIP
    mVar strIP = m$.var("strIP");
    m$.newVar(strIP);
    //<< set strIP=""
    strIP.set("");
    //<< if $isobject($get(%request)) {
    if (mOp.Logical(m$.Fnc.$isobject(m$.Fnc.$get(m$.getRequest())))) {
      //<< set strIP =$get(%request.CgiEnvs("REMOTE_ADDR"))
      strIP.set(m$.Fnc.$get(m$.getRequest().getCgiEnvs("REMOTE_ADDR")));
    }
    //<< }
    //<< quit strIP
    return strIP.get();
  }

  //<< 
  //<< 
  //<< Session
  public void Session() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create a V2 Session based on V1 Session Variables
    //<< ;
    //<< ; Returns (implicit) :
    //<< ;   The %alSession object will contain all the session variable required by @NM
    //<< ;
    //<< ; History:
    //<< ; 01-Nov-2007   SCR     SR15606: Added new Session Variable/Object %alSession
    //<< ;                           used for V2 code
    //<< ;-------------------------------------------------------------------------------
    //<< set $ztrap="SessionError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("SessionError");
    //<< 
    //<< //if '$data(%alSession) {
    //<< //  set %alSession=##class(alSYS.Session.iSession).Create()
    //<< //}
    //<< quit
    return;
  }

  //<< 
  //<< SessionError
  public Object SessionError() {
    //<< ; Session Error handler
    //<< ; TODO Something
    //<< quit
    return null;
  }

  //<< 
  //<< WSSession(pidUser)
  public Object WSSession(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create a @NM Session for
    //<< ;
    //<< ; Returns YUSER :
    //<< ;
    //<< ; History:
    //<< ; 23-Jun-2011   SCR     SR17809: Create a Session and pass back to WS
    //<< ;-------------------------------------------------------------------------------
    //<< set YBED=pidUser
    mVar YBED = m$.var("YBED");
    YBED.set(pidUser.get());
    //<< do ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< quit $Get(YUSER)
    return m$.Fnc.$get(m$.var("YUSER"));
  }

}
