//*****************************************************************************
//** TASC - ALPHALINC - INC include.$occOptions
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:04
//*****************************************************************************

package include;

import mLibrary.*;


public class $occOptions extends mInclude {

  //<< #define CompileDebugMode          $g(^%qCacheObjectSys("debug"))
  public static Object $$$CompileDebugMode(mContext m$) {
    return (m$.Fnc.$get(m$.var("^%qCacheObjectSys","debug")));
  }

  //<< #define LogInfo                   $g(^%qCacheObjectSys("loginfo"))
  public static Object $$$LogInfo(mContext m$) {
    return (m$.Fnc.$get(m$.var("^%qCacheObjectSys","loginfo")));
  }

  //<< #define StrictChecking            $g(^%qCacheObjectSys("strictchecking"),1)
  public static Object $$$StrictChecking(mContext m$) {
    return (m$.Fnc.$get(m$.var("^%qCacheObjectSys","strictchecking"),1));
  }

  //<< #define CreateMAC                 $g(^%qCacheObjectSys("createmac"))
  public static Object $$$CreateMAC(mContext m$) {
    return (m$.Fnc.$get(m$.var("^%qCacheObjectSys","createmac")));
  }

  //<< 
  //<< #define SysMultiDimProperty       $zbitget($zversion(0)_$c(0,0,0),23)
  public static Object $$$SysMultiDimProperty(mContext m$) {
    return (m$.Fnc.$zbitget(mOp.Concat(m$.Fnc.$zversion(0),m$.Fnc.$char(0,0,0)),23));
  }

  //<< #define SysReferenceCount         $zbitget($zversion(0)_$c(0,0,0,0),25)
  public static Object $$$SysReferenceCount(mContext m$) {
    return (m$.Fnc.$zbitget(mOp.Concat(m$.Fnc.$zversion(0),m$.Fnc.$char(0,0,0,0)),25));
  }

  //<< #define hasNEWLANGUAGE            $zbitget($zversion(0)_$c(0,0,0),20)
  public static Object $$$hasNEWLANGUAGE(mContext m$) {
    return (m$.Fnc.$zbitget(mOp.Concat(m$.Fnc.$zversion(0),m$.Fnc.$char(0,0,0)),20));
  }

  //<< #define IsUnicode                 $zbitget($zversion(0),1)
  public static Object $$$IsUnicode(mContext m$) {
    return (m$.Fnc.$zbitget(m$.Fnc.$zversion(0),1));
  }

  //<< 
  //<< #define isVMS                     ($zversion(1)=1)
  public static Object $$$isVMS(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$zversion(1),1)));
  }

  //<< #define isWINDOWS                 ($zversion(1)=2)
  public static Object $$$isWINDOWS(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$zversion(1),2)));
  }

  //<< #define isUNIX                    ($zversion(1)=3)
  public static Object $$$isUNIX(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$zversion(1),3)));
  }

  //<< 
  //<< #define CacheVersion              $p($p($zv,") ",2)," ",1)
  public static Object $$$CacheVersion(mContext m$) {
    return (m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$zversion(),") ",2)," ",1));
  }

  //<< #define CacheVersionMajor         $p($$$CacheVersion,".",1)
  public static Object $$$CacheVersionMajor(mContext m$) {
    return (m$.Fnc.$piece($$$CacheVersion(m$),".",1));
  }

  //<< #define CacheVersionMinor         $p($$$CacheVersion,".",2)
  public static Object $$$CacheVersionMinor(mContext m$) {
    return (m$.Fnc.$piece($$$CacheVersion(m$),".",2));
  }

  //<< #;CFL713+
  //<< #define CachePlatform             $p($p($zv,"(",2),")",1)
  public static Object $$$CachePlatform(mContext m$) {
    return (m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$zversion(),"(",2),")",1));
  }

  //<< #define CacheProduct              $p($zv," (")
  public static Object $$$CacheProduct(mContext m$) {
    return (m$.Fnc.$piece(m$.Fnc.$zversion()," ("));
  }

  //<< #define CacheOS                   $p($zv," ",3,$l($$$CacheProduct," "))
  public static Object $$$CacheOS(mContext m$) {
    return (m$.Fnc.$piece(m$.Fnc.$zversion()," ",3,m$.Fnc.$length($$$CacheProduct(m$)," ")));
  }

  //<< #;CFL713-
  //<< 
  //<< //#if 0 ; MC169+
  //<< #define isCACHE31                 $p($p($zv,") ",2)," ")'<3.1
  public static Object $$$isCACHE31(mContext m$) {
    return (mOp.NotLess(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$zversion(),") ",2)," "),3.1));
  }

  //<< #define isCACHE32                 $p($p($zv,") ",2)," ")'<3.2
  public static Object $$$isCACHE32(mContext m$) {
    return (mOp.NotLess(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$zversion(),") ",2)," "),3.2));
  }

  //<< #define isCACHE40                 $zbitget($zversion(0)_$c(0,0,0),20)
  public static Object $$$isCACHE40(mContext m$) {
    return (m$.Fnc.$zbitget(mOp.Concat(m$.Fnc.$zversion(0),m$.Fnc.$char(0,0,0)),20));
  }

  //<< //#else ; MC169=
  //<< //#define isCACHE31                 $$$CacheVersion'<3.1
  //<< //#define isCACHE32                 $$$CacheVersion'<3.2
  //<< //#define isCACHE40                 $$$CacheVersion'<4.0
  //<< //#endif ; MC169-
  //<< 
  //<< //#if 1   ; DLP495=
  //<< //#define hasSORTFUNC               $zbitget($zversion(0)_$c(0,0),14)
  //<< //#define hasBITFUNC                $zbitget($zversion(0)_$c(0,0),15)
  //<< //#endif  ; DLP495-
  //<< 
  //<< #; Upper case macros from %occConstant.inc
  //<< 
  //<< #define ucase(%string)     $zcvt(%string,"u")
  public static Object $$$ucase(mContext m$, Object ... _p) {
    mVar p$string = m$.varRef("p$string",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zconvert(p$string.get(),"u"));
  }

  //<< #define lcase(%string)     $zcvt(%string,"l")
  public static Object $$$lcase(mContext m$, Object ... _p) {
    mVar p$string = m$.varRef("p$string",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zconvert(p$string.get(),"l"));
  }

//<< 
//<< #; SQL Options - copied from %msql.inc
//<< 
//<< //#define DefSchema $g(^%SYS("sql","sys","default schema"))
//<< //#define DefSchemaNaked $g(^("default schema"))
//<< //#define SchemaExpression $s($$$UPPER($p($$$DefSchema,"/"))'="_CURRENT_USER":$$$DefSchemaNaked,1:$s($p($$$aid,"@")'="":$p($$$aid,"@"),1:$s($p($$$DefSchemaNaked,"/",2)="":"SQLUser",1:$p($$$DefSchemaNaked,"/",2))))
//<< 
//<< //#define DefaultSchema $$$SchemaExpression
//<< //#define DEFAULTSCHEMA $$$UPPER($$$SchemaExpression)
//<< //#define DefaultSchemaQ $$quoter2^%apiSQL($$$SchemaExpression)
//<< //#define DEFAULTSCHEMAQ $$quoter2^%apiSQL($$$UPPER($$$SchemaExpression))
}
