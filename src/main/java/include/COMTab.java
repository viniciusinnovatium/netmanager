//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMTab
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:12:36
//*****************************************************************************

package include;

import mLibrary.*;


//<< #; COMTab.inc
//<< 
public class COMTab extends mInclude {

  //<< #define START       $$$START1
  public static Object $$$START(mContext m$) {
    return ($$$START1(m$));
  }

  //<< #define START1      WRITE YCR,"<TABLE BORDER=1 CELLSPACING=0" DO FARBE^WWWTAB WRITE ">"
  public static Object $$$START1(mContext m$) {
    m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=1 CELLSPACING=0");
    m$.Cmd.Do("WWWTAB.FARBE");
    m$.Cmd.Write(">");
    return null;
  }

  //<< 
  //<< #define NLWWWTAB    SET:$GET(YDDSATZ)'="" YDDSATZ=$GET(YDDSATZ)+1 WRITE "<TR>"
  public static Object $$$NLWWWTAB(mContext m$) {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDDSATZ")),"")) {
      m$.var("YDDSATZ").set(mOp.Add(m$.Fnc.$get(m$.var("YDDSATZ")),1));
    }
    m$.Cmd.Write("<TR>");
    return null;
  }

}
