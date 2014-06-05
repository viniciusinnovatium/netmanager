//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMA
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:41
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

//<< WWWFORMA
public class WWWFORMA extends mClass {

  public void main() {
    _WWWFORMA();
  }

  public void _WWWFORMA() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANZEIGEN SUCHFUNKTION
    //<< ;       Display table of keys and fields for a class
    //<< ;
    //<< ;   +-------------------------------------------------------------------------+
    //<< ;   | P/D  :  #  :  Text in Forms  :  Input Type  :  Input Size  :  Index Key |
    //<< ;   +-------------------------------------------------------------------------+
    //<< ;
    //<< ; Called by : Form WWW001 - After Primary Key
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 24-Jun-2005   GRF     SR12777 : Activated enhancement
    //<< ; 21-Jun-2005   GRF     Proposed enhancement to class listing for relations so
    //<< ;                       don't need to hover over property to see relation name.
    //<< ; 07-Jun-2005   Paul K  Don't jump to WWW100 when a Yes/No property.
    //<< ; 26.06.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< quit:YSEITE>1
    if (mOp.Greater(m$.var("YSEITE").get(),1)) {
      return;
    }
    //<< 
    //<< set YDDSATZ = 1
    mVar YDDSATZ = m$.var("YDDSATZ");
    YDDSATZ.set(1);
    //<< set YNKEY   = $translate($$$KEY1(YKEY),"""")
    mVar YNKEY = m$.var("YNKEY");
    YNKEY.set(m$.Fnc.$translate(include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEY")),"\""));
    //<< 
    //<< new YFKEY,YDATEI,YSUCH,YSUCH1,YFORM,YI,YBACK,YKEY,YSATZ
    mVar YFKEY = m$.var("YFKEY");
    mVar YDATEI = m$.var("YDATEI");
    mVar YSUCH = m$.var("YSUCH");
    mVar YSUCH1 = m$.var("YSUCH1");
    mVar YFORM = m$.var("YFORM");
    mVar YI = m$.var("YI");
    mVar YBACK = m$.var("YBACK");
    mVar YKEY = m$.var("YKEY");
    mVar YSATZ = m$.var("YSATZ");
    m$.newVar(YFKEY,YDATEI,YSUCH,YSUCH1,YFORM,YI,YBACK,YKEY,YSATZ);
    //<< 
    //<< set YBACK = "WWW001,"
    YBACK.set("WWW001,");
    //<< set YKEY  = YNKEY
    YKEY.set(YNKEY.get());
    //<< set YFKEY = YKEY
    YFKEY.set(YKEY.get());
    //<< 
    //<< quit:YNKEY=""
    if (mOp.Equal(YNKEY.get(),"")) {
      return;
    }
    //<< 
    //<< write YCR,"</TABLE>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    //<< do ^WWWFRAME(0)
    m$.Cmd.Do("WWWFRAME.main",0);
    //<< do KOPF
    m$.Cmd.Do("KOPF");
    //<< do ANKEY
    m$.Cmd.Do("ANKEY");
    //<< do ANDAT
    m$.Cmd.Do("ANDAT");
    //<< do ^WWWFRAME(1)
    m$.Cmd.Do("WWWFRAME.main",1);
    //<< write YCR,"<TABLE BORDER=0 CELLSPACING=0>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=0 CELLSPACING=0>");
    //<< quit
    return;
  }

  //<< 
  //<< KOPF
  public Object KOPF() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Heading     UEBERSCHRIFT
    //<< ;
    //<< ; History :
    //<< ; 25-Jun-2007   RPW     SR15539: Rewrote into { syntax
    //<< ;-------------------------------------------------------------------------------
    //<< quit:YNKEY=""
    if (mOp.Equal(m$.var("YNKEY").get(),"")) {
      return null;
    }
    //<< 
    //<< set YDATEI="WWW002"
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set("WWW002");
    //<< write YCR,"<TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
    //<< set YDDSATZ=YDDSATZ+1
    mVar YDDSATZ = m$.var("YDDSATZ");
    YDDSATZ.set(mOp.Add(m$.var("YDDSATZ").get(),1));
    //<< write "<TH NOWRAP ALIGN=LEFT BGCOLOR="_YDARKGRAY_"><FONT SIZE=2>&nbsp;</TH>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<TH NOWRAP ALIGN=LEFT BGCOLOR=",m$.var("YDARKGRAY").get()),"><FONT SIZE=2>&nbsp;</TH>"));
    //<< write "<TH NOWRAP ALIGN=LEFT BGCOLOR="_YDARKGRAY_"><FONT SIZE=2>#</TH>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<TH NOWRAP ALIGN=LEFT BGCOLOR=",m$.var("YDARKGRAY").get()),"><FONT SIZE=2>#</TH>"));
    //<< for YLFN=2,3,4,6 {
    mVar YLFN = m$.var("YLFN");
    for (Object _YLFN: new Object[] {2,3,4,6}) {
    YLFN.set(_YLFN);
      //<< write "<TH NOWRAP ALIGN=LEFT BGCOLOR="_YDARKGRAY_"><FONT SIZE=2>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TH NOWRAP ALIGN=LEFT BGCOLOR=",m$.var("YDARKGRAY").get()),"><FONT SIZE=2>"));
      //<< if $data(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,YDATEI.get(),_YLFN,m$.var("SPRACHE").get(),1)))) {
        //<< write $$^WWWUML($piece($get(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)),Y,1),1)
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0031",0,YDATEI.get(),_YLFN,m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),1));
      }
      //<< } else {
      else {
        //<< write $$^WWWUML($piece($get(^WWW003(0,YDATEI,YLFN,1)),Y,2),1)
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),_YLFN,1)),m$.var("Y").get(),2),1));
      }
      //<< }
      //<< write YCR,"</TH>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TH>");
    }
    //<< }
    //<< write YCR,"</TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    //<< quit
    return null;
  }

  //<< 
  //<< ANKEY
  public Object ANKEY() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 26-Jun-2007   RPW     SR15539: Extracted the Unique Key handling
    //<< ;                       Passed in YINHALT to DrawImage, passed in YLFN and class to DATEN
    //<< ; 21-Dec-2006   JW      SR14235: Added reference to child window
    //<< ; 10-Nov-2005   JW      SR11904: Child user for popups
    //<< ;-------------------------------------------------------------------------------
    //<< quit:YNKEY=""
    if (mOp.Equal(m$.var("YNKEY").get(),"")) {
      return null;
    }
    //<< set YFORM="WWW002"
    mVar YFORM = m$.var("YFORM");
    YFORM.set("WWW002");
    //<< set YDATEI=YNKEY
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.var("YNKEY").get());
    //<< 
    //<< new YKEY
    mVar YKEY = m$.var("YKEY");
    m$.newVar(YKEY);
    //<< 
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< 
    //<< ; FIXME : ^WWW003s(0,2) will only have " " entries since D22 is deprecated. <GRF>
    //<< if '$data(^WWW003s(0,2,1,YDATEI)) && '$data(^WWW002(0,YNKEY)) do  quit
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW003s",0,2,1,YDATEI.get()))) && mOp.Not(m$.Fnc.$data(m$.var("^WWW002",0,m$.var("YNKEY").get())))) {
      //<< . write "<TR>"
      m$.Cmd.Write("<TR>");
      //<< . set YDDSATZ=YDDSATZ+1
      mVar YDDSATZ = m$.var("YDDSATZ");
      YDDSATZ.set(mOp.Add(m$.var("YDDSATZ").get(),1));
      //<< . write "<TD NOWRAP"
      m$.Cmd.Write("<TD NOWRAP");
      //<< . if YDDSATZ#2=1 write " BGCOLOR="_YWHITE
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
      }
      //<< . if YDDSATZ#2=0 write " BGCOLOR="_YGRAY
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
      }
      //<< . write ">"
      m$.Cmd.Write(">");
      //<< . write "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< . write "&nbsp;"
      m$.Cmd.Write("&nbsp;");
      //<< . write "</TD>",YCR
      m$.Cmd.Write("</TD>",m$.var("YCR").get());
      //<< . ;
      //<< . write "<TD NOWRAP"
      m$.Cmd.Write("<TD NOWRAP");
      //<< . if YDDSATZ#2=1 write " BGCOLOR="_YWHITE
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
      }
      //<< . if YDDSATZ#2=0 write " BGCOLOR="_YGRAY
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
      }
      //<< . write ">"
      m$.Cmd.Write(">");
      //<< . write "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< . write "&nbsp;"
      m$.Cmd.Write("&nbsp;");
      //<< . write "</TD>",YCR
      m$.Cmd.Write("</TD>",m$.var("YCR").get());
      //<< . ;
      //<< . write "<TD NOWRAP"
      m$.Cmd.Write("<TD NOWRAP");
      //<< . if YDDSATZ#2=1 write " BGCOLOR="_YWHITE
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
      }
      //<< . if YDDSATZ#2=0 write " BGCOLOR="_YGRAY
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
      }
      //<< . write ">"
      m$.Cmd.Write(">");
      //<< . write "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< . do
      do {
        //<< . . new YKEY
        m$.newVarBlock(2,YKEY);
        //<< . . set YKEY=YNKEY
        YKEY.set(m$.var("YNKEY").get());
        //<< . . set YDATEI=YNKEY
        YDATEI.set(m$.var("YNKEY").get());
        //<< . . write "<A"
        m$.Cmd.Write("<A");
        //<< . . write " TITLE="""_$$^WWWTEXT(374)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",374)),"\""));
        //<< . . write " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),YFORM.get()));
        //<< . . do ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< . . write """>"
        m$.Cmd.Write("\">");
      } while(false);
      m$.restoreVarBlock(2);
      //<< . write $$^WWWTEXT(278) ; No Primary Key
      m$.Cmd.Write(m$.fnc$("WWWTEXT.main",278));
      //<< . write "</A>"
      m$.Cmd.Write("</A>");
      //<< . write "</TD>",YCR
      m$.Cmd.Write("</TD>",m$.var("YCR").get());
      //<< . ;
      //<< . ;FOR YI=3,4,6,8 DO
      //<< . for YI=3,4,6 do
      mVar YI = m$.var("YI");
      for (Object _YI: new Object[] {3,4,6}) {
        YI.set(_YI);
        //<< . . write "<TD NOWRAP"
        m$.Cmd.Write("<TD NOWRAP");
        //<< . . if YDDSATZ#2=1 write " BGCOLOR="_YWHITE
        if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
          m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
        }
        //<< . . if YDDSATZ#2=0 write " BGCOLOR="_YGRAY
        if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
          m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
        }
        //<< . . write ">"
        m$.Cmd.Write(">");
        //<< . . write "<FONT SIZE=2>"
        m$.Cmd.Write("<FONT SIZE=2>");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "</TD>",YCR
        m$.Cmd.Write("</TD>",m$.var("YCR").get());
      }
      //<< . ;
      //<< . write "</TR>",YCR
      m$.Cmd.Write("</TR>",m$.var("YCR").get());
      return null;
    }
    //<< 
    //<< ; ... else ...
    //<< 
    //<< set YLFN=""
    mVar YLFN = m$.var("YLFN");
    YLFN.set("");
    //<< for  set YLFN=$order(^WWW002(0,YNKEY,YLFN)) quit:YLFN=""  do
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YNKEY").get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      //<< . do KillUniqueKeys(YNKEY) // SR15539
      m$.Cmd.Do("KillUniqueKeys",m$.var("YNKEY").get());
      //<< . ;IF $DATA(^WWW003s(0,2,1,pidClass)) DO   ; SR15539 : $$$WWW003UniqueKey() [D22] and thus index 2 is deprecated
      //<< . ;. NEW LFDD
      //<< . ;. SET LFDD=""
      //<< . ;. FOR  SET LFDD=$ORDER(^WWW003s(0,2,1,pidClass,LFDD)) QUIT:LFDD=""  DO
      //<< . ;. . SET $PIECE(^WWW003(0,pidClass,LFDD,1),Y,22)=""
      //<< . ;. . SET ^WWW003s(0,2," ",pidClass,LFDD)=""
      //<< . ;. . KILL ^WWW003s(0,2,1,pidClass,LFDD)
      //<< . ;
      //<< . set YSATZ=$get(^WWW002(0,YNKEY,YLFN,1))
      mVar YSATZ = m$.var("YSATZ");
      YSATZ.set(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YNKEY").get(),YLFN.get(),1)));
      //<< . set YKEY=YNKEY_","_YLFN
      YKEY.set(mOp.Concat(mOp.Concat(m$.var("YNKEY").get(),","),YLFN.get()));
      //<< . write "<TR>"
      m$.Cmd.Write("<TR>");
      //<< . set YDDSATZ=YDDSATZ+1
      mVar YDDSATZ = m$.var("YDDSATZ");
      YDDSATZ.set(mOp.Add(m$.var("YDDSATZ").get(),1));
      //<< . write "<TD NOWRAP"
      m$.Cmd.Write("<TD NOWRAP");
      //<< . if YDDSATZ#2=1 write " BGCOLOR="_YWHITE
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
      }
      //<< . if YDDSATZ#2=0 write " BGCOLOR="_YGRAY
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
      }
      //<< . write ">"
      m$.Cmd.Write(">");
      //<< . write "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< . do
      do {
        //<< . . set YDATEI=YNKEY
        YDATEI.set(m$.var("YNKEY").get());
        //<< . . write "<A"
        m$.Cmd.Write("<A");
        //<< . . write " TITLE="""_$$^WWWTEXT(374)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",374)),"\""));
        //<< . . write " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),YFORM.get()));
        //<< . . do ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< . . write """>"
        m$.Cmd.Write("\">");
      } while(false);
      //<< . set YINHALT="primaer.gif"
      mVar YINHALT = m$.var("YINHALT");
      YINHALT.set("primaer.gif");
      //<< . if $piece(YSATZ,Y,35)'="" set YINHALT=$piece($get(^WWW100(0,"RELATIONSHIP",SPRACHE,$piece(YSATZ,Y,35),1)),Y,1)
      if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),35),"")) {
        YINHALT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"RELATIONSHIP",m$.var("SPRACHE").get(),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),35),1)),m$.var("Y").get(),1));
      }
      //<< . do DrawImage(YINHALT) // SR15539
      m$.Cmd.Do("DrawImage",YINHALT.get());
      //<< . write "</TD>",YCR
      m$.Cmd.Write("</TD>",m$.var("YCR").get());
      //<< . ;
      //<< . write "<TD NOWRAP"
      m$.Cmd.Write("<TD NOWRAP");
      //<< . if YDDSATZ#2=1 write " BGCOLOR="_YWHITE
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
      }
      //<< . if YDDSATZ#2=0 write " BGCOLOR="_YGRAY
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
      }
      //<< . write ">"
      m$.Cmd.Write(">");
      //<< . write "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< . do
      do {
        //<< . . set YDATEI=YNKEY
        YDATEI.set(m$.var("YNKEY").get());
        //<< . . write "<A"
        m$.Cmd.Write("<A");
        //<< . . write " TITLE="""_$$^WWWTEXT(374)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",374)),"\""));
        //<< . . write " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),YFORM.get()));
        //<< . . do ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< . . write """>"
        m$.Cmd.Write("\">");
      } while(false);
      //<< . write YLFN
      m$.Cmd.Write(YLFN.get());
      //<< . write "</A>"
      m$.Cmd.Write("</A>");
      //<< . write "</TD>",YCR
      m$.Cmd.Write("</TD>",m$.var("YCR").get());
      //<< . ;
      //<< . ;FOR YI=2,3,4,6,8 SET YINHALT=$PIECE(YSATZ,Y,YI) DO  ;TYBD;14,2,2005
      //<< . for YI=2,3,4,6 set YINHALT=$piece(YSATZ,Y,YI) do
      mVar YI = m$.var("YI");
      for (Object _YI: new Object[] {2,3,4,6}) {
        YI.set(_YI);
        YINHALT.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),_YI));
        //<< . . if YI=2 if $data(^WWW0021(0,YNKEY,YLFN,SPRACHE,1)) set YINHALT=$piece(^WWW0021(0,YNKEY,YLFN,SPRACHE,1),Y,1)
        if (mOp.Equal(_YI,2)) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0021",0,m$.var("YNKEY").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
            YINHALT.set(m$.Fnc.$piece(m$.var("^WWW0021",0,m$.var("YNKEY").get(),YLFN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
          }
        }
        //<< . . new YLFN
        m$.newVarBlock(2,YLFN);
        //<< . . set YLFN=YI
        YLFN.set(_YI);
        //<< . . write "<TD NOWRAP"
        m$.Cmd.Write("<TD NOWRAP");
        //<< . . if YDDSATZ#2=1 write " BGCOLOR="_YWHITE
        if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
          m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
        }
        //<< . . if YDDSATZ#2=0 write " BGCOLOR="_YGRAY
        if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
          m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
        }
        //<< . . write ">"
        m$.Cmd.Write(">");
        //<< . . write "<FONT SIZE=2>"
        m$.Cmd.Write("<FONT SIZE=2>");
        //<< . . do
        do {
          //<< . . . set YDATEI=YNKEY
          YDATEI.set(m$.var("YNKEY").get());
          //<< . . . write "<A"
          m$.Cmd.Write("<A");
          //<< . . . if $piece(YSATZ,Y,8)="" write " TITLE="""_$$^WWWTEXT(374)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
          if (mOp.Equal(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",374)),"\""));
          }
          //<< . . . if YI=3 if $piece(YSATZ,Y,8)'="" write " TITLE="""_$piece(YSATZ,Y,8)_"("_$translate($piece(YSATZ,Y,9),"""")_")"""   ;DATENSATZ AUSWÄHLEN ;data record pick out
          if (mOp.Equal(_YI,3)) {
            if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=\"",m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8)),"("),m$.Fnc.$translate(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),9),"\"")),")\""));
            }
          }
          //<< . . .
          //<< . . . if YI=3 if ($piece(YSATZ,Y,8)'="") || ($piece(YSATZ,Y,26)'="") do  quit
          if (mOp.Equal(_YI,3)) {
            if ((mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8),"")) || (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26),""))) {
              //<< . . . . new YFORM,YKEY,YDATEI,YFKEY,strURL
              mVar YFKEY = m$.var("YFKEY");
              mVar strURL = m$.var("strURL");
              m$.newVarBlock(4,YFORM,YKEY,YDATEI,YFKEY,strURL);
              //<< . . . . set YKEY=""
              YKEY.set("");
              //<< . . . . if $piece(YSATZ,Y,8)'=""  set YKEY=$piece(YSATZ,Y,8)
              if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8),"")) {
                YKEY.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8));
              }
              //<< . . . . if $piece(YSATZ,Y,26)'="" set YKEY=$piece(YSATZ,Y,26)
              if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26),"")) {
                YKEY.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26));
              }
              //<< . . . . set YDATEI=YKEY
              YDATEI.set(YKEY.get());
              //<< . . . .
              //<< . . . . //SR14235
              //<< . . . . set strURL = $$FormURL^WWWCGI("WWW001",YDATEI,,$$$YES)
              strURL.set(m$.fnc$("WWWCGI.FormURL","WWW001",YDATEI.get(),null,include.COMSYS.$$$YES(m$)));
              //<< . . . . write " href='' onclick=""subWindow('"_strURL_"','TEILEFRAME1'); return false;"">"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" href='' onclick=\"subWindow('",strURL.get()),"','TEILEFRAME1'); return false;\">"));
              break;
            }
            m$.restoreVarBlock(4);
          }
          //<< . . . .
          //<< . . . . // WRITE " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM=WWW001"
          //<< . . . . // set blnPOPUP = $$$YES        //SR11904
          //<< . . . . // DO ^WWWCGI
          //<< . . . . // WRITE """"
          //<< . . . . // WRITE " TARGET=TEILEFRAME1"
          //<< . . . . // WRITE ">"
          //<< . . . ;
          //<< . . . write " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),YFORM.get()));
          //<< . . . do ^WWWCGI
          m$.Cmd.Do("WWWCGI.main");
          //<< . . . write """>"
          m$.Cmd.Write("\">");
        } while(false);
        //<< . . ;
        //<< . . set YDATEI="WWW002"
        YDATEI.set("WWW002");
        //<< . . if YI=3 if YINHALT=16 if $piece(YSATZ,Y,26)'="" set YINHALT=$piece(YSATZ,Y,26) set YLFN=8 ;ALTERNATIVE DATATYPE
        if (mOp.Equal(_YI,3)) {
          if (mOp.Equal(YINHALT.get(),16)) {
            if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26),"")) {
              YINHALT.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26));
              YLFN.set(8);
            }
          }
        }
        //<< . . if YI=3 if $piece(YSATZ,Y,8)'="" set YINHALT=$piece(YSATZ,Y,8) set YLFN=8  ;TYBD;14,2,2005
        if (mOp.Equal(_YI,3)) {
          if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8),"")) {
            YINHALT.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8));
            YLFN.set(8);
          }
        }
        //<< . . do DATEN("WWW002",YLFN,.YINHALT) // SR15539
        m$.Cmd.Do("DATEN","WWW002",YLFN.get(),YINHALT);
        //<< . . if YI=4 if $piece(YSATZ,Y,26)'="" if $piece(YSATZ,Y,3)=16 set YINHALT=$$^WWWTEXT("WWW00045")  ;OID
        if (mOp.Equal(_YI,4)) {
          if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26),"")) {
            if (mOp.Equal(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),3),16)) {
              YINHALT.set(m$.fnc$("WWWTEXT.main","WWW00045"));
            }
          }
        }
        //<< . . if YI=3 write "as "
        if (mOp.Equal(_YI,3)) {
          m$.Cmd.Write("as ");
        }
        //<< . . write $$^WWWUML(YINHALT,1)
        m$.Cmd.Write(m$.fnc$("WWWUML.main",YINHALT.get(),1));
        //<< . . ;IF YLFN=8 IF $GET(SPRACHE)="DE" IF $PIECE(YSATZ,Y,9)'="" WRITE " (",$PIECE(YSATZ,Y,9),")"   ;SR12777;GRF
        //<< . . if YLFN=8 if $piece(YSATZ,Y,9)'="" do
        if (mOp.Equal(YLFN.get(),8)) {
          if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),9),"")) {
            //<< . . . write "<FONT SIZE=1> (",$translate($piece($piece(YSATZ,Y,9),","),$$$DBLQUOTE),")</FONT>"
            m$.Cmd.Write("<FONT SIZE=1> (",m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),9),","),include.COMSYSString.$$$DBLQUOTE(m$)),")</FONT>");
          }
        }
        //<< . . if YINHALT="" write "&nbsp;"
        if (mOp.Equal(YINHALT.get(),"")) {
          m$.Cmd.Write("&nbsp;");
        }
        //<< . . write "</A>"
        m$.Cmd.Write("</A>");
        //<< . . write "</TD>",YCR
        m$.Cmd.Write("</TD>",m$.var("YCR").get());
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . write "</TR>",YCR
      m$.Cmd.Write("</TR>",m$.var("YCR").get());
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< ANDAT ;
  public Object ANDAT() {
    //<< ;/*-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 21-Dec-2006   JW      SR14235: Added reference to child window
    //<< ; 10-Nov-2005   JW      SR11904: Child user for popups
    //<< ;-------------------------------------------------------------------------------*/
    //<< quit:YNKEY=""
    if (mOp.Equal(m$.var("YNKEY").get(),"")) {
      return null;
    }
    //<< set YFORM="WWW003"
    mVar YFORM = m$.var("YFORM");
    YFORM.set("WWW003");
    //<< set YDATEI=YNKEY
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.var("YNKEY").get());
    //<< 
    //<< new YKEY
    mVar YKEY = m$.var("YKEY");
    m$.newVar(YKEY);
    //<< 
    //<< if '$data(^WWW003(0,YNKEY)) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW003",0,m$.var("YNKEY").get())))) {
      //<< do NoDataFields(YNKEY)
      m$.Cmd.Do("NoDataFields",m$.var("YNKEY").get());
    }
    //<< } else {
    else {
      //<< do DataFields(YNKEY)
      m$.Cmd.Do("DataFields",m$.var("YNKEY").get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< /*
  //<< IF '$DATA(^WWW003(0,YNKEY)) DO  QUIT
  //<< . WRITE "<TR>"
  //<< . SET YDDSATZ=YDDSATZ+1
  //<< . WRITE "<TD NOWRAP"
  //<< . IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
  //<< . IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
  //<< . WRITE ">"
  //<< . WRITE "<FONT SIZE=2>"
  //<< . WRITE "&nbsp;"
  //<< . WRITE YCR,"</TD>"
  //<< . WRITE "<TD NOWRAP"
  //<< . IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
  //<< . IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
  //<< . WRITE ">"
  //<< . WRITE "<FONT SIZE=2>"
  //<< . WRITE "&nbsp;"
  //<< . WRITE YCR,"</TD>"
  //<< . WRITE "<TD NOWRAP"
  //<< . IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
  //<< . IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
  //<< . WRITE ">"
  //<< . WRITE "<FONT SIZE=2>"
  //<< . DO
  //<< . . NEW YKEY
  //<< . . SET YKEY=YNKEY
  //<< . . SET YDATEI=YNKEY
  //<< . . WRITE "<A"
  //<< . . WRITE " TITLE="""_$$^WWWTEXT(374)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
  //<< . . WRITE " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
  //<< . . DO ^WWWCGI
  //<< . . WRITE """>"
  //<< . . QUIT
  //<< . WRITE $$^WWWTEXT(279)     ; No Data Items
  //<< . WRITE "</A>"
  //<< . WRITE YCR,"</TD>"
  //<< . FOR YI=3,4,6 DO
  //<< . . WRITE "<TD NOWRAP"
  //<< . . IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
  //<< . . IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
  //<< . . WRITE ">"
  //<< . . WRITE "<FONT SIZE=2>"
  //<< . . WRITE "&nbsp;"
  //<< . . WRITE YCR,"</TD>"
  //<< . . QUIT
  //<< . WRITE YCR,"</TR>"
  //<< 
  //<< SET YLFN=""
  //<< FOR  SET YLFN=$ORDER(^WWW003(0,YNKEY,YLFN)) QUIT:YLFN=""  DO
  //<< . SET YSATZ=$GET(^WWW003(0,YNKEY,YLFN,1))
  //<< . SET YKEY=YNKEY_","_YLFN
  //<< . WRITE "<TR>"
  //<< . SET YDDSATZ=YDDSATZ+1
  //<< . WRITE "<TD NOWRAP"
  //<< . IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
  //<< . IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
  //<< . WRITE ">"
  //<< . WRITE "<FONT SIZE=2>"
  //<< . DO
  //<< . . SET YDATEI=YNKEY
  //<< . . WRITE "<A"
  //<< . . WRITE " TITLE="""_$$^WWWTEXT(374)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
  //<< . . WRITE " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
  //<< . . DO ^WWWCGI
  //<< . . WRITE """>"
  //<< . . QUIT
  //<< . SET YINHALT="daten.gif"
  //<< . IF $PIECE(YSATZ,Y,22)=1 SET YINHALT="primaer.gif"   ; FIXME : $$$WWW003UniqueKey() [D22] is deprecated <GRF>
  //<< . IF $PIECE(YSATZ,Y,3)=16 SET YINHALT="1:n"  ;1-n Beziehung
  //<< . IF $PIECE(YSATZ,Y,35)'="" SET YINHALT=$PIECE($GET(^WWW100(0,"RELATIONSHIP",SPRACHE,$PIECE(YSATZ,Y,35),1)),Y,1)
  //<< . DO THUMP
  //<< . WRITE YCR,"</TD>"
  //<< . WRITE "<TD NOWRAP"
  //<< . IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
  //<< . IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
  //<< . WRITE ">"
  //<< . WRITE "<FONT SIZE=2>"
  //<< . DO
  //<< . . SET YDATEI=YNKEY
  //<< . . WRITE "<A"
  //<< . . WRITE " TITLE="""_$$^WWWTEXT(374)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
  //<< . . WRITE " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
  //<< . . DO ^WWWCGI
  //<< . . WRITE """>"
  //<< . . QUIT
  //<< . WRITE YLFN
  //<< . WRITE "</A>"
  //<< . WRITE YCR,"</TD>"
  //<< . ;FOR YI=2,3,4,6,8 SET YINHALT=$PIECE(YSATZ,Y,YI) DO  ;TYBD;14,2,2005
  //<< . FOR YI=2,3,4,6 SET YINHALT=$PIECE(YSATZ,Y,YI) DO
  //<< . . IF YI=2 IF $DATA(^WWW0031(0,YNKEY,YLFN,SPRACHE,1)) SET YINHALT=$PIECE(^WWW0031(0,YNKEY,YLFN,SPRACHE,1),Y,1)
  //<< . . IF YI=2 IF YINHALT="_FREE" set YINHALT=YINHALT_" ("_$piece(YSATZ,Y,25)_")"
  //<< . . NEW YLFN
  //<< . . SET YLFN=YI
  //<< . . WRITE "<TD NOWRAP"
  //<< . . IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
  //<< . . IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
  //<< . . WRITE ">"
  //<< . . WRITE "<FONT SIZE=2>"
  //<< . . DO
  //<< . . . SET YDATEI=YNKEY
  //<< . . . WRITE "<A"
  //<< . . . IF $PIECE(YSATZ,Y,8)_$PIECE(YSATZ,Y,26)=""!(YI'=3) WRITE " TITLE="""_$$^WWWTEXT(374)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
  //<< . . . IF YI=3 IF YINHALT'=2 IF $PIECE(YSATZ,Y,8)'="" IF $PIECE(YSATZ,Y,26)="" WRITE " TITLE="""_$PIECE(YSATZ,Y,8)_"("_$TRANSLATE($PIECE(YSATZ,Y,9),"""")_")"""   ;DATENSATZ AUSWÄHLEN ;data record pick out
  //<< . . . IF YI=3 IF YINHALT'=2 IF $PIECE(YSATZ,Y,26)'="" WRITE " TITLE="""_$PIECE(YSATZ,Y,26)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
  //<< . . . IF YI=3 IF YINHALT'=2 IF $PIECE(YSATZ,Y,8)'=""!($PIECE(YSATZ,Y,26)'="") DO  QUIT
  //<< . . . . NEW YFORM,YKEY,YDATEI,YFKEY,strURL
  //<< . . . . SET YKEY=""
  //<< . . . . IF $PIECE(YSATZ,Y,8)'="" SET YKEY=$PIECE(YSATZ,Y,8)
  //<< . . . . IF $PIECE(YSATZ,Y,26)'="" SET YKEY=$PIECE(YSATZ,Y,26)
  //<< . . . . SET YDATEI=YKEY
  //<< . . . .
  //<< . . . . //SR14235
  //<< . . . . set strURL = $$FormURL^WWWCGI("WWW001",YDATEI,,$$$YES)
  //<< . . . . write " href='' onclick=""subWindow('"_strURL_"','TEILEFRAME1'); return false;"">"
  //<< . . . .
  //<< . . . . // WRITE " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM=WWW001"
  //<< . . . . // set blnPOPUP = $$$YES        //SR11904
  //<< . . . . // DO ^WWWCGI
  //<< . . . . // WRITE """"
  //<< . . . . // WRITE " TARGET=TEILEFRAME1"
  //<< . . . . // WRITE ">"
  //<< . . . ;
  //<< . . . WRITE " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
  //<< . . . DO ^WWWCGI
  //<< . . . WRITE """>"
  //<< . . . QUIT
  //<< . . SET YDATEI="WWW003"
  //<< . . IF YI=3 IF YINHALT=16 IF $PIECE(YSATZ,Y,26)'="" SET YINHALT=$PIECE(YSATZ,Y,26) SET YLFN=8 ;ALTERNATIVE DATATYPE
  //<< . . IF YI=3 IF YINHALT'=2 IF $PIECE(YSATZ,Y,8)'="" SET YINHALT=$PIECE(YSATZ,Y,8) SET YLFN=8  ;TYBD;14,2,2005
  //<< . . DO DATEN
  //<< . . IF YI=4 IF $PIECE(YSATZ,Y,26)'="" IF $PIECE(YSATZ,Y,3)=16 SET YINHALT=$$^WWWTEXT("WWW00045")  ;OID
  //<< . . if YI=3 write "as "
  //<< . . WRITE $$^WWWUML(YINHALT,1)
  //<< . . ;IF YLFN=8 IF $GET(SPRACHE)="DE" IF $PIECE(YSATZ,Y,9)'="" WRITE " (",$PIECE(YSATZ,Y,9),")"   ;SR12777;GRF
  //<< . . if YLFN=8 if $piece(YSATZ,Y,9)'="" do
  //<< . . . write "<FONT SIZE=1> (",$translate($piece($piece(YSATZ,Y,9),","),$$$DBLQUOTE),")</FONT>"
  //<< . . IF YINHALT="" WRITE "&nbsp;"
  //<< . . WRITE "</A>"
  //<< . . WRITE YCR,"</TD>"
  //<< . . QUIT
  //<< . WRITE YCR,"</TR>"
  //<< 
  //<< QUIT
  //<< */
  //<< 
  //<< DataFields(pidClass)
  public Object DataFields(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Draw the data field definitions to the screen
    //<< ;
    //<< ; Inputs:
    //<< ; pidClass: The class we are listing
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,strColour,objField,YKEY,strImage,strRelationship
    mVar idField = m$.var("idField");
    mVar strColour = m$.var("strColour");
    mVar objField = m$.var("objField");
    mVar YKEY = m$.var("YKEY");
    mVar strImage = m$.var("strImage");
    mVar strRelationship = m$.var("strRelationship");
    m$.newVar(idField,strColour,objField,YKEY,strImage,strRelationship);
    //<< 
    //<< $$$Order3(^WWW003,0,pidClass,idField)
    idField.set("");
    for (;true;) {
      idField.set(m$.Fnc.$order(m$.var("^WWW003",0,pidClass.get(),idField.get())));
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< set objField=$get(^WWW003(0,pidClass,idField,1))
      objField.set(m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),idField.get(),1)));
      //<< set YKEY=pidClass_","_idField
      YKEY.set(mOp.Concat(mOp.Concat(pidClass.get(),","),idField.get()));
      //<< set YDDSATZ=YDDSATZ+1
      mVar YDDSATZ = m$.var("YDDSATZ");
      YDDSATZ.set(mOp.Add(m$.var("YDDSATZ").get(),1));
      //<< set strColour=$select(YDDSATZ#2:YWHITE,1:YGRAY)
      strColour.set(m$.Fnc.$select(mOp.Modulus(YDDSATZ.get(),2),m$.var("YWHITE").get(),1,m$.var("YGRAY").get()));
      //<< write "<TR><TD NOWRAP BGCOLOR="_strColour_"><FONT SIZE=2>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TR><TD NOWRAP BGCOLOR=",strColour.get()),"><FONT SIZE=2>"));
      //<< do SelectDataRecord()
      m$.Cmd.Do("SelectDataRecord");
      //<< set strImage="daten.gif"
      strImage.set("daten.gif");
      //<< 
      //<< if $$$WWW003UniqueKey(objField) set strImage="primaer.gif"
      if (mOp.Logical(include.WWWConst.$$$WWW003UniqueKey(m$,objField))) {
        strImage.set("primaer.gif");
      }
      //<< if $$$WWW003InputType(objField)=16 set strImage="1:n"  ;1-n Beziehung
      if (mOp.Equal(include.WWWConst.$$$WWW003InputType(m$,objField),16)) {
        strImage.set("1:n");
      }
      //<< set strRelationship=$$$WWW003Relationship(objField)
      strRelationship.set(include.WWWConst.$$$WWW003Relationship(m$,objField));
      //<< if strRelationship'="" set strImage=$piece($get(^WWW100(0,"RELATIONSHIP",SPRACHE,strRelationship,1)),Y,1)
      if (mOp.NotEqual(strRelationship.get(),"")) {
        strImage.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"RELATIONSHIP",m$.var("SPRACHE").get(),strRelationship.get(),1)),m$.var("Y").get(),1));
      }
      //<< 
      //<< do DrawImage(strImage)
      m$.Cmd.Do("DrawImage",strImage.get());
      //<< write "</TD><TD NOWRAP BGCOLOR="_strColour_"><FONT SIZE=2>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("</TD><TD NOWRAP BGCOLOR=",strColour.get()),"><FONT SIZE=2>"));
      //<< do SelectDataRecord()
      m$.Cmd.Do("SelectDataRecord");
      //<< write idField_"</A></TD>"
      m$.Cmd.Write(mOp.Concat(idField.get(),"</A></TD>"));
      //<< do DrawFields(pidClass,objField,idField,strColour)
      m$.Cmd.Do("DrawFields",pidClass.get(),objField.get(),idField.get(),strColour.get());
    }
    //<< $$$End
    //<< 
    //<< write YCR,"</TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< DrawFields(pidClass,pobjField,pidField,pstrColour)
  public Object DrawFields(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjField = m$.newVarRef("pobjField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrColour = m$.newVarRef("pstrColour",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; This draws the actual fields for the data field.
    //<< ;
    //<< ; Inputs:
    //<< ; pidClass  : The class we are listing
    //<< ; pobjField : The details of the current data field   (WWW003*)
    //<< ; pidField  : The id of the current data field
    //<< ; pstrColour: The colour of the row.
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idFieldSwap,strData
    mVar idField = m$.var("idField");
    mVar idFieldSwap = m$.var("idFieldSwap");
    mVar strData = m$.var("strData");
    m$.newVar(idField,idFieldSwap,strData);
    //<< 
    //<< for idField=2,3,4,6 {
    for (Object _idField: new Object[] {2,3,4,6}) {
    idField.set(_idField);
      //<< set strData=$piece(pobjField,Y,idField)
      strData.set(m$.Fnc.$piece(pobjField.get(),m$.var("Y").get(),_idField));
      //<< if idField=2 {
      if (mOp.Equal(_idField,2)) {
        //<< if $data(^WWW0031(0,pidClass,pidField,SPRACHE,1)) set strData=$piece(^WWW0031(0,pidClass,pidField,SPRACHE,1),Y,1)
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,pidClass.get(),pidField.get(),m$.var("SPRACHE").get(),1)))) {
          strData.set(m$.Fnc.$piece(m$.var("^WWW0031",0,pidClass.get(),pidField.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        }
        //<< if $$$TRIMWS(strData)=$$$FREE set strData=$$$FREE_" ["_$piece(pobjField,Y,25)_"]"
        if (mOp.Equal(include.COMSYSString.$$$TRIMWS(m$,strData),include.COMSYS.$$$FREE(m$))) {
          strData.set(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYS.$$$FREE(m$)," ["),m$.Fnc.$piece(pobjField.get(),m$.var("Y").get(),25)),"]"));
        }
      }
      //<< }
      //<< 
      //<< set idFieldSwap=idField
      idFieldSwap.set(_idField);
      //<< write "<TD NOWRAP"
      m$.Cmd.Write("<TD NOWRAP");
      //<< write " BGCOLOR="_pstrColour
      m$.Cmd.Write(mOp.Concat(" BGCOLOR=",pstrColour.get()));
      //<< write "><FONT SIZE=2>"
      m$.Cmd.Write("><FONT SIZE=2>");
      //<< do RelationalFields(pobjField,strData,idField)
      m$.Cmd.Do("RelationalFields",pobjField.get(),strData.get(),_idField);
      //<< 
      //<< if idField=3 {
      if (mOp.Equal(_idField,3)) {
        //<< if strData=16 {
        if (mOp.Equal(strData.get(),16)) {
          //<< if $piece(pobjField,Y,26)'="" set strData=$piece(pobjField,Y,26) set idFieldSwap=8 ;ALTERNATIVE DATATYPE
          if (mOp.NotEqual(m$.Fnc.$piece(pobjField.get(),m$.var("Y").get(),26),"")) {
            strData.set(m$.Fnc.$piece(pobjField.get(),m$.var("Y").get(),26));
            idFieldSwap.set(8);
          }
        }
        //<< } elseif strData'=2 {
        else if (mOp.NotEqual(strData.get(),2)) {
          //<< if $piece(pobjField,Y,8)'=""  set strData=$piece(pobjField,Y,8)  set idFieldSwap=8  ;TYBD;14,2,2005
          if (mOp.NotEqual(m$.Fnc.$piece(pobjField.get(),m$.var("Y").get(),8),"")) {
            strData.set(m$.Fnc.$piece(pobjField.get(),m$.var("Y").get(),8));
            idFieldSwap.set(8);
          }
        }
      }
      //<< }
      //<< }
      //<< do DATEN("WWW003",idFieldSwap,.strData)
      m$.Cmd.Do("DATEN","WWW003",idFieldSwap.get(),strData);
      //<< if idField=4 if $piece(pobjField,Y,26)'="" if $piece(pobjField,Y,3)=16 set strData=$$^WWWTEXT("WWW00045")  ;OID
      if (mOp.Equal(_idField,4)) {
        if (mOp.NotEqual(m$.Fnc.$piece(pobjField.get(),m$.var("Y").get(),26),"")) {
          if (mOp.Equal(m$.Fnc.$piece(pobjField.get(),m$.var("Y").get(),3),16)) {
            strData.set(m$.fnc$("WWWTEXT.main","WWW00045"));
          }
        }
      }
      //<< if idField=3 write "as "
      if (mOp.Equal(_idField,3)) {
        m$.Cmd.Write("as ");
      }
      //<< write $$^WWWUML(strData,1)
      m$.Cmd.Write(m$.fnc$("WWWUML.main",strData.get(),1));
      //<< if idFieldSwap=8 && ($piece(pobjField,Y,9)'="") {
      if (mOp.Equal(idFieldSwap.get(),8) && (mOp.NotEqual(m$.Fnc.$piece(pobjField.get(),m$.var("Y").get(),9),""))) {
        //<< write "<FONT SIZE=1> (",$translate($piece($piece(pobjField,Y,9),","),$$$DBLQUOTE),")</FONT>"
        m$.Cmd.Write("<FONT SIZE=1> (",m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$piece(pobjField.get(),m$.var("Y").get(),9),","),include.COMSYSString.$$$DBLQUOTE(m$)),")</FONT>");
      }
      //<< }
      //<< if strData="" write "&nbsp;"
      if (mOp.Equal(strData.get(),"")) {
        m$.Cmd.Write("&nbsp;");
      }
      //<< write "</A>"
      m$.Cmd.Write("</A>");
      //<< write "</TD>",YCR
      m$.Cmd.Write("</TD>",m$.var("YCR").get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< RelationalFields(pobjField,pstrData,pidField)
  public Object RelationalFields(Object ... _p) {
    mVar pobjField = m$.newVarRef("pobjField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrData = m$.newVarRef("pstrData",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If there is a relationship write out the details and maybe a hyperlink.
    //<< ;
    //<< ; Inputs:
    //<< ; pobjField: The details of the current data field
    //<< ; pstrData : The data for the current row
    //<< ; pidField : The id of the current data field
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnLink,strRelationDB,strAlternateInput
    mVar blnLink = m$.var("blnLink");
    mVar strRelationDB = m$.var("strRelationDB");
    mVar strAlternateInput = m$.var("strAlternateInput");
    m$.newVar(blnLink,strRelationDB,strAlternateInput);
    //<< 
    //<< write "<A"
    m$.Cmd.Write("<A");
    //<< 
    //<< set strRelationDB     = $$$WWW003RelationDatabase(pobjField)
    strRelationDB.set(include.WWWConst.$$$WWW003RelationDatabase(m$,pobjField));
    //<< set strAlternateInput = $$$WWW003AlternateInputType(pobjField)
    strAlternateInput.set(include.WWWConst.$$$WWW003AlternateInputType(m$,pobjField));
    //<< 
    //<< if ((strRelationDB_strAlternateInput)="") || (pidField'=3) write " TITLE="""_$$^WWWTEXT(374)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
    if ((mOp.Equal((mOp.Concat(strRelationDB.get(),strAlternateInput.get())),"")) || (mOp.NotEqual(pidField.get(),3))) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",374)),"\""));
    }
    //<< 
    //<< set blnLink=$$$NO
    blnLink.set(include.COMSYS.$$$NO(m$));
    //<< if pidField=3 {
    if (mOp.Equal(pidField.get(),3)) {
      //<< if pstrData'=2 {
      if (mOp.NotEqual(pstrData.get(),2)) {
        //<< if strAlternateInput="" {
        if (mOp.Equal(strAlternateInput.get(),"")) {
          //<< if strRelationDB'="" {
          if (mOp.NotEqual(strRelationDB.get(),"")) {
            //<< write " TITLE="""_strRelationDB_"("_$translate($piece(pobjField,Y,9),"""")_")"""   ;DATENSATZ AUSWÄHLEN ;data record pick out
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=\"",strRelationDB.get()),"("),m$.Fnc.$translate(m$.Fnc.$piece(pobjField.get(),m$.var("Y").get(),9),"\"")),")\""));
          }
        }
        //<< }
        //<< } else {
        else {
          //<< write " TITLE="""_strAlternateInput_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",strAlternateInput.get()),"\""));
        }
        //<< }
        //<< 
        //<< if (strAlternateInput'="") || (strRelationDB'="") {
        if ((mOp.NotEqual(strAlternateInput.get(),"")) || (mOp.NotEqual(strRelationDB.get(),""))) {
          //<< do RelationLink(pobjField)
          m$.Cmd.Do("RelationLink",pobjField.get());
          //<< set blnLink=$$$YES
          blnLink.set(include.COMSYS.$$$YES(m$));
        }
      }
    }
    //<< }
    //<< 
    //<< }
    //<< }
    //<< 
    //<< if 'blnLink {
    if (mOp.Not(blnLink.get())) {
      //<< write " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()));
      //<< do ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< write """>"
      m$.Cmd.Write("\">");
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< RelationLink(pobjField)
  public Object RelationLink(Object ... _p) {
    mVar pobjField = m$.newVarRef("pobjField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Draw the hyperlink for a relationship.
    //<< ;
    //<< ; Inputs:
    //<< ; pobjField: The details of the current data field
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YFORM,YKEY,YFKEY,strURL,strRelation,strAlternateInput
    mVar YFORM = m$.var("YFORM");
    mVar YKEY = m$.var("YKEY");
    mVar YFKEY = m$.var("YFKEY");
    mVar strURL = m$.var("strURL");
    mVar strRelation = m$.var("strRelation");
    mVar strAlternateInput = m$.var("strAlternateInput");
    m$.newVar(YFORM,YKEY,YFKEY,strURL,strRelation,strAlternateInput);
    //<< 
    //<< set YKEY=""
    YKEY.set("");
    //<< set strRelation=$$$WWW003RelationDatabase(pobjField)
    strRelation.set(include.WWWConst.$$$WWW003RelationDatabase(m$,pobjField));
    //<< if strRelation'="" set YKEY=strRelation
    if (mOp.NotEqual(strRelation.get(),"")) {
      YKEY.set(strRelation.get());
    }
    //<< set strAlternateInput=$$$WWW003AlternateInputType(pobjField)
    strAlternateInput.set(include.WWWConst.$$$WWW003AlternateInputType(m$,pobjField));
    //<< if strAlternateInput'="" set YKEY=strAlternateInput
    if (mOp.NotEqual(strAlternateInput.get(),"")) {
      YKEY.set(strAlternateInput.get());
    }
    //<< 
    //<< //SR14235
    //<< set strURL = $$FormURL^WWWCGI("WWW001",YKEY,,$$$YES)
    strURL.set(m$.fnc$("WWWCGI.FormURL","WWW001",YKEY.get(),null,include.COMSYS.$$$YES(m$)));
    //<< write " href='' onclick=""subWindow('"_strURL_"','TEILEFRAME1'); return false;"">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" href='' onclick=\"subWindow('",strURL.get()),"','TEILEFRAME1'); return false;\">"));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< NoDataFields(pidClass)
  public Object NoDataFields(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Draw the line for no data fields available for this class.
    //<< ;
    //<< ; Inputs:
    //<< ; pidClass  : The class we are listing
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strColour,loop
    mVar strColour = m$.var("strColour");
    mVar loop = m$.var("loop");
    m$.newVar(strColour,loop);
    //<< 
    //<< set YDDSATZ=YDDSATZ+1
    mVar YDDSATZ = m$.var("YDDSATZ");
    YDDSATZ.set(mOp.Add(m$.var("YDDSATZ").get(),1));
    //<< set strColour=$select(YDDSATZ#2:YWHITE,1:YGRAY)
    strColour.set(m$.Fnc.$select(mOp.Modulus(YDDSATZ.get(),2),m$.var("YWHITE").get(),1,m$.var("YGRAY").get()));
    //<< 
    //<< write "<TR>"
    m$.Cmd.Write("<TR>");
    //<< write "<TD NOWRAP BGCOLOR="_strColour_"><FONT SIZE=2>&nbsp;</TD>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD NOWRAP BGCOLOR=",strColour.get()),"><FONT SIZE=2>&nbsp;</TD>"));
    //<< write "<TD NOWRAP BGCOLOR="_strColour_"><FONT SIZE=2>&nbsp;</TD>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD NOWRAP BGCOLOR=",strColour.get()),"><FONT SIZE=2>&nbsp;</TD>"));
    //<< write "<TD NOWRAP BGCOLOR="_strColour_"><FONT SIZE=2>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD NOWRAP BGCOLOR=",strColour.get()),"><FONT SIZE=2>"));
    //<< do SelectDataRecord(pidClass)
    m$.Cmd.Do("SelectDataRecord",pidClass.get());
    //<< write $$^WWWTEXT(279)       ; No Data Items
    m$.Cmd.Write(m$.fnc$("WWWTEXT.main",279));
    //<< write "</A></TD>"
    m$.Cmd.Write("</A></TD>");
    //<< for loop=3,4,6 { // ?? Not sure why this is, obviously old code did something different way back.
    for (Object _loop: new Object[] {3,4,6}) {
    loop.set(_loop);
      //<< write "<TD NOWRAP BGCOLOR="_strColour_"><FONT SIZE=2>&nbsp;</TD>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD NOWRAP BGCOLOR=",strColour.get()),"><FONT SIZE=2>&nbsp;</TD>"));
    }
    //<< }
    //<< 
    //<< write "</TR>"
    m$.Cmd.Write("</TR>");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< SelectDataRecord(pidKey="")
  public Object SelectDataRecord(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the Select Data Record Title href which can load the form.
    //<< ;
    //<< ; Inputs:
    //<< ; pidKey: If it's blank use the current YKEY, other set YKEY to this
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idKey
    mVar idKey = m$.var("idKey");
    m$.newVar(idKey);
    //<< 
    //<< // Swap the current pidKey with YKEY, if pidKey is blank
    //<< if pidKey="" {
    if (mOp.Equal(pidKey.get(),"")) {
      //<< set idKey=YKEY
      idKey.set(m$.var("YKEY").get());
    }
    //<< } else {
    else {
      //<< set idKey=pidKey
      idKey.set(pidKey.get());
    }
    //<< }
    //<< 
    //<< new YKEY
    mVar YKEY = m$.var("YKEY");
    m$.newVar(YKEY);
    //<< 
    //<< set YKEY=idKey
    YKEY.set(idKey.get());
    //<< 
    //<< write "<A TITLE='"_$$^WWWTEXT(374)_"'"   ;DATENSATZ AUSWÄHLEN ;data record pick out
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<A TITLE='",m$.fnc$("WWWTEXT.main",374)),"'"));
    //<< write " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()));
    //<< do ^WWWCGI
    m$.Cmd.Do("WWWCGI.main");
    //<< write """>"
    m$.Cmd.Write("\">");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< DATEN(pidSource,pidField,&pstrData)
  public Object DATEN(Object ... _p) {
    mVar pidSource = m$.newVarRef("pidSource",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrData = m$.newVarRef("pstrData",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the relation information to be drawn
    //<< ;
    //<< ; Inputs:
    //<< ; pidSource: The source class, either WWW002 or WWW003
    //<< ; pidField : The id of the field to look up
    //<< ; pstrData : The data to be shown on the screen
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   RPW     SR15539: Rewrote in Brace Syntax
    //<< ;-------------------------------------------------------------------------------
    //<< new strRelation,strRelationKeys,strRelationDisplay,objRelation,objWWW003
    mVar strRelation = m$.var("strRelation");
    mVar strRelationKeys = m$.var("strRelationKeys");
    mVar strRelationDisplay = m$.var("strRelationDisplay");
    mVar objRelation = m$.var("objRelation");
    mVar objWWW003 = m$.var("objWWW003");
    m$.newVar(strRelation,strRelationKeys,strRelationDisplay,objRelation,objWWW003);
    //<< 
    //<< set objWWW003=$get(^WWW003(0,pidSource,pidField,1))
    objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,pidSource.get(),pidField.get(),1)));
    //<< 
    //<< set YQ=0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< if pstrData'="" && ($piece(objWWW003,Y,8)'="") {
    if (mOp.NotEqual(pstrData.get(),"") && (mOp.NotEqual(m$.Fnc.$piece(objWWW003.get(),m$.var("Y").get(),8),""))) {
      //<< set strRelation     = $$$WWW003RelationDatabase(objWWW003)
      strRelation.set(include.WWWConst.$$$WWW003RelationDatabase(m$,objWWW003));
      //<< set strRelationKeys = $$$WWW003RelationalPrimaryKeys(objWWW003)
      strRelationKeys.set(include.WWWConst.$$$WWW003RelationalPrimaryKeys(m$,objWWW003));
      //<< if strRelationKeys'="" && ($extract(strRelationKeys)'="""") {
      if (mOp.NotEqual(strRelationKeys.get(),"") && (mOp.NotEqual(m$.Fnc.$extract(strRelationKeys.get()),"\""))) {
        //<< quit:$find(strRelationKeys,",")  quit:'$data(@(strRelationKeys))  quit:$get(@(strRelationKeys))=""
        if (mOp.Logical(m$.Fnc.$find(strRelationKeys.get(),","))) {
          return null;
        }
        if (mOp.Not(m$.Fnc.$data(m$.indirectVar((strRelationKeys.get()))))) {
          return null;
        }
        if (mOp.Equal(m$.Fnc.$get(m$.indirectVar((strRelationKeys.get()))),"")) {
          return null;
        }
      }
      //<< }
      //<< set strRelationDisplay=$$$WWW003RelationalDisplayItems(objWWW003)
      strRelationDisplay.set(include.WWWConst.$$$WWW003RelationalDisplayItems(m$,objWWW003));
      //<< 
      //<< if +strRelationDisplay=0 set strRelationDisplay=1
      if (mOp.Equal(mOp.Positive(strRelationDisplay.get()),0)) {
        strRelationDisplay.set(1);
      }
      //<< 
      //<< if strRelation="WWW001" && ($data(^WWW0011(0,pstrData,SPRACHE,1))) {
      if (mOp.Equal(strRelation.get(),"WWW001") && mOp.Logical((m$.Fnc.$data(m$.var("^WWW0011",0,pstrData.get(),m$.var("SPRACHE").get(),1))))) {
        //<< set pstrData=$piece($get(^WWW0011(0,pstrData,SPRACHE,1)),Y,1)
        pstrData.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0011",0,pstrData.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
      }
      //<< } else {
      else {
        //<< set objRelation="^"_strRelation_"("_$$^WWWYM(strRelation,1)
        objRelation.set(mOp.Concat(mOp.Concat(mOp.Concat("^",strRelation.get()),"("),m$.fnc$("WWWYM.main",strRelation.get(),1)));
        //<< if strRelationKeys'="" && ($extract(strRelationKeys)'=",") {
        if (mOp.NotEqual(strRelationKeys.get(),"") && (mOp.NotEqual(m$.Fnc.$extract(strRelationKeys.get()),","))) {
          //<< set objRelation=objRelation_strRelationKeys_","
          objRelation.set(mOp.Concat(mOp.Concat(objRelation.get(),strRelationKeys.get()),","));
        }
        //<< }
        //<< set objRelation=objRelation_""""_$translate(pstrData,"""")_""",1)"
        objRelation.set(mOp.Concat(mOp.Concat(mOp.Concat(objRelation.get(),"\""),m$.Fnc.$translate(pstrData.get(),"\"")),"\",1)"));
        //<< set objRelation(1)=$piece($$^WWWSETL(objRelation),Y,strRelationDisplay)
        objRelation.var(1).set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",objRelation.get()),m$.var("Y").get(),strRelationDisplay.get()));
        //<< if objRelation(1)'="" set pstrData=$extract($translate(objRelation(1),"|"," "),1,30) set YQ=1
        if (mOp.NotEqual(objRelation.var(1).get(),"")) {
          pstrData.set(m$.Fnc.$extract(m$.Fnc.$translate(objRelation.var(1).get(),"|"," "),1,30));
          YQ.set(1);
        }
      }
    }
    //<< }
    //<< } else {
    else {
      //<< do Format($$$WWW003InputType(objWWW003),.pstrData)
      m$.Cmd.Do("Format",include.WWWConst.$$$WWW003InputType(m$,objWWW003),pstrData);
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< /*
  //<< DATEN ;FORMAT DATEN
  //<< ;
  //<< SET YTYP=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)
  //<< SET YQ=0
  //<< IF YINHALT'="" IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,8)'="" DO  QUIT
  //<< . NEW YDAT,YKE,YFE,YSAT
  //<< . SET YDAT=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,8)
  //<< . SET YKE=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,9)
  //<< . IF YKE'="" IF $EXTRACT(YKE)'="""" QUIT:$FIND(YKE,",")  QUIT:'$DATA(@(YKE))  QUIT:$GET(@(YKE))=""
  //<< . SET YFE=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,10)
  //<< . IF +YFE=0 SET YFE=1
  //<< . IF YDAT="WWW001" IF $DATA(^WWW0011(0,YINHALT,SPRACHE,1)) SET YINHALT=$PIECE(^WWW0011(0,YINHALT,SPRACHE,1),Y,1) QUIT
  //<< . SET YSAT="^"_YDAT_"("_$$^WWWYM(YDAT,1)
  //<< . IF YKE'="" IF $EXTRACT(YKE)'="," SET YSAT=YSAT_YKE_","
  //<< . SET YSAT=YSAT_""""_$TRANSLATE(YINHALT,"""")_""",1)"
  //<< . ;I $D(@(YSAT)) S YINHALT=$P(@(YSAT),Y,YFE) S YQ=1
  //<< . SET YSAT(1)=$PIECE($$^WWWSETL(YSAT),Y,YFE)
  //<< . IF YSAT(1)'="" SET YINHALT=$EXTRACT($TRANSLATE(YSAT(1),"|"," "),1,30) SET YQ=1
  //<< DO FORMAT
  //<< QUIT
  //<< */
  //<< 
  //<< Format(pstrInputType,&pstrData) ;
  public Object Format(Object ... _p) {
    mVar pstrInputType = m$.newVarRef("pstrInputType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrData = m$.newVarRef("pstrData",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Format the output for passwords (type 5) and memos (type 3)
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
    //<< ; 25-Jun-2007   RPW     SR15539: Rewrote to brace syntax
    //<< ;-------------------------------------------------------------------------------
    //<< if pstrData'="" {
    if (mOp.NotEqual(pstrData.get(),"")) {
      //<< set pstrData=$$GetLiteral^WWWTR(pstrInputType,pstrData)
      pstrData.set(m$.fnc$("WWWTR.GetLiteral",pstrInputType.get(),pstrData.get()));
      //<< 
      //<< if pstrInputType=5 {                     // password
      if (mOp.Equal(pstrInputType.get(),5)) {
        //<< set pstrData=$extract("*****************",1,$length(pstrData))
        pstrData.set(m$.Fnc.$extract("*****************",1,m$.Fnc.$length(pstrData.get())));
      }
      //<< } elseif pstrInputType=3 {               // memo
      else if (mOp.Equal(pstrInputType.get(),3)) {
        //<< set pstrData=$extract($piece(pstrData,"|",1),1,50)
        pstrData.set(m$.Fnc.$extract(m$.Fnc.$piece(pstrData.get(),"|",1),1,50));
        //<< set:pstrData'="" pstrData=pstrData_"..."
        if (mOp.NotEqual(pstrData.get(),"")) {
          pstrData.set(mOp.Concat(pstrData.get(),"..."));
        }
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< DrawImage(pstrImage) ;BILD ;portrait
  public Object DrawImage(Object ... _p) {
    mVar pstrImage = m$.newVarRef("pstrImage",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Draw the image of the field type.
    //<< ;
    //<< ; Inputs:
    //<< ; pstrImage: The image to draw or the type of relation
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   RPW     SR15539: Rewrote to brace syntax
    //<< ;-------------------------------------------------------------------------------
    //<< new strUpper
    mVar strUpper = m$.var("strUpper");
    m$.newVar(strUpper);
    //<< 
    //<< if pstrImage'="" {
    if (mOp.NotEqual(pstrImage.get(),"")) {
      //<< if $find(pstrImage,":") { ; 1:1, 1:n , m:n ; tybd;14,2,2005
      if (mOp.Logical(m$.Fnc.$find(pstrImage.get(),":"))) {
        //<< write pstrImage
        m$.Cmd.Write(pstrImage.get());
      }
      //<< } else {
      else {
        //<< set strUpper=$$$UPPER(pstrImage)
        strUpper.set(include.COMSYSString.$$$UPPER(m$,pstrImage));
        //<< if '$find(strUpper,".GIF") && ('$find(strUpper,".JPG")) {
        if (mOp.Not(m$.Fnc.$find(strUpper.get(),".GIF")) && (mOp.Not(m$.Fnc.$find(strUpper.get(),".JPG")))) {
        }
        //<< } else {
        else {
          //<< 
          //<< if '$find(pstrImage,"/") {
          if (mOp.Not(m$.Fnc.$find(pstrImage.get(),"/"))) {
            //<< set pstrImage=YGIF_pstrImage
            pstrImage.set(mOp.Concat(m$.var("YGIF").get(),pstrImage.get()));
          }
          //<< }
          //<< write YCR,"<IMG SRC="""_pstrImage_""" BORDER=0 ALIGN=RIGHT TITLE=""Property"" border=0>"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",pstrImage.get()),"\" BORDER=0 ALIGN=RIGHT TITLE=\"Property\" border=0>"));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< KillUniqueKeys(pidClass)
  public Object KillUniqueKeys(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Remove the Unique Key field from the class as it's no longer used.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField
    mVar idField = m$.var("idField");
    m$.newVar(idField);
    //<< 
    //<< if $data(^WWW003s(0,2,1,pidClass)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW003s",0,2,1,pidClass.get())))) {
      //<< $$$Order5(^WWW003s,0,2,1,pidClass,idField)
      idField.set("");
      for (;true;) {
        idField.set(m$.Fnc.$order(m$.var("^WWW003s",0,2,1,pidClass.get(),idField.get())));
        if (mOp.Equal(idField.get(),"")) {
          break;
        }
        //<< set $piece(^WWW003(0,pidClass,idField),Y,22)=""
        m$.pieceVar(m$.var("^WWW003",0,pidClass.get(),idField.get()),m$.var("Y").get(),22).set("");
        //<< set ^WWW003s(0,2," ",pidClass,idField)=""
        m$.var("^WWW003s",0,2," ",pidClass.get(),idField.get()).set("");
        //<< kill ^WWW003s(0,2,1,pidClass,idField)
        m$.var("^WWW003s",0,2,1,pidClass.get(),idField.get()).kill();
      }
    }
    //<< $$$End
    //<< }
    //<< 
    //<< quit
    return null;
  }

//<< 
//<< 
}
