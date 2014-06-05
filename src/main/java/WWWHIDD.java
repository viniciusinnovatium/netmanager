//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWHIDD
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:34
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

//<< WWWHIDD
public class WWWHIDD extends mClass {

  //<< 
  //<< #define PostMethod      0
  public static Object $$$PostMethod(mContext m$) {
    return (0);
  }

  //<< #define GetMethod       1
  public static Object $$$GetMethod(mContext m$) {
    return (1);
  }

  //<< 
  //<< #define jsMarker(%1)
  public static Object $$$jsMarker(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _WWWHIDD();
  }

  public void _WWWHIDD() {
    //<< #;define jsMarker(%1)   write YCR,YCR,"<!-- ************************* ",%1," (WWWHIDD)************************* -->",YCR,YCR
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       HIDDEN VARIABLEN VORGBEN
    //<< ;
    //<< ; Called By : START^WWWFORM
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;   YVOR        objWWW120       Form details (with Company Defaults)
    //<< ;   YVOR1       objWWW012       Company details
    //<< ;   YFOART      enumFormType
    //<< ;   YUSER
    //<< ;   YAKTION
    //<< ;   YHTMFORM
    //<< ;   YHYPER
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 22-Sep-2010   GRF     SR17515: cleanup; macros; doco
    //<< ; 24-Jun-2010   shobby  SR17362: display:inline
    //<< ; 19-Apr-2009   shobby  SR16108: Put a back button on COMView search forms.
    //<< ; 09-Feb-2009   GRF     Doco; boolean macros
    //<< ; 10-May-2006   JW      SR14508: Always create YPARA
    //<< ; 09-Dec-2005   JW      SR13195: Changed default of YOPEN to 1
    //<< ; 08.06.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;---------------------------------------
    //<< ; Close any open <FORM> and mark form has been started
    //<< ;---------------------------------------
    //<< if YUSER'="" {
    if (mOp.NotEqual(m$.var("YUSER").get(),"")) {
      //<< if $$$WWWUSERFormStarted($get(^WWWUSER(0,YUSER,1)))=$$$YES write YCR,"</FORM>"
      if (mOp.Equal(include.WWWConst.$$$WWWUSERFormStarted(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1))),include.COMSYS.$$$YES(m$))) {
        m$.Cmd.Write(m$.var("YCR").get(),"</FORM>");
      }
      //<< set $$$WWWUSERFormStarted(^WWWUSER(0,YUSER,1)) = $$$YES
      include.WWWConst.$$$WWWUSERFormStartedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ; Start <FORM>
    //<< ;---------------------------------------
    //<< $$$jsMarker("FORM START")
    $$$jsMarker(m$,"FORM START");
    //<< 
    //<< if +$$$WWW120FormWithFileDownloadFunct(YVOR)'=$$$YES do
    if (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW120FormWithFileDownloadFunct(m$,m$.var("YVOR"))),include.COMSYS.$$$YES(m$))) {
      do {
        //<< . write YCR,"<FORM NAME=""WWW"" style='display:inline;' id=""WWW""  ACTION="""_$piece(YAKTION,"?",1)_""""    ;SR17362
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<FORM NAME=\"WWW\" style='display:inline;' id=\"WWW\"  ACTION=\"",m$.Fnc.$piece(m$.var("YAKTION").get(),"?",1)),"\""));
        //<< . if (YHTMFORM="WWW2") && ($$$WWW120httpMethod(YVOR)'=0) QUIT   ;METHOD 0:POST, 1:GET
        if ((mOp.Equal(m$.var("YHTMFORM").get(),"WWW2")) && (mOp.NotEqual(include.WWWConst.$$$WWW120httpMethod(m$,m$.var("YVOR")),0))) {
          break;
        }
        //<< . if $GET(YFOART)=8 QUIT  ;NUR WENIGE DATEN BEI WIZARD ;only few next to
        if (mOp.Equal(m$.Fnc.$get(m$.var("YFOART")),8)) {
          break;
        }
        //<< . if $GET(YFOART)=6 QUIT  ;NUR WENIGE DATEN BEI LISTGENERATOR ;only few next to
        if (mOp.Equal(m$.Fnc.$get(m$.var("YFOART")),6)) {
          break;
        }
        //<< . if $GET(YFOART)=2 QUIT  ;NUR WENIGE DATEN BEI LISTGENERATOR ;only few next to
        if (mOp.Equal(m$.Fnc.$get(m$.var("YFOART")),2)) {
          break;
        }
        //<< . if $$$WWW012OnlyGETMethodonhttp(YVOR1)=$$$YES  IF $$$WWW120httpMethod(YVOR)'=$$$PostMethod QUIT   ; FIXME : quit if GET when ONLY GET?
        if (mOp.Equal(include.WWWConst.$$$WWW012OnlyGETMethodonhttp(m$,m$.var("YVOR1")),include.COMSYS.$$$YES(m$))) {
          if (mOp.NotEqual(include.WWWConst.$$$WWW120httpMethod(m$,m$.var("YVOR")),$$$PostMethod(m$))) {
            break;
          }
        }
        //<< . if $$$WWW012OnlyGETMethodonhttp(YVOR1)'=$$$YES IF $$$WWW120httpMethod(YVOR)=$$$GetMethod   QUIT   ;    then quit if GET and not ONLY GET?
        if (mOp.NotEqual(include.WWWConst.$$$WWW012OnlyGETMethodonhttp(m$,m$.var("YVOR1")),include.COMSYS.$$$YES(m$))) {
          if (mOp.Equal(include.WWWConst.$$$WWW120httpMethod(m$,m$.var("YVOR")),$$$GetMethod(m$))) {
            break;
          }
        }
        //<< . if +$GET(YHYPER)=0 write " Method=""POST"""
        if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),0)) {
          m$.Cmd.Write(" Method=\"POST\"");
        }
        //<< . if +$GET(YHYPER)=1 write " Method=""POST"""                                                       ; FIXME : Both POST? <GRF>
        if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),1)) {
          m$.Cmd.Write(" Method=\"POST\"");
        }
      } while (false);
    }
    //<< 
    //<< if +$$$WWW120FormWithFileDownloadFunct(YVOR)=$$$YES {
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120FormWithFileDownloadFunct(m$,m$.var("YVOR"))),include.COMSYS.$$$YES(m$))) {
      //<< write YCR,"<FORM NAME=""WWW"" id=""WWW"" ACTION="""_$piece(YAKTION,"?",1)_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<FORM NAME=\"WWW\" id=\"WWW\" ACTION=\"",m$.Fnc.$piece(m$.var("YAKTION").get(),"?",1)),"\""));
      //<< write " Method=post"
      m$.Cmd.Write(" Method=post");
      //<< write " enctype=""multipart/form-data"""
      m$.Cmd.Write(" enctype=\"multipart/form-data\"");
    }
    //<< }
    //<< 
    //<< set YTARGETF = $$$WWW120TargetNameForOutput(YVOR)
    mVar YTARGETF = m$.var("YTARGETF");
    YTARGETF.set(include.WWWConst.$$$WWW120TargetNameForOutput(m$,m$.var("YVOR")));
    //<< if (YFOART'=6) && (YFOART'=1) && (YTARGETF'="") write " TARGET="""_YTARGETF_""""
    if ((mOp.NotEqual(m$.var("YFOART").get(),6)) && (mOp.NotEqual(m$.var("YFOART").get(),1)) && (mOp.NotEqual(YTARGETF.get(),""))) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" TARGET=\"",YTARGETF.get()),"\""));
    }
    //<< write ">"
    m$.Cmd.Write(">");
    //<< 
    //<< ;---------------------------------------
    //<< ; Store values as hidden <INPUT> fields
    //<< ;---------------------------------------
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""EP"" VALUE=""WWWSAVE"">"
    m$.Cmd.Write(m$.var("YCR").get(),"<INPUT TYPE=HIDDEN NAME=\"EP\" VALUE=\"WWWSAVE\">");
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YFORM"" VALUE="""_YFORM_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YFORM\" VALUE=\"",m$.var("YFORM").get()),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YPARA"" VALUE="""_YPARA_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YPARA\" VALUE=\"",m$.var("YPARA").get()),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YBED"" VALUE="""_YBED_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YBED\" VALUE=\"",m$.var("YBED").get()),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YM"" VALUE="""_YM_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YM\" VALUE=\"",m$.var("YM").get()),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YUSER"" VALUE="""_$get(YUSER)_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YUSER\" VALUE=\"",m$.Fnc.$get(m$.var("YUSER"))),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YBACK"" VALUE="""_YBACK_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YBACK\" VALUE=\"",m$.var("YBACK").get()),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YBKEY"" VALUE="""_$get(YKEY)_""">" ;SR16108
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YBKEY\" VALUE=\"",m$.Fnc.$get(m$.var("YKEY"))),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YANZ"" VALUE="""_YANZ_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YANZ\" VALUE=\"",m$.var("YANZ").get()),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YUCI"" VALUE="""_YUCI_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YUCI\" VALUE=\"",m$.var("YUCI").get()),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YRICHT1"" VALUE="""">"
    m$.Cmd.Write(m$.var("YCR").get(),"<INPUT TYPE=HIDDEN NAME=\"YRICHT1\" VALUE=\"\">");
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YOPEN"" VALUE=""1"">"
    m$.Cmd.Write(m$.var("YCR").get(),"<INPUT TYPE=HIDDEN NAME=\"YOPEN\" VALUE=\"1\">");
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YORIENT"" VALUE="""_$get(YORIENT)_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YORIENT\" VALUE=\"",m$.Fnc.$get(m$.var("YORIENT"))),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YSORT"" VALUE="""_$get(YSORT)_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YSORT\" VALUE=\"",m$.Fnc.$get(m$.var("YSORT"))),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YNUMMER"" VALUE="""_YNUMMER_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YNUMMER\" VALUE=\"",m$.var("YNUMMER").get()),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YBUTTON"" VALUE="""_YBUTTON_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YBUTTON\" VALUE=\"",m$.var("YBUTTON").get()),"\">"));
    //<< write YCR,"<INPUT TYPE=HIDDEN NAME=""YINSEITE"" VALUE="""_YINSEITE_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YINSEITE\" VALUE=\"",m$.var("YINSEITE").get()),"\">"));
    //<< 
    //<< if $get(YAENBER)'=""   write YCR,"<INPUT TYPE=HIDDEN NAME=""YAENBER"" VALUE="""_YAENBER_""">"
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YAENBER")),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YAENBER\" VALUE=\"",m$.var("YAENBER").get()),"\">"));
    }
    //<< if YFKEY'=""           write YCR,"<INPUT TYPE=HIDDEN NAME=""YFKEY"" VALUE="""_$translate(YFKEY,"""")_""">"
    if (mOp.NotEqual(m$.var("YFKEY").get(),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YFKEY\" VALUE=\"",m$.Fnc.$translate(m$.var("YFKEY").get(),"\"")),"\">"));
    }
    //<< if $get(YNOKEY)'=""    write YCR,"<INPUT TYPE=HIDDEN NAME=""YNOKEY"" VALUE="""_YNOKEY_""">"
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YNOKEY")),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YNOKEY\" VALUE=\"",m$.var("YNOKEY").get()),"\">"));
    }
    //<< if $get(YOPTION)'=""   write YCR,"<INPUT TYPE=HIDDEN NAME=""YOPTION"" VALUE="""_YOPTION_""">"
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YOPTION")),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YOPTION\" VALUE=\"",m$.var("YOPTION").get()),"\">"));
    }
    //<< ;i $get(YOPTION1)'=""  write YCR,"<INPUT TYPE=HIDDEN NAME=""YOPTION1"" VALUE="""_YOPTION1_""">"
    //<< if $get(YSCREENM)'=""  write YCR,"<INPUT TYPE=HIDDEN NAME=""YSCREENM"" VALUE="""_+YSCREENM_""">"
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YSCREENM")),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YSCREENM\" VALUE=\"",mOp.Positive(m$.var("YSCREENM").get())),"\">"));
    }
    //<< if YSEITE'=""          write YCR,"<INPUT TYPE=HIDDEN NAME=""YSEITE"" VALUE="""_YSEITE_""">"
    if (mOp.NotEqual(m$.var("YSEITE").get(),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YSEITE\" VALUE=\"",m$.var("YSEITE").get()),"\">"));
    }
    //<< if $get(YTIMEFORM)'="" write YCR,"<INPUT TYPE=HIDDEN NAME=""YTIMEFORM"" VALUE="""_YTIMEFORM_""">"
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTIMEFORM")),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YTIMEFORM\" VALUE=\"",m$.var("YTIMEFORM").get()),"\">"));
    }
    //<< if YTRAKT'=""          write YCR,"<INPUT TYPE=HIDDEN NAME=""YTRAKT"" VALUE="""_YTRAKT_""">"
    if (mOp.NotEqual(m$.var("YTRAKT").get(),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"YTRAKT\" VALUE=\"",m$.var("YTRAKT").get()),"\">"));
    }
    //<< 
    //<< quit
    return;
  }

//<< 
//<< 
}
