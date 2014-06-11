//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSAVD
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-10 14:58:23
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
//import COMSYS;

//<< WWWSAVD
public class WWWSAVD extends mClass {

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogR2(%1,%2)    ;
  public static Object $$$LogR2(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogRx(%1)       ;
  public static Object $$$LogRx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogRm(%1)       ;
  public static Object $$$LogRm(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _WWWSAVD();
  }

  public void _WWWSAVD() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWSAVD("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogR2(%1,%2)   $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWSAVD("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Description of Function :
  //<< ;       Check Form Data Field
  //<< ;       DATENFELDER PRUEFEN
  //<< ;
  //<< ; Inputs :
  //<< ;   YI          SEQ NO
  //<< ;   YFELD       RECORD
  //<< ;   YTYP        DATATYPE
  //<< ;   YLFZ        ?
  //<< ;   YALLKEY     ?
  //<< ;   YDATEI
  //<< ;   SPRACHE
  //<< ;
  //<< ; NOTE: Data YFELD is in external (display) format
  //<< ;
  //<< ; History :
  //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
  //<< ; 01-Jun-2010   GRF     SR17146: Call common code for Dates
  //<< ; 20-Oct-2008   GRF     SR12505: Corrections to OnlyAllowChars test; Recognise
  //<< ;                           WWW122D
  //<< ; 20-Aug-2007   GM      SR13729: Change "FELDFORMAT" parameter to $$GetFormat^INPARA()
  //<< ; 14-Mar-2007   GRF     SR12505: Implement code for $$$WWW122DontAllowChars;
  //<< ;                           conversion macros; idChangeInput
  //<< ; 09-Mar-2007   GRF     SR12505: Change macro to $$$WWW122OnlyAllowChars; naked ref
  //<< ; 29-Sep-2006   HeberB  SRBR014265: Added YFELD as param to Validate
  //<< ; 10-Aug-2006   JW      SR13594: Encapsulated validation.
  //<< ; 29-Jun-2006   JW      SR12775: Add and return pblnValid, fix error check.
  //<< ; 24-Mar-2006   JW      SR14422: Change to internal format
  //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
  //<< ; 16-Aug-2005   JW      SR12290: Don't validate if no change. Return better
  //<< ;                           error msg if not valid.
  //<< ; 25-Jul-2005   JW      SR12615: Relation validation
  //<< ; 30-May-2005   RobertW SR12056: Attempt at Performance Increase
  //<< ; 21.06.1999    DT
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< PRUEFD(poldYFELD="")
  public Object PRUEFD(Object ... _p) {
    mVar poldYFELD = m$.newVarRef("poldYFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Check data field    ; PRUEFEN DATENFELDER
    //<< ;
    //<< ; Called By : WWWSAVE
    //<< ;
    //<< ; Inputs :
    //<< ;   poldYFELD       No longer used
    //<< ;
    //<< ; ByRef :
    //<< ;   YDATEI          idClass
    //<< ;   YFORM           idFormName
    //<< ;   YKEY(1)         String list of keys
    //<< ;   YFELD           Current data record
    //<< ;   YI              Current class field number - field in YFELD
    //<< ;   YALLKEY
    //<< ;   YLFZ
    //<< ;   YTYP
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< ;   A               Field data - taken from YFELD for piece YI
    //<< ;   YBBN            First form field associated with class field no (can only display one) : idFormField
    //<< ;   YPRUEF          Form data field parameters : objWWW122
    //<< ;-------------------------------------------------------------------------------
    //<< ; 09-Aug-2011   shobby  SR17807: GetFormat has moved.
    //<< 
    //<< new A,idChangeInput,objCustomData,Q,strAllowChars,strBlockChars,strTestChar,YPR,YPRUEF,YTEXT
    mVar A = m$.var("A");
    mVar idChangeInput = m$.var("idChangeInput");
    mVar objCustomData = m$.var("objCustomData");
    mVar Q = m$.var("Q");
    mVar strAllowChars = m$.var("strAllowChars");
    mVar strBlockChars = m$.var("strBlockChars");
    mVar strTestChar = m$.var("strTestChar");
    mVar YPR = m$.var("YPR");
    mVar YPRUEF = m$.var("YPRUEF");
    mVar YTEXT = m$.var("YTEXT");
    m$.newVar(A,idChangeInput,objCustomData,Q,strAllowChars,strBlockChars,strTestChar,YPR,YPRUEF,YTEXT);
    //<< 
    //<< $$$LogR2("PRUEFD",$get(YFORM)_":"_$get(YI)_"<"_$get(YTYP)_"<"_$get(YFELD)_"<")
    $$$LogR2(m$,"PRUEFD",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YFORM")),":"),m$.Fnc.$get(m$.var("YI"))),"<"),m$.Fnc.$get(m$.var("YTYP"))),"<"),m$.Fnc.$get(m$.var("YFELD"))),"<"));
    //<< 
    //<< QUIT:$GET(YALLKEY)=9
    if (mOp.Equal(m$.Fnc.$get(m$.var("YALLKEY")),9)) {
      return null;
    }
    //<< 
    //<< IF '$DATA(YLFZ) SET YLFZ=0
    if (mOp.Not(m$.Fnc.$data(m$.var("YLFZ")))) {
      mVar YLFZ = m$.var("YLFZ");
      YLFZ.set(0);
    }
    //<< 
    //<< ; Field Name - for error reporting
    //<< ;---------------------------------------
    //<< SET YTEXT = $PIECE($GET(^WWW003(0,YDATEI,YI,1)),Y,2)
    YTEXT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YI").get(),1)),m$.var("Y").get(),2));
    //<< IF $DATA(^WWW0031(0,YDATEI,YI,SPRACHE,1)) SET YTEXT = $PIECE(^WWW0031(0,YDATEI,YI,SPRACHE,1),Y,1)
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,m$.var("YDATEI").get(),m$.var("YI").get(),m$.var("SPRACHE").get(),1)))) {
      YTEXT.set(m$.Fnc.$piece(m$.var("^WWW0031",0,m$.var("YDATEI").get(),m$.var("YI").get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
    }
    //<< 
    //<< ; vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv FIXME : <GRF> WWW003 [D22] (and thus this block) is deprecated <GRF>
    //<< 
    //<< SET YTEXT(1) = $$$WWW003UniqueKey($GET(^WWW003(0,YDATEI,YI,1)))
    YTEXT.var(1).set(include.WWWConst.$$$WWW003UniqueKey(m$,m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YI").get(),1))));
    //<< 
    //<< IF YTEXT(1)=$$$YES DO   ;PRUEFEN DOPPELTER KEY BEI PRIMÄRSCHL IN DATENFELD ;KEY next to within data item
    if (mOp.Equal(YTEXT.var(1).get(),include.COMSYS.$$$YES(m$))) {
      do {
        //<< . QUIT:'$DATA(YKEY(1))
        if (mOp.Not(m$.Fnc.$data(m$.var("YKEY").var(1)))) {
          break;
        }
        //<< . NEW DATA,YDATA
        mVar DATA = m$.var("DATA");
        mVar YDATA = m$.var("YDATA");
        m$.newVarBlock(1,DATA,YDATA);
        //<< . SET YDATA=$GET(^WWW001(0,YDATEI,1))
        YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YDATEI").get(),1)));
        //<< . IF $$$WWW001AltSaveProcedure(YDATA)'=4 SET DATA="^"_YDATEI_"("_$$^WWWYM(YDATEI,1)_""""_YKEY(1)_""""_",1)"
        if (mOp.NotEqual(include.WWWConst.$$$WWW001AltSaveProcedure(m$,YDATA),4)) {
          DATA.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YDATEI").get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),"\""),m$.var("YKEY").var(1).get()),"\""),",1)"));
        }
        //<< . IF $$$WWW001AltSaveProcedure(YDATA)=4  SET DATA="^"_YDATEI_"("_$$^WWWYM(YDATEI,1)_""""_YKEY(1)_""""_")"
        if (mOp.Equal(include.WWWConst.$$$WWW001AltSaveProcedure(m$,YDATA),4)) {
          DATA.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YDATEI").get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),"\""),m$.var("YKEY").var(1).get()),"\""),")"));
        }
        //<< . SET DATA(1)=$$^WWWSETL(DATA)
        DATA.var(1).set(m$.fnc$("WWWSETL.main",DATA.get()));
        //<< . QUIT:DATA(1)=""  ;DATENSATZ NICHT VORHANDEN ;data record Not on hand
        if (mOp.Equal(DATA.var(1).get(),"")) {
          break;
        }
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< ; ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ FIXME
    //<< 
    //<< SET A = $PIECE(YFELD,Y,YI)
    A.set(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YI").get()));
    //<< //set origA = A
    //<< 
    //<< SET YBBN = $ORDER(^WWW122s(0,4,YI,YFORM,""))
    mVar YBBN = m$.var("YBBN");
    YBBN.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,m$.var("YI").get(),m$.var("YFORM").get(),"")));
    //<< SET YPRUEF        = ""
    YPRUEF.set("");
    //<< set objCustomData = ""
    objCustomData.set("");
    //<< IF YBBN'="" {
    if (mOp.NotEqual(YBBN.get(),"")) {
      //<< set YPRUEF        = $get(^WWW122(0,YFORM,YBBN,1))
      YPRUEF.set(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YBBN.get(),1)));
      //<< set objCustomData = $get(^WWW122D(0,YFORM,YBBN,YM,1))
      objCustomData.set(m$.Fnc.$get(m$.var("^WWW122D",0,m$.var("YFORM").get(),YBBN.get(),m$.var("YM").get(),1)));
    }
    //<< }
    //<< 
    //<< SET YDECIMALLEN=2
    mVar YDECIMALLEN = m$.var("YDECIMALLEN");
    YDECIMALLEN.set(2);
    //<< IF (YBBN'="") && ($GET(YM)'="") && $DATA(^WWW122D(0,YFORM,YBBN,YM,1)) {
    if ((mOp.NotEqual(YBBN.get(),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YM")),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^WWW122D",0,m$.var("YFORM").get(),YBBN.get(),m$.var("YM").get(),1)))) {
      //<< IF $$$WWW122DDecimals(^WWW122D(0,YFORM,YBBN,YM,1))'="" SET YDECIMALLEN=$$$WWW122DDecimals(^WWW122D(0,YFORM,YBBN,YM,1))
      if (mOp.NotEqual(include.WWWConst.$$$WWW122DDecimals(m$,m$.var("^WWW122D",0,m$.var("YFORM").get(),YBBN.get(),m$.var("YM").get(),1)),"")) {
        YDECIMALLEN.set(include.WWWConst.$$$WWW122DDecimals(m$,m$.var("^WWW122D",0,m$.var("YFORM").get(),YBBN.get(),m$.var("YM").get(),1)));
      }
    }
    //<< }
    //<< 
    //<< ; Counter (InputType 9) - next number
    //<< ;---------------------------------------
    //<< if (YTYP=9) && (A="+") set A = $$^WWWNEXT(YDATEI)
    if ((mOp.Equal(m$.var("YTYP").get(),9)) && (mOp.Equal(A.get(),"+"))) {
      A.set(m$.fnc$("WWWNEXT.main",m$.var("YDATEI").get()));
    }
    //<< 
    //<< ; Valid Relation, Mandatory Checks
    //<< ;---------------------------------------
    //<< set strStatus = $$Validate(YDATEI,YFORM,YI,.A,$$$YES,YFELD)
    mVar strStatus = m$.var("strStatus");
    strStatus.set(m$.fnc$("Validate",m$.var("YDATEI").get(),m$.var("YFORM").get(),m$.var("YI").get(),A,include.COMSYS.$$$YES(m$),m$.var("YFELD").get()));
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set A = ""          // SR12615: Clear field if not valid
      A.set("");
      //<< set ^WWWSOR(YUSER,$increment(YLFZ)) = YTEXT_": "_$$$Text(strStatus)_"|"
      m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),include.COMSYS.$$$Text(m$,strStatus)),"|"));
    }
    //<< }
    //<< 
    //<< ; "Min. Input Length"
    //<< ;---------------------------------------
    //<< if (+$$$WWW122MinInputLength(YPRUEF)'=0) && ($length(A)<$$$WWW122MinInputLength(YPRUEF)) {
    if ((mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW122MinInputLength(m$,YPRUEF)),0)) && (mOp.Less(m$.Fnc.$length(A.get()),include.WWWConst.$$$WWW122MinInputLength(m$,YPRUEF)))) {
      //<< set ^WWWSOR(YUSER,$increment(YLFZ)) = YTEXT_": "_$$^WWWTEXT(268)_" "_+$$$WWW122MinInputLength(YPRUEF)_"|"
      m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",268))," "),mOp.Positive(include.WWWConst.$$$WWW122MinInputLength(m$,YPRUEF))),"|"));
    }
    //<< }
    //<< 
    //<< ; "Only Following Characters Allowed"
    //<< ;---------------------------------------
    //<< set strAllowChars = $$$WWW122OnlyAllowChars(YPRUEF)
    strAllowChars.set(include.WWWConst.$$$WWW122OnlyAllowChars(m$,YPRUEF));
    //<< if strAllowChars'="" {
    if (mOp.NotEqual(strAllowChars.get(),"")) {
      //<< for YPR1=1:1:$length(A) {
      mVar YPR1 = m$.var("YPR1");
      for (YPR1.set(1);(mOp.LessOrEqual(YPR1.get(),m$.Fnc.$length(A.get())));YPR1.set(mOp.Add(YPR1.get(),1))) {
        //<< set strTestChar = $extract(A,YPR1)
        strTestChar.set(m$.Fnc.$extract(A.get(),YPR1.get()));
        //<< 
        //<< if '$find(strAllowChars,strTestChar) {
        if (mOp.Not(m$.Fnc.$find(strAllowChars.get(),strTestChar.get()))) {
          //<< set ^WWWSOR(YUSER,$increment(YLFZ)) = YTEXT_": "_$$^WWWTEXT(269)_" "_strAllowChars_"|"
          m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",269))," "),strAllowChars.get()),"|"));
          //<< quit
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< ; "The following characters are not allowed"
    //<< ;---------------------------------------
    //<< set strBlockChars = $$$WWW122DDontAllowCharacters(objCustomData)
    strBlockChars.set(include.WWWConst.$$$WWW122DDontAllowCharacters(m$,objCustomData));
    //<< if strBlockChars="" set strBlockChars = $$$WWW122DontAllowChars(YPRUEF)
    if (mOp.Equal(strBlockChars.get(),"")) {
      strBlockChars.set(include.WWWConst.$$$WWW122DontAllowChars(m$,YPRUEF));
    }
    //<< for YPR1=1:1:$length(strBlockChars) {
    mVar YPR1 = m$.var("YPR1");
    for (YPR1.set(1);(mOp.LessOrEqual(YPR1.get(),m$.Fnc.$length(strBlockChars.get())));YPR1.set(mOp.Add(YPR1.get(),1))) {
      //<< set strTestChar = $extract(strBlockChars,YPR1)
      strTestChar.set(m$.Fnc.$extract(strBlockChars.get(),YPR1.get()));
      //<< continue:strTestChar=" "
      if (mOp.Equal(strTestChar.get()," ")) {
        continue;
      }
      //<< 
      //<< if A[strTestChar {
      if (mOp.Contains(A.get(),strTestChar.get())) {
        //<< set ^WWWSOR(YUSER,$increment(YLFZ)) = YTEXT_": "_$$^WWWTEXT(287)_" "_strBlockChars_"|"
        m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",287))," "),strBlockChars.get()),"|"));
        //<< quit
        break;
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; Fill with zeroes (max 15 leading zeros)
    //<< ; FIXME : Strings with leading digits will get zero fill, those with leading alpha will not <GRF>
    //<< ;---------------------------------------
    //<< if (+$$$WWW122ForceStringLengthTo(YPRUEF)'=0) && (+A'=0) {
    if ((mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW122ForceStringLengthTo(m$,YPRUEF)),0)) && (mOp.NotEqual(mOp.Positive(A.get()),0))) {
      //<< set A = $extract((1_$extract("000000000000000",1,+$$$WWW122ForceStringLengthTo(YPRUEF))+A),2,99)
      A.set(m$.Fnc.$extract((mOp.Add(mOp.Concat(1,m$.Fnc.$extract("000000000000000",1,mOp.Positive(include.WWWConst.$$$WWW122ForceStringLengthTo(m$,YPRUEF)))),A.get())),2,99));
    }
    //<< }
    //<< 
    //<< ; Character conversion
    //<< ;---------------------------------------
    //<< set idChangeInput = $$$WWW122ChangeInputAs(YPRUEF)
    idChangeInput.set(include.WWWConst.$$$WWW122ChangeInputAs(m$,YPRUEF));
    //<< IF +idChangeInput'=0 DO
    if (mOp.NotEqual(mOp.Positive(idChangeInput.get()),0)) {
      //<< . IF idChangeInput="1" SET A=$$$UPPER(A)
      if (mOp.Equal(idChangeInput.get(),"1")) {
        A.set(include.COMSYSString.$$$UPPER(m$,A));
      }
      //<< . IF idChangeInput="2" SET A=$$$LOWER(A)
      if (mOp.Equal(idChangeInput.get(),"2")) {
        A.set(include.COMSYSString.$$$LOWER(m$,A));
      }
      //<< . IF idChangeInput="3" DO
      if (mOp.Equal(idChangeInput.get(),"3")) {
        //<< . . SET YPR=A,A=""
        YPR.set(A.get());
        A.set("");
        //<< . . FOR YPR1=1:1 SET YPR2=$PIECE(YPR," ",YPR1) QUIT:$PIECE(YPR," ",YPR1,999)=""  SET A=A_$$$UPPER($EXTRACT(YPR2))_$$$LOWER($EXTRACT(YPR2,2,5000))_" "
        for (YPR1.set(1);(true);YPR1.set(mOp.Add(YPR1.get(),1))) {
          mVar YPR2 = m$.var("YPR2");
          YPR2.set(m$.Fnc.$piece(YPR.get()," ",YPR1.get()));
          if (mOp.Equal(m$.Fnc.$piece(YPR.get()," ",YPR1.get(),999),"")) {
            break;
          }
          A.set(mOp.Concat(mOp.Concat(mOp.Concat(A.get(),include.COMSYSString.$$$UPPER(m$,m$.Fnc.$extract(YPR2.get()))),include.COMSYSString.$$$LOWER(m$,m$.Fnc.$extract(YPR2.get(),2,5000)))," "));
        }
      }
      //<< . ;
      //<< . IF idChangeInput="4" DO
      if (mOp.Equal(idChangeInput.get(),"4")) {
        //<< . . SET YPR=A,A=""
        YPR.set(A.get());
        A.set("");
        //<< . . FOR YPR1=1:2 SET YPR2=$EXTRACT(YPR,YPR1,YPR1+1) QUIT:YPR2=""  SET:$EXTRACT(YPR2,2)'=" " YPR2=$EXTRACT(YPR2)_" "_$EXTRACT(YPR2,2)_" " SET A=A_YPR2
        for (YPR1.set(1);(true);YPR1.set(mOp.Add(YPR1.get(),2))) {
          mVar YPR2 = m$.var("YPR2");
          YPR2.set(m$.Fnc.$extract(YPR.get(),YPR1.get(),mOp.Add(YPR1.get(),1)));
          if (mOp.Equal(YPR2.get(),"")) {
            break;
          }
          if (mOp.NotEqual(m$.Fnc.$extract(YPR2.get(),2)," ")) {
            YPR2.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(YPR2.get())," "),m$.Fnc.$extract(YPR2.get(),2))," "));
          }
          A.set(mOp.Concat(A.get(),YPR2.get()));
        }
      }
      //<< . ;
      //<< . IF idChangeInput="5" SET A=$TRANSLATE(A," ")
      if (mOp.Equal(idChangeInput.get(),"5")) {
        A.set(m$.Fnc.$translate(A.get()," "));
      }
      //<< . IF idChangeInput="6" SET A=$TRANSLATE($zconvert(A,"U")," ")
      if (mOp.Equal(idChangeInput.get(),"6")) {
        A.set(m$.Fnc.$translate(m$.Fnc.$zconvert(A.get(),"U")," "));
      }
      //<< . IF idChangeInput="7" SET A=$TRANSLATE(A,"][\}{|~,()@#$%^&*_=+<>?/-.:´`§²³!°€µ")  ;OHNE SONDERZEICHEN;FIS;08.04.03/TYBD 10.06.2003 ;without special character
      if (mOp.Equal(idChangeInput.get(),"7")) {
        A.set(m$.Fnc.$translate(A.get(),"][\\}{|~,()@#$%^&*_=+<>?/-.:´`§²³!°€µ"));
      }
    }
    //<< 
    //<< 
    //<< ; SR17146 vvv
    //<< ; Check date
    //<< ;---------------------------------------
    //<< if (YTYP=1) && (A'="") set A = $$CheckDate(A,SPRACHE,YUSER,YTEXT,.YLFZ)
    if ((mOp.Equal(m$.var("YTYP").get(),1)) && (mOp.NotEqual(A.get(),""))) {
      A.set(m$.fnc$("CheckDate",A.get(),m$.var("SPRACHE").get(),m$.var("YUSER").get(),YTEXT.get(),m$.var("YLFZ")));
    }
    //<< 
    //<< /*
    //<< ; Check date     ; "Wrong Date", "Wrong Date Format"
    //<< ;---------------------------------------
    //<< IF YTYP=1 DO
    //<< . QUIT:A=""
    //<< . IF A="." SET A=$$^WWWDATE($HOROLOG)
    //<< . IF $EXTRACT(A)="-" IF +$EXTRACT(A,2,9)'=0 SET A=$$^WWWDATE($HOROLOG-$EXTRACT(A,2,9))
    //<< . IF $EXTRACT(A)="+" IF +$EXTRACT(A,2,9)'=0 SET A=$$^WWWDATE($HOROLOG+$EXTRACT(A,2,9))
    //<< . IF $LENGTH(A,".")=3 IF $LENGTH($PIECE(A,".",3))=2 IF $LENGTH(A)=8 DO     ; MM.DD.YY or DD.MM.YY
    //<< . . ; FIXME : $$^WWWDATE returns with FORMAT delimiter not "."
    //<< . . IF $EXTRACT(A,7,8)>25 SET A=$EXTRACT(A,1,2)_"."_$EXTRACT(A,4,5)_"."_$EXTRACT($PIECE($$^WWWDATE($HOROLOG),".",3),1,2)_$EXTRACT(A,7,8) QUIT
    //<< . . IF $EXTRACT(A,7,8)<26 SET A=$EXTRACT(A,1,2)_"."_$EXTRACT(A,4,5)_"."_20_$EXTRACT(A,7,8)  ; FIXME : Hardcoded to 20xx for first 25 years
    //<< . ;
    //<< . IF '$FIND(A,".") IF '$FIND(A,"/") IF $LENGTH(A)=8 SET A=$EXTRACT(A,1,2)_"."_$EXTRACT(A,3,4)_"."_$EXTRACT(A,5,8)
    //<< . IF A'="" SET YPR=$$^WWWDATE1(A) IF YPR=""                                       SET ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(271)_"|"
    //<< . IF SPRACHE="DE" IF A'="" IF '$FIND(A,"W") IF '$FIND(A,"w") IF $LENGTH(A,".")'=3 SET ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(272)_"|"
    //<< */
    //<< ; SR17146 ^^^
    //<< 
    //<< ; Time     ; "Wrong Time", "Wrong Time Format"
    //<< ;---------------------------------------
    //<< IF YTYP=7 DO
    if (mOp.Equal(m$.var("YTYP").get(),7)) {
      do {
        //<< . QUIT:A=""
        if (mOp.Equal(A.get(),"")) {
          break;
        }
        //<< . IF A="." SET A=$$^WWWTIME($HOROLOG)
        if (mOp.Equal(A.get(),".")) {
          A.set(m$.fnc$("WWWTIME.main",m$.Fnc.$horolog()));
        }
        //<< . IF A'="" IF '$FIND(A,":") DO
        if (mOp.NotEqual(A.get(),"")) {
          if (mOp.Not(m$.Fnc.$find(A.get(),":"))) {
            //<< . . IF $LENGTH(A)<3 SET A=+A_":00"
            if (mOp.Less(m$.Fnc.$length(A.get()),3)) {
              A.set(mOp.Concat(mOp.Positive(A.get()),":00"));
            }
            //<< . . IF $LENGTH(A)=3 SET A=+$EXTRACT(A)_":"_+$EXTRACT(A,2,3)
            if (mOp.Equal(m$.Fnc.$length(A.get()),3)) {
              A.set(mOp.Concat(mOp.Concat(mOp.Positive(m$.Fnc.$extract(A.get())),":"),mOp.Positive(m$.Fnc.$extract(A.get(),2,3))));
            }
            //<< . . IF $LENGTH(A)=4 SET A=+$EXTRACT(A,1,2)_":"_+$EXTRACT(A,3,4)
            if (mOp.Equal(m$.Fnc.$length(A.get()),4)) {
              A.set(mOp.Concat(mOp.Concat(mOp.Positive(m$.Fnc.$extract(A.get(),1,2)),":"),mOp.Positive(m$.Fnc.$extract(A.get(),3,4))));
            }
          }
        }
        //<< . ;
        //<< . IF A'="" SET YPR=$$^WWWTIME1(A) IF YPR=""       SET ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(273)_"|"
        if (mOp.NotEqual(A.get(),"")) {
          YPR.set(m$.fnc$("WWWTIME1.main",A.get()));
          if (mOp.Equal(YPR.get(),"")) {
            m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",273)),"|"));
          }
        }
        //<< . IF A'="" IF $LENGTH(A,":")<2&($LENGTH(A,".")<2) SET ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(274)_"|"
        if (mOp.NotEqual(A.get(),"")) {
          if (mOp.And(mOp.Less(m$.Fnc.$length(A.get(),":"),2),(mOp.Less(m$.Fnc.$length(A.get(),"."),2)))) {
            m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",274)),"|"));
          }
        }
      } while (false);
    }
    //<< 
    //<< ; Amount fields  "Wrong Amount"
    //<< ;---------------------------------------
    //<< IF (YTYP=8) || (YTYP=12) || (YTYP=18) DO
    if ((mOp.Equal(m$.var("YTYP").get(),8)) || (mOp.Equal(m$.var("YTYP").get(),12)) || (mOp.Equal(m$.var("YTYP").get(),18))) {
      //<< . NEW A1,B1,B2,Z
      mVar A1 = m$.var("A1");
      mVar B1 = m$.var("B1");
      mVar B2 = m$.var("B2");
      mVar Z = m$.var("Z");
      m$.newVarBlock(1,A1,B1,B2,Z);
      //<< . SET Z=0
      Z.set(0);
      //<< . DO:'$FIND(A,"@")  IF $FIND(A,"@") SET B1=$PIECE(A,"@",1) SET B2=$PIECE(A,"@",2) SET B3=$PIECE(A,"@",3) NEW A SET A=B1 DO  SET A=B2 DO  SET A=B3 DO  ;FIS;21.05.04;25727;FREMDWÄHRUNG
      if (mOp.Not(m$.Fnc.$find(A.get(),"@"))) {
        do {
        } while(false);
        m$.restoreVarBlock(2);
        if (mOp.Logical(m$.Fnc.$find(A.get(),"@"))) {
          B1.set(m$.Fnc.$piece(A.get(),"@",1));
          B2.set(m$.Fnc.$piece(A.get(),"@",2));
          m$.var("B3").set(m$.Fnc.$piece(A.get(),"@",3));
          m$.newVarBlock(2,A);
          A.set(B1.get());
          A.set(B2.get());
          do {
          } while(false);
          A.set(m$.var("B3").get());
          do {
            //<< . . new YYDECIMAL
            mVar YYDECIMAL = m$.var("YYDECIMAL");
            m$.newVarBlock(5,YYDECIMAL);
            //<< . . ;SR17807 set YYDECIMAL = $$GetFormat^INPARA(8,YDECIMAL)
            //<< . . set YYDECIMAL = $$GetFormat^WWW100(8,YDECIMAL)
            YYDECIMAL.set(m$.fnc$("WWW100.GetFormat",8,m$.var("YDECIMAL").get()));
            //<< . . set YYDECIMAL = $extract($translate(YYDECIMAL,"nNxX"),2)
            YYDECIMAL.set(m$.Fnc.$extract(m$.Fnc.$translate(YYDECIMAL.get(),"nNxX"),2));
            //<< . . IF YYDECIMAL="" SET YYDECIMAL = YDECIMAL
            if (mOp.Equal(YYDECIMAL.get(),"")) {
              YYDECIMAL.set(m$.var("YDECIMAL").get());
            }
            //<< . . IF $GET(YYDECIMAL)="," IF $LENGTH(A,",")>2 SET:Z=0 YLFZ=YLFZ+1 SET Z=1 SET ^WWWSOR(YUSER,YLFZ)=YTEXT_": "_$$^WWWTEXT(275)_" "_A_"|"
            if (mOp.Equal(m$.Fnc.$get(YYDECIMAL),",")) {
              if (mOp.Greater(m$.Fnc.$length(A.get(),","),2)) {
                if (mOp.Equal(Z.get(),0)) {
                  m$.var("YLFZ").set(mOp.Add(m$.var("YLFZ").get(),1));
                }
                Z.set(1);
                m$.var("^WWWSOR",m$.var("YUSER").get(),m$.var("YLFZ").get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",275))," "),A.get()),"|"));
              }
            }
            //<< . . IF $GET(YYDECIMAL)="." IF $LENGTH(A,".")>2 SET:Z=0 YLFZ=YLFZ+1 SET Z=1 SET ^WWWSOR(YUSER,YLFZ)=YTEXT_": "_$$^WWWTEXT(275)_" "_A_"|"
            if (mOp.Equal(m$.Fnc.$get(YYDECIMAL),".")) {
              if (mOp.Greater(m$.Fnc.$length(A.get(),"."),2)) {
                if (mOp.Equal(Z.get(),0)) {
                  m$.var("YLFZ").set(mOp.Add(m$.var("YLFZ").get(),1));
                }
                Z.set(1);
                m$.var("^WWWSOR",m$.var("YUSER").get(),m$.var("YLFZ").get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",275))," "),A.get()),"|"));
              }
            }
          } while(false);
          m$.restoreVarBlock(5);
        }
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< ; Pattern Match  "Wrong Input Format"
    //<< ;---------------------------------------
    //<< IF $$$WWW122PatternMatch(YPRUEF)'="" SET YPR=$$$WWW122PatternMatch(YPRUEF) IF A?@YPR=0 SET ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(276)_"|"
    if (mOp.NotEqual(include.WWWConst.$$$WWW122PatternMatch(m$,YPRUEF),"")) {
      YPR.set(include.WWWConst.$$$WWW122PatternMatch(m$,YPRUEF));
      if (mOp.Equal(mOp.Match(A.get(),m$.indirectVar("YPR").get()),0)) {
        m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",276)),"|"));
      }
    }
    //<< 
    //<< ;VARIABLE ZUWEISEN ;assign to variable
    //<< SET $PIECE(YFELD,Y,YI)=$$GetInternal^WWWTR(YTYP,A)
    m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),m$.var("YI").get()).set(m$.fnc$("WWWTR.GetInternal",m$.var("YTYP").get(),A.get()));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CheckDate(pstrDate,pidLanguage,YUSER,pstrText,&pintSeq)
  public Object CheckDate(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLanguage = m$.newVarRef("pidLanguage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YUSER = m$.newVarRef("YUSER",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pintSeq = m$.newVarRef("pintSeq",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert possible incomplete literal date to the standard literal format and
    //<< ; check that this will result in a valid date
    //<< ;
    //<< ; History:
    //<< ; 31-May-2010   GRF     SR17146: extracted from PRUEFD as common correction for
    //<< ;                           WWWSAVD, WWWSAVM, WWWSAVP
    //<< ;-------------------------------------------------------------------------------
    //<< new dteInternal,strDelim,strFormat
    mVar dteInternal = m$.var("dteInternal");
    mVar strDelim = m$.var("strDelim");
    mVar strFormat = m$.var("strFormat");
    m$.newVar(dteInternal,strDelim,strFormat);
    //<< 
    //<< do GetDateFormat^COMUtilLocale(.strFormat,.strDelim,SPRACHE)
    m$.Cmd.Do("COMUtilLocale.GetDateFormat",strFormat,strDelim,m$.var("SPRACHE").get());
    //<< 
    //<< do LitToStdLit^WWWDATE1(.pstrDate,SPRACHE)
    m$.Cmd.Do("WWWDATE1.LitToStdLit",pstrDate,m$.var("SPRACHE").get());
    //<< 
    //<< if (pstrDate'="") && ($$StdLitToInt^WWWDATE1(pstrDate,strFormat,strDelim)="") {
    if ((mOp.NotEqual(pstrDate.get(),"")) && (mOp.Equal(m$.fnc$("WWWDATE1.StdLitToInt",pstrDate.get(),strFormat.get(),strDelim.get()),""))) {
      //<< set ^WWWSOR(YUSER,$increment(pintSeq)) = pstrText_": "_$$^WWWTEXT(271)_"|"
      m$.var("^WWWSOR",YUSER.get(),m$.Fnc.$increment(pintSeq)).set(mOp.Concat(mOp.Concat(mOp.Concat(pstrText.get(),": "),m$.fnc$("WWWTEXT.main",271)),"|"));
    }
    //<< } ; "Wrong Date"
    //<< 
    //<< quit pstrDate
    return pstrDate.get();
  }

  //<< 
  //<< 
  //<< Validate(pidClass,pidForm,pidField,&pstrValue,pblnDisplay=$$$NO,pstrData)
  public Object Validate(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnDisplay = m$.newVarRef("pblnDisplay",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    mVar pstrData = m$.newVarRef("pstrData",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Validation of data piece
    //<< ;
    //<< ; Called By : WWWFORMValidation, PRUEFD^WWWSAVD
    //<< ;
    //<< ; Params:   pidClass    - class id
    //<< ;           pidForm     - form id
    //<< ;           pidField    - data field number (WWW003)
    //<< ;           pblnDisplay - whether pstrValue is display value (or storage)
    //<< ;           pstrData    - YFELD
    //<< ;
    //<< ; ByRefs:   pstrValue   - field value, can be set to null
    //<< ;           YOPTION
    //<< ;           YOPTION1
    //<< ;
    //<< ; Returns:  status - whether there is a problem
    //<< ;
    //<< ; History:
    //<< ; 02-Jul-2013   SCR         CORE-86: Pass id & obj to $$ValidRelation^WWWFieldValidation
    //<< ; 06-Nov-2008   shobby      SR16123:    Standardised routine to determine InputType
    //<< ; 22-Jan-2008   heber       SRBR014794: fix byref parameter
    //<< ; 12-Nov-2007   shobby      SRBR014737: If idType can't be found from the form use the class.
    //<< ; 26-Nov-2007   GM/Shobby   SRBR014737: Get values from $$get^WWW122()
    //<< ; 06-Sep-2007   shobby      SRBR014638: Simplified the mandatory determination.
    //<< ; 29-Sep-2006   HeberB      SRBR014265: Added YFELD as param to Validate
    //<< ;                           Checking if mandatory field defined WWW122D2
    //<< ; 24-Aug-2006   JW          SR14939: Wrong variable used
    //<< ; 08-Aug-2006   JW          SR13594: Created (encapsulated)
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,objField,strReason,blnMandatory,strYOPTION,strYOPTION1,blnNull
    mVar strStatus = m$.var("strStatus");
    mVar objField = m$.var("objField");
    mVar strReason = m$.var("strReason");
    mVar blnMandatory = m$.var("blnMandatory");
    mVar strYOPTION = m$.var("strYOPTION");
    mVar strYOPTION1 = m$.var("strYOPTION1");
    mVar blnNull = m$.var("blnNull");
    m$.newVar(strStatus,objField,strReason,blnMandatory,strYOPTION,strYOPTION1,blnNull);
    //<< new strIn,strOut,idType,idFormField
    mVar strIn = m$.var("strIn");
    mVar strOut = m$.var("strOut");
    mVar idType = m$.var("idType");
    mVar idFormField = m$.var("idFormField");
    m$.newVar(strIn,strOut,idType,idFormField);
    //<< 
    //<< $$$LogR("Validate",pidClass_"<"_pidForm_"<"_pidField_"<"_$get(pstrValue))
    $$$LogR(m$,"Validate",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidClass.get(),"<"),pidForm.get()),"<"),pidField.get()),"<"),m$.Fnc.$get(pstrValue)));
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idFormField = $order(^WWW122s(0,4,pidField,pidForm,""))
    idFormField.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,pidField.get(),pidForm.get(),"")));
    //<< set idType = $$GetInputType^WWWSAVE(pidClass,pidField,pidForm)
    idType.set(m$.fnc$("WWWSAVE.GetInputType",pidClass.get(),pidField.get(),pidForm.get()));
    //<< 
    //<< set strIn = $select(pblnDisplay:$$GetInternal^WWWTR(idType,pstrValue),1:pstrValue)
    strIn.set(m$.Fnc.$select(pblnDisplay.get(),m$.fnc$("WWWTR.GetInternal",idType.get(),pstrValue.get()),1,pstrValue.get()));
    //<< ;if '$$ValidRelation^WWWFieldValidation("D",pidClass,pidForm,pidField,strIn,$$$NO,.strReason) {
    //<< if '$$ValidRelation^WWWFieldValidation("D",pidClass,pidForm,pidField,strIn,$$$NO,.strReason,YKEY,pstrData) { ; CORE-86
    if (mOp.Not(m$.fnc$("WWWFieldValidation.ValidRelation","D",pidClass.get(),pidForm.get(),pidField.get(),strIn.get(),include.COMSYS.$$$NO(m$),strReason,m$.var("YKEY").get(),pstrData.get()))) {
      //<< 
      //<< if $get(strReason)="" {
      if (mOp.Equal(m$.Fnc.$get(strReason),"")) {
        //<< set strOut    = $select(pblnDisplay:pstrValue,1:$$GetLiteral^WWWTR(idType,pstrValue))
        strOut.set(m$.Fnc.$select(pblnDisplay.get(),pstrValue.get(),1,m$.fnc$("WWWTR.GetLiteral",idType.get(),pstrValue.get())));
        //<< set strReason = $listbuild("WWW00028",strOut)       ; "´%1´ is invalid"
        strReason.set(m$.Fnc.$listbuild("WWW00028",strOut.get()));
      }
      //<< }
      //<< $$$LogRx("V1:"_$get(strReason))
      $$$LogRx(m$,mOp.Concat("V1:",m$.Fnc.$get(strReason)));
      //<< set pstrValue = ""  ; Clear field if not valid
      pstrValue.set("");
    }
    //<< }
    //<< 
    //<< if (pstrValue="") && (idType'=2) {
    if ((mOp.Equal(pstrValue.get(),"")) && (mOp.NotEqual(idType.get(),2))) {
      //<< if idFormField'="" {
      if (mOp.NotEqual(idFormField.get(),"")) {
        //<< set objField = $get(^WWW122(0,pidForm,idFormField,1))
        objField.set(m$.Fnc.$get(m$.var("^WWW122",0,pidForm.get(),idFormField.get(),1)));
        //<< 
        //<< ; Caution:  CheckRules does conditional checks based on pstrData,
        //<< ;           $$$WWW122D2MandatoryField(objRule) won't be enough <shobby> (don't need to pass pstrData further up)
        //<< do CheckRules^WWWFORMD(pidForm,idFormField,.pstrData,"","","",.blnMandatory)
        m$.Cmd.Do("WWWFORMD.CheckRules",pidForm.get(),idFormField.get(),pstrData,"","","",blnMandatory);
        //<< 
        //<< if blnMandatory {
        if (mOp.Logical(blnMandatory.get())) {
          //<< set strYOPTION  = $$$WWW122OnlyShowIfOptionYOPTION(objField)
          strYOPTION.set(include.WWWConst.$$$WWW122OnlyShowIfOptionYOPTION(m$,objField));
          //<< set strYOPTION1 = $$$WWW122OnlyShowIfOptionYOPTION1(objField)
          strYOPTION1.set(include.WWWConst.$$$WWW122OnlyShowIfOptionYOPTION1(m$,objField));
          //<< set blnNull     = $$$NO
          blnNull.set(include.COMSYS.$$$NO(m$));
          //<< 
          //<< if strYOPTION'="" {
          if (mOp.NotEqual(strYOPTION.get(),"")) {
            //<< if $find(","_strYOPTION_",",","_$get(YOPTION)_",")   set blnNull = $$$YES
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",strYOPTION.get()),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$get(m$.var("YOPTION"))),",")))) {
              blnNull.set(include.COMSYS.$$$YES(m$));
            }
          }
          //<< 
          //<< } elseif strYOPTION1'="" {
          else if (mOp.NotEqual(strYOPTION1.get(),"")) {
            //<< if $find(","_strYOPTION1_",",","_$get(YOPTION1)_",") set blnNull = $$$YES
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",strYOPTION1.get()),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$get(m$.var("YOPTION1"))),",")))) {
              blnNull.set(include.COMSYS.$$$YES(m$));
            }
          }
          //<< 
          //<< } else {
          else {
            //<< set blnNull = $$$YES
            blnNull.set(include.COMSYS.$$$YES(m$));
          }
          //<< }
          //<< 
          //<< if blnNull {
          if (mOp.Logical(blnNull.get())) {
            //<< set strStatus = $select(strReason="":$listbuild(267),1:strReason)      ; "Mandatory Field"
            strStatus.set(m$.Fnc.$select(mOp.Equal(strReason.get(),""),m$.Fnc.$listbuild(267),1,strReason.get()));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
//<< 
}
