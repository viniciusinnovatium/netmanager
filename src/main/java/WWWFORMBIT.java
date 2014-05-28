//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMBIT
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:51
//*****************************************************************************

import mLibrary.*;


//<< WWWFORMBIT
public class WWWFORMBIT extends mClass {

  public void main() {
    _WWWFORMBIT();
  }

  public void _WWWFORMBIT() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       BITMAP SUCHFORMULAR
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
    //<< ; 14-Jan-2009   GRF     SR16253: <NOSOURCE> during upgrade compile; Doco; quits
    //<< ; 14.04.2004    FIS     Created
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YDATEI,YLFN,YFULLTEXT,YTAB,YFRAGE,YMAX,YHTMFORM,YTABINDEX,YHELPTXT,YSHOWSUM
    mVar YDATEI = m$.var("YDATEI");
    mVar YLFN = m$.var("YLFN");
    mVar YFULLTEXT = m$.var("YFULLTEXT");
    mVar YTAB = m$.var("YTAB");
    mVar YFRAGE = m$.var("YFRAGE");
    mVar YMAX = m$.var("YMAX");
    mVar YHTMFORM = m$.var("YHTMFORM");
    mVar YTABINDEX = m$.var("YTABINDEX");
    mVar YHELPTXT = m$.var("YHELPTXT");
    mVar YSHOWSUM = m$.var("YSHOWSUM");
    m$.newVar(YDATEI,YLFN,YFULLTEXT,YTAB,YFRAGE,YMAX,YHTMFORM,YTABINDEX,YHELPTXT,YSHOWSUM);
    //<< 
    //<< SET YDATEI=$PIECE(YVOR,Y,11)  ;KLASSE ;class
    YDATEI.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11));
    //<< IF YDATEI=""                   DO ^WWWINFO($$^WWWTEXT(33),1) QUIT  ;KEINE DATEIVORGABE ;no
    if (mOp.Equal(YDATEI.get(),"")) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",33),1);
      return;
    }
    //<< IF '$DATA(^WWW001B(0,YDATEI))  DO ^WWWINFO($$^WWWTEXT(33),1) QUIT  ;KEINE DATEIVORGABE ;no
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW001B",0,YDATEI.get())))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",33),1);
      return;
    }
    //<< IF '$DATA(@("^"_YDATEI_"b"))   DO ^WWWINFO($$^WWWTEXT(46),1) QUIT  ;KEINE DATEN ;no
    if (mOp.Not(m$.Fnc.$data(m$.indirectVar((mOp.Concat(mOp.Concat("^",YDATEI.get()),"b")))))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",46),1);
      return;
    }
    //<< 
    //<< SET YHTMFORM="WWW2"
    YHTMFORM.set("WWW2");
    do {
      //<< ;KEY-EVENTS
      //<< DO
      //<< . WRITE YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . WRITE YCR,"<script for=document event=""onkeyup()"" language=""JavaScript"">"
      m$.Cmd.Write(m$.var("YCR").get(),"<script for=document event=\"onkeyup()\" language=\"JavaScript\">");
      //<< . WRITE YCR,"{pruef(window.event.keyCode)}"
      m$.Cmd.Write(m$.var("YCR").get(),"{pruef(window.event.keyCode)}");
      //<< . WRITE YCR,"function pruef(wert)"
      m$.Cmd.Write(m$.var("YCR").get(),"function pruef(wert)");
      //<< . WRITE YCR,"{"
      m$.Cmd.Write(m$.var("YCR").get(),"{");
      //<< . WRITE YCR,"  if (wert == 117) {window.history.back();}"
      m$.Cmd.Write(m$.var("YCR").get(),"  if (wert == 117) {window.history.back();}");
      //<< . WRITE YCR,"  if (wert == 116) {document.WWW.YOPEN.value='SAVEHELP'; SAVENOW();}"
      m$.Cmd.Write(m$.var("YCR").get(),"  if (wert == 116) {document.WWW.YOPEN.value='SAVEHELP'; SAVENOW();}");
      //<< . WRITE YCR,"  if (wert == 123) {"
      m$.Cmd.Write(m$.var("YCR").get(),"  if (wert == 123) {");
      //<< . WRITE YCR,"    //window.setTimeout("_""""_"loadResult()"_""""_",600);"  ;PROBLEM WENN NOCH KEINE SUCHAUSWAHL GETROFFEN WURDE;FIS;03.02.05
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("    //window.setTimeout(","\""),"loadResult()"),"\""),",600);"));
      //<< . WRITE YCR,"  }"
      m$.Cmd.Write(m$.var("YCR").get(),"  }");
      //<< . WRITE YCR,"}"
      m$.Cmd.Write(m$.var("YCR").get(),"}");
      //<< . WRITE YCR,"</script>"
      m$.Cmd.Write(m$.var("YCR").get(),"</script>");
      //<< . WRITE YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . WRITE YCR,"<script language=""JavaScript"">"
      m$.Cmd.Write(m$.var("YCR").get(),"<script language=\"JavaScript\">");
      //<< . WRITE YCR,"function loadResult()"
      m$.Cmd.Write(m$.var("YCR").get(),"function loadResult()");
      //<< . WRITE YCR,"{"
      m$.Cmd.Write(m$.var("YCR").get(),"{");
      //<< . WRITE YCR,"  if (document."_YHTMFORM_".searchresult.value > 0) window.location.href='"_YAKTION_"EP=WWWMANU&amp;YEXEC=DO|SHOW^WWWFORMBIT&amp;YBACK="_YFORM_",&amp;YFORM="_YFORM_"&amp;YKEY="_YDATEI
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  if (document.",YHTMFORM.get()),".searchresult.value > 0) window.location.href='"),m$.var("YAKTION").get()),"EP=WWWMANU&amp;YEXEC=DO|SHOW^WWWFORMBIT&amp;YBACK="),m$.var("YFORM").get()),",&amp;YFORM="),m$.var("YFORM").get()),"&amp;YKEY="),YDATEI.get()));
      //<< . NEW YFORM,YKEY,YBACK,YDATEI
      mVar YFORM = m$.var("YFORM");
      mVar YKEY = m$.var("YKEY");
      mVar YBACK = m$.var("YBACK");
      m$.newVarBlock(1,YFORM,YKEY,YBACK,YDATEI);
      //<< . DO ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< . WRITE "';"
      m$.Cmd.Write("';");
      //<< . WRITE YCR,"  else alert('"_$$^WWWTEXT(119)_"');"  ;KEINE DATEN GEFUNDEN
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("  else alert('",m$.fnc$("WWWTEXT.main",119)),"');"));
      //<< . WRITE YCR,"}"
      m$.Cmd.Write(m$.var("YCR").get(),"}");
      //<< . WRITE YCR,"</script>"
      m$.Cmd.Write(m$.var("YCR").get(),"</script>");
      //<< . WRITE YCR
      m$.Cmd.Write(m$.var("YCR").get());
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< WRITE YCR,"<FORM NAME="_""""_YHTMFORM_""""_">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FORM NAME=","\""),YHTMFORM.get()),"\""),">"));
    //<< WRITE YCR,"<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 VALIGN=TOP WIDTH=100%>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 VALIGN=TOP WIDTH=100%>");
    //<< WRITE YCR,"<TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
    //<< WRITE YCR,"<TD ALIGN=RIGHT valign=top NOWRAP>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TD ALIGN=RIGHT valign=top NOWRAP>");
    //<< IF '$DATA(^WWW122(0,YFORM)) IF +$PIECE(YVOR,Y,13)=1 DO
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),13)),1)) {
        //<< . IF $GET(YDREID)'=1 WRITE YCR,"<FIELDSET STYLE="_""""_"border-color:"_YLIGHTGREY_""""_">"
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDREID")),1)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=","\""),"border-color:"),m$.var("YLIGHTGREY").get()),"\""),">"));
        }
        //<< . IF +$GET(YDREID)=1 WRITE YCR,"<FIELDSET STYLE="_""""_"border-color-dark:"_YLIGHTGREY_"; border-color-light:"_YDARKGRAY_";"_""""_">"  ;FIS;31.03.04;25445;RAHMEN 2-FARBIG
        if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YDREID"))),1)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=","\""),"border-color-dark:"),m$.var("YLIGHTGREY").get()),"; border-color-light:"),m$.var("YDARKGRAY").get()),";"),"\""),">"));
        }
        //<< . WRITE "<LEGEND><FONT SIZE=2><B>"_$$^WWWTEXT(47)_"</B></FONT></LEGEND>"  ;SELECT
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<LEGEND><FONT SIZE=2><B>",m$.fnc$("WWWTEXT.main",47)),"</B></FONT></LEGEND>"));
      }
    }
    //<< 
    //<< WRITE YCR,"<FONT SIZE=2>"
    m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=2>");
    //<< ;HILFETEXT
    //<< ;SET YHELPTXT=$PIECE($GET(^WWW127(YM,YFORM,"M",1,SPRACHE,1)),Y,1)
    //<< SET YHELPTXT=$PIECE($GET(^WWW127(0,YFORM,"M",1,SPRACHE,1)),Y,1)  ; ;07.06.04;FAN;ZENTRALE DATEI;25866
    YHELPTXT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW127",0,m$.var("YFORM").get(),"M",1,m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
    //<< IF YHELPTXT'="" SET YHELPTXT=$$^WWWTRANSLATE(YHELPTXT,"|","\n")
    if (mOp.NotEqual(YHELPTXT.get(),"")) {
      YHELPTXT.set(m$.fnc$("WWWTRANSLATE.main",YHELPTXT.get(),"|","\\n"));
    }
    //<< IF $TRANSLATE(YHELPTXT," ")="" SET YHELPTXT=$$^WWWTEXT(28,,1)  ;KEIN HILFETEXT HINTERLEGT ;no
    if (mOp.Equal(m$.Fnc.$translate(YHELPTXT.get()," "),"")) {
      YHELPTXT.set(m$.fnc$("WWWTEXT.main",28,null,1));
    }
    //<< SET YTABINDEX=1
    YTABINDEX.set(1);
    //<< DO SELECT
    m$.Cmd.Do("SELECT");
    //<< IF '$DATA(^WWW122(0,YFORM)) IF +$PIECE(YVOR,Y,13)=1 WRITE YCR,"</FIELDSET>"
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),13)),1)) {
        m$.Cmd.Write(m$.var("YCR").get(),"</FIELDSET>");
      }
    }
    //<< WRITE YCR,"</TD></TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR>");
    //<< WRITE YCR,"<TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
    //<< WRITE YCR,"<TD ALIGN=LEFT valign=top NOWRAP>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TD ALIGN=LEFT valign=top NOWRAP>");
    //<< WRITE YCR,"<FONT SIZE=2>"
    m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=2>");
    //<< IF '$DATA(^WWW122(0,YFORM)) IF +$PIECE(YVOR,Y,13)=1 DO
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),13)),1)) {
        //<< . IF $GET(YDREID)'=1 WRITE YCR,"<FIELDSET STYLE="_""""_"border-color:"_YLIGHTGREY_""""_">"
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDREID")),1)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=","\""),"border-color:"),m$.var("YLIGHTGREY").get()),"\""),">"));
        }
        //<< . IF +$GET(YDREID)=1 WRITE YCR,"<FIELDSET STYLE="_""""_"border-color-dark:"_YLIGHTGREY_"; border-color-light:"_YDARKGRAY_";"_""""_">"  ;FIS;31.03.04;25445;RAHMEN 2-FARBIG
        if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YDREID"))),1)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=","\""),"border-color-dark:"),m$.var("YLIGHTGREY").get()),"; border-color-light:"),m$.var("YDARKGRAY").get()),";"),"\""),">"));
        }
        //<< . WRITE "<LEGEND><FONT SIZE=2><B>"_$$^WWWTEXT(33529)_"</B></FONT></LEGEND>"  ;RESULT
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<LEGEND><FONT SIZE=2><B>",m$.fnc$("WWWTEXT.main",33529)),"</B></FONT></LEGEND>"));
      }
    }
    //<< 
    //<< DO RESULT
    m$.Cmd.Do("RESULT");
    //<< IF '$DATA(^WWW122(0,YFORM)) IF +$PIECE(YVOR,Y,13)=1 WRITE YCR,"</FIELDSET>"
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),13)),1)) {
        m$.Cmd.Write(m$.var("YCR").get(),"</FIELDSET>");
      }
    }
    //<< WRITE YCR,"</TD></TR></TABLE>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
    //<< WRITE YCR,"</FORM>"
    m$.Cmd.Write(m$.var("YCR").get(),"</FORM>");
    //<< QUIT
    return;
  }

  //<< 
  //<< SELECT ;SELECTION
  public void SELECT() {
    //<< SET YFULLTEXT=0
    mVar YFULLTEXT = m$.var("YFULLTEXT");
    YFULLTEXT.set(0);
    //<< SET YSHOWSUM=0
    mVar YSHOWSUM = m$.var("YSHOWSUM");
    YSHOWSUM.set(0);
    //<< KILL ^WWWSOR(YUSER,"SORT")
    m$.var("^WWWSOR",m$.var("YUSER").get(),"SORT").kill();
    //<< WRITE YCR,"<TABLE BORDER=0 CELLSPACING=5 CELLPADDING=0 VALIGN=TOP WIDTH=100%>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=0 CELLSPACING=5 CELLPADDING=0 VALIGN=TOP WIDTH=100%>");
    //<< ;SUCHE BIT F躌 BIT ;search bit to bit
    //<< SET YLFN=""
    mVar YLFN = m$.var("YLFN");
    YLFN.set("");
    //<< FOR  SET YLFN=$ORDER(^WWW001B(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW001B",0,m$.var("YDATEI").get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      do {
        //<< . SET YFDAT1=$GET(^WWW003(0,YDATEI,YLFN,1))  ;DATENFELDDEFINITION
        mVar YFDAT1 = m$.var("YFDAT1");
        YFDAT1.set(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)));
        //<< . QUIT:YFDAT1=""
        if (mOp.Equal(YFDAT1.get(),"")) {
          break;
        }
        //<< . ;
        //<< . IF $PIECE($GET(^WWW001B(0,YDATEI,YLFN,1)),Y,5)=1 SET YFULLTEXT=1  QUIT  ;VOLLTEXTSUCHE
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001B",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),5),1)) {
          YFULLTEXT.set(1);
          break;
        }
        //<< . IF $PIECE($GET(^WWW001B(0,YDATEI,YLFN,1)),Y,3)=1 SET YSHOWSUM=1   QUIT  ;SUMMENANZEIGE
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001B",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),3),1)) {
          YSHOWSUM.set(1);
          break;
        }
        //<< . IF $PIECE($GET(^WWW001B(0,YDATEI,YLFN,1)),Y,4)'=1                 QUIT  ;NUR WENN EINZELN  ;only when special
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001B",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),4),1)) {
          break;
        }
        //<< . ;
        //<< . SET YFRAGE=$$^WWWFELDNAME(YDATEI,"D",YLFN)
        mVar YFRAGE = m$.var("YFRAGE");
        YFRAGE.set(m$.fnc$("WWWFELDNAME.main",m$.var("YDATEI").get(),"D",YLFN.get()));
        //<< . IF $EXTRACT(YFRAGE,1,5)="_FREE" QUIT
        if (mOp.Equal(m$.Fnc.$extract(YFRAGE.get(),1,5),"_FREE")) {
          break;
        }
        //<< . SET ^WWWSOR(YUSER,"SORT",YLFN)=YFRAGE  ;FIS;14.07.04;ZWISCHENSPEICHERN DAMIT VOLLTEXTSUCHE OBEN ;therewith upstairs
        m$.var("^WWWSOR",m$.var("YUSER").get(),"SORT",YLFN.get()).set(YFRAGE.get());
      } while (false);
    }
    //<< 
    //<< ;VOLLTEXTSUCHE
    //<< IF YFULLTEXT=1 DO
    if (mOp.Equal(YFULLTEXT.get(),1)) {
      //<< . SET YLFN=9999
      YLFN.set(9999);
      //<< . SET YFRAGE=$$^WWWTEXT(33033)  ;VOLLTEXTSUCHE
      mVar YFRAGE = m$.var("YFRAGE");
      YFRAGE.set(m$.fnc$("WWWTEXT.main",33033));
      //<< . WRITE YCR,"<TR>"
      m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
      //<< . WRITE YCR,"<TD ALIGN=RIGHT valign=top WIDTH=25%>"
      m$.Cmd.Write(m$.var("YCR").get(),"<TD ALIGN=RIGHT valign=top WIDTH=25%>");
      //<< . WRITE YCR,"<FONT SIZE=2>"
      m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=2>");
      //<< . WRITE YCR,"&nbsp;<B>"
      m$.Cmd.Write(m$.var("YCR").get(),"&nbsp;<B>");
      //<< . WRITE $EXTRACT(YFRAGE,1,35)
      m$.Cmd.Write(m$.Fnc.$extract(YFRAGE.get(),1,35));
      //<< . WRITE YCR,"</B></FONT>"
      m$.Cmd.Write(m$.var("YCR").get(),"</B></FONT>");
      //<< . WRITE "</TD><TD ALIGN=LEFT valign=top NOWRAP COLSPAN=3>"
      m$.Cmd.Write("</TD><TD ALIGN=LEFT valign=top NOWRAP COLSPAN=3>");
      //<< . ;
      //<< . ;WRITE YCR,"<textarea NAME="_""""_"Y"_YDATEI_"D"_YLFN_""""
      //<< . WRITE YCR,"<input type="_""""_"text"_""""_" NAME="_""""_"Y"_YDATEI_"D"_YLFN_""""_" maxlength=100"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<input type=","\""),"text"),"\"")," NAME="),"\""),"Y"),m$.var("YDATEI").get()),"D"),YLFN.get()),"\"")," maxlength=100"));
      //<< . WRITE " ID="_""""_YLFN_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" ID=","\""),YLFN.get()),"\""));
      //<< . ;WRITE " style="_""""_"font-family:arial; padding-top:0; padding-bottom:0; width:220px; height:115;"_""""   ;style
      //<< . WRITE " style="_""""_"font-family:arial; padding-top:0; padding-bottom:0; width:345px;"_""""   ;style
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" style=","\""),"font-family:arial; padding-top:0; padding-bottom:0; width:345px;"),"\""));
      //<< . WRITE YCR," onKeyDown='if (event.keyCode == 13) event.keyCode = 9;'"
      m$.Cmd.Write(m$.var("YCR").get()," onKeyDown='if (event.keyCode == 13) event.keyCode = 9;'");
      //<< . WRITE YCR," onhelp="_""""_"javascript: alert('"_$TRANSLATE(YHELPTXT,"'"_"""","创")_"'); window.event.returnValue = false; window.event.cancelBubble = true;"_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onhelp=","\""),"javascript: alert('"),m$.Fnc.$translate(m$.var("YHELPTXT").get(),mOp.Concat("'","\""),"创")),"'); window.event.returnValue = false; window.event.cancelBubble = true;"),"\""));
      //<< . WRITE YCR," onBlur='{ retval = EventValue("_""""_YUCI_""""_","_""""_YUSER_""""_","_""""_YFORM_""""_","_""""_"FIX"_""""_","_""""_"WWWSEARBIT2"_""""_",this.value,"_""""_"0"_""""_","_""""_"Y"_YDATEI_"D"_YLFN_""""_");"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onBlur='{ retval = EventValue(","\""),m$.var("YUCI").get()),"\""),","),"\""),m$.var("YUSER").get()),"\""),","),"\""),m$.var("YFORM").get()),"\""),","),"\""),"FIX"),"\""),","),"\""),"WWWSEARBIT2"),"\""),",this.value,"),"\""),"0"),"\""),","),"\""),"Y"),m$.var("YDATEI").get()),"D"),YLFN.get()),"\""),");"));
      //<< . WRITE YCR," window.setTimeout("_""""_"updateResult()"_""""_",100); }'"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" window.setTimeout(","\""),"updateResult()"),"\""),",100); }'"));
      //<< . WRITE YCR," tabindex="_YTABINDEX
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(" tabindex=",m$.var("YTABINDEX").get()));
      //<< . SET YTABINDEX=YTABINDEX+1
      mVar YTABINDEX = m$.var("YTABINDEX");
      YTABINDEX.set(mOp.Add(m$.var("YTABINDEX").get(),1));
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . ;WRITE YCR,"</textarea>"
      //<< . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","X"_YDATEI_"D"_YLFN,1)=1  ;VORBELEGEN SUCHLOGIK: UND ;And
      m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",mOp.Concat(mOp.Concat(mOp.Concat("X",m$.var("YDATEI").get()),"D"),YLFN.get()),1).set(1);
      //<< . ;
      //<< . WRITE "</TD>"
      m$.Cmd.Write("</TD>");
      //<< . WRITE "</TR>"
      m$.Cmd.Write("</TR>");
    }
    //<< 
    //<< SET YTAB=0
    mVar YTAB = m$.var("YTAB");
    YTAB.set(0);
    //<< SET YLFN=""
    YLFN.set("");
    //<< FOR  SET YLFN=$ORDER(^WWWSOR(YUSER,"SORT",YLFN)) QUIT:YLFN=""  DO
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"SORT",YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      do {
        //<< . SET YFDAT1=$GET(^WWW003(0,YDATEI,YLFN,1))  ;DATENFELDDEFINITION
        mVar YFDAT1 = m$.var("YFDAT1");
        YFDAT1.set(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)));
        //<< . ;
        //<< . NEW TYP,REL,PARA,RELF,LENGTH
        mVar TYP = m$.var("TYP");
        mVar REL = m$.var("REL");
        mVar PARA = m$.var("PARA");
        mVar RELF = m$.var("RELF");
        mVar LENGTH = m$.var("LENGTH");
        m$.newVarBlock(1,TYP,REL,PARA,RELF,LENGTH);
        //<< . SET YFRAGE=$GET(^WWWSOR(YUSER,"SORT",YLFN))
        mVar YFRAGE = m$.var("YFRAGE");
        YFRAGE.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"SORT",YLFN.get())));
        //<< . SET REL =$PIECE(YFDAT1,Y,8)    ;RELATIONSDATEI (PARAMETER)
        REL.set(m$.Fnc.$piece(YFDAT1.get(),m$.var("Y").get(),8));
        //<< . SET PARA=$PIECE(YFDAT1,Y,9)    ;KEY F躌 RELATIONSDATEI (Z.B. SPRACHE) ;KEY to
        PARA.set(m$.Fnc.$piece(YFDAT1.get(),m$.var("Y").get(),9));
        //<< . SET RELF=$PIECE(YFDAT1,Y,10)   ;ANZUZEIGENDES FELD AUS RELATIONSDATEI ;field out of
        RELF.set(m$.Fnc.$piece(YFDAT1.get(),m$.var("Y").get(),10));
        //<< . IF +RELF=0 SET RELF=1
        if (mOp.Equal(mOp.Positive(RELF.get()),0)) {
          RELF.set(1);
        }
        //<< . IF REL'="INPARA" IF REL'="WWW100" IF REL'="WWW101" IF PARA'="" SET REL=""
        if (mOp.NotEqual(REL.get(),"INPARA")) {
          if (mOp.NotEqual(REL.get(),"WWW100")) {
            if (mOp.NotEqual(REL.get(),"WWW101")) {
              if (mOp.NotEqual(PARA.get(),"")) {
                REL.set("");
              }
            }
          }
        }
        //<< . QUIT:REL=""
        if (mOp.Equal(REL.get(),"")) {
          break;
        }
        //<< . IF YTAB=0 WRITE YCR,"<TR>"
        if (mOp.Equal(YTAB.get(),0)) {
          m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
        }
        //<< . WRITE YCR,"<TD ALIGN=RIGHT valign=top WIDTH=25%>"
        m$.Cmd.Write(m$.var("YCR").get(),"<TD ALIGN=RIGHT valign=top WIDTH=25%>");
        //<< . WRITE YCR,"<FONT SIZE=2>"
        m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=2>");
        //<< . WRITE YCR,"&nbsp;"
        m$.Cmd.Write(m$.var("YCR").get(),"&nbsp;");
        //<< . WRITE $EXTRACT(YFRAGE,1,35)
        m$.Cmd.Write(m$.Fnc.$extract(YFRAGE.get(),1,35));
        //<< . WRITE YCR,"</FONT>"
        m$.Cmd.Write(m$.var("YCR").get(),"</FONT>");
        //<< . ;WRITE YCR,"<BR>"
        //<< . WRITE "</TD><TD ALIGN=LEFT valign=top NOWRAP>"
        m$.Cmd.Write("</TD><TD ALIGN=LEFT valign=top NOWRAP>");
        //<< . ;
        //<< . DO
        do {
          //<< . . WRITE YCR,"<select NAME="_""""_"Y"_YDATEI_"D"_YLFN_""""
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<select NAME=","\""),"Y"),m$.var("YDATEI").get()),"D"),YLFN.get()),"\""));
          //<< . . WRITE " ID="_""""_YLFN_""""
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" ID=","\""),YLFN.get()),"\""));
          //<< . . WRITE " size=5 multiple="_""""_"multiple"_""""  ;multi-select
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" size=5 multiple=","\""),"multiple"),"\""));
          //<< . . WRITE " style="_""""_"padding-top:0; padding-bottom:0; width:220px;"_""""   ;style
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" style=","\""),"padding-top:0; padding-bottom:0; width:220px;"),"\""));
          //<< . . WRITE YCR," onKeyDown='if (event.keyCode == 13) event.keyCode = 9;'"
          m$.Cmd.Write(m$.var("YCR").get()," onKeyDown='if (event.keyCode == 13) event.keyCode = 9;'");
          //<< . . WRITE YCR," onhelp="_""""_"javascript: alert('"_$TRANSLATE(YHELPTXT,"'"_"""","创")_"'); window.event.returnValue = false; window.event.cancelBubble = true;"_""""
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onhelp=","\""),"javascript: alert('"),m$.Fnc.$translate(m$.var("YHELPTXT").get(),mOp.Concat("'","\""),"创")),"'); window.event.returnValue = false; window.event.cancelBubble = true;"),"\""));
          //<< . . WRITE YCR," onkeyup="_""""_"QUICKSELECT(this, event)"_""""
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(" onkeyup=","\""),"QUICKSELECT(this, event)"),"\""));
          //<< . . WRITE YCR," onBlur='{ selval=MULTISELECTD"_YLFN_"();"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" onBlur='{ selval=MULTISELECTD",YLFN.get()),"();"));
          //<< . . WRITE YCR," retval = EventValue("_""""_YUCI_""""_","_""""_YUSER_""""_","_""""_YFORM_""""_","_""""_"FIX"_""""_","_""""_"WWWSEARBIT2"_""""_",selval,"_""""_"0"_""""_","_""""_"Y"_YDATEI_"D"_YLFN_""""_");"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" retval = EventValue(","\""),m$.var("YUCI").get()),"\""),","),"\""),m$.var("YUSER").get()),"\""),","),"\""),m$.var("YFORM").get()),"\""),","),"\""),"FIX"),"\""),","),"\""),"WWWSEARBIT2"),"\""),",selval,"),"\""),"0"),"\""),","),"\""),"Y"),m$.var("YDATEI").get()),"D"),YLFN.get()),"\""),");"));
          //<< . . WRITE YCR," window.setTimeout("_""""_"updateResult()"_""""_",100); }'"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" window.setTimeout(","\""),"updateResult()"),"\""),",100); }'"));
          //<< . . WRITE YCR," tabindex="_YTABINDEX
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(" tabindex=",m$.var("YTABINDEX").get()));
          //<< . . SET YTABINDEX=YTABINDEX+1
          mVar YTABINDEX = m$.var("YTABINDEX");
          YTABINDEX.set(mOp.Add(m$.var("YTABINDEX").get(),1));
          //<< . . WRITE ">"
          m$.Cmd.Write(">");
          //<< . . WRITE YCR,"<option value="_""""_""""_">&nbsp;</option>"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat("<option value=","\""),"\""),">&nbsp;</option>"));
          //<< . . ;
          //<< . . NEW SUCH,YI
          mVar SUCH = m$.var("SUCH");
          mVar YI = m$.var("YI");
          m$.newVarBlock(2,SUCH,YI);
          //<< . . SET SUCH="^"_REL_"("_""""_$$^WWWYM(REL)_""""  ;ZUSAMMENBAU DER GLOBALREFERENZ ;the
          SUCH.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",REL.get()),"("),"\""),m$.fnc$("WWWYM.main",REL.get())),"\""));
          //<< . . IF PARA'="" SET SUCH=SUCH_","_PARA
          if (mOp.NotEqual(PARA.get(),"")) {
            SUCH.set(mOp.Concat(mOp.Concat(SUCH.get(),","),PARA.get()));
          }
          //<< . . SET SUCH=SUCH_")"
          SUCH.set(mOp.Concat(SUCH.get(),")"));
          //<< . . FOR  DO  QUIT:SUCH=""
          for (;true;) {
            do {
              //<< . . . SET SUCH=$QUERY(@SUCH)
              SUCH.set(m$.Fnc.$query(m$.indirectVar(SUCH.get())));
              //<< . . . IF $PIECE($PIECE(SUCH,"^",2),"(",1)'=REL SET SUCH="" QUIT
              if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$piece(SUCH.get(),"^",2),"(",1),REL.get())) {
                SUCH.set("");
                break;
              }
              //<< . . . IF $PIECE($PIECE(SUCH,"(",2),",",1)'=$$^WWWYM(REL) SET SUCH=""  QUIT
              if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$piece(SUCH.get(),"(",2),",",1),m$.fnc$("WWWYM.main",REL.get()))) {
                SUCH.set("");
                break;
              }
              //<< . . . IF PARA'="" FOR YI=2:1:1+$LENGTH(PARA,",") DO  QUIT:SUCH=""
              if (mOp.NotEqual(PARA.get(),"")) {
                for (YI.set(2);(mOp.LessOrEqual(YI.get(),mOp.Add(1,m$.Fnc.$length(PARA.get(),","))));YI.set(mOp.Add(YI.get(),1))) {
                  //<< . . . . IF $FIND($PIECE(PARA,",",YI-1),"""") IF $PIECE(SUCH,",",YI)'=$PIECE(PARA,",",YI-1) SET SUCH=""
                  if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(PARA.get(),",",mOp.Subtract(YI.get(),1)),"\""))) {
                    if (mOp.NotEqual(m$.Fnc.$piece(SUCH.get(),",",YI.get()),m$.Fnc.$piece(PARA.get(),",",mOp.Subtract(YI.get(),1)))) {
                      SUCH.set("");
                    }
                  }
                  //<< . . . . IF '$FIND($PIECE(PARA,",",YI-1),"""") IF $TRANSLATE($PIECE(SUCH,",",YI),"""")'=$TRANSLATE(@$PIECE(PARA,",",YI-1),"""") SET SUCH=""
                  if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(PARA.get(),",",mOp.Subtract(YI.get(),1)),"\""))) {
                    if (mOp.NotEqual(m$.Fnc.$translate(m$.Fnc.$piece(SUCH.get(),",",YI.get()),"\""),m$.Fnc.$translate(m$.indirectVar(m$.Fnc.$piece(PARA.get(),",",mOp.Subtract(YI.get(),1))).get(),"\""))) {
                      SUCH.set("");
                    }
                  }
                  if (mOp.Equal(SUCH.get(),"")) {
                    break;
                  }
                }
              }
              //<< . . . ;
              //<< . . . QUIT:SUCH=""
              if (mOp.Equal(SUCH.get(),"")) {
                break;
              }
              //<< . . . IF PARA'="" SET NR=$PIECE(SUCH,",",2+$LENGTH(PARA,","))
              if (mOp.NotEqual(PARA.get(),"")) {
                mVar NR = m$.var("NR");
                NR.set(m$.Fnc.$piece(SUCH.get(),",",mOp.Add(2,m$.Fnc.$length(PARA.get(),","))));
              }
              //<< . . . IF PARA="" SET NR=$PIECE(SUCH,",",2)
              if (mOp.Equal(PARA.get(),"")) {
                mVar NR = m$.var("NR");
                NR.set(m$.Fnc.$piece(SUCH.get(),",",2));
              }
              //<< . . . WRITE YCR,"<option value="_""""_$TRANSLATE(NR,"""")_""""
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat("<option value=","\""),m$.Fnc.$translate(m$.var("NR").get(),"\"")),"\""));
              //<< . . . IF NR'=$PIECE(@SUCH,Y,+RELF) WRITE ">"_$$^WWWNBSP($TRANSLATE(NR,"""")_" - "_$EXTRACT($PIECE(@SUCH,Y,+RELF),1,30))_"</option>" QUIT
              if (mOp.NotEqual(m$.var("NR").get(),m$.Fnc.$piece(m$.indirectVar(SUCH.get()).get(),m$.var("Y").get(),mOp.Positive(RELF.get())))) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.fnc$("WWWNBSP.main",mOp.Concat(mOp.Concat(m$.Fnc.$translate(m$.var("NR").get(),"\"")," - "),m$.Fnc.$extract(m$.Fnc.$piece(m$.indirectVar(SUCH.get()).get(),m$.var("Y").get(),mOp.Positive(RELF.get())),1,30)))),"</option>"));
                break;
              }
              //<< . . . IF NR=$PIECE(@SUCH,Y,+RELF)  WRITE ">"_$$^WWWNBSP($TRANSLATE(NR,""""))_"</option>" QUIT   ;WENN GLEICH; TYBD;5,8,2004
              if (mOp.Equal(m$.var("NR").get(),m$.Fnc.$piece(m$.indirectVar(SUCH.get()).get(),m$.var("Y").get(),mOp.Positive(RELF.get())))) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.fnc$("WWWNBSP.main",m$.Fnc.$translate(m$.var("NR").get(),"\""))),"</option>"));
                break;
              }
            } while (false);
            if (mOp.Equal(SUCH.get(),"")) {
              break;
            }
          }
          //<< . . ;
          //<< . . WRITE YCR,"</select>"
          m$.Cmd.Write(m$.var("YCR").get(),"</select>");
          //<< . . DO ^WWWFORM73(YDATEI,"D",YLFN)  ;AUFBEREITEN FELDAUSWAHL
          m$.Cmd.Do("WWWFORM73.main",m$.var("YDATEI").get(),"D",YLFN.get());
          //<< . . SET ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","X"_YDATEI_"D"_YLFN,1)=1  ;VORBELEGEN SUCHLOGIK: UND ;And
          m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",mOp.Concat(mOp.Concat(mOp.Concat("X",m$.var("YDATEI").get()),"D"),YLFN.get()),1).set(1);
        } while(false);
        m$.restoreVarBlock(2);
        //<< . ;
        //<< . WRITE "</TD>"
        m$.Cmd.Write("</TD>");
        //<< . IF YTAB=0 SET YTAB=1 QUIT
        if (mOp.Equal(YTAB.get(),0)) {
          YTAB.set(1);
          break;
        }
        //<< . SET YTAB=0
        YTAB.set(0);
        //<< . WRITE "</TR>"
        m$.Cmd.Write("</TR>");
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< IF YTAB=1 WRITE "<TD COLSPAN=2>&nbsp;</TD></TR>"
    if (mOp.Equal(YTAB.get(),1)) {
      m$.Cmd.Write("<TD COLSPAN=2>&nbsp;</TD></TR>");
    }
    //<< WRITE YCR,"</TABLE>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    //<< KILL ^WWWSOR(YUSER,"SORT")
    m$.var("^WWWSOR",m$.var("YUSER").get(),"SORT").kill();
    //<< QUIT
    return;
  }

  //<< 
  //<< RESULT  ;SHOW RESULT
  public void RESULT() {
    //<< NEW YMAX
    mVar YMAX = m$.var("YMAX");
    m$.newVar(YMAX);
    //<< 
    //<< SET YMAX=+$$^WWWBITCOUNT(YDATEI)
    YMAX.set(mOp.Positive(m$.fnc$("WWWBITCOUNT.main",m$.var("YDATEI").get())));
    //<< WRITE YCR,"<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 VALIGN=CENTER>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 VALIGN=CENTER>");
    //<< WRITE YCR,"<TR><TD ALIGN=LEFT valign=top>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TR><TD ALIGN=LEFT valign=top>");
    //<< WRITE YCR,"<FONT SIZE=2>"
    m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=2>");
    //<< WRITE YCR,"&nbsp;"
    m$.Cmd.Write(m$.var("YCR").get(),"&nbsp;");
    //<< WRITE $$^WWWTEXT(402)  ;ANZAHL DATENS腡ZE INSGESAMT ;Number together
    m$.Cmd.Write(m$.fnc$("WWWTEXT.main",402));
    //<< WRITE YCR,":&nbsp;"
    m$.Cmd.Write(m$.var("YCR").get(),":&nbsp;");
    //<< WRITE YCR,"</TD><TD ALIGN=LEFT valign=CENTER NOWRAP>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD><TD ALIGN=LEFT valign=CENTER NOWRAP>");
    //<< WRITE YCR,"<FONT SIZE=2>"
    m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=2>");
    //<< WRITE YCR,"&nbsp;"
    m$.Cmd.Write(m$.var("YCR").get(),"&nbsp;");
    //<< WRITE YCR,YMAX
    m$.Cmd.Write(m$.var("YCR").get(),YMAX.get());
    //<< WRITE YCR,"&nbsp;"
    m$.Cmd.Write(m$.var("YCR").get(),"&nbsp;");
    //<< WRITE YCR,"</TD></TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR>");
    //<< WRITE YCR,"<TR><TD ALIGN=LEFT valign=CENTER>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TR><TD ALIGN=LEFT valign=CENTER>");
    //<< WRITE YCR,"<FONT SIZE=2>"
    m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=2>");
    //<< WRITE YCR,"&nbsp;"
    m$.Cmd.Write(m$.var("YCR").get(),"&nbsp;");
    //<< WRITE $$^WWWTEXT(33529)  ;ANZAHL DATENS腡ZE ;Number
    m$.Cmd.Write(m$.fnc$("WWWTEXT.main",33529));
    //<< WRITE ":&nbsp;"
    m$.Cmd.Write(":&nbsp;");
    //<< WRITE YCR,"</TD><TD ALIGN=LEFT valign=CENTER NOWRAP>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD><TD ALIGN=LEFT valign=CENTER NOWRAP>");
    //<< WRITE YCR,"<FONT SIZE=2>"
    m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=2>");
    //<< WRITE YCR,"&nbsp;"
    m$.Cmd.Write(m$.var("YCR").get(),"&nbsp;");
    //<< WRITE YCR,"<input name="_""""_"searchresult"_""""_" type="_""""_"text"_""""_" value="_""""_YMAX_""""_" maxlength=12"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<input name=","\""),"searchresult"),"\"")," type="),"\""),"text"),"\"")," value="),"\""),YMAX.get()),"\"")," maxlength=12"));
    //<< WRITE " style="_""""_" border:none; padding-top:0; padding-bottom:0; background-color:"_YSILVER_"; width:70px; height:17px;"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" style=","\"")," border:none; padding-top:0; padding-bottom:0; background-color:"),m$.var("YSILVER").get()),"; width:70px; height:17px;"));
    //<< WRITE " font-family:arial; font-size:10pt; font-weight:bold; text-align:left;"
    m$.Cmd.Write(" font-family:arial; font-size:10pt; font-weight:bold; text-align:left;");
    //<< WRITE """"
    m$.Cmd.Write("\"");
    //<< WRITE " readonly unselectable>"
    m$.Cmd.Write(" readonly unselectable>");
    //<< WRITE YCR,"</input>"
    m$.Cmd.Write(m$.var("YCR").get(),"</input>");
    //<< WRITE YCR,YCR,"<SCRIPT LANGUAGE=JavaScript>"
    m$.Cmd.Write(m$.var("YCR").get(),m$.var("YCR").get(),"<SCRIPT LANGUAGE=JavaScript>");
    //<< WRITE YCR,"<!--"
    m$.Cmd.Write(m$.var("YCR").get(),"<!--");
    //<< WRITE YCR,"function updateResult()"
    m$.Cmd.Write(m$.var("YCR").get(),"function updateResult()");
    //<< WRITE YCR,"{"
    m$.Cmd.Write(m$.var("YCR").get(),"{");
    //<< WRITE YCR," result = EventValue("_""""_YUCI_""""_","_""""_YUSER_""""_","_""""_YFORM_""""_","_""""_"FIX"_""""_","_""""_"WWWFORMBIT2"_""""_","_""""_YSHOWSUM_""""_","_""""_"6"_""""_","_""""_YDATEI_""""_");"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" result = EventValue(","\""),m$.var("YUCI").get()),"\""),","),"\""),m$.var("YUSER").get()),"\""),","),"\""),m$.var("YFORM").get()),"\""),","),"\""),"FIX"),"\""),","),"\""),"WWWFORMBIT2"),"\""),","),"\""),m$.var("YSHOWSUM").get()),"\""),","),"\""),"6"),"\""),","),"\""),m$.var("YDATEI").get()),"\""),");"));
    //<< ;WRITE YCR," document."_YHTMFORM_".searchresult.value=result;"
    //<< WRITE YCR," eval(result);"
    m$.Cmd.Write(m$.var("YCR").get()," eval(result);");
    //<< WRITE YCR,"}"
    m$.Cmd.Write(m$.var("YCR").get(),"}");
    //<< IF YFULLTEXT=1 WRITE YCR,"window.setTimeout('document."_YHTMFORM_".Y"_YDATEI_"D"_9999_".focus();',10)"
    if (mOp.Equal(m$.var("YFULLTEXT").get(),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("window.setTimeout('document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YDATEI").get()),"D"),9999),".focus();',10)"));
    }
    //<< WRITE YCR,"//-->"
    m$.Cmd.Write(m$.var("YCR").get(),"//-->");
    //<< WRITE YCR,"</SCRIPT>"
    m$.Cmd.Write(m$.var("YCR").get(),"</SCRIPT>");
    do {
      //<< DO  ;ANZEIGEN SUCHERGEBNIS ;display
      //<< . WRITE YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . WRITE "<A HREF="_""""_"#"_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),"#"),"\""));
      //<< . WRITE " onClick="_""""_"if (document."_YHTMFORM_".searchresult.value > 0) { window.location.href='"_YAKTION_"EP=WWWMANU&amp;YEXEC=DO|SHOW^WWWFORMBIT&amp;YBACK="_YFORM_",&amp;YFORM="_YFORM_"&amp;YKEY="_YDATEI
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onClick=","\""),"if (document."),m$.var("YHTMFORM").get()),".searchresult.value > 0) { window.location.href='"),m$.var("YAKTION").get()),"EP=WWWMANU&amp;YEXEC=DO|SHOW^WWWFORMBIT&amp;YBACK="),m$.var("YFORM").get()),",&amp;YFORM="),m$.var("YFORM").get()),"&amp;YKEY="),m$.var("YDATEI").get()));
      //<< . NEW YFORM,YKEY,YBACK,YDATEI
      mVar YFORM = m$.var("YFORM");
      mVar YKEY = m$.var("YKEY");
      mVar YBACK = m$.var("YBACK");
      mVar YDATEI = m$.var("YDATEI");
      m$.newVarBlock(1,YFORM,YKEY,YBACK,YDATEI);
      //<< . DO ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< . WRITE "'} else alert('"_$$^WWWTEXT(119)_"');"_""""  ;KEINE DATEN GEFUNDEN
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("'} else alert('",m$.fnc$("WWWTEXT.main",119)),"');"),"\""));
      //<< . WRITE YCR," tabindex="_YTABINDEX
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(" tabindex=",m$.var("YTABINDEX").get()));
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . WRITE YCR,"<IMG SRC="_""""_YGIF_"search1.gif"_""""_" ALIGN=ABSBOTTOM TITLE="_""""_$$^WWWTEXT(33239)_""""_" border=0>"  ;ANZEIGEN ;give notice  ;display
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"search1.gif"),"\"")," ALIGN=ABSBOTTOM TITLE="),"\""),m$.fnc$("WWWTEXT.main",33239)),"\"")," border=0>"));
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< WRITE YCR,"</TD></TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR>");
    //<< WRITE YCR,"</TABLE>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    //<< 
    //<< 
    //<< ;ANZEIGEN SUMMENFELDER;FIS;25940;21.06.04
    //<< IF YSHOWSUM=1 DO
    if (mOp.Equal(m$.var("YSHOWSUM").get(),1)) {
      //<< . IF '$DATA(^WWW122(0,YFORM)) IF +$PIECE(YVOR,Y,13)=1 DO
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),13)),1)) {
          //<< . . WRITE YCR,"</fieldset>"
          m$.Cmd.Write(m$.var("YCR").get(),"</fieldset>");
          //<< . . IF $GET(YDREID)'=1 WRITE YCR,"<FIELDSET STYLE="_""""_"border-color:"_YLIGHTGREY_""""_">"
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDREID")),1)) {
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=","\""),"border-color:"),m$.var("YLIGHTGREY").get()),"\""),">"));
          }
          //<< . . IF +$GET(YDREID)=1 WRITE YCR,"<FIELDSET STYLE="_""""_"border-color-dark:"_YLIGHTGREY_"; border-color-light:"_YDARKGRAY_";"_""""_">"  ;FIS;31.03.04;25445;RAHMEN 2-FARBIG
          if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YDREID"))),1)) {
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=","\""),"border-color-dark:"),m$.var("YLIGHTGREY").get()),"; border-color-light:"),m$.var("YDARKGRAY").get()),";"),"\""),">"));
          }
        }
      }
      //<< . . ;WRITE "<LEGEND><FONT SIZE=2><B>"_$$^WWWTEXT(33529)_"</B></FONT></LEGEND>"  ;RESULT
      //<< . ;
      //<< . SET YTAB=3
      mVar YTAB = m$.var("YTAB");
      YTAB.set(3);
      //<< . SET YTAB(1)=0
      YTAB.var(1).set(0);
      //<< . WRITE YCR,"<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 VALIGN=CENTER WIDTH=100%>"
      m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 VALIGN=CENTER WIDTH=100%>");
      //<< . SET YLFN="" FOR  SET YLFN=$ORDER(^WWW001B(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
      mVar YLFN = m$.var("YLFN");
      YLFN.set("");
      for (;true;) {
        YLFN.set(m$.Fnc.$order(m$.var("^WWW001B",0,m$.var("YDATEI").get(),YLFN.get())));
        if (mOp.Equal(YLFN.get(),"")) {
          break;
        }
        do {
          //<< . . IF $PIECE($GET(^WWW001B(0,YDATEI,YLFN,1)),Y,3)'=1 QUIT  ;NUR WENN SUMMENBILDUNG ;only when
          if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001B",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),3),1)) {
            break;
          }
          //<< . . ;
          //<< . . NEW YTYP,YVALUE
          mVar YTYP = m$.var("YTYP");
          mVar YVALUE = m$.var("YVALUE");
          m$.newVarBlock(2,YTYP,YVALUE);
          //<< . . SET YFRAGE=$$^WWWFELDNAME(YDATEI,"D",YLFN)
          mVar YFRAGE = m$.var("YFRAGE");
          YFRAGE.set(m$.fnc$("WWWFELDNAME.main",m$.var("YDATEI").get(),"D",YLFN.get()));
          //<< . . IF $EXTRACT(YFRAGE,1,5)="_FREE" QUIT
          if (mOp.Equal(m$.Fnc.$extract(YFRAGE.get(),1,5),"_FREE")) {
            break;
          }
          //<< . . SET YTYP=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)
          YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),3));
          //<< . . IF YTAB#3=0 WRITE YCR,"<TR>" SET YTAB(1)=1
          if (mOp.Equal(mOp.Modulus(YTAB.get(),3),0)) {
            m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
            YTAB.var(1).set(1);
          }
          //<< . . WRITE YCR,"<TD ALIGN=RIGHT valign=TOP>"
          m$.Cmd.Write(m$.var("YCR").get(),"<TD ALIGN=RIGHT valign=TOP>");
          //<< . . WRITE YCR,"<FONT SIZE=2>"
          m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=2>");
          //<< . . WRITE YCR,"&nbsp;"
          m$.Cmd.Write(m$.var("YCR").get(),"&nbsp;");
          //<< . . WRITE $EXTRACT(YFRAGE,1,35)
          m$.Cmd.Write(m$.Fnc.$extract(YFRAGE.get(),1,35));
          //<< . . WRITE YCR,"</FONT>"
          m$.Cmd.Write(m$.var("YCR").get(),"</FONT>");
          //<< . . WRITE "</TD><TD ALIGN=RIGHT valign=top NOWRAP>"
          m$.Cmd.Write("</TD><TD ALIGN=RIGHT valign=top NOWRAP>");
          //<< . . WRITE YCR,"<FONT SIZE=2>"
          m$.Cmd.Write(m$.var("YCR").get(),"<FONT SIZE=2>");
          //<< . . WRITE "&nbsp;"
          m$.Cmd.Write("&nbsp;");
          //<< . . IF YTYP=8 WRITE "<B>"_$$^WWWWHR(YWHR)_"</B>"
          if (mOp.Equal(YTYP.get(),8)) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<B>",m$.fnc$("WWWWHR.main",m$.var("YWHR").get())),"</B>"));
          }
          //<< . . SET YVALUE=$$^WWWBITCOUNT(YDATEI,YLFN)  ;GESAMT;FIS;14.07.04 ;total
          YVALUE.set(m$.fnc$("WWWBITCOUNT.main",m$.var("YDATEI").get(),YLFN.get()));
          //<< . . DO
          do {
            //<< . . . WRITE YCR,"<input name="_""""_"bitsum"_YLFN_""""_" type="_""""_"text"_""""_" value="_""""_$$^WWWTR(0,YTYP,YVALUE)_""""_" maxlength=12"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<input name=","\""),"bitsum"),YLFN.get()),"\"")," type="),"\""),"text"),"\"")," value="),"\""),m$.fnc$("WWWTR.main",0,YTYP.get(),YVALUE.get())),"\"")," maxlength=12"));
            //<< . . . WRITE " style="_""""_" padding-top:0; padding-bottom:0; background-color:"_YSILVER_"; width:120px; height:19px;"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" style=","\"")," padding-top:0; padding-bottom:0; background-color:"),m$.var("YSILVER").get()),"; width:120px; height:19px;"));
            //<< . . . WRITE " font-family:arial; font-size:10pt; font-weight:normal; text-align:right;"
            m$.Cmd.Write(" font-family:arial; font-size:10pt; font-weight:normal; text-align:right;");
            //<< . . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . . WRITE " readonly unselectable>"
            m$.Cmd.Write(" readonly unselectable>");
            //<< . . . WRITE YCR,"</input>"
            m$.Cmd.Write(m$.var("YCR").get(),"</input>");
          } while(false);
          //<< . . ;
          //<< . . WRITE "</TD>"
          m$.Cmd.Write("</TD>");
          //<< . . SET YTAB=YTAB+1
          YTAB.set(mOp.Add(YTAB.get(),1));
          //<< . . IF YTAB#3=0 WRITE "</TR>" SET YTAB(1)=0
          if (mOp.Equal(mOp.Modulus(YTAB.get(),3),0)) {
            m$.Cmd.Write("</TR>");
            YTAB.var(1).set(0);
          }
        } while (false);
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . IF YTAB=4 DO
      if (mOp.Equal(YTAB.get(),4)) {
        //<< . . WRITE YCR,"<TD ALIGN=RIGHT valign=TOP COLSPAN=2 WIDTH=50%>"
        m$.Cmd.Write(m$.var("YCR").get(),"<TD ALIGN=RIGHT valign=TOP COLSPAN=2 WIDTH=50%>");
        //<< . . WRITE YCR,"&nbsp;"
        m$.Cmd.Write(m$.var("YCR").get(),"&nbsp;");
        //<< . . WRITE "</TD>"
        m$.Cmd.Write("</TD>");
      }
      //<< . ;
      //<< . IF YTAB(1)=1 WRITE "</TR>"
      if (mOp.Equal(YTAB.var(1).get(),1)) {
        m$.Cmd.Write("</TR>");
      }
      //<< . WRITE YCR,"</TABLE>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< SHOW    ;SHOW SEARCH RESULT
  public void SHOW() {
    //<< ;NEW YMAX,YSUCH,YSUCH1,YSUCHV,YFELDER,YLFN
    //<< NEW YFORM1
    mVar YFORM1 = m$.var("YFORM1");
    m$.newVar(YFORM1);
    //<< 
    //<< SET YFORM =$GET(YFORM)
    mVar YFORM = m$.var("YFORM");
    YFORM.set(m$.Fnc.$get(m$.var("YFORM")));
    //<< SET YDATEI=$GET(YKEY)
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.Fnc.$get(m$.var("YKEY")));
    //<< SET YFORM1=YFORM
    YFORM1.set(YFORM.get());
    //<< DO ^WWWUP(0)
    m$.Cmd.Do("WWWUP.main",0);
    do {
      //<< DO
      //<< . NEW YKEY
      mVar YKEY = m$.var("YKEY");
      m$.newVarBlock(1,YKEY);
      //<< . SET YKEY=" "
      YKEY.set(" ");
      //<< . DO ^WWWBACK
      m$.Cmd.Do("WWWBACK.main");
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< IF YFORM="" QUIT
    if (mOp.Equal(YFORM.get(),"")) {
      return;
    }
    //<< 
    //<< ;YSUCH1="FORMULAR;DATEI;SORTKEY;VORGABEKEY|VORGABEDATEN;ANZEIGE KEY;ANZEIGEFELD;STD SORT;ANZEIGE ERGEBNIS;ORIENTIERUNG;ANZAHL ANZEIGEN;FIXKEY;FELDER MIT SUMMENBILDUNG;WELCHEN KEY UEBERGEBEN;
    //<< SET YSUCH=""
    mVar YSUCH = m$.var("YSUCH");
    YSUCH.set("");
    //<< SET YSUCH1=""
    mVar YSUCH1 = m$.var("YSUCH1");
    YSUCH1.set("");
    //<< SET YSUCHV=""
    mVar YSUCHV = m$.var("YSUCHV");
    YSUCHV.set("");
    //<< SET YSUCH=$ORDER(^WWW123(0,YFORM,""))
    YSUCH.set(m$.Fnc.$order(m$.var("^WWW123",0,YFORM.get(),"")));
    //<< IF YSUCH'="" IF $PIECE($GET(^WWW123(0,YFORM,YSUCH,1)),Y,13)'=""  IF $ORDER(^WWW123(0,YFORM,YSUCH))'="" SET YSUCH=$ORDER(^WWW123(0,YFORM,YSUCH))
    if (mOp.NotEqual(YSUCH.get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW123",0,YFORM.get(),YSUCH.get(),1)),m$.var("Y").get(),13),"")) {
        if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW123",0,YFORM.get(),YSUCH.get())),"")) {
          YSUCH.set(m$.Fnc.$order(m$.var("^WWW123",0,YFORM.get(),YSUCH.get())));
        }
      }
    }
    //<< IF YSUCH'="" IF $PIECE($GET(^WWW123(0,YFORM,YSUCH,1)),Y,13)'=""  IF $ORDER(^WWW123(0,YFORM,YSUCH))'="" SET YSUCH=$ORDER(^WWW123(0,YFORM,YSUCH))
    if (mOp.NotEqual(YSUCH.get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW123",0,YFORM.get(),YSUCH.get(),1)),m$.var("Y").get(),13),"")) {
        if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW123",0,YFORM.get(),YSUCH.get())),"")) {
          YSUCH.set(m$.Fnc.$order(m$.var("^WWW123",0,YFORM.get(),YSUCH.get())));
        }
      }
    }
    //<< IF YSUCH'="" SET YSUCHV=$GET(^WWW123(0,YFORM,YSUCH,1))
    if (mOp.NotEqual(YSUCH.get(),"")) {
      YSUCHV.set(m$.Fnc.$get(m$.var("^WWW123",0,YFORM.get(),YSUCH.get(),1)));
    }
    //<< IF $PIECE(YSUCHV,Y,2)'="" SET YDATEI=$PIECE(YSUCHV,Y,2)
    if (mOp.NotEqual(m$.Fnc.$piece(YSUCHV.get(),m$.var("Y").get(),2),"")) {
      YDATEI.set(m$.Fnc.$piece(YSUCHV.get(),m$.var("Y").get(),2));
    }
    //<< IF YSUCH="" IF $DATA(^WWW123(0,YDATEI)) DO  ;SUCHVORGABE AUS KLASSE ;out of groovy
    if (mOp.Equal(YSUCH.get(),"")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW123",0,YDATEI.get())))) {
        //<< . SET YSUCH=$ORDER(^WWW123(0,YDATEI,""))
        YSUCH.set(m$.Fnc.$order(m$.var("^WWW123",0,YDATEI.get(),"")));
        //<< . IF YSUCH'="" SET YSUCHV=$GET(^WWW123(0,YDATEI,YSUCH,1))
        if (mOp.NotEqual(YSUCH.get(),"")) {
          YSUCHV.set(m$.Fnc.$get(m$.var("^WWW123",0,YDATEI.get(),YSUCH.get(),1)));
        }
      }
    }
    //<< 
    //<< IF YDATEI'="" IF $DATA(^WWW120(0,YDATEI)) SET YFORM1=YDATEI
    if (mOp.NotEqual(YDATEI.get(),"")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW120",0,YDATEI.get())))) {
        YFORM1.set(YDATEI.get());
      }
    }
    //<< IF YDATEI="" SET YDATEI=YFORM
    if (mOp.Equal(YDATEI.get(),"")) {
      YDATEI.set(YFORM.get());
    }
    do {
      //<< DO
      //<< . NEW ANZAB,ANZAHL
      mVar ANZAB = m$.var("ANZAB");
      mVar ANZAHL = m$.var("ANZAHL");
      m$.newVarBlock(1,ANZAB,ANZAHL);
      //<< . SET ANZAB=1
      ANZAB.set(1);
      //<< . SET ANZAHL=100
      ANZAHL.set(100);
      //<< . SET $PIECE(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","YANZAB",1),Y,1)=ANZAB
      m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V","YANZAB",1),m$.var("Y").get(),1).set(ANZAB.get());
      //<< . SET $PIECE(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","YANZAHL",1),Y,1)=ANZAHL
      m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V","YANZAHL",1),m$.var("Y").get(),1).set(ANZAHL.get());
      //<< . KILL ^WWWSOR(YUSER,"KEY")  ;KILL VORAUSWAHL
      m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY").kill();
      //<< . ;DO BITSEARCH^WWWSEARBIT2(YDATEI)
      //<< . DO BITSEARCH^WWWSEARBIT2(YDATEI,,1)  ;EXPAND SEARCH
      m$.Cmd.Do("WWWSEARBIT2.BITSEARCH",YDATEI.get(),null,1);
      //<< . SET YMAX=$PIECE($GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"V","YRESULT",1)),Y,1)
      mVar YMAX = m$.var("YMAX");
      YMAX.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V","YRESULT",1)),m$.var("Y").get(),1));
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< SET YFELDER=$TRANSLATE($PIECE(YSUCHV,Y,6),";",",")
    mVar YFELDER = m$.var("YFELDER");
    YFELDER.set(m$.Fnc.$translate(m$.Fnc.$piece(YSUCHV.get(),m$.var("Y").get(),6),";",","));
    //<< SET YFELDER1=$TRANSLATE($PIECE(YSUCHV,Y,16),";",",")
    mVar YFELDER1 = m$.var("YFELDER1");
    YFELDER1.set(m$.Fnc.$translate(m$.Fnc.$piece(YSUCHV.get(),m$.var("Y").get(),16),";",","));
    //<< SET YLFN=""
    mVar YLFN = m$.var("YLFN");
    YLFN.set("");
    //<< FOR  SET YLFN=$ORDER(^WWW001B(0,YDATEI,YLFN),-1) QUIT:YLFN=""  DO  ;BITFELDER ERG腘ZEN    ;07.06.04;FAN;ZENTRALE DATEI;25866
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW001B",0,YDATEI.get(),YLFN.get()),mOp.Negative(1)));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      //<< . IF '$FIND(","_YFELDER_",",","_YLFN_",") SET YFELDER=YFELDER_","_YLFN SET YFELDER1=YFELDER1_","_YLFN
      if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YFELDER.get()),","),mOp.Concat(mOp.Concat(",",YLFN.get()),",")))) {
        YFELDER.set(mOp.Concat(mOp.Concat(YFELDER.get(),","),YLFN.get()));
        YFELDER1.set(mOp.Concat(mOp.Concat(YFELDER1.get(),","),YLFN.get()));
      }
    }
    //<< 
    //<< IF $EXTRACT(YFELDER)=","  SET YFELDER  = $EXTRACT(YFELDER,2,999)
    if (mOp.Equal(m$.Fnc.$extract(YFELDER.get()),",")) {
      YFELDER.set(m$.Fnc.$extract(YFELDER.get(),2,999));
    }
    //<< IF $EXTRACT(YFELDER1)="," SET YFELDER1 = $EXTRACT(YFELDER1,2,999)
    if (mOp.Equal(m$.Fnc.$extract(YFELDER1.get()),",")) {
      YFELDER1.set(m$.Fnc.$extract(YFELDER1.get(),2,999));
    }
    //<< SET $PIECE(YSUCH1,Y,1)=YFORM1      ;FORMULAR ;form
    m$.pieceVar(YSUCH1,m$.var("Y").get(),1).set(YFORM1.get());
    //<< SET $PIECE(YSUCH1,Y,2)=YDATEI      ;DATEI ;data file
    m$.pieceVar(YSUCH1,m$.var("Y").get(),2).set(YDATEI.get());
    //<< SET $PIECE(YSUCH1,Y,3)=""          ;SORTKEY
    m$.pieceVar(YSUCH1,m$.var("Y").get(),3).set("");
    //<< SET $PIECE(YSUCH1,Y,4)=""          ;VORGABEKEY|VORGABEDATEN
    m$.pieceVar(YSUCH1,m$.var("Y").get(),4).set("");
    //<< SET $PIECE(YSUCH1,Y,5)=$TRANSLATE($PIECE(YSUCHV,Y,5),";",",")       ;ANZEIGE KEY
    m$.pieceVar(YSUCH1,m$.var("Y").get(),5).set(m$.Fnc.$translate(m$.Fnc.$piece(YSUCHV.get(),m$.var("Y").get(),5),";",","));
    //<< IF $PIECE(YSUCH1,Y,5)="" DO
    if (mOp.Equal(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),5),"")) {
      //<< . NEW YI,YMAXKEY
      mVar YI = m$.var("YI");
      mVar YMAXKEY = m$.var("YMAXKEY");
      m$.newVarBlock(1,YI,YMAXKEY);
      //<< . SET YMAXKEY=$ORDER(^WWW002(0,YDATEI,""),-1)
      YMAXKEY.set(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1)));
      //<< . FOR YI=1:1:YMAXKEY SET $PIECE(YSUCH1,Y,5)=$PIECE(YSUCH1,Y,5)_","_YI       ;ANZEIGE KEY ;Show KEY
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
        m$.pieceVar(YSUCH1,m$.var("Y").get(),5).set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),5),","),YI.get()));
      }
      //<< . IF $EXTRACT($PIECE(YSUCH1,Y,5))="," SET $PIECE(YSUCH1,Y,5)=$EXTRACT($PIECE(YSUCH1,Y,5),2,999)
      if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),5)),",")) {
        m$.pieceVar(YSUCH1,m$.var("Y").get(),5).set(m$.Fnc.$extract(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),5),2,999));
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< SET $PIECE(YSUCH1,Y,6)=YFELDER     ;ANZEIGEFELD
    m$.pieceVar(YSUCH1,m$.var("Y").get(),6).set(YFELDER.get());
    //<< SET $PIECE(YSUCH1,Y,7)=""          ;STD SORT
    m$.pieceVar(YSUCH1,m$.var("Y").get(),7).set("");
    //<< SET $PIECE(YSUCH1,Y,8)=$TRANSLATE($PIECE(YSUCHV,Y,8),";",",")      ;ANZEIGEERGEBNIS
    m$.pieceVar(YSUCH1,m$.var("Y").get(),8).set(m$.Fnc.$translate(m$.Fnc.$piece(YSUCHV.get(),m$.var("Y").get(),8),";",","));
    //<< SET $PIECE(YSUCH1,Y,9)=1           ;ORIENTIERUNG
    m$.pieceVar(YSUCH1,m$.var("Y").get(),9).set(1);
    //<< SET $PIECE(YSUCH1,Y,10)=100        ;ANZAHL MAX. 100 ;Number
    m$.pieceVar(YSUCH1,m$.var("Y").get(),10).set(100);
    //<< SET $PIECE(YSUCH1,Y,11)=""         ;FIXKEY
    m$.pieceVar(YSUCH1,m$.var("Y").get(),11).set("");
    //<< SET $PIECE(YSUCH1,Y,11)=$TRANSLATE($PIECE(YSUCHV,Y,12),";",",")    ;FELDER MIT SUMMENBILDUNG
    m$.pieceVar(YSUCH1,m$.var("Y").get(),11).set(m$.Fnc.$translate(m$.Fnc.$piece(YSUCHV.get(),m$.var("Y").get(),12),";",","));
    //<< SET $PIECE(YSUCH1,Y,12)=$TRANSLATE($PIECE(YSUCHV,Y,13),";",",")    ;WELCHEN KEY 蹷ERGEBEN
    m$.pieceVar(YSUCH1,m$.var("Y").get(),12).set(m$.Fnc.$translate(m$.Fnc.$piece(YSUCHV.get(),m$.var("Y").get(),13),";",","));
    //<< SET $PIECE(YSUCH1,Y,16)=YFELDER1   ;REIHENFOLGE DATENFELDER ;row
    m$.pieceVar(YSUCH1,m$.var("Y").get(),16).set(YFELDER1.get());
    //<< SET $PIECE(YSUCH1,Y,17)=""         ;FIXVORGABE SORTKEY
    m$.pieceVar(YSUCH1,m$.var("Y").get(),17).set("");
    //<< SET $PIECE(YSUCH1,Y,20)="::"_$$^WWWTEXT(33529)                     ;SUCHERGEBNIS
    m$.pieceVar(YSUCH1,m$.var("Y").get(),20).set(mOp.Concat("::",m$.fnc$("WWWTEXT.main",33529)));
    //<< IF YMAX>0 SET $PIECE(YSUCH1,Y,20)=$PIECE(YSUCH1,Y,20)_" ("_YMAX_")"
    if (mOp.Greater(m$.var("YMAX").get(),0)) {
      m$.pieceVar(YSUCH1,m$.var("Y").get(),20).set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),20)," ("),m$.var("YMAX").get()),")"));
    }
    //<< IF YMAX>100 SET $PIECE(YSUCH1,Y,20)=$PIECE(YSUCH1,Y,20)_"&nbsp;&nbsp;<FONT COLOR="_YRED_">"_$$^WWWTEXT(33847)_"</FONT>"
    if (mOp.Greater(m$.var("YMAX").get(),100)) {
      m$.pieceVar(YSUCH1,m$.var("Y").get(),20).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),20),"&nbsp;&nbsp;<FONT COLOR="),m$.var("YRED").get()),">"),m$.fnc$("WWWTEXT.main",33847)),"</FONT>"));
    }
    //<< SET YNOSORT=1
    mVar YNOSORT = m$.var("YNOSORT");
    YNOSORT.set(1);
    do {
      //<< DO
      //<< . NEW YFORM
      m$.newVarBlock(1,YFORM);
      //<< . SET YFORM=YFORM1
      YFORM.set(YFORM1.get());
      //<< . DO ^WWWSEAR3
      m$.Cmd.Do("WWWSEAR3.main");
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< DO ^WWWUP(1)
    m$.Cmd.Do("WWWUP.main",1);
    //<< QUIT
    return;
  }

//<< 
//<< 
}
