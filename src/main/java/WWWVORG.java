//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWVORG
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:00
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
//<< #include WWWConst
import include.WWWConst;

//<< WWWVORG
public class WWWVORG extends mClass {

  public void main() {
    _WWWVORG();
  }

  public void _WWWVORG() {
    //<< ;------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       VORGABEN WWW ; WWW Defaults.
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
    //<< ; 14-Jan-2008   FIS     SR15619: replaced it again -> moved to WWW012
    //<< ; 14-Jan-2008   GRF     SR15619: base on WWW012 not WWW120; boolean macros
    //<< ; 10-Jan-2008   FIS     SR15619: set "framedform" in WWW012 always to 1
    //<< ; 11-Sep-2007   shobby  SRBR014713: YTARGET and YTARGET2 should be preserved.
    //<< ; 23-May-2007   GRF     SR15525: Call common code and default UNKNOWN should be
    //<< ;                       "EN" and dot, not "EN" and comma;  move YBED up and use.
    //<< ; 13-Mar-2007   RPW     SR15408: How many times do we need to get YM
    //<< ; 20-Feb-2007   GRF     SR15448: YAKTION to use www.cls only
    //<< ; 23-Nov-2005   GRF     SR13171: Doco; Macro
    //<< ; 27-Jul-2005   FIS     SR12390: Get old session values
    //<< ; 30-May-2005   RobertW SR12056: Attempt at Performance Increase
    //<< ; 29.07.1997    DT
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;INTERSYSTEMS CACHE WEBLINK / CSP
    //<< SET Y       = "~"
    mVar Y = m$.var("Y");
    Y.set("~");
    //<< SET %KEY    = ""
    m$.var("%KEY").set("");
    //<< SET YAKTION = ""
    mVar YAKTION = m$.var("YAKTION");
    YAKTION.set("");
    //<< SET YQUERY  = "%KEY"
    mVar YQUERY = m$.var("YQUERY");
    YQUERY.set("%KEY");
    //<< IF $GET(YHYPER)=""          SET YHYPER=0          ;KEIN HYPEREVENT SONDERN EVENTBROKER WENN NICHT GESETZT ;no when Not staid
    if (mOp.Equal(m$.Fnc.$get(m$.var("YHYPER")),"")) {
      mVar YHYPER = m$.var("YHYPER");
      YHYPER.set(0);
    }
    //<< IF $GET(^WWW012(0,0,1))=""  SET ^WWW012(0,0,1)="MANDANT~~~~123~8~2~~2~~Inhaltsverzeichnis,Table of Contents,Table des matières~8~1~51~138~79~3~1~FRAME22~~~1~1~1~KEY~A~VV~MK1~~~3~~~~~~~~127.0.0.1~127.0.0.1~110~25~ihreDomain.com~http://127.0.0.1~C:/inetpub/ftproot/~127.0.0.1/~/bin/~/bin/~C:/inetpub/wwwroot/bin/~~~~~100~100~~~137~~~~~2~67~1~0~1~c:/inetpub/ftproot/Austausch/~~0~1~~,~info@intraprend.de~EUR~0~69~~~~~1~~Postmaster~admin~~~~~~2~~~~~~http://translator.abacho.de?ab_cmd=translate&lp=de_en&urltext=~C:/inetpub/wwwroot/dtd/~~~96~html.gif~~~~~~~~25~137~69"
    if (mOp.Equal(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),"")) {
      m$.var("^WWW012",0,0,1).set("MANDANT~~~~123~8~2~~2~~Inhaltsverzeichnis,Table of Contents,Table des matières~8~1~51~138~79~3~1~FRAME22~~~1~1~1~KEY~A~VV~MK1~~~3~~~~~~~~127.0.0.1~127.0.0.1~110~25~ihreDomain.com~http://127.0.0.1~C:/inetpub/ftproot/~127.0.0.1/~/bin/~/bin/~C:/inetpub/wwwroot/bin/~~~~~100~100~~~137~~~~~2~67~1~0~1~c:/inetpub/ftproot/Austausch/~~0~1~~,~info@intraprend.de~EUR~0~69~~~~~1~~Postmaster~admin~~~~~~2~~~~~~http://translator.abacho.de?ab_cmd=translate&lp=de_en&urltext=~C:/inetpub/wwwroot/dtd/~~~96~html.gif~~~~~~~~25~137~69");
    }
    //<< IF $GET(YM)=""              SET YM=$ORDER(^WWW012(0,""))  ;MANDANT
    if (mOp.Equal(m$.Fnc.$get(m$.var("YM")),"")) {
      mVar YM = m$.var("YM");
      YM.set(m$.Fnc.$order(m$.var("^WWW012",0,"")));
    }
    //<< IF (YM="")||($ascii(YM)=0)  SET YM=0
    if ((mOp.Equal(m$.var("YM").get(),"")) || (mOp.Equal(m$.Fnc.$ascii(m$.var("YM").get()),0))) {
      mVar YM = m$.var("YM");
      YM.set(0);
    }
    //<< 
    //<< IF +YM'=YM IF +YM=0         SET @YM=YM  ;TYBD;17,12,2003;TYBD;22,07,2003;WENN MANDANT ALPHANUM, DANN VARIABLE BILDEN. ZB. YM=TEST DANN TEST="TEST"
    if (mOp.NotEqual(mOp.Positive(m$.var("YM").get()),m$.var("YM").get())) {
      if (mOp.Equal(mOp.Positive(m$.var("YM").get()),0)) {
        m$.indirectVar(m$.var("YM").get()).set(m$.var("YM").get());
      }
    }
    //<< IF $GET(%(YQUERY,"YM"))'="" SET YM=%(YQUERY,"YM")  ;VORGABE MANDANT AUS VORGABE ;default Company out of default
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("%",YQUERY.get(),"YM")),"")) {
      mVar YM = m$.var("YM");
      YM.set(m$.var("%",YQUERY.get(),"YM").get());
    }
    //<< 
    //<< ;USER VORGABE ZURÜCKHOLEN;FIS;06.05.04;25460
    //<< ;WIRD EINE ROUTINE MIT JOB AUFGERUFEN, SIND DIE CSP-OBJEKTE NICHT MEHR VORHANDEN. IN DIESEM FALL
    //<< ;KANN ES WÜNSCHENSWERT SEIN, DIE CGI-VARIABLEN ZURPÜCKZUHOLEN (SPEICHERUNG IN WWWVAR)
    //<< IF YHYPER'=0 IF $GET(%request)="" IF ($GET(YUSER)'="")||($GET(%(YQUERY,"YUSER"))'="") DO
    if (mOp.NotEqual(m$.var("YHYPER").get(),0)) {
      if (mOp.Equal(m$.Fnc.$get(m$.getRequest()),"")) {
        if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) || (mOp.NotEqual(m$.Fnc.$get(m$.var("%",YQUERY.get(),"YUSER")),""))) {
          //<< . NEW YUSER,YVAR
          mVar YUSER = m$.var("YUSER");
          mVar YVAR = m$.var("YVAR");
          m$.newVarBlock(1,YUSER,YVAR);
          //<< . IF $GET(YUSER)="" SET YUSER=$GET(%(YQUERY,"YUSER"))
          if (mOp.Equal(m$.Fnc.$get(YUSER),"")) {
            YUSER.set(m$.Fnc.$get(m$.var("%",YQUERY.get(),"YUSER")));
          }
          //<< . IF YUSER'="" IF $DATA(^WWWUSER1(0,YUSER)) DO
          if (mOp.NotEqual(YUSER.get(),"")) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWUSER1",0,YUSER.get())))) {
              //<< . . FOR YVAR="%KEY","%CGIEVAR" DO
              for (Object _YVAR: new Object[] {"%KEY","%CGIEVAR"}) {
                YVAR.set(_YVAR);
                do {
                  //<< . . . QUIT:$DATA(@YVAR)  ;VARIABLEN BEREITS VORHANDEN ;yet on hand
                  if (mOp.Logical(m$.Fnc.$data(m$.indirectVar(_YVAR)))) {
                    break;
                  }
                  //<< . . . SET YVAR(1)=""
                  YVAR.var(1).set("");
                  //<< . . . FOR  SET YVAR(1)=$ORDER(^WWWUSER1(0,YUSER,YVAR,YVAR(1))) QUIT:YVAR(1)=""  DO
                  for (;true;) {
                    YVAR.var(1).set(m$.Fnc.$order(m$.var("^WWWUSER1",0,YUSER.get(),_YVAR,YVAR.var(1).get())));
                    if (mOp.Equal(YVAR.var(1).get(),"")) {
                      break;
                    }
                    do {
                      //<< . . . . IF $ORDER(^WWWUSER1(0,YUSER,YVAR,YVAR(1),""))="" SET YEXEC="SET "_YVAR_"("_""""_YVAR(1)_""""_")="_""""_$GET(^WWWUSER1(0,YUSER,YVAR,YVAR(1)))_"""" XECUTE YEXEC QUIT
                      if (mOp.Equal(m$.Fnc.$order(m$.var("^WWWUSER1",0,YUSER.get(),_YVAR,YVAR.var(1).get(),"")),"")) {
                        mVar YEXEC = m$.var("YEXEC");
                        YEXEC.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("SET ",_YVAR),"("),"\""),YVAR.var(1).get()),"\""),")="),"\""),m$.Fnc.$get(m$.var("^WWWUSER1",0,YUSER.get(),_YVAR,YVAR.var(1).get()))),"\""));
                        m$.Cmd.Xecute(YEXEC.get());
                        break;
                      }
                      //<< . . . . SET YVAR(2)=""
                      YVAR.var(2).set("");
                      //<< . . . . FOR  SET YVAR(2)=$ORDER(^WWWUSER1(0,YUSER,YVAR,YVAR(1),YVAR(2))) QUIT:YVAR(2)=""  DO
                      for (;true;) {
                        YVAR.var(2).set(m$.Fnc.$order(m$.var("^WWWUSER1",0,YUSER.get(),_YVAR,YVAR.var(1).get(),YVAR.var(2).get())));
                        if (mOp.Equal(YVAR.var(2).get(),"")) {
                          break;
                        }
                        //<< . . . . . SET YEXEC="SET "_YVAR_"("_""""_YVAR(1)_""""_","_""""_YVAR(2)_""""_")="_""""_$GET(^WWWUSER1(0,YUSER,YVAR,YVAR(1),YVAR(2)))_""""
                        mVar YEXEC = m$.var("YEXEC");
                        YEXEC.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("SET ",_YVAR),"("),"\""),YVAR.var(1).get()),"\""),","),"\""),YVAR.var(2).get()),"\""),")="),"\""),m$.Fnc.$get(m$.var("^WWWUSER1",0,YUSER.get(),_YVAR,YVAR.var(1).get(),YVAR.var(2).get()))),"\""));
                        //<< . . . . . XECUTE YEXEC
                        m$.Cmd.Xecute(YEXEC.get());
                      }
                    } while (false);
                  }
                } while (false);
              }
            }
          }
        }
        m$.restoreVarBlock(1);
      }
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; A link such as
    //<< ;   http://server/csp/dev/www.cls?EP=WWWHELP&YFORM=INExample&YX=&YUCI=TEST&YBED=AAA&YUSER=1355x75&YUCI=QA
    //<< ;
    //<< ; will return the following
    //<< ;   %request.Data("EP",1)     = "WWWHELP"
    //<< ;   %request.Data("YBED",1)   = "AAA"
    //<< ;   %request.Data("YFORM",1)  = "INExample"
    //<< ;   %request.Data("YUCI",1)   = "TEST"
    //<< ;   %request.Data("YUCI",2)   = "QA"         ; multiple instances not normally found
    //<< ;   %request.Data("YUSER",1)  = "1355x75"
    //<< ;   %request.Data("YX",1)     = ""           ; parameters are not normally generated by WWWCGI when value is null
    //<< ;
    //<< ;   NOTE : If a null entry does exist, it will not clear any prior array value.
    //<< ;          If a request with multiple instances is received, subsequent single
    //<< ;          instance requests will not clear the second level array values.
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< IF '$DATA(%KEY("HYPEREVENT")) IF $GET(%request)'="" IF $GET(%request.Data("EP",1))'="" DO
    if (mOp.Not(m$.Fnc.$data(m$.var("%KEY","HYPEREVENT")))) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),"")) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.getRequest().varData("EP",1)),"")) {
          do {
            //<< . SET YHYPER=1
            mVar YHYPER = m$.var("YHYPER");
            YHYPER.set(1);
            //<< . NEW YVAR
            mVar YVAR = m$.var("YVAR");
            m$.newVarBlock(1,YVAR);
            //<< . SET YVAR=""
            YVAR.set("");
            //<< . FOR  SET YVAR=$ORDER(%request.Data(YVAR)) QUIT:YVAR=""  DO
            for (;true;) {
              YVAR.set(m$.Fnc.$order(m$.getRequest().varData(YVAR.get())));
              if (mOp.Equal(YVAR.get(),"")) {
                break;
              }
              do {
                //<< . . ; single subscript
                //<< . . IF $GET(%request.Data(YVAR))'=""    SET %KEY(YVAR)=$GET(%request.Data(YVAR))   QUIT
                if (mOp.NotEqual(m$.Fnc.$get(m$.getRequest().varData(YVAR.get())),"")) {
                  m$.var("%KEY",YVAR.get()).set(m$.Fnc.$get(m$.getRequest().varData(YVAR.get())));
                  break;
                }
                //<< . . IF $ORDER(%request.Data(YVAR,1))="" SET %KEY(YVAR)=$GET(%request.Data(YVAR,1)) QUIT
                if (mOp.Equal(m$.Fnc.$order(m$.getRequest().varData(YVAR.get(),1)),"")) {
                  m$.var("%KEY",YVAR.get()).set(m$.Fnc.$get(m$.getRequest().varData(YVAR.get(),1)));
                  break;
                }
                //<< . . ; multiple instances
                //<< . . SET YVAR(1)=""
                YVAR.var(1).set("");
                //<< . . FOR  SET YVAR(1)=$ORDER(%request.Data(YVAR,YVAR(1))) QUIT:YVAR(1)=""  DO
                for (;true;) {
                  YVAR.var(1).set(m$.Fnc.$order(m$.getRequest().varData(YVAR.get(),YVAR.var(1).get())));
                  if (mOp.Equal(YVAR.var(1).get(),"")) {
                    break;
                  }
                  //<< . . . SET %KEY(YVAR,YVAR(1))=%request.Data(YVAR,YVAR(1))
                  m$.var("%KEY",YVAR.get(),YVAR.var(1).get()).set(m$.getRequest().getData(YVAR.get(),YVAR.var(1).get()));
                }
              } while (false);
            }
            //<< . ;
            //<< . SET YVAR=""
            YVAR.set("");
            //<< . FOR  SET YVAR=$ORDER(%request.CgiEnvs(YVAR)) QUIT:YVAR=""  DO
            for (;true;) {
              //YVAR.set(m$.Fnc.$order(m$.getRequest().getCgiEnvs(YVAR.get())));
              YVAR.set("");
              if (mOp.Equal(YVAR.get(),"")) {
                break;
              }
              /*
              do {
                //<< . . ; single subscript
                //<< . . IF $GET(%request.CgiEnvs(YVAR))'=""    SET %CGIEVAR(YVAR)=$GET(%request.CgiEnvs(YVAR))   QUIT
                if (mOp.NotEqual(m$.Fnc.$get(m$.getRequest().getCgiEnvs(YVAR.get())),"")) {
                  m$.var("%CGIEVAR",YVAR.get()).set(m$.Fnc.$get(m$.getRequest().getCgiEnvs(YVAR.get())));
                  break;
                }
                //<< . . IF $ORDER(%request.CgiEnvs(YVAR,1))="" SET %CGIEVAR(YVAR)=$GET(%request.CgiEnvs(YVAR,1)) QUIT
                if (mOp.Equal(m$.Fnc.$order(m$.getRequest().getCgiEnvs(YVAR.get(),1)),"")) {
                  m$.var("%CGIEVAR",YVAR.get()).set(m$.Fnc.$get(m$.getRequest().getCgiEnvs(YVAR.get(),1)));
                  break;
                }
                //<< . . ; multiple instances
                //<< . . SET YVAR(1)=""
                YVAR.var(1).set("");
                //<< . . FOR  SET YVAR(1)=$ORDER(%request.CgiEnvs(YVAR,YVAR(1))) QUIT:YVAR(1)=""  DO
                for (;true;) {
                  YVAR.var(1).set(m$.Fnc.$order(m$.getRequest().getCgiEnvs(YVAR.get(),YVAR.var(1).get())));
                  if (mOp.Equal(YVAR.var(1).get(),"")) {
                    break;
                  }
                  //<< . . . SET %CGIEVAR(YVAR,YVAR(1))=%request.CgiEnvs(YVAR,YVAR(1))
                  m$.var("%CGIEVAR",YVAR.get(),YVAR.var(1).get()).set(m$.getRequest().getCgiEnvs(YVAR.get(),YVAR.var(1).get()));
                }
                
              } while (false);
              */
            }
            //<< . ;
            //<< . NEW MIME,MIMES,len,YIII
            mVar MIME = m$.var("MIME");
            mVar MIMES = m$.var("MIMES");
            mVar len = m$.var("len");
            mVar YIII = m$.var("YIII");
            m$.newVarBlock(1,MIME,MIMES,len,YIII);
            //<< . IF $GET(%request.Data("EP",1))="WWWXMLSERVER" DO READXML QUIT  ;XML
            if (mOp.Equal(m$.Fnc.$get(m$.getRequest().varData("EP",1)),"WWWXMLSERVER")) {
              m$.Cmd.Do("READXML");
              break;
            }
          } while (false);
        }
        m$.restoreVarBlock(1);
      }
    }
    //<< 
    //<< SET YIPADDR=$$^WWWIP1($GET(%CGIEVAR("REMOTE_ADDR")))
    mVar YIPADDR = m$.var("YIPADDR");
    YIPADDR.set(m$.fnc$("WWWIP1.main",m$.Fnc.$get(m$.var("%CGIEVAR","REMOTE_ADDR"))));
    do {
      //<< 
      //<< 
      //<< ;TEST!!
      //<< ;S ^TEST($H)=%session.CSPSessionCookie_"  "_##class(%CSP.Page).EscapeURL(##class(%CSP.Page).Encrypt("User.www.HyperEvent"))
      //<< 
      //<< 
      //<< DO
      //<< . ;NEW MGWLPN,MGWLIB
      //<< . MERGE %KEY=%("VAR")
      m$.Cmd.Merge(m$.var("%KEY"),m$.var("%","VAR"));
      //<< . MERGE %(YQUERY)=%KEY
      m$.Cmd.Merge(m$.var("%",YQUERY.get()),m$.var("%KEY"));
      //<< . SET MGWLPN=$GET(%KEY("MGWLPN"))            ; INTERSYSTEMS CACHE WEBLINK (obsolete?)
      mVar MGWLPN = m$.var("MGWLPN");
      MGWLPN.set(m$.Fnc.$get(m$.var("%KEY","MGWLPN")));
      //<< . SET MGWLIB=$GET(%KEY("MGWLIB"))
      mVar MGWLIB = m$.var("MGWLIB");
      MGWLIB.set(m$.Fnc.$get(m$.var("%KEY","MGWLIB")));
      //<< . ;IF YHYPER'=1 IF MGWLPN="" SET MGWLPN="LOCAL"
      //<< . ;IF YHYPER'=1 IF MGWLIB="" SET MGWLIB="/scripts/mgwms32.dll"
      //<< . IF MGWLIB'="" IF MGWLPN'="" SET YAKTION=MGWLIB_"?MGWLPN="_MGWLPN_"&" QUIT
      if (mOp.NotEqual(MGWLIB.get(),"")) {
        if (mOp.NotEqual(MGWLPN.get(),"")) {
          YAKTION.set(mOp.Concat(mOp.Concat(mOp.Concat(MGWLIB.get(),"?MGWLPN="),MGWLPN.get()),"&"));
          break;
        }
      }
      //<< . ;
      //<< . ;-------------------------------------
      //<< . ; FIXME : <GRF> What if suffix is ".html" - can end up with ".clsl"
      //<< . ;-------------------------------------
      //<< . ;
      //<< . IF $FIND($GET(%CGIEVAR("HTTP_REFERER")),".htm") SET %CGIEVAR("HTTP_REFERER")=$PIECE($PIECE($GET(%CGIEVAR("HTTP_REFERER")),"?",1),".htm",1)_".cls"
      if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$get(m$.var("%CGIEVAR","HTTP_REFERER")),".htm"))) {
        m$.var("%CGIEVAR","HTTP_REFERER").set(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$get(m$.var("%CGIEVAR","HTTP_REFERER")),"?",1),".htm",1),".cls"));
      }
      //<< . ;
      //<< . ;-------------------------------------
      //<< . ; SR15448  start
      //<< . ;SET YAKTION="/csp/"_$PIECE($PIECE($GET(%CGIEVAR("HTTP_REFERER")),"?",1),"/csp/",2)_"?"  ;csp
      //<< . ;IF $GET(%KEY("YUCI"))="" SET %KEY("YUCI")=$ZUTIL(5)                  ;TYBD;23.11.2003
      //<< . ;IF $GET(%KEY("YUCI"))="" SET %KEY("YUCI")="USER"                     ;TYBD;23.11.2003
      //<< . ;;SET YAKTION="/csp/"_$$^WWWLOW($GET(%KEY("YUCI")))_"/www.cls?"
      //<< . ;SET YAKTION="/csp/"_$zconvert($GET(%KEY("YUCI")),"L")_"/www.cls?"
      //<< . ;-------------------------------------
      //<< . set YAKTION="www.cls?"
      YAKTION.set("www.cls?");
      //<< . ; SR15448  end
      //<< . ;-------------------------------------
      //<< . SET YHYPER=1  ;HYPEREVENT
      mVar YHYPER = m$.var("YHYPER");
      YHYPER.set(1);
      //<< . IF $GET(%ZCS("USE_PORT"))="" SET %ZCS("USE_PORT")=""
      if (mOp.Equal(m$.Fnc.$get(m$.var("%ZCS","USE_PORT")),"")) {
        m$.var("%ZCS","USE_PORT").set("");
      }
      //<< . ;IF '$FIND($$^WWWUPER($IO),":\")   SET %ZCS("USE_PORT")="U "_""""_$IO_""""
      //<< . IF '$FIND($zconvert($IO,"U"),":\") SET %ZCS("USE_PORT")="U "_""""_$IO_""""
      if (mOp.Not(m$.Fnc.$find(m$.Fnc.$zconvert(m$.Fnc.$io(),"U"),":\\"))) {
        m$.var("%ZCS","USE_PORT").set(mOp.Concat(mOp.Concat(mOp.Concat("U ","\""),m$.Fnc.$io()),"\""));
      }
      //<< . SET %ZCS("FLUSH")=""     ;"W *-3"
      m$.var("%ZCS","FLUSH").set("");
    } while(false);
    //<< 
    //<< MERGE %(YQUERY)=%("VAR")             ; unnecessary duplication? <GRF>
    m$.Cmd.Merge(m$.var("%",YQUERY.get()),m$.var("%","VAR"));
    //<< KILL %("VAR")
    m$.var("%","VAR").kill();
    //<< SET YKOMMA = ","                     ; use $$$COMMA instead?
    mVar YKOMMA = m$.var("YKOMMA");
    YKOMMA.set(",");
    //<< SET YNULL  = ""                      ; not used?
    mVar YNULL = m$.var("YNULL");
    YNULL.set("");
    //<< SET YPAGE  = 70
    mVar YPAGE = m$.var("YPAGE");
    YPAGE.set(70);
    //<< SET YCR    = $CHAR(13,10)
    mVar YCR = m$.var("YCR");
    YCR.set(m$.Fnc.$char(13,10));
    //<< ;SET YAM     = "&"             ;FUER '_Button' WENN AKTIV
    //<< SET YAM    = ""
    mVar YAM = m$.var("YAM");
    YAM.set("");
    //<< 
    //<< //IF $GET(%(YQUERY,"YM"))'="" SET YM=%(YQUERY,"YM")  ;VORGABE MANDANT AUS VORGABE ;default Company out of default // SR15408
    //<< 
    //<< /*++++++++++++++++++++++++++++++++++++++
    //<< ;   YVOR1       objWWW012       General Company Parameter
    //<< ;+++++++++++++++++++++++++++++++++++++*/
    //<< 
    //<< SET YVOR1=$GET(^WWW012(0,YM,1))
    mVar YVOR1 = m$.var("YVOR1");
    YVOR1.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    do {
      //<< 
      //<< ;IF +$$$WWW120DisplayFrames(YVOR1)'=1 DO  ;SR15619; set "framed forms" always to 1  ; revised 14-Jan-2008 vvv
      //<< ;. set $piece(^WWW012(0,YM,1),Y,13)=1
      //<< ;. set $piece(YVOR1,Y,13)=1
      //<< 
      //<< /*if $$$WWW012FormsFramed(YVOR1)'=$$$YES {  ;SR15619; set "framed forms" always to 1
      //<< set $$$WWW012FormsFramed(^WWW012(0,YM,1)) = $$$YES
      //<< set $$$WWW012FormsFramed(YVOR1)           = $$$YES
      //<< }*/
      //<< 
      //<< DO  ;ZUSAMMENBAU VARIABLE MIT SONDERZEICHEN FÜR VERGLEICH IN WWWUMLAU;FIS;24771;08.12.03
      //<< . SET YUMLAU=""
      mVar YUMLAU = m$.var("YUMLAU");
      YUMLAU.set("");
      //<< . IF $$$WWW012FastConversionOfSortIndex(YVOR1)=$$$YES QUIT  ; D165  KEINE UMLAUTE;TYBD;6,10,2004;26526
      if (mOp.Equal(include.WWWConst.$$$WWW012FastConversionOfSortIndex(m$,YVOR1),include.COMSYS.$$$YES(m$))) {
        break;
      }
      //<< . NEW CHAR
      mVar CHAR = m$.var("CHAR");
      m$.newVarBlock(1,CHAR);
      //<< . SET CHAR=""
      CHAR.set("");
      //<< . FOR  SET CHAR=$ORDER(^WWWUMLAU(0,CHAR)) QUIT:CHAR=""  SET YUMLAU=YUMLAU_CHAR_","
      for (;true;) {
        CHAR.set(m$.Fnc.$order(m$.var("^WWWUMLAU",0,CHAR.get())));
        if (mOp.Equal(CHAR.get(),"")) {
          break;
        }
        YUMLAU.set(mOp.Concat(mOp.Concat(YUMLAU.get(),CHAR.get()),","));
      }
      //<< . IF YUMLAU'="" SET YUMLAU=$EXTRACT(YUMLAU,1,$LENGTH(YUMLAU)-1)  ;OHNE, AM ENDE
      if (mOp.NotEqual(YUMLAU.get(),"")) {
        YUMLAU.set(m$.Fnc.$extract(YUMLAU.get(),1,mOp.Subtract(m$.Fnc.$length(YUMLAU.get()),1)));
      }
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< ;SET YTARGET  = $PIECE($PIECE(YVOR1,Y,19),"/",1)_YUSER
    //<< ;SET YTARGET2 = $PIECE($PIECE(YVOR1,Y,19),"/",2)
    //<< 
    //<< ; Do Not Display the Header (D65)
    //<< ; This is always being reset to NO
    //<< IF $$$WWW012DoNotDisplayHeader(YVOR1)=$$$YES SET $$$WWW012DoNotDisplayHeader(^WWW012(0,YM,1))=$$$NO
    if (mOp.Equal(include.WWWConst.$$$WWW012DoNotDisplayHeader(m$,YVOR1),include.COMSYS.$$$YES(m$))) {
      include.WWWConst.$$$WWW012DoNotDisplayHeaderSet(m$,m$.var("^WWW012",0,m$.var("YM").get(),1),include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< SET YFIXHEADER = +$$$WWW012FixedHeader(YVOR1)  ; D115  FIXED HEADER
    mVar YFIXHEADER = m$.var("YFIXHEADER");
    YFIXHEADER.set(mOp.Positive(include.WWWConst.$$$WWW012FixedHeader(m$,YVOR1)));
    //<< 
    //<< SET YWHR  = $$$WWW012StandardCurrency(YVOR1)   ; D75  STANDARD WÄHRUNGSKZ   ; Standard Currency
    mVar YWHR = m$.var("YWHR");
    YWHR.set(include.WWWConst.$$$WWW012StandardCurrency(m$,YVOR1));
    //<< 
    //<< /*--------------------------------------
    //<< ;  Colours   -   Farbe
    //<< ;                   D64     Font Color Mandatory Input      ; $$$WWW012FontColorMandatoryInput
    //<< ;   YSILVER         D77     Frame Body Colour
    //<< ;   YBLUE           D101    Colour Code For Header Left     ; STANDARD GRAU IN FORMS
    //<< ;   YDARKGRAY       D110    Colour Table Heading            ; STANDARD LISTENKOPF
    //<< ;   YWHITE          D111    Column Colour Bright            ; STANDARD WEISS IN TABELLEN
    //<< ;   YGRAY (Silver)  D112    Column Colour Dark              ; STANDARD GRAU IN TABELLEN
    //<< ;   YRED            D116    Warning Colour                  ; STANDARD ROT FÜR WARNHINWEISE
    //<< ;   YLIGHTGREY      D119    Fieldset Frame Colour           ; STANDARD GRAU FÜR RAHMENFARBE
    //<< ;-------------------------------------*/
    //<< SET YBLUE = $PIECE(YVOR1,Y,101)
    mVar YBLUE = m$.var("YBLUE");
    YBLUE.set(m$.Fnc.$piece(YVOR1.get(),Y.get(),101));
    //<< IF YBLUE'="" SET YBLUE=$PIECE($GET(^WWW100(0,"FARBE","EN",YBLUE,1)),Y,1)
    if (mOp.NotEqual(YBLUE.get(),"")) {
      YBLUE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",YBLUE.get(),1)),Y.get(),1));
    }
    //<< IF YBLUE=""  SET YBLUE="BLUE"
    if (mOp.Equal(YBLUE.get(),"")) {
      YBLUE.set("BLUE");
    }
    //<< 
    //<< SET YSILVER=$PIECE(YVOR1,Y,77)
    mVar YSILVER = m$.var("YSILVER");
    YSILVER.set(m$.Fnc.$piece(YVOR1.get(),Y.get(),77));
    //<< IF YSILVER'="" SET YSILVER=$PIECE($GET(^WWW100(0,"FARBE","EN",YSILVER,1)),Y,1)
    if (mOp.NotEqual(YSILVER.get(),"")) {
      YSILVER.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",YSILVER.get(),1)),Y.get(),1));
    }
    //<< IF YSILVER=""  SET YSILVER="SILVER"
    if (mOp.Equal(YSILVER.get(),"")) {
      YSILVER.set("SILVER");
    }
    //<< 
    //<< SET YDARKGRAY=$PIECE(YVOR1,Y,110)
    mVar YDARKGRAY = m$.var("YDARKGRAY");
    YDARKGRAY.set(m$.Fnc.$piece(YVOR1.get(),Y.get(),110));
    //<< IF YDARKGRAY'="" SET YDARKGRAY=$PIECE($GET(^WWW100(0,"FARBE","EN",YDARKGRAY,1)),Y,1)
    if (mOp.NotEqual(YDARKGRAY.get(),"")) {
      YDARKGRAY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",YDARKGRAY.get(),1)),Y.get(),1));
    }
    //<< IF YDARKGRAY=""  SET YDARKGRAY="DARKGRAY"
    if (mOp.Equal(YDARKGRAY.get(),"")) {
      YDARKGRAY.set("DARKGRAY");
    }
    //<< 
    //<< SET YWHITE=$PIECE(YVOR1,Y,111)
    mVar YWHITE = m$.var("YWHITE");
    YWHITE.set(m$.Fnc.$piece(YVOR1.get(),Y.get(),111));
    //<< IF YWHITE'="" SET YWHITE=$PIECE($GET(^WWW100(0,"FARBE","EN",YWHITE,1)),Y,1)
    if (mOp.NotEqual(YWHITE.get(),"")) {
      YWHITE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",YWHITE.get(),1)),Y.get(),1));
    }
    //<< IF YWHITE=""  SET YWHITE="WHITE"
    if (mOp.Equal(YWHITE.get(),"")) {
      YWHITE.set("WHITE");
    }
    //<< 
    //<< SET YGRAY=$PIECE(YVOR1,Y,112)
    mVar YGRAY = m$.var("YGRAY");
    YGRAY.set(m$.Fnc.$piece(YVOR1.get(),Y.get(),112));
    //<< IF YGRAY'="" SET YGRAY=$PIECE($GET(^WWW100(0,"FARBE","EN",YGRAY,1)),Y,1)
    if (mOp.NotEqual(YGRAY.get(),"")) {
      YGRAY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",YGRAY.get(),1)),Y.get(),1));
    }
    //<< IF YGRAY=""  SET YGRAY=YSILVER
    if (mOp.Equal(YGRAY.get(),"")) {
      YGRAY.set(YSILVER.get());
    }
    //<< 
    //<< SET YRED=$PIECE(YVOR1,Y,116)
    mVar YRED = m$.var("YRED");
    YRED.set(m$.Fnc.$piece(YVOR1.get(),Y.get(),116));
    //<< IF YRED'="" SET YRED=$PIECE($GET(^WWW100(0,"FARBE","EN",YRED,1)),Y,1)
    if (mOp.NotEqual(YRED.get(),"")) {
      YRED.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",YRED.get(),1)),Y.get(),1));
    }
    //<< IF YRED=""  SET YRED="RED"
    if (mOp.Equal(YRED.get(),"")) {
      YRED.set("RED");
    }
    //<< 
    //<< SET YLIGHTGREY=$PIECE(YVOR1,Y,119)
    mVar YLIGHTGREY = m$.var("YLIGHTGREY");
    YLIGHTGREY.set(m$.Fnc.$piece(YVOR1.get(),Y.get(),119));
    //<< IF YLIGHTGREY'="" SET YLIGHTGREY=$PIECE($GET(^WWW100(0,"FARBE","EN",YLIGHTGREY,1)),Y,1)
    if (mOp.NotEqual(YLIGHTGREY.get(),"")) {
      YLIGHTGREY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",YLIGHTGREY.get(),1)),Y.get(),1));
    }
    //<< IF YLIGHTGREY=""  SET YLIGHTGREY="LIGHTGREY"
    if (mOp.Equal(YLIGHTGREY.get(),"")) {
      YLIGHTGREY.set("LIGHTGREY");
    }
    //<< 
    //<< /*----------------------------------------------------------------------------*/
    //<< 
    //<< SET YLINKCOL = ""                     ;FARBE FÃœR LINK (DFLT. = BLAU)
    mVar YLINKCOL = m$.var("YLINKCOL");
    YLINKCOL.set("");
    //<< SET YDREID   = +$$$WWW012GroupingFrameIn2Colors(YVOR1)   ; D157  TWO-TONE FRAME  RAHMEN ZWEIFARBIG (3D-EFFEKT)
    mVar YDREID = m$.var("YDREID");
    YDREID.set(mOp.Positive(include.WWWConst.$$$WWW012GroupingFrameIn2Colors(m$,YVOR1)));
    //<< SET YMANDANT =  $$$WWW012UniqueCompanyIdentifier(YVOR1)  ; D94
    mVar YMANDANT = m$.var("YMANDANT");
    YMANDANT.set(include.WWWConst.$$$WWW012UniqueCompanyIdentifier(m$,YVOR1));
    //<< SET YPAGE    =  $$$WWW012PrinterPageLength(YVOR1)        ; D16  FORMULARLNG  SEITENLÄNGE
    YPAGE.set(include.WWWConst.$$$WWW012PrinterPageLength(m$,YVOR1));
    //<< IF YPAGE="" SET YPAGE = 70
    if (mOp.Equal(YPAGE.get(),"")) {
      YPAGE.set(70);
    }
    //<< 
    //<< ; SSL Activation - use HTTPS: rather than HTTP:
    //<< ;---------------------------------------
    //<< SET YSSL=""
    mVar YSSL = m$.var("YSSL");
    YSSL.set("");
    //<< IF $$$WWW012SSLActivation(YVOR1)=$$$YES SET YSSL="s"    ; D33
    if (mOp.Equal(include.WWWConst.$$$WWW012SSLActivation(m$,YVOR1),include.COMSYS.$$$YES(m$))) {
      YSSL.set("s");
    }
    //<< SET YURL     =  $$$WWW012VirtualWWWDirectory(YVOR1)     ; D44  VORGABE FÜR URL ;default to URL
    mVar YURL = m$.var("YURL");
    YURL.set(include.WWWConst.$$$WWW012VirtualWWWDirectory(m$,YVOR1));
    //<< IF (YSSL="s") && '$FIND($zconvert(YURL,"U"),"HTTPS") {
    if ((mOp.Equal(YSSL.get(),"s")) && mOp.Not(m$.Fnc.$find(m$.Fnc.$zconvert(YURL.get(),"U"),"HTTPS"))) {
      //<< SET:$FIND(YURL,"HTTP") YURL=$PIECE(YURL,"HTTP",1)_"HTTPS"_$PIECE(YURL,"HTTP",2)
      if (mOp.Logical(m$.Fnc.$find(YURL.get(),"HTTP"))) {
        YURL.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YURL.get(),"HTTP",1),"HTTPS"),m$.Fnc.$piece(YURL.get(),"HTTP",2)));
      }
      //<< SET:$FIND(YURL,"http") YURL=$PIECE(YURL,"http",1)_"https"_$PIECE(YURL,"http",2)
      if (mOp.Logical(m$.Fnc.$find(YURL.get(),"http"))) {
        YURL.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YURL.get(),"http",1),"https"),m$.Fnc.$piece(YURL.get(),"http",2)));
      }
    }
    //<< }
    //<< 
    //<< /* Picture Directories
    //<< ;-------------------------------------*/
    //<< SET YGIF  = $$$WWW012PictureDirectorySystem(YVOR1)     ; D47  WWW GIF SYSTEM
    mVar YGIF = m$.var("YGIF");
    YGIF.set(include.WWWConst.$$$WWW012PictureDirectorySystem(m$,YVOR1));
    //<< SET YGIF1 = $$$WWW012PictureDirectoryUser(YVOR1)       ; D48  WWW GIF ANWENDERN
    mVar YGIF1 = m$.var("YGIF1");
    YGIF1.set(include.WWWConst.$$$WWW012PictureDirectoryUser(m$,YVOR1));
    //<< IF YGIF1="" SET YGIF1 = YGIF
    if (mOp.Equal(YGIF1.get(),"")) {
      YGIF1.set(YGIF.get());
    }
    //<< 
    //<< /* Default Language/Decimals        ;SPRACHVORGABE
    //<< ;-------------------------------------*/
    //<< if $get(SPRACHE)="" set SPRACHE="EN"
    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"")) {
      mVar SPRACHE = m$.var("SPRACHE");
      SPRACHE.set("EN");
    }
    //<< set LANGUAGE    = SPRACHE
    mVar LANGUAGE = m$.var("LANGUAGE");
    LANGUAGE.set(m$.var("SPRACHE").get());
    //<< set YDECIMALLEN = 2
    mVar YDECIMALLEN = m$.var("YDECIMALLEN");
    YDECIMALLEN.set(2);
    //<< set YDECIMAL    = "."
    mVar YDECIMAL = m$.var("YDECIMAL");
    YDECIMAL.set(".");
    //<< if $$$WWW012DecimalSigns(YVOR1)'="" set YDECIMAL = $$$WWW012DecimalSigns(YVOR1)    ; D73
    if (mOp.NotEqual(include.WWWConst.$$$WWW012DecimalSigns(m$,YVOR1),"")) {
      YDECIMAL.set(include.WWWConst.$$$WWW012DecimalSigns(m$,YVOR1));
    }
    //<< 
    //<< /* D79/80  Button Width and Height  Normal 24/22
    //<< ;-------------------------------------*/
    //<< SET YWIDTH=""
    mVar YWIDTH = m$.var("YWIDTH");
    YWIDTH.set("");
    //<< IF $$$WWW012ButtonWidth(YVOR1)>4  SET YWIDTH ="WIDTH="_+$$$WWW012ButtonWidth(YVOR1)
    if (mOp.Greater(include.WWWConst.$$$WWW012ButtonWidth(m$,YVOR1),4)) {
      YWIDTH.set(mOp.Concat("WIDTH=",mOp.Positive(include.WWWConst.$$$WWW012ButtonWidth(m$,YVOR1))));
    }
    //<< SET YHEIGHT=""
    mVar YHEIGHT = m$.var("YHEIGHT");
    YHEIGHT.set("");
    //<< IF $$$WWW012ButtonHeight(YVOR1)>4 SET YHEIGHT="HEIGHT="_+$$$WWW012ButtonHeight(YVOR1)
    if (mOp.Greater(include.WWWConst.$$$WWW012ButtonHeight(m$,YVOR1),4)) {
      YHEIGHT.set(mOp.Concat("HEIGHT=",mOp.Positive(include.WWWConst.$$$WWW012ButtonHeight(m$,YVOR1))));
    }
    //<< 
    //<< /* Authorisations - Don't proceed if no user
    //<< ;-------------------------------------*/
    //<< SET YBEDBER=""
    mVar YBEDBER = m$.var("YBEDBER");
    YBEDBER.set("");
    //<< SET YBEDMOD=""
    mVar YBEDMOD = m$.var("YBEDMOD");
    YBEDMOD.set("");
    //<< 
    //<< QUIT:$GET(%(YQUERY,"YBED"))=""                    ; User Code (BEDIENER)
    if (mOp.Equal(m$.Fnc.$get(m$.var("%",YQUERY.get(),"YBED")),"")) {
      return;
    }
    //<< 
    //<< /******************************************************************************/
    //<< 
    //<< set YBED      = $get(%(YQUERY,"YBED"))
    mVar YBED = m$.var("YBED");
    YBED.set(m$.Fnc.$get(m$.var("%",YQUERY.get(),"YBED")));
    //<< SET YLOCATION = $PIECE($GET(^WWW013(0,YBED,1)),Y,44)  ;BETRIEB      ; User's Home Location
    mVar YLOCATION = m$.var("YLOCATION");
    YLOCATION.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",0,YBED.get(),1)),Y.get(),44));
    //<< SET YUSER     = $GET(%(YQUERY,"YUSER"))               ;BEDIENER     ; User Session Number
    mVar YUSER = m$.var("YUSER");
    YUSER.set(m$.Fnc.$get(m$.var("%",YQUERY.get(),"YUSER")));
    //<< 
    //<< IF YUSER'="" DO   ;GET OLD SESSION VALUES;FIS;27-Jul-2005;SR12390
    if (mOp.NotEqual(YUSER.get(),"")) {
      //<< . NEW YUSER1
      mVar YUSER1 = m$.var("YUSER1");
      m$.newVarBlock(1,YUSER1);
      //<< . SET YUSER1=$GET(^WWWUSER(0,YUSER,1))
      YUSER1.set(m$.Fnc.$get(m$.var("^WWWUSER",0,YUSER.get(),1)));
      //<< . IF $PIECE(YUSER1,Y,20)'="" SET YM        = $PIECE(YUSER1,Y,20)   ;GET CURRENT COMPANY // Can this ever be different from above?
      if (mOp.NotEqual(m$.Fnc.$piece(YUSER1.get(),Y.get(),20),"")) {
        mVar YM = m$.var("YM");
        YM.set(m$.Fnc.$piece(YUSER1.get(),Y.get(),20));
      }
      //<< . IF $PIECE(YUSER1,Y,21)'="" SET YLOCATION = $PIECE(YUSER1,Y,21)   ;GET CURRENT LOCATION
      if (mOp.NotEqual(m$.Fnc.$piece(YUSER1.get(),Y.get(),21),"")) {
        YLOCATION.set(m$.Fnc.$piece(YUSER1.get(),Y.get(),21));
      }
      //<< . SET YTARGET  = $PIECE($PIECE(YVOR1,Y,19),"/",1)_YUSER  ;BR014713
      mVar YTARGET = m$.var("YTARGET");
      YTARGET.set(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$piece(YVOR1.get(),Y.get(),19),"/",1),YUSER.get()));
      //<< . SET YTARGET2 = $PIECE($PIECE(YVOR1,Y,19),"/",2)        ;BR014713
      mVar YTARGET2 = m$.var("YTARGET2");
      YTARGET2.set(m$.Fnc.$piece(m$.Fnc.$piece(YVOR1.get(),Y.get(),19),"/",2));
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< SET YBEDBER = $$^WWWBEDBER(YBED)             ; BERECHTIGUNG       ; user authorisation
    YBEDBER.set(m$.fnc$("WWWBEDBER.main",YBED.get()));
    //<< SET YBEDMOD = $$^WWWBEDMOD(YBED)             ; BERECHTIGUNG MODUL ; user module authorisation
    YBEDMOD.set(m$.fnc$("WWWBEDMOD.main",YBED.get()));
    //<< IF +YBEDBER'=0 SET $ZERROR="^WWWERROR"       ; ERRORTRAPING
    if (mOp.NotEqual(mOp.Positive(YBEDBER.get()),0)) {
      mVar $ZERROR = m$.var("$ZERROR");
      $ZERROR.set("^WWWERROR");
    }
    //<< 
    //<< ; Revise Language/Decimals
    //<< if YBED'="" set SPRACHE = $$^WWWLANGU(YBED)
    if (mOp.NotEqual(YBED.get(),"")) {
      mVar SPRACHE = m$.var("SPRACHE");
      SPRACHE.set(m$.fnc$("WWWLANGU.main",YBED.get()));
    }
    //<< set LANGUAGE = SPRACHE
    LANGUAGE.set(m$.var("SPRACHE").get());
    //<< set YDECIMAL = $extract($$GetNumberDelimiters^COMUtilLocale(SPRACHE),2)
    YDECIMAL.set(m$.Fnc.$extract(m$.fnc$("COMUtilLocale.GetNumberDelimiters",m$.var("SPRACHE").get()),2));
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< READXML ;lesen content, SAVE AS XML
  public void READXML() {
    //<< NEW YIII,FILENAME,%DEV
    mVar YIII = m$.var("YIII");
    mVar FILENAME = m$.var("FILENAME");
    m$.newVar(YIII,FILENAME);
    //<< 
    //<< ; D98   Physical DTD Table
    //<< SET YIII=0
    YIII.set(0);
    //<< SET YFILENAME=$PIECE($GET(^WWW012(0,YM,1)),Y,98)_"XMLIMPORT"_$JOB_".XML"  ;ZWISCHENSPEICHERN
    mVar YFILENAME = m$.var("YFILENAME");
    YFILENAME.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),98),"XMLIMPORT"),m$.Fnc.$job()),".XML"));
    //<< SET %DEV=$$^WWWDEV(YFILENAME)
    m$.var("%DEV").set(m$.fnc$("WWWDEV.main",YFILENAME.get()));
    //<< IF %DEV'="" USE %DEV         ;USE DER FILE ;the
    if (mOp.NotEqual(m$.var("%DEV").get(),"")) {
    }
    //<< WHILE (%request.Content.AtEnd = 0) {
    while ((mOp.Equal(m$.getRequest().getContent().AtEnd(),0))) {
      //<< set len = 30000
      mVar len = m$.var("len");
      len.set(30000);
      //<< SET YIII=YIII+1
      YIII.set(mOp.Add(YIII.get(),1));
      //<< SET %KEY("CONTENT",YIII)=%request.Content.Read(.len)
      m$.var("%KEY","CONTENT",YIII.get()).set(m$.getRequest().getContent().Read(len));
      //<< WRITE %KEY("CONTENT",YIII)
      m$.Cmd.Write(m$.var("%KEY","CONTENT",YIII.get()).get());
    }
    //<< }
    //<< IF %DEV'="" CLOSE %DEV         ;CLOSE DER FILE ;the
    if (mOp.NotEqual(m$.var("%DEV").get(),"")) {
    }
    //<< DO OPEN^WWWSTART
    m$.Cmd.Do("WWWSTART.OPEN");
    //<< QUIT
    return;
  }

//<< 
//<< 
}
