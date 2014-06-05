//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMANU
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:42
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

//<< WWWMANU
public class WWWMANU extends mClass {

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
    _WWWMANU();
  }

  public void _WWWMANU() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWMANU("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       MANUELLES PROGRAMM/DRUCKVORLAGE
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
    //<< ; 07-May-2007   GRF     SR15511: Doco; quits; naked references
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 06.08.1997    DT  (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< DO START
    m$.Cmd.Do("START");
    //<< QUIT
    return;
  }

  //<< 
  //<< START
  public void START() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 05-Nov-2007   shobby      BR014748: Use standard check for password.
    //<< ; 13-Apr-2006   JW          Removed + from user id's in lock check
    //<< ;-------------------------------------------------------------------------------
    //<< NEW (%request,%session,%KEY,%,%ZCS,%CGIEVAR)
    //<< 
    //<< DO ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< 
    //<< SET $ZTRAP="^WWWERROR"
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("^WWWERROR");
    //<< IF '$DATA(^WWW013(0,YBED)) DO ^WWWINFO($$^WWWTEXT(5)) QUIT
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW013",0,m$.var("YBED").get())))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< ;IF $$^WWWUPER($$^WWWPWDCHECK($PIECE(^WWW013(0,YBED,1),Y,2)))'=$$^WWWUPER(YPWD) DO ^WWWINFO($$^WWWTEXT(5)) QUIT
    //<< ;BR014748 IF $zconvert($$^WWWPWDCHECK($PIECE(^WWW013(0,YBED,1),Y,2)),"U")'=$zconvert(YPWD,"U") DO ^WWWINFO($$^WWWTEXT(5)) QUIT ;BR014748
    //<< IF '$$CHECK^WWWPWDCHECK($PIECE(^WWW013(0,YBED,1),Y,2),YPWD) DO ^WWWINFO($$^WWWTEXT(5)) QUIT
    if (mOp.Not(m$.fnc$("WWWPWDCHECK.CHECK",m$.Fnc.$piece(m$.var("^WWW013",0,m$.var("YBED").get(),1).get(),m$.var("Y").get(),2),m$.var("YPWD").get()))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< 
    //<< ;------------------------------------------------------------------------------------------------------------------
    //<< ;KILL LOCK
    //<< IF $GET(YUSER)'="" SET YA="" FOR  SET YA=$ORDER(^WWW006(0,YA)) QUIT:YA=""  DO
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      mVar YA = m$.var("YA");
      YA.set("");
      for (;true;) {
        YA.set(m$.Fnc.$order(m$.var("^WWW006",0,YA.get())));
        if (mOp.Equal(YA.get(),"")) {
          break;
        }
        do {
          //<< . IF +YA'=+$HOROLOG KILL ^WWW006(0,YA) QUIT  ;LÖSCHEN ALTE LOCKFILE ;Delete
          if (mOp.NotEqual(mOp.Positive(YA.get()),mOp.Positive(m$.Fnc.$horolog()))) {
            m$.var("^WWW006",0,YA.get()).kill();
            break;
          }
          //<< . NEW YA1  ;LOSCHEN ALLE EINTRÄGE WENN LEERES FELD ;when field
          mVar YA1 = m$.var("YA1");
          m$.newVarBlock(1,YA1);
          //<< . IF $GET(YDATEI)'="" DO
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDATEI")),"")) {
            //<< . . SET YA1=""
            YA1.set("");
            //<< . . FOR  SET YA1=$ORDER(^WWW006(0,+$HOROLOG,YA1)) QUIT:YA1=""  SET YA(1)=$GET(^WWW006(0,+$HOROLOG,YA1,1)) DO
            for (;true;) {
              YA1.set(m$.Fnc.$order(m$.var("^WWW006",0,mOp.Positive(m$.Fnc.$horolog()),YA1.get())));
              if (mOp.Equal(YA1.get(),"")) {
                break;
              }
              YA.var(1).set(m$.Fnc.$get(m$.var("^WWW006",0,mOp.Positive(m$.Fnc.$horolog()),YA1.get(),1)));
              //<< . . . IF $PIECE(YA(1),Y,1)=YUSER KILL ^WWW006(0,+$HOROLOG,YA1) KILL ^WWW0061(0,+$HOROLOG,YA1)  ;FIS;19.04.04;LÖSCHEN LOCK RÜCKHOLINFO ;Delete
              if (mOp.Equal(m$.Fnc.$piece(YA.var(1).get(),m$.var("Y").get(),1),m$.var("YUSER").get())) {
                m$.var("^WWW006",0,mOp.Positive(m$.Fnc.$horolog()),YA1.get()).kill();
                m$.var("^WWW0061",0,mOp.Positive(m$.Fnc.$horolog()),YA1.get()).kill();
              }
            }
          }
        } while (false);
      }
      m$.restoreVarBlock(1);
    }
    //<< 
    //<< KILL YA
    m$.var("YA").kill();
    //<< ;------------------------------------------------------------------------------------------------------------------
    //<< DO PGMSTART
    m$.Cmd.Do("PGMSTART");
    //<< QUIT
    return;
  }

  //<< 
  //<< PGMSTART
  public void PGMSTART() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; EINSPRUNG MIT YEXEC UND YFORM ;by means of And
    //<< ;
    //<< ; Params: YEXEC = Execute String
    //<< ;           if "#<executestring>" No HTML Preperation
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Dec-2006   JW      BR014262: Use GetType fn.
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< $$$LogR("PGMSTART",$get(YEXEC))
    $$$LogR(m$,"PGMSTART",m$.Fnc.$get(m$.var("YEXEC")));
    //<< 
    //<< ;IF '$FIND(YEXEC,"XML") IF '$FIND(YEXEC,"EDI") DO
    //<< ;. IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* MANUELLES PROGRAMM:"_YEXEC_" (WWWMANU)************************* -->",YCR,YCR
    //<< 
    //<< SET %(YQUERY,"EP")="WWWMANU"
    m$.var("%",m$.var("YQUERY").get(),"EP").set("WWWMANU");
    //<< 
    //<< ;------------------------------------------------------------------------------------------------------------------
    //<< IF $FIND(YEXEC,"**class") SET YEXEC=$PIECE(YEXEC,"**class",1)_"##class"_$PIECE(YEXEC,"**class",2,9)
    if (mOp.Logical(m$.Fnc.$find(m$.var("YEXEC").get(),"**class"))) {
      mVar YEXEC = m$.var("YEXEC");
      YEXEC.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.var("YEXEC").get(),"**class",1),"##class"),m$.Fnc.$piece(m$.var("YEXEC").get(),"**class",2,9)));
    }
    //<< IF $FIND(YEXEC,"**class") SET YEXEC=$PIECE(YEXEC,"**class",1)_"##class"_$PIECE(YEXEC,"**class",2,9)
    if (mOp.Logical(m$.Fnc.$find(m$.var("YEXEC").get(),"**class"))) {
      mVar YEXEC = m$.var("YEXEC");
      YEXEC.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.var("YEXEC").get(),"**class",1),"##class"),m$.Fnc.$piece(m$.var("YEXEC").get(),"**class",2,9)));
    }
    //<< 
    //<< ;FIS;24760;18.12.03;PRÜFEN HTML-VORBEREITUNG DURCH INDIVIDUELLEN EXECUTE
    //<< ;IN KLASSE WWWCHECKHTML KANN DEFINIERT WERDEN, OB BEI EINEM FUNKTIONSAUFRUF EINE ZUSÄTZLICHE
    //<< ;PRÜFUNG ERFOLGEN SOLL, OB HTML VORBEREITET WERDEN SOLL. IST DER RETURNVALUE =1, WIRD HTML NICHT
    //<< ;VORBEREITET
    //<< IF $EXTRACT(YEXEC)'="#" IF $EXTRACT(YEXEC)'="*" DO
    if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YEXEC").get()),"#")) {
      if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YEXEC").get()),"*")) {
        //<< . NEW EXEC,NOHTML,PROG
        mVar EXEC = m$.var("EXEC");
        mVar NOHTML = m$.var("NOHTML");
        mVar PROG = m$.var("PROG");
        m$.newVarBlock(1,EXEC,NOHTML,PROG);
        //<< . ;SET PROG=$$^WWWUPER($PIECE($PIECE(YEXEC," ",2),"(",1))  ;Z.B. 'do Gesamt^INAUFBES2(...)' = 'GESAMT^INAUFBES2'
        //<< . SET PROG=$zconvert($PIECE($PIECE(YEXEC," ",2),"(",1),"U")  ;Z.B. 'do Gesamt^INAUFBES2(...)' = 'GESAMT^INAUFBES2'
        PROG.set(m$.Fnc.$zconvert(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YEXEC").get()," ",2),"(",1),"U"));
        //<< . ;IF $DATA(^WWWCHECKHTML(0,PROG)) DO
        //<< . IF PROG'="" IF $DATA(^WWWCHECKHTML(0,PROG)) DO  ;FIS;09.03.05;27457
        if (mOp.NotEqual(PROG.get(),"")) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWCHECKHTML",0,PROG.get())))) {
            do {
              //<< . . SET NOHTML=0
              NOHTML.set(0);
              //<< . . IF $PIECE($GET(^WWWCHECKHTML(0,PROG,1)),Y,2)=1 QUIT  ;HTML IMMER VORBEREITEN ;HTML constantly prepare
              if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWCHECKHTML",0,PROG.get(),1)),m$.var("Y").get(),2),1)) {
                break;
              }
              //<< . . IF $PIECE($GET(^WWWCHECKHTML(0,PROG,1)),Y,1)'="" DO
              if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWCHECKHTML",0,PROG.get(),1)),m$.var("Y").get(),1),"")) {
                //<< . . . SET EXEC="SET NOHTML="_$PIECE(^WWWCHECKHTML(0,PROG,1),Y,1)     ;SR15511 naked ref
                EXEC.set(mOp.Concat("SET NOHTML=",m$.Fnc.$piece(m$.var("^WWWCHECKHTML",0,PROG.get(),1).get(),m$.var("Y").get(),1)));
                //<< . . . XECUTE EXEC
                m$.Cmd.Xecute(EXEC.get());
              }
              //<< . . ;
              //<< . . IF NOHTML=1 SET YEXEC="#"_YEXEC
              if (mOp.Equal(NOHTML.get(),1)) {
                mVar YEXEC = m$.var("YEXEC");
                YEXEC.set(mOp.Concat("#",m$.var("YEXEC").get()));
              }
            } while (false);
          }
        }
      }
      m$.restoreVarBlock(1);
    }
    //<< 
    //<< IF ($EXTRACT(YEXEC)="#") || ($EXTRACT(YEXEC)="*") SET YEXEC = $EXTRACT(YEXEC,2,999) DO  QUIT  ;OHNE HTML VORBEREITUNG ;without HTML preparation
    if ((mOp.Equal(m$.Fnc.$extract(m$.var("YEXEC").get()),"#")) || (mOp.Equal(m$.Fnc.$extract(m$.var("YEXEC").get()),"*"))) {
      mVar YEXEC = m$.var("YEXEC");
      YEXEC.set(m$.Fnc.$extract(m$.var("YEXEC").get(),2,999));
      do {
        //<< . SET $Y=0,$X=0
        mVar $Y = m$.var("$Y");
        $Y.set(0);
        mVar $X = m$.var("$X");
        $X.set(0);
        //<< . IF YEXEC'="" IF '$FIND(YEXEC," ") DO @YEXEC QUIT
        if (mOp.NotEqual(YEXEC.get(),"")) {
          if (mOp.Not(m$.Fnc.$find(YEXEC.get()," "))) {
            m$.Cmd.Do(YEXEC.get());
            break;
          }
        }
        //<< . IF YEXEC'="" IF $FIND(YEXEC," ") XECUTE YEXEC QUIT
        if (mOp.NotEqual(YEXEC.get(),"")) {
          if (mOp.Logical(m$.Fnc.$find(YEXEC.get()," "))) {
            m$.Cmd.Xecute(YEXEC.get());
            break;
          }
        }
      } while (false);
      return;
    }
    //<< 
    //<< ;------------------------------------------------------------------------------------------------------------------
    //<< DO ^WWWFORMX  ;VORGABEN WWW120,WWW012 - generates YVOR and YVOR1 respectively
    m$.Cmd.Do("WWWFORMX.main");
    //<< 
    //<< SET YKOPF = $PIECE(YVOR,Y,1)    ;  $$$WWW120FormHeaderOrImageFile
    mVar YKOPF = m$.var("YKOPF");
    YKOPF.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),1));
    //<< IF YNAME'="" IF YFORM'="" IF YKOPF="" IF $LENGTH(YKOPF)<$LENGTH(YNAME) SET YKOPF = YNAME
    if (mOp.NotEqual(m$.var("YNAME").get(),"")) {
      if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
        if (mOp.Equal(YKOPF.get(),"")) {
          if (mOp.Less(m$.Fnc.$length(YKOPF.get()),m$.Fnc.$length(m$.var("YNAME").get()))) {
            YKOPF.set(m$.var("YNAME").get());
          }
        }
      }
    }
    //<< IF YFORM'="" IF $DATA(^WWW1201(0,YFORM,SPRACHE,1)) SET YKOPF = $PIECE(^WWW1201(0,YFORM,SPRACHE,1),Y,1),YNAME=YKOPF
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1201",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),1)))) {
        YKOPF.set(m$.Fnc.$piece(m$.var("^WWW1201",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        mVar YNAME = m$.var("YNAME");
        YNAME.set(YKOPF.get());
      }
    }
    //<< IF YNAME="" SET YNAME = YKOPF
    if (mOp.Equal(m$.var("YNAME").get(),"")) {
      mVar YNAME = m$.var("YNAME");
      YNAME.set(YKOPF.get());
    }
    //<< 
    //<< DO ^WWWSTART(YKOPF)  ;STARTEN HTML ;launching HTML
    m$.Cmd.Do("WWWSTART.main",YKOPF.get());
    //<< 
    //<< //IF $PIECE($GET(^WWW012(0,YM,1)),Y,31)=7 DO ^WWWFORM8  ;BR014262
    //<< if $$GetType^WWWMENU() = 7 {
    if (mOp.Equal(m$.fnc$("WWWMENU.GetType"),7)) {
      //<< DO ^WWWFORM8  ;JAVASCRIPT WENN MENUE ;when
      m$.Cmd.Do("WWWFORM8.main");
    }
    //<< }
    //<< DO ^WWWBODY(2)   ;STARTEN BODY ;launching
    m$.Cmd.Do("WWWBODY.main",2);
    //<< IF $FIND($PIECE(YVOR,Y,8),1) WRITE "<STRONG><B>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),1))) {
      m$.Cmd.Write("<STRONG><B>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),2) WRITE "<U>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),2))) {
      m$.Cmd.Write("<U>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),3) WRITE "<I>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),3))) {
      m$.Cmd.Write("<I>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),4) WRITE "<STRIKE>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),4))) {
      m$.Cmd.Write("<STRIKE>");
    }
    //<< 
    //<< ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
    //<< /*
    //<< ;D   ;WENN 'ZURUECK' GEWUENSCHT! ;when
    //<< . WRITE YCR,"<FORM>"
    //<< . WRITE "<TABLE CELLSPACING=0 BORDER=0><TR><TD>"                ; "Back"
    //<< . WRITE "<INPUT TYPE="_""""_"BUTTON"_""""_" VALUE="_""""_YAM_$$^WWWTEXT(99)_""""_" onClick="_""""_"window.history.back()"_""""_">"
    //<< . WRITE "</TD></TR></TABLE>"
    //<< . WRITE "</FORM>",YCR
    //<< */
    //<< ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
    //<< 
    //<< IF $PIECE(YVOR,Y,9)="" WRITE "<PRE>"        ; $$$WWW120FontFace
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),9),"")) {
      m$.Cmd.Write("<PRE>");
    }
    //<< 
    //<< ;I $D(^$ROUTINE("MASK2")) S YP="HTM" D ^MASK2 S YP(2)=YPAGE,YP(1)=2,YB=".."_YBED
    //<< SET $Y=0,$X=0
    mVar $Y = m$.var("$Y");
    $Y.set(0);
    mVar $X = m$.var("$X");
    $X.set(0);
    do {
      //<< 
      //<< ;------------------------------------------------------------------------------------------------------------------
      //<< ;AUSFUEHRUNG
      //<< ;  YEXEC = "QUERY,..."  over-ridden by search in D111
      //<< DO   ;
      //<< . IF YEXEC'="" IF $EXTRACT(YEXEC,1,6)="QUERY," DO  QUIT  ;QUERY AUFRUFEN
      if (mOp.NotEqual(m$.var("YEXEC").get(),"")) {
        if (mOp.Equal(m$.Fnc.$extract(m$.var("YEXEC").get(),1,6),"QUERY,")) {
          do {
            //<< . . NEW YCLASS,YQUERY,YPARAX,intYVOR111
            mVar YCLASS = m$.var("YCLASS");
            mVar YQUERY = m$.var("YQUERY");
            mVar YPARAX = m$.var("YPARAX");
            mVar intYVOR111 = m$.var("intYVOR111");
            m$.newVarBlock(2,YCLASS,YQUERY,YPARAX,intYVOR111);
            //<< . . SET YCLASS = $PIECE(YEXEC,",",2)
            YCLASS.set(m$.Fnc.$piece(m$.var("YEXEC").get(),",",2));
            //<< . . SET YQUERY = $PIECE(YEXEC,",",3)
            YQUERY.set(m$.Fnc.$piece(m$.var("YEXEC").get(),",",3));
            //<< . . SET YPARAX = $PIECE(YEXEC,",",4,99)
            YPARAX.set(m$.Fnc.$piece(m$.var("YEXEC").get(),",",4,99));
            //<< . . set intYVOR111 = $FIND($zconvert($piece(YVOR,Y,111),"U"),"SELECT")              ; $$$WWW120QueryForDataFields
            intYVOR111.set(m$.Fnc.$find(m$.Fnc.$zconvert(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),111),"U"),"SELECT"));
            //<< . . IF 'intYVOR111 QUIT:(YCLASS="")||(YQUERY="")                                             ;KEIN QUERY ;no
            if (mOp.Not(intYVOR111.get())) {
              if ((mOp.Equal(YCLASS.get(),"")) || (mOp.Equal(YQUERY.get(),""))) {
                break;
              }
            }
            //<< . . IF intYVOR111 SET YQUERY=$TRANSLATE($PIECE(YVOR,Y,111),"|"," ") SET YCLASS="",YPARAX=""  ;MANUELLES QUERY
            if (mOp.Logical(intYVOR111.get())) {
              YQUERY.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),111),"|"," "));
              YCLASS.set("");
              YPARAX.set("");
            }
            //<< . . DO ^WWWQUERY(YCLASS,YQUERY,YPARAX,1)                                                     ;QUERY STARTEN ;launching
            m$.Cmd.Do("WWWQUERY.main",YCLASS.get(),YQUERY.get(),YPARAX.get(),1);
          } while (false);
          break;
        }
        m$.restoreVarBlock(2);
      }
      //<< . ;
      //<< . //IF YEXEC'="" IF '$FIND(YEXEC," ") DO @YEXEC    QUIT  ;DO COMMAND
      //<< . //IF YEXEC'="" IF $FIND(YEXEC," ")  XECUTE YEXEC QUIT  ;EXECUTE
      //<< . ;
      //<< . if $get(YUSER)'="" if $data(^mtempRecordFile("Record",YUSER)) do MacroRecordExecute^WWWRECORD(YM,$g(YUSER),$g(YFORM),$g(YKEY),$g(YEXEC))  ; PPP
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^mtempRecordFile","Record",m$.var("YUSER").get())))) {
          m$.Cmd.Do("WWWRECORD.MacroRecordExecute",m$.var("YM").get(),m$.Fnc.$get(m$.var("YUSER")),m$.Fnc.$get(m$.var("YFORM")),m$.Fnc.$get(m$.var("YKEY")),m$.Fnc.$get(m$.var("YEXEC")));
        }
      }
      //<< . IF YEXEC'="" IF '$FIND(YEXEC," ") DO @YEXEC do  QUIT  ;DO COMMAND
      if (mOp.NotEqual(m$.var("YEXEC").get(),"")) {
        if (mOp.Not(m$.Fnc.$find(m$.var("YEXEC").get()," "))) {
          m$.Cmd.Do(m$.var("YEXEC").get());
          //<< . . if $get(YUSER)'="" if $data(^mtempRecordFile("Record",YUSER)) do MacroRecordExecuteStop^WWWRECORD(YM,$g(YUSER))  ; PPP
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^mtempRecordFile","Record",m$.var("YUSER").get())))) {
              m$.Cmd.Do("WWWRECORD.MacroRecordExecuteStop",m$.var("YM").get(),m$.Fnc.$get(m$.var("YUSER")));
            }
          }
          break;
        }
      }
      //<< . IF YEXEC'="" IF $FIND(YEXEC," ") XECUTE YEXEC do  QUIT  ;EXECUTE
      if (mOp.NotEqual(m$.var("YEXEC").get(),"")) {
        if (mOp.Logical(m$.Fnc.$find(m$.var("YEXEC").get()," "))) {
          m$.Cmd.Xecute(m$.var("YEXEC").get());
          //<< . . if $get(YUSER)'="" if $data(^mtempRecordFile("Record",YUSER)) do MacroRecordExecuteStop^WWWRECORD(YM,$g(YUSER))  ; PPP
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^mtempRecordFile","Record",m$.var("YUSER").get())))) {
              m$.Cmd.Do("WWWRECORD.MacroRecordExecuteStop",m$.var("YM").get(),m$.Fnc.$get(m$.var("YUSER")));
            }
          }
          break;
        }
      }
    } while(false);
    //<< 
    //<< ;------------------------------------------------------------------------------------------------------------------
    //<< DO OPEN^WWWSTART
    m$.Cmd.Do("WWWSTART.OPEN");
    //<< IF $PIECE(YVOR,Y,9)=""       WRITE "</PRE>"                 ; $$$WWW120FontFace
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),9),"")) {
      m$.Cmd.Write("</PRE>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),1) WRITE "</STRONG></B>"          ; $$$WWW120FontStyle
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),1))) {
      m$.Cmd.Write("</STRONG></B>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),2) WRITE "</U>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),2))) {
      m$.Cmd.Write("</U>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),3) WRITE "</I>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),3))) {
      m$.Cmd.Write("</I>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),4) WRITE "</STRIKE>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),4))) {
      m$.Cmd.Write("</STRIKE>");
    }
    //<< WRITE "</FONT>",YCR
    m$.Cmd.Write("</FONT>",m$.var("YCR").get());
    //<< DO ^WWWSTOP
    m$.Cmd.Do("WWWSTOP.main");
    //<< 
    //<< QUIT
    return;
  }

//<< 
//<< 
}
