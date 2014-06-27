//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTME
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 20:56:43
//*****************************************************************************

import mLibrary.*;


//<< INARTME ;INARTME;FAN;ÜBERTRAGEN DES MENGENEINHEIT;03.04.2001
public class INARTME extends mClass {

  public void main() {
    _INARTME();
  }

  public void _INARTME() {
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      ÜBERTRAGEN DES MENGENEINHEIT
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
    //<< ;| FAN  03.04.2001
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< NEW YKEY,YFELD,YART1,ME
    mVar YKEY = m$.var("YKEY");
    mVar YFELD = m$.var("YFELD");
    mVar YART1 = m$.var("YART1");
    mVar ME = m$.var("ME");
    m$.newVar(YKEY,YFELD,YART1,ME);
    //<< SET YFELD=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"D",1)) ;DATENSATZ ;data record
    YFELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1)));
    //<< QUIT:YFELD=""
    if (mOp.Equal(YFELD.get(),"")) {
      return;
    }
    //<< ;SET YKEY=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"P",1)) ;DATENSATZ
    //<< ;QUIT:$PIECE(YKEY,",",1)=""   ;KEIN ARTIKEL
    //<< ;SET YART1=$GET(^INART(YM,$PIECE(YKEY,",",1),1))
    //<< SET ME=$PIECE(YFELD,Y,40)
    ME.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),40));
    //<< IF ME'=5 IF ME'=6 IF ME'=12 IF ME'=18 QUIT
    if (mOp.NotEqual(ME.get(),5)) {
      if (mOp.NotEqual(ME.get(),6)) {
        if (mOp.NotEqual(ME.get(),12)) {
          if (mOp.NotEqual(ME.get(),18)) {
            return;
          }
        }
      }
    }
    //<< IF ME=5 WRITE $$^WWWTEXT(32091)_" m"
    if (mOp.Equal(ME.get(),5)) {
      m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main",32091)," m"));
    }
    //<< IF ME=6 WRITE $$^WWWTEXT(32091)_" m"
    if (mOp.Equal(ME.get(),6)) {
      m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main",32091)," m"));
    }
    //<< IF ME=12 WRITE $$^WWWTEXT(32091)_" m"
    if (mOp.Equal(ME.get(),12)) {
      m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main",32091)," m"));
    }
    //<< IF ME=18 WRITE $$^WWWTEXT(32091)_" mm"
    if (mOp.Equal(ME.get(),18)) {
      m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main",32091)," mm"));
    }
    //<< QUIT
    return;
  }

//<< 
}
