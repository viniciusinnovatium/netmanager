//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTINFO
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 20:30:07
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
//<< #include INConst
import include.INConst;

//<< INARTINFO
public class INARTINFO extends mClass {

  public void main() {
    _INARTINFO();
  }

  public void _INARTINFO() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANZEIGEN INFO AUS ARTIKEL
    //<< ;   ANZEIGE IN ARTIKELANLAGE ;Show within
    //<< ;   VORGABE= YKEY = ARTIKELNUMMER
    //<< ;
    //<< ; Inputs :
    //<< ;   YKEY
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 02-Sep-2008   GRF     SR15804: Call form INListBundles rather than INBESTANZ
    //<< ; 18-Oct-2007   shobby  SRBR014511: Don't display links at the top of the screen
    //<< ;                           if no permission defined in INVORG
    //<< ; 14-Sep-2006   GRF     SR15040: INVORG Macros
    //<< ; 25-Aug-2006   GRF     SR12027: Mark Disabled Block; quits
    //<< ; 21-Jan-2006   GRF     SR14074: Doco; AuthorisedList & blnAuthorised
    //<< ; 09-Jan-2005   Frank   SR11392: Avoiding Language text combination.
    //<< ; 12-Jul-2005   GRF     SR12027: Identify INARTK Product Description Use
    //<< ; 31-May-2005   RobertW SR11649: Allow the user to view stock from all locations
    //<< ;                       or this location
    //<< ; 27.01.2000    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new ART,AUFTRAG,AuthorisedList,BETR,blnAuthorised,CONFIGURE,LEISTUNG,LIEF,ME,MENGE
    mVar ART = m$.var("ART");
    mVar AUFTRAG = m$.var("AUFTRAG");
    mVar AuthorisedList = m$.var("AuthorisedList");
    mVar BETR = m$.var("BETR");
    mVar blnAuthorised = m$.var("blnAuthorised");
    mVar CONFIGURE = m$.var("CONFIGURE");
    mVar LEISTUNG = m$.var("LEISTUNG");
    mVar LIEF = m$.var("LIEF");
    mVar ME = m$.var("ME");
    mVar MENGE = m$.var("MENGE");
    m$.newVar(ART,AUFTRAG,AuthorisedList,BETR,blnAuthorised,CONFIGURE,LEISTUNG,LIEF,ME,MENGE);
    //<< new objINVORG,PAUSCHAL,PHANTOM,YII
    mVar objINVORG = m$.var("objINVORG");
    mVar PAUSCHAL = m$.var("PAUSCHAL");
    mVar PHANTOM = m$.var("PHANTOM");
    mVar YII = m$.var("YII");
    m$.newVar(objINVORG,PAUSCHAL,PHANTOM,YII);
    //<< 
    //<< set objINVORG=$get(^INVORG(YM,YM,1)) ;BR014511
    objINVORG.set(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)));
    //<< 
    //<< ;Q:$get(YKEY)=""
    //<< SET ART=$PIECE($GET(YKEY),",",1)
    ART.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YKEY")),",",1));
    //<< ;Q:ART=""
    //<< 
    //<< set AuthorisedList = $$$INVORGOrderProcessingWithCustom(objINVORG)     ; D35 ;BR014511
    AuthorisedList.set(include.INConst.$$$INVORGOrderProcessingWithCustom(m$,objINVORG));
    //<< set blnAuthorised  = $$^WWWACCESS("",AuthorisedList)
    blnAuthorised.set(m$.fnc$("WWWACCESS.main","",AuthorisedList.get()));
    //<< 
    //<< ; ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //<< ; Data Records :
    //<< ;   SATZ            objINART            Item Masterfile
    //<< ;   LIEFSATZ        objINLIEF           Supplier Masterfile
    //<< ; ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< /*--------------------------------------------------------------------------------------------
    //<< ;           Item Number [<number>                ] <description>                             |
    //<< ; <customs message>                                                                          |
    //<< ; Stock: <qty unit> Open Orders: < > Actual Offer: <>  Supplier...  <level msg>  <part msg>  | <= INARTINFO
    //<< ;+- Description ----------------------------------------------------------------------------+|
    //<< ;|      Search Name [<item name>                       ]                                    ||
    //<< ;                                                                                            |
    //<< ;-------------------------------------------------------------------------------------------*/
    //<< 
    //<< WRITE YCR,"<NOBR>"
    m$.Cmd.Write(m$.var("YCR").get(),"<NOBR>");
    //<< SET PHANTOM   = $$$NO
    PHANTOM.set(include.COMSYS.$$$NO(m$));
    //<< SET LEISTUNG  = $$$NO
    LEISTUNG.set(include.COMSYS.$$$NO(m$));
    //<< SET PAUSCHAL  = $$$NO
    PAUSCHAL.set(include.COMSYS.$$$NO(m$));
    //<< SET CONFIGURE = $$$NO
    CONFIGURE.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< IF ART'="" DO
    if (mOp.NotEqual(ART.get(),"")) {
      //<< . NEW SATZ
      mVar SATZ = m$.var("SATZ");
      m$.newVarBlock(1,SATZ);
      //<< . SET SATZ=$GET(^INART(YM,ART,1))
      SATZ.set(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),ART.get(),1)));
      //<< . IF +$PIECE(SATZ,Y,26)=5  SET PHANTOM   = $$$YES  ; Phantom Item         ;PHANTOM-ARTIKEL
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),26)),5)) {
        PHANTOM.set(include.COMSYS.$$$YES(m$));
      }
      //<< . IF +$PIECE(SATZ,Y,26)=6  SET PAUSCHAL  = $$$YES  ; Overall performances ;PAUSCHALE
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),26)),6)) {
        PAUSCHAL.set(include.COMSYS.$$$YES(m$));
      }
      //<< . IF +$PIECE(SATZ,Y,26)=7  SET CONFIGURE = $$$YES  ; Item To Configure    ;KONFIGURATIONSARTIKEL
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),26)),7)) {
        CONFIGURE.set(include.COMSYS.$$$YES(m$));
      }
      //<< . IF +$PIECE(SATZ,Y,26)=2  SET LEISTUNG  = $$$YES  ; Service Item
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),26)),2)) {
        LEISTUNG.set(include.COMSYS.$$$YES(m$));
      }
      //<< . IF +$PIECE(SATZ,Y,40)=2  SET LEISTUNG  = $$$YES       ; Hours
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),40)),2)) {
        LEISTUNG.set(include.COMSYS.$$$YES(m$));
      }
      //<< . IF +$PIECE(SATZ,Y,40)=10 SET LEISTUNG  = $$$YES       ; Minutes
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),40)),10)) {
        LEISTUNG.set(include.COMSYS.$$$YES(m$));
      }
      //<< . IF +$PIECE(SATZ,Y,40)=11 SET LEISTUNG  = $$$YES       ; Industry Minutes
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(SATZ.get(),m$.var("Y").get(),40)),11)) {
        LEISTUNG.set(include.COMSYS.$$$YES(m$));
      }
      //<< . ;
      //<< . SET ^INDRPUSER(YM,YUSER,1)=Y_ART   ;VORGABE DRP ;default DRP
      m$.var("^INDRPUSER",m$.var("YM").get(),m$.var("YUSER").get(),1).set(mOp.Concat(m$.var("Y").get(),ART.get()));
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< ;***************** EARLY QUIT *******************************************
    //<< quit:'$$^WWWACCESS($$$INVORGItemMasterDataInfo(objINVORG),"")   ;BR014511
    if (mOp.Not(m$.fnc$("WWWACCESS.main",include.INConst.$$$INVORGItemMasterDataInfo(m$,objINVORG),""))) {
      return;
    }
    //<< 
    //<< SET BETR=""
    BETR.set("");
    //<< 
    //<< 
    //<< ;IF +$$$INVORGAccessOtherItemLocns($GET(^INVORG(YM,YM,1)))=0 SET BETR=YLOCATION           ; D67
    //<< IF +$$$INVORGViewStockFromAllLocations($GET(^INVORG(YM,YM,1)))=0 SET BETR=YLOCATION       ; D218
    if (mOp.Equal(mOp.Positive(include.INConst.$$$INVORGViewStockFromAllLocations(m$,m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)))),0)) {
      BETR.set(m$.var("YLOCATION").get());
    }
    //<< 
    //<< SET MENGE=0
    MENGE.set(0);
    //<< IF LEISTUNG'=$$$YES IF PAUSCHAL'=$$$YES IF CONFIGURE'=$$$YES SET MENGE=$$^INARTMENGE(ART,,BETR)   ;WEM;24475;24.02.2004;TATSÄCHLICH VERFÜGBARER BESTAND MIT KOMMISSIONEN
    if (mOp.NotEqual(LEISTUNG.get(),include.COMSYS.$$$YES(m$))) {
      if (mOp.NotEqual(PAUSCHAL.get(),include.COMSYS.$$$YES(m$))) {
        if (mOp.NotEqual(CONFIGURE.get(),include.COMSYS.$$$YES(m$))) {
          MENGE.set(m$.fnc$("INARTMENGE.main",ART.get(),null,BETR.get()));
        }
      }
    }
    //<< 
    //<< SET LIEF    = $$^INARTLIEF(ART,4)  ;LETZTEN LIEFERANTEN
    LIEF.set(m$.fnc$("INARTLIEF.main",ART.get(),4));
    //<< SET AUFTRAG = $$^INARTAUF(ART)     ;AUFTRAGSMENGE EINES ARTIKELS
    AUFTRAG.set(m$.fnc$("INARTAUF.main",ART.get()));
    //<< SET ANGEBOT = $$^INARTANG(ART)     ;ANGBOTSMENGE EINES ARTIKELS
    mVar ANGEBOT = m$.var("ANGEBOT");
    ANGEBOT.set(m$.fnc$("INARTANG.main",ART.get()));
    //<< 
    //<< WRITE "<TABLE BORDER=0 CELLSPACING=0>"
    m$.Cmd.Write("<TABLE BORDER=0 CELLSPACING=0>");
    //<< WRITE "<TR>"
    m$.Cmd.Write("<TR>");
    //<< 
    //<< /* +++++++++++++++++++++++++++++++++++++
    //<< ; "Stock: qty unit"   [Red if below safety stock level]
    //<< ; Tool Tip : "Display Available Stock Quantity"
    //<< ; Link     : form INBESTSALES
    //<< ; ++++++++++++++++++++++++++++++++++++++ */
    //<< 
    //<< WRITE "<TD NOWRAP VALIGN=TOP ALIGN=LEFT WIDTH=120>"
    m$.Cmd.Write("<TD NOWRAP VALIGN=TOP ALIGN=LEFT WIDTH=120>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    do {
      //<< 
      //<< DO  ;BESTANDSANZEIGE
      //<< . NEW YBACK
      mVar YBACK = m$.var("YBACK");
      m$.newVarBlock(1,YBACK);
      //<< . KILL FERTIGUNGSNR       ;WENN FERTIGUNGSNUMMER AUS UMBUCHUNG NOCH VORHANDEN     ;when out of yet on hand
      m$.var("FERTIGUNGSNR").kill();
      //<< . KILL SNANZEIGE          ;WENN RÜCKSPRUNGVARIABLE AUS SN-ZUORDUNG NOCH VORHANDEN ;when out of yet on hand
      m$.var("SNANZEIGE").kill();
      //<< . SET ARTANZEIGE=$$$YES   ;WENN VARIABLE AUS MANUELLER ANZEIGE NOCH VORHANDEN     ;when out of Show yet on hand
      mVar ARTANZEIGE = m$.var("ARTANZEIGE");
      ARTANZEIGE.set(include.COMSYS.$$$YES(m$));
      //<< . IF (PHANTOM=$$$YES) || (CONFIGURE=$$$YES) DO  QUIT
      if ((mOp.Equal(PHANTOM.get(),include.COMSYS.$$$YES(m$))) || (mOp.Equal(CONFIGURE.get(),include.COMSYS.$$$YES(m$)))) {
        //<< . . WRITE "<FONT COLOR="_YRED_">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT COLOR=",m$.var("YRED").get()),">"));
        //<< . . IF PAUSCHAL=$$$YES  WRITE $PIECE($GET(^WWW101(0,"ARTIKEL-ART",SPRACHE,5,1)),Y,1)  ; Phantom Item
        if (mOp.Equal(PAUSCHAL.get(),include.COMSYS.$$$YES(m$))) {
          m$.Cmd.Write(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",0,"ARTIKEL-ART",m$.var("SPRACHE").get(),5,1)),m$.var("Y").get(),1));
        }
        //<< . . IF CONFIGURE=$$$YES WRITE $PIECE($GET(^WWW101(0,"ARTIKEL-ART",SPRACHE,7,1)),Y,1)  ; Item To Configure
        if (mOp.Equal(CONFIGURE.get(),include.COMSYS.$$$YES(m$))) {
          m$.Cmd.Write(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",0,"ARTIKEL-ART",m$.var("SPRACHE").get(),7,1)),m$.var("Y").get(),1));
        }
        //<< . . WRITE "</FONT>"
        m$.Cmd.Write("</FONT>");
        break;
      }
      //<< . ;
      //<< . IF (LEISTUNG=$$$YES) || (PAUSCHAL=$$$YES) DO  QUIT
      if ((mOp.Equal(LEISTUNG.get(),include.COMSYS.$$$YES(m$))) || (mOp.Equal(PAUSCHAL.get(),include.COMSYS.$$$YES(m$)))) {
        do {
          //<< . . SET ME=$PIECE($GET(^INART(YM,ART,1)),Y,40)
          ME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),ART.get(),1)),m$.var("Y").get(),40));
          //<< . . IF ME="" WRITE $PIECE($GET(^WWW101(0,"ARTIKEL-ART",SPRACHE,2,1)),Y,1) QUIT   ; Service
          if (mOp.Equal(ME.get(),"")) {
            m$.Cmd.Write(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",0,"ARTIKEL-ART",m$.var("SPRACHE").get(),2,1)),m$.var("Y").get(),1));
            break;
          }
          //<< . . WRITE $PIECE($GET(^WWW101(0,"EINHEIT",SPRACHE,ME,1)),Y,1)                    ; Minutes, etc.
          m$.Cmd.Write(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",0,"EINHEIT",m$.var("SPRACHE").get(),ME.get(),1)),m$.var("Y").get(),1));
        } while (false);
        break;
      }
      //<< . ;
      //<< . IF ART'="" DO
      if (mOp.NotEqual(ART.get(),"")) {
        //<< . . SET $PIECE(^INUSER(YM,YBED,1),Y,2)=ART
        m$.pieceVar(m$.var("^INUSER",m$.var("YM").get(),m$.var("YBED").get(),1),m$.var("Y").get(),2).set(ART.get());
        //<< . . WRITE "<A"
        m$.Cmd.Write("<A");
        //<< . . ;WRITE " TITLE="_$$$DBLQUOTE_$$^WWWTEXT(32121)_$$$DBLQUOTE  ; "Display Items In Stock"
        //<< . . WRITE " TITLE="_$$$DBLQUOTE_$$^WWWTEXT(33773)_$$$DBLQUOTE   ; "Display Available Stock Quantity"   ;WEM;25.02.2003;AUSSAGEKRÄFTIGER ALT-TEXT
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.fnc$("WWWTEXT.main",33773)),include.COMSYSString.$$$DBLQUOTE(m$)));
        //<< . . ;WRITE " HREF="_$$$DBLQUOTE_YAKTION_"EP=WWWFORM&YFORM=INBESTANZ"               ;&YEXEC=D|^INARTI"   ; SR15804
        //<< . . WRITE " HREF="_$$$DBLQUOTE_YAKTION_"EP=WWWFORM&YFORM=INListBundles"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.var("YAKTION").get()),"EP=WWWFORM&YFORM=INListBundles"));
        //<< . . ;
        //<< . . ;ULM - ÄNDERUNG LINK FÜR BESTANDSAUSKUNFT - 06.02.03, JETZT ÜBER SEPARATEN BUTTON AUFZURUFEN;28.02.03
        //<< . . ;WRITE " HREF="_$$$DBLQUOTE_YAKTION_"EP=WWWFORM&YFORM=INBESTSALES"
        //<< . . ;
        //<< . . SET YBACK="INART,"
        YBACK.set("INART,");
        //<< . . DO ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< . . WRITE $$$DBLQUOTE_">"
        m$.Cmd.Write(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),">"));
      }
      //<< . ;
      //<< . ;     D40         $$$INARTUnitofMeasure
      //<< . ;     D134        $$$INARTSafetyStock()
      //<< . SET YII=0
      YII.set(0);
      //<< . IF ART'="" IF $PIECE($GET(^INART(YM,ART,1)),Y,134)>MENGE WRITE "<FONT COLOR="_YRED_">" SET YII=1
      if (mOp.NotEqual(ART.get(),"")) {
        if (mOp.Greater(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),ART.get(),1)),m$.var("Y").get(),134),MENGE.get())) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT COLOR=",m$.var("YRED").get()),">"));
          YII.set(1);
        }
      }
      //<< . WRITE $$^WWWTEXT(32020)_": ",$$^WWWZAHL(MENGE,0,$LENGTH($PIECE(MENGE,".",2)))   ; "Stock"
      m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main",32020),": "),m$.fnc$("WWWZAHL.main",MENGE.get(),0,m$.Fnc.$length(m$.Fnc.$piece(MENGE.get(),".",2))));
      //<< . IF +MENGE'=0 IF ART'="" IF $PIECE($get(^INART(YM,ART,1)),Y,40)'="" WRITE " ",$PIECE($GET(^WWW101(0,"EINHEIT",SPRACHE,$PIECE(^INART(YM,ART,1),Y,40),1)),Y,1)
      if (mOp.NotEqual(mOp.Positive(MENGE.get()),0)) {
        if (mOp.NotEqual(ART.get(),"")) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),ART.get(),1)),m$.var("Y").get(),40),"")) {
            m$.Cmd.Write(" ",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",0,"EINHEIT",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("^INART",m$.var("YM").get(),ART.get(),1).get(),m$.var("Y").get(),40),1)),m$.var("Y").get(),1));
          }
        }
      }
      //<< . IF YII=1 WRITE "</FONT>"
      if (mOp.Equal(YII.get(),1)) {
        m$.Cmd.Write("</FONT>");
      }
      //<< . IF ART'="" WRITE "</A>"
      if (mOp.NotEqual(ART.get(),"")) {
        m$.Cmd.Write("</A>");
      }
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< WRITE "</TD>"
    m$.Cmd.Write("</TD>");
    //<< 
    //<< /* +++++++++++++++++++++++++++++++++++++
    //<< ; "Open Orders:  #/#/#"
    //<< ; Tool Tip : "1. Customer Orders, 2. Manufacturing Orders, 3. Stock Orders"
    //<< ; Link     : Edit Open Orders/Demands/Supplies
    //<< ; ++++++++++++++++++++++++++++++++++++++ */
    //<< 
    //<< WRITE "<TD NOWRAP VALIGN=TOP>"
    m$.Cmd.Write("<TD NOWRAP VALIGN=TOP>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< 
    //<< ;AUFTRAGSANZEIGE
    //<< IF blnAuthorised DO   ;KEINE BERECHTIGUNG
    if (mOp.Logical(blnAuthorised.get())) {
      do {
        //<< . QUIT:PHANTOM=$$$YES
        if (mOp.Equal(PHANTOM.get(),include.COMSYS.$$$YES(m$))) {
          break;
        }
        //<< . NEW YBACK
        mVar YBACK = m$.var("YBACK");
        m$.newVarBlock(1,YBACK);
        //<< . WRITE "<A"
        m$.Cmd.Write("<A");
        //<< . WRITE " TITLE="_$$$DBLQUOTE_$$^WWWTEXT(32077)_$$$DBLQUOTE
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.fnc$("WWWTEXT.main",32077)),include.COMSYSString.$$$DBLQUOTE(m$)));
        //<< . WRITE " HREF="_$$$DBLQUOTE_YAKTION_"EP=WWWMANU&YFORM=INART&YEXEC=*D|^INARTIA(1)"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.var("YAKTION").get()),"EP=WWWMANU&YFORM=INART&YEXEC=*D|^INARTIA(1)"));
        //<< . SET YBACK="INART,"                               ;ULM, 03.03.03 EINGESCHALTET, WAR AUSGESCHALTET ???
        YBACK.set("INART,");
        //<< . DO ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< . WRITE $$$DBLQUOTE_">"
        m$.Cmd.Write(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),">"));
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< WRITE $$^WWWTEXT(32078)_": ",AUFTRAG   ;AUFTRAGSBESTAND ;open orders
    m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main",32078),": "),AUFTRAG.get());
    //<< 
    //<< IF blnAuthorised DO   ;KEINE BERECHTIGUNG
    if (mOp.Logical(blnAuthorised.get())) {
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< 
    //<< WRITE "&nbsp;&nbsp;&nbsp;&nbsp;"
    m$.Cmd.Write("&nbsp;&nbsp;&nbsp;&nbsp;");
    //<< WRITE "</TD>"
    m$.Cmd.Write("</TD>");
    //<< 
    //<< /* +++++++++++++++++++++++++++++++++++++
    //<< ; "Actual Offer:  #/#/#"
    //<< ; Tool Tip : "Inquiry/Offer/Cost-Based Pricing"
    //<< ; Link     : Edit Open Offers/Inquiries
    //<< ; ++++++++++++++++++++++++++++++++++++++ */
    //<< 
    //<< WRITE "<TD NOWRAP ALIGN=RIGHT VALIGN=TOP>"
    m$.Cmd.Write("<TD NOWRAP ALIGN=RIGHT VALIGN=TOP>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< 
    //<< ;ANGEBOTANZEIGE
    //<< IF blnAuthorised DO   ;KEINE BERECHTIGUNG
    if (mOp.Logical(blnAuthorised.get())) {
      do {
        //<< . QUIT:PHANTOM=$$$YES
        if (mOp.Equal(PHANTOM.get(),include.COMSYS.$$$YES(m$))) {
          break;
        }
        //<< . NEW YBACK
        mVar YBACK = m$.var("YBACK");
        m$.newVarBlock(1,YBACK);
        //<< . WRITE "<A"
        m$.Cmd.Write("<A");
        //<< . WRITE " TITLE="_$$$DBLQUOTE_$$^WWWTEXT(32177)_"/"_$$^WWWTEXT(32169)_"/"_$$^WWWTEXT(33069)_$$$DBLQUOTE
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.fnc$("WWWTEXT.main",32177)),"/"),m$.fnc$("WWWTEXT.main",32169)),"/"),m$.fnc$("WWWTEXT.main",33069)),include.COMSYSString.$$$DBLQUOTE(m$)));
        //<< . WRITE " HREF="_$$$DBLQUOTE_YAKTION_"EP=WWWMANU&YFORM=INART&YEXEC=*D|^INARTIA(2)"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.var("YAKTION").get()),"EP=WWWMANU&YFORM=INART&YEXEC=*D|^INARTIA(2)"));
        //<< . SET YBACK="INART,"  ;ULM, 03.03.03 EINGESCHALTET, WAR AUSGESCHALTET ???
        YBACK.set("INART,");
        //<< . ;SET YBACK=""  ;"INART,"
        //<< . DO ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< . WRITE $$$DBLQUOTE_">"
        m$.Cmd.Write(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),">"));
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< ;WRITE $$^WWWTEXT(33076)_" "_$$^WWWTEXT(32169)_": ",ANGEBOT ;"Actual" + "Offer"  ;ANGEBOT ;proposition
    //<< ;WRITE $$^WWWTEXT(34101)_": ",ANGEBOT                       ;"Open Offers"   ;ANGEBOT ;FIS;28.12.04;27037;EIN SPRACHENTEXT
    //<< WRITE $$^WWWTEXT("IN00386")_": ",ANGEBOT                    ;"Actual Offer"  ;ANGEBOT ;SR11392
    m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main","IN00386"),": "),ANGEBOT.get());
    //<< 
    //<< IF blnAuthorised DO   ;KEINE BERECHTIGUNG
    if (mOp.Logical(blnAuthorised.get())) {
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< 
    //<< WRITE "&nbsp;&nbsp;&nbsp;&nbsp;"
    m$.Cmd.Write("&nbsp;&nbsp;&nbsp;&nbsp;");
    //<< WRITE "</TD>"
    m$.Cmd.Write("</TD>");
    //<< 
    //<< /* +++++++++++++++++++++++++++++++++++++
    //<< ; "Supplier..."
    //<< ; Tool Tip : "Edit Suppliers Data" + supplier info
    //<< ; Link     : form INLIEF
    //<< ; ++++++++++++++++++++++++++++++++++++++ */
    //<< 
    //<< WRITE "<TD NOWRAP ALIGN=RIGHT VALIGN=TOP>"
    m$.Cmd.Write("<TD NOWRAP ALIGN=RIGHT VALIGN=TOP>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    do {
      //<< 
      //<< DO  ;LIEFERANTENANZEIGE
      //<< . QUIT:PHANTOM=$$$YES
      if (mOp.Equal(PHANTOM.get(),include.COMSYS.$$$YES(m$))) {
        break;
      }
      //<< . WRITE "</TD>"
      m$.Cmd.Write("</TD>");
      //<< . WRITE "<TD NOWRAP ALIGN=LEFT VALIGN=TOP>"
      m$.Cmd.Write("<TD NOWRAP ALIGN=LEFT VALIGN=TOP>");
      //<< . WRITE "<FONT SIZE=2>"   ;<B>"
      m$.Cmd.Write("<FONT SIZE=2>");
      //<< . WRITE "<A"
      m$.Cmd.Write("<A");
      //<< . WRITE " TITLE="_$$$DBLQUOTE_$$^WWWTEXT(32122)_":"  ;LIEFERANTENSTAMM BEARBEITEN
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.fnc$("WWWTEXT.main",32122)),":"));
      //<< . WRITE YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . NEW YBACK,YKEY,YI,LIEFSATZ,COLOR,INFO
      mVar YBACK = m$.var("YBACK");
      mVar YKEY = m$.var("YKEY");
      mVar YI = m$.var("YI");
      mVar LIEFSATZ = m$.var("LIEFSATZ");
      mVar COLOR = m$.var("COLOR");
      mVar INFO = m$.var("INFO");
      m$.newVarBlock(1,YBACK,YKEY,YI,LIEFSATZ,COLOR,INFO);
      //<< . FOR YI=1:1 SET LIEF1=$PIECE(LIEF,Y,YI) QUIT:LIEF1=""  DO
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        mVar LIEF1 = m$.var("LIEF1");
        LIEF1.set(m$.Fnc.$piece(LIEF.get(),m$.var("Y").get(),YI.get()));
        if (mOp.Equal(LIEF1.get(),"")) {
          break;
        }
        //<< . . IF LIEF1'="" DO
        if (mOp.NotEqual(LIEF1.get(),"")) {
          do {
            //<< . . . SET YKEY=LIEF1
            YKEY.set(LIEF1.get());
            //<< . . . SET INFO=""
            INFO.set("");
            //<< . . . SET COLOR=""
            COLOR.set("");
            //<< . . . SET LIEFSATZ=$GET(^INLIEF(YM,LIEF1,1))
            LIEFSATZ.set(m$.Fnc.$get(m$.var("^INLIEF",m$.var("YM").get(),LIEF1.get(),1)));
            //<< . . . IF $PIECE(LIEFSATZ,Y,8)="" QUIT  ;KURZBEZEICHNUNG
            if (mOp.Equal(m$.Fnc.$piece(LIEFSATZ.get(),m$.var("Y").get(),8),"")) {
              break;
            }
            //<< . . . ;IF +$PIECE(LIEFSATZ,Y,32)'=0 WRITE YCR,$PIECE($GET(^WWW101(0,"MARKIERUNG",SPRACHE,$PIECE(LIEFSATZ,Y,32),1)),Y,1)  ;LIEFERANTENMERKER  ;FIS,04.10.01
            //<< . . . ;IF +$PIECE(LIEFSATZ,Y,32)'=0 IF $PIECE(LIEFSATZ,Y,32)'=1 DO  ;LIEFERANTENMERKER  ;FIS,04.10.01
            //<< . . . ;. SET INFO=$PIECE($GET(^WWW101(0,"MARKIERUNG",SPRACHE,$PIECE(LIEFSATZ,Y,32),1)),Y,2)  ;FARBCODE
            //<< . . . ;. IF INFO'="" SET COLOR=$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,INFO,1)),Y,1)  ;FARBE AUS FARBCODE
            //<< . . . ;. IF COLOR'="" WRITE "<FONT COLOR="_COLOR_">"
            //<< . . . ;IF $PIECE(LIEFSATZ,Y,32)=1 W "<STRIKE>"
            //<< . . . ;;;IF $PIECE(LIEFSATZ,Y,32)=1 Q
            //<< . . . WRITE LIEF1_"  "_$EXTRACT($PIECE(LIEFSATZ,Y,8),1,30)  ;LETZTER LIEFERANT ;last supplier
            m$.Cmd.Write(mOp.Concat(mOp.Concat(LIEF1.get(),"  "),m$.Fnc.$extract(m$.Fnc.$piece(LIEFSATZ.get(),m$.var("Y").get(),8),1,30)));
            //<< . . . IF +$PIECE(LIEFSATZ,Y,32)'=0 WRITE " ("_$PIECE($GET(^WWW101(0,"MARKIERUNG",SPRACHE,$PIECE(LIEFSATZ,Y,32),1)),Y,1)_")"
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(LIEFSATZ.get(),m$.var("Y").get(),32)),0)) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" (",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",0,"MARKIERUNG",m$.var("SPRACHE").get(),m$.Fnc.$piece(LIEFSATZ.get(),m$.var("Y").get(),32),1)),m$.var("Y").get(),1)),")"));
            }
            //<< . . . WRITE YCR
            m$.Cmd.Write(m$.var("YCR").get());
          } while (false);
        }
      }
      //<< . . . ;IF +$PIECE(LIEFSATZ,Y,32)'=0 IF $PIECE(LIEFSATZ,Y,32)'=1 IF COLOR'="" WRITE "</FONT>"
      //<< . . . ;IF $PIECE(LIEFSATZ,Y,32)=1 W "</STRIKE>"
      //<< . ;
      //<< . WRITE $$$DBLQUOTE
      m$.Cmd.Write(include.COMSYSString.$$$DBLQUOTE(m$));
      //<< . WRITE " HREF="_$$$DBLQUOTE_YAKTION_"EP=WWWFORM&YFORM=INLIEF&YKEY="_LIEF1
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.var("YAKTION").get()),"EP=WWWFORM&YFORM=INLIEF&YKEY="),m$.var("LIEF1").get()));
      //<< . ;S YBACK="INART,"
      //<< . SET YBACK=""
      YBACK.set("");
      //<< . DO ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< . WRITE $$$DBLQUOTE_">"
      m$.Cmd.Write(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),">"));
      //<< . ;WRITE $$^WWWTEXT(32831)_" "_$$^WWWTEXT(32022)_"..."
      //<< . WRITE $$^WWWTEXT(32022)_"..."
      m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWTEXT.main",32022),"..."));
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< /*
    //<< . ;
    //<< . ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
    //<< . . ;
    //<< . . . WRITE "&nbsp;"
    //<< . . . DO  ;INFO ATIKEL BEI LIEFEANT ;next to
    //<< . . . . NEW YARTIKEL,YURL
    //<< . . . . SET YURL=$PIECE(LIEFSATZ,Y,119)  ;URL DER ARTIKELBESTÄNDE
    //<< . . . . QUIT:YURL=""
    //<< . . . . ; TODO : If this code is re-activated it is necessary to base on INARTK D8 instead of D1
    //<< . . . . ;        see routine INARTTRACK  <GRF> SR12027
    //<< . . . . SET YARTIKEL=$TRANSLATE($PIECE($$$INARTKProductDescription($GET(^INARTK(YM,ART,LIEF1,1))),"|",1)," ")
    //<< . . . . WRITE YCR
    //<< . . . . SET YURL=YURL_YARTIKEL
    //<< . . . . WRITE "<A HREF="
    //<< . . . . WRITE "http://"_YURL
    //<< . . . . WRITE " TARGET=ARTTIKELINFO"
    //<< . . . . WRITE ">"
    //<< . . . . ; 32196 : "Item Information From Supplier"
    //<< . . . . WRITE YCR,"<IMG SRC="_$$$DBLQUOTE_YGIF_"left.gif"_$$$DBLQUOTE_" BORDER=0 TITLE='"_$$^WWWTEXT(32196)_"'></A>"
    //<< . . . . WRITE "&nbsp;"
    //<< . . . ;
    //<< . . . WRITE "&nbsp;"
    //<< . . . IF $PIECE(LIEF,Y,YI+1)'="" WRITE "<BR>"
    //<< ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
    //<< */
    //<< 
    //<< WRITE "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
    m$.Cmd.Write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    //<< WRITE "</TD>"
    m$.Cmd.Write("</TD>");
    //<< 
    //<< /* +++++++++++++++++++++++++++++++++++++
    //<< ; "No Level In Item" -or- "Contains Level"
    //<< ; Tool Tip : "Display Item Level"
    //<< ; Link     : form INARTT1
    //<< ; ++++++++++++++++++++++++++++++++++++++ */
    //<< 
    //<< WRITE "<TD NOWRAP ALIGN=RIGHT VALIGN=TOP>"
    m$.Cmd.Write("<TD NOWRAP ALIGN=RIGHT VALIGN=TOP>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< IF ART'="" DO                  ;I $DATA(^INARTT(YM,ART)) D  ;ANZEIGE LINK ARTIKELTEILE
    if (mOp.NotEqual(ART.get(),"")) {
      //<< . NEW YBACK,YPARA
      mVar YBACK = m$.var("YBACK");
      mVar YPARA = m$.var("YPARA");
      m$.newVarBlock(1,YBACK,YPARA);
      //<< . SET YPARA=","  ;HAUPTTEIL
      YPARA.set(",");
      //<< . WRITE "<A"
      m$.Cmd.Write("<A");
      //<< . WRITE " TITLE="_$$$DBLQUOTE_$$^WWWTEXT(32123)_$$$DBLQUOTE  ;TEILE
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.fnc$("WWWTEXT.main",32123)),include.COMSYSString.$$$DBLQUOTE(m$)));
      //<< . WRITE " HREF="_$$$DBLQUOTE_YAKTION_"EP=WWWFORM&YFORM=INARTT1"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.var("YAKTION").get()),"EP=WWWFORM&YFORM=INARTT1"));
      //<< . SET YBACK="INART,"
      YBACK.set("INART,");
      //<< . DO ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< . WRITE $$$DBLQUOTE_">"
      m$.Cmd.Write(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),">"));
      //<< . IF '$DATA(^INARTT(YM,ART)) WRITE $$^WWWTEXT(32019)   ; KEINE TEILE ;no sub-parts
      if (mOp.Not(m$.Fnc.$data(m$.var("^INARTT",m$.var("YM").get(),ART.get())))) {
        m$.Cmd.Write(m$.fnc$("WWWTEXT.main",32019));
      }
      //<< . IF $DATA(^INARTT(YM,ART))  WRITE $$^WWWTEXT(32014)   ; "ARTIKELDATEI VORHANDEN"
      if (mOp.Logical(m$.Fnc.$data(m$.var("^INARTT",m$.var("YM").get(),ART.get())))) {
        m$.Cmd.Write(m$.fnc$("WWWTEXT.main",32014));
      }
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
    }
    m$.restoreVarBlock(1);
    //<< WRITE "</TD>"
    m$.Cmd.Write("</TD>");
    //<< 
    //<< /* +++++++++++++++++++++++++++++++++++++
    //<< ; "Item is a Part" -or- "Item is not a Part"
    //<< ; Tool Tip : "Display Parent Item"
    //<< ; Link     : form INARTIU
    //<< ; ++++++++++++++++++++++++++++++++++++++ */
    //<< 
    //<< WRITE "<TD NOWRAP VALIGN=TOP>"
    m$.Cmd.Write("<TD NOWRAP VALIGN=TOP>");
    //<< WRITE "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< IF ART'="" IF ART'=" " DO  ;ARTIKEL SELBER EIN TEIL? ;is item a part?
    if (mOp.NotEqual(ART.get(),"")) {
      if (mOp.NotEqual(ART.get()," ")) {
        //<< . NEW YBACK
        mVar YBACK = m$.var("YBACK");
        m$.newVarBlock(1,YBACK);
        //<< . WRITE "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        m$.Cmd.Write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        //<< . WRITE "<A"
        m$.Cmd.Write("<A");
        //<< . WRITE " TITLE="_$$$DBLQUOTE_$$^WWWTEXT(32124)_$$$DBLQUOTE   ;TEILE
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.fnc$("WWWTEXT.main",32124)),include.COMSYSString.$$$DBLQUOTE(m$)));
        //<< . WRITE " HREF="_$$$DBLQUOTE_YAKTION_"EP=WWWMANU&YFORM=INART&YEXEC=*D|^INARTIU"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=",include.COMSYSString.$$$DBLQUOTE(m$)),m$.var("YAKTION").get()),"EP=WWWMANU&YFORM=INART&YEXEC=*D|^INARTIU"));
        //<< . SET YBACK="INART,"
        YBACK.set("INART,");
        //<< . DO ^WWWCGI
        m$.Cmd.Do("WWWCGI.main");
        //<< . WRITE $$$DBLQUOTE_">"
        m$.Cmd.Write(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),">"));
        //<< . IF $DATA(^INARTTs(YM,1,$$^WWWUMLAU(ART,1)))  WRITE $$^WWWTEXT(32073)   ;ARTIKEL IST EIN UNTERTEIL
        if (mOp.Logical(m$.Fnc.$data(m$.var("^INARTTs",m$.var("YM").get(),1,m$.fnc$("WWWUMLAU.main",ART.get(),1))))) {
          m$.Cmd.Write(m$.fnc$("WWWTEXT.main",32073));
        }
        //<< . IF '$DATA(^INARTTs(YM,1,$$^WWWUMLAU(ART,1))) WRITE $$^WWWTEXT(32074)   ;ARTIKEL IST KEIN UNTERTEIL
        if (mOp.Not(m$.Fnc.$data(m$.var("^INARTTs",m$.var("YM").get(),1,m$.fnc$("WWWUMLAU.main",ART.get(),1))))) {
          m$.Cmd.Write(m$.fnc$("WWWTEXT.main",32074));
        }
        //<< . WRITE "</A>"
        m$.Cmd.Write("</A>");
      }
      m$.restoreVarBlock(1);
    }
    //<< WRITE "</TD>"
    m$.Cmd.Write("</TD>");
    //<< 
    //<< ; ++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< WRITE "<TR>"
    m$.Cmd.Write("<TR>");
    //<< WRITE "</TABLE>"
    m$.Cmd.Write("</TABLE>");
    //<< 
    //<< /* vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
    //<< ;
    //<< ; "Item Parts have been changed. Please recreate structure."
    //<< ;
    //<< ;IF $PIECE(^INVORG(YM,YM,1),Y,121)'=1 DO   ;ARTIKEL nicht UPTO DATE
    //<< . WRITE "<TABLE BORDER=0 CELLSPACING=0>"
    //<< . WRITE "<TR COLSPAN=5>"
    //<< . WRITE "<TD NOWRAP VALIGN=TOP COLSPAN=7>"
    //<< . WRITE "<FONT SIZE=2><B>"
    //<< . WRITE "<FONT COLOR="_YRED_">"
    //<< . WRITE $$^WWWTEXT(33274)  ;ARTIKEL NICHT UPTODATE BITTE AUFBEREITUNGSLAUF STARTEN"
    //<< . WRITE "<B>"
    //<< . WRITE "</TD>"
    //<< . WRITE "</TR>"
    //<< . WRITE "</TABLE>"
    //<< . QUIT
    //<< ; ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END */
    //<< 
    //<< QUIT
    return;
  }

