//*****************************************************************************
//** TASC - ALPHALINC - CLASS User.www
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:16
//*****************************************************************************

package User;

import mLibrary.*;

//<< Include COMSYS
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

//<< 
//<< /// @net Manger
//<< Class User.www Extends %CSP.Page [ ClassType = "", Not ProcedureBlock ]
public class www extends mPage {
  //<< {
  //<< 
  //<< Parameter ENCODED = 0;
  public static Object p_ENCODED = 0;

  //<< 
  //<< /*
  //<< ClassMethod DateDiff(pdteFirst = "", pdteSecond = "") As %String
  //<< {
  //<< ; ----------------------------------------------------------------------------
  //<< ; Determine the number of seconds difference between two $horolog dates
  //<< ;
  //<< ; History:
  //<< ; 08-Nov-2004   shobby/Paul Copied from COMUtils which is not available during COM upgrades. (SR10867)
  //<< ; 05-Nov-2004   GRF     Add parameter defaults
  //<< ; 28-Mar-2003   Paul K  Created(Commented)
  //<< ; ----------------------------------------------------------------------------
  //<< new plngFirst,plngSecond
  //<< set plngFirst  = $piece(pdteFirst,",",1) *86400+$piece(pdteFirst,",",2)
  //<< set plngSecond = $piece(pdteSecond,",",1)*86400+$piece(pdteSecond,",",2)
  //<< quit plngSecond-plngFirst
  //<< }
  //<< */
  //<< ClassMethod HyperEvent(
  //<< EVENT As %Library.String,
  //<< VALUE As %Library.String) As %Library.String
  public Object HyperEvent(Object ... _p) {
    mVar EVENT = m$.newVarRef("EVENT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar VALUE = m$.newVarRef("VALUE",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Aug-2006  JW      SR13594: Set more persistent version of YHYPER
    //<< ; 30-May-2006  PO      SR14665: Kill off cachetemp used for managing script tags
    //<< ;-------------------------------------------------------------------------------
    //<< set dteTime     = $zts
    mVar dteTime = m$.var("dteTime");
    dteTime.set(m$.Fnc.$ztimestamp());
    //<< SET %REQUEST    = $GET(EVENT)    ;UCI.USER.FORM.FIELD.FIX.FUNCTION
    m$.var("%REQUEST").set(m$.Fnc.$get(EVENT));
    //<< SET %REQUEST(1) = $GET(VALUE)    ;EINGABE IM DATENFELD
    m$.var("%REQUEST",1).set(m$.Fnc.$get(VALUE));
    //<< SET %KEY("HYPEREVENT") = 1       ;MERKER FÜR %request.data
    m$.var("%KEY","HYPEREVENT").set(1);
    //<< SET YHYPER  = 1                  ;TRIGGER FÜR WWWEVENT
    mVar YHYPER = m$.var("YHYPER");
    YHYPER.set(1);
    //<< SET %TXT(1) = ""                 ;RÜCKGABE
    m$.var("%TXT",1).set("");
    //<< 
    //<< set idUser = %session.SessionId
    mVar idUser = m$.var("idUser");
    idUser.set(m$.getSession().getSessionId());
    //<< kill ^CacheTempScriptTag(idUser,$job)
    m$.var("^CacheTempScriptTag",idUser.get(),m$.Fnc.$job()).kill();
    //<< set ^CacheTempInHyperEvent(idUser,$job) = $$$YES       //SR13594
    m$.var("^CacheTempInHyperEvent",idUser.get(),m$.Fnc.$job()).set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< DO ^WWWEVENT                 ;PRÜFUNGSROUTINE
    m$.Cmd.Do("WWWEVENT.main");
    //<< 
    //<< //Finish any pending exporting operations, if any
    //<< //do ##class(SourceControl.Exporter).FlushExports(1)
    //<< 
    //<< QUIT %TXT(1)                 ;RÜCKGABE
    return m$.var("%TXT",1).get();
  //<< }
  }

  //<< 
  //<< ClassMethod OnPage() As %Status
  public Object OnPage(Object ... _p) {
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; USAGE : e.g. Save button will generate entry point WWWSAVE that is then executed
    //<< ;         similar for forms, help, search, menu, etc.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Nov-2010   shobby  SR17603: use window.frames rather than parent.frames
    //<< ; 27-Jul-2010   FIS     SR17457: use parent.frames rather document.frames
    //<< ; 27-Jul-2010   shobby  SR17454: document.frames now done in WWWFORMCrossBrowser support.
    //<< ; 31-May-2010   FIS     SR17343: No document.frames in firefox
    //<< ; 21-Jun-2007   FIS     SR15550 License Allocation Added
    //<< ; 13-MAr-2007   GRF     Doco
    //<< ; 18-Dec-2006   JW      BR014262: Rewrote in brace syntax. Check for frameset.
    //<< ; 15-Aug-2006   JW      SR13594: Set more persistent version of YHYPER
    //<< ; 30-May-2006   PO      SR14665: Kill off cachetemp used for managing script tags
    //<< ; 04-Jul-2005   SCR     SR11778: Removed Debug Code
    //<< ;-------------------------------------------------------------------------------
    //<< set dteTime = $zts
    mVar dteTime = m$.var("dteTime");
    dteTime.set(m$.Fnc.$ztimestamp());
    //<< set idUser  = %session.SessionId
    mVar idUser = m$.var("idUser");
    idUser.set(m$.getSession().getSessionId());
    //<< 
    //<< kill ^CacheTempScriptTag(idUser,$job)
    m$.var("^CacheTempScriptTag",idUser.get(),m$.Fnc.$job()).kill();
    //<< 
    //<< set ^CacheTempInHyperEvent(idUser,$job) = $$$NO                  //SR13594
    m$.var("^CacheTempInHyperEvent",idUser.get(),m$.Fnc.$job()).set(include.COMSYS.$$$NO(m$));
    //<< ;set $piece(^zzUsers(%request.CgiEnvs("REMOTE_ADDR"),$zcvt(%request.Data("YBED",1),"u")),"~",2)=$h
    //<< set JobWatchUrl       = $get(%request.CgiEnvs("HTTP_REFERER"))
    mVar JobWatchUrl = m$.var("JobWatchUrl");
    JobWatchUrl.set(m$.Fnc.$get(m$.getRequest().getCgiEnvs("HTTP_REFERER")));
    //<< set blnSessionLoginOK = $$^WWWLicenseAllocation()                //FIS SR15550 21-Jun-2007
    mVar blnSessionLoginOK = m$.var("blnSessionLoginOK");
    blnSessionLoginOK.set(m$.fnc$("WWWLicenseAllocation.main"));
    //<< set %KEY("HYPER")     = ..EscapeURL(..Encrypt("User.www.HyperEvent"))
    m$.var("%KEY","HYPER").set(m$.fnc$(this,"EscapeURL",m$.fnc$(this,"Encrypt","User.www.HyperEvent")));
    //<< ;set %compiler.Get("%cspDocObject").NeedBroker=1
    //<< set %KEY("HYPER")     = ..HyperEventCall("User.www.HyperEvent","Para,Value",0)
    m$.var("%KEY","HYPER").set(m$.fnc$(this,"HyperEventCall","User.www.HyperEvent","Para,Value",0));
    //<< set %KEY("HYPERTEST") = ..HyperEventCall("COM.Popup.Event","Object,Value",0)
    m$.var("%KEY","HYPERTEST").set(m$.fnc$(this,"HyperEventCall","COM.Popup.Event","Object,Value",0));
    //<< 
    //<< do NastyAmpersandHack^WWWFORMCrossBrowserSupport()      ;SR17427
    m$.Cmd.Do("WWWFORMCrossBrowserSupport.NastyAmpersandHack");
    //<< 
    //<< set YI = $get(%request.Data("EP",1))  ;ENTRY POINT
    mVar YI = m$.var("YI");
    YI.set(m$.Fnc.$get(m$.getRequest().varData("EP",1)));
    //<< if YI'="" {
    if (mOp.NotEqual(YI.get(),"")) {
      //<< set YM   = $get(%request.Data("YM",1))        ;MANDANT
      mVar YM = m$.var("YM");
      YM.set(m$.Fnc.$get(m$.getRequest().varData("YM",1)));
      //<< set YBED = $get(%request.Data("YBED",1))      ;BEDIENER
      mVar YBED = m$.var("YBED");
      YBED.set(m$.Fnc.$get(m$.getRequest().varData("YBED",1)));
      //<< 
      //<< if $piece(YBED,"-",2)'="" {
      if (mOp.NotEqual(m$.Fnc.$piece(YBED.get(),"-",2),"")) {
        //<< set %request.Data("YM",1)   = $piece(YBED,"-",2)  ;WECHSEL MANDANT
        m$.getRequest().setData("YM",1,m$.Fnc.$piece(YBED.get(),"-",2));
        //<< set %request.Data("YBED",1) = $piece(YBED,"-",1)
        m$.getRequest().setData("YBED",1,m$.Fnc.$piece(YBED.get(),"-",1));
      }
      //<< }
      //<< set %("%KEY","XMLHTTPREQ")=1
      m$.var("%","%KEY","XMLHTTPREQ").set(1);
      //<< 
      //<< if $get(YUSER)="" set YUSER = $get(%request.Data("YUSER",1))
      if (mOp.Equal(m$.Fnc.$get(m$.var("YUSER")),"")) {
        mVar YUSER = m$.var("YUSER");
        YUSER.set(m$.Fnc.$get(m$.getRequest().varData("YUSER",1)));
      }
      //<< if $data(^WWWEP(0)) && +$piece($get(^WWWEP(0,YI,1)),"~",1)=0 {   ;UNERLAUBTER ZUGRIFF
      if (mOp.Equal(mOp.Logical(m$.Fnc.$data(m$.var("^WWWEP",0))) && mOp.Logical(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWEP",0,YI.get(),1)),"~",1))),0)) {
        //<< write "<HTML><BODY><H2>NO ACCESS (1001)</H2></BODY></HTML>"
        m$.Cmd.Write("<HTML><BODY><H2>NO ACCESS (1001)</H2></BODY></HTML>");
      }
      //<< 
      //<< } elseif (YI'="WWWMENU") && (YUSER'="") && ($$$WWWUSERFrameFormed($GET(^WWWUSER(0,YUSER,1)))="") {
      else if ((mOp.NotEqual(YI.get(),"WWWMENU")) && (mOp.NotEqual(m$.var("YUSER").get(),"")) && (mOp.Equal(include.WWWConst.$$$WWWUSERFrameFormed(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1))),""))) {
        //<< // BR014262 -If we are not going to the menu, and there is no frameset, create one.
        //<< do ^WWWVAR
        m$.Cmd.Do("WWWVAR.main");
        //<< $$$StartScript()  ;SR17454
        include.COMSYS.$$$StartScript(m$);
        //<< do Setup^WWWFORMCrossBrowserSupport() ;SR17454
        m$.Cmd.Do("WWWFORMCrossBrowserSupport.Setup");
        //<< $$$EndScript()      ;SR17454
        include.COMSYS.$$$EndScript(m$);
        //<< ;$$$StartFrameSet(0,"","if (document.frames) {document.frames[0].location = window.location;} else {this.location.href = window.location.href;}")  //SR17343
        //<< ;$$$StartFrameSet(0,"","document.frames[0].location = window.location;")  //SR17343  ;SR17454
        //<< ;SR17603 $$$StartFrameSet(0,"","parent.frames[0].location = window.location;")  //SR17343  ;SR17454  ;SR17457
        //<< $$$StartFrameSet(0,"","window.frames[0].location = window.location;")  //SR17343  ;SR17454  ;SR17457  ;SR17603
        include.COMSYSWWW.$$$StartFrameSet(m$,0,"","window.frames[0].location = window.location;");
        //<< write "<FRAME scrolling=yes>"
        m$.Cmd.Write("<FRAME scrolling=yes>");
        //<< $$$EndFrameSet
        include.COMSYSWWW.$$$EndFrameSet(m$);
      }
      //<< 
      //<< } elseif $$ExecuteCode^COMUtils("do ^"_YI) {    ;START FORM/HELP/SEARCH/MENU...
      else if (mOp.Logical(m$.fnc$("COMUtils.ExecuteCode",mOp.Concat("do ^",YI.get())))) {
        //<< set YI="1"
        YI.set("1");
      }
      //<< 
      //<< } else {
      else {
        //<< write "<HTML><BODY><H2>NO ACCESS (1002) </H2></BODY></HTML>"
        m$.Cmd.Write("<HTML><BODY><H2>NO ACCESS (1002) </H2></BODY></HTML>");
      }
    }
    //<< }
    //<< } else {
    else {
      //<< write "<HTML><BODY><H2>NO ACCESS (1003) </H2></BODY></HTML>"
      m$.Cmd.Write("<HTML><BODY><H2>NO ACCESS (1003) </H2></BODY></HTML>");
    }
    //<< }
    //<< 
    //<< //Finish any pending exporting operations, if any
    //<< //do ##class(SourceControl.Exporter).FlushExports(0)
    //<< 
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  //<< 
  }

//<< /*
//<< IF YI'="" DO
//<< . SET YM=$GET(%request.Data("YM",1)) ;MANDANT
//<< . DO  ;IF YM'="" DO
//<< . . SET YBED=$GET(%request.Data("YBED",1))  ;BEDIENER
//<< . . IF $PIECE(YBED,"-",2)'="" DO
//<< . . . SET %request.Data("YM",1)=$PIECE(YBED,"-",2)  ;WECHSEL MANDANT
//<< . . . SET %request.Data("YBED",1)=$PIECE(YBED,"-",1)
//<< . ;
//<< . set %("%KEY","XMLHTTPREQ")=1
//<< . ;
//<< . IF YI'="" IF $DATA(^WWWEP(0)) IF +$PIECE($GET(^WWWEP(0,YI,1)),"~",1)=0 DO  QUIT  ;UNERLAUBTER ZUGRIFF
//<< . . WRITE "<HTML><BODY><H2>NO ACCESS (1001)</H2></BODY></HTML>"
//<< . ;
//<< . DO
//<< . . IF $DATA(^ROUTINE(YI)) DO @("^"_YI) S YI="1" QUIT   ;START FORM/HELP/SEARCH/MENU...
//<< . . WRITE "<HTML><BODY><H2>NO ACCESS (1002) </H2></BODY></HTML>"
//<< IF YI="" WRITE "<HTML><BODY><H2>NO ACCESS (1003) </H2></BODY></HTML>"
//<< 
//<< quit $$$OK
//<< */
//<< }
//<< 
//<< }
}
