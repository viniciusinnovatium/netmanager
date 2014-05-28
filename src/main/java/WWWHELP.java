//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWHELP
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:01
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

//<< WWWHELP
public class WWWHELP extends mClass {

  //<< 
  //<< #define TEXTLENGTH  500
  public static Object $$$TEXTLENGTH(mContext m$) {
    return (500);
  }

  //<< #define Store(%row,%col,%fld) set parrFields($select(%row="":" ",$$$YES:%row),$select(%col="":" ",$$$YES:%col),%fld)=""
  public static Object $$$Store(mContext m$, Object ... _p) {
    mVar p$row = m$.varRef("p$row",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$col = m$.varRef("p$col",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$fld = m$.varRef("p$fld",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar parrFields = m$.var("parrFields");
    parrFields.var(m$.Fnc.$select(mOp.Equal(p$row.get(),"")," ",include.COMSYS.$$$YES(m$),p$row.get()),m$.Fnc.$select(mOp.Equal(p$col.get(),"")," ",include.COMSYS.$$$YES(m$),p$col.get()),p$fld.get()).set("");
    return null;
  }

  public void main() {
    _WWWHELP();
  }

  public void _WWWHELP() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Form Help             HILFE ZUM FORMULAR
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
    //<< ; 18-Sep-2008   shobby  BR014966: Support language texts for customisation help text.
    //<< ; 05-Nov-2007   shobby  SRBR014748: Standard routine for password check.
    //<< ; 07-May-2007   GRF     SR15511: Doco
    //<< ; 08-Dec-2006   PO      SR15276: Changed name of EventBroker to JSLibraries
    //<< ; 13-Nov-2006   GM      SRBR014107: Change Customization button to call WWW120D
    //<< ;                           and let form name changes with customisation on
    //<< ;                           Help Screen
    //<< ; 27-Oct-2006   SS      SR14915: Use some macros
    //<< ; 22-Aug-2006   PJ      SRBR014120: When the user's set language isn't English,
    //<< ;                           the help text defaults to English (if English text
    //<< ;                           exists in the database, but the user's language
    //<< ;                           doesn't.) German will still appear if there is
    //<< ;                           neither the user's own language nor English is
    //<< ;                           available.
    //<< ; 26-Jul-2006   JW      SRBR014099: Reverted all changes for build
    //<< ; 20-Jul-2006   GM      SRBR014099: Show hidden fields as greyed in Help Text
    //<< ;                           and field name like administrator and don't show
    //<< ;                           hidden fields in Help Text and field name like user
    //<< ;  2-Jun-2006   JW      SR14697: Always use eventbrokeren1.js
    //<< ;  9-Dec-2005   JW      SR13195: Removed back button. Look at parent user for grid.
    //<< ; 02-Dec-2005   RPW     SR13940: Get YADMIN from CanCustomize call
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 05-May-2005   Paul K  Normalised Directory
    //<< ; 25.01.2000    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< new (%request,%session,%KEY,%,%ZCS,%CGIEVAR,blnEditGridHelp)
    mVar blnEditGridHelp = m$.var("blnEditGridHelp");
    m$.newVarExcept(blnEditGridHelp);
    //<< 
    //<< do ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< 
    //<< if $get(%(YQUERY,"SPRACHE"))'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"SPRACHE")),"")) {
      //<< set SPRACHE = $get(%(YQUERY,"SPRACHE"))
      mVar SPRACHE = m$.var("SPRACHE");
      SPRACHE.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"SPRACHE")));
    }
    //<< }
    //<< ;------------------------------------------------------------------------
    //<< if +$get(YSEITE)=0 set YSEITE = 1
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YSEITE"))),0)) {
      mVar YSEITE = m$.var("YSEITE");
      YSEITE.set(1);
    }
    //<< if YFORM="" set YFORM = $piece(^WWW013(0,YBED,1),Y,12)           ;LETZTES FROMULAR ;last
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      mVar YFORM = m$.var("YFORM");
      YFORM.set(m$.Fnc.$piece(m$.var("^WWW013",0,m$.var("YBED").get(),1).get(),m$.var("Y").get(),12));
    }
    //<< if '$data(^WWW013(0,YBED)) do ^WWWINFO($$^WWWTEXT(5)) quit       ;BERECHTIGUNG
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW013",0,m$.var("YBED").get())))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< if '$$CHECK^WWWPWDCHECK($piece(^WWW013(0,YBED,1),Y,2),YPWD) do ^WWWINFO($$^WWWTEXT(5)) quit   ;PASSWORD
    if (mOp.Not(m$.fnc$("WWWPWDCHECK.CHECK",m$.Fnc.$piece(m$.var("^WWW013",0,m$.var("YBED").get(),1).get(),m$.var("Y").get(),2),m$.var("YPWD").get()))) {
      m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",5));
      return;
    }
    //<< 
    //<< set YADMIN = $$CanCustomize(YBEDBER)
    mVar YADMIN = m$.var("YADMIN");
    YADMIN.set(m$.fnc$("CanCustomize",m$.var("YBEDBER").get()));
    //<< if YADMIN=0 if '$data(^WWW127(0,YFORM)) do ^WWWINFO($$^WWWTEXT(28)) quit  ;KEINE HILFE ;no help
    if (mOp.Equal(YADMIN.get(),0)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW127",0,m$.var("YFORM").get())))) {
        m$.Cmd.Do("WWWINFO.main",m$.fnc$("WWWTEXT.main",28));
        return;
      }
    }
    //<< 
    //<< set YDATEI = $piece($get(^WWW120(0,YFORM,1)),Y,11)   ;DATEI ;data file
    mVar YDATEI = m$.var("YDATEI");
    YDATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),11));
    //<< do ^WWWFORMX  ;VORGABEN AUS MANDANTEN UND FORM ;out of And shape
    m$.Cmd.Do("WWWFORMX.main");
    //<< 
    //<< set $$$WWW120FontFace(YVOR)=$$$WWW012FontFace($get(^WWW012(0,YM,1)))
    include.WWWConst.$$$WWW120FontFaceSet(m$,m$.var("YVOR"),include.WWWConst.$$$WWW012FontFace(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))));
    //<< 
    //<< ;SR14915: Use Macros here
    //<< set $$$WWW120BackgroundColor(YVOR)  = 137       // white
    include.WWWConst.$$$WWW120BackgroundColorSet(m$,m$.var("YVOR"),137);
    //<< set $$$WWW120FrameBodyColor(YVOR)   = 137       // white
    include.WWWConst.$$$WWW120FrameBodyColorSet(m$,m$.var("YVOR"),137);
    //<< set $$$WWW012FrameBodyColor(YVOR1)  = 137       // white
    include.WWWConst.$$$WWW012FrameBodyColorSet(m$,m$.var("YVOR1"),137);
    //<< set $$$WWW120DisplayFrames(YVOR)    = $$$NO     ;KEIN RAHMEN ;no framework
    include.WWWConst.$$$WWW120DisplayFramesSet(m$,m$.var("YVOR"),include.COMSYS.$$$NO(m$));
    //<< 
    //<< set YFOART=$$$WWW120FormType(YVOR)
    mVar YFOART = m$.var("YFOART");
    YFOART.set(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")));
    //<< 
    //<< set KOPF1=$$^WWWUML($$^WWWFORMNAME(YFORM))
    mVar KOPF1 = m$.var("KOPF1");
    KOPF1.set(m$.fnc$("WWWUML.main",m$.fnc$("WWWFORMNAME.main",m$.var("YFORM").get())));
    //<< 
    //<< ;IF $$$WWW120DFormHeaderOrImageFile($GET(^WWW120D(0,YFORM,YM,1)))'="" {      ;BR014107 ;BR014966
    //<< ;   SET KOPF1=$$^WWWUML($$$WWW120DFormHeaderOrImageFile($GET(^WWW120D(0,YFORM,YM,1))))
    //<< ;}
    //<< 
    //<< set KOPF=$$^WWWTEXT(20)_": "_$$$Text(KOPF1) ;BR014966
    mVar KOPF = m$.var("KOPF");
    KOPF.set(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",20),": "),include.COMSYS.$$$Text(m$,KOPF1)));
    //<< 
    //<< do ^WWWSTART(KOPF)
    m$.Cmd.Do("WWWSTART.main",KOPF.get());
    //<< 
    //<< do JSLibraries^WWWFORM8()   // SR14697 // SR15276
    m$.Cmd.Do("WWWFORM8.JSLibraries");
    //<< 
    //<< if $$$WWW012MenuType($get(^WWW012(0,YM,1)))=7 do ^WWWFORM8  ;JAVASCRIPT MIT MENUE ;by means of
    if (mOp.Equal(include.WWWConst.$$$WWW012MenuType(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))),7)) {
      m$.Cmd.Do("WWWFORM8.main");
    }
    //<< do ^WWWBODY(4,"NOPRINT")
    m$.Cmd.Do("WWWBODY.main",4,"NOPRINT");
    //<< write "<FORM NAME=""WWW"" ACTION="""_$piece(YAKTION,"?",1)_""""
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<FORM NAME=\"WWW\" ACTION=\"",m$.Fnc.$piece(m$.var("YAKTION").get(),"?",1)),"\""));
    //<< if +$get(YHYPER)=0 write " Method=POST"
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),0)) {
      m$.Cmd.Write(" Method=POST");
    }
    //<< if +$get(YHYPER)=1 write " Method=POST"
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),1)) {
      m$.Cmd.Write(" Method=POST");
    }
    //<< write ">"
    m$.Cmd.Write(">");
    //<< 
    //<< set $piece(YVOR,Y,9)=$piece($get(^WWW012(0,YM,1)),Y,9)
    m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),9).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),9));
    //<< set $piece(YVOR,Y,5)=$piece($get(^WWW012(0,YM,1)),Y,5)
    m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),5).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),5));
    //<< if $piece(YVOR,Y,10)=1 write "<CENTER>"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),10),1)) {
      m$.Cmd.Write("<CENTER>");
    }
    //<< 
    //<< if $piece(YVOR,Y,10)=1 write "</CENTER>"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),10),1)) {
      m$.Cmd.Write("</CENTER>");
    }
    //<< write YCR,"<TABLE CELLSPACING=0 BORDER=0 NOWRAP><TR><TD"
    m$.Cmd.Write(m$.var("YCR").get(),"<TABLE CELLSPACING=0 BORDER=0 NOWRAP><TR><TD");
    //<< if +$piece(YVOR,Y,45)=1 write " class=""coolButton"""  ;MOUSEEFFECT
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),1)) {
      m$.Cmd.Write(" class=\"coolButton\"");
    }
    //<< write " NOWRAP>"
    m$.Cmd.Write(" NOWRAP>");
    //<< if +$piece(YVOR,Y,45)'=1 write "<FORM>"
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),1)) {
      m$.Cmd.Write("<FORM>");
    }
    //<< set YQ=0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< 
    //<< if +$piece(YVOR,Y,45)'=1 write "</FORM>"
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),1)) {
      m$.Cmd.Write("</FORM>");
    }
    //<< write YCR,"</TD></TR></TABLE>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< if $piece(YVOR,Y,13)=1 do ^WWWFRAME(0) write YCR,"<TR><TD>"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),13),1)) {
      m$.Cmd.Do("WWWFRAME.main",0);
      m$.Cmd.Write(m$.var("YCR").get(),"<TR><TD>");
    }
    //<< 
    //<< set idParentUser = $$$GetParentUser(YUSER)      //SR13195
    mVar idParentUser = m$.var("idParentUser");
    idParentUser.set(include.COMSYSWWW.$$$GetParentUser(m$,m$.var("YUSER")));
    //<< if idParentUser'="" && ($data(^CacheTemp(idParentUser,"Grid","Container"))#10)&&(^CacheTemp(idParentUser,"Grid","Container")=$get(YFORM)) { ; SR11141
    if (mOp.NotEqual(idParentUser.get(),"") && mOp.Logical((mOp.Modulus(m$.Fnc.$data(m$.var("^CacheTemp",idParentUser.get(),"Grid","Container")),10))) && (mOp.Equal(m$.var("^CacheTemp",idParentUser.get(),"Grid","Container").get(),m$.Fnc.$get(m$.var("YFORM"))))) {
      //<< set YNOFOOT=1
      mVar YNOFOOT = m$.var("YNOFOOT");
      YNOFOOT.set(1);
      //<< set blnIncludeGridHelp=$$$YES
      mVar blnIncludeGridHelp = m$.var("blnIncludeGridHelp");
      blnIncludeGridHelp.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< do START
    m$.Cmd.Do("START");
    //<< if $piece(YVOR,Y,13)=1 write YCR,"</TD></TR>" do ^WWWFRAME(1)
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),13),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR>");
      m$.Cmd.Do("WWWFRAME.main",1);
    }
    //<< 
    //<< do ^WWWSTOP
    m$.Cmd.Do("WWWSTOP.main");
    //<< 
    //<< if $get(blnIncludeGridHelp) { ; SR11141
    if (mOp.Logical(m$.Fnc.$get(m$.var("blnIncludeGridHelp")))) {
      //<< kill YNOFOOT
      m$.var("YNOFOOT").kill();
      //<< new strIndex,blnEditGridHelp
      mVar strIndex = m$.var("strIndex");
      m$.newVar(strIndex,blnEditGridHelp);
      //<< set strIndex = ""
      strIndex.set("");
      //<< for {
      for (;true;) {
        //<< set strIndex=$order(%request.Data(strIndex)) quit:strIndex=""
        strIndex.set(m$.Fnc.$order(m$.getRequest().varData(strIndex.get())));
        if (mOp.Equal(strIndex.get(),"")) {
          break;
        }
        //<< if strIndex="YFORM" {
        if (mOp.Equal(strIndex.get(),"YFORM")) {
          //<< set %request.Data(strIndex,1)=^CacheTemp(idParentUser,"Grid","Name")    //SR13195
          m$.getRequest().setData(strIndex.get(),1,m$.var("^CacheTemp",idParentUser.get(),"Grid","Name").get());
        }
        //<< } elseif strIndex="YSEITE" {                               ; SR11348
        else if (mOp.Equal(strIndex.get(),"YSEITE")) {
          //<< set %request.Data(strIndex,1)=1
          m$.getRequest().setData(strIndex.get(),1,1);
        }
      }
      //<< }
      //<< }
      //<< set blnEditGridHelp = $$$YES
      blnEditGridHelp.set(include.COMSYS.$$$YES(m$));
      //<< do WWWHELP
      m$.Cmd.Do("_WWWHELP");
    }
    //<< }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< START ; EINSPRUNG VON AUSSEN MIT YADMIN UND YFORM ;by means of And
  public void START() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 25-May-2011   shobby  SR16925.2: IndividualHelpText->CustomHelpText
    //<< ; 18-Sep-2008   shobby  BR014966: Support language texts for customisation help text.
    //<< ; 17-Sep-2007   SCR     SR15600: Added Call to Event Rule
    //<< ; 20-Jun-2007   RPW     SR15534: Show the (!) is either the name or help text is changed.
    //<< ; 18-Jun-2007   RPW     SR15539: Do not show free fields at all when not required,
    //<< ;                       it was showing the last field entry for each free field.
    //<< ;                       Complete rewrite into { syntax.
    //<< ; 11-May-2007   GM      BR014107: Doing fields number in class WWW120D (5, 7, 120
    //<< ;                       and 121) working in WWW120D form
    //<< ; 08-May-2007   GM      BR014107: Customisation Button on Help Screen go to form WWW120D
    //<< ; 21-Dec-2006   JW      SR14235: Added reference to child windows
    //<< ; 27-Oct-2006   Steve S SR15094: Tab customisation support; Encapsulated
    //<< ;                       function calls
    //<< ; 23-Oct-2006   Steve S SR14915: Go to new help text form; Don't use hyperlinks
    //<< ;                       for fields/keys (done via new form)
    //<< ;                        Use SPRACHE where available, else use WWWLANGU
    //<< ; 28-Aug-2006   HeberB  SRBR014155: Include customized help text for manual input forms
    //<< ; 27-Jul-2006   GM      SRBR014099: Change colour of field name and your help
    //<< ;                       text if it's a hidden field
    //<< ; 11-Nov-2005   JW      SR11904: Child user for popups
    //<< ;  9-Sep-2005   JW      Only call WWWUMLAU once (idxForm)
    //<< ;-------------------------------------------------------------------------------
    //<< new arrFields,idChildUser,idLang,objCust,objCust2,objWWW120D,strHelpText,strName
    mVar arrFields = m$.var("arrFields");
    mVar idChildUser = m$.var("idChildUser");
    mVar idLang = m$.var("idLang");
    mVar objCust = m$.var("objCust");
    mVar objCust2 = m$.var("objCust2");
    mVar objWWW120D = m$.var("objWWW120D");
    mVar strHelpText = m$.var("strHelpText");
    mVar strName = m$.var("strName");
    m$.newVar(arrFields,idChildUser,idLang,objCust,objCust2,objWWW120D,strHelpText,strName);
    //<< 
    //<< set idChildUser = $$GetChildUser^WWWUSER(YUSER)
    idChildUser.set(m$.fnc$("WWWUSER.GetChildUser",m$.var("YUSER").get()));
    //<< 
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< 
    //<< set idLang = $select($get(SPRACHE)="":$$^WWWLANGU(YBED),$$$YES:SPRACHE)
    idLang.set(m$.Fnc.$select(mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),""),m$.fnc$("WWWLANGU.main",m$.var("YBED").get()),include.COMSYS.$$$YES(m$),m$.var("SPRACHE").get()));
    //<< 
    //<< write "<HR COLOR="_YBLUE_">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<HR COLOR=",m$.var("YBLUE").get()),">"));
    //<< 
    //<< if YADMIN=1 {
    if (mOp.Equal(m$.var("YADMIN").get(),1)) {
      //<< write "<A HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM=COMHelp"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=COMHelp"));
      //<< write "&amp;YBED="_YBED_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YBED=",m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()));
      //<< write "&amp;YUSER="_YUSER
      m$.Cmd.Write(mOp.Concat("&amp;YUSER=",m$.var("YUSER").get()));
      //<< write "&amp;FORMULAR="_YFORM
      m$.Cmd.Write(mOp.Concat("&amp;FORMULAR=",m$.var("YFORM").get()));
      //<< write "&amp;ERFASSUNG=M"
      m$.Cmd.Write("&amp;ERFASSUNG=M");
      //<< new BEARB
      mVar BEARB = m$.var("BEARB");
      m$.newVar(BEARB);
      //<< set BEARB=1
      BEARB.set(1);
      //<< if (YFOART=4) || (YFOART=5) if $data(^WWW122(0,YFORM)) set BEARB=0  ;FIS;24611;13.11.03;FREIE FELDER OHNE BUTTON
      if ((mOp.Equal(m$.var("YFOART").get(),4)) || (mOp.Equal(m$.var("YFOART").get(),5))) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
          BEARB.set(0);
        }
      }
      //<< if '$data(^WWW122(0,YFORM,1)) if $translate($get(^WWW127(0,YFORM,"M",1,idLang,1)),Y_" ")'="" set BEARB=1
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get(),1)))) {
        if (mOp.NotEqual(m$.Fnc.$translate(m$.Fnc.$get(m$.var("^WWW127",0,m$.var("YFORM").get(),"M",1,idLang.get(),1)),mOp.Concat(m$.var("Y").get()," ")),"")) {
          BEARB.set(1);
        }
      }
      //<< write "&amp;BEARBEITUNG="_BEARB
      m$.Cmd.Write(mOp.Concat("&amp;BEARBEITUNG=",BEARB.get()));
      //<< write "&amp;SPRACHE="_idLang
      m$.Cmd.Write(mOp.Concat("&amp;SPRACHE=",idLang.get()));
      //<< write "&amp;YFKEY="_YFORM_","_idLang
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YFKEY=",m$.var("YFORM").get()),","),idLang.get()));
      //<< write "&amp;YKEY="_YFORM_","_idLang
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YKEY=",m$.var("YFORM").get()),","),idLang.get()));
      //<< write "&amp;YANZ="_YANZ
      m$.Cmd.Write(mOp.Concat("&amp;YANZ=",m$.var("YANZ").get()));
      //<< write """>"
      m$.Cmd.Write("\">");
    }
    //<< }
    //<< 
    //<< ;
    //<< ;------------------------------------------------------------------------
    //<< new strKOPF1
    mVar strKOPF1 = m$.var("strKOPF1");
    m$.newVar(strKOPF1);
    //<< set strKOPF1=$zconvert(KOPF1,"U")
    strKOPF1.set(m$.Fnc.$zconvert(m$.var("KOPF1").get(),"U"));
    //<< 
    //<< if $find(strKOPF1,".GIF") set KOPF1=""
    if (mOp.Logical(m$.Fnc.$find(strKOPF1.get(),".GIF"))) {
      mVar KOPF1 = m$.var("KOPF1");
      KOPF1.set("");
    }
    //<< if $find(strKOPF1,".JPG") set KOPF1=""
    if (mOp.Logical(m$.Fnc.$find(strKOPF1.get(),".JPG"))) {
      mVar KOPF1 = m$.var("KOPF1");
      KOPF1.set("");
    }
    //<< 
    //<< write "<H2>"
    m$.Cmd.Write("<H2>");
    //<< write KOPF1
    m$.Cmd.Write(m$.var("KOPF1").get());
    //<< write "</H2>"
    m$.Cmd.Write("</H2>");
    //<< 
    //<< if YADMIN=1 write "</A>"
    if (mOp.Equal(m$.var("YADMIN").get(),1)) {
      m$.Cmd.Write("</A>");
    }
    //<< 
    //<< set objWWW120D  = $get(^WWW120D(0,YFORM,YM,1))
    objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",0,m$.var("YFORM").get(),m$.var("YM").get(),1)));
    //<< set strName     = KOPF ;$$$WWW120DFormHeaderOrImageFile(objWWW120D) ;BR014966
    strName.set(m$.var("KOPF").get());
    //<< ;set strHelpText = $$$WWW120DCustomHelpText(objWWW120D)
    //<< set strHelpText = $$CustomHelpText^WWW120D(objWWW120D) ;BR014966 ;SR16925.2
    strHelpText.set(m$.fnc$("WWW120D.CustomHelpText",objWWW120D.get()));
    //<< 
    //<< if +YADMIN'=0 {
    if (mOp.NotEqual(mOp.Positive(m$.var("YADMIN").get()),0)) {
      //<< write "<A"
      m$.Cmd.Write("<A");
      //<< ;IF $PIECE($GET(^WWW121D(0,YFORM,0,YM,1)),Y,5)'="" WRITE " Title="""_$$^WWWTEXT(33417)_""""
      //<< if (strName'="")||(strHelpText'="") write " Title="""_$$^WWWTEXT(33417)_"""" ;BR014107 // SR15534
      if ((mOp.NotEqual(strName.get(),"")) || (mOp.NotEqual(strHelpText.get(),""))) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" Title=\"",m$.fnc$("WWWTEXT.main",33417)),"\""));
      }
      //<< 
      //<< ;   write " HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM=WWW121D"                        ;SR14235
      //<< write " href='' onclick=""subWindow('"_YAKTION_"EP=WWWFORM&amp;YFORM=WWW120D"  ;BR014107
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" href='' onclick=\"subWindow('",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWW120D"));
      //<< write "&amp;YBED="_YBED_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YBED=",m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()));
      //<< write "&amp;YUSER="_idChildUser              ;SR11904
      m$.Cmd.Write(mOp.Concat("&amp;YUSER=",idChildUser.get()));
      //<< write "&amp;SPRACHE="_idLang                 ;SR14915
      m$.Cmd.Write(mOp.Concat("&amp;SPRACHE=",idLang.get()));
      //<< write "&amp;YFKEY="_YFORM_","_YM             ;BR014107
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YFKEY=",m$.var("YFORM").get()),","),m$.var("YM").get()));
      //<< write "&amp;YKEY="_YFORM_","_YM              ;BR014107
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YKEY=",m$.var("YFORM").get()),","),m$.var("YM").get()));
      //<< write "&amp;YANZ="_YANZ
      m$.Cmd.Write(mOp.Concat("&amp;YANZ=",m$.var("YANZ").get()));
      //<< write "','TEILEFRAME1'); return false"">"
      m$.Cmd.Write("','TEILEFRAME1'); return false\">");
      //<< ;   write """ TARGET=TEILEFRAME1>"               ;SR14235
      //<< 
      //<< if (strName'="")||(strHelpText'="") write "&nbsp;<font color="_YRED_">(!)</FONT>" ;BR014107 // SR15534
      if ((mOp.NotEqual(strName.get(),"")) || (mOp.NotEqual(strHelpText.get(),""))) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat("&nbsp;<font color=",m$.var("YRED").get()),">(!)</FONT>"));
      }
      //<< ;IF $PIECE($GET(^WWW121D(0,YFORM,0,YM,1)),Y,5)'="" WRITE "&nbsp;<font color="_YRED_">(!)</FONT>"
      //<< write " <IMG SRC="_YGIF_"dflt.gif border=0 TITLE="_$$^WWWTEXT(33400)_">"         ;Customizing ;FAN ;07.07.03;23923
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" <IMG SRC=",m$.var("YGIF").get()),"dflt.gif border=0 TITLE="),m$.fnc$("WWWTEXT.main",33400)),">"));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< }
    //<< 
    //<< write YCR,"<HR COLOR="_YBLUE_">",YCR
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<HR COLOR=",m$.var("YBLUE").get()),">"),m$.var("YCR").get());
    //<< ;------------------------------------------------------------------------
    //<< if YADMIN=1 do FormLink() //SR15094
    if (mOp.Equal(m$.var("YADMIN").get(),1)) {
      m$.Cmd.Do("FormLink");
    }
    //<< do FormImage()            //SR15094
    m$.Cmd.Do("FormImage");
    //<< ;------------------------------------------------------------------------
    //<< ;  Class / Event Rule Display SR15600
    //<< 
    //<< ;MANUELLE, PRIMAER, LISTENFELDER
    //<< 
    //<< do ShowHelp(idLang,idChildUser)       //SR15539
    m$.Cmd.Do("ShowHelp",idLang.get(),idChildUser.get());
    //<< do DataFields(idLang)                 //SR15539
    m$.Cmd.Do("DataFields",idLang.get());
    //<< write "</FONT>",YCR
    m$.Cmd.Write("</FONT>",m$.var("YCR").get());
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< GetFieldsForPage(pYFORM,pintPage,&parrFields)
  public Object GetFieldsForPage(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintPage = m$.newVarRef("pintPage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar parrFields = m$.newVarRef("parrFields",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return an array of fields (YLFN numbers) for this form page
    //<< ; (takes customisation into account)
    //<< ;
    //<< ; Params:   pYFORM      : The form
    //<< ;           pintPage    : The page number (YSEITE)
    //<< ;
    //<< ; ByRefs:   parrFields  : Array of fields, with their row/col numbers subscripted
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Nov-2006   Steve S SR15094: Customisation ordering for row/col/page
    //<< ; 27-Oct-2006   Steve S SR15094: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idxForm,intRow,intCol,intYLFN,objWWW122,objWWW122D,intCustPage
    mVar idxForm = m$.var("idxForm");
    mVar intRow = m$.var("intRow");
    mVar intCol = m$.var("intCol");
    mVar intYLFN = m$.var("intYLFN");
    mVar objWWW122 = m$.var("objWWW122");
    mVar objWWW122D = m$.var("objWWW122D");
    mVar intCustPage = m$.var("intCustPage");
    m$.newVar(idxForm,intRow,intCol,intYLFN,objWWW122,objWWW122D,intCustPage);
    //<< new intStoreRow,intStoreCol,intCustStoreRow,intCustStoreCol
    mVar intStoreRow = m$.var("intStoreRow");
    mVar intStoreCol = m$.var("intStoreCol");
    mVar intCustStoreRow = m$.var("intCustStoreRow");
    mVar intCustStoreCol = m$.var("intCustStoreCol");
    m$.newVar(intStoreRow,intStoreCol,intCustStoreRow,intCustStoreCol);
    //<< 
    //<< kill parrFields
    parrFields.kill();
    //<< 
    //<< set idxForm = $$$Index(pYFORM)
    idxForm.set(include.MEDConst.$$$Index(m$,pYFORM));
    //<< 
    //<< set intRow=""
    intRow.set("");
    //<< for {
    for (;true;) {
      //<< set intRow=$order(^WWW122s(0,3,idxForm,pintPage,intRow))
      intRow.set(m$.Fnc.$order(m$.var("^WWW122s",0,3,idxForm.get(),pintPage.get(),intRow.get())));
      //<< quit:(intRow="")
      if ((mOp.Equal(intRow.get(),""))) {
        break;
      }
      //<< 
      //<< set intCol=""
      intCol.set("");
      //<< for {
      for (;true;) {
        //<< set intCol=$order(^WWW122s(0,3,idxForm,pintPage,intRow,intCol))
        intCol.set(m$.Fnc.$order(m$.var("^WWW122s",0,3,idxForm.get(),pintPage.get(),intRow.get(),intCol.get())));
        //<< quit:(intCol="")
        if ((mOp.Equal(intCol.get(),""))) {
          break;
        }
        //<< 
        //<< set intYLFN=""
        intYLFN.set("");
        //<< for {
        for (;true;) {
          //<< set intYLFN=$order(^WWW122s(0,3,idxForm,pintPage,intRow,intCol,pYFORM,intYLFN))
          intYLFN.set(m$.Fnc.$order(m$.var("^WWW122s",0,3,idxForm.get(),pintPage.get(),intRow.get(),intCol.get(),pYFORM.get(),intYLFN.get())));
          //<< quit:(intYLFN="")
          if ((mOp.Equal(intYLFN.get(),""))) {
            break;
          }
          //<< 
          //<< set objWWW122 = $get(^WWW122(0,pYFORM,intYLFN,1))
          objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,pYFORM.get(),intYLFN.get(),1)));
          //<< 
          //<< set intStoreRow = $$$WWW122RowPosition(objWWW122)
          intStoreRow.set(include.WWWConst.$$$WWW122RowPosition(m$,objWWW122));
          //<< set intStoreCol = $$$WWW122ColumnPosition(objWWW122)
          intStoreCol.set(include.WWWConst.$$$WWW122ColumnPosition(m$,objWWW122));
          //<< 
          //<< if $data(^WWW122D(0,pYFORM,intYLFN,YM)) { // check customisations
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122D",0,pYFORM.get(),intYLFN.get(),m$.var("YM").get())))) {
            //<< 
            //<< set objWWW122D          = $get(^WWW122D(0,pYFORM,intYLFN,YM,1))
            objWWW122D.set(m$.Fnc.$get(m$.var("^WWW122D",0,pYFORM.get(),intYLFN.get(),m$.var("YM").get(),1)));
            //<< set intCustPage         = $$$WWW122DDisplayOnPage(objWWW122D)
            intCustPage.set(include.WWWConst.$$$WWW122DDisplayOnPage(m$,objWWW122D));
            //<< set intCustStoreRow     = $$$WWW122DLinePosition(objWWW122D)
            intCustStoreRow.set(include.WWWConst.$$$WWW122DLinePosition(m$,objWWW122D));
            //<< set intCustStoreCol     = $$$WWW122DTabulatorPosition(objWWW122D)
            intCustStoreCol.set(include.WWWConst.$$$WWW122DTabulatorPosition(m$,objWWW122D));
            //<< 
            //<< if (intCustPage'="")&&(intCustPage'=pintPage) {
            if ((mOp.NotEqual(intCustPage.get(),"")) && (mOp.NotEqual(intCustPage.get(),pintPage.get()))) {
              //<< continue // not on this page
              continue;
            }
            //<< }
            //<< 
            //<< if (intCustStoreRow'="") set intStoreRow=intCustStoreRow
            if ((mOp.NotEqual(intCustStoreRow.get(),""))) {
              intStoreRow.set(intCustStoreRow.get());
            }
            //<< if (intCustStoreCol'="") set intStoreCol=intCustStoreCol
            if ((mOp.NotEqual(intCustStoreCol.get(),""))) {
              intStoreCol.set(intCustStoreCol.get());
            }
          }
          //<< }
          //<< $$$Store(intStoreRow,intStoreCol,intYLFN)
          $$$Store(m$,intStoreRow,intStoreCol,intYLFN);
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< // Now check for fields which are normally on other pages but have
    //<< // been customised to be on **THIS** page, and add them in.
    //<< 
    //<< set intYLFN=""
    intYLFN.set("");
    //<< for {
    for (;true;) {
      //<< set intYLFN = $order(^WWW122Ds(0,3,pintPage,pYFORM,intYLFN))
      intYLFN.set(m$.Fnc.$order(m$.var("^WWW122Ds",0,3,pintPage.get(),pYFORM.get(),intYLFN.get())));
      //<< quit:(intYLFN="")
      if ((mOp.Equal(intYLFN.get(),""))) {
        break;
      }
      //<< 
      //<< if $data(^WWW122Ds(0,3,pintPage,pYFORM,intYLFN,YM)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122Ds",0,3,pintPage.get(),pYFORM.get(),intYLFN.get(),m$.var("YM").get())))) {
        //<< set objWWW122D = $get(^WWW122D(0,pYFORM,intYLFN,YM,1))
        objWWW122D.set(m$.Fnc.$get(m$.var("^WWW122D",0,pYFORM.get(),intYLFN.get(),m$.var("YM").get(),1)));
        //<< set intStoreRow = $$$WWW122DLinePosition(objWWW122D)
        intStoreRow.set(include.WWWConst.$$$WWW122DLinePosition(m$,objWWW122D));
        //<< set intStoreCol = $$$WWW122DTabulatorPosition(objWWW122D)
        intStoreCol.set(include.WWWConst.$$$WWW122DTabulatorPosition(m$,objWWW122D));
        //<< $$$Store(intStoreRow,intStoreCol,intYLFN)
        $$$Store(m$,intStoreRow,intStoreCol,intYLFN);
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< ShowFieldNameNew(pYFORM,pYLFN,pYLFNN,pYDATEI,pidTab)
  public Object ShowFieldNameNew(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYLFN = m$.newVarRef("pYLFN",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYLFNN = m$.newVarRef("pYLFNN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYDATEI = m$.newVarRef("pYDATEI",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pidTab = m$.newVarRef("pidTab",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the field name
    //<< ;
    //<< ; Params:   pYFORM      : This form
    //<< ;           pYLFN       : This (form) field id
    //<< ;           pYLFNN      : This (class) field id
    //<< ;           pYDATEI     : Corresponding class name.
    //<< ;           pidTab      : Page
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Aug-2007   GM      SRBR014657: Include pidTab as parameter and YM as company
    //<< ; 20-Aug-2007   GM      SRBR014657: In Hidden tabs, field names are shown as
    //<< ;                       gray for System and Database Administrator users
    //<< ; 15-Aug-2007   shobby  SRBR014669: Created (Rewrite of ShowFieldName)
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW122,strFieldName,strType,intField,objWWW003,blnFreeField,objWWW1203D,blnHide
    mVar objWWW122 = m$.var("objWWW122");
    mVar strFieldName = m$.var("strFieldName");
    mVar strType = m$.var("strType");
    mVar intField = m$.var("intField");
    mVar objWWW003 = m$.var("objWWW003");
    mVar blnFreeField = m$.var("blnFreeField");
    mVar objWWW1203D = m$.var("objWWW1203D");
    mVar blnHide = m$.var("blnHide");
    m$.newVar(objWWW122,strFieldName,strType,intField,objWWW003,blnFreeField,objWWW1203D,blnHide);
    //<< 
    //<< set objWWW1203D = $get(^WWW1203D(0,pYFORM,SPRACHE,pidTab,YM,1))
    objWWW1203D.set(m$.Fnc.$get(m$.var("^WWW1203D",0,pYFORM.get(),m$.var("SPRACHE").get(),pidTab.get(),m$.var("YM").get(),1)));
    //<< set blnHide     = $$$WWW1203DHide(objWWW1203D)
    blnHide.set(include.WWWConst.$$$WWW1203DHide(m$,objWWW1203D));
    //<< 
    //<< if (pYDATEI'="") && (pYLFNN'="") {
    if ((mOp.NotEqual(pYDATEI.get(),"")) && (mOp.NotEqual(pYLFNN.get(),""))) {
      //<< set strType   = "D"
      strType.set("D");
      //<< set intField  = pYLFNN
      intField.set(pYLFNN.get());
      //<< set objWWW003 = $get(^WWW003(0,pYDATEI,pYLFNN,1))
      objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,pYDATEI.get(),pYLFNN.get(),1)));
    }
    //<< } else {
    else {
      //<< set strType   = "M"
      strType.set("M");
      //<< set intField  = pYLFN
      intField.set(pYLFN.get());
      //<< set objWWW003 = ""
      objWWW003.set("");
    }
    //<< }
    //<< set objWWW122    = $$Get^WWW122(pYFORM,pYLFN)
    objWWW122.set(m$.fnc$("WWW122.Get",pYFORM.get(),pYLFN.get()));
    //<< set strFieldName = $$^WWWFELDNAME(pYFORM,strType,intField)
    strFieldName.set(m$.fnc$("WWWFELDNAME.main",pYFORM.get(),strType.get(),intField.get()));
    //<< set blnFreeField = $$IsFreeField(strFieldName)
    blnFreeField.set(m$.fnc$("IsFreeField",strFieldName.get()));
    //<< if ($$$WWW122InputType(objWWW122)=0) || blnFreeField || blnHide {   ; Hidden
    if ((mOp.Equal(include.WWWConst.$$$WWW122InputType(m$,objWWW122),0)) || mOp.Logical(blnFreeField.get()) || mOp.Logical(blnHide.get())) {
      //<< if $$CanCustomize(YBEDBER) {
      if (mOp.Logical(m$.fnc$("CanCustomize",m$.var("YBEDBER").get()))) {
        //<< if blnFreeField {
        if (mOp.Logical(blnFreeField.get())) {
          //<< set strFieldName = $$$FREE_" ["_$$$WWW003PropertyName(objWWW003)_"]"
          strFieldName.set(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYS.$$$FREE(m$)," ["),include.WWWConst.$$$WWW003PropertyName(m$,objWWW003)),"]"));
        }
        //<< }
        //<< write "<FONT COLOR=#B6B6B6>"_strFieldName_ "</FONT>"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT COLOR=#B6B6B6>",strFieldName.get()),"</FONT>"));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< write strFieldName
      m$.Cmd.Write(strFieldName.get());
    }
    //<< }
    //<< write "</H4>"
    m$.Cmd.Write("</H4>");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< TextWrapper(pYDATEI="",pYLFNN="",pstrText="",pstrType="D")
  public Object TextWrapper(Object ... _p) {
    mVar pYDATEI = m$.newVarRef("pYDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pYLFNN = m$.newVarRef("pYLFNN",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"D");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the field name
    //<< ;
    //<< ; Params:   pYFORM      : This form
    //<< ;           pYLFN       : This (form) field id
    //<< ;           pstrText    : The text to display
    //<< ;           pstrType    : Field type
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Aug-2007   shobby  SRBR014669: Improved handling of what to do when a
    //<< ;                           free field has no help text written for it
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW003,strHeading
    mVar objWWW003 = m$.var("objWWW003");
    mVar strHeading = m$.var("strHeading");
    m$.newVar(objWWW003,strHeading);
    //<< 
    //<< set pstrText = $$$TRIMWS(pstrText)
    pstrText.set(include.COMSYSString.$$$TRIMWS(m$,pstrText));
    //<< if $translate(pstrText,"|")="" set pstrText = ""
    if (mOp.Equal(m$.Fnc.$translate(pstrText.get(),"|"),"")) {
      pstrText.set("");
    }
    //<< if pstrText="" {
    if (mOp.Equal(pstrText.get(),"")) {
      //<< if ($get(pYDATEI)'="") && ($get(pYLFNN)'="") && (pstrType="D") {
      if ((mOp.NotEqual(m$.Fnc.$get(pYDATEI),"")) && (mOp.NotEqual(m$.Fnc.$get(pYLFNN),"")) && (mOp.Equal(pstrType.get(),"D"))) {
        //<< set objWWW003  = $get(^WWW003(0,pYDATEI,pYLFNN,1))
        objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,pYDATEI.get(),pYLFNN.get(),1)));
        //<< set strHeading = $$$WWW003CaptionInForms(objWWW003)
        strHeading.set(include.WWWConst.$$$WWW003CaptionInForms(m$,objWWW003));
        //<< if $$IsFreeField(strHeading) {
        if (mOp.Logical(m$.fnc$("IsFreeField",strHeading.get()))) {
          //<< set pstrText = "<FONT COLOR=#B6B6B6>"_$$^WWWTEXT("WWW00077")_"</FONT>" ; "A user-configurable data field."
          pstrText.set(mOp.Concat(mOp.Concat("<FONT COLOR=#B6B6B6>",m$.fnc$("WWWTEXT.main","WWW00077")),"</FONT>"));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< if pstrText="" set pstrText = $$^WWWTEXT(28)   ; "No help text available"
    if (mOp.Equal(pstrText.get(),"")) {
      pstrText.set(m$.fnc$("WWWTEXT.main",28));
    }
    //<< quit pstrText
    return pstrText.get();
  }

  //<< 
  //<< IsFreeField(pstrFieldName)
  public Object IsFreeField(Object ... _p) {
    mVar pstrFieldName = m$.newVarRef("pstrFieldName",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines if this is a free field
    //<< ;
    //<< ; Params:   pYFORM      : This form
    //<< ;           pYLFN       : This (form) field id
    //<< ;           pYLFNN      : This (class) field id
    //<< ;           pYDATEI     : Corresponding class name.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Sep-2007   GRF     SRBR014669: "_BLANK" has six letters!
    //<< ; 15-Aug-2007   shobby  SRBR014669: Created (Rewrite of ShowFieldName)
    //<< ;-------------------------------------------------------------------------------
    //<< set pstrFieldName = $extract($$$TRIMWS(pstrFieldName),1,5)
    pstrFieldName.set(m$.Fnc.$extract(include.COMSYSString.$$$TRIMWS(m$,pstrFieldName),1,5));
    //<< quit (pstrFieldName=$$$FREE)||(pstrFieldName="_BLAN")
    return (mOp.Equal(pstrFieldName.get(),include.COMSYS.$$$FREE(m$))) || (mOp.Equal(pstrFieldName.get(),"_BLAN"));
  }

  //<< 
  //<< 
  //<< ShowFieldName(pYFORM,pYLFN,pidTab)
  public Object ShowFieldName(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYLFN = m$.newVarRef("pYLFN",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidTab = m$.newVarRef("pidTab",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; *************************   THIS ROUTINE CAN PROBABLY BE REMOVED IF BR014669 IS OK  **********************
    //<< ; **** Needs to have ShowFieldNameNew called in place of ShowFieldName noting different argument order *****
    //<< ;
    //<< ; NOTE : EXCESSIVE EXIT POINTS - QUITS in IFS (in DISABLED PART OF SUBROUTINE)
    //<< ;
    //<< ; Show the field name
    //<< ;
    //<< ; Params:   pYFORM      : This form
    //<< ;           pYLFN       : This field id
    //<< ;           pidTab      : Page
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Aug-2007   GM      SRBR014657: Include pidTab as parameter
    //<< ; 15-Aug-2007   shobby  SRBR014669: Redirect to ShowFieldNameNew (simplifies and
    //<< ;                       improves a few things)
    //<< ; 14-Aug-2007   GM      SRBR014669: Condition included if field name was customized in WWW122D1
    //<< ; 07-Aug-2007   GM      SRBR014593: Condition included if hidden field in WWW122 was selected
    //<< ; 26-Jun-2007   RPW     SR15539: Show the _FREE property name if not customised
    //<< ; 27-Oct-2006   Steve S SR15094: Created (moved code from START^WWWHELP)
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW122D1,strDesc,objWWW122D,objWWW0031,objWWW1221,objWWW122
    mVar objWWW122D1 = m$.var("objWWW122D1");
    mVar strDesc = m$.var("strDesc");
    mVar objWWW122D = m$.var("objWWW122D");
    mVar objWWW0031 = m$.var("objWWW0031");
    mVar objWWW1221 = m$.var("objWWW1221");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(objWWW122D1,strDesc,objWWW122D,objWWW0031,objWWW1221,objWWW122);
    //<< new objWWW003,strName
    mVar objWWW003 = m$.var("objWWW003");
    mVar strName = m$.var("strName");
    m$.newVar(objWWW003,strName);
    //<< 
    //<< do ShowFieldNameNew(pYFORM,pYLFN,YLFNN,YDATEI,pidTab)
    m$.Cmd.Do("ShowFieldNameNew",pYFORM.get(),pYLFN.get(),m$.var("YLFNN").get(),m$.var("YDATEI").get(),pidTab.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< HideField(pstrForm,pidField)
  public Object HideField(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check if we should show this field on the help text at all.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnHide
    mVar blnHide = m$.var("blnHide");
    m$.newVar(blnHide);
    //<< 
    //<< set blnHide = $$$NO
    blnHide.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if (YADMIN'=1) && (YADMIN'=2) && ($extract($$$WWW122ManualCaption($get(^WWW122(0,pstrForm,pidField,1))),1,5)="_FREE") {
    if ((mOp.NotEqual(m$.var("YADMIN").get(),1)) && (mOp.NotEqual(m$.var("YADMIN").get(),2)) && (mOp.Equal(m$.Fnc.$extract(include.WWWConst.$$$WWW122ManualCaption(m$,m$.Fnc.$get(m$.var("^WWW122",0,pstrForm.get(),pidField.get(),1))),1,5),"_FREE"))) {
      //<< set blnHide=$$$YES
      blnHide.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< quit blnHide
    return blnHide.get();
  }

  //<< 
  //<< 
  //<< ShowCustomiseButton(pYFORM,pYLFN)
  public Object ShowCustomiseButton(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYLFN = m$.newVarRef("pYLFN",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show customise button
    //<< ;
    //<< ; Called By : DataFields
    //<< ;
    //<< ; Params:   pYFORM      : This form
    //<< ;           pYLFN       : Form field id
    //<< ;
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-May-2011   shobby  SR16925.2: IndividualHelpText->CustomHelpText
    //<< ; 15-Aug-2007   shobby  BR014669: Don't show the customisation button if it is
    //<< ;                           hidden in core.  You can't make a hidden button
    //<< ;                           unhidden with customisation.
    //<< ; 07-Aug-2007   GM      BR014593: Included a second condition "YADMIN'=2"
    //<< ; 27-Oct-2006   Steve S SR15094: Created (moved code from START^WWWHELP)
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW122,objWWW122D
    mVar objWWW122 = m$.var("objWWW122");
    mVar objWWW122D = m$.var("objWWW122D");
    m$.newVar(objWWW122,objWWW122D);
    //<< 
    //<< set objWWW122 = $get(^WWW122(0,pYFORM,pYLFN,1))
    objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,pYFORM.get(),pYLFN.get(),1)));
    //<< 
    //<< ;FREIES DATENFELD; free field ;FIS;AUCH FÜR DATA-BASE-ADMIN;13.12.04;26973
    //<< if YADMIN'=1 if YADMIN'=2 if $extract($$$WWW122ManualCaption(objWWW122),1,5)="_FREE" quit    ; *** EARLY EXIT ***
    if (mOp.NotEqual(m$.var("YADMIN").get(),1)) {
      if (mOp.NotEqual(m$.var("YADMIN").get(),2)) {
        if (mOp.Equal(m$.Fnc.$extract(include.WWWConst.$$$WWW122ManualCaption(m$,objWWW122),1,5),"_FREE")) {
          return null;
        }
      }
    }
    //<< 
    //<< set YLFNN = $$$WWW122SequenceNumber(objWWW122)    ; Class Field #
    mVar YLFNN = m$.var("YLFNN");
    YLFNN.set(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122));
    //<< 
    //<< ;NUR HIDDEN FELD NICHT ANZEIGEN ;TYBD;1.11.01 ;only field Not display ;BR014593 ;BR014669
    //<< ;IF YADMIN'=1 IF YADMIN'=2 IF $$$WWW122DataInputType(objWWW122)=15 QUIT
    //<< 
    //<< ;+ + + + + + + + + + + + + + + + + + + +
    //<< ; DEPRECATED? We see "No help text available" instead
    //<< ; FIXME : YI should be "D" since dealing with WWW003 but enters with a value "13" creating
    //<< ;         ^WWW127(0,idForm,13,ClassFieldNo,"DE",1) = Class Data Field Description
    //<< ;             1. use "D"  instead of YM
    //<< ;             2. use "EN" instead of "DE"      <GRF>
    //<< ;+ + + + + + + + + + + + + + + + + + + +
    //<< /*
    //<< ; Initial population of help text with class field definition
    //<< IF (YLFNN'="") && ($GET(^WWW127(0,pYFORM,YI,YLFNN,"DE",1))="") && (YDATEI'="") {
    //<< ;SET ^WWW127(0,pYFORM,YI,YLFNN,"DE",1) = $$$WWW003Description($GET(^WWW003(0,YDATEI,YLFNN,1)))  ;Text from data record
    //<< SET ^WWW127(0,pYFORM,YI,YLFNN,"DE",1) = $$$WWW003Description($GET(^WWW003(0,YDATEI,YLFNN,1)))  ;Text from data record
    //<< }
    //<< */
    //<< ;+ + + + + + + + + + + + + + + + + + + +
    //<< 
    //<< write "<BR>",YCR
    m$.Cmd.Write("<BR>",m$.var("YCR").get());
    //<< write "<H4>"
    m$.Cmd.Write("<H4>");
    //<< if ($$$WWW122InputType(objWWW122)=0) || ($$$WWW122DataInputType(objWWW122)=15) quit    ; *** EARLY EXIT ***   ;BR014669
    if ((mOp.Equal(include.WWWConst.$$$WWW122InputType(m$,objWWW122),0)) || (mOp.Equal(include.WWWConst.$$$WWW122DataInputType(m$,objWWW122),15))) {
      return null;
    }
    //<< 
    //<< set objWWW122D = $get(^WWW122D(0,pYFORM,pYLFN,YM,1))
    objWWW122D.set(m$.Fnc.$get(m$.var("^WWW122D",0,pYFORM.get(),pYLFN.get(),m$.var("YM").get(),1)));
    //<< 
    //<< if +YADMIN'=0 {
    if (mOp.NotEqual(mOp.Positive(m$.var("YADMIN").get()),0)) {
      //<< write "<A"
      m$.Cmd.Write("<A");
      //<< if $$$WWW122DCustomHelpText(objWWW122D)'="" write " Title="""_$$^WWWTEXT(33417)_""""  ; "Location Specific Online-Help"  SR16925
      if (mOp.NotEqual(include.WWWConst.$$$WWW122DCustomHelpText(m$,objWWW122D),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" Title=\"",m$.fnc$("WWWTEXT.main",33417)),"\""));
      }
      //<< 
      //<< write " href='' onclick=""subWindow('"_YAKTION_"EP=WWWFORM&amp;YFORM=WWW122D"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" href='' onclick=\"subWindow('",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWW122D"));
      //<< write "&amp;YBED="_YBED_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YBED=",m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()));
      //<< write "&amp;YUSER="_idChildUser         //SR11904
      m$.Cmd.Write(mOp.Concat("&amp;YUSER=",m$.var("idChildUser").get()));
      //<< write "&amp;SPRACHE="_idLang
      m$.Cmd.Write(mOp.Concat("&amp;SPRACHE=",m$.var("idLang").get()));
      //<< write "&amp;YFKEY="_pYFORM_","_pYLFN_","_YM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YFKEY=",pYFORM.get()),","),pYLFN.get()),","),m$.var("YM").get()));
      //<< write "&amp;YKEY="_pYFORM_","_pYLFN_","_YM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YKEY=",pYFORM.get()),","),pYLFN.get()),","),m$.var("YM").get()));
      //<< write "&amp;YANZ="_YANZ
      m$.Cmd.Write(mOp.Concat("&amp;YANZ=",m$.var("YANZ").get()));
      //<< write "','TEILEFRAME1'); return false"">"
      m$.Cmd.Write("','TEILEFRAME1'); return false\">");
      //<< 
      //<< if $$$WWW122DCustomHelpText(objWWW122D)'="" write "&nbsp;<font color="_YRED_">(!)</FONT>" ;SR16925.2
      if (mOp.NotEqual(include.WWWConst.$$$WWW122DCustomHelpText(m$,objWWW122D),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat("&nbsp;<font color=",m$.var("YRED").get()),">(!)</FONT>"));
      }
      //<< write " <IMG SRC="_YGIF_"dflt.gif border=0 TITLE="_$$^WWWTEXT(33400)_">"         ; "Customizing"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" <IMG SRC=",m$.var("YGIF").get()),"dflt.gif border=0 TITLE="),m$.fnc$("WWWTEXT.main",33400)),">"));
      //<< write "</A>&nbsp;"
      m$.Cmd.Write("</A>&nbsp;");
    }
    //<< }
    //<< 
    //<< ; vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv EFFECTIVELY DISABLED BLOCK
    //<< //IF YADMIN=1 DO
    //<< if $$$NEVER { //SR14915
    if (mOp.Logical(include.COMSYS.$$$NEVER(m$))) {
      //<< write "<A HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM=WWW127"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWW127"));
      //<< write "&amp;YBED="_YBED_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YBED=",m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()));
      //<< write "&amp;YUSER="_YUSER
      m$.Cmd.Write(mOp.Concat("&amp;YUSER=",m$.var("YUSER").get()));
      //<< write "&amp;FORMULAR="_pYFORM
      m$.Cmd.Write(mOp.Concat("&amp;FORMULAR=",pYFORM.get()));
      //<< 
      //<< if YLFNN'="" {
      if (mOp.NotEqual(YLFNN.get(),"")) {
        //<< write "&amp;ERFASSUNG="_YI
        m$.Cmd.Write(mOp.Concat("&amp;ERFASSUNG=",m$.var("YI").get()));
        //<< write "&amp;BEARBEITUNG="_YLFNN
        m$.Cmd.Write(mOp.Concat("&amp;BEARBEITUNG=",YLFNN.get()));
        //<< write "&amp;SPRACHE="_idLang
        m$.Cmd.Write(mOp.Concat("&amp;SPRACHE=",m$.var("idLang").get()));
        //<< write "&amp;YFKEY="_pYFORM_","_YI_","_YLFNN_","_idLang
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YFKEY=",pYFORM.get()),","),m$.var("YI").get()),","),YLFNN.get()),","),m$.var("idLang").get()));
        //<< write "&amp;YKEY="_pYFORM_","_YI_","_YLFNN_","_idLang
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YKEY=",pYFORM.get()),","),m$.var("YI").get()),","),YLFNN.get()),","),m$.var("idLang").get()));
        //<< write "&amp;YANZ="_YANZ
        m$.Cmd.Write(mOp.Concat("&amp;YANZ=",m$.var("YANZ").get()));
      }
      //<< }
      //<< 
      //<< if YLFNN="" {
      if (mOp.Equal(YLFNN.get(),"")) {
        //<< write "&amp;ERFASSUNG=M"
        m$.Cmd.Write("&amp;ERFASSUNG=M");
        //<< write "&amp;BEARBEITUNG="_pYLFN
        m$.Cmd.Write(mOp.Concat("&amp;BEARBEITUNG=",pYLFN.get()));
        //<< write "&amp;SPRACHE="_idLang
        m$.Cmd.Write(mOp.Concat("&amp;SPRACHE=",m$.var("idLang").get()));
        //<< write "&amp;YFKEY="_pYFORM_",M,"_pYLFN_","_idLang
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YFKEY=",pYFORM.get()),",M,"),pYLFN.get()),","),m$.var("idLang").get()));
        //<< write "&amp;YKEY="_pYFORM_",M,"_pYLFN_","_idLang
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YKEY=",pYFORM.get()),",M,"),pYLFN.get()),","),m$.var("idLang").get()));
        //<< write "&amp;YANZ="_YANZ
        m$.Cmd.Write(mOp.Concat("&amp;YANZ=",m$.var("YANZ").get()));
      }
      //<< }
      //<< 
      //<< write """>"
      m$.Cmd.Write("\">");
    }
    //<< }
    //<< ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ EFFECTIVELY DISABLED BLOCK
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< TEXT(pblnColour=$$$NO)
  public Object TEXT(Object ... _p) {
    mVar pblnColour = m$.newVarRef("pblnColour",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   SCHREIBEN TEXT;ACHTUNG AUCH EINSPRUNG AUS WWWHPR ;write Text estimation too out of
    //<< ;       SET YTEXT=TEXT ;table-mat
    //<< ;       DO TEXT^WWWHELP()
    //<< ; Inputs:
    //<< ;   YEDITOR     Boolean
    //<< ;
    //<< ; History:
    //<< ; 18-Mar-2008   GM      SRBR014883: Make appear the pictures of buttons in "WWWHPR" form
    //<< ; 24-Oct-2006   SteveS  SR14915: Display process breaks to show .gifs
    //<< ; 28-Jul-2006   GRF     Fix Bug from 27-Jul-2006: pstrColour is not pblnColour
    //<< ; 27-Jul-2006   GM      SRBR014099: Change colour of help text field using parameter & macros
    //<< ; 16-Jun-2005   RW      Fixed incorrect variable usage which cause images not to
    //<< ;                       appear in help text files.
    //<< ;-------------------------------------------------------------------------------
    //<< new strYINHALT,strPIECEYINHALT,strText
    mVar strYINHALT = m$.var("strYINHALT");
    mVar strPIECEYINHALT = m$.var("strPIECEYINHALT");
    mVar strText = m$.var("strText");
    m$.newVar(strYINHALT,strPIECEYINHALT,strText);
    //<< 
    //<< set YEDITOR = $get(YEDITOR)    ;BEC;23380 KEINE TABELLE BEI EDITOR EINSPRUNG !!! ;no tabulation next to
    mVar YEDITOR = m$.var("YEDITOR");
    YEDITOR.set(m$.Fnc.$get(m$.var("YEDITOR")));
    //<< if YEDITOR'=1 {
    if (mOp.NotEqual(YEDITOR.get(),1)) {
      //<< write YCR,"<TABLE BORDER=0 WIDTH=100%>"
      m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=0 WIDTH=100%>");
      //<< write "<TR>",YCR
      m$.Cmd.Write("<TR>",m$.var("YCR").get());
      //<< if $data(^WWWSOR(YUSER,"WWW042SP")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),"WWW042SP")))) {
        //<< write "<TD WIDTH=7%>"   ;WEM;25131;19.02.2004;ANDERES LAYOUT WENN AUFRUF ÜBER WWW0042SP
        m$.Cmd.Write("<TD WIDTH=7%>");
      }
      //<< } else {
      else {
        //<< write "<TD WIDTH=60>"
        m$.Cmd.Write("<TD WIDTH=60>");
        //<< write "&nbsp;</TD><TD>"
        m$.Cmd.Write("&nbsp;</TD><TD>");
        //<< if pblnColour {
        if (mOp.Logical(pblnColour.get())) {
          //<< write "<FONT SIZE=2 color=#B6B6B6>"
          m$.Cmd.Write("<FONT SIZE=2 color=#B6B6B6>");
        }
        //<< } else {
        else {
          //<< write "<FONT SIZE=2>"
          m$.Cmd.Write("<FONT SIZE=2>");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< ; Process {YGIF} string
    //<< set YTEXT = $$Replace^COMUtilStr(YTEXT,"src=""{YGIF}","src="""_YGIF)
    mVar YTEXT = m$.var("YTEXT");
    YTEXT.set(m$.fnc$("COMUtilStr.Replace",m$.var("YTEXT").get(),"src=\"{YGIF}",mOp.Concat("src=\"",m$.var("YGIF").get())));
    //<< 
    //<< set strText = $piece($piece($piece(YTEXT,Y,1),"<body>",2),"</body>",1)
    strText.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$piece(YTEXT.get(),m$.var("Y").get(),1),"<body>",2),"</body>",1));
    //<< if strText'="" {
    if (mOp.NotEqual(strText.get(),"")) {
      //<< set $piece(YTEXT,Y,1) = strText
      m$.pieceVar(YTEXT,m$.var("Y").get(),1).set(strText.get());
    }
    //<< }
    do {
      //<< 
      //<< do
      //<< . for YI1=1:1 quit:$piece(YTEXT,"|",YI1,999)=""  do
      mVar YI1 = m$.var("YI1");
      for (YI1.set(1);(true);YI1.set(mOp.Add(YI1.get(),1))) {
        if (mOp.Equal(m$.Fnc.$piece(YTEXT.get(),"|",YI1.get(),999),"")) {
          break;
        }
        do {
          //<< . . set YINHALT = $piece(YTEXT,"|",YI1)
          mVar YINHALT = m$.var("YINHALT");
          YINHALT.set(m$.Fnc.$piece(YTEXT.get(),"|",YI1.get()));
          //<< . . if YINHALT'="" if $find(YINHALT,".GIF") || ($find(YINHALT,".gif")) if $extract($reverse($zconvert($translate(YINHALT," "),"U")),1,4)="FIG." do  quit
          if (mOp.NotEqual(YINHALT.get(),"")) {
            if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),".GIF")) || mOp.Logical((m$.Fnc.$find(YINHALT.get(),".gif")))) {
              if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(m$.Fnc.$zconvert(m$.Fnc.$translate(YINHALT.get()," "),"U")),1,4),"FIG.")) {
                //<< . . . new WIDTH
                mVar WIDTH = m$.var("WIDTH");
                m$.newVarBlock(3,WIDTH);
                //<< . . . set WIDTH = ""
                WIDTH.set("");
                //<< . . . set strYINHALT      = $zconvert(YINHALT,"L")
                strYINHALT.set(m$.Fnc.$zconvert(YINHALT.get(),"L"));
                //<< . . . set strPIECEYINHALT = $piece(strYINHALT,".gif/",2)
                strPIECEYINHALT.set(m$.Fnc.$piece(strYINHALT.get(),".gif/",2));
                //<< . . . if strPIECEYINHALT'="" set WIDTH = strPIECEYINHALT set YINHALT=$piece(strYINHALT,".gif/",1)_".gif"
                if (mOp.NotEqual(strPIECEYINHALT.get(),"")) {
                  WIDTH.set(strPIECEYINHALT.get());
                  YINHALT.set(mOp.Concat(m$.Fnc.$piece(strYINHALT.get(),".gif/",1),".gif"));
                }
                //<< . . . if $get(PDF)'=1 write "<CENTER><IMG SRC="""_YGIF_$translate(YINHALT," ")_""""
                if (mOp.NotEqual(m$.Fnc.$get(m$.var("PDF")),1)) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<CENTER><IMG SRC=\"",m$.var("YGIF").get()),m$.Fnc.$translate(YINHALT.get()," ")),"\""));
                }
                //<< . . . if $get(PDF)=1  write "<CENTER><IMG SRC="""_YGIF_$translate(YINHALT," ")_""""  ; FIXME : Same
                if (mOp.Equal(m$.Fnc.$get(m$.var("PDF")),1)) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<CENTER><IMG SRC=\"",m$.var("YGIF").get()),m$.Fnc.$translate(YINHALT.get()," ")),"\""));
                }
                //<< . . . if WIDTH'=""    write " width="_WIDTH
                if (mOp.NotEqual(WIDTH.get(),"")) {
                  m$.Cmd.Write(mOp.Concat(" width=",WIDTH.get()));
                }
                //<< . . . write " TITLE="""_$piece(YINHALT,".",1)_"""></CENTER>"            ;BEC;29.07.03;DAMIT BILDER AUF IM PDF RICHTIG ANGEZEIGT WERDEN ;therewith imagery upon rightly will
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.Fnc.$piece(YINHALT.get(),".",1)),"\"></CENTER>"));
                break;
              }
              m$.restoreVarBlock(3);
            }
          }
          //<< . . ;
          //<< . . if YINHALT'="" if '$find(YINHALT," ") if $find(YINHALT,".AVI") || $find(YINHALT,".avi") do  quit
          if (mOp.NotEqual(YINHALT.get(),"")) {
            if (mOp.Not(m$.Fnc.$find(YINHALT.get()," "))) {
              if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),".AVI")) || mOp.Logical(m$.Fnc.$find(YINHALT.get(),".avi"))) {
                //<< . . . write "<CENTER><IMG DYNSRC="""_YGIF_YINHALT_""" START=mouseover></CENTER>"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<CENTER><IMG DYNSRC=\"",m$.var("YGIF").get()),YINHALT.get()),"\" START=mouseover></CENTER>"));
                break;
              }
            }
          }
          //<< . . ;
          //<< . . if YINHALT'="" if '$find(YINHALT," ") set strYINHALT = $zconvert(YINHALT,"U") if $find(YINHALT,"HTTP://") || $find(strYINHALT,"WWW.") do  quit
          if (mOp.NotEqual(YINHALT.get(),"")) {
            if (mOp.Not(m$.Fnc.$find(YINHALT.get()," "))) {
              strYINHALT.set(m$.Fnc.$zconvert(YINHALT.get(),"U"));
              if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),"HTTP://")) || mOp.Logical(m$.Fnc.$find(strYINHALT.get(),"WWW."))) {
                //<< . . . if '$find(strYINHALT,"HTTP:") set YINHALT = "http://"_YINHALT
                if (mOp.Not(m$.Fnc.$find(strYINHALT.get(),"HTTP:"))) {
                  YINHALT.set(mOp.Concat("http://",YINHALT.get()));
                }
                //<< . . . write "<CENTER><A HREF="_YINHALT_" TARGET=NEUFRAME>"_YINHALT_"</A></CENTER>"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<CENTER><A HREF=",YINHALT.get())," TARGET=NEUFRAME>"),YINHALT.get()),"</A></CENTER>"));
                break;
              }
            }
          }
          //<< . . ;
          //<< . . if YINHALT'="" if '$find(YINHALT," ") set strYINHALT=$zconvert(YINHALT,"U") if $find(strYINHALT,"HYPERLINK:") do  quit
          if (mOp.NotEqual(YINHALT.get(),"")) {
            if (mOp.Not(m$.Fnc.$find(YINHALT.get()," "))) {
              strYINHALT.set(m$.Fnc.$zconvert(YINHALT.get(),"U"));
              if (mOp.Logical(m$.Fnc.$find(strYINHALT.get(),"HYPERLINK:"))) {
                //<< . . . do HYPERLINK
                m$.Cmd.Do("HYPERLINK");
                break;
              }
            }
          }
          //<< . . ;
          //<< . . if YINHALT'="" if '$find(YINHALT," ") if $find(YINHALT,".WAV") || ($find(YINHALT,".WAV")) do  quit
          if (mOp.NotEqual(YINHALT.get(),"")) {
            if (mOp.Not(m$.Fnc.$find(YINHALT.get()," "))) {
              if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),".WAV")) || mOp.Logical((m$.Fnc.$find(YINHALT.get(),".WAV")))) {
                //<< . . . write "<SOUND SRC="""_YGIF_YINHALT_""">"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<SOUND SRC=\"",m$.var("YGIF").get()),YINHALT.get()),"\">"));
                break;
              }
            }
          }
          //<< . . ;
          //<< . . if $get(YCORR)'=1 write YINHALT
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YCORR")),1)) {
            m$.Cmd.Write(YINHALT.get());
          }
          //<< . . ;
          //<< . . if $get(YCORR)=1 for YI2=1:1 quit:$piece(YINHALT," ",YI2,9999)=""  do
          if (mOp.Equal(m$.Fnc.$get(m$.var("YCORR")),1)) {
            mVar YI2 = m$.var("YI2");
            for (YI2.set(1);(true);YI2.set(mOp.Add(YI2.get(),1))) {
              if (mOp.Equal(m$.Fnc.$piece(YINHALT.get()," ",YI2.get(),9999),"")) {
                break;
              }
              //<< . . . new PRUEF
              mVar PRUEF = m$.var("PRUEF");
              m$.newVarBlock(3,PRUEF);
              //<< . . . set PRUEF = $piece(YINHALT," ",YI2)
              PRUEF.set(m$.Fnc.$piece(YINHALT.get()," ",YI2.get()));
              //<< . . . for PRUEF(4)="B","I","U","H1","H2","H3","H4","H5","H6","H7","LI","CENTER","OL","UL"  do
              for (Object _PRUEF$1: new Object[] {"B","I","U","H1","H2","H3","H4","H5","H6","H7","LI","CENTER","OL","UL"}) {
                m$.var("PRUEF",4).set(_PRUEF$1);
                //<< . . . . for PRUEF(3)=$zconvert(PRUEF(4),"U"),$zconvert(PRUEF(4),"L") do
                for (Object _PRUEF$2: new Object[] {m$.Fnc.$zconvert(PRUEF.var(4).get(),"U"),m$.Fnc.$zconvert(PRUEF.var(4).get(),"L")}) {
                  m$.var("PRUEF",3).set(_PRUEF$2);
                  //<< . . . . . if $find(PRUEF,"<"_PRUEF(3)_">")  set PRUEF = $piece(PRUEF,"<"_PRUEF(3)_">",1)_$piece(PRUEF,"<"_PRUEF(3)_">",2)
                  if (mOp.Logical(m$.Fnc.$find(PRUEF.get(),mOp.Concat(mOp.Concat("<",PRUEF.var(3).get()),">")))) {
                    PRUEF.set(mOp.Concat(m$.Fnc.$piece(PRUEF.get(),mOp.Concat(mOp.Concat("<",PRUEF.var(3).get()),">"),1),m$.Fnc.$piece(PRUEF.get(),mOp.Concat(mOp.Concat("<",PRUEF.var(3).get()),">"),2)));
                  }
                  //<< . . . . . if $find(PRUEF,"</"_PRUEF(3)_">") set PRUEF = $piece(PRUEF,"</"_PRUEF(3)_">",1)_$piece(PRUEF,"</"_PRUEF(3)_">",2)
                  if (mOp.Logical(m$.Fnc.$find(PRUEF.get(),mOp.Concat(mOp.Concat("</",PRUEF.var(3).get()),">")))) {
                    PRUEF.set(mOp.Concat(m$.Fnc.$piece(PRUEF.get(),mOp.Concat(mOp.Concat("</",PRUEF.var(3).get()),">"),1),m$.Fnc.$piece(PRUEF.get(),mOp.Concat(mOp.Concat("</",PRUEF.var(3).get()),">"),2)));
                  }
                  //<< . . . . . ;
                  //<< . . . . . if $find(PRUEF,"<"_PRUEF(3)_">")  set PRUEF = $$^WWWTRANSLATE(PRUEF,"<"_PRUEF(3)_">")
                  if (mOp.Logical(m$.Fnc.$find(PRUEF.get(),mOp.Concat(mOp.Concat("<",PRUEF.var(3).get()),">")))) {
                    PRUEF.set(m$.fnc$("WWWTRANSLATE.main",PRUEF.get(),mOp.Concat(mOp.Concat("<",PRUEF.var(3).get()),">")));
                  }
                  //<< . . . . . if $find(PRUEF,"</"_PRUEF(3)_">") set PRUEF = $$^WWWTRANSLATE(PRUEF,"</"_PRUEF(3)_">")
                  if (mOp.Logical(m$.Fnc.$find(PRUEF.get(),mOp.Concat(mOp.Concat("</",PRUEF.var(3).get()),">")))) {
                    PRUEF.set(m$.fnc$("WWWTRANSLATE.main",PRUEF.get(),mOp.Concat(mOp.Concat("</",PRUEF.var(3).get()),">")));
                  }
                }
              }
              //<< . . . ;
              //<< . . . set PRUEF = $translate(PRUEF,"@#$%^®&*_=+<>?-,!'""","                    ")    ;BEC;19.08.04
              PRUEF.set(m$.Fnc.$translate(PRUEF.get(),"@#$%^®&*_=+<>?-,!'\"","                    "));
              //<< . . . set PRUEF = $$^WWWUMLAU(PRUEF,1)
              PRUEF.set(m$.fnc$("WWWUMLAU.main",PRUEF.get(),1));
              //<< . . . if $translate(PRUEF," ,()@#$%^&*_=+<>?/-!")'="" for PRUEF(2)=".",";",",",":"," ","!","" do
              if (mOp.NotEqual(m$.Fnc.$translate(PRUEF.get()," ,()@#$%^&*_=+<>?/-!"),"")) {
                for (Object _PRUEF$1: new Object[] {".",";",",",":"," ","!",""}) {
                  m$.var("PRUEF",2).set(_PRUEF$1);
                  //<< . . . . if $extract($reverse(PRUEF))=PRUEF(2) set PRUEF = $reverse($extract($reverse(PRUEF),2,999))
                  if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(PRUEF.get())),PRUEF.var(2).get())) {
                    PRUEF.set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(PRUEF.get()),2,999)));
                  }
                  //<< . . . . if $extract(PRUEF)=PRUEF(2)           set PRUEF = $extract(PRUEF,2,999)
                  if (mOp.Equal(m$.Fnc.$extract(PRUEF.get()),PRUEF.var(2).get())) {
                    PRUEF.set(m$.Fnc.$extract(PRUEF.get(),2,999));
                  }
                }
              }
              //<< . . . ;
              //<< . . . set PRUEF(1) = 0
              PRUEF.var(1).set(0);
              //<< . . . if $translate(PRUEF," ,()@#$%^&*_=+<>?/-!")'="" do
              if (mOp.NotEqual(m$.Fnc.$translate(PRUEF.get()," ,()@#$%^&*_=+<>?/-!"),"")) {
                //<< . . . . if $length(PRUEF)'>256 if '$data(^WWWDICTIONARY01(0,SPRACHE,PRUEF,1)) do    ; CUST. DIC
                if (mOp.NotGreater(m$.Fnc.$length(PRUEF.get()),256)) {
                  if (mOp.Not(m$.Fnc.$data(m$.var("^WWWDICTIONARY01",0,m$.var("SPRACHE").get(),PRUEF.get(),1)))) {
                    //<< . . . . . if '$data(^WWWDICTIONARY(0,SPRACHE,PRUEF,1)) set PRUEF(1) = 1
                    if (mOp.Not(m$.Fnc.$data(m$.var("^WWWDICTIONARY",0,m$.var("SPRACHE").get(),PRUEF.get(),1)))) {
                      PRUEF.var(1).set(1);
                    }
                  }
                }
                //<< . . . . ;
                //<< . . . . if $length(PRUEF)'>256 if $data(^WWWDICTIONARY(0,SPRACHE,PRUEF_".",1)) || $data(^WWWDICTIONARY(0,SPRACHE,PRUEF_".",1)) set PRUEF(1) = 0     ;FÜR Z.B. , DIE EIN LESTZES "." HAT, DAS GEFILTERT WIRD
                if (mOp.NotGreater(m$.Fnc.$length(PRUEF.get()),256)) {
                  if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDICTIONARY",0,m$.var("SPRACHE").get(),mOp.Concat(PRUEF.get(),"."),1))) || mOp.Logical(m$.Fnc.$data(m$.var("^WWWDICTIONARY",0,m$.var("SPRACHE").get(),mOp.Concat(PRUEF.get(),"."),1)))) {
                    PRUEF.var(1).set(0);
                  }
                }
                //<< . . . . if $piece(YINHALT," ",YI2)=$zconvert($piece(YINHALT," ",YI2),"U")    set PRUEF(1) = 0   ;KEINE EIGENNAMEN WIE INTRAPREND ;no such as
                if (mOp.Equal(m$.Fnc.$piece(YINHALT.get()," ",YI2.get()),m$.Fnc.$zconvert(m$.Fnc.$piece(YINHALT.get()," ",YI2.get()),"U"))) {
                  PRUEF.var(1).set(0);
                }
                //<< . . . . if +PRUEF=PRUEF set PRUEF(1) = 0        ;KEINE ZAHLEN PRÜFEN ;no check
                if (mOp.Equal(mOp.Positive(PRUEF.get()),PRUEF.get())) {
                  PRUEF.var(1).set(0);
                }
              }
              //<< . . . ;
              //<< . . . if PRUEF(1)=1 write "<em style='border-bottom:1px dashed red; font-style:normal;'>"
              if (mOp.Equal(PRUEF.var(1).get(),1)) {
                m$.Cmd.Write("<em style='border-bottom:1px dashed red; font-style:normal;'>");
              }
              //<< . . . ;
              //<< . . . if PRUEF(1)=1 do
              if (mOp.Equal(PRUEF.var(1).get(),1)) {
                //<< . . . . new YKEY,WORD
                mVar YKEY = m$.var("YKEY");
                mVar WORD = m$.var("WORD");
                m$.newVarBlock(4,YKEY,WORD);
                //<< . . . . write YCR,"<A HREF=""#"""
                m$.Cmd.Write(m$.var("YCR").get(),"<A HREF=\"#\"");
                //<< . . . . set WORD=$translate($piece(YINHALT," ",YI2),",'^()""")
                WORD.set(m$.Fnc.$translate(m$.Fnc.$piece(YINHALT.get()," ",YI2.get()),",'^()\""));
                //<< . . . . for PRUEF(4)="B","I","U","H1","H2","H3","H4","H5","H6","H7","LI","CENTER","OL","UL"  do
                for (Object _PRUEF$1: new Object[] {"B","I","U","H1","H2","H3","H4","H5","H6","H7","LI","CENTER","OL","UL"}) {
                  m$.var("PRUEF",4).set(_PRUEF$1);
                  //<< . . . . . for PRUEF(3)=$zconvert(PRUEF(4),"U"),$zconvert(PRUEF(4),"L") do
                  for (Object _PRUEF$2: new Object[] {m$.Fnc.$zconvert(PRUEF.var(4).get(),"U"),m$.Fnc.$zconvert(PRUEF.var(4).get(),"L")}) {
                    m$.var("PRUEF",3).set(_PRUEF$2);
                    //<< . . . . . . if $find(WORD,"<"_PRUEF(3)_">")  set WORD  = $piece(WORD,"<"_PRUEF(3)_">",1)_$piece(WORD,"<"_PRUEF(3)_">",2)
                    if (mOp.Logical(m$.Fnc.$find(WORD.get(),mOp.Concat(mOp.Concat("<",PRUEF.var(3).get()),">")))) {
                      WORD.set(mOp.Concat(m$.Fnc.$piece(WORD.get(),mOp.Concat(mOp.Concat("<",PRUEF.var(3).get()),">"),1),m$.Fnc.$piece(WORD.get(),mOp.Concat(mOp.Concat("<",PRUEF.var(3).get()),">"),2)));
                    }
                    //<< . . . . . . if $find(WORD,"</"_PRUEF(3)_">") set PRUEF = $piece(WORD,"</"_PRUEF(3)_">",1)_$piece(WORD,"</"_PRUEF(3)_">",2)
                    if (mOp.Logical(m$.Fnc.$find(WORD.get(),mOp.Concat(mOp.Concat("</",PRUEF.var(3).get()),">")))) {
                      PRUEF.set(mOp.Concat(m$.Fnc.$piece(WORD.get(),mOp.Concat(mOp.Concat("</",PRUEF.var(3).get()),">"),1),m$.Fnc.$piece(WORD.get(),mOp.Concat(mOp.Concat("</",PRUEF.var(3).get()),">"),2)));
                    }
                    //<< . . . . . . ;
                    //<< . . . . . . if $find(WORD,"<"_PRUEF(3)_">")  set WORD = $$^WWWTRANSLATE(WORD,"<"_PRUEF(3)_">")
                    if (mOp.Logical(m$.Fnc.$find(WORD.get(),mOp.Concat(mOp.Concat("<",PRUEF.var(3).get()),">")))) {
                      WORD.set(m$.fnc$("WWWTRANSLATE.main",WORD.get(),mOp.Concat(mOp.Concat("<",PRUEF.var(3).get()),">")));
                    }
                    //<< . . . . . . if $find(WORD,"</"_PRUEF(3)_">") set WORD = $$^WWWTRANSLATE(WORD,"</"_PRUEF(3)_">")
                    if (mOp.Logical(m$.Fnc.$find(WORD.get(),mOp.Concat(mOp.Concat("</",PRUEF.var(3).get()),">")))) {
                      WORD.set(m$.fnc$("WWWTRANSLATE.main",WORD.get(),mOp.Concat(mOp.Concat("</",PRUEF.var(3).get()),">")));
                    }
                  }
                }
                //<< . . . . ;
                //<< . . . . if $length(WORD,".")>1 if $extract($reverse(WORD))="." set WORD = $reverse($extract($reverse(WORD),2,999))
                if (mOp.Greater(m$.Fnc.$length(WORD.get(),"."),1)) {
                  if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(WORD.get())),".")) {
                    WORD.set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(WORD.get()),2,999)));
                  }
                }
                //<< . . . . write " onClick='if (confirm(""\"""_WORD_"\"" "_$$^WWWTEXT(33954)_""")) retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"",""WWWDICTIONARY2"","""",""6"","""_WORD_""");'"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onClick='if (confirm(\"\\\"",WORD.get()),"\\\" "),m$.fnc$("WWWTEXT.main",33954)),"\")) retval = EventValue(\""),m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX\",\"WWWDICTIONARY2\",\"\",\"6\",\""),WORD.get()),"\");'"));
                //<< . . . . write YCR," TITLE="""_$$^WWWTEXT(33954,,1)_""""   ; "Save Unknown Word in Directory"
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWTEXT.main",33954,null,1)),"\""));
                //<< . . . . write YCR,">"
                m$.Cmd.Write(m$.var("YCR").get(),">");
              }
              m$.restoreVarBlock(4);
              //<< . . . ;
              //<< . . . write YCR,$$^WWWUML($piece(YINHALT," ",YI2),1)
              m$.Cmd.Write(m$.var("YCR").get(),m$.fnc$("WWWUML.main",m$.Fnc.$piece(YINHALT.get()," ",YI2.get()),1));
              //<< . . . if PRUEF(1)=1 write YCR,"</A>"
              if (mOp.Equal(PRUEF.var(1).get(),1)) {
                m$.Cmd.Write(m$.var("YCR").get(),"</A>");
              }
              //<< . . . ;
              //<< . . . if PRUEF(1)=1 write YCR,"</em>"
              if (mOp.Equal(PRUEF.var(1).get(),1)) {
                m$.Cmd.Write(m$.var("YCR").get(),"</em>");
              }
              //<< . . . write " "
              m$.Cmd.Write(" ");
            }
            m$.restoreVarBlock(3);
          }
          //<< . . ;
          //<< . . write "<BR>",YCR
          m$.Cmd.Write("<BR>",m$.var("YCR").get());
        } while (false);
      }
    } while(false);
    //<< 
    //<< if YEDITOR'=1 {
    if (mOp.NotEqual(YEDITOR.get(),1)) {
      //<< write "</TD>",YCR
      m$.Cmd.Write("</TD>",m$.var("YCR").get());
      //<< write "</TR>",YCR
      m$.Cmd.Write("</TR>",m$.var("YCR").get());
      //<< write "</TABLE>"
      m$.Cmd.Write("</TABLE>");
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< HYPERLINK ;EINFÜGEN LINK ;interpolate
  public void HYPERLINK() {
    //<< new YHKEY,YHFORM,YHTEXT,YHTITLE,YHBACK
    mVar YHKEY = m$.var("YHKEY");
    mVar YHFORM = m$.var("YHFORM");
    mVar YHTEXT = m$.var("YHTEXT");
    mVar YHTITLE = m$.var("YHTITLE");
    mVar YHBACK = m$.var("YHBACK");
    m$.newVar(YHKEY,YHFORM,YHTEXT,YHTITLE,YHBACK);
    //<< 
    //<< set YHTEXT  = $piece(YINHALT,":",2)
    YHTEXT.set(m$.Fnc.$piece(m$.var("YINHALT").get(),":",2));
    //<< set YHFORM  = $piece(YINHALT,":",3)    if $extract(YHFORM)="@"  set YHFORM  = @($extract(YHFORM,2,99))
    YHFORM.set(m$.Fnc.$piece(m$.var("YINHALT").get(),":",3));
    if (mOp.Equal(m$.Fnc.$extract(YHFORM.get()),"@")) {
      YHFORM.set(m$.indirectVar((m$.Fnc.$extract(YHFORM.get(),2,99))).get());
    }
    //<< set YHKEY   = $piece(YINHALT,":",4)    if $extract(YHKEY)="@"   set YHKEY   = @($extract(YHKEY,2,99))
    YHKEY.set(m$.Fnc.$piece(m$.var("YINHALT").get(),":",4));
    if (mOp.Equal(m$.Fnc.$extract(YHKEY.get()),"@")) {
      YHKEY.set(m$.indirectVar((m$.Fnc.$extract(YHKEY.get(),2,99))).get());
    }
    //<< set YHTITLE = $piece(YINHALT,":",5)    if $extract(YHTITLE)="@" set YHTITLE = @($extract(YHTITLE,2,99))
    YHTITLE.set(m$.Fnc.$piece(m$.var("YINHALT").get(),":",5));
    if (mOp.Equal(m$.Fnc.$extract(YHTITLE.get()),"@")) {
      YHTITLE.set(m$.indirectVar((m$.Fnc.$extract(YHTITLE.get(),2,99))).get());
    }
    //<< set YHBACK  = YFORM
    YHBACK.set(m$.var("YFORM").get());
    //<< 
    //<< quit:YHFORM=""
    if (mOp.Equal(YHFORM.get(),"")) {
      return;
    }
    //<< quit:'$data(^WWW120(0,YHFORM))
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW120",0,YHFORM.get())))) {
      return;
    }
    do {
      //<< 
      //<< do
      //<< . new YKEY,YFORM,YBACK
      mVar YKEY = m$.var("YKEY");
      mVar YFORM = m$.var("YFORM");
      mVar YBACK = m$.var("YBACK");
      m$.newVarBlock(1,YKEY,YFORM,YBACK);
      //<< . write "<A HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YHFORM_"&amp;YKEY="_YHKEY  ;_"&amp;YBACK="_YHBACK_","
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),YHFORM.get()),"&amp;YKEY="),YHKEY.get()));
      //<< . do ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< . write """"
      m$.Cmd.Write("\"");
      //<< . if YHTITLE'="" write " TITLE="""_YHTITLE_""""
      if (mOp.NotEqual(YHTITLE.get(),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",YHTITLE.get()),"\""));
      }
      //<< . write ">"
      m$.Cmd.Write(">");
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< write "<U>"_$get(YHTEXT)_"</U>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<U>",m$.Fnc.$get(YHTEXT)),"</U>"));
    //<< write "</A>",YCR
    m$.Cmd.Write("</A>",m$.var("YCR").get());
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< BUTTON()
  public Object BUTTON(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Print button help text
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Jul-2007   Karine  SRBR014589: Show customized name of buttons if exists.
    //<< ; 20-Jun-2007   RPW     SR15539: Created (rewritten from . syntax)
    //<< ;-------------------------------------------------------------------------------
    //<< new intPosition,objButton,idButton,idxForm,idxLang,strPicture,strDesc
    mVar intPosition = m$.var("intPosition");
    mVar objButton = m$.var("objButton");
    mVar idButton = m$.var("idButton");
    mVar idxForm = m$.var("idxForm");
    mVar idxLang = m$.var("idxLang");
    mVar strPicture = m$.var("strPicture");
    mVar strDesc = m$.var("strDesc");
    m$.newVar(intPosition,objButton,idButton,idxForm,idxLang,strPicture,strDesc);
    //<< 
    //<< ; "In addition to the standard-buttons this form contains buttons to link into the following functions:"
    //<< if $data(^WWW124(0,YFORM,SPRACHE)) set YTEXT="|<b>"_$$^WWWTEXT(33862)_"</b>" do TEXT($$$NO)
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW124",0,m$.var("YFORM").get(),m$.var("SPRACHE").get())))) {
      mVar YTEXT = m$.var("YTEXT");
      YTEXT.set(mOp.Concat(mOp.Concat("|<b>",m$.fnc$("WWWTEXT.main",33862)),"</b>"));
      m$.Cmd.Do("TEXT",include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< set idxForm = $$$Index(YFORM)
    idxForm.set(include.MEDConst.$$$Index(m$,m$.var("YFORM")));
    //<< set idxLang = $$$Index(SPRACHE)
    idxLang.set(include.MEDConst.$$$Index(m$,m$.var("SPRACHE")));
    //<< 
    //<< set intPosition = ""
    intPosition.set("");
    //<< for {
    for (;true;) {
      //<< set intPosition = $order(^WWW124s(0,2,idxForm,idxLang,intPosition))
      intPosition.set(m$.Fnc.$order(m$.var("^WWW124s",0,2,idxForm.get(),idxLang.get(),intPosition.get())));
      //<< quit:intPosition=""
      if (mOp.Equal(intPosition.get(),"")) {
        break;
      }
      //<< 
      //<< set idButton = ""
      idButton.set("");
      //<< for {
      for (;true;) {
        //<< set idButton = $order(^WWW124s(0,2,idxForm,idxLang,intPosition,YFORM,SPRACHE,idButton))
        idButton.set(m$.Fnc.$order(m$.var("^WWW124s",0,2,idxForm.get(),idxLang.get(),intPosition.get(),m$.var("YFORM").get(),m$.var("SPRACHE").get(),idButton.get())));
        //<< quit:idButton=""
        if (mOp.Equal(idButton.get(),"")) {
          break;
        }
        //<< 
        //<< set objButton  = $get(^WWW124(0,YFORM,SPRACHE,idButton,1))
        objButton.set(m$.Fnc.$get(m$.var("^WWW124",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),idButton.get(),1)));
        //<< set strPicture = $$$WWW124PictureFileOnButton(objButton)
        strPicture.set(include.WWWConst.$$$WWW124PictureFileOnButton(m$,objButton));
        //<< set strDesc    = $$GetButtonDescription^WWW124(YFORM,SPRACHE,idButton)
        strDesc.set(m$.fnc$("WWW124.GetButtonDescription",m$.var("YFORM").get(),m$.var("SPRACHE").get(),idButton.get()));
        //<< 
        //<< if strPicture="" set strPicture = $$$LOWER($extract(strDesc))_".gif"
        if (mOp.Equal(strPicture.get(),"")) {
          strPicture.set(mOp.Concat(include.COMSYSString.$$$LOWER(m$,m$.Fnc.$extract(strDesc.get())),".gif"));
        }
        //<< set YTEXT = strPicture_"|<U><B>"_$$^WWWUML(strDesc)_"</B></U>|"
        mVar YTEXT = m$.var("YTEXT");
        YTEXT.set(mOp.Concat(mOp.Concat(mOp.Concat(strPicture.get(),"|<U><B>"),m$.fnc$("WWWUML.main",strDesc.get())),"</B></U>|"));
        //<< 
        //<< do DrawButton(objButton)
        m$.Cmd.Do("DrawButton",objButton.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DrawButton(pobjButton)
  public Object DrawButton(Object ... _p) {
    mVar pobjButton = m$.newVarRef("pobjButton",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Draw the button info onto the screen
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHelp,strNewForm,strText
    mVar strHelp = m$.var("strHelp");
    mVar strNewForm = m$.var("strNewForm");
    mVar strText = m$.var("strText");
    m$.newVar(strHelp,strNewForm,strText);
    //<< 
    //<< set strText    = ""
    strText.set("");
    //<< set strNewForm = $$$WWW124NewFormOnClick(pobjButton)
    strNewForm.set(include.WWWConst.$$$WWW124NewFormOnClick(m$,pobjButton));
    //<< 
    //<< if strNewForm'="" {
    if (mOp.NotEqual(strNewForm.get(),"")) {
      //<< set strText = $$$WWW127HelpText($get(^WWW127(0,strNewForm,"M",0,SPRACHE,1)))
      strText.set(include.WWWConst.$$$WWW127HelpText(m$,m$.Fnc.$get(m$.var("^WWW127",0,strNewForm.get(),"M",0,m$.var("SPRACHE").get(),1))));
      //<< if strText="" set strText = $$$WWW127HelpText($get(^WWW127(0,strNewForm,"M",1,SPRACHE,1)))
      if (mOp.Equal(strText.get(),"")) {
        strText.set(include.WWWConst.$$$WWW127HelpText(m$,m$.Fnc.$get(m$.var("^WWW127",0,strNewForm.get(),"M",1,m$.var("SPRACHE").get(),1))));
      }
    }
    //<< }
    //<< 
    //<< set strText = $piece(strText,"</B>",1)
    strText.set(m$.Fnc.$piece(strText.get(),"</B>",1));
    //<< set strText = $piece(strText,"</b>",1)
    strText.set(m$.Fnc.$piece(strText.get(),"</b>",1));
    //<< 
    //<< if $length(strText)>$$$TEXTLENGTH set strText=$extract(strText,0,$$$TEXTLENGTH)
    if (mOp.Greater(m$.Fnc.$length(strText.get()),$$$TEXTLENGTH(m$))) {
      strText.set(m$.Fnc.$extract(strText.get(),0,$$$TEXTLENGTH(m$)));
    }
    //<< if $translate(strText," ")'="" set YTEXT = YTEXT_strText
    if (mOp.NotEqual(m$.Fnc.$translate(strText.get()," "),"")) {
      mVar YTEXT = m$.var("YTEXT");
      YTEXT.set(mOp.Concat(m$.var("YTEXT").get(),strText.get()));
    }
    //<< set strHelp = $$$WWW124Hilfe(pobjButton)
    strHelp.set(include.WWWConst.$$$WWW124Hilfe(m$,pobjButton));
    //<< if strHelp'="" set:YTEXT'="" YTEXT = YTEXT_" " set YTEXT = YTEXT_strHelp
    if (mOp.NotEqual(strHelp.get(),"")) {
      if (mOp.NotEqual(m$.var("YTEXT").get(),"")) {
        m$.var("YTEXT").set(mOp.Concat(m$.var("YTEXT").get()," "));
      }
      mVar YTEXT = m$.var("YTEXT");
      YTEXT.set(mOp.Concat(m$.var("YTEXT").get(),strHelp.get()));
    }
    //<< if $length(YTEXT)>10 {
    if (mOp.Greater(m$.Fnc.$length(m$.var("YTEXT").get()),10)) {
      //<< if '$find(YTEXT,"Assistance Text") && '$find(YTEXT,"Help Text") {
      if (mOp.Not(m$.Fnc.$find(m$.var("YTEXT").get(),"Assistance Text")) && mOp.Not(m$.Fnc.$find(m$.var("YTEXT").get(),"Help Text"))) {
        //<< set YTEXT = "|"_YTEXT
        mVar YTEXT = m$.var("YTEXT");
        YTEXT.set(mOp.Concat("|",m$.var("YTEXT").get()));
        //<< do TEXT($$$NO)
        m$.Cmd.Do("TEXT",include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CanCustomize(pintBEDBER,&pblnCanCustomize)
  public Object CanCustomize(Object ... _p) {
    mVar pintBEDBER = m$.newVarRef("pintBEDBER",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnCanCustomize = m$.newVarRef("pblnCanCustomize",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;/*-------------------------------------------------------------------------------
    //<< ; If the user is an Administrator or DB Administrator then they can customize.
    //<< ;
    //<< ; Let the user know which level they are and the fact they can customize
    //<< ;
    //<< ; Params:
    //<< ; pintBEDBER      : The security level of the user
    //<< ; pblnCanCustomize: Whether this user can customize the form.
    //<< ;
    //<< ; Returns:
    //<< ; 0 - Can not customize
    //<< ; 1 - Can Customize and is the System Administrator
    //<< ; 2 - Can Customize and is the DB Administrator
    //<< ;
    //<< ; History:
    //<< ; 02-Dec-2005   RPW     SR13940: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< new intAdmin
    mVar intAdmin = m$.var("intAdmin");
    m$.newVar(intAdmin);
    //<< 
    //<< set intAdmin = 0
    intAdmin.set(0);
    //<< if +pintBEDBER=1 set intAdmin = 1   ;SYSTEM ADMINISTRATOR
    if (mOp.Equal(mOp.Positive(pintBEDBER.get()),1)) {
      intAdmin.set(1);
    }
    //<< if +pintBEDBER=2 set intAdmin = 2   ;DATABASE ADMINISTRATOR
    if (mOp.Equal(mOp.Positive(pintBEDBER.get()),2)) {
      intAdmin.set(2);
    }
    //<< 
    //<< set pblnCanCustomize = (intAdmin'=0)
    pblnCanCustomize.set((mOp.NotEqual(intAdmin.get(),0)));
    //<< 
    //<< quit intAdmin
    return intAdmin.get();
  }

  //<< 
  //<< 
  //<< FormLink()
  public Object FormLink(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Write out the class/form link
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Oct-2006   SteveS  SR15094: Created (moved from START^WWWHELP)
    //<< ;-------------------------------------------------------------------------------
    //<< new YKEY,YFKEY,idClass
    mVar YKEY = m$.var("YKEY");
    mVar YFKEY = m$.var("YFKEY");
    mVar idClass = m$.var("idClass");
    m$.newVar(YKEY,YFKEY,idClass);
    //<< 
    //<< write YCR,"<TABLE CELLSPACING=0 BORDER=0>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TABLE CELLSPACING=0 BORDER=0>");
    //<< write "<TR>"
    m$.Cmd.Write("<TR>");
    //<< write "<TD ALIGN=RIGHT width=100></TD>"
    m$.Cmd.Write("<TD ALIGN=RIGHT width=100></TD>");
    //<< 
    //<< write "<TD ALIGN=RIGHT width=200>"
    m$.Cmd.Write("<TD ALIGN=RIGHT width=200>");
    //<< write "Form-Name: "
    m$.Cmd.Write("Form-Name: ");
    //<< write "</TD>"
    m$.Cmd.Write("</TD>");
    //<< 
    //<< write "<TD><A HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM=WWW120&amp;YKEY="_YFORM
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<TD><A HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWW120&amp;YKEY="),m$.var("YFORM").get()));
    //<< do ^WWWCGI
    m$.Cmd.Do("WWWCGI.main");
    //<< write """>"
    m$.Cmd.Write("\">");
    //<< write YFORM
    m$.Cmd.Write(m$.var("YFORM").get());
    //<< write "</A>",YCR
    m$.Cmd.Write("</A>",m$.var("YCR").get());
    //<< write "<BR>"
    m$.Cmd.Write("<BR>");
    //<< write "</TD></TR>"
    m$.Cmd.Write("</TD></TR>");
    //<< 
    //<< set idClass = $$$WWW120ClassUsedInForm(YVOR)
    idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.var("YVOR")));
    //<< 
    //<< if (idClass'="") {
    if ((mOp.NotEqual(idClass.get(),""))) {
      //<< write "<TR><TD ALIGN=RIGHT width=100></TD><TD ALIGN=RIGHT width=200>"
      m$.Cmd.Write("<TR><TD ALIGN=RIGHT width=100></TD><TD ALIGN=RIGHT width=200>");
      //<< write "Class-Name: "
      m$.Cmd.Write("Class-Name: ");
      //<< write "</TD>"
      m$.Cmd.Write("</TD>");
      //<< 
      //<< write "<TD><A HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM=WWW001&amp;YKEY="_idClass
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<TD><A HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWW001&amp;YKEY="),idClass.get()));
      //<< do ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< write """>"
      m$.Cmd.Write("\">");
      //<< write idClass
      m$.Cmd.Write(idClass.get());
      //<< write "</A>",YCR
      m$.Cmd.Write("</A>",m$.var("YCR").get());
      //<< write "<BR>"
      m$.Cmd.Write("<BR>");
      //<< write "</TD></TR>"
      m$.Cmd.Write("</TD></TR>");
    }
    //<< }
    //<< 
    //<< do ^WWWFRAME(1)
    m$.Cmd.Do("WWWFRAME.main",1);
    //<< write "<BR><BR>"
    m$.Cmd.Write("<BR><BR>");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< FormImage()
  public Object FormImage(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the form image
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Mar-2008   GM      SRBR014883: Make appear the pictures of screens in "WWWHPR" form
    //<< ; 27-Oct-2006   SteveS  SR15094: Created (moved from START^WWWHELP)
    //<< ;-------------------------------------------------------------------------------
    //<< new PATH,objCompany
    mVar PATH = m$.var("PATH");
    mVar objCompany = m$.var("objCompany");
    m$.newVar(PATH,objCompany);
    //<< 
    //<< set objCompany = $get(^WWW012(0,0,1))
    objCompany.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
    //<< 
    //<< set FILE2 = $zconvert("FORM_"_YFORM_"_"_SPRACHE_"_"_YSEITE_".HTM","L")  ;HTML
    mVar FILE2 = m$.var("FILE2");
    FILE2.set(m$.Fnc.$zconvert(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("FORM_",m$.var("YFORM").get()),"_"),m$.var("SPRACHE").get()),"_"),m$.var("YSEITE").get()),".HTM"),"L"));
    //<< set PATH  = ##Class(%File).NormalizeDirectory($$$WWW012PhysicalWWWDirectory(objCompany))
    PATH.set(m$.fnc$("$File.NormalizeDirectory",include.WWWConst.$$$WWW012PhysicalWWWDirectory(m$,objCompany)));
    //<< 
    //<< quit:$$^WWWFILECHECK(PATH_$piece(FILE2,".",1)_".jpg")'=1
    if (mOp.NotEqual(m$.fnc$("WWWFILECHECK.main",mOp.Concat(mOp.Concat(PATH.get(),m$.Fnc.$piece(FILE2.get(),".",1)),".jpg")),1)) {
      return null;
    }
    //<< quit:$get(blnEditGridHelp)=1
    if (mOp.Equal(m$.Fnc.$get(m$.var("blnEditGridHelp")),1)) {
      return null;
    }
    //<< 
    //<< write YCR,"<CENTER><IMG SRC="""_YGIF_$piece(FILE2,".",1)_".jpg"" BORDER=1></CENTER>"  ; display image
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat("<CENTER><IMG SRC=\"",m$.var("YGIF").get()),m$.Fnc.$piece(FILE2.get(),".",1)),".jpg\" BORDER=1></CENTER>"));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ShowHelp(pidLang,pidChildUser)
  public Object ShowHelp(Object ... _p) {
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidChildUser = m$.newVarRef("pidChildUser",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the Help Text
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strType
    mVar strType = m$.var("strType");
    m$.newVar(strType);
    //<< 
    //<< for strType="M","P","LP","LD" {
    for (Object _strType: new Object[] {"M","P","LP","LD"}) {
    strType.set(_strType);
      //<< do Tabs(strType)
      m$.Cmd.Do("Tabs",_strType);
      //<< do HelpText(strType,pidLang,pidChildUser)
      m$.Cmd.Do("HelpText",_strType,pidLang.get(),pidChildUser.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Tabs(pstrType)
  public Object Tabs(Object ... _p) {
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the Tabs
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strPictureFile
    mVar strPictureFile = m$.var("strPictureFile");
    m$.newVar(strPictureFile);
    //<< 
    //<< if (YSEITE=1) && (pstrType="P") && ($data(^WWW1203(0,YFORM,SPRACHE,1))) {
    if ((mOp.Equal(m$.var("YSEITE").get(),1)) && (mOp.Equal(pstrType.get(),"P")) && mOp.Logical((m$.Fnc.$data(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),1))))) {
      //<< do FF^WWWW()
      m$.Cmd.Do("WWWW.FF");
      //<< write "<HR COLOR="_YBLUE_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<HR COLOR=",m$.var("YBLUE").get()),">"));
      //<< set strPictureFile=$$$WWW1203PictureFileForPageTag($get(^WWW1203(0,YFORM,SPRACHE,1,1)))
      strPictureFile.set(include.WWWConst.$$$WWW1203PictureFileForPageTag(m$,m$.Fnc.$get(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),1,1))));
      //<< if strPictureFile="" {
      if (mOp.Equal(strPictureFile.get(),"")) {
        //<< if SPRACHE="DE" {
        if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
          //<< set strPictureFile="seite1.gif"
          strPictureFile.set("seite1.gif");
        }
        //<< } else {
        else {
          //<< set strPictureFile="page1.gif"
          strPictureFile.set("page1.gif");
        }
      }
      //<< }
      //<< }
      //<< if $find($$$UPPER(strPictureFile),".GIF") {
      if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$UPPER(m$,strPictureFile),".GIF"))) {
        //<< write "<img src="""_YGIF_strPictureFile_""">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<img src=\"",m$.var("YGIF").get()),strPictureFile.get()),"\">"));
      }
      //<< } else {
      else {
        //<< write YCR,"<H3>",strPictureFile,"</H3>"
        m$.Cmd.Write(m$.var("YCR").get(),"<H3>",strPictureFile.get(),"</H3>");
      }
      //<< }
      //<< write "<HR COLOR="_YBLUE_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<HR COLOR=",m$.var("YBLUE").get()),">"));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< HelpText(pstrType,pidLang,pidChildUser)
  public Object HelpText(Object ... _p) {
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidChildUser = m$.newVarRef("pidChildUser",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the actual help text data
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnNoPrinting,idField,blnQuit
    mVar blnNoPrinting = m$.var("blnNoPrinting");
    mVar idField = m$.var("idField");
    mVar blnQuit = m$.var("blnQuit");
    m$.newVar(blnNoPrinting,idField,blnQuit);
    //<< 
    //<< set blnQuit=$$$NO
    blnQuit.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if '$data(^WWW127(0,YFORM,"M",0,SPRACHE)) set ^WWW127(0,YFORM,"M",0,SPRACHE,1) = ""
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW127",0,m$.var("YFORM").get(),"M",0,m$.var("SPRACHE").get())))) {
      m$.var("^WWW127",0,m$.var("YFORM").get(),"M",0,m$.var("SPRACHE").get(),1).set("");
    }
    //<< set idField = ""
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField = $order(^WWW127(0,YFORM,pstrType,idField))
      idField.set(m$.Fnc.$order(m$.var("^WWW127",0,m$.var("YFORM").get(),pstrType.get(),idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< quit:$$FieldChecks(pstrType,idField)
      if (mOp.Logical(m$.fnc$("FieldChecks",pstrType.get(),idField.get()))) {
        break;
      }
      //<< 
      //<< set blnNoPrinting = $$$YES
      blnNoPrinting.set(include.COMSYS.$$$YES(m$));
      //<< 
      //<< if pstrType="P" {
      if (mOp.Equal(pstrType.get(),"P")) {
        //<< if YDATEI'="" {
        if (mOp.NotEqual(m$.var("YDATEI").get(),"")) {
          //<< if $data(^WWW002(0,YDATEI,idField)) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW002",0,m$.var("YDATEI").get(),idField.get())))) {
            //<< set blnNoPrinting=$$$NO
            blnNoPrinting.set(include.COMSYS.$$$NO(m$));
          }
          //<< }
          //<< 
          //<< if +YADMIN=0 && ($translate($$$WWW121FixedInputForHiddenField($get(^WWW121(0,YFORM,idField,1)))," ")'="") {
          if (mOp.Equal(mOp.Positive(m$.var("YADMIN").get()),0) && (mOp.NotEqual(m$.Fnc.$translate(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),idField.get(),1)))," "),""))) {
            //<< set blnQuit=$$$YES
            blnQuit.set(include.COMSYS.$$$YES(m$));
          }
          //<< } else {
          else {
            //<< write "<br><h4>"
            m$.Cmd.Write("<br><h4>");
            //<< if +YADMIN'=0 {
            if (mOp.NotEqual(mOp.Positive(m$.var("YADMIN").get()),0)) {
              //<< do LocationOnLineHelp(idField,pidLang,pidChildUser)
              m$.Cmd.Do("LocationOnLineHelp",idField.get(),pidLang.get(),pidChildUser.get());
            }
            //<< }
            //<< do FieldDescription(idField,.blnQuit)
            m$.Cmd.Do("FieldDescription",idField.get(),blnQuit);
            //<< if YADMIN=1 write "</A>"
            if (mOp.Equal(m$.var("YADMIN").get(),1)) {
              m$.Cmd.Write("</A>");
            }
            //<< write "</h4>"
            m$.Cmd.Write("</h4>");
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< if blnQuit {
      if (mOp.Logical(blnQuit.get())) {
        //<< set blnQuit=$$$NO
        blnQuit.set(include.COMSYS.$$$NO(m$));
      }
      //<< } else {
      else {
        //<< do:pstrType="M" ManualField(idField,.blnNoPrinting,pidLang,pidChildUser)
        if (mOp.Equal(pstrType.get(),"M")) {
          m$.Cmd.Do("ManualField",idField.get(),blnNoPrinting,pidLang.get(),pidChildUser.get());
        }
        //<< if $extract(pstrType)'="L" {
        if (mOp.NotEqual(m$.Fnc.$extract(pstrType.get()),"L")) {
          //<< ;   set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""","""_pstrType_""","""_idField_""","""_idLang_""","""_1_""")")
          //<< set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""","""_pstrType_""","""_idField_""","""_pidLang_""","""_1_""")")
          mVar YTEXT = m$.var("YTEXT");
          YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,\"",m$.var("YFORM").get()),"\",\""),pstrType.get()),"\",\""),idField.get()),"\",\""),pidLang.get()),"\",\""),1),"\")")));
          //<< if YTEXT="" set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""","""_pstrType_""","""_idField_""",""EN"","""_1_""")")
          if (mOp.Equal(YTEXT.get(),"")) {
            YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,\"",m$.var("YFORM").get()),"\",\""),pstrType.get()),"\",\""),idField.get()),"\",\"EN\",\""),1),"\")")));
          }
          //<< set $piece(YTEXT,Y,4)=""   ;WEM;25188;02.03.2004;KEINE ANZEIGE DES SCHULUNGSPARAMETERS IN DER ONLINEHILFE
          m$.pieceVar(YTEXT,m$.var("Y").get(),4).set("");
          //<< ;SR16925.2 do GetTrainingText(pstrType,idField)
          //<< do ShowText(pstrType,blnNoPrinting,idField)
          m$.Cmd.Do("ShowText",pstrType.get(),blnNoPrinting.get(),idField.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< FieldChecks(pstrType,pidField)
  public Object FieldChecks(Object ... _p) {
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check whether the field should be shown
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnQuit,objWWW122
    mVar blnQuit = m$.var("blnQuit");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(blnQuit,objWWW122);
    //<< 
    //<< set blnQuit=$$$NO
    blnQuit.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if pstrType="M" {
    if (mOp.Equal(pstrType.get(),"M")) {
      //<< if pidField=1 {
      if (mOp.Equal(pidField.get(),1)) {
        //<< set objWWW122 = $get(^WWW122(0,YFORM,1,1))
        objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),1,1)));
        //<< if (objWWW122'="") && ($$$WWW122SequenceNumber(objWWW122)="") {
        if ((mOp.NotEqual(objWWW122.get(),"")) && (mOp.Equal(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122),""))) {
          //<< set blnQuit = $$$YES
          blnQuit.set(include.COMSYS.$$$YES(m$));
        }
      }
      //<< }
      //<< } else {
      else {
        //<< if ((pidField'=0) && (pidField'=1)) || ($$$WWW122DataInputType($get(^WWW122(0,YFORM,pidField,1)))=15) {
        if (mOp.Logical(((mOp.NotEqual(pidField.get(),0)) && (mOp.NotEqual(pidField.get(),1)))) || (mOp.Equal(include.WWWConst.$$$WWW122DataInputType(m$,m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),pidField.get(),1))),15))) {
          //<< set blnQuit = $$$YES
          blnQuit.set(include.COMSYS.$$$YES(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< } elseif pstrType="P" {
    else if (mOp.Equal(pstrType.get(),"P")) {
      //<< set blnQuit = ($$$WWW121TypeOfAcquisition($get(^WWW121(0,YFORM,pidField,1)))=15)
      blnQuit.set((mOp.Equal(include.WWWConst.$$$WWW121TypeOfAcquisition(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),pidField.get(),1))),15)));
    }
    //<< }
    //<< quit blnQuit
    return blnQuit.get();
  }

  //<< 
  //<< 
  //<< FieldDescription(pidField,&pblnQuit)
  public Object FieldDescription(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnQuit = m$.newVarRef("pblnQuit",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the field description (probably equiv to WWWFELDNAME)
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $translate($$$WWW121FixedInputForHiddenField($get(^WWW121(0,YFORM,pidField,1)))," ")'="" {
    if (mOp.NotEqual(m$.Fnc.$translate(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),pidField.get(),1)))," "),"")) {
      //<< set pblnQuit=$$$YES
      pblnQuit.set(include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } elseif $$$WWW121D1FieldDescription($get(^WWW121D1(0,YFORM,pidField,YM,SPRACHE,1)))'="" {
    else if (mOp.NotEqual(include.WWWConst.$$$WWW121D1FieldDescription(m$,m$.Fnc.$get(m$.var("^WWW121D1",0,m$.var("YFORM").get(),pidField.get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1))),"")) {
      //<< write $$$WWW121D1FieldDescription($get(^WWW121D1(0,YFORM,pidField,YM,SPRACHE,1)))
      m$.Cmd.Write(include.WWWConst.$$$WWW121D1FieldDescription(m$,m$.Fnc.$get(m$.var("^WWW121D1",0,m$.var("YFORM").get(),pidField.get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1))));
    }
    //<< 
    //<< } elseif $$$WWW121DFieldDescription($get(^WWW121D(0,YFORM,pidField,YM,1)))'="" {
    else if (mOp.NotEqual(include.WWWConst.$$$WWW121DFieldDescription(m$,m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),pidField.get(),m$.var("YM").get(),1))),"")) {
      //<< write $$$WWW121DFieldDescription($get(^WWW121D(0,YFORM,pidField,YM,1)))
      m$.Cmd.Write(include.WWWConst.$$$WWW121DFieldDescription(m$,m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),pidField.get(),m$.var("YM").get(),1))));
    }
    //<< 
    //<< } elseif $data(^WWW0021(0,YDATEI,pidField,SPRACHE,1)) {
    else if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0021",0,m$.var("YDATEI").get(),pidField.get(),m$.var("SPRACHE").get(),1)))) {
      //<< write $$$WWW0021PropertyDescription(^WWW0021(0,YDATEI,pidField,SPRACHE,1))
      m$.Cmd.Write(include.WWWConst.$$$WWW0021PropertyDescription(m$,m$.var("^WWW0021",0,m$.var("YDATEI").get(),pidField.get(),m$.var("SPRACHE").get(),1)));
    }
    //<< 
    //<< } else {
    else {
      //<< write $$$WWW002TextInForms($get(^WWW002(0,YDATEI,pidField,1)))
      m$.Cmd.Write(include.WWWConst.$$$WWW002TextInForms(m$,m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),pidField.get(),1))));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< LocationOnLineHelp(pidField,pidLang,pidChildUser)
  public Object LocationOnLineHelp(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidChildUser = m$.newVarRef("pidChildUser",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the Location based help text window
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-May-2011   shobby  SR16925.2: IndividualHelpText->CustomHelpText
    //<< ; 18-Sep-2008   shobby  BR014966: Support language texts for customisation help text.
    //<< ; 19-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHelpText
    mVar strHelpText = m$.var("strHelpText");
    m$.newVar(strHelpText);
    //<< 
    //<< ;set strHelpText = $$$WWW121DCustomHelpText($get(^WWW121D(0,YFORM,pidField,YM,1))) ;SR16925.2
    //<< set strHelpText = $$CustomHelpText^WWW121D($get(^WWW121D(0,YFORM,pidField,YM,1)))
    strHelpText.set(m$.fnc$("WWW121D.CustomHelpText",m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),pidField.get(),m$.var("YM").get(),1))));
    //<< 
    //<< write "<A"
    m$.Cmd.Write("<A");
    //<< if strHelpText'="" write " Title="""_$$^WWWTEXT(33417)_""""   ; "Location Specific Online-Help"
    if (mOp.NotEqual(strHelpText.get(),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" Title=\"",m$.fnc$("WWWTEXT.main",33417)),"\""));
    }
    //<< 
    //<< write " href='' onclick=""subWindow('"_YAKTION_"EP=WWWFORM&amp;YFORM=WWW121D"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" href='' onclick=\"subWindow('",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWW121D"));
    //<< write "&amp;YBED="_YBED_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YBED=",m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()));
    //<< write "&amp;YUSER="_pidChildUser            //SR11904
    m$.Cmd.Write(mOp.Concat("&amp;YUSER=",pidChildUser.get()));
    //<< write "&amp;SPRACHE="_pidLang
    m$.Cmd.Write(mOp.Concat("&amp;SPRACHE=",pidLang.get()));
    //<< write "&amp;YFKEY="_YFORM_","_pidField_","_YM
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YFKEY=",m$.var("YFORM").get()),","),pidField.get()),","),m$.var("YM").get()));
    //<< write "&amp;YKEY="_YFORM_","_pidField_","_YM
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YKEY=",m$.var("YFORM").get()),","),pidField.get()),","),m$.var("YM").get()));
    //<< write "&amp;YANZ="_YANZ
    m$.Cmd.Write(mOp.Concat("&amp;YANZ=",m$.var("YANZ").get()));
    //<< write "','TEILEFRAME1'); return false"">"
    m$.Cmd.Write("','TEILEFRAME1'); return false\">");
    //<< 
    //<< if strHelpText'="" write "&nbsp;<font color="_YRED_">(!)</FONT>"
    if (mOp.NotEqual(strHelpText.get(),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat("&nbsp;<font color=",m$.var("YRED").get()),">(!)</FONT>"));
    }
    //<< write " <IMG SRC="_YGIF_"dflt.gif border=0 TITLE="_$$^WWWTEXT(33400)_">"         ; "Customizing"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" <IMG SRC=",m$.var("YGIF").get()),"dflt.gif border=0 TITLE="),m$.fnc$("WWWTEXT.main",33400)),">"));
    //<< write "</A>"
    m$.Cmd.Write("</A>");
    //<< write "&nbsp;"
    m$.Cmd.Write("&nbsp;");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ManualField(pidField,&pblnNoPrinting,pidLang,pidChildUser)
  public Object ManualField(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnNoPrinting = m$.newVarRef("pblnNoPrinting",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidChildUser = m$.newVarRef("pidChildUser",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the Manual Fields help text
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-May-2011   shobby  SR16925.2: Don't show the button for Manual Field 0
    //<< ;                           Which is actually form level help.  Already
    //<< ;                           has one button.
    //<< ; 25-May-2011   shobby  SR16925.2: IndividualHelpText->CustomHelpText
    //<< ; 18-Sep-2008   shobby  BR014966: Support language texts for customisation help text.
    //<< ; 19-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW122D,strDesc,strHelpText,strSequence
    mVar objWWW122D = m$.var("objWWW122D");
    mVar strDesc = m$.var("strDesc");
    mVar strHelpText = m$.var("strHelpText");
    mVar strSequence = m$.var("strSequence");
    m$.newVar(objWWW122D,strDesc,strHelpText,strSequence);
    //<< 
    //<< ;quit:'$data(^WWW122(0,YFORM,pidField,1))
    //<< 
    //<< set pblnNoPrinting = $$$NO
    pblnNoPrinting.set(include.COMSYS.$$$NO(m$));
    //<< set strSequence    = $$$WWW122SequenceNumber($get(^WWW122(0,YFORM,pidField,1)))
    strSequence.set(include.WWWConst.$$$WWW122SequenceNumber(m$,m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),pidField.get(),1))));
    //<< quit:(strSequence'="")  ; data item rather than manual field
    if ((mOp.NotEqual(strSequence.get(),""))) {
      return null;
    }
    //<< 
    //<< write "<BR>"
    m$.Cmd.Write("<BR>");
    //<< write "<H4>"
    m$.Cmd.Write("<H4>");
    //<< 
    //<< if (+YADMIN'=0)&&(pidField'=0) {    ;SR16925.2
    if ((mOp.NotEqual(mOp.Positive(m$.var("YADMIN").get()),0)) && (mOp.NotEqual(pidField.get(),0))) {
      //<< write "<A"
      m$.Cmd.Write("<A");
      //<< 
      //<< set objWWW122D=$get(^WWW122D(0,YFORM,pidField,YM,1))
      objWWW122D.set(m$.Fnc.$get(m$.var("^WWW122D",0,m$.var("YFORM").get(),pidField.get(),m$.var("YM").get(),1)));
      //<< set strHelpText=$$CustomHelpText^WWW122D(objWWW122D)  ;SR16925.2
      strHelpText.set(m$.fnc$("WWW122D.CustomHelpText",objWWW122D.get()));
      //<< if strHelpText'="" write " Title="""_$$^WWWTEXT(33417)_""""      ; "Location Specific Online-Help"
      if (mOp.NotEqual(strHelpText.get(),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" Title=\"",m$.fnc$("WWWTEXT.main",33417)),"\""));
      }
      //<< 
      //<< write " href='' onclick=""subWindow('"_YAKTION_"EP=WWWFORM&amp;YFORM=WWW121D"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" href='' onclick=\"subWindow('",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWW121D"));
      //<< write "&amp;YBED="_YBED_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YBED=",m$.var("YBED").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()));
      //<< write "&amp;YUSER="_pidChildUser            //SR11904
      m$.Cmd.Write(mOp.Concat("&amp;YUSER=",pidChildUser.get()));
      //<< write "&amp;SPRACHE="_pidLang
      m$.Cmd.Write(mOp.Concat("&amp;SPRACHE=",pidLang.get()));
      //<< write "&amp;YFKEY="_YFORM_","_pidField_","_YM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YFKEY=",m$.var("YFORM").get()),","),pidField.get()),","),m$.var("YM").get()));
      //<< write "&amp;YKEY="_YFORM_","_pidField_","_YM
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YKEY=",m$.var("YFORM").get()),","),pidField.get()),","),m$.var("YM").get()));
      //<< write "&amp;YANZ="_YANZ
      m$.Cmd.Write(mOp.Concat("&amp;YANZ=",m$.var("YANZ").get()));
      //<< write "','TEILEFRAME1'); return false"">"
      m$.Cmd.Write("','TEILEFRAME1'); return false\">");
      //<< 
      //<< if strHelpText'="" write "&nbsp;<font color="_YRED_">(!)</FONT>"
      if (mOp.NotEqual(strHelpText.get(),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat("&nbsp;<font color=",m$.var("YRED").get()),">(!)</FONT>"));
      }
      //<< write " <IMG SRC="_YGIF_"dflt.gif border=0 TITLE="_pidField_"::"_$$^WWWTEXT(33400)_">"   ; "Customizing"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" <IMG SRC=",m$.var("YGIF").get()),"dflt.gif border=0 TITLE="),pidField.get()),"::"),m$.fnc$("WWWTEXT.main",33400)),">"));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
      //<< write "&nbsp;"
      m$.Cmd.Write("&nbsp;");
    }
    //<< }
    //<< 
    //<< set strDesc = $$$WWW122D1FieldDescription($get(^WWW122D1(0,YFORM,pidField,YM,SPRACHE,1)))
    strDesc.set(include.WWWConst.$$$WWW122D1FieldDescription(m$,m$.Fnc.$get(m$.var("^WWW122D1",0,m$.var("YFORM").get(),pidField.get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1))));
    //<< if strDesc="" set strDesc = $$$WWW122DFieldDescription($get(^WWW122D(0,YFORM,pidField,YM,1)))
    if (mOp.Equal(strDesc.get(),"")) {
      strDesc.set(include.WWWConst.$$$WWW122DFieldDescription(m$,m$.Fnc.$get(m$.var("^WWW122D",0,m$.var("YFORM").get(),pidField.get(),m$.var("YM").get(),1))));
    }
    //<< if strDesc="" set strDesc = $get(^WWW1221(0,YFORM,pidField,SPRACHE,1))
    if (mOp.Equal(strDesc.get(),"")) {
      strDesc.set(m$.Fnc.$get(m$.var("^WWW1221",0,m$.var("YFORM").get(),pidField.get(),m$.var("SPRACHE").get(),1)));
    }
    //<< if strDesc="" set strDesc = $piece($get(^WWW122(0,YFORM,pidField,1)),Y,12)
    if (mOp.Equal(strDesc.get(),"")) {
      strDesc.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),pidField.get(),1)),m$.var("Y").get(),12));
    }
    //<< 
    //<< write strDesc
    m$.Cmd.Write(strDesc.get());
    //<< if YADMIN=1 write "</A>"
    if (mOp.Equal(m$.var("YADMIN").get(),1)) {
      m$.Cmd.Write("</A>");
    }
    //<< write "</H4>"
    m$.Cmd.Write("</H4>");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetFormText(YTEXT,pblnNoPrint=$$$NO) ;SR16925
  public Object GetFormText(Object ... _p) {
    mVar YTEXT = m$.newVarRef("YTEXT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnNoPrint = m$.newVarRef("pblnNoPrint",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the help text for the form
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-May-2011   shobby  SR16925.2: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW120D,strText
    mVar objWWW120D = m$.var("objWWW120D");
    mVar strText = m$.var("strText");
    m$.newVar(objWWW120D,strText);
    //<< 
    //<< set strText = ""
    strText.set("");
    //<< 
    //<< set objWWW120D = $get(^WWW120D(0,YFORM,YM,1))
    objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",0,m$.var("YFORM").get(),m$.var("YM").get(),1)));
    //<< 
    //<< if $$$WWW120DHideAlphalincHelpText(objWWW120D) {
    if (mOp.Logical(include.WWWConst.$$$WWW120DHideAlphalincHelpText(m$,objWWW120D))) {
      //<< set strText = ""
      strText.set("");
    }
    //<< } else {
    else {
      //<< set strText = $$$WWW127HelpText(YTEXT)
      strText.set(include.WWWConst.$$$WWW127HelpText(m$,YTEXT));
    }
    //<< }
    //<< 
    //<< if '$$$WWW120DHideCustomHelpText(objWWW120D) {
    if (mOp.Not(include.WWWConst.$$$WWW120DHideCustomHelpText(m$,objWWW120D))) {
      //<< set strText = strText_"||"_$$CustomHelpText^WWW120D(objWWW120D)
      strText.set(mOp.Concat(mOp.Concat(strText.get(),"||"),m$.fnc$("WWW120D.CustomHelpText",objWWW120D.get())));
    }
    //<< }
    //<< if '$$$WWW120DHideCustomTrainingText(objWWW120D) {
    if (mOp.Not(include.WWWConst.$$$WWW120DHideCustomTrainingText(m$,objWWW120D))) {
      //<< set strText = strText_"||"_$$CustomTrainingText^WWW120D(objWWW120D)
      strText.set(mOp.Concat(mOp.Concat(strText.get(),"||"),m$.fnc$("WWW120D.CustomTrainingText",objWWW120D.get())));
    }
    //<< }
    //<< set strText = $zstrip(strText,"<W","|")
    strText.set(m$.Fnc.$zstrip(strText.get(),"<W","|"));
    //<< if 'pblnNoPrint if strText="" set strText = $$^WWWTEXT(28) ; "No Help Text Available"
    if (mOp.Not(pblnNoPrint.get())) {
      if (mOp.Equal(strText.get(),"")) {
        strText.set(m$.fnc$("WWWTEXT.main",28));
      }
    }
    //<< quit strText
    return strText.get();
  }

  //<< 
  //<< 
  //<< GetPrimaryKeyText(YTEXT,pblnNoPrint=$$$NO,pidField) ;SR16925
  public Object GetPrimaryKeyText(Object ... _p) {
    mVar YTEXT = m$.newVarRef("YTEXT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnNoPrint = m$.newVarRef("pblnNoPrint",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the help text for the primary key
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-May-2011   shobby  SR16925.2: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW121D,strText
    mVar objWWW121D = m$.var("objWWW121D");
    mVar strText = m$.var("strText");
    m$.newVar(objWWW121D,strText);
    //<< 
    //<< set strText = ""
    strText.set("");
    //<< 
    //<< set objWWW121D = $get(^WWW121D(0,YFORM,pidField,YM,1))
    objWWW121D.set(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),pidField.get(),m$.var("YM").get(),1)));
    //<< 
    //<< if $$$WWW121DHideAlphalincHelpText(objWWW121D) {
    if (mOp.Logical(include.WWWConst.$$$WWW121DHideAlphalincHelpText(m$,objWWW121D))) {
      //<< set strText = ""
      strText.set("");
    }
    //<< } else {
    else {
      //<< set strText = $$$WWW127HelpText(YTEXT)
      strText.set(include.WWWConst.$$$WWW127HelpText(m$,YTEXT));
    }
    //<< }
    //<< 
    //<< if '$$$WWW121DHideCustomHelpText(objWWW121D) {
    if (mOp.Not(include.WWWConst.$$$WWW121DHideCustomHelpText(m$,objWWW121D))) {
      //<< set strText = strText_"||"_$$CustomHelpText^WWW121D(objWWW121D)
      strText.set(mOp.Concat(mOp.Concat(strText.get(),"||"),m$.fnc$("WWW121D.CustomHelpText",objWWW121D.get())));
    }
    //<< }
    //<< if '$$$WWW121DHideCustomTrainingText(objWWW121D) {
    if (mOp.Not(include.WWWConst.$$$WWW121DHideCustomTrainingText(m$,objWWW121D))) {
      //<< set strText = strText_"||"_$$CustomTrainingText^WWW121D(objWWW121D)
      strText.set(mOp.Concat(mOp.Concat(strText.get(),"||"),m$.fnc$("WWW121D.CustomTrainingText",objWWW121D.get())));
    }
    //<< }
    //<< set strText = $zstrip(strText,"<W","|")
    strText.set(m$.Fnc.$zstrip(strText.get(),"<W","|"));
    //<< if 'pblnNoPrint if strText="" set strText = $$^WWWTEXT(28) ; "No Help Text Available"
    if (mOp.Not(pblnNoPrint.get())) {
      if (mOp.Equal(strText.get(),"")) {
        strText.set(m$.fnc$("WWWTEXT.main",28));
      }
    }
    //<< quit strText
    return strText.get();
  }

  //<< 
  //<< 
  //<< GetDataFieldText(YTEXT,pblnNoPrint=$$$NO,pidField) ;SR16925
  public Object GetDataFieldText(Object ... _p) {
    mVar YTEXT = m$.newVarRef("YTEXT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnNoPrint = m$.newVarRef("pblnNoPrint",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the help text for the data field
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-May-2011   shobby  SR16925.2: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW122D,strText
    mVar objWWW122D = m$.var("objWWW122D");
    mVar strText = m$.var("strText");
    m$.newVar(objWWW122D,strText);
    //<< 
    //<< set strText = ""
    strText.set("");
    //<< 
    //<< set objWWW122D = $get(^WWW122D(0,YFORM,pidField,YM,1))
    objWWW122D.set(m$.Fnc.$get(m$.var("^WWW122D",0,m$.var("YFORM").get(),pidField.get(),m$.var("YM").get(),1)));
    //<< 
    //<< if $$$WWW122DHideAlphalincHelpText(objWWW122D) {
    if (mOp.Logical(include.WWWConst.$$$WWW122DHideAlphalincHelpText(m$,objWWW122D))) {
      //<< set strText = ""
      strText.set("");
    }
    //<< } else {
    else {
      //<< set strText = $$$WWW127HelpText(YTEXT)
      strText.set(include.WWWConst.$$$WWW127HelpText(m$,YTEXT));
    }
    //<< }
    //<< 
    //<< if '$$$WWW122DHideCustomHelpText(objWWW122D) {
    if (mOp.Not(include.WWWConst.$$$WWW122DHideCustomHelpText(m$,objWWW122D))) {
      //<< set strText = strText_"||"_$$CustomHelpText^WWW122D(objWWW122D)
      strText.set(mOp.Concat(mOp.Concat(strText.get(),"||"),m$.fnc$("WWW122D.CustomHelpText",objWWW122D.get())));
    }
    //<< }
    //<< if '$$$WWW122DHideCustomTrainingText(objWWW122D) {
    if (mOp.Not(include.WWWConst.$$$WWW122DHideCustomTrainingText(m$,objWWW122D))) {
      //<< set strText = strText_"||"_$$CustomTrainingText^WWW122D(objWWW122D)
      strText.set(mOp.Concat(mOp.Concat(strText.get(),"||"),m$.fnc$("WWW122D.CustomTrainingText",objWWW122D.get())));
    }
    //<< }
    //<< set strText = $zstrip(strText,"<W","|")
    strText.set(m$.Fnc.$zstrip(strText.get(),"<W","|"));
    //<< if 'pblnNoPrint if strText="" set strText = $$^WWWTEXT(28) ; "No Help Text Available"
    if (mOp.Not(pblnNoPrint.get())) {
      if (mOp.Equal(strText.get(),"")) {
        strText.set(m$.fnc$("WWWTEXT.main",28));
      }
    }
    //<< quit strText
    return strText.get();
  }

  //<< 
  //<< 
  //<< ShowText(pstrType,blnNoPrint,pidField)
  public Object ShowText(Object ... _p) {
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar blnNoPrint = m$.newVarRef("blnNoPrint",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the actual text
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-May-2011   shobby  SR16925.2: Simplified, subroutined and suppress display with
    //<< ;                           related checkboxes.
    //<< ; 25-May-2011   shobby  SR16925.2: IndividualHelpText->CustomHelpText
    //<< ; 18-Sep-2008   shobby  BR014966: Support language texts for customisation help text.
    //<< ; 20-Jun-2007   RPW     SR15534: WWW120D does not have a field number attached,
    //<< ;                           fix from original code.
    //<< ; 19-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnFormHelp,objWWW120D,objWWW121D,strText
    mVar blnFormHelp = m$.var("blnFormHelp");
    mVar objWWW120D = m$.var("objWWW120D");
    mVar objWWW121D = m$.var("objWWW121D");
    mVar strText = m$.var("strText");
    m$.newVar(blnFormHelp,objWWW120D,objWWW121D,strText);
    //<< 
    //<< if pidField=0 {
    if (mOp.Equal(pidField.get(),0)) {
      //<< set YTEXT = $$GetFormText(YTEXT,blnNoPrint)
      mVar YTEXT = m$.var("YTEXT");
      YTEXT.set(m$.fnc$("GetFormText",m$.var("YTEXT").get(),blnNoPrint.get()));
    }
    //<< } else {
    else {
      //<< set YTEXT = $$GetPrimaryKeyText(YTEXT,blnNoPrint,pidField)
      mVar YTEXT = m$.var("YTEXT");
      YTEXT.set(m$.fnc$("GetPrimaryKeyText",m$.var("YTEXT").get(),blnNoPrint.get(),pidField.get()));
    }
    //<< }
    //<< do TEXT($$$NO)
    m$.Cmd.Do("TEXT",include.COMSYS.$$$NO(m$));
    //<< set blnFormHelp = ( (pstrType="M") && ((pidField=0) || (pidField=1)) )
    blnFormHelp.set(((mOp.Equal(pstrType.get(),"M")) && mOp.Logical(((mOp.Equal(pidField.get(),0)) || (mOp.Equal(pidField.get(),1))))));
    //<< do:blnFormHelp BUTTON()
    if (mOp.Logical(blnFormHelp.get())) {
      m$.Cmd.Do("BUTTON");
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DataFields(pidLang)
  public Object DataFields(Object ... _p) {
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Draw the Data Fields for a form
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-May-2011   shobby  SR16925.2: Replaced code with call to GetDataFieldText
    //<< ; 25-May-2011   shobby  SR16925.2: IndividualTrainingText -> CustomTrainingText
    //<< ; 25-May-2011   shobby  SR16925.2: IndividualHelpText->CustomHelpText
    //<< ; 18-Sep-2008   shobby  BR014966: Support language texts for customisation help text.
    //<< ; 06-Sep-2007   GRF     SRBR014657: test (blnHide'=$$$YES) rather than (blnHide="")
    //<< ; 28-Aug-2007   GM      SRBR014657: Include pidTab as parameter and YM as company
    //<< ; 20-Aug-2007   GM      SRBR014657: Hidden tabs are shown as gray for System
    //<< ;                           and Database Administrator users
    //<< ; 15-Aug-2007   shobby  SRBR014669: Call to TextWrapper
    //<< ; 07-Aug-2007   GM      BR014593: Condition included if hidden field in WWW122 was selected
    //<< ; 24-Jul-2007   GM      BR014593: Data for hidden field will be shown just for
    //<< ;                           System Administrator user
    //<< ; 20-Jun-2007   RPW     SR15539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strType,idxForm,idTab,strPictureFile,objWWW122D,blnShowCustomisedOnly,strCustomised,arrFields
    mVar strType = m$.var("strType");
    mVar idxForm = m$.var("idxForm");
    mVar idTab = m$.var("idTab");
    mVar strPictureFile = m$.var("strPictureFile");
    mVar objWWW122D = m$.var("objWWW122D");
    mVar blnShowCustomisedOnly = m$.var("blnShowCustomisedOnly");
    mVar strCustomised = m$.var("strCustomised");
    mVar arrFields = m$.var("arrFields");
    m$.newVar(strType,idxForm,idTab,strPictureFile,objWWW122D,blnShowCustomisedOnly,strCustomised,arrFields);
    //<< new intRow,intCol,idField,objWWW122,objWWW1203D,blnHide
    mVar intRow = m$.var("intRow");
    mVar intCol = m$.var("intCol");
    mVar idField = m$.var("idField");
    mVar objWWW122 = m$.var("objWWW122");
    mVar objWWW1203D = m$.var("objWWW1203D");
    mVar blnHide = m$.var("blnHide");
    m$.newVar(intRow,intCol,idField,objWWW122,objWWW1203D,blnHide);
    //<< 
    //<< set strType = "D"
    strType.set("D");
    //<< set idxForm = $$$Index(YFORM)
    idxForm.set(include.MEDConst.$$$Index(m$,m$.var("YFORM")));
    //<< set idTab   = ""
    idTab.set("");
    //<< for {
    for (;true;) {
      //<< set idTab = $order(^WWW122s(0,3,idxForm,idTab))
      idTab.set(m$.Fnc.$order(m$.var("^WWW122s",0,3,idxForm.get(),idTab.get())));
      //<< quit:idTab=""
      if (mOp.Equal(idTab.get(),"")) {
        break;
      }
      //<< continue:(YSEITE'=1)&&(idTab'=YSEITE)
      if ((mOp.NotEqual(m$.var("YSEITE").get(),1)) && (mOp.NotEqual(idTab.get(),m$.var("YSEITE").get()))) {
        continue;
      }
      //<< 
      //<< set objWWW1203D = $get(^WWW1203D(0,YFORM,SPRACHE,idTab,YM,1))
      objWWW1203D.set(m$.Fnc.$get(m$.var("^WWW1203D",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),idTab.get(),m$.var("YM").get(),1)));
      //<< set blnHide = $$$WWW1203DHide(objWWW1203D)
      blnHide.set(include.WWWConst.$$$WWW1203DHide(m$,objWWW1203D));
      //<< 
      //<< if idTab'=1 {
      if (mOp.NotEqual(idTab.get(),1)) {
        //<< if $$CanCustomize($$$WWW013UserAccess($get(^WWW013(0,YBED,1)))) || (blnHide'=$$$YES) {
        if (mOp.Logical(m$.fnc$("CanCustomize",include.WWWConst.$$$WWW013UserAccess(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))))) || (mOp.NotEqual(blnHide.get(),include.COMSYS.$$$YES(m$)))) {
          //<< write "<BR><HR COLOR="_YBLUE_">"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("<BR><HR COLOR=",m$.var("YBLUE").get()),">"));
          //<< set strPictureFile = $$$WWW1203PictureFileForPageTag($get(^WWW1203(0,YFORM,SPRACHE,idTab,1)))
          strPictureFile.set(include.WWWConst.$$$WWW1203PictureFileForPageTag(m$,m$.Fnc.$get(m$.var("^WWW1203",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),idTab.get(),1))));
          //<< if (strPictureFile="") && (idTab<11) {
          if ((mOp.Equal(strPictureFile.get(),"")) && (mOp.Less(idTab.get(),11))) {
            //<< if SPRACHE="DE" {
            if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
              //<< set strPictureFile = "seite"_idTab_".gif"
              strPictureFile.set(mOp.Concat(mOp.Concat("seite",idTab.get()),".gif"));
            }
            //<< } else {
            else {
              //<< set strPictureFile = "page"_idTab_".gif"
              strPictureFile.set(mOp.Concat(mOp.Concat("page",idTab.get()),".gif"));
            }
          }
          //<< }
          //<< }
          //<< 
          //<< if $find($$$UPPER(strPictureFile),".GIF") {
          if (mOp.Logical(m$.Fnc.$find(include.COMSYSString.$$$UPPER(m$,strPictureFile),".GIF"))) {
            //<< write "<IMG SRC="""_YGIF_strPictureFile_""">"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),strPictureFile.get()),"\">"));
          }
          //<< } else {
          else {
            //<< if blnHide {
            if (mOp.Logical(blnHide.get())) {
              //<< write "<H3><font color=#B6B6B6>"_strPictureFile_"</font></H3>"
              m$.Cmd.Write(mOp.Concat(mOp.Concat("<H3><font color=#B6B6B6>",strPictureFile.get()),"</font></H3>"));
            }
            //<< } else {
            else {
              //<< write "<H3>"_strPictureFile_"</H3>"
              m$.Cmd.Write(mOp.Concat(mOp.Concat("<H3>",strPictureFile.get()),"</H3>"));
            }
          }
          //<< }
          //<< }
          //<< write "<HR COLOR="_YBLUE_">"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("<HR COLOR=",m$.var("YBLUE").get()),">"));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< do GetFieldsForPage(YFORM,idTab,.arrFields)
      m$.Cmd.Do("GetFieldsForPage",m$.var("YFORM").get(),idTab.get(),arrFields);
      //<< 
      //<< set intRow = ""
      intRow.set("");
      //<< for {
      for (;true;) {
        //<< set intRow = $order(arrFields(intRow))
        intRow.set(m$.Fnc.$order(arrFields.var(intRow.get())));
        //<< quit:intRow=""
        if (mOp.Equal(intRow.get(),"")) {
          break;
        }
        //<< 
        //<< set intCol = ""
        intCol.set("");
        //<< for {
        for (;true;) {
          //<< set intCol = $order(arrFields(intRow,intCol))
          intCol.set(m$.Fnc.$order(arrFields.var(intRow.get(),intCol.get())));
          //<< quit:intCol=""
          if (mOp.Equal(intCol.get(),"")) {
            break;
          }
          //<< 
          //<< set idField = ""
          idField.set("");
          //<< for {
          for (;true;) {
            //<< set idField = $order(arrFields(intRow,intCol,idField))
            idField.set(m$.Fnc.$order(arrFields.var(intRow.get(),intCol.get(),idField.get())));
            //<< quit:idField=""
            if (mOp.Equal(idField.get(),"")) {
              break;
            }
            //<< continue:$$HideField(YFORM,idField)
            if (mOp.Logical(m$.fnc$("HideField",m$.var("YFORM").get(),idField.get()))) {
              continue;
            }
            //<< 
            //<< ; FIXME : <GRF> should pull <H4> tag from ShowCustomiseButton and put it here since may not get executed
            //<< ;               NOTE : Test in ShowCustomiseButton matches $$HideField
            //<< 
            //<< do ShowCustomiseButton(YFORM,idField)
            m$.Cmd.Do("ShowCustomiseButton",m$.var("YFORM").get(),idField.get());
            //<< do ShowFieldName(YFORM,idField,idTab)
            m$.Cmd.Do("ShowFieldName",m$.var("YFORM").get(),idField.get(),idTab.get());
            //<< ;           do ShowFieldName(YFORM,idField,YLFNN,YDATEI,idTab)    ; replacement for previous line if ShowFieldNameNew is renamed (BR014669)
            //<< 
            //<< ; FIXME : <GRF> should pull </H4> tag from ShowFieldName and put it here since it is always executed
            //<< 
            //<< if YLFNN'="" {
            if (mOp.NotEqual(m$.var("YLFNN").get(),"")) {
              //<< set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""","""_strType_""","""_YLFNN_""","""_pidLang_""","""_1_""")")
              mVar YTEXT = m$.var("YTEXT");
              YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,\"",m$.var("YFORM").get()),"\",\""),strType.get()),"\",\""),m$.var("YLFNN").get()),"\",\""),pidLang.get()),"\",\""),1),"\")")));
              //<< if YTEXT="" set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""","""_strType_""","""_YLFNN_""",""EN"","""_1_""")")
              if (mOp.Equal(YTEXT.get(),"")) {
                YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,\"",m$.var("YFORM").get()),"\",\""),strType.get()),"\",\""),m$.var("YLFNN").get()),"\",\"EN\",\""),1),"\")")));
              }
              //<< if YTEXT="" set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""","""_strType_""","""_YLFNN_""",""DE"","""_1_""")")
              if (mOp.Equal(YTEXT.get(),"")) {
                YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,\"",m$.var("YFORM").get()),"\",\""),strType.get()),"\",\""),m$.var("YLFNN").get()),"\",\"DE\",\""),1),"\")")));
              }
            }
            //<< } else {
            else {
              //<< set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""",""M"","""_idField_""","""_pidLang_""","""_1_""")")
              mVar YTEXT = m$.var("YTEXT");
              YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,\"",m$.var("YFORM").get()),"\",\"M\",\""),idField.get()),"\",\""),pidLang.get()),"\",\""),1),"\")")));
              //<< if YTEXT="" set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""",""M"","""_idField_""",""EN"","""_1_""")")
              if (mOp.Equal(YTEXT.get(),"")) {
                YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,\"",m$.var("YFORM").get()),"\",\"M\",\""),idField.get()),"\",\"EN\",\""),1),"\")")));
              }
              //<< if YTEXT="" set YTEXT = $$^WWWSETL("^WWW127(0,"""_YFORM_""",""M"","""_idField_""",""DE"","""_1_""")")
              if (mOp.Equal(YTEXT.get(),"")) {
                YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,\"",m$.var("YFORM").get()),"\",\"M\",\""),idField.get()),"\",\"DE\",\""),1),"\")")));
              }
            }
            //<< }
            //<< 
            //<< set YTEXT     = $$GetDataFieldText(YTEXT,$$$NO,idField)
            mVar YTEXT = m$.var("YTEXT");
            YTEXT.set(m$.fnc$("GetDataFieldText",m$.var("YTEXT").get(),include.COMSYS.$$$NO(m$),idField.get()));
            //<< set objWWW122 = $$Get^WWW122(YFORM,idField)        ;BR014593  ;BR014669
            objWWW122.set(m$.fnc$("WWW122.Get",m$.var("YFORM").get(),idField.get()));
            //<< set YTEXT = $$TextWrapper(YDATEI,$$$WWW122SequenceNumber(objWWW122),YTEXT,"D")         ;BR014669
            YTEXT.set(m$.fnc$("TextWrapper",m$.var("YDATEI").get(),include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122),YTEXT.get(),"D"));
            //<< ;   if ($$$WWW122DHiddenField(objWWW122D)) || ($$$WWW122DataInputType(objWWW122)=15) {  ;BR014593   ;BR014669
            //<< if ($$$WWW122InputType(objWWW122)=0) || blnHide {                      ;BR014593 ;BR014669 ;BR014657 Hidden
            if ((mOp.Equal(include.WWWConst.$$$WWW122InputType(m$,objWWW122),0)) || mOp.Logical(blnHide.get())) {
              //<< if $$CanCustomize($$$WWW013UserAccess($get(^WWW013(0,YBED,1)))) {  ;BR014593
              if (mOp.Logical(m$.fnc$("CanCustomize",include.WWWConst.$$$WWW013UserAccess(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)))))) {
                //<< do TEXT($$$YES)
                m$.Cmd.Do("TEXT",include.COMSYS.$$$YES(m$));
              }
            }
            //<< }
            //<< } else {
            else {
              //<< do TEXT($$$NO)
              m$.Cmd.Do("TEXT",include.COMSYS.$$$NO(m$));
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

//<< 
}
