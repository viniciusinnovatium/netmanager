//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUtilDate
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:04
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; Date Manipulation Utilities
//<< ;
//<< ; See also :
//<< ;   COMUtilStr      String Manipulation
//<< ;   COMUtils        Other Common Utilities
//<< ;
//<< ; History:
//<< ; 17-Feb-2005   GRF     Additional Doco
//<< ; 01-Jul-2004   GRF     Created; moved some routines from COMUtils
//<< ;-------------------------------------------------------------------------------
//<< 
//<< ;-------------------------------------------------------------------------------
//<< ; Date & Time Functions
//<< ; =====================
//<< ; Special Values
//<< ;    $H     $HOROLOG        Internal : Current Time   ddddd,ttttt
//<< ;    $ZTS   $ZTIMESTAMP     Internal : Universal Time ddddd,ttttt.ttt
//<< ;                                      based on $ZTIMEZONE & Daylight Savings
//<< ;
//<< ;
//<< ; Internal to Literal
//<< ;    $ZD    $ZDATE          e.g. MM/DD/[YY]YY
//<< ;    $ZDT   $ZDATETIME      e.g. MM/DD/[YY]YY hh:mm:ss[.ffff] - see Cache doco for formats
//<< ;    $ZT    $ZTIME          hh:mm[:ss] [AM/PM]   (12 or 24 hr) based on format code 1-4
//<< ;
//<< ; Literal to Internal
//<< ;    $ZDH   $ZDATEH
//<< ;    $ZDTH  $ZDATETIMEH
//<< ;    $ZTH   $ZTIMEH
//<< ;
//<< ; Date Format Codes
//<< ;  1 MM/DD/[YY]YY    (07/01/97)
//<< ;  2 DD Mmm [YY]YY   (01 Jul 97)
//<< ;  3 YYYY-MM-DD      (1997-07-01)   - ODBC format
//<< ;  4 DD/MM/[YY]YY    (01/07/97)     - European format
//<< ;  5 Mmm D, YYYY     (Jul 1, 1997)
//<< ;  6 Mmm D YYYY      (Jul 1 1997)
//<< ;  7 Mmm DD [YY]YY   (Jul 01 1997)
//<< ;  8 YYYYMMDD        (19970701)     - Numeric format
//<< ;  9 Mmmmm D, YYYY   (July 1, 1997)
//<< ; 10 W               (2) [2nd day of the week]      * Internal to Literal Only *
//<< ; 11 Www             (Tue)                          * Internal to Literal Only *
//<< ; 12 Wwwwww          (Tuesday)                      * Internal to Literal Only *
//<< ;-------------------------------------------------------------------------------
//<< 
//<< #include COMConst
import include.COMConst;
import include.COMSYS;
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
//<< #include WWWConst
import include.WWWConst;

//<< COMUtilDate
public class COMUtilDate extends mClass {

  //<< #define SecondsInDay 86400
  public static Object $$$SecondsInDay(mContext m$) {
    return (86400);
  }

  //<< #define MonthsInYear 12
  public static Object $$$MonthsInYear(mContext m$) {
    return (12);
  }

  public void main() {
    _COMUtilDate();
  }

  public void _COMUtilDate() {
  }