//<< 
//<< 
//<< 
//<< /* vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
//<< 
//<< ;  -----ALT -------   ; Old code
//<< 
//<< DO  ;LIEFERANTENANZEIGE
//<< . QUIT:PHANTOM=1
//<< . WRITE $$^WWWTEXT(32022)_"..."
//<< . WRITE "</TD>"
//<< . WRITE "<TD NOWRAP ALIGN=LEFT VALIGN=TOP>"
//<< . WRITE "<FONT SIZE=2>"   ;<B>"
//<< . NEW YBACK,YKEY,YI,LIEFSATZ,COLOR,INFO
//<< . FOR YI=1:1 SET LIEF1=$PIECE(LIEF,Y,YI) QUIT:LIEF1=""  DO
//<< . . IF LIEF1'="" DO
//<< . . . SET YKEY=LIEF1
//<< . . . SET INFO=""
//<< . . . SET COLOR=""
//<< . . . SET LIEFSATZ=$GET(^INLIEF(YM,LIEF1,1))
//<< . . . IF $PIECE(LIEFSATZ,Y,8)="" QUIT  ;KURZBEZEICHNUNG
//<< . . . WRITE "<A"
//<< . . . WRITE " TITLE="_""""_$$^WWWTEXT(32122)  ;LIEFERANTENSTAMM BEARBEITEN
//<< . . . IF +$PIECE(LIEFSATZ,Y,32)'=0 WRITE YCR,$PIECE($GET(^WWW101(0,"MARKIERUNG",SPRACHE,$PIECE(LIEFSATZ,Y,32),1)),Y,1)  ;LIEFERANTENMERKER  ;FIS,04.10.01
//<< . . . WRITE """"
//<< . . . WRITE " HREF="_""""_YAKTION_"EP=WWWFORM&YFORM=INLIEF"
//<< . . . ;S YBACK="INART,"
//<< . . . SET YBACK=""
//<< . . . DO ^WWWCGI
//<< . . . WRITE """"_">"
//<< . . . IF +$PIECE(LIEFSATZ,Y,32)'=0 IF $PIECE(LIEFSATZ,Y,32)'=1 DO  ;LIEFERANTENMERKER  ;FIS,04.10.01
//<< . . . . SET INFO=$PIECE($GET(^WWW101(0,"MARKIERUNG",SPRACHE,$PIECE(LIEFSATZ,Y,32),1)),Y,2)  ;FARBCODE
//<< . . . . IF INFO'="" SET COLOR=$PIECE($GET(^WWW100(0,"FARBE",SPRACHE,INFO,1)),Y,1)  ;FARBE AUS FARBCODE ;tincture out of
//<< . . . . IF COLOR'="" WRITE "<FONT COLOR="_COLOR_">"
//<< . . . ;
//<< . . . IF $PIECE(LIEFSATZ,Y,32)=1 W "<STRIKE>"
//<< . . . WRITE $EXTRACT($PIECE(LIEFSATZ,Y,8),1,12)    ;LETZTER LIEFERANT ;last purveyor
//<< . . . IF +$PIECE(LIEFSATZ,Y,32)'=0 IF $PIECE(LIEFSATZ,Y,32)'=1 IF COLOR'="" WRITE "</FONT>"
//<< . . . IF $PIECE(LIEFSATZ,Y,32)=1 W "</STRIKE>"
//<< . . . WRITE "</A>"
//<< . . . WRITE "&nbsp;"
//<< . . . DO  ;INFO ATIKEL BEI LIEFEANT ;next to
//<< . . . . NEW YARTIKEL,YURL
//<< . . . . SET YURL=$PIECE(LIEFSATZ,Y,119)  ;URL DER ARTIKELBESTÄNDE ;URL the
//<< . . . . QUIT:YURL=""
//<< . . . . ; TODO : If this code is re-activated it is necessary to base on INARTK D8 ahead of D1
//<< . . . . ;        see routine INARTTRACK  <GRF> SR12027
//<< . . . . SET YARTIKEL=$TRANSLATE($PIECE($$$INARTKProductDescription($GET(^INARTK(YM,ART,LIEF1,1))),"|",1)," ")
//<< . . . . WRITE YCR
//<< . . . . SET YURL=YURL_YARTIKEL
//<< . . . . WRITE "<A HREF="
//<< . . . . WRITE "http://"_YURL
//<< . . . . WRITE " TARGET=ARTTIKELINFO"
//<< . . . . WRITE ">"
//<< . . . . WRITE YCR,"<IMG SRC="_""""_YGIF_"left.gif"_""""_" BORDER=0 TITLE='"_$$^WWWTEXT(32196)_"'></A>"
//<< . . . . WRITE "&nbsp;"
//<< . . . WRITE "&nbsp;"
//<< . . . IF $PIECE(LIEF,Y,YI+1)'="" WRITE "<BR>"
//<< ; ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END */
//<< 
//<< 
}
