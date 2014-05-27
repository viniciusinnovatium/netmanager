//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM75
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:42
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

//<< WWWFORM75
public class WWWFORM75 extends mClass {

  public void main() {
    _WWWFORM75();
  }

  public void _WWWFORM75() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       PARAMETERSUCHE
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
    //<< ; 02-Sep-2005   JW      SR12966: WWW120 is shared
    //<< ; 04-APR-2005   TYBD    IDs FOR BUTTON ADDED FOR TESTDIRECTOR
    //<< ; 30,01,2004    TYBD
    //<< ;-------------------------------------------------------------------------------
    //<< quit
    return;
  }

  //<< 
  //<< PARASUCHNEW ; DO NOT USE - Retained as legacy entry point - should not be needed
  public void PARASUCHNEW() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Parameter Search function
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 11-Jan-2010   GRF     Remove commented code; swap tags & call to reduce steps
    //<< ; 15-Feb-2008   GRF     Moved quit before commented code for performance
    //<< ; 25-Jun-2007   shobby  SRBR014409: Call out to rewritten version.
    //<< ; 01-Sep-2006   JW      SR14985: Fire on blur event instead of focus or savenow.
    //<< ; 15-Dec-2005   JW      SR13195: Don't call BEARB here
    //<< ; 23-Aug-2005   JW      SR12876: Also do parameter search for files.
    //<< ; 14-Jul-2005   JW      SR12963: Field colour was being set to white. Removed.
    //<< ;-------------------------------------------------------------------------------
    //<< do PARASUCH
    m$.Cmd.Do("PARASUCH");
    //<< quit
    return;
  }

  //<< 
  //<< PARASUCH
  public void PARASUCH() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Parameter Search function
    //<< ;
    //<< ; History:
    //<< ; 22-May-2013   shobby  CORE-107.1: YPOPUP parameter to mark a form opened in a popup window.
    //<< ; 19-Jun-2012   shobby  SR17790: If dialog closing from a timeout, then close the parent window.
    //<< ; 23-Jul-2007   RPW     SRBR014600: Do not restrict scrolling on the COMView.
    //<< ;                           Get the width and height via a callback to check the
    //<< ;                           COMViewUserSize global
    //<< ; 06-Jul-2007   RPW     SRBR014409: Call structure instead of the if 1 {} block
    //<< ; 05-Jul-2007   shobby  SRBR014409: MSIE test replaced. Avoid multiple calls to UMLAU
    //<< ; 08-Jun-2007   shobby  SRBR014409: Rewrote
    //<< ; 01-Sep-2006   JW      SR14985: Fire on blur event instead of focus or savenow.
    //<< ; 15-Dec-2005   JW      SR13195: Don't call BEARB here
    //<< ; 23-Aug-2005   JW      SR12876: Also do parameter search for files.
    //<< ; 14-Jul-2005   JW      SR12963: Field colour was being set to white. Removed.
    //<< ; 07.12.2004    FIS     26951
    //<< ;-------------------------------------------------------------------------------
    //<< new lstJS1,lstJS2,strField,strJS,strLinkType,STRUCT
    mVar lstJS1 = m$.var("lstJS1");
    mVar lstJS2 = m$.var("lstJS2");
    mVar strField = m$.var("strField");
    mVar strJS = m$.var("strJS");
    mVar strLinkType = m$.var("strLinkType");
    mVar STRUCT = m$.var("STRUCT");
    m$.newVar(lstJS1,lstJS2,strField,strJS,strLinkType,STRUCT);
    //<< 
    //<< if (YHID'=1) && ((+$$$WWW122RelationWithSearchFuncti(YSATZ)'=0) || (YTYPE="FILENAME")) {   ;PARAMETERSUCHE
    if ((mOp.NotEqual(m$.var("YHID").get(),1)) && mOp.Logical(((mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW122RelationWithSearchFuncti(m$,m$.var("YSATZ"))),0)) || (mOp.Equal(m$.var("YTYPE").get(),"FILENAME"))))) {
      //<< write YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< set STRUCT = ""
      STRUCT.set("");
      //<< set lstJS1 = ""
      lstJS1.set("");
      //<< set lstJS2 = ""
      lstJS2.set("");
      //<< set strLinkStart = ""
      mVar strLinkStart = m$.var("strLinkStart");
      strLinkStart.set("");
      //<< set strLinkEnd   = ""
      mVar strLinkEnd = m$.var("strLinkEnd");
      strLinkEnd.set("");
      //<< do SearchStructure(.STRUCT)
      m$.Cmd.Do("SearchStructure",STRUCT);
      //<< set strField="Y"_YFORM_YART_YLFN
      strField.set(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()));
      //<< if STRUCT'="" {
      if (mOp.NotEqual(STRUCT.get(),"")) {
        //<< set strLinkType = "HREF"
        strLinkType.set("HREF");
        //<< set URL = YAKTION_"EP=WWWMANU&amp;YEXEC=*D|^WWWPARAEXPL&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"&amp;YTRAKT="_YTRAKT
        mVar URL = m$.var("URL");
        URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWMANU&amp;YEXEC=*D|^WWWPARAEXPL&amp;YUSER="),m$.var("YUSER").get()),"&amp;YBED="),m$.var("YBED").get()),"&amp;YTRAKT="),m$.var("YTRAKT").get()));
        //<< set URL = URL_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM_"&amp;YKEY="_YKEY_"&amp;YBACK="_YBACK_"&amp;YLFDAT="_strField
        URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(URL.get(),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()),"&amp;YKEY="),m$.var("YKEY").get()),"&amp;YBACK="),m$.var("YBACK").get()),"&amp;YLFDAT="),strField.get()));
        //<< set URL = URL_"&amp;YLFFORM="_$get(YBBN)_"&amp;YFORM="_YFORM_"&amp;YPARA="_STRUCT
        URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(URL.get(),"&amp;YLFFORM="),m$.Fnc.$get(m$.var("YBBN"))),"&amp;YFORM="),m$.var("YFORM").get()),"&amp;YPARA="),STRUCT.get()));
        //<< set URL = URL_"&amp;YPOPUP=1" ;CORE-107.1
        URL.set(mOp.Concat(URL.get(),"&amp;YPOPUP=1"));
        //<< set OPT = "HEIGHT=500,WIDTH=400,SCROLLBARS=YES,RESIZEABLE=YES"
        mVar OPT = m$.var("OPT");
        OPT.set("HEIGHT=500,WIDTH=400,SCROLLBARS=YES,RESIZEABLE=YES");
        //<< set lstJS1 = $listbuild("var parameter=window.open('"_URL_"','Stucture','"_OPT_"');")
        lstJS1.set(m$.Fnc.$listbuild(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("var parameter=window.open('",URL.get()),"','Stucture','"),OPT.get()),"');")));
      }
      //<< 
      //<< } else {
      else {
        //<< set strLinkType = "class"
        strLinkType.set("class");
        //<< set strJS = $$$GetSizeEvent(Y,strField)
        strJS.set(include.COMSYS.$$$GetSizeEvent(m$,m$.var("Y"),strField));
        //<< 
        //<< set URL = YAKTION_"EP=WWWFORM&amp;YFORM=WWWPARA&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"&amp;YTRAKT="_YTRAKT
        mVar URL = m$.var("URL");
        URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM=WWWPARA&amp;YUSER="),m$.var("YUSER").get()),"&amp;YBED="),m$.var("YBED").get()),"&amp;YTRAKT="),m$.var("YTRAKT").get()));
        //<< set URL = URL_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM_"&amp;YLFDAT="_strField_"&amp;YLFFORM="_$get(YBBN)
        URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(URL.get(),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()),"&amp;YLFDAT="),strField.get()),"&amp;YLFFORM="),m$.Fnc.$get(m$.var("YBBN"))));
        //<< set URL = URL_"&amp;YPOPUP=1" ;CORE-107.1
        URL.set(mOp.Concat(URL.get(),"&amp;YPOPUP=1"));
        //<< if ($get(YUSERAGENT)="MSIE") || ($get(YUSERAGENT)="") {
        if ((mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) || (mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),""))) {
          //<< set lstJS1 = lstJS1_$listbuild("var jetzt=new Date();")
          lstJS1.set(mOp.Concat(lstJS1.get(),m$.Fnc.$listbuild("var jetzt=new Date();")));
          //<< 
          //<< ;---------------------------------------
          //<< ;   FIXME : <GRF> I believe "&YSEC"  below should be "&amp;YSEC" to match contents of URL.
          //<< ;                 Not subsequently being converted.  NOTE - similar changes were reverted due to FF issues.
          //<< ;---------------------------------------
          //<< ;if YBED["SHOBBY" set strJS=strJS_" alert(1); "
          //<< set strJS  = strJS_"result = window.showModalDialog('"_URL_"&YSEC='+ jetzt.getSeconds() ,'Parameter',"
          strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"result = window.showModalDialog('"),URL.get()),"&YSEC='+ jetzt.getSeconds() ,'Parameter',"));
          //<< ; e.g.      set strJS  = strJS_"result = window.showModalDialog('"_URL_"&amp;YSEC='+ jetzt.getSeconds() ,'Parameter',"
          //<< set strJS  = strJS_"'DialogWidth:'+ "_strField_"Width+'px; DialogHeight: '+"_strField
          strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"'DialogWidth:'+ "),strField.get()),"Width+'px; DialogHeight: '+"),strField.get()));
          //<< set strJS  = strJS_"Height+'px; resizable: yes; status: no; help: no;');"
          strJS.set(mOp.Concat(strJS.get(),"Height+'px; resizable: yes; status: no; help: no;');"));
        }
        //<< } else {
        else {
          //<< set strJS = strJS_"result = newModalDialog('"_URL_"','Parameter',"_strField_"Height,"_strField_"Width,'yes');"
          strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"result = newModalDialog('"),URL.get()),"','Parameter',"),strField.get()),"Height,"),strField.get()),"Width,'yes');"));
        }
        //<< }
        //<< set strJS  = strJS_"if (result=='## timeout ##') {"                         ;SR17790
        strJS.set(mOp.Concat(strJS.get(),"if (result=='## timeout ##') {"));
        //<< set strJS  = strJS_"  result='';"                                           ;SR17790
        strJS.set(mOp.Concat(strJS.get(),"  result='';"));
        //<< set strJS  = strJS_"  CSPLogout(); "                                        ;SR17790
        strJS.set(mOp.Concat(strJS.get(),"  CSPLogout(); "));
        //<< set strJS  = strJS_"}"                                                      ;SR17790
        strJS.set(mOp.Concat(strJS.get(),"}"));
        //<< set lstJS1 = lstJS1_$listbuild(strJS)
        lstJS1.set(mOp.Concat(lstJS1.get(),m$.Fnc.$listbuild(strJS.get())));
      }
      //<< }
      //<< write $$CreateOnClick^WWWBUTTON(strField,"search1.gif",$$^WWWTEXT(148),"BUTTON_SEARCH"_YLFN,lstJS1,lstJS2,strLinkType)
      m$.Cmd.Write(m$.fnc$("WWWBUTTON.CreateOnClick",strField.get(),"search1.gif",m$.fnc$("WWWTEXT.main",148),mOp.Concat("BUTTON_SEARCH",m$.var("YLFN").get()),lstJS1.get(),lstJS2.get(),strLinkType.get()));
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< SearchStructure(&pstrStructure)
  public Object SearchStructure(Object ... _p) {
    mVar pstrStructure = m$.newVarRef("pstrStructure",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the data structure for the search if it exists.
    //<< ;
    //<< ; Inputs:
    //<< ; pstrStructure: The structure we found if any
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Jul-2007   RPW     SRBR014409: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new REL,FIX,NR,idxYMUMLAU,idxRELUMLAU
    mVar REL = m$.var("REL");
    mVar FIX = m$.var("FIX");
    mVar NR = m$.var("NR");
    mVar idxYMUMLAU = m$.var("idxYMUMLAU");
    mVar idxRELUMLAU = m$.var("idxRELUMLAU");
    m$.newVar(REL,FIX,NR,idxYMUMLAU,idxRELUMLAU);
    //<< 
    //<< set REL = $piece($get(YDVOR),Y,8)
    REL.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YDVOR")),m$.var("Y").get(),8));
    //<< set FIX = $piece($get(YDVOR),Y,9)
    FIX.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YDVOR")),m$.var("Y").get(),9));
    //<< if REL="" set YREL = $piece(YSATZ,Y,32)  ;FIXME : Should this be REL?
    if (mOp.Equal(REL.get(),"")) {
      mVar YREL = m$.var("YREL");
      YREL.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),32));
    }
    //<< if FIX="" set FIX  = $piece(YSATZ,Y,33)
    if (mOp.Equal(FIX.get(),"")) {
      FIX.set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),33));
    }
    //<< if (REL'="") {
    if ((mOp.NotEqual(REL.get(),""))) {
      //<< set idxYMUMLAU  = $$$Index(YM)
      idxYMUMLAU.set(include.MEDConst.$$$Index(m$,m$.var("YM")));
      //<< set idxRELUMLAU = $$$Index(REL)
      idxRELUMLAU.set(include.MEDConst.$$$Index(m$,REL));
      //<< if ($data(^WWWSTRUKTURs(0,1,idxYMUMLAU,idxRELUMLAU))) {
      if (mOp.Logical((m$.Fnc.$data(m$.var("^WWWSTRUKTURs",0,1,idxYMUMLAU.get(),idxRELUMLAU.get()))))) {
        //<< set NR = ""
        NR.set("");
        //<< for {
        for (;true;) {
          //<< set NR = $order(^WWWSTRUKTURs(0,1,idxYMUMLAU,idxRELUMLAU,YM,NR))
          NR.set(m$.Fnc.$order(m$.var("^WWWSTRUKTURs",0,1,idxYMUMLAU.get(),idxRELUMLAU.get(),m$.var("YM").get(),NR.get())));
          //<< quit:NR=""
          if (mOp.Equal(NR.get(),"")) {
            break;
          }
          //<< 
          //<< if $piece($get(^WWWSTRUKTUR(0,YM,NR,1)),Y,2)=FIX set pstrStructure = NR
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWSTRUKTUR",0,m$.var("YM").get(),NR.get(),1)),m$.var("Y").get(),2),FIX.get())) {
            pstrStructure.set(NR.get());
          }
          //<< quit:pstrStructure'=""
          if (mOp.NotEqual(pstrStructure.get(),"")) {
            break;
          }
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
  //<< READONLY ;bei onchange=readOnly ANDERER FELDER ;next to other
  public void READONLY() {
    //<< if $piece($get(^WWW012(0,YM,1)),Y,82)=1 if $piece($get(^WWW120(0,YFORM,1)),Y,82)=1  quit  ;DURCH EVENTBROKER BEI STÄND. FELDBVALIDIERUNG
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),82),1)) {
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),82),1)) {
        return;
      }
    }
    //<< new HIDDENF,TRIGGER,LFN1,TRIGGERN,TRIGGER1
    mVar HIDDENF = m$.var("HIDDENF");
    mVar TRIGGER = m$.var("TRIGGER");
    mVar LFN1 = m$.var("LFN1");
    mVar TRIGGERN = m$.var("TRIGGERN");
    mVar TRIGGER1 = m$.var("TRIGGER1");
    m$.newVar(HIDDENF,TRIGGER,LFN1,TRIGGERN,TRIGGER1);
    //<< set TRIGGER1 = $translate($piece(YSATZ,Y,84),";",",")
    TRIGGER1.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),84),";",","));
    //<< set HIDDENF  = $translate($piece(YSATZ,Y,82),";",",")
    HIDDENF.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),82),";",","));
    //<< quit:HIDDENF=""
    if (mOp.Equal(HIDDENF.get(),"")) {
      return;
    }
    //<< 
    //<< write YCR," onChange='"
    m$.Cmd.Write(m$.var("YCR").get()," onChange='");
    //<< for TRIGGERN=1:1 set TRIGGER=$piece(TRIGGER1,",",TRIGGERN) do  quit:$piece(TRIGGER1,",",TRIGGERN+1)=""  ;ALLE TRIGGER AUSWERTEN
    for (TRIGGERN.set(1);(true);TRIGGERN.set(mOp.Add(TRIGGERN.get(),1))) {
      TRIGGER.set(m$.Fnc.$piece(TRIGGER1.get(),",",TRIGGERN.get()));
      //<< . set OPERA=TRIGGER
      mVar OPERA = m$.var("OPERA");
      OPERA.set(TRIGGER.get());
      //<< . for %II=1:1:$length(OPERA) do  ;RAUSFILTER DER VERGLEICHSOPERATOREN ;the
      for (m$.var("%II").set(1);(mOp.LessOrEqual(m$.var("%II").get(),m$.Fnc.$length(OPERA.get())));m$.var("%II").set(mOp.Add(m$.var("%II").get(),1))) {
        //<< . . if '$find("'<>=",$extract(OPERA,%II)) set $extract(OPERA,%II)="#"
        if (mOp.Not(m$.Fnc.$find("'<>=",m$.Fnc.$extract(OPERA.get(),m$.var("%II").get())))) {
          mVar $extract = m$.var("$extract");
          $extract.var(OPERA.get(),m$.var("%II").get()).set("#");
        }
      }
      //<< . ;
      //<< . set OPERA=$translate(OPERA,"#")  ;NUR VERGLIECHSOPERATOREN ERLAUBT ;only permissive
      OPERA.set(m$.Fnc.$translate(OPERA.get(),"#"));
      //<< . if TRIGGER="" if YTYP'=2 write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value != """")"
      if (mOp.Equal(TRIGGER.get(),"")) {
        if (mOp.NotEqual(m$.var("YTYP").get(),2)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value != \"\")"));
        }
      }
      //<< . if TRIGGER="" if YTYP=2  write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".checked == true)"  ;READONLY BEI CHECKBOXEN
      if (mOp.Equal(TRIGGER.get(),"")) {
        if (mOp.Equal(m$.var("YTYP").get(),2)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".checked == true)"));
        }
      }
      //<< . if (OPERA="")||(OPERA="=") if TRIGGER'=""    write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value == """_$translate(TRIGGER,"=")_""")"
      if ((mOp.Equal(OPERA.get(),"")) || (mOp.Equal(OPERA.get(),"="))) {
        if (mOp.NotEqual(TRIGGER.get(),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value == \""),m$.Fnc.$translate(TRIGGER.get(),"=")),"\")"));
        }
      }
      //<< . if TRIGGER="'"                               write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value == """")"
      if (mOp.Equal(TRIGGER.get(),"'")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value == \"\")"));
      }
      //<< . if OPERA="'"  if $extract(TRIGGER,2,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value != """_$extract(TRIGGER,2,999)_""")"
      if (mOp.Equal(OPERA.get(),"'")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,999),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value != \""),m$.Fnc.$extract(TRIGGER.get(),2,999)),"\")"));
        }
      }
      //<< . ;NEU GRÖßER/KLEINER/NICHT GLEICH ;recent without delay
      //<< . if OPERA="'=" if $extract(TRIGGER,3,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value != """_$extract(TRIGGER,3,999)_""")"
      if (mOp.Equal(OPERA.get(),"'=")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,999),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value != \""),m$.Fnc.$extract(TRIGGER.get(),3,999)),"\")"));
        }
      }
      //<< . if OPERA="<"  if $extract(TRIGGER,2,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value < "_$extract(TRIGGER,2,999)_")"
      if (mOp.Equal(OPERA.get(),"<")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,999),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value < "),m$.Fnc.$extract(TRIGGER.get(),2,999)),")"));
        }
      }
      //<< . if OPERA=">"  if $extract(TRIGGER,2,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value > "_$extract(TRIGGER,2,999)_")"
      if (mOp.Equal(OPERA.get(),">")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,999),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value > "),m$.Fnc.$extract(TRIGGER.get(),2,999)),")"));
        }
      }
      //<< . if OPERA="'<" if $extract(TRIGGER,3,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value >= "_$extract(TRIGGER,3,999)_")"
      if (mOp.Equal(OPERA.get(),"'<")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,999),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value >= "),m$.Fnc.$extract(TRIGGER.get(),3,999)),")"));
        }
      }
      //<< . if OPERA="'>" if $extract(TRIGGER,3,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value <= "_$extract(TRIGGER,3,999)_")"
      if (mOp.Equal(OPERA.get(),"'>")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,999),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value <= "),m$.Fnc.$extract(TRIGGER.get(),3,999)),")"));
        }
      }
      //<< . ;
      //<< . write "{"
      m$.Cmd.Write("{");
      //<< . for HIDDENF(1)=1:1 set HIDDENF(2)=$piece(HIDDENF,",",HIDDENF(1)) quit:HIDDENF(2)=""  do
      for (m$.var("HIDDENF",1).set(1);(true);m$.var("HIDDENF",1).set(mOp.Add(m$.var("HIDDENF",1).get(),1))) {
        HIDDENF.var(2).set(m$.Fnc.$piece(HIDDENF.get(),",",HIDDENF.var(1).get()));
        if (mOp.Equal(HIDDENF.var(2).get(),"")) {
          break;
        }
        //<< . . set YLFN1 = $piece($get(^WWW122(0,YFORM,HIDDENF(2),1)),Y,1)  ;datenfeld
        mVar YLFN1 = m$.var("YLFN1");
        YLFN1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),HIDDENF.var(2).get(),1)),m$.var("Y").get(),1));
        //<< . . if YLFN1="" set YLFN1=HIDDENF(2)
        if (mOp.Equal(YLFN1.get(),"")) {
          YLFN1.set(HIDDENF.var(2).get());
        }
        //<< . . if $piece(YVOR,Y,77)'="" write "document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN1_".style.background="""_$piece($get(^WWW100(0,"FARBE",SPRACHE,$piece(YVOR,Y,77),1)),Y,1)_""";"
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),77),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),YLFN1.get()),".style.background=\""),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),77),1)),m$.var("Y").get(),1)),"\";"));
        }
        //<< . . write "document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN1_".readOnly=true;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),YLFN1.get()),".readOnly=true;"));
        //<< . . if YART="M" write "document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN1_".value="""";"  ;FELDINHALT LÖSCHEN
        if (mOp.Equal(m$.var("YART").get(),"M")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),YLFN1.get()),".value=\"\";"));
        }
      }
      //<< . write "}"
      m$.Cmd.Write("}");
      //<< . ;
      //<< . if TRIGGER="" if YTYP'=2 write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value =="""")"
      if (mOp.Equal(TRIGGER.get(),"")) {
        if (mOp.NotEqual(m$.var("YTYP").get(),2)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value ==\"\")"));
        }
      }
      //<< . if TRIGGER="" if YTYP=2  write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".checked == false)"  ;READONLY BEI CHECKBOXEN
      if (mOp.Equal(TRIGGER.get(),"")) {
        if (mOp.Equal(m$.var("YTYP").get(),2)) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".checked == false)"));
        }
      }
      //<< . if OPERA=""   if TRIGGER'=""                write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value != """_$translate(TRIGGER,"'")_""")"
      if (mOp.Equal(OPERA.get(),"")) {
        if (mOp.NotEqual(TRIGGER.get(),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value != \""),m$.Fnc.$translate(TRIGGER.get(),"'")),"\")"));
        }
      }
      //<< . if OPERA="'"  if $extract(TRIGGER,2,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value =="""_$translate(TRIGGER,"'")_""")"
      if (mOp.Equal(OPERA.get(),"'")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,99),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value ==\""),m$.Fnc.$translate(TRIGGER.get(),"'")),"\")"));
        }
      }
      //<< . if OPERA="'=" if $extract(TRIGGER,3,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value =="""_$extract(TRIGGER,3,999)_""")"
      if (mOp.Equal(OPERA.get(),"'=")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,99),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value ==\""),m$.Fnc.$extract(TRIGGER.get(),3,999)),"\")"));
        }
      }
      //<< . if OPERA="<"  if $extract(TRIGGER,2,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value >="_$extract(TRIGGER,2,999)_")"
      if (mOp.Equal(OPERA.get(),"<")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,99),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value >="),m$.Fnc.$extract(TRIGGER.get(),2,999)),")"));
        }
      }
      //<< . if OPERA=">"  if $extract(TRIGGER,2,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value <="_$extract(TRIGGER,2,999)_")"
      if (mOp.Equal(OPERA.get(),">")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,99),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value <="),m$.Fnc.$extract(TRIGGER.get(),2,999)),")"));
        }
      }
      //<< . if OPERA="'<" if $extract(TRIGGER,3,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value <"_$extract(TRIGGER,3,999)_")"
      if (mOp.Equal(OPERA.get(),"'<")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,99),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value <"),m$.Fnc.$extract(TRIGGER.get(),3,999)),")"));
        }
      }
      //<< . if OPERA="'>" if $extract(TRIGGER,3,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value >"_$extract(TRIGGER,3,999)_")"
      if (mOp.Equal(OPERA.get(),"'>")) {
        if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,99),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value >"),m$.Fnc.$extract(TRIGGER.get(),3,999)),")"));
        }
      }
      //<< . write "{"
      m$.Cmd.Write("{");
      //<< . for HIDDENF(1)=1:1 set HIDDENF(2)=$piece(HIDDENF,",",HIDDENF(1)) quit:HIDDENF(2)=""  do
      for (m$.var("HIDDENF",1).set(1);(true);m$.var("HIDDENF",1).set(mOp.Add(m$.var("HIDDENF",1).get(),1))) {
        HIDDENF.var(2).set(m$.Fnc.$piece(HIDDENF.get(),",",HIDDENF.var(1).get()));
        if (mOp.Equal(HIDDENF.var(2).get(),"")) {
          break;
        }
        //<< . . set YLFN1=$piece($get(^WWW122(0,YFORM,HIDDENF(2),1)),Y,1)  ;datenfeld
        mVar YLFN1 = m$.var("YLFN1");
        YLFN1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),HIDDENF.var(2).get(),1)),m$.var("Y").get(),1));
        //<< . . if YLFN1="" set YLFN1=HIDDENF(2)
        if (mOp.Equal(YLFN1.get(),"")) {
          YLFN1.set(HIDDENF.var(2).get());
        }
        //<< . . write "document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN1_".style.background=""white"";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),YLFN1.get()),".style.background=\"white\";"));
        //<< . . write "document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN1_".readOnly=false;"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),YLFN1.get()),".readOnly=false;"));
      }
      //<< . ;
      //<< . write "}"
      m$.Cmd.Write("}");
      if (mOp.Equal(m$.Fnc.$piece(TRIGGER1.get(),",",mOp.Add(TRIGGERN.get(),1)),"")) {
        break;
      }
    }
    //<< 
    //<< write "'"
    m$.Cmd.Write("'");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< WRITE   ;bei onchange=write enable ANDERER FELDER;TYBD;4.5.2004 EINGETRAGEN IN PROGRAMM ;next to other regd. within programme
  public void WRITE() {
    //<< if $piece($get(^WWW012(0,YM,1)),Y,82)=1 if $piece($get(^WWW120(0,YFORM,1)),Y,82)=1 quit  ;DURCH EVENTBROKER BEI STÄND. FELDBVALIDIERUNG
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),82),1)) {
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),82),1)) {
        return;
      }
    }
    //<< new HIDDENF,TRIGGER,LFN1,TRIGGERN,TRIGGER1
    mVar HIDDENF = m$.var("HIDDENF");
    mVar TRIGGER = m$.var("TRIGGER");
    mVar LFN1 = m$.var("LFN1");
    mVar TRIGGERN = m$.var("TRIGGERN");
    mVar TRIGGER1 = m$.var("TRIGGER1");
    m$.newVar(HIDDENF,TRIGGER,LFN1,TRIGGERN,TRIGGER1);
    //<< set TRIGGER1 = $translate($piece(YSATZ,Y,85),";",",")
    TRIGGER1.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),85),";",","));
    //<< set HIDDENF  = $translate($piece(YSATZ,Y,83),";",",")
    HIDDENF.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),83),";",","));
    //<< quit:HIDDENF=""
    if (mOp.Equal(HIDDENF.get(),"")) {
      return;
    }
    //<< 
    //<< write YCR," onChange='"
    m$.Cmd.Write(m$.var("YCR").get()," onChange='");
    //<< for TRIGGERN=1:1 set TRIGGER=$piece(TRIGGER1,",",TRIGGERN) do  quit:$piece(TRIGGER1,",",TRIGGERN+1)=""  ;ALLE TRIGGER AUSWERTEN
    for (TRIGGERN.set(1);(true);TRIGGERN.set(mOp.Add(TRIGGERN.get(),1))) {
      TRIGGER.set(m$.Fnc.$piece(TRIGGER1.get(),",",TRIGGERN.get()));
      do {
        //<< . set OPERA=TRIGGER
        mVar OPERA = m$.var("OPERA");
        OPERA.set(TRIGGER.get());
        //<< . for %II=1:1:$length(OPERA) do  ;RAUSFILTER DER VERGLEICHSOPERATOREN ;the
        for (m$.var("%II").set(1);(mOp.LessOrEqual(m$.var("%II").get(),m$.Fnc.$length(OPERA.get())));m$.var("%II").set(mOp.Add(m$.var("%II").get(),1))) {
          //<< . . if '$find("'<>=",$extract(OPERA,%II)) set $extract(OPERA,%II)="#"
          if (mOp.Not(m$.Fnc.$find("'<>=",m$.Fnc.$extract(OPERA.get(),m$.var("%II").get())))) {
            mVar $extract = m$.var("$extract");
            $extract.var(OPERA.get(),m$.var("%II").get()).set("#");
          }
        }
        //<< . set OPERA=$translate(OPERA,"#")  ;NUR VERGLIECHSOPERATOREN ERMITTELN ;only find
        OPERA.set(m$.Fnc.$translate(OPERA.get(),"#"));
        //<< . if TRIGGER="***" set TRIGGER=$$PWD^WWWINPWD() quit
        if (mOp.Equal(TRIGGER.get(),"***")) {
          TRIGGER.set(m$.fnc$("WWWINPWD.PWD"));
          break;
        }
        //<< . if TRIGGER="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value != """")"
        if (mOp.Equal(TRIGGER.get(),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value != \"\")"));
        }
        //<< . if (OPERA="") || (OPERA="=") if TRIGGER'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value == """_$translate(TRIGGER,"=")_""")"
        if ((mOp.Equal(OPERA.get(),"")) || (mOp.Equal(OPERA.get(),"="))) {
          if (mOp.NotEqual(TRIGGER.get(),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value == \""),m$.Fnc.$translate(TRIGGER.get(),"=")),"\")"));
          }
        }
        //<< . if TRIGGER="'" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value == """")"
        if (mOp.Equal(TRIGGER.get(),"'")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value == \"\")"));
        }
        //<< . if OPERA="'"  if $extract(TRIGGER,2,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value == """_$extract(TRIGGER,2,999)_""")"
        if (mOp.Equal(OPERA.get(),"'")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,999),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value == \""),m$.Fnc.$extract(TRIGGER.get(),2,999)),"\")"));
          }
        }
        //<< . ;NEU GRÖßER/KLEINER/NICHT GLEICH ;recent without delay
        //<< . if OPERA="'=" if $extract(TRIGGER,3,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value == """_$extract(TRIGGER,3,999)_""")"
        if (mOp.Equal(OPERA.get(),"'=")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,999),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value == \""),m$.Fnc.$extract(TRIGGER.get(),3,999)),"\")"));
          }
        }
        //<< . if OPERA="<"  if $extract(TRIGGER,2,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value >= "_$extract(TRIGGER,2,999)_")"
        if (mOp.Equal(OPERA.get(),"<")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,999),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value >= "),m$.Fnc.$extract(TRIGGER.get(),2,999)),")"));
          }
        }
        //<< . if OPERA=">"  if $extract(TRIGGER,2,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value <= "_$extract(TRIGGER,2,999)_")"
        if (mOp.Equal(OPERA.get(),">")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,999),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value <= "),m$.Fnc.$extract(TRIGGER.get(),2,999)),")"));
          }
        }
        //<< . if OPERA="'<" if $extract(TRIGGER,3,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value < "_$extract(TRIGGER,3,999)_")"
        if (mOp.Equal(OPERA.get(),"'<")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,999),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value < "),m$.Fnc.$extract(TRIGGER.get(),3,999)),")"));
          }
        }
        //<< . if OPERA="'>" if $extract(TRIGGER,3,999)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value > "_$extract(TRIGGER,3,999)_")"
        if (mOp.Equal(OPERA.get(),"'>")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,999),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value > "),m$.Fnc.$extract(TRIGGER.get(),3,999)),")"));
          }
        }
        //<< . write "{"
        m$.Cmd.Write("{");
        //<< . for HIDDENF(1)=1:1 set HIDDENF(2)=$piece(HIDDENF,",",HIDDENF(1)) quit:HIDDENF(2)=""  do
        for (m$.var("HIDDENF",1).set(1);(true);m$.var("HIDDENF",1).set(mOp.Add(m$.var("HIDDENF",1).get(),1))) {
          HIDDENF.var(2).set(m$.Fnc.$piece(HIDDENF.get(),",",HIDDENF.var(1).get()));
          if (mOp.Equal(HIDDENF.var(2).get(),"")) {
            break;
          }
          //<< . . set YLFN1=$piece($get(^WWW122(0,YFORM,HIDDENF(2),1)),Y,1)  ;datenfeld
          mVar YLFN1 = m$.var("YLFN1");
          YLFN1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),HIDDENF.var(2).get(),1)),m$.var("Y").get(),1));
          //<< . . if YLFN1="" set YLFN1=HIDDENF(2)
          if (mOp.Equal(YLFN1.get(),"")) {
            YLFN1.set(HIDDENF.var(2).get());
          }
          //<< . . write "document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN1_".style.background="""_$piece($get(^WWW100(0,"FARBE",SPRACHE,$piece(YVOR,Y,77),1)),Y,1)_""";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),YLFN1.get()),".style.background=\""),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),77),1)),m$.var("Y").get(),1)),"\";"));
          //<< . . write "document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN1_".readOnly=true;"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),YLFN1.get()),".readOnly=true;"));
        }
        //<< . write "}"
        m$.Cmd.Write("}");
        //<< . if TRIGGER="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value !="""")"
        if (mOp.Equal(TRIGGER.get(),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value !=\"\")"));
        }
        //<< . if OPERA="'"  if $extract(TRIGGER,2,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value !="""_$translate(TRIGGER,"'")_""")"
        if (mOp.Equal(OPERA.get(),"'")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,99),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value !=\""),m$.Fnc.$translate(TRIGGER.get(),"'")),"\")"));
          }
        }
        //<< . if OPERA="'=" if $extract(TRIGGER,3,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value !="""_$extract(TRIGGER,3,999)_""")"
        if (mOp.Equal(OPERA.get(),"'=")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,99),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value !=\""),m$.Fnc.$extract(TRIGGER.get(),3,999)),"\")"));
          }
        }
        //<< . if OPERA="<"  if $extract(TRIGGER,2,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value <"_$extract(TRIGGER,2,999)_")"
        if (mOp.Equal(OPERA.get(),"<")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,99),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value <"),m$.Fnc.$extract(TRIGGER.get(),2,999)),")"));
          }
        }
        //<< . if OPERA=">"  if $extract(TRIGGER,2,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value >"_$extract(TRIGGER,2,999)_")"
        if (mOp.Equal(OPERA.get(),">")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),2,99),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value >"),m$.Fnc.$extract(TRIGGER.get(),2,999)),")"));
          }
        }
        //<< . if OPERA="'<" if $extract(TRIGGER,3,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value >="_$extract(TRIGGER,3,999)_")"
        if (mOp.Equal(OPERA.get(),"'<")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,99),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value >="),m$.Fnc.$extract(TRIGGER.get(),3,999)),")"));
          }
        }
        //<< . if OPERA="'>" if $extract(TRIGGER,3,99)'="" write " if (document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN_".value <="_$extract(TRIGGER,3,999)_")"
        if (mOp.Equal(OPERA.get(),"'>")) {
          if (mOp.NotEqual(m$.Fnc.$extract(TRIGGER.get(),3,99),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),m$.var("YLFN").get()),".value <="),m$.Fnc.$extract(TRIGGER.get(),3,999)),")"));
          }
        }
        //<< . write "{"
        m$.Cmd.Write("{");
        //<< . for HIDDENF(1)=1:1 set HIDDENF(2)=$piece(HIDDENF,",",HIDDENF(1)) quit:HIDDENF(2)=""  do
        for (m$.var("HIDDENF",1).set(1);(true);m$.var("HIDDENF",1).set(mOp.Add(m$.var("HIDDENF",1).get(),1))) {
          HIDDENF.var(2).set(m$.Fnc.$piece(HIDDENF.get(),",",HIDDENF.var(1).get()));
          if (mOp.Equal(HIDDENF.var(2).get(),"")) {
            break;
          }
          //<< . . set YLFN1=$piece($get(^WWW122(0,YFORM,HIDDENF(2),1)),Y,1)  ;datenfeld
          mVar YLFN1 = m$.var("YLFN1");
          YLFN1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),HIDDENF.var(2).get(),1)),m$.var("Y").get(),1));
          //<< . . if YLFN1="" set YLFN1=HIDDENF(2)
          if (mOp.Equal(YLFN1.get(),"")) {
            YLFN1.set(HIDDENF.var(2).get());
          }
          //<< . . write "document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN1_".style.background=""white"";"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),YLFN1.get()),".style.background=\"white\";"));
          //<< . . write "document."_YHTMFORM_".Y"_YFORM_""_YART_YLFN1_".readOnly=false;"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),""),m$.var("YART").get()),YLFN1.get()),".readOnly=false;"));
        }
        //<< . write "}"
        m$.Cmd.Write("}");
      } while (false);
      if (mOp.Equal(m$.Fnc.$piece(TRIGGER1.get(),",",mOp.Add(TRIGGERN.get(),1)),"")) {
        break;
      }
    }
    //<< 
    //<< write "'"
    m$.Cmd.Write("'");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< HyperEvent()
  public Object HyperEvent(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Code for JS calls
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 17-Oct-2012   shobby  SR18066: Reverted trigger to blur
    //<< ; 09-Oct-2012   shobby  SR18066: Trigger off change rather than blur.
    //<< ; 06-Sep-2010   shobby  SR17449: Make Enter work as tab key for firefox.
    //<< ; 29-Jul-2009   shobby  SRAdhoc: Try moving the OnBlur of checkboxes to OnClick.
    //<< ; 10-Feb-2009   shobby  SR16126:Made previous change optional based on a company parameter.
    //<< ; 12-Nov-2008   shobby  SR16126:Simulate commas in a primary key.
    //<< ; 27-Mar-2007   JW      SR15384: Removed Primary Key event call. Use better variables.
    //<< ; 21-Aug-2006   FrankF  SRBR014066: Passing the page number to the server.
    //<< ; 10-Aug-2006   JW      SR13594: Created (encapsulated from WWWFORM7)
    //<< ;-------------------------------------------------------------------------------
    //<< new idRelClass,intDisplay,strOnBlur,strText,YART1,YLFN1
    mVar idRelClass = m$.var("idRelClass");
    mVar intDisplay = m$.var("intDisplay");
    mVar strOnBlur = m$.var("strOnBlur");
    mVar strText = m$.var("strText");
    mVar YART1 = m$.var("YART1");
    mVar YLFN1 = m$.var("YLFN1");
    m$.newVar(idRelClass,intDisplay,strOnBlur,strText,YART1,YLFN1);
    //<< 
    //<< set idRelClass = YPARA(1)
    idRelClass.set(m$.var("YPARA").var(1).get());
    //<< set intDisplay = YPARA(20)
    intDisplay.set(m$.var("YPARA").var(20).get());
    //<< 
    //<< set strOnBlur = ""
    strOnBlur.set("");
    //<< 
    //<< if ($get(YPARA(67))'="")||($$$WWW122ExecuteOnBlur(YSATZ)'="")||(intDisplay=1) {  // If sending relation to a field OR on blur code OR display relations after input
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YPARA").var(67)),"")) || (mOp.NotEqual(include.WWWConst.$$$WWW122ExecuteOnBlur(m$,m$.var("YSATZ")),"")) || (mOp.Equal(intDisplay.get(),1))) {
      //<< 
      //<< if ((YART="P")  && ( $data(^WWW129(0,YFORM,YLFN,1))  || $data(^WWW129(0,YFORM,YLFN,6))  )) ||  ; Primary keys OnChange/OnBlur event
      //<< ((YART'="P") && ( $data(^WWW1291(0,YFORM,YLFN,1)) || $data(^WWW1291(0,YFORM,YLFN,6)) )) ||  ; Form Field OnChange/OnBlur event
      //<< ((YHTMFORM'="WWW2") && (YTYP=3) && ($get(YPARA(67))="")) {                                  ; Memo field, no parameter, no fast save (?)
      if (mOp.Logical(((mOp.Equal(m$.var("YART").get(),"P")) && (mOp.Logical(m$.Fnc.$data(m$.var("^WWW129",0,m$.var("YFORM").get(),m$.var("YLFN").get(),1))) || mOp.Logical(m$.Fnc.$data(m$.var("^WWW129",0,m$.var("YFORM").get(),m$.var("YLFN").get(),6)))))) || mOp.Logical(((mOp.NotEqual(m$.var("YART").get(),"P")) && (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1291",0,m$.var("YFORM").get(),m$.var("YLFN").get(),1))) || mOp.Logical(m$.Fnc.$data(m$.var("^WWW1291",0,m$.var("YFORM").get(),m$.var("YLFN").get(),6)))))) || mOp.Logical(((mOp.NotEqual(m$.var("YHTMFORM").get(),"WWW2")) && (mOp.Equal(m$.var("YTYP").get(),3)) && (mOp.Equal(m$.Fnc.$get(m$.var("YPARA").var(67)),""))))) {
      }
      //<< 
      //<< // Do nothing
      //<< 
      //<< } else {
      else {
        //<< set YLFN1=""
        YLFN1.set("");
        //<< set YART1=YART      ; data item
        YART1.set(m$.var("YART").get());
        //<< if YPARA(67)'="" {  ; Form Field
        if (mOp.NotEqual(m$.var("YPARA").var(67).get(),"")) {
          //<< set YLFN1 = $piece($get(^WWW122(0,YFORM,YPARA(67),1)),Y,1)  ; Class Field from Form Field
          YLFN1.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),m$.var("YPARA").var(67).get(),1)),m$.var("Y").get(),1));
          //<< set YART1 = "D"
          YART1.set("D");
          //<< if $piece($get(^WWW122(0,YFORM,YPARA(67),1)),Y,1)="" set YART1 = "M"  ; Manual field
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),m$.var("YPARA").var(67).get(),1)),m$.var("Y").get(),1),"")) {
            YART1.set("M");
          }
        }
        //<< }
        //<< if YLFN1="" set YLFN1 = YPARA(67)
        if (mOp.Equal(YLFN1.get(),"")) {
          YLFN1.set(m$.var("YPARA").var(67).get());
        }
        //<< if YLFN1="" set YLFN1 = YLFN
        if (mOp.Equal(YLFN1.get(),"")) {
          YLFN1.set(m$.var("YLFN").get());
        }
        //<< 
        //<< if (idRelClass="") && ($$$WWW122ExecuteOnBlur(YSATZ)="") {   // If has no relation class AND no execute on blur
        if ((mOp.Equal(idRelClass.get(),"")) && (mOp.Equal(include.WWWConst.$$$WWW122ExecuteOnBlur(m$,m$.var("YSATZ")),""))) {
          //<< write YCR," onChange='if (document."_YHTMFORM_".Y"_YFORM_YART1_YLFN1_".value == """") {document."_YHTMFORM_".Y"_YFORM_YART_YLFN1_".value = this.value;}'"   ;wenn nur Werteübergabe ohne Feld
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onChange='if (document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),YART1.get()),YLFN1.get()),".value == \"\") {document."),m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),m$.var("YART").get()),YLFN1.get()),".value = this.value;}'"));
        }
        //<< 
        //<< } elseif (idRelClass'="") && (intDisplay=1) && (YLFN1=YLFN) {   // If has relation class AND display relations after input
        else if ((mOp.NotEqual(idRelClass.get(),"")) && (mOp.Equal(intDisplay.get(),1)) && (mOp.Equal(YLFN1.get(),m$.var("YLFN").get()))) {
          //<< if (YTYP=2) || (YXTYP=3) {  //Checkboxes
          if ((mOp.Equal(m$.var("YTYP").get(),2)) || (mOp.Equal(m$.var("YXTYP").get(),3))) {
            //<< if (YART1'="P") || (idRelClass'=YDATEI) {
            if ((mOp.NotEqual(YART1.get(),"P")) || (mOp.NotEqual(idRelClass.get(),m$.var("YDATEI").get()))) {
              //<< write YCR," onChange='retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""",this.checked,""2"","""_YVARIA_""","""_YSEITE_"""); '"
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onChange='retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",this.checked,\"2\",\""),m$.var("YVARIA").get()),"\",\""),m$.var("YSEITE").get()),"\"); '"));
            }
          }
          //<< }
          //<< } elseif (+$$$WWW122PositionCaptionToAnswer(YSATZ)=0) {
          else if ((mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW122PositionCaptionToAnswer(m$,m$.var("YSATZ"))),0))) {
            //<< ;SR18066 $$$Append(strOnBlur," if (!this.readOnly) { retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""","_THISVALUE_",""2"","""_YVARIA_""","""_YSEITE_"""); }")
            //<< $$$Append(strOnBlur," if (doBlur(this)) { retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""","_THISVALUE_",""2"","""_YVARIA_""","""_YSEITE_"""); }")  ;SR18066
            include.COMSYSString.$$$Append(m$,strOnBlur,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (doBlur(this)) { retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\","),m$.var("THISVALUE").get()),",\"2\",\""),m$.var("YVARIA").get()),"\",\""),m$.var("YSEITE").get()),"\"); }"));
          }
          //<< }
          //<< set YSHOWRELA = 1
          mVar YSHOWRELA = m$.var("YSHOWRELA");
          YSHOWRELA.set(1);
        }
        //<< 
        //<< } else {
        else {
          //<< if (YTYP=3) && (YLFN1'="") {   // Memo fields ;WENN TEXTFELD ; WENN MIT PARAMETER oder inhalt in anderes feld   (+ an der ersten stelle=addieren zum feld)
          if ((mOp.Equal(m$.var("YTYP").get(),3)) && (mOp.NotEqual(YLFN1.get(),""))) {
            //<< 
            //<< ;SR18066 $$$Append(strOnBlur," if (!this.readOnly) { selval=this.value;")
            //<< $$$Append(strOnBlur," if (doBlur(this)) { selval=this.value;")          ;SR18066
            include.COMSYSString.$$$Append(m$,strOnBlur," if (doBlur(this)) { selval=this.value;");
            //<< if YHTMFORM'="WWW2" $$$Append(strOnBlur,"if (selval.length < 50 )")   ; Don't Check if Fast Save
            if (mOp.NotEqual(m$.var("YHTMFORM").get(),"WWW2")) {
              include.COMSYSString.$$$Append(m$,strOnBlur,"if (selval.length < 50 )");
            }
            //<< $$$Append(strOnBlur," {")
            include.COMSYSString.$$$Append(m$,strOnBlur," {");
            //<< $$$Append(strOnBlur,"var nach=String.fromCharCode(124) ;var selval0=selval.replace(/\r\n/g,nach);")
            include.COMSYSString.$$$Append(m$,strOnBlur,"var nach=String.fromCharCode(124) ;var selval0=selval.replace(/\\r\\n/g,nach);");
            //<< if YHYPER=0 $$$Append(strOnBlur,"selval=selval0.substring(0,1000);")   ;eventbroker
            if (mOp.Equal(m$.var("YHYPER").get(),0)) {
              include.COMSYSString.$$$Append(m$,strOnBlur,"selval=selval0.substring(0,1000);");
            }
            //<< $$$Append(strOnBlur,"retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""",selval,""2"","""_YVARIA_""","""_YSEITE_""");")
            include.COMSYSString.$$$Append(m$,strOnBlur,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",selval,\"2\",\""),m$.var("YVARIA").get()),"\",\""),m$.var("YSEITE").get()),"\");"));
            //<< 
            //<< if (YHTMFORM="WWW2") && (YHYPER=0) {
            if ((mOp.Equal(m$.var("YHTMFORM").get(),"WWW2")) && (mOp.Equal(m$.var("YHYPER").get(),0))) {
              //<< $$$Append(strOnBlur," retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""","""",""6"",""LOCKSTART"");")
              include.COMSYSString.$$$Append(m$,strOnBlur,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",\"\",\"6\",\"LOCKSTART\");"));
              //<< $$$Append(strOnBlur," var x=1; var x1")
              include.COMSYSString.$$$Append(m$,strOnBlur," var x=1; var x1");
              //<< $$$Append(strOnBlur," while (x<32) {")
              include.COMSYSString.$$$Append(m$,strOnBlur," while (x<32) {");
              //<< $$$Append(strOnBlur,"selval=selval0.substring((x*1000),(x*1000+1000));if (selval != """") retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""",selval,""2"",""PLUS"","""_YSEITE_""");")
              include.COMSYSString.$$$Append(m$,strOnBlur,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("selval=selval0.substring((x*1000),(x*1000+1000));if (selval != \"\") retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",selval,\"2\",\"PLUS\",\""),m$.var("YSEITE").get()),"\");"));
              //<< $$$Append(strOnBlur,"if (selval == """") {retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""","""",""6"",""LOCKEND""); break;}")
              include.COMSYSString.$$$Append(m$,strOnBlur,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("if (selval == \"\") {retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",\"\",\"6\",\"LOCKEND\"); break;}"));
              //<< $$$Append(strOnBlur," x++; }")
              include.COMSYSString.$$$Append(m$,strOnBlur," x++; }");
            }
            //<< }
            //<< $$$Append(strOnBlur,"}}")
            include.COMSYSString.$$$Append(m$,strOnBlur,"}}");
          }
          //<< }
          //<< 
          //<< if (YTYP=2) || (YXTYP=3) {   ;WENN MIT PARAMETER FÜR CHECKBOX oder inhalt in anderes feld
          if ((mOp.Equal(m$.var("YTYP").get(),2)) || (mOp.Equal(m$.var("YXTYP").get(),3))) {
            //<< if (($get(YONCHANGE)=1) && ((YXTYP=3) || (YXTYP=4))) || (YTYP=2) {  ;AUCH CHECKBOX IN MANUELLEM FORMULAR
            if (mOp.Logical(((mOp.Equal(m$.Fnc.$get(m$.var("YONCHANGE")),1)) && mOp.Logical(((mOp.Equal(m$.var("YXTYP").get(),3)) || (mOp.Equal(m$.var("YXTYP").get(),4)))))) || (mOp.Equal(m$.var("YTYP").get(),2))) {
              //<< write YCR," onClick="
              m$.Cmd.Write(m$.var("YCR").get()," onClick=");
              //<< kill YONCHANGE
              m$.var("YONCHANGE").kill();
            }
            //<< } else {
            else {
              //<< write YCR," onChange="
              m$.Cmd.Write(m$.var("YCR").get()," onChange=");
            }
            //<< }
            //<< write "'retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""",this.checked,""2"","""_YVARIA_""","""_YSEITE_""");'"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("'retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",this.checked,\"2\",\""),m$.var("YVARIA").get()),"\",\""),m$.var("YSEITE").get()),"\");'"));
          }
          //<< }
          //<< 
          //<< if (YTYP'=3) && (YTYP'=2) && (YXTYP'=3) && (YLFN1'="") {       ;WENN MIT PARAMETER oder inhalt in anderes feld   ;when by means of parameter or within
          if ((mOp.NotEqual(m$.var("YTYP").get(),3)) && (mOp.NotEqual(m$.var("YTYP").get(),2)) && (mOp.NotEqual(m$.var("YXTYP").get(),3)) && (mOp.NotEqual(YLFN1.get(),""))) {
            //<< 
            //<< if (YXTYP=6) {
            if ((mOp.Equal(m$.var("YXTYP").get(),6))) {
              //<< ;SR18066 $$$Append(strOnBlur," if (!this.readOnly) { selval=MULTISELECT"_YART1_YLFN_"();retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""",selval,""2"","""_YVARIA_""","""_YSEITE_"""); }")
              //<< $$$Append(strOnBlur," selval=MULTISELECT"_YART1_YLFN_"(); if (doBlur(this,selval)) { retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""",selval,""2"","""_YVARIA_""","""_YSEITE_"""); }") ; SR18066
              include.COMSYSString.$$$Append(m$,strOnBlur,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" selval=MULTISELECT",YART1.get()),m$.var("YLFN").get()),"(); if (doBlur(this,selval)) { retval = EventValue(\""),m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",selval,\"2\",\""),m$.var("YVARIA").get()),"\",\""),m$.var("YSEITE").get()),"\"); }"));
            }
            //<< 
            //<< } else {
            else {
              //<< ;SR18066 set strText = " if (!this.readOnly) { retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""","_THISVALUE_",""2"","""_YVARIA_""","""_YSEITE_"""); }"
              //<< set strText = " if (doBlur(this,"_THISVALUE_")) { retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""","_THISVALUE_",""2"","""_YVARIA_""","""_YSEITE_"""); }"  ;SR18066
              strText.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" if (doBlur(this,",m$.var("THISVALUE").get()),")) { retval = EventValue(\""),m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\","),m$.var("THISVALUE").get()),",\"2\",\""),m$.var("YVARIA").get()),"\",\""),m$.var("YSEITE").get()),"\"); }"));
              //<< 
              //<< if $get(YONCHANGE)=1 {    ;CHECKBOX MIT ONCLICK
              if (mOp.Equal(m$.Fnc.$get(m$.var("YONCHANGE")),1)) {
                //<< if (YXTYP'=11) && (YXTYP'=2) && (YXTYP'=3) {
                if ((mOp.NotEqual(m$.var("YXTYP").get(),11)) && (mOp.NotEqual(m$.var("YXTYP").get(),2)) && (mOp.NotEqual(m$.var("YXTYP").get(),3))) {
                  //<< write YCR," onChange="
                  m$.Cmd.Write(m$.var("YCR").get()," onChange=");
                  //<< kill YONCHANGE
                  m$.var("YONCHANGE").kill();
                }
                //<< 
                //<< } else {
                else {
                  //<< write YCR," onClick="
                  m$.Cmd.Write(m$.var("YCR").get()," onClick=");
                  //<< if ((YXTYP=11) || (YXTYP=2))                    &&
                  //<< ($get(YSORT)'="")                            &&
                  //<< ($get(YPARA(5))'="")                         &&
                  //<< ($order(^WWWSOR(YUSER,2,YSORT,YPARA(5)))="") &&
                  //<< ($order(^WWWSOR(YUSER,2,YSORT))="")             {
                  if (mOp.Logical(((mOp.Equal(m$.var("YXTYP").get(),11)) || (mOp.Equal(m$.var("YXTYP").get(),2)))) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YSORT")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YPARA").var(5)),"")) && (mOp.Equal(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,m$.var("YSORT").get(),m$.var("YPARA").var(5).get())),"")) && (mOp.Equal(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,m$.var("YSORT").get())),""))) {
                    //<< 
                    //<< kill YONCHANGE   ;NICHT IMMER KILLEN (RADIO-BUTTONS = MEHRERE AUSWAHLFLEDER)
                    m$.var("YONCHANGE").kill();
                  }
                }
                //<< }
                //<< }
                //<< write "'"_strText_"'"
                m$.Cmd.Write(mOp.Concat(mOp.Concat("'",strText.get()),"'"));
              }
              //<< 
              //<< } else {
              else {
                //<< $$$Append(strOnBlur,strText)
                include.COMSYSString.$$$Append(m$,strOnBlur,strText);
              }
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
    //<< }
    //<< 
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< if (YART="P") {
    if ((mOp.Equal(m$.var("YART").get(),"P"))) {
      //<< if '$data(^WWW129(0,YFORM,YLFN,14)) {   ; no OnKeyDown js event
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW129",0,m$.var("YFORM").get(),m$.var("YLFN").get(),14)))) {
        //<< if $$SimulateCommainPrimaryKey^WWW012() {
        if (mOp.Logical(m$.fnc$("WWW012.SimulateCommainPrimaryKey"))) {
          //<< ;write YCR," onKeyDown='switchKey(13,9); if (event.keyCode==188) {window.event.returnValue=false; this.value=this.value+"""_$$$FAKECOMMA_"""} '"  ; SR17449 Is returning NO ACCESS error on FireFox
          //<< write YCR," onKeyDown='if (document.all) { if (event.keyCode == 13) {event.keyCode = 9;} else if (event.keyCode==188) {window.event.returnValue=false; this.value=this.value+"""_$$$FAKECOMMA_"""} }'"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" onKeyDown='if (document.all) { if (event.keyCode == 13) {event.keyCode = 9;} else if (event.keyCode==188) {window.event.returnValue=false; this.value=this.value+\"",include.COMSYSString.$$$FAKECOMMA(m$)),"\"} }'"));
        }
        //<< 
        //<< } else {
        else {
          //<< ;write YCR," onKeyDown='switchKey(13,9);'"  ;SR17449 Is returning NO ACCESS error on FireFox
          //<< write YCR," onKeyDown='if (document.all) { if (event.keyCode == 13) {"
          m$.Cmd.Write(m$.var("YCR").get()," onKeyDown='if (document.all) { if (event.keyCode == 13) {");
          //<< write YCR,"event.KeyCode = 9;"
          m$.Cmd.Write(m$.var("YCR").get(),"event.KeyCode = 9;");
          //<< write YCR,"} }'"
          m$.Cmd.Write(m$.var("YCR").get(),"} }'");
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< if $$$WWW122SubmitFormOnChange(YSATZ) && '$data(^WWW1291(0,YFORM,YLFN,1)) { // submit OnChange, and no OnChange js event
      if (mOp.Logical(include.WWWConst.$$$WWW122SubmitFormOnChange(m$,m$.var("YSATZ"))) && mOp.Not(m$.Fnc.$data(m$.var("^WWW1291",0,m$.var("YFORM").get(),m$.var("YLFN").get(),1)))) {
        //<< $$$Append(strOnBlur,"SAVENOW();")
        include.COMSYSString.$$$Append(m$,strOnBlur,"SAVENOW();");
      }
    }
    //<< }
    //<< }
    //<< if strOnBlur'="" {
    if (mOp.NotEqual(strOnBlur.get(),"")) {
      //<< write " onBlur='"_strOnBlur_"'"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" onBlur='",strOnBlur.get()),"'"));
    }
    //<< ;SR18066 write " onChange=' "_strOnBlur_"' " ;SR18066
    //<< }
    //<< quit
    return null;
  }

//<< 
//<< 
}
