//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSEAR
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-11 15:26:01
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

//<< WWWSEAR
public class WWWSEAR extends mClass {

  public void main() {
    _WWWSEAR();
  }

  public void _WWWSEAR() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Search form. If using COMView jump out of this routine.     ;SUCHFUNKTION
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2007   shobby  SRBR014748: Use standard routine to validate passwords.
    //<< ; 12-Jun-2007   GRF     SR15543: Naked references; doco; quits
    //<< ; 08-Dec-2006   PO      SR15276: Changed name of EventBroker to JSLibraries
    //<< ;  2-Jun-2006   JW      SR14697: Always use eventbrokeren1.js
    //<< ; 07-Jul-2005   shobby  SR12892: WWW1263 is no longer shared.
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase. Also note
    //<< ;                       COMViewSetup.OBJ exists.
    //<< ; 22-Mar-2005   Paul K  SR11912: Changed to check for existance of COMViewSetup
    //<< ;                       routine before calling COMView
    //<< ; 11.08.1997    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< NEW (%request,%session,%KEY,%,%ZCS,%CGIEVAR,YTIMEFORM)
    mVar YTIMEFORM = m$.var("YTIMEFORM");
    m$.newVarExcept(YTIMEFORM);
    //<< 
    //<< SET $ZTRAP="^WWWERROR"
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("^WWWERROR");
    //<< DO ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< ;IF ($$EXIST^%R("COMViewSetup.OBJ",$GET(YUCI)))&&($PIECE($GET(^COMViewConfig(0,YM,1)),Y,9)=1)&&('$get(YTIMEFORM)) {
    //<< IF ($PIECE($GET(^COMViewConfig(0,YM,1)),Y,9)=1)&&('$get(YTIMEFORM)) {
    if ((mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^COMViewConfig",0,m$.var("YM").get(),1)),m$.var("Y").get(),9),1)) && (mOp.Not(m$.Fnc.$get(YTIMEFORM)))) {
      //<< set YPARA=$zconvert($listbuild(YFORM,"",$get(YFKEY)),"o","URL") ; SR11661
      mVar YPARA = m$.var("YPARA");
      YPARA.set(m$.Fnc.$zconvert(m$.Fnc.$listbuild(m$.var("YFORM").get(),"",m$.Fnc.$get(m$.var("YFKEY"))),"o","URL"));
      //<< do RedirectForm^COMUtilForm("COMViewSearch","",YFORM_",",YPARA,YSEITE)
      m$.Cmd.Do("COMUtilForm.RedirectForm","COMViewSearch","",mOp.Concat(m$.var("YFORM").get(),","),YPARA.get(),m$.var("YSEITE").get());
      //<< quit
      return;
    }
    //<< }
    //<< 
    //<< ;Berechtigung ;Users Access
    //<< IF '$DATA(^WWW013(0,YBED)) DO ^WWWINFO($$^WWWTEXT(5)) QUIT  ;KEINE BERECHTIGUNG ;no
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW013",0,m$.var("YBED").get())))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< ;IF $$^WWWPWDCHECK($PIECE(^WWW013(0,YBED,1),Y,2))'=YPWD DO ^WWWINFO($$^WWWTEXT(5)) QUIT
    //<< ;IF $$^WWWUPER($$^WWWPWDCHECK($PIECE(^WWW013(0,YBED,1),Y,2)))'=$$^WWWUPER(YPWD) DO ^WWWINFO($$^WWWTEXT(5)) QUIT     ;BEC;21.07.04;26124
    //<< ; BR014748 IF $zconvert($$^WWWPWDCHECK($PIECE(^WWW013(0,YBED,1),Y,2)),"U")'=$zconvert(YPWD,"U") DO ^WWWINFO($$^WWWTEXT(5)) QUIT     ;BEC;21.07.04;26124
    //<< IF '$$CHECK^WWWPWDCHECK($PIECE(^WWW013(0,YBED,1),Y,2),YPWD) DO ^WWWINFO($$^WWWTEXT(5)) QUIT     ;BEC;21.07.04;26124
    if (mOp.Not(m$.fnc$("WWWPWDCHECK.CHECK",m$.Fnc.$piece(m$.var("^WWW013",0,m$.var("YBED").get(),1).get(),m$.var("Y").get(),2),m$.var("YPWD").get()))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< SET YVOR = ^WWW013(0,YBED,1)
    mVar YVOR = m$.var("YVOR");
    YVOR.set(m$.var("^WWW013",0,m$.var("YBED").get(),1).get());
    //<< SET YBER = $PIECE(YVOR,Y,3)
    mVar YBER = m$.var("YBER");
    YBER.set(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),3));
    //<< SET YMOD = $PIECE(YVOR,Y,4)
    mVar YMOD = m$.var("YMOD");
    YMOD.set(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),4));
    //<< IF YUSER'="" DO
    if (mOp.NotEqual(m$.var("YUSER").get(),"")) {
      //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,5)  = ""         ; $$$WWWUSERHTMLStarted
      m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),5).set("");
      //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,6)  = ""
      m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),6).set("");
      //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,9)  = ""
      m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),9).set("");
      //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,10) = ""
      m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),10).set("");
    }
    //<< 
    //<< ;layout
    //<< DO ^WWWFORMX  ;VORGABEN
    m$.Cmd.Do("WWWFORMX.main");
    //<< SET YSUCH1=""
    mVar YSUCH1 = m$.var("YSUCH1");
    YSUCH1.set("");
    //<< IF YSUCH="" SET YSUCH=$ORDER(^WWW123(0,YFORM,""))
    if (mOp.Equal(m$.var("YSUCH").get(),"")) {
      mVar YSUCH = m$.var("YSUCH");
      YSUCH.set(m$.Fnc.$order(m$.var("^WWW123",0,m$.var("YFORM").get(),"")));
    }
    //<< IF YSUCH'="" IF $PIECE($GET(^WWW123(0,YFORM,YSUCH,1)),Y,13)'=""  IF $ORDER(^WWW123(0,YFORM,YSUCH))'="" SET YSUCH=$ORDER(^WWW123(0,YFORM,YSUCH))
    if (mOp.NotEqual(m$.var("YSUCH").get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW123",0,m$.var("YFORM").get(),m$.var("YSUCH").get(),1)),m$.var("Y").get(),13),"")) {
        if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW123",0,m$.var("YFORM").get(),m$.var("YSUCH").get())),"")) {
          mVar YSUCH = m$.var("YSUCH");
          YSUCH.set(m$.Fnc.$order(m$.var("^WWW123",0,m$.var("YFORM").get(),m$.var("YSUCH").get())));
        }
      }
    }
    //<< IF YSUCH'="" IF $PIECE($GET(^WWW123(0,YFORM,YSUCH,1)),Y,13)'=""  IF $ORDER(^WWW123(0,YFORM,YSUCH))'="" SET YSUCH=$ORDER(^WWW123(0,YFORM,YSUCH))
    if (mOp.NotEqual(m$.var("YSUCH").get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW123",0,m$.var("YFORM").get(),m$.var("YSUCH").get(),1)),m$.var("Y").get(),13),"")) {
        if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW123",0,m$.var("YFORM").get(),m$.var("YSUCH").get())),"")) {
          mVar YSUCH = m$.var("YSUCH");
          YSUCH.set(m$.Fnc.$order(m$.var("^WWW123",0,m$.var("YFORM").get(),m$.var("YSUCH").get())));
        }
      }
    }
    //<< IF YSUCH'="" SET YSUCH1=$GET(^WWW123(0,YFORM,YSUCH,1))
    if (mOp.NotEqual(m$.var("YSUCH").get(),"")) {
      YSUCH1.set(m$.Fnc.$get(m$.var("^WWW123",0,m$.var("YFORM").get(),m$.var("YSUCH").get(),1)));
    }
    //<< IF $PIECE(YSUCH1,Y,4)'="" DO  ;VON DIETMAR WACH ;open-eyed
    if (mOp.NotEqual(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4),"")) {
      //<< . IF YKEY="" SET YKEY=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"P",1))
      if (mOp.Equal(m$.var("YKEY").get(),"")) {
        mVar YKEY = m$.var("YKEY");
        YKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1)));
      }
      //<< . FOR %I=1:1:$LENGTH($PIECE(YSUCH1,Y,4),",") IF $PIECE(YSUCH1,",",%I)'="" SET YFKEY=$PIECE(YKEY,",",+$PIECE($PIECE(YSUCH1,Y,4),",",%I))_","
      for (m$.var("%I").set(1);(mOp.LessOrEqual(m$.var("%I").get(),m$.Fnc.$length(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4),",")));m$.var("%I").set(mOp.Add(m$.var("%I").get(),1))) {
        if (mOp.NotEqual(m$.Fnc.$piece(YSUCH1.get(),",",m$.var("%I").get()),"")) {
          mVar YFKEY = m$.var("YFKEY");
          YFKEY.set(mOp.Concat(m$.Fnc.$piece(m$.var("YKEY").get(),",",mOp.Positive(m$.Fnc.$piece(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4),",",m$.var("%I").get()))),","));
        }
      }
      //<< . IF $EXTRACT(YFKEY,$LENGTH(YFKEY))="," SET YFKEY=$EXTRACT(YFKEY,1,($LENGTH(YFKEY)-1))
      if (mOp.Equal(m$.Fnc.$extract(m$.var("YFKEY").get(),m$.Fnc.$length(m$.var("YFKEY").get())),",")) {
        mVar YFKEY = m$.var("YFKEY");
        YFKEY.set(m$.Fnc.$extract(m$.var("YFKEY").get(),1,(mOp.Subtract(m$.Fnc.$length(m$.var("YFKEY").get()),1))));
      }
    }
    //<< 
    //<< IF YFKEY="," SET YFKEY=""
    if (mOp.Equal(m$.var("YFKEY").get(),",")) {
      mVar YFKEY = m$.var("YFKEY");
      YFKEY.set("");
    }
    //<< SET YDATEI=$PIECE(YSUCH1,Y,2)
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),2));
    //<< IF YDATEI="" SET YDATEI=$PIECE($GET(^WWW120(0,YFORM,1)),Y,11)
    if (mOp.Equal(YDATEI.get(),"")) {
      YDATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),11));
    }
    //<< IF YDATEI="" DO ^WWWINFO($$^WWWTEXT(140)) QUIT    ;KEINE DATEI ;no data file
    if (mOp.Equal(YDATEI.get(),"")) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",140));
      return;
    }
    //<< IF $PIECE($GET(^WWW001(0,YDATEI,1)),Y,8)=5 DO  ;DATEI FUER PROGRAMME ;data file
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)),m$.var("Y").get(),8),5)) {
      //<< . DO ^WWWROUTINELIST
      m$.Cmd.Do("WWWROUTINELIST.main");
    }
    //<< 
    //<< SET YKOPF=$PIECE(YSUCH1,Y,1)
    mVar YKOPF = m$.var("YKOPF");
    YKOPF.set(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),1));
    //<< IF YKOPF=""  SET YKOPF=$PIECE(YSUCH1,Y,2)
    if (mOp.Equal(YKOPF.get(),"")) {
      YKOPF.set(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),2));
    }
    //<< IF YKOPF'="" SET YKOPF=$$^WWWTEXT(YKOPF)                        ;bec;12.06.03;23787;Text tiltleleiste
    if (mOp.NotEqual(YKOPF.get(),"")) {
      YKOPF.set(m$.fnc$("WWWTEXT.main",YKOPF.get()));
    }
    //<< IF YKOPF="" IF YNAME="" DO
    if (mOp.Equal(YKOPF.get(),"")) {
      if (mOp.Equal(m$.var("YNAME").get(),"")) {
        do {
          //<< . IF $DATA(^WWW0011(0,YDATEI,SPRACHE,1)) SET YNAME=$PIECE(^WWW0011(0,YDATEI,SPRACHE,1),Y,1) QUIT          ; SR15543 Naked Ref
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0011",0,YDATEI.get(),m$.var("SPRACHE").get(),1)))) {
            mVar YNAME = m$.var("YNAME");
            YNAME.set(m$.Fnc.$piece(m$.var("^WWW0011",0,YDATEI.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
            break;
          }
          //<< . SET YNAME=$PIECE($GET(^WWW001(0,YDATEI,1)),Y,1)
          mVar YNAME = m$.var("YNAME");
          YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)),m$.var("Y").get(),1));
        } while (false);
      }
    }
    //<< 
    //<< IF YKOPF="" SET YKOPF=YNAME
    if (mOp.Equal(YKOPF.get(),"")) {
      YKOPF.set(m$.var("YNAME").get());
    }
    //<< IF YNAME="" SET YNAME=YKOPF
    if (mOp.Equal(m$.var("YNAME").get(),"")) {
      mVar YNAME = m$.var("YNAME");
      YNAME.set(YKOPF.get());
    }
    //<< ;NUR ANZEIGE DER ZEITABHÄNIGEN DATEN ;only Show the
    //<< SET YTIMEFORM=+$GET(%(YQUERY,"YTIMEFORM"))
    YTIMEFORM.set(mOp.Positive(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YTIMEFORM"))));
    //<< IF YTIMEFORM=1 DO
    if (mOp.Equal(YTIMEFORM.get(),1)) {
      //<< . SET YMAXKEY=$ORDER(^WWW002(0,YDATEI,""),-1)
      mVar YMAXKEY = m$.var("YMAXKEY");
      YMAXKEY.set(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1)));
      //<< . IF +YMAXKEY=0 SET YMAXKEY=1
      if (mOp.Equal(mOp.Positive(YMAXKEY.get()),0)) {
        YMAXKEY.set(1);
      }
      //<< . SET YFKEY=$PIECE($GET(FFKEY),",",1,YMAXKEY)
      mVar YFKEY = m$.var("YFKEY");
      YFKEY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("FFKEY")),",",1,YMAXKEY.get()));
    }
    //<< 
    //<< SET YREFR=""
    mVar YREFR = m$.var("YREFR");
    YREFR.set("");
    //<< IF $GET(YOPEN)="SAVESEAR" SET YREFR=600  ;FIS;SONST CSP ERROR
    if (mOp.Equal(m$.Fnc.$get(m$.var("YOPEN")),"SAVESEAR")) {
      YREFR.set(600);
    }
    //<< DO ^WWWSTART($$^WWWTEXT(148)_" "_$$^WWWUML(YKOPF),,YREFR)
    m$.Cmd.Do("WWWSTART.main",mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",148)," "),m$.fnc$("WWWUML.main",YKOPF.get())),null,YREFR.get());
    //<< /*
    //<< IF $PIECE($GET(^WWW012(0,YM,1)),Y,31)'=7 IF $GET(YHYPER)=0!(YHYPER=1) DO
    //<< . WRITE YCR
    //<< . ;IF SPRACHE="DE" WRITE "<SCRIPT LANGUAGE=JavaScript SRC="_""""_YGIF_"eventbroker"_$$^WWWLOW(SPRACHE)_+$GET(YHYPER)_".js"_""""_"></SCRIPT>"
    //<< . IF SPRACHE="DE" WRITE "<SCRIPT LANGUAGE=JavaScript SRC="_""""_YGIF_"eventbroker"_$zconvert(SPRACHE,"L")_+$GET(YHYPER)_".js"_""""_"></SCRIPT>"
    //<< . IF SPRACHE'="DE" WRITE "<SCRIPT LANGUAGE=JavaScript SRC="_""""_YGIF_"eventbroker"_"en"_+$GET(YHYPER)_".js"_""""_"></SCRIPT>"
    //<< . if +$get(^SysSetup("FieldEvents")) write !,"<script type='text/javascript' src='"_YGIF_"eventfunctions.js'></script>"
    //<< */
    //<< 
    //<< IF $PIECE($GET(^WWW012(0,YM,1)),Y,31)'=7 do JSLibraries^WWWFORM8()  // SR14697 // SR15276
    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),31),7)) {
      m$.Cmd.Do("WWWFORM8.JSLibraries");
    }
    //<< IF $PIECE($GET(^WWW012(0,YM,1)),Y,31)=7 DO ^WWWFORM8  ;JAVASCRIPT MENUE
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),31),7)) {
      m$.Cmd.Do("WWWFORM8.main");
    }
    //<< 
    //<< IF $GET(%(YQUERY,"YBUTTON"))="YSEARBIT"  SET $PIECE(^WWW1263(YM,YFORM,YBED,1),Y,2)=1  ;BITSUCHE
    if (mOp.Equal(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YBUTTON")),"YSEARBIT")) {
      m$.pieceVar(m$.var("^WWW1263",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YBED").get(),1),m$.var("Y").get(),2).set(1);
    }
    //<< IF $GET(%(YQUERY,"YBUTTON"))="YSEARDFLT" SET $PIECE(^WWW1263(YM,YFORM,YBED,1),Y,2)=0  ;NORMALSUCHE
    if (mOp.Equal(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YBUTTON")),"YSEARDFLT")) {
      m$.pieceVar(m$.var("^WWW1263",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YBED").get(),1),m$.var("Y").get(),2).set(0);
    }
    //<< SET YBITSEARCH=0  ;VORGABE SUCHE (NORMAL/BITSUCHE) ;default search
    mVar YBITSEARCH = m$.var("YBITSEARCH");
    YBITSEARCH.set(0);
    //<< SET YSEARBIT=0    ;BITSUCHE MÖGLICH;FIS;19.12.03 ;potential
    mVar YSEARBIT = m$.var("YSEARBIT");
    YSEARBIT.set(0);
    //<< IF $PIECE(YSUCH1,Y,22)=1 IF YDATEI'="" IF $DATA(^WWW001B(0,YDATEI)) IF $DATA(@("^"_YDATEI_"b")) SET YSEARBIT=1  ;TYBD;11,09,2003
    if (mOp.Equal(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),22),1)) {
      if (mOp.NotEqual(YDATEI.get(),"")) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW001B",0,YDATEI.get())))) {
          if (mOp.Logical(m$.Fnc.$data(m$.indirectVar((mOp.Concat(mOp.Concat("^",YDATEI.get()),"b")))))) {
            YSEARBIT.set(1);
          }
        }
      }
    }
    //<< ;IF $PIECE($GET(^WWW1263(YM,YFORM,YBED,1)),Y,2)="" SET $PIECE(^(1),Y,2)=+YSEARBIT  ;FIS;19.12.03;USER SUCHVORGABE
    //<< SET YBITSEARCH=$PIECE($GET(^WWW1263(YM,YFORM,YBED,1)),Y,2)  ;FIS;19.12.03;USER SUCHVORGABE
    YBITSEARCH.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1263",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YBED").get(),1)),m$.var("Y").get(),2));
    //<< IF YBITSEARCH=""     SET YBITSEARCH=+YSEARBIT
    if (mOp.Equal(YBITSEARCH.get(),"")) {
      YBITSEARCH.set(mOp.Positive(YSEARBIT.get()));
    }
    //<< IF $GET(YTIMEFORM)=1 SET YBITSEARCH=0  ;TYBD;NORMALE SUCHE BEI VORERFASSUNG; 3,11,2003
    if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),1)) {
      YBITSEARCH.set(0);
    }
    //<< ;SET YBITSEARCH=0   ;AUSGESCHALTET.TYBD;28,11,2003
    //<< ;----------- NORMALE SUCHE ------------------
    //<< IF $GET(YBITSEARCH)'=1 DO
    if (mOp.NotEqual(m$.Fnc.$get(YBITSEARCH),1)) {
      //<< . DO ^WWWBODY(3,"NOPRINT")  ;OHNE AUS YAUSWAHL ;without out of
      m$.Cmd.Do("WWWBODY.main",3,"NOPRINT");
      //<< . ;
      //<< . SET YFIXHEADER=0
      mVar YFIXHEADER = m$.var("YFIXHEADER");
      YFIXHEADER.set(0);
      //<< . ;
      //<< . IF $GET(YFIXHEADER)'=1 DO ^WWWUP(0)  ;SETZEN ANKER ;typeset armature
      if (mOp.NotEqual(m$.Fnc.$get(YFIXHEADER),1)) {
        m$.Cmd.Do("WWWUP.main",0);
      }
      //<< . ;I $P(YVOR,Y,10)=1 W "<CENTER>"
      //<< . ;D ^WWWUP(0)
      //<< . ;D ^WWWKOPF($$^WWWTEXT(148)_" ("_YNAME_")")
      //<< . ;I $P(YVOR,Y,10)=1 W "</CENTER>"
      //<< . ;
      //<< . IF YORIENT="" SET YORIENT=+$PIECE(YSUCH1,Y,9)
      if (mOp.Equal(m$.var("YORIENT").get(),"")) {
        mVar YORIENT = m$.var("YORIENT");
        YORIENT.set(mOp.Positive(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),9)));
      }
      //<< . IF $GET(YSORT)="" IF $PIECE(YSUCH1,Y,3)'="" SET YSORT=+$PIECE(YSUCH1,Y,3)
      if (mOp.Equal(m$.Fnc.$get(m$.var("YSORT")),"")) {
        if (mOp.NotEqual(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),3),"")) {
          mVar YSORT = m$.var("YSORT");
          YSORT.set(mOp.Positive(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),3)));
        }
      }
      //<< . IF $GET(YSORT)="" SET YSORT=+$PIECE(YSUCH1,Y,7)
      if (mOp.Equal(m$.Fnc.$get(m$.var("YSORT")),"")) {
        mVar YSORT = m$.var("YSORT");
        YSORT.set(mOp.Positive(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),7)));
      }
      //<< . ;
      //<< . IF $PIECE(YSUCH1,Y,17)'="" DO  ;FESTER SORTKEY
      if (mOp.NotEqual(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),17),"")) {
        //<< . . SET YSAUSW=$PIECE(YSUCH1,Y,17)
        mVar YSAUSW = m$.var("YSAUSW");
        YSAUSW.set(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),17));
        //<< . . IF $EXTRACT(YSAUSW)="@" DO
        if (mOp.Equal(m$.Fnc.$extract(YSAUSW.get()),"@")) {
          do {
            //<< . . . IF $EXTRACT(YSAUSW,2)'="$" SET YSAUSW=$GET(@($EXTRACT($PIECE(YSUCH1,Y,17),2,99))) QUIT
            if (mOp.NotEqual(m$.Fnc.$extract(YSAUSW.get(),2),"$")) {
              YSAUSW.set(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$extract(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),17),2,99)))));
              break;
            }
            //<< . . . NEW YSAUSW1
            mVar YSAUSW1 = m$.var("YSAUSW1");
            m$.newVarBlock(3,YSAUSW1);
            //<< . . . SET YSAUSW1="S YSAUSW="_$EXTRACT($PIECE(YSUCH1,Y,17),2,99)
            YSAUSW1.set(mOp.Concat("S YSAUSW=",m$.Fnc.$extract(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),17),2,99)));
            //<< . . . XECUTE YSAUSW1
            m$.Cmd.Xecute(YSAUSW1.get());
          } while (false);
        }
        m$.restoreVarBlock(3);
      }
      //<< . ;
      //<< . IF $GET(YFIXHEADER)=1 DO
      if (mOp.Equal(m$.Fnc.$get(YFIXHEADER),1)) {
        //<< . . WRITE "<TABLE BORDER=0 cellspacing=0 cellpadding=0 height="_""""_"96%"_""""_" WIDTH="_""""_"100%"_""""_"><TR height="_""""_"4px"_""""_" width="_""""_"100%"_""""_"><TD>"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TABLE BORDER=0 cellspacing=0 cellpadding=0 height=","\""),"96%"),"\"")," WIDTH="),"\""),"100%"),"\""),"><TR height="),"\""),"4px"),"\"")," width="),"\""),"100%"),"\""),"><TD>"));
      }
      //<< . ;
      //<< . DO ^WWWSEAR4  ;SELEKTIEREN DER DATEN ;the
      m$.Cmd.Do("WWWSEAR4.main");
      //<< . DO ^WWWSEAR1   ;BUTTONS
      m$.Cmd.Do("WWWSEAR1.main");
      //<< . ;
      //<< . IF +$PIECE(YVOR,Y,13)=1 DO
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),13)),1)) {
        //<< . . DO ^WWWFRAME(100)
        m$.Cmd.Do("WWWFRAME.main",100);
        //<< . . WRITE "<TR><TD>"
        m$.Cmd.Write("<TR><TD>");
      }
      //<< . ;
      //<< . DO ^WWWSEAR2   ;ANZEIGEN VORGABEN ;display
      m$.Cmd.Do("WWWSEAR2.main");
      //<< . ;
      //<< . IF +$PIECE(YVOR,Y,13)=1 DO
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),13)),1)) {
        //<< . . WRITE "</TD></TR>"
        m$.Cmd.Write("</TD></TR>");
        //<< . . DO ^WWWFRAME(1)
        m$.Cmd.Do("WWWFRAME.main",1);
      }
      //<< . ;
      //<< . ;ENDE ;termination
      //<< . IF $PIECE(YVOR,Y,9)=""!($PIECE(YVOR,Y,21)="1") WRITE "</FONT><PRE>"
      if (mOp.Or(mOp.Equal(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),9),""),(mOp.Equal(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),21),"1")))) {
        m$.Cmd.Write("</FONT><PRE>");
      }
      //<< . IF $PIECE(YVOR,Y,8)=1 WRITE "<STRONG><B>"
      if (mOp.Equal(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),8),1)) {
        m$.Cmd.Write("<STRONG><B>");
      }
      //<< . ;I $P(YVOR,Y,10)=1 W "<CENTER>"
      //<< . ;DO ^WWWFRAME(0)
      //<< . ;
      //<< . ;
      //<< . IF $GET(YFIXHEADER)=1 DO
      if (mOp.Equal(m$.Fnc.$get(YFIXHEADER),1)) {
        //<< . . WRITE "</td></tr><tr><td>"
        m$.Cmd.Write("</td></tr><tr><td>");
        //<< . . WRITE "<div style="_""""_"width: 100%; height: 100%; overflow: auto; "_""""_">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<div style=","\""),"width: 100%; height: 100%; overflow: auto; "),"\""),">"));
      }
      //<< . ;
      //<< . DO ^WWWSEAR3  ;ANZEIGEN WERTE ;display
      m$.Cmd.Do("WWWSEAR3.main");
      //<< . ;
      //<< . ;DO ^WWWFRAME(1)
      //<< . ;IF +$PIECE(YVOR,Y,13)=1 WRITE YCR,"</TD></TR>" DO ^WWWFRAME(1)
      //<< . ;I $P(YVOR,Y,10)=1 W "</CENTER>"
      //<< . IF $PIECE(YVOR,Y,8)=1 WRITE "</STRONG></B>"
      if (mOp.Equal(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),8),1)) {
        m$.Cmd.Write("</STRONG></B>");
      }
      //<< . IF $PIECE(YVOR,Y,9)=""!($PIECE(YVOR,Y,21)="1") WRITE "</PRE>"
      if (mOp.Or(mOp.Equal(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),9),""),(mOp.Equal(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),21),"1")))) {
        m$.Cmd.Write("</PRE>");
      }
      //<< . WRITE "</FONT>"
      m$.Cmd.Write("</FONT>");
      //<< . ;
      //<< . IF $GET(YFIXHEADER)'=1 DO ^WWWUP(1)
      if (mOp.NotEqual(m$.Fnc.$get(YFIXHEADER),1)) {
        m$.Cmd.Do("WWWUP.main",1);
      }
      //<< . IF $GET(YFIXHEADER)=1 DO
      if (mOp.Equal(m$.Fnc.$get(YFIXHEADER),1)) {
        //<< . . WRITE "</div>"
        m$.Cmd.Write("</div>");
        //<< . . WRITE "</td></tr></table>"
        m$.Cmd.Write("</td></tr></table>");
      }
    }
    //<< 
    //<< ;----------- BITSEARCH ------------------
    //<< IF $GET(YBITSEARCH)=1 DO
    if (mOp.Equal(m$.Fnc.$get(YBITSEARCH),1)) {
      //<< . DO ^WWWBODY(2,"NOPRINT")
      m$.Cmd.Do("WWWBODY.main",2,"NOPRINT");
      //<< . DO ^WWWUP(0)
      m$.Cmd.Do("WWWUP.main",0);
      //<< . DO ^WWWSEARBIT
      m$.Cmd.Do("WWWSEARBIT.main");
      //<< . DO ^WWWUP(1)
      m$.Cmd.Do("WWWUP.main",1);
    }
    //<< 
    //<< DO ^WWWSTOP
    m$.Cmd.Do("WWWSTOP.main");
    //<< ;I YHYPER'=1 DO KillAllObjects^%apiOBJ()
    //<< 
    //<< QUIT
    return;
  }

//<< 
//<< 
}
