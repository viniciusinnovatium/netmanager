//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWBITRUN
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:34
//*****************************************************************************

import mLibrary.*;


//<< WWWBITRUN   ;WWWBITRUN;TYBD;HINTERGRUND BITMAP;19,10,2004  ; Compiled March 4, 2005 14:18:55
public class WWWBITRUN extends mClass {

  public void main() {
    _WWWBITRUN();
  }

  public void _WWWBITRUN() {
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      HINTERGRUND BITMAP
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
    //<< ;| TYBD 19,10,2004
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< LOCK +^WWWBITRUN:0 IF '$TEST halt
    m$.Cmd.LockInc(m$.var("^WWWBITRUN"),0);
    if (mOp.Not(m$.Fnc.$test())) {
    }
    //<< SET $ZTRAP="^WWWERROR"
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("^WWWERROR");
    //<< DO ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< DO LOW^%PRIO
    m$.Cmd.Do("$PRIO.LOW");
    //<< FOR YII=1:1:20 DO RUN hang 10
    mVar YII = m$.var("YII");
    for (YII.set(1);(mOp.LessOrEqual(YII.get(),20));YII.set(mOp.Add(YII.get(),1))) {
      m$.Cmd.Do("RUN");
      m$.Cmd.Hang(10);
    }
    //<< LOCK -^WWWBITRUN
    m$.Cmd.Unlock(m$.var("^WWWBITRUN"));
    RUN();
  }

  //<< halt
  //<< 
  //<< RUN ;
  public void RUN() {
    //<< NEW YII,YM,YOK,YNEXT,WWWYM,YBITLIST,YFELD,YKEY,YDATEI,YKILLBI,SET1,SET,YXREF
    mVar YII = m$.var("YII");
    mVar YM = m$.var("YM");
    mVar YOK = m$.var("YOK");
    mVar YNEXT = m$.var("YNEXT");
    mVar WWWYM = m$.var("WWWYM");
    mVar YBITLIST = m$.var("YBITLIST");
    mVar YFELD = m$.var("YFELD");
    mVar YKEY = m$.var("YKEY");
    mVar YDATEI = m$.var("YDATEI");
    mVar YKILLBI = m$.var("YKILLBI");
    mVar SET1 = m$.var("SET1");
    mVar SET = m$.var("SET");
    mVar YXREF = m$.var("YXREF");
    m$.newVar(YII,YM,YOK,YNEXT,WWWYM,YBITLIST,YFELD,YKEY,YDATEI,YKILLBI,SET1,SET,YXREF);
    //<< SET YM="" FOR  SET YM=$ORDER(^WWWBITRUN(YM)) QUIT:YM=""  DO
    YM.set("");
    for (;true;) {
      YM.set(m$.Fnc.$order(m$.var("^WWWBITRUN",YM.get())));
      if (mOp.Equal(YM.get(),"")) {
        break;
      }
      do {
        //<< . SET YNEXT="" FOR  SET YNEXT=$ORDER(^WWWBITRUN(YM,YNEXT)) QUIT:YNEXT=""  DO
        YNEXT.set("");
        for (;true;) {
          YNEXT.set(m$.Fnc.$order(m$.var("^WWWBITRUN",YM.get(),YNEXT.get())));
          if (mOp.Equal(YNEXT.get(),"")) {
            break;
          }
          do {
            //<< . . SET YDATEI=$GET(^WWWBITRUN(YM,YNEXT,1,1))
            YDATEI.set(m$.Fnc.$get(m$.var("^WWWBITRUN",YM.get(),YNEXT.get(),1,1)));
            //<< . . SET YKEY=$GET(^WWWBITRUN(YM,YNEXT,2,1))
            YKEY.set(m$.Fnc.$get(m$.var("^WWWBITRUN",YM.get(),YNEXT.get(),2,1)));
            //<< . . SET YFELD=$GET(^WWWBITRUN(YM,YNEXT,3,1))
            YFELD.set(m$.Fnc.$get(m$.var("^WWWBITRUN",YM.get(),YNEXT.get(),3,1)));
            //<< . . S SET1=$GET(^WWWBITRUN(YM,YNEXT,4,1))
            SET1.set(m$.Fnc.$get(m$.var("^WWWBITRUN",YM.get(),YNEXT.get(),4,1)));
            //<< . . SET SET=$PIECE(SET1,Y,1)
            SET.set(m$.Fnc.$piece(SET1.get(),m$.var("Y").get(),1));
            //<< . . SET YKILLBI=$PIECE(SET1,Y,2)
            YKILLBI.set(m$.Fnc.$piece(SET1.get(),m$.var("Y").get(),2));
            //<< . . SET YBITLIST=$PIECE(SET1,Y,3)
            YBITLIST.set(m$.Fnc.$piece(SET1.get(),m$.var("Y").get(),3));
            //<< . . SET WWWYM=$P($PIECE(SET1,Y,4),",",1)
            WWWYM.set(m$.Fnc.$piece(m$.Fnc.$piece(SET1.get(),m$.var("Y").get(),4),",",1));
            //<< . . SET YXREF=$PIECE(SET1,Y,5)
            YXREF.set(m$.Fnc.$piece(SET1.get(),m$.var("Y").get(),5));
            //<< . . DO
            do {
              //<< . . . NEW YNEXT
              m$.newVarBlock(3,YNEXT);
              //<< . . . SET YOK=$$^WWWBITSET(YDATEI,YKEY,SET,YFELD,YKILLBI,YBITLIST,1,WWWYM,YXREF)
              YOK.set(m$.fnc$("WWWBITSET.main",YDATEI.get(),YKEY.get(),SET.get(),YFELD.get(),YKILLBI.get(),YBITLIST.get(),1,WWWYM.get(),YXREF.get()));
              //<< . . . QUIT
              break;
            } while(false);
            m$.restoreVarBlock(3);
            //<< . . KILL ^WWWBITRUN(YM,YNEXT)
            m$.var("^WWWBITRUN",YM.get(),YNEXT.get()).kill();
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . QUIT
        break;
      } while (false);
    }
    //<< QUIT
    return;
  }

//<< 
}
