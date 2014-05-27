//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWINFO
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:56
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

public class WWWINFO extends mClass {

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

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWINFO("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< WWWINFO(YA,YHEAD,LINK,NOBUTTON,HTML)
  public Object main(Object ... _p) {
    mVar YA = m$.newVarRef("YA",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YHEAD = m$.newVarRef("YHEAD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar LINK = m$.newVarRef("LINK",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar NOBUTTON = m$.newVarRef("NOBUTTON",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar HTML = m$.newVarRef("HTML",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    return _WWWINFO(YA,YHEAD,LINK,NOBUTTON,HTML);
  }

  public Object _WWWINFO(Object ... _p) {
    mVar YA = m$.newVarRef("YA",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YHEAD = m$.newVarRef("YHEAD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar LINK = m$.newVarRef("LINK",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar NOBUTTON = m$.newVarRef("NOBUTTON",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar HTML = m$.newVarRef("HTML",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANZEIGEN INFO
    //<< ;
    //<< ;   SAMPLE FOR LINK
    //<< ;
    //<< ;   SET YLINK=""
    //<< ;   DO  ;LINK
    //<< ;   . NEW YKEY,YI
    //<< ;   . SET YI=YAKTION_"EP=WWWFORM&YFORM=INAUF&YKEY="_ORDER
    //<< ;   . DO VAR^WWWCGI
    //<< ;   . SET YLINK=YI
    //<< ;   DO ^WWWINFO($$^WWWTEXT(32188)_" ("_ORDER_")",0,YLINK)  ;ORDER CREATED WITH LINK
    //<< ;
    //<< ; Inputs :
    //<< ;   YA          =text
    //<< ;   YHEAD       =1 don't display header
    //<< ;   LINK        =link (text has link)
    //<< ;   NOBUTTON    =1 no back button / 2 back button has link
    //<< ;   HTML        =1 do not change < and >
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 03-Feb-2010   GRF     SR17160: simplify - blnLong; closing anchor without opening when NOBUTTON'=2
    //<< ; 02-Apr-2007   RPW     Refactored and added variables for pieces.
    //<< ; 19-Dec-2006   JW      BR014262: Rewrite. Use GetType fn.
    //<< ; 08-Dec-2006   PO      SR15276: Changed name of EventBroker to JSLibraries
    //<< ; 22-Sep-2006   JW      SR15072: Added alert if in hyperevent (moved from ReturnError^COMUtilError)
    //<< ; 02-Jun-2006   JW      SR14697: Always use eventbrokeren1.js
    //<< ; 21-Jul-2005   GRF     SR13024: Doco
    //<< ; 01-Jun-2005   RobertW SR12056: Attempt at Performance Increase
    //<< ; 04-APR-2005   TYBD    IDs FOR BUTTON ADDED FOR TESTDIRECTOR
    //<< ; 29.07.1997    DT      created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCenter,blnForce,blnFrame,blnLong
    mVar blnCenter = m$.var("blnCenter");
    mVar blnForce = m$.var("blnForce");
    mVar blnFrame = m$.var("blnFrame");
    mVar blnLong = m$.var("blnLong");
    m$.newVar(blnCenter,blnForce,blnFrame,blnLong);
    //<< 
    //<< $$$LogR("",$get(YA)_"<"_$get(YHEAD)_">"_$$$InHyperEvent)
    $$$LogR(m$,"",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(YA),"<"),m$.Fnc.$get(YHEAD)),">"),include.COMSYS.$$$InHyperEvent(m$)));
    //<< 
    //<< SET $ZTRAP=""
    mVar $ZTRAP = m$.var("$ZTRAP");
    $ZTRAP.set("");
    //<< QUIT:$GET(YA)=""
    if (mOp.Equal(m$.Fnc.$get(YA),"")) {
      return null;
    }
    //<< 
    //<< ; TODO : WWWINFO checks for $$$InHyperEvent so don't need to check again in ReturnError^COMUtilERROR.
    //<< ;        $$$Alert includes $$DecodeError call so entry in WWWINFO will convert list to
    //<< ;        string and then check that string doesn't need further conversion.
    //<< ;        Should have clear definition of what form parameter should be in and process
    //<< ;        accordingly - possibly separate entry points.                <GRF>
    //<< ;
    //<< 
    //<< // SR15072 Note: This is used for OnBeforeSave - assume that this is the only time
    //<< //               we will come in here during a hyperevent.
    //<< if $$$InHyperEvent {
    if (mOp.Logical(include.COMSYS.$$$InHyperEvent(m$))) {
      //<< $$$Alert(YA)
      include.COMSYS.$$$Alert(m$,YA);
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< SET NOBUTTON = $GET(NOBUTTON)
    NOBUTTON.set(m$.Fnc.$get(NOBUTTON));
    //<< SET HTML     = $GET(HTML)
    HTML.set(m$.Fnc.$get(HTML));
    //<< 
    //<< ;LOOP SICHERUNG WEGEN ERROR IN ERROR ;TYBD;19.05.2003 ;quibble within
    //<< ; If duplicated error processing ***HALT***
    //<< ; Note : This will stop any subsequent code being processed - usually as a
    //<< ;        result of an bug where error processing is being handled both at a
    //<< ;        lower and a higher level.
    //<< IF ($GET(YUSER)'="") && (+$GET(YTRAKT)'=0) {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) && (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("YTRAKT"))),0))) {
      //<< IF YTRAKT>10000                                           DO CLOSE^WWWSTART HALT  ; too many "processes" actioned by user today
      if (mOp.Greater(m$.var("YTRAKT").get(),10000)) {
        m$.Cmd.Do("WWWSTART.CLOSE");
      }
      //<< IF $GET(^WWWZWS(0,+$HOROLOG,YUSER,"X","YTRAKT",1))=YTRAKT DO CLOSE^WWWSTART HALT  ; current "process" already has had an error reported
      if (mOp.Equal(m$.Fnc.$get(m$.var("^WWWZWS",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),"X","YTRAKT",1)),m$.var("YTRAKT").get())) {
        m$.Cmd.Do("WWWSTART.CLOSE");
      }
      //<< SET ^WWWZWS(0,+$HOROLOG,YUSER,"X","YTRAKT",1)=YTRAKT
      m$.var("^WWWZWS",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),"X","YTRAKT",1).set(m$.var("YTRAKT").get());
    }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< if +$GET(YHEAD)=0 {
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(YHEAD)),0)) {
      //<< SET KOPF = $$^WWWTEXT(6)_"WWWINFO"  ; "Information"
      mVar KOPF = m$.var("KOPF");
      KOPF.set(mOp.Concat(m$.fnc$("WWWTEXT.main",6),"WWWINFO"));
      //<< DO ^WWWSTART(KOPF)
      m$.Cmd.Do("WWWSTART.main",KOPF.get());
      //<< 
      //<< if $$GetType^WWWMENU() = 7 {        ; Popup     //BR014262
      if (mOp.Equal(m$.fnc$("WWWMENU.GetType"),7)) {
        //<< do ^WWWFORM8
        m$.Cmd.Do("WWWFORM8.main");
      }
      //<< } else {
      else {
        //<< do JSLibraries^WWWFORM8()   // SR14697 // SR15276
        m$.Cmd.Do("WWWFORM8.JSLibraries");
      }
      //<< }
      //<< DO ^WWWBODY(0) ;FORMAT BODY
      m$.Cmd.Do("WWWBODY.main",0);
      //<< IF '$DATA(Y) DO ^WWWVORG                // Is this line necessary ??
      if (mOp.Not(m$.Fnc.$data(m$.var("Y")))) {
        m$.Cmd.Do("WWWVORG.main");
      }
      //<< SET YVOR = $GET(^WWW012(0,YM,1))
      mVar YVOR = m$.var("YVOR");
      YVOR.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
      //<< DO ^WWWUP(0)                        ;ANKER FESTLEGEN
      m$.Cmd.Do("WWWUP.main",0);
      //<< IF $GET(YUSER)'="" SET $PIECE(^WWWUSER(0,YUSER,1),Y,10) = ""
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),10).set("");
      }
      //<< DO ^WWWKOPF(KOPF)                   ;KOPFZEILE
      m$.Cmd.Do("WWWKOPF.main",KOPF.get());
    }
    //<< }
    //<< 
    //<< ;--------------------------------------- TABLE 1
    //<< 
    //<< WRITE "<TABLE CELLSPACING=0 BORDER=0>"
    m$.Cmd.Write("<TABLE CELLSPACING=0 BORDER=0>");
    //<< WRITE "<TR>"
    m$.Cmd.Write("<TR>");
    //<< WRITE "<TD"
    m$.Cmd.Write("<TD");
    //<< 
    //<< set blnForce  = +$$$WWW012ForcePicturesAsButtons(YVOR)
    blnForce.set(mOp.Positive(include.WWWConst.$$$WWW012ForcePicturesAsButtons(m$,m$.var("YVOR"))));
    //<< set blnCenter =  $$$WWW012CenterFormContents(YVOR)
    blnCenter.set(include.WWWConst.$$$WWW012CenterFormContents(m$,m$.var("YVOR")));
    //<< set blnFramed =  $$$WWW012FormsFramed(YVOR)
    mVar blnFramed = m$.var("blnFramed");
    blnFramed.set(include.WWWConst.$$$WWW012FormsFramed(m$,m$.var("YVOR")));
    //<< 
    //<< IF blnForce WRITE " class=""coolButton"""  ; MOUSEEFFECT
    if (mOp.Logical(blnForce.get())) {
      m$.Cmd.Write(" class=\"coolButton\"");
    }
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< 
    //<< SET YQ = 0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< 
    //<< ;WENN AUS FORMAULAR ;when out of
    //<< if (NOBUTTON'=1) && (NOBUTTON'=2)            &&
    //<< (+$GET(YHEAD)=0) && ($get(YFORM)'="")     &&
    //<< ($DATA(YKEY))                             &&
    //<< ((YKEY'="") || ($DATA(^WWW122(0,YFORM))))   {
    if ((mOp.NotEqual(NOBUTTON.get(),1)) && (mOp.NotEqual(NOBUTTON.get(),2)) && (mOp.Equal(mOp.Positive(m$.Fnc.$get(YHEAD)),0)) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && mOp.Logical((m$.Fnc.$data(m$.var("YKEY")))) && mOp.Logical(((mOp.NotEqual(m$.var("YKEY").get(),"")) || mOp.Logical((m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get()))))))) {
      //<< 
      //<< if blnForce {
      if (mOp.Logical(blnForce.get())) {
        //<< WRITE "<A HREF="""
        m$.Cmd.Write("<A HREF=\"");
      }
      //<< } else {
      else {
        //<< WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$^WWWTEXT(99))_""" onClick=""window.location='"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",99))),"\" onClick=\"window.location='"));
      }
      //<< } ; "Back"
      //<< WRITE YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM_"&amp;YOPEN="_$select($get(YKEY)'="":"OLD",1:"NEW") // SR14427
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()),"&amp;YOPEN="),m$.Fnc.$select(mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY")),""),"OLD",1,"NEW")));
      //<< DO ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< IF 'blnForce WRITE "'"
      if (mOp.Not(blnForce.get())) {
        m$.Cmd.Write("'");
      }
      //<< WRITE """>"
      m$.Cmd.Write("\">");
      //<< IF blnForce WRITE "<IMG SRC="""_YGIF_"hback.gif"" "_YHEIGHT_" "_YWIDTH_" TITLE="""_$$^WWWTEXT(99)_""" border=0 id=""BUTTON_BACK""></A>"
      if (mOp.Logical(blnForce.get())) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"hback.gif\" "),m$.var("YHEIGHT").get())," "),m$.var("YWIDTH").get())," TITLE=\""),m$.fnc$("WWWTEXT.main",99)),"\" border=0 id=\"BUTTON_BACK\"></A>"));
      }
      //<< SET YQ=1
      YQ.set(1);
    }
    //<< }
    //<< 
    //<< ;WENN AUS FORMAULAR ;when out of
    //<< if (NOBUTTON=2) && ($get(LINK)'="") {
    if ((mOp.Equal(NOBUTTON.get(),2)) && (mOp.NotEqual(m$.Fnc.$get(LINK),""))) {
      //<< if blnForce {
      if (mOp.Logical(blnForce.get())) {
        //<< write "<A HREF="""
        m$.Cmd.Write("<A HREF=\"");
      }
      //<< } else {
      else {
        //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$^WWWTEXT(99))_""" onClick=""window.location='"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",99))),"\" onClick=\"window.location='"));
      }
      //<< } ; "Back"
      //<< 
      //<< write LINK
      m$.Cmd.Write(LINK.get());
      //<< if 'blnForce write "'"
      if (mOp.Not(blnForce.get())) {
        m$.Cmd.Write("'");
      }
      //<< write """>"
      m$.Cmd.Write("\">");
      //<< IF blnForce WRITE "<IMG SRC="""_YGIF_"hback.gif"" "_YHEIGHT_" "_YWIDTH_" TITLE="""_$$^WWWTEXT(99)_""" border=0 id=""BUTTON_BACK""></A>"
      if (mOp.Logical(blnForce.get())) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"hback.gif\" "),m$.var("YHEIGHT").get())," "),m$.var("YWIDTH").get())," TITLE=\""),m$.fnc$("WWWTEXT.main",99)),"\" border=0 id=\"BUTTON_BACK\"></A>"));
      }
    }
    //<< }
    //<< 
    //<< ;WENN KEIN FORMULAR ;when no form
    //<< IF (NOBUTTON'=1) && (+$GET(YHEAD)=0) && (YQ=0) && ($get(YTARGET)="") {
    if ((mOp.NotEqual(NOBUTTON.get(),1)) && (mOp.Equal(mOp.Positive(m$.Fnc.$get(YHEAD)),0)) && (mOp.Equal(YQ.get(),0)) && (mOp.Equal(m$.Fnc.$get(m$.var("YTARGET")),""))) {
      //<< ;I +$P(YVOR,Y,24)'=1!(YUSER="")!(YBED="UNKNOWN") W "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWTEXT(99)_""" onClick=""window.history.back()"">" Q
      //<< IF YUSER'="" && (YBED'="UNKNOWN") && (blnForce) WRITE "<A HREF="""_YAKTION_"EP=WWWMENU" DO ^WWWCGI WRITE """>" WRITE "<IMG SRC="""_YGIF_"end.gif"" "_YHEIGHT_" "_YWIDTH_" TITLE="""_$$^WWWTEXT(10)_""" border=0 id=""BUTTON_BACK""></A>"
      if (mOp.NotEqual(m$.var("YUSER").get(),"") && (mOp.NotEqual(m$.var("YBED").get(),"UNKNOWN")) && mOp.Logical((blnForce.get()))) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"",m$.var("YAKTION").get()),"EP=WWWMENU"));
        m$.Cmd.Do("WWWCGI.main");
        m$.Cmd.Write("\">");
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"end.gif\" "),m$.var("YHEIGHT").get())," "),m$.var("YWIDTH").get())," TITLE=\""),m$.fnc$("WWWTEXT.main",10)),"\" border=0 id=\"BUTTON_BACK\"></A>"));
      }
    }
    //<< } ; "Cancel"
    //<< 
    //<< //WRITE YCR
    //<< WRITE "</TD></TR></TABLE>"
    m$.Cmd.Write("</TD></TR></TABLE>");
    //<< 
    //<< ;--------------------------------------- TABLE 2
    //<< 
    //<< if blnCenter write "<CENTER>"
    if (mOp.Logical(blnCenter.get())) {
      m$.Cmd.Write("<CENTER>");
    }
    //<< IF blnFramed {
    if (mOp.Logical(blnFramed.get())) {
      //<< DO ^WWWFRAME(0)
      m$.Cmd.Do("WWWFRAME.main",0);
      //<< WRITE "<TR><TD>"
      m$.Cmd.Write("<TR><TD>");
    }
    //<< }
    //<< 
    //<< WRITE "<TABLE CELLSPACING=0 BORDER=0>"
    m$.Cmd.Write("<TABLE CELLSPACING=0 BORDER=0>");
    //<< WRITE "<TR><TD>"
    m$.Cmd.Write("<TR><TD>");
    //<< IF 'blnForce WRITE "<BR>"   ;WRITE "<HR>"
    if (mOp.Not(blnForce.get())) {
      m$.Cmd.Write("<BR>");
    }
    //<< WRITE "</TD></TR>"
    m$.Cmd.Write("</TD></TR>");
    //<< 
    //<< ;-----
    //<< 
    //<< WRITE "<TR><TD>"
    m$.Cmd.Write("<TR><TD>");
    //<< 
    //<< IF '$FIND(YA,"|") {
    if (mOp.Not(m$.Fnc.$find(YA.get(),"|"))) {
      //<< set blnLong = ($length(YA)>100)                         ; SR17160
      blnLong.set((mOp.Greater(m$.Fnc.$length(YA.get()),100)));
      //<< write $select(blnLong:"<H5>",1:"<H3>")
      m$.Cmd.Write(m$.Fnc.$select(blnLong.get(),"<H5>",1,"<H3>"));
      //<< ;   IF $LENGTH(YA)'>100 WRITE "<H3>"
      //<< ;   IF $LENGTH(YA)>100  WRITE "<H5>"
      //<< IF $GET(YHEAD)=1                     WRITE "<FONT FACE=ARIAL>"
      if (mOp.Equal(m$.Fnc.$get(YHEAD),1)) {
        m$.Cmd.Write("<FONT FACE=ARIAL>");
      }
      //<< IF ($GET(LINK)'="") && (NOBUTTON'=2) WRITE "<A HREF="""_LINK_""">"
      if ((mOp.NotEqual(m$.Fnc.$get(LINK),"")) && (mOp.NotEqual(NOBUTTON.get(),2))) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"",LINK.get()),"\">"));
      }
      //<< WRITE $$^WWWUML(YA,HTML)
      m$.Cmd.Write(m$.fnc$("WWWUML.main",YA.get(),HTML.get()));
      //<< ;   IF $GET(LINK)'=""                    WRITE "</A>"       ; SR17160
      //<< IF ($GET(LINK)'="") && (NOBUTTON'=2) WRITE "</A>"
      if ((mOp.NotEqual(m$.Fnc.$get(LINK),"")) && (mOp.NotEqual(NOBUTTON.get(),2))) {
        m$.Cmd.Write("</A>");
      }
      //<< IF $GET(YHEAD)=1                     WRITE "</FONT>"
      if (mOp.Equal(m$.Fnc.$get(YHEAD),1)) {
        m$.Cmd.Write("</FONT>");
      }
      //<< write $select(blnLong:"</H5>",1:"</H3>")
      m$.Cmd.Write(m$.Fnc.$select(blnLong.get(),"</H5>",1,"</H3>"));
    }
    //<< ;   IF $LENGTH(YA)'>100 WRITE "</H3>"                       ; SR17160
    //<< ;   IF $LENGTH(YA)>100 WRITE "</H5>"
    //<< 
    //<< } else {
    else {
      //<< FOR YI=1:1 {
      mVar YI = m$.var("YI");
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        //<< SET YI(1)=$PIECE(YA,"|",YI)
        YI.var(1).set(m$.Fnc.$piece(YA.get(),"|",YI.get()));
        //<< QUIT:YI(1)=""
        if (mOp.Equal(YI.var(1).get(),"")) {
          break;
        }
        //<< 
        //<< set blnLong = ($length(YI(1))>100)                  ; SR17160
        blnLong.set((mOp.Greater(m$.Fnc.$length(YI.var(1).get()),100)));
        //<< write $select(blnLong:"<H5>",1:"<H3>")
        m$.Cmd.Write(m$.Fnc.$select(blnLong.get(),"<H5>",1,"<H3>"));
        //<< ;   IF $LENGTH(YI(1))'>100 WRITE "<H3>"
        //<< ;   IF $LENGTH(YI(1))>100 WRITE "<H5>"
        //<< IF ($GET(LINK)'="") && (NOBUTTON'=2) WRITE "<A HREF="""_LINK_""">"
        if ((mOp.NotEqual(m$.Fnc.$get(LINK),"")) && (mOp.NotEqual(NOBUTTON.get(),2))) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"",LINK.get()),"\">"));
        }
        //<< WRITE $$^WWWUML(YI(1),HTML)
        m$.Cmd.Write(m$.fnc$("WWWUML.main",YI.var(1).get(),HTML.get()));
        //<< ;   IF $GET(LINK)'=""                    WRITE "</A>"   ; SR17160
        //<< IF ($GET(LINK)'="") && (NOBUTTON'=2) WRITE "</A>"
        if ((mOp.NotEqual(m$.Fnc.$get(LINK),"")) && (mOp.NotEqual(NOBUTTON.get(),2))) {
          m$.Cmd.Write("</A>");
        }
        //<< write $select(blnLong:"</H5>",1:"</H3>")
        m$.Cmd.Write(m$.Fnc.$select(blnLong.get(),"</H5>",1,"</H3>"));
        //<< ;   IF $LENGTH(YI(1))'>100 WRITE "</H3>"                ; SR17160
        //<< ;   IF $LENGTH(YI(1))>100 WRITE "</H5>"
        //<< IF $PIECE(YA,Y,YI+1)'="" {
        if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),mOp.Add(YI.get(),1)),"")) {
          //<< WRITE "</TD></TR>"
          m$.Cmd.Write("</TD></TR>");
          //<< WRITE "<TR><TD>"
          m$.Cmd.Write("<TR><TD>");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< WRITE "</TD></TR>"
    m$.Cmd.Write("</TD></TR>");
    //<< 
    //<< ;-----
    //<< 
    //<< WRITE "<TR><TD>"
    m$.Cmd.Write("<TR><TD>");
    //<< IF 'blnForce WRITE "<BR>"  ;WRITE "<HR>"
    if (mOp.Not(blnForce.get())) {
      m$.Cmd.Write("<BR>");
    }
    //<< WRITE "</TD</TR>"
    m$.Cmd.Write("</TD</TR>");
    //<< WRITE "</TABLE>"
    m$.Cmd.Write("</TABLE>");
    //<< 
    //<< WRITE "</FONT>"
    m$.Cmd.Write("</FONT>");
    //<< 
    //<< IF blnFramed {
    if (mOp.Logical(blnFramed.get())) {
      //<< WRITE "</TD></TR>"
      m$.Cmd.Write("</TD></TR>");
      //<< DO ^WWWFRAME(1)
      m$.Cmd.Do("WWWFRAME.main",1);
    }
    //<< }
    //<< 
    //<< IF blnCenter WRITE "</CENTER>"
    if (mOp.Logical(blnCenter.get())) {
      m$.Cmd.Write("</CENTER>");
    }
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< IF +$GET(YHEAD)=0 {
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(YHEAD)),0)) {
      //<< DO ^WWWUP(1)  ;ANKER NACH OBEN ;armature within upstairs
      m$.Cmd.Do("WWWUP.main",1);
      //<< DO ^WWWSTOP   ;ENDE ;termination
      m$.Cmd.Do("WWWSTOP.main");
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

//<< 
//<< 
}
