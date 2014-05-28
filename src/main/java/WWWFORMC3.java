//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMC3
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:27
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

//<< WWWFORMC3
public class WWWFORMC3 extends mClass {

  public void main() {
    _WWWFORMC3();
  }

  public void _WWWFORMC3() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       BUTTON BEI FORMULAREN
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
    //<< ; 27-Sep-2011   shobby  SR17853: Reverted doCancelEvent
    //<< ; 27-Jul-2009   shobby  SR16798: Change the way that the onsubmenu_click is called.
    //<< ; 27-Sep-2007   GRF     Doco; !=>||
    //<< ; 07-May-2007   GRF     SR15511: Doco; quits
    //<< ; 08-Feb-2006   RPW     SR13655: Make the Edit button say Options
    //<< ; 22-Dec-2005   JW      SR13195: Edited SAVENOW calls.
    //<< ; 12-Oct-2005   GRF     Doco
    //<< ; 30-May-2005   RobertW SR12056: Attempt at Performance Increase
    //<< ; 29.09.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< ;;VERTEILERBUTTON
    //<< ;IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* SPECIAL BUTTON (WWWFORMC3) ************************* -->",YCR,YCR
    //<< 
    //<< NEW YI,YA,YK,YLSTKEY
    mVar YI = m$.var("YI");
    mVar YA = m$.var("YA");
    mVar YK = m$.var("YK");
    mVar YLSTKEY = m$.var("YLSTKEY");
    m$.newVar(YI,YA,YK,YLSTKEY);
    //<< 
    //<< SET YLSTKEY=""
    YLSTKEY.set("");
    do {
      //<< DO  ;AUCH IN WWWSTART AKTIVIEREN ! ;too within
      //<< . NEW LINKS,LNK,YDROPD,LINK1,YDISABLED
      mVar LINKS = m$.var("LINKS");
      mVar LNK = m$.var("LNK");
      mVar YDROPD = m$.var("YDROPD");
      mVar LINK1 = m$.var("LINK1");
      mVar YDISABLED = m$.var("YDISABLED");
      m$.newVarBlock(1,LINKS,LNK,YDROPD,LINK1,YDISABLED);
      //<< . WRITE YCR,"<TD width=30 nowrap valign=top align=center"
      m$.Cmd.Write(m$.var("YCR").get(),"<TD width=30 nowrap valign=top align=center");
      //<< . WRITE " class=""coolButton"""                                   ;MOUSEEFFECT
      m$.Cmd.Write(" class=\"coolButton\"");
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . WRITE YCR,"<input type=""hidden"" name=""YOPEN2"" value="""">"
      m$.Cmd.Write(m$.var("YCR").get(),"<input type=\"hidden\" name=\"YOPEN2\" value=\"\">");
      //<< . ;
      //<< . SET YDROPD=1
      YDROPD.set(1);
      //<< . ;WRITE YCR,"<div id=""cmdPanelMain"" style=""border:1px solid black; padding:0px; WIDTH: 100px;"">"
      //<< . WRITE YCR,"<table style=""padding-top:1px; border:none;"" cellspacing=0 cellpadding=0>"
      m$.Cmd.Write(m$.var("YCR").get(),"<table style=\"padding-top:1px; border:none;\" cellspacing=0 cellpadding=0>");
      //<< . WRITE YCR,"<tr><td>"
      m$.Cmd.Write(m$.var("YCR").get(),"<tr><td>");
      //<< . ;
      //<< . WRITE YCR,"<table style=""table-layout:fixed; border-left:1px solid ButtonHighLight; border-top:1px solid ButtonHighLight; border-right:2px solid ButtonShadow; border-bottom:2px solid ButtonShadow;"" cellspacing=0 cellpadding=0>"
      m$.Cmd.Write(m$.var("YCR").get(),"<table style=\"table-layout:fixed; border-left:1px solid ButtonHighLight; border-top:1px solid ButtonHighLight; border-right:2px solid ButtonShadow; border-bottom:2px solid ButtonShadow;\" cellspacing=0 cellpadding=0>");
      //<< . WRITE YCR,"<tr><td height=17 width=71>"
      m$.Cmd.Write(m$.var("YCR").get(),"<tr><td height=17 width=71>");
      //<< . ;
      //<< . WRITE YCR,"<myMenu:menu id=""MyPage"" access=""enabled"""
      m$.Cmd.Write(m$.var("YCR").get(),"<myMenu:menu id=\"MyPage\" access=\"enabled\"");
      //<< . write " onsubmenu_click=""document.WWW.YOPEN2.value=event.result; window.location=event.result; window.event.returnValue = false; window.event.cancelBubble = true;"""        ;SR16798 //SR17253 ;SR17853
      m$.Cmd.Write(" onsubmenu_click=\"document.WWW.YOPEN2.value=event.result; window.location=event.result; window.event.returnValue = false; window.event.cancelBubble = true;\"");
      //<< . WRITE " style=""cursor:pointer; text-align:middle; width:71px; height:17px;"">"   ;SR17253
      m$.Cmd.Write(" style=\"cursor:pointer; text-align:middle; width:71px; height:17px;\">");
      //<< . ;WRITE $$^WWWTEXT(394)  ;Edit
      //<< . WRITE $$^WWWTEXT("WWW00037")  ;Options // SR13655
      m$.Cmd.Write(m$.fnc$("WWWTEXT.main","WWW00037"));
      //<< . ;
      //<< . SET YSORT=""
      mVar YSORT = m$.var("YSORT");
      YSORT.set("");
      //<< . DO BUTTON  ;EINBAU AUSWAHLMENÜ ;in-built
      m$.Cmd.Do("BUTTON");
      //<< . ;
      //<< . WRITE YCR,"</myMenu:menu>"
      m$.Cmd.Write(m$.var("YCR").get(),"</myMenu:menu>");
      //<< . ;
      //<< . WRITE YCR,"</tr></td>"
      m$.Cmd.Write(m$.var("YCR").get(),"</tr></td>");
      //<< . WRITE YCR,"</table>"
      m$.Cmd.Write(m$.var("YCR").get(),"</table>");
      //<< . ;
      //<< . WRITE YCR,"</tr></td>"
      m$.Cmd.Write(m$.var("YCR").get(),"</tr></td>");
      //<< . WRITE YCR,"</table>"
      m$.Cmd.Write(m$.var("YCR").get(),"</table>");
    } while(false);
    m$.restoreVarBlock(1);
    //<< . ;WRITE YCR,"</div>"
    //<< 
    //<< 
    //<< WRITE YCR,"</TD>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
    //<< 
    //<< ; FIXME : WWW013 D94 (Compiler/Translator) is a language code e.g. "EN" or "PT" - not "1".  Wrong setting?
    //<< IF $$^WWWACCESS(1)=$$$YES IF $GET(YSCREENM)="" IF $PIECE($GET(^WWW013(0,YBED,1)),Y,94)=1 SET YSCREENM=2  ;WENN ADMIN UND UEBERSETZTER DANN IMMER AKTIV  ;when And constantly ENABLED
    if (mOp.Equal(m$.fnc$("WWWACCESS.main",1),include.COMSYS.$$$YES(m$))) {
      if (mOp.Equal(m$.Fnc.$get(m$.var("YSCREENM")),"")) {
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)),m$.var("Y").get(),94),1)) {
          mVar YSCREENM = m$.var("YSCREENM");
          YSCREENM.set(2);
        }
      }
    }
    //<< IF (+$GET(YSCREENM)'=0) && ((YFOART=1) || (YFOART=4) || (YFOART=3)) DO
    if ((mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("YSCREENM"))),0)) && mOp.Logical(((mOp.Equal(m$.var("YFOART").get(),1)) || (mOp.Equal(m$.var("YFOART").get(),4)) || (mOp.Equal(m$.var("YFOART").get(),3))))) {
      //<< . NEW YPRINT
      mVar YPRINT = m$.var("YPRINT");
      m$.newVarBlock(1,YPRINT);
      //<< . DO ^WWWSCRB  ;SCREEN DFLT BUTTON
      m$.Cmd.Do("WWWSCRB.main");
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< BUTTON
  public void BUTTON() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;ERSTELLEN DYNAM. BUTTON
    //<< ;
    //<< ; History
    //<< ; 21-Nov-2007   GRF     SR15614: Macros; idxForm
    //<< ; 02-May-2006   Steve S SR14592: Transaction buttons can no longer be doubleclicked
    //<< ; 08-Feb-2006   RPW     SR14276: Do not show buttons that should not be shown
    //<< ;-------------------------------------------------------------------------------
    //<< NEW idxForm,YI,YA,I,YLFN,SPRACHE,YEXEC,YKEYXX,YBPOS,YPRINT,Q,YQ
    mVar idxForm = m$.var("idxForm");
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
    m$.newVar(idxForm,YI,YA,I,YLFN,SPRACHE,YEXEC,YKEYXX,YBPOS,YPRINT,Q,YQ);
    //<< 
    //<< IF (YFOART=5) && '$DATA(^WWW122(0,YFORM)) SET YWIDTH = "",YHEIGHT = ""
    if ((mOp.Equal(m$.var("YFOART").get(),5)) && mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
      mVar YWIDTH = m$.var("YWIDTH");
      YWIDTH.set("");
      mVar YHEIGHT = m$.var("YHEIGHT");
      YHEIGHT.set("");
    }
    //<< SET YI = 0
    YI.set(0);
    //<< SET SPRACHE  = $$^WWWLANGU(YBED)
    SPRACHE.set(m$.fnc$("WWWLANGU.main",m$.var("YBED").get()));
    //<< SET LANGUAGE = SPRACHE
    mVar LANGUAGE = m$.var("LANGUAGE");
    LANGUAGE.set(SPRACHE.get());
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   YA          objWWW124       Button
    //<< ;   YVOR        objWWW120       Form
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< ;SUCHEN BUTTONS ;search all buttons
    //<< ; Index 2 : P1 (idForm), P2 (Language), D4 (Column)
    //<< ;---------------------------------------
    //<< set idxForm = $$$Index(YFORM)   ; SR15614
    idxForm.set(include.MEDConst.$$$Index(m$,m$.var("YFORM")));
    //<< set YBPOS   = ""
    YBPOS.set("");
    //<< FOR  SET YBPOS = $ORDER(^WWW124s(0,2,idxForm,SPRACHE,YBPOS)) QUIT:YBPOS=""  SET YLFN="" FOR  SET YLFN=$ORDER(^WWW124s(0,2,idxForm,SPRACHE,YBPOS,YFORM,SPRACHE,YLFN)) QUIT:YLFN=""  DO
    for (;true;) {
      YBPOS.set(m$.Fnc.$order(m$.var("^WWW124s",0,2,idxForm.get(),SPRACHE.get(),YBPOS.get())));
      if (mOp.Equal(YBPOS.get(),"")) {
        break;
      }
      YLFN.set("");
      for (;true;) {
        YLFN.set(m$.Fnc.$order(m$.var("^WWW124s",0,2,idxForm.get(),SPRACHE.get(),YBPOS.get(),m$.var("YFORM").get(),SPRACHE.get(),YLFN.get())));
        if (mOp.Equal(YLFN.get(),"")) {
          break;
        }
        do {
          //<< . SET YA = $GET(^WWW124(0,YFORM,SPRACHE,YLFN,1))
          YA.set(m$.Fnc.$get(m$.var("^WWW124",0,m$.var("YFORM").get(),SPRACHE.get(),YLFN.get(),1)));
          //<< . QUIT:$$DontShow^WWWFORMC() //SR14276
          if (mOp.Logical(m$.fnc$("WWWFORMC.DontShow"))) {
            break;
          }
          //<< . ;
          //<< . NEW YVALUE,YTEXT,strPrefix
          mVar YVALUE = m$.var("YVALUE");
          mVar YTEXT = m$.var("YTEXT");
          mVar strPrefix = m$.var("strPrefix");
          m$.newVarBlock(1,YVALUE,YTEXT,strPrefix);
          //<< . set strPrefix=""
          strPrefix.set("");
          //<< . if $$$WWW124BlankDuringProcessing(YA) set strPrefix=" NewPage(document.WWW); " ; D69      //SR14592
          if (mOp.Logical(include.WWWConst.$$$WWW124BlankDuringProcessing(m$,YA))) {
            strPrefix.set(" NewPage(document.WWW); ");
          }
          //<< . SET YVALUE=""
          YVALUE.set("");
          //<< . SET YTEXT=""
          YTEXT.set("");
          //<< . DO VALUE
          m$.Cmd.Do("VALUE");
          //<< . IF YVALUE'="" SET YTEXT=$$^WWWUML($PIECE(YA,Y,1))
          if (mOp.NotEqual(YVALUE.get(),"")) {
            YTEXT.set(m$.fnc$("WWWUML.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),1)));
          }
          //<< . QUIT:YTEXT=""
          if (mOp.Equal(YTEXT.get(),"")) {
            break;
          }
          //<< . IF $EXTRACT(YVALUE)="/" SET YVALUE=strPrefix_"window.location='"_YVALUE_"'" //SR14592
          if (mOp.Equal(m$.Fnc.$extract(YVALUE.get()),"/")) {
            YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(strPrefix.get(),"window.location='"),YVALUE.get()),"'"));
          }
          //<< . IF $EXTRACT($REVERSE(YVALUE))'=";" SET YVALUE=YVALUE_";"
          if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$reverse(YVALUE.get())),";")) {
            YVALUE.set(mOp.Concat(YVALUE.get(),";"));
          }
          //<< . ;
          //<< . IF $GET(YDROPD)=1 DO  QUIT
          if (mOp.Equal(m$.Fnc.$get(m$.var("YDROPD")),1)) {
            //<< . . ;SET LINKS($TR(YTEXT," ,;()@#$%^&*_=+<>?/|{}\'"""))=YTEXT_Y_YVALUE QUIT
            //<< . . SET YDISABLED="enabled"
            mVar YDISABLED = m$.var("YDISABLED");
            YDISABLED.set("enabled");
            //<< . . IF $FIND(YVALUE,$$^WWWTEXT(32072)) SET YDISABLED="disabled"            ; "Please Select A Data Record First."
            if (mOp.Logical(m$.Fnc.$find(YVALUE.get(),m$.fnc$("WWWTEXT.main",32072)))) {
              YDISABLED.set("disabled");
            }
            //<< . . ;IF $get(Q)=1||(+$get(YQ)=1) set YDISABLED="disabled"                  ; RPW/PO
            //<< . . WRITE YCR,"   <myMenu:menu access="""_YDISABLED_""" id="""_YVALUE_""">"_YTEXT_"</myMenu:menu>"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("   <myMenu:menu access=\"",YDISABLED.get()),"\" id=\""),YVALUE.get()),"\">"),YTEXT.get()),"</myMenu:menu>"));
            break;
          }
          //<< . ;
          //<< . WRITE YCR,"<option value="""_YVALUE_""""
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<option value=\"",YVALUE.get()),"\""));
          //<< . WRITE ">"_$$^WWWNBSP(YTEXT)_"</option>"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.fnc$("WWWNBSP.main",YTEXT.get())),"</option>"));
        } while (false);
      }
      m$.restoreVarBlock(1);
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< VALUE ;
  public void VALUE() {
    do {
      //<< /*-------------------------------------------------------------------------------
      //<< ;
      //<< ;
      //<< ; History:
      //<< ; 21-Nov-2007   GRF     SR15614: Macros; use idxForm
      //<< ; 12-Sep-2006   JW      Convert alert text to JS
      //<< ; 08-Feb-2006   RPW     SR13655: Make Hyper Event On Click buttons work in my-menu
      //<< ; 10-Jan-2006   JW      SR14117: Don't show menu option if Q=2
      //<< ; 04-Apr-2005   PO/RPW  SR12014 Fixed usage of find
      //<< ;-------------------------------------------------------------------------------*/
      //<< 
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< ;   YA          objWWW124
      //<< ;   D1      $$$WWW124ButtonDescription()
      //<< ;   D6      $$$WWW124ExecuteOnClick()
      //<< ;   D7      $$$WWW124NewFormOnClick()
      //<< ;   D8      $$$WWW124LinkWithexeOrHttp()
      //<< ;   D9      $$$WWW124PictureFileOnButton()
      //<< ;   D10     $$$WWW124ButtonBelongsToADataItem()
      //<< ;   D11     $$$WWW124TransferVariableIdentifie()
      //<< ;   D12     $$$WWW124DownloadFileOnClick()
      //<< ;   D14     $$$WWW124FunctionJavaScriptOnClick()
      //<< ;   D17     $$$WWW124AcknowledgementTextBefore()
      //<< ;   D18     $$$WWW124OutputWithWindowprint()
      //<< ;   D19     $$$WWW124TargetFrameName()
      //<< ;   D21     $$$WWW124ImageFileForDisabledButto()
      //<< ;   D22     $$$WWW124Authorization1()
      //<< ;   D23     $$$WWW124Module1()
      //<< ;   D24     $$$WWW124AutomaticSUBMIT()
      //<< ;   D25     $$$WWW124ExecuteForManualLink()
      //<< ;   D50     $$$WWW124ShowOnlyWhenYOPTION()
      //<< ;   D51     $$$WWW124DisplayOnlyWhenMenuParam()
      //<< ;   D53     $$$WWW124SearchFunctionOnClick()
      //<< ;   D56     $$$WWW124ChangeoversWithOnClick()
      //<< ;   D57     $$$WWW124QueryOnClick()
      //<< ;   D62     $$$WWW124ExecuteToCheckForDisabled()
      //<< ;   D63     $$$WWW124ButtonOnlyForCompany()
      //<< ;   D64     $$$WWW124ButtonNotforCompany()
      //<< ;   D65     $$$WWW124HyperEventOnClick()
      //<< ;
      //<< ;   YVOR        objWWW120
      //<< ;   D45     PicturesAsButtons
      //<< ;+++++++++++++++++++++++++++++++++++++++
      //<< 
      //<< DO   ;SET VALUE UND TEXT ;table-mat VALUE And Text
      //<< . SET Q=""
      mVar Q = m$.var("Q");
      Q.set("");
      //<< . SET YQ=""
      mVar YQ = m$.var("YQ");
      YQ.set("");
      //<< . ;
      //<< . IF YOPTION'="" IF $PIECE(YA,Y,50)'="" QUIT:'$FIND(","_$PIECE(YA,Y,50)_",",","_YOPTION_",")  ;NICHT ANZEIGE WEIL OPTION FALSCH ;Not Show since right of first refusal wrong
      if (mOp.NotEqual(m$.var("YOPTION").get(),"")) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),50),"")) {
          if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),50)),","),mOp.Concat(mOp.Concat(",",m$.var("YOPTION").get()),",")))) {
            break;
          }
        }
      }
      //<< . SET YPRINT=""  IF $PIECE(YA,Y,18)=1 SET YPRINT=1  ;ZIEL DRUCKEN ;target print
      mVar YPRINT = m$.var("YPRINT");
      YPRINT.set("");
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),18),1)) {
        YPRINT.set(1);
      }
      //<< . ;
      //<< . IF $PIECE(YA,Y,63)'="" IF '$FIND(","_$PIECE(YA,Y,63)_",",","_YMANDANT_",") QUIT  ;NUR FÜR FIRMA ;only to company
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),63),"")) {
        if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),63)),","),mOp.Concat(mOp.Concat(",",m$.var("YMANDANT").get()),",")))) {
          break;
        }
      }
      //<< . IF $PIECE(YA,Y,64)'="" IF $FIND(","_$PIECE(YA,Y,64)_",",","_YMANDANT_",")  QUIT  ;NICHT FÜR FIRMA ;Not to company
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),64),"")) {
        if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),64)),","),mOp.Concat(mOp.Concat(",",m$.var("YMANDANT").get()),",")))) {
          break;
        }
      }
      //<< . ;
      //<< . QUIT:$$^WWWACCESS($PIECE(YA,Y,22),$PIECE(YA,Y,23))'=1  ;KEIN ZUGANG ;no
      if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),22),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),23)),1)) {
        break;
      }
      //<< . IF $PIECE(YA,Y,6)="" IF $PIECE(YA,Y,7)="" IF $PIECE(YA,Y,8)="" IF $PIECE(YA,Y,12)="" IF $PIECE(YA,Y,14)="" IF $PIECE(YA,Y,53)="" IF $PIECE(YA,Y,56)="" IF $PIECE(YA,Y,57)="" IF $$$WWW124HyperEventOnClick(YA)="" QUIT    // 13655
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"")) {
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7),"")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),8),"")) {
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),12),"")) {
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),14),"")) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),53),"")) {
                  if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),56),"")) {
                    if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),57),"")) {
                      if (mOp.Equal(include.WWWConst.$$$WWW124HyperEventOnClick(m$,m$.var("YA")),"")) {
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      //<< . IF $PIECE(YA,Y,57)'="" SET $PIECE(YA,Y,6)="QUERY,"_$PIECE(YA,Y,57)  ;QUERY AUFRUFEN
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),57),"")) {
        m$.pieceVar(m$.var("YA"),m$.var("Y").get(),6).set(mOp.Concat("QUERY,",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),57)));
      }
      //<< . IF $PIECE(YA,Y,11)'="" DO   ;ZUSATZVARIABLE
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),11),"")) {
        do {
          //<< . . NEW YQ
          m$.newVarBlock(2,YQ);
          //<< . . SET YQ=$PIECE(YA,Y,11)
          YQ.set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),11));
          //<< . . IF '$DATA(@YQ) QUIT
          if (mOp.Not(m$.Fnc.$data(m$.indirectVar(YQ.get())))) {
            break;
          }
          //<< . . SET @YQ=$GET(%(YQUERY,YQ))
          m$.indirectVar(YQ.get()).set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),YQ.get())));
        } while (false);
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . SET YI=YI+1
      mVar YI = m$.var("YI");
      YI.set(mOp.Add(m$.var("YI").get(),1));
      //<< . ;
      //<< . ;KEIN BUTTON? ;KEIN BUTTON ABER BUTTON
      //<< . IF $PIECE(YVOR,Y,45)=$$$YES IF $PIECE(YA,Y,9)="" SET $PIECE(YA,Y,9)=$zconvert($EXTRACT($$^WWWUMLAU($PIECE(YA,Y,1),3)),"L")_".gif"
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45),include.COMSYS.$$$YES(m$))) {
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),9),"")) {
          m$.pieceVar(m$.var("YA"),m$.var("Y").get(),9).set(mOp.Concat(m$.Fnc.$zconvert(m$.Fnc.$extract(m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),1),3)),"L"),".gif"));
        }
      }
      //<< . QUIT:$PIECE(YA,Y,10)=$$$YES  ;NICHT OBEN ;Not if Button Belongs To A Data Item
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),10),include.COMSYS.$$$YES(m$))) {
        break;
      }
      //<< . IF $PIECE(YA,Y,51)'="" QUIT:'$FIND(","_YPARA_",",","_$PIECE(YA,Y,51)_",")  ;NICHT ANZEIGE WEIL PARAMETER FALSCH ;Not Show since parameter wrong
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),51),"")) {
        if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.var("YPARA").get()),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),51)),",")))) {
          break;
        }
      }
      //<< . ;
      //<< . ; FIXME : reset?  <GRF>
      //<< . SET YTARGETF=$PIECE(YA,Y,19)
      mVar YTARGETF = m$.var("YTARGETF");
      YTARGETF.set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),19));
      //<< . SET YTARGETF=""
      YTARGETF.set("");
      //<< . ;
      //<< . SET YTEXT=$$^WWWUML($PIECE(YA,Y,1))
      mVar YTEXT = m$.var("YTEXT");
      YTEXT.set(m$.fnc$("WWWUML.main",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),1)));
      //<< . ;
      //<< . ;     D62         $$$WWW124ExecuteToCheckForDisabled()
      //<< . IF $PIECE(YA,Y,62)'="" DO   ;PRUEFEN DISABLED             ; *** EXECUTE ***
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),62),"")) {
        do {
          //<< . . NEW EXEC,TEXT
          mVar EXEC = m$.var("EXEC");
          mVar TEXT = m$.var("TEXT");
          m$.newVarBlock(2,EXEC,TEXT);
          //<< . . SET EXEC=$PIECE(YA,Y,62)
          EXEC.set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),62));
          //<< . . XECUTE EXEC
          m$.Cmd.Xecute(EXEC.get());
          //<< . . ;
          //<< . . if ($get(Q)=2) || ($get(YQ)=2) do  quit     //SR14117
          if ((mOp.Equal(m$.Fnc.$get(Q),2)) || (mOp.Equal(m$.Fnc.$get(YQ),2))) {
            //<< . . . set Q = 1
            Q.set(1);
            //<< . . . set YTEXT=""
            YTEXT.set("");
            break;
          }
          //<< . . ;
          //<< . . IF (+$GET(Q)=1) || (+$GET(YQ)=1) DO  QUIT
          if ((mOp.Equal(mOp.Positive(m$.Fnc.$get(Q)),1)) || (mOp.Equal(mOp.Positive(m$.Fnc.$get(YQ)),1))) {
            //<< . . . SET TEXT=""   ;S TEXT=$$^WWWTEXT(32072)
            TEXT.set("");
            //<< . . . IF $EXTRACT($GET(Q),2,999)'=""  SET TEXT=$EXTRACT(Q,2,999)
            if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$get(Q),2,999),"")) {
              TEXT.set(m$.Fnc.$extract(Q.get(),2,999));
            }
            //<< . . . IF $EXTRACT($GET(YQ),2,999)'="" SET TEXT=$EXTRACT(YQ,2,999)
            if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$get(YQ),2,999),"")) {
              TEXT.set(m$.Fnc.$extract(YQ.get(),2,999));
            }
            //<< . . . IF TEXT'="" DO
            if (mOp.NotEqual(TEXT.get(),"")) {
              //<< . . . . SET YVALUE="alert('"_$$$JSText(TEXT)_"');"  // SR14979
              mVar YVALUE = m$.var("YVALUE");
              YVALUE.set(mOp.Concat(mOp.Concat("alert('",include.COMSYSString.$$$JSText(m$,TEXT)),"');"));
            }
            break;
          }
        } while (false);
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . IF $EXTRACT($GET(Q))=1  QUIT      ;DISABLED
      if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(Q)),1)) {
        break;
      }
      //<< . IF $EXTRACT($GET(YQ))=1 QUIT
      if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(YQ)),1)) {
        break;
      }
      //<< . ;
      //<< . ;
      //<< . ;DISABLED BUTTON BEI FORMULAREN, WENN KEIN KEY
      //<< . IF +$PIECE(YVOR,Y,45)=$$$YES IF $PIECE(YA,Y,7)'="" IF $TRANSLATE(YKEY,",+""")="" IF +$PIECE($GET(^WWW121(0,$PIECE(YA,Y,7),1,1)),Y,16)'=0 DO  QUIT
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7),"")) {
          if (mOp.Equal(m$.Fnc.$translate(m$.var("YKEY").get(),",+\""),"")) {
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7),1,1)),m$.var("Y").get(),16)),0)) {
              //<< . . SET YVALUE="alert('"_$$^WWWTEXT(32072)_"');"       ; "Please Select A Data Record First."
              mVar YVALUE = m$.var("YVALUE");
              YVALUE.set(mOp.Concat(mOp.Concat("alert('",m$.fnc$("WWWTEXT.main",32072)),"');"));
              break;
            }
          }
        }
      }
      //<< . ;
      //<< . IF +$PIECE(YVOR,Y,45)=$$$YES IF $PIECE(YA,Y,20)=$$$YES IF $TRANSLATE(YKEY,",+""")="" DO  QUIT   ;DISABLE WENN KEIN KEY (20) ;when no KEY
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),20),include.COMSYS.$$$YES(m$))) {
          if (mOp.Equal(m$.Fnc.$translate(m$.var("YKEY").get(),",+\""),"")) {
            //<< . . IF $PIECE(YA,Y,21)'="" SET $PIECE(YA,Y,9)=$PIECE(YA,Y,21)  ;NEUER DISABLED BUTTON
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),21),"")) {
              m$.pieceVar(m$.var("YA"),m$.var("Y").get(),9).set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),21));
            }
            //<< . . SET YVALUE="alert('"_$$^WWWTEXT(32072)_"');"       ; "Please Select A Data Record First."
            mVar YVALUE = m$.var("YVALUE");
            YVALUE.set(mOp.Concat(mOp.Concat("alert('",m$.fnc$("WWWTEXT.main",32072)),"');"));
            break;
          }
        }
      }
      //<< . ;
      //<< . IF $PIECE(YA,Y,24)=$$$YES IF $PIECE(YA,Y,7)'="" IF $PIECE(YA,Y,6)="" SET $PIECE(YA,Y,6)="SUBMIT"   ;AUTOSUBMIT
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),24),include.COMSYS.$$$YES(m$))) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7),"")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"")) {
            m$.pieceVar(m$.var("YA"),m$.var("Y").get(),6).set("SUBMIT");
          }
        }
      }
      //<< . ;
      //<< . IF YBEARB=2 IF $GET(YSAVEDDATA)'=1 IF +$PIECE(YVOR,Y,45)=$$$YES IF $PIECE(YA,Y,20)=$$$YES DO  QUIT   ;NOCH NICHT GESPEICHERT (20) ;yet Not
      if (mOp.Equal(m$.var("YBEARB").get(),2)) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YSAVEDDATA")),1)) {
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),20),include.COMSYS.$$$YES(m$))) {
              //<< . . IF $PIECE(YA,Y,21)'="" SET $PIECE(YA,Y,9)=$PIECE(YA,Y,21)  ;NEUER DISABLED BUTTON
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),21),"")) {
                m$.pieceVar(m$.var("YA"),m$.var("Y").get(),9).set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),21));
              }
              //<< . . SET YVALUE="alert('"_$$^WWWTEXT(32770)_"');"  ;BITTE ERST SPEICHERN
              mVar YVALUE = m$.var("YVALUE");
              YVALUE.set(mOp.Concat(mOp.Concat("alert('",m$.fnc$("WWWTEXT.main",32770)),"');"));
              break;
            }
          }
        }
      }
      //<< . ;
      //<< . ;
      //<< . ;NUR WENN BESTÄTIGUNG ;only when affirmation
      //<< . SET YCONF0=""  ;vor URL ;pre- URL
      mVar YCONF0 = m$.var("YCONF0");
      YCONF0.set("");
      //<< . SET YCONF1=""  ;VOR URL ;pre- URL
      mVar YCONF1 = m$.var("YCONF1");
      YCONF1.set("");
      //<< . SET YCONF2=""  ;NACH URL ;within URL
      mVar YCONF2 = m$.var("YCONF2");
      YCONF2.set("");
      //<< . SET YCONF3=""  ;NACH URL ;within URL
      mVar YCONF3 = m$.var("YCONF3");
      YCONF3.set("");
      //<< . IF $PIECE(YA,Y,17)'="" DO
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),17),"")) {
        //<< . . SET YCONF1="if (confirm('"_$PIECE(YA,Y,17)_"')) {"
        YCONF1.set(mOp.Concat(mOp.Concat("if (confirm('",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),17)),"')) {"));
        //<< . . SET YCONF2="}"  ;ENDE  ;termination
        YCONF2.set("}");
        //<< . . ;
        //<< . . SET YCONF0="JavaScript:if (confirm('"_$PIECE(YA,Y,17)_"')) { "_strPrefix_"window.location='" //SR14592
        YCONF0.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("JavaScript:if (confirm('",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),17)),"')) { "),m$.var("strPrefix").get()),"window.location='"));
        //<< . . SET YCONF3="';}"  ;ENDE
        YCONF3.set("';}");
      }
      //<< . ;
      //<< . if $$$WWW124HyperEventOnClick(YA)'="" do  quit  // SR13655
      if (mOp.NotEqual(include.WWWConst.$$$WWW124HyperEventOnClick(m$,m$.var("YA")),"")) {
        //<< . . set strHyper = $$$WWW124HyperEventOnClick(YA)
        mVar strHyper = m$.var("strHyper");
        strHyper.set(include.WWWConst.$$$WWW124HyperEventOnClick(m$,m$.var("YA")));
        //<< . . set YVALUE = "  retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','"_$PIECE(strHyper,"(",1)_"','"_$$$WWW124SetVariableYPARA(YA)_"','6','"_$PIECE($PIECE(strHyper,"(",2),")",1)_"');"
        mVar YVALUE = m$.var("YVALUE");
        YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  retval=EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','"),m$.Fnc.$piece(strHyper.get(),"(",1)),"','"),include.WWWConst.$$$WWW124SetVariableYPARA(m$,m$.var("YA"))),"','6','"),m$.Fnc.$piece(m$.Fnc.$piece(strHyper.get(),"(",2),")",1)),"');"));
        break;
      }
      //<< . ;
      //<< . ;HREF DURCH MANUELLEN EXECUTE;FIS;01.09.2003        ; *** EXECUTE ***
      //<< . ;     D25     $$$WWW124ExecuteForManualLink()
      //<< . IF $PIECE(YA,Y,25)'="" DO  QUIT
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),25),"")) {
        //<< . . NEW LINK,EXEC
        mVar LINK = m$.var("LINK");
        mVar EXEC = m$.var("EXEC");
        m$.newVarBlock(2,LINK,EXEC);
        //<< . . SET LINK=0
        LINK.set(0);
        //<< . . IF $EXTRACT($PIECE(YA,Y,25),1,2)="$$" SET EXEC="SET LINK="_$PIECE(YA,Y,25) XECUTE EXEC
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),25),1,2),"$$")) {
          EXEC.set(mOp.Concat("SET LINK=",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),25)));
          m$.Cmd.Xecute(EXEC.get());
        }
        //<< . . IF $EXTRACT($PIECE(YA,Y,25),1)="@"    SET LINK=@$EXTRACT($PIECE(YA,Y,25),2,99)
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),25),1),"@")) {
          LINK.set(m$.indirectVar(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),25),2,99)).get());
        }
        //<< . . SET YVALUE=YVALUE_"window.open("""
        mVar YVALUE = m$.var("YVALUE");
        YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),"window.open(\""));
        //<< . . IF LINK'=0 SET YVALUE=YVALUE_LINK
        if (mOp.NotEqual(LINK.get(),0)) {
          YVALUE.set(mOp.Concat(YVALUE.get(),LINK.get()));
        }
        //<< . . IF LINK=0 XECUTE $PIECE(YA,Y,25)
        if (mOp.Equal(LINK.get(),0)) {
          m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),25));
        }
        //<< . . SET YVALUE=YVALUE_""","""
        YVALUE.set(mOp.Concat(YVALUE.get(),"\",\""));
        //<< . . IF YTARGETF'="" SET YVALUE=YVALUE_YTARGETF
        if (mOp.NotEqual(YTARGETF.get(),"")) {
          YVALUE.set(mOp.Concat(YVALUE.get(),YTARGETF.get()));
        }
        //<< . . SET YVALUE=YVALUE_""");"
        YVALUE.set(mOp.Concat(YVALUE.get(),"\");"));
        break;
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . ;
      //<< . ;-------------------------------------
      //<< . ;     D53             SUCHFUNKTION
      //<< . ;-------------------------------------
      //<< . IF $$$WWW124SearchFunctionOnClick(YA)'="" DO  QUIT
      if (mOp.NotEqual(include.WWWConst.$$$WWW124SearchFunctionOnClick(m$,m$.var("YA")),"")) {
        //<< . . IF $PIECE(YA,Y,13)'="" SET YVALUE=YVALUE_"document.WWW.YPARA.value='"_$PIECE(YA,Y,13)_"'; "  ;PARAMETER NEU
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13),"")) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),"document.WWW.YPARA.value='"),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13)),"'; "));
        }
        //<< . . ;SET YVALUE=YVALUE_"document.WWW.YOPEN.value='SAVESEAR'; SAVENOW();"
        //<< . . SET YVALUE=YVALUE_" ShowSearch();"      //SR13195
        mVar YVALUE = m$.var("YVALUE");
        YVALUE.set(mOp.Concat(m$.var("YVALUE").get()," ShowSearch();"));
        break;
      }
      //<< . ;
      //<< . ;
      //<< . ;SUBMIT BEI EXECUTE
      //<< . ;-------------------------------------
      //<< . ;     D6      $$$WWW124ExecuteOnClick()                   ; *** EXECUTE ***
      //<< . ;     D7      $$$WWW124NewFormOnClick()
      //<< . ;-------------------------------------
      //<< . IF $PIECE(YA,Y,7)="" IF $TRANSLATE($PIECE(YA,Y,6),"submit","SUBMIT")="SUBMIT" DO  QUIT
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7),"")) {
        if (mOp.Equal(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"submit","SUBMIT"),"SUBMIT")) {
          //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES SET YVALUE=YVALUE_YCONF1
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
            mVar YVALUE = m$.var("YVALUE");
            YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),YCONF1.get()));
          }
          //<< . . SET YVALUE=YVALUE_"document.WWW.YSORT.value='0'; "
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),"document.WWW.YSORT.value='0'; "));
          //<< . . IF $PIECE(YA,Y,13)'=""  SET YVALUE=YVALUE_"document.WWW.YPARA.value='"_$PIECE(YA,Y,13)_"'; "  ;PARAMETER NEU
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13),"")) {
            YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(YVALUE.get(),"document.WWW.YPARA.value='"),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13)),"'; "));
          }
          //<< . . SET YVALUE=YVALUE_"document.WWW.YOPEN.value=0; SAVENOW();"
          YVALUE.set(mOp.Concat(YVALUE.get(),"document.WWW.YOPEN.value=0; SAVENOW();"));
          //<< . . SET YVALUE=YVALUE_YCONF2
          YVALUE.set(mOp.Concat(YVALUE.get(),YCONF2.get()));
          break;
        }
      }
      //<< . ;
      //<< . ;HELP BEI EXECUTE          ; D6       $$$WWW124ExecuteOnClick() ; *** EXECUTE ***
      //<< . IF $TRANSLATE($PIECE(YA,Y,6),"help","HELP")="HELP" DO  QUIT
      if (mOp.Equal(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"help","HELP"),"HELP")) {
        //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES SET YVALUE=YVALUE_YCONF1
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),YCONF1.get()));
        }
        //<< . . SET YVALUE=YVALUE_"document.WWW.YSORT.value='0'; "
        mVar YVALUE = m$.var("YVALUE");
        YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),"document.WWW.YSORT.value='0'; "));
        //<< . . IF $PIECE(YA,Y,13)'=""  SET YVALUE=YVALUE_"document.WWW.YPARA.value='"_$PIECE(YA,Y,13)_"'; "  ;PARAMETER NEU
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13),"")) {
          YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(YVALUE.get(),"document.WWW.YPARA.value='"),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13)),"'; "));
        }
        //<< . . ;SET YVALUE=YVALUE_"document.WWW.YOPEN.value='SAVEHELP'; SAVENOW();"
        //<< . . SET YVALUE=YVALUE_" SAVENOW('SAVEHELP');"       //SR13195
        YVALUE.set(mOp.Concat(YVALUE.get()," SAVENOW('SAVEHELP');"));
        //<< . . SET YVALUE=YVALUE_YCONF2
        YVALUE.set(mOp.Concat(YVALUE.get(),YCONF2.get()));
        break;
      }
      //<< . ;
      //<< . ;SEITENWECHSEL
      //<< . ;-------------------------------------
      //<< . ;     D56     $$$WWW124ChangeoversWithOnClick()
      //<< . ;-------------------------------------
      //<< . IF $$$WWW124ChangeoversWithOnClick(YA)'="" DO  QUIT
      if (mOp.NotEqual(include.WWWConst.$$$WWW124ChangeoversWithOnClick(m$,m$.var("YA")),"")) {
        //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES SET YVALUE=YVALUE_""
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),""));
        }
        //<< . . IF $PIECE(YA,Y,13)'=""  SET YVALUE=YVALUE_"document.WWW.YPARA.value='"_$PIECE(YA,Y,13)_"'; "  ;PARAMETER NEU
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13),"")) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),"document.WWW.YPARA.value='"),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13)),"'; "));
        }
        //<< . . ;S YVALUE=YVALUE_"document.WWW.YOPEN.value='SAVESEAR'; SAVENOW();"
        //<< . . ;SET YVALUE=YVALUE_"document.WWW.YOPEN.value='2'; document.WWW.YINSEITE.value=''; document.WWW.YSEITE.value='"_$PIECE(YA,Y,56)_"'; SAVENOW();"
        //<< . . SET YVALUE=YVALUE_" document.WWW.YINSEITE.value=''; document.WWW.YSEITE.value='"_$PIECE(YA,Y,56)_"'; SAVENOW(2);"       //SR13195
        mVar YVALUE = m$.var("YVALUE");
        YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YVALUE").get()," document.WWW.YINSEITE.value=''; document.WWW.YSEITE.value='"),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),56)),"'; SAVENOW(2);"));
        break;
      }
      //<< . ;
      //<< . ;
      //<< . ;FUNCTION BEI ONCLICK ;next to
      //<< . ;-------------------------------------
      //<< . ;     D14     $$$WWW124FunctionJavaScriptOnClick()
      //<< . ;-------------------------------------
      //<< . IF $PIECE(YA,Y,14)'="" DO  QUIT
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),14),"")) {
        //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES SET YVALUE=YVALUE_YCONF1
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),YCONF1.get()));
        }
        //<< . . IF $PIECE(YA,Y,24)=1    SET YVALUE=YVALUE_"retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9');"
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),24),1)) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),"retval=EventValue('"),m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','Y"),m$.var("YFORM").get()),"','','9');"));
        }
        //<< . . IF $PIECE(YA,Y,13)'=""  SET YVALUE=YVALUE_"document.WWW.YPARA.value='"_$PIECE(YA,Y,13)_"'; "  ;PARAMETER NEU
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13),"")) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),"document.WWW.YPARA.value='"),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13)),"'; "));
        }
        //<< . . SET YVALUE=YVALUE_$PIECE(YA,Y,14)
        mVar YVALUE = m$.var("YVALUE");
        YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),14)));
        //<< . . IF '$FIND($PIECE(YA,Y,14),";") SET YVALUE=YVALUE_";"
        if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),14),";"))) {
          YVALUE.set(mOp.Concat(YVALUE.get(),";"));
        }
        //<< . . SET YVALUE=YVALUE_YCONF2
        YVALUE.set(mOp.Concat(YVALUE.get(),YCONF2.get()));
        //<< . . IF YTARGETF'="" SET YVALUE=YVALUE_" TARGET="""_YTARGETF_""""
        if (mOp.NotEqual(YTARGETF.get(),"")) {
          YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(YVALUE.get()," TARGET=\""),YTARGETF.get()),"\""));
        }
        break;
      }
      //<< . ;
      //<< . ;
      //<< . ;VERKNÜPFUNG
      //<< . ;-------------------------------------
      //<< . ;     D8      $$$WWW124LinkWithexeOrHttp()
      //<< . ;-------------------------------------
      //<< . IF $PIECE(YA,Y,8)'="" DO  QUIT
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),8),"")) {
        //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES       SET YVALUE=YVALUE_"<A onClick='return doLink(this)' HREF=""" SET YVALUE=YVALUE_YCONF0
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),"<A onClick='return doLink(this)' HREF=\""));
          YVALUE.set(mOp.Concat(YVALUE.get(),YCONF0.get()));
        }
        //<< . . IF '$FIND($PIECE(YA,Y,8),":") SET YVALUE=YVALUE_YGIF_$PIECE(YA,Y,8)
        if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),8),":"))) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),m$.var("YGIF").get()),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),8)));
        }
        //<< . . IF $FIND($PIECE(YA,Y,8),":")  SET YVALUE=YVALUE_$PIECE(YA,Y,8)
        if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),8),":"))) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),8)));
        }
        //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES       SET YVALUE=YVALUE_YCONF3
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),YCONF3.get()));
        }
        //<< . . IF YTARGETF'=""               SET YVALUE=YVALUE_" TARGET="""_YTARGETF_""""
        if (mOp.NotEqual(YTARGETF.get(),"")) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YVALUE").get()," TARGET=\""),YTARGETF.get()),"\""));
        }
        break;
      }
      //<< . ;
      //<< . ;
      //<< . ;BILDDATEI FÜR BUTTON START FORM ;to take-off shape
      //<< . ;-------------------------------------
      //<< . ;     D9      $$$WWW124PictureFileOnButton()
      //<< . ;-------------------------------------
      //<< . ;IF $PIECE(YA,Y,9)'="" S YVALUE=YVALUE_YCONF0
      //<< . ;
      //<< . ;BUTTON MIT DOWNLOAD ;by means of
      //<< . ;-------------------------------------
      //<< . ;     D12     $$$WWW124DownloadFileOnClick()
      //<< . ; May contain   [Path] VORG@ FieldNo @/ [File]
      //<< . ; Constructs    [Path] [SubPath] / [File]         where SubPath comes from INVORG DfieldNo
      //<< . ;
      //<< . ; Likely FieldNo values match the FTP directories : 96,97,98,181,182,183,184,187
      //<< . ; Possibly also Standard directories - less likely?
      //<< . ; (No additional analysis has been performed to build this list <GRF>)
      //<< . ;-------------------------------------
      //<< . IF $PIECE(YA,Y,12)'="" DO  QUIT
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),12),"")) {
        //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES SET YVALUE=YVALUE_YCONF0
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),YCONF0.get()));
        }
        //<< . . NEW YDATEI
        mVar YDATEI = m$.var("YDATEI");
        m$.newVarBlock(2,YDATEI);
        //<< . . SET YDATEI=$PIECE(YA,Y,12)
        YDATEI.set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),12));
        //<< . . IF $FIND(YDATEI,"YM/")   SET YDATEI=$PIECE(YDATEI,"YM/",1)_YM_"/"_$PIECE(YDATEI,"YM/",2)
        if (mOp.Logical(m$.Fnc.$find(YDATEI.get(),"YM/"))) {
          YDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YDATEI.get(),"YM/",1),m$.var("YM").get()),"/"),m$.Fnc.$piece(YDATEI.get(),"YM/",2)));
        }
        //<< . . IF $FIND(YDATEI,"YUCI/") SET YDATEI=$PIECE(YDATEI,"YUCI/",1)_YUCI_"/"_$PIECE(YDATEI,"YUCI/",2)
        if (mOp.Logical(m$.Fnc.$find(YDATEI.get(),"YUCI/"))) {
          YDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YDATEI.get(),"YUCI/",1),m$.var("YUCI").get()),"/"),m$.Fnc.$piece(YDATEI.get(),"YUCI/",2)));
        }
        //<< . . ;SET YDATEI=$$^WWWLOW(YDATEI)
        //<< . . ;SET YDATEI=$TRANSLATE(YDATEI,"/","\")
        //<< . . SET YDATEI=$TRANSLATE($zconvert(YDATEI,"L"),"/","\")
        YDATEI.set(m$.Fnc.$translate(m$.Fnc.$zconvert(YDATEI.get(),"L"),"/","\\"));
        //<< . . IF $FIND(YDATEI,"\auto\") DO  ;ANLEGEN UNTERVERZEICHNIS AUTOMATISCH ;put onto automatic
        if (mOp.Logical(m$.Fnc.$find(YDATEI.get(),"\\auto\\"))) {
          do {
            //<< . . . NEW FILE,X
            mVar FILE = m$.var("FILE");
            mVar X = m$.var("X");
            m$.newVarBlock(3,FILE,X);
            //<< . . . QUIT:$GET(YKEY)=""
            if (mOp.Equal(m$.Fnc.$get(m$.var("YKEY")),"")) {
              break;
            }
            //<< . . . SET FILE=$TRANSLATE($PIECE($GET(^WWW012(0,YM,1)),Y,45),"/","\")
            FILE.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),45),"/","\\"));
            //<< . . . ;I $F(FILE,"YM/") S FILE=$P(FILE,"YM/",1)_YM_"/"_$P(FILE,"YM/",2)
            //<< . . . IF $EXTRACT(FILE,$LENGTH(FILE))="\" SET FILE=$EXTRACT(FILE,1,$LENGTH(FILE)-1)
            if (mOp.Equal(m$.Fnc.$extract(FILE.get(),m$.Fnc.$length(FILE.get())),"\\")) {
              FILE.set(m$.Fnc.$extract(FILE.get(),1,mOp.Subtract(m$.Fnc.$length(FILE.get()),1)));
            }
            //<< . . . IF $EXTRACT(YDATEI)'="\" SET YDATEI="\"_YDATEI
            if (mOp.NotEqual(m$.Fnc.$extract(YDATEI.get()),"\\")) {
              YDATEI.set(mOp.Concat("\\",YDATEI.get()));
            }
            //<< . . . ;
            //<< . . . SET X=$ZF(-1,"""MKDIR "_FILE_$PIECE(YDATEI,"auto",1)_$TRANSLATE(YKEY,", """)_"""")
            X.set(m$.Fnc.$zf(mOp.Negative(1),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("\"MKDIR ",FILE.get()),m$.Fnc.$piece(YDATEI.get(),"auto",1)),m$.Fnc.$translate(m$.var("YKEY").get(),", \"")),"\"")));
            //<< . . . SET YDATEI=$PIECE(YDATEI,"auto",1)_$TRANSLATE(YKEY,", """)_$PIECE(YDATEI,"auto",2,99)
            YDATEI.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YDATEI.get(),"auto",1),m$.Fnc.$translate(m$.var("YKEY").get(),", \"")),m$.Fnc.$piece(YDATEI.get(),"auto",2,99)));
          } while (false);
        }
        m$.restoreVarBlock(3);
        //<< . . ;
        //<< . . SET YDATEI=$TRANSLATE(YDATEI,"\","/")   ;LESEN AUTO FILE ;read motor-car
        YDATEI.set(m$.Fnc.$translate(YDATEI.get(),"\\","/"));
        //<< . . IF $FIND(YDATEI,"auto") DO
        if (mOp.Logical(m$.Fnc.$find(YDATEI.get(),"auto"))) {
          //<< . . . IF $GET(YKEY)'="" SET YDATEI=$PIECE(YDATEI,"auto",1)_$TRANSLATE(YKEY,", """)_$PIECE(YDATEI,"auto",2,99)
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY")),"")) {
            YDATEI.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YDATEI.get(),"auto",1),m$.Fnc.$translate(m$.var("YKEY").get(),", \"")),m$.Fnc.$piece(YDATEI.get(),"auto",2,99)));
          }
        }
        //<< . . ;
        //<< . . DO
        do {
          //<< . . . NEW FILE,X
          mVar FILE = m$.var("FILE");
          mVar X = m$.var("X");
          m$.newVarBlock(3,FILE,X);
          //<< . . . QUIT:$GET(YKEY)=""
          if (mOp.Equal(m$.Fnc.$get(m$.var("YKEY")),"")) {
            break;
          }
          //<< . . . SET FILE=$TRANSLATE($PIECE($GET(^WWW012(0,YM,1)),Y,46),"\","/")
          FILE.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),46),"\\","/"));
          //<< . . . ;I $F(FILE,"YM/") S FILE=$P(FILE,"YM/",1)_YM_"/"_$P(FILE,"YM/",2)
          //<< . . . IF $EXTRACT(FILE,$LENGTH(FILE))="/" SET FILE=$EXTRACT(FILE,1,$LENGTH(FILE)-1)
          if (mOp.Equal(m$.Fnc.$extract(FILE.get(),m$.Fnc.$length(FILE.get())),"/")) {
            FILE.set(m$.Fnc.$extract(FILE.get(),1,mOp.Subtract(m$.Fnc.$length(FILE.get()),1)));
          }
          //<< . . . IF $EXTRACT(YDATEI)="/" SET YDATEI=$EXTRACT(YDATEI,2,9999)  ;TYBD / HERAUSNEHMEN
          if (mOp.Equal(m$.Fnc.$extract(YDATEI.get()),"/")) {
            YDATEI.set(m$.Fnc.$extract(YDATEI.get(),2,9999));
          }
          //<< . . . SET YVALUE=YVALUE_"ftp://"_FILE_"/"_YDATEI
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),"ftp://"),FILE.get()),"/"),YDATEI.get()));
          //<< . . . IF +$PIECE(YVOR,Y,45)=$$$YES SET YVALUE=YVALUE_YCONF3
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
            YVALUE.set(mOp.Concat(YVALUE.get(),YCONF3.get()));
          }
        } while(false);
        m$.restoreVarBlock(3);
        //<< . . ;
        //<< . . IF YTARGETF'="" SET YVALUE=YVALUE_" TARGET="""_YTARGETF_""""
        if (mOp.NotEqual(YTARGETF.get(),"")) {
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YVALUE").get()," TARGET=\""),YTARGETF.get()),"\""));
        }
        break;
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . ;
      //<< . ;NORMAL MIT HTMLAUFBEREITUNG ;normal by means of
      //<< . ;-------------------------------------
      //<< . ;     D1      $$$WWW124ButtonDescription()
      //<< . ;     D5      $$$WWW124DoNotPrepareHTML()
      //<< . ;     D6      $$$WWW124ExecuteOnClick()                   ; *** EXECUTE ***
      //<< . ;     D7      $$$WWW124NewFormOnClick()
      //<< . ;     D11     $$$WWW124TransferVariableIdentifie()
      //<< . ;     D13     $$$WWW124SetVariableYPARA()
      //<< . ;     D15     $$$WWW124DMSFileForTargetHttp()
      //<< . ;     D19     $$$WWW124TargetFrameName()
      //<< . ;-------------------------------------
      //<< . IF $PIECE(YA,Y,7)="" IF +$PIECE(YA,Y,5)=$$$NO IF $PIECE(YA,Y,6)'="" DO  QUIT
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7),"")) {
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),5)),include.COMSYS.$$$NO(m$))) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"")) {
            //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES DO
            if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
              //<< . . . IF $PIECE(YA,Y,17)="" IF $PIECE(YA,Y,24)=1 DO
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),17),"")) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),24),1)) {
                  //<< . . . . SET YVALUE=YVALUE_"retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9');"
                  mVar YVALUE = m$.var("YVALUE");
                  YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),"retval=EventValue('"),m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','Y"),m$.var("YFORM").get()),"','','9');"));
                  //<< . . . . SET YVALUE=YVALUE_strPrefix_"window.location='"               //SR14592
                  YVALUE.set(mOp.Concat(mOp.Concat(YVALUE.get(),m$.var("strPrefix").get()),"window.location='"));
                  //<< . . . . SET YCONF3="';"
                  YCONF3.set("';");
                }
              }
              //<< . . . ;
              //<< . . . SET YVALUE=YVALUE_YCONF0
              mVar YVALUE = m$.var("YVALUE");
              YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),YCONF0.get()));
            }
            //<< . . ;
            //<< . . IF $PIECE(YA,Y,13)'="" NEW YPARA SET YPARA=$PIECE(YA,Y,13)  ;PARAMETER NEU ;parameter recent
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13),"")) {
              mVar YPARA = m$.var("YPARA");
              m$.newVarBlock(2,YPARA);
              YPARA.set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13));
            }
            //<< . . SET YVALUE=YVALUE_YAKTION_""
            mVar YVALUE = m$.var("YVALUE");
            YVALUE.set(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),m$.var("YAKTION").get()),""));
            //<< . . SET YVALUE=YVALUE_"EP=WWWMANU&amp;YFORM="_YFORM
            YVALUE.set(mOp.Concat(mOp.Concat(YVALUE.get(),"EP=WWWMANU&amp;YFORM="),m$.var("YFORM").get()));
            //<< . . SET YBACKX=YBACK
            mVar YBACKX = m$.var("YBACKX");
            YBACKX.set(m$.var("YBACK").get());
            //<< . . ;SR13009
            //<< . . ;new strYBACK
            //<< . . ;set strYBACK = YBACK
            //<< . . ;if $reverse($piece($reverse(YBACK),",",2))'=YFORM set strYBACK = strYBACK_YFORM_","
            //<< . . ;set YBACK = strYBACK
            //<< . . ;SR13009
            //<< . . SET YBACK=YBACK_YFORM_","
            mVar YBACK = m$.var("YBACK");
            YBACK.set(mOp.Concat(mOp.Concat(m$.var("YBACK").get(),m$.var("YFORM").get()),","));
            //<< . . IF $EXTRACT($PIECE(YA,Y,6))="""" DO   ;EXECUTE VOR EXECUTE
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6)),"\"")) {
              //<< . . . NEW YEXE
              mVar YEXE = m$.var("YEXE");
              m$.newVarBlock(3,YEXE);
              //<< . . . SET YEXE=$PIECE(YA,Y,6)
              YEXE.set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6));
              //<< . . . SET YEXE="S $P(YA,Y,6)="_YEXE
              YEXE.set(mOp.Concat("S $P(YA,Y,6)=",YEXE.get()));
              //<< . . . XECUTE YEXE
              m$.Cmd.Xecute(YEXE.get());
            }
            m$.restoreVarBlock(3);
            //<< . . ;
            //<< . . SET YVALUE=YVALUE_"&YEXEC="_$TRANSLATE($PIECE(YA,Y,6),"# ""","*|`")
            YVALUE.set(mOp.Concat(mOp.Concat(YVALUE.get(),"&YEXEC="),m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"# \"","*|`")));
            //<< . . IF $PIECE(YA,Y,11)'="" SET YVALUE=YVALUE_"&"_$PIECE(YA,Y,11)_"="_@($PIECE(YA,Y,11))
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),11),"")) {
              YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YVALUE.get(),"&"),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),11)),"="),m$.indirectVar((m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),11))).get()));
            }
            //<< . . DO
            do {
              //<< . . . NEW YI
              m$.newVarBlock(3,YI);
              //<< . . . DO VAR^WWWCGI
              m$.Cmd.Do("WWWCGI.VAR");
              //<< . . . SET YVALUE=YVALUE_YI
              YVALUE.set(mOp.Concat(YVALUE.get(),YI.get()));
            } while(false);
            m$.restoreVarBlock(3);
            //<< . . ;
            //<< . . SET YBACK=YBACKX
            YBACK.set(YBACKX.get());
            //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES SET YVALUE=YVALUE_YCONF3
            if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
              YVALUE.set(mOp.Concat(YVALUE.get(),YCONF3.get()));
            }
            //<< . . IF YTARGETF'=""         SET YVALUE=YVALUE_" TARGET="""_YTARGETF_""""
            if (mOp.NotEqual(YTARGETF.get(),"")) {
              YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(YVALUE.get()," TARGET=\""),YTARGETF.get()),"\""));
            }
            break;
          }
          m$.restoreVarBlock(2);
        }
      }
      //<< . . ;IF $PIECE(YA,Y,15)'="" DO ABLAGE
      //<< . ;
      //<< . ;
      //<< . ;OHNE HTML AUFBEREITUNG ;without HTML
      //<< . IF $PIECE(YA,Y,7)="" IF +$PIECE(YA,Y,5)=$$$YES IF $PIECE(YA,Y,6)'="" DO  QUIT
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7),"")) {
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),5)),include.COMSYS.$$$YES(m$))) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"")) {
            //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES DO
            if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
              //<< . . . IF $PIECE(YA,Y,17)="" IF $PIECE(YA,Y,24)=1 DO
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),17),"")) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),24),1)) {
                  //<< . . . . SET YVALUE=YVALUE_"retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9');"
                  mVar YVALUE = m$.var("YVALUE");
                  YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),"retval=EventValue('"),m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','Y"),m$.var("YFORM").get()),"','','9');"));
                  //<< . . . . SET YVALUE=YVALUE_strPrefix_"window.location='" //SR14592
                  YVALUE.set(mOp.Concat(mOp.Concat(YVALUE.get(),m$.var("strPrefix").get()),"window.location='"));
                  //<< . . . . SET YCONF3="';"
                  YCONF3.set("';");
                }
              }
              //<< . . . ;
              //<< . . . SET YVALUE=YVALUE_YCONF0
              mVar YVALUE = m$.var("YVALUE");
              YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),YCONF0.get()));
            }
            //<< . . ;
            //<< . . IF $PIECE(YA,Y,13)'="" NEW YPARA SET YPARA=$PIECE(YA,Y,13)  ;PARAMETER NEU ;parameter recent
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13),"")) {
              mVar YPARA = m$.var("YPARA");
              m$.newVarBlock(2,YPARA);
              YPARA.set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13));
            }
            //<< . . SET YVALUE=YVALUE_YAKTION_""
            mVar YVALUE = m$.var("YVALUE");
            YVALUE.set(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),m$.var("YAKTION").get()),""));
            //<< . . SET YVALUE=YVALUE_"EP=WWWMANU1&amp;YFORM="_YFORM
            YVALUE.set(mOp.Concat(mOp.Concat(YVALUE.get(),"EP=WWWMANU1&amp;YFORM="),m$.var("YFORM").get()));
            //<< . . SET YBACKX=YBACK
            mVar YBACKX = m$.var("YBACKX");
            YBACKX.set(m$.var("YBACK").get());
            //<< . . ;SR13009
            //<< . . ;new strYBACK
            //<< . . ;set strYBACK = YBACK
            //<< . . ;if $reverse($piece($reverse(YBACK),",",2))'=YFORM set strYBACK = strYBACK_YFORM_","
            //<< . . ;set YBACK = strYBACK
            //<< . . ;SR13009
            //<< . . SET YBACK=YBACK_YFORM_","
            mVar YBACK = m$.var("YBACK");
            YBACK.set(mOp.Concat(mOp.Concat(m$.var("YBACK").get(),m$.var("YFORM").get()),","));
            //<< . . IF $EXTRACT($PIECE(YA,Y,6))="""" DO   ;EXECUTE VOR EXECUTE
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6)),"\"")) {
              //<< . . . NEW YEXE
              mVar YEXE = m$.var("YEXE");
              m$.newVarBlock(3,YEXE);
              //<< . . . SET YEXE=$PIECE(YA,Y,6)
              YEXE.set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6));
              //<< . . . SET YEXE="S $P(YA,Y,6)="_YEXE
              YEXE.set(mOp.Concat("S $P(YA,Y,6)=",YEXE.get()));
              //<< . . . XECUTE YEXE
              m$.Cmd.Xecute(YEXE.get());
            }
            m$.restoreVarBlock(3);
            //<< . . ;
            //<< . . SET YVALUE=YVALUE_"&YEXEC="_$TRANSLATE($PIECE(YA,Y,6),"# ""%","*|`")
            YVALUE.set(mOp.Concat(mOp.Concat(YVALUE.get(),"&YEXEC="),m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"# \"%","*|`")));
            //<< . . IF $PIECE(YA,Y,11)'="" SET YVALUE=YVALUE_"&"_$PIECE(YA,Y,11)_"="_@($PIECE(YA,Y,11))
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),11),"")) {
              YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YVALUE.get(),"&"),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),11)),"="),m$.indirectVar((m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),11))).get()));
            }
            //<< . . DO
            do {
              //<< . . . NEW YI
              m$.newVarBlock(3,YI);
              //<< . . . DO VAR^WWWCGI
              m$.Cmd.Do("WWWCGI.VAR");
              //<< . . . SET YVALUE=YVALUE_YI
              YVALUE.set(mOp.Concat(YVALUE.get(),YI.get()));
            } while(false);
            m$.restoreVarBlock(3);
            //<< . . ;
            //<< . . SET YBACK=YBACKX
            YBACK.set(YBACKX.get());
            //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES SET YVALUE=YVALUE_YCONF3
            if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
              YVALUE.set(mOp.Concat(YVALUE.get(),YCONF3.get()));
            }
            //<< . . IF YTARGETF'="" SET YVALUE=YVALUE_" TARGET="""_YTARGETF_""""
            if (mOp.NotEqual(YTARGETF.get(),"")) {
              YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(YVALUE.get()," TARGET=\""),YTARGETF.get()),"\""));
            }
            break;
          }
          m$.restoreVarBlock(2);
        }
      }
      //<< . . ;IF $PIECE(YA,Y,15)'="" DO ABLAGE
      //<< . ;
      //<< . ;
      //<< . ; FORMULAR AUFRUF NORMAL ;form normal
      //<< . IF ($PIECE(YA,Y,6)="") || ($PIECE(YA,Y,6)="SUBMIT") || ($PIECE(YA,Y,6)="submit") IF $PIECE(YA,Y,7)'="" DO  QUIT
      if ((mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"")) || (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"SUBMIT")) || (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"submit"))) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7),"")) {
          //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES DO
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
            //<< . . . IF $PIECE(YA,Y,17)="" IF $zconvert($PIECE(YA,Y,6),"U")="SUBMIT" DO
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),17),"")) {
              if (mOp.Equal(m$.Fnc.$zconvert(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),6),"U"),"SUBMIT")) {
                //<< . . . . SET YVALUE=YVALUE_"retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','Y"_YFORM_"','','9');"
                mVar YVALUE = m$.var("YVALUE");
                YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),"retval=EventValue('"),m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','Y"),m$.var("YFORM").get()),"','','9');"));
                //<< . . . . SET YVALUE=YVALUE_strPrefix_"window.location='" //SR14592
                YVALUE.set(mOp.Concat(mOp.Concat(YVALUE.get(),m$.var("strPrefix").get()),"window.location='"));
                //<< . . . . SET YCONF3="';"
                YCONF3.set("';");
              }
            }
            //<< . . . ;
            //<< . . . SET YVALUE=YVALUE_YCONF0
            mVar YVALUE = m$.var("YVALUE");
            YVALUE.set(mOp.Concat(m$.var("YVALUE").get(),YCONF0.get()));
          }
          //<< . . ;
          //<< . . IF $PIECE(YA,Y,13)'="" NEW YPARA SET YPARA=$PIECE(YA,Y,13)  ;PARAMETER NEU ;parameter recent
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13),"")) {
            mVar YPARA = m$.var("YPARA");
            m$.newVarBlock(2,YPARA);
            YPARA.set(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),13));
          }
          //<< . . SET YVALUE=YVALUE_YAKTION_""
          mVar YVALUE = m$.var("YVALUE");
          YVALUE.set(mOp.Concat(mOp.Concat(m$.var("YVALUE").get(),m$.var("YAKTION").get()),""));
          //<< . . SET YKEYXX=YKEY
          mVar YKEYXX = m$.var("YKEYXX");
          YKEYXX.set(m$.var("YKEY").get());
          //<< . . NEW MAPPING,YKEY,YNOKEY,YNEXKEY
          mVar MAPPING = m$.var("MAPPING");
          mVar YKEY = m$.var("YKEY");
          mVar YNOKEY = m$.var("YNOKEY");
          mVar YNEXKEY = m$.var("YNEXKEY");
          m$.newVarBlock(2,MAPPING,YKEY,YNOKEY,YNEXKEY);
          //<< . . SET MAPPING=""   ;FELDMAPPING XXX=FELD
          MAPPING.set("");
          //<< . . IF $PIECE(YA,Y,54)'="" DO
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),54),"")) {
            //<< . . . NEW I,MAP
            mVar I = m$.var("I");
            mVar MAP = m$.var("MAP");
            m$.newVarBlock(3,I,MAP);
            //<< . . . SET YNOKEY=YFORM  ;BEI RÜCKSPRUNG KEINE ÜBERGABE DES KEY´S ;next to no
            YNOKEY.set(m$.var("YFORM").get());
            //<< . . . SET MAPPING=$TRANSLATE($PIECE(YA,Y,54),",",";")
            MAPPING.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),54),",",";"));
            //<< . . . SET YKEY=YKEYXX   ;VORGABE NORMAL ;default normal
            YKEY.set(YKEYXX.get());
            //<< . . . FOR I=1:1 QUIT:$PIECE(MAPPING,";",I)=""  SET MAP=$PIECE(MAPPING,";",I) DO
            for (I.set(1);(true);I.set(mOp.Add(I.get(),1))) {
              if (mOp.Equal(m$.Fnc.$piece(MAPPING.get(),";",I.get()),"")) {
                break;
              }
              MAP.set(m$.Fnc.$piece(MAPPING.get(),";",I.get()));
              do {
                //<< . . . . IF $PIECE(MAP,"=",1)=0              SET $PIECE(YKEY,",",+$PIECE(MAP,"=",2))="",$PIECE(YFKEY,",",+$PIECE(MAP,"=",2))="" QUIT  ;KEINE VORGABE ;no default
                if (mOp.Equal(m$.Fnc.$piece(MAP.get(),"=",1),0)) {
                  m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set("");
                  m$.pieceVar(m$.var("YFKEY"),",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set("");
                  break;
                }
                //<< . . . . IF $PIECE(MAP,"=",1)=999            SET $PIECE(YKEY,",",+$PIECE(MAP,"=",2))="",$PIECE(YFKEY,",",+$PIECE(MAP,"=",2))="" QUIT  ;KEINE VORGABE ;no default
                if (mOp.Equal(m$.Fnc.$piece(MAP.get(),"=",1),999)) {
                  m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set("");
                  m$.pieceVar(m$.var("YFKEY"),",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set("");
                  break;
                }
                //<< . . . . IF $EXTRACT($PIECE(MAP,"=",1))="""" SET $PIECE(YKEY,",",+$PIECE(MAP,"=",2))=$TRANSLATE($PIECE(MAP,"=",1),"""")         QUIT
                if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(MAP.get(),"=",1)),"\"")) {
                  m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set(m$.Fnc.$translate(m$.Fnc.$piece(MAP.get(),"=",1),"\""));
                  break;
                }
                //<< . . . . SET $PIECE(YKEY,",",+$PIECE(MAP,"=",2))=$PIECE(YFELD,Y,+$PIECE(MAP,"=",1))
                m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",1))));
              } while (false);
            }
          }
          m$.restoreVarBlock(3);
          //<< . . ;
          //<< . . IF MAPPING="" SET YKEY=YKEYXX   ;NORMALE KEYVORGABE
          if (mOp.Equal(MAPPING.get(),"")) {
            YKEY.set(YKEYXX.get());
          }
          //<< . . ;
          //<< . . IF $PIECE(YA,Y,7)'="" DO  ;PRUEFEN FPRMULAR AUF DATENINHALT ;upon
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7),"")) {
            do {
              //<< . . . NEW YDATEI,YFELD,YSCHLUES,YI
              mVar YDATEI = m$.var("YDATEI");
              mVar YFELD = m$.var("YFELD");
              mVar YSCHLUES = m$.var("YSCHLUES");
              m$.newVarBlock(3,YDATEI,YFELD,YSCHLUES,YI);
              //<< . . . SET YDATEI=$PIECE($GET(^WWW120(0,$PIECE(YA,Y,7),1)),Y,11)
              YDATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7),1)),m$.var("Y").get(),11));
              //<< . . . QUIT:YDATEI=""   ;KEINE DATEI ;no data file
              if (mOp.Equal(YDATEI.get(),"")) {
                break;
              }
              //<< . . . SET YSCHLUES="^"_YDATEI_"("_$$^WWWYM(YDATEI,1)
              YSCHLUES.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get(),1)));
              //<< . . . FOR YI=1:1 QUIT:$PIECE(YKEY,",",YI)=""  SET YSCHLUES=YSCHLUES_""""_$PIECE(YKEY,",",YI)_"""" IF $PIECE(YKEY,",",YI+1)'="" SET YSCHLUES=YSCHLUES_","
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                if (mOp.Equal(m$.Fnc.$piece(YKEY.get(),",",YI.get()),"")) {
                  break;
                }
                YSCHLUES.set(mOp.Concat(mOp.Concat(mOp.Concat(YSCHLUES.get(),"\""),m$.Fnc.$piece(YKEY.get(),",",YI.get())),"\""));
                if (mOp.NotEqual(m$.Fnc.$piece(YKEY.get(),",",mOp.Add(YI.get(),1)),"")) {
                  YSCHLUES.set(mOp.Concat(YSCHLUES.get(),","));
                }
              }
              //<< . . . IF $EXTRACT(YSCHLUES,$LENGTH(YSCHLUES))="," SET YSCHLUES=$EXTRACT(YSCHLUES,1,$LENGTH(YSCHLUES)-1)
              if (mOp.Equal(m$.Fnc.$extract(YSCHLUES.get(),m$.Fnc.$length(YSCHLUES.get())),",")) {
                YSCHLUES.set(m$.Fnc.$extract(YSCHLUES.get(),1,mOp.Subtract(m$.Fnc.$length(YSCHLUES.get()),1)));
              }
              //<< . . . IF $LENGTH(YSCHLUES)<($LENGTH(YDATEI)+1+$LENGTH($$^WWWYM(YDATEI))) QUIT
              if (mOp.Less(m$.Fnc.$length(YSCHLUES.get()),(mOp.Add(mOp.Add(m$.Fnc.$length(YDATEI.get()),1),m$.Fnc.$length(m$.fnc$("WWWYM.main",YDATEI.get())))))) {
                break;
              }
              //<< . . . SET YSCHLUES=YSCHLUES_")"
              YSCHLUES.set(mOp.Concat(YSCHLUES.get(),")"));
              //<< . . . IF $DATA(@(YSCHLUES)) DO
              if (mOp.Logical(m$.Fnc.$data(m$.indirectVar((YSCHLUES.get()))))) {
                //<< . . . . ;SET $PIECE(YA,Y,1)="* "_$PIECE(YA,Y,1)        ;DATEN VORHANDEN ;TYBD;16,04,2003
                //<< . . . . ;SET $PIECE(YA,Y,1)="&raquo; "_$PIECE(YA,Y,1)  ;DATEN VORHANDEN ;TYBD;16,04,2003
                //<< . . . . SET $PIECE(YA,Y,1)="&bull; "_$PIECE(YA,Y,1)    ;DATEN VORHANDEN ;TYBD;16,04,2003
                m$.pieceVar(m$.var("YA"),m$.var("Y").get(),1).set(mOp.Concat("&bull; ",m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),1)));
                //<< . . . . ;
                //<< . . . . IF $PIECE(YA,Y,55)=1 DO    ;ERSTEN DATENSATZ AUSWÄHLEN ;data record pick out
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),55),1)) {
                  //<< . . . . . SET YNEXKEY=$PIECE($PIECE($QUERY(@YSCHLUES),"(",2),")",1)
                  YNEXKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$query(m$.indirectVar(YSCHLUES.get())),"(",2),")",1));
                  //<< . . . . . SET YNEXKEY=$PIECE(YNEXKEY,",",2,$LENGTH(YNEXKEY,",")-1)
                  YNEXKEY.set(m$.Fnc.$piece(YNEXKEY.get(),",",2,mOp.Subtract(m$.Fnc.$length(YNEXKEY.get(),","),1)));
                  //<< . . . . . IF '$FIND("-"_$TRANSLATE(YNEXKEY,""""),"-"_$TRANSLATE(YKEYXX,"""")) SET YNEXKEY=""
                  if (mOp.Not(m$.Fnc.$find(mOp.Concat("-",m$.Fnc.$translate(YNEXKEY.get(),"\"")),mOp.Concat("-",m$.Fnc.$translate(YKEYXX.get(),"\""))))) {
                    YNEXKEY.set("");
                  }
                  //<< . . . . . IF YNEXKEY'="" SET YKEY=YNEXKEY
                  if (mOp.NotEqual(YNEXKEY.get(),"")) {
                    YKEY.set(YNEXKEY.get());
                  }
                }
              }
            } while (false);
          }
          m$.restoreVarBlock(3);
          //<< . . ;
          //<< . . ;IF $GET(YFOART)=1 IF $PIECE($GET(^WWW120(0,$PIECE(YA,Y,7),1)),Y,2)<4 KILL ^WWW128(0,$PIECE(YA,Y,7))  ;LFN
          //<< . . SET YVALUE=YVALUE_"EP=WWWFORM&amp;YFORM="_$PIECE(YA,Y,7)
          YVALUE.set(mOp.Concat(mOp.Concat(YVALUE.get(),"EP=WWWFORM&amp;YFORM="),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),7)));
          //<< . . SET YBACKX=YBACK
          mVar YBACKX = m$.var("YBACKX");
          YBACKX.set(m$.var("YBACK").get());
          //<< . . DO
          do {
            //<< . . . ;SR13009
            //<< . . . ;new strYBACK
            //<< . . . ;set strYBACK = YBACK
            //<< . . . ;if $reverse($piece($reverse(YBACK),",",2))'=YFORM set strYBACK = strYBACK_YFORM_","
            //<< . . . ;set YBACK = strYBACK
            //<< . . . ;SR13009
            //<< . . . SET YBACK=YBACK_YFORM_","
            mVar YBACK = m$.var("YBACK");
            YBACK.set(mOp.Concat(mOp.Concat(m$.var("YBACK").get(),m$.var("YFORM").get()),","));
          } while(false);
          //<< . . ;
          //<< . . IF $PIECE(YA,Y,11)'="" SET YVALUE=YVALUE_"&"_$PIECE(YA,Y,11)_"="_$GET(@($PIECE(YA,Y,11)))
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),11),"")) {
            YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YVALUE.get(),"&"),m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),11)),"="),m$.Fnc.$get(m$.indirectVar((m$.Fnc.$piece(m$.var("YA").get(),m$.var("Y").get(),11))))));
          }
          //<< . . DO
          do {
            //<< . . . NEW YI
            m$.newVarBlock(3,YI);
            //<< . . . DO VAR^WWWCGI
            m$.Cmd.Do("WWWCGI.VAR");
            //<< . . . SET YVALUE=YVALUE_YI
            YVALUE.set(mOp.Concat(YVALUE.get(),YI.get()));
          } while(false);
          m$.restoreVarBlock(3);
          //<< . . ;
          //<< . . SET YBACK=YBACKX
          mVar YBACK = m$.var("YBACK");
          YBACK.set(YBACKX.get());
          //<< . . IF +$PIECE(YVOR,Y,45)=$$$YES SET YVALUE=YVALUE_YCONF3
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
            YVALUE.set(mOp.Concat(YVALUE.get(),YCONF3.get()));
          }
          //<< . . IF YTARGETF'=""         SET YVALUE=YVALUE_" TARGET="""_YTARGETF_""""
          if (mOp.NotEqual(YTARGETF.get(),"")) {
            YVALUE.set(mOp.Concat(mOp.Concat(mOp.Concat(YVALUE.get()," TARGET=\""),YTARGETF.get()),"\""));
          }
          break;
        }
        m$.restoreVarBlock(2);
      }
    } while(false);
    //<< . . ;IF $PIECE(YA,Y,15)'="" DO ABLAGE
    //<< 
    //<< QUIT
    return;
  }

//<< 
}
