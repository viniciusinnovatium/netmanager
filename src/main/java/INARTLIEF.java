//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTLIEF
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 20:36:22
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
//<< #include INConst
import include.INConst;

//<< INARTLIEF(ART,ANZAHL) ;INARTLIEF;DT;SUCHEN LETZTEN LIEFERANT EINES ARTIKELS;15.06.2000
public class INARTLIEF extends mClass {

  public Object main(Object ... _p) {
    mVar ART = m$.newVarRef("ART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar ANZAHL = m$.newVarRef("ANZAHL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _INARTLIEF(ART,ANZAHL);
  }

  public Object _INARTLIEF(Object ... _p) {
    mVar ART = m$.newVarRef("ART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar ANZAHL = m$.newVarRef("ANZAHL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SUCHEN LETZTEN LIEFERANT EINES ARTIKELS
    //<< ;
    //<< ; Inputs :
    //<< ;   ART     : Item No
    //<< ;   ANZAHL  : Number?
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 12-Jul-2005   GRF     SR12027 : Macro Conversion; unnecessary $get for ART/LEIF
    //<< ; DT    15.06.2000
    //<< ;-------------------------------------------------------------------------------
    //<< NEW BET,LAP,WED
    mVar BET = m$.var("BET");
    mVar LAP = m$.var("LAP");
    mVar WED = m$.var("WED");
    m$.newVar(BET,LAP,WED);
    //<< 
    //<< SET LIEFERANTEN=""
    mVar LIEFERANTEN = m$.var("LIEFERANTEN");
    LIEFERANTEN.set("");
    //<< IF $GET(ART)="" QUIT ""   ;TYBD;6.2.2003
    if (mOp.Equal(m$.Fnc.$get(ART),"")) {
      return "";
    }
    //<< 
    //<< SET ANZAHL=+$GET(ANZAHL)  ;ANZAHL DER LIEFERANTEN ;Number the
    ANZAHL.set(mOp.Positive(m$.Fnc.$get(ANZAHL)));
    //<< IF ANZAHL=0 SET ANZAHL=1
    if (mOp.Equal(ANZAHL.get(),0)) {
      ANZAHL.set(1);
    }
    //<< 
    //<< SET LIEF=""
    mVar LIEF = m$.var("LIEF");
    LIEF.set("");
    //<< if ART'="" quit:$ORDER(^INARTK(YM,ART,""))="" ""  ;KEIN ARTIKEL MIT LIEFERANTEN ;no item by means of
    if (mOp.NotEqual(ART.get(),"")) {
      if (mOp.Equal(m$.Fnc.$order(m$.var("^INARTK",m$.var("YM").get(),ART.get(),"")),"")) {
        return "";
      }
    }
    //<< IF ART'="" DO
    if (mOp.NotEqual(ART.get(),"")) {
      do {
        //<< . SET BET=""
        BET.set("");
        //<< . FOR  SET BET=$ORDER(^INWE(YM,ART,BET)) QUIT:BET=""  DO  QUIT:LIEF'=""   ;BETRIEB
        for (;true;) {
          BET.set(m$.Fnc.$order(m$.var("^INWE",m$.var("YM").get(),ART.get(),BET.get())));
          if (mOp.Equal(BET.get(),"")) {
            break;
          }
          do {
            //<< . . SET LAP=""
            LAP.set("");
            //<< . . FOR  SET LAP=$ORDER(^INWE(YM,ART,BET,LAP)) QUIT:LAP=""  DO  QUIT:LIEF'=""  ;LAGERPLATZ   ;WEM;25418;01.04.2004;SORT -1 ENTFERNT, DA SONST NICHT LETZTER LIEF GEFUNDEN WURDE.
            for (;true;) {
              LAP.set(m$.Fnc.$order(m$.var("^INWE",m$.var("YM").get(),ART.get(),BET.get(),LAP.get())));
              if (mOp.Equal(LAP.get(),"")) {
                break;
              }
              do {
                //<< . . . SET WED=""
                WED.set("");
                //<< . . . FOR  SET WED=$ORDER(^INWE(YM,ART,BET,LAP,WED),-1) QUIT:WED=""  DO  QUIT:LIEF'=""  ;WEDATUM
                for (;true;) {
                  WED.set(m$.Fnc.$order(m$.var("^INWE",m$.var("YM").get(),ART.get(),BET.get(),LAP.get(),WED.get()),mOp.Negative(1)));
                  if (mOp.Equal(WED.get(),"")) {
                    break;
                  }
                  do {
                    //<< . . . . SET LIEF=$PIECE($GET(^INWE(YM,ART,BET,LAP,WED,1)),Y,7)   ;LETZTER LIEFERANT ;last supplier
                    LIEF.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INWE",m$.var("YM").get(),ART.get(),BET.get(),LAP.get(),WED.get(),1)),m$.var("Y").get(),7));
                    //<< . . . . QUIT:LIEF=""
                    if (mOp.Equal(LIEF.get(),"")) {
                      break;
                    }
                    //<< . . . . IF '$DATA(^INLIEF(YM,LIEF)) SET LIEF="" QUIT  ;FIS 02.10.01
                    if (mOp.Not(m$.Fnc.$data(m$.var("^INLIEF",m$.var("YM").get(),LIEF.get())))) {
                      LIEF.set("");
                      break;
                    }
                    //<< . . . . IF ANZAHL'=1 IF '$FIND(LIEFERANTEN,LIEF) SET LIEFERANTEN=LIEFERANTEN_LIEF_Y SET LIEF=""
                    if (mOp.NotEqual(ANZAHL.get(),1)) {
                      if (mOp.Not(m$.Fnc.$find(LIEFERANTEN.get(),LIEF.get()))) {
                        LIEFERANTEN.set(mOp.Concat(mOp.Concat(LIEFERANTEN.get(),LIEF.get()),m$.var("Y").get()));
                        LIEF.set("");
                      }
                    }
                    //<< . . . . QUIT
                    break;
                  } while (false);
                  if (mOp.NotEqual(LIEF.get(),"")) {
                    break;
                  }
                }
                //<< . . . QUIT
                break;
              } while (false);
              if (mOp.NotEqual(LIEF.get(),"")) {
                break;
              }
            }
            //<< . . QUIT
            break;
          } while (false);
          if (mOp.NotEqual(LIEF.get(),"")) {
            break;
          }
        }
        //<< . QUIT
        break;
      } while (false);
    }
    //<< 
    //<< IF LIEF="" IF ART'="" SET LIEF=$ORDER(^INARTK(YM,ART,""))  ;LIEFERANT IN ARTIKELKONDITION ;purveyor within
    if (mOp.Equal(LIEF.get(),"")) {
      if (mOp.NotEqual(ART.get(),"")) {
        LIEF.set(m$.Fnc.$order(m$.var("^INARTK",m$.var("YM").get(),ART.get(),"")));
      }
    }
    //<< IF ANZAHL'=1 DO  ;WENN MEHRERE ANGEZEIGT WERDEN SOLLEN ;when divers will should
    if (mOp.NotEqual(ANZAHL.get(),1)) {
      do {
        //<< . SET LIEF="" IF ART'="" FOR  SET LIEF=$ORDER(^INARTK(YM,ART,LIEF)) QUIT:LIEF=""  DO
        LIEF.set("");
        if (mOp.NotEqual(ART.get(),"")) {
          for (;true;) {
            LIEF.set(m$.Fnc.$order(m$.var("^INARTK",m$.var("YM").get(),ART.get(),LIEF.get())));
            if (mOp.Equal(LIEF.get(),"")) {
              break;
            }
            do {
              //<< . . IF '$FIND(LIEFERANTEN,LIEF) SET LIEFERANTEN=LIEFERANTEN_LIEF_Y
              if (mOp.Not(m$.Fnc.$find(LIEFERANTEN.get(),LIEF.get()))) {
                LIEFERANTEN.set(mOp.Concat(mOp.Concat(LIEFERANTEN.get(),LIEF.get()),m$.var("Y").get()));
              }
              //<< . . QUIT
              break;
            } while (false);
          }
        }
        //<< . QUIT
        break;
      } while (false);
    }
    //<< IF ANZAHL'=1 SET LIEF=$PIECE(LIEFERANTEN,Y,1,ANZAHL)  ;ANZAHL ANZEIGEN ;Number display
    if (mOp.NotEqual(ANZAHL.get(),1)) {
      LIEF.set(m$.Fnc.$piece(LIEFERANTEN.get(),m$.var("Y").get(),1,ANZAHL.get()));
    }
    //<< QUIT LIEF
    return LIEF.get();
  }

  //<< 
  //<< LEADTIME(ART="",LIEF="")    ;SUPPLIER LEAD TIME
  public Object LEADTIME(Object ... _p) {
    mVar ART = m$.newVarRef("ART",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar LIEF = m$.newVarRef("LIEF",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< NEW DAYS
    mVar DAYS = m$.var("DAYS");
    m$.newVar(DAYS);
    //<< 
    //<< SET DAYS=0
    DAYS.set(0);
    //<< IF (ART'="") && (LIEF'="") {
    if ((mOp.NotEqual(ART.get(),"")) && (mOp.NotEqual(LIEF.get(),""))) {
      //<< SET DAYS=+$$$INARTKDeliveryPeriodInDays($get(^INARTK(YM,ART,LIEF,1)))  ;DELIVERY DAYS
      DAYS.set(mOp.Positive(include.INConst.$$$INARTKDeliveryPeriodInDays(m$,m$.Fnc.$get(m$.var("^INARTK",m$.var("YM").get(),ART.get(),LIEF.get(),1)))));
    }
    //<< }
    //<< 
    //<< IF +DAYS=0 IF LIEF'="" SET DAYS=$PIECE($GET(^INLIEF(YM,LIEF,1)),Y,46)  ;GENERAL
    if (mOp.Equal(mOp.Positive(DAYS.get()),0)) {
      if (mOp.NotEqual(LIEF.get(),"")) {
        DAYS.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INLIEF",m$.var("YM").get(),LIEF.get(),1)),m$.var("Y").get(),46));
      }
    }
    //<< QUIT +DAYS
    return mOp.Positive(DAYS.get());
  }

//<< 
}
