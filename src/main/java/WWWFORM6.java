//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM6
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:17
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
//<< #include WWWConst
import include.WWWConst;

//<< WWWFORM6
public class WWWFORM6 extends mClass {

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogRx(%1)       ;
  public static Object $$$LogRx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogRm(%1)       ;
  public static Object $$$LogRm(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _WWWFORM6();
  }

  public void _WWWFORM6() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORM6("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SEITENPARAMETER
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 29-Jun-2012   shobby  SR18046: New tabs
    //<< ; 30-Jul-2008   GRF     SR15822: Remove older commented code
    //<< ; 10-Jul-2007   GRF     Doco; quits; disabled block
    //<< ; 25-Jun-2006   shobby  SRBR014072: Consider customisations with tabs.
    //<< ; 20-Feb-2006   JW      SR14134: Don't stop when hole in page numbers
    //<< ; 01-Feb-2006   RPW     SR14094: Display the tabs in the correct Display Order
    //<< ;                           not the tab order. Retain the correct YSEITE.
    //<< ;                           DEV sees YSEITE in the tooltip.
    //<< ; 22-Dec-2005   JW      SR13195: Call generic ChangeTabs function
    //<< ; 05.08.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new YLFN,YXS,YRLANG,YREITER
    mVar YLFN = m$.var("YLFN");
    mVar YXS = m$.var("YXS");
    mVar YRLANG = m$.var("YRLANG");
    mVar YREITER = m$.var("YREITER");
    m$.newVar(YLFN,YXS,YRLANG,YREITER);
    //<< if +$$$WWW013TabStyle($get(^WWW013(0,YBED,1))) do ^WWWFORM6NEW quit
    if (mOp.Logical(mOp.Positive(include.WWWConst.$$$WWW013TabStyle(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)))))) {
      m$.Cmd.Do("WWWFORM6NEW.main");
      return;
    }
    //<< if $get(YINPAGE)'=1 do MAIN
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YINPAGE")),1)) {
      m$.Cmd.Do("MAIN");
    }
    //<< if $get(YINPAGE)=1  do INPAGE
    if (mOp.Equal(m$.Fnc.$get(m$.var("YINPAGE")),1)) {
      m$.Cmd.Do("INPAGE");
    }
    //<< quit
    return;
  }

  //<< 
  //<< MAIN
  public void MAIN() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Tabs          ; HAUPT SEITE
    //<< ;
    //<< ; History:
    //<< ; 29-Jun-2012   shobby  SR18046: Removed some redundant code.
    //<< ; 25-Oct-2006   RPW     SRBR014072: removed some YCR's, also find the first tab
    //<< ;                           if needed.
    //<< ; 25-Jun-2006   shobby  SR014072: Customisation of tab properties WWW1203D
    //<< ; 11-May-2006   FrankF  SR14556: Customize Tabs
    //<< ;-------------------------------------------------------------------------------
    //<< new strDrawOrder,intLength,intPos,idSite
    mVar strDrawOrder = m$.var("strDrawOrder");
    mVar intLength = m$.var("intLength");
    mVar intPos = m$.var("intPos");
    mVar idSite = m$.var("idSite");
    m$.newVar(strDrawOrder,intLength,intPos,idSite);
    //<< 
    //<< $$$LogR("MAIN",YFORM)
    $$$LogR(m$,"MAIN",m$.var("YFORM"));
    //<< 
    //<< set strDrawOrder = $$GetDisplayOrder(YFORM,SPRACHE)
    strDrawOrder.set(m$.fnc$("GetDisplayOrder",m$.var("YFORM").get(),m$.var("SPRACHE").get()));
    //<< set intLength    = $length(strDrawOrder,Y)
    intLength.set(m$.Fnc.$length(strDrawOrder.get(),m$.var("Y").get()));
    //<< 
    //<< set idSite = $$FindFirstTab^WWW1203(YFORM,SPRACHE,YSEITE)
    idSite.set(m$.fnc$("WWW1203.FindFirstTab",m$.var("YFORM").get(),m$.var("SPRACHE").get(),m$.var("YSEITE").get()));
    //<< if (YSEITE=1) && (idSite'=1) {
    if ((mOp.Equal(m$.var("YSEITE").get(),1)) && (mOp.NotEqual(idSite.get(),1))) {
      //<< set YSEITE = idSite
      mVar YSEITE = m$.var("YSEITE");
      YSEITE.set(idSite.get());
    }
    //<< }
    //<< 
    //<< write YCR,"<TABLE border=0 frame=void cellpadding=0 cellspacing=0> "  ; width=100%>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TABLE border=0 frame=void cellpadding=0 cellspacing=0> ");
    //<< ;write YCR,"<TABLE id=""wf6m"" border=0 frame=void cellpadding=0 cellspacing=0> "
    //<< 
    //<< set YXS=0
    mVar YXS = m$.var("YXS");
    YXS.set(0);
    //<< 
    //<< set YLFN=""
    mVar YLFN = m$.var("YLFN");
    YLFN.set("");
    //<< for {
    for (;true;) {
      //<< set YLFN = $order(^WWW1203(0,YFORM,SPRACHE,YLFN))
      YLFN.set(m$.Fnc.$order(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),YLFN.get())));
      //<< quit:YLFN=""
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      //<< 
      //<< if $find($piece($get(^WWW1203(0,YFORM,SPRACHE,YLFN,1)),Y,1),".gif") {
      if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),YLFN.get(),1)),m$.var("Y").get(),1),".gif"))) {
        //<< set YXS=1
        YXS.set(1);
        //<< quit
        break;
      }
    }
    //<< }
    //<< }
    //<< 
    //<< write "<TR>"
    m$.Cmd.Write("<TR>");
    //<< 
    //<< set YRLANG=0  ;LÄNGE DER REITER ;length
    mVar YRLANG = m$.var("YRLANG");
    YRLANG.set(0);
    //<< if YXS=1 do   ;MIT GIF ;by means of
    if (mOp.Equal(YXS.get(),1)) {
      //<< . for intPos=1:1:intLength do
      for (intPos.set(1);(mOp.LessOrEqual(intPos.get(),intLength.get()));intPos.set(mOp.Add(intPos.get(),1))) {
        //<< . . set YLFN=$piece(strDrawOrder,Y,intPos)
        YLFN.set(m$.Fnc.$piece(strDrawOrder.get(),m$.var("Y").get(),intPos.get()));
        //<< . . if YLFN'="" do
        if (mOp.NotEqual(YLFN.get(),"")) {
          //<< . . . if $data(^WWW122s(0,1,YLFN,YFORM)) || $data(^WWW1203(0,YFORM,SPRACHE,YLFN)) do
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,1,YLFN.get(),m$.var("YFORM").get()))) || mOp.Logical(m$.Fnc.$data(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),YLFN.get())))) {
            //<< . . . . set YREITER=YLFN
            mVar YREITER = m$.var("YREITER");
            YREITER.set(YLFN.get());
            //<< . . . . do SEITE
            m$.Cmd.Do("SEITE");
          }
        }
      }
    }
    //<< 
    //<< if YXS=0 do   ;OHNE GIF ;without
    if (mOp.Equal(YXS.get(),0)) {
      //<< . for intPos=1:1:intLength do
      for (intPos.set(1);(mOp.LessOrEqual(intPos.get(),intLength.get()));intPos.set(mOp.Add(intPos.get(),1))) {
        //<< . . set YLFN=$piece(strDrawOrder,Y,intPos)
        YLFN.set(m$.Fnc.$piece(strDrawOrder.get(),m$.var("Y").get(),intPos.get()));
        //<< . . if YLFN'="" do
        if (mOp.NotEqual(YLFN.get(),"")) {
          //<< . . . if $data(^WWW122s(0,1,YLFN,YFORM)) || $data(^WWW1203(0,YFORM,SPRACHE,YLFN)) do
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,1,YLFN.get(),m$.var("YFORM").get()))) || mOp.Logical(m$.Fnc.$data(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),YLFN.get())))) {
            //<< . . . . set YREITER=YLFN
            mVar YREITER = m$.var("YREITER");
            YREITER.set(YLFN.get());
            //<< . . . . do SEITE1
            m$.Cmd.Do("SEITE1");
          }
        }
      }
    }
    //<< 
    //<< write YCR,"</TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    //<< 
    //<< ;SR18046 if YXS=0 do
    //<< ;SR18046 . new PAGE
    //<< ;SR18046 . write "<TR>"
    //<< ;SR18046 . for intPos=1:1:intLength do
    //<< ;SR18046 . . set YLFN=$piece(strDrawOrder,Y,intPos)
    //<< ;SR18046 . . if YLFN'="" do
    //<< ;SR18046 . . . if $data(^WWW122s(0,1,YLFN,YFORM)) && $data(^WWW1203(0,YFORM,SPRACHE,YLFN)) do
    //<< ;SR18046 . . . . set YREITER=YLFN
    //<< ;SR18046 . . . . write YCR,"<TD>"
    //<< ;SR18046 . . . . if $find(YSILVER,"gr")  if YLFN=YSEITE  write YCR,"<IMG SRC="""_YGIF_"graupunkt.gif"" width=98 height=1>"
    //<< ;SR18046 . . . . if $find(YSILVER,"gr")  if YLFN'=YSEITE write YCR,"<IMG SRC="""_YGIF_"weisspunkt.gif"" width=98 height=1>"
    //<< ;SR18046 . . . . if '$find(YSILVER,"gr") if YLFN=YSEITE  write YCR,"<IMG SRC="""_YGIF_"weisspunkt.gif"" width=98 height=1>"
    //<< ;SR18046 . . . . if '$find(YSILVER,"gr") if YLFN'=YSEITE write YCR,"<IMG SRC="""_YGIF_"graupunkt.gif"" width=98 height=1>"
    //<< ;SR18046 . . . . write "</TD>"
    //<< ;SR18046 . write "</TR>"
    //<< 
    //<< write YCR,"</TABLE>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< INPAGE
  public void INPAGE() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; SEITENREITER INNERHALB DER SEITE ;inside the side
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Jun-2012   shobby  SR18046: Removed some redundant code.
    //<< ; 06-Jan-2009   GRF     SR16249: Correct variable name - refactor
    //<< ; 25-Oct-2006   RPW     SRBR014072: removed some YCRs
    //<< ; 25-Jun-2006   shobby  SRBR014072: Customisation of tab properties.
    //<< ;-------------------------------------------------------------------------------
    //<< new intLength,intPos,strDrawOrder
    mVar intLength = m$.var("intLength");
    mVar intPos = m$.var("intPos");
    mVar strDrawOrder = m$.var("strDrawOrder");
    m$.newVar(intLength,intPos,strDrawOrder);
    //<< 
    //<< $$$LogR("INPAGE",YFORM)
    $$$LogR(m$,"INPAGE",m$.var("YFORM"));
    //<< 
    //<< set strDrawOrder = $$GetDisplayOrder(YFORM,SPRACHE)
    strDrawOrder.set(m$.fnc$("GetDisplayOrder",m$.var("YFORM").get(),m$.var("SPRACHE").get()));
    //<< set intLength    = $length(strDrawOrder,Y)
    intLength.set(m$.Fnc.$length(strDrawOrder.get(),m$.var("Y").get()));
    //<< set YINSEITE     = +$get(YINSEITE)
    mVar YINSEITE = m$.var("YINSEITE");
    YINSEITE.set(mOp.Positive(m$.Fnc.$get(m$.var("YINSEITE"))));
    //<< if YINSEITE=0 set YINSEITE = 1
    if (mOp.Equal(YINSEITE.get(),0)) {
      YINSEITE.set(1);
    }
    //<< 
    //<< if YINSEITE=1 {
    if (mOp.Equal(YINSEITE.get(),1)) {
      //<< set YINSEITE = $$FindFirstTab^WWW1203(YFORM,SPRACHE,YINSEITE)
      YINSEITE.set(m$.fnc$("WWW1203.FindFirstTab",m$.var("YFORM").get(),m$.var("SPRACHE").get(),YINSEITE.get()));
    }
    //<< }
    //<< 
    //<< write YCR,"<TABLE border=0 frame=void cellpadding=0 cellspacing=0 BGCOLOR="_YSILVER_"> "  ; width=100%>"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TABLE border=0 frame=void cellpadding=0 cellspacing=0 BGCOLOR=",m$.var("YSILVER").get()),"> "));
    //<< ;write YCR,"<TABLE id=""wf6i"" border=0 frame=void cellpadding=0 cellspacing=0 BGCOLOR="_YSILVER_"> "  ; width=100%>"
    //<< set YXS=0
    mVar YXS = m$.var("YXS");
    YXS.set(0);
    //<< 
    //<< set YLFN=""
    mVar YLFN = m$.var("YLFN");
    YLFN.set("");
    //<< for {
    for (;true;) {
      //<< set YLFN = $order(^WWW1203(0,YFORM,SPRACHE,YLFN))
      YLFN.set(m$.Fnc.$order(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),YLFN.get())));
      //<< quit:YLFN=""
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      //<< 
      //<< if $find($piece($$GET^WWW1203(YFORM,SPRACHE,YLFN),Y,1),".gif") {
      if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.fnc$("WWW1203.GET",m$.var("YFORM").get(),m$.var("SPRACHE").get(),YLFN.get()),m$.var("Y").get(),1),".gif"))) {
        //<< set YXS=1
        YXS.set(1);
        //<< quit
        break;
      }
    }
    //<< }
    //<< }
    //<< 
    //<< write "<TR>"
    m$.Cmd.Write("<TR>");
    //<< set YRLANG=0  ;LÄNGE DER REITER ;length
    mVar YRLANG = m$.var("YRLANG");
    YRLANG.set(0);
    //<< if YXS=1 do   ;MIT GIF ;by means of
    if (mOp.Equal(YXS.get(),1)) {
      //<< . for intPos=1:1:intLength do
      for (intPos.set(1);(mOp.LessOrEqual(intPos.get(),intLength.get()));intPos.set(mOp.Add(intPos.get(),1))) {
        //<< . . set YLFN=$piece(strDrawOrder,Y,intPos)
        YLFN.set(m$.Fnc.$piece(strDrawOrder.get(),m$.var("Y").get(),intPos.get()));
        //<< . . if YLFN'="" do
        if (mOp.NotEqual(YLFN.get(),"")) {
          //<< . . . if ($data(^WWW1203(0,YFORM,SPRACHE,YSEITE_"."_YLFN))) do
          if (mOp.Logical((m$.Fnc.$data(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),mOp.Concat(mOp.Concat(m$.var("YSEITE").get(),"."),YLFN.get())))))) {
            //<< . . . . set YREITER=YSEITE_"."_YLFN
            mVar YREITER = m$.var("YREITER");
            YREITER.set(mOp.Concat(mOp.Concat(m$.var("YSEITE").get(),"."),YLFN.get()));
            //<< . . . . do SEITE2
            m$.Cmd.Do("SEITE2");
          }
        }
      }
    }
    //<< 
    //<< if YXS=0 do   ;OHNE GIF ;without
    if (mOp.Equal(YXS.get(),0)) {
      //<< . for intPos=1:1:intLength do
      for (intPos.set(1);(mOp.LessOrEqual(intPos.get(),intLength.get()));intPos.set(mOp.Add(intPos.get(),1))) {
        //<< . . set YLFN=$piece(strDrawOrder,Y,intPos)
        YLFN.set(m$.Fnc.$piece(strDrawOrder.get(),m$.var("Y").get(),intPos.get()));
        //<< . . if YLFN'="" do
        if (mOp.NotEqual(YLFN.get(),"")) {
          //<< . . . if ($data(^WWW1203(0,YFORM,SPRACHE,YSEITE_"."_YLFN))) do
          if (mOp.Logical((m$.Fnc.$data(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),mOp.Concat(mOp.Concat(m$.var("YSEITE").get(),"."),YLFN.get())))))) {
            //<< . . . . set YREITER=YSEITE_"."_YLFN
            mVar YREITER = m$.var("YREITER");
            YREITER.set(mOp.Concat(mOp.Concat(m$.var("YSEITE").get(),"."),YLFN.get()));
            //<< . . . . do SEITE3
            m$.Cmd.Do("SEITE3");
          }
        }
      }
    }
    //<< 
    //<< ;SR18046 if YXS=0 do
    //<< ;SR18046 . write "<TR>"
    //<< ;SR18046 . for intPos=1:1:intLength do
    //<< ;SR18046 . . set YLFN=$piece(strDrawOrder,Y,intPos)
    //<< ;SR18046 . . if YLFN'="" do
    //<< ;SR18046 . . . if ($data(^WWW1203(0,YFORM,SPRACHE,YSEITE_"."_YLFN))) do
    //<< ;SR18046 . . . . set YREITER=YSEITE_"."_YLFN
    //<< ;SR18046 . . . . write YCR,"<TD>"
    //<< ;SR18046 . . . . if $find(YSILVER,"gr")  if YLFN=YINSEITE  write YCR,"<IMG SRC="""_YGIF_"graupunkt.gif"" width=98 height=1>"
    //<< ;SR18046 . . . . if $find(YSILVER,"gr")  if YLFN'=YINSEITE write YCR,"<IMG SRC="""_YGIF_"weisspunkt.gif"" width=98 height=1>"
    //<< ;SR18046 . . . . if '$find(YSILVER,"gr") if YLFN=YINSEITE  write YCR,"<IMG SRC="""_YGIF_"weisspunkt.gif"" width=98 height=1>"
    //<< ;SR18046 . . . . if '$find(YSILVER,"gr") if YLFN'=YINSEITE write YCR,"<IMG SRC="""_YGIF_"graupunkt.gif"" width=98 height=1>"
    //<< ;SR18046 . . . . write "</TD>"
    //<< ;SR18046 . write "</TR>"
    //<< 
    //<< ;DO
    //<< ;. WRITE YCR,"<TD WIDTH=90%"
    //<< ;. WRITE " BGCOLOR="_YSILVER  ; darkgray"  ;lightgrey"
    //<< ;. WRITE ">"
    //<< ;. WRITE YCR,"</TD>"
    //<< 
    //<< write YCR,"</TR>"   ; FIXME : Doubles up on </TR> in prev DO block - should this be a </TABLE>?
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< ChangeTabs(YINSEITE,YSEITE,TOOLTIP)
  public Object ChangeTabs(Object ... _p) {
    mVar YINSEITE = m$.newVarRef("YINSEITE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YSEITE = m$.newVarRef("YSEITE",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar TOOLTIP = m$.newVarRef("TOOLTIP",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Changing Tabs HTML
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ;  7-Feb-2006   JW      SR15062: FINGLBankRecon exception. (Moved from WWWSAVE)
    //<< ; 16-Dec-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------
    //<< write "<A "
    m$.Cmd.Write("<A ");
    //<< if $get(TOOLTIP)'="" write " TITLE="""_TOOLTIP_""" "
    if (mOp.NotEqual(m$.Fnc.$get(TOOLTIP),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",TOOLTIP.get()),"\" "));
    }
    //<< write "href=""#"" onClick="""
    m$.Cmd.Write("href=\"#\" onClick=\"");
    //<< write "document.WWW.target=''; "
    m$.Cmd.Write("document.WWW.target=''; ");
    //<< write "document.WWW.YINSEITE.value='"_YINSEITE_"'; "
    m$.Cmd.Write(mOp.Concat(mOp.Concat("document.WWW.YINSEITE.value='",YINSEITE.get()),"'; "));
    //<< if $get(YSEITE)'="" write "document.WWW.YSEITE.value='"_YSEITE_"'; "
    if (mOp.NotEqual(m$.Fnc.$get(YSEITE),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat("document.WWW.YSEITE.value='",YSEITE.get()),"'; "));
    }
    //<< 
    //<< if $get(YFORM) = "FINGLBankRecon" {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"FINGLBankRecon")) {
      //<< write "SAVENOW(0); "
      m$.Cmd.Write("SAVENOW(0); ");
    }
    //<< } else {
    else {
      //<< write "SAVENOW(2); "
      m$.Cmd.Write("SAVENOW(2); ");
    }
    //<< }
    //<< write "return false; "
    m$.Cmd.Write("return false; ");
    //<< write """>"
    m$.Cmd.Write("\">");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateTD(YGIF,pblnSelected,pblnColorFlag)
  public Object CreateTD(Object ... _p) {
    mVar YGIF = m$.newVarRef("YGIF",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnSelected = m$.newVarRef("pblnSelected",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnColorFlag = m$.newVarRef("pblnColorFlag",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Creates the tab TD
    //<< ;
    //<< ; History:
    //<< ; 04-May-2012   shobby  SR18046: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new HTML
    mVar HTML = m$.var("HTML");
    m$.newVar(HTML);
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< set HTML=HTML_YCR_"<TD align=center "
    HTML.set(mOp.Concat(mOp.Concat(HTML.get(),m$.var("YCR").get()),"<TD align=center "));
    //<< set HTML=HTML_"style=' white-space:nowrap; "
    HTML.set(mOp.Concat(HTML.get(),"style=' white-space:nowrap; "));
    //<< set HTML=HTML_" border:none; width:98px; height:19px; background-image:url("""_YGIF_"reitertab.gif"");"
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get()," border:none; width:98px; height:19px; background-image:url(\""),YGIF.get()),"reitertab.gif\");"));
    //<< set HTML=HTML_" background-color:"_$$getTabColor(pblnSelected)_";"
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get()," background-color:"),m$.fnc$("getTabColor",pblnSelected.get())),";"));
    //<< set HTML=HTML_" border-bottom:1px solid "_$select(pblnSelected'=pblnColorFlag:"white",1:"silver")_";'"
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get()," border-bottom:1px solid "),m$.Fnc.$select(mOp.NotEqual(pblnSelected.get(),pblnColorFlag.get()),"white",1,"silver")),";'"));
    //<< set HTML=HTML_">"
    HTML.set(mOp.Concat(HTML.get(),">"));
    //<< 
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< SEITE
  public void SEITE() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; PAGE HAUPTSEITE MIT BILDERN ;page by means of
    //<< ;
    //<< ; History:
    //<< ; 25-Oct-2006   RPW     SRBR014072: Removed unused code
    //<< ; 25-Jun-2006   shobby  SRBR014072: Customisation of tabs.
    //<< ; 11-May-2006   FrankF  SR14556: Customize Tabs
    //<< ;-------------------------------------------------------------------------------
    //<< new TOOLTIP,PAGE
    mVar TOOLTIP = m$.var("TOOLTIP");
    mVar PAGE = m$.var("PAGE");
    m$.newVar(TOOLTIP,PAGE);
    //<< 
    //<< set PAGE = $$GET^WWW1203(YFORM,SPRACHE,YREITER)
    PAGE.set(m$.fnc$("WWW1203.GET",m$.var("YFORM").get(),m$.var("SPRACHE").get(),m$.var("YREITER").get()));
    //<< 
    //<< set TOOLTIP=$piece(PAGE,Y,3)
    TOOLTIP.set(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),3));
    //<< if $piece(PAGE,Y,2)=1 write YCR,"</TR><TR>"  ;NEUE ZEILE
    if (mOp.Equal(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),2),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TR><TR>");
    }
    do {
      //<< do
      //<< . set YYSEIT=$piece(PAGE,Y,1)
      mVar YYSEIT = m$.var("YYSEIT");
      YYSEIT.set(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),1));
      //<< . if YYSEIT="" do
      if (mOp.Equal(YYSEIT.get(),"")) {
        //<< . . if SPRACHE="DE"  set YYSEIT="seite"_$piece(YREITER,".",1)_".gif"   ; FIXME : Internationalise or standardise?
        if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
          YYSEIT.set(mOp.Concat(mOp.Concat("seite",m$.Fnc.$piece(m$.var("YREITER").get(),".",1)),".gif"));
        }
        //<< . . if SPRACHE'="DE" set YYSEIT="page"_$piece(YREITER,".",1)_".gif"
        if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
          YYSEIT.set(mOp.Concat(mOp.Concat("page",m$.Fnc.$piece(m$.var("YREITER").get(),".",1)),".gif"));
        }
      }
      //<< . ;
      //<< . do
      do {
        //<< . . if YLFN=YSEITE  write YCR,"<TD NOWRAP align=left valign=bottom height=22"
        if (mOp.Equal(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
          m$.Cmd.Write(m$.var("YCR").get(),"<TD NOWRAP align=left valign=bottom height=22");
        }
        //<< . . if YLFN'=YSEITE write YCR,"<TD NOWRAP align=left valign=top height=22"
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
          m$.Cmd.Write(m$.var("YCR").get(),"<TD NOWRAP align=left valign=top height=22");
        }
        //<< . . write " BGCOLOR="_$$getTabColor(YLFN = YSEITE)_">",YCR
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" BGCOLOR=",m$.fnc$("getTabColor",mOp.Equal(m$.var("YLFN").get(),m$.var("YSEITE").get()))),">"),m$.var("YCR").get());
        //<< . . if $$$DEVMODE set TOOLTIP=TOOLTIP_" YSEITE="_YREITER
        if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
          TOOLTIP.set(mOp.Concat(mOp.Concat(TOOLTIP.get()," YSEITE="),m$.var("YREITER").get()));
        }
        //<< . . if YLFN'=YSEITE do ChangeTabs("",+YLFN)
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
          m$.Cmd.Do("ChangeTabs","",mOp.Positive(m$.var("YLFN").get()));
        }
        //<< . . ;
        //<< . . write YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . . if YLFN=YSEITE  write "<IMG SRC="""_YGIF_YYSEIT_""" align=left valign=bottom vspace=0 TITLE="""_TOOLTIP_""""
        if (mOp.Equal(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),YYSEIT.get()),"\" align=left valign=bottom vspace=0 TITLE=\""),TOOLTIP.get()),"\""));
        }
        //<< . . if YLFN'=YSEITE write "<IMG SRC="""_YGIF_YYSEIT_""" style=""filter:alpha(opacity=60)"" onMouseover=""makevisible(this,0)""onMouseout=""makevisible(this,1)"" align=left valign=bottom vspace=0 TITLE="""_TOOLTIP_""""
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),YYSEIT.get()),"\" style=\"filter:alpha(opacity=60)\" onMouseover=\"makevisible(this,0)\"onMouseout=\"makevisible(this,1)\" align=left valign=bottom vspace=0 TITLE=\""),TOOLTIP.get()),"\""));
        }
        //<< . . if YLFN=YSEITE  write " border=0"
        if (mOp.Equal(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
          m$.Cmd.Write(" border=0");
        }
        //<< . . if YLFN'=YSEITE write " border=0"
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
          m$.Cmd.Write(" border=0");
        }
        //<< . . write ">"
        m$.Cmd.Write(">");
        //<< . . if YLFN'=YSEITE write YCR,"</A>"
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
          m$.Cmd.Write(m$.var("YCR").get(),"</A>");
        }
        //<< . . write YCR,"</TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
      } while(false);
    } while(false);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< SEITE1
  public void SEITE1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   PAGE VERSION HAUPTSEITE OHNE BILDER ;page without images
    //<< ;
    //<< ; If Mandatory Data    is missing on the saved record,
    //<< ;                                     append an asterisk "*" to the tab
    //<< ; If Important Content is missing on the saved record,
    //<< ;                                     append an exclaimation mark "!" to the tab
    //<< ;
    //<< ; History:
    //<< ; 12-Mar-2013   shobby  CORE-71.1: Restrict length of text if * or ! are visible.
    //<< ; 06-Mar-2013   shobby  CORE-71: Rewrote the Required/Important as it would miss fields
    //<< ;                           that are customised on to a different tab.
    //<< ; 30-Jul-2008   GRF     SR15822: Reverse logic on Important Content test; macros;
    //<< ;                           Show first piece of object is being used as piece
    //<< ;                           number rather than whole object.
    //<< ; 25-Oct-2006   RPW     SRBR014072: Removed unsed code and naked reference
    //<< ; 25-Jun-2006   shobby  SRBR014072: Customisation of tabs.
    //<< ; 11-May-2006   FrankF  SR14556: Customize Tabs
    //<< ;-------------------------------------------------------------------------------
    //<< new TOOLTIP,PAGE
    mVar TOOLTIP = m$.var("TOOLTIP");
    mVar PAGE = m$.var("PAGE");
    m$.newVar(TOOLTIP,PAGE);
    //<< 
    //<< set PAGE    = $$GET^WWW1203(YFORM,SPRACHE,YREITER)
    PAGE.set(m$.fnc$("WWW1203.GET",m$.var("YFORM").get(),m$.var("SPRACHE").get(),m$.var("YREITER").get()));
    //<< set TOOLTIP = $piece(PAGE,Y,3)
    TOOLTIP.set(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),3));
    //<< if $piece(PAGE,Y,2)=1 write YCR,"</TR><TR>"  ;NEUE ZEILE WENN ZU VIELE REITER ;when within much
    if (mOp.Equal(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),2),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TR><TR>");
    }
    do {
      //<< do
      //<< . set YYSEIT=$piece(PAGE,Y,1)
      mVar YYSEIT = m$.var("YYSEIT");
      YYSEIT.set(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),1));
      //<< . if YYSEIT="" do
      if (mOp.Equal(YYSEIT.get(),"")) {
        //<< . . if SPRACHE="DE"  set YYSEIT="Seite "_(+YLFN)
        if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
          YYSEIT.set(mOp.Concat("Seite ",(mOp.Positive(m$.var("YLFN").get()))));
        }
        //<< . . if SPRACHE'="DE" set YYSEIT="page "_(+YLFN)
        if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
          YYSEIT.set(mOp.Concat("page ",(mOp.Positive(m$.var("YLFN").get()))));
        }
      }
      //<< . ;
      //<< . do
      do {
        //<< . . set YYSEIT=$piece(YYSEIT,".gif",1)
        YYSEIT.set(m$.Fnc.$piece(YYSEIT.get(),".gif",1));
        //<< . . if YYSEIT=""  set YYSEIT=$piece(YYSEIT,".GIF",1)
        if (mOp.Equal(YYSEIT.get(),"")) {
          YYSEIT.set(m$.Fnc.$piece(YYSEIT.get(),".GIF",1));
        }
        //<< . . if TOOLTIP="" set TOOLTIP=YYSEIT
        if (mOp.Equal(TOOLTIP.get(),"")) {
          TOOLTIP.set(YYSEIT.get());
        }
        //<< . . set YRLANG=YRLANG+$length(YYSEIT)  ;LÄNGE DER REITER ;length
        mVar YRLANG = m$.var("YRLANG");
        YRLANG.set(mOp.Add(m$.var("YRLANG").get(),m$.Fnc.$length(YYSEIT.get())));
        //<< . . ;
        //<< . . ;SR18046 if YLFN=YSEITE  write YCR,"<TD WIDTH=98 height=19 align=center NOWRAP BORDER=0 background="""_YGIF_"reitertab.gif"""
        //<< . . ;SR18046 if YLFN'=YSEITE write YCR,"<TD WIDTH=98 height=19 align=center NOWRAP BORDER=0 background="""_YGIF_"reitertab.gif"""
        //<< . . ;SR18046 write " BGCOLOR="_strColor_">",YCR
        //<< . . write $$CreateTD(YGIF,YLFN=YSEITE,$find(YSILVER,"gr"))  ;SR18046
        m$.Cmd.Write(m$.fnc$("CreateTD",m$.var("YGIF").get(),mOp.Equal(m$.var("YLFN").get(),m$.var("YSEITE").get()),m$.Fnc.$find(m$.var("YSILVER").get(),"gr")));
        //<< . . write "<FONT SIZE=2>",YCR
        m$.Cmd.Write("<FONT SIZE=2>",m$.var("YCR").get());
        //<< . . if $$$DEVMODE set TOOLTIP=TOOLTIP_" YSEITE="_YREITER
        if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
          TOOLTIP.set(mOp.Concat(mOp.Concat(TOOLTIP.get()," YSEITE="),m$.var("YREITER").get()));
        }
        //<< . . if YLFN'=YSEITE do ChangeTabs("",+YLFN,TOOLTIP)
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
          m$.Cmd.Do("ChangeTabs","",mOp.Positive(m$.var("YLFN").get()),TOOLTIP.get());
        }
        //<< . . ;
        //<< . . ; CORE-71 vvvvv
        //<< . . ; CORE-71.1 if $length(YYSEIT)>13 set YYSEIT = $extract(YYSEIT,1,12)_"."
        //<< . . write YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . . do
        do {
          //<< . . . new blnRequired,blnImportant,intMaxLength
          mVar blnRequired = m$.var("blnRequired");
          mVar blnImportant = m$.var("blnImportant");
          mVar intMaxLength = m$.var("intMaxLength");
          m$.newVarBlock(3,blnRequired,blnImportant,intMaxLength);
          //<< . . . do GetFlags(YLFN,.blnRequired,.blnImportant)
          m$.Cmd.Do("GetFlags",m$.var("YLFN").get(),blnRequired,blnImportant);
          //<< . . . set intMaxLength=13
          intMaxLength.set(13);
          //<< . . . if blnRequired set intMaxLength=intMaxLength-1
          if (mOp.Logical(blnRequired.get())) {
            intMaxLength.set(mOp.Subtract(intMaxLength.get(),1));
          }
          //<< . . . if blnImportant set intMaxLength=intMaxLength-1
          if (mOp.Logical(blnImportant.get())) {
            intMaxLength.set(mOp.Subtract(intMaxLength.get(),1));
          }
          //<< . . . if blnRequired || blnImportant set intMaxLength=intMaxLength-1
          if (mOp.Logical(blnRequired.get()) || mOp.Logical(blnImportant.get())) {
            intMaxLength.set(mOp.Subtract(intMaxLength.get(),1));
          }
          //<< . . . if $length(YYSEIT)>intMaxLength set YYSEIT = $extract(YYSEIT,1,intMaxLength-1)_"."
          if (mOp.Greater(m$.Fnc.$length(YYSEIT.get()),intMaxLength.get())) {
            YYSEIT.set(mOp.Concat(m$.Fnc.$extract(YYSEIT.get(),1,mOp.Subtract(intMaxLength.get(),1)),"."));
          }
          //<< . . . if YLFN=YSEITE write YCR,"<font color="_$$getTabTextColor($$$YES)_"><B>"_YYSEIT_"</B>"
          if (mOp.Equal(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<font color=",m$.fnc$("getTabTextColor",include.COMSYS.$$$YES(m$))),"><B>"),YYSEIT.get()),"</B>"));
          }
          //<< . . . if YLFN'=YSEITE do  ;SEITE NICHT AKTIV ;side Not ENABLED
          if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
            //<< . . . . write YCR,"<font color="_$$getTabTextColor($$$NO)_">"_YYSEIT_""
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<font color=",m$.fnc$("getTabTextColor",include.COMSYS.$$$NO(m$))),">"),YYSEIT.get()),""));
          }
          //<< . . . ;
          //<< . . . if blnRequired write YCR,"<FONT COLOR=RED>*</FONT>"
          if (mOp.Logical(blnRequired.get())) {
            m$.Cmd.Write(m$.var("YCR").get(),"<FONT COLOR=RED>*</FONT>");
          }
          //<< . . . if blnImportant write YCR,"<FONT COLOR=RED>!</FONT>"
          if (mOp.Logical(blnImportant.get())) {
            m$.Cmd.Write(m$.var("YCR").get(),"<FONT COLOR=RED>!</FONT>");
          }
        } while(false);
        m$.restoreVarBlock(3);
        //<< . . ;CORE-71 set YIMPORTANT = $$$NO
        //<< . . ;CORE-71 do   ;pfichtfelder
        //<< . . ;CORE-71 . new YI
        //<< . . ;CORE-71 . set YI(3)=0  ;STOP VARIABLE
        //<< . . ;CORE-71 . set YI=""
        //<< . . ;CORE-71 . for  set YI=$order(^WWW122s(0,1,YLFN,YFORM,YI)) quit:YI=""  do  quit:YI(3)=1
        //<< . . ;CORE-71 . . set YI(1)=$get(^WWW122(0,YFORM,YI,1))
        //<< . . ;CORE-71 . . quit:$$$WWW122SequenceNumber(YI(1))=""                            ;KEIN DATENFELD ;no data item
        //<< . . ;CORE-71 . . if $$$WWW122ImportantContent(YI(1))=$$$YES set YIMPORTANT=$$$YES  ;WICHTIGES FELD VORHANDEN ;field on hand
        //<< . . ;CORE-71 . . if $get(YM)'="" if $data(^WWW122D(0,YFORM,YI,YM,1)) do
        //<< . . ;CORE-71 . . . set $$$WWW122MandatoryInputItem(YI(1)) = $$$NO
        //<< . . ;CORE-71 . . . if $$$WWW122DMandatoryField(^WWW122D(0,YFORM,YI,YM,1))=$$$YES set $$$WWW122MandatoryInputItem(YI(1)) = $$$YES
        //<< . . ;CORE-71 . . quit:$$$WWW122MandatoryInputItem(YI(1))'=$$$YES             ;KEIN PFLICHTFELD ;no
        //<< . . ;CORE-71 . . quit:$piece($get(YFELD),Y,+YI(1))'=""                       ;DATEN EINGETRAGEN ;regd.
        //<< . . ;CORE-71 . . if $length(YYSEIT)<12 write YCR,"<FONT COLOR=RED>*</FONT>"  ;PFLICHTFELD NICHT EINGETRAGEN ;Not regd.
        //<< . . ;CORE-71 . . set YI(3)=1
        //<< . . ;CORE-71 ;
        //<< . . ;CORE-71 if YIMPORTANT=1 do   ;WICHTIGES FELD VORHANDEN ;field on hand
        //<< . . ;CORE-71 . new YI
        //<< . . ;CORE-71 . set YI(3)=0  ;STOP VARIABLE
        //<< . . ;CORE-71 . set YI=""
        //<< . . ;CORE-71 . for  set YI=$order(^WWW122s(0,1,YLFN,YFORM,YI)) quit:YI=""  do  quit:YI(3)=1
        //<< . . ;CORE-71 . . set YI(1)=$get(^WWW122(0,YFORM,YI,1))
        //<< . . ;CORE-71 . . quit:$$$WWW122SequenceNumber(YI(1))=""          ; not class field
        //<< . . ;CORE-71 . . quit:$$$WWW122ImportantContent(YI(1))'=$$$YES   ; Disregard if not important
        //<< . . ;CORE-71 . . quit:$piece($get(YFELD),Y,+YI(1))'=""           ; Not empty
        //<< . . ;CORE-71 . . if $length(YYSEIT)<12 write YCR,"<FONT COLOR=RED>!</FONT>"  ;WICHTIGES FELD EINGETRAGEN ;field regd.
        //<< . . ;CORE-71 . . set YI(3)=1
        //<< . . ;
        //<< . . if YLFN'=YSEITE write YCR,"</A>"
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YSEITE").get())) {
          m$.Cmd.Write(m$.var("YCR").get(),"</A>");
        }
        //<< . . write YCR,"</TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
      } while(false);
    } while(false);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< SEITE2
  public void SEITE2() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   PAGE INNENSEITE MIT BILDERN ;page by means of
    //<< ;
    //<< ; History:
    //<< ; 25-Oct-2006   RPW     SRBR014072: Removed unused code
    //<< ; 25-Jun-2006   shobby  SRBR014072: Customisation of tabs.
    //<< ; 11-May-2006   FrankF  SR14556: Customize Tabs
    //<< ;-------------------------------------------------------------------------------
    //<< new TOOLTIP,PAGE
    mVar TOOLTIP = m$.var("TOOLTIP");
    mVar PAGE = m$.var("PAGE");
    m$.newVar(TOOLTIP,PAGE);
    //<< set PAGE    = $$GET^WWW1203(YFORM,SPRACHE,YREITER)
    PAGE.set(m$.fnc$("WWW1203.GET",m$.var("YFORM").get(),m$.var("SPRACHE").get(),m$.var("YREITER").get()));
    //<< set TOOLTIP = $piece(PAGE,Y,3)
    TOOLTIP.set(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),3));
    //<< if $piece(PAGE,Y,2)=1 write YCR,"</TR><TR>"  ;NEUE ZEILE
    if (mOp.Equal(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),2),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TR><TR>");
    }
    do {
      //<< do
      //<< . set YYSEIT=$piece(PAGE,Y,1)
      mVar YYSEIT = m$.var("YYSEIT");
      YYSEIT.set(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),1));
      //<< . if YYSEIT="" do
      if (mOp.Equal(YYSEIT.get(),"")) {
        //<< . . if SPRACHE="DE"  set YYSEIT="Seite"_(+YLFN)_".gif"
        if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
          YYSEIT.set(mOp.Concat(mOp.Concat("Seite",(mOp.Positive(m$.var("YLFN").get()))),".gif"));
        }
        //<< . . if SPRACHE'="DE" set YYSEIT="page"_(+YLFN)_".gif"
        if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
          YYSEIT.set(mOp.Concat(mOp.Concat("page",(mOp.Positive(m$.var("YLFN").get()))),".gif"));
        }
      }
      //<< . ;
      //<< . do
      do {
        //<< . . if YLFN=YINSEITE  write YCR,"<TD NOWRAP align=left valign=bottom height=22"
        if (mOp.Equal(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          m$.Cmd.Write(m$.var("YCR").get(),"<TD NOWRAP align=left valign=bottom height=22");
        }
        //<< . . if YLFN'=YINSEITE write YCR,"<TD NOWRAP align=left valign=top height=22"
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          m$.Cmd.Write(m$.var("YCR").get(),"<TD NOWRAP align=left valign=top height=22");
        }
        //<< . . write " BGCOLOR="_$$getTabColor(YLFN = YINSEITE)_">",YCR
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" BGCOLOR=",m$.fnc$("getTabColor",mOp.Equal(m$.var("YLFN").get(),m$.var("YINSEITE").get()))),">"),m$.var("YCR").get());
        //<< . . if $$$DEVMODE set TOOLTIP=TOOLTIP_" YSEITE="_YREITER
        if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
          TOOLTIP.set(mOp.Concat(mOp.Concat(TOOLTIP.get()," YSEITE="),m$.var("YREITER").get()));
        }
        //<< . . if YLFN'=YINSEITE do
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          //<< . . . do ChangeTabs(+YLFN) //SR13195
          m$.Cmd.Do("ChangeTabs",mOp.Positive(m$.var("YLFN").get()));
        }
        //<< . . ;
        //<< . . write YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . . if YLFN=YINSEITE  write "<IMG SRC="""_YGIF_YYSEIT_""" align=left valign=bottom vspace=0 TITLE="""_TOOLTIP_""""
        if (mOp.Equal(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),YYSEIT.get()),"\" align=left valign=bottom vspace=0 TITLE=\""),TOOLTIP.get()),"\""));
        }
        //<< . . if YLFN'=YINSEITE write "<IMG SRC="""_YGIF_YYSEIT_""" style=""filter:alpha(opacity=60)"" onMouseover=""makevisible(this,0)""onMouseout=""makevisible(this,1)"" align=left valign=bottom vspace=0 TITLE="""_TOOLTIP_""""
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),YYSEIT.get()),"\" style=\"filter:alpha(opacity=60)\" onMouseover=\"makevisible(this,0)\"onMouseout=\"makevisible(this,1)\" align=left valign=bottom vspace=0 TITLE=\""),TOOLTIP.get()),"\""));
        }
        //<< . . if YLFN=YINSEITE  write " border=0"
        if (mOp.Equal(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          m$.Cmd.Write(" border=0");
        }
        //<< . . if YLFN'=YINSEITE write " border=0"
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          m$.Cmd.Write(" border=0");
        }
        //<< . . write ">"
        m$.Cmd.Write(">");
        //<< . . if YLFN'=YINSEITE write YCR,"</A>"
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          m$.Cmd.Write(m$.var("YCR").get(),"</A>");
        }
        //<< . . write YCR,"</TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
      } while(false);
    } while(false);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< SEITE3
  public void SEITE3() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   PAGE VERSION INNENSEITE OHNE BILDER ;page without imagery
    //<< ;
    //<< ; History:
    //<< ; 29-Jun-2012   shobby  SR18046: Removed some redundant code.
    //<< ; 25-Oct-2006   RPW     SRBR014072: Removed unused code
    //<< ; 25-Jun-2006   shobby  SRBR014072: Customisation of tabs.
    //<< ; 11-May-2006   FrankF  SR14556: Customize Tabs
    //<< ;-------------------------------------------------------------------------------
    //<< new TOOLTIP,PAGE
    mVar TOOLTIP = m$.var("TOOLTIP");
    mVar PAGE = m$.var("PAGE");
    m$.newVar(TOOLTIP,PAGE);
    //<< 
    //<< set PAGE    = $$GET^WWW1203(YFORM,SPRACHE,YREITER)
    PAGE.set(m$.fnc$("WWW1203.GET",m$.var("YFORM").get(),m$.var("SPRACHE").get(),m$.var("YREITER").get()));
    //<< set TOOLTIP = $piece(PAGE,Y,3)
    TOOLTIP.set(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),3));
    //<< if $piece(PAGE,Y,2)=1 write YCR,"</TR><TR>"  ;NEUE ZEILE WENN ZU VIELE REITER ;when within much
    if (mOp.Equal(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),2),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TR><TR>");
    }
    do {
      //<< do
      //<< . set YYSEIT = $piece(PAGE,Y,1)
      mVar YYSEIT = m$.var("YYSEIT");
      YYSEIT.set(m$.Fnc.$piece(PAGE.get(),m$.var("Y").get(),1));
      //<< . if YYSEIT="" do
      if (mOp.Equal(YYSEIT.get(),"")) {
        //<< . . if SPRACHE="DE"  set YYSEIT="seite "_(+YLFN)
        if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
          YYSEIT.set(mOp.Concat("seite ",(mOp.Positive(m$.var("YLFN").get()))));
        }
        //<< . . if SPRACHE'="DE" set YYSEIT="page "_(+YLFN)
        if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
          YYSEIT.set(mOp.Concat("page ",(mOp.Positive(m$.var("YLFN").get()))));
        }
      }
      //<< . ;
      //<< . do
      do {
        //<< . . set YYSEIT = $piece(YYSEIT,".gif",1)
        YYSEIT.set(m$.Fnc.$piece(YYSEIT.get(),".gif",1));
        //<< . . if YYSEIT=""  set YYSEIT  = $piece(YYSEIT,".GIF",1)
        if (mOp.Equal(YYSEIT.get(),"")) {
          YYSEIT.set(m$.Fnc.$piece(YYSEIT.get(),".GIF",1));
        }
        //<< . . if TOOLTIP="" set TOOLTIP = YYSEIT
        if (mOp.Equal(TOOLTIP.get(),"")) {
          TOOLTIP.set(YYSEIT.get());
        }
        //<< . . set YRLANG = YRLANG+$length(YYSEIT)  ;LÄNGE DER REITER ;length
        mVar YRLANG = m$.var("YRLANG");
        YRLANG.set(mOp.Add(m$.var("YRLANG").get(),m$.Fnc.$length(YYSEIT.get())));
        //<< . . ;
        //<< . . ;SR18046 if YLFN=YSEITE  write YCR,"<TD WIDTH=98 height=19 align=center NOWRAP BORDER=0 background="""_YGIF_"reitertab.gif"""
        //<< . . ;SR18046 if YLFN'=YSEITE write YCR,"<TD WIDTH=98 height=19 align=center NOWRAP BORDER=0 background="""_YGIF_"reitertab.gif"""
        //<< . . ;SR18046 write " BGCOLOR="_$$getTabColor(YLFN = YINSEITE)_">",YCR
        //<< . . write $$CreateTD(YGIF,YLFN=YINSEITE,$find(YSILVER,"gr"))    ;SR18046
        m$.Cmd.Write(m$.fnc$("CreateTD",m$.var("YGIF").get(),mOp.Equal(m$.var("YLFN").get(),m$.var("YINSEITE").get()),m$.Fnc.$find(m$.var("YSILVER").get(),"gr")));
        //<< . . write "<FONT SIZE=2>",YCR
        m$.Cmd.Write("<FONT SIZE=2>",m$.var("YCR").get());
        //<< . . if $$$DEVMODE set TOOLTIP=TOOLTIP_" YSEITE="_YREITER
        if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
          TOOLTIP.set(mOp.Concat(mOp.Concat(TOOLTIP.get()," YSEITE="),m$.var("YREITER").get()));
        }
        //<< . . if YLFN'=YINSEITE do
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          //<< . . . do ChangeTabs(+YLFN,,TOOLTIP)
          m$.Cmd.Do("ChangeTabs",mOp.Positive(m$.var("YLFN").get()),null,TOOLTIP.get());
        }
        //<< . . ;
        //<< . . if $length(YYSEIT)>13 set YYSEIT=$extract(YYSEIT,1,12)_"."
        if (mOp.Greater(m$.Fnc.$length(YYSEIT.get()),13)) {
          YYSEIT.set(mOp.Concat(m$.Fnc.$extract(YYSEIT.get(),1,12),"."));
        }
        //<< . . write YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . . if YLFN=YINSEITE  write "<font color="_$$getTabTextColor($$$YES)_"><B>"_YYSEIT_"</B>"
        if (mOp.Equal(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<font color=",m$.fnc$("getTabTextColor",include.COMSYS.$$$YES(m$))),"><B>"),YYSEIT.get()),"</B>"));
        }
        //<< . . if YLFN'=YINSEITE write "<font color="_$$getTabTextColor($$$NO)_">"_YYSEIT_""   ;SEITE NICHT AKTIV ;tab Not ENABLED
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<font color=",m$.fnc$("getTabTextColor",include.COMSYS.$$$NO(m$))),">"),YYSEIT.get()),""));
        }
        //<< . . ;
        //<< . . if YLFN'=YINSEITE write YCR,"</A>"
        if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YINSEITE").get())) {
          m$.Cmd.Write(m$.var("YCR").get(),"</A>");
        }
        //<< . . write YCR,"</TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
      } while(false);
    } while(false);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< GetDisplayOrder(pstrForm,pstrLanguage)
  public Object GetDisplayOrder(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrLanguage = m$.newVarRef("pstrLanguage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the correct order for the Tabs. The is based on the Display Position on WWW1203.
    //<< ;
    //<< ; If the display position is blank, we do a linear probe for the next open position.
    //<< ;
    //<< ; Params:
    //<< ; pstrForm    : The form to display the tabs on
    //<< ; pstrLanguage: The language of the current user.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Oct-2006   RPW     SRBR014072: Use the new security checking, so we only
    //<< ;                           send out the final to be displayed entries.
    //<< ; 20-Feb-2006   JW      SR14134: Removed hole check (Okayed by RW)
    //<< ; 01-Feb-2006   RobertW SR14094: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intHole,intLoop,intPos,intPrevPos,intTab,objWWW1203,strDrawOrder,strForm,strLanguage
    mVar intHole = m$.var("intHole");
    mVar intLoop = m$.var("intLoop");
    mVar intPos = m$.var("intPos");
    mVar intPrevPos = m$.var("intPrevPos");
    mVar intTab = m$.var("intTab");
    mVar objWWW1203 = m$.var("objWWW1203");
    mVar strDrawOrder = m$.var("strDrawOrder");
    mVar strForm = m$.var("strForm");
    mVar strLanguage = m$.var("strLanguage");
    m$.newVar(intHole,intLoop,intPos,intPrevPos,intTab,objWWW1203,strDrawOrder,strForm,strLanguage);
    //<< 
    //<< set strForm      = $$^WWWUMLAU(pstrForm,$$$YES)
    strForm.set(m$.fnc$("WWWUMLAU.main",pstrForm.get(),include.COMSYS.$$$YES(m$)));
    //<< set strLanguage  = $$^WWWUMLAU(pstrLanguage,$$$YES)
    strLanguage.set(m$.fnc$("WWWUMLAU.main",pstrLanguage.get(),include.COMSYS.$$$YES(m$)));
    //<< set strDrawOrder = ""
    strDrawOrder.set("");
    //<< 
    //<< set intPos = ""
    intPos.set("");
    //<< for {
    for (;true;) {
      //<< set intPos = $order(^WWW1203s(0,1,strForm,strLanguage,intPos))
      intPos.set(m$.Fnc.$order(m$.var("^WWW1203s",0,1,strForm.get(),strLanguage.get(),intPos.get())));
      //<< quit:intPos=""
      if (mOp.Equal(intPos.get(),"")) {
        break;
      }
      //<< 
      //<< set intTab = ""
      intTab.set("");
      //<< for {
      for (;true;) {
        //<< set intTab = $order(^WWW1203s(0,1,strForm,strLanguage,intPos,intTab))
        intTab.set(m$.Fnc.$order(m$.var("^WWW1203s",0,1,strForm.get(),strLanguage.get(),intPos.get(),intTab.get())));
        //<< quit:intTab=""
        if (mOp.Equal(intTab.get(),"")) {
          break;
        }
        //<< 
        //<< if (intPos'=" ") && ($piece(strDrawOrder,Y,intPos)="") {
        if ((mOp.NotEqual(intPos.get()," ")) && (mOp.Equal(m$.Fnc.$piece(strDrawOrder.get(),m$.var("Y").get(),intPos.get()),""))) {
          //<< set intLoop = intPos
          intLoop.set(intPos.get());
        }
        //<< } else {
        else {
          //<< for intLoop=1:1 {
          for (intLoop.set(1);(true);intLoop.set(mOp.Add(intLoop.get(),1))) {
            //<< quit:$piece(strDrawOrder,Y,intLoop)=""
            if (mOp.Equal(m$.Fnc.$piece(strDrawOrder.get(),m$.var("Y").get(),intLoop.get()),"")) {
              break;
            }
          }
        }
        //<< }
        //<< }
        //<< 
        //<< set objWWW1203 = $$GET^WWW1203(pstrForm,pstrLanguage,intTab)
        objWWW1203.set(m$.fnc$("WWW1203.GET",pstrForm.get(),pstrLanguage.get(),intTab.get()));
        //<< if $$ACCESS^WWW1203($$$WWW1203UsersAccess(objWWW1203),$$$WWW1203AccessForModule(objWWW1203)) {
        if (mOp.Logical(m$.fnc$("WWW1203.ACCESS",include.WWWConst.$$$WWW1203UsersAccess(m$,objWWW1203),include.WWWConst.$$$WWW1203AccessForModule(m$,objWWW1203)))) {
          //<< set $piece(strDrawOrder,Y,intLoop) = intTab
          m$.pieceVar(strDrawOrder,m$.var("Y").get(),intLoop.get()).set(intTab.get());
        }
      }
      //<< }
      //<< }
      //<< set intPrevPos = intPos
      intPrevPos.set(intPos.get());
    }
    //<< }
    //<< quit strDrawOrder
    return strDrawOrder.get();
  }

  //<< 
  //<< 
  //<< getTabColor(blnActiveTab)
  public Object getTabColor(Object ... _p) {
    mVar blnActiveTab = m$.newVarRef("blnActiveTab",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns the tab color. It depends if the tab is active or inactive.
    //<< ;
    //<< ; Params:
    //<< ;   blnActiveTab: if true, the tab is active.
    //<< ;
    //<< ; Returns: the color of the tab.
    //<< ;
    //<< ; History:
    //<< ; 11-May-2006   FrankF  SR14556: Customize Tabs
    //<< ;-------------------------------------------------------------------------------
    //<< new idColor,objCompany,strColor
    mVar idColor = m$.var("idColor");
    mVar objCompany = m$.var("objCompany");
    mVar strColor = m$.var("strColor");
    m$.newVar(idColor,objCompany,strColor);
    //<< 
    //<< set strColor   = ""
    strColor.set("");
    //<< set objCompany = $get(^WWW012(0,YM,1))
    objCompany.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< 
    //<< if blnActiveTab {
    if (mOp.Logical(blnActiveTab.get())) {
      //<< set idColor = $$$WWW012ActiveTabColor(objCompany)
      idColor.set(include.WWWConst.$$$WWW012ActiveTabColor(m$,objCompany));
      //<< if idColor'="" set strColor = $$$SysEnum("FARBE",idColor)
      if (mOp.NotEqual(idColor.get(),"")) {
        strColor.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",idColor));
      }
      //<< if strColor="" set strColor = YSILVER
      if (mOp.Equal(strColor.get(),"")) {
        strColor.set(m$.var("YSILVER").get());
      }
    }
    //<< 
    //<< } else {
    else {
      //<< set idColor = $$$WWW012InactiveTabColor(objCompany)
      idColor.set(include.WWWConst.$$$WWW012InactiveTabColor(m$,objCompany));
      //<< if idColor'="" set strColor = $$$SysEnum("FARBE",idColor)
      if (mOp.NotEqual(idColor.get(),"")) {
        strColor.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",idColor));
      }
      //<< if strColor="" set strColor = "darkgray"
      if (mOp.Equal(strColor.get(),"")) {
        strColor.set("darkgray");
      }
    }
    //<< }
    //<< quit strColor
    return strColor.get();
  }

  //<< 
  //<< 
  //<< getTabTextColor(blnActiveTab)
  public Object getTabTextColor(Object ... _p) {
    mVar blnActiveTab = m$.newVarRef("blnActiveTab",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns the tab text color. It depends if the tab is active or inactive.
    //<< ;
    //<< ; Params:
    //<< ;   blnActiveTab: if true, the tab is active.
    //<< ;
    //<< ; Returns: the color of the tab text.
    //<< ;
    //<< ; History:
    //<< ; 11-May-2006   FrankF  SR14556: Customize Tabs
    //<< ;-------------------------------------------------------------------------------
    //<< new idColor,objCompany,strColor
    mVar idColor = m$.var("idColor");
    mVar objCompany = m$.var("objCompany");
    mVar strColor = m$.var("strColor");
    m$.newVar(idColor,objCompany,strColor);
    //<< 
    //<< set strColor   = "black"
    strColor.set("black");
    //<< set objCompany = $get(^WWW012(0,0,1))
    objCompany.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
    //<< 
    //<< if blnActiveTab {
    if (mOp.Logical(blnActiveTab.get())) {
      //<< set idColor = $$$WWW012ActiveTabTextColor(objCompany)
      idColor.set(include.WWWConst.$$$WWW012ActiveTabTextColor(m$,objCompany));
      //<< if idColor'="" set strColor = $$$SysEnum("FARBE",idColor)
      if (mOp.NotEqual(idColor.get(),"")) {
        strColor.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",idColor));
      }
    }
    //<< 
    //<< } else {
    else {
      //<< set idColor = $$$WWW012InactiveTabTextColor(objCompany)
      idColor.set(include.WWWConst.$$$WWW012InactiveTabTextColor(m$,objCompany));
      //<< if idColor'="" set strColor = $$$SysEnum("FARBE",idColor)
      if (mOp.NotEqual(idColor.get(),"")) {
        strColor.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",idColor));
      }
    }
    //<< }
    //<< quit strColor
    return strColor.get();
  }

  //<< 
  //<< GetFlags(pintTab,pblnRequired=$$$NO,pblnImportant=$$$NO)
  public Object GetFlags(Object ... _p) {
    mVar pintTab = m$.newVarRef("pintTab",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnRequired = m$.newVarRef("pblnRequired",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar pblnImportant = m$.newVarRef("pblnImportant",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Finds out if there are any Mandatory of Important fields on this tab.
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 06-Mar-2013   shobby  CORE-71: Creation
    //<< ;-------------------------------------------------------------------------------
    //<< new idWWW122,objWWW122
    mVar idWWW122 = m$.var("idWWW122");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(idWWW122,objWWW122);
    //<< 
    //<< set idWWW122="" for { set idWWW122=$order(^WWW122(0,YFORM,idWWW122)) quit:idWWW122=""
    idWWW122.set("");
    for (;true;) {
      idWWW122.set(m$.Fnc.$order(m$.var("^WWW122",0,m$.var("YFORM").get(),idWWW122.get())));
      if (mOp.Equal(idWWW122.get(),"")) {
        break;
      }
      //<< quit:(pblnRequired && pblnImportant)
      if ((mOp.Logical(pblnRequired.get()) && mOp.Logical(pblnImportant.get()))) {
        break;
      }
      //<< set objWWW122=$$Get^WWW122(YFORM,idWWW122)
      objWWW122.set(m$.fnc$("WWW122.Get",m$.var("YFORM").get(),idWWW122.get()));
      //<< if $$$WWW122DisplayOnPageNumber(objWWW122)=pintTab {
      if (mOp.Equal(include.WWWConst.$$$WWW122DisplayOnPageNumber(m$,objWWW122),pintTab.get())) {
        //<< if $$$WWW122SequenceNumber(objWWW122)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122),"")) {
          //<< if $piece(YFELD,Y,$$$WWW122SequenceNumber(objWWW122))="" {      ;Don't worry if field already has data
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122)),"")) {
            //<< if 'pblnRequired  set pblnRequired  = $$$WWW122MandatoryInputItem(objWWW122)
            if (mOp.Not(pblnRequired.get())) {
              pblnRequired.set(include.WWWConst.$$$WWW122MandatoryInputItem(m$,objWWW122));
            }
            //<< if 'pblnImportant set pblnImportant = $$$WWW122ImportantContent(objWWW122)
            if (mOp.Not(pblnImportant.get())) {
              pblnImportant.set(include.WWWConst.$$$WWW122ImportantContent(m$,objWWW122));
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< GetFlags2(pintTab,pblnRequired=$$$NO,pblnImportant=$$$NO)
  public Object GetFlags2(Object ... _p) {
    mVar pintTab = m$.newVarRef("pintTab",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnRequired = m$.newVarRef("pblnRequired",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar pblnImportant = m$.newVarRef("pblnImportant",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Finds out if there are any Mandatory of Important fields on this tab.
    //<< ;
    //<< ;   NOTE:   Don't use.  Faster but doesn't consider 'required' defined at a class level
    //<< ;           Not to mention that it requires a number of indices.
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 06-Mar-2013   shobby  CORE-71: Creation
    //<< ;-------------------------------------------------------------------------------
    //<< new id,objWWW122,arrFields,idWWW122
    mVar id = m$.var("id");
    mVar objWWW122 = m$.var("objWWW122");
    mVar arrFields = m$.var("arrFields");
    mVar idWWW122 = m$.var("idWWW122");
    m$.newVar(id,objWWW122,arrFields,idWWW122);
    //<< 
    //<< set id="" for { set id=$order(^WWW122s(0,8,pintTab,1,YFORM,id)) quit:id=""
    id.set("");
    for (;true;) {
      id.set(m$.Fnc.$order(m$.var("^WWW122s",0,8,pintTab.get(),1,m$.var("YFORM").get(),id.get())));
      if (mOp.Equal(id.get(),"")) {
        break;
      }
      //<< set arrFields(id)=""
      arrFields.var(id.get()).set("");
    }
    //<< }
    //<< set id="" for { set id=$order(^WWW122s(0,9,pintTab,1,YFORM,id)) quit:id=""
    id.set("");
    for (;true;) {
      id.set(m$.Fnc.$order(m$.var("^WWW122s",0,9,pintTab.get(),1,m$.var("YFORM").get(),id.get())));
      if (mOp.Equal(id.get(),"")) {
        break;
      }
      //<< set arrFields(id)=""
      arrFields.var(id.get()).set("");
    }
    //<< }
    //<< set id="" for { set id=$order(^WWW122Ds(0,8,pintTab,1,YM,YFORM,id)) quit:id=""
    id.set("");
    for (;true;) {
      id.set(m$.Fnc.$order(m$.var("^WWW122Ds",0,8,pintTab.get(),1,m$.var("YM").get(),m$.var("YFORM").get(),id.get())));
      if (mOp.Equal(id.get(),"")) {
        break;
      }
      //<< set arrFields(id)=""
      arrFields.var(id.get()).set("");
    }
    //<< }
    //<< set id="" for { set id=$order(^WWW122Ds(0,8," ",1,YM,YFORM,id)) quit:id=""
    id.set("");
    for (;true;) {
      id.set(m$.Fnc.$order(m$.var("^WWW122Ds",0,8," ",1,m$.var("YM").get(),m$.var("YFORM").get(),id.get())));
      if (mOp.Equal(id.get(),"")) {
        break;
      }
      //<< ; Here we need to consider that customisation may change the Required status but not the tab.
      //<< ; so get Required fields for blank tabs.  May lead to a few extras but they will be filtered out below.
      //<< set arrFields(id)=""
      arrFields.var(id.get()).set("");
    }
    //<< }
    //<< set idWWW122="" for { set idWWW122=$order(arrFields(idWWW122)) quit:idWWW122=""
    idWWW122.set("");
    for (;true;) {
      idWWW122.set(m$.Fnc.$order(arrFields.var(idWWW122.get())));
      if (mOp.Equal(idWWW122.get(),"")) {
        break;
      }
      //<< quit:(pblnRequired && pblnImportant)
      if ((mOp.Logical(pblnRequired.get()) && mOp.Logical(pblnImportant.get()))) {
        break;
      }
      //<< set objWWW122=$$Get^WWW122(YFORM,idWWW122)
      objWWW122.set(m$.fnc$("WWW122.Get",m$.var("YFORM").get(),idWWW122.get()));
      //<< if $$$WWW122DisplayOnPageNumber(objWWW122)=pintTab {
      if (mOp.Equal(include.WWWConst.$$$WWW122DisplayOnPageNumber(m$,objWWW122),pintTab.get())) {
        //<< if $$$WWW122SequenceNumber(objWWW122)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122),"")) {
          //<< if $piece(YFELD,Y,$$$WWW122SequenceNumber(objWWW122))="" {      ;Don't worry if field already has data
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122)),"")) {
            //<< set pblnRequired  = pblnRequired  || $$$WWW122MandatoryInputItem(objWWW122)
            pblnRequired.set(mOp.Logical(pblnRequired.get()) || mOp.Logical(include.WWWConst.$$$WWW122MandatoryInputItem(m$,objWWW122)));
            //<< set pblnImportant = pblnImportant || $$$WWW122ImportantContent(objWWW122)
            pblnImportant.set(mOp.Logical(pblnImportant.get()) || mOp.Logical(include.WWWConst.$$$WWW122ImportantContent(m$,objWWW122)));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

//<< 
}
