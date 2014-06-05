//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWKOPF
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:34
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
//<< #include INConst
import include.INConst;
//<< #include WWWConst
import include.WWWConst;

//<< WWWKOPF(YKOPF)
public class WWWKOPF extends mClass {

  //<< 
  //<< #define jsMarker(%1)
  public static Object $$$jsMarker(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public Object main(Object ... _p) {
    mVar YKOPF = m$.newVarRef("YKOPF",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWKOPF(YKOPF);
  }

  public Object _WWWKOPF(Object ... _p) {
    mVar YKOPF = m$.newVarRef("YKOPF",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< #;define jsMarker(%1)   write YCR,YCR,"<!-- ************************* ",%1," (WWWKOPF)************************* -->",YCR,YCR
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Displays System Heading, including [logoff] button
    //<< ;       HTML Heading          HTMLKOPF
    //<< ;
    //<< ; Inputs :
    //<< ;   YKOPF   Current page title
    //<< ;
    //<< ; ByRef :
    //<< ;   ^WWWVAR variables
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 20-Jun-2013   shobby  CORE-127: Missing TR and TD could cause MegaMenu to appear above the buttons in firefox.
    //<< ; 07-Jun-2013   shobby  CORE-123: Removed extra border on MegaMenu
    //<< ; 06-Jun-2013   shobby  CORE-116.2: MegaMenu created in WWWBODY for COMViewSearch forms.
    //<< ; 05-Jun-2013   shobby  CORE-116: Create MegaMenu at this point.
    //<< ; 30-Apr-2012   shobby  SR17998: More detailed determination as to whether to show
    //<< ;                       form header.
    //<< ; 11-Dec-2009   GRF     SR16871: class macros, cleanup, doco
    //<< ; 15-Oct-2009   shobby  SR16925: Only translate header if a language code exists.
    //<< ; 06-Jan-2009   FIS     don't use gradient filter with system colors
    //<< ; 15-Dec-2008   HQN     Added additional notes regarding functionality
    //<< ; 25-Jul-2007   RPW     SRadhoc: Rewrote in { syntax
    //<< ; 07-May-2007   GRF     SR15511: Doco; quits; expand commands
    //<< ; 13-Dec-2006   JW      BR014262: Rewrite. Use GetType fn.
    //<< ; 18-Sep-2006   JW      Cleaned up.
    //<< ; 31-May-2005   RPW     Added the job to the tooltip.
    //<< ; 28.04.1998    DT      GEAENDERT=57916,57692
    //<< ;-------------------------------------------------------------------------------
    //<< new YA,YQ,YVOR1,objWWW120
    mVar YA = m$.var("YA");
    mVar YQ = m$.var("YQ");
    mVar YVOR1 = m$.var("YVOR1");
    mVar objWWW120 = m$.var("objWWW120");
    m$.newVar(YA,YQ,YVOR1,objWWW120);
    //<< 
    //<< quit:$get(YKOPF)=""
    if (mOp.Equal(m$.Fnc.$get(YKOPF),"")) {
      return null;
    }
    //<< 
    //<< ; FIXME : Precludes text codes with alpha prefixes but if that is allowed we
    //<< ;         might have a problem with hard-coded heading strings.
    //<< if +YKOPF'=0 if $data(^WWW009(0,SPRACHE,YKOPF)) if $$^WWWTEXT(YKOPF)'=YKOPF set YKOPF = $$^WWWTEXT(YKOPF)  ; Convert text code to heading text
    if (mOp.NotEqual(mOp.Positive(YKOPF.get()),0)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW009",0,m$.var("SPRACHE").get(),YKOPF.get())))) {
        if (mOp.NotEqual(m$.fnc$("WWWTEXT.main",YKOPF.get()),YKOPF.get())) {
          YKOPF.set(m$.fnc$("WWWTEXT.main",YKOPF.get()));
        }
      }
    }
    //<< set YVOR1 = $get(^WWW012(0,0,1))  ; General Company Parameters
    YVOR1.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
    //<< 
    //<< ;---------------------------------------
    //<< set YQ = $$$YQEnable
    YQ.set(include.COMSYSWWW.$$$YQEnable(m$));
    //<< if $$DoNotDisplayFormHeader^WWW120(YFORM) set YQ=1 ;SR17998
    if (mOp.Logical(m$.fnc$("WWW120.DoNotDisplayFormHeader",m$.var("YFORM").get()))) {
      YQ.set(1);
    }
    //<< ;SR17998 if $get(YFORM)'="" {
    //<< ;SR17998    set objWWW120 = $get(^WWW120(0,YFORM,1))
    //<< ;SR17998    if $$$WWW120DoNOTDisplayFormHeader(objWWW120) {
    //<< ;SR17998        set YQ = 1
    //<< ;SR17998    } elseif $$$WWW120InheritCompanyProperties(objWWW120) {
    //<< ;SR17998        if $$$WWW012DoNotDisplayHeader(YVOR1) set YQ = 1
    //<< ;SR17998    }
    //<< ;SR17998 }
    //<< 
    //<< quit:YQ=1
    if (mOp.Equal(YQ.get(),1)) {
      return null;
    }
    //<< ;---------------------------------------
    //<< 
    //<< 
    //<< if $get(YUSER)'="" set $piece(^WWWUSER(0,YUSER,1),Y,10)=$$$YES  ; Display Form heading ?
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),10).set(include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< $$$jsMarker("Form Title")
    $$$jsMarker(m$,"Form Title");
    //<< 
    //<< write "<NOBR id='NOBR'>" ;SR1799
    m$.Cmd.Write("<NOBR id='NOBR'>");
    //<< if $$$WWW013MenuType($get(^WWW013(0,YBED,1))) = 13 {                                        ;CORE-123
    if (mOp.Equal(include.WWWConst.$$$WWW013MenuType(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))),13)) {
      //<< write "<table id=""FRAME_Header"" width=""100%"" border=""0"" cellspacing=""0"" cellpadding=""0"">"          ;CORE-123
      m$.Cmd.Write("<table id=\"FRAME_Header\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
    }
    //<< } else {                                                                                    ;CORE-123
    else {
      //<< do ^WWWFRAME(0,,,"FRAME_Header") ; open table ;CORE-81                                  ;CORE-123
      m$.Cmd.Do("WWWFRAME.main",0,null,null,"FRAME_Header");
    }
    //<< }                                                                                           ;CORE-123
    //<< 
    //<< if ($$GetType^WWWMENU()=7) {       ; POPUP
    if ((mOp.Equal(m$.fnc$("WWWMENU.GetType"),7))) {
      //<< do V3
      m$.Cmd.Do("V3");
    }
    //<< } else {
    else {
      //<< if ($$$WWW013MenuType($get(^WWW013(0,YBED,1)))=13)&&(YFORM'="")&&($$$WWW120FormType($get(^WWW120(0,YFORM,1)))'=12) {
      if ((mOp.Equal(include.WWWConst.$$$WWW013MenuType(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))),13)) && (mOp.NotEqual(m$.var("YFORM").get(),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1))),12))) {
        //<< if YFORM'="COMViewSearch" {
        if (mOp.NotEqual(m$.var("YFORM").get(),"COMViewSearch")) {
          //<< write "<TR><TD>"    ;CORE-127
          m$.Cmd.Write("<TR><TD>");
          //<< write $$GetMegaMenu^WWWMegaMenu(YKOPF) //SR17998 ;CORE-116 ;CORE-116.2
          m$.Cmd.Write(m$.fnc$("WWWMegaMenu.GetMegaMenu",YKOPF.get()));
          //<< write "</TD></TR>"  ;CORE-127
          m$.Cmd.Write("</TD></TR>");
        }
      }
      //<< }
      //<< } else {
      else {
        //<< do V2
        m$.Cmd.Do("V2");
      }
    }
    //<< }
    //<< }
    //<< do ^WWWFRAME(1)                    ; close table
    m$.Cmd.Do("WWWFRAME.main",1);
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< V1
  public void V1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; VERSION CLASSIC
    //<< ; NOTE: Not currently in use
    //<< ;
    //<< ; History:
    //<< ; 09-Aug-2007   shobby  BR014237: Call to CreateLoginLink so that pressing the X
    //<< ;                           button will go back to the login screen.
    //<< ; 09-Dec-2005   JW      SR13195: Removed confirm msg
    //<< ;-------------------------------------------------------------------------------
    //<< write YCR,"<TR bgcolor=0>",YCR
    m$.Cmd.Write(m$.var("YCR").get(),"<TR bgcolor=0>",m$.var("YCR").get());
    //<< 
    //<< write "<TD bgcolor=midnightblue align=left nowrap>"
    m$.Cmd.Write("<TD bgcolor=midnightblue align=left nowrap>");
    //<< write "<font color=white size=3>"
    m$.Cmd.Write("<font color=white size=3>");
    //<< write "<b>",YCR
    m$.Cmd.Write("<b>",m$.var("YCR").get());
    //<< 
    //<< do ^WWWUP($$$NO)
    m$.Cmd.Do("WWWUP.main",include.COMSYS.$$$NO(m$));
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< if '$find(YKOPF,".gif") write "&nbsp;"_$$^WWWUML($translate(YKOPF,"_"," "))     ; überschrift
    if (mOp.Not(m$.Fnc.$find(m$.var("YKOPF").get(),".gif"))) {
      m$.Cmd.Write(mOp.Concat("&nbsp;",m$.fnc$("WWWUML.main",m$.Fnc.$translate(m$.var("YKOPF").get(),"_"," "))));
    }
    //<< write " ["_$get(YUCI)_"/"_$get(YM)_"]"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" [",m$.Fnc.$get(m$.var("YUCI"))),"/"),m$.Fnc.$get(m$.var("YM"))),"]"));
    //<< write " </B>"
    m$.Cmd.Write(" </B>");
    //<< write "</td>",YCR
    m$.Cmd.Write("</td>",m$.var("YCR").get());
    //<< 
    //<< write "<TD bgcolor=silver align=right width=20>"
    m$.Cmd.Write("<TD bgcolor=silver align=right width=20>");
    //<< do CreateLoginLink()
    m$.Cmd.Do("CreateLoginLink");
    //<< write "</TD>",YCR
    m$.Cmd.Write("</TD>",m$.var("YCR").get());
    //<< 
    //<< write "</TR>",YCR
    m$.Cmd.Write("</TR>",m$.var("YCR").get());
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< CreateLoginLink()
  public Object CreateLoginLink(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Draw the hyperlink nicely.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Feb-2010   shobby  SR17176: Try and Catch to stop error when cancelling 'Discard
    //<< ;                           Changes' message box.
    //<< ; 16-Oct-2009   shobby  SR16948: Can't use $job as a subscript to preserve URL
    //<< ;                           in CacheTempURL
    //<< ; 09-Aug-2007   shobby  SRBR014237: Renamed from Blank and changed to call out
    //<< ;                           to the login screen.
    //<< ; 25-Jul-2007   RPW     SRadhoc: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strURL
    mVar strURL = m$.var("strURL");
    m$.newVar(strURL);
    //<< 
    //<< set strURL = $get(^CacheTempURL(YUCI,YUSER))
    strURL.set(m$.Fnc.$get(m$.var("^CacheTempURL",m$.var("YUCI").get(),m$.var("YUSER").get())));
    //<< if strURL="" set strURL = $$getLoginPage^WWWLogin()
    if (mOp.Equal(strURL.get(),"")) {
      strURL.set(m$.fnc$("WWWLogin.getLoginPage"));
    }
    //<< write "<A onClick="""
    m$.Cmd.Write("<A onClick=\"");
    //<< write "try {"                                               ;SR17176
    m$.Cmd.Write("try {");
    //<< ;write " top.document.location.href='"_strURL_"'; "
    //<< write " window.top.location.href='"_strURL_"'; "
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" window.top.location.href='",strURL.get()),"'; "));
    //<< write "} catch (e) { }"
    m$.Cmd.Write("} catch (e) { }");
    //<< write """>"                                                 ;SR17176
    m$.Cmd.Write("\">");
    //<< write "<IMG SRC="""_YGIF_"exit.gif"" ALIGN=ABSBOTTOM TITLE="_$$^WWWTEXT(33980)_" border=0>"   ; "Logout"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"exit.gif\" ALIGN=ABSBOTTOM TITLE="),m$.fnc$("WWWTEXT.main",33980))," border=0>"));
    //<< write "</A>"
    m$.Cmd.Write("</A>");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Form Header  (0/1/Locn/USER)                     | AlphaLinc 1.23.45 | (o) [X]    V2^WWWKOPF
  //<< ;-------------------------------------------------------------------------------
  //<< ;  [Button Line]
  //<< ;---------------------------------------
  //<< ;
  //<< ;
  //<< ;  [Form]
  //<< ;
  //<< ;
  //<< ;---------------------------------------
  //<< ;  [Page End]
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< ; <TR>
  //<< ;   <TD NOWRAP BGCOLOR=xxx style=" border-right:none;" ALIGN=LEFT>
  //<< ;        [Start Anchor] [Form Header] [Session Information]
  //<< ;   </TD>
  //<< ;   <TD> [Version No.]    </TD>
  //<< ; [ <TD> [Flexible Menu]  </TD> ]
  //<< ;   <TD> [Login Link  X button]     </TD>
  //<< ; </TR>
  //<< 
  //<< V2
  public void V2() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; VERSION IN EINER FARBE ;with single colour
    //<< ;
    //<< ; History:
    //<< ; 25-Feb-2011   GRF     SR17661: Pass ColorCodeForHeaderRight to Warning Light
    //<< ; 08-Feb-2011   shobby  SR17657: Dashboard indicator on RHS
    //<< ; 22-Sep-2010   GRF     SR17515: "FARBE" property is not language based; missing
    //<< ;                           </font>
    //<< ; 21-May-2010   shobby  SR17316: Missing >
    //<< ; 22-Apr-2010   shobby  SR17253: Cross Browser Support
    //<< ; 01-Sep-2009   PPP     SRAdhoc: Add the version #,and the ability to add some
    //<< ;                           Text (e.g. BETA)
    //<< ; 16-Dec-2008   HQN     SR16240: Detect menu type 10, show links
    //<< ; 12-Dec-2008   HQN     SR16240: Moved System Information Tooltip building to
    //<< ;                           $$GetSystemInfoTooltip for code reuse.
    //<< ; 16-Sep-2008   shobby  BR014983: Allow calling out to external routines.
    //<< ;                           Called from form or customisation.
    //<< ; 16-Sep-2007   shobby  BR014983: Put the location name back in (and tidied up
    //<< ;                           some 'new line' issues in the tooltip)
    //<< ; 24-Oct-2007   GRF     Separation of IP and Form
    //<< ; 09-Aug-2007   shobby  BR014237: Call to CreateLoginLink so that pressing the X
    //<< ;                           button will go back to the login screen.
    //<< ; 25-Jul-2007   RPW     SRadhoc: Rewrote in { syntax
    //<< ; 09-Dec-2005   JW      SR13195: Removed confirm msg
    //<< ; 25.04.2005    FIS     SR12200: $$$WWW0121ColorTableHeader
    //<< ; 11.12.2003    FIS     colour on the right
    //<< ;-------------------------------------------------------------------------------
    //<< new COLOR,COLORR,strHeader
    mVar COLOR = m$.var("COLOR");
    mVar COLORR = m$.var("COLORR");
    mVar strHeader = m$.var("strHeader");
    m$.newVar(COLOR,COLORR,strHeader);
    //<< 
    //<< ;   D101        $$$WWW012ColorCodeForHeaderLeft()
    //<< ;   D147        $$$WWW012ColorCodeForHeaderRight()
    //<< ;
    //<< ;   D112        $$$WWW120InDevelopmentBy    => RED
    //<< ;
    //<< ;   D75         $$$WWW0121ColorTableHeader
    //<< 
    //<< set COLOR=""
    COLOR.set("");
    //<< if $piece(YVOR1,Y,101)'="" set COLOR = $piece($get(^WWW100(0,"FARBE","EN",$piece(YVOR1,Y,101),1)),Y,1)
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),101),"")) {
      COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),101),1)),m$.var("Y").get(),1));
    }
    //<< if COLOR="" set COLOR = "DIMGRAY"
    if (mOp.Equal(COLOR.get(),"")) {
      COLOR.set("DIMGRAY");
    }
    //<< 
    //<< set COLORR = $piece(YVOR1,Y,147)
    COLORR.set(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),147));
    //<< if COLORR'="" set COLORR = $piece($get(^WWW100(0,"FARBE","EN",COLORR,1)),Y,1)
    if (mOp.NotEqual(COLORR.get(),"")) {
      COLORR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",COLORR.get(),1)),m$.var("Y").get(),1));
    }
    //<< if COLORR=""  set COLORR = COLOR
    if (mOp.Equal(COLORR.get(),"")) {
      COLORR.set(COLOR.get());
    }
    //<< 
    //<< if ($get(YFORM)'="") && ($piece($get(^WWW120(0,YFORM,1)),Y,112)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),112),""))) {
      //<< set COLOR  = "RED"
      COLOR.set("RED");
      //<< set COLORR = "RED"
      COLORR.set("RED");
    }
    //<< }
    //<< if ($get(YLOCATION)'="") && (+$piece($get(^WWW0121(0,0,YLOCATION,1)),Y,75)'=0) {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YLOCATION")),"")) && (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0121",0,0,m$.var("YLOCATION").get(),1)),m$.var("Y").get(),75)),0))) {
      //<< set COLOR  = $piece($get(^WWW100(0,"FARBE","EN",$piece($get(^WWW0121(0,0,YLOCATION,1)),Y,75),1)),Y,1)
      COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0121",0,0,m$.var("YLOCATION").get(),1)),m$.var("Y").get(),75),1)),m$.var("Y").get(),1));
      //<< set COLORR = COLOR
      COLORR.set(COLOR.get());
    }
    //<< }
    //<< 
    //<< write YCR,"<TR>",YCR
    m$.Cmd.Write(m$.var("YCR").get(),"<TR>",m$.var("YCR").get());
    //<< 
    //<< ;---------------------------------------
    //<< ; Form Header
    //<< ;---------------------------------------
    //<< write "<TD NOWRAP"
    m$.Cmd.Write("<TD NOWRAP");
    //<< write " BGCOLOR="_COLOR  ;für netscape & co.
    m$.Cmd.Write(mOp.Concat(" BGCOLOR=",COLOR.get()));
    //<< write " style="""
    m$.Cmd.Write(" style=\"");
    //<< if $piece(YVOR1,Y,101)'>256 write $$ImageTransformGradient^WWWFORMCrossBrowserSupportVisual(COLOR,COLORR) ;SR17253
    if (mOp.NotGreater(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),101),256)) {
      m$.Cmd.Write(m$.fnc$("WWWFORMCrossBrowserSupportVisual.ImageTransformGradient",COLOR.get(),COLORR.get()));
    }
    //<< ;SR17253 IF $PIECE(YVOR1,Y,101)'>256 WRITE "filter:progid:DXImageTransform.Microsoft.Gradient(GradientType=1, StartColorStr='"_COLOR_"', EndColorStr='"_COLORR_"');"  ;FIS;11.12.03  ;SR16236 system colors
    //<< write " border-right:none;"
    m$.Cmd.Write(" border-right:none;");
    //<< write """"                  ; end style
    m$.Cmd.Write("\"");
    //<< write " ALIGN=LEFT><FONT SIZE=3 COLOR="_YWHITE_">",YCR
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" ALIGN=LEFT><FONT SIZE=3 COLOR=",m$.var("YWHITE").get()),">"),m$.var("YCR").get());
    //<< 
    //<< do ^WWWUP($$$NO)
    m$.Cmd.Do("WWWUP.main",include.COMSYS.$$$NO(m$));
    //<< 
    //<< write "<B>",YCR
    m$.Cmd.Write("<B>",m$.var("YCR").get());
    //<< set strHeader = $$FormHeaderOrImageFile^WWW120(YFORM)
    strHeader.set(m$.fnc$("WWW120.FormHeaderOrImageFile",m$.var("YFORM").get()));
    //<< if $extract(strHeader)="@" {
    if (mOp.Equal(m$.Fnc.$extract(strHeader.get()),"@")) {
      //<< xecute $extract(strHeader,2,$length(strHeader))
      m$.Cmd.Xecute(m$.Fnc.$extract(strHeader.get(),2,m$.Fnc.$length(strHeader.get())));
    }
    //<< } else {
    else {
      //<< IF '$FIND(YKOPF,".gif") {
      if (mOp.Not(m$.Fnc.$find(m$.var("YKOPF").get(),".gif"))) {
        //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
        if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
          //<< if ((YFORM = "INDispenseToPatient") && (YPARA = 1)) {
          if (mOp.Logical(((mOp.Equal(m$.var("YFORM").get(),"INDispenseToPatient")) && (mOp.Equal(m$.var("YPARA").get(),1))))) {
            //<< WRITE $piece($get(^WWW004(YM,"VARMenuPrincipal","006.25",1)),Y,1)
            m$.Cmd.Write(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW004",m$.var("YM").get(),"VARMenuPrincipal","006.25",1)),m$.var("Y").get(),1));
          }
          //<< } else {
          else {
            //<< WRITE " "_$$^WWWUML($TRANSLATE(YKOPF,"_"," "))
            m$.Cmd.Write(mOp.Concat(" ",m$.fnc$("WWWUML.main",m$.Fnc.$translate(m$.var("YKOPF").get(),"_"," "))));
          }
        }
        //<< }
        //<< } else {
        else {
          //<< WRITE " "_$$^WWWUML($TRANSLATE(YKOPF,"_"," "))
          m$.Cmd.Write(mOp.Concat(" ",m$.fnc$("WWWUML.main",m$.Fnc.$translate(m$.var("YKOPF").get(),"_"," "))));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< write "</B>"
    m$.Cmd.Write("</B>");
    //<< 
    //<< ;---------------------------------------
    //<< ; Session Information (Company/Locn ID/Locn Name/User ID)
    //<< ;---------------------------------------
    //<< write " <FONT SIZE=1>"
    m$.Cmd.Write(" <FONT SIZE=1>");
    //<< if $get(YFORM)=""  {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"")) {
      //<< write "<A HREF=""#"""
      m$.Cmd.Write("<A HREF=\"#\"");
    }
    //<< 
    //<< } else {   ; Quick Location Change
    else {
      //<< write "<A HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM=WWW0131B&amp;YBACK="_YFORM_","_$$VAR1^WWWCGI(1)_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWW0131B&amp;YBACK="),m$.var("YFORM").get()),","),m$.fnc$("WWWCGI.VAR1",1)),"\""));
    }
    //<< }
    //<< write " STYLE=""color:"_YWHITE_""""
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.var("YWHITE").get()),"\""));
    //<< write " TITLE="""_$$GetSystemInfoTooltip() ; SR16240:
    m$.Cmd.Write(mOp.Concat(" TITLE=\"",m$.fnc$("GetSystemInfoTooltip")));
    //<< write """"
    m$.Cmd.Write("\"");
    //<< write ">",YCR
    m$.Cmd.Write(">",m$.var("YCR").get());
    //<< 
    //<< write " ("_YM
    m$.Cmd.Write(mOp.Concat(" (",m$.var("YM").get()));
    //<< if $get(YLOCATION)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLOCATION")),"")) {
      //<< write "/"_YLOCATION
      m$.Cmd.Write(mOp.Concat("/",m$.var("YLOCATION").get()));
      //<< write "/"_$piece($get(^WWW0121(0,0,YLOCATION,1)),Y,1)
      m$.Cmd.Write(mOp.Concat("/",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0121",0,0,m$.var("YLOCATION").get(),1)),m$.var("Y").get(),1)));
    }
    //<< }
    //<< write "/"_$get(YBED)
    m$.Cmd.Write(mOp.Concat("/",m$.Fnc.$get(m$.var("YBED"))));
    //<< write ")"
    m$.Cmd.Write(")");
    //<< write "</A>"
    m$.Cmd.Write("</A>");
    //<< 
    //<< do Calculator()
    m$.Cmd.Do("Calculator");
    //<< 
    //<< ;---------------------------------------
    //<< ; "In Development:"
    //<< ;---------------------------------------
    //<< if COLOR="RED" write $$^WWWTEXT(32978)_" "_$piece($get(^WWW120(0,YFORM,1)),Y,112)   ; FIXME : What if user has set colour to RED?
    if (mOp.Equal(COLOR.get(),"RED")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",32978)," "),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),112)));
    }
    //<< write "</FONT>"
    m$.Cmd.Write("</FONT>");
    //<< write "</TD>",YCR
    m$.Cmd.Write("</TD>",m$.var("YCR").get());
    //<< 
    //<< ;---------------------------------------
    //<< ; Version No
    //<< ;---------------------------------------
    //<< if '(+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Not((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
      //<< WRITE "<TD bgcolor="_COLORR_" align=center width=160>"  ;SR17316
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD bgcolor=",COLORR.get())," align=center width=160>"));
      //<< WRITE "<b>"
      m$.Cmd.Write("<b>");
      //<< WRITE "<font color=white size=1>"
      m$.Cmd.Write("<font color=white size=1>");
      //<< WRITE "AlphaLinc "_$$GetVersion()
      m$.Cmd.Write(mOp.Concat("AlphaLinc ",m$.fnc$("GetVersion")));
      //<< WRITE " </B>"
      m$.Cmd.Write(" </B>");
      //<< WRITE "</TD>"
      m$.Cmd.Write("</TD>");
    }
    //<< }
    //<< 
    //<< ; 10 = "Flexible Menu"
    //<< set objWWW013 = $get(^WWW013(0,YBED,1))
    mVar objWWW013 = m$.var("objWWW013");
    objWWW013.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
    //<< if ($$$WWW013MenuType(objWWW013) = 10) {
    if ((mOp.Equal(include.WWWConst.$$$WWW013MenuType(m$,objWWW013),10))) {
      //<< write "<td style=""background-color:"_COLORR_";text-align:right;width:20px;"">"_$$GetButtonStyle()_$$GetOverviewButton()_"</td>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<td style=\"background-color:",COLORR.get()),";text-align:right;width:20px;\">"),m$.fnc$("GetButtonStyle")),m$.fnc$("GetOverviewButton")),"</td>"));
      //<< write "<td style=""background-color:"_COLORR_";text-align:right;width:20px"">"_$$GetMenuButton()_"</td>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<td style=\"background-color:",COLORR.get()),";text-align:right;width:20px\">"),m$.fnc$("GetMenuButton")),"</td>"));
    }
    //<< }
    //<< if '(+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
    if (mOp.Not((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
      //<< do WarningIndicator^WWWDASHBOARD(COLORR) ; SR17657, SR17661
      m$.Cmd.Do("WWWDASHBOARD.WarningIndicator",COLORR.get());
    }
    //<< }
    //<< 
    //<< write "<TD bgcolor="_COLORR
    m$.Cmd.Write(mOp.Concat("<TD bgcolor=",COLORR.get()));
    //<< write " style=""border-left:none;"""
    m$.Cmd.Write(" style=\"border-left:none;\"");
    //<< write " align=right width=20>"
    m$.Cmd.Write(" align=right width=20>");
    //<< 
    //<< do CreateLoginLink()
    m$.Cmd.Do("CreateLoginLink");
    //<< write "</TD>",YCR
    m$.Cmd.Write("</TD>",m$.var("YCR").get());
    //<< write "</TR>",YCR
    m$.Cmd.Write("</TR>",m$.var("YCR").get());
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< GetVersion()
  public Object GetVersion(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the Version #
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-Sep-2009   PPP     SRAdhoc: If Build with a Odd Minor Release is loaded,
    //<< ;                           BETA is added to the Release (only if it is not DEV)
    //<< ; 01-Sep-2009   PPP     SRAdhoc: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strVer
    mVar strVer = m$.var("strVer");
    m$.newVar(strVer);
    //<< 
    //<< set strVer = $piece($get(^WWWVERSION(0,"AlphaLinc",1)),Y,1)
    strVer.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWVERSION",0,"AlphaLinc",1)),m$.var("Y").get(),1));
    //<< 
    //<< if $get(^Development)'=1 {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("^Development")),1)) {
      //<< set intMinor = $piece(strVer,".",2)
      mVar intMinor = m$.var("intMinor");
      intMinor.set(m$.Fnc.$piece(strVer.get(),".",2));
      //<< if intMinor#2 {
      if (mOp.Logical(mOp.Modulus(intMinor.get(),2))) {
        //<< set strVer = strVer _" BETA"
        strVer.set(mOp.Concat(strVer.get()," BETA"));
      }
    }
    //<< }
    //<< }
    //<< quit strVer
    return strVer.get();
  }

  //<< 
  //<< 
  //<< Calculator()
  public Object Calculator(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the calculator
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jul-2007   RPW     SRadhoc: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new OPT,URL
    mVar OPT = m$.var("OPT");
    mVar URL = m$.var("URL");
    m$.newVar(OPT,URL);
    //<< 
    //<< set URL = YAKTION_"EP=WWWFORM&amp;YFORM=WWWCALC&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM
    URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM=WWWCALC&amp;YUSER="),m$.var("YUSER").get()),"&amp;YBED="),m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()));
    //<< set OPT = "HEIGHT=260,WIDTH=220,SCROLLBARS=NO,RESIZEABLE=NO"
    OPT.set("HEIGHT=260,WIDTH=220,SCROLLBARS=NO,RESIZEABLE=NO");
    //<< 
    //<< write "<A TITLE=Calculator HREF=""#"" onclick="""
    m$.Cmd.Write("<A TITLE=Calculator HREF=\"#\" onclick=\"");
    //<< write "javascript:var calculator=window.open('"_URL_"','calculator','"_OPT_"');"">&nbsp;&nbsp;&nbsp;&nbsp;"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("javascript:var calculator=window.open('",URL.get()),"','calculator','"),OPT.get()),"');\">&nbsp;&nbsp;&nbsp;&nbsp;"));
    //<< write "</A>"
    m$.Cmd.Write("</A>");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< V3
  public void V3() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   VERSION WITH POPUP MENU
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Apr-2010   shobby  SR17253: Cross Browser Support
    //<< ; 09-Aug-2007   shobby  BR014237: Call to CreateLoginLink so that pressing the X
    //<< ;                           button will go back to the login screen.
    //<< ; 25-Jul-2007   RPW     SRadhoc: rewrite in { syntax
    //<< ;-------------------------------------------------------------------------------
    //<< new COLOR,COLORR
    mVar COLOR = m$.var("COLOR");
    mVar COLORR = m$.var("COLORR");
    m$.newVar(COLOR,COLORR);
    //<< 
    //<< set COLOR=""
    COLOR.set("");
    //<< if $piece(YVOR1,Y,101)'="" set COLOR=$piece($get(^WWW100(0,"FARBE","EN",$piece(YVOR1,Y,101),1)),Y,1)
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),101),"")) {
      COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),101),1)),m$.var("Y").get(),1));
    }
    //<< if COLOR="" set COLOR="DIMGRAY"
    if (mOp.Equal(COLOR.get(),"")) {
      COLOR.set("DIMGRAY");
    }
    //<< set COLORR=$piece(YVOR1,Y,147)  ;FARBE RECHTS;FIS;11.12.03 ;tincture on the right
    COLORR.set(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),147));
    //<< if COLORR'="" set COLORR=$piece($get(^WWW100(0,"FARBE","EN",COLORR,1)),Y,1)
    if (mOp.NotEqual(COLORR.get(),"")) {
      COLORR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",COLORR.get(),1)),m$.var("Y").get(),1));
    }
    //<< if COLORR=""  set COLORR=COLOR
    if (mOp.Equal(COLORR.get(),"")) {
      COLORR.set(COLOR.get());
    }
    //<< if ($get(YLOCATION)'="") && (+$piece($get(^WWW0121(0,0,YLOCATION,1)),Y,75)'=0) {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YLOCATION")),"")) && (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0121",0,0,m$.var("YLOCATION").get(),1)),m$.var("Y").get(),75)),0))) {
      //<< set COLOR  = $piece($get(^WWW100(0,"FARBE","EN",$piece($get(^WWW0121(0,0,YLOCATION,1)),Y,75),1)),Y,1)
      COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0121",0,0,m$.var("YLOCATION").get(),1)),m$.var("Y").get(),75),1)),m$.var("Y").get(),1));
      //<< set COLORR = COLOR
      COLORR.set(COLOR.get());
    }
    //<< }
    //<< 
    //<< write YCR,"<TR bgcolor=0>",YCR
    m$.Cmd.Write(m$.var("YCR").get(),"<TR bgcolor=0>",m$.var("YCR").get());
    //<< 
    //<< write "<TD"
    m$.Cmd.Write("<TD");
    //<< write " BGCOLOR="_COLOR  ;für netscape & co. ;to
    m$.Cmd.Write(mOp.Concat(" BGCOLOR=",COLOR.get()));
    //<< ;SR17253 IF $PIECE(YVOR1,Y,101)'>256 WRITE " style=""filter:progid:DXImageTransform.Microsoft.Gradient(GradientType=1, StartColorStr='"_COLOR_"', EndColorStr='"_COLORR_"');"""
    //<< if $piece(YVOR1,Y,101)'>256 write " style="""_$$ImageTransformGradient^WWWFORMCrossBrowserSupportVisual(COLOR,COLORR)_";"""
    if (mOp.NotGreater(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),101),256)) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" style=\"",m$.fnc$("WWWFORMCrossBrowserSupportVisual.ImageTransformGradient",COLOR.get(),COLORR.get())),";\""));
    }
    //<< write " align=left nowrap>"
    m$.Cmd.Write(" align=left nowrap>");
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< write "<font color=white size=3>"
    m$.Cmd.Write("<font color=white size=3>");
    //<< write "<b>"
    m$.Cmd.Write("<b>");
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< do ^WWWUP($$$NO)
    m$.Cmd.Do("WWWUP.main",include.COMSYS.$$$NO(m$));
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< if '$find(YKOPF,".gif") write "&nbsp;"_$$^WWWUML($translate(YKOPF,"_"," "))
    if (mOp.Not(m$.Fnc.$find(m$.var("YKOPF").get(),".gif"))) {
      m$.Cmd.Write(mOp.Concat("&nbsp;",m$.fnc$("WWWUML.main",m$.Fnc.$translate(m$.var("YKOPF").get(),"_"," "))));
    }
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< write " </B>"
    m$.Cmd.Write(" </B>");
    //<< write "</TD>",YCR
    m$.Cmd.Write("</TD>",m$.var("YCR").get());
    //<< 
    //<< write "<TD bgcolor="_COLORR_" align=right width=20>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD bgcolor=",COLORR.get())," align=right width=20>"));
    //<< do ^WWWMENU8
    m$.Cmd.Do("WWWMENU8.main");
    //<< write "</TD>",YCR
    m$.Cmd.Write("</TD>",m$.var("YCR").get());
    //<< 
    //<< write "<TD bgcolor="_COLORR_" align=right width=20>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD bgcolor=",COLORR.get())," align=right width=20>"));
    //<< do CreateLoginLink()
    m$.Cmd.Do("CreateLoginLink");
    //<< write "</TD>",YCR
    m$.Cmd.Write("</TD>",m$.var("YCR").get());
    //<< 
    //<< write "</TR>",YCR
    m$.Cmd.Write("</TR>",m$.var("YCR").get());
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< GetSystemInfoTooltip()
  public Object GetSystemInfoTooltip(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns a string containing correctly formatted string to be inserted into an
    //<< ; <A TITLE="">  construct
    //<< ;---------------------------------------
    //<< ;   System Information
    //<< ;   Company 0 (ALPHALINC)    [deprecated information - reference removed]
    //<< ;   Location 1 (Locn1)
    //<< ;   Cost Centre CC (CostCentre)
    //<< ;   User USER (User Name)
    //<< ;   Language EN (English)
    //<< ;   IP 000.000.000.000
    //<< ;   Form INFormName
    //<< ;   Job 1234
    //<< ;---------------------------------------
    //<< ;
    //<< ; ByRefs:
    //<< ;   YM          Company ID
    //<< ;   YLOCATION   Location ID
    //<< ;   YCR         Newline Character
    //<< ;   SPRACHE     Language ID
    //<< ;   YBED        User ID
    //<< ;   YIPADDR     IP Address of current user
    //<< ;   YFORM       FORM ID
    //<< ;
    //<< ; History:
    //<< ; 11-Dec-2009   GRF     SR16871: Add Cost Centre; skip deprecated YM; macros
    //<< ; 12-Dec-2008   HQN     SR16240: Rewrote to return instead of direct write,
    //<< ;                           reusable in outside routines
    //<< ;-------------------------------------------------------------------------------
    //<< new idCostCentre,strTooltip
    mVar idCostCentre = m$.var("idCostCentre");
    mVar strTooltip = m$.var("strTooltip");
    m$.newVar(idCostCentre,strTooltip);
    //<< 
    //<< set strTooltip = $$^WWWTEXT(30038,,1)                                      ; "System Information"
    strTooltip.set(m$.fnc$("WWWTEXT.main",30038,null,1));
    //<< 
    //<< set strTooltip = strTooltip_YCR_$$^WWWTEXT(388,,1)_" "_YLOCATION           ; "Location"
    strTooltip.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strTooltip.get(),m$.var("YCR").get()),m$.fnc$("WWWTEXT.main",388,null,1))," "),m$.var("YLOCATION").get()));
    //<< if YLOCATION'="" {
    if (mOp.NotEqual(m$.var("YLOCATION").get(),"")) {
      //<< set strTooltip = strTooltip_" ("_$extract($$$WWW0121LocationName($get(^WWW0121(0,0,YLOCATION,1))),1,80)_")"
      strTooltip.set(mOp.Concat(mOp.Concat(mOp.Concat(strTooltip.get()," ("),m$.Fnc.$extract(include.WWWConst.$$$WWW0121LocationName(m$,m$.Fnc.$get(m$.var("^WWW0121",0,0,m$.var("YLOCATION").get(),1))),1,80)),")"));
      //<< set idCostCentre = $$GetCostCentre^INCostCentre(YLOCATION)
      idCostCentre.set(m$.fnc$("INCostCentre.GetCostCentre",m$.var("YLOCATION").get()));
      //<< set strTooltip = strTooltip_YCR_$$^WWWTEXT(33860,,1)_" "_idCostCentre  ; Cost Centre
      strTooltip.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strTooltip.get(),m$.var("YCR").get()),m$.fnc$("WWWTEXT.main",33860,null,1))," "),idCostCentre.get()));
      //<< if idCostCentre'="" {
      if (mOp.NotEqual(idCostCentre.get(),"")) {
        //<< set strTooltip = strTooltip_" ("_$extract($$$INKOSTLDesignation($get(^INKOSTL(0,idCostCentre,1))),1,80)_")"
        strTooltip.set(mOp.Concat(mOp.Concat(mOp.Concat(strTooltip.get()," ("),m$.Fnc.$extract(include.INConst.$$$INKOSTLDesignation(m$,m$.Fnc.$get(m$.var("^INKOSTL",0,idCostCentre.get(),1))),1,80)),")"));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set strTooltip = strTooltip_YCR_$$^WWWTEXT(232,,1)                         ; "Username"
    strTooltip.set(mOp.Concat(mOp.Concat(strTooltip.get(),m$.var("YCR").get()),m$.fnc$("WWWTEXT.main",232,null,1)));
    //<< set strTooltip = strTooltip_" "_YBED
    strTooltip.set(mOp.Concat(mOp.Concat(strTooltip.get()," "),m$.var("YBED").get()));
    //<< if YBED'="" set strTooltip = strTooltip_" ("_$extract($$$WWW013Name($get(^WWW013(0,YBED,1))),1,80)_")"
    if (mOp.NotEqual(m$.var("YBED").get(),"")) {
      strTooltip.set(mOp.Concat(mOp.Concat(mOp.Concat(strTooltip.get()," ("),m$.Fnc.$extract(include.WWWConst.$$$WWW013Name(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))),1,80)),")"));
    }
    //<< set strTooltip = strTooltip_YCR
    strTooltip.set(mOp.Concat(strTooltip.get(),m$.var("YCR").get()));
    //<< 
    //<< set strTooltip = strTooltip_$$^WWWTEXT(300,,1)                             ; "Language"
    strTooltip.set(mOp.Concat(strTooltip.get(),m$.fnc$("WWWTEXT.main",300,null,1)));
    //<< set strTooltip = strTooltip_" "_SPRACHE
    strTooltip.set(mOp.Concat(mOp.Concat(strTooltip.get()," "),m$.var("SPRACHE").get()));
    //<< if SPRACHE'="" set strTooltip = strTooltip_" ("_$extract($$$WWW100Text($get(^WWW100(0,"SPRACHE",SPRACHE,SPRACHE,1))),1,80)_")"
    if (mOp.NotEqual(m$.var("SPRACHE").get(),"")) {
      strTooltip.set(mOp.Concat(mOp.Concat(mOp.Concat(strTooltip.get()," ("),m$.Fnc.$extract(include.WWWConst.$$$WWW100Text(m$,m$.Fnc.$get(m$.var("^WWW100",0,"SPRACHE",m$.var("SPRACHE").get(),m$.var("SPRACHE").get(),1))),1,80)),")"));
    }
    //<< 
    //<< set strTooltip = strTooltip_YCR
    strTooltip.set(mOp.Concat(strTooltip.get(),m$.var("YCR").get()));
    //<< 
    //<< set strTooltip = strTooltip_$$^WWWTEXT(33776,,1)                           ; "IP"
    strTooltip.set(mOp.Concat(strTooltip.get(),m$.fnc$("WWWTEXT.main",33776,null,1)));
    //<< set strTooltip = strTooltip_" "_$get(YIPADDR)_"&nbsp;&nbsp;"
    strTooltip.set(mOp.Concat(mOp.Concat(mOp.Concat(strTooltip.get()," "),m$.Fnc.$get(m$.var("YIPADDR"))),"&nbsp;&nbsp;"));
    //<< 
    //<< if $get(YFORM)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
      //<< set strTooltip = strTooltip_YCR_$$^WWWTEXT(93,,1)_" "_YFORM            ; "Form"
      strTooltip.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strTooltip.get(),m$.var("YCR").get()),m$.fnc$("WWWTEXT.main",93,null,1))," "),m$.var("YFORM").get()));
    }
    //<< }
    //<< 
    //<< set strTooltip = strTooltip_" "_YCR_$$^WWWTEXT(34165,,1)_" "_$job          ; "Job"
    strTooltip.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strTooltip.get()," "),m$.var("YCR").get()),m$.fnc$("WWWTEXT.main",34165,null,1))," "),m$.Fnc.$job()));
    //<< quit strTooltip
    return strTooltip.get();
  }

  //<< 
  //<< 
  //<< GetButtonStyle()
  public Object GetButtonStyle(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns a string containing styles relevant to GetMenuButton and
    //<< ; GetOverviewButton
    //<< ;
    //<< ; History:
    //<< ; 16-Dec-2008   HQN     SR16240: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHTML);
    //<< 
    //<< set strHTML = "<style>"_$char(10)
    strHTML.set(mOp.Concat("<style>",m$.Fnc.$char(10)));
    //<< set strHTML = strHTML_" A.menuButton { border:0px;height:27px; } A.menuButton IMG { border:0px; }"
    strHTML.set(mOp.Concat(strHTML.get()," A.menuButton { border:0px;height:27px; } A.menuButton IMG { border:0px; }"));
    //<< set strHTML = strHTML_" A.Start { width:84px;background-image:url("_YGIF_"StartOff.gif);background-repeat:no-repeat;background-position:center; }"
    strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get()," A.Start { width:84px;background-image:url("),m$.var("YGIF").get()),"StartOff.gif);background-repeat:no-repeat;background-position:center; }"));
    //<< set strHTML = strHTML_" A.Start:hover { background-image:url("_YGIF_"StartOn.gif); }"
    strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get()," A.Start:hover { background-image:url("),m$.var("YGIF").get()),"StartOn.gif); }"));
    //<< set strHTML = strHTML_" A.Menu {width:84px;background-image:url("_YGIF_"MenuOff.gif);background-repeat:no-repeat;background-position:center;}"
    strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get()," A.Menu {width:84px;background-image:url("),m$.var("YGIF").get()),"MenuOff.gif);background-repeat:no-repeat;background-position:center;}"));
    //<< set strHTML = strHTML_" A.Menu:hover {background-image:url("_YGIF_"MenuOn.gif)}"_$char(10)_"</style>"
    strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get()," A.Menu:hover {background-image:url("),m$.var("YGIF").get()),"MenuOn.gif)}"),m$.Fnc.$char(10)),"</style>"));
    //<< quit strHTML
    return strHTML.get();
  }

  //<< 
  //<< 
  //<< GetMenuButton()
  public Object GetMenuButton(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns the HTML code for the Menu Button
    //<< ;
    //<< ; History:
    //<< ; 21-May-2010   shobby  SR17316: Firefox doesn't display buttons without display:block
    //<< ; 16-Dec-2008   HQN     SR16240: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHTML);
    //<< 
    //<< set strHTML = "<a style=""display:block"" class=""menuButton Menu"" onclick=""parent.showMenu(1);return false;"""
    strHTML.set("<a style=\"display:block\" class=\"menuButton Menu\" onclick=\"parent.showMenu(1);return false;\"");
    //<< set strHTML = strHTML_" href="""_YAKTION_"EP=WWWMENU"_$$WWWCGI2^WWWCGI($$$NO)_""" title=""Menu"" target=""FRAME2"_YUSER_"""></a>"
    strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get()," href=\""),m$.var("YAKTION").get()),"EP=WWWMENU"),m$.fnc$("WWWCGI.WWWCGI2",include.COMSYS.$$$NO(m$))),"\" title=\"Menu\" target=\"FRAME2"),m$.var("YUSER").get()),"\"></a>"));
    //<< quit strHTML
    return strHTML.get();
  }

  //<< 
  //<< 
  //<< GetOverviewButton()
  public Object GetOverviewButton(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns the HTML code for the Overview Button, used for Menu Type (10)
    //<< ; Flexible Menu
    //<< ;
    //<< ; History:
    //<< ; 21-May-2010   shobby  SR17316: Firefox doesn't display buttons without display:block
    //<< ; 16-Dec-2008   HQN     SR16240: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHTML);
    //<< 
    //<< set strHTML = "<a style=""display:block"" class=""menuButton Start"""
    strHTML.set("<a style=\"display:block\" class=\"menuButton Start\"");
    //<< set strHTML = strHTML_" href="""_YAKTION_"EP=WWWFORM&YFORM=WWWMenuOverview"_$$WWWCGI2^WWWCGI($$$NO)_""" title=""Menu Overview""></a>"
    strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get()," href=\""),m$.var("YAKTION").get()),"EP=WWWFORM&YFORM=WWWMenuOverview"),m$.fnc$("WWWCGI.WWWCGI2",include.COMSYS.$$$NO(m$))),"\" title=\"Menu Overview\"></a>"));
    //<< quit strHTML
    return strHTML.get();
  }

//<< 
//<< 
}
