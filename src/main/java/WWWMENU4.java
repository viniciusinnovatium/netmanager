//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMENU4
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:24
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

//<< WWWMENU4
public class WWWMENU4 extends mClass {

  public void main() {
    _WWWMENU4();
  }

  public void _WWWMENU4() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       MENU AUFGEHEND PLUS-MINUS
    //<< ;       Type 3 Explorer Menu
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
    //<< ; 17-Oct-2007   GRF     SR15563: Doco; simple brace; !=>||; expand commands; naked references
    //<< ; 17-Oct-2005   PO      SR13680: commented out - I $P(YA,Y,7)="CGI" W "?dummy=0" D ^WWWCGI
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 24-MAR-2005   TYBD    CHANGE INTRAPREND TO DISCLINC FOR CHARTS
    //<< ; 23.04.1998    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< NEW BILD
    mVar BILD = m$.var("BILD");
    m$.newVar(BILD);
    //<< 
    //<< ;---------------------------------------
    //<< ;  YVOR     objWWW012
    //<< ;       D2      $$$WWW012PictureAsMenuHeader()
    //<< ;       D11     $$$WWW012HeaderTextUnderPicture()
    //<< ;       D19     $$$WWW012TargetFrameName()
    //<< ;       D20     $$$WWW012MenuFramed()
    //<< ;       D21     $$$WWW012MenuCentered()
    //<< ;---------------------------------------
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
    //<< IF $PIECE(YVOR,Y,20) = $$$YES {
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),20),include.COMSYS.$$$YES(m$))) {
      //<< WRITE YCR,"<TABLE BORDER=1 VALIGN=TOP CELLSPACING=0><TR><TD NOWRAP>"
      m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=1 VALIGN=TOP CELLSPACING=0><TR><TD NOWRAP>");
    }
    //<< } else {
    else {
      //<< WRITE "<NOBR>"
      m$.Cmd.Write("<NOBR>");
    }
    //<< }
    //<< 
    //<< IF YANZ="" WRITE "<A NAME='TARGET'></A>"
    if (mOp.Equal(m$.var("YANZ").get(),"")) {
      m$.Cmd.Write("<A NAME='TARGET'></A>");
    }
    do {
      //<< 
      //<< ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK STARTS
      //<< /*
      //<< ;I YANZ'="" D
      //<< . NEW YANZ
      //<< . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
      //<< . SET YANZ=""
      //<< . DO ^WWWCGI
      //<< . WRITE """"
      //<< . WRITE ">"
      //<< */
      //<< ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
      //<< 
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< ; COMPANY NAME                 (_)(O)(X)      ^WWWMENU                     .gif files
      //<< ;---------------------------------------
      //<< ; (*) Table of Contents  [!]                  (* 1 *)
      //<< ; (-) (o) @net Manager                     +
      //<< ;  |  (+) (c) Classes And Forms            |                        iplus / plus  / oclose
      //<< ;  |  (-) (o) Company Parameter            |                        iplus / minus / oopen
      //<< ;  |       L  (?) Edit General ...         |  PGM^WWWMENU4
      //<< ;  |       L  (?) Enter Perm   ...         |
      //<< ;  |       L  ...                          |                        iplus / bplus / tplus / ?=image (BILD : default html.gif)
      //<< ;  |       L  (?) Program Version          |             <= YEND=1  iplus / bplus / lplus / ?
      //<< ;  |  (+) (c) Utility Programs             |
      //<< ;  |  ...                                  |
      //<< ; (+) (c) AlphaLinc                        |
      //<< ; ...                                      |
      //<< ; (+) (c) Tools                            +             <= YEND=1  eplus / oclose
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< 
      //<< 
      //<< DO
      //<< . ;NEW HTML
      //<< . Set InnovOldHTML = $Get(HTML)
      mVar InnovOldHTML = m$.var("InnovOldHTML");
      InnovOldHTML.set(m$.Fnc.$get(m$.var("HTML")));
      //<< . SET HTML="blank.htm"
      mVar HTML = m$.var("HTML");
      HTML.set("blank.htm");
      //<< . ;IF YBER=1 IF YMANDANT="Development" IF $GET(SPRACHE)="DE" SET HTML="blank1.htm"
      //<< . ;WRITE "<A HREF="_""""_YGIF_HTML_""""
      //<< . WRITE "<A HREF="
      m$.Cmd.Write("<A HREF=");
      //<< . DO
      do {
        //<< . . ;NEW YFORM,YKEY
        //<< . . Set InnovOldYFORM = YFORM, InnovOldYKEY = YKEY kill YFORM,YKEY
        mVar InnovOldYFORM = m$.var("InnovOldYFORM");
        InnovOldYFORM.set(m$.var("YFORM").get());
        mVar InnovOldYKEY = m$.var("InnovOldYKEY");
        InnovOldYKEY.set(m$.var("YKEY").get());
        m$.var("YFORM").kill();
        m$.var("YKEY").kill();
        //<< . . WRITE """"
        m$.Cmd.Write("\"");
        //<< . . ;WRITE YAKTION_"EP=WWWFORM&YFORM=WWW1264Search"
        //<< . . WRITE YAKTION_"EP=WWWFORM&amp;YFORM=WWWBLANK"
        m$.Cmd.Write(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM=WWWBLANK"));
        //<< . . DO ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< . . ;
        //<< . . WRITE """"  ;_">"
        m$.Cmd.Write("\"");
        //<< . . Set YFORM = InnovOldYFORM, YKEY = InnovOldYKEY
        mVar YFORM = m$.var("YFORM");
        YFORM.set(InnovOldYFORM.get());
        mVar YKEY = m$.var("YKEY");
        YKEY.set(InnovOldYKEY.get());
      } while(false);
      //<< . ;
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
      //<< . Set HTML = InnovOldHTML
      HTML.set(InnovOldHTML.get());
    } while(false);
    do {
      //<< 
      //<< ;IF $PIECE(YVOR,Y,19)="" DO  ;MENU-KOPFBILD
      //<< DO                            ;BEC;26818;19.11.04
      //<< . IF $PIECE(YVOR,Y,2)'="" DO
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),2),"")) {
        do {
          //<< . . QUIT:$PIECE(YVOR,Y,2)="intraprend.gif"               ;tybd;fast überall eingetragen und falsch
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),2),"intraprend.gif")) {
            break;
          }
          //<< . . IF $PIECE(YVOR,Y,21) = $$$YES WRITE "<CENTER>"
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),21),include.COMSYS.$$$YES(m$))) {
            m$.Cmd.Write("<CENTER>");
          }
          //<< . . WRITE "<IMG SRC="_""""_YGIF_$PIECE(YVOR,Y,2)_""""_" BORDER=0>"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),2)),"\"")," BORDER=0>"));
          //<< . . IF $PIECE(YVOR,Y,21) = $$$YES WRITE "</CENTER>"
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),21),include.COMSYS.$$$YES(m$))) {
            m$.Cmd.Write("</CENTER>");
          }
          //<< . . WRITE "<BR>"
          m$.Cmd.Write("<BR>");
        } while (false);
      }
      //<< . WRITE YCR
      m$.Cmd.Write(m$.var("YCR").get());
    } while(false);
    //<< 
    //<< ;---------------------------------------
    //<< ; (* 1 *)
    //<< ;---------------------------------------
    //<< WRITE "<IMG SRC="_""""_YGIF_"aplatz.gif"_""""_" align=top vspace=0 hspace=0 border=0>"  ; ALIGN=TOP>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"aplatz.gif"),"\"")," align=top vspace=0 hspace=0 border=0>"));
    //<< WRITE $PIECE(YVOR,Y,11)
    m$.Cmd.Write(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11));
    //<< WRITE "</A>"
    m$.Cmd.Write("</A>");
    //<< 
    //<< SET YQ=$ORDER(^WWWWV(YM,YBED,""))
    mVar YQ = m$.var("YQ");
    YQ.set(m$.Fnc.$order(m$.var("^WWWWV",m$.var("YM").get(),m$.var("YBED").get(),"")));
    //<< IF YQ'="" IF (YQ=+$HOROLOG) || (YQ<$HOROLOG) DO  ;WIEDERVORLAGEN VORHANDEN ;on hand
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
        //<< . ;WRITE "<img src="_""""_YGIF_"pin.gif"_""""_" border=0 height=14>"
        //<< . WRITE "</FONT>"
        m$.Cmd.Write("</FONT>");
        //<< . WRITE "</A>"
        m$.Cmd.Write("</A>");
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< DO PGM
    m$.Cmd.Do("PGM");
    //<< IF $PIECE(YVOR,Y,20) = $$$YES {
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),20),include.COMSYS.$$$YES(m$))) {
      //<< WRITE YCR,"</TD></TR></TABLE>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
    }
    //<< } else {
    else {
      //<< WRITE "</NOBR>"
      m$.Cmd.Write("</NOBR>");
    }
    //<< }
    //<< QUIT
    return;
  }

  //<< 
  //<< PGM ;
  public void PGM() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; YQ        Authorisation check : 0 permitted to show menu entry, 1 Don't show
    //<< ; YEND      Last entry in chain : 0 Not Last, 1 Last
    //<< ; YA        objMenu (^WWW004)
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< SET YAPP=""
    mVar YAPP = m$.var("YAPP");
    YAPP.set("");
    //<< FOR  SET YAPP=$ORDER(^WWW004(0,YAPP)) QUIT:YAPP=""  DO
    for (;true;) {
      YAPP.set(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get())));
      if (mOp.Equal(YAPP.get(),"")) {
        break;
      }
      do {
        //<< . SET YEND=0
        mVar YEND = m$.var("YEND");
        YEND.set(0);
        //<< . IF $ORDER(^WWW004(0,YAPP))="" SET YEND=1
        if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get())),"")) {
          YEND.set(1);
        }
        //<< . ;
        //<< . IF YAPP=YANZ WRITE "<A NAME='TARGET'></A>"
        if (mOp.Equal(YAPP.get(),m$.var("YANZ").get())) {
          m$.Cmd.Write("<A NAME='TARGET'></A>");
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ; Access Check
        //<< . ;-------------------------------------
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
            //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROG_";") SET YQ=0 QUIT   ;BERECHTIGT;TYBD;7,1,2004
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),YAPP.get())))) {
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),YAPP.get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROG.get()),";")))) {
                YQ.set(0);
                break;
              }
            }
            //<< . . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
            mVar YA = m$.var("YA");
            YA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),YPROG.get(),1)));
            //<< . . QUIT:$PIECE(YA,Y,7)="noshow"                                      ;keine anzeige ;None
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"noshow")) {
              break;
            }
            //<< . . IF $FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") SET YQ=0 QUIT
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
              YQ.set(0);
              break;
            }
            //<< . . IF $$^WWWACCESS($PIECE(YA,Y,3),$PIECE(YA,Y,4))=1                  SET YQ=0 QUIT  ;ZUGANG
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
        //<< . ;-------------------------------------
        //<< . ; Version Tooltip where appropriate
        //<< . ;-------------------------------------
        //<< . WRITE "<BR>"
        m$.Cmd.Write("<BR>");
        //<< . WRITE YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . IF (YANZ="") || ($PIECE(YANZ,",",1)'=YAPP) DO
        if ((mOp.Equal(m$.var("YANZ").get(),"")) || (mOp.NotEqual(m$.Fnc.$piece(m$.var("YANZ").get(),",",1),YAPP.get()))) {
          //<< . . ;NEW YANZ
          //<< . . SET InnovOld = YANZ kill YANZ
          mVar InnovOld = m$.var("InnovOld");
          InnovOld.set(m$.var("YANZ").get());
          m$.var("YANZ").kill();
          //<< . . WRITE "<A"
          m$.Cmd.Write("<A");
          //<< . . IF $DATA(^WWWVERSION(0,YAPP,1)) WRITE " TITLE="_""""_$$^WWWTEXT(253)_" "_$PIECE($GET(^WWWVERSION(0,YAPP,1)),Y,1)_""""    ;VERSION;BEC;23699;YM DURCH 0 ERSETZT,SPRACHENTEXT;26.05.03
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWVERSION",0,YAPP.get(),1)))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.fnc$("WWWTEXT.main",253))," "),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWVERSION",0,YAPP.get(),1)),m$.var("Y").get(),1)),"\""));
          }
          //<< . . WRITE " HREF="_""""_YAKTION_"EP=WWWMENU"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
          //<< . . SET YANZ=YAPP
          mVar YANZ = m$.var("YANZ");
          YANZ.set(YAPP.get());
          //<< . . DO ^WWWCGI
          m$.Cmd.Do("WWWCGI.main");
          //<< . . WRITE """"
          m$.Cmd.Write("\"");
          //<< . . WRITE ">"
          m$.Cmd.Write(">");
          //<< . . SET YANZ = InnovOld
          YANZ.set(InnovOld.get());
        }
        //<< . ;
        //<< . IF YANZ'="" IF $PIECE(YANZ,",",1)=YAPP DO
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YANZ").get(),",",1),YAPP.get())) {
            //<< . . ;NEW YANZ
            //<< . . SET InnovOld = YANZ kill YANZ
            mVar InnovOld = m$.var("InnovOld");
            InnovOld.set(m$.var("YANZ").get());
            m$.var("YANZ").kill();
            //<< . . WRITE "<A"
            m$.Cmd.Write("<A");
            //<< . . IF $DATA(^WWWVERSION(0,YAPP,1)) WRITE " TITLE="_""""_$$^WWWTEXT(253)_" "_$PIECE($GET(^WWWVERSION(0,YAPP,1)),Y,1)_""""   ;VERSION;BEC;23699;YM DURCH 0 ERSETZT,SPRACHENTEXT;26.05.03
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWVERSION",0,YAPP.get(),1)))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.fnc$("WWWTEXT.main",253))," "),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWVERSION",0,YAPP.get(),1)),m$.var("Y").get(),1)),"\""));
            }
            //<< . . WRITE " HREF="_""""_YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
            //<< . . SET YANZ=""
            mVar YANZ = m$.var("YANZ");
            YANZ.set("");
            //<< . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . WRITE ">"
            m$.Cmd.Write(">");
            //<< . . SET YANZ = InnovOld
            YANZ.set(InnovOld.get());
          }
        }
        //<< . ;
        //<< . ;-------------------------------------
        //<< . ;-------------------------------------
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
              //<< . . IF YEND=0 do  quit
              if (mOp.Equal(YEND.get(),0)) {
                //<< . . . WRITE "<IMG SRC="_""""_YGIF_"plus.gif"_""""_" align=top border=0 vspace=0 hspace=0>"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"plus.gif"),"\"")," align=top border=0 vspace=0 hspace=0>"));
                //<< . . . WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
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
            //<< . . IF YEND=0  WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" align=top  border=0 vspace=0 hspace=0>"
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
        //<< . SET YAPPP=YAPP
        mVar YAPPP = m$.var("YAPPP");
        YAPPP.set(YAPP.get());
        //<< . IF $PIECE($GET(^WWW00411(0,YAPP,SPRACHE,1)),Y,1)'="" SET YAPPP=$PIECE(^WWW00411(0,YAPP,SPRACHE,1),Y,1)  ;LANGUAGETEXT OF APPLICATION;TYBD;30.8.2004    ; SR15563 Naked Ref
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW00411",0,YAPP.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
          YAPPP.set(m$.Fnc.$piece(m$.var("^WWW00411",0,YAPP.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . IF YANZ'="" IF YAPP=$PIECE(YANZ,",",1) WRITE "<B>"
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(YAPP.get(),m$.Fnc.$piece(m$.var("YANZ").get(),",",1))) {
            m$.Cmd.Write("<B>");
          }
        }
        //<< . IF $FIND(YAPPP,"'") SET YAPPP=$$^WWWTRANSLATE(YAPPP,"'","&#146;")
        if (mOp.Logical(m$.Fnc.$find(YAPPP.get(),"'"))) {
          YAPPP.set(m$.fnc$("WWWTRANSLATE.main",YAPPP.get(),"'","&#146;"));
        }
        //<< . WRITE $TRANSLATE($$^WWWUML(YAPPP),"_"," ")
        m$.Cmd.Write(m$.Fnc.$translate(m$.fnc$("WWWUML.main",YAPPP.get()),"_"," "));
        //<< . IF YANZ'="" IF YAPP=$PIECE(YANZ,",",1) WRITE "</B>"
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(YAPP.get(),m$.Fnc.$piece(m$.var("YANZ").get(),",",1))) {
            m$.Cmd.Write("</B>");
          }
        }
        //<< . WRITE "</A>"
        m$.Cmd.Write("</A>");
        //<< . DO EDITMENU(0)  ;FIS;20.05.03;23658;SHORT CUT MENU
        m$.Cmd.Do("EDITMENU",0);
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
    //<< FOR  SET YPROG=$ORDER(^WWW004(0,YAPP,YPROG)) QUIT:YPROG=""  DO BER1
    for (;true;) {
      YPROG.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG.get())));
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
      //<< . SET YBEND=0  IF $PIECE($ORDER(^WWW004(0,YAPP,""),-1),".",1) =$PIECE(YPROG,".",1) SET YBEND=1
      mVar YBEND = m$.var("YBEND");
      YBEND.set(0);
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),""),mOp.Negative(1)),".",1),m$.Fnc.$piece(m$.var("YPROG").get(),".",1))) {
        YBEND.set(1);
      }
      //<< . SET YP0END=0 IF $PIECE($ORDER(^WWW004(0,YAPP,YPROG)),".",1)'=$PIECE(YPROG,".",1) SET YP0END=1
      mVar YP0END = m$.var("YP0END");
      YP0END.set(0);
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),m$.var("YPROG").get())),".",1),m$.Fnc.$piece(m$.var("YPROG").get(),".",1))) {
        YP0END.set(1);
      }
      //<< . SET YQ=0
      mVar YQ = m$.var("YQ");
      YQ.set(0);
      //<< . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
      mVar YA = m$.var("YA");
      YA.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),m$.var("YPROG").get(),1)));
      //<< . QUIT:$PIECE(YA,Y,7)="noshow"  ;keine anzeige ;None
      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"noshow")) {
        break;
      }
      //<< . SET BILD="html.gif"  ;VORGABE ;handicap  ;default
      mVar BILD = m$.var("BILD");
      BILD.set("html.gif");
      //<< . IF $PIECE(YA,Y,8)'=""     SET BILD=$PIECE(YA,Y,8)      ;NEUES BILD ;something new portrait
      if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),"")) {
        BILD.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8));
      }
      //<< . IF $PIECE(YVOR,Y,102)'="" SET BILD=$PIECE(YVOR,Y,102)  ;FESTE VORGABE ;default
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),102),"")) {
        BILD.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),102));
      }
      //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" SET YQ=1 SET YPROGP=YPROG FOR  SET YPROGP=$ORDER(^WWW004(0,YAPP,YPROGP)) QUIT:$EXTRACT(YPROGP,1,$LENGTH(YPROG))'=YPROG  QUIT:YPROGP=""  DO  QUIT:YQ=0
      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          YQ.set(1);
          mVar YPROGP = m$.var("YPROGP");
          YPROGP.set(m$.var("YPROG").get());
          for (;true;) {
            YPROGP.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGP.get())));
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
              //<< . . SET YA1=$GET(^WWW004(0,YAPP,YPROGP,1))
              mVar YA1 = m$.var("YA1");
              YA1.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGP.get(),1)));
              //<< . . IF $FIND(","_$TRANSLATE($PIECE(YA1,Y,6),";",",")_",",","_YBED_",") SET YQ=0 QUIT
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA1.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
                YQ.set(0);
                break;
              }
              //<< . . IF $$^WWWACCESS($PIECE(YA1,Y,3),$PIECE(YA1,Y,4))=1                 SET YQ=0 QUIT  ;ZUGANG
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
          //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROG_";") DO  SET YQ=0 QUIT  ;BERECHTIGT
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get())))) {
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",m$.var("YPROG").get()),";")))) {
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
      //<< . IF $DATA(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1))  SET $PIECE(YA,Y,1)=$PIECE(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1),Y,1)    ; SR15563 Naked Ref
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,m$.var("YAPP").get(),m$.var("YPROG").get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
        m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.var("^WWW0041",0,m$.var("YAPP").get(),m$.var("YPROG").get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1).get(),m$.var("Y").get(),1));
      }
      //<< . IF $PIECE($get(^WWW00441(0,YAPP,YPROG,1)),Y,1)'=""    SET $PIECE(YA,Y,1)=$PIECE(^WWW00441(0,YAPP,YPROG,1),Y,1)                     ; SR15563 Naked Ref
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW00441",0,m$.var("YAPP").get(),m$.var("YPROG").get(),1)),m$.var("Y").get(),1),"")) {
        m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.var("^WWW00441",0,m$.var("YAPP").get(),m$.var("YPROG").get(),1).get(),m$.var("Y").get(),1));
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
            //<< . . . ;NEW YANZ
            //<< . . . SET InnovOldYANZ = YANZ kill YANZ
            mVar InnovOldYANZ = m$.var("InnovOldYANZ");
            InnovOldYANZ.set(m$.var("YANZ").get());
            m$.var("YANZ").kill();
            //<< . . . SET YASTART=1
            YASTART.set(1);
            //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
            //<< . . . SET YANZ=YAPP_","_YPROG
            mVar YANZ = m$.var("YANZ");
            YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),m$.var("YPROG").get()));
            //<< . . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . . WRITE ">"
            m$.Cmd.Write(">");
            //<< . . . SET YANZ = InnovOldYANZ
            YANZ.set(InnovOldYANZ.get());
          }
          //<< . . ;
          //<< . . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") DO
          if (mOp.Equal(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
            //<< . . . ;NEW YANZ
            //<< . . . SET InnovOldYANZ = YANZ kill YANZ
            mVar InnovOldYANZ = m$.var("InnovOldYANZ");
            InnovOldYANZ.set(m$.var("YANZ").get());
            m$.var("YANZ").kill();
            //<< . . . SET YASTART=1
            YASTART.set(1);
            //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
            //<< . . . SET YANZ=YAPP
            mVar YANZ = m$.var("YANZ");
            YANZ.set(m$.var("YAPP").get());
            //<< . . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . . WRITE ">"
            m$.Cmd.Write(">");
            //<< . . . SET YANZ = InnovOldYANZ
            YANZ.set(InnovOldYANZ.get());
          }
        }
      }
      //<< . ;
      //<< . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") DO
      if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
        //<< . . SET YFORM=$PIECE(YA,Y,2)
        mVar YFORM = m$.var("YFORM");
        YFORM.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2));
        //<< . . IF $GET(YBEDMOD)'="" IF $DATA(^WWW00441(0,YAPP,YPROG,1)) DO  ;CHECK LESEBERECHTIGUNG;TYBD;04,07,2003;23883;
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBEDMOD")),"")) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW00441",0,m$.var("YAPP").get(),m$.var("YPROG").get(),1)))) {
            //<< . . . ;NEW MOD,ACCESS,YI
            //<< . . . SET InnovOldMOD=MOD,InnovOldACCESS=ACCESS,InnovOldYI=YI kill MOD,ACCESS,YI
            mVar InnovOldMOD = m$.var("InnovOldMOD");
            InnovOldMOD.set(m$.var("MOD").get());
            mVar InnovOldACCESS = m$.var("InnovOldACCESS");
            InnovOldACCESS.set(m$.var("ACCESS").get());
            mVar InnovOldYI = m$.var("InnovOldYI");
            InnovOldYI.set(m$.var("YI").get());
            m$.var("MOD").kill();
            m$.var("ACCESS").kill();
            m$.var("YI").kill();
            //<< . . . SET MOD=$TRANSLATE($PIECE(^WWW00441(0,YAPP,YPROG,1),Y,104),";",",")    ; SR15563 Naked Ref
            mVar MOD = m$.var("MOD");
            MOD.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("^WWW00441",0,m$.var("YAPP").get(),m$.var("YPROG").get(),1).get(),m$.var("Y").get(),104),";",","));
            //<< . . . IF MOD'="" DO  ;DAVON lESEBERECHTIGUNG
            if (mOp.NotEqual(MOD.get(),"")) {
              //<< . . . . SET ACCESS=0
              mVar ACCESS = m$.var("ACCESS");
              ACCESS.set(0);
              //<< . . . . FOR YI(2)=1:1 QUIT:$PIECE(YBEDMOD,",",YI(2))=""  IF $FIND(","_MOD_",",","_$PIECE(YBEDMOD,",",YI(2))_",") SET ACCESS=1 QUIT
              for (m$.var("YI",2).set(1);(true);m$.var("YI",2).set(mOp.Add(m$.var("YI",2).get(),1))) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YBEDMOD").get(),",",m$.var("YI").var(2).get()),"")) {
                  break;
                }
                if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",MOD.get()),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YBEDMOD").get(),",",m$.var("YI").var(2).get())),",")))) {
                  ACCESS.set(1);
                  break;
                }
              }
              //<< . . . . IF ACCESS=1 SET $PIECE(YA,Y,5)=5  ;NUR LESEBERECHTIGUNG ;only
              if (mOp.Equal(ACCESS.get(),1)) {
                m$.pieceVar(YA,m$.var("Y").get(),5).set(5);
              }
            }
            //<< . . . Set MOD = InnovOldMOD, ACCESS = InnovOldACCESS,YI = InnovOldYI
            MOD.set(InnovOldMOD.get());
            mVar ACCESS = m$.var("ACCESS");
            ACCESS.set(InnovOldACCESS.get());
            mVar YI = m$.var("YI");
            YI.set(InnovOldYI.get());
          }
        }
        //<< . . ;
        //<< . . SET YPARA=$PIECE(YA,Y,7)_Y_$PIECE(YA,Y,5)
        mVar YPARA = m$.var("YPARA");
        YPARA.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),m$.var("Y").get()),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),5)));
        //<< . . IF $PIECE(YA,Y,12)="" DO
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          //<< . . . ;NEW YNAME
          //<< . . . SET InnovOldYNAME = YNAME KILL YNAME
          mVar InnovOldYNAME = m$.var("InnovOldYNAME");
          InnovOldYNAME.set(m$.var("YNAME").get());
          m$.var("YNAME").kill();
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
          mVar YNAME = m$.var("YNAME");
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
          //<< . . . SET YNAME = InnovOldYNAME
          YNAME.set(InnovOldYNAME.get());
        }
        //<< . . ;
        //<< . . IF $PIECE(YA,Y,12)'="" DO  ;URL
        if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          //<< . . . SET YASTART=1
          YASTART.set(1);
          //<< . . . WRITE "<A HREF="_""""
          m$.Cmd.Write(mOp.Concat("<A HREF=","\""));
          //<< . . . ;WRITE $PIECE(YA,Y,12)
          //<< . . . WRITE $$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.1.2005
          m$.Cmd.Write(m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/")));
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
        //<< . . SET BPLUS="plus.gif" IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") SET BPLUS="tplus.gif"
        mVar BPLUS = m$.var("BPLUS");
        BPLUS.set("plus.gif");
        if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
          BPLUS.set("tplus.gif");
        }
        //<< . . IF YPROG'=($PIECE($PIECE(YANZ,",",2),".",1)_".") DO
        if (mOp.NotEqual(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
          //<< . . . IF ($PIECE(YA,Y,2)="")  && ($PIECE(YA,Y,12)="")  WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
          if ((mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) && (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
          }
          //<< . . . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" if $FIND(BILD,"gif") IF BILD'="html.gif" write " "
          if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
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
        //<< . . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".")    WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
        if (mOp.Equal(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top vspace=0>"));
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
        }
      }
      //<< . ;
      //<< . IF YBEND=1 DO
      if (mOp.Equal(YBEND.get(),1)) {
        //<< . . SET BPLUS="eplus.gif" IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
        mVar BPLUS = m$.var("BPLUS");
        BPLUS.set("eplus.gif");
        if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
          BPLUS.set("lplus.gif");
        }
        //<< . . IF YPROG'=($PIECE($PIECE(YANZ,",",2),".",1)_".") DO
        if (mOp.NotEqual(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
          //<< . . . IF ($PIECE(YA,Y,2)="")  && ($PIECE(YA,Y,12)="")  WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
          if ((mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) && (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
          }
          //<< . . . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" if $FIND(BILD,"gif") IF BILD'="html.gif" write " "
          if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
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
        //<< . . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".")    WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
        if (mOp.Equal(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top vspace=0>"));
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
        }
      }
      //<< . ;
      //<< . ;I $D(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1)) S $P(YA,Y,1)=$P(^(1),Y,1)  ; NAKED REFERENCE
      //<< . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") WRITE "<B>"
      if (mOp.Equal(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
        m$.Cmd.Write("<B>");
      }
      //<< . IF $FIND(YA,"'") SET YA=$$^WWWTRANSLATE(YA,"'","&#146;")
      if (mOp.Logical(m$.Fnc.$find(YA.get(),"'"))) {
        YA.set(m$.fnc$("WWWTRANSLATE.main",YA.get(),"'","&#146;"));
      }
      //<< . WRITE $$^WWWUML($PIECE(YA,Y,1))
      m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
      //<< . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") WRITE "</B>"
      if (mOp.Equal(m$.var("YPROG").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
        m$.Cmd.Write("</B>");
      }
      //<< . IF YASTART=1 WRITE "</A>" DO EDITMENU(0)  ;FIS;20.05.03;23658;SHORT CUT MENU
      if (mOp.Equal(YASTART.get(),1)) {
        m$.Cmd.Write("</A>");
        m$.Cmd.Do("EDITMENU",0);
      }
      //<< . IF $PIECE(YA,Y,21)'=""    DO CHART        ;EXTRACHART BEI MENUES;TYBD;4.09.2003 ;next to
      if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),21),"")) {
        m$.Cmd.Do("CHART");
      }
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
    //<< FOR  SET YPROG1=$ORDER(^WWW004(0,YAPP,YPROG1)) QUIT:YPROG1=""  QUIT:$EXTRACT(YPROG1,1,$LENGTH(YPROG))'=YPROG  DO PRO1
    for (;true;) {
      YPROG1.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG1.get())));
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
      //<< . SET YB1END=0 IF $PIECE($ORDER(^WWW004(0,YAPP,YPROG1_$CHAR(255))),".",1)'=$PIECE(YPROG1,".",1) SET YB1END=1
      mVar YB1END = m$.var("YB1END");
      YB1END.set(0);
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),mOp.Concat(m$.var("YPROG1").get(),m$.Fnc.$char(255)))),".",1),m$.Fnc.$piece(m$.var("YPROG1").get(),".",1))) {
        YB1END.set(1);
      }
      //<< . SET YP1END=0 IF $PIECE($ORDER(^WWW004(0,YAPP,YPROG1_$CHAR(255))),".",1,2)'=$PIECE(YPROG1,".",1,2) SET YP1END=1
      mVar YP1END = m$.var("YP1END");
      YP1END.set(0);
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),mOp.Concat(m$.var("YPROG1").get(),m$.Fnc.$char(255)))),".",1,2),m$.Fnc.$piece(m$.var("YPROG1").get(),".",1,2))) {
        YP1END.set(1);
      }
      //<< . SET YQ=0
      mVar YQ = m$.var("YQ");
      YQ.set(0);
      //<< . SET YA=$GET(^WWW004(0,YAPP,YPROG1,1))
      mVar YA = m$.var("YA");
      YA.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),m$.var("YPROG1").get(),1)));
      //<< . QUIT:$PIECE(YA,Y,7)="noshow"  ;keine anzeige ;None
      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"noshow")) {
        break;
      }
      //<< . SET BILD="html.gif"
      mVar BILD = m$.var("BILD");
      BILD.set("html.gif");
      //<< . IF $PIECE(YA,Y,8)'=""     SET BILD=$PIECE(YA,Y,8)
      if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),"")) {
        BILD.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8));
      }
      //<< . IF $PIECE(YVOR,Y,102)'="" SET BILD=$PIECE(YVOR,Y,102)  ;FESTE VORGABE ;default
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),102),"")) {
        BILD.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),102));
      }
      //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" SET YQ=1 SET YPROGP=YPROG1 FOR  SET YPROGP=$ORDER(^WWW004(0,YAPP,YPROGP)) QUIT:$EXTRACT(YPROGP,1,$LENGTH(YPROG1))'=YPROG1  QUIT:YPROGP=""  DO  QUIT:YQ=0
      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          YQ.set(1);
          mVar YPROGP = m$.var("YPROGP");
          YPROGP.set(m$.var("YPROG1").get());
          for (;true;) {
            YPROGP.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGP.get())));
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
              //<< . . SET YA1=$GET(^WWW004(0,YAPP,YPROGP,1))
              mVar YA1 = m$.var("YA1");
              YA1.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGP.get(),1)));
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
          //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROG1_";") Do  SET YQ=0 QUIT  ;BERECHTIGT
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get())))) {
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",m$.var("YPROG1").get()),";")))) {
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
      //<< . IF $DATA(^WWW0041(0,YAPP,YPROG1,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^WWW0041(0,YAPP,YPROG1,$$^WWWLANGU(YBED),1),Y,1)    ; SR15563 Naked Ref
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,m$.var("YAPP").get(),m$.var("YPROG1").get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
        m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.var("^WWW0041",0,m$.var("YAPP").get(),m$.var("YPROG1").get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1).get(),m$.var("Y").get(),1));
      }
      //<< . IF $PIECE($get(^WWW00441(0,YAPP,YPROG1,1)),Y,1)'=""   SET $PIECE(YA,Y,1)=$PIECE(^WWW00441(0,YAPP,YPROG1,1),Y,1)                     ; SR15563 Naked Ref
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW00441",0,m$.var("YAPP").get(),m$.var("YPROG1").get(),1)),m$.var("Y").get(),1),"")) {
        m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.var("^WWW00441",0,m$.var("YAPP").get(),m$.var("YPROG1").get(),1).get(),m$.var("Y").get(),1));
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
            //<< . . . ;NEW YANZ
            //<< . . . SET InnovOldYANZ = YANZ KILL YANZ
            mVar InnovOldYANZ = m$.var("InnovOldYANZ");
            InnovOldYANZ.set(m$.var("YANZ").get());
            m$.var("YANZ").kill();
            //<< . . . SET YASTART=1
            YASTART.set(1);
            //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
            //<< . . . SET YANZ=YAPP_","_YPROG1
            mVar YANZ = m$.var("YANZ");
            YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),m$.var("YPROG1").get()));
            //<< . . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . . WRITE ">"
            m$.Cmd.Write(">");
            //<< . . . SET YANZ = InnovOldYANZ
            YANZ.set(InnovOldYANZ.get());
          }
          //<< . . ;
          //<< . . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
          if (mOp.Equal(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            //<< . . . ;NEW YANZ
            //<< . . . SET InnovOldYANZ = YANZ KILL YANZ
            mVar InnovOldYANZ = m$.var("InnovOldYANZ");
            InnovOldYANZ.set(m$.var("YANZ").get());
            m$.var("YANZ").kill();
            //<< . . . SET YASTART=1
            YASTART.set(1);
            //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
            //<< . . . SET YANZ=YAPP_","_YPROG
            mVar YANZ = m$.var("YANZ");
            YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),m$.var("YPROG").get()));
            //<< . . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . . WRITE ">"
            m$.Cmd.Write(">");
            //<< . . . SET YANZ = InnovOldYANZ
            YANZ.set(InnovOldYANZ.get());
          }
        }
      }
      //<< . ;
      //<< . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") DO
      if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
        //<< . . SET YFORM=$PIECE(YA,Y,2)
        mVar YFORM = m$.var("YFORM");
        YFORM.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2));
        //<< . . IF $GET(YBEDMOD)'="" IF $DATA(^WWW00441(0,YAPP,YPROG1,1)) DO  ;CHECK LESEBERECHTIGUNG;TYBD;04,07,2003;23883;
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBEDMOD")),"")) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW00441",0,m$.var("YAPP").get(),m$.var("YPROG1").get(),1)))) {
            //<< . . . ;NEW MOD,ACCESS,YI
            //<< . . . SET InnovOldMOD=MOD,InnovOldACCESS=ACCESS,InnovOldYI=YI kill MOD,ACCESS,YI
            mVar InnovOldMOD = m$.var("InnovOldMOD");
            InnovOldMOD.set(m$.var("MOD").get());
            mVar InnovOldACCESS = m$.var("InnovOldACCESS");
            InnovOldACCESS.set(m$.var("ACCESS").get());
            mVar InnovOldYI = m$.var("InnovOldYI");
            InnovOldYI.set(m$.var("YI").get());
            m$.var("MOD").kill();
            m$.var("ACCESS").kill();
            m$.var("YI").kill();
            //<< . . . SET MOD=$TRANSLATE($PIECE(^WWW00441(0,YAPP,YPROG1,1),Y,104),";",",")     ; SR15563 Naked Ref
            mVar MOD = m$.var("MOD");
            MOD.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("^WWW00441",0,m$.var("YAPP").get(),m$.var("YPROG1").get(),1).get(),m$.var("Y").get(),104),";",","));
            //<< . . . IF MOD'="" DO  ;DAVON lESEBERECHTIGUNG
            if (mOp.NotEqual(MOD.get(),"")) {
              //<< . . . . SET ACCESS=0
              mVar ACCESS = m$.var("ACCESS");
              ACCESS.set(0);
              //<< . . . . FOR YI(2)=1:1 QUIT:$PIECE(YBEDMOD,",",YI(2))=""  IF $FIND(","_MOD_",",","_$PIECE(YBEDMOD,",",YI(2))_",") SET ACCESS=1 QUIT
              for (m$.var("YI",2).set(1);(true);m$.var("YI",2).set(mOp.Add(m$.var("YI",2).get(),1))) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YBEDMOD").get(),",",m$.var("YI").var(2).get()),"")) {
                  break;
                }
                if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",MOD.get()),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YBEDMOD").get(),",",m$.var("YI").var(2).get())),",")))) {
                  ACCESS.set(1);
                  break;
                }
              }
              //<< . . . . IF ACCESS=1 SET $PIECE(YA,Y,5)=5  ;NUR LESEBERECHTIGUNG ;only
              if (mOp.Equal(ACCESS.get(),1)) {
                m$.pieceVar(YA,m$.var("Y").get(),5).set(5);
              }
            }
            //<< . . . Set MOD = InnovOldMOD, ACCESS = InnovOldACCESS,YI = InnovOldYI
            MOD.set(InnovOldMOD.get());
            mVar ACCESS = m$.var("ACCESS");
            ACCESS.set(InnovOldACCESS.get());
            mVar YI = m$.var("YI");
            YI.set(InnovOldYI.get());
          }
        }
        //<< . . ;
        //<< . . SET YPARA=$PIECE(YA,Y,7)_Y_$PIECE(YA,Y,5)
        mVar YPARA = m$.var("YPARA");
        YPARA.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),m$.var("Y").get()),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),5)));
        //<< . . IF $PIECE(YA,Y,12)="" DO
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          //<< . . . ;NEW YNAME
          //<< . . . SET InnovOldYNAME = YNAME KILL YNAME
          mVar InnovOldYNAME = m$.var("InnovOldYNAME");
          InnovOldYNAME.set(m$.var("YNAME").get());
          m$.var("YNAME").kill();
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
          //<< . . . ;SET YNAME=$PIECE(YA,Y,1)
          //<< . . . SET YNAME=$$^WWWTRANSLATE($PIECE(YA,Y,1),"'","&#146;")  ;FIS;11.03.05;27395
          mVar YNAME = m$.var("YNAME");
          YNAME.set(m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1),"'","&#146;"));
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
          //<< . . . SET YNAME = InnovOldYNAME
          YNAME.set(InnovOldYNAME.get());
        }
        //<< . . ;
        //<< . . IF $PIECE(YA,Y,12)'="" DO  ;URL
        if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          //<< . . . SET YASTART=1
          YASTART.set(1);
          //<< . . . WRITE "<A HREF="_""""
          m$.Cmd.Write(mOp.Concat("<A HREF=","\""));
          //<< . . . ;WRITE $PIECE(YA,Y,12)
          //<< . . . WRITE $$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI
          m$.Cmd.Write(m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/")));
          //<< . . . IF $PIECE(YA,Y,7)="CGI" WRITE "?dummy=0" DO ^WWWCGI
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"CGI")) {
            m$.Cmd.Write("?dummy=0");
            m$.Cmd.Do("WWWCGI.main");
          }
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
          //<< . . . SET BPLUS="plus.gif"
          mVar BPLUS = m$.var("BPLUS");
          BPLUS.set("plus.gif");
          //<< . . . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") SET BPLUS="tplus.gif"
          if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
            BPLUS.set("tplus.gif");
          }
          //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
          if (mOp.NotEqual(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)=""       WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              }
            }
            //<< . . . . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" IF $FIND(BILD,"gif") IF BILD'="html.gif" write " "
            if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
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
          //<< . . . SET BPLUS="eplus.gif"
          mVar BPLUS = m$.var("BPLUS");
          BPLUS.set("eplus.gif");
          //<< . . . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
          if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
            BPLUS.set("lplus.gif");
          }
          //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
          if (mOp.NotEqual(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)=""       WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              }
            }
            //<< . . . . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" IF $FIND(BILD,"gif") IF BILD'="html.gif" write " "
            if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
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
          //<< . . . SET BPLUS="plus.gif"
          mVar BPLUS = m$.var("BPLUS");
          BPLUS.set("plus.gif");
          //<< . . . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") SET BPLUS="eplus.gif"
          if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
            BPLUS.set("eplus.gif");
          }
          //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
          if (mOp.NotEqual(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)=""       WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              }
            }
            //<< . . . . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" IF $FIND(BILD,"gif") IF BILD'="html.gif" write " "
            if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
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
          //<< . . . SET BPLUS="eplus.gif"
          mVar BPLUS = m$.var("BPLUS");
          BPLUS.set("eplus.gif");
          //<< . . . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
          if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
            BPLUS.set("lplus.gif");
          }
          //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
          if (mOp.NotEqual(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)=""       WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top vspace=0>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 vspace=0 ALIGN=TOP>"));
              }
            }
            //<< . . . . IF ($PIECE(YA,Y,2)'="") || ($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top vspace=0>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 vspace=0 ALIGN=TOP>" IF $FIND(BILD,"gif") IF BILD'="html.gif" write " "
            if ((mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) || (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),""))) {
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
      //<< . ;I $D(^WWW0041(0,YAPP,YPROG1,$$^WWWLANGU(YBED),1)) S $P(YA,Y,1)=$P(^(1),Y,1)    ; NAKED REFERENCE
      //<< . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<B>"
      if (mOp.Equal(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
        m$.Cmd.Write("<B>");
      }
      //<< . IF $FIND(YA,"'") SET YA=$$^WWWTRANSLATE(YA,"'","&#146;")
      if (mOp.Logical(m$.Fnc.$find(YA.get(),"'"))) {
        YA.set(m$.fnc$("WWWTRANSLATE.main",YA.get(),"'","&#146;"));
      }
      //<< . WRITE $$^WWWUML($PIECE(YA,Y,1))
      m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
      //<< . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "</B>"
      if (mOp.Equal(m$.var("YPROG1").get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
        m$.Cmd.Write("</B>");
      }
      //<< . IF YASTART=1 WRITE "</A>" DO EDITMENU(1)  ;FIS;20.05.03;23658;SHORT CUT MENU
      if (mOp.Equal(YASTART.get(),1)) {
        m$.Cmd.Write("</A>");
        m$.Cmd.Do("EDITMENU",1);
      }
      //<< . IF $PIECE(YA,Y,21)'=""    DO CHART  ;EXTRACHART BEI MENUES;TYBD;4,09,2003
      if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),21),"")) {
        m$.Cmd.Do("CHART");
      }
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
    //<< DO ^WWWMENUU
    m$.Cmd.Do("WWWMENUU.main");
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
    //<< ;QUIT:$PIECE($GET(^WWW012(0,YM,1)),Y,1)'="INTRAPREND"  ;NUR INTRAPREND
    //<< QUIT:+$$^WWWBEDBER(YBED)'=1  ;NUR SYSTEMADMIN ;only
    if (mOp.NotEqual(mOp.Positive(m$.fnc$("WWWBEDBER.main",m$.var("YBED").get())),1)) {
      return null;
    }
    //<< WRITE "&nbsp;",YCR
    m$.Cmd.Write("&nbsp;",m$.var("YCR").get());
    do {
      //<< DO
      //<< . ;NEW YFORM,YKEY,NUMBER
      //<< . SET InnovOldYFORM=$Get(FORM),InnovOldYKEY=$Get(YKEY),InnovOldNUMBER=$Get(NUMBER) KILL FORM,YKEY,NUMBER
      mVar InnovOldYFORM = m$.var("InnovOldYFORM");
      InnovOldYFORM.set(m$.Fnc.$get(m$.var("FORM")));
      mVar InnovOldYKEY = m$.var("InnovOldYKEY");
      InnovOldYKEY.set(m$.Fnc.$get(m$.var("YKEY")));
      mVar InnovOldNUMBER = m$.var("InnovOldNUMBER");
      InnovOldNUMBER.set(m$.Fnc.$get(m$.var("NUMBER")));
      m$.var("FORM").kill();
      m$.var("YKEY").kill();
      m$.var("NUMBER").kill();
      //<< . SET NUMBER=YPROG
      mVar NUMBER = m$.var("NUMBER");
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
      //<< . SET FORM=InnovOldYFORM,YKEY=InnovOldYKEY,NUMBER=InnovOldNUMBER
      mVar FORM = m$.var("FORM");
      FORM.set(InnovOldYFORM.get());
      mVar YKEY = m$.var("YKEY");
      YKEY.set(InnovOldYKEY.get());
      NUMBER.set(InnovOldNUMBER.get());
    } while(false);
    //<< 
    //<< WRITE "&nbsp;"
    m$.Cmd.Write("&nbsp;");
    //<< WRITE "</a>",YCR
    m$.Cmd.Write("</a>",m$.var("YCR").get());
    //<< QUIT
    return null;
  }

  //<< 
  //<< CHART ;EINSPRUNG NACH WWW004 ANZEIGE CHART;TYBD;4.09.2003 ;within Show
  public void CHART() {
    //<< IF SPRACHE="DE" {
    if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
      //<< SET $PIECE(YA,Y,21)=$PIECE($PIECE(YA,Y,21),",",1)
      m$.pieceVar(m$.var("YA"),m$.var("Y").get(),21).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),21),",",1));
    }
    //<< } else {
    else {
      //<< SET $PIECE(YA,Y,21)=$PIECE($PIECE(YA,Y,21),",",2)
      m$.pieceVar(m$.var("YA"),m$.var("Y").get(),21).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),21),",",2));
    }
    //<< }
    //<< QUIT:$PIECE(YA,Y,21)=""
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),21),"")) {
      return;
    }
    //<< 
    //<< IF $PIECE(YA,Y,21)="flow_software_de.gif" QUIT:$TRANSLATE("INTRAPREND","""")'=$TRANSLATE("I"_"N"_"T"_"R"_"A"_"P"_"R"_"E"_"N"_"D","""")  ;NUR WENN KEINE UMSETZTUNG ;only when no
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),21),"flow_software_de.gif")) {
      if (mOp.NotEqual(m$.Fnc.$translate("INTRAPREND","\""),m$.Fnc.$translate(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("I","N"),"T"),"R"),"A"),"P"),"R"),"E"),"N"),"D"),"\""))) {
        return;
      }
    }
    //<< WRITE "&nbsp;",YCR
    m$.Cmd.Write("&nbsp;",m$.var("YCR").get());
    //<< WRITE "<A HREF="_""""_YAKTION_"EP=WWWFORM&amp;YFORM=WWWBLANK&amp;YCHART="_$PIECE(YA,Y,21)
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWWBLANK&amp;YCHART="),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),21)));
    //<< DO ^WWWCGI
    m$.Cmd.Do("WWWCGI.main");
    //<< WRITE """"
    m$.Cmd.Write("\"");
    //<< WRITE " TITLE="_""""_$$^WWWTEXT(33609)_""""   ;CHART ANZEIGEN ;display
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.fnc$("WWWTEXT.main",33609)),"\""));
    //<< WRITE " TARGET="_""""_YTARGET_""""
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.var("YTARGET").get()),"\""));
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< WRITE "<img src="_""""_YGIF_"pin.gif"_""""_" border=0 height=14 align=top vspace=0 hspace=0>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<img src=","\""),m$.var("YGIF").get()),"pin.gif"),"\"")," border=0 height=14 align=top vspace=0 hspace=0>"));
    //<< WRITE "</a>",YCR
    m$.Cmd.Write("</a>",m$.var("YCR").get());
    //<< QUIT
    return;
  }

  //<< 
  //<< CHART1 ;ANZEIGEN CHART;FIS;11.05.04;25673
  public void CHART1() {
    //<< NEW PROG
    mVar PROG = m$.var("PROG");
    m$.newVar(PROG);
    //<< 
    //<< WRITE YCR,"<br>"
    m$.Cmd.Write(m$.var("YCR").get(),"<br>");
    //<< WRITE YCR,"<table border=0>"
    m$.Cmd.Write(m$.var("YCR").get(),"<table border=0>");
    //<< WRITE YCR,"<tr><td align=left valign=top nowrap>"
    m$.Cmd.Write(m$.var("YCR").get(),"<tr><td align=left valign=top nowrap>");
    //<< WRITE YCR,"<table border=0>"
    m$.Cmd.Write(m$.var("YCR").get(),"<table border=0>");
    //<< WRITE YCR,"<tr><td align=left valign=top nowrap>"
    m$.Cmd.Write(m$.var("YCR").get(),"<tr><td align=left valign=top nowrap>");
    //<< WRITE YCR,""
    m$.Cmd.Write(m$.var("YCR").get(),"");
    //<< WRITE YCR,"<font color=darkblue size=6><b>"
    m$.Cmd.Write(m$.var("YCR").get(),"<font color=darkblue size=6><b>");
    //<< ;WRITE YCR,$$^WWWUML("INTRAPREND",9)  ;WWWUMLAU DA GGF. ALTERNATIVER HERSTELLERNAME ;yonder
    //<< WRITE YCR,$$^WWWUML("Disclinc",9)  ;WWWUMLAU DA GGF. ALTERNATIVER HERSTELLERNAME ;yonder
    m$.Cmd.Write(m$.var("YCR").get(),m$.fnc$("WWWUML.main","Disclinc",9));
    //<< WRITE YCR,"&nbsp;"
    m$.Cmd.Write(m$.var("YCR").get(),"&nbsp;");
    //<< SET PROG=$TRANSLATE($PIECE($GET(YANZ),",",1),"_"," ")
    PROG.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YANZ")),",",1),"_"," "));
    //<< ;IF PROG="" SET PROG="WWS / PPS Manager"
    //<< IF PROG="" SET PROG="AlphaLinc"
    if (mOp.Equal(PROG.get(),"")) {
      PROG.set("AlphaLinc");
    }
    //<< SET PROG=$$^WWWUML(PROG,9)
    PROG.set(m$.fnc$("WWWUML.main",PROG.get(),9));
    //<< ;IF $FIND(PROG,"WWS / PPS") SET PROG=$PIECE(PROG,"WWS / PPS",1)_"<i>WWS / PPS</i>"_$PIECE(PROG,"WWS / PPS",2)  ;INTRAPREND WWS/PPS MANAGER ;WWS / PPS
    //<< ;WRITE YCR,$$^WWWUPER(PROG)
    //<< WRITE YCR,$zconvert(PROG,"U")
    m$.Cmd.Write(m$.var("YCR").get(),m$.Fnc.$zconvert(PROG.get(),"U"));
    //<< WRITE YCR,"</b></font>"
    m$.Cmd.Write(m$.var("YCR").get(),"</b></font>");
    //<< WRITE YCR,"</td><td align=left valign=top>"
    m$.Cmd.Write(m$.var("YCR").get(),"</td><td align=left valign=top>");
    //<< WRITE YCR,"<font color=darkblue size=3><sup>&reg;</sup></font>"  ;(R) - SYMPOL
    m$.Cmd.Write(m$.var("YCR").get(),"<font color=darkblue size=3><sup>&reg;</sup></font>");
    //<< WRITE YCR,"</td></tr>"
    m$.Cmd.Write(m$.var("YCR").get(),"</td></tr>");
    //<< WRITE YCR,"</table>"
    m$.Cmd.Write(m$.var("YCR").get(),"</table>");
    //<< WRITE YCR,"</td></tr>"
    m$.Cmd.Write(m$.var("YCR").get(),"</td></tr>");
    //<< WRITE YCR,"<tr><td align=left valign=top colspan=2>"
    m$.Cmd.Write(m$.var("YCR").get(),"<tr><td align=left valign=top colspan=2>");
    //<< WRITE "<img src="_YGIF_%(YQUERY,"YCHART")_">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<img src=",m$.var("YGIF").get()),m$.var("%",m$.var("YQUERY").get(),"YCHART").get()),">"));
    //<< WRITE YCR,"</td></tr>"
    m$.Cmd.Write(m$.var("YCR").get(),"</td></tr>");
    //<< WRITE YCR,"</table>"
    m$.Cmd.Write(m$.var("YCR").get(),"</table>");
    //<< QUIT
    return;
  }

}
