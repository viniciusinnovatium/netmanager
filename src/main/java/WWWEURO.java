//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWEURO
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 18:35:10
//*****************************************************************************

import mLibrary.*;


//<< WWWEURO(SIZE,WHR,RL) ;WWWEURO;DT;ANZEIGEN DES WAEHRUNG;10.10.1998
public class WWWEURO extends mClass {

  public Object main(Object ... _p) {
    mVar SIZE = m$.newVarRef("SIZE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar WHR = m$.newVarRef("WHR",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar RL = m$.newVarRef("RL",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return _WWWEURO(SIZE,WHR,RL);
  }

  public Object _WWWEURO(Object ... _p) {
    mVar SIZE = m$.newVarRef("SIZE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar WHR = m$.newVarRef("WHR",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar RL = m$.newVarRef("RL",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      ANZEIGEN DES WAEHRUNG
    //<< ;|
    //<< ;| Inputs :
    //<< ;|
    //<< ;|
    //<< ;| ByRef :
    //<< ;|
    //<< ;|
    //<< ;| Returns :
    //<< ;|
    //<< ;|
    //<< ;| History :
    //<< ;|
    //<< ;| DT   10.10.1998
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< ;SIZE= GRÖßE ;magnitude
    //<< ;WHR=WÄHRUNGSZEICHEN
    //<< ;RL R-WENN DARSTELLUNG RECHTS ; L-WENN DARSTELLUNG LINKS
    //<< NEW A,WHR1
    mVar A = m$.var("A");
    mVar WHR1 = m$.var("WHR1");
    m$.newVar(A,WHR1);
    //<< IF +$HOROLOG>58804 IF $GET(WHR)="" SET WHR="EUR"
    if (mOp.Greater(mOp.Positive(m$.Fnc.$horolog()),58804)) {
      if (mOp.Equal(m$.Fnc.$get(WHR),"")) {
        WHR.set("EUR");
      }
    }
    //<< IF '$DATA(SIZE) SET SIZE=2
    if (mOp.Not(m$.Fnc.$data(SIZE))) {
      SIZE.set(2);
    }
    //<< IF +SIZE=0 SET SIZE=2
    if (mOp.Equal(mOp.Positive(SIZE.get()),0)) {
      SIZE.set(2);
    }
    //<< IF SIZE>7 SET SIZE=7
    if (mOp.Greater(SIZE.get(),7)) {
      SIZE.set(7);
    }
    //<< SET RL=$GET(RL)
    RL.set(m$.Fnc.$get(RL));
    //<< ;SET WHR1=$GET(^WWWWAE(YM,WHR,1))
    //<< SET WHR1=$GET(^WWWWAE(0,WHR,1))    ;BEC;25866;07.06.04;DA ZENTRALE DATEI
    WHR1.set(m$.Fnc.$get(m$.var("^WWWWAE",0,WHR.get(),1)));
    //<< IF RL'="R" QUIT:$PIECE(WHR1,Y,4)=1  ;SOLLTE LINKS ;on the left
    if (mOp.NotEqual(RL.get(),"R")) {
      if (mOp.Equal(m$.Fnc.$piece(WHR1.get(),m$.var("Y").get(),4),1)) {
        return null;
      }
    }
    //<< IF RL="R" QUIT:$PIECE(WHR1,Y,4)'=1  ;SOLLTE RECHTS ;on the right
    if (mOp.Equal(RL.get(),"R")) {
      if (mOp.NotEqual(m$.Fnc.$piece(WHR1.get(),m$.var("Y").get(),4),1)) {
        return null;
      }
    }
    //<< WRITE "<FONT SIZE="_SIZE_">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=",SIZE.get()),">"));
    //<< W $$^WWWWHR(WHR)
    m$.Cmd.Write(m$.fnc$("WWWWHR.main",WHR.get()));
    //<< WRITE "</FONT>"
    m$.Cmd.Write("</FONT>");
    //<< Q
    return null;
  }

//<< 
}
