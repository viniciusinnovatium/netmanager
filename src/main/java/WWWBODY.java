//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWBODY
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:11
//*****************************************************************************

import mLibrary.*;

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

//<< WWWBODY(X,NOPRINT)
public class WWWBODY extends mClass {

  public Object main(Object ... _p) {
    mVar X = m$.newVarRef("X",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar NOPRINT = m$.newVarRef("NOPRINT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _WWWBODY(X,NOPRINT);
  }

  public Object _WWWBODY(Object ... _p) {
    mVar X = m$.newVarRef("X",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar NOPRINT = m$.newVarRef("NOPRINT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       STARTEN BODY NORMAL FORMULAR
    //<< ;
    //<< ; Called By: WWWFORM + many more
    //<< ;
    //<< ; Inputs :
    //<< ;   X           FLAG FÜR VORGABE AUS FOCUS
    //<< ;           0 DATEN AUS MANDANT                        ; company
    //<< ;           1 DATEN AUS FORMULAR MIT FOKUS             ; form with focus
    //<< ;           2 DATEN AUS FORMULAR OHNE FOKUS (MANUELLE) ; form without focus
    //<< ;           3 SUCHFUNKTION MIT FOCUS AUF "YAUSWAHL"    ; search function
    //<< ;           4 DATEN AUS VORGABE (YVOR)                 ; default
    //<< ;   NOPRINT
    //<< ;           "NOPRINT" KEIN AUTOMATISCHER DRUCK
    //<< ;
    //<< ; ByRef :
    //<< ;   YVOR        objWWW120   VORGABE AUS FORMULARDEFINITION
    //<< ;   YFOART
    //<< ;   YPRINT
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 18.07.1999    DT
    //<< ;-------------------------------------------------------------------------------
    //<< ; NOTE:
    //<< ;  It appears that colour fields were originally stored as hex codes (e.g. FF00FF
    //<< ;  which would have a hash pre-pended).  In a number of places the code tests
    //<< ;  that these are not still present before using the FARBE parameter codes.
    //<< ;  e.g.  I $L($P(YVOR,Y,5))=6 W " BGCOLOR=""#"_$P(YVOR,Y,5)_""""
    //<< ;
    //<< ;  Changes have been made to remove the old commented out code and to replace
    //<< ;  unneeded checks for legacy data.  If there is a problem with the data it should
    //<< ;  be fixed.   <GRF>
    //<< ;-------------------------------------------------------------------------------
    //<< NEW ONLOAD
    mVar ONLOAD = m$.var("ONLOAD");
    m$.newVar(ONLOAD);
    //<< 
    //<< SET X      = +$GET(X) ; ;to default out of
    X.set(mOp.Positive(m$.Fnc.$get(X)));
    //<< SET YFOART = $GET(YFOART)
    mVar YFOART = m$.var("YFOART");
    YFOART.set(m$.Fnc.$get(m$.var("YFOART")));
    BODY();
    return null;
  }

  //<< ;---------------------------------------
  //<< ; explicit drop through
  //<< ;---------------------------------------
  //<< 
  //<< BODY
  public void BODY() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; VORGABE ;default
    //<< ;
    //<< ; YVOR          objWWW120    VORGABE AUS FORMVORGABE
    //<< ; YVOR1         objWWW012    VORGABE AUS MANDANTENVORGABE
    //<< ; window.onload = window.document.execCommand("Print", false)
    //<< ;
    //<< ; History:
    //<< ; 07-Jun-2013   shobby  CORE-116.3: Scrollbar fix suggested by Thiago and Lucas
    //<< ; 06-Jun-2013   shobby  CORE-116.2: MegaMenu must be created here for COMViewSearch forms.
    //<< ; 05-Jun-2013   shobby  CORE-116: Moved MegaMenu creation to WWWKOPF
    //<< ; 28-May-2013   shobby  CORE-116: Remove double scrollbars for 'Fixed Header' forms (IE only)
    //<< ; 22-May-2013   shobby  CORE-107: Mega Menu function was been moved to WWWMegaMenu
    //<< ; 15-May-2013   shobby  CORE-70.2: Check if NewSession exists before calling.
    //<< ; 10-Apr-2013   shobby  CORE-70: Call to NewSession.
    //<< ; 18-Oct-2012   shobby  SR18145: Subroutine ControlSetFocus.
    //<< ; 29-Nov-2010   shobby  SRAdhoc: Manipulation of opacity to reduce flickering in firefox. (disabled)
    //<< ; 06-Jul-2010   GRF     SR17408: remove "overflow:hidden" to enable browser
    //<< ;                           horizontal scrollbar under firefox
    //<< ; 04-May-2007   RPW     SR15511: Fixed code structure for WWWUSER checks
    //<< ; 04-May-2007   GRF     SR15511: also check not disabled, defining "objcontrol"
    //<< ;                           in js rather than repeating whole object name; use
    //<< ;                           idClassFld and objFormData; reorganise window.setTimeout
    //<< ;                           tests; convert some do levels to brace format; boolean
    //<< ;                           macros; comment out obsolete length test
    //<< ; 05-Jan-2007   PO      SR15351: Created procedure to perform clearing of old content
    //<< ; 19-Dec-2006   JW      BR014262: Menu type 6 has been removed
    //<< ; 10-Aug-2006   JW      SR13836: Default context menu
    //<< ; 09-Aug-2006   RPW/SCH SRBR014167:
    //<< ; 08-Aug-2006   GRF     "Error Condition" investigation; YCR/quit cleanup
    //<< ; 09-May-2006   RPW     SR14420: Allow the unload of a form to be noted and used.
    //<< ; 05-May-2006   Steve S SR14508: ClearOld^WWWMultiLock code
    //<< ; 03-May-2006   Steve S SR14592: Start the div
    //<< ; 09-Dec-2005   JW      SR13195: OnBeforeUnload code
    //<< ;-------------------------------------------------------------------------------
    //<< new blnContext,objUser
    mVar blnContext = m$.var("blnContext");
    mVar objUser = m$.var("objUser");
    m$.newVar(blnContext,objUser);
    //<< 
    //<< set blnContext = $$$CONTEXT
    blnContext.set(include.COMSYS.$$$CONTEXT(m$));
    //<< if blnContext do DefaultContext^COMViewColumnMenu()
    if (mOp.Logical(blnContext.get())) {
      m$.Cmd.Do("COMViewColumnMenu.DefaultContext");
    }
    //<< 
    //<< do OnBeforeUnload()
    m$.Cmd.Do("OnBeforeUnload");
    //<< do ClearOnLoad^WWWSession(YUSER,YFORM)
    m$.Cmd.Do("WWWSession.ClearOnLoad",m$.var("YUSER").get(),m$.var("YFORM").get());
    //<< 
    //<< IF X=0           DO MANU QUIT
    if (mOp.Equal(m$.var("X").get(),0)) {
      m$.Cmd.Do("MANU");
      return;
    }
    //<< IF '$DATA(Y)     DO MANU QUIT
    if (mOp.Not(m$.Fnc.$data(m$.var("Y")))) {
      m$.Cmd.Do("MANU");
      return;
    }
    //<< IF '$DATA(YVOR)  DO MANU QUIT
    if (mOp.Not(m$.Fnc.$data(m$.var("YVOR")))) {
      m$.Cmd.Do("MANU");
      return;
    }
    //<< IF '$DATA(YVOR1) DO MANU QUIT
    if (mOp.Not(m$.Fnc.$data(m$.var("YVOR1")))) {
      m$.Cmd.Do("MANU");
      return;
    }
    //<< 
    //<< ;IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* BODY (WWWBODY)************************* -->",YCR,YCR
    //<< 
    //<< IF $PIECE(YVOR,Y,40)'="" DO   ;SOUND   ; keep alternatives - some work with fix to YGIF path, some don't <GRF>
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),40),"")) {
      //<< . ;WRITE "<embed src="""_YGIF_$PIECE(YVOR,Y,40)_""" autostart=TRUE hidden=TRUE loop=FALSE>"
      //<< . ;WRITE "<noembed>"
      //<< . WRITE "<bgsound src="""_YGIF_$PIECE(YVOR,Y,40)_""" loop=1>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<bgsound src=\"",m$.var("YGIF").get()),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),40)),"\" loop=1>"));
    }
    //<< ;. WRITE "</noembed>"
    //<< 
    //<< /*
    //<< ;IF $PIECE(YVOR,Y,40)'="" DO
    //<< . WRITE "<BGSOUND SRC="""_YGIF_$PIECE(YVOR,Y,40)_""" loop=1>",YCR
    //<< . WRITE "<EMBED HIDDEN=TRUE AUTOSTART=TRUE SRC="""_YGIF_$PIECE(YVOR,Y,40)_""" loop=1>",YCR
    //<< */
    //<< 
    //<< WRITE "</HEAD>",YCR
    m$.Cmd.Write("</HEAD>",m$.var("YCR").get());
    //<< 
    //<< ; FESTLEGEN/FARBEN BESTIMMEN ;ordain
    //<< ;---------------------------------------
    //<< IF X=2 IF $GET(YFORM)'="" IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,5)'="" SET $PIECE(YVOR,Y,5)=$PIECE($GET(^WWW120(0,YFORM,1)),Y,5)  ;BEI MANUELLEN PROGRAMMEN HINTERGRUND NACH VORGABE FORMULAR ;next to foil within default form
    if (mOp.Equal(m$.var("X").get(),2)) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),5),"")) {
          m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),5).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),5));
        }
      }
    }
    //<< IF $PIECE($GET(^WWW013(0,YBED,1)),Y,49)=998 NEW YVORX SET YVORX=YVOR NEW YVOR DO  ;USER = INTERNETLOGIN;FIS;15.12.2004
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)),m$.var("Y").get(),49),998)) {
      mVar YVORX = m$.var("YVORX");
      m$.newVar(YVORX);
      YVORX.set(m$.var("YVOR").get());
      mVar YVOR = m$.var("YVOR");
      m$.newVar(YVOR);
      //<< . SET YVOR=YVORX
      YVOR.set(YVORX.get());
      //<< . SET $PIECE(YVOR,Y,5)=""  ;KEINE HINTERGRUNDFARBE
      m$.pieceVar(YVOR,m$.var("Y").get(),5).set("");
    }
    //<< 
    //<< if ($get(YFORM)'="") && (YUSER'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.NotEqual(m$.var("YUSER").get(),""))) {
      //<< set objUser=$get(^WWWUSER(0,YUSER,1))
      objUser.set(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)));
      //<< if ($$$WWWUSERLastForm(objUser)'=YFORM) || ($$$WWWUSERLastFormpage(objUser)'=$get(YSEITE)) {
      if ((mOp.NotEqual(include.WWWConst.$$$WWWUSERLastForm(m$,objUser),m$.var("YFORM").get())) || (mOp.NotEqual(include.WWWConst.$$$WWWUSERLastFormpage(m$,objUser),m$.Fnc.$get(m$.var("YSEITE"))))) {
        //<< set $$$WWWUSERLastFormfield(^WWWUSER(0,YUSER,1))=""
        include.WWWConst.$$$WWWUSERLastFormfieldSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< //DO:YUSER=""  IF YUSER'="" IF +$PIECE($GET(^WWWUSER(0,YUSER,1)),Y,6)=$$$NO DO
    //<< IF (YUSER="") ! ((YUSER'="") & (+$PIECE($GET(^WWWUSER(0,YUSER,1)),Y,6)=$$$NO)) DO
    if (mOp.Logical(mOp.Or((mOp.Equal(m$.var("YUSER").get(),"")),(mOp.And((mOp.NotEqual(m$.var("YUSER").get(),"")),(mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),m$.var("Y").get(),6)),include.COMSYS.$$$NO(m$)))))))) {
      //<< . IF YUSER'="" SET $PIECE(^WWWUSER(0,YUSER,1),Y,6)=$$$YES
      if (mOp.NotEqual(m$.var("YUSER").get(),"")) {
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),6).set(include.COMSYS.$$$YES(m$));
      }
      //<< . ;write "<body onload=""document.body.style.opacity=1"""
      //<< 
      //<< . WRITE "<BODY"
      m$.Cmd.Write("<BODY");
      //<< . write " onbeforeunload='UnloadConfirm(event);'"       ;SR17253
      m$.Cmd.Write(" onbeforeunload='UnloadConfirm(event);'");
      //<< . write " onunload='UnloadEvent();'"
      m$.Cmd.Write(" onunload='UnloadEvent();'");
      //<< . if blnContext write " oncontextmenu=' DisplayContext(); return false; ' "
      if (mOp.Logical(blnContext.get())) {
        m$.Cmd.Write(" oncontextmenu=' DisplayContext(); return false; ' ");
      }
      //<< . ;
      //<< . ; no SCREENÄNDER / SCREEN    ;FOCUS SETZTEN
      //<< . if ($get(YSCREENM)="") && ($get(YSCR)="") && ($get(NOPRINT)'="NOPRINT") do
      if ((mOp.Equal(m$.Fnc.$get(m$.var("YSCREENM")),"")) && (mOp.Equal(m$.Fnc.$get(m$.var("YSCR")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("NOPRINT")),"NOPRINT"))) {
        //<< . . if $get(YUSERAGENT)="MSIE" do
        if (mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) {
          do {
            //<< . . . if $get(YPRINT)=1                      write YCR," onLoad=""window.setTimeout('document.body.focus(); window.print();',10); """ quit
            if (mOp.Equal(m$.Fnc.$get(m$.var("YPRINT")),1)) {
              m$.Cmd.Write(m$.var("YCR").get()," onLoad=\"window.setTimeout('document.body.focus(); window.print();',10); \"");
              break;
            }
            //<< . . . if (X=2) && ($piece(YVOR,Y,85)=$$$YES) write YCR," onLoad=""window.setTimeout('document.body.focus(); window.print();',10); """ set YPRINT=1   ;automatisches drucken beim laden
            if ((mOp.Equal(m$.var("X").get(),2)) && (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),85),include.COMSYS.$$$YES(m$)))) {
              m$.Cmd.Write(m$.var("YCR").get()," onLoad=\"window.setTimeout('document.body.focus(); window.print();',10); \"");
              mVar YPRINT = m$.var("YPRINT");
              YPRINT.set(1);
            }
          } while (false);
        }
        //<< . . if $get(YUSERAGENT)'="MSIE" do
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) {
          do {
            //<< . . . if $get(YPRINT)=1                      write YCR," onLoad=""window.setTimeout('window.print()',10); """ quit
            if (mOp.Equal(m$.Fnc.$get(m$.var("YPRINT")),1)) {
              m$.Cmd.Write(m$.var("YCR").get()," onLoad=\"window.setTimeout('window.print()',10); \"");
              break;
            }
            //<< . . . if (X=2) && ($piece(YVOR,Y,85)=$$$YES) write YCR," onLoad=""window.setTimeout('window.print()',10); """ set YPRINT=1
            if ((mOp.Equal(m$.var("X").get(),2)) && (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),85),include.COMSYS.$$$YES(m$)))) {
              m$.Cmd.Write(m$.var("YCR").get()," onLoad=\"window.setTimeout('window.print()',10); \"");
              mVar YPRINT = m$.var("YPRINT");
              YPRINT.set(1);
            }
          } while (false);
        }
      }
      //<< . ;
      //<< . IF $PIECE(YVOR,Y,3)'=""    WRITE YCR," BACKGROUND="""_YGIF_$PIECE(YVOR,Y,3)_""""
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),3),"")) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(" BACKGROUND=\"",m$.var("YGIF").get()),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),3)),"\""));
      }
      //<< . IF $PIECE(YVOR,Y,4)=$$$YES WRITE YCR," BGPROPERTIES=fixed"
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),4),include.COMSYS.$$$YES(m$))) {
        m$.Cmd.Write(m$.var("YCR").get()," BGPROPERTIES=fixed");
      }
      //<< . IF $PIECE(YVOR,Y,5)'=""  IF $GET(YPRINT)'=1 WRITE YCR," BGCOLOR="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR,Y,5),1)),Y,1)_""""
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),5),"")) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YPRINT")),1)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" BGCOLOR=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),5),1)),m$.var("Y").get(),1)),"\""));
        }
      }
      //<< . IF $PIECE(YVOR,Y,6)'=""    WRITE " TEXT="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR,Y,6),1)),Y,1)_""""
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),6),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" TEXT=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),6),1)),m$.var("Y").get(),1)),"\""));
      }
      //<< . ;
      //<< . IF $PIECE(YVOR1,Y,12)'=""  DO
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),12),"")) {
        //<< . . WRITE YCR," LINK="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR1,Y,12),1)),Y,1)_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" LINK=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),12),1)),m$.var("Y").get(),1)),"\""));
        //<< . . DO
        do {
          //<< . . . IF $GET(%(YQUERY,"EP"))="WWWMANU" IF $FIND($GET(YEXEC),"^WWW") WRITE YCR," VLINK=""BLUE""" QUIT  ;SUCHMASCHINE
          if (mOp.Equal(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"EP")),"WWWMANU")) {
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$get(m$.var("YEXEC")),"^WWW"))) {
              m$.Cmd.Write(m$.var("YCR").get()," VLINK=\"BLUE\"");
              break;
            }
          }
          //<< . . . IF $GET(YFOART)=7 WRITE YCR," VLINK=""BLUE""" QUIT  ;SUCHMASCHINE
          if (mOp.Equal(m$.Fnc.$get(m$.var("YFOART")),7)) {
            m$.Cmd.Write(m$.var("YCR").get()," VLINK=\"BLUE\"");
            break;
          }
          //<< . . . IF X=3            WRITE YCR," VLINK=""BLUE""" QUIT
          if (mOp.Equal(m$.var("X").get(),3)) {
            m$.Cmd.Write(m$.var("YCR").get()," VLINK=\"BLUE\"");
            break;
          }
          //<< . . . IF X'=3           WRITE YCR," VLINK="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR1,Y,12),1)),Y,1)_""""
          if (mOp.NotEqual(m$.var("X").get(),3)) {
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" VLINK=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),12),1)),m$.var("Y").get(),1)),"\""));
          }
        } while(false);
        //<< . . ;
        //<< . . WRITE YCR," ALINK="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR1,Y,12),1)),Y,1)_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" ALINK=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),12),1)),m$.var("Y").get(),1)),"\""));
      }
      //<< . ;
      //<< . WRITE YCR," topmargin=1"," leftmargin=1"
      m$.Cmd.Write(m$.var("YCR").get()," topmargin=1"," leftmargin=1");
      //<< . ;W " ONBEFOREUNLOAD=""event.returnValue = 'Are you sure you want to leave?'"""
      //<< . ;WRITE YCR," onBeforClose=window.open('"_YAKTION_"EP=WWWMANU&YEXEC=*D|^WWWEND&YUSER="_YUSER_"&YBED="_YBED_"')"
      //<< . ;WRITE " onUnload=""cursor='wait';"""  ;TYBD;15,3,2004;AUSGESCHALTET MAIL J.GÜNTER
      //<< . ;W " onunload=""alert('"_$$^WWWTEXT(372)_"'));"""
      //<< . ;I YFORM="WWWCAL" W YCR," onBlur=""self.focus();"""
      //<< . ;
      //<< . ;IF $PIECE($GET(^WWWUSER(0,YUSER,1)),Y,25)'="" DO  ;RÜCKHOLEN LETZTER LOCK;FIS;19.04.04
      //<< . ;.WRITE " onunload='"
      //<< . ;.WRITE "retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"",""WWW0061"","""_$PIECE($GET(^WWWUSER(0,YUSER,1)),Y,25)_""",""6"","""");"
      //<< . ;.WRITE "'"
      //<< . ;
      //<< . write " onresize="" if(cvResize) { cvResize();} """  ;SR17378
      m$.Cmd.Write(" onresize=\" if(cvResize) { cvResize();} \"");
      //<< . SET ONLOAD = $$$NO
      mVar ONLOAD = m$.var("ONLOAD");
      ONLOAD.set(include.COMSYS.$$$NO(m$));
      //<< . ;     D85     $$$WWW120WithWindowprint()
      //<< . ;-------------------------------------
      //<< .;IF YMOUSETR'=$$$YES IF $PIECE(YVOR,Y,85)'=$$$YES WRITE YCR," onLoad=""self.focus();" SET ONLOAD=1
      //<< . IF YMOUSETR=$$$YES                               WRITE " onLoad=""init();" SET ONLOAD = $$$YES
      if (mOp.Equal(m$.var("YMOUSETR").get(),include.COMSYS.$$$YES(m$))) {
        m$.Cmd.Write(" onLoad=\"init();");
        ONLOAD.set(include.COMSYS.$$$YES(m$));
      }
      //<< . IF YMOUSETR'=$$$YES IF $PIECE(YVOR,Y,85)'=$$$YES WRITE " onLoad="" if(typeof(newSession)!='undefined') {newSession();} if (typeof(LoadEvent)!='undefined') {LoadEvent(); self.focus(); }" SET ONLOAD = $$$YES ;CORE-70 ;CORE-70.2
      if (mOp.NotEqual(m$.var("YMOUSETR").get(),include.COMSYS.$$$YES(m$))) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),85),include.COMSYS.$$$YES(m$))) {
          m$.Cmd.Write(" onLoad=\" if(typeof(newSession)!='undefined') {newSession();} if (typeof(LoadEvent)!='undefined') {LoadEvent(); self.focus(); }");
          ONLOAD.set(include.COMSYS.$$$YES(m$));
        }
      }
      //<< . ;
      //<< . ;TEXT-MELDUNGEN (POP-UP) BEI ONLOAD ;next to
      //<< . IF $DATA(^WWW013Ms(0,1," ",YBED)) DO
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW013Ms",0,1," ",m$.var("YBED").get())))) {
        do {
          //<< . . NEW TXT,TXT1,YFORM,YVOR,YOK
          mVar TXT = m$.var("TXT");
          mVar TXT1 = m$.var("TXT1");
          mVar YFORM = m$.var("YFORM");
          mVar YVOR = m$.var("YVOR");
          mVar YOK = m$.var("YOK");
          m$.newVarBlock(2,TXT,TXT1,YFORM,YVOR,YOK);
          //<< . . SET (TXT,TXT1)=""
          TXT.set("");
          TXT1.set("");
          //<< . . SET TXT = $ORDER(^WWW013Ms(0,1," ",YBED,""))
          TXT.set(m$.Fnc.$order(m$.var("^WWW013Ms",0,1," ",m$.var("YBED").get(),"")));
          //<< . . IF TXT'="" SET TXT1 = $GET(^WWW013M(0,YBED,TXT,1))
          if (mOp.NotEqual(TXT.get(),"")) {
            TXT1.set(m$.Fnc.$get(m$.var("^WWW013M",0,m$.var("YBED").get(),TXT.get(),1)));
          }
          //<< . . IF TXT'="" IF $TRANSLATE(TXT1,Y)="" DO ^WWWSKILL("WWW013M",YBED_","_TXT) QUIT
          if (mOp.NotEqual(TXT.get(),"")) {
            if (mOp.Equal(m$.Fnc.$translate(TXT1.get(),m$.var("Y").get()),"")) {
              m$.Cmd.Do("WWWSKILL.main","WWW013M",mOp.Concat(mOp.Concat(m$.var("YBED").get(),","),TXT.get()));
              break;
            }
          }
          //<< . . IF TXT1'="" DO
          if (mOp.NotEqual(TXT1.get(),"")) {
            //<< . . . if ONLOAD=$$$NO write YCR," onLoad=""" set ONLOAD = $$$YES
            if (mOp.Equal(ONLOAD.get(),include.COMSYS.$$$NO(m$))) {
              m$.Cmd.Write(m$.var("YCR").get()," onLoad=\"");
              ONLOAD.set(include.COMSYS.$$$YES(m$));
            }
            //<< . . . WRITE " alert('"
            m$.Cmd.Write(" alert('");
            //<< . . . IF $PIECE(TXT1,Y,4)'="" WRITE "("_$PIECE(TXT1,Y,4)_":) "
            if (mOp.NotEqual(m$.Fnc.$piece(TXT1.get(),m$.var("Y").get(),4),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("(",m$.Fnc.$piece(TXT1.get(),m$.var("Y").get(),4)),":) "));
            }
            //<< . . . WRITE $PIECE(TXT1,Y,1)
            m$.Cmd.Write(m$.Fnc.$piece(TXT1.get(),m$.var("Y").get(),1));
            //<< . . . WRITE "');"
            m$.Cmd.Write("');");
          }
          //<< . . ;
          //<< . . SET $PIECE(TXT1,Y,2)=+$HOROLOG
          m$.pieceVar(TXT1,m$.var("Y").get(),2).set(mOp.Positive(m$.Fnc.$horolog()));
          //<< . . SET $PIECE(TXT1,Y,3)=$PIECE($HOROLOG,",",2)
          m$.pieceVar(TXT1,m$.var("Y").get(),3).set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
          //<< . . SET YOK = $$^WWWSPEI("WWW013M",YBED_","_TXT,TXT1,$$$YES)
          YOK.set(m$.fnc$("WWWSPEI.main","WWW013M",mOp.Concat(mOp.Concat(m$.var("YBED").get(),","),TXT.get()),TXT1.get(),include.COMSYS.$$$YES(m$)));
        } while (false);
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . ; "This Version Is No Longer Supported. Please Update The System."
      //<< . ;-------------------------------------
      //<< . IF $PIECE($GET(^WWW012V(0,0,1)),Y,120)'="" IF $PIECE($GET(^WWW012V(0,0,1)),Y,120)<$HOROLOG DO
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012V",0,0,1)),m$.var("Y").get(),120),"")) {
        if (mOp.Less(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012V",0,0,1)),m$.var("Y").get(),120),m$.Fnc.$horolog())) {
          //<< . . if ONLOAD=$$$NO write YCR," onLoad=""" set ONLOAD = $$$YES
          if (mOp.Equal(ONLOAD.get(),include.COMSYS.$$$NO(m$))) {
            m$.Cmd.Write(m$.var("YCR").get()," onLoad=\"");
            ONLOAD.set(include.COMSYS.$$$YES(m$));
          }
          //<< . . WRITE " alert('"_$$^WWWTEXT(407)_"');"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" alert('",m$.fnc$("WWWTEXT.main",407)),"');"));
        }
      }
      //<< . ;
      //<< . ;FOKUS BESTIMMEN ;focus ordain
      //<< . ;-------------------------------------
      //<< . ;     D23     $$$WWW120AuthorizationToModifyData()
      //<< . ;     D72     $$$WWW120FirstFocusToDataFieldNumb()     ; Help indicates focus set to first primary key
      //<< . ;                                                        or first form field if this is not set - now as YI below.
      //<< . ;IF +$PIECE(YVOR,Y,72)'=0 IF X=2 SET X=1
      //<< . IF X=1 IF (YOPTION'="") || ( (YOPTION="") && '$DATA(^WWW1210(0,YFORM)) ) DO   ;FOCUS AUF DAS ERSTE FELD ;upon who premier field
      if (mOp.Equal(m$.var("X").get(),1)) {
        if ((mOp.NotEqual(m$.var("YOPTION").get(),"")) || mOp.Logical(((mOp.Equal(m$.var("YOPTION").get(),"")) && mOp.Not(m$.Fnc.$data(m$.var("^WWW1210",0,m$.var("YFORM").get())))))) {
          do {
            //<< . . IF $GET(YEXEC)'="" QUIT             ;KEIN FOCUS BEI EXECUTE ;no next to EXECUTE
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YEXEC")),"")) {
              break;
            }
            //<< . . QUIT:$PIECE($GET(YVOR),Y,23)=5      ;KEINE BERECHTIGUNG;TYBD;6,9,2004
            if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR")),m$.var("Y").get(),23),5)) {
              break;
            }
            //<< . . QUIT:$GET(YAENBER)=5                ;NUR LESEBERECHTIGUNG;CHECK LESEBERECHTIGUNG;TYBD;04,07,2003;23883;
            if (mOp.Equal(m$.Fnc.$get(m$.var("YAENBER")),5)) {
              break;
            }
            //<< . . ;I $E($G(YAUSWAHL))="#" Q           ;KEINE AUSWAHL BEI SELEKTIONEN
            //<< . . QUIT:$GET(YFOART)=8  ;WIZARD
            if (mOp.Equal(m$.Fnc.$get(m$.var("YFOART")),8)) {
              break;
            }
            //<< . . QUIT:YSEITE'=1
            if (mOp.NotEqual(m$.var("YSEITE").get(),1)) {
              break;
            }
            //<< . . NEW YI,YQ
            mVar YI = m$.var("YI");
            mVar YQ = m$.var("YQ");
            m$.newVarBlock(2,YI,YQ);
            //<< . . ;-----------------------------------
            //<< . . ;
            //<< . . SET YQ=0
            YQ.set(0);
            //<< . . if ONLOAD=$$$NO write YCR," onLoad=""" set ONLOAD = $$$YES
            if (mOp.Equal(ONLOAD.get(),include.COMSYS.$$$NO(m$))) {
              m$.Cmd.Write(m$.var("YCR").get()," onLoad=\"");
              ONLOAD.set(include.COMSYS.$$$YES(m$));
            }
            //<< . . IF YFOART=7 SET YI=+$PIECE(YVOR,Y,72) IF +YI'=0 do  quit            ;MAUELLER FOKUS
            if (mOp.Equal(m$.var("YFOART").get(),7)) {
              YI.set(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),72)));
              if (mOp.NotEqual(mOp.Positive(YI.get()),0)) {
                //<< . . . ;SR18145 write YCR," var objcontrol=document."_YHTMFORM_".Y"_YFORM_"D"_YI_";"
                //<< . . . ;SR18145 write " if(objcontrol.type!='hidden' && !objcontrol.disabled) {objcontrol.focus();}"
                //<< . . . write YCR, "ControlSetFocus('Y"_YFORM_"D"_YI_"');"     ;SR18145
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ControlSetFocus('Y",m$.var("YFORM").get()),"D"),YI.get()),"');"));
                //<< . . . SET YQ = 1
                YQ.set(1);
                break;
              }
            }
            //<< . . SET YI=$PIECE(YVOR,Y,72)
            YI.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),72));
            //<< . . QUIT:YI=0                           ;KEIN FOCUS DA 0 EINGETRAGEN ;no yonder regd.
            if (mOp.Equal(YI.get(),0)) {
              break;
            }
            //<< . . ;-----------------------------------
            //<< . . ;
            //<< . . IF YFOART=11 QUIT                   ;KEIN FOCUS AUF BEARBEITUNGSLISTE;FIS;03.02.04;25029
            if (mOp.Equal(m$.var("YFOART").get(),11)) {
              break;
            }
            //<< . . IF YI'="" DO                        ;MANUELLER FOCUS
            if (mOp.NotEqual(YI.get(),"")) {
              do {
                //<< . . . IF $PIECE($GET(^WWW122(0,YFORM,YI,1)),Y,1)'="" do  quit    ;MANUELLER
                if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YI.get(),1)),m$.var("Y").get(),1),"")) {
                  //<< . . . . ;SR18145 write YCR," var objcontrol=document."_YHTMFORM_".Y"_YFORM_"D"_YI_";"
                  //<< . . . . ;SR18145 write " if(objcontrol.type!='hidden' && !objcontrol.disabled) {objcontrol.focus();}"
                  //<< . . . . write YCR, "ControlSetFocus('Y"_YFORM_"D"_YI_"');"     ;SR18145
                  m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ControlSetFocus('Y",m$.var("YFORM").get()),"D"),YI.get()),"');"));
                  //<< . . . . SET YQ=1
                  YQ.set(1);
                  break;
                }
                //<< . . . ;
                //<< . . . IF (YSEITE=1) || (+YSEITE=0) IF $DATA(^WWW122(0,YFORM,YI,1)) IF $PIECE($GET(^WWW122(0,YFORM,YI,1)),Y,1)="" do  quit
                if ((mOp.Equal(m$.var("YSEITE").get(),1)) || (mOp.Equal(mOp.Positive(m$.var("YSEITE").get()),0))) {
                  if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get(),YI.get(),1)))) {
                    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YI.get(),1)),m$.var("Y").get(),1),"")) {
                      //<< . . . . ;SR18145 write YCR," var objcontrol=document."_YHTMFORM_".Y"_YFORM_"M"_YI_";"
                      //<< . . . . ;SR18145 write " if(objcontrol.type!='hidden' && !objcontrol.disabled) {objcontrol.focus();}"
                      //<< . . . . write YCR, "ControlSetFocus('Y"_YFORM_"M"_YI_"');"     ;SR18145
                      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ControlSetFocus('Y",m$.var("YFORM").get()),"M"),YI.get()),"');"));
                      //<< . . . . SET YQ=1
                      YQ.set(1);
                      break;
                    }
                  }
                }
              } while (false);
            }
            //<< . . QUIT:YQ=1
            if (mOp.Equal(YQ.get(),1)) {
              break;
            }
            //<< . . ;-----------------------------------
            //<< . . ;
            //<< . . IF YFOART=1 IF YSEITE=1 SET YI="" FOR  SET YI=$ORDER(^WWW121(0,YFORM,YI)) QUIT:YI=""  QUIT:YQ=1  DO  ;FOKUS BEI NORMAL ;focus next to normal
            if (mOp.Equal(m$.var("YFOART").get(),1)) {
              if (mOp.Equal(m$.var("YSEITE").get(),1)) {
                YI.set("");
                for (;true;) {
                  YI.set(m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YFORM").get(),YI.get())));
                  if (mOp.Equal(YI.get(),"")) {
                    break;
                  }
                  if (mOp.Equal(YQ.get(),1)) {
                    break;
                  }
                  do {
                    //<< . . . QUIT:YFOART'=1
                    if (mOp.NotEqual(m$.var("YFOART").get(),1)) {
                      break;
                    }
                    //<< . . . IF $PIECE(YKEY,",",YI)'="" QUIT                                       ;SCHLÜSSEL VORHANDEN ; key available
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) {
                      break;
                    }
                    //<< . . . QUIT:$PIECE($GET(^WWW121(0,YFORM,YI,1)),Y,16)'=""                     ; Fixed Input For Hidden Field
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YI.get(),1)),m$.var("Y").get(),16),"")) {
                      break;
                    }
                    //<< . . . QUIT:$PIECE($GET(^WWW121(0,YFORM,YI,1)),Y,104)=15                     ; Hidden
                    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YI.get(),1)),m$.var("Y").get(),104),15)) {
                      break;
                    }
                    //<< . . . IF $GET(YDATEI)'="" QUIT:+$PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)=0  ; Hidden
                    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDATEI")),"")) {
                      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),YI.get(),1)),m$.var("Y").get(),3)),0)) {
                        break;
                      }
                    }
                    //<< . . . QUIT:$EXTRACT($PIECE($GET(^WWW121(0,YFORM,YI,1)),Y,15))="@"           ; Default Variable Input
                    if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YI.get(),1)),m$.var("Y").get(),15)),"@")) {
                      break;
                    }
                    //<< . . . ;
                    //<< . . . ;SR18145 write YCR," var objcontrol=document."_YHTMFORM_".Y"_YFORM_"P"_YI_";"
                    //<< . . . ;SR18145 write " if(objcontrol.type!='hidden' && !objcontrol.disabled) {objcontrol.focus();}"
                    //<< . . . write YCR, "ControlSetFocus('Y"_YFORM_"P"_YI_"');"     ;SR18145
                    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ControlSetFocus('Y",m$.var("YFORM").get()),"P"),YI.get()),"');"));
                    //<< . . . SET YQ=1
                    YQ.set(1);
                  } while (false);
                }
              }
            }
            //<< . . QUIT:YQ=1
            if (mOp.Equal(YQ.get(),1)) {
              break;
            }
            //<< . . ;-----------------------------------
            //<< . . ;
            //<< . . IF YFOART=3 SET YI=$ORDER(^WWW121(0,YFORM,""),-1) IF YI'="" IF $PIECE(YKEY,",",YI)="" DO   ;FOKUS BEI GRID ;focus next to
            if (mOp.Equal(m$.var("YFOART").get(),3)) {
              YI.set(m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YFORM").get(),""),mOp.Negative(1)));
              if (mOp.NotEqual(YI.get(),"")) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) {
                  do {
                    //<< . . . QUIT:$PIECE($GET(^WWW121(0,YFORM,YI,1)),Y,16)'=""                      ; Fixed Input For Hidden Field
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YI.get(),1)),m$.var("Y").get(),16),"")) {
                      break;
                    }
                    //<< . . . QUIT:$PIECE($GET(^WWW121(0,YFORM,YI,1)),Y,104)=15                      ; Hidden
                    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YI.get(),1)),m$.var("Y").get(),104),15)) {
                      break;
                    }
                    //<< . . . IF $GET(YDATEI)'="" QUIT:+$PIECE($GET(^WWW002(0,YDATEI,YI,1)),Y,3)=0   ; Hidden
                    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDATEI")),"")) {
                      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),YI.get(),1)),m$.var("Y").get(),3)),0)) {
                        break;
                      }
                    }
                    //<< . . . QUIT:$EXTRACT($PIECE($GET(^WWW121(0,YFORM,YI,1)),Y,15))="@"            ; Default Variable Input
                    if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YI.get(),1)),m$.var("Y").get(),15)),"@")) {
                      break;
                    }
                    //<< . . . ;
                    //<< . . . ;SR18145 write YCR," var objcontrol=document."_YHTMFORM_".Y"_YFORM_"P"_YI_";"
                    //<< . . . ;SR18145 write " if(objcontrol.type!='hidden' && !objcontrol.disabled) {objcontrol.focus();}"
                    //<< . . . write YCR, "ControlSetFocus('Y"_YFORM_"P"_YI_"');"     ;SR18145
                    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ControlSetFocus('Y",m$.var("YFORM").get()),"P"),YI.get()),"');"));
                    //<< . . . SET YQ=1
                    YQ.set(1);
                  } while (false);
                }
              }
            }
            //<< . . QUIT:YQ=1
            if (mOp.Equal(YQ.get(),1)) {
              break;
            }
            //<< . . ;-----------------------------------
            //<< . . ;
            //<< . . new idClassFld,objFormData
            mVar idClassFld = m$.var("idClassFld");
            mVar objFormData = m$.var("objFormData");
            m$.newVarBlock(2,idClassFld,objFormData);
            //<< . . SET YI=""
            YI.set("");
            //<< . . FOR  SET YI=$ORDER(^WWW122(0,YFORM,YI)) QUIT:YI=""  QUIT:YQ=1  DO   ;FOKUS AUF ERSTES FELD ;focus upon premier field
            for (;true;) {
              YI.set(m$.Fnc.$order(m$.var("^WWW122",0,m$.var("YFORM").get(),YI.get())));
              if (mOp.Equal(YI.get(),"")) {
                break;
              }
              if (mOp.Equal(YQ.get(),1)) {
                break;
              }
              do {
                //<< . . . set objFormData = $get(^WWW122(0,YFORM,YI,1))
                objFormData.set(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YI.get(),1)));
                //<< . . . QUIT:$PIECE(objFormData,Y,60)'=YSEITE  ; Wrong Tab
                if (mOp.NotEqual(m$.Fnc.$piece(objFormData.get(),m$.var("Y").get(),60),m$.var("YSEITE").get())) {
                  break;
                }
                //<< . . . QUIT:+$PIECE(objFormData,Y,81)'=0      ; Inner Page Tags
                if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(objFormData.get(),m$.var("Y").get(),81)),0)) {
                  break;
                }
                //<< . . .;QUIT:$PIECE(objFormData,Y,32)'=""      ; Relation Class
                //<< . . . QUIT:$PIECE(objFormData,Y,50)'=""      ; Only Show If Option (YOPTION)
                if (mOp.NotEqual(m$.Fnc.$piece(objFormData.get(),m$.var("Y").get(),50),"")) {
                  break;
                }
                //<< . . . QUIT:$PIECE(objFormData,Y,51)'=""      ; Display Item Only When Menu Parameter
                if (mOp.NotEqual(m$.Fnc.$piece(objFormData.get(),m$.var("Y").get(),51),"")) {
                  break;
                }
                //<< . . . QUIT:$PIECE(objFormData,Y,2)=2         ; Radio (vertical
                if (mOp.Equal(m$.Fnc.$piece(objFormData.get(),m$.var("Y").get(),2),2)) {
                  break;
                }
                //<< . . . QUIT:$PIECE(objFormData,Y,2)=15        ; Hidden
                if (mOp.Equal(m$.Fnc.$piece(objFormData.get(),m$.var("Y").get(),2),15)) {
                  break;
                }
                //<< . . . QUIT:$PIECE(objFormData,Y,2)=11        ; Radio (horizontal)
                if (mOp.Equal(m$.Fnc.$piece(objFormData.get(),m$.var("Y").get(),2),11)) {
                  break;
                }
                //<< . . . QUIT:$PIECE(objFormData,Y,5)=5         ; Password
                if (mOp.Equal(m$.Fnc.$piece(objFormData.get(),m$.var("Y").get(),5),5)) {
                  break;
                }
                //<< . . . IF $GET(YDATEI)'="" QUIT:$PIECE($GET(^WWW003(0,YDATEI,YI,1)),Y,3)=0    ;hidden
                if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDATEI")),"")) {
                  if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),YI.get(),1)),m$.var("Y").get(),3),0)) {
                    break;
                  }
                }
                //<< . . . set idClassFld = $piece(objFormData,Y,1)
                idClassFld.set(m$.Fnc.$piece(objFormData.get(),m$.var("Y").get(),1));
                //<< . . . IF (YKEY="")||(YFOART=3) IF $DATA(^WWW121(0,YFORM)) IF idClassFld'="" do  quit
                if ((mOp.Equal(m$.var("YKEY").get(),"")) || (mOp.Equal(m$.var("YFOART").get(),3))) {
                  if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YFORM").get())))) {
                    if (mOp.NotEqual(idClassFld.get(),"")) {
                      //<< . . . . ;SR18145 write YCR," var objcontrol=document."_YHTMFORM_".Y"_YFORM_"D"_idClassFld_";"
                      //<< . . . . ;SR18145 write " if(objcontrol.type!='hidden' && !objcontrol.disabled) {objcontrol.focus();}"
                      //<< . . . . write YCR, "ControlSetFocus('Y"_YFORM_"D"_idClassFld_"');"     ;SR18145
                      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ControlSetFocus('Y",m$.var("YFORM").get()),"D"),idClassFld.get()),"');"));
                      //<< . . . . SET YQ=1
                      YQ.set(1);
                      break;
                    }
                  }
                }
                //<< . . . if (idClassFld="") && ($piece(objFormData,Y,32)="") do  quit
                if ((mOp.Equal(idClassFld.get(),"")) && (mOp.Equal(m$.Fnc.$piece(objFormData.get(),m$.var("Y").get(),32),""))) {
                  //<< . . . . ;SR18145 write YCR," var objcontrol=document."_YHTMFORM_".Y"_YFORM_"M"_YI_";"
                  //<< . . . . ;SR18145 write " if(!objcontrol.readOnly && objcontrol.type!='hidden' && !objcontrol.disabled) {objcontrol.focus();}"
                  //<< . . . . write YCR, "ControlSetFocus('Y"_YFORM_"M"_YI_"');"     ;SR18145
                  m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ControlSetFocus('Y",m$.var("YFORM").get()),"M"),YI.get()),"');"));
                  //<< . . . . SET YQ=1
                  YQ.set(1);
                  break;
                }
              } while (false);
            }
          } while (false);
        }
        m$.restoreVarBlock(2);
      }
      //<< . ;=====================================
      //<< . ;
      //<< . IF X=3 IF (YOPTION'="") || ( (YOPTION="") && '$DATA(^WWW1210(0,YFORM)) ) DO   ;FOCUS AUF DAS ERSTE FELD ;upon who premier field
      if (mOp.Equal(m$.var("X").get(),3)) {
        if ((mOp.NotEqual(m$.var("YOPTION").get(),"")) || mOp.Logical(((mOp.Equal(m$.var("YOPTION").get(),"")) && mOp.Not(m$.Fnc.$data(m$.var("^WWW1210",0,m$.var("YFORM").get())))))) {
          do {
            //<< . . QUIT:$GET(YAENBER)=5  ;NUR LESEBERECHTIGUNG;CHECK LESEBERECHTIGUNG;TYBD;04,07,2003;23883;
            if (mOp.Equal(m$.Fnc.$get(m$.var("YAENBER")),5)) {
              break;
            }
            //<< . . WRITE YCR," document.WWW.YAUSWAHL.focus();"
            m$.Cmd.Write(m$.var("YCR").get()," document.WWW.YAUSWAHL.focus();");
          } while (false);
        }
      }
      //<< . ;
      //<< . ;IF $PIECE($GET(^WWWUSER(0,YUSER,1)),Y,15)'="" WRITE YCR," document.location='#TARGET';"
      //<< . IF ONLOAD=$$$YES WRITE """"                                ;ENDE ONLOAD ;termination
      if (mOp.Equal(ONLOAD.get(),include.COMSYS.$$$YES(m$))) {
        m$.Cmd.Write("\"");
      }
      //<< . ;
      //<< . ; NOTE : scroll is only recognised by MSIE
      //<< . ;WRITE " style=""margin: 0px; opacity:0;"" scroll=""auto"">"
      //<< . ;CORE-116 WRITE " style=""margin: 0px; "" scroll=""auto"">"
      //<< . if ('YFIXHEADER)||(YUSERAGENT'="MSIE") do ;CORE-116
      if ((mOp.Not(m$.var("YFIXHEADER").get())) || (mOp.NotEqual(m$.var("YUSERAGENT").get(),"MSIE"))) {
        //<< . . WRITE " style=""margin: 0px; "" scroll=""auto"">"
        m$.Cmd.Write(" style=\"margin: 0px; \" scroll=\"auto\">");
      }
      //<< . if (YFIXHEADER)&&(YUSERAGENT="MSIE") do ;CORE-116
      if (mOp.Logical((m$.var("YFIXHEADER").get())) && (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE"))) {
        //<< . . ;CORE-116.3 WRITE " style=""margin: 0px; overflow:hidden;"">"  ;CORE-116
        //<< . . WRITE " style=""margin: 0px; overflow-x:auto; overflow-y:hidden;"">"  ;CORE-116 ;CORE-116.3
        m$.Cmd.Write(" style=\"margin: 0px; overflow-x:auto; overflow-y:hidden;\">");
      }
      //<< 
      //<< 
      //<< .;
      //<< .;-------------------------------------- end <BODY>
      //<< .;
      //<< . WRITE "<div id=""MASTER"">"                           ; SR17408   ; (default - visible)
      m$.Cmd.Write("<div id=\"MASTER\">");
      //<< . if YFORM="COMViewSearch" do ;CORE-116.2
      if (mOp.Equal(m$.var("YFORM").get(),"COMViewSearch")) {
        //<< . . write $$GetMegaMenu^WWWMegaMenu($get(YKOPF)) ;SR17998; CORE-107 ;CORE-116
        m$.Cmd.Write(m$.fnc$("WWWMegaMenu.GetMegaMenu",m$.Fnc.$get(m$.var("YKOPF"))));
      }
      //<< . do SetupStyle^WWWFORMCrossBrowserSupport()  ;SR17871 ;CORE-116.2
      m$.Cmd.Do("WWWFORMCrossBrowserSupport.SetupStyle");
    }
    //<< ;. WRITE "<div id=""MASTER"" style='overflow:hidden'>"
    //<< 
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< WRITE "<FONT"
    m$.Cmd.Write("<FONT");
    //<< IF $PIECE(YVOR,Y,9)'="" WRITE " FACE="""_$PIECE($GET(^WWW100(0,"SCHRIFTART",SPRACHE,$PIECE(YVOR,Y,9),1)),Y,1)_""""
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),9),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" FACE=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),9),1)),m$.var("Y").get(),1)),"\""));
    }
    //<< IF $PIECE(YVOR,Y,7)'="" WRITE " SIZE="""_$PIECE(YVOR,Y,7)_""""
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\""));
    }
    //<< IF $PIECE(YVOR,Y,6)'="" WRITE " COLOR="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR,Y,6),1)),Y,1)_""""
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),6),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" COLOR=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),6),1)),m$.var("Y").get(),1)),"\""));
    }
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< 
    //<< WRITE YCR,"<TEMPLATEPRINTER HEADER="""" FOOTER="""" />"
    m$.Cmd.Write(m$.var("YCR").get(),"<TEMPLATEPRINTER HEADER=\"\" FOOTER=\"\" />");
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< IF $GET(YPRINT)=1 DO
    if (mOp.Equal(m$.Fnc.$get(m$.var("YPRINT")),1)) {
      do {
        //<< . QUIT:$GET(YBACKBUTTON)=1    ;NUR EINMAL DRUCKEN ;only sometimes print
        if (mOp.Equal(m$.Fnc.$get(m$.var("YBACKBUTTON")),1)) {
          break;
        }
        //<< . SET YBACKBUTTON=1           ;GEDRUCKT
        mVar YBACKBUTTON = m$.var("YBACKBUTTON");
        YBACKBUTTON.set(1);
        //<< . WRITE YCR,"<style type='text/css' media=""print"">"
        m$.Cmd.Write(m$.var("YCR").get(),"<style type='text/css' media=\"print\">");
        //<< . WRITE YCR," .noprint { display:none; }"
        m$.Cmd.Write(m$.var("YCR").get()," .noprint { display:none; }");
        //<< . WRITE YCR,"</style>"
        m$.Cmd.Write(m$.var("YCR").get(),"</style>");
        //<< . WRITE YCR,"<div class=""noprint"">"_YCR
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat("<div class=\"noprint\">",m$.var("YCR").get()));
        //<< . ;
        //<< . ; Forms In HTA Mode
        //<< . IF $PIECE($GET(^WWW012(0,YM,1)),Y,117)'=$$$YES DO
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),117),include.COMSYS.$$$YES(m$))) {
          //<< . . WRITE "<A class=link onClick='history.back()'>"_YCR
          m$.Cmd.Write(mOp.Concat("<A class=link onClick='history.back()'>",m$.var("YCR").get()));
          //<< . . WRITE "<img src="_YGIF_"hback.gif border=0 TITLE="""_$$^WWWTEXT(99)_"""></A>"  ;ZURÜCK ;retro-  ;back
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<img src=",m$.var("YGIF").get()),"hback.gif border=0 TITLE=\""),m$.fnc$("WWWTEXT.main",99)),"\"></A>"));
        }
        //<< . ;
        //<< . IF $PIECE($GET(^WWW012(0,YM,1)),Y,117)=$$$YES DO
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),117),include.COMSYS.$$$YES(m$))) {
          //<< . . WRITE "<A HREF="""
          m$.Cmd.Write("<A HREF=\"");
          //<< . . WRITE YAKTION_"EP=WWWFORM&amp;YFORM=WWWBLANK"
          m$.Cmd.Write(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM=WWWBLANK"));
          //<< . . WRITE """>"
          m$.Cmd.Write("\">");
          //<< . . WRITE YCR,"<IMG SRC="""_YGIF_"end.gif""  "_YHEIGHT_" "_YWIDTH_" TITLE="""_$$^WWWTEXT(10)_""" border=0>"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"end.gif\"  "),m$.var("YHEIGHT").get())," "),m$.var("YWIDTH").get())," TITLE=\""),m$.fnc$("WWWTEXT.main",10)),"\" border=0>"));
          //<< . . WRITE "</A>"
          m$.Cmd.Write("</A>");
        }
        //<< . ;
        //<< . WRITE "</div>",YCR
        m$.Cmd.Write("</div>",m$.var("YCR").get());
      } while (false);
    }
    //<< 
    //<< do OnUnLoad() // SR14420: Please do not remove from here, we need the YKEY and YFORM and they are both defined at this point.
    m$.Cmd.Do("OnUnLoad");
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< MANU
  public void MANU() {
    //<< ;--------------------------------------------------------------------------------
    //<< ;   MANUELLE VORGABE ;default
    //<< ;
    //<< ;   WARNING : YVOR is populated from company default (WWW012) rather than form default (WWW120)
    //<< ;
    //<< ; History:
    //<< ; 22-May-2013   shobby  CORE-107.2: Show Mega Menu on MANU forms.
    //<< ; 04-May-2007   RPW     SR15511: Fixed code structure for WWWUSER checks
    //<< ; 04-May-2007   GRF     SR15511: comment out obsolete length test; use strLinkColour;
    //<< ;                           convert some dot levels to braces; reorganise
    //<< ;                           window.setTimeout tests;
    //<< ; 19-Dec-2006   JW      BR014262: Menu type 6 has been removed
    //<< ; 10-Aug-2006   JW      SR13836: Default context menu
    //<< ;--------------------------------------------------------------------------------
    //<< new objUser
    mVar objUser = m$.var("objUser");
    m$.newVar(objUser);
    //<< 
    //<< DO ^WWWVORG
    m$.Cmd.Do("WWWVORG.main");
    //<< 
    //<< SET YVOR=$GET(^WWW012(0,YM,1))
    mVar YVOR = m$.var("YVOR");
    YVOR.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< 
    //<< IF $PIECE($GET(^WWW013(0,YBED,1)),Y,49)=998 NEW YVORX SET YVORX=YVOR NEW YVOR DO  ;USER = INTERNETLOGIN;FIS;15.12.2004
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)),m$.var("Y").get(),49),998)) {
      mVar YVORX = m$.var("YVORX");
      m$.newVar(YVORX);
      YVORX.set(YVOR.get());
      m$.newVar(YVOR);
      //<< . SET YVOR=YVORX
      YVOR.set(YVORX.get());
      //<< . SET $PIECE(YVOR,Y,5)=""  ;KEINE HINTERGRUNDFARBE
      m$.pieceVar(YVOR,m$.var("Y").get(),5).set("");
    }
    //<< 
    //<< ;IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* BODY (MANU^WWWBODY)************************* -->",YCR,YCR
    //<< 
    //<< if ($get(YFORM)'="") && (YUSER'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.NotEqual(m$.var("YUSER").get(),""))) {
      //<< set objUser=$get(^WWWUSER(0,YUSER,1))
      objUser.set(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)));
      //<< if ($$$WWWUSERLastForm(objUser)'=YFORM) || ($$$WWWUSERLastFormpage(objUser)'=$get(YSEITE)) {
      if ((mOp.NotEqual(include.WWWConst.$$$WWWUSERLastForm(m$,objUser),m$.var("YFORM").get())) || (mOp.NotEqual(include.WWWConst.$$$WWWUSERLastFormpage(m$,objUser),m$.Fnc.$get(m$.var("YSEITE"))))) {
        //<< set $$$WWWUSERLastFormfield(^WWWUSER(0,YUSER,1))=""
        include.WWWConst.$$$WWWUSERLastFormfieldSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< //DO:YUSER=""  IF YUSER'="" IF +$PIECE($GET(^WWWUSER(0,YUSER,1)),Y,6)=$$$NO DO
    //<< IF (YUSER="") ! ((YUSER'="") & (+$PIECE($GET(^WWWUSER(0,YUSER,1)),Y,6)=$$$NO)) DO
    if (mOp.Logical(mOp.Or((mOp.Equal(m$.var("YUSER").get(),"")),(mOp.And((mOp.NotEqual(m$.var("YUSER").get(),"")),(mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),m$.var("Y").get(),6)),include.COMSYS.$$$NO(m$)))))))) {
      //<< . IF YUSER'="" SET $PIECE(^WWWUSER(0,YUSER,1),Y,6)=$$$YES
      if (mOp.NotEqual(m$.var("YUSER").get(),"")) {
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),6).set(include.COMSYS.$$$YES(m$));
      }
      //<< . WRITE "<BODY"
      m$.Cmd.Write("<BODY");
      //<< . if $$$CONTEXT write " oncontextmenu=' DisplayContext(); return false; ' " //SR13836
      if (mOp.Logical(include.COMSYS.$$$CONTEXT(m$))) {
        m$.Cmd.Write(" oncontextmenu=' DisplayContext(); return false; ' ");
      }
      //<< . ;
      //<< . IF $PIECE(YVOR,Y,3)'=""                    WRITE YCR," BACKGROUND="""_YGIF_$PIECE(YVOR,Y,3)_""""
      if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),3),"")) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(" BACKGROUND=\"",m$.var("YGIF").get()),m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),3)),"\""));
      }
      //<< . IF $PIECE(YVOR,Y,4)=$$$YES                 WRITE YCR," BGPROPERTIES=fixed"
      if (mOp.Equal(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),4),include.COMSYS.$$$YES(m$))) {
        m$.Cmd.Write(m$.var("YCR").get()," BGPROPERTIES=fixed");
      }
      //<< . IF $PIECE(YVOR,Y,5)'="" IF $GET(YPRINT)'=1 WRITE YCR," BGCOLOR="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR,Y,5),1)),Y,1)_""""
      if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),5),"")) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YPRINT")),1)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" BGCOLOR=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),5),1)),m$.var("Y").get(),1)),"\""));
        }
      }
      //<< . ;
      //<< . ; SCREENÄNDER    ;FOCUS SETZTEN
      //<< . if ($get(YSCREENM)'=1) && ($get(NOPRINT)'="NOPRINT") do
      if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YSCREENM")),1)) && (mOp.NotEqual(m$.Fnc.$get(m$.var("NOPRINT")),"NOPRINT"))) {
        //<< . . if $get(YUSERAGENT)="MSIE" do
        if (mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) {
          do {
            //<< . . . if $get(YPRINT)=1                                                      write YCR," onLoad=""window.setTimeout('document.body.focus(); window.print();',10); """ quit
            if (mOp.Equal(m$.Fnc.$get(m$.var("YPRINT")),1)) {
              m$.Cmd.Write(m$.var("YCR").get()," onLoad=\"window.setTimeout('document.body.focus(); window.print();',10); \"");
              break;
            }
            //<< . . . if ($get(YFORM)'="") && ($piece($get(^WWW120(0,YFORM,1)),Y,85)=$$$YES) write YCR," onLoad=""window.setTimeout('document.body.focus(); window.print();',10); """      ;automatisches drucken beim laden
            if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),85),include.COMSYS.$$$YES(m$)))) {
              m$.Cmd.Write(m$.var("YCR").get()," onLoad=\"window.setTimeout('document.body.focus(); window.print();',10); \"");
            }
          } while (false);
        }
        //<< . . if $get(YUSERAGENT)'="MSIE" do
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) {
          do {
            //<< . . . if $get(YPRINT)=1                                                      write YCR," onLoad=""window.setTimeout('window.print()',10); """ quit
            if (mOp.Equal(m$.Fnc.$get(m$.var("YPRINT")),1)) {
              m$.Cmd.Write(m$.var("YCR").get()," onLoad=\"window.setTimeout('window.print()',10); \"");
              break;
            }
            //<< . . . if ($get(YFORM)'="") && ($piece($get(^WWW120(0,YFORM,1)),Y,85)=$$$YES) write YCR," onLoad=""window.setTimeout('window.print()',10); """
            if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),85),include.COMSYS.$$$YES(m$)))) {
              m$.Cmd.Write(m$.var("YCR").get()," onLoad=\"window.setTimeout('window.print()',10); \"");
            }
          } while (false);
        }
      }
      //<< . ;
      //<< . ;  LINKS IN MANDANTENFARBEN ANZEIGEN
      //<< . if $piece(YVOR,Y,12)'="" do
      if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),12),"")) {
        //<< . . new strLinkColour
        mVar strLinkColour = m$.var("strLinkColour");
        m$.newVarBlock(2,strLinkColour);
        //<< . . set strLinkColour = $piece($get(^WWW100(0,"FARBE",SPRACHE,$piece(YVOR,Y,12),1)),Y,1)
        strLinkColour.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),12),1)),m$.var("Y").get(),1));
        //<< . . write YCR," LINK="""_strLinkColour_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" LINK=\"",strLinkColour.get()),"\""));
        //<< . . write YCR," ALINK="""_strLinkColour_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" ALINK=\"",strLinkColour.get()),"\""));
        //<< . . write YCR," VLINK="""_strLinkColour_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" VLINK=\"",strLinkColour.get()),"\""));
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . WRITE YCR," topmargin=1"," leftmargin=1",">"
      m$.Cmd.Write(m$.var("YCR").get()," topmargin=1"," leftmargin=1",">");
    }
    //<< 
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< WRITE "<FONT"
    m$.Cmd.Write("<FONT");
    //<< IF $PIECE(YVOR,Y,9)'="" WRITE " FACE="""_$PIECE($GET(^WWW100(0,"SCHRIFTART",SPRACHE,$PIECE(YVOR,Y,9),1)),Y,1)_""""
    if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),9),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" FACE=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),9),1)),m$.var("Y").get(),1)),"\""));
    }
    //<< IF $PIECE(YVOR,Y,7)'="" WRITE " SIZE="""_$PIECE(YVOR,Y,7)_""""
    if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),7),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" SIZE=\"",m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),7)),"\""));
    }
    //<< IF $PIECE(YVOR,Y,6)'="" WRITE " COLOR="""_$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,$PIECE(YVOR,Y,6),1)),Y,1)_""""
    if (mOp.NotEqual(m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),6),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" COLOR=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),6),1)),m$.var("Y").get(),1)),"\""));
    }
    //<< 
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< write $$GetMegaMenu^WWWMegaMenu($get(YKOPF),$$$YES) ;SR17998     ;CORE-107.2
    m$.Cmd.Write(m$.fnc$("WWWMegaMenu.GetMegaMenu",m$.Fnc.$get(m$.var("YKOPF")),include.COMSYS.$$$YES(m$)));
    //<< WRITE YCR,"<TEMPLATEPRINTER HEADER="""" FOOTER="""" />",YCR
    m$.Cmd.Write(m$.var("YCR").get(),"<TEMPLATEPRINTER HEADER=\"\" FOOTER=\"\" />",m$.var("YCR").get());
    //<< QUIT
    return;
  }

  //<< 
  //<< OnBeforeUnload()
  public Object OnBeforeUnload(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check for changes before unloading page.
    //<< ; NOTE: If in development, can 'mute' dialog if hold down control.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Dec-2008   FIS     SR16205: no onunload in PDA's
    //<< ; 05-Jun-2007   HeberB  SR15522: Put printing javascript functions on sub-routines
    //<< ; 22-Jan-2007   JW      SR14235: Fixed case error in addwindow.
    //<< ; 21-Dec-2006   JW      SR14235: changes attribute now on parent window. Added subWindow.
    //<< ; 06-Dec-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnIsMobile
    mVar blnIsMobile = m$.var("blnIsMobile");
    m$.newVar(blnIsMobile);
    //<< 
    //<< ;SR16205 vvvvv
    //<< set blnIsMobile = $$$NO
    blnIsMobile.set(include.COMSYS.$$$NO(m$));
    //<< if ($get(%request) '= "") && ( $find($get(%request.CgiEnvs("HTTP_USER_AGENT")),"Windows CE")) {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),"")) && mOp.Logical((m$.Fnc.$find(m$.Fnc.$get(m$.getRequest().getCgiEnvs("HTTP_USER_AGENT")),"Windows CE")))) {
      //<< set blnIsMobile = $$$YES
      blnIsMobile.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< ;^^^^^^^
    //<< 
    //<< if (blnIsMobile '= $$$YES) {
    if ((mOp.NotEqual(blnIsMobile.get(),include.COMSYS.$$$YES(m$)))) {
      //<< do PrintsubWindow()
      m$.Cmd.Do("PrintsubWindow");
      //<< do PrintdoLink()
      m$.Cmd.Do("PrintdoLink");
      //<< do PrintUnloadConfirm()
      m$.Cmd.Do("PrintUnloadConfirm");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PrintsubWindow()
  public Object PrintsubWindow(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 05-Jun-2007   HeberB  SR13195: Copied from OnBeforeUnload
    //<< ;-------------------------------------------------------------------------------
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write "function subWindow(pstrUrl,pstrWindow,pstrExtra) { "     // Need exception handling, because "Discard Changes"
    m$.Cmd.Write("function subWindow(pstrUrl,pstrWindow,pstrExtra) { ");
    //<< write " try { "                                                 // dialogue may stop popup, causing error.
    m$.Cmd.Write(" try { ");
    //<< write "     if (pstrWindow==undefined) pstrWindow=''; "
    m$.Cmd.Write("     if (pstrWindow==undefined) pstrWindow=''; ");
    //<< write "     if (pstrExtra==undefined) pstrExtra=''; "
    m$.Cmd.Write("     if (pstrExtra==undefined) pstrExtra=''; ");
    //<< write "     parent.addWindow(window.open(pstrUrl,pstrWindow,pstrExtra)); "
    m$.Cmd.Write("     parent.addWindow(window.open(pstrUrl,pstrWindow,pstrExtra)); ");
    //<< write " } catch(e) { } "
    m$.Cmd.Write(" } catch(e) { } ");
    //<< write "} "
    m$.Cmd.Write("} ");
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PrintdoLink()
  public Object PrintdoLink(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 05-Jun-2007   HeberB  SR13195: Copied from OnBeforeUnload
    //<< ;-------------------------------------------------------------------------------
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write "function doLink(elem) { "
    m$.Cmd.Write("function doLink(elem) { ");
    //<< write "     eval(unescape(elem.href));"
    m$.Cmd.Write("     eval(unescape(elem.href));");
    //<< write "     return false;"
    m$.Cmd.Write("     return false;");
    //<< write "} "
    m$.Cmd.Write("} ");
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PrintUnloadConfirm()
  public Object PrintUnloadConfirm(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; ByRefs: YFORM
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2012   shobby  SR17790: Disable 'Save changes' prompt if closing app from timeout.
    //<< ; 07-Sep-2011   shobby  SR17894: RemoveLockingInterest
    //<< ; 19-Oct-2010   GRF     SR17525: define ver as variable in case using FF and not
    //<< ;                           getting from appVersion
    //<< ; 26-Aug-2010   shobby  SR17525: Crashes in firefox because the structure of
    //<< ;                           appversion is different.
    //<< ; 14-Apr-2010   SRC     SR17253: Use passed in 'e' for event.
    //<< ; 16-Oct-2008   FIS     SR15878: Close Save Layer if 'Discard Changes' message appears
    //<< ; 24-Jul-2007   RPW     SRBR014600: Before we unload store the current width & height
    //<< ; 05-Jun-2007   HeberB  SR13195: Copied from OnBeforeUnload
    //<< ;-------------------------------------------------------------------------------
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write "function UnloadConfirm(e) { ",!
    m$.Cmd.Write("function UnloadConfirm(e) { ","\n");
    //<< if YFORM="COMViewSearch" {
    if (mOp.Equal(m$.var("YFORM").get(),"COMViewSearch")) {
      //<< write "var ver;"
      m$.Cmd.Write("var ver;");
      //<< write "var intWidth=document.body.clientWidth;",!
      m$.Cmd.Write("var intWidth=document.body.clientWidth;","\n");
      //<< write "var intHeight=document.body.clientHeight;",!
      m$.Cmd.Write("var intHeight=document.body.clientHeight;","\n");
      //<< write "if (navigator.appVersion.split(' ')[3]) {"                        ; SR17525
      m$.Cmd.Write("if (navigator.appVersion.split(' ')[3]) {");
      //<< write "   ver=navigator.appVersion.split(' ')[3].split(';')[0];",!
      m$.Cmd.Write("   ver=navigator.appVersion.split(' ')[3].split(';')[0];","\n");
      //<< write "}"
      m$.Cmd.Write("}");
      //<< //  IE6 calculates different from IE7. Slight Kludge
      //<< write "if (ver=='6.0') { intWidth+=8; intHeight+=27 }",!
      m$.Cmd.Write("if (ver=='6.0') { intWidth+=8; intHeight+=27 }","\n");
      //<< write "if (CallBackNow !== undefined) { CallBackNow('StoreSize^COMViewSession',intWidth,intHeight);}",!
      m$.Cmd.Write("if (CallBackNow !== undefined) { CallBackNow('StoreSize^COMViewSession',intWidth,intHeight);}","\n");
    }
    //<< }
    //<< 
    //<< write "if (document.WWW!==undefined && document.WWW.YBEARB!=null "
    m$.Cmd.Write("if (document.WWW!==undefined && document.WWW.YBEARB!=null ");
    //<< ; SR17253 if $$$DEVMODE write "&& !event.ctrlKey "
    //<< if $$$DEVMODE write "&& !e.ctrlKey " ; SR17253
    if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
      m$.Cmd.Write("&& !e.ctrlKey ");
    }
    //<< 
    //<< write " && parent.window.changes) { ",!
    m$.Cmd.Write(" && parent.window.changes) { ","\n");
    //<< ;SR17253 write " var e;"            ,!                                  // dialogue may stop popup, causing error.
    //<< ;SR17253 write "    e=window.event;",!
    //<< write " e.cancelBubble=true; ",!
    m$.Cmd.Write(" e.cancelBubble=true; ","\n");
    //<< ;SR17790
    //<< write " if (typeof(CSPEnding) == 'undefined') {"  ;CORE-70
    m$.Cmd.Write(" if (typeof(CSPEnding) == 'undefined') {");
    //<< write "    alert('CSPEnding is null');"
    m$.Cmd.Write("    alert('CSPEnding is null');");
    //<< write " } else if (!CSPEnding) {"                                                               ;SR17790
    m$.Cmd.Write(" } else if (!CSPEnding) {");
    //<< write "    e.returnValue='"_$$$Text("WWW00034")_"'; ",!  ; "Discard Changes?"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("    e.returnValue='",include.COMSYS.$$$Text(m$,"WWW00034")),"'; "),"\n");
    //<< write " }"                                                                                  ;SR17790
    m$.Cmd.Write(" }");
    //<< write " if (typeof(SaveAction) == 'function') {window.setTimeout('SaveAction(0)',1);} ",!  ;SR15878 ;close save layer
    m$.Cmd.Write(" if (typeof(SaveAction) == 'function') {window.setTimeout('SaveAction(0)',1);} ","\n");
    //<< 
    //<< write "}"
    m$.Cmd.Write("}");
    //<< if '$$$NoKey(YKEY) {                                                                        ;SR17894
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,m$.var("YKEY")))) {
      //<< write "if (!e.cancelBubble) {;"                                                         ;SR17894
      m$.Cmd.Write("if (!e.cancelBubble) {;");
      //<< write "  if (typeof(CallBackNow) != 'undefined') {"                                     ;SR17894
      m$.Cmd.Write("  if (typeof(CallBackNow) != 'undefined') {");
      //<< write "    if (top.document.readyState != 'loading') {"   ;SR16758                      ;SR17894
      m$.Cmd.Write("    if (top.document.readyState != 'loading') {");
      //<< write "      CallBackNow('RemoveLockingInterest^COMLock','"_YFORM_"','"_YKEY_"');"      ;SR17894
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("      CallBackNow('RemoveLockingInterest^COMLock','",m$.var("YFORM").get()),"','"),m$.var("YKEY").get()),"');"));
      //<< write "    }"                                                                           ;SR17894
      m$.Cmd.Write("    }");
      //<< write "  }"                                                                             ;SR17894
      m$.Cmd.Write("  }");
      //<< write "  if (typeof(pobjWin) == 'object') pobjWin.document.body.onunload = '';"         ;SR17894
      m$.Cmd.Write("  if (typeof(pobjWin) == 'object') pobjWin.document.body.onunload = '';");
      //<< write "}"                                                                               ;SR17894
      m$.Cmd.Write("}");
    }
    //<< }                                                                                           ;SR17894
    //<< write "}"
    m$.Cmd.Write("}");
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< ;--------------------------------------- ^^^^^
  //<< ; Windows Internet Explorer
  //<< ; Are you sure you want to navigate away from this page?
  //<< ;
  //<< ; Discard Changes?
  //<< ;
  //<< ; Press OK to continue, or Cancel to stay on the current page.
  //<< ;---------------------------------------
  //<< 
  //<< 
  //<< OnUnLoad()
  public Object OnUnLoad(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; When unloading the form, check to see if the system is interested in locking
    //<< ; and if so, remove uneeded locks.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Sep-2011   shobby  SR17894: Moved the code to PrintUnloadConfirm
    //<< ; 07-Aug-2009   shobby  SR16758: Don't do the call back if the browser is
    //<< ;                           closing or we are returning to the login form as the
    //<< ;                           session won't exist.
    //<< ; 04-Sep-2006   PO      SR14420: Provided with a window object remove unload calls
    //<< ;                           ***** 04-Sep-2006 Change will remove all calls
    //<< ;                           ***** whether to UnloadEvent or not
    //<< ; 09-Aug-2006   RPW/SCH SRBR014167: We don't need to worry about whether the
    //<< ;                           CacheTemp exists, just call it.
    //<< ; 23-May-2006   PO      SR14427: Only perform callback if function exists.
    //<< ; 09-May-2006   RPW     SR14420: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YHYPER
    mVar YHYPER = m$.var("YHYPER");
    m$.newVar(YHYPER);
    //<< 
    //<< set YHYPER=0
    YHYPER.set(0);
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< 
    //<< ;do EventValue^WWWFORMJavascript()
    //<< write "function UnloadEvent(pobjWin) {"
    m$.Cmd.Write("function UnloadEvent(pobjWin) {");
    //<< ;SR17894 if '$$$NoKey(YKEY) {
    //<< ;SR17894    write "if (typeof(CallBackNow) != 'undefined') {"
    //<< ;SR17894    write "  if (top.document.readyState != 'loading') {"   ;SR16758
    //<< ;SR17894    write "    CallBackNow('RemoveLockingInterest^COMLock','"_YFORM_"','"_YKEY_"');"
    //<< ;SR17894    write "  }"
    //<< ;SR17894    write "}"
    //<< ;SR17894    write "if (typeof(pobjWin) == 'object') pobjWin.document.body.onunload = '';"
    //<< ;SR17894 }
    //<< write "}"
    m$.Cmd.Write("}");
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

//<< 
//<< 
}
