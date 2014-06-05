//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMSYSString
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:52:12
//*****************************************************************************

package include;

import mLibrary.*;


//<< #; Macros for string-related functions
//<< 
public class COMSYSString extends mInclude {

  //<< #define NULLCHAR    $c(0)
  public static Object $$$NULLCHAR(mContext m$) {
    return (m$.Fnc.$char(0));
  }

  //<< #define TAB         $c(9)
  public static Object $$$TAB(mContext m$) {
    return (m$.Fnc.$char(9));
  }

  //<< #define CRLF        $c(13,10)
  public static Object $$$CRLF(mContext m$) {
    return (m$.Fnc.$char(13,10));
  }

  //<< #define DBLQUOTE    """"
  public static Object $$$DBLQUOTE(mContext m$) {
    return ("\"");
  }

  //<< #define PLUS        "+"
  public static Object $$$PLUS(mContext m$) {
    return ("+");
  }

  //<< #define MINUS       "-"
  public static Object $$$MINUS(mContext m$) {
    return ("-");
  }

  //<< #define SGLQUOTE    "'"
  public static Object $$$SGLQUOTE(mContext m$) {
    return ("'");
  }

  //<< #define COMMA       ","
  public static Object $$$COMMA(mContext m$) {
    return (",");
  }

  //<< ;16126 vvv
  //<< ;#define FAKECOMMA "‚"
  //<< #define FAKECOMMA   "¸"
  public static Object $$$FAKECOMMA(mContext m$) {
    return ("¸");
  }

  //<< #define GRAVE       "`"
  public static Object $$$GRAVE(mContext m$) {
    return ("`");
  }

  //<< #define ACUTE       "´"
  public static Object $$$ACUTE(mContext m$) {
    return ("´");
  }

  //<< #define SPACE       " "
  public static Object $$$SPACE(mContext m$) {
    return (" ");
  }

  //<< #define NULLID      ""
  public static Object $$$NULLID(mContext m$) {
    return ("");
  }

  //<< #define FWDSLASH    "/"
  public static Object $$$FWDSLASH(mContext m$) {
    return ("/");
  }

  //<< #define BACKSLASH   "\"
  public static Object $$$BACKSLASH(mContext m$) {
    return ("\\");
  }

  //<< #define SEMICOLON   ";"
  public static Object $$$SEMICOLON(mContext m$) {
    return (";");
  }

  //<< #define SPFILL      $justify("",200)
  public static Object $$$SPFILL(mContext m$) {
    return (m$.Fnc.$justify("",200));
  }

