//*****************************************************************************
//** TASC - ALPHALINC - INC include.$occConstant
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:10:48
//*****************************************************************************

package include;

import mLibrary.*;


public class $occConstant extends mInclude {

  //<< #define NL                 $c(13,10)
  public static Object $$$NL(mContext m$) {
    return (m$.Fnc.$char(13,10));
  }

  //<< #define TAB                " "
  public static Object $$$TAB(mContext m$) {
    return (" ");
  }

  //<< #define NULLOREF           ""
  public static Object $$$NULLOREF(mContext m$) {
    return ("");
  }

  //<< #define NULLOID            ""
  public static Object $$$NULLOID(mContext m$) {
    return ("");
  }

  //<< 
  //<< #; Maximum lengths for various names. Some use the $zu(40,0,n) function, others are only defined here.
  //<< #define sysNameSizeGet(%f)      $zu(40,0,%f)
  public static Object $$$sysNameSizeGet(mContext m$, Object ... _p) {
    mVar p$f = m$.varRef("p$f",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zutil(40,0,p$f.get()));
  }

  //<< 
  //<< #define MAXRTNNAMELENGTH        $$$sysNameSizeGet(34)
  public static Object $$$MAXRTNNAMELENGTH(mContext m$) {
    return ($$$sysNameSizeGet(m$,34));
  }

  //<< #define MAXGLOBALNAMELENGTH     $$$sysNameSizeGet(35)
  public static Object $$$MAXGLOBALNAMELENGTH(mContext m$) {
    return ($$$sysNameSizeGet(m$,35));
  }

  //<< #define MAXVARIABLELENGTH       $$$sysNameSizeGet(36)
  public static Object $$$MAXVARIABLELENGTH(mContext m$) {
    return ($$$sysNameSizeGet(m$,36));
  }

  //<< 
  //<< #define MAXNAMELENGTH       31
  public static Object $$$MAXNAMELENGTH(mContext m$) {
    return (31);
  }

  //<< 
  //<< #;define MAXLABELLENGTH         $$$sysNameSizeGet(37)
  //<< #define MAXLABELLENGTH      31
  public static Object $$$MAXLABELLENGTH(mContext m$) {
    return (31);
  }

  //<< 
  //<< #; The CLASSID is the unique portion of a class name
  //<< #define MAXCLASSIDLENGTH        $$$sysNameSizeGet(38)
  public static Object $$$MAXCLASSIDLENGTH(mContext m$) {
    return ($$$sysNameSizeGet(m$,38));
  }

  //<< #; The PACKAGEID is the unique portion of the package name
  //<< #define MAXPACKAGEIDLENGTH      $$$sysNameSizeGet(39)
  public static Object $$$MAXPACKAGEIDLENGTH(mContext m$) {
    return ($$$sysNameSizeGet(m$,39));
  }

  //<< 
  //<< #define MAXCLASSNAMELENGTH 220
  public static Object $$$MAXCLASSNAMELENGTH(mContext m$) {
    return (220);
  }

  //<< #define MAXSQLNAMELENGTH   128
  public static Object $$$MAXSQLNAMELENGTH(mContext m$) {
    return (128);
  }

  //<< 
  //<< #define MaxStringLength 999999999
  public static Object $$$MaxStringLength(mContext m$) {
    return (999999999);
  }

  //<< #define MaxLocalLength $select($view($zutil(40,1,50),-1,4)=135168:32767,1:3641143)
  public static Object $$$MaxLocalLength(mContext m$) {
    return (m$.Fnc.$select(mOp.Equal(m$.Fnc.$view(m$.Fnc.$zutil(40,1,50),mOp.Negative(1),4),135168),32767,1,3641143));
  }

  //<< 
  //<< #define LOCKtimeout                                     "$zu(115,4)"
  public static Object $$$LOCKtimeout(mContext m$) {
    return ("$zu(115,4)");
  }

  //<< 
  //<< #define NameForGet         "Get"
  public static Object $$$NameForGet(mContext m$) {
    return ("Get");
  }

  //<< #define NameForSet         "Set"
  public static Object $$$NameForSet(mContext m$) {
    return ("Set");
  }

  //<< #define DEFAULTLOCALE      "default"
  public static Object $$$DEFAULTLOCALE(mContext m$) {
    return ("default");
  }

}
