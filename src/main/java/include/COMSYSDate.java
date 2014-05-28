//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMSYSDate
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:10:51
//*****************************************************************************

package include;

import mLibrary.*;


//<< 
//<< 
//<< #; Date extraction macros
public class COMSYSDate extends mInclude {

  //<< #define DateMonth(%obj)             (+$zdate(+(%obj),1))
  public static Object $$$DateMonth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Positive(m$.Fnc.$zdate(mOp.Positive((p$obj.get())),1))));
  }

  //<< #define DateDay(%obj)               (+$zdate(+(%obj),2))
  public static Object $$$DateDay(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Positive(m$.Fnc.$zdate(mOp.Positive((p$obj.get())),2))));
  }

  //<< #define DateYear(%obj)              (+$zdate(+(%obj),3))
  public static Object $$$DateYear(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Positive(m$.Fnc.$zdate(mOp.Positive((p$obj.get())),3))));
  }

  //<< 
  //<< #; SR14877
  //<< #define DateYearMonth(%obj)         $piece($zdate(%obj,3),"-",1,2)
  public static Object $$$DateYearMonth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(m$.Fnc.$zdate(p$obj.get(),3),"-",1,2));
  }

  //<< #define DateMonthDay(%obj)          $piece($zdate(%obj,3),"-",2,3)
  public static Object $$$DateMonthDay(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(m$.Fnc.$zdate(p$obj.get(),3),"-",2,3));
  }

  //<< #define DateFirstDayOfMonth(%obj)   $zdateh($$$DateYearMonth(%obj)_"-01",3)
  public static Object $$$DateFirstDayOfMonth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zdateh(mOp.Concat($$$DateYearMonth(m$,p$obj),"-01"),3));
  }

  //<< #define DateLastDayOfMonth(%obj)    $zdateh($$$DateYearMonth(%obj)_"-"_$$GetDaysInMonth^COMUtilDate(%obj),3)
  public static Object $$$DateLastDayOfMonth(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zdateh(mOp.Concat(mOp.Concat($$$DateYearMonth(m$,p$obj),"-"),m$.fnc$("COMUtilDate.GetDaysInMonth",p$obj.get())),3));
  }

  //<< 
  //<< #; SRBR014340
  //<< #define DateFirstDayOfYear(%obj)    $zdateh($$$DateYear(%obj)_"-01-01",3)
  public static Object $$$DateFirstDayOfYear(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zdateh(mOp.Concat($$$DateYear(m$,p$obj),"-01-01"),3));
  }

  //<< #define DateLastDayOfYear(%obj)     $zdateh($$$DateYear(%obj)_"-12-31",3)
  public static Object $$$DateLastDayOfYear(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zdateh(mOp.Concat($$$DateYear(m$,p$obj),"-12-31"),3));
  }

  //<< 
  //<< #; SR14549
  //<< #define DateWithinRange(%1,%2,%3)   ((%1>=%2)&&(%1<=%3))
  public static Object $$$DateWithinRange(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$3 = m$.varRef("p$3",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return (((mOp.GreaterOrEqual(p$1.get(),p$2.get())) && (mOp.LessOrEqual(p$1.get(),p$3.get()))));
  }

  //<< 
  //<< #;SR15384 - return int (Mon=1,Sun=7)
  //<< #define DayOfWeek(%1)               ((%1+3)#7+1)
  public static Object $$$DayOfWeek(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Add(mOp.Modulus((mOp.Add(p$1.get(),3)),7),1)));
  }

  //<< 
  //<< #; SR15347 - time constants
  //<< #define Midnight        0
  public static Object $$$Midnight(mContext m$) {
    return (0);
  }

  //<< #define SecsInDay       86400
  public static Object $$$SecsInDay(mContext m$) {
    return (86400);
  }

  //<< 
  //<< #define ToSeconds(%1)   ($piece(%1,$$$COMMA,1)*86400+$piece(%1,$$$COMMA,2))
  public static Object $$$ToSeconds(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Add(mOp.Multiply(m$.Fnc.$piece(p$1.get(),include.COMSYSString.$$$COMMA(m$),1),86400),m$.Fnc.$piece(p$1.get(),include.COMSYSString.$$$COMMA(m$),2))));
  }

  //<< #define DateDiff(%1,%2) $$$ToSeconds(%2)-$$$ToSeconds(%1)
  public static Object $$$DateDiff(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (mOp.Subtract($$$ToSeconds(m$,p$2),$$$ToSeconds(m$,p$1)));
  }

//<< 
//<< 
//<< 
//<< 
}
