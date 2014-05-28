//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWDATE1
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:25
//*****************************************************************************

import mLibrary.*;

//<< ;WWWDATE1(YA) ; Original
//<< ;WWWDATE1(YA,pstrFormat="DD.MM.YYYY")   ; proposal to handle hardcoded calls for first/last day based on this format independantly of user parameters
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

//<< WWWDATE1(YA,pstrFormat="") ; defaults to use GetDateFormat^COMUtilLocale
public class WWWDATE1 extends mClass {

  //<< #define IncrementFactor 0.00001
  public static Object $$$IncrementFactor(mContext m$) {
    return (0.00001);
  }

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
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

  public Object main(Object ... _p) {
    mVar YA = m$.newVarRef("YA",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrFormat = m$.newVarRef("pstrFormat",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    return _WWWDATE1(YA,pstrFormat);
  }

  public Object _WWWDATE1(Object ... _p) {
    mVar YA = m$.newVarRef("YA",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrFormat = m$.newVarRef("pstrFormat",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWDATE1("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Convert Date to Horolog format
    //<< ;       ANZEIGEN $H AUS DATUM
    //<< ;
    //<< ; Inputs :
    //<< ;   expects  dd.mm.yyyy                  [hardcoded calls - ignore FELDFORMAT]
    //<< ;            dd/mm/yyyy or mm/dd/yyyy    [based on "FELDFORMAT" setting]
    //<< ;            yyyy-mm-dd or yyyymmdd
    //<< ;            +$h (5 digits)              [allows ., +n, -n converted values to be accepted]
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 01-Jun-2010   GRF     SR17146: Common functions - restore call to LitToInt;
    //<< ;                           Expand parameters (though not used yet for override)
    //<< ; 22-Feb-2010   shobby  SR17162: Included YM in NEW(...) command
    //<< ; 07-May-2009   GRF     SR16522: Revised to cover YYYYMMDD, YYYY/MM/DD
    //<< ; 13-Jun-2007   GRF     SR15525: Naked Reference; braces; !=>||; doco; comment
    //<< ;                           duplicated tests
    //<< ; 01-Jun-2007   GRF     Expand commands; quits
    //<< ; 24-Mar-2006   JW      SR14422: Allow counter on date
    //<< ; 07-Apr-2005   Paul K  Year was not defaulting correctly if > 25. Modified
    //<< ;                           to sliding scale.
    //<< ;               PJK     SR10644: DD.MM or DD.MM.YY => DD.MM.YYYY
    //<< ; 30.07.1997    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new (pstrFormat,SPRACHE,Y,YA,YBED,YM)              ; FIXME : <GRF> Exclusive new is very inefficient.  ;SR17162
    mVar SPRACHE = m$.var("SPRACHE");
    mVar Y = m$.var("Y");
    mVar YBED = m$.var("YBED");
    mVar YM = m$.var("YM");
    m$.newVarExcept(pstrFormat,SPRACHE,Y,YA,YBED,YM);
    //<< quit $$LitToInt(YA,pstrFormat)           ; SR16522   ; SR17146
    return m$.fnc$("LitToInt",YA.get(),pstrFormat.get());
  }

  //<< 
  //<< ; vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv Replaces code
  //<< old(YA)
  public Object old(Object ... _p) {
    mVar YA = m$.newVarRef("YA",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< NEW (YA,SPRACHE,Y,YBED,YM)              ; FIXME : <GRF> Exclusive new is very inefficient.  ;SR17162
    mVar SPRACHE = m$.var("SPRACHE");
    mVar Y = m$.var("Y");
    mVar YBED = m$.var("YBED");
    mVar YM = m$.var("YM");
    m$.newVarExcept(YA,SPRACHE,Y,YBED,YM);
    //<< 
    //<< // display counter A.0000B as A (B)
    //<< set YB = ""
    mVar YB = m$.var("YB");
    YB.set("");
    //<< if $find($get(YA),"(") {
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$get(YA),"("))) {
      //<< set YB = $piece(YA,"(",2) * $$$IncrementFactor   ;$$GetIncrementFactor()
      YB.set(mOp.Multiply(m$.Fnc.$piece(YA.get(),"(",2),$$$IncrementFactor(m$)));
      //<< set YA = $piece(YA," ",1)
      YA.set(m$.Fnc.$piece(YA.get()," ",1));
    }
    //<< }
    //<< 
    //<< SET YKW = 0
    mVar YKW = m$.var("YKW");
    YKW.set(0);
    //<< SET A   = $GET(YA)
    mVar A = m$.var("A");
    A.set(m$.Fnc.$get(YA));
    //<< 
    //<< ; YYYY-MM-DD => DD.MM.YYYY
    //<< if $find(A,"-") && ($length($piece(A," ",1)=10)) {
    if (mOp.Logical(m$.Fnc.$find(A.get(),"-")) && mOp.Logical((m$.Fnc.$length(mOp.Equal(m$.Fnc.$piece(A.get()," ",1),10))))) {
      //<< set A = $piece(A," ",1)
      A.set(m$.Fnc.$piece(A.get()," ",1));
      //<< if ($length($piece(A,"-",1))=4) && ($length($piece(A,"-",2))=2) && ($length($piece(A,"-",3))=2) {
      if ((mOp.Equal(m$.Fnc.$length(m$.Fnc.$piece(A.get(),"-",1)),4)) && (mOp.Equal(m$.Fnc.$length(m$.Fnc.$piece(A.get(),"-",2)),2)) && (mOp.Equal(m$.Fnc.$length(m$.Fnc.$piece(A.get(),"-",3)),2))) {
        //<< set A = $piece(A,"-",3)_"."_$piece(A,"-",2)_"."_$piece(A,"-",1)
        A.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(A.get(),"-",3),"."),m$.Fnc.$piece(A.get(),"-",2)),"."),m$.Fnc.$piece(A.get(),"-",1)));
      }
      //<< }
      //<< set YA = A
      YA.set(A.get());
    }
    //<< }
    //<< 
    //<< SET A = $TRANSLATE($GET(A)," |")
    A.set(m$.Fnc.$translate(m$.Fnc.$get(A)," |"));
    //<< 
    //<< IF YA="." SET A = +$HOROLOG
    if (mOp.Equal(YA.get(),".")) {
      A.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< IF YA="" QUIT ""
    if (mOp.Equal(YA.get(),"")) {
      return "";
    }
    //<< 
    //<< ; w23 (Monday of week 23) => DD/MM/YYYY (or DD.MM.YYYY based on SPRACHE)
    //<< IF $FIND(A,"W") || $FIND(A,"w") SET YKW=1 SET A=$$^WWWWEEK1(A)  ;WOCHE IN DATUM ;week within Date
    if (mOp.Logical(m$.Fnc.$find(A.get(),"W")) || mOp.Logical(m$.Fnc.$find(A.get(),"w"))) {
      YKW.set(1);
      A.set(m$.fnc$("WWWWEEK1.main",A.get()));
    }
    //<< 
    //<< ; YYYYMMDD => DD.MM.YYYY
    //<< IF $LENGTH(+A)=8 IF A=+A SET A = $EXTRACT(A,7,8)_"."_$EXTRACT(A,5,6)_"."_$EXTRACT(A,1,4) SET YA = A   ;FALSCHES FORMAT;TYBD;21,08,2003
    if (mOp.Equal(m$.Fnc.$length(mOp.Positive(A.get())),8)) {
      if (mOp.Equal(A.get(),mOp.Positive(A.get()))) {
        A.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(A.get(),7,8),"."),m$.Fnc.$extract(A.get(),5,6)),"."),m$.Fnc.$extract(A.get(),1,4)));
        YA.set(A.get());
      }
    }
    //<< 
    //<< ; +$h rather than DD/MM which gets current year appended
    //<< IF ($LENGTH($PIECE(A,",",1))=5) && '($FIND(YA,".") || $FIND(YA,"/")) QUIT A   ;BEC;26815;19.11.04;FALSCHES FORMAT
    if ((mOp.Equal(m$.Fnc.$length(m$.Fnc.$piece(A.get(),",",1)),5)) && mOp.Not((mOp.Logical(m$.Fnc.$find(YA.get(),".")) || mOp.Logical(m$.Fnc.$find(YA.get(),"/"))))) {
      return A.get();
    }
    //<< 
    //<< IF $FIND(YA,".") || $FIND(YA,"/") DO START
    if (mOp.Logical(m$.Fnc.$find(YA.get(),".")) || mOp.Logical(m$.Fnc.$find(YA.get(),"/"))) {
      m$.Cmd.Do("START");
    }
    //<< IF YA=A SET A = ""
    if (mOp.Equal(YA.get(),A.get())) {
      A.set("");
    }
    //<< SET YA = A
    YA.set(A.get());
    //<< IF YKW=1 SET YA = YA_".1"      ; FIXME : This returns DD/MM/YYYY.1 (or similar) rather than $horolog format; *ONLY* for week input
    if (mOp.Equal(YKW.get(),1)) {
      YA.set(mOp.Concat(YA.get(),".1"));
    }
    //<< 
    //<< QUIT YA_YB
    return mOp.Concat(YA.get(),YB.get());
  }

  //<< 
  //<< 
  //<< START
  public void START() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 09-Aug-2011   shobby  SR17807: GetFormat has moved.
    //<< ; 20-Aug-2007   GM      SR13729: Change "FELDFORMAT" parameter to $$GetFormat^INPARA()
    //<< ; 20-Jul-2005   JW      SR12807: Changed 1800 to 1841
    //<< ;-------------------------------------------------------------------------------
    //<< IF '$DATA(Y) DO ^WWWVORG
    if (mOp.Not(m$.Fnc.$data(m$.var("Y")))) {
      m$.Cmd.Do("WWWVORG.main");
    }
    //<< 
    //<< if (A'="") && $find(A,"/") {
    if ((mOp.NotEqual(m$.var("A").get(),"")) && mOp.Logical(m$.Fnc.$find(m$.var("A").get(),"/"))) {
      //<< IF $GET(Y)="" SET Y = "~"
      if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
        mVar Y = m$.var("Y");
        Y.set("~");
      }
      //<< ;SR1807 SET FORMAT = $$GetFormat^INPARA(1,"DD.MM.YYYY")      ; FIXME : use GetDateFormat^COMUtilLocale ?
      //<< SET FORMAT = $$GetFormat^WWW100(1,"DD.MM.YYYY")      ; FIXME : use GetDateFormat^COMUtilLocale ? ;SR1807
      mVar FORMAT = m$.var("FORMAT");
      FORMAT.set(m$.fnc$("WWW100.GetFormat",1,"DD.MM.YYYY"));
      //<< 
      //<< IF ($EXTRACT(FORMAT)="D") || ($EXTRACT(FORMAT)="T") SET A=$TRANSLATE(A,"/",".")
      if ((mOp.Equal(m$.Fnc.$extract(FORMAT.get()),"D")) || (mOp.Equal(m$.Fnc.$extract(FORMAT.get()),"T"))) {
        mVar A = m$.var("A");
        A.set(m$.Fnc.$translate(m$.var("A").get(),"/","."));
      }
    }
    //<< }
    //<< 
    //<< SET A = $TRANSLATE(A," ;,_+:=()\!`´~|#'*°^<>§$%&"_"""")
    mVar A = m$.var("A");
    A.set(m$.Fnc.$translate(m$.var("A").get(),mOp.Concat(" ;,_+:=()\\!`´~|#'*°^<>§$%&","\"")));
    //<< 
    //<< IF A'="" {
    if (mOp.NotEqual(A.get(),"")) {
      //<< ;   YYYY-MM-DD => DD.MM.YYYY (already done above?)
      //<< IF $FIND(A,"-") IF $LENGTH($PIECE(A,"-",1))=4 SET A=$PIECE(A,"-",3)_"."_$PIECE(A,"-",2)_"."_$PIECE(A,"-",1)
      if (mOp.Logical(m$.Fnc.$find(A.get(),"-"))) {
        if (mOp.Equal(m$.Fnc.$length(m$.Fnc.$piece(A.get(),"-",1)),4)) {
          A.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(A.get(),"-",3),"."),m$.Fnc.$piece(A.get(),"-",2)),"."),m$.Fnc.$piece(A.get(),"-",1)));
        }
      }
      //<< IF $FIND(A,"-") SET A=$TRANSLATE(A,"-",".")
      if (mOp.Logical(m$.Fnc.$find(A.get(),"-"))) {
        A.set(m$.Fnc.$translate(A.get(),"-","."));
      }
      //<< 
      //<< ;   MM/DD/YYYY => DD.MM.YYYY
      //<< IF $FIND(A,"/") SET A=$PIECE(A,"/",2)_"."_$PIECE(A,"/",1)_"."_$PIECE(A,"/",3)
      if (mOp.Logical(m$.Fnc.$find(A.get(),"/"))) {
        A.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(A.get(),"/",2),"."),m$.Fnc.$piece(A.get(),"/",1)),"."),m$.Fnc.$piece(A.get(),"/",3)));
      }
    }
    //<< }
    //<< 
    //<< ; DD.MM or DD.MM.YY => DD.MM.YYYY
    //<< IF $LENGTH($PIECE(A,".",3))<3 SET $PIECE(A,".",3) = $$GETYEAR($PIECE(A,".",3))
    if (mOp.Less(m$.Fnc.$length(m$.Fnc.$piece(A.get(),".",3)),3)) {
      m$.pieceVar(A,".",3).set(m$.fnc$("GETYEAR",m$.Fnc.$piece(A.get(),".",3)));
    }
    //<< 
    //<< ; check *.MM.YYYY and not extra pieces
    //<< IF $LENGTH($PIECE(A,".",3))'=2 IF $LENGTH($PIECE(A,".",3))'=4 SET A="" QUIT  ;FALSCHES DATUM ;Date
    if (mOp.NotEqual(m$.Fnc.$length(m$.Fnc.$piece(A.get(),".",3)),2)) {
      if (mOp.NotEqual(m$.Fnc.$length(m$.Fnc.$piece(A.get(),".",3)),4)) {
        A.set("");
        return;
      }
    }
    //<< IF $LENGTH(A,".")>3   SET A="" QUIT
    if (mOp.Greater(m$.Fnc.$length(A.get(),"."),3)) {
      A.set("");
      return;
    }
    //<< 
    //<< ; Month Check
    //<< IF $PIECE(A,".",2)>12 SET A="" QUIT
    if (mOp.Greater(m$.Fnc.$piece(A.get(),".",2),12)) {
      A.set("");
      return;
    }
    //<< IF $PIECE(A,".",2)<1  SET A="" QUIT
    if (mOp.Less(m$.Fnc.$piece(A.get(),".",2),1)) {
      A.set("");
      return;
    }
    //<< 
    //<< ; Date Check
    //<< IF $PIECE(A,".",1)<1  SET A="" QUIT
    if (mOp.Less(m$.Fnc.$piece(A.get(),".",1),1)) {
      A.set("");
      return;
    }
    //<< IF $FIND(",1,3,5,7,8,10,12,",","_+$PIECE(A,".",2)_",") IF $PIECE(A,".",1)>31 SET A="" QUIT
    if (mOp.Logical(m$.Fnc.$find(",1,3,5,7,8,10,12,",mOp.Concat(mOp.Concat(",",mOp.Positive(m$.Fnc.$piece(A.get(),".",2))),",")))) {
      if (mOp.Greater(m$.Fnc.$piece(A.get(),".",1),31)) {
        A.set("");
        return;
      }
    }
    //<< IF $FIND(",4,6,9,11,",","_+$PIECE(A,".",2)_",")        IF $PIECE(A,".",1)>30 SET A="" QUIT
    if (mOp.Logical(m$.Fnc.$find(",4,6,9,11,",mOp.Concat(mOp.Concat(",",mOp.Positive(m$.Fnc.$piece(A.get(),".",2))),",")))) {
      if (mOp.Greater(m$.Fnc.$piece(A.get(),".",1),30)) {
        A.set("");
        return;
      }
    }
    //<< 
    //<< SET A(1)=29
    A.var(1).set(29);
    //<< IF +$PIECE(A,".",2)=2 DO
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(A.get(),".",2)),2)) {
      do {
        //<< . IF $PIECE(A,".",3)#4   SET A(1)=28 QUIT
        if (mOp.Logical(mOp.Modulus(m$.Fnc.$piece(A.get(),".",3),4))) {
          A.var(1).set(28);
          break;
        }
        //<< . IF $PIECE(A,".",3)#100 SET A(1)=29 QUIT
        if (mOp.Logical(mOp.Modulus(m$.Fnc.$piece(A.get(),".",3),100))) {
          A.var(1).set(29);
          break;
        }
        //<< . IF $PIECE(A,".",3)#400 SET A(1)=28
        if (mOp.Logical(mOp.Modulus(m$.Fnc.$piece(A.get(),".",3),400))) {
          A.var(1).set(28);
        }
      } while (false);
    }
    //<< 
    //<< IF +$PIECE(A,".",2)=2 IF $PIECE(A,".",1)>A(1) SET A="" QUIT
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(A.get(),".",2)),2)) {
      if (mOp.Greater(m$.Fnc.$piece(A.get(),".",1),A.var(1).get())) {
        A.set("");
        return;
      }
    }
    //<< 
    //<< ; Year Check
    //<< IF $PIECE(A,".",3)<1841 SET A="" QUIT
    if (mOp.Less(m$.Fnc.$piece(A.get(),".",3),1841)) {
      A.set("");
      return;
    }
    //<< IF $PIECE(A,".",3)>2201 SET A="" QUIT
    if (mOp.Greater(m$.Fnc.$piece(A.get(),".",3),2201)) {
      A.set("");
      return;
    }
    //<< 
    //<< SET A = $zdateh(+$PIECE(A,".",2)_"/"_+$PIECE(A,".",1)_"/"_+$PIECE(A,".",3))    ; uses MM/DD/YYYY
    A.set(m$.Fnc.$zdateh(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Positive(m$.Fnc.$piece(A.get(),".",2)),"/"),mOp.Positive(m$.Fnc.$piece(A.get(),".",1))),"/"),mOp.Positive(m$.Fnc.$piece(A.get(),".",3)))));
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< DMY(pstrDate="")
  public Object DMY(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper replacing all calls for WWWDATE1 where date string is in set format
    //<< ; rather than complying with system FELDFORMAT setting.
    //<< ;
    //<< ; History :
    //<< ; 03-Jun-2010   GRF     SR17146: Rewritten with common functions
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$LitToInt(pstrDate,"DD.MM.YYYY")
    return m$.fnc$("LitToInt",pstrDate.get(),"DD.MM.YYYY");
  }

  //<< 
  //<< 
  //<< LitToInt(pstrDate="",pstrFormat="")
  public Object LitToInt(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrFormat = m$.newVarRef("pstrFormat",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;       Convert Date to Horolog format
    //<< ;
    //<< ; History :
    //<< ; 01-Jun-2010   GRF     SR17146: Rewritten with common functions
    //<< ;-------------------------------------------------------------------------------
    //<< new dteInternal,strDelim
    mVar dteInternal = m$.var("dteInternal");
    mVar strDelim = m$.var("strDelim");
    m$.newVar(dteInternal,strDelim);
    //<< $$$LogR("LitToInt",">"_pstrDate_"<"_pstrFormat_"<")
    $$$LogR(m$,"LitToInt",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(">",pstrDate.get()),"<"),pstrFormat.get()),"<"));
    //<< 
    //<< if '$data(Y) do GetBasics(.SPRACHE,.Y,.YBED,.YM)
    if (mOp.Not(m$.Fnc.$data(m$.var("Y")))) {
      m$.Cmd.Do("GetBasics",m$.var("SPRACHE"),m$.var("Y"),m$.var("YBED"),m$.var("YM"));
    }
    //<< if pstrFormat="" {
    if (mOp.Equal(pstrFormat.get(),"")) {
      //<< do GetDateFormat^COMUtilLocale(.pstrFormat,.strDelim,SPRACHE)
      m$.Cmd.Do("COMUtilLocale.GetDateFormat",pstrFormat,strDelim,m$.var("SPRACHE").get());
    }
    //<< } else {
    else {
      //<< set strDelim = $extract($translate(pstrFormat,"DMY"),1)
      strDelim.set(m$.Fnc.$extract(m$.Fnc.$translate(pstrFormat.get(),"DMY"),1));
    }
    //<< }
    //<< 
    //<< do LitToStdLit(.pstrDate,SPRACHE,pstrFormat)
    m$.Cmd.Do("LitToStdLit",pstrDate,m$.var("SPRACHE").get(),pstrFormat.get());
    //<< $$$LogRx("L2I:"_pstrDate_"<")
    $$$LogRx(m$,mOp.Concat(mOp.Concat("L2I:",pstrDate.get()),"<"));
    //<< set dteInternal = $$StdLitToInt(pstrDate,pstrFormat,strDelim)
    dteInternal.set(m$.fnc$("StdLitToInt",pstrDate.get(),pstrFormat.get(),strDelim.get()));
    //<< 
    //<< quit dteInternal
    return dteInternal.get();
  }

  //<< 
  //<< 
  //<< GetBasics(&SPRACHE,&Y,&YBED,&YM)
  public Object GetBasics(Object ... _p) {
    mVar SPRACHE = m$.newVarRef("SPRACHE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Y = m$.newVarRef("Y",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YBED = m$.newVarRef("YBED",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YM = m$.newVarRef("YM",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper to restrict variable override - only called when necessary
    //<< ;
    //<< ; History :
    //<< ; 07-May-2009   GRF     SR16522: Revised to cover YYYYMMDD, YYYY/MM/DD
    //<< ;-------------------------------------------------------------------------------
    //<< new (SPRACHE,Y,YBED,YM)
    m$.newVarExcept(SPRACHE,Y,YBED,YM);
    //<< do ^WWWVORG
    m$.Cmd.Do("WWWVORG.main");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< LitToStdLit(&pstrDate="",pidLocale="",pstrFormat="")
  public Object LitToStdLit(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidLocale = m$.newVarRef("pidLocale",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrFormat = m$.newVarRef("pstrFormat",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Convert possibly Incomplete Literal Date to Standard Literal Date
    //<< ;   (StdLitDate matches format returned from GetDateFormat^COMUtilLocale)
    //<< ;
    //<< ;   eg MM.DD.YYYY, MM/DD/YY, MM/DD, MMDDYY, MMDD, DD, etc all => MM/DD/YYYY
    //<< ;
    //<< ;   If no year is specified, uses current year but interpret near future or past
    //<< ;       (subtract 1 Year)   Nov/Dec <==> Jan/Feb   (add 1 Year)
    //<< ;
    //<< ;   Doesn't recognise YYYYDDMM or YYYY/DD/MM sequences - treats as YYYYMMDD or YYYY/MM/DD
    //<< ;
    //<< ;
    //<< ; Inputs :
    //<< ;   pstrDate  - Initial Date String - Returns revised Date String byRef
    //<< ;   pidLocale - Locale used to specify standard format (initially Language)
    //<< ;    Input
    //<< ;   Date            dd/mm/yyyy, mm/dd/yyyy, yyyy/mm/dd, yyyymmdd
    //<< ;                   (permit other delimiters or some partial entry)
    //<< ;   Date (Counter)  xx/xx/xxxx (n)
    //<< ;   Week Number     Wn or nW                (=> Monday starting week)
    //<< ;                   Wnn.yyyy or nn.yyyyW
    //<< ;   Day of *THIS* week  "mo", "tu", etc.   (Limited use - must be 2 characters in EN/DE/ES - not PT)
    //<< ;   Horolog         recognised though unlikely to be entered
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 11-Jun-2010   GRF     SR17146: Basic "+" or "-" interpretation to function as
    //<< ;                           it was with previous WWWTR.  Note: +$H becomes today
    //<< ;                           because it equates to +0 not because of any
    //<< ;                           interpretation of the $horolog part of the input
    //<< ;                           string.  +$H-7 would also equate to +0.
    //<< ; 01-Jun-2010   GRF     SR17146: Created as common function; add day-of-week
    //<< ;                           name & DD entry from WWWFieldRules
    //<< ;-------------------------------------------------------------------------------
    //<< new arrDate,dteToday,intCentury,intCounter,intDayofWeek,intThisMonth,intSDLength,intToday
    mVar arrDate = m$.var("arrDate");
    mVar dteToday = m$.var("dteToday");
    mVar intCentury = m$.var("intCentury");
    mVar intCounter = m$.var("intCounter");
    mVar intDayofWeek = m$.var("intDayofWeek");
    mVar intThisMonth = m$.var("intThisMonth");
    mVar intSDLength = m$.var("intSDLength");
    mVar intToday = m$.var("intToday");
    m$.newVar(arrDate,dteToday,intCentury,intCounter,intDayofWeek,intThisMonth,intSDLength,intToday);
    //<< new loop,strDelim,strDelimUsed,strToday,strType,strXlateIn,strXlateOut
    mVar loop = m$.var("loop");
    mVar strDelim = m$.var("strDelim");
    mVar strDelimUsed = m$.var("strDelimUsed");
    mVar strToday = m$.var("strToday");
    mVar strType = m$.var("strType");
    mVar strXlateIn = m$.var("strXlateIn");
    mVar strXlateOut = m$.var("strXlateOut");
    m$.newVar(loop,strDelim,strDelimUsed,strToday,strType,strXlateIn,strXlateOut);
    //<< 
    //<< if $get(SPRACHE)="" set SPRACHE = $$^WWWLANGU(YBED)
    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"")) {
      mVar SPRACHE = m$.var("SPRACHE");
      SPRACHE.set(m$.fnc$("WWWLANGU.main",m$.var("YBED").get()));
    }
    //<< if pidLocale="" set pidLocale = SPRACHE  ; simplify later conversion to true locale
    if (mOp.Equal(pidLocale.get(),"")) {
      pidLocale.set(m$.var("SPRACHE").get());
    }
    //<< 
    //<< if pstrFormat="" {
    if (mOp.Equal(pstrFormat.get(),"")) {
      //<< do GetDateFormat^COMUtilLocale(.pstrFormat,.strDelim,pidLocale)
      m$.Cmd.Do("COMUtilLocale.GetDateFormat",pstrFormat,strDelim,pidLocale.get());
    }
    //<< } else {
    else {
      //<< set strDelim = $extract($translate(pstrFormat,"DMY"),1)
      strDelim.set(m$.Fnc.$extract(m$.Fnc.$translate(pstrFormat.get(),"DMY"),1));
    }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ; Extract date & counter from "DD/MM/YYYY (B)" or similar
    //<< ;     eventually becomes HHHHH.0000B e.g. 65000.00001
    //<< ;---------------------------------------
    //<< set intCounter = ""
    intCounter.set("");
    //<< if $find(pstrDate,"(") {
    if (mOp.Logical(m$.Fnc.$find(pstrDate.get(),"("))) {
      //<< set intCounter = +$piece(pstrDate,"(",2)
      intCounter.set(mOp.Positive(m$.Fnc.$piece(pstrDate.get(),"(",2)));
      //<< set pstrDate   =  $piece(pstrDate," ",1)
      pstrDate.set(m$.Fnc.$piece(pstrDate.get()," ",1));
    }
    //<< }
    //<< set pstrDate = $translate(pstrDate," |")
    pstrDate.set(m$.Fnc.$translate(pstrDate.get()," |"));
    //<< set dteToday = +$horolog
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< ;---------------------------------------
    //<< ; Offset shortcuts - today, past, future, Monday of week
    //<< ;---------------------------------------
    //<< if pstrDate="." {
    if (mOp.Equal(pstrDate.get(),".")) {
      //<< set pstrDate = $$^WWWDATE(dteToday)
      pstrDate.set(m$.fnc$("WWWDATE.main",dteToday.get()));
    }
    //<< 
    //<< } elseif $extract(pstrDate)="-" {
    else if (mOp.Equal(m$.Fnc.$extract(pstrDate.get()),"-")) {
      //<< set pstrDate = $$^WWWDATE(dteToday-$extract(pstrDate,2,9))   ; 11-Jun-2010
      pstrDate.set(m$.fnc$("WWWDATE.main",mOp.Subtract(dteToday.get(),m$.Fnc.$extract(pstrDate.get(),2,9))));
    }
    //<< ;   if +$extract(pstrDate,2,9)'=0 set pstrDate = $$^WWWDATE(dteToday-$extract(pstrDate,2,9))
    //<< ;   if $length(pstrDate)=1        set pstrDate = $$^WWWDATE(dteToday)    ; "-" alone => "."
    //<< ;   if pstrDate="-0"              set pstrDate = $$^WWWDATE(dteToday)
    //<< 
    //<< } elseif $extract(pstrDate)="+" {
    else if (mOp.Equal(m$.Fnc.$extract(pstrDate.get()),"+")) {
      //<< set pstrDate = $$^WWWDATE(dteToday+$extract(pstrDate,2,9))   ; 11-Jun-2010
      pstrDate.set(m$.fnc$("WWWDATE.main",mOp.Add(dteToday.get(),m$.Fnc.$extract(pstrDate.get(),2,9))));
    }
    //<< ;   if +$extract(pstrDate,2,9)'=0 set pstrDate = $$^WWWDATE(dteToday+$extract(pstrDate,2,9))
    //<< ;   if $length(pstrDate)=1        set pstrDate = $$^WWWDATE(dteToday)
    //<< ;   if pstrDate="+0"              set pstrDate = $$^WWWDATE(dteToday)    ; "+" alone => "."
    //<< 
    //<< } elseif $find(pstrDate,"W") || $find(pstrDate,"w") {            ; Week
    else if (mOp.Logical(m$.Fnc.$find(pstrDate.get(),"W")) || mOp.Logical(m$.Fnc.$find(pstrDate.get(),"w"))) {
      //<< set pstrDate = $$^WWWWEEK1(pstrDate)
      pstrDate.set(m$.fnc$("WWWWEEK1.main",pstrDate.get()));
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; 2 char day of week (mo,tu,we,...,su) case insensitive
    //<< ;
    //<< ; NOTE : Only available in DE, EN, ES.  "PT" requires 3 chars for uniqueness
    //<< ;
    //<< ; FIXME :  Must be 2 chars "Mo" not "Mon"; "PT" missed
    //<< ;---------------------------------------
    //<< } elseif pstrDate?2A {                                      ;
    else if (mOp.Match(pstrDate.get(),"2A")) {
      //<< set intDayofWeek = $order(^WWW101s(0,1,$$$Index(pstrDate),"COMDAYSOFWEEKSHORT",SPRACHE,""))
      intDayofWeek.set(m$.Fnc.$order(m$.var("^WWW101s",0,1,include.MEDConst.$$$Index(m$,pstrDate),"COMDAYSOFWEEKSHORT",m$.var("SPRACHE").get(),"")));
      //<< if intDayofWeek'="" {
      if (mOp.NotEqual(intDayofWeek.get(),"")) {
        //<< set intToday = $$$DayOfWeek(dteToday)
        intToday.set(include.COMSYSDate.$$$DayOfWeek(m$,dteToday));
        //<< set pstrDate = $$^WWWDATE(dteToday - intToday + intDayofWeek)  ; +$h for corresponding day of *THIS* week Mon-Sun
        pstrDate.set(m$.fnc$("WWWDATE.main",mOp.Add(mOp.Subtract(dteToday.get(),intToday.get()),intDayofWeek.get())));
      }
    }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ; Internal format - +$horolog, $horolog
    //<< ;---------------------------------------
    //<< } elseif ($length(pstrDate)=5) && (pstrDate=+pstrDate) {
    else if ((mOp.Equal(m$.Fnc.$length(pstrDate.get()),5)) && (mOp.Equal(pstrDate.get(),mOp.Positive(pstrDate.get())))) {
      //<< set pstrDate = $$^WWWDATE(pstrDate)
      pstrDate.set(m$.fnc$("WWWDATE.main",pstrDate.get()));
    }
    //<< 
    //<< } elseif ($length(pstrDate\1)=5) && ($extract(pstrDate,1,5)=(pstrDate\1)) {
    else if ((mOp.Equal(m$.Fnc.$length(mOp.IntegerDivide(pstrDate.get(),1)),5)) && (mOp.Equal(m$.Fnc.$extract(pstrDate.get(),1,5),(mOp.IntegerDivide(pstrDate.get(),1))))) {
      //<< set pstrDate = $$^WWWDATE(pstrDate\1)
      pstrDate.set(m$.fnc$("WWWDATE.main",mOp.IntegerDivide(pstrDate.get(),1)));
    }
    //<< 
    //<< } else {
    else {
      //<< ;---------------------------------------
      //<< ; Any initial delimiter converted to standard delimiter (strDelim may be null)
      //<< ;---------------------------------------
      //<< set strXlateIn  = "`~!@#$%^&*()-_=+:;.,<>/\|'´°§"_""""
      strXlateIn.set(mOp.Concat("`~!@#$%^&*()-_=+:;.,<>/\\|'´°§","\""));
      //<< set strXlateOut = $translate($justify("",$length(strXlateIn))," ",strDelim)  ; string of delimiters
      strXlateOut.set(m$.Fnc.$translate(m$.Fnc.$justify("",m$.Fnc.$length(strXlateIn.get()))," ",strDelim.get()));
      //<< set pstrDate    = $translate(pstrDate,strXlateIn,strXlateOut)
      pstrDate.set(m$.Fnc.$translate(pstrDate.get(),strXlateIn.get(),strXlateOut.get()));
      //<< $$$LogRx("l2sl:1:"_pstrDate_"<"_pstrFormat_"<"_strDelim_"<")
      $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("l2sl:1:",pstrDate.get()),"<"),pstrFormat.get()),"<"),strDelim.get()),"<"));
      //<< 
      //<< ;---------------------------------------
      //<< ; No delimiter : YYYYMMDD => std format
      //<< ;   or
      //<< ; Entered without required delimiter (shown as / in comments - could be other)
      //<< ;---------------------------------------
      //<< kill arrDate
      arrDate.kill();
      //<< set intSDLength = $length(pstrDate)
      intSDLength.set(m$.Fnc.$length(pstrDate.get()));
      //<< 
      //<< ;   if (strDelim="") || '$find(pstrDate,strDelim) {
      //<< if (pstrDate?1.N) {
      if ((mOp.Match(pstrDate.get(),"1.N"))) {
        //<< if (intSDLength=8) {
        if ((mOp.Equal(intSDLength.get(),8))) {
          //<< $$$LogRx("l2sl:path 1-8")
          $$$LogRx(m$,"l2sl:path 1-8");
          //<< if $extract(pstrFormat,1) = "Y" {                    ; YYYYMMDD (Japan, etc.)
          if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"Y")) {
            //<< set arrDate("Y") = $extract(pstrDate,1,4)        ; YYYY/MM/DD (China?)
            arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),1,4));
            //<< set arrDate("M") = $extract(pstrDate,5,6)
            arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),5,6));
            //<< set arrDate("D") = $extract(pstrDate,7,8)
            arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),7,8));
          }
          //<< 
          //<< } elseif $extract(pstrFormat,1) = "M" {              ; MMDDYYYY (not expected)
          else if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"M")) {
            //<< set arrDate("M") = $extract(pstrDate,1,2)        ; MM/DD/YYYY
            arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),1,2));
            //<< set arrDate("D") = $extract(pstrDate,3,4)
            arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),3,4));
            //<< set arrDate("Y") = $extract(pstrDate,5,8)
            arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),5,8));
          }
          //<< 
          //<< } else {                                             ; DDMMYYYY (not expected)
          else {
            //<< set arrDate("D") = $extract(pstrDate,1,2)        ; DD/MM/YYYY
            arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),1,2));
            //<< set arrDate("M") = $extract(pstrDate,3,4)
            arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),3,4));
            //<< set arrDate("Y") = $extract(pstrDate,5,8)
            arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),5,8));
          }
        }
        //<< }
        //<< 
        //<< } elseif (intSDLength=6) {                               ; with YY instead of YYYY
        else if ((mOp.Equal(intSDLength.get(),6))) {
          //<< $$$LogRx("l2sl:path 1-6")
          $$$LogRx(m$,"l2sl:path 1-6");
          //<< if $extract(pstrFormat,1) = "Y" {
          if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"Y")) {
            //<< set arrDate("Y") = $extract(pstrDate,1,2)
            arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),1,2));
            //<< set arrDate("M") = $extract(pstrDate,3,4)
            arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),3,4));
            //<< set arrDate("D") = $extract(pstrDate,5,6)
            arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),5,6));
          }
          //<< 
          //<< } elseif $extract(pstrFormat,1) = "M" {
          else if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"M")) {
            //<< set arrDate("M") = $extract(pstrDate,1,2)
            arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),1,2));
            //<< set arrDate("D") = $extract(pstrDate,3,4)
            arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),3,4));
            //<< set arrDate("Y") = $extract(pstrDate,5,6)
            arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),5,6));
          }
          //<< 
          //<< } else {
          else {
            //<< set arrDate("D") = $extract(pstrDate,1,2)
            arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),1,2));
            //<< set arrDate("M") = $extract(pstrDate,3,4)
            arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),3,4));
            //<< set arrDate("Y") = $extract(pstrDate,5,6)
            arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),5,6));
          }
        }
        //<< }
        //<< 
        //<< } elseif (intSDLength=4) {                               ; without YYYY
        else if ((mOp.Equal(intSDLength.get(),4))) {
          //<< $$$LogRx("l2sl:path 1-4")
          $$$LogRx(m$,"l2sl:path 1-4");
          //<< set strToday     = $zdate(+$horolog,8)               ; as YYYYMMDD
          strToday.set(m$.Fnc.$zdate(mOp.Positive(m$.Fnc.$horolog()),8));
          //<< set intThisMonth = $extract(strToday,5,6)
          intThisMonth.set(m$.Fnc.$extract(strToday.get(),5,6));
          //<< 
          //<< if $extract(pstrFormat,1) = "Y" {
          if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"Y")) {
            //<< set arrDate("M") = $extract(pstrDate,1,2)
            arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),1,2));
            //<< set arrDate("D") = $extract(pstrDate,3,4)
            arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),3,4));
            //<< set arrDate("Y") = $extract(strToday,1,4)
            arrDate.var("Y").set(m$.Fnc.$extract(strToday.get(),1,4));
          }
          //<< 
          //<< } elseif $extract(pstrFormat,1) = "M" {
          else if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"M")) {
            //<< set arrDate("M") = $extract(pstrDate,1,2)
            arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),1,2));
            //<< set arrDate("D") = $extract(pstrDate,3,4)
            arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),3,4));
            //<< set arrDate("Y") = $extract(strToday,1,4)
            arrDate.var("Y").set(m$.Fnc.$extract(strToday.get(),1,4));
          }
          //<< 
          //<< } else {
          else {
            //<< set arrDate("D") = $extract(pstrDate,1,2)
            arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),1,2));
            //<< set arrDate("M") = $extract(pstrDate,3,4)
            arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),3,4));
            //<< set arrDate("Y") = $extract(strToday,1,4)
            arrDate.var("Y").set(m$.Fnc.$extract(strToday.get(),1,4));
          }
          //<< }
          //<< 
          //<< if (intThisMonth<3) && (arrDate("M")>10) {        ; if in Jan/Feb and specify Nov/Dec use last year
          if ((mOp.Less(intThisMonth.get(),3)) && (mOp.Greater(arrDate.var("M").get(),10))) {
            //<< set arrDate("Y") = arrDate("Y") - 1
            arrDate.var("Y").set(mOp.Subtract(arrDate.var("Y").get(),1));
          }
          //<< } elseif (intThisMonth>10) && (arrDate("M")<10) { ; if in Nov/Dec and specify Jan/Feb use next year
          else if ((mOp.Greater(intThisMonth.get(),10)) && (mOp.Less(arrDate.var("M").get(),10))) {
            //<< set arrDate("Y") = arrDate("Y") + 1
            arrDate.var("Y").set(mOp.Add(arrDate.var("Y").get(),1));
          }
        }
        //<< }
        //<< 
        //<< } elseif (intSDLength=2) || (intSDLength=1) {  ; D or DD only
        else if ((mOp.Equal(intSDLength.get(),2)) || (mOp.Equal(intSDLength.get(),1))) {
          //<< $$$LogRx("l2sl:path 1-2")
          $$$LogRx(m$,"l2sl:path 1-2");
          //<< set strToday     = $zdate(+$horolog,8)               ; as YYYYMMDD
          strToday.set(m$.Fnc.$zdate(mOp.Positive(m$.Fnc.$horolog()),8));
          //<< set arrDate("D") = $select(intSDLength=2:"",1:"0")_pstrDate
          arrDate.var("D").set(mOp.Concat(m$.Fnc.$select(mOp.Equal(intSDLength.get(),2),"",1,"0"),pstrDate.get()));
          //<< set arrDate("M") = $extract(strToday,5,6)
          arrDate.var("M").set(m$.Fnc.$extract(strToday.get(),5,6));
          //<< set arrDate("Y") = $extract(strToday,1,4)
          arrDate.var("Y").set(m$.Fnc.$extract(strToday.get(),1,4));
        }
      }
      //<< }
      //<< 
      //<< ;---------------------------------------
      //<< ; Different Character used as delimiter
      //<< ;---------------------------------------
      //<< } elseif (strDelim="") || '$find(pstrDate,strDelim) {
      else if ((mOp.Equal(strDelim.get(),"")) || mOp.Not(m$.Fnc.$find(pstrDate.get(),strDelim.get()))) {
        //<< set strDelimUsed = $extract($translate(pstrDate,"1234567890"),1)
        strDelimUsed.set(m$.Fnc.$extract(m$.Fnc.$translate(pstrDate.get(),"1234567890"),1));
        //<< $$$LogRx("l2sl:path 1a:"_strDelimUsed_"<")
        $$$LogRx(m$,mOp.Concat(mOp.Concat("l2sl:path 1a:",strDelimUsed.get()),"<"));
        //<< if (strDelimUsed'="") {
        if ((mOp.NotEqual(strDelimUsed.get(),""))) {
          //<< if $length(pstrDate,strDelim)=3 {
          if (mOp.Equal(m$.Fnc.$length(pstrDate.get(),strDelim.get()),3)) {
            //<< $$$LogRx("l2sl:path 1a-1")
            $$$LogRx(m$,"l2sl:path 1a-1");
            //<< for loop = 1:1:3 {
            for (loop.set(1);(mOp.LessOrEqual(loop.get(),3));loop.set(mOp.Add(loop.get(),1))) {
              //<< set strType = $extract($piece(pstrFormat,strDelim,loop),1)
              strType.set(m$.Fnc.$extract(m$.Fnc.$piece(pstrFormat.get(),strDelim.get(),loop.get()),1));
              //<< if strType'="" {
              if (mOp.NotEqual(strType.get(),"")) {
                //<< set arrDate(strType) = $piece(pstrDate,strDelim,loop)
                arrDate.var(strType.get()).set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),loop.get()));
              }
            }
          }
          //<< }
          //<< }
          //<< 
          //<< } elseif $length(pstrDate,strDelim)=2 {
          else if (mOp.Equal(m$.Fnc.$length(pstrDate.get(),strDelim.get()),2)) {
            //<< $$$LogRx("l2sl:path 1a-2")
            $$$LogRx(m$,"l2sl:path 1a-2");
            //<< set strToday     = $zdate(+$horolog,8)          ;  as YYYYMMDD
            strToday.set(m$.Fnc.$zdate(mOp.Positive(m$.Fnc.$horolog()),8));
            //<< set intThisMonth = $extract(strToday,5,6)
            intThisMonth.set(m$.Fnc.$extract(strToday.get(),5,6));
            //<< if $extract(pstrFormat,1) = "Y" {                     ; YYYY/MM/DD
            if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"Y")) {
              //<< set arrDate("M") = $piece(pstrDate,strDelim,1)
              arrDate.var("M").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),1));
              //<< set arrDate("D") = $piece(pstrDate,strDelim,2)
              arrDate.var("D").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),2));
              //<< set arrDate("Y") = $extract(strToday,1,4)
              arrDate.var("Y").set(m$.Fnc.$extract(strToday.get(),1,4));
            }
            //<< } elseif $extract(pstrFormat,1) = "M" {               ; MM/DD/YYYY
            else if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"M")) {
              //<< set arrDate("M") = $piece(pstrDate,strDelim,1)
              arrDate.var("M").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),1));
              //<< set arrDate("D") = $piece(pstrDate,strDelim,2)
              arrDate.var("D").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),2));
              //<< set arrDate("Y") = $extract(strToday,1,4)
              arrDate.var("Y").set(m$.Fnc.$extract(strToday.get(),1,4));
            }
            //<< } else {                                             ; DD/MM/YYYY
            else {
              //<< set arrDate("D") = $piece(pstrDate,strDelim,1)
              arrDate.var("D").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),1));
              //<< set arrDate("M") = $piece(pstrDate,strDelim,2)
              arrDate.var("M").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),2));
              //<< set arrDate("Y") = $extract(strToday,1,4)
              arrDate.var("Y").set(m$.Fnc.$extract(strToday.get(),1,4));
            }
            //<< }
            //<< if (intThisMonth<3) && (arrDate("M")>10) {        ; if in Jan/Feb and specify Nov/Dec use last year
            if ((mOp.Less(intThisMonth.get(),3)) && (mOp.Greater(arrDate.var("M").get(),10))) {
              //<< set arrDate("Y") = arrDate("Y") - 1
              arrDate.var("Y").set(mOp.Subtract(arrDate.var("Y").get(),1));
            }
            //<< } elseif (intThisMonth>10) && (arrDate("M")<10) { ; if in Nov/Dec and specify Jan/Feb use next year
            else if ((mOp.Greater(intThisMonth.get(),10)) && (mOp.Less(arrDate.var("M").get(),10))) {
              //<< set arrDate("Y") = arrDate("Y") + 1
              arrDate.var("Y").set(mOp.Add(arrDate.var("Y").get(),1));
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< ;---------------------------------------
      //<< ; 3 pieces : split according to type
      //<< ;            MM.DD.(YY)YY or DD.MM.(YY)YY or even (YY)YY.MM.DD
      //<< ;---------------------------------------
      //<< } elseif $length(pstrDate,strDelim)=3 {
      else if (mOp.Equal(m$.Fnc.$length(pstrDate.get(),strDelim.get()),3)) {
        //<< $$$LogRx("l2sl:path 2 >"_pstrFormat_"<")
        $$$LogRx(m$,mOp.Concat(mOp.Concat("l2sl:path 2 >",pstrFormat.get()),"<"));
        //<< for loop = 1:1:3 {
        for (loop.set(1);(mOp.LessOrEqual(loop.get(),3));loop.set(mOp.Add(loop.get(),1))) {
          //<< set strType = $extract($piece(pstrFormat,strDelim,loop),1)
          strType.set(m$.Fnc.$extract(m$.Fnc.$piece(pstrFormat.get(),strDelim.get(),loop.get()),1));
          //<< if strType'="" {
          if (mOp.NotEqual(strType.get(),"")) {
            //<< set arrDate(strType) = $piece(pstrDate,strDelim,loop)
            arrDate.var(strType.get()).set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),loop.get()));
          }
        }
      }
      //<< }
      //<< }
      //<< 
      //<< ;---------------------------------------
      //<< ; 2 pieces : split according to type
      //<< ;            MM.DD or DD.MM
      //<< ;---------------------------------------
      //<< } elseif $length(pstrDate,strDelim)=2 {
      else if (mOp.Equal(m$.Fnc.$length(pstrDate.get(),strDelim.get()),2)) {
        //<< $$$LogRx("l2sl:path 3")
        $$$LogRx(m$,"l2sl:path 3");
        //<< set strToday     = $zdate(+$horolog,8)          ; as YYYYMMDD
        strToday.set(m$.Fnc.$zdate(mOp.Positive(m$.Fnc.$horolog()),8));
        //<< set intThisMonth = $extract(strToday,5,6)
        intThisMonth.set(m$.Fnc.$extract(strToday.get(),5,6));
        //<< if $extract(pstrFormat,1) = "Y" {                     ; YYYY/MM/DD
        if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"Y")) {
          //<< set arrDate("M") = $piece(pstrDate,strDelim,1)
          arrDate.var("M").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),1));
          //<< set arrDate("D") = $piece(pstrDate,strDelim,2)
          arrDate.var("D").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),2));
          //<< set arrDate("Y") = $extract(strToday,1,4)
          arrDate.var("Y").set(m$.Fnc.$extract(strToday.get(),1,4));
        }
        //<< } elseif $extract(pstrFormat,1) = "M" {               ; MM/DD/YYYY
        else if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"M")) {
          //<< set arrDate("M") = $piece(pstrDate,strDelim,1)
          arrDate.var("M").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),1));
          //<< set arrDate("D") = $piece(pstrDate,strDelim,2)
          arrDate.var("D").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),2));
          //<< set arrDate("Y") = $extract(strToday,1,4)
          arrDate.var("Y").set(m$.Fnc.$extract(strToday.get(),1,4));
        }
        //<< } else {                                             ; DD/MM/YYYY
        else {
          //<< set arrDate("D") = $piece(pstrDate,strDelim,1)
          arrDate.var("D").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),1));
          //<< set arrDate("M") = $piece(pstrDate,strDelim,2)
          arrDate.var("M").set(m$.Fnc.$piece(pstrDate.get(),strDelim.get(),2));
          //<< set arrDate("Y") = $extract(strToday,1,4)
          arrDate.var("Y").set(m$.Fnc.$extract(strToday.get(),1,4));
        }
        //<< }
        //<< if (intThisMonth<3) && (arrDate("M")>10) {        ; if in Jan/Feb and specify Nov/Dec use last year
        if ((mOp.Less(intThisMonth.get(),3)) && (mOp.Greater(arrDate.var("M").get(),10))) {
          //<< set arrDate("Y") = arrDate("Y") - 1
          arrDate.var("Y").set(mOp.Subtract(arrDate.var("Y").get(),1));
        }
        //<< } elseif (intThisMonth>10) && (arrDate("M")<10) { ; if in Nov/Dec and specify Jan/Feb use next year
        else if ((mOp.Greater(intThisMonth.get(),10)) && (mOp.Less(arrDate.var("M").get(),10))) {
          //<< set arrDate("Y") = arrDate("Y") + 1
          arrDate.var("Y").set(mOp.Add(arrDate.var("Y").get(),1));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< ;---------------------------------------
      //<< ; Reconstruct from Pieces (single-digit D or M padded; century added)
      //<< ;---------------------------------------
      //<< if $data(arrDate) {
      if (mOp.Logical(m$.Fnc.$data(arrDate))) {
        //<< $$$LogRx("l2sl:2:"_arrDate("Y")_"<"_arrDate("M")_"<"_arrDate("D")_"<")
        $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("l2sl:2:",arrDate.var("Y").get()),"<"),arrDate.var("M").get()),"<"),arrDate.var("D").get()),"<"));
        //<< 
        //<< if $length(arrDate("D"))=1   set arrDate("D") = "0"_arrDate("D")
        if (mOp.Equal(m$.Fnc.$length(arrDate.var("D").get()),1)) {
          arrDate.var("D").set(mOp.Concat("0",arrDate.var("D").get()));
        }
        //<< if $length(arrDate("M"))=1   set arrDate("M") = "0"_arrDate("M")
        if (mOp.Equal(m$.Fnc.$length(arrDate.var("M").get()),1)) {
          arrDate.var("M").set(mOp.Concat("0",arrDate.var("M").get()));
        }
        //<< if $get(arrDate("Y")) < 1000 set arrDate("Y") = $$GETYEAR(arrDate("Y")) ; YY => YYYY
        if (mOp.Less(m$.Fnc.$get(arrDate.var("Y")),1000)) {
          arrDate.var("Y").set(m$.fnc$("GETYEAR",arrDate.var("Y").get()));
        }
        //<< 
        //<< 
        //<< if $extract(pstrFormat,1) = "Y" {
        if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"Y")) {
          //<< set pstrDate = arrDate("Y")_strDelim_arrDate("M")_strDelim_arrDate("D")
          pstrDate.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(arrDate.var("Y").get(),strDelim.get()),arrDate.var("M").get()),strDelim.get()),arrDate.var("D").get()));
        }
        //<< 
        //<< } elseif $extract(pstrFormat,1) = "M" {
        else if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"M")) {
          //<< set pstrDate = arrDate("M")_strDelim_arrDate("D")_strDelim_arrDate("Y")
          pstrDate.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(arrDate.var("M").get(),strDelim.get()),arrDate.var("D").get()),strDelim.get()),arrDate.var("Y").get()));
        }
        //<< 
        //<< } else { ; default to DD/MM/YYYY
        else {
          //<< set pstrDate = arrDate("D")_strDelim_arrDate("M")_strDelim_arrDate("Y")
          pstrDate.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(arrDate.var("D").get(),strDelim.get()),arrDate.var("M").get()),strDelim.get()),arrDate.var("Y").get()));
        }
      }
      //<< }
      //<< }
      //<< $$$LogRx("l2sl:3:"_pstrDate_"<")
      $$$LogRx(m$,mOp.Concat(mOp.Concat("l2sl:3:",pstrDate.get()),"<"));
    }
    //<< 
    //<< }
    //<< 
    //<< if intCounter'="" set pstrDate = pstrDate_" ("_intCounter_")"
    if (mOp.NotEqual(intCounter.get(),"")) {
      pstrDate.set(mOp.Concat(mOp.Concat(mOp.Concat(pstrDate.get()," ("),intCounter.get()),")"));
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< StdLitToInt(pstrDate,pstrFormat,pstrDelim)
  public Object StdLitToInt(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrFormat = m$.newVarRef("pstrFormat",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrDelim = m$.newVarRef("pstrDelim",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Convert Standard Literal Date to Horolog format
    //<< ;   (StdLitDate matches format returned from GetDateFormat^COMUtilLocale)
    //<< ;-------------------------------------------------------------------------------
    //<< new arrDate,dteInternal,fltCounter
    mVar arrDate = m$.var("arrDate");
    mVar dteInternal = m$.var("dteInternal");
    mVar fltCounter = m$.var("fltCounter");
    m$.newVar(arrDate,dteInternal,fltCounter);
    //<< 
    //<< set dteInternal = ""
    dteInternal.set("");
    //<< set fltCounter = ""
    fltCounter.set("");
    //<< if $find(pstrDate,"(") {
    if (mOp.Logical(m$.Fnc.$find(pstrDate.get(),"("))) {
      //<< set fltCounter = $piece(pstrDate,"(",2) * $$$IncrementFactor
      fltCounter.set(mOp.Multiply(m$.Fnc.$piece(pstrDate.get(),"(",2),$$$IncrementFactor(m$)));
      //<< set pstrDate   = $piece(pstrDate," ",1)
      pstrDate.set(m$.Fnc.$piece(pstrDate.get()," ",1));
    }
    //<< }
    //<< 
    //<< if $extract(pstrFormat,1) = "Y" {
    if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"Y")) {
      //<< if pstrDelim = "" {
      if (mOp.Equal(pstrDelim.get(),"")) {
        //<< set arrDate("Y") = $extract(pstrDate,1,4)      ; YYYYMMDD
        arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),1,4));
        //<< set arrDate("M") = $extract(pstrDate,5,6)
        arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),5,6));
        //<< set arrDate("D") = $extract(pstrDate,7,8)
        arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),7,8));
      }
      //<< 
      //<< } else {
      else {
        //<< set arrDate("Y") = $extract(pstrDate,1,4)      ; YYYY/MM/DD
        arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),1,4));
        //<< set arrDate("M") = $extract(pstrDate,6,7)
        arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),6,7));
        //<< set arrDate("D") = $extract(pstrDate,9,10)
        arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),9,10));
      }
    }
    //<< }
    //<< 
    //<< } elseif $extract(pstrFormat,1) = "M" {
    else if (mOp.Equal(m$.Fnc.$extract(pstrFormat.get(),1),"M")) {
      //<< if pstrDelim = "" {
      if (mOp.Equal(pstrDelim.get(),"")) {
        //<< set arrDate("M") = $extract(pstrDate,1,2)      ; MMDDYYYY
        arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),1,2));
        //<< set arrDate("D") = $extract(pstrDate,3,4)
        arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),3,4));
        //<< set arrDate("Y") = $extract(pstrDate,5,8)
        arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),5,8));
      }
      //<< 
      //<< } else {
      else {
        //<< set arrDate("M") = $extract(pstrDate,1,2)      ; MM/DD/YYYY
        arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),1,2));
        //<< set arrDate("D") = $extract(pstrDate,4,5)
        arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),4,5));
        //<< set arrDate("Y") = $extract(pstrDate,7,10)
        arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),7,10));
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< if pstrDelim = "" {
      if (mOp.Equal(pstrDelim.get(),"")) {
        //<< set arrDate("D") = $extract(pstrDate,1,2)      ; DDMMYYYY
        arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),1,2));
        //<< set arrDate("M") = $extract(pstrDate,3,4)
        arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),3,4));
        //<< set arrDate("Y") = $extract(pstrDate,5,8)
        arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),5,8));
      }
      //<< 
      //<< } else {
      else {
        //<< set arrDate("D") = $extract(pstrDate,1,2)      ; DD/MM/YYYY
        arrDate.var("D").set(m$.Fnc.$extract(pstrDate.get(),1,2));
        //<< set arrDate("M") = $extract(pstrDate,4,5)
        arrDate.var("M").set(m$.Fnc.$extract(pstrDate.get(),4,5));
        //<< set arrDate("Y") = $extract(pstrDate,7,10)
        arrDate.var("Y").set(m$.Fnc.$extract(pstrDate.get(),7,10));
      }
    }
    //<< }
    //<< }
    //<< if $$Validate(+$get(arrDate("D")),+$get(arrDate("M")),+$get(arrDate("Y"))) {
    if (mOp.Logical(m$.fnc$("Validate",mOp.Positive(m$.Fnc.$get(arrDate.var("D"))),mOp.Positive(m$.Fnc.$get(arrDate.var("M"))),mOp.Positive(m$.Fnc.$get(arrDate.var("Y")))))) {
      //<< set dteInternal = $zdateh(+arrDate("M")_"/"_+arrDate("D")_"/"_+arrDate("Y"))   ; uses MM/DD/YYYY
      dteInternal.set(m$.Fnc.$zdateh(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Positive(arrDate.var("M").get()),"/"),mOp.Positive(arrDate.var("D").get())),"/"),mOp.Positive(arrDate.var("Y").get()))));
    }
    //<< }
    //<< if (dteInternal'="") set dteInternal = dteInternal_fltCounter
    if ((mOp.NotEqual(dteInternal.get(),""))) {
      dteInternal.set(mOp.Concat(dteInternal.get(),fltCounter.get()));
    }
    //<< quit dteInternal
    return dteInternal.get();
  }

  //<< 
  //<< 
  //<< /*
  //<< oldLitToInt(pstrDateIn="",pstrFormat="")
  //<< ;-------------------------------------------------------------------------------
  //<< ;       Convert Date to Horolog format
  //<< ;
  //<< ; Called By : removed from ^WWWDATE1 with concern over SQL access - restore?
  //<< ;
  //<< ; Inputs :
  //<< ;   pstrDateIn
  //<< ;
  //<< ; ByRef :
  //<< ;
  //<< ;
  //<< ; Returns :
  //<< ;   Horolog date [with suffixes if applicable] e.g. 65000 or 65000.1 or 65000.00003
  //<< ;
  //<< ; History :
  //<< ; 07-May-2009   GRF     SR16522: Revised to cover YYYYMMDD, YYYY/MM/DD
  //<< ;-------------------------------------------------------------------------------
  //<< new arrDate,dteInternal,fltCounter,loop,strDelim,strType
  //<< 
  //<< ;if '$data(Y) do ^WWWVORG
  //<< if '$data(Y) do GetBasics(.SPRACHE,.Y,.YBED)
  //<< ;---------------------------------------
  //<< ;    Input                  Output
  //<< ;   xx/xx/xxxx              nnnnn            Date => +$horolog
  //<< ;   xx/xx/xxxx (n)          nnnnn.0000n      Date (Counter) => Horolog.counter
  //<< ;    Wn or nW               nnnnn            Week Number => Monday starting week => +horolog.1
  //<< ; Wnn.yyyy or nn.yyyyW      nnnnn
  //<< ;---------------------------------------
  //<< 
  //<< set dteInternal = ""
  //<< 
  //<< ; Extract date & counter A.0000B from A (B)    65000.00001
  //<< set fltCounter = ""
  //<< if $find(pstrDateIn,"(") {
  //<< set fltCounter  = $piece(pstrDateIn,"(",2) * $$$IncrementFactor
  //<< set pstrDateIn  = $piece(pstrDateIn," ",1)
  //<< }
  //<< 
  //<< set pstrDateIn = $translate(pstrDateIn," |")
  //<< 
  //<< if pstrDateIn = "" {
  //<< set dteInternal = ""
  //<< 
  //<< } elseif pstrDateIn = "." {
  //<< set dteInternal = +$horolog
  //<< 
  //<< } elseif $find(pstrDateIn,"W") || $find(pstrDateIn,"w") {                 ; Week
  //<< set dteInternal = $$^WWWWEEK1(pstrDateIn,1)_".1"         ; FIXME : Why sequence no?  NOTE - $horolog
  //<< 
  //<< } else {
  //<< if pstrFormat="" {
  //<< do GetDateFormat^COMUtilLocale(.pstrFormat,.strDelim,SPRACHE)
  //<< 
  //<< } else {
  //<< if $length(pstrFormat)=8 {
  //<< set strDelim = ""                                         ; YYYYMMDD
  //<< } else {
  //<< set strDelim = $extract(pstrFormat,3)                     ; xx.xx.YYYY
  //<< if strDelim = "Y" set strDelim = $extract(pstrFormat,5)   ; YYYY.MM.DD
  //<< }
  //<< }
  //<< 
  //<< if ($length(pstrDateIn)=5) && (pstrDateIn=+pstrDateIn) {
  //<< set dteInternal = pstrDateIn                                  ; +$horolog (excludes DD/MM)
  //<< }
  //<< 
  //<< if (dteInternal="") && ($length(pstrDateIn,strDelim)<4) {         ; passes initial validation
  //<< if (($length(pstrDateIn)=8) && (pstrDateIn=+pstrDateIn)) || (strDelim="") {
  //<< set arrDate("Y") = $extract(pstrDateIn,1,4)
  //<< set arrDate("M") = $extract(pstrDateIn,5,6)              ; YYYYMMDD (can ALWAYS be specified)
  //<< set arrDate("D") = $extract(pstrDateIn,7,8)
  //<< 
  //<< } else {                             ; DD.MM.YYYY, MM.DD.YYYY, YYYY.MM.DD (any delimiter)
  //<< for loop = 1:1:3 {
  //<< set strType = $extract($piece(pstrFormat,strDelim,loop),1)
  //<< if strType'="" {
  //<< set arrDate(strType) = $piece(pstrDateIn,strDelim,loop)
  //<< }
  //<< }
  //<< if $get(arrDate("Y")) < 1000 {                            ; YY => YYYY
  //<< set arrDate("Y") = $$GETYEAR(arrDate("Y"))
  //<< }
  //<< }
  //<< if $$Validate(+$get(arrDate("D")),+$get(arrDate("M")),+$get(arrDate("Y"))) {
  //<< set dteInternal = $zdateh(+arrDate("M")_"/"_+arrDate("D")_"/"_+arrDate("Y"))   ; uses MM/DD/YYYY
  //<< }
  //<< if (dteInternal'="") set dteInternal = dteInternal_fltCounter
  //<< }
  //<< }
  //<< 
  //<< quit dteInternal
  //<< */
  //<< 
  //<< LitToDMY(pstrDateIn,pstrFormat,pstrDelim,&intDay,&intMonth,&intYear)
  public Object LitToDMY(Object ... _p) {
    mVar pstrDateIn = m$.newVarRef("pstrDateIn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrFormat = m$.newVarRef("pstrFormat",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrDelim = m$.newVarRef("pstrDelim",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar intDay = m$.newVarRef("intDay",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar intMonth = m$.newVarRef("intMonth",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar intYear = m$.newVarRef("intYear",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Split literal components into array
    //<< ;
    //<< ; Called By : WWWCAL2
    //<< ;
    //<< ; History :
    //<< ; 02-Feb-2010   GRF     SR17146: extract date where no delimiter (e.g. YYYYMMDD)
    //<< ; 08-May-2009   GRF     SR16522: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrDate,loop,strType
    mVar arrDate = m$.var("arrDate");
    mVar loop = m$.var("loop");
    mVar strType = m$.var("strType");
    m$.newVar(arrDate,loop,strType);
    //<< 
    //<< if (pstrDelim="") {            ; SR17146 vvv
    if ((mOp.Equal(pstrDelim.get(),""))) {
      //<< if $length(pstrDateIn)=8 {
      if (mOp.Equal(m$.Fnc.$length(pstrDateIn.get()),8)) {
        //<< set arrDate("Y") = $extract(pstrDateIn,1,4)         ; YYYYMMDD
        arrDate.var("Y").set(m$.Fnc.$extract(pstrDateIn.get(),1,4));
        //<< set arrDate("M") = $extract(pstrDateIn,5,6)
        arrDate.var("M").set(m$.Fnc.$extract(pstrDateIn.get(),5,6));
        //<< set arrDate("D") = $extract(pstrDateIn,7,8)
        arrDate.var("D").set(m$.Fnc.$extract(pstrDateIn.get(),7,8));
      }
      //<< 
      //<< } elseif $length(pstrDateIn)=6 {
      else if (mOp.Equal(m$.Fnc.$length(pstrDateIn.get()),6)) {
        //<< set arrDate("Y") = $extract(pstrDateIn,1,2)         ; YYMMDD
        arrDate.var("Y").set(m$.Fnc.$extract(pstrDateIn.get(),1,2));
        //<< set arrDate("M") = $extract(pstrDateIn,3,4)
        arrDate.var("M").set(m$.Fnc.$extract(pstrDateIn.get(),3,4));
        //<< set arrDate("D") = $extract(pstrDateIn,5,6)
        arrDate.var("D").set(m$.Fnc.$extract(pstrDateIn.get(),5,6));
      }
      //<< 
      //<< } elseif $length(pstrDateIn)=4 {
      else if (mOp.Equal(m$.Fnc.$length(pstrDateIn.get()),4)) {
        //<< set arrDate("Y") = ""
        arrDate.var("Y").set("");
        //<< set arrDate("M") = $extract(pstrDateIn,1,2)         ; MMDD   ; FIXME : Should we allow DDMM if locale date is DD/MM/YYYY or similar?
        arrDate.var("M").set(m$.Fnc.$extract(pstrDateIn.get(),1,2));
        //<< set arrDate("D") = $extract(pstrDateIn,3,4)
        arrDate.var("D").set(m$.Fnc.$extract(pstrDateIn.get(),3,4));
      }
    }
    //<< }
    //<< 
    //<< } else {                      ; SR17146 ^^^
    else {
      //<< for loop = 1:1:3 {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),3));loop.set(mOp.Add(loop.get(),1))) {
        //<< set strType = $extract($piece(pstrFormat,pstrDelim,loop),1)
        strType.set(m$.Fnc.$extract(m$.Fnc.$piece(pstrFormat.get(),pstrDelim.get(),loop.get()),1));
        //<< if strType'="" {
        if (mOp.NotEqual(strType.get(),"")) {
          //<< set arrDate(strType) = $piece(pstrDateIn,pstrDelim,loop)
          arrDate.var(strType.get()).set(m$.Fnc.$piece(pstrDateIn.get(),pstrDelim.get(),loop.get()));
        }
      }
      //<< }
      //<< }
      //<< if $get(arrDate("Y")) < 1000 {                          ; YY => YYYY
      if (mOp.Less(m$.Fnc.$get(arrDate.var("Y")),1000)) {
        //<< set arrDate("Y") = $$GETYEAR(arrDate("Y"))
        arrDate.var("Y").set(m$.fnc$("GETYEAR",arrDate.var("Y").get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set intDay   = +$get(arrDate("D"))
    intDay.set(mOp.Positive(m$.Fnc.$get(arrDate.var("D"))));
    //<< set intMonth = +$get(arrDate("M"))
    intMonth.set(mOp.Positive(m$.Fnc.$get(arrDate.var("M"))));
    //<< set intYear  = +$get(arrDate("Y"))
    intYear.set(mOp.Positive(m$.Fnc.$get(arrDate.var("Y"))));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Validate(pintDay,pintMonth,pintYear)
  public Object Validate(Object ... _p) {
    mVar pintDay = m$.newVarRef("pintDay",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintMonth = m$.newVarRef("pintMonth",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintYear = m$.newVarRef("pintYear",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Check that the digits entered represent a valid date
    //<< ;
    //<< ; Inputs :
    //<< ;   day, month and year portions
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;   Horolog date [with suffixes if applicable] e.g. 65000 or 65000.1 or 65000.00003
    //<< ;
    //<< ; History :
    //<< ; 07-May-2009   GRF     SR16522: Revised to cover YYYYMMDD, YYYY/MM/DD
    //<< ;-------------------------------------------------------------------------------
    //<< new blnDateOkay,intMaxDays
    mVar blnDateOkay = m$.var("blnDateOkay");
    mVar intMaxDays = m$.var("intMaxDays");
    m$.newVar(blnDateOkay,intMaxDays);
    //<< 
    //<< set blnDateOkay = $$$YES
    blnDateOkay.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< if ($length(pintYear)'=4) || (pintYear\1'=pintYear) {                      ; Year
    if ((mOp.NotEqual(m$.Fnc.$length(pintYear.get()),4)) || (mOp.NotEqual(mOp.IntegerDivide(pintYear.get(),1),pintYear.get()))) {
      //<< set blnDateOkay = $$$NO
      blnDateOkay.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif (pintYear<1841) || (pintYear>2201) {
    else if ((mOp.Less(pintYear.get(),1841)) || (mOp.Greater(pintYear.get(),2201))) {
      //<< set blnDateOkay = $$$NO
      blnDateOkay.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif (pintMonth<1) || (pintMonth>12) || (pintMonth\1'=pintMonth) {     ; Month
    else if ((mOp.Less(pintMonth.get(),1)) || (mOp.Greater(pintMonth.get(),12)) || (mOp.NotEqual(mOp.IntegerDivide(pintMonth.get(),1),pintMonth.get()))) {
      //<< set blnDateOkay = $$$NO
      blnDateOkay.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif (pintDay<1) || (pintDay\1'=pintDay) {                             ; Date
    else if ((mOp.Less(pintDay.get(),1)) || (mOp.NotEqual(mOp.IntegerDivide(pintDay.get(),1),pintDay.get()))) {
      //<< set blnDateOkay = $$$NO
      blnDateOkay.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } else {
    else {
      //<< if $find(",4,6,9,11,",$$$COMMA_pintMonth_$$$COMMA) {
      if (mOp.Logical(m$.Fnc.$find(",4,6,9,11,",mOp.Concat(mOp.Concat(include.COMSYSString.$$$COMMA(m$),pintMonth.get()),include.COMSYSString.$$$COMMA(m$))))) {
        //<< set intMaxDays = 30
        intMaxDays.set(30);
      }
      //<< 
      //<< } elseif pintMonth'=2 {
      else if (mOp.NotEqual(pintMonth.get(),2)) {
        //<< set intMaxDays = 31
        intMaxDays.set(31);
      }
      //<< 
      //<< } else {                                                               ; Leap Year
      else {
        //<< if pintYear#4 {
        if (mOp.Logical(mOp.Modulus(pintYear.get(),4))) {
          //<< set intMaxDays = 28       ; 2001
          intMaxDays.set(28);
        }
        //<< 
        //<< } elseif pintYear#100 {
        else if (mOp.Logical(mOp.Modulus(pintYear.get(),100))) {
          //<< set intMaxDays = 29       ; 2004
          intMaxDays.set(29);
        }
        //<< 
        //<< } elseif pintYear#400 {
        else if (mOp.Logical(mOp.Modulus(pintYear.get(),400))) {
          //<< set intMaxDays = 28       ; 1900
          intMaxDays.set(28);
        }
        //<< 
        //<< } else {
        else {
          //<< set intMaxDays = 29       ; 2000
          intMaxDays.set(29);
        }
      }
      //<< }
      //<< }
      //<< if (pintDay>intMaxDays) set blnDateOkay = $$$NO
      if ((mOp.Greater(pintDay.get(),intMaxDays.get()))) {
        blnDateOkay.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< quit blnDateOkay
    return blnDateOkay.get();
  }

  //<< 
  //<< 
  //<< GETYEAR(pintYY="",pintBaseYear="")
  public Object GETYEAR(Object ... _p) {
    mVar pintYY = m$.newVarRef("pintYY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintBaseYear = m$.newVarRef("pintBaseYear",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Given a two digit year, guess the correct year. Current year can be passed in as a param.
    //<< ;
    //<< ; Inputs:
    //<< ;   pintYY          2 digit year (or null for current year)
    //<< ;   pintBaseYear    base year - if blank uses current year
    //<< ;
    //<< ; Returns:
    //<< ;   intReturn       4 digit year
    //<< ;
    //<< ; History:
    //<< ; 27-Sep-2007   GRF     SRBR014643: Changed 75/25 default to 95/05
    //<< ; 26-Sep-2007   GRF     SRBR014643: Doco and use offset variables rather than hard
    //<< ;                       coded values as precursor to more flexible mechanism.
    //<< ; 13-Jun-2007   GRF     SR15525: Clarify variable use and simplify; calling with
    //<< ;                       -ve value results in 3 digit response (e.g. -3 => 97 => 7)
    //<< ;                       now -ve equivalent to zero
    //<< ; 07-Apr-2005   Paul K  SR10644: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intBack,intForward,intReturn
    mVar intBack = m$.var("intBack");
    mVar intForward = m$.var("intForward");
    mVar intReturn = m$.var("intReturn");
    m$.newVar(intBack,intForward,intReturn);
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ; Sliding interpretation of 2 digit dates based on
    //<< ; Back Offset of 75 years and thus a Forward offset of 25 years
    //<< ;
    //<< ;               Current Year (pintBaseYear)         |                 Current Year (pintBaseYear)
    //<< ; -75                       2007             +25    |   -75                       2087             +25
    //<< ;  +-------------------------|----------------+     |    +-------------------------|----------------+
    //<< ; 1932                                       2032   |   2012                                       2112
    //<< ;                                                   |
    //<< ; pintYY        02      20      40      90          |   pintYY      02      20      40      90
    //<< ; Case #        3       2       1       1           |   Case #      4       3       3       2
    //<< ; Year          2002    2020    1940    1990        |   Year        2102    2020    2040    2090
    //<< ;                                                   |
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< set intBack    = 95
    intBack.set(95);
    //<< set intForward = 100 - intBack
    intForward.set(mOp.Subtract(100,intBack.get()));
    //<< 
    //<< if pintBaseYear="" set pintBaseYear=$piece($zdatetime($horolog,3),"-",1)  ;current year
    if (mOp.Equal(pintBaseYear.get(),"")) {
      pintBaseYear.set(m$.Fnc.$piece(m$.Fnc.$zdatetime(m$.Fnc.$horolog(),3),"-",1));
    }
    //<< set intReturn = pintBaseYear
    intReturn.set(pintBaseYear.get());
    //<< 
    //<< if pintYY'="" {
    if (mOp.NotEqual(pintYY.get(),"")) {
      //<< set pintYY = +pintYY
      pintYY.set(mOp.Positive(pintYY.get()));
      //<< if pintYY<0          set pintYY=0
      if (mOp.Less(pintYY.get(),0)) {
        pintYY.set(0);
      }
      //<< if $length(pintYY)=1 set pintYY = "0"_pintYY
      if (mOp.Equal(m$.Fnc.$length(pintYY.get()),1)) {
        pintYY.set(mOp.Concat("0",pintYY.get()));
      }
      //<< 
      //<< if pintYY>$extract(pintBaseYear,3,4) {
      if (mOp.Greater(pintYY.get(),m$.Fnc.$extract(pintBaseYear.get(),3,4))) {
        //<< if pintYY > ($extract(pintBaseYear,3,4)+intForward) {
        if (mOp.Greater(pintYY.get(),(mOp.Add(m$.Fnc.$extract(pintBaseYear.get(),3,4),intForward.get())))) {
          //<< set intReturn = ($extract(pintBaseYear,1,2)-1)_pintYY           ; #1  Previous Century
          intReturn.set(mOp.Concat((mOp.Subtract(m$.Fnc.$extract(pintBaseYear.get(),1,2),1)),pintYY.get()));
        }
        //<< } else {
        else {
          //<< set intReturn =  $extract(pintBaseYear,1,2)   _pintYY           ; #2  A little way ahead
          intReturn.set(mOp.Concat(m$.Fnc.$extract(pintBaseYear.get(),1,2),pintYY.get()));
        }
      }
      //<< }
      //<< } else {
      else {
        //<< if (pintYY+intBack) > $extract(pintBaseYear,3,4) {
        if (mOp.Greater((mOp.Add(pintYY.get(),intBack.get())),m$.Fnc.$extract(pintBaseYear.get(),3,4))) {
          //<< set intReturn =  $extract(pintBaseYear,1,2)   _pintYY           ; #3  A little way back
          intReturn.set(mOp.Concat(m$.Fnc.$extract(pintBaseYear.get(),1,2),pintYY.get()));
        }
        //<< } else {
        else {
          //<< set intReturn = ($extract(pintBaseYear,1,2)+1)_pintYY           ; #4  Next Century
          intReturn.set(mOp.Concat((mOp.Add(m$.Fnc.$extract(pintBaseYear.get(),1,2),1)),pintYY.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit intReturn
    return intReturn.get();
  }

  //<< 
  //<< 
  //<< GetIncrementFactor()
  public Object GetIncrementFactor(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; How much a date value will increment by if being used as a counter.
    //<< ;
    //<< ; Called by : INReceiptLinePost, INRECLine, INWECounter
    //<< ;
    //<< ; Returns: CONSTANT - DO NOT CHANGE !!
    //<< ;           Set to 5 decimal places so it can be replaced by time if necessary
    //<< ;
    //<< ; History:
    //<< ; 02-Jun-2010   GRF     SR17146: Use Macro
    //<< ; 23-Mar-2006   JW      SR14422: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$$IncrementFactor       ;0.00001
    return $$$IncrementFactor(m$);
  }

}
