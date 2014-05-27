//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMSYSNum
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:12:35
//*****************************************************************************

package include;

import mLibrary.*;


//<< #; COMSYSNum.inc    Macros for number-related functions
//<< 
public class COMSYSNum extends mInclude {

  //<< #define GetNumDecimalPoints(%1)     $$GetDecimalPoints^WWWZAHL(%1)
  public static Object $$$GetNumDecimalPoints(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("WWWZAHL.GetDecimalPoints",p$1.get()));
  }

  //<< #define RoundToDecimalPoints(%1,%2) $fnumber(%2,"",$$$GetNumDecimalPoints(%1))
  public static Object $$$RoundToDecimalPoints(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$fnumber(p$2.get(),"",$$$GetNumDecimalPoints(m$,p$1)));
  }

  //<< 
  //<< 
  //<< #define IsNum(%str)         ((+$get(%str))=$get(%str))
  public static Object $$$IsNum(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal((mOp.Positive(m$.Fnc.$get(p$str))),m$.Fnc.$get(p$str))));
  }

  //<< #define NumberOfDP(%flt)    $length($piece($get(%flt),".",2))
  public static Object $$$NumberOfDP(mContext m$, Object ... _p) {
    mVar p$flt = m$.varRef("p$flt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$length(m$.Fnc.$piece(m$.Fnc.$get(p$flt),".",2)));
  }

  //<< 
  //<< 
  //<< #define Min(%1,%2)          $select((%1)>(%2):%2,1:%1)
  public static Object $$$Min(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select(mOp.Greater((p$1.get()),(p$2.get())),p$2.get(),1,p$1.get()));
  }

  //<< #define Max(%1,%2)          $select((%1)>(%2):%1,1:%2)
  public static Object $$$Max(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select(mOp.Greater((p$1.get()),(p$2.get())),p$1.get(),1,p$2.get()));
  }

  //<< 
  //<< #define IsPosInt(%1)        ((%1>0)&&(%1\1=%1))
  public static Object $$$IsPosInt(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (((mOp.Greater(p$1.get(),0)) && (mOp.Equal(mOp.IntegerDivide(p$1.get(),1),p$1.get()))));
  }

  //<< 
  //<< 
  //<< #; Foreign Currency
  //<< #; Bracketed second argument to handle case where %amt2 is in the form AMTa OP AMTb
  //<< #; 11-Jul-2005  JW      SR12811: Changed FINSYSFC to COMSYSFC
  //<< #; 07-Mar-2007  JW      SR15459: Added FCInc,FCDec,FCADD,FCSUB - can put fns in these macros.
  //<< 
  //<< #define FCInc(%amt1,%amt2)      set %2=%amt2,%amt1=$$$FCAdd(%amt1,%2)
  public static Object $$$FCInc(mContext m$, Object ... _p) {
    mVar p$amt1 = m$.varRef("p$amt1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$amt2 = m$.varRef("p$amt2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.var("%2").set(p$amt2.get());
    p$amt1.set($$$FCAdd(m$,p$amt1,m$.var("%2")));
    return null;
  }

  //<< #define FCDec(%amt1,%amt2)      set %2=%amt2,%amt1=$$$FCSub(%amt1,%2)
  public static Object $$$FCDec(mContext m$, Object ... _p) {
    mVar p$amt1 = m$.varRef("p$amt1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$amt2 = m$.varRef("p$amt2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.var("%2").set(p$amt2.get());
    p$amt1.set($$$FCSub(m$,p$amt1,m$.var("%2")));
    return null;
  }

  //<< #define FCADD(%amt1,%amt2,%res) set %1=%amt1,%2=%amt2,%res=$$$FCAdd(%1,%2)
  public static Object $$$FCADD(mContext m$, Object ... _p) {
    mVar p$amt1 = m$.varRef("p$amt1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$amt2 = m$.varRef("p$amt2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$res = m$.varRef("p$res",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.var("%1").set(p$amt1.get());
    m$.var("%2").set(p$amt2.get());
    p$res.set($$$FCAdd(m$,m$.var("%1"),m$.var("%2")));
    return null;
  }

  //<< #define FCSUB(%amt1,%amt2,%res) set %1=%amt1,%2=%amt2,%res=$$$FCSub(%1,%2)
  public static Object $$$FCSUB(mContext m$, Object ... _p) {
    mVar p$amt1 = m$.varRef("p$amt1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$amt2 = m$.varRef("p$amt2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$res = m$.varRef("p$res",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.var("%1").set(p$amt1.get());
    m$.var("%2").set(p$amt2.get());
    p$res.set($$$FCSub(m$,m$.var("%1"),m$.var("%2")));
    return null;
  }

  //<< 
  //<< #define FCGetAmountText(%amt)   $$GetAmountText^COMSYSFC(%amt)
  public static Object $$$FCGetAmountText(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMSYSFC.GetAmountText",p$amt.get()));
  }

  //<< #define FCMult(%amt1,%amt2)     $select((%amt1["@"):$$Mult^COMSYSFC(%amt1,%amt2),1:%amt1*(%amt2))
  public static Object $$$FCMult(mContext m$, Object ... _p) {
    mVar p$amt1 = m$.varRef("p$amt1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$amt2 = m$.varRef("p$amt2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select((mOp.Contains(p$amt1.get(),"@")),m$.fnc$("COMSYSFC.Mult",p$amt1.get(),p$amt2.get()),1,mOp.Multiply(p$amt1.get(),(p$amt2.get()))));
  }

  //<< #define FCMult2(%amt1,%amt2)    $select((%amt1["@"):$$Mult2^COMSYSFC(%amt1,%amt2),1:%amt1*(%amt2))
  public static Object $$$FCMult2(mContext m$, Object ... _p) {
    mVar p$amt1 = m$.varRef("p$amt1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$amt2 = m$.varRef("p$amt2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select((mOp.Contains(p$amt1.get(),"@")),m$.fnc$("COMSYSFC.Mult2",p$amt1.get(),p$amt2.get()),1,mOp.Multiply(p$amt1.get(),(p$amt2.get()))));
  }

  //<< #define FCDivd(%amt1,%amt2)     $select((%amt1["@"):$$Divd^COMSYSFC(%amt1,%amt2),1:%amt1/(%amt2))
  public static Object $$$FCDivd(mContext m$, Object ... _p) {
    mVar p$amt1 = m$.varRef("p$amt1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$amt2 = m$.varRef("p$amt2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select((mOp.Contains(p$amt1.get(),"@")),m$.fnc$("COMSYSFC.Divd",p$amt1.get(),p$amt2.get()),1,mOp.Divide(p$amt1.get(),(p$amt2.get()))));
  }

  //<< #define FCDivd2(%amt1,%amt2)    $select((%amt1["@"):$$Divd2^COMSYSFC(%amt1,%amt2),1:%amt1/(%amt2))
  public static Object $$$FCDivd2(mContext m$, Object ... _p) {
    mVar p$amt1 = m$.varRef("p$amt1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$amt2 = m$.varRef("p$amt2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select((mOp.Contains(p$amt1.get(),"@")),m$.fnc$("COMSYSFC.Divd2",p$amt1.get(),p$amt2.get()),1,mOp.Divide(p$amt1.get(),(p$amt2.get()))));
  }

  //<< #define FCAdd(%amt1,%amt2)      $select((%amt1["@")||(%amt2["@"):$$Add^COMSYSFC(%amt1,%amt2),1:%amt1+(%amt2))
  public static Object $$$FCAdd(mContext m$, Object ... _p) {
    mVar p$amt1 = m$.varRef("p$amt1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$amt2 = m$.varRef("p$amt2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select((mOp.Contains(p$amt1.get(),"@")) || (mOp.Contains(p$amt2.get(),"@")),m$.fnc$("COMSYSFC.Add",p$amt1.get(),p$amt2.get()),1,mOp.Add(p$amt1.get(),(p$amt2.get()))));
  }

  //<< #define FCSub(%amt1,%amt2)      $select((%amt1["@")||(%amt2["@"):$$Sub^COMSYSFC(%amt1,%amt2),1:%amt1-(%amt2))
  public static Object $$$FCSub(mContext m$, Object ... _p) {
    mVar p$amt1 = m$.varRef("p$amt1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$amt2 = m$.varRef("p$amt2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select((mOp.Contains(p$amt1.get(),"@")) || (mOp.Contains(p$amt2.get(),"@")),m$.fnc$("COMSYSFC.Sub",p$amt1.get(),p$amt2.get()),1,mOp.Subtract(p$amt1.get(),(p$amt2.get()))));
  }

  //<< #define FCSign(%amt)            $select(%amt["@":$$Sign^COMSYSFC(%amt),1:-(%amt))
  public static Object $$$FCSign(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Contains(p$amt.get(),"@"),m$.fnc$("COMSYSFC.Sign",p$amt.get()),1,mOp.Negative((p$amt.get()))));
  }

  //<< #define FCur(%amt)              $select(%amt["@":$$Cur^COMSYSFC(%amt),1:"")
  public static Object $$$FCur(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Contains(p$amt.get(),"@"),m$.fnc$("COMSYSFC.Cur",p$amt.get()),1,""));
  }

  //<< #def1arg FCRound(%amt)          $$Round^COMSYSFC(%amt)
  public static Object $$$FCRound(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMSYSFC.Round",p$amt.get()));
  }

  //<< #define FCBase(%amt)            $select(%amt["@":$$FCBase^COMSYSFC(%amt),1:%amt)
  public static Object $$$FCBase(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Contains(p$amt.get(),"@"),m$.fnc$("COMSYSFC.FCBase",p$amt.get()),1,p$amt.get()));
  }

  //<< #define FCAmount(%amt)          $select(%amt["@":$$FCAmount^COMSYSFC(%amt),1:%amt)
  public static Object $$$FCAmount(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Contains(p$amt.get(),"@"),m$.fnc$("COMSYSFC.FCAmount",p$amt.get()),1,p$amt.get()));
  }

  //<< #define FCRate(%amt)            $select(%amt["@":$$FCRate^COMSYSFC(%amt),1:"")
  public static Object $$$FCRate(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Contains(p$amt.get(),"@"),m$.fnc$("COMSYSFC.FCRate",p$amt.get()),1,""));
  }

  //<< #define FCZero(%amt)            $select(%amt["@":$$FCZero^COMSYSFC(%amt),1:'(%amt))
  public static Object $$$FCZero(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Contains(p$amt.get(),"@"),m$.fnc$("COMSYSFC.FCZero",p$amt.get()),1,mOp.Not((p$amt.get()))));
  }

  //<< #define FCGTZero(%amt)          $select(%amt["@":$$FCGTZero^COMSYSFC(%amt),1:%amt>0)
  public static Object $$$FCGTZero(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Contains(p$amt.get(),"@"),m$.fnc$("COMSYSFC.FCGTZero",p$amt.get()),1,mOp.Greater(p$amt.get(),0)));
  }

  //<< #define FCLTZero(%amt)          $select(%amt["@":$$FCLTZero^COMSYSFC(%amt),1:%amt<0)
  public static Object $$$FCLTZero(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Contains(p$amt.get(),"@"),m$.fnc$("COMSYSFC.FCLTZero",p$amt.get()),1,mOp.Less(p$amt.get(),0)));
  }

  //<< #define FCIsEqual(%amt1,%amt2)  $select((%amt1["@")&&(%amt2["@"):$$FCIsEqual^COMSYSFC(%amt1,%amt2),1:+%amt1=+(%amt2))
  public static Object $$$FCIsEqual(mContext m$, Object ... _p) {
    mVar p$amt1 = m$.varRef("p$amt1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$amt2 = m$.varRef("p$amt2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select((mOp.Contains(p$amt1.get(),"@")) && (mOp.Contains(p$amt2.get(),"@")),m$.fnc$("COMSYSFC.FCIsEqual",p$amt1.get(),p$amt2.get()),1,mOp.Equal(mOp.Positive(p$amt1.get()),mOp.Positive((p$amt2.get())))));
  }

  //<< #define FCUpdate(%amt,%rate,%mode)  $select(%amt["@":$$FCUpdate^COMSYSFC(%amt,%rate,%mode),1:+(%amt))
  public static Object $$$FCUpdate(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$rate = m$.varRef("p$rate",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$mode = m$.varRef("p$mode",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return (m$.Fnc.$select(mOp.Contains(p$amt.get(),"@"),m$.fnc$("COMSYSFC.FCUpdate",p$amt.get(),p$rate.get(),p$mode.get()),1,mOp.Positive((p$amt.get()))));
  }

  //<< #define FCMake(%base,%code,%rate)   $$FCMake^COMSYSFC(%base,%code,%rate)
  public static Object $$$FCMake(mContext m$, Object ... _p) {
    mVar p$base = m$.varRef("p$base",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$code = m$.varRef("p$code",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$rate = m$.varRef("p$rate",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return (m$.fnc$("COMSYSFC.FCMake",p$base.get(),p$code.get(),p$rate.get()));
  }

  //<< #define FCJoin(%base,%foreign,%code,%rate)          $$Join^COMSYSFC(%base,%foreign,%code,%rate)
  public static Object $$$FCJoin(mContext m$, Object ... _p) {
    mVar p$base = m$.varRef("p$base",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$foreign = m$.varRef("p$foreign",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$code = m$.varRef("p$code",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar p$rate = m$.varRef("p$rate",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    return (m$.fnc$("COMSYSFC.Join",p$base.get(),p$foreign.get(),p$code.get(),p$rate.get()));
  }

  //<< #define FCSplit(%amt,%base,%foreign,%code,%rate)    do Split^COMSYSFC(%amt,%base,%foreign,%code,%rate)
  public static Object $$$FCSplit(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$base = m$.varRef("p$base",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$foreign = m$.varRef("p$foreign",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar p$code = m$.varRef("p$code",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar p$rate = m$.varRef("p$rate",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    m$.Cmd.Do("COMSYSFC.Split",p$amt.get(),p$base.get(),p$foreign.get(),p$code.get(),p$rate.get());
    return null;
  }

  //<< #define AmountIsFC(%amt)            $$AmountIsFC^COMSYSFC(%amt)
  public static Object $$$AmountIsFC(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMSYSFC.AmountIsFC",p$amt.get()));
  }

  //<< #define CurIsFC(%amt)               $$CurIsFC^COMSYSFC(%amt)
  public static Object $$$CurIsFC(mContext m$, Object ... _p) {
    mVar p$amt = m$.varRef("p$amt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMSYSFC.CurIsFC",p$amt.get()));
  }

  //<< #define CurrencyToUse               $get(^CacheTemp(YUSER,$get(^CacheTemp(YUSER,"Grid","Container")," "),"Toggles","Currency"))
  public static Object $$$CurrencyToUse(mContext m$) {
    return (m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")," "),"Toggles","Currency")));
  }

  //<< 
  //<< #define GetAmount(%idAccount,%curAmount)    $select($$GetFCCode^FINGLFC(%idAccount)="":$$$FCBase(%curAmount),1:%curAmount)
  public static Object $$$GetAmount(mContext m$, Object ... _p) {
    mVar p$idAccount = m$.varRef("p$idAccount",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$curAmount = m$.varRef("p$curAmount",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select(mOp.Equal(m$.fnc$("FINGLFC.GetFCCode",p$idAccount.get()),""),$$$FCBase(m$,p$curAmount),1,p$curAmount.get()));
  }

//<< 
//<< 
}
