//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWUSERAGENT
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:58
//*****************************************************************************

import mLibrary.*;


//<< WWWUSERAGENT(YUSERAGENT)
public class WWWUSERAGENT extends mClass {

  public Object main(Object ... _p) {
    mVar YUSERAGENT = m$.newVarRef("YUSERAGENT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWUSERAGENT(YUSERAGENT);
  }

  public Object _WWWUSERAGENT(Object ... _p) {
    mVar YUSERAGENT = m$.newVarRef("YUSERAGENT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       BESTIMMEN BROWSER VERSION
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
    //<< ; 21-Apr-2010   shobby  SR17253: Support CHROME
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 25.11.2004    FIS
    //<< ;-------------------------------------------------------------------------------
    //<< ;IN:  Beispiel:
    //<< ;     Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)
    //<< ;     Mozilla 4.0 ; Gecko; Firefox
    //<< ;OUT:
    //<< ;     MSIE  = Internet Explorer
    //<< ;     GECKO = Firefox / Mozilla
    //<< ;     OPERA = Opera Browser
    //<< ;
    //<< ;---------------------------------------
    //<< ; Note : On MSIE 8 on Windows XP
    //<< ;   Tools >> Compatibility View Setting >> [] Display intranet/all sites in Compatibility View
    //<< ;      If ticked, "HTTP_USER_AGENT" returns -
    //<< ;          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0)"
    //<< ;
    //<< ;      If not ticked, returns -
    //<< ;          "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0)"
    //<< ;
    //<< ;      For current comparison (Mar 2011) FF returned -
    //<< ;          "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-GB; rv:1.9.2.15) Gecko/20110303 Firefox/3.6.15"
    //<< ;
    //<< ;      Using MSIE 7 on Windows Server 2003 returned -
    //<< ;          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.2; .NET CLR 1.1.4322)"
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< if $get(YUSER)'="" if $piece($get(^WWWUSER(0,YUSER,1)),Y,35)'="" do  quit YUSERAGENT
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),m$.var("Y").get(),35),"")) {
        //<< . set YUSERAGENT = $piece($get(^WWWUSER(0,YUSER,1)),Y,35)
        YUSERAGENT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),m$.var("Y").get(),35));
        return YUSERAGENT.get();
      }
    }
    //<< 
    //<< if $get(YUSERAGENT)="" set YUSERAGENT = $get(%CGIEVAR("HTTP_USER_AGENT"))
    if (mOp.Equal(m$.Fnc.$get(YUSERAGENT),"")) {
      YUSERAGENT.set(m$.Fnc.$get(m$.var("%CGIEVAR","HTTP_USER_AGENT")));
    }
    //<< 
    //<< if YUSERAGENT'="" do
    if (mOp.NotEqual(YUSERAGENT.get(),"")) {
      do {
        //<< . set YUSERAGENT=$zconvert(YUSERAGENT,"U")
        YUSERAGENT.set(m$.Fnc.$zconvert(YUSERAGENT.get(),"U"));
        //<< . if $find(YUSERAGENT,"CHROME")   set YUSERAGENT="CHROME" quit      ;SR17253
        if (mOp.Logical(m$.Fnc.$find(YUSERAGENT.get(),"CHROME"))) {
          YUSERAGENT.set("CHROME");
          break;
        }
        //<< . if $find(YUSERAGENT,"NETSCAPE") set YUSERAGENT="GECKO"  quit
        if (mOp.Logical(m$.Fnc.$find(YUSERAGENT.get(),"NETSCAPE"))) {
          YUSERAGENT.set("GECKO");
          break;
        }
        //<< . if $find(YUSERAGENT,"GECKO")    set YUSERAGENT="GECKO"  quit
        if (mOp.Logical(m$.Fnc.$find(YUSERAGENT.get(),"GECKO"))) {
          YUSERAGENT.set("GECKO");
          break;
        }
        //<< . if $find(YUSERAGENT,"FIREFOX")  set YUSERAGENT="GECKO"  quit
        if (mOp.Logical(m$.Fnc.$find(YUSERAGENT.get(),"FIREFOX"))) {
          YUSERAGENT.set("GECKO");
          break;
        }
        //<< . if $find(YUSERAGENT,"MSIE")     set YUSERAGENT="MSIE"   quit
        if (mOp.Logical(m$.Fnc.$find(YUSERAGENT.get(),"MSIE"))) {
          YUSERAGENT.set("MSIE");
          break;
        }
        //<< . if $find(YUSERAGENT,"OPERA")    set YUSERAGENT="OPERA"  quit
        if (mOp.Logical(m$.Fnc.$find(YUSERAGENT.get(),"OPERA"))) {
          YUSERAGENT.set("OPERA");
          break;
        }
        //<< . set YUSERAGENT=""
        YUSERAGENT.set("");
      } while (false);
    }
    //<< 
    //<< if YUSERAGENT="" set YUSERAGENT="MSIE"  ; Default
    if (mOp.Equal(YUSERAGENT.get(),"")) {
      YUSERAGENT.set("MSIE");
    }
    //<< quit YUSERAGENT
    return YUSERAGENT.get();
  }

  //<< 
  //<< 
  //<< SET(pYUSERAGENT)
  public Object SET(Object ... _p) {
    mVar pYUSERAGENT = m$.newVarRef("pYUSERAGENT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Common place to set the YUSERAGENT variable (to track down why it sometimes
    //<< ;   had incorrect values)
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Aug-2010   shobby  SR17488: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set YUSERAGENT = pYUSERAGENT
    mVar YUSERAGENT = m$.var("YUSERAGENT");
    YUSERAGENT.set(pYUSERAGENT.get());
    //<< if YUSERAGENT="" set YUSERAGENT = "MSIE"
    if (mOp.Equal(YUSERAGENT.get(),"")) {
      YUSERAGENT.set("MSIE");
    }
    //<< quit
    return null;
  }

//<< 
//<< 
}
