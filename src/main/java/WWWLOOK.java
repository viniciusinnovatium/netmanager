//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWLOOK
//** Innovatium Systems - Code Converter - v1.24
//** 2014-06-02 20:16:33
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
//import COMSYS;

//<< WWWLOOK
public class WWWLOOK extends mClass {

  public void main() {
    _WWWLOOK();
  }

  public void _WWWLOOK() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SUCHEN DATENSATZ
    //<< ;Vorgaben suchen bei open datensatz ;default seek next to
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
    //<< ; 12-Oct-2005   GRF     Doco
    //<< ; 20.05.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YI,YA,YFELD1,YKEY1
    mVar YI = m$.var("YI");
    mVar YA = m$.var("YA");
    mVar YFELD1 = m$.var("YFELD1");
    mVar YKEY1 = m$.var("YKEY1");
    m$.newVar(YI,YA,YFELD1,YKEY1);
    //<< 
    //<< SET YDATEI=$PIECE(YVOR,Y,11)
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11));
    //<< SET YKEY1=""
    YKEY1.set("");
    //<< IF YALLKEY=2 DO  QUIT
    if (mOp.Equal(m$.var("YALLKEY").get(),2)) {
      //<< . FOR YI=1:1 QUIT:'$DATA(YKEY(YI))  QUIT:YKEY(YI)=""  DO
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        if (mOp.Not(m$.Fnc.$data(m$.var("YKEY").var(YI.get())))) {
          break;
        }
        if (mOp.Equal(m$.var("YKEY").var(YI.get()).get(),"")) {
          break;
        }
        do {
          //<< . . NEW YXKEY
          mVar YXKEY = m$.var("YXKEY");
          m$.newVar(YXKEY);
          //<< . . SET YTYP=$PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)
          mVar YTYP = m$.var("YTYP");
          YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),YI.get(),1)),m$.var("Y").get(),3));
          //<< . . SET YXKEY=YKEY(YI)
          YXKEY.set(m$.var("YKEY").var(YI.get()).get());
          //<< . . IF YTYP=1 SET YXKEY=$$^WWWDATE1(YXKEY)
          if (mOp.Equal(YTYP.get(),1)) {
            YXKEY.set(m$.fnc$("WWWDATE1.main",YXKEY.get()));
          }
          //<< . . IF YTYP=7 SET YXKEY=$$^WWWTIME1(YXKEY)
          if (mOp.Equal(YTYP.get(),7)) {
            YXKEY.set(m$.fnc$("WWWTIME1.main",YXKEY.get()));
          }
          //<< . . QUIT:YXKEY=""
          if (mOp.Equal(YXKEY.get(),"")) {
            break;
          }
          //<< . . SET YKEY1=YKEY1_YXKEY_","
          YKEY1.set(mOp.Concat(mOp.Concat(YKEY1.get(),YXKEY.get()),","));
        } while (false);
      }
      //<< . ;
      //<< . DO FIND
      m$.Cmd.Do("FIND");
      return;
    }
    //<< 
    //<< IF YFELD'="" DO FIND QUIT
    if (mOp.NotEqual(m$.var("YFELD").get(),"")) {
      m$.Cmd.Do("FIND");
      return;
    }
    FIND();
  }

  //<< 
  //<< FIND ;SUCHEN KEY AUS WILD ;seek KEY out of wild
  public void FIND() {
    //<< SET YFELD1 = $TRANSLATE(YFELD,"+")
    mVar YFELD1 = m$.var("YFELD1");
    YFELD1.set(m$.Fnc.$translate(m$.var("YFELD").get(),"+"));
    //<< SET YKEY1  = $TRANSLATE(YKEY1,"+*")
    mVar YKEY1 = m$.var("YKEY1");
    YKEY1.set(m$.Fnc.$translate(m$.var("YKEY1").get(),"+*"));
    //<< ;DO ^WWWSOR(YDATEI,"","",1,0,0,1,YFELD1,YKEY1)  ;ALT
    //<< DO ^WWWSOR(YDATEI,"","",1,0,100,1,YFELD1,YKEY1)  ;TYBD;NUR 100 STÜCK MAX;8,1,2004
    m$.Cmd.Do("WWWSOR.main",m$.var("YDATEI").get(),"","",1,0,100,1,YFELD1.get(),YKEY1.get());
    //<< SET YKEY=""
    mVar YKEY = m$.var("YKEY");
    YKEY.set("");
    //<< SET YA(2)="" SET YA(2)=$ORDER(^WWWSOR(YUSER,"KEY",YA(2)),-1) IF YA(2)'="" DO     ; FIXME : no FOR commands in these 2 lines - get first entry only?
    mVar YA = m$.var("YA");
    YA.var(2).set("");
    YA.var(2).set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YA.var(2).get()),mOp.Negative(1)));
    if (mOp.NotEqual(YA.var(2).get(),"")) {
      //<< . SET YKEY="" SET YKEY=$ORDER(^WWWSOR(YUSER,"KEY",YA(2),YKEY)) IF YKEY'=""  DO
      YKEY.set("");
      YKEY.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YA.var(2).get(),YKEY.get())));
      if (mOp.NotEqual(YKEY.get(),"")) {
        //<< . . SET YA=$GET(^WWWSOR(YUSER,"KEY",YA(2),YKEY))
        YA.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YA.var(2).get(),YKEY.get())));
        //<< . . FOR YI=1:1 QUIT:$PIECE(YKEY,",",YI)=""  SET YKEY(YI)=$PIECE(YKEY,",",YI)
        mVar YI = m$.var("YI");
        for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
          if (mOp.Equal(m$.Fnc.$piece(YKEY.get(),",",YI.get()),"")) {
            break;
          }
          YKEY.var(YI.get()).set(m$.Fnc.$piece(YKEY.get(),",",YI.get()));
        }
      }
    }
    //<< 
    //<< KILL ^WWWSOR(YUSER)
    m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< PRIM ;SUCHEN KEYS OHNE PRIMÄRSCHLÜSSEL ;seek without
  public void PRIM() {
    //<< SET YFELD1=$TRANSLATE(YFELD,"+*")
    mVar YFELD1 = m$.var("YFELD1");
    YFELD1.set(m$.Fnc.$translate(m$.var("YFELD").get(),"+*"));
    //<< NEW YSCH,YFLD,Q,YSCHK
    mVar YSCH = m$.var("YSCH");
    mVar YFLD = m$.var("YFLD");
    mVar Q = m$.var("Q");
    mVar YSCHK = m$.var("YSCHK");
    m$.newVar(YSCH,YFLD,Q,YSCHK);
    //<< SET YSCH="^"_YDATEI_"s("_$$^WWWYM(YDATEI,1)_1
    YSCH.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YDATEI").get()),"s("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),1));
    //<< SET Q=0
    Q.set(0);
    //<< SET YFLD=""
    YFLD.set("");
    //<< FOR  SET YFLD=$ORDER(^WWW003s(0,2,1,YDATEI,YFLD)) QUIT:YFLD=""  DO  QUIT:Q=1
    for (;true;) {
      YFLD.set(m$.Fnc.$order(m$.var("^WWW003s",0,2,1,m$.var("YDATEI").get(),YFLD.get())));
      if (mOp.Equal(YFLD.get(),"")) {
        break;
      }
      do {
        //<< . IF $PIECE(YFELD1,Y,YFLD)="" SET Q=1 QUIT
        if (mOp.Equal(m$.Fnc.$piece(YFELD1.get(),m$.var("Y").get(),YFLD.get()),"")) {
          Q.set(1);
          break;
        }
        //<< . SET YSCH=YSCH_","_$PIECE(YFELD1,Y,YFLD)
        YSCH.set(mOp.Concat(mOp.Concat(YSCH.get(),","),m$.Fnc.$piece(YFELD1.get(),m$.var("Y").get(),YFLD.get())));
      } while (false);
      if (mOp.Equal(Q.get(),1)) {
        break;
      }
    }
    //<< 
    //<< QUIT:Q=1
    if (mOp.Equal(Q.get(),1)) {
      return;
    }
    //<< SET YSCH=YSCH_","_""""_""""_")"
    YSCH.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YSCH.get(),","),"\""),"\""),")"));
    //<< IF $ORDER(@YSCH)'="" SET YKEY(1)=$ORDER(@YSCH),YKEY=YKEY(1)
    if (mOp.NotEqual(m$.Fnc.$order(m$.indirectVar(YSCH.get())),"")) {
      mVar YKEY = m$.var("YKEY");
      YKEY.var(1).set(m$.Fnc.$order(m$.indirectVar(YSCH.get())));
      YKEY.set(YKEY.var(1).get());
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< KEY ;SUCHEN FESTEN KEY ;seek KEY
  public void KEY() {
    //<< NEW YI,YA,YFELD1,YKEY1
    mVar YI = m$.var("YI");
    mVar YA = m$.var("YA");
    mVar YFELD1 = m$.var("YFELD1");
    mVar YKEY1 = m$.var("YKEY1");
    m$.newVar(YI,YA,YFELD1,YKEY1);
    //<< 
    //<< SET YDATEI=$$$WWW120ClassUsedInForm(YVOR)
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.var("YVOR")));
    //<< QUIT:YDATEI=""
    if (mOp.Equal(YDATEI.get(),"")) {
      return;
    }
    //<< 
    //<< SET YKEY1=""
    YKEY1.set("");
    //<< SET YA="^"_YDATEI_"("_$$^WWWYM(YDATEI,1)
    YA.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get(),1)));
    //<< 
    //<< FOR YI=1:1 QUIT:'$DATA(YKEY(YI))  QUIT:YKEY(YI)=""  DO
    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
      if (mOp.Not(m$.Fnc.$data(m$.var("YKEY").var(YI.get())))) {
        break;
      }
      if (mOp.Equal(m$.var("YKEY").var(YI.get()).get(),"")) {
        break;
      }
      do {
        //<< . NEW YXKEY
        mVar YXKEY = m$.var("YXKEY");
        m$.newVar(YXKEY);
        //<< . SET YTYP=$PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)
        mVar YTYP = m$.var("YTYP");
        YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),YI.get(),1)),m$.var("Y").get(),3));
        //<< . SET YXKEY=YKEY(YI)
        YXKEY.set(m$.var("YKEY").var(YI.get()).get());
        //<< . IF YTYP=1 SET YXKEY=$$^WWWDATE1(YXKEY)
        if (mOp.Equal(YTYP.get(),1)) {
          YXKEY.set(m$.fnc$("WWWDATE1.main",YXKEY.get()));
        }
        //<< . IF YTYP=7 SET YXKEY=$$^WWWTIME1(YXKEY)
        if (mOp.Equal(YTYP.get(),7)) {
          YXKEY.set(m$.fnc$("WWWTIME1.main",YXKEY.get()));
        }
        //<< . QUIT:YXKEY=""
        if (mOp.Equal(YXKEY.get(),"")) {
          break;
        }
        //<< . SET YKEY1=YKEY1_YXKEY_","
        YKEY1.set(mOp.Concat(mOp.Concat(YKEY1.get(),YXKEY.get()),","));
        //<< . SET YA=YA_""""_YXKEY_""""_","
        YA.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YA.get(),"\""),YXKEY.get()),"\""),","));
      } while (false);
    }
    //<< 
    //<< SET YA=YA_"1)"
    YA.set(mOp.Concat(YA.get(),"1)"));
    //<< 
    //<< SET YFELD1=$$^WWWSETL(YA,1)   ;TYBD;30.04.2003; WENN LEER DANN TEST
    YFELD1.set(m$.fnc$("WWWSETL.main",YA.get(),1));
    //<< IF YFELD1'="" SET YKEY=YKEY1
    if (mOp.NotEqual(YFELD1.get(),"")) {
      mVar YKEY = m$.var("YKEY");
      YKEY.set(YKEY1.get());
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< ANZEIGE ;SUCHEN MIT ANZEIGE ;seek by means of Show
  public void ANZEIGE() {
    //<< DO ^WWWFORMX  ;VORGABEN WWW120/012
    m$.Cmd.Do("WWWFORMX.main");
    //<< DO ^WWWSTART(YFORM)
    m$.Cmd.Do("WWWSTART.main",m$.var("YFORM").get());
    //<< DO ^WWWKOPF($$^WWWTEXT(101))   ;ÖFFNEN ;open
    m$.Cmd.Do("WWWKOPF.main",m$.fnc$("WWWTEXT.main",101));
    //<< DO ^WWWUP(0)
    m$.Cmd.Do("WWWUP.main",0);
    //<< DO ^WWWBODY(2)  ;OHNE FOKUS ;without focus
    m$.Cmd.Do("WWWBODY.main",2);
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
    //<< NEW SUCH,AUSW
    mVar SUCH = m$.var("SUCH");
    mVar AUSW = m$.var("AUSW");
    m$.newVar(SUCH,AUSW);
    //<< 
    //<< SET YKEY1=""
    mVar YKEY1 = m$.var("YKEY1");
    YKEY1.set("");
    //<< FOR YI=1:1 QUIT:'$DATA(YKEY(YI))  QUIT:YKEY(YI)=""  DO
    mVar YI = m$.var("YI");
    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
      if (mOp.Not(m$.Fnc.$data(m$.var("YKEY").var(YI.get())))) {
        break;
      }
      if (mOp.Equal(m$.var("YKEY").var(YI.get()).get(),"")) {
        break;
      }
      do {
        //<< . NEW YXKEY
        mVar YXKEY = m$.var("YXKEY");
        m$.newVar(YXKEY);
        //<< . SET YTYP=$PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)
        mVar YTYP = m$.var("YTYP");
        YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),YI.get(),1)),m$.var("Y").get(),3));
        //<< . SET YXKEY=YKEY(YI)
        YXKEY.set(m$.var("YKEY").var(YI.get()).get());
        //<< . IF YTYP=1 SET YXKEY=$$^WWWDATE1(YXKEY)
        if (mOp.Equal(YTYP.get(),1)) {
          YXKEY.set(m$.fnc$("WWWDATE1.main",YXKEY.get()));
        }
        //<< . IF YTYP=7 SET YXKEY=$$^WWWTIME1(YXKEY)
        if (mOp.Equal(YTYP.get(),7)) {
          YXKEY.set(m$.fnc$("WWWTIME1.main",YXKEY.get()));
        }
        //<< . QUIT:YXKEY=""
        if (mOp.Equal(YXKEY.get(),"")) {
          break;
        }
        //<< . SET YKEY1=YKEY1_YXKEY_","
        YKEY1.set(mOp.Concat(mOp.Concat(YKEY1.get(),YXKEY.get()),","));
        //<< . QUIT
        break;
      } while (false);
    }
    //<< SET YDATEI = $PIECE(YVOR,Y,11)
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),11));
    //<< SET YFELD1 = $TRANSLATE(YFELD,Y_"+|","#")
    mVar YFELD1 = m$.var("YFELD1");
    YFELD1.set(m$.Fnc.$translate(m$.var("YFELD").get(),mOp.Concat(m$.var("Y").get(),"+|"),"#"));
    //<< SET YKEY1  = $TRANSLATE(YKEY1,"+*")
    YKEY1.set(m$.Fnc.$translate(YKEY1.get(),"+*"));
    //<< SET AUSW   = "|"_YFELD1_"|"_YKEY1
    AUSW.set(mOp.Concat(mOp.Concat(mOp.Concat("|",YFELD1.get()),"|"),YKEY1.get()));
    //<< SET SUCH   = $ORDER(^WWW123(0,YFORM,""))
    SUCH.set(m$.Fnc.$order(m$.var("^WWW123",0,m$.var("YFORM").get(),"")));
    //<< SET YSUCH1 = ""
    mVar YSUCH1 = m$.var("YSUCH1");
    YSUCH1.set("");
    //<< IF SUCH'="" SET YSUCH1=$GET(^WWW123(0,YFORM,SUCH,1))
    if (mOp.NotEqual(SUCH.get(),"")) {
      YSUCH1.set(m$.Fnc.$get(m$.var("^WWW123",0,m$.var("YFORM").get(),SUCH.get(),1)));
    }
    //<< IF YSUCH1="",$DATA(^WWW123(0,YFORM)) SET YSUCH1=$ORDER(^WWW123(0,YFORM,"")) SET YSUCH1=$PIECE(^WWW123(0,YFORM,YSUCH1,1),Y,2)
    if (mOp.Equal(YSUCH1.get(),"") && mOp.Logical(m$.Fnc.$data(m$.var("^WWW123",0,m$.var("YFORM").get())))) {
      YSUCH1.set(m$.Fnc.$order(m$.var("^WWW123",0,m$.var("YFORM").get(),"")));
      YSUCH1.set(m$.Fnc.$piece(m$.var("^WWW123",0,m$.var("YFORM").get(),YSUCH1.get(),1).get(),m$.var("Y").get(),2));
    }
    //<< ;DO ^WWWKOPF($$^WWWUML($PIECE(YSUCH1,Y,1)))
    //<< DO ^WWWKOPF($$^WWWTEXT($PIECE(YSUCH1,Y,1)))  ;TYBD;8,7,2003
    m$.Cmd.Do("WWWKOPF.main",m$.fnc$("WWWTEXT.main",m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),1)));
    //<< IF $DATA(YFORM) IF YFORM'="" DO
    if (mOp.Logical(m$.Fnc.$data(m$.var("YFORM")))) {
      if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
        do {
          //<< . ;
          //<< . WRITE YCR,"<TABLE CELLSPACING=0 BORDER=0><TR><TD NOWRAP>"
          m$.Cmd.Write(m$.var("YCR").get(),"<TABLE CELLSPACING=0 BORDER=0><TR><TD NOWRAP>");
          //<< . WRITE "<A HREF="_""""
          m$.Cmd.Write(mOp.Concat("<A HREF=","\""));
          //<< . WRITE YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM   ;  _"&YOPEN=OLD"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()));
          //<< . DO ^WWWCGI
          m$.Cmd.Do("WWWCGI.main");
          //<< . WRITE """"_">"
          m$.Cmd.Write(mOp.Concat("\"",">"));
          //<< . WRITE YCR,"<IMG SRC="_""""_YGIF_"hback.gif"_""""_" style="_""""_"cursor:w-resize"_""""_" "_YHEIGHT_" "_YWIDTH_" TITLE="_""""_$$^WWWTEXT(99)_""""_" border=0></A>"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"hback.gif"),"\"")," style="),"\""),"cursor:w-resize"),"\"")," "),m$.var("YHEIGHT").get())," "),m$.var("YWIDTH").get())," TITLE="),"\""),m$.fnc$("WWWTEXT.main",99)),"\"")," border=0></A>"));
          //<< . WRITE YCR,"</TD></TR></TABLE>"
          m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
          //<< . QUIT
          break;
        } while (false);
      }
    }
    //<< 
    //<< ;YSUCH1="FORMULAR;DATEI;SORTKEY;VORGABE;ANZEIGE KEY;ANZEIGEFELD;STD SORT;ANZEIGE ERGEBNIS;ORIENTIERUNG;ANZAHL ANZEIGEN;FIXKEY;FELDER MIT SUMMENBILDUNG;WELCHEN KEY UEBERGEBEN;
    //<< SET $PIECE(YSUCH1,Y,1)=YFORM
    m$.pieceVar(YSUCH1,m$.var("Y").get(),1).set(m$.var("YFORM").get());
    //<< IF $PIECE(YSUCH1,Y,2)="" SET $PIECE(YSUCH1,Y,2)=YDATEI
    if (mOp.Equal(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),2),"")) {
      m$.pieceVar(YSUCH1,m$.var("Y").get(),2).set(YDATEI.get());
    }
    //<< SET $PIECE(YSUCH1,Y,4)=AUSW
    m$.pieceVar(YSUCH1,m$.var("Y").get(),4).set(AUSW.get());
    //<< SET $PIECE(YSUCH1,Y,11)=YFKEY
    m$.pieceVar(YSUCH1,m$.var("Y").get(),11).set(m$.var("YFKEY").get());
    //<< SET $PIECE(YSUCH1,Y,10)=900
    m$.pieceVar(YSUCH1,m$.var("Y").get(),10).set(900);
    //<< DO ^WWWSUCH1
    m$.Cmd.Do("WWWSUCH1.main");
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
    //<< WRITE "</FONT>"
    m$.Cmd.Write("</FONT>");
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< DO ^WWWUP(1)
    m$.Cmd.Do("WWWUP.main",1);
    //<< DO ^WWWSTOP
    m$.Cmd.Do("WWWSTOP.main");
    //<< QUIT
    return;
  }

//<< 
}
