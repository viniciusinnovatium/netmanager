//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMENU1
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:36
//*****************************************************************************

import mLibrary.*;


//<< WWWMENU1 ;WWWMENU1;DT;INFACHES INTERNET MENU;29.04.1998
public class WWWMENU1 extends mClass {

  public void main() {
    _WWWMENU1();
  }

  public void _WWWMENU1() {
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      INFACHES INTERNET MENU
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
    //<< ;| 14-Oct-2005      RPW     SR13680: Make all $translate($piece(YA,Y,12),"/YUCI/","/"_$get(YUCI)_"/" into $$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")
    //<< ;| DT   29.04.1998
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< ;PICTURES
    //<< ;IF $PIECE(YVOR,Y,19)="" DO
    //<< ;. IF $PIECE(YVOR,Y,2)'="" DO
    //<< ;. . IF $PIECE(YVOR,Y,21)=1 WRITE "<CENTER>"
    //<< ;. . WRITE "<IMG SRC="_""""_YGIF_$PIECE(YVOR,Y,2)_""""_">"
    //<< ;. . IF $PIECE(YVOR,Y,21)=1 WRITE "</CENTER>"
    //<< ;. . QUIT
    //<< ;. WRITE YCR
    //<< ;. QUIT
    //<< IF SPRACHE'="DE" IF $PIECE($PIECE(YVOR,Y,11),",",2)'="" SET $PIECE(YVOR,Y,11)=$PIECE($PIECE(YVOR,Y,11),",",2)
    if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11),",",2),"")) {
        m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),11).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11),",",2));
      }
    }
    //<< SET $PIECE(YVOR,Y,11)=$PIECE($PIECE(YVOR,Y,11),",",1)
    m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),11).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11),",",1));
    //<< ;HEADER
    //<< ;DO
    //<< ;. IF $PIECE(YVOR,Y,21)=1 WRITE "<CENTER>"
    //<< ;. IF $PIECE(YVOR,Y,11)'="" DO ^WWWUP(0) WRITE "<H3>"_$PIECE($PIECE(YVOR,Y,11),",",1)_"</H3>"
    //<< ;. IF $PIECE(YVOR,Y,21)=1 WRITE "</CENTER>"
    //<< ;. QUIT
    //<< ;IF $PIECE(YVOR,Y,21)=1 WRITE "<CENTER>"
    //<< IF $PIECE(YVOR,Y,9)="" WRITE "<PRE>"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),9),"")) {
      m$.Cmd.Write("<PRE>");
    }
    //<< ;IF $PIECE(YVOR,Y,20)=1 WRITE YCR,"<TABLE CELLSPACING=0 BORDER=1><TR><TD NOWRAP>"
    //<< ;IF $PIECE(YVOR,Y,20)=1 do
    //<< ;. WRITE YCR,"</TABLE></TD></TR></TABLE>"
    //<< ;. ;WRITE YCR,"<BR>"
    //<< ;. write "<TABLE CELLSPACING=0 BORDER=1><TR><TD><TABLE CELLSPACING=0>"
    //<< ;. QUIT
    //<< SET YAPP="" FOR  SET YAPP=$ORDER(^WWW004(0,YAPP)) QUIT:YAPP=""  DO
    mVar YAPP = m$.var("YAPP");
    YAPP.set("");
    for (;true;) {
      YAPP.set(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get())));
      if (mOp.Equal(YAPP.get(),"")) {
        break;
      }
      do {
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
            //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROG_";") SET YQ=0 Q   ;BERECHTIGT;TYBD;7,1,2004
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),YAPP.get())))) {
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),YAPP.get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROG.get()),";")))) {
                YQ.set(0);
                break;
              }
            }
            //<< . . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
            mVar YA = m$.var("YA");
            YA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),YPROG.get(),1)));
            //<< . . QUIT:$PIECE(YA,Y,7)="noshow"  ;keine anzeige ;None
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"noshow")) {
              break;
            }
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
        //<< . SET YPROG="" FOR  SET YPROG=$ORDER(^WWW004(0,YAPP,YPROG)) QUIT:YPROG=""  DO
        YPROG.set("");
        for (;true;) {
          YPROG.set(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get(),YPROG.get())));
          if (mOp.Equal(YPROG.get(),"")) {
            break;
          }
          do {
            //<< . . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
            mVar YA = m$.var("YA");
            YA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),YPROG.get(),1)));
            //<< . . QUIT:$PIECE(YA,Y,7)="noshow"  ;keine anzeige ;None
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"noshow")) {
              break;
            }
            //<< . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") DO
            if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
              do {
                //<< . . . SET YQ=1
                YQ.set(1);
                //<< . . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROG_";") DO  SET YQ=0 QUIT  ;BERECHTIGT
                if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),YAPP.get())))) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),YAPP.get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROG.get()),";")))) {
                    do {
                      //<< . . . . IF $PIECE(YA,Y,2)'="" SET ^WWWUSE(0,YUSER,$PIECE(YA,Y,2),"A",1)="Form Access"
                      if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                        m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"A",1).set("Form Access");
                      }
                      //<< . . . . QUIT
                      break;
                    } while (false);
                    YQ.set(0);
                    break;
                  }
                }
                //<< . . . IF $FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") SET YQ=0 QUIT
                if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
                  YQ.set(0);
                  break;
                }
                //<< . . . IF $$^WWWACCESS($PIECE(YA,Y,3),$PIECE(YA,Y,4))=1 SET YQ=0  ;ZUGANG
                if (mOp.Equal(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4)),1)) {
                  YQ.set(0);
                }
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . QUIT:YQ=1
            if (mOp.Equal(YQ.get(),1)) {
              break;
            }
            //<< . . IF $DATA(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,YAPP.get(),YPROG.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
              m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
            }
            //<< . . SET YAA=$GET(^WWW004(0,YAPP,$PIECE(YPROG,".",1)_".",1))
            mVar YAA = m$.var("YAA");
            YAA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),mOp.Concat(m$.Fnc.$piece(YPROG.get(),".",1),"."),1)));
            //<< . . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") QUIT:$$^WWWACCESS($PIECE(YA,Y,3),$PIECE(YA,Y,4))'=1  ;KEIN ZUGANG
            if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
              if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4)),1)) {
                break;
              }
            }
            //<< . . ;IF $PIECE(YPROG,".",1)'="" IF '$DATA(YZW1(YAPP,$PIECE(YPROG,".",1)))  ;NO HEADER;TYBD
            //<< . . SET YNAME=$$^WWWUML($PIECE(YA,Y,1))
            mVar YNAME = m$.var("YNAME");
            YNAME.set(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
            //<< . . IF $PIECE(YPROG,".",2)="" DO  IF $PIECE($ORDER(^WWW004(0,YAPP,YPROG)),".",2)'="" QUIT
            if (mOp.Equal(m$.Fnc.$piece(YPROG.get(),".",2),"")) {
              do {
                //<< . . . ;IF $PIECE(YVOR,Y,22)'=1 WRITE "<BR>"
                //<< . . . IF '$DATA(YZW(YAPP)) DO
                if (mOp.Not(m$.Fnc.$data(m$.var("YZW").var(YAPP.get())))) {
                  do {
                    //<< . . . . DO
                    do {
                      //<< . . . . . ;WRITE "<BR>"
                      //<< . . . . . WRITE "<H3>"
                      m$.Cmd.Write("<H3>");
                      //<< . . . . . WRITE "<A NAME="_"""" WRITE "v"_$PIECE(YAPP,"/",1) WRITE """"_">"
                      m$.Cmd.Write(mOp.Concat("<A NAME=","\""));
                      m$.Cmd.Write(mOp.Concat("v",m$.Fnc.$piece(YAPP.get(),"/",1)));
                      m$.Cmd.Write(mOp.Concat("\"",">"));
                      //<< . . . . . ;WRITE "<IMG SRC="_""""_YGIF_"bullet.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0>"
                      //<< . . . . . SET YAPPP=YAPP
                      mVar YAPPP = m$.var("YAPPP");
                      YAPPP.set(YAPP.get());
                      //<< . . . . . IF $PIECE($GET(^WWW00411(0,YAPP,SPRACHE,1)),Y,1)'="" SET YAPPP=$PIECE(^(1),Y,1)  ;LANGUAGETEXT OF APPLICATION;TYBD;30.8.2004
                      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW00411",0,YAPP.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
                        YAPPP.set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
                      }
                      //<< . . . . . WRITE $$^WWWUML($TRANSLATE(YAPPP,"_"," "))_"</H3>"
                      m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWUML.main",m$.Fnc.$translate(YAPPP.get(),"_"," ")),"</H3>"));
                      //<< . . . . . ;W YCR,"<BR>"
                      //<< . . . . . QUIT
                      break;
                    } while(false);
                    //<< . . . . SET YZW(YAPP)=""
                    mVar YZW = m$.var("YZW");
                    YZW.var(YAPP.get()).set("");
                    //<< . . . . KILL YZW1
                    m$.var("YZW1").kill();
                    //<< . . . . QUIT
                    break;
                  } while (false);
                }
                //<< . . . WRITE "<H4>"
                m$.Cmd.Write("<H4>");
                //<< . . . ;
                //<< . . . WRITE "&nbsp;&nbsp;"_YNAME
                m$.Cmd.Write(mOp.Concat("&nbsp;&nbsp;",YNAME.get()));
                //<< . . . WRITE "</H4>"
                m$.Cmd.Write("</H4>");
                //<< . . . SET YZW1(YAPP,$PIECE(YPROG,".",1))=""
                mVar YZW1 = m$.var("YZW1");
                YZW1.var(YAPP.get(),m$.Fnc.$piece(YPROG.get(),".",1)).set("");
                //<< . . . ;DO ^WWWUP(1)
                //<< . . . ;WRITE YCR,"<BR>"
                //<< . . . QUIT
                break;
              } while (false);
              if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get(),YPROG.get())),".",2),"")) {
                break;
              }
            }
            //<< . . SET YFORM=$PIECE(YA,Y,2)
            mVar YFORM = m$.var("YFORM");
            YFORM.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2));
            //<< . . SET YPARA=$PIECE(YA,Y,7)_Y_$PIECE(YA,Y,5)
            mVar YPARA = m$.var("YPARA");
            YPARA.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),m$.var("Y").get()),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),5)));
            //<< . . ;
            //<< . . WRITE "&nbsp;&nbsp;&nbsp;&nbsp;"
            m$.Cmd.Write("&nbsp;&nbsp;&nbsp;&nbsp;");
            //<< . . SET YORDNER="html.gif"
            mVar YORDNER = m$.var("YORDNER");
            YORDNER.set("html.gif");
            //<< . . IF YFORM'="" SET YXART=$PIECE($GET(^WWW120(0,YFORM,1)),Y,2) DO
            if (mOp.NotEqual(YFORM.get(),"")) {
              mVar YXART = m$.var("YXART");
              YXART.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),2));
              do {
                //<< . . . SET YORDNER="html.gif"
                YORDNER.set("html.gif");
                //<< . . . IF $PIECE(YA,Y,8)'="" DO
                if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),"")) {
                  do {
                    //<< . . . . SET YORDNER=$PIECE(YA,Y,8)
                    YORDNER.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8));
                    //<< . . . . quit
                    break;
                  } while (false);
                }
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . IF $PIECE(YVOR,Y,102)'="" SET YORDNER=$PIECE(YVOR,Y,102)  ;FESTE VORGABE ;default
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),102),"")) {
              YORDNER.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),102));
            }
            //<< . . IF $PIECE(YA,Y,2)'="" DO
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
              do {
                //<< . . . NEW YNAME
                m$.newVar(YNAME);
                //<< . . . SET YAUFRUF="WWWFORM"
                mVar YAUFRUF = m$.var("YAUFRUF");
                YAUFRUF.set("WWWFORM");
                //<< . . . IF $PIECE(YA,Y,13)=1 SET YAUFRUF="WWWSEAR"
                if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),1)) {
                  YAUFRUF.set("WWWSEAR");
                }
                //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP="),YAUFRUF.get()),"&amp;YFORM="),YFORM.get()));
                //<< . . . SET YNAME=$PIECE(YA,Y,1)
                YNAME.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1));
                //<< . . . DO ^WWWCGI
                m$.Cmd.Do("WWWCGI.main");
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
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . IF $PIECE(YA,Y,12)'="" DO  ;URL
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
              do {
                //<< . . . WRITE "<A HREF="_""""
                m$.Cmd.Write(mOp.Concat("<A HREF=","\""));
                //<< . . . IF '$FIND($PIECE(YA,Y,12),":") WRITE "http://"_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
                if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
                  m$.Cmd.Write(mOp.Concat("http://",m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/"))));
                }
                //<< . . . IF $FIND($PIECE(YA,Y,12),":") WRITE $$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
                if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
                  m$.Cmd.Write(m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/")));
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
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_YORDNER_""""_" TITLE="_$$^WWWTEXT(7)_" border=0>" WRITE "&nbsp;"
            if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),YORDNER.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",7))," border=0>"));
              m$.Cmd.Write("&nbsp;");
            }
            //<< . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "<B>"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                m$.Cmd.Write("<B>");
              }
            }
            //<< . . WRITE YNAME
            m$.Cmd.Write(YNAME.get());
            //<< . . ;W YAPP,"/",YPROG  ;TEST
            //<< . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "</B>"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                m$.Cmd.Write("</B>");
              }
            }
            //<< . . IF $PIECE(YA,Y,2)'=""!$PIECE(YA,Y,12)'="" WRITE "</A>"
            if (mOp.NotEqual(mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12)),"")) {
              m$.Cmd.Write("</A>");
            }
            //<< . . ;IF $PIECE(YA,Y,15)'="" DO
            //<< . . . FOR YI=1:1 QUIT:$PIECE($PIECE(YA,Y,15),"|",YI,99)=""  WRITE YCR,"<BR>"_$PIECE($PIECE(YA,Y,15),"|",YI)
            //<< . . . QUIT
            //<< . . DO
            do {
              //<< . . . WRITE YCR,"<BR>"
              m$.Cmd.Write(m$.var("YCR").get(),"<BR>");
              //<< . . . QUIT
              break;
            } while(false);
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . QUIT
        break;
      } while (false);
    }
    //<< QUIT
    return;
  }

//<< 
}
