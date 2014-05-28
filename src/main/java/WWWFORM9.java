//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM9
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:25
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
//<< #include WWWConst
import include.WWWConst;
//<< #include COMConst
import include.COMConst;

//<< WWWFORM9
public class WWWFORM9 extends mClass {

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogR2(%1,%2)    ;
  public static Object $$$LogR2(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogRx(%1)       ;
  public static Object $$$LogRx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _WWWFORM9();
  }

  public void _WWWFORM9() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORM9("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogR2(%1,%2)   $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORM9("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       EINGABE VORBEREITEN - Input Preparation
    //<< ;
    //<< ; Called By: FORMVOR^WWWFORMD, PRIM^WWWFORML, FELD^WWWFORML, ^WWWFORMO
    //<< ;            ^WWWFORMP, ^WWWFORMW, FORMVOR^WWWFORMW, ^WWWSMA
    //<< ;
    //<< ; By Ref :
    //<< ;
    //<< ;   YKEY    = PRIMÄRSCHLÜSSEL  XX,XX,XX  ;WENN DATEI
    //<< ;   YFORM   = FORMULAR
    //<< ;   YLFN    = Form  Field Number F#      LFD DATENBANKNUMMER
    //<< ;   YBBN    = Class Field Number D#      LFN BEARBEITUNGSNUMMER
    //<< ;   YART    = Type
    //<< ;               O=OPTIONEN, P=PRIMÄR, D=DATENFELDER, M=MANUELLE,
    //<< ;               LP=LISTGENERATORPRIMÄR, LD=LISTFGEN.DATENFELDER, S=SORTIERUNG
    //<< ;   YFOART  = FORMART 1=NORMAL 2=LISTE 3=GRID 4=MANUELLE
    //<< ;   YSATZ   = DEFINITION VORGABE WWW121,WWW122 (Form); WWW132,WWW133 (List)
    //<< ;   YFELD   = DATENSATZ    ;WENN DATEI   ;when data file
    //<< ;   YINHALT = FELDINHALT   ;WENN MANUELL ;when
    //<< ;   YGRIKEY = STAMMKEY FUER GRIDSTAMM
    //<< ;   YLISTLF = LISTEN EINZELFELD
    //<< ;   YVOR    = VORGABEN DES FORMULARS
    //<< ;   YOLDVAL = VORGABEWERT
    //<< ;   YPARA1  = ?
    //<< ;
    //<< ; Returns : Nothing
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 04-Oct-2012   shobby  SR18129: Better alignment of caption and input controls
    //<< ; 29-Aug-2011   PPP     SR17887: Added FONTSIZE for 'Text Behind User Input Field'
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
    //<< ; 25-Jun-2009   shobby  SR16679: Allow the 'Text Behind User Input Field' to be translatable
    //<< ; 30-May-2008   shobby  SRBR014949: Corrected issue with WWW1211
    //<< ; 04-Apr-2008   GM      SRBR014923: Changed $$^WWWTEXT() to $$$Text() for language texts (53) and (54)
    //<< ; 10-Oct-2007   GRF     SR15563: Macro change
    //<< ; 01-Jun-2007   shobby  SRBR014501: Put the onBehind calls before the translated references.
    //<< ; 07-May-2007   GRF     SRBR014310: Doco; quits
    //<< ; 19-Oct-2006   RPW     SR14914: Clean ups for multiple calls to one routine and
    //<< ;                           removed naked references
    //<< ; 18-Apr-2006   JW      SR14421: Key should not be converted to display format yet.
    //<< ;  9-Dec-2005   JW      SR13195: Update 2nd D piece of WWWDATEN as well. Don't set
    //<< ;                           either if just changing tabs
    //<< ; 16-Nov-2005   GRF     SR12505: Doco
    //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 04-APR-2005   TYBD    IDs FOR BUTTON ADDED FOR TESTDIRECTOR
    //<< ; 05-Aug-1997   DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< set YPARA1 = $get(YPARA)
    mVar YPARA1 = m$.var("YPARA1");
    YPARA1.set(m$.Fnc.$get(m$.var("YPARA")));
    //<< 
    //<< new YO,YI,YNAME,YNAME0,YNAME1,YTYPE,YPARA,YTYP,Q,YSORT,YXTYP,YFOART1,YJAVA,YPFLICHT,YCOLOR1
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
    mVar YCOLOR1 = m$.var("YCOLOR1");
    m$.newVar(YO,YI,YNAME,YNAME0,YNAME1,YTYPE,YPARA,YTYP,Q,YSORT,YXTYP,YFOART1,YJAVA,YPFLICHT,YCOLOR1);
    //<< new YPADDINGTOP ;SR18129
    mVar YPADDINGTOP = m$.var("YPADDINGTOP");
    m$.newVar(YPADDINGTOP);
    //<< new strLanguage
    mVar strLanguage = m$.var("strLanguage");
    m$.newVar(strLanguage);
    //<< 
    //<< $$$LogR("",YFORM_"<"_YART_"<"_YFOART)
    $$$LogR(m$,"",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YFORM").get(),"<"),m$.var("YART").get()),"<"),m$.var("YFOART").get()));
    //<< 
    //<< set YPARA = YPARA1
    YPARA.set(YPARA1.get());
    //<< set YFELD = $get(YFELD)
    mVar YFELD = m$.var("YFELD");
    YFELD.set(m$.Fnc.$get(m$.var("YFELD")));
    //<< 
    //<< quit:YFORM=""  ;FORMULAR ;form
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      return;
    }
    //<< quit:YART=""   ;P=PRIMÄR,D=DATENFELDER,M=MANUELLE,L=LISTGENERATOR  [O=OPTION?]
    if (mOp.Equal(m$.var("YART").get(),"")) {
      return;
    }
    //<< ;Q:YLFN=""     ;LFD NUMMER
    //<< ;Q:YSATZ=""    ;DEFINITION VORGABE WWW121,WWW122,WWW1210
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;---------------------------------------
    //<< ;  D36 : Horizontal Orientation  WWW121/122
    //<< ;---------------------------------------
    //<< set YFAUS="LEFT"
    mVar YFAUS = m$.var("YFAUS");
    YFAUS.set("LEFT");
    //<< if $piece(YVOR,Y,36)=3  set YFAUS="RIGHT"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),36),3)) {
      YFAUS.set("RIGHT");
    }
    //<< if $piece(YSATZ,Y,36)=3 set YFAUS="RIGHT"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),36),3)) {
      YFAUS.set("RIGHT");
    }
    //<< if $piece(YVOR,Y,36)=2  set YFAUS="CENTER"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),36),2)) {
      YFAUS.set("CENTER");
    }
    //<< if $piece(YSATZ,Y,36)=2 set YFAUS="CENTER"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),36),2)) {
      YFAUS.set("CENTER");
    }
    //<< if $piece(YVOR,Y,36)=1  set YFAUS="LEFT"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),36),1)) {
      YFAUS.set("LEFT");
    }
    //<< if $piece(YSATZ,Y,36)=1 set YFAUS="LEFT"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),36),1)) {
      YFAUS.set("LEFT");
    }
    //<< if YFOART=3             set YFAUS="LEFT"   ;WENN GRID, DANN LINKS
    if (mOp.Equal(m$.var("YFOART").get(),3)) {
      YFAUS.set("LEFT");
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;  D37 : Vertical Orientation  WWW121/122
    //<< ;---------------------------------------
    //<< set YVAUS="TOP"
    mVar YVAUS = m$.var("YVAUS");
    YVAUS.set("TOP");
    //<< if $piece(YVOR,Y,37)=3  set YVAUS="BOTTOM"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),37),3)) {
      YVAUS.set("BOTTOM");
    }
    //<< if $piece(YSATZ,Y,37)=3 set YVAUS="BOTTOM"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),37),3)) {
      YVAUS.set("BOTTOM");
    }
    //<< if $piece(YVOR,Y,37)=2  set YVAUS="MIDDLE"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),37),2)) {
      YVAUS.set("MIDDLE");
    }
    //<< if $piece(YSATZ,Y,37)=2 set YVAUS="MIDDLE"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),37),2)) {
      YVAUS.set("MIDDLE");
    }
    //<< if $piece(YVOR,Y,37)=4  set YVAUS="BASELINE"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),37),4)) {
      YVAUS.set("BASELINE");
    }
    //<< if $piece(YSATZ,Y,37)=4 set YVAUS="BASELINE"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),37),4)) {
      YVAUS.set("BASELINE");
    }
    //<< if $piece(YVOR,Y,37)=1  set YVAUS="TOP"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),37),1)) {
      YVAUS.set("TOP");
    }
    //<< if $piece(YSATZ,Y,37)=1 set YVAUS="TOP"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),37),1)) {
      YVAUS.set("TOP");
    }
    //<< if YFOART=3             set YVAUS="BOTTOM"  ;GRID=UNTEN
    if (mOp.Equal(m$.var("YFOART").get(),3)) {
      YVAUS.set("BOTTOM");
    }
    //<< 
    //<< set YPADDINGTOP="0px"                       ;SR18129
    YPADDINGTOP.set("0px");
    //<< if YVAUS="TOP" {                            ;SR18129
    if (mOp.Equal(YVAUS.get(),"TOP")) {
      //<< if $$$WWW122FlatControls(YSATZ) {       ;SR18129
      if (mOp.Logical(include.WWWConst.$$$WWW122FlatControls(m$,m$.var("YSATZ")))) {
        //<< set YPADDINGTOP="1px"               ;SR18129
        YPADDINGTOP.set("1px");
      }
      //<< } else {                                ;SR18129
      else {
        //<< set YPADDINGTOP="3px"               ;SR18129
        YPADDINGTOP.set("3px");
      }
    }
    //<< }                                       ;SR18129
    //<< }                                           ;SR18129
    //<< 
    //<< set YXTYP = 0
    YXTYP.set(0);
    //<< set YHID  = 0
    mVar YHID = m$.var("YHID");
    YHID.set(0);
    //<< if $get(YBBN)="" set YBBN=YLFN
    if (mOp.Equal(m$.Fnc.$get(m$.var("YBBN")),"")) {
      mVar YBBN = m$.var("YBBN");
      YBBN.set(m$.var("YLFN").get());
    }
    //<< ;SET YNUMMER   = YLFN
    //<< set YNUMMER   = YBBN
    mVar YNUMMER = m$.var("YNUMMER");
    YNUMMER.set(m$.var("YBBN").get());
    //<< set YFOART1   = YFOART
    YFOART1.set(m$.var("YFOART").get());
    //<< set YTYP      = ""
    YTYP.set("");
    //<< set YINHALT   = ""
    mVar YINHALT = m$.var("YINHALT");
    YINHALT.set("");
    //<< set YNAME0    = ""
    YNAME0.set("");
    //<< set YNAME1    = ""
    YNAME1.set("");
    //<< set YPARA(7)  = 0
    YPARA.var(7).set(0);
    //<< set YPARA(20) = 0  ; "Display All Relations"
    YPARA.var(20).set(0);
    //<< set YPARA(29) = 1  ;  Display Direction 1 or -1     AUF / AB SORTIERUNG ; based on WWW003 D29 : DisplayRelationsDownwards
    YPARA.var(29).set(1);
    //<< set YJAVA     = 0
    YJAVA.set(0);
    //<< set YPFLICHT  = ""
    YPFLICHT.set("");
    //<< set YSTATUS   = $piece(YSATZ,Y,65)
    mVar YSTATUS = m$.var("YSTATUS");
    YSTATUS.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),65));
    //<< 
    //<< if (YFOART=1) || (YFOART=3) || (YFOART=4) || (YFOART=5) set YJAVA=1  ;BEARBEITUNGSSTATUS
    if ((mOp.Equal(m$.var("YFOART").get(),1)) || (mOp.Equal(m$.var("YFOART").get(),3)) || (mOp.Equal(m$.var("YFOART").get(),4)) || (mOp.Equal(m$.var("YFOART").get(),5))) {
      YJAVA.set(1);
    }
    //<< //for YI=53:1:56,60 set YO(YI)=$piece(YVOR,Y,YI)
    //<< for YI=53,54,55,56,60 set YO(YI)=$piece(YVOR,Y,YI)
    for (Object _YI: new Object[] {53,54,55,56,60}) {
    YI.set(_YI);
      YO.var(_YI).set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),_YI));
    }
    //<< 
    //<< kill ^WWWSOR(YUSER,2)
    m$.var("^WWWSOR",m$.var("YUSER").get(),2).kill();
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Primary Key             ; PRIMAERSCHLUESSEL
    //<< ;   YSATZ           WWW121
    //<< ;   YDVOR           WWW002
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< if YART="P" do
    if (mOp.Equal(m$.var("YART").get(),"P")) {
      do {
        //<< . set YDATEI=$piece($get(^WWW120(0,YFORM,1)),Y,11)   ; Class associated with form
        mVar YDATEI = m$.var("YDATEI");
        YDATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),11));
        //<< . quit:YDATEI=""
        if (mOp.Equal(YDATEI.get(),"")) {
          break;
        }
        //<< . ;
        //<< . set YFOART1=1
        YFOART1.set(1);
        //<< . ;
        //<< . ; Form Type 3 : Grid
        //<< . ; Close off prior key table if applicable and call WWWFORM3 to build grid header line
        //<< . ;-------------------------------------
        //<< . if YFOART=3 if YLFN=$order(^WWW002(0,YDATEI,""),-1) do  if ($$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly) write YCR,"<INPUT NAME=""Y"_YFORM_YART_YLFN_"""" write " ID=""Y"_YFORM_YART_YLFN_"""" write " TYPE=HIDDEN" quit  ;WENN LETZTER KEY IM GRID ;when last KEY  ;SR17253
        if (mOp.Equal(m$.var("YFOART").get(),3)) {
          if (mOp.Equal(m$.var("YLFN").get(),m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1)))) {
            //<< . . if YLFN'=1 do
            if (mOp.NotEqual(m$.var("YLFN").get(),1)) {
              do {
                //<< . . . ;     D16     $$$WWW121FixedInputForHiddenField()
                //<< . . . if YLFN=2 if $piece($get(^WWW121(0,YFORM,1,1)),Y,16)=0 quit  ;TYBD;6.1.2003;WENN KEIN PRIMÄRSCHLÜSSEL DANN KEIN ENDE ;when no no termination
                if (mOp.Equal(m$.var("YLFN").get(),2)) {
                  if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),1,1)),m$.var("Y").get(),16),0)) {
                    break;
                  }
                }
                //<< . . . write YCR,"</TR></TABLE><BR>"
                m$.Cmd.Write(m$.var("YCR").get(),"</TR></TABLE><BR>");
                //<< . . . set YTABLEANZ=$get(YTABLEANZ)-1
                mVar YTABLEANZ = m$.var("YTABLEANZ");
                YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
              } while (false);
            }
            //<< . . ;
            //<< . . set YFOART1=3 do ^WWWFORM3  ; Form Type 3 : GRID - Display Heading line
            YFOART1.set(3);
            m$.Cmd.Do("WWWFORM3.main");
            if ((mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$)))) {
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT NAME=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ID=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
              m$.Cmd.Write(" TYPE=HIDDEN");
              break;
            }
          }
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . set YDVOR = $get(^WWW002(0,YDATEI,YLFN,1))  ;VORGABEN AUS DATEIDEV ;out of
        mVar YDVOR = m$.var("YDVOR");
        YDVOR.set(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),m$.var("YLFN").get(),1)));
        //<< . if $get(YTIMEFORM)=1 do   ;ZEITABHÄNGIGE ERFASSUNG ;logging
        if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
          do {
            //<< . . set YSAVEDDATA = 1
            mVar YSAVEDDATA = m$.var("YSAVEDDATA");
            YSAVEDDATA.set(1);
            //<< . . if YDVOR'="" quit       ;KEY VORHANDEN ;KEY on hand
            if (mOp.NotEqual(YDVOR.get(),"")) {
              break;
            }
            //<< . . if $piece(YKEY,",",YLFN)="" set $piece(YKEY,",",YLFN) = ""  ;$H+1
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",m$.var("YLFN").get()),"")) {
              m$.pieceVar(m$.var("YKEY"),",",m$.var("YLFN").get()).set("");
            }
            //<< . . if $piece(YKEY,",",YLFN)="" set YSAVEDDATA = ""
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",m$.var("YLFN").get()),"")) {
              YSAVEDDATA.set("");
            }
            //<< . . set YDVOR = "Effectivity Date~Effectivity Date~1~10~~~"         ; FIXME : Internationalise rather than EN/DE?
            YDVOR.set("Effectivity Date~Effectivity Date~1~10~~~");
            //<< . . if SPRACHE="DE" set YDVOR="Gültig ab Datum~Gültig ab Datum~1~10~~~"  ;bei Zeitabhängiger erfassung ;next to
            if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
              YDVOR.set("Gültig ab Datum~Gültig ab Datum~1~10~~~");
            }
          } while (false);
        }
        //<< . ;
        //<< . quit:YDVOR=""
        if (mOp.Equal(YDVOR.get(),"")) {
          break;
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . set YTYP  = $piece(YDVOR,Y,3)      ; $$$WWW002InputType()                  TYPE AUS DATEI DEV ;letter out of data file
        YTYP.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),3));
        //<< . set YXTYP =+$piece(YSATZ,Y,104)    ; $$$WWW121TypeOfAcquisition()          ERFASSUNGSART AUS FORMULARFELD ;out of
        YXTYP.set(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),104)));
        //<< . if YXTYP=16 set YXTYP = 0          ; Primary key cannot be a "Collection"
        if (mOp.Equal(YXTYP.get(),16)) {
          YXTYP.set(0);
        }
        //<< . if $piece(YSATZ,Y,16)'="" do       ; $$$WWW121FixedInputForHiddenField()   default for fixed key
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),"")) {
          //<< . . set YHID=1
          YHID.set(1);
          //<< . . if YLFN=$piece(YSATZ,Y,16) do
          if (mOp.Equal(m$.var("YLFN").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16))) {
            do {
              //<< . . . if $piece(YFKEY,",",YLFN)'="" if $piece(YKEY,",",$piece(YSATZ,Y,16))="" set $piece(YKEY,",",YLFN)=$piece(YFKEY,",",$piece(YSATZ,Y,16))  ;WENN "NEU"  BEI GLEICHE KEYS
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFKEY").get(),",",m$.var("YLFN").get()),"")) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16)),"")) {
                  m$.pieceVar(m$.var("YKEY"),",",m$.var("YLFN").get()).set(m$.Fnc.$piece(m$.var("YFKEY").get(),",",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16)));
                }
              }
              //<< . . . set $piece(YFKEY,",",YLFN)=$piece(YKEY,",",$piece(YSATZ,Y,16))  ;GLEICHE KEYS ;same
              m$.pieceVar(m$.var("YFKEY"),",",m$.var("YLFN").get()).set(m$.Fnc.$piece(m$.var("YKEY").get(),",",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16)));
              //<< . . . quit:$piece(YKEY,",",YLFN)'=""
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),",",m$.var("YLFN").get()),"")) {
                break;
              }
              //<< . . . new YBACK1
              mVar YBACK1 = m$.var("YBACK1");
              m$.newVarBlock(3,YBACK1);
              //<< . . . set YBACK1=$piece($get(YBACK),",",$length($get(YBACK),",")-1)
              YBACK1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YBACK")),",",mOp.Subtract(m$.Fnc.$length(m$.Fnc.$get(m$.var("YBACK")),","),1)));
              //<< . . . if YBACK1'="" set $piece(YKEY,",",YLFN)=$get(^WWW126(YM,YBACK1,YUSER,$piece(YSATZ,Y,16),1)) set $piece(YFKEY,",",YLFN)=$get(^WWW126(YM,YBACK1,YUSER,$piece(YSATZ,Y,16),1)) ;UNGLEICHE KEYS
              if (mOp.NotEqual(YBACK1.get(),"")) {
                m$.pieceVar(m$.var("YKEY"),",",m$.var("YLFN").get()).set(m$.Fnc.$get(m$.var("^WWW126",m$.var("YM").get(),YBACK1.get(),m$.var("YUSER").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),1)));
                m$.pieceVar(m$.var("YFKEY"),",",m$.var("YLFN").get()).set(m$.Fnc.$get(m$.var("^WWW126",m$.var("YM").get(),YBACK1.get(),m$.var("YUSER").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),1)));
              }
            } while (false);
          }
          m$.restoreVarBlock(3);
          //<< . . ;
          //<< . . if YLFN'=$piece(YSATZ,Y,16) do
          if (mOp.NotEqual(m$.var("YLFN").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16))) {
            do {
              //<< . . . quit:+$piece(YSATZ,Y,16)=0
              if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16)),0)) {
                break;
              }
              //<< . . . new YBACK1
              mVar YBACK1 = m$.var("YBACK1");
              m$.newVarBlock(3,YBACK1);
              //<< . . . set YBACK1=$piece($get(YBACK),",",$length($get(YBACK),",")-1)
              YBACK1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YBACK")),",",mOp.Subtract(m$.Fnc.$length(m$.Fnc.$get(m$.var("YBACK")),","),1)));
              //<< . . . if YBACK1'="" set $piece(YKEY,",",YLFN)=$get(^WWW126(YM,YBACK1,YUSER,$piece(YSATZ,Y,16),1)) set $piece(YFKEY,",",YLFN)=$get(^WWW126(YM,YBACK1,YUSER,$piece(YSATZ,Y,16),1)) ;UNGLEICHE KEYS
              if (mOp.NotEqual(YBACK1.get(),"")) {
                m$.pieceVar(m$.var("YKEY"),",",m$.var("YLFN").get()).set(m$.Fnc.$get(m$.var("^WWW126",m$.var("YM").get(),YBACK1.get(),m$.var("YUSER").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),1)));
                m$.pieceVar(m$.var("YFKEY"),",",m$.var("YLFN").get()).set(m$.Fnc.$get(m$.var("^WWW126",m$.var("YM").get(),YBACK1.get(),m$.var("YUSER").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),1)));
              }
            } while (false);
          }
          m$.restoreVarBlock(3);
          //<< . . ;
          //<< . . if +$piece(YSATZ,Y,16)=0 do
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16)),0)) {
            do {
              //<< . . . quit:$get(YSAVEDDATA)=1  ;DATEN WAREN GESPEICHERT = KEINE VORBELEGUNG ;no
              if (mOp.Equal(m$.Fnc.$get(m$.var("YSAVEDDATA")),1)) {
                break;
              }
              //<< . . . if $piece(YSATZ,Y,15)'="+" set $piece(YFKEY,",",YLFN) = $piece(YSATZ,Y,15)
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),"+")) {
                m$.pieceVar(m$.var("YFKEY"),",",m$.var("YLFN").get()).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15));
              }
              //<< . . . if $piece(YSATZ,Y,15)="+"  set $piece(YFKEY,",",YLFN) = $piece(YSATZ,Y,15),$piece(YKEY,",",YLFN)=$piece(YSATZ,Y,15),YINHALT=$piece(YSATZ,Y,15)
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),"+")) {
                m$.pieceVar(m$.var("YFKEY"),",",m$.var("YLFN").get()).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15));
                m$.pieceVar(m$.var("YKEY"),",",m$.var("YLFN").get()).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15));
                YINHALT.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15));
              }
              //<< . . . ;SET $PIECE(YFKEY,",",YLFN)=$PIECE(YSATZ,Y,15),$PIECE(YKEY,",",YLFN)=$PIECE(YSATZ,Y,15),YINHALT=$PIECE(YSATZ,Y,15)
              //<< . . . if (YTYP=1)||(YTYP=7)               set YINHALT=$$GetInternal^WWWTR(YTYP,YINHALT)  ;DATUM/UHRZEITVORGABE
              if ((mOp.Equal(YTYP.get(),1)) || (mOp.Equal(YTYP.get(),7))) {
                YINHALT.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YINHALT.get()));
              }
              //<< . . . if $extract($piece(YSATZ,Y,15))="@" set YINHALT=$get(@($extract($piece(YSATZ,Y,15),2,99))) set $piece(YFKEY,",",YLFN)=YINHALT set $piece(YKEY,",",YLFN)=YINHALT
              if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15)),"@")) {
                YINHALT.set(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),2,99)))));
                m$.pieceVar(m$.var("YFKEY"),",",m$.var("YLFN").get()).set(YINHALT.get());
                m$.pieceVar(m$.var("YKEY"),",",m$.var("YLFN").get()).set(YINHALT.get());
              }
            } while (false);
          }
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . set YLANGE = $piece(YDVOR,Y,4)   ; $$$WWW002InputSize()
        mVar YLANGE = m$.var("YLANGE");
        YLANGE.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),4));
        //<< . if $piece($get(^WWW121D(0,YFORM,YLFN,YM,1)),Y,3)'="" set YLANGE=$piece($get(^WWW121D(0,YFORM,YLFN,YM,1)),Y,3)  ;MANDANTENVORGABE
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YLFN").get(),m$.var("YM").get(),1)),m$.var("Y").get(),3),"")) {
          YLANGE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YLFN").get(),m$.var("YM").get(),1)),m$.var("Y").get(),3));
        }
        //<< . set YNAME0 = $piece(YSATZ,Y,27)  ;VOR TEXT   ;pre- Text
        YNAME0.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),27));
        //<< . ;SET YNAME1 = $PIECE(YSATZ,Y,28)  ;NACH TEXT  ;within Text ;SR16679
        //<< . set YNAME1 = $$$Text($$$WWW122TextBehindUserInputField(YSATZ))
        YNAME1.set(include.COMSYS.$$$Text(m$,include.WWWConst.$$$WWW122TextBehindUserInputField(m$,m$.var("YSATZ"))));
        //<< . set YNAME  = $piece(YDVOR,Y,2)   ;NORMALTEXT ;notation
        YNAME.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),2));
        //<< . set strLanguage=$$^WWWLANGU(YBED) ;BR014949
        strLanguage.set(m$.fnc$("WWWLANGU.main",m$.var("YBED").get()));
        //<< . if $data(^WWW0021(0,YDATEI,YLFN,strLanguage,1)) set YNAME=$piece(^WWW0021(0,YDATEI,YLFN,strLanguage,1),Y,1)  ;SPRACHENTEXT AUS KLASSENDEFINITION ;BR014949
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0021",0,YDATEI.get(),m$.var("YLFN").get(),strLanguage.get(),1)))) {
          YNAME.set(m$.Fnc.$piece(m$.var("^WWW0021",0,YDATEI.get(),m$.var("YLFN").get(),strLanguage.get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . if $data(^WWW1211(0,YFORM,YLFN,strLanguage,1))  set YNAME=$piece(^WWW1211(0,YFORM,YLFN,strLanguage,1),Y,1)   ;SPRACHENTEXT AUS FORMULARDEFINITION  ;FIS;11.03.05;27434 ;BR014949
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1211",0,m$.var("YFORM").get(),m$.var("YLFN").get(),strLanguage.get(),1)))) {
          YNAME.set(m$.Fnc.$piece(m$.var("^WWW1211",0,m$.var("YFORM").get(),m$.var("YLFN").get(),strLanguage.get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . set YPARA(12)   = $$$WWW003SortTheRelation(YDVOR)
        YPARA.var(12).set(include.WWWConst.$$$WWW003SortTheRelation(m$,YDVOR));
        //<< . set YPARA(1)    = $$$WWW003RelationDatabase(YDVOR)        ;RELATIONEN
        YPARA.var(1).set(include.WWWConst.$$$WWW003RelationDatabase(m$,YDVOR));
        //<< . set YPARA(2)    = $$$WWW003RelationalPrimaryKeys(YDVOR)   ;PARAMETER
        YPARA.var(2).set(include.WWWConst.$$$WWW003RelationalPrimaryKeys(m$,YDVOR));
        //<< . set YPARA(3)    = $$$WWW003RelationalDisplayItems(YDVOR)  ;DATENFELD ;data item
        YPARA.var(3).set(include.WWWConst.$$$WWW003RelationalDisplayItems(m$,YDVOR));
        //<< . set YPARA(20)   = $$$WWW003RelationDisplayOptions(YDVOR)
        YPARA.var(20).set(include.WWWConst.$$$WWW003RelationDisplayOptions(m$,YDVOR));
        //<< . set YPARA(33)   = $$$WWW003DisplayIfSortKeyEqual(YDVOR)   ;ZUGRIFF AUF SORTKEY ;upon
        YPARA.var(33).set(include.WWWConst.$$$WWW003DisplayIfSortKeyEqual(m$,YDVOR));
        //<< . set YPARA("CF") = $$$WWW003CalcRelationalDisplayItems(YDVOR)  ;Calculated Display Fields          //SR16663
        YPARA.var("CF").set(include.WWWConst.$$$WWW003CalcRelationalDisplayItems(m$,YDVOR));
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ;  Relation Class
        //<< . ;     D15     $$$WWW121DefaultVariableInput()
        //<< . ;     D29     $$$WWW121DisplayIfSORTKeys()
        //<< . ;     D31     -
        //<< . ;     D32     $$$WWW121RelationClass()
        //<< . ;     D33     $$$WWW121RelationPrimaryKeys()
        //<< . ;     D34     $$$WWW121RelationalDisplayItems()
        //<< . ;     D35     $$$WWW121RelationDisplayOptions()
        //<< . ;     D62     -                                    $$$WWW122SortTheRelation()
        //<< . ;     D63     $$$WWW121SequenceOfRelationFields()
        //<< . ;     D67     $$$WWW121ResultTransferIntoAField()
        //<< . ;     D79     $$$WWW121RelationalItemToMark()
        //<< . ;-------------------------------------
        //<< . if $piece(YSATZ,Y,32)'="" do
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),32),"")) {
          //<< . . set YPARA(12)   = $piece(YSATZ,Y,62)                    ;REL SORTIEREN ;assortment
          YPARA.var(12).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),62));
          //<< . . set YPARA(1)    = $$$WWW121RelationClass(YSATZ)         ;RELDATEI AUS FORMULAR DEV ;out of form     ; SR15563
          YPARA.var(1).set(include.WWWConst.$$$WWW121RelationClass(m$,m$.var("YSATZ")));
          //<< . . set YPARA(2)    = $piece(YSATZ,Y,33)                    ;KEY F. RELATION
          YPARA.var(2).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),33));
          //<< . . set YPARA(3)    = $piece(YSATZ,Y,34)                    ;FELDER
          YPARA.var(3).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),34));
          //<< . . set YPARA(33)   = $piece(YSATZ,Y,31)                    ;ZUGRIFF AUF SORTKEY ;upon
          YPARA.var(33).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),31));
          //<< . . set YPARA("CF") = $$$WWW121CalcRelationalDisplayItems(YSATZ)  ;Calculated Display Fields            //SR16663
          YPARA.var("CF").set(include.WWWConst.$$$WWW121CalcRelationalDisplayItems(m$,m$.var("YSATZ")));
          //<< . . if $piece(YSATZ,Y,63)'="" set YPARA(3) = $piece(YSATZ,Y,63)
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63),"")) {
            YPARA.var(3).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63));
          }
          //<< . . set YPARA(20)   = $$$WWW121RelationDisplayOptions(YSATZ)
          YPARA.var(20).set(include.WWWConst.$$$WWW121RelationDisplayOptions(m$,m$.var("YSATZ")));
        }
        //<< . ;
        //<< . set YPARA(67) = $$$WWW121ResultTransferIntoAField(YSATZ)
        YPARA.var(67).set(include.WWWConst.$$$WWW121ResultTransferIntoAField(m$,m$.var("YSATZ")));
        //<< . set YPARA(79) = $piece(YSATZ,Y,79)                        ;RELATIONSFELD FÜR MARKIERUNG ;to
        YPARA.var(79).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),79));
        //<< . ;
        //<< . set YPARA(80) = ""                                        ;WELCHE FELDER MARKIEREN ;who
        YPARA.var(80).set("");
        //<< . set YSPAL     = $piece(YSATZ,Y,4)                             ;WELCHE SPALTE ;who rift
        mVar YSPAL = m$.var("YSPAL");
        YSPAL.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),4));
        //<< . set YINHALT   = $translate($piece(YKEY,",",YLFN),"""")  ;Default for field - Internal Format
        YINHALT.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YKEY").get(),",",m$.var("YLFN").get()),"\""));
        //<< . if $piece($get(^WWW121D(0,YFORM,YLFN,YM,1)),Y,1)'="" set $piece(YSATZ,Y,15) = $piece(^WWW121D(0,YFORM,YLFN,YM,1),Y,1)  ;MANDANTENVORGABE
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YLFN").get(),m$.var("YM").get(),1)),m$.var("Y").get(),1),"")) {
          m$.pieceVar(m$.var("YSATZ"),m$.var("Y").get(),15).set(m$.Fnc.$piece(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YLFN").get(),m$.var("YM").get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . if $piece($get(^WWW121D(0,YFORM,YLFN,YM,1)),Y,63)'="" do  ;MANDANTENVORGABE RELATION;TYBD:2,09,2003;23892
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YLFN").get(),m$.var("YM").get(),1)),m$.var("Y").get(),63),"")) {
          //<< . . set YPARA(3) = $translate($piece(^WWW121D(0,YFORM,YLFN,YM,1),Y,63),",",";")
          YPARA.var(3).set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YLFN").get(),m$.var("YM").get(),1).get(),m$.var("Y").get(),63),",",";"));
          //<< . . set $piece(YDVOR,Y,10)=YPARA(3)
          m$.pieceVar(YDVOR,m$.var("Y").get(),10).set(YPARA.var(3).get());
        }
        //<< . ;
        //<< . // TODO JW - Change to use CalculateString^WWWFORMD
        //<< . ;-------------------------------------
        //<< . ;  D15    WWW121  Default Variable Input
        //<< . ;
        //<< . ;  @string
        //<< . ;     e.g. @"dataLocn" sets YINHALT to contents of dataLocn
        //<< . ;          @dataLocn   sets YINHALT to contents of variable/global contained in dataLocn
        //<< . ;  @$string
        //<< . ;  @#string
        //<< . ;     e.g. @#"dataLocn" sets YINHALT to string dataLocn
        //<< . ;          @#dataLocn   sets YINHALT to contents of dataLocn
        //<< . ;-------------------------------------
        //<< . if YINHALT="" set YINHALT = $piece(YSATZ,Y,15) if $extract(YINHALT)="@" do
        if (mOp.Equal(YINHALT.get(),"")) {
          YINHALT.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15));
          if (mOp.Equal(m$.Fnc.$extract(YINHALT.get()),"@")) {
            do {
              //<< . . if $extract(YINHALT,2)'="$" if $extract(YINHALT,2)'="#"   set YINHALT = $get(@($extract($piece(YSATZ,Y,15),2,99))) quit
              if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"$")) {
                if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"#")) {
                  YINHALT.set(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),2,99)))));
                  break;
                }
              }
              //<< . . new YINHALT1
              mVar YINHALT1 = m$.var("YINHALT1");
              m$.newVarBlock(2,YINHALT1);
              //<< . . if ($extract(YINHALT,2)="$") || ($extract(YINHALT,2)="#") set YINHALT1 = "S YINHALT="_$extract($piece(YSATZ,Y,15),2,99) xecute YINHALT1
              if ((mOp.Equal(m$.Fnc.$extract(YINHALT.get(),2),"$")) || (mOp.Equal(m$.Fnc.$extract(YINHALT.get(),2),"#"))) {
                YINHALT1.set(mOp.Concat("S YINHALT=",m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),2,99)));
                m$.Cmd.Xecute(YINHALT1.get());
              }
            } while (false);
          }
          m$.restoreVarBlock(2);
        }
        //<< . ;
        //<< . set YGROUP=1
        mVar YGROUP = m$.var("YGROUP");
        YGROUP.set(1);
        //<< . if YTYP=0 if $get(YSAVEDDATA)'=1 if +$piece(YSATZ,Y,16)=0   set YINHALT = $piece(YSATZ,Y,15) if $extract(YINHALT)="@" do
        if (mOp.Equal(YTYP.get(),0)) {
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YSAVEDDATA")),1)) {
            if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16)),0)) {
              YINHALT.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15));
              if (mOp.Equal(m$.Fnc.$extract(YINHALT.get()),"@")) {
                //<< . . if ($extract(YINHALT,2)'="$") && ($extract(YINHALT,2)'="#") do
                if ((mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"$")) && (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"#"))) {
                  //<< . . . set YINHALT = $get(@($extract($piece(YSATZ,Y,15),2,99)))
                  YINHALT.set(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),2,99)))));
                  //<< . . . set $piece(YFKEY,",",YLFN) = YINHALT
                  m$.pieceVar(m$.var("YFKEY"),",",m$.var("YLFN").get()).set(YINHALT.get());
                  //<< . . . set $piece(YKEY,",",YLFN)  = YINHALT
                  m$.pieceVar(m$.var("YKEY"),",",m$.var("YLFN").get()).set(YINHALT.get());
                }
                //<< . . ;
                //<< . . if ($extract(YINHALT,2)="$") || ($extract(YINHALT,2)'="#") do
                if ((mOp.Equal(m$.Fnc.$extract(YINHALT.get(),2),"$")) || (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"#"))) {
                  //<< . . . new YINHALT1
                  mVar YINHALT1 = m$.var("YINHALT1");
                  m$.newVarBlock(3,YINHALT1);
                  //<< . . . set YINHALT1 = "S YINHALT="_$extract($piece(YSATZ,Y,15),2,99)
                  YINHALT1.set(mOp.Concat("S YINHALT=",m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),2,99)));
                  //<< . . . xecute YINHALT1
                  m$.Cmd.Xecute(YINHALT1.get());
                  //<< . . . set $piece(YFKEY,",",YLFN) = YINHALT
                  m$.pieceVar(m$.var("YFKEY"),",",m$.var("YLFN").get()).set(YINHALT.get());
                  //<< . . . set $piece(YKEY,",",YLFN)  = YINHALT
                  m$.pieceVar(m$.var("YKEY"),",",m$.var("YLFN").get()).set(YINHALT.get());
                }
                m$.restoreVarBlock(3);
              }
            }
          }
        }
        //<< . ;
        //<< . if $piece(YSATZ,Y,21)'="" if +$piece(YSATZ,Y,21)=0 set @($piece(YSATZ,Y,21)) = YINHALT
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21),"")) {
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21)),0)) {
            m$.indirectVar((m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21))).set(YINHALT.get());
          }
        }
        //<< . if YFOART'=7 if ($piece(YSATZ,Y,2)=1) || (YTYP=9) if YINHALT="" set YINHALT = "+"  ;AUTOM LFN
        if (mOp.NotEqual(m$.var("YFOART").get(),7)) {
          if ((mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),2),1)) || (mOp.Equal(YTYP.get(),9))) {
            if (mOp.Equal(YINHALT.get(),"")) {
              YINHALT.set("+");
            }
          }
        }
        //<< . ;
        //<< . ;-------------------------------------  *** EXECUTE ***
        //<< . ;  D26 : ExecuteOnLoad (P/D)
        //<< . ;-------------------------------------
        //<< . if $piece(YSATZ,Y,26)'="" xecute $piece(YSATZ,Y,26)  ;EXECUTE BEI ONLOAD (YINHALT) ;EXECUTE next to
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),26),"")) {
          m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),26));
        }
        //<< . if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onLoad.OBJ",$get(YUCI)) xecute "DO ^Y"_YFORM_YART_YLFN_"onLoad"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
        if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onLoad.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
          m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onLoad"));
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ;
        //<< . if YFORM="WWW127" set YHID=1
        if (mOp.Equal(m$.var("YFORM").get(),"WWW127")) {
          YHID.set(1);
        }
        //<< . if $data(^WWW129(0,YFORM,YLFN)) set YJAVA=1
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW129",0,m$.var("YFORM").get(),m$.var("YLFN").get())))) {
          YJAVA.set(1);
        }
        //<< . if +$get(YHID)=0 if $get(YFELD)'="" do         ;Primärschluessel ohne Änderung ;Without Modify Only
        if (mOp.Equal(mOp.Positive(m$.Fnc.$get(YHID)),0)) {
          if (mOp.NotEqual(m$.Fnc.$get(YFELD),"")) {
            do {
              //<< . . ;IF YFOART'=3 IF YFELD="" QUIT               ;WENN NICHT GRID DANN NUR, WENN DATENSATZ ANGEZEIGT
              //<< . . if $get(YSAVEDDATA)=1 set YHID=2 quit        ;NEU FÜR ANZEIGE SEITENWECHSEL BEI NICHT GESPEICHERTEN DATEN  ;recent to Show next to Not
              if (mOp.Equal(m$.Fnc.$get(m$.var("YSAVEDDATA")),1)) {
                YHID.set(2);
                break;
              }
            } while (false);
          }
        }
        //<< . . ;IF $TRANSLATE($PIECE(YKEY,",",YLFN),"""")'="" IF $TRANSLATE($PIECE(YKEY,",",YLFN),"""")'="+" SET YHID=2  ;KEIN KOPIEREN
        //<< . ;
        //<< . if YINHALT'="" set $piece(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"P",1),",",YLFN)=YINHALT
        if (mOp.NotEqual(YINHALT.get(),"")) {
          m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1),",",m$.var("YLFN").get()).set(YINHALT.get());
        }
        //<< . ;
        //<< . //IF YHID=1 DO  ;TYBD 20.02.2002  SR14421 - Should not convert...
        //<< . //. IF (YTYP=1) || (YTYP=7) SET YINHALT = $$GetLiteral^WWWTR(YTYP,YINHALT)  ;Date/Time ;Convert to External Format
        //<< . ;
        //<< . if YXTYP=15 do
        if (mOp.Equal(YXTYP.get(),15)) {
          //<< . . if (YTYP=1) || (YTYP=7) set YINHALT = $$GetLiteral^WWWTR(YTYP,YINHALT)  ;DATUM/UHRZEITVORGABE
          if ((mOp.Equal(YTYP.get(),1)) || (mOp.Equal(YTYP.get(),7))) {
            YINHALT.set(m$.fnc$("WWWTR.GetLiteral",YTYP.get(),YINHALT.get()));
          }
          //<< . . set YTYP=0  ;UNSICHTBAR ;viewless
          YTYP.set(0);
        }
        //<< . ;
        //<< . if $piece(YSATZ,Y,16)=0 do
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),0)) {
          //<< . . if (YTYP=1) || (YTYP=7) set YINHALT = $$GetLiteral^WWWTR(YTYP,YINHALT)        ;DATUM/UHRZEITVORGABE
          if ((mOp.Equal(YTYP.get(),1)) || (mOp.Equal(YTYP.get(),7))) {
            YINHALT.set(m$.fnc$("WWWTR.GetLiteral",YTYP.get(),YINHALT.get()));
          }
          //<< . . if (+$piece(YSATZ,Y,104)=0) || ($piece(YSATZ,Y,104)=15) set YTYP = 0  ;UNSICHTBAR ;viewless
          if ((mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),104)),0)) || (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),104),15))) {
            YTYP.set(0);
          }
        }
        //<< . ;
        //<< . do Start^WWWFORM7($$$YES)
        m$.Cmd.Do("WWWFORM7.Start",include.COMSYS.$$$YES(m$));
        //<< . ;
        //<< . ; Form Type 1 : Standard
        //<< . ;-------------------------------------
        //<< . if YFOART=1 do  ;ANZEIGE FELDER BEI MEHREREN SEITEN ;Show next to sidelong
        if (mOp.Equal(m$.var("YFOART").get(),1)) {
          //<< . . new YI
          m$.newVarBlock(2,YI);
          //<< . . if ($piece(YDVOR,Y,8)="") || ($piece(YDVOR,Y,8)=YDATEI) do
          if ((mOp.Equal(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),8),"")) || (mOp.Equal(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),8),YDATEI.get()))) {
            //<< . . . if $get(YPARA(3))'="" set $piece(YDVOR,Y,10) = $translate(YPARA(3),",",";")   ;MULTIPLE ANZEIGE NACH PRIMÄRSCHLÜSSEL;TYBD;30,7,2004;26192
            if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(3)),"")) {
              m$.pieceVar(YDVOR,m$.var("Y").get(),10).set(m$.Fnc.$translate(YPARA.var(3).get(),",",";"));
            }
            //<< . . . if $piece(YDVOR,Y,10)'="" do
            if (mOp.NotEqual(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),10),"")) {
              //<< . . . . set YI(2)=""
              YI.var(2).set("");
              //<< . . . . write "<FONT SIZE=2>"
              m$.Cmd.Write("<FONT SIZE=2>");
              //<< . . . . if $piece($get(YVOR1),Y,95)=1 write YCR,"<STRONG><B>"      ; $$$WWW012PrimaryKeyFatRepresent()
              if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR1")),m$.var("Y").get(),95),1)) {
                m$.Cmd.Write(m$.var("YCR").get(),"<STRONG><B>");
              }
              //<< . . . . for YI=1:1 set YI(1)=$piece($piece(YDVOR,Y,10),";",YI) quit:YI(1)=""  do
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                YI.var(1).set(m$.Fnc.$piece(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),10),";",YI.get()));
                if (mOp.Equal(YI.var(1).get(),"")) {
                  break;
                }
                //<< . . . . . set YI(3)=$piece($get(YFELD),Y,YI(1))
                YI.var(3).set(m$.Fnc.$piece(m$.Fnc.$get(YFELD),m$.var("Y").get(),YI.var(1).get()));
                //<< . . . . . if YI'=1 if YI(2)'="" if YI(3)'="" set YI(2)=YI(2)_", "  ;TYBD;22.07.2003;ZU VIELE ,
                if (mOp.NotEqual(YI.get(),1)) {
                  if (mOp.NotEqual(YI.var(2).get(),"")) {
                    if (mOp.NotEqual(YI.var(3).get(),"")) {
                      YI.var(2).set(mOp.Concat(YI.var(2).get(),", "));
                    }
                  }
                }
                //<< . . . . . set YI(2)=YI(2)_YI(3)
                YI.var(2).set(mOp.Concat(YI.var(2).get(),YI.var(3).get()));
              }
              //<< . . . . ;
              //<< . . . . write "&nbsp;",YI(2)                                       ; YI(2) = Primary Keys List
              m$.Cmd.Write("&nbsp;",YI.var(2).get());
              //<< . . . . if $piece($get(YVOR1),Y,95)=1 write YCR,"</STRONG></B>"
              if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR1")),m$.var("Y").get(),95),1)) {
                m$.Cmd.Write(m$.var("YCR").get(),"</STRONG></B>");
              }
            }
          }
        }
        m$.restoreVarBlock(2);
      } while (false);
    }
    //<< . ;
    //<< . ;VVV BR014501
    //<< . ;IF $PIECE(YSATZ,Y,97)'="" WRITE " " XECUTE $PIECE(YSATZ,Y,97)  ;execute hinter feld ;posterior
    //<< . ;IF $$EXIST^%R("Y"_YFORM_YART_YLFN_"onBehind.OBJ",$GET(YUCI)) WRITE " " XECUTE "DO ^Y"_YFORM_YART_YLFN_"onBehind"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
    //<< 
    //<< 
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Data Fields
    //<< ;   YSATZ           WWW122
    //<< ;   YXTYP       D5      InputType                   ^WWW100("FELDTYP")
    //<< ;   YINHALT     D16     FixedInputForHiddenField
    //<< ;               D120    InputInVariable
    //<< ;               D63     RelationFieldSequence
    //<< ;
    //<< ;   YDVOR           WWW003
    //<< ;   YTYPE       D3      InputType                   ^WWW100("FELDTYP")
    //<< ;               D8      RelationDatabase
    //<< ;               D9      RelationalPrimaryKeys
    //<< ;               D10     RelationalDisplayItems
    //<< ;               D21     DisplayIfSortKeyEqual
    //<< ;-------------------------------------------------------------------------------
    //<< ;I YART="D"!(YART="M") I YOPTION'="" I $P(YSATZ,Y,50)'="" I $E($P(YSATZ,Y,50))'="'" I '$F(","_$P(YSATZ,Y,50)_",",","_YOPTION_",")         S YHIDDSE=1  ;FALSCHE OPTION
    //<< ;I YART="D"!(YART="M") I YOPTION'="" I $P(YSATZ,Y,50)'="" I $E($P(YSATZ,Y,50))="'"  I $F(","_$E($P(YSATZ,Y,50),2,90)_",",","_YOPTION_",") S YHIDDSE=1  ;FALSCHE NICHT OPTION
    //<< ;I YART="D"!(YART="M") I YPARA1'=""  I $P(YSATZ,Y,51)'="" I $E($P(YSATZ,Y,51))'="'" I '$F(","_$P(YSATZ,Y,51)_",",","_YPARA1_",")          S YHIDDSE=1  ;FALSCHE OPTION
    //<< ;I YART="D"!(YART="M") I YPARA1'=""  I $P(YSATZ,Y,51)'="" I $E($P(YSATZ,Y,51))="'"  I $F(","_$E($P(YSATZ,Y,51),2,90)_",",","_YPARA1_",")  S YHIDDSE=1  ;FALSCHE NICHT OPTION
    //<< 
    //<< if YART="D" do
    if (mOp.Equal(m$.var("YART").get(),"D")) {
      do {
        //<< . set YDATEI = $piece($get(^WWW120(0,YFORM,1)),Y,11)   quit:YDATEI=""
        mVar YDATEI = m$.var("YDATEI");
        YDATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),11));
        if (mOp.Equal(YDATEI.get(),"")) {
          break;
        }
        //<< . set YDVOR = $get(^WWW003(0,YDATEI,YLFN,1))           quit:YDVOR=""  ;DATEN AUS FELDDEV ;out of
        mVar YDVOR = m$.var("YDVOR");
        YDVOR.set(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),m$.var("YLFN").get(),1)));
        if (mOp.Equal(YDVOR.get(),"")) {
          break;
        }
        //<< . ;
        //<< . set YTYP = $piece(YDVOR,Y,3)   ;ERFASSUNGSART
        YTYP.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),3));
        //<< . if (YTYP=12) || (YTYP=18) if +YINHALT'=0 if $piece(YDVOR,Y,16)'="" set YINHALT=$justify(YINHALT,0,$piece(YDVOR,Y,16))  ;NACHKOMMASTELLEN  //SR13074
        if ((mOp.Equal(YTYP.get(),12)) || (mOp.Equal(YTYP.get(),18))) {
          if (mOp.NotEqual(mOp.Positive(YINHALT.get()),0)) {
            if (mOp.NotEqual(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),16),"")) {
              YINHALT.set(m$.Fnc.$justify(YINHALT.get(),0,m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),16)));
            }
          }
        }
        //<< . if $piece(YSATZ,Y,5)'="" set YTYP=$piece(YSATZ,Y,5)
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),5),"")) {
          YTYP.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),5));
        }
        //<< . set YXTYP=+$piece(YSATZ,Y,2)         ;ERFASSUNGSART AUS FORMULARFELD ;TYPE OF ACQUISITION FROM FORM FIELD
        YXTYP.set(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),2)));
        //<< . if YXTYP=15 set YTYP=0               ;UNSICHTBAR ;hidden
        if (mOp.Equal(YXTYP.get(),15)) {
          YTYP.set(0);
        }
        //<< . if $piece(YSATZ,Y,16)'="" do         ;FESTE VORGABE ;default
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),"")) {
          //<< . . set YHID=1                         ;UNSICHTBAR ;hidden
          YHID.set(1);
          //<< . . set YINHALT = $piece(YSATZ,Y,16)
          YINHALT.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16));
          //<< . . if (YTYP=1) || (YTYP=7) if $extract(YINHALT)'="@" set YINHALT=$$GetInternal^WWWTR(YTYP,YINHALT)  ;DATUM/UHRZEITVORGABE ;DATE/TIME DEFAULT
          if ((mOp.Equal(YTYP.get(),1)) || (mOp.Equal(YTYP.get(),7))) {
            if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get()),"@")) {
              YINHALT.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YINHALT.get()));
            }
          }
          //<< . . if $extract(YINHALT)="@" do
          if (mOp.Equal(m$.Fnc.$extract(YINHALT.get()),"@")) {
            do {
              //<< . . . if $extract(YINHALT,2)'="$" if $extract(YINHALT,2)'="#" set YINHALT=$get(@($extract($piece(YSATZ,Y,16),2,99))) quit
              if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"$")) {
                if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"#")) {
                  YINHALT.set(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),2,99)))));
                  break;
                }
              }
              //<< . . . new YINHALT1
              mVar YINHALT1 = m$.var("YINHALT1");
              m$.newVarBlock(3,YINHALT1);
              //<< . . . set YINHALT1="S YINHALT="_$extract($piece(YSATZ,Y,16),2,99)
              YINHALT1.set(mOp.Concat("S YINHALT=",m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),2,99)));
              //<< . . . xecute YINHALT1
              m$.Cmd.Xecute(YINHALT1.get());
            } while (false);
          }
          m$.restoreVarBlock(3);
        }
        //<< . ;
        //<< . set YLANGE=$piece(YDVOR,Y,4)               ;FELDLENGE
        mVar YLANGE = m$.var("YLANGE");
        YLANGE.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),4));
        //<< . if +$piece(YSATZ,Y,6)'=0 set YLANGE=$piece(YSATZ,Y,6)
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),6)),0)) {
          YLANGE.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),6));
        }
        //<< . ;-----
        //<< . set YNAME0 = $piece(YSATZ,Y,27)            ;TEXT VOR ;Text pre-
        YNAME0.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),27));
        //<< . ;SET YNAME1 = $PIECE(YSATZ,Y,28)            ;TEXT NACH ;Text within
        //<< . set YNAME1=$$$Text($$$WWW122TextBehindUserInputField(YSATZ)) ;16679
        YNAME1.set(include.COMSYS.$$$Text(m$,include.WWWConst.$$$WWW122TextBehindUserInputField(m$,m$.var("YSATZ"))));
        //<< . set YNAME  = $piece(YDVOR,Y,2)             ;NORMALTEXT
        YNAME.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),2));
        //<< . set strLanguage = $$^WWWLANGU(YBED)          // SR14914
        strLanguage.set(m$.fnc$("WWWLANGU.main",m$.var("YBED").get()));
        //<< . if $data(^WWW0031(0,YDATEI,YLFN,strLanguage,1)) set YNAME = $piece(^WWW0031(0,YDATEI,YLFN,strLanguage,1),Y,1)  ;SPRACHENTEXT AUS KLASSENDEFINITION // SR14914
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,YDATEI.get(),m$.var("YLFN").get(),strLanguage.get(),1)))) {
          YNAME.set(m$.Fnc.$piece(m$.var("^WWW0031",0,YDATEI.get(),m$.var("YLFN").get(),strLanguage.get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . if $data(^WWW1221(0,YFORM,YBBN,strLanguage,1))  set YNAME = $piece(^WWW1221(0,YFORM,YBBN,strLanguage,1),Y,1)   ;SPRACHENTEXT AUS FORMULARDEFINITION  ;FIS;11.03.05;27434 // SR14914
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1221",0,m$.var("YFORM").get(),m$.var("YBBN").get(),strLanguage.get(),1)))) {
          YNAME.set(m$.Fnc.$piece(m$.var("^WWW1221",0,m$.var("YFORM").get(),m$.var("YBBN").get(),strLanguage.get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . ;-----
        //<< . set YPARA(12)=$piece(YDVOR,Y,7)            ;RELATION SORTIEREN ;assortment
        YPARA.var(12).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),7));
        //<< . if $piece(YDVOR,Y,29)=$$$YES set YPARA(29)=-1   ;RELATION ABSTEIGEND WENN =1  ;when
        if (mOp.Equal(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),29),include.COMSYS.$$$YES(m$))) {
          YPARA.var(29).set(mOp.Negative(1));
        }
        //<< . set YPARA(1)   = $piece(YDVOR,Y,8)         ;RELATIONSDATEI  AUS DATEIDEV ;out of
        YPARA.var(1).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),8));
        //<< . set YPARA(33)  = $piece(YDVOR,Y,21)        ;ZUGRIFF AUF SORTKEY ;upon
        YPARA.var(33).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),21));
        //<< . set YPARA(2)   = $piece(YDVOR,Y,9)         ;REL KEY
        YPARA.var(2).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),9));
        //<< . set YPARA(3)   = $piece(YDVOR,Y,10)        ;REL FELD ;field
        YPARA.var(3).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),10));
        //<< . set YPARA(120) = $piece(YSATZ,Y,120)       ;KEY NICHT ANZEIGEN ;KEY Not display
        YPARA.var(120).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),120));
        //<< . if $piece(YSATZ,Y,63)'="" set YPARA(3)=$piece(YSATZ,Y,63)
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63),"")) {
          YPARA.var(3).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63));
        }
        //<< . set YPARA(20)=$piece(YDVOR,Y,20)           ;ERST SPÄTER ANZEIGEN ;only subsequent display
        YPARA.var(20).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),20));
        //<< . set YPARA("CF") = $$$WWW003CalcRelationalDisplayItems(YDVOR)  ;Calculated Display Fields          //SR16663
        YPARA.var("CF").set(include.WWWConst.$$$WWW003CalcRelationalDisplayItems(m$,YDVOR));
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ;  Relation Class
        //<< . ;     D29     $$$WWW122DisplayRelationsDownwards()
        //<< . ;     D31     $$$WWW122DisplayIfSortCodes()
        //<< . ;     D32     $$$WWW122RelationClass()
        //<< . ;     D33     $$$WWW122RelationalPrimaryKey()
        //<< . ;     D34     $$$WWW122RelationalDataField()
        //<< . ;     D35     $$$WWW122RelationDisplayOptions()
        //<< . ;     D62     $$$WWW122SortTheRelation()
        //<< . ;     D63     $$$WWW122RelationFieldSequence()
        //<< . ;     D67     $$$WWW122RelationSendToField()
        //<< . ;     D79     $$$WWW122RelationalItemToMark()
        //<< . ;-------------------------------------
        //<< . if $piece(YSATZ,Y,32)'="" do
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),32),"")) {
          //<< . . set YPARA(12) = $piece(YSATZ,Y,62)       ;REL SORTIEREN ;assortment
          YPARA.var(12).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),62));
          //<< . . set YPARA(1)  = $piece(YSATZ,Y,32)       ;RELDATEI AUS FORMULAR DEV ;out of form
          YPARA.var(1).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),32));
          //<< . . set YPARA(2)  = $piece(YSATZ,Y,33)       ;KEY F. RELATION
          YPARA.var(2).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),33));
          //<< . . set YPARA(3)  = $piece(YSATZ,Y,34)       ;FELDER
          YPARA.var(3).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),34));
          //<< . . set YPARA(33) = $piece(YSATZ,Y,31)       ;ZUGRIFF AUF SORTKEY ;upon
          YPARA.var(33).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),31));
          //<< . . if $piece(YSATZ,Y,63)'="" set YPARA(3)=$piece(YSATZ,Y,63)
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63),"")) {
            YPARA.var(3).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63));
          }
          //<< . . set YPARA(20) = $piece(YSATZ,Y,35)        ;ERST SPÄTER ANZEIGEN ;only subsequent display
          YPARA.var(20).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),35));
          //<< . . if $piece(YSATZ,Y,29)=1 set YPARA(29)=-1  ;RELATION ABSTEIGEND WENN =1  ;when
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),29),1)) {
            YPARA.var(29).set(mOp.Negative(1));
          }
        }
        //<< . ;
        //<< . set YPARA(67)=$piece(YSATZ,Y,67)  ;NEUES FELD AUS EVENT BROKER ;something new field out of
        YPARA.var(67).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),67));
        //<< . set YPARA(79)=$piece(YSATZ,Y,79)  ;RELATIONSFELD FÜR MARKIERUNG ;to
        YPARA.var(79).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),79));
        //<< . set YPARA(80)="" ;WELCHE FELDER MARKIEREN ;who
        YPARA.var(80).set("");
        //<< . ;
        //<< . ;----- Manual Option Class
        //<< . if $data(^WWW1251(0,YFORM,YBBN)) do   ;SEKEKTIONEN SONDER
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1251",0,m$.var("YFORM").get(),m$.var("YBBN").get())))) {
          //<< . . set YXTYP = +$piece($get(^WWW1251(0,YFORM,YBBN,1,1)),Y,2)
          YXTYP.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1251",0,m$.var("YFORM").get(),m$.var("YBBN").get(),1,1)),m$.var("Y").get(),2)));
          //<< . . set YPARA(12) = 0               ;SORTIERUNG PARA ;sorting
          YPARA.var(12).set(0);
          //<< . . set YPARA(1)  = "WWW1251"
          YPARA.var(1).set("WWW1251");
          //<< . . set YPARA(2)  = """"_YFORM_""","""_YBBN_""""
          YPARA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("\"",m$.var("YFORM").get()),"\",\""),m$.var("YBBN").get()),"\""));
          //<< . . set YPARA(3)  = 1
          YPARA.var(3).set(1);
        }
        //<< . ;
        //<< . set YSPAL = $piece(YSATZ,Y,4)   ;SPALTEN VORGABE ;split default
        mVar YSPAL = m$.var("YSPAL");
        YSPAL.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),4));
        //<< . if $piece(YFELD,Y,YLFN)'="" set YINHALT = $piece(YFELD,Y,YLFN)   ;FELDINHALT
        if (mOp.NotEqual(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.var("YLFN").get()),"")) {
          YINHALT.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.var("YLFN").get()));
        }
        //<< . if YTYP=9 if YINHALT=""     set YINHALT = "+"                        ;AUTOM LFN
        if (mOp.Equal(YTYP.get(),9)) {
          if (mOp.Equal(YINHALT.get(),"")) {
            YINHALT.set("+");
          }
        }
        //<< . if YLFN=1 if $order(^WWW003(0,YDATEI,YLFN))="" if $piece($get(^WWW003(0,YDATEI,YLFN,1)),Y,3)=3 set YINHALT = $piece(YFELD,Y,YLFN,9999)  ;TEXT
        if (mOp.Equal(m$.var("YLFN").get(),1)) {
          if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW003",0,YDATEI.get(),m$.var("YLFN").get())),"")) {
            if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),3),3)) {
              YINHALT.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.var("YLFN").get(),9999));
            }
          }
        }
        //<< . ;-------------------------------------
        //<< . ;  D15    WWW122  Default Variable Input
        //<< . ;
        //<< . ;  @string, @$string, @#string   See explanation above under WWW121
        //<< . ;-------------------------------------
        //<< . if YBEARB=1 if YINHALT="" do
        if (mOp.Equal(m$.var("YBEARB").get(),1)) {
          if (mOp.Equal(YINHALT.get(),"")) {
            //<< . . set YINHALT = $piece(YSATZ,Y,15)
            YINHALT.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15));
            //<< . . if (YTYP=1) || (YTYP=7) if $extract(YINHALT)'="@" set YINHALT=$$GetInternal^WWWTR(YTYP,YINHALT)  ;DATUM/UHRZEITVORGABE
            if ((mOp.Equal(YTYP.get(),1)) || (mOp.Equal(YTYP.get(),7))) {
              if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get()),"@")) {
                YINHALT.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YINHALT.get()));
              }
            }
            //<< . . if $extract(YINHALT)="@" do
            if (mOp.Equal(m$.Fnc.$extract(YINHALT.get()),"@")) {
              do {
                //<< . . . if $extract(YINHALT,2)'="$" if $extract(YINHALT,2)'="#" set YINHALT=$get(@($extract($piece(YSATZ,Y,15),2,99))) quit
                if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"$")) {
                  if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"#")) {
                    YINHALT.set(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),2,99)))));
                    break;
                  }
                }
                //<< . . . new YINHALT1
                mVar YINHALT1 = m$.var("YINHALT1");
                m$.newVarBlock(3,YINHALT1);
                //<< . . . set YINHALT1="S YINHALT="_$extract($piece(YSATZ,Y,15),2,99)
                YINHALT1.set(mOp.Concat("S YINHALT=",m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),2,99)));
                //<< . . . xecute YINHALT1
                m$.Cmd.Xecute(YINHALT1.get());
                //<< . . . if (YTYP=1) || (YTYP=7) set YINHALT=$$GetInternal^WWWTR(YTYP,YINHALT)  ;DATUM/UHRZEITVORGABE
                if ((mOp.Equal(YTYP.get(),1)) || (mOp.Equal(YTYP.get(),7))) {
                  YINHALT.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YINHALT.get()));
                }
              } while (false);
            }
            m$.restoreVarBlock(3);
          }
        }
        //<< . ;
        //<< . ;-------------------------------------  *** EXECUTE ***
        //<< . ;  D26 : ExecuteOnLoad (D)
        //<< . ;-------------------------------------
        //<< . if $piece(YSATZ,Y,26)'="" xecute $piece(YSATZ,Y,26)  ;EXECUTE BEI ONLOAD (YINHALT) ;EXECUTE next to
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),26),"")) {
          m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),26));
        }
        //<< . if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onLoad.OBJ",$get(YUCI)) xecute "DO ^Y"_YFORM_YART_YLFN_"onLoad"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
        if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onLoad.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
          m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onLoad"));
        }
        //<< . ;
        //<< . ;
        //<< . if $get(YOLDVAL)="" set YOLDVAL=""  ;WERT NEBEN FELD ;value next to field
        if (mOp.Equal(m$.Fnc.$get(m$.var("YOLDVAL")),"")) {
          mVar YOLDVAL = m$.var("YOLDVAL");
          YOLDVAL.set("");
        }
        //<< . ;I YBEARB'=1 I YINHALT="" D
        //<< . ;. SET YOLDVAL=$PIECE(YSATZ,Y,15)
        //<< . ;. IF (YTYP=1) || (YTYP=7) SET YOLDVAL=$$GetInternal^WWWTR(YTYP,YOLDVAL)  ;DATUM/UHRZEITVORGABE
        //<< . ;. IF $EXTRACT(YOLDVAL)="@" IF $EXTRACT(YOLDVAL,2)'="$" SET YOLDVAL=$GET(@($EXTRACT($PIECE(YSATZ,Y,15),2,99)))
        //<< . ;
        //<< . ;IF $$^WWWACCESS($PIECE(YSATZ,Y,22),$PIECE(YSATZ,Y,24))'=1 SET YHIDDSE=1 SET YHID=2  ;KEINE BERECHTIGUNG
        //<< . if $$^WWWACCESS($piece(YDVOR,Y,14),"")'=1 set YHID=2  ;KEINE BERECHTIGUNG (DATEI) ;no
        if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),14),""),1)) {
          YHID.set(2);
        }
        //<< . ;
        //<< . if YKEY="" if YINHALT="" if $piece(YDVOR,Y,17)=$$$YES set YINHALT = $piece($get(^WWWDLF(0,YDATEI,YLFN,YBED,1)),Y,1)  ;VORGABE ;handicap  ;default
        if (mOp.Equal(m$.var("YKEY").get(),"")) {
          if (mOp.Equal(YINHALT.get(),"")) {
            if (mOp.Equal(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),17),include.COMSYS.$$$YES(m$))) {
              YINHALT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDLF",0,YDATEI.get(),m$.var("YLFN").get(),m$.var("YBED").get(),1)),m$.var("Y").get(),1));
            }
          }
        }
        //<< . ;
        //<< . ;-----
        //<< . if $$$WWW120AuthorizationToModifyData(YSATZ)=$$$EnumReadOnly          set YHID=2   ;FELDBERECHITIGUNG
        if (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YSATZ")),include.COMSYSEnum.$$$EnumReadOnly(m$))) {
          YHID.set(2);
        }
        //<< . if YBEARB'=1 if YBEARB'=6   if $piece(YSATZ,Y,23)=$$$EnumCreateOnly   set YHID=2   ;FELDBERECHITIGUNG
        if (mOp.NotEqual(m$.var("YBEARB").get(),1)) {
          if (mOp.NotEqual(m$.var("YBEARB").get(),6)) {
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),23),include.COMSYSEnum.$$$EnumCreateOnly(m$))) {
              YHID.set(2);
            }
          }
        }
        //<< . if (YBEARB=1) || (YBEARB=6) if $piece(YSATZ,Y,23)=$$$EnumModifyOnly   set YHID=2   ;FELDBERECHITIGUNG
        if ((mOp.Equal(m$.var("YBEARB").get(),1)) || (mOp.Equal(m$.var("YBEARB").get(),6))) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),23),include.COMSYSEnum.$$$EnumModifyOnly(m$))) {
            YHID.set(2);
          }
        }
        //<< . if $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly           set YHID=2   ;FELDBERECHTIGUNNG
        if (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$))) {
          YHID.set(2);
        }
        //<< . ;
        //<< . if ($piece(YSATZ,Y,42)'="") || ($piece(YSATZ,Y,44)'="") if $$^WWWACCESS($piece(YSATZ,Y,42),$piece(YSATZ,Y,44))=1 do    ;KEINE FELDBERECHTIGUNG ;no
        if ((mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),42),"")) || (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),44),""))) {
          if (mOp.Equal(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),42),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),44)),1)) {
            //<< //. if (($piece(YSATZ,Y,42)'="") || ($piece(YSATZ,Y,44)'="")) && ($$^WWWACCESS($piece(YSATZ,Y,42),$piece(YSATZ,Y,44))=1) do    ;KEINE FELDBERECHTIGUNG ;no
            //<< . . if $piece(YSATZ,Y,43)=$$$EnumReadOnly                               set YHID=2   ;FELDBERECHTIGUNNG
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),43),include.COMSYSEnum.$$$EnumReadOnly(m$))) {
              YHID.set(2);
            }
            //<< . . if YBEARB'=1 if YBEARB'=6   if $piece(YSATZ,Y,43)=$$$EnumCreateOnly set YHID=2   ;FELDBERECHITIGUNG
            if (mOp.NotEqual(m$.var("YBEARB").get(),1)) {
              if (mOp.NotEqual(m$.var("YBEARB").get(),6)) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),43),include.COMSYSEnum.$$$EnumCreateOnly(m$))) {
                  YHID.set(2);
                }
              }
            }
            //<< . . if (YBEARB=1) || (YBEARB=6) if $piece(YSATZ,Y,43)=$$$EnumModifyOnly set YHID=2   ;FELDBERECHITIGUNG
            if ((mOp.Equal(m$.var("YBEARB").get(),1)) || (mOp.Equal(m$.var("YBEARB").get(),6))) {
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),43),include.COMSYSEnum.$$$EnumModifyOnly(m$))) {
                YHID.set(2);
              }
            }
            //<< . . if +$piece(YSATZ,Y,43)<2                                            set YHID=0   ;FREIGABE
            if (mOp.Less(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),43)),2)) {
              YHID.set(0);
            }
          }
        }
        //<< . ;-----
        //<< . ;
        //<< . do IsInactive(YSATZ,YFELD,.YHID)  //SR13309 - moved into function
        m$.Cmd.Do("IsInactive",m$.var("YSATZ").get(),YFELD.get(),YHID);
        //<< . ;
        //<< . ;----- JavaScript Class
        //<< . if $data(^WWW1291(0,YFORM,YBBN)) set YJAVA=1   ;JAVASCRIPT VORHANDEN ;on hand
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1291",0,m$.var("YFORM").get(),m$.var("YBBN").get())))) {
          YJAVA.set(1);
        }
        //<< . ;
        //<< . ;----- Embedded Objects
        //<< . for YI=53:1:56 if +$piece(YSATZ,Y,YI)'=0 set YO(YI)=$piece(YSATZ,Y,YI)  ;VORGABEN FÜR OBJEKTANZEIGE ;to
        for (YI.set(53);(mOp.LessOrEqual(YI.get(),56));YI.set(mOp.Add(YI.get(),1))) {
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),YI.get())),0)) {
            YO.var(YI.get()).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),YI.get()));
          }
        }
        //<< . ;
        //<< . ;----- Mandatory / Unique Key    ; FIXME : D22 $$$WWW003UniqueKey() is deprecated <GRF>
        //<< . if ($piece(YSATZ,Y,13)=$$$YES) || ($piece(YDVOR,Y,22)=$$$YES) if YPFLICHT'=0 set YPFLICHT=1 if $piece(YSATZ,Y,10)="" set $piece(YSATZ,Y,10) = $piece(YVOR,Y,63)
        if ((mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),13),include.COMSYS.$$$YES(m$))) || (mOp.Equal(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),22),include.COMSYS.$$$YES(m$)))) {
          if (mOp.NotEqual(YPFLICHT.get(),0)) {
            YPFLICHT.set(1);
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),"")) {
              m$.pieceVar(m$.var("YSATZ"),m$.var("Y").get(),10).set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),63));
            }
          }
        }
        //<< . ;
        //<< . ;----- Input In Variable
        //<< . if YINHALT'="" set $piece(YFELD,Y,YLFN)=YINHALT
        if (mOp.NotEqual(YINHALT.get(),"")) {
          m$.pieceVar(YFELD,m$.var("Y").get(),m$.var("YLFN").get()).set(YINHALT.get());
        }
        //<< . if $piece(YSATZ,Y,21)'="" if +$piece(YSATZ,Y,21)=0 set @($piece(YSATZ,Y,21))=YINHALT
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21),"")) {
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21)),0)) {
            m$.indirectVar((m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21))).set(YINHALT.get());
          }
        }
        //<< . ;
        //<< . if (YOPEN'=2) do
        if ((mOp.NotEqual(m$.var("YOPEN").get(),2))) {
          //<< . . set $piece(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"D",1),Y,YLFN)=YINHALT
          m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1),m$.var("Y").get(),m$.var("YLFN").get()).set(YINHALT.get());
          //<< . . set $piece(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"D",2),Y,YLFN)=YINHALT
          m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",2),m$.var("Y").get(),m$.var("YLFN").get()).set(YINHALT.get());
        }
        //<< . ;
        //<< . do Start^WWWFORM7(YHIDDSE=0)
        m$.Cmd.Do("WWWFORM7.Start",mOp.Equal(m$.var("YHIDDSE").get(),0));
      } while (false);
    }
    //<< 
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ;Manual Fields
    //<< ;-------------------------------------------------------------------------------
    //<< if YART="M" do
    if (mOp.Equal(m$.var("YART").get(),"M")) {
      do {
        //<< . new YYKEY
        mVar YYKEY = m$.var("YYKEY");
        m$.newVarBlock(1,YYKEY);
        //<< . set YYKEY=$get(YKEY)
        YYKEY.set(m$.Fnc.$get(m$.var("YKEY")));
        //<< . new YKEY
        mVar YKEY = m$.var("YKEY");
        m$.newVarBlock(1,YKEY);
        //<< . set YKEY=YYKEY
        YKEY.set(YYKEY.get());
        //<< . if YKEY="" set YKEY=$translate($get(%(YQUERY,"YKEY")),"|"," ")  ;WENN VARIABLE BENÖTIGT ;when
        if (mOp.Equal(YKEY.get(),"")) {
          YKEY.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YKEY")),"|"," "));
        }
        //<< . quit:YSATZ=""
        if (mOp.Equal(m$.var("YSATZ").get(),"")) {
          break;
        }
        //<< . set YTYP=$piece(YSATZ,Y,5)
        YTYP.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),5));
        //<< . if YTYP="" set YTYP=6
        if (mOp.Equal(YTYP.get(),"")) {
          YTYP.set(6);
        }
        //<< . set YXTYP=+$piece(YSATZ,Y,2)
        YXTYP.set(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),2)));
        //<< . if YXTYP=15 set YTYP=0         ;UNSICHTBAR ;viewless
        if (mOp.Equal(YXTYP.get(),15)) {
          YTYP.set(0);
        }
        //<< . if $piece(YSATZ,Y,16)'="" do   ;FESTE VORGABE ;default
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),"")) {
          //<< . . set YHID=1                   ;UNSICHTBAR ;viewless
          YHID.set(1);
          //<< . . set YINHALT=$piece(YSATZ,Y,16)
          YINHALT.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16));
          //<< . . if (YTYP=1) || (YTYP=7) set YINHALT=$$GetInternal^WWWTR(YTYP,YINHALT)  ;DATUM/UHRZEITVORGABE
          if ((mOp.Equal(YTYP.get(),1)) || (mOp.Equal(YTYP.get(),7))) {
            YINHALT.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YINHALT.get()));
          }
          //<< . . if $extract(YINHALT)="@" do
          if (mOp.Equal(m$.Fnc.$extract(YINHALT.get()),"@")) {
            do {
              //<< . . . if $extract(YINHALT,2)'="$" if $extract(YINHALT,2)'="#" set YINHALT=$get(@($extract($piece(YSATZ,Y,16),2,99))) quit
              if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"$")) {
                if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"#")) {
                  YINHALT.set(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),2,99)))));
                  break;
                }
              }
              //<< . . . new YINHALT1
              mVar YINHALT1 = m$.var("YINHALT1");
              m$.newVarBlock(3,YINHALT1);
              //<< . . . set YINHALT1="S YINHALT="_$extract($piece(YSATZ,Y,16),2,99)
              YINHALT1.set(mOp.Concat("S YINHALT=",m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),16),2,99)));
              //<< . . . xecute YINHALT1
              m$.Cmd.Xecute(YINHALT1.get());
            } while (false);
          }
          m$.restoreVarBlock(3);
        }
        //<< . ;
        //<< . set YLANGE=$piece(YSATZ,Y,6)
        mVar YLANGE = m$.var("YLANGE");
        YLANGE.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),6));
        //<< . ;
        //<< . set YNAME=$piece(YSATZ,Y,12)
        YNAME.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),12));
        //<< . if $data(^WWW1221(0,YFORM,YBBN,SPRACHE,1)) set YNAME=$piece(^WWW1221(0,YFORM,YBBN,SPRACHE,1),Y,1) // SR14914
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1221",0,m$.var("YFORM").get(),m$.var("YBBN").get(),m$.var("SPRACHE").get(),1)))) {
          YNAME.set(m$.Fnc.$piece(m$.var("^WWW1221",0,m$.var("YFORM").get(),m$.var("YBBN").get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ;  Relation Class
        //<< . ;     D29     $$$WWW122DisplayRelationsDownwards()
        //<< . ;     D31     $$$WWW122DisplayIfSortCodes()
        //<< . ;     D32     $$$WWW122RelationClass()
        //<< . ;     D33     $$$WWW122RelationalPrimaryKey()
        //<< . ;     D34     $$$WWW122RelationalDataField()
        //<< . ;     D35     $$$WWW122RelationDisplayOptions()
        //<< . ;     D62     $$$WWW122SortTheRelation()
        //<< . ;     D63     $$$WWW122RelationFieldSequence()
        //<< . ;  v  D67     $$$WWW122RelationSendToField()
        //<< . ;     D79     $$$WWW122RelationalItemToMark()
        //<< . ;-------------------------------------
        //<< . set YPARA(12)=$piece(YSATZ,Y,62)
        YPARA.var(12).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),62));
        //<< . set YPARA(1)=$piece(YSATZ,Y,32)
        YPARA.var(1).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),32));
        //<< . set YPARA(2)=$piece(YSATZ,Y,33)
        YPARA.var(2).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),33));
        //<< . set YPARA(3)=$piece(YSATZ,Y,34)
        YPARA.var(3).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),34));
        //<< . set YPARA("CF") = $$$WWW122CalcRelationalDataField(YSATZ)  ;Calculated Display Fields         //SR16663
        YPARA.var("CF").set(include.WWWConst.$$$WWW122CalcRelationalDataField(m$,m$.var("YSATZ")));
        //<< . set YPARA(33)=$piece(YSATZ,Y,31)                   ;ZUGRIFF AUF SORTKEY ;upon
        YPARA.var(33).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),31));
        //<< . if $piece(YSATZ,Y,63)'="" set YPARA(3)=$piece(YSATZ,Y,63)
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63),"")) {
          YPARA.var(3).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),63));
        }
        //<< . set YPARA(20)=$piece(YSATZ,Y,35)                   ;später ;subsequent
        YPARA.var(20).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),35));
        //<< . set YPARA(79)=$piece(YSATZ,Y,79)                   ;RELATIONSFELD FÜR MARKIERUNG ;to
        YPARA.var(79).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),79));
        //<< . if $piece(YSATZ,Y,29)=1 set YPARA(29)=-1           ;RELATION ABSTEIGEND WENN =1  ;when
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),29),1)) {
          YPARA.var(29).set(mOp.Negative(1));
        }
        //<< . ;
        //<< . set YPARA(80)="" ;WELCHE FELDER MARKIEREN ;who
        YPARA.var(80).set("");
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ; EMBEDED OBJECT
        //<< . ;-------------------------------------
        //<< . if $find(YNAME,".") do
        if (mOp.Logical(m$.Fnc.$find(YNAME.get(),"."))) {
          //<< . . if $piece(YNAME,".",1)'="" if $piece(YNAME,".",2)'="" if $piece(YNAME,".",3)="" do
          if (mOp.NotEqual(m$.Fnc.$piece(YNAME.get(),".",1),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(YNAME.get(),".",2),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YNAME.get(),".",3),"")) {
                do {
                  //<< . . . new YLFN,YLFNX,YDATEI1,YDATEI
                  mVar YLFN = m$.var("YLFN");
                  mVar YLFNX = m$.var("YLFNX");
                  mVar YDATEI1 = m$.var("YDATEI1");
                  mVar YDATEI = m$.var("YDATEI");
                  m$.newVarBlock(3,YLFN,YLFNX,YDATEI1,YDATEI);
                  //<< . . . set YDATEI=$piece($get(^WWW120(0,YFORM,1)),Y,11)
                  YDATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),11));
                  //<< . . . quit:YDATEI=""
                  if (mOp.Equal(YDATEI.get(),"")) {
                    break;
                  }
                  //<< . . . set YLFNX=$order(^WWW003s(0,3,$$^WWWUMLAU(YDATEI,1),$$^WWWUMLAU($piece(YNAME,".",1),1),YDATEI,""))
                  YLFNX.set(m$.Fnc.$order(m$.var("^WWW003s",0,3,m$.fnc$("WWWUMLAU.main",YDATEI.get(),1),m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(YNAME.get(),".",1),1),YDATEI.get(),"")));
                  //<< . . . if YLFNX'="" do
                  if (mOp.NotEqual(YLFNX.get(),"")) {
                    do {
                      //<< . . . . set LFNX(1)=$get(^WWW003(0,YDATEI,YLFNX,1))
                      mVar LFNX = m$.var("LFNX");
                      LFNX.var(1).set(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),YLFNX.get(),1)));
                      //<< . . . . set YDATEI1=$piece(LFNX(1),Y,26)
                      YDATEI1.set(m$.Fnc.$piece(LFNX.var(1).get(),m$.var("Y").get(),26));
                      //<< . . . . quit:YDATEI1=""
                      if (mOp.Equal(YDATEI1.get(),"")) {
                        break;
                      }
                      //<< . . . . set YLFN=$order(^WWW003s(0,3,$$^WWWUMLAU(YDATEI1,1),$$^WWWUMLAU($piece(YNAME,".",2),1),YDATEI1,""))
                      YLFN.set(m$.Fnc.$order(m$.var("^WWW003s",0,3,m$.fnc$("WWWUMLAU.main",YDATEI1.get(),1),m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(YNAME.get(),".",2),1),YDATEI1.get(),"")));
                      //<< . . . . if YLFN'="" do
                      if (mOp.NotEqual(YLFN.get(),"")) {
                        do {
                          //<< . . . . . set YLFN(1)=$get(^WWW003(0,YDATEI1,YLFN,1))
                          YLFN.var(1).set(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI1.get(),YLFN.get(),1)));
                          //<< . . . . . quit:YLFN(1)=""
                          if (mOp.Equal(YLFN.var(1).get(),"")) {
                            break;
                          }
                          //<< . . . . . set YNAME=$piece(YLFN(1),Y,2)          ;TEXT EMBEDED OBJECT
                          YNAME.set(m$.Fnc.$piece(YLFN.var(1).get(),m$.var("Y").get(),2));
                          //<< . . . . . set strLanguage=$$^WWWLANGU(YBED)      //SR14914
                          strLanguage.set(m$.fnc$("WWWLANGU.main",m$.var("YBED").get()));
                          //<< . . . . . if $data(^WWW0031(0,YDATEI,YLFN,strLanguage,1)) set YNAME=$piece(^WWW0031(0,YDATEI,YLFN,strLanguage,1),Y,1) //SR14914
                          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,YDATEI.get(),YLFN.get(),strLanguage.get(),1)))) {
                            YNAME.set(m$.Fnc.$piece(m$.var("^WWW0031",0,YDATEI.get(),YLFN.get(),strLanguage.get(),1).get(),m$.var("Y").get(),1));
                          }
                          //<< . . . . . set YLANGE=$piece(YLFN(1),Y,4)         ;LENGTH EMBEDED OBJECT
                          YLANGE.set(m$.Fnc.$piece(YLFN.var(1).get(),m$.var("Y").get(),4));
                          //<< . . . . . set YTYP=$piece(YLFN(1),Y,3)           ;DATATYPE EMBEDED OBJECT
                          YTYP.set(m$.Fnc.$piece(YLFN.var(1).get(),m$.var("Y").get(),3));
                          //<< . . . . . quit:YPARA(1)'=""                      ;SELECTED THRU FORMDEF
                          if (mOp.NotEqual(YPARA.var(1).get(),"")) {
                            break;
                          }
                          //<< . . . . . set YPARA(12) = $piece(YLFN(1),Y,7)    ;RELATION SORTIEREN ;assortment
                          YPARA.var(12).set(m$.Fnc.$piece(YLFN.var(1).get(),m$.var("Y").get(),7));
                          //<< . . . . . set YPARA(1)  = $piece(YLFN(1),Y,8)    ;RELATIONSDATEI  AUS DATEIDEV ;out of
                          YPARA.var(1).set(m$.Fnc.$piece(YLFN.var(1).get(),m$.var("Y").get(),8));
                          //<< . . . . . set YPARA(33) = $piece(YLFN(1),Y,21)   ;ZUGRIFF AUF SORTKEY ;upon
                          YPARA.var(33).set(m$.Fnc.$piece(YLFN.var(1).get(),m$.var("Y").get(),21));
                          //<< . . . . . set YPARA(2)  = $piece(YLFN(1),Y,9)    ;REL KEY
                          YPARA.var(2).set(m$.Fnc.$piece(YLFN.var(1).get(),m$.var("Y").get(),9));
                          //<< . . . . . set YPARA(3)  = $piece(YLFN(1),Y,10)   ;REL FELD ;field
                          YPARA.var(3).set(m$.Fnc.$piece(YLFN.var(1).get(),m$.var("Y").get(),10));
                          //<< . . . . . set YPARA("CF") = $$$WWW003CalcRelationalDisplayItems(YLFN(1))  ;Calculated Display Fields            //SR16663
                          YPARA.var("CF").set(include.WWWConst.$$$WWW003CalcRelationalDisplayItems(m$,YLFN.var(1)));
                          //<< . . . . . set YPARA(20) = $piece(YLFN(1),Y,20)   ;ERST SPÄTER ANZEIGEN ;only subsequent display
                          YPARA.var(20).set(m$.Fnc.$piece(YLFN.var(1).get(),m$.var("Y").get(),20));
                        } while (false);
                      }
                    } while (false);
                  }
                } while (false);
              }
              m$.restoreVarBlock(3);
            }
          }
        }
        //<< . ;
        //<< . if $data(^WWW1251(0,YFORM,YBBN)) do   ;SEKEKTIONEN
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1251",0,m$.var("YFORM").get(),m$.var("YBBN").get())))) {
          //<< . . set YXTYP=+$piece($get(^WWW1251(0,YFORM,YBBN,1,1)),Y,2)
          YXTYP.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1251",0,m$.var("YFORM").get(),m$.var("YBBN").get(),1,1)),m$.var("Y").get(),2)));
          //<< . . ;SET YPARA(12)=0  ;SORTIERUNG PARA ;table-mat sorting
          //<< . . set YPARA(1)="WWW1251"
          YPARA.var(1).set("WWW1251");
          //<< . . set YPARA(2)=""""_YFORM_""","""_YBBN_""""
          YPARA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("\"",m$.var("YFORM").get()),"\",\""),m$.var("YBBN").get()),"\""));
          //<< . . set YPARA(3)=1
          YPARA.var(3).set(1);
        }
        //<< . ;
        //<< . set YPARA(67) = $piece(YSATZ,Y,67)  ;NEUES FELD AUS EVENT BROKER ;$$$WWW122RelationSendToField()
        YPARA.var(67).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),67));
        //<< . set YNAME0    = $piece(YSATZ,Y,27)
        YNAME0.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),27));
        //<< . ;SET YNAME1    = $PIECE(YSATZ,Y,28) ;16679
        //<< . set YNAME1=$$$Text($$$WWW122TextBehindUserInputField(YSATZ)) ;16679
        YNAME1.set(include.COMSYS.$$$Text(m$,include.WWWConst.$$$WWW122TextBehindUserInputField(m$,m$.var("YSATZ"))));
        //<< . set YSPAL     = $piece(YSATZ,Y,4)
        mVar YSPAL = m$.var("YSPAL");
        YSPAL.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),4));
        //<< . if $piece(YSATZ,Y,15)'="" do
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),"")) {
          //<< . . set YINHALT=$piece(YSATZ,Y,15)
          YINHALT.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15));
          //<< . . if (YTYP=1) || (YTYP=7) if $extract(YINHALT)'="@" set YINHALT=$$GetInternal^WWWTR(YTYP,YINHALT)  ;DATUM/UHRZEITVORGABE
          if ((mOp.Equal(YTYP.get(),1)) || (mOp.Equal(YTYP.get(),7))) {
            if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get()),"@")) {
              YINHALT.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YINHALT.get()));
            }
          }
          //<< . . if $extract(YINHALT)="@" do
          if (mOp.Equal(m$.Fnc.$extract(YINHALT.get()),"@")) {
            do {
              //<< . . . if $extract(YINHALT,2)'="$" if $extract(YINHALT,2)'="#" set YINHALT=$get(@($extract($piece(YSATZ,Y,15),2,99))) quit
              if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"$")) {
                if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),2),"#")) {
                  YINHALT.set(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),2,99)))));
                  break;
                }
              }
              //<< . . . new YINHALT1
              mVar YINHALT1 = m$.var("YINHALT1");
              m$.newVarBlock(3,YINHALT1);
              //<< . . . set YINHALT1="S YINHALT="_$extract($piece(YSATZ,Y,15),2,99)
              YINHALT1.set(mOp.Concat("S YINHALT=",m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),15),2,99)));
              //<< . . . xecute YINHALT1
              m$.Cmd.Xecute(YINHALT1.get());
              //<< . . . if (YTYP=1) || (YTYP=7) set YINHALT=$$GetInternal^WWWTR(YTYP,YINHALT)  ;DATUM/UHRZEITVORGABE
              if ((mOp.Equal(YTYP.get(),1)) || (mOp.Equal(YTYP.get(),7))) {
                YINHALT.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YINHALT.get()));
              }
            } while (false);
          }
          m$.restoreVarBlock(3);
        }
        //<< . ;
        //<< . if $data(YMFELD) if YMFELD'="" set YINHALT=$piece(YMFELD,Y,YLFN)
        if (mOp.Logical(m$.Fnc.$data(m$.var("YMFELD")))) {
          if (mOp.NotEqual(m$.var("YMFELD").get(),"")) {
            YINHALT.set(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()));
          }
        }
        //<< . ;
        //<< . ;-------------------------------------  *** EXECUTE ***
        //<< . ;  ExecuteOnLoad (M)
        //<< . ;-------------------------------------
        //<< . ;
        //<< . if $piece(YSATZ,Y,26)'="" xecute $piece(YSATZ,Y,26)  ;EXECUTE BEI ONLOAD (YINHALT) ;EXECUTE next to
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),26),"")) {
          m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),26));
        }
        //<< . if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onLoad.OBJ",$get(YUCI)) xecute "DO ^Y"_YFORM_YART_YLFN_"onLoad"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
        if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onLoad.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
          m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onLoad"));
        }
        //<< . ;
        //<< . ;IF $$^WWWACCESS($PIECE(YSATZ,Y,22),$PIECE(YSATZ,Y,24))'=1 S YHID=2    ;KEINE FELDBERECHTIGUNG MODUL
        //<< . if ($$$WWW120AuthorizationToModifyData(YSATZ)=$$$EnumReadOnly)  set YHID=2
        if ((mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YSATZ")),include.COMSYSEnum.$$$EnumReadOnly(m$)))) {
          YHID.set(2);
        }
        //<< . if ($$$WWW120AuthorizationToModifyData(YVOR) =$$$EnumReadOnly)  set YHID=2
        if ((mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$)))) {
          YHID.set(2);
        }
        //<< . if ($piece(YSATZ,Y,42)'="") || ($piece(YSATZ,Y,44)'="") if $$^WWWACCESS($piece(YSATZ,Y,42),$piece(YSATZ,Y,44))=1 do    ;FELDBERECHTIGUNG MODUL ;module
        if ((mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),42),"")) || (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),44),""))) {
          if (mOp.Equal(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),42),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),44)),1)) {
            //<< . . if $piece(YSATZ,Y,43)=5  set YHID=2   ;FELDBERECHTIGUNNG
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),43),5)) {
              YHID.set(2);
            }
            //<< . . if +$piece(YSATZ,Y,43)=0 set YHID=0   ;FREIGABE
            if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),43)),0)) {
              YHID.set(0);
            }
          }
        }
        //<< . ;
        //<< . do IsInactive(YSATZ,YFELD,.YHID)  //SR13309 - moved into function
        m$.Cmd.Do("IsInactive",m$.var("YSATZ").get(),YFELD.get(),YHID);
        //<< . ;
        //<< . ;-------------------------------------  *** EXECUTE ***
        //<< . ;  Execute : Set from Form Object when FormObj'=""
        //<< . ;  D21        Input In Variable
        //<< . ;  Must have object opened as XXXObj for form XXX (?)
        //<< . ;  then property name is in D21
        //<< . ;  FormObj possibly set in WWWXML
        //<< . ;-------------------------------------
        //<< . ;
        //<< . if $piece(YSATZ,Y,21)'="" if +$piece(YSATZ,Y,21)=0 if $find($piece(YSATZ,Y,21),".") do
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21),"")) {
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21)),0)) {
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21),"."))) {
              //<< . . new OBJ
              mVar OBJ = m$.var("OBJ");
              m$.newVarBlock(2,OBJ);
              //<< . . if $get(FormObj)'="" do
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("FormObj")),"")) {
                //<< . . . set OBJ="S YINHALT="_YFORM_"Obj."_$piece(YSATZ,Y,21)
                OBJ.set(mOp.Concat(mOp.Concat(mOp.Concat("S YINHALT=",m$.var("YFORM").get()),"Obj."),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21)));
                //<< . . . xecute OBJ
                m$.Cmd.Xecute(OBJ.get());
              }
            }
            m$.restoreVarBlock(2);
          }
        }
        //<< . ;
        //<< . if $piece(YSATZ,Y,21)'="" if +$piece(YSATZ,Y,21)=0 if '$find($piece(YSATZ,Y,21),".") set @($piece(YSATZ,Y,21))=YINHALT
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21),"")) {
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21)),0)) {
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21),"."))) {
              m$.indirectVar((m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),21))).set(YINHALT.get());
            }
          }
        }
        //<< . if $piece(YSATZ,Y,13)=1 if YPFLICHT'=0 set YPFLICHT=1 set $piece(YSATZ,Y,10)=$piece(YVOR,Y,63)
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),13),1)) {
          if (mOp.NotEqual(YPFLICHT.get(),0)) {
            YPFLICHT.set(1);
            m$.pieceVar(m$.var("YSATZ"),m$.var("Y").get(),10).set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),63));
          }
        }
        //<< . do  ;IF $PIECE(YVOR,Y,82)=1 DO
        do {
          //<< . . set $piece(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"M",1),Y,YLFN)=YINHALT  ;AUF BROWSER ;upon
          m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"M",1),m$.var("Y").get(),m$.var("YLFN").get()).set(YINHALT.get());
          //<< . . set $piece(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"M",2),Y,YLFN)=YINHALT  ;VORGABE   ;default
          m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"M",2),m$.var("Y").get(),m$.var("YLFN").get()).set(YINHALT.get());
        } while(false);
        //<< . ;
        //<< . do Start^WWWFORM7(YHIDDSE=0)
        m$.Cmd.Do("WWWFORM7.Start",mOp.Equal(m$.var("YHIDDSE").get(),0));
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; LISTENFELDER
    //<< ;-------------------------------------------------------------------------------
    //<< if $extract(YART)="L" do
    if (mOp.Equal(m$.Fnc.$extract(m$.var("YART").get()),"L")) {
      do {
        //<< . quit:YSATZ=""
        if (mOp.Equal(m$.var("YSATZ").get(),"")) {
          break;
        }
        //<< . set YDVOR=YSATZ
        mVar YDVOR = m$.var("YDVOR");
        YDVOR.set(m$.var("YSATZ").get());
        //<< . quit:YDVOR=""
        if (mOp.Equal(YDVOR.get(),"")) {
          break;
        }
        //<< . ;
        //<< . set YTYP=$piece(YDVOR,Y,3)
        YTYP.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),3));
        //<< . if YTYP=3 set YTYP=6
        if (mOp.Equal(YTYP.get(),3)) {
          YTYP.set(6);
        }
        //<< . set YLANGE=$piece(YDVOR,Y,4)
        mVar YLANGE = m$.var("YLANGE");
        YLANGE.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),4));
        //<< . ;-----
        //<< . set YNAME=$piece(YDVOR,Y,2)
        YNAME.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),2));
        //<< . if $piece(YLISTLF,Y,3)=1 set YNAME = $$$Text($listbuild("53",$piece(YDVOR,Y,2)))  ; "From %1"  ;VON EINGABE  ;BR014923
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),3),1)) {
          YNAME.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("53",m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),2))));
        }
        //<< . if $piece(YLISTLF,Y,3)=3 set YNAME = $piece(YDVOR,Y,2) set YXTYP=6
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),3),3)) {
          YNAME.set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),2));
          YXTYP.set(6);
        }
        //<< . ;-----
        //<< . set YPARA(12) = $piece(YDVOR,Y,7)   ;SORTIERUNG PARA ;sorting
        YPARA.var(12).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),7));
        //<< . set YPARA(1)  = $piece(YDVOR,Y,8)   ;DATEI RELATION ;data file
        YPARA.var(1).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),8));
        //<< . set YPARA(2)  = $piece(YDVOR,Y,9)
        YPARA.var(2).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),9));
        //<< . set YPARA(3)  = $piece(YDVOR,Y,10)
        YPARA.var(3).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),10));
        //<< . set YPARA("CF") = $$$WWW003CalcRelationalDisplayItems(YDVOR)  ;Calculated Display Fields          //SR16663
        YPARA.var("CF").set(include.WWWConst.$$$WWW003CalcRelationalDisplayItems(m$,YDVOR));
        //<< . set YPARA(20) = $piece(YDVOR,Y,20)  ;SPÄTER ANZEIGEN ;subsequent display
        YPARA.var(20).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),20));
        //<< . if $piece(YLISTLF,Y,22)'="" do
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),22),"")) {
          //<< . . set YPARA(12) = $piece(YLISTLF,Y,30)
          YPARA.var(12).set(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),30));
          //<< . . set YPARA(1)  = $piece(YLISTLF,Y,22)
          YPARA.var(1).set(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),22));
          //<< . . set YPARA(2)  = $piece(YLISTLF,Y,23)
          YPARA.var(2).set(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),23));
          //<< . . set YPARA(3)  = $piece(YLISTLF,Y,24)
          YPARA.var(3).set(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),24));
          //<< . . if YXTYP'=6 set YXTYP=4
          if (mOp.NotEqual(YXTYP.get(),6)) {
            YXTYP.set(4);
          }
        }
        //<< . ;
        //<< . set YPARA(67)=""
        YPARA.var(67).set("");
        //<< . set YSPAL=1
        mVar YSPAL = m$.var("YSPAL");
        YSPAL.set(1);
        //<< . set YINHALT=$piece(YLISTLF,Y,13)
        YINHALT.set(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),13));
        //<< . do ^WWWFORM7      ; FIXME : Start^WWWFORM7($$$NO)
        m$.Cmd.Do("WWWFORM7.main");
        //<< . if $piece(YLISTLF,Y,3)'=1 write YCR,"</TD><TD>&nbsp;</TD><TD>&nbsp;" quit       ;KEIN VON-BIS
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),3),1)) {
          m$.Cmd.Write(m$.var("YCR").get(),"</TD><TD>&nbsp;</TD><TD>&nbsp;");
          break;
        }
        //<< . do THUMP
        m$.Cmd.Do("THUMP");
        //<< . set YNAME     = $$$Text($listbuild("54",$piece(YDVOR,Y,2)))  ; "To %1"   ;BIS ABFRABE FELD ;until field  ;BR014923
        YNAME.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("54",m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),2))));
        //<< . set YPARA(12)   = 0                   ;SORTIERUNG PARA ;sorting
        YPARA.var(12).set(0);
        //<< . set YPARA(1)    = $piece(YDVOR,Y,8)
        YPARA.var(1).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),8));
        //<< . set YPARA(2)    = $piece(YDVOR,Y,9)
        YPARA.var(2).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),9));
        //<< . set YPARA(3)    = $piece(YDVOR,Y,10)
        YPARA.var(3).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),10));
        //<< . set YPARA("CF") = $$$WWW003CalcRelationalDisplayItems(YDVOR)  ;Calculated Display Fields          //SR16663
        YPARA.var("CF").set(include.WWWConst.$$$WWW003CalcRelationalDisplayItems(m$,YDVOR));
        //<< . set YPARA(20)   = $piece(YDVOR,Y,20)  ;SPÄTER ANZEIGEN ;subsequent display
        YPARA.var(20).set(m$.Fnc.$piece(YDVOR.get(),m$.var("Y").get(),20));
        //<< . if $piece(YLISTLF,Y,22)'="" do
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),22),"")) {
          //<< . . set YPARA(12) = $piece(YLISTLF,Y,30)
          YPARA.var(12).set(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),30));
          //<< . . set YPARA(1)  = $piece(YLISTLF,Y,22)
          YPARA.var(1).set(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),22));
          //<< . . set YPARA(2)  = $piece(YLISTLF,Y,23)
          YPARA.var(2).set(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),23));
          //<< . . set YPARA(3)  = $piece(YLISTLF,Y,24)
          YPARA.var(3).set(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),24));
          //<< . . if YXTYP'=6 set YXTYP = 4
          if (mOp.NotEqual(YXTYP.get(),6)) {
            YXTYP.set(4);
          }
        }
        //<< . ;
        //<< . set YPARA(67) = ""
        YPARA.var(67).set("");
        //<< . set YSPAL     = 2
        YSPAL.set(2);
        //<< . set YINHALT   = $piece(YLISTLF,Y,14)
        YINHALT.set(m$.Fnc.$piece(m$.var("YLISTLF").get(),m$.var("Y").get(),14));
        //<< . set YART      = YART_"1"
        mVar YART = m$.var("YART");
        YART.set(mOp.Concat(m$.var("YART").get(),"1"));
        //<< . do ^WWWFORM7      ; FIXME : Start^WWWFORM7($$$NO)
        m$.Cmd.Do("WWWFORM7.main");
      } while (false);
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ;OPTIONSFELDER
    //<< ;-------------------------------------------------------------------------------
    //<< if YART="O" {
    if (mOp.Equal(m$.var("YART").get(),"O")) {
      //<< set YTYP      = 6
      YTYP.set(6);
      //<< set YXTYP     = +$piece($get(^WWW1210(0,YFORM,1,1)),Y,2)
      YXTYP.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1210",0,m$.var("YFORM").get(),1,1)),m$.var("Y").get(),2)));
      //<< set YLANGE    = 10
      mVar YLANGE = m$.var("YLANGE");
      YLANGE.set(10);
      //<< set YNAME     = $$^WWWTEXT(202)_"  :"         ; "Options"
      YNAME.set(mOp.Concat(m$.fnc$("WWWTEXT.main",202),"  :"));
      //<< set YPARA(12) = 0                             ;SORTIERUNG PARA ;sorting
      YPARA.var(12).set(0);
      //<< set YPARA(1)  = "WWW1210"
      YPARA.var(1).set("WWW1210");
      //<< set YPARA(2)  = """"_YFORM_""""
      YPARA.var(2).set(mOp.Concat(mOp.Concat("\"",m$.var("YFORM").get()),"\""));
      //<< set YPARA(3)  = 1
      YPARA.var(3).set(1);
      //<< set YPARA(67) = ""
      YPARA.var(67).set("");
      //<< set YSPAL     = 1
      mVar YSPAL = m$.var("YSPAL");
      YSPAL.set(1);
      //<< set YINHALT   = 1
      YINHALT.set(1);
      //<< do ^WWWFORM7      ; FIXME : Start^WWWFORM7($$$NO)
      m$.Cmd.Do("WWWFORM7.main");
    }
    //<< }
    //<< ;-------------------------------------------------------------------------------
    //<< quit:YHIDDSE=1     ;SEITE ;side
    if (mOp.Equal(m$.var("YHIDDSE").get(),1)) {
      return;
    }
    //<< quit:$get(YTYP)=0  ;UNSICHTBAR ;viewless
    if (mOp.Equal(m$.Fnc.$get(YTYP),0)) {
      return;
    }
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< if YNAME1'="" do
    if (mOp.NotEqual(YNAME1.get(),"")) {
      //<< . new YI
      m$.newVarBlock(1,YI);
      //<< . write "<FONT SIZE="_$piece(YVOR,Y,7)_">"  ;SR17887
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),">"));
      //<< . for YI=1:1 set YI(1)=$piece(YNAME1,"|",YI) quit:YI(1)=""  do
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        YI.var(1).set(m$.Fnc.$piece(YNAME1.get(),"|",YI.get()));
        if (mOp.Equal(YI.var(1).get(),"")) {
          break;
        }
        //<< . . if YI'=1 write "<BR>"
        if (mOp.NotEqual(YI.get(),1)) {
          m$.Cmd.Write("<BR>");
        }
        //<< . . write $$^WWWUML(YI(1))_"&nbsp;"
        m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWUML.main",YI.var(1).get()),"&nbsp;"));
      }
      //<< . write "</FONT>"   ;SR17887
      m$.Cmd.Write("</FONT>");
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< // SR?????: Reorder these so that extra buttons go after the standard buttons
    //<< do THUMP      ;BILDER NACH DER EINGABEE ;imagery within the
    m$.Cmd.Do("THUMP");
    //<< do BUTTON     ;BUTTONS NACH DER EINGABE ;within the
    m$.Cmd.Do("BUTTON");
    //<< 
    //<< if +$get(YSCREENM)=1 if (YFOART=1) || (YFOART=4) || (YFOART=5) do ^WWWSCRM   ;SCREEN MOVEMENT
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YSCREENM"))),1)) {
      if ((mOp.Equal(m$.var("YFOART").get(),1)) || (mOp.Equal(m$.var("YFOART").get(),4)) || (mOp.Equal(m$.var("YFOART").get(),5))) {
        m$.Cmd.Do("WWWSCRM.main");
      }
    }
    //<< if +$get(YSCREENM)=3 if (YFOART=1) || (YFOART=4) || (YFOART=5) do ^WWWSCRMD  ;CUSTOMIZING SCREEN MOVEMENT;FIS;10.03.04;25301
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YSCREENM"))),3)) {
      if ((mOp.Equal(m$.var("YFOART").get(),1)) || (mOp.Equal(m$.var("YFOART").get(),4)) || (mOp.Equal(m$.var("YFOART").get(),5))) {
        m$.Cmd.Do("WWWSCRMD.main");
      }
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ;    BEENDEN FORMATIERUNG DES FELDES ;formatting
    //<< ;-------------------------------------------------------------------------------
    //<< kill ^WWWSOR(YUSER,2)
    m$.var("^WWWSOR",m$.var("YUSER").get(),2).kill();
    //<< if (YART="P") || (YART="D") || (YART="M") if +$piece(YSATZ,Y,10)=0 do
    if ((mOp.Equal(m$.var("YART").get(),"P")) || (mOp.Equal(m$.var("YART").get(),"D")) || (mOp.Equal(m$.var("YART").get(),"M"))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10)),0)) {
        do {
          //<< . quit:+$piece(YVOR,Y,8)=0
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8)),0)) {
            break;
          }
          //<< . if $find($piece(YVOR,Y,8),1) write "</STRONG></B>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),1))) {
            m$.Cmd.Write("</STRONG></B>");
          }
          //<< . if $find($piece(YVOR,Y,8),2) write "</U>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),2))) {
            m$.Cmd.Write("</U>");
          }
          //<< . if $find($piece(YVOR,Y,8),3) write "</I>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),3))) {
            m$.Cmd.Write("</I>");
          }
          //<< . if $find($piece(YVOR,Y,8),4) write "</STRIKE>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),4))) {
            m$.Cmd.Write("</STRIKE>");
          }
          //<< . if $find($piece(YVOR,Y,8),5) write "</BLINK>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),5))) {
            m$.Cmd.Write("</BLINK>");
          }
          //<< . if $find($piece(YVOR,Y,8),6) write "</MARQUEE>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),6))) {
            m$.Cmd.Write("</MARQUEE>");
          }
        } while (false);
      }
    }
    //<< 
    //<< if (YART="P") || (YART="D") || (YART="M") if (+$piece(YSATZ,Y,8)'=0) || (+$piece(YSATZ,Y,9)'=0) || (+$piece(YSATZ,Y,10)'=0) || (+$piece(YSATZ,Y,11)'=0) do
    if ((mOp.Equal(m$.var("YART").get(),"P")) || (mOp.Equal(m$.var("YART").get(),"D")) || (mOp.Equal(m$.var("YART").get(),"M"))) {
      if ((mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),8)),0)) || (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),9)),0)) || (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10)),0)) || (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),11)),0))) {
        //<< . write "</FONT>"
        m$.Cmd.Write("</FONT>");
        //<< . if $find($piece(YSATZ,Y,10),1) write "</STRONG></B>"
        if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),1))) {
          m$.Cmd.Write("</STRONG></B>");
        }
        //<< . if $find($piece(YSATZ,Y,10),2) write "</U>"
        if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),2))) {
          m$.Cmd.Write("</U>");
        }
        //<< . if $find($piece(YSATZ,Y,10),3) write "</I>"
        if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),3))) {
          m$.Cmd.Write("</I>");
        }
        //<< . if $find($piece(YSATZ,Y,10),4) write "</STRIKE>"
        if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),4))) {
          m$.Cmd.Write("</STRIKE>");
        }
        //<< . if $find($piece(YSATZ,Y,10),5) write "</BLINK>"
        if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),5))) {
          m$.Cmd.Write("</BLINK>");
        }
        //<< . if $find($piece(YSATZ,Y,10),6) write "</MARQUEE>"
        if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),6))) {
          m$.Cmd.Write("</MARQUEE>");
        }
      }
    }
    //<< 
    //<< if YART="P" if $piece($get(YVOR1),Y,95)=1 write YCR,"</STRONG></B>"
    if (mOp.Equal(m$.var("YART").get(),"P")) {
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR1")),m$.var("Y").get(),95),1)) {
        m$.Cmd.Write(m$.var("YCR").get(),"</STRONG></B>");
      }
    }
    //<< write YCR,"</TD>",YCR
    m$.Cmd.Write(m$.var("YCR").get(),"</TD>",m$.var("YCR").get());
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< IsInactive(YSATZ,YFELD,&YHID)
  public Object IsInactive(Object ... _p) {
    mVar YSATZ = m$.newVarRef("YSATZ",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YHID = m$.newVarRef("YHID",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Looks at "Field Is Inactive, If Data Field" and "Has The Following Entry"
    //<< ; fields to decide whether inactive.
    //<< ;
    //<< ; strTestValue can have the following formats
    //<< ;    A       or   A;B;C     Inactive if the field contains the value or one of
    //<< ;                           the semicolon delimited values (string compare)
    //<< ;
    //<< ;   'A       or '=A         Inactive if the field does not contain any of
    //<< ;   'A;B;C   or '=A;B;C     the nominated values (string compare)
    //<< ;
    //<< ;   <nnn        '<nnn       Inactive if the field evaluates to being
    //<< ;   >nnn        '>nnn       (not) less/greater than the numerical value
    //<< ;
    //<< ; Called By : Enabled^COMGridEdit31G, ^WWWFORM9, ReadOnly^WWWFORMD
    //<< ;
    //<< ; Params:
    //<< ;   YSATZ
    //<< ;   YFELD
    //<< ;   YHID
    //<< ;
    //<< ; Returns: YHID - by Ref
    //<< ;
    //<< ; History:
    //<< ; 10-Aug-2010   PPP     SR17296: reverted code to original
    //<< ; 05-Aug-2010   GRF     SR17296: use macros; add & to parameter; doco
    //<< ; 16-Sep-2005   JW      SR13309: Created (moved code into function)
    //<< ;                       Fixed 3 lines of code that should've looked at first TWO chars.
    //<< ;-------------------------------------------------------------------------------
    //<< new idTestField,strContents,strPrefix,strRest,strSearchVal,strTestValue
    mVar idTestField = m$.var("idTestField");
    mVar strContents = m$.var("strContents");
    mVar strPrefix = m$.var("strPrefix");
    mVar strRest = m$.var("strRest");
    mVar strSearchVal = m$.var("strSearchVal");
    mVar strTestValue = m$.var("strTestValue");
    m$.newVar(idTestField,strContents,strPrefix,strRest,strSearchVal,strTestValue);
    //<< 
    //<< /*
    //<< set idTestField = $$$WWW122FieldIsInactiveIfDataFiel(YSATZ)     ; D86
    //<< 
    //<< if (idTestField'="") {
    //<< set strTestValue = $$$WWW122HasTheFollowingEntry(YSATZ)     ; D87
    //<< set strContents  = $piece(YFELD,Y,idTestField)
    //<< set strSearchVal = $$$COMMA_strContents_$$$COMMA
    //<< 
    //<< set strPrefix = $extract(strTestValue,1,2)
    //<< set strRest   = $extract(strTestValue,3,99)
    //<< 
    //<< if strPrefix = "'=" {
    //<< if '$find($$$COMMA_$translate(strRest,$$$SEMICOLON,$$$COMMA)_$$$COMMA,strSearchVal) set YHID = 2
    //<< 
    //<< } elseif strPrefix = "'<" {
    //<< if strContents '< strRest set YHID = 2
    //<< 
    //<< } elseif strPrefix = "'>" {
    //<< if strContents '> strRest set YHID = 2
    //<< 
    //<< } else {
    //<< set strPrefix = $extract(strTestValue)
    //<< set strRest   = $extract(strTestValue,2,99)
    //<< 
    //<< if strPrefix = "'" {
    //<< if '$find($$$COMMA_$translate(strRest,$$$SEMICOLON,$$$COMMA)_$$$COMMA,strSearchVal) set YHID = 2
    //<< 
    //<< } elseif strPrefix = "<" {
    //<< if strContents < strRest set YHID = 2
    //<< 
    //<< } elseif strPrefix = ">" {
    //<< if strContents > strRest set YHID = 2
    //<< 
    //<< } else {
    //<< if $find($$$COMMA_$translate(strRest,$$$SEMICOLON,$$$COMMA)_$$$COMMA,strSearchVal) set YHID = 2
    //<< 
    //<< }
    //<< 
    //<< }
    //<< }
    //<< quit
    //<< */
    //<< 
    //<< if $piece(YSATZ,Y,86)'="" do
    if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),86),"")) {
      do {
        //<< . if $extract($piece(YSATZ,Y,87))="'"      if '$find(","_$translate($extract($piece(YSATZ,Y,87),2,99),";",",")_",",","_$piece(YFELD,Y,$piece(YSATZ,Y,86))_",") set YHID=2 quit
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87)),"'")) {
          if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87),2,99),";",",")),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),86))),",")))) {
            YHID.set(2);
            break;
          }
        }
        //<< . if $extract($piece(YSATZ,Y,87),1,2)="'=" if '$find(","_$translate($extract($piece(YSATZ,Y,87),3,99),";",",")_",",","_$piece(YFELD,Y,$piece(YSATZ,Y,86))_",") set YHID=2 quit      //SR13309
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87),1,2),"'=")) {
          if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87),3,99),";",",")),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),86))),",")))) {
            YHID.set(2);
            break;
          }
        }
        //<< . if $extract($piece(YSATZ,Y,87))="<"      if $piece(YFELD,Y,$piece(YSATZ,Y,86))<$extract($piece(YSATZ,Y,87),2,99)  set YHID=2 quit
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87)),"<")) {
          if (mOp.Less(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),86)),m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87),2,99))) {
            YHID.set(2);
            break;
          }
        }
        //<< . if $extract($piece(YSATZ,Y,87))=">"      if $piece(YFELD,Y,$piece(YSATZ,Y,86))>$extract($piece(YSATZ,Y,87),2,99)  set YHID=2 quit
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87)),">")) {
          if (mOp.Greater(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),86)),m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87),2,99))) {
            YHID.set(2);
            break;
          }
        }
        //<< . if $extract($piece(YSATZ,Y,87),1,2)="'<" if $piece(YFELD,Y,$piece(YSATZ,Y,86))'<$extract($piece(YSATZ,Y,87),3,99) set YHID=2 quit     //SR13309
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87),1,2),"'<")) {
          if (mOp.NotLess(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),86)),m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87),3,99))) {
            YHID.set(2);
            break;
          }
        }
        //<< . if $extract($piece(YSATZ,Y,87),1,2)="'>" if $piece(YFELD,Y,$piece(YSATZ,Y,86))'>$extract($piece(YSATZ,Y,87),3,99) set YHID=2 quit     //SR13309
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87),1,2),"'>")) {
          if (mOp.NotGreater(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),86)),m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87),3,99))) {
            YHID.set(2);
            break;
          }
        }
        //<< . if $find(","_$translate($piece(YSATZ,Y,87),";",",")_",",","_$piece(YFELD,Y,$piece(YSATZ,Y,86))_",")               set YHID=2
        if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),87),";",",")),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),86))),",")))) {
          YHID.set(2);
        }
      } while (false);
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< THUMP
  public void THUMP() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display images and other objects
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2012   shobby  SR18187:    Allow configuration to hide buttons on disabled fields.
    //<< ; 01-Aug-2012   shobby  SR18076: IsImageType includes many more image types.
    //<< ; 06-Jun-2007   shobby  SRBR014409: Subroutined code to create the date button in to CreateDateButton
    //<< ; 07-May-2007   GRF     SRBR014310: Missing line restored; doco; quits
    //<< ; 02-Apr-2007   JW      SR15384: Removed extra JS for currency fields
    //<< ; 17-Jan-2007   Steve S SR15355: Give Calender buttons an id
    //<< ; 24-Oct-2006   Steve S SR14915: Encapsulate code which draws memo buttons
    //<< ; 17-Oct-2006   Steve S SR15124: Disable date buttons if field is readonly.
    //<< ; 12-Oct-2006   RPW     SR14914: use the new COMEditor form.
    //<< ; 02-Jun-2006   SC      SRBR014011: Increased size of Calendar Dialog box to
    //<< ;                       allow for larger text buttons.
    //<< ; 11-May-2006   JW      SR14508: Remove date img if YHID=2
    //<< ; 12-Dec-2005   JW      SR13195: Rewrote memo field. Don't call BEARB.
    //<< ; 31-Oct-2005   JW      SR12918: Improved file identification
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++  ???
    //<< ; YSATZ - WWW122
    //<< ; YVOR  - WWW120
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< new objCompany,strExtension
    mVar objCompany = m$.var("objCompany");
    mVar strExtension = m$.var("strExtension");
    m$.newVar(objCompany,strExtension);
    //<< new idEditor,objEditor,idSkin,idToolbar,intMaxCharacter,blnUseStandard,strAction,objData,strURL
    mVar idEditor = m$.var("idEditor");
    mVar objEditor = m$.var("objEditor");
    mVar idSkin = m$.var("idSkin");
    mVar idToolbar = m$.var("idToolbar");
    mVar intMaxCharacter = m$.var("intMaxCharacter");
    mVar blnUseStandard = m$.var("blnUseStandard");
    mVar strAction = m$.var("strAction");
    mVar objData = m$.var("objData");
    mVar strURL = m$.var("strURL");
    m$.newVar(idEditor,objEditor,idSkin,idToolbar,intMaxCharacter,blnUseStandard,strAction,objData,strURL);
    //<< 
    //<< set objCompany = $get(^WWW012(0,YM,1))
    objCompany.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< 
    //<< set strExtension=""
    strExtension.set("");
    //<< if $find(YINHALT,".") {
    if (mOp.Logical(m$.Fnc.$find(m$.var("YINHALT").get(),"."))) {
      //<< set strExtension = $$$LOWER($piece(YINHALT,".",$length(YINHALT,".")))
      strExtension.set(include.COMSYSString.$$$LOWER(m$,m$.Fnc.$piece(m$.var("YINHALT").get(),".",m$.Fnc.$length(m$.var("YINHALT").get(),"."))));
    }
    //<< }
    //<< 
    //<< ;IF YTYP'=1 QUIT:$GET(YHID)=2  ;HIDDEN READ ONLY WENN NICHT DATUM
    //<< 
    //<< if $get(YOLDVAL)'="" do  ;ALTEN WERT ODER VORGABE ANZEIGEN ;worthy Or default display
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YOLDVAL")),"")) {
      //<< . write YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . ;WRITE "<A HREF=""JavaScript:document."_YHTMFORM_".Y"_YFORM_YART_YLFN_".value='"_YOLDVAL_"'; document.WWW.focus();"">"
      //<< . write "<A onClick='return doLink(this)' HREF=""JavaScript:document."_YHTMFORM_".Y"_YFORM_YART_YLFN_".value='"_YOLDVAL_"';document."_YHTMFORM_".Y"_YFORM_YART_YLFN_".focus(); document.WWW.focus();"">"   ;TYBD; WEGEN FOCUS IM FELD;14,12,2003
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A onClick='return doLink(this)' HREF=\"JavaScript:document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),".value='"),m$.var("YOLDVAL").get()),"';document."),m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),".focus(); document.WWW.focus();\">"));
      //<< . write YCR,"<IMG SRC="""_YGIF_"dflt.gif"" ALIGN=ABSBOTTOM TITLE="""_$$^WWWTEXT(136)_" ("_YOLDVAL_")"" border=0>"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"dflt.gif\" ALIGN=ABSBOTTOM TITLE=\""),m$.fnc$("WWWTEXT.main",136))," ("),m$.var("YOLDVAL").get()),")\" border=0>"));
      //<< . write "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< new YWIDTH1,YHEIHT1,YBORDER,YI,YINHALT1,idChild
    mVar YWIDTH1 = m$.var("YWIDTH1");
    mVar YHEIHT1 = m$.var("YHEIHT1");
    mVar YBORDER = m$.var("YBORDER");
    mVar YI = m$.var("YI");
    mVar YINHALT1 = m$.var("YINHALT1");
    mVar idChild = m$.var("idChild");
    m$.newVar(YWIDTH1,YHEIHT1,YBORDER,YI,YINHALT1,idChild);
    //<< 
    //<< if $piece(YSATZ,Y,94)'=1 if YTYP'=1 if YTYP'=17 if YTYP'=3 quit:YINHALT=""
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),94),1)) {
      if (mOp.NotEqual(m$.var("YTYP").get(),1)) {
        if (mOp.NotEqual(m$.var("YTYP").get(),17)) {
          if (mOp.NotEqual(m$.var("YTYP").get(),3)) {
            if (mOp.Equal(m$.var("YINHALT").get(),"")) {
              return;
            }
          }
        }
      }
    }
    //<< if $length(YINHALT)>5 for  quit:$length(YINHALT)<5  quit:$extract($reverse(YINHALT))'=" "  set YINHALT=$reverse($extract($reverse(YINHALT),2,99))  ;LEERSTELLEN FILTERN
    if (mOp.Greater(m$.Fnc.$length(m$.var("YINHALT").get()),5)) {
      for (;true;) {
        if (mOp.Less(m$.Fnc.$length(m$.var("YINHALT").get()),5)) {
          break;
        }
        if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YINHALT").get()))," ")) {
          break;
        }
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YINHALT").get()),2,99)));
      }
    }
    //<< if YTYP'=3 quit:$find(YINHALT,"|")
    if (mOp.NotEqual(m$.var("YTYP").get(),3)) {
      if (mOp.Logical(m$.Fnc.$find(m$.var("YINHALT").get(),"|"))) {
        return;
      }
    }
    //<< ;IF YTYP'=3 IF YTYP'=1 QUIT:$FIND(YINHALT," ")
    //<< if YTYP'=3 if YTYP'=1 if $extract(YINHALT)'="+" quit:$find(YINHALT," ")    ;BEC;11.03.05;27475;WEGEN CALLTO BEFEHL MIT " "
    if (mOp.NotEqual(m$.var("YTYP").get(),3)) {
      if (mOp.NotEqual(m$.var("YTYP").get(),1)) {
        if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YINHALT").get()),"+")) {
          if (mOp.Logical(m$.Fnc.$find(m$.var("YINHALT").get()," "))) {
            return;
          }
        }
      }
    }
    //<< set YWIDTH1=100
    YWIDTH1.set(100);
    //<< set YHEIHT1=100
    YHEIHT1.set(100);
    //<< set YBORDER=1
    YBORDER.set(1);
    //<< for YI=53:1:56 if '$data(YO(YI)) set YO(YI)=""
    for (YI.set(53);(mOp.LessOrEqual(YI.get(),56));YI.set(mOp.Add(YI.get(),1))) {
      if (mOp.Not(m$.Fnc.$data(m$.var("YO").var(YI.get())))) {
        mVar YO = m$.var("YO");
        YO.var(YI.get()).set("");
      }
    }
    //<< if YO(53)=1 quit  ;KEIN OBJEKT ;no thing
    if (mOp.Equal(m$.var("YO").var(53).get(),1)) {
      return;
    }
    //<< if (+YO(54)'=0) || (+YO(55)'=0) {
    if ((mOp.NotEqual(mOp.Positive(m$.var("YO").var(54).get()),0)) || (mOp.NotEqual(mOp.Positive(m$.var("YO").var(55).get()),0))) {
      //<< set YWIDTH1=YO(54)
      YWIDTH1.set(m$.var("YO").var(54).get());
      //<< set YHEIHT1=YO(55)
      YHEIHT1.set(m$.var("YO").var(55).get());
    }
    //<< }
    //<< 
    //<< if +YO(56)'=0 set YBORDER=0
    if (mOp.NotEqual(mOp.Positive(m$.var("YO").var(56).get()),0)) {
      YBORDER.set(0);
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< if YART="D" if +$$$WWW122AbsPositionFromAbove(YSATZ)'=0 do   ;ABSOLUTE POSITIONIERUNG Anfang ;outset
    if (mOp.Equal(m$.var("YART").get(),"D")) {
      if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW122AbsPositionFromAbove(m$,m$.var("YSATZ"))),0)) {
        //<< . write YCR,"<div"
        m$.Cmd.Write(m$.var("YCR").get(),"<div");
        //<< . write " id=""objY"_YFORM_YART_YLFN_""""
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" id=\"objY",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
        //<< . write YCR," style=""border:none; background-color=#FFFFFF; position:absolute;"
        m$.Cmd.Write(m$.var("YCR").get()," style=\"border:none; background-color=#FFFFFF; position:absolute;");
        //<< . write " top:"_+$$$WWW122AbsPositionFromAbove(YSATZ)_"px;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" top:",mOp.Positive(include.WWWConst.$$$WWW122AbsPositionFromAbove(m$,m$.var("YSATZ")))),"px;"));
        //<< . if $$$WWW120PositioningOfButtonLine(YVOR)'=2 write " left:"_+$$$WWW122AbsPositionFromLeft(YSATZ)_"px;"
        if (mOp.NotEqual(include.WWWConst.$$$WWW120PositioningOfButtonLine(m$,m$.var("YVOR")),2)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" left:",mOp.Positive(include.WWWConst.$$$WWW122AbsPositionFromLeft(m$,m$.var("YSATZ")))),"px;"));
        }
        //<< . if $$$WWW120PositioningOfButtonLine(YVOR)=2  write " left:"_($$$WWW122AbsPositionFromLeft(YSATZ)+120)_"px;"
        if (mOp.Equal(include.WWWConst.$$$WWW120PositioningOfButtonLine(m$,m$.var("YVOR")),2)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" left:",(mOp.Add(include.WWWConst.$$$WWW122AbsPositionFromLeft(m$,m$.var("YSATZ")),120))),"px;"));
        }
        //<< . write " width:"_YWIDTH1_"px;"">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",YWIDTH1.get()),"px;\">"));
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; OTHER OBJECTS
    //<< ;---------------------------------------
    //<< if YTYP'=3 if YO(60)="" do  ;BILD UND VIDEO ;portrait And video
    if (mOp.NotEqual(m$.var("YTYP").get(),3)) {
      if (mOp.Equal(m$.var("YO").var(60).get(),"")) {
        //<< . new YINHALT0,URL
        mVar YINHALT0 = m$.var("YINHALT0");
        mVar URL = m$.var("URL");
        m$.newVarBlock(1,YINHALT0,URL);
        //<< . set YINHALT0=$translate(YINHALT,",",";")
        YINHALT0.set(m$.Fnc.$translate(m$.var("YINHALT").get(),",",";"));
        //<< . for YI=1:1 quit:$piece(YINHALT0,";",YI)=""  set YINHALT1=$piece(YINHALT0,";",YI) do
        for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
          if (mOp.Equal(m$.Fnc.$piece(YINHALT0.get(),";",YI.get()),"")) {
            break;
          }
          YINHALT1.set(m$.Fnc.$piece(YINHALT0.get(),";",YI.get()));
          do {
            //<< . . //IF $FIND(YINHALT1,".GIF")!($FIND(YINHALT1,".gif"))!($FIND(YINHALT1,".JPG"))!($FIND(YINHALT1,".jpg")) DO  QUIT
            //<< . . if '$find(YINHALT1,".") quit
            if (mOp.Not(m$.Fnc.$find(YINHALT1.get(),"."))) {
              break;
            }
            //<< . . ;SR18076 new strExtension
            //<< . . ;SR18076 set strExtension = $$$LOWER($piece(YINHALT1,".",$length(YINHALT1,".")))    //SR12918
            //<< . . ;SR18076 if (strExtension="gif")||(strExtension="jpg") do  quit
            //<< . . if $$IsImageType($piece(YINHALT1,".",$length(YINHALT1,"."))) do  quit
            if (mOp.Logical(m$.fnc$("IsImageType",m$.Fnc.$piece(YINHALT1.get(),".",m$.Fnc.$length(YINHALT1.get(),"."))))) {
              //<< . . . if '$find(YINHALT1,"/") if '$find(YINHALT1,"\") do   ;SPEICHERORT
              if (mOp.Not(m$.Fnc.$find(YINHALT1.get(),"/"))) {
                if (mOp.Not(m$.Fnc.$find(YINHALT1.get(),"\\"))) {
                  do {
                    //<< . . . . if $piece(YSATZ,Y,57)'="" if YART="D"!(YART="M") do  quit
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),57),"")) {
                      if (mOp.Or(mOp.Equal(m$.var("YART").get(),"D"),(mOp.Equal(m$.var("YART").get(),"M")))) {
                        do {
                          //<< . . . . . new PATH
                          mVar PATH = m$.var("PATH");
                          m$.newVarBlock(5,PATH);
                          //<< . . . . . set PATH=$$$WWW122ListOfObjects(YSATZ)
                          PATH.set(include.WWWConst.$$$WWW122ListOfObjects(m$,m$.var("YSATZ")));
                          //<< . . . . . if PATH="YGIF" set YINHALT1=YGIF_YINHALT quit
                          if (mOp.Equal(PATH.get(),"YGIF")) {
                            YINHALT1.set(mOp.Concat(m$.var("YGIF").get(),m$.var("YINHALT").get()));
                            break;
                          }
                          //<< . . . . . if PATH="YGIF1" set YINHALT1=YGIF1_YINHALT quit
                          if (mOp.Equal(PATH.get(),"YGIF1")) {
                            YINHALT1.set(mOp.Concat(m$.var("YGIF1").get(),m$.var("YINHALT").get()));
                            break;
                          }
                          //<< . . . . . if $find(PATH,"##") do
                          if (mOp.Logical(m$.Fnc.$find(PATH.get(),"##"))) {
                            //<< . . . . . . set PATH=$piece(PATH,"##",1)_$piece($translate($piece(objCompany,Y,1),"-,+#/\()[]")," ",1)_$piece(PATH,"##",2)
                            PATH.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(PATH.get(),"##",1),m$.Fnc.$piece(m$.Fnc.$translate(m$.Fnc.$piece(objCompany.get(),m$.var("Y").get(),1),"-,+#/\\()[]")," ",1)),m$.Fnc.$piece(PATH.get(),"##",2)));
                          }
                          //<< . . . . . ;
                          //<< . . . . . set YINHALT1=PATH_YINHALT1
                          YINHALT1.set(mOp.Concat(PATH.get(),YINHALT1.get()));
                        } while (false);
                        break;
                      }
                      m$.restoreVarBlock(5);
                    }
                    //<< . . . . ;
                    //<< . . . . set:$extract(YFORM,1,3)'="WWW" YINHALT1=YGIF1_YINHALT1
                    if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
                      YINHALT1.set(mOp.Concat(m$.var("YGIF1").get(),YINHALT1.get()));
                    }
                    //<< . . . . set:$extract(YFORM,1,3)="WWW" YINHALT1=YGIF_YINHALT1
                    if (mOp.Equal(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
                      YINHALT1.set(mOp.Concat(m$.var("YGIF").get(),YINHALT1.get()));
                    }
                  } while (false);
                }
              }
              //<< . . . ;
              //<< . . . if $find(YINHALT1,"\") do   ;WENN GLEICHES VERZEICHNIS ABER MIT \ ;when same tabulation yet by means of
              if (mOp.Logical(m$.Fnc.$find(YINHALT1.get(),"\\"))) {
                do {
                  //<< . . . . set YINHALT1=$translate(YINHALT1,"\","/")
                  YINHALT1.set(m$.Fnc.$translate(YINHALT1.get(),"\\","/"));
                  //<< . . . . if $find($$$LOWER(YINHALT1),$$$LOWER(YGIF)) set YINHALT1=YGIF_$piece($$$LOWER(YINHALT1),$$$LOWER(YGIF),2,999) quit
                  if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$LOWER(m$,YINHALT1),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF"))))) {
                    YINHALT1.set(mOp.Concat(m$.var("YGIF").get(),m$.Fnc.$piece(include.COMSYSString.$$$LOWER(m$,YINHALT1),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF")),2,999)));
                    break;
                  }
                  //<< . . . . if $find($$$LOWER(YINHALT1),$$$LOWER(YGIF1)) set YINHALT1=YGIF1_$piece($$$LOWER(YINHALT1),$$$LOWER(YGIF1),2,999) quit
                  if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$LOWER(m$,YINHALT1),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF1"))))) {
                    YINHALT1.set(mOp.Concat(m$.var("YGIF1").get(),m$.Fnc.$piece(include.COMSYSString.$$$LOWER(m$,YINHALT1),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF1")),2,999)));
                    break;
                  }
                } while (false);
              }
              //<< . . . ;
              //<< . . . set URL = $translate(YINHALT1,"|")    // SR12918
              URL.set(m$.Fnc.$translate(YINHALT1.get(),"|"));
              //<< . . . ;
              //<< . . . if +$piece(YSATZ,Y,58)=0 write "&nbsp;"
              if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),58)),0)) {
                m$.Cmd.Write("&nbsp;");
              }
              //<< . . . ;IF YWIDTH1'=999 W YCR,"<iframe WIDTH="_YWIDTH1_" HEIGHT="_YHEIHT1_" SRC="""_$TR(YINHALT1,"|")_""" BORDER="_YBORDER_" title="""_$P(YINHALT1,".",1)_"""></iframe>"
              //<< . . . if +YWIDTH1'=0 if YWIDTH1'=999 write YCR,"<IMG SRC="""_URL_""" BORDER="_YBORDER_" WIDTH="_YWIDTH1_" VALIGN=TOP ALIGN=TEXTTOP TITLE="""_$piece(YINHALT1,".",1)_""">"
              if (mOp.NotEqual(mOp.Positive(YWIDTH1.get()),0)) {
                if (mOp.NotEqual(YWIDTH1.get(),999)) {
                  m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",URL.get()),"\" BORDER="),YBORDER.get())," WIDTH="),YWIDTH1.get())," VALIGN=TOP ALIGN=TEXTTOP TITLE=\""),m$.Fnc.$piece(YINHALT1.get(),".",1)),"\">"));
                }
              }
              //<< . . . if +YWIDTH1=0 if YHEIHT1'=0 if YWIDTH1'=999 write YCR,"<IMG SRC="""_URL_""" BORDER="_YBORDER_" HEIGHT="_YHEIHT1_" VALIGN=TOP ALIGN=TEXTTOP TITLE="""_$piece(YINHALT1,".",1)_""">"
              if (mOp.Equal(mOp.Positive(YWIDTH1.get()),0)) {
                if (mOp.NotEqual(YHEIHT1.get(),0)) {
                  if (mOp.NotEqual(YWIDTH1.get(),999)) {
                    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",URL.get()),"\" BORDER="),YBORDER.get())," HEIGHT="),YHEIHT1.get())," VALIGN=TOP ALIGN=TEXTTOP TITLE=\""),m$.Fnc.$piece(YINHALT1.get(),".",1)),"\">"));
                  }
                }
              }
              //<< . . . if YWIDTH1=999 write YCR,"<BR><A HREF=""#start""><IMG SRC="""_URL_""" BORDER="_YBORDER_" VALIGN=TOP ALIGN=TEXTTOP TITLE="""_$piece(YINHALT1,".",1)_""" USEMAP=""#WWW_MAP"" ISMAP><MAP NAME=""WWW_MAP"">" write "</MAP></A>"
              if (mOp.Equal(YWIDTH1.get(),999)) {
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<BR><A HREF=\"#start\"><IMG SRC=\"",URL.get()),"\" BORDER="),YBORDER.get())," VALIGN=TOP ALIGN=TEXTTOP TITLE=\""),m$.Fnc.$piece(YINHALT1.get(),".",1)),"\" USEMAP=\"#WWW_MAP\" ISMAP><MAP NAME=\"WWW_MAP\">"));
                m$.Cmd.Write("</MAP></A>");
              }
              //<< . . . do  ;MIT VERGRÖßERUNG DES BILDES ;by means of enlargement
              do {
                //<< . . . . //NEW URL
                //<< . . . . write YCR
                m$.Cmd.Write(m$.var("YCR").get());
                //<< . . . . //SET YURL=$$$WWW012VirtualWWWDirectory(objCompany)
                //<< . . . . set OPT="HEIGHT=300,WIDTH=300,SCROLLBARS=YES,RESIZEABLE=YES"
                mVar OPT = m$.var("OPT");
                OPT.set("HEIGHT=300,WIDTH=300,SCROLLBARS=YES,RESIZEABLE=YES");
                //<< . . . . //SET URL=""_YURL_$TRANSLATE(YINHALT1,"|")
                //<< . . . . write "<INPUT TYPE=BUTTON NAME='B"_$get(YKEY)_"' onClick='var menue=window.open("""_URL_""",""DOK"","""_OPT_""");menue.focus();' VALUE='"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=BUTTON NAME='B",m$.Fnc.$get(m$.var("YKEY"))),"' onClick='var menue=window.open(\""),URL.get()),"\",\"DOK\",\""),OPT.get()),"\");menue.focus();' VALUE='"));
                //<< . . . . write "'>"
                m$.Cmd.Write("'>");
              } while(false);
              break;
            }
            //<< . . ;
            //<< . . if (strExtension="avi") do  quit        //SR12918
            if ((mOp.Equal(strExtension.get(),"avi"))) {
              //<< . . . if '$find(YINHALT1,"/") if '$find(YINHALT1,"\") do   ;SPEICHERORT
              if (mOp.Not(m$.Fnc.$find(YINHALT1.get(),"/"))) {
                if (mOp.Not(m$.Fnc.$find(YINHALT1.get(),"\\"))) {
                  do {
                    //<< . . . . if $piece(YSATZ,Y,57)'="" if (YART="D") || (YART="M") do  quit
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),57),"")) {
                      if ((mOp.Equal(m$.var("YART").get(),"D")) || (mOp.Equal(m$.var("YART").get(),"M"))) {
                        do {
                          //<< . . . . . new PATH
                          mVar PATH = m$.var("PATH");
                          m$.newVarBlock(5,PATH);
                          //<< . . . . . set PATH=$piece(YSATZ,Y,57)
                          PATH.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),57));
                          //<< . . . . . if PATH="YGIF"  set YINHALT1=YGIF_YINHALT  quit
                          if (mOp.Equal(PATH.get(),"YGIF")) {
                            YINHALT1.set(mOp.Concat(m$.var("YGIF").get(),m$.var("YINHALT").get()));
                            break;
                          }
                          //<< . . . . . if PATH="YGIF1" set YINHALT1=YGIF1_YINHALT quit
                          if (mOp.Equal(PATH.get(),"YGIF1")) {
                            YINHALT1.set(mOp.Concat(m$.var("YGIF1").get(),m$.var("YINHALT").get()));
                            break;
                          }
                          //<< . . . . . if $find(PATH,"##") do
                          if (mOp.Logical(m$.Fnc.$find(PATH.get(),"##"))) {
                            //<< . . . . . . set PATH=$piece(PATH,"##",1)_$piece($translate($piece(objCompany,Y,1),"-,+#/\()[]")," ",1)_$piece(PATH,"##",2)
                            PATH.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(PATH.get(),"##",1),m$.Fnc.$piece(m$.Fnc.$translate(m$.Fnc.$piece(objCompany.get(),m$.var("Y").get(),1),"-,+#/\\()[]")," ",1)),m$.Fnc.$piece(PATH.get(),"##",2)));
                          }
                          //<< . . . . . ;
                          //<< . . . . . set YINHALT1=PATH_YINHALT1
                          YINHALT1.set(mOp.Concat(PATH.get(),YINHALT1.get()));
                        } while (false);
                        break;
                      }
                      m$.restoreVarBlock(5);
                    }
                    //<< . . . . ;
                    //<< . . . . set:$extract(YFORM,1,3)'="WWW" YINHALT1=YGIF1_YINHALT1
                    if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
                      YINHALT1.set(mOp.Concat(m$.var("YGIF1").get(),YINHALT1.get()));
                    }
                    //<< . . . . set:$extract(YFORM,1,3)="WWW" YINHALT1=YGIF_YINHALT1
                    if (mOp.Equal(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
                      YINHALT1.set(mOp.Concat(m$.var("YGIF").get(),YINHALT1.get()));
                    }
                  } while (false);
                }
              }
              //<< . . . ;
              //<< . . . if $find(YINHALT1,"\") do   ;WENN GLEICHES VERZEICHNIS ABER MIT \ ;when same tabulation yet by means of
              if (mOp.Logical(m$.Fnc.$find(YINHALT1.get(),"\\"))) {
                do {
                  //<< . . . . set YINHALT1=$translate(YINHALT1,"\","/")
                  YINHALT1.set(m$.Fnc.$translate(YINHALT1.get(),"\\","/"));
                  //<< . . . . if $find($$$LOWER(YINHALT1),$$$LOWER(YGIF))  set YINHALT1=YGIF_$piece($$$LOWER(YINHALT1),$$$LOWER(YGIF),2,999)   quit
                  if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$LOWER(m$,YINHALT1),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF"))))) {
                    YINHALT1.set(mOp.Concat(m$.var("YGIF").get(),m$.Fnc.$piece(include.COMSYSString.$$$LOWER(m$,YINHALT1),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF")),2,999)));
                    break;
                  }
                  //<< . . . . if $find($$$LOWER(YINHALT1),$$$LOWER(YGIF1)) set YINHALT1=YGIF1_$piece($$$LOWER(YINHALT1),$$$LOWER(YGIF1),2,999) quit
                  if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$LOWER(m$,YINHALT1),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF1"))))) {
                    YINHALT1.set(mOp.Concat(m$.var("YGIF1").get(),m$.Fnc.$piece(include.COMSYSString.$$$LOWER(m$,YINHALT1),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF1")),2,999)));
                    break;
                  }
                } while (false);
              }
              //<< . . . ;
              //<< . . . write YCR ;W "&nbsp;"
              m$.Cmd.Write(m$.var("YCR").get());
              //<< . . . write "<CENTER><IMG DYNSRC="""_YINHALT1_""" BORDER="_YBORDER_" START=mouseover></CENTER>"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<CENTER><IMG DYNSRC=\"",YINHALT1.get()),"\" BORDER="),YBORDER.get())," START=mouseover></CENTER>"));
              break;
            }
          } while (false);
        }
      }
      m$.restoreVarBlock(1);
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; Show Pictures      ; BILDER ;GIF ANZEIGE
    //<< ;---------------------------------------
    //<< if YTYP'=3 if YO(60)'="" do
    if (mOp.NotEqual(m$.var("YTYP").get(),3)) {
      if (mOp.NotEqual(m$.var("YO").var(60).get(),"")) {
        do {
          //<< . ;SR18076 if (strExtension="gif")||(strExtension="jpg") do  quit       //SR12918
          //<< . if $$IsImageType(strExtension) do  quit
          if (mOp.Logical(m$.fnc$("IsImageType",strExtension.get()))) {
            //<< . . if '$find(YINHALT,"/") do
            if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get(),"/"))) {
              do {
                //<< . . . if $piece(YSATZ,Y,57)'="" if (YART="D") || (YART="M") do  quit
                if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),57),"")) {
                  if ((mOp.Equal(m$.var("YART").get(),"D")) || (mOp.Equal(m$.var("YART").get(),"M"))) {
                    do {
                      //<< . . . . new PATH
                      mVar PATH = m$.var("PATH");
                      m$.newVarBlock(4,PATH);
                      //<< . . . . set PATH=$piece(YSATZ,Y,57)
                      PATH.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),57));
                      //<< . . . . if PATH="YGIF"  set YINHALT1=YGIF_YINHALT  quit
                      if (mOp.Equal(PATH.get(),"YGIF")) {
                        YINHALT1.set(mOp.Concat(m$.var("YGIF").get(),m$.var("YINHALT").get()));
                        break;
                      }
                      //<< . . . . if PATH="YGIF1" set YINHALT1=YGIF1_YINHALT quit
                      if (mOp.Equal(PATH.get(),"YGIF1")) {
                        YINHALT1.set(mOp.Concat(m$.var("YGIF1").get(),m$.var("YINHALT").get()));
                        break;
                      }
                      //<< . . . . if $find(PATH,"##") do
                      if (mOp.Logical(m$.Fnc.$find(PATH.get(),"##"))) {
                        //<< . . . . . set PATH=$piece(PATH,"##",1)_$piece($translate($piece(objCompany,Y,1),"-,+#/\()[]")," ",1)_$piece(PATH,"##",2)
                        PATH.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(PATH.get(),"##",1),m$.Fnc.$piece(m$.Fnc.$translate(m$.Fnc.$piece(objCompany.get(),m$.var("Y").get(),1),"-,+#/\\()[]")," ",1)),m$.Fnc.$piece(PATH.get(),"##",2)));
                      }
                      //<< . . . . ;
                      //<< . . . . set YINHALT1=PATH_YINHALT1
                      YINHALT1.set(mOp.Concat(PATH.get(),YINHALT1.get()));
                    } while (false);
                    break;
                  }
                  m$.restoreVarBlock(4);
                }
                //<< . . . ;
                //<< . . . set:$extract(YFORM,1,3)'="WWW" YINHALT=YGIF1_YINHALT
                if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
                  m$.var("YINHALT").set(mOp.Concat(m$.var("YGIF1").get(),m$.var("YINHALT").get()));
                }
                //<< . . . set:$extract(YFORM,1,3)="WWW" YINHALT=YGIF_YINHALT
                if (mOp.Equal(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
                  m$.var("YINHALT").set(mOp.Concat(m$.var("YGIF").get(),m$.var("YINHALT").get()));
                }
              } while (false);
            }
            //<< . . ;
            //<< . . if $find(YINHALT,"\") do   ;WENN GLEICHES VERZEICHNIS ABER MIT \ ;when same tabulation yet by means of
            if (mOp.Logical(m$.Fnc.$find(m$.var("YINHALT").get(),"\\"))) {
              do {
                //<< . . . set YINHALT=$translate(YINHALT,"\","/")
                mVar YINHALT = m$.var("YINHALT");
                YINHALT.set(m$.Fnc.$translate(m$.var("YINHALT").get(),"\\","/"));
                //<< . . . if $find($$$LOWER(YINHALT),$$$LOWER(YGIF))  set YINHALT=YGIF_$piece($$$LOWER(YINHALT),$$$LOWER(YGIF),2,999)   quit
                if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF"))))) {
                  YINHALT.set(mOp.Concat(m$.var("YGIF").get(),m$.Fnc.$piece(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF")),2,999)));
                  break;
                }
                //<< . . . if $find($$$LOWER(YINHALT),$$$LOWER(YGIF1)) set YINHALT=YGIF1_$piece($$$LOWER(YINHALT),$$$LOWER(YGIF1),2,999) quit
                if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF1"))))) {
                  YINHALT.set(mOp.Concat(m$.var("YGIF1").get(),m$.Fnc.$piece(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF1")),2,999)));
                  break;
                }
              } while (false);
            }
            //<< . . ;
            //<< . . if +$piece(YSATZ,Y,58)=0 write "&nbsp;"
            if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),58)),0)) {
              m$.Cmd.Write("&nbsp;");
            }
            //<< . . write YCR
            m$.Cmd.Write(m$.var("YCR").get());
            //<< . . set OPT="HEIGHT=300,WIDTH=300,SCROLLBARS=YES,RESIZEABLE=YES"
            mVar OPT = m$.var("OPT");
            OPT.set("HEIGHT=300,WIDTH=300,SCROLLBARS=YES,RESIZEABLE=YES");
            //<< . . write "<INPUT TYPE=BUTTON NAME='B"_YKEY_"' onClick='var menue=window.open("""_YINHALT_""",""DOK"","""_OPT_""");menue.focus();' VALUE='"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=BUTTON NAME='B",m$.var("YKEY").get()),"' onClick='var menue=window.open(\""),m$.var("YINHALT").get()),"\",\"DOK\",\""),OPT.get()),"\");menue.focus();' VALUE='"));
            //<< . . write "'>"
            m$.Cmd.Write("'>");
            break;
          }
        } while (false);
      }
    }
    //<< 
    //<< if YART="D" if +$piece(YSATZ,Y,58)'=0 write YCR,"</div>"  ;ENDE POSITION ;termination
    if (mOp.Equal(m$.var("YART").get(),"D")) {
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),58)),0)) {
        m$.Cmd.Write(m$.var("YCR").get(),"</div>");
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; Show PDF   ;PDF ANZEIGE
    //<< ;---------------------------------------
    //<< if YTYP'=3 do
    if (mOp.NotEqual(m$.var("YTYP").get(),3)) {
      do {
        //<< . if strExtension'="pdf" quit               //SR12918
        if (mOp.NotEqual(strExtension.get(),"pdf")) {
          break;
        }
        //<< . do
        do {
          //<< . . if '$find(YINHALT,"/") do
          if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get(),"/"))) {
            do {
              //<< . . . if $piece(YSATZ,Y,57)'="" if (YART="D") || (YART="M") do  quit
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),57),"")) {
                if ((mOp.Equal(m$.var("YART").get(),"D")) || (mOp.Equal(m$.var("YART").get(),"M"))) {
                  do {
                    //<< . . . . new PATH
                    mVar PATH = m$.var("PATH");
                    m$.newVarBlock(4,PATH);
                    //<< . . . . set PATH=$piece(YSATZ,Y,57)
                    PATH.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),57));
                    //<< . . . . if PATH="YGIF"  set YINHALT1=YGIF_YINHALT  quit
                    if (mOp.Equal(PATH.get(),"YGIF")) {
                      YINHALT1.set(mOp.Concat(m$.var("YGIF").get(),m$.var("YINHALT").get()));
                      break;
                    }
                    //<< . . . . if PATH="YGIF1" set YINHALT1=YGIF1_YINHALT quit
                    if (mOp.Equal(PATH.get(),"YGIF1")) {
                      YINHALT1.set(mOp.Concat(m$.var("YGIF1").get(),m$.var("YINHALT").get()));
                      break;
                    }
                    //<< . . . . if $find(PATH,"##") do
                    if (mOp.Logical(m$.Fnc.$find(PATH.get(),"##"))) {
                      //<< . . . . . set PATH=$piece(PATH,"##",1)_$piece($translate($piece(objCompany,Y,1),"-,+#/\()[]")," ",1)_$piece(PATH,"##",2)
                      PATH.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(PATH.get(),"##",1),m$.Fnc.$piece(m$.Fnc.$translate(m$.Fnc.$piece(objCompany.get(),m$.var("Y").get(),1),"-,+#/\\()[]")," ",1)),m$.Fnc.$piece(PATH.get(),"##",2)));
                    }
                    //<< . . . . ;
                    //<< . . . . set YINHALT1=PATH_YINHALT1
                    YINHALT1.set(mOp.Concat(PATH.get(),YINHALT1.get()));
                  } while (false);
                  break;
                }
                m$.restoreVarBlock(4);
              }
              //<< . . . ;
              //<< . . . set:$extract(YFORM,1,3)'="WWW" YINHALT=YGIF1_YINHALT
              if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
                m$.var("YINHALT").set(mOp.Concat(m$.var("YGIF1").get(),m$.var("YINHALT").get()));
              }
              //<< . . . set:$extract(YFORM,1,3)="WWW" YINHALT=YGIF_YINHALT
              if (mOp.Equal(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
                m$.var("YINHALT").set(mOp.Concat(m$.var("YGIF").get(),m$.var("YINHALT").get()));
              }
            } while (false);
          }
          //<< . . ;
          //<< . . if $find(YINHALT,"\") do   ;WENN GLEICHES VERZEICHNIS ABER MIT \ ;when same tabulation yet by means of
          if (mOp.Logical(m$.Fnc.$find(m$.var("YINHALT").get(),"\\"))) {
            do {
              //<< . . . set YINHALT=$translate(YINHALT,"\","/")
              mVar YINHALT = m$.var("YINHALT");
              YINHALT.set(m$.Fnc.$translate(m$.var("YINHALT").get(),"\\","/"));
              //<< . . . if $find($$$LOWER(YINHALT),$$$LOWER(YGIF))  set YINHALT=YGIF_$piece($$$LOWER(YINHALT),$$$LOWER(YGIF),2,999)   quit
              if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF"))))) {
                YINHALT.set(mOp.Concat(m$.var("YGIF").get(),m$.Fnc.$piece(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF")),2,999)));
                break;
              }
              //<< . . . if $find($$$LOWER(YINHALT),$$$LOWER(YGIF1)) set YINHALT=YGIF1_$piece($$$LOWER(YINHALT),$$$LOWER(YGIF1),2,999) quit
              if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF1"))))) {
                YINHALT.set(mOp.Concat(m$.var("YGIF1").get(),m$.Fnc.$piece(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF1")),2,999)));
                break;
              }
            } while (false);
          }
          //<< . . ;
          //<< . . if +$piece(YSATZ,Y,58)=0 write "&nbsp;"
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),58)),0)) {
            m$.Cmd.Write("&nbsp;");
          }
          //<< . . write YCR
          m$.Cmd.Write(m$.var("YCR").get());
          //<< . . write "<A HREF=""" ;_"http://"
          m$.Cmd.Write("<A HREF=\"");
          //<< . . write YINHALT
          m$.Cmd.Write(m$.var("YINHALT").get());
          //<< . . write """ TARGET=WWWWW>"
          m$.Cmd.Write("\" TARGET=WWWWW>");
          //<< . . write YCR,"<IMG SRC="""_YGIF_"pdf.gif"" ALIGN=ABSBOTTOM TITLE=""Acrobat Reader"" border=0>"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"pdf.gif\" ALIGN=ABSBOTTOM TITLE=\"Acrobat Reader\" border=0>"));
          //<< . . write "</A>"
          m$.Cmd.Write("</A>");
        } while(false);
      } while (false);
    }
    //<< 
    //<< 
    //<< ;---------------------------------------
    //<< ; Show DOC   ;DOC ANZEIGE
    //<< ;---------------------------------------
    //<< if YTYP'=3 do
    if (mOp.NotEqual(m$.var("YTYP").get(),3)) {
      do {
        //<< . if strExtension'="doc" quit               //SR12918
        if (mOp.NotEqual(strExtension.get(),"doc")) {
          break;
        }
        //<< . do
        do {
          //<< . . if '$find(YINHALT,"/") do
          if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get(),"/"))) {
            do {
              //<< . . . if $piece(YSATZ,Y,57)'="" if (YART="D") || (YART="M") do  quit
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),57),"")) {
                if ((mOp.Equal(m$.var("YART").get(),"D")) || (mOp.Equal(m$.var("YART").get(),"M"))) {
                  do {
                    //<< . . . . new PATH
                    mVar PATH = m$.var("PATH");
                    m$.newVarBlock(4,PATH);
                    //<< . . . . set PATH=$piece(YSATZ,Y,57)
                    PATH.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),57));
                    //<< . . . . if PATH="YGIF"  set YINHALT1=YGIF_YINHALT  quit
                    if (mOp.Equal(PATH.get(),"YGIF")) {
                      YINHALT1.set(mOp.Concat(m$.var("YGIF").get(),m$.var("YINHALT").get()));
                      break;
                    }
                    //<< . . . . if PATH="YGIF1" set YINHALT1=YGIF1_YINHALT quit
                    if (mOp.Equal(PATH.get(),"YGIF1")) {
                      YINHALT1.set(mOp.Concat(m$.var("YGIF1").get(),m$.var("YINHALT").get()));
                      break;
                    }
                    //<< . . . . if $find(PATH,"##") do
                    if (mOp.Logical(m$.Fnc.$find(PATH.get(),"##"))) {
                      //<< . . . . . set PATH=$piece(PATH,"##",1)_$piece($translate($piece(objCompany,Y,1),"-,+#/\()[]")," ",1)_$piece(PATH,"##",2)
                      PATH.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(PATH.get(),"##",1),m$.Fnc.$piece(m$.Fnc.$translate(m$.Fnc.$piece(objCompany.get(),m$.var("Y").get(),1),"-,+#/\\()[]")," ",1)),m$.Fnc.$piece(PATH.get(),"##",2)));
                    }
                    //<< . . . . ;
                    //<< . . . . set YINHALT1=PATH_YINHALT1
                    YINHALT1.set(mOp.Concat(PATH.get(),YINHALT1.get()));
                  } while (false);
                  break;
                }
                m$.restoreVarBlock(4);
              }
              //<< . . . ;
              //<< . . . set:$extract(YFORM,1,3)'="WWW" YINHALT=YGIF1_YINHALT
              if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
                m$.var("YINHALT").set(mOp.Concat(m$.var("YGIF1").get(),m$.var("YINHALT").get()));
              }
              //<< . . . set:$extract(YFORM,1,3)="WWW" YINHALT=YGIF_YINHALT
              if (mOp.Equal(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
                m$.var("YINHALT").set(mOp.Concat(m$.var("YGIF").get(),m$.var("YINHALT").get()));
              }
            } while (false);
          }
          //<< . . ;
          //<< . . ; Restore missing line based on other blocks    SRBR014310
          //<< . . if $find(YINHALT,"\") do   ;WENN GLEICHES VERZEICHNIS ABER MIT \ ;when same tabulation yet by means of
          if (mOp.Logical(m$.Fnc.$find(m$.var("YINHALT").get(),"\\"))) {
            do {
              //<< . . . set YINHALT=$translate(YINHALT,"\","/")
              mVar YINHALT = m$.var("YINHALT");
              YINHALT.set(m$.Fnc.$translate(m$.var("YINHALT").get(),"\\","/"));
              //<< . . . if $find($$$LOWER(YINHALT),$$$LOWER(YGIF))  set YINHALT=YGIF_$piece($$$LOWER(YINHALT),$$$LOWER(YGIF),2,999)   quit
              if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF"))))) {
                YINHALT.set(mOp.Concat(m$.var("YGIF").get(),m$.Fnc.$piece(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF")),2,999)));
                break;
              }
              //<< . . . if $find($$$LOWER(YINHALT),$$$LOWER(YGIF1)) set YINHALT=YGIF1_$piece($$$LOWER(YINHALT),$$$LOWER(YGIF1),2,999) quit
              if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF1"))))) {
                YINHALT.set(mOp.Concat(m$.var("YGIF1").get(),m$.Fnc.$piece(include.COMSYSString.$$$LOWER(m$,YINHALT),include.COMSYSString.$$$LOWER(m$,m$.var("YGIF1")),2,999)));
                break;
              }
            } while (false);
          }
          //<< . . ;
          //<< . . ;IF +$PIECE(YSATZ,Y,58)=0 WRITE "&nbsp;"
          //<< . . write YCR
          m$.Cmd.Write(m$.var("YCR").get());
          //<< . . //SET YURL=$PIECE(objCompany,Y,44)      //SR12918
          //<< . . //SET URL=""_YURL_YINHALT
          //<< . . write "<A HREF=""" ;_"http://"
          m$.Cmd.Write("<A HREF=\"");
          //<< . . //WRITE URL
          //<< . . write YINHALT
          m$.Cmd.Write(m$.var("YINHALT").get());
          //<< . . write """ TARGET=WWWWW>"
          m$.Cmd.Write("\" TARGET=WWWWW>");
          //<< . . write YCR,"<IMG SRC="""_YGIF_"data.gif"" ALIGN=ABSBOTTOM TITLE=""Word"" border=0 id=""BUTTON_DOC"">"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"data.gif\" ALIGN=ABSBOTTOM TITLE=\"Word\" border=0 id=\"BUTTON_DOC\">"));
          //<< . . write "</A>"
          m$.Cmd.Write("</A>");
        } while(false);
      } while (false);
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;MAILTO
    //<< ; FIXME : <GRF> check logic of tests - AND and OR mixed as separate tests
    //<< ;         Combine to clarify intended use.
    //<< ;         e.g. (w && x && y) || (z)  [as currently]   or   (w) && (x) && (y || z)
    //<< ;---------------------------------------
    //<< if YTYP'=3 if ($extract(YINHALT)'="@") && ($find(YINHALT,"@")) && ('$find(YINHALT," ")) || ($get(YXTYP)=12) do  quit  ;E-MAIL
    if (mOp.NotEqual(m$.var("YTYP").get(),3)) {
      if ((mOp.NotEqual(m$.Fnc.$extract(m$.var("YINHALT").get()),"@")) && mOp.Logical((m$.Fnc.$find(m$.var("YINHALT").get(),"@"))) && (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get()," "))) || (mOp.Equal(m$.Fnc.$get(m$.var("YXTYP")),12))) {
        //<< . write YCR ;W "&nbsp;"
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . write "<A HREF=""mailto:"
        m$.Cmd.Write("<A HREF=\"mailto:");
        //<< . write YINHALT
        m$.Cmd.Write(m$.var("YINHALT").get());
        //<< . write """>"
        m$.Cmd.Write("\">");
        //<< . write YCR,"<IMG SRC="""_YGIF_"mail.gif"" ALIGN=ABSBOTTOM TITLE=""E-Mail"" border=0 id=""BUTTON_MAIL"">"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"mail.gif\" ALIGN=ABSBOTTOM TITLE=\"E-Mail\" border=0 id=\"BUTTON_MAIL\">"));
        //<< . write "</A>"
        m$.Cmd.Write("</A>");
        return;
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; Telephone Call     ;TELEFON CALL
    //<< ;---------------------------------------
    //<< ;IF $EXTRACT(YINHALT)="+" IF +$EXTRACT(YINHALT,2,99)'=0 IF $LENGTH(+YINHALT)>6 IF $PIECE(objCompany,Y,92)=1 DO ;MIT TELEFONANWAHL =1 ;TYBD;6,12,2004
    //<< if $extract(YINHALT)="+" if +$extract($translate(YINHALT," "),2,99)'=0 if $length(+$translate(YINHALT," "))>6 if $piece(objCompany,Y,92)=1 do ;MIT TELEFONANWAHL =1 ;bec;11,03,2005;27475
    if (mOp.Equal(m$.Fnc.$extract(m$.var("YINHALT").get()),"+")) {
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$extract(m$.Fnc.$translate(m$.var("YINHALT").get()," "),2,99)),0)) {
        if (mOp.Greater(m$.Fnc.$length(mOp.Positive(m$.Fnc.$translate(m$.var("YINHALT").get()," "))),6)) {
          if (mOp.Equal(m$.Fnc.$piece(objCompany.get(),m$.var("Y").get(),92),1)) {
            //<< . new FILE
            mVar FILE = m$.var("FILE");
            m$.newVarBlock(1,FILE);
            //<< . ;WRITE "&nbsp;"
            //<< . write YCR,"<A HREF=""CALLTO://"_$translate(YINHALT,"()-.#*_  &/!?")_""">"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<A HREF=\"CALLTO://",m$.Fnc.$translate(m$.var("YINHALT").get(),"()-.#*_  &/!?")),"\">"));
            //<< . write YCR,"<IMG SRC="""_YGIF_"verbind.gif"" ALIGN=TEXTTOP TITLE=""Telefon"" border=0 id=""BUTTON_PHONE"">"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"verbind.gif\" ALIGN=TEXTTOP TITLE=\"Telefon\" border=0 id=\"BUTTON_PHONE\">"));
            //<< . write "</A>"
            m$.Cmd.Write("</A>");
          }
          m$.restoreVarBlock(1);
        }
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;WWW VERZEICHNIS ;WWW tabulation
    //<< ;---------------------------------------
    //<< ;IF YTYP'=3 IF $GET(YXTYP)=13!($EXTRACT(YINHALT,1,4)="www.")!($EXTRACT(YINHALT,1,4)="WWW.") IF '$FIND(YINHALT,"@") IF '$FIND(YINHALT," ") IF $LENGTH(YINHALT,".")>2 DO  QUIT  ;WWW.XXX.COM
    //<< if YTYP'=3 if ($get(YXTYP)=13) || ($extract(YINHALT,1,4)="www.") || ($extract(YINHALT,1,4)="WWW.") || ($extract(YINHALT,1,7)="http://") if '$find(YINHALT,"@") if '$find(YINHALT," ") if $length(YINHALT,".")>2 do  quit  ;WWW.XXX.COM  ;AUCH OHNE WWW;FIS;21.06.04
    if (mOp.NotEqual(m$.var("YTYP").get(),3)) {
      if ((mOp.Equal(m$.Fnc.$get(m$.var("YXTYP")),13)) || (mOp.Equal(m$.Fnc.$extract(m$.var("YINHALT").get(),1,4),"www.")) || (mOp.Equal(m$.Fnc.$extract(m$.var("YINHALT").get(),1,4),"WWW.")) || (mOp.Equal(m$.Fnc.$extract(m$.var("YINHALT").get(),1,7),"http://"))) {
        if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get(),"@"))) {
          if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get()," "))) {
            if (mOp.Greater(m$.Fnc.$length(m$.var("YINHALT").get(),"."),2)) {
              //<< . write YCR ;W "&nbsp;"
              m$.Cmd.Write(m$.var("YCR").get());
              //<< . write "<A HREF="""
              m$.Cmd.Write("<A HREF=\"");
              //<< . if $extract(YINHALT,1,7)'="http://" write "http://"
              if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YINHALT").get(),1,7),"http://")) {
                m$.Cmd.Write("http://");
              }
              //<< . write YINHALT
              m$.Cmd.Write(m$.var("YINHALT").get());
              //<< . write """ TARGET=WWWWW>"
              m$.Cmd.Write("\" TARGET=WWWWW>");
              //<< . write YCR,"<IMG SRC="""_YGIF_"www.gif"" ALIGN=ABSBOTTOM TITLE=""WWW"" border=0 id=""BUTTON_WWW"">"
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"www.gif\" ALIGN=ABSBOTTOM TITLE=\"WWW\" border=0 id=\"BUTTON_WWW\">"));
              return;
            }
          }
        }
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;ROUTENPLANER
    //<< ;---------------------------------------
    //<< new strName
    mVar strName = m$.var("strName");
    m$.newVar(strName);
    //<< 
    //<< if $length(YINHALT)=5 if +YINHALT'=0 set strName=$$$UPPER(YNAME) if $extract(strName,1,3)="PLZ"!($extract(strName,1,3)="ZIP") do  quit  ;PLZ ;ZIP
    if (mOp.Equal(m$.Fnc.$length(m$.var("YINHALT").get()),5)) {
      if (mOp.NotEqual(mOp.Positive(m$.var("YINHALT").get()),0)) {
        strName.set(include.COMSYSString.$$$UPPER(m$,m$.var("YNAME")));
        if (mOp.Or(mOp.Equal(m$.Fnc.$extract(strName.get(),1,3),"PLZ"),(mOp.Equal(m$.Fnc.$extract(strName.get(),1,3),"ZIP")))) {
          do {
            //<< . write YCR
            m$.Cmd.Write(m$.var("YCR").get());
            //<< . new URL
            mVar URL = m$.var("URL");
            m$.newVarBlock(1,URL);
            //<< . set URL = $$$WWW012URLForAutoRoute(objCompany)
            URL.set(include.WWWConst.$$$WWW012URLForAutoRoute(m$,objCompany));
            //<< . quit:URL=""  ;KEIN EINTRAG IN MAP UND GUIDE;TYBD;14,5,2004
            if (mOp.Equal(URL.get(),"")) {
              break;
            }
            //<< . //SET YBTR=$ORDER(^WWW0121(0,YM,""))
            //<< . //QUIT:YBTR=""
            //<< . //SET YBTR1=$GET(^WWW0121(0,YM,YBTR,1))
            //<< . ;WRITE "<A HREF=""http://"_$PIECE(objCompany,Y,96)_YINHALT      ;bec;03.06.04;25849;http abfangen
            //<< . write "<A HREF="""
            m$.Cmd.Write("<A HREF=\"");
            //<< . if $$$UPPER($extract(URL,0,7))'="HTTP://" write "http://"
            if (mOp.NotEqual(include.COMSYSString.$$$UPPER(m$,m$.Fnc.$extract(URL.get(),0,7)),"HTTP://")) {
              m$.Cmd.Write("http://");
            }
            //<< . write URL_YINHALT
            m$.Cmd.Write(mOp.Concat(URL.get(),m$.var("YINHALT").get()));
            //<< . ;WRITE "<A HREF=""http://map.ptv.de/emr/mapping.asp?ID=AV&LNG=D&UC=&CF=0&SC=D&RAD=400&SIZX=400&SIZY=400&RECT=1303039&BUTTON=CLICK&NX=1303439&NY=6479243&SX=1303039&SY=6479243&MAP=S&SP="_YINHALT_"&SO=&SS="_$GET(STRASSE)
            //<< . write """ TARGET=routenplaner>"
            m$.Cmd.Write("\" TARGET=routenplaner>");
            //<< . write YCR,"<IMG SRC="""_YGIF_"route.gif"" ALIGN=ABSBOTTOM TITLE=""Auto-Route"" border=0>"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"route.gif\" ALIGN=ABSBOTTOM TITLE=\"Auto-Route\" border=0>"));
            //<< . write "</A>"
            m$.Cmd.Write("</A>");
          } while (false);
          return;
        }
        m$.restoreVarBlock(1);
      }
    }
    //<< 
    //<< if (YTYP=1)||(YTYP=17) do  quit  ;KALENDER ALS MODAL WINDOW ANZEIGEN ;calendar when display
    if ((mOp.Equal(m$.var("YTYP").get(),1)) || (mOp.Equal(m$.var("YTYP").get(),17))) {
      //<< . if (YHID'=2)||('$$$WWW122HideButton(YSATZ)) do  ;SR18187
      if ((mOp.NotEqual(m$.var("YHID").get(),2)) || (mOp.Not(include.WWWConst.$$$WWW122HideButton(m$,m$.var("YSATZ"))))) {
        //<< . . do CreateDateButton() // SRBR014409
        m$.Cmd.Do("CreateDateButton");
      }
      return;
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;FREMDWÄHRUNG         ;FIS;25933;21.06.2004
    //<< ;---------------------------------------
    //<< ; SR:12256
    //<< if YTYP=8 if $find($piece(YFELD,Y,YLFN),"@") if ($get(^CacheTemp(YUSER,YFORM,"Toggles","Currency"))'="Base")&&('$data(^CacheTemp(YUSER,YFORM,"Disable Coins"))) do  quit ; SR11349
    if (mOp.Equal(m$.var("YTYP").get(),8)) {
      if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),"@"))) {
        if ((mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Toggles","Currency")),"Base")) && (mOp.Not(m$.Fnc.$data(m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Disable Coins"))))) {
          do {
            //<< . ;IF YTYP=8 IF $FIND($PIECE(YFELD,Y,YLFN),"@") if '$data(^CacheTemp(YUSER,YFORM,"Toggles","Currency")) DO  QUIT ; SR11349
            //<< . ;
            //<< . quit:YHID=2
            if (mOp.Equal(m$.var("YHID").get(),2)) {
              break;
            }
            //<< . quit:YHID=1  ;NICHT WENN NUR HIDDEN ;Not when only
            if (mOp.Equal(m$.var("YHID").get(),1)) {
              break;
            }
            //<< . ;W "&nbsp;"
            //<< . write YCR
            m$.Cmd.Write(m$.var("YCR").get());
            //<< . write YCR,"<A class=link"         //SR13195
            m$.Cmd.Write(m$.var("YCR").get(),"<A class=link");
            //<< . set URL=YAKTION_"EP=WWWFORM&amp;YFORM=WWWWHRX&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"&amp;YTRAKT="_YTRAKT_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM_"&amp;YLFDAT=Y"_YFORM_YART_YLFN_"&amp;YLFFORM="_YFORM_"&amp;YHTMFORM1="_YHTMFORM_"&amp;YKEY="_YKEY
            mVar URL = m$.var("URL");
            URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM=WWWWHRX&amp;YUSER="),m$.var("YUSER").get()),"&amp;YBED="),m$.var("YBED").get()),"&amp;YTRAKT="),m$.var("YTRAKT").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()),"&amp;YLFDAT=Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"&amp;YLFFORM="),m$.var("YFORM").get()),"&amp;YHTMFORM1="),m$.var("YHTMFORM").get()),"&amp;YKEY="),m$.var("YKEY").get()));
            //<< . write YCR," onclick=""var result = window.showModalDialog('"_URL_"&YSEC='+ new Date().getSeconds(),'Calendar','DialogWidth: 600px; DialogHeight: 180px; resizable: no; status: no');"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" onclick=\"var result = window.showModalDialog('",URL.get()),"&YSEC='+ new Date().getSeconds(),'Calendar','DialogWidth: 600px; DialogHeight: 180px; resizable: no; status: no');"));
            //<< . write YCR,"if (result != null) {"
            m$.Cmd.Write(m$.var("YCR").get(),"if (result != null) {");
            //<< . write YCR," retval = EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_YART_YLFN_"',result,'2','NOVALUE');"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" retval = EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"',result,'2','NOVALUE');"));
            //<< . ;
            //<< . // SR15384 - No longer necessary with new WWWEVENT
            //<< . //write YCR," if (retval!='') {"
            //<< . //write YCR,"  document."_YHTMFORM_".Y"_YFORM_YART_YLFN_".value=retval;" ;used to be value
            //<< . //write YCR," }"
            //<< . ;
            //<< . write YCR," window.setTimeout('document."_YHTMFORM_".Y"_YFORM_YART_YLFN_".focus()',10);"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" window.setTimeout('document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),".focus()',10);"));
            //<< . write YCR," }"
            m$.Cmd.Write(m$.var("YCR").get()," }");
            //<< . write YCR,""">"
            m$.Cmd.Write(m$.var("YCR").get(),"\">");
            //<< . write YCR,"<IMG SRC="""_YGIF_"konditionen.gif"" ALIGN=ABSBOTTOM TITLE="""_$$^WWWTEXT(33910)_""" border=0 id=""BUTTON_CURR"">"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"konditionen.gif\" ALIGN=ABSBOTTOM TITLE=\""),m$.fnc$("WWWTEXT.main",33910)),"\" border=0 id=\"BUTTON_CURR\">"));
            //<< . write "</A>"
            m$.Cmd.Write("</A>");
          } while (false);
          return;
        }
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;TEXT       //SR13195 - rewrote
    //<< ;---------------------------------------
    //<< if YTYP=3 {
    if (mOp.Equal(m$.var("YTYP").get(),3)) {
      //<< write $$MemoLink(YDATEI,YSATZ,YART,YKEY)
      m$.Cmd.Write(m$.fnc$("MemoLink",m$.var("YDATEI").get(),m$.var("YSATZ").get(),m$.var("YART").get(),m$.var("YKEY").get()));
    }
    //<< 
    //<< } elseif (strExtension'="") && (strExtension'=+strExtension) && ##class(%File).Exists($$$WWW012PhysicalWWWDirectory(objCompany)_YINHALT) {          //SR12918
    else if ((mOp.NotEqual(strExtension.get(),"")) && (mOp.NotEqual(strExtension.get(),mOp.Positive(strExtension.get()))) && mOp.Logical(m$.fnc$("$File.Exists",mOp.Concat(include.WWWConst.$$$WWW012PhysicalWWWDirectory(m$,objCompany),m$.var("YINHALT").get())))) {
      //<< write "&nbsp;"
      m$.Cmd.Write("&nbsp;");
      //<< write "<EMBED SRC="""_YGIF_YINHALT_""" BORDER="_YBORDER_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<EMBED SRC=\"",m$.var("YGIF").get()),m$.var("YINHALT").get()),"\" BORDER="),YBORDER.get()),">"));
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< IsImageType(pstrExtension)
  public Object IsImageType(Object ... _p) {
    mVar pstrExtension = m$.newVarRef("pstrExtension",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ; 01-Aug-2012   shobby  SR18076: Include various additional types of image extensions.
    //<< set pstrExtension=$$$LOWER(pstrExtension)
    pstrExtension.set(include.COMSYSString.$$$LOWER(m$,pstrExtension));
    //<< quit $listfind($listbuild("gif","jpg","png","bmp","dib","jpeg","jfif","tif","tiff"),pstrExtension)
    return m$.Fnc.$listfind(m$.Fnc.$listbuild("gif","jpg","png","bmp","dib","jpeg","jfif","tif","tiff"),pstrExtension.get());
  }

  //<< 
  //<< CreateDateButtonNew()
  public Object CreateDateButtonNew(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create the button that pops up the date window.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: strLink
    //<< ;
    //<< ; History:
    //<< ; 05-Jul-2007   RPW     SRBR014409: Change str to lst for %List types
    //<< ; 25-Jun-2007   shobby  SRBR014409: Adjusted the image id
    //<< ; 11-Jun-2007   shobby  SRBR014409: Streamlined.  Put some common code in to
    //<< ;                       CreateOnClick to be shared with other types of buttons
    //<< ;                       when they are created.
    //<< ; 06-Jun-2007   shobby  SRBR014409: Created.  Subroutined out of THUMP.  Change
    //<< ;                       in functionality.  The button is now drawn as disabled
    //<< ;                       when related field is readonly rather than not being
    //<< ;                       drawn.  Made non-IE browser call conditional on related
    //<< ;                       field being not readOnly.
    //<< ;-------------------------------------------------------------------------------
    //<< new lstJS1,lstJS2
    mVar lstJS1 = m$.var("lstJS1");
    mVar lstJS2 = m$.var("lstJS2");
    m$.newVar(lstJS1,lstJS2);
    //<< 
    //<< if (YHID'=1) {
    if ((mOp.NotEqual(m$.var("YHID").get(),1))) {
      //<< set URL=YAKTION_"EP=WWWFORM&amp;YFORM=WWWCAL2&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM_"&amp;YLFDAT=Y"_YFORM_YART_YLFN
      mVar URL = m$.var("URL");
      URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM=WWWCAL2&amp;YUSER="),m$.var("YUSER").get()),"&amp;YBED="),m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()),"&amp;YLFDAT=Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()));
      //<< if (($get(YUSERAGENT)="MSIE")||($get(YUSERAGENT)="")) {  ;FIS:31.12.04;26951;MOZILLA OHNE MODAL-WINDOW
      if (mOp.Logical(((mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) || (mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),""))))) {
        //<< set lstJS1=$listbuild("var result = window.showModalDialog('"_URL_"','Calendar','DialogWidth: 320px; DialogHeight: 330px; resizable: no; status: no; scrollbar: no;');")
        lstJS1.set(m$.Fnc.$listbuild(mOp.Concat(mOp.Concat("var result = window.showModalDialog('",URL.get()),"','Calendar','DialogWidth: 320px; DialogHeight: 330px; resizable: no; status: no; scrollbar: no;');")));
      }
      //<< } elseif ($get(YUSERAGENT)'="MSIE")&&($get(YUSERAGENT)'="") {
      else if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSERAGENT")),""))) {
        //<< set lstJS1=$listbuild("var result = newModalDialog('"_URL_"','',330,290,0);")
        lstJS1.set(m$.Fnc.$listbuild(mOp.Concat(mOp.Concat("var result = newModalDialog('",URL.get()),"','',330,290,0);")));
      }
      //<< }
      //<< set lstJS2=$listbuild("document."_YHTMFORM_".Y"_YFORM_YART_YLFN_".focus();")
      lstJS2.set(m$.Fnc.$listbuild(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),".focus();")));
      //<< if YART="D" if $piece(YSATZ,Y,66)=1 set lstJS2=lstJS2_$listbuild("SAVENOW();")  ;FIS;02.08.04;26195;SPEICHERN BEI DATUMAUSWAHL
      if (mOp.Equal(m$.var("YART").get(),"D")) {
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),66),1)) {
          lstJS2.set(mOp.Concat(lstJS2.get(),m$.Fnc.$listbuild("SAVENOW();")));
        }
      }
      //<< write $$CreateOnClick^WWWBUTTON("Y"_YFORM_YART_YLFN,"date.gif",$$^WWWTEXT(124),"CalendarButton"_YART_YLFN,lstJS1,lstJS2,"class")  ;BR014409
      m$.Cmd.Write(m$.fnc$("WWWBUTTON.CreateOnClick",mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"date.gif",m$.fnc$("WWWTEXT.main",124),mOp.Concat(mOp.Concat("CalendarButton",m$.var("YART").get()),m$.var("YLFN").get()),lstJS1.get(),lstJS2.get(),"class"));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateDateButton()
  public Object CreateDateButton(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create the button that pops up the date window.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: strLink
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   shobby  SRBR014409: Call out to a simplified version
    //<< ; 06-Jun-2007   shobby  SRBR014409: Created.  Subroutined out of THUMP.  Change
    //<< ;                       in functionality.  The button is now drawn as disabled
    //<< ;                       when related field is readonly rather than not being
    //<< ;                       drawn.  Made non-IE browser call conditional on related
    //<< ;                       field being not readOnly.
    //<< ;-------------------------------------------------------------------------------
    //<< do CreateDateButtonNew()
    m$.Cmd.Do("CreateDateButtonNew");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< MemoLink(pidClass,pobjWWW122,pYART="D",YKEY,pblnGrid=$$$NO)
  public Object MemoLink(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjWWW122 = m$.newVarRef("pobjWWW122",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYART = m$.newVarRef("pYART",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"D");
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnGrid = m$.newVarRef("pblnGrid",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the memo field HTML link stuff
    //<< ;
    //<< ; Called By : INPUT^COMGridEdit31F, THUMP^WWWFORM9
    //<< ;
    //<< ; Params: pidClass      : Class to save to
    //<< ;         pobjWWW122    : Current field form record
    //<< ;         pYART         : Field type (YART)
    //<< ;         pstrKey       : Current record key
    //<< ;         pblnGrid      : Whether we are in a grid form
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: strLink
    //<< ;
    //<< ; History:
    //<< ; 13-Mar-2008   shobby  SRBR014911: Allowing saving and loading of the popup screen dimensions
    //<< ; 06-Sep-2007   shobby  SRBR014712: Corrected an issue where the FCK editor
    //<< ;                       wouldn't show when being called from an edit grid.
    //<< ; 16-Aug-2007   shobby  SRBR014637: Don't show FCK editor if field is readonly.
    //<< ; 06-Jun-2007   shobby  SRBR014409: If the field is readonly display the view
    //<< ;                       window instead of the edit window
    //<< ; 05-Jun-2007   shobby  SRBR014409: Include an id for the memolink button.
    //<< ; 04-Jun-2007   RPW     SR15369: Do not find the object twice.
    //<< ; 26-Feb-2007   PO      SR15448: No longer using YAKTION to locate COM.Editor.cls
    //<< ; 11-Jan-2007   JW/RW/SH SR15369: Memo is type 3 not type 6.
    //<< ; 21-Dec-2006   JW      SR14235: Added reference to child window
    //<< ; 01-Nov-2006   JW      SR14914: Added pstrKey,pblnGrid. Don't get editor here.
    //<< ; 24-Oct-2006   Steve S SR14915: Encapsulated from THUMP
    //<< ;-------------------------------------------------------------------------------
    //<< new objCompany,idChild,strDimensions,strLink
    mVar objCompany = m$.var("objCompany");
    mVar idChild = m$.var("idChild");
    mVar strDimensions = m$.var("strDimensions");
    mVar strLink = m$.var("strLink");
    m$.newVar(objCompany,idChild,strDimensions,strLink);
    //<< new idEditor,objEditor,idSkin,idToolbar,intMaxChar,blnUseStandard
    mVar idEditor = m$.var("idEditor");
    mVar objEditor = m$.var("objEditor");
    mVar idSkin = m$.var("idSkin");
    mVar idToolbar = m$.var("idToolbar");
    mVar intMaxChar = m$.var("intMaxChar");
    mVar blnUseStandard = m$.var("blnUseStandard");
    m$.newVar(idEditor,objEditor,idSkin,idToolbar,intMaxChar,blnUseStandard);
    //<< new strAction,objData,strURL,blnEditor,blnReadOnly
    mVar strAction = m$.var("strAction");
    mVar objData = m$.var("objData");
    mVar strURL = m$.var("strURL");
    mVar blnEditor = m$.var("blnEditor");
    mVar blnReadOnly = m$.var("blnReadOnly");
    m$.newVar(strAction,objData,strURL,blnEditor,blnReadOnly);
    //<< 
    //<< quit:(YHID=1) ""
    if ((mOp.Equal(m$.var("YHID").get(),1))) {
      return "";
    }
    //<< 
    //<< set blnReadOnly = (YHID=2)
    blnReadOnly.set((mOp.Equal(m$.var("YHID").get(),2)));
    //<< set objCompany  = $get(^WWW012(0,YM,1))
    objCompany.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< set blnEditor   = ($$$WWW012HTMLEditor(objCompany)'="")
    blnEditor.set((mOp.NotEqual(include.WWWConst.$$$WWW012HTMLEditor(m$,objCompany),"")));
    //<< set strLink     = ""
    strLink.set("");
    //<< 
    //<< if blnEditor || (pidClass'="") {
    if (mOp.Logical(blnEditor.get()) || (mOp.NotEqual(pidClass.get(),""))) {
      //<< set strLink = "<IMG SRC="""_YGIF_"text.gif"" TITLE=""Text"" border=0 "
      strLink.set(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"text.gif\" TITLE=\"Text\" border=0 "));
      //<< set strLink = strLink_"id=""Y"_YFORM_pYART_YLFN_"MEMOLINK"" "
      strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strLink.get(),"id=\"Y"),m$.var("YFORM").get()),pYART.get()),m$.var("YLFN").get()),"MEMOLINK\" "));
      //<< set strLink = strLink_$select(pblnGrid:" class=IMGcell ", 1:" class=link ALIGN=ABSBOTTOM ")
      strLink.set(mOp.Concat(strLink.get(),m$.Fnc.$select(pblnGrid.get()," class=IMGcell ",1," class=link ALIGN=ABSBOTTOM ")));
      //<< 
      //<< // Standard @Net memo
      //<< if '$$$WWW122MemoFieldWithFormatButton(pobjWWW122)||'blnEditor||blnReadOnly {
      if (mOp.Not(include.WWWConst.$$$WWW122MemoFieldWithFormatButton(m$,pobjWWW122)) || mOp.Not(blnEditor.get()) || mOp.Logical(blnReadOnly.get())) {
        //<< set strLink=strLink_" onClick="""
        strLink.set(mOp.Concat(strLink.get()," onClick=\""));
        //<< set strLink=strLink_$$ShowPopup()
        strLink.set(mOp.Concat(strLink.get(),m$.fnc$("ShowPopup")));
        //<< set strLink=strLink_""""
        strLink.set(mOp.Concat(strLink.get(),"\""));
      }
      //<< 
      //<< // HTML editor
      //<< } else {
      else {
        //<< // Rewrote this entire section to cleanly handle the new editor.
        //<< set strLink = strLink_" onclick="""
        strLink.set(mOp.Concat(strLink.get()," onclick=\""));
        //<< 
        //<< ; For some reason the related cell in the fields tab of COMhelp doesn't have an ID.
        //<< ;   If we are in an edit grid the id is not valid.  This doesn't matter
        //<< ;   too much because if the cell is disabled we won't see the button anyway.
        //<< set strLink   = strLink_"if((document.getElementById('Y"_YFORM_pYART_YLFN_"')!=null)&&(document.getElementById('Y"_YFORM_pYART_YLFN_"').readOnly)) {"
        strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strLink.get(),"if((document.getElementById('Y"),m$.var("YFORM").get()),pYART.get()),m$.var("YLFN").get()),"')!=null)&&(document.getElementById('Y"),m$.var("YFORM").get()),pYART.get()),m$.var("YLFN").get()),"').readOnly)) {"));
        //<< set strLink   = strLink_$$ShowPopup()
        strLink.set(mOp.Concat(strLink.get(),m$.fnc$("ShowPopup")));
        //<< set strLink   = strLink_"} else {"
        strLink.set(mOp.Concat(strLink.get(),"} else {"));
        //<< set strAction = "COM.Editor.cls?"     // Construct the new URI.
        strAction.set("COM.Editor.cls?");
        //<< set strURL    = strAction_"&YM="_YM_"&YUSER="_YUSER_"&YFORM="_YFORM_"&YART="_pYART_"&YLFN="_YLFN_"&GRID="_pblnGrid_"&GRIDFIELD="_$get(YFIELDNAME)_"&Y="_Y_"&SPRACHE="_SPRACHE
        strURL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strAction.get(),"&YM="),m$.var("YM").get()),"&YUSER="),m$.var("YUSER").get()),"&YFORM="),m$.var("YFORM").get()),"&YART="),pYART.get()),"&YLFN="),m$.var("YLFN").get()),"&GRID="),pblnGrid.get()),"&GRIDFIELD="),m$.Fnc.$get(m$.var("YFIELDNAME"))),"&Y="),m$.var("Y").get()),"&SPRACHE="),m$.var("SPRACHE").get()));
        //<< 
        //<< set strLink = strLink_"var arrDimensions = EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','GetWindowSize^COMFCKeditor','"_YBED_"','6',''); "
        strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strLink.get(),"var arrDimensions = EventValue('"),m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','GetWindowSize^COMFCKeditor','"),m$.var("YBED").get()),"','6',''); "));
        //<< set strLink = strLink_"var strDialogHeight=arrDimensions.split('~')[0];"
        strLink.set(mOp.Concat(strLink.get(),"var strDialogHeight=arrDimensions.split('~')[0];"));
        //<< set strLink = strLink_"var strDialogWidth=arrDimensions.split('~')[1];"
        strLink.set(mOp.Concat(strLink.get(),"var strDialogWidth=arrDimensions.split('~')[1];"));
        //<< set strLink = strLink_"var arrResult=window.showModalDialog('"_strURL_"','editor','DialogWidth: '+strDialogWidth+'; DialogHeight: '+strDialogHeight+'; resizable: yes; status: no');" // SR14914
        strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(strLink.get(),"var arrResult=window.showModalDialog('"),strURL.get()),"','editor','DialogWidth: '+strDialogWidth+'; DialogHeight: '+strDialogHeight+'; resizable: yes; status: no');"));
        //<< set strLink = strLink_"if (arrResult != undefined) {"
        strLink.set(mOp.Concat(strLink.get(),"if (arrResult != undefined) {"));
        //<< set strLink = strLink_"  var strDialogHeight=arrResult.split('~')[0];"
        strLink.set(mOp.Concat(strLink.get(),"  var strDialogHeight=arrResult.split('~')[0];"));
        //<< set strLink = strLink_"  var strDialogWidth=arrResult.split('~')[1];"
        strLink.set(mOp.Concat(strLink.get(),"  var strDialogWidth=arrResult.split('~')[1];"));
        //<< set strLink = strLink_"  var result=arrResult.split('~')[2];"
        strLink.set(mOp.Concat(strLink.get(),"  var result=arrResult.split('~')[2];"));
        //<< set strLink = strLink_"  if (strDialogHeight != '' ) { "
        strLink.set(mOp.Concat(strLink.get(),"  if (strDialogHeight != '' ) { "));
        //<< set strLink = strLink_"   var update = EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','SetWindowSize^COMFCKeditor',strDialogHeight,'6',strDialogWidth); "
        strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strLink.get(),"   var update = EventValue('"),m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','SetWindowSize^COMFCKeditor',strDialogHeight,'6',strDialogWidth); "));
        //<< set strLink = strLink_"  }"
        strLink.set(mOp.Concat(strLink.get(),"  }"));
        //<< set strLink = strLink_"}"
        strLink.set(mOp.Concat(strLink.get(),"}"));
        //<< 
        //<< // If in dev - translate the picture directory to YGIF
        //<< if $$$DEVMODE {
        if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
          //<< set strLink = strLink_" if (result != null ) { "
          strLink.set(mOp.Concat(strLink.get()," if (result != null ) { "));
          //<< set strLink = strLink_"     var convertDir = EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','ConvertDir^COMEditor',result,'6'); "
          strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strLink.get(),"     var convertDir = EventValue('"),m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','ConvertDir^COMEditor',result,'6'); "));
          //<< set strLink = strLink_"     if (convertDir!='') result = convertDir; "
          strLink.set(mOp.Concat(strLink.get(),"     if (convertDir!='') result = convertDir; "));
          //<< set strLink = strLink_" } "
          strLink.set(mOp.Concat(strLink.get()," } "));
        }
        //<< }
        //<< if pblnGrid {
        if (mOp.Logical(pblnGrid.get())) {
          //<< set strLink = strLink_" modalReturn('"_YFIELDNAME_"',result,3,'');"
          strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(strLink.get()," modalReturn('"),m$.var("YFIELDNAME").get()),"',result,3,'');"));
        }
        //<< 
        //<< } else {
        else {
          //<< set strLink = strLink_"if (result != null ) { "
          strLink.set(mOp.Concat(strLink.get(),"if (result != null ) { "));
          //<< set strLink = strLink_" with (document.getElementById('Y"_YFORM_pYART_YLFN_"')) {"
          strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strLink.get()," with (document.getElementById('Y"),m$.var("YFORM").get()),pYART.get()),m$.var("YLFN").get()),"')) {"));
          //<< set strLink = strLink_"  value=result; "
          strLink.set(mOp.Concat(strLink.get(),"  value=result; "));
          //<< set strLink = strLink_"  focus(); "
          strLink.set(mOp.Concat(strLink.get(),"  focus(); "));
          //<< set strLink = strLink_" }"
          strLink.set(mOp.Concat(strLink.get()," }"));
          //<< set strLink = strLink_"}"
          strLink.set(mOp.Concat(strLink.get(),"}"));
        }
        //<< }
        //<< set strLink = strLink_"}"
        strLink.set(mOp.Concat(strLink.get(),"}"));
        //<< set strLink = strLink_""""
        strLink.set(mOp.Concat(strLink.get(),"\""));
      }
      //<< }
      //<< set strLink = strLink_">"
      strLink.set(mOp.Concat(strLink.get(),">"));
    }
    //<< }
    //<< quit strLink
    return strLink.get();
  }

  //<< 
  //<< 
  //<< ShowPopup()
  public Object ShowPopup(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create the link to show the popup from a text box.
    //<< ;
    //<< ; Params: pidClass      : Class the field is contained in.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: strLink
    //<< ;
    //<< ; History:
    //<< ; 16-Aug-2007   shobby  SRBR014637: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idChild,strLink,strDimensions,URL
    mVar idChild = m$.var("idChild");
    mVar strLink = m$.var("strLink");
    mVar strDimensions = m$.var("strDimensions");
    mVar URL = m$.var("URL");
    m$.newVar(idChild,strLink,strDimensions,URL);
    //<< 
    //<< set strLink = ""
    strLink.set("");
    //<< set idChild = $$GetChildUser^WWWUSER(YUSER)
    idChild.set(m$.fnc$("WWWUSER.GetChildUser",m$.var("YUSER").get()));
    //<< set URL = YAKTION_"EP=WWWFORM&amp;YFORM=WWWDOCUMENT&amp;YUSER="_idChild_"&amp;YBED="_YBED
    URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM=WWWDOCUMENT&amp;YUSER="),idChild.get()),"&amp;YBED="),m$.var("YBED").get()));
    //<< set URL = URL_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM_"&amp;YDATA="_pidClass_"|"_YKEY_"|"_YLFN_"&amp;YHTMFORM1="_YHTMFORM
    URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(URL.get(),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()),"&amp;YDATA="),m$.var("pidClass").get()),"|"),m$.var("YKEY").get()),"|"),m$.var("YLFN").get()),"&amp;YHTMFORM1="),m$.var("YHTMFORM").get()));
    //<< set strDimensions = "HEIGHT=520,WIDTH=470,SCROLLBARS=YES,TOOLBAR=NO,RESIZABLE=YES"
    strDimensions.set("HEIGHT=520,WIDTH=470,SCROLLBARS=YES,TOOLBAR=NO,RESIZABLE=YES");
    //<< set strLink       = strLink_"subWindow('"_URL_"','text','"_strDimensions_"');"
    strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strLink.get(),"subWindow('"),URL.get()),"','text','"),strDimensions.get()),"');"));
    //<< quit strLink
    return strLink.get();
  }

  //<< 
  //<< 
  //<< BUTTON
  public void BUTTON() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; BUTTON HINTER FELD ;posterior field
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   shobby  SRBR014409: Removed previous change.
    //<< ; 12-Jun-2007   shobby  SRBR014409: Still display buttons for readonly fields.
    //<< ;                       They will be displayed as disabled.
    //<< ;-------------------------------------------------------------------------------
    //<< new YA,YBUTT,YI,YPARA,YTARGET
    mVar YA = m$.var("YA");
    mVar YBUTT = m$.var("YBUTT");
    mVar YI = m$.var("YI");
    mVar YPARA = m$.var("YPARA");
    mVar YTARGET = m$.var("YTARGET");
    m$.newVar(YA,YBUTT,YI,YPARA,YTARGET);
    //<< 
    //<< quit:$get(YHID)=2  ;HIDDEN READ ONLY
    if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
      return;
    }
    //<< if YART'="P" if YART'="M" if YART'="D" quit
    if (mOp.NotEqual(m$.var("YART").get(),"P")) {
      if (mOp.NotEqual(m$.var("YART").get(),"M")) {
        if (mOp.NotEqual(m$.var("YART").get(),"D")) {
          return;
        }
      }
    }
    //<< 
    //<< set YPARA = YPARA1
    YPARA.set(m$.var("YPARA1").get());
    //<< set YBUTT = $$$WWW122ButtonBehindInputField(YSATZ)
    YBUTT.set(include.WWWConst.$$$WWW122ButtonBehindInputField(m$,m$.var("YSATZ")));
    //<< if YBUTT'="" {
    if (mOp.NotEqual(YBUTT.get(),"")) {
      //<< do ^WWWFORMB
      m$.Cmd.Do("WWWFORMB.main");
      //<< write YCR
      m$.Cmd.Write(m$.var("YCR").get());
    }
    //<< }
    //<< quit
    return;
  }

//<< 
//<< 
}
