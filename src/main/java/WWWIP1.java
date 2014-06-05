//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWIP1
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:02
//*****************************************************************************

import mLibrary.*;


//<< WWWIP1(pstrIPAddress)
public class WWWIP1 extends mClass {

  public Object main(Object ... _p) {
    mVar pstrIPAddress = m$.newVarRef("pstrIPAddress",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWIP1(pstrIPAddress);
  }

  public Object _WWWIP1(Object ... _p) {
    mVar pstrIPAddress = m$.newVarRef("pstrIPAddress",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Format IP address             FORMAT AUSGABE
    //<< ;       n.n.n.n => ddd.ddd.ddd.ddd (numbers to three digits with leading zeros)
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 05-Mar-2007   RPW     SR15408: Rewrote as clean code
    //<< ;               DT      format expenses
    //<< ;-------------------------------------------------------------------------------
    //<< new intLoop,strIPAddress,intOctet
    mVar intLoop = m$.var("intLoop");
    mVar strIPAddress = m$.var("strIPAddress");
    mVar intOctet = m$.var("intOctet");
    m$.newVar(intLoop,strIPAddress,intOctet);
    //<< 
    //<< if pstrIPAddress="" set strIPAddress="" quit strIPAddress ;KEINE IP ;no IP
    if (mOp.Equal(pstrIPAddress.get(),"")) {
      strIPAddress.set("");
      return strIPAddress.get();
    }
    //<< 
    //<< set strIPAddress="..."
    strIPAddress.set("...");
    //<< for intLoop=1:1:4 {
    for (intLoop.set(1);(mOp.LessOrEqual(intLoop.get(),4));intLoop.set(mOp.Add(intLoop.get(),1))) {
      //<< set intOctet = +$piece(pstrIPAddress,".",intLoop)
      intOctet.set(mOp.Positive(m$.Fnc.$piece(pstrIPAddress.get(),".",intLoop.get())));
      //<< set $piece(strIPAddress,".",intLoop) = $extract(1000+$select(intOctet<0:0, intOctet>255:255, 1:intOctet),2,4)
      m$.pieceVar(strIPAddress,".",intLoop.get()).set(m$.Fnc.$extract(mOp.Add(1000,m$.Fnc.$select(mOp.Less(intOctet.get(),0),0,mOp.Greater(intOctet.get(),255),255,1,intOctet.get())),2,4));
    }
    //<< }
    //<< 
    //<< quit strIPAddress
    return strIPAddress.get();
  }

//<< 
}
