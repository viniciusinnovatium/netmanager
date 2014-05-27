//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMF
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:47
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;
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
//<< #include COMConst
import include.COMConst;
//<< #include WWWFORM
import include.WWWFORM;

//<< WWWFORMF
public class WWWFORMF extends mClass {

  //<< 
  //<< #define Buttons         $$$WWW120PicturesAsButtons(YVOR)
  public static Object $$$Buttons(mContext m$) {
    return (include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.var("YVOR")));
  }

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogRx(%1)       ;
  public static Object $$$LogRx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogRm(%1)       ;
  public static Object $$$LogRm(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _WWWFORMF();
  }

  public void _WWWFORMF() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORMF("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       BUTTON STANDARD FORM
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
    //<< ; 03-May-2010   GRF     -: Old comments cleanup
    //<< ; 02-Mar-2009   GRF     Doco
    //<< ; 30-Nov-2005   JW      SR13195: Rewrote a lot of code (see OBSWWWFORMF)
    //<< ;                           to use braces / macros.
    //<< ; 15.07.1999    DT
    //<< ;-------------------------------------------------------------------------------
    //<< do HEAD1
    m$.Cmd.Do("HEAD1");
    //<< quit
    return;
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Do NOT Display Standard Button   (WWW120 D94)
  //<< ;   1 - New                             10 - First Record
  //<< ;   2 - Open                            11 - Previous Record
  //<< ;   3 - Save                            12 - Next Record
  //<< ;   4 - Internal Message Display        13 - Last Record
  //<< ;   5 - Delete                          14 - Reminder
  //<< ;   6 - Help                            15 - Copy
  //<< ;   7 - Back                            16 - Export to Excel
  //<< ;   8 - Cancel                          17 - Grid Layout
  //<< ;   9 - Search
  //<< ;
  //<< ; if '$find(strDontDisplay,#) do DisplayButton
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< 
  //<< HEAD1
  public void HEAD1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Form Type 1 Standard - Display standard buttons
    //<< ;
    //<< ; Called By : ^WWWFORMF, WWWFORM1 (for YFOART=1)
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Dec-2007   shobby  SRBR014601: Move DoNotDisplay call to routine WWWFORMX
    //<< ; 12-Dec-2007   GM      SRBR014601: Call routine that checks characters in Form
    //<< ;                           and Customisation
    //<< ; 19-Feb-2007   JW      SR15240: Cleaned up
    //<< ;-------------------------------------------------------------------------------
    //<< new strDontDisplay,strStandardSubmit
    mVar strDontDisplay = m$.var("strDontDisplay");
    mVar strStandardSubmit = m$.var("strStandardSubmit");
    m$.newVar(strDontDisplay,strStandardSubmit);
    //<< 
    //<< $$$LogR("HEAD1",YVOR)
    $$$LogR(m$,"HEAD1",m$.var("YVOR"));
    //<< 
    //<< set strDontDisplay    = ","_$$$WWW120DoNOTDisplayStandardButto(YVOR)_","
    strDontDisplay.set(mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW120DoNOTDisplayStandardButto(m$,m$.var("YVOR"))),","));
    //<< set strStandardSubmit = $$$WWW120StandardSubmit(YVOR)
    strStandardSubmit.set(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")));
    //<< 
    //<< set YTARGETF = $$$WWW120TargetNameForOutput(YVOR)
    mVar YTARGETF = m$.var("YTARGETF");
    YTARGETF.set(include.WWWConst.$$$WWW120TargetNameForOutput(m$,m$.var("YVOR")));
    //<< if $$$Buttons write $$Delimiter^WWWFORMCOMMON()
    if (mOp.Logical($$$Buttons(m$))) {
      m$.Cmd.Write(m$.fnc$("WWWFORMCOMMON.Delimiter"));
    }
    //<< 
    //<< ;WENN STANDARD SUBMIT ;when
    //<< if strStandardSubmit'="" do  quit  ; NUR DIESEN ;only
    if (mOp.NotEqual(strStandardSubmit.get(),"")) {
      //<< . set $$$Buttons = $$$NO           ; As text rather than as images
      mVar $$$Buttons = m$.var("$$$Buttons");
      $$$Buttons.set(include.COMSYS.$$$NO(m$));
      //<< . if '$find(strDontDisplay,",3,") do OK
      if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",3,"))) {
        m$.Cmd.Do("OK");
      }
      //<< . if '$find(strDontDisplay,",5,") if $piece(strStandardSubmit,",",3)'="" do DELETE
      if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",5,"))) {
        if (mOp.NotEqual(m$.Fnc.$piece(strStandardSubmit.get(),",",3),"")) {
          m$.Cmd.Do("DELETE");
        }
      }
      //<< . if '$find(strDontDisplay,",1,") if $piece(strStandardSubmit,",",2)'="" do
      if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",1,"))) {
        if (mOp.NotEqual(m$.Fnc.$piece(strStandardSubmit.get(),",",2),"")) {
          do {
            //<< . . if $$$WWW120ClassUsedInForm(YVOR)'="" do NEW quit  ;NEUANLAGE
            if (mOp.NotEqual(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.var("YVOR")),"")) {
              m$.Cmd.Do("NEW");
              break;
            }
            //<< . . ;
            //<< . . new YNEU
            mVar YNEU = m$.var("YNEU");
            m$.newVar(YNEU);
            //<< . . set YNEU = $$^WWWTEXT($piece(strStandardSubmit,",",2))
            YNEU.set(m$.fnc$("WWWTEXT.main",m$.Fnc.$piece(strStandardSubmit.get(),",",2)));
            //<< . . if YNEU="" set YNEU="NEW"
            if (mOp.Equal(YNEU.get(),"")) {
              YNEU.set("NEW");
            }
            //<< . . write "<TD>"
            m$.Cmd.Write("<TD>");
            //<< . . write "<INPUT TYPE=""RESET"" VALUE="""_$$^WWWUML(YNEU)_""""
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<INPUT TYPE=\"RESET\" VALUE=\"",m$.fnc$("WWWUML.main",YNEU.get())),"\""));
            //<< . . if $$$WWW120StylesheetCSSFile(YVOR)'="" write " class=""button"""
            if (mOp.NotEqual(include.WWWConst.$$$WWW120StylesheetCSSFile(m$,m$.var("YVOR")),"")) {
              m$.Cmd.Write(" class=\"button\"");
            }
            //<< . . write ">"   ;NEU ;recent
            m$.Cmd.Write(">");
            //<< . . write YCR,"</TD>"
            m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
          } while (false);
        }
      }
      return;
    }
    //<< 
    //<< 
    //<< 
    //<< if '$find(strDontDisplay,",1,") if +$get(YTIMEFORM)=0 do NEW
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",1,"))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YTIMEFORM"))),0)) {
        m$.Cmd.Do("NEW");
      }
    }
    //<< if '$find(strDontDisplay,",2,") if +$get(YTIMEFORM)=0 do OPEN
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",2,"))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YTIMEFORM"))),0)) {
        m$.Cmd.Do("OPEN");
      }
    }
    //<< if '$find(strDontDisplay,",3,") do SAVE
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",3,"))) {
      m$.Cmd.Do("SAVE");
    }
    //<< do TEXT
    m$.Cmd.Do("TEXT");
    //<< if '$find(strDontDisplay,",5,") do DELETE
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",5,"))) {
      m$.Cmd.Do("DELETE");
    }
    //<< if '$find(strDontDisplay,",6,") if +$get(YTIMEFORM)=0 do HELP
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",6,"))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YTIMEFORM"))),0)) {
        m$.Cmd.Do("HELP");
      }
    }
    //<< if '$find(strDontDisplay,",7,") do BACK
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",7,"))) {
      m$.Cmd.Do("BACK");
    }
    //<< if '$find(strDontDisplay,",8,") do END
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",8,"))) {
      m$.Cmd.Do("END");
    }
    //<< if $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumCreateOnly do  quit  ; "Create Only"   ;NUR NEUERFASSUNG ERLAUBT ;only permissive
    if (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumCreateOnly(m$))) {
      //<< . if '$find(strDontDisplay,",14,") if +$get(YTIMEFORM)=0 do WV
      if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",14,"))) {
        if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YTIMEFORM"))),0)) {
          m$.Cmd.Do("WV");
        }
      }
      return;
    }
    //<< 
    //<< if +$get(YTIMEFORM)=$$$NO {
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YTIMEFORM"))),include.COMSYS.$$$NO(m$))) {
      //<< if '$find(strDontDisplay,",9,")  do SEARCH
      if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",9,"))) {
        m$.Cmd.Do("SEARCH");
      }
      //<< if '$find(strDontDisplay,",10,") do Direction("rrev", "FIRST","PAGEL","&lt;&lt;",301)
      if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",10,"))) {
        m$.Cmd.Do("Direction","rrev","FIRST","PAGEL","&lt;&lt;",301);
      }
      //<< if '$find(strDontDisplay,",11,") do Direction("rev",  "BACK", "PAGEF","&lt;",    302)
      if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",11,"))) {
        m$.Cmd.Do("Direction","rev","BACK","PAGEF","&lt;",302);
      }
      //<< if '$find(strDontDisplay,",12,") do Direction("for",  "NEXT", "PAGEN","&gt;",    303)
      if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",12,"))) {
        m$.Cmd.Do("Direction","for","NEXT","PAGEN","&gt;",303);
      }
      //<< if '$find(strDontDisplay,",13,") do Direction("ffor", "LAST", "PAGEE","&gt;&gt;",304)
      if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",13,"))) {
        m$.Cmd.Do("Direction","ffor","LAST","PAGEE","&gt;&gt;",304);
      }
    }
    //<< }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< HEAD3
  public void HEAD3() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Form Type 3 GRID - STANDARD BUTTONS
    //<< ;
    //<< ; History
    //<< ; 09-Nov-2010   GRF     SR17243: use strDontDisplay to get list once
    //<< ;-------------------------------------------------------------------------------
    //<< new strDontDisplay
    mVar strDontDisplay = m$.var("strDontDisplay");
    m$.newVar(strDontDisplay);
    //<< 
    //<< $$$LogR("HEAD3",YVOR)
    $$$LogR(m$,"HEAD3",m$.var("YVOR"));
    //<< 
    //<< set strDontDisplay = ","_$$$WWW120DoNOTDisplayStandardButto(YVOR)_","
    strDontDisplay.set(mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW120DoNOTDisplayStandardButto(m$,m$.var("YVOR"))),","));
    //<< 
    //<< if $$$Buttons write $$Delimiter^WWWFORMCOMMON()
    if (mOp.Logical($$$Buttons(m$))) {
      m$.Cmd.Write(m$.fnc$("WWWFORMCOMMON.Delimiter"));
    }
    //<< if '$find(strDontDisplay,",1,") if +$get(YTIMEFORM)=0 do NEW
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",1,"))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YTIMEFORM"))),0)) {
        m$.Cmd.Do("NEW");
      }
    }
    //<< if '$find(strDontDisplay,",2,") if +$get(YTIMEFORM)=0 do OPEN
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",2,"))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YTIMEFORM"))),0)) {
        m$.Cmd.Do("OPEN");
      }
    }
    //<< if '$find(strDontDisplay,",3,") {
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",3,"))) {
      //<< if $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly {
      if (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$))) {
        //<< do SAVE  ;DISABLED (READONLY)
        m$.Cmd.Do("SAVE");
      }
      //<< } else {
      else {
        //<< do OK1
        m$.Cmd.Do("OK1");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if '$find(strDontDisplay,",4,") do TEXT
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",4,"))) {
      m$.Cmd.Do("TEXT");
    }
    //<< if '$find(strDontDisplay,",5,") do DELETE
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",5,"))) {
      m$.Cmd.Do("DELETE");
    }
    //<< if '$find(strDontDisplay,",6,") if +$get(YTIMEFORM)=0 do HELP
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",6,"))) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YTIMEFORM"))),0)) {
        m$.Cmd.Do("HELP");
      }
    }
    //<< if '$find(strDontDisplay,",7,") do BACK
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",7,"))) {
      m$.Cmd.Do("BACK");
    }
    //<< if '$find(strDontDisplay,",8,") do END
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",8,"))) {
      m$.Cmd.Do("END");
    }
    //<< 
    //<< if $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumCreateOnly do  quit  ;NUR NEUERFASSUNG ERLAUBT ;only permissive
    if (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumCreateOnly(m$))) {
      return;
    }
    //<< 
    //<< if '$find(strDontDisplay,",9,") do SEARCH
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",9,"))) {
      m$.Cmd.Do("SEARCH");
    }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< OK1 ; BUTTON GRID
  public void OK1() {
    //<< new YOK
    mVar YOK = m$.var("YOK");
    m$.newVar(YOK);
    //<< 
    //<< if $data(^WWW122(0,YFORM)) || $data(^WWW131(0,YFORM)) || (YFOART=7) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get()))) || mOp.Logical(m$.Fnc.$data(m$.var("^WWW131",0,m$.var("YFORM").get()))) || (mOp.Equal(m$.var("YFOART").get(),7))) {
      //<< $$$OpenTD($$$NO)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
      //<< if YFOART=8 write "<BR>"
      if (mOp.Equal(m$.var("YFOART").get(),8)) {
        m$.Cmd.Write("<BR>");
      }
      //<< if '$$$Buttons {
      if (mOp.Not($$$Buttons(m$))) {
        //<< set YOK = "OK"
        YOK.set("OK");
        //<< if $piece($$$WWW120StandardSubmit(YVOR),",",1)'="" set YOK = $piece($$$WWW120StandardSubmit(YVOR),",",1)
        if (mOp.NotEqual(m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",1),"")) {
          YOK.set(m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",1));
        }
        //<< write "<INPUT TYPE=""SUBMIT"""
        m$.Cmd.Write("<INPUT TYPE=\"SUBMIT\"");
        //<< if $$$WWW120StylesheetCSSFile(YVOR)'="" write " class=""button"""
        if (mOp.NotEqual(include.WWWConst.$$$WWW120StylesheetCSSFile(m$,m$.var("YVOR")),"")) {
          m$.Cmd.Write(" class=\"button\"");
        }
        //<< write """ onClick=""document.WWW.YOPEN.value=0;""" ; SPEICHERN ;Save
        m$.Cmd.Write("\" onClick=\"document.WWW.YOPEN.value=0;\"");
        //<< write " VALUE="""_YOK_""">" ; OK!
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" VALUE=\"",YOK.get()),"\">"));
      }
      //<< 
      //<< } else {
      else {
        //<< write "<A class=link onClick="""  ;SAVE AUF SAVENOW MIT DELAY;TYBD;5.09.2003 ;upon by means of
        m$.Cmd.Write("<A class=link onClick=\"");
        //<< do SaveNow()
        m$.Cmd.Do("SaveNow");
        //<< write "return false;"
        m$.Cmd.Write("return false;");
        //<< write """>"
        m$.Cmd.Write("\">");
        //<< do StopButton^WWWFORMCOMMON("OK","save.gif","BUTTON_SAVE")
        m$.Cmd.Do("WWWFORMCOMMON.StopButton","OK","save.gif","BUTTON_SAVE");
        //<< write "</A>"   ;NEU ;recent
        m$.Cmd.Write("</A>");
      }
      //<< }
      //<< $$$CloseTD
      include.WWWFORM.$$$CloseTD(m$);
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< OK
  public void OK() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; OK BUTTON
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jul-2006   JW      SR14799: Set YOPEN to 0 for save
    //<< ;-------------------------------------------------------------------------------
    //<< new YOK
    mVar YOK = m$.var("YOK");
    m$.newVar(YOK);
    //<< 
    //<< if $data(^WWW122(0,YFORM)) || $data(^WWW131(0,YFORM)) || (YFOART=7) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get()))) || mOp.Logical(m$.Fnc.$data(m$.var("^WWW131",0,m$.var("YFORM").get()))) || (mOp.Equal(m$.var("YFOART").get(),7))) {
      //<< $$$OpenTD($$$NO)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
      //<< if YFOART=8 write "<BR>"
      if (mOp.Equal(m$.var("YFOART").get(),8)) {
        m$.Cmd.Write("<BR>");
      }
      //<< if '$$$Buttons {
      if (mOp.Not($$$Buttons(m$))) {
        //<< set YOK="OK"
        YOK.set("OK");
        //<< if $piece($$$WWW120StandardSubmit(YVOR),",",1)'="" set YOK=$$^WWWTEXT($piece($$$WWW120StandardSubmit(YVOR),",",1))
        if (mOp.NotEqual(m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",1),"")) {
          YOK.set(m$.fnc$("WWWTEXT.main",m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",1)));
        }
        //<< write "<INPUT TYPE=""SUBMIT"""
        m$.Cmd.Write("<INPUT TYPE=\"SUBMIT\"");
        //<< if $$$WWW120StylesheetCSSFile(YVOR)'="" write " class=""button"""
        if (mOp.NotEqual(include.WWWConst.$$$WWW120StylesheetCSSFile(m$,m$.var("YVOR")),"")) {
          m$.Cmd.Write(" class=\"button\"");
        }
        //<< write " onClick=""document.WWW.YOPEN.value=0;"""
        m$.Cmd.Write(" onClick=\"document.WWW.YOPEN.value=0;\"");
        //<< write " VALUE="""_YOK_""">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" VALUE=\"",YOK.get()),"\">"));
      }
      //<< 
      //<< } else {
      else {
        //<< write "<A class=link onClick="""  ;SAVE AUF SAVENOW MIT DELAY
        m$.Cmd.Write("<A class=link onClick=\"");
        //<< write "document.WWW.target='"
        m$.Cmd.Write("document.WWW.target='");
        //<< write $$$WWW120TargetNameForOutput(YVOR)  ;TARGET
        m$.Cmd.Write(include.WWWConst.$$$WWW120TargetNameForOutput(m$,m$.var("YVOR")));
        //<< write "';"
        m$.Cmd.Write("';");
        //<< write "document.WWW.YBUTTON.value='';"
        m$.Cmd.Write("document.WWW.YBUTTON.value='';");
        //<< write "window.focus();"
        m$.Cmd.Write("window.focus();");
        //<< write "SAVENOW();"
        m$.Cmd.Write("SAVENOW();");
        //<< write "return false;"
        m$.Cmd.Write("return false;");
        //<< write """>"
        m$.Cmd.Write("\">");
        //<< do StopButton^WWWFORMCOMMON("OK","ok.gif","BUTTON_SAVE")
        m$.Cmd.Do("WWWFORMCOMMON.StopButton","OK","ok.gif","BUTTON_SAVE");
        //<< write "</A>"
        m$.Cmd.Write("</A>");
      }
      //<< }
      //<< $$$CloseTD
      include.WWWFORM.$$$CloseTD(m$);
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< MENU
  public Object MENU() {
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< HBACK
  public Object HBACK() {
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< NEW
  public void NEW() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 30-Sep-2009   shobby  SR16913: Rework to prevent multiple clicks on a button
    //<< ;-------------------------------------------------------------------------------
    //<< new YNEU,strWL
    mVar YNEU = m$.var("YNEU");
    mVar strWL = m$.var("strWL");
    m$.newVar(YNEU,strWL);
    //<< 
    //<< ; New data record
    //<< if $$$WWW120AuthorizationToModifyData(YVOR)'=$$$EnumModifyOnly {
    if (mOp.NotEqual(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumModifyOnly(m$))) {
      //<< $$$OpenTD($$$NO)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
      //<< 
      //<< if '$$$Buttons {
      if (mOp.Not($$$Buttons(m$))) {
        //<< set YNEU = $$^WWWTEXT(130)
        YNEU.set(m$.fnc$("WWWTEXT.main",130));
        //<< if $piece($$$WWW120StandardSubmit(YVOR),",",2)'="" set YNEU=$$^WWWTEXT($piece($$$WWW120StandardSubmit(YVOR),",",2))
        if (mOp.NotEqual(m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",2),"")) {
          YNEU.set(m$.fnc$("WWWTEXT.main",m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",2)));
        }
        //<< write "<INPUT TYPE=""BUTTON"""
        m$.Cmd.Write("<INPUT TYPE=\"BUTTON\"");
        //<< if $$$WWW120StylesheetCSSFile(YVOR)'="" write " class=""button"""
        if (mOp.NotEqual(include.WWWConst.$$$WWW120StylesheetCSSFile(m$,m$.var("YVOR")),"")) {
          m$.Cmd.Write(" class=\"button\"");
        }
        //<< write " VALUE="""_$$^WWWUML(YNEU)_""""
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" VALUE=\"",m$.fnc$("WWWUML.main",YNEU.get())),"\""));
      }
      //<< 
      //<< } else {
      else {
        //<< write "<A class=link"
        m$.Cmd.Write("<A class=link");
      }
      //<< }
      //<< 
      //<< set strWL = YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
      strWL.set(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()));
      //<< if $get(YSCREENM)=1 set strWL=strWL_"&amp;YSCREENM=1"
      if (mOp.Equal(m$.Fnc.$get(m$.var("YSCREENM")),1)) {
        strWL.set(mOp.Concat(strWL.get(),"&amp;YSCREENM=1"));
      }
      //<< 
      //<< if YFOART=3 {  ;WENN GRID, DANN NICHT ALLES NEU
      if (mOp.Equal(m$.var("YFOART").get(),3)) {
        //<< set strWL=strWL_"&amp;YNEW=1&amp;YSORT="_$get(YSORT)_"&amp;YORIENT="_$get(YORIENT)
        strWL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strWL.get(),"&amp;YNEW=1&amp;YSORT="),m$.Fnc.$get(m$.var("YSORT"))),"&amp;YORIENT="),m$.Fnc.$get(m$.var("YORIENT"))));
        //<< 
        //<< new YXKEY              ; FIXME : Different operation of NEW under brace format - subroutine call instead <GRF>
        mVar YXKEY = m$.var("YXKEY");
        m$.newVar(YXKEY);
        //<< set YXKEY=YKEY
        YXKEY.set(m$.var("YKEY").get());
        //<< new YKEY
        mVar YKEY = m$.var("YKEY");
        m$.newVar(YKEY);
        //<< 
        //<< set YKEY=""
        YKEY.set("");
        //<< set YMAXKEY=+$order(^WWW002(0,YDATEI,""),-1)
        mVar YMAXKEY = m$.var("YMAXKEY");
        YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),""),mOp.Negative(1))));
        //<< if YMAXKEY=0 set YMAXKEY=1
        if (mOp.Equal(YMAXKEY.get(),0)) {
          YMAXKEY.set(1);
        }
        //<< if $piece(YXKEY,",",YMAXKEY)'="" set YKEY=$piece(YXKEY,",",1,YMAXKEY-1)  ;LETZTEN KEY ABSCHNEIDEN ;KEY shear
        if (mOp.NotEqual(m$.Fnc.$piece(YXKEY.get(),",",YMAXKEY.get()),"")) {
          YKEY.set(m$.Fnc.$piece(YXKEY.get(),",",1,mOp.Subtract(YMAXKEY.get(),1)));
        }
        //<< if YKEY="" if $get(YKEY1)'=""    set YKEY=$piece(YKEY1,",",1,YMAXKEY-1)
        if (mOp.Equal(YKEY.get(),"")) {
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY1")),"")) {
            YKEY.set(m$.Fnc.$piece(m$.var("YKEY1").get(),",",1,mOp.Subtract(YMAXKEY.get(),1)));
          }
        }
      }
      //<< 
      //<< } else {      ;NO GRID
      else {
        //<< new YKEY              ; FIXME : Different operation of NEW under brace format - subroutine call instead <GRF>
        mVar YKEY = m$.var("YKEY");
        m$.newVar(YKEY);
        //<< set YKEY=""
        YKEY.set("");
        //<< if YFOART=1 {
        if (mOp.Equal(m$.var("YFOART").get(),1)) {
          //<< new YLFN
          mVar YLFN = m$.var("YLFN");
          m$.newVar(YLFN);
          //<< for YLFN=1:1 {
          for (YLFN.set(1);(true);YLFN.set(mOp.Add(YLFN.get(),1))) {
            //<< quit:+$$$WWW121FixedInputForHiddenField($get(^WWW121(0,YFORM,YLFN,1)))=0
            if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN.get(),1)))),0)) {
              break;
            }
            //<< if $piece(YFKEY,",",YLFN)'="" set $piece(YKEY,",",YLFN)=$piece(YFKEY,",",YLFN)
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFKEY").get(),",",YLFN.get()),"")) {
              m$.pieceVar(YKEY,",",YLFN.get()).set(m$.Fnc.$piece(m$.var("YFKEY").get(),",",YLFN.get()));
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< set strWL = strWL_$$WWWCGI2^WWWCGI()
      strWL.set(mOp.Concat(strWL.get(),m$.fnc$("WWWCGI.WWWCGI2")));
      //<< write $$CreateWindowLocation^WWWBUTTON(strWL)
      m$.Cmd.Write(m$.fnc$("WWWBUTTON.CreateWindowLocation",strWL.get()));
      //<< write ">"
      m$.Cmd.Write(">");
      //<< 
      //<< do StopButton^WWWFORMCOMMON($$^WWWTEXT(130),"new.gif","BUTTON_NEW")
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWTEXT.main",130),"new.gif","BUTTON_NEW");
      //<< if $$$Buttons write "</A>"
      if (mOp.Logical($$$Buttons(m$))) {
        m$.Cmd.Write("</A>");
      }
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< OPEN
  public void OPEN() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Open data record
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 12-May-2006   JW      SR14508: Temporary exception for INWEINVEHeader
    //<< ;-------------------------------------------------------------------------------
    //<< new strImg
    mVar strImg = m$.var("strImg");
    m$.newVar(strImg);
    //<< 
    //<< if '$$$Buttons {
    if (mOp.Not($$$Buttons(m$))) {
      //<< if (YBEARB'=4) && ($$$WWW120AuthorizationToModifyData(YVOR)'=$$$EnumReadOnly) {
      if ((mOp.NotEqual(m$.var("YBEARB").get(),4)) && (mOp.NotEqual(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$)))) {
        //<< write "<TD>"
        m$.Cmd.Write("<TD>");
        //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_$$^WWWTEXT(101)_""" onClick="""     ; "Open"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.fnc$("WWWTEXT.main",101)),"\" onClick=\""));
        //<< do SaveNow(1)
        m$.Cmd.Do("SaveNow",1);
        //<< write """>"
        m$.Cmd.Write("\">");
        //<< write YCR,"</TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
      }
    }
    //<< }
    //<< 
    //<< } else {    ;wenn nicht gesperrt ;when not Disabled
    else {
      //<< if ($$$WWW120AuthorizationToModifyData(YVOR)'=$$$EnumCreateOnly) {   ;nur ERFASSEN ;solely Edit
      if ((mOp.NotEqual(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumCreateOnly(m$)))) {
        //<< $$$OpenTD($$$NO)
        include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
        //<< write "<A class=link onClick="""
        m$.Cmd.Write("<A class=link onClick=\"");
        //<< 
        //<< do SaveNow(1)
        m$.Cmd.Do("SaveNow",1);
        //<< write "return false;"
        m$.Cmd.Write("return false;");
        //<< write """>"
        m$.Cmd.Write("\">");
        //<< 
        //<< if YFORM="INWEINVEHeader" {
        if (mOp.Equal(m$.var("YFORM").get(),"INWEINVEHeader")) {
          //<< set strImg = "reset"
          strImg.set("reset");
          //<< set YSTATUS = $$^WWWTEXT(32810)     ; "Refresh"
          mVar YSTATUS = m$.var("YSTATUS");
          YSTATUS.set(m$.fnc$("WWWTEXT.main",32810));
        }
        //<< } else {
        else {
          //<< set strImg  = "open"
          strImg.set("open");
          //<< set YSTATUS = $$^WWWTEXT(101)       ; "Open"
          mVar YSTATUS = m$.var("YSTATUS");
          YSTATUS.set(m$.fnc$("WWWTEXT.main",101));
        }
        //<< }
        //<< do StopButton^WWWFORMCOMMON(YSTATUS,strImg_".gif","BUTTON_OPEN",$$$YES,$$$YES)
        m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.var("YSTATUS").get(),mOp.Concat(strImg.get(),".gif"),"BUTTON_OPEN",include.COMSYS.$$$YES(m$),include.COMSYS.$$$YES(m$));
        //<< write "</A>"
        m$.Cmd.Write("</A>");
      }
    }
    //<< }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< TEXT
  public void TEXT() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;TEXTBAUSTEIN ANZEIGE ;Show
    //<< ;
    //<< ; History:
    //<< ; 19-Feb-2007   JW      SR15240: Don't allow "pressing" of this 'button'.
    //<< ; 11-Oct-2005   GRF     Doco (SR13195 research)
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ; BEARBEITUNG System Parameter
    //<< ; ----------------------------
    //<< ; 1  New
    //<< ; 2  Save Changes?
    //<< ; 3  Saved
    //<< ; 4  Data Item In Use
    //<< ; 5  Wrong Data Input
    //<< ; 6  Open Or New
    //<< ; 7  Wrong Back Jump
    //<< ; 8  Read Only!!
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< ; Existing key or  No MRU List
    //<< ;---------------------------------------
    //<< new YBEA
    mVar YBEA = m$.var("YBEA");
    m$.newVar(YBEA);
    //<< 
    //<< ; FIXME : pass boolean for (strDontDisplay [ 4) to get list once <GRF>
    //<< 
    //<< set YBEA=""
    YBEA.set("");
    //<< 
    //<< write "<td class=""coolButton"" unselectable"
    m$.Cmd.Write("<td class=\"coolButton\" unselectable");
    //<< 
    //<< if ('$$IsNewRecord^WWWFORMStatus())||(+$$$WWW120NumberofMRURecordListItem(YVOR)=0) {
    if ((mOp.Not(m$.fnc$("WWWFORMStatus.IsNewRecord"))) || (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120NumberofMRURecordListItem(m$,m$.var("YVOR"))),0))) {
      //<< ; Change "Saved" to "Save Changes?"
      //<< if YBEARB=3 if $$$WWWUSERLastSave(^WWWUSER(0,YUSER,1))=9 set YBEA=$$^WWWTEXT(391) set YBEARB=2  ; "Not Saved!" ; Nicht gespeichert BEI LETZTER SPEICHERUNG
      if (mOp.Equal(m$.var("YBEARB").get(),3)) {
        if (mOp.Equal(include.WWWConst.$$$WWWUSERLastSave(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)),9)) {
          YBEA.set(m$.fnc$("WWWTEXT.main",391));
          mVar YBEARB = m$.var("YBEARB");
          YBEARB.set(2);
        }
      }
      //<< 
      //<< if $$$Buttons {                            ; AUSGESCHALTETE AKTIONSANZEIGE
      if (mOp.Logical($$$Buttons(m$))) {
        //<< if '$find(","_$piece(YVOR,Y,94)_",",",4,") {
        if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),94)),","),",4,"))) {
          //<< write " width=138"
          m$.Cmd.Write(" width=138");
        }
        //<< } else {
        else {
          //<< write " style=""display:none; visibility:hidden; overflow:hidden; width:0;"""
          m$.Cmd.Write(" style=\"display:none; visibility:hidden; overflow:hidden; width:0;\"");
        }
      }
      //<< }
      //<< }
      //<< write ">",YCR
      m$.Cmd.Write(">",m$.var("YCR").get());
      //<< 
      //<< write "<INPUT NAME=""YBEARB"""
      m$.Cmd.Write("<INPUT NAME=\"YBEARB\"");
      //<< 
      //<< ; "Data Item in Use"
      //<< if YBEARB=4 write YCR_" TITLE="""_$$GETLOCKDETAIL($get(YDATEI),$get(YKEY))_""""
      if (mOp.Equal(m$.var("YBEARB").get(),4)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YCR").get()," TITLE=\""),m$.fnc$("GETLOCKDETAIL",m$.Fnc.$get(m$.var("YDATEI")),m$.Fnc.$get(m$.var("YKEY")))),"\""));
      }
      //<< write YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< ; AUSGESCHALTETE AKTIONSANZEIGE
      //<< if $find(","_$piece(YVOR,Y,94)_",",",4,") {
      if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),94)),","),",4,"))) {
        //<< write " TYPE=""HIDDEN"""
        m$.Cmd.Write(" TYPE=\"HIDDEN\"");
      }
      //<< } else {
      else {
        //<< write " TYPE=""TEXT"" SIZE=""21"" MAXLENGTH=""20"""
        m$.Cmd.Write(" TYPE=\"TEXT\" SIZE=\"21\" MAXLENGTH=\"20\"");
      }
      //<< }
      //<< write YCR," onFocus='blur()';"
      m$.Cmd.Write(m$.var("YCR").get()," onFocus='blur()';");
      //<< write YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< if $piece(YVOR,Y,5)'="" write " STYLE=""background-color:"_$piece($get(^WWW100(0,"FARBE",SPRACHE,$piece(YVOR,Y,5),1)),Y,1)_""""
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),5),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" STYLE=\"background-color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),5),1)),m$.var("Y").get(),1)),"\""));
      }
      //<< write YCR,">",YCR
      m$.Cmd.Write(m$.var("YCR").get(),">",m$.var("YCR").get());
    }
    //<< 
    //<< } else {
    else {
      //<< ; MRU List : "Open" plus list
      //<< ;---------------------------------------
      //<< if $$$Buttons write " width=138"
      if (mOp.Logical($$$Buttons(m$))) {
        m$.Cmd.Write(" width=138");
      }
      //<< write ">",YCR
      m$.Cmd.Write(">",m$.var("YCR").get());
      //<< write "<INPUT NAME=""YBEARB"" TYPE=""HIDDEN"">"
      m$.Cmd.Write("<INPUT NAME=\"YBEARB\" TYPE=\"HIDDEN\">");
      //<< if +$$$WWW120NumberofMRURecordListItem(YVOR)'=0 do ^WWWFORM91  ;MULTISCHLUESSELVORGABE   ; TODO : Extra text not required
      if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW120NumberofMRURecordListItem(m$,m$.var("YVOR"))),0)) {
        m$.Cmd.Do("WWWFORM91.main");
      }
    }
    //<< }
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< do UpdateStatus^WWWFORMStatus(YFORM,YBEARB,$$$YES,YBEA)
    m$.Cmd.Do("WWWFORMStatus.UpdateStatus",m$.var("YFORM").get(),m$.var("YBEARB").get(),include.COMSYS.$$$YES(m$),YBEA.get());
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< $$$CloseTD
    include.WWWFORM.$$$CloseTD(m$);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< GETLOCKDETAIL(pidClass="",pstrKey="")
  public Object GETLOCKDETAIL(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; For a class and key return who locked it and when.
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 03-May-2010   GRF     SR15961: use dteToday for efficiency
    //<< ; 28-Jun-2005   shobby  SR12538: Language Text.  Enabled this existing routine
    //<< ; 09-Jun-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new dteToday,idLock,idSession,tmeLock,idUser,strText
    mVar dteToday = m$.var("dteToday");
    mVar idLock = m$.var("idLock");
    mVar idSession = m$.var("idSession");
    mVar tmeLock = m$.var("tmeLock");
    mVar idUser = m$.var("idUser");
    mVar strText = m$.var("strText");
    m$.newVar(dteToday,idLock,idSession,tmeLock,idUser,strText);
    //<< 
    //<< set strText=""
    strText.set("");
    //<< if (pidClass'="") {
    if ((mOp.NotEqual(pidClass.get(),""))) {
      //<< set idLock="^"_pidClass_"/"_$select($$$WWW001SharedFile($get(^WWW001(0,pidClass,1))):0,1:YM)_"."_$translate(pstrKey,",",".")_".1/"
      idLock.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",pidClass.get()),"/"),m$.Fnc.$select(include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,pidClass.get(),1))),0,1,m$.var("YM").get())),"."),m$.Fnc.$translate(pstrKey.get(),",",".")),".1/"));
      //<< set dteToday = +$horolog
      dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
      //<< if $data(^WWW006(0,dteToday,idLock,1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW006",0,dteToday.get(),idLock.get(),1)))) {
        //<< set idSession = $piece($get(^WWW006(0,dteToday,idLock,1)),Y,1)
        idSession.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW006",0,dteToday.get(),idLock.get(),1)),m$.var("Y").get(),1));
        //<< set tmeLock   = $piece($get(^WWW006(0,dteToday,idLock,1)),Y,2)
        tmeLock.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW006",0,dteToday.get(),idLock.get(),1)),m$.var("Y").get(),2));
        //<< if idSession'="" {
        if (mOp.NotEqual(idSession.get(),"")) {
          //<< set idUser = $piece($get(^WWWUSER(0,idSession,1)),Y,2)
          idUser.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,idSession.get(),1)),m$.var("Y").get(),2));
          //<< if idUser'="" {   ; "Locked By"  ;"at"
          if (mOp.NotEqual(idUser.get(),"")) {
            //<< set strText = $$$Text("WWW00023")_" : "_$$$WWW013Name($get(^WWW013(0,idUser,1)))_" "_$$$Text("WWW00024")_" : "_$$^WWWTIME(tmeLock)
            strText.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYS.$$$Text(m$,"WWW00023")," : "),include.WWWConst.$$$WWW013Name(m$,m$.Fnc.$get(m$.var("^WWW013",0,idUser.get(),1))))," "),include.COMSYS.$$$Text(m$,"WWW00024"))," : "),m$.fnc$("WWWTIME.main",tmeLock.get())));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit strText
    return strText.get();
  }

  //<< 
  //<< 
  //<< WV
  public void WV() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;  Reminder
    //<< ;-------------------------------------------------------------------------------
    //<< new TAGE,TEXT
    mVar TAGE = m$.var("TAGE");
    mVar TEXT = m$.var("TEXT");
    m$.newVar(TAGE,TEXT);
    //<< 
    //<< if (YKEY'="") && (YBEARB'=4) && (YBEARB'=1) && (YBEARB'=6) {
    if ((mOp.NotEqual(m$.var("YKEY").get(),"")) && (mOp.NotEqual(m$.var("YBEARB").get(),4)) && (mOp.NotEqual(m$.var("YBEARB").get(),1)) && (mOp.NotEqual(m$.var("YBEARB").get(),6))) {
      //<< $$$OpenTD($$$NO)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
      //<< set YSTATUS = $$^WWWTEXT(149)   ; "Reminder"
      mVar YSTATUS = m$.var("YSTATUS");
      YSTATUS.set(m$.fnc$("WWWTEXT.main",149));
      //<< if $$$Buttons {
      if (mOp.Logical($$$Buttons(m$))) {
        //<< set TAGE=+$$$WWW120ReminderWithinHowManyDays(YVOR)
        TAGE.set(mOp.Positive(include.WWWConst.$$$WWW120ReminderWithinHowManyDays(m$,m$.var("YVOR"))));
        //<< if TAGE=0 set TAGE=1
        if (mOp.Equal(TAGE.get(),0)) {
          TAGE.set(1);
        }
        //<< set TEXT=$$$WWW120ReminderText(YVOR)
        TEXT.set(include.WWWConst.$$$WWW120ReminderText(m$,m$.var("YVOR")));
        //<< 
        //<< write "<A class=link onClick="""     ; "Reminder On: (You may add text after the date)"
        m$.Cmd.Write("<A class=link onClick=\"");
        //<< write "pvalue = prompt('"_$$^WWWTEXT(149,,1)_" "_$$^WWWTEXT(293,,1)_": "_$$^WWWTEXT(325,,1)_"', '"_$$^WWWDATE($horolog+TAGE)_" "_TEXT_"');if (pvalue == null) alert('"_$$^WWWTEXT(324)_" "_$$^WWWTEXT(149)_"'); else {alert('"_$$^WWWTEXT(149)_" "_$$^WWWTEXT(293)_" ' + pvalue); SAVENOW('SAVEWV'+pvalue);}"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("pvalue = prompt('",m$.fnc$("WWWTEXT.main",149,null,1))," "),m$.fnc$("WWWTEXT.main",293,null,1)),": "),m$.fnc$("WWWTEXT.main",325,null,1)),"', '"),m$.fnc$("WWWDATE.main",mOp.Add(m$.Fnc.$horolog(),TAGE.get())))," "),TEXT.get()),"');if (pvalue == null) alert('"),m$.fnc$("WWWTEXT.main",324))," "),m$.fnc$("WWWTEXT.main",149)),"'); else {alert('"),m$.fnc$("WWWTEXT.main",149))," "),m$.fnc$("WWWTEXT.main",293))," ' + pvalue); SAVENOW('SAVEWV'+pvalue);}"));
        //<< write "return false;"
        m$.Cmd.Write("return false;");
        //<< write """>"
        m$.Cmd.Write("\">");
      }
      //<< }
      //<< do StopButton^WWWFORMCOMMON(YSTATUS,"wv.gif","BUTTON_REMIND",$$$YES,$$$YES)
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",YSTATUS.get(),"wv.gif","BUTTON_REMIND",include.COMSYS.$$$YES(m$),include.COMSYS.$$$YES(m$));
      //<< if $$$Buttons write "</A>"
      if (mOp.Logical($$$Buttons(m$))) {
        m$.Cmd.Write("</A>");
      }
    }
    //<< ; FIXME : Should there be a CloseTD?
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< BACK
  public void BACK() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Back button
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Nov-2010   shobby  SR17580: If this form was loaded from a search back button
    //<< ;                           will return to that search.
    //<< ; 12-Mar-2008   shobby  SRBR014897: 'Back' support YFKEYTS not necessary after
    //<< ;                           other changes under this SR.
    //<< ; 09-Oct-2007   Karine  BR014648: Check if back button is passing correct keys
    //<< ; 19-Feb-2007   JW      SR15240: Disable disabled button.
    //<< ;-------------------------------------------------------------------------------
    //<< new YBACK1,YBACK2,YFKEY1,YYALT,YSEITE,YINSEITE
    mVar YBACK1 = m$.var("YBACK1");
    mVar YBACK2 = m$.var("YBACK2");
    mVar YFKEY1 = m$.var("YFKEY1");
    mVar YYALT = m$.var("YYALT");
    mVar YSEITE = m$.var("YSEITE");
    mVar YINSEITE = m$.var("YINSEITE");
    m$.newVar(YBACK1,YBACK2,YFKEY1,YYALT,YSEITE,YINSEITE);
    //<< 
    //<< if $translate(YBACK,",")="" {
    if (mOp.Equal(m$.Fnc.$translate(m$.var("YBACK").get(),","),"")) {
      //<< if ($$$WWW012TargetFrameName(YVOR1)'="") {
      if ((mOp.NotEqual(include.WWWConst.$$$WWW012TargetFrameName(m$,m$.var("YVOR1")),""))) {
        //<< if $$$Buttons {               ;KEINE FUNKTION ;no
        if (mOp.Logical($$$Buttons(m$))) {
          //<< $$$OpenTD($$$YES)
          include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$YES(m$));
          //<< do StopButton^WWWFORMCOMMON("","hbackd.gif","BUTTON_BACK",$$$NO,,0)
          m$.Cmd.Do("WWWFORMCOMMON.StopButton","","hbackd.gif","BUTTON_BACK",include.COMSYS.$$$NO(m$),null,0);
        }
      }
      //<< }
      //<< } else {
      else {
        //<< $$$OpenTD($$$NO)
        include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
        //<< if YMENU'=4 {
        if (mOp.NotEqual(m$.var("YMENU").get(),4)) {
          //<< if '$$$Buttons {
          if (mOp.Not($$$Buttons(m$))) {
            //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$^WWWTEXT(99))_""" onClick=""window.location='"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",99))),"\" onClick=\"window.location='"));
          }
          //<< } else {
          else {
            //<< write "<A class=link onClick="" window.location'"
            m$.Cmd.Write("<A class=link onClick=\" window.location'");
          }
          //<< }
          //<< write YAKTION_"EP=WWWMENU"   ;ENDE ;termination
          m$.Cmd.Write(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWMENU"));
          //<< do ^WWWCGI
          m$.Cmd.Do("WWWCGI.main");
          //<< write "'"
          m$.Cmd.Write("'");
          //<< write """>"
          m$.Cmd.Write("\">");
        }
        //<< 
        //<< } elseIF $$$Buttons {
        else if (mOp.Logical($$$Buttons(m$))) {
          //<< write "<A onClick='return doLink(this)' HREF='JavaScript:window.focus();' TARGET='MENUE'>"
          m$.Cmd.Write("<A onClick='return doLink(this)' HREF='JavaScript:window.focus();' TARGET='MENUE'>");
        }
        //<< }
        //<< do StopButton^WWWFORMCOMMON($$^WWWTEXT(99),"hback.gif","BUTTON_BACK")
        m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWTEXT.main",99),"hback.gif","BUTTON_BACK");
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set YBACK1 = $piece(YBACK,",",$length(YBACK,",")-1)
      YBACK1.set(m$.Fnc.$piece(m$.var("YBACK").get(),",",mOp.Subtract(m$.Fnc.$length(m$.var("YBACK").get(),","),1)));
      //<< set YBACK2 = $piece(YBACK,",",1,$length(YBACK,",")-2)_","
      YBACK2.set(mOp.Concat(m$.Fnc.$piece(m$.var("YBACK").get(),",",1,mOp.Subtract(m$.Fnc.$length(m$.var("YBACK").get(),","),2)),","));
      //<< set YFKEY1 = $piece(YFKEY,",",1,$length(YFKEY,",")-2)
      YFKEY1.set(m$.Fnc.$piece(m$.var("YFKEY").get(),",",1,mOp.Subtract(m$.Fnc.$length(m$.var("YFKEY").get(),","),2)));
      //<< ;$$$OpenTD($$$NO)
      //<< $$$OpenTD($$$NO)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
      //<< 
      //<< set YFKEYTS = $translate(YFKEY,"# "_"""","~|")
      mVar YFKEYTS = m$.var("YFKEYTS");
      YFKEYTS.set(m$.Fnc.$translate(m$.var("YFKEY").get(),mOp.Concat("# ","\""),"~|"));
      //<< 
      //<< if '$$$Buttons {
      if (mOp.Not($$$Buttons(m$))) {
        //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$^WWWTEXT(99))_""" onClick=""window.location='"      ; Back
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",99))),"\" onClick=\"window.location='"));
      }
      //<< 
      //<< } else {
      else {
        //<< ;WRITE "<A HREF="""
        //<< write "<A class=link onClick="" window.location='"
        m$.Cmd.Write("<A class=link onClick=\" window.location='");
      }
      //<< }
      //<< 
      //<< new YBACK,YFKEY              ; FIXME : Different operation of NEW under brace format - subroutine call instead <GRF>
      mVar YBACK = m$.var("YBACK");
      mVar YFKEY = m$.var("YFKEY");
      m$.newVar(YBACK,YFKEY);
      //<< 
      //<< if YBACK1="WWWSEAR" {  ;SR17580
      if (mOp.Equal(YBACK1.get(),"WWWSEAR")) {
        //<< write YAKTION_"EP=WWWSEAR&amp;YFORM="_YFORM_"&amp;YLOCKKILL=1"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWSEAR&amp;YFORM="),m$.var("YFORM").get()),"&amp;YLOCKKILL=1"));
        //<< 
        //<< if $extract(YOPEN,1,4)="SAVE" write "&amp;YOPEN=OLD"
        if (mOp.Equal(m$.Fnc.$extract(m$.var("YOPEN").get(),1,4),"SAVE")) {
          m$.Cmd.Write("&amp;YOPEN=OLD");
        }
        //<< do ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< 
        //<< set YYALT=""
        YYALT.set("");
        //<< write "'"
        m$.Cmd.Write("'");
        //<< write """>"
        m$.Cmd.Write("\">");
        //<< set YYALT = $$^WWWTEXT(99)   ; "Back"
        YYALT.set(m$.fnc$("WWWTEXT.main",99));
      }
      //<< 
      //<< } else {
      else {
        //<< write YAKTION_"EP=WWWFORM&amp;YFORM="_YBACK1
        m$.Cmd.Write(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),YBACK1.get()));
        //<< 
        //<< if $extract(YOPEN,1,4)="SAVE" write "&amp;YOPEN=OLD"
        if (mOp.Equal(m$.Fnc.$extract(m$.var("YOPEN").get(),1,4),"SAVE")) {
          m$.Cmd.Write("&amp;YOPEN=OLD");
        }
        //<< write "&amp;YRETURN=1"
        m$.Cmd.Write("&amp;YRETURN=1");
        //<< set YBACK = YBACK2
        YBACK.set(YBACK2.get());
        //<< set YFKEY = YFKEY1
        YFKEY.set(YFKEY1.get());
        //<< do ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< 
        //<< write "'"
        m$.Cmd.Write("'");
        //<< write """>"
        m$.Cmd.Write("\">");
        //<< set YYALT = ""
        YYALT.set("");
        //<< if YBACK1'=""                 set YYALT = $piece($get(^WWW1201(0,YBACK1,SPRACHE,1)),Y,1)
        if (mOp.NotEqual(YBACK1.get(),"")) {
          YYALT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1201",0,YBACK1.get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
        }
        //<< if (YYALT="") && (YBACK1'="") set YYALT = $piece($get(^WWW120(0,YBACK1,1)),Y,1)
        if ((mOp.Equal(YYALT.get(),"")) && (mOp.NotEqual(YBACK1.get(),""))) {
          YYALT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YBACK1.get(),1)),m$.var("Y").get(),1));
        }
        //<< if YYALT=""                   set YYALT = $$^WWWTEXT(99)   ; "Back"
        if (mOp.Equal(YYALT.get(),"")) {
          YYALT.set(m$.fnc$("WWWTEXT.main",99));
        }
      }
      //<< }
      //<< do StopButton^WWWFORMCOMMON(YYALT,"hback.gif","BUTTON_BACK")
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",YYALT.get(),"hback.gif","BUTTON_BACK");
      //<< $$$CloseTD
      include.WWWFORM.$$$CloseTD(m$);
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< END ;  Cancel
  public void END() {
    //<< 
    //<< $$$OpenTD($$$NO)
    include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
    //<< if YMENU=4 {
    if (mOp.Equal(m$.var("YMENU").get(),4)) {
      //<< if '$$$Buttons {
      if (mOp.Not($$$Buttons(m$))) {
        //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$^WWWTEXT(10))_""" onClick=""window.blur();"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",10))),"\" onClick=\"window.blur();"));
      }
      //<< } else {
      else {
        //<< write "<A onClick='return doLink(this)' HREF='JavaScript:window.focus();' TARGET=""MENUE"_$$$GetTopUser(YUSER)
        m$.Cmd.Write(mOp.Concat("<A onClick='return doLink(this)' HREF='JavaScript:window.focus();' TARGET=\"MENUE",include.COMSYSWWW.$$$GetTopUser(m$,m$.var("YUSER"))));
      }
    }
    //<< }
    //<< 
    //<< } else {    ;Cancel without window
    else {
      //<< if '$$$Buttons {
      if (mOp.Not($$$Buttons(m$))) {
        //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$^WWWTEXT(10))_""" onClick=""window.location='"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",10))),"\" onClick=\"window.location='"));
      }
      //<< } else {
      else {
        //<< write "<A class=link onClick="" window.location='"
        m$.Cmd.Write("<A class=link onClick=\" window.location='");
      }
      //<< }
      //<< if $$$WWW012TargetFrameName(YVOR1)="" {
      if (mOp.Equal(include.WWWConst.$$$WWW012TargetFrameName(m$,m$.var("YVOR1")),"")) {
        //<< write YAKTION_"EP=WWWMENU"   ;ENDE ;termination
        m$.Cmd.Write(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWMENU"));
        //<< do ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
      }
      //<< 
      //<< } else {
      else {
        //<< write YGIF_"blank.htm"
        m$.Cmd.Write(mOp.Concat(m$.var("YGIF").get(),"blank.htm"));
      }
      //<< }
      //<< write "'"
      m$.Cmd.Write("'");
    }
    //<< }
    //<< write """>"
    m$.Cmd.Write("\">");
    //<< do StopButton^WWWFORMCOMMON($$^WWWTEXT(10),"end.gif","BUTTON_END")
    m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWTEXT.main",10),"end.gif","BUTTON_END");
    //<< if $$$Buttons write "</A>"
    if (mOp.Logical($$$Buttons(m$))) {
      m$.Cmd.Write("</A>");
    }
    //<< $$$CloseTD
    include.WWWFORM.$$$CloseTD(m$);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< HELP
  public void HELP() {
    //<< if YFORM'="WWW127" {
    if (mOp.NotEqual(m$.var("YFORM").get(),"WWW127")) {
      //<< do HelpButton($$$YES,YFORM,20)
      m$.Cmd.Do("HelpButton",include.COMSYS.$$$YES(m$),m$.var("YFORM").get(),20);
    }
    //<< } elseif ($$$WWW120AuthorizationToModifyData(YVOR)'=$$$EnumCreateOnly) && $data(FORMULAR) {
    else if ((mOp.NotEqual(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumCreateOnly(m$))) && mOp.Logical(m$.Fnc.$data(m$.var("FORMULAR")))) {
      //<< do HelpButton($$$NO,FORMULAR,99)
      m$.Cmd.Do("HelpButton",include.COMSYS.$$$NO(m$),m$.var("FORMULAR").get(),99);
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< HelpButton(pblnPopup,pstrForm,pstrText) private
  public Object HelpButton(Object ... _p) {
    mVar pblnPopup = m$.newVarRef("pblnPopup",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Dec-2006   JW      SR14235: Rewrote. Added reference to child window
    //<< ;-------------------------------------------------------------------------------
    //<< new strURL
    mVar strURL = m$.var("strURL");
    m$.newVar(strURL);
    //<< 
    //<< set pstrText = $$^WWWTEXT(pstrText)
    pstrText.set(m$.fnc$("WWWTEXT.main",pstrText.get()));
    //<< set strURL = YAKTION_"EP=WWWHELP&amp;YFORM="_pstrForm_$$WWWCGI2^WWWCGI(pblnPopup)_"&amp;YSEITE="_YSEITE
    strURL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWHELP&amp;YFORM="),pstrForm.get()),m$.fnc$("WWWCGI.WWWCGI2",pblnPopup.get())),"&amp;YSEITE="),m$.var("YSEITE").get()));
    //<< 
    //<< $$$OpenTD($$$NO)
    include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
    //<< 
    //<< if '$$$Buttons {
    if (mOp.Not($$$Buttons(m$))) {
      //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML(pstrText)_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",pstrText.get())),"\""));
    }
    //<< } else {
    else {
      //<< write "<A class=link"
      m$.Cmd.Write("<A class=link");
    }
    //<< }
    //<< 
    //<< if pblnPopup {
    if (mOp.Logical(pblnPopup.get())) {
      //<< write " onClick=""subWindow('"_strURL_"','HELP"_YTARGET_"');"">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onClick=\"subWindow('",strURL.get()),"','HELP"),m$.var("YTARGET").get()),"');\">"));
    }
    //<< } else {
    else {
      //<< write " onClick=""window.location='"_strURL_"'"">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" onClick=\"window.location='",strURL.get()),"'\">"));
    }
    //<< }
    //<< do StopButton^WWWFORMCOMMON(pstrText,"help.gif","BUTTON_HELP",$$$YES,$$$NO,"cursor:help")
    m$.Cmd.Do("WWWFORMCOMMON.StopButton",pstrText.get(),"help.gif","BUTTON_HELP",include.COMSYS.$$$YES(m$),include.COMSYS.$$$NO(m$),"cursor:help");
    //<< if $$$Buttons write "</A>"
    if (mOp.Logical($$$Buttons(m$))) {
      m$.Cmd.Write("</A>");
    }
    //<< $$$CloseTD
    include.WWWFORM.$$$CloseTD(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SEARCH
  public void SEARCH() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; "Search"
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Oct-2010   shobby  SR17540: Removed HREF=""#"" from the anchor link.
    //<< ; 14-Oct-2009   GRF     SR16938: Condense to single write statement
    //<< ; 14-Oct-2009   shobby  SR16938: Changed the redirection mechanism.
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< $$$OpenTD($$$NO)
    include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
    //<< if '$$$Buttons {    ; "Search"
    if (mOp.Not($$$Buttons(m$))) {
      //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$^WWWTEXT(148))_""" onClick=""ShowSearch();"">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",148))),"\" onClick=\"ShowSearch();\">"));
    }
    //<< 
    //<< } else {
    else {
      //<< write "<A onClick=""ShowSearch();"">"  ;SR17540
      m$.Cmd.Write("<A onClick=\"ShowSearch();\">");
    }
    //<< }
    //<< 
    //<< do StopButton^WWWFORMCOMMON($$^WWWTEXT(148),"search.gif","BUTTON_SEARCH")
    m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWTEXT.main",148),"search.gif","BUTTON_SEARCH");
    //<< if $$$Buttons write "</A>"
    if (mOp.Logical($$$Buttons(m$))) {
      m$.Cmd.Write("</A>");
    }
    //<< $$$CloseTD
    include.WWWFORM.$$$CloseTD(m$);
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< SaveNow(pYOPEN=0)
  public Object SaveNow(Object ... _p) {
    mVar pYOPEN = m$.newVarRef("pYOPEN",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< write "document.WWW.target='';"
    m$.Cmd.Write("document.WWW.target='';");
    //<< write "document.WWW.YBUTTON.value='';"
    m$.Cmd.Write("document.WWW.YBUTTON.value='';");
    //<< write "document.WWW.YRICHT1.value='';"
    m$.Cmd.Write("document.WWW.YRICHT1.value='';");
    //<< write "SAVENOW("_pYOPEN_");"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("SAVENOW(",pYOPEN.get()),");"));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SAVE
  public void SAVE() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Save button
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Feb-2007   JW      SR15240: Disable disabled button.
    //<< ;-------------------------------------------------------------------------------
    //<< new strText
    mVar strText = m$.var("strText");
    m$.newVar(strText);
    //<< 
    //<< if (YBEARB=4) || ($$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly) {   ; "IN USE"
    if ((mOp.Equal(m$.var("YBEARB").get(),4)) || (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$)))) {
      //<< if $$$Buttons {
      if (mOp.Logical($$$Buttons(m$))) {
        //<< $$$OpenTD($$$YES)
        include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$YES(m$));
        //<< do StopButton^WWWFORMCOMMON("","saved.gif","BUTTONNOSAVE")
        m$.Cmd.Do("WWWFORMCOMMON.StopButton","","saved.gif","BUTTONNOSAVE");
      }
    }
    //<< }
    //<< 
    //<< } elseif '$$$Buttons {
    else if (mOp.Not($$$Buttons(m$))) {
      //<< write "<TD WIDTH=10>"
      m$.Cmd.Write("<TD WIDTH=10>");
      //<< write "<INPUT TYPE=""SUBMIT"" VALUE="""
      m$.Cmd.Write("<INPUT TYPE=\"SUBMIT\" VALUE=\"");
      //<< write $case($$$WWW120AuthorizationToModifyData(YVOR)<4,$$$YES:$$^WWWUML($$^WWWTEXT(165)),$$$NO:"OK")    ; "Save"
      m$.Cmd.Write(m$.Fnc.$case(mOp.Less(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),4),include.COMSYS.$$$YES(m$),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",165)),include.COMSYS.$$$NO(m$),"OK"));
      //<< write """ onClick=""document.WWW.YOPEN.value=0;"">" ; SPEICHERN ;Save
      m$.Cmd.Write("\" onClick=\"document.WWW.YOPEN.value=0;\">");
      //<< write YCR,"</TD>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
    }
    //<< 
    //<< } else {    // Save + button
    else {
      //<< set strText = $case($$$WWW120AuthorizationToModifyData(YVOR)<4,$$$YES:165,$$$NO:"Com00183")
      strText.set(m$.Fnc.$case(mOp.Less(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),4),include.COMSYS.$$$YES(m$),165,include.COMSYS.$$$NO(m$),"Com00183"));
      //<< 
      //<< if $$$WWW120FastSave(YVOR) {
      if (mOp.Logical(include.WWWConst.$$$WWW120FastSave(m$,m$.var("YVOR")))) {
        //<< do FastSave("save","","SAVE",strText)
        m$.Cmd.Do("FastSave","save","","SAVE",strText.get());
      }
      //<< 
      //<< } else {
      else {
        //<< $$$OpenTD($$$NO)
        include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
        //<< write "<A class=link onClick="""
        m$.Cmd.Write("<A class=link onClick=\"");
        //<< do SaveNow()
        m$.Cmd.Do("SaveNow");
        //<< write "return false;"
        m$.Cmd.Write("return false;");
        //<< write """>"
        m$.Cmd.Write("\">");
        //<< do StopButton^WWWFORMCOMMON($$^WWWUML($$^WWWTEXT(strText)),"save.gif","BUTTON_SAVE")
        m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",strText.get())),"save.gif","BUTTON_SAVE");
        //<< write "</A>",YCR
        m$.Cmd.Write("</A>",m$.var("YCR").get());
        //<< $$$CloseTD
        include.WWWFORM.$$$CloseTD(m$);
      }
    }
    //<< }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< Direction(pstrImg,pstrEvent,pstrButton,pstrPic,pstrText)
  public Object Direction(Object ... _p) {
    mVar pstrImg = m$.newVarRef("pstrImg",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrEvent = m$.newVarRef("pstrEvent",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrButton = m$.newVarRef("pstrButton",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrPic = m$.newVarRef("pstrPic",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Navigational buttons
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Sep-2009   shobby  SR16913: tweaked to support locking the form during operation
    //<< ; 30-Nov-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $$$WWW120FastSave(YVOR) {
    if (mOp.Logical(include.WWWConst.$$$WWW120FastSave(m$,m$.var("YVOR")))) {
      //<< do FastSave(pstrImg,pstrEvent,pstrButton,pstrText)
      m$.Cmd.Do("FastSave",pstrImg.get(),pstrEvent.get(),pstrButton.get(),pstrText.get());
    }
    //<< 
    //<< } else {
    else {
      //<< $$$OpenTD($$$NO)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
      //<< if '$$$Buttons {
      if (mOp.Not($$$Buttons(m$))) {
        //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_pstrPic_""""
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",pstrPic.get()),"\""));
      }
      //<< } else {
      else {
        //<< write "<A class=link"
        m$.Cmd.Write("<A class=link");
      }
      //<< }
      //<< write $$CreateWindowLocation^WWWBUTTON($$DirectionURL2(pstrEvent))
      m$.Cmd.Write(m$.fnc$("WWWBUTTON.CreateWindowLocation",m$.fnc$("DirectionURL2",pstrEvent.get())));
      //<< write ">"
      m$.Cmd.Write(">");
      //<< do StopButton^WWWFORMCOMMON($$^WWWUML($$^WWWTEXT(pstrText)),pstrImg_".gif","BUTTON_"_pstrButton)
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",pstrText.get())),mOp.Concat(pstrImg.get(),".gif"),mOp.Concat("BUTTON_",pstrButton.get()));
      //<< if $$$Buttons write "</A>"
      if (mOp.Logical($$$Buttons(m$))) {
        m$.Cmd.Write("</A>");
      }
      //<< $$$CloseTD
      include.WWWFORM.$$$CloseTD(m$);
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DirectionURL(pstrEvent)
  public Object DirectionURL(Object ... _p) {
    mVar pstrEvent = m$.newVarRef("pstrEvent",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : WWWFORMF and WWWFORM8
    //<< ;
    //<< ; History:
    //<< ; 29-Sep-2009   shobby      SR16913: Redirect to DirectionURL2
    //<< ;-------------------------------------------------------------------------------
    //<< write $$DirectionURL2(pstrEvent)
    m$.Cmd.Write(m$.fnc$("DirectionURL2",pstrEvent.get()));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DirectionURL2(pstrEvent)
  public Object DirectionURL2(Object ... _p) {
    mVar pstrEvent = m$.newVarRef("pstrEvent",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; History:
    //<< ; 29-Sep-2009   shobby      SR16913:
    //<< ;-------------------------------------------------------------------------------
    //<< quit YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM_"&amp;YRICHT="_pstrEvent_"&amp;YBUTTON="_$$WWWCGI2^WWWCGI()
    return mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()),"&amp;YRICHT="),pstrEvent.get()),"&amp;YBUTTON="),m$.fnc$("WWWCGI.WWWCGI2"));
  }

  //<< 
  //<< 
  //<< FastSave(pstrImg,pstrEvent,pstrButton,pstrText)
  public Object FastSave(Object ... _p) {
    mVar pstrImg = m$.newVarRef("pstrImg",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrEvent = m$.newVarRef("pstrEvent",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrButton = m$.newVarRef("pstrButton",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< if (YBEARB'=4) && ($$$WWW120AuthorizationToModifyData(YVOR)'=$$$EnumReadOnly) && $$$Buttons {
    if ((mOp.NotEqual(m$.var("YBEARB").get(),4)) && (mOp.NotEqual(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$))) && mOp.Logical($$$Buttons(m$))) {
      //<< write YCR,"<TD WIDTH=10 class=""coolButton"">"
      m$.Cmd.Write(m$.var("YCR").get(),"<TD WIDTH=10 class=\"coolButton\">");
      //<< 
      //<< write YCR,"<IMG SRC="""_YGIF_pstrImg_".gif"" "_YHEIGHT_" "_YWIDTH_" TITLE="""_$$^WWWTEXT(pstrText)_""" border=0 "
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),pstrImg.get()),".gif\" "),m$.var("YHEIGHT").get())," "),m$.var("YWIDTH").get())," TITLE=\""),m$.fnc$("WWWTEXT.main",pstrText.get())),"\" border=0 "));
      //<< write "onClick=""retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','"_pstrEvent_"','9'); BEARB('"_$get(^WWW100(0,"BEARBEITUNG",SPRACHE,3,1))_"');"""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("onClick=\"retval=EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','Y"),m$.var("YFORM").get()),"','"),pstrEvent.get()),"','9'); BEARB('"),m$.Fnc.$get(m$.var("^WWW100",0,"BEARBEITUNG",m$.var("SPRACHE").get(),3,1))),"');\""));
      //<< write " id=""BUTTON_"_pstrButton_""">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" id=\"BUTTON_",pstrButton.get()),"\">"));
      //<< 
      //<< write YCR,"</TD>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AllKeys(pidForm,pstrKey)
  public Object AllKeys(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Do we have all the required keys for this form?
    //<< ;
    //<< ; Params:   pidForm     : The form to check
    //<< ;           pstrKey     : The key we're using
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  blnKeys     : Whether we have all the keys or not
    //<< ;
    //<< ; History:
    //<< ; 17-Oct-2006   SteveS  SR15086: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnKeys,intNumKeys
    mVar blnKeys = m$.var("blnKeys");
    mVar intNumKeys = m$.var("intNumKeys");
    m$.newVar(blnKeys,intNumKeys);
    //<< 
    //<< set blnKeys = $$$YES
    blnKeys.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< set intNumKeys = +$order(^WWW121(0,pidForm,""),-1)
    intNumKeys.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW121",0,pidForm.get(),""),mOp.Negative(1))));
    //<< if (intNumKeys>0) set blnKeys = $$GetKey^COMUtilClass(pstrKey,intNumKeys)
    if ((mOp.Greater(intNumKeys.get(),0))) {
      blnKeys.set(m$.fnc$("COMUtilClass.GetKey",pstrKey.get(),intNumKeys.get()));
    }
    //<< 
    //<< quit blnKeys
    return blnKeys.get();
  }

  //<< 
  //<< 
  //<< DELETE
  public void DELETE() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Delete button - available when there is a data record
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Feb-2007   JW      SR15240: Disable disabled button.
    //<< ; 14-Dec-2006   JW      BR014285: Allow for error message
    //<< ; 17-Oct-2006   SteveS  SR15086: Don't check YKEY for null, use $$AllKeys.
    //<< ; 25-Jul-2006   JW      SR14799: Added double quote. Check before overriding with ""
    //<< ;-------------------------------------------------------------------------------
    //<< new YDISDEL,Q,YQ,strExec,YKILL,YKEY1,YDEL,idFormRedirect,objWWW120,idFormRedirectKey
    mVar YDISDEL = m$.var("YDISDEL");
    mVar Q = m$.var("Q");
    mVar YQ = m$.var("YQ");
    mVar strExec = m$.var("strExec");
    mVar YKILL = m$.var("YKILL");
    mVar YKEY1 = m$.var("YKEY1");
    mVar YDEL = m$.var("YDEL");
    mVar idFormRedirect = m$.var("idFormRedirect");
    mVar objWWW120 = m$.var("objWWW120");
    mVar idFormRedirectKey = m$.var("idFormRedirectKey");
    m$.newVar(YDISDEL,Q,YQ,strExec,YKILL,YKEY1,YDEL,idFormRedirect,objWWW120,idFormRedirectKey);
    //<< new strTooltip
    mVar strTooltip = m$.var("strTooltip");
    m$.newVar(strTooltip);
    //<< 
    //<< ;++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //<< ; YDISDEL  : Disable Delete Flag - can't delete when set to $$$YES
    //<< ;++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< set YDISDEL    = $$$NO
    YDISDEL.set(include.COMSYS.$$$NO(m$));
    //<< set strTooltip = $listbuild(45)   ; "Not Deletable"
    strTooltip.set(m$.Fnc.$listbuild(45));
    //<< 
    //<< set strExec = $$$WWW120ExecuteBeforeDeletePossib(YVOR)     ;   *** EXECUTE ***
    strExec.set(include.WWWConst.$$$WWW120ExecuteBeforeDeletePossib(m$,m$.var("YVOR")));
    //<< if strExec'="" {
    if (mOp.NotEqual(strExec.get(),"")) {
      //<< set Q = 0,YQ = 0
      Q.set(0);
      YQ.set(0);
      //<< xecute strExec
      m$.Cmd.Xecute(strExec.get());
      //<< if (+YQ=1) || (+Q=1) {
      if ((mOp.Equal(mOp.Positive(YQ.get()),1)) || (mOp.Equal(mOp.Positive(Q.get()),1))) {
        //<< set YDISDEL = $$$YES                    ;NICHT LÖSCHEN ;Not Delete
        YDISDEL.set(include.COMSYS.$$$YES(m$));
        //<< if $extract(Q,2,999)'="" {              ; Allow for error message
        if (mOp.NotEqual(m$.Fnc.$extract(Q.get(),2,999),"")) {
          //<< set strTooltip = $extract(Q,2,999)
          strTooltip.set(m$.Fnc.$extract(Q.get(),2,999));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< set YKEY1 = YKEY
    YKEY1.set(m$.var("YKEY").get());
    //<< 
    //<< if (YDISDEL=$$$NO) &&
    //<< (($$$WWW120AuthorizationToModifyData(YVOR)<2) || ($$$WWW120AuthorizationToModifyData(YVOR)=4)) &&
    //<< $$AllKeys(YFORM,YKEY)      {   ;LÖSCHEN ;Delete
    if ((mOp.Equal(YDISDEL.get(),include.COMSYS.$$$NO(m$))) && mOp.Logical(((mOp.Less(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),2)) || (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),4)))) && mOp.Logical(m$.fnc$("AllKeys",m$.var("YFORM").get(),m$.var("YKEY").get()))) {
      //<< 
      //<< $$$OpenTD($$$NO)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
      //<< if '$$$Buttons {
      if (mOp.Not($$$Buttons(m$))) {
        //<< set YDEL = $$^WWWTEXT(41)  ; "Delete"
        YDEL.set(m$.fnc$("WWWTEXT.main",41));
        //<< if $piece($$$WWW120StandardSubmit(YVOR),",",3)'="" set YDEL = $$^WWWTEXT($piece($$$WWW120StandardSubmit(YVOR),",",3))
        if (mOp.NotEqual(m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",3),"")) {
          YDEL.set(m$.fnc$("WWWTEXT.main",m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",3)));
        }
        //<< 
        //<< write "<INPUT TYPE=""BUTTON"""
        m$.Cmd.Write("<INPUT TYPE=\"BUTTON\"");
        //<< if $$$WWW120StylesheetCSSFile(YVOR)'="" write " class=""button"""
        if (mOp.NotEqual(include.WWWConst.$$$WWW120StylesheetCSSFile(m$,m$.var("YVOR")),"")) {
          m$.Cmd.Write(" class=\"button\"");
        }
        //<< write " VALUE="""_YAM_$$^WWWUML(YDEL)_""""
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",YDEL.get())),"\""));
      }
      //<< } else {
      else {
        //<< write "<A class=link"
        m$.Cmd.Write("<A class=link");
      }
      //<< }
      //<< 
      //<< write " onClick=""if (confirm('"_$$^WWWTEXT(321)_"')) { BEARB('',1); window.location='"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" onClick=\"if (confirm('",m$.fnc$("WWWTEXT.main",321)),"')) { BEARB('',1); window.location='"));
      //<< 
      //<< if $get(YTIMEFORM)'=1 {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
        //<< write YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM_"&amp;YRICHT=NEXT"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()),"&amp;YRICHT=NEXT"));
      }
      //<< } else {
      else {
        //<< write YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM_"t&amp;YRICHT=NEXT"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()),"t&amp;YRICHT=NEXT"));
        //<< write "&amp;YTIMEFORM=1"
        m$.Cmd.Write("&amp;YTIMEFORM=1");
      }
      //<< }
      //<< 
      //<< if YFOART=3 write "&amp;YSORT="_$get(YSORT)_"&amp;YORIENT="_$get(YORIENT)   ;WENN GRID  DANN SORT
      if (mOp.Equal(m$.var("YFOART").get(),3)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YSORT=",m$.Fnc.$get(m$.var("YSORT"))),"&amp;YORIENT="),m$.Fnc.$get(m$.var("YORIENT"))));
      }
      //<< set YKILL=1
      YKILL.set(1);
      //<< do ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< write "'; }"">"
      m$.Cmd.Write("'; }\">");
      //<< do StopButton^WWWFORMCOMMON($$^WWWTEXT(41),"del.gif","BUTTON_DELETE",,,)
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWTEXT.main",41),"del.gif","BUTTON_DELETE",null,null,null);
      //<< $$$CloseTD
      include.WWWFORM.$$$CloseTD(m$);
    }
    //<< 
    //<< } elseif $$$Buttons {
    else if (mOp.Logical($$$Buttons(m$))) {
      //<< $$$OpenTD($$$YES)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$YES(m$));
      //<< do StopButton^WWWFORMCOMMON($$$HTMLText($$$Text(strTooltip)),"disdel.gif","BUTTON_NODELETE",$$$NO,,0)
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",include.COMSYSString.$$$HTMLText(m$,include.COMSYS.$$$Text(m$,strTooltip)),"disdel.gif","BUTTON_NODELETE",include.COMSYS.$$$NO(m$),null,0);
      //<< $$$CloseTD
      include.WWWFORM.$$$CloseTD(m$);
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< NEWREC  ;BEARBEITUNGSTABELLE: NEUEN DATENSATZ ANLEGEN
  public void NEWREC() {
    do {
      //<< do   ;UNDO
      //<< . new YKILL,YKEY1
      mVar YKILL = m$.var("YKILL");
      mVar YKEY1 = m$.var("YKEY1");
      m$.newVar(YKILL,YKEY1);
      //<< . $$$OpenTD($$$NO)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
      //<< . if '$$$Buttons write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$^WWWTEXT(33946))_""""   ; "Create New Data Record"
      if (mOp.Not($$$Buttons(m$))) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",33946))),"\""));
      }
      //<< . if $$$Buttons  write "<A HREF=""#"""
      if (mOp.Logical($$$Buttons(m$))) {
        m$.Cmd.Write("<A HREF=\"#\"");
      }
      //<< . write " onClick='javascript:pruef(45);document.WWW.YOPEN.value=""""'>"
      m$.Cmd.Write(" onClick='javascript:pruef(45);document.WWW.YOPEN.value=\"\"'>");
      //<< . if '$$$Buttons write """>"
      if (mOp.Not($$$Buttons(m$))) {
        m$.Cmd.Write("\">");
      }
      //<< . ;;if $$$Buttons
      //<< . ;;. do StopButton^WWWFORMCOMMON($$^WWWTEXT(33946),"new.gif","BUTTON_NEW")
      //<< . ;;. write "</A>"
      //<< . ;;write                  ; FIXME : missing?  unnecessary?
      //<< . $$$CloseTD
      include.WWWFORM.$$$CloseTD(m$);
    } while(false);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< SAVREC  ;BEARBEITUNGSTABELLE: NEUEN DATENSATZ SPEICHERN
  public void SAVREC() {
    do {
      //<< do
      //<< . new YKILL,YKEY1
      mVar YKILL = m$.var("YKILL");
      mVar YKEY1 = m$.var("YKEY1");
      m$.newVar(YKILL,YKEY1);
      //<< . $$$OpenTD($$$NO)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
      //<< . if '$$$Buttons write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$^WWWTEXT(11))_""""   ; "Save Data"
      if (mOp.Not($$$Buttons(m$))) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",11))),"\""));
      }
      //<< . if $$$Buttons  write "<A HREF=""#"""
      if (mOp.Logical($$$Buttons(m$))) {
        m$.Cmd.Write("<A HREF=\"#\"");
      }
      //<< . write " onClick='if (yaddline ==1) {pruef(45);} else {alert("""_$$^WWWTEXT(34099)_""");}'>"  ; "No New Data Record Has Been Saved" ;KEIN NEUER DATENSATZ ANGELEGT
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" onClick='if (yaddline ==1) {pruef(45);} else {alert(\"",m$.fnc$("WWWTEXT.main",34099)),"\");}'>"));
      //<< . if $$$Buttons write YCR,"<IMG SRC="""_YGIF_"save.gif"" "_YHEIGHT_" "_YWIDTH_" TITLE="""_$$^WWWTEXT(11)_""" border=0 id=""BUTTON_SAVE""></A>"  ;SPEICHERN ;Save
      if (mOp.Logical($$$Buttons(m$))) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"save.gif\" "),m$.var("YHEIGHT").get())," "),m$.var("YWIDTH").get())," TITLE=\""),m$.fnc$("WWWTEXT.main",11)),"\" border=0 id=\"BUTTON_SAVE\"></A>"));
      }
      //<< . $$$CloseTD
      include.WWWFORM.$$$CloseTD(m$);
    } while(false);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< DELREC  ;BEARBEITUNGSTABELLE: DATENSATZ LÖSCHEN
  public void DELREC() {
    do {
      //<< do
      //<< . new YKILL,YKEY1
      mVar YKILL = m$.var("YKILL");
      mVar YKEY1 = m$.var("YKEY1");
      m$.newVar(YKILL,YKEY1);
      //<< . $$$OpenTD($$$NO)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
      //<< . if '$$$Buttons write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$^WWWTEXT(122))_""""  ; "Delete"
      if (mOp.Not($$$Buttons(m$))) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",122))),"\""));
      }
      //<< . if $$$Buttons  write "<A HREF=""#"""
      if (mOp.Logical($$$Buttons(m$))) {
        m$.Cmd.Write("<A HREF=\"#\"");
      }
      //<< . write " onClick='JavaScript:pruef(46);'>"
      m$.Cmd.Write(" onClick='JavaScript:pruef(46);'>");
      //<< . if $$$Buttons write YCR,"<IMG SRC="""_YGIF_"del.gif"" "_YHEIGHT_" "_YWIDTH_" TITLE="""_$$^WWWTEXT(122)_""" border=0 id=""BUTTON_DELETE""></A>"  ;LÖSCHEN ;Delete
      if (mOp.Logical($$$Buttons(m$))) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"del.gif\" "),m$.var("YHEIGHT").get())," "),m$.var("YWIDTH").get())," TITLE=\""),m$.fnc$("WWWTEXT.main",122)),"\" border=0 id=\"BUTTON_DELETE\"></A>"));
      }
      //<< . $$$CloseTD
      include.WWWFORM.$$$CloseTD(m$);
    } while(false);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< RESET ;RESET
  public void RESET() {
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< if YFOART'=5 do
    if (mOp.NotEqual(m$.var("YFOART").get(),5)) {
      //<< . $$$OpenTD($$$NO)
      include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
      //<< . if '$$$Buttons do
      if (mOp.Not($$$Buttons(m$))) {
        //<< . . write "<INPUT TYPE=""RESET"" VALUE="""_$$^WWWUML($$^WWWTEXT(32810))_""">"   ; "Refresh"   ; AKTUALISIEREN
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<INPUT TYPE=\"RESET\" VALUE=\"",m$.fnc$("WWWUML.main",m$.fnc$("WWWTEXT.main",32810))),"\">"));
      }
      //<< . ;
      //<< . if $$$Buttons do
      if (mOp.Logical($$$Buttons(m$))) {
        //<< . . write "<A class=link onClick="" window.location='"
        m$.Cmd.Write("<A class=link onClick=\" window.location='");
        //<< . . new YKEY
        mVar YKEY = m$.var("YKEY");
        m$.newVar(YKEY);
        //<< . . write YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM
        m$.Cmd.Write(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()));
        //<< . . set YKEY=""
        YKEY.set("");
        //<< . . do ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< . . write "'"">"
        m$.Cmd.Write("'\">");
        //<< . . if $find($piece(YVOR,Y,16),"SAVE") do StopButton^WWWFORMCOMMON($$^WWWTEXT(130),"new.gif","BUTTON_NEW")
        if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16),"SAVE"))) {
          m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWTEXT.main",130),"new.gif","BUTTON_NEW");
        }
        //<< . . if '$find($piece(YVOR,Y,16),"SAVE") do StopButton^WWWFORMCOMMON($$^WWWTEXT(32810),"reset.gif","BUTTON_RESET")
        if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),16),"SAVE"))) {
          m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWTEXT.main",32810),"reset.gif","BUTTON_RESET");
        }
        //<< . . write "</A>"
        m$.Cmd.Write("</A>");
      }
      //<< . $$$CloseTD
      include.WWWFORM.$$$CloseTD(m$);
    }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< STAT ;STATUS
  public void STAT() {
    //<< write $$STATEX() ;SR18033
    m$.Cmd.Write(m$.fnc$("STATEX"));
    //<< quit
    return;
  }

  //<< 
  //<< STATEX() ;SR18033
  public Object STATEX(Object ... _p) {
    //<< new HTML
    mVar HTML = m$.var("HTML");
    m$.newVar(HTML);
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< set HTML=HTML_" onMouseover='window.status="""_YSTATUS_""";'"
    HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get()," onMouseover='window.status=\""),m$.var("YSTATUS").get()),"\";'"));
    //<< set HTML=HTML_" onMouseout='window.status=""""'"
    HTML.set(mOp.Concat(HTML.get()," onMouseout='window.status=\"\"'"));
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< COPY
  public void COPY() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Oct-2006   SteveS  SRBR014172: Use $$$SysEnum macro
    //<< ; 12-Oct-2006   HEBER   SRBR014172: Copy button title translated
    //<< ;-------------------------------------------------------------------------------
    //<< if YKEY'="" if $get(YFELD)'="" if YBEARB'=4 if $$$Buttons do
    if (mOp.NotEqual(m$.var("YKEY").get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFELD")),"")) {
        if (mOp.NotEqual(m$.var("YBEARB").get(),4)) {
          if (mOp.Logical($$$Buttons(m$))) {
            do {
              //<< . new YLFN1
              mVar YLFN1 = m$.var("YLFN1");
              m$.newVar(YLFN1);
              //<< . quit:$$$WWW120AuthorizationToModifyData(YVOR)>3     ; i.e. quit if = $$$EnumModifyOnly or $$$EnumReadOnly
              if (mOp.Greater(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),3)) {
                break;
              }
              //<< . $$$OpenTD($$$NO)
              include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
              //<< . write "<A HREF=""#"" onClick="""
              m$.Cmd.Write("<A HREF=\"#\" onClick=\"");
              //<< . for YLFN1=1:1 quit:'$data(^WWW121(0,YFORM,YLFN1))  do
              for (YLFN1.set(1);(true);YLFN1.set(mOp.Add(YLFN1.get(),1))) {
                if (mOp.Not(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN1.get())))) {
                  break;
                }
                //<< . . write "document."_YHTMFORM_".Y"_YFORM_"P"_YLFN1_".style.background='white';"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),"P"),YLFN1.get()),".style.background='white';"));
                //<< . . if $order(^WWW121(0,YFORM,YLFN1))="" do
                if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN1.get())),"")) {
                  do {
                    //<< . . . if $piece($get(^WWW002(0,YFORM,YLFN1,1)),Y,3)=9 do  quit
                    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YFORM").get(),YLFN1.get(),1)),m$.var("Y").get(),3),9)) {
                      //<< . . . . ;IF $GET(YHTMFORM)'="WWW2"
                      //<< . . . . write "document."_YHTMFORM_".Y"_YFORM_"P"_YLFN1_".value='+';"
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),"P"),YLFN1.get()),".value='+';"));
                      //<< . . . . write "retval = EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX"_YKEY_"','Y"_YFORM_"P"_YLFN1_"','+','2','');"
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("retval = EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX"),m$.var("YKEY").get()),"','Y"),m$.var("YFORM").get()),"P"),YLFN1.get()),"','+','2','');"));
                      break;
                    }
                    //<< . . . ;
                    //<< . . . if YFORM'="WWW004" write "document."_YHTMFORM_".Y"_YFORM_"P"_YLFN1_".value='';" quit
                    if (mOp.NotEqual(m$.var("YFORM").get(),"WWW004")) {
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),"P"),YLFN1.get()),".value='';"));
                      break;
                    }
                  } while (false);
                }
                //<< . . ;
                //<< . . write "document."_YHTMFORM_".Y"_YFORM_"P"_YLFN1_".readOnly=false;"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),"P"),YLFN1.get()),".readOnly=false;"));
              }
              //<< . ;
              //<< . write "window.alert('"_$$^WWWTEXT(39)_"');"  ; "Copy Data Records"
              m$.Cmd.Write(mOp.Concat(mOp.Concat("window.alert('",m$.fnc$("WWWTEXT.main",39)),"');"));
              //<< . if $$$Buttons write "return false;"
              if (mOp.Logical($$$Buttons(m$))) {
                m$.Cmd.Write("return false;");
              }
              //<< . write """>"
              m$.Cmd.Write("\">");
              //<< . write YCR
              m$.Cmd.Write(m$.var("YCR").get());
              //<< . set YSTATUS="copy"
              mVar YSTATUS = m$.var("YSTATUS");
              YSTATUS.set("copy");
              //<< . do StopButton^WWWFORMCOMMON($$$SysEnum("BUTTON",15),"copy.gif","BUTTON_COPY",,$$$YES)
              m$.Cmd.Do("WWWFORMCOMMON.StopButton",include.COMSYSWWW.$$$SysEnum(m$,"BUTTON",15),"copy.gif","BUTTON_COPY",null,include.COMSYS.$$$YES(m$));
              //<< . write "</A>"
              m$.Cmd.Write("</A>");
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< TM ;ZEITABHÄNGIGE ERFASSUNG ;logging
  public void TM() {
    //<< $$$OpenTD($$$NO)
    include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
    do {
      //<< do
      //<< . new YBACK1
      mVar YBACK1 = m$.var("YBACK1");
      m$.newVar(YBACK1);
      //<< . set YBACK1 = YBACK
      YBACK1.set(m$.var("YBACK").get());
      //<< . new YBACK
      mVar YBACK = m$.var("YBACK");
      m$.newVar(YBACK);
      //<< . set YBACK = YBACK1
      YBACK.set(YBACK1.get());
      //<< . ;
      //<< . if '$$$Buttons write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWTEXT(389)_""" onClick=""window.location='"   ; "Changes By Date"
      if (mOp.Not($$$Buttons(m$))) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWTEXT.main",389)),"\" onClick=\"window.location='"));
      }
      //<< . if $$$Buttons  write "<A HREF="""
      if (mOp.Logical($$$Buttons(m$))) {
        m$.Cmd.Write("<A HREF=\"");
      }
      //<< . write YAKTION_""
      m$.Cmd.Write(mOp.Concat(m$.var("YAKTION").get(),""));
      //<< . write "EP=WWWFORM&amp;YFORM="_YFORM_"t"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("EP=WWWFORM&amp;YFORM=",m$.var("YFORM").get()),"t"));
      //<< . set YBACK=YBACK_YFORM_","
      YBACK.set(mOp.Concat(mOp.Concat(YBACK.get(),m$.var("YFORM").get()),","));
      //<< . do ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< . if '$$$Buttons write "'"
      if (mOp.Not($$$Buttons(m$))) {
        m$.Cmd.Write("'");
      }
      //<< . write """>"
      m$.Cmd.Write("\">");
      //<< . do StopButton^WWWFORMCOMMON($$^WWWTEXT(389),"time1.gif","BUTTON_TIME")
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWTEXT.main",389),"time1.gif","BUTTON_TIME");
      //<< . write "</A>"
      m$.Cmd.Write("</A>");
    } while(false);
    //<< 
    //<< $$$CloseTD
    include.WWWFORM.$$$CloseTD(m$);
    //<< quit
    return;
  }

//<< 
//<< 
}
