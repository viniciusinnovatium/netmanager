//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTPREIS
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 18:52:27
//*****************************************************************************

import mLibrary.*;


//<< INARTPREIS ;INARTPREIS;DT;ARTIKEL VKPREISE;11.10.2001
public class INARTPREIS extends mClass {

  public Object main() {
    _INARTPREIS();
    return null;
  }

  public Object _INARTPREIS() {
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      ARTIKEL VKPREISE
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
    //<< ;| DT   11.10.2001
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< QUIT:$GET(YFELD)=""  ;KEIN INHALT ;no purport
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFELD")),"")) {
      return null;
    }
    //<< QUIT:$PIECE($GET(^INVORG(YM,YM,1)),Y,68)'=1  ;KEIN PARAMETER ;no parameter
    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)),m$.var("Y").get(),68),1)) {
      return null;
    }
    //<< NEW MWST,PREIS,BETRAG
    mVar MWST = m$.var("MWST");
    mVar PREIS = m$.var("PREIS");
    mVar BETRAG = m$.var("BETRAG");
    m$.newVar(MWST,PREIS,BETRAG);
    //<< SET BETRAG=$$^WWWTR(1,12,YINHALT)
    BETRAG.set(m$.fnc$("WWWTR.main",1,12,m$.var("YINHALT").get()));
    //<< QUIT:+BETRAG=0  ;KEIN PREIS ;no prize
    if (mOp.Equal(mOp.Positive(BETRAG.get()),0)) {
      return null;
    }
    //<< SET MWST=$PIECE(YFELD,Y,36)  ;MWST KENNZEICHEN ;Tax characteristic
    MWST.set(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),36));
    //<< IF MWST="" SET MWST=1
    if (mOp.Equal(MWST.get(),"")) {
      MWST.set(1);
    }
    //<< QUIT:+MWST=0
    if (mOp.Equal(mOp.Positive(MWST.get()),0)) {
      return null;
    }
    //<< SET MWST=+$PIECE($GET(^WWW101(0,"MWST",SPRACHE,MWST,1)),Y,1)
    MWST.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",0,"MWST",m$.var("SPRACHE").get(),MWST.get(),1)),m$.var("Y").get(),1)));
    //<< IF $$EXIST^%R("COMTAX.OBJ",$GET(YUCI)) DO
    if (mOp.Logical(m$.fnc$("$R.EXIST","COMTAX.OBJ",m$.Fnc.$get(m$.var("YUCI"))))) {
      do {
        //<< . NEW RatesArray,TAXLOC,TAXST,TAXCO,TAXCI
        mVar RatesArray = m$.var("RatesArray");
        mVar TAXLOC = m$.var("TAXLOC");
        mVar TAXST = m$.var("TAXST");
        mVar TAXCO = m$.var("TAXCO");
        mVar TAXCI = m$.var("TAXCI");
        m$.newVarBlock(1,RatesArray,TAXLOC,TAXST,TAXCO,TAXCI);
        //<< . SET TAXLOC=""
        TAXLOC.set("");
        //<< . DO TaxRates^COMTAX(MWST,TAXLOC,+$HOROLOG,.RatesArray)      ;Bec;20.04.04;25158;shows the Tax, IF ROUTINE EXSIST.
        m$.Cmd.Do("COMTAX.TaxRates",MWST.get(),TAXLOC.get(),mOp.Positive(m$.Fnc.$horolog()),RatesArray);
        //<< . SET TAXST=$GET(RatesArray(1))
        TAXST.set(m$.Fnc.$get(RatesArray.var(1)));
        //<< . SET TAXCO=$GET(RatesArray(2))
        TAXCO.set(m$.Fnc.$get(RatesArray.var(2)));
        //<< . SET TAXCI=$GET(RatesArray(3))
        TAXCI.set(m$.Fnc.$get(RatesArray.var(3)));
        //<< . IF TAXST'="" SET MWST=$PIECE(TAXST,Y,1)                    ;state taxes
        if (mOp.NotEqual(TAXST.get(),"")) {
          MWST.set(m$.Fnc.$piece(TAXST.get(),m$.var("Y").get(),1));
        }
        //<< . IF TAXCO'="" SET MWST=MWST_"&nbsp;"_$PIECE(TAXCO,Y,1)      ;county taxes
        if (mOp.NotEqual(TAXCO.get(),"")) {
          MWST.set(mOp.Concat(mOp.Concat(MWST.get(),"&nbsp;"),m$.Fnc.$piece(TAXCO.get(),m$.var("Y").get(),1)));
        }
        //<< . IF TAXCI'="" SET MWST=MWST_"&nbsp;"_$PIECE(TAXCI,Y,1)      ;city taxes
        if (mOp.NotEqual(TAXCI.get(),"")) {
          MWST.set(mOp.Concat(mOp.Concat(MWST.get(),"&nbsp;"),m$.Fnc.$piece(TAXCI.get(),m$.var("Y").get(),1)));
        }
        //<< . QUIT
        break;
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< QUIT:+MWST=0
    if (mOp.Equal(mOp.Positive(MWST.get()),0)) {
      return null;
    }
    //<< SET MWST=$JUSTIFY(BETRAG/100*MWST,0,2)
    MWST.set(m$.Fnc.$justify(mOp.Multiply(mOp.Divide(BETRAG.get(),100),MWST.get()),0,2));
    //<< QUIT:(+BETRAG+MWST)=0
    if (mOp.Equal((mOp.Add(mOp.Positive(BETRAG.get()),MWST.get())),0)) {
      return null;
    }
    //<< WRITE "<FONT SIZE=1>"
    m$.Cmd.Write("<FONT SIZE=1>");
    //<< WRITE "&nbsp;"
    m$.Cmd.Write("&nbsp;");
    //<< WRITE "("
    m$.Cmd.Write("(");
    //<< WRITE $$^WWWZAHL(BETRAG+MWST,0,2)
    m$.Cmd.Write(m$.fnc$("WWWZAHL.main",mOp.Add(BETRAG.get(),MWST.get()),0,2));
    //<< WRITE ")"
    m$.Cmd.Write(")");
    //<< WRITE "</FONT>"
    m$.Cmd.Write("</FONT>");
    //<< WRITE "&nbsp;"
    m$.Cmd.Write("&nbsp;");
    //<< ;WRITE $$^WWWTEXT(32676)
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    return null;
  }

//<< 
}
