//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWKEYBUILD
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:08
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

//<< WWWKEYBUILD(pstrKey)
public class WWWKEYBUILD extends mClass {

  public Object main(Object ... _p) {
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWKEYBUILD(pstrKey);
  }

  public Object _WWWKEYBUILD(Object ... _p) {
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       BUILD KEY FOR GLOBAL REFERENCE
    //<< ;
    //<< ; Inputs :
    //<< ;   pstrKey     Comma-delimited keys for global reference
    //<< ;
    //<< ; Returns :
    //<< ;   String keys have double quotes added around them
    //<< ;
    //<< ; History :
    //<< ; 03-Jun-2008   GRF     Doco
    //<< ; 03-May-2007   RPW     Rewrite
    //<< ; 10-May-2006   JW      SR14508: Combine both checks (can get MAXNUM error)
    //<< ; 07-May-2005   JW      SR12061: Numbers such as 000123 need to be "000123"
    //<< ; 14.06.2004    FIS     Original created
    //<< ;-------------------------------------------------------------------------------
    //<< new loop,strKeyPiece,strKey
    mVar loop = m$.var("loop");
    mVar strKeyPiece = m$.var("strKeyPiece");
    mVar strKey = m$.var("strKey");
    m$.newVar(loop,strKeyPiece,strKey);
    //<< 
    //<< quit:$get(pstrKey)=""
    if (mOp.Equal(m$.Fnc.$get(pstrKey),"")) {
      return null;
    }
    //<< 
    //<< set strKey=""
    strKey.set("");
    //<< 
    //<< for loop=1:1 {
    for (loop.set(1);(true);loop.set(mOp.Add(loop.get(),1))) {
      //<< quit:$piece(pstrKey,$$$COMMA,loop,99)=""
      if (mOp.Equal(m$.Fnc.$piece(pstrKey.get(),include.COMSYSString.$$$COMMA(m$),loop.get(),99),"")) {
        break;
      }
      //<< 
      //<< set strKeyPiece=$piece(pstrKey,$$$COMMA,loop)
      strKeyPiece.set(m$.Fnc.$piece(pstrKey.get(),include.COMSYSString.$$$COMMA(m$),loop.get()));
      //<< if (strKeyPiece'=+strKeyPiece) || ($translate(strKeyPiece,"1234567890.-")'="") {
      if ((mOp.NotEqual(strKeyPiece.get(),mOp.Positive(strKeyPiece.get()))) || (mOp.NotEqual(m$.Fnc.$translate(strKeyPiece.get(),"1234567890.-"),""))) {
        //<< if '(($extract(strKeyPiece)=$$$DBLQUOTE) && ($extract($reverse(strKeyPiece))=$$$DBLQUOTE)) {
        if (mOp.Not(((mOp.Equal(m$.Fnc.$extract(strKeyPiece.get()),include.COMSYSString.$$$DBLQUOTE(m$))) && (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(strKeyPiece.get())),include.COMSYSString.$$$DBLQUOTE(m$)))))) {
          //<< set strKeyPiece=$$$DBLQUOTE_strKeyPiece_$$$DBLQUOTE
          strKeyPiece.set(mOp.Concat(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),strKeyPiece.get()),include.COMSYSString.$$$DBLQUOTE(m$)));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if strKey'="" set strKey=strKey_","
      if (mOp.NotEqual(strKey.get(),"")) {
        strKey.set(mOp.Concat(strKey.get(),","));
      }
      //<< set strKey=strKey_strKeyPiece
      strKey.set(mOp.Concat(strKey.get(),strKeyPiece.get()));
    }
    //<< }
    //<< 
    //<< quit strKey
    return strKey.get();
  }

//<< 
//<< /*
//<< OLDWWWKEYBUILD(YKEY)    ;WWWKEYBUILD;FIS;BUILD KEY FOR GLOBAL REFERENCE;14.06.2004
//<< 
//<< ;
//<< //EXAMPLE: A123,100,"TEST",14"  --> "A123",100,"TEST","14""
//<< NEW YI,YYKEY,YYDATEI,YYM,YMAXKEY
//<< SET YKEY=$GET(YKEY)
//<< QUIT:YKEY="" ""
//<< SET YYKEY(0)=""
//<< FOR YI=1:1  QUIT:$PIECE(YKEY,",",YI,99)=""  SET YYKEY(1)=$PIECE(YKEY,",",YI) DO
//<< . ;IF $TRANSLATE(YYKEY(1),"1234567890")'="" DO
//<< . ;IF YYKEY(1)'=+YYKEY(1) DO  // JW SR12061
//<< . IF ($TRANSLATE(YYKEY(1),"1234567890.-")'="") || (YYKEY(1)'=+YYKEY(1)) DO  // JW SR14508
//<< . . IF $EXTRACT(YYKEY(1))="""" IF $EXTRACT($REVERSE(YYKEY(1)))="""" QUIT
//<< . . SET YYKEY(1)=""""_YYKEY(1)_""""
//<< .
//<< . IF YYKEY(0)'="" SET YYKEY(0)=YYKEY(0)_","
//<< . SET YYKEY(0)=YYKEY(0)_YYKEY(1)
//<< 
//<< SET YKEY=YYKEY(0)
//<< QUIT YKEY
//<< 
//<< */
//<< 
}
