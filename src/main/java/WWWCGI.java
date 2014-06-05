//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWCGI
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:16
//*****************************************************************************

import mLibrary.*;

//<< 
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

//<< WWWCGI
public class WWWCGI extends mClass {

  public void main() {
    _WWWCGI();
  }

  public void _WWWCGI() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANSETZEN CGI VARIABLEN
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 20-Oct-2008   FIS     SR15824: set YLOCKKILL to force lock kill at form load
    //<< ;                           when called from menu
    //<< ; 18-Apr-2006   shobby  SRBR014016: Merged WWWCGI2 and WWWCGI
    //<< ; 10-Nov-2005   JW      SR11904:    Child user for popups
    //<< ; 22-Sep-2005   RPW     SR13306:    Cleaned error prone code, copied to OBSWWWCGI
    //<< ; 30.10.1999    DT
    //<< ;-------------------------------------------------------------------------------
    //<< write $$WWWCGI2($get(blnPOPUP))
    m$.Cmd.Write(m$.fnc$("WWWCGI2",m$.Fnc.$get(m$.var("blnPOPUP"))));
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< FormURL(pstrForm,pstrKey="",pstrExtra="",pblnPopup=$$$NO)
  public Object FormURL(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrExtra = m$.newVarRef("pstrExtra",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnPopup = m$.newVarRef("pblnPopup",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper to new YKEY, pass in new form
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Oct-2006   JW      BR014262: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YKEY,strHTML
    mVar YKEY = m$.var("YKEY");
    mVar strHTML = m$.var("strHTML");
    m$.newVar(YKEY,strHTML);
    //<< 
    //<< if $get(pstrForm)="" set pstrForm = YFORM
    if (mOp.Equal(m$.Fnc.$get(pstrForm),"")) {
      pstrForm.set(m$.var("YFORM").get());
    }
    //<< set YKEY = pstrKey
    YKEY.set(pstrKey.get());
    //<< 
    //<< set strHTML = YAKTION_"EP=WWWFORM&amp;YFORM="_pstrForm_pstrExtra_$$WWWCGI2(pblnPopup)
    strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),pstrForm.get()),pstrExtra.get()),m$.fnc$("WWWCGI2",pblnPopup.get())));
    //<< quit strHTML
    return strHTML.get();
  }

  //<< 
  //<< 
  //<< WWWCGI2(pblnPopup=$$$NO) ;WWWCGI;DT;ANSETZEN CGI VARIABLEN;30.10.1999
  public Object WWWCGI2(Object ... _p) {
    mVar pblnPopup = m$.newVarRef("pblnPopup",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANSETZEN CGI VARIABLEN
    //<< ;
    //<< ;   LINK BEISPIEL:
    //<< ;     write "<A HREF="_""""_YAKTION_"EP=WWWFORM&YFORM=FORM&YKEY="_KEY
    //<< ;     do ^WWWCGI           ; or write $$WWWCGI2^WWWCGI($get(blnPOPUP))
    //<< ;     write """"_">"
    //<< ;     write strLink
    //<< ;     write "</A>"
    //<< ;
    //<< ;   ANHAENGEN STANDARD VARIABLEN
    //<< ;   "|" = HILFSVARIABLE BEI NETSCAPE
    //<< ;
    //<< ; Params:   pblnPopup - whether going to a pop up form
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 11-Feb-2011   GRF     SR17659: Replace double quote characters in parameter
    //<< ;                           string with corresponding HTML substring (&#34;)
    //<< ; 20-Aug-2009   GRF     SR16851: translated single quotes in VAR as well
    //<< ; 20-Aug-2009   DWR     SR16851: added ' to translate string, was causing
    //<< ;                           errors with writing the link to the screen for popup
    //<< ;                           windows using the value as a key.
    //<< ; 17-Oct-2008   GRF     $get(YANZ) not $get(YINZ) test in VAR
    //<< ; 21-Dec-2006   JW      SR14235:  Changed floating blnPOPUP to param pblnPopup
    //<< ; 11-Jul-2006   GRF     Doco
    //<< ; 18-Apr-2006   shobby  SRBR014016: Included support for Popup windows.
    //<< ; 08-Aug-2005   shobby  Equivalent of WWWCGI but doesn't write directly to the
    //<< ;                           screen.
    //<< ; 30.10.1999    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHTML);
    //<< ;if YBED["SHOBBY" if $get(YPARA)'="" for l=1:1:100 hang 1
    //<< set strHTML = ""
    strHTML.set("");
    //<< if $get(YUCI)'=""           set strHTML=strHTML_"&amp;YUCI="_YUCI  ; Namespace
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUCI")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YUCI="),m$.var("YUCI").get()));
    }
    //<< if $get(YBED)'=""           set strHTML=strHTML_"&amp;YBED="_YBED  ; User ID
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YBED="),m$.var("YBED").get()));
    }
    //<< if $get(YM)'=""             set strHTML=strHTML_"&amp;YM="_YM      ; Company
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YM")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YM="),m$.var("YM").get()));
    }
    //<< if $get(YUSER)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      //<< set strHTML = strHTML_"&amp;YUSER="_$select(pblnPopup:$$GetChildUser^WWWUSER(YUSER),1:YUSER)
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YUSER="),m$.Fnc.$select(pblnPopup.get(),m$.fnc$("WWWUSER.GetChildUser",m$.var("YUSER").get()),1,m$.var("YUSER").get())));
    }
    //<< }
    //<< if $get(YTRAKT)'=""         set strHTML=strHTML_"&amp;YTRAKT="_YTRAKT     ;TRANSAKTIONSNUMMER
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTRAKT")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YTRAKT="),m$.var("YTRAKT").get()));
    }
    //<< if $get(YPARA)'=""          set strHTML=strHTML_"&amp;YPARA="_YPARA       ;PARAMETER
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YPARA")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YPARA="),m$.var("YPARA").get()));
    }
    //<< if $get(YAENBER)'=""        set strHTML=strHTML_"&amp;YAENBER="_YAENBER   ;PARAMETER ÄNDERUNGSBERECHTIGUNG;DES FORMULARS
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YAENBER")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YAENBER="),m$.var("YAENBER").get()));
    }
    //<< if $get(YBACK)'=""          set strHTML=strHTML_"&amp;YBACK="_YBACK       ;RÜCKSPRUNG
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBACK")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YBACK="),m$.var("YBACK").get()));
    }
    //<< if $get(YKEY)'=""           set strHTML=strHTML_"&amp;YKEY="_$translate(YKEY,"# '"_"""","~|")    ;SCHLÜSSEL ;key
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YKEY="),m$.Fnc.$translate(m$.var("YKEY").get(),mOp.Concat("# '","\""),"~|")));
    }
    //<< if $get(YKEY1)'=""          set strHTML=strHTML_"&amp;YKEY1="_$translate(YKEY1," '"_"""","|")    ;SCHLÜSSEL1 FÜR LÖSCHEN UND SPEICHERN ;to Delete And Save
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY1")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YKEY1="),m$.Fnc.$translate(m$.var("YKEY1").get(),mOp.Concat(" '","\""),"|")));
    }
    //<< if $get(YFKEY)'=""          set strHTML=strHTML_"&amp;YFKEY="_$translate(YFKEY,"# '"_"""","~|")  ;FIX KEYS
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFKEY")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YFKEY="),m$.Fnc.$translate(m$.var("YFKEY").get(),mOp.Concat("# '","\""),"~|")));
    }
    //<< if $get(YANZ)'=""           set strHTML=strHTML_"&amp;YANZ="_YANZ                                ;ANZEIGE AUS MENU ;Show out of
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YANZ")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YANZ="),m$.var("YANZ").get()));
    }
    //<< if $get(YOPTION)'=""        set strHTML=strHTML_"&amp;YOPTION="_YOPTION                          ;OPTIONEN
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YOPTION")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YOPTION="),m$.var("YOPTION").get()));
    }
    //<< if $get(YNAME)'=""          set strHTML=strHTML_"&amp;YNAME="_$translate(YNAME," ","_")          ;NAME DES FORMS
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YNAME")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YNAME="),m$.Fnc.$translate(m$.var("YNAME").get()," ","_")));
    }
    //<< if $get(YSIZE)'=""          set strHTML=strHTML_"&amp;YSIZE="_YSIZE                              ;gRÖßE
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YSIZE")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YSIZE="),m$.var("YSIZE").get()));
    }
    //<< if $get(YKILL)'=""          set strHTML=strHTML_"&amp;YKILL="_YKILL                ;LÖSCHMERKER
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKILL")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YKILL="),m$.var("YKILL").get()));
    }
    //<< if $get(YBUTTON)'=""        set strHTML=strHTML_"&amp;YBUTTON="_YBUTTON            ;LETZTER BUTTON ;last
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBUTTON")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YBUTTON="),m$.var("YBUTTON").get()));
    }
    //<< if $get(YNUMMER)'=""        set strHTML=strHTML_"&amp;YNUMMER="_YNUMMER            ;LETZTE LFD NUMMMER (FÜR RÜCKSPRUNG) ;last
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YNUMMER")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YNUMMER="),m$.var("YNUMMER").get()));
    }
    //<< if $get(YSCREENM)'=""       set strHTML=strHTML_"&amp;YSCREENM="_+YSCREENM         ;TEST KENNZEICHEN ;Test characteristic
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YSCREENM")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YSCREENM="),mOp.Positive(m$.var("YSCREENM").get())));
    }
    //<< if $get(YUSERPROFILE)'=""   set strHTML=strHTML_"&amp;YUSERPROFILE="_YUSERPROFILE  ;SCREEN FOR USER ;Test
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSERPROFILE")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YUSERPROFILE="),m$.var("YUSERPROFILE").get()));
    }
    //<< if $get(YPRINT)'=""         set strHTML=strHTML_"&amp;YPRINT="_YPRINT              ;ZIEL WIRD GEDRUCKT ;target
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YPRINT")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YPRINT="),m$.var("YPRINT").get()));
    }
    //<< if $get(YNOKEY)'=""         set strHTML=strHTML_"&amp;YNOKEY="_YNOKEY              ;FORMS, DIE BEI RÜCKSPRUNG KEINEN KEY ERHALTEN
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YNOKEY")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YNOKEY="),m$.var("YNOKEY").get()));
    }
    //<< if $get(YASTART)'=""        set strHTML=strHTML_"&amp;YLOCKKILL="_YASTART          ; set YLOCKKILL to force lock kill at form load when called from menu
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YASTART")),"")) {
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"&amp;YLOCKKILL="),m$.var("YASTART").get()));
    }
    //<< 
    //<< set strHTML = $$FullReplace^COMUtilStr(strHTML,$$$DBLQUOTE,"&#34;")          ; SR17659
    strHTML.set(m$.fnc$("COMUtilStr.FullReplace",strHTML.get(),include.COMSYSString.$$$DBLQUOTE(m$),"&#34;"));
    //<< quit strHTML
    return strHTML.get();
  }

  //<< 
  //<< 
  //<< VAR ;SPEICHERN IN YI ;Save within     ; ´'`   ´´´
  public void VAR() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add parameter string to ByRef YI string.
    //<< ;
    //<< ; History:
    //<< ; 11-Feb-2011   GRF     SR17659: Maintain single construct.  Only difference was
    //<< ;                           to add YUSERPROFILE which does not appear to have
    //<< ;                           been fully implemented and if required would be
    //<< ;                           needed in the YI string anyway.
    //<< ;-------------------------------------------------------------------------------
    //<< set YI=$get(YI)_$$WWWCGI2($$$NO)
    mVar YI = m$.var("YI");
    YI.set(mOp.Concat(m$.Fnc.$get(m$.var("YI")),m$.fnc$("WWWCGI2",include.COMSYS.$$$NO(m$))));
    //<< quit
    return;
  }

  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< ; SR17659 : Previous version - can remove after review
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< /*
  //<< set YI=$get(YI)
  //<< if $get(YUCI)'=""     set YI=YI_"&amp;YUCI="_YUCI
  //<< if $get(YBED)'=""     set YI=YI_"&amp;YBED="_YBED
  //<< if $get(YM)'=""       set YI=YI_"&amp;YM="_YM
  //<< if $get(YUSER)'=""    set YI=YI_"&amp;YUSER="_YUSER
  //<< if $get(YTRAKT)'=""   set YI=YI_"&amp;YTRAKT="_YTRAKT
  //<< if $get(YPARA)'=""    set YI=YI_"&amp;YPARA="_YPARA
  //<< if $get(YAENBER)'=""  set YI=YI_"&amp;YAENBER="_YAENBER  ;PARAMETER ÄNDERUNGSBERECHTIGUNG;DES FORMULARS
  //<< if $get(YBACK)'=""    set YI=YI_"&amp;YBACK="_YBACK
  //<< if $get(YKEY)'=""     set YI=YI_"&amp;YKEY="_$translate(YKEY," '"_"""","|")
  //<< if $get(YKEY1)'=""    set YI=YI_"&amp;YKEY1="_$translate(YKEY1," '"_"""","|")
  //<< if $get(YFKEY)'=""    set YI=YI_"&amp;YFKEY="_$translate(YFKEY," '"_"""","|")
  //<< if $get(YANZ)'=""     set YI=YI_"&amp;YANZ="_YANZ
  //<< if $get(YOPTION)'=""  set YI=YI_"&amp;YOPTION="_YOPTION
  //<< if $get(YNAME)'=""    set YI=YI_"&amp;YNAME="_$translate(YNAME," ","_")
  //<< if $get(YSIZE)'=""    set YI=YI_"&amp;YSIZE="_YSIZE
  //<< if $get(YKILL)'=""    set YI=YI_"&amp;YKILL="_YKILL
  //<< if $get(YBUTTON)'=""  set YI=YI_"&amp;YBUTTON="_YBUTTON
  //<< if $get(YNUMMER)'=""  set YI=YI_"&amp;YNUMMER="_YNUMMER
  //<< if $get(YSCREENM)'="" set YI=YI_"&amp;YSCREENM="_+YSCREENM
  //<< if $get(YPRINT)'=""   set YI=YI_"&amp;YPRINT="_YPRINT  ;ZIEL WIRD GEDRUCKT ;target
  //<< if $get(YNOKEY)'=""   set YI=YI_"&amp;YNOKEY="_YNOKEY
  //<< if $get(YASTART)'=""  set YI=YI_"&amp;YLOCKKILL="_YASTART          ; pass flag YLOCKKILL
  //<< 
  //<< quit
  //<< */
  //<< 
  //<< VAR1(MANU)    ;ALS RETURN VALUE
  public Object VAR1(Object ... _p) {
    mVar MANU = m$.newVarRef("MANU",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< if $get(MANU)=1 new YFORM,YKEY,YBACK     ;MAUELLER LINK
    if (mOp.Equal(m$.Fnc.$get(MANU),1)) {
      mVar YFORM = m$.var("YFORM");
      mVar YKEY = m$.var("YKEY");
      mVar YBACK = m$.var("YBACK");
      m$.newVar(YFORM,YKEY,YBACK);
    }
    //<< new YI
    mVar YI = m$.var("YI");
    m$.newVar(YI);
    //<< set YI=""
    YI.set("");
    //<< do VAR
    m$.Cmd.Do("VAR");
    //<< quit YI
    return YI.get();
  }

//<< 
}
