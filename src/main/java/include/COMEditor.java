//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMEditor
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:12:36
//*****************************************************************************

package include;

import mLibrary.*;


//<< #; COMEditor.INC
//<< 
public class COMEditor extends mInclude {

  //<< #define ReplaceYGIF(%1)     $$Replace^COMUtilStr(%1,"src=""{YGIF}","src="""_YGIF)
  public static Object $$$ReplaceYGIF(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMUtilStr.Replace",p$1.get(),"src=\"{YGIF}",mOp.Concat("src=\"",m$.var("YGIF").get())));
  }

}