  //<< 
  //<< 
  //<< GetEndOfMonth(pdteDate)
  public Object GetEndOfMonth(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; For a date, return the date at the end of the month.
    //<< ;
    //<< ; Returns: date ($horolog format)
    //<< ;
    //<< ; History:
    //<< ; 08-Jun-2005   Steve S     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intDays,intMonth,intYear
    mVar intDays = m$.var("intDays");
    mVar intMonth = m$.var("intMonth");
    mVar intYear = m$.var("intYear");
    m$.newVar(intDays,intMonth,intYear);
    //<< 
    //<< set:$get(pdteDate)="" pdteDate=+$horolog
    if (mOp.Equal(m$.Fnc.$get(pdteDate),"")) {
      pdteDate.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< 
    //<< set intDays     = $$GetDaysInMonth(pdteDate)
    intDays.set(m$.fnc$("GetDaysInMonth",pdteDate.get()));
    //<< set intMonth    = $$$DateMonth(pdteDate)
    intMonth.set(include.COMSYSDate.$$$DateMonth(m$,pdteDate));
    //<< set intYear     = $$$DateYear(pdteDate)
    intYear.set(include.COMSYSDate.$$$DateYear(m$,pdteDate));
    //<< 
    //<< quit $zdateh(intMonth_"/"_intDays_"/"_intYear)
    return m$.Fnc.$zdateh(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(intMonth.get(),"/"),intDays.get()),"/"),intYear.get()));
  }

  //<< 
  //<< 
  //<< GetStartOfMonth(pdteDate)
  public Object GetStartOfMonth(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; For a date, return the date at the start of the month.
    //<< ;
    //<< ; Returns: date ($horolog format)
    //<< ;
    //<< ; History:
    //<< ; 09-Jun-2005   Steve S     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intMonth,intYear
    mVar intMonth = m$.var("intMonth");
    mVar intYear = m$.var("intYear");
    m$.newVar(intMonth,intYear);
    //<< 
    //<< set:$get(pdteDate)="" pdteDate=+$horolog
    if (mOp.Equal(m$.Fnc.$get(pdteDate),"")) {
      pdteDate.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< 
    //<< set intMonth      = $$$DateMonth(pdteDate)
    intMonth.set(include.COMSYSDate.$$$DateMonth(m$,pdteDate));
    //<< set intYear       = $$$DateYear(pdteDate)
    intYear.set(include.COMSYSDate.$$$DateYear(m$,pdteDate));
    //<< 
    //<< quit $zdateh(intMonth_"/1/"_intYear)
    return m$.Fnc.$zdateh(mOp.Concat(mOp.Concat(intMonth.get(),"/1/"),intYear.get()));
  }

  //<< 
  //<< 
  //<< GetMonthString(pdteDate)
  public Object GetMonthString(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; For a date, return the month string literal ("January", "February", etc.)
    //<< ;
    //<< ; Returns: string
    //<< ;
    //<< ; History:
    //<< ; 08-Jun-2005   Steve S     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intMonth,strMonth
    mVar intMonth = m$.var("intMonth");
    mVar strMonth = m$.var("strMonth");
    m$.newVar(intMonth,strMonth);
    //<< 
    //<< set:$get(pdteDate)="" pdteDate=+$h
    if (mOp.Equal(m$.Fnc.$get(pdteDate),"")) {
      pdteDate.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< 
    //<< set strMonth = ""
    strMonth.set("");
    //<< set intMonth = $$$DateMonth(pdteDate)
    intMonth.set(include.COMSYSDate.$$$DateMonth(m$,pdteDate));
    //<< set strMonth = $$$AppEnum("COMMONTHSOFYEAR",intMonth)
    strMonth.set(include.COMSYSWWW.$$$AppEnum(m$,"COMMONTHSOFYEAR",intMonth));
    //<< 
    //<< quit strMonth
    return strMonth.get();
  }

  //<< 
  //<< 
  //<< ConvertDate(pstrDate="",pstrFormat=1,pdteDate="")
  public Object ConvertDate(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrFormat = m$.newVarRef("pstrFormat",(((_p!=null)&&(_p.length>=2))?_p[1]:null),1);
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Converts a date to horolog and returns a status if not successful.
    //<< ;
    //<< ; pstrFormat values: 1-9 see above
    //<< 
    //<< ; ByRef  : pdteDate
    //<< ; Returns: Status
    //<< ;
    //<< ; History:
    //<< ; 17-Feb-2005   GRF     Boolean Macros; clarify ByRef
    //<< ; 05-Nov-2004   GRF     Add parameter defaults
    //<< ; 21-Oct-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< //FIXME: A Fin language text in the COM module ??
    //<< 
    //<< set pdteDate=$zdateh(pstrDate,pstrFormat,,,,,,,$lb("Fin00394",pstrDate))  ;Invalid Date Format: '%1'
    pdteDate.set(m$.Fnc.$zdateh(pstrDate.get(),pstrFormat.get(),null,null,null,null,null,null,m$.Fnc.$listbuild("Fin00394",pstrDate.get())));
    //<< if 'pdteDate {
    if (mOp.Not(pdteDate.get())) {
      //<< set strStatus=pdteDate
      strStatus.set(pdteDate.get());
      //<< set pdteDate=""
      pdteDate.set("");
    }
    //<< } else {
    else {
      //<< set strStatus=$$$OK
      strStatus.set(include.COMSYS.$$$OK(m$));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< Date(pstrDate="",pstrFormat=1)
  public Object Date(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrFormat = m$.newVarRef("pstrFormat",(((_p!=null)&&(_p.length>=2))?_p[1]:null),1);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns a horolog for a date string. can pass in the format.
    //<< ;
    //<< ; Format : -1 or 1 through 9
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2004   GRF     Add parameter defaults
    //<< ; 31-Mar-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< set $ztrap="DateException"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("DateException");
    //<< 
    //<< // FIXME: Why do we have this routine? Just call $zdateh directly. Nothing seems
    //<< //        to be calling this.
    //<< 
    //<< quit $zdateh(pstrDate,pstrFormat)
    return m$.Fnc.$zdateh(pstrDate.get(),pstrFormat.get());
  }

  //<< 
  //<< 
  //<< DateException
  public Object DateException() {
    //<< quit 0
    return 0;
  }

  //<< 
  //<< 
  //<< DateDiff(pdteFirst="",pdteSecond="")
  public Object DateDiff(Object ... _p) {
    mVar pdteFirst = m$.newVarRef("pdteFirst",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pdteSecond = m$.newVarRef("pdteSecond",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ; ----------------------------------------------------------------------------
    //<< ; Determine the number of seconds difference between two $horolog dates
    //<< ;
    //<< ; NOTE: This is not taking leap seconds into consideration.
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2004   GRF     Add parameter defaults
    //<< ; 28-Mar-2003   Paul K  Created(Commented)
    //<< ; ----------------------------------------------------------------------------
    //<< new plngFirst,plngSecond
    mVar plngFirst = m$.var("plngFirst");
    mVar plngSecond = m$.var("plngSecond");
    m$.newVar(plngFirst,plngSecond);
    //<< 
    //<< set plngFirst  = $piece(pdteFirst ,$$$COMMA,1)*$$$SecondsInDay+$piece(pdteFirst ,$$$COMMA,2)
    plngFirst.set(mOp.Add(mOp.Multiply(m$.Fnc.$piece(pdteFirst.get(),include.COMSYSString.$$$COMMA(m$),1),$$$SecondsInDay(m$)),m$.Fnc.$piece(pdteFirst.get(),include.COMSYSString.$$$COMMA(m$),2)));
    //<< set plngSecond = $piece(pdteSecond,$$$COMMA,1)*$$$SecondsInDay+$piece(pdteSecond,$$$COMMA,2)
    plngSecond.set(mOp.Add(mOp.Multiply(m$.Fnc.$piece(pdteSecond.get(),include.COMSYSString.$$$COMMA(m$),1),$$$SecondsInDay(m$)),m$.Fnc.$piece(pdteSecond.get(),include.COMSYSString.$$$COMMA(m$),2)));
    //<< 
    //<< quit plngSecond-plngFirst
    return mOp.Subtract(plngSecond.get(),plngFirst.get());
  }

  //<< 
  //<< 
  //<< Max(pdteFirst="",pdteSecond="")
  public Object Max(Object ... _p) {
    mVar pdteFirst = m$.newVarRef("pdteFirst",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pdteSecond = m$.newVarRef("pdteSecond",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns the later of two horolog "date,time" or "date" values
    //<< ;
    //<< ; Returns:Date
    //<< ;
    //<< ; History:
    //<< ; 15-Mar-2005   GRF     Remove else so terminating quit case is clearer
    //<< ; 21-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< if $$DateDiff(pdteFirst,pdteSecond) < 0 {
    if (mOp.Less(m$.fnc$("DateDiff",pdteFirst.get(),pdteSecond.get()),0)) {
      //<< quit pdteFirst
      return pdteFirst.get();
    }
    //<< }
    //<< quit pdteSecond
    return pdteSecond.get();
  }

  //<< 
  //<< 
  //<< GetDaysInMonth(pdteDate="")
  public Object GetDaysInMonth(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ; ----------------------------------------------------------------------------
    //<< ; Returns the number of days in the month of the date passed in.
    //<< ;
    //<< ; Input : pdteDate as +$HOROLOG format
    //<< ;
    //<< ; History:
    //<< ; 19-Dec-2006   Steve S SR15244: Rewrote and greatly simplified
    //<< ; 05-Nov-2004   GRF     Add parameter defaults
    //<< ; 28-Mar-2003   Paul K  Created (Commented)
    //<< ; ----------------------------------------------------------------------------
    //<< 
    //<< //  SR15244: Use $case statement. Experiments at the terminal prompt reveal this
    //<< //  to be about 5 times quicker than complex $zd logic, as per the old method.
    //<< 
    //<< quit $case($$$DateMonth(pdteDate),1:31,                                                   //Jan
    //<< 2:$select($$IsLeapYear($$$DateYear(pdteDate)):29,1:28), //Feb
    //<< 3:31,                                                   //Mar
    //<< 4:30,                                                   //Apr
    //<< 5:31,                                                   //May
    //<< 6:30,                                                   //June
    //<< 7:31,                                                   //July
    //<< 8:31,                                                   //Aug
    //<< 9:30,                                                   //Sept
    //<< 10:31,                                                   //Oct
    //<< 11:30,                                                   //Nov
    //<< 12:31)                                                   //Dec
    return m$.Fnc.$case(include.COMSYSDate.$$$DateMonth(m$,pdteDate),1,31,2,m$.Fnc.$select(m$.fnc$("IsLeapYear",include.COMSYSDate.$$$DateYear(m$,pdteDate)),29,1,28),3,31,4,30,5,31,6,30,7,31,8,31,9,30,10,31,11,30,12,31);
  }

  //<< /* SR15244: Commented
  //<< new lngYear,lngMonth,dteFirstNextMonth
  //<< 
  //<< set pdteDate = $zdate(pdteDate,3)
  //<< set lngYear  = $piece(pdteDate,"-",1)
  //<< set lngMonth = $piece(pdteDate,"-",2)+1
  //<< if lngMonth>$$$MonthsInYear {
  //<< set lngYear  = lngYear + 1
  //<< set lngMonth = lngMonth-$$$MonthsInYear
  //<< }
  //<< set dteFirstNextMonth = lngYear_"-"_lngMonth_"-01"
  //<< set dteFirstNextMonth = $zdateh(dteFirstNextMonth,3)
  //<< 
  //<< quit $piece($zdate(dteFirstNextMonth-1,3),"-",3)
  //<< */
  //<< 
  //<< 
  //<< AddSeconds(pdteDate="",lngSeconds=0)
  public Object AddSeconds(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar lngSeconds = m$.newVarRef("lngSeconds",(((_p!=null)&&(_p.length>=2))?_p[1]:null),0);
    //<< ; ----------------------------------------------------------------------------
    //<< ; Adds X number of seconds to a $horolog format date.
    //<< ;                               ========
    //<< ;
    //<< ; NOTE: This is not taking leap seconds into consideration.
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2004   GRF     Add parameter defaults
    //<< ; 28-Mar-2003   Paul K  Created(Commented)
    //<< ; ----------------------------------------------------------------------------
    //<< new lngTotalSeconds
    mVar lngTotalSeconds = m$.var("lngTotalSeconds");
    m$.newVar(lngTotalSeconds);
    //<< 
    //<< set lngTotalSeconds=$piece(pdteDate,$$$COMMA,1)*$$$SecondsInDay+$piece(pdteDate,$$$COMMA,2)+lngSeconds
    lngTotalSeconds.set(mOp.Add(mOp.Add(mOp.Multiply(m$.Fnc.$piece(pdteDate.get(),include.COMSYSString.$$$COMMA(m$),1),$$$SecondsInDay(m$)),m$.Fnc.$piece(pdteDate.get(),include.COMSYSString.$$$COMMA(m$),2)),lngSeconds.get()));
    //<< quit (lngTotalSeconds\$$$SecondsInDay)_$$$COMMA_(lngTotalSeconds#$$$SecondsInDay)
    return mOp.Concat(mOp.Concat((mOp.IntegerDivide(lngTotalSeconds.get(),$$$SecondsInDay(m$))),include.COMSYSString.$$$COMMA(m$)),(mOp.Modulus(lngTotalSeconds.get(),$$$SecondsInDay(m$))));
  }

  //<< 
  //<< 
  //<< AddMonth(pdteDate,pintNumMonths=0,pintOffset="")
  public Object AddMonth(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintNumMonths = m$.newVarRef("pintNumMonths",(((_p!=null)&&(_p.length>=2))?_p[1]:null),0);
    mVar pintOffset = m$.newVarRef("pintOffset",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Adds/Subtracts a specified number of months from a date.  Will try and
    //<< ; get as close as it can in case day of month>current month
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Dec-2004   Paul K  Added Offset
    //<< ; 07-Nov-2003   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intNumDays,intNumMonths,intNumYears,lngDaysInMonth
    mVar intNumDays = m$.var("intNumDays");
    mVar intNumMonths = m$.var("intNumMonths");
    mVar intNumYears = m$.var("intNumYears");
    mVar lngDaysInMonth = m$.var("lngDaysInMonth");
    m$.newVar(intNumDays,intNumMonths,intNumYears,lngDaysInMonth);
    //<< 
    //<< set pintNumMonths=pintNumMonths\1
    pintNumMonths.set(mOp.IntegerDivide(pintNumMonths.get(),1));
    //<< 
    //<< if pintNumMonths>0 {
    if (mOp.Greater(pintNumMonths.get(),0)) {
      //<< set intNumMonths = pintNumMonths#$$$MonthsInYear
      intNumMonths.set(mOp.Modulus(pintNumMonths.get(),$$$MonthsInYear(m$)));
      //<< set intNumYears  = pintNumMonths\$$$MonthsInYear
      intNumYears.set(mOp.IntegerDivide(pintNumMonths.get(),$$$MonthsInYear(m$)));
    }
    //<< } else {
    else {
      //<< set intNumMonths = pintNumMonths#-$$$MonthsInYear
      intNumMonths.set(mOp.Modulus(pintNumMonths.get(),mOp.Negative($$$MonthsInYear(m$))));
      //<< set intNumYears  = pintNumMonths\$$$MonthsInYear
      intNumYears.set(mOp.IntegerDivide(pintNumMonths.get(),$$$MonthsInYear(m$)));
    }
    //<< }
    //<< if pintOffset'="" {
    if (mOp.NotEqual(pintOffset.get(),"")) {
      //<< set intNumDays = +pintOffset\1
      intNumDays.set(mOp.IntegerDivide(mOp.Positive(pintOffset.get()),1));
      //<< if intNumDays<=0 set intNumDays = 1
      if (mOp.LessOrEqual(intNumDays.get(),0)) {
        intNumDays.set(1);
      }
    }
    //<< } else {
    else {
      //<< set intNumDays = $piece($zdate(pdteDate,3),"-",3)
      intNumDays.set(m$.Fnc.$piece(m$.Fnc.$zdate(pdteDate.get(),3),"-",3));
    }
    //<< }
    //<< set intNumMonths = intNumMonths+$piece($zdate(pdteDate,3),"-",2)
    intNumMonths.set(mOp.Add(intNumMonths.get(),m$.Fnc.$piece(m$.Fnc.$zdate(pdteDate.get(),3),"-",2)));
    //<< set intNumYears  = $piece($zdate(pdteDate,3),"-",1)+intNumYears
    intNumYears.set(mOp.Add(m$.Fnc.$piece(m$.Fnc.$zdate(pdteDate.get(),3),"-",1),intNumYears.get()));
    //<< 
    //<< if intNumMonths<1 {
    if (mOp.Less(intNumMonths.get(),1)) {
      //<< set intNumMonths = intNumMonths+$$$MonthsInYear
      intNumMonths.set(mOp.Add(intNumMonths.get(),$$$MonthsInYear(m$)));
      //<< set intNumYears  = intNumYears-1
      intNumYears.set(mOp.Subtract(intNumYears.get(),1));
    }
    //<< } elseif intNumMonths>$$$MonthsInYear {
    else if (mOp.Greater(intNumMonths.get(),$$$MonthsInYear(m$))) {
      //<< set intNumMonths = intNumMonths-$$$MonthsInYear
      intNumMonths.set(mOp.Subtract(intNumMonths.get(),$$$MonthsInYear(m$)));
      //<< set intNumYears  = intNumYears+1
      intNumYears.set(mOp.Add(intNumYears.get(),1));
    }
    //<< }
    //<< set pdteDate = intNumYears_"-"_intNumMonths_"-01"
    pdteDate.set(mOp.Concat(mOp.Concat(mOp.Concat(intNumYears.get(),"-"),intNumMonths.get()),"-01"));
    //<< set lngDaysInMonth = $$GetDaysInMonth($zdateh(pdteDate,3))
    lngDaysInMonth.set(m$.fnc$("GetDaysInMonth",m$.Fnc.$zdateh(pdteDate.get(),3)));
    //<< if intNumDays>lngDaysInMonth set intNumDays = lngDaysInMonth
    if (mOp.Greater(intNumDays.get(),lngDaysInMonth.get())) {
      intNumDays.set(lngDaysInMonth.get());
    }
    //<< 
    //<< quit $zdateh(intNumYears_"-"_intNumMonths_"-"_intNumDays,3)
    return m$.Fnc.$zdateh(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(intNumYears.get(),"-"),intNumMonths.get()),"-"),intNumDays.get()),3);
  }

  //<< 
  //<< 
  //<< AddWeek(pstrDate="",pintAddWeek="",pintOffset="")
  public Object AddWeek(Object ... _p) {
    mVar pstrDate = m$.newVarRef("pstrDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintAddWeek = m$.newVarRef("pintAddWeek",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pintOffset = m$.newVarRef("pintOffset",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< 
    //<< if pstrDate="" set pstrDate=+$h
    if (mOp.Equal(pstrDate.get(),"")) {
      pstrDate.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< set pstrDate=pstrDate+(7*pintAddWeek)
    pstrDate.set(mOp.Add(pstrDate.get(),(mOp.Multiply(7,pintAddWeek.get()))));
    //<< 
    //<< if pintOffset'="" {
    if (mOp.NotEqual(pintOffset.get(),"")) {
      //<< set pstrDate=pstrDate-$zdate(pstrDate,10)+pintOffset
      pstrDate.set(mOp.Add(mOp.Subtract(pstrDate.get(),m$.Fnc.$zdate(pstrDate.get(),10)),pintOffset.get()));
    }
    //<< }
    //<< quit pstrDate
    return pstrDate.get();
  }

  //<< 
  //<< 
  //<< IsLeapYear(pintYear=0)
  public Object IsLeapYear(Object ... _p) {
    mVar pintYear = m$.newVarRef("pintYear",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; A function to determine if a year is a leap year.
    //<< ;
    //<< ; Returns:Boolean
    //<< ;
    //<< ; History:
    //<< ; 05-Jan-2004   GRF     SR11415 : Standardise in COM Module
    //<< ; 28-Jul-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnLeapYear
    mVar blnLeapYear = m$.var("blnLeapYear");
    m$.newVar(blnLeapYear);
    //<< 
    //<< // TODO: Make a macro to avoid the extra function call.
    //<< 
    //<< set blnLeapYear = $$$NO
    blnLeapYear.set(include.COMSYS.$$$NO(m$));
    //<< if (pintYear#4=0) && ((pintYear#400=0) || (pintYear#100'=0)) {
    if ((mOp.Equal(mOp.Modulus(pintYear.get(),4),0)) && mOp.Logical(((mOp.Equal(mOp.Modulus(pintYear.get(),400),0)) || (mOp.NotEqual(mOp.Modulus(pintYear.get(),100),0))))) {
      //<< set blnLeapYear = $$$YES
      blnLeapYear.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< quit blnLeapYear
    return blnLeapYear.get();
  }

  //<< 
  //<< 
  //<< WithinDateRange(pdteDate="",pdteLower="",pdteUpper="")
  public Object WithinDateRange(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pdteLower = m$.newVarRef("pdteLower",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pdteUpper = m$.newVarRef("pdteUpper",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Is pdteDate within the date range given by pdteLower -> pdteUpper?
    //<< ;
    //<< ; Returns: boolean
    //<< ;
    //<< ; History:
    //<< ; 21-Mar-2005   JW      Simplified.
    //<< ; 28-Jan-2005   Steve S Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnWithinRange
    mVar blnWithinRange = m$.var("blnWithinRange");
    m$.newVar(blnWithinRange);
    //<< 
    //<< set blnWithinRange=$$$YES
    blnWithinRange.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< if pdteDate'="" {
    if (mOp.NotEqual(pdteDate.get(),"")) {
      //<< if (pdteLower>pdteDate) {
      if ((mOp.Greater(pdteLower.get(),pdteDate.get()))) {
        //<< set blnWithinRange=$$$NO
        blnWithinRange.set(include.COMSYS.$$$NO(m$));
      }
      //<< } elseif (pdteUpper'="")&&(pdteDate>pdteUpper) {
      else if ((mOp.NotEqual(pdteUpper.get(),"")) && (mOp.Greater(pdteDate.get(),pdteUpper.get()))) {
        //<< set blnWithinRange=$$$NO
        blnWithinRange.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit blnWithinRange
    return blnWithinRange.get();
  }

  //<< 
  //<< 
  //<< FindBadDates(pblnFix=$$$NO,pstrModule="")
  public Object FindBadDates(Object ... _p) {
    mVar pblnFix = m$.newVarRef("pblnFix",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$NO(m$));
    mVar pstrModule = m$.newVarRef("pstrModule",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Looks through the @Net globals for date and timestamp fields.
    //<< ; Fixes them if they're out.
    //<< ;
    //<< ; History:
    //<< ; 15-Mar-2005   GRF     Boolean Macro in parameters
    //<< ; 04-Mar-2005   Steve S Newed idKey,KeyLoop,objRef
    //<< ; 23-Feb-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idField,objField,strRef,intTypeGuess,intGuess,strDate
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar objField = m$.var("objField");
    mVar strRef = m$.var("strRef");
    mVar intTypeGuess = m$.var("intTypeGuess");
    mVar intGuess = m$.var("intGuess");
    mVar strDate = m$.var("strDate");
    m$.newVar(idClass,idField,objField,strRef,intTypeGuess,intGuess,strDate);
    //<< new idKey,KeyLoop,objRef
    mVar idKey = m$.var("idKey");
    mVar KeyLoop = m$.var("KeyLoop");
    mVar objRef = m$.var("objRef");
    m$.newVar(idKey,KeyLoop,objRef);
    //<< 
    //<< // TODO : Move to a DEV .mac file??
    //<< 
    //<< set idClass=""
    idClass.set("");
    //<< for {
    for (;true;) {
      //<< set idClass=$order(^WWW001(0,idClass))
      idClass.set(m$.Fnc.$order(m$.var("^WWW001",0,idClass.get())));
      //<< quit:idClass=""
      if (mOp.Equal(idClass.get(),"")) {
        break;
      }
      //<< 
      //<< if $extract(idClass,1,$length(pstrModule))=pstrModule {
      if (mOp.Equal(m$.Fnc.$extract(idClass.get(),1,m$.Fnc.$length(pstrModule.get())),pstrModule.get())) {
        //<< set idField=""
        idField.set("");
        //<< for {
        for (;true;) {
          //<< set idField=$order(^WWW003(0,idClass,idField))
          idField.set(m$.Fnc.$order(m$.var("^WWW003",0,idClass.get(),idField.get())));
          //<< quit:idField=""
          if (mOp.Equal(idField.get(),"")) {
            break;
          }
          //<< 
          //<< set objField=$get(^WWW003(0,idClass,idField,1))
          objField.set(m$.Fnc.$get(m$.var("^WWW003",0,idClass.get(),idField.get(),1)));
          //<< set strRef="^"_idClass_"(0)"
          strRef.set(mOp.Concat(mOp.Concat("^",idClass.get()),"(0)"));
          //<< set intTypeGuess=""
          intTypeGuess.set("");
          //<< if ($$$WWW003InputType(objField)=1) || ($$$WWW003InputType(objField)=14) {
          if ((mOp.Equal(include.WWWConst.$$$WWW003InputType(m$,objField),1)) || (mOp.Equal(include.WWWConst.$$$WWW003InputType(m$,objField),14))) {
            //<< for {
            for (;true;) {
              //<< set strRef=$query(@strRef)
              strRef.set(m$.Fnc.$query(m$.indirectVar(strRef.get())));
              //<< quit:strRef=""
              if (mOp.Equal(strRef.get(),"")) {
                break;
              }
              //<< 
              //<< set strDate=$piece(@strRef,"~",idField)
              strDate.set(m$.Fnc.$piece(m$.indirectVar(strRef.get()).get(),"~",idField.get()));
              //<< set intGuess=""
              intGuess.set("");
              //<< if strDate'="" {
              if (mOp.NotEqual(strDate.get(),"")) {
                //<< if strDate=+strDate {
                if (mOp.Equal(strDate.get(),mOp.Positive(strDate.get()))) {
                  //<< set intGuess=1
                  intGuess.set(1);
                }
                //<< } else {
                else {
                  //<< set intGuess=14
                  intGuess.set(14);
                }
              }
              //<< }
              //<< }
              //<< quit:('pblnFix)&&(intGuess'="")&&(intTypeGuess'="")&&(intTypeGuess'=intGuess)
              if ((mOp.Not(pblnFix.get())) && (mOp.NotEqual(intGuess.get(),"")) && (mOp.NotEqual(intTypeGuess.get(),"")) && (mOp.NotEqual(intTypeGuess.get(),intGuess.get()))) {
                break;
              }
              //<< 
              //<< set intTypeGuess=intGuess
              intTypeGuess.set(intGuess.get());
              //<< if (pblnFix)&&(intGuess'="")&&(intGuess'=$$$WWW003InputType(objField)) {
              if (mOp.Logical((pblnFix.get())) && (mOp.NotEqual(intGuess.get(),"")) && (mOp.NotEqual(intGuess.get(),include.WWWConst.$$$WWW003InputType(m$,objField)))) {
                //<< if $$$WWW003InputType(objField)=1 set strDate=+strDate
                if (mOp.Equal(include.WWWConst.$$$WWW003InputType(m$,objField),1)) {
                  strDate.set(mOp.Positive(strDate.get()));
                }
                //<< if $$$WWW003InputType(objField)=14 set strDate=strDate_",43200"  ;midday
                if (mOp.Equal(include.WWWConst.$$$WWW003InputType(m$,objField),14)) {
                  strDate.set(mOp.Concat(strDate.get(),",43200"));
                }
                //<< write YCR,"Class:"_idClass_" Field:("_idField_") "_$$$WWW003PropertyDescription(objField)_" "_$piece(@strRef,"~",idField)_" changed to:"_strDate
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Class:",idClass.get())," Field:("),idField.get()),") "),include.WWWConst.$$$WWW003PropertyDescription(m$,objField))," "),m$.Fnc.$piece(m$.indirectVar(strRef.get()).get(),"~",idField.get()))," changed to:"),strDate.get()));
                //<< if $$$WWW003IndexKey(objField)="" {
                if (mOp.Equal(include.WWWConst.$$$WWW003IndexKey(m$,objField),"")) {
                  //<< set $piece(@strRef,"~",idField)=strDate
                  m$.pieceVar(m$.indirectVar(strRef.get()),"~",idField.get()).set(strDate.get());
                }
                //<< } else {
                else {
                  //<< set idKey=""
                  idKey.set("");
                  //<< for KeyLoop=2:1:$qlength(strRef)-1 {
                  for (KeyLoop.set(2);(mOp.LessOrEqual(KeyLoop.get(),mOp.Subtract(m$.Fnc.$qlength(strRef),1)));KeyLoop.set(mOp.Add(KeyLoop.get(),1))) {
                    //<< if idKey'="" set idKey=idKey_","
                    if (mOp.NotEqual(idKey.get(),"")) {
                      idKey.set(mOp.Concat(idKey.get(),","));
                    }
                    //<< set idKey=idKey_$qsubscript(strRef,KeyLoop)
                    idKey.set(mOp.Concat(idKey.get(),m$.Fnc.$qsubscript(strRef,KeyLoop.get())));
                  }
                  //<< }
                  //<< set objRef=@strRef
                  objRef.set(m$.indirectVar(strRef.get()).get());
                  //<< set $piece(objRef,"~",idField)=strDate
                  m$.pieceVar(objRef,"~",idField.get()).set(strDate.get());
                  //<< set @strRef=objRef
                  m$.indirectVar(strRef.get()).set(objRef.get());
                }
              }
            }
            //<< ;set strStatus=$$$Save(idClass,idKey,objRef)
            //<< }
            //<< 
            //<< }
            //<< }
            //<< if strRef'="" {
            if (mOp.NotEqual(strRef.get(),"")) {
              //<< write YCR,"Class:"_idClass_" Field:("_idField_") "_$$$WWW003PropertyDescription(objField)_" ("_$$GetEnumDescription^COMUtils("FELDTYP",$$$WWW003InputType(objField),1)_") has a mix of dates and time stamps"
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Class:",idClass.get())," Field:("),idField.get()),") "),include.WWWConst.$$$WWW003PropertyDescription(m$,objField))," ("),m$.fnc$("COMUtils.GetEnumDescription","FELDTYP",include.WWWConst.$$$WWW003InputType(m$,objField),1)),") has a mix of dates and time stamps"));
            }
            //<< } else {
            else {
              //<< if (intTypeGuess'="")&&(intTypeGuess'=$$$WWW003InputType(objField)) {
              if ((mOp.NotEqual(intTypeGuess.get(),"")) && (mOp.NotEqual(intTypeGuess.get(),include.WWWConst.$$$WWW003InputType(m$,objField)))) {
                //<< write YCR,"Class:"_idClass_" Field:("_idField_") "_$$$WWW003PropertyDescription(objField)_" is a '"_$$GetEnumDescription^COMUtils("FELDTYP",$$$WWW003InputType(objField),1)_"' should be a '"_$$GetEnumDescription^COMUtils("FELDTYP",intTypeGuess,1)_"'"
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Class:",idClass.get())," Field:("),idField.get()),") "),include.WWWConst.$$$WWW003PropertyDescription(m$,objField))," is a '"),m$.fnc$("COMUtils.GetEnumDescription","FELDTYP",include.WWWConst.$$$WWW003InputType(m$,objField),1)),"' should be a '"),m$.fnc$("COMUtils.GetEnumDescription","FELDTYP",intTypeGuess.get(),1)),"'"));
              }
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

//<< 
}
