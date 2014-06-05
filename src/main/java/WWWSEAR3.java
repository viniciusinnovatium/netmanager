//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSEAR3
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:44
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

//<< WWWSEAR3
public class WWWSEAR3 extends mClass {

  public void main() {
    _WWWSEAR3();
  }

  public void _WWWSEAR3() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SUCHANZEIGE
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;   YSUCH
    //<< ;   YFORM
    //<< ;   YDATEI
    //<< ;   YSUCH1      objWWW123   FORMULAR; DATEI; SORTKEY; VORGABEKEY|VORGABEDATEN; ANZEIGE KEY;
    //<< ;                           ANZEIGEFELD; STD SORT; ANZEIGE ERGEBNIS; ORIENTIERUNG; ANZAHL ANZEIGEN;
    //<< ;                           FIXKEY; FELDER MIT SUMMENBILDUNG; WELCHEN KEY UEBERGEBEN; ; ; Header
    //<< ;
    //<< ;   YNOSORT     =ANZEIGE OHNE SORTIER MÖGLICHKEIT ;without possibility
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 03-May-2007   GRF     SR15509: Doco; brace format; quits; boolean macros
    //<< ; 30-May-2005   RobertW SR12056: Attempt at Performance Increase
    //<< ; 26.10.1999    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YADDS,YLFN,YA,YI,YSRI,YBEV,YSUCH3,TELYES,YDDSATZ,datei,YFARBCODE
    mVar YADDS = m$.var("YADDS");
    mVar YLFN = m$.var("YLFN");
    mVar YA = m$.var("YA");
    mVar YI = m$.var("YI");
    mVar YSRI = m$.var("YSRI");
    mVar YBEV = m$.var("YBEV");
    mVar YSUCH3 = m$.var("YSUCH3");
    mVar TELYES = m$.var("TELYES");
    mVar YDDSATZ = m$.var("YDDSATZ");
    mVar datei = m$.var("datei");
    mVar YFARBCODE = m$.var("YFARBCODE");
    m$.newVar(YADDS,YLFN,YA,YI,YSRI,YBEV,YSUCH3,TELYES,YDDSATZ,datei,YFARBCODE);
    //<< 
    //<< SET TELYES=+$PIECE($GET(^WWW012(0,YM,1)),Y,92)  ;MIT TELEFONANWAHL =1 ;by means of
    TELYES.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),92)));
    //<< SET YSUCH3=$GET(YSUCH)   ;LFD SUCHFUNKTION FÜR LÄNGE DER ANZEIGE DER EINZELFELDER ;to longitude the Show the
    YSUCH3.set(m$.Fnc.$get(m$.var("YSUCH")));
    //<< IF $GET(YFORM)=""  IF $PIECE($GET(YSUCH1),Y,1)'="" SET YFORM =$PIECE($GET(YSUCH1),Y,1)  ;TYBD;26.06.2003
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YSUCH1")),m$.var("Y").get(),1),"")) {
        mVar YFORM = m$.var("YFORM");
        YFORM.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YSUCH1")),m$.var("Y").get(),1));
      }
    }
    //<< IF $GET(YDATEI)="" IF $PIECE($GET(YSUCH1),Y,2)'="" SET YDATEI=$PIECE($GET(YSUCH1),Y,2)
    if (mOp.Equal(m$.Fnc.$get(m$.var("YDATEI")),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YSUCH1")),m$.var("Y").get(),2),"")) {
        mVar YDATEI = m$.var("YDATEI");
        YDATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YSUCH1")),m$.var("Y").get(),2));
      }
    }
    //<< IF YSUCH3="" SET YSUCH3=$ORDER(^WWW1232(0,YFORM,""))
    if (mOp.Equal(YSUCH3.get(),"")) {
      YSUCH3.set(m$.Fnc.$order(m$.var("^WWW1232",0,m$.var("YFORM").get(),"")));
    }
    //<< 
    //<< QUIT:$GET(YDATEI)=""   ;FINDEN BERECHTIGUNG ;find
    if (mOp.Equal(m$.Fnc.$get(m$.var("YDATEI")),"")) {
      return;
    }
    //<< 
    //<< IF $PIECE($GET(YVOR),Y,7)="" DO ^WWWFORMX  ;VORGABEN WWW120,WWW012
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR")),m$.var("Y").get(),7),"")) {
      m$.Cmd.Do("WWWFORMX.main");
    }
    //<< SET YMAXKEY=+$ORDER(^WWW002(0,YDATEI,""),-1)
    mVar YMAXKEY = m$.var("YMAXKEY");
    YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),""),mOp.Negative(1))));
    //<< IF '$DATA(YBER) DO
    if (mOp.Not(m$.Fnc.$data(m$.var("YBER")))) {
      //<< . SET YBEV=^WWW013(0,YBED,1)
      YBEV.set(m$.var("^WWW013",0,m$.var("YBED").get(),1).get());
      //<< . IF $GET(YM)="" SET YM=$PIECE(YBEV,Y,5)
      if (mOp.Equal(m$.Fnc.$get(m$.var("YM")),"")) {
        mVar YM = m$.var("YM");
        YM.set(m$.Fnc.$piece(YBEV.get(),m$.var("Y").get(),5));
      }
      //<< . IF YM="" SET YM=0
      if (mOp.Equal(m$.var("YM").get(),"")) {
        mVar YM = m$.var("YM");
        YM.set(0);
      }
      //<< . SET YBER=$PIECE(YBEV,Y,3)
      mVar YBER = m$.var("YBER");
      YBER.set(m$.Fnc.$piece(YBEV.get(),m$.var("Y").get(),3));
    }
    //<< 
    //<< IF $PIECE($GET(YSUCH1),Y,20)'="" DO
    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YSUCH1")),m$.var("Y").get(),20),"")) {
      //<< . WRITE YCR,"&nbsp;"
      m$.Cmd.Write(m$.var("YCR").get(),"&nbsp;");
      //<< . write "<FONT SIZE=2><B>"
      m$.Cmd.Write("<FONT SIZE=2><B>");
      //<< . DO
      do {
        //<< . . IF $EXTRACT($PIECE($GET(YSUCH1),Y,20),1,2)="::" WRITE $EXTRACT($PIECE(YSUCH1,Y,20),3,99) QUIT
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YSUCH1")),m$.var("Y").get(),20),1,2),"::")) {
          m$.Cmd.Write(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),20),3,99));
          break;
        }
        //<< . . WRITE $$^WWWTEXT($PIECE($GET(YSUCH1),Y,20))  ;POSITIONEN OHNE ERFASSTE ER ;without him
        m$.Cmd.Write(m$.fnc$("WWWTEXT.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("YSUCH1")),m$.var("Y").get(),20)));
      } while(false);
      //<< . ;
      //<< . WRITE "</B></FONT>",YCR
      m$.Cmd.Write("</B></FONT>",m$.var("YCR").get());
    }
    //<< 
    //<< IF $PIECE($GET(YSUCH1),Y,21)=$$$YES {
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YSUCH1")),m$.var("Y").get(),21),include.COMSYS.$$$YES(m$))) {
      //<< DO ^WWWFRAME(2)
      m$.Cmd.Do("WWWFRAME.main",2);
    }
    //<< } else {
    else {
      //<< DO ^WWWFRAME(0)
      m$.Cmd.Do("WWWFRAME.main",0);
    }
    //<< }
    //<< 
    //<< ;IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* SUCHERGEBNIS KOPF (WWWSEAR3)************************* -->",YCR,YCR
    //<< DO KOPF   ;ÜBERSCHRIFT ;superscription
    m$.Cmd.Do("KOPF");
    //<< ;IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* SUCHERGEBNIS DATEN (WWWSEAR3)************************* -->",YCR,YCR
    //<< 
    //<< DO ANZEIGE   ;DATENANZEGE
    m$.Cmd.Do("ANZEIGE");
    //<< IF $PIECE(YSUCH1,Y,12)'="" DO SUMME^WWWSEAR5  ;SUMMENZEILE
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),12),"")) {
      m$.Cmd.Do("WWWSEAR5.SUMME");
    }
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< DO ^WWWFRAME(1)
    m$.Cmd.Do("WWWFRAME.main",1);
    //<< ;W YCR,$G(YDDSATZ) ;ANZAHL DER DATENSÄTZE
    //<< QUIT
    return;
  }

  //<< 
  //<< KOPF ;ANZEIGEN KOPFLEISTE ;display
  public void KOPF() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-May-2007   GRF     SR15509: Doco; brace format; quits; boolean macros;
    //<< ;                       named references; close </FONT>
    //<< ; 05-Sep-2006   HEBERB  SRBR014194: No grid header when fieldname "_BLANK"
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YPRIMFIRST
    mVar YPRIMFIRST = m$.var("YPRIMFIRST");
    m$.newVar(YPRIMFIRST);
    //<< 
    //<< SET YPRIMFIRST=0
    YPRIMFIRST.set(0);
    //<< WRITE YCR,"<TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
    //<< 
    //<< ;PRIMÄRSCHÜSSEL
    //<< SET YLFN=""
    mVar YLFN = m$.var("YLFN");
    YLFN.set("");
    //<< FOR  SET YLFN=$ORDER(^WWW002(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      do {
        //<< . IF YFOART=3 QUIT:$ORDER(^WWW002(0,YDATEI,YLFN))=""        ;FÜR GRID ;to
        if (mOp.Equal(m$.var("YFOART").get(),3)) {
          if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get())),"")) {
            break;
          }
        }
        //<< . IF $PIECE(YSUCH1,Y,5)="" IF $PIECE(YSUCH1,Y,6)'="" QUIT   ;KEINE KEY WEIL NICHT AUSGEWÄHT ;no KEY since Not
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),5),"")) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),"")) {
            break;
          }
        }
        //<< . IF $PIECE(YSUCH1,Y,5)'="" IF $ORDER(^WWW002(0,YDATEI,YLFN))'="" QUIT:'$FIND(","_$TRANSLATE($PIECE(YSUCH1,Y,5),";",",")_",",","_YLFN_",")   ;NICHT AUSGEWÄHLT
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),5),"")) {
          if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get())),"")) {
            if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),5),";",",")),","),mOp.Concat(mOp.Concat(",",YLFN.get()),",")))) {
              break;
            }
          }
        }
        //<< . WRITE "<TH NOWRAP ALIGN=LEFT"
        m$.Cmd.Write("<TH NOWRAP ALIGN=LEFT");
        //<< . IF $PIECE(YVOR,Y,83)=""  WRITE " BGCOLOR="_YDARKGRAY
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
          m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YDARKGRAY").get()));
        }
        //<< . IF $PIECE(YVOR,Y,83)'="" WRITE " class=""header"""        ;FIS;CUSTOMER CSS STYLESHEET;08.12.04;26564
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
          m$.Cmd.Write(" class=\"header\"");
        }
        //<< . WRITE ">"
        m$.Cmd.Write(">");
        //<< . IF $PIECE(YVOR,Y,7)'=""  WRITE "<FONT SIZE="""_$PIECE(YVOR,Y,7)_""">"
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
        }
        //<< . DO
        do {
          //<< . . NEW YTEXT  ;TYB;10.07.2002 ; CUSTOMIZING MIT NAME IN HEADER
          mVar YTEXT = m$.var("YTEXT");
          m$.newVarBlock(2,YTEXT);
          //<< . . SET YTEXT=""
          YTEXT.set("");
          //<< . . IF YDATEI=$GET(YFORM) SET YTEXT=$$^WWWUML($$^WWWFELDNAME(YFORM,"P",YLFN),1)
          if (mOp.Equal(m$.var("YDATEI").get(),m$.Fnc.$get(m$.var("YFORM")))) {
            YTEXT.set(m$.fnc$("WWWUML.main",m$.fnc$("WWWFELDNAME.main",m$.var("YFORM").get(),"P",YLFN.get()),1));
          }
          //<< . . IF YTEXT="" IF $DATA(^WWW0021(0,YDATEI,YLFN,SPRACHE,1)) SET YTEXT=$$^WWWUML($PIECE($GET(^WWW0021(0,YDATEI,YLFN,SPRACHE,1)),Y,1),1)   ;TYBD;4,10,2004; QUIT ENTFERNT
          if (mOp.Equal(YTEXT.get(),"")) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0021",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
              YTEXT.set(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0021",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),1));
            }
          }
          //<< . . IF YTEXT="" SET YTEXT=$$^WWWUML($PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,2),1)
          if (mOp.Equal(YTEXT.get(),"")) {
            YTEXT.set(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),2),1));
          }
          //<< . . IF YSUCH3'="" IF $GET(YFORM)'="" IF +$PIECE($GET(^WWW1231(0,YFORM,YSUCH3,YLFN,1)),Y,2)'=0 DO   ;LÄNGENBEGRENZUNG ;TYBD;27,7,2004
          if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
              if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1231",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2)),0)) {
                //<< . . . SET YTEXT=$EXTRACT($GET(YTEXT),1,+$PIECE($GET(^WWW1231(0,YFORM,YSUCH3,YLFN,1)),Y,2))
                YTEXT.set(m$.Fnc.$extract(m$.Fnc.$get(YTEXT),1,mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1231",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2))));
              }
            }
          }
          //<< . . ;
          //<< . . WRITE YTEXT
          m$.Cmd.Write(YTEXT.get());
        } while(false);
        m$.restoreVarBlock(2);
        //<< . . ;IF $DATA(^WWW0021(0,YDATEI,YLFN,SPRACHE,1)) WRITE $$^WWWUML($PIECE($GET(^WWW0021(0,YDATEI,YLFN,SPRACHE,1)),Y,1),1) QUIT
        //<< . . ;WRITE $$^WWWUML($PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,2),1)
        //<< . ;
        //<< . IF YPRIMFIRST=0 DO  ;SORT
        if (mOp.Equal(YPRIMFIRST.get(),0)) {
          do {
            //<< . . QUIT:$GET(YNOSORT)=1   ;UNTERSORT AUSSCHALTEN ;eliminate
            if (mOp.Equal(m$.Fnc.$get(m$.var("YNOSORT")),1)) {
              break;
            }
            //<< . . ;
            //<< . . WRITE "<A"
            m$.Cmd.Write("<A");
            //<< . . WRITE " TITLE="""_$$^WWWTEXT(65)_""""              ;SORTIERUNG ;sorting
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",65)),"\""));
            //<< . . WRITE " HREF="""
            m$.Cmd.Write(" HREF=\"");
            //<< . . WRITE YAKTION_"EP=WWWSEAR&amp;YFORM="_YFORM_"&amp;YSORT=&amp;YFUNCT=3&amp;YORIENT=1&amp;YANZAHL="_$GET(YANZAHL)_"&amp;YSUCH="_$GET(YSUCH)_"&amp;YAUSWAHL=&amp;YVORGABE=&amp;YLFN=3"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWSEAR&amp;YFORM="),m$.var("YFORM").get()),"&amp;YSORT=&amp;YFUNCT=3&amp;YORIENT=1&amp;YANZAHL="),m$.Fnc.$get(m$.var("YANZAHL"))),"&amp;YSUCH="),m$.Fnc.$get(m$.var("YSUCH"))),"&amp;YAUSWAHL=&amp;YVORGABE=&amp;YLFN=3"));
            //<< . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . WRITE """> "
            m$.Cmd.Write("\"> ");
            //<< . . WRITE "<IMG SRC="""_YGIF_"scrup.gif"" BORDER=0>"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"scrup.gif\" BORDER=0>"));
            //<< . . WRITE "</A>"                                       ;ENDE SORT ;termination
            m$.Cmd.Write("</A>");
          } while (false);
        }
        //<< . ;
        //<< . IF YPRIMFIRST=0 DO
        if (mOp.Equal(YPRIMFIRST.get(),0)) {
          do {
            //<< . . QUIT:$GET(YNOSORT)=1   ;UNTERSORT AUSSCHALTEN ;eliminate
            if (mOp.Equal(m$.Fnc.$get(m$.var("YNOSORT")),1)) {
              break;
            }
            //<< . . WRITE "<A"
            m$.Cmd.Write("<A");
            //<< . . WRITE " TITLE="""_$$^WWWTEXT(65)_""""              ;SORTIERUNG ;sorting
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",65)),"\""));
            //<< . . WRITE " HREF="""
            m$.Cmd.Write(" HREF=\"");
            //<< . . WRITE YAKTION_"EP=WWWSEAR&amp;YFORM="_YFORM_"&amp;YSORT=&amp;YFUNCT=3&amp;YORIENT=0&amp;YANZAHL="_$GET(YANZAHL)_"&amp;YSUCH="_$GET(YSUCH)_"&amp;YAUSWAHL=&amp;YVORGABE="
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWSEAR&amp;YFORM="),m$.var("YFORM").get()),"&amp;YSORT=&amp;YFUNCT=3&amp;YORIENT=0&amp;YANZAHL="),m$.Fnc.$get(m$.var("YANZAHL"))),"&amp;YSUCH="),m$.Fnc.$get(m$.var("YSUCH"))),"&amp;YAUSWAHL=&amp;YVORGABE="));
            //<< . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . WRITE """> "
            m$.Cmd.Write("\"> ");
            //<< . . WRITE "<IMG SRC="""_YGIF_"scrdown.gif"" BORDER=0>"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"scrdown.gif\" BORDER=0>"));
            //<< . . WRITE "</A>"                                       ;ENDE SORT ;termination
            m$.Cmd.Write("</A>");
          } while (false);
        }
        //<< . ;
        //<< . SET YPRIMFIRST=1
        YPRIMFIRST.set(1);
        //<< . if $piece(YVOR,Y,7)'="" write "</FONT>"            ; SR15509
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
          m$.Cmd.Write("</FONT>");
        }
        //<< . WRITE YCR,"</TH>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TH>");
      } while (false);
    }
    //<< 
    //<< ;KEIN PRIMÄRSCHLÜSSEL ;no
    //<< IF '$DATA(^WWW002(0,YDATEI)) {            ; SR15509
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW002",0,m$.var("YDATEI").get())))) {
      //<< WRITE "<TH NOWRAP ALIGN=LEFT BGCOLOR="_YDARKGRAY_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TH NOWRAP ALIGN=LEFT BGCOLOR=",m$.var("YDARKGRAY").get()),">"));
      //<< IF $PIECE(YVOR,Y,7)'="" WRITE "<FONT SIZE="""_$PIECE(YVOR,Y,7)_""">"
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
      }
      //<< WRITE "#"
      m$.Cmd.Write("#");
      //<< if $piece(YVOR,Y,7)'="" write "</FONT>"            ; SR15509
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
        m$.Cmd.Write("</FONT>");
      }
      //<< WRITE "</TH>",YCR
      m$.Cmd.Write("</TH>",m$.var("YCR").get());
    }
    //<< }
    //<< 
    //<< ;WENN OHNE VORGABE ;when without default
    //<< IF $TRANSLATE($PIECE(YSUCH1,Y,16),",; 0-""")'="" SET $PIECE(YSUCH1,Y,6)=$PIECE(YSUCH1,Y,16)  ;SORTIERUNG UMDEREHEN
    if (mOp.NotEqual(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),16),",; 0-\""),"")) {
      m$.pieceVar(m$.var("YSUCH1"),m$.var("Y").get(),6).set(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),16));
    }
    //<< IF $PIECE(YSUCH1,Y,6)="" IF YFOART'=3 SET YLFN="" FOR YANLZ=1:1 SET YLFN=$ORDER(^WWW003(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),"")) {
      if (mOp.NotEqual(m$.var("YFOART").get(),3)) {
        YLFN.set("");
        mVar YANLZ = m$.var("YANLZ");
        for (YANLZ.set(1);(true);YANLZ.set(mOp.Add(YANLZ.get(),1))) {
          YLFN.set(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get())));
          if (mOp.Equal(YLFN.get(),"")) {
            break;
          }
          do {
            //<< . NEW YSORTX,strYTEXT,strAccessList     ; SR15509
            mVar YSORTX = m$.var("YSORTX");
            mVar strYTEXT = m$.var("strYTEXT");
            mVar strAccessList = m$.var("strAccessList");
            m$.newVarBlock(1,YSORTX,strYTEXT,strAccessList);
            //<< . ;IF +YBER'=1 IF YBER'="" IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,14)'="" IF $PIECE(^(1),Y,14)'=99 IF '$FIND(","_$TRANSLATE($PIECE(^(1),Y,14),";",",")_",",","_YBER_",") QUIT
            //<< . IF +YBER'=1 IF YBER'="" set strAccessList=$piece($get(^WWW003(0,YDATEI,YLFN,1)),Y,14) if (strAccessList'="")&&(strAccessList'=99)&&'$find(","_$translate(strAccessList,";",",")_",",","_YBER_",") quit  ; SR15509 naked ref
            if (mOp.NotEqual(mOp.Positive(m$.var("YBER").get()),1)) {
              if (mOp.NotEqual(m$.var("YBER").get(),"")) {
                strAccessList.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),14));
                if ((mOp.NotEqual(strAccessList.get(),"")) && (mOp.NotEqual(strAccessList.get(),99)) && mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(strAccessList.get(),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBER").get()),",")))) {
                  break;
                }
              }
            }
            //<< . IF $PIECE(YSUCH1,Y,6)=""  QUIT:YANLZ>8
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),"")) {
              if (mOp.Greater(YANLZ.get(),8)) {
                break;
              }
            }
            //<< . IF $PIECE(YSUCH1,Y,6)'="" QUIT:'$FIND(","_$TRANSLATE($PIECE(YSUCH1,Y,6),";",",")_",",","_YLFN_",")
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),"")) {
              if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",YLFN.get()),",")))) {
                break;
              }
            }
            //<< . WRITE "<TH NOWRAP ALIGN=LEFT"
            m$.Cmd.Write("<TH NOWRAP ALIGN=LEFT");
            //<< . IF $PIECE(YVOR,Y,83)=""  WRITE " BGCOLOR="_YDARKGRAY
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
              m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YDARKGRAY").get()));
            }
            //<< . IF $PIECE(YVOR,Y,83)'="" WRITE " class=""header"""  ;FIS;CUSTOMER CSS STYLESHEET;08.12.04;26564
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
              m$.Cmd.Write(" class=\"header\"");
            }
            //<< . WRITE ">"
            m$.Cmd.Write(">");
            //<< . IF $PIECE(YVOR,Y,7)'="" WRITE "<FONT SIZE="""_$PIECE(YVOR,Y,7)_""">"
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
            }
            //<< . SET YSORTX=+$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,6)
            YSORTX.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),6)));
            //<< . DO
            do {
              //<< . . NEW YTEXT
              mVar YTEXT = m$.var("YTEXT");
              m$.newVarBlock(2,YTEXT);
              //<< . . IF YDATEI=$GET(YFORM) SET YTEXT=$$^WWWFELDNAME(YFORM,"D",YLFN) IF YTEXT'="" DO  QUIT  ;TYB;10.07.2002 ; CUSTOMIZING MIT NAME IN HEADER
              if (mOp.Equal(m$.var("YDATEI").get(),m$.Fnc.$get(m$.var("YFORM")))) {
                YTEXT.set(m$.fnc$("WWWFELDNAME.main",m$.var("YFORM").get(),"D",YLFN.get()));
                if (mOp.NotEqual(YTEXT.get(),"")) {
                  do {
                    //<< . . . IF $FIND(YTEXT,"_BLANK")'=0 WRITE "&nbsp;" DO  QUIT   // BR014194
                    if (mOp.NotEqual(m$.Fnc.$find(YTEXT.get(),"_BLANK"),0)) {
                      m$.Cmd.Write("&nbsp;");
                      break;
                    }
                    //<< . . . WRITE YTEXT
                    m$.Cmd.Write(YTEXT.get());
                    //<< . . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEFON")  SET YTELE(YLFN)=1
                    //<< . . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEPHON") SET YTELE(YLFN)=1
                    //<< . . . set strYTEXT=$zconvert(YTEXT,"U")
                    strYTEXT.set(m$.Fnc.$zconvert(YTEXT.get(),"U"));
                    //<< . . . IF $FIND(strYTEXT,"TELEFON")  SET YTELE(YLFN)=1
                    if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEFON"))) {
                      mVar YTELE = m$.var("YTELE");
                      YTELE.var(YLFN.get()).set(1);
                    }
                    //<< . . . IF $FIND(strYTEXT,"TELEPHON") SET YTELE(YLFN)=1
                    if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEPHON"))) {
                      mVar YTELE = m$.var("YTELE");
                      YTELE.var(YLFN.get()).set(1);
                    }
                  } while (false);
                  break;
                }
              }
              //<< . . ;
              //<< . . IF $DATA(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)) DO  QUIT
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
                //<< . . . SET YTEXT=$$^WWWUML($PIECE($GET(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)),Y,1),1)
                YTEXT.set(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),1));
                //<< . . . WRITE YTEXT
                m$.Cmd.Write(YTEXT.get());
                //<< . . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEFON")  SET YTELE(YLFN)=1
                //<< . . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEPHON") SET YTELE(YLFN)=1
                //<< . . . set strYTEXT=$zconvert(YTEXT,"U")
                strYTEXT.set(m$.Fnc.$zconvert(YTEXT.get(),"U"));
                //<< . . . IF $FIND(strYTEXT,"TELEFON")  SET YTELE(YLFN)=1
                if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEFON"))) {
                  mVar YTELE = m$.var("YTELE");
                  YTELE.var(YLFN.get()).set(1);
                }
                //<< . . . IF $FIND(strYTEXT,"TELEPHON") SET YTELE(YLFN)=1
                if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEPHON"))) {
                  mVar YTELE = m$.var("YTELE");
                  YTELE.var(YLFN.get()).set(1);
                }
                break;
              }
              //<< . . ;
              //<< . . SET YTEXT=$$^WWWUML($PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,2),1)
              YTEXT.set(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),2),1));
              //<< . . WRITE YTEXT
              m$.Cmd.Write(YTEXT.get());
              //<< . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEFON")  SET YTELE(YLFN)=1
              //<< . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEPHON") SET YTELE(YLFN)=1
              //<< . . set strYTEXT=$zconvert(YTEXT,"U")
              strYTEXT.set(m$.Fnc.$zconvert(YTEXT.get(),"U"));
              //<< . . IF $FIND(strYTEXT,"TELEFON")  SET YTELE(YLFN)=1
              if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEFON"))) {
                mVar YTELE = m$.var("YTELE");
                YTELE.var(YLFN.get()).set(1);
              }
              //<< . . IF $FIND(strYTEXT,"TELEPHON") SET YTELE(YLFN)=1
              if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEPHON"))) {
                mVar YTELE = m$.var("YTELE");
                YTELE.var(YLFN.get()).set(1);
              }
              //<< . . SET datei(YANLZ)=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)=10
              mVar datei = m$.var("datei");
              datei.var(YANLZ.get()).set(mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),3),10));
            } while(false);
            m$.restoreVarBlock(2);
            //<< . ;
            //<< . IF +YSORTX'=0 IF $PIECE(YSORTX,".",2)<2 DO  ;SORT
            if (mOp.NotEqual(mOp.Positive(YSORTX.get()),0)) {
              if (mOp.Less(m$.Fnc.$piece(YSORTX.get(),".",2),2)) {
                do {
                  //<< . . QUIT:$GET(YNOSORT)=1   ;UNTERSORT AUSSCHALTEN ;eliminate
                  if (mOp.Equal(m$.Fnc.$get(m$.var("YNOSORT")),1)) {
                    break;
                  }
                  //<< . . WRITE "<A"
                  m$.Cmd.Write("<A");
                  //<< . . WRITE " TITLE="""_$$^WWWTEXT(65)_""""              ;SORTIERUNG ;sorting
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",65)),"\""));
                  //<< . . WRITE " HREF="""
                  m$.Cmd.Write(" HREF=\"");
                  //<< . . WRITE YAKTION_"EP=WWWSEAR&amp;YFORM="_YFORM_"&amp;YSORT="_$PIECE(YSORTX,".",1)_"&amp;YFUNCT=&amp;YORIENT=1&amp;YANZAHL="_$GET(YANZAHL)_"&amp;YSUCH="_$GET(YSUCH)_"&amp;YAUSWAHL=&amp;YVORGABE="
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWSEAR&amp;YFORM="),m$.var("YFORM").get()),"&amp;YSORT="),m$.Fnc.$piece(YSORTX.get(),".",1)),"&amp;YFUNCT=&amp;YORIENT=1&amp;YANZAHL="),m$.Fnc.$get(m$.var("YANZAHL"))),"&amp;YSUCH="),m$.Fnc.$get(m$.var("YSUCH"))),"&amp;YAUSWAHL=&amp;YVORGABE="));
                  //<< . . DO ^WWWCGI
                  m$.Cmd.Do("WWWCGI.main");
                  //<< . . WRITE """> "
                  m$.Cmd.Write("\"> ");
                  //<< . . WRITE "<IMG SRC="""_YGIF_"scrup.gif"" BORDER=0>"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"scrup.gif\" BORDER=0>"));
                  //<< . . WRITE "</A>"                                       ;ENDE SORT ;termination
                  m$.Cmd.Write("</A>");
                } while (false);
              }
            }
            //<< . ;
            //<< . IF +YSORTX'=0 IF $PIECE(YSORTX,".",2)<2 DO  ;SORT
            if (mOp.NotEqual(mOp.Positive(YSORTX.get()),0)) {
              if (mOp.Less(m$.Fnc.$piece(YSORTX.get(),".",2),2)) {
                do {
                  //<< . . QUIT:$GET(YNOSORT)=1   ;UNTERSORT AUSSCHALTEN ;eliminate
                  if (mOp.Equal(m$.Fnc.$get(m$.var("YNOSORT")),1)) {
                    break;
                  }
                  //<< . . WRITE "<A"
                  m$.Cmd.Write("<A");
                  //<< . . WRITE " TITLE="""_$$^WWWTEXT(65)_""""              ;SORTIERUNG ;sorting
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",65)),"\""));
                  //<< . . WRITE " HREF="""
                  m$.Cmd.Write(" HREF=\"");
                  //<< . . WRITE YAKTION_"EP=WWWSEAR&amp;YFORM="_YFORM_"&amp;YSORT="_$PIECE(YSORTX,".",1)_"&amp;YFUNCT=&amp;YORIENT=0&amp;YANZAHL="_$GET(YANZAHL)_"&amp;YSUCH="_$GET(YSUCH)_"&amp;YAUSWAHL=&amp;YVORGABE="
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWSEAR&amp;YFORM="),m$.var("YFORM").get()),"&amp;YSORT="),m$.Fnc.$piece(YSORTX.get(),".",1)),"&amp;YFUNCT=&amp;YORIENT=0&amp;YANZAHL="),m$.Fnc.$get(m$.var("YANZAHL"))),"&amp;YSUCH="),m$.Fnc.$get(m$.var("YSUCH"))),"&amp;YAUSWAHL=&amp;YVORGABE="));
                  //<< . . DO ^WWWCGI
                  m$.Cmd.Do("WWWCGI.main");
                  //<< . . WRITE """> "
                  m$.Cmd.Write("\"> ");
                  //<< . . WRITE "<IMG SRC="""_YGIF_"scrdown.gif"" BORDER=0>"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"scrdown.gif\" BORDER=0>"));
                  //<< . . WRITE "</A>"                                       ;ENDE SORT ;termination
                  m$.Cmd.Write("</A>");
                } while (false);
              }
            }
            //<< . ;
            //<< . if $piece(YVOR,Y,7)'="" write "</FONT>"              ; SR15509
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
              m$.Cmd.Write("</FONT>");
            }
            //<< . WRITE "</TH>",YCR
            m$.Cmd.Write("</TH>",m$.var("YCR").get());
          } while (false);
        }
        m$.restoreVarBlock(1);
      }
    }
    //<< 
    //<< ;WENN MIT VORGABE ;when by means of default
    //<< IF $PIECE(YSUCH1,Y,6)'="" IF YFOART'=3 DO
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),"")) {
      if (mOp.NotEqual(m$.var("YFOART").get(),3)) {
        //<< . SET $PIECE(YSUCH1,Y,6)=$TRANSLATE($PIECE(YSUCH1,Y,6),";",",")
        m$.pieceVar(m$.var("YSUCH1"),m$.var("Y").get(),6).set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),";",","));
        //<< . FOR YANLZ=1:1 SET YLFN=$PIECE($PIECE(YSUCH1,Y,6),",",YANLZ) QUIT:YLFN=""  DO
        mVar YANLZ = m$.var("YANLZ");
        for (YANLZ.set(1);(true);YANLZ.set(mOp.Add(YANLZ.get(),1))) {
          YLFN.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),",",YANLZ.get()));
          if (mOp.Equal(YLFN.get(),"")) {
            break;
          }
          do {
            //<< . . NEW SORTX,strYTEXT,strAccessList     ; SR15509
            mVar SORTX = m$.var("SORTX");
            mVar strYTEXT = m$.var("strYTEXT");
            mVar strAccessList = m$.var("strAccessList");
            m$.newVarBlock(2,SORTX,strYTEXT,strAccessList);
            //<< . . ;IF +YBER'=1 IF YBER'="" IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,14)'="" IF $PIECE(^(1),Y,14)'=99 IF '$FIND(","_$TRANSLATE($PIECE(^(1),Y,14),";",",")_",",","_YBER_",") QUIT
            //<< . . IF +YBER'=1 IF YBER'="" set strAccessList=$piece($get(^WWW003(0,YDATEI,YLFN,1)),Y,14) if (strAccessList'="")&&(strAccessList'=99)&&'$find(","_$translate(strAccessList,";",",")_",",","_YBER_",") quit  ; SR15509 naked ref
            if (mOp.NotEqual(mOp.Positive(m$.var("YBER").get()),1)) {
              if (mOp.NotEqual(m$.var("YBER").get(),"")) {
                strAccessList.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),14));
                if ((mOp.NotEqual(strAccessList.get(),"")) && (mOp.NotEqual(strAccessList.get(),99)) && mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(strAccessList.get(),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBER").get()),",")))) {
                  break;
                }
              }
            }
            //<< . . ;
            //<< . . WRITE "<TH NOWRAP ALIGN=LEFT"
            m$.Cmd.Write("<TH NOWRAP ALIGN=LEFT");
            //<< . . IF $PIECE(YVOR,Y,83)=""  WRITE " BGCOLOR="_YDARKGRAY
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
              m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YDARKGRAY").get()));
            }
            //<< . . IF $PIECE(YVOR,Y,83)'="" WRITE " class=""header"""  ;FIS;CUSTOMER CSS STYLESHEET;08.12.04;26564
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
              m$.Cmd.Write(" class=\"header\"");
            }
            //<< . . WRITE ">"
            m$.Cmd.Write(">");
            //<< . . IF $PIECE(YVOR,Y,7)'="" WRITE "<FONT SIZE="""_$PIECE(YVOR,Y,7)_""">"
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
            }
            //<< . . SET YSORTX=+$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,6)
            mVar YSORTX = m$.var("YSORTX");
            YSORTX.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),6)));
            //<< . . DO
            do {
              //<< . . . NEW YTEXT
              mVar YTEXT = m$.var("YTEXT");
              m$.newVarBlock(3,YTEXT);
              //<< . . . IF YDATEI=$GET(YFORM) SET YTEXT=$$^WWWFELDNAME(YFORM,"D",YLFN) IF YTEXT'="" DO  QUIT  ;TYB;10.07.2002 ; CUSTOMIZING MIT NAME IN HEADER
              if (mOp.Equal(m$.var("YDATEI").get(),m$.Fnc.$get(m$.var("YFORM")))) {
                YTEXT.set(m$.fnc$("WWWFELDNAME.main",m$.var("YFORM").get(),"D",YLFN.get()));
                if (mOp.NotEqual(YTEXT.get(),"")) {
                  //<< . . . . IF YSUCH3'="" IF $PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,4)'="" SET YTEXT=$$^WWWTEXT($PIECE(^WWW1232(0,YFORM,YSUCH3,YLFN,1),Y,4))   ; SR15509 naked ref
                  if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),4),"")) {
                      YTEXT.set(m$.fnc$("WWWTEXT.main",m$.Fnc.$piece(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1).get(),m$.var("Y").get(),4)));
                    }
                  }
                  //<< . . . . IF YSUCH3'="" IF +$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2)'=0 DO   ;LÄNGENBEGRENZUNG
                  if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
                    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2)),0)) {
                      //<< . . . . . SET YTEXT=$EXTRACT(YTEXT,1,+$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2))
                      YTEXT.set(m$.Fnc.$extract(YTEXT.get(),1,mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2))));
                    }
                  }
                  //<< . . . . ;
                  //<< . . . . IF '$FIND(YTEXT,"m2") IF '$FIND(YTEXT,"m3") WRITE YTEXT
                  if (mOp.Not(m$.Fnc.$find(YTEXT.get(),"m2"))) {
                    if (mOp.Not(m$.Fnc.$find(YTEXT.get(),"m3"))) {
                      m$.Cmd.Write(YTEXT.get());
                    }
                  }
                  //<< . . . . IF $FIND(YTEXT,"m2") WRITE $PIECE(YTEXT,"m2",1)_"m<sup>"_2_"</sup>"_$PIECE(YTEXT,"m2",2,99)
                  if (mOp.Logical(m$.Fnc.$find(YTEXT.get(),"m2"))) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YTEXT.get(),"m2",1),"m<sup>"),2),"</sup>"),m$.Fnc.$piece(YTEXT.get(),"m2",2,99)));
                  }
                  //<< . . . . IF $FIND(YNAME,"m3") WRITE $PIECE(YTEXT,"m3",1)_"m<sup>"_3_"</sup>"_$PIECE(YTEXT,"m3",2,99)
                  if (mOp.Logical(m$.Fnc.$find(m$.var("YNAME").get(),"m3"))) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YTEXT.get(),"m3",1),"m<sup>"),3),"</sup>"),m$.Fnc.$piece(YTEXT.get(),"m3",2,99)));
                  }
                  //<< . . . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEFON") SET YTELE(YLFN)=1
                  //<< . . . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEPHON") SET YTELE(YLFN)=1
                  //<< . . . . set strYTEXT=$zconvert(YTEXT,"U")
                  strYTEXT.set(m$.Fnc.$zconvert(YTEXT.get(),"U"));
                  //<< . . . . IF $FIND(strYTEXT,"TELEFON")  SET YTELE(YLFN)=1
                  if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEFON"))) {
                    mVar YTELE = m$.var("YTELE");
                    YTELE.var(YLFN.get()).set(1);
                  }
                  //<< . . . . IF $FIND(strYTEXT,"TELEPHON") SET YTELE(YLFN)=1
                  if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEPHON"))) {
                    mVar YTELE = m$.var("YTELE");
                    YTELE.var(YLFN.get()).set(1);
                  }
                  break;
                }
              }
              //<< . . . ;
              //<< . . . IF $DATA(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)) DO  QUIT
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)))) {
                //<< . . . . SET YTEXT=$$^WWWUML($PIECE($GET(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)),Y,1),1)
                YTEXT.set(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YLFN.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),1));
                //<< . . . . IF YSUCH3'="" IF $PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,4)'="" SET YTEXT=$$^WWWTEXT($PIECE(^(1),Y,4))
                if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
                  if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),4),"")) {
                    YTEXT.set(m$.fnc$("WWWTEXT.main",m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),4)));
                  }
                }
                //<< . . . . IF YSUCH3'="" IF +$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2)'=0 DO   ;LÄNGENBEGRENZUNG
                if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
                  if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2)),0)) {
                    //<< . . . . . SET YTEXT=$EXTRACT(YTEXT,1,+$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2))
                    YTEXT.set(m$.Fnc.$extract(YTEXT.get(),1,mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2))));
                  }
                }
                //<< . . . . ;
                //<< . . . . IF '$FIND(YTEXT,"m2") IF '$FIND(YTEXT,"m3") WRITE YTEXT
                if (mOp.Not(m$.Fnc.$find(YTEXT.get(),"m2"))) {
                  if (mOp.Not(m$.Fnc.$find(YTEXT.get(),"m3"))) {
                    m$.Cmd.Write(YTEXT.get());
                  }
                }
                //<< . . . . IF $FIND(YTEXT,"m2") WRITE $PIECE(YTEXT,"m2",1)_"m<sup>"_2_"</sup>"_$PIECE(YTEXT,"m2",2,99)
                if (mOp.Logical(m$.Fnc.$find(YTEXT.get(),"m2"))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YTEXT.get(),"m2",1),"m<sup>"),2),"</sup>"),m$.Fnc.$piece(YTEXT.get(),"m2",2,99)));
                }
                //<< . . . . IF $FIND(YNAME,"m3") WRITE $PIECE(YTEXT,"m3",1)_"m<sup>"_3_"</sup>"_$PIECE(YTEXT,"m3",2,99)
                if (mOp.Logical(m$.Fnc.$find(m$.var("YNAME").get(),"m3"))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YTEXT.get(),"m3",1),"m<sup>"),3),"</sup>"),m$.Fnc.$piece(YTEXT.get(),"m3",2,99)));
                }
                //<< . . . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEFON")  SET YTELE(YLFN)=1
                //<< . . . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEPHON") SET YTELE(YLFN)=1
                //<< . . . . set strYTEXT=$zconvert(YTEXT,"U")
                strYTEXT.set(m$.Fnc.$zconvert(YTEXT.get(),"U"));
                //<< . . . . IF $FIND(strYTEXT,"TELEFON")  SET YTELE(YLFN)=1
                if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEFON"))) {
                  mVar YTELE = m$.var("YTELE");
                  YTELE.var(YLFN.get()).set(1);
                }
                //<< . . . . IF $FIND(strYTEXT,"TELEPHON") SET YTELE(YLFN)=1
                if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEPHON"))) {
                  mVar YTELE = m$.var("YTELE");
                  YTELE.var(YLFN.get()).set(1);
                }
                break;
              }
              //<< . . . ;
              //<< . . . SET YTEXT=$$^WWWUML($PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,2),1)
              YTEXT.set(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),2),1));
              //<< . . . IF YSUCH3'="" IF $PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,4)'="" SET YTEXT=$$^WWWTEXT($PIECE(^WWW1232(0,YFORM,YSUCH3,YLFN,1),Y,4))   ; SR15509 naked ref
              if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
                if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),4),"")) {
                  YTEXT.set(m$.fnc$("WWWTEXT.main",m$.Fnc.$piece(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1).get(),m$.var("Y").get(),4)));
                }
              }
              //<< . . . IF YSUCH3'="" IF +$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2)'=0 DO   ;LÄNGENBEGRENZUNG
              if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
                if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2)),0)) {
                  //<< . . . . SET YTEXT=$EXTRACT(YTEXT,1,+$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2))
                  YTEXT.set(m$.Fnc.$extract(YTEXT.get(),1,mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2))));
                }
              }
              //<< . . . ;
              //<< . . . IF '$FIND(YTEXT,"m2") IF '$FIND(YTEXT,"m3") WRITE YTEXT
              if (mOp.Not(m$.Fnc.$find(YTEXT.get(),"m2"))) {
                if (mOp.Not(m$.Fnc.$find(YTEXT.get(),"m3"))) {
                  m$.Cmd.Write(YTEXT.get());
                }
              }
              //<< . . . IF $FIND(YTEXT,"m2") WRITE $PIECE(YTEXT,"m2",1)_"m<sup>"_2_"</sup>"_$PIECE(YTEXT,"m2",2,99)
              if (mOp.Logical(m$.Fnc.$find(YTEXT.get(),"m2"))) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YTEXT.get(),"m2",1),"m<sup>"),2),"</sup>"),m$.Fnc.$piece(YTEXT.get(),"m2",2,99)));
              }
              //<< . . . IF $FIND(YNAME,"m3") WRITE $PIECE(YTEXT,"m3",1)_"m<sup>"_3_"</sup>"_$PIECE(YTEXT,"m3",2,99)
              if (mOp.Logical(m$.Fnc.$find(m$.var("YNAME").get(),"m3"))) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YTEXT.get(),"m3",1),"m<sup>"),3),"</sup>"),m$.Fnc.$piece(YTEXT.get(),"m3",2,99)));
              }
              //<< . . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEFON") SET YTELE(YLFN)=1
              //<< . . . ;IF $FIND($$^WWWUPER(YTEXT),"TELEPHON") SET YTELE(YLFN)=1
              //<< . . . set strYTEXT=$zconvert(YTEXT,"U")
              strYTEXT.set(m$.Fnc.$zconvert(YTEXT.get(),"U"));
              //<< . . . IF $FIND(strYTEXT,"TELEFON")  SET YTELE(YLFN)=1
              if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEFON"))) {
                mVar YTELE = m$.var("YTELE");
                YTELE.var(YLFN.get()).set(1);
              }
              //<< . . . IF $FIND(strYTEXT,"TELEPHON") SET YTELE(YLFN)=1
              if (mOp.Logical(m$.Fnc.$find(strYTEXT.get(),"TELEPHON"))) {
                mVar YTELE = m$.var("YTELE");
                YTELE.var(YLFN.get()).set(1);
              }
              //<< . . . SET datei(YANLZ)=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)=10
              mVar datei = m$.var("datei");
              datei.var(YANLZ.get()).set(mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),3),10));
            } while(false);
            m$.restoreVarBlock(3);
            //<< . . ;
            //<< . . IF +YSORTX'=0 IF $PIECE(YSORTX,".",2)<2 DO  ;SORT
            if (mOp.NotEqual(mOp.Positive(YSORTX.get()),0)) {
              if (mOp.Less(m$.Fnc.$piece(YSORTX.get(),".",2),2)) {
                do {
                  //<< . . . QUIT:$GET(YNOSORT)=1   ;UNTERSORT AUSSCHALTEN ;eliminate
                  if (mOp.Equal(m$.Fnc.$get(m$.var("YNOSORT")),1)) {
                    break;
                  }
                  //<< . . . WRITE "<A"
                  m$.Cmd.Write("<A");
                  //<< . . . WRITE " TITLE="""_$$^WWWTEXT(65)_""""            ;SORTIERUNG ;sorting
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",65)),"\""));
                  //<< . . . WRITE " HREF="""
                  m$.Cmd.Write(" HREF=\"");
                  //<< . . . WRITE YAKTION_"EP=WWWSEAR&amp;YFORM="_YFORM_"&amp;YSORT="_$PIECE(YSORTX,".",1)_"&amp;YFUNCT=&amp;YORIENT=1&amp;YANZAHL="_$GET(YANZAHL)_"&amp;YSUCH="_$GET(YSUCH)_"&amp;YAUSWAHL=&amp;YVORGABE="
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWSEAR&amp;YFORM="),m$.var("YFORM").get()),"&amp;YSORT="),m$.Fnc.$piece(YSORTX.get(),".",1)),"&amp;YFUNCT=&amp;YORIENT=1&amp;YANZAHL="),m$.Fnc.$get(m$.var("YANZAHL"))),"&amp;YSUCH="),m$.Fnc.$get(m$.var("YSUCH"))),"&amp;YAUSWAHL=&amp;YVORGABE="));
                  //<< . . . DO ^WWWCGI
                  m$.Cmd.Do("WWWCGI.main");
                  //<< . . . WRITE """> "
                  m$.Cmd.Write("\"> ");
                  //<< . . . WRITE "<IMG SRC="""_YGIF_"scrup.gif"" BORDER=0>"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"scrup.gif\" BORDER=0>"));
                  //<< . . . WRITE "</A>"                                     ;ENDE SORT ;termination
                  m$.Cmd.Write("</A>");
                } while (false);
              }
            }
            //<< . . ;
            //<< . . IF +YSORTX'=0 IF $PIECE(YSORTX,".",2)<2 DO  ;SORT
            if (mOp.NotEqual(mOp.Positive(YSORTX.get()),0)) {
              if (mOp.Less(m$.Fnc.$piece(YSORTX.get(),".",2),2)) {
                do {
                  //<< . . . QUIT:$GET(YNOSORT)=1   ;UNTERSORT AUSSCHALTEN ;eliminate
                  if (mOp.Equal(m$.Fnc.$get(m$.var("YNOSORT")),1)) {
                    break;
                  }
                  //<< . . . WRITE "<A"
                  m$.Cmd.Write("<A");
                  //<< . . . WRITE " TITLE="""_$$^WWWTEXT(65)_""""            ;SORTIERUNG ;sorting
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",65)),"\""));
                  //<< . . . WRITE " HREF="""
                  m$.Cmd.Write(" HREF=\"");
                  //<< . . . WRITE YAKTION_"EP=WWWSEAR&amp;YFORM="_YFORM_"&amp;YSORT="_$PIECE(YSORTX,".",1)_"&amp;YFUNCT=&amp;YORIENT=0&amp;YANZAHL="_$GET(YANZAHL)_"&amp;YSUCH="_$GET(YSUCH)_"&amp;YAUSWAHL=&amp;YVORGABE="
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWSEAR&amp;YFORM="),m$.var("YFORM").get()),"&amp;YSORT="),m$.Fnc.$piece(YSORTX.get(),".",1)),"&amp;YFUNCT=&amp;YORIENT=0&amp;YANZAHL="),m$.Fnc.$get(m$.var("YANZAHL"))),"&amp;YSUCH="),m$.Fnc.$get(m$.var("YSUCH"))),"&amp;YAUSWAHL=&amp;YVORGABE="));
                  //<< . . . DO ^WWWCGI
                  m$.Cmd.Do("WWWCGI.main");
                  //<< . . . WRITE """> "
                  m$.Cmd.Write("\"> ");
                  //<< . . . WRITE "<IMG SRC="""_YGIF_"scrdown.gif"" BORDER=0>"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"scrdown.gif\" BORDER=0>"));
                  //<< . . . WRITE "</A>"                                     ;ENDE SORT ;termination
                  m$.Cmd.Write("</A>");
                } while (false);
              }
            }
            //<< . . ;
            //<< . . if $piece(YVOR,Y,7)'="" write "</FONT>"            ; SR15509
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
              m$.Cmd.Write("</FONT>");
            }
            //<< . . WRITE "</TH>",YCR
            m$.Cmd.Write("</TH>",m$.var("YCR").get());
          } while (false);
        }
        m$.restoreVarBlock(2);
      }
    }
    //<< 
    //<< WRITE "</TR>",YCR
    m$.Cmd.Write("</TR>",m$.var("YCR").get());
    //<< QUIT
    return;
  }

  //<< 
  //<< ANZEIGE
  public void ANZEIGE() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display single record
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Oct-2007   shobby  SRBR014744: Don't keep checking if there are no call out methods.
    //<< ; 09-Oct-2007   shobby  SRBR014744: Pass the class that is being used to populate the list in to the DataAccess call
    //<< ; 26-Feb-2007   JW      SR15452: Rewrote. Added data access check. Added param to ANZEIGE1
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YKEYY,YKEY,YSEITE,strExec,intCounter,blnCheck
    mVar YKEYY = m$.var("YKEYY");
    mVar YKEY = m$.var("YKEY");
    mVar YSEITE = m$.var("YSEITE");
    mVar strExec = m$.var("strExec");
    mVar intCounter = m$.var("intCounter");
    mVar blnCheck = m$.var("blnCheck");
    m$.newVar(YKEYY,YKEY,YSEITE,strExec,intCounter,blnCheck);
    //<< 
    //<< SET YSEITE=1        ;Ziel darf nicht aktuelle Seite sein, da vieleicht nicht vorhanden
    YSEITE.set(1);
    //<< SET YDDSATZ=0
    mVar YDDSATZ = m$.var("YDDSATZ");
    YDDSATZ.set(0);
    //<< 
    //<< ;YHEADONLY=1=NO DATARECORDS ONLY HEADER
    //<< IF $GET(YHEADONLY)'=1 {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHEADONLY")),1)) {
      //<< set strExec = $$$WWW001DataAccess($get(^WWW001(0,YDATEI,1)))
      strExec.set(include.WWWConst.$$$WWW001DataAccess(m$,m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YDATEI").get(),1))));
      //<< set blnCheck=$$$YES
      blnCheck.set(include.COMSYS.$$$YES(m$));
      //<< $$$Order3(^WWWSOR,YUSER,"KEY",intCounter)
      intCounter.set("");
      for (;true;) {
        intCounter.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",intCounter.get())));
        if (mOp.Equal(intCounter.get(),"")) {
          break;
        }
        //<< $$$Order4(^WWWSOR,YUSER,"KEY",intCounter,YKEYY)
        YKEYY.set("");
        for (;true;) {
          YKEYY.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",intCounter.get(),YKEYY.get())));
          if (mOp.Equal(YKEYY.get(),"")) {
            break;
          }
          //<< if blnCheck&&'$$DataAccess^WWWFieldValidation(strExec,YKEYY,$get(LASTUSEDFORM),,,,YDATEI,.blnCheck) {   ;BR014744 //SR15452 - LASTUSEDFORM is the best option here.
          if (mOp.Logical(blnCheck.get()) && mOp.Not(m$.fnc$("WWWFieldValidation.DataAccess",strExec.get(),YKEYY.get(),m$.Fnc.$get(m$.var("LASTUSEDFORM")),null,null,null,m$.var("YDATEI").get(),blnCheck))) {
            //<< kill ^WWWSOR(YUSER,"KEY",intCounter,YKEYY)      // So still get blank lines
            m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",intCounter.get(),YKEYY.get()).kill();
          }
          //<< } else {
          else {
            //<< DO ANZEIGE1($$$NO)
            m$.Cmd.Do("ANZEIGE1",include.COMSYS.$$$NO(m$));
          }
        }
      }
    }
    //<< }
    //<< $$$End
    //<< $$$End
    //<< }
    //<< /* SR15452 - rewritten above.
    //<< IF $GET(YHEADONLY)'=1 SET YA(2)="" FOR  SET YA(2)=$ORDER(^WWWSOR(YUSER,"KEY",YA(2))) QUIT:YA(2)=""  DO
    //<< . SET YKEYY="" FOR  SET YKEYY=$ORDER(^WWWSOR(YUSER,"KEY",YA(2),YKEYY)) QUIT:YKEYY=""  DO ANZEIGE1
    //<< */
    //<< ;
    //<< IF '$DATA(^WWWSOR(YUSER,"KEY"))!(YDDSATZ<$GET(YANZAHL)) DO
    if (mOp.Or(mOp.Not(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY"))),(mOp.Less(YDDSATZ.get(),m$.Fnc.$get(m$.var("YANZAHL")))))) {
      //<< . NEW YBLANKLINE
      mVar YBLANKLINE = m$.var("YBLANKLINE");
      m$.newVarBlock(1,YBLANKLINE);
      //<< . SET YBLANKLINE(1)=$GET(YANZAHL)
      YBLANKLINE.var(1).set(m$.Fnc.$get(m$.var("YANZAHL")));
      //<< . IF $GET(YANZAHL)<5 SET YBLANKLINE(1)=5  ;TYBD;VORGABE AUS SUCHFELD ;default out of
      if (mOp.Less(m$.Fnc.$get(m$.var("YANZAHL")),5)) {
        YBLANKLINE.var(1).set(5);
      }
      //<< . IF $GET(YANZAHL)>30 SET YBLANKLINE(1)=30  ;TYBD ; VORGABE AUS SPEICHERUNG
      if (mOp.Greater(m$.Fnc.$get(m$.var("YANZAHL")),30)) {
        YBLANKLINE.var(1).set(30);
      }
      //<< . SET YBLANKLINE=$GET(YDDSATZ)
      YBLANKLINE.set(m$.Fnc.$get(YDDSATZ));
      //<< . IF $PIECE($GET(^WWW012(0,YM,1)),Y,144)=1  SET YBLANKLINE(1)=YBLANKLINE  ;NICHT ANZEIGEN;TYBD;8,09,2003;24248
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),144),1)) {
        YBLANKLINE.var(1).set(YBLANKLINE.get());
      }
      //<< . FOR YBLANKLINE=YBLANKLINE:1:YBLANKLINE(1) SET YKEYY="" DO ANZEIGE1($$$YES)    //SR15452
      for (YBLANKLINE.set(YBLANKLINE.get());(mOp.LessOrEqual(YBLANKLINE.get(),YBLANKLINE.var(1).get()));YBLANKLINE.set(mOp.Add(YBLANKLINE.get(),1))) {
        YKEYY.set("");
        m$.Cmd.Do("ANZEIGE1",include.COMSYS.$$$YES(m$));
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< KILL ^WWWSOR(YUSER,"KEY")
    m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY").kill();
    //<< QUIT
    return;
  }

  //<< 
  //<< ANZEIGE1(pblnBlank)
  public Object ANZEIGE1(Object ... _p) {
    mVar pblnBlank = m$.newVarRef("pblnBlank",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
    //<< ; 03-May-2007   GRF     SR15509: Doco; quits; close </FONT>
    //<< ; 24-Apr-2007   HeberB  BR014432: show ID when no text provided
    //<< ; 13-Apr-2007   HeberB  BR014432: Show ID if requested
    //<< ; 06-Mar-2007   JW      SR15452: Added param. Don't format if blank.
    //<< ; 22-Dec-2005   RPW     SR13899: New schluessel
    //<< ; 23-Nov-2005   JW      SR13195: New YFELD, as had undesired results
    //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
    //<< ;-------------------------------------------------------------------------------
    //<< new YFELD,SCHLUESSEL,blnHide ; BR014432
    mVar YFELD = m$.var("YFELD");
    mVar SCHLUESSEL = m$.var("SCHLUESSEL");
    mVar blnHide = m$.var("blnHide");
    m$.newVar(YFELD,SCHLUESSEL,blnHide);
    //<< 
    //<< SET YKEY=YKEYY
    mVar YKEY = m$.var("YKEY");
    YKEY.set(m$.var("YKEYY").get());
    //<< IF YFOART=3 SET $PIECE(YKEY,",",YMAXKEY)=""  ;BEI GRID OHNE LETZTEN KEY ;next to without KEY
    if (mOp.Equal(m$.var("YFOART").get(),3)) {
      m$.pieceVar(YKEY,",",m$.var("YMAXKEY").get()).set("");
    }
    //<< SET YDDSATZ=YDDSATZ+1                        ;HINTERGRUNDFARBE
    mVar YDDSATZ = m$.var("YDDSATZ");
    YDDSATZ.set(mOp.Add(m$.var("YDDSATZ").get(),1));
    //<< WRITE "<TR>"
    m$.Cmd.Write("<TR>");
    //<< 
    //<< SET YLFN=""
    mVar YLFN = m$.var("YLFN");
    YLFN.set("");
    //<< FOR  SET YLFN=$ORDER(^WWW002(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      do {
        //<< . IF YFOART=3 QUIT:$ORDER(^WWW002(0,YDATEI,YLFN))=""
        if (mOp.Equal(m$.var("YFOART").get(),3)) {
          if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get())),"")) {
            break;
          }
        }
        //<< . IF $PIECE(YSUCH1,Y,5)=""  IF $PIECE(YSUCH1,Y,6)'="" QUIT   ;KEINE KEY WEIL NICHT AUSGEWÄHT ;no KEY since Not
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),5),"")) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),"")) {
            break;
          }
        }
        //<< . IF $PIECE(YSUCH1,Y,5)'="" IF $ORDER(^WWW002(0,YDATEI,YLFN))'="" QUIT:'$FIND(","_$TRANSLATE($PIECE(YSUCH1,Y,5),";",",")_",",","_YLFN_",")
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),5),"")) {
          if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),YLFN.get())),"")) {
            if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),5),";",",")),","),mOp.Concat(mOp.Concat(",",YLFN.get()),",")))) {
              break;
            }
          }
        }
        //<< . ;
        //<< . WRITE "<TD VALIGN=TOP NOWRAP"
        m$.Cmd.Write("<TD VALIGN=TOP NOWRAP");
        //<< . IF $PIECE(YVOR,Y,83)=""  IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
          if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
            m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
          }
        }
        //<< . IF $PIECE(YVOR,Y,83)=""  IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
          if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
            m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
          }
        }
        //<< . IF $PIECE(YVOR,Y,83)'="" IF YDDSATZ#2=1 WRITE " class=""white"""  ;FIS;CUSTOMER CSS STYLESHEET;08.12.04;26564
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
          if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
            m$.Cmd.Write(" class=\"white\"");
          }
        }
        //<< . IF $PIECE(YVOR,Y,83)'="" IF YDDSATZ#2=0 WRITE " class=""gray"""  ;FIS;CUSTOMER CSS STYLESHEET;08.12.04;26564
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
          if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
            m$.Cmd.Write(" class=\"gray\"");
          }
        }
        //<< . WRITE ">"
        m$.Cmd.Write(">");
        //<< . WRITE "<DIV>"
        m$.Cmd.Write("<DIV>");
        //<< . IF $PIECE(YVOR,Y,7)'="" WRITE "<FONT SIZE="""_$PIECE(YVOR,Y,7)_""">"
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
        }
        //<< . SET YINHALT=$PIECE(YKEY,",",YLFN)
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set(m$.Fnc.$piece(YKEY.get(),",",YLFN.get()));
        //<< . IF YINHALT'="" IF $FIND(YINHALT,".htm")!($FIND(YINHALT,".HTM")) DO
        if (mOp.NotEqual(YINHALT.get(),"")) {
          if (mOp.Logical(mOp.Or(m$.Fnc.$find(YINHALT.get(),".htm"),(m$.Fnc.$find(YINHALT.get(),".HTM"))))) {
            //<< . . WRITE "<A HREF="""
            m$.Cmd.Write("<A HREF=\"");
            //<< . . IF $FIND(YINHALT,"C:") WRITE "file://"
            if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),"C:"))) {
              m$.Cmd.Write("file://");
            }
            //<< . . WRITE YINHALT_""">"
            m$.Cmd.Write(mOp.Concat(YINHALT.get(),"\">"));
          }
        }
        //<< . ;
        //<< . IF '$FIND(YINHALT,".htm") IF '$FIND(YINHALT,".HTM") DO
        if (mOp.Not(m$.Fnc.$find(YINHALT.get(),".htm"))) {
          if (mOp.Not(m$.Fnc.$find(YINHALT.get(),".HTM"))) {
            //<< . . WRITE "<A"
            m$.Cmd.Write("<A");
            //<< . . IF $GET(YBITSEARCH)=1 WRITE " TARGET="""_YTARGET_""""  ;FIS;BITSEARCH;23909;14.12.03
            if (mOp.Equal(m$.Fnc.$get(m$.var("YBITSEARCH")),1)) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" TARGET=\"",m$.var("YTARGET").get()),"\""));
            }
            //<< . . IF $PIECE(YSUCH1,Y,8)'=0 DO
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),8),0)) {
              //<< . . . IF $GET(YTOOLTIP)=""  WRITE " TITLE="""_$$^WWWTEXT(374)_""""  ;DATENSATZ AUSWÄHLEN ;data record pick out
              if (mOp.Equal(m$.Fnc.$get(m$.var("YTOOLTIP")),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",374)),"\""));
              }
              //<< . . . IF $GET(YTOOLTIP)'="" WRITE " TITLE="""_YTOOLTIP_""""          ;DATENSATZ AUSWÄHLEN ;data record pick out
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTOOLTIP")),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.var("YTOOLTIP").get()),"\""));
              }
            }
            //<< . . ;
            //<< . . WRITE " HREF="""
            m$.Cmd.Write(" HREF=\"");
            //<< . . ;
            //<< . . IF $GET(YWSAVE)'="" DO   ;AUTOMATISCHER SAVE;TYBD;20,10,2003;24142
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YWSAVE")),"")) {
              //<< . . . NEW YKEY,YFORM
              mVar YFORM = m$.var("YFORM");
              m$.newVarBlock(3,YKEY,YFORM);
              //<< . . . SET YFORM=$PIECE(YWSAVE,Y,1)
              YFORM.set(m$.Fnc.$piece(m$.var("YWSAVE").get(),m$.var("Y").get(),1));
              //<< . . . SET YKEY=$PIECE(YWSAVE,Y,2)
              YKEY.set(m$.Fnc.$piece(m$.var("YWSAVE").get(),m$.var("Y").get(),2));
              //<< . . . WRITE "JavaScript:"
              m$.Cmd.Write("JavaScript:");
              //<< . . . WRITE "retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9');"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("retval=EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),YFORM.get()),"','FIX','Y"),YFORM.get()),"','','9');"));
              //<< . . . WRITE "window.location='"
              m$.Cmd.Write("window.location='");
              //<< . . . SET YCONF3="';"
              mVar YCONF3 = m$.var("YCONF3");
              YCONF3.set("';");
            }
            m$.restoreVarBlock(3);
            //<< . . ;
            //<< . . IF $PIECE(YSUCH1,Y,8)'=0 DO
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),8),0)) {
              //<< . . . WRITE YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
              m$.Cmd.Write(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()));
              //<< . . . IF $GET(YTIMEFORM)=1 WRITE "t"               ;zeitabhängige erfassungsformular
              if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
                m$.Cmd.Write("t");
              }
              //<< . . . WRITE "&amp;YSEITE="_YSEITE
              m$.Cmd.Write(mOp.Concat("&amp;YSEITE=",m$.var("YSEITE").get()));
              //<< . . . DO ^WWWCGI
              m$.Cmd.Do("WWWCGI.main");
            }
            //<< . . ;
            //<< . . IF $PIECE(YSUCH1,Y,8)=0 WRITE "#"
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),8),0)) {
              m$.Cmd.Write("#");
            }
            //<< . . IF $GET(YWSAVE)'="" WRITE "';"                 ;ENDE
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YWSAVE")),"")) {
              m$.Cmd.Write("';");
            }
            //<< . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . WRITE ">"
            m$.Cmd.Write(">");
          }
        }
        //<< . ;
        //<< . SET YINHALT =$$^WWWFORMAT(YDATEI,"P",YLFN,YINHALT,1)  ;FORMAT DES PRIMÄRSCHLÜSSELS
        YINHALT.set(m$.fnc$("WWWFORMAT.main",m$.var("YDATEI").get(),"P",YLFN.get(),YINHALT.get(),1));
        //<< . SET YINHALTK=$$^WWWFORMAT(YDATEI,"P",YLFN,YINHALT,2)  ;FORMAT DES PRIMÄRSCHLÜSSELS
        mVar YINHALTK = m$.var("YINHALTK");
        YINHALTK.set(m$.fnc$("WWWFORMAT.main",m$.var("YDATEI").get(),"P",YLFN.get(),YINHALT.get(),2));
        //<< . IF YSUCH3'="" IF +$PIECE($GET(^WWW1231(0,YFORM,YSUCH3,YLFN,1)),Y,2)'=0 DO   ;LÄNGENBEGRENZUNG
        if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1231",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2)),0)) {
            //<< . . SET YINHALT=$EXTRACT($GET(YINHALT),1,+$PIECE($GET(^WWW1231(0,YFORM,YSUCH3,YLFN,1)),Y,2))
            YINHALT.set(m$.Fnc.$extract(m$.Fnc.$get(YINHALT),1,mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1231",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2))));
          }
        }
        //<< . ;
        //<< . ;BR014432
        //<< . ;WRITE $$^WWWUML($EXTRACT(YINHALT,1,30))
        //<< . set blnHide = +$$$WWW012HideRelationClassIDs($get(^WWW012(0,YM,1)))
        blnHide.set(mOp.Positive(include.WWWConst.$$$WWW012HideRelationClassIDs(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)))));
        //<< . ;BR014432
        //<< . ;if 'blnHide do
        //<< . if 'blnHide || (blnHide && ($GET(YINHALTK)="")) do
        if (mOp.Not(blnHide.get()) || (mOp.Logical(blnHide.get()) && (mOp.Equal(m$.Fnc.$get(YINHALTK),"")))) {
          //<< . . WRITE $$^WWWUML($EXTRACT(YINHALT,1,30))
          m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$extract(YINHALT.get(),1,30)));
        }
        //<< . IF YINHALT=" " WRITE "[space]"
        if (mOp.Equal(YINHALT.get()," ")) {
          m$.Cmd.Write("[space]");
        }
        //<< . IF $TRANSLATE(YINHALT," ")="" WRITE "&nbsp;"  ;TYBD;23,7,2004;WENN "  " Dann falsche anzeige
        if (mOp.Equal(m$.Fnc.$translate(YINHALT.get()," "),"")) {
          m$.Cmd.Write("&nbsp;");
        }
        //<< . ;BR014432
        //<< . ;IF $GET(YINHALTK)'="" IF YINHALTK'=YINHALT WRITE " ("_$$^WWWUML(YINHALTK)_")"
        //<< . IF $GET(YINHALTK)'="" IF YINHALTK'=YINHALT WRITE $select(blnHide:$$^WWWUML(YINHALTK),1:" ("_$$^WWWUML(YINHALTK)_")")
        if (mOp.NotEqual(m$.Fnc.$get(YINHALTK),"")) {
          if (mOp.NotEqual(YINHALTK.get(),YINHALT.get())) {
            m$.Cmd.Write(m$.Fnc.$select(blnHide.get(),m$.fnc$("WWWUML.main",YINHALTK.get()),1,mOp.Concat(mOp.Concat(" (",m$.fnc$("WWWUML.main",YINHALTK.get())),")")));
          }
        }
        //<< . IF YINHALT'="" IF $FIND(YINHALT,".GIF")!($FIND(YINHALT,".gif")) SET URL=YINHALT DO THUMP
        if (mOp.NotEqual(YINHALT.get(),"")) {
          if (mOp.Logical(mOp.Or(m$.Fnc.$find(YINHALT.get(),".GIF"),(m$.Fnc.$find(YINHALT.get(),".gif"))))) {
            mVar URL = m$.var("URL");
            URL.set(YINHALT.get());
            m$.Cmd.Do("THUMP");
          }
        }
        //<< . IF $GET(YTIMEFORM)=1 DO  ;WENN ZEITABHÄNGIGE ERFASSUNG ;when logging
        if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
          //<< . . IF YLFN=YMAXKEY DO
          if (mOp.Equal(YLFN.get(),m$.var("YMAXKEY").get())) {
            //<< . . . WRITE " "
            m$.Cmd.Write(" ");
            //<< . . . IF $PIECE(YKEY,",",YMAXKEY+1)'="" DO
            if (mOp.NotEqual(m$.Fnc.$piece(YKEY.get(),",",mOp.Add(m$.var("YMAXKEY").get(),1)),"")) {
              //<< . . . . WRITE $$^WWWTEXT(293)," "
              m$.Cmd.Write(m$.fnc$("WWWTEXT.main",293)," ");
              //<< . . . . WRITE $$^WWWDATE($PIECE(YKEY,",",YMAXKEY+1))
              m$.Cmd.Write(m$.fnc$("WWWDATE.main",m$.Fnc.$piece(YKEY.get(),",",mOp.Add(m$.var("YMAXKEY").get(),1))));
            }
          }
        }
        //<< . ;
        //<< . WRITE "</A>"
        m$.Cmd.Write("</A>");
        //<< . WRITE "</DIV>"
        m$.Cmd.Write("</DIV>");
        //<< . WRITE "</TD>",YCR
        m$.Cmd.Write("</TD>",m$.var("YCR").get());
      } while (false);
    }
    //<< 
    //<< 
    //<< IF '$DATA(^WWW002(0,YDATEI)) {            ; SR15509
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW002",0,m$.var("YDATEI").get())))) {
      //<< WRITE "<TD VALIGN=TOP NOWRAP"
      m$.Cmd.Write("<TD VALIGN=TOP NOWRAP");
      //<< IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
      }
      //<< IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
      if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
        m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
      }
      //<< WRITE ">"
      m$.Cmd.Write(">");
      //<< WRITE "<DIV>"
      m$.Cmd.Write("<DIV>");
      //<< IF $PIECE(YVOR,Y,7)'="" WRITE "<FONT SIZE="""_$PIECE(YVOR,Y,7)_""">"
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
      }
      //<< WRITE $PIECE($GET(YKEY),",",1)
      m$.Cmd.Write(m$.Fnc.$piece(m$.Fnc.$get(YKEY),",",1));
      //<< if $piece(YVOR,Y,7)'="" write "</FONT>"            ; SR15509
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
        m$.Cmd.Write("</FONT>");
      }
      //<< WRITE "</DIV>"
      m$.Cmd.Write("</DIV>");
      //<< WRITE "</TD>",YCR
      m$.Cmd.Write("</TD>",m$.var("YCR").get());
    }
    //<< }
    //<< 
    //<< 
    //<< ;ZUSAMMENBAUEN DES SCHLÜSSELS
    //<< SET YFELD=""
    YFELD.set("");
    //<< IF YDATEI'="" DO
    if (mOp.NotEqual(m$.var("YDATEI").get(),"")) {
      //<< . SET YDATA=$GET(^WWW001(0,YDATEI,1))
      mVar YDATA = m$.var("YDATA");
      YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YDATEI").get(),1)));
      //<< . SET MAXYKEY=+$ORDER(^WWW002(0,YDATEI,""),-1)
      mVar MAXYKEY = m$.var("MAXYKEY");
      MAXYKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),""),mOp.Negative(1))));
      //<< . IF MAXYKEY=0 SET MAXYKEY=1
      if (mOp.Equal(MAXYKEY.get(),0)) {
        MAXYKEY.set(1);
      }
      //<< . SET ERSTFELD=$ORDER(^WWW003(0,YDATEI,""))
      mVar ERSTFELD = m$.var("ERSTFELD");
      ERSTFELD.set(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),"")));
      //<< . SET FELDKEY=""
      mVar FELDKEY = m$.var("FELDKEY");
      FELDKEY.set("");
      //<< . IF ERSTFELD'="" SET FELDKEY=$PIECE(^WWW003(0,YDATEI,ERSTFELD,1),Y,11) ;FUER MIT ODER OHNE ,1) ZUM SCHLUESSEL
      if (mOp.NotEqual(ERSTFELD.get(),"")) {
        FELDKEY.set(m$.Fnc.$piece(m$.var("^WWW003",0,m$.var("YDATEI").get(),ERSTFELD.get(),1).get(),m$.var("Y").get(),11));
      }
      //<< . IF MAXYKEY'=0 DO
      if (mOp.NotEqual(MAXYKEY.get(),0)) {
        //<< . . SET Q=0
        mVar Q = m$.var("Q");
        Q.set(0);
        //<< . . IF $GET(YTIMEFORM)'=1 SET SCHLUESSEL="^"_YDATEI_"("_$$^WWWYM(YDATEI,1)  ;TYBD:01.11.01
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
          SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YDATEI").get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)));
        }
        //<< . . IF $GET(YTIMEFORM)=1  SET SCHLUESSEL="^"_YDATEI_"t("_$$^WWWYM(YDATEI,1) SET MAXYKEY=MAXYKEY+1  ;TYBD:01.11.01
        if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
          SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YDATEI").get()),"t("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)));
          MAXYKEY.set(mOp.Add(MAXYKEY.get(),1));
        }
        //<< . . FOR I=1:1:MAXYKEY SET XYKEY=$TRANSLATE($PIECE(YKEY,",",I),"""") SET SCHLUESSEL=SCHLUESSEL_""""_XYKEY_"""" SET:I<MAXYKEY SCHLUESSEL=SCHLUESSEL_"," IF XYKEY="" SET Q=1
        mVar I = m$.var("I");
        for (I.set(1);(mOp.LessOrEqual(I.get(),MAXYKEY.get()));I.set(mOp.Add(I.get(),1))) {
          mVar XYKEY = m$.var("XYKEY");
          XYKEY.set(m$.Fnc.$translate(m$.Fnc.$piece(YKEY.get(),",",I.get()),"\""));
          SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat(SCHLUESSEL.get(),"\""),XYKEY.get()),"\""));
          if (mOp.Less(I.get(),MAXYKEY.get())) {
            SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),","));
          }
          if (mOp.Equal(XYKEY.get(),"")) {
            Q.set(1);
          }
        }
        //<< . . IF $PIECE(YDATA,Y,8)=4  SET SCHLUESSEL=SCHLUESSEL_$SELECT(FELDKEY'="":","_FELDKEY,1:"")_")"
        if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          SCHLUESSEL.set(mOp.Concat(mOp.Concat(SCHLUESSEL.get(),m$.Fnc.$select(mOp.NotEqual(FELDKEY.get(),""),mOp.Concat(",",FELDKEY.get()),1,"")),")"));
        }
        //<< . . IF $PIECE(YDATA,Y,8)'=4 SET SCHLUESSEL=SCHLUESSEL_",1)"
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),",1)"));
        }
        //<< . . IF Q=0 DO
        if (mOp.Equal(Q.get(),0)) {
          //<< . . . SET YFELD=$$^WWWSETL(SCHLUESSEL)
          YFELD.set(m$.fnc$("WWWSETL.main",SCHLUESSEL.get()));
        }
      }
    }
    //<< 
    //<< ;WENN OHNE VORGABE ;when without default
    //<< IF $TRANSLATE($PIECE(YSUCH1,Y,16),",; 0-""")'="" SET $PIECE(YSUCH1,Y,6)=$PIECE(YSUCH1,Y,16)   ;SORTIERUNG UMDEREHEN
    if (mOp.NotEqual(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),16),",; 0-\""),"")) {
      m$.pieceVar(m$.var("YSUCH1"),m$.var("Y").get(),6).set(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),16));
    }
    //<< IF $PIECE(YSUCH1,Y,6)="" IF YFOART'=3 SET YLFN="" FOR YANLZ=1:1 SET YLFN=$ORDER(^WWW003(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),"")) {
      if (mOp.NotEqual(m$.var("YFOART").get(),3)) {
        YLFN.set("");
        mVar YANLZ = m$.var("YANLZ");
        for (YANLZ.set(1);(true);YANLZ.set(mOp.Add(YANLZ.get(),1))) {
          YLFN.set(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get())));
          if (mOp.Equal(YLFN.get(),"")) {
            break;
          }
          do {
            //<< . new strAccessList     ; SR15509
            mVar strAccessList = m$.var("strAccessList");
            m$.newVarBlock(1,strAccessList);
            //<< .;IF +YBER'=1 IF YBER'="" IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,14)'="" IF $PIECE(^(1),Y,14)'=99 IF '$FIND(","_$TRANSLATE($PIECE(^(1),Y,14),";",",")_",",","_YBER_",") QUIT
            //<< . IF +YBER'=1 IF YBER'="" set strAccessList=$piece($get(^WWW003(0,YDATEI,YLFN,1)),Y,14) if (strAccessList'="")&&(strAccessList'=99)&&'$find(","_$translate(strAccessList,";",",")_",",","_YBER_",") quit  ; SR15509 naked ref
            if (mOp.NotEqual(mOp.Positive(m$.var("YBER").get()),1)) {
              if (mOp.NotEqual(m$.var("YBER").get(),"")) {
                strAccessList.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),14));
                if ((mOp.NotEqual(strAccessList.get(),"")) && (mOp.NotEqual(strAccessList.get(),99)) && mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(strAccessList.get(),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBER").get()),",")))) {
                  break;
                }
              }
            }
            //<< . IF $PIECE(YSUCH1,Y,6)=""  QUIT:YANLZ>8
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),"")) {
              if (mOp.Greater(YANLZ.get(),8)) {
                break;
              }
            }
            //<< . IF $PIECE(YSUCH1,Y,6)'="" QUIT:'$FIND(","_$TRANSLATE($PIECE(YSUCH1,Y,6),";",",")_",",","_YLFN_",")
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),"")) {
              if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",YLFN.get()),",")))) {
                break;
              }
            }
            //<< . SET YINHALT=$PIECE(YFELD,Y,YLFN)
            mVar YINHALT = m$.var("YINHALT");
            YINHALT.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YLFN.get()));
            //<< . SET YINHALT=$$^WWWFORMAT(YDATEI,"D",YLFN,YINHALT,3)    ;FIS;25.03.03;23255;ANZEIGE MIT FARBE
            YINHALT.set(m$.fnc$("WWWFORMAT.main",m$.var("YDATEI").get(),"D",YLFN.get(),YINHALT.get(),3));
            //<< . SET YTYP=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)
            mVar YTYP = m$.var("YTYP");
            YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),3));
            //<< . SET YFARBCODE=$PIECE(YINHALT,Y,2)
            mVar YFARBCODE = m$.var("YFARBCODE");
            YFARBCODE.set(m$.Fnc.$piece(YINHALT.get(),m$.var("Y").get(),2));
            //<< . SET YINHALT=$PIECE(YINHALT,Y,1)
            YINHALT.set(m$.Fnc.$piece(YINHALT.get(),m$.var("Y").get(),1));
            //<< . WRITE "<TD VALIGN=TOP"
            m$.Cmd.Write("<TD VALIGN=TOP");
            //<< . ;IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
            //<< . ;IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
            //<< . DO
            do {
              //<< . . IF YFARBCODE'="" WRITE " BGCOLOR="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,YFARBCODE,1)),Y,1)_"""" QUIT
              if (mOp.NotEqual(YFARBCODE.get(),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" BGCOLOR=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),YFARBCODE.get(),1)),m$.var("Y").get(),1)),"\""));
                break;
              }
              //<< . . ;IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
              //<< . . ;IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
              //<< . . IF $PIECE(YVOR,Y,83)=""  IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
                  m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
                }
              }
              //<< . . IF $PIECE(YVOR,Y,83)=""  IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
                  m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
                }
              }
              //<< . . IF $PIECE(YVOR,Y,83)'="" IF YDDSATZ#2=1 WRITE " class=""white"""  ;FIS;CUSTOMER CSS STYLESHEET;08.12.04;26564
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
                  m$.Cmd.Write(" class=\"white\"");
                }
              }
              //<< . . IF $PIECE(YVOR,Y,83)'="" IF YDDSATZ#2=0 WRITE " class=""gray"""   ;FIS;CUSTOMER CSS STYLESHEET;08.12.04;26564
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
                  m$.Cmd.Write(" class=\"gray\"");
                }
              }
            } while(false);
            //<< . ;
            //<< . IF YTYP=4||(YTYP=8)||(YTYP=12)||(YTYP=18) WRITE " ALIGN=RIGHT"        //SR13074
            if (mOp.Equal(YTYP.get(),4) || (mOp.Equal(YTYP.get(),8)) || (mOp.Equal(YTYP.get(),12)) || (mOp.Equal(YTYP.get(),18))) {
              m$.Cmd.Write(" ALIGN=RIGHT");
            }
            //<< . IF $GET(YTELE(YLFN))=1 WRITE " ALIGN=RIGHT"
            if (mOp.Equal(m$.Fnc.$get(m$.var("YTELE").var(YLFN.get())),1)) {
              m$.Cmd.Write(" ALIGN=RIGHT");
            }
            //<< . WRITE " NOWRAP>"
            m$.Cmd.Write(" NOWRAP>");
            //<< . WRITE "<DIV>"
            m$.Cmd.Write("<DIV>");
            //<< . IF $PIECE(YVOR,Y,7)'="" WRITE "<FONT SIZE="""_$PIECE(YVOR,Y,7)_""">"
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
            }
            //<< . IF $PIECE(YSUCH1,Y,12)'="" IF $FIND(","_$TRANSLATE($PIECE(YSUCH1,Y,12),";",",")_",",","_YLFN_",") DO
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),12),"")) {
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),12),";",",")),","),mOp.Concat(mOp.Concat(",",YLFN.get()),",")))) {
                //<< . . SET YADDS(YLFN)=$$GetInternal^WWWTR(8,$TRANSLATE(YINHALT," "))+$GET(YADDS(YLFN))
                mVar YADDS = m$.var("YADDS");
                YADDS.var(YLFN.get()).set(mOp.Add(m$.fnc$("WWWTR.GetInternal",8,m$.Fnc.$translate(YINHALT.get()," ")),m$.Fnc.$get(m$.var("YADDS").var(YLFN.get()))));
              }
            }
            //<< . ;
            //<< . IF $ORDER(^WWW003(0,YDATEI,YLFN))="" IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)=3 SET YINHALT=$PIECE(YFELD,Y,YLFN,9999)  ;TEXT
            if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get())),"")) {
              if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),3),3)) {
                YINHALT.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YLFN.get(),9999));
              }
            }
            //<< . DO   ;I YLFN<3 D
            do {
              //<< . . IF $FIND(YINHALT,".htm")!($FIND(YINHALT,".HTM")) QUIT
              if (mOp.Logical(mOp.Or(m$.Fnc.$find(YINHALT.get(),".htm"),(m$.Fnc.$find(YINHALT.get(),".HTM"))))) {
                break;
              }
              //<< . . WRITE "<A"
              m$.Cmd.Write("<A");
              //<< . . IF $GET(YBITSEARCH)=1 WRITE " TARGET="""_YTARGET_""""  ;FIS;BITSEARCH;23909;14.12.03
              if (mOp.Equal(m$.Fnc.$get(m$.var("YBITSEARCH")),1)) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" TARGET=\"",m$.var("YTARGET").get()),"\""));
              }
              //<< . . IF $GET(YTOOLTIP)=""  WRITE " TITLE="""_$$^WWWTEXT(374)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
              if (mOp.Equal(m$.Fnc.$get(m$.var("YTOOLTIP")),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",374)),"\""));
              }
              //<< . . IF $GET(YTOOLTIP)'="" WRITE " TITLE="""_YTOOLTIP_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTOOLTIP")),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.var("YTOOLTIP").get()),"\""));
              }
              //<< . . WRITE " HREF="""
              m$.Cmd.Write(" HREF=\"");
              //<< . . ;
              //<< . . IF $GET(YWSAVE)'="" DO   ;AUTOMATISCHER SAVE;TYBD;20,10,2003;24142
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("YWSAVE")),"")) {
                //<< . . . NEW YKEY,YFORM
                mVar YFORM = m$.var("YFORM");
                m$.newVarBlock(3,YKEY,YFORM);
                //<< . . . SET YFORM=$PIECE(YWSAVE,Y,1)
                YFORM.set(m$.Fnc.$piece(m$.var("YWSAVE").get(),m$.var("Y").get(),1));
                //<< . . . SET YKEY=$PIECE(YWSAVE,Y,2)
                YKEY.set(m$.Fnc.$piece(m$.var("YWSAVE").get(),m$.var("Y").get(),2));
                //<< . . . WRITE "JavaScript:"
                m$.Cmd.Write("JavaScript:");
                //<< . . . WRITE "retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9');"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("retval=EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),YFORM.get()),"','FIX','Y"),YFORM.get()),"','','9');"));
                //<< . . . WRITE "window.location='"
                m$.Cmd.Write("window.location='");
                //<< . . . SET YCONF3="';"
                mVar YCONF3 = m$.var("YCONF3");
                YCONF3.set("';");
              }
              m$.restoreVarBlock(3);
              //<< . . ;
              //<< . . WRITE YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
              m$.Cmd.Write(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()));
              //<< . . IF $GET(YTIMEFORM)=1 WRITE "t"  ;zeitabhängige erfassungsformular
              if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
                m$.Cmd.Write("t");
              }
              //<< . . WRITE "&amp;YSEITE="_YSEITE
              m$.Cmd.Write(mOp.Concat("&amp;YSEITE=",m$.var("YSEITE").get()));
              //<< . . ;IF $GET(YBUTTON)'="" ;W "&YOPEN=OLD"
              //<< . . DO ^WWWCGI
              m$.Cmd.Do("WWWCGI.main");
              //<< . . IF $GET(YWSAVE)'="" WRITE "';"  ;ENDE
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("YWSAVE")),"")) {
                m$.Cmd.Write("';");
              }
              //<< . . ;
              //<< . . WRITE """>"
              m$.Cmd.Write("\">");
            } while(false);
            //<< . ;
            //<< . IF $LENGTH(YINHALT)<30 IF YINHALT'="" IF $FIND(YINHALT,".htm")!($FIND(YINHALT,".HTM")) DO
            if (mOp.Less(m$.Fnc.$length(YINHALT.get()),30)) {
              if (mOp.NotEqual(YINHALT.get(),"")) {
                if (mOp.Logical(mOp.Or(m$.Fnc.$find(YINHALT.get(),".htm"),(m$.Fnc.$find(YINHALT.get(),".HTM"))))) {
                  //<< . . WRITE "<A HREF="""_YINHALT_""">"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"",YINHALT.get()),"\">"));
                }
              }
            }
            //<< . ;
            //<< . IF YINHALT="" SET datei(YANLZ)=0
            if (mOp.Equal(YINHALT.get(),"")) {
              mVar datei = m$.var("datei");
              datei.var(YANLZ.get()).set(0);
            }
            //<< . IF +$GET(datei(YANLZ))'=0 DO  ;WENN GIF ODER DOKUMENT IN ANZEIGE ;when Or paper within Show
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("datei").var(YANLZ.get()))),0)) {
              //<< . . SET YURL=""  ;$PIECE($GET(^WWW012(0,YM,1)),Y,44)  ;FIS;22903;15.04.03
              mVar YURL = m$.var("YURL");
              YURL.set("");
              //<< . . SET OPT="HEIGHT=500,WIDTH=750,SCROLLBARS=YES,RESIZEABLE=YES"
              mVar OPT = m$.var("OPT");
              OPT.set("HEIGHT=500,WIDTH=750,SCROLLBARS=YES,RESIZEABLE=YES");
              //<< . . IF '$FIND(YINHALT,"//") SET YINHALT=YGIF1_YINHALT
              if (mOp.Not(m$.Fnc.$find(YINHALT.get(),"//"))) {
                YINHALT.set(mOp.Concat(m$.var("YGIF1").get(),YINHALT.get()));
              }
              //<< . . SET URL=YURL_YINHALT
              mVar URL = m$.var("URL");
              URL.set(mOp.Concat(YURL.get(),YINHALT.get()));
              //<< . . WRITE "<INPUT TYPE=BUTTON NAME='B"_YKEY_"' onClick='var menue=window.open("""_URL_""",""DOK"","""_OPT_""");menue.focus();' VALUE='"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=BUTTON NAME='B",YKEY.get()),"' onClick='var menue=window.open(\""),URL.get()),"\",\"DOK\",\""),OPT.get()),"\");menue.focus();' VALUE='"));
            }
            //<< . ;
            //<< . ; SR15509 naked ref vvv
            //<< . ;IF YLFN=1 IF YDATEI="WWW001" IF SPRACHE'="DE" IF $PIECE(YKEY,",",1)'="" IF $DATA(^WWW0011(0,$PIECE(YKEY,",",1),SPRACHE,1)) SET YINHALT=$PIECE(^(1),Y,1)
            //<< . ;IF YLFN=1 IF YDATEI="WWW120" IF SPRACHE'="DE" IF $PIECE(YKEY,",",1)'="" IF $DATA(^WWW1201(0,$PIECE(YKEY,",",1),SPRACHE,1)) SET YINHALT=$PIECE(^(1),Y,1)
            //<< . IF YLFN=1 IF SPRACHE'="DE" IF $PIECE(YKEY,",",1)'="" do
            if (mOp.Equal(YLFN.get(),1)) {
              if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
                if (mOp.NotEqual(m$.Fnc.$piece(YKEY.get(),",",1),"")) {
                  //<< . . IF YDATEI="WWW001" IF $DATA(^WWW0011(0,$PIECE(YKEY,",",1),SPRACHE,1)) SET YINHALT=$PIECE(^WWW0011(0,$PIECE(YKEY,",",1),SPRACHE,1),Y,1)
                  if (mOp.Equal(m$.var("YDATEI").get(),"WWW001")) {
                    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0011",0,m$.Fnc.$piece(YKEY.get(),",",1),m$.var("SPRACHE").get(),1)))) {
                      YINHALT.set(m$.Fnc.$piece(m$.var("^WWW0011",0,m$.Fnc.$piece(YKEY.get(),",",1),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
                    }
                  }
                  //<< . . IF YDATEI="WWW120" IF $DATA(^WWW1201(0,$PIECE(YKEY,",",1),SPRACHE,1)) SET YINHALT=$PIECE(^WWW1201(0,$PIECE(YKEY,",",1),SPRACHE,1),Y,1)
                  if (mOp.Equal(m$.var("YDATEI").get(),"WWW120")) {
                    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1201",0,m$.Fnc.$piece(YKEY.get(),",",1),m$.var("SPRACHE").get(),1)))) {
                      YINHALT.set(m$.Fnc.$piece(m$.var("^WWW1201",0,m$.Fnc.$piece(YKEY.get(),",",1),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
                    }
                  }
                }
              }
            }
            //<< . ;
            //<< . ;SET YINHALT=$$^WWWFORMAT(YDATEI,"D",YLFN,YINHALT,0)  ;FORMAT DER DATEN  -> SIEHE OBEN
            //<< . NEW YCUT
            mVar YCUT = m$.var("YCUT");
            m$.newVarBlock(1,YCUT);
            //<< . SET YCUT=40
            YCUT.set(40);
            //<< . IF YSUCH3'="" DO
            if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
              //<< . . IF +$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2)'=0 DO   ;LÄNGENBEGRENZUNG
              if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2)),0)) {
                //<< . . . SET YCUT=+$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2)
                YCUT.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2)));
              }
            }
            //<< . . .;SET YINHALT=$EXTRACT(YINHALT,1,+$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2))
            //<< . ;
            //<< . ;IF YINHALT="" SET YINHALT="&nbsp;"
            //<< . IF $TRANSLATE(YINHALT," ")="" WRITE "&nbsp;"  ;TYBD;23,7,2004;WENN "  " Dann falsche anzeige
            if (mOp.Equal(m$.Fnc.$translate(YINHALT.get()," "),"")) {
              m$.Cmd.Write("&nbsp;");
            }
            //<< . IF +$GET(datei(YANLZ))'=0 SET YINHALT=$PIECE(YINHALT,"/",$LENGTH(YINHALT,"/"))
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("datei").var(YANLZ.get()))),0)) {
              YINHALT.set(m$.Fnc.$piece(YINHALT.get(),"/",m$.Fnc.$length(YINHALT.get(),"/")));
            }
            //<< . WRITE $$^WWWUML($EXTRACT(YINHALT,1,YCUT))
            m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$extract(YINHALT.get(),1,YCUT.get())));
            //<< . IF YSUCH3'="" DO  ;EXECUTE INNERHALB DER ANZEIGE ;EXECUTE inside the Show
            if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
              //<< . . IF $PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,3)'="" DO
              if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),3),"")) {
                //<< . . . XECUTE $PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,3)
                m$.Cmd.Xecute(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),3));
              }
            }
            //<< . ;
            //<< . IF +$GET(datei(YANLZ))'=0 DO
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("datei").var(YANLZ.get()))),0)) {
              //<< . . WRITE "'>"
              m$.Cmd.Write("'>");
              //<< . .;IF "-GIF-JPEG-JPG-"[("-"_$PIECE($$^WWWUPER(YINHALT),".",2)_"_") SET URL=YINHALT DO THUMP
              //<< . . IF "-GIF-JPEG-JPG-"[("-"_$PIECE($$$UPPER(YINHALT),".",2)_"_") SET URL=YINHALT DO THUMP
              if (mOp.Contains("-GIF-JPEG-JPG-",(mOp.Concat(mOp.Concat("-",m$.Fnc.$piece(include.COMSYSString.$$$UPPER(m$,YINHALT),".",2)),"_")))) {
                mVar URL = m$.var("URL");
                URL.set(YINHALT.get());
                m$.Cmd.Do("THUMP");
              }
            }
            //<< . ;
            //<< . IF YINHALT'="" IF $FIND(YINHALT,".GIF")||$FIND(YINHALT,".gif") SET URL=YINHALT DO THUMP
            if (mOp.NotEqual(YINHALT.get(),"")) {
              if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),".GIF")) || mOp.Logical(m$.Fnc.$find(YINHALT.get(),".gif"))) {
                mVar URL = m$.var("URL");
                URL.set(YINHALT.get());
                m$.Cmd.Do("THUMP");
              }
            }
            //<< . IF YINHALT'="" IF (YLFN=1)||$FIND(YINHALT,".htm")||$FIND(YINHALT,".HTM") DO
            if (mOp.NotEqual(YINHALT.get(),"")) {
              if ((mOp.Equal(YLFN.get(),1)) || mOp.Logical(m$.Fnc.$find(YINHALT.get(),".htm")) || mOp.Logical(m$.Fnc.$find(YINHALT.get(),".HTM"))) {
                //<< . . WRITE "</A>"
                m$.Cmd.Write("</A>");
              }
            }
            //<< . ;
            //<< . IF $EXTRACT(YINHALT)'="@" IF $FIND(YINHALT,"@") IF '$FIND(YINHALT," ") DO   ;ANZEIGE DES MAILBUTTONS ;Show
            if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get()),"@")) {
              if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),"@"))) {
                if (mOp.Not(m$.Fnc.$find(YINHALT.get()," "))) {
                  //<< . . WRITE "&nbsp;"
                  m$.Cmd.Write("&nbsp;");
                  //<< . . WRITE "<A HREF="""
                  m$.Cmd.Write("<A HREF=\"");
                  //<< . . WRITE "mailto:"
                  m$.Cmd.Write("mailto:");
                  //<< . . WRITE YINHALT
                  m$.Cmd.Write(YINHALT.get());
                  //<< . . WRITE """"
                  m$.Cmd.Write("\"");
                  //<< . . WRITE ">"
                  m$.Cmd.Write(">");
                  //<< . . WRITE YCR,"<IMG SRC="""_YGIF_"mail.gif"" ALIGN=TEXTTOP TITLE=""mail"" border=0 width=18 height=18>"
                  m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"mail.gif\" ALIGN=TEXTTOP TITLE=\"mail\" border=0 width=18 height=18>"));
                  //<< . . WRITE "</A>"
                  m$.Cmd.Write("</A>");
                }
              }
            }
            //<< . ;
            //<< . IF $GET(TELYES)=1 IF $GET(YTELE(YLFN))=1 IF +YINHALT'=0 DO  ;TELEFON BUTTON;TYBD;6,12,2004
            if (mOp.Equal(m$.Fnc.$get(m$.var("TELYES")),1)) {
              if (mOp.Equal(m$.Fnc.$get(m$.var("YTELE").var(YLFN.get())),1)) {
                if (mOp.NotEqual(mOp.Positive(YINHALT.get()),0)) {
                  //<< . . NEW FILE
                  mVar FILE = m$.var("FILE");
                  m$.newVarBlock(2,FILE);
                  //<< . . WRITE "&nbsp;"
                  m$.Cmd.Write("&nbsp;");
                  //<< . . IF $EXTRACT(YINHALT)="0" SET YINHALT="+49 "_$EXTRACT(YINHALT,2,999)  ;DE
                  if (mOp.Equal(m$.Fnc.$extract(YINHALT.get()),"0")) {
                    YINHALT.set(mOp.Concat("+49 ",m$.Fnc.$extract(YINHALT.get(),2,999)));
                  }
                  //<< . . WRITE "<A HREF=""CALLTO://"_$TRANSLATE(YINHALT,"()-.#*_  &/!?")_""""
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"CALLTO://",m$.Fnc.$translate(YINHALT.get(),"()-.#*_  &/!?")),"\""));
                  //<< . . WRITE ">"
                  m$.Cmd.Write(">");
                  //<< . . WRITE YCR,"<IMG SRC="""_YGIF_"verbind.gif"" ALIGN=TEXTTOP TITLE=""Telefon"" border=0 width=18 height=18>"
                  m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"verbind.gif\" ALIGN=TEXTTOP TITLE=\"Telefon\" border=0 width=18 height=18>"));
                  //<< . . WRITE "</A>"
                  m$.Cmd.Write("</A>");
                  //<< . ;
                  //<< . ; vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
                  //<< . ;IF $GET(TELYES)=1 IF $GET(YTELE(YLFN))=1 IF +YINHALT'=0 DO    ;ANZEIGE DES TELEFONBUTTONS ;Show
                  //<< . . NEW FILE
                  m$.newVarBlock(2,FILE);
                  //<< . . WRITE "&nbsp;"
                  m$.Cmd.Write("&nbsp;");
                  //<< . . SET FILE="ftp://"_$PIECE($GET(^WWW012(0,YM,1)),Y,46)
                  FILE.set(mOp.Concat("ftp://",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),46)));
                  //<< . . SET FILE=FILE_"T"_$EXTRACT(+$TRANSLATE(YINHALT,"()-.+#*_  &/!?"),$LENGTH(+$TRANSLATE(YINHALT,"()-.+#*_  &/!?"))-3,$LENGTH(+$TRANSLATE(YINHALT,"()-.+#*_  &/!?")))_".BAT"
                  FILE.set(mOp.Concat(mOp.Concat(mOp.Concat(FILE.get(),"T"),m$.Fnc.$extract(mOp.Positive(m$.Fnc.$translate(YINHALT.get(),"()-.+#*_  &/!?")),mOp.Subtract(m$.Fnc.$length(mOp.Positive(m$.Fnc.$translate(YINHALT.get(),"()-.+#*_  &/!?"))),3),m$.Fnc.$length(mOp.Positive(m$.Fnc.$translate(YINHALT.get(),"()-.+#*_  &/!?"))))),".BAT"));
                  //<< . . WRITE "<A HREF="""_FILE_""""
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"",FILE.get()),"\""));
                  //<< . . WRITE $TRANSLATE(YINHALT,"()-.+#*_  &/!?")_"')"
                  m$.Cmd.Write(mOp.Concat(m$.Fnc.$translate(YINHALT.get(),"()-.+#*_  &/!?"),"')"));
                  //<< . . DO ^WWWTELE($TRANSLATE(YINHALT,"()-.+#*_  &/!?"))
                  m$.Cmd.Do("WWWTELE.main",m$.Fnc.$translate(YINHALT.get(),"()-.+#*_  &/!?"));
                  //<< . . WRITE ">"
                  m$.Cmd.Write(">");
                  //<< . . WRITE YCR,"<IMG SRC="""_YGIF_"verbind.gif"" ALIGN=TEXTTOP TITLE=""Telefon"" border=0 width=18 height=18>"
                  m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"verbind.gif\" ALIGN=TEXTTOP TITLE=\"Telefon\" border=0 width=18 height=18>"));
                  //<< . . WRITE "</A>"
                  m$.Cmd.Write("</A>");
                }
                m$.restoreVarBlock(2);
              }
            }
            //<< . ; ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
            //<< . ;
            //<< . WRITE "</DIV>"
            m$.Cmd.Write("</DIV>");
            //<< . WRITE "</TD>",YCR
            m$.Cmd.Write("</TD>",m$.var("YCR").get());
          } while (false);
        }
        m$.restoreVarBlock(1);
      }
    }
    //<< 
    //<< ;WENN MIT VORGABE ;when by means of default
    //<< IF $PIECE(YSUCH1,Y,6)'="" IF YFOART'=3 DO
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),"")) {
      if (mOp.NotEqual(m$.var("YFOART").get(),3)) {
        //<< . SET $PIECE(YSUCH1,Y,6)=$TRANSLATE($PIECE(YSUCH1,Y,6),";",",")
        m$.pieceVar(m$.var("YSUCH1"),m$.var("Y").get(),6).set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),";",","));
        //<< . FOR YANLZ=1:1 SET YLFN=$PIECE($PIECE(YSUCH1,Y,6),",",YANLZ) QUIT:YLFN=""  DO
        mVar YANLZ = m$.var("YANLZ");
        for (YANLZ.set(1);(true);YANLZ.set(mOp.Add(YANLZ.get(),1))) {
          YLFN.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),6),",",YANLZ.get()));
          if (mOp.Equal(YLFN.get(),"")) {
            break;
          }
          do {
            //<< . . new strAccessList     ; SR15509
            mVar strAccessList = m$.var("strAccessList");
            m$.newVarBlock(2,strAccessList);
            //<< . .;IF +YBER'=1 IF YBER'="" IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,14)'="" IF $PIECE(^(1),Y,14)'=99 IF '$FIND(","_$TRANSLATE($PIECE(^(1),Y,14),";",",")_",",","_YBER_",") QUIT
            //<< . . IF +YBER'=1 IF YBER'="" set strAccessList=$piece($get(^WWW003(0,YDATEI,YLFN,1)),Y,14) if (strAccessList'="")&&(strAccessList'=99)&&'$find(","_$translate(strAccessList,";",",")_",",","_YBER_",") quit  ; SR15509 naked ref
            if (mOp.NotEqual(mOp.Positive(m$.var("YBER").get()),1)) {
              if (mOp.NotEqual(m$.var("YBER").get(),"")) {
                strAccessList.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),14));
                if ((mOp.NotEqual(strAccessList.get(),"")) && (mOp.NotEqual(strAccessList.get(),99)) && mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(strAccessList.get(),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBER").get()),",")))) {
                  break;
                }
              }
            }
            //<< . . SET YTYP=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)
            mVar YTYP = m$.var("YTYP");
            YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),3));
            //<< . . SET YINHALT=$PIECE(YFELD,Y,YLFN)
            mVar YINHALT = m$.var("YINHALT");
            YINHALT.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YLFN.get()));
            //<< . . SET:'pblnBlank YINHALT=$$^WWWFORMAT(YDATEI,"D",YLFN,YINHALT,3)  ;SR15452
            if (mOp.Not(pblnBlank.get())) {
              YINHALT.set(m$.fnc$("WWWFORMAT.main",m$.var("YDATEI").get(),"D",YLFN.get(),YINHALT.get(),3));
            }
            //<< . . SET YFARBCODE=$PIECE(YINHALT,Y,2)
            mVar YFARBCODE = m$.var("YFARBCODE");
            YFARBCODE.set(m$.Fnc.$piece(YINHALT.get(),m$.var("Y").get(),2));
            //<< . . SET YINHALT  =$PIECE(YINHALT,Y,1)
            YINHALT.set(m$.Fnc.$piece(YINHALT.get(),m$.var("Y").get(),1));
            //<< . . WRITE "<TD VALIGN=TOP"
            m$.Cmd.Write("<TD VALIGN=TOP");
            //<< . . ;IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
            //<< . . ;IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
            //<< . . DO
            do {
              //<< . . . IF YFARBCODE'="" WRITE " BGCOLOR="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,YFARBCODE,1)),Y,1)_"""" QUIT
              if (mOp.NotEqual(YFARBCODE.get(),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" BGCOLOR=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),YFARBCODE.get(),1)),m$.var("Y").get(),1)),"\""));
                break;
              }
              //<< . . . ;IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
              //<< . . . ;IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
              //<< . . . IF $PIECE(YVOR,Y,83)=""  IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
                  m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
                }
              }
              //<< . . . IF $PIECE(YVOR,Y,83)=""  IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
                  m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
                }
              }
              //<< . . . IF $PIECE(YVOR,Y,83)'="" IF YDDSATZ#2=1 WRITE " class=""white"""  ;FIS;CUSTOMER CSS STYLESHEET;08.12.04;26564
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
                  m$.Cmd.Write(" class=\"white\"");
                }
              }
              //<< . . . IF $PIECE(YVOR,Y,83)'="" IF YDDSATZ#2=0 WRITE " class=""gray"""  ;FIS;CUSTOMER CSS STYLESHEET;08.12.04;26564
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
                  m$.Cmd.Write(" class=\"gray\"");
                }
              }
            } while(false);
            //<< . . ;
            //<< . . IF (YTYP=4)||(YTYP=8)||(YTYP=12)||(YTYP=18)||($GET(YTELE(YLFN))=1) WRITE " ALIGN=RIGHT"     //SR13074
            if ((mOp.Equal(YTYP.get(),4)) || (mOp.Equal(YTYP.get(),8)) || (mOp.Equal(YTYP.get(),12)) || (mOp.Equal(YTYP.get(),18)) || (mOp.Equal(m$.Fnc.$get(m$.var("YTELE").var(YLFN.get())),1))) {
              m$.Cmd.Write(" ALIGN=RIGHT");
            }
            //<< . . IF $FIND(YINHALT,"@") IF $PIECE(YINHALT," ",2)="" IF '$FIND(YINHALT,"@net") WRITE " ALIGN=RIGHT"   ;TYBD;14.05.2003; KEIN " " WENN @ NUR DANN MAIL
            if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),"@"))) {
              if (mOp.Equal(m$.Fnc.$piece(YINHALT.get()," ",2),"")) {
                if (mOp.Not(m$.Fnc.$find(YINHALT.get(),"@net"))) {
                  m$.Cmd.Write(" ALIGN=RIGHT");
                }
              }
            }
            //<< . . WRITE " NOWRAP>"
            m$.Cmd.Write(" NOWRAP>");
            //<< . . WRITE "<DIV>"
            m$.Cmd.Write("<DIV>");
            //<< . . ;
            //<< . . IF $PIECE(YVOR,Y,7)'="" WRITE "<FONT SIZE="""_$PIECE(YVOR,Y,7)_""">"
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
            }
            //<< . . IF $PIECE(YSUCH1,Y,12)'="" IF $FIND(","_$TRANSLATE($PIECE(YSUCH1,Y,12),";",",")_",",","_YLFN_",") DO
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),12),"")) {
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),12),";",",")),","),mOp.Concat(mOp.Concat(",",YLFN.get()),",")))) {
                //<< . . . SET YADDS(YLFN)=$$GetInternal^WWWTR(8,$TRANSLATE(YINHALT," "))+$GET(YADDS(YLFN))
                mVar YADDS = m$.var("YADDS");
                YADDS.var(YLFN.get()).set(mOp.Add(m$.fnc$("WWWTR.GetInternal",8,m$.Fnc.$translate(YINHALT.get()," ")),m$.Fnc.$get(m$.var("YADDS").var(YLFN.get()))));
              }
            }
            //<< . . ;
            //<< . . IF $ORDER(^WWW003(0,YDATEI,YLFN))="" IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)=3 SET YINHALT=$PIECE(YFELD,Y,YLFN,9999)  ;TEXT
            if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get())),"")) {
              if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get(),1)),m$.var("Y").get(),3),3)) {
                YINHALT.set(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),YLFN.get(),9999));
              }
            }
            //<< . . DO  ;I YLFN<3 D      ;?IMMER LINK ERSTELLEN
            do {
              //<< . . . IF $FIND(YINHALT,".htm")!($FIND(YINHALT,".HTM")) QUIT
              if (mOp.Logical(mOp.Or(m$.Fnc.$find(YINHALT.get(),".htm"),(m$.Fnc.$find(YINHALT.get(),".HTM"))))) {
                break;
              }
              //<< . . . WRITE "<A"
              m$.Cmd.Write("<A");
              //<< . . . IF $PIECE(YSUCH1,Y,8)'=0 DO
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),8),0)) {
                //<< . . . . IF $GET(YTOOLTIP)=""  WRITE " TITLE="""_$$^WWWTEXT(374)_""""   ;DATENSATZ AUSWÄHLEN ;data record pick out
                if (mOp.Equal(m$.Fnc.$get(m$.var("YTOOLTIP")),"")) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",374)),"\""));
                }
                //<< . . . . IF $GET(YTOOLTIP)'="" WRITE " TITLE="""_YTOOLTIP_""""          ;DATENSATZ AUSWÄHLEN ;data record pick out
                if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTOOLTIP")),"")) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.var("YTOOLTIP").get()),"\""));
                }
              }
              //<< . . . ;
              //<< . . . IF $GET(YBITSEARCH)=1 WRITE " TARGET="""_YTARGET_""""            ;FIS;BITSEARCH;23909;14.12.03
              if (mOp.Equal(m$.Fnc.$get(m$.var("YBITSEARCH")),1)) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" TARGET=\"",m$.var("YTARGET").get()),"\""));
              }
              //<< . . . WRITE " HREF="""
              m$.Cmd.Write(" HREF=\"");
              //<< . . . ;
              //<< . . . IF $GET(YWSAVE)'="" DO   ;AUTOMATISCHER SAVE;TYBD;20,10,2003;24142
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("YWSAVE")),"")) {
                //<< . . . . NEW YKEY,YFORM
                mVar YFORM = m$.var("YFORM");
                m$.newVarBlock(4,YKEY,YFORM);
                //<< . . . . SET YFORM=$PIECE(YWSAVE,Y,1)
                YFORM.set(m$.Fnc.$piece(m$.var("YWSAVE").get(),m$.var("Y").get(),1));
                //<< . . . . SET YKEY =$PIECE(YWSAVE,Y,2)
                YKEY.set(m$.Fnc.$piece(m$.var("YWSAVE").get(),m$.var("Y").get(),2));
                //<< . . . . WRITE "JavaScript:"
                m$.Cmd.Write("JavaScript:");
                //<< . . . . WRITE "retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9');"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("retval=EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),YFORM.get()),"','FIX','Y"),YFORM.get()),"','','9');"));
                //<< . . . . WRITE "window.location='"
                m$.Cmd.Write("window.location='");
                //<< . . . . SET YCONF3="';"
                mVar YCONF3 = m$.var("YCONF3");
                YCONF3.set("';");
              }
              m$.restoreVarBlock(4);
              //<< . . . ;
              //<< . . . IF $PIECE(YSUCH1,Y,8)'=0 DO
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),8),0)) {
                //<< . . . . WRITE YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
                m$.Cmd.Write(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()));
                //<< . . . . IF $GET(YTIMEFORM)=1 WRITE "t"  ;zeitabhängige erfassungsformular
                if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
                  m$.Cmd.Write("t");
                }
                //<< . . . . WRITE "&amp;YSEITE="_YSEITE
                m$.Cmd.Write(mOp.Concat("&amp;YSEITE=",m$.var("YSEITE").get()));
                //<< . . . . ;IF $GET(YBUTTON)'="" ;W "&YOPEN=OLD"
                //<< . . . . DO ^WWWCGI
                m$.Cmd.Do("WWWCGI.main");
              }
              //<< . . . ;
              //<< . . . IF $PIECE(YSUCH1,Y,8)=0 WRITE "#"
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YSUCH1").get(),m$.var("Y").get(),8),0)) {
                m$.Cmd.Write("#");
              }
              //<< . . . IF $GET(YWSAVE)'="" WRITE "';"  ;ENDE
              if (mOp.NotEqual(m$.Fnc.$get(m$.var("YWSAVE")),"")) {
                m$.Cmd.Write("';");
              }
              //<< . . . WRITE """"
              m$.Cmd.Write("\"");
              //<< . . . WRITE ">"
              m$.Cmd.Write(">");
            } while(false);
            //<< . . ;
            //<< . . IF $LENGTH(YINHALT)<30 IF YINHALT'="" IF $FIND(YINHALT,".htm")||$FIND(YINHALT,".HTM") DO
            if (mOp.Less(m$.Fnc.$length(YINHALT.get()),30)) {
              if (mOp.NotEqual(YINHALT.get(),"")) {
                if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),".htm")) || mOp.Logical(m$.Fnc.$find(YINHALT.get(),".HTM"))) {
                  //<< . . . WRITE "<A HREF="""_YINHALT_""">"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"",YINHALT.get()),"\">"));
                }
              }
            }
            //<< . . ;
            //<< . . IF YINHALT="" SET datei(YANLZ)=0
            if (mOp.Equal(YINHALT.get(),"")) {
              mVar datei = m$.var("datei");
              datei.var(YANLZ.get()).set(0);
            }
            //<< . . IF +$GET(datei(YANLZ))'=0 DO  ;ANZEIGE VON GIF UND DOKUMENTEN ;Show And
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("datei").var(YANLZ.get()))),0)) {
              //<< . . . SET YURL=""  ;$PIECE($GET(^WWW012(0,YM,1)),Y,44)  ;FIS;22903;15.04.03
              mVar YURL = m$.var("YURL");
              YURL.set("");
              //<< . . . SET OPT="HEIGHT=500,WIDTH=750,SCROLLBARS=YES,RESIZEABLE=YES"
              mVar OPT = m$.var("OPT");
              OPT.set("HEIGHT=500,WIDTH=750,SCROLLBARS=YES,RESIZEABLE=YES");
              //<< . . . IF '$FIND(YINHALT,"//") SET YINHALT=YGIF1_YINHALT
              if (mOp.Not(m$.Fnc.$find(YINHALT.get(),"//"))) {
                YINHALT.set(mOp.Concat(m$.var("YGIF1").get(),YINHALT.get()));
              }
              //<< . . . SET URL=YURL_YINHALT
              mVar URL = m$.var("URL");
              URL.set(mOp.Concat(YURL.get(),YINHALT.get()));
              //<< . . . WRITE YCR,"<INPUT TYPE=BUTTON NAME='B"_YKEY_"' onClick='var menue=window.open("""_URL_""",""DOK"","""_OPT_""");menue.focus();' VALUE='"
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=BUTTON NAME='B",YKEY.get()),"' onClick='var menue=window.open(\""),URL.get()),"\",\"DOK\",\""),OPT.get()),"\");menue.focus();' VALUE='"));
            }
            //<< . . ;
            //<< . . ; SR15509 naked ref vvv
            //<< . .;IF YLFN=1 IF YDATEI="WWW001" IF SPRACHE'="DE" IF $PIECE(YKEY,",",1)'="" IF $DATA(^WWW0011(0,$PIECE(YKEY,",",1),SPRACHE,1)) SET YINHALT=$PIECE(^(1),Y,1)
            //<< . .;IF YLFN=1 IF YDATEI="WWW120" IF SPRACHE'="DE" IF $PIECE(YKEY,",",1)'="" IF $DATA(^WWW1201(0,$PIECE(YKEY,",",1),SPRACHE,1)) SET YINHALT=$PIECE(^(1),Y,1)
            //<< . . IF YLFN=1 IF SPRACHE'="DE" IF $PIECE(YKEY,",",1)'="" do
            if (mOp.Equal(YLFN.get(),1)) {
              if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
                if (mOp.NotEqual(m$.Fnc.$piece(YKEY.get(),",",1),"")) {
                  //<< . . . IF YDATEI="WWW001" IF $DATA(^WWW0011(0,$PIECE(YKEY,",",1),SPRACHE,1)) SET YINHALT=$PIECE(^WWW0011(0,$PIECE(YKEY,",",1),SPRACHE,1),Y,1)
                  if (mOp.Equal(m$.var("YDATEI").get(),"WWW001")) {
                    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0011",0,m$.Fnc.$piece(YKEY.get(),",",1),m$.var("SPRACHE").get(),1)))) {
                      YINHALT.set(m$.Fnc.$piece(m$.var("^WWW0011",0,m$.Fnc.$piece(YKEY.get(),",",1),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
                    }
                  }
                  //<< . . . IF YDATEI="WWW120" IF $DATA(^WWW1201(0,$PIECE(YKEY,",",1),SPRACHE,1)) SET YINHALT=$PIECE(^WWW1201(0,$PIECE(YKEY,",",1),SPRACHE,1),Y,1)
                  if (mOp.Equal(m$.var("YDATEI").get(),"WWW120")) {
                    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1201",0,m$.Fnc.$piece(YKEY.get(),",",1),m$.var("SPRACHE").get(),1)))) {
                      YINHALT.set(m$.Fnc.$piece(m$.var("^WWW1201",0,m$.Fnc.$piece(YKEY.get(),",",1),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
                    }
                  }
                }
              }
            }
            //<< . . ;
            //<< . . ;S YINHALT=$$^WWWFORMAT(YDATEI,"D",YLFN,YINHALT,0)  ;FORMAT DER DATEN  -> SIEHE OBEN
            //<< . . NEW YCUT
            mVar YCUT = m$.var("YCUT");
            m$.newVarBlock(2,YCUT);
            //<< . . SET YCUT=40
            YCUT.set(40);
            //<< . . IF YSUCH3'="" IF +$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2)'=0 DO   ;LÄNGENBEGRENZUNG
            if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
              if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2)),0)) {
                //<< . . . SET YCUT=+$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2)
                YCUT.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2)));
                //<< . . . SET YINHALT=$EXTRACT(YINHALT,1,+$PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,2))
                YINHALT.set(m$.Fnc.$extract(YINHALT.get(),1,mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),2))));
              }
            }
            //<< . .
            //<< . . ;IF YINHALT="" SET YINHALT="&nbsp;"
            //<< . . IF $TRANSLATE(YINHALT," ")="" WRITE "&nbsp;"  ;TYBD;23,7,2004;WENN "  " Dann falsche anzeige
            if (mOp.Equal(m$.Fnc.$translate(YINHALT.get()," "),"")) {
              m$.Cmd.Write("&nbsp;");
            }
            //<< . . IF +$GET(datei(YANLZ))'=0 SET YINHALT=$PIECE(YINHALT,"/",$LENGTH(YINHALT,"/"))
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("datei").var(YANLZ.get()))),0)) {
              YINHALT.set(m$.Fnc.$piece(YINHALT.get(),"/",m$.Fnc.$length(YINHALT.get(),"/")));
            }
            //<< . . ;
            //<< . . WRITE $TRANSLATE($$^WWWUML($EXTRACT(YINHALT,1,YCUT)),"|")
            m$.Cmd.Write(m$.Fnc.$translate(m$.fnc$("WWWUML.main",m$.Fnc.$extract(YINHALT.get(),1,YCUT.get())),"|"));
            //<< . . ;
            //<< . . IF YSUCH3'="" DO  ;EXECUTE INNERHALB DER ANZEIGE ;EXECUTE inside the Show
            if (mOp.NotEqual(m$.var("YSUCH3").get(),"")) {
              //<< . . . IF $PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,3)'="" DO
              if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),3),"")) {
                //<< . . . . XECUTE $PIECE($GET(^WWW1232(0,YFORM,YSUCH3,YLFN,1)),Y,3)
                m$.Cmd.Xecute(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1232",0,m$.var("YFORM").get(),m$.var("YSUCH3").get(),YLFN.get(),1)),m$.var("Y").get(),3));
              }
            }
            //<< . . ;
            //<< . . IF +$GET(datei(YANLZ))'=0 DO
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("datei").var(YANLZ.get()))),0)) {
              //<< . . . WRITE "'>"
              m$.Cmd.Write("'>");
              //<< . . . ;IF "-GIF-JPEG-JPG-"[("-"_$PIECE($$^WWWUPER(YINHALT),".",2)_"_") SET URL=YINHALT DO THUMP
              //<< . . . IF "-GIF-JPEG-JPG-"[("-"_$PIECE($zconvert(YINHALT,"U"),".",2)_"_") SET URL=YINHALT DO THUMP
              if (mOp.Contains("-GIF-JPEG-JPG-",(mOp.Concat(mOp.Concat("-",m$.Fnc.$piece(m$.Fnc.$zconvert(YINHALT.get(),"U"),".",2)),"_")))) {
                mVar URL = m$.var("URL");
                URL.set(YINHALT.get());
                m$.Cmd.Do("THUMP");
              }
            }
            //<< . . ;
            //<< . . IF YINHALT'="" IF $FIND(YINHALT,".GIF")!($FIND(YINHALT,".gif")) SET URL=YINHALT DO THUMP
            if (mOp.NotEqual(YINHALT.get(),"")) {
              if (mOp.Logical(mOp.Or(m$.Fnc.$find(YINHALT.get(),".GIF"),(m$.Fnc.$find(YINHALT.get(),".gif"))))) {
                mVar URL = m$.var("URL");
                URL.set(YINHALT.get());
                m$.Cmd.Do("THUMP");
              }
            }
            //<< . . IF YINHALT'="" IF YLFN=1!($FIND(YINHALT,".htm"))!($FIND(YINHALT,".HTM")) DO
            if (mOp.NotEqual(YINHALT.get(),"")) {
              if (mOp.Logical(mOp.Or(mOp.Or(mOp.Equal(YLFN.get(),1),(m$.Fnc.$find(YINHALT.get(),".htm"))),(m$.Fnc.$find(YINHALT.get(),".HTM"))))) {
                //<< . . . WRITE "</A>"
                m$.Cmd.Write("</A>");
              }
            }
            //<< . . ;
            //<< . . IF $EXTRACT(YINHALT)'="@" IF $FIND(YINHALT,"@") IF '$FIND(YINHALT," ") DO
            if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get()),"@")) {
              if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),"@"))) {
                if (mOp.Not(m$.Fnc.$find(YINHALT.get()," "))) {
                  //<< . . . WRITE "&nbsp;"
                  m$.Cmd.Write("&nbsp;");
                  //<< . . . WRITE "<A HREF="""
                  m$.Cmd.Write("<A HREF=\"");
                  //<< . . . WRITE "mailto:"
                  m$.Cmd.Write("mailto:");
                  //<< . . . WRITE YINHALT
                  m$.Cmd.Write(YINHALT.get());
                  //<< . . . WRITE """"
                  m$.Cmd.Write("\"");
                  //<< . . . WRITE ">"
                  m$.Cmd.Write(">");
                  //<< . . . WRITE YCR,"<IMG SRC="""_YGIF_"mail.gif"" ALIGN=TEXTTOP TITLE=""mail"" border=0 width=18 height=18>"
                  m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"mail.gif\" ALIGN=TEXTTOP TITLE=\"mail\" border=0 width=18 height=18>"));
                  //<< . . . WRITE "</A>"
                  m$.Cmd.Write("</A>");
                }
              }
            }
            //<< . . ;
            //<< . . IF $GET(TELYES)=1 IF $GET(YTELE(YLFN))=1 IF +YINHALT'=0 DO  ;TELEFON BUTTON;TYBD;6,12,2004
            if (mOp.Equal(m$.Fnc.$get(m$.var("TELYES")),1)) {
              if (mOp.Equal(m$.Fnc.$get(m$.var("YTELE").var(YLFN.get())),1)) {
                if (mOp.NotEqual(mOp.Positive(YINHALT.get()),0)) {
                  //<< . . . NEW FILE
                  mVar FILE = m$.var("FILE");
                  m$.newVarBlock(3,FILE);
                  //<< . . . WRITE "&nbsp;"
                  m$.Cmd.Write("&nbsp;");
                  //<< . . . IF $EXTRACT(YINHALT)="0" SET YINHALT="+49 "_$EXTRACT(YINHALT,2,999)  ;DE
                  if (mOp.Equal(m$.Fnc.$extract(YINHALT.get()),"0")) {
                    YINHALT.set(mOp.Concat("+49 ",m$.Fnc.$extract(YINHALT.get(),2,999)));
                  }
                  //<< . . . WRITE "<A HREF=""CALLTO://"_$TRANSLATE(YINHALT,"()-.#*_  &/!?")_""""
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"CALLTO://",m$.Fnc.$translate(YINHALT.get(),"()-.#*_  &/!?")),"\""));
                  //<< . . . WRITE ">"
                  m$.Cmd.Write(">");
                  //<< . . . WRITE YCR,"<IMG SRC="""_YGIF_"verbind.gif"" ALIGN=TEXTTOP TITLE=""Telefon"" border=0 width=18 height=18>"
                  m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"verbind.gif\" ALIGN=TEXTTOP TITLE=\"Telefon\" border=0 width=18 height=18>"));
                  //<< . . . WRITE "</A>"
                  m$.Cmd.Write("</A>");
                  //<< . . ;
                  //<< . . ; vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
                  //<< . . ;IF $GET(TELYES)=1 IF $GET(YTELE(YLFN))=1 IF +YINHALT'=0 DO  ;TELEFON BUTTON
                  //<< . . . NEW FILE
                  m$.newVarBlock(3,FILE);
                  //<< . . . WRITE "&nbsp;"
                  m$.Cmd.Write("&nbsp;");
                  //<< . . . SET FILE="ftp://"_$PIECE($GET(^WWW012(0,YM,1)),Y,46)
                  FILE.set(mOp.Concat("ftp://",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),46)));
                  //<< . . . SET FILE=FILE_"T"_$EXTRACT(+$TRANSLATE(YINHALT,"()-.+#*_  &/!?"),$LENGTH(+$TRANSLATE(YINHALT,"()-.+#*_  &/!?"))-3,$LENGTH(+$TRANSLATE(YINHALT,"()-.+#*_  &/!?")))_".BAT"
                  FILE.set(mOp.Concat(mOp.Concat(mOp.Concat(FILE.get(),"T"),m$.Fnc.$extract(mOp.Positive(m$.Fnc.$translate(YINHALT.get(),"()-.+#*_  &/!?")),mOp.Subtract(m$.Fnc.$length(mOp.Positive(m$.Fnc.$translate(YINHALT.get(),"()-.+#*_  &/!?"))),3),m$.Fnc.$length(mOp.Positive(m$.Fnc.$translate(YINHALT.get(),"()-.+#*_  &/!?"))))),".BAT"));
                  //<< . . . WRITE "<A HREF="""_FILE_""""
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"",FILE.get()),"\""));
                  //<< . . . WRITE $TRANSLATE(YINHALT,"()-.#*_  &/!?")_"')"
                  m$.Cmd.Write(mOp.Concat(m$.Fnc.$translate(YINHALT.get(),"()-.#*_  &/!?"),"')"));
                  //<< . . . DO ^WWWTELE($TRANSLATE(YINHALT,"()-.#*_  &/!?"))
                  m$.Cmd.Do("WWWTELE.main",m$.Fnc.$translate(YINHALT.get(),"()-.#*_  &/!?"));
                  //<< . . . WRITE ">"
                  m$.Cmd.Write(">");
                  //<< . . . WRITE YCR,"<IMG SRC="""_YGIF_"verbind.gif"" ALIGN=TEXTTOP TITLE=""Telefon"" border=0 width=18 height=18>"
                  m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"verbind.gif\" ALIGN=TEXTTOP TITLE=\"Telefon\" border=0 width=18 height=18>"));
                  //<< . . . WRITE "</A>"
                  m$.Cmd.Write("</A>");
                }
                m$.restoreVarBlock(3);
              }
            }
            //<< . . ; ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
            //<< . . ;
            //<< . . WRITE "</DIV>"
            m$.Cmd.Write("</DIV>");
            //<< . . WRITE "</TD>",YCR
            m$.Cmd.Write("</TD>",m$.var("YCR").get());
          } while (false);
        }
        m$.restoreVarBlock(2);
      }
    }
    //<< 
    //<< WRITE "</TR>",YCR
    m$.Cmd.Write("</TR>",m$.var("YCR").get());
    //<< QUIT
    return null;
  }

  //<< 
  //<< KEY ;FORMAT KEY  ACHTUNG EINSPRUNG zb aus ^WWWFORM4   (EINSPRUNG MIT YDATEI,YLFN,YINHALT)
  public void KEY() {
    //<< SET YINHALT =$$^WWWFORMAT(YDATEI,"P",YLFN,YINHALT,0)
    mVar YINHALT = m$.var("YINHALT");
    YINHALT.set(m$.fnc$("WWWFORMAT.main",m$.var("YDATEI").get(),"P",m$.var("YLFN").get(),m$.var("YINHALT").get(),0));
    //<< SET YINHALTK=$$^WWWFORMAT(YDATEI,"P",YLFN,YINHALT,2)
    mVar YINHALTK = m$.var("YINHALTK");
    YINHALTK.set(m$.fnc$("WWWFORMAT.main",m$.var("YDATEI").get(),"P",m$.var("YLFN").get(),YINHALT.get(),2));
    //<< QUIT
    return;
  }

  //<< 
  //<< DATEN ;FORMAT DATEN  ACHTUNG EINSPRUNG VON AUSSEN  (YDATEI,LFN,YINHALT)
  public void DATEN() {
    //<< SET YINHALT=$$^WWWFORMAT(YDATEI,"D",YLFN,YINHALT,0)
    mVar YINHALT = m$.var("YINHALT");
    YINHALT.set(m$.fnc$("WWWFORMAT.main",m$.var("YDATEI").get(),"D",m$.var("YLFN").get(),m$.var("YINHALT").get(),0));
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
    //<< SET YINHALT=$$GetLiteral^WWWTR(YTYP,YINHALT)
    mVar YINHALT = m$.var("YINHALT");
    YINHALT.set(m$.fnc$("WWWTR.GetLiteral",m$.var("YTYP").get(),m$.var("YINHALT").get()));
    //<< ;I YTYP=8!(YTYP=12) S YINHALT=$E("              ",1,(12-$L(YINHALT)))_YINHALT Q
    //<< IF YTYP=8 IF $GET(YWHR)'="" SET YINHALT=YINHALT_" "_$$^WWWWHR(YWHR)   ;WÄHRUNG ANZEIGEN ;money standard display
    if (mOp.Equal(m$.var("YTYP").get(),8)) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YWHR")),"")) {
        YINHALT.set(mOp.Concat(mOp.Concat(YINHALT.get()," "),m$.fnc$("WWWWHR.main",m$.var("YWHR").get())));
      }
    }
    //<< IF YTYP=5 SET YINHALT=$EXTRACT("*****************",1,$LENGTH(YINHALT)) QUIT
    if (mOp.Equal(m$.var("YTYP").get(),5)) {
      YINHALT.set(m$.Fnc.$extract("*****************",1,m$.Fnc.$length(YINHALT.get())));
      return null;
    }
    //<< IF YTYP=3 SET YINHALT=$EXTRACT($PIECE(YINHALT,"|",1),1,200) SET:$EXTRACT(YINHALT,200)'="" YINHALT=YINHALT_"..." QUIT
    if (mOp.Equal(m$.var("YTYP").get(),3)) {
      YINHALT.set(m$.Fnc.$extract(m$.Fnc.$piece(YINHALT.get(),"|",1),1,200));
      if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),200),"")) {
        YINHALT.set(mOp.Concat(YINHALT.get(),"..."));
      }
      return null;
    }
    //<< QUIT
    return null;
  }

  //<< 
  //<< THUMP ;BILD ;portrait
  public void THUMP() {
    //<< NEW YSATZ,YBBN,YQ,PATH
    mVar YSATZ = m$.var("YSATZ");
    mVar YBBN = m$.var("YBBN");
    mVar YQ = m$.var("YQ");
    mVar PATH = m$.var("PATH");
    m$.newVar(YSATZ,YBBN,YQ,PATH);
    //<< 
    //<< QUIT:'$DATA(URL)
    if (mOp.Not(m$.Fnc.$data(m$.var("URL")))) {
      return;
    }
    //<< QUIT:URL=""
    if (mOp.Equal(m$.var("URL").get(),"")) {
      return;
    }
    //<< SET YQ=0
    YQ.set(0);
    //<< QUIT:$FIND(URL,";")
    if (mOp.Logical(m$.Fnc.$find(m$.var("URL").get(),";"))) {
      return;
    }
    //<< 
    //<< IF '$FIND(URL,"/")  DO
    if (mOp.Not(m$.Fnc.$find(m$.var("URL").get(),"/"))) {
      do {
        //<< . IF $GET(YFORM)'="" IF $GET(YLFN)'="" DO  QUIT:YQ=1   ;WENN ANDERES VERZEICHNIS ;when tabulation
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLFN")),"")) {
            //<< . . SET YBBN=$ORDER(^WWW122s(0,4,YLFN,YFORM,""))
            YBBN.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,m$.var("YLFN").get(),m$.var("YFORM").get(),"")));
            //<< . . IF YBBN'="" DO
            if (mOp.NotEqual(YBBN.get(),"")) {
              do {
                //<< . . . SET YSATZ=$GET(^WWW122(0,YFORM,YBBN,1))
                YSATZ.set(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YBBN.get(),1)));
                //<< . . . SET PATH=$PIECE(YSATZ,Y,57)
                PATH.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),57));
                //<< . . . IF PATH="YGIF"  SET URL=YGIF_YINHALT  SET YQ=1 QUIT
                if (mOp.Equal(PATH.get(),"YGIF")) {
                  mVar URL = m$.var("URL");
                  URL.set(mOp.Concat(m$.var("YGIF").get(),m$.var("YINHALT").get()));
                  YQ.set(1);
                  break;
                }
                //<< . . . IF PATH="YGIF1" SET URL=YGIF1_YINHALT SET YQ=1 QUIT
                if (mOp.Equal(PATH.get(),"YGIF1")) {
                  mVar URL = m$.var("URL");
                  URL.set(mOp.Concat(m$.var("YGIF1").get(),m$.var("YINHALT").get()));
                  YQ.set(1);
                  break;
                }
                //<< . . . IF PATH'="" DO  QUIT
                if (mOp.NotEqual(PATH.get(),"")) {
                  //<< . . . . IF $FIND(PATH,"##") DO
                  if (mOp.Logical(m$.Fnc.$find(PATH.get(),"##"))) {
                    //<< . . . . . SET PATH=$PIECE(PATH,"##",1)_$PIECE($TRANSLATE($PIECE($GET(^WWW012(0,YM,1)),Y,1),"-,+#/\()[]")," ",1)_$PIECE(PATH,"##",2)
                    PATH.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(PATH.get(),"##",1),m$.Fnc.$piece(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),1),"-,+#/\\()[]")," ",1)),m$.Fnc.$piece(PATH.get(),"##",2)));
                  }
                  //<< . . . . ;
                  //<< . . . . SET URL=PATH_URL
                  mVar URL = m$.var("URL");
                  URL.set(mOp.Concat(PATH.get(),m$.var("URL").get()));
                  //<< . . . . SET YQ=1
                  YQ.set(1);
                  break;
                }
              } while (false);
            }
            if (mOp.Equal(YQ.get(),1)) {
              break;
            }
          }
        }
        //<< . ;
        //<< . ;I $E(YFORM,1,4)="INLP" S URL=YGIF_URL Q  ;TYBD;TEST LAGERPLATZ
        //<< . SET:$EXTRACT(YFORM,1,3)'="WWW" URL=YGIF1_URL
        if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
          m$.var("URL").set(mOp.Concat(m$.var("YGIF1").get(),m$.var("URL").get()));
        }
        //<< . SET:$EXTRACT(YFORM,1,3)="WWW" URL=YGIF_URL
        if (mOp.Equal(m$.Fnc.$extract(m$.var("YFORM").get(),1,3),"WWW")) {
          m$.var("URL").set(mOp.Concat(m$.var("YGIF").get(),m$.var("URL").get()));
        }
      } while (false);
    }
    //<< 
    //<< IF '$FIND(URL,".GIF") IF '$FIND(URL,".gif") DO
    if (mOp.Not(m$.Fnc.$find(m$.var("URL").get(),".GIF"))) {
      if (mOp.Not(m$.Fnc.$find(m$.var("URL").get(),".gif"))) {
        //<< . WRITE "<A onClick='return doLink(this)' HREF='JavaScript:document.WWW.B"_YKEY_".click();'>"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<A onClick='return doLink(this)' HREF='JavaScript:document.WWW.B",m$.var("YKEY").get()),".click();'>"));
      }
    }
    //<< 
    //<< WRITE YCR,"<IMG SRC="""_$PIECE(URL," ",1)_""" BORDER=1 WIDTH="""_60_""" ALIGN=RIGHT TITLE="""_$PIECE(YINHALT,".",1)_""" border=0>"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.Fnc.$piece(m$.var("URL").get()," ",1)),"\" BORDER=1 WIDTH=\""),60),"\" ALIGN=RIGHT TITLE=\""),m$.Fnc.$piece(m$.var("YINHALT").get(),".",1)),"\" border=0>"));
    //<< WRITE "</A>"
    m$.Cmd.Write("</A>");
    //<< QUIT
    return;
  }

//<< 
//<< 
}
