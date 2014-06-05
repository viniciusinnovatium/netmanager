//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORML
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:53
//*****************************************************************************

import mLibrary.*;


//<< WWWFORML
public class WWWFORML extends mClass {

  public void main() {
    _WWWFORML();
  }

  public void _WWWFORML() {
    //<< ;------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       LISTGENERATOR
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
    //<< ; 22-Feb-2008   GRF     Doco; quits; Naked References
    //<< ; 05.08.1997    DT      Created
    //<< ;------------------------------------------------------------------------
    //<< NEW YDATEI,YDATSO,YDNUM,YI
    mVar YDATEI = m$.var("YDATEI");
    mVar YDATSO = m$.var("YDATSO");
    mVar YDNUM = m$.var("YDNUM");
    mVar YI = m$.var("YI");
    m$.newVar(YDATEI,YDATSO,YDNUM,YI);
    //<< 
    //<< IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,30)=1 DO
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),30),1)) {
      //<< . SET $PIECE(^WWW120(0,YFORM,1),Y,30)=0
      m$.pieceVar(m$.var("^WWW120",0,m$.var("YFORM").get(),1),m$.var("Y").get(),30).set(0);
      //<< . KILL ^WWW131(0,YFORM),^WWW132(0,YFORM),^WWW133(0,YFORM)
      m$.var("^WWW131",0,m$.var("YFORM").get()).kill();
      m$.var("^WWW132",0,m$.var("YFORM").get()).kill();
      m$.var("^WWW133",0,m$.var("YFORM").get()).kill();
      //<< . IF '$DATA(^WWW131(0,YFORM)) SET ^WWW131(0,YFORM,1,1)=$PIECE(^WWW120(0,YFORM,1),Y,11)_Y_Y_Y_Y_Y_Y_Y_1_Y_Y_Y_Y_Y_Y_Y_Y_1
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW131",0,m$.var("YFORM").get())))) {
        m$.var("^WWW131",0,m$.var("YFORM").get(),1,1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.var("^WWW120",0,m$.var("YFORM").get(),1).get(),m$.var("Y").get(),11),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),1),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),1));
      }
      //<< . SET YI(3)=""
      YI.var(3).set("");
      //<< . FOR  SET YI(3)=$ORDER(^WWW131(0,YFORM,YI(3))) QUIT:YI(3)=""  DO
      for (;true;) {
        YI.var(3).set(m$.Fnc.$order(m$.var("^WWW131",0,m$.var("YFORM").get(),YI.var(3).get())));
        if (mOp.Equal(YI.var(3).get(),"")) {
          break;
        }
        //<< . . SET YI(1)=$PIECE($GET(^WWW131(0,YFORM,YI(3),1)),Y,1)
        YI.var(1).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW131",0,m$.var("YFORM").get(),YI.var(3).get(),1)),m$.var("Y").get(),1));
        //<< . . IF YI(1)'="" DO
        if (mOp.NotEqual(YI.var(1).get(),"")) {
          //<< . . . SET YI(2)=""
          YI.var(2).set("");
          //<< . . . FOR  SET YI(2)=$ORDER(^WWW002(0,YI(1),YI(2))) QUIT:YI(2)=""  DO
          for (;true;) {
            YI.var(2).set(m$.Fnc.$order(m$.var("^WWW002",0,YI.var(1).get(),YI.var(2).get())));
            if (mOp.Equal(YI.var(2).get(),"")) {
              break;
            }
            //<< . . . . IF '$DATA(^WWW132(0,YFORM,YI(3),YI(2),1)) SET ^WWW132(0,YFORM,YI(3),YI(2),1)=YI(2)_Y_Y_1_Y_1_Y_Y_Y_1_Y
            if (mOp.Not(m$.Fnc.$data(m$.var("^WWW132",0,m$.var("YFORM").get(),YI.var(3).get(),YI.var(2).get(),1)))) {
              m$.var("^WWW132",0,m$.var("YFORM").get(),YI.var(3).get(),YI.var(2).get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YI.var(2).get(),m$.var("Y").get()),m$.var("Y").get()),1),m$.var("Y").get()),1),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),1),m$.var("Y").get()));
            }
          }
          //<< . . . SET YI(2)=""
          YI.var(2).set("");
          //<< . . . FOR  SET YI(2)=$ORDER(^WWW003(0,YI(1),YI(2))) QUIT:YI(2)=""  DO
          for (;true;) {
            YI.var(2).set(m$.Fnc.$order(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get())));
            if (mOp.Equal(YI.var(2).get(),"")) {
              break;
            }
            //<< . . . . IF '$DATA(^WWW133(0,YFORM,YI(3),YI(2),1)) SET ^WWW133(0,YFORM,YI(3),YI(2),1)=YI(2)_Y_Y_1_Y_1_Y_Y_Y_1_Y
            if (mOp.Not(m$.Fnc.$data(m$.var("^WWW133",0,m$.var("YFORM").get(),YI.var(3).get(),YI.var(2).get(),1)))) {
              m$.var("^WWW133",0,m$.var("YFORM").get(),YI.var(3).get(),YI.var(2).get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YI.var(2).get(),m$.var("Y").get()),m$.var("Y").get()),1),m$.var("Y").get()),1),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),1),m$.var("Y").get()));
            }
          }
        }
      }
      //<< 
      //<< ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
      //<< ;PRUEFEN VORGABEN
      //<< ;DO
      //<< . SET YSELECTION=0  ;KEINE SELECTION ;no
      mVar YSELECTION = m$.var("YSELECTION");
      YSELECTION.set(0);
      //<< . SET YI(3)="" FOR  SET YI(3)=$ORDER(^WWW131(0,YFORM,YI(3))) QUIT:YI(3)=""  DO  QUIT:YSELECTION=1
      YI.var(3).set("");
      for (;true;) {
        YI.var(3).set(m$.Fnc.$order(m$.var("^WWW131",0,m$.var("YFORM").get(),YI.var(3).get())));
        if (mOp.Equal(YI.var(3).get(),"")) {
          break;
        }
        //<< . . SET YI(1)=$PIECE($GET(^WWW131(0,YFORM,YI(3),1)),Y,1)
        YI.var(1).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW131",0,m$.var("YFORM").get(),YI.var(3).get(),1)),m$.var("Y").get(),1));
        //<< . . IF YI(1)'="" DO
        if (mOp.NotEqual(YI.var(1).get(),"")) {
          do {
            //<< . . . SET YI(2)=""
            YI.var(2).set("");
            //<< . . . FOR  SET YI(2)=$ORDER(^WWW002(0,YI(1),YI(2))) QUIT:YI(2)=""  DO  QUIT:YSELECTION=1
            for (;true;) {
              YI.var(2).set(m$.Fnc.$order(m$.var("^WWW002",0,YI.var(1).get(),YI.var(2).get())));
              if (mOp.Equal(YI.var(2).get(),"")) {
                break;
              }
              //<< . . . . IF +$PIECE($GET(^WWW132(0,YFORM,YI(3),YI(2),1)),Y,3)'=0 SET YSELECTION=1
              if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW132",0,m$.var("YFORM").get(),YI.var(3).get(),YI.var(2).get(),1)),m$.var("Y").get(),3)),0)) {
                YSELECTION.set(1);
              }
              if (mOp.Equal(YSELECTION.get(),1)) {
                break;
              }
            }
            //<< . . . QUIT:YSELECTION=1
            if (mOp.Equal(YSELECTION.get(),1)) {
              break;
            }
            //<< . . . SET YI(2)="" FOR  SET YI(2)=$ORDER(^WWW003(0,YI(1),YI(2))) QUIT:YI(2)=""  DO  QUIT:YSELECTION=1
            YI.var(2).set("");
            for (;true;) {
              YI.var(2).set(m$.Fnc.$order(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get())));
              if (mOp.Equal(YI.var(2).get(),"")) {
                break;
              }
              //<< . . . . IF +$PIECE($GET(^WWW132(0,YFORM,YI(3),YI(2),1)),Y,3)'=0 SET YSELECTION=1
              if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW132",0,m$.var("YFORM").get(),YI.var(3).get(),YI.var(2).get(),1)),m$.var("Y").get(),3)),0)) {
                YSELECTION.set(1);
              }
              if (mOp.Equal(YSELECTION.get(),1)) {
                break;
              }
            }
          } while (false);
        }
        if (mOp.Equal(YSELECTION.get(),1)) {
          break;
        }
      }
    }
    //<< ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
    //<< 
    //<< WRITE YCR,"</TABLE>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    //<< ;WRITE "<CENTER>"
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< ;W YCR,"<TABLE CELLSPACING=0 BORDER="_+$P(YVOR,Y,13)_">"
    //<< ;I YSELECTION=1 D   ;WENN KEINE AUSWAHL,DANN KEINE FRAGE
    //<< IF '$DATA(^WWW122(0,YFORM)) IF +$PIECE(YVOR,Y,13)=1 DO  ;WRITE YCR,"<FIELDSET STYLE="_""""_"border-color:"_YLIGHTGREY_""""_">"
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),13)),1)) {
        //<< . IF $GET(YDREID)'=1 WRITE YCR,"<FIELDSET STYLE="_""""_"border-color:"_YLIGHTGREY_""""_">"
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDREID")),1)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=","\""),"border-color:"),m$.var("YLIGHTGREY").get()),"\""),">"));
        }
        //<< . IF +$GET(YDREID)=1 WRITE YCR,"<FIELDSET STYLE="_""""_"border-color-dark:"_YLIGHTGREY_"; border-color-light:"_YDARKGRAY_";"_""""_">"  ;FIS;31.03.04;25445;RAHMEN 2-FARBIG
        if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YDREID"))),1)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=","\""),"border-color-dark:"),m$.var("YLIGHTGREY").get()),"; border-color-light:"),m$.var("YDARKGRAY").get()),";"),"\""),">"));
        }
      }
    }
    do {
      //<< 
      //<< DO
      //<< . WRITE YCR,"<TABLE CELLSPACING=0 BORDER=0>"
      m$.Cmd.Write(m$.var("YCR").get(),"<TABLE CELLSPACING=0 BORDER=0>");
      //<< . NEW YDATEI,YDATSO,YDNUM
      m$.newVarBlock(1,YDATEI,YDATSO,YDNUM);
      //<< . SET YDATSO=""
      YDATSO.set("");
      //<< . FOR  SET YDATSO=$ORDER(^WWW131(0,YFORM,YDATSO)) QUIT:YDATSO=""  DO
      for (;true;) {
        YDATSO.set(m$.Fnc.$order(m$.var("^WWW131",0,m$.var("YFORM").get(),YDATSO.get())));
        if (mOp.Equal(YDATSO.get(),"")) {
          break;
        }
        //<< . . SET YLISTDAT=$GET(^WWW131(0,YFORM,YDATSO,1))
        mVar YLISTDAT = m$.var("YLISTDAT");
        YLISTDAT.set(m$.Fnc.$get(m$.var("^WWW131",0,m$.var("YFORM").get(),YDATSO.get(),1)));
        //<< . . SET YDATEI=$PIECE(YLISTDAT,Y,1)
        YDATEI.set(m$.Fnc.$piece(YLISTDAT.get(),m$.var("Y").get(),1));
        //<< . . SET YSORT=$PIECE(YLISTDAT,Y,2)
        mVar YSORT = m$.var("YSORT");
        YSORT.set(m$.Fnc.$piece(YLISTDAT.get(),m$.var("Y").get(),2));
        //<< . . ;WRITE YCR
        //<< . . ;WRITE "<TR>"
        //<< . . ;WRITE "<TD>"
        //<< . . ;WRITE YCR,"<FONT SIZE="_""""_$PIECE(YVOR,Y,7)_""""_">"
        //<< . . DO SUCH
        m$.Cmd.Do("SUCH");
        //<< . . ;WRITE YCR,"</FONT></TD>"
        //<< . . ;WRITE YCR,"</TR>"
        //<< . . WRITE YCR,"<TR>"
        m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
        //<< . . WRITE YCR,"<TD ALIGN=RIGHT NOWRAP VALIGN=TOP>"
        m$.Cmd.Write(m$.var("YCR").get(),"<TD ALIGN=RIGHT NOWRAP VALIGN=TOP>");
        //<< . . WRITE "<FONT SIZE="_""""_$PIECE(YVOR,Y,7)_""""_">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FONT SIZE=","\""),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\""),">"));
        //<< . . WRITE $$^WWWTEXT(382)          ; "Print Orientation"
        m$.Cmd.Write(m$.fnc$("WWWTEXT.main",382));
        //<< . . WRITE "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . WRITE YCR,"</FONT></TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</FONT></TD>");
        //<< . . DO RICHT
        m$.Cmd.Do("RICHT");
        //<< . . WRITE YCR,"</TR>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
        //<< . . ;;W YCR,"</TABLE>"
        //<< . . ;;WRITE YCR,"<TABLE CELLSPACING=0 BORDER=0>"
        //<< . . ;W "<TR>"
        //<< . . ;W "<TD>&nbsp;"
        //<< . . ;W YCR,"</TD>"
        //<< . . ;W YCR,"</TR>"
        //<< . . ;SET YHID=""
        //<< . . ;SET YHIDDSE=0  ;TYBD;WENN AUS ;table-mat when out of
        //<< . . DO PRIM
        m$.Cmd.Do("PRIM");
        //<< . . DO FELD
        m$.Cmd.Do("FELD");
      }
      //<< . ;
      //<< . WRITE YCR,"</TABLE>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    } while(false);
    m$.restoreVarBlock(1);
    //<< . ;WRITE "</CENTER>"
    //<< 
    //<< IF '$DATA(^WWW122(0,YFORM)) IF +$PIECE(YVOR,Y,13)=1 WRITE YCR,"</FIELDSET>"
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),13)),1)) {
        m$.Cmd.Write(m$.var("YCR").get(),"</FIELDSET>");
      }
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< SUCH ;AUSWAHL SORTKEY ;Selection
  public Object SUCH() {
    //<< QUIT:YDATEI=""
    if (mOp.Equal(m$.var("YDATEI").get(),"")) {
      return null;
    }
    //<< NEW YSKEY,YA,YI,YX
    mVar YSKEY = m$.var("YSKEY");
    mVar YA = m$.var("YA");
    mVar YI = m$.var("YI");
    mVar YX = m$.var("YX");
    m$.newVar(YSKEY,YA,YI,YX);
    //<< 
    //<< IF '$DATA(YSORT) SET YSORT = ""
    if (mOp.Not(m$.Fnc.$data(m$.var("YSORT")))) {
      mVar YSORT = m$.var("YSORT");
      YSORT.set("");
    }
    //<< IF YSORT="" IF $PIECE(YLISTDAT,Y,3)'="" SET YSORT = +$PIECE(YLISTDAT,Y,3)
    if (mOp.Equal(m$.var("YSORT").get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YLISTDAT").get(),m$.var("Y").get(),3),"")) {
        mVar YSORT = m$.var("YSORT");
        YSORT.set(mOp.Positive(m$.Fnc.$piece(m$.var("YLISTDAT").get(),m$.var("Y").get(),3)));
      }
    }
    //<< 
    //<< SET YSKEY(0)=""
    YSKEY.var(0).set("");
    //<< SET YLFN = ""
    mVar YLFN = m$.var("YLFN");
    YLFN.set("");
    //<< FOR  SET YLFN = $ORDER(^WWW002(0,YDATEI,YLFN)) QUIT:YLFN=""  DO   ;neue selection; tybd;4,07,2003
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      //<< . SET YNAME = ""
      mVar YNAME = m$.var("YNAME");
      YNAME.set("");
      //<< . IF YFORM'="" IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,11)=YDATEI SET YNAME=$$^WWWFELDNAME(YFORM,"P",YLFN)
      if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),11),m$.var("YDATEI").get())) {
          YNAME.set(m$.fnc$("WWWFELDNAME.main",m$.var("YFORM").get(),"P",YLFN.get()));
        }
      }
      //<< . IF YNAME="" DO
      if (mOp.Equal(YNAME.get(),"")) {
        //<< . . SET YNAME = $PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,2)
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),2));
        //<< . . IF $DATA(^WWW0021(0,YDATEI,YLFN,SPRACHE,1)) SET YNAME=$PIECE(^WWW0021(0,YDATEI,YLFN,SPRACHE,1),Y,1)     ; Naked Ref
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0021",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
          YNAME.set(m$.Fnc.$piece(m$.var("^WWW0021",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        }
      }
      //<< . ;
      //<< . SET $PIECE(YSKEY(0),"/",YLFN)=YNAME
      m$.pieceVar(YSKEY.var(0),"/",YLFN.get()).set(YNAME.get());
      //<< . ;
      //<< . SET YSKEY = $PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,6)
      YSKEY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),6));
      //<< . FOR YI=1:1 SET YA = $PIECE(YSKEY,",",YI) QUIT:YA=""  DO
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        YA.set(m$.Fnc.$piece(YSKEY.get(),",",YI.get()));
        if (mOp.Equal(YA.get(),"")) {
          break;
        }
        do {
          //<< . . SET YA(1) = +$PIECE(YA,".",1)
          YA.var(1).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",1)));
          //<< . . SET YA(2) = +$PIECE(YA,".",2)
          YA.var(2).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",2)));
          //<< . . QUIT:+YA(1)=0
          if (mOp.Equal(mOp.Positive(YA.var(1).get()),0)) {
            break;
          }
          //<< . . IF +YA(2)=0 SET YA(2)=1
          if (mOp.Equal(mOp.Positive(YA.var(2).get()),0)) {
            YA.var(2).set(1);
          }
          //<< . . SET YNAME=""
          YNAME.set("");
          //<< . . IF YFORM'="" IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,11)=YDATEI SET YNAME=$$^WWWFELDNAME(YFORM,"P",YLFN)
          if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
            if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),11),m$.var("YDATEI").get())) {
              YNAME.set(m$.fnc$("WWWFELDNAME.main",m$.var("YFORM").get(),"P",YLFN.get()));
            }
          }
          //<< . . IF YNAME="" DO
          if (mOp.Equal(YNAME.get(),"")) {
            //<< . . . SET YNAME = $PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,2)
            YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),2));
            //<< . . . IF $DATA(^WWW0021(0,YDATEI,YLFN,SPRACHE,1)) SET YNAME=$PIECE(^WWW0021(0,YDATEI,YLFN,SPRACHE,1),Y,1)     ; Naked Ref
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0021",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
              YNAME.set(m$.Fnc.$piece(m$.var("^WWW0021",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
            }
          }
          //<< . . ;
          //<< . . SET $PIECE(YSKEY(YA(1)),"/",YA(2))=YNAME
          m$.pieceVar(YSKEY.var(YA.var(1).get()),"/",YA.var(2).get()).set(YNAME.get());
        } while (false);
      }
    }
    //<< 
    //<< SET YLFN = ""
    YLFN.set("");
    //<< FOR  SET YLFN = $ORDER(^WWW003(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      //<< . SET YSKEY = $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,6)
      YSKEY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),6));
      //<< . FOR YI=1:1 SET YA = $PIECE(YSKEY,",",YI) QUIT:YA=""  DO
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        YA.set(m$.Fnc.$piece(YSKEY.get(),",",YI.get()));
        if (mOp.Equal(YA.get(),"")) {
          break;
        }
        do {
          //<< . . SET YA(1) = +$PIECE(YA,".",1)
          YA.var(1).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",1)));
          //<< . . SET YA(2) = +$PIECE(YA,".",2)
          YA.var(2).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",2)));
          //<< . . QUIT:+YA(1)=0
          if (mOp.Equal(mOp.Positive(YA.var(1).get()),0)) {
            break;
          }
          //<< . . IF +YA(2)=0 SET YA(2)=1
          if (mOp.Equal(mOp.Positive(YA.var(2).get()),0)) {
            YA.var(2).set(1);
          }
          //<< . . SET YNAME=""
          mVar YNAME = m$.var("YNAME");
          YNAME.set("");
          //<< . . IF YFORM'="" IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,11)=YDATEI DO
          if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
            if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),11),m$.var("YDATEI").get())) {
              do {
                //<< . . . NEW YLFN1
                mVar YLFN1 = m$.var("YLFN1");
                m$.newVarBlock(3,YLFN1);
                //<< . . . SET YLFN1=$ORDER(^WWW122s(0,4,YLFN,YFORM,""))
                YLFN1.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,YLFN.get(),m$.var("YFORM").get(),"")));
                //<< . . . QUIT:YLFN1=""
                if (mOp.Equal(YLFN1.get(),"")) {
                  break;
                }
                //<< . . . SET YNAME=$$^WWWFELDNAME(YFORM,"D",YLFN1)
                YNAME.set(m$.fnc$("WWWFELDNAME.main",m$.var("YFORM").get(),"D",YLFN1.get()));
              } while (false);
            }
            m$.restoreVarBlock(3);
          }
          //<< . . ;
          //<< . . IF YNAME="" DO
          if (mOp.Equal(YNAME.get(),"")) {
            //<< . . . SET YNAME=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,2)
            YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),2));
            //<< . . . IF $DATA(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)) SET YNAME=$PIECE(^WWW0031(0,YDATEI,YLFN,SPRACHE,1),Y,1)     ; Naked Ref
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
              YNAME.set(m$.Fnc.$piece(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
            }
          }
          //<< . . ;
          //<< . . SET $PIECE(YSKEY(YA(1)),"/",YA(2))=YNAME
          m$.pieceVar(YSKEY.var(YA.var(1).get()),"/",YA.var(2).get()).set(YNAME.get());
        } while (false);
      }
    }
    do {
      //<< 
      //<< DO
      //<< . IF $ORDER(YSKEY(0))="" DO  QUIT
      if (mOp.Equal(m$.Fnc.$order(YSKEY.var(0)),"")) {
        do {
          //<< . . ;WRITE YCR
          //<< . . ;WRITE "&nbsp;"
          //<< . . ;WRITE YCR,"</TD>"
          //<< . . ;WRITE YCR,"<TD>"
          //<< . . ;WRITE "&nbsp;"
          //<< . . WRITE "<INPUT TYPE=HIDDEN NAME="_""""_"Y"_YFORM_"S"_YDATSO_""""_" VALUE=0>"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=","\""),"Y"),m$.var("YFORM").get()),"S"),m$.var("YDATSO").get()),"\"")," VALUE=0>"));
          //<< . ;
          //<< . ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
          //<< . ;DO
          //<< . . IF $DATA(^WWW0011(0,YDATEI,SPRACHE,1)) WRITE $$^WWWUML($PIECE(^WWW0011(0,YDATEI,SPRACHE,1),Y,1))_" " QUIT     ; Naked Ref
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0011",0,m$.var("YDATEI").get(),m$.var("SPRACHE").get(),1)))) {
            m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.var("^WWW0011",0,m$.var("YDATEI").get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1))," "));
            break;
          }
          //<< . . WRITE $$^WWWUML($PIECE($GET(^WWW001(0,YDATEI,1)),Y,1))_" "
          m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YDATEI").get(),1)),m$.var("Y").get(),1))," "));
        } while (false);
        break;
      }
      //<< . ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
      //<< . WRITE "<TR>"
      m$.Cmd.Write("<TR>");
      //<< . WRITE "<TD ALIGN=RIGHT>"
      m$.Cmd.Write("<TD ALIGN=RIGHT>");
      //<< . WRITE YCR,"<FONT SIZE="_""""_$PIECE(YVOR,Y,7)_""""_">"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FONT SIZE=","\""),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\""),">"));
      //<< . WRITE $$^WWWTEXT(65)
      m$.Cmd.Write(m$.fnc$("WWWTEXT.main",65));
      //<< . WRITE "&nbsp;"
      m$.Cmd.Write("&nbsp;");
      //<< . WRITE YCR,"</FONT></TD>"
      m$.Cmd.Write(m$.var("YCR").get(),"</FONT></TD>");
      //<< . ;
      //<< . WRITE YCR,"<TD>"
      m$.Cmd.Write(m$.var("YCR").get(),"<TD>");
      //<< . WRITE "<select NAME="_""""_"Y"_YFORM_"S"_YDATSO_""""_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<select NAME=","\""),"Y"),m$.var("YFORM").get()),"S"),m$.var("YDATSO").get()),"\""),">"));
      //<< . IF +YSORT=0  WRITE "<option value="_""""_0_""""_" SELECTED=SELECTED>"_$$^WWWUML(YSKEY(0))_"</option>"
      if (mOp.Equal(mOp.Positive(m$.var("YSORT").get()),0)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<option value=","\""),0),"\"")," SELECTED=SELECTED>"),m$.fnc$("WWWUML.main",YSKEY.var(0).get())),"</option>"));
      }
      //<< . IF +YSORT'=0 WRITE "<option value="_""""_0_""""_">"_$$^WWWUML(YSKEY(0))_"</option>"
      if (mOp.NotEqual(mOp.Positive(m$.var("YSORT").get()),0)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<option value=","\""),0),"\""),">"),m$.fnc$("WWWUML.main",YSKEY.var(0).get())),"</option>"));
      }
      //<< . SET YA="0"
      YA.set("0");
      //<< . FOR  SET YA = $ORDER(YSKEY(YA)) QUIT:YA=""  DO
      for (;true;) {
        YA.set(m$.Fnc.$order(YSKEY.var(YA.get())));
        if (mOp.Equal(YA.get(),"")) {
          break;
        }
        do {
          //<< . . QUIT:YSKEY(YA)="_FREE"
          if (mOp.Equal(YSKEY.var(YA.get()).get(),"_FREE")) {
            break;
          }
          //<< . . IF YSORT'=YA WRITE YCR,"<option value="_""""_YA_""""_">"_$$^WWWUML(YSKEY(YA))_"</option>"
          if (mOp.NotEqual(m$.var("YSORT").get(),YA.get())) {
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<option value=","\""),YA.get()),"\""),">"),m$.fnc$("WWWUML.main",YSKEY.var(YA.get()).get())),"</option>"));
          }
          //<< . . IF YSORT=YA  WRITE YCR,"<option value="_""""_YA_""""_" SELECTED=SELECTED>"_$$^WWWUML(YSKEY(YA))_"</option>"
          if (mOp.Equal(m$.var("YSORT").get(),YA.get())) {
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<option value=","\""),YA.get()),"\"")," SELECTED=SELECTED>"),m$.fnc$("WWWUML.main",YSKEY.var(YA.get()).get())),"</option>"));
          }
        } while (false);
      }
      //<< . ;
      //<< . WRITE "</select>"
      m$.Cmd.Write("</select>");
      //<< . WRITE YCR,"</TD>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
      //<< . WRITE YCR,"</TR>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    } while(false);
    //<< 
    //<< QUIT
    return null;
  }

  //<< 
  //<< RICHT ;ORIENTIERUNG AUF ODER ABSTEIGEND? ;upon Or
  public void RICHT() {
    //<< IF '$DATA(YORIENT) SET YORIENT=0
    if (mOp.Not(m$.Fnc.$data(m$.var("YORIENT")))) {
      mVar YORIENT = m$.var("YORIENT");
      YORIENT.set(0);
    }
    //<< IF YORIENT=""      SET YORIENT=0
    if (mOp.Equal(m$.var("YORIENT").get(),"")) {
      mVar YORIENT = m$.var("YORIENT");
      YORIENT.set(0);
    }
    do {
      //<< DO
      //<< . WRITE YCR,"<TD NOWRAP>"
      m$.Cmd.Write(m$.var("YCR").get(),"<TD NOWRAP>");
      //<< . WRITE "<FONT SIZE=2>",YCR
      m$.Cmd.Write("<FONT SIZE=2>",m$.var("YCR").get());
      //<< . IF $GET(YDREID)'=1 WRITE "<FIELDSET STYLE="_""""_"border-color:"_YLIGHTGREY_""""_">"
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDREID")),1)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=","\""),"border-color:"),m$.var("YLIGHTGREY").get()),"\""),">"));
      }
      //<< . IF +$GET(YDREID)=1 WRITE "<FIELDSET STYLE="_""""_"border-color-dark:"_YLIGHTGREY_"; border-color-light:"_YDARKGRAY_";"_""""_">"  ;FIS;31.03.04;25445;RAHMEN 2-FARBIG
      if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YDREID"))),1)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=","\""),"border-color-dark:"),m$.var("YLIGHTGREY").get()),"; border-color-light:"),m$.var("YDARKGRAY").get()),";"),"\""),">"));
      }
      //<< . WRITE YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . ;WRITE "<LEGEND>"_$$^WWWTEXT(382)_"</LEGEND>"    ; "Print Orientation"
      //<< . ;W $$^WWWTEXT(110)_" "
      //<< . FOR YI=0,1 DO
      mVar YI = m$.var("YI");
      for (Object _YI: new Object[] {0,1}) {
        YI.set(_YI);
        //<< . . IF YI=1 WRITE YCR,"<BR>"
        if (mOp.Equal(_YI,1)) {
          m$.Cmd.Write(m$.var("YCR").get(),"<BR>");
        }
        //<< . . WRITE YCR,"<FONT SIZE="_""""_$PIECE(YVOR,Y,7)_""""_">"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FONT SIZE=","\""),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\""),">"));
        //<< . . SET YA=$PIECE($$^WWWTEXT(112)_"#"_$$^WWWTEXT(111),"#",YI+1)    ; "Ascending"  "Descending"
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$piece(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",112),"#"),m$.fnc$("WWWTEXT.main",111)),"#",mOp.Add(_YI,1)));
        //<< . . WRITE "<INPUT TYPE="_""""_"RADIO"_""""_" NAME="_""""_"Y"_YFORM_"LR"_YDATSO_""""_" VALUE="_""""_YI_""""
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=","\""),"RADIO"),"\"")," NAME="),"\""),"Y"),m$.var("YFORM").get()),"LR"),m$.var("YDATSO").get()),"\"")," VALUE="),"\""),_YI),"\""));
        //<< . . IF YI=YORIENT WRITE " CHECKED="_""""_"CHECKED"_""""
        if (mOp.Equal(_YI,m$.var("YORIENT").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" CHECKED=","\""),"CHECKED"),"\""));
        }
        //<< . . WRITE "> "_YA
        m$.Cmd.Write(mOp.Concat("> ",YA.get()));
        //<< . . WRITE "</INPUT></FONT>"
        m$.Cmd.Write("</INPUT></FONT>");
      }
      //<< . ;
      //<< . WRITE YCR,"</FIELDSET>"
      m$.Cmd.Write(m$.var("YCR").get(),"</FIELDSET>");
      //<< . WRITE YCR,"</FONT></TD>"
      m$.Cmd.Write(m$.var("YCR").get(),"</FONT></TD>");
    } while(false);
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< PRIM
  public void PRIM() {
    //<< SET YLFD = ""
    mVar YLFD = m$.var("YLFD");
    YLFD.set("");
    //<< FOR  SET YLFD = $ORDER(^WWW132(0,YFORM,YDATSO,YLFD)) QUIT:YLFD=""  DO
    for (;true;) {
      YLFD.set(m$.Fnc.$order(m$.var("^WWW132",0,m$.var("YFORM").get(),m$.var("YDATSO").get(),YLFD.get())));
      if (mOp.Equal(YLFD.get(),"")) {
        break;
      }
      do {
        //<< . SET YLISTLF = $GET(^WWW132(0,YFORM,YDATSO,YLFD,1))
        mVar YLISTLF = m$.var("YLISTLF");
        YLISTLF.set(m$.Fnc.$get(m$.var("^WWW132",0,m$.var("YFORM").get(),m$.var("YDATSO").get(),YLFD.get(),1)));
        //<< . SET YLFN    = $PIECE(YLISTLF,Y,1)
        mVar YLFN = m$.var("YLFN");
        YLFN.set(m$.Fnc.$piece(YLISTLF.get(),m$.var("Y").get(),1));
        //<< . QUIT:+$PIECE(YLISTLF,Y,2)'=0
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YLISTLF.get(),m$.var("Y").get(),2)),0)) {
          break;
        }
        //<< . QUIT:YLFN=""
        if (mOp.Equal(YLFN.get(),"")) {
          break;
        }
        //<< . QUIT:+$PIECE(YLISTLF,Y,3)=0
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(YLISTLF.get(),m$.var("Y").get(),3)),0)) {
          break;
        }
        //<< . SET YSATZ = $GET(^WWW002(0,YDATEI,YLFN,1))
        mVar YSATZ = m$.var("YSATZ");
        YSATZ.set(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get(),1)));
        //<< . IF $DATA(^WWW0021(0,YDATEI,YLFN,SPRACHE,1)) SET $PIECE(YSATZ,Y,2)=$PIECE(^WWW0021(0,YDATEI,YLFN,SPRACHE,1),Y,1)     ; Naked Ref
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0021",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
          m$.pieceVar(YSATZ,m$.var("Y").get(),2).set(m$.Fnc.$piece(m$.var("^WWW0021",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . SET $PIECE(YSATZ,Y,88)=$PIECE(YLISTLF,Y,88)   ;FELDLÄNGE GEÄNDERT ;field size
        m$.pieceVar(YSATZ,m$.var("Y").get(),88).set(m$.Fnc.$piece(YLISTLF.get(),m$.var("Y").get(),88));
        //<< . QUIT:YSATZ=""
        if (mOp.Equal(YSATZ.get(),"")) {
          break;
        }
        //<< . SET YFOART = 2
        mVar YFOART = m$.var("YFOART");
        YFOART.set(2);
        //<< . SET YART   = "LP"
        mVar YART = m$.var("YART");
        YART.set("LP");
        //<< . IF '$DATA(^WWW127(0,YFORM,YART,YLFN,SPRACHE,1)) SET ^WWW127(0,YFORM,YART,YLFN,SPRACHE,1) = ""
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWW127",0,m$.var("YFORM").get(),YART.get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
          m$.var("^WWW127",0,m$.var("YFORM").get(),YART.get(),YLFN.get(),m$.var("SPRACHE").get(),1).set("");
        }
        //<< . SET YLFN = +YDATSO_$EXTRACT(100+YLFN,2,3)
        YLFN.set(mOp.Concat(mOp.Positive(m$.var("YDATSO").get()),m$.Fnc.$extract(mOp.Add(100,YLFN.get()),2,3)));
        //<< . DO ^WWWFORM9
        m$.Cmd.Do("WWWFORM9.main");
      } while (false);
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< FELD
  public void FELD() {
    //<< SET YLFD = ""
    mVar YLFD = m$.var("YLFD");
    YLFD.set("");
    //<< FOR  SET YLFD = $ORDER(^WWW133(0,YFORM,YDATSO,YLFD)) QUIT:YLFD=""  DO
    for (;true;) {
      YLFD.set(m$.Fnc.$order(m$.var("^WWW133",0,m$.var("YFORM").get(),m$.var("YDATSO").get(),YLFD.get())));
      if (mOp.Equal(YLFD.get(),"")) {
        break;
      }
      do {
        //<< . SET YLISTLF = $GET(^WWW133(0,YFORM,YDATSO,YLFD,1))
        mVar YLISTLF = m$.var("YLISTLF");
        YLISTLF.set(m$.Fnc.$get(m$.var("^WWW133",0,m$.var("YFORM").get(),m$.var("YDATSO").get(),YLFD.get(),1)));
        //<< . SET YLFN    = $PIECE(YLISTLF,Y,1)
        mVar YLFN = m$.var("YLFN");
        YLFN.set(m$.Fnc.$piece(YLISTLF.get(),m$.var("Y").get(),1));
        //<< . QUIT:YLFN=""
        if (mOp.Equal(YLFN.get(),"")) {
          break;
        }
        //<< . QUIT:+$PIECE(YLISTLF,Y,3)=0
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(YLISTLF.get(),m$.var("Y").get(),3)),0)) {
          break;
        }
        //<< . SET YSATZ=$GET(^WWW003(0,YDATEI,YLFN,1))
        mVar YSATZ = m$.var("YSATZ");
        YSATZ.set(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)));
        //<< . IF $DATA(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)) SET $PIECE(YSATZ,Y,2)=$PIECE(^WWW0031(0,YDATEI,YLFN,SPRACHE,1),Y,1) ; Naked Ref
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
          m$.pieceVar(YSATZ,m$.var("Y").get(),2).set(m$.Fnc.$piece(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . SET $PIECE(YSATZ,Y,88)=$PIECE(YLISTLF,Y,88)   ;FELDLÄNGE GEÄNDERT ;field size
        m$.pieceVar(YSATZ,m$.var("Y").get(),88).set(m$.Fnc.$piece(YLISTLF.get(),m$.var("Y").get(),88));
        //<< . QUIT:YSATZ=""
        if (mOp.Equal(YSATZ.get(),"")) {
          break;
        }
        //<< . SET YFOART = 2
        mVar YFOART = m$.var("YFOART");
        YFOART.set(2);
        //<< . SET YART   = "LD"
        mVar YART = m$.var("YART");
        YART.set("LD");
        //<< . IF '$DATA(^WWW127(0,YFORM,YART,YLFN,SPRACHE,1)) SET ^WWW127(0,YFORM,YART,YLFN,SPRACHE,1) = ""
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWW127",0,m$.var("YFORM").get(),YART.get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
          m$.var("^WWW127",0,m$.var("YFORM").get(),YART.get(),YLFN.get(),m$.var("SPRACHE").get(),1).set("");
        }
        //<< . SET YLFN = +YDATSO_$EXTRACT(100+YLFN,2,3)
        YLFN.set(mOp.Concat(mOp.Positive(m$.var("YDATSO").get()),m$.Fnc.$extract(mOp.Add(100,YLFN.get()),2,3)));
        //<< . DO ^WWWFORM9
        m$.Cmd.Do("WWWFORM9.main");
      } while (false);
    }
    //<< 
    //<< QUIT
    return;
  }

//<< 
//<< 
}
