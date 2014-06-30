//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTVERKHID
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 18:46:31
//*****************************************************************************

import mLibrary.*;


//<< INARTVERKHID(PREIS) ;INARTVERKHID;BEC;HIDDENSETZTEN VON VERKAUFSPREIS;11.06.03
public class INARTVERKHID extends mClass {

  public Object main(Object ... _p) {
    mVar PREIS = m$.newVarRef("PREIS",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _INARTVERKHID(PREIS);
  }

  public Object _INARTVERKHID(Object ... _p) {
    mVar PREIS = m$.newVarRef("PREIS",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      HIDDENSETZTEN VON VERKAUFSPREIS
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
    //<< ;| BEC  11.06.03
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< NEW PRUEF,YFELD,WG,KALK
    mVar PRUEF = m$.var("PRUEF");
    mVar YFELD = m$.var("YFELD");
    mVar WG = m$.var("WG");
    mVar KALK = m$.var("KALK");
    m$.newVar(PRUEF,YFELD,WG,KALK);
    //<< SET PREIS=$GET(PREIS)                             ;WELCHER PREIS:1-4 ;who
    PREIS.set(m$.Fnc.$get(PREIS));
    //<< SET PRUEF=0
    PRUEF.set(0);
    //<< IF $GET(YKEY)'="" IF $GET(YUSER)'="" IF $GET(YFORM)'="" IF PREIS'="" DO
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY")),"")) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
          if (mOp.NotEqual(PREIS.get(),"")) {
            do {
              //<< . SET PREIS=24+PREIS                             ;FÜR PREIS1 DATENFELD 25 ;to data item
              PREIS.set(mOp.Add(24,PREIS.get()));
              //<< . SET YFELD=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"D",1))
              YFELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1)));
              //<< . SET WG=$PIECE(YFELD,Y,30)
              WG.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),30));
              //<< . IF WG="" SET WG=$PIECE($GET(^INVORG(YM,YM,1)),Y,13)
              if (mOp.Equal(WG.get(),"")) {
                WG.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)),m$.var("Y").get(),13));
              }
              //<< . ;IF '$D(^INKALK(YM,YLOCATION,WG,1)) IF '$D(^INKALKART(YM,YLOCATION,YKEY)) SET WG=$P($G(^INVORG(YM,YM,1)),Y,13)  ;STANDARTWARENGRUPPE, WENN KEINE VORGABEN VORHANDEN
              //<< . IF WG'="" IF '$DATA(^INKALK(YM,YLOCATION,WG,1)) IF '$DATA(^INKALKART(YM,YLOCATION,YKEY)) SET WG=$PIECE($GET(^INVORG(YM,YM,1)),Y,13)  ;BEC;08.06.04;25866
              if (mOp.NotEqual(WG.get(),"")) {
                if (mOp.Not(m$.Fnc.$data(m$.var("^INKALK",m$.var("YM").get(),m$.var("YLOCATION").get(),WG.get(),1)))) {
                  if (mOp.Not(m$.Fnc.$data(m$.var("^INKALKART",m$.var("YM").get(),m$.var("YLOCATION").get(),m$.var("YKEY").get())))) {
                    WG.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)),m$.var("Y").get(),13));
                  }
                }
              }
              //<< . IF WG'="" DO
              if (mOp.NotEqual(WG.get(),"")) {
                do {
                  //<< . . SET KALK=$GET(^INKALK(YM,YLOCATION,WG,1))
                  KALK.set(m$.Fnc.$get(m$.var("^INKALK",m$.var("YM").get(),m$.var("YLOCATION").get(),WG.get(),1)));
                  //<< . . IF $PIECE(KALK,Y,PREIS)=1 SET PRUEF=1
                  if (mOp.Equal(m$.Fnc.$piece(KALK.get(),m$.var("Y").get(),PREIS.get()),1)) {
                    PRUEF.set(1);
                  }
                  //<< . . QUIT
                  break;
                } while (false);
              }
              //<< . IF $DATA(^INKALKART(YM,YLOCATION,YKEY)) DO
              if (mOp.Logical(m$.Fnc.$data(m$.var("^INKALKART",m$.var("YM").get(),m$.var("YLOCATION").get(),m$.var("YKEY").get())))) {
                do {
                  //<< . . SET KALK=$GET(^INKALKART(YM,YLOCATION,YKEY,1))
                  KALK.set(m$.Fnc.$get(m$.var("^INKALKART",m$.var("YM").get(),m$.var("YLOCATION").get(),m$.var("YKEY").get(),1)));
                  //<< . . IF $PIECE(KALK,Y,PREIS)=1 SET PRUEF=1
                  if (mOp.Equal(m$.Fnc.$piece(KALK.get(),m$.var("Y").get(),PREIS.get()),1)) {
                    PRUEF.set(1);
                  }
                  //<< . . IF +$PIECE(KALK,Y,PREIS)=0 SET PRUEF=0
                  if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(KALK.get(),m$.var("Y").get(),PREIS.get())),0)) {
                    PRUEF.set(0);
                  }
                  //<< . . QUIT
                  break;
                } while (false);
              }
              //<< . QUIT
              break;
            } while (false);
          }
        }
      }
    }
    //<< QUIT PRUEF
    return PRUEF.get();
  }

//<< 
}
