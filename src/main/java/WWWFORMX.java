//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMX
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:03
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWFORMX
public class WWWFORMX extends mClass {

  public void main() {
    _WWWFORMX();
  }

  public void _WWWFORMX() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Set Form Values from Company Defaults
    //<< ;
    //<< ; Inputs :
    //<< ;   YFORM       FORMNAME
    //<< ;
    //<< ; ByRef :
    //<< ;   YVOR1       VORGABE AUS MANDANT ;out of Company
    //<< ;   YVOR        VORGABE AUS FORMULAR ;out of form
    //<< ;               (WWW120 record returned to routine WWW120)
    //<< ;   YFIXHEADER
    //<< ;   YI          FIXME : Should probably new this; ideally pass byRef
    //<< ;               through argument list <GRF>
    //<< ;
    //<< ; Returns :
    //<< ;   YVOR (By Ref) : Form Values - adjusted
    //<< ;
    //<< ; History :
    //<< ; 13-Dec-2007   shobby  Call to DoNotDisplay to determine if additional buttons
    //<< ;                           are to be hidden with customisation
    //<< ; 28-Mar-2007   RPW     Code Rewrite
    //<< ;  8-Aug-2006   JW      SR13594: Cleaned up.
    //<< ; 20-Jul-2005   GRF     SR12996 : Doco
    //<< ; 11.10.1999    DT
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;---------------------------------------
    //<< ;   YVOR    objForm             WWW120
    //<< ;   YVOR1   objCoyDefaults      WWW012
    //<< ;---------------------------------------
    //<< 
    //<< set YVOR1 = $get(^WWW012(0,YM,1))  ;LAYOUTVORGABEN ; Company layout defaults
    mVar YVOR1 = m$.var("YVOR1");
    YVOR1.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< set YVOR  = ""
    mVar YVOR = m$.var("YVOR");
    YVOR.set("");
    //<< IF YFORM'="" {
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      //<< set YVOR = $get(^WWW120(0,YFORM,1))  ;FORMULARDATEN
      YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
      //<< set $$$WWW120DoNOTDisplayStandardButto(YVOR) = $$DoNotDisplay^WWW120(YFORM)   ;SRBR014601
      include.WWWConst.$$$WWW120DoNOTDisplayStandardButtoSet(m$,YVOR,m$.fnc$("WWW120.DoNotDisplay",m$.var("YFORM").get()));
    }
    //<< }
    //<< 
    //<< if $$$WWW120InheritCompanyProperties(YVOR) {
    if (mOp.Logical(include.WWWConst.$$$WWW120InheritCompanyProperties(m$,YVOR))) {
      //<< for YI=3:1:10,63,64,70,77,91 set $piece(YVOR,Y,YI) = $piece(YVOR1,Y,YI)   ;VORGABEN AUS MANDANT IN FORMULAR ;out of Company within form
      mVar YI = m$.var("YI");
      for (YI.set(3);(mOp.LessOrEqual(YI.get(),10));YI.set(mOp.Add(YI.get(),1))) {
        m$.pieceVar(YVOR,m$.var("Y").get(),YI.get()).set(m$.Fnc.$piece(YVOR1.get(),m$.var("Y").get(),YI.get()));
      }
      //<< 
      //<< set YI = 66    ; $$$WWW012DisplayButtonOnBottomLine     $$$WWW120PositioningOfButtonLine
      YI.set(66);
      //<< if (+$piece(YVOR1,Y,YI)'=0) && ($piece(YVOR,Y,YI)="")  set $piece(YVOR,Y,YI) = $piece(YVOR1,Y,YI)  ;BUTTONLEISTE ; "WWWBUTTONFORMAT"
      if ((mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YVOR1.get(),m$.var("Y").get(),YI.get())),0)) && (mOp.Equal(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),YI.get()),""))) {
        m$.pieceVar(YVOR,m$.var("Y").get(),YI.get()).set(m$.Fnc.$piece(YVOR1.get(),m$.var("Y").get(),YI.get()));
      }
      //<< if ($piece(YVOR,Y,YI)=2) && ('$data(^WWW124(0,YFORM))) set $piece(YVOR,Y,YI) = 0
      if ((mOp.Equal(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),YI.get()),2)) && (mOp.Not(m$.Fnc.$data(m$.var("^WWW124",0,m$.var("YFORM").get()))))) {
        m$.pieceVar(YVOR,m$.var("Y").get(),YI.get()).set(0);
      }
      //<< 
      //<< 
      //<< set YI=13      ; $$$WWW012FormsFramed                   $$$WWW120DisplayFrames
      YI.set(13);
      //<< if +$piece(YVOR1,Y,YI)'=$$$NO set $piece(YVOR,Y,YI) = $$$YES
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YVOR1.get(),m$.var("Y").get(),YI.get())),include.COMSYS.$$$NO(m$))) {
        m$.pieceVar(YVOR,m$.var("Y").get(),YI.get()).set(include.COMSYS.$$$YES(m$));
      }
      //<< 
      //<< set $piece(YVOR,Y,36) = $piece(YVOR1,Y,17)     ; HorizontalOrientation
      m$.pieceVar(YVOR,m$.var("Y").get(),36).set(m$.Fnc.$piece(YVOR1.get(),m$.var("Y").get(),17));
      //<< set $piece(YVOR,Y,37) = $piece(YVOR1,Y,18)     ; VerticalOrientation
      m$.pieceVar(YVOR,m$.var("Y").get(),37).set(m$.Fnc.$piece(YVOR1.get(),m$.var("Y").get(),18));
      //<< 
      //<< ;   if $piece(YVOR,Y,44)'=2 set $piece(YVOR,Y,44)=$piece(YVOR1,Y,23)  ;WENN KEINE ANDERE VORGABE
      //<< set $$$WWW120PicturesAsButtons(YVOR) = $$$WWW012ForcePicturesAsButtons(YVOR1)     ; D45/D24
      include.WWWConst.$$$WWW120PicturesAsButtonsSet(m$,YVOR,include.WWWConst.$$$WWW012ForcePicturesAsButtons(m$,YVOR1));
    }
    //<< 
    //<< } else {
    else {
      //<< for YI=3:1:10,63,64,77,91 set $piece(YVOR1,Y,YI) = $piece(YVOR,Y,YI)   ;VORGABEN
      mVar YI = m$.var("YI");
      for (YI.set(3);(mOp.LessOrEqual(YI.get(),10));YI.set(mOp.Add(YI.get(),1))) {
        m$.pieceVar(YVOR1,m$.var("Y").get(),YI.get()).set(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),YI.get()));
      }
    }
    //<< }
    //<< 
    //<< if ($$$WWW120InputFormatLengthInPixel(YVOR)="") && ($$$WWW120FormFormatting(YVOR)'=1) set $$$WWW120InputFormatLengthInPixel(YVOR) = 150
    if ((mOp.Equal(include.WWWConst.$$$WWW120InputFormatLengthInPixel(m$,YVOR),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW120FormFormatting(m$,YVOR),1))) {
      include.WWWConst.$$$WWW120InputFormatLengthInPixelSet(m$,YVOR,150);
    }
    //<< 
    //<< if $$$WWW120FixedHeader(YVOR)=$$$YES set YFIXHEADER = $$$YES
    if (mOp.Equal(include.WWWConst.$$$WWW120FixedHeader(m$,YVOR),include.COMSYS.$$$YES(m$))) {
      mVar YFIXHEADER = m$.var("YFIXHEADER");
      YFIXHEADER.set(include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< quit
    return;
  }

//<< 
}
