//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWTRANSLATE
//** Innovatium Systems - Code Converter - v1.24
//** 2014-05-21 21:10:01
//*****************************************************************************

import mLibrary.*;


//<< WWWTRANSLATE(YTXT,YOUT,YIN) ;WWWTRANSLATE;FIS;WIE $TRANSLATE, ABER MIT MEHREREN ZEICHEN;25.06.2003
public class WWWTRANSLATE extends mClass {

  public Object main(Object ... _p) {
    mVar YTXT = m$.newVarRef("YTXT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YOUT = m$.newVarRef("YOUT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YIN = m$.newVarRef("YIN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return _WWWTRANSLATE(YTXT,YOUT,YIN);
  }

  public Object _WWWTRANSLATE(Object ... _p) {
    mVar YTXT = m$.newVarRef("YTXT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YOUT = m$.newVarRef("YOUT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YIN = m$.newVarRef("YIN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      WIE $TRANSLATE, ABER MIT MEHREREN ZEICHEN
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
    //<< ;| FIS  25.06.2003
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< ;YTXT=TEXT
    //<< ;YOUT=WAS HERAUS ;away
    //<< ;YIN=WAS HEREIN
    //<< ;BEISPIEL: W $$^WWWTRANSLATE("ZEILE1|ZEILE2","|","<BR>")
    //<< SET YTXT=$GET(YTXT)
    YTXT.set(m$.Fnc.$get(YTXT));
    //<< IF YTXT="" QUIT YTXT
    if (mOp.Equal(YTXT.get(),"")) {
      return YTXT.get();
    }
    //<< SET YOUT=$GET(YOUT)
    YOUT.set(m$.Fnc.$get(YOUT));
    //<< IF YOUT="" QUIT YTXT
    if (mOp.Equal(YOUT.get(),"")) {
      return YTXT.get();
    }
    //<< SET YIN=$GET(YIN)
    YIN.set(m$.Fnc.$get(YIN));
    //<< IF $EXTRACT(YOUT,2)="" IF YIN="" QUIT $TRANSLATE(YTXT,YOUT)
    if (mOp.Equal(m$.Fnc.$extract(YOUT.get(),2),"")) {
      if (mOp.Equal(YIN.get(),"")) {
        return m$.Fnc.$translate(YTXT.get(),YOUT.get());
      }
    }
    //<< IF $EXTRACT(YOUT,2)="" IF $EXTRACT(YIN,2)="" QUIT $TRANSLATE(YTXT,YOUT,YIN)
    if (mOp.Equal(m$.Fnc.$extract(YOUT.get(),2),"")) {
      if (mOp.Equal(m$.Fnc.$extract(YIN.get(),2),"")) {
        return m$.Fnc.$translate(YTXT.get(),YOUT.get(),YIN.get());
      }
    }
    //<< ;LÖSCHEN ;Delete
    //<< FOR  QUIT:'$FIND(YTXT,YOUT)  DO
    for (;true;) {
      if (mOp.Not(m$.Fnc.$find(YTXT.get(),YOUT.get()))) {
        break;
      }
      do {
        //<< . NEW YCUT
        mVar YCUT = m$.var("YCUT");
        m$.newVar(YCUT);
        //<< . SET YCUT=$FIND(YTXT,YOUT)
        YCUT.set(m$.Fnc.$find(YTXT.get(),YOUT.get()));
        //<< . SET YTXT=$EXTRACT(YTXT,1,YCUT-1-$LENGTH(YOUT))_$C(255)_$EXTRACT(YTXT,YCUT,$LENGTH(YTXT))  ;EINFÜGEN PLATZHALTER ;interpolate
        YTXT.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(YTXT.get(),1,mOp.Subtract(mOp.Subtract(YCUT.get(),1),m$.Fnc.$length(YOUT.get()))),m$.Fnc.$char(255)),m$.Fnc.$extract(YTXT.get(),YCUT.get(),m$.Fnc.$length(YTXT.get()))));
        //<< . QUIT
        break;
      } while (false);
    }
    //<< ;EINFÜGEN ;interpolate
    //<< FOR  QUIT:'$FIND(YTXT,$CHAR(255))  DO
    for (;true;) {
      if (mOp.Not(m$.Fnc.$find(YTXT.get(),m$.Fnc.$char(255)))) {
        break;
      }
      do {
        //<< . NEW YCUT,YLENGTH
        mVar YCUT = m$.var("YCUT");
        mVar YLENGTH = m$.var("YLENGTH");
        m$.newVar(YCUT,YLENGTH);
        //<< . SET YCUT=$FIND(YTXT,$CHAR(255))
        YCUT.set(m$.Fnc.$find(YTXT.get(),m$.Fnc.$char(255)));
        //<< . SET YLENGTH(1)=$LENGTH(YTXT)  ;TYBD;16.05.2004;
        YLENGTH.var(1).set(m$.Fnc.$length(YTXT.get()));
        //<< . SET YLENGTH=$LENGTH($EXTRACT(YTXT,1,YCUT-2))+$LENGTH(YIN)+$LENGTH($EXTRACT(YTXT,YCUT,$LENGTH(YTXT)))
        YLENGTH.set(mOp.Add(mOp.Add(m$.Fnc.$length(m$.Fnc.$extract(YTXT.get(),1,mOp.Subtract(YCUT.get(),2))),m$.Fnc.$length(YIN.get())),m$.Fnc.$length(m$.Fnc.$extract(YTXT.get(),YCUT.get(),m$.Fnc.$length(YTXT.get())))));
        //<< . IF YLENGTH>32000 SET YLENGTH(1)=YLENGTH(1)-(YLENGTH-32000)  ;TYBD;16.05.2004;
        if (mOp.Greater(YLENGTH.get(),32000)) {
          YLENGTH.var(1).set(mOp.Subtract(YLENGTH.var(1).get(),(mOp.Subtract(YLENGTH.get(),32000))));
        }
        //<< . ;SET YTXT=$EXTRACT(YTXT,1,YCUT-2)_YIN_$EXTRACT(YTXT,YCUT,$LENGTH(YTXT))
        //<< . SET YTXT=$EXTRACT(YTXT,1,YCUT-2)_YIN_$EXTRACT(YTXT,YCUT,YLENGTH(1))   ;TYBD;16.05.2004 WEGEN MAX STRING ;quibble
        YTXT.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(YTXT.get(),1,mOp.Subtract(YCUT.get(),2)),YIN.get()),m$.Fnc.$extract(YTXT.get(),YCUT.get(),YLENGTH.var(1).get())));
        //<< . QUIT
        break;
      } while (false);
    }
    //<< QUIT YTXT
    return YTXT.get();
  }

}
