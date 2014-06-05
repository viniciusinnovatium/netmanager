//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMENU8
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:28
//*****************************************************************************

import mLibrary.*;


//<< WWWMENU8
public class WWWMENU8 extends mClass {

  public Object main() {
    _WWWMENU8();
    return null;
  }

  public Object _WWWMENU8() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       POPUP MENUE 2
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
    //<< ; 14-Oct-2005   RPW     SR13680: Make all $translate($piece(YA,Y,12),"/YUCI/","/"_$get(YUCI)_"/"
    //<< ;                       into $$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")
    //<< ; 21.02.2000    DT
    //<< ;-------------------------------------------------------------------------------
    //<< QUIT:$GET(YBED)=""
    if (mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"")) {
      return null;
    }
    //<< QUIT:$GET(YUSER)=""
    if (mOp.Equal(m$.Fnc.$get(m$.var("YUSER")),"")) {
      return null;
    }
    //<< 
    //<< ;WRITE YCR,YCR,"<!-- ************************* ANZEIGN MENUE (WWWMENUE8)************************* -->",YCR,YCR
    //<< 
    //<< NEW YFORM,YAPP,YPROG,YFORM,YKEY,YTARGET,YA,YAA,YI,YKOPF,YVOR,YNAME,YFELD,YLASTP,YAUFRUF,YPARA,YVERKN
    mVar YFORM = m$.var("YFORM");
    mVar YAPP = m$.var("YAPP");
    mVar YPROG = m$.var("YPROG");
    mVar YKEY = m$.var("YKEY");
    mVar YTARGET = m$.var("YTARGET");
    mVar YA = m$.var("YA");
    mVar YAA = m$.var("YAA");
    mVar YI = m$.var("YI");
    mVar YKOPF = m$.var("YKOPF");
    mVar YVOR = m$.var("YVOR");
    mVar YNAME = m$.var("YNAME");
    mVar YFELD = m$.var("YFELD");
    mVar YLASTP = m$.var("YLASTP");
    mVar YAUFRUF = m$.var("YAUFRUF");
    mVar YPARA = m$.var("YPARA");
    mVar YVERKN = m$.var("YVERKN");
    m$.newVar(YFORM,YAPP,YPROG,YFORM,YKEY,YTARGET,YA,YAA,YI,YKOPF,YVOR,YNAME,YFELD,YLASTP,YAUFRUF,YPARA,YVERKN);
    //<< 
    //<< SET YTARGET=""    ;TARGET IST GLEICHES WINDOW ;same
    YTARGET.set("");
    //<< IF $GET(YBER)="" DO
    if (mOp.Equal(m$.Fnc.$get(m$.var("YBER")),"")) {
      //<< . SET YVOR=^WWW013(0,YBED,1)  ;VORGABEN AUS USER ;out of
      YVOR.set(m$.var("^WWW013",0,m$.var("YBED").get(),1).get());
      //<< . ;SET YMENU=$PIECE(YVOR,Y,11)  ;MENUART
      //<< . SET YBER=$PIECE(YVOR,Y,3)  ;BERECHTIGUNG
      mVar YBER = m$.var("YBER");
      YBER.set(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),3));
      //<< . SET YMOD=$PIECE(YVOR,Y,4)  ;MODULBERECHTIGUNG
      mVar YMOD = m$.var("YMOD");
      YMOD.set(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),4));
    }
    //<< 
    //<< ;STARTEN ANZEIGEN DATEN ;launching display
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< SET YVOR=$GET(^WWW012(0,YM,1))
    YVOR.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< SET YKOPF=$PIECE($PIECE(YVOR,Y,11),",",1)
    YKOPF.set(m$.Fnc.$piece(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),11),",",1));
    //<< IF SPRACHE'="DE" IF $PIECE($PIECE(YVOR,Y,11),",",2)'="" SET YKOPF=$PIECE($PIECE(YVOR,Y,11),",",2)
    if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),11),",",2),"")) {
        YKOPF.set(m$.Fnc.$piece(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),11),",",2));
      }
    }
    //<< WRITE "<select name=""site"" size=1 onChange=""javascript:formHandler()"">"
    m$.Cmd.Write("<select name=\"site\" size=1 onChange=\"javascript:formHandler()\">");
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< WRITE "<option value="""" STYLE=""font-weight:bold"" selected=selected>"_YKOPF
    m$.Cmd.Write(mOp.Concat("<option value=\"\" STYLE=\"font-weight:bold\" selected=selected>",YKOPF.get()));
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< DO MENU   ;AUFBAU MENUE STRUKTUR ;texture
    m$.Cmd.Do("MENU");
    //<< WRITE "</select>"
    m$.Cmd.Write("</select>");
    //<< 
    //<< QUIT
    return null;
  }

  //<< 
  //<< MENU ;
  public void MENU() {
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< SET YLASTP=""
    mVar YLASTP = m$.var("YLASTP");
    YLASTP.set("");
    //<< SET YAPP="" FOR  SET YAPP=$ORDER(^WWW004(0,YAPP)) QUIT:YAPP=""  DO
    mVar YAPP = m$.var("YAPP");
    YAPP.set("");
    for (;true;) {
      YAPP.set(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get())));
      if (mOp.Equal(YAPP.get(),"")) {
        break;
      }
      do {
        //<< . WRITE "<option value="""""
        m$.Cmd.Write("<option value=\"\"");
        //<< . WRITE " STYLE=""background:"_YDARKGRAY_""""  ;   "_$P($G(^WWW100(0,"FARBMARKIERUNG",SPRACHE,1,1)),Y,1)_""""
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" STYLE=\"background:",m$.var("YDARKGRAY").get()),"\""));
        //<< . SET YAPPP=YAPP
        mVar YAPPP = m$.var("YAPPP");
        YAPPP.set(YAPP.get());
        //<< . IF $PIECE($GET(^WWW00411(0,YAPP,SPRACHE,1)),Y,1)'="" SET YAPPP=$PIECE(^(1),Y,1)  ;LANGUAGETEXT OF APPLICATION;TYBD;30.8.2004
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW00411",0,YAPP.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
          YAPPP.set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
        }
        //<< . WRITE ">------------------------------"_$TRANSLATE(YAPPP,"_"," ")_"----------------------------------"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(">------------------------------",m$.Fnc.$translate(YAPPP.get(),"_"," ")),"----------------------------------"));
        //<< . WRITE YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< . ;
        //<< . SET YPROG="" FOR  SET YPROG=$ORDER(^WWW004(0,YAPP,YPROG)) QUIT:YPROG=""  DO
        mVar YPROG = m$.var("YPROG");
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
            //<< . . IF $DATA(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,YAPP.get(),YPROG.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
              m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
            }
            //<< . . SET YAA=$GET(^WWW004(0,YAPP,$PIECE(YPROG,".",1)_".",1))
            mVar YAA = m$.var("YAA");
            YAA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),mOp.Concat(m$.Fnc.$piece(YPROG.get(),".",1),"."),1)));
            //<< . . SET YQ=1
            mVar YQ = m$.var("YQ");
            YQ.set(1);
            //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROG_";") SET YQ=0  ;BERECHTIGT
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),YAPP.get())))) {
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),YAPP.get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROG.get()),";")))) {
                YQ.set(0);
              }
            }
            //<< . . IF $FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") SET YQ=0
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
              YQ.set(0);
            }
            //<< . . IF $$^WWWACCESS($PIECE(YA,Y,3),$PIECE(YA,Y,4))=1 SET YQ=0 ;KEIN ZUGANG ;no
            if (mOp.Equal(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4)),1)) {
              YQ.set(0);
            }
            //<< . . SET YNAME=$$^WWWUML($PIECE(YA,Y,1))
            mVar YNAME = m$.var("YNAME");
            YNAME.set(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
            //<< . . SET YFORM=$PIECE(YA,Y,2)
            mVar YFORM = m$.var("YFORM");
            YFORM.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2));
            //<< . . SET YVERKN=$PIECE(YA,Y,12)
            mVar YVERKN = m$.var("YVERKN");
            YVERKN.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12));
            //<< . . IF YFORM="" IF YVERKN="" DO  QUIT   ;UNTERUNTERMENUE
            if (mOp.Equal(YFORM.get(),"")) {
              if (mOp.Equal(YVERKN.get(),"")) {
                do {
                  //<< . . . WRITE "<option value="""""
                  m$.Cmd.Write("<option value=\"\"");
                  //<< . . . WRITE ">"
                  m$.Cmd.Write(">");
                  //<< . . . WRITE "<option value="""""
                  m$.Cmd.Write("<option value=\"\"");
                  //<< . . . WRITE " STYLE=""text-decoration:underline; background:"_YDARKGRAY_""""
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(" STYLE=\"text-decoration:underline; background:",m$.var("YDARKGRAY").get()),"\""));
                  //<< . . . WRITE ">"_YNAME_""
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(">",YNAME.get()),""));
                  //<< . . . WRITE YCR
                  m$.Cmd.Write(m$.var("YCR").get());
                  //<< . . . QUIT
                  break;
                } while (false);
                break;
              }
            }
            //<< . . ;
            //<< . . ;ZUSAMMENSTELLEN AUFRUF
            //<< . . SET YI=""
            mVar YI = m$.var("YI");
            YI.set("");
            //<< . . SET YPARA=$PIECE(YA,Y,7)_Y_$PIECE(YA,Y,5)
            mVar YPARA = m$.var("YPARA");
            YPARA.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),m$.var("Y").get()),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),5)));
            //<< . . IF YFORM'="" DO
            if (mOp.NotEqual(YFORM.get(),"")) {
              do {
                //<< . . . ;
                //<< . . . SET YAUFRUF="WWWFORM"
                mVar YAUFRUF = m$.var("YAUFRUF");
                YAUFRUF.set("WWWFORM");
                //<< . . . IF $PIECE(YA,Y,13)=1 SET YAUFRUF="WWWSEAR"
                if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),1)) {
                  YAUFRUF.set("WWWSEAR");
                }
                //<< . . . SET YI=YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM
                YI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP="),YAUFRUF.get()),"&amp;YFORM="),YFORM.get()));
                //<< . . . ;
                //<< . . . DO VAR^WWWCGI
                m$.Cmd.Do("WWWCGI.VAR");
                //<< . . . ;
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . IF YVERKN'="" DO  ;URL
            if (mOp.NotEqual(YVERKN.get(),"")) {
              do {
                //<< . . . SET YI=""
                YI.set("");
                //<< . . . IF '$FIND($PIECE(YA,Y,12),":") SET YI=YI_"http://"_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
                if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
                  YI.set(mOp.Concat(mOp.Concat(YI.get(),"http://"),m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/"))));
                }
                //<< . . . IF $FIND($PIECE(YA,Y,12),":") SET YI=YI_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
                if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
                  YI.set(mOp.Concat(YI.get(),m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/"))));
                }
                //<< . . . ;
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . ;
            //<< . . WRITE "<option value="""_YI_""">"_YNAME
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<option value=\"",YI.get()),"\">"),YNAME.get()));
            //<< . . WRITE YCR
            m$.Cmd.Write(m$.var("YCR").get());
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . ;
        //<< . QUIT
        break;
      } while (false);
    }
    //<< QUIT
    return;
  }

//<< 
}
