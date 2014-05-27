//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMB
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:46
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWFORM
import include.WWWFORM;
import include.WWWConst;

//<< WWWFORMB
public class WWWFORMB extends mClass {

  public void main() {
    _WWWFORMB();
  }

  public void _WWWFORMB() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       FORMBUTTONS BUTTON NEBEN FELD - Form buttons beside field
    //<< ;       Builds the HTML for the button - actual execution on clicking the button
    //<< ;       occurs elsewhere.
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
    //<< ; 13-Nov-2007   shobby  SRBR014771: Wrapper the EXEC call in <TD> otherwise
    //<< ;                           multiple buttons against a field will appear on
    //<< ;                           different lines.  (INWEINVD)
    //<< ; 04-Jul-2007   RPW     SRBR014409: Now don't forget at the end that YLFN
    //<< ;                           MUST be set back to idYLFN.
    //<< ; 25-Jun-2007   shobby  BR014409:Remember what YLFN was before this routine
    //<< ;                           is called.  It is used in the ID of the images.
    //<< ; 11-Jun-2007   shobby  BR014409:Don't use YLFN as the loop for buttons.
    //<< ;                           We need that to preserve the id of the associated
    //<< ;                            field (set somewhere up the stack)
    //<< ; 07-May-2007   GRF     SR15511: Doco
    //<< ; 16-Dec-2005   JW      SR13195: Rewrote in brace syntax / functions
    //<< ; 15-Aug-2005   Steve S Doco
    //<< ; 28-Jul-2005   RPW     SR11983: Check for YOPTION="" when piece 50 of the button def is not ""
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 24-May-2005   Paul K  Problem with the use of variable "Q" instead of "YQ"
    //<< ;                           causing multiple buttons showing. SR:12351
    //<< ; 21.08.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< QUIT:YBUTT=""
    if (mOp.Equal(m$.var("YBUTT").get(),"")) {
      return;
    }
    //<< NEW YPRINT,YQ,YTARGET,blnButtons,newForm,strPic,idType,oldYBACK,idYLFN
    mVar YPRINT = m$.var("YPRINT");
    mVar YQ = m$.var("YQ");
    mVar YTARGET = m$.var("YTARGET");
    mVar blnButtons = m$.var("blnButtons");
    mVar newForm = m$.var("newForm");
    mVar strPic = m$.var("strPic");
    mVar idType = m$.var("idType");
    mVar oldYBACK = m$.var("oldYBACK");
    mVar idYLFN = m$.var("idYLFN");
    m$.newVar(YPRINT,YQ,YTARGET,blnButtons,newForm,strPic,idType,oldYBACK,idYLFN);
    //<< 
    //<< set blnButtons = $$$WWW120PicturesAsButtons($get(YVOR))
    blnButtons.set(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.Fnc.$get(m$.var("YVOR"))));
    //<< set idYLFN     = $get(YLFN)
    idYLFN.set(m$.Fnc.$get(m$.var("YLFN")));
    //<< 
    //<< ;IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* EXTRA BUTTON (WWWFORMB) ************************* -->",YCR,YCR
    //<< 
    //<< SET YBUTT=$TRANSLATE(YBUTT,";",",")
    mVar YBUTT = m$.var("YBUTT");
    YBUTT.set(m$.Fnc.$translate(m$.var("YBUTT").get(),";",","));
    //<< 
    //<< ;---------------------------------------
    //<< ; YA   = Button Record
    //<< ; YVOR = Form Definition
    //<< ;---------------------------------------
    //<< 
    //<< set oldYBACK = YBACK
    oldYBACK.set(m$.var("YBACK").get());
    //<< 
    //<< for YI=1:1 {
    mVar YI = m$.var("YI");
    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
      //<< quit:$PIECE(YBUTT,",",YI)=""
      if (mOp.Equal(m$.Fnc.$piece(YBUTT.get(),",",YI.get()),"")) {
        break;
      }
      //<< 
      //<< set YLFN = $piece(YBUTT,",",YI) ;NÄCHSTER BUTTEN
      mVar YLFN = m$.var("YLFN");
      YLFN.set(m$.Fnc.$piece(YBUTT.get(),",",YI.get()));
      //<< set YA   = $get(^WWW124(0,YFORM,SPRACHE,YLFN,1))
      mVar YA = m$.var("YA");
      YA.set(m$.Fnc.$get(m$.var("^WWW124",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),YLFN.get(),1)));
      //<< continue:YA=""
      if (mOp.Equal(YA.get(),"")) {
        continue;
      }
      //<< 
      //<< set YBACK = oldYBACK
      mVar YBACK = m$.var("YBACK");
      YBACK.set(oldYBACK.get());
      //<< if $EXTRACT($$$WWW124TargetFrameName(YA))="@" set YBACK=""   ;TYBD;OHNE YBACK ;without
      if (mOp.Equal(m$.Fnc.$extract(include.WWWConst.$$$WWW124TargetFrameName(m$,YA)),"@")) {
        YBACK.set("");
      }
      //<< 
      //<< set strPic = $$$WWW124PictureFileOnButton(YA)
      strPic.set(include.WWWConst.$$$WWW124PictureFileOnButton(m$,YA));
      //<< if blnButtons && (strPic="") {
      if (mOp.Logical(blnButtons.get()) && (mOp.Equal(strPic.get(),""))) {
        //<< set strPic = $zconvert($extract($$^WWWUMLAU($$$WWW124ButtonDescription(YA),3)),"L")
        strPic.set(m$.Fnc.$zconvert(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA),3)),"L"));
        //<< if '$find("abcdefghijklmnopqrstuvwxyzöäüß@?1234567890",strPic) SET strPic="x"
        if (mOp.Not(m$.Fnc.$find("abcdefghijklmnopqrstuvwxyzöäüß@?1234567890",strPic.get()))) {
          strPic.set("x");
        }
        //<< set strPic = strPic_".gif"  ;KEIN BUTTON ABER BUTTON ;no yet
        strPic.set(mOp.Concat(strPic.get(),".gif"));
      }
      //<< }
      //<< 
      //<< set newForm = $$$WWW124NewFormOnClick(YA)
      newForm.set(include.WWWConst.$$$WWW124NewFormOnClick(m$,YA));
      //<< continue:$$Disabled(newForm,blnButtons,strPic,1,"","",idYLFN)  ;BR014409
      if (mOp.Logical(m$.fnc$("Disabled",newForm.get(),blnButtons.get(),strPic.get(),1,"","",idYLFN.get()))) {
        continue;
      }
      //<< continue:$$^WWWACCESS($$$WWW124Authorization1(YA),$$$WWW124Module1(YA))'=1  ;KEIN ZUGANG ;no
      if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",include.WWWConst.$$$WWW124Authorization1(m$,YA),include.WWWConst.$$$WWW124Module1(m$,YA)),1)) {
        continue;
      }
      //<< continue:$$DontShow()
      if (mOp.Logical(m$.fnc$("DontShow"))) {
        continue;
      }
      //<< 
      //<< if $$$WWW124AutomaticSUBMIT(YA)         &&
      //<< (newForm'="")                        &&
      //<< ($$$WWW124HyperEventOnClick(YA)'="") &&
      //<< ($$$WWW124ExecuteOnClick(YA)="")        {
      if (mOp.Logical(include.WWWConst.$$$WWW124AutomaticSUBMIT(m$,YA)) && (mOp.NotEqual(newForm.get(),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW124HyperEventOnClick(m$,YA),"")) && (mOp.Equal(include.WWWConst.$$$WWW124ExecuteOnClick(m$,YA),""))) {
        //<< 
        //<< set $$$WWW124ExecuteOnClick(YA)="SUBMIT"   ;AUTOSUBMIT
        include.WWWConst.$$$WWW124ExecuteOnClickSet(m$,YA,"SUBMIT");
      }
      //<< }
      //<< set YPRINT=""
      YPRINT.set("");
      //<< if $$$WWW124OutputWithWindowprint(YA)=$$$YES set YPRINT=$$$YES  ;ZIEL DRUCKEN ;target print
      if (mOp.Equal(include.WWWConst.$$$WWW124OutputWithWindowprint(m$,YA),include.COMSYS.$$$YES(m$))) {
        YPRINT.set(include.COMSYS.$$$YES(m$));
      }
      //<< 
      //<< set YTARGETF = $$$WWW124TargetFrameName(YA)
      mVar YTARGETF = m$.var("YTARGETF");
      YTARGETF.set(include.WWWConst.$$$WWW124TargetFrameName(m$,YA));
      //<< if $extract(YTARGETF)="@" set YTARGETF = @$extract(YTARGETF,2,99)  ;FIS;26.09.03;ZIELTARGET AUS PARAMETER ;out of parameter
      if (mOp.Equal(m$.Fnc.$extract(YTARGETF.get()),"@")) {
        YTARGETF.set(m$.indirectVar(m$.Fnc.$extract(YTARGETF.get(),2,99)).get());
      }
      //<< set YTARGET = YTARGETF
      YTARGET.set(YTARGETF.get());
      //<< if $get(YVOR1)'=""        set YTARGET = $piece($$$WWW012TargetFrameName(YVOR1),"/",1)_YUSER
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YVOR1")),"")) {
        YTARGET.set(mOp.Concat(m$.Fnc.$piece(include.WWWConst.$$$WWW012TargetFrameName(m$,m$.var("YVOR1")),"/",1),m$.var("YUSER").get()));
      }
      //<< 
      //<< set YCONF1=""  ;VOR URL ;pre- URL
      mVar YCONF1 = m$.var("YCONF1");
      YCONF1.set("");
      //<< set YCONF2=""
      mVar YCONF2 = m$.var("YCONF2");
      YCONF2.set("");
      //<< if $$$WWW124AcknowledgementTextBefore(YA)'="" {   ; FIXME : Internationalise
      if (mOp.NotEqual(include.WWWConst.$$$WWW124AcknowledgementTextBefore(m$,YA),"")) {
        //<< set YCONF1 = "if (confirm('"_$TRANSLATE($$$WWW124AcknowledgementTextBefore(YA),"'""","´´")_"')) {"  ;FIS;31.01.05
        YCONF1.set(mOp.Concat(mOp.Concat("if (confirm('",m$.Fnc.$translate(include.WWWConst.$$$WWW124AcknowledgementTextBefore(m$,YA),"'\"","´´")),"')) {"));
        //<< set YCONF2 = "}"
        YCONF2.set("}");
      }
      //<< }
      //<< 
      //<< ;-----------------------------------
      //<< ; *** EXECUTE # ***
      //<< ;-----------------------------------
      //<< 
      //<< if $$$WWW124SearchFunctionOnClick(YA)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW124SearchFunctionOnClick(m$,YA),"")) {
        //<< set $$$WWW124DoNotPrepareHTML(YA)=0
        include.WWWConst.$$$WWW124DoNotPrepareHTMLSet(m$,YA,0);
        //<< set idType = $case(YART,"M":3,"D":2,"P":1,:"")
        idType.set(m$.Fnc.$case(m$.var("YART").get(),"M",3,"D",2,"P",1,""));
        //<< if idType'="" {
        if (mOp.NotEqual(idType.get(),"")) {
          //<< set $$$WWW124ExecuteOnClick(YA) = "D ^WWWSBU("_idType_")"
          include.WWWConst.$$$WWW124ExecuteOnClickSet(m$,YA,mOp.Concat(mOp.Concat("D ^WWWSBU(",idType.get()),")"));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if $$$WWW124HyperEventOnClick(YA)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW124HyperEventOnClick(m$,YA),"")) {
        //<< do HYPER
        m$.Cmd.Do("HYPER");
      }
      //<< 
      //<< } elseif $$$WWW124ExecuteForManualLink(YA)'="" {
      else if (mOp.NotEqual(include.WWWConst.$$$WWW124ExecuteForManualLink(m$,YA),"")) {
        //<< do MANU
        m$.Cmd.Do("MANU");
      }
      //<< 
      //<< } elseif $$$WWW124ChangeoversWithOnClick(YA)'="" {
      else if (mOp.NotEqual(include.WWWConst.$$$WWW124ChangeoversWithOnClick(m$,YA),"")) {
        //<< do SEITE
        m$.Cmd.Do("SEITE");
      }
      //<< 
      //<< } else {
      else {
        //<< if $$$WWW124QueryOnClick(YA)'="" set $$$WWW124ExecuteOnClick(YA)="QUERY,"_$$$WWW124QueryOnClick(YA)  ;QUERY AUFRUFEN
        if (mOp.NotEqual(include.WWWConst.$$$WWW124QueryOnClick(m$,YA),"")) {
          include.WWWConst.$$$WWW124ExecuteOnClickSet(m$,YA,mOp.Concat("QUERY,",include.WWWConst.$$$WWW124QueryOnClick(m$,YA)));
        }
        //<< 
        //<< if newForm'="" {
        if (mOp.NotEqual(newForm.get(),"")) {
          //<< do NORM
          m$.Cmd.Do("NORM");
        }
        //<< 
        //<< } elseif ($$$WWW124ExecuteOnClick(YA)'="") || ($$$WWW124FunctionJavaScriptOnClick(YA)'="") {
        else if ((mOp.NotEqual(include.WWWConst.$$$WWW124ExecuteOnClick(m$,YA),"")) || (mOp.NotEqual(include.WWWConst.$$$WWW124FunctionJavaScriptOnClick(m$,YA),""))) {
          //<< write "<TD ALIGN='ABSTOP'>"     ;BR014771
          m$.Cmd.Write("<TD ALIGN='ABSTOP'>");
          //<< do EXEC
          m$.Cmd.Do("EXEC");
          //<< write "</TD>"                   ;BR014771
          m$.Cmd.Write("</TD>");
        }
        //<< 
        //<< } elseif $$$WWW124LinkWithexeOrHttp(YA)'="" {
        else if (mOp.NotEqual(include.WWWConst.$$$WWW124LinkWithexeOrHttp(m$,YA),"")) {
          //<< do VERKN
          m$.Cmd.Do("VERKN");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< set YLFN=idYLFN  ;BR014409
    mVar YLFN = m$.var("YLFN");
    YLFN.set(idYLFN.get());
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< Disabled(newForm,blnButtons,strPic,pblnTD=$$$NO,&pstrStartJS,&pstrEndJS,pidYLFN)
  public Object Disabled(Object ... _p) {
    mVar newForm = m$.newVarRef("newForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar blnButtons = m$.newVarRef("blnButtons",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar strPic = m$.newVarRef("strPic",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnTD = m$.newVarRef("pblnTD",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    mVar pstrStartJS = m$.newVarRef("pstrStartJS",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pstrEndJS = m$.newVarRef("pstrEndJS",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pidYLFN = m$.newVarRef("pidYLFN",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Works out if button should be disabled, and if so, displays it as such.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: whether button should be disabled
    //<< ;
    //<< ; History:
    //<< ; 17-Aug-2009   shobby  SR16819:    When displaying javascript alerts on disabled buttons don't crash if
    //<< ;                           the text contains a "
    //<< ; 22-Sep-2008   shobby  SRBR014939: Moved DataItemInUse check to not be dependent on whether
    //<< ;                                   there is ExecuteToCheckForDisabled code.
    //<< ; 23-Jul-2008   GRF     SRBR014939: use macro & revised property name for WWW124
    //<< ; 30-Apr-2008   shobby  SRBR014939: Need to check YBEARB to find out if the
    //<< ;                           disable was because it is 'In Use'
    //<< ; 29-Apr-2008   shobby  SRBR014939: Disable buttons when Data Item In Use
    //<< ; 25-Jun-2007   shobby  SRBR014409: pidYLFN as a parameter
    //<< ; 25-Jun-2007   shobby  SRBR014409: More changes to the button id.
    //<< ; 11-Jun-2007   shobby  SRBR014409: Changes to button id to guarantee uniqueness
    //<< ; 08-Jun-2007   GRF     SRBR014417: property name changed
    //<< ; 03-Jan-2007   JW      SR15240: Revision to OpenTD macro for Disabled buttons
    //<< ; 25-Oct-2006   JW      BR014279: Grid check for selected record
    //<< ; 12-Sep-2006   JW      Convert alert text to JS
    //<< ; 16-Dec-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Q,YQ,blnDisabled,strText,strExec,blnHidden
    mVar Q = m$.var("Q");
    mVar YQ = m$.var("YQ");
    mVar blnDisabled = m$.var("blnDisabled");
    mVar strText = m$.var("strText");
    mVar strExec = m$.var("strExec");
    mVar blnHidden = m$.var("blnHidden");
    m$.newVar(Q,YQ,blnDisabled,strText,strExec,blnHidden);
    //<< 
    //<< set blnDisabled = $$$NO
    blnDisabled.set(include.COMSYS.$$$NO(m$));
    //<< set blnHidden   = $$$NO
    blnHidden.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< ;AUS WWWFORMC ÜBERNOMMEN ;FIS;24.02.03 ;out of
    //<< ;    5 = "Read Only"
    //<< if ($$$WWW120AuthorizationToModifyData($get(YVOR))=$$$EnumReadOnly) && '$$$WWW124AvailWhenDataItemIsInUse(YA) && ($get(YBEARB)=4) {  ;BR014939
    if ((mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.Fnc.$get(m$.var("YVOR"))),include.COMSYSEnum.$$$EnumReadOnly(m$))) && mOp.Not(include.WWWConst.$$$WWW124AvailWhenDataItemIsInUse(m$,m$.var("YA"))) && (mOp.Equal(m$.Fnc.$get(m$.var("YBEARB")),4))) {
      //<< set blnDisabled = $$$YES                                                ;BR014939
      blnDisabled.set(include.COMSYS.$$$YES(m$));
      //<< set strText     = $$$SysEnum("BEARBEITUNG",4)   ; "Data Item In Use"    ;BR014939
      strText.set(include.COMSYSWWW.$$$SysEnum(m$,"BEARBEITUNG",4));
    }
    //<< } else {
    else {
      //<< set strExec=$$$WWW124ExecuteToCheckForDisabled(YA)
      strExec.set(include.WWWConst.$$$WWW124ExecuteToCheckForDisabled(m$,m$.var("YA")));
      //<< if strExec'="" {   ;PRUEFEN DISABLED
      if (mOp.NotEqual(strExec.get(),"")) {
        //<< 
        //<< ;-----------------------------------
        //<< ; *** EXECUTE # ***
        //<< ;-----------------------------------
        //<< xecute strExec
        m$.Cmd.Xecute(strExec.get());
        //<< 
        //<< if (+$get(Q)=2) || (+$GET(YQ)=2) {
        if ((mOp.Equal(mOp.Positive(m$.Fnc.$get(Q)),2)) || (mOp.Equal(mOp.Positive(m$.Fnc.$get(YQ)),2))) {
          //<< set blnHidden = $$$YES
          blnHidden.set(include.COMSYS.$$$YES(m$));
        }
        //<< 
        //<< } elseif (+$get(Q)=1) || (+$GET(YQ)=1) {
        else if ((mOp.Equal(mOp.Positive(m$.Fnc.$get(Q)),1)) || (mOp.Equal(mOp.Positive(m$.Fnc.$get(YQ)),1))) {
          //<< set strText=""   ;S strText=$$^WWWTEXT(32072)
          strText.set("");
          //<< if $extract($get(Q),2,999)'=""  set strText = $extract(Q,2,999)
          if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$get(Q),2,999),"")) {
            strText.set(m$.Fnc.$extract(Q.get(),2,999));
          }
          //<< if $extract($get(YQ),2,999)'="" set strText = $extract(YQ,2,999)
          if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$get(YQ),2,999),"")) {
            strText.set(m$.Fnc.$extract(YQ.get(),2,999));
          }
          //<< set blnDisabled = $$$YES
          blnDisabled.set(include.COMSYS.$$$YES(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if 'blnHidden {
    if (mOp.Not(blnHidden.get())) {
      //<< if 'blnDisabled {
      if (mOp.Not(blnDisabled.get())) {
        //<< ;If there needs to be a key and there isn't one, disable.
        //<< ;
        //<< ;NOTE - TODO - this check should probably be BEFORE the xecute above.
        //<< 
        //<< ; SRBR014417
        //<< if $$$WWW124OnlyWhenRecordSelected(YA) || ((newForm'="") && (+$$$WWW121FixedInputForHiddenField($GET(^WWW121(0,newForm,1,1)))'=0)) {
        if (mOp.Logical(include.WWWConst.$$$WWW124OnlyWhenRecordSelected(m$,m$.var("YA"))) || mOp.Logical(((mOp.NotEqual(newForm.get(),"")) && (mOp.NotEqual(mOp.Positive(include.WWWConst.$$$WWW121FixedInputForHiddenField(m$,m$.Fnc.$get(m$.var("^WWW121",0,newForm.get(),1,1)))),0))))) {
          //<< if (YFOART=12) {        // BR014279 - Grid
          if ((mOp.Equal(m$.var("YFOART").get(),12))) {
            //<< set strText     = $$^WWWTEXT("WWW00053")    ; "Please select a saved grid record."
            strText.set(m$.fnc$("WWWTEXT.main","WWW00053"));
            //<< set pstrStartJS = "if "_$$GetDisabledCheck^COMGridEdit31J_" { alert('"_strText_"'); } else { "
            pstrStartJS.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("if ",m$.fnc$("COMGridEdit31J.GetDisabledCheck"))," { alert('"),strText.get()),"'); } else { "));
            //<< set pstrEndJS   = " }"
            pstrEndJS.set(" }");
          }
          //<< 
          //<< } else {                // Not grid
          else {
            //<< if blnButtons && $$IsNewRecord^WWWFORMStatus() {        // Don't know why only for buttons...
            if (mOp.Logical(blnButtons.get()) && mOp.Logical(m$.fnc$("WWWFORMStatus.IsNewRecord"))) {
              //<< set strText     = $$^WWWTEXT(32072)       ; "Please Select A Data Record First."
              strText.set(m$.fnc$("WWWTEXT.main",32072));
              //<< set blnDisabled = $$$YES
              blnDisabled.set(include.COMSYS.$$$YES(m$));
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< if blnDisabled {
      if (mOp.Logical(blnDisabled.get())) {
        //<< //if pblnTD $$$OpenTD           //SR15240
        //<< if pblnTD $$$OpenTD($$$YES)
        if (mOp.Logical(pblnTD.get())) {
          include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$YES(m$));
        }
        //<< if $$$WWW124ImageFileForDisabledButto(YA)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW124ImageFileForDisabledButto(m$,m$.var("YA")),"")) {
          //<< set strPic = $$$WWW124ImageFileForDisabledButto(YA)  ;NEUER DISABLED BUTTON
          strPic.set(include.WWWConst.$$$WWW124ImageFileForDisabledButto(m$,m$.var("YA")));
        }
        //<< 
        //<< } elseif $extract(strPic,2)="." {
        else if (mOp.Equal(m$.Fnc.$extract(strPic.get(),2),".")) {
          //<< set $piece(strPic,".",1) = $extract(strPic)_"_dis"      //SR15240
          m$.pieceVar(strPic,".",1).set(mOp.Concat(m$.Fnc.$extract(strPic.get()),"_dis"));
        }
        //<< }
        //<< 
        //<< if strPic'="" {
        if (mOp.NotEqual(strPic.get(),"")) {
          //<< if $$$WWW012DisplayButtonTooltips($get(^WWW012(0,YM,1))) {      //SR15240
          if (mOp.Logical(include.WWWConst.$$$WWW012DisplayButtonTooltips(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))))) {
            //<< do StopButton^WWWFORMCOMMON($$$HTMLText(strText),strPic,"Y"_$GET(YFORM)_"D"_$get(pidYLFN)_"_"_$GET(YLFN)_"IMG","","","cursor:default")
            m$.Cmd.Do("WWWFORMCOMMON.StopButton",include.COMSYSString.$$$HTMLText(m$,strText),strPic.get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.Fnc.$get(m$.var("YFORM"))),"D"),m$.Fnc.$get(pidYLFN)),"_"),m$.Fnc.$get(m$.var("YLFN"))),"IMG"),"","","cursor:default");
          }
          //<< } else {
          else {
            //<< if strText'="" write "<A onClick='return doLink(this)' HREF=""JavaScript:"_$$$HTMLText("alert('"_$$$JSText(strText)_"');")_""">"        //SR14979 ;16819
            if (mOp.NotEqual(strText.get(),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("<A onClick='return doLink(this)' HREF=\"JavaScript:",include.COMSYSString.$$$HTMLText(m$,mOp.Concat(mOp.Concat("alert('",include.COMSYSString.$$$JSText(m$,strText)),"');"))),"\">"));
            }
            //<< do StopButton^WWWFORMCOMMON($$^WWWUML($$$WWW124ButtonDescription(YA)),strPic,"Y"_$GET(YFORM)_"D"_$get(pidYLFN)_"_"_$GET(YLFN)_"IMG","","","cursor:default")
            m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,m$.var("YA"))),strPic.get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.Fnc.$get(m$.var("YFORM"))),"D"),m$.Fnc.$get(pidYLFN)),"_"),m$.Fnc.$get(m$.var("YLFN"))),"IMG"),"","","cursor:default");
            //<< if strText'="" write "</A>"
            if (mOp.NotEqual(strText.get(),"")) {
              m$.Cmd.Write("</A>");
            }
          }
        }
        //<< }
        //<< }
        //<< write YCR
        m$.Cmd.Write(m$.var("YCR").get());
        //<< if pblnTD $$$CloseTD
        if (mOp.Logical(pblnTD.get())) {
          include.WWWFORM.$$$CloseTD(m$);
        }
      }
    }
    //<< }
    //<< }
    //<< quit (blnDisabled || blnHidden)
    return (mOp.Logical(blnDisabled.get()) || mOp.Logical(blnHidden.get()));
  }

  //<< 
  //<< 
  //<< DontShow()
  public Object DontShow(Object ... _p) {
    //<< ;/*-------------------------------------------------------------------------------
    //<< ; Works out whether a button should not be displayed
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Dec-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< new blnDontShow,strOnlyShow
    mVar blnDontShow = m$.var("blnDontShow");
    mVar strOnlyShow = m$.var("strOnlyShow");
    m$.newVar(blnDontShow,strOnlyShow);
    //<< 
    //<< set blnDontShow = $$$NO
    blnDontShow.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if $$$WWW124DisplayOnlyWhenMenuParam(YA)'="" && '$FIND(","_YPARA_",",","_$$$WWW124DisplayOnlyWhenMenuParam(YA)_",") {  ;NICHT ANZEIGE WEIL PARAMETER FALSCH ;Not Show since parameter wrong
    if (mOp.NotEqual(include.WWWConst.$$$WWW124DisplayOnlyWhenMenuParam(m$,m$.var("YA")),"") && mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.var("YPARA").get()),","),mOp.Concat(mOp.Concat(",",include.WWWConst.$$$WWW124DisplayOnlyWhenMenuParam(m$,m$.var("YA"))),",")))) {
      //<< set blnDontShow = $$$YES
      blnDontShow.set(include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } else {
    else {
      //<< set strOnlyShow = $$$WWW124ShowOnlyWhenYOPTION(YA)
      strOnlyShow.set(include.WWWConst.$$$WWW124ShowOnlyWhenYOPTION(m$,m$.var("YA")));
      //<< if (strOnlyShow'="") && (YOPTION="" || '$FIND(","_strOnlyShow_",",","_YOPTION_",")) {
      if ((mOp.NotEqual(strOnlyShow.get(),"")) && (mOp.Equal(m$.var("YOPTION").get(),"") || mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",strOnlyShow.get()),","),mOp.Concat(mOp.Concat(",",m$.var("YOPTION").get()),","))))) {
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
  //<< NORM ;NORMAL MIT FORMULAR ;normal by means of form
  public void NORM() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;       call form
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Oct-2008   FIS     SR15962: removed quote masking again (not ok anymore
    //<< ;                           since change in SAVENOW() was made)
    //<< ; 25-Sep-2008   FIS     SR15962: allow multiple mapping values (same as WWWFORMC)
    //<< ; 25-Sep-2008   FIS     SR15964: mask quotes to stay as text string in SAVENOW()
    //<< ;-------------------------------------------------------------------------------
    //<< new MAPPING,strExec,strKEY,idX,strMAP,blnNewWindow
    mVar MAPPING = m$.var("MAPPING");
    mVar strExec = m$.var("strExec");
    mVar strKEY = m$.var("strKEY");
    mVar idX = m$.var("idX");
    mVar strMAP = m$.var("strMAP");
    mVar blnNewWindow = m$.var("blnNewWindow");
    m$.newVar(MAPPING,strExec,strKEY,idX,strMAP,blnNewWindow);
    //<< 
    //<< set MAPPING = $$$WWW124DataItemMapToNewFormNnnn(YA)
    MAPPING.set(include.WWWConst.$$$WWW124DataItemMapToNewFormNnnn(m$,m$.var("YA")));
    //<< 
    //<< set blnNewWindow = ((YTARGETF'="") && (YTARGETF'=YTARGET))
    blnNewWindow.set(((mOp.NotEqual(m$.var("YTARGETF").get(),"")) && (mOp.NotEqual(m$.var("YTARGETF").get(),m$.var("YTARGET").get()))));
    //<< 
    //<< if 'blnNewWindow {  ;NEUES FORMULAR ;something new form
    if (mOp.Not(blnNewWindow.get())) {
      //<< if MAPPING'="" set MAPPING="|"_$$^WWWTRANSLATE(MAPPING,"""","&quot;")  ;FIS;13.01.04;ANFÜHRUNGSZEICHEN ÜBERGEBEN
      if (mOp.NotEqual(MAPPING.get(),"")) {
        MAPPING.set(mOp.Concat("|",m$.fnc$("WWWTRANSLATE.main",MAPPING.get(),"\"","&quot;")));
      }
      //<< 
      //<< set strExec = "document.WWW.YBACK.value='"_YBACK_YFORM_",'; "
      strExec.set(mOp.Concat(mOp.Concat(mOp.Concat("document.WWW.YBACK.value='",m$.var("YBACK").get()),m$.var("YFORM").get()),",'; "));
      //<< set strExec = strExec_"document.WWW.target='"_$GET(YTARGETF)_"';"
      strExec.set(mOp.Concat(mOp.Concat(mOp.Concat(strExec.get(),"document.WWW.target='"),m$.Fnc.$get(m$.var("YTARGETF"))),"';"));
      //<< if ($zconvert($$$WWW124ExecuteOnClick(YA),"U")="SUBMIT") || $$$WWW124AutomaticSUBMIT(YA) {
      if ((mOp.Equal(m$.Fnc.$zconvert(include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA")),"U"),"SUBMIT")) || mOp.Logical(include.WWWConst.$$$WWW124AutomaticSUBMIT(m$,m$.var("YA")))) {
        //<< set strExec = strExec_"retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9');"
        strExec.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strExec.get(),"retval=EventValue('"),m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','Y"),m$.var("YFORM").get()),"','','9');"));
      }
      //<< }
      //<< 
      //<< set strExec = strExec_"document.WWW.YSEITE.value=1;"
      strExec.set(mOp.Concat(strExec.get(),"document.WWW.YSEITE.value=1;"));
      //<< set strExec = strExec_"SAVENOW('SAVEFORM"_$$$WWW124NewFormOnClick(YA)_MAPPING_"');"
      strExec.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strExec.get(),"SAVENOW('SAVEFORM"),include.WWWConst.$$$WWW124NewFormOnClick(m$,m$.var("YA"))),MAPPING.get()),"');"));
    }
    //<< ;   set strExec = strExec_"SAVENOW('\'SAVEFORM"_$$$WWW124NewFormOnClick(YA)_MAPPING_"\'');"  ;SR15964 ;SR15962 ;not required anymore since change in SAVENOW() was made
    //<< 
    //<< 
    //<< } else {  ;FORMULAR IN SEPARATEM FENSTER;FIS;16.04.04;25534
    else {
      //<< set strExec = "WWWFORM&amp;YFORM="_$PIECE(YA,Y,7)
      strExec.set(mOp.Concat("WWWFORM&amp;YFORM=",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7)));
      //<< if MAPPING'="" {
      if (mOp.NotEqual(MAPPING.get(),"")) {
        //<< SET strKEY=""
        strKEY.set("");
        //<< 
        //<< /*IF $EXTRACT($PIECE(MAPPING,"=",1))="""" {
        //<< SET $PIECE(strKEY,",",+$PIECE(MAPPING,"=",2))=$TRANSLATE($PIECE(MAPPING,"=",1),"""")  ;FESTER WERT ;worthy
        //<< } else {
        //<< IF $EXTRACT(MAPPING)="P" {
        //<< SET strKEY="' + document."_YHTMFORM_".Y"_YFORM_"P"_+$EXTRACT($PIECE(MAPPING,"=",1),2,99)_".value + '"  ;AUS PRIMÄRSCHLÜSSEL;FIS;27.09.04;26416
        //<< } else {
        //<< SET strKEY="' + document."_YHTMFORM_".Y"_YFORM_"D"_+$PIECE(MAPPING,"=",1)_".value + '"  ;AUS DATENSATZ ;out of data record
        //<< }
        //<< }*/
        //<< for idX=1:1 {  //allow multiple values (same as in WWWFORMC) ; vvv SR15962
        for (idX.set(1);(true);idX.set(mOp.Add(idX.get(),1))) {
          //<< set strMAP=$piece(MAPPING,";",idX)
          strMAP.set(m$.Fnc.$piece(MAPPING.get(),";",idX.get()));
          //<< quit:strMAP=""
          if (mOp.Equal(strMAP.get(),"")) {
            break;
          }
          //<< 
          //<< set:idX>1 strKEY = strKEY_","
          if (mOp.Greater(idX.get(),1)) {
            strKEY.set(mOp.Concat(strKEY.get(),","));
          }
          //<< if $EXTRACT($PIECE(strMAP,"=",1))="""" {
          if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(strMAP.get(),"=",1)),"\"")) {
            //<< SET $PIECE(strKEY,",",+$PIECE(strMAP,"=",2))=$TRANSLATE($PIECE(strMAP,"=",1),"""")  ;fix value
            m$.pieceVar(strKEY,",",mOp.Positive(m$.Fnc.$piece(strMAP.get(),"=",2))).set(m$.Fnc.$translate(m$.Fnc.$piece(strMAP.get(),"=",1),"\""));
          }
          //<< } else {
          else {
            //<< IF $EXTRACT(strMAP)="P" {
            if (mOp.Equal(m$.Fnc.$extract(strMAP.get()),"P")) {
              //<< SET strKEY="' + document."_YHTMFORM_".Y"_YFORM_"P"_+$EXTRACT($PIECE(strMAP,"=",1),2,99)_".value + '"  ;primary key
              strKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("' + document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),"P"),mOp.Positive(m$.Fnc.$extract(m$.Fnc.$piece(strMAP.get(),"=",1),2,99))),".value + '"));
            }
            //<< } else {
            else {
              //<< SET strKEY="' + document."_YHTMFORM_".Y"_YFORM_"D"_+$PIECE(strMAP,"=",1)_".value + '"  ;data field
              strKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("' + document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),"D"),mOp.Positive(m$.Fnc.$piece(strMAP.get(),"=",1))),".value + '"));
            }
          }
        }
        //<< }
        //<< }
        //<< }                                                            ; ^^^ SR15962
        //<< 
        //<< set strExec = strExec_"&YKEY="_strKEY
        strExec.set(mOp.Concat(mOp.Concat(strExec.get(),"&YKEY="),strKEY.get()));
      }
    }
    //<< }
    //<< }
    //<< do Button(strExec,blnNewWindow)
    m$.Cmd.Do("Button",strExec.get(),blnNewWindow.get());
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< SEITE   ;SEITENWECHSEL
  public void SEITE() {
    //<< new strExec
    mVar strExec = m$.var("strExec");
    m$.newVar(strExec);
    //<< 
    //<< set strExec = "document.WWW.target=''; document.WWW.YINSEITE.value=''; document.WWW.YSEITE.value='"_$$$WWW124ChangeoversWithOnClick(YA)_"'; SAVENOW(2);"
    strExec.set(mOp.Concat(mOp.Concat("document.WWW.target=''; document.WWW.YINSEITE.value=''; document.WWW.YSEITE.value='",include.WWWConst.$$$WWW124ChangeoversWithOnClick(m$,m$.var("YA"))),"'; SAVENOW(2);"));
    //<< do Button(strExec)
    m$.Cmd.Do("Button",strExec.get());
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< HYPER
  public void HYPER() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;       HYPER EVENT BEI ONCLICK ;next to
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Aug-2007   Frank   SRBR014566: Replace EventCall for CallBackNow, and remove
    //<< ;                       the property 'Set Variable YPARA' as the first parameter.
    //<< ;-------------------------------------------------------------------------------
    //<< new strExec,strHyper
    mVar strExec = m$.var("strExec");
    mVar strHyper = m$.var("strHyper");
    m$.newVar(strExec,strHyper);
    //<< 
    //<< set strHyper = $$$WWW124HyperEventOnClick(YA)
    strHyper.set(include.WWWConst.$$$WWW124HyperEventOnClick(m$,m$.var("YA")));
    //<< 
    //<< ; SRBR014566 vvvvvvv
    //<< set strExec = "    retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','"_$piece(strHyper,"(",1)_"','"_$$$WWW124SetVariableYPARA(YA)_"','6','"_$piece($piece(strHyper,"(",2),")",1)_"');"
    strExec.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("    retval=EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','"),m$.Fnc.$piece(strHyper.get(),"(",1)),"','"),include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA"))),"','6','"),m$.Fnc.$piece(m$.Fnc.$piece(strHyper.get(),"(",2),")",1)),"');"));
    //<< /*set strParams    = $piece($piece(strHyper,"(",2),")",1)
    //<< set strRoutine   = $piece(strHyper,"(",1)
    //<< 
    //<< set strParam1 = $piece(strParams, ",", 1)
    //<< 
    //<< set strParams = $piece(strParams, ",", 2)
    //<< set strParam2 = $piece(strParams, ",", 1)
    //<< 
    //<< set strParams = $piece(strParams, ",", 2)
    //<< set strParam3 = $piece(strParams, ",", 1)
    //<< 
    //<< set strParams = $piece(strParams, ",", 2)
    //<< set strParam4 = $piece(strParams, ",", 1)
    //<< 
    //<< set strExec = "   CallBackNow('"_strRoutine_"','"_strParam1_"','"_strParam2_"','"_strParam3_"','"_strParam4_"');"
    //<< ; SRBR014566 ^^^^^^^
    //<< */
    //<< 
    //<< do Button(strExec)
    m$.Cmd.Do("Button",strExec.get());
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< EXEC
  public void EXEC() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;       WENN MIT EXECUTERUECKSPRUNG ;when by means of
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   shobby  BR014490: Reverted previous change.
    //<< ; 11-Jun-2007   shobby  BR014409: Don't use YLFN as the loop for buttons.  We
    //<< ;                       need that to preserve the id of the associated field
    //<< ;                       (set somewhere up the stack)
    //<< ;-------------------------------------------------------------------------------
    //<< new blnNewWindow,preExec,strExec,YHTML
    mVar blnNewWindow = m$.var("blnNewWindow");
    mVar preExec = m$.var("preExec");
    mVar strExec = m$.var("strExec");
    mVar YHTML = m$.var("YHTML");
    m$.newVar(blnNewWindow,preExec,strExec,YHTML);
    //<< 
    //<< set blnNewWindow = $$$NO
    blnNewWindow.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if $zconvert($$$WWW124ExecuteOnClick(YA),"U")="SUBMIT" {    ;SUBMIT BEI EXECUTE ;next to EXECUTE
    if (mOp.Equal(m$.Fnc.$zconvert(include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA")),"U"),"SUBMIT")) {
      //<< set strExec = "SAVENOW();"
      strExec.set("SAVENOW();");
    }
    //<< 
    //<< } elseif $$$WWW124FunctionJavaScriptOnClick(YA)'="" {       ;FUNCTION BEI ONCLICK ;next to
    else if (mOp.NotEqual(include.WWWConst.$$$WWW124FunctionJavaScriptOnClick(m$,m$.var("YA")),"")) {
      //<< set strExec = $$$WWW124FunctionJavaScriptOnClick(YA)_";"
      strExec.set(mOp.Concat(include.WWWConst.$$$WWW124FunctionJavaScriptOnClick(m$,m$.var("YA")),";"));
    }
    //<< 
    //<< } else {
    else {
      //<< if (YTARGETF="") || (YTARGETF=YTARGET) {                ; MANUELLE ROUTINE
      if ((mOp.Equal(m$.var("YTARGETF").get(),"")) || (mOp.Equal(m$.var("YTARGETF").get(),m$.var("YTARGET").get()))) {
        //<< set YHTML = "EXEC"                                  ; MIT HTML ;by means of HTML
        YHTML.set("EXEC");
        //<< if $$$WWW124DoNotPrepareHTML(YA) SET YHTML = "MANU" ; OHNE HTML ;without HTML
        if (mOp.Logical(include.WWWConst.$$$WWW124DoNotPrepareHTML(m$,m$.var("YA")))) {
          YHTML.set("MANU");
        }
        //<< 
        //<< set strExec = "document.WWW.YNUMMER.value='"_$GET(YNUMMER)_"'; "_
        //<< "document.WWW.YBUTTON.value='"_YLFN_"'; "_
        //<< "document.WWW.YSEITE.value='"_YSEITE_"'; "_
        //<< "SAVENOW('SAVE"_YHTML_$$$WWW124ExecuteOnClick(YA)_"');"
        strExec.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.WWW.YNUMMER.value='",m$.Fnc.$get(m$.var("YNUMMER"))),"'; "),"document.WWW.YBUTTON.value='"),m$.var("YLFN").get()),"'; "),"document.WWW.YSEITE.value='"),m$.var("YSEITE").get()),"'; "),"SAVENOW('SAVE"),YHTML.get()),include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA"))),"');"));
      }
      //<< 
      //<< } else {  ; FORM IN SEPARATE WINDOW ;FIS;16.04.04;25534
      else {
        //<< set blnNewWindow = $$$YES
        blnNewWindow.set(include.COMSYS.$$$YES(m$));
        //<< if '$$$WWW124DoNotPrepareHTML(YA) {
        if (mOp.Not(include.WWWConst.$$$WWW124DoNotPrepareHTML(m$,m$.var("YA")))) {
          //<< set strExec = "WWWMANU&amp;YFORM="_YFORM_"&amp;YEXEC="_$$$WWW124ExecuteOnClick(YA)
          strExec.set(mOp.Concat(mOp.Concat(mOp.Concat("WWWMANU&amp;YFORM=",m$.var("YFORM").get()),"&amp;YEXEC="),include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA"))));
        }
        //<< } else {
        else {
          //<< set strExec = "WWWMANU1&amp;YEXEC="_$$$WWW124ExecuteOnClick(YA)
          strExec.set(mOp.Concat("WWWMANU1&amp;YEXEC=",include.WWWConst.$$$WWW124ExecuteOnClick(m$,m$.var("YA"))));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if 'blnNewWindow {
    if (mOp.Not(blnNewWindow.get())) {
      //<< set preExec = ""
      preExec.set("");
      //<< if $$$WWW124AutomaticSUBMIT(YA) set preExec = "retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9');"
      if (mOp.Logical(include.WWWConst.$$$WWW124AutomaticSUBMIT(m$,m$.var("YA")))) {
        preExec.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("retval=EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','Y"),m$.var("YFORM").get()),"','','9');"));
      }
      //<< set strExec = preExec_"document.WWW.target='"_$GET(YTARGETF)_"';"_strExec
      strExec.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(preExec.get(),"document.WWW.target='"),m$.Fnc.$get(m$.var("YTARGETF"))),"';"),strExec.get()));
    }
    //<< }
    //<< 
    //<< do Button(strExec,blnNewWindow) // Display button
    m$.Cmd.Do("Button",strExec.get(),blnNewWindow.get());
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< VERKN
  public void VERKN() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;       VERKNÜPFUNG MIT BILDANZEIGE ;by means of
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   shobby  BR014490: Adjusted id of image
    //<< ; 11-Jun-2007   shobby  BR014409: Don't use YLFN as the loop for buttons.  We
    //<< ;                       need that to preserve the id of the associated field
    //<< ;                       (set somewhere up the stack)
    //<< ;-------------------------------------------------------------------------------
    //<< new strLink
    mVar strLink = m$.var("strLink");
    m$.newVar(strLink);
    //<< 
    //<< if 'blnButtons {
    if (mOp.Not(m$.var("blnButtons").get())) {
      //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,m$.var("YA")))),"\""));
    }
    //<< } else {
    else {
      //<< write "<A class=link "
      m$.Cmd.Write("<A class=link ");
    }
    //<< }
    //<< 
    //<< $$$OpenOnClick
    include.WWWFORM.$$$OpenOnClick(m$);
    //<< $$$StartWindow
    include.WWWFORM.$$$StartWindow(m$);
    //<< 
    //<< set strLink = $$$WWW124LinkWithexeOrHttp(YA)
    strLink.set(include.WWWConst.$$$WWW124LinkWithexeOrHttp(m$,m$.var("YA")));
    //<< 
    //<< if '$find(strLink," ^") {   ;NORMALE VERKNÜFUNG
    if (mOp.Not(m$.Fnc.$find(strLink.get()," ^"))) {
      //<< if '$find(strLink,":") write YGIF
      if (mOp.Not(m$.Fnc.$find(strLink.get(),":"))) {
        m$.Cmd.Write(m$.var("YGIF").get());
      }
      //<< write strLink
      m$.Cmd.Write(strLink.get());
    }
    //<< 
    //<< } else {
    else {
      //<< xecute strLink  ;HTTP: ODER MAILTO AUS EXECUTE ;Or out of EXECUTE
      m$.Cmd.Xecute(strLink.get());
    }
    //<< }
    //<< 
    //<< $$$EndWindow
    include.WWWFORM.$$$EndWindow(m$);
    //<< $$$CloseOnClick
    include.WWWFORM.$$$CloseOnClick(m$);
    //<< 
    //<< write ">"
    m$.Cmd.Write(">");
    //<< 
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< do StopButton^WWWFORMCOMMON($$$WWW124ButtonDescription(YA),strPic,"Y"_$get(YFORM)_"D"_$get(idYLFN)_"_"_$get(YLFN)_"IMG")
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",include.WWWConst.$$$WWW124ButtonDescription(m$,m$.var("YA")),m$.var("strPic").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.Fnc.$get(m$.var("YFORM"))),"D"),m$.Fnc.$get(m$.var("idYLFN"))),"_"),m$.Fnc.$get(m$.var("YLFN"))),"IMG"));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< MANU
  public void MANU() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;       MANUELLER LINK DURCH EXECUTE ;trans- EXECUTE
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2007   shobby  BR014409: Adjusted id of image
    //<< ; 11-Jun-2007   shobby  BR014409: Don't use YLFN as the loop for buttons.  We
    //<< ;                       need that to preserve the id of the associated field
    //<< ;                       (set somewhere up the stack)
    //<< ;-------------------------------------------------------------------------------
    //<< new LINK,EXEC,strLink
    mVar LINK = m$.var("LINK");
    mVar EXEC = m$.var("EXEC");
    mVar strLink = m$.var("strLink");
    m$.newVar(LINK,EXEC,strLink);
    //<< 
    //<< set LINK=0
    LINK.set(0);
    //<< set strLink = $$$WWW124ExecuteForManualLink(YA)
    strLink.set(include.WWWConst.$$$WWW124ExecuteForManualLink(m$,m$.var("YA")));
    //<< 
    //<< if $EXTRACT(strLink,1,2)="$$" {
    if (mOp.Equal(m$.Fnc.$extract(strLink.get(),1,2),"$$")) {
      //<< set EXEC = "SET LINK="_strLink
      EXEC.set(mOp.Concat("SET LINK=",strLink.get()));
      //<< XECUTE EXEC
      m$.Cmd.Xecute(EXEC.get());
    }
    //<< 
    //<< } elseif $EXTRACT(strLink,1)="@" {
    else if (mOp.Equal(m$.Fnc.$extract(strLink.get(),1),"@")) {
      //<< set LINK = @$EXTRACT(strLink,2,99)
      LINK.set(m$.indirectVar(m$.Fnc.$extract(strLink.get(),2,99)).get());
    }
    //<< }
    //<< if 'blnButtons {
    if (mOp.Not(m$.var("blnButtons").get())) {
      //<< write "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick="""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,m$.var("YA")))),"\" onClick=\""));
    }
    //<< } else {
    else {
      //<< write "<A onClick='return doLink(this)' HREF="""
      m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"");
    }
    //<< }
    //<< if LINK'=0 {
    if (mOp.NotEqual(LINK.get(),0)) {
      //<< write LINK
      m$.Cmd.Write(LINK.get());
    }
    //<< } else {
    else {
      //<< XECUTE strLink
      m$.Cmd.Xecute(strLink.get());
    }
    //<< }
    //<< write """"
    m$.Cmd.Write("\"");
    //<< if YTARGETF'="" write " TARGET="""_YTARGETF_""""
    if (mOp.NotEqual(m$.var("YTARGETF").get(),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" TARGET=\"",m$.var("YTARGETF").get()),"\""));
    }
    //<< write ">"
    m$.Cmd.Write(">");
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< do StopButton^WWWFORMCOMMON($$$WWW124ButtonDescription(YA),strPic,"Y"_$GET(YFORM)_"D"_$get(idYLFN)_"_"_$GET(YLFN)_"IMG")
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",include.WWWConst.$$$WWW124ButtonDescription(m$,m$.var("YA")),m$.var("strPic").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.Fnc.$get(m$.var("YFORM"))),"D"),m$.Fnc.$get(m$.var("idYLFN"))),"_"),m$.Fnc.$get(m$.var("YLFN"))),"IMG"));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< }
    //<< QUIT
    return;
  }

  //<< 
  //<< Button(pstrExec,pblnNewWindow=$$$NO)
  public Object Button(Object ... _p) {
    mVar pstrExec = m$.newVarRef("pstrExec",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnNewWindow = m$.newVarRef("pblnNewWindow",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Generic button display
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-Dec-2008   FIS     SR16205: bugfix
    //<< ; 28-Jun-2007   shobby  BR014409: YCONF1 may already have something in in so preserve that
    //<< ; 11-Jun-2007   shobby  BR014409: Give the <A> object an id so that we can
    //<< ;                       determine later if the button is read only.  Make the action
    //<< ;                       dependent on whether this object has been set to read only.
    //<< ; 25-Oct-2006   JW      BR014279: Use Macros.
    //<< ; 16-Dec-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strDesc
    mVar strDesc = m$.var("strDesc");
    m$.newVar(strDesc);
    //<< 
    //<< set strDesc = $$^WWWUML($$$WWW124ButtonDescription(YA))
    strDesc.set(m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,m$.var("YA"))));
    //<< 
    //<< if 'blnButtons {
    if (mOp.Not(m$.var("blnButtons").get())) {
      //<< write "<INPUT TYPE=""BUTTON"" "
      m$.Cmd.Write("<INPUT TYPE=\"BUTTON\" ");
      //<< if $$$WWW120StylesheetCSSFile(YVOR)'="" write " class=""button"" "
      if (mOp.NotEqual(include.WWWConst.$$$WWW120StylesheetCSSFile(m$,m$.var("YVOR")),"")) {
        m$.Cmd.Write(" class=\"button\" ");
      }
      //<< ;   write "VALUE="""_YAM_strDesc_""      ; SR16205
      //<< write "VALUE="""_YAM_strDesc_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("VALUE=\"",m$.var("YAM").get()),strDesc.get()),"\""));
    }
    //<< } else {
    else {
      //<< write "<A class=link id=""Y"_$get(YFORM)_$get(YART)_$get(idYLFN)_"_"_$get(YLFN)_""" "
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A class=link id=\"Y",m$.Fnc.$get(m$.var("YFORM"))),m$.Fnc.$get(m$.var("YART"))),m$.Fnc.$get(m$.var("idYLFN"))),"_"),m$.Fnc.$get(m$.var("YLFN"))),"\" "));
    }
    //<< }
    //<< 
    //<< //write " onClick="""_YCONF1        BR014279
    //<< set YCONF1=$get(YCONF1)_"if (this.readOnly!=true) {"  ;BR014409
    mVar YCONF1 = m$.var("YCONF1");
    YCONF1.set(mOp.Concat(m$.Fnc.$get(m$.var("YCONF1")),"if (this.readOnly!=true) {"));
    //<< $$$OpenOnClick
    include.WWWFORM.$$$OpenOnClick(m$);
    //<< 
    //<< if 'pblnNewWindow {
    if (mOp.Not(pblnNewWindow.get())) {
      //<< if $$$WWW124SetVariableYPARA(YA)'="" write "document.WWW.YPARA.value='"_$$$WWW124SetVariableYPARA(YA)_"'; "  ;PARAMETER NEU
      if (mOp.NotEqual(include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA")),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat("document.WWW.YPARA.value='",include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA"))),"'; "));
      }
      //<< write pstrExec
      m$.Cmd.Write(pstrExec.get());
    }
    //<< 
    //<< } else {
    else {
      //<< write " var parameter=window.open('"_YAKTION_"EP="_strExec
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" var parameter=window.open('",m$.var("YAKTION").get()),"EP="),m$.var("strExec").get()));
      //<< if $$$WWW124SetVariableYPARA(YA)'="" write "&amp;YPARA="_$$$WWW124SetVariableYPARA(YA)  ;PARAMETER NEU ;parameter recent
      if (mOp.NotEqual(include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA")),"")) {
        m$.Cmd.Write(mOp.Concat("&amp;YPARA=",include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA"))));
      }
      //<< write "&amp;YLOCKBACK="_YTRAKT  ;AKTUELLE LOCKDATEI BEI SCHLIESSEN ZURÜCKHOLEN;FIS;25534;20.04.04
      m$.Cmd.Write(mOp.Concat("&amp;YLOCKBACK=",m$.var("YTRAKT").get()));
      //<< new YKEY,YFKEY,YBACK
      mVar YKEY = m$.var("YKEY");
      mVar YFKEY = m$.var("YFKEY");
      mVar YBACK = m$.var("YBACK");
      m$.newVar(YKEY,YFKEY,YBACK);
      //<< do ^WWWCGI
      m$.Cmd.Do("WWWCGI.main");
      //<< write "','"_YTARGETF_"','resizable=yes, scrollbars=yes');"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("','",m$.var("YTARGETF").get()),"','resizable=yes, scrollbars=yes');"));
    }
    //<< }
    //<< 
    //<< //write YCONF2              BR014279
    //<< write "}" ;BR014409
    m$.Cmd.Write("}");
    //<< //write """>"
    //<< $$$CloseOnClick
    include.WWWFORM.$$$CloseOnClick(m$);
    //<< write ">"
    m$.Cmd.Write(">");
    //<< if blnButtons {
    if (mOp.Logical(m$.var("blnButtons").get())) {
      //<< do StopButton^WWWFORMCOMMON(strDesc,strPic,"Y"_$get(YFORM)_"D"_$get(idYLFN)_"_"_$get(YLFN)_"IMG")
      m$.Cmd.Do("WWWFORMCOMMON.StopButton",strDesc.get(),m$.var("strPic").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.Fnc.$get(m$.var("YFORM"))),"D"),m$.Fnc.$get(m$.var("idYLFN"))),"_"),m$.Fnc.$get(m$.var("YLFN"))),"IMG"));
      //<< write "</A>"
      m$.Cmd.Write("</A>");
    }
    //<< }
    //<< quit
    return null;
  }

//<< 
}
