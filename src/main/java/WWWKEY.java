//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWKEY
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:42
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include COMSYS
import include.COMSYS;
import include.COMSYSDate;
import include.COMSYSNum;
import include.COMSYSString;
import include.COMSYSWWW;
import include.COMSYSOutput;
import include.COMSYSEnum;
import include.COMGridEdit31Interface;
import include.COMTab;
import include.COMEditor;
import include.COMSYSJS;
import include.$occInclude;

//<< WWWKEY(YIPADDR)
public class WWWKEY extends mClass {

  public Object main(Object ... _p) {
    mVar YIPADDR = m$.newVarRef("YIPADDR",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWKEY(YIPADDR);
  }

  public Object _WWWKEY(Object ... _p) {
    mVar YIPADDR = m$.newVarRef("YIPADDR",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; CHECK LICENCE KEY
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns : boolean RESULT
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 30-Aug-2010   GRF     quits; macros
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YFELD,RESULT,MAX,USED,DAY,HOUR,CHECKED,IP
    mVar YFELD = m$.var("YFELD");
    mVar RESULT = m$.var("RESULT");
    mVar MAX = m$.var("MAX");
    mVar USED = m$.var("USED");
    mVar DAY = m$.var("DAY");
    mVar HOUR = m$.var("HOUR");
    mVar CHECKED = m$.var("CHECKED");
    mVar IP = m$.var("IP");
    m$.newVar(YFELD,RESULT,MAX,USED,DAY,HOUR,CHECKED,IP);
    //<< 
    //<< SET RESULT = $$$OK  ;ACCESS = OK
    RESULT.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< IF $GET(YIPADDR)=""                QUIT RESULT  ;NO IP
    if (mOp.Equal(m$.Fnc.$get(YIPADDR),"")) {
      return RESULT.get();
    }
    //<< IF $GET(YIPADDR)="127.000.000.001" QUIT RESULT  ;SINGLE USER
    if (mOp.Equal(m$.Fnc.$get(YIPADDR),"127.000.000.001")) {
      return RESULT.get();
    }
    //<< 
    //<< SET YFELD = $GET(^WWWKEY(0,0,1))
    YFELD.set(m$.Fnc.$get(m$.var("^WWWKEY",0,0,1)));
    //<< SET MAX   = +$PIECE(YFELD,Y,2)
    MAX.set(mOp.Positive(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),2)));
    //<< IF MAX=0 SET MAX = 1                                        ; MIN. 1 ;m.
    if (mOp.Equal(MAX.get(),0)) {
      MAX.set(1);
    }
    //<< IF MAX>50 QUIT RESULT                                       ; MAX ALLOWED
    if (mOp.Greater(MAX.get(),50)) {
      return RESULT.get();
    }
    //<< 
    //<< ; FIXME : class => ^WWWKEY(0,0,1) cf ^WWWKEY(date,hour,IP)
    //<< 
    //<< SET DAY = 50000
    DAY.set(50000);
    //<< FOR  SET DAY = $ORDER(^WWWKEY(DAY)) QUIT:DAY=""  QUIT:DAY=+$HOROLOG  KILL ^WWWKEY(DAY)  ;KILL OLD
    for (;true;) {
      DAY.set(m$.Fnc.$order(m$.var("^WWWKEY",DAY.get())));
      if (mOp.Equal(DAY.get(),"")) {
        break;
      }
      if (mOp.Equal(DAY.get(),mOp.Positive(m$.Fnc.$horolog()))) {
        break;
      }
      m$.var("^WWWKEY",DAY.get()).kill();
    }
    //<< 
    //<< SET CHECKED = $$$NO
    CHECKED.set(include.COMSYS.$$$NO(m$));
    //<< SET USED    = 0  ;NUMBER OF USERS
    USED.set(0);
    //<< SET HOUR    = $PIECE($HOROLOG,",",2)-600
    HOUR.set(mOp.Subtract(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),600));
    //<< FOR  SET HOUR = $ORDER(^WWWKEY(+$HOROLOG,HOUR)) QUIT:HOUR=""  DO  QUIT:CHECKED=$$$YES
    for (;true;) {
      HOUR.set(m$.Fnc.$order(m$.var("^WWWKEY",mOp.Positive(m$.Fnc.$horolog()),HOUR.get())));
      if (mOp.Equal(HOUR.get(),"")) {
        break;
      }
      //<< . SET IP = ""
      IP.set("");
      //<< . FOR  SET IP = $ORDER(^WWWKEY(+$HOROLOG,HOUR,IP)) QUIT:IP=""  DO  QUIT:CHECKED=$$$YES
      for (;true;) {
        IP.set(m$.Fnc.$order(m$.var("^WWWKEY",mOp.Positive(m$.Fnc.$horolog()),HOUR.get(),IP.get())));
        if (mOp.Equal(IP.get(),"")) {
          break;
        }
        do {
          //<< . . IF IP=YIPADDR SET CHECKED = $$$YES QUIT                      ; PAST CHECK
          if (mOp.Equal(IP.get(),YIPADDR.get())) {
            CHECKED.set(include.COMSYS.$$$YES(m$));
            break;
          }
          //<< . . SET USED = USED+1
          USED.set(mOp.Add(USED.get(),1));
        } while (false);
        if (mOp.Equal(CHECKED.get(),include.COMSYS.$$$YES(m$))) {
          break;
        }
      }
      if (mOp.Equal(CHECKED.get(),include.COMSYS.$$$YES(m$))) {
        break;
      }
    }
    //<< 
    //<< IF CHECKED=1                                   QUIT RESULT
    if (mOp.Equal(CHECKED.get(),1)) {
      return RESULT.get();
    }
    //<< IF (USED=MAX) || (USED>MAX) SET RESULT = $$$NO QUIT RESULT      ; ALL USED UP
    if ((mOp.Equal(USED.get(),MAX.get())) || (mOp.Greater(USED.get(),MAX.get()))) {
      RESULT.set(include.COMSYS.$$$NO(m$));
      return RESULT.get();
    }
    //<< SET ^WWWKEY(+$HOROLOG,$PIECE($HOROLOG,",",2),YIPADDR)=""
    m$.var("^WWWKEY",mOp.Positive(m$.Fnc.$horolog()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),YIPADDR.get()).set("");
    //<< 
    //<< QUIT RESULT
    return RESULT.get();
  }

  //<< 
  //<< 
  //<< CHECK ; CHECK IN FORM ;within shape
  public void CHECK() {
    //<< IF $PIECE(YFELD,Y,4)="???" DO  QUIT
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),4),"???")) {
      //<< . NEW I
      mVar I = m$.var("I");
      m$.newVarBlock(1,I);
      //<< . FOR I=1:1 QUIT:$EXTRACT($PIECE(YFELD,Y,1),I)=""  SET I(1) = $GET(I(1))+$ASCII($EXTRACT($PIECE(YFELD,Y,1),I))
      for (I.set(1);(true);I.set(mOp.Add(I.get(),1))) {
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),1),I.get()),"")) {
          break;
        }
        I.var(1).set(mOp.Add(m$.Fnc.$get(I.var(1)),m$.Fnc.$ascii(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),1),I.get()))));
      }
      //<< . SET I(1) = $EXTRACT(100000+I(1),4,6)_$PIECE(YFELD,Y,3)_$PIECE(YFELD,Y,2)
      I.var(1).set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(mOp.Add(100000,I.var(1).get()),4,6),m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),3)),m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),2)));
      //<< . ;
      //<< . SET %TXT(1)="#YWWWKEYD4~"_$ZHEX($GET(I(1)))
      m$.var("%TXT",1).set(mOp.Concat("#YWWWKEYD4~",m$.Fnc.$zhex(m$.Fnc.$get(I.var(1)))));
      return;
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< IF $PIECE(YFELD,Y,4)'="" DO
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),4),"")) {
      //<< . NEW I
      mVar I = m$.var("I");
      m$.newVarBlock(1,I);
      //<< . FOR I=1:1 QUIT:$EXTRACT($PIECE(YFELD,Y,1),I)=""  SET I(1) = $GET(I(1))+$ASCII($EXTRACT($PIECE(YFELD,Y,1),I))
      for (I.set(1);(true);I.set(mOp.Add(I.get(),1))) {
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),1),I.get()),"")) {
          break;
        }
        I.var(1).set(mOp.Add(m$.Fnc.$get(I.var(1)),m$.Fnc.$ascii(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),1),I.get()))));
      }
      //<< . SET I(1) = $EXTRACT(100000+I(1),4,6)_$PIECE(YFELD,Y,3)_$PIECE(YFELD,Y,2)
      I.var(1).set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(mOp.Add(100000,I.var(1).get()),4,6),m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),3)),m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),2)));
      //<< . ;
      //<< . IF $piece(YFELD,Y,4)'=$ZHEX($GET(I(1))) SET %TXT(1) = "!"_$$^WWWTEXT(409,,1)  ; "Licence Key Is Not Valid"
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),4),m$.Fnc.$zhex(m$.Fnc.$get(I.var(1))))) {
        m$.var("%TXT",1).set(mOp.Concat("!",m$.fnc$("WWWTEXT.main",409,null,1)));
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< CHECK1 ; CHECK ON SAVE
  public void CHECK1() {
    //<< NEW I
    mVar I = m$.var("I");
    m$.newVar(I);
    //<< 
    //<< FOR I=1:1 QUIT:$EXTRACT($PIECE(YFELD,Y,1),I)=""  SET I(1) = $GET(I(1))+$ASCII($EXTRACT($PIECE(YFELD,Y,1),I))
    for (I.set(1);(true);I.set(mOp.Add(I.get(),1))) {
      if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),1),I.get()),"")) {
        break;
      }
      I.var(1).set(mOp.Add(m$.Fnc.$get(I.var(1)),m$.Fnc.$ascii(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),1),I.get()))));
    }
    //<< SET I(1)=$EXTRACT(100000+I(1),4,6)_$PIECE(YFELD,Y,3)_$PIECE(YFELD,Y,2)
    I.var(1).set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(mOp.Add(100000,I.var(1).get()),4,6),m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),3)),m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),2)));
    //<< 
    //<< IF $piece(YFELD,Y,4)'=$ZHEX($GET(I(1))) SET ^WWWSOR(YUSER,1)=$$^WWWTEXT(409,,1)  ; "Licence Key Is Not Valid"
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),4),m$.Fnc.$zhex(m$.Fnc.$get(I.var(1))))) {
      m$.var("^WWWSOR",m$.var("YUSER").get(),1).set(m$.fnc$("WWWTEXT.main",409,null,1));
    }
    //<< 
    //<< QUIT
    return;
  }

//<< 
//<< 
}
