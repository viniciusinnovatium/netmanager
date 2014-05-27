//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMH
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:22
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

//<< WWWFORMH
public class WWWFORMH extends mClass {

  public void main() {
    _WWWFORMH();
  }

  public void _WWWFORMH() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANZEIGEN DATENFELDER
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
    //<< ; 11-Dec-2008   GRF     Disabled block duplicated existing lines - removed
    //<< ; 10-Jul-2007   GRF     Doco; quits; disabled block
    //<< ; 05.08.1997    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW ERSTES,YFFORMAT,YSPALTE,YZEILE,YZEIPO
    mVar ERSTES = m$.var("ERSTES");
    mVar YFFORMAT = m$.var("YFFORMAT");
    mVar YSPALTE = m$.var("YSPALTE");
    mVar YZEILE = m$.var("YZEILE");
    mVar YZEIPO = m$.var("YZEIPO");
    m$.newVar(ERSTES,YFFORMAT,YSPALTE,YZEILE,YZEIPO);
    //<< 
    //<< ;   D44     $$$WWW122FormFormatting     0=Single Field Formatting
    //<< SET YFFORMAT = $PIECE(YVOR,Y,44)   ; Preserve while processing
    YFFORMAT.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44));
    //<< SET $PIECE(YVOR,Y,44) = 0
    m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),44).set(0);
    //<< SET YZEILE = 0,YSPALTE = 0,YZEIPO = 0
    YZEILE.set(0);
    YSPALTE.set(0);
    YZEIPO.set(0);
    //<< SET YHIDDSE = 0
    mVar YHIDDSE = m$.var("YHIDDSE");
    YHIDDSE.set(0);
    //<< 
    //<< NEW YI,YPRIM,YA,YLFN,YLFDNR,YSEI,YZEILE,YSPL,YPOS    ; FIXME : re-newing YZEILE
    mVar YI = m$.var("YI");
    mVar YPRIM = m$.var("YPRIM");
    mVar YA = m$.var("YA");
    mVar YLFN = m$.var("YLFN");
    mVar YLFDNR = m$.var("YLFDNR");
    mVar YSEI = m$.var("YSEI");
    mVar YSPL = m$.var("YSPL");
    mVar YPOS = m$.var("YPOS");
    m$.newVar(YI,YPRIM,YA,YLFN,YLFDNR,YSEI,YZEILE,YSPL,YPOS);
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  YPOS     Header Position (WWW122 D80)
    //<< ;  YBBN     Form Field ID (F#)
    //<< ;  YSATZ    objWWW122       Form Data - Fields
    //<< ;  YVOR     objWWW120       Form Data
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< QUIT:YFORM=""
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      return;
    }
    //<< SET YPOS=""
    YPOS.set("");
    //<< FOR  SET YPOS=$ORDER(^WWW122s(0,6,$$^WWWUMLAU(YFORM,1),YPOS)) QUIT:YPOS=""  QUIT:YPOS=" "  DO
    for (;true;) {
      YPOS.set(m$.Fnc.$order(m$.var("^WWW122s",0,6,m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1),YPOS.get())));
      if (mOp.Equal(YPOS.get(),"")) {
        break;
      }
      if (mOp.Equal(YPOS.get()," ")) {
        break;
      }
      //<< . SET YBBN=""
      mVar YBBN = m$.var("YBBN");
      YBBN.set("");
      //<< . FOR  SET YBBN=$ORDER(^WWW122s(0,6,$$^WWWUMLAU(YFORM,1),YPOS,YFORM,YBBN)) QUIT:YBBN=""  DO
      for (;true;) {
        YBBN.set(m$.Fnc.$order(m$.var("^WWW122s",0,6,m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1),YPOS.get(),m$.var("YFORM").get(),YBBN.get())));
        if (mOp.Equal(YBBN.get(),"")) {
          break;
        }
        do {
          //<< . . SET YSATZ=$GET(^WWW122(0,YFORM,YBBN,1))  ;FELDDEFINITION
          mVar YSATZ = m$.var("YSATZ");
          YSATZ.set(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YBBN.get(),1)));
          //<< . . SET YLFN=$PIECE(YSATZ,Y,1)               ;DATENBANKFELD
          YLFN.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),1));
          //<< . . QUIT:YLFN=""                             ;KEIN DATENFELD (MANUELLES) ;no data item
          if (mOp.Equal(YLFN.get(),"")) {
            break;
          }
          //<< . . SET YART="D"                             ;P=PRIMÄR,D=DATENFELD,M=MANUELLE,L=LISTGENERATOR
          mVar YART = m$.var("YART");
          YART.set("D");
          //<< . . SET YERSTES=2
          mVar YERSTES = m$.var("YERSTES");
          YERSTES.set(2);
          //<< . . DO FORMVOR
          m$.Cmd.Do("FORMVOR");
        } while (false);
      }
    }
    //<< 
    //<< /*   Proposed change
    //<< 
    //<< set idxForm=$$Index^COMUtils(YFORM)
    //<< set YPOS=""
    //<< for {
    //<< set YPOS=$order(^WWW122s(0,6,idxForm,YPOS))
    //<< quit:YPOS=""
    //<< 
    //<< set YBBN=""
    //<< for {
    //<< set YBBN=$order(^WWW122s(0,6,idxForm,YPOS,YFORM,YBBN))
    //<< quit:YBBN=""
    //<< 
    //<< SET YSATZ=$GET(^WWW122(0,YFORM,YBBN,1))  ;FELDDEFINITION
    //<< SET YLFN=$PIECE(YSATZ,Y,1)  ;DATENBANKFELD
    //<< QUIT:YLFN=""                ;KEIN DATENFELD (MANUELLES) ;no data item
    //<< SET YART="D"                ;P=PRIMÄR,D=DATENFELD,M=MANUELLE,L=LISTGENERATOR
    //<< SET YERSTES=2
    //<< DO FORMVOR
    //<< }
    //<< }
    //<< */
    //<< 
    //<< WRITE YCR,"</TR>",YCR      ;ABSCHLUSS FELD  ;TYBD;10.3.2005;27437
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>",m$.var("YCR").get());
    //<< WRITE YCR,"</TABLE>",YCR   ;ABSCHLUSS FORMAT;TYBD;10.3.2005;27437
    m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>",m$.var("YCR").get());
    //<< SET $PIECE(YVOR,Y,44) = YFFORMAT   ; restore
    m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),44).set(YFFORMAT.get());
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< FORMVOR
  public void FORMVOR() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   VORGABEN FÜR FORMULAR ;to form
    //<< ;
    //<< ;   YKEY        = PRIMÄRSCHLÜSSEL  XX,XX,XX  ;WENN DATEI
    //<< ;   YFORM       = FORMULAR
    //<< ;   YLFN        = LFD DATENBANKNUMMER
    //<< ;   YBBN        = LFN BEARBEITUNGSNUMMER
    //<< ;   YART        = Type : O  = OPTIONEN,            P  = PRIMÄR,
    //<< ;                        D  = DATENFELDER,         M  = MANUELLE,
    //<< ;                        LP = LISTGENERATORPRIMÄR, LD = LISTFGEN.DATENFELDER,
    //<< ;                        S  = SORTIERUNG
    //<< ;   YFOART      = Form Type : 1=NORMAL 2=LISTE 3=GRID 4=MANUELLE
    //<< ;   YSATZ       = objWWW122     DEFINITION VORGABE WWW121,WWW122,WWW132,WWW133
    //<< ;   YFELD       = DATENSATZ  ;WENN DATEI ;when data file
    //<< ;   YINHALT     = FELDINHALT  ;WENN MANUELL ;when
    //<< ;   YGRIKEY     = STAMMKEY FUER GRIDSTAMM
    //<< ;   YLISTLF     = LISTEN EINZELFELD
    //<< ;   YVOR        = objWWW120     VORGABEN DES FORMULARS
    //<< ;   YOLDVAL     = VORGABEWERT
    //<< ;-------------------------------------------------------------------------------
    //<< SET YPARA1=YPARA
    mVar YPARA1 = m$.var("YPARA1");
    YPARA1.set(m$.var("YPARA").get());
    //<< 
    //<< NEW YO,YI,YNAME,YNAME0,YNAME1,YTYPE,YPARA,YTYP,Q,YSORT,YXTYP,YFOART1,YJAVA,YPFLICHT
    mVar YO = m$.var("YO");
    mVar YI = m$.var("YI");
    mVar YNAME = m$.var("YNAME");
    mVar YNAME0 = m$.var("YNAME0");
    mVar YNAME1 = m$.var("YNAME1");
    mVar YTYPE = m$.var("YTYPE");
    mVar YPARA = m$.var("YPARA");
    mVar YTYP = m$.var("YTYP");
    mVar Q = m$.var("Q");
    mVar YSORT = m$.var("YSORT");
    mVar YXTYP = m$.var("YXTYP");
    mVar YFOART1 = m$.var("YFOART1");
    mVar YJAVA = m$.var("YJAVA");
    mVar YPFLICHT = m$.var("YPFLICHT");
    m$.newVar(YO,YI,YNAME,YNAME0,YNAME1,YTYPE,YPARA,YTYP,Q,YSORT,YXTYP,YFOART1,YJAVA,YPFLICHT);
    //<< 
    //<< QUIT:YFORM=""
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      return;
    }
    //<< QUIT:YART=""   ;P=PRIMÄR,D=DATENFELDER,M=MANUELLE,L=LISTGENERATOR
    if (mOp.Equal(m$.var("YART").get(),"")) {
      return;
    }
    //<< ;Q:YLFN=""     ;LFD NUMMER
    //<< ;Q:YSATZ=""    ;DEFINITION VORGABE WWW121,WWW122,WWW1210
    //<< 
    //<< ; D36   Horizontal Orientation Of Label
    //<< SET YFAUS="LEFT"
    mVar YFAUS = m$.var("YFAUS");
    YFAUS.set("LEFT");
    //<< IF $PIECE(YVOR,Y,36)=3  SET YFAUS="RIGHT"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),36),3)) {
      YFAUS.set("RIGHT");
    }
    //<< IF $PIECE(YSATZ,Y,36)=3 SET YFAUS="RIGHT"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),36),3)) {
      YFAUS.set("RIGHT");
    }
    //<< IF $PIECE(YVOR,Y,36)=2  SET YFAUS="CENTER"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),36),2)) {
      YFAUS.set("CENTER");
    }
    //<< IF $PIECE(YSATZ,Y,36)=2 SET YFAUS="CENTER"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),36),2)) {
      YFAUS.set("CENTER");
    }
    //<< IF YFOART=3             SET YFAUS="LEFT"   ;WENN GRID, DANN LINKS
    if (mOp.Equal(m$.var("YFOART").get(),3)) {
      YFAUS.set("LEFT");
    }
    //<< 
    //<< ; D37   Vertical Orientation Of Label
    //<< SET YVAUS="TOP"
    mVar YVAUS = m$.var("YVAUS");
    YVAUS.set("TOP");
    //<< IF $PIECE(YVOR,Y,37)=3  SET YVAUS="BOTTOM"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),37),3)) {
      YVAUS.set("BOTTOM");
    }
    //<< IF $PIECE(YSATZ,Y,37)=3 SET YVAUS="BOTTOM"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),37),3)) {
      YVAUS.set("BOTTOM");
    }
    //<< IF $PIECE(YVOR,Y,37)=2  SET YVAUS="MIDDLE"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),37),2)) {
      YVAUS.set("MIDDLE");
    }
    //<< IF $PIECE(YSATZ,Y,37)=2 SET YVAUS="MIDDLE"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),37),2)) {
      YVAUS.set("MIDDLE");
    }
    //<< IF $PIECE(YVOR,Y,37)=4  SET YVAUS="BASELINE"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),37),4)) {
      YVAUS.set("BASELINE");
    }
    //<< IF $PIECE(YSATZ,Y,37)=4 SET YVAUS="BASELINE"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),37),4)) {
      YVAUS.set("BASELINE");
    }
    //<< IF YFOART=3             SET YVAUS="BOTTOM"  ;GRID=UNTEN
    if (mOp.Equal(m$.var("YFOART").get(),3)) {
      YVAUS.set("BOTTOM");
    }
    //<< 
    //<< SET YXTYP = 0
    YXTYP.set(0);
    //<< SET YHID  = 0
    mVar YHID = m$.var("YHID");
    YHID.set(0);
    //<< IF $GET(YBBN)="" SET YBBN = YLFN
    if (mOp.Equal(m$.Fnc.$get(m$.var("YBBN")),"")) {
      mVar YBBN = m$.var("YBBN");
      YBBN.set(m$.var("YLFN").get());
    }
    //<< SET YNUMMER   = YLFN                ; FIXME : immediately overwritten <GRF>
    mVar YNUMMER = m$.var("YNUMMER");
    YNUMMER.set(m$.var("YLFN").get());
    //<< SET YNUMMER   = YBBN
    YNUMMER.set(m$.var("YBBN").get());
    //<< SET YFOART1   = YFOART
    YFOART1.set(m$.var("YFOART").get());
    //<< SET YTYP      = ""
    YTYP.set("");
    //<< SET YINHALT   = 1
    mVar YINHALT = m$.var("YINHALT");
    YINHALT.set(1);
    //<< SET YNAME0    = ""
    YNAME0.set("");
    //<< SET YNAME1    = ""
    YNAME1.set("");
    //<< SET YPARA(7)  = 0
    YPARA.var(7).set(0);
    //<< SET YPARA(20) = 0
    YPARA.var(20).set(0);
    //<< SET YJAVA     = 0
    YJAVA.set(0);
    //<< SET YPFLICHT  = 0
    YPFLICHT.set(0);
    //<< SET YSTATUS   = $PIECE(YSATZ,Y,65)         ; Text Displayed In Status Line
    mVar YSTATUS = m$.var("YSTATUS");
    YSTATUS.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),65));
    //<< IF (YFOART=1) || (YFOART=3) SET YJAVA = 1  ;BEARBEITUNGSSTATUS
    if ((mOp.Equal(m$.var("YFOART").get(),1)) || (mOp.Equal(m$.var("YFOART").get(),3))) {
      YJAVA.set(1);
    }
    //<< FOR YI=53:1:56,60 SET YO(YI) = $PIECE(YVOR,Y,YI)
    for (YI.set(53);(mOp.LessOrEqual(YI.get(),56));YI.set(mOp.Add(YI.get(),1))) {
      YO.var(YI.get()).set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),YI.get()));
    }
    //<< 
    //<< ;DATENFELDER
    //<< SET YART="H"
    mVar YART = m$.var("YART");
    YART.set("H");
    do {
      //<< DO
      //<< . SET YDATEI = $PIECE($GET(^WWW120(0,YFORM,1)),Y,11)  QUIT:YDATEI=""
      mVar YDATEI = m$.var("YDATEI");
      YDATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),11));
      if (mOp.Equal(YDATEI.get(),"")) {
        break;
      }
      //<< . SET YDVOR  = $GET(^WWW003(0,YDATEI,YLFN,1))         QUIT:YDVOR=""    ;DATEN AUS FELDDEV ;out of
      mVar YDVOR = m$.var("YDVOR");
      YDVOR.set(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),m$.var("YLFN").get(),1)));
      if (mOp.Equal(YDVOR.get(),"")) {
        break;
      }
      //<< . ;
      //<< . SET YTYP   = $PIECE(YDVOR,Y,3)          ;ERFASSUNGSART
      YTYP.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),3));
      //<< . IF $PIECE(YSATZ,Y,5)'="" SET YTYP = $PIECE(YSATZ,Y,5)
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),5),"")) {
        YTYP.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),5));
      }
      //<< . SET YXTYP  = +$PIECE(YSATZ,Y,2)         ;ERFASSUNGSART AUS FORMULARFELD ;out of
      YXTYP.set(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),2)));
      //<< . SET YLANGE = $PIECE(YDVOR,Y,4)          ;FELDLENGE
      mVar YLANGE = m$.var("YLANGE");
      YLANGE.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),4));
      //<< . IF +$PIECE(YSATZ,Y,6)'=0 SET YLANGE = $PIECE(YSATZ,Y,6)
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),6)),0)) {
        YLANGE.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),6));
      }
      //<< . SET YNAME0 = ""                         ;TEXT VOR ;Text pre-
      YNAME0.set("");
      //<< . SET YNAME1 = ""                         ;TEXT NACH ;Text within
      YNAME1.set("");
      //<< . SET YNAME  = $PIECE(YDVOR,Y,2)          ;NORMALTEXT
      YNAME.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),2));
      //<< . IF $DATA(^WWW0031(0,YDATEI,YLFN,$$^WWWLANGU(YBED),1)) SET YNAME=$PIECE(^(1),Y,1)
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,YDATEI.get(),m$.var("YLFN").get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
        YNAME.set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
      }
      //<< . ;IF $PIECE(YSATZ,Y,12)="" IF $DATA(^WWW122(0,YFORM,YBBN,1)) SET $PIECE(^WWW122(0,YFORM,YBBN,1),Y,12)=YNAME  ;WENN LEER
      //<< . SET YPARA(12) = $PIECE(YDVOR,Y,7)   ;RELATION SORTIEREN ;assortment
      YPARA.var(12).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),7));
      //<< . SET YPARA(1)  = $PIECE(YDVOR,Y,8)   ;RELATIONSDATEI  AUS DATEIDEV ;out of
      YPARA.var(1).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),8));
      //<< . SET YPARA(2)  = $PIECE(YDVOR,Y,9)   ;REL KEY
      YPARA.var(2).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),9));
      //<< . SET YPARA(3)  = $PIECE(YDVOR,Y,10)  ;REL FELD ;field
      YPARA.var(3).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),10));
      //<< . IF $PIECE(YSATZ,Y,63)'="" SET YPARA(3) = $PIECE(YSATZ,Y,63)
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63),"")) {
        YPARA.var(3).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63));
      }
      //<< . SET YPARA(20) = 1                   ;ERST SPÄTER ANZEIGEN ;only subsequent display
      YPARA.var(20).set(1);
      //<< . IF $PIECE(YSATZ,Y,32)'="" DO
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),32),"")) {
        //<< . . SET YPARA(12)= $PIECE(YSATZ,Y,62) ;REL SORTIEREN ;assortment
        YPARA.var(12).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),62));
        //<< . . SET YPARA(1) = $PIECE(YSATZ,Y,32) ;RELDATEI AUS FORMULAR DEV ;out of form
        YPARA.var(1).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),32));
        //<< . . SET YPARA(2) = $PIECE(YSATZ,Y,33) ;KEY F. RELATION
        YPARA.var(2).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),33));
        //<< . . SET YPARA(3) = $PIECE(YSATZ,Y,34) ;FELDER
        YPARA.var(3).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),34));
        //<< . . IF $PIECE(YSATZ,Y,63)'="" SET YPARA(3)=$PIECE(YSATZ,Y,63)
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63),"")) {
          YPARA.var(3).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63));
        }
        //<< . . SET YPARA(20)=1                   ;ERST SPÄTER ANZEIGEN ;only subsequent display
        YPARA.var(20).set(1);
      }
      //<< . ;
      //<< . SET YPARA(67)=""                    ;NEUES FELD AUS EVENT BROKER ;something new field out of
      YPARA.var(67).set("");
      //<< . SET YPARA(79)=""                    ;RELATIONSFELD FÜR MARKIERUNG ;to
      YPARA.var(79).set("");
      //<< . SET YPARA(80)=""                    ;WELCHE FELDER MARKIEREN ;who
      YPARA.var(80).set("");
      //<< . SET YSPAL  = $PIECE(YPOS,".",2)     ;SPALTEN VORGABE ;split default
      mVar YSPAL = m$.var("YSPAL");
      YSPAL.set(m$.Fnc.$piece(m$.var("YPOS").get(),".",2));
      //<< . SET YZEILE = $PIECE(YPOS,".",1)
      mVar YZEILE = m$.var("YZEILE");
      YZEILE.set(m$.Fnc.$piece(m$.var("YPOS").get(),".",1));
      //<< . IF $GET(YLASTZEIL)'="" IF YLASTZEIL'=YZEILE WRITE "</TABLE>"
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLASTZEIL")),"")) {
        if (mOp.NotEqual(m$.var("YLASTZEIL").get(),YZEILE.get())) {
          m$.Cmd.Write("</TABLE>");
        }
      }
      //<< . SET YLASTZEIL = YZEILE
      mVar YLASTZEIL = m$.var("YLASTZEIL");
      YLASTZEIL.set(YZEILE.get());
      //<< . SET YINHALT   = $PIECE(YFELD,Y,YLFN)  ;FELDINHALT
      YINHALT.set(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()));
      //<< . SET YHID = 2                          ; Field Disabled      ;FELDBERECHITIGUNG
      YHID.set(2);
      //<< . FOR YI=53:1:56 IF +$PIECE(YSATZ,Y,YI)'=0 SET YO(YI)=$PIECE(YSATZ,Y,YI)  ;VORGABEN FÜR OBJEKTANZEIGE ;to
      for (YI.set(53);(mOp.LessOrEqual(YI.get(),56));YI.set(mOp.Add(YI.get(),1))) {
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),YI.get())),0)) {
          YO.var(YI.get()).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),YI.get()));
        }
      }
      //<< . ;
      //<< . DO ^WWWFORM7                        ; *** EXECUTE 15-20 ***   ; FIXME : Start^WWWFORM7($$$NO)
      m$.Cmd.Do("WWWFORM7.main");
    } while(false);
    //<< 
    //<< QUIT
    return;
  }

//<< 
}
