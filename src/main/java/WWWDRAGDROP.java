//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWDRAGDROP
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

public class WWWDRAGDROP extends mClass {

  //<< 
  //<< WWWDRAGDROP(CHART,START,STOP)
  public Object main(Object ... _p) {
    mVar CHART = m$.newVarRef("CHART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar START = m$.newVarRef("START",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar STOP = m$.newVarRef("STOP",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return _WWWDRAGDROP(CHART,START,STOP);
  }

  public Object _WWWDRAGDROP(Object ... _p) {
    mVar CHART = m$.newVarRef("CHART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar START = m$.newVarRef("START",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar STOP = m$.newVarRef("STOP",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       DRAG AND DROP VON WINDOW KOMPONENTEN
    //<< ;
    //<< ; Inputs :
    //<< ;   CHART
    //<< ;   START
    //<< ;   STOP
    //<< ;
    //<< ; ByRef :
    //<< ;   YAUSWAHL
    //<< ;   YPRINTMODE
    //<< ;   YPARA
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 03-Jun-2010   GRF     SR17146: call "DD.MM.YYYY" wrapper for WWWDATE1
    //<< ; 04-Apr-2008   GM      SRBR014923: Changed $$^WWWTEXT() to $$$Text() for
    //<< ;                           language texts (53) and (54)
    //<< ; 24-Aug-2006   GRF     Doco; quits
    //<< ; 30.06.2003    FIS
    //<< ;-------------------------------------------------------------------------------
    //<< ;ÜBERSICHT DRAG DROP ROUTIONEN ! ;summary
    //<< ;WWWDRAGDROP(CHART,START,STOP)          DRAG AND DROP VON WINDOW KOMPONENTEN
    //<< ;WWWDRAGDROP1(POSITION,OBJEKT)          AUSFÜHREN OBJEKTVERSCHIEBUNG
    //<< ;WWWDRAGDROP2(YFUNCTION,OBJEKT)         AUSFÜHREN SPEICHER EVENT
    //<< ;WWWDRAGDROP3(YFUNCTION,OBJEKT)         AUSFÜHREN RECHTS CLICK EVENT
    //<< ;WWWDRAGDROP4()                         BEARBEITEN RETURNVALUE BEI DATENVERÄNDERUNG ;next to
    //<< ;WWWDRAGDROP5(YFUNC,YKEY)               AKTUALISIEREN HISTOGRAMM
    //<< ;WWWDRAGDROP6                           AUSWAHLFENSTER DRAG AND DROP FORM ;shape
    //<< ;WWWDRAGDROP7                           BUTTONLINE DRAG AND DROP FORMULAR ;form
    //<< ;WWWDRAGDROP8(START,STOP,TERMIN,INOUT)   KORRIGIEREN FEIERTAGE UND WOCHENENDE
    //<< ;WWWDRAGDROP9                           SETUPFENSTER
    //<< ;WWWDRAGDROP10                          DARSTELLEN DRAG AND DROP ELEMENTE ;impersonate
    //<< ;WWWDRAGDROP11(YINNER,YELEMENT)         BEARBEITUNGSFENSTER
    //<< ;WWWDRAGDROP12(YINHALT,YVAR)            DRAG AND DROP VON SPEICHERN SZENARIEN
    //<< ;WWWDRAGDROP13(YINHALT,YVAR)            DRAG AND DROP VON LADEN SZENARIEN
    //<< ;WWWDRAGDROP14(YINHALT,YVAR)            DRAG AND DROP VON SPEICHERN VON SETUPEINSTELLUNGEN
    //<< ;WWWDRAGDROP15(YINHALT,YVAR)            DRAG AND DROP VON LÖSCHEN SETUPEINSTELLUNGEN
    //<< ;WWWDRAGDROP16(YINHALT,YVAR)            SZENARIO BEENDEN
    //<< ;WWWDRAGDROP17                          AUSWAHLFENSTER SZENARIO LADEN / SPEICHERN ;charge Save
    //<< ;WWWDRAGDROP18                          AUSWAHLFENSTER FÜR ANZEIGEFILTER ;to
    //<< ;WWWDRAGDROP19                          SHOW DIAGRAMM
    //<< ;WWWDRAGDROP20(YINHALT,YVAR)            DRAG AND DROP VON löschen seznario
    //<< ;WWWDRAGDROP21                          BLÄTTERFUNKTION
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< set YAUSWAHL   = $get(YAUSWAHL)
    mVar YAUSWAHL = m$.var("YAUSWAHL");
    YAUSWAHL.set(m$.Fnc.$get(m$.var("YAUSWAHL")));
    //<< set YPRINTMODE = $get(YPRINTMODE)
    mVar YPRINTMODE = m$.var("YPRINTMODE");
    YPRINTMODE.set(m$.Fnc.$get(m$.var("YPRINTMODE")));
    //<< if ($get(YPARA)'="") && $find(YPARA,"-") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YPARA")),"")) && mOp.Logical(m$.Fnc.$find(m$.var("YPARA").get(),"-"))) {
      //<< if $get(START)="" set START = $piece(YPARA,"-",1)
      if (mOp.Equal(m$.Fnc.$get(START),"")) {
        START.set(m$.Fnc.$piece(m$.var("YPARA").get(),"-",1));
      }
      //<< if $get(STOP)=""  set STOP  = $piece(YPARA,"-",2)
      if (mOp.Equal(m$.Fnc.$get(STOP),"")) {
        STOP.set(m$.Fnc.$piece(m$.var("YPARA").get(),"-",2));
      }
    }
    //<< }
    //<< 
    //<< IF $GET(CHART)'="" KILL ^WWWDRAGDROPF(0,CHART,YBED)  ;LÖSCHEN FILTEREINSTELLUNGEN;FIS;25696;27.05.04
    if (mOp.NotEqual(m$.Fnc.$get(CHART),"")) {
      m$.var("^WWWDRAGDROPF",0,CHART.get(),m$.var("YBED").get()).kill();
    }
    //<< IF $GET(YPRINTMODE)=1 DO CHART($GET(CHART),$GET(START),$GET(STOP)) QUIT  ;OHNE FRAME ! ;FIS;02.01.04 ;without
    if (mOp.Equal(m$.Fnc.$get(YPRINTMODE),1)) {
      m$.Cmd.Do("CHART",m$.Fnc.$get(CHART),m$.Fnc.$get(START),m$.Fnc.$get(STOP));
      return null;
    }
    //<< 
    //<< NEW FRAMESIZE,LFN
    mVar FRAMESIZE = m$.var("FRAMESIZE");
    mVar LFN = m$.var("LFN");
    m$.newVar(FRAMESIZE,LFN);
    //<< SET FRAMESIZE=57
    FRAMESIZE.set(57);
    //<< ;SET LFN=""
    //<< ;FOR  SET LFN=$ORDER(^WWW124(YM,CHART,SPRACHE,LFN)) QUIT:LFN=""  DO  QUIT:FRAMESIZE'=57
    //<< ;.IF $PIECE($GET(^WWW124(YM,CHART,SPRACHE,LFN,1)),Y,2)=1 SET FRAMESIZE=88  ;2. BUTTONZEILE
    //<< 
    //<< SET LFN = ""
    LFN.set("");
    //<< FOR  SET LFN = $ORDER(^WWW124(0,CHART,SPRACHE,LFN)) QUIT:LFN=""  DO  QUIT:FRAMESIZE'=57
    for (;true;) {
      LFN.set(m$.Fnc.$order(m$.var("^WWW124",0,CHART.get(),m$.var("SPRACHE").get(),LFN.get())));
      if (mOp.Equal(LFN.get(),"")) {
        break;
      }
      //<< . IF $PIECE($GET(^WWW124(0,CHART,SPRACHE,LFN,1)),Y,2)=1 SET FRAMESIZE=88  ;2. BUTTONZEILE   ;BEC;25866;07.06.04;DA ZENTRALE DATEI
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW124",0,CHART.get(),m$.var("SPRACHE").get(),LFN.get(),1)),m$.var("Y").get(),2),1)) {
        FRAMESIZE.set(88);
      }
      if (mOp.NotEqual(FRAMESIZE.get(),57)) {
        break;
      }
    }
    //<< 
    //<< WRITE YCR,"<HTML>"
    m$.Cmd.Write(m$.var("YCR").get(),"<HTML>");
    //<< WRITE YCR,"<TITLE>"_YKOPF_"</TITLE>"  ;INTRASTAT-MELDUNG
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TITLE>",m$.var("YKOPF").get()),"</TITLE>"));
    //<< WRITE YCR,"<frameset rows="_""""_FRAMESIZE_",*"_""""_" BORDER=0 FRAMEBORDER=0 FRAMESPACING=0>"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<frameset rows=","\""),FRAMESIZE.get()),",*"),"\"")," BORDER=0 FRAMEBORDER=0 FRAMESPACING=0>"));
    //<< WRITE YCR,"<frame SRC="_""""_YAKTION_"EP=WWWMANU&amp;YFORM="_YFORM_"&amp;YEXEC=DO|KOPF^WWWDRAGDROP('"_$GET(CHART)_"','"_$GET(START)_"','"_$GET(STOP)_"')&amp;YAUSWAHL="_YAUSWAHL
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<frame SRC=","\""),m$.var("YAKTION").get()),"EP=WWWMANU&amp;YFORM="),m$.var("YFORM").get()),"&amp;YEXEC=DO|KOPF^WWWDRAGDROP('"),m$.Fnc.$get(CHART)),"','"),m$.Fnc.$get(START)),"','"),m$.Fnc.$get(STOP)),"')&amp;YAUSWAHL="),YAUSWAHL.get()));
    //<< DO ^WWWCGI
    m$.Cmd.Do("WWWCGI.main");
    //<< WRITE """"_" NAME="_""""_"head"_""""_" SCROLLING=no noresize>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("\""," NAME="),"\""),"head"),"\"")," SCROLLING=no noresize>"));
    //<< WRITE YCR,"<frame SRC="_""""_YAKTION_"EP=WWWMANU&amp;YFORM="_YFORM_"&amp;YEXEC=*DO|CHART^WWWDRAGDROP('"_$GET(CHART)_"','"_$GET(START)_"','"_$GET(STOP)_"')&amp;YAUSWAHL="_YAUSWAHL
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<frame SRC=","\""),m$.var("YAKTION").get()),"EP=WWWMANU&amp;YFORM="),m$.var("YFORM").get()),"&amp;YEXEC=*DO|CHART^WWWDRAGDROP('"),m$.Fnc.$get(CHART)),"','"),m$.Fnc.$get(START)),"','"),m$.Fnc.$get(STOP)),"')&amp;YAUSWAHL="),YAUSWAHL.get()));
    //<< DO ^WWWCGI
    m$.Cmd.Do("WWWCGI.main");
    //<< WRITE """"_" NAME="_""""_"chart"_""""_" SCROLLING=auto noresize>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("\""," NAME="),"\""),"chart"),"\"")," SCROLLING=auto noresize>"));
    //<< WRITE YCR,"</frameset>"
    m$.Cmd.Write(m$.var("YCR").get(),"</frameset>");
    //<< WRITE YCR,"</HTML>"
    m$.Cmd.Write(m$.var("YCR").get(),"</HTML>");
    //<< QUIT
    return null;
  }

  //<< 
  //<< 
  //<< KOPF(CHART,START,STOP)
  public Object KOPF(Object ... _p) {
    mVar CHART = m$.newVarRef("CHART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar START = m$.newVarRef("START",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar STOP = m$.newVarRef("STOP",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< NEW YHTMFORM,YNOEVENTKEY
    mVar YHTMFORM = m$.var("YHTMFORM");
    mVar YNOEVENTKEY = m$.var("YNOEVENTKEY");
    m$.newVar(YHTMFORM,YNOEVENTKEY);
    //<< 
    //<< SET YKOPF = $PIECE($GET(^WWW120(0,YFORM,1)),Y,1)
    mVar YKOPF = m$.var("YKOPF");
    YKOPF.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),1));
    //<< IF $DATA(^WWW1201(0,YFORM,SPRACHE,1)) SET YKOPF=$PIECE(^(1),Y,1)
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1201",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),1)))) {
      YKOPF.set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
    }
    //<< SET YHTMFORM="WWW"
    YHTMFORM.set("WWW");
    //<< WRITE YCR,YCR,"<FORM NAME="_""""_$GET(YHTMFORM)_""""_">"
    m$.Cmd.Write(m$.var("YCR").get(),m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FORM NAME=","\""),m$.Fnc.$get(YHTMFORM)),"\""),">"));
    //<< SET YNOEVENTKEY=1
    YNOEVENTKEY.set(1);
    //<< DO ^WWWFORM8
    m$.Cmd.Do("WWWFORM8.main");
    //<< DO EVENT^WWWFORM  ;CSP HYPEREVENT
    m$.Cmd.Do("WWWFORM.EVENT");
    //<< DO ^WWWKOPF(YKOPF)
    m$.Cmd.Do("WWWKOPF.main",YKOPF.get());
    //<< DO ^WWWDRAGDROP7  ;BUTTONLINE
    m$.Cmd.Do("WWWDRAGDROP7.main");
    //<< WRITE YCR,"</FORM>"
    m$.Cmd.Write(m$.var("YCR").get(),"</FORM>");
    //<< SET YNOFOOT=1
    mVar YNOFOOT = m$.var("YNOFOOT");
    YNOFOOT.set(1);
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< QUIT
    return null;
  }

  //<< 
  //<< 
  //<< CHART(CHART,START,STOP,PLUSMIN,VONBIS)
  public Object CHART(Object ... _p) {
    mVar CHART = m$.newVarRef("CHART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar START = m$.newVarRef("START",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar STOP = m$.newVarRef("STOP",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar PLUSMIN = m$.newVarRef("PLUSMIN",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar VONBIS = m$.newVarRef("VONBIS",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Inputs :
    //<< ;   CHART   = GANTT CHART (FORM)
    //<< ;   START   = AB DATUM ;take-off Confirm. Date
    //<< ;   STOP    = BIS DATUM  -> Z.ZT. KEINE FUKTION !! ;until Date no
    //<< ;   PLUSMIN = VOR / ZURÜCK IN ZEITSKALA ;pre- back within
    //<< ;   VONBIS  = BLÄTTERFUNKTION (Z.B. ANZEIGE 1-10 VON 100) ;Show
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   YFELD       objWWWDRAGDROPD
    //<< ;   YVOR        objWWW012
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< NEW ROWS,COLUMNS,PIXEL,HEADLAENG,HEADSIZE,LENGTH,MON,WEEK,DAY,UHR,YTIMEFORM,CHART1,COLORDARK,COLORLIGHT,SORT
    mVar ROWS = m$.var("ROWS");
    mVar COLUMNS = m$.var("COLUMNS");
    mVar PIXEL = m$.var("PIXEL");
    mVar HEADLAENG = m$.var("HEADLAENG");
    mVar HEADSIZE = m$.var("HEADSIZE");
    mVar LENGTH = m$.var("LENGTH");
    mVar MON = m$.var("MON");
    mVar WEEK = m$.var("WEEK");
    mVar DAY = m$.var("DAY");
    mVar UHR = m$.var("UHR");
    mVar YTIMEFORM = m$.var("YTIMEFORM");
    mVar CHART1 = m$.var("CHART1");
    mVar COLORDARK = m$.var("COLORDARK");
    mVar COLORLIGHT = m$.var("COLORLIGHT");
    mVar SORT = m$.var("SORT");
    m$.newVar(ROWS,COLUMNS,PIXEL,HEADLAENG,HEADSIZE,LENGTH,MON,WEEK,DAY,UHR,YTIMEFORM,CHART1,COLORDARK,COLORLIGHT,SORT);
    //<< NEW LINE,LEFTX,HISTSIZE,KEY,HEADER,ARBSTUNDEN,SIZE,FONTSIZE,TERMIN,DAUER,COLOR,DAUERX,LFN,YZA,YA,YZASIZE,DAUER2
    mVar LINE = m$.var("LINE");
    mVar LEFTX = m$.var("LEFTX");
    mVar HISTSIZE = m$.var("HISTSIZE");
    mVar KEY = m$.var("KEY");
    mVar HEADER = m$.var("HEADER");
    mVar ARBSTUNDEN = m$.var("ARBSTUNDEN");
    mVar SIZE = m$.var("SIZE");
    mVar FONTSIZE = m$.var("FONTSIZE");
    mVar TERMIN = m$.var("TERMIN");
    mVar DAUER = m$.var("DAUER");
    mVar COLOR = m$.var("COLOR");
    mVar DAUERX = m$.var("DAUERX");
    mVar LFN = m$.var("LFN");
    mVar YZA = m$.var("YZA");
    mVar YA = m$.var("YA");
    mVar YZASIZE = m$.var("YZASIZE");
    mVar DAUER2 = m$.var("DAUER2");
    m$.newVar(LINE,LEFTX,HISTSIZE,KEY,HEADER,ARBSTUNDEN,SIZE,FONTSIZE,TERMIN,DAUER,COLOR,DAUERX,LFN,YZA,YA,YZASIZE,DAUER2);
    //<< NEW BUTTONLINE,YZAMAX,STUNDE,KEY2,SKEY,ARBBEGINN,YNOEVENTKEY,LINEAL,YKOPF,SORT2,YSETUP,RICHT,YZAMAX,READONLY
    mVar BUTTONLINE = m$.var("BUTTONLINE");
    mVar YZAMAX = m$.var("YZAMAX");
    mVar STUNDE = m$.var("STUNDE");
    mVar KEY2 = m$.var("KEY2");
    mVar SKEY = m$.var("SKEY");
    mVar ARBBEGINN = m$.var("ARBBEGINN");
    mVar YNOEVENTKEY = m$.var("YNOEVENTKEY");
    mVar LINEAL = m$.var("LINEAL");
    mVar YKOPF = m$.var("YKOPF");
    mVar SORT2 = m$.var("SORT2");
    mVar YSETUP = m$.var("YSETUP");
    mVar RICHT = m$.var("RICHT");
    mVar READONLY = m$.var("READONLY");
    m$.newVar(BUTTONLINE,YZAMAX,STUNDE,KEY2,SKEY,ARBBEGINN,YNOEVENTKEY,LINEAL,YKOPF,SORT2,YSETUP,RICHT,YZAMAX,READONLY);
    //<< NEW ZNR,ZNSTART,ZNSTOP,NEULADEN,DATLFN,CAL,LINK
    mVar ZNR = m$.var("ZNR");
    mVar ZNSTART = m$.var("ZNSTART");
    mVar ZNSTOP = m$.var("ZNSTOP");
    mVar NEULADEN = m$.var("NEULADEN");
    mVar DATLFN = m$.var("DATLFN");
    mVar CAL = m$.var("CAL");
    mVar LINK = m$.var("LINK");
    m$.newVar(ZNR,ZNSTART,ZNSTOP,NEULADEN,DATLFN,CAL,LINK);
    //<< 
    //<< ;HOLEN WERTE ;send for
    //<< ;-----------
    //<< SET CHART=$GET(CHART)
    CHART.set(m$.Fnc.$get(CHART));
    //<< IF CHART="" SET CHART=$ORDER(^WWWDRAGDROP(0,""))
    if (mOp.Equal(CHART.get(),"")) {
      CHART.set(m$.Fnc.$order(m$.var("^WWWDRAGDROP",0,"")));
    }
    //<< SET CHART1=$$VORG(CHART)   ;VORGABEN CHART
    CHART1.set(m$.fnc$("VORG",CHART.get()));
    //<< SET $PIECE(CHART1,Y,45)=1  ;IMMER IN NEUEM FENSTER ;constantly within window
    m$.pieceVar(CHART1,m$.var("Y").get(),45).set(1);
    //<< SET PIXEL=+$PIECE(CHART1,Y,1)  ;FELDGRÖSSE IN PIXEL ;within
    PIXEL.set(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),1)));
    //<< IF PIXEL=0 SET PIXEL=17
    if (mOp.Equal(PIXEL.get(),0)) {
      PIXEL.set(17);
    }
    //<< 
    //<< ;FELDER IM HEADER LAUT USER SETUP ;noisy
    //<< SET YSETUP=""
    YSETUP.set("");
    //<< SET YZA=0
    YZA.set(0);
    //<< SET YZAMAX=0
    YZAMAX.set(0);
    //<< SET YNUM=""
    mVar YNUM = m$.var("YNUM");
    YNUM.set("");
    //<< FOR  SET YNUM=$ORDER(^WWWDRAGDROPD(0,CHART,YNUM)) QUIT:YNUM=""  DO
    for (;true;) {
      YNUM.set(m$.Fnc.$order(m$.var("^WWWDRAGDROPD",0,CHART.get(),YNUM.get())));
      if (mOp.Equal(YNUM.get(),"")) {
        break;
      }
      //<< . SET YFELD = $GET(^WWWDRAGDROPD(0,CHART,YNUM,1))
      mVar YFELD = m$.var("YFELD");
      YFELD.set(m$.Fnc.$get(m$.var("^WWWDRAGDROPD",0,CHART.get(),YNUM.get(),1)));
      //<< . DO
      do {
        //<< . . IF $PIECE(YFELD,Y,20)=1 IF $DATA(^WWWDRAGDROPDU(0,CHART,YBED,1)) DO  QUIT
        if (mOp.Equal(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),20),1)) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDRAGDROPDU",0,CHART.get(),m$.var("YBED").get(),1)))) {
            //<< . . . SET $PIECE(YSETUP,Y,YNUM)=$PIECE(^(1),Y,YNUM)
            m$.pieceVar(YSETUP,m$.var("Y").get(),YNUM.get()).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),YNUM.get()));
            break;
          }
        }
        //<< . . ;
        //<< . . SET $PIECE(YSETUP,Y,YNUM)=$PIECE(YFELD,Y,5)
        m$.pieceVar(YSETUP,m$.var("Y").get(),YNUM.get()).set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),5));
      } while(false);
      //<< . ;
      //<< . IF $PIECE(YSETUP,Y,YNUM)=1 DO
      if (mOp.Equal(m$.Fnc.$piece(YSETUP.get(),m$.var("Y").get(),YNUM.get()),1)) {
        //<< . . SET YZA=YZA+1  ;ANZAHL FELDER ;Number
        YZA.set(mOp.Add(YZA.get(),1));
        //<< . . IF +$PIECE(YFELD,Y,16)'>0 SET $PIECE(YFELD,Y,16)=4*PIXEL  ;DFLT.
        if (mOp.NotGreater(mOp.Positive(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),16)),0)) {
          m$.pieceVar(YFELD,m$.var("Y").get(),16).set(mOp.Multiply(4,PIXEL.get()));
        }
        //<< . . SET $PIECE(YFELD,Y,16)=($PIECE(YFELD,Y,16)\PIXEL)*PIXEL
        m$.pieceVar(YFELD,m$.var("Y").get(),16).set(mOp.Multiply((mOp.IntegerDivide(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),16),PIXEL.get())),PIXEL.get()));
        //<< . . SET YZAMAX=YZAMAX+$PIECE(YFELD,Y,16)
        YZAMAX.set(mOp.Add(YZAMAX.get(),m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),16)));
      }
    }
    //<< 
    //<< ;ERMITTELN START UND STOP ;find take-off And
    //<< SET START = $GET(START)  ;STARTDATUM
    START.set(m$.Fnc.$get(START));
    //<< SET STOP  = $GET(STOP)  ;STOPDATUM
    STOP.set(m$.Fnc.$get(STOP));
    //<< IF START="" SET START = $GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","YSTARTDATE",1))  ;AUS ZWISCHENDATEI ;out of
    if (mOp.Equal(START.get(),"")) {
      START.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","YSTARTDATE",1)));
    }
    //<< SET START=$PIECE(START,".",1)   ;WENN KALENDERWOCHE ;when calendar week
    START.set(m$.Fnc.$piece(START.get(),".",1));
    //<< IF START="" SET START=+$HOROLOG
    if (mOp.Equal(START.get(),"")) {
      START.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< IF +$PIECE(CHART1,Y,31)=0 SET $PIECE(CHART1,Y,31)=5
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),31)),0)) {
      m$.pieceVar(CHART1,m$.var("Y").get(),31).set(5);
    }
    //<< IF +$GET(PLUSMIN)=1 DO  ;ZURÜCK ;retro-  ;back
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(PLUSMIN)),1)) {
      //<< . SET START = START-$PIECE(CHART1,Y,31)
      START.set(mOp.Subtract(START.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),31)));
      //<< . SET STOP  = START+$PIECE(CHART1,Y,31)   ;ANZAHL TAGE AUS VORGABE ;Number out of default
      STOP.set(mOp.Add(START.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),31)));
    }
    //<< 
    //<< IF +$GET(PLUSMIN)=2 DO  ;VOR ;pre-
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(PLUSMIN)),2)) {
      //<< . SET START = START+$PIECE(CHART1,Y,31)
      START.set(mOp.Add(START.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),31)));
      //<< . SET STOP  = START+$PIECE(CHART1,Y,31)   ;ANZAHL TAGE AUS VORGABE ;Number out of default
      STOP.set(mOp.Add(START.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),31)));
    }
    //<< 
    //<< IF STOP="" SET STOP = START+$PIECE(CHART1,Y,31)   ;ANZAHL TAGE AUS VORGABE ;Number out of default
    if (mOp.Equal(STOP.get(),"")) {
      STOP.set(mOp.Add(START.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),31)));
    }
    //<< SET CAL=$PIECE(CHART1,Y,36)  ;KALENDERVORGABE
    CAL.set(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),36));
    //<< IF CAL="" SET CAL=$PIECE($GET(^WWW0121(0,YM,YLOCATION,1)),Y,54)  ;DFLT. KALENDER BETRIEB ;calendar location
    if (mOp.Equal(CAL.get(),"")) {
      CAL.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0121",0,m$.var("YM").get(),m$.var("YLOCATION").get(),1)),m$.var("Y").get(),54));
    }
    //<< IF $PIECE(CHART1,Y,37)=1 IF +$PIECE(CHART1,Y,5)=1 DO  ;NUR ARBEITSTAGE ANZEIGEN ;only display
    if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),37),1)) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),5)),1)) {
        //<< . IF +$GET(PLUSMIN)'=0 FOR  QUIT:$$^WWWCALDAY(START,CAL)=0  SET START=START-1
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(PLUSMIN)),0)) {
          for (;true;) {
            if (mOp.Equal(m$.fnc$("WWWCALDAY.main",START.get(),CAL.get()),0)) {
              break;
            }
            START.set(mOp.Subtract(START.get(),1));
          }
        }
        //<< . IF +$GET(PLUSMIN)=0  FOR  QUIT:$$^WWWCALDAY(START,CAL)=0  SET START=START+1
        if (mOp.Equal(mOp.Positive(m$.Fnc.$get(PLUSMIN)),0)) {
          for (;true;) {
            if (mOp.Equal(m$.fnc$("WWWCALDAY.main",START.get(),CAL.get()),0)) {
              break;
            }
            START.set(mOp.Add(START.get(),1));
          }
        }
      }
    }
    //<< 
    //<< IF ($PIECE(CHART1,Y,21)="") || ($PIECE(CHART1,Y,22)="") WRITE $$^WWWTEXT(46) QUIT  ; "No Data Available"
    if ((mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),21),"")) || (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),22),""))) {
      m$.Cmd.Write(m$.fnc$("WWWTEXT.main",46));
      return null;
    }
    //<< ;SET YKOPF=$PIECE($GET(^WWW120(YM,YFORM,1)),Y,1)  ;FORMULARNAME
    //<< SET YKOPF=$PIECE($GET(^WWW120(0,YFORM,1)),Y,1)  ;FORMULARNAME    ;BEC;25866;07.06.04;DA ZENTRALE DATEI
    YKOPF.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),1));
    //<< IF $DATA(^WWW1201(0,YFORM,SPRACHE,1)) SET YKOPF=$PIECE(^(1),Y,1)
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1201",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),1)))) {
      YKOPF.set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
    }
    //<< SET READONLY=+$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","YREADONLY",1))  ;DATEN NUR ANZEIGEN ;only display
    READONLY.set(mOp.Positive(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","YREADONLY",1))));
    //<< SET NORELOAD=+$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","YNORELOAD",1))  ;DATEN NICHT NEU AUFBEREITEN ;Not recent
    mVar NORELOAD = m$.var("NORELOAD");
    NORELOAD.set(mOp.Positive(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","YNORELOAD",1))));
    //<< IF $GET(YPRINTMODE)=1 SET READONLY=1,NORELOAD=1
    if (mOp.Equal(m$.Fnc.$get(m$.var("YPRINTMODE")),1)) {
      READONLY.set(1);
      NORELOAD.set(1);
    }
    //<< 
    //<< ;BLÄTTERFUNKTION
    //<< SET ZNSTART=1
    ZNSTART.set(1);
    //<< IF $GET(VONBIS)'="" IF $PIECE(CHART1,Y,60)=1 DO
    if (mOp.NotEqual(m$.Fnc.$get(VONBIS),"")) {
      if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),60),1)) {
        //<< . IF $PIECE(CHART1,Y,61)=1 SET NORELOAD=1  ;DATEN NICHT NEU LADEN ;Not recent charge
        if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),61),1)) {
          NORELOAD.set(1);
        }
        //<< . SET ZNSTART=+$EXTRACT(VONBIS,4,99)
        ZNSTART.set(mOp.Positive(m$.Fnc.$extract(VONBIS.get(),4,99)));
        //<< . IF $EXTRACT(VONBIS,1,3)="PLU" SET ZNSTART=(ZNSTART+(5*$PIECE(CHART1,Y,58)))
        if (mOp.Equal(m$.Fnc.$extract(VONBIS.get(),1,3),"PLU")) {
          ZNSTART.set((mOp.Add(ZNSTART.get(),(mOp.Multiply(5,m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),58))))));
        }
        //<< . IF $EXTRACT(VONBIS,1,3)="MIN" SET ZNSTART=(ZNSTART-(5*$PIECE(CHART1,Y,58)))
        if (mOp.Equal(m$.Fnc.$extract(VONBIS.get(),1,3),"MIN")) {
          ZNSTART.set((mOp.Subtract(ZNSTART.get(),(mOp.Multiply(5,m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),58))))));
        }
        //<< . IF $EXTRACT(VONBIS,1,3)="OLD" SET ZNSTART=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","ZNSTART",1))
        if (mOp.Equal(m$.Fnc.$extract(VONBIS.get(),1,3),"OLD")) {
          ZNSTART.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","ZNSTART",1)));
        }
        //<< . IF ZNSTART<1 SET ZNSTART=1
        if (mOp.Less(ZNSTART.get(),1)) {
          ZNSTART.set(1);
        }
      }
    }
    //<< 
    //<< SET ZNSTOP=ZNSTART+$PIECE(CHART1,Y,58)-1
    ZNSTOP.set(mOp.Subtract(mOp.Add(ZNSTART.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),58)),1));
    //<< 
    //<< ;ANZEIGEWERTE
    //<< SET ROWS      = 0  ;ANZAHL ZEILEN ;Number
    ROWS.set(0);
    //<< SET COLUMNS   = 0  ;ANZAHL SPALTEN ;Number split
    COLUMNS.set(0);
    //<< SET HEADLAENG = 0
    HEADLAENG.set(0);
    //<< IF YZAMAX'=0 SET HEADLAENG=$JUSTIFY(YZAMAX/PIXEL,0,0)
    if (mOp.NotEqual(YZAMAX.get(),0)) {
      HEADLAENG.set(m$.Fnc.$justify(mOp.Divide(YZAMAX.get(),PIXEL.get()),0,0));
    }
    //<< SET HEADSIZE  = 0
    HEADSIZE.set(0);
    //<< SET MON       =+$PIECE(CHART1,Y,3)
    MON.set(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),3)));
    //<< SET WEK       =+$PIECE(CHART1,Y,4)
    mVar WEK = m$.var("WEK");
    WEK.set(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),4)));
    //<< SET DAY       =+$PIECE(CHART1,Y,5)
    DAY.set(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),5)));
    //<< SET UHR       =+$PIECE(CHART1,Y,6)
    UHR.set(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),6)));
    //<< SET HISTSIZE  =+$PIECE(CHART1,Y,23)
    HISTSIZE.set(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),23)));
    //<< SET HISTCOLOR = $PIECE(CHART1,Y,25)
    mVar HISTCOLOR = m$.var("HISTCOLOR");
    HISTCOLOR.set(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),25));
    //<< IF HISTCOLOR'="" SET HISTCOLOR=$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,HISTCOLOR,1)),Y,1)
    if (mOp.NotEqual(HISTCOLOR.get(),"")) {
      HISTCOLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),HISTCOLOR.get(),1)),m$.var("Y").get(),1));
    }
    //<< IF HISTCOLOR=""  SET HISTCOLOR="blue"
    if (mOp.Equal(HISTCOLOR.get(),"")) {
      HISTCOLOR.set("blue");
    }
    //<< SET FONTSIZE=+$PIECE(CHART1,Y,32)  ;SCHRIFTGRÖßE IN PIXEL ;within
    FONTSIZE.set(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),32)));
    //<< IF FONTSIZE=0 SET FONTSIZE=8
    if (mOp.Equal(FONTSIZE.get(),0)) {
      FONTSIZE.set(8);
    }
    //<< SET BUTTONLINE=0  ;ZEILE ÜBER TABELLE ;via tabulation
    BUTTONLINE.set(0);
    //<< IF $PIECE(CHART1,Y,60)=1 IF $GET(YPRINTMODE)'=1 SET BUTTONLINE=(((FONTSIZE+2)*4)+5)  ;PLATZ FÜR BLÄTTERFUNKTION ;square to
    if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),60),1)) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YPRINTMODE")),1)) {
        BUTTONLINE.set((mOp.Add((mOp.Multiply((mOp.Add(FONTSIZE.get(),2)),4)),5)));
      }
    }
    //<< SET YAUSWAHL=$GET(YAUSWAHL)
    mVar YAUSWAHL = m$.var("YAUSWAHL");
    YAUSWAHL.set(m$.Fnc.$get(m$.var("YAUSWAHL")));
    //<< SET YHTMFORM="WWW"
    mVar YHTMFORM = m$.var("YHTMFORM");
    YHTMFORM.set("WWW");
    //<< SET COLORDARK=$PIECE($GET(^WWW012(0,YM,1)),Y,15)
    COLORDARK.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),15));
    //<< IF COLORDARK'=""                           SET COLORDARK=$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,COLORDARK,1)),Y,1)
    if (mOp.NotEqual(COLORDARK.get(),"")) {
      COLORDARK.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),COLORDARK.get(),1)),m$.var("Y").get(),1));
    }
    //<< IF (COLORDARK="")!($PIECE(CHART1,Y,7)'=1)  SET COLORDARK="black"
    if (mOp.Logical(mOp.Or((mOp.Equal(COLORDARK.get(),"")),(mOp.NotEqual(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),7),1))))) {
      COLORDARK.set("black");
    }
    //<< SET COLORLIGHT=$PIECE($GET(^WWW012(0,YM,1)),Y,14)
    COLORLIGHT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),14));
    //<< IF COLORLIGHT'=""                          SET COLORLIGHT=$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,COLORLIGHT,1)),Y,1)
    if (mOp.NotEqual(COLORLIGHT.get(),"")) {
      COLORLIGHT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),COLORLIGHT.get(),1)),m$.var("Y").get(),1));
    }
    //<< IF (COLORLIGHT="")!($PIECE(CHART1,Y,7)'=1) SET COLORLIGHT="black"
    if (mOp.Logical(mOp.Or((mOp.Equal(COLORLIGHT.get(),"")),(mOp.NotEqual(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),7),1))))) {
      COLORLIGHT.set("black");
    }
    do {
      //<< 
      //<< DO  ;VORAUSWAHL UND SORTIERUNG ;And sorting
      //<< . NEW SORTFELD
      mVar SORTFELD = m$.var("SORTFELD");
      m$.newVarBlock(1,SORTFELD);
      //<< . SET SORTFELD=$PIECE(CHART1,Y,40)  ;FELD FÜR SORTIERUNG ;field to sorting
      SORTFELD.set(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),40));
      //<< . IF $EXTRACT(YAUSWAHL)="*" DO
      if (mOp.Equal(m$.Fnc.$extract(YAUSWAHL.get()),"*")) {
        do {
          //<< . . IF $EXTRACT(YAUSWAHL,2,99)="" DO  QUIT
          if (mOp.Equal(m$.Fnc.$extract(YAUSWAHL.get(),2,99),"")) {
            //<< . . . KILL ^WWWDRAGDROPF(0,CHART,YBED)  ;LÖSCHEN FILTEREINSTELLUNGEN ;Delete
            m$.var("^WWWDRAGDROPF",0,CHART.get(),m$.var("YBED").get()).kill();
            //<< . . . SET YAUSWAHL=""
            YAUSWAHL.set("");
            break;
          }
          //<< . . ;
          //<< . . SET SORTFELD=$PIECE(YAUSWAHL,"*",2)
          SORTFELD.set(m$.Fnc.$piece(YAUSWAHL.get(),"*",2));
          //<< . . SET YAUSWAHL=$PIECE(YAUSWAHL,"*",3,99)
          YAUSWAHL.set(m$.Fnc.$piece(YAUSWAHL.get(),"*",3,99));
        } while (false);
      }
      //<< . ;
      //<< . IF SORTFELD="" DO
      if (mOp.Equal(SORTFELD.get(),"")) {
        //<< . . NEW YNUM
        m$.newVarBlock(2,YNUM);
        //<< . . SET YNUM=""
        YNUM.set("");
        //<< . . FOR  SET YNUM=$ORDER(^WWWDRAGDROPD(0,CHART,YNUM)) QUIT:YNUM=""  DO  QUIT:SORTFELD'=""
        for (;true;) {
          YNUM.set(m$.Fnc.$order(m$.var("^WWWDRAGDROPD",0,CHART.get(),YNUM.get())));
          if (mOp.Equal(YNUM.get(),"")) {
            break;
          }
          //<< . . . IF $PIECE($GET(^WWWDRAGDROPD(0,CHART,YNUM,1)),Y,12)=1 SET SORTFELD=YNUM
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDRAGDROPD",0,CHART.get(),YNUM.get(),1)),m$.var("Y").get(),12),1)) {
            SORTFELD.set(YNUM.get());
          }
          if (mOp.NotEqual(SORTFELD.get(),"")) {
            break;
          }
        }
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . IF +SORTFELD=0 SET SORTFELD=1
      if (mOp.Equal(mOp.Positive(SORTFELD.get()),0)) {
        SORTFELD.set(1);
      }
      //<< . SET $PIECE(CHART1,Y,40)=SORTFELD
      m$.pieceVar(CHART1,m$.var("Y").get(),40).set(SORTFELD.get());
      //<< . ;SET $PIECE(^WWWDRAGDROP(0,CHART,1),Y,40)=SORTFELD  ;SPEICHERN SORTIERFELD
      //<< . IF $DATA(^WWWDRAGDROPU(0,CHART,YBED,1)) SET $PIECE(^(1),Y,40)=SORTFELD QUIT  ;ÜBERTRAGEN IN USERDATEI ;transport within
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDRAGDROPU",0,CHART.get(),m$.var("YBED").get(),1)))) {
        m$.pieceVar(m$.lastVar(1),m$.var("Y").get(),40).set(SORTFELD.get());
        break;
      }
      //<< . NEW FELDER,LFN,SATZ
      mVar FELDER = m$.var("FELDER");
      mVar SATZ = m$.var("SATZ");
      m$.newVarBlock(1,FELDER,LFN,SATZ);
      //<< . SET FELDER=$TRANSLATE($PIECE(CHART1,Y,47),",",";")
      FELDER.set(m$.Fnc.$translate(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),47),",",";"));
      //<< . SET SATZ=""
      SATZ.set("");
      //<< . FOR LFN=1:1 QUIT:$PIECE(FELDER,";",LFN,99)=""  DO
      for (LFN.set(1);(true);LFN.set(mOp.Add(LFN.get(),1))) {
        if (mOp.Equal(m$.Fnc.$piece(FELDER.get(),";",LFN.get(),99),"")) {
          break;
        }
        //<< . . SET $PIECE(SATZ,Y,$PIECE(FELDER,";",LFN))=$PIECE(CHART1,Y,$PIECE(FELDER,";",LFN))
        m$.pieceVar(SATZ,m$.var("Y").get(),m$.Fnc.$piece(FELDER.get(),";",LFN.get())).set(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),m$.Fnc.$piece(FELDER.get(),";",LFN.get())));
      }
      //<< . ;
      //<< . IF SATZ'="" SET ^WWWDRAGDROPU(0,CHART,YBED,1)=SATZ  ;NEUAUFBAU USERDATEI
      if (mOp.NotEqual(SATZ.get(),"")) {
        m$.var("^WWWDRAGDROPU",0,CHART.get(),m$.var("YBED").get(),1).set(SATZ.get());
      }
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< ;LÖSCHEN ALTE DATEN UND SPEICHERN NEUE WERTE ;Delete And Save
    //<< ;-------------------------------------------
    //<< IF NORELOAD'=1 KILL ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V")
    if (mOp.NotEqual(NORELOAD.get(),1)) {
      m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V").kill();
    }
    //<< KILL ^WWWSOR(YUSER)
    m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
    //<< SET ^WWWSOR(YUSER,"START")=START
    m$.var("^WWWSOR",m$.var("YUSER").get(),"START").set(START.get());
    //<< SET ^WWWSOR(YUSER,"STOP")=STOP
    m$.var("^WWWSOR",m$.var("YUSER").get(),"STOP").set(STOP.get());
    //<< SET ^WWWSOR(YUSER,"AUSWAHL")=$GET(YAUSWAHL)
    m$.var("^WWWSOR",m$.var("YUSER").get(),"AUSWAHL").set(m$.Fnc.$get(YAUSWAHL));
    //<< SET ^WWWSOR(YUSER,"CHART")=$GET(CHART)
    m$.var("^WWWSOR",m$.var("YUSER").get(),"CHART").set(m$.Fnc.$get(CHART));
    //<< IF $PIECE(CHART1,Y,37)=1 IF +$PIECE(CHART1,Y,5)=1 DO
    if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),37),1)) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),5)),1)) {
        //<< . FOR YI=START:1:STOP IF $$^WWWCALDAY(YI,CAL)'=0 SET ^WWWSOR(YUSER,"FEIERTAG",YI,1)=""
        mVar YI = m$.var("YI");
        for (YI.set(START.get());(mOp.LessOrEqual(YI.get(),STOP.get()));YI.set(mOp.Add(YI.get(),1))) {
          if (mOp.NotEqual(m$.fnc$("WWWCALDAY.main",YI.get(),CAL.get()),0)) {
            m$.var("^WWWSOR",m$.var("YUSER").get(),"FEIERTAG",YI.get(),1).set("");
          }
        }
        //<< . MERGE ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","FEIERTAG")=^WWWSOR(YUSER,"FEIERTAG")
        m$.Cmd.Merge(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","FEIERTAG"),m$.var("^WWWSOR",m$.var("YUSER").get(),"FEIERTAG"));
      }
    }
    //<< 
    //<< ;STARTEN HTML-SEITE ;launching
    //<< ;------------------
    //<< WRITE YCR,"<html>"
    m$.Cmd.Write(m$.var("YCR").get(),"<html>");
    //<< WRITE YCR,"<head>"
    m$.Cmd.Write(m$.var("YCR").get(),"<head>");
    //<< WRITE YCR,"<title>"_$GET(YKOPF)_"</title>"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<title>",m$.Fnc.$get(YKOPF)),"</title>"));
    //<< WRITE YCR,"<style type='text/css'>"
    m$.Cmd.Write(m$.var("YCR").get(),"<style type='text/css'>");
    //<< WRITE YCR,"<!--"
    m$.Cmd.Write(m$.var("YCR").get(),"<!--");
    //<< WRITE YCR,"  body, td, th {font-family:'Arial','SansSerif';}"
    m$.Cmd.Write(m$.var("YCR").get(),"  body, td, th {font-family:'Arial','SansSerif';}");
    //<< WRITE YCR,"  a {text-decoration:none}"
    m$.Cmd.Write(m$.var("YCR").get(),"  a {text-decoration:none}");
    //<< WRITE YCR,"  a:hover{color:blue; text-decoration:underline;}"
    m$.Cmd.Write(m$.var("YCR").get(),"  a:hover{color:blue; text-decoration:underline;}");
    //<< WRITE YCR,"  a:active {color:blue}"
    m$.Cmd.Write(m$.var("YCR").get(),"  a:active {color:blue}");
    //<< WRITE YCR,"//-->"
    m$.Cmd.Write(m$.var("YCR").get(),"//-->");
    //<< WRITE YCR,"</style>"
    m$.Cmd.Write(m$.var("YCR").get(),"</style>");
    //<< WRITE YCR,"</head>"
    m$.Cmd.Write(m$.var("YCR").get(),"</head>");
    //<< WRITE YCR,"<body bgcolor="_YSILVER_" texttop=0 topmargin=0 leftmargin=0 rightmargin=0"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<body bgcolor=",m$.var("YSILVER").get())," texttop=0 topmargin=0 leftmargin=0 rightmargin=0"));
    //<< 
    //<< NEW YVOR
    mVar YVOR = m$.var("YVOR");
    m$.newVar(YVOR);
    //<< SET YVOR=$GET(^WWW012(0,YM,1))
    YVOR.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< IF $PIECE(YVOR,Y,12)'=""  DO
    if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),12),"")) {
      //<< . WRITE YCR," TEXT="_""""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR,Y,12),1)),Y,1)_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(" TEXT=","\""),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),12),1)),m$.var("Y").get(),1)),"\""));
      //<< . WRITE YCR," LINK="_""""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR,Y,12),1)),Y,1)_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(" LINK=","\""),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),12),1)),m$.var("Y").get(),1)),"\""));
      //<< . WRITE YCR," ALINK="_""""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR,Y,12),1)),Y,1)_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(" ALINK=","\""),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),12),1)),m$.var("Y").get(),1)),"\""));
      //<< . WRITE YCR," VLINK="_""""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR,Y,12),1)),Y,1)_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(" VLINK=","\""),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),12),1)),m$.var("Y").get(),1)),"\""));
    }
    //<< 
    //<< WRITE YCR," onload="_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(" onload=","\""));
    //<< IF $GET(YPRINTMODE)=1  WRITE YCR,"document.getElementById('loadinfo').style.visibility='hidden'; window.print();"
    if (mOp.Equal(m$.Fnc.$get(m$.var("YPRINTMODE")),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"document.getElementById('loadinfo').style.visibility='hidden'; window.print();");
    }
    //<< IF $GET(YPRINTMODE)'=1 WRITE YCR,"draginit();"
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YPRINTMODE")),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"draginit();");
    }
    //<< WRITE """"_">"
    m$.Cmd.Write(mOp.Concat("\"",">"));
    //<< 
    //<< ;JAVA-SCRIPT
    //<< ;-----------
    //<< DO ^WWWDRAGDROPJ
    m$.Cmd.Do("WWWDRAGDROPJ.main");
    //<< 
    //<< ;STARTEN ANZEIGE ;launching Show
    //<< ;---------------
    //<< WRITE YCR,"<DIV"
    m$.Cmd.Write(m$.var("YCR").get(),"<DIV");
    //<< WRITE " style="_""""
    m$.Cmd.Write(mOp.Concat(" style=","\""));
    //<< WRITE " position:absolute;"
    m$.Cmd.Write(" position:absolute;");
    //<< WRITE " height:100%;"
    m$.Cmd.Write(" height:100%;");
    //<< WRITE " width:100%;"
    m$.Cmd.Write(" width:100%;");
    //<< WRITE " background-color:"_YSILVER_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" background-color:",m$.var("YSILVER").get()),";"));
    //<< WRITE " border:none;"
    m$.Cmd.Write(" border:none;");
    //<< WRITE """"
    m$.Cmd.Write("\"");
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< WRITE "<FORM NAME="_""""_YHTMFORM_""""_">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FORM NAME=","\""),YHTMFORM.get()),"\""),">"));
    //<< 
    //<< ;LADE FENSTER ;loading window
    //<< WRITE YCR,"<DIV id="_""""_"loadinfo"_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat("<DIV id=","\""),"loadinfo"),"\""));
    //<< WRITE YCR," style="_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(" style=","\""));
    //<< WRITE " position:absolute;"
    m$.Cmd.Write(" position:absolute;");
    //<< WRITE " border:2px solid;"
    m$.Cmd.Write(" border:2px solid;");
    //<< WRITE " border-Bottom-Color:"_COLORLIGHT_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Bottom-Color:",COLORLIGHT.get()),";"));
    //<< WRITE " border-Right-Color:"_COLORLIGHT_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Right-Color:",COLORLIGHT.get()),";"));
    //<< WRITE " border-Top-Color:"_COLORDARK_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Top-Color:",COLORDARK.get()),";"));
    //<< WRITE " border-Left-Color:"_COLORDARK_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Left-Color:",COLORDARK.get()),";"));
    //<< WRITE " background-color:"_YSILVER_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" background-color:",m$.var("YSILVER").get()),";"));
    //<< WRITE " top:200;"
    m$.Cmd.Write(" top:200;");
    //<< WRITE " left:300;"
    m$.Cmd.Write(" left:300;");
    //<< WRITE " width:250;"
    m$.Cmd.Write(" width:250;");
    //<< WRITE " height:65;"
    m$.Cmd.Write(" height:65;");
    //<< WRITE " overflow:visible;"
    m$.Cmd.Write(" overflow:visible;");
    //<< WRITE " font-family:arial; font-size:12px; font-weight:bold;"
    m$.Cmd.Write(" font-family:arial; font-size:12px; font-weight:bold;");
    //<< WRITE " text-align:center;"
    m$.Cmd.Write(" text-align:center;");
    //<< WRITE " white-space:nowrap;"
    m$.Cmd.Write(" white-space:nowrap;");
    //<< WRITE " color:"_YRED_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" color:",m$.var("YRED").get()),";"));
    //<< WRITE " padding:5;"
    m$.Cmd.Write(" padding:5;");
    //<< WRITE " z-index:10000;"
    m$.Cmd.Write(" z-index:10000;");
    //<< WRITE """"
    m$.Cmd.Write("\"");
    //<< WRITE YCR," onClick="_""""_"this.style.visibility='hidden';"_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(" onClick=","\""),"this.style.visibility='hidden';"),"\""));
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< WRITE YCR,"<fieldset style="_""""_"height:100%; width:100%;"_""""_">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<fieldset style=","\""),"height:100%; width:100%;"),"\""),">"));
    //<< WRITE "<br>&nbsp;"
    m$.Cmd.Write("<br>&nbsp;");
    //<< WRITE $$^WWWTEXT(33582)  ;"DATEN WERDEN GELADEN"
    m$.Cmd.Write(m$.fnc$("WWWTEXT.main",33582));
    //<< WRITE "&nbsp;"
    m$.Cmd.Write("&nbsp;");
    //<< WRITE YCR,"</fieldset>"
    m$.Cmd.Write(m$.var("YCR").get(),"</fieldset>");
    //<< WRITE YCR,"</DIV>"
    m$.Cmd.Write(m$.var("YCR").get(),"</DIV>");
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< ;WRITE YCR,"<script type="_""""_"text/javascript"_""""_">"
    //<< ;WRITE YCR,"<!--"
    //<< WRITE YCR," loadinfo();"     ;div positionieren
    m$.Cmd.Write(m$.var("YCR").get()," loadinfo();");
    //<< ;WRITE YCR,"//-->"
    //<< ;WRITE YCR,"</script>"
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< ;DATEN AUFBEREITEN
    //<< ;-----------------
    //<< IF NORELOAD'=1 DO  ;NUR WENN NEUER START UND NICHT SIMULATION ;only when take-off And Not simulation
    if (mOp.NotEqual(NORELOAD.get(),1)) {
      //<< . NEW YAUSWAHL,YPARA,VORG
      mVar YPARA = m$.var("YPARA");
      mVar VORG = m$.var("VORG");
      m$.newVarBlock(1,YAUSWAHL,YPARA,VORG);
      //<< . IF $PIECE(CHART1,Y,10)'="" XECUTE $PIECE(CHART1,Y,10)  ;EXECUTE ZUR DATENAUFBEREITUNG ;EXECUTE data preparation
      if (mOp.NotEqual(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),10),"")) {
        m$.Cmd.Xecute(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),10));
      }
    }
    m$.restoreVarBlock(1);
    do {
      //<< 
      //<< ;DATEN VORSORTIERUNG UND ANZAHL ZEILEN ERMITTELN ;And Number find
      //<< ;-----------------------------------------------
      //<< DO
      //<< . NEW SORTFELD,SORT,SORTAUSW,KEY2,SORT2,YFILTER,SATZ2
      mVar SORTFELD = m$.var("SORTFELD");
      mVar SORTAUSW = m$.var("SORTAUSW");
      mVar YFILTER = m$.var("YFILTER");
      mVar SATZ2 = m$.var("SATZ2");
      m$.newVarBlock(1,SORTFELD,SORT,SORTAUSW,KEY2,SORT2,YFILTER,SATZ2);
      //<< . SET SORTFELD=$PIECE(CHART1,Y,40)  ;FELD FÜR SORTIERUNG ;field to sorting
      SORTFELD.set(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),40));
      //<< . QUIT:+SORTFELD=0
      if (mOp.Equal(mOp.Positive(SORTFELD.get()),0)) {
        break;
      }
      //<< . SET CHARTD1=$GET(^WWWDRAGDROPD(0,CHART,SORTFELD,1))
      mVar CHARTD1 = m$.var("CHARTD1");
      CHARTD1.set(m$.Fnc.$get(m$.var("^WWWDRAGDROPD",0,CHART.get(),SORTFELD.get(),1)));
      //<< . SET SORTAUSW=+$PIECE(CHARTD1,Y,13)        ;AUSWAHL NUR WENN DATEN ;Selection only when
      SORTAUSW.set(mOp.Positive(m$.Fnc.$piece(CHARTD1.get(),m$.var("Y").get(),13)));
      //<< . IF $PIECE(CHARTD1,Y,9)="" SET SORTAUSW=1  ;KEINE RELATIONSDATEI=NUR VORHANDENE DATEN ;no
      if (mOp.Equal(m$.Fnc.$piece(CHARTD1.get(),m$.var("Y").get(),9),"")) {
        SORTAUSW.set(1);
      }
      //<< . SET LINEAL=+$PIECE(CHARTD1,Y,18)          ;ANZEIGE SUMMENBALKEN ;Show
      LINEAL.set(mOp.Positive(m$.Fnc.$piece(CHARTD1.get(),m$.var("Y").get(),18)));
      //<< . ;
      //<< . ;IF NORELOAD=1 DO  QUIT  ;RÜCKHOLEN ALTE DATEN
      //<< . . SET SORT=""
      //<< . . FOR  SET SORT=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT)) QUIT:SORT=""  DO
        //<< . . . SET SORT2=""
        //<< . . . FOR  SET SORT2=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT,SORT2)) QUIT:SORT2=""  DO
          //<< . . . . SET KEY=""
          //<< . . . . FOR  SET KEY=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT,SORT2,KEY)) QUIT:KEY=""  DO
            //<< . . . . . SET SATZ2=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATEN",KEY,1))  ;BEARBEITETER SATZ ;typesetting
            //<< . . . . . IF SATZ2="" SET SATZ2=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT,SORT2,KEY,1))  ;UNBEARBEITET
            //<< . . . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT,SORT2,KEY,1)=SATZ2
            //<< . . . . . SET ROWS=ROWS+1  ;ZEILEN ZÄHLEN
            //<< . . . . . SET KEY2=""
            //<< . . . . . FOR  SET KEY2=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENn",KEY,KEY2)) QUIT:KEY2=""  DO
              //<< . . . . . . SET SATZ2=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATEN",KEY_"%s%"_KEY2,1))  ;BEARBEITETER SATZ ;typesetting
              //<< . . . . . . IF SATZ2="" SET SATZ2=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENn",KEY,KEY2,1))  ;UNBEARBEITET
              //<< . . . . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENn",KEY,KEY2,1)=SATZ2
              //<< . . ;
              //<< . . SET DATLFN(1) = $GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATLFN1",1))
              //<< . . SET DATLFN(2) = $GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATLFN2",1))
              //<< . . IF $PIECE(CHART1,Y,61)=1 DO  ;RÜCKHOLEN DIAGRAMMLINIE
                //<< . . . SET ^WWWSOR(YUSER,"DATA1",1)=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATA1",1))
                //<< . . . SET ^WWWSOR(YUSER,"DATA1KEY",1)=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATA1KEY",1))
      //<< . ;
      //<< . SET KEY2 = ""
      KEY2.set("");
      //<< . SET KEY  = ""
      KEY.set("");
      //<< . FOR  SET KEY = $ORDER(^WWWSOR(YUSER,"DATEN",KEY)) QUIT:KEY=""  DO
      for (;true;) {
        KEY.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"DATEN",KEY.get())));
        if (mOp.Equal(KEY.get(),"")) {
          break;
        }
        //<< . . SET SATZ = $GET(^WWWSOR(YUSER,"DATEN",KEY,1))  ;WENN OHNE MEHRFACHKEY ;when without
        mVar SATZ = m$.var("SATZ");
        SATZ.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"DATEN",KEY.get(),1)));
        //<< . . IF SATZ'="" SET KEY2 = KEY
        if (mOp.NotEqual(SATZ.get(),"")) {
          KEY2.set(KEY.get());
        }
        //<< . . ;;;; DO:KEY2=KEY  IF KEY2="" FOR  SET KEY2=$ORDER(^WWWSOR(YUSER,"DATEN",KEY,KEY2))  QUIT:KEY2=""  SET SATZ="" DO
        //<< . . DO:KEY2=KEY
        if (mOp.Equal(KEY2.get(),KEY.get())) {
          do {
            //<< . . . IF SATZ="" SET SATZ=^WWWSOR(YUSER,"DATEN",KEY,KEY2,1)
            if (mOp.Equal(SATZ.get(),"")) {
              SATZ.set(m$.var("^WWWSOR",m$.var("YUSER").get(),"DATEN",KEY.get(),KEY2.get(),1).get());
            }
            //<< . . . IF $PIECE(SATZ,Y,$PIECE(CHART1,Y,21))="" QUIT  ;START FERTIGUNGSTERMIN ;take-off
            if (mOp.Equal(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),21)),"")) {
              break;
            }
            //<< . . . IF $PIECE(SATZ,Y,$PIECE(CHART1,Y,22))="" QUIT  ;DAUER ;permanence within
            if (mOp.Equal(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),22)),"")) {
              break;
            }
            //<< . . . SET SORT=$PIECE(SATZ,Y,SORTFELD)
            SORT.set(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),SORTFELD.get()));
            //<< . . . IF SORT="" SET SORT=" "
            if (mOp.Equal(SORT.get(),"")) {
              SORT.set(" ");
            }
            //<< . . . IF $PIECE(CHART1,Y,38)=1 IF SORTAUSW=1 DO  ;AUFBAU GRUPPEN MIT DATEN ;by means of
            if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),38),1)) {
              if (mOp.Equal(SORTAUSW.get(),1)) {
                //<< . . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","AUSWAHL",SORT,1)=""
                m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","AUSWAHL",SORT.get(),1).set("");
              }
            }
            //<< . . . ;
            //<< . . . IF $PIECE(CHARTD1,Y,19)'="" DO  ;EXECUTE VOR ANZEIGE FELDINHALT ;EXECUTE pre- Show
            if (mOp.NotEqual(m$.Fnc.$piece(CHARTD1.get(),m$.var("Y").get(),19),"")) {
              //<< . . . . NEW YEXEC,YINHALT
              mVar YEXEC = m$.var("YEXEC");
              mVar YINHALT = m$.var("YINHALT");
              m$.newVarBlock(4,YEXEC,YINHALT);
              //<< . . . . SET YINHALT=SORT
              YINHALT.set(SORT.get());
              //<< . . . . SET YEXEC=$PIECE(CHARTD1,Y,19)
              YEXEC.set(m$.Fnc.$piece(CHARTD1.get(),m$.var("Y").get(),19));
              //<< . . . . DO
              do {
                //<< . . . . . NEW (YEXEC,YINHALT,SPRACHE,LANGUAGE,Y,YUCI,YM,YBED,YUSER,YFORM,YDATEI,YLOCATION)
                mVar SPRACHE = m$.var("SPRACHE");
                mVar LANGUAGE = m$.var("LANGUAGE");
                mVar Y = m$.var("Y");
                mVar YUCI = m$.var("YUCI");
                mVar YM = m$.var("YM");
                mVar YBED = m$.var("YBED");
                mVar YUSER = m$.var("YUSER");
                mVar YFORM = m$.var("YFORM");
                mVar YDATEI = m$.var("YDATEI");
                mVar YLOCATION = m$.var("YLOCATION");
                m$.newVarExceptBlock(5,YEXEC,YINHALT,SPRACHE,LANGUAGE,Y,YUCI,YM,YBED,YUSER,YFORM,YDATEI,YLOCATION);
                //<< . . . . . XECUTE YEXEC
                m$.Cmd.Xecute(YEXEC.get());
              } while(false);
              m$.restoreVarBlock(5);
              //<< . . . . ;
              //<< . . . . SET SORT=YINHALT
              SORT.set(YINHALT.get());
            }
            m$.restoreVarBlock(4);
            //<< . . . ;
            //<< . . . SET DATLFN(1)=+$GET(DATLFN(1))+1  ;DATENSÄTZE GESAMT ;total
            DATLFN.var(1).set(mOp.Add(mOp.Positive(m$.Fnc.$get(DATLFN.var(1))),1));
            //<< . . . IF $GET(YAUSWAHL)'="" QUIT:'$FIND(";"_YAUSWAHL_";",";"_SORT_";")  ;NICHT ALLE ANZEIGEN
            if (mOp.NotEqual(m$.Fnc.$get(YAUSWAHL),"")) {
              if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",YAUSWAHL.get()),";"),mOp.Concat(mOp.Concat(";",SORT.get()),";")))) {
                break;
              }
            }
            //<< . . . SET YFILTER=0  ;KEIN FILTER ;no strainer
            YFILTER.set(0);
            //<< . . . IF $DATA(^WWWDRAGDROPF(0,CHART,YBED)) DO  QUIT:YFILTER=1
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDRAGDROPF",0,CHART.get(),m$.var("YBED").get())))) {
              //<< . . . . NEW YNUM,YSUCH,YFILTER1,YWERT
              mVar YSUCH = m$.var("YSUCH");
              mVar YFILTER1 = m$.var("YFILTER1");
              mVar YWERT = m$.var("YWERT");
              m$.newVarBlock(4,YNUM,YSUCH,YFILTER1,YWERT);
              //<< . . . . SET YNUM=""
              YNUM.set("");
              //<< . . . . FOR  SET YNUM=$ORDER(^WWWDRAGDROPF(0,CHART,YBED,YNUM)) QUIT:YNUM=""  DO  QUIT:YFILTER=1
              for (;true;) {
                YNUM.set(m$.Fnc.$order(m$.var("^WWWDRAGDROPF",0,CHART.get(),m$.var("YBED").get(),YNUM.get())));
                if (mOp.Equal(YNUM.get(),"")) {
                  break;
                }
                do {
                  //<< . . . . . SET YSUCH=$PIECE($GET(^WWWDRAGDROPF(0,CHART,YBED,YNUM,1)),Y,1)
                  YSUCH.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDRAGDROPF",0,CHART.get(),m$.var("YBED").get(),YNUM.get(),1)),m$.var("Y").get(),1));
                  //<< . . . . . IF YSUCH="" QUIT  ;KEINE DATEN ;no
                  if (mOp.Equal(YSUCH.get(),"")) {
                    break;
                  }
                  //<< . . . . . SET YWERT=$PIECE(SATZ,Y,YNUM)
                  YWERT.set(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),YNUM.get()));
                  //<< . . . . . IF YWERT="" SET YWERT=" "
                  if (mOp.Equal(YWERT.get(),"")) {
                    YWERT.set(" ");
                  }
                  //<< . . . . . IF $FIND(";"_YSUCH_";",";"_YWERT_";") QUIT
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",YSUCH.get()),";"),mOp.Concat(mOp.Concat(";",YWERT.get()),";")))) {
                    break;
                  }
                  //<< . . . . . SET YFILTER=1  ;KEINE ANZEIGE ;no Show
                  YFILTER.set(1);
                  //<< . . . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENx",KEY,1)=SATZ  ;GEFILTERTE DATEN
                  m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENx",KEY.get(),1).set(SATZ.get());
                } while (false);
                if (mOp.Equal(YFILTER.get(),1)) {
                  break;
                }
              }
              if (mOp.Equal(YFILTER.get(),1)) {
                break;
              }
            }
            m$.restoreVarBlock(4);
            //<< . . . ;
            //<< . . . SET SORT2=""  ;VORSORTIERUNG
            SORT2.set("");
            //<< . . . IF $PIECE(CHARTD1,Y,21)=1 IF $PIECE(CHART1,Y,46)'="" SET SORT2=$PIECE(SATZ,Y,$PIECE(CHART1,Y,46))
            if (mOp.Equal(m$.Fnc.$piece(CHARTD1.get(),m$.var("Y").get(),21),1)) {
              if (mOp.NotEqual(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),46),"")) {
                SORT2.set(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),46)));
              }
            }
            //<< . . . IF SORT2="" SET SORT2=" "
            if (mOp.Equal(SORT2.get(),"")) {
              SORT2.set(" ");
            }
            //<< . . . IF (KEY=KEY2)!(KEY2=0)  SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT2,SORT,KEY,1)=SATZ  ;HAUPTSATZ
            if (mOp.Logical(mOp.Or((mOp.Equal(KEY.get(),KEY2.get())),(mOp.Equal(KEY2.get(),0))))) {
              m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs",SORT2.get(),SORT.get(),KEY.get(),1).set(SATZ.get());
            }
            //<< . . . IF KEY'=KEY2 IF KEY2'=0 SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENn",KEY,KEY2,1)=SATZ  ;SPLITTING
            if (mOp.NotEqual(KEY.get(),KEY2.get())) {
              if (mOp.NotEqual(KEY2.get(),0)) {
                m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENn",KEY.get(),KEY2.get(),1).set(SATZ.get());
              }
            }
            //<< . . . SET DATLFN(2)=+$GET(DATLFN(2))+1  ;ANGEZEIGTE DATENSÄTZE
            DATLFN.var(2).set(mOp.Add(mOp.Positive(m$.Fnc.$get(DATLFN.var(2))),1));
            //<< . . . ;
            //<< . . . IF +$PIECE(CHART1,Y,58)'=0 QUIT:ROWS'<$PIECE(CHART1,Y,58)
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),58)),0)) {
              if (mOp.NotLess(ROWS.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),58))) {
                break;
              }
            }
            //<< . . . SET ROWS=ROWS+1  ;ZEILEN ZÄHLEN
            ROWS.set(mOp.Add(ROWS.get(),1));
          } while(false);
          //<< . . IF KEY2="" FOR  SET KEY2=$ORDER(^WWWSOR(YUSER,"DATEN",KEY,KEY2))  QUIT:KEY2=""  SET SATZ="" DO
          if (mOp.Equal(KEY2.get(),"")) {
            for (;true;) {
              KEY2.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"DATEN",KEY.get(),KEY2.get())));
              if (mOp.Equal(KEY2.get(),"")) {
                break;
              }
              SATZ.set("");
              do {
                //<< . . . IF SATZ="" SET SATZ=^WWWSOR(YUSER,"DATEN",KEY,KEY2,1)
                if (mOp.Equal(SATZ.get(),"")) {
                  SATZ.set(m$.var("^WWWSOR",m$.var("YUSER").get(),"DATEN",KEY.get(),KEY2.get(),1).get());
                }
                //<< . . . IF $PIECE(SATZ,Y,$PIECE(CHART1,Y,21))="" QUIT  ;START FERTIGUNGSTERMIN ;take-off
                if (mOp.Equal(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),21)),"")) {
                  break;
                }
                //<< . . . IF $PIECE(SATZ,Y,$PIECE(CHART1,Y,22))="" QUIT  ;DAUER ;permanence within
                if (mOp.Equal(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),22)),"")) {
                  break;
                }
                //<< . . . SET SORT=$PIECE(SATZ,Y,SORTFELD)
                SORT.set(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),SORTFELD.get()));
                //<< . . . IF SORT="" SET SORT=" "
                if (mOp.Equal(SORT.get(),"")) {
                  SORT.set(" ");
                }
                //<< . . . IF $PIECE(CHART1,Y,38)=1 IF SORTAUSW=1 DO  ;AUFBAU GRUPPEN MIT DATEN ;by means of
                if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),38),1)) {
                  if (mOp.Equal(SORTAUSW.get(),1)) {
                    //<< . . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","AUSWAHL",SORT,1)=""
                    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","AUSWAHL",SORT.get(),1).set("");
                  }
                }
                //<< . . . ;
                //<< . . . IF $PIECE(CHARTD1,Y,19)'="" DO  ;EXECUTE VOR ANZEIGE FELDINHALT ;EXECUTE pre- Show
                if (mOp.NotEqual(m$.Fnc.$piece(CHARTD1.get(),m$.var("Y").get(),19),"")) {
                  //<< . . . . NEW YEXEC,YINHALT
                  mVar YEXEC = m$.var("YEXEC");
                  mVar YINHALT = m$.var("YINHALT");
                  m$.newVarBlock(4,YEXEC,YINHALT);
                  //<< . . . . SET YINHALT=SORT
                  YINHALT.set(SORT.get());
                  //<< . . . . SET YEXEC=$PIECE(CHARTD1,Y,19)
                  YEXEC.set(m$.Fnc.$piece(CHARTD1.get(),m$.var("Y").get(),19));
                  //<< . . . . DO
                  do {
                    //<< . . . . . NEW (YEXEC,YINHALT,SPRACHE,LANGUAGE,Y,YUCI,YM,YBED,YUSER,YFORM,YDATEI,YLOCATION)
                    mVar SPRACHE = m$.var("SPRACHE");
                    mVar LANGUAGE = m$.var("LANGUAGE");
                    mVar Y = m$.var("Y");
                    mVar YUCI = m$.var("YUCI");
                    mVar YM = m$.var("YM");
                    mVar YBED = m$.var("YBED");
                    mVar YUSER = m$.var("YUSER");
                    mVar YFORM = m$.var("YFORM");
                    mVar YDATEI = m$.var("YDATEI");
                    mVar YLOCATION = m$.var("YLOCATION");
                    m$.newVarExceptBlock(5,YEXEC,YINHALT,SPRACHE,LANGUAGE,Y,YUCI,YM,YBED,YUSER,YFORM,YDATEI,YLOCATION);
                    //<< . . . . . XECUTE YEXEC
                    m$.Cmd.Xecute(YEXEC.get());
                  } while(false);
                  m$.restoreVarBlock(5);
                  //<< . . . . ;
                  //<< . . . . SET SORT=YINHALT
                  SORT.set(YINHALT.get());
                }
                m$.restoreVarBlock(4);
                //<< . . . ;
                //<< . . . SET DATLFN(1)=+$GET(DATLFN(1))+1  ;DATENSÄTZE GESAMT ;total
                DATLFN.var(1).set(mOp.Add(mOp.Positive(m$.Fnc.$get(DATLFN.var(1))),1));
                //<< . . . IF $GET(YAUSWAHL)'="" QUIT:'$FIND(";"_YAUSWAHL_";",";"_SORT_";")  ;NICHT ALLE ANZEIGEN
                if (mOp.NotEqual(m$.Fnc.$get(YAUSWAHL),"")) {
                  if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",YAUSWAHL.get()),";"),mOp.Concat(mOp.Concat(";",SORT.get()),";")))) {
                    break;
                  }
                }
                //<< . . . SET YFILTER=0  ;KEIN FILTER ;no strainer
                YFILTER.set(0);
                //<< . . . IF $DATA(^WWWDRAGDROPF(0,CHART,YBED)) DO  QUIT:YFILTER=1
                if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDRAGDROPF",0,CHART.get(),m$.var("YBED").get())))) {
                  //<< . . . . NEW YNUM,YSUCH,YFILTER1,YWERT
                  mVar YSUCH = m$.var("YSUCH");
                  mVar YFILTER1 = m$.var("YFILTER1");
                  mVar YWERT = m$.var("YWERT");
                  m$.newVarBlock(4,YNUM,YSUCH,YFILTER1,YWERT);
                  //<< . . . . SET YNUM=""
                  YNUM.set("");
                  //<< . . . . FOR  SET YNUM=$ORDER(^WWWDRAGDROPF(0,CHART,YBED,YNUM)) QUIT:YNUM=""  DO  QUIT:YFILTER=1
                  for (;true;) {
                    YNUM.set(m$.Fnc.$order(m$.var("^WWWDRAGDROPF",0,CHART.get(),m$.var("YBED").get(),YNUM.get())));
                    if (mOp.Equal(YNUM.get(),"")) {
                      break;
                    }
                    do {
                      //<< . . . . . SET YSUCH=$PIECE($GET(^WWWDRAGDROPF(0,CHART,YBED,YNUM,1)),Y,1)
                      YSUCH.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDRAGDROPF",0,CHART.get(),m$.var("YBED").get(),YNUM.get(),1)),m$.var("Y").get(),1));
                      //<< . . . . . IF YSUCH="" QUIT  ;KEINE DATEN ;no
                      if (mOp.Equal(YSUCH.get(),"")) {
                        break;
                      }
                      //<< . . . . . SET YWERT=$PIECE(SATZ,Y,YNUM)
                      YWERT.set(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),YNUM.get()));
                      //<< . . . . . IF YWERT="" SET YWERT=" "
                      if (mOp.Equal(YWERT.get(),"")) {
                        YWERT.set(" ");
                      }
                      //<< . . . . . IF $FIND(";"_YSUCH_";",";"_YWERT_";") QUIT
                      if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",YSUCH.get()),";"),mOp.Concat(mOp.Concat(";",YWERT.get()),";")))) {
                        break;
                      }
                      //<< . . . . . SET YFILTER=1  ;KEINE ANZEIGE ;no Show
                      YFILTER.set(1);
                      //<< . . . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENx",KEY,1)=SATZ  ;GEFILTERTE DATEN
                      m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENx",KEY.get(),1).set(SATZ.get());
                    } while (false);
                    if (mOp.Equal(YFILTER.get(),1)) {
                      break;
                    }
                  }
                  if (mOp.Equal(YFILTER.get(),1)) {
                    break;
                  }
                }
                m$.restoreVarBlock(4);
                //<< . . . ;
                //<< . . . SET SORT2=""  ;VORSORTIERUNG
                SORT2.set("");
                //<< . . . IF $PIECE(CHARTD1,Y,21)=1 IF $PIECE(CHART1,Y,46)'="" SET SORT2=$PIECE(SATZ,Y,$PIECE(CHART1,Y,46))
                if (mOp.Equal(m$.Fnc.$piece(CHARTD1.get(),m$.var("Y").get(),21),1)) {
                  if (mOp.NotEqual(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),46),"")) {
                    SORT2.set(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),46)));
                  }
                }
                //<< . . . IF SORT2="" SET SORT2=" "
                if (mOp.Equal(SORT2.get(),"")) {
                  SORT2.set(" ");
                }
                //<< . . . IF (KEY=KEY2)!(KEY2=0)  SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT2,SORT,KEY,1)=SATZ  ;HAUPTSATZ
                if (mOp.Logical(mOp.Or((mOp.Equal(KEY.get(),KEY2.get())),(mOp.Equal(KEY2.get(),0))))) {
                  m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs",SORT2.get(),SORT.get(),KEY.get(),1).set(SATZ.get());
                }
                //<< . . . IF KEY'=KEY2 IF KEY2'=0 SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENn",KEY,KEY2,1)=SATZ  ;SPLITTING
                if (mOp.NotEqual(KEY.get(),KEY2.get())) {
                  if (mOp.NotEqual(KEY2.get(),0)) {
                    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENn",KEY.get(),KEY2.get(),1).set(SATZ.get());
                  }
                }
                //<< . . . SET DATLFN(2)=+$GET(DATLFN(2))+1  ;ANGEZEIGTE DATENSÄTZE
                DATLFN.var(2).set(mOp.Add(mOp.Positive(m$.Fnc.$get(DATLFN.var(2))),1));
                //<< . . . ;
                //<< . . . IF +$PIECE(CHART1,Y,58)'=0 QUIT:ROWS'<$PIECE(CHART1,Y,58)
                if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),58)),0)) {
                  if (mOp.NotLess(ROWS.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),58))) {
                    break;
                  }
                }
                //<< . . . SET ROWS=ROWS+1  ;ZEILEN ZÄHLEN
                ROWS.set(mOp.Add(ROWS.get(),1));
              } while (false);
            }
          }
        //<< . ;
        //<< . IF $PIECE(CHART1,Y,38)=1 IF SORTAUSW'=1 DO  ;AUFBAU ALLER GRUPPEN ;everyone
        }
      }
      if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),38),1)) {
        if (mOp.NotEqual(SORTAUSW.get(),1)) {
          do {
            //<< . . NEW YFELD,YDATEI,YDATEI1,RELK,RELF,YI,LFN
            mVar YFELD = m$.var("YFELD");
            mVar YDATEI = m$.var("YDATEI");
            mVar YDATEI1 = m$.var("YDATEI1");
            mVar RELK = m$.var("RELK");
            mVar RELF = m$.var("RELF");
            mVar YI = m$.var("YI");
            m$.newVarBlock(2,YFELD,YDATEI,YDATEI1,RELK,RELF,YI,LFN);
            //<< . . QUIT:$PIECE(CHART1,Y,40)=""
            if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),40),"")) {
              break;
            }
            //<< . . SET YFELD=$GET(^WWWDRAGDROPD(0,CHART,$PIECE(CHART1,Y,40),1))  ;SORTIER-DATENFELD
            YFELD.set(m$.Fnc.$get(m$.var("^WWWDRAGDROPD",0,CHART.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),40),1)));
            //<< . . IF $PIECE(YFELD,Y,9)'="" DO  ;RELATIONSDATEI VORHANDEN ;on hand
            if (mOp.NotEqual(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),9),"")) {
              //<< . . . SET YDATEI=$PIECE(YFELD,Y,9)
              YDATEI.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),9));
              //<< . . . SET RELK=$PIECE(YFELD,Y,10)  ;RELATIONS PRIMÄRSCHLÜSSEL
              RELK.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),10));
              //<< . . . IF RELK'="" FOR YI=1:1  QUIT:$PIECE(RELK,",",YI)=""  IF '$FIND($PIECE(RELK,",",YI),"""") SET $PIECE(RELK,",",YI)=""""_@$PIECE(RELK,",",YI)_""""
              if (mOp.NotEqual(RELK.get(),"")) {
                for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                  if (mOp.Equal(m$.Fnc.$piece(RELK.get(),",",YI.get()),"")) {
                    break;
                  }
                  if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(RELK.get(),",",YI.get()),"\""))) {
                    m$.pieceVar(RELK,",",YI.get()).set(mOp.Concat(mOp.Concat("\"",m$.indirectVar(m$.Fnc.$piece(RELK.get(),",",YI.get())).get()),"\""));
                  }
                }
              }
              //<< . . . SET RELF=+$PIECE(YFELD,Y,11)  ;ANZEIGE FELD ;Show field
              RELF.set(mOp.Positive(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),11)));
              //<< . . . IF RELF=0 SET RELF=1
              if (mOp.Equal(RELF.get(),0)) {
                RELF.set(1);
              }
              //<< . . . SET YDATEI1="^"_YDATEI_"("_""""_$$^WWWYM(YDATEI)_""""
              YDATEI1.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"("),"\""),m$.fnc$("WWWYM.main",YDATEI.get())),"\""));
              //<< . . . IF RELK'="" FOR YI=1:1  QUIT:$PIECE(RELK,",",YI)=""  SET YDATEI1=YDATEI1_","_""""_$TRANSLATE($PIECE(RELK,",",YI),"""")_""""
              if (mOp.NotEqual(RELK.get(),"")) {
                for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                  if (mOp.Equal(m$.Fnc.$piece(RELK.get(),",",YI.get()),"")) {
                    break;
                  }
                  YDATEI1.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YDATEI1.get(),","),"\""),m$.Fnc.$translate(m$.Fnc.$piece(RELK.get(),",",YI.get()),"\"")),"\""));
                }
              }
              //<< . . . SET YDATEI1=YDATEI1_",LFN)"
              YDATEI1.set(mOp.Concat(YDATEI1.get(),",LFN)"));
              //<< . . . SET LFN=""
              LFN.set("");
              //<< . . . FOR  SET LFN=$ORDER(@YDATEI1) QUIT:LFN=""  DO
              for (;true;) {
                LFN.set(m$.Fnc.$order(m$.indirectVar(YDATEI1.get())));
                if (mOp.Equal(LFN.get(),"")) {
                  break;
                }
                //<< . . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","AUSWAHL",LFN,1)=""
                m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","AUSWAHL",LFN.get(),1).set("");
              }
              //<< . . . ;
              //<< . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","AUSWAHL"," ",1)=""  ;OHNE ;without
              m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","AUSWAHL"," ",1).set("");
            }
          } while (false);
        }
        m$.restoreVarBlock(2);
      }
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< IF +ROWS=0 DO  ;IF +ROWS<10 DO  //KEINE DATEN VORHANDEN;FIS;19.07.04;26118
    if (mOp.Equal(mOp.Positive(ROWS.get()),0)) {
      //<< . NEW YI,SORT
      mVar YI = m$.var("YI");
      m$.newVarBlock(1,YI,SORT);
      //<< . SET SORT=$CHAR(255)
      SORT.set(m$.Fnc.$char(255));
      //<< . IF $PIECE(CHART1,Y,40)'="" IF $PIECE($GET(^WWWDRAGDROPD(0,CHART,$PIECE(CHART1,Y,40),1)),Y,22)=1 SET SORT=" "
      if (mOp.NotEqual(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),40),"")) {
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDRAGDROPD",0,CHART.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),40),1)),m$.var("Y").get(),22),1)) {
          SORT.set(" ");
        }
      }
      //<< . FOR YI=ROWS:1:10 SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT,SORT,YI,1)=""
      for (YI.set(ROWS.get());(mOp.LessOrEqual(YI.get(),10));YI.set(mOp.Add(YI.get(),1))) {
        m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs",SORT.get(),SORT.get(),YI.get(),1).set("");
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< DO SCRIPT^WWWTOOLTIP
    m$.Cmd.Do("WWWTOOLTIP.SCRIPT");
    //<< IF $PIECE(CHART1,Y,60)=1 IF $GET(YPRINTMODE)'=1 DO ^WWWDRAGDROP21  ;BLÄTTERFUNKTION
    if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),60),1)) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YPRINTMODE")),1)) {
        m$.Cmd.Do("WWWDRAGDROP21.main");
      }
    }
    //<< 
    //<< ;AUFBAU TABELLEN-STRUKTUR
    //<< ;---------------------------------------------------------------------------
    //<< WRITE YCR,"<table border=0 cellspacing=0 cellpadding=0"
    m$.Cmd.Write(m$.var("YCR").get(),"<table border=0 cellspacing=0 cellpadding=0");
    //<< DO FARBE^WWWTAB
    m$.Cmd.Do("WWWTAB.FARBE");
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< DO TIMESCALE  ;HEADER
    m$.Cmd.Do("TIMESCALE");
    //<< DO GRID       ;TABLE
    m$.Cmd.Do("GRID");
    //<< IF $PIECE(CHART1,Y,24)=1 IF HISTSIZE>0 DO HISTOGRAMM  ;HISTOGRAMM
    if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),24),1)) {
      if (mOp.Greater(HISTSIZE.get(),0)) {
        m$.Cmd.Do("HISTOGRAMM");
      }
    }
    //<< WRITE YCR,"</table>"
    m$.Cmd.Write(m$.var("YCR").get(),"</table>");
    //<< 
    //<< ;EINFÜGEN DATEN/ELEMENTE ;interpolate
    //<< ;---------------------------------------------------------------------------
    //<< WRITE "<input type="_""""_"hidden"_""""_" name="_""""_"OPENELEM"_""""_" value="_""""_""""_">"  ;OFFENES ELEMENT MERKEN ;medium
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<input type=","\""),"hidden"),"\"")," name="),"\""),"OPENELEM"),"\"")," value="),"\""),"\""),">"));
    //<< WRITE "<input type="_""""_"hidden"_""""_" name="_""""_"YAUSWAHL"_""""_" value="_""""_$GET(YAUSWAHL)_""""_">"  ;EINGESCHRÄNKTER DATENSATZ ;data record
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<input type=","\""),"hidden"),"\"")," name="),"\""),"YAUSWAHL"),"\"")," value="),"\""),m$.Fnc.$get(YAUSWAHL)),"\""),">"));
    //<< IF $GET(ARBSTUNDEN)<1 SET ARBSTUNDEN=8
    if (mOp.Less(m$.Fnc.$get(ARBSTUNDEN),1)) {
      ARBSTUNDEN.set(8);
    }
    //<< SET LINE=HEADSIZE
    LINE.set(HEADSIZE.get());
    //<< SET KEY2=""
    KEY2.set("");
    //<< SET RICHT=1
    RICHT.set(1);
    //<< SET ZNR=0
    ZNR.set(0);
    //<< IF $PIECE(CHART1,Y,40)'="" IF $PIECE($GET(^WWWDRAGDROPD(0,CHART,$PIECE(CHART1,Y,40),1)),Y,22)=1 SET RICHT=-1
    if (mOp.NotEqual(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),40),"")) {
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDRAGDROPD",0,CHART.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),40),1)),m$.var("Y").get(),22),1)) {
        RICHT.set(mOp.Negative(1));
      }
    }
    //<< SET SORT2=""
    SORT2.set("");
    //<< FOR  SET SORT2=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT2),RICHT) QUIT:SORT2=""  DO
    for (;true;) {
      SORT2.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs",SORT2.get()),RICHT.get()));
      if (mOp.Equal(SORT2.get(),"")) {
        break;
      }
      //<< . SET SORT=""
      SORT.set("");
      //<< . FOR  SET SORT=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT2,SORT),RICHT) QUIT:SORT=""  DO
      for (;true;) {
        SORT.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs",SORT2.get(),SORT.get()),RICHT.get()));
        if (mOp.Equal(SORT.get(),"")) {
          break;
        }
        //<< . . SET KEY=""
        KEY.set("");
        //<< . . FOR  SET KEY=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT2,SORT,KEY)) QUIT:KEY=""  DO
        for (;true;) {
          KEY.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs",SORT2.get(),SORT.get(),KEY.get())));
          if (mOp.Equal(KEY.get(),"")) {
            break;
          }
          do {
            //<< . . . SET SATZ=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT2,SORT,KEY,1))
            mVar SATZ = m$.var("SATZ");
            SATZ.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs",SORT2.get(),SORT.get(),KEY.get(),1)));
            //<< . . . SET ZNR=ZNR+1
            ZNR.set(mOp.Add(ZNR.get(),1));
            //<< . . . IF ZNSTART>ZNR QUIT
            if (mOp.Greater(ZNSTART.get(),ZNR.get())) {
              break;
            }
            //<< . . . IF ZNSTOP<ZNR  QUIT
            if (mOp.Less(ZNSTOP.get(),ZNR.get())) {
              break;
            }
            //<< . . . ;
            //<< . . . DO ^WWWDRAGDROP10  ;HAUPTSATZ
            m$.Cmd.Do("WWWDRAGDROP10.main");
            //<< . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATEN",KEY,1)=SATZ  ;NACHHER ;afterward
            m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATEN",KEY.get(),1).set(SATZ.get());
            //<< . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATEN",KEY,2)=SATZ  ;VORHER ;pre-
            m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATEN",KEY.get(),2).set(SATZ.get());
            //<< . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","X-REF",KEY,1)=(LINE-HEADSIZE)_"X"_((TERMIN*TIMESIZE)+STUNDE)_"X"_(DAUER-1)  ;ZEILE X SPLATE X LAENGE ;X X
            m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","X-REF",KEY.get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat((mOp.Subtract(LINE.get(),HEADSIZE.get())),"X"),(mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get()))),"X"),(mOp.Subtract(DAUER.get(),1))));
            //<< . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","X-REF",KEY,2)=(LINE-HEADSIZE)_"X"_((TERMIN*TIMESIZE)+STUNDE)_"X"_(DAUER-1)  ;ZEILE X SPLATE X LAENGE ;X X
            m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","X-REF",KEY.get(),2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat((mOp.Subtract(LINE.get(),HEADSIZE.get())),"X"),(mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get()))),"X"),(mOp.Subtract(DAUER.get(),1))));
            //<< . . . IF LINEAL=1 SET ^WWWSOR(YUSER,"LINEAL","WERTE",(LINE-HEADSIZE),1)=((TERMIN*TIMESIZE)+STUNDE)_"X"_(((TERMIN*TIMESIZE)+STUNDE)+(DAUER-1))_Y_KEY
            if (mOp.Equal(LINEAL.get(),1)) {
              m$.var("^WWWSOR",m$.var("YUSER").get(),"LINEAL","WERTE",(mOp.Subtract(LINE.get(),HEADSIZE.get())),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())),"X"),(mOp.Add((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())),(mOp.Subtract(DAUER.get(),1))))),m$.var("Y").get()),KEY.get()));
            }
            //<< . . . DO
            do {
              //<< . . . . IF +$PIECE(CHART1,Y,54)'=0 IF $PIECE(SATZ,Y,$PIECE(CHART1,Y,54))=1 QUIT
              if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),54)),0)) {
                if (mOp.Equal(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),54)),1)) {
                  break;
                }
              }
              //<< . . . . IF +$PIECE(CHART1,Y,64)'=0 DO  QUIT  ;DATENFELD FÜR SUMMENBILDUNG ;data item to
              if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),64)),0)) {
                //<< . . . . . FOR LREF=((TERMIN*TIMESIZE)+STUNDE):1:(((TERMIN*TIMESIZE)+STUNDE)+DAUER-1) SET ^WWWSOR(YUSER,"Y-REF",LREF)=$GET(^WWWSOR(YUSER,"Y-REF",LREF))+$PIECE(SATZ,Y,$PIECE(CHART1,Y,64))  ;HISTOGRAMM SUMMEN ;purr
                mVar LREF = m$.var("LREF");
                for (LREF.set((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())));(mOp.LessOrEqual(LREF.get(),(mOp.Subtract(mOp.Add((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())),DAUER.get()),1))));LREF.set(mOp.Add(LREF.get(),1))) {
                  m$.var("^WWWSOR",m$.var("YUSER").get(),"Y-REF",LREF.get()).set(mOp.Add(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"Y-REF",LREF.get())),m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),64))));
                }
                break;
              }
              //<< . . . . ;
              //<< . . . . FOR LREF=((TERMIN*TIMESIZE)+STUNDE):1:(((TERMIN*TIMESIZE)+STUNDE)+DAUER-1) SET ^WWWSOR(YUSER,"Y-REF",LREF)=$GET(^WWWSOR(YUSER,"Y-REF",LREF))+1  ;HISTOGRAMM SUMMEN ;purr
              mVar LREF = m$.var("LREF");
              for (LREF.set((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())));(mOp.LessOrEqual(LREF.get(),(mOp.Subtract(mOp.Add((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())),DAUER.get()),1))));LREF.set(mOp.Add(LREF.get(),1))) {
                m$.var("^WWWSOR",m$.var("YUSER").get(),"Y-REF",LREF.get()).set(mOp.Add(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"Y-REF",LREF.get())),1));
              }
            } while(false);
            //<< . . . ;
            //<< . . . ;SPLITTING
            //<< . . . IF $DATA(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENn",KEY)) DO
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENn",KEY.get())))) {
              //<< . . . . NEW SATZ,KEY2
              m$.newVarBlock(4,SATZ,KEY2);
              //<< . . . . SET KEY2=""
              KEY2.set("");
              //<< . . . . FOR  SET KEY2=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENn",KEY,KEY2))  QUIT:KEY2=""  DO
              for (;true;) {
                KEY2.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENn",KEY.get(),KEY2.get())));
                if (mOp.Equal(KEY2.get(),"")) {
                  break;
                }
                do {
                  //<< . . . . . SET SATZ=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENn",KEY,KEY2,1))
                  SATZ.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENn",KEY.get(),KEY2.get(),1)));
                  //<< . . . . . QUIT:SATZ=""
                  if (mOp.Equal(SATZ.get(),"")) {
                    break;
                  }
                  //<< . . . . . DO ^WWWDRAGDROP10  ;SPLITTING
                  m$.Cmd.Do("WWWDRAGDROP10.main");
                  //<< . . . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATEN",KEY_"%s%"_KEY2,1)=SATZ  ;NACHHER ;afterward
                  m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATEN",mOp.Concat(mOp.Concat(KEY.get(),"%s%"),KEY2.get()),1).set(SATZ.get());
                  //<< . . . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATEN",KEY_"%s%"_KEY2,2)=SATZ  ;VORHER ;pre-
                  m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATEN",mOp.Concat(mOp.Concat(KEY.get(),"%s%"),KEY2.get()),2).set(SATZ.get());
                  //<< . . . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","X-REF",KEY_"%s%"_KEY2,1)=(LINE-HEADSIZE)_"X"_((TERMIN*TIMESIZE)+STUNDE)_"X"_(DAUER-1)  ;ZEILE X SPLATE X LAENGE ;X X
                  m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","X-REF",mOp.Concat(mOp.Concat(KEY.get(),"%s%"),KEY2.get()),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat((mOp.Subtract(LINE.get(),HEADSIZE.get())),"X"),(mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get()))),"X"),(mOp.Subtract(DAUER.get(),1))));
                  //<< . . . . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","X-REF",KEY_"%s%"_KEY2,2)=(LINE-HEADSIZE)_"X"_((TERMIN*TIMESIZE)+STUNDE)_"X"_(DAUER-1)  ;ZEILE X SPLATE X LAENGE ;X X
                  m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","X-REF",mOp.Concat(mOp.Concat(KEY.get(),"%s%"),KEY2.get()),2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat((mOp.Subtract(LINE.get(),HEADSIZE.get())),"X"),(mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get()))),"X"),(mOp.Subtract(DAUER.get(),1))));
                  //<< . . . . . IF LINEAL=1 SET ^WWWSOR(YUSER,"LINEAL","WERTE",(LINE-HEADSIZE+(KEY2/1000)),1)=((TERMIN*TIMESIZE)+STUNDE)_"X"_(((TERMIN*TIMESIZE)+STUNDE)+(DAUER-1))_Y_KEY_"%s%"_KEY2
                  if (mOp.Equal(LINEAL.get(),1)) {
                    m$.var("^WWWSOR",m$.var("YUSER").get(),"LINEAL","WERTE",(mOp.Add(mOp.Subtract(LINE.get(),HEADSIZE.get()),(mOp.Divide(KEY2.get(),1000)))),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())),"X"),(mOp.Add((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())),(mOp.Subtract(DAUER.get(),1))))),m$.var("Y").get()),KEY.get()),"%s%"),KEY2.get()));
                  }
                  //<< . . . . . DO
                  do {
                    //<< . . . . . . IF +$PIECE(CHART1,Y,54)'=0 IF $PIECE(SATZ,Y,$PIECE(CHART1,Y,54))=1 QUIT
                    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),54)),0)) {
                      if (mOp.Equal(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),54)),1)) {
                        break;
                      }
                    }
                    //<< . . . . . . IF +$PIECE(CHART1,Y,64)'=0 DO  QUIT  ;DATENFELD FÜR SUMMENBILDUNG ;data item to
                    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),64)),0)) {
                      //<< . . . . . . . FOR LREF=((TERMIN*TIMESIZE)+STUNDE):1:(((TERMIN*TIMESIZE)+STUNDE)+DAUER-1) SET ^WWWSOR(YUSER,"Y-REF",LREF)=$GET(^WWWSOR(YUSER,"Y-REF",LREF))+$PIECE(SATZ,Y,$PIECE(CHART1,Y,64))  ;HISTOGRAMM SUMMEN ;purr
                      mVar LREF = m$.var("LREF");
                      for (LREF.set((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())));(mOp.LessOrEqual(LREF.get(),(mOp.Subtract(mOp.Add((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())),DAUER.get()),1))));LREF.set(mOp.Add(LREF.get(),1))) {
                        m$.var("^WWWSOR",m$.var("YUSER").get(),"Y-REF",LREF.get()).set(mOp.Add(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"Y-REF",LREF.get())),m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),64))));
                      }
                      break;
                    }
                    //<< . . . . . . ;
                    //<< . . . . . . FOR LREF=((TERMIN*TIMESIZE)+STUNDE):1:(((TERMIN*TIMESIZE)+STUNDE)+DAUER-1) SET ^WWWSOR(YUSER,"Y-REF",LREF)=$GET(^WWWSOR(YUSER,"Y-REF",LREF))+1  ;HISTOGRAMM SUMMEN
                    mVar LREF = m$.var("LREF");
                    for (LREF.set((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())));(mOp.LessOrEqual(LREF.get(),(mOp.Subtract(mOp.Add((mOp.Add((mOp.Multiply(TERMIN.get(),m$.var("TIMESIZE").get())),STUNDE.get())),DAUER.get()),1))));LREF.set(mOp.Add(LREF.get(),1))) {
                      m$.var("^WWWSOR",m$.var("YUSER").get(),"Y-REF",LREF.get()).set(mOp.Add(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"Y-REF",LREF.get())),1));
                    }
                  } while(false);
                } while (false);
              }
            }
            m$.restoreVarBlock(4);
            //<< . . . ;
            //<< . . . SET LINE=LINE+1
            LINE.set(mOp.Add(LINE.get(),1));
          } while (false);
        }
      }
    }
    //<< 
    //<< ;KEINE DATEN ZUR ANZEIGE ;no Show
    //<< IF '$DATA(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs"))!(ROWS=0) IF HEADLAENG>0 DO
    if (mOp.Or(mOp.Not(m$.Fnc.$data(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs"))),(mOp.Equal(ROWS.get(),0)))) {
      if (mOp.Greater(HEADLAENG.get(),0)) {
        //<< . WRITE YCR,"<DIV id="_""""_"desc"_"edit"_0_""""  ;edit muss bleiben ! ;stay over
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<DIV id=","\""),"desc"),"edit"),0),"\""));
        //<< . WRITE " style="_""""
        m$.Cmd.Write(mOp.Concat(" style=","\""));
        //<< . WRITE " position:absolute;"
        m$.Cmd.Write(" position:absolute;");
        //<< . ;WRITE " top:"_(((LINE-1)*PIXEL)+BUTTONLINE)_";"
        //<< . WRITE " top:"_(((LINE-11)*PIXEL)+BUTTONLINE)_";"  ;FIS;19.07.04;26118
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" top:",(mOp.Add((mOp.Multiply((mOp.Subtract(LINE.get(),11)),PIXEL.get())),BUTTONLINE.get()))),";"));
        //<< . WRITE " left:"_1_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" left:",1),";"));
        //<< . WRITE " height:"_PIXEL_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" height:",PIXEL.get()),";"));
        //<< . WRITE " width:"_((HEADLAENG*PIXEL)-1)_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",(mOp.Subtract((mOp.Multiply(HEADLAENG.get(),PIXEL.get())),1))),";"));
        //<< . WRITE " text-align:left;"
        m$.Cmd.Write(" text-align:left;");
        //<< . WRITE " font:9pt arial;"
        m$.Cmd.Write(" font:9pt arial;");
        //<< . WRITE " white-space:nowrap;"
        m$.Cmd.Write(" white-space:nowrap;");
        //<< . WRITE " z-index:10;"
        m$.Cmd.Write(" z-index:10;");
        //<< . WRITE """"
        m$.Cmd.Write("\"");
        //<< . WRITE ">"
        m$.Cmd.Write(">");
        //<< . WRITE YCR,"<TABLE style="_""""_"table-layout:fixed;"_""""_" BORDER=0 CELLSPACING=0 CELLPADDING=0><TR>"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TABLE style=","\""),"table-layout:fixed;"),"\"")," BORDER=0 CELLSPACING=0 CELLPADDING=0><TR>"));
        //<< . WRITE YCR,"<TD nowrap"
        m$.Cmd.Write(m$.var("YCR").get(),"<TD nowrap");
        //<< . WRITE " style="_""""
        m$.Cmd.Write(mOp.Concat(" style=","\""));
        //<< . WRITE " text-align:left;"
        m$.Cmd.Write(" text-align:left;");
        //<< . WRITE " vertical-align:bottom;"
        m$.Cmd.Write(" vertical-align:bottom;");
        //<< . WRITE " font-family:arial;"
        m$.Cmd.Write(" font-family:arial;");
        //<< . WRITE " font-size:"_FONTSIZE_"pt;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" font-size:",FONTSIZE.get()),"pt;"));
        //<< . WRITE " border-right:1px solid "_COLORLIGHT_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-right:1px solid ",COLORLIGHT.get()),";"));
        //<< . WRITE " border-left:1px solid "_COLORDARK_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-left:1px solid ",COLORDARK.get()),";"));
        //<< . WRITE " width:"_((HEADLAENG*PIXEL)-1)_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",(mOp.Subtract((mOp.Multiply(HEADLAENG.get(),PIXEL.get())),1))),";"));
        //<< . WRITE " height:"_(PIXEL-2)_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" height:",(mOp.Subtract(PIXEL.get(),2))),";"));
        //<< . WRITE " z-index:10;"
        m$.Cmd.Write(" z-index:10;");
        //<< . WRITE " overflow:hidden;"
        m$.Cmd.Write(" overflow:hidden;");
        //<< . WRITE " white-space:nowrap;"
        m$.Cmd.Write(" white-space:nowrap;");
        //<< . WRITE """"_">"
        m$.Cmd.Write(mOp.Concat("\"",">"));
        //<< . WRITE "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . WRITE "<font color="_YRED_"><B>"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<font color=",m$.var("YRED").get()),"><B>"));
        //<< . WRITE $$^WWWTEXT(46)  ;KEINE DATEN ;no
        m$.Cmd.Write(m$.fnc$("WWWTEXT.main",46));
        //<< . WRITE "</B></FONT>"
        m$.Cmd.Write("</B></FONT>");
        //<< . WRITE YCR,"</TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
        //<< . WRITE YCR,"</TR>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
        //<< . WRITE YCR,"</TABLE>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
        //<< . WRITE YCR,"</DIV>"
        m$.Cmd.Write(m$.var("YCR").get(),"</DIV>");
      }
    }
    //<< 
    //<< ;LINEAL/SUMMENBALKEN EINFÜGEN ;interpolate
    //<< ;----------------------------
    //<< IF LINEAL=1 DO
    if (mOp.Equal(LINEAL.get(),1)) {
      //<< . NEW LINROW,ELEM,LEFT,RIGHT,LENGTH,ZEILE,LASTRIGHT,COLOR,LENGL,LENGR,KEYS
      mVar LINROW = m$.var("LINROW");
      mVar ELEM = m$.var("ELEM");
      mVar LEFT = m$.var("LEFT");
      mVar RIGHT = m$.var("RIGHT");
      mVar ZEILE = m$.var("ZEILE");
      mVar LASTRIGHT = m$.var("LASTRIGHT");
      mVar LENGL = m$.var("LENGL");
      mVar LENGR = m$.var("LENGR");
      mVar KEYS = m$.var("KEYS");
      m$.newVarBlock(1,LINROW,ELEM,LEFT,RIGHT,LENGTH,ZEILE,LASTRIGHT,COLOR,LENGL,LENGR,KEYS);
      //<< . SET LASTRIGHT=0
      LASTRIGHT.set(0);
      //<< . SET LINROW=""
      LINROW.set("");
      //<< . FOR  SET LINROW=$ORDER(^WWWSOR(YUSER,"LINEAL","ZEILE",LINROW)) QUIT:LINROW=""  DO
      for (;true;) {
        LINROW.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"LINEAL","ZEILE",LINROW.get())));
        if (mOp.Equal(LINROW.get(),"")) {
          break;
        }
        do {
          //<< . . SET ZEILE(1)=LINROW  ;VON ZEILE
          ZEILE.var(1).set(LINROW.get());
          //<< . . SET ZEILE(2)=$ORDER(^WWWSOR(YUSER,"LINEAL","ZEILE",ZEILE(1)))-1  ;BIS ZEILE ;until
          ZEILE.var(2).set(mOp.Subtract(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"LINEAL","ZEILE",ZEILE.var(1).get())),1));
          //<< . . IF ZEILE(2)<0 SET ZEILE(2)=LINE  ;MAX. ZEILE
          if (mOp.Less(ZEILE.var(2).get(),0)) {
            ZEILE.var(2).set(LINE.get());
          }
          //<< . . SET LEFT=""
          LEFT.set("");
          //<< . . SET RIGHT=""
          RIGHT.set("");
          //<< . . SET KEYS=""
          KEYS.set("");
          //<< . . SET ZEILE(0)=$ORDER(^WWWSOR(YUSER,"LINEAL","WERTE",ZEILE(1)),-1)
          ZEILE.var(0).set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"LINEAL","WERTE",ZEILE.var(1).get()),mOp.Negative(1)));
          //<< . . FOR  SET ZEILE(0)=$ORDER(^WWWSOR(YUSER,"LINEAL","WERTE",ZEILE(0))) QUIT:ZEILE(0)=""  QUIT:$PIECE(ZEILE(0),".",1)>ZEILE(2)  DO
          for (;true;) {
            ZEILE.var(0).set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"LINEAL","WERTE",ZEILE.var(0).get())));
            if (mOp.Equal(ZEILE.var(0).get(),"")) {
              break;
            }
            if (mOp.Greater(m$.Fnc.$piece(ZEILE.var(0).get(),".",1),ZEILE.var(2).get())) {
              break;
            }
            //<< . . . SET WERTE=$GET(^WWWSOR(YUSER,"LINEAL","WERTE",ZEILE(0),1))
            mVar WERTE = m$.var("WERTE");
            WERTE.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"LINEAL","WERTE",ZEILE.var(0).get(),1)));
            //<< . . . IF (LEFT="")  || ($PIECE(WERTE,"X",1)<LEFT)  SET LEFT  = +$PIECE(WERTE,"X",1)
            if ((mOp.Equal(LEFT.get(),"")) || (mOp.Less(m$.Fnc.$piece(WERTE.get(),"X",1),LEFT.get()))) {
              LEFT.set(mOp.Positive(m$.Fnc.$piece(WERTE.get(),"X",1)));
            }
            //<< . . . IF (RIGHT="") || ($PIECE(WERTE,"X",2)>RIGHT) SET RIGHT = +$PIECE(WERTE,"X",2)
            if ((mOp.Equal(RIGHT.get(),"")) || (mOp.Greater(m$.Fnc.$piece(WERTE.get(),"X",2),RIGHT.get()))) {
              RIGHT.set(mOp.Positive(m$.Fnc.$piece(WERTE.get(),"X",2)));
            }
            //<< . . . SET KEYS=KEYS_$PIECE(WERTE,Y,2)_";"
            KEYS.set(mOp.Concat(mOp.Concat(KEYS.get(),m$.Fnc.$piece(WERTE.get(),m$.var("Y").get(),2)),";"));
          }
          //<< . . ;
          //<< . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","LINEAL",ZEILE(1),1) = ZEILE(2)_"X"_LEFT_"X"_RIGHT_Y_KEYS
          m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","LINEAL",ZEILE.var(1).get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(ZEILE.var(2).get(),"X"),LEFT.get()),"X"),RIGHT.get()),m$.var("Y").get()),KEYS.get()));
          //<< . . ;
          //<< . . IF RIGHT>(COLUMNS-HEADLAENG-1) SET RIGHT=(COLUMNS-HEADLAENG-1)
          if (mOp.Greater(RIGHT.get(),(mOp.Subtract(mOp.Subtract(COLUMNS.get(),HEADLAENG.get()),1)))) {
            RIGHT.set((mOp.Subtract(mOp.Subtract(COLUMNS.get(),HEADLAENG.get()),1)));
          }
          //<< . . IF RIGHT<LEFT QUIT
          if (mOp.Less(RIGHT.get(),LEFT.get())) {
            break;
          }
          //<< . . SET LENGTH=((RIGHT+1)-LEFT)
          LENGTH.set((mOp.Subtract((mOp.Add(RIGHT.get(),1)),LEFT.get())));
          //<< . . SET LENL=(LENGTH\2)  ;LINKE SEITE DFLT. ;left-hand side
          mVar LENL = m$.var("LENL");
          LENL.set((mOp.IntegerDivide(LENGTH.get(),2)));
          //<< . . SET COLOR(0)=""
          COLOR.var(0).set("");
          //<< . . SET COLOR(9)=""
          COLOR.var(9).set("");
          //<< . . SET COLOR=""
          COLOR.set("");
          //<< . . IF $PIECE(CHART1,Y,40)'=0 SET COLOR=$GET(^WWWDRAGDROPD(0,CHART,$PIECE(CHART1,Y,40),1))
          if (mOp.NotEqual(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),40),0)) {
            COLOR.set(m$.Fnc.$get(m$.var("^WWWDRAGDROPD",0,CHART.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),40),1)));
          }
          //<< . . IF $PIECE(COLOR,Y,23)'="" SET COLOR(0)=$PIECE(COLOR,Y,23)
          if (mOp.NotEqual(m$.Fnc.$piece(COLOR.get(),m$.var("Y").get(),23),"")) {
            COLOR.var(0).set(m$.Fnc.$piece(COLOR.get(),m$.var("Y").get(),23));
          }
          //<< . . IF $PIECE(COLOR,Y,24)'="" SET COLOR(9)=$PIECE(COLOR,Y,24)
          if (mOp.NotEqual(m$.Fnc.$piece(COLOR.get(),m$.var("Y").get(),24),"")) {
            COLOR.var(9).set(m$.Fnc.$piece(COLOR.get(),m$.var("Y").get(),24));
          }
          //<< . . IF COLOR(0)'="" SET COLOR(0)=$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,COLOR(0),1)),Y,1)
          if (mOp.NotEqual(COLOR.var(0).get(),"")) {
            COLOR.var(0).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),COLOR.var(0).get(),1)),m$.var("Y").get(),1));
          }
          //<< . . IF COLOR(9)'="" SET COLOR(9)=$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,COLOR(9),1)),Y,1)
          if (mOp.NotEqual(COLOR.var(9).get(),"")) {
            COLOR.var(9).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),COLOR.var(9).get(),1)),m$.var("Y").get(),1));
          }
          //<< . . IF COLOR(0)=""  SET COLOR(0)="limegreen"
          if (mOp.Equal(COLOR.var(0).get(),"")) {
            COLOR.var(0).set("limegreen");
          }
          //<< . . IF COLOR(9)=""  SET COLOR(9)=COLOR(0)
          if (mOp.Equal(COLOR.var(9).get(),"")) {
            COLOR.var(9).set(COLOR.var(0).get());
          }
          //<< . . SET COLOR(1)=COLOR(0)
          COLOR.var(1).set(COLOR.var(0).get());
          //<< . . SET COLOR(2)=COLOR(0)
          COLOR.var(2).set(COLOR.var(0).get());
          //<< . . IF LASTRIGHT'=0 IF LASTRIGHT>LEFT SET COLOR(1)=COLOR(9) SET LENL=(LASTRIGHT-LEFT+1)  ;LINKE SEITE ;left-hand side
          if (mOp.NotEqual(LASTRIGHT.get(),0)) {
            if (mOp.Greater(LASTRIGHT.get(),LEFT.get())) {
              COLOR.var(1).set(COLOR.var(9).get());
              LENL.set((mOp.Add(mOp.Subtract(LASTRIGHT.get(),LEFT.get()),1)));
            }
          }
          //<< . . IF LASTRIGHT>RIGHT                SET COLOR(2)=COLOR(9) SET LENL=(LENGTH\2)          ;LINKE SEITE DFLT. ;left-hand side
          if (mOp.Greater(LASTRIGHT.get(),RIGHT.get())) {
            COLOR.var(2).set(COLOR.var(9).get());
            LENL.set((mOp.IntegerDivide(LENGTH.get(),2)));
          }
          //<< . . SET LASTRIGHT=RIGHT
          LASTRIGHT.set(RIGHT.get());
          //<< . . SET LENR=(LENGTH-LENL)  ;RECHTE SEITE ;right-hand side
          mVar LENR = m$.var("LENR");
          LENR.set((mOp.Subtract(LENGTH.get(),LENL.get())));
          //<< . . ;
          //<< . . WRITE YCR,"<DIV id="_""""_"lineal"_ZEILE(1)_""""
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<DIV id=","\""),"lineal"),ZEILE.var(1).get()),"\""));
          //<< . . WRITE " style="_""""
          m$.Cmd.Write(mOp.Concat(" style=","\""));
          //<< . . WRITE " position:absolute;"
          m$.Cmd.Write(" position:absolute;");
          //<< . . WRITE " top:"_(((ZEILE(1)*PIXEL)+(HEADSIZE*PIXEL)+BUTTONLINE)-2)_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" top:",(mOp.Subtract((mOp.Add(mOp.Add((mOp.Multiply(ZEILE.var(1).get(),PIXEL.get())),(mOp.Multiply(HEADSIZE.get(),PIXEL.get()))),BUTTONLINE.get())),2))),";"));
          //<< . . WRITE " left:"_(((LEFT*PIXEL)+(HEADLAENG*PIXEL))-3)_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" left:",(mOp.Subtract((mOp.Add((mOp.Multiply(LEFT.get(),PIXEL.get())),(mOp.Multiply(HEADLAENG.get(),PIXEL.get())))),3))),";"));
          //<< . . WRITE " height:"_PIXEL_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" height:",PIXEL.get()),";"));
          //<< . . WRITE " width:"_((LENGTH*PIXEL)+6)_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",(mOp.Add((mOp.Multiply(LENGTH.get(),PIXEL.get())),6))),";"));
          //<< . . WRITE " text-align:left;"
          m$.Cmd.Write(" text-align:left;");
          //<< . . WRITE " font:9pt arial;"
          m$.Cmd.Write(" font:9pt arial;");
          //<< . . WRITE " white-space:nowrap;"
          m$.Cmd.Write(" white-space:nowrap;");
          //<< . . WRITE " z-index:1;"
          m$.Cmd.Write(" z-index:1;");
          //<< . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . WRITE ">"
          m$.Cmd.Write(">");
          //<< . . ;
          //<< . . WRITE YCR,"<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>"
          m$.Cmd.Write(m$.var("YCR").get(),"<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>");
          //<< . . WRITE YCR,"<tr><td align=left id="_""""_"linleft"_ZEILE(1)_""""
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<tr><td align=left id=","\""),"linleft"),ZEILE.var(1).get()),"\""));
          //<< . . WRITE " style="_""""
          m$.Cmd.Write(mOp.Concat(" style=","\""));
          //<< . . WRITE " border-top:5px solid "_COLOR(1)_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-top:5px solid ",COLOR.var(1).get()),";"));
          //<< . . WRITE " width:"_((LENL*PIXEL)+3)_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",(mOp.Add((mOp.Multiply(LENL.get(),PIXEL.get())),3))),";"));
          //<< . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . WRITE ">"
          m$.Cmd.Write(">");
          //<< . . WRITE YCR,"<img src="_""""_YGIF_"scrdown.gif"_""""_" style="_""""_"vertical-align:top;"_""""_">"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<img src=","\""),m$.var("YGIF").get()),"scrdown.gif"),"\"")," style="),"\""),"vertical-align:top;"),"\""),">"));
          //<< . . ;
          //<< . . WRITE YCR,"</td><td align=right id="_""""_"linright"_ZEILE(1)_""""
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("</td><td align=right id=","\""),"linright"),ZEILE.var(1).get()),"\""));
          //<< . . WRITE " style="_""""
          m$.Cmd.Write(mOp.Concat(" style=","\""));
          //<< . . WRITE " border-top:5px solid "_COLOR(2)_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-top:5px solid ",COLOR.var(2).get()),";"));
          //<< . . WRITE " width:"_((LENR*PIXEL)+3)_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",(mOp.Add((mOp.Multiply(LENR.get(),PIXEL.get())),3))),";"));
          //<< . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . WRITE ">"
          m$.Cmd.Write(">");
          //<< . . WRITE YCR,"<img src="_""""_YGIF_"scrdown.gif"_""""_" style="_""""_"vertical-align:top;"_""""_">"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<img src=","\""),m$.var("YGIF").get()),"scrdown.gif"),"\"")," style="),"\""),"vertical-align:top;"),"\""),">"));
          //<< . . WRITE YCR,"</td></tr></table>"
          m$.Cmd.Write(m$.var("YCR").get(),"</td></tr></table>");
          //<< . . WRITE YCR,"</DIV>"
          m$.Cmd.Write(m$.var("YCR").get(),"</DIV>");
        } while (false);
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< ;BALKENDIAGRAMM
    //<< ;--------------
    //<< IF $PIECE(CHART1,Y,24)=1 IF HISTSIZE>0 DO
    if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),24),1)) {
      if (mOp.Greater(HISTSIZE.get(),0)) {
        //<< . NEW DATA,PLEFT,PTOP,HEIGHT,WIDTH,LNUM,CNUM,DATA1,RCOLOR,RCOLOR2,TEMPDATA,TEMPD,JUST,WERT
        mVar DATA = m$.var("DATA");
        mVar PLEFT = m$.var("PLEFT");
        mVar PTOP = m$.var("PTOP");
        mVar HEIGHT = m$.var("HEIGHT");
        mVar WIDTH = m$.var("WIDTH");
        mVar LNUM = m$.var("LNUM");
        mVar CNUM = m$.var("CNUM");
        mVar DATA1 = m$.var("DATA1");
        mVar RCOLOR = m$.var("RCOLOR");
        mVar RCOLOR2 = m$.var("RCOLOR2");
        mVar TEMPDATA = m$.var("TEMPDATA");
        mVar TEMPD = m$.var("TEMPD");
        mVar JUST = m$.var("JUST");
        mVar WERT = m$.var("WERT");
        m$.newVarBlock(1,DATA,PLEFT,PTOP,HEIGHT,WIDTH,LNUM,CNUM,DATA1,RCOLOR,RCOLOR2,TEMPDATA,TEMPD,JUST,WERT);
        //<< . NEW YKEY1T,YKEY1
        mVar YKEY1T = m$.var("YKEY1T");
        mVar YKEY1 = m$.var("YKEY1");
        m$.newVarBlock(1,YKEY1T,YKEY1);
        //<< . SET DATA1=""      ;REFERENZLINIE
        DATA1.set("");
        //<< . SET DATA=""
        DATA.set("");
        //<< . SET JUST=0
        JUST.set(0);
        //<< . SET LEFTX=""
        LEFTX.set("");
        //<< . FOR  SET LEFTX=$ORDER(^WWWSOR(YUSER,"Y-REF",LEFTX)) QUIT:LEFTX=""  DO
        for (;true;) {
          LEFTX.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"Y-REF",LEFTX.get())));
          if (mOp.Equal(LEFTX.get(),"")) {
            break;
          }
          do {
            //<< . . ;QUIT:LEFTX>1000       ;ZUR SICHERHEIT WEGEN ENDLOSSCHLEIFE
            //<< . . QUIT:LEFTX>COLUMNS     ;ZUR SICHERHEIT WEGEN ENDLOSSCHLEIFE ;self-assurance quibble
            if (mOp.Greater(LEFTX.get(),COLUMNS.get())) {
              break;
            }
            //<< . . SET WERT=$GET(^WWWSOR(YUSER,"Y-REF",LEFTX))
            WERT.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"Y-REF",LEFTX.get())));
            //<< . . SET $PIECE(DATA,Y,LEFTX+1)=WERT
            m$.pieceVar(DATA,m$.var("Y").get(),mOp.Add(LEFTX.get(),1)).set(WERT.get());
          } while (false);
        }
        //<< . ;
        //<< . SET PTOP   = ((LINE*PIXEL)-1+BUTTONLINE)  ;POSITION TOP
        PTOP.set((mOp.Add(mOp.Subtract((mOp.Multiply(LINE.get(),PIXEL.get())),1),BUTTONLINE.get())));
        //<< . SET PLEFT  = (HEADLAENG*PIXEL)  ;POSITION LEFT
        PLEFT.set((mOp.Multiply(HEADLAENG.get(),PIXEL.get())));
        //<< . SET HEIGHT = (HISTSIZE*PIXEL)   ;HEIGHT IN PIXEL ;within
        HEIGHT.set((mOp.Multiply(HISTSIZE.get(),PIXEL.get())));
        //<< . SET WIDTH  = (((COLUMNS*PIXEL)-(HEADLAENG*PIXEL))-1)  ;WIDTH IN PIXEL ;within
        WIDTH.set((mOp.Subtract((mOp.Subtract((mOp.Multiply(COLUMNS.get(),PIXEL.get())),(mOp.Multiply(HEADLAENG.get(),PIXEL.get())))),1)));
        //<< . SET LNUM   = 0                  ;DYN. AUFBAUEN ;construct
        LNUM.set(0);
        //<< . SET CNUM   = COLUMNS-HEADLAENG  ;NUMBER OF FIELDS
        CNUM.set(mOp.Subtract(COLUMNS.get(),HEADLAENG.get()));
        //<< . SET LNUM   = LINE-HEADSIZE      ;NUMBER OF LINES
        LNUM.set(mOp.Subtract(LINE.get(),HEADSIZE.get()));
        //<< . IF +$PIECE(CHART1,Y,64)'=0 DO   ;GRÖSSTEN WERT ERMITTELN WENN DYN. AUFBAU ;worthy find when
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),64)),0)) {
          //<< . . NEW YI
          mVar YI = m$.var("YI");
          m$.newVarBlock(2,YI);
          //<< . . SET LNUM=0
          LNUM.set(0);
          //<< . . FOR YI=1:1:CNUM IF +$PIECE(DATA,Y,YI)>LNUM SET LNUM=$PIECE(DATA,Y,YI)
          for (YI.set(1);(mOp.LessOrEqual(YI.get(),CNUM.get()));YI.set(mOp.Add(YI.get(),1))) {
            if (mOp.Greater(mOp.Positive(m$.Fnc.$piece(DATA.get(),m$.var("Y").get(),YI.get())),LNUM.get())) {
              LNUM.set(m$.Fnc.$piece(DATA.get(),m$.var("Y").get(),YI.get()));
            }
          }
        }
        m$.restoreVarBlock(2);
        //<< . ;
        //<< . ;SET DATA1=$GET(^WWWSOR(YUSER,"DATA1",1))
        //<< . SET TEMPDATA = $GET(^WWWSOR(YUSER,"DATA1",1))
        TEMPDATA.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"DATA1",1)));
        //<< . SET YKEY1T   = $GET(^WWWSOR(YUSER,"DATA1KEY",1))
        YKEY1T.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"DATA1KEY",1)));
        //<< . NEW YI,YII
        mVar YI = m$.var("YI");
        mVar YII = m$.var("YII");
        m$.newVarBlock(1,YI,YII);
        //<< . FOR YII=1:1 QUIT:$PIECE(TEMPDATA,Y,YII,9999)=""  DO    ;SETZTEN DER REFERENZLINIE PRO TAG ;the within TAG
        for (YII.set(1);(true);YII.set(mOp.Add(YII.get(),1))) {
          if (mOp.Equal(m$.Fnc.$piece(TEMPDATA.get(),m$.var("Y").get(),YII.get(),9999),"")) {
            break;
          }
          //<< . . FOR YI=1:1:TIMESIZE DO
          for (YI.set(1);(mOp.LessOrEqual(YI.get(),m$.var("TIMESIZE").get()));YI.set(mOp.Add(YI.get(),1))) {
            //<< . . . IF +TIMESIZE'=0 IF $PIECE(TEMPDATA,Y,YII)'="X" SET DATA1=$GET(DATA1)_($PIECE(TEMPDATA,Y,YII)/TIMESIZE)_Y
            if (mOp.NotEqual(mOp.Positive(m$.var("TIMESIZE").get()),0)) {
              if (mOp.NotEqual(m$.Fnc.$piece(TEMPDATA.get(),m$.var("Y").get(),YII.get()),"X")) {
                DATA1.set(mOp.Concat(mOp.Concat(m$.Fnc.$get(DATA1),(mOp.Divide(m$.Fnc.$piece(TEMPDATA.get(),m$.var("Y").get(),YII.get()),m$.var("TIMESIZE").get()))),m$.var("Y").get()));
              }
            }
            //<< . . . IF +TIMESIZE=0!($PIECE(TEMPDATA,Y,YII)="X") SET DATA1=$GET(DATA1)_$PIECE(TEMPDATA,Y,YII)_Y
            if (mOp.Or(mOp.Equal(mOp.Positive(m$.var("TIMESIZE").get()),0),(mOp.Equal(m$.Fnc.$piece(TEMPDATA.get(),m$.var("Y").get(),YII.get()),"X")))) {
              DATA1.set(mOp.Concat(mOp.Concat(m$.Fnc.$get(DATA1),m$.Fnc.$piece(TEMPDATA.get(),m$.var("Y").get(),YII.get())),m$.var("Y").get()));
            }
            //<< . . . SET YKEY1=$GET(YKEY1)_$PIECE(YKEY1T,Y,YII)_Y
            YKEY1.set(mOp.Concat(mOp.Concat(m$.Fnc.$get(YKEY1),m$.Fnc.$piece(YKEY1T.get(),m$.var("Y").get(),YII.get())),m$.var("Y").get()));
          }
        }
        //<< . ;
        //<< . SET RCOLOR=""
        RCOLOR.set("");
        //<< . IF $PIECE(CHART1,Y,26)'="" DO  ;FARBE REFENZLINE ;tincture
        if (mOp.NotEqual(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),26),"")) {
          //<< . . SET RCOLOR=$PIECE(CHART1,Y,26)
          RCOLOR.set(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),26));
          //<< . . IF RCOLOR'="" SET RCOLOR=$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,RCOLOR,1)),Y,1)
          if (mOp.NotEqual(RCOLOR.get(),"")) {
            RCOLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),RCOLOR.get(),1)),m$.var("Y").get(),1));
          }
        }
        //<< . ;
        //<< . IF RCOLOR="" SET RCOLOR="red"
        if (mOp.Equal(RCOLOR.get(),"")) {
          RCOLOR.set("red");
        }
        //<< . SET RCOLOR2=""
        RCOLOR2.set("");
        //<< . IF $PIECE(CHART1,Y,27)'="" DO  ;FARBE BOXES BELOW THE REFERENZ LINE ;tincture reference
        if (mOp.NotEqual(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),27),"")) {
          //<< . . SET RCOLOR2=$PIECE(CHART1,Y,27)
          RCOLOR2.set(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),27));
          //<< . . IF RCOLOR2'="" SET RCOLOR2=$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,RCOLOR2,1)),Y,1)
          if (mOp.NotEqual(RCOLOR2.get(),"")) {
            RCOLOR2.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),RCOLOR2.get(),1)),m$.var("Y").get(),1));
          }
        }
        //<< . ;
        //<< . IF RCOLOR2="" SET RCOLOR2="red"
        if (mOp.Equal(RCOLOR2.get(),"")) {
          RCOLOR2.set("red");
        }
        //<< . NEW RLINK,NAMES
        mVar RLINK = m$.var("RLINK");
        mVar NAMES = m$.var("NAMES");
        m$.newVarBlock(1,RLINK,NAMES);
        //<< . ;SET NAMES=$PIECE(CHART1,Y,51)_Y_$PIECE(CHART1,Y,52)_Y_$PIECE(CHART1,Y,53)_Y_$PIECE(CHART1,Y,54)_Y_$PIECE(CHART1,Y,55)
        //<< . SET NAMES=$$^WWWTEXT($PIECE(CHART1,Y,51))  ;LEGENDE HISTOGRAMM ;legend
        NAMES.set(m$.fnc$("WWWTEXT.main",m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),51)));
        //<< . SET NAMES=NAMES_Y_$$^WWWFELDNAME("WWWDRAGDROP","D",25)  ;AUSLASTUNG
        NAMES.set(mOp.Concat(mOp.Concat(NAMES.get(),m$.var("Y").get()),m$.fnc$("WWWFELDNAME.main","WWWDRAGDROP","D",25)));
        //<< . SET NAMES=NAMES_Y_$$^WWWFELDNAME("WWWDRAGDROP","D",26)  ;KAPAZITÄT ;potentiality
        NAMES.set(mOp.Concat(mOp.Concat(NAMES.get(),m$.var("Y").get()),m$.fnc$("WWWFELDNAME.main","WWWDRAGDROP","D",26)));
        //<< . SET NAMES=NAMES_Y_$$^WWWFELDNAME("WWWDRAGDROP","D",27)  ;ÜBERLASTUNG
        NAMES.set(mOp.Concat(mOp.Concat(NAMES.get(),m$.var("Y").get()),m$.fnc$("WWWFELDNAME.main","WWWDRAGDROP","D",27)));
        //<< . SET NAMES=NAMES_Y_$$^WWWFELDNAME("WWWDRAGDROP","D",26)_" "_$$^WWWTEXT(33634)  ;KAPAZITÄT (ÜBER SKALA) ;potentiality
        NAMES.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(NAMES.get(),m$.var("Y").get()),m$.fnc$("WWWFELDNAME.main","WWWDRAGDROP","D",26))," "),m$.fnc$("WWWTEXT.main",33634)));
        //<< . SET RLINK=$PIECE(CHART1,Y,50)     ;LINK ÄNDERN REFERENZLINIE ;alter
        RLINK.set(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),50));
        //<< . IF $GET(YPRINTMODE)=1 SET RLINK=""
        if (mOp.Equal(m$.Fnc.$get(m$.var("YPRINTMODE")),1)) {
          RLINK.set("");
        }
        //<< . DO ^WWWDIAGRAMM(PTOP,PLEFT,HEIGHT,WIDTH,LNUM,CNUM,DATA,DATA1,HISTCOLOR,RCOLOR,RCOLOR2,,,RLINK,NAMES,$PIECE(CHART1,Y,56),$PIECE(CHART1,Y,57),$GET(TIMESIZE),$GET(YKEY1))
        m$.Cmd.Do("WWWDIAGRAMM.main",PTOP.get(),PLEFT.get(),HEIGHT.get(),WIDTH.get(),LNUM.get(),CNUM.get(),DATA.get(),DATA1.get(),HISTCOLOR.get(),RCOLOR.get(),RCOLOR2.get(),null,null,RLINK.get(),NAMES.get(),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),56),m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),57),m$.Fnc.$get(m$.var("TIMESIZE")),m$.Fnc.$get(YKEY1));
        //<< . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DIAGR-HEIGHT",1)=HEIGHT
        m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DIAGR-HEIGHT",1).set(HEIGHT.get());
        //<< . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DIAGR-WIDTH",1)=WIDTH
        m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DIAGR-WIDTH",1).set(WIDTH.get());
        //<< . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DIAGR-LNUM",1)=LNUM
        m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DIAGR-LNUM",1).set(LNUM.get());
        //<< . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DIAGR-CNUM",1)=CNUM
        m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DIAGR-CNUM",1).set(CNUM.get());
        //<< . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DIAGR-DATA",1)=DATA
        m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DIAGR-DATA",1).set(DATA.get());
        //<< . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DIAGR-DATA",2)=DATA
        m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DIAGR-DATA",2).set(DATA.get());
        //<< . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DIAGR-REFLINE",1)=DATA1
        m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DIAGR-REFLINE",1).set(DATA1.get());
        //<< . IF $PIECE(CHART1,Y,61)=1 DO  ;MERKEN FÜR RELOAD ;to
        if (mOp.Equal(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),61),1)) {
          //<< . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATA1",1)=$GET(^WWWSOR(YUSER,"DATA1",1))
          m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATA1",1).set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"DATA1",1)));
          //<< . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATA1KEY",1)=$GET(^WWWSOR(YUSER,"DATA1KEY",1))
          m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATA1KEY",1).set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"DATA1KEY",1)));
        }
      }
      m$.restoreVarBlock(1);
    }
    //<< 
    //<< WRITE "</FORM>"
    m$.Cmd.Write("</FORM>");
    //<< WRITE "</DIV>"
    m$.Cmd.Write("</DIV>");
    //<< SET YNOEVENTKEY=1
    YNOEVENTKEY.set(1);
    //<< DO ^WWWFORM8
    m$.Cmd.Do("WWWFORM8.main");
    //<< DO EVENT^WWWFORM  ;CSP HYPEREVENT
    m$.Cmd.Do("WWWFORM.EVENT");
    //<< 
    //<< ;SPEICHERN FÜR HYPEREVENT ;Save to
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","CHART",1)      = CHART
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","CHART",1).set(CHART.get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","PIXEL",1)      = PIXEL
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","PIXEL",1).set(PIXEL.get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","HEADLAENG",1)  = HEADLAENG
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","HEADLAENG",1).set(HEADLAENG.get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","HEADSIZE",1)   = HEADSIZE
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","HEADSIZE",1).set(HEADSIZE.get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","BUTTONLINE",1) = BUTTONLINE
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","BUTTONLINE",1).set(BUTTONLINE.get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","TIMESIZE",1)   = TIMESIZE
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","TIMESIZE",1).set(m$.var("TIMESIZE").get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","ROWS",1)       = ROWS
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","ROWS",1).set(ROWS.get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","COLUMNS",1)    = COLUMNS
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","COLUMNS",1).set(COLUMNS.get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","TIMESCALE",1)  = START
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","TIMESCALE",1).set(START.get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","ARBSTUNDEN",1) = ARBSTUNDEN
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","ARBSTUNDEN",1).set(ARBSTUNDEN.get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","ARBBEGINN",1)  = ARBBEGINN
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","ARBBEGINN",1).set(ARBBEGINN.get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","YSTARTDATE",1) = START
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","YSTARTDATE",1).set(START.get());
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATLFN1",1)    = $GET(DATLFN(1))
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATLFN1",1).set(m$.Fnc.$get(DATLFN.var(1)));
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATLFN2",1)    = $GET(DATLFN(2))
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATLFN2",1).set(m$.Fnc.$get(DATLFN.var(2)));
    //<< SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","ZNSTART",1)    = ZNSTART
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","ZNSTART",1).set(ZNSTART.get());
    //<< KILL ^WWWSOR(YUSER)
    m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
    //<< WRITE YCR,"</BODY>"
    m$.Cmd.Write(m$.var("YCR").get(),"</BODY>");
    //<< WRITE "</HTML>"
    m$.Cmd.Write("</HTML>");
    //<< QUIT
    return null;
  }

  //<< 
  //<< TIMESCALE   ;ZEITSKALA
  public void TIMESCALE() {
    //<< NEW YI,YII,YDDCOL,YDDROW,WEEK,MONAT,JAHR,MONTHDAYS,WEEKDAYS,DATE1,DATE,TIME,YVORG,ENDE,DAUER,YA,MAXDAYS
    mVar YI = m$.var("YI");
    mVar YII = m$.var("YII");
    mVar YDDCOL = m$.var("YDDCOL");
    mVar YDDROW = m$.var("YDDROW");
    mVar WEEK = m$.var("WEEK");
    mVar MONAT = m$.var("MONAT");
    mVar JAHR = m$.var("JAHR");
    mVar MONTHDAYS = m$.var("MONTHDAYS");
    mVar WEEKDAYS = m$.var("WEEKDAYS");
    mVar DATE1 = m$.var("DATE1");
    mVar DATE = m$.var("DATE");
    mVar TIME = m$.var("TIME");
    mVar YVORG = m$.var("YVORG");
    mVar ENDE = m$.var("ENDE");
    mVar DAUER = m$.var("DAUER");
    mVar YA = m$.var("YA");
    mVar MAXDAYS = m$.var("MAXDAYS");
    m$.newVar(YI,YII,YDDCOL,YDDROW,WEEK,MONAT,JAHR,MONTHDAYS,WEEKDAYS,DATE1,DATE,TIME,YVORG,ENDE,DAUER,YA,MAXDAYS);
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   VORG        objINVORG
    //<< ;   D16         $$$INVORGWorkingHoursPerDay()
    //<< ;   D152        $$$INVORGWorkStart()
    //<< ;   D153        $$$INVORGWorkEnd()
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< SET (YDDROW,YDDCOL)=0
    YDDROW.set(0);
    YDDCOL.set(0);
    //<< SET YII=0
    YII.set(0);
    //<< SET HEADSIZE=(MON+WEK+DAY+UHR)
    mVar HEADSIZE = m$.var("HEADSIZE");
    HEADSIZE.set((mOp.Add(mOp.Add(mOp.Add(m$.var("MON").get(),m$.var("WEK").get()),m$.var("DAY").get()),m$.var("UHR").get())));
    //<< SET TIMESIZE=1
    mVar TIMESIZE = m$.var("TIMESIZE");
    TIMESIZE.set(1);
    do {
      //<< DO
      //<< . SET YVORG=$GET(^INVORG(YM,YM,1))
      YVORG.set(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)));
      //<< . SET ARBBEGINN = $PIECE(YVORG,Y,152)    ;ARBEITSBEGINN AUS ALLG. ABLAUFPARAMETERN ;out of
      mVar ARBBEGINN = m$.var("ARBBEGINN");
      ARBBEGINN.set(m$.Fnc.$piece(YVORG.get(),m$.var("Y").get(),152));
      //<< . SET ENDE      = $PIECE(YVORG,Y,153)    ;ARBEITSENDE  AUS ALLG. ABLAUFPARAMETERN ;out of
      ENDE.set(m$.Fnc.$piece(YVORG.get(),m$.var("Y").get(),153));
      //<< . ;
      //<< . SET TIMESIZE=0
      TIMESIZE.set(0);
      //<< . IF +ARBBEGINN'=0 IF +ENDE'=0 SET TIMESIZE=((ENDE-ARBBEGINN)/60/60)
      if (mOp.NotEqual(mOp.Positive(ARBBEGINN.get()),0)) {
        if (mOp.NotEqual(mOp.Positive(ENDE.get()),0)) {
          TIMESIZE.set((mOp.Divide(mOp.Divide((mOp.Subtract(ENDE.get(),ARBBEGINN.get())),60),60)));
        }
      }
      //<< . IF +TIMESIZE=0 SET TIMESIZE=$PIECE(YVORG,Y,16)  ;ARBEITSZEIT AUS MANDANTENVORGABE ;working hours out of
      if (mOp.Equal(mOp.Positive(TIMESIZE.get()),0)) {
        TIMESIZE.set(m$.Fnc.$piece(YVORG.get(),m$.var("Y").get(),16));
      }
      //<< . IF +TIMESIZE=0 SET TIMESIZE=8                   ;STUNDEN ;delay
      if (mOp.Equal(mOp.Positive(TIMESIZE.get()),0)) {
        TIMESIZE.set(8);
      }
      //<< . ;
      //<< . IF +ARBBEGINN'=0 IF +ENDE=0  SET ENDE=ARBBEGINN+TIMESIZE
      if (mOp.NotEqual(mOp.Positive(ARBBEGINN.get()),0)) {
        if (mOp.Equal(mOp.Positive(ENDE.get()),0)) {
          ENDE.set(mOp.Add(ARBBEGINN.get(),TIMESIZE.get()));
        }
      }
      //<< . IF +ARBBEGINN=0  IF +ENDE'=0 SET ARBBEGINN=ENDE-TIMESIZE
      if (mOp.Equal(mOp.Positive(ARBBEGINN.get()),0)) {
        if (mOp.NotEqual(mOp.Positive(ENDE.get()),0)) {
          ARBBEGINN.set(mOp.Subtract(ENDE.get(),TIMESIZE.get()));
        }
      }
      //<< . IF +ARBBEGINN=0 SET ARBBEGINN=$$^WWWTIME1("08:00")
      if (mOp.Equal(mOp.Positive(ARBBEGINN.get()),0)) {
        ARBBEGINN.set(m$.fnc$("WWWTIME1.main","08:00"));
      }
      //<< . IF +ENDE=0 SET ENDE=ARBBEGINN+TIMESIZE
      if (mOp.Equal(mOp.Positive(ENDE.get()),0)) {
        ENDE.set(mOp.Add(ARBBEGINN.get(),TIMESIZE.get()));
      }
    } while(false);
    //<< 
    //<< SET ARBSTUNDEN=TIMESIZE
    mVar ARBSTUNDEN = m$.var("ARBSTUNDEN");
    ARBSTUNDEN.set(TIMESIZE.get());
    //<< IF UHR'=1 SET TIMESIZE=1
    if (mOp.NotEqual(m$.var("UHR").get(),1)) {
      TIMESIZE.set(1);
    }
    //<< FOR YI="MON","WEK","DAY","UHR" DO
    for (Object _YI: new Object[] {"MON","WEK","DAY","UHR"}) {
    YI.set(_YI);
      do {
        //<< . QUIT:@YI=0  ;NICHT ANZEIGEN ;Not display
        if (mOp.Equal(m$.indirectVar(_YI).get(),0)) {
          break;
        }
        //<< . SET YII=YII+1
        YII.set(mOp.Add(YII.get(),1));
        //<< . WRITE YCR,"<tr>"
        m$.Cmd.Write(m$.var("YCR").get(),"<tr>");
        //<< . ;
        //<< . ;DESCRIPTION
        //<< . IF HEADLAENG>0 DO
        if (mOp.Greater(m$.var("HEADLAENG").get(),0)) {
          //<< . . WRITE YCR,"<td align=middle valign=middle"
          m$.Cmd.Write(m$.var("YCR").get(),"<td align=middle valign=middle");
          //<< . . WRITE " BGCOLOR="_YSILVER
          m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YSILVER").get()));
          //<< . . WRITE " COLSPAN="_HEADLAENG
          m$.Cmd.Write(mOp.Concat(" COLSPAN=",m$.var("HEADLAENG").get()));
          //<< . . WRITE ">"
          m$.Cmd.Write(">");
          //<< . . WRITE YCR,"<div valign=middle"
          m$.Cmd.Write(m$.var("YCR").get(),"<div valign=middle");
          //<< . . WRITE " style="_""""
          m$.Cmd.Write(mOp.Concat(" style=","\""));
          //<< . . WRITE " height:"_PIXEL_"px;"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" height:",m$.var("PIXEL").get()),"px;"));
          //<< . . WRITE " width:"_(PIXEL*HEADLAENG)_"px;"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",(mOp.Multiply(m$.var("PIXEL").get(),m$.var("HEADLAENG").get()))),"px;"));
          //<< . . WRITE " text-align:middle;"
          m$.Cmd.Write(" text-align:middle;");
          //<< . . WRITE " font:"_FONTSIZE_"pt arial;"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" font:",m$.var("FONTSIZE").get()),"pt arial;"));
          //<< . . ;WRITE " font-weight:bold;"
          //<< . . WRITE " border-left:1px solid;"
          m$.Cmd.Write(" border-left:1px solid;");
          //<< . . WRITE " border-right:1px solid;"
          m$.Cmd.Write(" border-right:1px solid;");
          //<< . . IF YII=1 WRITE " border-top:1px solid;"
          if (mOp.Equal(YII.get(),1)) {
            m$.Cmd.Write(" border-top:1px solid;");
          }
          //<< . . IF YII=(MON+WEK+DAY+UHR-1) WRITE " border-bottom:1px solid;"
          if (mOp.Equal(YII.get(),(mOp.Subtract(mOp.Add(mOp.Add(mOp.Add(m$.var("MON").get(),m$.var("WEK").get()),m$.var("DAY").get()),m$.var("UHR").get()),1)))) {
            m$.Cmd.Write(" border-bottom:1px solid;");
          }
          //<< . . WRITE " border-Bottom-Color:"_COLORLIGHT_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Bottom-Color:",m$.var("COLORLIGHT").get()),";"));
          //<< . . WRITE " border-Right-Color:"_COLORLIGHT_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Right-Color:",m$.var("COLORLIGHT").get()),";"));
          //<< . . WRITE " border-Top-Color:"_COLORDARK_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Top-Color:",m$.var("COLORDARK").get()),";"));
          //<< . . WRITE " border-Left-Color:"_COLORDARK_";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Left-Color:",m$.var("COLORDARK").get()),";"));
          //<< . . WRITE " overflow:hidden;"
          m$.Cmd.Write(" overflow:hidden;");
          //<< . . WRITE """"_">"
          m$.Cmd.Write(mOp.Concat("\"",">"));
          //<< . . IF YII=1 IF (MON+WEK+DAY+UHR)>1 DO
          if (mOp.Equal(YII.get(),1)) {
            if (mOp.Greater((mOp.Add(mOp.Add(mOp.Add(m$.var("MON").get(),m$.var("WEK").get()),m$.var("DAY").get()),m$.var("UHR").get())),1)) {
              //<< . . . IF (MON+WEK+DAY+UHR)>3  WRITE YCR,"<B>"_YKOPF_"</B>"
              if (mOp.Greater((mOp.Add(mOp.Add(mOp.Add(m$.var("MON").get(),m$.var("WEK").get()),m$.var("DAY").get()),m$.var("UHR").get())),3)) {
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<B>",m$.var("YKOPF").get()),"</B>"));
              }
              //<< . . . IF (MON+WEK+DAY+UHR)'>3 WRITE "<B>"_$$^WWWDATE(START)_" - "_$$^WWWDATE(STOP)_"</B>"  ;VON - BIS ;until
              if (mOp.NotGreater((mOp.Add(mOp.Add(mOp.Add(m$.var("MON").get(),m$.var("WEK").get()),m$.var("DAY").get()),m$.var("UHR").get())),3)) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<B>",m$.fnc$("WWWDATE.main",m$.var("START").get()))," - "),m$.fnc$("WWWDATE.main",m$.var("STOP").get())),"</B>"));
              }
            }
          }
          //<< . . ;
          //<< . . IF YII=2 IF (MON+WEK+DAY+UHR)>2 DO
          if (mOp.Equal(YII.get(),2)) {
            if (mOp.Greater((mOp.Add(mOp.Add(mOp.Add(m$.var("MON").get(),m$.var("WEK").get()),m$.var("DAY").get()),m$.var("UHR").get())),2)) {
              do {
                //<< . . . ;IF (MON+WEK+DAY+UHR)>3 WRITE "&nbsp;&nbsp;"_$$^WWWTEXT(31002)_" "_$$^WWWDATE(START)_" "_$$^WWWTEXT(69)_" "_$$^WWWDATE(STOP) QUIT  ;VON - BIS  ;BR014923
                //<< . . . IF (MON+WEK+DAY+UHR)>3 WRITE "&nbsp;&nbsp;"_$$^WWWTEXT(31002)_" "_$$^WWWDATE(START)_" "_$$$Text($listbuild("54",$$^WWWDATE(STOP))) QUIT  ;VON - BIS  ;BR014923  ;$lb("54",""): To %1
                if (mOp.Greater((mOp.Add(mOp.Add(mOp.Add(m$.var("MON").get(),m$.var("WEK").get()),m$.var("DAY").get()),m$.var("UHR").get())),3)) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&nbsp;&nbsp;",m$.fnc$("WWWTEXT.main",31002))," "),m$.fnc$("WWWDATE.main",m$.var("START").get()))," "),include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("54",m$.fnc$("WWWDATE.main",m$.var("STOP").get())))));
                  break;
                }
                //<< . . . IF $PIECE(CHART1,Y,60)=1 QUIT  ;TEXT IN BLÄTTERFUNKTION ;Text within
                if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),60),1)) {
                  break;
                }
                //<< . . . ;WRITE $$^WWWTEXT(33629)_": "_+$GET(DATLFN(2))_" "_$$^WWWTEXT(68)_" "_+$GET(DATLFN(1))  ;ANGEZEIGTE DATENSÄTZE n VON nn ;substitute product   ;BR014923
                //<< . . . WRITE $$^WWWTEXT(33629)_": "_+$GET(DATLFN(2))_" "_$$$Text($listbuild("53",+$GET(DATLFN(1))))  ;ANGEZEIGTE DATENSÄTZE n VON nn ;substitute product   ;BR014923  ;$lb("53",""): From %1
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",33629),": "),mOp.Positive(m$.Fnc.$get(m$.var("DATLFN").var(2))))," "),include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("53",mOp.Positive(m$.Fnc.$get(m$.var("DATLFN").var(1)))))));
              } while (false);
            }
          }
          //<< . . ;
          //<< . . IF YII=3 IF (MON+WEK+DAY+UHR)>3 DO
          if (mOp.Equal(YII.get(),3)) {
            if (mOp.Greater((mOp.Add(mOp.Add(mOp.Add(m$.var("MON").get(),m$.var("WEK").get()),m$.var("DAY").get()),m$.var("UHR").get())),3)) {
              do {
                //<< . . . IF $PIECE(CHART1,Y,60)=1 QUIT  ;TEXT IN BLÄTTERFUNKTION ;Text within
                if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),60),1)) {
                  break;
                }
                //<< . . . ;WRITE $$^WWWTEXT(33629)_": "_+$GET(DATLFN(2))_" "_$$^WWWTEXT(68)_" "_+$GET(DATLFN(1))  ;ANGEZEIGTE DATENSÄTZE n VON nn ;substitute product   ;BR014923
                //<< . . . WRITE $$^WWWTEXT(33629)_": "_+$GET(DATLFN(2))_" "_$$$Text($listbuild("53",+$GET(DATLFN(1))))  ;ANGEZEIGTE DATENSÄTZE n VON nn ;substitute product   ;BR014923  ;$lb("53",""): From %1
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",33629),": "),mOp.Positive(m$.Fnc.$get(m$.var("DATLFN").var(2))))," "),include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("53",mOp.Positive(m$.Fnc.$get(m$.var("DATLFN").var(1)))))));
                //<< . . . IF YAUSWAHL'="" WRITE " ("_$$^WWWTEXT(33631)_")" QUIT  ;EINGESCHRÄNKTE AUSWAHL ;Selection
                if (mOp.NotEqual(m$.var("YAUSWAHL").get(),"")) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" (",m$.fnc$("WWWTEXT.main",33631)),")"));
                  break;
                }
                //<< . . . IF $DATA(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENx")) WRITE " <font color="_YRED_">("_$$^WWWTEXT(33628)_")</font>"  ;GEFILTERT DATEN
                if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENx")))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" <font color=",m$.var("YRED").get()),">("),m$.fnc$("WWWTEXT.main",33628)),")</font>"));
                }
              } while (false);
            }
          }
          //<< . . ;
          //<< . . IF YII=(MON+WEK+DAY+UHR) DO
          if (mOp.Equal(YII.get(),(mOp.Add(mOp.Add(mOp.Add(m$.var("MON").get(),m$.var("WEK").get()),m$.var("DAY").get()),m$.var("UHR").get())))) {
            do {
              //<< . . . ;NEW YNUM,YFELD
              //<< . . . ;SET YZA=0 ;table-mat
              //<< . . . ;SET YNUM="" FOR  SET YNUM=$ORDER(^WWWDRAGDROPD(0,CHART,YNUM)) QUIT:YNUM=""  DO
              //<< . . . ;. ;SET YFELD=$GET(^WWWDRAGDROPD(0,CHART,YNUM,1))
              //<< . . . ;. ;IF $PIECE(YFELD,Y,5)=1 SET YZA=YZA+1
              //<< . . . ;. I $P(YSETUP,Y,YNUM)=1 S YZA=YZA+1
              //<< . . . QUIT:YZA=0
              if (mOp.Equal(m$.var("YZA").get(),0)) {
                break;
              }
              //<< . . . ;SET YZAMAX=(HEADLAENG*PIXEL)  ;MAX HEADER BREITE ;table-mat width
              //<< . . . WRITE YCR,"<TABLE style="_""""_"table-layout:fixed;"_""""_" BORDER=0 CELLSPACING=0 CELLPADDING=0><TR>"
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TABLE style=","\""),"table-layout:fixed;"),"\"")," BORDER=0 CELLSPACING=0 CELLPADDING=0><TR>"));
              //<< . . . SET YA=0
              YA.set(0);
              //<< . . . SET YNUM=""
              mVar YNUM = m$.var("YNUM");
              YNUM.set("");
              //<< . . . FOR  SET YNUM=$ORDER(^WWWDRAGDROPD(0,CHART,YNUM)) QUIT:YNUM=""  DO
              for (;true;) {
                YNUM.set(m$.Fnc.$order(m$.var("^WWWDRAGDROPD",0,m$.var("CHART").get(),YNUM.get())));
                if (mOp.Equal(YNUM.get(),"")) {
                  break;
                }
                do {
                  //<< . . . . SET YFELD=$GET(^WWWDRAGDROPD(0,CHART,YNUM,1))
                  mVar YFELD = m$.var("YFELD");
                  YFELD.set(m$.Fnc.$get(m$.var("^WWWDRAGDROPD",0,m$.var("CHART").get(),YNUM.get(),1)));
                  //<< . . . . ;IF $PIECE(YFELD,Y,5)'=1 QUIT
                  //<< . . . . IF $PIECE(YSETUP,Y,YNUM)'=1 QUIT
                  if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSETUP").get(),m$.var("Y").get(),YNUM.get()),1)) {
                    break;
                  }
                  //<< . . . . SET YA=YA+1
                  YA.set(mOp.Add(YA.get(),1));
                  //<< . . . . SET YZASIZE=$PIECE(YFELD,Y,16)  ;FELDBREITE
                  mVar YZASIZE = m$.var("YZASIZE");
                  YZASIZE.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),16));
                  //<< . . . . IF +YZASIZE=0 SET YZASIZE=4*PIXEL  ;DFLT. BREITE ;width
                  if (mOp.Equal(mOp.Positive(YZASIZE.get()),0)) {
                    YZASIZE.set(mOp.Multiply(4,m$.var("PIXEL").get()));
                  }
                  //<< . . . . ;IF +YZASIZE=0 SET YZASIZE=$JUSTIFY((HEADLAENG*PIXEL)/YZA,0,0)  ;DFLT. BREITE
                  //<< . . . . SET YZASIZE=(YZASIZE\PIXEL)*PIXEL
                  YZASIZE.set(mOp.Multiply((mOp.IntegerDivide(YZASIZE.get(),m$.var("PIXEL").get())),m$.var("PIXEL").get()));
                  //<< . . . . IF YA=YZA SET YZASIZE=YZAMAX  ;RESTBREITE
                  if (mOp.Equal(YA.get(),m$.var("YZA").get())) {
                    YZASIZE.set(m$.var("YZAMAX").get());
                  }
                  //<< . . . . SET YZAMAX=YZAMAX-YZASIZE  ;RESTL. BREITE ;width
                  mVar YZAMAX = m$.var("YZAMAX");
                  YZAMAX.set(mOp.Subtract(m$.var("YZAMAX").get(),YZASIZE.get()));
                  //<< . . . . IF YZAMAX<0 QUIT
                  if (mOp.Less(YZAMAX.get(),0)) {
                    break;
                  }
                  //<< . . . . WRITE YCR,"<TD"
                  m$.Cmd.Write(m$.var("YCR").get(),"<TD");
                  //<< . . . . WRITE " BGCOLOR="_YDARKGRAY
                  m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YDARKGRAY").get()));
                  //<< . . . . WRITE " style="_""""
                  m$.Cmd.Write(mOp.Concat(" style=","\""));
                  //<< . . . . WRITE " text-align:left;"
                  m$.Cmd.Write(" text-align:left;");
                  //<< . . . . WRITE " vertical-align:middle;"
                  m$.Cmd.Write(" vertical-align:middle;");
                  //<< . . . . WRITE " font:"_FONTSIZE_"pt arial;"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" font:",m$.var("FONTSIZE").get()),"pt arial;"));
                  //<< . . . . ;WRITE " font-weight:bold;"
                  //<< . . . . IF YNUM=$PIECE(CHART1,Y,40) DO
                  if (mOp.Equal(YNUM.get(),m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),40))) {
                    //<< . . . . . ;NEW BGCOLOR
                    //<< . . . . . ;SET BGCOLOR=$PIECE($GET(^WWW012(0,YM,1)),Y,14)
                    //<< . . . . . ;IF BGCOLOR'="" SET BGCOLOR=$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,BGCOLOR,1)),Y,1)
                    //<< . . . . . ;IF BGCOLOR="" SET BGCOLOR="gray"
                    //<< . . . . . ;WRITE " background-color:"_BGCOLOR_";"
                    //<< . . . . . WRITE " font-weight:bold;"
                    m$.Cmd.Write(" font-weight:bold;");
                  }
                  //<< . . . . ;
                  //<< . . . . WRITE " border-top:1px solid "_COLORDARK_";"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-top:1px solid ",m$.var("COLORDARK").get()),";"));
                  //<< . . . . WRITE " border-bottom:1px solid "_COLORLIGHT_";"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-bottom:1px solid ",m$.var("COLORLIGHT").get()),";"));
                  //<< . . . . IF YA<YZA WRITE " border-right:1px solid "_COLORLIGHT_";"
                  if (mOp.Less(YA.get(),m$.var("YZA").get())) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-right:1px solid ",m$.var("COLORLIGHT").get()),";"));
                  }
                  //<< . . . . IF YA>1 WRITE " border-left:1px solid "_COLORDARK_";"
                  if (mOp.Greater(YA.get(),1)) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-left:1px solid ",m$.var("COLORDARK").get()),";"));
                  }
                  //<< . . . . WRITE " width:"_YZASIZE_";"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",YZASIZE.get()),";"));
                  //<< . . . . ;WRITE " height:"_(PIXEL-1)_";"
                  //<< . . . . WRITE " height:"_PIXEL_";"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" height:",m$.var("PIXEL").get()),";"));
                  //<< . . . . WRITE """"_">"
                  m$.Cmd.Write(mOp.Concat("\"",">"));
                  //<< . . . . WRITE "&nbsp;"
                  m$.Cmd.Write("&nbsp;");
                  //<< . . . . DO
                  do {
                    //<< . . . . . NEW HEADER
                    mVar HEADER = m$.var("HEADER");
                    m$.newVarBlock(5,HEADER);
                    //<< . . . . . SET HEADER=$PIECE(YFELD,Y,1)
                    HEADER.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),1));
                    //<< . . . . . IF $PIECE($GET(^WWW1221(0,CHART,YNUM,SPRACHE,1)),Y,1)'="" SET HEADER=$PIECE(^(1),Y,1)
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1221",0,m$.var("CHART").get(),YNUM.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
                      HEADER.set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
                    }
                    //<< . . . . . ;IF +$PIECE(YFELD,Y,1)'=0 IF $DATA(^WWW009(0,SPRACHE,+$PIECE(YFELD,Y,1))) SET HEADER=$$^WWWTEXT($PIECE($PIECE(YFELD,Y,1),";",1))
                    //<< . . . . . ;IF $EXTRACT($PIECE(YFELD,Y,1),1,3)="$$^" XECUTE "SET HEADER="_$PIECE($PIECE(YFELD,Y,1),";",1)
                    //<< . . . . . QUIT:HEADER=""
                    if (mOp.Equal(HEADER.get(),"")) {
                      break;
                    }
                    //<< . . . . . IF $PIECE(CHART1,Y,38)=1 IF $PIECE(YFELD,Y,12)=1 IF $GET(YPRINTMODE)'=1 DO  ;SORTIERFELD
                    if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),38),1)) {
                      if (mOp.Equal(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),12),1)) {
                        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YPRINTMODE")),1)) {
                          //<< . . . . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMANU1&amp;YEXEC=DO|CHART^WWWDRAGDROP('"_CHART_"','"_START_"','"_STOP_"')&amp;YFORM="_YFORM_"&amp;YAUSWAHL="_"*"_YNUM
                          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMANU1&amp;YEXEC=DO|CHART^WWWDRAGDROP('"),m$.var("CHART").get()),"','"),m$.var("START").get()),"','"),m$.var("STOP").get()),"')&amp;YFORM="),m$.var("YFORM").get()),"&amp;YAUSWAHL="),"*"),YNUM.get()));
                          //<< . . . . . . NEW YFORM,YKEY
                          mVar YFORM = m$.var("YFORM");
                          mVar YKEY = m$.var("YKEY");
                          m$.newVarBlock(6,YFORM,YKEY);
                          //<< . . . . . . DO ^WWWCGI
                          m$.Cmd.Do("WWWCGI.main");
                          //<< . . . . . . WRITE """"_">"
                          m$.Cmd.Write(mOp.Concat("\"",">"));
                        }
                        m$.restoreVarBlock(6);
                      }
                    }
                    //<< . . . . . ;
                    //<< . . . . . WRITE $$^WWWTRANSLATE(HEADER," ","&nbsp;")
                    m$.Cmd.Write(m$.fnc$("WWWTRANSLATE.main",HEADER.get()," ","&nbsp;"));
                    //<< . . . . . IF $PIECE(CHART1,Y,38)=1 IF $PIECE(YFELD,Y,12)=1 WRITE "</A>"
                    if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),38),1)) {
                      if (mOp.Equal(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),12),1)) {
                        m$.Cmd.Write("</A>");
                      }
                    }
                  } while(false);
                  m$.restoreVarBlock(5);
                  //<< . . . . ;
                  //<< . . . . WRITE YCR,"</TD>"
                  m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
                } while (false);
              }
              //<< . . . ;
              //<< . . . WRITE YCR,"</TR>"
              m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
              //<< . . . WRITE YCR,"</TABLE>"
              m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
            } while (false);
          }
          //<< . . ;
          //<< . . WRITE YCR,"</div>"
          m$.Cmd.Write(m$.var("YCR").get(),"</div>");
          //<< . . WRITE YCR,"</td>"
          m$.Cmd.Write(m$.var("YCR").get(),"</td>");
        }
        //<< . ;
        //<< . IF YI="MON" DO
        if (mOp.Equal(_YI,"MON")) {
          //<< . . SET COLUMNS   = 0
          mVar COLUMNS = m$.var("COLUMNS");
          COLUMNS.set(0);
          //<< . . SET DATE      = START
          DATE.set(m$.var("START").get());
          //<< . . SET MONAT     = ""
          MONAT.set("");
          //<< . . SET MONTHDAYS = 30
          MONTHDAYS.set(30);
          //<< . . FOR  QUIT:DATE>STOP  DO  SET DATE=DATE+MONTHDAYS
          for (;true;) {
            if (mOp.Greater(DATE.get(),m$.var("STOP").get())) {
              break;
            }
            do {
              //<< . . . IF $$^WWWMONTH(DATE)'=MONAT DO
              if (mOp.NotEqual(m$.fnc$("WWWMONTH.main",DATE.get()),MONAT.get())) {
                do {
                  //<< . . . . SET MONAT = $$^WWWMONTH(DATE)
                  MONAT.set(m$.fnc$("WWWMONTH.main",DATE.get()));
                  //<< . . . . SET JAHR  = $$^WWWYEAR(DATE)
                  JAHR.set(m$.fnc$("WWWYEAR.main",DATE.get()));
                  //<< . . . . IF $$^WWWMONTH(STOP)=$$^WWWMONTH(START) IF $$^WWWYEAR(STOP)=$$^WWWYEAR(START) SET MONTHDAYS=(STOP-START+1) QUIT
                  if (mOp.Equal(m$.fnc$("WWWMONTH.main",m$.var("STOP").get()),m$.fnc$("WWWMONTH.main",m$.var("START").get()))) {
                    if (mOp.Equal(m$.fnc$("WWWYEAR.main",m$.var("STOP").get()),m$.fnc$("WWWYEAR.main",m$.var("START").get()))) {
                      MONTHDAYS.set((mOp.Add(mOp.Subtract(m$.var("STOP").get(),m$.var("START").get()),1)));
                      break;
                    }
                  }
                  //<< . . . . IF $$^WWWMONTH(STOP)=MONAT              IF $$^WWWYEAR(STOP)=JAHR              SET MONTHDAYS=(STOP-$$DMY^WWWDATE1("01."_MONAT_"."_JAHR)+1) QUIT   ; SR17146
                  if (mOp.Equal(m$.fnc$("WWWMONTH.main",m$.var("STOP").get()),MONAT.get())) {
                    if (mOp.Equal(m$.fnc$("WWWYEAR.main",m$.var("STOP").get()),JAHR.get())) {
                      MONTHDAYS.set((mOp.Add(mOp.Subtract(m$.var("STOP").get(),m$.fnc$("WWWDATE1.DMY",mOp.Concat(mOp.Concat(mOp.Concat("01.",MONAT.get()),"."),JAHR.get()))),1)));
                      break;
                    }
                  }
                  //<< . . . . SET MONTHDAYS=$$^WWWMONTHDAYS(DATE)-(DATE-$$DMY^WWWDATE1("01."_MONAT_"."_JAHR))   ; SR17146
                  MONTHDAYS.set(mOp.Subtract(m$.fnc$("WWWMONTHDAYS.main",DATE.get()),(mOp.Subtract(DATE.get(),m$.fnc$("WWWDATE1.DMY",mOp.Concat(mOp.Concat(mOp.Concat("01.",MONAT.get()),"."),JAHR.get()))))));
                } while (false);
              }
              //<< . . . ;
              //<< . . . SET MAXDAYS=MONTHDAYS
              MAXDAYS.set(MONTHDAYS.get());
              //<< . . . IF $PIECE(CHART1,Y,37)=1 DO
              if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),37),1)) {
                //<< . . . . FOR YI=0:1:MONTHDAYS-1  IF $DATA(^WWWSOR(YUSER,"FEIERTAG",(DATE+YI))) SET MAXDAYS=MAXDAYS-1
                for (YI.set(0);(mOp.LessOrEqual(YI.get(),mOp.Subtract(MONTHDAYS.get(),1)));YI.set(mOp.Add(YI.get(),1))) {
                  if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),"FEIERTAG",(mOp.Add(DATE.get(),_YI)))))) {
                    MAXDAYS.set(mOp.Subtract(MAXDAYS.get(),1));
                  }
                }
              }
              //<< . . . ;
              //<< . . . IF MAXDAYS<1 QUIT  ;KEIN TAG MEHR ZUM ANZEIGEN ;no TAG more display
              if (mOp.Less(MAXDAYS.get(),1)) {
                break;
              }
              //<< . . . WRITE YCR,"<td align=middle valign=middle"
              m$.Cmd.Write(m$.var("YCR").get(),"<td align=middle valign=middle");
              //<< . . . WRITE " BGCOLOR="_YDARKGRAY
              m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YDARKGRAY").get()));
              //<< . . . WRITE " COLSPAN="_(MAXDAYS*TIMESIZE)
              m$.Cmd.Write(mOp.Concat(" COLSPAN=",(mOp.Multiply(MAXDAYS.get(),TIMESIZE.get()))));
              //<< . . . WRITE ">"
              m$.Cmd.Write(">");
              //<< . . . WRITE YCR,"<div valign=middle"
              m$.Cmd.Write(m$.var("YCR").get(),"<div valign=middle");
              //<< . . . WRITE " style="_""""_" height:"_PIXEL_"px;"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" style=","\"")," height:"),m$.var("PIXEL").get()),"px;"));
              //<< . . . WRITE " width:"_(PIXEL*MAXDAYS*TIMESIZE)_"px; text-align:middle;"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",(mOp.Multiply(mOp.Multiply(m$.var("PIXEL").get(),MAXDAYS.get()),TIMESIZE.get()))),"px; text-align:middle;"));
              //<< . . . WRITE " border:1px solid;"
              m$.Cmd.Write(" border:1px solid;");
              //<< . . . WRITE " border-Bottom-Color:"_COLORLIGHT_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Bottom-Color:",m$.var("COLORLIGHT").get()),";"));
              //<< . . . WRITE " border-Right-Color:"_COLORLIGHT_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Right-Color:",m$.var("COLORLIGHT").get()),";"));
              //<< . . . WRITE " border-Top-Color:"_COLORDARK_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Top-Color:",m$.var("COLORDARK").get()),";"));
              //<< . . . WRITE " border-Left-Color:"_COLORDARK_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Left-Color:",m$.var("COLORDARK").get()),";"));
              //<< . . . WRITE " font:"_FONTSIZE_"pt arial;"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" font:",m$.var("FONTSIZE").get()),"pt arial;"));
              //<< . . . WRITE " overflow:hidden;"
              m$.Cmd.Write(" overflow:hidden;");
              //<< . . . WRITE """"_">"
              m$.Cmd.Write(mOp.Concat("\"",">"));
              //<< . . . IF (MAXDAYS*TIMESIZE*PIXEL)>50 DO
              if (mOp.Greater((mOp.Multiply(mOp.Multiply(MAXDAYS.get(),TIMESIZE.get()),m$.var("PIXEL").get())),50)) {
                //<< . . . . WRITE YCR,$PIECE($$^WWWTEXT(30023),",",MONAT)
                m$.Cmd.Write(m$.var("YCR").get(),m$.Fnc.$piece(m$.fnc$("WWWTEXT.main",30023),",",MONAT.get()));
                //<< . . . . WRITE " "_JAHR
                m$.Cmd.Write(mOp.Concat(" ",JAHR.get()));
              }
              //<< . . . ;
              //<< . . . WRITE YCR,"</div>"
              m$.Cmd.Write(m$.var("YCR").get(),"</div>");
              //<< . . . WRITE YCR,"</td>"
              m$.Cmd.Write(m$.var("YCR").get(),"</td>");
              //<< . . . SET COLUMNS=COLUMNS+(MAXDAYS*TIMESIZE)
              COLUMNS.set(mOp.Add(COLUMNS.get(),(mOp.Multiply(MAXDAYS.get(),TIMESIZE.get()))));
            } while (false);
            DATE.set(mOp.Add(DATE.get(),MONTHDAYS.get()));
          }
        }
        //<< . ;
        //<< . IF YI="WEK" DO
        if (mOp.Equal(_YI,"WEK")) {
          //<< . . SET DATE=START
          DATE.set(m$.var("START").get());
          //<< . . SET WEEK=""
          WEEK.set("");
          //<< . . SET COLUMNS=0
          mVar COLUMNS = m$.var("COLUMNS");
          COLUMNS.set(0);
          //<< . . FOR  QUIT:DATE>STOP  DO  SET DATE=DATE+WEEKDAYS
          for (;true;) {
            if (mOp.Greater(DATE.get(),m$.var("STOP").get())) {
              break;
            }
            do {
              //<< . . . DO
              do {
                //<< . . . . ;IF WEEK'="" SET WEEKDAYS=7 IF (DATE+WEEKDAYS)<STOP QUIT
                //<< . . . . SET WEEK=$$^WWWWEEK(DATE,4)
                WEEK.set(m$.fnc$("WWWWEEK.main",DATE.get(),4));
                //<< . . . . SET DATE1=DATE
                DATE1.set(DATE.get());
                //<< . . . . SET WEEKDAYS=0
                WEEKDAYS.set(0);
                //<< . . . . FOR  QUIT:$$^WWWWEEK(DATE1,4)'=WEEK  QUIT:DATE1>STOP  SET WEEKDAYS=WEEKDAYS+1 SET DATE1=DATE1+1
                for (;true;) {
                  if (mOp.NotEqual(m$.fnc$("WWWWEEK.main",DATE1.get(),4),WEEK.get())) {
                    break;
                  }
                  if (mOp.Greater(DATE1.get(),m$.var("STOP").get())) {
                    break;
                  }
                  WEEKDAYS.set(mOp.Add(WEEKDAYS.get(),1));
                  DATE1.set(mOp.Add(DATE1.get(),1));
                }
              } while(false);
              //<< . . . ;
              //<< . . . SET MAXDAYS=WEEKDAYS
              MAXDAYS.set(WEEKDAYS.get());
              //<< . . . IF $PIECE(CHART1,Y,37)=1 DO
              if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),37),1)) {
                //<< . . . . FOR YI=0:1:WEEKDAYS-1  IF $DATA(^WWWSOR(YUSER,"FEIERTAG",(DATE+YI))) SET MAXDAYS=MAXDAYS-1
                for (YI.set(0);(mOp.LessOrEqual(YI.get(),mOp.Subtract(WEEKDAYS.get(),1)));YI.set(mOp.Add(YI.get(),1))) {
                  if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),"FEIERTAG",(mOp.Add(DATE.get(),_YI)))))) {
                    MAXDAYS.set(mOp.Subtract(MAXDAYS.get(),1));
                  }
                }
              }
              //<< . . . ;
              //<< . . . IF MAXDAYS<1 QUIT  ;KEIN TAG MEHR ZUM ANZEIGEN ;no TAG more display
              if (mOp.Less(MAXDAYS.get(),1)) {
                break;
              }
              //<< . . . WRITE YCR,"<td align=middle valign=middle"
              m$.Cmd.Write(m$.var("YCR").get(),"<td align=middle valign=middle");
              //<< . . . WRITE " BGCOLOR="_YGRAY
              m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
              //<< . . . WRITE " COLSPAN="_(MAXDAYS*TIMESIZE)
              m$.Cmd.Write(mOp.Concat(" COLSPAN=",(mOp.Multiply(MAXDAYS.get(),TIMESIZE.get()))));
              //<< . . . WRITE ">"
              m$.Cmd.Write(">");
              //<< . . . WRITE YCR,"<div valign=middle"
              m$.Cmd.Write(m$.var("YCR").get(),"<div valign=middle");
              //<< . . . WRITE " style="_""""_" height:"_PIXEL_"px;"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" style=","\"")," height:"),m$.var("PIXEL").get()),"px;"));
              //<< . . . WRITE " width:"_(PIXEL*MAXDAYS*TIMESIZE)_"px; text-align:middle;"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",(mOp.Multiply(mOp.Multiply(m$.var("PIXEL").get(),MAXDAYS.get()),TIMESIZE.get()))),"px; text-align:middle;"));
              //<< . . . WRITE " border:1px solid;"
              m$.Cmd.Write(" border:1px solid;");
              //<< . . . WRITE " border-Bottom-Color:"_COLORLIGHT_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Bottom-Color:",m$.var("COLORLIGHT").get()),";"));
              //<< . . . WRITE " border-Right-Color:"_COLORLIGHT_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Right-Color:",m$.var("COLORLIGHT").get()),";"));
              //<< . . . WRITE " border-Top-Color:"_COLORDARK_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Top-Color:",m$.var("COLORDARK").get()),";"));
              //<< . . . WRITE " border-Left-Color:"_COLORDARK_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Left-Color:",m$.var("COLORDARK").get()),";"));
              //<< . . . WRITE " overflow:hidden;"
              m$.Cmd.Write(" overflow:hidden;");
              //<< . . . WRITE " font:"_FONTSIZE_"pt arial;"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" font:",m$.var("FONTSIZE").get()),"pt arial;"));
              //<< . . . WRITE """"_">"
              m$.Cmd.Write(mOp.Concat("\"",">"));
              //<< . . . IF (MAXDAYS*TIMESIZE)>2 WRITE YCR,$$^WWWTEXT(385)_" "  ;KW ;week
              if (mOp.Greater((mOp.Multiply(MAXDAYS.get(),TIMESIZE.get())),2)) {
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(m$.fnc$("WWWTEXT.main",385)," "));
              }
              //<< . . . WRITE YCR,$$^WWWWEEK(DATE,4)
              m$.Cmd.Write(m$.var("YCR").get(),m$.fnc$("WWWWEEK.main",DATE.get(),4));
              //<< . . . WRITE YCR,"</div>"
              m$.Cmd.Write(m$.var("YCR").get(),"</div>");
              //<< . . . WRITE YCR,"</td>"
              m$.Cmd.Write(m$.var("YCR").get(),"</td>");
              //<< . . . SET COLUMNS=COLUMNS+(MAXDAYS*TIMESIZE)
              COLUMNS.set(mOp.Add(COLUMNS.get(),(mOp.Multiply(MAXDAYS.get(),TIMESIZE.get()))));
            } while (false);
            DATE.set(mOp.Add(DATE.get(),WEEKDAYS.get()));
          }
        }
        //<< . ;
        //<< . IF YI="DAY" DO  ;DAY SCALE
        if (mOp.Equal(_YI,"DAY")) {
          //<< . . SET DATE=START
          DATE.set(m$.var("START").get());
          //<< . . SET COLUMNS=0
          mVar COLUMNS = m$.var("COLUMNS");
          COLUMNS.set(0);
          //<< . . FOR  QUIT:DATE>STOP  DO  SET DATE=DATE+1
          for (;true;) {
            if (mOp.Greater(DATE.get(),m$.var("STOP").get())) {
              break;
            }
            do {
              //<< . . . IF $PIECE(CHART1,Y,37)=1 IF $DATA(^WWWSOR(YUSER,"FEIERTAG",DATE)) QUIT
              if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),37),1)) {
                if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),"FEIERTAG",DATE.get())))) {
                  break;
                }
              }
              //<< . . . WRITE YCR,"<td align=middle valign=middle"
              m$.Cmd.Write(m$.var("YCR").get(),"<td align=middle valign=middle");
              //<< . . . DO
              do {
                //<< . . . . IF $PIECE(CHART1,Y,37)'=1 IF $$^WWWCALDAY(DATE,CAL)'=0 WRITE " BGCOLOR="_"MISTYROSE" QUIT
                if (mOp.NotEqual(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),37),1)) {
                  if (mOp.NotEqual(m$.fnc$("WWWCALDAY.main",DATE.get(),m$.var("CAL").get()),0)) {
                    m$.Cmd.Write(mOp.Concat(" BGCOLOR=","MISTYROSE"));
                    break;
                  }
                }
                //<< . . . . WRITE " BGCOLOR="_YWHITE
                m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
              } while(false);
              //<< . . . ;
              //<< . . . IF TIMESIZE>1 WRITE " COLSPAN="_TIMESIZE
              if (mOp.Greater(TIMESIZE.get(),1)) {
                m$.Cmd.Write(mOp.Concat(" COLSPAN=",TIMESIZE.get()));
              }
              //<< . . . WRITE ">"
              m$.Cmd.Write(">");
              //<< . . . WRITE YCR,"<div valign=middle"
              m$.Cmd.Write(m$.var("YCR").get(),"<div valign=middle");
              //<< . . . WRITE " style="_""""_" height:"_PIXEL_"px;"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" style=","\"")," height:"),m$.var("PIXEL").get()),"px;"));
              //<< . . . WRITE " width:"_(PIXEL*TIMESIZE)_"px; text-align:middle;"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",(mOp.Multiply(m$.var("PIXEL").get(),TIMESIZE.get()))),"px; text-align:middle;"));
              //<< . . . WRITE " border:1px solid;"
              m$.Cmd.Write(" border:1px solid;");
              //<< . . . WRITE " border-Bottom-Color:"_COLORLIGHT_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Bottom-Color:",m$.var("COLORLIGHT").get()),";"));
              //<< . . . WRITE " border-Right-Color:"_COLORLIGHT_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Right-Color:",m$.var("COLORLIGHT").get()),";"));
              //<< . . . WRITE " border-Top-Color:"_COLORDARK_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Top-Color:",m$.var("COLORDARK").get()),";"));
              //<< . . . WRITE " border-Left-Color:"_COLORDARK_";"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Left-Color:",m$.var("COLORDARK").get()),";"));
              //<< . . . WRITE " overflow:hidden;"
              m$.Cmd.Write(" overflow:hidden;");
              //<< . . . WRITE " font:"_FONTSIZE_"pt arial;"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" font:",m$.var("FONTSIZE").get()),"pt arial;"));
              //<< . . . WRITE """"_">"
              m$.Cmd.Write(mOp.Concat("\"",">"));
              //<< . . . IF TIMESIZE'>5 WRITE YCR,$PIECE($$^WWWDATE(DATE,"DE"),".",1)
              if (mOp.NotGreater(TIMESIZE.get(),5)) {
                m$.Cmd.Write(m$.var("YCR").get(),m$.Fnc.$piece(m$.fnc$("WWWDATE.main",DATE.get(),"DE"),".",1));
              }
              //<< . . . ;IF TIMESIZE>5 WRITE YCR,$PIECE($$^WWWTEXT(30022),",",$$^WWWDAY(DATE))_", "_$PIECE($$^WWWDATE(DATE,"DE"),".",1)_"."   ;24873;05.01.03;SHOW DATE WITH DATEFUNCTION
              //<< . . . IF TIMESIZE>5 WRITE YCR,$$^WWWDATEFULL(DATE,1)
              if (mOp.Greater(TIMESIZE.get(),5)) {
                m$.Cmd.Write(m$.var("YCR").get(),m$.fnc$("WWWDATEFULL.main",DATE.get(),1));
              }
              //<< . . . WRITE YCR,"</div>"
              m$.Cmd.Write(m$.var("YCR").get(),"</div>");
              //<< . . . WRITE YCR,"</td>"
              m$.Cmd.Write(m$.var("YCR").get(),"</td>");
              //<< . . . SET COLUMNS=COLUMNS+1
              COLUMNS.set(mOp.Add(COLUMNS.get(),1));
            } while (false);
            DATE.set(mOp.Add(DATE.get(),1));
          }
        }
        //<< . ;
        //<< . IF YI="UHR" DO  ;TIME SCALE
        if (mOp.Equal(_YI,"UHR")) {
          //<< . . SET DATE=START
          DATE.set(m$.var("START").get());
          //<< . . SET COLUMNS=0
          mVar COLUMNS = m$.var("COLUMNS");
          COLUMNS.set(0);
          //<< . . FOR  QUIT:DATE>STOP  DO  SET DATE=DATE+1
          for (;true;) {
            if (mOp.Greater(DATE.get(),m$.var("STOP").get())) {
              break;
            }
            do {
              //<< . . . IF $PIECE(CHART1,Y,37)=1 IF $DATA(^WWWSOR(YUSER,"FEIERTAG",DATE)) QUIT
              if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),37),1)) {
                if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),"FEIERTAG",DATE.get())))) {
                  break;
                }
              }
              //<< . . . FOR TIME=1:1:TIMESIZE DO
              for (TIME.set(1);(mOp.LessOrEqual(TIME.get(),TIMESIZE.get()));TIME.set(mOp.Add(TIME.get(),1))) {
                //<< . . . . WRITE YCR,"<td align=middle valign=middle"
                m$.Cmd.Write(m$.var("YCR").get(),"<td align=middle valign=middle");
                //<< . . . . WRITE " BGCOLOR="_"LIGHTGOLDENRODYELLOW"
                m$.Cmd.Write(mOp.Concat(" BGCOLOR=","LIGHTGOLDENRODYELLOW"));
                //<< . . . . WRITE ">"
                m$.Cmd.Write(">");
                //<< . . . . WRITE YCR,"<div valign=middle"
                m$.Cmd.Write(m$.var("YCR").get(),"<div valign=middle");
                //<< . . . . WRITE " style="_""""_" height:"_PIXEL_"px;"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" style=","\"")," height:"),m$.var("PIXEL").get()),"px;"));
                //<< . . . . WRITE " width:"_PIXEL_"px; text-align:middle;"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",m$.var("PIXEL").get()),"px; text-align:middle;"));
                //<< . . . . WRITE " border:1px solid;"
                m$.Cmd.Write(" border:1px solid;");
                //<< . . . . WRITE " border-Bottom-Color:"_COLORLIGHT_";"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Bottom-Color:",m$.var("COLORLIGHT").get()),";"));
                //<< . . . . WRITE " border-Right-Color:"_COLORLIGHT_";"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Right-Color:",m$.var("COLORLIGHT").get()),";"));
                //<< . . . . WRITE " border-Top-Color:"_COLORDARK_";"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Top-Color:",m$.var("COLORDARK").get()),";"));
                //<< . . . . WRITE " border-Left-Color:"_COLORDARK_";"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-Left-Color:",m$.var("COLORDARK").get()),";"));
                //<< . . . . WRITE " overflow:hidden;"
                m$.Cmd.Write(" overflow:hidden;");
                //<< . . . . WRITE " font:"_FONTSIZE_"pt arial;"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" font:",m$.var("FONTSIZE").get()),"pt arial;"));
                //<< . . . . WRITE """"_">"
                m$.Cmd.Write(mOp.Concat("\"",">"));
                //<< . . . . WRITE YCR,(TIME+$$^WWWTIME(ARBBEGINN)-1)
                m$.Cmd.Write(m$.var("YCR").get(),(mOp.Subtract(mOp.Add(TIME.get(),m$.fnc$("WWWTIME.main",m$.var("ARBBEGINN").get())),1)));
                //<< . . . . WRITE YCR,"</div>"
                m$.Cmd.Write(m$.var("YCR").get(),"</div>");
                //<< . . . . WRITE YCR,"</td>"
                m$.Cmd.Write(m$.var("YCR").get(),"</td>");
                //<< . . . . SET COLUMNS=COLUMNS+1
                COLUMNS.set(mOp.Add(COLUMNS.get(),1));
              }
            } while (false);
            DATE.set(mOp.Add(DATE.get(),1));
          }
        }
        //<< . ;
        //<< . WRITE YCR,"</tr>"
        m$.Cmd.Write(m$.var("YCR").get(),"</tr>");
      } while (false);
    }
    //<< 
    //<< SET COLUMNS=COLUMNS+HEADLAENG
    mVar COLUMNS = m$.var("COLUMNS");
    COLUMNS.set(mOp.Add(m$.var("COLUMNS").get(),m$.var("HEADLAENG").get()));
    //<< QUIT
    return;
  }

  //<< 
  //<< GRID    ;AUFBAU TABELLEN-RASTER
  public void GRID() {
    //<< NEW YDDROW,YDDCOL,SORT,NEXTSORT,KEY,YI,LASTSORT,YLIN,SORT2
    mVar YDDROW = m$.var("YDDROW");
    mVar YDDCOL = m$.var("YDDCOL");
    mVar SORT = m$.var("SORT");
    mVar NEXTSORT = m$.var("NEXTSORT");
    mVar KEY = m$.var("KEY");
    mVar YI = m$.var("YI");
    mVar LASTSORT = m$.var("LASTSORT");
    mVar YLIN = m$.var("YLIN");
    mVar SORT2 = m$.var("SORT2");
    m$.newVar(YDDROW,YDDCOL,SORT,NEXTSORT,KEY,YI,LASTSORT,YLIN,SORT2);
    //<< 
    //<< SET (YDDROW,YDDCOL)=0
    YDDROW.set(0);
    YDDCOL.set(0);
    //<< SET YI(1)=0
    YI.var(1).set(0);
    //<< SET LASTSORT=""
    LASTSORT.set("");
    //<< SET RICHT=1
    mVar RICHT = m$.var("RICHT");
    RICHT.set(1);
    //<< SET ZNR=0
    mVar ZNR = m$.var("ZNR");
    ZNR.set(0);
    //<< IF $PIECE(CHART1,Y,40)'="" IF $PIECE($GET(^WWWDRAGDROPD(0,CHART,$PIECE(CHART1,Y,40),1)),Y,22)=1 SET RICHT=-1
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),40),"")) {
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDRAGDROPD",0,m$.var("CHART").get(),m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),40),1)),m$.var("Y").get(),22),1)) {
        RICHT.set(mOp.Negative(1));
      }
    }
    //<< SET SORT2=""
    SORT2.set("");
    //<< FOR  SET SORT2=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT2),RICHT) QUIT:SORT2=""  DO
    for (;true;) {
      SORT2.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs",SORT2.get()),RICHT.get()));
      if (mOp.Equal(SORT2.get(),"")) {
        break;
      }
      //<< . SET SORT=""
      SORT.set("");
      //<< . FOR  SET SORT=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT2,SORT),RICHT) QUIT:SORT=""  DO
      for (;true;) {
        SORT.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs",SORT2.get(),SORT.get()),RICHT.get()));
        if (mOp.Equal(SORT.get(),"")) {
          break;
        }
        //<< . . SET KEY=""
        KEY.set("");
        //<< . . FOR  SET KEY=$ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT2,SORT,KEY)) QUIT:KEY=""  DO
        for (;true;) {
          KEY.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs",SORT2.get(),SORT.get(),KEY.get())));
          if (mOp.Equal(KEY.get(),"")) {
            break;
          }
          do {
            //<< . . . SET ZNR=ZNR+1
            ZNR.set(mOp.Add(ZNR.get(),1));
            //<< . . . IF ZNSTART>ZNR QUIT
            if (mOp.Greater(m$.var("ZNSTART").get(),ZNR.get())) {
              break;
            }
            //<< . . . IF ZNSTOP<ZNR  QUIT
            if (mOp.Less(m$.var("ZNSTOP").get(),ZNR.get())) {
              break;
            }
            //<< . . . ;
            //<< . . . SET YI(1)=YI(1)+1
            YI.var(1).set(mOp.Add(YI.var(1).get(),1));
            //<< . . . SET YI(3)=0  ;INNERHALB EINER GRUPPE ;inside unit group
            YI.var(3).set(0);
            //<< . . . IF $ORDER(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs",SORT2,SORT,KEY))="" SET YI(3)=1  ;DANACH FOLGT NEUE GRUPPE ;thereafter group
            if (mOp.Equal(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs",SORT2.get(),SORT.get(),KEY.get())),"")) {
              YI.var(3).set(1);
            }
            //<< . . . IF YI(1)=ROWS SET YI(3)=0  ;LETZTE ZEILE ;last
            if (mOp.Equal(YI.var(1).get(),m$.var("ROWS").get())) {
              YI.var(3).set(0);
            }
            //<< . . . ;
            //<< . . . IF LINEAL=1 IF LASTSORT=""!(LASTSORT'=SORT) SET ^WWWSOR(YUSER,"LINEAL","ZEILE",(YI(1)-1),1)=""  ;LINEALANFANG
            if (mOp.Equal(m$.var("LINEAL").get(),1)) {
              if (mOp.Or(mOp.Equal(LASTSORT.get(),""),(mOp.NotEqual(LASTSORT.get(),SORT.get())))) {
                m$.var("^WWWSOR",m$.var("YUSER").get(),"LINEAL","ZEILE",(mOp.Subtract(YI.var(1).get(),1)),1).set("");
              }
            }
            //<< . . . SET LASTSORT=SORT
            LASTSORT.set(SORT.get());
            //<< . . . ;
            //<< . . . WRITE YCR,"<tr id="_""""_"row"_YI(1)_""""
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<tr id=","\""),"row"),YI.var(1).get()),"\""));
            //<< . . . WRITE ">"
            m$.Cmd.Write(">");
            //<< . . . SET YDDROW=YDDROW+1
            YDDROW.set(mOp.Add(YDDROW.get(),1));
            //<< . . . FOR YI(2)=1:1:COLUMNS DO
            for (m$.var("YI",2).set(1);(mOp.LessOrEqual(m$.var("YI",2).get(),m$.var("COLUMNS").get()));m$.var("YI",2).set(mOp.Add(m$.var("YI",2).get(),1))) {
              //<< . . . . WRITE YCR,"<td id="_""""_"col"_YI(1)_"-"_YI(2)_""""_" align=middle valign=middle"
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<td id=","\""),"col"),YI.var(1).get()),"-"),YI.var(2).get()),"\"")," align=middle valign=middle"));
              //<< . . . . IF YDDROW#2=1 WRITE " BGCOLOR="_YWHITE
              if (mOp.Equal(mOp.Modulus(YDDROW.get(),2),1)) {
                m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
              }
              //<< . . . . IF YDDROW#2=0 WRITE " BGCOLOR="_YGRAY
              if (mOp.Equal(mOp.Modulus(YDDROW.get(),2),0)) {
                m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
              }
              //<< . . . . WRITE ">"
              m$.Cmd.Write(">");
              //<< . . . . WRITE YCR,"<div id="_""""_"elem"_YI(1)_"-"_YI(2)_""""_" align=middle valign=middle"
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<div id=","\""),"elem"),YI.var(1).get()),"-"),YI.var(2).get()),"\"")," align=middle valign=middle"));
              //<< . . . . WRITE " style="_""""_"width:"_PIXEL_"px; height:"_PIXEL_"px;"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" style=","\""),"width:"),m$.var("PIXEL").get()),"px; height:"),m$.var("PIXEL").get()),"px;"));
              //<< . . . . IF YI(2)=1              WRITE " border-left:1px solid "_COLORDARK_";"
              if (mOp.Equal(YI.var(2).get(),1)) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-left:1px solid ",m$.var("COLORDARK").get()),";"));
              }
              //<< . . . . IF YI(2)=HEADLAENG      WRITE " border-right:1px solid "_COLORLIGHT_";"
              if (mOp.Equal(YI.var(2).get(),m$.var("HEADLAENG").get())) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-right:1px solid ",m$.var("COLORLIGHT").get()),";"));
              }
              //<< . . . . IF YI(2)>HEADLAENG      WRITE " border-right:1px dotted "_YDARKGRAY_";"
              if (mOp.Greater(YI.var(2).get(),m$.var("HEADLAENG").get())) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-right:1px dotted ",m$.var("YDARKGRAY").get()),";"));
              }
              //<< . . . . IF YI(2)=COLUMNS        WRITE " border-right:1px solid "_COLORLIGHT_";"
              if (mOp.Equal(YI.var(2).get(),m$.var("COLUMNS").get())) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-right:1px solid ",m$.var("COLORLIGHT").get()),";"));
              }
              //<< . . . . IF $PIECE(CHART1,Y,7)=1 WRITE " border-top:1px solid "_COLORDARK_";"
              if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),7),1)) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-top:1px solid ",m$.var("COLORDARK").get()),";"));
              }
              //<< . . . . IF $PIECE(CHART1,Y,39)'=1 IF $PIECE(CHART1,Y,7)=1             WRITE " border-bottom:1px solid "_COLORLIGHT_";"
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),39),1)) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),7),1)) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-bottom:1px solid ",m$.var("COLORLIGHT").get()),";"));
                }
              }
              //<< . . . . IF $PIECE(CHART1,Y,39)=1  IF $PIECE(CHART1,Y,7)=1 IF YI(3)'=1 WRITE " border-bottom:1px solid "_COLORLIGHT_";"
              if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),39),1)) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),7),1)) {
                  if (mOp.NotEqual(YI.var(3).get(),1)) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-bottom:1px solid ",m$.var("COLORLIGHT").get()),";"));
                  }
                }
              }
              //<< . . . . IF $PIECE(CHART1,Y,39)=1                          IF YI(3)=1  WRITE " border-bottom:2px solid black;"
              if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),39),1)) {
                if (mOp.Equal(YI.var(3).get(),1)) {
                  m$.Cmd.Write(" border-bottom:2px solid black;");
                }
              }
              //<< . . . . WRITE """"_">"
              m$.Cmd.Write(mOp.Concat("\"",">"));
              //<< . . . . WRITE YCR,"<FONT SIZE=1></FONT>"  ;ZEILE NICHT LÖSCHEN ! ;Not Delete
              m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=1></FONT>");
              //<< . . . . WRITE YCR,"</div>"
              m$.Cmd.Write(m$.var("YCR").get(),"</div>");
              //<< . . . . WRITE YCR,"</td>"
              m$.Cmd.Write(m$.var("YCR").get(),"</td>");
            }
            //<< . . . ;
            //<< . . . WRITE YCR,"</tr>"
            m$.Cmd.Write(m$.var("YCR").get(),"</tr>");
          } while (false);
        }
      }
    }
    //<< 
    //<< IF '$DATA(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","DATENs")) DO  ;KEINE ANZEIGE = LEERZEILE ;no Show blank line
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","DATENs")))) {
      //<< . SET HEADSIZE=HEADSIZE+1
      mVar HEADSIZE = m$.var("HEADSIZE");
      HEADSIZE.set(mOp.Add(m$.var("HEADSIZE").get(),1));
      //<< . WRITE YCR,"<tr id="_""""_"row"_0_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<tr id=","\""),"row"),0),"\""));
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . FOR YI(2)=1:1:COLUMNS DO
      for (m$.var("YI",2).set(1);(mOp.LessOrEqual(m$.var("YI",2).get(),m$.var("COLUMNS").get()));m$.var("YI",2).set(mOp.Add(m$.var("YI",2).get(),1))) {
        //<< . . WRITE YCR,"<td id="_""""_"col"_0_"-"_0_""""_" align=LEFT NOWRAP"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<td id=","\""),"col"),0),"-"),0),"\"")," align=LEFT NOWRAP"));
        //<< . . ;WRITE " BGCOLOR="_YWHITE
        //<< . . WRITE " BGCOLOR="_YGRAY
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
        //<< . . WRITE ">"
        m$.Cmd.Write(">");
        //<< . . WRITE YCR,"<div id="_""""_"elem"_0_"-"_0_""""_" align=middle valign=middle"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<div id=","\""),"elem"),0),"-"),0),"\"")," align=middle valign=middle"));
        //<< . . WRITE " style="_""""_"width:"_PIXEL_"px; height:"_PIXEL_"px;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" style=","\""),"width:"),m$.var("PIXEL").get()),"px; height:"),m$.var("PIXEL").get()),"px;"));
        //<< . . IF YI(2)=1              WRITE " border-left:1px solid "_COLORDARK_";"
        if (mOp.Equal(YI.var(2).get(),1)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-left:1px solid ",m$.var("COLORDARK").get()),";"));
        }
        //<< . . IF YI(2)=HEADLAENG      WRITE " border-right:1px solid "_COLORLIGHT_";"
        if (mOp.Equal(YI.var(2).get(),m$.var("HEADLAENG").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-right:1px solid ",m$.var("COLORLIGHT").get()),";"));
        }
        //<< . . IF YI(2)>HEADLAENG      WRITE " border-right:1px dotted "_YDARKGRAY_";"
        if (mOp.Greater(YI.var(2).get(),m$.var("HEADLAENG").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-right:1px dotted ",m$.var("YDARKGRAY").get()),";"));
        }
        //<< . . IF YI(2)=COLUMNS        WRITE " border-right:1px solid "_COLORLIGHT_";"
        if (mOp.Equal(YI.var(2).get(),m$.var("COLUMNS").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-right:1px solid ",m$.var("COLORLIGHT").get()),";"));
        }
        //<< . . IF $PIECE(CHART1,Y,7)=1 WRITE " border-top:1px solid "_COLORDARK_";"
        if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),7),1)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-top:1px solid ",m$.var("COLORDARK").get()),";"));
        }
        //<< . . IF $PIECE(CHART1,Y,39)'=1 IF $PIECE(CHART1,Y,7)=1 WRITE " border-bottom:1px solid "_COLORLIGHT_";"
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),39),1)) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),7),1)) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-bottom:1px solid ",m$.var("COLORLIGHT").get()),";"));
          }
        }
        //<< . . IF $PIECE(CHART1,Y,39)=1  IF $PIECE(CHART1,Y,7)=1 WRITE " border-bottom:1px solid "_COLORLIGHT_";"
        if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),39),1)) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("CHART1").get(),m$.var("Y").get(),7),1)) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-bottom:1px solid ",m$.var("COLORLIGHT").get()),";"));
          }
        }
        //<< . . WRITE """"_">"
        m$.Cmd.Write(mOp.Concat("\"",">"));
        //<< . . WRITE YCR,"<FONT SIZE=1>"
        m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=1>");
        //<< . . ;IF YI(2)=1 WRITE $$^WWWTEXT(46)
        //<< . . WRITE "</FONT>"
        m$.Cmd.Write("</FONT>");
        //<< . . WRITE YCR,"</div>"
        m$.Cmd.Write(m$.var("YCR").get(),"</div>");
        //<< . . WRITE YCR,"</td>"
        m$.Cmd.Write(m$.var("YCR").get(),"</td>");
      }
      //<< . ;
      //<< . WRITE YCR,"</tr>"
      m$.Cmd.Write(m$.var("YCR").get(),"</tr>");
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< HISTOGRAMM  ;SUMMEN HISTOGRAMM ;purr
  public void HISTOGRAMM() {
    //<< NEW YI,YII,YDDCOL,YDDROW,WEEK,MONAT,JAHR,MONTHDAYS,WEEKDAYS,DATE1,DATE,TIME,BEGINN,ENDE,DAUER
    mVar YI = m$.var("YI");
    mVar YII = m$.var("YII");
    mVar YDDCOL = m$.var("YDDCOL");
    mVar YDDROW = m$.var("YDDROW");
    mVar WEEK = m$.var("WEEK");
    mVar MONAT = m$.var("MONAT");
    mVar JAHR = m$.var("JAHR");
    mVar MONTHDAYS = m$.var("MONTHDAYS");
    mVar WEEKDAYS = m$.var("WEEKDAYS");
    mVar DATE1 = m$.var("DATE1");
    mVar DATE = m$.var("DATE");
    mVar TIME = m$.var("TIME");
    mVar BEGINN = m$.var("BEGINN");
    mVar ENDE = m$.var("ENDE");
    mVar DAUER = m$.var("DAUER");
    m$.newVar(YI,YII,YDDCOL,YDDROW,WEEK,MONAT,JAHR,MONTHDAYS,WEEKDAYS,DATE1,DATE,TIME,BEGINN,ENDE,DAUER);
    //<< 
    //<< SET (YDDROW,YDDCOL)=0
    YDDROW.set(0);
    YDDCOL.set(0);
    //<< SET YII=0
    YII.set(0);
    //<< FOR YI=1:1:HISTSIZE DO
    for (YI.set(1);(mOp.LessOrEqual(YI.get(),m$.var("HISTSIZE").get()));YI.set(mOp.Add(YI.get(),1))) {
      //<< . SET YII=YII+1
      YII.set(mOp.Add(YII.get(),1));
      //<< . WRITE YCR,"<tr>"
      m$.Cmd.Write(m$.var("YCR").get(),"<tr>");
      //<< . ;
      //<< . ;DESCRIPTION
      //<< . IF HEADLAENG>0 DO
      if (mOp.Greater(m$.var("HEADLAENG").get(),0)) {
        //<< . . WRITE YCR,"<td align=middle valign=middle"
        m$.Cmd.Write(m$.var("YCR").get(),"<td align=middle valign=middle");
        //<< . . WRITE " BGCOLOR="_YDARKGRAY
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YDARKGRAY").get()));
        //<< . . WRITE " COLSPAN="_HEADLAENG
        m$.Cmd.Write(mOp.Concat(" COLSPAN=",m$.var("HEADLAENG").get()));
        //<< . . WRITE ">"
        m$.Cmd.Write(">");
        //<< . . WRITE YCR,"<div valign=middle"
        m$.Cmd.Write(m$.var("YCR").get(),"<div valign=middle");
        //<< . . WRITE " style="_""""
        m$.Cmd.Write(mOp.Concat(" style=","\""));
        //<< . . WRITE " height:"_PIXEL_"px;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" height:",m$.var("PIXEL").get()),"px;"));
        //<< . . WRITE " width:"_(PIXEL*HEADLAENG)_"px;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",(mOp.Multiply(m$.var("PIXEL").get(),m$.var("HEADLAENG").get()))),"px;"));
        //<< . . WRITE " text-align:left;"
        m$.Cmd.Write(" text-align:left;");
        //<< . . WRITE " border-left:1px solid "_COLORDARK_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-left:1px solid ",m$.var("COLORDARK").get()),";"));
        //<< . . WRITE " border-right:1px solid "_COLORLIGHT_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-right:1px solid ",m$.var("COLORLIGHT").get()),";"));
        //<< . . IF YII=1        WRITE " border-top:1px solid "_COLORDARK_";"
        if (mOp.Equal(YII.get(),1)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-top:1px solid ",m$.var("COLORDARK").get()),";"));
        }
        //<< . . IF YII=HISTSIZE WRITE " border-bottom:1px solid; "_COLORLIGHT_";"
        if (mOp.Equal(YII.get(),m$.var("HISTSIZE").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-bottom:1px solid; ",m$.var("COLORLIGHT").get()),";"));
        }
        //<< . . WRITE " overflow:hidden;"
        m$.Cmd.Write(" overflow:hidden;");
        //<< . . WRITE " z-index:0;"
        m$.Cmd.Write(" z-index:0;");
        //<< . . WRITE " font:"_FONTSIZE_"pt arial;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" font:",m$.var("FONTSIZE").get()),"pt arial;"));
        //<< . . WRITE """"_">"
        m$.Cmd.Write(mOp.Concat("\"",">"));
        //<< . . WRITE "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . WRITE YCR,"</div>"
        m$.Cmd.Write(m$.var("YCR").get(),"</div>");
        //<< . . WRITE YCR,"</td>"
        m$.Cmd.Write(m$.var("YCR").get(),"</td>");
      }
      //<< . ;
      //<< . FOR YI(2)=1:1:(COLUMNS-HEADLAENG) DO
      for (m$.var("YI",2).set(1);(mOp.LessOrEqual(m$.var("YI",2).get(),(mOp.Subtract(m$.var("COLUMNS").get(),m$.var("HEADLAENG").get()))));m$.var("YI",2).set(mOp.Add(m$.var("YI",2).get(),1))) {
        //<< . . WRITE YCR,"<td align=middle valign=middle"
        m$.Cmd.Write(m$.var("YCR").get(),"<td align=middle valign=middle");
        //<< . . WRITE " BGCOLOR="_YWHITE
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
        //<< . . ;IF TIMESIZE>1 WRITE " COLSPAN="_TIMESIZE
        //<< . . WRITE ">"
        m$.Cmd.Write(">");
        //<< . . WRITE YCR,"<div valign=middle"
        m$.Cmd.Write(m$.var("YCR").get(),"<div valign=middle");
        //<< . . WRITE " style="_""""_" height:"_PIXEL_"px;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" style=","\"")," height:"),m$.var("PIXEL").get()),"px;"));
        //<< . . WRITE " width:"_PIXEL_"px; text-align:middle;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",m$.var("PIXEL").get()),"px; text-align:middle;"));
        //<< . . IF YII=1   WRITE " border-top:1px solid "_COLORDARK_";"
        if (mOp.Equal(YII.get(),1)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-top:1px solid ",m$.var("COLORDARK").get()),";"));
        }
        //<< . . IF YI(2)=1 WRITE " border-left:1px solid "_COLORDARK_";"
        if (mOp.Equal(YI.var(2).get(),1)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-left:1px solid ",m$.var("COLORDARK").get()),";"));
        }
        //<< . . WRITE " border-right:1px dotted "_YDARKGRAY_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-right:1px dotted ",m$.var("YDARKGRAY").get()),";"));
        //<< . . IF YI(2)=(COLUMNS-HEADLAENG) WRITE " border-right:1px solid "_COLORLIGHT_";"
        if (mOp.Equal(YI.var(2).get(),(mOp.Subtract(m$.var("COLUMNS").get(),m$.var("HEADLAENG").get())))) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-right:1px solid ",m$.var("COLORLIGHT").get()),";"));
        }
        //<< . . IF YII=HISTSIZE WRITE " border-bottom:1px solid "_COLORLIGHT_";"
        if (mOp.Equal(YII.get(),m$.var("HISTSIZE").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" border-bottom:1px solid ",m$.var("COLORLIGHT").get()),";"));
        }
        //<< . . WRITE " overflow:hidden;"
        m$.Cmd.Write(" overflow:hidden;");
        //<< . . WRITE " font:"_FONTSIZE_"pt arial;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" font:",m$.var("FONTSIZE").get()),"pt arial;"));
        //<< . . WRITE """"_">"
        m$.Cmd.Write(mOp.Concat("\"",">"));
        //<< . . ;WRITE YCR,"<FONT SIZE=1 FACE=ARIAL>"
        //<< . . ;WRITE YCR,"</FONT>"
        //<< . . WRITE YCR,"</div>"
        m$.Cmd.Write(m$.var("YCR").get(),"</div>");
        //<< . . WRITE YCR,"</td>"
        m$.Cmd.Write(m$.var("YCR").get(),"</td>");
      }
      //<< . ;
      //<< . WRITE YCR,"</tr>"
      m$.Cmd.Write(m$.var("YCR").get(),"</tr>");
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< VORG(CHART)   ;HOLEN BENUTZERSPEZIFISCHE VORGABEN ;send for
  public Object VORG(Object ... _p) {
    mVar CHART = m$.newVarRef("CHART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< NEW CHART1,YI,SATZ,FELDER
    mVar CHART1 = m$.var("CHART1");
    mVar YI = m$.var("YI");
    mVar SATZ = m$.var("SATZ");
    mVar FELDER = m$.var("FELDER");
    m$.newVar(CHART1,YI,SATZ,FELDER);
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   CHART1      obj^WWWDRAGDROP
    //<< ;   SATZ        obj^WWWDRAGDROPU
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< SET CHART1 = $GET(^WWWDRAGDROP(0,CHART,1))
    CHART1.set(m$.Fnc.$get(m$.var("^WWWDRAGDROP",0,CHART.get(),1)));
    //<< IF '$FIND(";"_$PIECE(CHART1,Y,47)_";",";40;") SET $PIECE(CHART1,Y,47)=$PIECE(CHART1,Y,47)_";"_40  ;AUSWAHL IMMER AUS USERDATEI LADEN
    if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),47)),";"),";40;"))) {
      m$.pieceVar(CHART1,m$.var("Y").get(),47).set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),47),";"),40));
    }
    //<< IF $PIECE(CHART1,Y,47)'="" DO
    if (mOp.NotEqual(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),47),"")) {
      do {
        //<< . SET SATZ=$GET(^WWWDRAGDROPU(0,CHART,YBED,1))  ;MITARBEITERVORGABEN
        SATZ.set(m$.Fnc.$get(m$.var("^WWWDRAGDROPU",0,CHART.get(),m$.var("YBED").get(),1)));
        //<< . IF SATZ="" QUIT
        if (mOp.Equal(SATZ.get(),"")) {
          break;
        }
        //<< . SET FELDER=$TRANSLATE($PIECE(CHART1,Y,47),",",";")
        FELDER.set(m$.Fnc.$translate(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),47),",",";"));
        //<< . FOR YI=1:1 QUIT:$PIECE(FELDER,";",YI,99)=""  DO
        for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
          if (mOp.Equal(m$.Fnc.$piece(FELDER.get(),";",YI.get(),99),"")) {
            break;
          }
          do {
            //<< . . IF $PIECE(SATZ,Y,$PIECE(FELDER,";",YI))="" QUIT
            if (mOp.Equal(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(FELDER.get(),";",YI.get())),"")) {
              break;
            }
            //<< . . SET $PIECE(CHART1,Y,$PIECE(FELDER,";",YI))=$PIECE(SATZ,Y,$PIECE(FELDER,";",YI))
            m$.pieceVar(CHART1,m$.var("Y").get(),m$.Fnc.$piece(FELDER.get(),";",YI.get())).set(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),m$.Fnc.$piece(FELDER.get(),";",YI.get())));
          } while (false);
        }
      } while (false);
    }
    //<< 
    //<< IF +$PIECE(CHART1,Y,58)=0 SET $PIECE(CHART1,Y,58)=100  ;MAX. ANZEIGE ;Show
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(CHART1.get(),m$.var("Y").get(),58)),0)) {
      m$.pieceVar(CHART1,m$.var("Y").get(),58).set(100);
    }
    //<< QUIT CHART1
    return CHART1.get();
  }

//<< 
//<< 
}
