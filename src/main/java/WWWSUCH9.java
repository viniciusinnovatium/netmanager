//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSUCH9
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:52
//*****************************************************************************

import mLibrary.*;


//<< WWWSUCH9
public class WWWSUCH9 extends mClass {

  public void main() {
    _WWWSUCH9();
  }

  public void _WWWSUCH9() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SUCHE ANZEIGEN NACH DATENFELDERN
    //<< ;
    //<< ; Search Function for Data Field
    //<< ;   D4      $$$WWW1203DDataFieldSearchFunction()   over-rides
    //<< ;   D4      $$$WWW1203DataFieldSearchFunction()    which then over-rides
    //<< ;   D58     $$$WWW120DataFieldSearchFunction()     which may be cleared if user is not authorised
    //<< ;   D24     $$$WWW123ExecuteBeforeTableDisplay      (no macro)
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;   YFORM
    //<< ;   YVOR        objWWW120 - Form specification
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 28-Sep-2007   GRF     Doco
    //<< ; 03-May-2007   GRF     SR15509: Doco; brace format
    //<< ; 27.10.1998            Created
    //<< ;-------------------------------------------------------------------------------
    //<< SET YALTALT=YFORM
    mVar YALTALT = m$.var("YALTALT");
    YALTALT.set(m$.var("YFORM").get());
    //<< NEW YFORM,YA,I,YDATEI,YZWFORM,YBACK,YALTFORM,%YSUCH1,%I,YQ,Q
    mVar YFORM = m$.var("YFORM");
    mVar YA = m$.var("YA");
    mVar I = m$.var("I");
    mVar YDATEI = m$.var("YDATEI");
    mVar YZWFORM = m$.var("YZWFORM");
    mVar YBACK = m$.var("YBACK");
    mVar YALTFORM = m$.var("YALTFORM");
    mVar YQ = m$.var("YQ");
    mVar Q = m$.var("Q");
    m$.newVar(YFORM,YA,I,YDATEI,YZWFORM,YBACK,YALTFORM,YQ,Q);
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   YSUCH1      objWWW123
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< KILL ^WWWSOR(YUSER)
    m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
    //<< ;IF YBEDBER=1 WRITE YCY,YCR"<!-- ************************* ANZEIGEFUNKTION (WWWSUCH9)************************* -->",YCY,YCR
    //<< 
    //<< ;YSUCH1="FORMULAR;DATEI;SORTKEY;VORGABEKEY|VORGABEDATEN;ANZEIGE KEY;ANZEIGEFELD;STD SORT;ANZEIGE ERGEBNIS;ORIENTIERUNG;ANZAHL ANZEIGEN;FIXKEY;FELDER MIT SUMMENBILDUNG;WELCHEN KEY UEBERGEBEN;
    //<< ;S YKEY=$GET(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"P",1))
    //<< SET YFORM=$PIECE(YVOR,Y,58)  ;FORMULAR AUSWÄHLEN  ;form pick out
    YFORM.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),58));
    //<< 
    //<< ;Rücksprung bearbeiten
    //<< SET YZWFORM=$GET(%(YQUERY,"YBACK"))
    YZWFORM.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YBACK")));
    //<< SET YALTFORM=YZWFORM
    YALTFORM.set(YZWFORM.get());
    //<< IF $TRANSLATE(YZWFORM,",")="" SET YZWFORM=YALTALT
    if (mOp.Equal(m$.Fnc.$translate(YZWFORM.get(),","),"")) {
      YZWFORM.set(YALTALT.get());
    }
    //<< IF YZWFORM'="" IF $EXTRACT(YZWFORM,$LENGTH(YZWFORM))'="," SET YZWFORM=YZWFORM_","
    if (mOp.NotEqual(YZWFORM.get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$extract(YZWFORM.get(),m$.Fnc.$length(YZWFORM.get())),",")) {
        YZWFORM.set(mOp.Concat(YZWFORM.get(),","));
      }
    }
    //<< IF YALTALT'=YFORM SET YZWFORM=YZWFORM_YALTALT_","   ;YBACK
    if (mOp.NotEqual(YALTALT.get(),YFORM.get())) {
      YZWFORM.set(mOp.Concat(mOp.Concat(YZWFORM.get(),YALTALT.get()),","));
    }
    //<< 
    //<< SET YBACK=YZWFORM
    YBACK.set(YZWFORM.get());
    //<< SET %(YQUERY,"YBACK") = YZWFORM
    m$.var("%",m$.var("YQUERY").get(),"YBACK").set(YZWFORM.get());
    //<< SET %("VAR","YBACK")  = YZWFORM
    m$.var("%","VAR","YBACK").set(YZWFORM.get());
    //<< 
    //<< SET YSUCH1=""
    mVar YSUCH1 = m$.var("YSUCH1");
    YSUCH1.set("");
    //<< SET YDATEI=""
    YDATEI.set("");
    //<< IF YFORM'="" {               ; SR15509
    if (mOp.NotEqual(YFORM.get(),"")) {
      //<< SET YDATEI=$PIECE($GET(^WWW120(0,YFORM,1)),Y,11)
      YDATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),11));
      //<< SET YSUCH1=$GET(^WWW123(0,YFORM,1,1))
      YSUCH1.set(m$.Fnc.$get(m$.var("^WWW123",0,YFORM.get(),1,1)));
    }
    //<< }
    //<< IF YDATEI="" SET YDATEI=$PIECE(YSUCH1,Y,2)
    if (mOp.Equal(YDATEI.get(),"")) {
      YDATEI.set(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),2));
    }
    //<< 
    //<< SET $PIECE(YSUCH1,Y,1)=YFORM
    m$.pieceVar(YSUCH1,m$.var("Y").get(),1).set(YFORM.get());
    //<< IF $PIECE(YSUCH1,Y,2)="" SET $PIECE(YSUCH1,Y,2)=YDATEI
    if (mOp.Equal(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),2),"")) {
      m$.pieceVar(YSUCH1,m$.var("Y").get(),2).set(YDATEI.get());
    }
    //<< SET %YSUCH1=YSUCH1
    m$.var("%YSUCH1").set(YSUCH1.get());
    //<< 
    //<< ;EXECUTE VOR AUSFÜHRUNG DER LISTE
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  Execute Before Table Display                *** EXECUTE ? ***
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< SET Q=""
    Q.set("");
    //<< SET YQ=""
    YQ.set("");
    //<< IF $PIECE(YSUCH1,Y,24)'="" XECUTE $PIECE(YSUCH1,Y,24)
    if (mOp.NotEqual(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),24),"")) {
      m$.Cmd.Xecute(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),24));
    }
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< IF (Q=1)||(YQ=1) QUIT                        ; *** EARLY EXIT ***
    if ((mOp.Equal(Q.get(),1)) || (mOp.Equal(YQ.get(),1))) {
      return;
    }
    //<< 
    //<< KILL Q
    Q.kill();
    //<< KILL YQ
    YQ.kill();
    //<< 
    //<< QUIT:$PIECE(YSUCH1,Y,2)=""                   ;no data file   ; *** EARLY EXIT ***
    if (mOp.Equal(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),2),"")) {
      return;
    }
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< IF YKEY="" NEW YKEY SET YKEY="+,+,+,+,+"
    if (mOp.Equal(m$.var("YKEY").get(),"")) {
      mVar YKEY = m$.var("YKEY");
      m$.newVar(YKEY);
      YKEY.set("+,+,+,+,+");
    }
    //<< IF $PIECE(YSUCH1,Y,4)'="-" IF $DATA(^WWW002(0,$PIECE(YSUCH1,Y,2),2,1)) DO  QUIT:YKEY=""   ;WENN MEHRERE KEYS ;when divers
    if (mOp.NotEqual(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4),"-")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW002",0,m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),2),2,1)))) {
        //<< . SET $PIECE(YSUCH1,Y,4)=YKEY
        m$.pieceVar(YSUCH1,m$.var("Y").get(),4).set(m$.var("YKEY").get());
        //<< . SET $PIECE(YSUCH1,Y,11)=YKEY
        m$.pieceVar(YSUCH1,m$.var("Y").get(),11).set(m$.var("YKEY").get());
        if (mOp.Equal(m$.var("YKEY").get(),"")) {
          return;
        }
      }
    }
    //<< 
    //<< IF $PIECE(YKEY,",",2)'="" DO
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),",",2),"")) {
      //<< . ;IF YALTALT=YFORM DO  ;WENN GLEICHE FORM / SUCH UND ANZEIGE ;when same shape And Show
      //<< . IF YALTALT=YFORM IF $PIECE(YSUCH1,Y,4)'="-" DO  ;WENN GLEICHE FORM / SUCH UND ANZEIGE  ;FIS;14.05.04;NICHT WENN ALLE ANZEIGEN
      if (mOp.Equal(YALTALT.get(),YFORM.get())) {
        if (mOp.NotEqual(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4),"-")) {
          //<< . . NEW YKEYS,YI
          mVar YKEYS = m$.var("YKEYS");
          mVar YI = m$.var("YI");
          m$.newVarBlock(2,YKEYS,YI);
          //<< . . SET YKEYS=""
          YKEYS.set("");
          //<< . . FOR YI=1:1 QUIT:$PIECE($GET(^WWW121(0,YFORM,YI,1)),Y,16)=""  QUIT:$PIECE(YKEY,",",YI)=""  SET $PIECE(YKEYS,",",YI)=$PIECE(YKEY,",",YI)  ; S $PIECE(YKEY,",",1,$LENGTH(YKEY,",")-1)
          for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
            if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,YFORM.get(),YI.get(),1)),m$.var("Y").get(),16),"")) {
              break;
            }
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) {
              break;
            }
            m$.pieceVar(YKEYS,",",YI.get()).set(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()));
          }
          //<< . . SET $PIECE(YSUCH1,Y,4)=YKEYS
          m$.pieceVar(YSUCH1,m$.var("Y").get(),4).set(YKEYS.get());
        }
        m$.restoreVarBlock(2);
      }
      //<< . ;
      //<< . SET YMAXKEY=+$ORDER(^WWW002(0,YDATEI,""),-1)
      mVar YMAXKEY = m$.var("YMAXKEY");
      YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
      //<< . IF YMAXKEY=0 SET YMAXKEY=1
      if (mOp.Equal(YMAXKEY.get(),0)) {
        YMAXKEY.set(1);
      }
      //<< . IF YALTALT=YFORM SET $PIECE(YSUCH1,Y,11)=YFKEY IF YKEY'="" SET $PIECE(YSUCH1,Y,11)=$PIECE(YKEY,",",1,YMAXKEY-1)  ;WENN GLEICHE FORM / SUCH UND ANZEIGE ;when same shape And Show
      if (mOp.Equal(YALTALT.get(),YFORM.get())) {
        m$.pieceVar(YSUCH1,m$.var("Y").get(),11).set(m$.var("YFKEY").get());
        if (mOp.NotEqual(m$.var("YKEY").get(),"")) {
          m$.pieceVar(YSUCH1,m$.var("Y").get(),11).set(m$.Fnc.$piece(m$.var("YKEY").get(),",",1,mOp.Subtract(YMAXKEY.get(),1)));
        }
      }
    }
    //<< 
    //<< IF $PIECE(%YSUCH1,Y,4)'="" DO     ;WAC; SUCHE NACH VORGABE VON KEYS WELCHE BERÜCKSICHTIGT WERDEN SOLLEN, (IN DER SUCHFUNKTION UNTER PRIMÄRSCHLÜSSEL FIX)
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("%YSUCH1").get(),m$.var("Y").get(),4),"")) {
      do {
        //<< . QUIT:$PIECE(%YSUCH1,Y,4)="-"
        if (mOp.Equal(m$.Fnc.$piece(m$.var("%YSUCH1").get(),m$.var("Y").get(),4),"-")) {
          break;
        }
        //<< . NEW YKEY  ;TYBD; 19,09,2003
        mVar YKEY = m$.var("YKEY");
        m$.newVarBlock(1,YKEY);
        //<< . SET YKEY=$PIECE(YSUCH1,Y,4)
        YKEY.set(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4));
        //<< . SET $PIECE(YSUCH1,Y,4)=""   ;TYBD;19,09,2003;WENN NICHT GELÖSCHT DANN GGF FALSCH
        m$.pieceVar(YSUCH1,m$.var("Y").get(),4).set("");
        //<< . ;FOR %I=1:1:$LENGTH($PIECE(%YSUCH1,Y,4),",") IF $PIECE(YSUCH1,",",%I)'="" SET $PIECE(YSUCH1,Y,4)=$PIECE(YKEY,",",+$PIECE($PIECE(%YSUCH1,Y,4),",",%I))_","
        //<< . FOR %I=1:1:$LENGTH($PIECE(%YSUCH1,Y,4),",") IF $PIECE(YKEY,",",%I)'="" SET $PIECE(YSUCH1,Y,4)=$PIECE(YSUCH1,Y,4)_$PIECE(YKEY,",",+$PIECE($PIECE(%YSUCH1,Y,4),",",%I))_","  ;FIS;10.09.03
        for (m$.var("%I").set(1);(mOp.LessOrEqual(m$.var("%I").get(),m$.Fnc.$length(m$.Fnc.$piece(m$.var("%YSUCH1").get(),m$.var("Y").get(),4),",")));m$.var("%I").set(mOp.Add(m$.var("%I").get(),1))) {
          if (mOp.NotEqual(m$.Fnc.$piece(YKEY.get(),",",m$.var("%I").get()),"")) {
            m$.pieceVar(YSUCH1,m$.var("Y").get(),4).set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4),m$.Fnc.$piece(YKEY.get(),",",mOp.Positive(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("%YSUCH1").get(),m$.var("Y").get(),4),",",m$.var("%I").get())))),","));
          }
        }
        //<< . IF $EXTRACT($PIECE(YSUCH1,Y,4),$LENGTH($PIECE(YSUCH1,Y,4)))="," SET $PIECE(YSUCH1,Y,4)=$EXTRACT($PIECE(YSUCH1,Y,4),1,($LENGTH($PIECE(YSUCH1,Y,4))-1))
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4),m$.Fnc.$length(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4))),",")) {
          m$.pieceVar(YSUCH1,m$.var("Y").get(),4).set(m$.Fnc.$extract(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4),1,(mOp.Subtract(m$.Fnc.$length(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4)),1))));
        }
        //<< . SET $PIECE(YSUCH1,Y,11)=$PIECE(YSUCH1,Y,4)
        m$.pieceVar(YSUCH1,m$.var("Y").get(),11).set(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4));
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< IF $PIECE(YSUCH1,Y,4)="-" SET $PIECE(YSUCH1,Y,4)="",$PIECE(%YSUCH1,Y,4)="",$PIECE(YSUCH1,Y,11)=""  ;KEINE VORGABE ;no default
    if (mOp.Equal(m$.Fnc.$piece(YSUCH1.get(),m$.var("Y").get(),4),"-")) {
      m$.pieceVar(YSUCH1,m$.var("Y").get(),4).set("");
      m$.pieceVar(m$.var("%YSUCH1"),m$.var("Y").get(),4).set("");
      m$.pieceVar(YSUCH1,m$.var("Y").get(),11).set("");
    }
    //<< 
    //<< DO ^WWWSUCH1
    m$.Cmd.Do("WWWSUCH1.main");
    //<< 
    //<< SET %(YQUERY,"YBACK")=YALTFORM
    m$.var("%",m$.var("YQUERY").get(),"YBACK").set(YALTFORM.get());
    //<< SET %("VAR","YBACK") =YALTFORM
    m$.var("%","VAR","YBACK").set(YALTFORM.get());
    //<< SET YBACK=YALTFORM
    YBACK.set(YALTFORM.get());
    //<< 
    //<< QUIT
    return;
  }

//<< 
//<< 
}
