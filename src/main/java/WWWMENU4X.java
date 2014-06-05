//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMENU4X
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:26
//*****************************************************************************

import mLibrary.*;


//<< WWWMENU4X
public class WWWMENU4X extends mClass {

  public void main() {
    _WWWMENU4X();
  }

  public void _WWWMENU4X() {
    //<< ;/------------------------------------------------------------------\
    //<< ; Description of Function :
    //<< ;       MENU AUFGEHEND PLUS-MINUS
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
    //<< ; 17-Oct-2005   PO      SR13680: commented out - I $P(YA,Y,7)="CGI" W "?dummy=0" D ^WWWCGI
    //<< ; DT    23.04.1998
    //<< ;\------------------------------------------------------------------/
    //<< NEW BILD
    mVar BILD = m$.var("BILD");
    m$.newVar(BILD);
    //<< 
    //<< ;SET YTARGET=$PIECE(YVOR,Y,19)
    //<< SET YA=""
    mVar YA = m$.var("YA");
    YA.set("");
    //<< IF SPRACHE="EN" IF $PIECE($PIECE(YVOR,Y,11),",",2)'="" SET $PIECE(YVOR,Y,11)=$PIECE($PIECE(YVOR,Y,11),",",2)
    if (mOp.Equal(m$.var("SPRACHE").get(),"EN")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11),",",2),"")) {
        m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),11).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11),",",2));
      }
    }
    //<< IF SPRACHE="FR" IF $PIECE($PIECE(YVOR,Y,11),",",3)'="" SET $PIECE(YVOR,Y,11)=$PIECE($PIECE(YVOR,Y,11),",",3)
    if (mOp.Equal(m$.var("SPRACHE").get(),"FR")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11),",",3),"")) {
        m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),11).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11),",",3));
      }
    }
    //<< SET $PIECE(YVOR,Y,11)=$PIECE($PIECE(YVOR,Y,11),",",1)
    m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),11).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11),",",1));
    //<< IF $PIECE(YVOR,Y,20)=1  WRITE YCR,"<TABLE BORDER=1 VALIGN=TOP CELLSPACING=0><TR><TD NOWRAP>"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),20),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=1 VALIGN=TOP CELLSPACING=0><TR><TD NOWRAP>");
    }
    //<< IF $PIECE(YVOR,Y,20)'=1 WRITE "<NOBR>"
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),20),1)) {
      m$.Cmd.Write("<NOBR>");
    }
    //<< IF YANZ="" WRITE "<A NAME='TARGET'></A>"
    if (mOp.Equal(m$.var("YANZ").get(),"")) {
      m$.Cmd.Write("<A NAME='TARGET'></A>");
    }
    do {
      //<< 
      //<< ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK
      //<< ;I YANZ'="" D
      //<< ;. NEW YANZ
      //<< ;. WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
      //<< ;. SET YANZ=""
      //<< ;. DO ^WWWCGI
      //<< ;. WRITE """"
      //<< ;. WRITE ">"
      //<< 
      //<< DO
      //<< . IF YBER=1 IF $GET(SPRACHE)="DE"  WRITE "<A HREF="_""""_YGIF_"blank1.htm"_""""
      if (mOp.Equal(m$.var("YBER").get(),1)) {
        if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"DE")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YGIF").get()),"blank1.htm"),"\""));
        }
      }
      //<< . IF YBER'=1!($GET(SPRACHE)'="DE") WRITE "<A HREF="_""""_YGIF_"blank.htm"_""""
      if (mOp.Or(mOp.NotEqual(m$.var("YBER").get(),1),(mOp.NotEqual(m$.Fnc.$get(m$.var("SPRACHE")),"DE")))) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YGIF").get()),"blank.htm"),"\""));
      }
      //<< . IF $PIECE(YA,Y,19)="" IF $PIECE(YVOR,Y,19)'="" WRITE " TARGET="_""""_YTARGET_""""
      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),19),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.var("YTARGET").get()),"\""));
        }
      }
      //<< . IF $PIECE(YA,Y,19)'="" WRITE " TARGET="_""""_$PIECE(YA,Y,19)_""""
      if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"\""));
      }
      //<< . WRITE ">"
      m$.Cmd.Write(">");
    } while(false);
    //<< 
    //<< WRITE "<IMG SRC="_""""_YGIF_"aplatz.gif"_""""_" align=top vspace=0 hspace=0 border=0>"  ; ALIGN=TOP>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"aplatz.gif"),"\"")," align=top vspace=0 hspace=0 border=0>"));
    //<< WRITE $PIECE(YVOR,Y,11)
    m$.Cmd.Write(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11));
    //<< WRITE "</A>"
    m$.Cmd.Write("</A>");
    //<< SET YQ=$ORDER(^WWWWV(YM,YBED,"")) IF YQ'="" IF (YQ=+$HOROLOG) || (YQ<$HOROLOG) DO  ;WIEDERVORLAGEN VORHANDEN ;on hand
    mVar YQ = m$.var("YQ");
    YQ.set(m$.Fnc.$order(m$.var("^WWWWV",m$.var("YM").get(),m$.var("YBED").get(),"")));
    if (mOp.NotEqual(YQ.get(),"")) {
      if ((mOp.Equal(YQ.get(),mOp.Positive(m$.Fnc.$horolog()))) || (mOp.Less(YQ.get(),m$.Fnc.$horolog()))) {
        //<< . WRITE YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . WRITE "<A"
        m$.Cmd.Write("<A");
        //<< . WRITE " TITLE="_""""_$$^WWWTEXT(149)_""""
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.fnc$("WWWTEXT.main",149)),"\""));
        //<< . DO  ;FIS;25.01.05;KEINE BERECHTIGUNG FÜR WIEDERVORLAGEN
        do {
          //<< . . IF $$^WWWACCESS($PIECE($GET(^WWW001(0,"WWWWV",1)),Y,2),$PIECE($GET(^WWW001(0,"WWWWV",1)),Y,5))'=1 WRITE " HREF="_""""_"#" QUIT
          if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,"WWWWV",1)),m$.var("Y").get(),2),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,"WWWWV",1)),m$.var("Y").get(),5)),1)) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" HREF=","\""),"#"));
            break;
          }
          //<< . . WRITE " HREF="_""""_YAKTION_"EP=WWWFORM&amp;YFORM=WWWWV"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=","\""),m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWWWV"));
          //<< . . DO ^WWWCGI
          m$.Cmd.Do("WWWCGI.main");
        } while(false);
        //<< . ;
        //<< . ;WRITE " HREF="_""""_YAKTION_"EP=WWWFORM&YFORM=WWWWV"
        //<< . ;DO ^WWWCGI
        //<< . WRITE """"
        m$.Cmd.Write("\"");
        //<< . IF $PIECE(YA,Y,19)="" IF $PIECE(YVOR,Y,19)'="" WRITE " TARGET="_""""_YTARGET_""""
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),19),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.var("YTARGET").get()),"\""));
          }
        }
        //<< . IF $PIECE(YA,Y,19)'="" WRITE " TARGET="_""""_$PIECE(YA,Y,19)_""""
        if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"\""));
        }
        //<< . WRITE ">"
        m$.Cmd.Write(">");
        //<< . ;WRITE "<FONT COLOR=RED>"
        //<< . WRITE "<FONT COLOR="_YRED_">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT COLOR=",m$.var("YRED").get()),">"));
        //<< . WRITE "[!]"
        m$.Cmd.Write("[!]");
        //<< . WRITE "</FONT>"
        m$.Cmd.Write("</FONT>");
        //<< . WRITE "</A>"
        m$.Cmd.Write("</A>");
      }
    }
    //<< 
    //<< DO PGM
    m$.Cmd.Do("PGM");
    //<< IF $PIECE(YVOR,Y,20)'=1 WRITE "</NOBR>"
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),20),1)) {
      m$.Cmd.Write("</NOBR>");
    }
    //<< IF $PIECE(YVOR,Y,20)=1 WRITE YCR,"</TD></TR></TABLE>"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),20),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< PGM ;
  public void PGM() {
    //<< SET YAPP=""
    mVar YAPP = m$.var("YAPP");
    YAPP.set("");
    //<< FOR  SET YAPP=$ORDER(^WWW004X(0,YM,YAPP)) QUIT:YAPP=""  DO
    for (;true;) {
      YAPP.set(m$.Fnc.$order(m$.var("^WWW004X",0,m$.var("YM").get(),YAPP.get())));
      if (mOp.Equal(YAPP.get(),"")) {
        break;
      }
      do {
        //<< . SET YEND=0 IF $ORDER(^WWW004X(0,YM,YAPP))="" SET YEND=1
        mVar YEND = m$.var("YEND");
        YEND.set(0);
        if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW004X",0,m$.var("YM").get(),YAPP.get())),"")) {
          YEND.set(1);
        }
        //<< . IF YAPP=YANZ WRITE "<A NAME='TARGET'></A>"
        if (mOp.Equal(YAPP.get(),m$.var("YANZ").get())) {
          m$.Cmd.Write("<A NAME='TARGET'></A>");
        }
        //<< . SET YQ=1
        mVar YQ = m$.var("YQ");
        YQ.set(1);
        //<< . SET YPROG=""
        mVar YPROG = m$.var("YPROG");
        YPROG.set("");
        //<< . FOR  SET YPROG=$ORDER(^WWW004(0,YAPP,YPROG)) QUIT:YPROG=""  DO  QUIT:YQ=0
        for (;true;) {
          YPROG.set(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get(),YPROG.get())));
          if (mOp.Equal(YPROG.get(),"")) {
            break;
          }
          do {
            //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROG_";") SET YQ=0 QUIT  ;BERECHTIGT
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),YAPP.get())))) {
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),YAPP.get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROG.get()),";")))) {
                YQ.set(0);
                break;
              }
            }
            //<< . . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
            mVar YA = m$.var("YA");
            YA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),YPROG.get(),1)));
            //<< . . IF $FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") SET YQ=0 QUIT
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
              YQ.set(0);
              break;
            }
            //<< . . IF $$^WWWACCESS($PIECE(YA,Y,3),$PIECE(YA,Y,4))=1 SET YQ=0 QUIT  ;ZUGANG
            if (mOp.Equal(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4)),1)) {
              YQ.set(0);
              break;
            }
          } while (false);
          if (mOp.Equal(YQ.get(),0)) {
            break;
          }
        }
        //<< . ;
        //<< . QUIT:YQ=1
        if (mOp.Equal(YQ.get(),1)) {
          break;
        }
        //<< . WRITE "<BR>"
        m$.Cmd.Write("<BR>");
        //<< . WRITE YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . IF YANZ=""!($PIECE(YANZ,",",1)'=YAPP) DO
        if (mOp.Or(mOp.Equal(m$.var("YANZ").get(),""),(mOp.NotEqual(m$.Fnc.$piece(m$.var("YANZ").get(),",",1),YAPP.get())))) {
          //<< . . NEW YANZ
          mVar YANZ = m$.var("YANZ");
          m$.newVarBlock(2,YANZ);
          //<< . . WRITE "<A"
          m$.Cmd.Write("<A");
          //<< . . IF $DATA(^WWWVERSION(0,YAPP,1)) WRITE " TITLE="_""""_$$^WWWTEXT(253)_" "_$PIECE($GET(^WWWVERSION(0,YAPP,1)),Y,1)_""""    ;VERSION;BEC;23699;YM DURCH 0 ERSETZT,SPRACHENTEXT;26.05.03
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWVERSION",0,YAPP.get(),1)))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.fnc$("WWWTEXT.main",253))," "),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWVERSION",0,YAPP.get(),1)),m$.var("Y").get(),1)),"\""));
          }
          //<< . . WRITE " HREF="_""""_YAKTION_"EP=WWWMENU"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
          //<< . . SET YANZ=YAPP
          YANZ.set(YAPP.get());
          //<< . . DO ^WWWCGI
          m$.Cmd.Do("WWWCGI.main");
          //<< . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . WRITE ">"
          m$.Cmd.Write(">");
        }
        m$.restoreVarBlock(2);
        //<< . ;
        //<< . IF YANZ'="" IF $PIECE(YANZ,",",1)=YAPP DO
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YANZ").get(),",",1),YAPP.get())) {
            //<< . . NEW YANZ
            mVar YANZ = m$.var("YANZ");
            m$.newVarBlock(2,YANZ);
            //<< . . WRITE "<A"
            m$.Cmd.Write("<A");
            //<< . . IF $DATA(^WWWVERSION(0,YAPP,1)) WRITE " TITLE="_""""_$$^WWWTEXT(253)_" "_$PIECE($GET(^WWWVERSION(0,YAPP,1)),Y,1)_""""   ;VERSION;BEC;23699;YM DURCH 0 ERSETZT,SPRACHENTEXT;26.05.03
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWVERSION",0,YAPP.get(),1)))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.fnc$("WWWTEXT.main",253))," "),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWVERSION",0,YAPP.get(),1)),m$.var("Y").get(),1)),"\""));
            }
            //<< . . WRITE " HREF="_""""_YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
            //<< . . SET YANZ=""
            YANZ.set("");
            //<< . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . WRITE ">"
            m$.Cmd.Write(">");
          }
          m$.restoreVarBlock(2);
        }
        //<< . ;
        //<< . IF YANZ="" DO
        if (mOp.Equal(m$.var("YANZ").get(),"")) {
          //<< . . IF YEND=0  WRITE "<IMG SRC="_""""_YGIF_"plus.gif"_""""_" align=top  border=0 vspace=0 hspace=0>"
          if (mOp.Equal(YEND.get(),0)) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"plus.gif"),"\"")," align=top  border=0 vspace=0 hspace=0>"));
          }
          //<< . . IF YEND'=0 WRITE "<IMG SRC="_""""_YGIF_"eplus.gif"_""""_" align=top  border=0 vspace=0 hspace=0>"
          if (mOp.NotEqual(YEND.get(),0)) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eplus.gif"),"\"")," align=top  border=0 vspace=0 hspace=0>"));
          }
          //<< . . WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" align=top border=0 vspace=0>"  ; ALIGN=TOP>"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," align=top border=0 vspace=0>"));
        }
        //<< . ;
        //<< . IF YANZ'="" IF $PIECE(YANZ,",",1)'=YAPP DO
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YANZ").get(),",",1),YAPP.get())) {
            do {
              //<< . . IF YEND=0 WRITE "<IMG SRC="_""""_YGIF_"plus.gif"_""""_" align=top border=0 vspace=0 hspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" QUIT
              if (mOp.Equal(YEND.get(),0)) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"plus.gif"),"\"")," align=top border=0 vspace=0 hspace=0>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
                break;
              }
              //<< . . WRITE "<IMG SRC="_""""_YGIF_"eplus.gif"_""""_" align=top border=0 vspace=0 hspace=0>"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eplus.gif"),"\"")," align=top border=0 vspace=0 hspace=0>"));
              //<< . . WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" align=top border=0 vspace=0 hspace=0>"  ;ALIGN=TOP>"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," align=top border=0 vspace=0 hspace=0>"));
            } while (false);
          }
        }
        //<< . ;
        //<< . IF YANZ'="" IF $PIECE(YANZ,",",1)=YAPP DO
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YANZ").get(),",",1),YAPP.get())) {
            //<< . . IF YEND=0 WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" align=top  border=0 vspace=0 hspace=0>"
            if (mOp.Equal(YEND.get(),0)) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," align=top  border=0 vspace=0 hspace=0>"));
            }
            //<< . . IF YEND'=0 WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" align=top border=0 vspace=0 hspace=0>"
            if (mOp.NotEqual(YEND.get(),0)) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," align=top border=0 vspace=0 hspace=0>"));
            }
            //<< . . WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" align=top border=0 vspace=0 hspace=0>"  ; ALIGN=TOP>"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," align=top border=0 vspace=0 hspace=0>"));
          }
        }
        //<< . ;
        //<< . IF YANZ'="" IF YAPP=$PIECE(YANZ,",",1) WRITE "<B>"
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(YAPP.get(),m$.Fnc.$piece(m$.var("YANZ").get(),",",1))) {
            m$.Cmd.Write("<B>");
          }
        }
        //<< . WRITE $TRANSLATE($$^WWWUML(YAPP),"_"," ")
        m$.Cmd.Write(m$.Fnc.$translate(m$.fnc$("WWWUML.main",YAPP.get()),"_"," "));
        //<< . IF YANZ'="" IF YAPP=$PIECE(YANZ,",",1) WRITE "</B>"
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(YAPP.get(),m$.Fnc.$piece(m$.var("YANZ").get(),",",1))) {
            m$.Cmd.Write("</B>");
          }
        }
        //<< . WRITE "</A>"
        m$.Cmd.Write("</A>");
        //<< . ;DO EDITMENU(0)  ;FIS;20.05.03;23658;SHORT CUT MENU
        //<< . IF YANZ'="" IF YAPP=$PIECE(YANZ,",",1) DO BER
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(YAPP.get(),m$.Fnc.$piece(m$.var("YANZ").get(),",",1))) {
            m$.Cmd.Do("BER");
          }
        }
      } while (false);
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< BER ;
  public void BER() {
    //<< SET YQ=0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< SET YPROG=""
    mVar YPROG = m$.var("YPROG");
    YPROG.set("");
    //<< FOR  SET YPROG=$ORDER(^WWW004X(0,YM,YAPP,YPROG)) QUIT:YPROG=""  DO BER1
    for (;true;) {
      YPROG.set(m$.Fnc.$order(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),YPROG.get())));
      if (mOp.Equal(YPROG.get(),"")) {
        break;
      }
      m$.Cmd.Do("BER1");
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< BER1 ;
  public void BER1() {
    do {
      //<< DO
      //<< . QUIT:$PIECE(YPROG,".",2,9)'=""
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YPROG").get(),".",2,9),"")) {
        break;
      }
      //<< . IF (YAPP_","_YPROG)=YANZ WRITE "<A NAME='TARGET'></A>"
      if (mOp.Equal((mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),m$.var("YPROG").get())),m$.var("YANZ").get())) {
        m$.Cmd.Write("<A NAME='TARGET'></A>");
      }
      //<< . SET YBEND=0  IF $PIECE($ORDER(^WWW004X(0,YM,YAPP,""),-1),".",1)=$PIECE(YPROG,".",1)  SET YBEND=1
      mVar YBEND = m$.var("YBEND");
      YBEND.set(0);
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),""),mOp.Negative(1)),".",1),m$.Fnc.$piece(m$.var("YPROG").get(),".",1))) {
        YBEND.set(1);
      }
      //<< . SET YP0END=0 IF $PIECE($ORDER(^WWW004X(0,YM,YAPP,YPROG)),".",1)'=$PIECE(YPROG,".",1) SET YP0END=1
      mVar YP0END = m$.var("YP0END");
      YP0END.set(0);
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),m$.var("YPROG").get())),".",1),m$.Fnc.$piece(m$.var("YPROG").get(),".",1))) {
        YP0END.set(1);
      }
      //<< . SET YQ=0
      mVar YQ = m$.var("YQ");
      YQ.set(0);
      //<< . SET YPROGX=$PIECE($GET(^WWW004X(0,YM,YAPP,YPROG,1)),Y,1)
      mVar YPROGX = m$.var("YPROGX");
      YPROGX.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),m$.var("YPROG").get(),1)),m$.var("Y").get(),1));
      //<< . QUIT:YPROGX=""
      if (mOp.Equal(YPROGX.get(),"")) {
        break;
      }
      //<< . SET YA=$GET(^WWW004(0,YAPP,YPROGX,1))
      mVar YA = m$.var("YA");
      YA.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGX.get(),1)));
      //<< . QUIT:$PIECE(YA,Y,7)="noshow"  ;keine anzeige ;None
      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"noshow")) {
        break;
      }
      //<< . QUIT:YA=""
      if (mOp.Equal(YA.get(),"")) {
        break;
      }
      //<< . SET BILD="html.gif"  ;VORGABE ;handicap  ;default
      mVar BILD = m$.var("BILD");
      BILD.set("html.gif");
      //<< . IF $PIECE(YA,Y,8)'="" SET BILD=$PIECE(YA,Y,8)  ;NEUES BILD ;something new portrait
      if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),"")) {
        BILD.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8));
      }
      //<< . IF $PIECE(YVOR,Y,102)'="" SET BILD=$PIECE(YVOR,Y,102)  ;FESTE VORGABE ;default
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),102),"")) {
        BILD.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),102));
      }
      //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" SET YQ=1 SET YPROGP=YPROG FOR  SET YPROGP=$ORDER(^WWW004X(0,YM,YAPP,YPROGP)) QUIT:$EXTRACT(YPROGP,1,$LENGTH(YPROG))'=YPROG  QUIT:YPROGP=""  DO  QUIT:YQ=0
      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          YQ.set(1);
          mVar YPROGP = m$.var("YPROGP");
          YPROGP.set(m$.var("YPROG").get());
          for (;true;) {
            YPROGP.set(m$.Fnc.$order(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),YPROGP.get())));
            if (mOp.NotEqual(m$.Fnc.$extract(YPROGP.get(),1,m$.Fnc.$length(m$.var("YPROG").get())),m$.var("YPROG").get())) {
              break;
            }
            if (mOp.Equal(YPROGP.get(),"")) {
              break;
            }
            do {
              //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROGP_";") SET YQ=0 QUIT  ;BERECHTIGT
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get())))) {
                if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROGP.get()),";")))) {
                  YQ.set(0);
                  break;
                }
              }
              //<< . . SET YPROGPX=$PIECE($GET(^WWW004X(0,YM,YAPP,YPROGP,1)),Y,1)
              mVar YPROGPX = m$.var("YPROGPX");
              YPROGPX.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),YPROGP.get(),1)),m$.var("Y").get(),1));
              //<< . . QUIT:YPROGPX=""
              if (mOp.Equal(YPROGPX.get(),"")) {
                break;
              }
              //<< . . SET YA1=$GET(^WWW004(0,YAPP,YPROGPX,1))
              mVar YA1 = m$.var("YA1");
              YA1.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGPX.get(),1)));
              //<< . . QUIT:YA1=""
              if (mOp.Equal(YA1.get(),"")) {
                break;
              }
              //<< . . IF $FIND(","_$TRANSLATE($PIECE(YA1,Y,6),";",",")_",",","_YBED_",") SET YQ=0 QUIT
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA1.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
                YQ.set(0);
                break;
              }
              //<< . . IF $$^WWWACCESS($PIECE(YA1,Y,3),$PIECE(YA1,Y,4))=1 SET YQ=0 QUIT  ;ZUGANG
              if (mOp.Equal(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA1.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA1.get(),m$.var("Y").get(),4)),1)) {
                YQ.set(0);
                break;
              }
            } while (false);
            if (mOp.Equal(YQ.get(),0)) {
              break;
            }
          }
        }
      }
      //<< . ;
      //<< . QUIT:YQ=1
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
      //<< . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") DO
      if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
        do {
          //<< . . SET YQ=1
          YQ.set(1);
          //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROGX_";") DO  SET YQ=0 QUIT  ;BERECHTIGT
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get())))) {
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROGX.get()),";")))) {
              //<< . . . IF $PIECE(YA,Y,2)'="" SET ^WWWUSE(0,YUSER,$PIECE(YA,Y,2),"A",1)="Form Access"
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"A",1).set("Form Access");
              }
              YQ.set(0);
              break;
            }
          }
          //<< . . ;
          //<< . . IF $FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") SET YQ=0 QUIT
          if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
            YQ.set(0);
            break;
          }
          //<< . . IF $$^WWWACCESS($PIECE(YA,Y,3),$PIECE(YA,Y,4))=1 SET YQ=0  ;ZUGANG
          if (mOp.Equal(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4)),1)) {
            YQ.set(0);
          }
        } while (false);
      }
      //<< . ;
      //<< . QUIT:YQ=1
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
      //<< . IF $DATA(^WWW0041(0,YAPP,YPROGX,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,m$.var("YAPP").get(),YPROGX.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
        m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
      }
      //<< . IF $DATA(^WWW00441(0,YAPP,YPROGX,1)) IF $PIECE(^(1),Y,1)'="" SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW00441",0,m$.var("YAPP").get(),YPROGX.get(),1)))) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1),"")) {
          m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
        }
      }
      //<< . WRITE YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . WRITE "<br>"
      m$.Cmd.Write("<br>");
      //<< . SET YASTART=0
      mVar YASTART = m$.var("YASTART");
      YASTART.set(0);
      //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" DO
      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          //<< . . IF YPROG'=($PIECE($PIECE(YANZ,",",2),".",1)_".") DO
          if (mOp.NotEqual(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
            //<< . . . NEW YANZ
            mVar YANZ = m$.var("YANZ");
            m$.newVarBlock(3,YANZ);
            //<< . . . SET YASTART=1
            YASTART.set(1);
            //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
            //<< . . . SET YANZ=YAPP_","_YPROG
            YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),m$.var("YPROG").get()));
            //<< . . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . . WRITE ">"
            m$.Cmd.Write(">");
          }
          m$.restoreVarBlock(3);
          //<< . . ;
          //<< . . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") DO
          if (mOp.Equal(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
            //<< . . . NEW YANZ
            mVar YANZ = m$.var("YANZ");
            m$.newVarBlock(3,YANZ);
            //<< . . . SET YASTART=1
            YASTART.set(1);
            //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
            //<< . . . SET YANZ=YAPP
            YANZ.set(m$.var("YAPP").get());
            //<< . . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . . WRITE ">"
            m$.Cmd.Write(">");
          }
          m$.restoreVarBlock(3);
        }
      }
      //<< . ;
      //<< . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") DO
      if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
        //<< . . SET YFORM=$PIECE(YA,Y,2)
        mVar YFORM = m$.var("YFORM");
        YFORM.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2));
        //<< . . SET YPARA=$PIECE(YA,Y,7)_Y_$PIECE(YA,Y,5)
        mVar YPARA = m$.var("YPARA");
        YPARA.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),m$.var("Y").get()),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),5)));
        //<< . . IF $PIECE(YA,Y,12)="" DO
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          //<< . . . NEW YNAME
          mVar YNAME = m$.var("YNAME");
          m$.newVarBlock(3,YNAME);
          //<< . . . SET YAUFRUF="WWWFORM"
          mVar YAUFRUF = m$.var("YAUFRUF");
          YAUFRUF.set("WWWFORM");
          //<< . . . IF $PIECE(YA,Y,13)=1 SET YAUFRUF="WWWSEAR"
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),1)) {
            YAUFRUF.set("WWWSEAR");
          }
          //<< . . . SET YASTART=1
          YASTART.set(1);
          //<< . . . WRITE "<A"
          m$.Cmd.Write("<A");
          //<< . . . DO STAT
          m$.Cmd.Do("STAT");
          //<< . . . WRITE " HREF="
          m$.Cmd.Write(" HREF=");
          //<< . . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . . IF +$PIECE(YA,Y,20)'=0 DO
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)),0)) {
            //<< . . . . WRITE "JavaScript:parent.document.body.cols='"_(100-$PIECE(YA,Y,20))_"%,"_$PIECE(YA,Y,20)_"%'; "
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("JavaScript:parent.document.body.cols='",(mOp.Subtract(100,m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)))),"%,"),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)),"%'; "));
            //<< . . . . WRITE "window.location='"
            m$.Cmd.Write("window.location='");
          }
          //<< . . . WRITE YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP="),YAUFRUF.get()),"&amp;YFORM="),YFORM.get()));
          //<< . . . SET YNAME=$PIECE(YA,Y,1)
          YNAME.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1));
          //<< . . . DO ^WWWCGI
          m$.Cmd.Do("WWWCGI.main");
          //<< . . . IF +$PIECE(YA,Y,20)'=0 DO   ;WENN MIT VERGRÖSSERUNG ;when by means of
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)),0)) {
            //<< . . . . WRITE "';"
            m$.Cmd.Write("';");
          }
          //<< . . . ;
          //<< . . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . . IF $PIECE(YA,Y,19)="" IF $PIECE(YVOR,Y,19)'="" WRITE " TARGET="_""""_YTARGET_""""
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),19),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.var("YTARGET").get()),"\""));
            }
          }
          //<< . . . IF $PIECE(YA,Y,19)'="" WRITE " TARGET="_""""_$PIECE(YA,Y,19)_""""
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"\""));
          }
          //<< . . . WRITE ">"
          m$.Cmd.Write(">");
        }
        m$.restoreVarBlock(3);
        //<< . . ;
        //<< . . IF $PIECE(YA,Y,12)'="" DO  ;URL
        if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          //<< . . . SET YASTART=1
          YASTART.set(1);
          //<< . . . WRITE "<A HREF="_""""
          m$.Cmd.Write(mOp.Concat("<A HREF=","\""));
          //<< . . . WRITE $PIECE(YA,Y,12)
          m$.Cmd.Write(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12));
          //<< . . . ;I $P(YA,Y,7)="CGI" W "?dummy=0" D ^WWWCGI ; SR13680
          //<< . . . ;I '$F($P(YA,Y,12),":") W "http://"_$P(YA,Y,12)
          //<< . . . ;I $F($P(YA,Y,12),":") W $P(YA,Y,12)
          //<< . . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . . IF $PIECE(YA,Y,19)="" IF $PIECE(YVOR,Y,19)'="" WRITE " TARGET="_""""_YTARGET_""""
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),19),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.var("YTARGET").get()),"\""));
            }
          }
          //<< . . . IF $PIECE(YA,Y,19)'="" WRITE " TARGET="_""""_$PIECE(YA,Y,19)_""""
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"\""));
          }
          //<< . . . WRITE ">"
          m$.Cmd.Write(">");
        }
      }
      //<< . ;
      //<< . IF YEND=0 WRITE "<IMG SRC="_""""_YGIF_"iplus.gif"_""""_" border=0 align=top vspace=0>"
      if (mOp.Equal(m$.var("YEND").get(),0)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"iplus.gif"),"\"")," border=0 align=top vspace=0>"));
      }
      //<< . IF YEND=1 WRITE "<IMG SRC="_""""_YGIF_"bplus.gif"_""""_" border=0 align=top vspace=0>"
      if (mOp.Equal(m$.var("YEND").get(),1)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"bplus.gif"),"\"")," border=0 align=top vspace=0>"));
      }
      //<< . IF YBEND=0 DO
      if (mOp.Equal(YBEND.get(),0)) {
        //<< . . SET BPLUS="plus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="tplus.gif"
        mVar BPLUS = m$.var("BPLUS");
        BPLUS.set("plus.gif");
        if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
          BPLUS.set("tplus.gif");
        }
        //<< . . IF YPROG'=($PIECE($PIECE(YANZ,",",2),".",1)_".") DO
        if (mOp.NotEqual(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
          //<< . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
            }
          }
          //<< . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" if $FIND(BILD,"gif") IF BILD'="html.gif" write " "
          if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
            if (mOp.Logical(m$.Fnc.$find(BILD.get(),"gif"))) {
              if (mOp.NotEqual(BILD.get(),"html.gif")) {
                m$.Cmd.Write(" ");
              }
            }
          }
        }
        //<< . . ;
        //<< . . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
        if (mOp.Equal(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top vspace=0>"));
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
        }
      }
      //<< . ;
      //<< . IF YBEND=1 DO
      if (mOp.Equal(YBEND.get(),1)) {
        //<< . . SET BPLUS="eplus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
        mVar BPLUS = m$.var("BPLUS");
        BPLUS.set("eplus.gif");
        if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
          BPLUS.set("lplus.gif");
        }
        //<< . . IF YPROG'=($PIECE($PIECE(YANZ,",",2),".",1)_".") DO
        if (mOp.NotEqual(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
          //<< . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
            }
          }
          //<< . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" if $FIND(BILD,"gif") IF BILD'="html.gif" write " "
          if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
            if (mOp.Logical(m$.Fnc.$find(BILD.get(),"gif"))) {
              if (mOp.NotEqual(BILD.get(),"html.gif")) {
                m$.Cmd.Write(" ");
              }
            }
          }
        }
        //<< . . ;
        //<< . . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
        if (mOp.Equal(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top vspace=0>"));
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
        }
      }
      //<< . ;
      //<< . ;I $D(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1)) S $P(YA,Y,1)=$P(^(1),Y,1)
      //<< . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") WRITE "<B>"
      if (mOp.Equal(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
        m$.Cmd.Write("<B>");
      }
      //<< . WRITE $$^WWWUML($PIECE(YA,Y,1))
      m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
      //<< . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") WRITE "</B>"
      if (mOp.Equal(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
        m$.Cmd.Write("</B>");
      }
      //<< . ;IF YASTART=1 WRITE "</A>" DO EDITMENU(0)  ;FIS;20.05.03;23658;SHORT CUT MENU
      //<< . IF YANZ'="" IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") SET YLEV=1 DO PRO
      if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
        if (mOp.Equal(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
          mVar YLEV = m$.var("YLEV");
          YLEV.set(1);
          m$.Cmd.Do("PRO");
        }
      }
    } while(false);
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< PRO ;
  public void PRO() {
    //<< SET YPROG1=YPROG
    mVar YPROG1 = m$.var("YPROG1");
    YPROG1.set(m$.var("YPROG").get());
    //<< FOR  SET YPROG1=$ORDER(^WWW004X(0,YM,YAPP,YPROG1)) QUIT:YPROG1=""  QUIT:$EXTRACT(YPROG1,1,$LENGTH(YPROG))'=YPROG  DO PRO1
    for (;true;) {
      YPROG1.set(m$.Fnc.$order(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),YPROG1.get())));
      if (mOp.Equal(YPROG1.get(),"")) {
        break;
      }
      if (mOp.NotEqual(m$.Fnc.$extract(YPROG1.get(),1,m$.Fnc.$length(m$.var("YPROG").get())),m$.var("YPROG").get())) {
        break;
      }
      m$.Cmd.Do("PRO1");
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< PRO1 ;
  public void PRO1() {
    do {
      //<< DO
      //<< . QUIT:$PIECE(YPROG1,".",3,9)'=""
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YPROG1").get(),".",3,9),"")) {
        break;
      }
      //<< . IF (YAPP_","_YPROG1)=YANZ WRITE "<A NAME='TARGET'></A>"
      if (mOp.Equal((mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),m$.var("YPROG1").get())),m$.var("YANZ").get())) {
        m$.Cmd.Write("<A NAME='TARGET'></A>");
      }
      //<< . SET YB1END=0 IF $PIECE($ORDER(^WWW004X(0,YM,YAPP,YPROG1_$CHAR(255))),".",1)'=$PIECE(YPROG1,".",1) SET YB1END=1
      mVar YB1END = m$.var("YB1END");
      YB1END.set(0);
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),mOp.Concat(m$.var("YPROG1").get(),m$.Fnc.$char(255)))),".",1),m$.Fnc.$piece(m$.var("YPROG1").get(),".",1))) {
        YB1END.set(1);
      }
      //<< . SET YP1END=0 IF $PIECE($ORDER(^WWW004X(0,YM,YAPP,YPROG1_$CHAR(255))),".",1,2)'=$PIECE(YPROG1,".",1,2) SET YP1END=1
      mVar YP1END = m$.var("YP1END");
      YP1END.set(0);
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),mOp.Concat(m$.var("YPROG1").get(),m$.Fnc.$char(255)))),".",1,2),m$.Fnc.$piece(m$.var("YPROG1").get(),".",1,2))) {
        YP1END.set(1);
      }
      //<< . SET YQ=0
      mVar YQ = m$.var("YQ");
      YQ.set(0);
      //<< . SET YPROGX=$PIECE($GET(^WWW004X(0,YM,YAPP,YPROG1,1)),Y,1)
      mVar YPROGX = m$.var("YPROGX");
      YPROGX.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),m$.var("YPROG1").get(),1)),m$.var("Y").get(),1));
      //<< . QUIT:YPROGX=""
      if (mOp.Equal(YPROGX.get(),"")) {
        break;
      }
      //<< . SET YA=$GET(^WWW004(0,YAPP,YPROGX,1))
      mVar YA = m$.var("YA");
      YA.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGX.get(),1)));
      //<< . QUIT:$PIECE(YA,Y,7)="noshow"  ;keine anzeige ;None
      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"noshow")) {
        break;
      }
      //<< . QUIT:YA=""
      if (mOp.Equal(YA.get(),"")) {
        break;
      }
      //<< . SET BILD="html.gif"
      mVar BILD = m$.var("BILD");
      BILD.set("html.gif");
      //<< . IF $PIECE(YA,Y,8)'="" SET BILD=$PIECE(YA,Y,8)
      if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),"")) {
        BILD.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8));
      }
      //<< . IF $PIECE(YVOR,Y,102)'="" SET BILD=$PIECE(YVOR,Y,102)  ;FESTE VORGABE ;default
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),102),"")) {
        BILD.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),102));
      }
      //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" SET YQ=1 SET YPROGP=YPROG1 FOR  SET YPROGP=$ORDER(^WWW004X(0,YM,YAPP,YPROGP)) QUIT:$EXTRACT(YPROGP,1,$LENGTH(YPROG1))'=YPROG1  QUIT:YPROGP=""  DO  QUIT:YQ=0
      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          YQ.set(1);
          mVar YPROGP = m$.var("YPROGP");
          YPROGP.set(m$.var("YPROG1").get());
          for (;true;) {
            YPROGP.set(m$.Fnc.$order(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),YPROGP.get())));
            if (mOp.NotEqual(m$.Fnc.$extract(YPROGP.get(),1,m$.Fnc.$length(m$.var("YPROG1").get())),m$.var("YPROG1").get())) {
              break;
            }
            if (mOp.Equal(YPROGP.get(),"")) {
              break;
            }
            do {
              //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROGP_";") SET YQ=0 QUIT  ;BERECHTIGT
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get())))) {
                if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROGP.get()),";")))) {
                  YQ.set(0);
                  break;
                }
              }
              //<< . . SET YPROGPX=$PIECE($GET(^WWW004X(0,YM,YAPP,YPROGP,1)),Y,1)
              mVar YPROGPX = m$.var("YPROGPX");
              YPROGPX.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW004X",0,m$.var("YM").get(),m$.var("YAPP").get(),YPROGP.get(),1)),m$.var("Y").get(),1));
              //<< . . QUIT:YPROGPX=""
              if (mOp.Equal(YPROGPX.get(),"")) {
                break;
              }
              //<< . . SET YA1=$GET(^WWW004(0,YAPP,YPROGPX,1))
              mVar YA1 = m$.var("YA1");
              YA1.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGPX.get(),1)));
              //<< . . QUIT:YA1=""
              if (mOp.Equal(YA1.get(),"")) {
                break;
              }
              //<< . . IF $FIND(","_$TRANSLATE($PIECE(YA1,Y,6),";",",")_",",","_YBED_",") SET YQ=0 QUIT
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA1.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
                YQ.set(0);
                break;
              }
              //<< . . IF $$^WWWACCESS($PIECE(YA1,Y,3),$PIECE(YA1,Y,4))=1 SET YQ=0 QUIT  ;ZUGANG
              if (mOp.Equal(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA1.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA1.get(),m$.var("Y").get(),4)),1)) {
                YQ.set(0);
                break;
              }
            } while (false);
            if (mOp.Equal(YQ.get(),0)) {
              break;
            }
          }
        }
      }
      //<< . ;
      //<< . QUIT:YQ=1
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
      //<< . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") DO
      if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
        do {
          //<< . . SET YQ=1
          YQ.set(1);
          //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROGX_";") Do  SET YQ=0 QUIT  ;BERECHTIGT
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get())))) {
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROGX.get()),";")))) {
              //<< . . . IF $PIECE(YA,Y,2)'="" SET ^WWWUSE(0,YUSER,$PIECE(YA,Y,2),"A",1)="Form Access"
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"A",1).set("Form Access");
              }
              YQ.set(0);
              break;
            }
          }
          //<< . . ;
          //<< . . IF $FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") SET YQ=0 QUIT
          if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
            YQ.set(0);
            break;
          }
          //<< . . IF $$^WWWACCESS($PIECE(YA,Y,3),$PIECE(YA,Y,4))=1 SET YQ=0  ;ZUGANG
          if (mOp.Equal(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4)),1)) {
            YQ.set(0);
          }
        } while (false);
      }
      //<< . ;
      //<< . QUIT:YQ=1
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
      //<< . IF $DATA(^WWW0041(0,YAPP,YPROGX,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,m$.var("YAPP").get(),YPROGX.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
        m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
      }
      //<< . IF $DATA(^WWW00441(0,YAPP,YPROGX,1)) IF $PIECE(^(1),Y,1)'="" SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW00441",0,m$.var("YAPP").get(),YPROGX.get(),1)))) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1),"")) {
          m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
        }
      }
      //<< . WRITE YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . WRITE "<br>"
      m$.Cmd.Write("<br>");
      //<< . SET YASTART=0
      mVar YASTART = m$.var("YASTART");
      YASTART.set(0);
      //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" DO
      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          //<< . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
          if (mOp.NotEqual(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            //<< . . . NEW YANZ
            mVar YANZ = m$.var("YANZ");
            m$.newVarBlock(3,YANZ);
            //<< . . . SET YASTART=1
            YASTART.set(1);
            //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
            //<< . . . SET YANZ=YAPP_","_YPROG1
            YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),m$.var("YPROG1").get()));
            //<< . . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . . WRITE ">"
            m$.Cmd.Write(">");
          }
          m$.restoreVarBlock(3);
          //<< . . ;
          //<< . . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
          if (mOp.Equal(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            //<< . . . NEW YANZ
            mVar YANZ = m$.var("YANZ");
            m$.newVarBlock(3,YANZ);
            //<< . . . SET YASTART=1
            YASTART.set(1);
            //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
            //<< . . . SET YANZ=YAPP_","_YPROG
            YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),m$.var("YPROG").get()));
            //<< . . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . . WRITE ">"
            m$.Cmd.Write(">");
          }
          m$.restoreVarBlock(3);
        }
      }
      //<< . ;
      //<< . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") DO
      if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
        //<< . . SET YFORM=$PIECE(YA,Y,2)
        mVar YFORM = m$.var("YFORM");
        YFORM.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2));
        //<< . . SET YPARA=$PIECE(YA,Y,7)_Y_$PIECE(YA,Y,5)
        mVar YPARA = m$.var("YPARA");
        YPARA.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),m$.var("Y").get()),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),5)));
        //<< . . IF $PIECE(YA,Y,12)="" DO
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          //<< . . . NEW YNAME
          mVar YNAME = m$.var("YNAME");
          m$.newVarBlock(3,YNAME);
          //<< . . . SET YAUFRUF="WWWFORM"
          mVar YAUFRUF = m$.var("YAUFRUF");
          YAUFRUF.set("WWWFORM");
          //<< . . . IF $PIECE(YA,Y,13)=1 SET YAUFRUF="WWWSEAR"
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),1)) {
            YAUFRUF.set("WWWSEAR");
          }
          //<< . . . SET YASTART=1
          YASTART.set(1);
          //<< . . . WRITE "<A"
          m$.Cmd.Write("<A");
          //<< . . . DO STAT1
          m$.Cmd.Do("STAT1");
          //<< . . . WRITE " HREF="
          m$.Cmd.Write(" HREF=");
          //<< . . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . . IF +$PIECE(YA,Y,20)'=0 DO  ;WENN MIT VERGRÖSSERUNG ;when by means of
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)),0)) {
            //<< . . . . WRITE "JavaScript:parent.document.body.cols='"_(100-$PIECE(YA,Y,20))_"%,"_$PIECE(YA,Y,20)_"%'; "
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("JavaScript:parent.document.body.cols='",(mOp.Subtract(100,m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)))),"%,"),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)),"%'; "));
            //<< . . . . WRITE "window.location='"
            m$.Cmd.Write("window.location='");
          }
          //<< . . . ;
          //<< . . . WRITE YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP="),YAUFRUF.get()),"&amp;YFORM="),YFORM.get()));
          //<< . . . SET YNAME=$PIECE(YA,Y,1)
          YNAME.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1));
          //<< . . . DO ^WWWCGI
          m$.Cmd.Do("WWWCGI.main");
          //<< . . . IF +$PIECE(YA,Y,20)'=0 DO   ;WENN MIT VERGRÖSSERUNG ;when by means of
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)),0)) {
            do {
              //<< . . . . WRITE "';"
              m$.Cmd.Write("';");
              //<< . . . . QUIT
              break;
            } while (false);
          }
          //<< . . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . . IF $PIECE(YA,Y,19)="" IF $PIECE(YVOR,Y,19)'="" WRITE " TARGET="_""""_YTARGET_""""
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),19),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.var("YTARGET").get()),"\""));
            }
          }
          //<< . . . IF $PIECE(YA,Y,19)'="" WRITE " TARGET="_""""_$PIECE(YA,Y,19)_""""
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"\""));
          }
          //<< . . . WRITE ">"
          m$.Cmd.Write(">");
        }
        m$.restoreVarBlock(3);
        //<< . . ;
        //<< . . IF $PIECE(YA,Y,12)'="" DO  ;URL
        if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          //<< . . . SET YASTART=1
          YASTART.set(1);
          //<< . . . WRITE "<A HREF="_""""
          m$.Cmd.Write(mOp.Concat("<A HREF=","\""));
          //<< . . . WRITE $PIECE(YA,Y,12)
          m$.Cmd.Write(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12));
          //<< . . . ;I $P(YA,Y,7)="CGI" W "?dummy=0" D ^WWWCGI ; SR13680
          //<< . . . ;I '$F($P(YA,Y,12),":") W "http://"_$P(YA,Y,12)
          //<< . . . ;I $F($P(YA,Y,12),":") W $P(YA,Y,12)
          //<< . . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . . IF $PIECE(YA,Y,19)="" IF $PIECE(YVOR,Y,19)'="" WRITE " TARGET="_""""_YTARGET_""""
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),19),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.var("YTARGET").get()),"\""));
            }
          }
          //<< . . . IF $PIECE(YA,Y,19)'="" WRITE " TARGET="_""""_$PIECE(YA,Y,19)_""""
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"\""));
          }
          //<< . . . WRITE ">"
          m$.Cmd.Write(">");
        }
      }
      //<< . ;
      //<< . IF YEND=0  WRITE "<IMG SRC="_""""_YGIF_"iplus.gif"_""""_" border=0 align=top vspace=0>"
      if (mOp.Equal(m$.var("YEND").get(),0)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"iplus.gif"),"\"")," border=0 align=top vspace=0>"));
      }
      //<< . IF YEND=1  WRITE "<IMG SRC="_""""_YGIF_"bplus.gif"_""""_" border=0 align=top vspace=0>"
      if (mOp.Equal(m$.var("YEND").get(),1)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"bplus.gif"),"\"")," border=0 align=top vspace=0>"));
      }
      //<< . IF YBEND=0 WRITE "<IMG SRC="_""""_YGIF_"iplus.gif"_""""_" border=0 align=top vspace=0>"
      if (mOp.Equal(m$.var("YBEND").get(),0)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"iplus.gif"),"\"")," border=0 align=top vspace=0>"));
      }
      //<< . IF YBEND=1 WRITE "<IMG SRC="_""""_YGIF_"bplus.gif"_""""_" border=0 align=top vspace=0>"
      if (mOp.Equal(m$.var("YBEND").get(),1)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"bplus.gif"),"\"")," border=0 align=top vspace=0>"));
      }
      //<< . IF YP1END=1 DO
      if (mOp.Equal(YP1END.get(),1)) {
        //<< . . IF YB1END=0 DO
        if (mOp.Equal(YB1END.get(),0)) {
          //<< . . . SET BPLUS="plus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="tplus.gif"
          mVar BPLUS = m$.var("BPLUS");
          BPLUS.set("plus.gif");
          if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
            BPLUS.set("tplus.gif");
          }
          //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
          if (mOp.NotEqual(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)=""  WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              }
            }
            //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" IF $FIND(BILD,"gif") IF BILD'="html.gif" write " "
            if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              if (mOp.Logical(m$.Fnc.$find(BILD.get(),"gif"))) {
                if (mOp.NotEqual(BILD.get(),"html.gif")) {
                  m$.Cmd.Write(" ");
                }
              }
            }
          }
          //<< . . . ;
          //<< . . . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
          if (mOp.Equal(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top vspace=0>"));
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
          }
        }
        //<< . . ;
        //<< . . IF YB1END=1 DO
        if (mOp.Equal(YB1END.get(),1)) {
          //<< . . . SET BPLUS="eplus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
          mVar BPLUS = m$.var("BPLUS");
          BPLUS.set("eplus.gif");
          if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
            BPLUS.set("lplus.gif");
          }
          //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
          if (mOp.NotEqual(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)=""  WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              }
            }
            //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" IF $FIND(BILD,"gif") IF BILD'="html.gif" write " "
            if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              if (mOp.Logical(m$.Fnc.$find(BILD.get(),"gif"))) {
                if (mOp.NotEqual(BILD.get(),"html.gif")) {
                  m$.Cmd.Write(" ");
                }
              }
            }
          }
          //<< . . . ;
          //<< . . . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
          if (mOp.Equal(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top vspace=0>"));
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
          }
        }
      }
      //<< . ;
      //<< . IF YP1END=0 DO
      if (mOp.Equal(YP1END.get(),0)) {
        //<< . . IF YB1END=0 DO
        if (mOp.Equal(YB1END.get(),0)) {
          //<< . . . SET BPLUS="plus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="eplus.gif"
          mVar BPLUS = m$.var("BPLUS");
          BPLUS.set("plus.gif");
          if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
            BPLUS.set("eplus.gif");
          }
          //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
          if (mOp.NotEqual(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)=""  WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              }
            }
            //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" IF $FIND(BILD,"gif") IF BILD'="html.gif" write " "
            if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              if (mOp.Logical(m$.Fnc.$find(BILD.get(),"gif"))) {
                if (mOp.NotEqual(BILD.get(),"html.gif")) {
                  m$.Cmd.Write(" ");
                }
              }
            }
          }
          //<< . . . ;
          //<< . . . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
          if (mOp.Equal(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top vspace=0>"));
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
          }
        }
        //<< . . ;
        //<< . . IF YB1END=1 DO
        if (mOp.Equal(YB1END.get(),1)) {
          //<< . . . SET BPLUS="eplus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
          mVar BPLUS = m$.var("BPLUS");
          BPLUS.set("eplus.gif");
          if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
            BPLUS.set("lplus.gif");
          }
          //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
          if (mOp.NotEqual(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)=""  WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              }
            }
            //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" IF $FIND(BILD,"gif") IF BILD'="html.gif" write " "
            if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              if (mOp.Logical(m$.Fnc.$find(BILD.get(),"gif"))) {
                if (mOp.NotEqual(BILD.get(),"html.gif")) {
                  m$.Cmd.Write(" ");
                }
              }
            }
          }
          //<< . . . ;
          //<< . . . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
          if (mOp.Equal(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top vspace=0>"));
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
          }
        }
      }
      //<< . ;
      //<< . ;I $D(^WWW0041(0,YAPP,YPROG1,$$^WWWLANGU(YBED),1)) S $P(YA,Y,1)=$P(^(1),Y,1)
      //<< . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<B>"
      if (mOp.Equal(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
        m$.Cmd.Write("<B>");
      }
      //<< . WRITE $$^WWWUML($PIECE(YA,Y,1))
      m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
      //<< . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "</B>"
      if (mOp.Equal(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
        m$.Cmd.Write("</B>");
      }
      //<< . ;IF YASTART=1 WRITE "</A>" DO EDITMENU(1)  ;FIS;20.05.03;23658;SHORT CUT MENU
      //<< . IF YANZ'="" IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO PROX
      if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
        if (mOp.Equal(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
          m$.Cmd.Do("PROX");
        }
      }
    } while(false);
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< PROX ;
  public void PROX() {
    //<< DO ^WWWMENUUX
    m$.Cmd.Do("WWWMENUUX.main");
    //<< QUIT
    return;
  }

  //<< 
  //<< STAT ;STATUS
  public void STAT() {
    //<< WRITE " TITLE="_""""_$PIECE(YA,Y,1)
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),1)));
    //<< WRITE " ("_$GET(YPROG)
    m$.Cmd.Write(mOp.Concat(" (",m$.Fnc.$get(m$.var("YPROG"))));
    //<< IF YBEDBER=1 WRITE " "_$PIECE(YA,Y,2)
    if (mOp.Equal(m$.var("YBEDBER").get(),1)) {
      m$.Cmd.Write(mOp.Concat(" ",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),2)));
    }
    //<< WRITE ")"
    m$.Cmd.Write(")");
    //<< WRITE """"
    m$.Cmd.Write("\"");
    //<< QUIT
    return;
  }

  //<< 
  //<< STAT1 ;STATUS
  public void STAT1() {
    //<< WRITE " TITLE="_""""_$PIECE(YA,Y,1)
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),1)));
    //<< WRITE " ("_$GET(YPROG1)
    m$.Cmd.Write(mOp.Concat(" (",m$.Fnc.$get(m$.var("YPROG1"))));
    //<< IF YBEDBER=1 WRITE " "_$PIECE(YA,Y,2)
    if (mOp.Equal(m$.var("YBEDBER").get(),1)) {
      m$.Cmd.Write(mOp.Concat(" ",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),2)));
    }
    //<< WRITE ")"
    m$.Cmd.Write(")");
    //<< WRITE """"
    m$.Cmd.Write("\"");
    //<< QUIT
    return;
  }

  //<< 
  //<< EDITMENU(NO) ;EINSPRUNG NACH WWW004;FIS;20.05.03;23658;SHORT CUT MENU
  public Object EDITMENU(Object ... _p) {
    mVar NO = m$.newVarRef("NO",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< QUIT:$PIECE($GET(^WWW012(0,YM,1)),Y,1)'="INTRAPREND"  ;NUR INTRAPREND ;only
    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),1),"INTRAPREND")) {
      return null;
    }
    //<< QUIT:+$$^WWWBEDBER(YBED)'=1  ;NUR SYSTEMADMIN ;only
    if (mOp.NotEqual(mOp.Positive(m$.fnc$("WWWBEDBER.main",m$.var("YBED").get())),1)) {
      return null;
    }
    //<< WRITE "&nbsp;",YCR
    m$.Cmd.Write("&nbsp;",m$.var("YCR").get());
    do {
      //<< DO
      //<< . NEW YFORM,YKEY,NUMBER
      mVar YFORM = m$.var("YFORM");
      mVar YKEY = m$.var("YKEY");
      mVar NUMBER = m$.var("NUMBER");
      m$.newVarBlock(1,YFORM,YKEY,NUMBER);
      //<< . SET NUMBER=YPROG
      NUMBER.set(m$.var("YPROG").get());
      //<< . IF $GET(NO)=1 SET NUMBER=YPROG1
      if (mOp.Equal(m$.Fnc.$get(NO),1)) {
        NUMBER.set(m$.var("YPROG1").get());
      }
      //<< . IF $GET(NO)=2 SET NUMBER=YPROG2
      if (mOp.Equal(m$.Fnc.$get(NO),2)) {
        NUMBER.set(m$.var("YPROG2").get());
      }
      //<< . IF $GET(NO)=3 SET NUMBER=YPROG3
      if (mOp.Equal(m$.Fnc.$get(NO),3)) {
        NUMBER.set(m$.var("YPROG3").get());
      }
      //<< . IF $GET(NO)=4 SET NUMBER=YPROG4
      if (mOp.Equal(m$.Fnc.$get(NO),4)) {
        NUMBER.set(m$.var("YPROG4").get());
      }
      //<< . WRITE "<A HREF="_""""_YAKTION_"EP=WWWFORM&amp;YFORM=WWW004&amp;YKEY="_YAPP_","_NUMBER
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWW004&amp;YKEY="),m$.var("YAPP").get()),","),NUMBER.get()));
      //<< . DO ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< . WRITE """"
      m$.Cmd.Write("\"");
      //<< . WRITE " TARGET="_""""_YTARGET_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.var("YTARGET").get()),"\""));
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . QUIT
      break;
    } while(false);
    m$.restoreVarBlock(1);
    //<< WRITE "&nbsp;"
    m$.Cmd.Write("&nbsp;");
    //<< WRITE "</a>",YCR
    m$.Cmd.Write("</a>",m$.var("YCR").get());
    //<< QUIT
    return null;
  }

//<< /*
//<< WRITE "&nbsp;"
//<< WRITE "</a>",YCR
//<< QUIT
//<< */
}
