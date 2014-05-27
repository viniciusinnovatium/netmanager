//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWLANGU
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:15
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
//<< #include INConst
import include.INConst;
//<< #include WWWConst
import include.WWWConst;

//<< WWWLANGU(YBED)
public class WWWLANGU extends mClass {

  public Object main(Object ... _p) {
    mVar YBED = m$.newVarRef("YBED",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWLANGU(YBED);
  }

  public Object _WWWLANGU(Object ... _p) {
    mVar YBED = m$.newVarRef("YBED",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Returns the user's language code
    //<< ;       Preserve it in %("%KEY") if using Customer/Supplier Login
    //<< ;       SPRACHE DES BEDIENERS
    //<< ;
    //<< ; Inputs :
    //<< ;   YBED
    //<< ;   YUSER
    //<< ;   YM
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;   Language code - this will never be null - defaults to "EN"
    //<< ;
    //<< ; History :
    //<< ; 05-Oct-2006   JW      SR15098: Default to "EN"
    //<< ; 19-Jul-2005   GRF     SR13024: Doco, Macros
    //<< ; 27-May-2005   RobertW SR12056: Attempt at performance increase
    //<< ; 01.08.1997    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW SPRACHE,strLanguage
    mVar SPRACHE = m$.var("SPRACHE");
    mVar strLanguage = m$.var("strLanguage");
    m$.newVar(SPRACHE,strLanguage);
    //<< 
    //<< SET SPRACHE=""
    SPRACHE.set("");
    //<< ;TYBD;10,12,2004 ;IMMER DIE GLEICHE SPRACHE
    //<< ;IF $GET(YUSER)'="" set strLanguage=$piece($get(^WWWUSER(0,YUSER,1)),Y,19) IF strLanguage'="" QUIT strLanguage
    //<< ;IF $GET(YBED)'=""  set SPRACHE=$PIECE($GET(^WWW013(0,YBED,1)),Y,6)
    //<< IF $GET(YUSER)'="" set strLanguage = $$$WWWUSERLanguage1($get(^WWWUSER(0,YUSER,1))) IF strLanguage'="" QUIT strLanguage   ; *** EARLY EXIT ***
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      strLanguage.set(include.WWWConst.$$$WWWUSERLanguage1(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1))));
      if (mOp.NotEqual(strLanguage.get(),"")) {
        return strLanguage.get();
      }
    }
    //<< IF $GET(YBED)'=""  set SPRACHE     = $$$WWW013Language1($get(^WWW013(0,YBED,1)))
    if (mOp.NotEqual(m$.Fnc.$get(YBED),"")) {
      SPRACHE.set(include.WWWConst.$$$WWW013Language1(m$,m$.Fnc.$get(m$.var("^WWW013",0,YBED.get(),1))));
    }
    //<< 
    //<< IF SPRACHE="" {
    if (mOp.Equal(SPRACHE.get(),"")) {
      //<< SET SPRACHE="EN"
      SPRACHE.set("EN");
      //<< IF $GET(YM)="" SET YM=0
      if (mOp.Equal(m$.Fnc.$get(m$.var("YM")),"")) {
        mVar YM = m$.var("YM");
        YM.set(0);
      }
    }
    //<< ;   IF $PIECE($GET(^WWW012(0,YM,1)),Y,75)="EUR" SET SPRACHE="DE"
    //<< //  if $$$WWW012StandardCurrency($get(^WWW012(0,YM,1)))="EUR" SET SPRACHE="DE"  SR15098
    //<< }
    //<< 
    //<< ; Get property saved in ^CacheTempWWWAM
    //<< ;KUNDEN-LOGIN;FIS;08.12.04
    //<< IF $GET(YM)'="" IF $GET(YBED)'="" IF $DATA(^INVORG(YM,YM,1)) IF $$$INVORGCustomerVendorAsUsers($get(^INVORG(YM,YM,1)))=YBED DO
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YM")),"")) {
      if (mOp.NotEqual(m$.Fnc.$get(YBED),"")) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)))) {
          if (mOp.Equal(include.INConst.$$$INVORGCustomerVendorAsUsers(m$,m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1))),YBED.get())) {
            do {
              //<< . SET SPRACHE(1)=$$PROPGET^WWWAMVAR($GET(YUSER),"SPRACHE")
              SPRACHE.var(1).set(m$.fnc$("WWWAMVAR.PROPGET",m$.Fnc.$get(m$.var("YUSER")),"SPRACHE"));
              //<< . IF SPRACHE(1)'=""  SET SPRACHE=SPRACHE(1)  QUIT
              if (mOp.NotEqual(SPRACHE.var(1).get(),"")) {
                SPRACHE.set(SPRACHE.var(1).get());
                break;
              }
              //<< . IF $GET(%("%KEY","SPRACHE"))'="" SET SPRACHE=%("%KEY","SPRACHE")
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("%","%KEY","SPRACHE")),"")) {
                SPRACHE.set(m$.var("%","%KEY","SPRACHE").get());
              }
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< QUIT SPRACHE
    return SPRACHE.get();
  }

//<< 
}