  //<< #define SPC(%1)     $justify("",%1)
  public static Object $$$SPC(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$justify("",p$1.get()));
  }

  //<< #define C255        "ÿ"
  public static Object $$$C255(mContext m$) {
    return ("ÿ");
  }

  //<< 
  //<< #; Add/remove quotes to a string
  //<< #define QUOTE(%str)         $$$DBLQUOTE_%str_$$$DBLQUOTE
  public static Object $$$QUOTE(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mOp.Concat(mOp.Concat($$$DBLQUOTE(m$),p$str.get()),$$$DBLQUOTE(m$)));
  }

  //<< #define DEQUOTE(%str)       $translate(%str,"""")
  public static Object $$$DEQUOTE(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$translate(p$str.get(),"\""));
  }

  //<< 
  //<< 
  //<< #; $zstrip macro's for ease of use
  //<< #; 11-Apr-2006      PO/SS       SR14442: Trims can now be used
  //<< #; 19-Dec-2005      RPW         SR12974: StripToNumber added
  //<< #; 25-Jan-2007      JW          SR15384: StripNum used
  //<< #define StripNum(%1)        $zstrip(%1,"*N")
  public static Object $$$StripNum(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zstrip(p$1.get(),"*N"));
  }

  //<< #define StripToNumber(%1)   $zstrip(%1,"*APCW")
  public static Object $$$StripToNumber(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zstrip(p$1.get(),"*APCW"));
  }

  //<< #define LTRIMWS(%1)         $zstrip(%1,"<W")
  public static Object $$$LTRIMWS(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zstrip(p$1.get(),"<W"));
  }

  //<< #define RTRIMWS(%1)         $zstrip(%1,">W")
  public static Object $$$RTRIMWS(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zstrip(p$1.get(),">W"));
  }

  //<< #define TRIMWS(%1)          $zstrip(%1,"<>W")
  public static Object $$$TRIMWS(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zstrip(p$1.get(),"<>W"));
  }

  //<< 
  //<< #define JSText(%1)          $zconvert(%1,"o","JS")
  public static Object $$$JSText(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zconvert(p$1.get(),"o","JS"));
  }

  //<< #define HTMLText(%1)        $zconvert(%1,"o","HTML")
  public static Object $$$HTMLText(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zconvert(p$1.get(),"o","HTML"));
  }

  //<< 
  //<< #define UPPER(%1)   $zcvt(%1,"U")
  public static Object $$$UPPER(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zconvert(p$1.get(),"U"));
  }

  //<< #define LOWER(%1)   $zcvt(%1,"L")
  public static Object $$$LOWER(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zconvert(p$1.get(),"L"));
  }

  //<< 
  //<< #; 25-Oct-2006      JW      BR014279: Prepend
  //<< #define Append(%1,%2)       set %1 = %1_%2
  public static Object $$$Append(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    p$1.set(mOp.Concat(p$1.get(),p$2.get()));
    return null;
  }

  //<< #define Prepend(%1,%2)      set %1 = %2_%1
  public static Object $$$Prepend(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    p$1.set(mOp.Concat(p$2.get(),p$1.get()));
    return null;
  }

  //<< #define SQLNull(%1)         ($ascii(%1)=0)
  public static Object $$$SQLNull(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal(m$.Fnc.$ascii(p$1.get()),0)));
  }

  //<< 
  //<< #; 08-Dec-2006      Steve S SR15292: Useful for %query null checks
  //<< #define IsNull(%1)          ($get(%1)="")||($$$SQLNull(%1))
  public static Object $$$IsNull(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal(m$.Fnc.$get(p$1),"")) || mOp.Logical(($$$SQLNull(m$,p$1))));
  }

  //<< 
  //<< 
  //<< #define ValidCharsInExpression(%1)  ($zstrip(%1,"*E",,"0123456789eEF()+-*/.")=%1)
  public static Object $$$ValidCharsInExpression(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal(m$.Fnc.$zstrip(p$1.get(),"*E",null,"0123456789eEF()+-*/."),p$1.get())));
  }

  //<< #define BracketsMatch(%1)           ($length(%1,"(")=$length(%1,")"))
  public static Object $$$BracketsMatch(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal(m$.Fnc.$length(p$1.get(),"("),m$.Fnc.$length(p$1.get(),")"))));
  }

  //<< 
  //<< #define Split(%1,%2,%3)         for %=1:1:$length(%1,%2) s %3(%)=$piece(%1,%2,%)
  public static Object $$$Split(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$3 = m$.varRef("p$3",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    for (m$.var("%").set(1);(mOp.LessOrEqual(m$.var("%").get(),m$.Fnc.$length(p$1.get(),p$2.get())));m$.var("%").set(mOp.Add(m$.var("%").get(),1))) {
      p$3.var(m$.var("%").get()).set(m$.Fnc.$piece(p$1.get(),p$2.get(),m$.var("%").get()));
    }
    return null;
  }

  //<< #define Join(%1,%2,%3)          set %="" for { set %=$order(%1(%)) quit:%=""  set $piece(%3,%2,%)=%1(%) }
  public static Object $$$Join(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$3 = m$.varRef("p$3",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.var("%").set("");
    for (;true;) {
      m$.var("%").set(m$.Fnc.$order(p$1.var(m$.var("%").get())));
      if (mOp.Equal(m$.var("%").get(),"")) {
        break;
      }
      m$.pieceVar(p$3,p$2.get(),m$.var("%").get()).set(p$1.var(m$.var("%").get()).get());
    }
    return null;
  }

  //<< #define ToJSBoolean(%1)         $select(%1:"true",$$$YES:"false")
  public static Object $$$ToJSBoolean(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(p$1.get(),"true",include.COMSYS.$$$YES(m$),"false"));
  }

  //<< 
  //<< #define LC  "ÜÄÖüäöß][\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/"_$CHAR(128)_""" "
  public static Object $$$LC(mContext m$) {
    return (mOp.Concat(mOp.Concat("ÜÄÖüäöß][\\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\" "));
  }

  //<< #define UC  "UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   "
  public static Object $$$UC(mContext m$) {
    return ("UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   ");
  }

  //<< #define LC2 "ÜÄÖüäöß][\}{|~abcdefghijklmnopqrstuvwxyz"
  public static Object $$$LC2(mContext m$) {
    return ("ÜÄÖüäöß][\\}{|~abcdefghijklmnopqrstuvwxyz");
  }

  //<< #define UC2 "UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ"
  public static Object $$$UC2(mContext m$) {
    return ("UAOUAOSUAOUAOSABCDEFGHIJKLMNOPQRSTUVWXYZ");
  }

}
