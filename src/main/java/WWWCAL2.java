//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWCAL2
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:40
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

//<< WWWCAL2
public class WWWCAL2 extends mClass {

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

  public void main() {
    _WWWCAL2();
  }

  public void _WWWCAL2() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWCAL2("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       CALENDERFUNKTION
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 12-Jul-2010   FIS     SR17431: get element by id rather with document.form
    //<< ; 03-Jun-2010   GRF     SR17146: Add </FONT>; cleanup old commented code
    //<< ; 07-May-2009   GRF     SR16522: Doco; quits
    //<< ; 10.10.1999    DT      Created.
    //<< ;-------------------------------------------------------------------------------
    //<< ;      ;FIS;IN MODAL WINDOW ANZEIGEN;29.10.2003
    //<< SET YDATE = $GET(%(YQUERY,"YDATE"))
    mVar YDATE = m$.var("YDATE");
    YDATE.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YDATE")));
    //<< IF +YDATE=0 SET YDATE = +$HOROLOG
    if (mOp.Equal(mOp.Positive(YDATE.get()),0)) {
      YDATE.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< SET YLFDAT    = $GET(%(YQUERY,"YLFDAT"))     ;AUFRUF AUS DATENFELD
    mVar YLFDAT = m$.var("YLFDAT");
    YLFDAT.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YLFDAT")));
    //<< SET YHTMFORM1 = $GET(%(YQUERY,"YHTMFORM1"))  ;AUFRUF AUS DATENFELD
    mVar YHTMFORM1 = m$.var("YHTMFORM1");
    YHTMFORM1.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YHTMFORM1")));
    //<< 
    //<< $$$LogR("",YDATE_"<"_YLFDAT)
    $$$LogR(m$,"",mOp.Concat(mOp.Concat(YDATE.get(),"<"),YLFDAT.get()));
    do {
      //<< 
      //<< DO  ; ============== LADEN FRAME =============
      //<< . WRITE YCR,YCR,"<IFRAME name="_""""_"YCALENDER"_""""
      m$.Cmd.Write(m$.var("YCR").get(),m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat("<IFRAME name=","\""),"YCALENDER"),"\""));
      //<< . WRITE " src="_""""_"javascript:window.location='"_YAKTION_"EP=WWWMANU&amp;YEXEC=DO|START^WWWCAL2("_YDATE_")&amp;YFORM="_YFORM_"&amp;YHTMFORM="_$GET(YHTMFORM)_"&amp;YLFDAT="_$GET(YLFDAT)_"&amp;YHTMFORM1="_$GET(YHTMFORM1)  ;YFORM FÜR LAYOUT ;to
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" src=","\""),"javascript:window.location='"),m$.var("YAKTION").get()),"EP=WWWMANU&amp;YEXEC=DO|START^WWWCAL2("),YDATE.get()),")&amp;YFORM="),m$.var("YFORM").get()),"&amp;YHTMFORM="),m$.Fnc.$get(m$.var("YHTMFORM"))),"&amp;YLFDAT="),m$.Fnc.$get(YLFDAT)),"&amp;YHTMFORM1="),m$.Fnc.$get(YHTMFORM1)));
      //<< . NEW YFORM
      mVar YFORM = m$.var("YFORM");
      m$.newVarBlock(1,YFORM);
      //<< . DO ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< . WRITE "'"_""""
      m$.Cmd.Write(mOp.Concat("'","\""));
      //<< . WRITE YCR," BORDER=0 FRAMEBORDER=0"
      m$.Cmd.Write(m$.var("YCR").get()," BORDER=0 FRAMEBORDER=0");
      //<< . ;SR17460 WRITE " FRAMESPACING=0 HEIGHT=270 SCROLLING=NO"
      //<< . WRITE " FRAMESPACING=0 HEIGHT=300 WIDTH=270 SCROLLING=NO" ;SR17460
      m$.Cmd.Write(" FRAMESPACING=0 HEIGHT=300 WIDTH=270 SCROLLING=NO");
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . WRITE YCR,"</IFRAME>",YCR
      m$.Cmd.Write(m$.var("YCR").get(),"</IFRAME>",m$.var("YCR").get());
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< SET YNOFOOT=1
    mVar YNOFOOT = m$.var("YNOFOOT");
    YNOFOOT.set(1);
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< START(YDATE)
  public Object START(Object ... _p) {
    mVar YDATE = m$.newVarRef("YDATE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display calendar
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History :
    //<< ; 06-Aug-2010   shobby  SR17488: call to SET^WWWUSERAGENT
    //<< ; 03-Jun-2010   GRF     SR17146: call "DD.MM.YYYY" wrapper for WWWDATE1
    //<< ; 06-Aug-2007   Frank   SRBR014598: Changing minimum year limit from 80 to 130
    //<< ;                           under today's year.
    //<< ; 16-May-2007   HeberB  BR014457: Added type to TERMIN1 call
    //<< ; 02-Jun-2006   SC      SRBR014011: Replaced Month button from .gifs to language text.
    //<< ; 10.10.1999    DT      Created.
    //<< ;-------------------------------------------------------------------------------
    //<< NEW TX,TAGEX,A,TAGXE,TAGXX,TAGXXX,KWPM,GO,WEBUSER,YHTMFORM1
    mVar TX = m$.var("TX");
    mVar TAGEX = m$.var("TAGEX");
    mVar A = m$.var("A");
    mVar TAGXE = m$.var("TAGXE");
    mVar TAGXX = m$.var("TAGXX");
    mVar TAGXXX = m$.var("TAGXXX");
    mVar KWPM = m$.var("KWPM");
    mVar GO = m$.var("GO");
    mVar WEBUSER = m$.var("WEBUSER");
    mVar YHTMFORM1 = m$.var("YHTMFORM1");
    m$.newVar(TX,TAGEX,A,TAGXE,TAGXX,TAGXXX,KWPM,GO,WEBUSER,YHTMFORM1);
    //<< 
    //<< $$$LogR("START",YDATE)
    $$$LogR(m$,"START",YDATE);
    //<< 
    //<< SET YLFDAT    = $GET(%(YQUERY,"YLFDAT"))  ;AUFRUF AUS DATENFELD
    mVar YLFDAT = m$.var("YLFDAT");
    YLFDAT.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YLFDAT")));
    //<< SET YHTMFORM1 = $GET(%(YQUERY,"YHTMFORM1"))
    YHTMFORM1.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YHTMFORM1")));
    //<< IF YHTMFORM1'="" NEW YHTMFORM SET YHTMFORM=YHTMFORM1
    if (mOp.NotEqual(YHTMFORM1.get(),"")) {
      mVar YHTMFORM = m$.var("YHTMFORM");
      m$.newVar(YHTMFORM);
      YHTMFORM.set(YHTMFORM1.get());
    }
    //<< SET WEBUSER=0
    WEBUSER.set(0);
    //<< IF $PIECE($GET(^WWW013(0,YBED,1)),Y,49)=998 SET WEBUSER=1  ; SET YHTMFORM="WWW"
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)),m$.var("Y").get(),49),998)) {
      WEBUSER.set(1);
    }
    //<< ;SR17488 IF $GET(YUSERAGENT)="" SET YUSERAGENT=$$^WWWUSERAGENT()
    //<< IF $GET(YUSERAGENT)="" do SET^WWWUSERAGENT($$^WWWUSERAGENT())   ;SR17488
    if (mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"")) {
      m$.Cmd.Do("WWWUSERAGENT.SET",m$.fnc$("WWWUSERAGENT.main"));
    }
    //<< WRITE "<NOBR>"
    m$.Cmd.Write("<NOBR>");
    //<< SET YKEY="",YFKEY=""
    mVar YKEY = m$.var("YKEY");
    YKEY.set("");
    mVar YFKEY = m$.var("YFKEY");
    YFKEY.set("");
    //<< SET YBEDI = YBED
    mVar YBEDI = m$.var("YBEDI");
    YBEDI.set(m$.var("YBED").get());
    //<< SET KWPM  = 0   ;KWen PRO MONAT ;within month
    KWPM.set(0);
    //<< SET GO    = 0  ; WENN MONAT=12 ;when
    GO.set(0);
    //<< ;WRITE YCR,"<SCRIPT LANGUAGE=JavaScript>"
    //<< ;WRITE YCR,"<!--"
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< WRITE YCR,"function gotodate(date)"
    m$.Cmd.Write(m$.var("YCR").get(),"function gotodate(date)");
    //<< WRITE YCR,"{"
    m$.Cmd.Write(m$.var("YCR").get(),"{");
    //<< WRITE YCR,"  window.location="_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat("  window.location=","\""));
    do {
      //<< DO
      //<< . NEW YI,YFORM
      mVar YI = m$.var("YI");
      mVar YFORM = m$.var("YFORM");
      m$.newVarBlock(1,YI,YFORM);
      //<< . WRITE YAKTION_"EP=WWWMANU&amp;YEXEC=DO|START^WWWCAL2('"_""""_" + date + "_""""_"')&amp;YFORM=WWWCAL&amp;YHTMFORM1="_YHTMFORM_"&amp;YLFDAT="_YLFDAT
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWMANU&amp;YEXEC=DO|START^WWWCAL2('"),"\"")," + date + "),"\""),"')&amp;YFORM=WWWCAL&amp;YHTMFORM1="),m$.var("YHTMFORM").get()),"&amp;YLFDAT="),YLFDAT.get()));
      //<< . NEW YFORM
      m$.newVarBlock(1,YFORM);
      //<< . DO ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< . WRITE """"_";"
      m$.Cmd.Write(mOp.Concat("\"",";"));
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< WRITE YCR,"}"
    m$.Cmd.Write(m$.var("YCR").get(),"}");
    //<< ;WRITE YCR,"//-->"
    //<< ;WRITE YCR,"</SCRIPT>"
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< WRITE YCR,"<CENTER>"
    m$.Cmd.Write(m$.var("YCR").get(),"<CENTER>");
    //<< WRITE YCR,"<TABLE CELLSPACING=0 BORDER=0>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TABLE CELLSPACING=0 BORDER=0>");
    //<< 
    //<< 
    //<< ;     Horizontal style calendar
    //<< ;-----------------------------------------+
    //<< ;  [-Month] [+Month] [Month   ] [Year   ] |     <Row 1>  START
    //<< ;-----------------------------------------+
    //<< ;             Month Year (Counter)        |     <Row 2>  HORIZON
    //<< ;-----------------------------------------+
    //<< ; Week | Mo | Tu | We | Th | Fr | Sa | Su |     <Row 3>  HORIZON
    //<< ;-----------------------------------------+
    //<< ;      |    |    |    |    |    |    |    |     <Row 4>  HORIZON
    //<< ;-----------------------------------------+
    //<< ;      |    |    |    |    |    |    |    |
    //<< ;-----------------------------------------+
    //<< ;      |    |    |    |    |    |    |    |
    //<< ;-----------------------------------------+
    //<< 
    //<< ; Row 1
    //<< ;---------------------------------------
    //<< WRITE "<TR>"
    m$.Cmd.Write("<TR>");
    //<< WRITE "<TD NOWRAP>"
    m$.Cmd.Write("<TD NOWRAP>");
    //<< /*IF WEBUSER'=1 IF SPRACHE="DE" DO
    //<< . WRITE YCR,"<A onClick='return doLink(this)' HREF='JavaScript:gotodate("_(YDATE-$$^WWWMONTHDAYS(YDATE,-1))_");' TITLE='Monat zur&uuml;ck'>"
    //<< . WRITE YCR,"<IMG SRC="_""""_YGIF_"monatm.gif"_""""_" BORDER=0 TITLE='Monat zur&uuml;ck'></A>"
    //<< . WRITE YCR,"</TD>"
    //<< . WRITE "<TD NOWRAP>"
    //<< . ;
    //<< . WRITE YCR,"<A onClick='return doLink(this)' HREF='JavaScript:gotodate("_(YDATE+$$^WWWMONTHDAYS(YDATE))_");' TITLE='Monat vor'>"
    //<< . WRITE YCR,"<IMG SRC="_""""_YGIF_"monatp.gif"_""""_" BORDER=0 TITLE='Monat vor'></A>"
    //<< 
    //<< IF WEBUSER'=1 IF SPRACHE'="DE" DO
    //<< . WRITE YCR,"<A onClick='return doLink(this)' HREF='JavaScript:gotodate("_(YDATE-$$^WWWMONTHDAYS(YDATE,-1))_");' TITLE='Month back'>"
    //<< . WRITE YCR,"<IMG SRC="_""""_YGIF_"mmonth.gif"_""""_" BORDER=0 TITLE='Month back'></A>"
    //<< . WRITE YCR,"</TD>"
    //<< . WRITE "<TD NOWRAP>"
    //<< . ;
    //<< . WRITE YCR,"<A onClick='return doLink(this)' HREF='JavaScript:gotodate("_(YDATE+$$^WWWMONTHDAYS(YDATE))_");' TITLE='Month forward'>"
    //<< . WRITE YCR,"<IMG SRC="_""""_YGIF_"pmonth.gif"_""""_" BORDER=0 TITLE='Month forward'></A>"
    //<< 
    //<< WEBUSER=1 DO //SRBR014011
    //<< . WRITE YCR,"<INPUT TYPE='BUTTON' style='cursor:pointer; height:21px; width:56px;' onClick='JavaScript:gotodate("_(YDATE-$$^WWWMONTHDAYS(YDATE,-1))_");' VALUE='-"_$$^WWWTEXT(16)_"' TITLE='"_$$^WWWTEXT(33600)_"'>"  ;MONAT ZURÜCK         ;SR17253
    //<< . WRITE YCR,"</TD>"
    //<< . WRITE "<TD NOWRAP>"
    //<< . WRITE YCR,"<INPUT TYPE='BUTTON' style='cursor:pointer; height:21px; width:56px;' onClick='JavaScript:gotodate("_(YDATE+$$^WWWMONTHDAYS(YDATE))_");' VALUE='+"_$$^WWWTEXT(16)_"' TITLE='"_$$^WWWTEXT(33599)_"'>"  ;MONAT VOR               ;SR17253
    //<< */
    //<< 
    //<< WRITE YCR,"<INPUT TYPE='BUTTON' style='cursor:pointer; height:21px; width:56px;' onClick='JavaScript:gotodate("_(YDATE-$$^WWWMONTHDAYS(YDATE,-1))_");' VALUE='-"_$$^WWWTEXT(16)_"' TITLE='"_$$^WWWTEXT(33600)_"'>" ;"Month back" ;MONAT ZURÜCK  ;SR17253
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE='BUTTON' style='cursor:pointer; height:21px; width:56px;' onClick='JavaScript:gotodate(",(mOp.Subtract(YDATE.get(),m$.fnc$("WWWMONTHDAYS.main",YDATE.get(),mOp.Negative(1))))),");' VALUE='-"),m$.fnc$("WWWTEXT.main",16)),"' TITLE='"),m$.fnc$("WWWTEXT.main",33600)),"'>"));
    //<< WRITE YCR,"</TD>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
    //<< 
    //<< WRITE "<TD NOWRAP>"
    m$.Cmd.Write("<TD NOWRAP>");
    //<< WRITE YCR,"<INPUT TYPE='BUTTON' style='cursor:pointer; height:21px; width:56px;' onClick='JavaScript:gotodate("_(YDATE+$$^WWWMONTHDAYS(YDATE))_");' VALUE='+"_$$^WWWTEXT(16)_"' TITLE='"_$$^WWWTEXT(33599)_"'>"    ; "Month forward" ;MONAT VOR ;SR17253
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE='BUTTON' style='cursor:pointer; height:21px; width:56px;' onClick='JavaScript:gotodate(",(mOp.Add(YDATE.get(),m$.fnc$("WWWMONTHDAYS.main",YDATE.get())))),");' VALUE='+"),m$.fnc$("WWWTEXT.main",16)),"' TITLE='"),m$.fnc$("WWWTEXT.main",33599)),"'>"));
    //<< WRITE YCR,"</TD>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
    //<< 
    //<< WRITE YCR,"<TD>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TD>");
    //<< WRITE "<select NAME=MONAT SIZE=1 onChange="_""""_"javascript:gotodate(this.value)"_""""_">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<select NAME=MONAT SIZE=1 onChange=","\""),"javascript:gotodate(this.value)"),"\""),">"));
    //<< SET MONATS=""
    mVar MONATS = m$.var("MONATS");
    MONATS.set("");
    //<< FOR  SET MONATS=$ORDER(^WWW101(0,"MONAT",SPRACHE,MONATS)) QUIT:MONATS=""  DO
    for (;true;) {
      MONATS.set(m$.Fnc.$order(m$.var("^WWW101",0,"MONAT",m$.var("SPRACHE").get(),MONATS.get())));
      if (mOp.Equal(MONATS.get(),"")) {
        break;
      }
      //<< .;WRITE YCR,"<option value="_$$^WWWDATE1("01."_$EXTRACT(MONATS+100,2,3)_"."_$$^WWWYEAR(YDATE)) ; SR17146
      //<< . WRITE YCR,"<option value="_$$DMY^WWWDATE1("01."_$EXTRACT(MONATS+100,2,3)_"."_$$^WWWYEAR(YDATE))
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat("<option value=",m$.fnc$("WWWDATE1.DMY",mOp.Concat(mOp.Concat(mOp.Concat("01.",m$.Fnc.$extract(mOp.Add(MONATS.get(),100),2,3)),"."),m$.fnc$("WWWYEAR.main",YDATE.get())))));
      //<< . IF $$^WWWMONTH(YDATE)=MONATS WRITE " SELECTED=SELECTED"
      if (mOp.Equal(m$.fnc$("WWWMONTH.main",YDATE.get()),MONATS.get())) {
        m$.Cmd.Write(" SELECTED=SELECTED");
      }
      //<< . WRITE ">"_$PIECE($GET(^WWW101(0,"MONAT",SPRACHE,MONATS,1)),Y,1)_"</option>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",0,"MONAT",m$.var("SPRACHE").get(),MONATS.get(),1)),m$.var("Y").get(),1)),"</option>"));
    }
    //<< WRITE YCR,"</select>"
    m$.Cmd.Write(m$.var("YCR").get(),"</select>");
    //<< WRITE YCR,"</TD>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
    //<< 
    //<< WRITE YCR,"<TD>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TD>");
    //<< WRITE "<select NAME=JAHR onChange="_""""_"javascript:gotodate(this.value)"_""""_">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<select NAME=JAHR onChange=","\""),"javascript:gotodate(this.value)"),"\""),">"));
    //<< FOR JAHR=($$^WWWYEAR()-130):1:($$^WWWYEAR()+20) DO
    mVar JAHR = m$.var("JAHR");
    for (JAHR.set((mOp.Subtract(m$.fnc$("WWWYEAR.main"),130)));(mOp.LessOrEqual(JAHR.get(),(mOp.Add(m$.fnc$("WWWYEAR.main"),20))));JAHR.set(mOp.Add(JAHR.get(),1))) {
      //<< .;WRITE YCR,"<option value="_$$^WWWDATE1("01."_$EXTRACT(100+$$^WWWMONTH(YDATE),2,3)_"."_JAHR) ; SR17146
      //<< . WRITE YCR,"<option value="_$$DMY^WWWDATE1("01."_$EXTRACT(100+$$^WWWMONTH(YDATE),2,3)_"."_JAHR)
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat("<option value=",m$.fnc$("WWWDATE1.DMY",mOp.Concat(mOp.Concat(mOp.Concat("01.",m$.Fnc.$extract(mOp.Add(100,m$.fnc$("WWWMONTH.main",YDATE.get())),2,3)),"."),JAHR.get()))));
      //<< . IF $$^WWWYEAR(YDATE)=JAHR WRITE " SELECTED=SELECTED"
      if (mOp.Equal(m$.fnc$("WWWYEAR.main",YDATE.get()),JAHR.get())) {
        m$.Cmd.Write(" SELECTED=SELECTED");
      }
      //<< . WRITE ">"_JAHR_"</option>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(">",JAHR.get()),"</option>"));
    }
    //<< WRITE YCR,"</select>"
    m$.Cmd.Write(m$.var("YCR").get(),"</select>");
    //<< WRITE YCR,"</TD>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
    //<< 
    //<< WRITE YCR,"</TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    //<< WRITE YCR,"</TABLE>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    //<< 
    //<< SET TAGXXX = $$^WWWDATE(YDATE)
    TAGXXX.set(m$.fnc$("WWWDATE.main",YDATE.get()));
    //<< DO TERMIN1(TAGXXX,1,2)
    m$.Cmd.Do("TERMIN1",TAGXXX.get(),1,2);
    //<< WRITE "</CENTER>"
    m$.Cmd.Write("</CENTER>");
    //<< set YFIXHEADER=1  ;SR17460
    mVar YFIXHEADER = m$.var("YFIXHEADER");
    YFIXHEADER.set(1);
    //<< QUIT
    return null;
  }

  //<< 
  //<< 
  //<< TERMIN1(DATUM,TAG,CALTYPE)
  public Object TERMIN1(Object ... _p) {
    mVar DATUM = m$.newVarRef("DATUM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar TAG = m$.newVarRef("TAG",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar CALTYPE = m$.newVarRef("CALTYPE",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display calendar            ;TAGESKALENDER
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History :
    //<< ; 03-Jun-2010   GRF     SR17146: pass override format "DD.MM.YYYY" to WWWDATE1;
    //<< ;                           Use Start and End of Year variables; rewrite
    //<< ; 08-May-2009   GRF     SR16522: Extract DMY from strDate
    //<< ; 20-Aug-2007   GM      SR13729: Change "FELDFORMAT" parameter to $$GetFormat^INPARA()
    //<< ; 16-May-2007   HeberB  BR014457: Added type to enable being reused by WWWCAL1
    //<< ;-------------------------------------------------------------------------------
    //<< new FORMAT,intMonthStartDay,intYearEndDay,intYearStartDay,MAXWOCH,strMaxDays,TRENN,WEEK,YCAL
    mVar FORMAT = m$.var("FORMAT");
    mVar intMonthStartDay = m$.var("intMonthStartDay");
    mVar intYearEndDay = m$.var("intYearEndDay");
    mVar intYearStartDay = m$.var("intYearStartDay");
    mVar MAXWOCH = m$.var("MAXWOCH");
    mVar strMaxDays = m$.var("strMaxDays");
    mVar TRENN = m$.var("TRENN");
    mVar WEEK = m$.var("WEEK");
    mVar YCAL = m$.var("YCAL");
    m$.newVar(FORMAT,intMonthStartDay,intYearEndDay,intYearStartDay,MAXWOCH,strMaxDays,TRENN,WEEK,YCAL);
    //<< 
    //<< $$$LogR("TERMIN1",$get(DATUM)_"<"_$get(TAG)_"<"_$get(CALTYPE))
    $$$LogR(m$,"TERMIN1",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(DATUM),"<"),m$.Fnc.$get(TAG)),"<"),m$.Fnc.$get(CALTYPE)));
    //<< 
    //<< QUIT:'$DATA(DATUM)
    if (mOp.Not(m$.Fnc.$data(DATUM))) {
      return null;
    }
    //<< 
    //<< IF '$DATA(TAG) SET TAG = 1  ;TAG=0 : KEINE ANZEIGE DES TAGESDATUMS ;no Show
    if (mOp.Not(m$.Fnc.$data(TAG))) {
      TAG.set(1);
    }
    //<< SET YCAL = ""
    YCAL.set("");
    //<< IF $GET(YLOCATION)'="" SET YCAL = $PIECE($GET(^WWW0121(0,YM,YLOCATION,1)),Y,54)  ;KALENDERVORGABE;FIS;13.11.03;21655
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLOCATION")),"")) {
      YCAL.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0121",0,m$.var("YM").get(),m$.var("YLOCATION").get(),1)),m$.var("Y").get(),54));
    }
    //<< DO ^WWWFRAME(0)
    m$.Cmd.Do("WWWFRAME.main",0);
    //<< SET DAT = $$^WWWDATE(+$HOROLOG)
    mVar DAT = m$.var("DAT");
    DAT.set(m$.fnc$("WWWDATE.main",mOp.Positive(m$.Fnc.$horolog())));
    //<< 
    //<< ;---------------------------------------
    //<< ;  FORMAT   literal date structure      e.g. DD/MM/YYYY, MM-DD-YYYY, YYYY.MM.DD, YYYYMMDD
    //<< ;  TRENN    date delimiter character
    //<< ;  DAT      Today         - literal - not actually used for anything; MONATY/TAGY not used
    //<< ;  DATUM    Calendar date - literal
    //<< ;---------------------------------------
    //<< 
    //<< do GetDateFormat^COMUtilLocale(.FORMAT,.TRENN,SPRACHE)   ; SR16522
    m$.Cmd.Do("COMUtilLocale.GetDateFormat",FORMAT,TRENN,m$.var("SPRACHE").get());
    //<< do LitToDMY^WWWDATE1(DATUM,FORMAT,TRENN,.TAGXX,.MONATX,.JAHRX)
    m$.Cmd.Do("WWWDATE1.LitToDMY",DATUM.get(),FORMAT.get(),TRENN.get(),m$.var("TAGXX"),m$.var("MONATX"),m$.var("JAHRX"));
    //<< 
    //<< set strMaxDays = "312831303130313130313031"
    strMaxDays.set("312831303130313130313031");
    //<< set MAX   = $extract(strMaxDays,2*MONATX-1,2*MONATX)
    mVar MAX = m$.var("MAX");
    MAX.set(m$.Fnc.$extract(strMaxDays.get(),mOp.Subtract(mOp.Multiply(2,m$.var("MONATX").get()),1),mOp.Multiply(2,m$.var("MONATX").get())));
    //<< if (JAHRX#4=0) && (+MONATX=2) set MAX=29               ; FIXME : shortcut version - fails 1900
    if ((mOp.Equal(mOp.Modulus(m$.var("JAHRX").get(),4),0)) && (mOp.Equal(mOp.Positive(m$.var("MONATX").get()),2))) {
      MAX.set(29);
    }
    //<< set A     = "01."_$extract(MONATX+100,2,3)_"."_JAHRX
    mVar A = m$.var("A");
    A.set(mOp.Concat(mOp.Concat(mOp.Concat("01.",m$.Fnc.$extract(mOp.Add(m$.var("MONATX").get(),100),2,3)),"."),m$.var("JAHRX").get()));
    //<< set ZAHL  = $$DMY^WWWDATE1(A)                ; Start of Month                    ; SR17146
    mVar ZAHL = m$.var("ZAHL");
    ZAHL.set(m$.fnc$("WWWDATE1.DMY",A.get()));
    //<< set WEEK  = +$EXTRACT($$^WWWWEEK(ZAHL),1,2)  ; week and year wwyyyy e.g. 192009  ; SR17146
    WEEK.set(mOp.Positive(m$.Fnc.$extract(m$.fnc$("WWWWEEK.main",ZAHL.get()),1,2)));
    //<< 
    //<< $$$LogRx("T:1:"_A_"<"_ZAHL_"<"_WEEK)
    $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("T:1:",A.get()),"<"),ZAHL.get()),"<"),WEEK.get()));
    //<< ; create array
    //<< ;---------------------------------------
    //<< set TX    = ZAHL-4#7
    mVar TX = m$.var("TX");
    TX.set(mOp.Modulus(mOp.Subtract(ZAHL.get(),4),7));
    //<< set WOCHE = 1
    mVar WOCHE = m$.var("WOCHE");
    WOCHE.set(1);
    //<< set TAGXE = 0
    mVar TAGXE = m$.var("TAGXE");
    TAGXE.set(0);
    //<< do TAGXE
    m$.Cmd.Do("TAGXE");
    //<< 
    //<< set intYearStartDay  = $$^WWWDAY($$DMY^WWWDATE1("01.01."_JAHRX))   ; SR17146
    intYearStartDay.set(m$.fnc$("WWWDAY.main",m$.fnc$("WWWDATE1.DMY",mOp.Concat("01.01.",m$.var("JAHRX").get()))));
    //<< set intYearEndDay    = $$^WWWDAY($$DMY^WWWDATE1("31.12."_JAHRX))
    intYearEndDay.set(m$.fnc$("WWWDAY.main",m$.fnc$("WWWDATE1.DMY",mOp.Concat("31.12.",m$.var("JAHRX").get()))));
    //<< set intMonthStartDay = $$^WWWDAY(ZAHL)
    intMonthStartDay.set(m$.fnc$("WWWDAY.main",ZAHL.get()));
    //<< 
    //<< SET MAXWOCH=52
    MAXWOCH.set(52);
    //<< IF (intYearStartDay=4) || (intYearEndDay=4) SET MAXWOCH = 53
    if ((mOp.Equal(intYearStartDay.get(),4)) || (mOp.Equal(intYearEndDay.get(),4))) {
      MAXWOCH.set(53);
    }
    //<< 
    //<< IF WEEK=52 IF MONATX=1 SET WEEK(1)="52,1,2,3,4,5"
    if (mOp.Equal(WEEK.get(),52)) {
      if (mOp.Equal(m$.var("MONATX").get(),1)) {
        WEEK.var(1).set("52,1,2,3,4,5");
      }
    }
    //<< IF WEEK=53 IF MONATX=1 SET WEEK(1)="53,1,2,3,4,5"
    if (mOp.Equal(WEEK.get(),53)) {
      if (mOp.Equal(m$.var("MONATX").get(),1)) {
        WEEK.var(1).set("53,1,2,3,4,5");
      }
    }
    //<< 
    //<< SET KWPM=5
    mVar KWPM = m$.var("KWPM");
    KWPM.set(5);
    //<< IF (MONATX=2) && (MAX=28) && (intMonthStartDay=1)             SET KWPN=4
    if ((mOp.Equal(m$.var("MONATX").get(),2)) && (mOp.Equal(MAX.get(),28)) && (mOp.Equal(intMonthStartDay.get(),1))) {
      mVar KWPN = m$.var("KWPN");
      KWPN.set(4);
    }
    //<< IF (intMonthStartDay=7) && (MAX=30)                           SET KWPM=6
    if ((mOp.Equal(intMonthStartDay.get(),7)) && (mOp.Equal(MAX.get(),30))) {
      KWPM.set(6);
    }
    //<< IF ((intMonthStartDay=6) || (intMonthStartDay=7)) && (MAX=31) SET KWPM=6
    if (mOp.Logical(((mOp.Equal(intMonthStartDay.get(),6)) || (mOp.Equal(intMonthStartDay.get(),7)))) && (mOp.Equal(MAX.get(),31))) {
      KWPM.set(6);
    }
    //<< 
    //<< IF MONATX=12 DO
    if (mOp.Equal(m$.var("MONATX").get(),12)) {
      //<< . IF KWPM=5 DO
      if (mOp.Equal(KWPM.get(),5)) {
        //<< . . IF (intYearEndDay=1) || (intYearEndDay=2) || (intYearEndDay=3) DO
        if ((mOp.Equal(intYearEndDay.get(),1)) || (mOp.Equal(intYearEndDay.get(),2)) || (mOp.Equal(intYearEndDay.get(),3))) {
          //<< . . . IF intYearStartDay=4  SET WEEK(1)="50,51,52,53,1" SET GO=1
          if (mOp.Equal(intYearStartDay.get(),4)) {
            WEEK.var(1).set("50,51,52,53,1");
            mVar GO = m$.var("GO");
            GO.set(1);
          }
          //<< . . . IF intYearStartDay'=4 SET WEEK(1)="49,50,51,52,1" SET GO=1
          if (mOp.NotEqual(intYearStartDay.get(),4)) {
            WEEK.var(1).set("49,50,51,52,1");
            mVar GO = m$.var("GO");
            GO.set(1);
          }
        }
        //<< . . ;
        //<< . . IF (intYearEndDay'=1) && (intYearEndDay'=2) && (intYearEndDay'=3) DO
        if ((mOp.NotEqual(intYearEndDay.get(),1)) && (mOp.NotEqual(intYearEndDay.get(),2)) && (mOp.NotEqual(intYearEndDay.get(),3))) {
          //<< . . . IF (intYearStartDay=4)  || (intYearEndDay=4)  SET WEEK(1)="49,50,51,52,53" SET GO=1
          if ((mOp.Equal(intYearStartDay.get(),4)) || (mOp.Equal(intYearEndDay.get(),4))) {
            WEEK.var(1).set("49,50,51,52,53");
            mVar GO = m$.var("GO");
            GO.set(1);
          }
          //<< . . . IF (intYearStartDay'=4) && (intYearEndDay'=4) SET WEEK(1)="48,49,50,51,52" SET GO=1
          if ((mOp.NotEqual(intYearStartDay.get(),4)) && (mOp.NotEqual(intYearEndDay.get(),4))) {
            WEEK.var(1).set("48,49,50,51,52");
            mVar GO = m$.var("GO");
            GO.set(1);
          }
        }
      }
      //<< . ;
      //<< . IF KWPM=6 DO
      if (mOp.Equal(KWPM.get(),6)) {
        //<< . . IF (intYearEndDay=1) || (intYearEndDay=2) || (intYearEndDay=3) DO
        if ((mOp.Equal(intYearEndDay.get(),1)) || (mOp.Equal(intYearEndDay.get(),2)) || (mOp.Equal(intYearEndDay.get(),3))) {
          //<< . . . IF intYearStartDay=4  SET WEEK(1)="49,50,51,52,53,1" SET GO=1
          if (mOp.Equal(intYearStartDay.get(),4)) {
            WEEK.var(1).set("49,50,51,52,53,1");
            mVar GO = m$.var("GO");
            GO.set(1);
          }
          //<< . . . IF intYearStartDay'=4 SET WEEK(1)="48,49,50,51,52,1" SET GO=1
          if (mOp.NotEqual(intYearStartDay.get(),4)) {
            WEEK.var(1).set("48,49,50,51,52,1");
            mVar GO = m$.var("GO");
            GO.set(1);
          }
        }
        //<< . . ;
        //<< . . IF (intYearEndDay'=1) && (intYearEndDay'=2) && (intYearEndDay'=3) DO
        if ((mOp.NotEqual(intYearEndDay.get(),1)) && (mOp.NotEqual(intYearEndDay.get(),2)) && (mOp.NotEqual(intYearEndDay.get(),3))) {
          //<< . . . IF (intYearStartDay=4)  || (intYearEndDay=4)  SET WEEK(1)="48,49,50,51,52,53" SET GO=1
          if ((mOp.Equal(intYearStartDay.get(),4)) || (mOp.Equal(intYearEndDay.get(),4))) {
            WEEK.var(1).set("48,49,50,51,52,53");
            mVar GO = m$.var("GO");
            GO.set(1);
          }
          //<< . . . IF (intYearStartDay'=4) && (intYearEndDay'=4) SET WEEK(1)="47,48,49,50,51,52" SET GO=1
          if ((mOp.NotEqual(intYearStartDay.get(),4)) && (mOp.NotEqual(intYearEndDay.get(),4))) {
            WEEK.var(1).set("47,48,49,50,51,52");
            mVar GO = m$.var("GO");
            GO.set(1);
          }
        }
      }
    }
    //<< 
    //<< ; Display Calendar
    //<< ;---------------------------------------  ;FIS;26211;03.08.04
    //<< if $piece($get(^WWW012(0,YM,1)),Y,164)=$$$YES {   ; D164  Calendar In Horizontal Orientation
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),164),include.COMSYS.$$$YES(m$))) {
      //<< do HORIZON(CALTYPE)
      m$.Cmd.Do("HORIZON",CALTYPE.get());
    }
    //<< } else {
    else {
      //<< do VERTICAL(CALTYPE)
      m$.Cmd.Do("VERTICAL",CALTYPE.get());
    }
    //<< }
    //<< 
    //<< do ^WWWFRAME(1)
    m$.Cmd.Do("WWWFRAME.main",1);
    //<< if CALTYPE=2 {
    if (mOp.Equal(CALTYPE.get(),2)) {
      //<< write YCR,"</CENTER>"
      m$.Cmd.Write(m$.var("YCR").get(),"</CENTER>");
      //<< ;SR17460 write YCR,"<A onClick='return doLink(this)' HREF=""JavaScript:self.close();"_""""_">"
      //<< ;SR17460 write "<IMG SRC="_""""_YGIF_"end.gif"_""""_" border=0 HEIGHT=22 ALIGN=TOP VALIGN=LEFT TITLE="_""""_$$^WWWTEXT(33564)_""""_">"  ; "Close"
      //<< ;SR17460 write "</A>",YCR
      //<< if WEBUSER=1 set YNOFOOT=1  ;FIS;15.12.04;26564
      if (mOp.Equal(m$.var("WEBUSER").get(),1)) {
        mVar YNOFOOT = m$.var("YNOFOOT");
        YNOFOOT.set(1);
      }
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< TAGXE
  public void TAGXE() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;  Create array of dates by week and day of week
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:   TX
    //<< ;           TAGXE
    //<< ;           MAX
    //<< ;           WOCHE   Week Number
    //<< ;           A()
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History :
    //<< ; 16-May-2007   HeberB  BR014457: Added type to be reused by WWWCAL1
    //<< ;-------------------------------------------------------------------------------
    //<< FOR  DO  QUIT:TAGXE>MAX
    for (;true;) {
      do {
        //<< . SET TX=TX+1,TAGXE=TAGXE+1
        mVar TX = m$.var("TX");
        TX.set(mOp.Add(m$.var("TX").get(),1));
        mVar TAGXE = m$.var("TAGXE");
        TAGXE.set(mOp.Add(m$.var("TAGXE").get(),1));
        //<< . QUIT:TAGXE>MAX
        if (mOp.Greater(TAGXE.get(),m$.var("MAX").get())) {
          break;
        }
        //<< . ;
        //<< . SET:TX>7 WOCHE=WOCHE+1,TX=1
        if (mOp.Greater(TX.get(),7)) {
          m$.var("WOCHE").set(mOp.Add(m$.var("WOCHE").get(),1));
          TX.set(1);
        }
        //<< . SET A(WOCHE,TX)=TAGXE
        mVar A = m$.var("A");
        A.var(m$.var("WOCHE").get(),TX.get()).set(TAGXE.get());
        //<< . IF CALTYPE=2 DO
        if (mOp.Equal(m$.var("CALTYPE").get(),2)) {
          //<< . . IF TAG'=0 IF +TAGXE=+TAGXX SET A(WOCHE,TX)="*"_TAGXE
          if (mOp.NotEqual(m$.var("TAG").get(),0)) {
            if (mOp.Equal(mOp.Positive(TAGXE.get()),mOp.Positive(m$.var("TAGXX").get()))) {
              A.var(m$.var("WOCHE").get(),TX.get()).set(mOp.Concat("*",TAGXE.get()));
            }
          }
        }
      } while (false);
      if (mOp.Greater(m$.var("TAGXE").get(),m$.var("MAX").get())) {
        break;
      }
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< VERTICAL(CALTYPE)
  public Object VERTICAL(Object ... _p) {
    mVar CALTYPE = m$.newVarRef("CALTYPE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 16-May-2007   HeberB  SRBR014457: Added call to print cell of type CAL1 and CAL2
    //<< ; 02-Apr-2007   SHOBBY  SRBR014426: Fixed up display of words containing diacretic marks
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< $$$LogR("VERTICAL",$get(CALTYPE))
    $$$LogR(m$,"VERTICAL",m$.Fnc.$get(CALTYPE));
    //<< 
    //<< ; Row 2
    //<< ;---------------------------------------
    //<< WRITE "<TR>"
    m$.Cmd.Write("<TR>");
    //<< WRITE "<TH COLSPAN=7 NOWRAP><FONT SIZE=2>"
    m$.Cmd.Write("<TH COLSPAN=7 NOWRAP><FONT SIZE=2>");
    //<< WRITE " "_$$$AppEnum("MONAT",+MONATX)_" "_JAHRX_"    "
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ",include.COMSYSWWW.$$$AppEnum(m$,"MONAT",mOp.Positive(m$.var("MONATX").get())))," "),m$.var("JAHRX").get()),"    "));
    //<< WRITE YCR,"</TH>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TH>");
    //<< WRITE YCR,"</TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    //<< 
    //<< ; Row 3
    //<< ;---------------------------------------
    //<< WRITE YCR,"<TR><TH align=left><FONT SIZE=2>"_$$$TextSimple(31001)_"</FONT></TH>"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TR><TH align=left><FONT SIZE=2>",include.COMSYS.$$$TextSimple(m$,31001)),"</FONT></TH>"));
    //<< 
    //<< IF WEEK'=52 IF WEEK'=53 IF GO'=1 DO
    if (mOp.NotEqual(m$.var("WEEK").get(),52)) {
      if (mOp.NotEqual(m$.var("WEEK").get(),53)) {
        if (mOp.NotEqual(m$.var("GO").get(),1)) {
          //<< . ;--END
          //<< . ;FOR I=WEEK:1:(WEEK+5) DO   ; ORIGINAL LINE
          //<< . FOR I=WEEK:1:(WEEK+(KWPM-1)) DO
          mVar I = m$.var("I");
          for (I.set(m$.var("WEEK").get());(mOp.LessOrEqual(I.get(),(mOp.Add(m$.var("WEEK").get(),(mOp.Subtract(m$.var("KWPM").get(),1))))));I.set(mOp.Add(I.get(),1))) {
            //<< . . SET WOC=I
            mVar WOC = m$.var("WOC");
            WOC.set(I.get());
            //<< . . ;SET:WOC>MAXWOCH WOC=WOC-MAXWOCH   ; OLD CODE
            //<< . . WRITE YCR,"<TH ALIGN=CENTER><FONT SIZE=2>"
            m$.Cmd.Write(m$.var("YCR").get(),"<TH ALIGN=CENTER><FONT SIZE=2>");
            //<< . . IF SPRACHE="DE" DO
            if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
              //<< . . . IF YUSERAGENT="MSIE" WRITE "<A HREF="_""""_"#"_""""_" onclick="_""""_"window.returnValue='"_WOC_"."_JAHRX_" KW"_"'; window.close();"_""""_">"
              if (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),"#"),"\"")," onclick="),"\""),"window.returnValue='"),WOC.get()),"."),m$.var("JAHRX").get())," KW"),"'; window.close();"),"\""),">"));
              }
              //<< . . . //IF YUSERAGENT'="MSIE" IF $GET(YLFDAT)'="" WRITE "<A onClick='return doLink(this)' HREF=""JavaScript: top.opener.document."_YHTMFORM_"."_YLFDAT_".value='"_WOC_"."_JAHRX_" KW"_"'; top.opener.document."_YHTMFORM_"."_YLFDAT_".focus(); top.close(); close();"_""""_">"
              //<< . . . IF YUSERAGENT'="MSIE" IF $GET(YLFDAT)'="" WRITE "<A onClick='return doLink(this)' HREF=""JavaScript: top.opener.document.getElementById('"_YLFDAT_"').value='"_WOC_"."_JAHRX_" KW"_"'; top.opener.document.getElementById('"_YLFDAT_"').focus(); top.close(); close();"_""""_">"  //SR17431
              if (mOp.NotEqual(m$.var("YUSERAGENT").get(),"MSIE")) {
                if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLFDAT")),"")) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A onClick='return doLink(this)' HREF=\"JavaScript: top.opener.document.getElementById('",m$.var("YLFDAT").get()),"').value='"),WOC.get()),"."),m$.var("JAHRX").get())," KW"),"'; top.opener.document.getElementById('"),m$.var("YLFDAT").get()),"').focus(); top.close(); close();"),"\""),">"));
                }
              }
            }
            //<< . . ;
            //<< . . WRITE WOC
            m$.Cmd.Write(WOC.get());
            //<< . . IF SPRACHE="DE" DO
            if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
              //<< . . . WRITE "</A>"
              m$.Cmd.Write("</A>");
            }
            //<< . . ;
            //<< . . WRITE "</FONT></TH>"
            m$.Cmd.Write("</FONT></TH>");
          }
          //<< . ;
          //<< . IF (I-WEEK)<5 WRITE YCR,"<TH ALIGN=CENTER><FONT SIZE=2>&nbsp;</FONT></TH>"  ;FIS;15.12.04;WEGEN COLSPAN OBEN
          if (mOp.Less((mOp.Subtract(I.get(),m$.var("WEEK").get())),5)) {
            m$.Cmd.Write(m$.var("YCR").get(),"<TH ALIGN=CENTER><FONT SIZE=2>&nbsp;</FONT></TH>");
          }
        }
      }
    }
    //<< 
    //<< ;---WEM;02.09.2003;#22960;ADDED
    //<< IF (WEEK=52) || (WEEK=53) || (GO=1) DO
    if ((mOp.Equal(m$.var("WEEK").get(),52)) || (mOp.Equal(m$.var("WEEK").get(),53)) || (mOp.Equal(m$.var("GO").get(),1))) {
      //<< . FOR I=1:1:KWPM DO
      mVar I = m$.var("I");
      for (I.set(1);(mOp.LessOrEqual(I.get(),m$.var("KWPM").get()));I.set(mOp.Add(I.get(),1))) {
        //<< . . SET WOC=I
        mVar WOC = m$.var("WOC");
        WOC.set(I.get());
        //<< . . WRITE YCR,"<TH ALIGN=CENTER><FONT SIZE=2>"
        m$.Cmd.Write(m$.var("YCR").get(),"<TH ALIGN=CENTER><FONT SIZE=2>");
        //<< . . IF SPRACHE="DE" DO
        if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
          //<< . . . IF YUSERAGENT="MSIE" WRITE "<A HREF="_""""_"#"_""""_" onclick="_""""_"window.returnValue='"_WOC_"."_JAHRX_" KW"_"'; window.close();"_""""_">"
          if (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),"#"),"\"")," onclick="),"\""),"window.returnValue='"),WOC.get()),"."),m$.var("JAHRX").get())," KW"),"'; window.close();"),"\""),">"));
          }
          //<< . . . //IF YUSERAGENT'="MSIE" IF $GET(YLFDAT)'="" WRITE "<A onClick='return doLink(this)' HREF=""JavaScript: top.opener.document."_YHTMFORM_"."_YLFDAT_".value='"_WOC_"."_JAHRX_" KW"_"'; top.opener.document."_YHTMFORM_"."_YLFDAT_".focus(); top.close(); close();"_""""_">"
          //<< . . . IF YUSERAGENT'="MSIE" IF $GET(YLFDAT)'="" WRITE "<A onClick='return doLink(this)' HREF=""JavaScript: top.opener.document.getElementById('"_YLFDAT_"').value='"_WOC_"."_JAHRX_" KW"_"'; top.opener.document.getElementById('"_YLFDAT_"').focus(); top.close(); close();"_""""_">"  //SR17431
          if (mOp.NotEqual(m$.var("YUSERAGENT").get(),"MSIE")) {
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLFDAT")),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A onClick='return doLink(this)' HREF=\"JavaScript: top.opener.document.getElementById('",m$.var("YLFDAT").get()),"').value='"),WOC.get()),"."),m$.var("JAHRX").get())," KW"),"'; top.opener.document.getElementById('"),m$.var("YLFDAT").get()),"').focus(); top.close(); close();"),"\""),">"));
            }
          }
        }
        //<< . . ;
        //<< . . WRITE $PIECE(WEEK(1),",",I)
        m$.Cmd.Write(m$.Fnc.$piece(m$.var("WEEK").var(1).get(),",",I.get()));
        //<< . . IF SPRACHE="DE" DO
        if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
          //<< . . . WRITE "</A>"
          m$.Cmd.Write("</A>");
        }
        //<< . . ;
        //<< . . WRITE "</FONT></TH>"
        m$.Cmd.Write("</FONT></TH>");
      }
      //<< . ;
      //<< . IF (I-1)<5 WRITE YCR,"<TH ALIGN=CENTER><FONT SIZE=2>&nbsp;</FONT></TH>"  ;FIS;15.12.04;WEGEN COLSPAN OBEN
      if (mOp.Less((mOp.Subtract(I.get(),1)),5)) {
        m$.Cmd.Write(m$.var("YCR").get(),"<TH ALIGN=CENTER><FONT SIZE=2>&nbsp;</FONT></TH>");
      }
    }
    //<< 
    //<< ;---END
    //<< WRITE YCR,"</TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    //<< 
    //<< 
    //<< ; Row 4
    //<< ;---------------------------------------
    //<< FOR TAGXE=1:1:7 DO
    mVar TAGXE = m$.var("TAGXE");
    for (TAGXE.set(1);(mOp.LessOrEqual(TAGXE.get(),7));TAGXE.set(mOp.Add(TAGXE.get(),1))) {
      //<< . WRITE "<TR>"
      m$.Cmd.Write("<TR>");
      //<< . WRITE "<TD><FONT SIZE=2>"
      m$.Cmd.Write("<TD><FONT SIZE=2>");
      //<< . WRITE $$$AppEnum("COMDAYSOFWEEK",TAGXE)
      m$.Cmd.Write(include.COMSYSWWW.$$$AppEnum(m$,"COMDAYSOFWEEK",TAGXE));
      //<< . WRITE YCR,"</FONT></TD>"
      m$.Cmd.Write(m$.var("YCR").get(),"</FONT></TD>");
      //<< . FOR WOCHE=1:1:6 DO
      mVar WOCHE = m$.var("WOCHE");
      for (WOCHE.set(1);(mOp.LessOrEqual(WOCHE.get(),6));WOCHE.set(mOp.Add(WOCHE.get(),1))) {
        //<< . . IF CALTYPE=2 DO CalendarCellCal2  ; FIXME : specify (); pass arguments
        if (mOp.Equal(CALTYPE.get(),2)) {
          m$.Cmd.Do("CalendarCellCal2");
        }
        //<< . . IF CALTYPE=1 DO CalendarCellCal1
        if (mOp.Equal(CALTYPE.get(),1)) {
          m$.Cmd.Do("CalendarCellCal1");
        }
      }
      //<< . ;
      //<< . WRITE YCR,"</TR>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    }
    //<< 
    //<< QUIT
    return null;
  }

  //<< 
  //<< 
  //<< HORIZON(CALTYPE)
  public Object HORIZON(Object ... _p) {
    mVar CALTYPE = m$.newVarRef("CALTYPE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 16-May-2007   HeberB  SRBR014457: Added call to print cell of type CAL1 and CAL2
    //<< ; 02-Apr-2007   SHOBBY  SRBR014426: Fixed up display of words containing diacretic marks
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< $$$LogR("HORIZON",$get(CALTYPE))
    $$$LogR(m$,"HORIZON",m$.Fnc.$get(CALTYPE));
    //<< 
    //<< ; Row 2
    //<< ;---------------------------------------
    //<< WRITE "<TR>"
    m$.Cmd.Write("<TR>");
    //<< WRITE "<TH COLSPAN=8 NOWRAP><FONT SIZE=2>"
    m$.Cmd.Write("<TH COLSPAN=8 NOWRAP><FONT SIZE=2>");
    //<< WRITE " "_$$$AppEnum("MONAT",+MONATX)_" "_JAHRX_"    "
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ",include.COMSYSWWW.$$$AppEnum(m$,"MONAT",mOp.Positive(m$.var("MONATX").get())))," "),m$.var("JAHRX").get()),"    "));
    //<< WRITE YCR,"</FONT></TH>"
    m$.Cmd.Write(m$.var("YCR").get(),"</FONT></TH>");
    //<< WRITE YCR,"</TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    //<< 
    //<< ; Row 3
    //<< ;---------------------------------------
    //<< WRITE YCR,"<TR><TH align=left><FONT SIZE=2>"_$$$TextSimple(31001)_"</FONT></TH>" ; "Week"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TR><TH align=left><FONT SIZE=2>",include.COMSYS.$$$TextSimple(m$,31001)),"</FONT></TH>"));
    //<< 
    //<< FOR TAGXE=1:1:7 DO
    mVar TAGXE = m$.var("TAGXE");
    for (TAGXE.set(1);(mOp.LessOrEqual(TAGXE.get(),7));TAGXE.set(mOp.Add(TAGXE.get(),1))) {
      //<< . WRITE YCR,"<TD ALIGN=CENTER><FONT SIZE=2><B>"
      m$.Cmd.Write(m$.var("YCR").get(),"<TD ALIGN=CENTER><FONT SIZE=2><B>");
      //<< . write $$$AppEnum("COMDAYSOFWEEKSHORT",TAGXE)         ; "Monday"..."Sunday"
      m$.Cmd.Write(include.COMSYSWWW.$$$AppEnum(m$,"COMDAYSOFWEEKSHORT",TAGXE));
      //<< . WRITE YCR,"</B></FONT></TD>"
      m$.Cmd.Write(m$.var("YCR").get(),"</B></FONT></TD>");
    }
    //<< 
    //<< SET WOCHE=0
    mVar WOCHE = m$.var("WOCHE");
    WOCHE.set(0);
    //<< IF WEEK'=52 IF WEEK'=53 IF GO'=1 DO
    if (mOp.NotEqual(m$.var("WEEK").get(),52)) {
      if (mOp.NotEqual(m$.var("WEEK").get(),53)) {
        if (mOp.NotEqual(m$.var("GO").get(),1)) {
          //<< . FOR I=WEEK:1:(WEEK+(KWPM-1)) DO
          mVar I = m$.var("I");
          for (I.set(m$.var("WEEK").get());(mOp.LessOrEqual(I.get(),(mOp.Add(m$.var("WEEK").get(),(mOp.Subtract(m$.var("KWPM").get(),1))))));I.set(mOp.Add(I.get(),1))) {
            //<< . . SET WOC=I
            mVar WOC = m$.var("WOC");
            WOC.set(I.get());
            //<< . . WRITE "<TR>"
            m$.Cmd.Write("<TR>");
            //<< . . WRITE YCR,"<TD ALIGN=CENTER><FONT SIZE=2>"         ; FIXME : why special German function?
            m$.Cmd.Write(m$.var("YCR").get(),"<TD ALIGN=CENTER><FONT SIZE=2>");
            //<< . . IF SPRACHE="DE" IF YUSERAGENT="MSIE" WRITE "<A HREF="_""""_"#"_""""_" onclick="_""""_"window.returnValue='"_WOC_"."_JAHRX_" KW"_"'; window.close();"_""""_">"
            if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
              if (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),"#"),"\"")," onclick="),"\""),"window.returnValue='"),WOC.get()),"."),m$.var("JAHRX").get())," KW"),"'; window.close();"),"\""),">"));
              }
            }
            //<< . . WRITE "<B>"_WOC_"</B>"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<B>",WOC.get()),"</B>"));
            //<< . . IF SPRACHE="DE" IF YUSERAGENT="MSIE" WRITE "</A>"
            if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
              if (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")) {
                m$.Cmd.Write("</A>");
              }
            }
            //<< . . WRITE YCR,"</FONT></TD>"
            m$.Cmd.Write(m$.var("YCR").get(),"</FONT></TD>");
            //<< . . ;
            //<< . . SET WOCHE=WOCHE+1
            WOCHE.set(mOp.Add(WOCHE.get(),1));
            //<< . . FOR TAGXE=1:1:7 DO
            for (TAGXE.set(1);(mOp.LessOrEqual(TAGXE.get(),7));TAGXE.set(mOp.Add(TAGXE.get(),1))) {
              //<< . . . IF CALTYPE=2 DO CalendarCellCal2  ; FIXME : specify (); pass arguments
              if (mOp.Equal(CALTYPE.get(),2)) {
                m$.Cmd.Do("CalendarCellCal2");
              }
              //<< . . . IF CALTYPE=1 DO CalendarCellCal1
              if (mOp.Equal(CALTYPE.get(),1)) {
                m$.Cmd.Do("CalendarCellCal1");
              }
            }
            //<< . . ;
            //<< . . WRITE YCR,"</TR>"
            m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
          }
        }
      }
    }
    //<< 
    //<< IF (WEEK=52) || (WEEK=53) || (GO=1) DO
    if ((mOp.Equal(m$.var("WEEK").get(),52)) || (mOp.Equal(m$.var("WEEK").get(),53)) || (mOp.Equal(m$.var("GO").get(),1))) {
      //<< . FOR I=1:1:KWPM DO
      mVar I = m$.var("I");
      for (I.set(1);(mOp.LessOrEqual(I.get(),m$.var("KWPM").get()));I.set(mOp.Add(I.get(),1))) {
        //<< . . SET WOC=I
        mVar WOC = m$.var("WOC");
        WOC.set(I.get());
        //<< . . WRITE "<TR>"
        m$.Cmd.Write("<TR>");
        //<< . . WRITE YCR,"<TD ALIGN=CENTER><FONT SIZE=2>"
        m$.Cmd.Write(m$.var("YCR").get(),"<TD ALIGN=CENTER><FONT SIZE=2>");
        //<< . . IF SPRACHE="DE" DO                                       ; FIXME : why special German function?
        if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
          //<< . . . IF YUSERAGENT="MSIE" WRITE "<A HREF="_""""_"#"_""""_" onclick="_""""_"window.returnValue='"_WOC_"."_JAHRX_" KW"_"'; window.close();"_""""_">"
          if (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),"#"),"\"")," onclick="),"\""),"window.returnValue='"),WOC.get()),"."),m$.var("JAHRX").get())," KW"),"'; window.close();"),"\""),">"));
          }
          //<< . . . //IF YUSERAGENT'="MSIE" IF $GET(YLFDAT)'="" WRITE "<A onClick='return doLink(this)' HREF=""JavaScript: top.opener.document."_YHTMFORM_"."_YLFDAT_".value='"_WOC_"."_JAHRX_" KW"_"'; top.opener.document."_YHTMFORM_"."_YLFDAT_".focus(); top.close(); close();"_""""_">"
          //<< . . . IF YUSERAGENT'="MSIE" IF $GET(YLFDAT)'="" WRITE "<A onClick='return doLink(this)' HREF=""JavaScript: top.opener.document.getElementById('"_YLFDAT_"').value='"_WOC_"."_JAHRX_" KW"_"'; top.opener.document.getElementById('"_YLFDAT_"').focus(); top.close(); close();"_""""_">"  //SR17431
          if (mOp.NotEqual(m$.var("YUSERAGENT").get(),"MSIE")) {
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLFDAT")),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A onClick='return doLink(this)' HREF=\"JavaScript: top.opener.document.getElementById('",m$.var("YLFDAT").get()),"').value='"),WOC.get()),"."),m$.var("JAHRX").get())," KW"),"'; top.opener.document.getElementById('"),m$.var("YLFDAT").get()),"').focus(); top.close(); close();"),"\""),">"));
            }
          }
        }
        //<< . . ;
        //<< . . WRITE "<B>"_$PIECE(WEEK(1),",",I)_"</B>"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<B>",m$.Fnc.$piece(m$.var("WEEK").var(1).get(),",",I.get())),"</B>"));
        //<< . . IF SPRACHE="DE" WRITE "</A>"
        if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
          m$.Cmd.Write("</A>");
        }
        //<< . . WRITE YCR,"</FONT></TD>"
        m$.Cmd.Write(m$.var("YCR").get(),"</FONT></TD>");
        //<< . . ;
        //<< . . SET WOCHE=WOCHE+1
        WOCHE.set(mOp.Add(WOCHE.get(),1));
        //<< . . FOR TAGXE=1:1:7 DO
        for (TAGXE.set(1);(mOp.LessOrEqual(TAGXE.get(),7));TAGXE.set(mOp.Add(TAGXE.get(),1))) {
          //<< . . . IF CALTYPE=2 DO CalendarCellCal2
          if (mOp.Equal(CALTYPE.get(),2)) {
            m$.Cmd.Do("CalendarCellCal2");
          }
          //<< . . . IF CALTYPE=1 DO CalendarCellCal1
          if (mOp.Equal(CALTYPE.get(),1)) {
            m$.Cmd.Do("CalendarCellCal1");
          }
        }
        //<< . . ;
        //<< . . WRITE YCR,"</TR>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
      }
    }
    //<< 
    //<< QUIT
    return null;
  }

  //<< 
  //<< SAVE ;SAVE START MASKE ;take-off mask
  public void SAVE() {
    //<< SET %(YQUERY,"YKEY")=""
    m$.var("%",m$.var("YQUERY").get(),"YKEY").set("");
    //<< SET YLFDAT=$GET(%(YQUERY,"YLFDAT"))
    mVar YLFDAT = m$.var("YLFDAT");
    YLFDAT.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YLFDAT")));
    //<< SET %(YQUERY,"YLFDAT")=YLFDAT
    m$.var("%",m$.var("YQUERY").get(),"YLFDAT").set(YLFDAT.get());
    //<< DO ^WWWFORM
    m$.Cmd.Do("WWWFORM.main");
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< CalendarCellCal1
  public void CalendarCellCal1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Print table cell with day for WWWCAL1
    //<< ; - Get day of month from array of weeks and days (blanks if no array element)
    //<< ; - Today is yellow; weekends are pink and holidays are blue
    //<< ; - TAGTM is horolog date
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Jun-2010   GRF     SR17146: pass override format "DD.MM.YYYY" to WWWDATE1
    //<< ; 16-May-2007   HeberB  SRBR014457: Copied from WWWCAL1
    //<< ;-------------------------------------------------------------------------------
    //<< SET TAGTM = ""
    mVar TAGTM = m$.var("TAGTM");
    TAGTM.set("");
    //<< SET A     = "&nbsp;&nbsp;&nbsp;"
    mVar A = m$.var("A");
    A.set("&nbsp;&nbsp;&nbsp;");
    //<< SET:$DATA(A(WOCHE,TAGXE)) A = A(WOCHE,TAGXE)
    if (mOp.Logical(m$.Fnc.$data(A.var(m$.var("WOCHE").get(),m$.var("TAGXE").get())))) {
      A.set(A.var(m$.var("WOCHE").get(),m$.var("TAGXE").get()).get());
    }
    //<< 
    //<< WRITE "<TD"
    m$.Cmd.Write("<TD");
    //<< IF +A'=0 DO
    if (mOp.NotEqual(mOp.Positive(A.get()),0)) {
      do {
        //<< .;SET TAGTM = $$^WWWDATE1($EXTRACT(100+A,2,3)_"."_$EXTRACT(100+MONATX,2,3)_"."_JAHRX)  ;TAGESZAHL ; SR17146
        //<< . set TAGTM = $$DMY^WWWDATE1($extract(100+A,2,3)_"."_$extract(100+MONATX,2,3)_"."_JAHRX)
        TAGTM.set(m$.fnc$("WWWDATE1.DMY",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(mOp.Add(100,A.get()),2,3),"."),m$.Fnc.$extract(mOp.Add(100,m$.var("MONATX").get()),2,3)),"."),m$.var("JAHRX").get())));
        //<< . ;
        //<< . IF TAGTM=+$HOROLOG                                                WRITE " BGCOLOR=LIGHTGOLDENRODYELLOW" QUIT  ;HEUTE ;today
        if (mOp.Equal(TAGTM.get(),mOp.Positive(m$.Fnc.$horolog()))) {
          m$.Cmd.Write(" BGCOLOR=LIGHTGOLDENRODYELLOW");
          break;
        }
        //<< . IF KALENDER="" IF TAGTM'="" IF $DATA(^TERMIN9(0,SPRACHE,TAGTM,1)) WRITE " BGCOLOR=LIGHTBLUE"            QUIT  ;FEIERTAG STANDARD ;holiday
        if (mOp.Equal(m$.var("KALENDER").get(),"")) {
          if (mOp.NotEqual(TAGTM.get(),"")) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^TERMIN9",0,m$.var("SPRACHE").get(),TAGTM.get(),1)))) {
              m$.Cmd.Write(" BGCOLOR=LIGHTBLUE");
              break;
            }
          }
        }
        //<< . IF KALENDER="" IF TAGXE>5                                         WRITE " BGCOLOR=MISTYROSE"  ;WOCHENENDE STANDARD ;weekend
        if (mOp.Equal(m$.var("KALENDER").get(),"")) {
          if (mOp.Greater(m$.var("TAGXE").get(),5)) {
            m$.Cmd.Write(" BGCOLOR=MISTYROSE");
          }
        }
        //<< . IF KALENDER'="" IF TAGTM'="" DO
        if (mOp.NotEqual(m$.var("KALENDER").get(),"")) {
          if (mOp.NotEqual(TAGTM.get(),"")) {
            do {
              //<< . . IF $DATA(^WWWCAL1(0,KALENDER,TAGTM,1))                                                              WRITE " BGCOLOR=LIGHTBLUE"          QUIT  ;FEIERTAG ;holiday
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWCAL1",0,m$.var("KALENDER").get(),TAGTM.get(),1)))) {
                m$.Cmd.Write(" BGCOLOR=LIGHTBLUE");
                break;
              }
              //<< . . IF $DATA(^WWWCAL1s(0,1,1,$$^WWWUMLAU($EXTRACT(100+A,2,3)_"/"_$EXTRACT(100+MONATX,2,3),1),KALENDER)) WRITE " BGCOLOR=LIGHTBLUE"          QUIT  ;FEIERTAG ;holiday
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWCAL1s",0,1,1,m$.fnc$("WWWUMLAU.main",mOp.Concat(mOp.Concat(m$.Fnc.$extract(mOp.Add(100,A.get()),2,3),"/"),m$.Fnc.$extract(mOp.Add(100,m$.var("MONATX").get()),2,3)),1),m$.var("KALENDER").get())))) {
                m$.Cmd.Write(" BGCOLOR=LIGHTBLUE");
                break;
              }
              //<< . . IF $PIECE($GET(^WWWKALENDER(0,KALENDER,1)),Y,2)=""                                                  WRITE:TAGXE>5 " BGCOLOR=MISTYROSE"  QUIT  ;WOCHENDENDE
              if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWKALENDER",0,m$.var("KALENDER").get(),1)),m$.var("Y").get(),2),"")) {
                if (mOp.Greater(m$.var("TAGXE").get(),5)) {
                  m$.Cmd.Write(" BGCOLOR=MISTYROSE");
                }
                break;
              }
              //<< . . IF '$FIND(";"_$TRANSLATE($PIECE($GET(^WWWKALENDER(0,KALENDER,1)),Y,2),",",";")_";",";"_TAGXE_";")   WRITE " BGCOLOR=MISTYROSE"                ;WOCHENDENDE
              if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(";",m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWKALENDER",0,m$.var("KALENDER").get(),1)),m$.var("Y").get(),2),",",";")),";"),mOp.Concat(mOp.Concat(";",m$.var("TAGXE").get()),";")))) {
                m$.Cmd.Write(" BGCOLOR=MISTYROSE");
              }
            } while (false);
          }
        }
      } while (false);
    }
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< 
    //<< write "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< IF +A'=0 DO
    if (mOp.NotEqual(mOp.Positive(A.get()),0)) {
      //<< . //WRITE "<A onClick='return doLink(this)' HREF=""JavaScript: document."_YHTMFORM_"."_YLFDAT_".value='"_$$^WWWDATE(TAGTM)_"';document."_YHTMFORM_"."_YLFDAT_".focus();"_""""
      //<< . WRITE "<A onClick='return doLink(this)' HREF=""JavaScript: document.getElementById('"_YLFDAT_"').value='"_$$^WWWDATE(TAGTM)_"';document.getElementById('"_YLFDAT_"').focus();"_""""  //SR17431
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A onClick='return doLink(this)' HREF=\"JavaScript: document.getElementById('",m$.var("YLFDAT").get()),"').value='"),m$.fnc$("WWWDATE.main",TAGTM.get())),"';document.getElementById('"),m$.var("YLFDAT").get()),"').focus();"),"\""));
      //<< . IF KALENDER'="" DO
      if (mOp.NotEqual(m$.var("KALENDER").get(),"")) {
        do {
          //<< . . IF +TAGTM'=0 IF $DATA(^WWWCAL1(0,KALENDER,TAGTM,1)) WRITE " TITLE="_""""_$PIECE(^(1),Y,1)_"""" QUIT
          if (mOp.NotEqual(mOp.Positive(TAGTM.get()),0)) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWCAL1",0,m$.var("KALENDER").get(),TAGTM.get(),1)))) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.Fnc.$piece(m$.lastVar(1).get(),m$.var("Y").get(),1)),"\""));
              break;
            }
          }
          //<< . . IF $DATA(^WWWCAL1s(0,1,1,$$^WWWUMLAU($EXTRACT(100+A,2,3)_"/"_$EXTRACT(100+MONATX,2,3),1),KALENDER)) DO
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWCAL1s",0,1,1,m$.fnc$("WWWUMLAU.main",mOp.Concat(mOp.Concat(m$.Fnc.$extract(mOp.Add(100,A.get()),2,3),"/"),m$.Fnc.$extract(mOp.Add(100,m$.var("MONATX").get()),2,3)),1),m$.var("KALENDER").get())))) {
            //<< . . . NEW FTAG
            mVar FTAG = m$.var("FTAG");
            m$.newVarBlock(3,FTAG);
            //<< . . . SET FTAG=$ORDER(^WWWCAL1s(0,1,1,$$^WWWUMLAU($EXTRACT(100+A,2,3)_"/"_$EXTRACT(100+MONATX,2,3),1),KALENDER,""))
            FTAG.set(m$.Fnc.$order(m$.var("^WWWCAL1s",0,1,1,m$.fnc$("WWWUMLAU.main",mOp.Concat(mOp.Concat(m$.Fnc.$extract(mOp.Add(100,A.get()),2,3),"/"),m$.Fnc.$extract(mOp.Add(100,m$.var("MONATX").get()),2,3)),1),m$.var("KALENDER").get(),"")));
            //<< . . . IF FTAG'="" WRITE " TITLE="_""""_$PIECE($GET(^WWWCAL1(0,KALENDER,FTAG,1)),Y,1)_""""
            if (mOp.NotEqual(FTAG.get(),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWCAL1",0,m$.var("KALENDER").get(),FTAG.get(),1)),m$.var("Y").get(),1)),"\""));
            }
          }
          m$.restoreVarBlock(3);
        } while (false);
      }
      //<< . ;
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . IF $LENGTH(A)=1 SET A = "&nbsp;"_A
      if (mOp.Equal(m$.Fnc.$length(A.get()),1)) {
        A.set(mOp.Concat("&nbsp;",A.get()));
      }
      //<< . WRITE "<FONT COLOR=BLACK>"
      m$.Cmd.Write("<FONT COLOR=BLACK>");
      //<< . WRITE A
      m$.Cmd.Write(A.get());
      //<< . WRITE "</FONT></A>"
      m$.Cmd.Write("</FONT></A>");
    }
    //<< 
    //<< WRITE "</FONT>",YCR,"</TD>"
    m$.Cmd.Write("</FONT>",m$.var("YCR").get(),"</TD>");
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< CalendarCellCal2
  public void CalendarCellCal2() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Print table cell with day for WWWCAL2
    //<< ; - Get day of month from array of weeks and days (blanks if no array element)
    //<< ; - Today (* prefix) is yellow; weekends and holidays are pink
    //<< ; - TAGTM is horolog date
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Jun-2010   GRF     SR17146: pass override format "DD.MM.YYYY" to WWWDATE1
    //<< ; 16-May-2007   HeberB  SRBR014457: Copied from WWWCAL2
    //<< ;-------------------------------------------------------------------------------
    //<< SET TAGTM = ""
    mVar TAGTM = m$.var("TAGTM");
    TAGTM.set("");
    //<< SET A     = "&nbsp;&nbsp;&nbsp;"   ; blank spaces prior to or after displayed month
    mVar A = m$.var("A");
    A.set("&nbsp;&nbsp;&nbsp;");
    //<< if $DATA(A(WOCHE,TAGXE)) set A = A(WOCHE,TAGXE)
    if (mOp.Logical(m$.Fnc.$data(A.var(m$.var("WOCHE").get(),m$.var("TAGXE").get())))) {
      A.set(A.var(m$.var("WOCHE").get(),m$.var("TAGXE").get()).get());
    }
    //<< 
    //<< WRITE "<TD ALIGN=CENTER"
    m$.Cmd.Write("<TD ALIGN=CENTER");
    //<< IF +$TRANSLATE(A,"*")'=0 DO
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$translate(A.get(),"*")),0)) {
      do {
        //<< . IF $EXTRACT(A)="*" WRITE " BGCOLOR=LIGHTGOLDENRODYELLOW" QUIT    ; Today
        if (mOp.Equal(m$.Fnc.$extract(A.get()),"*")) {
          m$.Cmd.Write(" BGCOLOR=LIGHTGOLDENRODYELLOW");
          break;
        }
        //<< . ;
        //<< .;SET TAGTM = $$^WWWDATE1($EXTRACT(100+A,2,3)_"."_$EXTRACT(100+MONATX,2,3)_"."_JAHRX)  ; SR17146
        //<< . set TAGTM = $$DMY^WWWDATE1($extract(100+A,2,3)_"."_$extract(100+MONATX,2,3)_"."_JAHRX)
        TAGTM.set(m$.fnc$("WWWDATE1.DMY",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(mOp.Add(100,A.get()),2,3),"."),m$.Fnc.$extract(mOp.Add(100,m$.var("MONATX").get()),2,3)),"."),m$.var("JAHRX").get())));
        //<< . IF YCAL=""  IF TAGTM'="" IF $DATA(^TERMIN9(0,SPRACHE,TAGTM,1)) WRITE " BGCOLOR=MISTYROSE" QUIT
        if (mOp.Equal(m$.var("YCAL").get(),"")) {
          if (mOp.NotEqual(TAGTM.get(),"")) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^TERMIN9",0,m$.var("SPRACHE").get(),TAGTM.get(),1)))) {
              m$.Cmd.Write(" BGCOLOR=MISTYROSE");
              break;
            }
          }
        }
        //<< . IF YCAL=""  IF TAGXE>5                                         WRITE " BGCOLOR=MISTYROSE" QUIT
        if (mOp.Equal(m$.var("YCAL").get(),"")) {
          if (mOp.Greater(m$.var("TAGXE").get(),5)) {
            m$.Cmd.Write(" BGCOLOR=MISTYROSE");
            break;
          }
        }
        //<< . IF YCAL'="" IF TAGTM'="" IF $$^WWWCALDAY(TAGTM,YCAL)'=0        WRITE " BGCOLOR=MISTYROSE"
        if (mOp.NotEqual(m$.var("YCAL").get(),"")) {
          if (mOp.NotEqual(TAGTM.get(),"")) {
            if (mOp.NotEqual(m$.fnc$("WWWCALDAY.main",TAGTM.get(),m$.var("YCAL").get()),0)) {
              m$.Cmd.Write(" BGCOLOR=MISTYROSE");
            }
          }
        }
      } while (false);
    }
    //<< WRITE ">"
    m$.Cmd.Write(">");
    //<< 
    //<< write "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< 
    //<< ; Today
    //<< IF $EXTRACT(A)="*" {   ; FIXME : why $e(A,2,4) rather than $e(A,2,3)?
    if (mOp.Equal(m$.Fnc.$extract(A.get()),"*")) {
      //<< ;   SET TAGTM = $$^WWWDATE1($EXTRACT(100+$EXTRACT(A,2,4),2,3)_"."_$EXTRACT(100+MONATX,2,3)_"."_JAHRX)  ; SR17146
      //<< set TAGTM = $$DMY^WWWDATE1($extract(100+$extract(A,2,4),2,3)_"."_$extract(100+MONATX,2,3)_"."_JAHRX)
      TAGTM.set(m$.fnc$("WWWDATE1.DMY",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(mOp.Add(100,m$.Fnc.$extract(A.get(),2,4)),2,3),"."),m$.Fnc.$extract(mOp.Add(100,m$.var("MONATX").get()),2,3)),"."),m$.var("JAHRX").get())));
      //<< SET A     = $EXTRACT(A,2,4)
      A.set(m$.Fnc.$extract(A.get(),2,4));
    }
    //<< }
    //<< 
    //<< IF +A=0 WRITE "&nbsp;"  ;FIS;15.12.04
    if (mOp.Equal(mOp.Positive(A.get()),0)) {
      m$.Cmd.Write("&nbsp;");
    }
    //<< IF +A'=0 DO
    if (mOp.NotEqual(mOp.Positive(A.get()),0)) {
      //<< . IF YUSERAGENT="MSIE" WRITE "<A HREF="_""""_"#"_""""_" onclick="_""""_"window.returnValue='"_$$^WWWDATE(TAGTM)_"';window.close();"_""""_">"
      if (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),"#"),"\"")," onclick="),"\""),"window.returnValue='"),m$.fnc$("WWWDATE.main",TAGTM.get())),"';window.close();"),"\""),">"));
      }
      //<< . ;WRITE "<A HREF="_""""_"#"_""""_" onclick=""window.returnValue='"_$$^WWWDATE(TAGTM)_"';window.close();"_""""_">"
      //<< . //IF YUSERAGENT'="MSIE" IF $GET(YLFDAT)'="" WRITE "<A onClick='return doLink(this)' HREF=""JavaScript: top.opener.document."_YHTMFORM_"."_YLFDAT_".value='"_$$^WWWDATE(TAGTM)_"'; top.opener.document."_YHTMFORM_"."_YLFDAT_".focus(); top.close(); close();"_""""_">"
      //<< . IF YUSERAGENT'="MSIE" IF $GET(YLFDAT)'="" WRITE "<A onClick='return doLink(this)' HREF=""JavaScript: top.opener.document.getElementById('"_YLFDAT_"').value='"_$$^WWWDATE(TAGTM)_"'; top.opener.document.getElementById('"_YLFDAT_"').focus(); top.close(); close();"_""""_">"  //SR17431
      if (mOp.NotEqual(m$.var("YUSERAGENT").get(),"MSIE")) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YLFDAT")),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A onClick='return doLink(this)' HREF=\"JavaScript: top.opener.document.getElementById('",m$.var("YLFDAT").get()),"').value='"),m$.fnc$("WWWDATE.main",TAGTM.get())),"'; top.opener.document.getElementById('"),m$.var("YLFDAT").get()),"').focus(); top.close(); close();"),"\""),">"));
        }
      }
      //<< . IF $LENGTH(A)=1 SET A="&nbsp;"_A_"&nbsp;"   ;---WEM;02.09.2003;#22960;ADDED LAST &nbsp;
      if (mOp.Equal(m$.Fnc.$length(A.get()),1)) {
        A.set(mOp.Concat(mOp.Concat("&nbsp;",A.get()),"&nbsp;"));
      }
      //<< . WRITE A
      m$.Cmd.Write(A.get());
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< 
    //<< WRITE "</FONT>",YCR,"</TD>"
    m$.Cmd.Write("</FONT>",m$.var("YCR").get(),"</TD>");
    //<< QUIT
    return;
  }

//<< 
//<< 
}
