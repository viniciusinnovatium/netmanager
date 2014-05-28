//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMENU6
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:23
//*****************************************************************************

import mLibrary.*;


//<< WWWMENU6 ;WWWMENU6;DT;MENU SEPARAT MAP  ;26.10.1999
public class WWWMENU6 extends mClass {

  public void main() {
    _WWWMENU6();
  }

  public void _WWWMENU6() {
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      MENU SEPARAT MAP
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
    //<< ;| DT   26.10.1999
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< ;(C) BY DITMAR TYBUSSEK
    //<< IF YANZ'="" DO BILD IF YBILD="" SET YANZ=""
    if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
      m$.Cmd.Do("BILD");
      if (mOp.Equal(m$.var("YBILD").get(),"")) {
        mVar YANZ = m$.var("YANZ");
        YANZ.set("");
      }
    }
    //<< IF YANZ="" SET YBILD=$PIECE(YVOR,Y,2)
    if (mOp.Equal(m$.var("YANZ").get(),"")) {
      mVar YBILD = m$.var("YBILD");
      YBILD.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),2));
    }
    //<< IF YBILD="" DO ^WWWMENU1 QUIT  ;KEIN BILDVORHANDEN ;no
    if (mOp.Equal(m$.var("YBILD").get(),"")) {
      m$.Cmd.Do("WWWMENU1.main");
      return;
    }
    //<< IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YBER=1!(YBER="") DO  ;WENN ADMINISTRATOR = ANZEIGE DER NUMMERN
    if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
      if (mOp.Or(mOp.Equal(m$.var("YBER").get(),1),(mOp.Equal(m$.var("YBER").get(),"")))) {
        do {
          //<< . WRITE YCR
          m$.Cmd.Write(m$.var("YCR").get());
          //<< . WRITE "<A HREF="_""""_"#start"_""""_">"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),"#start"),"\""),">"));
          //<< . WRITE "<IMG SRC="_""""_YGIF_YBILD_""""_" border=0 TITLE="_""""_$PIECE(YVOR,Y,2)_""""_" USEMAP="_""""_"#WWW_MAP"_""""_" ISMAP>"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),m$.var("YBILD").get()),"\"")," border=0 TITLE="),"\""),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),2)),"\"")," USEMAP="),"\""),"#WWW_MAP"),"\"")," ISMAP>"));
          //<< . WRITE "</A>"
          m$.Cmd.Write("</A>");
          //<< . WRITE YCR
          m$.Cmd.Write(m$.var("YCR").get());
          //<< . QUIT
          break;
        } while (false);
      }
    }
    //<< IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YBER'=1 IF YBER'="" DO
    if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
      if (mOp.NotEqual(m$.var("YBER").get(),1)) {
        if (mOp.NotEqual(m$.var("YBER").get(),"")) {
          do {
            //<< . WRITE "<IMG SRC="_""""_YGIF_YBILD_""""_" BORDER=0 TITLE="_""""_$PIECE(YVOR,Y,2)_""""_" USEMAP="_""""_"#WWW_MAP"_""""_">"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),m$.var("YBILD").get()),"\"")," BORDER=0 TITLE="),"\""),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),2)),"\"")," USEMAP="),"\""),"#WWW_MAP"),"\""),">"));
            //<< . QUIT
            break;
          } while (false);
        }
      }
    }
    //<< WRITE "<MAP NAME="_""""_"WWW_MAP"_""""_">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<MAP NAME=","\""),"WWW_MAP"),"\""),">"));
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< DO MAIN
    m$.Cmd.Do("MAIN");
    //<< DO MAP
    m$.Cmd.Do("MAP");
    //<< WRITE "</MAP>"
    m$.Cmd.Write("</MAP>");
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< QUIT
    return;
  }

  //<< 
  //<< MAP ;SUCHEN MENUEPUNKTE AUS MAP ;seek out of
  public void MAP() {
    //<< SET YAPP=""
    mVar YAPP = m$.var("YAPP");
    YAPP.set("");
    //<< IF YANZ'="" SET YAPP=$PIECE(YANZ,",",1)
    if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
      YAPP.set(m$.Fnc.$piece(m$.var("YANZ").get(),",",1));
    }
    //<< IF YAPP="" FOR  SET YAPP=$ORDER(^WWW004(0,YAPP)) QUIT:YAPP=""  DO MAP1
    if (mOp.Equal(YAPP.get(),"")) {
      for (;true;) {
        YAPP.set(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get())));
        if (mOp.Equal(YAPP.get(),"")) {
          break;
        }
        m$.Cmd.Do("MAP1");
      }
    }
    //<< IF YAPP'="" DO MAP1
    if (mOp.NotEqual(YAPP.get(),"")) {
      m$.Cmd.Do("MAP1");
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< MAP1 ;UNTERPROGRAMME
  public void MAP1() {
    //<< SET YNEUBILD=0  ;ABBRUCH DER ANZEIGE, WENN NEUES BILD GEFUNDEN
    mVar YNEUBILD = m$.var("YNEUBILD");
    YNEUBILD.set(0);
    //<< SET YPROG="" FOR  SET YPROG=$ORDER(^WWW004(0,YAPP,YPROG)) QUIT:YPROG=""  DO  QUIT:YNEUBILD=1
    mVar YPROG = m$.var("YPROG");
    YPROG.set("");
    for (;true;) {
      YPROG.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG.get())));
      if (mOp.Equal(YPROG.get(),"")) {
        break;
      }
      do {
        //<< . IF YANZ'="" QUIT:$PIECE(YANZ,",",2)'=$EXTRACT(YPROG,1,$LENGTH($PIECE(YANZ,",",2)))
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),m$.Fnc.$extract(YPROG.get(),1,m$.Fnc.$length(m$.Fnc.$piece(m$.var("YANZ").get(),",",2))))) {
            break;
          }
        }
        //<< . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG.get(),1)));
        //<< . ;
        //<< . QUIT:$PIECE(YA,Y,16)=""  ;KEINE MAP FÜR BILD ;no to portrait
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),16),"")) {
          break;
        }
        //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" QUIT:$PIECE(YA,Y,8)=""   ;KEIN NEUES BILD FÜR UNTERPUNKT ;no something new portrait to
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),"")) {
              break;
            }
          }
        }
        //<< . IF YANZ="" IF $PIECE(YA,Y,8)'="" SET YNEUBILD=1  ;NEUES BILD DANN KEINE BEARBEITUNG  ;something new portrait no adaptation
        if (mOp.Equal(m$.var("YANZ").get(),"")) {
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),"")) {
            YNEUBILD.set(1);
          }
        }
        //<< . ;BERECHTIGUNG
        //<< . IF $DATA(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,m$.var("YAPP").get(),YPROG.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
          m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
        }
        //<< . SET YAA=$GET(^WWW004(0,YAPP,$PIECE(YPROG,".",1)_".",1))
        mVar YAA = m$.var("YAA");
        YAA.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),mOp.Concat(m$.Fnc.$piece(YPROG.get(),".",1),"."),1)));
        //<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") QUIT:$$^WWWACCESS($PIECE(YA,Y,3),$PIECE(YA,Y,4))'=1  ;KEIN ZUGANG
        if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
          if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4)),1)) {
            break;
          }
        }
        //<< . ;IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YBER'=1 IF YBER'="" IF $PIECE(YA,Y,3)'="" IF $PIECE(YA,Y,3)'=99 IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,3),";",",")_",",","_YBER_",") QUIT
        //<< . ;IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YBER'=1 IF YBER'="" IF $PIECE(YAA,Y,3)'="" IF $PIECE(YAA,Y,3)'=99 IF '$FIND(","_$TRANSLATE($PIECE(YAA,Y,3),";",",")_",",","_YBER_",") QUIT
        //<< . ;IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YMOD'="" IF $PIECE(YA,Y,4)'="" IF '$FIND($PIECE(YA,Y,4),YMOD) QUIT
        //<< . ;IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YMOD'="" IF $PIECE(YAA,Y,4)'="" IF '$FIND($PIECE(YAA,Y,4),YMOD) QUIT
        //<< . SET YNAME=$$^WWWUML($PIECE(YA,Y,1))
        mVar YNAME = m$.var("YNAME");
        YNAME.set(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
        //<< . SET YFORM=$PIECE(YA,Y,2)
        mVar YFORM = m$.var("YFORM");
        YFORM.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2));
        //<< . SET YPARA=$PIECE(YA,Y,7)_Y_$PIECE(YA,Y,5)
        mVar YPARA = m$.var("YPARA");
        YPARA.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),m$.var("Y").get()),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),5)));
        //<< . IF $PIECE(YA,Y,2)'="" DO  QUIT
        if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
          do {
            //<< . . NEW YNAME
            m$.newVarBlock(2,YNAME);
            //<< . . SET YNAME=$PIECE(YA,Y,1)
            YNAME.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1));
            //<< . . SET YSHAPE=0
            mVar YSHAPE = m$.var("YSHAPE");
            YSHAPE.set(0);
            //<< . . IF '$FIND($PIECE(YA,Y,16)," ") SET YSHAPE=$LENGTH($PIECE(YA,Y,16),",")
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),16)," "))) {
              YSHAPE.set(m$.Fnc.$length(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),16),","));
            }
            //<< . . SET YSHAPE1="POLYGON"   ;POLYGONE
            mVar YSHAPE1 = m$.var("YSHAPE1");
            YSHAPE1.set("POLYGON");
            //<< . . IF YSHAPE=3 SET YSHAPE1="CIRCLE"  ;KREISE
            if (mOp.Equal(YSHAPE.get(),3)) {
              YSHAPE1.set("CIRCLE");
            }
            //<< . . IF YSHAPE=4 SET YSHAPE1="RECT"  ;QUADRATE
            if (mOp.Equal(YSHAPE.get(),4)) {
              YSHAPE1.set("RECT");
            }
            //<< . . WRITE "<AREA SHAPE="_YSHAPE1_" COORDS="
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<AREA SHAPE=",YSHAPE1.get())," COORDS="));
            //<< . . WRITE """"_$TRANSLATE($PIECE(YA,Y,16),"|"_$CHAR(10,13))_""""_" TITLE="_""""_YNAME_""""
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("\"",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),16),mOp.Concat("|",m$.Fnc.$char(10,13)))),"\"")," TITLE="),"\""),YNAME.get()),"\""));
            //<< . . SET YAUFRUF="WWWFORM"
            mVar YAUFRUF = m$.var("YAUFRUF");
            YAUFRUF.set("WWWFORM");
            //<< . . IF $PIECE(YA,Y,13)=1 SET YAUFRUF="WWWSEAR"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),1)) {
              YAUFRUF.set("WWWSEAR");
            }
            //<< . . WRITE " HREF="_""""_YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=","\""),m$.var("YAKTION").get()),"EP="),YAUFRUF.get()),"&amp;YFORM="),YFORM.get()));
            //<< . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . IF $PIECE(YA,Y,19)="" IF $PIECE(YVOR,Y,19)'="" WRITE " TARGET="_""""_YTARGET_""""
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),19),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.var("YTARGET").get()),"\""));
              }
            }
            //<< . . IF $PIECE(YA,Y,19)'="" WRITE " TARGET="_""""_$PIECE(YA,Y,19)_""""
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"\""));
            }
            //<< . . WRITE ">"
            m$.Cmd.Write(">");
            //<< . . WRITE YCR
            m$.Cmd.Write(m$.var("YCR").get());
            //<< . . QUIT
            break;
          } while (false);
          break;
        }
        m$.restoreVarBlock(2);
        //<< . IF $PIECE(YA,Y,12)'="" DO  QUIT   ;URL
        if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
          do {
            //<< . . NEW YNAME
            m$.newVarBlock(2,YNAME);
            //<< . . SET YNAME=$PIECE(YA,Y,1)
            YNAME.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1));
            //<< . . SET YSHAPE=0
            mVar YSHAPE = m$.var("YSHAPE");
            YSHAPE.set(0);
            //<< . . IF '$FIND($PIECE(YA,Y,16)," ") SET YSHAPE=$LENGTH($PIECE(YA,Y,16),",")
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),16)," "))) {
              YSHAPE.set(m$.Fnc.$length(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),16),","));
            }
            //<< . . SET YSHAPE1="POLYGON"   ;POLYGONE
            mVar YSHAPE1 = m$.var("YSHAPE1");
            YSHAPE1.set("POLYGON");
            //<< . . IF YSHAPE=3 SET YSHAPE1="CIRCLE"  ;KREISE
            if (mOp.Equal(YSHAPE.get(),3)) {
              YSHAPE1.set("CIRCLE");
            }
            //<< . . IF YSHAPE=4 SET YSHAPE1="RECT"  ;QUADRATE
            if (mOp.Equal(YSHAPE.get(),4)) {
              YSHAPE1.set("RECT");
            }
            //<< . . WRITE "<AREA SHAPE="_YSHAPE1_" COORDS="
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<AREA SHAPE=",YSHAPE1.get())," COORDS="));
            //<< . . WRITE """"_$TRANSLATE($PIECE(YA,Y,16),"|"_$CHAR(10,13))_""""_" TITLE="_""""_YNAME_""""
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("\"",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),16),mOp.Concat("|",m$.Fnc.$char(10,13)))),"\"")," TITLE="),"\""),YNAME.get()),"\""));
            //<< . . WRITE " HREF="_""""
            m$.Cmd.Write(mOp.Concat(" HREF=","\""));
            //<< . . IF '$FIND($PIECE(YA,Y,12),":") WRITE "http://"_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
              m$.Cmd.Write(mOp.Concat("http://",m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/"))));
            }
            //<< . . IF $FIND($PIECE(YA,Y,12),":") WRITE $$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
              m$.Cmd.Write(m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/")));
            }
            //<< . . WRITE """"
            m$.Cmd.Write("\"");
            //<< . . IF $PIECE(YA,Y,19)="" IF $PIECE(YVOR,Y,19)'="" WRITE " TARGET="_""""_YTARGET_""""
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),19),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.var("YTARGET").get()),"\""));
              }
            }
            //<< . . IF $PIECE(YA,Y,19)'="" WRITE " TARGET="_""""_$PIECE(YA,Y,19)_""""
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TARGET=","\""),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"\""));
            }
            //<< . . WRITE ">"
            m$.Cmd.Write(">");
            //<< . . WRITE YCR
            m$.Cmd.Write(m$.var("YCR").get());
            //<< . . QUIT
            break;
          } while (false);
          break;
        }
        m$.restoreVarBlock(2);
        //<< . ;
        //<< . IF $PIECE(YA,Y,8)'="" DO  QUIT  ;URL
        if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),"")) {
          do {
            //<< . . NEW YNAME
            m$.newVarBlock(2,YNAME);
            //<< . . SET YNAME=$PIECE(YA,Y,1)
            YNAME.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1));
            //<< . . SET YSHAPE=0
            mVar YSHAPE = m$.var("YSHAPE");
            YSHAPE.set(0);
            //<< . . IF '$FIND($PIECE(YA,Y,16)," ") SET YSHAPE=$LENGTH($PIECE(YA,Y,16),",")
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),16)," "))) {
              YSHAPE.set(m$.Fnc.$length(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),16),","));
            }
            //<< . . SET YSHAPE1="POLYGON"   ;POLYGONE
            mVar YSHAPE1 = m$.var("YSHAPE1");
            YSHAPE1.set("POLYGON");
            //<< . . IF YSHAPE=3 SET YSHAPE1="CIRCLE"  ;KREISE
            if (mOp.Equal(YSHAPE.get(),3)) {
              YSHAPE1.set("CIRCLE");
            }
            //<< . . IF YSHAPE=4 SET YSHAPE1="RECT"  ;QUADRATE
            if (mOp.Equal(YSHAPE.get(),4)) {
              YSHAPE1.set("RECT");
            }
            //<< . . WRITE "<AREA SHAPE="_YSHAPE1_" COORDS="
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<AREA SHAPE=",YSHAPE1.get())," COORDS="));
            //<< . . WRITE """"_$TRANSLATE($PIECE(YA,Y,16),"|"_$CHAR(10,13))_""""_" TITLE="_""""_YNAME_""""
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("\"",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),16),mOp.Concat("|",m$.Fnc.$char(10,13)))),"\"")," TITLE="),"\""),YNAME.get()),"\""));
            //<< . . WRITE " HREF="_""""
            m$.Cmd.Write(mOp.Concat(" HREF=","\""));
            //<< . . WRITE YAKTION_"EP=WWWMENU"
            m$.Cmd.Write(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWMENU"));
            //<< . . SET YANZ=YAPP_","_YPROG
            mVar YANZ = m$.var("YANZ");
            YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),YPROG.get()));
            //<< . . DO ^WWWCGI
            m$.Cmd.Do("WWWCGI.main");
            //<< . . WRITE """"_">"
            m$.Cmd.Write(mOp.Concat("\"",">"));
            //<< . . QUIT
            break;
          } while (false);
          break;
        }
        m$.restoreVarBlock(2);
        //<< . QUIT
        break;
      } while (false);
      if (mOp.Equal(YNEUBILD.get(),1)) {
        break;
      }
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< MAIN ;ZURÜCK OPTION OBEN LINKS ;back right of first refusal upstairs on the left
  public void MAIN() {
    //<< IF YANZ'="" DO   ;MAP FÜR ZURUECK ;to
    if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
      do {
        //<< . NEW YANZ
        mVar YANZ = m$.var("YANZ");
        m$.newVarBlock(1,YANZ);
        //<< . SET YSHAPE1="POLYGON"   ;POLYGONE
        mVar YSHAPE1 = m$.var("YSHAPE1");
        YSHAPE1.set("POLYGON");
        //<< . WRITE "<AREA SHAPE="_YSHAPE1_" COORDS="
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<AREA SHAPE=",YSHAPE1.get())," COORDS="));
        //<< . WRITE """"_"0,0 20,0 20,20 0,20"_""""_" TITLE="_""""_$$^WWWTEXT(99)_""""
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("\"","0,0 20,0 20,20 0,20"),"\"")," TITLE="),"\""),m$.fnc$("WWWTEXT.main",99)),"\""));
        //<< . SET YAUFRUF="WWWFORM"
        mVar YAUFRUF = m$.var("YAUFRUF");
        YAUFRUF.set("WWWFORM");
        //<< . WRITE " HREF="_""""_YAKTION_"EP=WWWMENU&YANZ="
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU&YANZ="));
        //<< . DO ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< . WRITE """"
        m$.Cmd.Write("\"");
        //<< . WRITE ">"
        m$.Cmd.Write(">");
        //<< . WRITE YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . QUIT
        break;
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< QUIT
    return;
  }

  //<< 
  //<< BILD ;SUCHEN UNTERMAP ;seek
  public void BILD() {
    //<< SET YBILD=""
    mVar YBILD = m$.var("YBILD");
    YBILD.set("");
    //<< SET YAPP=$PIECE(YANZ,",",1)
    mVar YAPP = m$.var("YAPP");
    YAPP.set(m$.Fnc.$piece(m$.var("YANZ").get(),",",1));
    //<< QUIT:YAPP=""
    if (mOp.Equal(YAPP.get(),"")) {
      return;
    }
    //<< SET YPROG="" FOR  SET YPROG=$ORDER(^WWW004(0,YAPP,YPROG)) QUIT:YPROG=""  DO  QUIT:YBILD'=""
    mVar YPROG = m$.var("YPROG");
    YPROG.set("");
    for (;true;) {
      YPROG.set(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get(),YPROG.get())));
      if (mOp.Equal(YPROG.get(),"")) {
        break;
      }
      do {
        //<< . QUIT:$PIECE(YANZ,",",2)'=$EXTRACT(YPROG,1,$LENGTH($PIECE(YANZ,",",2)))
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),m$.Fnc.$extract(YPROG.get(),1,m$.Fnc.$length(m$.Fnc.$piece(m$.var("YANZ").get(),",",2))))) {
          break;
        }
        //<< . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),YPROG.get(),1)));
        //<< . ;
        //<< . QUIT:$PIECE(YA,Y,8)=""   ;KEIN NEUES BILD FÜR UNTERPUNKT ;no something new portrait to
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),"")) {
          break;
        }
        //<< . SET YBILD=$PIECE(YA,Y,8)
        YBILD.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8));
        //<< . QUIT
        break;
      } while (false);
      if (mOp.NotEqual(YBILD.get(),"")) {
        break;
      }
    }
    //<< QUIT
    return;
  }

//<< 
}
