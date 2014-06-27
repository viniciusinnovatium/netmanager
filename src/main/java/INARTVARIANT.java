//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTVARIANT
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 20:27:19
//*****************************************************************************

import mLibrary.*;


//<< INARTVARIANT
public class INARTVARIANT extends mClass {

  public void main() {
    _INARTVARIANT();
  }

  public void _INARTVARIANT() {
    do {
      //<< ;-------------------------------------------------------------------------------
      //<< ; Description of Function :
      //<< ;       BUTTON FÜR DIE AUSWAHL DER ARTIKELVARIANTEN
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
      //<< ; 03.06.2001    DT
      //<< ;-------------------------------------------------------------------------------
      //<< DO  ;ERSTELLEN DES BUTTONS
      //<< . IF $GET(YINHALT)="" QUIT
      if (mOp.Equal(m$.Fnc.$get(m$.var("YINHALT")),"")) {
        break;
      }
      //<< . QUIT:$GET(YHID)=1
      if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),1)) {
        break;
      }
      //<< . ;QUIT:$GET(YHID)=2 ;NUR LESEBERECHTIGUNG
      //<< . NEW ART1,YCHAR,ART2
      mVar ART1 = m$.var("ART1");
      mVar YCHAR = m$.var("YCHAR");
      mVar ART2 = m$.var("ART2");
      m$.newVarBlock(1,ART1,YCHAR,ART2);
      //<< . SET ART2 = $PIECE($TRANSLATE(YINHALT,",;-_?/+*#':<>","............."),".",1)
      ART2.set(m$.Fnc.$piece(m$.Fnc.$translate(m$.var("YINHALT").get(),",;-_?/+*#':<>","............."),".",1));
      //<< . QUIT:ART2=""
      if (mOp.Equal(ART2.get(),"")) {
        break;
      }
      //<< . ;
      //<< . SET ART1(1) = ""
      ART1.var(1).set("");
      //<< . SET YCHAR = "-"
      YCHAR.set("-");
      //<< . SET ART1 = $ORDER(^INART(YM,ART2_YCHAR)) IF $EXTRACT(ART1,1,$LENGTH(ART2))=ART2 IF $FIND(ART1,YCHAR) SET ART1(1) = ART1
      ART1.set(m$.Fnc.$order(m$.var("^INART",m$.var("YM").get(),mOp.Concat(ART2.get(),YCHAR.get()))));
      if (mOp.Equal(m$.Fnc.$extract(ART1.get(),1,m$.Fnc.$length(ART2.get())),ART2.get())) {
        if (mOp.Logical(m$.Fnc.$find(ART1.get(),YCHAR.get()))) {
          ART1.var(1).set(ART1.get());
        }
      }
      //<< . SET YCHAR = "."
      YCHAR.set(".");
      //<< . SET ART1 = $ORDER(^INART(YM,ART2_YCHAR)) IF $EXTRACT(ART1,1,$LENGTH(ART2))=ART2 IF $FIND(ART1,YCHAR) SET ART1(1) = ART1
      ART1.set(m$.Fnc.$order(m$.var("^INART",m$.var("YM").get(),mOp.Concat(ART2.get(),YCHAR.get()))));
      if (mOp.Equal(m$.Fnc.$extract(ART1.get(),1,m$.Fnc.$length(ART2.get())),ART2.get())) {
        if (mOp.Logical(m$.Fnc.$find(ART1.get(),YCHAR.get()))) {
          ART1.var(1).set(ART1.get());
        }
      }
      //<< . IF ART1(1)="" QUIT  ;KEINE VARIANTEN ;no
      if (mOp.Equal(ART1.var(1).get(),"")) {
        break;
      }
      //<< . ;
      //<< . ;W "&nbsp;"
      //<< . WRITE YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . WRITE "<A HREF="_""""
      m$.Cmd.Write(mOp.Concat("<A HREF=","\""));
      //<< . SET URL=YAKTION_"EP=WWWMANU1&YEXEC=D|START^INARTVARIANT&YUSER="_YUSER_"&YBED="_YBED_"&YTRAKT="_YTRAKT_"&YUCI="_$GET(YUCI)_"&YM="_YM_"&YKEY="_ART2_"&YBACK="_YBACK_"&YLFDAT="_"Y"_YFORM_YART_YLFN_"&YLFFORM="_$GET(YBBN)_"&YFORM="_YFORM
      mVar URL = m$.var("URL");
      URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWMANU1&YEXEC=D|START^INARTVARIANT&YUSER="),m$.var("YUSER").get()),"&YBED="),m$.var("YBED").get()),"&YTRAKT="),m$.var("YTRAKT").get()),"&YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&YM="),m$.var("YM").get()),"&YKEY="),ART2.get()),"&YBACK="),m$.var("YBACK").get()),"&YLFDAT="),"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"&YLFFORM="),m$.Fnc.$get(m$.var("YBBN"))),"&YFORM="),m$.var("YFORM").get()));
      //<< . SET OPT="HEIGHT=500,WIDTH=400,SCROLLBARS=YES,RESIZEABLE=YES"
      mVar OPT = m$.var("OPT");
      OPT.set("HEIGHT=500,WIDTH=400,SCROLLBARS=YES,RESIZEABLE=YES");
      //<< . WRITE "javascript:var parameter=window.open('"_URL_"','Stucture','"_OPT_"');"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("javascript:var parameter=window.open('",URL.get()),"','Stucture','"),OPT.get()),"');"));
      //<< . WRITE """"
      m$.Cmd.Write("\"");
      //<< . WRITE ">"          ; "Display Item Variations"
      m$.Cmd.Write(">");
      //<< . WRITE YCR,"<IMG SRC="_""""_YGIF_"search1.gif"_""""_" ALIGN=ABSBOTTOM TITLE="_""""_$$^WWWTEXT(32530)_""""_" border=0>"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"search1.gif"),"\"")," ALIGN=ABSBOTTOM TITLE="),"\""),m$.fnc$("WWWTEXT.main",32530)),"\"")," border=0>"));
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< START ;AUSWERTEN VARIABELEN UND STARTEN WWWPARAM (ANZEIGE DATEN IN MENUFORM) ;And launching within
  public void START() {
    //<< NEW (%request,%session,%KEY,%,%ZCS,%CGIEVAR)
    //<< DO ^WWWVAR  ;VORGABEN SETZEN ;typeset
    m$.Cmd.Do("WWWVAR.main");
    //<< NEW ART,ART1
    mVar ART = m$.var("ART");
    mVar ART1 = m$.var("ART1");
    m$.newVar(ART,ART1);
    //<< 
    //<< SET ART = YKEY
    ART.set(m$.var("YKEY").get());
    //<< SET ART = $PIECE($TRANSLATE(ART,",;-_?/+*#':<>","............."),".",1)
    ART.set(m$.Fnc.$piece(m$.Fnc.$translate(ART.get(),",;-_?/+*#':<>","............."),".",1));
    //<< QUIT:ART=""
    if (mOp.Equal(ART.get(),"")) {
      return;
    }
    //<< 
    //<< LOCK +^INARTVARIANT(YM,ART):0 IF $TEST KILL ^INARTVARIANT(YM,ART)
    m$.Cmd.LockInc(m$.var("^INARTVARIANT",m$.var("YM").get(),ART.get()),0);
    if (mOp.Logical(m$.Fnc.$test())) {
      m$.var("^INARTVARIANT",m$.var("YM").get(),ART.get()).kill();
    }
    //<< 
    //<< IF '$DATA(^INARTVARIANT(YM,ART)) DO
    if (mOp.Not(m$.Fnc.$data(m$.var("^INARTVARIANT",m$.var("YM").get(),ART.get())))) {
      //<< . FOR ART1=ART_"-",ART_"." FOR  SET ART1=$ORDER(^INART(YM,ART1)) QUIT:ART1=""  QUIT:$EXTRACT(ART1,1,$LENGTH(ART))'=ART  DO
      for (Object _ART1: new Object[] {mOp.Concat(ART.get(),"-"),mOp.Concat(ART.get(),".")}) {
        ART1.set(_ART1);
        for (;true;) {
          ART1.set(m$.Fnc.$order(m$.var("^INART",m$.var("YM").get(),_ART1)));
          if (mOp.Equal(_ART1,"")) {
            break;
          }
          if (mOp.NotEqual(m$.Fnc.$extract(_ART1,1,m$.Fnc.$length(ART.get())),ART.get())) {
            break;
          }
          do {
            //<< . . IF '$FIND(ART1,".") IF '$FIND(ART1,"-") QUIT  ;KEIN TEIL ;no whack
            if (mOp.Not(m$.Fnc.$find(_ART1,"."))) {
              if (mOp.Not(m$.Fnc.$find(_ART1,"-"))) {
                break;
              }
            }
            //<< . . SET SORT("T") = $PIECE($GET(^INART(YM,ART1,1)),Y,1)
            mVar SORT = m$.var("SORT");
            SORT.var("T").set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),_ART1,1)),m$.var("Y").get(),1));
            //<< . . SET $PIECE(SORT("T"),Y,2) = ART1  ;ARTIKELNUMMER IN DATENSATZ FÜR ANZEIGE ;within data record to Show
            m$.pieceVar(SORT.var("T"),m$.var("Y").get(),2).set(_ART1);
            //<< . . SET SORT(9) = "^INARTVARIANT("_""""_YM_""""
            SORT.var(9).set(mOp.Concat(mOp.Concat(mOp.Concat("^INARTVARIANT(","\""),m$.var("YM").get()),"\""));
            //<< . . SET SORT(0) = $TRANSLATE(ART1,",;-_?/+*#':<>",".............")  ;ALLES PUNKT
            SORT.var(0).set(m$.Fnc.$translate(_ART1,",;-_?/+*#':<>","............."));
            //<< . . SET SORT(8) = SORT(9)
            SORT.var(8).set(SORT.var(9).get());
            //<< . . FOR SORT(1)=1:1 SET SORT(2) = $PIECE(SORT(0),".",SORT(1)) QUIT:SORT(2)=""  DO
            for (m$.var("SORT",1).set(1);(true);m$.var("SORT",1).set(mOp.Add(m$.var("SORT",1).get(),1))) {
              SORT.var(2).set(m$.Fnc.$piece(SORT.var(0).get(),".",SORT.var(1).get()));
              if (mOp.Equal(SORT.var(2).get(),"")) {
                break;
              }
              //<< . . . SET SORT(8) = SORT(8)_","_""""_SORT(2)_""""
              SORT.var(8).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(SORT.var(8).get(),","),"\""),SORT.var(2).get()),"\""));
            }
            //<< . . ;
            //<< . . SET SORT(8)  = SORT(8)_")"
            SORT.var(8).set(mOp.Concat(SORT.var(8).get(),")"));
            //<< . . SET @SORT(8) = SORT("T")
            m$.indirectVar(SORT.var(8).get()).set(SORT.var("T").get());
          } while (false);
        }
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; &FILE   = DATEI DIE ANGEZEIGT WIRD (STANDARD=WWWEXPLORE) ;who
    //<< ; &FIX    = FESTER ERSTER KEY (NUR WENN &FILE) ;premier KEY when
    //<< ; &RECORD = FELDER DIE ANGEZEIGT WERDEN SOLLEN (STANDARD=1) ;who will should
    //<< ; &OFFSET = STRUKTUR (WIRD GEBILDET)
    //<< ; &HEAD   = TEXT FÜR HEADER ;to
    //<< ; &YLFDAT = "_"Y"_YFORM_YART_YLFN_"&YLFORM="_$G(YBBN)
    //<< ;---------------------------------------
    //<< 
    //<< SET %(YQUERY,"TARGET") = $GET(YTARGET)  ;TARGET DER AUSGABE ;the expenses
    m$.var("%",m$.var("YQUERY").get(),"TARGET").set(m$.Fnc.$get(m$.var("YTARGET")));
    //<< SET %(YQUERY,"FILE")   = "INARTVARIANT"
    m$.var("%",m$.var("YQUERY").get(),"FILE").set("INARTVARIANT");
    //<< SET %(YQUERY,"FIX")    = YM_","_YKEY
    m$.var("%",m$.var("YQUERY").get(),"FIX").set(mOp.Concat(mOp.Concat(m$.var("YM").get(),","),m$.var("YKEY").get()));
    //<< SET %(YQUERY,"RECORD") = "1"  ;FELDER, DIE ANGEZEIGT WERDEN (1,2,3,4)
    m$.var("%",m$.var("YQUERY").get(),"RECORD").set("1");
    //<< SET %(YQUERY,"YUCI")   = $GET(YUCI)  ;NAMESPACE
    m$.var("%",m$.var("YQUERY").get(),"YUCI").set(m$.Fnc.$get(m$.var("YUCI")));
    //<< SET %(YQUERY,"HEAD")   = $$^WWWTEXT(32530)_" ("_YKEY_") "_$PIECE($GET(^INART(YM,YKEY,1)),Y,1)   ; "Display Item Variations"
    m$.var("%",m$.var("YQUERY").get(),"HEAD").set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",32530)," ("),m$.var("YKEY").get()),") "),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),m$.var("YKEY").get(),1)),m$.var("Y").get(),1)));
    //<< SET %(YQUERY,"YKEY")   = YKEY
    m$.var("%",m$.var("YQUERY").get(),"YKEY").set(m$.var("YKEY").get());
    //<< SET %(YQUERY,"YTRAKT") = YTRAKT
    m$.var("%",m$.var("YQUERY").get(),"YTRAKT").set(m$.var("YTRAKT").get());
    //<< SET %(YQUERY,"YBACK")  = YBACK
    m$.var("%",m$.var("YQUERY").get(),"YBACK").set(m$.var("YBACK").get());
    //<< SET %(YQUERY,"FORM")   = YFORM   ;ERFASSEN  ;Edit
    m$.var("%",m$.var("YQUERY").get(),"FORM").set(m$.var("YFORM").get());
    //<< SET %(YQUERY,"YFORM")  = YFORM   ;ERFASSEN BETRIEB ;Edit BETRIEB
    m$.var("%",m$.var("YQUERY").get(),"YFORM").set(m$.var("YFORM").get());
    //<< SET %(YQUERY,"OFFSET") = ""   ;ANZEIGE AB SUBSCRIPT ;Show Confirm.
    m$.var("%",m$.var("YQUERY").get(),"OFFSET").set("");
    //<< 
    //<< MERGE %KEY=%(YQUERY)
    m$.Cmd.Merge(m$.var("%KEY"),m$.var("%",m$.var("YQUERY").get()));
    //<< DO ^WWWPARAM
    m$.Cmd.Do("WWWPARAM.main");
    //<< QUIT
    return;
  }

//<< 
//<< 
}
