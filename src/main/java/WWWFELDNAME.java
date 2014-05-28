//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFELDNAME
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:13
//*****************************************************************************

import mLibrary.*;


//<< WWWFELDNAME(YFORM,YTYP,YLFN,YALTER)
public class WWWFELDNAME extends mClass {

  public Object main(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YTYP = m$.newVarRef("YTYP",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YALTER = m$.newVarRef("YALTER",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    return _WWWFELDNAME(YFORM,YTYP,YLFN,YALTER);
  }

  public Object _WWWFELDNAME(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YTYP = m$.newVarRef("YTYP",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YALTER = m$.newVarRef("YALTER",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       HOLEN FELDNAME AUS FORMULAR
    //<< ;   set NAME=$$^WWWFELDNAME(YFORM,"P",20,"Artikel")
    //<< ;
    //<< ; Inputs :
    //<< ;   YFORM       Form Name       FORMULARNAME
    //<< ;   YTYP        Field Type      FELDART     P=PRIM�RSCHL�SSEL D=DATENFELD M=MANUELLES FELD
    //<< ;   YLFN        DATENFELDNUMMER BEI STANDARD BZW. FORMULARFELDNUMMER BEI MANUELLEN FORMULAREN
    //<< ;   YALTER      ALTERNATIVE TEXT - only applied if language is German - then
    //<< ;                   ALWAYS override whatever else was produced.
    //<< ;   SPRACHE     Language
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;   YNAME   Field Name in appropriate language with customisation
    //<< ;
    //<< ; History :
    //<< ; 12-Apr-2011   GRF     SR17711: Brace format with comment cleanup; doco
    //<< ; 13-Dec-2007   GRF     SRBR014790: Doco
    //<< ; 24-Oct-2006   PO      SR15201: Use WWW1221 instead of WWW1211 for data fields
    //<< ;                           and use YLFN1 instead of YLFN, also removed naked
    //<< ;                           references
    //<< ; 19-Apr-2006   shobby  SRBR014020: If a free field has the caption overwritten
    //<< ;                           in the class definition use that if no customisation
    //<< ;                           has been done at the form level.
    //<< ; 16-Dec-2005   GRF     SR13984 : Doco
    //<< ; 14-Sep-2005   RPW     SR13306: Use $get instead of $data
    //<< ; 25-May-2005   RPW     SR12426: Use D2 (Caption in Forms) instead of D1 (Data
    //<< ;                           Element Description)
    //<< ; 25.Sep.2002   FIS     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YDATEI,YNAME,YLFN1
    mVar YDATEI = m$.var("YDATEI");
    mVar YNAME = m$.var("YNAME");
    mVar YLFN1 = m$.var("YLFN1");
    m$.newVar(YDATEI,YNAME,YLFN1);
    //<< 
    //<< set YNAME = ""
    YNAME.set("");
    //<< set YFORM = $get(YFORM)
    YFORM.set(m$.Fnc.$get(YFORM));
    //<< 
    //<< quit:YFORM="" YNAME
    if (mOp.Equal(YFORM.get(),"")) {
      return YNAME.get();
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; YFORM is the form id with assumption that the form and class ids are the
    //<< ; same, and that there might not be an actual form in which case we are
    //<< ; referring to the class.
    //<< ; If a form does exist, double check in case it actually uses a different
    //<< ; class.
    //<< ;
    //<< ; CAUTION : There is a flaw here in that we can have a manual form *** WITHOUT ***
    //<< ;           a class where the form name matches a class - INWEFREI is an example.
    //<< ;           In this situation we will never set YTYP to "M" if the form field
    //<< ;           number is within the valid class field numbers.  In the other cases
    //<< ;           YTYP remains "D" and the WWW122 customisation is followed by the class
    //<< ;           texts without considering WWW122 itself.  The class descriptions will
    //<< ;           be used (e.g. for table headings) without there necessarily being a
    //<< ;           correspondence.
    //<< ;
    //<< ;           [INWEFREI matches F# to D# with the exception of F101 "UPC Quantity"
    //<< ;           which matches _FREE so a table built from this form is not likely to
    //<< ;           be drastically different fromt he form field prompts themselves.]
    //<< ;
    //<< ;
    //<< ; The field number YLFN is the form field number for types P and M and is
    //<< ; the class field number for type D, being converted to the form field
    //<< ; number (YLFN1).
    //<< ;---------------------------------------
    //<< 
    //<< set YDATEI = YFORM
    YDATEI.set(YFORM.get());
    //<< if $get(^WWW120(0,YFORM,1))'="" if $piece(^WWW120(0,YFORM,1),Y,11)'="" set YDATEI = $piece(^WWW120(0,YFORM,1),Y,11)
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("^WWW120",0,YFORM.get(),1).get(),m$.var("Y").get(),11),"")) {
        YDATEI.set(m$.Fnc.$piece(m$.var("^WWW120",0,YFORM.get(),1).get(),m$.var("Y").get(),11));
      }
    }
    //<< quit:YDATEI="" YNAME
    if (mOp.Equal(YDATEI.get(),"")) {
      return YNAME.get();
    }
    //<< 
    //<< set YLFN = +$get(YLFN)
    YLFN.set(mOp.Positive(m$.Fnc.$get(YLFN)));
    //<< quit:YLFN=0 YNAME
    if (mOp.Equal(YLFN.get(),0)) {
      return YNAME.get();
    }
    //<< 
    //<< ; TODO : Consider checking YTYP="C" in this routine as well based on
    //<< ;        $$$WWW003CalcCaption   and   $$$WWW003CalcFieldName
    //<< 
    //<< set YTYP=$get(YTYP)
    YTYP.set(m$.Fnc.$get(YTYP));
    //<< if YTYP'="P" if YTYP'="D" if YTYP'="M" quit YNAME
    if (mOp.NotEqual(YTYP.get(),"P")) {
      if (mOp.NotEqual(YTYP.get(),"D")) {
        if (mOp.NotEqual(YTYP.get(),"M")) {
          return YNAME.get();
        }
      }
    }
    //<< 
    //<< ;=======================================
    //<< ; 1. Customising For Language           Form, Field, Company 0, Language
    //<< ; 2. Customisation                      Form, Field, Company 0
    //<< ; 3. Form Language Override             Form, Field, Language
    //<< ;
    //<< ; M
    //<< ; 4. Form Field                         Form, Field
    //<< ;
    //<< ; P/D
    //<< ; 4. Class Language Override            Class, Field, Language
    //<< ; 5. Class (Name for Form)              Class, Field
    //<< ;
    //<< ; D
    //<< ; 6. Class (BLANK Description)          Class, Field
    //<< ; 7. Class Free Field Customisation     Class, Field, Company 0
    //<< ;=======================================
    //<< 
    //<< if YTYP="D" if '$data(^WWW003(0,YDATEI,YLFN)) if $data(^WWW122(0,YFORM,YLFN)) set YTYP = "M"
    if (mOp.Equal(YTYP.get(),"D")) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW003",0,YDATEI.get(),YLFN.get())))) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122",0,YFORM.get(),YLFN.get())))) {
          YTYP.set("M");
        }
      }
    }
    //<< 
    //<< ; Primary Key
    //<< ;---------------------------------------
    //<< if YTYP="P" {
    if (mOp.Equal(YTYP.get(),"P")) {
      //<< if $piece($get(^WWW121D1(0,YFORM,YLFN,YM,SPRACHE,1)),Y,1)'="" {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D1",0,YFORM.get(),YLFN.get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
        //<< set YNAME = $piece($get(^WWW121D1(0,YFORM,YLFN,YM,SPRACHE,1)),Y,1)
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D1",0,YFORM.get(),YLFN.get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
      }
      //<< } else {
      else {
        //<< set YNAME = $piece($get(^WWW121D(0,YFORM,YLFN,YM,1)),Y,6)
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D",0,YFORM.get(),YLFN.get(),m$.var("YM").get(),1)),m$.var("Y").get(),6));
      }
      //<< }
      //<< if YNAME="" set YNAME = $piece($get(^WWW1211(0,YFORM,YLFN,SPRACHE,1)),Y,1)
      if (mOp.Equal(YNAME.get(),"")) {
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1211",0,YFORM.get(),YLFN.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
      }
      //<< if YNAME="" set YNAME = $piece($get(^WWW0021(0,YDATEI,YLFN,SPRACHE,1)),Y,1)
      if (mOp.Equal(YNAME.get(),"")) {
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0021",0,YDATEI.get(),YLFN.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
      }
      //<< if YNAME="" set YNAME = $piece($get(^WWW002(0,YDATEI,YLFN,1)),Y,2)
      if (mOp.Equal(YNAME.get(),"")) {
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),YLFN.get(),1)),m$.var("Y").get(),2));
      }
    }
    //<< 
    //<< ; Data Field
    //<< ;---------------------------------------
    //<< } elseif YTYP="D" {
    else if (mOp.Equal(YTYP.get(),"D")) {
      //<< set YLFN1 = $order(^WWW122s(0,4,$$^WWWUMLAU(YLFN,1),YFORM,""))
      YLFN1.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,m$.fnc$("WWWUMLAU.main",YLFN.get(),1),YFORM.get(),"")));
      //<< if +YLFN1=0 set YLFN1 = YLFN
      if (mOp.Equal(mOp.Positive(YLFN1.get()),0)) {
        YLFN1.set(YLFN.get());
      }
      //<< 
      //<< 
      //<< if $piece($get(^WWW122D1(0,YFORM,YLFN1,YM,SPRACHE,1)),Y,1)'="" {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122D1",0,YFORM.get(),YLFN1.get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
        //<< set YNAME = $piece($get(^WWW122D1(0,YFORM,YLFN1,YM,SPRACHE,1)),Y,1)
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122D1",0,YFORM.get(),YLFN1.get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
      }
      //<< } else {
      else {
        //<< set YNAME = $piece($get(^WWW122D(0,YFORM,YLFN1,YM,1)),Y,6)
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122D",0,YFORM.get(),YLFN1.get(),m$.var("YM").get(),1)),m$.var("Y").get(),6));
      }
      //<< }
      //<< if YNAME="" set YNAME = $piece($get(^WWW1221(0,YFORM,YLFN1,SPRACHE,1)),Y,1)
      if (mOp.Equal(YNAME.get(),"")) {
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1221",0,YFORM.get(),YLFN1.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
      }
      //<< if YNAME="" set YNAME = $piece($get(^WWW0031(0,YDATEI,YLFN,SPRACHE,1)),Y,1)
      if (mOp.Equal(YNAME.get(),"")) {
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0031",0,YDATEI.get(),YLFN.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
      }
      //<< if YNAME="" set YNAME = $piece($get(^WWW003(0,YDATEI,YLFN,1)),Y,2)
      if (mOp.Equal(YNAME.get(),"")) {
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),YLFN.get(),1)),m$.var("Y").get(),2));
      }
      //<< if (YNAME="") || ($extract(YNAME,1,6)="_BLANK") set YNAME = $piece($get(^WWW003(0,YDATEI,YLFN,1)),Y,1)
      if ((mOp.Equal(YNAME.get(),"")) || (mOp.Equal(m$.Fnc.$extract(YNAME.get(),1,6),"_BLANK"))) {
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDATEI.get(),YLFN.get(),1)),m$.var("Y").get(),1));
      }
      //<< if ((YNAME="") || ($extract(YNAME,1,5)="_FREE")) && ($piece($get(^WWW003D(0,YDATEI,YLFN,YM,1)),Y,25)'="") {
      if (mOp.Logical(((mOp.Equal(YNAME.get(),"")) || (mOp.Equal(m$.Fnc.$extract(YNAME.get(),1,5),"_FREE")))) && (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003D",0,YDATEI.get(),YLFN.get(),m$.var("YM").get(),1)),m$.var("Y").get(),25),""))) {
        //<< set YNAME = $piece($get(^WWW003D(0,YDATEI,YLFN,YM,1)),Y,25)
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003D",0,YDATEI.get(),YLFN.get(),m$.var("YM").get(),1)),m$.var("Y").get(),25));
      }
    }
    //<< }
    //<< 
    //<< ; Manual Field
    //<< ;---------------------------------------
    //<< } elseif YTYP="M" {
    else if (mOp.Equal(YTYP.get(),"M")) {
      //<< if $piece($get(^WWW122D1(0,YFORM,YLFN,YM,SPRACHE,1)),Y,1)'="" {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122D1",0,YFORM.get(),YLFN.get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
        //<< set YNAME = $piece($get(^WWW122D1(0,YFORM,YLFN,YM,SPRACHE,1)),Y,1)
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122D1",0,YFORM.get(),YLFN.get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
      }
      //<< } else {
      else {
        //<< set YNAME = $piece($get(^WWW122D(0,YFORM,YLFN,YM,1)),Y,6)
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122D",0,YFORM.get(),YLFN.get(),m$.var("YM").get(),1)),m$.var("Y").get(),6));
      }
      //<< }
      //<< if YNAME="" set YNAME = $piece($get(^WWW1221(0,YFORM,YLFN,SPRACHE,1)),Y,1)
      if (mOp.Equal(YNAME.get(),"")) {
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1221",0,YFORM.get(),YLFN.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
      }
      //<< if YNAME="" set YNAME = $piece($get(^WWW122(0,YFORM,YLFN,1)),Y,12)
      if (mOp.Equal(YNAME.get(),"")) {
        YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,YFORM.get(),YLFN.get(),1)),m$.var("Y").get(),12));
      }
    }
    //<< }
    //<< 
    //<< ; FIXME : <GRF> Is the language restriction here appropriate?
    //<< ;               Is YALTER ever used?  If we have YALTER to pass in through the
    //<< ;               calling routine, why even call this routine?
    //<< if $get(SPRACHE)="DE" if $get(YALTER)'="" set YNAME = YALTER
    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"DE")) {
      if (mOp.NotEqual(m$.Fnc.$get(YALTER),"")) {
        YNAME.set(YALTER.get());
      }
    }
    //<< 
    //<< quit YNAME
    return YNAME.get();
  }

//<< 
//<< 
}
