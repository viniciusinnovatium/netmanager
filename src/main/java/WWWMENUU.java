//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWMENUU
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:43
//*****************************************************************************

import mLibrary.*;


//<< WWWMENUU ;WWWMENUU;DT;UNTERPROGRAMM MENU;12.11.1998
public class WWWMENUU extends mClass {

  public void main() {
    _WWWMENUU();
  }

  public void _WWWMENUU() {
    PRO1();
  }

  //<< ;
  //<< ;/------------------------------------------------------------------\
  //<< ;| Description of Function :
  //<< ;|      UNTERPROGRAMM MENU
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
  //<< ;| DT   12.11.1998
  //<< ;|
  //<< ;\------------------------------------------------------------------/
  //<< ;
  //<< 
  //<< PRO1 ;
  public void PRO1() {
    //<< SET YPROG2=YPROG1 FOR  SET YPROG2=$ORDER(^WWW004(0,YAPP,YPROG2)) QUIT:YPROG2=""  QUIT:$EXTRACT(YPROG2,1,$LENGTH(YPROG1))'=YPROG1  DO
    mVar YPROG2 = m$.var("YPROG2");
    YPROG2.set(m$.var("YPROG1").get());
    for (;true;) {
      YPROG2.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG2.get())));
      if (mOp.Equal(YPROG2.get(),"")) {
        break;
      }
      if (mOp.NotEqual(m$.Fnc.$extract(YPROG2.get(),1,m$.Fnc.$length(m$.var("YPROG1").get())),m$.var("YPROG1").get())) {
        break;
      }
      do {
        //<< . QUIT:$PIECE(YPROG2,".",4,9)'=""
        if (mOp.NotEqual(m$.Fnc.$piece(YPROG2.get(),".",4,9),"")) {
          break;
        }
        //<< . IF (YAPP_","_YPROG2)=YANZ WRITE "<A NAME='TARGET'></A>"
        if (mOp.Equal((mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),YPROG2.get())),m$.var("YANZ").get())) {
          m$.Cmd.Write("<A NAME='TARGET'></A>");
        }
        //<< . SET YB2END=0 IF $PIECE($ORDER(^WWW004(0,YAPP,YPROG2_$CHAR(255))),".",1,2)'=$PIECE(YPROG2,".",1,2) SET YB2END=1
        mVar YB2END = m$.var("YB2END");
        YB2END.set(0);
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),mOp.Concat(YPROG2.get(),m$.Fnc.$char(255)))),".",1,2),m$.Fnc.$piece(YPROG2.get(),".",1,2))) {
          YB2END.set(1);
        }
        //<< . SET YP2END=0 IF $PIECE($ORDER(^WWW004(0,YAPP,YPROG2_$CHAR(255))),".",1,3)'=$PIECE(YPROG2,".",1,3) SET YP2END=1
        mVar YP2END = m$.var("YP2END");
        YP2END.set(0);
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),mOp.Concat(YPROG2.get(),m$.Fnc.$char(255)))),".",1,3),m$.Fnc.$piece(YPROG2.get(),".",1,3))) {
          YP2END.set(1);
        }
        //<< . SET YA=$GET(^WWW004(0,YAPP,YPROG2,1))
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG2.get(),1)));
        //<< . Q:$PIECE(YA,Y,7)="noshow"  ;keine anzeige ;None
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"noshow")) {
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
        //<< . SET YQ=0
        mVar YQ = m$.var("YQ");
        YQ.set(0);
        //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" SET YQ=1 SET YPROGP=YPROG2 FOR  SET YPROGP=$ORDER(^WWW004(0,YAPP,YPROGP)) QUIT:$EXTRACT(YPROGP,1,$LENGTH(YPROG2))'=YPROG2  QUIT:YPROGP=""  DO  QUIT:YQ=0
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
            YQ.set(1);
            mVar YPROGP = m$.var("YPROGP");
            YPROGP.set(YPROG2.get());
            for (;true;) {
              YPROGP.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGP.get())));
              if (mOp.NotEqual(m$.Fnc.$extract(YPROGP.get(),1,m$.Fnc.$length(YPROG2.get())),YPROG2.get())) {
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
            //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROG2_";") D  SET YQ=0 QUIT  ;BERECHTIGT
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get())))) {
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROG2.get()),";")))) {
                do {
                  //<< . . . IF $PIECE(YA,Y,2)'="" SET ^WWWUSE(0,YUSER,$PIECE(YA,Y,2),"A",1)="Form Access"
                  if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                    m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"A",1).set("Form Access");
                  }
                  //<< . . . QUIT
                  break;
                } while (false);
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
        //<< . IF $DATA(^WWW0041(0,YAPP,YPROG2,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,m$.var("YAPP").get(),YPROG2.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
          m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
        }
        //<< . IF $DATA(^WWW00441(0,YAPP,YPROG2,1)) IF $PIECE(^(1),Y,1)'="" SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW00441",0,m$.var("YAPP").get(),YPROG2.get(),1)))) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1),"")) {
            m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
          }
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
            do {
              //<< . . IF YPROG2'=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") DO
              if (mOp.NotEqual(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
                do {
                  //<< . . . NEW YANZ
                  mVar YANZ = m$.var("YANZ");
                  m$.newVarBlock(3,YANZ);
                  //<< . . . SET YASTART=1
                  YASTART.set(1);
                  //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
                  //<< . . . SET YANZ=YAPP_","_YPROG2
                  YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),YPROG2.get()));
                  //<< . . . DO ^WWWCGI
                  m$.Cmd.Do("WWWCGI.main");
                  //<< . . . WRITE """"_">"
                  m$.Cmd.Write(mOp.Concat("\"",">"));
                  //<< . . . QUIT
                  break;
                } while (false);
              }
              m$.restoreVarBlock(3);
              //<< . . IF YPROG2=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") DO
              if (mOp.Equal(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
                do {
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
                  //<< . . . WRITE """"_">"
                  m$.Cmd.Write(mOp.Concat("\"",">"));
                  //<< . . . QUIT
                  break;
                } while (false);
              }
              m$.restoreVarBlock(3);
              //<< . . QUIT
              break;
            } while (false);
          }
        }
        //<< . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") DO
        if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
          do {
            //<< . . SET YFORM=$PIECE(YA,Y,2)
            mVar YFORM = m$.var("YFORM");
            YFORM.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2));
            //<< . . IF $GET(YBEDMOD)'="" IF $DATA(^WWW00441(0,YAPP,YPROG2,1)) DO  ;CHECK LESEBERECHTIGUNG;TYBD;04,07,2003;23883;
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBEDMOD")),"")) {
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW00441",0,m$.var("YAPP").get(),YPROG2.get(),1)))) {
                do {
                  //<< . . . NEW MOD,ACCESS,YI
                  mVar MOD = m$.var("MOD");
                  mVar ACCESS = m$.var("ACCESS");
                  mVar YI = m$.var("YI");
                  m$.newVarBlock(3,MOD,ACCESS,YI);
                  //<< . . . SET MOD=$TR($PIECE(^(1),Y,104),";",",")
                  MOD.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),104),";",","));
                  //<< . . . IF MOD'="" DO  ;DAVON lESEBERECHTIGUNG
                  if (mOp.NotEqual(MOD.get(),"")) {
                    do {
                      //<< . . . . SET ACCESS=0
                      ACCESS.set(0);
                      //<< . . . . FOR YI(2)=1:1 QUIT:$PIECE(YBEDMOD,",",YI(2))=""  IF $FIND(","_MOD_",",","_$PIECE(YBEDMOD,",",YI(2))_",") SET ACCESS=1 QUIT
                      for (m$.var("YI",2).set(1);(true);m$.var("YI",2).set(mOp.Add(m$.var("YI",2).get(),1))) {
                        if (mOp.Equal(m$.Fnc.$piece(m$.var("YBEDMOD").get(),",",YI.var(2).get()),"")) {
                          break;
                        }
                        if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",MOD.get()),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YBEDMOD").get(),",",YI.var(2).get())),",")))) {
                          ACCESS.set(1);
                          break;
                        }
                      }
                      //<< . . . . IF ACCESS=1 SET $PIECE(YA,Y,5)=5  ;NUR LESEBERECHTIGUNG ;only
                      if (mOp.Equal(ACCESS.get(),1)) {
                        m$.pieceVar(YA,m$.var("Y").get(),5).set(5);
                      }
                      //<< . . . . QUIT
                      break;
                    } while (false);
                  }
                  //<< . . . QUIT
                  break;
                } while (false);
              }
              m$.restoreVarBlock(3);
            }
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
                //<< . . . WRITE "<A"
                m$.Cmd.Write("<A");
                //<< . . . DO STAT
                m$.Cmd.Do("STAT");
                //<< . . . WRITE " HREF="
                m$.Cmd.Write(" HREF=");
                //<< . . . WRITE """"
                m$.Cmd.Write("\"");
                //<< . . . IF +$PIECE(YA,Y,20)'=0 DO  ;WENN MIT VERGRÖSSERUNG ;when by means of
                if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)),0)) {
                  do {
                    //<< . . . . WRITE "JavaScript:parent.document.body.cols='"_(100-$PIECE(YA,Y,20))_"%,"_$PIECE(YA,Y,20)_"%'; "
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("JavaScript:parent.document.body.cols='",(mOp.Subtract(100,m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)))),"%,"),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)),"%'; "));
                    //<< . . . . WRITE "window.location='"
                    m$.Cmd.Write("window.location='");
                    //<< . . . . QUIT
                    break;
                  } while (false);
                }
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
                //<< . . . QUIT
                break;
              } while (false);
            }
            m$.restoreVarBlock(3);
            //<< . . IF $PIECE(YA,Y,12)'="" DO  ;URL
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
              do {
                //<< . . . SET YORDNER="ordner4.gif"
                mVar YORDNER = m$.var("YORDNER");
                YORDNER.set("ordner4.gif");
                //<< . . . SET YASTART=1
                YASTART.set(1);
                //<< . . . WRITE "<A HREF="_""""
                m$.Cmd.Write(mOp.Concat("<A HREF=","\""));
                //<< . . . ;WRITE $PIECE(YA,Y,12)
                //<< . . . WRITE $$^WWWTRANSLATE($PIECE(YA,Y,12),"/YUCI/","/"_$GET(YUCI)_"/")  ;YUCI ; SR13680
                m$.Cmd.Write(m$.fnc$("WWWTRANSLATE.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"/YUCI/",mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("YUCI"))),"/")));
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
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . QUIT
            break;
          } while (false);
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
        //<< . IF YB1END=0 WRITE "<IMG SRC="_""""_YGIF_"iplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YB1END").get(),0)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"iplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YB1END=1 WRITE "<IMG SRC="_""""_YGIF_"bplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YB1END").get(),1)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"bplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YP2END=1 DO
        if (mOp.Equal(YP2END.get(),1)) {
          do {
            //<< . . IF YB2END=0 DO
            if (mOp.Equal(YB2END.get(),0)) {
              do {
                //<< . . . SET BPLUS="plus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="tplus.gif"
                mVar BPLUS = m$.var("BPLUS");
                BPLUS.set("plus.gif");
                if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                  BPLUS.set("tplus.gif");
                }
                //<< . . . IF YPROG2'=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") DO
                if (mOp.NotEqual(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
                  do {
                    //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                      }
                    }
                    //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                    }
                    //<< . . . . QUIT
                    break;
                  } while (false);
                }
                //<< . . . IF YPROG2=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                if (mOp.Equal(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top>"));
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                }
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . IF YB2END=1 DO
            if (mOp.Equal(YB2END.get(),1)) {
              do {
                //<< . . . SET BPLUS="eplus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
                mVar BPLUS = m$.var("BPLUS");
                BPLUS.set("eplus.gif");
                if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                  BPLUS.set("lplus.gif");
                }
                //<< . . . IF YPROG2'=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") DO
                if (mOp.NotEqual(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
                  do {
                    //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                      }
                    }
                    //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                    }
                    //<< . . . . QUIT
                    break;
                  } while (false);
                }
                //<< . . . IF YPROG2=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                if (mOp.Equal(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top>"));
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                }
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . IF YP2END=0 DO
        if (mOp.Equal(YP2END.get(),0)) {
          do {
            //<< . . IF YB2END=0 DO
            if (mOp.Equal(YB2END.get(),0)) {
              do {
                //<< . . . SET BPLUS="plus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="eplus.gif"
                mVar BPLUS = m$.var("BPLUS");
                BPLUS.set("plus.gif");
                if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                  BPLUS.set("eplus.gif");
                }
                //<< . . . IF YPROG2'=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") DO
                if (mOp.NotEqual(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
                  do {
                    //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                      }
                    }
                    //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                    }
                    //<< . . . . QUIT
                    break;
                  } while (false);
                }
                //<< . . . IF YPROG2=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                if (mOp.Equal(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top>"));
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                }
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . IF YB2END=1 DO
            if (mOp.Equal(YB2END.get(),1)) {
              do {
                //<< . . . SET BPLUS="eplus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
                mVar BPLUS = m$.var("BPLUS");
                BPLUS.set("eplus.gif");
                if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                  BPLUS.set("lplus.gif");
                }
                //<< . . . IF YPROG2'=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") DO
                if (mOp.NotEqual(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
                  do {
                    //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                      }
                    }
                    //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                    }
                    //<< . . . . QUIT
                    break;
                  } while (false);
                }
                //<< . . . IF YPROG2=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                if (mOp.Equal(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top>"));
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                }
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . ;I $D(^WWW0041(0,YAPP,YPROG2,$$^WWWLANGU(YBED),1)) S $P(YA,Y,1)=$P(^(1),Y,1)
        //<< . IF YPROG2=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") WRITE "<B>"
        if (mOp.Equal(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
          m$.Cmd.Write("<B>");
        }
        //<< . I $F(YA,"'") S YA=$$^WWWTRANSLATE(YA,"'","&#146;")
        if (mOp.Logical(m$.Fnc.$find(YA.get(),"'"))) {
          YA.set(m$.fnc$("WWWTRANSLATE.main",YA.get(),"'","&#146;"));
        }
        //<< . WRITE $$^WWWUML($PIECE(YA,Y,1))
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
        //<< . IF YPROG2=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") WRITE "</B>"
        if (mOp.Equal(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
          m$.Cmd.Write("</B>");
        }
        //<< . IF YASTART=1 WRITE "</A>" DO EDITMENU^WWWMENU4(2)  ;FIS;20.05.03;23658;SHORT CUT MENU
        if (mOp.Equal(YASTART.get(),1)) {
          m$.Cmd.Write("</A>");
          m$.Cmd.Do("WWWMENU4.EDITMENU",2);
        }
        //<< . IF $PIECE(YA,Y,21)'="" DO CHART^WWWMENU4  ;EXTRACHART BEI MENUES;TYBD;4,09,2003
        if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),21),"")) {
          m$.Cmd.Do("WWWMENU4.CHART");
        }
        //<< . IF YANZ'="" IF YPROG2=($PIECE($PIECE(YANZ,",",2),".",1,3)_".") DO PRO2
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(YPROG2.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,3),".")))) {
            m$.Cmd.Do("PRO2");
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
  //<< PRO2 ;
  public void PRO2() {
    //<< SET YPROG3=YPROG2 FOR  SET YPROG3=$ORDER(^WWW004(0,YAPP,YPROG3)) QUIT:YPROG3=""  QUIT:$EXTRACT(YPROG3,1,$LENGTH(YPROG2))'=YPROG2  DO
    mVar YPROG3 = m$.var("YPROG3");
    YPROG3.set(m$.var("YPROG2").get());
    for (;true;) {
      YPROG3.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG3.get())));
      if (mOp.Equal(YPROG3.get(),"")) {
        break;
      }
      if (mOp.NotEqual(m$.Fnc.$extract(YPROG3.get(),1,m$.Fnc.$length(m$.var("YPROG2").get())),m$.var("YPROG2").get())) {
        break;
      }
      do {
        //<< . QUIT:$PIECE(YPROG3,".",5,9)'=""
        if (mOp.NotEqual(m$.Fnc.$piece(YPROG3.get(),".",5,9),"")) {
          break;
        }
        //<< . IF (YAPP_","_YPROG3)=YANZ WRITE "<A NAME='TARGET'></A>"
        if (mOp.Equal((mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),YPROG3.get())),m$.var("YANZ").get())) {
          m$.Cmd.Write("<A NAME='TARGET'></A>");
        }
        //<< . SET YB3END=0 IF $PIECE($ORDER(^WWW004(0,YAPP,YPROG3_$CHAR(255))),".",1,3)'=$PIECE(YPROG3,".",1,3) SET YB3END=1
        mVar YB3END = m$.var("YB3END");
        YB3END.set(0);
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),mOp.Concat(YPROG3.get(),m$.Fnc.$char(255)))),".",1,3),m$.Fnc.$piece(YPROG3.get(),".",1,3))) {
          YB3END.set(1);
        }
        //<< . SET YP3END=0 IF $PIECE($ORDER(^WWW004(0,YAPP,YPROG3_$CHAR(255))),".",1,4)'=$PIECE(YPROG3,".",1,4) SET YP3END=1
        mVar YP3END = m$.var("YP3END");
        YP3END.set(0);
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),mOp.Concat(YPROG3.get(),m$.Fnc.$char(255)))),".",1,4),m$.Fnc.$piece(YPROG3.get(),".",1,4))) {
          YP3END.set(1);
        }
        //<< . SET YA=$GET(^WWW004(0,YAPP,YPROG3,1))
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$get(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROG3.get(),1)));
        //<< . Q:$PIECE(YA,Y,7)="noshow"  ;keine anzeige ;None
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"noshow")) {
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
        //<< . SET YQ=0
        mVar YQ = m$.var("YQ");
        YQ.set(0);
        //<< . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" SET YQ=1 SET YPROGP=YPROG3 FOR  SET YPROGP=$ORDER(^WWW004(0,YAPP,YPROGP)) QUIT:$EXTRACT(YPROGP,1,$LENGTH(YPROG3))'=YPROG3  QUIT:YPROGP=""  DO  QUIT:YQ=0
        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
            YQ.set(1);
            mVar YPROGP = m$.var("YPROGP");
            YPROGP.set(YPROG3.get());
            for (;true;) {
              YPROGP.set(m$.Fnc.$order(m$.var("^WWW004",0,m$.var("YAPP").get(),YPROGP.get())));
              if (mOp.NotEqual(m$.Fnc.$extract(YPROGP.get(),1,m$.Fnc.$length(YPROG3.get())),YPROG3.get())) {
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
            //<< . . IF $DATA(^WWW0132(0,YBED,YM,YAPP)) IF $FIND(";"_$PIECE($GET(^WWW0132(0,YBED,YM,YAPP,1)),Y,1)_";",";"_YPROG3_";") D  SET YQ=0 QUIT  ;BERECHTIGT
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get())))) {
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0132",0,m$.var("YBED").get(),m$.var("YM").get(),m$.var("YAPP").get(),1)),m$.var("Y").get(),1)),";"),mOp.Concat(mOp.Concat(";",YPROG3.get()),";")))) {
                do {
                  //<< . . . IF $PIECE(YA,Y,2)'="" SET ^WWWUSE(0,YUSER,$PIECE(YA,Y,2),"A",1)="Form Access"
                  if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                    m$.var("^WWWUSE",0,m$.var("YUSER").get(),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"A",1).set("Form Access");
                  }
                  //<< . . . QUIT
                  break;
                } while (false);
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
        //<< . IF $DATA(^WWW0041(0,YAPP,YPROG3,$$^WWWLANGU(YBED),1)) SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,m$.var("YAPP").get(),YPROG3.get(),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),1)))) {
          m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
        }
        //<< . IF $DATA(^WWW00441(0,YAPP,YPROG3,1)) IF $PIECE(^(1),Y,1)'="" SET $PIECE(YA,Y,1)=$PIECE(^(1),Y,1)
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW00441",0,m$.var("YAPP").get(),YPROG3.get(),1)))) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1),"")) {
            m$.pieceVar(YA,m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1));
          }
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
            do {
              //<< . . IF YPROG3'=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") DO
              if (mOp.NotEqual(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
                do {
                  //<< . . . NEW YANZ
                  mVar YANZ = m$.var("YANZ");
                  m$.newVarBlock(3,YANZ);
                  //<< . . . SET YASTART=1
                  YASTART.set(1);
                  //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
                  //<< . . . SET YANZ=YAPP_","_YPROG3
                  YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),YPROG3.get()));
                  //<< . . . DO ^WWWCGI
                  m$.Cmd.Do("WWWCGI.main");
                  //<< . . . WRITE """"_">"
                  m$.Cmd.Write(mOp.Concat("\"",">"));
                  //<< . . . QUIT
                  break;
                } while (false);
              }
              m$.restoreVarBlock(3);
              //<< . . IF YPROG3=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") DO
              if (mOp.Equal(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
                do {
                  //<< . . . NEW YANZ
                  mVar YANZ = m$.var("YANZ");
                  m$.newVarBlock(3,YANZ);
                  //<< . . . SET YASTART=1
                  YASTART.set(1);
                  //<< . . . WRITE "<A HREF="_""""_YAKTION_"EP=WWWMENU"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWMENU"));
                  //<< . . . SET YANZ=YAPP_","_YPROG2
                  YANZ.set(mOp.Concat(mOp.Concat(m$.var("YAPP").get(),","),m$.var("YPROG2").get()));
                  //<< . . . DO ^WWWCGI
                  m$.Cmd.Do("WWWCGI.main");
                  //<< . . . WRITE """"_">"
                  m$.Cmd.Write(mOp.Concat("\"",">"));
                  //<< . . . QUIT
                  break;
                } while (false);
              }
              m$.restoreVarBlock(3);
              //<< . . QUIT
              break;
            } while (false);
          }
        }
        //<< . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") DO
        if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
          do {
            //<< . . SET YFORM=$PIECE(YA,Y,2)
            mVar YFORM = m$.var("YFORM");
            YFORM.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2));
            //<< . . IF $GET(YBEDMOD)'="" IF $DATA(^WWW00441(0,YAPP,YPROG3,1)) DO  ;CHECK LESEBERECHTIGUNG;TYBD;04,07,2003;23883;
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBEDMOD")),"")) {
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW00441",0,m$.var("YAPP").get(),YPROG3.get(),1)))) {
                do {
                  //<< . . . NEW MOD,ACCESS,YI
                  mVar MOD = m$.var("MOD");
                  mVar ACCESS = m$.var("ACCESS");
                  mVar YI = m$.var("YI");
                  m$.newVarBlock(3,MOD,ACCESS,YI);
                  //<< . . . SET MOD=$TR($PIECE(^(1),Y,104),";",",")
                  MOD.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),104),";",","));
                  //<< . . . IF MOD'="" DO  ;DAVON lESEBERECHTIGUNG
                  if (mOp.NotEqual(MOD.get(),"")) {
                    do {
                      //<< . . . . SET ACCESS=0
                      ACCESS.set(0);
                      //<< . . . . FOR YI(2)=1:1 QUIT:$PIECE(YBEDMOD,",",YI(2))=""  IF $FIND(","_MOD_",",","_$PIECE(YBEDMOD,",",YI(2))_",") SET ACCESS=1 QUIT
                      for (m$.var("YI",2).set(1);(true);m$.var("YI",2).set(mOp.Add(m$.var("YI",2).get(),1))) {
                        if (mOp.Equal(m$.Fnc.$piece(m$.var("YBEDMOD").get(),",",YI.var(2).get()),"")) {
                          break;
                        }
                        if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",MOD.get()),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YBEDMOD").get(),",",YI.var(2).get())),",")))) {
                          ACCESS.set(1);
                          break;
                        }
                      }
                      //<< . . . . IF ACCESS=1 SET $PIECE(YA,Y,5)=5  ;NUR LESEBERECHTIGUNG ;only
                      if (mOp.Equal(ACCESS.get(),1)) {
                        m$.pieceVar(YA,m$.var("Y").get(),5).set(5);
                      }
                      //<< . . . . QUIT
                      break;
                    } while (false);
                  }
                  //<< . . . QUIT
                  break;
                } while (false);
              }
              m$.restoreVarBlock(3);
            }
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
                  do {
                    //<< . . . . WRITE "JavaScript:parent.document.body.cols='"_(100-$PIECE(YA,Y,20))_"%,"_$PIECE(YA,Y,20)_"%'; "
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("JavaScript:parent.document.body.cols='",(mOp.Subtract(100,m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)))),"%,"),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20)),"%'; "));
                    //<< . . . . WRITE "window.location='"
                    m$.Cmd.Write("window.location='");
                    //<< . . . . QUIT
                    break;
                  } while (false);
                }
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
                //<< . . . QUIT
                break;
              } while (false);
            }
            m$.restoreVarBlock(3);
            //<< . . IF $PIECE(YA,Y,12)'="" DO  ;URL
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
              do {
                //<< . . . SET YORDNER="ordner4.gif"
                mVar YORDNER = m$.var("YORDNER");
                YORDNER.set("ordner4.gif");
                //<< . . . SET YASTART=1
                YASTART.set(1);
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
            //<< . . QUIT
            break;
          } while (false);
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
        //<< . IF YB1END=0 WRITE "<IMG SRC="_""""_YGIF_"iplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YB1END").get(),0)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"iplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YB1END=1 WRITE "<IMG SRC="_""""_YGIF_"bplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YB1END").get(),1)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"bplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YB2END=0 WRITE "<IMG SRC="_""""_YGIF_"iplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YB2END").get(),0)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"iplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YB2END=1 WRITE "<IMG SRC="_""""_YGIF_"bplus.gif"_""""_" border=0 align=top>"
        if (mOp.Equal(m$.var("YB2END").get(),1)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"bplus.gif"),"\"")," border=0 align=top>"));
        }
        //<< . IF YP3END=1 DO
        if (mOp.Equal(YP3END.get(),1)) {
          do {
            //<< . . IF YB3END=0 DO
            if (mOp.Equal(YB3END.get(),0)) {
              do {
                //<< . . . SET BPLUS="plus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="tplus.gif"
                mVar BPLUS = m$.var("BPLUS");
                BPLUS.set("plus.gif");
                if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                  BPLUS.set("tplus.gif");
                }
                //<< . . . IF YPROG3'=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") DO
                if (mOp.NotEqual(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
                  do {
                    //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                      }
                    }
                    //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                    }
                    //<< . . . . QUIT
                    break;
                  } while (false);
                }
                //<< . . . IF YPROG3=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                if (mOp.Equal(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top>"));
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                }
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . IF YB3END=1 DO
            if (mOp.Equal(YB3END.get(),1)) {
              do {
                //<< . . . SET BPLUS="eplus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
                mVar BPLUS = m$.var("BPLUS");
                BPLUS.set("eplus.gif");
                if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                  BPLUS.set("lplus.gif");
                }
                //<< . . . IF YPROG3'=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") DO
                if (mOp.NotEqual(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
                  do {
                    //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                      }
                    }
                    //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                    }
                    //<< . . . . QUIT
                    break;
                  } while (false);
                }
                //<< . . . IF YPROG3=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                if (mOp.Equal(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top>"));
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                }
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . IF YP3END=0 DO
        if (mOp.Equal(YP3END.get(),0)) {
          do {
            //<< . . IF YB3END=0 DO
            if (mOp.Equal(YB3END.get(),0)) {
              do {
                //<< . . . SET BPLUS="plus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="eplus.gif"
                mVar BPLUS = m$.var("BPLUS");
                BPLUS.set("plus.gif");
                if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                  BPLUS.set("eplus.gif");
                }
                //<< . . . IF YPROG3'=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") DO
                if (mOp.NotEqual(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
                  do {
                    //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                      }
                    }
                    //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                    }
                    //<< . . . . QUIT
                    break;
                  } while (false);
                }
                //<< . . . IF YPROG3=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") WRITE "<IMG SRC="_""""_YGIF_"minus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                if (mOp.Equal(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"minus.gif"),"\"")," border=0 align=top>"));
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                }
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . IF YB3END=1 DO
            if (mOp.Equal(YB3END.get(),1)) {
              do {
                //<< . . . SET BPLUS="eplus.gif" IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") SET BPLUS="lplus.gif"
                mVar BPLUS = m$.var("BPLUS");
                BPLUS.set("eplus.gif");
                if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                  BPLUS.set("lplus.gif");
                }
                //<< . . . IF YPROG3'=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") DO
                if (mOp.NotEqual(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
                  do {
                    //<< . . . . IF $PIECE(YA,Y,2)="" IF $PIECE(YA,Y,12)="" WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oclose.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),"")) {
                      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oclose.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                      }
                    }
                    //<< . . . . IF $PIECE(YA,Y,2)'=""!($PIECE(YA,Y,12)'="") WRITE "<IMG SRC="_""""_YGIF_BPLUS_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_BILD_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                    if (mOp.Or(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),2),""),(mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")))) {
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BPLUS.get()),"\"")," border=0 align=top>"));
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),BILD.get()),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                    }
                    //<< . . . . QUIT
                    break;
                  } while (false);
                }
                //<< . . . IF YPROG3=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") WRITE "<IMG SRC="_""""_YGIF_"eminus.gif"_""""_" border=0 align=top>" WRITE "<IMG SRC="_""""_YGIF_"oopen.gif"_""""_" TITLE="_$$^WWWTEXT(8)_" border=0 ALIGN=TOP>"
                if (mOp.Equal(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"eminus.gif"),"\"")," border=0 align=top>"));
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"oopen.gif"),"\"")," TITLE="),m$.fnc$("WWWTEXT.main",8))," border=0 ALIGN=TOP>"));
                }
                //<< . . . QUIT
                break;
              } while (false);
            }
            //<< . . QUIT
            break;
          } while (false);
        }
        //<< . ;I $D(^WWW0041(0,YAPP,YPROG3,$$^WWWLANGU(YBED),1)) S $P(YA,Y,1)=$P(^(1),Y,1)
        //<< . IF YPROG3=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") WRITE "<B>"
        if (mOp.Equal(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
          m$.Cmd.Write("<B>");
        }
        //<< . I $F(YA,"'") S YA=$$^WWWTRANSLATE(YA,"'","&#146;")
        if (mOp.Logical(m$.Fnc.$find(YA.get(),"'"))) {
          YA.set(m$.fnc$("WWWTRANSLATE.main",YA.get(),"'","&#146;"));
        }
        //<< . WRITE $$^WWWUML($PIECE(YA,Y,1))
        m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
        //<< . IF YPROG3=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") WRITE "<B>"
        if (mOp.Equal(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
          m$.Cmd.Write("<B>");
        }
        //<< . IF YASTART=1 WRITE "</A>" DO EDITMENU^WWWMENU4(3)  ;FIS;20.05.03;23658;SHORT CUT MENU
        if (mOp.Equal(YASTART.get(),1)) {
          m$.Cmd.Write("</A>");
          m$.Cmd.Do("WWWMENU4.EDITMENU",3);
        }
        //<< . IF $PIECE(YA,Y,21)'="" DO CHART^WWWMENU4  ;EXTRACHART BEI MENUES;TYBD;4,09,2003
        if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),21),"")) {
          m$.Cmd.Do("WWWMENU4.CHART");
        }
        //<< . IF YANZ'="" IF YPROG3=($PIECE($PIECE(YANZ,",",2),".",1,4)_".") DO PRO3
        if (mOp.NotEqual(m$.var("YANZ").get(),"")) {
          if (mOp.Equal(YPROG3.get(),(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YANZ").get(),",",2),".",1,4),".")))) {
            m$.Cmd.Do("PRO3");
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
  //<< PRO3 ;
  public void PRO3() {
    //<< DO ^WWWMENUV
    m$.Cmd.Do("WWWMENUV.main");
    //<< QUIT
    return;
  }

  //<< 
  //<< STAT ;STATUS
  public void STAT() {
    //<< WRITE " TITLE="_""""_$PIECE(YA,Y,1)
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),1)));
    //<< WRITE " ("_$GET(YPROG2)
    m$.Cmd.Write(mOp.Concat(" (",m$.Fnc.$get(m$.var("YPROG2"))));
    //<< IF YBEDBER=1 WRITE " "_$PIECE(YA,Y,2)
    if (mOp.Equal(m$.var("YBEDBER").get(),1)) {
      m$.Cmd.Write(mOp.Concat(" ",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),2)));
    }
    //<< W ")"
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
    //<< WRITE " ("_$GET(YPROG3)
    m$.Cmd.Write(mOp.Concat(" (",m$.Fnc.$get(m$.var("YPROG3"))));
    //<< IF YBEDBER=1 WRITE " "_$PIECE(YA,Y,2)
    if (mOp.Equal(m$.var("YBEDBER").get(),1)) {
      m$.Cmd.Write(mOp.Concat(" ",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),2)));
    }
    //<< W ")"
    m$.Cmd.Write(")");
    //<< WRITE """"
    m$.Cmd.Write("\"");
    //<< QUIT
    return;
  }

//<< 
}
