//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUtilIndex
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:10
//*****************************************************************************

import mLibrary.*;


//<< COMUtilIndex
public class COMUtilIndex extends mClass {

  public void main() {
    _COMUtilIndex();
  }

  public void _COMUtilIndex() {
  }

  //<< 
  //<< Index(pstrVal="")
  public Object Index(Object ... _p) {
    mVar pstrVal = m$.newVarRef("pstrVal",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert Value to @NM Index
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-May-2011   shobby  SR17754: Reduced the number of global hits.
    //<< ; 08-May-2008   shobby  SRBR014941: Moved from COMUtils (Runs much faster in a small routine)
    //<< ; 06-Feb-2007   Steve S SR15423: (Peer Review) Conform to coding standards
    //<< ; 02-Feb-2007   RPW     SR15423: Use 254 instead of 255 for subscript length.
    //<< ; 27-May-2005   RobertW SR12056: Use $get instead of $data, we know the node we want.
    //<< ; 17-Feb-2004   SCR     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strIndex
    mVar strIndex = m$.var("strIndex");
    m$.newVar(strIndex);
    //<< 
    //<< quit:+pstrVal=pstrVal pstrVal
    if (mOp.Equal(mOp.Positive(pstrVal.get()),pstrVal.get())) {
      return pstrVal.get();
    }
    //<< 
    //<< if pstrVal="" set pstrVal = " "
    if (mOp.Equal(pstrVal.get(),"")) {
      pstrVal.set(" ");
    }
    //<< 
    //<< if $length(pstrVal)>254 set pstrVal = $extract(pstrVal,1,254)
    if (mOp.Greater(m$.Fnc.$length(pstrVal.get()),254)) {
      pstrVal.set(m$.Fnc.$extract(pstrVal.get(),1,254));
    }
    //<< 
    //<< set strIndex = $get(^CacheTempIndex(pstrVal))
    strIndex.set(m$.Fnc.$get(m$.var("^CacheTempIndex",pstrVal.get())));
    //<< if $get(strIndex)="" {
    if (mOp.Equal(m$.Fnc.$get(strIndex),"")) {
      //<< set strIndex = $$^WWWUMLAU(pstrVal,1)
      strIndex.set(m$.fnc$("WWWUMLAU.main",pstrVal.get(),1));
      //<< set ^CacheTempIndex(pstrVal)=strIndex
      m$.var("^CacheTempIndex",pstrVal.get()).set(strIndex.get());
    }
    //<< }
    //<< quit strIndex
    return strIndex.get();
  }

//<< 
//<< 
}
