//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMENU5
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:07
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

//<< WWWMENU5 ;WWWMENU5;DT;MENU SEPARAT PLUS-MINUS  ;23.04.1998  ; Compiled January 18, 2005 16:18:11
public class WWWMENU5 extends mClass {

  public void main() {
    _WWWMENU5();
  }

  public void _WWWMENU5() {
    //<< 
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      MENU SEPARAT PLUS-MINUS
    //<< ;|
    //<< ;| Inputs :
    //<< ;|
    //<< ;|
    //<< ;| ByRef :
    //<< ;|
    //<< ;|
    //<< ;| Returns :
    //<< ;|
    //<< ;|
    //<< ;| History :
    //<< ;|
    //<< ;| 23-Mar-2009  shobby  SR16427: Add some additional javascript references so that calls can be made back to cache
    //<< ;|                               from popup menu forms.
    //<< ;| DT   23.04.1998
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< ;(C) BY DITMAR TYBUSSEK
    //<< ;WRITE YCR,"<SCRIPT LANGUAGE=JAVASCRIPT>"
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< if $$SR16427^WWWFORMJavascript() do EventValue^WWWFORMJavascript()      ;SR16427
    if (mOp.Logical(m$.fnc$("WWWFORMJavascript.SR16427"))) {
      m$.Cmd.Do("WWWFORMJavascript.EventValue");
    }
    //<< WRITE YCR,"function call(x)"
    m$.Cmd.Write(m$.var("YCR").get(),"function call(x)");
    //<< WRITE YCR,"{"
    m$.Cmd.Write(m$.var("YCR").get(),"{");
    //<< SET YPARA=""
    mVar YPARA = m$.var("YPARA");
    YPARA.set("");
    //<< if $$SR16427^WWWFORMJavascript() write YCR," EventValue('"_YUCI_"','"_YUSER_"','"_$get(YFORM)_"','FIX','End^WWWEND','"_YM_"','6','"_YUSER_"'); "  ;SR16427
    if (mOp.Logical(m$.fnc$("WWWFORMJavascript.SR16427"))) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.Fnc.$get(m$.var("YFORM"))),"','FIX','End^WWWEND','"),m$.var("YM").get()),"','6','"),m$.var("YUSER").get()),"'); "));
    }
    //<< WRITE YCR,"y=x+'" DO ^WWWCGI WRITE "';"
    m$.Cmd.Write(m$.var("YCR").get(),"y=x+'");
    m$.Cmd.Do("WWWCGI.main");
    m$.Cmd.Write("';");
    //<< WRITE YCR,"window.opener.location.href=y;"
    m$.Cmd.Write(m$.var("YCR").get(),"window.opener.location.href=y;");
    //<< 
    //<< WRITE YCR,"window.opener.focus();"
    m$.Cmd.Write(m$.var("YCR").get(),"window.opener.focus();");
    //<< WRITE YCR,"}"
    m$.Cmd.Write(m$.var("YCR").get(),"}");
    //<< ;WRITE YCR,"</SCRIPT>"
    //<< ;WRITE YCR,"<SCRIPT LANGUAGE=JAVASCRIPT>"
    //<< WRITE YCR,"function call1(y)"
    m$.Cmd.Write(m$.var("YCR").get(),"function call1(y)");
    //<< WRITE YCR,"{"
    m$.Cmd.Write(m$.var("YCR").get(),"{");
    //<< WRITE YCR,"window.opener.location.href=y;"
    m$.Cmd.Write(m$.var("YCR").get(),"window.opener.location.href=y;");
    //<< WRITE YCR,"window.opener.focus();"
    m$.Cmd.Write(m$.var("YCR").get(),"window.opener.focus();");
    //<< WRITE YCR,"}"
    m$.Cmd.Write(m$.var("YCR").get(),"}");
    //<< 
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< ;WRITE "<sup>"
    //<< ;WRITE "<BIG>"
    //<< ;SET YTARGET=$PIECE(YVOR,Y,19)
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
    //<< IF $PIECE(YVOR,Y,20)=1 WRITE YCR,"<TABLE BORDER=1 CELLSPACING=0><TR><TD NOWRAP>"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),20),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=1 CELLSPACING=0><TR><TD NOWRAP>");
    }
    //<< IF $PIECE(YVOR,Y,20)'=1 WRITE "<NOBR>"
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),20),1)) {
      m$.Cmd.Write("<NOBR>");
    }
    //<< IF YANZ="" WRITE "<A NAME='TARGET'></A>"
    if (mOp.Equal(m$.var("YANZ").get(),"")) {
      m$.Cmd.Write("<A NAME='TARGET'></A>");
    }
    //<< IF YANZ'="" DO
    if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
      do {
        //<< . NEW YANZ
        mVar YANZ = m$.var("YANZ");
        m$.newVarBlock(1,YANZ);
        //<< . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
        //<< . SET YANZ=""
        YANZ.set("");
        //<< . DO ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< . WRITE """"
        m$.Cmd.Write("\"");
        //<< . WRITE ">"
        m$.Cmd.Write(">");
        //<< . QUIT
        break;
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< WRITE "<IMG SRC="_""""_YGIF_"aplatz.gif"_""""_" width=18 height=18 border=0 align=top>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"aplatz.gif"),"\"")," width=18 height=18 border=0 align=top>"));
    //<< WRITE $PIECE(YVOR,Y,11)
    m$.Cmd.Write(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11));
    //<< IF YANZ'="" WRITE "</A>"
    if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
      m$.Cmd.Write("</A>");
    }
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
    //<< ;WRITE "</sup>"
    //<< ;WRITE "</BIG>"
    //<< QUIT
    return;
  }

  //<< 
  //<< PGM ;
  public void PGM() {
    //<< SET YAPP="" FOR  SET YAPP=$ORDER(^WWW004(0,YAPP)) QUIT:YAPP=""  DO
    mVar YAPP = m$.var("YAPP");
    YAPP.set("");
    for (;true;) {
      YAPP.set(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get())));
      if (mOp.Equal(YAPP.get(),"")) {
        break;
      }
      do {
        //<< . SET YEND=0 IF $ORDER(^WWW004(0,YAPP))="" SET YEND=1
        mVar YEND = m$.var("YEND");
        YEND.set(0);
        if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get())),"")) {
          YEND.set(1);
        }
        //<< . IF YAPP=YANZ WRITE "<A NAME='TARGET'></A>"
        if (mOp.Equal(YAPP.get(),m$.var("YANZ").get())) {
          m$.Cmd.Write("<A NAME='TARGET'></A>");
        }
        //<< . SET YQ=1
        mVar YQ = m$.var("YQ");
        YQ.set(1);
        //<< . SET YPROG="" FOR  SET YPROG=$ORDER(^WWW004(0,YAPP,YPROG)) QUIT:YPROG=""  DO  QUIT:YQ=0
        mVar YPROG = m$.var("YPROG");
        YPROG.set("");
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
            //<< . . QUIT
            break;
          } while (false);
          if (mOp.Equal(YQ.get(),0)) {
            break;
          }
        }
        //<< . QUIT:YQ=1
        if (mOp.Equal(YQ.get(),1)) {
          break;
        }
        //<< . WRITE YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . WRITE "<BR>"
        m$.Cmd.Write("<BR>");
        //<< . IF YANZ=""!($PIECE(YANZ,",",1)'=YAPP) DO
        if (mOp.Or(mOp.Equal(m$.var("YANZ").get(),""),(mOp.NotEqual(m$.Fnc.$piece(m$.var("YANZ").get(),",",1),YAPP.get())))) {
          do {
            //<< . . NEW YANZ
            mVar YANZ = m$.var("YANZ");
            m$.newVarBlock(2,YANZ);
            //<< . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
            //<< . . SET YANZ=YAPP
            YANZ.set(YAPP.get());
            //<< . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . WRITE """"_">"
            m$.Cmd.Write(mOp.Concat("\"",">"));
            //<< . . QUIT
            break;
          } while (false);
        }
        m$.restoreVarBlock(2);
        //<< . IF YANZ'="" IF $PIECE(YANZ,",",1)=YAPP DO
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YANZ").get(),",",1),YAPP.get())) {
            do {
              //<< . . NEW YANZ
              mVar YANZ = m$.var("YANZ");
              m$.newVarBlock(2,YANZ);
              //<< . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
              //<< . . SET YANZ=""
              YANZ.set("");
              //<< . . DO ^WWWCGI
              m$.Cmd.Do("WWWCGI.main");
              //<< . . WRITE """"_">"
              m$.Cmd.Write(mOp.Concat("\"",">"));
              //<< . . QUIT
              break;
            } while (false);
          }
          m$.restoreVarBlock(2);
        }
        //<< . IF YANZ="" DO
        if (mOp.Equal(m$.var("YANZ").get(),"")) {
          do {
            //<< . . IF YEND=0 WRITE "<IMG SRC="_""""_YGIF_"plus.gif"_""""_" border=0 align=top>"
            if (mOp.Equal(YEND.get(),0)) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"plus.gif"),"\"")," border=0 align=top>"));
            }
            //<< . . IF YEND'=0 WRITE "<IMG SRC="_""""_YGIF_"eplus.gif"_""""_" border=0 align=top>"
            if (mOp.NotEqual(YEND.get(),0)) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eplus.gif"),"\"")," border=0 align=top>"));
            }
            //<< . . WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . IF YANZ'="" IF $PIECE(YANZ,",",1)'=YAPP DO
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YANZ").get(),",",1),YAPP.get())) {
            do {
              //<< . . IF YEND=0 WRITE "<IMG SRC="_""""_YGIF_"plus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>" QUIT
              if (mOp.Equal(YEND.get(),0)) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"plus.gif"),"\"")," border=0 align=top>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
                break;
              }
              //<< . . WRITE "<IMG SRC="_""""_YGIF_"eplus.gif"_""""_" border=0 align=top>"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eplus.gif"),"\"")," border=0 align=top>"));
              //<< . . WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
              //<< . . QUIT
              break;
            } while (false);
          }
        }
        //<< . IF YANZ'="" IF $PIECE(YANZ,",",1)=YAPP DO
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YANZ").get(),",",1),YAPP.get())) {
            do {
              //<< . . IF YEND=0 WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top>"
              if (mOp.Equal(YEND.get(),0)) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top>"));
              }
              //<< . . IF YEND'=0 WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top>"
              if (mOp.NotEqual(YEND.get(),0)) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top>"));
              }
              //<< . . WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
              //<< . . QUIT
              break;
            } while (false);
          }
        }
        //<< . SET YAPPP=YAPP
        mVar YAPPP = m$.var("YAPPP");
        YAPPP.set(YAPP.get());
        //<< . IF $PIECE($GET(^WWW00411(0,YAPP,SPRACHE,1)),Y,1)'="" SET YAPPP=$PIECE(^(1),Y,1)  ;LANGUAGETEXT OF APPLICATION;TYBD;30.8.2004
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW00411",0,YAPP.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
          YAPPP.set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
        }
        //<< . WRITE " ",$TR($$^WWWUML(YAPPP),"_"," ")_"</A>"
        m$.Cmd.Write(" ",mOp.Concat(m$.Fnc.$translate(m$.fnc$("WWWUML.main",YAPPP.get()),"_"," "),"</A>"));
        //<< . IF YANZ'="" IF YAPP=$PIECE(YANZ,",",1) DO BER
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(YAPP.get(),m$.Fnc.$piece(m$.var("YANZ").get(),",",1))) {
            m$.Cmd.Do("BER");
          }
        }
        //<< . QUIT
        break;
      } while (false);
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< Event()
  public Object Event(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add some additional javascript references so that calls can be made back to cache
    //<< ; from popup menu forms.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 30-Jul-2013   shobby      SR18053: Stylesheets for Big buttons.
    //<< ; 21-Apr-2011   shobby      SR17998: Stylesheets for MegaMenu
    //<< ; 23-Mar-2009   shobby      SR16427: Created
    //<< ;-------------------------------------------------------------------------------
    //<< WRITE YCR,"<SCRIPT LANGUAGE=JavaScript SRC="""_YGIF_"eventbroker"_"en"_+$GET(YHYPER)_".js""></SCRIPT>",!
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<SCRIPT LANGUAGE=JavaScript SRC=\"",m$.var("YGIF").get()),"eventbroker"),"en"),mOp.Positive(m$.Fnc.$get(m$.var("YHYPER")))),".js\"></SCRIPT>"),"\n");
    //<< WRITE YCR,"<SCRIPT LANGUAGE=JavaScript SRC="""_YGIF_"discPDADesigner.js""></SCRIPT>",! //SR17584
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<SCRIPT LANGUAGE=JavaScript SRC=\"",m$.var("YGIF").get()),"discPDADesigner.js\"></SCRIPT>"),"\n");
    //<< if YBED["SHOBBY" WRITE YCR,"<SCRIPT LANGUAGE=JavaScript SRC="""_YGIF_"discCalendar.js""></SCRIPT>",! //SR17460
    if (mOp.Contains(m$.var("YBED").get(),"SHOBBY")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<SCRIPT LANGUAGE=JavaScript SRC=\"",m$.var("YGIF").get()),"discCalendar.js\"></SCRIPT>"),"\n");
    }
    //<< if YBED["SHOBBY" write "<link rel=""stylesheet"" type=""text/css"" href="""_YGIF_"discCalendar.css"" />",!  //SR17460
    if (mOp.Contains(m$.var("YBED").get(),"SHOBBY")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<link rel=\"stylesheet\" type=\"text/css\" href=\"",m$.var("YGIF").get()),"discCalendar.css\" />"),"\n");
    }
    //<< write "<link rel=""stylesheet"" type=""text/css"" href="""_YGIF_"/Buttons/buttons.css"" />",!  ;SR18053
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<link rel=\"stylesheet\" type=\"text/css\" href=\"",m$.var("YGIF").get()),"/Buttons/buttons.css\" />"),"\n");
    //<< ;if YBED["SHOBBY" WRITE YCR,"<SCRIPT LANGUAGE=JavaScript SRC="""_YGIF_"crossbrowsersupport.js""></SCRIPT>",! //SR17460
    //<< write "<link rel=""stylesheet"" type=""text/css"" href="""_YGIF_"menu.css"" />",!  ;SR17998
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<link rel=\"stylesheet\" type=\"text/css\" href=\"",m$.var("YGIF").get()),"menu.css\" />"),"\n");
    //<< write $$Cspxml^WWWFORMJavascript(YQUERY),!
    m$.Cmd.Write(m$.fnc$("WWWFORMJavascript.Cspxml",m$.var("YQUERY").get()),"\n");
    //<< write YCR_"<script language=JavaScript src=""/csp/broker/cspbroker.js""></script>",!
    m$.Cmd.Write(mOp.Concat(m$.var("YCR").get(),"<script language=JavaScript src=\"/csp/broker/cspbroker.js\"></script>"),"\n");
    //<< 
    //<< //write YCR_"<script type='text/javascript' src='"_YGIF_"ieemu.js'></script>",! ;SR17253
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< BER
  public void BER() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 20-Oct-2006   Steve S     BR014276: Don't use doLink(this) / removed redundant Quits
    //<< ;-------------------------------------------------------------------------------
    //<< SET YQ=0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< SET YPROG="" FOR  SET YPROG=$ORDER(^WWW004(0,YAPP,YPROG)) QUIT:YPROG=""  DO
    mVar YPROG = m$.var("YPROG");
    YPROG.set("");
    for (;true;) {
      YPROG.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG.get())));
      if (mOp.Equal(YPROG.get(),"")) {
        break;
      }
      do {
        //<< . QUIT:$PIECE(YPROG,".",2,9)'=""
        if (mOp.NotEqual(m$.Fnc.$piece(YPROG.get(),".",2,9),"")) {
          break;
        }
        //<< . IF (YAPP_","_YPROG)=YANZ WRITE "<A NAME='TARGET'></A>"
        if (mOp.Equal((mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),YPROG.get())),m$.var("YANZ").get())) {
          m$.Cmd.Write("<A NAME='TARGET'></A>");
        }
        //<< . SET YBEND=0 IF $PIECE($ORDER(^WWW004(0,YAPP,""),-1),".",1)=$PIECE(YPROG,".",1) SET YBEND=1
        mVar YBEND = m$.var("YBEND");
        YBEND.set(0);
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),""),mOp.Negative(1)),".",1),m$.Fnc.$piece(YPROG.get(),".",1))) {
          YBEND.set(1);
        }
        //<< . SET YP0END=0 IF $PIECE($ORDER(^WWW004(0,YAPP,YPROG)),".",1)'=$PIECE(YPROG,".",1) SET YP0END=1
        mVar YP0END = m$.var("YP0END");
        YP0END.set(0);
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG.get())),".",1),m$.Fnc.$piece(YPROG.get(),".",1))) {
          YP0END.set(1);
        }
        //<< . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG.get(),1)));
        //<< . Q:$PIECE(YA,Y,7)="noshow"  ;keine anzeige ;None
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"noshow")) {
          break;
        }
        //<< . SET YQ=0
        YQ.set(0);
        //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" SET YQ=1 SET YPROGP=YPROG FOR  SET YPROGP=$ORDER(^WWW004(0,YAPP,YPROGP)) QUIT:$EXTRACT(YPROGP,1,$LENGTH(YPROG))'=YPROG  QUIT:YPROGP=""  DO  QUIT:YQ=0
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
            YQ.set(1);
            mVar YPROGP = m$.var("YPROGP");
            YPROGP.set(YPROG.get());
            for (;true;) {
              YPROGP.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGP.get())));
              if (mOp.NotEqual(m$.Fnc.$extract(YPROGP.get(),1,m$.Fnc.$length(YPROG.get())),YPROG.get())) {
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
                //<< . . QUIT
                break;
              } while (false);
              if (mOp.Equal(YQ.get(),0)) {
                break;
              }
            }
          }
        }
        //<< . QUIT:YQ=1
        if (mOp.Equal(YQ.get(),1)) {
          break;
        }
        //<< . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") DO
        if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
          do {
            //<< . . SET YQ=1
            YQ.set(1);
            //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROG_";") SET YQ=0 QUIT  ;BERECHTIGT
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get())))) {
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROG.get()),";")))) {
                YQ.set(0);
                break;
              }
            }
            //<< . . IF $FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") SET YQ=0 QUIT
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
              YQ.set(0);
              break;
            }
            //<< . . IF $$^WWWACCESS($PIECE(YA,Y,3),$PIECE(YA,Y,4))=1 SET YQ=0  ;ZUGANG
            if (mOp.Equal(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4)),1)) {
              YQ.set(0);
            }
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . QUIT:YQ=1
        if (mOp.Equal(YQ.get(),1)) {
          break;
        }
        //<< . IF $DATA(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,m$.var("YAPP").get(),YPROG.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
          m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
        }
        //<< . WRITE YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . WRITE "<BR>"
        m$.Cmd.Write("<BR>");
        //<< . SET YASTART=0
        mVar YASTART = m$.var("YASTART");
        YASTART.set(0);
        //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" DO
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
            //<< . . IF YPROG'=($PIECE($PIECE(YANZ,",",2),".",1)_".") DO
            if (mOp.NotEqual(YPROG.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
              do {
                //<< . . . NEW YANZ
                mVar YANZ = m$.var("YANZ");
                m$.newVarBlock(3,YANZ);
                //<< . . . SET YASTART=1
                YASTART.set(1);
                //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
                //<< . . . SET YANZ=YAPP_","_YPROG
                YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),YPROG.get()));
                //<< . . . DO ^WWWCGI
                m$.Cmd.Do("WWWCGI.main");
                //<< . . . WRITE """"_">"
                m$.Cmd.Write(mOp.Concat("\"",">"));
                //<< . . . QUIT
                break;
              } while (false);
            }
            m$.restoreVarBlock(3);
            //<< . . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") DO
            if (mOp.Equal(YPROG.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
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
              //<< . . . WRITE """"_">"
              m$.Cmd.Write(mOp.Concat("\"",">"));
            }
            m$.restoreVarBlock(3);
          }
        }
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
            do {
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
              //<< . . . //SR BR014276
              //<< . . . WRITE "<A HREF=""JavaScript:call('"_YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM_"&amp;YPARA="_YPARA_"')"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=\"JavaScript:call('",m$.var("YAKTION").get()),"EP="),YAUFRUF.get()),"&amp;YFORM="),YFORM.get()),"&amp;YPARA="),YPARA.get()),"')"));
              //<< . . . //WRITE "<A onClick='return doLink(this)' HREF=""JavaScript:call('"_YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM_"&amp;YPARA="_YPARA_"')"
              //<< . . . SET YNAME=$PIECE(YA,Y,1)
              YNAME.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1));
              //<< . . . WRITE """"
              m$.Cmd.Write("\"");
              //<< . . . WRITE ">"
              m$.Cmd.Write(">");
              //<< . . . QUIT
              break;
            } while (false);
          }
          m$.restoreVarBlock(3);
          //<< . . IF $PIECE(YA,Y,12)'="" DO  ;URL
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
            //<< . . . SET YORDNER="ordner4.gif"
            mVar YORDNER = m$.var("YORDNER");
            YORDNER.set("ordner4.gif");
            //<< . . . SET YASTART=1
            YASTART.set(1);
            //<< . . . WRITE "<A HREF="_""""
            m$.Cmd.Write(mOp.Concat("<A HREF=","\""));
            //<< . . . WRITE "javascript:call1('"
            m$.Cmd.Write("javascript:call1('");
            //<< . . . IF '$FIND($PIECE(YA,Y,12),":") WRITE "http://"
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
              m$.Cmd.Write("http://");
            }
            //<< . . . ;WRITE $PIECE(YA,Y,12)
            //<< . . . WRITE $$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$G(YUCI)_"/")  ;YUCI ; SR13680
            m$.Cmd.Write(m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/")));
            //<< . . . WRITE "')"
            m$.Cmd.Write("')");
            //<< . . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . . WRITE ">"
            m$.Cmd.Write(">");
          }
        }
        //<< . IF YEND=0 WRITE "<IMG SRC="_""""_YGIF_"iplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YEND").get(),0)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"iplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YEND=1 WRITE "<IMG SRC="_""""_YGIF_"bplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YEND").get(),1)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"bplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YBEND=0 DO
        if (mOp.Equal(YBEND.get(),0)) {
          do {
            //<< . . SET BPLUS="plus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="tplus.gif"
            mVar BPLUS = m$.var("BPLUS");
            BPLUS.set("plus.gif");
            if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
              BPLUS.set("tplus.gif");
            }
            //<< . . IF YPROG'=($PIECE($PIECE(YANZ,",",2),".",1)_".") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
            if (mOp.NotEqual(YPROG.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
            }
            //<< . . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
            if (mOp.Equal(YPROG.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
            }
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . IF YBEND=1 DO
        if (mOp.Equal(YBEND.get(),1)) {
          do {
            //<< . . SET BPLUS="eplus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
            mVar BPLUS = m$.var("BPLUS");
            BPLUS.set("eplus.gif");
            if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
              BPLUS.set("lplus.gif");
            }
            //<< . . IF YPROG'=($PIECE($PIECE(YANZ,",",2),".",1)_".") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
            if (mOp.NotEqual(YPROG.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
            }
            //<< . . IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
            if (mOp.Equal(YPROG.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
            }
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . IF $DATA(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,m$.var("YAPP").get(),YPROG.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
          m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
        }
        //<< . WRITE $$^WWWUML($PIECE(YA,Y,1))
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
        //<< . IF YASTART=1 WRITE "</A>"
        if (mOp.Equal(YASTART.get(),1)) {
          m$.Cmd.Write("</A>");
        }
        //<< . IF YANZ'="" IF YPROG=($PIECE($PIECE(YANZ,",",2),".",1)_".") SET YLEV=1 DO PRO
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(YPROG.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1),".")))) {
            mVar YLEV = m$.var("YLEV");
            YLEV.set(1);
            m$.Cmd.Do("PRO");
          }
        }
      } while (false);
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< PRO
  public void PRO() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 20-Oct-2006   Steve S     BR014276: Don't use doLink(this) / removed redundant Quits
    //<< ;-------------------------------------------------------------------------------
    //<< SET YPROG1=YPROG FOR  SET YPROG1=$ORDER(^WWW004(0,YAPP,YPROG1)) QUIT:YPROG1=""  QUIT:$EXTRACT(YPROG1,1,$LENGTH(YPROG))'=YPROG  DO
    mVar YPROG1 = m$.var("YPROG1");
    YPROG1.set(m$.var("YPROG").get());
    for (;true;) {
      YPROG1.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG1.get())));
      if (mOp.Equal(YPROG1.get(),"")) {
        break;
      }
      if (mOp.NotEqual(m$.Fnc.$extract(YPROG1.get(),1,m$.Fnc.$length(m$.var("YPROG").get())),m$.var("YPROG").get())) {
        break;
      }
      do {
        //<< . QUIT:$PIECE(YPROG1,".",3,9)'=""
        if (mOp.NotEqual(m$.Fnc.$piece(YPROG1.get(),".",3,9),"")) {
          break;
        }
        //<< . IF (YAPP_","_YPROG1)=YANZ WRITE "<A NAME='TARGET'></A>"
        if (mOp.Equal((mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),YPROG1.get())),m$.var("YANZ").get())) {
          m$.Cmd.Write("<A NAME='TARGET'></A>");
        }
        //<< . SET YB1END=0 IF $PIECE($ORDER(^WWW004(0,YAPP,YPROG1_$CHAR(255))),".",1)'=$PIECE(YPROG1,".",1) SET YB1END=1
        mVar YB1END = m$.var("YB1END");
        YB1END.set(0);
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),mOp.Concat(YPROG1.get(),m$.Fnc.$char(255)))),".",1),m$.Fnc.$piece(YPROG1.get(),".",1))) {
          YB1END.set(1);
        }
        //<< . SET YP1END=0 IF $PIECE($ORDER(^WWW004(0,YAPP,YPROG1_$CHAR(255))),".",1,2)'=$PIECE(YPROG1,".",1,2) SET YP1END=1
        mVar YP1END = m$.var("YP1END");
        YP1END.set(0);
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),mOp.Concat(YPROG1.get(),m$.Fnc.$char(255)))),".",1,2),m$.Fnc.$piece(YPROG1.get(),".",1,2))) {
          YP1END.set(1);
        }
        //<< . SET YA=$GET(^WWW004(0,YAPP,YPROG1,1))
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG1.get(),1)));
        //<< . Q:$PIECE(YA,Y,7)="noshow"  ;keine anzeige ;None
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"noshow")) {
          break;
        }
        //<< . SET YQ=0
        mVar YQ = m$.var("YQ");
        YQ.set(0);
        //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" SET YQ=1 SET YPROGP=YPROG1 FOR  SET YPROGP=$ORDER(^WWW004(0,YAPP,YPROGP)) QUIT:$EXTRACT(YPROGP,1,$LENGTH(YPROG1))'=YPROG1  QUIT:YPROGP=""  DO  QUIT:YQ=0
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
            YQ.set(1);
            mVar YPROGP = m$.var("YPROGP");
            YPROGP.set(YPROG1.get());
            for (;true;) {
              YPROGP.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGP.get())));
              if (mOp.NotEqual(m$.Fnc.$extract(YPROGP.get(),1,m$.Fnc.$length(YPROG1.get())),YPROG1.get())) {
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
                //<< . . QUIT
                break;
              } while (false);
              if (mOp.Equal(YQ.get(),0)) {
                break;
              }
            }
          }
        }
        //<< . QUIT:YQ=1
        if (mOp.Equal(YQ.get(),1)) {
          break;
        }
        //<< . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") DO
        if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
          do {
            //<< . . SET YQ=1
            YQ.set(1);
            //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROG1_";") SET YQ=0 QUIT  ;BERECHTIGT
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get())))) {
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROG1.get()),";")))) {
                YQ.set(0);
                break;
              }
            }
            //<< . . IF $FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") SET YQ=0 QUIT
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
              YQ.set(0);
              break;
            }
            //<< . . IF $$^WWWACCESS($PIECE(YA,Y,3),$PIECE(YA,Y,4))=1 SET YQ=0  ;ZUGANG
            if (mOp.Equal(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4)),1)) {
              YQ.set(0);
            }
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . QUIT:YQ=1
        if (mOp.Equal(YQ.get(),1)) {
          break;
        }
        //<< . IF $DATA(^WWW0041(0,YAPP,YPROG1,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,m$.var("YAPP").get(),YPROG1.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
          m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
        }
        //<< . WRITE YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . WRITE "<BR>"
        m$.Cmd.Write("<BR>");
        //<< . SET YASTART=0
        mVar YASTART = m$.var("YASTART");
        YASTART.set(0);
        //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" DO
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
            //<< . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
            if (mOp.NotEqual(YPROG1.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
              do {
                //<< . . . NEW YANZ
                mVar YANZ = m$.var("YANZ");
                m$.newVarBlock(3,YANZ);
                //<< . . . SET YASTART=1
                YASTART.set(1);
                //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
                //<< . . . SET YANZ=YAPP_","_YPROG1
                YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),YPROG1.get()));
                //<< . . . DO ^WWWCGI
                m$.Cmd.Do("WWWCGI.main");
                //<< . . . WRITE """"_">"
                m$.Cmd.Write(mOp.Concat("\"",">"));
                //<< . . . QUIT
                break;
              } while (false);
            }
            m$.restoreVarBlock(3);
            //<< . . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO
            if (mOp.Equal(YPROG1.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
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
              //<< . . . WRITE """"_">"
              m$.Cmd.Write(mOp.Concat("\"",">"));
            }
            m$.restoreVarBlock(3);
          }
        }
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
            do {
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
              //<< . . . //SR BR014276
              //<< . . . WRITE "<A HREF=""JavaScript:call('"_YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM_"&amp;YPARA="_YPARA_"')"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=\"JavaScript:call('",m$.var("YAKTION").get()),"EP="),YAUFRUF.get()),"&amp;YFORM="),YFORM.get()),"&amp;YPARA="),YPARA.get()),"')"));
              //<< . . . //WRITE "<A onClick='return doLink(this)' HREF=""JavaScript:call('"_YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM_"&amp;YPARA="_YPARA_"')"
              //<< . . . SET YNAME=$PIECE(YA,Y,1)
              YNAME.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1));
              //<< . . . WRITE """"
              m$.Cmd.Write("\"");
              //<< . . . WRITE ">"
              m$.Cmd.Write(">");
              //<< . . . QUIT
              break;
            } while (false);
          }
          m$.restoreVarBlock(3);
          //<< . . IF $PIECE(YA,Y,12)'="" DO  ;URL
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
            //<< . . . SET YORDNER="ordner4.gif"
            mVar YORDNER = m$.var("YORDNER");
            YORDNER.set("ordner4.gif");
            //<< . . . SET YASTART=1
            YASTART.set(1);
            //<< . . . WRITE "<A HREF="_""""
            m$.Cmd.Write(mOp.Concat("<A HREF=","\""));
            //<< . . . WRITE "javascript:call1('"
            m$.Cmd.Write("javascript:call1('");
            //<< . . . IF '$FIND($PIECE(YA,Y,12),":") WRITE "http://"
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
              m$.Cmd.Write("http://");
            }
            //<< . . . ;WRITE $PIECE(YA,Y,12)
            //<< . . . WRITE $$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI ; SR13680
            m$.Cmd.Write(m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/")));
            //<< . . . WRITE "')"
            m$.Cmd.Write("')");
            //<< . . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . . WRITE ">"
            m$.Cmd.Write(">");
          }
        }
        //<< . IF YEND=0 WRITE "<IMG SRC="_""""_YGIF_"iplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YEND").get(),0)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"iplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YEND=1 WRITE "<IMG SRC="_""""_YGIF_"bplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YEND").get(),1)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"bplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YBEND=0 WRITE "<IMG SRC="_""""_YGIF_"iplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YBEND").get(),0)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"iplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YBEND=1 WRITE "<IMG SRC="_""""_YGIF_"bplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YBEND").get(),1)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"bplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YP1END=1 DO
        if (mOp.Equal(YP1END.get(),1)) {
          //<< . . IF YB1END=0 DO
          if (mOp.Equal(YB1END.get(),0)) {
            do {
              //<< . . . SET BPLUS="plus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="tplus.gif"
              mVar BPLUS = m$.var("BPLUS");
              BPLUS.set("plus.gif");
              if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                BPLUS.set("tplus.gif");
              }
              //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
              if (mOp.NotEqual(YPROG1.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
              }
              //<< . . . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
              if (mOp.Equal(YPROG1.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top>"));
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
              }
              //<< . . . QUIT
              break;
            } while (false);
          }
          //<< . . IF YB1END=1 DO
          if (mOp.Equal(YB1END.get(),1)) {
            //<< . . . SET BPLUS="eplus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
            mVar BPLUS = m$.var("BPLUS");
            BPLUS.set("eplus.gif");
            if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
              BPLUS.set("lplus.gif");
            }
            //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
            if (mOp.NotEqual(YPROG1.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
            }
            //<< . . . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
            if (mOp.Equal(YPROG1.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
            }
          }
        }
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
            //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
            if (mOp.NotEqual(YPROG1.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
            }
            //<< . . . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
            if (mOp.Equal(YPROG1.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
            }
          }
          //<< . . IF YB1END=1 DO
          if (mOp.Equal(YB1END.get(),1)) {
            //<< . . . SET BPLUS="eplus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
            mVar BPLUS = m$.var("BPLUS");
            BPLUS.set("eplus.gif");
            if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
              BPLUS.set("lplus.gif");
            }
            //<< . . . IF YPROG1'=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
            if (mOp.NotEqual(YPROG1.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
            }
            //<< . . . IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 align=top>"
            if (mOp.Equal(YPROG1.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top>"));
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 align=top>"));
            }
          }
        }
        //<< . IF $DATA(^WWW0041(0,YAPP,YPROG1,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,m$.var("YAPP").get(),YPROG1.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
          m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
        }
        //<< . WRITE $$^WWWUML($PIECE(YA,Y,1))
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
        //<< . IF YASTART=1 WRITE "</A>"
        if (mOp.Equal(YASTART.get(),1)) {
          m$.Cmd.Write("</A>");
        }
        //<< . IF YANZ'="" IF YPROG1=($PIECE($PIECE(YANZ,",",2),".",1,2)_".") DO PRO1
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(YPROG1.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,2),".")))) {
            m$.Cmd.Do("PRO1");
          }
        }
      } while (false);
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< PRO1 ;
  public void PRO1() {
    //<< DO ^WWWMENUW
    m$.Cmd.Do("WWWMENUW.main");
    //<< QUIT
    return;
  }

}
