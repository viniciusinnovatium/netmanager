//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWIMAGE
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:50
//*****************************************************************************

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

//<< WWWIMAGE
public class WWWIMAGE extends mClass {

  public void main() {
    _WWWIMAGE();
  }

  public void _WWWIMAGE() {
  }

  //<< 
  //<< Name(pstrImage,pblnDisabled=$$$NO)
  public Object Name(Object ... _p) {
    mVar pstrImage = m$.newVarRef("pstrImage",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnDisabled = m$.newVarRef("pblnDisabled",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Standard method to change an image to it's disabled counterpart.
    //<< ; Limited to images that we know exist.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-May-2013   shobby  CORE-79.7: Remove previous change.
    //<< ; 13-May-2013   shobby  CORE-79.2: Disable FATSearch button
    //<< ; 04-Jul-2007   RPW     SRBR014409: Use variable
    //<< ; 26-Jun-2007   shobby      SRBR014409: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strImage
    mVar strImage = m$.var("strImage");
    m$.newVar(strImage);
    //<< 
    //<< set strImage=$piece(pstrImage,".",1)
    strImage.set(m$.Fnc.$piece(pstrImage.get(),".",1));
    //<< 
    //<< if pblnDisabled {
    if (mOp.Logical(pblnDisabled.get())) {
      //<< if ($length(strImage)=1)
      //<< ||(pstrImage="date.gif")
      //<< ||(pstrImage="text.gif")
      //<< ||(pstrImage="search1.gif")
      //<< ||(pstrImage="searchtree.gif") {
      if ((mOp.Equal(m$.Fnc.$length(strImage.get()),1)) || (mOp.Equal(pstrImage.get(),"date.gif")) || (mOp.Equal(pstrImage.get(),"text.gif")) || (mOp.Equal(pstrImage.get(),"search1.gif")) || (mOp.Equal(pstrImage.get(),"searchtree.gif"))) {
        //<< set pstrImage=strImage_"_dis."_$piece(pstrImage,".",2)
        pstrImage.set(mOp.Concat(mOp.Concat(strImage.get(),"_dis."),m$.Fnc.$piece(pstrImage.get(),".",2)));
      }
    }
    //<< }
    //<< }
    //<< quit pstrImage
    return pstrImage.get();
  }

//<< 
}
