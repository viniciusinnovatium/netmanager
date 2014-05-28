//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWUML
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:58
//*****************************************************************************

import mLibrary.*;


//<< WWWUML(X,YX1) ;WWWUML;DT;UMLAUTE INTERNET;28.10;1996
public class WWWUML extends mClass {

  public Object main(Object ... _p) {
    mVar X = m$.newVarRef("X",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YX1 = m$.newVarRef("YX1",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _WWWUML(X,YX1);
  }

  public Object _WWWUML(Object ... _p) {
    mVar X = m$.newVarRef("X",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YX1 = m$.newVarRef("YX1",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      UMLAUTE INTERNET
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
    //<< ;|  27-May-2005     RobertW     SR12056: Performance improvement with in memory globals
    //<< ;| DT   28.10
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< ;YX1=1 BEI DER UMSETZUNG WERDEN DIE ZEICHEN <> NICHT UMGESETZ (HTML AUSGABE AUF DEVICE) ;next to the transferral will who sign Not expenses upon
    //<< ;YX1=2 BEI DER UMSETZUNG WERDEN NUR DIE ZEICHEN <>  UMGESETZ (HTML AUSGABE AUF DEVICE) ;next to the transferral will only who sign expenses upon
    //<< ;YX1=9 UMSETZUNG HARDCODIERTER NAMEN ;transferral
    //<< NEW K,CHAR,UML
    mVar K = m$.var("K");
    mVar CHAR = m$.var("CHAR");
    mVar UML = m$.var("UML");
    m$.newVar(K,CHAR,UML);
    //<< QUIT:X="" X
    if (mOp.Equal(X.get(),"")) {
      return X.get();
    }
    //<< SET YX1=$GET(YX1)
    YX1.set(m$.Fnc.$get(YX1));
    //<< IF YX1=9 SET X=$$^WWW012E(X) QUIT X  ;FIS;13.05.04;25673
    if (mOp.Equal(YX1.get(),9)) {
      X.set(m$.fnc$("WWW012E.main",X.get()));
      return X.get();
    }
    //<< 
    //<< if '$data(^CacheTempWWWUMLAU) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^CacheTempWWWUMLAU")))) {
      //<< merge ^CacheTempWWWUMLAU=^WWWUMLAU
      m$.Cmd.Merge(m$.var("^CacheTempWWWUMLAU"),m$.var("^WWWUMLAU"));
    }
    //<< }
    //<< 
    //<< ;NUR <> ;only
    //<< IF YX1=2 DO  QUIT X  ;OHNE <> zeichen ;without
    if (mOp.Equal(YX1.get(),2)) {
      do {
        //<< . SET CHAR=60 DO CHAR
        CHAR.set(60);
        m$.Cmd.Do("CHAR");
        //<< . SET CHAR=62 DO CHAR
        CHAR.set(62);
        m$.Cmd.Do("CHAR");
        //<< . QUIT
        break;
      } while (false);
      return X.get();
    }
    //<< ;ALLE ZEICHEN ;sign
    //<< SET CHAR="" FOR  SET CHAR=$ORDER(^CacheTempWWWUMLAU(0,CHAR)) QUIT:CHAR=""  IF CHAR'=60 IF CHAR'=62 DO CHAR
    CHAR.set("");
    for (;true;) {
      CHAR.set(m$.Fnc.$order(m$.var("^CacheTempWWWUMLAU",0,CHAR.get())));
      if (mOp.Equal(CHAR.get(),"")) {
        break;
      }
      if (mOp.NotEqual(CHAR.get(),60)) {
        if (mOp.NotEqual(CHAR.get(),62)) {
          m$.Cmd.Do("CHAR");
        }
      }
    }
    //<< ;OHNE <> ;without
    //<< IF YX1=1 QUIT X   ;OHNE <> zeichen ;without
    if (mOp.Equal(YX1.get(),1)) {
      return X.get();
    }
    //<< SET CHAR=60 DO CHAR
    CHAR.set(60);
    m$.Cmd.Do("CHAR");
    //<< SET CHAR=62 DO CHAR
    CHAR.set(62);
    m$.Cmd.Do("CHAR");
    //<< QUIT X   ;mit <> Zeichen ;by means of Character
    return X.get();
  }

  //<< 
  //<< CHAR ;umsetzen der umlaute und sonderzeichen ;transact money who and
  public void CHAR() {
    //<< SET UML="&"_$PIECE($GET(^CacheTempWWWUMLAU(0,CHAR,1)),Y,3)_";"
    mVar UML = m$.var("UML");
    UML.set(mOp.Concat(mOp.Concat("&",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^CacheTempWWWUMLAU",0,m$.var("CHAR").get(),1)),m$.var("Y").get(),3)),";"));
    //<< QUIT:$LENGTH(UML)<3
    if (mOp.Less(m$.Fnc.$length(UML.get()),3)) {
      return;
    }
    //<< IF $LENGTH(X)<32000 FOR  QUIT:'$FIND(X,$CHAR(CHAR))  QUIT:$LENGTH(X)>32000  QUIT:X=""  IF $FIND(X,$CHAR(CHAR)) SET K=$FIND(X,$CHAR(CHAR)) SET X=$EXTRACT(X,1,K-2)_UML_$EXTRACT(X,K,$LENGTH(X))
    if (mOp.Less(m$.Fnc.$length(m$.var("X").get()),32000)) {
      for (;true;) {
        if (mOp.Not(m$.Fnc.$find(m$.var("X").get(),m$.Fnc.$char(m$.var("CHAR").get())))) {
          break;
        }
        if (mOp.Greater(m$.Fnc.$length(m$.var("X").get()),32000)) {
          break;
        }
        if (mOp.Equal(m$.var("X").get(),"")) {
          break;
        }
        if (mOp.Logical(m$.Fnc.$find(m$.var("X").get(),m$.Fnc.$char(m$.var("CHAR").get())))) {
          mVar K = m$.var("K");
          K.set(m$.Fnc.$find(m$.var("X").get(),m$.Fnc.$char(m$.var("CHAR").get())));
          mVar X = m$.var("X");
          X.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(m$.var("X").get(),1,mOp.Subtract(K.get(),2)),UML.get()),m$.Fnc.$extract(m$.var("X").get(),K.get(),m$.Fnc.$length(m$.var("X").get()))));
        }
      }
    }
    //<< QUIT
    return;
  }

}
