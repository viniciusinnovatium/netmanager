//*****************************************************************************
//** TASC - ALPHALINC - INC include.VARLog
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:55
//*****************************************************************************

package include;

import mLibrary.*;


//<< // Standard log macros
public class VARLog extends mInclude {

  //<< #define VARLOGERROR(%text)          do ##class(VAR.infra.log.Logger).LogError($$$CURRENTUNIT, $$$CURRENTROUTINE, %text, 0)
  public static Object $$$VARLOGERROR(mContext m$, Object ... _p) {
    mVar p$text = m$.varRef("p$text",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("VAR.infra.log.Logger.LogError",$$$CURRENTUNIT(m$),$$$CURRENTROUTINE(m$),p$text.get(),0);
    return null;
  }

  //<< #define VARLOGWARNING(%text)        do ##class(VAR.infra.log.Logger).LogWarning($$$CURRENTUNIT, $$$CURRENTROUTINE, %text, 0)
  public static Object $$$VARLOGWARNING(mContext m$, Object ... _p) {
    mVar p$text = m$.varRef("p$text",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("VAR.infra.log.Logger.LogWarning",$$$CURRENTUNIT(m$),$$$CURRENTROUTINE(m$),p$text.get(),0);
    return null;
  }

  //<< #define VARLOGINFO(%text)           do ##class(VAR.infra.log.Logger).LogInfo($$$CURRENTUNIT, $$$CURRENTROUTINE, %text, 0)
  public static Object $$$VARLOGINFO(mContext m$, Object ... _p) {
    mVar p$text = m$.varRef("p$text",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("VAR.infra.log.Logger.LogInfo",$$$CURRENTUNIT(m$),$$$CURRENTROUTINE(m$),p$text.get(),0);
    return null;
  }

  //<< #define VARLOGDEBUG(%text)          do ##class(VAR.infra.log.Logger).LogDebug($$$CURRENTUNIT, $$$CURRENTROUTINE, %text, 0)
  public static Object $$$VARLOGDEBUG(mContext m$, Object ... _p) {
    mVar p$text = m$.varRef("p$text",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("VAR.infra.log.Logger.LogDebug",$$$CURRENTUNIT(m$),$$$CURRENTROUTINE(m$),p$text.get(),0);
    return null;
  }

  //<< #define VARLOGERRSTATUS(%status)    ##class(VAR.infra.log.Logger).LogStatus($$$CURRENTUNIT, $$$CURRENTROUTINE, %status, 0)
  public static Object $$$VARLOGERRSTATUS(mContext m$, Object ... _p) {
    mVar p$status = m$.varRef("p$status",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("VAR.infra.log.Logger.LogStatus",$$$CURRENTUNIT(m$),$$$CURRENTROUTINE(m$),p$status.get(),0));
  }

  //<< 
  //<< #define VARLOGSCRERROR(%text)       do ##class(VAR.infra.log.Logger).LogError($$$CURRENTUNIT, $$$CURRENTROUTINE, %text, 1)
  public static Object $$$VARLOGSCRERROR(mContext m$, Object ... _p) {
    mVar p$text = m$.varRef("p$text",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("VAR.infra.log.Logger.LogError",$$$CURRENTUNIT(m$),$$$CURRENTROUTINE(m$),p$text.get(),1);
    return null;
  }

  //<< #define VARLOGSCRWARNING(%text)     do ##class(VAR.infra.log.Logger).LogWarning($$$CURRENTUNIT, $$$CURRENTROUTINE, %text, 1)
  public static Object $$$VARLOGSCRWARNING(mContext m$, Object ... _p) {
    mVar p$text = m$.varRef("p$text",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("VAR.infra.log.Logger.LogWarning",$$$CURRENTUNIT(m$),$$$CURRENTROUTINE(m$),p$text.get(),1);
    return null;
  }

  //<< #define VARLOGSCRINFO(%text)        do ##class(VAR.infra.log.Logger).LogInfo($$$CURRENTUNIT, $$$CURRENTROUTINE, %text, 1)
  public static Object $$$VARLOGSCRINFO(mContext m$, Object ... _p) {
    mVar p$text = m$.varRef("p$text",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("VAR.infra.log.Logger.LogInfo",$$$CURRENTUNIT(m$),$$$CURRENTROUTINE(m$),p$text.get(),1);
    return null;
  }

  //<< #define VARLOGSCRDEBUG(%text)       do ##class(VAR.infra.log.Logger).LogDebug($$$CURRENTUNIT, $$$CURRENTROUTINE, %text, 1)
  public static Object $$$VARLOGSCRDEBUG(mContext m$, Object ... _p) {
    mVar p$text = m$.varRef("p$text",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("VAR.infra.log.Logger.LogDebug",$$$CURRENTUNIT(m$),$$$CURRENTROUTINE(m$),p$text.get(),1);
    return null;
  }

  //<< #define VARLOGSCRERRSTATUS(%status) ##class(VAR.infra.log.Logger).LogStatus($$$CURRENTUNIT, $$$CURRENTROUTINE, %status, 1)
  public static Object $$$VARLOGSCRERRSTATUS(mContext m$, Object ... _p) {
    mVar p$status = m$.varRef("p$status",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("VAR.infra.log.Logger.LogStatus",$$$CURRENTUNIT(m$),$$$CURRENTROUTINE(m$),p$status.get(),1));
  }

  //<< 
  //<< // Transaction (Journal) log macros
  //<< #define VARLOGTRANSSAVEPOINT        do ##class(VAR.infra.log.Logger).LogTransactionsSavePoint()
  public static Object $$$VARLOGTRANSSAVEPOINT(mContext m$) {
    m$.Cmd.Do("VAR.infra.log.Logger.LogTransactionsSavePoint");
    return null;
  }

  //<< #define VARLOGTRANSFROMLASTPOINT    do ##class(VAR.infra.log.Logger).LogTransactionsFromLastPoint()
  public static Object $$$VARLOGTRANSFROMLASTPOINT(mContext m$) {
    m$.Cmd.Do("VAR.infra.log.Logger.LogTransactionsFromLastPoint");
    return null;
  }

  //<< 
  //<< // Context information
  //<< #define CURRENTCALL                 $stack($stack(0), "mcode")
  public static Object $$$CURRENTCALL(mContext m$) {
    return (m$.Fnc.$stack(m$.Fnc.$stack(0),"mcode"));
  }

  //<< #define CURRENTCODEPOSITION         $piece($stack($stack(-1), "place"), " +", 1)
  public static Object $$$CURRENTCODEPOSITION(mContext m$) {
    return (m$.Fnc.$piece(m$.Fnc.$stack(m$.Fnc.$stack(mOp.Negative(1)),"place")," +",1));
  }

  //<< #define CURRENTUNIT                 $zutil(67, 5, $job)
  public static Object $$$CURRENTUNIT(mContext m$) {
    return (m$.Fnc.$zutil(67,5,m$.Fnc.$job()));
  }

  //<< #define CURRENTROUTINE              $piece($$$CURRENTCODEPOSITION, "^", 1)
  public static Object $$$CURRENTROUTINE(mContext m$) {
    return (m$.Fnc.$piece($$$CURRENTCODEPOSITION(m$),"^",1));
  }

  //<< #define CURRENTLINE                 +$piece($$$CURRENTROUTINE, "+", 2)
  public static Object $$$CURRENTLINE(mContext m$) {
    return (mOp.Positive(m$.Fnc.$piece($$$CURRENTROUTINE(m$),"+",2)));
  }

  //<< #define CURRENTCLASS                ##expression(""""_$get(%classname)_"""")
  public static Object $$$CURRENTCLASS(mContext m$) {
    return ((mOp.Concat(mOp.Concat("\"",m$.Fnc.$get(m$.var("%classname"))),"\"")));
  }

  //<< #define CURRENTMETHOD               ##expression(""""_$get(%methodname)_"""")
  public static Object $$$CURRENTMETHOD(mContext m$) {
    return ((mOp.Concat(mOp.Concat("\"",m$.Fnc.$get(m$.var("%methodname"))),"\"")));
  }

}
