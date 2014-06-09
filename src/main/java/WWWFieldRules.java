//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFieldRules
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-09 15:04:57
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
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

//<< WWWFieldRules
public class WWWFieldRules extends mClass {

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

  public void main() {
    _WWWFieldRules();
  }

  public void _WWWFieldRules() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFieldRules("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< ChangeInputAs(&pstrInput,pidType)
  public Object ChangeInputAs(Object ... _p) {
    mVar pstrInput = m$.newVarRef("pstrInput",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidType = m$.newVarRef("pidType",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Process the Change Input As option
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Jan-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new strNoSpace,loop
    mVar strNoSpace = m$.var("strNoSpace");
    mVar loop = m$.var("loop");
    m$.newVar(strNoSpace,loop);
    //<< 
    //<< $$$LogR("ChangeInputAs",$get(pstrInput)_"<"_$get(pidType))
    $$$LogR(m$,"ChangeInputAs",mOp.Concat(mOp.Concat(m$.Fnc.$get(pstrInput),"<"),m$.Fnc.$get(pidType)));
    //<< 
    //<< if pidType=7 {          ; no special characters
    if (mOp.Equal(pidType.get(),7)) {
      //<< set pstrInput = $translate(pstrInput,"][\}{|~,()@#$%^&*_=+<>?/-.:´`§²³!°€µ")
      pstrInput.set(m$.Fnc.$translate(pstrInput.get(),"][\\}{|~,()@#$%^&*_=+<>?/-.:´`§²³!°€µ"));
    }
    //<< 
    //<< } else {
    else {
      //<< if pidType=1 {                  ; BIG
      if (mOp.Equal(pidType.get(),1)) {
        //<< set pstrInput = $$$UPPER(pstrInput)
        pstrInput.set(include.COMSYSString.$$$UPPER(m$,pstrInput));
      }
      //<< 
      //<< } elseif pidType=2 {            ; small
      else if (mOp.Equal(pidType.get(),2)) {
        //<< set pstrInput = $$$LOWER(pstrInput)
        pstrInput.set(include.COMSYSString.$$$LOWER(m$,pstrInput));
      }
      //<< 
      //<< } elseif pidType=3 {            ; Title
      else if (mOp.Equal(pidType.get(),3)) {
        //<< set pstrInput = $$$UPPER($extract(pstrInput))_$extract($$$LOWER(pstrInput),2,999)
        pstrInput.set(mOp.Concat(include.COMSYSString.$$$UPPER(m$,m$.Fnc.$extract(pstrInput.get())),m$.Fnc.$extract(include.COMSYSString.$$$LOWER(m$,pstrInput),2,999)));
      }
      //<< 
      //<< } elseif pidType=4 {            ; Spaced
      else if (mOp.Equal(pidType.get(),4)) {
        //<< set strNoSpace = $translate(pstrInput," ")
        strNoSpace.set(m$.Fnc.$translate(pstrInput.get()," "));
        //<< set pstrInput = ""
        pstrInput.set("");
        //<< for loop=1:1:$length(strNoSpace) {
        for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strNoSpace.get())));loop.set(mOp.Add(loop.get(),1))) {
          //<< $$$Append(pstrInput," "_$extract(strNoSpace,loop))
          include.COMSYSString.$$$Append(m$,pstrInput,mOp.Concat(" ",m$.Fnc.$extract(strNoSpace.get(),loop.get())));
        }
        //<< }
        //<< set $extract(pstrInput) = ""
        mVar $extract = m$.var("$extract");
        $extract.var(pstrInput.get()).set("");
      }
      //<< 
      //<< // Need to look at this - think WWWEVENT and SAVE are diff. SAVE adds extra space?
      //<< 
      //<< } elseif pidType=5 {            ; No Spaces
      else if (mOp.Equal(pidType.get(),5)) {
        //<< set pstrInput = $translate(pstrInput," ")
        pstrInput.set(m$.Fnc.$translate(pstrInput.get()," "));
      }
      //<< 
      //<< } elseif pidType=6 {            ; BIG and no spaces
      else if (mOp.Equal(pidType.get(),6)) {
        //<< set pstrInput = $$$UPPER($translate(pstrInput," "))
        pstrInput.set(include.COMSYSString.$$$UPPER(m$,m$.Fnc.$translate(pstrInput.get()," ")));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< TranslateDate(&pstrDate)
  public Object TranslateDate(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Date translation
    //<< ;
    //<< ; Called By : FIELD^WWWEVENT, VARIBLE^WWWEVENT
    //<< ;
    //<< ; Params:   pstrInput   - user input (ByRef)
    //<< ;
    //<< ; Returns:  storage value (+$h)
    //<< ;
    //<< ; History:
    //<< ; 02-Jun-2010   GRF     SR17146: Revised to use common code in WWWDATE1
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
    //<< set dteInternal = $$StdLitToInt^WWWDATE1(pstrDate,strFormat,strDelim)
    dteInternal.set(m$.fnc$("WWWDATE1.StdLitToInt",pstrDate.get(),strFormat.get(),strDelim.get()));
    //<< 
    //<< if dteInternal="" {
    if (mOp.Equal(dteInternal.get(),"")) {
      //<< set %TXT(1)   = "§"_$$^WWWTEXT(272)    ; "Wrong Date Format"   (Alert & Focus)
      m$.var("%TXT",1).set(mOp.Concat("§",m$.fnc$("WWWTEXT.main",272)));
      //<< set pstrDate = ""
      pstrDate.set("");
    }
    //<< } else {
    else {
      //<< set pstrDate = $$^WWWDATE(dteInternal)
      pstrDate.set(m$.fnc$("WWWDATE.main",dteInternal.get()));
    }
    //<< }
    //<< quit dteInternal
    return dteInternal.get();
  }

  //<< 
  //<< 
  //<< v2TranslateDate(&pstrInput)
  public Object v2TranslateDate(Object ... _p) {
    mVar pstrInput = m$.newVarRef("pstrInput",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Date translation
    //<< ;
    //<< ; Called By : FIELD^WWWEVENT, VARIBLE^WWWEVENT
    //<< ;
    //<< ; Params:   pstrInput   - user input (ByRef)
    //<< ;
    //<< ; Returns:  storage value (+$h)
    //<< ;
    //<< ; History:
    //<< ; 02-Feb-2010   GRF     SR17146: MM/DD/YYYY was treating inputs as DD/MM/YYYY
    //<< ; 08-May-2009   GRF     SR16522: revised; Handle YYYY*MM*DD & YYYYMMDD; doco
    //<< ; 27-Aug-2008   heber   SRBR014945a: fixing date masking automatic
    //<< ; 30-May-2008   heber   SRBR014945: added date masking to grid fields
    //<< ; 19-Jan-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new dteReturned,dteToday,intBaseLen,intDate,intToday,intYear
    mVar dteReturned = m$.var("dteReturned");
    mVar dteToday = m$.var("dteToday");
    mVar intBaseLen = m$.var("intBaseLen");
    mVar intDate = m$.var("intDate");
    mVar intToday = m$.var("intToday");
    mVar intYear = m$.var("intYear");
    m$.newVar(dteReturned,dteToday,intBaseLen,intDate,intToday,intYear);
    //<< new strBaseDate,strDelim,strFormat,strToday,strType
    mVar strBaseDate = m$.var("strBaseDate");
    mVar strDelim = m$.var("strDelim");
    mVar strFormat = m$.var("strFormat");
    mVar strToday = m$.var("strToday");
    mVar strType = m$.var("strType");
    m$.newVar(strBaseDate,strDelim,strFormat,strToday,strType);
    //<< 
    //<< $$$LogR("TranslateDate",$get(pstrInput))
    $$$LogR(m$,"TranslateDate",m$.Fnc.$get(pstrInput));
    //<< 
    //<< set dteReturned = ""
    dteReturned.set("");
    //<< set dteToday    = +$horolog
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< set strToday    = $zdate(dteToday,3)   ; as YYYY-MM-DD
    strToday.set(m$.Fnc.$zdate(dteToday.get(),3));
    //<< 
    //<< ;---------------------------------------
    //<< ;  Part 1
    //<< ;
    //<< ;  "."  "+n"  "-n"  "Wn"  "nW"
    //<< ;  ","                (not standard in WWWDATE1)
    //<< ;---------------------------------------
    //<< 
    //<< if (pstrInput=".") || (pstrInput=",") {                      ; today
    if ((mOp.Equal(pstrInput.get(),".")) || (mOp.Equal(pstrInput.get(),","))) {
      //<< set dteReturned = dteToday
      dteReturned.set(dteToday.get());
    }
    //<< 
    //<< } elseif $extract(pstrInput)="-" {                           ; today - days
    else if (mOp.Equal(m$.Fnc.$extract(pstrInput.get()),"-")) {
      //<< set dteReturned = dteToday - $extract(pstrInput,2,9)
      dteReturned.set(mOp.Subtract(dteToday.get(),m$.Fnc.$extract(pstrInput.get(),2,9)));
    }
    //<< 
    //<< } elseif $extract(pstrInput)="+" {                           ; today + days
    else if (mOp.Equal(m$.Fnc.$extract(pstrInput.get()),"+")) {
      //<< set dteReturned = dteToday + $extract(pstrInput,2,9)
      dteReturned.set(mOp.Add(dteToday.get(),m$.Fnc.$extract(pstrInput.get(),2,9)));
    }
    //<< 
    //<< } elseif pstrInput?2A {                                      ; 2 char day of week (mo,tu,we,...,su) case insensitive
    else if (mOp.Match(pstrInput.get(),"2A")) {
      //<< set intDate = $order(^WWW101s(0,1,$$$Index(pstrInput),"COMDAYSOFWEEKSHORT",SPRACHE,""))
      intDate.set(m$.Fnc.$order(m$.var("^WWW101s",0,1,include.COMConst.$$$Index(m$,pstrInput),"COMDAYSOFWEEKSHORT",m$.var("SPRACHE").get(),"")));
      //<< if intDate'="" {
      if (mOp.NotEqual(intDate.get(),"")) {
        //<< set intToday    = $$$DayOfWeek(dteToday)
        intToday.set(include.COMSYSDate.$$$DayOfWeek(m$,dteToday));
        //<< set dteReturned = dteToday - intToday + intDate      ; +$h for corresponding day of *THIS* week Mon-Sun
        dteReturned.set(mOp.Add(mOp.Subtract(dteToday.get(),intToday.get()),intDate.get()));
      }
    }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ;  Part 2
    //<< ;
    //<< ;  Delimiter "*" used below can be ".-,;:\/"
    //<< ;  though may not all be properly managed by WWWDATE1.
    //<< ;
    //<< ;  Today is represented by DD MM and YYYY or CCYY
    //<< ;          pstrInput                                 strBaseDate            pstrInput                 FELDFORMAT
    //<< ;  Wn or Wn.yyyy => string date in FELDFORMAT format          intBaseLen
    //<< ;     then processed as follows...
    //<< ;  yyyyddmm                                           yyyyddmm  8       => yyyy-mm-dd                     any
    //<< ;  yyyy*mm*dd                                         yyyyddmm  8              do                      YYYY*MM*DD
    //<< ;  dd*mm*yyyy                                         ddmmyyyy  8              do                      DD*MM*YYYY
    //<< ;  mm*dd*yyyy                                         mmddyyyy  8              do                      MM*DD*YYYY
    //<< ;  d      or dd       (add current month and year)       dd     2       => YYYY-MM-dd                     any
    //<< ;  ddmm   or dd*mm    (add current year)                ddmm    4       => YYYY-mm-dd                  DD*MM*YYYY
    //<< ;  ddmmyy or dd*mm*yy (extend current year)            ddmmyy   6       => CCyy-mm-dd (-95/+5)         DD*MM*YYYY
    //<< ;  mmdd   or mmdd     (add current year)     ?          mmdd    4       => YYYY-mm-dd           YYYY*MM*DD or MM*DD*YYYY
    //<< ;  mmddyy or mm*dd*yy (extend current year)  ?         mmddyy   6       => CCyy-mm-dd (-95/+5)         MM*DD*YYYY
    //<< ;  nnn...                                              nnn...  odd      => error (null in dteReturned)
    //<< ;---------------------------------------
    //<< 
    //<< } elseif (pstrInput'="") {    ; convert various forms to YYYY-MM-DD -  (no else)
    else if ((mOp.NotEqual(pstrInput.get(),""))) {
      //<< do GetDateFormat^COMUtilLocale(.strFormat,.strDelim,SPRACHE)
      m$.Cmd.Do("COMUtilLocale.GetDateFormat",strFormat,strDelim,m$.var("SPRACHE").get());
      //<< set strType = $extract(strFormat,1)    ; D = DD*MM*YYYY, M = MM*DD*YYYY, Y = YYYY*MM*DD
      strType.set(m$.Fnc.$extract(strFormat.get(),1));
      //<< 
      //<< if $find(pstrInput,"W") || $find(pstrInput,"w") {        ; week number  Wn or Wn.yyyy or Wn.yy or nW, etc.
      if (mOp.Logical(m$.Fnc.$find(pstrInput.get(),"W")) || mOp.Logical(m$.Fnc.$find(pstrInput.get(),"w"))) {
        //<< set pstrInput = $$^WWWWEEK1(pstrInput)               ; returns monday of matching week
        pstrInput.set(m$.fnc$("WWWWEEK1.main",pstrInput.get()));
      }
      //<< }
      //<< 
      //<< set strBaseDate = $translate(pstrInput,"-.,;:\/ ")
      strBaseDate.set(m$.Fnc.$translate(pstrInput.get(),"-.,;:\\/ "));
      //<< set intBaseLen  = $length(strBaseDate)
      intBaseLen.set(m$.Fnc.$length(strBaseDate.get()));
      //<< 
      //<< if $extract(strBaseDate)?1.8N {
      if (mOp.Match(m$.Fnc.$extract(strBaseDate.get()),"1.8N")) {
        //<< if intBaseLen = 1 {
        if (mOp.Equal(intBaseLen.get(),1)) {
          //<< set pstrInput = "0"_pstrInput
          pstrInput.set(mOp.Concat("0",pstrInput.get()));
          //<< set intBaseLen = 2
          intBaseLen.set(2);
        }
        //<< }
        //<< 
        //<< if intBaseLen = 2 {                ; only DD
        if (mOp.Equal(intBaseLen.get(),2)) {
          //<< set pstrInput = $piece(strToday,"-",1,2)_"-"_pstrInput
          pstrInput.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(strToday.get(),"-",1,2),"-"),pstrInput.get()));
        }
        //<< 
        //<< } elseif intBaseLen = 4 {          ; only DDMM or MMDD depending on strFormat (D or M/Y)
        else if (mOp.Equal(intBaseLen.get(),4)) {
          //<< if strType = "D" {
          if (mOp.Equal(strType.get(),"D")) {
            //<< set pstrInput = $piece(strToday,"-",1)_"-"_$extract(strBaseDate,3,4)_"-"_$extract(strBaseDate,1,2)
            pstrInput.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(strToday.get(),"-",1),"-"),m$.Fnc.$extract(strBaseDate.get(),3,4)),"-"),m$.Fnc.$extract(strBaseDate.get(),1,2)));
          }
          //<< 
          //<< } else {
          else {
            //<< set pstrInput = $piece(strToday,"-",1)_"-"_$extract(strBaseDate,1,2)_"-"_$extract(strBaseDate,3,4)
            pstrInput.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(strToday.get(),"-",1),"-"),m$.Fnc.$extract(strBaseDate.get(),1,2)),"-"),m$.Fnc.$extract(strBaseDate.get(),3,4)));
          }
        }
        //<< }
        //<< 
        //<< } elseif intBaseLen = 6 {          ; DDMMYY or MMDDYY - needs century
        else if (mOp.Equal(intBaseLen.get(),6)) {
          //<< set intYear = $$GETYEAR^WWWDATE1($extract(strBaseDate,5,6))
          intYear.set(m$.fnc$("WWWDATE1.GETYEAR",m$.Fnc.$extract(strBaseDate.get(),5,6)));
          //<< if strType = "D" {
          if (mOp.Equal(strType.get(),"D")) {
            //<< set pstrInput = intYear_"-"_$extract(strBaseDate,3,4)_"-"_$extract(strBaseDate,1,2)
            pstrInput.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(intYear.get(),"-"),m$.Fnc.$extract(strBaseDate.get(),3,4)),"-"),m$.Fnc.$extract(strBaseDate.get(),1,2)));
          }
          //<< 
          //<< } elseif strType = "M" {
          else if (mOp.Equal(strType.get(),"M")) {
            //<< set pstrInput = intYear_"-"_$extract(strBaseDate,1,2)_"-"_$extract(strBaseDate,3,4)
            pstrInput.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(intYear.get(),"-"),m$.Fnc.$extract(strBaseDate.get(),1,2)),"-"),m$.Fnc.$extract(strBaseDate.get(),3,4)));
          }
          //<< 
          //<< } else {
          else {
            //<< set pstrInput = ""         ; error situation
            pstrInput.set("");
          }
        }
        //<< }
        //<< 
        //<< } elseif intBaseLen = 8 {          ; DD*MM*YYYY or MM*DD*YYYY or YYYY*MM*DD or YYYYMMDD
        else if (mOp.Equal(intBaseLen.get(),8)) {
          //<< 
          //<< if pstrInput?8N  {             ; explicit YYYYMMDD regardless of strFormat
          if (mOp.Match(pstrInput.get(),"8N")) {
            //<< set pstrInput = $extract(strBaseDate,1,4)_"-"_$extract(strBaseDate,5,6)_"-"_$extract(strBaseDate,7,8)
            pstrInput.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(strBaseDate.get(),1,4),"-"),m$.Fnc.$extract(strBaseDate.get(),5,6)),"-"),m$.Fnc.$extract(strBaseDate.get(),7,8)));
          }
          //<< 
          //<< } elseif strType = "D" {
          else if (mOp.Equal(strType.get(),"D")) {
            //<< set pstrInput = $extract(strBaseDate,5,8)_"-"_$extract(strBaseDate,3,4)_"-"_$extract(strBaseDate,1,2)
            pstrInput.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(strBaseDate.get(),5,8),"-"),m$.Fnc.$extract(strBaseDate.get(),3,4)),"-"),m$.Fnc.$extract(strBaseDate.get(),1,2)));
          }
          //<< 
          //<< } elseif strType = "M" {
          else if (mOp.Equal(strType.get(),"M")) {
            //<< ;           set pstrInput = $extract(strBaseDate,5,8)_"-"_$extract(strBaseDate,3,4)_"-"_$extract(strBaseDate,1,2)  ; SR17146
            //<< set pstrInput = $extract(strBaseDate,5,8)_"-"_$extract(strBaseDate,1,2)_"-"_$extract(strBaseDate,3,4)
            pstrInput.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(strBaseDate.get(),5,8),"-"),m$.Fnc.$extract(strBaseDate.get(),1,2)),"-"),m$.Fnc.$extract(strBaseDate.get(),3,4)));
          }
          //<< 
          //<< } else {
          else {
            //<< set pstrInput = $extract(strBaseDate,1,4)_"-"_$extract(strBaseDate,5,6)_"-"_$extract(strBaseDate,7,8)
            pstrInput.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(strBaseDate.get(),1,4),"-"),m$.Fnc.$extract(strBaseDate.get(),5,6)),"-"),m$.Fnc.$extract(strBaseDate.get(),7,8)));
          }
        }
        //<< }
        //<< 
        //<< } else {                           ; odd number of digits
        else {
          //<< set pstrInput = ""             ; error situation
          pstrInput.set("");
        }
      }
      //<< }
      //<< }               ; else case - dteReturned = ""
      //<< 
      //<< ;   pstrInput will now be either null or YYYY-MM-DD
      //<< set dteReturned = $zdateh(pstrInput,3,,,,,,,"")         ; return null if error
      dteReturned.set(m$.Fnc.$zdateh(pstrInput.get(),3,null,null,null,null,null,null,""));
    }
    //<< }                   ; else case - null input returns null dteReturned
    //<< 
    //<< if dteReturned="" {
    if (mOp.Equal(dteReturned.get(),"")) {
      //<< set %TXT(1)   = "§"_$$^WWWTEXT(272)    ; "Wrong Date Format"   (Alert & Focus)
      m$.var("%TXT",1).set(mOp.Concat("§",m$.fnc$("WWWTEXT.main",272)));
      //<< set pstrInput = ""
      pstrInput.set("");
    }
    //<< } else {
    else {
      //<< set pstrInput = $$^WWWDATE(dteReturned)
      pstrInput.set(m$.fnc$("WWWDATE.main",dteReturned.get()));
    }
    //<< }
    //<< quit dteReturned
    return dteReturned.get();
  }

  //<< 
  //<< 
  //<< OldTranslateDate(&pstrInput)     ; DEPRECATED (v1)
  public Object OldTranslateDate(Object ... _p) {
    mVar pstrInput = m$.newVarRef("pstrInput",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Date translation
    //<< ;
    //<< ; Called By : WWWEVENT
    //<< ;
    //<< ; Params:   pstrInput   - user input
    //<< ;           pstrField   - field id
    //<< ;
    //<< ; Returns:  storage value
    //<< ;
    //<< ; History:
    //<< ; 08-May-2009   GRF     SR16522: Deprecated
    //<< ; 27-Aug-2008   heber   SRBR014945a: fixing date masking automatic
    //<< ; 30-May-2008   heber   SRBR014945: added date masking to grid fields
    //<< ; 19-Jan-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new dte,dteToday,intDate,intToday,strOrig,strDelim
    mVar dte = m$.var("dte");
    mVar dteToday = m$.var("dteToday");
    mVar intDate = m$.var("intDate");
    mVar intToday = m$.var("intToday");
    mVar strOrig = m$.var("strOrig");
    mVar strDelim = m$.var("strDelim");
    m$.newVar(dte,dteToday,intDate,intToday,strOrig,strDelim);
    //<< new intStrLen,strInput // SRBR014945
    mVar intStrLen = m$.var("intStrLen");
    mVar strInput = m$.var("strInput");
    m$.newVar(intStrLen,strInput);
    //<< new pstrTest                                    //SRBR014945a
    mVar pstrTest = m$.var("pstrTest");
    m$.newVar(pstrTest);
    //<< 
    //<< set dte = ""
    dte.set("");
    //<< set dteToday = +$horolog
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< ;---------------------------------------
    //<< ;  Part 1
    //<< ;
    //<< ;  Delimiter "*" used below can be ".-,;:\/"
    //<< ;  though may not all be properly managed by WWWDATE1.
    //<< ;
    //<< ;  Today is represented by DD MM and YYYY or CCYY
    //<< ;                                                     strInput
    //<< ;          pstrInput                                  strTest              pstrInput
    //<< ;
    //<< ;  ccyyddmm    ccyy*mm*dd                             ccyyddmm  8       => YYYY-MM-cc => YYYY-yy-cc => ddmm-yy-cc
    //<< ;  dd*mm*yyyy                                         ddmmyyyy  8       => YYYY-MM-dd => YYYY-mm-dd => yyyy-mm-dd
    //<< ;  mm*dd*yyyy                                         mmddyyyy  8       => YYYY-MM-mm => YYYY-dd-mm => yyyy-dd-mm
    //<< ;  d      or dd       (add current month and year)       dd     2       => YYYY-MM-dd
    //<< ;  ddmm   or dd*mm    (add current year)                ddmm    4       => YYYY-MM-dd => YYYY-mm-dd
    //<< ;  ddmmyy or dd*mm*yy (extend current year)            ddmmyy   6       => CCYY-MM-dd => YYYY-mm-dd => CCyy-mm-dd
    //<< ;  mmdd   or mmdd     (add current year)     ?          mmdd    4       => YYYY-MM-mm => YYYY-dd-mm
    //<< ;  mmddyy or mm*dd*yy (extend current year)  ?         mmddyy   6       => CCYY-MM-mm => YYYY-dd-mm => CCyy-dd-mm
    //<< ;  nnn
    //<< ;  nnnnn                                             nnnnn...  odd => error (null in dte)?
    //<< ;  nnnnnnn
    //<< ;  nnnnnnnnn ...
    //<< ;
    //<< ;  Part 2
    //<< ;
    //<< ;  "."  "+n"  "-n"  "Wn"  "nW"
    //<< ;  ","                (not a standard option in WWWDATE1)
    //<< ;---------------------------------------
    //<< 
    //<< if $extract(pstrInput)?1N {     // First char is a number. Get display then internal.
    if (mOp.Match(m$.Fnc.$extract(pstrInput.get()),"1N")) {
      //<< set pstrInput = $translate(pstrInput,"-,;:\/","......")
      pstrInput.set(m$.Fnc.$translate(pstrInput.get(),"-,;:\\/","......"));
      //<< 
      //<< set pstrTest = $translate(pstrInput,".","")     //SRBR014945a
      pstrTest.set(m$.Fnc.$translate(pstrInput.get(),".",""));
      //<< ; only numeric fields accepted
      //<< if (pstrTest?.N) {                              //SRBR014945a
      if ((mOp.Match(pstrTest.get(),".N"))) {
        //<< if +$piece(pstrInput,".",2)=0 {     // Day Only
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(pstrInput.get(),".",2)),0)) {
          //<< ; SRBR014945 ---vvvvv
          //<< ;
          //<< ;set pstrInput = $$$DateYearMonth(dteToday)_"-"_pstrInput       // Add the year and month
          //<< ;set dte = $zdateh(pstrInput,3,,,,,,,"")                            // Set to "" if error
          //<< 
          //<< set pstrInput = pstrTest    //SRBR014945a
          pstrInput.set(pstrTest.get());
          //<< 
          //<< set intStrLen = $length(pstrInput)
          intStrLen.set(m$.Fnc.$length(pstrInput.get()));
          //<< 
          //<< //SRBR014945a
          //<< if intStrLen = 1 {
          if (mOp.Equal(intStrLen.get(),1)) {
            //<< set pstrInput = "0" _ pstrInput
            pstrInput.set(mOp.Concat("0",pstrInput.get()));
            //<< set intStrLen = $length(pstrInput)
            intStrLen.set(m$.Fnc.$length(pstrInput.get()));
          }
          //<< }
          //<< //^^^^SRBR014945a
          //<< 
          //<< set strInput = pstrInput
          strInput.set(pstrInput.get());
          //<< if ((intStrLen = 2)||(intStrLen = 4)||(intStrLen = 6)||(intStrLen = 8)) {   //SRBR014945a
          if (mOp.Logical(((mOp.Equal(intStrLen.get(),2)) || (mOp.Equal(intStrLen.get(),4)) || (mOp.Equal(intStrLen.get(),6)) || (mOp.Equal(intStrLen.get(),8))))) {
            //<< ;if (intStrLen = 2)||(intStrLen = 4)||(intStrLen = 8)   //SRBR014945a
            //<< set pstrInput = $$$DateYearMonth(dteToday)_"-"_$extract(strInput,1,2)       // Add the year and month
            pstrInput.set(mOp.Concat(mOp.Concat(include.COMSYSDate.$$$DateYearMonth(m$,dteToday),"-"),m$.Fnc.$extract(strInput.get(),1,2)));
          }
          //<< }
          //<< if (intStrLen = 4)||(intStrLen = 6)||(intStrLen = 8) { //SRBR014945a
          if ((mOp.Equal(intStrLen.get(),4)) || (mOp.Equal(intStrLen.get(),6)) || (mOp.Equal(intStrLen.get(),8))) {
            //<< ;if (intStrLen = 4)||(intStrLen = 8) {  //SRBR014945a
            //<< set $piece(pstrInput,"-",2) = $extract(strInput,3,4)
            m$.pieceVar(pstrInput,"-",2).set(m$.Fnc.$extract(strInput.get(),3,4));
          }
          //<< }
          //<< //SRBR014945a
          //<< if (intStrLen = 6) {
          if ((mOp.Equal(intStrLen.get(),6))) {
            //<< set $piece(pstrInput,"-",1) = $extract($piece($$$DateYear(dteToday),"-",1),1,2) _ $extract(strInput,5,6)
            m$.pieceVar(pstrInput,"-",1).set(mOp.Concat(m$.Fnc.$extract(m$.Fnc.$piece(include.COMSYSDate.$$$DateYear(m$,dteToday),"-",1),1,2),m$.Fnc.$extract(strInput.get(),5,6)));
          }
          //<< }
          //<< //^^^^SRBR014945a
          //<< if (intStrLen = 8) {
          if ((mOp.Equal(intStrLen.get(),8))) {
            //<< set $piece(pstrInput,"-",1) = $extract(strInput,5,8)
            m$.pieceVar(pstrInput,"-",1).set(m$.Fnc.$extract(strInput.get(),5,8));
          }
          //<< }
          //<< set dte = $zdateh(pstrInput,3,,,,,,,"")                         // Set to "" if error
          dte.set(m$.Fnc.$zdateh(pstrInput.get(),3,null,null,null,null,null,null,""));
        }
        //<< ; ---^^^^^
        //<< } else {                    // Have month. Translate delimiter and may add year.
        else {
          //<< set strDelim = $extract($$SystemDateFormat^WWWDATE(),3)
          strDelim.set(m$.Fnc.$extract(m$.fnc$("WWWDATE.SystemDateFormat"),3));
          //<< if strDelim'="." set pstrInput = $translate(pstrInput,".",strDelim)
          if (mOp.NotEqual(strDelim.get(),".")) {
            pstrInput.set(m$.Fnc.$translate(pstrInput.get(),".",strDelim.get()));
          }
          //<< if $piece(pstrInput,strDelim,3)="" set $piece(pstrInput,strDelim,3) = $$$DateYear(dteToday)
          if (mOp.Equal(m$.Fnc.$piece(pstrInput.get(),strDelim.get(),3),"")) {
            m$.pieceVar(pstrInput,strDelim.get(),3).set(include.COMSYSDate.$$$DateYear(m$,dteToday));
          }
          //<< set dte = $$^WWWDATE1(pstrInput)
          dte.set(m$.fnc$("WWWDATE1.main",pstrInput.get()));
        }
      }
    }
    //<< }
    //<< }   //SRBR014945a
    //<< 
    //<< } else {        // For all others, get internal then display
    else {
      //<< if (pstrInput=".") || (pstrInput=",") {                 // TODAY
      if ((mOp.Equal(pstrInput.get(),".")) || (mOp.Equal(pstrInput.get(),","))) {
        //<< set dte = dteToday
        dte.set(dteToday.get());
      }
      //<< 
      //<< } elseif $extract(pstrInput)="-" {
      else if (mOp.Equal(m$.Fnc.$extract(pstrInput.get()),"-")) {
        //<< set dte = dteToday - $extract(pstrInput,2,9)        // today - days
        dte.set(mOp.Subtract(dteToday.get(),m$.Fnc.$extract(pstrInput.get(),2,9)));
      }
      //<< 
      //<< } elseif $extract(pstrInput)="+" {
      else if (mOp.Equal(m$.Fnc.$extract(pstrInput.get()),"+")) {
        //<< set dte = dteToday + $extract(pstrInput,2,9)        // today + days
        dte.set(mOp.Add(dteToday.get(),m$.Fnc.$extract(pstrInput.get(),2,9)));
      }
      //<< 
      //<< } else {        // First char is not number, lookup alpha
      else {
        //<< set intDate = $order(^WWW101s(0,1,$$$Index(pstrInput),"COMDAYSOFWEEKSHORT",SPRACHE,""))
        intDate.set(m$.Fnc.$order(m$.var("^WWW101s",0,1,include.COMConst.$$$Index(m$,pstrInput),"COMDAYSOFWEEKSHORT",m$.var("SPRACHE").get(),"")));
        //<< if intDate'="" {
        if (mOp.NotEqual(intDate.get(),"")) {
          //<< set intToday = $$$DayOfWeek(dteToday)           // Today
          intToday.set(include.COMSYSDate.$$$DayOfWeek(m$,dteToday));
          //<< set dte = dteToday - intToday + intDate
          dte.set(mOp.Add(mOp.Subtract(dteToday.get(),intToday.get()),intDate.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if dte="" {
    if (mOp.Equal(dte.get(),"")) {
      //<< set %TXT(1) = "§"_$$^WWWTEXT(272)           ;Wrong date Format
      m$.var("%TXT",1).set(mOp.Concat("§",m$.fnc$("WWWTEXT.main",272)));
      //<< set pstrInput = ""
      pstrInput.set("");
    }
    //<< } else {
    else {
      //<< set pstrInput = $$^WWWDATE(dte)
      pstrInput.set(m$.fnc$("WWWDATE.main",dte.get()));
    }
    //<< }
    //<< quit dte
    return dte.get();
  }

  //<< 
  //<< 
  //<< CustPattern(YINHALT,pstrPattern)
  public Object CustPattern(Object ... _p) {
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrPattern = m$.newVarRef("pstrPattern",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Customised pattern match
    //<< ;
    //<< ; Params:   YINHALT     - input
    //<< ;           pobjCust    - customised record.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 05-Apr-2007   JW&HB   BR014420: Simplified
    //<< ; 31-Jan-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< if (YINHALT?@pstrPattern=0) {
    if ((mOp.Equal(mOp.Match(YINHALT.get(),m$.indirectVar("pstrPattern").get()),0))) {
      //<< set %TXT(1) = $$$Confirm_$$^WWWTEXT(276,,1)     ; "Wrong Input Format"
      m$.var("%TXT",1).set(mOp.Concat(include.COMSYS.$$$Confirm(m$),m$.fnc$("WWWTEXT.main",276,null,1)));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< /*
  //<< 
  //<< quit:$TRANSLATE(YINHALT," ")=""
  //<< 
  //<< set strPattern = $$$WWW122DPatternMatch(pobjCust)       // Same for WWW121 and WWW122
  //<< 
  //<< quit:(strPattern="")
  //<< quit:($$$StripNum(YINHALT)=$$$StripNum(strPattern))
  //<< quit:$TRANSLATE($$$UPPER(YINHALT),"1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZÖÄÜß{}")=$TRANSLATE($$^WWWUMLAU(strPattern),"1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZÖÄÜß{}")
  //<< 
  //<< SET PATTERN1=""
  //<< SET I(2)=""
  //<< FOR loop=1:1 {
  //<< SET I(1)=$EXTRACT(strPattern,loop)
  //<< QUIT:I(1)=""
  //<< 
  //<< IF I(1)="X" {
  //<< SET I(2)=I(2)+1
  //<< SET I(1)=$EXTRACT(YINHALT,I(2))   ;ALPHA
  //<< } elseIF I(1)="9" {
  //<< SET I(2)=I(2)+1
  //<< SET I(1)=+$EXTRACT(YINHALT,I(2))  ;NUMERIC
  //<< }
  //<< SET PATTERN1=PATTERN1_I(1)
  //<< }
  //<< 
  //<< if YART'="P" {      // Is this apt ?
  //<< IF $FIND(PATTERN1,"{YBED}") SET PATTERN1=$$^WWWTRANSLATE(PATTERN1,"{YBED}",$GET(YBED))
  //<< IF $FIND(PATTERN1,"{YLOCATION}") SET PATTERN1=$$^WWWTRANSLATE(PATTERN1,"{YLOCATION}",$GET(YLOCATION))
  //<< IF $FIND(PATTERN1,"{YM}") SET PATTERN1=$$^WWWTRANSLATE(PATTERN1,"{YM}",$GET(YM))
  //<< }
  //<< IF PATTERN1'="" SET YINHALT=PATTERN1   ;TYBD;PATTERNMATCH;5,8,2004;25514;
  //<< 
  //<< quit
  //<< */
  //<< 
  //<< 
  //<< CustomWarnings(&YXTEXT,YINHALT,pobjCustFld)
  public Object CustomWarnings(Object ... _p) {
    mVar YXTEXT = m$.newVarRef("YXTEXT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjCustFld = m$.newVarRef("pobjCustFld",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Sondertext hinweis  ;Special Text
    //<< ; wenn syntax: ;when
    //<< ;     IF: 1 TEXT WENN INHALT=1 ;Text when
    //<< ;     IF: '1 TEXT WENN INHALT NICHT 1 ;Text when purport Not
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Mar-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< IF YINHALT'="" && (pobjCustFld'="") {
    if (mOp.NotEqual(YINHALT.get(),"") && (mOp.NotEqual(pobjCustFld.get(),""))) {
      //<< SET YXTEXT=$$$WWW122DIndividualWarnings(pobjCustFld)
      YXTEXT.set(include.WWWConst.$$$WWW122DIndividualWarnings(m$,pobjCustFld));
      //<< 
      //<< IF $EXTRACT(YXTEXT,1,7)="IF NOT:" SET YXTEXT="IF:'"_$EXTRACT(YXTEXT,8,999)  ;FIS;24141;11.08.03
      if (mOp.Equal(m$.Fnc.$extract(YXTEXT.get(),1,7),"IF NOT:")) {
        YXTEXT.set(mOp.Concat("IF:'",m$.Fnc.$extract(YXTEXT.get(),8,999)));
      }
      //<< IF $EXTRACT(YXTEXT,1,3)="IF:" {  ;nur wenn eintrag dann anzeige ;solely when
      if (mOp.Equal(m$.Fnc.$extract(YXTEXT.get(),1,3),"IF:")) {
        //<< SET YXTEXT(1)=YXTEXT
        YXTEXT.var(1).set(YXTEXT.get());
        //<< SET YXTEXT=""
        YXTEXT.set("");
        //<< 
        //<< FOR YXTEXT(2)=2:1 {
        for (YXTEXT.set(2);(true);YXTEXT.set(mOp.Add(YXTEXT.get(),1))) {
          //<< QUIT:$PIECE(YXTEXT(1),"IF:",YXTEXT(2))=""
          if (mOp.Equal(m$.Fnc.$piece(YXTEXT.var(1).get(),"IF:",YXTEXT.var(2).get()),"")) {
            break;
          }
          //<< SET YXTEXT(3)=$PIECE(YXTEXT(1),"IF:",YXTEXT(2))
          YXTEXT.var(3).set(m$.Fnc.$piece(YXTEXT.var(1).get(),"IF:",YXTEXT.var(2).get()));
          //<< 
          //<< IF $EXTRACT(YXTEXT(3))=" " SET YXTEXT(3)=$EXTRACT(YXTEXT(3),2,999)
          if (mOp.Equal(m$.Fnc.$extract(YXTEXT.var(3).get())," ")) {
            YXTEXT.var(3).set(m$.Fnc.$extract(YXTEXT.var(3).get(),2,999));
          }
          //<< IF $EXTRACT(YXTEXT(3))'="'" IF YINHALT=$PIECE(YXTEXT(3)," ",1)                  SET YXTEXT=$PIECE(YXTEXT(3)," ",2,999) QUIT
          if (mOp.NotEqual(m$.Fnc.$extract(YXTEXT.var(3).get()),"'")) {
            if (mOp.Equal(YINHALT.get(),m$.Fnc.$piece(YXTEXT.var(3).get()," ",1))) {
              YXTEXT.set(m$.Fnc.$piece(YXTEXT.var(3).get()," ",2,999));
              break;
            }
          }
          //<< IF $EXTRACT(YXTEXT(3))="'"  IF YINHALT'=$EXTRACT($PIECE(YXTEXT(3)," ",1),2,999) SET YXTEXT=$PIECE(YXTEXT(3)," ",2,999) QUIT
          if (mOp.Equal(m$.Fnc.$extract(YXTEXT.var(3).get()),"'")) {
            if (mOp.NotEqual(YINHALT.get(),m$.Fnc.$extract(m$.Fnc.$piece(YXTEXT.var(3).get()," ",1),2,999))) {
              YXTEXT.set(m$.Fnc.$piece(YXTEXT.var(3).get()," ",2,999));
              break;
            }
          }
        }
        //<< }
        //<< SET YXTEXT=$$^WWWTRANSLATE(YXTEXT,"|","'")  ;Is this appropriate here?
        YXTEXT.set(m$.fnc$("WWWTRANSLATE.main",YXTEXT.get(),"|","'"));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< InputOk(YINHALT,YSATZ,YVOR)
  public Object InputOk(Object ... _p) {
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YSATZ = m$.newVarRef("YSATZ",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YVOR = m$.newVarRef("YVOR",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check whether the input is valid
    //<< ;
    //<< ;
    //<< ;   FIXME :  Need to update YSATZ before passing it to this routine.
    //<< ;            e.g. $$$Get^WWW122 for WWW122/WWW122D
    //<< ;            Doesn't happen for WWW121/WWW121D but does for WWW122/WWW122D.
    //<< ;
    //<< ;
    //<< ;   NOTE : This is called to validate both ***KEYS*** and ***DATA***.
    //<< ;     (i.e. WWW121 and WWW122 - thus common checks need to be in the same piece)
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jun-2008   GRF     BR014945: new variable for code check
    //<< ; 20-Mar-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new blnMandatory,intChar,intMin,strAllow,strBlockChars,strMsg,strPattern,strTestChar
    mVar blnMandatory = m$.var("blnMandatory");
    mVar intChar = m$.var("intChar");
    mVar intMin = m$.var("intMin");
    mVar strAllow = m$.var("strAllow");
    mVar strBlockChars = m$.var("strBlockChars");
    mVar strMsg = m$.var("strMsg");
    mVar strPattern = m$.var("strPattern");
    mVar strTestChar = m$.var("strTestChar");
    m$.newVar(blnMandatory,intChar,intMin,strAllow,strBlockChars,strMsg,strPattern,strTestChar);
    //<< 
    //<< $$$LogR("InputOk",$get(YINHALT)_"<"_$get(YART))
    $$$LogR(m$,"InputOk",mOp.Concat(mOp.Concat(m$.Fnc.$get(YINHALT),"<"),m$.Fnc.$get(m$.var("YART"))));
    //<< 
    //<< set strMsg=""
    strMsg.set("");
    //<< 
    //<< set blnMandatory = $$$WWW122MandatoryInputItem(YSATZ)
    blnMandatory.set(include.WWWConst.$$$WWW122MandatoryInputItem(m$,YSATZ));
    //<< if blnMandatory && $$$WWW120CheckForMandatoryFields(YVOR) && (YART'="P") {
    if (mOp.Logical(blnMandatory.get()) && mOp.Logical(include.WWWConst.$$$WWW120CheckForMandatoryFields(m$,YVOR)) && (mOp.NotEqual(m$.var("YART").get(),"P"))) {
      //<< 
      //<< // TODO - Why remove spaces before checking blank ?
      //<< if $translate(YINHALT," ")="" {
      if (mOp.Equal(m$.Fnc.$translate(YINHALT.get()," "),"")) {
        //<< set strMsg = $$^WWWTEXT(267,,1)         ; "Mandatory Field"
        strMsg.set(m$.fnc$("WWWTEXT.main",267,null,1));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if strMsg="" {
    if (mOp.Equal(strMsg.get(),"")) {
      //<< set strPattern = $$$WWW122PatternMatch(YSATZ)
      strPattern.set(include.WWWConst.$$$WWW122PatternMatch(m$,YSATZ));
      //<< if strPattern'="" {
      if (mOp.NotEqual(strPattern.get(),"")) {
        //<< if YINHALT?@strPattern=0 {
        if (mOp.Equal(mOp.Match(YINHALT.get(),m$.indirectVar("strPattern").get()),0)) {
          //<< set strMsg = $$^WWWTEXT(276,,1)     ; "Wrong Input Format"
          strMsg.set(m$.fnc$("WWWTEXT.main",276,null,1));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if strMsg="" {
    if (mOp.Equal(strMsg.get(),"")) {
      //<< set strAllow = $$$WWW122OnlyAllowChars(YSATZ)
      strAllow.set(include.WWWConst.$$$WWW122OnlyAllowChars(m$,YSATZ));
      //<< if strAllow'="" {
      if (mOp.NotEqual(strAllow.get(),"")) {
        //<< for intChar=1:1:$length(YINHALT) {
        for (intChar.set(1);(mOp.LessOrEqual(intChar.get(),m$.Fnc.$length(YINHALT.get())));intChar.set(mOp.Add(intChar.get(),1))) {
          //<< if '$find(strAllow,$extract(YINHALT,intChar)) {
          if (mOp.Not(m$.Fnc.$find(strAllow.get(),m$.Fnc.$extract(YINHALT.get(),intChar.get())))) {
            //<< set strMsg = $$^WWWTEXT(269,,1)_" "_$piece(YSATZ,Y,17)
            strMsg.set(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",269,null,1)," "),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),17)));
            //<< quit
            break;
          }
        }
      }
    }
    //<< } ; "Only Following Characters Allowed"
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if strMsg="" && (YINHALT'="") {               ; SR12505
    if (mOp.Equal(strMsg.get(),"") && (mOp.NotEqual(YINHALT.get(),""))) {
      //<< set strBlockChars = $$$WWW122DontAllowChars(YSATZ)
      strBlockChars.set(include.WWWConst.$$$WWW122DontAllowChars(m$,YSATZ));
      //<< for intChar=1:1:$length(strBlockChars) {
      for (intChar.set(1);(mOp.LessOrEqual(intChar.get(),m$.Fnc.$length(strBlockChars.get())));intChar.set(mOp.Add(intChar.get(),1))) {
        //<< set strTestChar = $extract(strBlockChars,intChar)
        strTestChar.set(m$.Fnc.$extract(strBlockChars.get(),intChar.get()));
        //<< continue:strTestChar=" "
        if (mOp.Equal(strTestChar.get()," ")) {
          continue;
        }
        //<< 
        //<< if YINHALT[strTestChar {
        if (mOp.Contains(YINHALT.get(),strTestChar.get())) {
          //<< set strMsg = $$^WWWTEXT(287,,1)_" "_strBlockChars
          strMsg.set(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",287,null,1)," "),strBlockChars.get()));
          //<< quit
          break;
        }
      }
    }
    //<< } ; "The following characters are not allowed"
    //<< }
    //<< }
    //<< 
    //<< if strMsg="" {
    if (mOp.Equal(strMsg.get(),"")) {
      //<< if (blnMandatory || (YINHALT'="")) {                // Don't check if mandatory and null
      if ((mOp.Logical(blnMandatory.get()) || (mOp.NotEqual(YINHALT.get(),"")))) {
        //<< set intMin = $$$WWW122MinInputLength(YSATZ)
        intMin.set(include.WWWConst.$$$WWW122MinInputLength(m$,YSATZ));
        //<< if (intMin'="") && ($length(YINHALT)<intMin) {
        if ((mOp.NotEqual(intMin.get(),"")) && (mOp.Less(m$.Fnc.$length(YINHALT.get()),intMin.get()))) {
          //<< set strMsg = $$^WWWTEXT(268,,1)_" "_+intMin     ; "Min. Input Length"
          strMsg.set(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",268,null,1)," "),mOp.Positive(intMin.get())));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< set:strMsg'="" %TXT(1) = $$$Confirm_strMsg
    if (mOp.NotEqual(strMsg.get(),"")) {
      m$.var("%TXT",1).set(mOp.Concat(include.COMSYS.$$$Confirm(m$),strMsg.get()));
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DateOk(&YINHALT,&pdte,pstrCheck)
  public Object DateOk(Object ... _p) {
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pdte = m$.newVarRef("pdte",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrCheck = m$.newVarRef("pstrCheck",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Date Validation against specification
    //<< ;
    //<< ; Called By : FIELD^WWWEVENT
    //<< ;
    //<< ; Params:
    //<< ;   YINHALT             Current value
    //<< ;   pdte      (ByRef)   $$TranslateDate^WWWFieldRules(YINHALT) - May be reset to today
    //<< ;   pstrCheck           Date match specification string (from $$$WWW122ExecuteOnBlur for date field)
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jun-2008   GRF     BR014945: new variable for code check
    //<< ; 26-Mar-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new dteToday,strMsg
    mVar dteToday = m$.var("dteToday");
    mVar strMsg = m$.var("strMsg");
    m$.newVar(dteToday,strMsg);
    //<< 
    //<< $$$LogR("DateOk",$get(YINHALT)_"<"_$get(pdte)_"<"_pstrCheck_"<")
    $$$LogR(m$,"DateOk",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(YINHALT),"<"),m$.Fnc.$get(pdte)),"<"),pstrCheck.get()),"<"));
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;               Assuming $h = 60040
    //<< ;
    //<< ;           Compare     ----------------------  pdte  -----------------------
    //<< ;pstrCheck   with       60000       60025       60040       60045       60100
    //<< ;   -30     60010        OK     :     x           x           x           x     Before a set date   Check
    //<< ;   -       60040        OK          OK          OK :         x           x     Any Past Date       Error
    //<< ;   .       60040         x           x        : OK :         x           x     Only Today          Force to Today
    //<< ;   +       60040         x           x        : OK          OK          OK     Any Future Date     Error
    //<< ;   +30     60070         x           x           x           x     :    OK     After a set date    Check
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< set strMsg = ""
    strMsg.set("");
    //<< 
    //<< if YINHALT'="" {
    if (mOp.NotEqual(YINHALT.get(),"")) {
      //<< set dteToday = +$horolog
      dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
      //<< 
      //<< // Past dates only
      //<< if $extract(pstrCheck)="-" {
      if (mOp.Equal(m$.Fnc.$extract(pstrCheck.get()),"-")) {
        //<< if +$extract(pstrCheck,2,9)'=0 {
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$extract(pstrCheck.get(),2,9)),0)) {
          //<< if pdte > (dteToday-$extract(pstrCheck,2,9)) {
          if (mOp.Greater(pdte.get(),(mOp.Subtract(dteToday.get(),m$.Fnc.$extract(pstrCheck.get(),2,9))))) {
            //<< set strMsg = $$$Confirm_$$^WWWTEXT(294,,1)_" ("_YINHALT_")" ; Is The Date Correct?
            strMsg.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYS.$$$Confirm(m$),m$.fnc$("WWWTEXT.main",294,null,1))," ("),YINHALT.get()),")"));
          }
        }
        //<< }
        //<< } elseif pdte > dteToday {
        else if (mOp.Greater(pdte.get(),dteToday.get())) {
          //<< set strMsg = $$$AlertAndFocus_$$^WWWTEXT(271,,1)        ; "Wrong Date"
          strMsg.set(mOp.Concat(include.COMSYS.$$$AlertAndFocus(m$),m$.fnc$("WWWTEXT.main",271,null,1)));
          //<< set YINHALT=""
          YINHALT.set("");
        }
      }
      //<< }
      //<< 
      //<< // Future dates only
      //<< } elseif $extract(pstrCheck)="+" {
      else if (mOp.Equal(m$.Fnc.$extract(pstrCheck.get()),"+")) {
        //<< if +$extract(pstrCheck,2,9)'=0 {
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$extract(pstrCheck.get(),2,9)),0)) {
          //<< if pdte < (dteToday+$extract(pstrCheck,2,9)) {
          if (mOp.Less(pdte.get(),(mOp.Add(dteToday.get(),m$.Fnc.$extract(pstrCheck.get(),2,9))))) {
            //<< set strMsg = $$$Confirm_$$^WWWTEXT(294,,1)_" ("_YINHALT_")" ; Is The Date Correct?
            strMsg.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYS.$$$Confirm(m$),m$.fnc$("WWWTEXT.main",294,null,1))," ("),YINHALT.get()),")"));
          }
        }
        //<< }
        //<< } elseif pdte < dteToday {
        else if (mOp.Less(pdte.get(),dteToday.get())) {
          //<< set strMsg = $$$AlertAndFocus_$$^WWWTEXT(271,,1)        ; "Wrong Date"
          strMsg.set(mOp.Concat(include.COMSYS.$$$AlertAndFocus(m$),m$.fnc$("WWWTEXT.main",271,null,1)));
          //<< set YINHALT=""
          YINHALT.set("");
        }
      }
      //<< }
      //<< 
      //<< // Only today
      //<< } elseif (pstrCheck=".") || (pstrCheck=",") {
      else if ((mOp.Equal(pstrCheck.get(),".")) || (mOp.Equal(pstrCheck.get(),","))) {
        //<< if pdte'=dteToday {
        if (mOp.NotEqual(pdte.get(),dteToday.get())) {
          //<< set pdte = dteToday
          pdte.set(dteToday.get());
          //<< set YINHALT = $$^WWWDATE(dteToday)
          YINHALT.set(m$.fnc$("WWWDATE.main",dteToday.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< set:strMsg'="" %TXT(1) = strMsg
    if (mOp.NotEqual(strMsg.get(),"")) {
      m$.var("%TXT",1).set(strMsg.get());
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ReadWrite(YINHALTX,YSATZ,YEART,YART)
  public Object ReadWrite(Object ... _p) {
    mVar YINHALTX = m$.newVarRef("YINHALTX",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YSATZ = m$.newVarRef("YSATZ",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YEART = m$.newVarRef("YEART",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; FREIE FELDER AUF READONLY SETZEN  ;FREE FIELDS ON READONLY SETTING
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
    //<< ; 31-Jan-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< NEW HIDDENF,TRIGGER,YLFN1,TRIGGERN,TRIGGER1,DISPLAY,OPERA,YTYP1,blnTrigger
    mVar HIDDENF = m$.var("HIDDENF");
    mVar TRIGGER = m$.var("TRIGGER");
    mVar YLFN1 = m$.var("YLFN1");
    mVar TRIGGERN = m$.var("TRIGGERN");
    mVar TRIGGER1 = m$.var("TRIGGER1");
    mVar DISPLAY = m$.var("DISPLAY");
    mVar OPERA = m$.var("OPERA");
    mVar YTYP1 = m$.var("YTYP1");
    mVar blnTrigger = m$.var("blnTrigger");
    m$.newVar(HIDDENF,TRIGGER,YLFN1,TRIGGERN,TRIGGER1,DISPLAY,OPERA,YTYP1,blnTrigger);
    //<< 
    //<< IF YEART=2 {                                            // Is this necessary ??
    if (mOp.Equal(YEART.get(),2)) {
      //<< IF YINHALTX=-1 SET YINHALTX=1  ;CHECKBOX AN ;upon
      if (mOp.Equal(YINHALTX.get(),mOp.Negative(1))) {
        YINHALTX.set(1);
      }
      //<< IF YINHALTX=0 SET YINHALTX=""  ;CHECKBOX AUS ;out of
      if (mOp.Equal(YINHALTX.get(),0)) {
        YINHALTX.set("");
      }
    }
    //<< }
    //<< 
    //<< SET HIDDENF=$TRANSLATE($$$WWW122READOnlyFieldsWithFieldEn(YSATZ),";",",")   // Why translate ?
    HIDDENF.set(m$.Fnc.$translate(include.WWWConst.$$$WWW122READOnlyFieldsWithFieldEn(m$,YSATZ),";",","));
    //<< if HIDDENF'="" {
    if (mOp.NotEqual(HIDDENF.get(),"")) {
      //<< 
      //<< // Does this really make sense?
      //<< // We loop through each trigger, setting the fields EACH time
      //<< // That means, for each trigger, we update every field...
      //<< // Surely we should update the fields ONCE ?
      //<< //
      //<< // And then we do the WRITE ones below. How can this work?
      //<< 
      //<< SET TRIGGER1=$TRANSLATE($$$WWW122ReadOnlyTriggers(YSATZ),";",",")
      TRIGGER1.set(m$.Fnc.$translate(include.WWWConst.$$$WWW122ReadOnlyTriggers(m$,YSATZ),";",","));
      //<< 
      //<< FOR TRIGGERN=1:1 {
      for (TRIGGERN.set(1);(true);TRIGGERN.set(mOp.Add(TRIGGERN.get(),1))) {
        //<< SET TRIGGER=$PIECE(TRIGGER1,",",TRIGGERN)       ;ALLE TRIGGER AUSWERTEN
        TRIGGER.set(m$.Fnc.$piece(TRIGGER1.get(),",",TRIGGERN.get()));
        //<< 
        //<< set blnTrigger = $$TriggerCheck(TRIGGER,YINHALTX,YEART)
        blnTrigger.set(m$.fnc$("TriggerCheck",TRIGGER.get(),YINHALTX.get(),YEART.get()));
        //<< set DISPLAY = $select(blnTrigger:"READ",1:"WRITE")
        DISPLAY.set(m$.Fnc.$select(blnTrigger.get(),"READ",1,"WRITE"));
        //<< 
        //<< FOR HIDDENF(1)=1:1 {
        for (m$.var("HIDDENF",1).set(1);(true);m$.var("HIDDENF",1).set(mOp.Add(m$.var("HIDDENF",1).get(),1))) {
          //<< SET HIDDENF(2)=$PIECE(HIDDENF,",",HIDDENF(1))
          HIDDENF.var(2).set(m$.Fnc.$piece(HIDDENF.get(),",",HIDDENF.var(1).get()));
          //<< QUIT:HIDDENF(2)=""
          if (mOp.Equal(HIDDENF.var(2).get(),"")) {
            break;
          }
          //<< 
          //<< SET YLFN1=$$$WWW122SequenceNumber($GET(^WWW122(0,YFORM,HIDDENF(2),1)))  ;datenfeld
          YLFN1.set(include.WWWConst.$$$WWW122SequenceNumber(m$,m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),HIDDENF.var(2).get(),1))));
          //<< IF YLFN1="" SET YLFN1=HIDDENF(2)
          if (mOp.Equal(YLFN1.get(),"")) {
            YLFN1.set(HIDDENF.var(2).get());
          }
          //<< 
          //<< SET %TXT(1)=%TXT(1)_"#Y"_YFORM_YART_YLFN1_"~"_DISPLAY
          m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#Y"),m$.var("YFORM").get()),YART.get()),YLFN1.get()),"~"),DISPLAY.get()));
          //<< 
          //<< // What is the following block of code actually doing?
          //<< // For starters YART is incorrectly used, as it refers to the event field, not the field to update (HIDDENF)
          //<< // YTYP1 maybe incorrect - and it should also call GetInputType^WWWField.
          //<< 
          //<< SET YTYP1=""
          YTYP1.set("");
          //<< IF YART="D" SET YTYP1=$PIECE($GET(^WWW003(0,YDATEI,YLFN1,1)),Y,3)  ;FIS;01.09.04
          if (mOp.Equal(YART.get(),"D")) {
            YTYP1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN1.get(),1)),m$.var("Y").get(),3));
          }
          //<< IF YART="M" SET YTYP1=$PIECE($GET(^WWW122(0,YFORM,YLFN1,1)),Y,5)   ;FIS;01.09.04
          if (mOp.Equal(YART.get(),"M")) {
            YTYP1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YLFN1.get(),1)),m$.var("Y").get(),5));
          }
          //<< if blnTrigger {
          if (mOp.Logical(blnTrigger.get())) {
            //<< IF YART="D" IF YTYP1'="" SET %TXT(1)=%TXT(1)_"#Y"_YFORM_YART_YLFN1_"~"_$$GetLiteral^WWWTR(YTYP1,$PIECE($GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,YART,1)),Y,YLFN1))  ;FELDINHALT BEIBEHALTEN;FIS;09.08.04;26180  ;FIS;01.09.04
            if (mOp.Equal(YART.get(),"D")) {
              if (mOp.NotEqual(YTYP1.get(),"")) {
                m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#Y"),m$.var("YFORM").get()),YART.get()),YLFN1.get()),"~"),m$.fnc$("WWWTR.GetLiteral",YTYP1.get(),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),YART.get(),1)),m$.var("Y").get(),YLFN1.get()))));
              }
            }
            //<< IF YART="D" IF YTYP1=""  SET %TXT(1)=%TXT(1)_"#Y"_YFORM_YART_YLFN1_"~"_$PIECE($GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,YART,1)),Y,YLFN1)  ;FELDINHALT BEIBEHALTEN;FIS;09.08.04;26180
            if (mOp.Equal(YART.get(),"D")) {
              if (mOp.Equal(YTYP1.get(),"")) {
                m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#Y"),m$.var("YFORM").get()),YART.get()),YLFN1.get()),"~"),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),YART.get(),1)),m$.var("Y").get(),YLFN1.get())));
              }
            }
            //<< IF YART="M" SET $PIECE(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,YART,1),Y,YLFN1)=""  ;FELDINHALT LÖSCHEN;FIS;09.08.04;26180  ;FIS;19.08.04;26300;NUR WENN READONLY
            if (mOp.Equal(YART.get(),"M")) {
              m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),YART.get(),1),m$.var("Y").get(),YLFN1.get()).set("");
            }
          }
        }
        //<< }
        //<< }
        //<< QUIT:$PIECE(TRIGGER1,",",TRIGGERN+1)=""
        if (mOp.Equal(m$.Fnc.$piece(TRIGGER1.get(),",",mOp.Add(TRIGGERN.get(),1)),"")) {
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; YEART = Field Type (Sys Parameter FELDTYP).
    //<< 
    //<< ;READONLY FELDER FREIGEBEN  ;READONLY FIELDS RELEASING
    //<< 
    //<< set HIDDENF=$translate($$$WWW122WriteFieldsWithFieldEntry(YSATZ),";",",")
    HIDDENF.set(m$.Fnc.$translate(include.WWWConst.$$$WWW122WriteFieldsWithFieldEntry(m$,YSATZ),";",","));
    //<< if HIDDENF'="" {
    if (mOp.NotEqual(HIDDENF.get(),"")) {
      //<< set TRIGGER1=$translate($$$WWW122WriteTrigger(YSATZ),";",",")
      TRIGGER1.set(m$.Fnc.$translate(include.WWWConst.$$$WWW122WriteTrigger(m$,YSATZ),";",","));
      //<< 
      //<< for TRIGGERN=1:1 {
      for (TRIGGERN.set(1);(true);TRIGGERN.set(mOp.Add(TRIGGERN.get(),1))) {
        //<< set TRIGGER=$piece(TRIGGER1,",",TRIGGERN)
        TRIGGER.set(m$.Fnc.$piece(TRIGGER1.get(),",",TRIGGERN.get()));
        //<< 
        //<< set blnTrigger = $$TriggerCheck(TRIGGER,YINHALTX,YEART)
        blnTrigger.set(m$.fnc$("TriggerCheck",TRIGGER.get(),YINHALTX.get(),YEART.get()));
        //<< set DISPLAY = $select(blnTrigger:"WRITE",1:"READ")      // Inverse of above
        DISPLAY.set(m$.Fnc.$select(blnTrigger.get(),"WRITE",1,"READ"));
        //<< 
        //<< for HIDDENF(1)=1:1 {
        for (m$.var("HIDDENF",1).set(1);(true);m$.var("HIDDENF",1).set(mOp.Add(m$.var("HIDDENF",1).get(),1))) {
          //<< set HIDDENF(2)=$piece(HIDDENF,",",HIDDENF(1))
          HIDDENF.var(2).set(m$.Fnc.$piece(HIDDENF.get(),",",HIDDENF.var(1).get()));
          //<< quit:HIDDENF(2)=""
          if (mOp.Equal(HIDDENF.var(2).get(),"")) {
            break;
          }
          //<< 
          //<< set YLFN1=$piece($get(^WWW122(0,YFORM,HIDDENF(2),1)),Y,1)  ;datenfeld
          YLFN1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),HIDDENF.var(2).get(),1)),m$.var("Y").get(),1));
          //<< if YLFN1="" set YLFN1=HIDDENF(2)
          if (mOp.Equal(YLFN1.get(),"")) {
            YLFN1.set(HIDDENF.var(2).get());
          }
          //<< set %TXT(1)=%TXT(1)_"#Y"_YFORM_YART_YLFN1_"~"_DISPLAY
          m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#Y"),m$.var("YFORM").get()),YART.get()),YLFN1.get()),"~"),DISPLAY.get()));
        }
        //<< }
        //<< quit:$piece(TRIGGER1,",",TRIGGERN+1)=""  ;ALLE TRIGGER AUSWERTEN
        if (mOp.Equal(m$.Fnc.$piece(TRIGGER1.get(),",",mOp.Add(TRIGGERN.get(),1)),"")) {
          break;
        }
      }
      //<< }
      //<< 
      //<< // English hard coded ?
      //<< // Should this be an else/if to the above block ?
      //<< // Why only for write, not read ?
      //<< // %TXT(1) is overwritten ?
      //<< // YART is incorrect, as above
      //<< 
      //<< if $find(TRIGGER1,"***") && (YINHALTX'="") {
      if (mOp.Logical(m$.Fnc.$find(TRIGGER1.get(),"***")) && (mOp.NotEqual(YINHALTX.get(),""))) {
        //<< 
        //<< if '$data(^WWWCODE(YM,YINHALTX,1)) {
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWWCODE",m$.var("YM").get(),YINHALTX.get(),1)))) {
          //<< set %TXT(1)="!Wrong Code!"
          m$.var("%TXT",1).set("!Wrong Code!");
        }
        //<< } elseif $$$WWWCODEUsed($GET(^WWWCODE(YM,YINHALTX,1))) {
        else if (mOp.Logical(include.WWWConst.$$$WWWCODEUsed(m$,m$.Fnc.$get(m$.var("^WWWCODE",m$.var("YM").get(),YINHALTX.get(),1))))) {
          //<< set %TXT(1)="!Code Used!"
          m$.var("%TXT",1).set("!Code Used!");
        }
        //<< } else {
        else {
          //<< set $$$WWWCODEUsed(^WWWCODE(YM,YINHALTX,1))=$$$YES
          include.WWWConst.$$$WWWCODEUsedSet(m$,m$.var("^WWWCODE",m$.var("YM").get(),YINHALTX.get(),1),include.COMSYS.$$$YES(m$));
          //<< set %TXT(1)=""
          m$.var("%TXT",1).set("");
          //<< for HIDDENF(1)=1:1 {
          for (m$.var("HIDDENF",1).set(1);(true);m$.var("HIDDENF",1).set(mOp.Add(m$.var("HIDDENF",1).get(),1))) {
            //<< set HIDDENF(2)=$piece(HIDDENF,",",HIDDENF(1))
            HIDDENF.var(2).set(m$.Fnc.$piece(HIDDENF.get(),",",HIDDENF.var(1).get()));
            //<< quit:HIDDENF(2)=""
            if (mOp.Equal(HIDDENF.var(2).get(),"")) {
              break;
            }
            //<< set YLFN1=$piece($get(^WWW122(0,YFORM,HIDDENF(2),1)),Y,1)  ;datenfeld
            YLFN1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),HIDDENF.var(2).get(),1)),m$.var("Y").get(),1));
            //<< if YLFN1="" set YLFN1=HIDDENF(2)
            if (mOp.Equal(YLFN1.get(),"")) {
              YLFN1.set(HIDDENF.var(2).get());
            }
            //<< set %TXT(1)=%TXT(1)_"#Y"_YFORM_YART_YLFN1_"~WRITE"
            m$.var("%TXT",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("%TXT",1).get(),"#Y"),m$.var("YFORM").get()),YART.get()),YLFN1.get()),"~WRITE"));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< TriggerCheck(TRIGGER,YINHALTX,YEART)
  public Object TriggerCheck(Object ... _p) {
    mVar TRIGGER = m$.newVarRef("TRIGGER",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YINHALTX = m$.newVarRef("YINHALTX",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YEART = m$.newVarRef("YEART",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
    //<< ; 31-Jan-2007   JW      SR15384: Encapsulated.
    //<< ;-------------------------------------------------------------------------------
    //<< new OPERA
    mVar OPERA = m$.var("OPERA");
    m$.newVar(OPERA);
    //<< 
    //<< set OPERA = $zstrip(TRIGGER,"*E","","'<>=")     ; Keep only '<>=
    OPERA.set(m$.Fnc.$zstrip(TRIGGER.get(),"*E","","'<>="));
    //<< 
    //<< // The following code should be optimised, and verified.
    //<< // Functionality doesn't seem correct. (eg. entering ' as a trigger)
    //<< 
    //<< IF TRIGGER=""  IF YINHALTX'="" quit $$$YES  ;READONLY BEI FELDEINTRAG ;next to
    if (mOp.Equal(TRIGGER.get(),"")) {
      if (mOp.NotEqual(YINHALTX.get(),"")) {
        return include.COMSYS.$$$YES(m$);
      }
    }
    //<< IF TRIGGER="'" IF YINHALTX=""  quit $$$YES  ;READONLY WENN KEIN FELDEINTRAG ;when no
    if (mOp.Equal(TRIGGER.get(),"'")) {
      if (mOp.Equal(YINHALTX.get(),"")) {
        return include.COMSYS.$$$YES(m$);
      }
    }
    //<< IF (OPERA="") || (OPERA="=") IF TRIGGER'="" IF YINHALTX=$TRANSLATE(TRIGGER,"=") quit $$$YES  ;READONLY BEI BESTIMMTEM EINTRAG ;next to
    if ((mOp.Equal(OPERA.get(),"")) || (mOp.Equal(OPERA.get(),"="))) {
      if (mOp.NotEqual(TRIGGER.get(),"")) {
        if (mOp.Equal(YINHALTX.get(),m$.Fnc.$translate(TRIGGER.get(),"="))) {
          return include.COMSYS.$$$YES(m$);
        }
      }
    }
    //<< IF (OPERA="") || (OPERA="=") IF TRIGGER'="" IF $$GetLiteral^WWWTR(YEART,YINHALTX)=$$GetLiteral^WWWTR(YEART,$TRANSLATE(TRIGGER,"=")) quit $$$YES  ;FIS;02.08.07;26180;ANZEIGEFORMAT VERGLEICHEN (Z.B. BEI WÄHRUNGEN)
    if ((mOp.Equal(OPERA.get(),"")) || (mOp.Equal(OPERA.get(),"="))) {
      if (mOp.NotEqual(TRIGGER.get(),"")) {
        if (mOp.Equal(m$.fnc$("WWWTR.GetLiteral",YEART.get(),YINHALTX.get()),m$.fnc$("WWWTR.GetLiteral",YEART.get(),m$.Fnc.$translate(TRIGGER.get(),"=")))) {
          return include.COMSYS.$$$YES(m$);
        }
      }
    }
    //<< IF OPERA="'"  IF $EXTRACT(TRIGGER,2,999)'="" IF YINHALTX'=$EXTRACT(TRIGGER,2,999) quit $$$YES  ;READONLY WENN NICHT BESTIMMTER FELDEINTRAG ;when Not
    if (mOp.Equal(OPERA.get(),"'")) {
      if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,999),"")) {
        if (mOp.NotEqual(YINHALTX.get(),m$.Fnc.$extract(TRIGGER.get(),2,999))) {
          return include.COMSYS.$$$YES(m$);
        }
      }
    }
    //<< IF OPERA="'=" IF $EXTRACT(TRIGGER,3,999)'="" IF YINHALTX'=$EXTRACT(TRIGGER,3,999) quit $$$YES  ;READONLY WENN NICHT BESTIMMTER FELDEINTRAG ;when Not
    if (mOp.Equal(OPERA.get(),"'=")) {
      if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,999),"")) {
        if (mOp.NotEqual(YINHALTX.get(),m$.Fnc.$extract(TRIGGER.get(),3,999))) {
          return include.COMSYS.$$$YES(m$);
        }
      }
    }
    //<< IF OPERA="<"  IF $EXTRACT(TRIGGER,2,999)'="" IF YINHALTX<$EXTRACT(TRIGGER,2,999)  quit $$$YES  ;READONLY WENN KLEINER VORGABE ;when lesser default
    if (mOp.Equal(OPERA.get(),"<")) {
      if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,999),"")) {
        if (mOp.Less(YINHALTX.get(),m$.Fnc.$extract(TRIGGER.get(),2,999))) {
          return include.COMSYS.$$$YES(m$);
        }
      }
    }
    //<< IF OPERA=">"  IF $EXTRACT(TRIGGER,2,999)'="" IF YINHALTX>$EXTRACT(TRIGGER,2,999)  quit $$$YES  ;READONLY WENN GROESSER VORGABE ;when default
    if (mOp.Equal(OPERA.get(),">")) {
      if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,999),"")) {
        if (mOp.Greater(YINHALTX.get(),m$.Fnc.$extract(TRIGGER.get(),2,999))) {
          return include.COMSYS.$$$YES(m$);
        }
      }
    }
    //<< IF OPERA="'<" IF $EXTRACT(TRIGGER,3,999)'="" IF YINHALTX'<$EXTRACT(TRIGGER,3,999) quit $$$YES  ;READONLY WENN GROESSER/GLEICH VORGABE ;when default
    if (mOp.Equal(OPERA.get(),"'<")) {
      if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,999),"")) {
        if (mOp.NotLess(YINHALTX.get(),m$.Fnc.$extract(TRIGGER.get(),3,999))) {
          return include.COMSYS.$$$YES(m$);
        }
      }
    }
    //<< IF OPERA="'>" IF $EXTRACT(TRIGGER,3,999)'="" IF YINHALTX'>$EXTRACT(TRIGGER,3,999) quit $$$YES  ;READONLY WENN KLEINER/GLEICH VORGABE ;when default
    if (mOp.Equal(OPERA.get(),"'>")) {
      if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,999),"")) {
        if (mOp.NotGreater(YINHALTX.get(),m$.Fnc.$extract(TRIGGER.get(),3,999))) {
          return include.COMSYS.$$$YES(m$);
        }
      }
    }
    //<< 
    //<< quit $$$NO  // early quits above
    return include.COMSYS.$$$NO(m$);
  }

//<< 
//<< 
}
