//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMENU7
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:51
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

//<< WWWMENU7
public class WWWMENU7 extends mClass {

  public void main() {
    _WWWMENU7();
  }

  public void _WWWMENU7() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       POPUP MENUE
    //<< ;
    //<< ;   NO LONGER IN USE - menu option 6
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
    //<< ; 10-Jul-2007   GRF     Doco; quits; disabled block; Naked References
    //<< ; 14-Oct-2005   RPW     SR13680: Make all $translate($piece(YA,Y,12),"/YUCI/","/"_$get(YUCI)_"/"
    //<< ;                       into $$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")
    //<< ; 21.02.2000    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YFORM,YAPP,YMENUM,YTARGET,YA,YI,YU1NUM,YU2NUM
    mVar YFORM = m$.var("YFORM");
    mVar YAPP = m$.var("YAPP");
    mVar YMENUM = m$.var("YMENUM");
    mVar YTARGET = m$.var("YTARGET");
    mVar YA = m$.var("YA");
    mVar YI = m$.var("YI");
    mVar YU1NUM = m$.var("YU1NUM");
    mVar YU2NUM = m$.var("YU2NUM");
    m$.newVar(YFORM,YAPP,YMENUM,YTARGET,YA,YI,YU1NUM,YU2NUM);
    //<< 
    //<< WRITE "</TABLE>",YCR
    m$.Cmd.Write("</TABLE>",m$.var("YCR").get());
    //<< SET YTARGET=""    ;TARGET IST GLEICHES WINDOW ;same
    YTARGET.set("");
    //<< 
    //<< ;STARTEN ANZEIGEN DATEN ;launching display
    //<< WRITE "<span id="_""""_"MenuePosition"_""""_" style="_""""_"position: relative; width: 1"_""""_">&nbsp;</span>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<span id=","\""),"MenuePosition"),"\"")," style="),"\""),"position: relative; width: 1"),"\""),">&nbsp;</span>"));
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< ;WRITE "<script language="_""""_"JavaScript1.2"_""""_" type="_""""_"text/javascript"_""""_">"
    //<< ;WRITE YCR
    //<< ;WRITE "<!--"
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< WRITE "if (ie || ns) {",YCR
    m$.Cmd.Write("if (ie || ns) {",m$.var("YCR").get());
    //<< WRITE "  lMenu = new Menu(0, 0);",YCR
    m$.Cmd.Write("  lMenu = new Menu(0, 0);",m$.var("YCR").get());
    //<< DO MENU   ;AUFBAU MENUE STRUKTUR ;texture
    m$.Cmd.Do("MENU");
    //<< WRITE "  lMenu.build();",YCR
    m$.Cmd.Write("  lMenu.build();",m$.var("YCR").get());
    //<< WRITE "}",YCR
    m$.Cmd.Write("}",m$.var("YCR").get());
    //<< ;WRITE "//-->",YCR
    //<< ;WRITE "</script>"
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< WRITE YCR,"<BR><BR>"
    m$.Cmd.Write(m$.var("YCR").get(),"<BR><BR>");
    //<< QUIT
    return;
  }

  //<< 
  //<< MENU ;
  public void MENU() {
    //<< ;HAUPTMENU
    //<< SET YAPP=""
    mVar YAPP = m$.var("YAPP");
    YAPP.set("");
    //<< FOR YU1NUM=1:1 SET YAPP=$ORDER(^WWW004(0,YAPP)) QUIT:YAPP=""  DO
    mVar YU1NUM = m$.var("YU1NUM");
    for (YU1NUM.set(1);(true);YU1NUM.set(mOp.Add(YU1NUM.get(),1))) {
      YAPP.set(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get())));
      if (mOp.Equal(YAPP.get(),"")) {
        break;
      }
      do {
        //<< . SET YQ=0
        mVar YQ = m$.var("YQ");
        YQ.set(0);
        //<< . SET YPROG="" SET YPROG=$ORDER(^WWW004(0,YAPP,YPROG)) IF YPROG'=""  DO
        mVar YPROG = m$.var("YPROG");
        YPROG.set("");
        YPROG.set(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get(),YPROG.get())));
        if (mOp.NotEqual(YPROG.get(),"")) {
          do {
            //<< . . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
            mVar YA = m$.var("YA");
            YA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),YPROG.get(),1)));
            //<< . . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF $$^WWWACCESS($PIECE(YA,Y,3),$PIECE(YA,Y,4))'=1 SET YQ=1 QUIT  ;KEIN ZUGANG
            if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
              if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4)),1)) {
                YQ.set(1);
                break;
              }
            }
          } while (false);
        }
        //<< . . ;IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YBER'=1 IF YBER'="" IF $PIECE(YA,Y,3)'="" IF $PIECE(YA,Y,3)'=99 IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,3),";",",")_",",","_YBER_",") SET YQ=1
        //<< . . ;IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YMOD'="" IF $PIECE(YA,Y,4)'="" IF '$FIND($PIECE(YA,Y,4),YMOD) SET YQ=1
        //<< . ;
        //<< . QUIT:YQ=1
        if (mOp.Equal(YQ.get(),1)) {
          break;
        }
        //<< . SET YU1NUM(YAPP)=YU1NUM
        YU1NUM.var(YAPP.get()).set(YU1NUM.get());
        //<< . SET YAPPP=YAPP
        mVar YAPPP = m$.var("YAPPP");
        YAPPP.set(YAPP.get());
        //<< . IF $PIECE($GET(^WWW00411(0,YAPP,SPRACHE,1)),Y,1)'="" SET YAPPP=$PIECE(^WWW00411(0,YAPP,SPRACHE,1),Y,1)  ;LANGUAGETEXT OF APPLICATION;TYBD;30.8.2004   ; Naked Ref
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW00411",0,YAPP.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
          YAPPP.set(m$.Fnc.$piece(m$.var("^WWW00411",0,YAPP.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . WRITE "  lMenu.addMenu('lMenu"_YU1NUM_"', 'javascript:void(0)', '_top', '"_$$^WWWUMLAU(YAPPP)_"');"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  lMenu.addMenu('lMenu",YU1NUM.get()),"', 'javascript:void(0)', '_top', '"),m$.fnc$("WWWUMLAU.main",YAPPP.get())),"');"));
        //<< . WRITE YCR
        m$.Cmd.Write(m$.var("YCR").get());
      } while (false);
    }
    //<< 
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< SET YLASTP=""
    mVar YLASTP = m$.var("YLASTP");
    YLASTP.set("");
    //<< SET YAPP=""
    YAPP.set("");
    //<< FOR  SET YAPP=$ORDER(YU1NUM(YAPP)) QUIT:YAPP=""  SET YPROG="" FOR YU1NUM=1:1 SET YPROG=$ORDER(^WWW004(0,YAPP,YPROG)) QUIT:YPROG=""  DO
    for (;true;) {
      YAPP.set(m$.Fnc.$order(YU1NUM.var(YAPP.get())));
      if (mOp.Equal(YAPP.get(),"")) {
        break;
      }
      mVar YPROG = m$.var("YPROG");
      YPROG.set("");
      for (YU1NUM.set(1);(true);YU1NUM.set(mOp.Add(YU1NUM.get(),1))) {
        YPROG.set(m$.Fnc.$order(m$.var("^WWW004",0,YAPP.get(),YPROG.get())));
        if (mOp.Equal(YPROG.get(),"")) {
          break;
        }
        do {
          //<< . IF $PIECE(YPROG,".",2)'="" DO  QUIT  ;2.EBENE
          if (mOp.NotEqual(m$.Fnc.$piece(YPROG.get(),".",2),"")) {
            //<< . . IF YLASTP'="" SET YU2NUM(YAPP,YPROG)=YLASTP
            if (mOp.NotEqual(YLASTP.get(),"")) {
              mVar YU2NUM = m$.var("YU2NUM");
              YU2NUM.var(YAPP.get(),YPROG.get()).set(YLASTP.get());
            }
            break;
          }
          //<< . ;
          //<< . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
          mVar YA = m$.var("YA");
          YA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),YPROG.get(),1)));
          //<< . SET YLASTP=YU1NUM(YAPP)_"X"_YU1NUM
          YLASTP.set(mOp.Concat(mOp.Concat(YU1NUM.var(YAPP.get()).get(),"X"),YU1NUM.get()));
          //<< . IF $DATA(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,YAPP.get(),YPROG.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
            m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
          }
          //<< . SET YAA=$GET(^WWW004(0,YAPP,$PIECE(YPROG,".",1)_".",1))
          mVar YAA = m$.var("YAA");
          YAA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),mOp.Concat(m$.Fnc.$piece(YPROG.get(),".",1),"."),1)));
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
          //<< . SET YNAME=$$^WWWUMLAU($PIECE(YA,Y,1))
          mVar YNAME = m$.var("YNAME");
          YNAME.set(m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
          //<< . SET YFORM=$PIECE(YA,Y,2)
          mVar YFORM = m$.var("YFORM");
          YFORM.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2));
          //<< . SET YVERKN=$PIECE(YA,Y,12)
          mVar YVERKN = m$.var("YVERKN");
          YVERKN.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12));
          //<< . IF YFORM="" IF YVERKN="" DO  QUIT   ;UNTERUNTERMENUE
          if (mOp.Equal(YFORM.get(),"")) {
            if (mOp.Equal(YVERKN.get(),"")) {
              //<< . . WRITE "  lMenu"_YU1NUM(YAPP)_".addMenu('lMenu"_YU1NUM(YAPP)_"X"_YU1NUM_"', 'javascript:void(0)', '_top', '"_YNAME_"');"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  lMenu",YU1NUM.var(YAPP.get()).get()),".addMenu('lMenu"),YU1NUM.var(YAPP.get()).get()),"X"),YU1NUM.get()),"', 'javascript:void(0)', '_top', '"),YNAME.get()),"');"));
              //<< . . WRITE YCR
              m$.Cmd.Write(m$.var("YCR").get());
              break;
            }
          }
          //<< . ;
          //<< . ;ZUSAMMENSTELLEN AUFRUF
          //<< . SET YI=""
          mVar YI = m$.var("YI");
          YI.set("");
          //<< . SET YPARA=$PIECE(YA,Y,7)_Y_$PIECE(YA,Y,5)
          mVar YPARA = m$.var("YPARA");
          YPARA.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),m$.var("Y").get()),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),5)));
          //<< . IF YFORM'="" DO
          if (mOp.NotEqual(YFORM.get(),"")) {
            //<< . . SET YAUFRUF="WWWFORM"
            mVar YAUFRUF = m$.var("YAUFRUF");
            YAUFRUF.set("WWWFORM");
            //<< . . IF $PIECE(YA,Y,13)=1 SET YAUFRUF="WWWSEAR"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),1)) {
              YAUFRUF.set("WWWSEAR");
            }
            //<< . . SET YI=YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM
            YI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP="),YAUFRUF.get()),"&amp;YFORM="),YFORM.get()));
            //<< . . DO VAR^WWWCGI
            m$.Cmd.Do("WWWCGI.VAR");
          }
          //<< . ;
          //<< . IF YVERKN'="" DO  ;URL
          if (mOp.NotEqual(YVERKN.get(),"")) {
            //<< . . SET YI=""
            YI.set("");
            //<< . . IF '$FIND($PIECE(YA,Y,12),":") SET YI=YI_"http://"_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
              YI.set(mOp.Concat(mOp.Concat(YI.get(),"http://"),m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/"))));
            }
            //<< . . IF $FIND($PIECE(YA,Y,12),":") SET YI=YI_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
              YI.set(mOp.Concat(YI.get(),m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/"))));
            }
          }
          //<< . ;
          //<< . WRITE "  lMenu"_YU1NUM(YAPP)_".addMenuItem('"_YI_"', '_top', '"_YNAME_"');"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  lMenu",YU1NUM.var(YAPP.get()).get()),".addMenuItem('"),YI.get()),"', '_top', '"),YNAME.get()),"');"));
          //<< . WRITE YCR
          m$.Cmd.Write(m$.var("YCR").get());
        } while (false);
      }
    }
    //<< 
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< SET YLASTP=""
    YLASTP.set("");
    //<< SET YAPP=""
    YAPP.set("");
    //<< FOR  SET YAPP=$ORDER(YU2NUM(YAPP)) QUIT:YAPP=""  SET YPROG="" FOR YU2NUM=1:1 SET YPROG=$ORDER(YU2NUM(YAPP,YPROG)) QUIT:YPROG=""  DO
    for (;true;) {
      YAPP.set(m$.Fnc.$order(m$.var("YU2NUM").var(YAPP.get())));
      if (mOp.Equal(YAPP.get(),"")) {
        break;
      }
      mVar YPROG = m$.var("YPROG");
      YPROG.set("");
      mVar YU2NUM = m$.var("YU2NUM");
      for (YU2NUM.set(1);(true);YU2NUM.set(mOp.Add(YU2NUM.get(),1))) {
        YPROG.set(m$.Fnc.$order(YU2NUM.var(YAPP.get(),YPROG.get())));
        if (mOp.Equal(YPROG.get(),"")) {
          break;
        }
        do {
          //<< . IF $PIECE(YPROG,".",3)'="" DO  QUIT  ;3.EBENE
          if (mOp.NotEqual(m$.Fnc.$piece(YPROG.get(),".",3),"")) {
            //<< . . IF YLASTP'="" SET YU3NUM(YAPP,YPROG)=YLASTP
            if (mOp.NotEqual(YLASTP.get(),"")) {
              mVar YU3NUM = m$.var("YU3NUM");
              YU3NUM.var(YAPP.get(),YPROG.get()).set(YLASTP.get());
            }
            break;
          }
          //<< . ;
          //<< . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
          mVar YA = m$.var("YA");
          YA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),YPROG.get(),1)));
          //<< . SET YLASTP=YU1NUM(YAPP)_"Y"_YU2NUM
          YLASTP.set(mOp.Concat(mOp.Concat(YU1NUM.var(YAPP.get()).get(),"Y"),YU2NUM.get()));
          //<< . IF $DATA(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1),Y,1)   ; Naked Ref
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,YAPP.get(),YPROG.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
            m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.var("^WWW0041",0,YAPP.get(),YPROG.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1).get(),m$.var("Y").get(),1));
          }
          //<< . SET YAA=$GET(^WWW004(0,YAPP,$PIECE(YPROG,".",1)_".",1))
          mVar YAA = m$.var("YAA");
          YAA.set(m$.Fnc.$get(m$.var("^WWW004",0,YAPP.get(),mOp.Concat(m$.Fnc.$piece(YPROG.get(),".",1),"."),1)));
          //<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YBER'=1 IF YBER'="" IF $PIECE(YA,Y,3)'=""  IF $PIECE(YA,Y,3)'=99  IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,3),";",",")_",",","_YBER_",")  QUIT
          if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
            if (mOp.NotEqual(m$.var("YBER").get(),1)) {
              if (mOp.NotEqual(m$.var("YBER").get(),"")) {
                if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),"")) {
                  if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),99)) {
                    if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),3),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBER").get()),",")))) {
                      break;
                    }
                  }
                }
              }
            }
          }
          //<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YBER'=1 IF YBER'="" IF $PIECE(YAA,Y,3)'="" IF $PIECE(YAA,Y,3)'=99 IF '$FIND(","_$TRANSLATE($PIECE(YAA,Y,3),";",",")_",",","_YBER_",") QUIT
          if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
            if (mOp.NotEqual(m$.var("YBER").get(),1)) {
              if (mOp.NotEqual(m$.var("YBER").get(),"")) {
                if (mOp.NotEqual(m$.Fnc.$piece(YAA.get(),m$.var("Y").get(),3),"")) {
                  if (mOp.NotEqual(m$.Fnc.$piece(YAA.get(),m$.var("Y").get(),3),99)) {
                    if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YAA.get(),m$.var("Y").get(),3),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBER").get()),",")))) {
                      break;
                    }
                  }
                }
              }
            }
          }
          //<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YMOD'="" IF $PIECE(YA,Y,4)'=""  IF '$FIND($PIECE(YA,Y,4),YMOD)  QUIT
          if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
            if (mOp.NotEqual(m$.var("YMOD").get(),"")) {
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4),"")) {
                if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),4),m$.var("YMOD").get()))) {
                  break;
                }
              }
            }
          }
          //<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YMOD'="" IF $PIECE(YAA,Y,4)'="" IF '$FIND($PIECE(YAA,Y,4),YMOD) QUIT
          if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),";",",")),","),mOp.Concat(mOp.Concat(",",m$.var("YBED").get()),",")))) {
            if (mOp.NotEqual(m$.var("YMOD").get(),"")) {
              if (mOp.NotEqual(m$.Fnc.$piece(YAA.get(),m$.var("Y").get(),4),"")) {
                if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YAA.get(),m$.var("Y").get(),4),m$.var("YMOD").get()))) {
                  break;
                }
              }
            }
          }
          //<< . SET YNAME=$$^WWWUMLAU($PIECE(YA,Y,1))
          mVar YNAME = m$.var("YNAME");
          YNAME.set(m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
          //<< . SET YFORM=$PIECE(YA,Y,2)
          mVar YFORM = m$.var("YFORM");
          YFORM.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2));
          //<< . SET YVERKN=$PIECE(YA,Y,12)
          mVar YVERKN = m$.var("YVERKN");
          YVERKN.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12));
          //<< . IF YFORM="" IF YVERKN="" QUIT  //DO  QUIT   ;UNTERUNTERMENUE
          if (mOp.Equal(YFORM.get(),"")) {
            if (mOp.Equal(YVERKN.get(),"")) {
              break;
            }
          }
          //<< . ;. WRITE "  lMenu"_YU2NUM(YAPP,YPROG)_".addMenu('lMenu"_YU1NUM(YAPP)_"Y"_YU2NUM_"', 'javascript:void(0)', '_top', '"_YNAME_"');"
          //<< . ;. WRITE YCR
          //<< . ;
          //<< . ;ZUSAMMENSTELLEN AUFRUF
          //<< . SET YI=""
          mVar YI = m$.var("YI");
          YI.set("");
          //<< . SET YPARA=$PIECE(YA,Y,7)_Y_$PIECE(YA,Y,5)
          mVar YPARA = m$.var("YPARA");
          YPARA.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),m$.var("Y").get()),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),5)));
          //<< . IF YFORM'="" DO
          if (mOp.NotEqual(YFORM.get(),"")) {
            //<< . . SET YAUFRUF="WWWFORM"
            mVar YAUFRUF = m$.var("YAUFRUF");
            YAUFRUF.set("WWWFORM");
            //<< . . IF $PIECE(YA,Y,13)=1 SET YAUFRUF="WWWSEAR"
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),1)) {
              YAUFRUF.set("WWWSEAR");
            }
            //<< . . SET YI=YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM
            YI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP="),YAUFRUF.get()),"&amp;YFORM="),YFORM.get()));
            //<< . . DO VAR^WWWCGI
            m$.Cmd.Do("WWWCGI.VAR");
          }
          //<< . ;
          //<< . IF YVERKN'="" DO  ;URL
          if (mOp.NotEqual(YVERKN.get(),"")) {
            //<< . . SET YI=""
            YI.set("");
            //<< . . IF '$FIND($PIECE(YA,Y,12),":") SET YI=YI_"http://"_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
              YI.set(mOp.Concat(mOp.Concat(YI.get(),"http://"),m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/"))));
            }
            //<< . . IF $FIND($PIECE(YA,Y,12),":")  SET YI=YI_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")            ;YUCI;TYBD;16.01.2005 ; SR13680
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),":"))) {
              YI.set(mOp.Concat(YI.get(),m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/"))));
            }
          }
          //<< . ;
          //<< . WRITE "  lMenu"_YU2NUM(YAPP,YPROG)_".addMenuItem('"_YI_"', '_top', '"_YNAME_"');"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  lMenu",YU2NUM.var(YAPP.get(),YPROG.get()).get()),".addMenuItem('"),YI.get()),"', '_top', '"),YNAME.get()),"');"));
          //<< . WRITE YCR
          m$.Cmd.Write(m$.var("YCR").get());
        } while (false);
      }
    }
    //<< 
    //<< KILL YU2NUM
    m$.var("YU2NUM").kill();
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< QUIT
    return;
  }

