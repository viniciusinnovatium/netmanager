//*****************************************************************************
//** TASC - ALPHALINC - MAC INPROJECT
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-08 12:25:41
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
//<< #include INConst
import include.INConst;

//<< INPROJECT(PROJECT)
public class INPROJECT extends mClass {

  public Object main(Object ... _p) {
    mVar PROJECT = m$.newVarRef("PROJECT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _INPROJECT(PROJECT);
  }

  public Object _INPROJECT(Object ... _p) {
    mVar PROJECT = m$.newVarRef("PROJECT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       PROKECTANZEIGE
    //<< ;
    //<< ; Inputs : PROJECT=PROJECTNUMMER
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 03.03.2002    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< SET PROJECT = $GET(PROJECT)
    PROJECT.set(m$.Fnc.$get(PROJECT));
    //<< QUIT:PROJECT=""
    if (mOp.Equal(PROJECT.get(),"")) {
      return null;
    }
    //<< 
    //<< NEW VERGANGEN,ZUKUNFT,TAG,WOCHE,AUF,POS,POS1,YOPTION,GESTARTET,YLEAUF,YLEPOS,NICHTOK,NICHTALLE
    mVar VERGANGEN = m$.var("VERGANGEN");
    mVar ZUKUNFT = m$.var("ZUKUNFT");
    mVar TAG = m$.var("TAG");
    mVar WOCHE = m$.var("WOCHE");
    mVar AUF = m$.var("AUF");
    mVar POS = m$.var("POS");
    mVar POS1 = m$.var("POS1");
    mVar YOPTION = m$.var("YOPTION");
    mVar GESTARTET = m$.var("GESTARTET");
    mVar YLEAUF = m$.var("YLEAUF");
    mVar YLEPOS = m$.var("YLEPOS");
    mVar NICHTOK = m$.var("NICHTOK");
    mVar NICHTALLE = m$.var("NICHTALLE");
    m$.newVar(VERGANGEN,ZUKUNFT,TAG,WOCHE,AUF,POS,POS1,YOPTION,GESTARTET,YLEAUF,YLEPOS,NICHTOK,NICHTALLE);
    //<< 
    //<< SET YLEAUF = $PIECE($GET(^WWW126(YM,"INAUFP",YBED,1,1)),Y,1)  ;LETZTE AUFTRAGSNUMMER ;last
    YLEAUF.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW126",m$.var("YM").get(),"INAUFP",m$.var("YBED").get(),1,1)),m$.var("Y").get(),1));
    //<< SET YLEPOS = $PIECE($GET(^WWW126(YM,"INAUFP",YBED,2,1)),Y,1)  ;LETZTE POSITIONSNUMMER ;last
    YLEPOS.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW126",m$.var("YM").get(),"INAUFP",m$.var("YBED").get(),2,1)),m$.var("Y").get(),1));
    //<< DO ^WWWFRAME(0,,,,1)  ;TABLE AN   ;11,2,2004;TYBD;HINTERGRUNDFARBE
    m$.Cmd.Do("WWWFRAME.main",0,null,null,null,1);
    //<< IF $DATA(^INAUFs(YM,14,$$^WWWUMLAU(PROJECT,1)))  DO HEADER  ;ÜBERSCHRIFT ;superscription
    if (mOp.Logical(m$.Fnc.$data(m$.var("^INAUFs",m$.var("YM").get(),14,m$.fnc$("WWWUMLAU.main",PROJECT.get(),1))))) {
      m$.Cmd.Do("HEADER");
    }
    //<< SET AUF=""
    AUF.set("");
    //<< FOR  SET AUF=$ORDER(^INAUFs(YM,14,$$^WWWUMLAU(PROJECT,1),AUF),-1) QUIT:AUF=""  DO  ;PROJECT
    for (;true;) {
      AUF.set(m$.Fnc.$order(m$.var("^INAUFs",m$.var("YM").get(),14,m$.fnc$("WWWUMLAU.main",PROJECT.get(),1),AUF.get()),mOp.Negative(1)));
      if (mOp.Equal(AUF.get(),"")) {
        break;
      }
      //<< . SET AUF1 = $GET(^INAUF(YM,AUF,1))
      mVar AUF1 = m$.var("AUF1");
      AUF1.set(m$.Fnc.$get(m$.var("^INAUF",m$.var("YM").get(),AUF.get(),1)));
      //<< . SET POS=""
      POS.set("");
      //<< . FOR  SET POS=$ORDER(^INAUFP(YM,AUF,POS)) QUIT:POS=""  DO
      for (;true;) {
        POS.set(m$.Fnc.$order(m$.var("^INAUFP",m$.var("YM").get(),AUF.get(),POS.get())));
        if (mOp.Equal(POS.get(),"")) {
          break;
        }
        do {
          //<< . . SET POS1=$GET(^INAUFP(YM,AUF,POS,1))  ;AUFTRAGSPOSITION
          POS1.set(m$.Fnc.$get(m$.var("^INAUFP",m$.var("YM").get(),AUF.get(),POS.get(),1)));
          //<< . . IF $PIECE(POS1,Y,19)="" SET $PIECE(POS1,Y,19)=$PIECE(AUF1,Y,19)   ;LIEFERTERMIN AUS AUFTRAG ;time of delivery out of order
          if (mOp.Equal(m$.Fnc.$piece(POS1.get(),m$.var("Y").get(),19),"")) {
            m$.pieceVar(POS1,m$.var("Y").get(),19).set(m$.Fnc.$piece(AUF1.get(),m$.var("Y").get(),19));
          }
          //<< . . ;IF +$PIECE(POS1,Y,7)'=4 IF $PIECE(POS1,Y,7)'=3 QUIT  ;BESTELL ODER LAGERWARE NICHT ANZEIGEN
          //<< . . ;IF +$PIECE(POS1,Y,60)=1 QUIT  ;ABGESCHLOSSENE POSITION  ;GGF ANDERE FARBE
          //<< . . IF +$PIECE(POS1,Y,9)=1 QUIT  ;STORNO POSITION
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(POS1.get(),m$.var("Y").get(),9)),1)) {
            break;
          }
          //<< . . DO ^INTIMEAUFP
          m$.Cmd.Do("INTIMEAUFP.main");
        } while (false);
      }
    }
    //<< 
    //<< DO ^WWWFRAME(1)  ;TABLE AUS  ;out of
    m$.Cmd.Do("WWWFRAME.main",1);
    //<< QUIT
    return null;
  }

  //<< 
  //<< HEADER ;KOPF DER WOCHEN  ;pate the weekly
  public void HEADER() {
    //<< SET VERGANGEN = $PIECE($GET(^INVORG(YM,YM,1)),Y,7)  ;WOCHEN IN VERGANGENHEIT ;weekly within past
    mVar VERGANGEN = m$.var("VERGANGEN");
    VERGANGEN.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)),m$.var("Y").get(),7));
    //<< IF +VERGANGEN=0 SET VERGANGEN = 7
    if (mOp.Equal(mOp.Positive(VERGANGEN.get()),0)) {
      VERGANGEN.set(7);
    }
    //<< SET ZUKUNFT = $PIECE($GET(^INVORG(YM,YM,1)),Y,8)  ;WOCHEN IN ZUKUNFT ;weekly within future
    mVar ZUKUNFT = m$.var("ZUKUNFT");
    ZUKUNFT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)),m$.var("Y").get(),8));
    //<< IF +ZUKUNFT=0 SET ZUKUNFT = 40
    if (mOp.Equal(mOp.Positive(ZUKUNFT.get()),0)) {
      ZUKUNFT.set(40);
    }
    //<< 
    //<< SET TAG   = $$^WWWDAY($HOROLOG)   ;TAG 1=MONTAG 2=DI, 3=MI,...
    mVar TAG = m$.var("TAG");
    TAG.set(m$.fnc$("WWWDAY.main",m$.Fnc.$horolog()));
    //<< SET TAG   = +$HOROLOG-TAG+1       ;MONTAG DER WOCHE ;Monday the week
    TAG.set(mOp.Add(mOp.Subtract(mOp.Positive(m$.Fnc.$horolog()),TAG.get()),1));
    //<< SET TAG   = TAG-(VERGANGEN*7)     ;10 WOCHEN ZURÜCK ;weekly back
    TAG.set(mOp.Subtract(TAG.get(),(mOp.Multiply(VERGANGEN.get(),7))));
    //<< SET WOCHE = $$^WWWWEEK($HOROLOG)  ;WOCHE HEUTE ;week today
    mVar WOCHE = m$.var("WOCHE");
    WOCHE.set(m$.fnc$("WWWWEEK.main",m$.Fnc.$horolog()));
    //<< 
    //<< WRITE "<TH VALIGN=TOP NOWRAP VALIGN=TOP align=LEFT ALIGN=LEFT"
    m$.Cmd.Write("<TH VALIGN=TOP NOWRAP VALIGN=TOP align=LEFT ALIGN=LEFT");
    //<< WRITE " BGCOLOR="_YDARKGRAY
    m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YDARKGRAY").get()));
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< WRITE $$^WWWTEXT(32047)   ;Auftrag ;Order  ;Order Order
    m$.Cmd.Write(m$.fnc$("WWWTEXT.main",32047));
    //<< WRITE "</TH>",YCR
    m$.Cmd.Write("</TH>",m$.var("YCR").get());
    //<< 
    //<< WRITE "<TH VALIGN=TOP NOWRAP VALIGN=TOP align=LEFT ALIGN=LEFT"
    m$.Cmd.Write("<TH VALIGN=TOP NOWRAP VALIGN=TOP align=LEFT ALIGN=LEFT");
    //<< WRITE " BGCOLOR="_YDARKGRAY
    m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YDARKGRAY").get()));
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< WRITE $$^WWWTEXT(32024)   ;Artikel ;Item  ;Item Item
    m$.Cmd.Write(m$.fnc$("WWWTEXT.main",32024));
    //<< WRITE "</TH>",YCR
    m$.Cmd.Write("</TH>",m$.var("YCR").get());
    //<< 
    //<< FOR WOCH=TAG:7:TAG+((VERGANGEN+ZUKUNFT)*7) DO  ;ZEITRAUM AUSWERTEN (JE VORGABE)
    mVar WOCH = m$.var("WOCH");
    for (WOCH.set(TAG.get());(mOp.LessOrEqual(WOCH.get(),mOp.Add(TAG.get(),(mOp.Multiply((mOp.Add(VERGANGEN.get(),ZUKUNFT.get())),7)))));WOCH.set(mOp.Add(WOCH.get(),7))) {
      //<< . NEW YBACK
      mVar YBACK = m$.var("YBACK");
      m$.newVarBlock(1,YBACK);
      //<< . SET WEEK=$$^WWWWEEK(WOCH)
      mVar WEEK = m$.var("WEEK");
      WEEK.set(m$.fnc$("WWWWEEK.main",WOCH.get()));
      //<< . WRITE "<TH VALIGN=TOP NOWRAP VALIGN=TOP align=LEFT"
      m$.Cmd.Write("<TH VALIGN=TOP NOWRAP VALIGN=TOP align=LEFT");
      //<< . IF WEEK'=WOCHE WRITE " BGCOLOR="_YDARKGRAY
      if (mOp.NotEqual(WEEK.get(),WOCHE.get())) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YDARKGRAY").get()));
      }
      //<< . IF WEEK=WOCHE  WRITE " BGCOLOR=PALEGOLDENROD"
      if (mOp.Equal(WEEK.get(),WOCHE.get())) {
        m$.Cmd.Write(" BGCOLOR=PALEGOLDENROD");
      }
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . WRITE "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< . WRITE "<A TITLE="_""""_$$^WWWDATE(WOCH)_"-"_$$^WWWDATE(WOCH+6)_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A TITLE=","\""),m$.fnc$("WWWDATE.main",WOCH.get())),"-"),m$.fnc$("WWWDATE.main",mOp.Add(WOCH.get(),6))),"\""));
      //<< . WRITE " HREF="
      m$.Cmd.Write(" HREF=");
      //<< . WRITE """"_"#"_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat("\"","#"),"\""));
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . ;W "&nbsp;"
      //<< . WRITE $EXTRACT(WEEK,1,2)_"."
      m$.Cmd.Write(mOp.Concat(m$.Fnc.$extract(WEEK.get(),1,2),"."));
      //<< . IF SPRACHE="DE"  WRITE "KW"
      if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
        m$.Cmd.Write("KW");
      }
      //<< . IF SPRACHE'="DE" WRITE $EXTRACT(WEEK,5,6)
      if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
        m$.Cmd.Write(m$.Fnc.$extract(WEEK.get(),5,6));
      }
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
      //<< . WRITE "</FONT></TH>",YCR
      m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< WRITE YCR,"</TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< IsProgramOutOfDateRange(pidINPROJECT,pdteDate)
  public Object IsProgramOutOfDateRange(Object ... _p) {
    mVar pidINPROJECT = m$.newVarRef("pidINPROJECT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines if the specified date falls outside of the date range of the project.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Dec-2009   shobby  SR17034: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnResult,objINPROJECT
    mVar blnResult = m$.var("blnResult");
    mVar objINPROJECT = m$.var("objINPROJECT");
    m$.newVar(blnResult,objINPROJECT);
    //<< 
    //<< set blnResult = $$$NO
    blnResult.set(include.COMSYS.$$$NO(m$));
    //<< if pidINPROJECT'="" {
    if (mOp.NotEqual(pidINPROJECT.get(),"")) {
      //<< set objINPROJECT = $get(^INPROJECT(YM,pidINPROJECT,1))
      objINPROJECT.set(m$.Fnc.$get(m$.var("^INPROJECT",m$.var("YM").get(),pidINPROJECT.get(),1)));
      //<< if ($$$INPROJECTProjectStart(objINPROJECT)'="") &&
      //<< ($$DateDiff^COMUtilDate(pdteDate,$$$INPROJECTProjectStart(objINPROJECT))>0) {
      if ((mOp.NotEqual(include.INConst.$$$INPROJECTProjectStart(m$,objINPROJECT),"")) && (mOp.Greater(m$.fnc$("COMUtilDate.DateDiff",pdteDate.get(),include.INConst.$$$INPROJECTProjectStart(m$,objINPROJECT)),0))) {
        //<< 
        //<< set blnResult = $$$YES
        blnResult.set(include.COMSYS.$$$YES(m$));
      }
      //<< }
      //<< if ($$$INPROJECTProjectEnd(objINPROJECT)'="") &&
      //<< ($$DateDiff^COMUtilDate(pdteDate,$$$INPROJECTProjectEnd(objINPROJECT))<0) {
      if ((mOp.NotEqual(include.INConst.$$$INPROJECTProjectEnd(m$,objINPROJECT),"")) && (mOp.Less(m$.fnc$("COMUtilDate.DateDiff",pdteDate.get(),include.INConst.$$$INPROJECTProjectEnd(m$,objINPROJECT)),0))) {
        //<< 
        //<< set blnResult = $$$YES
        blnResult.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnResult
    return blnResult.get();
  }

//<< 
//<< 
}
