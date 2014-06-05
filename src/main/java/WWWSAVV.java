//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSAVV
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:36
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;
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

//<< WWWSAVV
public class WWWSAVV extends mClass {

  public void main() {
    _WWWSAVV();
  }

  public void _WWWSAVV() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SAVEVORGABE - save default
    //<< ;
    //<< ; [NOTE : YDECIMALLEN is used by WWWTR.]
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
    //<< ; 09-Aug-2011   shobby  SR17807: GetFormat has moved.
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
    //<< ; 14-Apr-2009   GRF     Clean up commented code
    //<< ; 06-Nov-2008   shobby  SR16123: Standardised routine to determine InputType
    //<< ; 20-Aug-2007   GM      SR13729: Change "FELDFORMAT" parameter to $$GetFormat^INPARA()
    //<< ; 09-May-2007   GRF     SRBR014310: Call WWWDECIMALLEN function; naked references;
    //<< ;                           Identify disabled blocks
    //<< ; 29-May-2006   PO      SR14679: Save the Manual field values.
    //<< ; 09-Dec-2005   JW      SR13195: Quit if trying to overwrite stored data
    //<< ; 31-Oct-2005   GRF     SR13627 : Doco
    //<< ; 30.09.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< KILL YKEY
    m$.var("YKEY").kill();
    //<< SET YFELD  = ""
    mVar YFELD = m$.var("YFELD");
    YFELD.set("");
    //<< SET YMFELD = ""
    mVar YMFELD = m$.var("YMFELD");
    YMFELD.set("");
    //<< SET YKEY   = ""
    mVar YKEY = m$.var("YKEY");
    YKEY.set("");
    //<< SET YKILL  = ""
    mVar YKILL = m$.var("YKILL");
    YKILL.set("");
    //<< SET YAEND  = ""
    mVar YAEND = m$.var("YAEND");
    YAEND.set("");
    //<< SET YVOR   = ^WWW120(0,YFORM,1)
    mVar YVOR = m$.var("YVOR");
    YVOR.set(m$.var("^WWW120",0,m$.var("YFORM").get(),1).get());
    //<< 
    //<< NEW YI,YA
    mVar YI = m$.var("YI");
    mVar YA = m$.var("YA");
    m$.newVar(YI,YA);
    //<< 
    //<< QUIT:$$$WWW120FormType(YVOR)=6  ;MENUE
    if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,YVOR),6)) {
      return;
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;YALLKEY=0 = SPEICHERN ;Save
    //<< ;YALLKEY=1 = NUR ÖFFNEN ;only open
    //<< ;YALLKEY=2 = KEYS VORHANDEN ;on hand
    //<< ;YALLKEY=9 = KEY VOLLSTÄNDIG KEIN WEITERSUCHEN NÖTIG ;KEY integral no necessary
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< SET YALLKEY=0             ;SPEICHERN ;Save
    mVar YALLKEY = m$.var("YALLKEY");
    YALLKEY.set(0);
    //<< IF YOPEN=1 SET YALLKEY=1  ;ÖFFNEN    ;open
    if (mOp.Equal(m$.var("YOPEN").get(),1)) {
      YALLKEY.set(1);
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   YVOR        objWWW120       Form Definition
    //<< ;   D2      $$$WWW120FormType()
    //<< ;   D11     $$$WWW120ClassUsedInForm()
    //<< ;   D66     $$$WWW120PositioningOfButtonLine()
    //<< ;   D123    $$$WWW120SaveServerdata()
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< ;LESEN DATEN /KEY UND FELDER ;read And
    //<< IF $$$WWW120FormType(YVOR)'=2 IF $$$WWW120FormType(YVOR)'=8 IF +$$$WWW120SaveServerdata(YVOR)=1 IF +$$$WWW120PositioningOfButtonLine(YVOR)'=1 DO  QUIT  ;SCHNELLSAVE
    if (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,YVOR),2)) {
      if (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,YVOR),8)) {
        if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120SaveServerdata(m$,YVOR)),1)) {
          if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW120PositioningOfButtonLine(m$,YVOR)),1)) {
            do {
              //<< . NEW YDATEI
              mVar YDATEI = m$.var("YDATEI");
              m$.newVarBlock(1,YDATEI);
              //<< . SET YDATEI=$$$WWW120ClassUsedInForm(YVOR)
              YDATEI.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,YVOR));
              //<< . ;PRIMAERSCHLUESSEL
              //<< . IF $GET(YRICHT)="" IF YOPEN=0 IF $GET(^WWWDATEN(YM,+$HOROLOG,YUSER,"RECORDEXISTS",YFORM,1))=1 set YOPEN="X" QUIT
              if (mOp.Equal(m$.Fnc.$get(m$.var("YRICHT")),"")) {
                if (mOp.Equal(m$.var("YOPEN").get(),0)) {
                  if (mOp.Equal(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),"RECORDEXISTS",m$.var("YFORM").get(),1)),1)) {
                    mVar YOPEN = m$.var("YOPEN");
                    YOPEN.set("X");
                    break;
                  }
                }
              }
              //<< . ;
              //<< . SET YMAXKEY=""
              mVar YMAXKEY = m$.var("YMAXKEY");
              YMAXKEY.set("");
              //<< . IF YDATEI'="" SET YMAXKEY=$ORDER(^WWW002(0,YDATEI,""),-1) IF YMAXKEY'="" DO  QUIT:YALLKEY=2   ;PRIMAERSCHLÜSSEL
              if (mOp.NotEqual(YDATEI.get(),"")) {
                YMAXKEY.set(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1)));
                if (mOp.NotEqual(YMAXKEY.get(),"")) {
                  //<< . . IF $GET(YTIMEFORM)=1 SET YMAXKEY=YMAXKEY+1                     ;EIN KEY MEHR ;uni- KEY more
                  if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
                    YMAXKEY.set(mOp.Add(YMAXKEY.get(),1));
                  }
                  //<< . . FOR YI=1:1:YMAXKEY DO
                  for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
                    //<< . . . SET YKEY(YI)=$PIECE($GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"P",1)),",",YI)
                    YKEY.var(YI.get()).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1)),",",YI.get()));
                    //<< . . . SET YKEY(YI)=$TRANSLATE(YKEY(YI),"&,;()'"_Y_"""","+//////")  ;SCHLUESSEL OHNE SONDERZEICHEN
                    YKEY.var(YI.get()).set(m$.Fnc.$translate(YKEY.var(YI.get()).get(),mOp.Concat(mOp.Concat("&,;()'",m$.var("Y").get()),"\""),"+//////"));
                    //<< . . . IF $EXTRACT(YOPEN,1,4)'="SAVE" DO
                    if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YOPEN").get(),1,4),"SAVE")) {
                      do {
                        //<< . . . . QUIT:YKEY(YI)=""
                        if (mOp.Equal(YKEY.var(YI.get()).get(),"")) {
                          break;
                        }
                        //<< . . . . SET YTYP=$PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)
                        mVar YTYP = m$.var("YTYP");
                        YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),YI.get(),1)),m$.var("Y").get(),3));
                        //<< . . . . SET YKEY(YI)=$$GetLiteral^WWWTR(YTYP,YKEY(YI))
                        YKEY.var(YI.get()).set(m$.fnc$("WWWTR.GetLiteral",YTYP.get(),YKEY.var(YI.get()).get()));
                      } while (false);
                    }
                    //<< . . . ;
                    //<< . . . IF YKEY(YI)="" DO
                    if (mOp.Equal(YKEY.var(YI.get()).get(),"")) {
                      do {
                        //<< . . . . IF $PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)=2 SET YKEY(YI)=0 QUIT
                        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),YI.get(),1)),m$.var("Y").get(),3),2)) {
                          YKEY.var(YI.get()).set(0);
                          break;
                        }
                        //<< . . . . SET YALLKEY=1  ;SUCHEN ÖFFNEN ;seek unclose
                        YALLKEY.set(1);
                      } while (false);
                    }
                    //<< . . . IF YOPEN=1 IF YKEY(YI)'="" SET YALLKEY=2
                    if (mOp.Equal(m$.var("YOPEN").get(),1)) {
                      if (mOp.NotEqual(YKEY.var(YI.get()).get(),"")) {
                        YALLKEY.set(2);
                      }
                    }
                    //<< . . . SET %(YQUERY,"Y"_YFORM_"P"_YI)=YKEY(YI)
                    m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P"),YI.get())).set(YKEY.var(YI.get()).get());
                    //<< . . . IF $GET(YTIMEFORM)=1 I YMAXKEY=YI K YKEY(YI)
                    if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
                      if (mOp.Equal(YMAXKEY.get(),YI.get())) {
                        YKEY.var(YI.get()).kill();
                      }
                    }
                  }
                  if (mOp.Equal(YALLKEY.get(),2)) {
                    break;
                  }
                }
              }
              //<< . ;
              //<< . ;MANUELLE FELDER
              //<< . IF $DATA(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"LOCK",2)) DO
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"LOCK",2)))) {
                //<< . . NEW LOCK
                mVar LOCK = m$.var("LOCK");
                m$.newVarBlock(2,LOCK);
                //<< . . FOR  hang 1 SET LOCK=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"LOCK",2)) QUIT:LOCK=""  QUIT:+LOCK'=+$HOROLOG  QUIT:($PIECE(LOCK,",",2)+4)<$PIECE($HOROLOG,",",2)  ;TYBD;LOCK BEI SAVE VON DATENFELDERN ;next to
                for (;true;) {
                  m$.Cmd.Hang(1);
                  LOCK.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"LOCK",2)));
                  if (mOp.Equal(LOCK.get(),"")) {
                    break;
                  }
                  if (mOp.NotEqual(mOp.Positive(LOCK.get()),mOp.Positive(m$.Fnc.$horolog()))) {
                    break;
                  }
                  if (mOp.Less((mOp.Add(m$.Fnc.$piece(LOCK.get(),",",2),4)),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2))) {
                    break;
                  }
                }
              }
              m$.restoreVarBlock(2);
              //<< . ;
              //<< . SET YMFELD=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"M",1))
              YMFELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"M",1)));
              //<< . SET YI=""
              YI.set("");
              //<< . FOR  SET YI=$ORDER(^WWW122s(0,4," ",YFORM,YI)) QUIT:YI=""  DO   ;prüfen der manuellen felder ;sift who
              for (;true;) {
                YI.set(m$.Fnc.$order(m$.var("^WWW122s",0,4," ",m$.var("YFORM").get(),YI.get())));
                if (mOp.Equal(YI.get(),"")) {
                  break;
                }
                do {
                  //<< . . NEW YSATZ
                  mVar YSATZ = m$.var("YSATZ");
                  m$.newVarBlock(2,YSATZ);
                  //<< . . SET YSATZ=$GET(^WWW122(0,YFORM,YI,1))
                  YSATZ.set(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YI.get(),1)));
                  //<< . . QUIT:$PIECE(YSATZ,Y,1)'=""   ;KEIN MANUELLER ;no
                  if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),1),"")) {
                    break;
                  }
                  //<< . . SET YTYP=$PIECE(YSATZ,Y,5)
                  mVar YTYP = m$.var("YTYP");
                  YTYP.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),5));
                  //<< . . IF YTYP'=3 IF ($PIECE(YSATZ,Y,2)=6) || ($PIECE(YSATZ,Y,32)'="") SET $PIECE(YMFELD,Y,YI)=$TRANSLATE($PIECE(YMFELD,Y,YI),";"_Y,",,")  ;TYBD;NUR BEI NICHT MEMOFELDERN;18,08,2003;24154
                  if (mOp.NotEqual(YTYP.get(),3)) {
                    if ((mOp.Equal(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),2),6)) || (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),32),""))) {
                      m$.pieceVar(YMFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$translate(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),YI.get()),mOp.Concat(";",m$.var("Y").get()),",,"));
                    }
                  }
                  //<< . . IF $FIND($PIECE(YMFELD,Y,YI),"&")  SET $PIECE(YMFELD,Y,YI)=$TRANSLATE($$GetLiteral^WWWTR(YTYP,$PIECE(YMFELD,Y,YI)),Y,",")
                  if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),YI.get()),"&"))) {
                    m$.pieceVar(YMFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$translate(m$.fnc$("WWWTR.GetLiteral",YTYP.get(),m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),YI.get())),m$.var("Y").get(),","));
                  }
                  //<< . . IF '$FIND($PIECE(YMFELD,Y,YI),"&") SET $PIECE(YMFELD,Y,YI)=$$GetLiteral^WWWTR(YTYP,$PIECE(YMFELD,Y,YI))
                  if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),YI.get()),"&"))) {
                    m$.pieceVar(YMFELD,m$.var("Y").get(),YI.get()).set(m$.fnc$("WWWTR.GetLiteral",YTYP.get(),m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),YI.get())));
                  }
                  //<< . . ;
                  //<< . . ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
                  //<< . . ;IF $DATA(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"Y"_YFORM_"M"_YI,1)) DO   ;MULTISELECT FELD
                  //<< . . . SET $PIECE(YMFELD,Y,YI)=$PIECE($GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"Y"_YFORM_"M"_YI,1)),Y,2)
                  //<< . . . IF $EXTRACT($REVERSE($PIECE(YMFELD,Y,YI)))="," IF '$FIND($PIECE(YMFELD,Y,YI),"&") SET $PIECE(YMFELD,Y,YI)=$REVERSE($EXTRACT($REVERSE($PIECE(YMFELD,Y,YI)),2,9999))
                  //<< . . ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
                  //<< . . ;
                  //<< . . SET %(YQUERY,"Y"_YFORM_"M"_YI)=$PIECE(YMFELD,Y,YI)
                  m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),YI.get())).set(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),YI.get()));
                  //<< . . IF $EXTRACT($REVERSE($PIECE(YMFELD,Y,YI)))="," IF '$FIND($PIECE(YMFELD,Y,YI),"&") SET $PIECE(YMFELD,Y,YI)=$REVERSE($EXTRACT($REVERSE($PIECE(YMFELD,Y,YI)),2,9999))
                  if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),YI.get()))),",")) {
                    if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),YI.get()),"&"))) {
                      m$.pieceVar(YMFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),YI.get())),2,9999)));
                    }
                  }
                  //<< . . SET YM(YI)=$PIECE(YMFELD,Y,YI)
                  mVar YM = m$.var("YM");
                  YM.var(YI.get()).set(m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),YI.get()));
                  //<< . . SET $PIECE(YMFELD,Y,YI)=$$GetInternal^WWWTR(YTYP,$PIECE(YMFELD,Y,YI))  ;TYBD;23827;25,06,2003;UMSETZUNG FÜR SEITENWECHSEL
                  m$.pieceVar(YMFELD,m$.var("Y").get(),YI.get()).set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),m$.Fnc.$piece(YMFELD.get(),m$.var("Y").get(),YI.get())));
                } while (false);
              }
              m$.restoreVarBlock(2);
              //<< . ;
              //<< . ;DATENFELDER
              //<< . SET YFELD=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"D",1))
              YFELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1)));
              //<< . IF $EXTRACT(YOPEN,1,4)="SAVE" DO
              if (mOp.Equal(m$.Fnc.$extract(m$.var("YOPEN").get(),1,4),"SAVE")) {
                //<< . . IF YDATEI'="" SET YI="" FOR  SET YI=$ORDER(^WWW003(0,YDATEI,YI)) QUIT:YI=""  DO  ;DATENFELDER
                if (mOp.NotEqual(YDATEI.get(),"")) {
                  YI.set("");
                  for (;true;) {
                    YI.set(m$.Fnc.$order(m$.var("^WWW003",0,YDATEI.get(),YI.get())));
                    if (mOp.Equal(YI.get(),"")) {
                      break;
                    }
                    //<< . . . ;
                    //<< . . . ; vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
                    //<< . . . ;IF $DATA(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"Y"_YFORM_"D"_YI,1)) DO   ;MULTISELECT FELD
                    //<< . . . . SET $PIECE(YFELD,Y,YI)=$PIECE($GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"Y"_YFORM_"D"_YI,1)),Y,2)
                    m$.pieceVar(YFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),YI.get()),1)),m$.var("Y").get(),2));
                    //<< . . . . IF $EXTRACT($REVERSE($PIECE(YFELD,Y,YI)))=";" I '$F($PIECE(YFELD,Y,YI),"&") SET $PIECE(YFELD,Y,YI)=$REVERSE($EXTRACT($REVERSE($PIECE(YFELD,Y,YI)),2,9999))
                    if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get()))),";")) {
                      if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get()),"&"))) {
                        m$.pieceVar(YFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get())),2,9999)));
                      }
                    }
                  }
                }
              }
            } while (false);
            return;
          }
          m$.restoreVarBlock(1);
        }
      }
      //<< . . . ; ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
      //<< . ;
      //<< . IF $EXTRACT(YOPEN,1,4)'="SAVE" DO
      if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YOPEN").get(),1,4),"SAVE")) {
        //<< . . NEW YDECIMALLEN
        mVar YDECIMALLEN = m$.var("YDECIMALLEN");
        m$.newVarBlock(2,YDECIMALLEN);
        //<< . . IF YDATEI'="" SET YI="" FOR  SET YI=$ORDER(^WWW003(0,YDATEI,YI)) QUIT:YI=""  DO  ;DATENFELDER
        if (mOp.NotEqual(m$.var("YDATEI").get(),"")) {
          YI.set("");
          for (;true;) {
            YI.set(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),YI.get())));
            if (mOp.Equal(YI.get(),"")) {
              break;
            }
            //<< . . . ;
            //<< . . . ; vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
            //<< . . . ;IF $DATA(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"Y"_YFORM_"D"_YI,1)) DO   ;MULTISELECT FELD
            //<< . . . . SET $PIECE(YFELD,Y,YI)=$PIECE($GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"Y"_YFORM_"D"_YI,1)),Y,2)
            m$.pieceVar(YFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),YI.get()),1)),m$.var("Y").get(),2));
            //<< . . . . IF $EXTRACT($REVERSE($PIECE(YFELD,Y,YI)))=";" IF '$FIND($PIECE(YFELD,Y,YI),"&") SET $PIECE(YFELD,Y,YI)=$REVERSE($EXTRACT($REVERSE($PIECE(YFELD,Y,YI)),2,9999))
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get()))),";")) {
              if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get()),"&"))) {
                m$.pieceVar(YFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get())),2,9999)));
              }
            }
          }
          do {
            //<< . . . ; ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
            //<< . . . ;
            //<< . . . IF $PIECE(YFELD,Y,YI)="" QUIT
            if (mOp.Equal(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get()),"")) {
              break;
            }
            //<< . . . IF $EXTRACT($REVERSE($PIECE(YFELD,Y,YI)))=";" IF '$FIND($PIECE(YFELD,Y,YI),"&") SET $PIECE(YFELD,Y,YI)=$REVERSE($EXTRACT($REVERSE($PIECE(YFELD,Y,YI)),2,9999))
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get()))),";")) {
              if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get()),"&"))) {
                m$.pieceVar(YFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get())),2,9999)));
              }
            }
            //<< . . . set YTYP=$$GetInputType^WWWSAVE(YDATEI,YI,YFORM) ;SR16123
            mVar YTYP = m$.var("YTYP");
            YTYP.set(m$.fnc$("WWWSAVE.GetInputType",m$.var("YDATEI").get(),YI.get(),m$.var("YFORM").get()));
            //<< . . . SET YDECIMALLEN=2
            YDECIMALLEN.set(2);
            //<< . . . IF YTYP=8 DO
            if (mOp.Equal(YTYP.get(),8)) {
              //<< . . . . IF $DATA(^WWW122D(0,YFORM)) DO  ;TYBD;18,10,2004;ANZAHL DECIMALSTELLEN WÄHRUNG
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122D",0,m$.var("YFORM").get())))) {
                //<< . . . . . set YDECIMALLEN = $$^WWWDECIMALLEN(YFORM,YI)
                YDECIMALLEN.set(m$.fnc$("WWWDECIMALLEN.main",m$.var("YFORM").get(),YI.get()));
              }
            }
            //<< . . . ;
            //<< . . . IF YTYP=8 IF $FIND($PIECE(YFELD,Y,YI),"@") DO  QUIT  ;FIS;25727;21.05.04;FREMDWÄHRUNG
            if (mOp.Equal(YTYP.get(),8)) {
              if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get()),"@"))) {
                //<< . . . . NEW TRENN
                mVar TRENN = m$.var("TRENN");
                m$.newVarBlock(4,TRENN);
                //<< . . . . ;SR17807 SET TRENN    = $$GetFormat^INPARA(8,".,")
                //<< . . . . SET TRENN    = $$GetFormat^WWW100(8,".,") ;SR17807
                TRENN.set(m$.fnc$("WWW100.GetFormat",8,".,"));
                //<< . . . . SET TRENN    = $TRANSLATE(TRENN,"nNxX")
                TRENN.set(m$.Fnc.$translate(TRENN.get(),"nNxX"));
                //<< . . . . set YDECIMAL = $extract(TRENN,1)
                mVar YDECIMAL = m$.var("YDECIMAL");
                YDECIMAL.set(m$.Fnc.$extract(TRENN.get(),1));
                //<< . . . . ;
                //<< . . . . IF YDECIMAL="," SET $PIECE(YFELD,Y,YI)=$TRANSLATE($PIECE(YFELD,Y,YI),".",$EXTRACT(TRENN,2))  ;ZURÜCKSETZEN AUF DEZIMAL-TRENNZEICHEN ;upon
                if (mOp.Equal(YDECIMAL.get(),",")) {
                  m$.pieceVar(YFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$translate(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get()),".",m$.Fnc.$extract(TRENN.get(),2)));
                }
                //<< . . . . SET %(YQUERY,"Y"_YFORM_"D"_YI)=$$GetLiteral^WWWTR(YTYP,$PIECE(YFELD,Y,YI))
                m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),YI.get())).set(m$.fnc$("WWWTR.GetLiteral",YTYP.get(),m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get())));
                break;
              }
              m$.restoreVarBlock(4);
            }
            //<< . . . ;
            //<< . . . SET $PIECE(YFELD,Y,YI)=$$GetLiteral^WWWTR(YTYP,$PIECE(YFELD,Y,YI))
            m$.pieceVar(YFELD,m$.var("Y").get(),YI.get()).set(m$.fnc$("WWWTR.GetLiteral",YTYP.get(),m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get())));
            //<< . . . SET %(YQUERY,"Y"_YFORM_"D"_YI)=$PIECE(YFELD,Y,YI)
            m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),YI.get())).set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YI.get()));
          } while (false);
        }
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . if YMFELD '= "" do SaveRecallRecord^WWWRECALL(YBED,YFORM,"M",YMFELD)
      if (mOp.NotEqual(YMFELD.get(),"")) {
        m$.Cmd.Do("WWWRECALL.SaveRecallRecord",m$.var("YBED").get(),m$.var("YFORM").get(),"M",YMFELD.get());
      }
    }
    //<< 
    //<< IF $$$WWW120FormType(YVOR)'=2 DO   ;FORM ;shape
    if (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,YVOR),2)) {
      do {
        //<< . NEW YDATEI
        mVar YDATEI = m$.var("YDATEI");
        m$.newVarBlock(1,YDATEI);
        //<< . SET YDATEI = $$$WWW120ClassUsedInForm(YVOR)  ; D11
        YDATEI.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,YVOR));
        //<< . SET YMAXKEY=""
        mVar YMAXKEY = m$.var("YMAXKEY");
        YMAXKEY.set("");
        //<< . IF YDATEI'="" SET YMAXKEY=$ORDER(^WWW002(0,YDATEI,""),-1) IF YMAXKEY'="" DO  QUIT:YALLKEY=2   ;PRIMAERSCHLÜSSEL
        if (mOp.NotEqual(YDATEI.get(),"")) {
          YMAXKEY.set(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1)));
          if (mOp.NotEqual(YMAXKEY.get(),"")) {
            //<< . . FOR YI=1:1:YMAXKEY DO
            for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
              //<< . . . SET YA=$GET(%(YQUERY,"Y"_YFORM_"P"_YI))
              YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P"),YI.get()))));
              //<< . . . IF $EXTRACT(YOPEN,1,4)="SAVE" DO
              if (mOp.Equal(m$.Fnc.$extract(m$.var("YOPEN").get(),1,4),"SAVE")) {
                //<< . . . . SET YTYP=$PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)
                mVar YTYP = m$.var("YTYP");
                YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),YI.get(),1)),m$.var("Y").get(),3));
                //<< . . . . SET YA=$$GetInternal^WWWTR(YTYP,YA)
                YA.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YA.get()));
              }
              //<< . . . ;
              //<< . . . SET YKEY(YI)=$TRANSLATE(YA,"&,;()'"_Y_"""","+//////")  ;SCHLUESSEL OHNE SONDERZEICHEN
              YKEY.var(YI.get()).set(m$.Fnc.$translate(YA.get(),mOp.Concat(mOp.Concat("&,;()'",m$.var("Y").get()),"\""),"+//////"));
              //<< . . . IF YKEY(YI)="" DO
              if (mOp.Equal(YKEY.var(YI.get()).get(),"")) {
                do {
                  //<< . . . . IF $PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)=2 SET YKEY(YI)=0 QUIT
                  if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),YI.get(),1)),m$.var("Y").get(),3),2)) {
                    YKEY.var(YI.get()).set(0);
                    break;
                  }
                  //<< . . . . SET YALLKEY=1  ;SUCHEN ÖFFNEN ;seek unclose
                  YALLKEY.set(1);
                } while (false);
              }
              //<< . . . IF YOPEN=1 IF YKEY(YI)'="" SET YALLKEY=2
              if (mOp.Equal(m$.var("YOPEN").get(),1)) {
                if (mOp.NotEqual(YKEY.var(YI.get()).get(),"")) {
                  YALLKEY.set(2);
                }
              }
            }
            if (mOp.Equal(YALLKEY.get(),2)) {
              break;
            }
          }
        }
        //<< . ;
        //<< . IF YMAXKEY="" DO  ;AUTOMATISCH LFD ALS PRIMAERSCHL (KEIN PRIMAER) ;automatic when
        if (mOp.Equal(YMAXKEY.get(),"")) {
          do {
            //<< . . NEW DATA
            mVar DATA = m$.var("DATA");
            m$.newVarBlock(2,DATA);
            //<< . . SET YKEY(1)=$GET(%(YQUERY,"Y"_YFORM_"P"_1))
            YKEY.var(1).set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P"),1))));
            //<< . . QUIT:YRICHT'=""                              ;NUR NEXT DATENSATZ ;only data record
            if (mOp.NotEqual(m$.var("YRICHT").get(),"")) {
              break;
            }
            //<< . . QUIT:YOPEN=1                                 ;NUR DATENSATZ SUCHEN/ÖFFNEN ;only data record
            if (mOp.Equal(m$.var("YOPEN").get(),1)) {
              break;
            }
            //<< . . SET DATA="^"_YDATEI_"("_$$^WWWYM(YDATEI,1)_""""_""""_")"
            DATA.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get(),1)),"\""),"\""),")"));
            //<< . . IF YKEY(1)="" SET YKEY(1)=$ORDER(@DATA,-1)+1
            if (mOp.Equal(YKEY.var(1).get(),"")) {
              YKEY.var(1).set(mOp.Add(m$.Fnc.$order(m$.indirectVar(DATA.get()),mOp.Negative(1)),1));
            }
          } while (false);
        }
        m$.restoreVarBlock(2);
        //<< . ;
        //<< . IF YDATEI'="" SET YI="" FOR  SET YI=$ORDER(^WWW003(0,YDATEI,YI)) QUIT:YI=""  DO  ;DATENFELDER
        if (mOp.NotEqual(YDATEI.get(),"")) {
          YI.set("");
          for (;true;) {
            YI.set(m$.Fnc.$order(m$.var("^WWW003",0,YDATEI.get(),YI.get())));
            if (mOp.Equal(YI.get(),"")) {
              break;
            }
            //<< . . SET YA=$GET(%(YQUERY,"Y"_YFORM_"D"_YI))
            YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),YI.get()))));
            //<< . . DO MULTD
            m$.Cmd.Do("MULTD");
            //<< . . IF YA'="" DO
            if (mOp.NotEqual(YA.get(),"")) {
              //<< . . . SET YTYP=$PIECE($GET(^WWW003(0,YDATEI,YI,1)),Y,3)
              mVar YTYP = m$.var("YTYP");
              YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),YI.get(),1)),m$.var("Y").get(),3));
              //<< . . . SET YDECIMALLEN=2                                 ;TYBD;26328;15,10,2004;DECIMALKOMMASTELLEN
              mVar YDECIMALLEN = m$.var("YDECIMALLEN");
              YDECIMALLEN.set(2);
              //<< . . . IF $DATA(^WWW122D(0,YFORM)) DO                    ;TYBD;30,07,2003;24066;FELDTYPE CUSTOMIZEING
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122D",0,m$.var("YFORM").get())))) {
                //<< . . . . set YDECIMALLEN = $$^WWWDECIMALLEN(YFORM,YI)
                YDECIMALLEN.set(m$.fnc$("WWWDECIMALLEN.main",m$.var("YFORM").get(),YI.get()));
              }
              //<< . . . ;
              //<< . . . IF $EXTRACT(YOPEN,1,4)="SAVE" SET YA=$$GetInternal^WWWTR(YTYP,YA)
              if (mOp.Equal(m$.Fnc.$extract(m$.var("YOPEN").get(),1,4),"SAVE")) {
                YA.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YA.get()));
              }
              //<< . . . ;
              //<< . . . SET $PIECE(YFELD,Y,YI)=$TRANSLATE(YA,Y,",")
              m$.pieceVar(YFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$translate(YA.get(),m$.var("Y").get(),","));
              //<< . . . IF YTYP=3 IF $ORDER(^WWW003(0,YDATEI,YI))="" SET $PIECE(YFELD,Y,YI)=YA  ;TEXT
              if (mOp.Equal(YTYP.get(),3)) {
                if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW003",0,YDATEI.get(),YI.get())),"")) {
                  m$.pieceVar(YFELD,m$.var("Y").get(),YI.get()).set(YA.get());
                }
              }
              //<< . . . IF $FIND(YA,"C:") SET $PIECE(YFELD,Y,YI)=$TRANSLATE(YA,$CHAR(214)_"'","/"_"""")  ;DATEI ;data file
              if (mOp.Logical(m$.Fnc.$find(YA.get(),"C:"))) {
                m$.pieceVar(YFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$translate(YA.get(),mOp.Concat(m$.Fnc.$char(214),"'"),mOp.Concat("/","\"")));
              }
            }
          }
        }
        //<< . ;
        //<< . SET YMAXKEY=+$ORDER(^WWW122(0,YFORM,""),-1) IF YMAXKEY'="" DO   ;MANUELLE
        YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW122",0,m$.var("YFORM").get(),""),mOp.Negative(1))));
        if (mOp.NotEqual(YMAXKEY.get(),"")) {
          //<< . . FOR YI=1:1:YMAXKEY SET YA=$GET(%(YQUERY,"Y"_YFORM_"M"_YI)) IF $PIECE($GET(^WWW122(0,YFORM,YI,1)),Y,1)="" DO
          for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
            YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),YI.get()))));
            if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YI.get(),1)),m$.var("Y").get(),1),"")) {
              //<< . . . DO MULTM
              m$.Cmd.Do("MULTM");
              //<< . . . SET YM(YI)=$TRANSLATE(YA,";"_Y,",,")
              mVar YM = m$.var("YM");
              YM.var(YI.get()).set(m$.Fnc.$translate(YA.get(),mOp.Concat(";",m$.var("Y").get()),",,"));
              //<< . . . IF YA'="" DO                                         ;MANUELLE
              if (mOp.NotEqual(YA.get(),"")) {
                do {
                  //<< . . . . QUIT:$PIECE($GET(^WWW122(0,YFORM,YI,1)),Y,1)'=""   ;KEIN MANUELLER ;no
                  if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YI.get(),1)),m$.var("Y").get(),1),"")) {
                    break;
                  }
                  //<< . . . . IF YOPEN'=2 QUIT:$EXTRACT(YOPEN,1,4)'="SAVE"       ;ZWISCHENSPEICHER FÜR MANUELLE ;to
                  if (mOp.NotEqual(m$.var("YOPEN").get(),2)) {
                    if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YOPEN").get(),1,4),"SAVE")) {
                      break;
                    }
                  }
                  //<< . . . . SET YTYP=$PIECE($GET(^WWW122(0,YFORM,YI,1)),Y,5)
                  mVar YTYP = m$.var("YTYP");
                  YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YI.get(),1)),m$.var("Y").get(),5));
                  //<< . . . . SET $PIECE(YMFELD,Y,YI)=$TRANSLATE($$GetInternal^WWWTR(YTYP,YA),Y,",")
                  m$.pieceVar(YMFELD,m$.var("Y").get(),YI.get()).set(m$.Fnc.$translate(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YA.get()),m$.var("Y").get(),","));
                } while (false);
              }
            }
          }
        }
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< if YMFELD '= "" do SaveRecallRecord^WWWRECALL(YBED,YFORM,"M",YMFELD)
    if (mOp.NotEqual(YMFELD.get(),"")) {
      m$.Cmd.Do("WWWRECALL.SaveRecallRecord",m$.var("YBED").get(),m$.var("YFORM").get(),"M",YMFELD.get());
    }
    //<< 
    //<< ; MENUFORM
    //<< if ($$$WWW120FormType(YVOR)=6) || ($get(%(YQUERY,"Y"_YFORM_"P0"))'="") {
    if ((mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,YVOR),6)) || (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P0"))),""))) {
      //<< if YKEY(1)="" {
      if (mOp.Equal(YKEY.var(1).get(),"")) {
        //<< if $get(%(YQUERY,"Y"_YFORM_"P0"))'="" set YKEY(1)=%(YQUERY,"Y"_YFORM_"P0")
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P0"))),"")) {
          YKEY.var(1).set(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P0")).get());
        }
      }
      //<< } else {
      else {
        //<< set YKEY(1)=%(YQUERY,"Y"_YFORM_"P0")_$translate(YKEY(1)," /","_")_"/"  ;FORM WIE MENU:_"/"
        YKEY.var(1).set(mOp.Concat(mOp.Concat(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P0")).get(),m$.Fnc.$translate(YKEY.var(1).get()," /","_")),"/"));
      }
    }
    //<< }
    //<< }
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< MULTD ;MULTIEINGABE DATENFELDER
  public void MULTD() {
    //<< NEW YII,YIII
    mVar YII = m$.var("YII");
    mVar YIII = m$.var("YIII");
    m$.newVar(YII,YIII);
    //<< 
    //<< IF $DATA(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"Y"_YFORM_"D"_YI,1)) DO  QUIT   ;MULTISELECT FELD ;field
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),m$.var("YI").get()),1)))) {
      //<< . SET YA=$PIECE($GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"Y"_YFORM_"D"_YI,1)),Y,2)
      mVar YA = m$.var("YA");
      YA.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),m$.var("YI").get()),1)),m$.var("Y").get(),2));
      //<< . IF $EXTRACT($REVERSE(YA))=";" SET YA=$REVERSE($EXTRACT($REVERSE(YA),2,9999))
      if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(YA.get())),";")) {
        YA.set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(YA.get()),2,9999)));
      }
      return;
    }
    //<< 
    //<< SET YII=""
    YII.set("");
    //<< FOR  SET YII=$ORDER(%(YQUERY,"Y"_YFORM_"D"_YI,YII)) QUIT:YII=""  DO
    for (;true;) {
      YII.set(m$.Fnc.$order(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),m$.var("YI").get()),YII.get())));
      if (mOp.Equal(YII.get(),"")) {
        break;
      }
      //<< . IF $GET(%(YQUERY,"Y"_YFORM_"D"_YI,YII))'="" SET:YA'="" YA=YA_";" SET YA=YA_$GET(%(YQUERY,"Y"_YFORM_"D"_YI,YII))
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),m$.var("YI").get()),YII.get())),"")) {
        if (mOp.NotEqual(m$.var("YA").get(),"")) {
          m$.var("YA").set(mOp.Concat(m$.var("YA").get(),";"));
        }
        mVar YA = m$.var("YA");
        YA.set(mOp.Concat(m$.var("YA").get(),m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),m$.var("YI").get()),YII.get()))));
      }
      //<< . SET YIII=""
      YIII.set("");
      //<< . FOR  SET YIII=$ORDER(%(YQUERY,"Y"_YFORM_"D"_YI,YII,YIII)) QUIT:YIII=""  DO
      for (;true;) {
        YIII.set(m$.Fnc.$order(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),m$.var("YI").get()),YII.get(),YIII.get())));
        if (mOp.Equal(YIII.get(),"")) {
          break;
        }
        //<< . . IF $GET(%(YQUERY,"Y"_YFORM_"D"_YI,YII,YIII))'="" SET YA=YA_$GET(%(YQUERY,"Y"_YFORM_"D"_YI,YII,YIII))
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),m$.var("YI").get()),YII.get(),YIII.get())),"")) {
          mVar YA = m$.var("YA");
          YA.set(mOp.Concat(m$.var("YA").get(),m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),m$.var("YI").get()),YII.get(),YIII.get()))));
        }
      }
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< MULTM ;MULTIEINGABE MANUELLE FELDER
  public void MULTM() {
    //<< NEW YII
    mVar YII = m$.var("YII");
    m$.newVar(YII);
    //<< 
    //<< IF $DATA(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"Y"_YFORM_"M"_YI,1)) DO  QUIT   ;MULTISELECT FELD ;field
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),m$.var("YI").get()),1)))) {
      //<< . SET YA=$PIECE($GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"Y"_YFORM_"M"_YI,1)),Y,2)
      mVar YA = m$.var("YA");
      YA.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),m$.var("YI").get()),1)),m$.var("Y").get(),2));
      //<< . IF $EXTRACT($REVERSE(YA))=";" SET YA=$REVERSE($EXTRACT($REVERSE(YA),2,9999))
      if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(YA.get())),";")) {
        YA.set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(YA.get()),2,9999)));
      }
      return;
    }
    //<< 
    //<< SET YII=""
    YII.set("");
    //<< FOR  SET YII=$ORDER(%(YQUERY,"Y"_YFORM_"M"_YI,YII)) QUIT:YII=""  DO
    for (;true;) {
      YII.set(m$.Fnc.$order(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),m$.var("YI").get()),YII.get())));
      if (mOp.Equal(YII.get(),"")) {
        break;
      }
      //<< . IF $GET(%(YQUERY,"Y"_YFORM_"M"_YI,YII))'="" SET:YA'="" YA=YA_";" SET YA=YA_$GET(%(YQUERY,"Y"_YFORM_"M"_YI,YII))
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),m$.var("YI").get()),YII.get())),"")) {
        if (mOp.NotEqual(m$.var("YA").get(),"")) {
          m$.var("YA").set(mOp.Concat(m$.var("YA").get(),";"));
        }
        mVar YA = m$.var("YA");
        YA.set(mOp.Concat(m$.var("YA").get(),m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),m$.var("YI").get()),YII.get()))));
      }
      //<< . SET YIII=""
      mVar YIII = m$.var("YIII");
      YIII.set("");
      //<< . FOR  SET YIII=$ORDER(%(YQUERY,"Y"_YFORM_"M"_YI,YII,YIII)) QUIT:YIII=""  DO
      for (;true;) {
        YIII.set(m$.Fnc.$order(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),m$.var("YI").get()),YII.get(),YIII.get())));
        if (mOp.Equal(YIII.get(),"")) {
          break;
        }
        //<< . . IF $GET(%(YQUERY,"Y"_YFORM_"M"_YI,YII,YIII))'="" SET YA=YA_$GET(%(YQUERY,"Y"_YFORM_"M"_YI,YII,YIII))
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),m$.var("YI").get()),YII.get(),YIII.get())),"")) {
          mVar YA = m$.var("YA");
          YA.set(mOp.Concat(m$.var("YA").get(),m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"M"),m$.var("YI").get()),YII.get(),YIII.get()))));
        }
      }
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< MULTL(YL)       ;MULTIEINGABE LISTFELDER
  public Object MULTL(Object ... _p) {
    mVar YL = m$.newVarRef("YL",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< NEW YII,YIII
    mVar YII = m$.var("YII");
    mVar YIII = m$.var("YIII");
    m$.newVar(YII,YIII);
    //<< 
    //<< SET YII=""
    YII.set("");
    //<< FOR  SET YII=$ORDER(%(YQUERY,YL,YII)) QUIT:YII=""  DO
    for (;true;) {
      YII.set(m$.Fnc.$order(m$.var("%",m$.var("YQUERY").get(),YL.get(),YII.get())));
      if (mOp.Equal(YII.get(),"")) {
        break;
      }
      //<< . IF $GET(%(YQUERY,YL,YII))'="" SET:YA'="" YA=YA_";" SET YA=YA_$GET(%(YQUERY,YL,YII))
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),YL.get(),YII.get())),"")) {
        if (mOp.NotEqual(m$.var("YA").get(),"")) {
          m$.var("YA").set(mOp.Concat(m$.var("YA").get(),";"));
        }
        mVar YA = m$.var("YA");
        YA.set(mOp.Concat(m$.var("YA").get(),m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),YL.get(),YII.get()))));
      }
      //<< . SET YIII=""
      YIII.set("");
      //<< . FOR  SET YIII=$ORDER(%(YQUERY,YL,YII,YIII)) QUIT:YIII=""  DO
      for (;true;) {
        YIII.set(m$.Fnc.$order(m$.var("%",m$.var("YQUERY").get(),YL.get(),YII.get(),YIII.get())));
        if (mOp.Equal(YIII.get(),"")) {
          break;
        }
        //<< . . IF $GET(%(YQUERY,YL,YII,YIII))'="" SET YA=YA_$GET(%(YQUERY,YL,YII,YIII))
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),YL.get(),YII.get(),YIII.get())),"")) {
          mVar YA = m$.var("YA");
          YA.set(mOp.Concat(m$.var("YA").get(),m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),YL.get(),YII.get(),YIII.get()))));
        }
      }
    }
    //<< 
    //<< QUIT
    return null;
  }

//<< 
//<< 
}
