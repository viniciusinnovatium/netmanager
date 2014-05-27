//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSCRAD
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:15
//*****************************************************************************

import mLibrary.*;


//<< WWWSCRAD
public class WWWSCRAD extends mClass {

  public void main() {
    _WWWSCRAD();
  }

  public void _WWWSCRAD() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SCREEN MOVE AUSWERTUNG CUSTOMIZING
    //<< ;   DIESES PROGRAMM WERTET DIE EINGABEN AUS DEM SCREEN EDIT AUS ;this programme who out of out of
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
    //<< ; 24-Aug-2007   GRF     Doco; ||
    //<< ; 10.03.2004    FIS
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YI,YQ,YDAT,YFELD
    mVar YI = m$.var("YI");
    mVar YQ = m$.var("YQ");
    mVar YDAT = m$.var("YDAT");
    mVar YFELD = m$.var("YFELD");
    m$.newVar(YI,YQ,YDAT,YFELD);
    //<< 
    //<< SET YDAT  = $EXTRACT($PIECE(YSCR,"-",1),5,99)
    YDAT.set(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSCR").get(),"-",1),5,99));
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
    //<< QUIT:YQ=""
    if (mOp.Equal(YQ.get(),"")) {
      return;
    }
    //<< 
    //<< SET YI="^WWW122(0,"_""""_YFORM_""""_","_YFELD_",1)"
    YI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW122(0,","\""),m$.var("YFORM").get()),"\""),","),YFELD.get()),",1)"));
    //<< SET YI(1)=$GET(@YI)  ;SUCHEN FELD ;seek field
    YI.var(1).set(m$.Fnc.$get(m$.indirectVar(YI.get())));
    //<< 
    //<< QUIT:YI(1)=""
    if (mOp.Equal(YI.var(1).get(),"")) {
      return;
    }
    //<< 
    //<< SET YII="^WWW122D(0,"_""""_YFORM_""""_","_YFELD_","_""""_YM_""""_",1)"
    mVar YII = m$.var("YII");
    YII.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW122D(0,","\""),m$.var("YFORM").get()),"\""),","),YFELD.get()),","),"\""),m$.var("YM").get()),"\""),",1)"));
    //<< SET YII(1)=$GET(@YII)  ;SUCHEN FELD ;seek field
    YII.var(1).set(m$.Fnc.$get(m$.indirectVar(YII.get())));
    //<< 
    //<< IF (YQ="P") || (YQ="M") IF $PIECE(YII(1),Y,60)="" SET $PIECE(YII(1),Y,60)=$PIECE(YI(1),Y,60) ;SEITE ;side
    if ((mOp.Equal(YQ.get(),"P")) || (mOp.Equal(YQ.get(),"M"))) {
      if (mOp.Equal(m$.Fnc.$piece(YII.var(1).get(),m$.var("Y").get(),60),"")) {
        m$.pieceVar(YII.var(1),m$.var("Y").get(),60).set(m$.Fnc.$piece(YI.var(1).get(),m$.var("Y").get(),60));
      }
    }
    //<< IF (YQ="U") || (YQ="D") IF $PIECE(YII(1),Y,61)="" SET $PIECE(YII(1),Y,61)=$PIECE(YI(1),Y,3)  ;ZEILE
    if ((mOp.Equal(YQ.get(),"U")) || (mOp.Equal(YQ.get(),"D"))) {
      if (mOp.Equal(m$.Fnc.$piece(YII.var(1).get(),m$.var("Y").get(),61),"")) {
        m$.pieceVar(YII.var(1),m$.var("Y").get(),61).set(m$.Fnc.$piece(YI.var(1).get(),m$.var("Y").get(),3));
      }
    }
    //<< IF (YQ="L") || (YQ="R") IF $PIECE(YII(1),Y,62)="" SET $PIECE(YII(1),Y,62)=$PIECE(YI(1),Y,4)  ;POSITION
    if ((mOp.Equal(YQ.get(),"L")) || (mOp.Equal(YQ.get(),"R"))) {
      if (mOp.Equal(m$.Fnc.$piece(YII.var(1).get(),m$.var("Y").get(),62),"")) {
        m$.pieceVar(YII.var(1),m$.var("Y").get(),62).set(m$.Fnc.$piece(YI.var(1).get(),m$.var("Y").get(),4));
      }
    }
    //<< IF YQ="G" IF $PIECE(YII(1),Y,38)="" SET $PIECE(YII(1),Y,38)=$PIECE(YI(1),Y,38)               ;GRUPPE ;group
    if (mOp.Equal(YQ.get(),"G")) {
      if (mOp.Equal(m$.Fnc.$piece(YII.var(1).get(),m$.var("Y").get(),38),"")) {
        m$.pieceVar(YII.var(1),m$.var("Y").get(),38).set(m$.Fnc.$piece(YI.var(1).get(),m$.var("Y").get(),38));
      }
    }
    //<< IF YQ="D" DO D
    if (mOp.Equal(YQ.get(),"D")) {
      m$.Cmd.Do("D");
    }
    //<< IF YQ="G" DO G
    if (mOp.Equal(YQ.get(),"G")) {
      m$.Cmd.Do("G");
    }
    //<< IF YQ="L" DO L
    if (mOp.Equal(YQ.get(),"L")) {
      m$.Cmd.Do("L");
    }
    //<< IF YQ="M" DO M
    if (mOp.Equal(YQ.get(),"M")) {
      m$.Cmd.Do("M");
    }
    //<< IF YQ="P" DO P
    if (mOp.Equal(YQ.get(),"P")) {
      m$.Cmd.Do("P");
    }
    //<< IF YQ="R" DO R
    if (mOp.Equal(YQ.get(),"R")) {
      m$.Cmd.Do("R");
    }
    //<< IF YQ="U" DO U
    if (mOp.Equal(YQ.get(),"U")) {
      m$.Cmd.Do("U");
    }
    //<< IF YQ="H" DO H
    if (mOp.Equal(YQ.get(),"H")) {
      m$.Cmd.Do("H");
    }
    //<< SET @YII=YII(1)
    m$.indirectVar(YII.get()).set(YII.var(1).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< U ;UP
  public void U() {
    //<< SET YI(61)=$PIECE(YII(1),Y,61)
    mVar YI = m$.var("YI");
    YI.var(61).set(m$.Fnc.$piece(m$.var("YII").var(1).get(),m$.var("Y").get(),61));
    //<< SET YI(61)=YI(61)-1
    YI.var(61).set(mOp.Subtract(YI.var(61).get(),1));
    //<< IF YI(61)<0 SET YI(61)=0
    if (mOp.Less(YI.var(61).get(),0)) {
      YI.var(61).set(0);
    }
    //<< SET $PIECE(YII(1),Y,61)=YI(61)
    m$.pieceVar(m$.var("YII").var(1),m$.var("Y").get(),61).set(YI.var(61).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< D ;DOWN
  public void D() {
    //<< SET YI(61)=$PIECE(YII(1),Y,61)
    mVar YI = m$.var("YI");
    YI.var(61).set(m$.Fnc.$piece(m$.var("YII").var(1).get(),m$.var("Y").get(),61));
    //<< SET YI(61)=YI(61)+1
    YI.var(61).set(mOp.Add(YI.var(61).get(),1));
    //<< IF YI(61)<0 SET YI(61)=0
    if (mOp.Less(YI.var(61).get(),0)) {
      YI.var(61).set(0);
    }
    //<< SET $PIECE(YII(1),Y,61)=YI(61)
    m$.pieceVar(m$.var("YII").var(1),m$.var("Y").get(),61).set(YI.var(61).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< R ;RECHTS ;on the right
  public void R() {
    //<< SET YI(62)=$PIECE(YII(1),Y,62)
    mVar YI = m$.var("YI");
    YI.var(62).set(m$.Fnc.$piece(m$.var("YII").var(1).get(),m$.var("Y").get(),62));
    //<< SET YI(62)=YI(62)+1
    YI.var(62).set(mOp.Add(YI.var(62).get(),1));
    //<< IF YI(62)<1 SET YI(62)=1
    if (mOp.Less(YI.var(62).get(),1)) {
      YI.var(62).set(1);
    }
    //<< SET $PIECE(YII(1),Y,62)=YI(62)
    m$.pieceVar(m$.var("YII").var(1),m$.var("Y").get(),62).set(YI.var(62).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< L ;LINKS ;on the left
  public void L() {
    //<< SET YI(62)=$PIECE(YII(1),Y,62)
    mVar YI = m$.var("YI");
    YI.var(62).set(m$.Fnc.$piece(m$.var("YII").var(1).get(),m$.var("Y").get(),62));
    //<< SET YI(62)=YI(62)-1
    YI.var(62).set(mOp.Subtract(YI.var(62).get(),1));
    //<< IF YI(62)<1 SET YI(62)=1
    if (mOp.Less(YI.var(62).get(),1)) {
      YI.var(62).set(1);
    }
    //<< SET $PIECE(YII(1),Y,62)=YI(62)
    m$.pieceVar(m$.var("YII").var(1),m$.var("Y").get(),62).set(YI.var(62).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< P ;SEITE PLUS ;side plus
  public void P() {
    //<< SET YI(60)=$PIECE(YII(1),Y,60)
    mVar YI = m$.var("YI");
    YI.var(60).set(m$.Fnc.$piece(m$.var("YII").var(1).get(),m$.var("Y").get(),60));
    //<< SET YI(60)=YI(60)+1
    YI.var(60).set(mOp.Add(YI.var(60).get(),1));
    //<< IF YI(60)>8 SET YI(60)=8
    if (mOp.Greater(YI.var(60).get(),8)) {
      YI.var(60).set(8);
    }
    //<< SET $PIECE(YII(1),Y,60)=YI(60)
    m$.pieceVar(m$.var("YII").var(1),m$.var("Y").get(),60).set(YI.var(60).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< M ;SEITE MINUS ;side minus
  public void M() {
    //<< SET YI(60)=$PIECE(YII(1),Y,60)
    mVar YI = m$.var("YI");
    YI.var(60).set(m$.Fnc.$piece(m$.var("YII").var(1).get(),m$.var("Y").get(),60));
    //<< SET YI(60)=YI(60)-1
    YI.var(60).set(mOp.Subtract(YI.var(60).get(),1));
    //<< IF YI(60)<1 SET YI(60)=1
    if (mOp.Less(YI.var(60).get(),1)) {
      YI.var(60).set(1);
    }
    //<< SET $PIECE(YII(1),Y,60)=YI(60)
    m$.pieceVar(m$.var("YII").var(1),m$.var("Y").get(),60).set(YI.var(60).get());
    //<< QUIT
    return;
  }

  //<< 
  //<< G ;GRUPPE ;group
  public void G() {
    //<< SET YI(38)=$PIECE(YII(1),Y,38)
    mVar YI = m$.var("YI");
    YI.var(38).set(m$.Fnc.$piece(m$.var("YII").var(1).get(),m$.var("Y").get(),38));
    //<< IF YI(38)=1  SET $PIECE(YII(1),Y,38)=0 QUIT
    if (mOp.Equal(YI.var(38).get(),1)) {
      m$.pieceVar(m$.var("YII").var(1),m$.var("Y").get(),38).set(0);
      return;
    }
    //<< IF YI(38)'=1 SET $PIECE(YII(1),Y,38)=1 QUIT
    if (mOp.NotEqual(YI.var(38).get(),1)) {
      m$.pieceVar(m$.var("YII").var(1),m$.var("Y").get(),38).set(1);
      return;
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< H ;HIDDEN
  public void H() {
    //<< SET $PIECE(YII(1),Y,13)=1  ;NICHT ANZEIGEN ;Not display
    m$.pieceVar(m$.var("YII").var(1),m$.var("Y").get(),13).set(1);
    //<< QUIT
    return;
  }

//<< 
}
