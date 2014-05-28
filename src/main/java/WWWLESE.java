//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWLESE
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:41
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

//<< WWWLESE(YDATEI,YKEY,YTEST,YNEWYM,YREADONLY)
public class WWWLESE extends mClass {

  public Object main(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YTEST = m$.newVarRef("YTEST",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YNEWYM = m$.newVarRef("YNEWYM",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YREADONLY = m$.newVarRef("YREADONLY",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    return _WWWLESE(YDATEI,YKEY,YTEST,YNEWYM,YREADONLY);
  }

  public Object _WWWLESE(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YTEST = m$.newVarRef("YTEST",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YNEWYM = m$.newVarRef("YNEWYM",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YREADONLY = m$.newVarRef("YREADONLY",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       LESEN DATENSATZ
    //<< ;       Read Record
    //<< ;           D ^WWWLESE(YDATEI,"KEY1,KEYN")      ;INHALT IN YFELD
    //<< ;
    //<< ; Inputs :
    //<< ;   YDATEI      Class
    //<< ;   YKEY        Keys      SCHLUESSEL
    //<< ;   YTEST       1 = PRUEFUNG OB DER DATENSATZ VORHANDEN IST / CHECK IF $D ;whether the data record on hand
    //<< ;               2 = NUR PRUEFUNG OB DER DATENSATZ VORHANDEN IST / CHECK IF $D (KEIN LOCK !!!) ;only whether the data record on hand
    //<< ;   YNEWYM      WENN VON EINEM SPEZIELLEM MANDANT GELESEN WERDEN SOLL.  ;BEC;30.09.04;26476
    //<< ;   YREADONLY   =1 KEIN LOCK NEUSETZTEN ODER LÖSCHEN                    ;BEC;TYBD;27477;14.03.05
    //<< ;
    //<< ;
    //<< ; ByRef : see list of variables in exclusive NEW
    //<< ;   YFELD - contents of record specified by YDATEI & YKEY
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 03-May-2010   GRF     SR15961: use dteToday for efficiency
    //<< ; 20-Feb-2009   GRF     SR16356: call CreateLock^WWWFORMLocking as common
    //<< ;                           locking code; cleanup old change comments
    //<< ; 19-Feb-2009   HQN     SR16356: Handle locking as a pair of entries
    //<< ;                           WWWDATEN(,,,,"LOCK") and WWW006() records may exist
    //<< ;                           only if $$CanLock^WWWFORMLocking() is true
    //<< ; 18-Jun-2007   RPW     SRBR014510: Use YA1 instead of YA(1). YA1 is the object
    //<< ;                           id, YA(1) is the data.
    //<< ; 13-Mar-2007   GRF     SR12505: FIXME; comment unnecessary new command - covered
    //<< ;                           by exclusive new
    //<< ; 02-Jan-2007   GRF     SR15336: Doco; quits; naked reference; move set inside
    //<< ;                           DO loop to simplify line
    //<< ; 05-May-2006   Steve S SR14508: Only lock specific forms
    //<< ; 13-Apr-2006   JW      Removed + from user id's in lock check
    //<< ; 07-Jul-2005   shobby  SR12892: WWW126,WWW1262,WWW1262 are no longer shared.
    //<< ; 08.08.1997    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new (YREADONLY,YUMLAU,Y,YM,YMANDANT,LANGUAGE,SPRACHE,YFORM,YBEARB,YUSER,YBED,YDATEI,YKEY,YFELD,%FELD,%SCHLUESSEL,YTIMEFORM,YLOCATION,YTEST,YNEWYM)
    mVar YUMLAU = m$.var("YUMLAU");
    mVar Y = m$.var("Y");
    mVar YM = m$.var("YM");
    mVar YMANDANT = m$.var("YMANDANT");
    mVar LANGUAGE = m$.var("LANGUAGE");
    mVar SPRACHE = m$.var("SPRACHE");
    mVar YFORM = m$.var("YFORM");
    mVar YBEARB = m$.var("YBEARB");
    mVar YUSER = m$.var("YUSER");
    mVar YBED = m$.var("YBED");
    mVar YFELD = m$.var("YFELD");
    mVar YTIMEFORM = m$.var("YTIMEFORM");
    mVar YLOCATION = m$.var("YLOCATION");
    m$.newVarExcept(YREADONLY,YUMLAU,Y,YM,YMANDANT,LANGUAGE,SPRACHE,YFORM,YBEARB,YUSER,YBED,YDATEI,YKEY,YFELD,YTIMEFORM,YLOCATION,YTEST,YNEWYM);
    //<< 
    //<< set dteToday = +$horolog   ; SR15961
    mVar dteToday = m$.var("dteToday");
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< if YDATEI'="" {                              ; ALTERNATIVE CLASS
    if (mOp.NotEqual(YDATEI.get(),"")) {
      //<< set idxYDATEI = $$$Index(YDATEI)
      mVar idxYDATEI = m$.var("idxYDATEI");
      idxYDATEI.set(include.MEDConst.$$$Index(m$,YDATEI));
      //<< if $ORDER(^WWW0011s(0,1,idxYDATEI,""))'="" SET YDATEI = $ORDER(^WWW0011s(0,1,idxYDATEI,""))
      if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW0011s",0,1,idxYDATEI.get(),"")),"")) {
        YDATEI.set(m$.Fnc.$order(m$.var("^WWW0011s",0,1,idxYDATEI.get(),"")));
      }
    }
    //<< }
    //<< 
    //<< SET YQ          = 0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< SET YFELD       = ""
    YFELD.set("");
    //<< SET %FELD       = ""
    m$.var("%FELD").set("");
    //<< SET %SCHLUESSEL = ""
    m$.var("%SCHLUESSEL").set("");
    //<< SET YTEST       = $GET(YTEST)
    YTEST.set(m$.Fnc.$get(YTEST));
    //<< SET YTEST1      = ""
    mVar YTEST1 = m$.var("YTEST1");
    YTEST1.set("");
    //<< IF YTEST=2 SET YTEST=1 SET YTEST1=1    ; KEIN LOCK EINTRAGEN
    if (mOp.Equal(YTEST.get(),2)) {
      YTEST.set(1);
      YTEST1.set(1);
    }
    //<< 
    //<< if (YFORM'="") && (YKEY'="") && (YBED'="") && '$find(YKEY,"+") {
    if ((mOp.NotEqual(YFORM.get(),"")) && (mOp.NotEqual(YKEY.get(),"")) && (mOp.NotEqual(YBED.get(),"")) && mOp.Not(m$.Fnc.$find(YKEY.get(),"+"))) {
      //<< set dteKillDate = dteToday
      mVar dteKillDate = m$.var("dteKillDate");
      dteKillDate.set(dteToday.get());
      //<< for {
      for (;true;) {
        //<< set dteKillDate = $order(^WWW1264(YM,YBED,dteKillDate),-1)
        dteKillDate.set(m$.Fnc.$order(m$.var("^WWW1264",YM.get(),YBED.get(),dteKillDate.get()),mOp.Negative(1)));
        //<< quit:dteKillDate=""
        if (mOp.Equal(dteKillDate.get(),"")) {
          break;
        }
        //<< 
        //<< kill ^WWW1264(YM,YBED,dteKillDate)
        m$.var("^WWW1264",YM.get(),YBED.get(),dteKillDate.get()).kill();
      }
      //<< }
      //<< set intTime = ""
      mVar intTime = m$.var("intTime");
      intTime.set("");
      //<< for {
      for (;true;) {
        //<< set intTime = $order(^WWW1264(YM,YBED,dteToday,intTime))
        intTime.set(m$.Fnc.$order(m$.var("^WWW1264",YM.get(),YBED.get(),dteToday.get(),intTime.get())));
        //<< quit:intTime=""
        if (mOp.Equal(intTime.get(),"")) {
          break;
        }
        //<< 
        //<< if $get(^WWW1264(YM,YBED,dteToday,intTime,1))=(YFORM_Y_YKEY) {
        if (mOp.Equal(m$.Fnc.$get(m$.var("^WWW1264",YM.get(),YBED.get(),dteToday.get(),intTime.get(),1)),(mOp.Concat(mOp.Concat(YFORM.get(),Y.get()),YKEY.get())))) {
          //<< kill ^WWW1264(YM,YBED,dteToday,intTime,1)
          m$.var("^WWW1264",YM.get(),YBED.get(),dteToday.get(),intTime.get(),1).kill();
        }
      }
      //<< }
      //<< }
      //<< set ^WWW1264(YM,YBED,dteToday,$piece($horolog,",",2),1)=YFORM_Y_YKEY
      m$.var("^WWW1264",YM.get(),YBED.get(),dteToday.get(),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),1).set(mOp.Concat(mOp.Concat(YFORM.get(),Y.get()),YKEY.get()));
    }
    //<< }
    //<< 
    //<< IF YDATEI'="" DO
    if (mOp.NotEqual(YDATEI.get(),"")) {
      //<< . SET YDATA   = $GET(^WWW001(0,YDATEI,1))
      mVar YDATA = m$.var("YDATA");
      YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)));
      //<< . SET MAXYKEY = +$ORDER(^WWW002(0,YDATEI,""),-1)
      mVar MAXYKEY = m$.var("MAXYKEY");
      MAXYKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
      //<< . IF MAXYKEY=0 SET MAXYKEY = 1
      if (mOp.Equal(MAXYKEY.get(),0)) {
        MAXYKEY.set(1);
      }
      //<< . IF MAXYKEY'=0 DO
      if (mOp.NotEqual(MAXYKEY.get(),0)) {
        //<< . . SET Q   = 0                           ;SAVE OK?
        mVar Q = m$.var("Q");
        Q.set(0);
        //<< . . SET YOK = 0                           ;MULTISCHLUESSEL PRUEFUNG
        mVar YOK = m$.var("YOK");
        YOK.set(0);
        //<< . . SET SCHLUESSEL = "^"_YDATEI_"("
        mVar SCHLUESSEL = m$.var("SCHLUESSEL");
        SCHLUESSEL.set(mOp.Concat(mOp.Concat("^",YDATEI.get()),"("));
        //<< . . IF $GET(YTIMEFORM)=1 SET SCHLUESSEL = "^"_YDATEI_"t("  ;zeitabhängige änderung
        if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),1)) {
          SCHLUESSEL.set(mOp.Concat(mOp.Concat("^",YDATEI.get()),"t("));
        }
        //<< . . SET SCHLUESSEL = SCHLUESSEL_$$^WWWYM(YDATEI,1)
        SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),m$.fnc$("WWWYM.main",YDATEI.get(),1)));
        //<< . . SET YNUMM = ""                              ;LFD NUMMER FÜR MULTI SCHLUESSELVORGABE ;numeral to
        mVar YNUMM = m$.var("YNUMM");
        YNUMM.set("");
        //<< . . IF YFORM'="" IF +$PIECE($GET(^WWW120(0,YFORM,1)),Y,88)'=0 DO       ; D88    $$$WWW120NumberofMRURecordListItem()
        if (mOp.NotEqual(YFORM.get(),"")) {
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),Y.get(),88)),0)) {
            //<< . . . SET YNUMM = $$^WWWNEXT("WWW1262")
            YNUMM.set(m$.fnc$("WWWNEXT.main","WWW1262"));
            //<< . . . IF $ORDER(^WWW1262(YM,YFORM,YBED,""),-1)>YNUMM DO
            if (mOp.Greater(m$.Fnc.$order(m$.var("^WWW1262",YM.get(),YFORM.get(),YBED.get(),""),mOp.Negative(1)),YNUMM.get())) {
              //<< . . . . SET YNUMM = $ORDER(^WWW1262(YM,YFORM,YBED,""),-1)+1
              YNUMM.set(mOp.Add(m$.Fnc.$order(m$.var("^WWW1262",YM.get(),YFORM.get(),YBED.get(),""),mOp.Negative(1)),1));
            }
          }
        }
        //<< . . ;
        //<< . . FOR I=1:1:MAXYKEY SET XYKEY = $TRANSLATE($PIECE(YKEY,",",I),"""") SET SCHLUESSEL = SCHLUESSEL_""""_XYKEY_""""_"," DO  IF XYKEY="" SET Q = 1
        mVar I = m$.var("I");
        for (I.set(1);(mOp.LessOrEqual(I.get(),MAXYKEY.get()));I.set(mOp.Add(I.get(),1))) {
          mVar XYKEY = m$.var("XYKEY");
          XYKEY.set(m$.Fnc.$translate(m$.Fnc.$piece(YKEY.get(),",",I.get()),"\""));
          SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(SCHLUESSEL.get(),"\""),XYKEY.get()),"\""),","));
          do {
            //<< . . . QUIT:'$DATA(YFORM)
            if (mOp.Not(m$.Fnc.$data(YFORM))) {
              break;
            }
            //<< . . . QUIT:YFORM=""
            if (mOp.Equal(YFORM.get(),"")) {
              break;
            }
            //<< . . . SET ^WWW126(YM,YFORM,YBED,I,1)  = XYKEY  ;SPEICHERN VORGABEN ;Save
            m$.var("^WWW126",YM.get(),YFORM.get(),YBED.get(),I.get(),1).set(XYKEY.get());
            //<< . . . SET ^WWW126(YM,YFORM,YUSER,I,1) = XYKEY  ;SPEICHERN VORGABEN ;Save
            m$.var("^WWW126",YM.get(),YFORM.get(),YUSER.get(),I.get(),1).set(XYKEY.get());
            //<< . . . IF YNUMM'="" DO                          ;MULTISCHLUESSEL VORGABE ;default
            if (mOp.NotEqual(YNUMM.get(),"")) {
              do {
                //<< . . . . IF XYKEY="" SET YOK = 2 QUIT           ;NICHT SPEICHERN ;Not Save
                if (mOp.Equal(XYKEY.get(),"")) {
                  YOK.set(2);
                  break;
                }
                //<< . . . . SET YNUMM(1)=$ORDER(^WWW1262(YM,YFORM,YBED,""),-1)
                YNUMM.var(1).set(m$.Fnc.$order(m$.var("^WWW1262",YM.get(),YFORM.get(),YBED.get(),""),mOp.Negative(1)));
                //<< . . . . IF YNUMM(1)="" SET YOK = 1             ;SAVE OK
                if (mOp.Equal(YNUMM.var(1).get(),"")) {
                  YOK.set(1);
                }
                //<< . . . . IF YNUMM(1)'="" IF $GET(^WWW1262(YM,YFORM,YBED,YNUMM(1),I,1))'=$GET(XYKEY) SET YOK = 1  ;NICHT GLEICH ;Not without delay
                if (mOp.NotEqual(YNUMM.var(1).get(),"")) {
                  if (mOp.NotEqual(m$.Fnc.$get(m$.var("^WWW1262",YM.get(),YFORM.get(),YBED.get(),YNUMM.var(1).get(),I.get(),1)),m$.Fnc.$get(XYKEY))) {
                    YOK.set(1);
                  }
                }
                //<< . . . . SET ^WWW1262(YM,YFORM,YBED,YNUMM,I,1) = XYKEY  ;SPEICH DFLT
                m$.var("^WWW1262",YM.get(),YFORM.get(),YBED.get(),YNUMM.get(),I.get(),1).set(XYKEY.get());
              } while (false);
            }
          } while (false);
          if (mOp.Equal(XYKEY.get(),"")) {
            Q.set(1);
          }
        }
        //<< . . ;
        //<< . . IF (YOK=0) || (YOK=2) IF +YNUMM'=0 KILL ^WWW1262(YM,YFORM,YBED,YNUMM)  ;DOPPELTER DATENSATZ ;data record
        if ((mOp.Equal(YOK.get(),0)) || (mOp.Equal(YOK.get(),2))) {
          if (mOp.NotEqual(mOp.Positive(YNUMM.get()),0)) {
            m$.var("^WWW1262",YM.get(),YFORM.get(),YBED.get(),YNUMM.get()).kill();
          }
        }
        //<< . . IF $GET(YTIMEFORM)=1 DO  ;ZEITABHÄNGIGE ERFASSUNG ;logging
        if (mOp.Equal(m$.Fnc.$get(YTIMEFORM),1)) {
          do {
            //<< . . . NEW YABDATE
            mVar YABDATE = m$.var("YABDATE");
            m$.newVarBlock(3,YABDATE);
            //<< . . . SET YABDATE = +$PIECE(YKEY,",",MAXYKEY+1)
            YABDATE.set(mOp.Positive(m$.Fnc.$piece(YKEY.get(),",",mOp.Add(MAXYKEY.get(),1))));
            //<< . . . IF YABDATE=0              SET SCHLUESSEL = $PIECE($PIECE(SCHLUESSEL,"(",1),"t",1)_"("_$PIECE(SCHLUESSEL,"(",2,999) QUIT  ;new record
            if (mOp.Equal(YABDATE.get(),0)) {
              SCHLUESSEL.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(SCHLUESSEL.get(),"(",1),"t",1),"("),m$.Fnc.$piece(SCHLUESSEL.get(),"(",2,999)));
              break;
            }
            //<< . . . IF YABDATE>($HOROLOG-300) SET SCHLUESSEL = SCHLUESSEL_YABDATE_","
            if (mOp.Greater(YABDATE.get(),(mOp.Subtract(m$.Fnc.$horolog(),300)))) {
              SCHLUESSEL.set(mOp.Concat(mOp.Concat(SCHLUESSEL.get(),YABDATE.get()),","));
            }
          } while (false);
        }
        m$.restoreVarBlock(3);
        //<< . . ;
        //<< . . IF $PIECE(YDATA,Y,8)'=4     SET SCHLUESSEL = SCHLUESSEL_"1"
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),Y.get(),8),4)) {
          SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),"1"));
        }
        //<< . . IF $PIECE(YDATA,Y,8)=4 IF $EXTRACT(SCHLUESSEL,$LENGTH(SCHLUESSEL))="," SET SCHLUESSEL = $EXTRACT(SCHLUESSEL,1,$LENGTH(SCHLUESSEL)-1)
        if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),Y.get(),8),4)) {
          if (mOp.Equal(m$.Fnc.$extract(SCHLUESSEL.get(),m$.Fnc.$length(SCHLUESSEL.get())),",")) {
            SCHLUESSEL.set(m$.Fnc.$extract(SCHLUESSEL.get(),1,mOp.Subtract(m$.Fnc.$length(SCHLUESSEL.get()),1)));
          }
        }
        //<< . . SET SCHLUESSEL = SCHLUESSEL_")"
        SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),")"));
        //<< . . ;
        //<< . . IF Q=0 DO
        if (mOp.Equal(Q.get(),0)) {
          //<< . . . SET YFELD  = $$^WWWSETL(SCHLUESSEL,$GET(YTEST))   ;LESEN DATENSATZ
          YFELD.set(m$.fnc$("WWWSETL.main",SCHLUESSEL.get(),m$.Fnc.$get(YTEST)));
          //<< . . . SET YBEARB = 3
          YBEARB.set(3);
          //<< . . . IF $GET(YFORM)'="" IF $$^WWWLOCATION($GET(YLOCATION),YFORM,YFELD)'=1 SET YBEARB = 8    ;KEINE BERECHTIGUNG, DA FALSCHER BETRIEB
          if (mOp.NotEqual(m$.Fnc.$get(YFORM),"")) {
            if (mOp.NotEqual(m$.fnc$("WWWLOCATION.main",m$.Fnc.$get(YLOCATION),YFORM.get(),YFELD.get()),1)) {
              YBEARB.set(8);
            }
          }
          //<< . . . SET %SCHLUESSEL = SCHLUESSEL
          m$.var("%SCHLUESSEL").set(SCHLUESSEL.get());
          //<< . . . SET %FELD = YFELD                                   ; COPY FÜR AENDERUNGSPRÜFUNG ;to
          m$.var("%FELD").set(YFELD.get());
          //<< . . . SET YLOCK = +$PIECE($GET(^WWW001(0,YDATEI,1)),Y,6)  ;SATZLOCKSEKUNDEN
          mVar YLOCK = m$.var("YLOCK");
          YLOCK.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)),Y.get(),6)));
          //<< . . . ;
          //<< . . . ;---------------------------------
          //<< . . . ;   YA1    WWW006 P2   idFile : Class and keys (e.g. "^INReqToSupOrder/0.REQM0001.1/")
          //<< . . . ;   YA(1)  objWWW006   Lock-File
          //<< . . . ;---------------------------------
          //<< . . . IF $GET(YREADONLY)'=1 SET YA1 = "" FOR  SET YA1 = $ORDER(^WWW006(0,dteToday,YA1)) QUIT:YA1=""  DO
          if (mOp.NotEqual(m$.Fnc.$get(YREADONLY),1)) {
            mVar YA1 = m$.var("YA1");
            YA1.set("");
            for (;true;) {
              YA1.set(m$.Fnc.$order(m$.var("^WWW006",0,dteToday.get(),YA1.get())));
              if (mOp.Equal(YA1.get(),"")) {
                break;
              }
              //<< . . . . SET YA(1) = $GET(^WWW006(0,dteToday,YA1,1))                       ; SR15336
              mVar YA = m$.var("YA");
              YA.var(1).set(m$.Fnc.$get(m$.var("^WWW006",0,dteToday.get(),YA1.get(),1)));
              //<< . . . . IF $PIECE(YA(1),Y,1)=YUSER IF ($PIECE(YA(1),Y,2)+YLOCK)<$PIECE($HOROLOG,",",2) KILL ^WWW006(0,dteToday,YA1)
              if (mOp.Equal(m$.Fnc.$piece(YA.var(1).get(),Y.get(),1),YUSER.get())) {
                if (mOp.Less((mOp.Add(m$.Fnc.$piece(YA.var(1).get(),Y.get(),2),YLOCK.get())),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2))) {
                  m$.var("^WWW006",0,dteToday.get(),YA1.get()).kill();
                }
              }
              //<< . . . . IF $PIECE(YA(1),Y,1)=YUSER IF YA1'=$TRANSLATE(%SCHLUESSEL,",()"_"""",".//")    KILL ^WWW006(0,dteToday,YA1) ; ALTEN LOCK LÖSCHEN
              if (mOp.Equal(m$.Fnc.$piece(YA.var(1).get(),Y.get(),1),YUSER.get())) {
                if (mOp.NotEqual(YA1.get(),m$.Fnc.$translate(m$.var("%SCHLUESSEL").get(),mOp.Concat(",()","\""),".//"))) {
                  m$.var("^WWW006",0,dteToday.get(),YA1.get()).kill();
                }
              }
              //<< . . . . ;RÜCKHOLEN LETZTER LOCK WENN FORMULAR IN SEPARATEM FENSTER
              //<< . . . . IF $PIECE($GET(^WWWUSER(0,YUSER,1)),Y,25)'="" DO
              if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1)),Y.get(),25),"")) {
                //<< . . . . . NEW YTRAKTOLD,YA1,YA,YT
                mVar YTRAKTOLD = m$.var("YTRAKTOLD");
                mVar YT = m$.var("YT");
                m$.newVarBlock(5,YTRAKTOLD,YA1,YA,YT);
                //<< . . . . . SET YTRAKTOLD = $PIECE($GET(^WWWUSER(0,YUSER,1)),Y,25)      ; Transaction no. Lock Return Info
                YTRAKTOLD.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1)),Y.get(),25));
                //<< . . . . . SET YT  = 0
                YT.set(0);
                //<< . . . . . SET YA1 = ""
                YA1.set("");
                //<< . . . . . FOR  SET YA1 = $ORDER(^WWW0061(0,dteToday,YA1)) QUIT:YA1=""  DO
                for (;true;) {
                  YA1.set(m$.Fnc.$order(m$.var("^WWW0061",0,dteToday.get(),YA1.get())));
                  if (mOp.Equal(YA1.get(),"")) {
                    break;
                  }
                  //<< . . . . . . IF $DATA(^WWW0061(0,dteToday,YA1,YTRAKTOLD)) DO
                  if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0061",0,dteToday.get(),YA1.get(),YTRAKTOLD.get())))) {
                    do {
                      //<< . . . . . . . SET YA(1) = $GET(^WWW0061(0,dteToday,YA1,YTRAKTOLD,1))
                      YA.var(1).set(m$.Fnc.$get(m$.var("^WWW0061",0,dteToday.get(),YA1.get(),YTRAKTOLD.get(),1)));
                      //<< . . . . . . . IF $PIECE(YA(1),Y,1)=YUSER IF ($PIECE(YA(1),Y,2)+300)>$PIECE($HOROLOG,",",2) DO  QUIT  ;PRÜFEN OB NOCH GÜLTIG (MAX. 5 MINUTEN) ;check whether yet valuable
                      if (mOp.Equal(m$.Fnc.$piece(YA.var(1).get(),Y.get(),1),YUSER.get())) {
                        if (mOp.Greater((mOp.Add(m$.Fnc.$piece(YA.var(1).get(),Y.get(),2),300)),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2))) {
                          //<< . . . . . . . . IF '$DATA(^WWW006(0,dteToday,YA1)) SET ^WWW006(0,dteToday,YA1,1) = $GET(^WWW0061(0,dteToday,YA1,YTRAKTOLD,1))  ;LOCK ZURÜCKSETZTEN
                          if (mOp.Not(m$.Fnc.$data(m$.var("^WWW006",0,dteToday.get(),YA1.get())))) {
                            m$.var("^WWW006",0,dteToday.get(),YA1.get(),1).set(m$.Fnc.$get(m$.var("^WWW0061",0,dteToday.get(),YA1.get(),YTRAKTOLD.get(),1)));
                          }
                          //<< . . . . . . . . SET YT = 1
                          YT.set(1);
                          break;
                        }
                      }
                      //<< . . . . . . . ;
                      //<< . . . . . . . KILL ^WWW0061(0,dteToday,YA1)  ;LÖSCHEN WENN UNGÜLTIG ;Delete when
                      m$.var("^WWW0061",0,dteToday.get(),YA1.get()).kill();
                    } while (false);
                  }
                }
                //<< . . . . . ;
                //<< . . . . . IF YT'=1 SET $PIECE(^WWWUSER(0,YUSER,1),Y,25)=""
                if (mOp.NotEqual(YT.get(),1)) {
                  m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),Y.get(),25).set("");
                }
              }
              m$.restoreVarBlock(5);
            }
          }
          //<< . . . ;
          //<< . . . IF ($GET(YREADONLY)'=1) && (YDATEI'="WWW006") && (YLOCK'=0) DO
          if ((mOp.NotEqual(m$.Fnc.$get(YREADONLY),1)) && (mOp.NotEqual(YDATEI.get(),"WWW006")) && (mOp.NotEqual(YLOCK.get(),0))) {
            //<< . . . . new strKey
            mVar strKey = m$.var("strKey");
            m$.newVarBlock(4,strKey);
            //<< . . . . set strKey = $TRANSLATE(%SCHLUESSEL,",()"_"""",".//")
            strKey.set(m$.Fnc.$translate(m$.var("%SCHLUESSEL").get(),mOp.Concat(",()","\""),".//"));
            //<< . . . . IF $DATA(^WWW006(0,dteToday,strKey,1)) DO
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW006",0,dteToday.get(),strKey.get(),1)))) {
              //<< . . . . . SET YA(1) = $get(^WWW006(0,dteToday,strKey,1))
              mVar YA = m$.var("YA");
              YA.var(1).set(m$.Fnc.$get(m$.var("^WWW006",0,dteToday.get(),strKey.get(),1)));
              //<< . . . . . IF YUSER'=$$$WWW006User1(YA(1)) IF ($$$WWW006LockedUntilTime(YA(1))+YLOCK)>$PIECE($HOROLOG,",",2) SET Q=1 SET YBEARB=4  ;IN USE
              if (mOp.NotEqual(YUSER.get(),include.WWWConst.$$$WWW006User1(m$,YA.var(1)))) {
                if (mOp.Greater((mOp.Add(include.WWWConst.$$$WWW006LockedUntilTime(m$,YA.var(1)),YLOCK.get())),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2))) {
                  Q.set(1);
                  YBEARB.set(4);
                }
              }
            }
          }
          m$.restoreVarBlock(4);
          //<< . . . . . ;
          //<< . . . . . ;*****************************
          //<< . . . . . ;  FIXME : Do we really want an unconditional lock (which unlocks ALL locks held by this process)?
          //<< . . . . . ;          e.g.  lock batch, save block [unconditionally unlock], save batch, unlock batch
          //<< . . . . . ;          Other processes can sieze control of the batch between unlock and save.
          //<< . . . . . ;          This depends on whether the following lock is ever executed.                  <GRF>
          //<< . . . . . ;          Most calls don't pass YREADONLY
          //<< . . . . . ;          Only executed if Lock Seconds assigned in WWW001
          //<< . . . . . ;*****************************
          //<< . . . . . ;
          //<< . . . . . LOCK
          //<< . . . ;
          //<< . . . IF $GET(YREADONLY)'=1 DO      ;BEC;TYBD;27477;14.03.05
          if (mOp.NotEqual(m$.Fnc.$get(YREADONLY),1)) {
            do {
              //<< . . . . IF YTEST1=1 QUIT:YFELD'=""  ;FIS;24.10.03;24469;NUR LOCK EINTRAGEN WENN DATENSATZ VORHANDEN
              if (mOp.Equal(YTEST1.get(),1)) {
                if (mOp.NotEqual(YFELD.get(),"")) {
                  break;
                }
              }
              //<< . . . . ; SR16356 vvvv
              //<< . . . . ; Only lock from the allowed forms
              //<< . . . . IF (Q=0) && (YDATEI'="WWW006") && $$CanLock^WWWFORMLocking(YFORM) do CreateLock^WWWFORMLocking(%SCHLUESSEL,YUSER,$horolog,YFORM)
              if ((mOp.Equal(Q.get(),0)) && (mOp.NotEqual(YDATEI.get(),"WWW006")) && mOp.Logical(m$.fnc$("WWWFORMLocking.CanLock",YFORM.get()))) {
                m$.Cmd.Do("WWWFORMLocking.CreateLock",m$.var("%SCHLUESSEL").get(),YUSER.get(),m$.Fnc.$horolog(),YFORM.get());
              }
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< ;. . . .  ^^^ REPLACES vvvv
    //<< ;. . . . IF (Q=0) && (YDATEI'="WWW006") && $$CanLock^WWWFORMLocking(YFORM) DO
    //<< ;. . . . . SET ^WWW006(0,dteToday,$TRANSLATE(%SCHLUESSEL,",()"_"""",".//"),1) = YUSER_Y_$PIECE($HOROLOG,",",2) ;SPEICHERN NEUEN LOCK ;Save
    //<< ;. . . . . IF $GET(YFORM)'="" SET ^WWWDATEN(YM,dteToday,YUSER,YFORM,"LOCK",1) = "^WWW006(0,"_dteToday_","_""""_$TRANSLATE(SCHLUESSEL,",()"_"""",".//")_""""_",1)"
    //<< ;. . . .  ^^^ REPLACES vvvv
    //<< ;. . . . IF Q=0 IF YDATEI'="WWW006" SET:$$CanLock^WWWFORMLocking(YFORM) ^WWW006(0,dteToday,$TRANSLATE(%SCHLUESSEL,",()"_"""",".//"),1)=YUSER_Y_$PIECE($HOROLOG,",",2) ;SPEICHERN NEUEN LOCK ;Save
    //<< ;. . . . IF $GET(YFORM)'="" SET ^WWWDATEN(YM,dteToday,YUSER,YFORM,"LOCK",1)="^WWW006(0,"_dteToday_","_""""_$TRANSLATE(SCHLUESSEL,",()"_"""",".//")_""""_",1)"
    //<< ;. . . .  SR16356 REPLACED ^^^^
    //<< 
    //<< QUIT
    return null;
  }

//<< 
//<< 
}
