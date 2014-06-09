//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW120A
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-05 18:37:31
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

//<< WWW120A
public class WWW120A extends mClass {

  public void main() {
    _WWW120A();
  }

  public void _WWW120A() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANZEIGEN FORMULARFELDER
    //<< ;       Display table of keys and fields for a form
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;   DATEI
    //<< ;   YFELD
    //<< ;   YKEY
    //<< ;   YSEITE      Tab number - don't display if not on first tab
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 27-Mar-2007   GRF     SR15487: Doco; if/else rather than repeated testing; grid
    //<< ;                       background colours assigned through <TR> rather than <TD>
    //<< ;                       throughout.
    //<< ; 24-Jun-2005   GRF     SR12777: Enhancement to class listing for relations so
    //<< ;                       don't need to hover over property to see relation name.
    //<< ; 28.06.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;==============================================================================================
    //<< ; (Form Key)         Form Name [*******                   ] *********
    //<< ;-----------------------------------------------------------------------------------------------+  gen    list    gantt
    //<< ; |# |Description in Forms     |Input Type   |Input Size|Index Key|Input In Variable|Customizing|  KOPF / KOPF1 / KOPF2
    //<< ;-----------------------------------------------------------------------------------------------+
    //<< ; |  | No Primary Key          |             |          |         |                 |           |  ANKEY                 "WWW121"
    //<< ;-----------------------------------------------------------------------------------------------+
    //<< ; |  |                         |             |          |         |                 |           |         ANLIS1         "WWW131"
    //<< ;-----------------------------------------------------------------------------------------------+
    //<< ; |  | No Data Items           |             |          |         |                 |           |  ANDAT  ANDAT          "WWW122"
    //<< ;-----------------------------------------------------------------------------------------------+
    //<< ; |  | No List Items           |             |          |         |                 |           | (ANLIS)                "WWW131"
    //<< ;-----------------------------------------------------------------------------------------------+
    //<< ; |  | No Gantt Chart Defaults |             |          |         |                 |           | (ANGANT)        ANGANT "WWWDRAGDROP"
    //<< ;-----------------------------------------------------------------------------------------------+
    //<< ; (Form Data)
    //<< ;================================================================================================
    //<< 
    //<< IF $GET(DATEI)="" SET DATEI=$PIECE($GET(YFELD),Y,11)
    if (mOp.Equal(m$.Fnc.$get(m$.var("DATEI")),"")) {
      mVar DATEI = m$.var("DATEI");
      DATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YFELD")),m$.var("Y").get(),11));
    }
    //<< IF $PIECE($GET(YKEY),",",1)'="" SET DATEI=$PIECE($GET(^WWW120(0,$PIECE(YKEY,",",1),1)),Y,11)  ;23861;TYBD;30,06,2003
    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YKEY")),",",1),"")) {
      mVar DATEI = m$.var("DATEI");
      DATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.Fnc.$piece(m$.var("YKEY").get(),",",1),1)),m$.var("Y").get(),11));
    }
    //<< QUIT:YSEITE>1
    if (mOp.Greater(m$.var("YSEITE").get(),1)) {
      return;
    }
    //<< 
    //<< SET YDDSATZ=0
    mVar YDDSATZ = m$.var("YDDSATZ");
    YDDSATZ.set(0);
    //<< SET YNKEY=$TRANSLATE($PIECE(YKEY,",",1),"""")
    mVar YNKEY = m$.var("YNKEY");
    YNKEY.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YKEY").get(),",",1),"\""));
    //<< QUIT:YNKEY=""
    if (mOp.Equal(YNKEY.get(),"")) {
      return;
    }
    //<< SET YNDATEI=$PIECE($GET(^WWW120(0,YNKEY,1)),Y,11)
    mVar YNDATEI = m$.var("YNDATEI");
    YNDATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YNKEY.get(),1)),m$.var("Y").get(),11));
    //<< 
    //<< NEW YFKEY,YDATEI,YSUCH,YSUCH1,YFORM,YI,YBACK,YKEY,YSATZ,FORMULAR
    mVar YFKEY = m$.var("YFKEY");
    mVar YDATEI = m$.var("YDATEI");
    mVar YSUCH = m$.var("YSUCH");
    mVar YSUCH1 = m$.var("YSUCH1");
    mVar YFORM = m$.var("YFORM");
    mVar YI = m$.var("YI");
    mVar YBACK = m$.var("YBACK");
    mVar YKEY = m$.var("YKEY");
    mVar YSATZ = m$.var("YSATZ");
    mVar FORMULAR = m$.var("FORMULAR");
    m$.newVar(YFKEY,YDATEI,YSUCH,YSUCH1,YFORM,YI,YBACK,YKEY,YSATZ,FORMULAR);
    //<< 
    //<< SET YBACK="WWW120,"
    YBACK.set("WWW120,");
    //<< SET YKEY=YNKEY
    YKEY.set(YNKEY.get());
    //<< SET FORMULAR=YNKEY
    FORMULAR.set(YNKEY.get());
    //<< 
    //<< IF YNDATEI="" SET YNDATEI=YNKEY
    if (mOp.Equal(YNDATEI.get(),"")) {
      YNDATEI.set(YNKEY.get());
    }
    //<< 
    //<< SET YFKEY=YKEY
    YFKEY.set(YKEY.get());
    //<< 
    //<< IF $PIECE(YVOR,Y,44)>0 WRITE YCR,"</TABLE>"
    if (mOp.Greater(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),0)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    }
    //<< do ^WWWFRAME(0)
    m$.Cmd.Do("WWWFRAME.main",0);
    //<< 
    //<< ; vvv SR15487
    //<< if $data(^WWWDRAGDROP(0,YKEY)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDRAGDROP",0,YKEY.get())))) {
      //<< ;   GANTT CHARTS
      //<< do KOPF2                                                             ; 7 columns
      m$.Cmd.Do("KOPF2");
      //<< do ANGANT
      m$.Cmd.Do("ANGANT");
    }
    //<< } else {
    else {
      //<< ;   LIST GENERATOR
      //<< if $data(^WWW131(0,YKEY)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW131",0,YKEY.get())))) {
        //<< do KOPF1
        m$.Cmd.Do("KOPF1");
        //<< do ANLIS1
        m$.Cmd.Do("ANLIS1");
        //<< do ANDAT
        m$.Cmd.Do("ANDAT");
      }
      //<< 
      //<< } else {
      else {
        //<< ;   OTHER FORM TYPES
        //<< do KOPF                              ; heading
        m$.Cmd.Do("KOPF");
        //<< set YDATEI=YNDATEI
        YDATEI.set(YNDATEI.get());
        //<< if YDATEI'="" {
        if (mOp.NotEqual(YDATEI.get(),"")) {
          //<< do ANKEY                         ; keys
          m$.Cmd.Do("ANKEY");
          //<< do ANDAT                         ; data fields
          m$.Cmd.Do("ANDAT");
          //<< if '$data(^WWW121(0,YKEY)) {
          if (mOp.Not(m$.Fnc.$data(m$.var("^WWW121",0,YKEY.get())))) {
            //<< do ANLIS                                                 ; "No List Items"
            m$.Cmd.Do("ANLIS");
            //<< do ANGANT                                                ; "No Gantt Chart Defaults"
            m$.Cmd.Do("ANGANT");
          }
        }
        //<< }
        //<< } else {
        else {
          //<< do ANDAT                         ; DRUCKEN MANUELLE    ; can never get here! <GRF>
          m$.Cmd.Do("ANDAT");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< DO ^WWWFRAME(1)
    m$.Cmd.Do("WWWFRAME.main",1);
    //<< IF $PIECE(YVOR,Y,44)>0 WRITE YCR,"<TABLE CELLSPACING=0 BORDER=0>"
    if (mOp.Greater(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),0)) {
      m$.Cmd.Write(m$.var("YCR").get(),"<TABLE CELLSPACING=0 BORDER=0>");
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< KOPF
  public void KOPF() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   UEBERSCHRIFT
    //<< ;
    //<< ; History:
    //<< ; 27-Mar-2007   GRF     SR15487: Convert to brace format; close <FONT>; doco
    //<< ;-------------------------------------------------------------------------------
    //<< SET YDATEI="WWW002"
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set("WWW002");
    //<< 
    //<< WRITE YCR,"<TR BGCOLOR="_YDARKGRAY_">",YCR  ; SR15487
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TR BGCOLOR=",m$.var("YDARKGRAY").get()),">"),m$.var("YCR").get());
    //<< 
    //<< WRITE "<TH NOWRAP ALIGN=LEFT>"
    m$.Cmd.Write("<TH NOWRAP ALIGN=LEFT>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< WRITE "&nbsp;"
    m$.Cmd.Write("&nbsp;");
    //<< WRITE "</FONT></TH>",YCR
    m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    //<< 
    //<< WRITE "<TH NOWRAP ALIGN=LEFT>"
    m$.Cmd.Write("<TH NOWRAP ALIGN=LEFT>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< WRITE "#"
    m$.Cmd.Write("#");
    //<< WRITE "</FONT></TH>",YCR
    m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    //<< 
    //<< FOR YLFN=2,3,4,6 {                                                              ; SR15487
    mVar YLFN = m$.var("YLFN");
    for (Object _YLFN: new Object[] {2,3,4,6}) {
    YLFN.set(_YLFN);
      //<< WRITE "<TH NOWRAP ALIGN=LEFT>"
      m$.Cmd.Write("<TH NOWRAP ALIGN=LEFT>");
      //<< WRITE "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< IF $DATA(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,YDATEI.get(),_YLFN,m$.var("SPRACHE").get(),1)))) {
        //<< WRITE $$^WWWUML($PIECE($GET(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)),Y,1),1)
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0031",0,YDATEI.get(),_YLFN,m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),1));
      }
      //<< } else {
      else {
        //<< WRITE $$^WWWUML($PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,2),1)
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),_YLFN,1)),m$.var("Y").get(),2),1));
      }
      //<< }
      //<< WRITE "</FONT></TH>",YCR
      m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    }
    //<< }
    //<< 
    //<< WRITE "<TH NOWRAP ALIGN=LEFT>"
    m$.Cmd.Write("<TH NOWRAP ALIGN=LEFT>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< IF $DATA(^WWW0031(0,"WWW122",21,SPRACHE,1)) {                                   ; SR15487
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,"WWW122",21,m$.var("SPRACHE").get(),1)))) {
      //<< WRITE $$^WWWUML($PIECE($GET(^WWW0031(0,"WWW122",21,SPRACHE,1)),Y,1),1)
      m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0031",0,"WWW122",21,m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),1));
    }
    //<< } else {
    else {
      //<< WRITE $$^WWWUML($PIECE($GET(^WWW003(0,"WWW122",21,1)),Y,2),1)       ; "Input In Variable"
      m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,"WWW122",21,1)),m$.var("Y").get(),2),1));
    }
    //<< }
    //<< WRITE "</FONT></TH>",YCR
    m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    //<< 
    //<< WRITE "<TH NOWRAP ALIGN=LEFT>"
    m$.Cmd.Write("<TH NOWRAP ALIGN=LEFT>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< WRITE $$^WWWTEXT(33400)           ; "Customizing"   ;SR14275
    m$.Cmd.Write(m$.fnc$("WWWTEXT.main",33400));
    //<< WRITE "</FONT></TH>",YCR
    m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    //<< 
    //<< WRITE "</TR>",YCR
    m$.Cmd.Write("</TR>",m$.var("YCR").get());
    //<< QUIT
    return;
  }

  //<< 
  //<< KOPF1
  public void KOPF1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   UEBERSCHRIFT LISTGENERATOR
    //<< ;
    //<< ; History:
    //<< ; 28-Mar-2007   GRF     SR15487: Always show 8 columns
    //<< ; 27-Mar-2007   GRF     SR15487: Convert to brace format; close <FONT>; doco
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;-------------------------------------+
    //<< ;  |# |List : Database |  |  |  |  |  |
    //<< ;-------------------------------------+
    //<< 
    //<< SET YDATEI="WWW131"
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set("WWW131");
    //<< WRITE YCR,"<TR BGCOLOR="_YDARKGRAY_">",YCR ; SR15487
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TR BGCOLOR=",m$.var("YDARKGRAY").get()),">"),m$.var("YCR").get());
    //<< 
    //<< WRITE "<TH NOWRAP>"
    m$.Cmd.Write("<TH NOWRAP>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< WRITE "&nbsp;"
    m$.Cmd.Write("&nbsp;");
    //<< WRITE "</FONT></TH>",YCR
    m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    //<< 
    //<< WRITE "<TH NOWRAP>"
    m$.Cmd.Write("<TH NOWRAP>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< WRITE "#"
    m$.Cmd.Write("#");
    //<< WRITE "</FONT></TH>",YCR
    m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    //<< 
    //<< ;FOR YLFN=1,0,0,0,0 {                                ; SR15487
    //<< FOR YLFN=1,0,0,0,0,0 {
    mVar YLFN = m$.var("YLFN");
    for (Object _YLFN: new Object[] {1,0,0,0,0,0}) {
    YLFN.set(_YLFN);
      //<< WRITE "<TH NOWRAP>"
      m$.Cmd.Write("<TH NOWRAP>");
      //<< WRITE "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< IF YLFN=1 WRITE $$^WWWTEXT(90)_": "              ; "List"
      if (mOp.Equal(_YLFN,1)) {
        m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main",90),": "));
      }
      //<< 
      //<< IF $DATA(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)) {                               ; SR15487
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,YDATEI.get(),_YLFN,m$.var("SPRACHE").get(),1)))) {
        //<< WRITE $$^WWWUML($PIECE($GET(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)),Y,1),1)
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0031",0,YDATEI.get(),_YLFN,m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),1));
      }
      //<< } else {
      else {
        //<< WRITE $$^WWWUML($PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,2),1),"&nbsp;"
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),_YLFN,1)),m$.var("Y").get(),2),1),"&nbsp;");
      }
      //<< }
      //<< WRITE "</FONT></TH>",YCR
      m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    }
    //<< }
    //<< 
    //<< WRITE "</TR>",YCR
    m$.Cmd.Write("</TR>",m$.var("YCR").get());
    //<< QUIT
    return;
  }

  //<< 
  //<< KOPF2
  public void KOPF2() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   UEBERSCHRIFT GANTT
    //<< ;
    //<< ; History:
    //<< ; 29-Mar-2007   RPW     SR15487: Removed hard coded english
    //<< ; 28-Mar-2007   GRF     SR15487: Always show 8 columns
    //<< ; 27-Mar-2007   GRF     SR15487: Convert to brace format; close <FONT>; doco
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;--------------------------------------------+
    //<< ;  |# |Gantt-Chart : Database |  |  |  |  |  |
    //<< ;--------------------------------------------+
    //<< 
    //<< SET YDATEI="WWW131"
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set("WWW131");
    //<< WRITE YCR,"<TR BGCOLOR="_YDARKGRAY_">",YCR  ; SR15487
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TR BGCOLOR=",m$.var("YDARKGRAY").get()),">"),m$.var("YCR").get());
    //<< 
    //<< WRITE "<TH NOWRAP>"
    m$.Cmd.Write("<TH NOWRAP>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< WRITE "&nbsp;"
    m$.Cmd.Write("&nbsp;");
    //<< WRITE "</FONT></TH>",YCR
    m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    //<< 
    //<< WRITE "<TH NOWRAP>"
    m$.Cmd.Write("<TH NOWRAP>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< WRITE "#"
    m$.Cmd.Write("#");
    //<< WRITE "</FONT></TH>",YCR
    m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    //<< 
    //<< ;FOR YLFN=1,0,0,0,0 {                             ; SR15487
    //<< FOR YLFN=1,0,0,0,0,0 {
    mVar YLFN = m$.var("YLFN");
    for (Object _YLFN: new Object[] {1,0,0,0,0,0}) {
    YLFN.set(_YLFN);
      //<< WRITE "<TH NOWRAP>"
      m$.Cmd.Write("<TH NOWRAP>");
      //<< WRITE "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< IF YLFN=1 WRITE $$^WWWTEXT("WWW00068")_": "  ;Gantt-Chart // SR15487
      if (mOp.Equal(_YLFN,1)) {
        m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main","WWW00068"),": "));
      }
      //<< 
      //<< IF $DATA(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)) {                               ; SR15487
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,YDATEI.get(),_YLFN,m$.var("SPRACHE").get(),1)))) {
        //<< WRITE $$^WWWUML($PIECE($GET(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)),Y,1),1)
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0031",0,YDATEI.get(),_YLFN,m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),1));
      }
      //<< } else {
      else {
        //<< WRITE $$^WWWUML($PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,2),1),"&nbsp;"
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),_YLFN,1)),m$.var("Y").get(),2),1),"&nbsp;");
      }
      //<< }
      //<< WRITE "</FONT></TH>",YCR
      m$.Cmd.Write("</FONT></TH>",m$.var("YCR").get());
    }
    //<< }
    //<< 
    //<< WRITE "</TR>",YCR
    m$.Cmd.Write("</TR>",m$.var("YCR").get());
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< ANKEY
  public void ANKEY() {
    //<< /*-------------------------------------------------------------------------------
    //<< ;   PRIMÄRSCHLÜSSEL
    //<< ;   Keys
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Mar-2007   GRF     SR15487: Replace kill commands to ensure indices are updated.
    //<< ; 27-Mar-2007   GRF     SR15487: Call AddLink; close <FONT>;set strBGColor once
    //<< ;                       instead of repeated checking; brace format; use idFld and
    //<< ;                       pass to DATEN because new of YLFN is different under brace
    //<< ;                       format; simplify "No Primary Key" output.
    //<< ; 08-Feb-2006   shobby  SR14275: Call out to DisplayCustomising
    //<< ;-------------------------------------------------------------------------------*/
    //<< NEW idFld,intCol,strBGColor,YKEY
    mVar idFld = m$.var("idFld");
    mVar intCol = m$.var("intCol");
    mVar strBGColor = m$.var("strBGColor");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(idFld,intCol,strBGColor,YKEY);
    //<< 
    //<< SET YFORM="WWW121"
    mVar YFORM = m$.var("YFORM");
    YFORM.set("WWW121");
    //<< SET YDATEI=YNKEY
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.var("YNKEY").get());
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< 
    //<< ;---------------------------------------
    //<< ; If any of the class' data fields are marked as being a unique key, kill all
    //<< ; the standard keys for the form.           (Key 2 : based on D22 Unique Key)
    //<< ;
    //<< ; NOTE: the "Unique Key" facility has been disabled because accidental use can
    //<< ;       wipe out the true keys for a class.
    //<< ;---------------------------------------
    //<< 
    //<< ;IF $DATA(^WWW003s(0,2,$$$YES,YNDATEI)) KILL ^WWW121(0,YNKEY)          ;SONDER PRIMÄR
    //<< ;---------------------------------------
    //<< IF $DATA(^WWW003s(0,2,$$$YES,YNDATEI)) do ^WWWSKILL("WWW121",YNKEY)    ; kills all keys for form
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW003s",0,2,include.COMSYS.$$$YES(m$),m$.var("YNDATEI").get())))) {
      m$.Cmd.Do("WWWSKILL.main","WWW121",m$.var("YNKEY").get());
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; If no "Unique Key" field in class (all classes now) and
    //<< ; No actual keys for form
    //<< ;---------------------------------------
    //<< IF '$DATA(^WWW003s(0,2,$$$YES,YNDATEI)) && '$DATA(^WWW121(0,YNKEY)) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW003s",0,2,include.COMSYS.$$$YES(m$),m$.var("YNDATEI").get()))) && mOp.Not(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YNKEY").get())))) {
      //<< set strBGColor = " BGCOLOR="_$select($increment(YDDSATZ)#2:YWHITE,1:YGRAY)    ; SR15487
      strBGColor.set(mOp.Concat(" BGCOLOR=",m$.Fnc.$select(mOp.Modulus(m$.Fnc.$increment(m$.var("YDDSATZ")),2),m$.var("YWHITE").get(),1,m$.var("YGRAY").get())));
      //<< write "<TR"_strBGColor_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TR",strBGColor.get()),">"));
      //<< 
      //<< ;--------------------------------------- Col 1-8         ; SR15487 - simplify
      //<< for intCol=1:1:8 {
      for (intCol.set(1);(mOp.LessOrEqual(intCol.get(),8));intCol.set(mOp.Add(intCol.get(),1))) {
        //<< write "<TD NOWRAP>"                              ;  SR15487
        m$.Cmd.Write("<TD NOWRAP>");
        //<< write "<FONT SIZE=2>"
        m$.Cmd.Write("<FONT SIZE=2>");
        //<< if intCol=3 {
        if (mOp.Equal(intCol.get(),3)) {
          //<< do AddLink(YNKEY,YNKEY,YAKTION,YFORM,"")
          m$.Cmd.Do("AddLink",m$.var("YNKEY").get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),"");
          //<< write $$^WWWTEXT(278)                        ; "No Primary Key"
          m$.Cmd.Write(m$.fnc$("WWWTEXT.main",278));
          //<< write "</A>"
          m$.Cmd.Write("</A>");
        }
        //<< } else {
        else {
          //<< write "&nbsp;"
          m$.Cmd.Write("&nbsp;");
        }
        //<< }
        //<< write "</FONT></TD>",YCR
        m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
      }
      //<< }
      //<< 
      //<< write YCR,"</TR>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    }
    //<< 
    //<< } else {
    else {
      //<< ;-----------------------------------
      //<< ; Form has actual keys
      //<< ;-----------------------------------
      //<< 
      //<< SET YLFN=""
      mVar YLFN = m$.var("YLFN");
      YLFN.set("");
      //<< FOR  {
      for (;true;) {
        //<< SET YLFN=$ORDER(^WWW121(0,YNKEY,YLFN))
        YLFN.set(m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YNKEY").get(),YLFN.get())));
        //<< quit:YLFN=""
        if (mOp.Equal(YLFN.get(),"")) {
          break;
        }
        //<< 
        //<< ;*******************************
        //<< ; If a particular form key doesn't exist for the class, remove
        //<< ; it from the form together with any customization.
        //<< ;-------------------------------
        //<< SET YSATZ=$GET(^WWW002(0,YNDATEI,YLFN,1))
        mVar YSATZ = m$.var("YSATZ");
        YSATZ.set(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YNDATEI").get(),YLFN.get(),1)));
        //<< IF YSATZ="" {
        if (mOp.Equal(YSATZ.get(),"")) {
          //<< set strStatus = $$$Kill("WWW121",YNKEY_$$$COMMA_YLFN)
          mVar strStatus = m$.var("strStatus");
          strStatus.set(include.COMSYS.$$$Kill(m$,"WWW121",mOp.Concat(mOp.Concat(m$.var("YNKEY").get(),include.COMSYSString.$$$COMMA(m$)),YLFN.get())));
          //<< do ^WWWSKILL("WWW121D",YNKEY_$$$COMMA_YLFN)               ; kills for all companies
          m$.Cmd.Do("WWWSKILL.main","WWW121D",mOp.Concat(mOp.Concat(m$.var("YNKEY").get(),include.COMSYSString.$$$COMMA(m$)),YLFN.get()));
          //<< quit
          break;
        }
        //<< }
        //<< ;*******************************
        //<< 
        //<< SET YKEY=YNKEY_","_YLFN
        YKEY.set(mOp.Concat(mOp.Concat(m$.var("YNKEY").get(),","),YLFN.get()));
        //<< set strBGColor = " BGCOLOR="_$select($increment(YDDSATZ)#2:YWHITE,1:YGRAY)    ; SR15487
        strBGColor.set(mOp.Concat(" BGCOLOR=",m$.Fnc.$select(mOp.Modulus(m$.Fnc.$increment(m$.var("YDDSATZ")),2),m$.var("YWHITE").get(),1,m$.var("YGRAY").get())));
        //<< write "<TR"_strBGColor_">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<TR",strBGColor.get()),">"));
        //<< 
        //<< ;--------------------------------------- Col 1
        //<< write "<TD NOWRAP>"                            ; SR15487
        m$.Cmd.Write("<TD NOWRAP>");
        //<< WRITE "<FONT SIZE=2>"
        m$.Cmd.Write("<FONT SIZE=2>");
        //<< do AddLink(YKEY,YNKEY,YAKTION,YFORM,$$^WWWTEXT(374))        ; "Select Data Record"    ; SR15487
        m$.Cmd.Do("AddLink",YKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),m$.fnc$("WWWTEXT.main",374));
        //<< SET YINHALT="primaer.gif"
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set("primaer.gif");
        //<< DO THUMP
        m$.Cmd.Do("THUMP");
        //<< IF $PIECE(YSATZ,Y,3)=16   SET YINHALT="1:n"  ;1-n Beziehung
        if (mOp.Equal(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),3),16)) {
          YINHALT.set("1:n");
        }
        //<< IF $PIECE(YSATZ,Y,35)'="" SET YINHALT=$PIECE($GET(^WWW100(0,"RELATIONSHIP",SPRACHE,$PIECE(YSATZ,Y,35),1)),Y,1)
        if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),35),"")) {
          YINHALT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"RELATIONSHIP",m$.var("SPRACHE").get(),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),35),1)),m$.var("Y").get(),1));
        }
        //<< WRITE "</FONT></TD>",YCR
        m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
        //<< 
        //<< ;--------------------------------------- Col 2
        //<< write "<TD NOWRAP>"                            ; SR15487
        m$.Cmd.Write("<TD NOWRAP>");
        //<< WRITE "<FONT SIZE=2>"
        m$.Cmd.Write("<FONT SIZE=2>");
        //<< do AddLink(YKEY,YNKEY,YAKTION,YFORM,$$^WWWTEXT(374))        ; "Select Data Record"    ; SR15487
        m$.Cmd.Do("AddLink",YKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),m$.fnc$("WWWTEXT.main",374));
        //<< 
        //<< WRITE YLFN
        m$.Cmd.Write(YLFN.get());
        //<< WRITE "</A>"
        m$.Cmd.Write("</A>");
        //<< WRITE "</FONT></TD>",YCR
        m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
        //<< 
        //<< ;--------------------------------------- Col 3-7
        //<< ;FOR YI=2,3,4,6,8,21 SET YINHALT=$PIECE(YSATZ,Y,YI) DO  ;TYBD;14,2,2005
        //<< FOR YI=2,3,4,6,21 {
        mVar YI = m$.var("YI");
        for (Object _YI: new Object[] {2,3,4,6,21}) {
          YI.set(_YI);
          //<< SET YINHALT=$PIECE(YSATZ,Y,YI)
          YINHALT.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),_YI));
          //<< IF YI=2 {
          if (mOp.Equal(_YI,2)) {
            //<< IF YNDATEI'="" IF YLFN'="" IF $DATA(^WWW0021(0,YNDATEI,YLFN,SPRACHE,1)) SET YINHALT=$PIECE(^WWW0021(0,YNDATEI,YLFN,SPRACHE,1),Y,1)
            if (mOp.NotEqual(m$.var("YNDATEI").get(),"")) {
              if (mOp.NotEqual(YLFN.get(),"")) {
                if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0021",0,m$.var("YNDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
                  YINHALT.set(m$.Fnc.$piece(m$.var("^WWW0021",0,m$.var("YNDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
                }
              }
            }
            //<< SET YINHALT="("_YLFN_") "_YINHALT
            YINHALT.set(mOp.Concat(mOp.Concat(mOp.Concat("(",YLFN.get()),") "),YINHALT.get()));
          }
          //<< } elseIF YI=21 {
          else if (mOp.Equal(_YI,21)) {
            //<< SET YINHALT=$PIECE($GET(^WWW121(0,YNKEY,YLFN,1)),Y,21)
            YINHALT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YNKEY").get(),YLFN.get(),1)),m$.var("Y").get(),21));
          }
          //<< }
          //<< 
          //<< ;   NEW YLFN                                             ; SR15487
          //<< ;   SET YLFN=YI
          //<< set idFld = YI
          idFld.set(_YI);
          //<< 
          //<< write "<TD NOWRAP>"                                  ; SR15487
          m$.Cmd.Write("<TD NOWRAP>");
          //<< WRITE "<FONT SIZE=2>"
          m$.Cmd.Write("<FONT SIZE=2>");
          //<< ; vvv   SR15487
          //<< set strTitle = ""
          mVar strTitle = m$.var("strTitle");
          strTitle.set("");
          //<< if (YI=3) {
          if ((mOp.Equal(_YI,3))) {
            //<< if ($piece(YSATZ,Y,26)'="") {
            if ((mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26),""))) {
              //<< set strTitle = $piece(YSATZ,Y,26)
              strTitle.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26));
            }
            //<< } elseif $piece(YSATZ,Y,8)'="" {
            else if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8),"")) {
              //<< set strTitle = $piece(YSATZ,Y,8)_"("_$translate($piece(YSATZ,Y,9),"""")_")"
              strTitle.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8),"("),m$.Fnc.$translate(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),9),"\"")),")"));
            }
            //<< } else {
            else {
              //<< set strTitle = $$^WWWTEXT(374)
              strTitle.set(m$.fnc$("WWWTEXT.main",374));
            }
          }
          //<< }
          //<< } else {
          else {
            //<< set strTitle = $$^WWWTEXT(374)
            strTitle.set(m$.fnc$("WWWTEXT.main",374));
          }
          //<< }
          //<< 
          //<< do AddLink(YKEY,YNKEY,YAKTION,YFORM,strTitle)        ; SR15487
          m$.Cmd.Do("AddLink",YKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),strTitle.get());
          //<< 
          //<< SET YDATEI="WWW002"
          YDATEI.set("WWW002");
          //<< ;   SR15487 vvv
          //<< IF YI=3 {
          if (mOp.Equal(_YI,3)) {
            //<< IF YINHALT=16 && ($PIECE(YSATZ,Y,26)'="") {
            if (mOp.Equal(YINHALT.get(),16) && (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26),""))) {
              //<< SET YINHALT=$PIECE(YSATZ,Y,26)
              YINHALT.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26));
              //<< SET idFld=8 ;ALTERNATIVE DATATYPE
              idFld.set(8);
            }
            //<< } elseIF $PIECE(YSATZ,Y,8)'="" {
            else if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8),"")) {
              //<< SET YINHALT=$PIECE(YSATZ,Y,8)
              YINHALT.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8));
              //<< SET idFld=8 ;TYBD;14,2,2005
              idFld.set(8);
            }
          }
          //<< }
          //<< }
          //<< DO DATEN(idFld)
          m$.Cmd.Do("DATEN",idFld.get());
          //<< ;   SR15487 ^^^
          //<< IF YI=4 {
          if (mOp.Equal(_YI,4)) {
            //<< if ($PIECE(YSATZ,Y,26)'="") && ($PIECE(YSATZ,Y,3)=16) SET YINHALT=$$^WWWTEXT("WWW00045")  ;OID
            if ((mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26),"")) && (mOp.Equal(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),3),16))) {
              YINHALT.set(m$.fnc$("WWWTEXT.main","WWW00045"));
            }
          }
          //<< } elseif YI=3 {
          else if (mOp.Equal(_YI,3)) {
            //<< write $$^WWWTEXT("WWW00069")_" "  ;as
            m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main","WWW00069")," "));
          }
          //<< }
          //<< 
          //<< WRITE $$^WWWUML(YINHALT,1)
          m$.Cmd.Write(m$.fnc$("WWWUML.main",YINHALT.get(),1));
          //<< ;IF YLFN=8 IF $GET(SPRACHE)="DE" IF $PIECE(YSATZ,Y,9)'="" WRITE " (",$PIECE(YSATZ,Y,9),")"   ; SR12777;GRF
          //<< if (idFld=8) && ($piece(YSATZ,Y,9)'="") {                                                    ; SR15487
          if ((mOp.Equal(idFld.get(),8)) && (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),9),""))) {
            //<< write "<FONT SIZE=1> (",$translate($piece($piece(YSATZ,Y,9),","),$$$DBLQUOTE),")</FONT>"
            m$.Cmd.Write("<FONT SIZE=1> (",m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),9),","),include.COMSYSString.$$$DBLQUOTE(m$)),")</FONT>");
          }
          //<< }
          //<< IF YINHALT="" WRITE "&nbsp;"
          if (mOp.Equal(YINHALT.get(),"")) {
            m$.Cmd.Write("&nbsp;");
          }
          //<< ;DO DATEN
          //<< ;WRITE $$^WWWUML(YINHALT,1)
          //<< ;IF YINHALT="" WRITE "&nbsp;"
          //<< WRITE "</A>"
          m$.Cmd.Write("</A>");
          //<< WRITE "</FONT></TD>",YCR
          m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
        }
        //<< }
        //<< 
        //<< ;--------------------------------------- Col 8
        //<< do DisplayCustomizing(YKEY)               ;SR14275
        m$.Cmd.Do("DisplayCustomizing",YKEY.get());
        //<< 
        //<< WRITE "</TR>",YCR
        m$.Cmd.Write("</TR>",m$.var("YCR").get());
      }
    }
    //<< }
    //<< }
    //<< QUIT
    return;
  }

  //<< 
  //<< ANDAT
  public void ANDAT() {
    //<< /*-------------------------------------------------------------------------------
    //<< ;   DATENFELDER
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Jun-2007   RPW     SR15539: Show Free property number after _FREE fields
    //<< ; 28-Mar-2007   GRF     SR15487: Always show 8 columns
    //<< ; 27-Mar-2007   GRF     SR15487: Call AddLink; close <FONT>; set strBGColor once
    //<< ;                       instead of repeated checking; brace format; use idFld and
    //<< ;                       pass to DATEN because new of YLFN is different under brace
    //<< ;                       format; simplify "No Data Items" output.
    //<< ; 08-Feb-2006   shobby  SR14275: Call out to DisplayCustomising
    //<< ;-------------------------------------------------------------------------------*/
    //<< NEW idFld,intCol,strBGColor,YKEY,YSATZ1,objWWW003
    mVar idFld = m$.var("idFld");
    mVar intCol = m$.var("intCol");
    mVar strBGColor = m$.var("strBGColor");
    mVar YKEY = m$.var("YKEY");
    mVar YSATZ1 = m$.var("YSATZ1");
    mVar objWWW003 = m$.var("objWWW003");
    m$.newVar(idFld,intCol,strBGColor,YKEY,YSATZ1,objWWW003);
    //<< 
    //<< SET YFORM="WWW122"
    mVar YFORM = m$.var("YFORM");
    YFORM.set("WWW122");
    //<< SET YDATEI=YNKEY
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.var("YNKEY").get());
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< 
    //<< IF '$DATA(^WWW122(0,YNKEY)) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YNKEY").get())))) {
      //<< set strBGColor = " BGCOLOR="_$select($increment(YDDSATZ)#2:YWHITE,1:YGRAY)    ; SR15487
      strBGColor.set(mOp.Concat(" BGCOLOR=",m$.Fnc.$select(mOp.Modulus(m$.Fnc.$increment(m$.var("YDDSATZ")),2),m$.var("YWHITE").get(),1,m$.var("YGRAY").get())));
      //<< write "<TR"_strBGColor_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TR",strBGColor.get()),">"));
      //<< 
      //<< ;--------------------------------------- Col 1-8
      //<< for intCol=1:1:8 {
      for (intCol.set(1);(mOp.LessOrEqual(intCol.get(),8));intCol.set(mOp.Add(intCol.get(),1))) {
        //<< write "<TD NOWRAP>"                            ; SR15487
        m$.Cmd.Write("<TD NOWRAP>");
        //<< write "<FONT SIZE=2>"
        m$.Cmd.Write("<FONT SIZE=2>");
        //<< if intCol=3 {
        if (mOp.Equal(intCol.get(),3)) {
          //<< do AddLink(YNKEY,YNKEY,YAKTION,YFORM,$$^WWWTEXT(374))        ; "Select Data Record"    ; SR15487
          m$.Cmd.Do("AddLink",m$.var("YNKEY").get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),m$.fnc$("WWWTEXT.main",374));
          //<< write $$^WWWTEXT(279)                                        ; "No Data Items"
          m$.Cmd.Write(m$.fnc$("WWWTEXT.main",279));
          //<< write "</A>"
          m$.Cmd.Write("</A>");
        }
        //<< } else {
        else {
          //<< write "&nbsp;"
          m$.Cmd.Write("&nbsp;");
        }
        //<< }
        //<< write "</FONT></TD>",YCR
        m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
      }
      //<< }
      //<< 
      //<< write YCR,"</TR>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    }
    //<< 
    //<< } else {
    else {
      //<< 
      //<< SET YBBN=""
      mVar YBBN = m$.var("YBBN");
      YBBN.set("");
      //<< FOR  {
      for (;true;) {
        //<< SET YBBN=$ORDER(^WWW122(0,YNKEY,YBBN))
        YBBN.set(m$.Fnc.$order(m$.var("^WWW122",0,m$.var("YNKEY").get(),YBBN.get())));
        //<< QUIT:YBBN=""
        if (mOp.Equal(YBBN.get(),"")) {
          break;
        }
        //<< 
        //<< SET YLFN  = $PIECE($GET(^WWW122(0,YNKEY,YBBN,1)),Y,1)
        mVar YLFN = m$.var("YLFN");
        YLFN.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YNKEY").get(),YBBN.get(),1)),m$.var("Y").get(),1));
        //<< SET YSATZ = ""
        mVar YSATZ = m$.var("YSATZ");
        YSATZ.set("");
        //<< IF YLFN'="" SET YSATZ = $GET(^WWW003(0,YNDATEI,YLFN,1))
        if (mOp.NotEqual(YLFN.get(),"")) {
          YSATZ.set(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YNDATEI").get(),YLFN.get(),1)));
        }
        //<< 
        //<< SET YSATZ1=$GET(^WWW122(0,YNKEY,YBBN,1))
        YSATZ1.set(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YNKEY").get(),YBBN.get(),1)));
        //<< IF YSATZ="" {
        if (mOp.Equal(YSATZ.get(),"")) {
          //<< SET $PIECE(YSATZ,Y,2) = $PIECE(YSATZ1,Y,12)
          m$.pieceVar(YSATZ,m$.var("Y").get(),2).set(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),12));
          //<< IF $DATA(^WWW1221(0,YNKEY,YBBN,SPRACHE,1)) SET $PIECE(YSATZ,Y,2) = $PIECE(^WWW1221(0,YNKEY,YBBN,SPRACHE,1),Y,1)
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1221",0,m$.var("YNKEY").get(),YBBN.get(),m$.var("SPRACHE").get(),1)))) {
            m$.pieceVar(YSATZ,m$.var("Y").get(),2).set(m$.Fnc.$piece(m$.var("^WWW1221",0,m$.var("YNKEY").get(),YBBN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
          }
          //<< SET $PIECE(YSATZ,Y,3) = $PIECE(YSATZ1,Y,5)
          m$.pieceVar(YSATZ,m$.var("Y").get(),3).set(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),5));
          //<< SET $PIECE(YSATZ,Y,4) = $PIECE(YSATZ1,Y,6)
          m$.pieceVar(YSATZ,m$.var("Y").get(),4).set(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),6));
          //<< SET $PIECE(YSATZ,Y,8) = $PIECE(YSATZ1,Y,32)
          m$.pieceVar(YSATZ,m$.var("Y").get(),8).set(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),32));
        }
        //<< }
        //<< 
        //<< set YKEY=YNKEY_","_YBBN
        YKEY.set(mOp.Concat(mOp.Concat(m$.var("YNKEY").get(),","),YBBN.get()));
        //<< set strBGColor = " BGCOLOR="_$select($increment(YDDSATZ)#2:YWHITE,1:YGRAY)    ; SR15487
        strBGColor.set(mOp.Concat(" BGCOLOR=",m$.Fnc.$select(mOp.Modulus(m$.Fnc.$increment(m$.var("YDDSATZ")),2),m$.var("YWHITE").get(),1,m$.var("YGRAY").get())));
        //<< write "<TR"_strBGColor_">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<TR",strBGColor.get()),">"));
        //<< 
        //<< ;--------------------------------------- Col 1
        //<< write "<TD NOWRAP>"                                    ; SR15487
        m$.Cmd.Write("<TD NOWRAP>");
        //<< write "<FONT SIZE=2>"
        m$.Cmd.Write("<FONT SIZE=2>");
        //<< do AddLink(YKEY,YNKEY,YAKTION,YFORM,$$^WWWTEXT(374))        ; "Select Data Record"    ; SR15487
        m$.Cmd.Do("AddLink",YKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),m$.fnc$("WWWTEXT.main",374));
        //<< set YINHALT="daten.gif"
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set("daten.gif");
        //<< IF $PIECE(YSATZ,Y,22)=1   set YINHALT="primaer.gif"   ; FIXME : $$$WWW003UniqueKey() [D22] is deprecated <GRF>
        if (mOp.Equal(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),22),1)) {
          YINHALT.set("primaer.gif");
        }
        //<< IF $PIECE(YSATZ,Y,3)=16   set YINHALT="1:n"  ;1-n Beziehung
        if (mOp.Equal(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),3),16)) {
          YINHALT.set("1:n");
        }
        //<< IF $PIECE(YSATZ,Y,35)'="" set YINHALT=$PIECE($GET(^WWW100(0,"RELATIONSHIP",SPRACHE,$PIECE(YSATZ,Y,35),1)),Y,1)
        if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),35),"")) {
          YINHALT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"RELATIONSHIP",m$.var("SPRACHE").get(),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),35),1)),m$.var("Y").get(),1));
        }
        //<< do THUMP
        m$.Cmd.Do("THUMP");
        //<< write "</FONT></TD>",YCR
        m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
        //<< 
        //<< ;--------------------------------------- Col 2
        //<< write "<TD NOWRAP>"                                    ; SR15487
        m$.Cmd.Write("<TD NOWRAP>");
        //<< WRITE "<FONT SIZE=2>"
        m$.Cmd.Write("<FONT SIZE=2>");
        //<< do AddLink(YKEY,YNKEY,YAKTION,YFORM,$$^WWWTEXT(374))        ; "Select Data Record"    ; SR15487
        m$.Cmd.Do("AddLink",YKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),m$.fnc$("WWWTEXT.main",374));
        //<< WRITE YBBN
        m$.Cmd.Write(YBBN.get());
        //<< WRITE "</A>"
        m$.Cmd.Write("</A>");
        //<< WRITE "</FONT></TD>",YCR
        m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
        //<< 
        //<< ;--------------------------------------- Col 3-7
        //<< FOR YI=2,3,4,6,21 {
        mVar YI = m$.var("YI");
        for (Object _YI: new Object[] {2,3,4,6,21}) {
          YI.set(_YI);
          //<< SET YINHALT=$PIECE(YSATZ,Y,YI)
          YINHALT.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),_YI));
          //<< IF (YI=2) && (YLFN'="") {   ;WENN TEXTANZEIGE ;when
          if ((mOp.Equal(_YI,2)) && (mOp.NotEqual(YLFN.get(),""))) {
            //<< // SR15539: vvv
            //<< IF YNDATEI'="" {
            if (mOp.NotEqual(m$.var("YNDATEI").get(),"")) {
              //<< IF $DATA(^WWW0031(0,YNDATEI,YLFN,SPRACHE,1)) SET YINHALT=$PIECE(^WWW0031(0,YNDATEI,YLFN,SPRACHE,1),Y,1)
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,m$.var("YNDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
                YINHALT.set(m$.Fnc.$piece(m$.var("^WWW0031",0,m$.var("YNDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
              }
              //<< set objWWW003=$get(^WWW003(0,YNDATEI,YLFN,1))
              objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YNDATEI").get(),YLFN.get(),1)));
              //<< if $$$TRIMWS(YINHALT)=$$$FREE set YINHALT=$$$FREE_" ["_$$$WWW003PropertyName(objWWW003)_"]"
              if (mOp.Equal(include.COMSYSString.$$$TRIMWS(m$,YINHALT),include.COMSYS.$$$FREE(m$))) {
                YINHALT.set(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYS.$$$FREE(m$)," ["),include.WWWConst.$$$WWW003PropertyName(m$,objWWW003)),"]"));
              }
            }
            //<< }
            //<< // SR15539 ^^^
            //<< SET YINHALT="("_YLFN_") "_YINHALT
            YINHALT.set(mOp.Concat(mOp.Concat(mOp.Concat("(",YLFN.get()),") "),YINHALT.get()));
          }
          //<< 
          //<< }
          //<< IF YI=21 SET YINHALT=$PIECE(YSATZ1,Y,21)_"("_$PIECE(YSATZ1,Y,60)_"-"_$PIECE(YSATZ1,Y,3)_"."_$PIECE(YSATZ1,Y,4)_")"
          if (mOp.Equal(_YI,21)) {
            YINHALT.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),21),"("),m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),60)),"-"),m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),3)),"."),m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),4)),")"));
          }
          //<< 
          //<< ;   NEW YLFN                                             ; SR15487
          //<< ;   SET YLFN=YI
          //<< set idFld = YI
          idFld.set(_YI);
          //<< 
          //<< write "<TD NOWRAP>"                                    ; SR15487
          m$.Cmd.Write("<TD NOWRAP>");
          //<< WRITE "<FONT SIZE=2>"
          m$.Cmd.Write("<FONT SIZE=2>");
          //<< 
          //<< ; vvv   SR15487
          //<< set strTitle = ""
          mVar strTitle = m$.var("strTitle");
          strTitle.set("");
          //<< if (YI=3) {
          if ((mOp.Equal(_YI,3))) {
            //<< if ($piece(YSATZ,Y,26)'="") {
            if ((mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26),""))) {
              //<< set strTitle = $piece(YSATZ,Y,26)
              strTitle.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26));
            }
            //<< } elseif $piece(YSATZ,Y,8)'="" {
            else if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8),"")) {
              //<< set strTitle = $piece(YSATZ,Y,8)_"("_$translate($piece(YSATZ,Y,9),"""")_")"
              strTitle.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8),"("),m$.Fnc.$translate(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),9),"\"")),")"));
            }
            //<< } else {
            else {
              //<< set strTitle = $$^WWWTEXT(374)
              strTitle.set(m$.fnc$("WWWTEXT.main",374));
            }
          }
          //<< }
          //<< } else {
          else {
            //<< set strTitle = $$^WWWTEXT(374)
            strTitle.set(m$.fnc$("WWWTEXT.main",374));
          }
          //<< }
          //<< 
          //<< do AddLink(YKEY,YNKEY,YAKTION,YFORM,strTitle)        ; SR15487
          m$.Cmd.Do("AddLink",YKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),strTitle.get());
          //<< 
          //<< SET YDATEI="WWW003"
          YDATEI.set("WWW003");
          //<< ;   SR15487 vvv
          //<< ;   IF YI=3 IF YINHALT=16 IF $PIECE(YSATZ,Y,26)'="" SET YINHALT=$PIECE(YSATZ,Y,26) SET YLFN=8 ;ALTERNATIVE DATATYPE
          //<< ;   if YI=3 IF $PIECE(YSATZ,Y,8)'=""                SET YINHALT=$PIECE(YSATZ,Y,8) SET YLFN=8  ;TYBD;14,2,2005
          //<< ;   DO DATEN                                ; SR15487
          //<< IF YI=3 {
          if (mOp.Equal(_YI,3)) {
            //<< IF YINHALT=16 && ($PIECE(YSATZ,Y,26)'="") {
            if (mOp.Equal(YINHALT.get(),16) && (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26),""))) {
              //<< SET YINHALT=$PIECE(YSATZ,Y,26)
              YINHALT.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26));
              //<< SET idFld=8 ;ALTERNATIVE DATATYPE
              idFld.set(8);
            }
            //<< } elseIF $PIECE(YSATZ,Y,8)'="" {
            else if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8),"")) {
              //<< SET YINHALT=$PIECE(YSATZ,Y,8)
              YINHALT.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),8));
              //<< SET idFld=8  ;TYBD;14,2,2005
              idFld.set(8);
            }
          }
          //<< }
          //<< }
          //<< 
          //<< DO DATEN(idFld)
          m$.Cmd.Do("DATEN",idFld.get());
          //<< ;   SR15487 ^^^
          //<< IF YI=4  {
          if (mOp.Equal(_YI,4)) {
            //<< IF $PIECE(YSATZ,Y,26)'="" && ($PIECE(YSATZ,Y,3)=16) {
            if (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),26),"") && (mOp.Equal(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),3),16))) {
              //<< SET YINHALT=$$^WWWTEXT("WWW00045")  ;OID
              YINHALT.set(m$.fnc$("WWWTEXT.main","WWW00045"));
            }
          }
          //<< }
          //<< } elseif YI=3 {
          else if (mOp.Equal(_YI,3)) {
            //<< write $$^WWWTEXT("WWW00069")_" "  ;as
            m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main","WWW00069")," "));
          }
          //<< }
          //<< 
          //<< WRITE $$^WWWUML(YINHALT,1)
          m$.Cmd.Write(m$.fnc$("WWWUML.main",YINHALT.get(),1));
          //<< ;IF YLFN=8 IF $GET(SPRACHE)="DE" IF $PIECE(YSATZ,Y,9)'="" WRITE " (",$PIECE(YSATZ,Y,9),")"   ; SR12777;GRF
          //<< if (idFld=8) && ($piece(YSATZ,Y,9)'="") {                                                    ; SR15487
          if ((mOp.Equal(idFld.get(),8)) && (mOp.NotEqual(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),9),""))) {
            //<< write "<FONT SIZE=1> (",$translate($piece($piece(YSATZ,Y,9),","),$$$DBLQUOTE),")</FONT>"
            m$.Cmd.Write("<FONT SIZE=1> (",m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),9),","),include.COMSYSString.$$$DBLQUOTE(m$)),")</FONT>");
          }
          //<< }
          //<< IF YINHALT="" WRITE "&nbsp;"
          if (mOp.Equal(YINHALT.get(),"")) {
            m$.Cmd.Write("&nbsp;");
          }
          //<< ;DO DATEN
          //<< ;WRITE $$^WWWUML(YINHALT,1)
          //<< ;IF YINHALT="" WRITE "&nbsp;"
          //<< WRITE "</A>"
          m$.Cmd.Write("</A>");
          //<< WRITE "</FONT></TD>",YCR
          m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
        }
        //<< }
        //<< 
        //<< ;--------------------------------------- Col 8
        //<< do DisplayCustomizing(YKEY)              ;SR14275
        m$.Cmd.Do("DisplayCustomizing",YKEY.get());
        //<< 
        //<< WRITE "</TR>",YCR
        m$.Cmd.Write("</TR>",m$.var("YCR").get());
      }
    }
    //<< }
    //<< }
    //<< QUIT
    return;
  }

  //<< 
  //<< DisplayCustomizing(pYKEY="")
  public Object DisplayCustomizing(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Displays an additional column on the 'Create Forms and Listings' screen WWW120
    //<< ; to display links to customisations for each primary key and each field for
    //<< ; each company.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-Jul-2009   shobby  SR16710: Add visual indicators to the fields to link to 'Core Rules' or field
    //<< ;                           customising.
    //<< ; 08-Aug-2007   shobby  SR?????: Put the link back to the customizing form.
    //<< ; 29-Mar-2007   RPW     SR15487: &nbsp requires a ; on the end
    //<< ; 27-Mar-2007   GRF     SR15487: Close <TD> and <FONT>; call AddLink
    //<< ; 08-Feb-2006   shobby  SR14275: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< new id1,id2,strLink,idCompany,YDATEI,YKEY
    mVar id1 = m$.var("id1");
    mVar id2 = m$.var("id2");
    mVar strLink = m$.var("strLink");
    mVar idCompany = m$.var("idCompany");
    mVar YDATEI = m$.var("YDATEI");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(id1,id2,strLink,idCompany,YDATEI,YKEY);
    //<< 
    //<< set id1=$piece(pYKEY,",",1)
    id1.set(m$.Fnc.$piece(pYKEY.get(),",",1));
    //<< set id2=$piece(pYKEY,",",2)
    id2.set(m$.Fnc.$piece(pYKEY.get(),",",2));
    //<< set strLink=""
    strLink.set("");
    //<< 
    //<< write "<TD NOWRAP>"                                    ; SR15487
    m$.Cmd.Write("<TD NOWRAP>");
    //<< 
    //<< write "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< write "&nbsp"
    m$.Cmd.Write("&nbsp");
    //<< 
    //<< set blnCoreRule=$$$NO
    mVar blnCoreRule = m$.var("blnCoreRule");
    blnCoreRule.set(include.COMSYS.$$$NO(m$));
    //<< if (id1'="")&&(YFORM="WWW122") {
    if ((mOp.NotEqual(id1.get(),"")) && (mOp.Equal(m$.var("YFORM").get(),"WWW122"))) {
      //<< if $data(^WWW122C2(0,id1,id2)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122C2",0,id1.get(),id2.get())))) {
        //<< do AddLink(pYKEY,YNKEY,YAKTION,YFORM_"C2",$$$Text(34455),"ball_blue.gif")   ;Core rules are defined for this field.         ;SR16710
        m$.Cmd.Do("AddLink",pYKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),mOp.Concat(m$.var("YFORM").get(),"C2"),include.COMSYS.$$$Text(m$,34455),"ball_blue.gif");
      }
      //<< } else {
      else {
        //<< do AddLink(pYKEY,YNKEY,YAKTION,YFORM_"C2",$$$Text(34456),"ball_grey.gif")   ;No Core rules are defined for this field.      ;SR16710
        m$.Cmd.Do("AddLink",pYKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),mOp.Concat(m$.var("YFORM").get(),"C2"),include.COMSYS.$$$Text(m$,34456),"ball_grey.gif");
      }
      //<< }
      //<< write "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< }
    //<< 
    //<< if (id1'="")&&(id2'="") {
    if ((mOp.NotEqual(id1.get(),"")) && (mOp.NotEqual(id2.get(),""))) {
      //<< set idCompany=""
      idCompany.set("");
      //<< for {
      for (;true;) {
        //<< xecute "set idCompany=$order(^"_YFORM_"D(0,id1,id2,idCompany))"
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat("set idCompany=$order(^",m$.var("YFORM").get()),"D(0,id1,id2,idCompany))"));
        //<< quit:idCompany=""
        if (mOp.Equal(idCompany.get(),"")) {
          break;
        }
        //<< 
        //<< set YKEY=pYKEY_","_idCompany
        YKEY.set(mOp.Concat(mOp.Concat(pYKEY.get(),","),idCompany.get()));
        //<< do AddLink(YKEY,YNKEY,YAKTION,YFORM_"D",$$$Text($lb(34457,idCompany)),"ball_green.gif")        ; Customisation is defined for company %1 on this field.    ; SR15487 ;SR????? ;SR16710
        m$.Cmd.Do("AddLink",YKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),mOp.Concat(m$.var("YFORM").get(),"D"),include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild(34457,idCompany.get())),"ball_green.gif");
        //<< write "</A>"
        m$.Cmd.Write("</A>");
      }
    }
    //<< }
    //<< }
    //<< write "</FONT></TD>",YCR             ; SR15487
    m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
    //<< quit
    return null;
  }

  //<< 
  //<< ANLIS
  public void ANLIS() {
    //<< /*-------------------------------------------------------------------------------
    //<< ;   LISTGENERATORVORGABEN
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Mar-2007   GRF     SR15487: ^WWW131D (customization of ^WWW131) does *NOT*
    //<< ;                       exist - commented call to DisplayCustomizing but ensure
    //<< ;                       8 columns.   CLEANED UP
    //<< ; 27-Mar-2007   GRF     SR15487: set strBGColor once instead of repeated checking;
    //<< ;                       call AddLink; close <FONT>; brace format
    //<< ; 08-Feb-2006   shobby  SR14275: Call out to DisplayCustomising
    //<< ;-------------------------------------------------------------------------------*/
    //<< new intCol,strBGColor,YKEY
    mVar intCol = m$.var("intCol");
    mVar strBGColor = m$.var("strBGColor");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(intCol,strBGColor,YKEY);
    //<< 
    //<< set YFORM="WWW131"
    mVar YFORM = m$.var("YFORM");
    YFORM.set("WWW131");
    //<< set YDATEI=YNKEY
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.var("YNKEY").get());
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< 
    //<< ;  vvv SR15487
    //<< if '$data(^WWW131(0,YNKEY)) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW131",0,m$.var("YNKEY").get())))) {
      //<< set strBGColor = " BGCOLOR="_$select($increment(YDDSATZ)#2:YWHITE,1:YGRAY)
      strBGColor.set(mOp.Concat(" BGCOLOR=",m$.Fnc.$select(mOp.Modulus(m$.Fnc.$increment(m$.var("YDDSATZ")),2),m$.var("YWHITE").get(),1,m$.var("YGRAY").get())));
      //<< write "<TR "_strBGColor_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TR ",strBGColor.get()),">"));
      //<< 
      //<< ;--------------------------------------- Col 1-8
      //<< for intCol=1:1:8 {
      for (intCol.set(1);(mOp.LessOrEqual(intCol.get(),8));intCol.set(mOp.Add(intCol.get(),1))) {
        //<< write "<TD NOWRAP>"
        m$.Cmd.Write("<TD NOWRAP>");
        //<< write "<FONT SIZE=2>"
        m$.Cmd.Write("<FONT SIZE=2>");
        //<< if intCol=3 {
        if (mOp.Equal(intCol.get(),3)) {
          //<< do AddLink(YNKEY,YNKEY,YAKTION,YFORM,$$^WWWTEXT(374))        ; "Select Data Record"
          m$.Cmd.Do("AddLink",m$.var("YNKEY").get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),m$.fnc$("WWWTEXT.main",374));
          //<< write $$^WWWTEXT(334)                                        ; "No List Items"
          m$.Cmd.Write(m$.fnc$("WWWTEXT.main",334));
          //<< write "</A>"
          m$.Cmd.Write("</A>");
        }
        //<< } else {
        else {
          //<< write "&nbsp;"
          m$.Cmd.Write("&nbsp;");
        }
        //<< }
        //<< write "</FONT></TD>",YCR
        m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
      }
      //<< }
      //<< write "</TR>",YCR
      m$.Cmd.Write("</TR>",m$.var("YCR").get());
    }
    //<< }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< ANGANT
  public void ANGANT() {
    //<< /*-------------------------------------------------------------------------------
    //<< ;   GANTCHART VORGAGEN
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Mar-2007   GRF     SR15487: ^WWWDRAGDROPD is *NOT* customization of
    //<< ;                       ^WWWDRAGDROP - commented call to DisplayCustomizing but
    //<< ;                       ensure 8 columns.   CLEANED UP
    //<< ; 27-Mar-2007   GRF     SR15487: Call AddLink; close <FONT>; set strBGColor once
    //<< ;                       instead of repeated checking; brace format
    //<< ; 08-Feb-2006   shobby  SR14275: Call out to DisplayCustomising
    //<< ;-------------------------------------------------------------------------------*/
    //<< new intCol,strBGColor,YKEY
    mVar intCol = m$.var("intCol");
    mVar strBGColor = m$.var("strBGColor");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(intCol,strBGColor,YKEY);
    //<< 
    //<< set YFORM  = "WWWDRAGDROP"
    mVar YFORM = m$.var("YFORM");
    YFORM.set("WWWDRAGDROP");
    //<< set YDATEI = YNKEY
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.var("YNKEY").get());
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< 
    //<< ;  vvv SR15487
    //<< set strBGColor = " BGCOLOR="_$select($increment(YDDSATZ)#2:YWHITE,1:YGRAY)
    strBGColor.set(mOp.Concat(" BGCOLOR=",m$.Fnc.$select(mOp.Modulus(m$.Fnc.$increment(m$.var("YDDSATZ")),2),m$.var("YWHITE").get(),1,m$.var("YGRAY").get())));
    //<< write "<TR "_strBGColor_">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<TR ",strBGColor.get()),">"));
    //<< 
    //<< ;--------------------------------------- Col 1-8
    //<< for intCol=1:1:8 {
    for (intCol.set(1);(mOp.LessOrEqual(intCol.get(),8));intCol.set(mOp.Add(intCol.get(),1))) {
      //<< write "<TD NOWRAP>"
      m$.Cmd.Write("<TD NOWRAP>");
      //<< write "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< if intCol=3 {
      if (mOp.Equal(intCol.get(),3)) {
        //<< do AddLink(YNKEY,YNKEY,YAKTION,YFORM,$$^WWWTEXT(374))        ; "Select Data Record"
        m$.Cmd.Do("AddLink",m$.var("YNKEY").get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),m$.fnc$("WWWTEXT.main",374));
        //<< if $data(^WWWDRAGDROP(0,YNKEY)) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDRAGDROP",0,m$.var("YNKEY").get())))) {
          //<< write $$^WWWTEXT(405)                                    ; "Gantt Chart Layout Default"   ; "Gantt Chart AUSWÄHLEN"
          m$.Cmd.Write(m$.fnc$("WWWTEXT.main",405));
        }
        //<< } else {
        else {
          //<< write $$^WWWTEXT(404)                                    ; "No Gantt Chart Defaults"      ; "KEIN Gantt Chart"
          m$.Cmd.Write(m$.fnc$("WWWTEXT.main",404));
        }
        //<< }
        //<< write "</A>"
        m$.Cmd.Write("</A>");
      }
      //<< } else {
      else {
        //<< write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
      }
      //<< }
      //<< write "</FONT></TD>",YCR
      m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
    }
    //<< }
    //<< 
    //<< write "</TR>",YCR
    m$.Cmd.Write("</TR>",m$.var("YCR").get());
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< ANLIS1
  public void ANLIS1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   LISTGENERATOR
    //<< ;
    //<< ; History:
    //<< ; 28-Mar-2007   GRF     SR15487: Always show 8 columns; remove ineffective anchors
    //<< ;                       in cols 4-7 and combine with col 8.   CLEANED UP
    //<< ; 27-Mar-2007   GRF     SR15487: Call AddLink; close <FONT>; set strBGColor once
    //<< ;                       instead of repeated checking; brace format; pass YI to
    //<< ;                       DATEN because new of YLFN is different under brace format
    //<< ;-------------------------------------------------------------------------------
    //<< new strBGColor,YKEY
    mVar strBGColor = m$.var("strBGColor");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(strBGColor,YKEY);
    //<< 
    //<< set YFORM="WWW131"
    mVar YFORM = m$.var("YFORM");
    YFORM.set("WWW131");
    //<< set YDATEI=YNKEY
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.var("YNKEY").get());
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< 
    //<< ;  vvv SR15487
    //<< set YLFN=""
    mVar YLFN = m$.var("YLFN");
    YLFN.set("");
    //<< set YLFN = "" for { set YLFN = $order(^WWW131(0,YNKEY,YLFN)) quit:YLFN=""
    YLFN.set("");
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW131",0,m$.var("YNKEY").get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      //<< 
      //<< set YSATZ=$GET(^WWW131(0,YNKEY,YLFN,1))
      mVar YSATZ = m$.var("YSATZ");
      YSATZ.set(m$.Fnc.$get(m$.var("^WWW131",0,m$.var("YNKEY").get(),YLFN.get(),1)));
      //<< set YKEY=YNKEY_","_YLFN
      YKEY.set(mOp.Concat(mOp.Concat(m$.var("YNKEY").get(),","),YLFN.get()));
      //<< set strBGColor = " BGCOLOR="_$select($increment(YDDSATZ)#2:YWHITE,1:YGRAY)
      strBGColor.set(mOp.Concat(" BGCOLOR=",m$.Fnc.$select(mOp.Modulus(m$.Fnc.$increment(m$.var("YDDSATZ")),2),m$.var("YWHITE").get(),1,m$.var("YGRAY").get())));
      //<< write "<TR"_strBGColor_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TR",strBGColor.get()),">"));
      //<< 
      //<< ;--------------------------------------- Col 1
      //<< write "<TD NOWRAP>"
      m$.Cmd.Write("<TD NOWRAP>");
      //<< write "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< do AddLink(YKEY,YNKEY,YAKTION,YFORM,$$^WWWTEXT(374))        ; "Select Data Record"
      m$.Cmd.Do("AddLink",YKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),m$.fnc$("WWWTEXT.main",374));
      //<< write "&nbsp;"
      m$.Cmd.Write("&nbsp;");
      //<< write "</FONT></TD>",YCR
      m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
      //<< 
      //<< ;--------------------------------------- Col 2
      //<< write "<TD NOWRAP>"
      m$.Cmd.Write("<TD NOWRAP>");
      //<< write "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< do AddLink(YKEY,YNKEY,YAKTION,YFORM,$$^WWWTEXT(374))        ; "Select Data Record"
      m$.Cmd.Do("AddLink",YKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),m$.fnc$("WWWTEXT.main",374));
      //<< write YLFN
      m$.Cmd.Write(YLFN.get());
      //<< write "</A>"
      m$.Cmd.Write("</A>");
      //<< write "</FONT></TD>",YCR
      m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
      //<< 
      //<< ;--------------------------------------- Col 3
      //<< set YINHALT = $piece(YSATZ,Y,1)
      mVar YINHALT = m$.var("YINHALT");
      YINHALT.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),1));
      //<< WRITE "<TD NOWRAP>"
      m$.Cmd.Write("<TD NOWRAP>");
      //<< WRITE "<FONT SIZE=2>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< do AddLink(YKEY,YNKEY,YAKTION,YFORM,$$^WWWTEXT(374))        ; "Select Data Record"
      m$.Cmd.Do("AddLink",YKEY.get(),m$.var("YNKEY").get(),m$.var("YAKTION").get(),YFORM.get(),m$.fnc$("WWWTEXT.main",374));
      //<< set YDATEI="WWW131"
      YDATEI.set("WWW131");
      //<< do DATEN(1)
      m$.Cmd.Do("DATEN",1);
      //<< write $$^WWWUML(YINHALT,1)
      m$.Cmd.Write(m$.fnc$("WWWUML.main",YINHALT.get(),1));
      //<< IF YINHALT="" write "&nbsp;"
      if (mOp.Equal(YINHALT.get(),"")) {
        m$.Cmd.Write("&nbsp;");
      }
      //<< write "</A>"
      m$.Cmd.Write("</A>");
      //<< write "</FONT></TD>",YCR
      m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
      //<< 
      //<< ;--------------------------------------- Col 4-8
      //<< for intCol=4:1:8 {
      mVar intCol = m$.var("intCol");
      for (intCol.set(4);(mOp.LessOrEqual(intCol.get(),8));intCol.set(mOp.Add(intCol.get(),1))) {
        //<< WRITE "<TD NOWRAP>"
        m$.Cmd.Write("<TD NOWRAP>");
        //<< WRITE "<FONT SIZE=2>"
        m$.Cmd.Write("<FONT SIZE=2>");
        //<< write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< write "</FONT></TD>",YCR
        m$.Cmd.Write("</FONT></TD>",m$.var("YCR").get());
      }
      //<< }
      //<< 
      //<< write "</TR>",YCR
      m$.Cmd.Write("</TR>",m$.var("YCR").get());
    }
    //<< }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< DATEN(YLFN)
  public Object DATEN(Object ... _p) {
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   FORMAT DATEN
    //<< ;   Convert *Input Type* codes to text and replace references to relation classes
    //<< ;   with their class names (e.g. WWW100 becomes System Parameter)
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
    //<< ; 28-Mar-2007   GRF     SR15487: use objClassData and macros; convert to brace
    //<< ;                       format; doco
    //<< ; 27-Mar-2007   GRF     SR15487: Pass YLFN in to cope with different new
    //<< ;                       operation under brace format.
    //<< ;-------------------------------------------------------------------------------
    //<< new blnProcess,objClassData,YDAT,YDATA,YFE,YKE,YSAT        ; vvv SR15487
    mVar blnProcess = m$.var("blnProcess");
    mVar objClassData = m$.var("objClassData");
    mVar YDAT = m$.var("YDAT");
    mVar YDATA = m$.var("YDATA");
    mVar YFE = m$.var("YFE");
    mVar YKE = m$.var("YKE");
    mVar YSAT = m$.var("YSAT");
    m$.newVar(blnProcess,objClassData,YDAT,YDATA,YFE,YKE,YSAT);
    //<< 
    //<< set objClassData = $get(^WWW003(0,YDATEI,YLFN,1))
    objClassData.set(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)));
    //<< set YQ=0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< set YTYP = $$$WWW003InputType(objClassData)
    mVar YTYP = m$.var("YTYP");
    YTYP.set(include.WWWConst.$$$WWW003InputType(m$,objClassData));
    //<< set YDAT = $$$WWW003RelationDatabase(objClassData)
    YDAT.set(include.WWWConst.$$$WWW003RelationDatabase(m$,objClassData));
    //<< 
    //<< if (YINHALT'="") && (YDAT'="") {
    if ((mOp.NotEqual(m$.var("YINHALT").get(),"")) && (mOp.NotEqual(YDAT.get(),""))) {
      //<< set blnProcess = $$$YES
      blnProcess.set(include.COMSYS.$$$YES(m$));
      //<< set YKE  = $$$WWW003RelationalPrimaryKeys(objClassData)
      YKE.set(include.WWWConst.$$$WWW003RelationalPrimaryKeys(m$,objClassData));
      //<< if (YKE'="") && ($extract(YKE)'="""") {
      if ((mOp.NotEqual(YKE.get(),"")) && (mOp.NotEqual(m$.Fnc.$extract(YKE.get()),"\""))) {
        //<< set blnProcess=(YKEY[",") || ('$data(@YKE)) || ($get(@YKE)="")
        blnProcess.set((mOp.Contains(m$.var("YKEY").get(),",")) || (mOp.Not(m$.Fnc.$data(m$.indirectVar(YKE.get())))) || (mOp.Equal(m$.Fnc.$get(m$.indirectVar(YKE.get())),"")));
      }
      //<< }
      //<< if blnProcess {
      if (mOp.Logical(blnProcess.get())) {
        //<< set YFE  = $$$WWW003RelationalDisplayItems(objClassData)
        YFE.set(include.WWWConst.$$$WWW003RelationalDisplayItems(m$,objClassData));
        //<< if +YFE=0 SET YFE=1
        if (mOp.Equal(mOp.Positive(YFE.get()),0)) {
          YFE.set(1);
        }
        //<< if (YDAT="WWW001") && $data(^WWW0011(0,YINHALT,SPRACHE,1)) {
        if ((mOp.Equal(YDAT.get(),"WWW001")) && mOp.Logical(m$.Fnc.$data(m$.var("^WWW0011",0,m$.var("YINHALT").get(),m$.var("SPRACHE").get(),1)))) {
          //<< set YINHALT = $piece(^WWW0011(0,YINHALT,SPRACHE,1),Y,1)
          mVar YINHALT = m$.var("YINHALT");
          YINHALT.set(m$.Fnc.$piece(m$.var("^WWW0011",0,m$.var("YINHALT").get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        }
        //<< } else {
        else {
          //<< set YSAT  = "^"_YDAT_"("_$$^WWWYM(YDAT,1)
          YSAT.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YDAT.get()),"("),m$.fnc$("WWWYM.main",YDAT.get(),1)));
          //<< set YDATA = $get(^WWW001(0,YDAT,1))
          YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YDAT.get(),1)));
          //<< if (YKE'="") && ($extract(YKE)'=",") set YSAT = YSAT_YKE_","
          if ((mOp.NotEqual(YKE.get(),"")) && (mOp.NotEqual(m$.Fnc.$extract(YKE.get()),","))) {
            YSAT.set(mOp.Concat(mOp.Concat(YSAT.get(),YKE.get()),","));
          }
          //<< if $$$WWW001AltSaveProcedure(YDATA)=4 {
          if (mOp.Equal(include.WWWConst.$$$WWW001AltSaveProcedure(m$,YDATA),4)) {
            //<< set YSAT = YSAT_""""_$translate(YINHALT,"""")_""""_")"
            YSAT.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YSAT.get(),"\""),m$.Fnc.$translate(m$.var("YINHALT").get(),"\"")),"\""),")"));
          }
          //<< } else {
          else {
            //<< set YSAT = YSAT_""""_$translate(YINHALT,"""")_""""_",1)"
            YSAT.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YSAT.get(),"\""),m$.Fnc.$translate(m$.var("YINHALT").get(),"\"")),"\""),",1)"));
          }
          //<< }
          //<< set YSAT(1) = $piece($$^WWWSETL(YSAT),Y,YFE)
          YSAT.var(1).set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YSAT.get()),m$.var("Y").get(),YFE.get()));
          //<< if YSAT(1)'="" set YINHALT = $extract($translate(YSAT(1),"|"," "),1,30) set YQ=1
          if (mOp.NotEqual(YSAT.var(1).get(),"")) {
            mVar YINHALT = m$.var("YINHALT");
            YINHALT.set(m$.Fnc.$extract(m$.Fnc.$translate(YSAT.var(1).get(),"|"," "),1,30));
            YQ.set(1);
          }
        }
      }
    }
    //<< }
    //<< }
    //<< } else {
    else {
      //<< do FORMAT
      m$.Cmd.Do("FORMAT");
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< FORMAT ;DATENFORMAT FELDER ;data format
  public Object FORMAT() {
    //<< 
    //<< QUIT:YINHALT=""
    if (mOp.Equal(m$.var("YINHALT").get(),"")) {
      return null;
    }
    //<< SET YINHALT=$$GetLiteral^WWWTR(YTYP,YINHALT)
    mVar YINHALT = m$.var("YINHALT");
    YINHALT.set(m$.fnc$("WWWTR.GetLiteral",m$.var("YTYP").get(),m$.var("YINHALT").get()));
    //<< 
    //<< ;I YTYP=8!(YTYP=12) S YINHALT=$E("              ",1,(12-$L(YINHALT)))_YINHALT Q
    //<< IF YTYP=5 SET YINHALT=$EXTRACT("*****************",1,$LENGTH(YINHALT)) QUIT
    if (mOp.Equal(m$.var("YTYP").get(),5)) {
      YINHALT.set(m$.Fnc.$extract("*****************",1,m$.Fnc.$length(YINHALT.get())));
      return null;
    }
    //<< IF YTYP=3 SET YINHALT=$EXTRACT($PIECE(YINHALT,"|",1),1,50) SET:YINHALT'="" YINHALT=YINHALT_"..." QUIT
    if (mOp.Equal(m$.var("YTYP").get(),3)) {
      YINHALT.set(m$.Fnc.$extract(m$.Fnc.$piece(YINHALT.get(),"|",1),1,50));
      if (mOp.NotEqual(YINHALT.get(),"")) {
        YINHALT.set(mOp.Concat(YINHALT.get(),"..."));
      }
      return null;
    }
    //<< QUIT
    return null;
  }

  //<< 
  //<< THUMP ;BILDANZEIGE
  public Object THUMP() {
    //<< QUIT:YINHALT=""
    if (mOp.Equal(m$.var("YINHALT").get(),"")) {
      return null;
    }
    //<< 
    //<< IF $FIND(YINHALT,":") WRITE YINHALT QUIT   ; 1:1, 1:n , m:n ; tybd;14,2,2005
    if (mOp.Logical(m$.Fnc.$find(m$.var("YINHALT").get(),":"))) {
      m$.Cmd.Write(m$.var("YINHALT").get());
      return null;
    }
    //<< IF '$FIND(YINHALT,".GIF") IF '$FIND(YINHALT,".gif") QUIT
    if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get(),".GIF"))) {
      if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get(),".gif"))) {
        return null;
      }
    }
    //<< IF '$FIND(YINHALT,"/") SET YINHALT=YGIF_YINHALT
    if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get(),"/"))) {
      mVar YINHALT = m$.var("YINHALT");
      YINHALT.set(mOp.Concat(m$.var("YGIF").get(),m$.var("YINHALT").get()));
    }
    //<< WRITE YCR,"<IMG SRC="_""""_YINHALT_""""_" BORDER=0 ALIGN=RIGHT TITLE="_""""_$PIECE(YINHALT,".",1)_""""_" border=0>"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YINHALT").get()),"\"")," BORDER=0 ALIGN=RIGHT TITLE="),"\""),m$.Fnc.$piece(m$.var("YINHALT").get(),".",1)),"\"")," border=0>"));
    //<< QUIT
    return null;
  }

  //<< 
  //<< AddLink(YKEY,YDATEI,YAKTION,YFORM,pstrTitle="",pstrImage="")
  public Object AddLink(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YAKTION = m$.newVarRef("YAKTION",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pstrImage = m$.newVarRef("pstrImage",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Build opening structure for link with optional title
    //<< ;
    //<< ; History :
    //<< ; 02-Jul-2009   shobby  SR16710: Add images.
    //<< ; 27-Mar-2007   GRF     SR15487: created from lines in other subroutines as common
    //<< ;                       wrapper for WWWCGI with implied NEW.
    //<< ;-------------------------------------------------------------------------------
    //<< write "<A"
    m$.Cmd.Write("<A");
    //<< if pstrTitle'="" write " TITLE="""_pstrTitle_""""
    if (mOp.NotEqual(pstrTitle.get(),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",pstrTitle.get()),"\""));
    }
    //<< write " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=\"",YAKTION.get()),"EP=WWWFORM&amp;YFORM="),YFORM.get()));
    //<< do ^WWWCGI
    m$.Cmd.Do("WWWCGI.main");
    //<< write """>"
    m$.Cmd.Write("\">");
    //<< if (pstrImage'="") write "<IMG border=0 SRC="""_YGIF_pstrImage_""">"   ;SR16710
    if ((mOp.NotEqual(pstrImage.get(),""))) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<IMG border=0 SRC=\"",m$.var("YGIF").get()),pstrImage.get()),"\">"));
    }
    //<< quit
    return null;
  }

//<< 
//<< 
}
