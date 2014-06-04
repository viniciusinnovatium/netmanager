//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSUCH1
//** Innovatium Systems - Code Converter - v1.24
//** 2014-06-02 20:35:33
//*****************************************************************************

import mLibrary.*;


//<< WWWSUCH1
public class WWWSUCH1 extends mClass {

  public void main() {
    _WWWSUCH1();
  }

  public void _WWWSUCH1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANZEIGEN MIT MANUELLER VORGABE
    //<< ;
    //<< ;   SET YSUCH1="FORMULAR;DATEI;SORTKEY;VORGABEKEY|VORGABEDATEN;ANZEIGE KEY;ANZEIGEFELD;STD SORT;ANZEIGE ERGEBNIS;ORIENTIERUNG;ANZAHL ANZEIGEN;FIXKEY;FELDER MIT SUMMENBILDUNG;WELCHEN KEY UEBERGEBEN;
    //<< ;   D ^WWWSUCH1
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;   YSUCH1      objWWW123
    //<< ;   YFORM       idForm
    //<< ;   YHEADONLY   bln
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 26-Aug-2009   PPP     SR16842:Update the Fixed Index Key (WWW123 #3) to also be
    //<< ;                       a Function call
    //<< ; 16-Jun-2008   GRF     Doco only
    //<< ; 03-May-2007   GRF     SR15509: Doco; brace format
    //<< ; 26.10.1999    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< IF '$FIND(YSUCH1,Y) IF $FIND(YSUCH1,";") SET YSUCH1=$TRANSLATE(YSUCH1,";",Y)
    if (mOp.Not(m$.Fnc.$find(m$.var("YSUCH1").get(),m$.var("Y").get()))) {
      if (mOp.Logical(m$.Fnc.$find(m$.var("YSUCH1").get(),";"))) {
        mVar YSUCH1 = m$.var("YSUCH1");
        YSUCH1.set(m$.Fnc.$translate(m$.var("YSUCH1").get(),";",m$.var("Y").get()));
      }
    }
    //<< IF YSUCH1="" IF YFORM'="" SET YSUCH1=$GET(^WWW123(0,YFORM,1,1))
    if (mOp.Equal(m$.var("YSUCH1").get(),"")) {
      if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
        mVar YSUCH1 = m$.var("YSUCH1");
        YSUCH1.set(m$.Fnc.$get(m$.var("^WWW123",0,m$.var("YFORM").get(),1,1)));
      }
    }
    //<< IF $PIECE(YSUCH1,Y,1)="" SET $PIECE(YSUCH1,Y,1)=YFORM
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),1),"")) {
      m$.pieceVar(m$.var("YSUCH1"),m$.var("Y").get(),1).set(m$.var("YFORM").get());
    }
    //<< 
    //<< NEW YDATEI,YAUSW,YRICHT,YSORT,YANZ,YKOMP,YFIND,YFORM,YFOART,YFKEY,YSAUSW
    mVar YDATEI = m$.var("YDATEI");
    mVar YAUSW = m$.var("YAUSW");
    mVar YRICHT = m$.var("YRICHT");
    mVar YSORT = m$.var("YSORT");
    mVar YANZ = m$.var("YANZ");
    mVar YKOMP = m$.var("YKOMP");
    mVar YFIND = m$.var("YFIND");
    mVar YFORM = m$.var("YFORM");
    mVar YFOART = m$.var("YFOART");
    mVar YFKEY = m$.var("YFKEY");
    mVar YSAUSW = m$.var("YSAUSW");
    m$.newVar(YDATEI,YAUSW,YRICHT,YSORT,YANZ,YKOMP,YFIND,YFORM,YFOART,YFKEY,YSAUSW);
    //<< 
    //<< set YFOART  = 1
    YFOART.set(1);
    //<< set YFORM   = $piece(YSUCH1,Y,1)
    YFORM.set(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),1));
    //<< set YDATEI  = $piece(YSUCH1,Y,2)
    YDATEI.set(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),2));
    //<< set YSORT   = $piece(YSUCH1,Y,3)
    YSORT.set(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),3));
    //<< set YORIENT =+$piece(YSUCH1,Y,9)    ; 0 Ascending, 1 Descending
    mVar YORIENT = m$.var("YORIENT");
    YORIENT.set(mOp.Positive(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),9)));
    //<< 
    //<< //SR16842
    //<< if $extract(YSORT)="@" {
    if (mOp.Equal(m$.Fnc.$extract(YSORT.get()),"@")) {
      //<< new strExec
      mVar strExec = m$.var("strExec");
      m$.newVar(strExec);
      //<< if $extract(YSORT,2)'="$" {
      if (mOp.NotEqual(m$.Fnc.$extract(YSORT.get(),2),"$")) {
        //<< set YSORT = @($extract(YSORT,2,99))
        YSORT.set(m$.indirectVar((m$.Fnc.$extract(YSORT.get(),2,99))).get());
      }
      //<< } else {
      else {
        //<< set strExec = "set YSORT="_$extract(YSORT,2,99)
        strExec.set(mOp.Concat("set YSORT=",m$.Fnc.$extract(YSORT.get(),2,99)));
        //<< xecute strExec
        m$.Cmd.Xecute(strExec.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if +YSORT=0 {                                         ; SR15509
    if (mOp.Equal(mOp.Positive(YSORT.get()),0)) {
      //<< set YAUSW=$piece($piece(YSUCH1,Y,4),"|",1)
      YAUSW.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),4),"|",1));
      //<< if YAUSW'="" set YAUSW="|"_YAUSW
      if (mOp.NotEqual(YAUSW.get(),"")) {
        YAUSW.set(mOp.Concat("|",YAUSW.get()));
      }
    }
    //<< } else {
    else {
      //<< set YAUSW=$$^WWWUMLAU($piece($piece(YSUCH1,Y,4),"|",2),1)
      YAUSW.set(m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),4),"|",2),1));
      //<< if YAUSW'="" set YAUSW="|"_YAUSW
      if (mOp.NotEqual(YAUSW.get(),"")) {
        YAUSW.set(mOp.Concat("|",YAUSW.get()));
      }
    }
    //<< }
    //<< 
    //<< if +YAUSW="" {                                  ; FIXME : +X=0  or X="" - not certain of correct logic <GRF>
    if (mOp.Equal(mOp.Positive(YAUSW.get()),"")) {
      //<< SET YAUSW=$PIECE(YSUCH1,Y,4)
      YAUSW.set(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),4));
      //<< IF YAUSW'="" SET YAUSW="|"_YAUSW
      if (mOp.NotEqual(YAUSW.get(),"")) {
        YAUSW.set(mOp.Concat("|",YAUSW.get()));
      }
    }
    //<< }
    //<< IF $TRANSLATE(YAUSW,"| .")="" SET YAUSW=""
    if (mOp.Equal(m$.Fnc.$translate(YAUSW.get(),"| ."),"")) {
      YAUSW.set("");
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  Execute - build sort order                *** EXECUTE ? ***
    //<< ;  "@$$Function^Routine()" returns sorted fields as though originally stored in D17
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< IF $EXTRACT($PIECE(YSUCH1,Y,17))="@" DO
    if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),17)),"@")) {
      do {
        //<< . NEW YA
        mVar YA = m$.var("YA");
        m$.newVar(YA);
        //<< . IF $EXTRACT($PIECE(YSUCH1,Y,17),2)'="$" SET $PIECE(YSUCH1,Y,17) = @($EXTRACT($PIECE(YSUCH1,Y,17),2,99)) QUIT   ;WENN @ ;when
        if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),17),2),"$")) {
          m$.pieceVar(m$.var("YSUCH1"),m$.var("Y").get(),17).set(m$.indirectVar((m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),17),2,99))).get());
          break;
        }
        //<< . SET YA = "set $PIECE(YSUCH1,Y,17)="_$EXTRACT($PIECE(YSUCH1,Y,17),2,99)
        YA.set(mOp.Concat("set $PIECE(YSUCH1,Y,17)=",m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),17),2,99)));
        //<< . XECUTE YA
        m$.Cmd.Xecute(YA.get());
      } while (false);
    }
    //<< 
    //<< SET YSAUSW = $PIECE($PIECE(YSUCH1,Y,17),"|",1) ;SORTKEY FIX ;skillful
    YSAUSW.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),17),"|",1));
    //<< SET YFKEY  = $PIECE(YSUCH1,Y,11)
    YFKEY.set(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),11));
    //<< SET YANZ   = $PIECE(YSUCH1,Y,10)
    YANZ.set(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),10));
    //<< IF +YANZ=0 SET YANZ = $PIECE($GET(^WWW012(0,YM,1)),Y,135)  ;DFLT. ANZAHL DATENSÄTZE ;Number   ; D135 $$$WWW012NumberOfDataRecordsInSear()
    if (mOp.Equal(mOp.Positive(YANZ.get()),0)) {
      YANZ.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),135));
    }
    //<< IF +YANZ=0 SET YANZ = 1000
    if (mOp.Equal(mOp.Positive(YANZ.get()),0)) {
      YANZ.set(1000);
    }
    //<< 
    //<< SET YKOMP = 1
    YKOMP.set(1);
    //<< SET YFIND = $TRANSLATE($PIECE($PIECE(YSUCH1,Y,4),"|",2),"#",Y)
    YFIND.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),4),"|",2),"#",m$.var("Y").get()));
    //<< SET YFFKY = $TRANSLATE($PIECE($PIECE(YSUCH1,Y,4),"|",3),"#",Y)
    mVar YFFKY = m$.var("YFFKY");
    YFFKY.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),4),"|",3),"#",m$.var("Y").get()));
    //<< ;YHEADONLY=1 = NUR LISTKOPF ANZEIGEN KEINE DATEN ;only display no
    //<< 
    //<< IF $GET(YHEADONLY)'=1 DO ^WWWSOR(YDATEI,YFKEY,YAUSW,YORIENT,YSORT,YANZ,YKOMP,YFIND,YFFKY,YSAUSW)  ;SUCHE AUSWÄHLEN ;search pick out
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHEADONLY")),1)) {
      m$.Cmd.Do("WWWSOR.main",YDATEI.get(),YFKEY.get(),YAUSW.get(),YORIENT.get(),YSORT.get(),YANZ.get(),YKOMP.get(),YFIND.get(),YFFKY.get(),YSAUSW.get());
    }
    //<< ;ZW ^WWWSOR(YUSER)
    //<< ;IF $PIECE(YVOR,Y,44)>0 WRITE YCR,"<TR><TD>"
    //<< ;DO ^WWWFRAME(0)
    //<< DO ^WWWSEAR3
    m$.Cmd.Do("WWWSEAR3.main");
    //<< ;IF $PIECE(YVOR,Y,44)>0 WRITE YCR,"</TD></TR>"
    //<< ;DO ^WWWFRAME(1)
    //<< QUIT
    return;
  }

//<< 
}
