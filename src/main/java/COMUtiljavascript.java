//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUtiljavascript
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:53:59
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

//<< COMUtiljavascript
public class COMUtiljavascript extends mClass {

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
    _COMUtiljavascript();
  }

  public void _COMUtiljavascript() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^COMUtiljavascript("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Write out an HTML script tag only if it is required.
  //<< ;
  //<< ; Params:
  //<< ; pstrAttributes -
  //<< ; pstrScriptType -
  //<< ;
  //<< ; ByRefs: None
  //<< ;
  //<< ; Returns: Nothing
  //<< ;
  //<< ; History:
  //<< ; 13-Dec-2006   JW&SH   SR15311: Switched condition.  '$$$InHyperEvent is incorrect.
  //<< ; 20-Jun-2006   RPW     SRBR014013: Check for %session existing
  //<< ; 23-May-2006   PO      SR14665: Created
  //<< ;-------------------------------------------------------------------------------
  //<< StartScript(pstrAttributes="",pstrScriptType="type='text/javascript'")
  public Object StartScript(Object ... _p) {
    mVar pstrAttributes = m$.newVarRef("pstrAttributes",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrScriptType = m$.newVarRef("pstrScriptType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"type='text/javascript'");
    //<< new idUser
    mVar idUser = m$.var("idUser");
    m$.newVar(idUser);
    //<< 
    //<< $$$LogR("StartScript","")
    $$$LogR(m$,"StartScript","");
    //<< 
    //<< if $$$NotInHyperEvent {
    if (mOp.Logical(include.COMSYS.$$$NotInHyperEvent(m$))) {
      //<< set idUser = %session.SessionId
      idUser.set(m$.getSession().getSessionId());
      //<< if ($increment(^CacheTempScriptTag(idUser,$job)) = 1) { ; (idUser = "") ||
      if ((mOp.Equal(m$.Fnc.$increment(m$.var("^CacheTempScriptTag",idUser.get(),m$.Fnc.$job())),1))) {
        //<< $$$LogRx("script:"_pstrAttributes)
        $$$LogRx(m$,mOp.Concat("script:",pstrAttributes.get()));
        //<< write "<script "_$select(pstrAttributes'="":pstrAttributes_" ",1:"")_pstrScriptType_"><!--"_$$$CRLF
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<script ",m$.Fnc.$select(mOp.NotEqual(pstrAttributes.get(),""),mOp.Concat(pstrAttributes.get()," "),1,"")),pstrScriptType.get()),"><!--"),include.COMSYSString.$$$CRLF(m$)));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Write out an HTML end of script tag only if it is required.
  //<< ;
  //<< ; Params:
  //<< ;
  //<< ; ByRefs:
  //<< ;
  //<< ; Returns:
  //<< ;
  //<< ; History:
  //<< ; 13-Dec-2006   JW&SH   SR15311: Switched condition.  '$$$InHyperEvent is incorrect.
  //<< ; 20-Jun-2006   RPW     SRBR014013: Check for %session existing
  //<< ; 23-May-2006   PO      SR14665: Created
  //<< ;-------------------------------------------------------------------------------
  //<< EndScript()
  public Object EndScript(Object ... _p) {
    //<< new idUser
    mVar idUser = m$.var("idUser");
    m$.newVar(idUser);
    //<< 
    //<< $$$LogR("EndScript","")
    $$$LogR(m$,"EndScript","");
    //<< 
    //<< if $$$NotInHyperEvent {
    if (mOp.Logical(include.COMSYS.$$$NotInHyperEvent(m$))) {
      //<< set idUser = %session.SessionId
      idUser.set(m$.getSession().getSessionId());
      //<< if ($increment(^CacheTempScriptTag(idUser,$job),-1) = 0) { ; (idUser = "") ||
      if ((mOp.Equal(m$.Fnc.$increment(m$.var("^CacheTempScriptTag",idUser.get(),m$.Fnc.$job()),mOp.Negative(1)),0))) {
        //<< write $$$CRLF_"//--></script>"
        m$.Cmd.Write(mOp.Concat(include.COMSYSString.$$$CRLF(m$),"//--></script>"));
        //<< kill ^CacheTempScriptTag(idUser,$job)
        m$.var("^CacheTempScriptTag",idUser.get(),m$.Fnc.$job()).kill();
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Alert(str)
  public Object Alert(Object ... _p) {
    mVar str = m$.newVarRef("str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Utility that displays an Alert msg on the front end.
    //<< ;
    //<< ; History:
    //<< ; 04-May-2004   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< set str = ##class(%CSP.Page).QuoteJS(str)
    str.set(mLibrary.mPage.QuoteJS(str.get()));
    //<< &js<
    //<< alert("<%=str%>");
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("        alert(\"<%=str%>\");","\n");
    m$.Cmd.WriteJS("    ");
    //<< quit
    return null;
  }

//<< 
}
