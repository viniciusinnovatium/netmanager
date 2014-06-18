//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMENU
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:36
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

//<< WWWMENU
public class WWWMENU extends mClass {

  //<< 
  //<< #; System Param: Menu Types
  //<< #define ShowAll     0
  public static Object $$$ShowAll(mContext m$) {
    return (0);
  }

  //<< #define Explorer    3
  public static Object $$$Explorer(mContext m$) {
    return (3);
  }

  //<< #define Separate    4
  public static Object $$$Separate(mContext m$) {
    return (4);
  }

  //<< #define Image       5
  public static Object $$$Image(mContext m$) {
    return (5);
  }

  //<< #define Popup       7
  public static Object $$$Popup(mContext m$) {
    return (7);
  }

  //<< #define None        9
  public static Object $$$None(mContext m$) {
    return (9);
  }

  //<< #define FlexibleMenu 10
  public static Object $$$FlexibleMenu(mContext m$) {
    return (10);
  }

  //<< #define MegaMenu    13
  public static Object $$$MegaMenu(mContext m$) {
    return (13);
  }

  public void main() {
    _WWWMENU();
  }

  public void _WWWMENU() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; WWW Table of contents
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Apr-2012   shobby  SR17998: Mega Menu.
    //<< ; 02-Aug-2010   shobby  SR17481: Corrected some invalid syntax with style
    //<< ; 22-Apr-2010   shobby  SR17253: Cross Browser Support
    //<< ; 06-Jan-2009   FIS     don't use gradient filter with system colors
    //<< ; 16-Dec-2008   HQN     SR16240: Added new Menu Type #define
    //<< ;                       Separate menu for Menu Type 10
    //<< ; 04-Dec-2008   FIS     SR16205: Login with no menu
    //<< ; 30-Jun-2008   shobby  BR014963: If user is logged in at the change of midnight,
    //<< ;                           update the time when refreshing the menu.
    //<< ; 09-Aug-2007   shobby  BR014237: Call to CreateLoginLink so that pressing the X
    //<< ;                           button will go back to the login screen.
    //<< ; 26-Oct-2006   JW      BR014262: Rewrote, added frames.
    //<< ; 04-Sep-2006   PO      SR14420: Call UnloadEvent in frame[1]
    //<< ; 10-Aug-2006   JW      SR13836: Default context menu
    //<< ;  9-Dec-2005   JW      SR13195: Removed confirm msg
    //<< ; 02-Sep-2005   JW      SR12966: WWW120 is shared
    //<< ; 04-Aug-2005   RPW     SR13153: Needed check for YBEDBER, I believe this is set
    //<< ;                           to non zero after login.  YBEDBER is the users
    //<< ;                           authorisation level.
    //<< ; 05-Jul-2005   RPW     SR12230: Added namespace to ^CacheTemp global
    //<< ;  4-Jul-2005   JW      SR12807: Remove call to WWWTAG. Now done in COMHousekeeping
    //<< ; 29-Jun-2005   RPW     SR12230: If there is no menu and there is a user
    //<< ;                           kill the User Session Date data and then save this
    //<< ;                           info into the form so that it displays accurately.
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 11.09.1996    DT      (C) BY DITMAR TYBUSSEK; WWW INHALTSVERZEICHNIS
    //<< ;-------------------------------------------------------------------------------
    //<< new (%request,%KEY,%,%ZCS,%session)
    //<< 
    //<< ;---------------------------------------
    //<< ;  YVOR     objWWW012
    //<< ;---------------------------------------
    //<< set YNOFOOT = 1
    mVar YNOFOOT = m$.var("YNOFOOT");
    YNOFOOT.set(1);
    //<< do ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< 
    //<< set $ztrap="^WWWERROR"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("^WWWERROR");
    //<< set YSCREENM="",YMFA="",YKILL="",YBACK="",YPARA="",YOPTION="",YNAME="",YKEY="",YFKEY="",YTRAKT="",YTRAKT0=0
    mVar YSCREENM = m$.var("YSCREENM");
    YSCREENM.set("");
    mVar YMFA = m$.var("YMFA");
    YMFA.set("");
    mVar YKILL = m$.var("YKILL");
    YKILL.set("");
    mVar YBACK = m$.var("YBACK");
    YBACK.set("");
    mVar YPARA = m$.var("YPARA");
    YPARA.set("");
    mVar YOPTION = m$.var("YOPTION");
    YOPTION.set("");
    mVar YNAME = m$.var("YNAME");
    YNAME.set("");
    mVar YKEY = m$.var("YKEY");
    YKEY.set("");
    mVar YFKEY = m$.var("YFKEY");
    YFKEY.set("");
    mVar YTRAKT = m$.var("YTRAKT");
    YTRAKT.set("");
    mVar YTRAKT0 = m$.var("YTRAKT0");
    YTRAKT0.set(0);
    //<< 
    //<< set strStatus = $$LoginCheck(YUSER)
    mVar strStatus = m$.var("strStatus");
    strStatus.set(m$.fnc$("LoginCheck",m$.var("YUSER").get()));
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set ^CacheTempFAILED($job) = $$$YES
      m$.var("^CacheTempFAILED",m$.Fnc.$job()).set(include.COMSYS.$$$YES(m$));
      //<< do ^WWWINFO($$$Text(strStatus))
      m$.Cmd.Do("WWWINFO.main",include.COMSYS.$$$Text(m$,strStatus));
      //<< kill ^CacheTempFAILED($job)
      m$.var("^CacheTempFAILED",m$.Fnc.$job()).kill();
      //<< quit                                /// ***** EARLY QUIT - INVALID LOGIN *****
      return;
    }
    //<< }
    //<< 
    //<< do UpdateSessionDate()
    m$.Cmd.Do("UpdateSessionDate");
    //<< 
    //<< set objUser = ($get(^WWW013(0,YBED,1)))
    mVar objUser = m$.var("objUser");
    objUser.set((m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))));
    //<< set YBER    = $$$WWW013UserAccess(objUser)      // These are needed in WWWMENU* calls
    mVar YBER = m$.var("YBER");
    YBER.set(include.WWWConst.$$$WWW013UserAccess(m$,objUser));
    //<< set YMOD    = $$$WWW013Module1(objUser)
    mVar YMOD = m$.var("YMOD");
    YMOD.set(include.WWWConst.$$$WWW013Module1(m$,objUser));
    //<< set YVOR    = $get(^WWW012(0,YM,1))         // YVOR used in WWWMENU* calls
    mVar YVOR = m$.var("YVOR");
    YVOR.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< 
    //<< set objWWWUSER = $get(^WWWUSER(0,YUSER,1))
    mVar objWWWUSER = m$.var("objWWWUSER");
    objWWWUSER.set(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)));
    //<< set $$$WWWUSERPassword1(objWWWUSER) = $$$WWW013Password1(objUser)
    include.WWWConst.$$$WWWUSERPassword1Set(m$,objWWWUSER,include.WWWConst.$$$WWW013Password1(m$,objUser));
    //<< if $$$WWWUSERDate1(objWWWUSER)'=+$horolog {
    if (mOp.NotEqual(include.WWWConst.$$$WWWUSERDate1(m$,objWWWUSER),mOp.Positive(m$.Fnc.$horolog()))) {
      //<< set $$$WWWUSERDate1(objWWWUSER) = +$horolog
      include.WWWConst.$$$WWWUSERDate1Set(m$,objWWWUSER,mOp.Positive(m$.Fnc.$horolog()));
      //<< set $$$WWWUSERTime1(objWWWUSER) = 0                ;reset only at change of day
      include.WWWConst.$$$WWWUSERTime1Set(m$,objWWWUSER,0);
    }
    //<< }
    //<< set ^WWWUSER(0,YUSER,1) = objWWWUSER      // Direct set (May have been a reason, best not to mess with it)
    m$.var("^WWWUSER",0,m$.var("YUSER").get(),1).set(objWWWUSER.get());
    //<< 
    //<< // Define Menu
    //<< 
    //<< set YMENU = $$GetType()
    mVar YMENU = m$.var("YMENU");
    YMENU.set(m$.fnc$("GetType"));
    //<< if YMENU=11 { ;Zen
    if (mOp.Equal(YMENU.get(),11)) {
      //<< write "<FRAMESET >"
      m$.Cmd.Write("<FRAMESET >");
      //<< write "<FRAME SCROLLING=""NO"" name=""ZENMENU"" SRC=""alZEN.Alphalinc.cls?"_$$WWWCGI2^WWWCGI()_"&YM="_YM_""">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FRAME SCROLLING=\"NO\" name=\"ZENMENU\" SRC=\"alZEN.Alphalinc.cls?",m$.fnc$("WWWCGI.WWWCGI2")),"&YM="),m$.var("YM").get()),"\">"));
      //<< write "</FRAMESET>"
      m$.Cmd.Write("</FRAMESET>");
      //<< quit                ;############  Early quit ################################
      return;
    }
    //<< }
    //<< 
    //<< // No Menu
    //<< if ((YMENU=$$$None) || (YMENU=$$$FlexibleMenu) || (YMENU=$$$MegaMenu)) && (YUSER'="") && ($$$WWWUSERFrameFormed($get(^WWWUSER(0,YUSER,1)))="") { ;SR17998
    if (mOp.Logical(((mOp.Equal(YMENU.get(),$$$None(m$))) || (mOp.Equal(YMENU.get(),$$$FlexibleMenu(m$))) || (mOp.Equal(YMENU.get(),$$$MegaMenu(m$))))) && (mOp.NotEqual(m$.var("YUSER").get(),"")) && (mOp.Equal(include.WWWConst.$$$WWWUSERFrameFormed(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1))),""))) {
      //<< do Separate(objUser,0)
      m$.Cmd.Do("Separate",objUser.get(),0);
      //<< quit                                /// ***** EARLY QUIT *****
      return;
    }
    //<< }
    //<< 
    //<< // Separate Window
    //<< if (YMENU=$$$Separate) && (YUSER'="") && ($$$WWWUSERFrameFormed($get(^WWWUSER(0,YUSER,1)))="") {
    if ((mOp.Equal(YMENU.get(),$$$Separate(m$))) && (mOp.NotEqual(m$.var("YUSER").get(),"")) && (mOp.Equal(include.WWWConst.$$$WWWUSERFrameFormed(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1))),""))) {
      //<< do Separate(objUser)
      m$.Cmd.Do("Separate",objUser.get());
      //<< quit                                /// ***** EARLY QUIT *****
      return;
    }
    //<< }
    //<< 
    //<< set $$$WWWUSERFormStarted(^WWWUSER(0,YUSER,1))=""               // Direct set
    include.WWWConst.$$$WWWUSERFormStartedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
    //<< 
    //<< // Menu with frames
    //<< if (YMENU'=$$$Popup) && ($$$WWW012TargetFrameName(YVOR)'="") && (YUSER'="") && ($$$WWWUSERFrameFormed($get(^WWWUSER(0,YUSER,1)))="") {
    if ((mOp.NotEqual(YMENU.get(),$$$Popup(m$))) && (mOp.NotEqual(include.WWWConst.$$$WWW012TargetFrameName(m$,YVOR),"")) && (mOp.NotEqual(m$.var("YUSER").get(),"")) && (mOp.Equal(include.WWWConst.$$$WWWUSERFrameFormed(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1))),""))) {
      //<< do Framed(YVOR,objUser)
      m$.Cmd.Do("Framed",YVOR.get(),objUser.get());
      //<< quit                                /// ***** EARLY QUIT *****
      return;
    }
    //<< }
    //<< 
    //<< // Delete lock files
    //<< set YA = ""
    mVar YA = m$.var("YA");
    YA.set("");
    //<< for {
    for (;true;) {
      //<< set YA = $order(^WWW006(0,YA))
      YA.set(m$.Fnc.$order(m$.var("^WWW006",0,YA.get())));
      //<< quit:YA=""
      if (mOp.Equal(YA.get(),"")) {
        break;
      }
      //<< 
      //<< if +YA'=+$horolog {
      if (mOp.NotEqual(mOp.Positive(YA.get()),mOp.Positive(m$.Fnc.$horolog()))) {
        //<< kill ^WWW006(0,YA)
        m$.var("^WWW006",0,YA.get()).kill();
        //<< kill ^WWW0061(0,YA)    ;LÖSCHEN ALTE LOCKFILE ;LÖSCHEN LOCK RÜCKHOLINFO
        m$.var("^WWW0061",0,YA.get()).kill();
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ;LOSCHEN ZWISCHENDATEIEN - delete buffer files
    //<< if YUSER'="" kill ^WWWUSE(0,YUSER)
    if (mOp.NotEqual(m$.var("YUSER").get(),"")) {
      m$.var("^WWWUSE",0,m$.var("YUSER").get()).kill();
    }
    //<< 
    //<< set YKOPF=$$GetHeaderText(YVOR)
    mVar YKOPF = m$.var("YKOPF");
    YKOPF.set(m$.fnc$("GetHeaderText",YVOR.get()));
    //<< 
    //<< do ^WWWSTART(YKOPF)  ;STARTEN HTML ;launching HTML
    m$.Cmd.Do("WWWSTART.main",YKOPF.get());
    //<< 
    //<< if YMENU=$$$Popup do ^WWWFORM8  ;JAVASCRIPT WENN POPUP ;when
    if (mOp.Equal(YMENU.get(),$$$Popup(m$))) {
      m$.Cmd.Do("WWWFORM8.main");
    }
    //<< 
    //<< set blnContext = $$$CONTEXT
    mVar blnContext = m$.var("blnContext");
    blnContext.set(include.COMSYS.$$$CONTEXT(m$));
    //<< if blnContext do DefaultContext^COMViewColumnMenu()
    if (mOp.Logical(blnContext.get())) {
      m$.Cmd.Do("COMViewColumnMenu.DefaultContext");
    }
    //<< 
    //<< write "<BODY"
    m$.Cmd.Write("<BODY");
    //<< if blnContext write " oncontextmenu=' DisplayContext(); return false; ' "
    if (mOp.Logical(blnContext.get())) {
      m$.Cmd.Write(" oncontextmenu=' DisplayContext(); return false; ' ");
    }
    //<< 
    //<< write " onLoad='self.focus();document.location=""#TARGET"";'"    ;FORMULARFORMAT
    m$.Cmd.Write(" onLoad='self.focus();document.location=\"#TARGET\";'");
    //<< 
    //<< if $$$WWW012BackgroundPicture(YVOR)'="" write " BACKGROUND="""_YGIF_$$$WWW012BackgroundPicture(YVOR)_""""
    if (mOp.NotEqual(include.WWWConst.$$$WWW012BackgroundPicture(m$,YVOR),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" BACKGROUND=\"",m$.var("YGIF").get()),include.WWWConst.$$$WWW012BackgroundPicture(m$,YVOR)),"\""));
    }
    //<< if $$$WWW012WatermarkEffect(YVOR) write " BGPROPERTIES=fixed"
    if (mOp.Logical(include.WWWConst.$$$WWW012WatermarkEffect(m$,YVOR))) {
      m$.Cmd.Write(" BGPROPERTIES=fixed");
    }
    //<< 
    //<< if ($$$WWW012MenuBackgroundColor(YVOR)'="") {
    if ((mOp.NotEqual(include.WWWConst.$$$WWW012MenuBackgroundColor(m$,YVOR),""))) {
      //<< write " BGCOLOR="""_$$$SysEnum("FARBE",$$$WWW012MenuBackgroundColor(YVOR))_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" BGCOLOR=\"",include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012MenuBackgroundColor(m$,YVOR))),"\""));
    }
    //<< 
    //<< } elseif ($$$WWW012BackgroundColor(YVOR)'="") {
    else if ((mOp.NotEqual(include.WWWConst.$$$WWW012BackgroundColor(m$,YVOR),""))) {
      //<< write " BGCOLOR="""_$$$SysEnum("FARBE",$$$WWW012BackgroundColor(YVOR))_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" BGCOLOR=\"",include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012BackgroundColor(m$,YVOR))),"\""));
    }
    //<< }
    //<< 
    //<< if $$$WWW012FontColor(YVOR)'="" write " TEXT="""_$$$SysEnum("FARBE",$$$WWW012FontColor(YVOR))_""""
    if (mOp.NotEqual(include.WWWConst.$$$WWW012FontColor(m$,YVOR),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" TEXT=\"",include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012FontColor(m$,YVOR))),"\""));
    }
    //<< 
    //<< if $$$WWW012LinkFontColor(YVOR)'="" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW012LinkFontColor(m$,YVOR),"")) {
      //<< set strColour = $$$SysEnum("FARBE",$$$WWW012LinkFontColor(YVOR))
      mVar strColour = m$.var("strColour");
      strColour.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012LinkFontColor(m$,YVOR)));
      //<< write " LINK="""_strColour_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" LINK=\"",strColour.get()),"\""));
      //<< write " VLINK="""_strColour_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" VLINK=\"",strColour.get()),"\""));
      //<< write " ALINK="""_strColour_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" ALINK=\"",strColour.get()),"\""));
    }
    //<< }
    //<< 
    //<< write " topmargin=1 leftmargin=1>",YCR
    m$.Cmd.Write(" topmargin=1 leftmargin=1>",m$.var("YCR").get());
    //<< write "<FONT "
    m$.Cmd.Write("<FONT ");
    //<< if $$$WWW012FontFace(YVOR)'=""  write " FACE="""_$$$SysEnum("SCHRIFTART",$$$WWW012FontFace(YVOR))_""""
    if (mOp.NotEqual(include.WWWConst.$$$WWW012FontFace(m$,YVOR),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" FACE=\"",include.COMSYSWWW.$$$SysEnum(m$,"SCHRIFTART",include.WWWConst.$$$WWW012FontFace(m$,YVOR))),"\""));
    }
    //<< if $$$WWW012FontSize(YVOR)'=""  write " SIZE="""_$$$WWW012FontSize(YVOR)_""""
    if (mOp.NotEqual(include.WWWConst.$$$WWW012FontSize(m$,YVOR),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" SIZE=\"",include.WWWConst.$$$WWW012FontSize(m$,YVOR)),"\""));
    }
    //<< if $$$WWW012FontColor(YVOR)'="" write " COLOR="""_$$$SysEnum("FARBE",$$$WWW012FontColor(YVOR))_""""     // Duplicated above?
    if (mOp.NotEqual(include.WWWConst.$$$WWW012FontColor(m$,YVOR),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" COLOR=\"",include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012FontColor(m$,YVOR))),"\""));
    }
    //<< write ">"
    m$.Cmd.Write(">");
    //<< 
    //<< ;Header
    //<< if $$$WWW012CenterFormContents(YVOR) write "<CENTER>"
    if (mOp.Logical(include.WWWConst.$$$WWW012CenterFormContents(m$,YVOR))) {
      m$.Cmd.Write("<CENTER>");
    }
    //<< if (YMENU=$$$Popup) {
    if ((mOp.Equal(YMENU.get(),$$$Popup(m$)))) {
      //<< write "<FORM NAME=""WWW"" ACTION="""_$piece(YAKTION,"?",1)_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<FORM NAME=\"WWW\" ACTION=\"",m$.Fnc.$piece(m$.var("YAKTION").get(),"?",1)),"\""));
      //<< if +$get(YHYPER)=0 write " Method=POST"
      if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),0)) {
        m$.Cmd.Write(" Method=POST");
      }
      //<< write ">"
      m$.Cmd.Write(">");
      //<< do ^WWWKOPF($$$WWW012CompanyName(YVOR))
      m$.Cmd.Do("WWWKOPF.main",include.WWWConst.$$$WWW012CompanyName(m$,YVOR));
      //<< write YCR,"</FORM>"
      m$.Cmd.Write(m$.var("YCR").get(),"</FORM>");
    }
    //<< 
    //<< } else {
    else {
      //<< if $$$WWW012TargetFrameName(YVOR)="" {
      if (mOp.Equal(include.WWWConst.$$$WWW012TargetFrameName(m$,YVOR),"")) {
        //<< do ^WWWKOPF($$$WWW012CompanyName(YVOR))
        m$.Cmd.Do("WWWKOPF.main",include.WWWConst.$$$WWW012CompanyName(m$,YVOR));
      }
      //<< 
      //<< } else {
      else {
        //<< new COLOR,COLORR
        mVar COLOR = m$.var("COLOR");
        mVar COLORR = m$.var("COLORR");
        m$.newVar(COLOR,COLORR);
        //<< set COLOR = "DIMGRAY"
        COLOR.set("DIMGRAY");
        //<< if $$$WWW012ColorCodeForHeaderLeft(YVOR)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW012ColorCodeForHeaderLeft(m$,YVOR),"")) {
          //<< set COLOR = $$$SysEnum("FARBE",$$$WWW012ColorCodeForHeaderLeft(YVOR))
          COLOR.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012ColorCodeForHeaderLeft(m$,YVOR)));
        }
        //<< }
        //<< set COLORR=$$$WWW012ColorCodeForHeaderRight(YVOR)  ;FARBE RECHTS;FIS;11.12.03 ;tincture on the right
        COLORR.set(include.WWWConst.$$$WWW012ColorCodeForHeaderRight(m$,YVOR));
        //<< if COLORR'="" set COLORR = $$$SysEnum("FARBE",COLORR)
        if (mOp.NotEqual(COLORR.get(),"")) {
          COLORR.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",COLORR));
        }
        //<< if COLORR=""  set COLORR = COLOR
        if (mOp.Equal(COLORR.get(),"")) {
          COLORR.set(COLOR.get());
        }
        //<< write YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< ;SR17862 do ^WWWFRAME(0)
        //<< DO ^WWWFRAME(0,,,,,$$$NO) ;SR17862
        m$.Cmd.Do("WWWFRAME.main",0,null,null,null,null,include.COMSYS.$$$NO(m$));
        //<< write "<TR><TD"
        m$.Cmd.Write("<TR><TD");
        //<< write " bgcolor="_COLOR  ;für netscape & co. ;to
        m$.Cmd.Write(mOp.Concat(" bgcolor=",COLOR.get()));
        //<< ;SR17253 IF $$$WWW012ColorCodeForHeaderLeft(YVOR)'>256 WRITE " style=""filter:progid:DXImageTransform.Microsoft.Gradient(GradientType=1, StartColorStr="_COLOR_", EndColorStr="_COLORR_");"""  ;FIS;11.12.03  ;SR16236
        //<< if $$$WWW012ColorCodeForHeaderLeft(YVOR)'>256 write " style="""_$$ImageTransformGradient^WWWFORMCrossBrowserSupportVisual(COLOR,COLORR) ;SR17253
        if (mOp.NotGreater(include.WWWConst.$$$WWW012ColorCodeForHeaderLeft(m$,YVOR),256)) {
          m$.Cmd.Write(mOp.Concat(" style=\"",m$.fnc$("WWWFORMCrossBrowserSupportVisual.ImageTransformGradient",COLOR.get(),COLORR.get())));
        }
        //<< write " border-right:none;"""  ;FIS;11.12.03  ;SR17481
        m$.Cmd.Write(" border-right:none;\"");
        //<< ;SR17481 WRITE " style=""border-right:none;"""  ;FIS;11.12.03
        //<< write " VALIGN=TOP align=LEFT nowrap>"
        m$.Cmd.Write(" VALIGN=TOP align=LEFT nowrap>");
        //<< write "<FONT SIZE=3 color=white><b>"
        m$.Cmd.Write("<FONT SIZE=3 color=white><b>");
        //<< 
        //<< if ($get(YLOCATION)="")||('$$$WWW012ShowNameOfLocation(YVOR)) {
        if ((mOp.Equal(m$.Fnc.$get(m$.var("YLOCATION")),"")) || (mOp.Not(include.WWWConst.$$$WWW012ShowNameOfLocation(m$,YVOR)))) {
          //<< write "&nbsp;"_$$$WWW012CompanyName(YVOR)   ;MANDANTENNAME
          m$.Cmd.Write(mOp.Concat("&nbsp;",include.WWWConst.$$$WWW012CompanyName(m$,YVOR)));
        }
        //<< } else {
        else {
          //<< write "&nbsp;"_$$$WWW0121LocationName($get(^WWW0121(0,YM,YLOCATION,1)))  ;BETRIEB STATT MANDANT ANZEIGEN
          m$.Cmd.Write(mOp.Concat("&nbsp;",include.WWWConst.$$$WWW0121LocationName(m$,m$.Fnc.$get(m$.var("^WWW0121",0,m$.var("YM").get(),m$.var("YLOCATION").get(),1)))));
        }
        //<< }
        //<< write "</b></TD>"
        m$.Cmd.Write("</b></TD>");
        //<< 
        //<< ;klein
        //<< write "<TD bgcolor="_COLORR
        m$.Cmd.Write(mOp.Concat("<TD bgcolor=",COLORR.get()));
        //<< write " style=""border-right:none; border-left:none;"""
        m$.Cmd.Write(" style=\"border-right:none; border-left:none;\"");
        //<< write " align=right WIDTH=10>"
        m$.Cmd.Write(" align=right WIDTH=10>");
        //<< write "<IMG SRC="""_YGIF_"klein.gif"" border=0 class=link onclick=""parent.document.body.cols='6%,94%';"">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"klein.gif\" border=0 class=link onclick=\"parent.document.body.cols='6%,94%';\">"));
        //<< write "</TD>"
        m$.Cmd.Write("</TD>");
        //<< 
        //<< ;gross
        //<< write "<TD bgcolor="_COLORR
        m$.Cmd.Write(mOp.Concat("<TD bgcolor=",COLORR.get()));
        //<< write " style=""border-right:none; border-left:none;"""
        m$.Cmd.Write(" style=\"border-right:none; border-left:none;\"");
        //<< write " align=right WIDTH=10>"
        m$.Cmd.Write(" align=right WIDTH=10>");
        //<< write "<IMG SRC="""_YGIF_"gross.gif"" border=0 class=link onclick=""parent.document.body.cols='30%,70%';"">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"gross.gif\" border=0 class=link onclick=\"parent.document.body.cols='30%,70%';\">"));
        //<< write "</TD>"
        m$.Cmd.Write("</TD>");
        //<< 
        //<< ;ende
        //<< write "<TD bgcolor="_COLORR
        m$.Cmd.Write(mOp.Concat("<TD bgcolor=",COLORR.get()));
        //<< write " style=""border-left:none;"""
        m$.Cmd.Write(" style=\"border-left:none;\"");
        //<< write " align=right WIDTH=10>"
        m$.Cmd.Write(" align=right WIDTH=10>");
        //<< do CreateLoginLink^WWWKOPF()
        m$.Cmd.Do("WWWKOPF.CreateLoginLink");
        //<< write "</TD>"
        m$.Cmd.Write("</TD>");
        //<< 
        //<< write "</TR>"
        m$.Cmd.Write("</TR>");
        //<< do ^WWWFRAME(1)
        m$.Cmd.Do("WWWFRAME.main",1);
        //<< write YCR
        m$.Cmd.Write(m$.var("YCR").get());
      }
    }
    //<< }
    //<< }
    //<< if $$$WWW012CenterFormContents(YVOR) write "</CENTER>"
    if (mOp.Logical(include.WWWConst.$$$WWW012CenterFormContents(m$,YVOR))) {
      m$.Cmd.Write("</CENTER>");
    }
    //<< write "<NOBR>"
    m$.Cmd.Write("<NOBR>");
    //<< 
    //<< ;WRITE YCR,YCR,"<!-- ************************* MENUEPUNKTE ************************* -->",YCR,YCR
    //<< 
    //<< ;VERTEILEN AUF MENUARTEN ;distribute upon
    //<< if YMENU'=$$$Separate if YMENU'=$$$Explorer if YMENU'=$$$Popup write YCR,"</TD></TR></TABLE>"
    if (mOp.NotEqual(YMENU.get(),$$$Separate(m$))) {
      if (mOp.NotEqual(YMENU.get(),$$$Explorer(m$))) {
        if (mOp.NotEqual(YMENU.get(),$$$Popup(m$))) {
          m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
        }
      }
    }
    //<< 
    //<< if YMENU=$$$ShowAll {
    if (mOp.Equal(YMENU.get(),$$$ShowAll(m$))) {
      //<< do ^WWWMENU1       ;NORMALES MENU
      m$.Cmd.Do("WWWMENU1.main");
    }
    //<< 
    //<< } elseif YMENU=$$$Explorer {
    else if (mOp.Equal(YMENU.get(),$$$Explorer(m$))) {
      //<< if '$data(^WWW004X(0,YM)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW004X",0,m$.var("YM").get())))) {
        //<< do ^WWWMENU4   ;PLUS MINUS
        m$.Cmd.Do("WWWMENU4.main");
      }
      //<< } else {
      else {
        //<< do ^WWWMENU4X  ;PLUS MINUS MANDANTEN MENU
        m$.Cmd.Do("WWWMENU4X.main");
      }
    }
    //<< }
    //<< ;} elseif YMENU=$$$Separate {
    //<< } elseif ((YMENU=$$$Separate) || (YMENU=$$$FlexibleMenu)) {
    else if (mOp.Logical(((mOp.Equal(YMENU.get(),$$$Separate(m$))) || (mOp.Equal(YMENU.get(),$$$FlexibleMenu(m$)))))) {
      //<< ;} elseif (YMENU=$$$Separate) {
      //<< do ^WWWMENU5  ;SEPARATES FENSTER PLUS MINUS ;window plus minus
      m$.Cmd.Do("WWWMENU5.main");
    }
    //<< 
    //<< } elseif YMENU=$$$Image {
    else if (mOp.Equal(YMENU.get(),$$$Image(m$))) {
      //<< do ^WWWMENU6  ;IMAGE
      m$.Cmd.Do("WWWMENU6.main");
    }
    //<< }
    //<< 
    //<< if $$$WWW012MenuFormated(YVOR) write YCR,"</TABLE>"
    if (mOp.Logical(include.WWWConst.$$$WWW012MenuFormated(m$,YVOR))) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    }
    //<< if $$$WWW012MenuCentered(YVOR) write "</CENTER>"
    if (mOp.Logical(include.WWWConst.$$$WWW012MenuCentered(m$,YVOR))) {
      m$.Cmd.Write("</CENTER>");
    }
    //<< if $$$WWW012FontFace(YVOR)=""  write "</PRE>"
    if (mOp.Equal(include.WWWConst.$$$WWW012FontFace(m$,YVOR),"")) {
      m$.Cmd.Write("</PRE>");
    }
    //<< if $$$WWW012MenuFramed(YVOR)   write YCR,"</TD></TR></TABLE>"
    if (mOp.Logical(include.WWWConst.$$$WWW012MenuFramed(m$,YVOR))) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
    }
    //<< write YCR,"</NOBR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</NOBR>");
    //<< write YCR,"<BR>"
    m$.Cmd.Write(m$.var("YCR").get(),"<BR>");
    //<< 
    //<< do EVENT^WWWFORM  ;APPLET FÜR EVENTGBROKER ;to
    m$.Cmd.Do("WWWFORM.EVENT");
    //<< do ^WWWSTOP           ; close body, HTML, etc. as required
    m$.Cmd.Do("WWWSTOP.main");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< LoginCheck(&YUSER)
  public Object LoginCheck(Object ... _p) {
    mVar YUSER = m$.newVarRef("YUSER",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check login details
    //<< ;
    //<< ; Params:   YUSER
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 01-Nov-2007   shobby  SRBR014748: Use standard password check $$CHECK^WWWPWDCHECK
    //<< ; 03-Apr-2007   GRF     SR15492: TerminationBy => TerminationOn
    //<< ; 26-Oct-2006   JW      BR014262: Created (Encapsulated, brace syntax)
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,objYUSER,strUserLocs,strMenuLocs,intLoop,dteTerminated,YPWD
    mVar strStatus = m$.var("strStatus");
    mVar objYUSER = m$.var("objYUSER");
    mVar strUserLocs = m$.var("strUserLocs");
    mVar strMenuLocs = m$.var("strMenuLocs");
    mVar intLoop = m$.var("intLoop");
    mVar dteTerminated = m$.var("dteTerminated");
    mVar YPWD = m$.var("YPWD");
    m$.newVar(strStatus,objYUSER,strUserLocs,strMenuLocs,intLoop,dteTerminated,YPWD);
    //<< new tmeStart,intAttempt,YA,objUser
    mVar tmeStart = m$.var("tmeStart");
    mVar intAttempt = m$.var("intAttempt");
    mVar YA = m$.var("YA");
    mVar objUser = m$.var("objUser");
    m$.newVar(tmeStart,intAttempt,YA,objUser);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< ;BEDIENER SUCHEN ;seek
    //<< if YUSER'="" {
    if (mOp.NotEqual(YUSER.get(),"")) {
      //<< set objYUSER = $get(^WWWUSER(0,YUSER,1))
      objYUSER.set(m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1)));
      //<< set YPWD     = $$$WWWUSERPassword1(objYUSER)
      YPWD.set(include.WWWConst.$$$WWWUSERPassword1(m$,objYUSER));
      //<< if $$$WWWUSERUser1(objYUSER)'=YBED {
      if (mOp.NotEqual(include.WWWConst.$$$WWWUSERUser1(m$,objYUSER),m$.var("YBED").get())) {
        //<< set strStatus = $listbuild(5)       ;USER NICHT MEHR AKTIV ;Not more ENABLED
        strStatus.set(m$.Fnc.$listbuild(5));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< ;PRUEFEN BERECHTIGUNG
      //<< if '$data(^WWW013(0,YBED)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW013",0,m$.var("YBED").get())))) {
        //<< set YUSER = ""
        YUSER.set("");
        //<< do ^WWWFOOL(YBED,"no such user")
        m$.Cmd.Do("WWWFOOL.main",m$.var("YBED").get(),"no such user");
        //<< set strStatus = $listbuild(5)       ;FALSCHER USER
        strStatus.set(m$.Fnc.$listbuild(5));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set objUser     = $get(^WWW013(0,YBED,1))
      objUser.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
      //<< set strUserLocs = $$$WWW013AllowedLocations(objUser)    ;USERBERECHTIGUNG FÜR BETRIEBE
      strUserLocs.set(include.WWWConst.$$$WWW013AllowedLocations(m$,objUser));
      //<< 
      //<< if strUserLocs'="" {
      if (mOp.NotEqual(strUserLocs.get(),"")) {
        //<< set strMenuLocs = $translate($$$WWW012LocationsWithMenu($get(^WWW012(0,YM,1))),",",";")
        strMenuLocs.set(m$.Fnc.$translate(include.WWWConst.$$$WWW012LocationsWithMenu(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))),",",";"));
        //<< if $translate(strMenuLocs,";, ")'="" {
        if (mOp.NotEqual(m$.Fnc.$translate(strMenuLocs.get(),";, "),"")) {
          //<< for intLoop=1:1 {
          for (intLoop.set(1);(true);intLoop.set(mOp.Add(intLoop.get(),1))) {
            //<< quit:$piece(strMenuLocs,";",intLoop)=""
            if (mOp.Equal(m$.Fnc.$piece(strMenuLocs.get(),";",intLoop.get()),"")) {
              break;
            }
            //<< 
            //<< if $find(";"_strUserLocs_";",";"_$piece(strMenuLocs,";",intLoop)_";") {
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",strUserLocs.get()),";"),mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(strMenuLocs.get(),";",intLoop.get())),";")))) {
              //<< do ^WWWFOOL(YBED,"wrong location")
              m$.Cmd.Do("WWWFOOL.main",m$.var("YBED").get(),"wrong location");
              //<< set strStatus = $listbuild(5)           ;FALSCHER BETRIEB ;location
              strStatus.set(m$.Fnc.$listbuild(5));
              //<< quit
              break;
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< }
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< set dteTerminated = $$$WWW013TerminationOn(objUser)
        dteTerminated.set(include.WWWConst.$$$WWW013TerminationOn(m$,objUser));
        //<< if (dteTerminated'="") && ($$$WWW013EmployeeCategory(objUser)'=999) && ($horolog>dteTerminated) {    ; SR15492
        if ((mOp.NotEqual(dteTerminated.get(),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW013EmployeeCategory(m$,objUser),999)) && (mOp.Greater(m$.Fnc.$horolog(),dteTerminated.get()))) {
          //<< do ^WWWFOOL(YBED,"no longer valid")
          m$.Cmd.Do("WWWFOOL.main",m$.var("YBED").get(),"no longer valid");
          //<< set strStatus = $listbuild(5)               ;GEKÜNDIGT;3,12,2003; WENN NICHT SYSTEMADMIN
          strStatus.set(m$.Fnc.$listbuild(5));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set YA = $$^WWWPWDCHECK($$$WWW013Password1(objUser))  ;TYBD; PASSWORTSCHLÜSSEL;7,1,2004
      YA.set(m$.fnc$("WWWPWDCHECK.main",include.WWWConst.$$$WWW013Password1(m$,objUser)));
      //<< if (YBED="INTRAPREND") && ($get(%(YQUERY,"YRANDOM"))'="") && (+YPWD'=0) {
      if ((mOp.Equal(m$.var("YBED").get(),"INTRAPREND")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YRANDOM")),"")) && (mOp.NotEqual(mOp.Positive(YPWD.get()),0))) {
        //<< if YPWD=$extract(%(YQUERY,"YRANDOM")+($random(+$horolog*91)),2,6) {
        if (mOp.Equal(YPWD.get(),m$.Fnc.$extract(mOp.Add(m$.var("%",m$.var("YQUERY").get(),"YRANDOM").get(),(m$.Fnc.$random(mOp.Multiply(mOp.Positive(m$.Fnc.$horolog()),91)))),2,6))) {
          //<< kill %(YQUERY,"YRANDOM")
          m$.var("%",m$.var("YQUERY").get(),"YRANDOM").kill();
          //<< set YPWD             = YA
          YPWD.set(YA.get());
          //<< set %(YQUERY,"YPWD") = YA
          m$.var("%",m$.var("YQUERY").get(),"YPWD").set(YA.get());
          //<< set $piece(^WWWUSER(0,YUSER,1),Y,1) = $zconvert(YPWD,"U")
          m$.pieceVar(m$.var("^WWWUSER",0,YUSER.get(),1),m$.var("Y").get(),1).set(m$.Fnc.$zconvert(YPWD.get(),"U"));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< ; BR014748if $$$UPPER(YA)'=$$$UPPER(YPWD) {    ;FALSCHES PASSWORD
      //<< if '$$CHECK^WWWPWDCHECK(YA,YPWD) {
      if (mOp.Not(m$.fnc$("WWWPWDCHECK.CHECK",YA.get(),YPWD.get()))) {
        //<< set YUSER = ""
        YUSER.set("");
        //<< do ^WWWFOOL(YBED,"wrong password")
        m$.Cmd.Do("WWWFOOL.main",m$.var("YBED").get(),"wrong password");
        //<< set intAttempt = 0
        intAttempt.set(0);
        //<< 
        //<< set tmeStart = $piece($horolog,",",2)-600
        tmeStart.set(mOp.Subtract(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),600));
        //<< for {
        for (;true;) {
          //<< set tmeStart = $order(^WWWFOOL(0,+$horolog,tmeStart))
          tmeStart.set(m$.Fnc.$order(m$.var("^WWWFOOL",0,mOp.Positive(m$.Fnc.$horolog()),tmeStart.get())));
          //<< quit:tmeStart=""
          if (mOp.Equal(tmeStart.get(),"")) {
            break;
          }
          //<< 
          //<< if $data(^WWWFOOL(0,+$horolog,tmeStart,YBED)) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWFOOL",0,mOp.Positive(m$.Fnc.$horolog()),tmeStart.get(),m$.var("YBED").get())))) {
            //<< set intAttempt=intAttempt+1  ; ANZAHL DER FEHLVERSUCHE ;Number the
            intAttempt.set(mOp.Add(intAttempt.get(),1));
          }
        }
        //<< }
        //<< }
        //<< if intAttempt<5 {
        if (mOp.Less(intAttempt.get(),5)) {
          //<< 
          //<< set strStatus = $listbuild(5)
          strStatus.set(m$.Fnc.$listbuild(5));
        }
        //<< } else {
        else {
          //<< 
          //<< // FIXME: This is just stupid.
          //<< // Needs to at least be based on user id and probably also lock out remote IP
          //<< 
          //<< hang 30
          m$.Cmd.Hang(30);
          //<< set strStatus = $listbuild(408)   ;ZEITSPERRE, DA ZU VIELE FEHLVERSUCHE
          strStatus.set(m$.Fnc.$listbuild(408));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< UpdateSessionDate()
  public Object UpdateSessionDate(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update User Session Date Info on FINUserSessionDate form
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 19-Feb-2009   FIS     SR16065: log first session event
    //<< ; 26-Oct-2006   JW      BR014262: Created (encapsulated, added status)
    //<< ;-------------------------------------------------------------------------------
    //<< new objForm,strStatus
    mVar objForm = m$.var("objForm");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objForm,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if (YANZ="") && (YBED'="") && (YBEDBER=0) {
    if ((mOp.Equal(m$.var("YANZ").get(),"")) && (mOp.NotEqual(m$.var("YBED").get(),"")) && (mOp.Equal(m$.var("YBEDBER").get(),0))) {
      //<< kill ^CacheTempUserSessionDate($zutil(5),YBED)
      m$.var("^CacheTempUserSessionDate",m$.Fnc.$zutil(5),m$.var("YBED").get()).kill();
      //<< set ^CacheTempUserSessionDate($zutil(5),YBED) = +$horolog
      m$.var("^CacheTempUserSessionDate",m$.Fnc.$zutil(5),m$.var("YBED").get()).set(mOp.Positive(m$.Fnc.$horolog()));
      //<< 
      //<< set objForm = $get(^WWW120(0,"FINUserSessionDate",1))
      objForm.set(m$.Fnc.$get(m$.var("^WWW120",0,"FINUserSessionDate",1)));
      //<< if objForm'="" {
      if (mOp.NotEqual(objForm.get(),"")) {
        //<< set $$$WWW120FormInformation(objForm) = $$$Text($listbuild("Fin00817",$$^WWWDATE(+$horolog),0))
        include.WWWConst.$$$WWW120FormInformationSet(m$,objForm,include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("Fin00817",m$.fnc$("WWWDATE.main",mOp.Positive(m$.Fnc.$horolog())),0)));
        //<< set strStatus = $$$Save("WWW120","FINUserSessionDate",objForm,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"WWW120","FINUserSessionDate",objForm,include.COMSYS.$$$YES(m$)));
      }
    }
    //<< }  ; "User Session Date: %1"
    //<< }
    //<< 
    //<< do LogAction^WWWUSER(YUSER)  ;Log first Action time
    m$.Cmd.Do("WWWUSER.LogAction",m$.var("YUSER").get());
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< Separate(pobjUser,blnShowMenu=$$$YES)
  public Object Separate(Object ... _p) {
    mVar pobjUser = m$.newVarRef("pobjUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar blnShowMenu = m$.newVarRef("blnShowMenu",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create the Separate Window frame set.
    //<< ;
    //<< ; Params:   pobjUser    - WWW013 record
    //<< ;           blnShowMenu - do not load menu window if $$$NO
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Jan-2009   FIS     SR16205: Change (SR16205, 4-Dec-09) incorporated into
    //<< ;                           this label, other label deleted
    //<< ; 04-Dec-2008   FIS     SR16205: new Label: do not load menu window if
    //<< ;                           blnShowMenu=$$$NO
    //<< ; 27-Oct-2006   JW      BR014262: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new startForm
    mVar startForm = m$.var("startForm");
    m$.newVar(startForm);
    //<< 
    //<< // Full screen mode - show COMHeader
    //<< if $$$WWW013useFullScreenandHeader(pobjUser) {
    if (mOp.Logical(include.WWWConst.$$$WWW013useFullScreenandHeader(m$,pobjUser))) {
      //<< $$$StartFrameSet(1,"rows='49,*' framespacing=0 frameborder=no border=0")
      m$.Cmd.Do("WWWSession.StartFrameSet",1,"rows='49,*' framespacing=0 frameborder=no border=0");
      //<< 
      //<< write "<frame scrolling=""NO"" noresize src=""COMHeader.cls?EP=WWWFORM"
      m$.Cmd.Write("<frame scrolling=\"NO\" noresize src=\"COMHeader.cls?EP=WWWFORM");
      //<< do ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< write """>"
      m$.Cmd.Write("\">");
    }
    //<< 
    //<< // Normal mode
    //<< } elseif (blnShowMenu = $$$YES) {
    else if ((mOp.Equal(blnShowMenu.get(),include.COMSYS.$$$YES(m$)))) {
      //<< $$$StartFrameSet(0,"","showMenu(0);")  //load menu window
      m$.Cmd.Do("WWWSession.StartFrameSet",0,"","showMenu(0);");
    }
    //<< 
    //<< } else {
    else {
      //<< $$$StartFrameSet(0,"","")  //no menu //SR16205
      m$.Cmd.Do("WWWSession.StartFrameSet",0,"","");
    }
    //<< }
    //<< 
    //<< 
    //<< set startForm = $$$WWW013StartForm(pobjUser)
    startForm.set(include.WWWConst.$$$WWW013StartForm(m$,pobjUser));
    //<< set:startForm="" startForm = "WWWBLANK"
    if (mOp.Equal(startForm.get(),"")) {
      startForm.set("WWWBLANK");
    }
    //<< 
    //<< write "<frame src="""_YAKTION_"EP=WWWFORM&YFORM="_startForm
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<frame src=\"",m$.var("YAKTION").get()),"EP=WWWFORM&YFORM="),startForm.get()));
    //<< 
    //<< do ^WWWCGI
    m$.Cmd.Do("WWWCGI.main");
    //<< write """>"
    m$.Cmd.Write("\">");
    //<< 
    //<< $$$EndFrameSet
    include.COMSYSWWW.$$$EndFrameSet(m$);
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Framed(pobjCompany,pobjUser)
  public Object Framed(Object ... _p) {
    mVar pobjCompany = m$.newVarRef("pobjCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjUser = m$.newVarRef("pobjUser",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create the frame set for a menu|form set up.
    //<< ;
    //<< ; Params:   pobjCompany - WWW012 record
    //<< ;           pobjUser    - WWW013 record
    //<< ;
    //<< ; Returns: nil
    //<< ;
    //<< ; History:
    //<< ; 20-Oct-2009   shobby  SR16948: Need to remember the original URL.  Save later
    //<< ;                           in CacheTempURLwhen we have a value for YUSER.
    //<< ; 27-Oct-2006   JW      BR014262: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YXTARGET,YCOLS,YROWS,strForm
    mVar YXTARGET = m$.var("YXTARGET");
    mVar YCOLS = m$.var("YCOLS");
    mVar YROWS = m$.var("YROWS");
    mVar strForm = m$.var("strForm");
    m$.newVar(YXTARGET,YCOLS,YROWS,strForm);
    //<< 
    //<< set YXTARGET = $$$WWW012TargetFrameName(pobjCompany)
    YXTARGET.set(include.WWWConst.$$$WWW012TargetFrameName(m$,pobjCompany));
    //<< 
    //<< set YCOLS = $piece(YXTARGET,"/",3)    if +YCOLS=0 set YCOLS = 28
    YCOLS.set(m$.Fnc.$piece(YXTARGET.get(),"/",3));
    if (mOp.Equal(mOp.Positive(YCOLS.get()),0)) {
      YCOLS.set(28);
    }
    //<< set YROWS = $piece(YXTARGET,"/",4)
    YROWS.set(m$.Fnc.$piece(YXTARGET.get(),"/",4));
    //<< 
    //<< if $get(YTARGET2)="" set YTARGET2 = "FRAME3"
    if (mOp.Equal(m$.Fnc.$get(m$.var("YTARGET2")),"")) {
      mVar YTARGET2 = m$.var("YTARGET2");
      YTARGET2.set("FRAME3");
    }
    //<< if $get(YTARGET)=""  set YTARGET  = "FRAME2"
    if (mOp.Equal(m$.Fnc.$get(m$.var("YTARGET")),"")) {
      mVar YTARGET = m$.var("YTARGET");
      YTARGET.set("FRAME2");
    }
    //<< 
    //<< $$$StartFrameSet(1," cols="""_YCOLS_"%,"_(100-YCOLS)_"%""")
    m$.Cmd.Do("WWWSession.StartFrameSet",1,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" cols=\"",YCOLS.get()),"%,"),(mOp.Subtract(100,YCOLS.get()))),"%\""));
    //<< write "<FRAME SRC="""_YAKTION_"EP=WWWMENU&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM_"&amp;YXURL="_$get(YXURL)_""" scrolling=yes NAME=""MENUFRAME1"">"  ;16948 (required)
    
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FRAME SRC=\"",m$.var("YAKTION").get()),"EP=WWWMENU&amp;YUSER="),m$.var("YUSER").get()),"&amp;YBED="),m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()),"&amp;YXURL="),m$.Fnc.$get(m$.var("YXURL"))),"\" scrolling=yes NAME=\"MENUFRAME1\">"));
    
    ///m$.Cmd.Write("<FRAME SRC=\"about:blank\" scrolling=yes NAME=\"MENUFRAME1\">");
    
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< 
    //<< // More than 1 frame
    //<< if YROWS {
    if (mOp.Logical(YROWS.get())) {
      //<< write "<FRAMESET ROWS="""_YROWS_"%,"_(100-YROWS)_"%"">",YCR
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FRAMESET ROWS=\"",YROWS.get()),"%,"),(mOp.Subtract(100,YROWS.get()))),"%\">"),m$.var("YCR").get());
      //<< write "<FRAME SRC="""
      m$.Cmd.Write("<FRAME SRC=\"");
      //<< write $$FormURL^WWWCGI("WWWBLANK")                      //BR014262
      m$.Cmd.Write(m$.fnc$("WWWCGI.FormURL","WWWBLANK"));
      //<< write """ scrolling=yes NAME="""_YTARGET_""">",YCR
      m$.Cmd.Write(mOp.Concat(mOp.Concat("\" scrolling=yes NAME=\"",m$.var("YTARGET").get()),"\">"),m$.var("YCR").get());
      //<< write "<FRAME SRC="""
      m$.Cmd.Write("<FRAME SRC=\"");
      //<< write $$FormURL^WWWCGI("WWWBLANK")                      //BR014262
      m$.Cmd.Write(m$.fnc$("WWWCGI.FormURL","WWWBLANK"));
      //<< write """ scrolling=yes NAME="""_YTARGET2_""">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("\" scrolling=yes NAME=\"",m$.var("YTARGET2").get()),"\">"));
      //<< write "</FRAMESET>"
      m$.Cmd.Write("</FRAMESET>");
    }
    //<< 
    //<< } else {
    else {
        ///Adicionado para testar o menu sem carregar o segundo frame
        /// Fernando em 16/06      

      //<< write YCR,"<FRAME SRC="""
      m$.Cmd.Write(m$.var("YCR").get(),"<FRAME SRC=\"");
      //<< set strForm = $$$WWW013StartForm(pobjUser)
      strForm.set(include.WWWConst.$$$WWW013StartForm(m$,pobjUser));
      //<< if strForm="" set strForm = "WWWBLANK"
      if (mOp.Equal(strForm.get(),"")) {
        strForm.set("WWWBLANK");
      }
      
      //<< write $$FormURL^WWWCGI(strForm,,"&amp;YFORMWAIT=1")     //BR014262
      ///m$.Cmd.Write(m$.fnc$("WWWCGI.FormURL",strForm.get(),null,"&amp;YFORMWAIT=1"));
      m$.Cmd.Write("about:blank");
      
      //<< write """ scrolling=yes NAME="""_YTARGET_""">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("\" scrolling=yes NAME=\"",m$.var("YTARGET").get()),"\">"));
    }
    //<< }
    //<< 
    //<< $$$EndFrameSet
    include.COMSYSWWW.$$$EndFrameSet(m$);
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetHeaderText(pobjCompany)
  public Object GetHeaderText(Object ... _p) {
    mVar pobjCompany = m$.newVarRef("pobjCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the Header for the menu
    //<< ;
    //<< ; Params:   pobjCompany - WWW012 record
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Oct-2006   JW      BR014262: Encapsulated.
    //<< ;-------------------------------------------------------------------------------
    //<< new strHeader
    mVar strHeader = m$.var("strHeader");
    m$.newVar(strHeader);
    //<< 
    //<< set strHeader = $$$WWW012HeaderTextUnderPicture(pobjCompany)
    strHeader.set(include.WWWConst.$$$WWW012HeaderTextUnderPicture(m$,pobjCompany));
    //<< 
    //<< if (SPRACHE'="DE") && ($piece(strHeader,",",2)'="") {       // FIXME Needs to change - this is rubbish
    if ((mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) && (mOp.NotEqual(m$.Fnc.$piece(strHeader.get(),",",2),""))) {
      //<< set strHeader = $piece(strHeader,",",2)
      strHeader.set(m$.Fnc.$piece(strHeader.get(),",",2));
    }
    //<< } else {
    else {
      //<< set strHeader = $piece(strHeader,",",1)
      strHeader.set(m$.Fnc.$piece(strHeader.get(),",",1));
    }
    //<< }
    //<< quit strHeader
    return strHeader.get();
  }

  //<< 
  //<< 
  //<< GetType()
  public Object GetType(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the current menu type.
    //<< ;
    //<< ; NOTE: ^CacheTempFAILED is used to make sure a failed login does NOT attempt to
    //<< ;       show the obscure menu types.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  enum - menu type
    //<< ;
    //<< ; History:
    //<< ; 14-Dec-2006   JW      BR014262: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idMenu
    mVar idMenu = m$.var("idMenu");
    m$.newVar(idMenu);
    //<< 
    //<< set idMenu = ""
    idMenu.set("");
    //<< 
    //<< // Make sure the login is valid
    //<< if '$get(^CacheTempFAILED($job)) {
    if (mOp.Not(m$.Fnc.$get(m$.var("^CacheTempFAILED",m$.Fnc.$job())))) {
      //<< if $get(YBED)'="" {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) {
        //<< set idMenu = $$$WWW013MenuType($get(^WWW013(0,YBED,1)))
        idMenu.set(include.WWWConst.$$$WWW013MenuType(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))));
      }
      //<< }
      //<< if idMenu="" {
      if (mOp.Equal(idMenu.get(),"")) {
        //<< set idMenu = $$$WWW012MenuType($get(^WWW012(0,0,1)))
        idMenu.set(include.WWWConst.$$$WWW012MenuType(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))));
      }
    }
    //<< }
    //<< }
    //<< quit idMenu
    return idMenu.get();
  }

//<< 
//<< 
//<< 
}
