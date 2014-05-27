//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMView
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:13:51
//*****************************************************************************

package include;

import mLibrary.*;

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

//<< #; COMView
//<< 
public class COMView extends mInclude {

  //<< 
  //<< #define SQLID   YUSER_"-"_YFORM
  public static Object $$$SQLID(mContext m$) {
    return (mOp.Concat(mOp.Concat(m$.var("YUSER").get(),"-"),m$.var("YFORM").get()));
  }

  //<< 
  //<< #define RowCount        $get(^CacheTempSQL($$$SQLID,"RowCount"))
  public static Object $$$RowCount(mContext m$) {
    return (m$.Fnc.$get(m$.var("^CacheTempSQL",$$$SQLID(m$),"RowCount")));
  }

  //<< #define SetStatus       write "SetStatus('"_$$$Text($listbuild("Com00255",$$$RowCount))_"');",!
  public static Object $$$SetStatus(mContext m$) {
    m$.Cmd.Write(mOp.Concat(mOp.Concat("SetStatus('",include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("Com00255",$$$RowCount(m$)))),"');"),"\n");
    return null;
  }

  //<< #define CallingForm     $get(^CacheTempView(YUSER,"CallingForm"))
  public static Object $$$CallingForm(mContext m$) {
    return (m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallingForm")));
  }

  //<< #define ParentForm      $get(^CacheTempView(YUSER,YUCI,"ParentForm"))
  public static Object $$$ParentForm(mContext m$) {
    return (m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"ParentForm")));
  }

  //<< 
  //<< #define ClearExternalFilter(%1) kill ^CacheTempViewExternal(YUSER,YUCI,%1,"Filter")
  public static Object $$$ClearExternalFilter(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.var("^CacheTempViewExternal",m$.var("YUSER").get(),m$.var("YUCI").get(),p$1.get(),"Filter").kill();
    return null;
  }

}
