//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWGEDT
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:09
//*****************************************************************************

import mLibrary.*;


//<< WWWGEDT
public class WWWGEDT extends mClass {

  public void main() {
    _WWWGEDT();
  }

  public void _WWWGEDT() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       GLOBAL ANZEIGE
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
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 23.04.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< do START
    m$.Cmd.Do("START");
    //<< quit
    return;
  }

  //<< 
  //<< START ;
  public void START() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Feb-2008   GRF     Doco; quits; Naked References
    //<< ; 05-Nov-2007   shobby  SRBR014748: Standard routine for password check.
    //<< ;-------------------------------------------------------------------------------
    //<< DO ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< SET YDATEI=$GET(%(YQUERY,"YDATEI"))
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YDATEI")));
    //<< NEW YANZMAX
    mVar YANZMAX = m$.var("YANZMAX");
    m$.newVar(YANZMAX);
    //<< 
    //<< SET YANZMAX=$PIECE($GET(^WWW012(0,YM,1)),Y,160)  ; MAX NUMBER OF DATA RECORDS IN THE SELECT FIELD
    YANZMAX.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),160));
    //<< IF +YANZMAX=0 SET YANZMAX=1000
    if (mOp.Equal(mOp.Positive(YANZMAX.get()),0)) {
      YANZMAX.set(1000);
    }
    //<< KILL ^WWWZWS(0,+$HOROLOG,YUSER)
    m$.var("^WWWZWS",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get()).kill();
    //<< IF '$DATA(^WWW013(0,YBED)) DO ^WWWINFO($$^WWWTEXT(5)) QUIT
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW013",0,m$.var("YBED").get())))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< 
    //<< ;IF $$^WWWUPER($$^WWWPWDCHECK($PIECE(^WWW013(0,YBED,1),Y,2)))'=$$^WWWUPER(YPWD) DO ^WWWINFO($$^WWWTEXT(5)) QUIT  ;TYBD;26124;20,7,2004;
    //<< ;BR014748 IF $zconvert($$^WWWPWDCHECK($PIECE(^WWW013(0,YBED,1),Y,2)),"U")'=$zconvert(YPWD,"U") DO ^WWWINFO($$^WWWTEXT(5)) QUIT  ;TYBD;26124;20,7,2004;
    //<< IF '$$CHECK^WWWPWDCHECK($PIECE(^WWW013(0,YBED,1),Y,2),YPWD) DO ^WWWINFO($$^WWWTEXT(5)) QUIT  ;TYBD;26124;20,7,2004; ;BR014748
    if (mOp.Not(m$.fnc$("WWWPWDCHECK.CHECK",m$.Fnc.$piece(m$.var("^WWW013",0,m$.var("YBED").get(),1).get(),m$.var("Y").get(),2),m$.var("YPWD").get()))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< 
    //<< ;WRITE YCR,YCR,"<!-- ************************* GLOBAL ANZEIGE (WWWGEDT)************************* -->",YCR,YCR
    //<< 
    //<< DO ^WWWFORMX  ;VORGABEN FORM U. MANDANT ;shape Company
    m$.Cmd.Do("WWWFORMX.main");
    //<< SET YFDATEI=$PIECE(YVOR,Y,11)
    mVar YFDATEI = m$.var("YFDATEI");
    YFDATEI.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11));
    //<< IF YFDATEI'="" SET YDATEI=YFDATEI
    if (mOp.NotEqual(YFDATEI.get(),"")) {
      YDATEI.set(YFDATEI.get());
    }
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< WRITE "<FONT"
    m$.Cmd.Write("<FONT");
    //<< IF $PIECE(YVOR,Y,9)'="" WRITE " FACE="_""""_$PIECE($GET(^WWW100(0,"SCHRIFTART",SPRACHE,$PIECE(YVOR,Y,9),1)),Y,1)_""""
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),9),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" FACE=","\""),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),9),1)),m$.var("Y").get(),1)),"\""));
    }
    //<< IF $PIECE(YVOR,Y,7)'="" WRITE " SIZE="_""""_$PIECE(YVOR,Y,7)_""""
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" SIZE=","\""),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\""));
    }
    //<< IF $PIECE(YVOR,Y,6)'=""  DO
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),6),"")) {
      //<< . IF $LENGTH($PIECE(YVOR,Y,6))=6  WRITE " COLOR="_""""_"#"_$PIECE(YVOR,Y,6)_""""
      if (mOp.Equal(m$.Fnc.$length(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),6)),6)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" COLOR=","\""),"#"),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),6)),"\""));
      }
      //<< . IF $LENGTH($PIECE(YVOR,Y,6))'=6 WRITE " COLOR="_""""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR,Y,6),1)),Y,1)_""""
      if (mOp.NotEqual(m$.Fnc.$length(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),6)),6)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" COLOR=","\""),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),6),1)),m$.var("Y").get(),1)),"\""));
      }
    }
    //<< 
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< IF $FIND($PIECE(YVOR,Y,8),1) WRITE "<STRONG><B>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),1))) {
      m$.Cmd.Write("<STRONG><B>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),2) WRITE "<U>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),2))) {
      m$.Cmd.Write("<U>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),3) WRITE "<I>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),3))) {
      m$.Cmd.Write("<I>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),4) WRITE "<STRIKE>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),4))) {
      m$.Cmd.Write("<STRIKE>");
    }
    //<< IF $GET(YTARGET)="" DO   ;WENN KEIN TARGET,DANN ENDE BUTTON
    if (mOp.Equal(m$.Fnc.$get(m$.var("YTARGET")),"")) {
      //<< . WRITE YCR,"<DIR>"
      m$.Cmd.Write(m$.var("YCR").get(),"<DIR>");
      //<< . WRITE "<LI>"
      m$.Cmd.Write("<LI>");
      //<< . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
      //<< . WRITE "&YBED="_YBED_"&YUCI="_$GET(YUCI)_"&YM="_YM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&YBED=",m$.var("YBED").get()),"&YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&YM="),m$.var("YM").get()));
      //<< . WRITE "&YUSER="_YUSER
      m$.Cmd.Write(mOp.Concat("&YUSER=",m$.var("YUSER").get()));
      //<< . WRITE "&YANZ="_YANZ
      m$.Cmd.Write(mOp.Concat("&YANZ=",m$.var("YANZ").get()));
      //<< . WRITE """"
      m$.Cmd.Write("\"");
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" valign=middle vspace=0 hspace=0 border=0>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," valign=middle vspace=0 hspace=0 border=0>"));
      //<< . WRITE $$^WWWTEXT(99)
      m$.Cmd.Write(m$.fnc$("WWWTEXT.main",99));
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< 
    //<< IF YFDATEI="" DO  ;KEINE DATEIVORGABE=DATEIAUSWAHL ;no
    if (mOp.Equal(YFDATEI.get(),"")) {
      //<< . WRITE YCR,"<DIR>"
      m$.Cmd.Write(m$.var("YCR").get(),"<DIR>");
      //<< . WRITE "<LI>"
      m$.Cmd.Write("<LI>");
      //<< . WRITE "<A HREF="_""""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()));
      //<< . WRITE "&amp;YBED="_YBED_"&amp;YUCI="_$GET(YUCI)
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YBED=",m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))));
      //<< . WRITE "&amp;YUSER="_YUSER
      m$.Cmd.Write(mOp.Concat("&amp;YUSER=",m$.var("YUSER").get()));
      //<< . WRITE "&amp;YANZ="_YANZ
      m$.Cmd.Write(mOp.Concat("&amp;YANZ=",m$.var("YANZ").get()));
      //<< . WRITE """"
      m$.Cmd.Write("\"");
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_""""_$$^WWWTEXT(374)_""""_" valign=middle vspace=0 hspace=0 border=0>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),"\""),m$.fnc$("WWWTEXT.main",374)),"\"")," valign=middle vspace=0 hspace=0 border=0>"));
      //<< . WRITE $$^WWWTEXT(87)
      m$.Cmd.Write(m$.fnc$("WWWTEXT.main",87));
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< 
    //<< DO DATEI   ;AUSWAHL DATEI UND DATENSATZ ;Selection data file And data record
    m$.Cmd.Do("DATEI");
    //<< IF YFDATEI="" DO
    if (mOp.Equal(YFDATEI.get(),"")) {
      //<< . WRITE YCR,"</DIR>"
      m$.Cmd.Write(m$.var("YCR").get(),"</DIR>");
    }
    //<< 
    //<< IF $GET(YTARGET)="" WRITE "</DIR>"
    if (mOp.Equal(m$.Fnc.$get(m$.var("YTARGET")),"")) {
      m$.Cmd.Write("</DIR>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),1) WRITE "</STRONG></B>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),1))) {
      m$.Cmd.Write("</STRONG></B>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),2) WRITE "</U>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),2))) {
      m$.Cmd.Write("</U>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),3) WRITE "</I>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),3))) {
      m$.Cmd.Write("</I>");
    }
    //<< IF $FIND($PIECE(YVOR,Y,8),4) WRITE "</STRIKE>"
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),4))) {
      m$.Cmd.Write("</STRIKE>");
    }
    //<< WRITE "</FONT>",YCR
    m$.Cmd.Write("</FONT>",m$.var("YCR").get());
    //<< ;D ^WWWSTOP
    //<< QUIT
    return;
  }

  //<< 
  //<< DATEI ;ANZEIGEN ALLE DATEIEN AUS WWW001 ;display out of
  public void DATEI() {
    //<< WRITE YCR,"<DIR>"
    m$.Cmd.Write(m$.var("YCR").get(),"<DIR>");
    //<< IF YDATEI=""  SET YGLOB="" FOR  SET YGLOB=$ORDER(^WWW001(0,YGLOB)) QUIT:YGLOB=""  DO DATEI1
    if (mOp.Equal(m$.var("YDATEI").get(),"")) {
      mVar YGLOB = m$.var("YGLOB");
      YGLOB.set("");
      for (;true;) {
        YGLOB.set(m$.Fnc.$order(m$.var("^WWW001",0,YGLOB.get())));
        if (mOp.Equal(YGLOB.get(),"")) {
          break;
        }
        m$.Cmd.Do("DATEI1");
      }
    }
    //<< IF YDATEI'="" SET YGLOB=YDATEI DO DATEI1
    if (mOp.NotEqual(m$.var("YDATEI").get(),"")) {
      mVar YGLOB = m$.var("YGLOB");
      YGLOB.set(m$.var("YDATEI").get());
      m$.Cmd.Do("DATEI1");
    }
    //<< WRITE "</DIR>",YCR
    m$.Cmd.Write("</DIR>",m$.var("YCR").get());
    //<< QUIT
    return;
  }

  //<< 
  //<< DATEI1 ;DATEIAUSWAHL
  public void DATEI1() {
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    do {
      //<< DO
      //<< . SET SATZ=$GET(^WWW001(0,YGLOB,1))
      mVar SATZ = m$.var("SATZ");
      SATZ.set(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YGLOB").get(),1)));
      //<< . WRITE "<LI>"
      m$.Cmd.Write("<LI>");
      //<< . WRITE "<A HREF="_""""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()));
      //<< . WRITE "&amp;YBED="_YBED_"&amp;YUCI="_$GET(YUCI)
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YBED=",m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))));
      //<< . WRITE "&amp;YUSER="_YUSER
      m$.Cmd.Write(mOp.Concat("&amp;YUSER=",m$.var("YUSER").get()));
      //<< . WRITE "&amp;YDATEI="_YGLOB
      m$.Cmd.Write(mOp.Concat("&amp;YDATEI=",m$.var("YGLOB").get()));
      //<< . WRITE "&amp;YANZ="_YANZ
      m$.Cmd.Write(mOp.Concat("&amp;YANZ=",m$.var("YANZ").get()));
      //<< . WRITE """"
      m$.Cmd.Write("\"");
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . IF YDATEI=""  WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_""""_$$^WWWTEXT(374)_""""_" valign=middle vspace=0 hspace=0 border=0>"
      if (mOp.Equal(m$.var("YDATEI").get(),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),"\""),m$.fnc$("WWWTEXT.main",374)),"\"")," valign=middle vspace=0 hspace=0 border=0>"));
      }
      //<< . IF YDATEI'="" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_""""_$$^WWWTEXT(374)_""""_" valign=middle vspace=0 hspace=0 border=0>"
      if (mOp.NotEqual(m$.var("YDATEI").get(),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),"\""),m$.fnc$("WWWTEXT.main",374)),"\"")," valign=middle vspace=0 hspace=0 border=0>"));
      }
      //<< . IF $DATA(^WWW0011(0,YGLOB,SPRACHE,1)) SET $PIECE(SATZ,Y,1)=$PIECE(^WWW0011(0,YGLOB,SPRACHE,1),Y,1)    ; Naked Ref
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0011",0,m$.var("YGLOB").get(),m$.var("SPRACHE").get(),1)))) {
        m$.pieceVar(SATZ,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.var("^WWW0011",0,m$.var("YGLOB").get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
      }
      //<< . WRITE YGLOB,"   (",$$^WWWUML($PIECE(SATZ,Y,1))_")"
      m$.Cmd.Write(m$.var("YGLOB").get(),"   (",mOp.Concat(m$.fnc$("WWWUML.main",m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),1)),")"));
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
      //<< . IF YDATEI=YGLOB DO KEY  ;ANZEIGEN KEY´S AUS DATEI ;display out of data file
      if (mOp.Equal(m$.var("YDATEI").get(),m$.var("YGLOB").get())) {
        m$.Cmd.Do("KEY");
      }
    } while(false);
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< KEY ;KEY WENN NUR EINE DATEI ;KEY when only one data file
  public void KEY() {
    //<< SET YMAXKEY=+$ORDER(^WWW002(0,YDATEI,""),-1)   ;WIEVIELE PRIMÄRSCHLÜSSEL
    mVar YMAXKEY = m$.var("YMAXKEY");
    YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),""),mOp.Negative(1))));
    //<< IF YMAXKEY=0 SET YMAXKEY=1
    if (mOp.Equal(YMAXKEY.get(),0)) {
      YMAXKEY.set(1);
    }
    //<< DO ^WWWSOR(YDATEI,YFKEY,"",0,0,$GET(YANZMAX),1,"")   ;SUCHEN PRIMÄRSCHLÜSSEL ;seek
    m$.Cmd.Do("WWWSOR.main",m$.var("YDATEI").get(),m$.var("YFKEY").get(),"",0,0,m$.Fnc.$get(m$.var("YANZMAX")),1,"");
    //<< FOR YLFNLAN=1:1 QUIT:$PIECE(YFKEY,",",YLFNLAN)=""
    mVar YLFNLAN = m$.var("YLFNLAN");
    for (YLFNLAN.set(1);(true);YLFNLAN.set(mOp.Add(YLFNLAN.get(),1))) {
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YFKEY").get(),",",YLFNLAN.get()),"")) {
        break;
      }
    }
    //<< IF YLFNLAN>YMAXKEY SET YLFNLAN=YMAXKEY
    if (mOp.Greater(YLFNLAN.get(),YMAXKEY.get())) {
      YLFNLAN.set(YMAXKEY.get());
    }
    //<< FOR YLFN=1:1:YLFNLAN DO KEY1
    mVar YLFN = m$.var("YLFN");
    for (YLFN.set(1);(mOp.LessOrEqual(YLFN.get(),YLFNLAN.get()));YLFN.set(mOp.Add(YLFN.get(),1))) {
      m$.Cmd.Do("KEY1");
    }
    //<< KILL ^WWWSOR(YUSER)
    m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< FOR YLFN=1:1:YLFNLAN WRITE "</DIR>"
    for (YLFN.set(1);(mOp.LessOrEqual(YLFN.get(),YLFNLAN.get()));YLFN.set(mOp.Add(YLFN.get(),1))) {
      m$.Cmd.Write("</DIR>");
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< KEY1 ;ANZEIGE EINZELKEY ;Show
  public void KEY1() {
    //<< SET YVORKEY=""
    mVar YVORKEY = m$.var("YVORKEY");
    YVORKEY.set("");
    //<< WRITE YCR,"<DIR>"
    m$.Cmd.Write(m$.var("YCR").get(),"<DIR>");
    //<< WRITE YCR,"<STRONG>"
    m$.Cmd.Write(m$.var("YCR").get(),"<STRONG>");
    //<< SET NAME=$PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,1)
    mVar NAME = m$.var("NAME");
    NAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),1));
    //<< IF $DATA(^WWW0021(0,YDATEI,YLFN,SPRACHE,1)) SET NAME=$PIECE(^WWW0021(0,YDATEI,YLFN,SPRACHE,1),Y,1)    ; Naked Ref
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0021",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),m$.var("SPRACHE").get(),1)))) {
      NAME.set(m$.Fnc.$piece(m$.var("^WWW0021",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
    }
    //<< WRITE $$^WWWUML(NAME)
    m$.Cmd.Write(m$.fnc$("WWWUML.main",NAME.get()));
    //<< WRITE "</STRONG>"
    m$.Cmd.Write("</STRONG>");
    //<< WRITE "<BR>"
    m$.Cmd.Write("<BR>");
    //<< SET YA(2)=""
    mVar YA = m$.var("YA");
    YA.var(2).set("");
    //<< FOR  SET YA(2)=$ORDER(^WWWSOR(YUSER,"KEY",YA(2))) QUIT:YA(2)=""  DO
    for (;true;) {
      YA.var(2).set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YA.var(2).get())));
      if (mOp.Equal(YA.var(2).get(),"")) {
        break;
      }
      //<< . SET YKEY=""
      mVar YKEY = m$.var("YKEY");
      YKEY.set("");
      //<< . FOR  SET YKEY=$ORDER(^WWWSOR(YUSER,"KEY",YA(2),YKEY)) QUIT:YKEY=""  DO
      for (;true;) {
        YKEY.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YA.var(2).get(),YKEY.get())));
        if (mOp.Equal(YKEY.get(),"")) {
          break;
        }
        do {
          //<< . . WRITE YCR
          m$.Cmd.Write(m$.var("YCR").get());
          //<< . . SET YA=$GET(^WWWSOR(YUSER,"KEY",YA(2),YKEY))
          YA.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YA.var(2).get(),YKEY.get())));
          //<< . . IF YLFN'=YMAXKEY QUIT:YVORKEY=$PIECE(YKEY,",",1,YLFN)  SET YVORKEY=$PIECE(YKEY,",",1,YLFN)
          if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YMAXKEY").get())) {
            if (mOp.Equal(YVORKEY.get(),m$.Fnc.$piece(YKEY.get(),",",1,m$.var("YLFN").get()))) {
              break;
            }
            YVORKEY.set(m$.Fnc.$piece(YKEY.get(),",",1,m$.var("YLFN").get()));
          }
          //<< . . WRITE YCR,"<LI>"
          m$.Cmd.Write(m$.var("YCR").get(),"<LI>");
          //<< . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()));
          //<< . . WRITE "&amp;YBED="_YBED_"&amp;YUCI="_$GET(YUCI)
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YBED=",m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))));
          //<< . . WRITE "&amp;YUSER="_YUSER
          m$.Cmd.Write(mOp.Concat("&amp;YUSER=",m$.var("YUSER").get()));
          //<< . . WRITE "&amp;YDATEI="_YGLOB
          m$.Cmd.Write(mOp.Concat("&amp;YDATEI=",m$.var("YGLOB").get()));
          //<< . . WRITE "&amp;YANZ="_YANZ
          m$.Cmd.Write(mOp.Concat("&amp;YANZ=",m$.var("YANZ").get()));
          //<< . . IF YLFN'=YMAXKEY WRITE "&amp;YFKEY="_$PIECE(YKEY,",",1,YLFN)
          if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YMAXKEY").get())) {
            m$.Cmd.Write(mOp.Concat("&amp;YFKEY=",m$.Fnc.$piece(YKEY.get(),",",1,m$.var("YLFN").get())));
          }
          //<< . . IF YLFN=YMAXKEY  WRITE "&amp;YFKEY="_YKEY_"&amp;YKEY="_YKEY
          if (mOp.Equal(m$.var("YLFN").get(),m$.var("YMAXKEY").get())) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YFKEY=",YKEY.get()),"&amp;YKEY="),YKEY.get()));
          }
          //<< . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . WRITE ">"
          m$.Cmd.Write(">");
          //<< . . DO
          do {
            //<< . . . IF YLFN'=YMAXKEY IF YLFN=YLFNLAN WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_""""_$$^WWWTEXT(374)_""""_" valign=middle vspace=0 hspace=0 border=0>" QUIT
            if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YMAXKEY").get())) {
              if (mOp.Equal(m$.var("YLFN").get(),m$.var("YLFNLAN").get())) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),"\""),m$.fnc$("WWWTEXT.main",374)),"\"")," valign=middle vspace=0 hspace=0 border=0>"));
                break;
              }
            }
            //<< . . . IF YLFN'=YLFNLAN WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_""""_$$^WWWTEXT(374)_""""_" valign=middle vspace=0 hspace=0 border=0>" QUIT
            if (mOp.NotEqual(m$.var("YLFN").get(),m$.var("YLFNLAN").get())) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),"\""),m$.fnc$("WWWTEXT.main",374)),"\"")," valign=middle vspace=0 hspace=0 border=0>"));
              break;
            }
            //<< . . . IF YLFN=YMAXKEY IF YFKEY=YKEY WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_""""_$$^WWWTEXT(374)_""""_" valign=middle vspace=0 hspace=0 border=0>" QUIT
            if (mOp.Equal(m$.var("YLFN").get(),m$.var("YMAXKEY").get())) {
              if (mOp.Equal(m$.var("YFKEY").get(),YKEY.get())) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),"\""),m$.fnc$("WWWTEXT.main",374)),"\"")," valign=middle vspace=0 hspace=0 border=0>"));
                break;
              }
            }
            //<< . . . WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_""""_$$^WWWTEXT(374)_""""_" valign=middle vspace=0 hspace=0 border=0>" QUIT
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),"\""),m$.fnc$("WWWTEXT.main",374)),"\"")," valign=middle vspace=0 hspace=0 border=0>"));
            break;
          } while(false);
          //<< . . ;
          //<< . . SET YINHALT=$PIECE(YKEY,",",YLFN)
          mVar YINHALT = m$.var("YINHALT");
          YINHALT.set(m$.Fnc.$piece(YKEY.get(),",",m$.var("YLFN").get()));
          //<< . . DO KEYLFN
          m$.Cmd.Do("KEYLFN");
          //<< . . WRITE $$^WWWUML(YINHALT)
          m$.Cmd.Write(m$.fnc$("WWWUML.main",YINHALT.get()));
          //<< . . IF YINHALT1'="" WRITE "  (",$$^WWWUML(YINHALT1),")"
          if (mOp.NotEqual(m$.var("YINHALT1").get(),"")) {
            m$.Cmd.Write("  (",m$.fnc$("WWWUML.main",m$.var("YINHALT1").get()),")");
          }
          //<< . . WRITE "</A>"
          m$.Cmd.Write("</A>");
          //<< . . IF YLFN=YMAXKEY IF YFKEY=YKEY DO SATZ   ;DATENSATZ VORHANDEN ;data record on hand
          if (mOp.Equal(m$.var("YLFN").get(),m$.var("YMAXKEY").get())) {
            if (mOp.Equal(m$.var("YFKEY").get(),YKEY.get())) {
              m$.Cmd.Do("SATZ");
            }
          }
        } while (false);
      }
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< SATZ ;
  public void SATZ() {
    //<< SET YFELD=$$^WWWSETL(YA)   ;LESEN DATENSATZ ;read data record
    mVar YFELD = m$.var("YFELD");
    YFELD.set(m$.fnc$("WWWSETL.main",m$.var("YA").get()));
    //<< NEW YLFN
    mVar YLFN = m$.var("YLFN");
    m$.newVar(YLFN);
    //<< 
    //<< WRITE "<DIR>"
    m$.Cmd.Write("<DIR>");
    //<< SET YLFN=""
    YLFN.set("");
    //<< FOR  SET YLFN=$ORDER(^WWW003(0,YDATEI,YLFN)) QUIT:YLFN=""  DO   ;ANZEIGE DER DATENFELDER ;Show the
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      do {
        //<< . WRITE YCR,"<LI>"
        m$.Cmd.Write(m$.var("YCR").get(),"<LI>");
        //<< . SET YINHALT=$PIECE(YFELD,Y,YLFN)
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YLFN.get()));
        //<< . WRITE "<STRONG>"
        m$.Cmd.Write("<STRONG>");
        //<< . SET NAME=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,1)
        mVar NAME = m$.var("NAME");
        NAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),1));
        //<< . IF $DATA(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)) SET NAME=$PIECE(^WWW0031(0,YDATEI,YLFN,SPRACHE,1),Y,1)    ; Naked Ref
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
          NAME.set(m$.Fnc.$piece(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . WRITE $$^WWWUML(NAME)   ;BEZEICHNUNG DES EINZELFELDES ;notation
        m$.Cmd.Write(m$.fnc$("WWWUML.main",NAME.get()));
        //<< . WRITE ": "
        m$.Cmd.Write(": ");
        //<< . WRITE "</STRONG>"
        m$.Cmd.Write("</STRONG>");
        //<< . DO DATEN  ;DATENAUSGABE DES EINZELFELDES ;data output
        m$.Cmd.Do("DATEN");
        //<< . ;IF $$^WWWUPER($EXTRACT(YINHALT,1,7))="HTTP://"  DO  QUIT   ;VERTEILER AUF LINK ;distributor upon
        //<< . IF $zconvert($EXTRACT(YINHALT,1,7),"U")="HTTP://"  DO  QUIT   ;VERTEILER AUF LINK ;distributor upon
        if (mOp.Equal(m$.Fnc.$zconvert(m$.Fnc.$extract(YINHALT.get(),1,7),"U"),"HTTP://")) {
          //<< . . SET YINHALT=$PIECE(YINHALT,"YUSER=",1)_YUSER_$PIECE($PIECE(YINHALT,"YUSER=",2),"&",2,99)  ;AKTUELLER USER
          YINHALT.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YINHALT.get(),"YUSER=",1),m$.var("YUSER").get()),m$.Fnc.$piece(m$.Fnc.$piece(YINHALT.get(),"YUSER=",2),"&",2,99)));
          //<< . . WRITE "<A HREF="_""""_YINHALT_""""
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),YINHALT.get()),"\""));
          //<< . . WRITE ">"
          m$.Cmd.Write(">");
          //<< . . WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_""""_$$^WWWTEXT(374)_""""_" valign=middle vspace=0 hspace=0 border=0>"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),"\""),m$.fnc$("WWWTEXT.main",374)),"\"")," valign=middle vspace=0 hspace=0 border=0>"));
          //<< . . WRITE "</A>"
          m$.Cmd.Write("</A>");
          break;
        }
        //<< . ;
        //<< . WRITE $$^WWWUML(YINHALT)
        m$.Cmd.Write(m$.fnc$("WWWUML.main",YINHALT.get()));
        //<< . IF YINHALT1'="" WRITE "  (",$$^WWWUML(YINHALT1),")"   ;RELATIONSFELDER
        if (mOp.NotEqual(m$.var("YINHALT1").get(),"")) {
          m$.Cmd.Write("  (",m$.fnc$("WWWUML.main",m$.var("YINHALT1").get()),")");
        }
      } while (false);
    }
    //<< 
    //<< WRITE "</DIR>"
    m$.Cmd.Write("</DIR>");
    //<< QUIT
    return;
  }

  //<< 
  //<< KEYLFN ;FORMAT KEY
  public void KEYLFN() {
    //<< NEW YKEY,YMAXKEY
    mVar YKEY = m$.var("YKEY");
    mVar YMAXKEY = m$.var("YMAXKEY");
    m$.newVar(YKEY,YMAXKEY);
    //<< 
    //<< SET YINHALT1=""
    mVar YINHALT1 = m$.var("YINHALT1");
    YINHALT1.set("");
    //<< SET YTYP=$PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,3)
    mVar YTYP = m$.var("YTYP");
    YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),3));
    //<< SET YQ=0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< IF YINHALT'="" IF $PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,8)'="" DO  QUIT
    if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),8),"")) {
        do {
          //<< . NEW YDAT,YKE,YFE,YSAT,YDATA
          mVar YDAT = m$.var("YDAT");
          mVar YKE = m$.var("YKE");
          mVar YFE = m$.var("YFE");
          mVar YSAT = m$.var("YSAT");
          mVar YDATA = m$.var("YDATA");
          m$.newVar(YDAT,YKE,YFE,YSAT,YDATA);
          //<< . SET YDAT=$PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,8)
          YDAT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),8));
          //<< . SET YKE=$PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,9)
          YKE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),9));
          //<< . IF YKE'="" IF $EXTRACT(YKE)'="""" QUIT
          if (mOp.NotEqual(YKE.get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$extract(YKE.get()),"\"")) {
              break;
            }
          }
          //<< . SET YFE=$PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,10)
          YFE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),10));
          //<< . SET YSAT="^"_YDAT_"("_$$^WWWYM(YDAT,1)
          YSAT.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YDAT.get()),"("),m$.fnc$("WWWYM.main",YDAT.get(),1)));
          //<< . SET YDATA=$GET(^WWW001(0,YDAT,1))
          YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YDAT.get(),1)));
          //<< . IF YKE'="" IF $EXTRACT(YKE)'="," SET YSAT=YSAT_YKE_","
          if (mOp.NotEqual(YKE.get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$extract(YKE.get()),",")) {
              YSAT.set(mOp.Concat(mOp.Concat(YSAT.get(),YKE.get()),","));
            }
          }
          //<< . IF $PIECE(YDATA,Y,8)'=4 SET YSAT=YSAT_""""_$TRANSLATE(YINHALT,"""")_""""_",1)"
          if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
            YSAT.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YSAT.get(),"\""),m$.Fnc.$translate(m$.var("YINHALT").get(),"\"")),"\""),",1)"));
          }
          //<< . IF $PIECE(YDATA,Y,8)=4  SET YSAT=YSAT_""""_$TRANSLATE(YINHALT,"""")_""""_")"
          if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
            YSAT.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YSAT.get(),"\""),m$.Fnc.$translate(m$.var("YINHALT").get(),"\"")),"\""),")"));
          }
          //<< . IF $DATA(@(YSAT)) SET YINHALT1=$PIECE(@(YSAT),Y,YFE) SET YQ=1
          if (mOp.Logical(m$.Fnc.$data(m$.indirectVar((YSAT.get()))))) {
            YINHALT1.set(m$.Fnc.$piece(m$.indirectVar((YSAT.get())).get(),m$.var("Y").get(),YFE.get()));
            YQ.set(1);
          }
          //<< . SET YSAT(1)=$PIECE($$^WWWSETL(YSAT),Y,YFE)
          YSAT.var(1).set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YSAT.get()),m$.var("Y").get(),YFE.get()));
          //<< . IF YSAT(1)'="" SET YINHALT1=YSAT(1) SET YQ=1
          if (mOp.NotEqual(YSAT.var(1).get(),"")) {
            YINHALT1.set(YSAT.var(1).get());
            YQ.set(1);
          }
        } while (false);
        return;
      }
    }
    //<< 
    //<< IF YQ=0 DO FORMAT
    if (mOp.Equal(YQ.get(),0)) {
      m$.Cmd.Do("FORMAT");
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< DATEN ;FORMAT DATEN
  public void DATEN() {
    //<< SET YINHALT1=""
    mVar YINHALT1 = m$.var("YINHALT1");
    YINHALT1.set("");
    //<< SET YTYP=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)
    mVar YTYP = m$.var("YTYP");
    YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),3));
    //<< SET YQ=0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< IF YINHALT'="" IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,8)'="" DO  QUIT
    if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),8),"")) {
        do {
          //<< . NEW YDAT,YKE,YFE,YSAT,YDATA
          mVar YDAT = m$.var("YDAT");
          mVar YKE = m$.var("YKE");
          mVar YFE = m$.var("YFE");
          mVar YSAT = m$.var("YSAT");
          mVar YDATA = m$.var("YDATA");
          m$.newVar(YDAT,YKE,YFE,YSAT,YDATA);
          //<< . SET YDAT=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,8)
          YDAT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),8));
          //<< . SET YKE =$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,9)
          YKE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),9));
          //<< . IF YKE'="" IF $EXTRACT(YKE)'="""" QUIT
          if (mOp.NotEqual(YKE.get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$extract(YKE.get()),"\"")) {
              break;
            }
          }
          //<< . SET YFE=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,10)
          YFE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),10));
          //<< . SET YSAT="^"_YDAT_"("_$$^WWWYM(YDAT,1)
          YSAT.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YDAT.get()),"("),m$.fnc$("WWWYM.main",YDAT.get(),1)));
          //<< . SET YDATA=$GET(^WWW001(0,YDAT,1))
          YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YDAT.get(),1)));
          //<< . IF YKE'="" IF $EXTRACT(YKE)'="," SET YSAT=YSAT_YKE_","
          if (mOp.NotEqual(YKE.get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$extract(YKE.get()),",")) {
              YSAT.set(mOp.Concat(mOp.Concat(YSAT.get(),YKE.get()),","));
            }
          }
          //<< . IF $PIECE(YDATA,Y,8)'=4 SET YSAT=YSAT_""""_$TRANSLATE(YINHALT,"""")_""""_",1)"
          if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
            YSAT.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YSAT.get(),"\""),m$.Fnc.$translate(m$.var("YINHALT").get(),"\"")),"\""),",1)"));
          }
          //<< . IF $PIECE(YDATA,Y,8)=4  SET YSAT=YSAT_""""_$TRANSLATE(YINHALT,"""")_""""_")"
          if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
            YSAT.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YSAT.get(),"\""),m$.Fnc.$translate(m$.var("YINHALT").get(),"\"")),"\""),")"));
          }
          //<< . ;I $D(@(YSAT)) S YINHALT=$P(@(YSAT),Y,YFE) S YQ=1
          //<< . SET YSAT(1)=$PIECE($$^WWWSETL(YSAT),Y,YFE)
          YSAT.var(1).set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YSAT.get()),m$.var("Y").get(),YFE.get()));
          //<< . IF YSAT(1)'="" SET YINHALT1=YSAT(1) SET YQ=1
          if (mOp.NotEqual(YSAT.var(1).get(),"")) {
            YINHALT1.set(YSAT.var(1).get());
            YQ.set(1);
          }
        } while (false);
        return;
      }
    }
    //<< 
    //<< DO FORMAT
    m$.Cmd.Do("FORMAT");
    //<< QUIT
    return;
  }

  //<< 
  //<< FORMAT ;
  public Object FORMAT() {
    //<< QUIT:YINHALT=""
    if (mOp.Equal(m$.var("YINHALT").get(),"")) {
      return null;
    }
    //<< SET YINHALT=$$^WWWTR(0,YTYP,YINHALT)
    mVar YINHALT = m$.var("YINHALT");
    YINHALT.set(m$.fnc$("WWWTR.main",0,m$.var("YTYP").get(),m$.var("YINHALT").get()));
    //<< IF YTYP=2 SET:+YINHALT=0 YINHALT="" SET:YINHALT=1 YINHALT="X"          QUIT
    if (mOp.Equal(m$.var("YTYP").get(),2)) {
      if (mOp.Equal(mOp.Positive(YINHALT.get()),0)) {
        YINHALT.set("");
      }
      if (mOp.Equal(YINHALT.get(),1)) {
        YINHALT.set("X");
      }
      return null;
    }
    //<< IF YTYP=5 SET YINHALT=$EXTRACT("*****************",1,$LENGTH(YINHALT)) QUIT
    if (mOp.Equal(m$.var("YTYP").get(),5)) {
      YINHALT.set(m$.Fnc.$extract("*****************",1,m$.Fnc.$length(YINHALT.get())));
      return null;
    }
    //<< IF YTYP=3 SET YINHALT=$TRANSLATE(YINHALT,"|"," ")                      QUIT
    if (mOp.Equal(m$.var("YTYP").get(),3)) {
      YINHALT.set(m$.Fnc.$translate(YINHALT.get(),"|"," "));
      return null;
    }
    //<< QUIT
    return null;
  }

//<< 
//<< 
}
