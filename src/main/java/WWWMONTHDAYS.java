//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMONTHDAYS
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:44
//*****************************************************************************

import mLibrary.*;


//<< WWWMONTHDAYS(A,B)
public class WWWMONTHDAYS extends mClass {

  public Object main(Object ... _p) {
    mVar A = m$.newVarRef("A",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar B = m$.newVarRef("B",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _WWWMONTHDAYS(A,B);
  }

  public Object _WWWMONTHDAYS(Object ... _p) {
    mVar A = m$.newVarRef("A",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar B = m$.newVarRef("B",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANZAHL TAGE IM NÄCHSTEN MONAT
    //<< ;
    //<< ; Inputs :
    //<< ;       A = $H FORMAT
    //<< ;       B = PLUS ODER MINUS MONATSPRÜFUNG  ;MAX 1 WEITER ! ;Or minus ulterior
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ;
    //<< ; 02.02.2001    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW RETURN,MONAT,JAHR
    mVar RETURN = m$.var("RETURN");
    mVar MONAT = m$.var("MONAT");
    mVar JAHR = m$.var("JAHR");
    m$.newVar(RETURN,MONAT,JAHR);
    //<< 
    //<< SET A = $GET(A)   IF A="" SET A = +$HOROLOG
    A.set(m$.Fnc.$get(A));
    if (mOp.Equal(A.get(),"")) {
      A.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< SET B = $GET(B)
    B.set(m$.Fnc.$get(B));
    //<< 
    //<< SET RETURN = 30
    RETURN.set(30);
    //<< 
    //<< SET MONAT = $$^WWWMONTH(A)+B
    MONAT.set(mOp.Add(m$.fnc$("WWWMONTH.main",A.get()),B.get()));
    //<< SET JAHR  = $$^WWWYEAR(A)
    JAHR.set(m$.fnc$("WWWYEAR.main",A.get()));
    //<< IF MONAT>12 SET MONAT=1 SET JAHR=JAHR+1
    if (mOp.Greater(MONAT.get(),12)) {
      MONAT.set(1);
      JAHR.set(mOp.Add(JAHR.get(),1));
    }
    //<< IF MONAT<1  SET MONAT=1 SET JAHR=JAHR-1
    if (mOp.Less(MONAT.get(),1)) {
      MONAT.set(1);
      JAHR.set(mOp.Subtract(JAHR.get(),1));
    }
    //<< SET RETURN=$PIECE("31,28,31,30,31,30,31,31,30,31,30,31",",",MONAT)
    RETURN.set(m$.Fnc.$piece("31,28,31,30,31,30,31,31,30,31,30,31",",",MONAT.get()));
    //<< IF MONAT=2 IF JAHR#4=0 IF JAHR#100'=0 SET RETURN=29  ;PRÜFEN SCHALTJAHR;FIS;06.10.03 ;check leap-year
    if (mOp.Equal(MONAT.get(),2)) {
      if (mOp.Equal(mOp.Modulus(JAHR.get(),4),0)) {
        if (mOp.NotEqual(mOp.Modulus(JAHR.get(),100),0)) {
          RETURN.set(29);
        }
      }
    }
    //<< QUIT RETURN
    return RETURN.get();
  }

//<< 
}
