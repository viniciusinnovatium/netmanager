//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMM
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-17 11:17:10
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

//<< WWWFORMM
public class WWWFORMM extends mClass {

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
    _WWWFORMM();
  }

  public void _WWWFORMM() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORMM("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       BUTTON MANUELLE UND LISTEN UND WIZARD
    //<< ;
    //<< ; Called By: -- (all to HEAD2 or HEAD4)
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
    //<< ; 02-Mar-2009   GRF     doco; quits
    //<< ; 15.07.1999    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< do HEAD4
    m$.Cmd.Do("HEAD4");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< HEAD2
  public void HEAD2() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   LISTEN VORGABEN
    //<< ;
    //<< ; Called By: ^WWWFORM1 (YFOART = 2, 9)
    //<< ;            (^WWWFORMM - not called)
    //<< ;-------------------------------------------------------------------------------
    //<< do HEAD4
    m$.Cmd.Do("HEAD4");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< HEAD4
  public void HEAD4() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   MANUELLE VORGABEN
    //<< ;
    //<< ; Called By: HEAD2^WWWFORMM, ^WWWFORM1 (YFOART = 4, 5, 6, 7, 8)
    //<< ;            (^WWWFORMM - not called)
    //<< ;
    //<< ; History
    //<< ; 09-Nov-2010   GRF     SR17243: use strDontDisplay to get list once; macros
    //<< ;-------------------------------------------------------------------------------
    //<< new strDontDisplay,YOKBA
    mVar strDontDisplay = m$.var("strDontDisplay");
    mVar YOKBA = m$.var("YOKBA");
    m$.newVar(strDontDisplay,YOKBA);
    //<< 
    //<< $$$LogR("HEAD4",YFOART_"<"_YVOR)
    $$$LogR(m$,"HEAD4",mOp.Concat(mOp.Concat(m$.var("YFOART").get(),"<"),m$.var("YVOR").get()));
    //<< set strDontDisplay    = ","_$$$WWW120DoNOTDisplayStandardButto(YVOR)_","
    strDontDisplay.set(mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW120DoNOTDisplayStandardButto(m$,m$.var("YVOR"))),","));
    //<< 
    //<< 
    //<< ;set strStandardSubmit = $$$WWW120StandardSubmit(YVOR)
    //<< 
    //<< ;---------------------------------------
    //<< ;   D45     $$$WWW120PicturesAsButtons(YVOR) (bln)
    //<< ;   D46     $$$WWW120StandardSubmit(YVOR)
    //<< ;---------------------------------------
    //<< 
    //<< set YOKBA = 0
    YOKBA.set(0);
    //<< if $$$WWW120PicturesAsButtons(YVOR)=$$$YES write $$Delimiter^WWWFORMCOMMON()
    if (mOp.Equal(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.var("YVOR")),include.COMSYS.$$$YES(m$))) {
      m$.Cmd.Write(m$.fnc$("WWWFORMCOMMON.Delimiter"));
    }
    //<< 
    //<< ;WENN WIZARD SUBMIT ;when
    //<< if YFOART=8 do  quit  ;NUR für Wizards ;only to
    if (mOp.Equal(m$.var("YFOART").get(),8)) {
      //<< . new YLFN
      mVar YLFN = m$.var("YLFN");
      m$.newVarBlock(1,YLFN);
      //<< . set $$$WWW120PicturesAsButtons(YVOR) = $$$NO
      include.WWWConst.$$$WWW120PicturesAsButtonsSet(m$,m$.var("YVOR"),include.COMSYS.$$$NO(m$));
      //<< . set $$$WWW120StandardSubmit(YVOR) = "Next >,Reset,< Back,Cancel"
      include.WWWConst.$$$WWW120StandardSubmitSet(m$,m$.var("YVOR"),"Next >,Reset,< Back,Cancel");
      //<< . set YLFN = $piece($get(YOPTION),"#",10)
      YLFN.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YOPTION")),"#",10));
      //<< . set YLFN = $order(^WWW122s(0,5,$$^WWWUMLAU(YFORM,1),YLFN))  ;1x
      YLFN.set(m$.Fnc.$order(m$.var("^WWW122s",0,5,m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1),YLFN.get())));
      //<< . set YLFN = $order(^WWW122s(0,5,$$^WWWUMLAU(YFORM,1),YLFN))  ;2x
      YLFN.set(m$.Fnc.$order(m$.var("^WWW122s",0,5,m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1),YLFN.get())));
      //<< . if YLFN="" set $$$WWW120StandardSubmit(YVOR) = "Finish,Reset,< Back,Cancel" ;keine weiteren felder ;None
      if (mOp.Equal(YLFN.get(),"")) {
        include.WWWConst.$$$WWW120StandardSubmitSet(m$,m$.var("YVOR"),"Finish,Reset,< Back,Cancel");
      }
      //<< . ;
      //<< . ; FIXME : initial setting of D46 has 4 pieces; override has 4 pieces - test below is $$$ALWAYS
      //<< . ;
      //<< . if $piece($$$WWW120StandardSubmit(YVOR),",",2)'="" do
      if (mOp.NotEqual(m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",2),"")) {
        //<< . . write "<TD>"
        m$.Cmd.Write("<TD>");
        //<< . . write "<BR>"
        m$.Cmd.Write("<BR>");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "<INPUT TYPE="_""""_"RESET"_""""_" VALUE="_""""_$$^WWWUML($piece($$$WWW120StandardSubmit(YVOR),",",2))_""""_">"   ;NEU ;recent
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=","\""),"RESET"),"\"")," VALUE="),"\""),m$.fnc$("WWWUML.main",m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",2))),"\""),">"));
        //<< . . write YCR,"</TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
        //<< . . write "<TD>"
        m$.Cmd.Write("<TD>");
        //<< . . write "<BR>"
        m$.Cmd.Write("<BR>");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write YCR,"</TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
      }
      //<< . ;
      //<< . if $piece($$$WWW120StandardSubmit(YVOR),",",3)'="" do
      if (mOp.NotEqual(m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",3),"")) {
        //<< . . write "<TD>"
        m$.Cmd.Write("<TD>");
        //<< . . write "<BR>"
        m$.Cmd.Write("<BR>");
        //<< . . write "<INPUT TYPE="_""""_"BUTTON"_""""_" VALUE="_""""_$$^WWWUML($piece($$$WWW120StandardSubmit(YVOR),",",3))_""""_" onClick="_""""_"window.history.back()"_""""_">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=","\""),"BUTTON"),"\"")," VALUE="),"\""),m$.fnc$("WWWUML.main",m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",3))),"\"")," onClick="),"\""),"window.history.back()"),"\""),">"));
        //<< . . write YCR,"</TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
      }
      //<< . ;
      //<< . do OK^WWWFORMF
      m$.Cmd.Do("WWWFORMF.OK");
      //<< . if $piece($$$WWW120StandardSubmit(YVOR),",",4)'="" do
      if (mOp.NotEqual(m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",4),"")) {
        //<< . . write "<TD>"
        m$.Cmd.Write("<TD>");
        //<< . . write "<BR>"
        m$.Cmd.Write("<BR>");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . write "<INPUT TYPE="_""""_"BUTTON"_""""_" VALUE="_""""_$$^WWWUML($piece($$$WWW120StandardSubmit(YVOR),",",4))_""""_" onClick="_""""_"window.location='"_YGIF_"blank.htm'"_""""_">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=","\""),"BUTTON"),"\"")," VALUE="),"\""),m$.fnc$("WWWUML.main",m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",4))),"\"")," onClick="),"\""),"window.location='"),m$.var("YGIF").get()),"blank.htm'"),"\""),">"));
        //<< . . write YCR,"</TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
      }
      return;
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< ;WENN STANDARD SUBMIT
    //<< 
    //<< ; Standard Submit might not come from settings for form type 8
    //<< if $$$WWW120StandardSubmit(YVOR)'="" do  quit  ;NUR DIESEN ;only
    if (mOp.NotEqual(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),"")) {
      //<< . set $$$WWW120PicturesAsButtons(YVOR) = $$$NO
      include.WWWConst.$$$WWW120PicturesAsButtonsSet(m$,m$.var("YVOR"),include.COMSYS.$$$NO(m$));
      //<< . do OK^WWWFORMF
      m$.Cmd.Do("WWWFORMF.OK");
      //<< . if $piece($$$WWW120StandardSubmit(YVOR),",",2)'="" do
      if (mOp.NotEqual(m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",2),"")) {
        //<< . . write "<TD>"
        m$.Cmd.Write("<TD>");
        //<< . . write "<INPUT TYPE="_""""_"RESET"_""""_" VALUE="_""""_$$^WWWUML($piece($$$WWW120StandardSubmit(YVOR),",",2))_""""_">"   ;NEU ;recent
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=","\""),"RESET"),"\"")," VALUE="),"\""),m$.fnc$("WWWUML.main",m$.Fnc.$piece(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",",2))),"\""),">"));
        //<< . . write YCR,"</TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
      }
      return;
    }
    //<< 
    //<< if '$find(strDontDisplay,",1,") do RESET^WWWFORMF
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",1,"))) {
      m$.Cmd.Do("WWWFORMF.RESET");
    }
    //<< if '$find(strDontDisplay,",3,") do OK^WWWFORMF
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",3,"))) {
      m$.Cmd.Do("WWWFORMF.OK");
    }
    //<< if '$find(strDontDisplay,",7,") do BACK^WWWFORMF
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",7,"))) {
      m$.Cmd.Do("WWWFORMF.BACK");
    }
    //<< if '$find(strDontDisplay,",8,") do END^WWWFORMF
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",8,"))) {
      m$.Cmd.Do("WWWFORMF.END");
    }
    //<< if '$find(strDontDisplay,",6,") do HELP^WWWFORMF
    if (mOp.Not(m$.Fnc.$find(strDontDisplay.get(),",6,"))) {
      m$.Cmd.Do("WWWFORMF.HELP");
    }
    //<< 
    //<< quit
    return;
  }

//<< 
//<< 
}
