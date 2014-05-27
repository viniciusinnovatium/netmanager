//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFRAME
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:49
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
//<< #include WWWConst
import include.WWWConst;

//<< WWWFRAME(X,YFIX,YLIGHT,YID,YTABLE,APPLYBORDER=1,YHEIGHT="") ;SR17862
public class WWWFRAME extends mClass {

  public Object main(Object ... _p) {
    mVar X = m$.newVarRef("X",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFIX = m$.newVarRef("YFIX",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLIGHT = m$.newVarRef("YLIGHT",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YID = m$.newVarRef("YID",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YTABLE = m$.newVarRef("YTABLE",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar APPLYBORDER = m$.newVarRef("APPLYBORDER",(((_p!=null)&&(_p.length>=6))?_p[5]:null),1);
    mVar YHEIGHT = m$.newVarRef("YHEIGHT",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    return _WWWFRAME(X,YFIX,YLIGHT,YID,YTABLE,APPLYBORDER,YHEIGHT);
  }

  public Object _WWWFRAME(Object ... _p) {
    mVar X = m$.newVarRef("X",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFIX = m$.newVarRef("YFIX",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLIGHT = m$.newVarRef("YLIGHT",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YID = m$.newVarRef("YID",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YTABLE = m$.newVarRef("YTABLE",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar APPLYBORDER = m$.newVarRef("APPLYBORDER",(((_p!=null)&&(_p.length>=6))?_p[5]:null),1);
    mVar YHEIGHT = m$.newVarRef("YHEIGHT",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       RAHMEN MIT RAHMEN
    //<< ;       Framework
    //<< ;
    //<< ; Inputs :
    //<< ;   startet einen Rahmen mit den vorgegebenen rahmenbedingungen
    //<< ;   starts a fraemwork with the given conditions
    //<< ;
    //<< ;   X   = 0      ; Start frame 100%
    //<< ;   X   = 1      ; Terminate frame
    //<< ;   X   = 2      ; Start frame without %
    //<< ;   X   = 3      ; starten rahmen wie hintergrund z.b,grau
    //<< ;                ; start frame like background e.g., grey
    //<< ;   X   = NN     ; Start frame with NN=% width
    //<< ;   X   = NNN    ; PICELBREITE - pixel width
    //<< ;
    //<< ;   YFIX    = 1     dann ist der Rand des Tables scrollbar
    //<< ;                   there is a scrollbar on the edge of the table
    //<< ;   YLIGHT  = 1     =farbe an hintergrund angepasst ; color adapted to background
    //<< ;   YID     = ID    the table id
    //<< ;   YTABLE  = 0     Normal frame
    //<< ;           = 1     table (wegen hintergrundfarbe=zeilenfarbe oder hintergrund) ;or
    //<< ;
    //<< ; ByRef :
    //<< ;   YFORM
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 13-Dec-2006   JW      BR014262: Doco, clean up.
    //<< ; 27-Nov-2006   GRF     SR15232: Doco; quits; YCR
    //<< ; 11.10.1999    DT
    //<< ;-------------------------------------------------------------------------------
    //<< SET YFIX=$GET(YFIX)
    YFIX.set(m$.Fnc.$get(YFIX));
    //<< SET X=+$GET(X)
    X.set(mOp.Positive(m$.Fnc.$get(X)));
    //<< IF X=1 {
    if (mOp.Equal(X.get(),1)) {
      //<< DO STOP
      m$.Cmd.Do("STOP");
    }
    //<< } else {
    else {
      //<< DO START
      m$.Cmd.Do("START");
    }
    //<< }
    //<< QUIT
    return null;
  }

  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< ; YVOR      objFORM     (WWW120)
  //<< ; YVOR1     objCOMPANY  (WWW012)
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< START
  public void START() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Start frame as HTML <TABLE>, incrementing table level
    //<< ;
    //<< ; Passed as Arguments : X,YFIX,YLIGHT,YID,YTABLE
    //<< ;
    //<< ; By Ref :
    //<< ;   YTABLEANZ   Table level
    //<< ;
    //<< ; Returns by ref:
    //<< ;   YVOR1       objWWW012
    //<< ;
    //<< ; History :
    //<< ; 22-Sep-2010   GRF     SR17515: "FARBE" property is not language based; Macros;
    //<< ;                           $get not required for YVOR; dot to brace format
    //<< ;-------------------------------------------------------------------------------
    //<< new YVOR
    mVar YVOR = m$.var("YVOR");
    m$.newVar(YVOR);
    //<< 
    //<< if '$data(YVOR1)   set YVOR1 = $get(^WWW012(0,YM,1))
    if (mOp.Not(m$.Fnc.$data(m$.var("YVOR1")))) {
      mVar YVOR1 = m$.var("YVOR1");
      YVOR1.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    }
    //<< set YVOR=""
    YVOR.set("");
    //<< if $get(YFORM)'="" set YVOR  = $get(^WWW120(0,YFORM,1))  ;FIS;08.12.04;26564
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
      YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
    }
    //<< 
    //<< ;   D49     $$$WWW013EmployeeCategory()
    //<< if $$$WWW013EmployeeCategory($get(^WWW013(0,YBED,1)))=998 new YVOR1X set YVOR1X=YVOR1 new YVOR1 do  ;USER = INTERNETLOGIN;FIS;15.12.2004
    if (mOp.Equal(include.WWWConst.$$$WWW013EmployeeCategory(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))),998)) {
      mVar YVOR1X = m$.var("YVOR1X");
      m$.newVar(YVOR1X);
      YVOR1X.set(m$.var("YVOR1").get());
      mVar YVOR1 = m$.var("YVOR1");
      m$.newVar(YVOR1);
      //<< . set YVOR1 = YVOR1X
      YVOR1.set(YVOR1X.get());
      //<< . set $$$WWW012BackgroundColor(YVOR1)      = 137    ; Background Colour  (White)
      include.WWWConst.$$$WWW012BackgroundColorSet(m$,YVOR1,137);
      //<< . set $$$WWW012ColumnColourDarkness(YVOR1) = 137    ; Column Colour Dark (White)
      include.WWWConst.$$$WWW012ColumnColourDarknessSet(m$,YVOR1,137);
      //<< . set $$$WWW012FrameBodyColor(YVOR1)       = 137    ; Frame Body Colour  (White)
      include.WWWConst.$$$WWW012FrameBodyColorSet(m$,YVOR1,137);
      //<< . set $$$WWW012FrameColorForLight(YVOR1)   =   8    ; Light Frame Colour (Black)
      include.WWWConst.$$$WWW012FrameColorForLightSet(m$,YVOR1,8);
      //<< . set $$$WWW012FrameColorForDark(YVOR1)    = 137    ; Dark Frame Colour  (White)
      include.WWWConst.$$$WWW012FrameColorForDarkSet(m$,YVOR1,137);
    }
    //<< 
    //<< set YTABLEANZ = $get(YTABLEANZ)+1
    mVar YTABLEANZ = m$.var("YTABLEANZ");
    YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
    //<< 
    //<< write YCR,"<TABLE"
    m$.Cmd.Write(m$.var("YCR").get(),"<TABLE");
    //<< if $get(YID)'="" write " id="""_YID_""""
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YID")),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" id=\"",m$.var("YID").get()),"\""));
    }
    //<< 
    //<< ;SR17862 vvvvvv
    //<< ;SR17862 ; Using style sheet
    //<< ;SR17862 if $$$WWW120StylesheetCSSFile(YVOR)="" {
    //<< ;SR17862    write " border=1"
    //<< ;SR17862 } else {
    //<< ;SR17862    write " border=0 class=""table"""
    //<< ;SR17862 }
    //<< if $$$WWW120StylesheetCSSFile(YVOR)="" {
    if (mOp.Equal(include.WWWConst.$$$WWW120StylesheetCSSFile(m$,YVOR),"")) {
      //<< if (APPLYBORDER = $$$YES) {
      if ((mOp.Equal(m$.var("APPLYBORDER").get(),include.COMSYS.$$$YES(m$)))) {
        //<< write " border=1"
        m$.Cmd.Write(" border=1");
      }
      //<< } else {
      else {
        //<< write " border=0 " ;SR17871
        m$.Cmd.Write(" border=0 ");
        //<< set strStyle="border:1px solid gainsboro; " ;SR17871
        mVar strStyle = m$.var("strStyle");
        strStyle.set("border:1px solid gainsboro; ");
      }
    }
    //<< }
    //<< } else {
    else {
      //<< write " border=0 class=""table"""
      m$.Cmd.Write(" border=0 class=\"table\"");
    }
    //<< }
    //<< ;SR17862 ^^^^^
    //<< 
    //<< write " NOWRAP"
    m$.Cmd.Write(" NOWRAP");
    //<< 
    //<< if YFIX=1 write YCR," STYLE=""table-layout:fixed"""
    if (mOp.Equal(m$.var("YFIX").get(),1)) {
      m$.Cmd.Write(m$.var("YCR").get()," STYLE=\"table-layout:fixed\"");
    }
    //<< 
    //<< ; WIDTH
    //<< ;---------------------------------------
    //<< if X>100 {
    if (mOp.Greater(m$.var("X").get(),100)) {
      //<< write YCR," WIDTH="_X       ; Pixels over 100
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(" WIDTH=",m$.var("X").get()));
    }
    //<< 
    //<< } elseif X>3 {
    else if (mOp.Greater(m$.var("X").get(),3)) {
      //<< write YCR," WIDTH="_X_"%"   ; Percentage to 100, special for 2 or 3
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" WIDTH=",m$.var("X").get()),"%"));
    }
    //<< 
    //<< } elseif (X'=2) && (X'=3) {
    else if ((mOp.NotEqual(m$.var("X").get(),2)) && (mOp.NotEqual(m$.var("X").get(),3))) {
      //<< write YCR," WIDTH=100%"
      m$.Cmd.Write(m$.var("YCR").get()," WIDTH=100%");
    }
    //<< }
    //<< 
    //<< if $$$WWW120StylesheetCSSFile(YVOR)="" {
    if (mOp.Equal(include.WWWConst.$$$WWW120StylesheetCSSFile(m$,YVOR),"")) {
      //<< if $$$WWW012FrameBodyColor(YVOR1)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW012FrameBodyColor(m$,m$.var("YVOR1")),"")) {
        //<< if $$$WWW012ColumnColourDarkness(YVOR1)="" set $$$WWW012ColumnColourDarkness(YVOR1) = $$$WWW012FrameBodyColor(YVOR1)
        if (mOp.Equal(include.WWWConst.$$$WWW012ColumnColourDarkness(m$,m$.var("YVOR1")),"")) {
          include.WWWConst.$$$WWW012ColumnColourDarknessSet(m$,m$.var("YVOR1"),include.WWWConst.$$$WWW012FrameBodyColor(m$,m$.var("YVOR1")));
        }
        //<< if $get(YTABLE)=$$$YES {
        if (mOp.Equal(m$.Fnc.$get(m$.var("YTABLE")),include.COMSYS.$$$YES(m$))) {
          //<< write YCR," bgcolor="""_$piece($get(^WWW100(0,"FARBE","EN",$$$WWW012ColumnColourDarkness(YVOR1),1)),Y,1)_""""
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" bgcolor=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",include.WWWConst.$$$WWW012ColumnColourDarkness(m$,m$.var("YVOR1")),1)),m$.var("Y").get(),1)),"\""));
        }
        //<< } else {
        else {
          //<< write YCR," bgcolor="""_$piece($get(^WWW100(0,"FARBE","EN",$$$WWW012FrameBodyColor(YVOR1),1)),Y,1)_""""
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" bgcolor=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",include.WWWConst.$$$WWW012FrameBodyColor(m$,m$.var("YVOR1")),1)),m$.var("Y").get(),1)),"\""));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if $$$WWW012FrameColorForDark(YVOR1)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW012FrameColorForDark(m$,m$.var("YVOR1")),"")) {
        //<< write YCR," BORDERCOLORDARK="_""""_$piece($get(^WWW100(0,"FARBE","EN",$$$WWW012FrameColorForDark(YVOR1),1)),Y,1)_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(" BORDERCOLORDARK=","\""),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",include.WWWConst.$$$WWW012FrameColorForDark(m$,m$.var("YVOR1")),1)),m$.var("Y").get(),1)),"\""));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< 
    //<< if $get(YLIGHT)=$$$YES {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YLIGHT")),include.COMSYS.$$$YES(m$))) {
      //<< if $$$WWW012BackgroundColor(YVOR1)'=""    write YCR," BORDERCOLORLIGHT="""_$piece($get(^WWW100(0,"FARBE","EN",$$$WWW012BackgroundColor(YVOR1),1)),Y,1)_""""
      if (mOp.NotEqual(include.WWWConst.$$$WWW012BackgroundColor(m$,m$.var("YVOR1")),"")) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" BORDERCOLORLIGHT=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",include.WWWConst.$$$WWW012BackgroundColor(m$,m$.var("YVOR1")),1)),m$.var("Y").get(),1)),"\""));
      }
    }
    //<< 
    //<< } else {
    else {
      //<< if $$$WWW012FrameColorForLight(YVOR1)'="" write YCR," BORDERCOLORLIGHT="""_$piece($get(^WWW100(0,"FARBE","EN",$$$WWW012FrameColorForLight(YVOR1),1)),Y,1)_""""
      if (mOp.NotEqual(include.WWWConst.$$$WWW012FrameColorForLight(m$,m$.var("YVOR1")),"")) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" BORDERCOLORLIGHT=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",include.WWWConst.$$$WWW012FrameColorForLight(m$,m$.var("YVOR1")),1)),m$.var("Y").get(),1)),"\""));
      }
    }
    //<< }
    //<< write " cellspacing=0>",YCR
    m$.Cmd.Write(" cellspacing=0>",m$.var("YCR").get());
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< oldSTART ;STARTEN RAHMEN ;launching framework
  public void oldSTART() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Passed as Arguments : X,YFIX,YLIGHT,YID,YTABLE
    //<< ;
    //<< ; By Ref :
    //<< ;   YTABLEANZ   Table level
    //<< ;
    //<< ; Returns by ref:
    //<< ;   YVOR1       objWWW012
    //<< ;-------------------------------------------------------------------------------
    //<< new YPROZ,YVOR
    mVar YPROZ = m$.var("YPROZ");
    mVar YVOR = m$.var("YVOR");
    m$.newVar(YPROZ,YVOR);
    //<< 
    //<< IF '$DATA(YVOR1) SET YVOR1=$GET(^WWW012(0,YM,1))
    if (mOp.Not(m$.Fnc.$data(m$.var("YVOR1")))) {
      mVar YVOR1 = m$.var("YVOR1");
      YVOR1.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    }
    //<< SET YVOR=""
    YVOR.set("");
    //<< IF $GET(YFORM)'="" SET YVOR=$GET(^WWW120(0,YFORM,1))  ;FIS;08.12.04;26564
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
      YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
    }
    //<< 
    //<< ;   D49     $$$WWW013EmployeeCategory()
    //<< IF $PIECE($GET(^WWW013(0,YBED,1)),Y,49)=998 NEW YVOR1X SET YVOR1X=YVOR1 NEW YVOR1 DO  ;USER = INTERNETLOGIN;FIS;15.12.2004
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)),m$.var("Y").get(),49),998)) {
      mVar YVOR1X = m$.var("YVOR1X");
      m$.newVar(YVOR1X);
      YVOR1X.set(m$.var("YVOR1").get());
      mVar YVOR1 = m$.var("YVOR1");
      m$.newVar(YVOR1);
      //<< . SET YVOR1=YVOR1X
      YVOR1.set(YVOR1X.get());
      //<< . SET $PIECE(YVOR1,Y,5)  = 137    ; Background Colour  (White)   ;HINTERGRUNDFARBE WEISS
      m$.pieceVar(YVOR1,m$.var("Y").get(),5).set(137);
      //<< . SET $PIECE(YVOR1,Y,112)= 137    ; Column Colour Dark (White)   ;HINTERGRUNDFARBE WEISS
      m$.pieceVar(YVOR1,m$.var("Y").get(),112).set(137);
      //<< . SET $PIECE(YVOR1,Y,77) = 137    ; Frame Body Colour  (White)   ;HINTERGRUNDFARBE WEISS
      m$.pieceVar(YVOR1,m$.var("Y").get(),77).set(137);
      //<< . SET $PIECE(YVOR1,Y,14) =   8    ; Light Frame Colour (Black)   ;RAHMENFARBE SCHWARZ
      m$.pieceVar(YVOR1,m$.var("Y").get(),14).set(8);
      //<< . SET $PIECE(YVOR1,Y,15) = 137    ; Dark Fram Colour   (White)   ;RAHMENFARBE WEISS
      m$.pieceVar(YVOR1,m$.var("Y").get(),15).set(137);
    }
    do {
      //<< 
      //<< DO
      //<< . SET YTABLEANZ=$GET(YTABLEANZ)+1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
      //<< . WRITE YCR,"<TABLE"
      m$.Cmd.Write(m$.var("YCR").get(),"<TABLE");
      //<< . IF $GET(YID)'="" WRITE " id="""_YID_""""                                       ;TABLE ID;FIS;11.02.04;24587
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YID")),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" id=\"",m$.var("YID").get()),"\""));
      }
      //<< . ;
      //<< . IF $PIECE($GET(YVOR),Y,83)=""  WRITE " BORDER=1"
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(YVOR),m$.var("Y").get(),83),"")) {
        m$.Cmd.Write(" BORDER=1");
      }
      //<< . IF $PIECE($GET(YVOR),Y,83)'="" WRITE " border=0 class=""table"""         ;FIS;CUSTOMER CSS STYLESHEET;08.12.04;26564
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(YVOR),m$.var("Y").get(),83),"")) {
        m$.Cmd.Write(" border=0 class=\"table\"");
      }
      //<< . ;
      //<< . WRITE " NOWRAP"
      m$.Cmd.Write(" NOWRAP");
      //<< . SET YPROZ=100                                                                     ;WEITE IN PROZENT ;offset within percentage
      YPROZ.set(100);
      //<< . IF YFIX=1 WRITE YCR," STYLE=""table-layout:fixed"""
      if (mOp.Equal(m$.var("YFIX").get(),1)) {
        m$.Cmd.Write(m$.var("YCR").get()," STYLE=\"table-layout:fixed\"");
      }
      //<< . IF +X>3 SET YPROZ=X
      if (mOp.Greater(mOp.Positive(m$.var("X").get()),3)) {
        YPROZ.set(m$.var("X").get());
      }
      //<< . IF X<100.01 IF +X'=2 IF +X'=3 WRITE YCR," WIDTH="_YPROZ_"%"
      if (mOp.Less(m$.var("X").get(),100.01)) {
        if (mOp.NotEqual(mOp.Positive(m$.var("X").get()),2)) {
          if (mOp.NotEqual(mOp.Positive(m$.var("X").get()),3)) {
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" WIDTH=",YPROZ.get()),"%"));
          }
        }
      }
      //<< . IF X>100                      WRITE YCR," WIDTH="_YPROZ
      if (mOp.Greater(m$.var("X").get(),100)) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(" WIDTH=",YPROZ.get()));
      }
      //<< . ;
      //<< . IF $PIECE(YVOR1,Y,77)'="" DO
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),77),"")) {
        do {
          //<< . . QUIT:$PIECE($GET(YVOR),Y,83)'=""
          if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(YVOR),m$.var("Y").get(),83),"")) {
            break;
          }
          //<< . . WRITE YCR
          m$.Cmd.Write(m$.var("YCR").get());
          //<< . . IF $PIECE(YVOR1,Y,112)="" SET $PIECE(YVOR1,Y,112)=$PIECE(YVOR1,Y,77)  ;FIS;06.04.04
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),112),"")) {
            m$.pieceVar(m$.var("YVOR1"),m$.var("Y").get(),112).set(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),77));
          }
          //<< . . IF $GET(YTABLE)'=1 WRITE " bgcolor="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR1,Y,77),1)),Y,1)_""""
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTABLE")),1)) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" bgcolor=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),77),1)),m$.var("Y").get(),1)),"\""));
          }
          //<< . . IF $GET(YTABLE)=1  WRITE " bgcolor="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR1,Y,112),1)),Y,1)_""""  ;TYBD;FARBEN ANGEPASST;11,2,2004
          if (mOp.Equal(m$.Fnc.$get(m$.var("YTABLE")),1)) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" bgcolor=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),112),1)),m$.var("Y").get(),1)),"\""));
          }
        } while (false);
      }
      //<< . ;
      //<< . IF $PIECE(YVOR1,Y,15)'="" DO
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),15),"")) {
        do {
          //<< . . QUIT:$PIECE($GET(YVOR),Y,83)'=""
          if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(YVOR),m$.var("Y").get(),83),"")) {
            break;
          }
          //<< . . WRITE YCR," BORDERCOLORDARK="_""""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR1,Y,15),1)),Y,1)_""""
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(" BORDERCOLORDARK=","\""),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),15),1)),m$.var("Y").get(),1)),"\""));
        } while (false);
      }
      //<< . ;
      //<< . IF $GET(YLIGHT)=1  IF $PIECE(YVOR1,Y,5)'=""  WRITE YCR," BORDERCOLORLIGHT="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR1,Y,5),1)),Y,1)_""""
      if (mOp.Equal(m$.Fnc.$get(m$.var("YLIGHT")),1)) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),5),"")) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" BORDERCOLORLIGHT=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),5),1)),m$.var("Y").get(),1)),"\""));
        }
      }
      //<< . IF $GET(YLIGHT)'=1 IF $PIECE(YVOR1,Y,14)'="" WRITE YCR," BORDERCOLORLIGHT="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR1,Y,14),1)),Y,1)_""""
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLIGHT")),1)) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),14),"")) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" BORDERCOLORLIGHT=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),14),1)),m$.var("Y").get(),1)),"\""));
        }
      }
      //<< . WRITE " cellspacing=0>",YCR
      m$.Cmd.Write(" cellspacing=0>",m$.var("YCR").get());
    } while(false);
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< STOP ;ENDE DES RAHMENS        ;termination
  public void STOP() {
    //<< write YCR,"</TABLE>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    //<< set YTABLEANZ = $get(YTABLEANZ)-1
    mVar YTABLEANZ = m$.var("YTABLEANZ");
    YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
    //<< quit
    return;
  }

//<< 
//<< 
}
