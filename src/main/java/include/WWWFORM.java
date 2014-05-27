//*****************************************************************************
//** TASC - ALPHALINC - INC include.WWWFORM
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:13:40
//*****************************************************************************

package include;

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

public class WWWFORM extends mInclude {

  //<< 
  //<< #define OpenTD(%blnDis) write $$OpenTD^WWWFORMCOMMON(%blnDis)
  public static Object $$$OpenTD(mContext m$, Object ... _p) {
    mVar p$blnDis = m$.varRef("p$blnDis",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Write(m$.fnc$("WWWFORMCOMMON.OpenTD",p$blnDis.get()));
    return null;
  }

  //<< #define CloseTD         write $$CloseTD^WWWFORMCOMMON()
  public static Object $$$CloseTD(mContext m$) {
    m$.Cmd.Write(m$.fnc$("WWWFORMCOMMON.CloseTD"));
    return null;
  }

  //<< 
  //<< #define OpenOnClick     write " onClick="""_YCONF1
  public static Object $$$OpenOnClick(mContext m$) {
    m$.Cmd.Write(mOp.Concat(" onClick=\"",m$.var("YCONF1").get()));
    return null;
  }

  //<< #define CloseOnClick    write YCONF2_""""
  public static Object $$$CloseOnClick(mContext m$) {
    m$.Cmd.Write(mOp.Concat(m$.var("YCONF2").get(),"\""));
    return null;
  }

  //<< 
  //<< #define StartWindow     write $select(YTARGETF="":" window.location='",1:" subWindow('")
  public static Object $$$StartWindow(mContext m$) {
    m$.Cmd.Write(m$.Fnc.$select(mOp.Equal(m$.var("YTARGETF").get(),"")," window.location='",1," subWindow('"));
    return null;
  }

  //<< #define EndWindow       write $select(YTARGETF="":"' ",1:"','"_YTARGETF_"') ")
  public static Object $$$EndWindow(mContext m$) {
    m$.Cmd.Write(m$.Fnc.$select(mOp.Equal(m$.var("YTARGETF").get(),""),"' ",1,mOp.Concat(mOp.Concat("','",m$.var("YTARGETF").get()),"') ")));
    return null;
  }

//<< 
//<< 
}
