//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWWEEK
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:47
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

//<< WWWWEEK(YDATUM="",YPARA)
public class WWWWEEK extends mClass {

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

  public Object main(Object ... _p) {
    mVar YDATUM = m$.newVarRef("YDATUM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YPARA = m$.newVarRef("YPARA",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _WWWWEEK(YDATUM,YPARA);
  }

  public Object _WWWWEEK(Object ... _p) {
    mVar YDATUM = m$.newVarRef("YDATUM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YPARA = m$.newVarRef("YPARA",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWWEEK("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       CONVERT DATE TO WEEK AS PER ISO 8601 (German DIN 1355)
    //<< ;
    //<< ;           W $$^WWWWEEK("20.10.2002")
    //<< ;
    //<< ; Inputs :
    //<< ;   YDATUM = $H OR DD.MM.YYYY  (will accept DD/MM/YYYY or DD-MM-YYYY)
    //<< ;
    //<< ;   YPARA=1 : Return WW.YYYY KW ;week
    //<< ;   YPARA=2 : Return YYYYWW         ISO 8601 standard
    //<< ;   YPARA=3 : Return YYYY-WW
    //<< ;   YPARA=4 : Return WW
    //<< ;   Default : Return WWYYYY
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 01-Nov-2010   GRF     SR17585.2: Re-write WOC to use new subroutines GetWeek
    //<< ;                           and CalcWeek - simplify calculation and preserve so
    //<< ;                           don't need to repeatedly calculate.
    //<< ; 29-Oct-2010   GRF     SR17585.1: Special Days of Week variables missed; tests
    //<< ;                           for 1st Jan excludes all first days and all days in
    //<< ;                           January but error in comparing "1" instead of "01"
    //<< ;                           meant code worked for most dates.
    //<< ; 28-Oct-2010   GRF     SR17585: Code to determine if week should be 01xxxx or
    //<< ;                           53yyyy (where xxxx is current year and yyyy is
    //<< ;                           previous year) was using variable for Day Of Week
    //<< ;                           (1=Mon) instead of Month (1=Jan)
    //<< ; 07-Jun-2010   GRF     SR17146: call "DD.MM.YYYY" wrapper for WWWDATE1 (DMY) &
    //<< ;                           for WWWDATE (IntToDMY); Inappropriate logic negation
    //<< ;                           MON and TAG treated as both "01" and 1 without
    //<< ;                           string to numeric conversion
    //<< ; 16.06.2003    WEM
    //<< ;-------------------------------------------------------------------------------
    //<< new DAT,JAH,WOC,MON,TAG,DAYS,YI,YQ,SDAY,SFWOCDAY,DAY,LYDAY,SPRACHE,WEEK
    mVar DAT = m$.var("DAT");
    mVar JAH = m$.var("JAH");
    mVar WOC = m$.var("WOC");
    mVar MON = m$.var("MON");
    mVar TAG = m$.var("TAG");
    mVar DAYS = m$.var("DAYS");
    mVar YI = m$.var("YI");
    mVar YQ = m$.var("YQ");
    mVar SDAY = m$.var("SDAY");
    mVar SFWOCDAY = m$.var("SFWOCDAY");
    mVar DAY = m$.var("DAY");
    mVar LYDAY = m$.var("LYDAY");
    mVar SPRACHE = m$.var("SPRACHE");
    mVar WEEK = m$.var("WEEK");
    m$.newVar(DAT,JAH,WOC,MON,TAG,DAYS,YI,YQ,SDAY,SFWOCDAY,DAY,LYDAY,SPRACHE,WEEK);
    //<< 
    //<< set SPRACHE="DE"
    SPRACHE.set("DE");
    //<< 
    //<< set YPARA = $get(YPARA)
    YPARA.set(m$.Fnc.$get(YPARA));
    //<< if YDATUM="" set YDATUM = +$horolog
    if (mOp.Equal(YDATUM.get(),"")) {
      YDATUM.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< set YDATUM = $translate(YDATUM," ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz")
    YDATUM.set(m$.Fnc.$translate(YDATUM.get()," ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"));
    //<< 
    //<< set WEEK = $$WOC(YDATUM)
    WEEK.set(m$.fnc$("WOC",YDATUM.get()));
    //<< quit WEEK
    return WEEK.get();
  }

  //<< 
  //<< 
  //<< WOC(pstrInputDate)
  public Object WOC(Object ... _p) {
    mVar pstrInputDate = m$.newVarRef("pstrInputDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Inputs: pstrInputDate ($h or DD*MM*YYYY where * can be ./-)
    //<< ;
    //<< ; ByRef : YPARA - output format
    //<< ;
    //<< ; History:
    //<< ; 24-Mar-2011   GRF     SR17585.1: Manage short year case
    //<< ; 01-Nov-2010   GRF     SR17585: Revised version
    //<< ;-------------------------------------------------------------------------------
    //<< new dteInput,strWeekInput
    mVar dteInput = m$.var("dteInput");
    mVar strWeekInput = m$.var("strWeekInput");
    m$.newVar(dteInput,strWeekInput);
    //<< 
    //<< if $find(pstrInputDate,"/")       set pstrInputDate = $translate(pstrInputDate,"/",".")
    if (mOp.Logical(m$.Fnc.$find(pstrInputDate.get(),"/"))) {
      pstrInputDate.set(m$.Fnc.$translate(pstrInputDate.get(),"/","."));
    }
    //<< if $find(pstrInputDate,"-")       set pstrInputDate = $translate(pstrInputDate,"-",".")
    if (mOp.Logical(m$.Fnc.$find(pstrInputDate.get(),"-"))) {
      pstrInputDate.set(m$.Fnc.$translate(pstrInputDate.get(),"-","."));
    }
    //<< if $piece(pstrInputDate,".",3)="" set pstrInputDate = $$IntToDMY^WWWDATE($piece(pstrInputDate,".",1))
    if (mOp.Equal(m$.Fnc.$piece(pstrInputDate.get(),".",3),"")) {
      pstrInputDate.set(m$.fnc$("WWWDATE.IntToDMY",m$.Fnc.$piece(pstrInputDate.get(),".",1)));
    }
    //<< 
    //<< set dteInput     = $$DMY^WWWDATE1(pstrInputDate)
    dteInput.set(m$.fnc$("WWWDATE1.DMY",pstrInputDate.get()));
    //<< if $length($piece(pstrInputDate,".",3))'=4 set pstrInputDate = $$IntToDMY^WWWDATE(dteInput)  ; SR17585.1
    if (mOp.NotEqual(m$.Fnc.$length(m$.Fnc.$piece(pstrInputDate.get(),".",3)),4)) {
      pstrInputDate.set(m$.fnc$("WWWDATE.IntToDMY",dteInput.get()));
    }
    //<< set strWeekInput = $$GetWeek(dteInput,pstrInputDate)
    strWeekInput.set(m$.fnc$("GetWeek",dteInput.get(),pstrInputDate.get()));
    //<< 
    //<< if YPARA=1 {
    if (mOp.Equal(m$.var("YPARA").get(),1)) {
      //<< set strWeekInput = $extract(strWeekInput,5,6)_"."_$extract(strWeekInput,1,4)_" "_$$^WWWTEXT(385)  ; "Week "
      strWeekInput.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(strWeekInput.get(),5,6),"."),m$.Fnc.$extract(strWeekInput.get(),1,4))," "),m$.fnc$("WWWTEXT.main",385)));
    }
    //<< 
    //<< } elseif YPARA=2 {
    else if (mOp.Equal(m$.var("YPARA").get(),2)) {
    }
    //<< ; ISO Standard - no alteration
    //<< 
    //<< } elseif YPARA=3 {
    else if (mOp.Equal(m$.var("YPARA").get(),3)) {
      //<< set strWeekInput = $extract(strWeekInput,1,4)_"-"_$extract(strWeekInput,5,6)
      strWeekInput.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(strWeekInput.get(),1,4),"-"),m$.Fnc.$extract(strWeekInput.get(),5,6)));
    }
    //<< 
    //<< } elseif YPARA=4 {
    else if (mOp.Equal(m$.var("YPARA").get(),4)) {
      //<< set strWeekInput = $extract(strWeekInput,5,6)
      strWeekInput.set(m$.Fnc.$extract(strWeekInput.get(),5,6));
    }
    //<< 
    //<< } else {
    else {
      //<< set strWeekInput = $extract(strWeekInput,5,6)_$extract(strWeekInput,1,4)
      strWeekInput.set(mOp.Concat(m$.Fnc.$extract(strWeekInput.get(),5,6),m$.Fnc.$extract(strWeekInput.get(),1,4)));
    }
    //<< }
    //<< quit strWeekInput
    return strWeekInput.get();
  }

  //<< 
  //<< 
  //<< GetWeek(pdteInput,pstrDMYInput)
  public Object GetWeek(Object ... _p) {
    mVar pdteInput = m$.newVarRef("pdteInput",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrDMYInput = m$.newVarRef("pstrDMYInput",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Calculate week in ISO 8601 format (YYYYnn) for input date
    //<< ;
    //<< ; Inputs:
    //<< ;  - pdteInput    : Input date in horolog format
    //<< ;  - pstrDMYInput : Input date in DD.MM.YYYY standard string
    //<< ;
    //<< ; Returns: Week Number
    //<< ;
    //<< ; History:
    //<< ; 01-Nov-2010   GRF     SR17585: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new dteLastSundayPY,dteLastSundayThisYear,intThisYear,intNextYear,intWeekNo
    mVar dteLastSundayPY = m$.var("dteLastSundayPY");
    mVar dteLastSundayThisYear = m$.var("dteLastSundayThisYear");
    mVar intThisYear = m$.var("intThisYear");
    mVar intNextYear = m$.var("intNextYear");
    mVar intWeekNo = m$.var("intWeekNo");
    m$.newVar(dteLastSundayPY,dteLastSundayThisYear,intThisYear,intNextYear,intWeekNo);
    //<< new strWeekInput,strWeekNextNewYear,strWeekJan1
    mVar strWeekInput = m$.var("strWeekInput");
    mVar strWeekNextNewYear = m$.var("strWeekNextNewYear");
    mVar strWeekJan1 = m$.var("strWeekJan1");
    m$.newVar(strWeekInput,strWeekNextNewYear,strWeekJan1);
    //<< 
    //<< set intThisYear = $piece(pstrDMYInput,".",3)
    intThisYear.set(m$.Fnc.$piece(pstrDMYInput.get(),".",3));
    //<< set intNextYear = intThisYear + 1
    intNextYear.set(mOp.Add(intThisYear.get(),1));
    //<< 
    //<< do CalcWeek(intThisYear,.dteLastSundayPY,.strWeekJan1)
    m$.Cmd.Do("CalcWeek",intThisYear.get(),dteLastSundayPY,strWeekJan1);
    //<< do CalcWeek(intNextYear,.dteLastSundayThisYear,.strWeekNextNewYear)
    m$.Cmd.Do("CalcWeek",intNextYear.get(),dteLastSundayThisYear,strWeekNextNewYear);
    //<< 
    //<< if pdteInput > dteLastSundayThisYear {
    if (mOp.Greater(pdteInput.get(),dteLastSundayThisYear.get())) {
      //<< set strWeekInput = strWeekNextNewYear
      strWeekInput.set(strWeekNextNewYear.get());
    }
    //<< 
    //<< } elseif pdteInput > dteLastSundayPY {
    else if (mOp.Greater(pdteInput.get(),dteLastSundayPY.get())) {
      //<< set intWeekNo    = (pdteInput - dteLastSundayPY - 1) \7 +1
      intWeekNo.set(mOp.Add(mOp.IntegerDivide((mOp.Subtract(mOp.Subtract(pdteInput.get(),dteLastSundayPY.get()),1)),7),1));
      //<< set strWeekInput = intThisYear_$translate($justify(intWeekNo,2)," ","0")
      strWeekInput.set(mOp.Concat(intThisYear.get(),m$.Fnc.$translate(m$.Fnc.$justify(intWeekNo.get(),2)," ","0")));
    }
    //<< 
    //<< } else {  ; 1 Jan to 3 Jan in certain years will be in prev year
    else {
      //<< set strWeekInput = strWeekJan1
      strWeekInput.set(strWeekJan1.get());
    }
    //<< }
    //<< quit strWeekInput
    return strWeekInput.get();
  }

  //<< 
  //<< 
  //<< CalcWeek(pintThisYear,&pdteLastSundayPY,&pstrWeekJan1)
  public Object CalcWeek(Object ... _p) {
    mVar pintThisYear = m$.newVarRef("pintThisYear",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pdteLastSundayPY = m$.newVarRef("pdteLastSundayPY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrWeekJan1 = m$.newVarRef("pstrWeekJan1",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Calculate week in ISO 8601 format (YYYYnn) where Week 1 for a year is the week
    //<< ; with the year's first Thursday in it.
    //<< ;  - Jan 04 is always in Week 1
    //<< ;  - Dec 28 is always in last week of its year
    //<< ;
    //<< ; Monday is always the first day of the week under the standard.
    //<< ; If 1 Jan is Fri/Sat/Sun it is in week 52 or 53 of previous year.
    //<< ;
    //<< ; Inputs:
    //<< ;  - Year of input date (YYYY)
    //<< ;
    //<< ; Returns (ByRef) :
    //<< ;  - $horolog of last Sunday of the Previous Year (could be 1, 2, or 3 Jan)
    //<< ;  - string of week number (YYYYnn) for 1 Jan of this year
    //<< ;
    //<< ; History:
    //<< ; 01-Nov-2010   GRF     SR17585: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;  Prev Year  Jan1  DoW      1   1   2   2   3   3   4   4   5   5   6   6   7   7
    //<< ;  Prev Year Leap Year       N   Y   N   Y   N   Y   N   Y   N   Y   N   Y   N   Y
    //<< ;  Weeks in Prev Year       52  52  52  52  52  53  53  53  52  52  52  52  52  52
    //<< ;  Input Year Jan 1 DoW      2   3   3   4   4   5   5   6   6   7   7   1   1   2
    //<< ;  Input Year Jan 1 WeekNo  01  01  01  01  01  53  53  53  52  52  52  01  01  01
    //<< ;
    //<< ;  Case                      1   1   1   1   1   2   2   2   3   3   3   1   1   1
    //<< ;
    //<< ;  1.   If Jan 1 Dow < 5, Week No will always be YYYY01
    //<< ;       else
    //<< ;  2.      If PY Jan 1 DoW = 3 or 4, Week No will always be PPPP53
    //<< ;          else
    //<< ;  3.         Week No will always be PPPP52
    //<< ;-------------------------------------------------------------------------------
    //<< new blnLeapYear,dteJan1,enumDoWJan1,enumLastNewYear,intPrevYear,objWeek,strStatus
    mVar blnLeapYear = m$.var("blnLeapYear");
    mVar dteJan1 = m$.var("dteJan1");
    mVar enumDoWJan1 = m$.var("enumDoWJan1");
    mVar enumLastNewYear = m$.var("enumLastNewYear");
    mVar intPrevYear = m$.var("intPrevYear");
    mVar objWeek = m$.var("objWeek");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnLeapYear,dteJan1,enumDoWJan1,enumLastNewYear,intPrevYear,objWeek,strStatus);
    //<< 
    //<< set objWeek = $get(^WWWWEEK(0,pintThisYear,1))
    objWeek.set(m$.Fnc.$get(m$.var("^WWWWEEK",0,pintThisYear.get(),1)));
    //<< 
    //<< if objWeek'="" {
    if (mOp.NotEqual(objWeek.get(),"")) {
      //<< set pdteLastSundayPY = $piece(objWeek,Y,1)    ; $$$WWWWEEKLastSundayPrevYear
      pdteLastSundayPY.set(m$.Fnc.$piece(objWeek.get(),m$.var("Y").get(),1));
      //<< set pstrWeekJan1     = $piece(objWeek,Y,2)    ; $$$WWWWEEKWeekNoForJan1st
      pstrWeekJan1.set(m$.Fnc.$piece(objWeek.get(),m$.var("Y").get(),2));
    }
    //<< 
    //<< } else {
    else {
      //<< set dteJan1          = $$DMY^WWWDATE1("01.01."_pintThisYear)
      dteJan1.set(m$.fnc$("WWWDATE1.DMY",mOp.Concat("01.01.",pintThisYear.get())));
      //<< set enumDoWJan1      = $$^WWWDAY(dteJan1)
      enumDoWJan1.set(m$.fnc$("WWWDAY.main",dteJan1.get()));
      //<< set pdteLastSundayPY = dteJan1 - enumDoWJan1
      pdteLastSundayPY.set(mOp.Subtract(dteJan1.get(),enumDoWJan1.get()));
      //<< set pstrWeekJan1     = pintThisYear_"01"           ; Case 1
      pstrWeekJan1.set(mOp.Concat(pintThisYear.get(),"01"));
      //<< 
      //<< if enumDoWJan1 > 4 {
      if (mOp.Greater(enumDoWJan1.get(),4)) {
        //<< set pdteLastSundayPY = pdteLastSundayPY+7
        pdteLastSundayPY.set(mOp.Add(pdteLastSundayPY.get(),7));
        //<< set intPrevYear      = pintThisYear-1
        intPrevYear.set(mOp.Subtract(pintThisYear.get(),1));
        //<< set enumLastNewYear  = $$^WWWDAY($$DMY^WWWDATE1("01.01."_intPrevYear))
        enumLastNewYear.set(m$.fnc$("WWWDAY.main",m$.fnc$("WWWDATE1.DMY",mOp.Concat("01.01.",intPrevYear.get()))));
        //<< set blnLeapYear      = $$IsLeapYear^COMUtilDate(intPrevYear)
        blnLeapYear.set(m$.fnc$("COMUtilDate.IsLeapYear",intPrevYear.get()));
        //<< 
        //<< if (enumLastNewYear < 5) {
        if ((mOp.Less(enumLastNewYear.get(),5))) {
          //<< set pstrWeekJan1 = intPrevYear_53          ; Case 2
          pstrWeekJan1.set(mOp.Concat(intPrevYear.get(),53));
        }
        //<< 
        //<< } else {
        else {
          //<< set pstrWeekJan1 = intPrevYear_52          ; Case 3
          pstrWeekJan1.set(mOp.Concat(intPrevYear.get(),52));
        }
      }
      //<< }
      //<< }
      //<< set objWeek = pdteLastSundayPY_Y_pstrWeekJan1
      objWeek.set(mOp.Concat(mOp.Concat(pdteLastSundayPY.get(),m$.var("Y").get()),pstrWeekJan1.get()));
      //<< set strStatus = $$$Save("WWWWEEK",pintThisYear,objWeek,$$$YES)
      strStatus.set(include.COMSYS.$$$Save(m$,"WWWWEEK",pintThisYear,objWeek,include.COMSYS.$$$YES(m$)));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< oldWOC(YDATUM)
  public Object oldWOC(Object ... _p) {
    mVar YDATUM = m$.newVarRef("YDATUM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new intEOLastYear,intEOYWeekDay,intLastNewYear,intNewYearsDay,intTodaysDay    ; SR17146
    mVar intEOLastYear = m$.var("intEOLastYear");
    mVar intEOYWeekDay = m$.var("intEOYWeekDay");
    mVar intLastNewYear = m$.var("intLastNewYear");
    mVar intNewYearsDay = m$.var("intNewYearsDay");
    mVar intTodaysDay = m$.var("intTodaysDay");
    m$.newVar(intEOLastYear,intEOYWeekDay,intLastNewYear,intNewYearsDay,intTodaysDay);
    //<< 
    //<< SET DAT      = YDATUM    ; +$h or DD.MM.YYYY
    mVar DAT = m$.var("DAT");
    DAT.set(YDATUM.get());
    //<< SET WOC      = 1
    mVar WOC = m$.var("WOC");
    WOC.set(1);
    //<< SET DAYS     = 1
    mVar DAYS = m$.var("DAYS");
    DAYS.set(1);
    //<< SET DAY      = 0
    mVar DAY = m$.var("DAY");
    DAY.set(0);
    //<< SET LYDAY    = 0
    mVar LYDAY = m$.var("LYDAY");
    LYDAY.set(0);
    //<< SET YQ       = 0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< SET SFWOCDAY = 1
    mVar SFWOCDAY = m$.var("SFWOCDAY");
    SFWOCDAY.set(1);
    //<< 
    //<< IF $FIND(DAT,"/")       SET DAT = $PIECE(DAT,"/",1)_"."_$PIECE(DAT,"/",2)_"."_$PIECE(DAT,"/",3)
    if (mOp.Logical(m$.Fnc.$find(DAT.get(),"/"))) {
      DAT.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(DAT.get(),"/",1),"."),m$.Fnc.$piece(DAT.get(),"/",2)),"."),m$.Fnc.$piece(DAT.get(),"/",3)));
    }
    //<< ;F $PIECE(DAT,".",3)="" SET DAT = $$^WWWDATE($PIECE(YDATUM,".",1))   ; SR17146
    //<< IF $PIECE(DAT,".",3)="" SET DAT = $$IntToDMY^WWWDATE($PIECE(YDATUM,".",1))
    if (mOp.Equal(m$.Fnc.$piece(DAT.get(),".",3),"")) {
      DAT.set(m$.fnc$("WWWDATE.IntToDMY",m$.Fnc.$piece(YDATUM.get(),".",1)));
    }
    //<< IF $FIND(DAT,"/")       SET DAT = $PIECE(DAT,"/",1)_"."_$PIECE(DAT,"/",2)_"."_$PIECE(DAT,"/",3)
    if (mOp.Logical(m$.Fnc.$find(DAT.get(),"/"))) {
      DAT.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(DAT.get(),"/",1),"."),m$.Fnc.$piece(DAT.get(),"/",2)),"."),m$.Fnc.$piece(DAT.get(),"/",3)));
    }
    //<< IF $FIND(DAT,"-")       SET DAT = $TRANSLATE(DAT,"-",".")
    if (mOp.Logical(m$.Fnc.$find(DAT.get(),"-"))) {
      DAT.set(m$.Fnc.$translate(DAT.get(),"-","."));
    }
    //<< SET TAG = $PIECE(DAT,".",1)
    mVar TAG = m$.var("TAG");
    TAG.set(m$.Fnc.$piece(DAT.get(),".",1));
    //<< set MON = $PIECE(DAT,".",2)
    mVar MON = m$.var("MON");
    MON.set(m$.Fnc.$piece(DAT.get(),".",2));
    //<< set JAH = $PIECE(DAT,".",3)
    mVar JAH = m$.var("JAH");
    JAH.set(m$.Fnc.$piece(DAT.get(),".",3));
    //<< 
    //<< ;CALCULATES CALENDAR WEEK BASED ON 1ST OF JANUARY
    //<< ;SET SDAT = $$^WWWDATE1("01.01."_JAH)                    ; SR17146 not used - use clearer variables
    //<< ;SET SDAY = $$^WWWDAY(SDAT)                ; WHICH DAY OF WEEK
    //<< 
    //<< ; Special Days of Week : 1=Monday through 7=Sunday       ; SR17146 vvv
    //<< ; DAT : DD.MM.YYYY
    //<< set intTodaysDay   = $$^WWWDAY($$DMY^WWWDATE1(DAT))
    intTodaysDay.set(m$.fnc$("WWWDAY.main",m$.fnc$("WWWDATE1.DMY",DAT.get())));
    //<< set intNewYearsDay = $$^WWWDAY($$DMY^WWWDATE1("01.01."_JAH))
    intNewYearsDay.set(m$.fnc$("WWWDAY.main",m$.fnc$("WWWDATE1.DMY",mOp.Concat("01.01.",JAH.get()))));
    //<< set intEOYWeekDay  = $$^WWWDAY($$DMY^WWWDATE1("31.12."_JAH))
    intEOYWeekDay.set(m$.fnc$("WWWDAY.main",m$.fnc$("WWWDATE1.DMY",mOp.Concat("31.12.",JAH.get()))));
    //<< set intLastNewYear = $$^WWWDAY($$DMY^WWWDATE1("01.01."_(JAH-1)))
    intLastNewYear.set(m$.fnc$("WWWDAY.main",m$.fnc$("WWWDATE1.DMY",mOp.Concat("01.01.",(mOp.Subtract(JAH.get(),1))))));
    //<< set intEOLastYear  = $$^WWWDAY($$DMY^WWWDATE1("31.12."_(JAH-1)))
    intEOLastYear.set(m$.fnc$("WWWDAY.main",m$.fnc$("WWWDATE1.DMY",mOp.Concat("31.12.",(mOp.Subtract(JAH.get(),1))))));
    do {
      //<< 
      //<< DO
      //<< . ; End of Year => Week 1 of following year or week 52/53 of this year
      //<< . ;-------------------------------------
      //<< .;IF MON=12 IF JAH=$$^WWWYEAR($$^WWWDATE1(DAT)) IF (TAG=31)!(TAG=30)!(TAG=29)  DO    ; SR17146 - already know year=year
      //<< .;. IF ($$^WWWDAY($$^WWWDATE1("31.12."_JAH))=3) || ($$^WWWDAY($$^WWWDATE1("31.12."_JAH))=2) || ($$^WWWDAY($$^WWWDATE1("31.12."_JAH))=1) DO    ; SR17146
      //<< . IF (MON=12) && ((TAG=31) || (TAG=30) || (TAG=29))  DO
      if ((mOp.Equal(MON.get(),12)) && mOp.Logical(((mOp.Equal(TAG.get(),31)) || (mOp.Equal(TAG.get(),30)) || (mOp.Equal(TAG.get(),29))))) {
        do {
          //<< . . IF (intEOYWeekDay=3) || (intEOYWeekDay=2) || (intEOYWeekDay=1) DO  ; KW=1 31ST OF DECEMBER IS MONDAY,TUESDAY,WEDNESDAY
          if ((mOp.Equal(intEOYWeekDay.get(),3)) || (mOp.Equal(intEOYWeekDay.get(),2)) || (mOp.Equal(intEOYWeekDay.get(),1))) {
            //<< . . . SET WOC = 1
            WOC.set(1);
            //<< . . . SET JAH = JAH+1
            JAH.set(mOp.Add(JAH.get(),1));
            //<< . . . SET YQ  = 1
            YQ.set(1);
          }
          //<< . . ;
          //<< . . QUIT:YQ=1
          if (mOp.Equal(YQ.get(),1)) {
            break;
          }
          //<< . . SET WOC=52                                             ; KW=52 YEAR STARTED OR ENDED NOT WITH THURSDAY (DEFAULT) ;privation
          WOC.set(52);
          //<< . .;IF ($$^WWWDAY($$^WWWDATE1("01.01."_JAH))=4) || ($$^WWWDAY($$^WWWDATE1("31.12."_JAH))=4) SET WOC=53   ; SR17146
          //<< . . IF (intNewYearsDay=4) || (intEOYWeekDay=4) SET WOC=53   ; KW=53 YEAR STARTED OR ENDED WITH THURSDAY
          if ((mOp.Equal(intNewYearsDay.get(),4)) || (mOp.Equal(intEOYWeekDay.get(),4))) {
            WOC.set(53);
          }
          //<< . . SET YQ=1
          YQ.set(1);
        } while (false);
      }
      //<< . ;
      //<< . QUIT:YQ=1
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
      //<< . ;
      //<< . ; Start of Year => Week 52/53 of previous year
      //<< . ;--------------------------------------
      //<< . IF (+MON=1) && ((TAG="01") || (TAG="02") || (TAG="03")) DO   ;WEM;22960;02.09.2003;ADDED SPECIAL HANDLINK FIRST THREE DAYS OF JANUARY
      if ((mOp.Equal(mOp.Positive(MON.get()),1)) && mOp.Logical(((mOp.Equal(TAG.get(),"01")) || (mOp.Equal(TAG.get(),"02")) || (mOp.Equal(TAG.get(),"03"))))) {
        do {
          //<< . .;IF JAH#4=0 IF $$^WWWDAY($$^WWWDATE1("01.01."_JAH))=4 SET YQ=1 QUIT   ; SR17146
          //<< . .;IF $$^WWWDAY($$^WWWDATE1(TAG_".01."_(JAH)))>4 IF ($$^WWWDAY($$^WWWDATE1("01.01."_(JAH-1)))=4) || ($$^WWWDAY($$^WWWDATE1("31.12."_(JAH-1)))=4) SET WOC=53 SET JAH=JAH-1 SET YQ=1 QUIT
          //<< . .;IF $$^WWWDAY($$^WWWDATE1(TAG_".01."_(JAH)))>4 SET WOC=52 SET JAH=JAH-1 SET YQ=1
          //<< . . IF (JAH#4=0) && (intNewYearsDay=4) SET YQ=1 QUIT   ; WILL BE HANDLED IN LEAP YEAR CALCULATION AT THE END OF ROUTINE
          if ((mOp.Equal(mOp.Modulus(JAH.get(),4),0)) && (mOp.Equal(intNewYearsDay.get(),4))) {
            YQ.set(1);
            break;
          }
          //<< . . IF (intTodaysDay>4) do
          if ((mOp.Greater(intTodaysDay.get(),4))) {
            do {
              //<< . . . IF (intLastNewYear=4) || (intEOLastYear=4) SET WOC=53 SET JAH=JAH-1 SET YQ=1 quit
              if ((mOp.Equal(intLastNewYear.get(),4)) || (mOp.Equal(intEOLastYear.get(),4))) {
                WOC.set(53);
                JAH.set(mOp.Subtract(JAH.get(),1));
                YQ.set(1);
                break;
              }
              //<< . . . SET WOC=52 SET JAH=JAH-1 SET YQ=1
              WOC.set(52);
              JAH.set(mOp.Subtract(JAH.get(),1));
              YQ.set(1);
            } while (false);
          }
        } while (false);
      }
      //<< . ;
      //<< . QUIT:YQ=1
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
      //<< . ;
      //<< . ; Last Year had 53 weeks (01.01.=THURSDAY) - before 8th Jan
      //<< . ;--------------------------------------
      //<< .;IF $$^WWWDAY($$^WWWDATE1("01.01."_(JAH-1)))=4 IF $$^WWWMONTH($$^WWWDATE1(YDATUM))=1 IF TAG<8 DO   ; SR17146
      //<< .;. SET LYDAY=$$^WWWDAY($$^WWWDATE1("31.12."_(JAH-1)))   ; WEEKDAY OF THE 31st OF DECEMBER LAST YEAR ;charge
      //<< . IF (intLastNewYear=4) IF +MON=1 IF TAG<8 DO   ; ADDED SPECIAL HANDLING WHEN YEARS STARTS WITH THURSDAY, MONTH = JANUARY AND DAY<8
      if ((mOp.Equal(intLastNewYear.get(),4))) {
        if (mOp.Equal(mOp.Positive(MON.get()),1)) {
          if (mOp.Less(TAG.get(),8)) {
            do {
              //<< . . SET LYDAY = intEOLastYear   ; WEEKDAY OF THE 31st OF DECEMBER LAST YEAR
              LYDAY.set(intEOLastYear.get());
              //<< . . DO  QUIT:YQ=1
              do {
                //<< . . . IF LYDAY=7 SET WOC=1 SET YQ=1
                if (mOp.Equal(LYDAY.get(),7)) {
                  WOC.set(1);
                  YQ.set(1);
                }
                //<< . . . IF LYDAY=6 DO
                if (mOp.Equal(LYDAY.get(),6)) {
                  //<< . . . . IF intTodaysDay=1 SET WOC=53 SET JAH=JAH-1   ; SR17146 replace all $$^WWWDAY($$^WWWDATE1(YDATUM)) with intTodaysDay
                  if (mOp.Equal(intTodaysDay.get(),1)) {
                    WOC.set(53);
                    JAH.set(mOp.Subtract(JAH.get(),1));
                  }
                  //<< . . . . IF intTodaysDay>1 SET WOC=1
                  if (mOp.Greater(intTodaysDay.get(),1)) {
                    WOC.set(1);
                  }
                  //<< . . . . SET YQ=1
                  YQ.set(1);
                }
                //<< . . . ;
                //<< . . . IF LYDAY=5 DO
                if (mOp.Equal(LYDAY.get(),5)) {
                  //<< . . . . IF intTodaysDay>5 SET WOC=53 SET JAH=JAH-1
                  if (mOp.Greater(intTodaysDay.get(),5)) {
                    WOC.set(53);
                    JAH.set(mOp.Subtract(JAH.get(),1));
                  }
                  //<< . . . . IF intTodaysDay<6 SET WOC=1
                  if (mOp.Less(intTodaysDay.get(),6)) {
                    WOC.set(1);
                  }
                  //<< . . . . SET YQ=1
                  YQ.set(1);
                }
                //<< . . . ;
                //<< . . . IF LYDAY=4 DO
                if (mOp.Equal(LYDAY.get(),4)) {
                  //<< . . . . IF intTodaysDay>4 SET WOC=53 SET JAH=JAH-1
                  if (mOp.Greater(intTodaysDay.get(),4)) {
                    WOC.set(53);
                    JAH.set(mOp.Subtract(JAH.get(),1));
                  }
                  //<< . . . . IF intTodaysDay<5 SET WOC=1
                  if (mOp.Less(intTodaysDay.get(),5)) {
                    WOC.set(1);
                  }
                  //<< . . . . SET YQ=1
                  YQ.set(1);
                }
                //<< . . . ;
                //<< . . . IF LYDAY=3 DO
                if (mOp.Equal(LYDAY.get(),3)) {
                  //<< . . . . IF intTodaysDay>3 SET WOC=53 SET JAH=JAH-1
                  if (mOp.Greater(intTodaysDay.get(),3)) {
                    WOC.set(53);
                    JAH.set(mOp.Subtract(JAH.get(),1));
                  }
                  //<< . . . . IF intTodaysDay<4 SET WOC=1
                  if (mOp.Less(intTodaysDay.get(),4)) {
                    WOC.set(1);
                  }
                  //<< . . . . SET YQ=1
                  YQ.set(1);
                }
                //<< . . . ;
                //<< . . . IF LYDAY=2 DO
                if (mOp.Equal(LYDAY.get(),2)) {
                  //<< . . . . IF intTodaysDay>2 SET WOC=53 SET JAH=JAH-1
                  if (mOp.Greater(intTodaysDay.get(),2)) {
                    WOC.set(53);
                    JAH.set(mOp.Subtract(JAH.get(),1));
                  }
                  //<< . . . . IF intTodaysDay<3 SET WOC=1
                  if (mOp.Less(intTodaysDay.get(),3)) {
                    WOC.set(1);
                  }
                  //<< . . . . SET YQ=1
                  YQ.set(1);
                }
                //<< . . . ;
                //<< . . . IF LYDAY=1 DO
                if (mOp.Equal(LYDAY.get(),1)) {
                  //<< . . . . IF intTodaysDay>1 SET WOC=53 SET JAH=JAH-1
                  if (mOp.Greater(intTodaysDay.get(),1)) {
                    WOC.set(53);
                    JAH.set(mOp.Subtract(JAH.get(),1));
                  }
                  //<< . . . . IF intTodaysDay<2 SET WOC=1
                  if (mOp.Less(intTodaysDay.get(),2)) {
                    WOC.set(1);
                  }
                  //<< . . . . SET YQ=1
                  YQ.set(1);
                }
              } while(false);
              if (mOp.Equal(YQ.get(),1)) {
                break;
              }
            } while (false);
          }
        }
      }
      //<< . ;
      //<< . QUIT:YQ=1
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
      //<< . ;
      //<< . ; Last Year had 53 weeks (31.12.=THURSDAY) - before 4th Jan
      //<< . ;--------------------------------------
      //<< .;IF $$^WWWDAY($$^WWWDATE1("31.12."_(JAH-1)))=4 IF $$^WWWMONTH($$^WWWDATE1(YDATUM))=1 IF TAG<4 DO   ; SR17146
      //<< .;IF intEOLastYear=4 IF intTodaysDay=1 IF TAG<4 DO    ; SR17585
      //<< . IF intEOLastYear=4 IF MON=1 IF TAG<4 DO
      if (mOp.Equal(intEOLastYear.get(),4)) {
        if (mOp.Equal(MON.get(),1)) {
          if (mOp.Less(TAG.get(),4)) {
            //<< . . SET WOC = 53
            WOC.set(53);
            //<< . . SET JAH = JAH-1
            JAH.set(mOp.Subtract(JAH.get(),1));
            //<< . . SET YQ  = 1
            YQ.set(1);
          }
        }
      }
      //<< . ;
      //<< . QUIT:YQ=1
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
      //<< . ;
      //<< . ;
      //<< . IF WOC=1  DO
      if (mOp.Equal(WOC.get(),1)) {
        do {
          //<< . . FOR YI=1,2,3,4,5,6,7 DO  QUIT:SDAY=1   ; GET FIRST MONDAY OF YEAR
          mVar YI = m$.var("YI");
          for (Object _YI: new Object[] {1,2,3,4,5,6,7}) {
            YI.set(_YI);
            //<< . . . SET SDAY=$$^WWWDAY($$DMY^WWWDATE1("0"_YI_".01."_JAH))      ; SR17146 add DMY tag
            mVar SDAY = m$.var("SDAY");
            SDAY.set(m$.fnc$("WWWDAY.main",m$.fnc$("WWWDATE1.DMY",mOp.Concat(mOp.Concat(mOp.Concat("0",_YI),".01."),JAH.get()))));
            if (mOp.Equal(m$.var("SDAY").get(),1)) {
              break;
            }
          }
          //<< . .;
          //<< . .; SR17146 NOTE : Original NOTs in wrong places
          //<< . .;IF '$$^WWWDAY($$^WWWDATE1("01.01."_(JAH-1)))=4 IF '$$^WWWDAY($$^WWWDATE1("31.12."_(JAH-1)))=4 DO   ;WEM#22960;22.08.2003;ADDED
          //<< . .;. IF $$^WWWMONTH($$^WWWDATE1(YDATUM))=1 IF TAG<8 IF TAG<YI SET WOC=52 SET JAH=JAH-1 SET YQ=1 QUIT
          //<< . . IF (intLastNewYear'=4) && (intEOLastYear'=4) DO
          if ((mOp.NotEqual(intLastNewYear.get(),4)) && (mOp.NotEqual(intEOLastYear.get(),4))) {
            do {
              //<< . . . IF +MON=1 IF TAG<8 IF TAG<YI SET WOC=52 SET JAH=JAH-1 SET YQ=1 QUIT     ; FIXME : if TAG<YI then must always be <8 since max YI=7
              if (mOp.Equal(mOp.Positive(MON.get()),1)) {
                if (mOp.Less(TAG.get(),8)) {
                  if (mOp.Less(TAG.get(),YI.get())) {
                    WOC.set(52);
                    JAH.set(mOp.Subtract(JAH.get(),1));
                    YQ.set(1);
                    break;
                  }
                }
              }
            } while (false);
          }
          //<< . . ;
          //<< . . QUIT:YQ=1
          if (mOp.Equal(YQ.get(),1)) {
            break;
          }
          //<< . . ;
          //<< . . IF (YI'=1) && (YI'=7) SET YI=YI-1
          if ((mOp.NotEqual(YI.get(),1)) && (mOp.NotEqual(YI.get(),7))) {
            YI.set(mOp.Subtract(YI.get(),1));
          }
          //<< . . IF $$^WWWDAY($$DMY^WWWDATE1("06.01."_JAH))=1 SET YI=6        ; SR17146 add DMY tag
          if (mOp.Equal(m$.fnc$("WWWDAY.main",m$.fnc$("WWWDATE1.DMY",mOp.Concat("06.01.",JAH.get()))),1)) {
            YI.set(6);
          }
          //<< . . IF YI'=1 SET SFWOCDAY=YI                   ; STARTDAY OF 2ND WEEK
          if (mOp.NotEqual(YI.get(),1)) {
            SFWOCDAY.set(YI.get());
          }
          //<< . .;IF YI=1 IF +MON'=1 IF +TAG'=1 SET SFWOCDAY=8 ; IF INPUT NOT 01.01.XXXX SET START SECOND WEEK TO 8 ;privation table-mat take-off
          //<< . . IF YI=1 IF '((+MON=1) && (+TAG=1)) SET SFWOCDAY=8 ; IF INPUT NOT 01.01.XXXX SET START SECOND WEEK TO 8 ;SR17585.1
          if (mOp.Equal(YI.get(),1)) {
            if (mOp.Not(((mOp.Equal(mOp.Positive(MON.get()),1)) && (mOp.Equal(mOp.Positive(TAG.get()),1))))) {
              SFWOCDAY.set(8);
            }
          }
          //<< . . ;
          //<< . .;IF TAG="01" IF $$^WWWMONTH($$^WWWDATE1(YDATUM))'=1 IF $$^WWWDAY($$^WWWDATE1(DAT))=7 IF $$^WWWDAY($$^WWWDATE1("01.01."_(JAH-1)))'=4 IF $$^WWWDAY($$^WWWDATE1("31.12."_JAH))'=4 IF $P($$^WWWWEEK("31.12."_JAH,1),".",1)'="01" SET WOC=WOC-1   ;WEM;22960;02.09.2003;ADDED
          //<< . .;IF TAG="01" IF +MON'=1 IF intTodaysDay=7 IF $$^WWWDAY($$DMY^WWWDATE1("01.01."_(JAH-1)))'=4 IF $$^WWWDAY($$DMY^WWWDATE1("31.12."_JAH))'=4 IF $PIECE($$^WWWWEEK("31.12."_JAH,1),".",1)'="01" SET WOC=WOC-1   ; SR17585.1
          //<< . . IF TAG="01" IF +MON'=1 IF intTodaysDay=7 IF intLastNewYear'=4 IF intEOYWeekDay'=4 IF $PIECE($$^WWWWEEK("31.12."_JAH,1),".",1)'="01" SET WOC=WOC-1
          if (mOp.Equal(TAG.get(),"01")) {
            if (mOp.NotEqual(mOp.Positive(MON.get()),1)) {
              if (mOp.Equal(intTodaysDay.get(),7)) {
                if (mOp.NotEqual(intLastNewYear.get(),4)) {
                  if (mOp.NotEqual(intEOYWeekDay.get(),4)) {
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.fnc$("WWWWEEK.main",mOp.Concat("31.12.",JAH.get()),1),".",1),"01")) {
                      WOC.set(mOp.Subtract(WOC.get(),1));
                    }
                  }
                }
              }
            }
          }
          //<< . . ;
          //<< . .; SR17146
          //<< . .;IF $$^WWWDAY($$^WWWDATE1("31.12."_(JAH-1)))=4 SET SFWOCDAY=11   ;WEM;22960;22.08.2003;ADDED
          //<< . .;IF $$^WWWDAY($$^WWWDATE1("01.01."_(JAH-1)))=4 DO
          //<< . .;. SET LYDAY=$$^WWWDAY($$^WWWDATE1("31.12."_(JAH-1)))   ; WEEKDAY OF THE 31st OF DECEMBER LAST YEAR ;charge
          //<< . . IF intEOLastYear=4 SET SFWOCDAY=11   ;WEM;22960;22.08.2003;ADDED
          if (mOp.Equal(intEOLastYear.get(),4)) {
            SFWOCDAY.set(11);
          }
          //<< . . IF intLastNewYear=4 DO
          if (mOp.Equal(intLastNewYear.get(),4)) {
            //<< . . . SET LYDAY    = intEOLastYear   ; WEEKDAY OF THE 31st OF DECEMBER LAST YEAR
            LYDAY.set(intEOLastYear.get());
            //<< . . . SET SFWOCDAY = (7-LYDAY)+8
            SFWOCDAY.set(mOp.Add((mOp.Subtract(7,LYDAY.get())),8));
          }
        } while (false);
      }
      //<< . ;
      //<< . QUIT:YQ=1
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
      //<< . ;
      //<< . ;
      //<< . ;--------------------------------------
      //<< .;IF +MON'=1 IF +TAG'=1 DO
      //<< . IF '((+MON=1) && (+TAG=1)) DO    ; SR17585.1
      if (mOp.Not(((mOp.Equal(mOp.Positive(MON.get()),1)) && (mOp.Equal(mOp.Positive(TAG.get()),1))))) {
        do {
          //<< . .; SR17146
          //<< . .;SET DAYS=($$^WWWDATE1(DAT)-$$^WWWDATE1(SFWOCDAY_".01."_JAH))  ; NUMBER OF DAYS FROM DATE AND THE DAY OF THE 2ND WEEK IN JANUARY TO BE CONVERTED ;within
          //<< . .;IF DAYS=0 IF $$^WWWDAY($$^WWWDATE1(TAG_".01."_JAH))=1 SET WOC=WOC+1 QUIT  ; IF NUM DAYS=0 AND DATE=MONDAY THEN 2ND WEEK
          //<< . . SET DAYS=($$DMY^WWWDATE1(DAT)-$$DMY^WWWDATE1(SFWOCDAY_".01."_JAH))  ; NUMBER OF DAYS FROM DATE AND THE DAY OF THE 2ND WEEK IN JANUARY TO BE CONVERTED ;within
          DAYS.set((mOp.Subtract(m$.fnc$("WWWDATE1.DMY",DAT.get()),m$.fnc$("WWWDATE1.DMY",mOp.Concat(mOp.Concat(SFWOCDAY.get(),".01."),JAH.get())))));
          //<< . . IF DAYS=0 IF $$^WWWDAY($$DMY^WWWDATE1(TAG_".01."_JAH))=1 SET WOC=WOC+1 QUIT  ; IF NUM DAYS=0 AND DATE=MONDAY THEN 2ND WEEK
          if (mOp.Equal(DAYS.get(),0)) {
            if (mOp.Equal(m$.fnc$("WWWDAY.main",m$.fnc$("WWWDATE1.DMY",mOp.Concat(mOp.Concat(TAG.get(),".01."),JAH.get()))),1)) {
              WOC.set(mOp.Add(WOC.get(),1));
              break;
            }
          }
          //<< . . IF DAYS=0 SET WOC=1 QUIT  ; IF NUM DAYS=0 AND DATE IS NOT MONDAY THEN 1ST WEEK ;privation
          if (mOp.Equal(DAYS.get(),0)) {
            WOC.set(1);
            break;
          }
          //<< . . IF DAYS#7=0 DO
          if (mOp.Equal(mOp.Modulus(DAYS.get(),7),0)) {
            //<< . . . IF DAYS'=0 IF DAYS'=7 SET WOC = WOC+(DAYS/7)+1
            if (mOp.NotEqual(DAYS.get(),0)) {
              if (mOp.NotEqual(DAYS.get(),7)) {
                WOC.set(mOp.Add(mOp.Add(WOC.get(),(mOp.Divide(DAYS.get(),7))),1));
              }
            }
            //<< . . . IF DAYS=7             SET WOC = WOC+2  ;TYBD;WACH MELDUNG BEI 17.1.2004; FALSCH;
            if (mOp.Equal(DAYS.get(),7)) {
              WOC.set(mOp.Add(WOC.get(),2));
            }
          }
          //<< . . ;
          //<< . . IF DAYS#7'=0 DO
          if (mOp.NotEqual(mOp.Modulus(DAYS.get(),7),0)) {
            do {
              //<< . . . IF DAYS>7           SET WOC = WOC+($PIECE(DAYS/7,".",1)+1)
              if (mOp.Greater(DAYS.get(),7)) {
                WOC.set(mOp.Add(WOC.get(),(mOp.Add(m$.Fnc.$piece(mOp.Divide(DAYS.get(),7),".",1),1))));
              }
              //<< . . . IF DAYS<7 IF DAYS>0 SET WOC = WOC+1 QUIT
              if (mOp.Less(DAYS.get(),7)) {
                if (mOp.Greater(DAYS.get(),0)) {
                  WOC.set(mOp.Add(WOC.get(),1));
                  break;
                }
              }
              //<< . . . IF DAYS<0           SET WOC = 1
              if (mOp.Less(DAYS.get(),0)) {
                WOC.set(1);
              }
            } while (false);
          }
        } while (false);
      }
    } while(false);
    //<< 
    //<< ; SPECIAL CALCULATION LEAP YEARS
    //<< ;---------------------------------------
    //<< IF (JAH#4=0) && (WOC'=52) && (WOC'=53) DO                                   ;WEM;24433;17.10.2003
    if ((mOp.Equal(mOp.Modulus(JAH.get(),4),0)) && (mOp.NotEqual(WOC.get(),52)) && (mOp.NotEqual(WOC.get(),53))) {
      do {
        //<< . IF (JAH=2028) || (JAH=2056) || (JAH=2084) || (JAH=2112) || (JAH=2140) DO   ; SPECIAL LEAP YEARS (ALL 28 YEARS)
        if ((mOp.Equal(JAH.get(),2028)) || (mOp.Equal(JAH.get(),2056)) || (mOp.Equal(JAH.get(),2084)) || (mOp.Equal(JAH.get(),2112)) || (mOp.Equal(JAH.get(),2140))) {
          do {
            //<< . .;IF $EXTRACT(DAT,1,6)'="01.10." IF $$^WWWDAY($$^WWWDATE1(DAT))=7 SET WOC=WOC-1 IF WOC<1 SET WOC=1 SET YQ=1 QUIT  ; SR17146
            //<< . . IF $EXTRACT(DAT,1,6)'="01.10." IF intTodaysDay=7 SET WOC=WOC-1 IF WOC<1 SET WOC=1 SET YQ=1 QUIT
            if (mOp.NotEqual(m$.Fnc.$extract(DAT.get(),1,6),"01.10.")) {
              if (mOp.Equal(intTodaysDay.get(),7)) {
                WOC.set(mOp.Subtract(WOC.get(),1));
                if (mOp.Less(WOC.get(),1)) {
                  WOC.set(1);
                  YQ.set(1);
                  break;
                }
              }
            }
            //<< . . IF WOC>1 SET WOC=WOC-1 SET YQ=1 QUIT
            if (mOp.Greater(WOC.get(),1)) {
              WOC.set(mOp.Subtract(WOC.get(),1));
              YQ.set(1);
              break;
            }
            //<< . . IF WOC<2               SET YQ=1 QUIT
            if (mOp.Less(WOC.get(),2)) {
              YQ.set(1);
              break;
            }
          } while (false);
        }
        //<< . ;
        //<< . QUIT:YQ=1
        if (mOp.Equal(YQ.get(),1)) {
          break;
        }
        //<< .;IF $$^WWWDAY($$^WWWDATE1("01.01."_JAH))=4 DO   ; SPECIAL LEAP YEAR (STARTS WITH THURSDAY)   ; SR17146
        //<< .;. IF $$^WWWDAY($$^WWWDATE1(DAT))=7 IF $EXTRACT(DAT,4,6)'="01." DO   ; MONTH NOT JANUARY
        //<< . IF intNewYearsDay=4 DO   ; SPECIAL LEAP YEAR (STARTS WITH THURSDAY)
        if (mOp.Equal(intNewYearsDay.get(),4)) {
          do {
            //<< . . IF intTodaysDay=7 IF $EXTRACT(DAT,4,6)'="01." DO   ; MONTH NOT JANUARY
            if (mOp.Equal(intTodaysDay.get(),7)) {
              if (mOp.NotEqual(m$.Fnc.$extract(DAT.get(),4,6),"01.")) {
                do {
                  //<< . . . IF $EXTRACT(DAT,1,3)="01." SET YQ=1 QUIT
                  if (mOp.Equal(m$.Fnc.$extract(DAT.get(),1,3),"01.")) {
                    YQ.set(1);
                    break;
                  }
                  //<< . . . SET WOC=WOC-1              SET YQ=1 QUIT
                  WOC.set(mOp.Subtract(WOC.get(),1));
                  YQ.set(1);
                  break;
                } while (false);
              }
            }
            //<< . . ;
            //<< . . QUIT:YQ=1
            if (mOp.Equal(YQ.get(),1)) {
              break;
            }
            //<< . .;IF $$^WWWDAY($$^WWWDATE1(DAT))=7 IF $EXTRACT(DAT,4,6)="01." DO   ; MONTH = JANUARY   ; SR17146
            //<< . . IF intTodaysDay=7 IF $EXTRACT(DAT,4,6)="01." DO                  ; MONTH = JANUARY
            if (mOp.Equal(intTodaysDay.get(),7)) {
              if (mOp.Equal(m$.Fnc.$extract(DAT.get(),4,6),"01.")) {
                do {
                  //<< . . . IF (+TAG=2) || (+TAG=3) SET WOC=1     SET YQ=1 QUIT
                  if ((mOp.Equal(mOp.Positive(TAG.get()),2)) || (mOp.Equal(mOp.Positive(TAG.get()),3))) {
                    WOC.set(1);
                    YQ.set(1);
                    break;
                  }
                  //<< . . . IF (TAG=18) || (TAG=25) SET WOC=WOC-1 SET YQ=1 QUIT
                  if ((mOp.Equal(TAG.get(),18)) || (mOp.Equal(TAG.get(),25))) {
                    WOC.set(mOp.Subtract(WOC.get(),1));
                    YQ.set(1);
                    break;
                  }
                } while (false);
              }
            }
          } while (false);
        }
        //<< . ;
        //<< . QUIT:YQ=1
        if (mOp.Equal(YQ.get(),1)) {
          break;
        }
        //<< . ;
        //<< . IF intTodaysDay=7 DO   ; NORMAL LEAP YEARS
        if (mOp.Equal(intTodaysDay.get(),7)) {
          do {
            //<< . . IF (intNewYearsDay=7) && (WOC>2) SET WOC=WOC-1                    QUIT
            if ((mOp.Equal(intNewYearsDay.get(),7)) && (mOp.Greater(WOC.get(),2))) {
              WOC.set(mOp.Subtract(WOC.get(),1));
              break;
            }
            //<< . . IF (intNewYearsDay=1) || (intNewYearsDay=2) || (intNewYearsDay=3) QUIT   ; FIXME - Do nothing?
            if ((mOp.Equal(intNewYearsDay.get(),1)) || (mOp.Equal(intNewYearsDay.get(),2)) || (mOp.Equal(intNewYearsDay.get(),3))) {
              break;
            }
          } while (false);
        }
      } while (false);
    }
    //<< .; IF $$^WWWDAY($$^WWWDATE1(DAT))=7 DO   ; NORMAL LEAP YEARS   ; SR17146
    //<< .; . IF $$^WWWDAY($$^WWWDATE1("01.01."_JAH))=7 IF WOC>2 SET WOC=WOC-1 QUIT
    //<< .; . IF $$^WWWDAY($$^WWWDATE1("01.01."_JAH))=1!($$^WWWDAY($$^WWWDATE1("01.01."_JAH))=2)!($$^WWWDAY($$^WWWDATE1("01.01."_JAH))=3) QUIT
    //<< 
    //<< ; FIXED RULE FOR DECEMBER SPECIAL LEAP YEARS (ALL 28 YEARS)
    //<< IF (JAH=2028) || (JAH=2056) || (JAH=2084) || (JAH=2112) || (JAH=2140) IF (MON=12) && ((WOC=52) || (WOC=53)) DO
    if ((mOp.Equal(JAH.get(),2028)) || (mOp.Equal(JAH.get(),2056)) || (mOp.Equal(JAH.get(),2084)) || (mOp.Equal(JAH.get(),2112)) || (mOp.Equal(JAH.get(),2140))) {
      if ((mOp.Equal(MON.get(),12)) && mOp.Logical(((mOp.Equal(WOC.get(),52)) || (mOp.Equal(WOC.get(),53))))) {
        do {
          //<< . IF TAG<17                      QUIT
          if (mOp.Less(TAG.get(),17)) {
            break;
          }
          //<< . IF TAG=17           SET WOC=50 QUIT
          if (mOp.Equal(TAG.get(),17)) {
            WOC.set(50);
            break;
          }
          //<< . IF TAG>17 IF TAG<25 SET WOC=51 QUIT
          if (mOp.Greater(TAG.get(),17)) {
            if (mOp.Less(TAG.get(),25)) {
              WOC.set(51);
              break;
            }
          }
          //<< . IF TAG>24 SET WOC=52
          if (mOp.Greater(TAG.get(),24)) {
            WOC.set(52);
          }
        } while (false);
      }
    }
    //<< 
    //<< SET WOC = $EXTRACT(100+WOC,2,3)
    WOC.set(m$.Fnc.$extract(mOp.Add(100,WOC.get()),2,3));
    //<< 
    //<< IF YPARA=1 QUIT WOC_"."_JAH_" "_$$^WWWTEXT(385)  ; "Week "
    if (mOp.Equal(m$.var("YPARA").get(),1)) {
      return mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(WOC.get(),"."),JAH.get())," "),m$.fnc$("WWWTEXT.main",385));
    }
    //<< IF YPARA=2 QUIT JAH_WOC
    if (mOp.Equal(m$.var("YPARA").get(),2)) {
      return mOp.Concat(JAH.get(),WOC.get());
    }
    //<< IF YPARA=3 QUIT JAH_"-"_WOC
    if (mOp.Equal(m$.var("YPARA").get(),3)) {
      return mOp.Concat(mOp.Concat(JAH.get(),"-"),WOC.get());
    }
    //<< IF YPARA=4 QUIT WOC
    if (mOp.Equal(m$.var("YPARA").get(),4)) {
      return WOC.get();
    }
    //<< QUIT WOC_JAH
    return mOp.Concat(WOC.get(),JAH.get());
  }

  //<< 
  //<< 
  //<< WOC1(YDATUM) ;
  public Object WOC1(Object ... _p) {
    mVar YDATUM = m$.newVarRef("YDATUM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    OLDVERSION();
    return null;
  }

  //<< 
  //<< OLDVERSION ;ALTE VERSION GGF LÖSCHEN ;Delete
  public Object OLDVERSION() {
    //<< ;
    //<< QUIT
    return null;
  }

//<< 
//<< ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK
//<< /*
//<< NEW DAT,JAH,WOC,MON,TAG
//<< ;
//<< ;
//<< ;YDATUM=$H ODER TT.MM.JJJJ ;Or
//<< ;
//<< ;YPARA=1 AUSGABE IN WW.JJJJ KW ;expenses within week
//<< ;YPARA=2 AUSGABE IN JJJJWW ;expenses within
//<< ;YPARA=3 AUSGABE IN JJJJ-WW ;expenses within
//<< SET YPARA=$GET(YPARA)
//<< IF '$DATA(YDATUM) SET YDATUM=""
//<< IF YDATUM="" SET YDATUM=+$HOROLOG
//<< ;
//<< SET DAT=YDATUM
//<< IF $FIND(DAT,"/") SET DAT=$PIECE(DAT,"/",2)_"."_$PIECE(DAT,"/",1)_"."_$PIECE(DAT,"/",3)
//<< IF $P(DAT,".",3)="" SET DAT=$$^WWWDATE($P(YDATUM,".",1))
//<< IF $FIND(DAT,"/") SET DAT=$PIECE(DAT,"/",2)_"."_$PIECE(DAT,"/",1)_"."_$PIECE(DAT,"/",3)
//<< IF $FIND(DAT,"-") SET DAT=$TRANSLATE(DAT,"-",".")
//<< SET MON=$PIECE(DAT,".",2),JAH=$PIECE(DAT,".",3),TAG=$PIECE(DAT,".",1)
//<< 
//<< SET DAT=$$^WWWDATE1("01.01."_JAH)
//<< SET DAT=$$^WWWDAY(DAT)  ;wochentag des 1.1.
//<< IF +MON=1,TAG<$PIECE("1;0;0;0;4;3;2",";",DAT) DO
//<< . SET JAH=JAH-1,MON=12,TAG=31
//<< . SET DAT=$$^WWWDATE1("01.01."_JAH)
//<< . SET DAT=$$^WWWDAY(DAT)
//<< 
//<< SET DAT(1)=$PIECE("0;1;2;3;-3;-2;-1",";",DAT)
//<< SET WOC=DAT(1)+TAG+$PIECE("0,31,59,90,120,151,181,212,243,273,304,334",",",MON)
//<< SET DAT("LY")=$SELECT(JAH#100:JAH#4=0,1:JAH#400=0)
//<< IF DAT("LY"),MON>2 SET WOC=WOC+1
//<< SET WOC=WOC\7+(WOC#7'=0)
//<< IF WOC=53 DO
//<< . IF $PIECE($GET(^WWW100(0,"WEEKS",SPRACHE,JAH,1)),Y,1)=53 QUIT   ;TYBD;22960;17.5.2003; PARAMETER FÜR JAHRESZAHL
//<< . IF $PIECE($GET(^WWW100(0,"WEEKS",SPRACHE,JAH,1)),Y,1)=52 SET JAH=JAH+1,WOC=1 QUIT   ;TYBD;22960;17.5.2003; PARAMETER FÜR JAHRESZAHL
//<< . IF DAT=4,'DAT("LY") QUIT
//<< . IF DAT=3,DAT("LY")  QUIT
//<< . SET JAH=JAH+1,WOC=1
//<< 
//<< SET WOC=$EXTRACT(100+WOC,2,3)
//<< IF YPARA=1 QUIT WOC_"."_JAH_" "_$$^WWWTEXT(385)  ;KW ;week
//<< IF YPARA=2 QUIT JAH_WOC      ;KW ;week
//<< IF YPARA=3 QUIT JAH_"-"_WOC  ;KW ;week
//<< QUIT WOC_JAH
//<< */
//<< 
}
