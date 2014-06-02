//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSORTKEY
//** Innovatium Systems - Code Converter - v1.24
//** 2014-06-02 20:23:41
//*****************************************************************************

import mLibrary.*;

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
//<< #include WWWConst
import include.WWWConst;
//import COMSYS;

//<< WWWSORTKEY(YDATEI,pblnForceNoIdx=0)
public class WWWSORTKEY extends mClass {

  public Object main(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnForceNoIdx = m$.newVarRef("pblnForceNoIdx",(((_p!=null)&&(_p.length>=2))?_p[1]:null),0);
    return _WWWSORTKEY(YDATEI,pblnForceNoIdx);
  }

  public Object _WWWSORTKEY(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnForceNoIdx = m$.newVarRef("pblnForceNoIdx",(((_p!=null)&&(_p.length>=2))?_p[1]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       VORGABEN F‹R SORTKEYS IN VARIABLE YSKEY
    //<< ;       Build list of index keys for a class for use in updating indices
    //<< ;
    //<< ;   D ^WWWSORTKEY(CLASS)
    //<< ;
    //<< ; Inputs :
    //<< ;   YDATEI      idClass
    //<< ;
    //<< ; ByRef :
    //<< ;   YSKEY(1)  = "K1,F2,K3"               ;VARIABLEN F‹R SORTIERSCHL‹SSEL
    //<< ;   YSKEY     = LAST USED SORTKEY
    //<< ;
    //<< ;------------------------
    //<< ; e.g. Class FINAPInv with index definitions -     will return -
    //<< ;    1.1 : 22 : Invoice Supplier                YSKEY     = "FINAPInv"
    //<< ;    1.2 :  2 : SuppliersInvoiceNumber          YSKEY(1)  = "F22,F2"
    //<< ;      2 :  3 : Is Voucher                      YSKEY(2)  = "F3"
    //<< ;      3 : 34 : Parent Invoice                  YSKEY(3)  = "F34"
    //<< ;    4.1 : 36 : Repeat Group                    YSKEY(4)  = "F36,F34"
    //<< ;    4.2 : 34 : Parent Invoice                  YSKEY(5)  = "F9"
    //<< ;      5 :  9 : Batch Number                    YSKEY(60) = "F28"
    //<< ;     60 : 28 : Status
    //<< ;------------------------
    //<< ;
    //<< ; Returns : Nothing
    //<< ;
    //<< ; History :
    //<< ; 20-Sep-2011   SCR     SR17885: Added Force No Index option , used by compiled code (COMIndex,WWW001OO,idx etc)
    //<< ; 07-Feb-2008   GRF     Doco
    //<< ; 31-May-2007   HeberB  BR014465:Add new characters
    //<< ; 30-Mar-2007   RPW     Possible brace version
    //<< ; 02-Mar-2007   GRF     SR15462: Doco; quits; WW120=>WWW120
    //<< ; 18:08.2000    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YYDATEI,YSORSOR
    mVar YYDATEI = m$.var("YYDATEI");
    mVar YSORSOR = m$.var("YSORSOR");
    m$.newVar(YYDATEI,YSORSOR);
    //<< 
    //<< KILL YSKEY
    m$.var("YSKEY").kill();
    //<< 
    //<< QUIT:$GET(YDATEI)=""
    if (mOp.Equal(m$.Fnc.$get(YDATEI),"")) {
      return null;
    }
    //<< 
    //<< SET YSKEY=YDATEI  ;LETZTER VERWENDETER KEY
    mVar YSKEY = m$.var("YSKEY");
    YSKEY.set(YDATEI.get());
    //<< 
    //<< /*
    //<< if '$find("WWW120,WWW124,WWW122,WWW002,WWW003",YDATEI) && ($DATA(^WWW002s(0,4))) {
    //<< SET LC="·‡„‚ÈËÍÌÏÓÛÚıÙ˙˘˚Á‹ƒ÷¸‰ˆﬂ][\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/"_$CHAR(128)_""""_" "   ;SPEEDUP;TYBD;25.09.2004
    //<< SET UC="¡¿√¬…» ÕÃŒ”“’‘⁄Ÿ€«UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   "
    //<< IF YUMLAU'="" {
    //<< SET YYDATEI=$$^WWWUMLAU(YDATEI,1)
    //<< } else {
    //<< SET YYDATEI=$TRANSLATE(YDATEI,LC,UC)
    //<< }
    //<< 
    //<< $$$Order4(^WWW002s,0,4,YYDATEI,YSORSOR)
    //<< $$$Order5(^WWW002s,0,4,YYDATEI,YSORSOR,YLFN)
    //<< continue:YSORSOR'=" "
    //<< set YSKEY=$$$WWW002IndexKey($get(^WWW002(0,YDATEI,YLFN,1)))
    //<< for YI=1:1 {
    //<< set YA=$piece(YSKEY,$$$COMMA,YI)
    //<< quit:YA=""
    //<< set YA(1)=+$piece(YA,".",1)
    //<< continue:YA(1)=0
    //<< 
    //<< set YA(2)=+$piece(YA,".",2)
    //<< if YA(2)=0 set YA(2)=1
    //<< set $piece(YSKEY(YA(1)),$$$COMMA,YA(2))="K"_YLFN
    //<< }
    //<< $$$End
    //<< $$$End
    //<< 
    //<< $$$Order4(^WWW003s,0,4,YYDATEI,YSORSOR)
    //<< continue:YSORSOR'=" "
    //<< $$$Order5(^WWW002s,0,4,YYDATEI,YSORSOR,YLFN)
    //<< continue:YSORSOR'=" "
    //<< set YSKEY=$$$WWW003IndexKey($get(^WWW003(0,YDATEI,YLFN,1)))
    //<< for YI=1:1 {
    //<< set YA=$piece(YSKEY,$$$COMMA,YI)
    //<< quit:YA=""
    //<< set YA(1)=+$piece(YA,".",1)
    //<< continue:YA(1)=0
    //<< 
    //<< set YA(2)=+$piece(YA,".",2)
    //<< if YA(2)=0 set YA(2)=1
    //<< set $piece(YSKEY(YA(1)),$$$COMMA,YA(2))="F"_YLFN
    //<< }
    //<< $$$End
    //<< $$$End
    //<< 
    //<< SET YSKEY=YDATEI
    //<< quit
    //<< }
    //<< */
    //<< 
    //<< ;IF '$FIND("WWW120,WWW124,WWW122,WWW002,WWW003",YDATEI) IF $DATA(^WWW002s(0,4)) DO  SET YSKEY=YDATEI QUIT  ;MIT SORTKEY;SPEEDUP;TYBD;27,10,2004
    //<< IF ('$FIND("WWW120,WWW124,WWW122,WWW002,WWW003",YDATEI)) && ('pblnForceNoIdx) IF $DATA(^WWW002s(0,4)) DO  SET YSKEY=YDATEI QUIT  ;SR17885 MIT SORTKEY;SPEEDUP;TYBD;27,10,2004
    if ((mOp.Not(m$.Fnc.$find("WWW120,WWW124,WWW122,WWW002,WWW003",YDATEI.get()))) && (mOp.Not(pblnForceNoIdx.get()))) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW002s",0,4)))) {
        //<< . ;BR014465
        //<< . ;SET LC="‹ƒ÷¸‰ˆﬂ][\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/"_$CHAR(128)_""""_" "   ;SPEEDUP;TYBD;25.09.2004
        //<< . ;SET UC="UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   "
        //<< . SET LC="·‡„‚ÈËÍÌÏÓÛÚıÙ˙˘˚Á‹ƒ÷¸‰ˆﬂ][\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/"_$CHAR(128)_""""_" "   ;SPEEDUP;TYBD;25.09.2004
        mVar LC = m$.var("LC");
        LC.set(mOp.Concat(mOp.Concat(mOp.Concat("·‡„‚ÈËÍÌÏÓÛÚıÙ˙˘˚Á‹ƒ÷¸‰ˆﬂ][\\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\"")," "));
        //<< . SET UC="¡¿√¬…» ÕÃŒ”“’‘⁄Ÿ€«UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   "
        mVar UC = m$.var("UC");
        UC.set("¡¿√¬…» ÕÃŒ”“’‘⁄Ÿ€«UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   ");
        //<< . IF YUMLAU'="" SET YYDATEI=$$^WWWUMLAU(YDATEI,1)
        if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
          YYDATEI.set(m$.fnc$("WWWUMLAU.main",YDATEI.get(),1));
        }
        //<< . IF YUMLAU=""  SET YYDATEI=$TRANSLATE(YDATEI,LC,UC)
        if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
          YYDATEI.set(m$.Fnc.$translate(YDATEI.get(),LC.get(),UC.get()));
        }
        //<< . SET YSORSOR=""
        YSORSOR.set("");
        //<< . FOR  SET YSORSOR=$ORDER(^WWW002s(0,4,YYDATEI,YSORSOR)) QUIT:YSORSOR=""  IF YSORSOR'=" " DO
        for (;true;) {
          YSORSOR.set(m$.Fnc.$order(m$.var("^WWW002s",0,4,YYDATEI.get(),YSORSOR.get())));
          if (mOp.Equal(YSORSOR.get(),"")) {
            break;
          }
          if (mOp.NotEqual(YSORSOR.get()," ")) {
            //<< . . SET YLFN=""
            mVar YLFN = m$.var("YLFN");
            YLFN.set("");
            //<< . . FOR  SET YLFN=$ORDER(^WWW002s(0,4,YYDATEI,YSORSOR,YDATEI,YLFN)) QUIT:YLFN=""  DO
            for (;true;) {
              YLFN.set(m$.Fnc.$order(m$.var("^WWW002s",0,4,YYDATEI.get(),YSORSOR.get(),YDATEI.get(),YLFN.get())));
              if (mOp.Equal(YLFN.get(),"")) {
                break;
              }
              //<< . . . SET YSKEY=$PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,6)
              YSKEY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),YLFN.get(),1)),m$.var("Y").get(),6));
              //<< . . . FOR YI=1:1 SET YA=$PIECE(YSKEY,",",YI) QUIT:YA=""  DO
              mVar YI = m$.var("YI");
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                mVar YA = m$.var("YA");
                YA.set(m$.Fnc.$piece(YSKEY.get(),",",YI.get()));
                if (mOp.Equal(YA.get(),"")) {
                  break;
                }
                do {
                  //<< . . . . SET YA(1)=+$PIECE(YA,".",1)
                  YA.var(1).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",1)));
                  //<< . . . . SET YA(2)=+$PIECE(YA,".",2)
                  YA.var(2).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",2)));
                  //<< . . . . QUIT:+YA(1)=0
                  if (mOp.Equal(mOp.Positive(YA.var(1).get()),0)) {
                    break;
                  }
                  //<< . . . . IF +YA(2)=0 SET YA(2)=1
                  if (mOp.Equal(mOp.Positive(YA.var(2).get()),0)) {
                    YA.var(2).set(1);
                  }
                  //<< . . . . SET $PIECE(YSKEY(YA(1)),",",YA(2))="K"_YLFN
                  m$.pieceVar(YSKEY.var(YA.var(1).get()),",",YA.var(2).get()).set(mOp.Concat("K",YLFN.get()));
                } while (false);
              }
            }
          }
        }
        //<< . ;
        //<< . SET YSORSOR=""
        YSORSOR.set("");
        //<< . FOR  SET YSORSOR=$ORDER(^WWW003s(0,4,YYDATEI,YSORSOR)) QUIT:YSORSOR=""  IF YSORSOR'=" " DO
        for (;true;) {
          YSORSOR.set(m$.Fnc.$order(m$.var("^WWW003s",0,4,YYDATEI.get(),YSORSOR.get())));
          if (mOp.Equal(YSORSOR.get(),"")) {
            break;
          }
          if (mOp.NotEqual(YSORSOR.get()," ")) {
            //<< . . SET YLFN=""
            mVar YLFN = m$.var("YLFN");
            YLFN.set("");
            //<< . . FOR  SET YLFN=$ORDER(^WWW003s(0,4,YYDATEI,YSORSOR,YDATEI,YLFN)) QUIT:YLFN=""  DO
            for (;true;) {
              YLFN.set(m$.Fnc.$order(m$.var("^WWW003s",0,4,YYDATEI.get(),YSORSOR.get(),YDATEI.get(),YLFN.get())));
              if (mOp.Equal(YLFN.get(),"")) {
                break;
              }
              //<< . . . SET YSKEY=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,6)
              YSKEY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),YLFN.get(),1)),m$.var("Y").get(),6));
              //<< . . . FOR YI=1:1 SET YA=$PIECE(YSKEY,",",YI) QUIT:YA=""  DO
              mVar YI = m$.var("YI");
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                mVar YA = m$.var("YA");
                YA.set(m$.Fnc.$piece(YSKEY.get(),",",YI.get()));
                if (mOp.Equal(YA.get(),"")) {
                  break;
                }
                do {
                  //<< . . . . SET YA(1)=+$PIECE(YA,".",1)
                  YA.var(1).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",1)));
                  //<< . . . . SET YA(2)=+$PIECE(YA,".",2)
                  YA.var(2).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",2)));
                  //<< . . . . QUIT:+YA(1)=0
                  if (mOp.Equal(mOp.Positive(YA.var(1).get()),0)) {
                    break;
                  }
                  //<< . . . . IF +YA(2)=0 SET YA(2)=1
                  if (mOp.Equal(mOp.Positive(YA.var(2).get()),0)) {
                    YA.var(2).set(1);
                  }
                  //<< . . . . SET $PIECE(YSKEY(YA(1)),",",YA(2))="F"_YLFN
                  m$.pieceVar(YSKEY.var(YA.var(1).get()),",",YA.var(2).get()).set(mOp.Concat("F",YLFN.get()));
                } while (false);
              }
            }
          }
        }
        YSKEY.set(YDATEI.get());
        return null;
      }
    }
    //<< 
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; OBSOLETE (?) CODE BELOW IS ONLY EXECUTED WHEN ^WWW002s(0,4) DOESN'T EXIST
    //<< ; or FOR SPECIAL CLASSES
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;old version;tybd;28,10,2004
    //<< SET YLFN=""
    mVar YLFN = m$.var("YLFN");
    YLFN.set("");
    //<< FOR  SET YLFN=$ORDER(^WWW002(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      //<< . SET YSKEY=$PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,6)
      YSKEY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),YLFN.get(),1)),m$.var("Y").get(),6));
      //<< . FOR YI=1:1 SET YA=$PIECE(YSKEY,",",YI) QUIT:YA=""  DO
      mVar YI = m$.var("YI");
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$piece(YSKEY.get(),",",YI.get()));
        if (mOp.Equal(YA.get(),"")) {
          break;
        }
        do {
          //<< . . SET YA(1)=+$PIECE(YA,".",1)
          YA.var(1).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",1)));
          //<< . . SET YA(2)=+$PIECE(YA,".",2)
          YA.var(2).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",2)));
          //<< . . QUIT:+YA(1)=0
          if (mOp.Equal(mOp.Positive(YA.var(1).get()),0)) {
            break;
          }
          //<< . . IF +YA(2)=0 SET YA(2)=1
          if (mOp.Equal(mOp.Positive(YA.var(2).get()),0)) {
            YA.var(2).set(1);
          }
          //<< . . SET $PIECE(YSKEY(YA(1)),",",YA(2))="K"_YLFN
          m$.pieceVar(YSKEY.var(YA.var(1).get()),",",YA.var(2).get()).set(mOp.Concat("K",YLFN.get()));
        } while (false);
      }
    }
    //<< 
    //<< SET YLFN=""
    YLFN.set("");
    //<< FOR  SET YLFN=$ORDER(^WWW003(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW003",0,YDATEI.get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      //<< . SET YSKEY=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,6)
      YSKEY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),YLFN.get(),1)),m$.var("Y").get(),6));
      //<< . FOR YI=1:1 SET YA=$PIECE(YSKEY,",",YI) QUIT:YA=""  DO
      mVar YI = m$.var("YI");
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$piece(YSKEY.get(),",",YI.get()));
        if (mOp.Equal(YA.get(),"")) {
          break;
        }
        do {
          //<< . . SET YA(1)=+$PIECE(YA,".",1)
          YA.var(1).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",1)));
          //<< . . SET YA(2)=+$PIECE(YA,".",2)
          YA.var(2).set(mOp.Positive(m$.Fnc.$piece(YA.get(),".",2)));
          //<< . . QUIT:+YA(1)=0
          if (mOp.Equal(mOp.Positive(YA.var(1).get()),0)) {
            break;
          }
          //<< . . IF +YA(2)=0 SET YA(2)=1
          if (mOp.Equal(mOp.Positive(YA.var(2).get()),0)) {
            YA.var(2).set(1);
          }
          //<< . . SET $PIECE(YSKEY(YA(1)),",",YA(2))="F"_YLFN
          m$.pieceVar(YSKEY.var(YA.var(1).get()),",",YA.var(2).get()).set(mOp.Concat("F",YLFN.get()));
        } while (false);
      }
    }
    //<< 
    //<< SET YSKEY=YDATEI
    YSKEY.set(YDATEI.get());
    //<< QUIT
    return null;
  }

//<< 
}
