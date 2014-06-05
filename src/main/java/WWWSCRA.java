//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSCRA
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:00
//*****************************************************************************

import mLibrary.*;


//<< WWWSCRA
public class WWWSCRA extends mClass {

  public void main() {
    _WWWSCRA();
  }

  public void _WWWSCRA() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SCREEN MOVE ANALYSIS
    //<< ;   DIESES PROGRAMM WERTET DIE EINGABEN AUS DEM SCREEN EDIT AUS
    //<< ;   This program evaluates the input from the screen edit
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
    //<< ; 24-Aug-2007   GRF     Doco; quits; expand commands
    //<< ; 09.07.1999    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YI,YQ,YDAT,YFELD
    mVar YI = m$.var("YI");
    mVar YQ = m$.var("YQ");
    mVar YDAT = m$.var("YDAT");
    mVar YFELD = m$.var("YFELD");
    m$.newVar(YI,YQ,YDAT,YFELD);
    //<< 
    //<< SET YDAT  = $PIECE(YSCR,"-",1)
    YDAT.set(m$.Fnc.$piece(m$.var("YSCR").get(),"-",1));
    //<< SET YFELD = $PIECE(YSCR,"-",2)
    YFELD.set(m$.Fnc.$piece(m$.var("YSCR").get(),"-",2));
    //<< SET YQ    = $PIECE(YSCR,"-",3)
    YQ.set(m$.Fnc.$piece(m$.var("YSCR").get(),"-",3));
    //<< 
    //<< QUIT:YDAT=""
    if (mOp.Equal(YDAT.get(),"")) {
      return;
    }
    //<< QUIT:YFELD=""
    if (mOp.Equal(YFELD.get(),"")) {
      return;
    }
    //<< QUIT:YFORM=""
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      return;
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; FIXME : <GRF> There is no class WWW122DU
    //<< ;         either killed or set to 1 here and used in WWWFORMD to change hidden flags
    //<< ;---------------------------------------
    //<< 
    //<< IF $GET(YUSERPROFILE)'="" IF YQ'="" DO  QUIT  ;USER ACCESS SPECIAL
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSERPROFILE")),"")) {
      if (mOp.NotEqual(YQ.get(),"")) {
        //<< . IF YQ="K" SET ^WWW122DU(0,YFORM,YM,YUSERPROFILE,YFELD,1)=1  ;DO NOT SHOW
        if (mOp.Equal(YQ.get(),"K")) {
          m$.var("^WWW122DU",0,m$.var("YFORM").get(),m$.var("YM").get(),m$.var("YUSERPROFILE").get(),YFELD.get(),1).set(1);
        }
        //<< . IF YQ="X" KILL ^WWW122DU(0,YFORM,YM,YUSERPROFILE)           ;SHOW
        if (mOp.Equal(YQ.get(),"X")) {
          m$.var("^WWW122DU",0,m$.var("YFORM").get(),m$.var("YM").get(),m$.var("YUSERPROFILE").get()).kill();
        }
        return;
      }
    }
    //<< 
    //<< IF YDAT="B" DO  QUIT  ;BUTTONAUSWERTUNG KOPF
    if (mOp.Equal(YDAT.get(),"B")) {
      //<< . IF YFELD=1 DO  ;FORMULARART
      if (mOp.Equal(YFELD.get(),1)) {
        //<< . . SET YI(1)=$PIECE($GET(^WWW120(0,YFORM,1)),Y,44)
        YI.var(1).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),44));
        //<< . . SET YI(1)=YI(1)+1
        YI.var(1).set(mOp.Add(YI.var(1).get(),1));
        //<< . . IF YI(1)>2 SET YI(1)=0
        if (mOp.Greater(YI.var(1).get(),2)) {
          YI.var(1).set(0);
        }
        //<< . . SET $PIECE(^WWW120(0,YFORM,1),Y,44)=YI(1)
        m$.pieceVar(m$.var("^WWW120",0,m$.var("YFORM").get(),1),m$.var("Y").get(),44).set(YI.var(1).get());
      }
      //<< . ;
      //<< . IF YFELD=2 DO  ;FORMULARART
      if (mOp.Equal(YFELD.get(),2)) {
        do {
          //<< . . SET YI(1)=$PIECE($GET(^WWW120(0,YFORM,1)),Y,2)
          YI.var(1).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),2));
          //<< . . IF YI(1)=1 SET $PIECE(^WWW120(0,YFORM,1),Y,2)=3 SET $PIECE(^WWW120(0,YFORM,1),Y,44)=1 QUIT
          if (mOp.Equal(YI.var(1).get(),1)) {
            m$.pieceVar(m$.var("^WWW120",0,m$.var("YFORM").get(),1),m$.var("Y").get(),2).set(3);
            m$.pieceVar(m$.var("^WWW120",0,m$.var("YFORM").get(),1),m$.var("Y").get(),44).set(1);
            break;
          }
          //<< . . IF YI(1)=3 SET $PIECE(^WWW120(0,YFORM,1),Y,2)=1 QUIT
          if (mOp.Equal(YI.var(1).get(),3)) {
            m$.pieceVar(m$.var("^WWW120",0,m$.var("YFORM").get(),1),m$.var("Y").get(),2).set(1);
            break;
          }
        } while (false);
      }
      //<< . ;
      //<< . IF YFELD=3 DO  ;FRAME
      if (mOp.Equal(YFELD.get(),3)) {
        do {
          //<< . . SET YI(1)=$PIECE($GET(^WWW120(0,YFORM,1)),Y,13)
          YI.var(1).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),13));
          //<< . . IF +YI(1)=0 SET $PIECE(^WWW120(0,YFORM,1),Y,13)=1 QUIT
          if (mOp.Equal(mOp.Positive(YI.var(1).get()),0)) {
            m$.pieceVar(m$.var("^WWW120",0,m$.var("YFORM").get(),1),m$.var("Y").get(),13).set(1);
            break;
          }
          //<< . . IF YI(1)=1  SET $PIECE(^WWW120(0,YFORM,1),Y,13)=0 QUIT
          if (mOp.Equal(YI.var(1).get(),1)) {
            m$.pieceVar(m$.var("^WWW120",0,m$.var("YFORM").get(),1),m$.var("Y").get(),13).set(0);
            break;
          }
        } while (false);
      }
      //<< . ;
      //<< . IF YFELD=4 DO  ;HORIZONTAL
      if (mOp.Equal(YFELD.get(),4)) {
        do {
          //<< . . SET YI(1)=$PIECE($GET(^WWW120(0,YFORM,1)),Y,36)
          YI.var(1).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),36));
          //<< . . IF YI(1)=1  SET $PIECE(^WWW120(0,YFORM,1),Y,36)=3 QUIT
          if (mOp.Equal(YI.var(1).get(),1)) {
            m$.pieceVar(m$.var("^WWW120",0,m$.var("YFORM").get(),1),m$.var("Y").get(),36).set(3);
            break;
          }
          //<< . . IF YI(1)'=1 SET $PIECE(^WWW120(0,YFORM,1),Y,36)=1 QUIT
          if (mOp.NotEqual(YI.var(1).get(),1)) {
            m$.pieceVar(m$.var("^WWW120",0,m$.var("YFORM").get(),1),m$.var("Y").get(),36).set(1);
            break;
          }
        } while (false);
      }
      return;
    }
    //<< 
    //<< QUIT:YQ=""
    if (mOp.Equal(YQ.get(),"")) {
      return;
    }
    //<< 
    //<< SET YI="^WWW122(0,"_""""_YFORM_""""_","_YFELD_",1)"
    YI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW122(0,","\""),m$.var("YFORM").get()),"\""),","),YFELD.get()),",1)"));
    //<< IF YDAT="P" SET YI="^WWW121(0,"_""""_YFORM_""""_","_YFELD_",1)"
    if (mOp.Equal(YDAT.get(),"P")) {
      YI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW121(0,","\""),m$.var("YFORM").get()),"\""),","),YFELD.get()),",1)"));
    }
    //<< SET YI(1)=$GET(@YI)          ;SUCHEN FELD ;seek field
    YI.var(1).set(m$.Fnc.$get(m$.indirectVar(YI.get())));
    //<< IF YDAT'="P" QUIT:YI(1)=""   ;WENN "PRIMÄRSCHLÜSSEL DANN KANN AUCH LEER
    if (mOp.NotEqual(YDAT.get(),"P")) {
      if (mOp.Equal(YI.var(1).get(),"")) {
        return;
      }
    }
    //<< IF YDAT'="P" DO
    if (mOp.NotEqual(YDAT.get(),"P")) {
      //<< . SET SK1=$$^WWWUMLAU(YFORM,1)
      mVar SK1 = m$.var("SK1");
      SK1.set(m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1));
      //<< . SET SK2=$PIECE(YI(1),Y,60)
      mVar SK2 = m$.var("SK2");
      SK2.set(m$.Fnc.$piece(YI.var(1).get(),m$.var("Y").get(),60));
      //<< . IF SK2="" SET SK2=" "
      if (mOp.Equal(SK2.get(),"")) {
        SK2.set(" ");
      }
      //<< . SET SK3=$PIECE(YI(1),Y,3)
      mVar SK3 = m$.var("SK3");
      SK3.set(m$.Fnc.$piece(YI.var(1).get(),m$.var("Y").get(),3));
      //<< . IF SK3="" SET SK3=" "
      if (mOp.Equal(SK3.get(),"")) {
        SK3.set(" ");
      }
      //<< . SET SK4=$PIECE(YI(1),Y,4)
      mVar SK4 = m$.var("SK4");
      SK4.set(m$.Fnc.$piece(YI.var(1).get(),m$.var("Y").get(),4));
      //<< . IF SK4="" SET SK4=" "
      if (mOp.Equal(SK4.get(),"")) {
        SK4.set(" ");
      }
      //<< . KILL ^WWW122s(0,3,$$^WWWUMLAU(SK1,1),SK2,SK3,SK4,YFORM,YFELD)
      m$.var("^WWW122s",0,3,m$.fnc$("WWWUMLAU.main",SK1.get(),1),SK2.get(),SK3.get(),SK4.get(),m$.var("YFORM").get(),YFELD.get()).kill();
      //<< . KILL ^WWW122s(0,1,SK2,YFORM,YFELD)
      m$.var("^WWW122s",0,1,SK2.get(),m$.var("YFORM").get(),YFELD.get()).kill();
    }
    //<< 
    //<< IF YQ'="K" DO   ; D @YQ  ;VERTEILER ;distributor
    if (mOp.NotEqual(YQ.get(),"K")) {
      //<< . IF YQ="A" DO A
      if (mOp.Equal(YQ.get(),"A")) {
        m$.Cmd.Do("A");
      }
      //<< . IF YQ="B" DO B
      if (mOp.Equal(YQ.get(),"B")) {
        m$.Cmd.Do("B");
      }
      //<< . IF YQ="C" DO C
      if (mOp.Equal(YQ.get(),"C")) {
        m$.Cmd.Do("C");
      }
      //<< . IF YQ="D" DO D
      if (mOp.Equal(YQ.get(),"D")) {
        m$.Cmd.Do("D");
      }
      //<< . IF YQ="E" DO E
      if (mOp.Equal(YQ.get(),"E")) {
        m$.Cmd.Do("E");
      }
      //<< . IF YQ="G" DO G
      if (mOp.Equal(YQ.get(),"G")) {
        m$.Cmd.Do("G");
      }
      //<< . IF YQ="H" DO H
      if (mOp.Equal(YQ.get(),"H")) {
        m$.Cmd.Do("H");
      }
      //<< . IF YQ="L" DO L
      if (mOp.Equal(YQ.get(),"L")) {
        m$.Cmd.Do("L");
      }
      //<< . IF YQ="M" DO M
      if (mOp.Equal(YQ.get(),"M")) {
        m$.Cmd.Do("M");
      }
      //<< . IF YQ="O" DO O
      if (mOp.Equal(YQ.get(),"O")) {
        m$.Cmd.Do("O");
      }
      //<< . IF YQ="P" DO P
      if (mOp.Equal(YQ.get(),"P")) {
        m$.Cmd.Do("P");
      }
      //<< . IF YQ="R" DO R
      if (mOp.Equal(YQ.get(),"R")) {
        m$.Cmd.Do("R");
      }
      //<< . IF YQ="S" DO S
      if (mOp.Equal(YQ.get(),"S")) {
        m$.Cmd.Do("S");
      }
      //<< . IF YQ="T" DO T
      if (mOp.Equal(YQ.get(),"T")) {
        m$.Cmd.Do("T");
      }
      //<< . IF YQ="U" DO U
      if (mOp.Equal(YQ.get(),"U")) {
        m$.Cmd.Do("U");
      }
      //<< . IF YQ="V" DO V
      if (mOp.Equal(YQ.get(),"V")) {
        m$.Cmd.Do("V");
      }
      //<< . IF YQ="W" DO W
      if (mOp.Equal(YQ.get(),"W")) {
        m$.Cmd.Do("W");
      }
      //<< . IF YQ="X" DO X
      if (mOp.Equal(YQ.get(),"X")) {
        m$.Cmd.Do("X");
      }
    }
    //<< 
    //<< SET @YI=YI(1)   ;SUCHEN FELD ;seek field
    m$.indirectVar(YI.get()).set(YI.var(1).get());
    //<< 
    //<< IF YDAT'="P" DO
    if (mOp.NotEqual(YDAT.get(),"P")) {
      //<< . NEW SK1,SK2,SK3,SK4  ;TYBD;6,8,2004
      mVar SK1 = m$.var("SK1");
      mVar SK2 = m$.var("SK2");
      mVar SK3 = m$.var("SK3");
      mVar SK4 = m$.var("SK4");
      m$.newVarBlock(1,SK1,SK2,SK3,SK4);
      //<< . SET SK1=$$^WWWUMLAU(YFORM,1)
      SK1.set(m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1));
      //<< . SET SK2=$PIECE(YI(1),Y,60)
      SK2.set(m$.Fnc.$piece(YI.var(1).get(),m$.var("Y").get(),60));
      //<< . IF SK2="" SET SK2=" "
      if (mOp.Equal(SK2.get(),"")) {
        SK2.set(" ");
      }
      //<< . SET SK3=$PIECE(YI(1),Y,3)
      SK3.set(m$.Fnc.$piece(YI.var(1).get(),m$.var("Y").get(),3));
      //<< . IF SK3="" SET SK3=" "
      if (mOp.Equal(SK3.get(),"")) {
        SK3.set(" ");
      }
      //<< . SET SK4=$PIECE(YI(1),Y,4)
      SK4.set(m$.Fnc.$piece(YI.var(1).get(),m$.var("Y").get(),4));
      //<< . IF SK4="" SET SK4=" "
      if (mOp.Equal(SK4.get(),"")) {
        SK4.set(" ");
      }
      //<< . SET ^WWW122s(0,3,$$^WWWUMLAU(SK1,1),SK2,SK3,SK4,YFORM,YFELD)=""
      m$.var("^WWW122s",0,3,m$.fnc$("WWWUMLAU.main",SK1.get(),1),SK2.get(),SK3.get(),SK4.get(),m$.var("YFORM").get(),YFELD.get()).set("");
      //<< . SET ^WWW122s(0,1,SK2,YFORM,YFELD)=""
      m$.var("^WWW122s",0,1,SK2.get(),m$.var("YFORM").get(),YFELD.get()).set("");
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< IF YQ="K" DO   ;KILL
    if (mOp.Equal(YQ.get(),"K")) {
      //<< . NEW YFORM1
      mVar YFORM1 = m$.var("YFORM1");
      m$.newVarBlock(1,YFORM1);
      //<< . SET YFORM1=YFORM
      YFORM1.set(m$.var("YFORM").get());
      //<< . NEW YFORM
      mVar YFORM = m$.var("YFORM");
      m$.newVarBlock(1,YFORM);
      //<< . SET YFORM="WWW122"
      YFORM.set("WWW122");
      //<< . DO ^WWWKILL("WWW122",YFORM1_","_YFELD)
      m$.Cmd.Do("WWWKILL.main","WWW122",mOp.Concat(mOp.Concat(YFORM1.get(),","),YFELD.get()));
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< ; YI(1)     objWWW122
  //<< ;   D3      $$$WWW122RowPosition()
  //<< ;   D4      $$$WWW122ColumnPosition()
  //<< ;   D7      $$$WWW122AddNoOfSpaces()
  //<< ;   D24     $$$WWW122Module1()
  //<< ;   D36     $$$WWW122HorizontalOrientation()
  //<< ;   D38     $$$WWW122NewGroup()
  //<< ;   D60     $$$WWW122DisplayOnPageNumber()
  //<< ;   D70     $$$WWW122PositionCaptionToAnswer()
  //<< ;   D88     $$$WWW122ModifiedFieldLength()
  //<< 
  //<< A ;UP AUF 1 ;upon
  public void A() {
    //<< SET $PIECE(YI(1),Y,3)=1
    m$.pieceVar(m$.var("YI").var(1),m$.var("Y").get(),3).set(1);
    //<< QUIT
    return;
  }

  //<< 
  //<< X ;UP AUF 10 ;upon
  public void X() {
    //<< SET $PIECE(YI(1),Y,3)=10
    m$.pieceVar(m$.var("YI").var(1),m$.var("Y").get(),3).set(10);
    //<< QUIT
    return;
  }

  //<< 
  //<< U ;UP
  public void U() {
    //<< SET YI(3)=$PIECE(YI(1),Y,3)
    mVar YI = m$.var("YI");
    YI.var(3).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),3));
    //<< SET YI(3)=YI(3)-1
    YI.var(3).set(mOp.Subtract(YI.var(3).get(),1));
    //<< IF YI(3)<0 SET YI(3)=0
    if (mOp.Less(YI.var(3).get(),0)) {
      YI.var(3).set(0);
    }
    //<< SET $PIECE(YI(1),Y,3)=YI(3)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),3).set(YI.var(3).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< D ;DOWN
  public void D() {
    //<< SET YI(3)=$PIECE(YI(1),Y,3)
    mVar YI = m$.var("YI");
    YI.var(3).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),3));
    //<< SET YI(3)=YI(3)+1
    YI.var(3).set(mOp.Add(YI.var(3).get(),1));
    //<< IF YI(3)<0 SET YI(3)=0
    if (mOp.Less(YI.var(3).get(),0)) {
      YI.var(3).set(0);
    }
    //<< SET $PIECE(YI(1),Y,3)=YI(3)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),3).set(YI.var(3).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< R ;RECHTS ;on the right
  public void R() {
    //<< SET YI(4)=$PIECE(YI(1),Y,4)
    mVar YI = m$.var("YI");
    YI.var(4).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),4));
    //<< SET YI(4)=YI(4)+1
    YI.var(4).set(mOp.Add(YI.var(4).get(),1));
    //<< IF YI(4)<1 SET YI(4)=1
    if (mOp.Less(YI.var(4).get(),1)) {
      YI.var(4).set(1);
    }
    //<< SET $PIECE(YI(1),Y,4)=YI(4)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),4).set(YI.var(4).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< L ;LINKS ;on the left
  public void L() {
    //<< SET YI(4)=$PIECE(YI(1),Y,4)
    mVar YI = m$.var("YI");
    YI.var(4).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),4));
    //<< SET YI(4)=YI(4)-1
    YI.var(4).set(mOp.Subtract(YI.var(4).get(),1));
    //<< IF YI(4)<1 SET YI(4)=1
    if (mOp.Less(YI.var(4).get(),1)) {
      YI.var(4).set(1);
    }
    //<< SET $PIECE(YI(1),Y,4)=YI(4)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),4).set(YI.var(4).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< P ;SEITE PLUS ;side plus
  public void P() {
    //<< ;Q:$P(YI(1),Y,1)=""   ;NUR FÜR DATENFELDER
    //<< SET YI(60)=$PIECE(YI(1),Y,60)
    mVar YI = m$.var("YI");
    YI.var(60).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),60));
    //<< SET YI(60)=YI(60)+1
    YI.var(60).set(mOp.Add(YI.var(60).get(),1));
    //<< IF YI(60)>8 SET YI(60)=8
    if (mOp.Greater(YI.var(60).get(),8)) {
      YI.var(60).set(8);
    }
    //<< SET $PIECE(YI(1),Y,60)=YI(60)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),60).set(YI.var(60).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< M ;SEITE MINUS ;side minus
  public void M() {
    //<< SET YI(60)=$PIECE(YI(1),Y,60)
    mVar YI = m$.var("YI");
    YI.var(60).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),60));
    //<< SET YI(60)=YI(60)-1
    YI.var(60).set(mOp.Subtract(YI.var(60).get(),1));
    //<< IF YI(60)<1 SET YI(60)=1
    if (mOp.Less(YI.var(60).get(),1)) {
      YI.var(60).set(1);
    }
    //<< SET $PIECE(YI(1),Y,60)=YI(60)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),60).set(YI.var(60).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< S ;SPACE MEHR  ;more
  public void S() {
    //<< SET YI(7)=$PIECE(YI(1),Y,7)
    mVar YI = m$.var("YI");
    YI.var(7).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),7));
    //<< SET YI(7)=YI(7)+1
    YI.var(7).set(mOp.Add(YI.var(7).get(),1));
    //<< IF YI(7)>80 SET YI(7)=80
    if (mOp.Greater(YI.var(7).get(),80)) {
      YI.var(7).set(80);
    }
    //<< SET $PIECE(YI(1),Y,7)=YI(7)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),7).set(YI.var(7).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< B ;BLANKS RAUS
  public void B() {
    //<< SET YI(7)=$PIECE(YI(1),Y,7)
    mVar YI = m$.var("YI");
    YI.var(7).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),7));
    //<< SET YI(7)=YI(7)-1
    YI.var(7).set(mOp.Subtract(YI.var(7).get(),1));
    //<< ;IF YI(7)<0 S YI(7)=0
    //<< SET $PIECE(YI(1),Y,7)=YI(7)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),7).set(YI.var(7).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< W ;MEHR width  ;more
  public void W() {
    //<< SET YI(7)=$PIECE(YI(1),Y,88)
    mVar YI = m$.var("YI");
    YI.var(7).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),88));
    //<< IF YI(7)="" SET YI(7)=25
    if (mOp.Equal(YI.var(7).get(),"")) {
      YI.var(7).set(25);
    }
    //<< SET YI(7)=YI(7)+1
    YI.var(7).set(mOp.Add(YI.var(7).get(),1));
    //<< SET $PIECE(YI(1),Y,88)=YI(7)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),88).set(YI.var(7).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< C ;weniger width ;minus
  public void C() {
    //<< SET YI(7)=$PIECE(YI(1),Y,88)
    mVar YI = m$.var("YI");
    YI.var(7).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),88));
    //<< SET YI(7)=YI(7)-1
    YI.var(7).set(mOp.Subtract(YI.var(7).get(),1));
    //<< IF YI(7)<1 SET YI(7)=""
    if (mOp.Less(YI.var(7).get(),1)) {
      YI.var(7).set("");
    }
    //<< SET $PIECE(YI(1),Y,88)=YI(7)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),88).set(YI.var(7).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< H ;HORIZONTAL
  public void H() {
    //<< SET YI(36)=$PIECE(YI(1),Y,36)
    mVar YI = m$.var("YI");
    YI.var(36).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),36));
    //<< IF YI(36)=3  SET $PIECE(YI(1),Y,36)=1 QUIT
    if (mOp.Equal(YI.var(36).get(),3)) {
      m$.pieceVar(YI.var(1),m$.var("Y").get(),36).set(1);
      return;
    }
    //<< IF YI(36)'=3 SET $PIECE(YI(1),Y,36)=3 QUIT
    if (mOp.NotEqual(YI.var(36).get(),3)) {
      m$.pieceVar(YI.var(1),m$.var("Y").get(),36).set(3);
      return;
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< O ;ORIENTIERUNG
  public void O() {
    //<< SET YI(70)=$PIECE(YI(1),Y,70)
    mVar YI = m$.var("YI");
    YI.var(70).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),70));
    //<< SET YI(70)=YI(70)+1
    YI.var(70).set(mOp.Add(YI.var(70).get(),1));
    //<< IF YI(70)>4 SET YI(70)=0
    if (mOp.Greater(YI.var(70).get(),4)) {
      YI.var(70).set(0);
    }
    //<< SET $PIECE(YI(1),Y,70)=YI(70)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),70).set(YI.var(70).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< G ;GRUPPE ;group
  public void G() {
    //<< SET YI(38)=$PIECE(YI(1),Y,38)
    mVar YI = m$.var("YI");
    YI.var(38).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),38));
    //<< IF YI(38)=1  SET $PIECE(YI(1),Y,38)=0 QUIT
    if (mOp.Equal(YI.var(38).get(),1)) {
      m$.pieceVar(YI.var(1),m$.var("Y").get(),38).set(0);
      return;
    }
    //<< IF YI(38)'=1 SET $PIECE(YI(1),Y,38)=1 QUIT
    if (mOp.NotEqual(YI.var(38).get(),1)) {
      m$.pieceVar(YI.var(1),m$.var("Y").get(),38).set(1);
      return;
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< E ;MODUL EK ;module Planned Cost
  public void E() {
    //<< SET YI(24)=$PIECE(YI(1),Y,24)
    mVar YI = m$.var("YI");
    YI.var(24).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),24));
    //<< IF '$FIND(YI(24),"EK") DO
    if (mOp.Not(m$.Fnc.$find(YI.var(24).get(),"EK"))) {
      //<< . IF YI(24)'=""  SET YI(24)=YI(24)_";"
      if (mOp.NotEqual(YI.var(24).get(),"")) {
        YI.var(24).set(mOp.Concat(YI.var(24).get(),";"));
      }
      //<< . SET YI(24)=YI(24)_"EK"
      YI.var(24).set(mOp.Concat(YI.var(24).get(),"EK"));
    }
    //<< 
    //<< SET $PIECE(YI(1),Y,24)=YI(24)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),24).set(YI.var(24).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< V ;MODUL VK ;module Sale
  public void V() {
    //<< SET YI(24)=$PIECE(YI(1),Y,24)
    mVar YI = m$.var("YI");
    YI.var(24).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),24));
    //<< IF '$FIND(YI(24),"VK") DO
    if (mOp.Not(m$.Fnc.$find(YI.var(24).get(),"VK"))) {
      //<< . IF YI(24)'=""  SET YI(24)=YI(24)_";"
      if (mOp.NotEqual(YI.var(24).get(),"")) {
        YI.var(24).set(mOp.Concat(YI.var(24).get(),";"));
      }
      //<< . SET YI(24)=YI(24)_"VK"
      YI.var(24).set(mOp.Concat(YI.var(24).get(),"VK"));
    }
    //<< 
    //<< SET $PIECE(YI(1),Y,24)=YI(24)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),24).set(YI.var(24).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< T ;TAB ORIENTIERUNG
  public void T() {
    //<< SET YI(70)=$PIECE(YI(1),Y,70)
    mVar YI = m$.var("YI");
    YI.var(70).set(m$.Fnc.$piece(m$.var("YI").var(1).get(),m$.var("Y").get(),70));
    //<< SET YI(70)=YI(70)+1
    YI.var(70).set(mOp.Add(YI.var(70).get(),1));
    //<< IF YI(70)=1 SET YI(70)=2 SET $PIECE(YI(1),Y,7)=4
    if (mOp.Equal(YI.var(70).get(),1)) {
      YI.var(70).set(2);
      m$.pieceVar(YI.var(1),m$.var("Y").get(),7).set(4);
    }
    //<< IF YI(70)>4 SET YI(70)=0
    if (mOp.Greater(YI.var(70).get(),4)) {
      YI.var(70).set(0);
    }
    //<< SET $PIECE(YI(1),Y,70)=YI(70)
    m$.pieceVar(YI.var(1),m$.var("Y").get(),70).set(YI.var(70).get());
    //<< QUIT
    return;
  }

//<< 
//<< 
}
