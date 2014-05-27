//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSMA
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:11
//*****************************************************************************

import mLibrary.*;


//<< WWWSMA
public class WWWSMA extends mClass {

  public void main() {
    _WWWSMA();
  }

  public void _WWWSMA() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SUCHEN DATEN MASKE SUCHFUNKTION
    //<< ;
    //<< ;   VORG(X)=SUCHFUNKTION DER SORTKEY'S ;the
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
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
    //<< ; 28-Sep-2007   GRF     Naked References
    //<< ; 08-Jun-2007   GRF     Doco; expand commands; quits
    //<< ; 19.08.1999    DT
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;WRITE YCR,YCR,"<!-- ************************* SUCHFUNKTION (WWWSMA)************************* -->",YCR,YCR
    //<< SET %("VAR","YBACK")=""
    m$.var("%","VAR","YBACK").set("");
    //<< SET %("VAR","YFORM")=YFORM
    m$.var("%","VAR","YFORM").set(m$.var("YFORM").get());
    //<< KILL ^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM)  ;TYBD;FEHLER IN ANZEIGE;10,3,2005
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get()).kill();
    //<< ;AUSWAHL EINGEBEN ;Selection key in
    //<< DO GETVAR  ;VORGABEWERTE HOLEN ;send for
    m$.Cmd.Do("GETVAR");
    //<< 
    //<< ;IF +$PIECE(YVOR,Y,13)=1 WRITE YCR,"<FIELDSET>"
    //<< SET YBBN=""
    mVar YBBN = m$.var("YBBN");
    YBBN.set("");
    //<< FOR  SET YBBN=$ORDER(^WWW002(0,YDATEI,YBBN)) QUIT:YBBN=""  DO  ;AUSWAHL DER AUZEIGEFELDER ;Selection the
    for (;true;) {
      YBBN.set(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),YBBN.get())));
      if (mOp.Equal(YBBN.get(),"")) {
        break;
      }
      do {
        //<< . QUIT:YBBN>1  ;NUR 1.KEY ;only
        if (mOp.Greater(YBBN.get(),1)) {
          break;
        }
        //<< . NEW YKEY,YFKEY
        mVar YKEY = m$.var("YKEY");
        mVar YFKEY = m$.var("YFKEY");
        m$.newVar(YKEY,YFKEY);
        //<< . SET YKEY="",YFKEY=""
        YKEY.set("");
        YFKEY.set("");
        //<< . SET YSATZ=YBBN
        mVar YSATZ = m$.var("YSATZ");
        YSATZ.set(YBBN.get());
        //<< . SET YLFN=YBBN
        mVar YLFN = m$.var("YLFN");
        YLFN.set(YBBN.get());
        //<< . SET YSSOR=0
        mVar YSSOR = m$.var("YSSOR");
        YSSOR.set(0);
        //<< . SET YSSOR(1)=+$PIECE(YSSOR,".",1)
        YSSOR.var(1).set(mOp.Positive(m$.Fnc.$piece(YSSOR.get(),".",1)));
        //<< . SET YSSOR(2)=+$PIECE(YSSOR,".",2)
        YSSOR.var(2).set(mOp.Positive(m$.Fnc.$piece(YSSOR.get(),".",2)));
        //<< . IF YSSOR(2)=0 SET YSSOR(2)=1
        if (mOp.Equal(YSSOR.var(2).get(),0)) {
          YSSOR.var(2).set(1);
        }
        //<< . IF $DATA(^WWW0021(0,YDATEI,YBBN,SPRACHE,1)) SET $PIECE(YSATZ,Y,12)=$PIECE(^WWW0021(0,YDATEI,YBBN,SPRACHE,1),Y,1)   ; Naked Ref
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0021",0,m$.var("YDATEI").get(),YBBN.get(),m$.var("SPRACHE").get(),1)))) {
          m$.pieceVar(YSATZ,m$.var("Y").get(),12).set(m$.Fnc.$piece(m$.var("^WWW0021",0,m$.var("YDATEI").get(),YBBN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . SET YOLDVAL=$GET(YSKEY0(YSSOR(1),YSSOR(2)))  ;SUCHVORGABE ORIGINAL
        mVar YOLDVAL = m$.var("YOLDVAL");
        YOLDVAL.set(m$.Fnc.$get(m$.var("YSKEY0").var(YSSOR.var(1).get(),YSSOR.var(2).get())));
        //<< . ;
        //<< . SET YFELD=""  ;VORGABE LÖSCHEN ;default Delete
        mVar YFELD = m$.var("YFELD");
        YFELD.set("");
        //<< . SET YART="P"  ;P=PRIMÄR,D=DATENFELD,M=MANUELLE,L=LISTGENERATOR
        mVar YART = m$.var("YART");
        YART.set("P");
        //<< . DO ^WWWFORM9
        m$.Cmd.Do("WWWFORM9.main");
      } while (false);
    }
    //<< 
    //<< SET YBBN=""
    YBBN.set("");
    //<< FOR  SET YBBN=$ORDER(^WWW003(0,YDATEI,YBBN)) QUIT:YBBN=""  DO  ;AUSWAHL DER AUZEIGEFELDER ;Selection the
    for (;true;) {
      YBBN.set(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),YBBN.get())));
      if (mOp.Equal(YBBN.get(),"")) {
        break;
      }
      do {
        //<< . SET YSATZ=YBBN
        mVar YSATZ = m$.var("YSATZ");
        YSATZ.set(YBBN.get());
        //<< . SET YLFN=YBBN
        mVar YLFN = m$.var("YLFN");
        YLFN.set(YBBN.get());
        //<< . SET YSSOR=$PIECE($PIECE($GET(^WWW003(0,YDATEI,YBBN,1)),Y,6),",",1)  ;SORTKEY
        mVar YSSOR = m$.var("YSSOR");
        YSSOR.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YBBN.get(),1)),m$.var("Y").get(),6),",",1));
        //<< . QUIT:YSSOR=""
        if (mOp.Equal(YSSOR.get(),"")) {
          break;
        }
        //<< . SET YSSOR(1)=+$PIECE(YSSOR,".",1)
        YSSOR.var(1).set(mOp.Positive(m$.Fnc.$piece(YSSOR.get(),".",1)));
        //<< . SET YSSOR(2)=+$PIECE(YSSOR,".",2)
        YSSOR.var(2).set(mOp.Positive(m$.Fnc.$piece(YSSOR.get(),".",2)));
        //<< . IF YSSOR(2)=0 SET YSSOR(2)=1
        if (mOp.Equal(YSSOR.var(2).get(),0)) {
          YSSOR.var(2).set(1);
        }
        //<< . QUIT:YSSOR(2)>1
        if (mOp.Greater(YSSOR.var(2).get(),1)) {
          break;
        }
        //<< . IF $DATA(^WWW0031(0,YDATEI,YBBN,SPRACHE,1)) SET $PIECE(YSATZ,Y,12)=$PIECE(^WWW0031(0,YDATEI,YBBN,SPRACHE,1),Y,1)   ; Naked Ref
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YBBN.get(),m$.var("SPRACHE").get(),1)))) {
          m$.pieceVar(YSATZ,m$.var("Y").get(),12).set(m$.Fnc.$piece(m$.var("^WWW0031",0,m$.var("YDATEI").get(),YBBN.get(),m$.var("SPRACHE").get(),1).get(),m$.var("Y").get(),1));
        }
        //<< . SET YOLDVAL=$GET(YSKEY0(YSSOR(1),YSSOR(2)))  ;SUCHVORGABE ORIGINAL
        mVar YOLDVAL = m$.var("YOLDVAL");
        YOLDVAL.set(m$.Fnc.$get(m$.var("YSKEY0").var(YSSOR.var(1).get(),YSSOR.var(2).get())));
        //<< . IF $PIECE($GET(^WWW003(0,YDATEI,YBBN,1)),Y,3)=1 SET YOLDVAL=$$^WWWDATE(YOLDVAL)  ;DATUMSFORMAT
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YBBN.get(),1)),m$.var("Y").get(),3),1)) {
          YOLDVAL.set(m$.fnc$("WWWDATE.main",YOLDVAL.get()));
        }
        //<< . IF $PIECE($GET(^WWW003(0,YDATEI,YBBN,1)),Y,3)=7 SET YOLDVAL=$$^WWWTIME(YOLDVAL)  ;TIMEFORMAT
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YBBN.get(),1)),m$.var("Y").get(),3),7)) {
          YOLDVAL.set(m$.fnc$("WWWTIME.main",YOLDVAL.get()));
        }
        //<< . SET YFELD=""  ;VORGABE LÖSCHEN ;default Delete
        mVar YFELD = m$.var("YFELD");
        YFELD.set("");
        //<< . SET YART="D"  ;P=PRIMÄR,D=DATENFELD,M=MANUELLE,L=LISTGENERATOR
        mVar YART = m$.var("YART");
        YART.set("D");
        //<< . IF $EXTRACT($PIECE($GET(^WWW003(0,YDATEI,YBBN,1)),Y,1),1,5)="_FREE" QUIT  ;KEINE _FREE ANZEIGEN;TYBD:27,07,2003;
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YBBN.get(),1)),m$.var("Y").get(),1),1,5),"_FREE")) {
          break;
        }
        //<< . DO ^WWWFORM9
        m$.Cmd.Do("WWWFORM9.main");
      } while (false);
    }
    //<< 
    //<< WRITE YCR,"</TR>",YCR  ;ABSCHLUSS FELD ;field
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>",m$.var("YCR").get());
    //<< IF $PIECE(YVOR,Y,44)'=1 WRITE YCR,"</TABLE>",YCR  ;ABSCHLUSS FORMAT
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>",m$.var("YCR").get());
    }
    //<< 
    //<< ;IF +$PIECE(YVOR,Y,13)=1 WRITE YCR,"</FIELDSET>"
    //<< QUIT
    return;
  }

  //<< 
  //<< SUCH ;EINSPRUNG FÜR SUCHE ;to search
  public void SUCH() {
    //<< SET YANZFORM=$PIECE($GET(^WWW120(0,YFORM,1)),Y,79)
    mVar YANZFORM = m$.var("YANZFORM");
    YANZFORM.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),79));
    //<< DO SEARCH   ;SUCHEN DER FELDER  ;seek the
    m$.Cmd.Do("SEARCH");
    //<< DO DISPLY   ;ANZEIGE DER FELDER ;Show the
    m$.Cmd.Do("DISPLY");
    //<< QUIT
    return;
  }

  //<< 
  //<< GETVAR ;VORGABEN SUCHEN  ;seek
  public void GETVAR() {
    //<< SET YTEST=""
    mVar YTEST = m$.var("YTEST");
    YTEST.set("");
    do {
      //<< 
      //<< DO  ;PRIMÄRSCHLÜSSEL
      //<< . SET YI=1,SKEY=0,YSKEY=0   ;ERSTER PRIMÄRSCHLÜSSEL SORTKEY=0 ;premier
      mVar YI = m$.var("YI");
      YI.set(1);
      mVar SKEY = m$.var("SKEY");
      SKEY.set(0);
      mVar YSKEY = m$.var("YSKEY");
      YSKEY.set(0);
      //<< . SET YA=$GET(%(YQUERY,"Y"_YFORM_"P"_YI)) IF YA'="" DO
      mVar YA = m$.var("YA");
      YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"P"),YI.get()))));
      if (mOp.NotEqual(YA.get(),"")) {
        do {
          //<< . . SET YTYP=$PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)
          mVar YTYP = m$.var("YTYP");
          YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),YI.get(),1)),m$.var("Y").get(),3));
          //<< . . SET YA=$TRANSLATE(YA,"+"_"""")
          YA.set(m$.Fnc.$translate(YA.get(),mOp.Concat("+","\"")));
          //<< . . SET YA=$$GetInternal^WWWTR(YTYP,YA)
          YA.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YA.get()));
          //<< . . IF $EXTRACT(YA)'="*" SET YA=$TRANSLATE(YA,"*")
          if (mOp.NotEqual(m$.Fnc.$extract(YA.get()),"*")) {
            YA.set(m$.Fnc.$translate(YA.get(),"*"));
          }
          //<< . . IF $EXTRACT(YA)="."  SET YA=$EXTRACT(YA,2,999)
          if (mOp.Equal(m$.Fnc.$extract(YA.get()),".")) {
            YA.set(m$.Fnc.$extract(YA.get(),2,999));
          }
          //<< . . QUIT:YA=""
          if (mOp.Equal(YA.get(),"")) {
            break;
          }
          //<< . . FOR YLFSK=1:1 SET YSSOR=$PIECE(YSKEY,",",YLFSK) QUIT:YSSOR=""  DO
          mVar YLFSK = m$.var("YLFSK");
          for (YLFSK.set(1);(true);YLFSK.set(mOp.Add(YLFSK.get(),1))) {
            mVar YSSOR = m$.var("YSSOR");
            YSSOR.set(m$.Fnc.$piece(YSKEY.get(),",",YLFSK.get()));
            if (mOp.Equal(YSSOR.get(),"")) {
              break;
            }
            //<< . . . IF $PIECE(YSSOR,".",2)="" SET $PIECE(YSSOR,".",2)=1
            if (mOp.Equal(m$.Fnc.$piece(YSSOR.get(),".",2),"")) {
              m$.pieceVar(YSSOR,".",2).set(1);
            }
            //<< . . . SET YSSOR(1)=+$PIECE(YSSOR,".",1)
            YSSOR.var(1).set(mOp.Positive(m$.Fnc.$piece(YSSOR.get(),".",1)));
            //<< . . . SET YSSOR(2)=+$PIECE(YSSOR,".",2)
            YSSOR.var(2).set(mOp.Positive(m$.Fnc.$piece(YSSOR.get(),".",2)));
            //<< . . . SET YSKEY(YSSOR(1),YSSOR(2))=$$^WWWUMLAU(YA,1)  ;SUCHVORGABE FÜR SORTSCHLÜSSEL ;to
            YSKEY.var(YSSOR.var(1).get(),YSSOR.var(2).get()).set(m$.fnc$("WWWUMLAU.main",YA.get(),1));
            //<< . . . SET YSKEY(YSSOR(1),YSSOR(2))=YA  ;SUCHVORGABE FÜR SORTSCHLÜSSEL ;to
            YSKEY.var(YSSOR.var(1).get(),YSSOR.var(2).get()).set(YA.get());
            //<< . . . ;SET $PIECE(YTEST,Y,999)=YSKEY(YSSOR(1),YSSOR(2))
            //<< . . . SET YSKEY0(YSSOR(1),YSSOR(2))=$TRANSLATE(YA,",")  ;SUCHVORGABE ORIGINAL
            mVar YSKEY0 = m$.var("YSKEY0");
            YSKEY0.var(YSSOR.var(1).get(),YSSOR.var(2).get()).set(m$.Fnc.$translate(YA.get(),","));
            //<< . . . SET YSKEY1(YSSOR(1),YSSOR(2))=YI  ;WELCHES DATENFELD ;who data item
            mVar YSKEY1 = m$.var("YSKEY1");
            YSKEY1.var(YSSOR.var(1).get(),YSSOR.var(2).get()).set(YI.get());
            //<< . . . IF YTYP=3 IF $ORDER(^WWW002(0,YDATEI,YI))="" SET YSKEY0(YSSOR(1),YSSOR(2))="*"_YA  ;TEXT
            if (mOp.Equal(YTYP.get(),3)) {
              if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),YI.get())),"")) {
                YSKEY0.var(YSSOR.var(1).get(),YSSOR.var(2).get()).set(mOp.Concat("*",YA.get()));
              }
            }
            //<< . . . IF $FIND(YA,"C:") SET YSKEY(YSSOR(1),YSSOR(2))=$TRANSLATE(YA,$CHAR(214)_"'","/"_"""")  ;DATEI ;data file
            if (mOp.Logical(m$.Fnc.$find(YA.get(),"C:"))) {
              YSKEY.var(YSSOR.var(1).get(),YSSOR.var(2).get()).set(m$.Fnc.$translate(YA.get(),mOp.Concat(m$.Fnc.$char(214),"'"),mOp.Concat("/","\"")));
            }
          }
        } while (false);
      }
    } while(false);
    //<< 
    //<< ;DATENFELDER
    //<< SET YI=""
    mVar YI = m$.var("YI");
    YI.set("");
    //<< FOR  SET YI=$ORDER(^WWW003(0,YDATEI,YI)) QUIT:YI=""  DO  ;DATENFELDER
    for (;true;) {
      YI.set(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),YI.get())));
      if (mOp.Equal(YI.get(),"")) {
        break;
      }
      do {
        //<< . SET YSKEY=$PIECE($GET(^WWW003(0,YDATEI,YI,1)),Y,6)
        mVar YSKEY = m$.var("YSKEY");
        YSKEY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YI.get(),1)),m$.var("Y").get(),6));
        //<< . QUIT:YSKEY=""
        if (mOp.Equal(YSKEY.get(),"")) {
          break;
        }
        //<< . SET YA=$GET(%(YQUERY,"Y"_YFORM_"D"_YI)) DO MULTD IF YA'="" DO
        mVar YA = m$.var("YA");
        YA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),"D"),YI.get()))));
        m$.Cmd.Do("MULTD");
        if (mOp.NotEqual(YA.get(),"")) {
          do {
            //<< . . SET YTYP=$PIECE($GET(^WWW003(0,YDATEI,YI,1)),Y,3)
            mVar YTYP = m$.var("YTYP");
            YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YI.get(),1)),m$.var("Y").get(),3));
            //<< . . SET YA=$$GetInternal^WWWTR(YTYP,YA)
            YA.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YA.get()));
            //<< . . IF $EXTRACT(YA)'="*" SET YA=$TRANSLATE(YA,"*")
            if (mOp.NotEqual(m$.Fnc.$extract(YA.get()),"*")) {
              YA.set(m$.Fnc.$translate(YA.get(),"*"));
            }
            //<< . . IF $EXTRACT(YA)="." SET YA=$EXTRACT(YA,2,999)
            if (mOp.Equal(m$.Fnc.$extract(YA.get()),".")) {
              YA.set(m$.Fnc.$extract(YA.get(),2,999));
            }
            //<< . . QUIT:YA=""
            if (mOp.Equal(YA.get(),"")) {
              break;
            }
            //<< . . FOR YLFSK=1:1 SET YSSOR=$PIECE(YSKEY,",",YLFSK) QUIT:YSSOR=""  DO
            mVar YLFSK = m$.var("YLFSK");
            for (YLFSK.set(1);(true);YLFSK.set(mOp.Add(YLFSK.get(),1))) {
              mVar YSSOR = m$.var("YSSOR");
              YSSOR.set(m$.Fnc.$piece(YSKEY.get(),",",YLFSK.get()));
              if (mOp.Equal(YSSOR.get(),"")) {
                break;
              }
              //<< . . . IF $PIECE(YSSOR,".",2)="" SET $PIECE(YSSOR,".",2)=1
              if (mOp.Equal(m$.Fnc.$piece(YSSOR.get(),".",2),"")) {
                m$.pieceVar(YSSOR,".",2).set(1);
              }
              //<< . . . SET YSSOR(1)=$PIECE(YSSOR,".",1)
              YSSOR.var(1).set(m$.Fnc.$piece(YSSOR.get(),".",1));
              //<< . . . SET YSSOR(2)=$PIECE(YSSOR,".",2)
              YSSOR.var(2).set(m$.Fnc.$piece(YSSOR.get(),".",2));
              //<< . . . SET YSKEY(YSSOR(1),YSSOR(2))=$$^WWWUMLAU(YA,1)  ;SUCHVORGABE FÜR SORTSCHLÜSSEL ;to
              YSKEY.var(YSSOR.var(1).get(),YSSOR.var(2).get()).set(m$.fnc$("WWWUMLAU.main",YA.get(),1));
              //<< . . . SET $PIECE(YTEST,Y,YI)=YSKEY(YSSOR(1),YSSOR(2))
              m$.pieceVar(YTEST,m$.var("Y").get(),YI.get()).set(YSKEY.var(YSSOR.var(1).get(),YSSOR.var(2).get()).get());
              //<< . . . SET YSKEY0(YSSOR(1),YSSOR(2))=$TRANSLATE(YA,",")  ;SUCHVORGABE ORIGINAL
              mVar YSKEY0 = m$.var("YSKEY0");
              YSKEY0.var(YSSOR.var(1).get(),YSSOR.var(2).get()).set(m$.Fnc.$translate(YA.get(),","));
              //<< . . . SET YSKEY1(YSSOR(1),YSSOR(2))=YI  ;WELCHES DATENFELD ;who data item
              mVar YSKEY1 = m$.var("YSKEY1");
              YSKEY1.var(YSSOR.var(1).get(),YSSOR.var(2).get()).set(YI.get());
              //<< . . . IF YTYP=3 IF $ORDER(^WWW003(0,YDATEI,YI))="" SET YSKEY0(YSSOR(1),YSSOR(2))="*"_YA  ;TEXT
              if (mOp.Equal(YTYP.get(),3)) {
                if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),YI.get())),"")) {
                  YSKEY0.var(YSSOR.var(1).get(),YSSOR.var(2).get()).set(mOp.Concat("*",YA.get()));
                }
              }
              //<< . . . IF $FIND(YA,"C:") SET YSKEY(YSSOR(1),YSSOR(2))=$TRANSLATE(YA,$CHAR(214)_"'","/"_"""")  ;DATEI ;data file
              if (mOp.Logical(m$.Fnc.$find(YA.get(),"C:"))) {
                YSKEY.var(YSSOR.var(1).get(),YSSOR.var(2).get()).set(m$.Fnc.$translate(YA.get(),mOp.Concat(m$.Fnc.$char(214),"'"),mOp.Concat("/","\"")));
              }
            }
          } while (false);
        }
      } while (false);
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< MULTD ;MULTIEINGABE DATENFELDER
  public void MULTD() {
    //<< NEW YII
    mVar YII = m$.var("YII");
    m$.newVar(YII);
    //<< 
    //<< SET YII=""
    YII.set("");
    //<< FOR  SET YII=$ORDER(%(YQUERY,"YD"_YI,YII)) QUIT:YII=""  DO
    for (;true;) {
      YII.set(m$.Fnc.$order(m$.var("%",m$.var("YQUERY").get(),mOp.Concat("YD",m$.var("YI").get()),YII.get())));
      if (mOp.Equal(YII.get(),"")) {
        break;
      }
      //<< . IF $GET(%(YQUERY,"YD"_YI,YII))'="" SET:YA'="" YA=YA_";" SET YA=YA_$GET(%(YQUERY,"YD"_YI,YII))
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat("YD",m$.var("YI").get()),YII.get())),"")) {
        if (mOp.NotEqual(m$.var("YA").get(),"")) {
          m$.var("YA").set(mOp.Concat(m$.var("YA").get(),";"));
        }
        mVar YA = m$.var("YA");
        YA.set(mOp.Concat(m$.var("YA").get(),m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),mOp.Concat("YD",m$.var("YI").get()),YII.get()))));
      }
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< SEARCH ;SUCHEN DER DATEN ;seek the
  public void SEARCH() {
    //<< SET YSUCH1=""
    mVar YSUCH1 = m$.var("YSUCH1");
    YSUCH1.set("");
    //<< IF YFORM'="" SET YSUCH1=$GET(^WWW123(0,YFORM,1,1))
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      YSUCH1.set(m$.Fnc.$get(m$.var("^WWW123",0,m$.var("YFORM").get(),1,1)));
    }
    //<< 
    //<< ;SUCHEN BESTE AUSWAHL 1.LAENGE AUSWERTEN NUR  ;seek best Selection only
    //<< SET YFIND=""
    mVar YFIND = m$.var("YFIND");
    YFIND.set("");
    //<< SET YSORT1=""
    mVar YSORT1 = m$.var("YSORT1");
    YSORT1.set("");
    //<< FOR  SET YSORT1=$ORDER(YSKEY0(YSORT1)) QUIT:YSORT1=""  DO
    for (;true;) {
      YSORT1.set(m$.Fnc.$order(m$.var("YSKEY0").var(YSORT1.get())));
      if (mOp.Equal(YSORT1.get(),"")) {
        break;
      }
      do {
        //<< . SET YFIND(YSORT1)=""
        YFIND.var(YSORT1.get()).set("");
        //<< . QUIT:$GET(YSKEY0(YSORT1,1))=""
        if (mOp.Equal(m$.Fnc.$get(m$.var("YSKEY0").var(YSORT1.get(),1)),"")) {
          break;
        }
        //<< . QUIT:$EXTRACT($GET(YSKEY0(YSORT1,1)))="*"  ;kein * volltext ;not
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(m$.var("YSKEY0").var(YSORT1.get(),1))),"*")) {
          break;
        }
        //<< . SET YSORT2="" FOR  SET YSORT2=$ORDER(YSKEY0(YSORT1,YSORT2)) QUIT:YSORT2=""  DO
        mVar YSORT2 = m$.var("YSORT2");
        YSORT2.set("");
        for (;true;) {
          YSORT2.set(m$.Fnc.$order(m$.var("YSKEY0").var(YSORT1.get(),YSORT2.get())));
          if (mOp.Equal(YSORT2.get(),"")) {
            break;
          }
          //<< . . SET YFIND(YSORT1)=YFIND(YSORT1)_$GET(YSKEY0(YSORT1,YSORT2))_","
          YFIND.var(YSORT1.get()).set(mOp.Concat(mOp.Concat(YFIND.var(YSORT1.get()).get(),m$.Fnc.$get(m$.var("YSKEY0").var(YSORT1.get(),YSORT2.get()))),","));
        }
      } while (false);
    }
    //<< . . ;I $E(YFIND(YSORT1))="." S YFIND(YSORT1)=$E(YFIND(YSORT1),2,999)    ;TYBD;30,10,2003
    //<< 
    //<< SET YSORT=""
    mVar YSORT = m$.var("YSORT");
    YSORT.set("");
    //<< FOR  SET YSORT=$ORDER(YFIND(YSORT)) QUIT:YSORT=""  DO
    for (;true;) {
      YSORT.set(m$.Fnc.$order(YFIND.var(YSORT.get())));
      if (mOp.Equal(YSORT.get(),"")) {
        break;
      }
      //<< . IF $LENGTH(YFIND(YSORT))>$LENGTH(YFIND) SET YFIND=YFIND(YSORT) SET YSORT1=YSORT
      if (mOp.Greater(m$.Fnc.$length(YFIND.var(YSORT.get()).get()),m$.Fnc.$length(YFIND.get()))) {
        YFIND.set(YFIND.var(YSORT.get()).get());
        YSORT1.set(YSORT.get());
      }
    }
    //<< 
    //<< ;suche nach VOLLTEXT SUCHE ;within full text search
    //<< IF YFIND="" DO
    if (mOp.Equal(YFIND.get(),"")) {
      //<< . SET YSORT1=""
      YSORT1.set("");
      //<< . FOR  SET YSORT1=$ORDER(YSKEY0(YSORT1)) QUIT:YSORT1=""  DO
      for (;true;) {
        YSORT1.set(m$.Fnc.$order(m$.var("YSKEY0").var(YSORT1.get())));
        if (mOp.Equal(YSORT1.get(),"")) {
          break;
        }
        do {
          //<< . . SET YFIND(YSORT1)=""
          YFIND.var(YSORT1.get()).set("");
          //<< . . QUIT:$GET(YSKEY0(YSORT1,1))=""
          if (mOp.Equal(m$.Fnc.$get(m$.var("YSKEY0").var(YSORT1.get(),1)),"")) {
            break;
          }
          //<< . . QUIT:$EXTRACT($GET(YSKEY0(YSORT1,1)))'="*"
          if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$get(m$.var("YSKEY0").var(YSORT1.get(),1))),"*")) {
            break;
          }
          //<< . . SET YSORT2=""
          mVar YSORT2 = m$.var("YSORT2");
          YSORT2.set("");
          //<< . . FOR  SET YSORT2=$ORDER(YSKEY0(YSORT1,YSORT2)) QUIT:YSORT2=""  DO
          for (;true;) {
            YSORT2.set(m$.Fnc.$order(m$.var("YSKEY0").var(YSORT1.get(),YSORT2.get())));
            if (mOp.Equal(YSORT2.get(),"")) {
              break;
            }
            //<< . . . SET YFIND(YSORT1)=YFIND(YSORT1)_$GET(YSKEY0(YSORT1,YSORT2))_","
            YFIND.var(YSORT1.get()).set(mOp.Concat(mOp.Concat(YFIND.var(YSORT1.get()).get(),m$.Fnc.$get(m$.var("YSKEY0").var(YSORT1.get(),YSORT2.get()))),","));
          }
        } while (false);
      }
      //<< . ;
      //<< . SET YSORT=""
      YSORT.set("");
      //<< . FOR  SET YSORT=$ORDER(YFIND(YSORT)) QUIT:YSORT=""  DO
      for (;true;) {
        YSORT.set(m$.Fnc.$order(YFIND.var(YSORT.get())));
        if (mOp.Equal(YSORT.get(),"")) {
          break;
        }
        //<< . . IF $LENGTH(YFIND(YSORT))>$LENGTH(YFIND) SET YFIND=YFIND(YSORT) SET YSORT1=YSORT
        if (mOp.Greater(m$.Fnc.$length(YFIND.var(YSORT.get()).get()),m$.Fnc.$length(YFIND.get()))) {
          YFIND.set(YFIND.var(YSORT.get()).get());
          YSORT1.set(YSORT.get());
        }
      }
    }
    //<< 
    //<< ;3.suche nach key ;within
    //<< IF $GET(YSKEY0(0,1))'="" SET YSORT=0,YSORT1=0 SET YFIND=YFIND(YSORT) ;NACH PRIMÄRSCHLÜSSEL ;within
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YSKEY0").var(0,1)),"")) {
      YSORT.set(0);
      YSORT1.set(0);
      YFIND.set(YFIND.var(YSORT.get()).get());
    }
    //<< 
    //<< FOR  QUIT:$EXTRACT(YFIND,$LENGTH(YFIND))'=","  DO
    for (;true;) {
      if (mOp.NotEqual(m$.Fnc.$extract(YFIND.get(),m$.Fnc.$length(YFIND.get())),",")) {
        break;
      }
      //<< . SET YFIND=$EXTRACT(YFIND,1,$LENGTH(YFIND)-1)
      YFIND.set(m$.Fnc.$extract(YFIND.get(),1,mOp.Subtract(m$.Fnc.$length(YFIND.get()),1)));
    }
    //<< . ;I $E(YFIND)="." S YFIND=$E(YFIND,2,999)    ;TYBD;30,10,2003
    do {
      //<< 
      //<< DO
      //<< . WRITE "<B>"
      m$.Cmd.Write("<B>");
      //<< . WRITE "&nbsp;",$$^WWWTEXT(148)_": "   ;SUCHE:
      m$.Cmd.Write("&nbsp;",mOp.Concat(m$.fnc$("WWWTEXT.main",148),": "));
      //<< . DO
      do {
        //<< . . IF $LENGTH(YFIND)=5 IF YFIND<63000 IF YFIND>59000 WRITE $$^WWWDATE(YFIND) QUIT
        if (mOp.Equal(m$.Fnc.$length(YFIND.get()),5)) {
          if (mOp.Less(YFIND.get(),63000)) {
            if (mOp.Greater(YFIND.get(),59000)) {
              m$.Cmd.Write(m$.fnc$("WWWDATE.main",YFIND.get()));
              break;
            }
          }
        }
        //<< . . WRITE YFIND   ;ANZEIGE NACH WASGESUCHT WIRD ;Show within
        m$.Cmd.Write(YFIND.get());
      } while(false);
      //<< . ;
      //<< . WRITE "</B>"
      m$.Cmd.Write("</B>");
    } while(false);
    //<< 
    //<< QUIT:YFIND=""
    if (mOp.Equal(YFIND.get(),"")) {
      return;
    }
    //<< 
    //<< ;S YSUCH1="FORMULAR;DATEI;SORTKEY;VORGABEKEY|VORGABEDATEN;ANZEIGE KEY;ANZEIGEFELD;STD SORT;ANZEIGE ERGEBNIS;ORIENTIERUNG;ANZAHL ANZEIGEN;FIXKEY;FELDER MIT SUMMENBILDUNG;WELCHEN KEY UEBERGEBEN;
    //<< IF YFORM'="" SET YSUCH1=$GET(^WWW123(0,YFORM,1,1))
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      YSUCH1.set(m$.Fnc.$get(m$.var("^WWW123",0,m$.var("YFORM").get(),1,1)));
    }
    //<< IF YSUCH1="" SET YSUCH1=YFORM_Y_YDATEI_Y_YSORT1_Y_YFIND
    if (mOp.Equal(YSUCH1.get(),"")) {
      YSUCH1.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YFORM").get(),m$.var("Y").get()),m$.var("YDATEI").get()),m$.var("Y").get()),YSORT1.get()),m$.var("Y").get()),YFIND.get()));
    }
    //<< 
    //<< IF $PIECE(YSUCH1,Y,1)="" SET $PIECE(YSUCH1,Y,1)=YFORM
    if (mOp.Equal(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),1),"")) {
      m$.pieceVar(YSUCH1,m$.var("Y").get(),1).set(m$.var("YFORM").get());
    }
    //<< IF $PIECE(YSUCH1,Y,2)="" SET $PIECE(YSUCH1,Y,2)=YDATEI
    if (mOp.Equal(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),2),"")) {
      m$.pieceVar(YSUCH1,m$.var("Y").get(),2).set(m$.var("YDATEI").get());
    }
    //<< IF $PIECE(YSUCH1,Y,3)="" SET $PIECE(YSUCH1,Y,3)=YSORT1
    if (mOp.Equal(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),3),"")) {
      m$.pieceVar(YSUCH1,m$.var("Y").get(),3).set(YSORT1.get());
    }
    //<< IF $PIECE(YSUCH1,Y,4)="" SET $PIECE(YSUCH1,Y,4)=YFIND
    if (mOp.Equal(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4),"")) {
      m$.pieceVar(YSUCH1,m$.var("Y").get(),4).set(YFIND.get());
    }
    //<< 
    //<< NEW YDATEI,YAUSW,YRICHT,YSORT,YANZ,YKOMP,YFIND,YFORM,YFOART,YFKEY
    mVar YDATEI = m$.var("YDATEI");
    mVar YAUSW = m$.var("YAUSW");
    mVar YRICHT = m$.var("YRICHT");
    mVar YANZ = m$.var("YANZ");
    mVar YKOMP = m$.var("YKOMP");
    mVar YFORM = m$.var("YFORM");
    mVar YFOART = m$.var("YFOART");
    mVar YFKEY = m$.var("YFKEY");
    m$.newVar(YDATEI,YAUSW,YRICHT,YSORT,YANZ,YKOMP,YFIND,YFORM,YFOART,YFKEY);
    //<< 
    //<< SET YFOART=1
    YFOART.set(1);
    //<< SET YDATEI=$PIECE(YSUCH1,Y,2)
    YDATEI.set(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),2));
    //<< SET YSORT=$PIECE(YSUCH1,Y,3)
    YSORT.set(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),3));
    //<< SET YRICHT=+$PIECE(YSUCH1,Y,9)
    YRICHT.set(mOp.Positive(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),9)));
    //<< SET YAUSW=$PIECE($PIECE(YSUCH1,Y,4),"|",1)
    YAUSW.set(m$.Fnc.$piece(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4),"|",1));
    //<< SET YANZ=$PIECE(YSUCH1,Y,10)
    YANZ.set(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),10));
    //<< SET YFKEY=$PIECE(YSUCH1,Y,11)
    YFKEY.set(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),11));
    //<< IF +YANZ=0 SET YANZ=1000
    if (mOp.Equal(mOp.Positive(YANZ.get()),0)) {
      YANZ.set(1000);
    }
    //<< 
    //<< KILL ^WWWSOR(YUSER,"SEL")
    m$.var("^WWWSOR",m$.var("YUSER").get(),"SEL").kill();
    //<< KILL ^WWWSOR(YUSER,"KEY")
    m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY").kill();
    //<< 
    //<< IF $FIND(YAUSW,";") DO  ;WENN ;
    if (mOp.Logical(m$.Fnc.$find(YAUSW.get(),";"))) {
      //<< . NEW YAUSW1
      mVar YAUSW1 = m$.var("YAUSW1");
      m$.newVar(YAUSW1);
      //<< . SET YAUSW1=YAUSW
      YAUSW1.set(YAUSW.get());
      //<< . FOR YAUSW1(1)=1:1 QUIT:$PIECE(YAUSW1,";",YAUSW1(1),99)=""  SET YAUSW=$PIECE(YAUSW1,";",YAUSW1(1)) DO
      for (m$.var("YAUSW1",1).set(1);(true);m$.var("YAUSW1",1).set(mOp.Add(m$.var("YAUSW1",1).get(),1))) {
        if (mOp.Equal(m$.Fnc.$piece(YAUSW1.get(),";",YAUSW1.var(1).get(),99),"")) {
          break;
        }
        YAUSW.set(m$.Fnc.$piece(YAUSW1.get(),";",YAUSW1.var(1).get()));
        //<< . . IF YAUSW'="" DO ^WWWSMA1
        if (mOp.NotEqual(YAUSW.get(),"")) {
          m$.Cmd.Do("WWWSMA1.main");
        }
      }
    }
    //<< 
    //<< IF '$FIND(YAUSW,";") DO ^WWWSMA1
    if (mOp.Not(m$.Fnc.$find(YAUSW.get(),";"))) {
      m$.Cmd.Do("WWWSMA1.main");
    }
    //<< 
    //<< IF +$GET(YMAL)'=0 WRITE $$^WWWTEXT(31625)_":"_$GET(YMAL)    ; Anzahl Einträge:  ;Number
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("YMAL"))),0)) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",31625),":"),m$.Fnc.$get(m$.var("YMAL"))));
    }
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< DISPLY ;ANZEIGEN SUCHERGEBNISE ;display
  public void DISPLY() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Mar-2008   GM      BR014910: Make appear the table
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< NEW YFORM,YI,YQ
    mVar YFORM = m$.var("YFORM");
    mVar YI = m$.var("YI");
    mVar YQ = m$.var("YQ");
    m$.newVar(YFORM,YI,YQ);
    //<< 
    //<< IF $PIECE(YVOR,Y,44)>0 WRITE YCR,"<TR><TD>"
    if (mOp.Greater(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),0)) {
      m$.Cmd.Write(m$.var("YCR").get(),"<TR><TD>");
    }
    //<< SET YQ=0
    YQ.set(0);
    //<< SET YFORM=$GET(YANZFORM)
    YFORM.set(m$.Fnc.$get(m$.var("YANZFORM")));
    //<< IF YFORM'="" SET YQ=1
    if (mOp.NotEqual(YFORM.get(),"")) {
      YQ.set(1);
    }
    //<< IF YFORM=""  SET YFORM=YDATEI
    if (mOp.Equal(YFORM.get(),"")) {
      YFORM.set(m$.var("YDATEI").get());
    }
    //<< 
    //<< ; FIXME : <GRF> YI will be undefined if YANZFORM is null
    //<< ; FIXED : <GM>
    //<< ;IF YQ=0 SET YI=""  ;BR014910
    //<< SET YI=""           ;BR014910
    YI.set("");
    //<< FOR  SET YI=$ORDER(^WWW120s(0,1,YDATEI,YI)) QUIT:YI=""  DO  QUIT:YQ=1
    for (;true;) {
      YI.set(m$.Fnc.$order(m$.var("^WWW120s",0,1,m$.var("YDATEI").get(),YI.get())));
      if (mOp.Equal(YI.get(),"")) {
        break;
      }
      do {
        //<< . IF $PIECE($GET(^WWW120(0,YI,1)),Y,2)'=1 IF $PIECE($GET(^WWW120(0,YI,1)),Y,2)'=3 QUIT
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YI.get(),1)),m$.var("Y").get(),2),1)) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YI.get(),1)),m$.var("Y").get(),2),3)) {
            break;
          }
        }
        //<< . SET YFORM=YI
        YFORM.set(YI.get());
        //<< . SET YQ=1
        YQ.set(1);
      } while (false);
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
    }
    //<< 
    //<< DO ^WWWFRAME(0)
    m$.Cmd.Do("WWWFRAME.main",0);
    //<< 
    //<< NEW YBACK
    mVar YBACK = m$.var("YBACK");
    m$.newVar(YBACK);
    //<< SET YBACK=$GET(%(YQUERY,"YFORM"))_","
    YBACK.set(mOp.Concat(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YFORM")),","));
    //<< ;S YBACK=$G(%("VAR","YFORM"))_","
    //<< SET YNOSORT=1  ;KEIN UNTERSORT ;no
    mVar YNOSORT = m$.var("YNOSORT");
    YNOSORT.set(1);
    //<< DO ^WWWSEAR3
    m$.Cmd.Do("WWWSEAR3.main");
    //<< 
    //<< IF $PIECE(YVOR,Y,44)>0 WRITE YCR,"</TD></TR>"
    if (mOp.Greater(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),0)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR>");
    }
    //<< DO ^WWWFRAME(1)
    m$.Cmd.Do("WWWFRAME.main",1);
    //<< QUIT
    return;
  }

//<< 
//<< 
}