//<< 
//<< /*
//<< ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK STARTS
//<< SET YLASTP=""
//<< SET YAPP=""
//<< FOR  SET YAPP=$ORDER(YU3NUM(YAPP)) QUIT:YAPP=""  SET YPROG="" FOR YU3NUM=1:1 SET YPROG=$ORDER(YU3NUM(YAPP,YPROG)) QUIT:YPROG=""  DO
//<< . IF $PIECE(YPROG,".",4)'="" DO  QUIT  ;4.EBENE
//<< . . IF YLASTP'="" SET YU4NUM(YAPP,YPROG)=YLASTP
//<< . ;
//<< . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
//<< . SET YLASTP=YU1NUM(YAPP)_"Z"_YU3NUM
//<< . IF $DATA(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
//<< . SET YAA=$GET(^WWW004(0,YAPP,$PIECE(YPROG,".",1)_".",1))
//<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YBER'=1 IF YBER'="" IF $PIECE(YA,Y,3)'="" IF $PIECE(YA,Y,3)'=99 IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,3),";",",")_",",","_YBER_",") QUIT
//<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YBER'=1 IF YBER'="" IF $PIECE(YAA,Y,3)'="" IF $PIECE(YAA,Y,3)'=99 IF '$FIND(","_$TRANSLATE($PIECE(YAA,Y,3),";",",")_",",","_YBER_",") QUIT
//<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YMOD'="" IF $PIECE(YA,Y,4)'="" IF '$FIND($PIECE(YA,Y,4),YMOD) QUIT
//<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YMOD'="" IF $PIECE(YAA,Y,4)'="" IF '$FIND($PIECE(YAA,Y,4),YMOD) QUIT
//<< . SET YNAME=$$^WWWUMLAU($PIECE(YA,Y,1))
//<< . SET YFORM=$PIECE(YA,Y,2)
//<< . SET YVERKN=$PIECE(YA,Y,12)
//<< . IF YFORM="" IF YVERKN=""  DO  QUIT   ;UNTERUNTERMENUE
//<< . . WRITE "  lMenu"_YU3NUM(YAPP,YPROG)_".addMenu('lMenu"_YU1NUM(YAPP)_"Y"_YU3NUM_"', 'javascript:void(0)', '_top', '"_YNAME_"');"
//<< . . WRITE YCR
//<< . ;
//<< . ;ZUSAMMENSTELLEN AUFRUF
//<< . SET YI=""
//<< . SET YPARA=$PIECE(YA,Y,7)_Y_$PIECE(YA,Y,5)
//<< . IF YFORM'="" DO
//<< . . SET YAUFRUF="WWWFORM"
//<< . . IF $PIECE(YA,Y,13)=1 SET YAUFRUF="WWWSEAR"
//<< . . SET YI=YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM
//<< . . DO VAR^WWWCGI
//<< . ;
//<< . IF YVERKN'="" DO  ;URL
//<< . . SET YI=""
//<< . . IF '$FIND($PIECE(YA,Y,12),":") SET YI=YI_"http://"_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
//<< . . IF $FIND($PIECE(YA,Y,12),":") SET YI=YI_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
//<< . ;
//<< . WRITE "  lMenu"_YU3NUM(YAPP,YPROG)_".addMenuItem('"_YI_"', '_top', '"_YNAME_"');"
//<< . WRITE YCR
//<< 
//<< WRITE YCR
//<< KILL YU3NUM
//<< SET YLASTP=""
//<< SET YAPP=""
//<< FOR  SET YAPP=$ORDER(YU4NUM(YAPP)) QUIT:YAPP=""  SET YPROG="" FOR YU4NUM=1:1 SET YPROG=$ORDER(YU4NUM(YAPP,YPROG)) QUIT:YPROG=""  DO
//<< . IF $PIECE(YPROG,".",5)'="" QUIT  ;5.EBENE
//<< . SET YA=$GET(^WWW004(0,YAPP,YPROG,1))
//<< . IF $DATA(^WWW0041(0,YAPP,YPROG,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
//<< . SET YAA=$GET(^WWW004(0,YAPP,$PIECE(YPROG,".",1)_".",1))
//<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YBER'=1 IF YBER'="" IF $PIECE(YA,Y,3)'="" IF $PIECE(YA,Y,3)'=99 IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,3),";",",")_",",","_YBER_",") QUIT
//<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YBER'=1 IF YBER'="" IF $PIECE(YAA,Y,3)'="" IF $PIECE(YAA,Y,3)'=99 IF '$FIND(","_$TRANSLATE($PIECE(YAA,Y,3),";",",")_",",","_YBER_",") QUIT
//<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YMOD'="" IF $PIECE(YA,Y,4)'="" IF '$FIND($PIECE(YA,Y,4),YMOD) QUIT
//<< . IF '$FIND(","_$TRANSLATE($PIECE(YA,Y,6),";",",")_",",","_YBED_",") IF YMOD'="" IF $PIECE(YAA,Y,4)'="" IF '$FIND($PIECE(YAA,Y,4),YMOD) QUIT
//<< . SET YNAME=$$^WWWUMLAU($PIECE(YA,Y,1))
//<< . SET YFORM=$PIECE(YA,Y,2)
//<< . SET YVERKN=$PIECE(YA,Y,12)
//<< . IF YFORM="" IF YVERKN="" QUIT   ;UNTERUNTERMENUE
//<< . ;
//<< . ;ZUSAMMENSTELLEN AUFRUF
//<< . SET YI=""
//<< . SET YPARA=$PIECE(YA,Y,7)_Y_$PIECE(YA,Y,5)
//<< . IF YFORM'="" DO
//<< . . SET YAUFRUF="WWWFORM"
//<< . . IF $PIECE(YA,Y,13)=1 SET YAUFRUF="WWWSEAR"
//<< . . SET YI=YAKTION_"EP="_YAUFRUF_"&amp;YFORM="_YFORM
//<< . . DO VAR^WWWCGI
//<< . ;
//<< . IF YVERKN'="" DO  ;URL
//<< . . SET YI=""
//<< . . IF '$FIND($PIECE(YA,Y,12),":") SET YI=YI_"http://"_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
//<< . . IF $FIND($PIECE(YA,Y,12),":") SET YI=YI_$$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI;TYBD;16.01.2005 ; SR13680
//<< . ;
//<< . WRITE "  lMenu"_YU4NUM(YAPP,YPROG)_".addMenuItem('"_YI_"', '_top', '"_YNAME_"');"
//<< . WRITE YCR
//<< 
//<< KILL YU4NUM
//<< QUIT
//<< ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
//<< */
//<< 
}
