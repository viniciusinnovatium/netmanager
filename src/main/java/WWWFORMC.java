//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMC
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:44
//*****************************************************************************

import mLibrary.*;

//<< #include WWWFORM
import include.WWWFORM;
import include.WWWConst;

//<< WWWFORMC
public class WWWFORMC extends mClass {

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
    _WWWFORMC();
  }

  public void _WWWFORMC() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORMC("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Button with forms     BUTTON BEI forMULAREN
    //<< ;
    //<< ; Inputs :
    //<< ;   YFORM           idForm
    //<< ;   YVOR            objWWW120
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 14-Jun-2012   shobby  SR18033: Javascript buttons may be enable or disabled dynamically.
    //<< ; 08-Jul-2009   shobby  SR16455.2:  Start a new line even if the button marked
    //<< ;                           for this is not displayed.
    //<< ; 24-Jan-2008   shobby  SRBR014526: Call to standard Coolbar function.
    //<< ; 27-Jun-2007   Karine  SRBR014535: Changes to improve the code
    //<< ; 25-Jun-2007   shobby  SRBR014490: Pass in the button number (YLFN) to $$Disabled
    //<< ; 22-Jun-2007   Karine  SRBR014535: Show in the button title the form header that the
    //<< ;                       button points to.
    //<< ; 07-Jun-2007   RPW     SRBR014417: Allow List Forms to use the Download button
    //<< ;                       as well. INMAIL was missing it's button
    //<< ; 07-May-2007   GRF     SR15511: Doco; replace if and if not tests with if/else
    //<< ; 03-Jan-2007   JW      SR15240: Revision to OpenTD macro for Disabled buttons
    //<< ; 25-Oct-2006   JW      BR014279: Grid check for selected record - append to
    //<< ;                           confirmation text.
    //<< ; 24-Aug-2006   GRF     Doco
    //<< ; 13-Jan-2006   JW      SR13195: Rewrote to use braces/macros/functions.
    //<< ; 14-Sep-2005   RPW     SR13438: Change the $$$Alert($$^WWWTEXT into $$$Alert($lb
    //<< ; 08-Sep-2005   shobby  SR13438: Use $$$Alert macro when creating the alert message,
    //<< ;                           this handles things like quotes in the alert message.
    //<< ; 28-Jul-2005   RPW     SR11983: Check for YOPTION="" when piece 50 of the button
    //<< ;                           def is not ""
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 29.09.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new YI,YA,I,YLFN,SPRACHE,YEXEC,YKEYXX,YBPOS,YPRINT,Q,YQ,YCHECK
    mVar YI = m$.var("YI");
    mVar YA = m$.var("YA");
    mVar I = m$.var("I");
    mVar YLFN = m$.var("YLFN");
    mVar SPRACHE = m$.var("SPRACHE");
    mVar YEXEC = m$.var("YEXEC");
    mVar YKEYXX = m$.var("YKEYXX");
    mVar YBPOS = m$.var("YBPOS");
    mVar YPRINT = m$.var("YPRINT");
    mVar Q = m$.var("Q");
    mVar YQ = m$.var("YQ");
    mVar YCHECK = m$.var("YCHECK");
    m$.newVar(YI,YA,I,YLFN,SPRACHE,YEXEC,YKEYXX,YBPOS,YPRINT,Q,YQ,YCHECK);
    //<< new oldYBACK,blnButtons,blnNextLine,idxForm,xferVar,strPic,strTitle
    mVar oldYBACK = m$.var("oldYBACK");
    mVar blnButtons = m$.var("blnButtons");
    mVar blnNextLine = m$.var("blnNextLine");
    mVar idxForm = m$.var("idxForm");
    mVar xferVar = m$.var("xferVar");
    mVar strPic = m$.var("strPic");
    mVar strTitle = m$.var("strTitle");
    m$.newVar(oldYBACK,blnButtons,blnNextLine,idxForm,xferVar,strPic,strTitle);
    //<< 
    //<< $$$LogR("",YFORM)
    $$$LogR(m$,"",m$.var("YFORM"));
    //<< 
    //<< set blnNextLine = $$$NO
    blnNextLine.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< ;;VERTEILERBUTTON
    //<< ;if YBEDBER=1 write YCR,YCR,"<!-- ************************* SPECIAL BUTTON (WWWFORMC) ************************* -->",YCR,YCR
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   YA          objWWW124       Buttons
    //<< ;   YVOR        objWWW120       Form
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< set blnButtons = $$$WWW120PicturesAsButtons(YVOR)
    blnButtons.set(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.var("YVOR")));
    //<< 
    //<< if YFOART=5 if '$data(^WWW122(0,YFORM)) set YWIDTH="",YHEIGHT=""
    if (mOp.Equal(m$.var("YFOART").get(),5)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
        mVar YWIDTH = m$.var("YWIDTH");
        YWIDTH.set("");
        mVar YHEIGHT = m$.var("YHEIGHT");
        YHEIGHT.set("");
      }
    }
    //<< if $$$WWW120StandardSubmit(YVOR)="" if 'blnButtons write "<TR>" ;nicht bilder als button UND KEIN STANDARDSUBMIT ;not when And no
    if (mOp.Equal(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),"")) {
      if (mOp.Not(blnButtons.get())) {
        m$.Cmd.Write("<TR>");
      }
    }
    //<< 
    //<< set YI=0
    YI.set(0);
    //<< set SPRACHE  = $$^WWWLANGU(YBED)
    SPRACHE.set(m$.fnc$("WWWLANGU.main",m$.var("YBED").get()));
    //<< set LANGUAGE = SPRACHE
    mVar LANGUAGE = m$.var("LANGUAGE");
    LANGUAGE.set(SPRACHE.get());
    //<< set oldYBACK = YBACK
    oldYBACK.set(m$.var("YBACK").get());
    //<< 
    //<< ; SEARCH BUTTONS
    //<< set idxForm = $$^WWWUMLAU(YFORM,1)
    idxForm.set(m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1));
    //<< set YBPOS   = ""
    YBPOS.set("");
    //<< for {
    for (;true;) {
      //<< set YBPOS = $order(^WWW124s(0,2,idxForm,SPRACHE,YBPOS))
      YBPOS.set(m$.Fnc.$order(m$.var("^WWW124s",0,2,idxForm.get(),SPRACHE.get(),YBPOS.get())));
      //<< quit:YBPOS=""
      if (mOp.Equal(YBPOS.get(),"")) {
        break;
      }
      //<< 
      //<< set YLFN = ""       ;alle angelegten Button ;All Button
      YLFN.set("");
      //<< for {
      for (;true;) {
        //<< set YLFN = $order(^WWW124s(0,2,idxForm,SPRACHE,YBPOS,YFORM,SPRACHE,YLFN))
        YLFN.set(m$.Fnc.$order(m$.var("^WWW124s",0,2,idxForm.get(),SPRACHE.get(),YBPOS.get(),m$.var("YFORM").get(),SPRACHE.get(),YLFN.get())));
        //<< quit:YLFN=""
        if (mOp.Equal(YLFN.get(),"")) {
          break;
        }
        //<< 
        //<< set YA = $get(^WWW124(0,YFORM,SPRACHE,YLFN,1))
        YA.set(m$.Fnc.$get(m$.var("^WWW124",0,m$.var("YFORM").get(),SPRACHE.get(),YLFN.get(),1)));
        //<< if ($$$WWW124FunctionJavaScriptOnClick(YA)'="")&&($$$WWW124Dynamic(YA)) {                   ;SR18033
        if ((mOp.NotEqual(include.WWWConst.$$$WWW124FunctionJavaScriptOnClick(m$,YA),"")) && mOp.Logical((include.WWWConst.$$$WWW124Dynamic(m$,YA)))) {
          //<< write $$Button^WWWFORMC2012(YA,oldYBACK,.YI,YPARA,YMANDANT,YOPTION,YFORM,SPRACHE,YLFN)  ;SR18033
          m$.Cmd.Write(m$.fnc$("WWWFORMC2012.Button",YA.get(),oldYBACK.get(),YI,m$.var("YPARA").get(),m$.var("YMANDANT").get(),m$.var("YOPTION").get(),m$.var("YFORM").get(),SPRACHE.get(),YLFN.get()));
        }
        //<< } else {
        else {
          //<< set Q     = ""
          Q.set("");
          //<< set YQ    = ""
          YQ.set("");
          //<< set YBACK = oldYBACK
          mVar YBACK = m$.var("YBACK");
          YBACK.set(oldYBACK.get());
          //<< if $extract($$$WWW124TargetFrameName(YA))="@" set YBACK  = ""   ;TYBD;OHNE YBACK ;without
          if (mOp.Equal(m$.Fnc.$extract(include.WWWConst.$$$WWW124TargetFrameName(m$,YA)),"@")) {
            YBACK.set("");
          }
          //<< 
          //<< if $$$WWW124NextLine(YA) set blnNextLine = $$$WWW124NextLine(YA)
          if (mOp.Logical(include.WWWConst.$$$WWW124NextLine(m$,YA))) {
            blnNextLine.set(include.WWWConst.$$$WWW124NextLine(m$,YA));
          }
          //<< 
          //<< continue:$$DontShow()
          if (mOp.Logical(m$.fnc$("DontShow"))) {
            continue;
          }
          //<< continue:$$^WWWACCESS($$$WWW124Authorization1(YA),$$$WWW124Module1(YA))'=$$$YES  ;KEIN ZUGANG ;no
          if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",include.WWWConst.$$$WWW124Authorization1(m$,YA),include.WWWConst.$$$WWW124Module1(m$,YA)),include.COMSYS.$$$YES(m$))) {
            continue;
          }
          //<< continue:(($$$WWW124ExecuteOnClick(YA)="")            &&
          //<< ($$$WWW124NewFormOnClick(YA)="")            &&
          //<< ($$$WWW124LinkWithexeOrHttp(YA)="")         &&
          //<< ($$$WWW124DownloadFileOnClick(YA)="")       &&
          //<< ($$$WWW124FunctionJavaScriptOnClick(YA)="") &&
          //<< ($$$WWW124ExecuteForManualLink(YA)="")      &&
          //<< ($$$WWW124SearchFunctionOnClick(YA)="")     &&
          //<< ($$$WWW124ChangeoversWithOnClick(YA)="")    &&
          //<< ($$$WWW124QueryOnClick(YA)="")              &&
          //<< ($$$WWW124HyperEventOnClick(YA)="")            )   // No actions
          if (mOp.Logical(((mOp.Equal(include.WWWConst.$$$WWW124ExecuteOnClick(m$,YA),"")) && (mOp.Equal(include.WWWConst.$$$WWW124NewFormOnClick(m$,YA),"")) && (mOp.Equal(include.WWWConst.$$$WWW124LinkWithexeOrHttp(m$,YA),"")) && (mOp.Equal(include.WWWConst.$$$WWW124DownloadFileOnClick(m$,YA),"")) && (mOp.Equal(include.WWWConst.$$$WWW124FunctionJavaScriptOnClick(m$,YA),"")) && (mOp.Equal(include.WWWConst.$$$WWW124ExecuteForManualLink(m$,YA),"")) && (mOp.Equal(include.WWWConst.$$$WWW124SearchFunctionOnClick(m$,YA),"")) && (mOp.Equal(include.WWWConst.$$$WWW124ChangeoversWithOnClick(m$,YA),"")) && (mOp.Equal(include.WWWConst.$$$WWW124QueryOnClick(m$,YA),"")) && (mOp.Equal(include.WWWConst.$$$WWW124HyperEventOnClick(m$,YA),""))))) {
            continue;
          }
          //<< 
          //<< set strTitle = $$GetButtonDescription^WWW124(YFORM,SPRACHE,YLFN)
          strTitle.set(m$.fnc$("WWW124.GetButtonDescription",m$.var("YFORM").get(),SPRACHE.get(),YLFN.get()));
          //<< 
          //<< set YPRINT = ""
          YPRINT.set("");
          //<< if $$$WWW124OutputWithWindowprint(YA)=$$$YES set YPRINT = $$$YES  ;ZIEL DRUCKEN ;target print
          if (mOp.Equal(include.WWWConst.$$$WWW124OutputWithWindowprint(m$,YA),include.COMSYS.$$$YES(m$))) {
            YPRINT.set(include.COMSYS.$$$YES(m$));
          }
          //<< 
          //<< if $$$WWW124QueryOnClick(YA)'="" set $$$WWW124ExecuteOnClick(YA)="QUERY,"_$$$WWW124QueryOnClick(YA)  ;QUERY AUFRUFEN
          if (mOp.NotEqual(include.WWWConst.$$$WWW124QueryOnClick(m$,YA),"")) {
            include.WWWConst.$$$WWW124ExecuteOnClickSet(m$,YA,mOp.Concat("QUERY,",include.WWWConst.$$$WWW124QueryOnClick(m$,YA)));
          }
          //<< 
          //<< set xferVar = $$$WWW124TransferVariableIdentifie(YA)
          xferVar.set(include.WWWConst.$$$WWW124TransferVariableIdentifie(m$,YA));
          //<< if xferVar'="" {   ;ZUSATZVARIABLE
          if (mOp.NotEqual(xferVar.get(),"")) {
            //<< if $data(@xferVar) {
            if (mOp.Logical(m$.Fnc.$data(m$.indirectVar(xferVar.get())))) {
              //<< set @xferVar = $get(%(YQUERY,xferVar))
              m$.indirectVar(xferVar.get()).set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),xferVar.get())));
            }
          }
          //<< }
          //<< }
          //<< 
          //<< set YI = YI+1
          YI.set(mOp.Add(YI.get(),1));
          //<< 
          //<< if blnNextLine && blnButtons {
          if (mOp.Logical(blnNextLine.get()) && mOp.Logical(blnButtons.get())) {
            //<< set blnNextLine = $$$NO
            blnNextLine.set(include.COMSYS.$$$NO(m$));
            //<< write YCR,"<TD><IMG SRC="""_YGIF_"delimiter.gif""></TD>"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TD><IMG SRC=\"",m$.var("YGIF").get()),"delimiter.gif\"></TD>"));
            //<< write "</TR></TABLE>"
            m$.Cmd.Write("</TR></TABLE>");
            //<< write $$Coolbar^WWWFORMCOMMON("")
            m$.Cmd.Write(m$.fnc$("WWWFORMCOMMON.Coolbar",""));
            //<< write "<TR>"                      ;NEUE ZEILE
            m$.Cmd.Write("<TR>");
            //<< write "<TD WIDTH=3><IMG SRC="""_YGIF_"delimiter1.gif""></TD>"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD WIDTH=3><IMG SRC=\"",m$.var("YGIF").get()),"delimiter1.gif\"></TD>"));
          }
          //<< }
          //<< 
          //<< set strPic  = $$$WWW124PictureFileOnButton(YA)
          strPic.set(include.WWWConst.$$$WWW124PictureFileOnButton(m$,YA));
          //<< set newForm = $$$WWW124NewFormOnClick(YA)
          mVar newForm = m$.var("newForm");
          newForm.set(include.WWWConst.$$$WWW124NewFormOnClick(m$,YA));
          //<< 
          //<< ;KEIN BUTTON? ;no picture
          //<< if blnButtons && (strPic="") {
          if (mOp.Logical(blnButtons.get()) && (mOp.Equal(strPic.get(),""))) {
            //<< set strPic=$zconvert($extract($$^WWWUMLAU($$$WWW124ButtonDescription(YA),3)),"L")
            strPic.set(m$.Fnc.$zconvert(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA),3)),"L"));
            //<< if '$find("abcdefghijklmnopqrstuvwxyzöäüß@?1234567890",strPic) set strPic = "x"
            if (mOp.Not(m$.Fnc.$find("abcdefghijklmnopqrstuvwxyzöäüß@?1234567890",strPic.get()))) {
              strPic.set("x");
            }
            //<< set strPic = strPic_".gif"  ;KEIN BUTTON ABER BUTTON ;no yet
            strPic.set(mOp.Concat(strPic.get(),".gif"));
          }
          //<< }
          //<< 
          //<< set YTARGETF = $$$WWW124TargetFrameName(YA)
          mVar YTARGETF = m$.var("YTARGETF");
          YTARGETF.set(include.WWWConst.$$$WWW124TargetFrameName(m$,YA));
          //<< if $extract(YTARGETF)="@" set YTARGETF = @$extract(YTARGETF,2,99)  ;ZIELTARGET AUS PARAMETER ;out of parameter
          if (mOp.Equal(m$.Fnc.$extract(YTARGETF.get()),"@")) {
            YTARGETF.set(m$.indirectVar(m$.Fnc.$extract(YTARGETF.get(),2,99)).get());
          }
          //<< 
          //<< set YCONF1 = ""  ; Start JS
          mVar YCONF1 = m$.var("YCONF1");
          YCONF1.set("");
          //<< set YCONF2 = ""  ; End JS
          mVar YCONF2 = m$.var("YCONF2");
          YCONF2.set("");
          //<< 
          //<< continue:$$Disabled^WWWFORMB(newForm,blnButtons,strPic,$$$YES,.YCONF1,.YCONF2,YLFN)
          if (mOp.Logical(m$.fnc$("WWWFORMB.Disabled",newForm.get(),blnButtons.get(),strPic.get(),include.COMSYS.$$$YES(m$),YCONF1,YCONF2,YLFN.get()))) {
            continue;
          }
          //<< 
          //<< // Add confirmation text
          //<< 
          //<< if ($$$WWW124AcknowledgementTextBefore(YA)'="") {
          if ((mOp.NotEqual(include.WWWConst.$$$WWW124AcknowledgementTextBefore(m$,YA),""))) {
            //<< $$$Append(YCONF1," if (confirm('"_$translate($$$WWW124AcknowledgementTextBefore(YA),"'""","´´")_"')) {")
            include.COMSYSString.$$$Append(m$,YCONF1,mOp.Concat(mOp.Concat(" if (confirm('",m$.Fnc.$translate(include.WWWConst.$$$WWW124AcknowledgementTextBefore(m$,YA),"'\"","´´")),"')) {"));
            //<< $$$Prepend(YCONF2,"} ")
            include.COMSYSString.$$$Prepend(m$,YCONF2,"} ");
          }
          //<< }
          //<< 
          //<< if $$$WWW124AutomaticSUBMIT(YA) if newForm'="" if $$$WWW124ExecuteOnClick(YA)="" set $$$WWW124ExecuteOnClick(YA)="SUBMIT"   ;AUTOSUBMIT
          if (mOp.Logical(include.WWWConst.$$$WWW124AutomaticSUBMIT(m$,YA))) {
            if (mOp.NotEqual(newForm.get(),"")) {
              if (mOp.Equal(include.WWWConst.$$$WWW124ExecuteOnClick(m$,YA),"")) {
                include.WWWConst.$$$WWW124ExecuteOnClickSet(m$,YA,"SUBMIT");
              }
            }
          }
          //<< 
          //<< ;-------------------------------
          //<< 
          //<< $$$OpenTD($$$NO)
          include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
          //<< 
          //<< ;HREF DURCH MANUELLEN EXECUTE
          //<< if $$$WWW124ExecuteForManualLink(YA)'="" {
          if (mOp.NotEqual(include.WWWConst.$$$WWW124ExecuteForManualLink(m$,YA),"")) {
            //<< do MANU^WWWFORMB
            m$.Cmd.Do("WWWFORMB.MANU");
          }
          //<< 
          //<< } elseif $$$WWW124SearchFunctionOnClick(YA)'="" {
          else if (mOp.NotEqual(include.WWWConst.$$$WWW124SearchFunctionOnClick(m$,YA),"")) {
            //<< do Search(strTitle)
            m$.Cmd.Do("Search",strTitle.get());
          }
          //<< 
          //<< } elseif (newForm="") && ($zconvert($$$WWW124ExecuteOnClick(YA),"U")="SUBMIT") {      ; *** EXECUTE ***
          else if ((mOp.Equal(newForm.get(),"")) && (mOp.Equal(m$.Fnc.$zconvert(include.WWWConst.$$$WWW124ExecuteOnClick(m$,YA),"U"),"SUBMIT"))) {
            //<< do EXEC^WWWFORMB
            m$.Cmd.Do("WWWFORMB.EXEC");
          }
          //<< 
          //<< } elseif $$$UPPER($$$WWW124ExecuteOnClick(YA))="HELP" {                               ; *** EXECUTE ***
          else if (mOp.Equal(include.COMSYSString.$$$UPPER(m$,include.WWWConst.$$$WWW124ExecuteOnClick(m$,YA)),"HELP")) {
            //<< do Help(strTitle)
            m$.Cmd.Do("Help",strTitle.get());
          }
          //<< 
          //<< } elseif $$$WWW124ChangeoversWithOnClick(YA)'="" {
          else if (mOp.NotEqual(include.WWWConst.$$$WWW124ChangeoversWithOnClick(m$,YA),"")) {
            //<< do SEITE^WWWFORMB
            m$.Cmd.Do("WWWFORMB.SEITE");
          }
          //<< 
          //<< } elseif $$$WWW124FunctionJavaScriptOnClick(YA)'="" {
          else if (mOp.NotEqual(include.WWWConst.$$$WWW124FunctionJavaScriptOnClick(m$,YA),"")) {
            //<< do Java(strTitle)
            m$.Cmd.Do("Java",strTitle.get());
          }
          //<< 
          //<< } elseif $$$WWW124HyperEventOnClick(YA)'="" {
          else if (mOp.NotEqual(include.WWWConst.$$$WWW124HyperEventOnClick(m$,YA),"")) {
            //<< do HYPER^WWWFORMB
            m$.Cmd.Do("WWWFORMB.HYPER");
          }
          //<< 
          //<< } elseif $$$WWW124LinkWithexeOrHttp(YA)'="" {
          else if (mOp.NotEqual(include.WWWConst.$$$WWW124LinkWithexeOrHttp(m$,YA),"")) {
            //<< do VERKN^WWWFORMB
            m$.Cmd.Do("WWWFORMB.VERKN");
          }
          //<< 
          //<< } elseif ($$$WWW124DownloadFileOnClick(YA)'="") && (($get(YKEY)'="") || (YFOART=2)) {
          else if ((mOp.NotEqual(include.WWWConst.$$$WWW124DownloadFileOnClick(m$,YA),"")) && mOp.Logical(((mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY")),"")) || (mOp.Equal(m$.var("YFOART").get(),2))))) {
            //<< do Download(strTitle)
            m$.Cmd.Do("Download",strTitle.get());
          }
          //<< 
          //<< } elseif (newForm="") && ($$$WWW124ExecuteOnClick(YA)'="") {
          else if ((mOp.Equal(newForm.get(),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW124ExecuteOnClick(m$,YA),""))) {
            //<< do Exec(YBACK,strTitle)
            m$.Cmd.Do("Exec",YBACK.get(),strTitle.get());
          }
          //<< 
          //<< } elseif ($$$WWW124ExecuteOnClick(YA)="" || ($$$UPPER($$$WWW124ExecuteOnClick(YA))="SUBMIT")) && (newForm'="") {
          else if ((mOp.Equal(include.WWWConst.$$$WWW124ExecuteOnClick(m$,YA),"") || (mOp.Equal(include.COMSYSString.$$$UPPER(m$,include.WWWConst.$$$WWW124ExecuteOnClick(m$,YA)),"SUBMIT"))) && (mOp.NotEqual(newForm.get(),""))) {
            //<< do Exec2(YKEY,YBACK,strTitle)
            m$.Cmd.Do("Exec2",m$.var("YKEY").get(),YBACK.get(),strTitle.get());
          }
          //<< }
          //<< $$$CloseTD
          include.WWWFORM.$$$CloseTD(m$);
        }
      }
    }
    //<< 
    //<< ;-------------------------------
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if (($$^WWWACCESS(1)=$$$YES) || ($$^WWWACCESS(2)=$$$YES))     &&
    //<< ($get(YSCREENM)="")                                        &&
    //<< ($$$WWW013CompilerTranslator($get(^WWW013(0,YBED,1)))'="")    {
    if (mOp.Logical(((mOp.Equal(m$.fnc$("WWWACCESS.main",1),include.COMSYS.$$$YES(m$))) || (mOp.Equal(m$.fnc$("WWWACCESS.main",2),include.COMSYS.$$$YES(m$))))) && (mOp.Equal(m$.Fnc.$get(m$.var("YSCREENM")),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW013CompilerTranslator(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))),""))) {
      //<< 
      //<< set YSCREENM = 2  ;ENABLE TOOLBAR for SYSADMIN AND CUSTOMIZING TOOLBAR for DATABASE ADMIN;FIS;03.05.05;SR12200
      mVar YSCREENM = m$.var("YSCREENM");
      YSCREENM.set(2);
    }
    //<< }
    //<< if (+$get(YSCREENM)'=0) && ((YFOART=1) || (YFOART=4) || (YFOART=3)) {
    if ((mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("YSCREENM"))),0)) && mOp.Logical(((mOp.Equal(m$.var("YFOART").get(),1)) || (mOp.Equal(m$.var("YFOART").get(),4)) || (mOp.Equal(m$.var("YFOART").get(),3))))) {
      //<< new YPRINT
      m$.newVar(YPRINT);
      //<< do ^WWWSCRB  ;SCREEN DFLT BUTTON
      m$.Cmd.Do("WWWSCRB.main");
    }
    //<< }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< DontShow()
  public Object DontShow(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Works out whether a button should not be displayed
    //<< ; *** Some parts deprecated by single company 0 ***
    //<< ;
    //<< ; Called By: ^WWWFORMC
    //<< ;
    //<< ; ByRefs:
    //<< ;   YA
    //<< ;   YMANDANT
    //<< ;   YOPTION
    //<< ;
    //<< ; Returns: boolean
    //<< ;
    //<< ; History:
    //<< ; 20-Dec-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnDontShow,strOnlyShow
    mVar blnDontShow = m$.var("blnDontShow");
    mVar strOnlyShow = m$.var("strOnlyShow");
    m$.newVar(blnDontShow,strOnlyShow);
    //<< 
    //<< set blnDontShow = $$$NO
    blnDontShow.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if $$$WWW124ButtonBelongsToADataItem(YA) {
    if (mOp.Logical(include.WWWConst.$$$WWW124ButtonBelongsToADataItem(m$,m$.var("YA")))) {
      //<< set blnDontShow = $$$YES
      blnDontShow.set(include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } elseif ($$$WWW124DisplayOnlyWhenMenuParam(YA)'="") && '$find(","_YPARA_",",","_$$$WWW124DisplayOnlyWhenMenuParam(YA)_",") {
    else if ((mOp.NotEqual(include.WWWConst.$$$WWW124DisplayOnlyWhenMenuParam(m$,m$.var("YA")),"")) && mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.var("YPARA").get()),","),mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW124DisplayOnlyWhenMenuParam(m$,m$.var("YA"))),",")))) {
      //<< set blnDontShow = $$$YES     ;NICHT ANZEIGE WEIL PARAMETER FALSCH ;Not Show since parameter wrong
      blnDontShow.set(include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } elseif ($$$WWW124ButtonOnlyForCompany(YA)'="") && '$find(","_$$$WWW124ButtonOnlyForCompany(YA)_",",","_YMANDANT_",") {
    else if ((mOp.NotEqual(include.WWWConst.$$$WWW124ButtonOnlyForCompany(m$,m$.var("YA")),"")) && mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW124ButtonOnlyForCompany(m$,m$.var("YA"))),","),mOp.Concat(mOp.Concat(",",m$.var("YMANDANT").get()),",")))) {
      //<< set blnDontShow = $$$YES
      blnDontShow.set(include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } elseif ($$$WWW124ButtonNotforCompany(YA)'="") && $find(","_$$$WWW124ButtonNotforCompany(YA)_",",","_YMANDANT_",") {
    else if ((mOp.NotEqual(include.WWWConst.$$$WWW124ButtonNotforCompany(m$,m$.var("YA")),"")) && mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW124ButtonNotforCompany(m$,m$.var("YA"))),","),mOp.Concat(mOp.Concat(",",m$.var("YMANDANT").get()),",")))) {
      //<< set blnDontShow = $$$YES
      blnDontShow.set(include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } else {
    else {
      //<< set strOnlyShow = $$$WWW124ShowOnlyWhenYOPTION(YA)
      strOnlyShow.set(include.WWWConst.$$$WWW124ShowOnlyWhenYOPTION(m$,m$.var("YA")));
      //<< if (strOnlyShow'="") && ((YOPTION="") || '$find(","_strOnlyShow_",",","_YOPTION_",")) {
      if ((mOp.NotEqual(strOnlyShow.get(),"")) && mOp.Logical(((mOp.Equal(m$.var("YOPTION").get(),"")) || mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",strOnlyShow.get()),","),mOp.Concat(mOp.Concat(",",m$.var("YOPTION").get()),",")))))) {
        //<< set blnDontShow = $$$YES
        blnDontShow.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnDontShow
    return blnDontShow.get();
  }

  //<< 
  //<< 
  //<< Download(pstrTitle)
  public Object Download(Object ... _p) {
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new strDownload,strField,strFile,strDirectory,objCompany,strChar
    mVar strDownload = m$.var("strDownload");
    mVar strField = m$.var("strField");
    mVar strFile = m$.var("strFile");
    mVar strDirectory = m$.var("strDirectory");
    mVar objCompany = m$.var("objCompany");
    mVar strChar = m$.var("strChar");
    m$.newVar(strDownload,strField,strFile,strDirectory,objCompany,strChar);
    //<< 
    //<< if blnButtons  {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< write "<A class=link"
      m$.Cmd.Write("<A class=link");
    }
    //<< } else {
    else {
      //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,m$.var("YA")))),""));
    }
    //<< }
    //<< 
    //<< $$$OpenOnClick
    include.WWWFORM.$$$OpenOnClick(m$);
    //<< $$$StartWindow
    include.WWWFORM.$$$StartWindow(m$);
    //<< 
    //<< set objCompany=$get(^WWW012(0,YM,1))
    objCompany.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
    //<< 
    //<< ;---------------------------------------
    //<< ;   May contain   [Path] VORG@ FieldNo @/ [File]
    //<< ;   Constructs    [Path] [SubPath] / [File]         where SubPath comes from INVORG DfieldNo
    //<< ;
    //<< ;   Likely FieldNo values match the FTP directories : 96,97,98,181,182,183,184,187
    //<< ;   Possibly also Standard directories - less likely?
    //<< ;   (No additional analysis has been performed to build this list <GRF>)
    //<< ;---------------------------------------
    //<< set strDownload=$$$WWW124DownloadFileOnClick(YA)
    strDownload.set(include.WWWConst.$$$WWW124DownloadFileOnClick(m$,m$.var("YA")));
    //<< 
    //<< if $find(strDownload,"VORG@") {                       ;BEC;26614;22.11.04
    if (mOp.Logical(m$.Fnc.$find(strDownload.get(),"VORG@"))) {
      //<< set strField = $piece($piece(strDownload,"VORG@",2),"@",1)
      strField.set(m$.Fnc.$piece(m$.Fnc.$piece(strDownload.get(),"VORG@",2),"@",1));
      //<< set strDownload=$piece(strDownload,"VORG@"_strField_"@/",1)_$piece($get(^INVORG(YM,YM,1)),Y,strField)_"/"_$piece(strDownload,"VORG@"_strField_"@/",2)    ;BEC;26614;22.11.04
      strDownload.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(strDownload.get(),mOp.Concat(mOp.Concat("VORG@",strField.get()),"@/"),1),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)),m$.var("Y").get(),strField.get())),"/"),m$.Fnc.$piece(strDownload.get(),mOp.Concat(mOp.Concat("VORG@",strField.get()),"@/"),2)));
    }
    //<< }
    //<< 
    //<< if $find(strDownload,"YM/")   set strDownload=$piece(strDownload,"YM/",1)_YM_"/"_$piece(strDownload,"YM/",2)
    if (mOp.Logical(m$.Fnc.$find(strDownload.get(),"YM/"))) {
      strDownload.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(strDownload.get(),"YM/",1),m$.var("YM").get()),"/"),m$.Fnc.$piece(strDownload.get(),"YM/",2)));
    }
    //<< if $find(strDownload,"YUCI/") set strDownload=$piece(strDownload,"YUCI/",1)_YUCI_"/"_$piece(strDownload,"YUCI/",2)
    if (mOp.Logical(m$.Fnc.$find(strDownload.get(),"YUCI/"))) {
      strDownload.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(strDownload.get(),"YUCI/",1),m$.var("YUCI").get()),"/"),m$.Fnc.$piece(strDownload.get(),"YUCI/",2)));
    }
    //<< set strDownload=$zconvert(strDownload,"L")
    strDownload.set(m$.Fnc.$zconvert(strDownload.get(),"L"));
    //<< set strDownload=$translate(strDownload,"/","\")
    strDownload.set(m$.Fnc.$translate(strDownload.get(),"/","\\"));
    //<< 
    //<< if $find(strDownload,"\auto\") {                      ;ANLEGEN UNTERVERZEICHNIS AUTOMATISCH ;put onto automatic
    if (mOp.Logical(m$.Fnc.$find(strDownload.get(),"\\auto\\"))) {
      //<< set strFile=$translate($$$WWW012PhysicalFTPDirectory(objCompany),"/","\")
      strFile.set(m$.Fnc.$translate(include.WWWConst.$$$WWW012PhysicalFTPDirectory(m$,objCompany),"/","\\"));
      //<< 
      //<< if $extract(strFile,$length(strFile))="\" set strFile=$extract(strFile,1,$length(strFile)-1)
      if (mOp.Equal(m$.Fnc.$extract(strFile.get(),m$.Fnc.$length(strFile.get())),"\\")) {
        strFile.set(m$.Fnc.$extract(strFile.get(),1,mOp.Subtract(m$.Fnc.$length(strFile.get()),1)));
      }
      //<< if $extract(strDownload)'="\" set strDownload="\"_strDownload
      if (mOp.NotEqual(m$.Fnc.$extract(strDownload.get()),"\\")) {
        strDownload.set(mOp.Concat("\\",strDownload.get()));
      }
      //<< 
      //<< set strDirectory=strFile_$piece(strDownload,"auto",1)_$translate(YKEY,", """)
      strDirectory.set(mOp.Concat(mOp.Concat(strFile.get(),m$.Fnc.$piece(strDownload.get(),"auto",1)),m$.Fnc.$translate(m$.var("YKEY").get(),", \"")));
      //<< 
      //<< if '##class(%Library.File).DirectoryExists(strDirectory) {
      if (mOp.Not(m$.fnc$("$Library.File.DirectoryExists",strDirectory.get()))) {
        //<< do ##class(%Library.File).CreateDirectoryChain(strDirectory)
        m$.Cmd.Do("$Library.File.CreateDirectoryChain",strDirectory.get());
      }
      //<< }
      //<< set strDownload = $piece(strDownload,"auto",1)_$translate(YKEY,", """)_$piece(strDownload,"auto",2,99)
      strDownload.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(strDownload.get(),"auto",1),m$.Fnc.$translate(m$.var("YKEY").get(),", \"")),m$.Fnc.$piece(strDownload.get(),"auto",2,99)));
    }
    //<< }
    //<< 
    //<< set strDownload = $translate(strDownload,"\","/")   ;LESEN AUTO strFile
    strDownload.set(m$.Fnc.$translate(strDownload.get(),"\\","/"));
    //<< 
    //<< if $find(strDownload,"auto") {
    if (mOp.Logical(m$.Fnc.$find(strDownload.get(),"auto"))) {
      //<< set strDownload = $piece(strDownload,"auto",1)_$translate(YKEY,", """)_$piece(strDownload,"auto",2,99)
      strDownload.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(strDownload.get(),"auto",1),m$.Fnc.$translate(m$.var("YKEY").get(),", \"")),m$.Fnc.$piece(strDownload.get(),"auto",2,99)));
    }
    //<< }
    //<< 
    //<< set strFile = $translate($$$WWW012VirtualFTPDirectory(objCompany),"\","/")
    strFile.set(m$.Fnc.$translate(include.WWWConst.$$$WWW012VirtualFTPDirectory(m$,objCompany),"\\","/"));
    //<< 
    //<< for {
    for (;true;) {
      //<< set strChar = $extract(strFile,$length(strFile))
      strChar.set(m$.Fnc.$extract(strFile.get(),m$.Fnc.$length(strFile.get())));
      //<< quit:strChar'="/"
      if (mOp.NotEqual(strChar.get(),"/")) {
        break;
      }
      //<< 
      //<< set strFile = $extract(strFile,1,$length(strFile)-1)
      strFile.set(m$.Fnc.$extract(strFile.get(),1,mOp.Subtract(m$.Fnc.$length(strFile.get()),1)));
    }
    //<< }
    //<< 
    //<< if $extract(strDownload)="/" set strDownload = $extract(strDownload,2,9999)  ; HERAUSNEHMEN
    if (mOp.Equal(m$.Fnc.$extract(strDownload.get()),"/")) {
      strDownload.set(m$.Fnc.$extract(strDownload.get(),2,9999));
    }
    //<< write "ftp://"_strFile_"/"_strDownload
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("ftp://",strFile.get()),"/"),strDownload.get()));
    //<< 
    //<< $$$EndWindow
    include.WWWFORM.$$$EndWindow(m$);
    //<< $$$CloseOnClick
    include.WWWFORM.$$$CloseOnClick(m$);
    //<< 
    //<< write ">"
    m$.Cmd.Write(">");
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< do StopButton^WWWFORMCOMMON($$^WWWUML(pstrTitle),strPic,$get(YFORM)_"_"_YLFN)
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWUML.main",pstrTitle.get()),m$.var("strPic").get(),mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YFORM")),"_"),m$.var("YLFN").get()));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Exec(YBACK,pstrTitle) ; FIXME : Pass blnButtons
  public Object Exec(Object ... _p) {
    mVar YBACK = m$.newVarRef("YBACK",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 29-Sep-2009   shobby  SR16913: Some rework to prevent multiple button clicking.
    //<< ; 02-May-2006   Steve S SR14592: Transaction buttons can no longer be doubleclicked
    //<< ;-------------------------------------------------------------------------------
    //<< new YEXE,strAction
    mVar YEXE = m$.var("YEXE");
    mVar strAction = m$.var("strAction");
    m$.newVar(YEXE,strAction);
    //<< 
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< write "<A class=link "
      m$.Cmd.Write("<A class=link ");
    }
    //<< } else {
    else {
      //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,m$.var("YA")))),""));
    }
    //<< }
    //<< $$$OpenOnClick
    include.WWWFORM.$$$OpenOnClick(m$);
    //<< set strAction = ""
    strAction.set("");
    //<< if $$$WWW124BlankDuringProcessing(YA) set strAction = strAction_" NewPage(document.WWW); "
    if (mOp.Logical(include.WWWConst.$$$WWW124BlankDuringProcessing(m$,m$.var("YA")))) {
      strAction.set(mOp.Concat(strAction.get()," NewPage(document.WWW); "));
    }
    //<< if $$$WWW124AutomaticSUBMIT(YA)       set strAction = strAction_" BEARB('',1); retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9'); "
    if (mOp.Logical(include.WWWConst.$$$WWW124AutomaticSUBMIT(m$,m$.var("YA")))) {
      strAction.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strAction.get()," BEARB('',1); retval=EventValue('"),m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','Y"),m$.var("YFORM").get()),"','','9'); "));
    }
    //<< 
    //<< 
    //<< set strAction = strAction_$select(YTARGETF="":" window.location='",1:" subWindow('")
    strAction.set(mOp.Concat(strAction.get(),m$.Fnc.$select(mOp.Equal(m$.var("YTARGETF").get(),"")," window.location='",1," subWindow('")));
    //<< 
    //<< if $$$WWW124SetVariableYPARA(YA)'="" new YPARA set YPARA=$$$WWW124SetVariableYPARA(YA)   ; new parameter
    if (mOp.NotEqual(include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA")),"")) {
      mVar YPARA = m$.var("YPARA");
      m$.newVar(YPARA);
      YPARA.set(include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA")));
    }
    //<< set strAction = strAction_YAKTION
    strAction.set(mOp.Concat(strAction.get(),m$.var("YAKTION").get()));
    //<< if $$$WWW124DoNotPrepareHTML(YA)  {
    if (mOp.Logical(include.WWWConst.$$$WWW124DoNotPrepareHTML(m$,m$.var("YA")))) {
      //<< set strAction = strAction_"EP=WWWMANU1&amp;YFORM="_YFORM
      strAction.set(mOp.Concat(mOp.Concat(strAction.get(),"EP=WWWMANU1&amp;YFORM="),m$.var("YFORM").get()));
    }
    //<< 
    //<< } else {
    else {
      //<< set strAction = strAction_"EP=WWWMANU&amp;YFORM="_YFORM
      strAction.set(mOp.Concat(mOp.Concat(strAction.get(),"EP=WWWMANU&amp;YFORM="),m$.var("YFORM").get()));
    }
    //<< }
    //<< set YBACK = YBACK_YFORM_","
    YBACK.set(mOp.Concat(mOp.Concat(YBACK.get(),m$.var("YFORM").get()),","));
    //<< if $extract($$$WWW124TargetFrameName(YA))="@" set YBACK=""   ; without YBACK
    if (mOp.Equal(m$.Fnc.$extract(include.WWWConst.$$$WWW124TargetFrameName(m$,m$.var("YA"))),"@")) {
      YBACK.set("");
    }
    //<< if $extract($$$WWW124ExecuteOnClick(YA))="""" {              ; EXECUTE
    if (mOp.Equal(m$.Fnc.$extract(include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA"))),"\"")) {
      //<< set YEXE = $$$WWW124ExecuteOnClick(YA)
      YEXE.set(include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA")));
      //<< set YEXE = "s $piece(YA,Y,6)="_YEXE
      YEXE.set(mOp.Concat("s $piece(YA,Y,6)=",YEXE.get()));
      //<< xecute YEXE
      m$.Cmd.Xecute(YEXE.get());
    }
    //<< }
    //<< if '$$$WWW124DoNotPrepareHTML(YA) set strAction=strAction_"&YEXEC="_$translate($$$WWW124ExecuteOnClick(YA),"# ""","*|`")                                            ;16913
    if (mOp.Not(include.WWWConst.$$$WWW124DoNotPrepareHTML(m$,m$.var("YA")))) {
      strAction.set(mOp.Concat(mOp.Concat(strAction.get(),"&YEXEC="),m$.Fnc.$translate(include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA")),"# \"","*|`")));
    }
    //<< if $$$WWW124DoNotPrepareHTML(YA)  set strAction=strAction_"&YEXEC="_$translate($$$WWW124ExecuteOnClick(YA),"# ""%","*|`")       // Is it correct to remove '%' ?    ;16913
    if (mOp.Logical(include.WWWConst.$$$WWW124DoNotPrepareHTML(m$,m$.var("YA")))) {
      strAction.set(mOp.Concat(mOp.Concat(strAction.get(),"&YEXEC="),m$.Fnc.$translate(include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA")),"# \"%","*|`")));
    }
    //<< 
    //<< if $$$WWW124TransferVariableIdentifie(YA)'="" set strAction=strAction_"&"_$$$WWW124TransferVariableIdentifie(YA)_"="_@($$$WWW124TransferVariableIdentifie(YA))
    if (mOp.NotEqual(include.WWWConst.$$$WWW124TransferVariableIdentifie(m$,m$.var("YA")),"")) {
      strAction.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strAction.get(),"&"),include.WWWConst.$$$WWW124TransferVariableIdentifie(m$,m$.var("YA"))),"="),m$.indirectVar((include.WWWConst.$$$WWW124TransferVariableIdentifie(m$,m$.var("YA")))).get()));
    }
    //<< set strAction=strAction_$$WWWCGI2^WWWCGI()
    strAction.set(mOp.Concat(strAction.get(),m$.fnc$("WWWCGI.WWWCGI2")));
    //<< if YTARGETF'="" if YTARGETF'=YTARGET set strAction=strAction_"&YLOCKBACK="_YTRAKT  ;AKTUELLE LOCKDATEI BEI SCHLIESSEN ZURÜCKHOLEN
    if (mOp.NotEqual(m$.var("YTARGETF").get(),"")) {
      if (mOp.NotEqual(m$.var("YTARGETF").get(),m$.var("YTARGET").get())) {
        strAction.set(mOp.Concat(mOp.Concat(strAction.get(),"&YLOCKBACK="),m$.var("YTRAKT").get()));
      }
    }
    //<< 
    //<< write $$DoOnClick^WWWBUTTON(strAction)
    m$.Cmd.Write(m$.fnc$("WWWBUTTON.DoOnClick",strAction.get()));
    //<< write $select(YTARGETF="":"' ",1:"','"_YTARGETF_"') ")
    m$.Cmd.Write(m$.Fnc.$select(mOp.Equal(m$.var("YTARGETF").get(),""),"' ",1,mOp.Concat(mOp.Concat("','",m$.var("YTARGETF").get()),"') ")));
    //<< 
    //<< $$$CloseOnClick
    include.WWWFORM.$$$CloseOnClick(m$);
    //<< 
    //<< write ">"
    m$.Cmd.Write(">");
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< do StopButton^WWWFORMCOMMON($$^WWWUML(pstrTitle),strPic,$get(YFORM)_"_"_YLFN)
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWUML.main",pstrTitle.get()),m$.var("strPic").get(),mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YFORM")),"_"),m$.var("YLFN").get()));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< }
    //<< if $$$WWW124DMSFileForTargetHttp(YA)'="" do ABLAGE
    if (mOp.NotEqual(include.WWWConst.$$$WWW124DMSFileForTargetHttp(m$,m$.var("YA")),"")) {
      m$.Cmd.Do("ABLAGE");
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Exec2(YKEY,YBACK,pstrTitle) ; FIXME : Pass blnButtons
  public Object Exec2(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YBACK = m$.newVarRef("YBACK",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 02-May-2006   SteveS  SR14592: Transaction buttons can no longer be double-clicked
    //<< ;-------------------------------------------------------------------------------
    //<< new MAPPING,YNOKEY,YNEXKEY,YI,MAP,idClass,YSCHLUES
    mVar MAPPING = m$.var("MAPPING");
    mVar YNOKEY = m$.var("YNOKEY");
    mVar YNEXKEY = m$.var("YNEXKEY");
    mVar YI = m$.var("YI");
    mVar MAP = m$.var("MAP");
    mVar idClass = m$.var("idClass");
    mVar YSCHLUES = m$.var("YSCHLUES");
    m$.newVar(MAPPING,YNOKEY,YNEXKEY,YI,MAP,idClass,YSCHLUES);
    //<< 
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< write "<A class=link"
      m$.Cmd.Write("<A class=link");
    }
    //<< } else {
    else {
      //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,m$.var("YA")))),"\""));
    }
    //<< }
    //<< 
    //<< $$$OpenOnClick
    include.WWWFORM.$$$OpenOnClick(m$);
    //<< if $$$WWW124BlankDuringProcessing(YA) write " NewPage(document.WWW); "
    if (mOp.Logical(include.WWWConst.$$$WWW124BlankDuringProcessing(m$,m$.var("YA")))) {
      m$.Cmd.Write(" NewPage(document.WWW); ");
    }
    //<< if ($zconvert($$$WWW124ExecuteOnClick(YA),"U")="SUBMIT") || $$$WWW124AutomaticSUBMIT(YA) {
    if ((mOp.Equal(m$.Fnc.$zconvert(include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA")),"U"),"SUBMIT")) || mOp.Logical(include.WWWConst.$$$WWW124AutomaticSUBMIT(m$,m$.var("YA")))) {
      //<< write "BEARB('',1); retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9');"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("BEARB('',1); retval=EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','Y"),m$.var("YFORM").get()),"','','9');"));
    }
    //<< }
    //<< $$$StartWindow
    include.WWWFORM.$$$StartWindow(m$);
    //<< 
    //<< if $$$WWW124SetVariableYPARA(YA)'="" new YPARA set YPARA=$$$WWW124SetVariableYPARA(YA)  ; new parameter
    if (mOp.NotEqual(include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA")),"")) {
      mVar YPARA = m$.var("YPARA");
      m$.newVar(YPARA);
      YPARA.set(include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA")));
    }
    //<< 
    //<< write YAKTION_""
    m$.Cmd.Write(mOp.Concat(m$.var("YAKTION").get(),""));
    //<< set YKEYXX  = YKEY
    mVar YKEYXX = m$.var("YKEYXX");
    YKEYXX.set(YKEY.get());
    //<< set MAPPING = $translate($$$WWW124DataItemMapToNewFormNnnn(YA),",",";")   ;FELDMAPPING XXX=FELD
    MAPPING.set(m$.Fnc.$translate(include.WWWConst.$$$WWW124DataItemMapToNewFormNnnn(m$,m$.var("YA")),",",";"));
    //<< if MAPPING'="" {
    if (mOp.NotEqual(MAPPING.get(),"")) {
      //<< set YNOKEY = YFORM  ;BEI RÜCKSPRUNG KEINE ÜBERGABE DES KEY´S ;next to no
      YNOKEY.set(m$.var("YFORM").get());
      //<< 
      //<< for YI=1:1 {
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        //<< set MAP = $piece(MAPPING,";",YI)
        MAP.set(m$.Fnc.$piece(MAPPING.get(),";",YI.get()));
        //<< quit:MAP=""
        if (mOp.Equal(MAP.get(),"")) {
          break;
        }
        //<< 
        //<< if ($piece(MAP,"=",1)=0) || ($piece(MAP,"=",1)=999) {
        if ((mOp.Equal(m$.Fnc.$piece(MAP.get(),"=",1),0)) || (mOp.Equal(m$.Fnc.$piece(MAP.get(),"=",1),999))) {
          //<< set $piece(YKEY,",",+$piece(MAP,"=",2))  = ""
          m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set("");
          //<< set $piece(YFKEY,",",+$piece(MAP,"=",2)) = ""   ;KEINE VORGABE ;no default
          m$.pieceVar(m$.var("YFKEY"),",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set("");
        }
        //<< 
        //<< } elseif $extract($piece(MAP,"=",1))="""" {
        else if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(MAP.get(),"=",1)),"\"")) {
          //<< set $piece(YKEY,",",+$piece(MAP,"=",2)) = $translate($piece(MAP,"=",1),"""")
          m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set(m$.Fnc.$translate(m$.Fnc.$piece(MAP.get(),"=",1),"\""));
        }
        //<< 
        //<< } elseif $extract($piece(MAP,"=",1))="P" {
        else if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(MAP.get(),"=",1)),"P")) {
          //<< set $piece(YKEY,",",+$piece(MAP,"=",2)) = $piece(YKEYXX,",",+$extract($piece(MAP,"=",1),2,99))  ;AUS PRIMÄRSCHLÜSSEL
          m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set(m$.Fnc.$piece(YKEYXX.get(),",",mOp.Positive(m$.Fnc.$extract(m$.Fnc.$piece(MAP.get(),"=",1),2,99))));
        }
        //<< 
        //<< } else {
        else {
          //<< set $piece(YKEY,",",+$piece(MAP,"=",2)) = $piece(YFELD,Y,+$piece(MAP,"=",1))  ;AUS DATENFELD ;out of data item
          m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",1))));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< if newForm'="" {  ;PRUEFEN FPRMULAR AUF DATENINHALT ;upon
    if (mOp.NotEqual(m$.var("newForm").get(),"")) {
      //<< set idClass = $piece($get(^WWW120(0,newForm,1)),Y,11)
      idClass.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("newForm").get(),1)),m$.var("Y").get(),11));
      //<< 
      //<< if idClass'="" {   ;KEINE DATEI ;no data file
      if (mOp.NotEqual(idClass.get(),"")) {
        //<< set YSCHLUES="^"_idClass_"("_$$^WWWYM(idClass,1)
        YSCHLUES.set(mOp.Concat(mOp.Concat(mOp.Concat("^",idClass.get()),"("),m$.fnc$("WWWYM.main",idClass.get(),1)));
        //<< for YI=1:1 {
        for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
          //<< quit:$piece(YKEY,",",YI)=""
          if (mOp.Equal(m$.Fnc.$piece(YKEY.get(),",",YI.get()),"")) {
            break;
          }
          //<< 
          //<< set YSCHLUES=YSCHLUES_""""_$piece(YKEY,",",YI)_""""
          YSCHLUES.set(mOp.Concat(mOp.Concat(mOp.Concat(YSCHLUES.get(),"\""),m$.Fnc.$piece(YKEY.get(),",",YI.get())),"\""));
          //<< if $piece(YKEY,",",YI+1)'="" set YSCHLUES=YSCHLUES_","
          if (mOp.NotEqual(m$.Fnc.$piece(YKEY.get(),",",mOp.Add(YI.get(),1)),"")) {
            YSCHLUES.set(mOp.Concat(YSCHLUES.get(),","));
          }
        }
        //<< }
        //<< if $extract(YSCHLUES,$length(YSCHLUES))="," set YSCHLUES=$extract(YSCHLUES,1,$length(YSCHLUES)-1)
        if (mOp.Equal(m$.Fnc.$extract(YSCHLUES.get(),m$.Fnc.$length(YSCHLUES.get())),",")) {
          YSCHLUES.set(m$.Fnc.$extract(YSCHLUES.get(),1,mOp.Subtract(m$.Fnc.$length(YSCHLUES.get()),1)));
        }
        //<< if $length(YSCHLUES)'<($length(idClass)+1+$length($$^WWWYM(idClass))) {
        if (mOp.NotLess(m$.Fnc.$length(YSCHLUES.get()),(mOp.Add(mOp.Add(m$.Fnc.$length(idClass.get()),1),m$.Fnc.$length(m$.fnc$("WWWYM.main",idClass.get())))))) {
          //<< set YSCHLUES=YSCHLUES_")"
          YSCHLUES.set(mOp.Concat(YSCHLUES.get(),")"));
          //<< if $DATA(@(YSCHLUES)) {
          if (mOp.Logical(m$.Fnc.$data(m$.indirectVar((YSCHLUES.get()))))) {
            //<< set pstrTitle = "* "_pstrTitle
            pstrTitle.set(mOp.Concat("* ",pstrTitle.get()));
            //<< if $$$WWW124DisplayFirstDataRecord(YA) {    ;ERSTEN DATENSATZ AUSWÄHLEN ;data record pick out
            if (mOp.Logical(include.WWWConst.$$$WWW124DisplayFirstDataRecord(m$,m$.var("YA")))) {
              //<< set YNEXKEY = $piece($piece($QUERY(@YSCHLUES),"(",2),")",1)
              YNEXKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$query(m$.indirectVar(YSCHLUES.get())),"(",2),")",1));
              //<< set YNEXKEY = $piece(YNEXKEY,",",2,$length(YNEXKEY,",")-1)
              YNEXKEY.set(m$.Fnc.$piece(YNEXKEY.get(),",",2,mOp.Subtract(m$.Fnc.$length(YNEXKEY.get(),","),1)));
              //<< if '$find("-"_$translate(YNEXKEY,""""),"-"_$translate(YKEYXX,"""")) set YNEXKEY = ""
              if (mOp.Not(m$.Fnc.$find(mOp.Concat("-",m$.Fnc.$translate(YNEXKEY.get(),"\"")),mOp.Concat("-",m$.Fnc.$translate(YKEYXX.get(),"\""))))) {
                YNEXKEY.set("");
              }
              //<< if YNEXKEY'="" set YKEY = YNEXKEY
              if (mOp.NotEqual(YNEXKEY.get(),"")) {
                YKEY.set(YNEXKEY.get());
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
    //<< 
    //<< write "EP=WWWFORM&amp;YFORM="_newForm
    m$.Cmd.Write(mOp.Concat("EP=WWWFORM&amp;YFORM=",m$.var("newForm").get()));
    //<< set YBACK=YBACK_YFORM_","
    YBACK.set(mOp.Concat(mOp.Concat(YBACK.get(),m$.var("YFORM").get()),","));
    //<< 
    //<< if $extract($$$WWW124TargetFrameName(YA))="@" new YBACK set YBACK=""    ;OHNE YBACK ;without
    if (mOp.Equal(m$.Fnc.$extract(include.WWWConst.$$$WWW124TargetFrameName(m$,m$.var("YA"))),"@")) {
      YBACK = m$.var("YBACK");
      m$.newVar(YBACK);
      YBACK.set("");
    }
    //<< if $$$WWW124TransferVariableIdentifie(YA)'="" write "&"_$$$WWW124TransferVariableIdentifie(YA)_"="_$get(@($$$WWW124TransferVariableIdentifie(YA)))
    if (mOp.NotEqual(include.WWWConst.$$$WWW124TransferVariableIdentifie(m$,m$.var("YA")),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&",include.WWWConst.$$$WWW124TransferVariableIdentifie(m$,m$.var("YA"))),"="),m$.Fnc.$get(m$.indirectVar((include.WWWConst.$$$WWW124TransferVariableIdentifie(m$,m$.var("YA")))))));
    }
    //<< if YTARGETF'="" if YTARGETF'=YTARGET          write "&YLOCKBACK="_YTRAKT  ;AKTUELLE LOCKDATEI BEI SCHLIESSEN ZURÜCKHOLEN
    if (mOp.NotEqual(m$.var("YTARGETF").get(),"")) {
      if (mOp.NotEqual(m$.var("YTARGETF").get(),m$.var("YTARGET").get())) {
        m$.Cmd.Write(mOp.Concat("&YLOCKBACK=",m$.var("YTRAKT").get()));
      }
    }
    //<< do ^WWWCGI
    m$.Cmd.Do("WWWCGI.main");
    //<< 
    //<< $$$EndWindow
    include.WWWFORM.$$$EndWindow(m$);
    //<< $$$CloseOnClick
    include.WWWFORM.$$$CloseOnClick(m$);
    //<< 
    //<< write ">"
    m$.Cmd.Write(">");
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< do StopButton^WWWFORMCOMMON($$^WWWUML(pstrTitle),strPic,$get(YFORM)_"_"_YLFN)
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWUML.main",pstrTitle.get()),m$.var("strPic").get(),mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YFORM")),"_"),m$.var("YLFN").get()));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< }
    //<< if $$$WWW124DMSFileForTargetHttp(YA)'="" do ABLAGE
    if (mOp.NotEqual(include.WWWConst.$$$WWW124DMSFileForTargetHttp(m$,m$.var("YA")),"")) {
      m$.Cmd.Do("ABLAGE");
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Search(pstrTitle) ; FIXME : Pass blnButtons
  public Object Search(Object ... _p) {
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< write "<A class=link "
      m$.Cmd.Write("<A class=link ");
    }
    //<< } else {
    else {
      //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,m$.var("YA")))),""));
    }
    //<< }
    //<< 
    //<< write " onClick="""
    m$.Cmd.Write(" onClick=\"");
    //<< if $$$WWW124SetVariableYPARA(YA)'="" write "document.WWW.YPARA.value='"_$$$WWW124SetVariableYPARA(YA)_"'; "  ;PARAMETER NEU
    if (mOp.NotEqual(include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA")),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat("document.WWW.YPARA.value='",include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA"))),"'; "));
    }
    //<< write " ShowSearch();"
    m$.Cmd.Write(" ShowSearch();");
    //<< write """>"
    m$.Cmd.Write("\">");
    //<< 
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< do StopButton^WWWFORMCOMMON($$^WWWUML(pstrTitle),strPic,$get(YFORM)_"_"_YLFN)
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWUML.main",pstrTitle.get()),m$.var("strPic").get(),mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YFORM")),"_"),m$.var("YLFN").get()));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Help(pstrTitle) ; FIXME : Pass blnButtons
  public Object Help(Object ... _p) {
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show a help button
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Dec-2006   JW      SR14235: Added reference to child window
    //<< ;-------------------------------------------------------------------------------
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< write "<A class=link "
      m$.Cmd.Write("<A class=link ");
    }
    //<< } else {
    else {
      //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML(pstrText)_""" "
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",m$.var("pstrText").get())),"\" "));
    }
    //<< }
    //<< write " onClick=""subWindow('"_YAKTION_"EP=WWWHELP&amp;YFORM="_YFORM_$$WWWCGI2^WWWCGI($$$YES)_"');"">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onClick=\"subWindow('",m$.var("YAKTION").get()),"EP=WWWHELP&amp;YFORM="),m$.var("YFORM").get()),m$.fnc$("WWWCGI.WWWCGI2",include.COMSYS.$$$YES(m$))),"');\">"));
    //<< 
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< do StopButton^WWWFORMCOMMON($$^WWWUML(pstrTitle),strPic,$get(YFORM)_"_"_YLFN)
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWUML.main",pstrTitle.get()),m$.var("strPic").get(),mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YFORM")),"_"),m$.var("YLFN").get()));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Java(pstrTitle="") ; FIXME : Pass blnButtons
  public Object Java(Object ... _p) {
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< write $$Java^WWWFORMC2012(pstrTitle)            ;SR18033
    m$.Cmd.Write(m$.fnc$("WWWFORMC2012.Java",pstrTitle.get()));
    //<< ;SR18033 ;-------------------------------------------------------------------------------
    //<< ;SR18033 ;-------------------------------------------------------------------------------
    //<< ;SR18033 if blnButtons {
    //<< ;SR18033    write "<A onClick='return doLink(this)' HREF=""JavaScript:"_YCONF1
    //<< ;SR18033 } else {
    //<< ;SR18033    write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick="""_YCONF1
    //<< ;SR18033 }
    //<< ;SR18033 if $$$WWW124AutomaticSUBMIT(YA)=1    write "retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9');"
    //<< ;SR18033 if $$$WWW124SetVariableYPARA(YA)'="" write "document.WWW.YPARA.value='"_$$$WWW124SetVariableYPARA(YA)_"'; "  ;PARAMETER NEU
    //<< ;SR18033 write $$$WWW124FunctionJavaScriptOnClick(YA)
    //<< ;SR18033 if '$find($$$WWW124FunctionJavaScriptOnClick(YA),";") write ";"
    //<< ;SR18033 write YCONF2
    //<< ;SR18033 write """"
    //<< ;SR18033 if YTARGETF'="" write " TARGET="""_YTARGETF_""""
    //<< ;SR18033 write ">"
    //<< ;SR18033 if blnButtons {
    //<< ;SR18033    do StopButton^WWWFORMCOMMON($$^WWWUML(pstrTitle),strPic,$get(YFORM)_"_"_YLFN)
    //<< ;SR18033    write "</A>"
    //<< ;SR18033 }
    //<< quit
    return null;
  }

  //<< 
  //<< //++++++++++++++++++++++++++++++++++++++
  //<< // JW - Don't believe the following are used
  //<< //++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< ABLAGE ;SPEICHERN URL IN ZWISCHENDATEI ;Save URL within
  public Object ABLAGE() {
    //<< quit
    return null;
  }

  //<< 
  //<< ABLAGE1
  public Object ABLAGE1() {
    //<< quit:$length($piece(YVOR,Y,15))<3
    if (mOp.Less(m$.Fnc.$length(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),15)),3)) {
      return null;
    }
    //<< quit:$translate(YKEY,",*+-. """)=""
    if (mOp.Equal(m$.Fnc.$translate(m$.var("YKEY").get(),",*+-. \""),"")) {
      return null;
    }
    //<< 
    //<< new YI,YURL,I
    mVar YI = m$.var("YI");
    mVar YURL = m$.var("YURL");
    mVar I = m$.var("I");
    m$.newVar(YI,YURL,I);
    //<< 
    //<< set YURL = $piece($get(^WWW012(0,YM,1)),Y,44)
    YURL.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),44));
    //<< set YI   = YAKTION
    YI.set(m$.var("YAKTION").get());
    //<< 
    //<< if +$$$WWW124DoNotPrepareHTML(YA)=$$$NO if $$$WWW124ExecuteOnClick(YA)'="" do
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW124DoNotPrepareHTML(m$,m$.var("YA"))),include.COMSYS.$$$NO(m$))) {
      if (mOp.NotEqual(include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA")),"")) {
        //<< . set YI=YI_"EP=WWWMANU&amp;YFORM="_YFORM
        YI.set(mOp.Concat(mOp.Concat(YI.get(),"EP=WWWMANU&amp;YFORM="),m$.var("YFORM").get()));
      }
    }
    //<< 
    //<< if +$$$WWW124DoNotPrepareHTML(YA)=$$$YES if $$$WWW124ExecuteOnClick(YA)'="" do
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW124DoNotPrepareHTML(m$,m$.var("YA"))),include.COMSYS.$$$YES(m$))) {
      if (mOp.NotEqual(include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA")),"")) {
        //<< . set YI=YI_"EP=WWWMANU1&amp;YFORM="_YFORM
        YI.set(mOp.Concat(mOp.Concat(YI.get(),"EP=WWWMANU1&amp;YFORM="),m$.var("YFORM").get()));
      }
    }
    //<< 
    //<< if $$$WWW124ExecuteOnClick(YA)="" if newForm'="" do
    if (mOp.Equal(include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA")),"")) {
      if (mOp.NotEqual(m$.var("newForm").get(),"")) {
        //<< . set YI=YI_"EP=WWWFORM&amp;YFORM="_newForm
        YI.set(mOp.Concat(mOp.Concat(YI.get(),"EP=WWWFORM&amp;YFORM="),m$.var("newForm").get()));
      }
    }
    //<< 
    //<< set YBACKX=YBACK
    mVar YBACKX = m$.var("YBACKX");
    YBACKX.set(m$.var("YBACK").get());
    //<< 
    //<< set YBACK=YBACK_YFORM_","
    mVar YBACK = m$.var("YBACK");
    YBACK.set(mOp.Concat(mOp.Concat(m$.var("YBACK").get(),m$.var("YFORM").get()),","));
    //<< if $extract($$$WWW124TargetFrameName(YA))="@" new YBACK set YBACK=""   ;TYBD;OHNE YBACK ;without
    if (mOp.Equal(m$.Fnc.$extract(include.WWWConst.$$$WWW124TargetFrameName(m$,m$.var("YA"))),"@")) {
      m$.newVar(YBACK);
      YBACK.set("");
    }
    //<< set YI=YI_"&YEXEC="_$translate($$$WWW124ExecuteOnClick(YA),"# ","*|")
    YI.set(mOp.Concat(mOp.Concat(YI.get(),"&YEXEC="),m$.Fnc.$translate(include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA")),"# ","*|")));
    //<< if $$$WWW124TransferVariableIdentifie(YA)'="" set YI=YI_"&"_$$$WWW124TransferVariableIdentifie(YA)_"="_@($$$WWW124TransferVariableIdentifie(YA))
    if (mOp.NotEqual(include.WWWConst.$$$WWW124TransferVariableIdentifie(m$,m$.var("YA")),"")) {
      YI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YI.get(),"&"),include.WWWConst.$$$WWW124TransferVariableIdentifie(m$,m$.var("YA"))),"="),m$.indirectVar((include.WWWConst.$$$WWW124TransferVariableIdentifie(m$,m$.var("YA")))).get()));
    }
    //<< do VAR^WWWCGI
    m$.Cmd.Do("WWWCGI.VAR");
    //<< set YBACK=YBACKX
    YBACK.set(YBACKX.get());
    //<< set YI(1)=$piece(YA,Y,16)
    YI.var(1).set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),16));
    //<< if $extract(YI(1))="/" set YI(1)=$extract(YI(1),2,99)
    if (mOp.Equal(m$.Fnc.$extract(YI.var(1).get()),"/")) {
      YI.var(1).set(m$.Fnc.$extract(YI.var(1).get(),2,99));
    }
    //<< if $extract(YI(1),$length(YI(1)))'="/" set YI(1)=YI(1)_"/"
    if (mOp.NotEqual(m$.Fnc.$extract(YI.var(1).get(),m$.Fnc.$length(YI.var(1).get())),"/")) {
      YI.var(1).set(mOp.Concat(YI.var(1).get(),"/"));
    }
    //<< set YI(1)=YI(1)_$translate(YKEY,",""","/")
    YI.var(1).set(mOp.Concat(YI.var(1).get(),m$.Fnc.$translate(m$.var("YKEY").get(),",\"","/")));
    //<< if $extract(YI(1))="/" set YI(1)=$extract(YI(1),2,999)
    if (mOp.Equal(m$.Fnc.$extract(YI.var(1).get()),"/")) {
      YI.var(1).set(m$.Fnc.$extract(YI.var(1).get(),2,999));
    }
    //<< if $extract(YI(1),$length(YI(1)))'="/" set YI(1)=YI(1)_"/"
    if (mOp.NotEqual(m$.Fnc.$extract(YI.var(1).get(),m$.Fnc.$length(YI.var(1).get())),"/")) {
      YI.var(1).set(mOp.Concat(YI.var(1).get(),"/"));
    }
    //<< set YI(3)=YI(1)
    YI.var(3).set(YI.var(1).get());
    //<< set YI(1)=""
    YI.var(1).set("");
    //<< for I=1:1 quit:$piece(YI(3),"/",I)=""  set YI(1)=$piece(YI(3),"/",I) do
    for (I.set(1);(true);I.set(mOp.Add(I.get(),1))) {
      if (mOp.Equal(m$.Fnc.$piece(YI.var(3).get(),"/",I.get()),"")) {
        break;
      }
      YI.var(1).set(m$.Fnc.$piece(YI.var(3).get(),"/",I.get()));
      //<< . if $extract(YI(1))="@" do
      if (mOp.Equal(m$.Fnc.$extract(YI.var(1).get()),"@")) {
        do {
          //<< . . if +$extract(YI(1),2,99)'=0 set YI(1)=$piece(YFELD,Y,+$extract(YI(1),2,99)) quit
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$extract(YI.var(1).get(),2,99)),0)) {
            YI.var(1).set(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Positive(m$.Fnc.$extract(YI.var(1).get(),2,99))));
            break;
          }
          //<< . . set YI(1)=$get(@($extract($piece(YI(3),"/",I),2,99)))
          YI.var(1).set(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$extract(m$.Fnc.$piece(YI.var(3).get(),"/",I.get()),2,99)))));
        } while (false);
      }
      //<< . ;
      //<< . if YI(1)="" set YI(1)="*"
      if (mOp.Equal(YI.var(1).get(),"")) {
        YI.var(1).set("*");
      }
      //<< . set $piece(YI(3),"/",I)=YI(1)
      m$.pieceVar(YI.var(3),"/",I.get()).set(YI.var(1).get());
    }
    //<< 
    //<< ;DATEI SPEICHERN ;data file Save
    //<< new II
    mVar II = m$.var("II");
    m$.newVar(II);
    //<< 
    //<< quit:$$$WWW124DMSFileForTargetHttp(YA)=""
    if (mOp.Equal(include.WWWConst.$$$WWW124DMSFileForTargetHttp(m$,m$.var("YA")),"")) {
      return null;
    }
    //<< 
    //<< set YI(1)=YI(3)
    YI.var(1).set(YI.var(3).get());
    //<< set YI(2)="^"_$$$WWW124DMSFileForTargetHttp(YA)_"("_$$^WWWYM($$$WWW124DMSFileForTargetHttp(YA))
    YI.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat("^",include.WWWConst.$$$WWW124DMSFileForTargetHttp(m$,m$.var("YA"))),"("),m$.fnc$("WWWYM.main",include.WWWConst.$$$WWW124DMSFileForTargetHttp(m$,m$.var("YA")))));
    //<< for II=1:1 quit:$piece(YI(1),"/",II)=""  set YI(2)=YI(2)_","""_$piece(YI(1),"/",II)_""""
    for (II.set(1);(true);II.set(mOp.Add(II.get(),1))) {
      if (mOp.Equal(m$.Fnc.$piece(YI.var(1).get(),"/",II.get()),"")) {
        break;
      }
      YI.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(YI.var(2).get(),",\""),m$.Fnc.$piece(YI.var(1).get(),"/",II.get())),"\""));
    }
    //<< set YI(2)=YI(2)_",1)"
    YI.var(2).set(mOp.Concat(YI.var(2).get(),",1)"));
    //<< set @YI(2)=YI_Y_+$HOROLOG
    m$.indirectVar(YI.var(2).get()).set(mOp.Concat(mOp.Concat(YI.get(),m$.var("Y").get()),mOp.Positive(m$.Fnc.$horolog())));
    //<< 
    //<< quit
    return null;
  }

//<< 
}
