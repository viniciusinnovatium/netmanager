//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSAVP
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-10 14:55:16
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
//<< #include WWWConst
import include.WWWConst;
//import COMSYS;

//<< WWWSAVP
public class WWWSAVP extends mClass {

  public void main() {
    _WWWSAVP();
  }

  public void _WWWSAVP() {
    PRUEFP();
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Description of Function :
  //<< ;       Check Form Key
  //<< ;       PRUEFEN PRIMÄRSCHLUESSEL
  //<< ;
  //<< ; NOTE: Keys YKEY(YI) are in external (display) format
  //<< ;
  //<< ; History :
  //<< ; 01-Jun-2010   GRF     SR17146: Call common code for Dates
  //<< ; 20-Oct-2008   GRF     SR12505: Corrections to OnlyAllowChars test; Recognise
  //<< ;                           WWW121D
  //<< ; 20-Aug-2007   GM      SR13729: Change "FELDFORMAT" parameter to $$GetFormat^INPARA()
  //<< ; 15-Mar-2007   GRF     SR12505: Implement code for $$$WWW121DontAllowChars;
  //<< ;                           Naked References; use YTYP, idChangeInput
  //<< ; 13-Mar-2007   GRF     SR12505: Doco; expand commands; remove unneeded +; &&
  //<< ;                           rather than &.
  //<< ; 24-Mar-2006   JW      SR14422: Change to internal format
  //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
  //<< ; 25-Jul-2005   JW      SR12615: Relation validation
  //<< ; 30-May-2005   RobertW SR12056: Attempt at Performance Increase
  //<< ; 27.09.1999    DT
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< PRUEFP
  public void PRUEFP() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Check keys    ; PRUEFEN PRIMÄRSCHLUESSEL
    //<< ;
    //<< ; Called By : WWWSAVE, COMUtilStr
    //<< ;
    //<< ; Inputs :
    //<< ;   poldYFELD       No longer used
    //<< ;
    //<< ; ByRef :
    //<< ;   YI          Key Number
    //<< ;   YTYP        Input Type            ERFASSUNGSTYP     ^WWW002 D3
    //<< ;   YKEY(YI)    String list of keys   PRIMAERSCHLUESSEL
    //<< ;   YALLKEY
    //<< ;   YLFZ
    //<< ; History
    //<< ; 09-Aug-2011   shobby  SR17807: GetFormat has moved.
    //<< ;-------------------------------------------------------------------------------
    //<< new A,idChangeInput,internalA,objCustomData,Q,strAllowChars,strBlockChars,strTestChar
    mVar A = m$.var("A");
    mVar idChangeInput = m$.var("idChangeInput");
    mVar internalA = m$.var("internalA");
    mVar objCustomData = m$.var("objCustomData");
    mVar Q = m$.var("Q");
    mVar strAllowChars = m$.var("strAllowChars");
    mVar strBlockChars = m$.var("strBlockChars");
    mVar strTestChar = m$.var("strTestChar");
    m$.newVar(A,idChangeInput,internalA,objCustomData,Q,strAllowChars,strBlockChars,strTestChar);
    //<< new YPR,YPR1,YPR2,YPRUEF,YTEXT
    mVar YPR = m$.var("YPR");
    mVar YPR1 = m$.var("YPR1");
    mVar YPR2 = m$.var("YPR2");
    mVar YPRUEF = m$.var("YPRUEF");
    mVar YTEXT = m$.var("YTEXT");
    m$.newVar(YPR,YPR1,YPR2,YPRUEF,YTEXT);
    //<< 
    //<< QUIT:$GET(YALLKEY)=9
    if (mOp.Equal(m$.Fnc.$get(m$.var("YALLKEY")),9)) {
      return;
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
    //<< SET YTEXT = $PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,2)
    YTEXT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YI").get(),1)),m$.var("Y").get(),2));
    //<< IF $DATA(^WWW0021(0,YDATEI,YI,SPRACHE,1)) SET YTEXT = $PIECE($get(^WWW0021(0,YDATEI,YI,SPRACHE,1)),Y,1)
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0021",0,m$.var("YDATEI").get(),m$.var("YI").get(),m$.var("SPRACHE").get(),1)))) {
      YTEXT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0021",0,m$.var("YDATEI").get(),m$.var("YI").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
    }
    //<< 
    //<< set A             = $get(YKEY(YI))
    A.set(m$.Fnc.$get(m$.var("YKEY").var(m$.var("YI").get())));
    //<< set YPRUEF        = $get(^WWW121(0,YFORM,YI,1))
    YPRUEF.set(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),m$.var("YI").get(),1)));
    //<< set objCustomData = $get(^WWW121D(0,YFORM,YI,YM,1))
    objCustomData.set(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YI").get(),m$.var("YM").get(),1)));
    //<< 
    //<< //set A = $zstrip(A,"<>W")      TODO - strip leading AND trailing spaces - anything else ?
    //<< ;                                      If do strip trailing space, can amend the next test which translates spaces to nulls before testing
    //<< 
    //<< ; Counter (InputType 9) - next number
    //<< ;---------------------------------------
    //<< IF ($EXTRACT($TRANSLATE(A," "))="+")||(($$$WWW121AutomaticSequenceCounter(YPRUEF)=$$$YES)&&(A=""))||((YTYP=9)&&(A="")) DO
    if ((mOp.Equal(m$.Fnc.$extract(m$.Fnc.$translate(A.get()," ")),"+")) || mOp.Logical(((mOp.Equal(include.WWWConst.$$$WWW121AutomaticSequenceCounter(m$,YPRUEF),include.COMSYS.$$$YES(m$))) && (mOp.Equal(A.get(),"")))) || mOp.Logical(((mOp.Equal(m$.var("YTYP").get(),9)) && (mOp.Equal(A.get(),""))))) {
      do {
        //<< . IF $EXTRACT(A,2,99)'="" IF $DATA(^WWW001(0,$EXTRACT(A,2,99))) SET A=$$^WWWNEXT($EXTRACT(A,2,99)) QUIT  ;TYBD;7,1,2004;ANDERER VORGABE IN DER DATEI DER LFD NUMMER
        if (mOp.NotEqual(m$.Fnc.$extract(A.get(),2,99),"")) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW001",0,m$.Fnc.$extract(A.get(),2,99))))) {
            A.set(m$.fnc$("WWWNEXT.main",m$.Fnc.$extract(A.get(),2,99)));
            break;
          }
        }
        //<< . IF YI'=1 quit:$TRANSLATE(YFKEY,",")=""  SET A=$$^WWWNEXT1(YDATEI,YFKEY,YI) QUIT
        if (mOp.NotEqual(m$.var("YI").get(),1)) {
          if (mOp.Equal(m$.Fnc.$translate(m$.var("YFKEY").get(),","),"")) {
            break;
          }
          A.set(m$.fnc$("WWWNEXT1.main",m$.var("YDATEI").get(),m$.var("YFKEY").get(),m$.var("YI").get()));
          break;
        }
        //<< . ;IF (YI'=1)&&('$data(^WWW128(0,YDATEI))) QUIT:$TRANSLATE(YFKEY,",")=""  SET A=$$^WWWNEXT1(YDATEI,YFKEY,YI) QUIT
        //<< . SET A=$$^WWWNEXT(YDATEI)
        A.set(m$.fnc$("WWWNEXT.main",m$.var("YDATEI").get()));
      } while (false);
    }
    //<< 
    //<< ;NÄCHSTER DATENSATZ ;data record
    //<< IF YTYP=9 IF $EXTRACT(A)="+" DO
    if (mOp.Equal(m$.var("YTYP").get(),9)) {
      if (mOp.Equal(m$.Fnc.$extract(A.get()),"+")) {
        do {
          //<< . IF $EXTRACT(A,2,99)'="" IF $DATA(^WWW001(0,$EXTRACT(A,2,99))) SET A=$$^WWWNEXT($EXTRACT(A,2,99)) QUIT  ;TYBD;7,1,2004;ANDERER VORGABE IN DER DATEI DER LFD NUMMER
          if (mOp.NotEqual(m$.Fnc.$extract(A.get(),2,99),"")) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW001",0,m$.Fnc.$extract(A.get(),2,99))))) {
              A.set(m$.fnc$("WWWNEXT.main",m$.Fnc.$extract(A.get(),2,99)));
              break;
            }
          }
          //<< . IF A'="+" QUIT
          if (mOp.NotEqual(A.get(),"+")) {
            break;
          }
          //<< . SET A=$$^WWWNEXT(YDATEI)
          A.set(m$.fnc$("WWWNEXT.main",m$.var("YDATEI").get()));
        } while (false);
      }
    }
    //<< 
    //<< IF A="+" SET A=" "      // TODO - remove this
    if (mOp.Equal(A.get(),"+")) {
      A.set(" ");
    }
    //<< ;---------------------------------------
    //<< 
    //<< ; Valid Relation, Mandatory Checks
    //<< ;---------------------------------------
    //<< set strStatus = $$Validate(YDATEI,YFORM,YI,.A,$$$YES)
    mVar strStatus = m$.var("strStatus");
    strStatus.set(m$.fnc$("Validate",m$.var("YDATEI").get(),m$.var("YFORM").get(),m$.var("YI").get(),A,include.COMSYS.$$$YES(m$)));
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set A = ""              ; Clear field if not valid
      A.set("");
      //<< SET ^WWWSOR(YUSER,$increment(YLFZ)) = YTEXT_": "_$$$Text(strStatus)_"|"
      m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),include.COMSYS.$$$Text(m$,strStatus)),"|"));
    }
    //<< }
    //<< 
    //<< ; "Min. Input Length"
    //<< ;---------------------------------------
    //<< if (+$$$WWW121MinInputLength(YPRUEF)'=0) && ($length(A)<$$$WWW121MinInputLength(YPRUEF)) {
    if ((mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW121MinInputLength(m$,YPRUEF)),0)) && (mOp.Less(m$.Fnc.$length(A.get()),include.WWWConst.$$$WWW121MinInputLength(m$,YPRUEF)))) {
      //<< set ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(268)_" "_+$$$WWW121MinInputLength(YPRUEF)_"|"
      m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",268))," "),mOp.Positive(include.WWWConst.$$$WWW121MinInputLength(m$,YPRUEF))),"|"));
    }
    //<< }
    //<< 
    //<< ; "Only Following Characters Allowed"
    //<< ;---------------------------------------
    //<< set strAllowChars = $$$WWW121OnlyAllowChars(YPRUEF)
    strAllowChars.set(include.WWWConst.$$$WWW121OnlyAllowChars(m$,YPRUEF));
    //<< if strAllowChars'="" {
    if (mOp.NotEqual(strAllowChars.get(),"")) {
      //<< for YPR1=1:1:$length(A) {
      for (YPR1.set(1);(mOp.LessOrEqual(YPR1.get(),m$.Fnc.$length(A.get())));YPR1.set(mOp.Add(YPR1.get(),1))) {
        //<< set strTestChar = $extract(A,YPR1)
        strTestChar.set(m$.Fnc.$extract(A.get(),YPR1.get()));
        //<< 
        //<< if '$find(strAllowChars,strTestChar) {
        if (mOp.Not(m$.Fnc.$find(strAllowChars.get(),strTestChar.get()))) {
          //<< set ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(269)_" "_strAllowChars_"|"
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
    //<< set strBlockChars = $$$WWW121DDontAllowCharacters(objCustomData)
    strBlockChars.set(include.WWWConst.$$$WWW121DDontAllowCharacters(m$,objCustomData));
    //<< if strBlockChars="" set strBlockChars = $$$WWW121DontAllowChars(YPRUEF)
    if (mOp.Equal(strBlockChars.get(),"")) {
      strBlockChars.set(include.WWWConst.$$$WWW121DontAllowChars(m$,YPRUEF));
    }
    //<< for YPR1=1:1:$length(strBlockChars) {
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
    //<< IF +$$$WWW121ForceStringLengthTo(YPRUEF)'=0 IF +A'=0 SET A=$EXTRACT((1_$EXTRACT("000000000000000",1,$$$WWW121ForceStringLengthTo(YPRUEF))+A),2,99)     ; SR12505
    if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW121ForceStringLengthTo(m$,YPRUEF)),0)) {
      if (mOp.NotEqual(mOp.Positive(A.get()),0)) {
        A.set(m$.Fnc.$extract((mOp.Add(mOp.Concat(1,m$.Fnc.$extract("000000000000000",1,include.WWWConst.$$$WWW121ForceStringLengthTo(m$,YPRUEF))),A.get())),2,99));
      }
    }
    //<< 
    //<< ; Character conversion
    //<< ;---------------------------------------
    //<< set idChangeInput = $$$WWW121ChangeInputAs(YPRUEF)
    idChangeInput.set(include.WWWConst.$$$WWW121ChangeInputAs(m$,YPRUEF));
    //<< IF +$$$WWW121ChangeInputAs(YPRUEF)'=0 DO
    if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW121ChangeInputAs(m$,YPRUEF)),0)) {
      //<< . IF idChangeInput="1" SET A = $$$UPPER(A)
      if (mOp.Equal(idChangeInput.get(),"1")) {
        A.set(include.COMSYSString.$$$UPPER(m$,A));
      }
      //<< . IF idChangeInput="2" SET A = $$$LOWER(A)
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
        //<< . . FOR YPR1=1:2 SET YPR2=$EXTRACT(YPR,YPR1,YPR1+1) QUIT:YPR2=""  SET:$EXTRACT(YPR2,2)'=" " YPR2=$EXTRACT(YPR2)_" "_$EXTRACT(YPR2,2) SET A=A_YPR2
        for (YPR1.set(1);(true);YPR1.set(mOp.Add(YPR1.get(),2))) {
          YPR2.set(m$.Fnc.$extract(YPR.get(),YPR1.get(),mOp.Add(YPR1.get(),1)));
          if (mOp.Equal(YPR2.get(),"")) {
            break;
          }
          if (mOp.NotEqual(m$.Fnc.$extract(YPR2.get(),2)," ")) {
            YPR2.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(YPR2.get())," "),m$.Fnc.$extract(YPR2.get(),2)));
          }
          A.set(mOp.Concat(A.get(),YPR2.get()));
        }
      }
      //<< . ;
      //<< . IF idChangeInput="5" SET A=$TRANSLATE(A," ")                                     ;LEER ;void
      if (mOp.Equal(idChangeInput.get(),"5")) {
        A.set(m$.Fnc.$translate(A.get()," "));
      }
      //<< . IF idChangeInput="6" SET A=$TRANSLATE($$^WWWUMLAU(A,3)," ")                      ;GROß UND OHNE LEER ;macro- And without void
      if (mOp.Equal(idChangeInput.get(),"6")) {
        A.set(m$.Fnc.$translate(m$.fnc$("WWWUMLAU.main",A.get(),3)," "));
      }
      //<< . IF idChangeInput="7" SET A=$TRANSLATE(A,"][\}{|~,()@#$%^&*_=+<>?/-.:´`§²³!°€µ")  ;OHNE SONDERZEICHEN;FIS;08.04.03/TYBD ;without special character
      if (mOp.Equal(idChangeInput.get(),"7")) {
        A.set(m$.Fnc.$translate(A.get(),"][\\}{|~,()@#$%^&*_=+<>?/-.:´`§²³!°€µ"));
      }
    }
    //<< 
    //<< 
    //<< ; SR17146 vvv
    //<< ; Check date
    //<< ;---------------------------------------
    //<< if (YTYP=1) set A = $$CheckDate^WWWSAVD(A,SPRACHE,YUSER,YTEXT,.YLFZ)
    if ((mOp.Equal(m$.var("YTYP").get(),1))) {
      A.set(m$.fnc$("WWWSAVD.CheckDate",A.get(),m$.var("SPRACHE").get(),m$.var("YUSER").get(),YTEXT.get(),m$.var("YLFZ")));
    }
    //<< 
    //<< /*
    //<< ; Check date     ; "Wrong Date", "Wrong Date Format"
    //<< ;---------------------------------------
    //<< IF YTYP=1 DO
    //<< . IF A="." SET A=$$^WWWDATE($HOROLOG)
    //<< . IF $EXTRACT(A)="-" IF +$EXTRACT(A,2,9)'=0 SET A = $$^WWWDATE($HOROLOG-$EXTRACT(A,2,9))
    //<< . IF $EXTRACT(A)="+" IF +$EXTRACT(A,2,9)'=0 SET A = $$^WWWDATE($HOROLOG+$EXTRACT(A,2,9))
    //<< . IF $LENGTH(A,".")=3 IF $LENGTH($PIECE(A,".",3))=2 IF $LENGTH(A)=8 DO
    //<< . . IF $EXTRACT(A,7,8)>25 SET A=$EXTRACT(A,1,2)_"."_$EXTRACT(A,4,5)_"."_$EXTRACT($PIECE($$^WWWDATE($HOROLOG),".",3),1,2)_$EXTRACT(A,7,8) QUIT
    //<< . . IF $EXTRACT(A,7,8)<26 SET A=$EXTRACT(A,1,2)_"."_$EXTRACT(A,4,5)_"."_20_$EXTRACT(A,7,8)
    //<< . ;
    //<< . IF '$FIND(A,".") IF '$FIND(A,"/") IF $LENGTH(A)=8 SET A=$EXTRACT(A,1,2)_"."_$EXTRACT(A,3,4)_"."_$EXTRACT(A,5,8)
    //<< . IF A'="" SET YPR=$$^WWWDATE1(A) IF YPR=""                                       SET ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(271)_"|"
    //<< . IF SPRACHE="DE" IF A'="" IF '$FIND(A,"W") IF '$FIND(A,"w") IF $LENGTH(A,".")'=3 SET ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(272)_A_"|"
    //<< */
    //<< ; SR17146 ^^^
    //<< 
    //<< ; Time     ; "Wrong Time", "Wrong Time Format"
    //<< ;---------------------------------------
    //<< IF YTYP=7 DO
    if (mOp.Equal(m$.var("YTYP").get(),7)) {
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
      //<< . IF A="." SET A=$$^WWWTIME($HOROLOG)
      if (mOp.Equal(A.get(),".")) {
        A.set(m$.fnc$("WWWTIME.main",m$.Fnc.$horolog()));
      }
      //<< . IF A'="" SET YPR=$$^WWWTIME1(A) IF YPR=""          SET ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(273)_"|"
      if (mOp.NotEqual(A.get(),"")) {
        YPR.set(m$.fnc$("WWWTIME1.main",A.get()));
        if (mOp.Equal(YPR.get(),"")) {
          m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",273)),"|"));
        }
      }
      //<< . IF A'="" IF ($LENGTH(A,":")<2)&&($LENGTH(A,".")<2) SET ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(274)_"|"
      if (mOp.NotEqual(A.get(),"")) {
        if ((mOp.Less(m$.Fnc.$length(A.get(),":"),2)) && (mOp.Less(m$.Fnc.$length(A.get(),"."),2))) {
          m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",274)),"|"));
        }
      }
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
            //<< . . set YYDECIMAL = $$GetFormat^WWW100(8,YDECIMAL)          ;SR17807
            YYDECIMAL.set(m$.fnc$("WWW100.GetFormat",8,m$.var("YDECIMAL").get()));
            //<< . . set YYDECIMAL = $extract($translate(YYDECIMAL,"nNxX"),2)
            YYDECIMAL.set(m$.Fnc.$extract(m$.Fnc.$translate(YYDECIMAL.get(),"nNxX"),2));
            //<< . . IF YYDECIMAL="" SET YYDECIMAL=YDECIMAL
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
    //<< IF $$$WWW121Patternmatch(YPRUEF)'="" SET YPR=$$$WWW121Patternmatch(YPRUEF) IF A?@YPR=0 SET ^WWWSOR(YUSER,$increment(YLFZ))=YTEXT_": "_$$^WWWTEXT(276)_"|"
    if (mOp.NotEqual(include.WWWConst.$$$WWW121Patternmatch(m$,YPRUEF),"")) {
      YPR.set(include.WWWConst.$$$WWW121Patternmatch(m$,YPRUEF));
      if (mOp.Equal(mOp.Match(A.get(),m$.indirectVar("YPR").get()),0)) {
        m$.var("^WWWSOR",m$.var("YUSER").get(),m$.Fnc.$increment(m$.var("YLFZ"))).set(mOp.Concat(mOp.Concat(mOp.Concat(YTEXT.get(),": "),m$.fnc$("WWWTEXT.main",276)),"|"));
      }
    }
    //<< 
    //<< IF $DATA(^WWWSOR(YUSER)) SET YKFEHL=1
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get())))) {
      mVar YKFEHL = m$.var("YKFEHL");
      YKFEHL.set(1);
    }
    //<< 
    //<< ; Explicit character conversion in keys
    //<< ;---------------------------------------
    //<< SET YKEY(YI)=$TRANSLATE(A,"%","/")
    mVar YKEY = m$.var("YKEY");
    YKEY.var(m$.var("YI").get()).set(m$.Fnc.$translate(A.get(),"%","/"));
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< Validate(pidClass,pidForm,pidField,&pstrValue,pblnDisplay=$$$NO)
  public Object Validate(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnDisplay = m$.newVarRef("pblnDisplay",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Validation of key part
    //<< ;
    //<< ; Called By : WWWFORMValidation, PRUEFP^WWWSAVP
    //<< ;
    //<< ; Params:   pidClass    - class id
    //<< ;           pidForm     - form id
    //<< ;           pidField    - data field number (WWW003)
    //<< ;           pblnDisplay - whether pstrValue is display value (or storage)
    //<< ;
    //<< ; ByRefs:   pstrValue   - key value, can be set to null
    //<< ;
    //<< ; Returns:  status - whether there is a problem
    //<< ;
    //<< ; History:
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
    //<< ; 08-Aug-2006   JW      SR13594: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,objField,strReason,strIn,strOut,idType
    mVar strStatus = m$.var("strStatus");
    mVar objField = m$.var("objField");
    mVar strReason = m$.var("strReason");
    mVar strIn = m$.var("strIn");
    mVar strOut = m$.var("strOut");
    mVar idType = m$.var("idType");
    m$.newVar(strStatus,objField,strReason,strIn,strOut,idType);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set objField  = $get(^WWW122(0,pidForm,pidField,1))
    objField.set(m$.Fnc.$get(m$.var("^WWW122",0,pidForm.get(),pidField.get(),1)));
    //<< set idType    = $$$WWW122InputType(objField)
    idType.set(include.WWWConst.$$$WWW122InputType(m$,objField));
    //<< 
    //<< set strIn = $select(pblnDisplay:$$GetInternal^WWWTR(idType,pstrValue),1:pstrValue)
    strIn.set(m$.Fnc.$select(pblnDisplay.get(),m$.fnc$("WWWTR.GetInternal",idType.get(),pstrValue.get()),1,pstrValue.get()));
    //<< 
    //<< if '$$ValidRelation^WWWFieldValidation("P",pidClass,pidForm,pidField,strIn,$$$NO,.strReason) {
    if (mOp.Not(m$.fnc$("WWWFieldValidation.ValidRelation","P",pidClass.get(),pidForm.get(),pidField.get(),strIn.get(),include.COMSYS.$$$NO(m$),strReason))) {
      //<< if $get(strReason)="" {
      if (mOp.Equal(m$.Fnc.$get(strReason),"")) {
        //<< set strOut    = $select(pblnDisplay:pstrValue,1:$$GetLiteral^WWWTR(idType,pstrValue))
        strOut.set(m$.Fnc.$select(pblnDisplay.get(),pstrValue.get(),1,m$.fnc$("WWWTR.GetLiteral",idType.get(),pstrValue.get())));
        //<< set strReason = $listbuild("WWW00028",strOut)                      ; "´%1´ is invalid"
        strReason.set(m$.Fnc.$listbuild("WWW00028",strOut.get()));
      }
      //<< }
      //<< set pstrValue = ""  ; Clear field if not valid
      pstrValue.set("");
    }
    //<< }
    //<< 
    //<< if pstrValue="" {
    if (mOp.Equal(pstrValue.get(),"")) {
      //<< set strStatus = $select(strReason="":$listbuild(278),1:strReason)      ; "No Primary Key"
      strStatus.set(m$.Fnc.$select(mOp.Equal(strReason.get(),""),m$.Fnc.$listbuild(278),1,strReason.get()));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
//<< 
}
