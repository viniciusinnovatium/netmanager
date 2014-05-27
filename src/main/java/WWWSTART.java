//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSTART
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:03
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

//<< WWWSTART(YTITLE,YEXIT,YREFR,YNOOPEN,HTA)
public class WWWSTART extends mClass {

  //<< 
  //<< #define jsMarker(%1)
  public static Object $$$jsMarker(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public Object main(Object ... _p) {
    mVar YTITLE = m$.newVarRef("YTITLE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YEXIT = m$.newVarRef("YEXIT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YREFR = m$.newVarRef("YREFR",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YNOOPEN = m$.newVarRef("YNOOPEN",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar HTA = m$.newVarRef("HTA",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    return _WWWSTART(YTITLE,YEXIT,YREFR,YNOOPEN,HTA);
  }

  public Object _WWWSTART(Object ... _p) {
    mVar YTITLE = m$.newVarRef("YTITLE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YEXIT = m$.newVarRef("YEXIT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YREFR = m$.newVarRef("YREFR",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YNOOPEN = m$.newVarRef("YNOOPEN",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar HTA = m$.newVarRef("HTA",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< #;define jsMarker(%1)   write YCR,YCR,"<!-- ************************* ",%1," (WWWSTART)************************* -->",YCR,YCR
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       STARTEN HTML
    //<< ;
    //<< ; Inputs :
    //<< ;   YTITLE = UEBERSCHRIFT
    //<< ;   YEXIT  = VORZEITIGES ENDE DES HEADERS (ZB WENN JAVASCRIPT) ;termination when
    //<< ;   YREFR= ANZAHL DER REFRESHSEKUNDEN ;Number the
    //<< ;   YNOOPEN=1 = NICHT DIE LEITUNG ÖFFNEN (Z.B. WEIL DIE HTMLSEITE AUF PLATTE
    //<< ;               GESPEICHERNT WIRD UND NICHT HTTP) ;Not who conduction unclose since who upon And Not
    //<< ;   HTA=1 = im Aplicationsmodus starten
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 29-Oct-2010   shobby  SR17596: If the form is WWWPARA then there could be a
    //<< ;                           delay before the screen is ready to draw, which
    //<< ;                           means the blendTrans will cause a partial (untidy)
    //<< ;                           draw of the screen.  Disable in this case.
    //<< ; 03-May-2010   shobby  SR17253: Remove annoying screen flashes when loading pages.
    //<< ; 23-Mar-2009   shobby  SR16427: Add some additional javascript references so
    //<< ;                           that calls can be made back to cache from popup menu
    //<< ;                           forms.
    //<< ; 07-May-2007   GRF     SR15511: Doco; quits; expand commands
    //<< ; 19-Dec-2006   JW      BR014262: Menu type 6 has been removed. Encapsulate Title
    //<< ; 22-Dec-2005   JW      SR13195: Add link class
    //<< ; 02-Dec-2005   RPW     SR13940: If the user can customize then allow the drag
    //<< ;                           and drop actions.
    //<< ; 25.04.2005    FIS     SR12200
    //<< ; 26.11.2003    Bec     24708
    //<< ; 15.04.2003    FIS     23391: DROP-DOWN MENU STATT BUTTONLEISTE
    //<< ; 03.06.1998    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YSTYLE,YDROPD,blnCanDrag
    mVar YSTYLE = m$.var("YSTYLE");
    mVar YDROPD = m$.var("YDROPD");
    mVar blnCanDrag = m$.var("blnCanDrag");
    m$.newVar(YSTYLE,YDROPD,blnCanDrag);
    //<< 
    //<< ; FIXME : Get ^WWW012(0,0,1) and ^WWW120(0,YFORM,1) records once and reuse obj... variables.
    //<< 
    //<< IF '$DATA(YTITLE) SET YTITLE = ""
    if (mOp.Not(m$.Fnc.$data(YTITLE))) {
      YTITLE.set("");
    }
    //<< IF '$DATA(YREFR)  SET YREFR  = ""
    if (mOp.Not(m$.Fnc.$data(YREFR))) {
      YREFR.set("");
    }
    //<< 
    //<< ; D76       $$$WWW012CharacterSet()
    //<< SET YISO = $PIECE($GET(^WWW012(0,0,1)),Y,76)                  ;zeichensatz suchen ;seek
    mVar YISO = m$.var("YISO");
    YISO.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),m$.var("Y").get(),76));
    //<< IF YISO'="" IF SPRACHE'="" SET YISO=$PIECE($GET(^WWW100(0,"CHARSET",SPRACHE,YISO,1)),Y,1) ; FIXME : CHARSET settings are common for all languages - should default still be active? <GRF>
    if (mOp.NotEqual(YISO.get(),"")) {
      if (mOp.NotEqual(m$.var("SPRACHE").get(),"")) {
        YISO.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"CHARSET",m$.var("SPRACHE").get(),YISO.get(),1)),m$.var("Y").get(),1));
      }
    }
    //<< ;IF YISO="" SET YISO="iso-8859-1"
    //<< 
    //<< ; D66       $$$WWW012DisplayButtonOnBottomLine    0="Buttons Above", 3="Selection"
    //<< SET YDROPD = $$$NO   ;EINSCHALTEN FILE LOAD FÜR MENU.HTC (SCRIPT FÜR POPUP-MENU IN WWWFORMC3) ;switch in to to within
    YDROPD.set(include.COMSYS.$$$NO(m$));
    //<< IF $GET(YQUERY)'="" IF $GET(%(YQUERY,"EP"))'="WWWMENU" IF $PIECE($GET(^WWW012(0,0,1)),Y,66)=3 SET YDROPD=$$$YES  ;DROP-DOWN MENU STATT BUTTONLEISTE;TYBD;NUR WENN KEIN MENUE
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YQUERY")),"")) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"EP")),"WWWMENU")) {
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),m$.var("Y").get(),66),3)) {
          YDROPD.set(include.COMSYS.$$$YES(m$));
        }
      }
    }
    //<< 
    //<< IF $GET(YNOOPEN)'=1 DO OPEN   ;start html
    if (mOp.NotEqual(m$.Fnc.$get(YNOOPEN),1)) {
      m$.Cmd.Do("OPEN");
    }
    //<< IF YUSER'="" SET $PIECE(^WWWUSER(0,YUSER,1),Y,5)=1,$PIECE(^WWWUSER(0,YUSER,1),Y,6)=0  ;merker start und ende ;and
    if (mOp.NotEqual(m$.var("YUSER").get(),"")) {
      m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),5).set(1);
      m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),6).set(0);
    }
    //<< 
    //<< ; vvvvv   TO DO : Implement in some form once standard achieved
    //<< ;write "<!DOCTYPE HTML PUBLIC ""-//W3C//DTD HTML 4.0//EN"">"
    //<< ;write "<!DOCTYPE HTML PUBLIC ""-//W3C//DTD HTML 4.01 Transitional//EN"" ""http://www.w3.org/TR/html4/loose.dtd"">"
    //<< ;write "<!DOCTYPE html PUBLIC ""-//W3C//DTD XHTML 1.0 Strict//EN"" ""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"">"
    //<< ; ^^^^^
    //<< 
    //<< WRITE "<HTML"
    m$.Cmd.Write("<HTML");
    //<< IF YDROPD=$$$YES WRITE " XMLNS:myMenu"
    if (mOp.Equal(YDROPD.get(),include.COMSYS.$$$YES(m$))) {
      m$.Cmd.Write(" XMLNS:myMenu");
    }
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< IF YDROPD=$$$YES WRITE "<?IMPORT namespace=""myMenu"" implementation="""_YGIF_"formc3.htc"" />"
    if (mOp.Equal(YDROPD.get(),include.COMSYS.$$$YES(m$))) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<?IMPORT namespace=\"myMenu\" implementation=\"",m$.var("YGIF").get()),"formc3.htc\" />"));
    }
    //<< 
    //<< $$$jsMarker("Header")
    $$$jsMarker(m$,"Header");
    //<< 
    //<< WRITE "<HEAD>"
    m$.Cmd.Write("<HEAD>");
    //<< if $$SR16427^WWWFORMJavascript() do Event^WWWMENU5()
    if (mOp.Logical(m$.fnc$("WWWFORMJavascript.SR16427"))) {
      m$.Cmd.Do("WWWMENU5.Event");
    }
    //<< do CanCustomize^WWWHELP($GET(YBEDBER),.blnCanDrag)    ; 1 = System Administrator 2 = DB Administrator
    m$.Cmd.Do("WWWHELP.CanCustomize",m$.Fnc.$get(m$.var("YBEDBER")),blnCanDrag);
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< WRITE "var blnCanDrag="_$select(blnCanDrag:"true",1:"false")_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("var blnCanDrag=",m$.Fnc.$select(blnCanDrag.get(),"true",1,"false")),";"));
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< IF +YREFR'=0 DO
    if (mOp.NotEqual(mOp.Positive(YREFR.get()),0)) {
      //<< . WRITE "<META HTTP-EQUIV=""refresh"" content="""_YREFR_""">",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<META HTTP-EQUIV=\"refresh\" content=\"",YREFR.get()),"\">"),"\n");
    }
    //<< 
    //<< IF YISO'="" DO   ;CHARACTER
    if (mOp.NotEqual(YISO.get(),"")) {
      //<< . WRITE "<META HTTP-EQUIV=""Content-Type"" content=""text/html; charset="_YISO_""">",!
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<META HTTP-EQUIV=\"Content-Type\" content=\"text/html; charset=",YISO.get()),"\">"),"\n");
      //<< . ;SR17596 if ($get(YUSERAGENT)="MSIE") do  ;SR17596
      //<< . if ($get(YUSERAGENT)="MSIE") && ($get(YFORM)'="WWWPARA") do     ;SR17596
      if ((mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"WWWPARA"))) {
        //<< . . WRITE "<META http-equiv=""Page-Enter"" content=""blendTrans(Duration=0)"">"  ;SR17253
        m$.Cmd.Write("<META http-equiv=\"Page-Enter\" content=\"blendTrans(Duration=0)\">");
        //<< . . WRITE "<META http-equiv=""Page-Exit"" content=""blendTrans(Duration=0)""> "  ;SR17253
        m$.Cmd.Write("<META http-equiv=\"Page-Exit\" content=\"blendTrans(Duration=0)\"> ");
      }
    }
    //<< 
    //<< 
    //<< ; STYLE SHEET
    //<< ;---------------------------------------
    //<< ;   D83     $$$WWW012StylesheetCSSDataFile()
    //<< ;   D83     $$$WWW120StylesheetCSSFile()
    //<< ;---------------------------------------
    //<< SET YSTYLE = $$$NO  ; no stylesheet
    YSTYLE.set(include.COMSYS.$$$NO(m$));
    do {
      //<< 
      //<< DO
      //<< . NEW STYLE
      mVar STYLE = m$.var("STYLE");
      m$.newVar(STYLE);
      //<< . SET STYLE = $PIECE($GET(^WWW012(0,0,1)),Y,83)
      STYLE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),m$.var("Y").get(),83));
      //<< . IF $GET(YFORM)'="" IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,83)'="" SET STYLE=$PIECE($GET(^WWW120(0,YFORM,1)),Y,83)
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),83),"")) {
          STYLE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),83));
        }
      }
      //<< . IF STYLE'="" IF $EXTRACT(STYLE,1,2)="$$" DO  QUIT
      if (mOp.NotEqual(STYLE.get(),"")) {
        if (mOp.Equal(m$.Fnc.$extract(STYLE.get(),1,2),"$$")) {
          //<< . . SET YSTYLE = $$$YES  ;STYLEANWEISUNG
          YSTYLE.set(include.COMSYS.$$$YES(m$));
          //<< . . NEW EXEC
          mVar EXEC = m$.var("EXEC");
          m$.newVar(EXEC);
          //<< . . SET EXEC = "WRITE "_STYLE
          EXEC.set(mOp.Concat("WRITE ",STYLE.get()));
          //<< . . XECUTE EXEC
          m$.Cmd.Xecute(EXEC.get());
          break;
        }
      }
      //<< . ;
      //<< . IF STYLE'="" DO
      if (mOp.NotEqual(STYLE.get(),"")) {
        do {
          //<< . . SET YSTYLE=$$$YES  ;STYLEANWEISUNG
          YSTYLE.set(include.COMSYS.$$$YES(m$));
          //<< . . IF $GET(YFORM)'="" IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,83)'="" DO  QUIT   ;FORMULAREIGEN
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),83),"")) {
              //<< . . . WRITE " <LINK REL=""stylesheet"" TYPE=""text/css"" HREF="""_YGIF_$PIECE($GET(^WWW120(0,YFORM,1)),Y,83)_""">"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"",m$.var("YGIF").get()),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),83)),"\">"));
              break;
            }
          }
          //<< . . ;
          //<< . . WRITE " <LINK REL=""stylesheet"" TYPE=""text/css"" HREF="""_YGIF_$PIECE($GET(^WWW012(0,0,1)),Y,83)_""">"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"",m$.var("YGIF").get()),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),m$.var("Y").get(),83)),"\">"));
        } while (false);
      }
    } while(false);
    do {
      //<< 
      //<< DO  ;STYLE
      //<< . IF YSTYLE=$$$YES DO  QUIT             ;ANDERE STYLES
      if (mOp.Equal(YSTYLE.get(),include.COMSYS.$$$YES(m$))) {
        //<< . . WRITE "<STYLE type='text/css'></STYLE>"
        m$.Cmd.Write("<STYLE type='text/css'></STYLE>");
        break;
      }
      //<< . ;
      //<< . WRITE "<STYLE type='text/css'>",!
      m$.Cmd.Write("<STYLE type='text/css'>","\n");
      //<< . WRITE "<!--"
      m$.Cmd.Write("<!--");
      //<< . ;W "@media all {IE\:HOMEPAGE {behavior:url(#default#homepage)} }"
      //<< . NEW COLOR
      mVar COLOR = m$.var("COLOR");
      m$.newVar(COLOR);
      //<< . DO                               ;SCHRIFT ;typeface
      do {
        //<< . . NEW SCHRIFT  ;,COLOR
        mVar SCHRIFT = m$.var("SCHRIFT");
        m$.newVar(SCHRIFT);
        //<< . . SET SCHRIFT = $PIECE($GET(^WWW012(0,0,1)),Y,9)
        SCHRIFT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),m$.var("Y").get(),9));
        //<< . . IF SCHRIFT'="" SET SCHRIFT = $PIECE($GET(^WWW100(0,"SCHRIFTART",SPRACHE,SCHRIFT,1)),Y,1)
        if (mOp.NotEqual(SCHRIFT.get(),"")) {
          SCHRIFT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),SCHRIFT.get(),1)),m$.var("Y").get(),1));
        }
        //<< . . IF SCHRIFT=""  SET SCHRIFT = "SansSerif"
        if (mOp.Equal(SCHRIFT.get(),"")) {
          SCHRIFT.set("SansSerif");
        }
        //<< . . SET COLOR = $PIECE($GET(^WWW012(0,0,1)),Y,6)
        COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),m$.var("Y").get(),6));
        //<< . . IF COLOR'="" SET COLOR = $PIECE($GET(^WWW100(0,"FARBE",SPRACHE,COLOR,1)),Y,1)
        if (mOp.NotEqual(COLOR.get(),"")) {
          COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),COLOR.get(),1)),m$.var("Y").get(),1));
        }
        //<< . . WRITE " body, td, th, legend {font-family:'"_SCHRIFT_"','SansSerif';"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" body, td, th, legend {font-family:'",SCHRIFT.get()),"','SansSerif';"));
        //<< . . IF COLOR'="" WRITE " color:"_COLOR_";"
        if (mOp.NotEqual(COLOR.get(),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" color:",COLOR.get()),";"));
        }
        //<< . . WRITE "}",!
        m$.Cmd.Write("}","\n");
      } while(false);
      //<< . ;
      //<< . IF $GET(YLINKCOL)=""  WRITE " a:hover{color:blue; text-decoration:underline}",!
      if (mOp.Equal(m$.Fnc.$get(m$.var("YLINKCOL")),"")) {
        m$.Cmd.Write(" a:hover{color:blue; text-decoration:underline}","\n");
      }
      //<< . IF $GET(YLINKCOL)'="" WRITE " a:hover{color:"_YBLUE_"; text-decoration:underline}",!
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLINKCOL")),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" a:hover{color:",m$.var("YBLUE").get()),"; text-decoration:underline}"),"\n");
      }
      //<< . WRITE " a {text-decoration:none;"
      m$.Cmd.Write(" a {text-decoration:none;");
      //<< . IF COLOR'="" WRITE " color:"_COLOR_";"
      if (mOp.NotEqual(COLOR.get(),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" color:",COLOR.get()),";"));
      }
      //<< . WRITE "}",!
      m$.Cmd.Write("}","\n");
      //<< . ;
      //<< . IF $GET(YLINKCOL)=""  WRITE " a:active {color:blue"
      if (mOp.Equal(m$.Fnc.$get(m$.var("YLINKCOL")),"")) {
        m$.Cmd.Write(" a:active {color:blue");
      }
      //<< . IF $GET(YLINKCOL)'="" WRITE " a:active {color:"_YBLUE
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLINKCOL")),"")) {
        m$.Cmd.Write(mOp.Concat(" a:active {color:",m$.var("YBLUE").get()));
      }
      //<< . IF $GET(YFORM)=""     WRITE "; font-weight:bold"
      if (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"")) {
        m$.Cmd.Write("; font-weight:bold");
      }
      //<< . WRITE "}",!
      m$.Cmd.Write("}","\n");
      //<< . IF $GET(YFORM)'="" IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,78)=1 DO   ;ORIENTIERUNG
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),78),1)) {
          //<< . . WRITE " @page { size:landscape; }"
          m$.Cmd.Write(" @page { size:landscape; }");
        }
      }
      //<< . ;
      //<< . WRITE " THEAD {display:table-header-group}",!
      m$.Cmd.Write(" THEAD {display:table-header-group}","\n");
      //<< . ; vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
      //<< . ;do
      //<< . . WRITE " #header {        "
      //<< . . WRITE "   position: fixed;"
      //<< . . WRITE "   width: 100%;"
      //<< . . WRITE "   height: 60px;"
      //<< . . WRITE "   top: 0;"
      //<< . . WRITE "   right: 0;"
      //<< . . WRITE "   bottom: auto;"
      //<< . . WRITE "   left: 0;"
      //<< . . WRITE " }"
      //<< . . ;
      //<< . . WRITE " #content {       "
      //<< . . WRITE "   overflow: auto;"
      //<< . . WRITE "   width: 100%;"
      //<< . . WRITE "   height: auto;"
      //<< . . WRITE "   top: auto;"
      //<< . . WRITE "   right: auto;"
      //<< . . WRITE "   bottom: auto;"
      //<< . . WRITE "   left: 0;"
      //<< . . WRITE " }"
      //<< . ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
      //<< . ;
      //<< . write " .link { cursor:pointer; }",!  ;SR17253
      m$.Cmd.Write(" .link { cursor:pointer; }","\n");
      //<< . ;
      //<< . WRITE "-->",!
      m$.Cmd.Write("-->","\n");
      //<< . WRITE "</STYLE>",YCR
      m$.Cmd.Write("</STYLE>",m$.var("YCR").get());
    } while(false);
    //<< 
    //<< do Title(YTITLE)
    m$.Cmd.Do("Title",YTITLE.get());
    //<< 
    //<< IF $DATA(YEXIT) QUIT
    if (mOp.Logical(m$.Fnc.$data(YEXIT))) {
      return null;
    }
    //<< 
    //<< IF $GET(HTA)=1 write "<HTA:APPLICATION ID=""WWW""  APPLICATIONNAME=""WWW"" BORDER=""none"" CAPTION=""no"" SHOWINTASKBAR=""no""  SINGLEINSTANCE=""yes"" SYSMENU=""no"" WINDOWSTATE=""maximize"">"
    if (mOp.Equal(m$.Fnc.$get(HTA),1)) {
      m$.Cmd.Write("<HTA:APPLICATION ID=\"WWW\"  APPLICATIONNAME=\"WWW\" BORDER=\"none\" CAPTION=\"no\" SHOWINTASKBAR=\"no\"  SINGLEINSTANCE=\"yes\" SYSMENU=\"no\" WINDOWSTATE=\"maximize\">");
    }
    //<< 
    //<< WRITE "</HEAD>"
    m$.Cmd.Write("</HEAD>");
    //<< QUIT
    return null;
  }

  //<< 
  //<< 
  //<< Title(pstrTitle)
  public Object Title(Object ... _p) {
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add the title tag
    //<< ;
    //<< ; Params:   pstrTitle - title description
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Dec-2006   JW      BR014262: Created (Encapsulated).
    //<< ;-------------------------------------------------------------------------------
    //<< write "<TITLE>"
    m$.Cmd.Write("<TITLE>");
    //<< 
    //<< write $$^WWWUML(pstrTitle)   ;Heading
    m$.Cmd.Write(m$.fnc$("WWWUML.main",pstrTitle.get()));
    //<< if $get(YBED)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) {
      //<< write " - "
      m$.Cmd.Write(" - ");
      //<< write $piece($get(^WWW013(0,YBED,1)),Y,1)
      m$.Cmd.Write(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)),m$.var("Y").get(),1));
      //<< write " - "
      m$.Cmd.Write(" - ");
      //<< write $$^WWWDATE($horolog)
      m$.Cmd.Write(m$.fnc$("WWWDATE.main",m$.Fnc.$horolog()));
      //<< write " -  ["_$translate($get(YUCI),"_"," ")_"/"_$get(YM)
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" -  [",m$.Fnc.$translate(m$.Fnc.$get(m$.var("YUCI")),"_"," ")),"/"),m$.Fnc.$get(m$.var("YM"))));
      //<< write "/"_$get(SPRACHE)_"]"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("/",m$.Fnc.$get(m$.var("SPRACHE"))),"]"));
    }
    //<< }
    //<< write "</TITLE>"
    m$.Cmd.Write("</TITLE>");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OPEN
  public void OPEN() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   USE PIPE
    //<< ; call as: DO OPEN^WWWSTART
    //<< ;-------------------------------------------------------------------------------
    //<< IF YQUERY="%KEY" IF $GET(%ZCS("USE_PORT"))'="" XECUTE %ZCS("USE_PORT")
    if (mOp.Equal(m$.var("YQUERY").get(),"%KEY")) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("%ZCS","USE_PORT")),"")) {
        m$.Cmd.Xecute(m$.var("%ZCS","USE_PORT").get());
      }
    }
    //<< ;IF YQUERY'="%KEY" USE 56:(:1)
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< CLOSE
  public void CLOSE() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   CLOSE PIPE
    //<< ; call as: DO CLOSE^WWWSTART
    //<< ;-------------------------------------------------------------------------------
    //<< IF YQUERY="%KEY" IF $GET(%ZCS("FLUSH"))'="" XECUTE %ZCS("FLUSH")
    if (mOp.Equal(m$.var("YQUERY").get(),"%KEY")) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("%ZCS","FLUSH")),"")) {
        m$.Cmd.Xecute(m$.var("%ZCS","FLUSH").get());
      }
    }
    //<< ;IF YQUERY'="%KEY" USE 56:(::1)
    //<< QUIT
    return;
  }

//<< 
//<< 
//<< 
}
