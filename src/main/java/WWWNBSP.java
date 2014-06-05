//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWNBSP
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:38
//*****************************************************************************

import mLibrary.*;


//<< WWWNBSP(X) ; WWWNBSP;DT;SPACES IN NBSP UMWANDELN;17.02.1999
public class WWWNBSP extends mClass {

  public Object main(Object ... _p) {
    mVar X = m$.newVarRef("X",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWNBSP(X);
  }

  public Object _WWWNBSP(Object ... _p) {
    mVar X = m$.newVarRef("X",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      SPACES IN NBSP UMWANDELN
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
    //<< ;| DT   17.02.1999
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< ;quit $replace(X," ","&nbsp")  ;This would be about 10 times faster.
    //<< NEW K
    mVar K = m$.var("K");
    m$.newVar(K);
    //<< QUIT:X="" X
    if (mOp.Equal(X.get(),"")) {
      return X.get();
    }
    //<< FOR  QUIT:'$FIND(X,$CHAR(32))  IF $FIND(X,$CHAR(32)) SET K=$FIND(X,$CHAR(32)),X=$EXTRACT(X,1,K-2)_"&nbsp;"_$EXTRACT(X,K,$LENGTH(X))
    for (;true;) {
      if (mOp.Not(m$.Fnc.$find(X.get(),m$.Fnc.$char(32)))) {
        break;
      }
      if (mOp.Logical(m$.Fnc.$find(X.get(),m$.Fnc.$char(32)))) {
        K.set(m$.Fnc.$find(X.get(),m$.Fnc.$char(32)));
        X.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(X.get(),1,mOp.Subtract(K.get(),2)),"&nbsp;"),m$.Fnc.$extract(X.get(),K.get(),m$.Fnc.$length(X.get()))));
      }
    }
    //<< QUIT X
    return X.get();
  }

//<< 
}
