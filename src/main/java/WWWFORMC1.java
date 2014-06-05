//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMC1
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:51
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

//<< WWWFORMC1
public class WWWFORMC1 extends mClass {

  public void main() {
    _WWWFORMC1();
  }

  public void _WWWFORMC1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       BUTTON BEI FORMULAREN AN DER LINKEN SEITE
    //<< ;       BUTTON WITH FORMS AT LEFT SIDE
    //<< ;
    //<< ; Called By:
    //<< ;   Routine WWWFORM
    //<< ;
    //<< ; Inputs :
    //<< ;   YVOR
    //<< ;   YFORM
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 13-Jan-2010   GRF     Button Macros; use blnPicOnButton & blnDescOnButton
    //<< ;                           instead of getting repeatedly (two for clarity)
    //<< ; 21-Nov-2007   GRF     SR15614: Macros; idxForm
    //<< ; 27-Sep-2007   GRF     Unnecessary do level removed; !=>||
    //<< ; 12-Sep-2006   JW      Convert alert text to JS
    //<< ; 24-Aug-2006   GRF     Doco
    //<< ; 08-Aug-2006   GRF     Doco; dot levels; quits; YCR; expand commands
    //<< ; 22-Dec-2005   JW      SR13195: Edited SAVENOW calls.
    //<< ; 01-Jun-2005   RW      SR12056: Attempt at Performance Increase
    //<< ; 04-Apr-2005   PO/RPW  SR12014 Fixed usage of find
    //<< ; 09.10.2000    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnDescOnButton,blnPicOnButton,idxForm
    mVar blnDescOnButton = m$.var("blnDescOnButton");
    mVar blnPicOnButton = m$.var("blnPicOnButton");
    mVar idxForm = m$.var("idxForm");
    m$.newVar(blnDescOnButton,blnPicOnButton,idxForm);
    //<< new I,Q,SPRACHE,YA,YBPOS,YEXEC,YI,YKEYXX,YLFN,YPRINT,YQ
    mVar I = m$.var("I");
    mVar Q = m$.var("Q");
    mVar SPRACHE = m$.var("SPRACHE");
    mVar YA = m$.var("YA");
    mVar YBPOS = m$.var("YBPOS");
    mVar YEXEC = m$.var("YEXEC");
    mVar YI = m$.var("YI");
    mVar YKEYXX = m$.var("YKEYXX");
    mVar YLFN = m$.var("YLFN");
    mVar YPRINT = m$.var("YPRINT");
    mVar YQ = m$.var("YQ");
    m$.newVar(I,Q,SPRACHE,YA,YBPOS,YEXEC,YI,YKEYXX,YLFN,YPRINT,YQ);
    //<< 
    //<< ;IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* SPECIAL BUTTON LINKS (WWWFORMC1) ************************* -->",YCR,YCR
    //<< 
    //<< WRITE "<TABLE BORDER=0 STYLE=""table-layout:fixed"" WIDTH=120>"
    m$.Cmd.Write("<TABLE BORDER=0 STYLE=\"table-layout:fixed\" WIDTH=120>");
    //<< ;WRITE "<COL WIDTH=120>"
    //<< WRITE YCR,"<TR><TD NOWRAP ALIGN=LEFT>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TR><TD NOWRAP ALIGN=LEFT>");
    //<< WRITE "<FONT SIZE=2><NOBR>"
    m$.Cmd.Write("<FONT SIZE=2><NOBR>");
    //<< ;W "<B>"
    //<< 
    //<< IF YFOART=5 IF '$DATA(^WWW122(0,YFORM)) SET YWIDTH="",YHEIGHT=""
    if (mOp.Equal(m$.var("YFOART").get(),5)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
        mVar YWIDTH = m$.var("YWIDTH");
        YWIDTH.set("");
        mVar YHEIGHT = m$.var("YHEIGHT");
        YHEIGHT.set("");
      }
    }
    //<< SET YI=0
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
    //<< set blnPicOnButton  = (+$$$WWW120PicturesAsButtons(YVOR)=$$$YES)   ; D45
    blnPicOnButton.set((mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.var("YVOR"))),include.COMSYS.$$$YES(m$))));
    //<< set blnDescOnButton = 'blnPicOnButton
    blnDescOnButton.set(mOp.Not(blnPicOnButton.get()));
    //<< 
    //<< ;---------------------------------------
    //<< ; Check for Action on Button
    //<< ;   D6      $$$WWW124ExecuteOnClick()
    //<< ;   D7      $$$WWW124NewFormOnClick()
    //<< ;   D8      $$$WWW124LinkWithexeOrHttp()
    //<< ;   D12     $$$WWW124DownloadFileOnClick()
    //<< ;   D14     $$$WWW124FunctionJavaScriptOnClick()
    //<< ;   D53     $$$WWW124SearchFunctionOnClick()
    //<< ;   D56     $$$WWW124ChangeoversWithOnClick()
    //<< ;   D57     $$$WWW124QueryOnClick()
    //<< ;   D65     $$$WWW124HyperEventOnClick()
    //<< ;---------------------------------------
    //<< 
    //<< ;SUCHEN BUTTONS ;search all buttons
    //<< ; Index 2 : P1 (idForm), P2 (Language), D4 (Column)
    //<< ;---------------------------------------
    //<< set idxForm = $$$Index(YFORM)   ; SR15614
    idxForm.set(include.MEDConst.$$$Index(m$,m$.var("YFORM")));
    //<< SET YBPOS = ""
    YBPOS.set("");
    //<< FOR  SET YBPOS = $ORDER(^WWW124s(0,2,idxForm,SPRACHE,YBPOS)) QUIT:YBPOS=""  SET YLFN = "" FOR  SET YLFN = $ORDER(^WWW124s(0,2,idxForm,SPRACHE,YBPOS,YFORM,SPRACHE,YLFN)) QUIT:YLFN=""  DO
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
          //<< . ;
          //<< . ; D50     $$$WWW124ShowOnlyWhenYOPTION()
          //<< . IF YOPTION'="" IF $PIECE(YA,Y,50)'="" QUIT:'$FIND(","_$PIECE(YA,Y,50)_",",","_YOPTION_",")  ;NICHT ANZEIGE WEIL OPTION FALSCH ;Not Show since right of first refusal wrong
          if (mOp.NotEqual(m$.var("YOPTION").get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),50),"")) {
              if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),50)),","),mOp.Concat(mOp.Concat(",",m$.var("YOPTION").get()),",")))) {
                break;
              }
            }
          }
          //<< . SET YPRINT="" IF $PIECE(YA,Y,18)=$$$YES SET YPRINT=$$$YES     ;ZIEL DRUCKEN ;target print  ; $$$WWW124OutputWithWindowprint()
          YPRINT.set("");
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),18),include.COMSYS.$$$YES(m$))) {
            YPRINT.set(include.COMSYS.$$$YES(m$));
          }
          //<< . QUIT:($$^WWWACCESS($PIECE(YA,Y,22),$PIECE(YA,Y,23))'=$$$YES)  ;KEIN ZUGANG ;not authorised ; $$$WWW124Authorization1(), $$$WWW124Module1()
          if ((mOp.NotEqual(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),22),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),23)),include.COMSYS.$$$YES(m$)))) {
            break;
          }
          //<< . ;
          //<< . IF $EXTRACT($PIECE(YA,Y,19))="@" NEW YBACK SET YBACK = ""     ;OHNE YBACK ;without YBACK   ; $$$WWW124TargetFrameName()
          if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"@")) {
            mVar YBACK = m$.var("YBACK");
            m$.newVarBlock(1,YBACK);
            YBACK.set("");
          }
          //<< . ;
          //<< . IF $PIECE(YA,Y,63)'="" IF '$FIND(","_$PIECE(YA,Y,63)_",",","_YMANDANT_",") QUIT            ; $$$WWW124ButtonOnlyForCompany()  ; DEPRECATED
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),63),"")) {
            if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),63)),","),mOp.Concat(mOp.Concat(",",m$.var("YMANDANT").get()),",")))) {
              break;
            }
          }
          //<< . IF $PIECE(YA,Y,64)'="" IF $FIND(","_$PIECE(YA,Y,64)_",",","_YMANDANT_",")  QUIT            ; $$$WWW124ButtonNotforCompany()   ; DEPRECATED
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),64),"")) {
            if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),64)),","),mOp.Concat(mOp.Concat(",",m$.var("YMANDANT").get()),",")))) {
              break;
            }
          }
          //<< . ;
          //<< . ; Check for Action on Button - quit if none found
          //<< . IF $PIECE(YA,Y,6)="" IF $PIECE(YA,Y,7)="" IF $PIECE(YA,Y,8)="" IF $PIECE(YA,Y,12)="" IF $PIECE(YA,Y,53)="" IF $PIECE(YA,Y,56)="" IF $PIECE(YA,Y,57)="" IF $PIECE(YA,Y,14)="" IF $PIECE(YA,Y,65)="" QUIT
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),"")) {
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"")) {
              if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),"")) {
                if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
                  if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),53),"")) {
                    if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),56),"")) {
                      if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),57),"")) {
                        if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),14),"")) {
                          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),65),"")) {
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
          //<< . ;
          //<< . IF $PIECE(YA,Y,57)'="" SET $PIECE(YA,Y,6)="QUERY,"_$PIECE(YA,Y,57)  ;QUERY AUFRUFEN
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),57),"")) {
            m$.pieceVar(YA,m$.var("Y").get(),6).set(mOp.Concat("QUERY,",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),57)));
          }
          //<< . ;
          //<< . IF $PIECE(YA,Y,11)'="" DO                                           ;ZUSATZVARIABLE        ; $$$WWW124TransferVariableIdentifie()
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),11),"")) {
            do {
              //<< . . NEW YQ
              m$.newVarBlock(2,YQ);
              //<< . . SET YQ  = $PIECE(YA,Y,11)
              YQ.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),11));
              //<< . . IF '$DATA(@YQ) QUIT
              if (mOp.Not(m$.Fnc.$data(m$.indirectVar(YQ.get())))) {
                break;
              }
              //<< . . SET @YQ = $GET(%(YQUERY,YQ))
              m$.indirectVar(YQ.get()).set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),YQ.get())));
            } while (false);
          }
          m$.restoreVarBlock(2);
          //<< . ;
          //<< . SET YI = YI+1
          YI.set(mOp.Add(YI.get(),1));
          //<< . ;
          //<< . ; D9      $$$WWW124PictureFileOnButton()
          //<< . ; If no picture defined when expected, set picture to first letter : If associated with a data item don't show in button line
          //<< . IF blnPicOnButton IF $PIECE(YA,Y,9)="" SET $PIECE(YA,Y,9) = $zconvert($extract($$$WWW124ButtonDescription(YA)),"L")_".gif"
          if (mOp.Logical(blnPicOnButton.get())) {
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),9),"")) {
              m$.pieceVar(YA,m$.var("Y").get(),9).set(mOp.Concat(m$.Fnc.$zconvert(m$.Fnc.$extract(include.WWWConst.$$$WWW124ButtonDescription(m$,YA)),"L"),".gif"));
            }
          }
          //<< . QUIT:$$$WWW124ButtonBelongsToADataItem(YA)=$$$YES                     ;
          if (mOp.Equal(include.WWWConst.$$$WWW124ButtonBelongsToADataItem(m$,YA),include.COMSYS.$$$YES(m$))) {
            break;
          }
          //<< . ;
          //<< . ; D19     $$$WWW124TargetFrameName()
          //<< . ; D51     $$$WWW124DisplayOnlyWhenMenuParam()
          //<< . IF $PIECE(YA,Y,51)'="" QUIT:'$FIND(","_YPARA_",",","_$PIECE(YA,Y,51)_",")  ;NICHT ANZEIGE WEIL PARAMETER FALSCH ;Not Show since parameter wrong
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),51),"")) {
            if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.var("YPARA").get()),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),51)),",")))) {
              break;
            }
          }
          //<< . SET YTARGETF = $PIECE(YA,Y,19)
          mVar YTARGETF = m$.var("YTARGETF");
          YTARGETF.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19));
          //<< . IF $EXTRACT(YTARGETF)="@" SET YTARGETF = @$EXTRACT(YTARGETF,2,99)  ;FIS;26.09.03;ZIELTARGET AUS PARAMETER ;out of parameter
          if (mOp.Equal(m$.Fnc.$extract(YTARGETF.get()),"@")) {
            YTARGETF.set(m$.indirectVar(m$.Fnc.$extract(YTARGETF.get(),2,99)).get());
          }
          //<< . ;
          //<< . ;-------------------------------------
          //<< . ;
          //<< . WRITE YCR
          m$.Cmd.Write(m$.var("YCR").get());
          //<< . ;
          //<< . ; DISABLED BUTTON BEI FORMULAREN, WENN KEIN KEY
          //<< . IF blnPicOnButton IF $PIECE(YA,Y,7)'="" IF ($TRANSLATE(YKEY,",+""")="") || ($PIECE(YKEY,",",2)="+") IF +$PIECE($GET(^WWW121(0,$PIECE(YA,Y,7),1,1)),Y,16)'=0 DO  QUIT
          if (mOp.Logical(blnPicOnButton.get())) {
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"")) {
              if ((mOp.Equal(m$.Fnc.$translate(m$.var("YKEY").get(),",+\""),"")) || (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",2),"+"))) {
                if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),1,1)),m$.var("Y").get(),16)),0)) {
                  //<< . . WRITE "<A onClick='return doLink(this)' HREF=""JavaScript:"
                  m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"JavaScript:");
                  //<< . . WRITE "alert('"_$$^WWWTEXT(32072)_"');"            ; "Please Select A Data Record First."
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('",m$.fnc$("WWWTEXT.main",32072)),"');"));
                  //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
                  //<< . . IF $PIECE(YA,Y,9)'="" WRITE YCR,$$$WWW124ButtonDescription(YA)
                  if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),9),"")) {
                    m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA));
                  }
                  //<< . . WRITE "</A><BR>"
                  m$.Cmd.Write("</A><BR>");
                  break;
                }
              }
            }
          }
          //<< . ;
          //<< . IF blnPicOnButton IF $PIECE(YA,Y,20)=$$$YES IF ($TRANSLATE(YKEY,",+""")="") || ($PIECE(YKEY,",",2)="+") DO  QUIT   ;DISABLE WENN KEIN KEY (20) ;when no KEY
          if (mOp.Logical(blnPicOnButton.get())) {
            if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20),include.COMSYS.$$$YES(m$))) {
              if ((mOp.Equal(m$.Fnc.$translate(m$.var("YKEY").get(),",+\""),"")) || (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",2),"+"))) {
                //<< . . WRITE "<A onClick='return doLink(this)' HREF=""JavaScript:"
                m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"JavaScript:");
                //<< . . WRITE "alert('"_$$^WWWTEXT(32072)_"');"            ; "Please Select A Data Record First."
                m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('",m$.fnc$("WWWTEXT.main",32072)),"');"));
                //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
                m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
                //<< . . IF $PIECE(YA,Y,9)'="" WRITE YCR,$$$WWW124ButtonDescription(YA)
                if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),9),"")) {
                  m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA));
                }
                //<< . . WRITE "</A><BR>"
                m$.Cmd.Write("</A><BR>");
                break;
              }
            }
          }
          //<< . ;
          //<< . SET YCHECK = $$$NO    ; D20          $$$WWW124OnlyWhenRecordSelected()
          mVar YCHECK = m$.var("YCHECK");
          YCHECK.set(include.COMSYS.$$$NO(m$));
          //<< . FOR YI(9)=1:1:$LENGTH(YKEY,",")  IF $PIECE(YKEY,",",YI(9))="" SET YCHECK = $$$YES  ;FIS;25049;04.02.04
          for (m$.var("YI",9).set(1);(mOp.LessOrEqual(m$.var("YI",9).get(),m$.Fnc.$length(m$.var("YKEY").get(),",")));m$.var("YI",9).set(mOp.Add(m$.var("YI",9).get(),1))) {
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.var(9).get()),"")) {
              YCHECK.set(include.COMSYS.$$$YES(m$));
            }
          }
          //<< . IF YBEARB=1 IF YCHECK=$$$YES IF blnPicOnButton IF $PIECE(YA,Y,20)=$$$YES DO  QUIT   ; Disable when no KEY
          if (mOp.Equal(m$.var("YBEARB").get(),1)) {
            if (mOp.Equal(YCHECK.get(),include.COMSYS.$$$YES(m$))) {
              if (mOp.Logical(blnPicOnButton.get())) {
                if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20),include.COMSYS.$$$YES(m$))) {
                  //<< . . WRITE "<A onClick='return doLink(this)' HREF=""JavaScript:"
                  m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"JavaScript:");
                  //<< . . WRITE "alert('"_$$^WWWTEXT(32072)_"');"            ; "Please Select A Data Record First."
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('",m$.fnc$("WWWTEXT.main",32072)),"');"));
                  //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
                  //<< . . IF $PIECE(YA,Y,9)'="" WRITE YCR,$$$WWW124ButtonDescription(YA)
                  if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),9),"")) {
                    m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA));
                  }
                  //<< . . WRITE "</A><BR>"
                  m$.Cmd.Write("</A><BR>");
                  break;
                }
              }
            }
          }
          //<< . ;
          //<< . IF YBEARB=2 IF $GET(YSAVEDDATA)'=1 IF blnPicOnButton IF $PIECE(YA,Y,20)=$$$YES DO  QUIT   ; Disable when no KEY
          if (mOp.Equal(m$.var("YBEARB").get(),2)) {
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YSAVEDDATA")),1)) {
              if (mOp.Logical(blnPicOnButton.get())) {
                if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),20),include.COMSYS.$$$YES(m$))) {
                  //<< . . WRITE "<A onClick='return doLink(this)' HREF=""JavaScript:"
                  m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"JavaScript:");
                  //<< . . WRITE "alert('"_$$^WWWTEXT(32770)_"');"            ; "Please Save Changes!"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('",m$.fnc$("WWWTEXT.main",32770)),"');"));
                  //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
                  //<< . . IF $PIECE(YA,Y,9)'="" WRITE YCR,$$$WWW124ButtonDescription(YA)
                  if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),9),"")) {
                    m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA));
                  }
                  //<< . . WRITE "</A><BR>"
                  m$.Cmd.Write("</A><BR>");
                  break;
                }
              }
            }
          }
          //<< . ;
          //<< . ; Check if Button is Disabled                             ; *** EXECUTE ***
          //<< . ;-------------------------------------
          //<< . ;     D9      $$$WWW124PictureFileOnButton()
          //<< . ;     D21     $$$WWW124ImageFileForDisabledButto()
          //<< . ;     D62     $$$WWW124ExecuteToCheckForDisabled()
          //<< . ;-------------------------------------
          //<< . IF $PIECE(YA,Y,62)'="" DO
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),62),"")) {
            do {
              //<< . . NEW EXEC,TEXT
              mVar EXEC = m$.var("EXEC");
              mVar TEXT = m$.var("TEXT");
              m$.newVarBlock(2,EXEC,TEXT);
              //<< . . SET EXEC = $PIECE(YA,Y,62)
              EXEC.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),62));
              //<< . . XECUTE EXEC
              m$.Cmd.Xecute(EXEC.get());
              //<< . . IF (+$GET(Q)=1) || (+$GET(YQ)=1) DO  QUIT
              if ((mOp.Equal(mOp.Positive(m$.Fnc.$get(Q)),1)) || (mOp.Equal(mOp.Positive(m$.Fnc.$get(YQ)),1))) {
                //<< . . . WRITE "<A onClick='return doLink(this)' HREF=""JavaScript:"
                m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"JavaScript:");
                //<< . . . SET TEXT=$$^WWWTEXT(32072)                                    ; "Please Select A Data Record First."
                TEXT.set(m$.fnc$("WWWTEXT.main",32072));
                //<< . . . IF $EXTRACT($GET(Q),2,999)'=""  SET TEXT = $EXTRACT(Q,2,999)
                if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$get(Q),2,999),"")) {
                  TEXT.set(m$.Fnc.$extract(Q.get(),2,999));
                }
                //<< . . . IF $EXTRACT($GET(YQ),2,999)'="" SET TEXT = $EXTRACT(YQ,2,999)
                if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$get(YQ),2,999),"")) {
                  TEXT.set(m$.Fnc.$extract(YQ.get(),2,999));
                }
                //<< . . . WRITE "alert('"_$$$JSText(TEXT)_"');"     //SR14979
                m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('",include.COMSYSString.$$$JSText(m$,TEXT)),"');"));
                //<< . . . WRITE """>"
                m$.Cmd.Write("\">");
                //<< . . . IF $PIECE(YA,Y,21)'="" SET $PIECE(YA,Y,9)=$PIECE(YA,Y,21)  ;NEUER DISABLED BUTTON
                if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),21),"")) {
                  m$.pieceVar(YA,m$.var("Y").get(),9).set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),21));
                }
                //<< . . . IF $PIECE(YA,Y,9)'="" WRITE YCR,$$$WWW124ButtonDescription(YA)
                if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),9),"")) {
                  m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA));
                }
                //<< . . . WRITE "</A>"
                m$.Cmd.Write("</A>");
                //<< . . . WRITE "<BR>"
                m$.Cmd.Write("<BR>");
                break;
              }
            } while (false);
          }
          m$.restoreVarBlock(2);
          //<< . ;
          //<< . IF $GET(Q)=1  QUIT      ;DISABLED
          if (mOp.Equal(m$.Fnc.$get(Q),1)) {
            break;
          }
          //<< . IF $GET(YQ)=1 QUIT
          if (mOp.Equal(m$.Fnc.$get(YQ),1)) {
            break;
          }
          //<< . ;
          //<< . ;NUR WENN BESTÄTIGUNG ;only when affirmation
          //<< . ;-------------------------------------
          //<< . ;     D17     $$$WWW124AcknowledgementTextBefore()
          //<< . ;-------------------------------------
          //<< . SET YCONF0 = ""  ;vor URL ;pre- URL
          mVar YCONF0 = m$.var("YCONF0");
          YCONF0.set("");
          //<< . SET YCONF1 = ""  ;VOR URL ;pre- URL
          mVar YCONF1 = m$.var("YCONF1");
          YCONF1.set("");
          //<< . SET YCONF2 = ""  ;NACH URL ;within URL
          mVar YCONF2 = m$.var("YCONF2");
          YCONF2.set("");
          //<< . SET YCONF3 = ""  ;NACH URL ;within URL
          mVar YCONF3 = m$.var("YCONF3");
          YCONF3.set("");
          //<< . IF $PIECE(YA,Y,17)'="" DO
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),17),"")) {
            //<< . . SET YCONF1="if (confirm('"_$PIECE(YA,Y,17)_"')) {"
            YCONF1.set(mOp.Concat(mOp.Concat("if (confirm('",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),17)),"')) {"));
            //<< . . SET YCONF2="}"  ;ENDE  ;termination
            YCONF2.set("}");
            //<< . . ;
            //<< . . SET YCONF0="JavaScript:if (confirm('"_$PIECE(YA,Y,17)_"')) { window.location='"
            YCONF0.set(mOp.Concat(mOp.Concat("JavaScript:if (confirm('",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),17)),"')) { window.location='"));
            //<< . . SET YCONF3="';}"  ;ENDE
            YCONF3.set("';}");
          }
          //<< . ;
          //<< . ;HREF DURCH MANUELLEN EXECUTE;FIS;01.09.2003              ; *** EXECUTE ***
          //<< . ;-------------------------------------
          //<< . ;     D25     $$$WWW124ExecuteForManualLink()
          //<< . ;-------------------------------------
          //<< . IF $PIECE(YA,Y,25)'="" DO  QUIT
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),25),"")) {
            //<< . . NEW LINK,EXEC
            mVar LINK = m$.var("LINK");
            mVar EXEC = m$.var("EXEC");
            m$.newVarBlock(2,LINK,EXEC);
            //<< . . SET LINK=0
            LINK.set(0);
            //<< . . IF $EXTRACT($PIECE(YA,Y,25),1,2)="$$" SET EXEC = "SET LINK="_$PIECE(YA,Y,25) XECUTE EXEC
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),25),1,2),"$$")) {
              EXEC.set(mOp.Concat("SET LINK=",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),25)));
              m$.Cmd.Xecute(EXEC.get());
            }
            //<< . . IF $EXTRACT($PIECE(YA,Y,25),1)="@"    SET LINK = @$EXTRACT($PIECE(YA,Y,25),2,99)
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),25),1),"@")) {
              LINK.set(m$.indirectVar(m$.Fnc.$extract(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),25),2,99)).get());
            }
            //<< . . ;
            //<< . . IF blnDescOnButton WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick="""
            if (mOp.Logical(blnDescOnButton.get())) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" onClick=\""));
            }
            //<< . . IF blnPicOnButton  WRITE "<A onClick='return doLink(this)' HREF="""
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"");
            }
            //<< . . IF LINK'=0 WRITE LINK
            if (mOp.NotEqual(LINK.get(),0)) {
              m$.Cmd.Write(LINK.get());
            }
            //<< . . IF LINK=0 XECUTE $PIECE(YA,Y,25)
            if (mOp.Equal(LINK.get(),0)) {
              m$.Cmd.Xecute(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),25));
            }
            //<< . . IF YTARGETF'="" WRITE """ TARGET="""_YTARGETF
            if (mOp.NotEqual(YTARGETF.get(),"")) {
              m$.Cmd.Write(mOp.Concat("\" TARGET=\"",YTARGETF.get()));
            }
            //<< . . WRITE """>"
            m$.Cmd.Write("\">");
            //<< . . IF blnPicOnButton WRITE YCR,$$$WWW124ButtonDescription(YA) WRITE "</A>"
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA));
              m$.Cmd.Write("</A>");
            }
            break;
          }
          m$.restoreVarBlock(2);
          //<< . ;
          //<< . ;SUCHFUNKTION ; Search Function
          //<< . ;-------------------------------------
          //<< . ;     D13     $$$WWW124SetVariableYPARA()
          //<< . ;     D53     $$$WWW124SearchFunctionOnClick()
          //<< . ;-------------------------------------
          //<< . IF $PIECE(YA,Y,53)'="" DO  QUIT
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),53),"")) {
            //<< . . IF blnDescOnButton WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick="""
            if (mOp.Logical(blnDescOnButton.get())) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" onClick=\""));
            }
            //<< . . IF blnPicOnButton  WRITE "<A onClick='return doLink(this)' HREF=""JavaScript:"
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"JavaScript:");
            }
            //<< . . IF $PIECE(YA,Y,13)'=""  WRITE "document.WWW.YPARA.value='"_$PIECE(YA,Y,13)_"'; "  ;PARAMETER NEU
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("document.WWW.YPARA.value='",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13)),"'; "));
            }
            //<< . . ;WRITE "document.WWW.YOPEN.value='SAVESEAR'; SAVENOW();"
            //<< . . WRITE " SAVENOW('SAVESEAR');"   //SR13195
            m$.Cmd.Write(" SAVENOW('SAVESEAR');");
            //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
            //<< . . IF blnPicOnButton WRITE YCR,$$$WWW124ButtonDescription(YA),"</A>"
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA),"</A>");
            }
            //<< . . WRITE "<BR>"
            m$.Cmd.Write("<BR>");
            break;
          }
          //<< . ;
          //<< . ;SEITENWECHSEL
          //<< . ;-------------------------------------
          //<< . ;     D13     $$$WWW124SetVariableYPARA()
          //<< . ;     D56     $$$WWW124ChangeoversWithOnClick()
          //<< . ;-------------------------------------
          //<< . IF $PIECE(YA,Y,56)'="" DO  QUIT
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),56),"")) {
            //<< . . IF blnDescOnButton WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick="""
            if (mOp.Logical(blnDescOnButton.get())) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" onClick=\""));
            }
            //<< . . IF blnPicOnButton  WRITE "<A onClick='return doLink(this)' HREF=""JavaScript:"
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"JavaScript:");
            }
            //<< . . IF $PIECE(YA,Y,13)'=""  WRITE "document.WWW.YPARA.value='"_$PIECE(YA,Y,13)_"'; "  ;PARAMETER NEU
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("document.WWW.YPARA.value='",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13)),"'; "));
            }
            //<< . . ;WRITE "document.WWW.YOPEN.value='2'; document.WWW.YINSEITE.value=''; document.WWW.YSEITE.value='"_$PIECE(YA,Y,56)_"'; SAVENOW();"
            //<< . . WRITE " document.WWW.YINSEITE.value=''; document.WWW.YSEITE.value='"_$PIECE(YA,Y,56)_"'; SAVENOW(2);"       //SR13195
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" document.WWW.YINSEITE.value=''; document.WWW.YSEITE.value='",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),56)),"'; SAVENOW(2);"));
            //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
            //<< . . IF blnPicOnButton WRITE YCR,$$$WWW124ButtonDescription(YA),"</A>"
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA),"</A>");
            }
            //<< . . WRITE "<BR>"
            m$.Cmd.Write("<BR>");
            break;
          }
          //<< . ;
          //<< . ;SUBMIT BEI EXECUTE ;EXECUTE contains "SUBMIT"            ; *** EXECUTE ***
          //<< . ;-------------------------------------
          //<< . ;     D6      $$$WWW124ExecuteOnClick()
          //<< . ;     D13     $$$WWW124SetVariableYPARA()
          //<< . ;-------------------------------------
          //<< . IF $TRANSLATE($PIECE(YA,Y,6),"submit","SUBMIT")="SUBMIT" DO  QUIT
          if (mOp.Equal(m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),"submit","SUBMIT"),"SUBMIT")) {
            //<< . . IF blnDescOnButton WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick="""_YCONF1
            if (mOp.Logical(blnDescOnButton.get())) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" onClick=\""),YCONF1.get()));
            }
            //<< . . IF blnPicOnButton  WRITE "<A onClick='return doLink(this)' HREF=""JavaScript:"_YCONF1
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write(mOp.Concat("<A onClick='return doLink(this)' HREF=\"JavaScript:",YCONF1.get()));
            }
            //<< . . IF $PIECE(YA,Y,13)'=""  WRITE "document.WWW.YPARA.value='"_$PIECE(YA,Y,13)_"'; "  ;PARAMETER NEU
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("document.WWW.YPARA.value='",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13)),"'; "));
            }
            //<< . . WRITE "SAVENOW();"
            m$.Cmd.Write("SAVENOW();");
            //<< . . WRITE YCONF2
            m$.Cmd.Write(YCONF2.get());
            //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
            //<< . . IF blnPicOnButton WRITE YCR,$$$WWW124ButtonDescription(YA),"</A>"
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA),"</A>");
            }
            //<< . . WRITE "<BR>"
            m$.Cmd.Write("<BR>");
            break;
          }
          //<< . ;
          //<< . ;FUNCTION BEI ONCLICK ;JavaScript                         ; *** EXECUTE ***
          //<< . ;-------------------------------------
          //<< . ;     D13     $$$WWW124SetVariableYPARA()
          //<< . ;     D14     $$$WWW124FunctionJavaScriptOnClick()
          //<< . ;-------------------------------------
          //<< . IF $PIECE(YA,Y,14)'="" DO  QUIT
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),14),"")) {
            //<< . . IF blnDescOnButton WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick="""_YCONF1
            if (mOp.Logical(blnDescOnButton.get())) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" onClick=\""),YCONF1.get()));
            }
            //<< . . IF blnPicOnButton  WRITE "<A onClick='return doLink(this)' HREF=""JavaScript:"_YCONF1
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write(mOp.Concat("<A onClick='return doLink(this)' HREF=\"JavaScript:",YCONF1.get()));
            }
            //<< . . IF $PIECE(YA,Y,13)'=""  WRITE "document.WWW.YPARA.value='"_$PIECE(YA,Y,13)_"'; "  ;PARAMETER NEU
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("document.WWW.YPARA.value='",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13)),"'; "));
            }
            //<< . . WRITE $PIECE(YA,Y,14)
            m$.Cmd.Write(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),14));
            //<< . . IF '$FIND($PIECE(YA,Y,14),";") WRITE ";"
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),14),";"))) {
              m$.Cmd.Write(";");
            }
            //<< . . WRITE YCONF2
            m$.Cmd.Write(YCONF2.get());
            //<< . . IF YTARGETF'="" WRITE """ TARGET="""_YTARGETF
            if (mOp.NotEqual(YTARGETF.get(),"")) {
              m$.Cmd.Write(mOp.Concat("\" TARGET=\"",YTARGETF.get()));
            }
            //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
            //<< . . IF blnPicOnButton WRITE YCR,$$$WWW124ButtonDescription(YA),"</A>"
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA),"</A>");
            }
            //<< . . WRITE "<BR>"
            m$.Cmd.Write("<BR>");
            break;
          }
          //<< . ;
          //<< . ;HYPER EVENT ONCLICK;TYBD;19,12,2004                      ; *** EXECUTE ***
          //<< . ;-------------------------------------
          //<< . ;     D65     $$$WWW124HyperEventOnClick()
          //<< . ;-------------------------------------
          //<< . IF $PIECE(YA,Y,65)'="" DO
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),65),"")) {
            //<< . . WRITE YCR
            m$.Cmd.Write(m$.var("YCR").get());
            //<< . . IF blnDescOnButton DO
            if (mOp.Logical(blnDescOnButton.get())) {
              //<< . . . WRITE "<INPUT TYPE=""BUTTON"""
              m$.Cmd.Write("<INPUT TYPE=\"BUTTON\"");
              //<< . . . IF $PIECE(YVOR,Y,83)'="" WRITE " class=""button"""
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                m$.Cmd.Write(" class=\"button\"");
              }
              //<< . . . WRITE " VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick="""
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" onClick=\""));
            }
            //<< . . ;
            //<< . . IF blnPicOnButton WRITE "<A class=link onClick="""
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write("<A class=link onClick=\"");
            }
            //<< . . ;WRITE YCONF1
            //<< . . WRITE "retval=EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX','"_$PIECE($PIECE(YA,Y,65),"(",1)_"','"_$PIECE(YA,Y,13)_"','6','"_$PIECE($PIECE($PIECE(YA,Y,65),"(",2),")",1)_"');"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("retval=EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),m$.var("YFORM").get()),"','FIX','"),m$.Fnc.$piece(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),65),"(",1)),"','"),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13)),"','6','"),m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),65),"(",2),")",1)),"');"));
            //<< . . ;WRITE YCONF2
            //<< . . WRITE """>"
            m$.Cmd.Write("\">");
            //<< . . IF blnPicOnButton WRITE YCR,"<IMG SRC="""_YGIF_$PIECE(YA,Y,9)_""" "_YHEIGHT_" "_YWIDTH_" TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" ALIGN=ABSBOTTOM border=0 id="""_$GET(YFORM)_"_"_$GET(YLFN)_"""></A>"
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),9)),"\" "),m$.var("YHEIGHT").get())," "),m$.var("YWIDTH").get())," TITLE=\""),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" ALIGN=ABSBOTTOM border=0 id=\""),m$.Fnc.$get(m$.var("YFORM"))),"_"),m$.Fnc.$get(YLFN)),"\"></A>"));
            }
          }
          //<< . ;
          //<< . ;VERKNÜPFUNG
          //<< . ;-------------------------------------
          //<< . ;     D1      $$$WWW124ButtonDescription()
          //<< . ;     D8      $$$WWW124LinkWithexeOrHttp()
          //<< . ;-------------------------------------
          //<< . IF $PIECE(YA,Y,8)'="" DO  QUIT
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),"")) {
            //<< . . IF blnDescOnButton WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick=""window.location="
            if (mOp.Logical(blnDescOnButton.get())) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" onClick=\"window.location="));
            }
            //<< . . IF blnPicOnButton  WRITE "<A onClick='return doLink(this)' HREF=""" WRITE YCONF0
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"");
              m$.Cmd.Write(YCONF0.get());
            }
            //<< . . IF blnDescOnButton WRITE "'"
            if (mOp.Logical(blnDescOnButton.get())) {
              m$.Cmd.Write("'");
            }
            //<< . . IF '$FIND($PIECE(YA,Y,8),":") WRITE YGIF_$PIECE(YA,Y,8)
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),":"))) {
              m$.Cmd.Write(mOp.Concat(m$.var("YGIF").get(),m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8)));
            }
            //<< . . IF $FIND($PIECE(YA,Y,8),":")  WRITE $PIECE(YA,Y,8)
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8),":"))) {
              m$.Cmd.Write(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),8));
            }
            //<< . . IF blnDescOnButton WRITE "'"
            if (mOp.Logical(blnDescOnButton.get())) {
              m$.Cmd.Write("'");
            }
            //<< . . IF blnPicOnButton  WRITE YCONF3
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write(YCONF3.get());
            }
            //<< . . IF YTARGETF'="" WRITE """ TARGET="""_YTARGETF
            if (mOp.NotEqual(YTARGETF.get(),"")) {
              m$.Cmd.Write(mOp.Concat("\" TARGET=\"",YTARGETF.get()));
            }
            //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
            //<< . . IF blnPicOnButton WRITE YCR,$$$WWW124ButtonDescription(YA),"</A>"
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA),"</A>");
            }
            //<< . . WRITE "<BR>"
            m$.Cmd.Write("<BR>");
            break;
          }
          //<< . ;
          //<< . ;BILDDATEI FÜR BUTTON START FORM ;to take-off shape
          //<< . ;-------------------------------------
          //<< . ;     D9      $$$WWW124PictureFileOnButton()
          //<< . ;-------------------------------------
          //<< . ;IF $PIECE(YA,Y,9)=""  WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick=""window.location="
          //<< . ;IF $PIECE(YA,Y,9)'="" WRITE "<A HREF=""" W YCONF0
          //<< . ;
          //<< . ;
          //<< . ;BUTTON MIT DOWNLOAD ;Download a file when the button is clicked
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
          if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12),"")) {
            //<< . . IF blnDescOnButton WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick=""window.location="
            if (mOp.Logical(blnDescOnButton.get())) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" onClick=\"window.location="));
            }
            //<< . . IF blnPicOnButton  WRITE "<A onClick='return doLink(this)' HREF=""" WRITE YCONF0
            if (mOp.Logical(blnPicOnButton.get())) {
              m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"");
              m$.Cmd.Write(YCONF0.get());
            }
            //<< . . NEW YDATEI
            mVar YDATEI = m$.var("YDATEI");
            m$.newVarBlock(2,YDATEI);
            //<< . . SET YDATEI=$PIECE(YA,Y,12)
            YDATEI.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),12));
            //<< . . IF $FIND(YDATEI,"VORG@") DO   ;BEC;26614;22.11.04
            if (mOp.Logical(m$.Fnc.$find(YDATEI.get(),"VORG@"))) {
              //<< . . . NEW FIELD
              mVar FIELD = m$.var("FIELD");
              m$.newVarBlock(3,FIELD);
              //<< . . . SET FIELD  = $PIECE(YDATEI,"VORG@",2)
              FIELD.set(m$.Fnc.$piece(YDATEI.get(),"VORG@",2));
              //<< . . . SET FIELD  = $PIECE(FIELD,"@",1)
              FIELD.set(m$.Fnc.$piece(FIELD.get(),"@",1));
              //<< . . . SET YDATEI = $PIECE(YDATEI,"VORG@"_FIELD_"@/",1)_$PIECE($GET(^INVORG(YM,YM,1)),Y,FIELD)_"/"_$PIECE(YDATEI,"VORG@"_FIELD_"@/",2)    ;BEC;26614;22.11.04
              YDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YDATEI.get(),mOp.Concat(mOp.Concat("VORG@",FIELD.get()),"@/"),1),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)),m$.var("Y").get(),FIELD.get())),"/"),m$.Fnc.$piece(YDATEI.get(),mOp.Concat(mOp.Concat("VORG@",FIELD.get()),"@/"),2)));
            }
            m$.restoreVarBlock(3);
            //<< . . ;
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
                //<< . . . IF $FIND(FILE,"YM/")                SET FILE=$PIECE(FILE,"YM/",1)_YM_"/"_$PIECE(FILE,"YM/",2)
                if (mOp.Logical(m$.Fnc.$find(FILE.get(),"YM/"))) {
                  FILE.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(FILE.get(),"YM/",1),m$.var("YM").get()),"/"),m$.Fnc.$piece(FILE.get(),"YM/",2)));
                }
                //<< . . . IF $EXTRACT(FILE,$LENGTH(FILE))="\" SET FILE=$EXTRACT(FILE,1,$LENGTH(FILE)-1)
                if (mOp.Equal(m$.Fnc.$extract(FILE.get(),m$.Fnc.$length(FILE.get())),"\\")) {
                  FILE.set(m$.Fnc.$extract(FILE.get(),1,mOp.Subtract(m$.Fnc.$length(FILE.get()),1)));
                }
                //<< . . . IF $EXTRACT(YDATEI)'="\" SET YDATEI="\"_YDATEI
                if (mOp.NotEqual(m$.Fnc.$extract(YDATEI.get()),"\\")) {
                  YDATEI.set(mOp.Concat("\\",YDATEI.get()));
                }
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
              //<< . . . SET FILE = $TRANSLATE($PIECE($GET(^WWW012(0,YM,1)),Y,46),"\","/")
              FILE.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),46),"\\","/"));
              //<< . . . IF $FIND(FILE,"YM/")                SET FILE   = $PIECE(FILE,"YM/",1)_YM_"/"_$PIECE(FILE,"YM/",2)
              if (mOp.Logical(m$.Fnc.$find(FILE.get(),"YM/"))) {
                FILE.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(FILE.get(),"YM/",1),m$.var("YM").get()),"/"),m$.Fnc.$piece(FILE.get(),"YM/",2)));
              }
              //<< . . . IF $EXTRACT(FILE,$LENGTH(FILE))="/" SET FILE   = $EXTRACT(FILE,1,$LENGTH(FILE)-1)
              if (mOp.Equal(m$.Fnc.$extract(FILE.get(),m$.Fnc.$length(FILE.get())),"/")) {
                FILE.set(m$.Fnc.$extract(FILE.get(),1,mOp.Subtract(m$.Fnc.$length(FILE.get()),1)));
              }
              //<< . . . IF $EXTRACT(YDATEI)="/"             SET YDATEI = $EXTRACT(YDATEI,2,9999)  ;TYBD / HERAUSNEHMEN
              if (mOp.Equal(m$.Fnc.$extract(YDATEI.get()),"/")) {
                YDATEI.set(m$.Fnc.$extract(YDATEI.get(),2,9999));
              }
              //<< . . . WRITE "ftp://"_FILE_"/"_YDATEI
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("ftp://",FILE.get()),"/"),YDATEI.get()));
              //<< . . . IF blnPicOnButton WRITE YCONF3
              if (mOp.Logical(blnPicOnButton.get())) {
                m$.Cmd.Write(YCONF3.get());
              }
              //<< . . . WRITE """"
              m$.Cmd.Write("\"");
            } while(false);
            m$.restoreVarBlock(3);
            //<< . . ;
            //<< . . IF YTARGETF'="" WRITE " TARGET="""_YTARGETF_""""
            if (mOp.NotEqual(YTARGETF.get(),"")) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" TARGET=\"",YTARGETF.get()),"\""));
            }
            //<< . . WRITE " TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
            //<< . . WRITE YCR,$$$WWW124ButtonDescription(YA),"</A>"
            m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA),"</A>");
            //<< . . WRITE "<BR>"
            m$.Cmd.Write("<BR>");
            break;
          }
          m$.restoreVarBlock(2);
          //<< . ;
          //<< . ;OHNE HTMLAUFBEREITUNG ;Don't Prepare HTML
          //<< . ;-------------------------------------
          //<< . ;     D1      $$$WWW124ButtonDescription()
          //<< . ;     D5      $$$WWW124DoNotPrepareHTML()
          //<< . ;     D6      $$$WWW124ExecuteOnClick()
          //<< . ;     D11     $$$WWW124TransferVariableIdentifie()
          //<< . ;     D13     $$$WWW124SetVariableYPARA()
          //<< . ;     D15     $$$WWW124DMSFileForTargetHttp()
          //<< . ;     D19     $$$WWW124TargetFrameName()
          //<< . ;-------------------------------------
          //<< . IF +$PIECE(YA,Y,5)=$$$NO IF $PIECE(YA,Y,6)'="" DO  QUIT
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),5)),include.COMSYS.$$$NO(m$))) {
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),"")) {
              //<< . . IF blnDescOnButton WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick=""window.location="
              if (mOp.Logical(blnDescOnButton.get())) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" onClick=\"window.location="));
              }
              //<< . . IF blnPicOnButton  WRITE "<A onClick='return doLink(this)' HREF=""" WRITE YCONF0
              if (mOp.Logical(blnPicOnButton.get())) {
                m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"");
                m$.Cmd.Write(YCONF0.get());
              }
              //<< . . IF $PIECE(YA,Y,13)'="" NEW YPARA SET YPARA=$PIECE(YA,Y,13)  ;PARAMETER NEU ;parameter recent
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),"")) {
                mVar YPARA = m$.var("YPARA");
                m$.newVarBlock(2,YPARA);
                YPARA.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13));
              }
              //<< . . IF blnDescOnButton WRITE "'"
              if (mOp.Logical(blnDescOnButton.get())) {
                m$.Cmd.Write("'");
              }
              //<< . . WRITE YAKTION_""
              m$.Cmd.Write(mOp.Concat(m$.var("YAKTION").get(),""));
              //<< . . WRITE "EP=WWWMANU&amp;YFORM="_YFORM
              m$.Cmd.Write(mOp.Concat("EP=WWWMANU&amp;YFORM=",m$.var("YFORM").get()));
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
              //<< . . IF $EXTRACT($PIECE(YA,Y,19))="@" NEW YBACK SET YBACK=""   ;TYBD;OHNE YBACK ;without
              if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"@")) {
                m$.newVarBlock(2,YBACK);
                YBACK.set("");
              }
              //<< . . IF $EXTRACT($PIECE(YA,Y,6))="""" DO                  ;EXECUTE VOR EXECUTE
              if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6)),"\"")) {
                //<< . . . NEW YEXE
                mVar YEXE = m$.var("YEXE");
                m$.newVarBlock(3,YEXE);
                //<< . . . SET YEXE = $PIECE(YA,Y,6)
                YEXE.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6));
                //<< . . . SET YEXE = "S $P(YA,Y,6)="_YEXE
                YEXE.set(mOp.Concat("S $P(YA,Y,6)=",YEXE.get()));
                //<< . . . XECUTE YEXE
                m$.Cmd.Xecute(YEXE.get());
              }
              m$.restoreVarBlock(3);
              //<< . . ;
              //<< . . WRITE "&YEXEC="_$TRANSLATE($PIECE(YA,Y,6),"# ""","*|'")
              m$.Cmd.Write(mOp.Concat("&YEXEC=",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),"# \"","*|'")));
              //<< . . IF $PIECE(YA,Y,11)'="" WRITE "&"_$PIECE(YA,Y,11)_"="_@($PIECE(YA,Y,11))
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),11),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),11)),"="),m$.indirectVar((m$.Fnc.$piece(YA.get(),m$.var("Y").get(),11))).get()));
              }
              //<< . . DO ^WWWCGI
              m$.Cmd.Do("WWWCGI.main");
              //<< . . SET YBACK=YBACKX
              YBACK.set(YBACKX.get());
              //<< . . IF blnDescOnButton WRITE "'"
              if (mOp.Logical(blnDescOnButton.get())) {
                m$.Cmd.Write("'");
              }
              //<< . . IF blnPicOnButton  WRITE YCONF3
              if (mOp.Logical(blnPicOnButton.get())) {
                m$.Cmd.Write(YCONF3.get());
              }
              //<< . . IF YTARGETF'="" WRITE """ TARGET="""_YTARGETF
              if (mOp.NotEqual(YTARGETF.get(),"")) {
                m$.Cmd.Write(mOp.Concat("\" TARGET=\"",YTARGETF.get()));
              }
              //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
              m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
              //<< . . IF blnPicOnButton WRITE YCR,$$$WWW124ButtonDescription(YA)
              if (mOp.Logical(blnPicOnButton.get())) {
                m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA));
              }
              //<< . . WRITE "<BR>"
              m$.Cmd.Write("<BR>");
              //<< . . IF $PIECE(YA,Y,15)'="" DO ABLAGE
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),15),"")) {
                m$.Cmd.Do("ABLAGE");
              }
              break;
            }
            m$.restoreVarBlock(2);
          }
          //<< . ;
          //<< . ;MIT HTML AUFBEREITUNG ;Prepare HTML
          //<< . ;-------------------------------------
          //<< . IF +$PIECE(YA,Y,5)=$$$YES IF $PIECE(YA,Y,6)'="" DO  QUIT      ; $$$WWW124DMSFileForTargetHttp()  $$$WWW124ExecuteOnClick()
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),5)),include.COMSYS.$$$YES(m$))) {
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),"")) {
              //<< . . IF blnDescOnButton WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick=""window.location="
              if (mOp.Logical(blnDescOnButton.get())) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" onClick=\"window.location="));
              }
              //<< . . IF blnPicOnButton  WRITE "<A onClick='return doLink(this)' HREF=""" WRITE YCONF0
              if (mOp.Logical(blnPicOnButton.get())) {
                m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"");
                m$.Cmd.Write(YCONF0.get());
              }
              //<< . . IF $PIECE(YA,Y,13)'="" NEW YPARA SET YPARA=$PIECE(YA,Y,13)  ;PARAMETER NEU ;parameter recent
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),"")) {
                mVar YPARA = m$.var("YPARA");
                m$.newVarBlock(2,YPARA);
                YPARA.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13));
              }
              //<< . . IF blnDescOnButton WRITE "'"
              if (mOp.Logical(blnDescOnButton.get())) {
                m$.Cmd.Write("'");
              }
              //<< . . WRITE YAKTION_""
              m$.Cmd.Write(mOp.Concat(m$.var("YAKTION").get(),""));
              //<< . . WRITE "EP=WWWMANU1&amp;YFORM="_YFORM
              m$.Cmd.Write(mOp.Concat("EP=WWWMANU1&amp;YFORM=",m$.var("YFORM").get()));
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
              //<< . . IF $EXTRACT($PIECE(YA,Y,19))="@" NEW YBACK SET YBACK=""   ;TYBD;OHNE YBACK ;without
              if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"@")) {
                m$.newVarBlock(2,YBACK);
                YBACK.set("");
              }
              //<< . . IF $EXTRACT($PIECE(YA,Y,6))="""" DO   ;EXECUTE VOR EXECUTE ;EXECUTE pre- EXECUTE
              if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6)),"\"")) {
                //<< . . . NEW YEXE
                mVar YEXE = m$.var("YEXE");
                m$.newVarBlock(3,YEXE);
                //<< . . . SET YEXE = $PIECE(YA,Y,6)
                YEXE.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6));
                //<< . . . SET YEXE = "S $P(YA,Y,6)="_YEXE
                YEXE.set(mOp.Concat("S $P(YA,Y,6)=",YEXE.get()));
                //<< . . . XECUTE YEXE
                m$.Cmd.Xecute(YEXE.get());
              }
              m$.restoreVarBlock(3);
              //<< . . ;
              //<< . . WRITE "&YEXEC="_$TRANSLATE($PIECE(YA,Y,6),"# ""","*|'")
              m$.Cmd.Write(mOp.Concat("&YEXEC=",m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),"# \"","*|'")));
              //<< . . IF $PIECE(YA,Y,11)'="" WRITE "&"_$PIECE(YA,Y,11)_"="_@($PIECE(YA,Y,11))
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),11),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),11)),"="),m$.indirectVar((m$.Fnc.$piece(YA.get(),m$.var("Y").get(),11))).get()));
              }
              //<< . . DO ^WWWCGI
              m$.Cmd.Do("WWWCGI.main");
              //<< . . SET YBACK=YBACKX
              YBACK.set(YBACKX.get());
              //<< . . IF blnDescOnButton WRITE "'"
              if (mOp.Logical(blnDescOnButton.get())) {
                m$.Cmd.Write("'");
              }
              //<< . . IF blnPicOnButton  WRITE YCONF3
              if (mOp.Logical(blnPicOnButton.get())) {
                m$.Cmd.Write(YCONF3.get());
              }
              //<< . . IF YTARGETF'="" WRITE """ TARGET="""_YTARGETF
              if (mOp.NotEqual(YTARGETF.get(),"")) {
                m$.Cmd.Write(mOp.Concat("\" TARGET=\"",YTARGETF.get()));
              }
              //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
              m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
              //<< . . IF blnPicOnButton WRITE YCR,$$$WWW124ButtonDescription(YA),"</A>"
              if (mOp.Logical(blnPicOnButton.get())) {
                m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA),"</A>");
              }
              //<< . . WRITE "<BR>"
              m$.Cmd.Write("<BR>");
              //<< . . IF $PIECE(YA,Y,15)'="" DO ABLAGE
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),15),"")) {
                m$.Cmd.Do("ABLAGE");
              }
              break;
            }
            m$.restoreVarBlock(2);
          }
          //<< . ;
          //<< . ;EXECUTE ODER FORMULAR AUFRUF ;EXECUTE Or form
          //<< . ;-------------------------------------
          //<< . ;     D6      $$$WWW124ExecuteOnClick()
          //<< . ;     D7      $$$WWW124NewFormOnClick()
          //<< . ;     D13     $$$WWW124SetVariableYPARA()
          //<< . ;     D15     $$$WWW124DMSFileForTargetHttp()
          //<< . ;     D19     $$$WWW124TargetFrameName()
          //<< . ;     D54     $$$WWW124DataItemMapToNewFormNnnn()
          //<< . ;     D55     $$$WWW124DisplayFirstDataRecord()
          //<< . ;-------------------------------------
          //<< . IF $PIECE(YA,Y,6)="" IF $PIECE(YA,Y,7)'="" DO  QUIT
          if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),6),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"")) {
              //<< . . ;
              //<< . . IF blnDescOnButton WRITE "<INPUT TYPE=""BUTTON"" VALUE="""_YAM_$$^WWWUML($$$WWW124ButtonDescription(YA))_""" onClick=""window.location="
              if (mOp.Logical(blnDescOnButton.get())) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"BUTTON\" VALUE=\"",m$.var("YAM").get()),m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\" onClick=\"window.location="));
              }
              //<< . . IF blnPicOnButton  WRITE "<A onClick='return doLink(this)' HREF=""" WRITE YCONF0
              if (mOp.Logical(blnPicOnButton.get())) {
                m$.Cmd.Write("<A onClick='return doLink(this)' HREF=\"");
                m$.Cmd.Write(YCONF0.get());
              }
              //<< . . IF $PIECE(YA,Y,13)'="" NEW YPARA SET YPARA=$PIECE(YA,Y,13)  ;PARAMETER NEU ;parameter recent
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13),"")) {
                mVar YPARA = m$.var("YPARA");
                m$.newVarBlock(2,YPARA);
                YPARA.set(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),13));
              }
              //<< . . IF blnDescOnButton WRITE "'"
              if (mOp.Logical(blnDescOnButton.get())) {
                m$.Cmd.Write("'");
              }
              //<< . . WRITE YAKTION_""
              m$.Cmd.Write(mOp.Concat(m$.var("YAKTION").get(),""));
              //<< . . SET YKEYXX=YKEY
              YKEYXX.set(m$.var("YKEY").get());
              //<< . . NEW MAPPING,YKEY,YNOKEY
              mVar MAPPING = m$.var("MAPPING");
              mVar YKEY = m$.var("YKEY");
              mVar YNOKEY = m$.var("YNOKEY");
              m$.newVarBlock(2,MAPPING,YKEY,YNOKEY);
              //<< . . SET MAPPING=""   ;FELDMAPPING XXX=FELD
              MAPPING.set("");
              //<< . . IF $PIECE(YA,Y,54)'="" DO
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),54),"")) {
                //<< . . . NEW I,MAP
                mVar MAP = m$.var("MAP");
                m$.newVarBlock(3,I,MAP);
                //<< . . . SET YNOKEY=YFORM  ;BEI RÜCKSPRUNG KEINE ÜBERGABE DES KEY´S ;next to no
                YNOKEY.set(m$.var("YFORM").get());
                //<< . . . SET MAPPING=$TRANSLATE($PIECE(YA,Y,54),",",";")
                MAPPING.set(m$.Fnc.$translate(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),54),",",";"));
                //<< . . . SET YKEY=YKEYXX   ;VORGABE NORMAL ;default normal
                YKEY.set(YKEYXX.get());
                //<< . . . FOR I=1:1 QUIT:$PIECE(MAPPING,";",I)=""  SET MAP=$PIECE(MAPPING,";",I) DO
                for (I.set(1);(true);I.set(mOp.Add(I.get(),1))) {
                  if (mOp.Equal(m$.Fnc.$piece(MAPPING.get(),";",I.get()),"")) {
                    break;
                  }
                  MAP.set(m$.Fnc.$piece(MAPPING.get(),";",I.get()));
                  do {
                    //<< . . . . IF $PIECE(MAP,"=",1)=0   SET $PIECE(YKEY,",",+$PIECE(MAP,"=",2))="",$PIECE(YFKEY,",",+$PIECE(MAP,"=",2))=""    QUIT  ; no default
                    if (mOp.Equal(m$.Fnc.$piece(MAP.get(),"=",1),0)) {
                      m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set("");
                      m$.pieceVar(m$.var("YFKEY"),",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set("");
                      break;
                    }
                    //<< . . . . IF $PIECE(MAP,"=",1)=999 SET $PIECE(YKEY,",",+$PIECE(MAP,"=",2))="",$PIECE(YFKEY,",",+$PIECE(MAP,"=",2))=""    QUIT  ; no default
                    if (mOp.Equal(m$.Fnc.$piece(MAP.get(),"=",1),999)) {
                      m$.pieceVar(YKEY,",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set("");
                      m$.pieceVar(m$.var("YFKEY"),",",mOp.Positive(m$.Fnc.$piece(MAP.get(),"=",2))).set("");
                      break;
                    }
                    //<< . . . . IF $EXTRACT($PIECE(MAP,"=",1))="""" SET $PIECE(YKEY,",",+$PIECE(MAP,"=",2))=$TRANSLATE($PIECE(MAP,"=",1),"""") QUIT
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
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),"")) {
                do {
                  //<< . . . NEW YDATEI,YFELD,YSCHLUES,YI
                  mVar YDATEI = m$.var("YDATEI");
                  mVar YFELD = m$.var("YFELD");
                  mVar YSCHLUES = m$.var("YSCHLUES");
                  m$.newVarBlock(3,YDATEI,YFELD,YSCHLUES,YI);
                  //<< . . . SET YDATEI=$PIECE($GET(^WWW120(0,$PIECE(YA,Y,7),1)),Y,11)
                  YDATEI.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7),1)),m$.var("Y").get(),11));
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
                    //<< . . . . SET $$$WWW124ButtonDescription(YA) = "* "_$$$WWW124ButtonDescription(YA)  ;DATEN VORHANDEN ;on hand
                    include.WWWConst.$$$WWW124ButtonDescriptionSet(m$,YA,mOp.Concat("* ",include.WWWConst.$$$WWW124ButtonDescription(m$,YA)));
                    //<< . . . . ;
                    //<< . . . . IF $PIECE(YA,Y,55)=$$$YES DO    ;ERSTEN DATENSATZ AUSWÄHLEN ;data record pick out
                    if (mOp.Equal(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),55),include.COMSYS.$$$YES(m$))) {
                      //<< . . . . . ;
                      //<< . . . . . SET YNEXKEY = $PIECE($PIECE($QUERY(@YSCHLUES),"(",2),")",1)
                      mVar YNEXKEY = m$.var("YNEXKEY");
                      YNEXKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$query(m$.indirectVar(YSCHLUES.get())),"(",2),")",1));
                      //<< . . . . . SET YNEXKEY = $PIECE(YNEXKEY,",",2,$LENGTH(YNEXKEY,",")-1)
                      YNEXKEY.set(m$.Fnc.$piece(YNEXKEY.get(),",",2,mOp.Subtract(m$.Fnc.$length(YNEXKEY.get(),","),1)));
                      //<< . . . . . IF '$FIND("-"_$TRANSLATE(YNEXKEY,""""),"-"_$TRANSLATE(YKEYXX,"""")) SET YNEXKEY = ""
                      if (mOp.Not(m$.Fnc.$find(mOp.Concat("-",m$.Fnc.$translate(YNEXKEY.get(),"\"")),mOp.Concat("-",m$.Fnc.$translate(YKEYXX.get(),"\""))))) {
                        YNEXKEY.set("");
                      }
                      //<< . . . . . IF YNEXKEY'="" SET YKEY = YNEXKEY
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
              //<< . . WRITE "EP=WWWFORM&amp;YFORM="_$PIECE(YA,Y,7)
              m$.Cmd.Write(mOp.Concat("EP=WWWFORM&amp;YFORM=",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),7)));
              //<< . . SET YBACKX = YBACK
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
              //<< . . IF $EXTRACT($PIECE(YA,Y,19))="@" NEW YBACK SET YBACK=""   ;TYBD;OHNE YBACK ;without
              if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),19)),"@")) {
                mVar YBACK = m$.var("YBACK");
                m$.newVarBlock(2,YBACK);
                YBACK.set("");
              }
              //<< . . IF $PIECE(YA,Y,11)'="" WRITE "&"_$PIECE(YA,Y,11)_"="_$GET(@($PIECE(YA,Y,11)))
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),11),"")) {
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&",m$.Fnc.$piece(YA.get(),m$.var("Y").get(),11)),"="),m$.Fnc.$get(m$.indirectVar((m$.Fnc.$piece(YA.get(),m$.var("Y").get(),11))))));
              }
              //<< . . DO ^WWWCGI
              m$.Cmd.Do("WWWCGI.main");
              //<< . . SET YBACK=YBACKX
              mVar YBACK = m$.var("YBACK");
              YBACK.set(YBACKX.get());
              //<< . . IF blnDescOnButton WRITE "'"
              if (mOp.Logical(blnDescOnButton.get())) {
                m$.Cmd.Write("'");
              }
              //<< . . IF blnPicOnButton  WRITE YCONF3
              if (mOp.Logical(blnPicOnButton.get())) {
                m$.Cmd.Write(YCONF3.get());
              }
              //<< . . IF YTARGETF'=""    WRITE """ TARGET="""_YTARGETF
              if (mOp.NotEqual(YTARGETF.get(),"")) {
                m$.Cmd.Write(mOp.Concat("\" TARGET=\"",YTARGETF.get()));
              }
              //<< . . WRITE """ TITLE="""_$$^WWWUML($$$WWW124ButtonDescription(YA))_""">"
              m$.Cmd.Write(mOp.Concat(mOp.Concat("\" TITLE=\"",m$.fnc$("WWWUML.main",include.WWWConst.$$$WWW124ButtonDescription(m$,YA))),"\">"));
              //<< . . IF blnPicOnButton  WRITE YCR,$$$WWW124ButtonDescription(YA),"</A>"
              if (mOp.Logical(blnPicOnButton.get())) {
                m$.Cmd.Write(m$.var("YCR").get(),include.WWWConst.$$$WWW124ButtonDescription(m$,YA),"</A>");
              }
              //<< . . WRITE "<BR>"
              m$.Cmd.Write("<BR>");
              //<< . . IF $PIECE(YA,Y,15)'="" DO ABLAGE
              if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),m$.var("Y").get(),15),"")) {
                m$.Cmd.Do("ABLAGE");
              }
              break;
            }
            m$.restoreVarBlock(2);
          }
        } while (false);
      }
      m$.restoreVarBlock(1);
    }
    do {
      //<< 
      //<< DO
      //<< . ;W "</B>"
      //<< . WRITE "</NOBR>"
      m$.Cmd.Write("</NOBR>");
      //<< . WRITE "</TD></TR>"
      m$.Cmd.Write("</TD></TR>");
      //<< . WRITE "</TABLE>"
      m$.Cmd.Write("</TABLE>");
      //<< . WRITE YCR
      m$.Cmd.Write(m$.var("YCR").get());
    } while(false);
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
      m$.newVarBlock(1,YPRINT);
      //<< . DO ^WWWSCRB1  ;SCREEN DFLT BUTTON
      m$.Cmd.Do("WWWSCRB1.main");
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< ABLAGE ;SPEICHERN URL IN ZWISCHENDATEI ;Save URL within
  public Object ABLAGE() {
    //<< ;   Called if D15'=""
    //<< ;   D15     $$$WWW124DMSFileForTargetHttp()
    //<< QUIT
    return null;
  }

//<< 
//<< /*vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
//<< QUIT:$TRANSLATE(YKEY,",*+-. """)=""
//<< NEW YI,YURL,I
//<< SET YURL=$PIECE($GET(^WWW012(0,YM,1)),Y,44)
//<< SET YI=YAKTION
//<< 
//<< IF +$PIECE(YA,Y,5)=0 IF $PIECE(YA,Y,6)'="" DO
//<< . SET YI=YI_"EP=WWWMANU&amp;YFORM="_YFORM
//<< 
//<< IF +$PIECE(YA,Y,5)=1 IF $PIECE(YA,Y,6)'="" DO
//<< . SET YI=YI_"EP=WWWMANU1&amp;YFORM="_YFORM
//<< 
//<< IF $PIECE(YA,Y,6)="" IF $PIECE(YA,Y,7)'="" DO
//<< . SET YI=YI_"EP=WWWFORM&amp;YFORM="_$PIECE(YA,Y,7)
//<< 
//<< SET YBACKX=YBACK
//<< ;SR13009
//<< ;new strYBACK
//<< ;set strYBACK = YBACK
//<< ;if $reverse($piece($reverse(YBACK),",",2))'=YFORM set strYBACK = strYBACK_YFORM_","
//<< ;set YBACK = strYBACK
//<< ;SR13009
//<< SET YBACK=YBACK_YFORM_","
//<< SET YI=YI_"&YEXEC="_$TRANSLATE($PIECE(YA,Y,6),"# ","*|")
//<< IF $PIECE(YA,Y,11)'="" SET YI=YI_"&"_$PIECE(YA,Y,11)_"="_@($PIECE(YA,Y,11))
//<< DO VAR^WWWCGI
//<< SET YBACK=YBACKX
//<< SET YI(1)=$PIECE(YA,Y,16)
//<< IF $EXTRACT(YI(1))="/" SET YI(1)=$EXTRACT(YI(1),2,99)
//<< IF $EXTRACT(YI(1),$LENGTH(YI(1)))'="/" SET YI(1)=YI(1)_"/"
//<< SET YI(1)=YI(1)_$TRANSLATE(YKEY,",""","/")
//<< IF $EXTRACT(YI(1))="/" SET YI(1)=$EXTRACT(YI(1),2,999)
//<< IF $EXTRACT(YI(1),$LENGTH(YI(1)))'="/" SET YI(1)=YI(1)_"/"
//<< SET YI(3)=YI(1)
//<< SET YI(1)=""
//<< FOR I=1:1 QUIT:$PIECE(YI(3),"/",I)=""  SET YI(1)=$PIECE(YI(3),"/",I) DO
//<< . IF $EXTRACT(YI(1))="@" DO
//<< . . IF +$EXTRACT(YI(1),2,99)'=0 SET YI(1)=$PIECE(YFELD,Y,+$EXTRACT(YI(1),2,99)) QUIT
//<< . . SET YI(1)=$GET(@($EXTRACT($PIECE(YI(3),"/",I),2,99)))
//<< . ;
//<< . IF YI(1)="" SET YI(1)="*"
//<< . SET $PIECE(YI(3),"/",I)=YI(1)
//<< 
//<< ;DATEI SPEICHERN ;data file Save
//<< NEW II
//<< ;NUR FÜR DEN FALL VON WILDEN GLOBALS!;F I=1:1 Q:$P(YI(3),"/",I)=""  S YI(1)=$P(YI(3),"/",1,I)_"/" D
//<< . SET YI(2)="^"_$PIECE(YA,Y,15)_"("_$$^WWWYM($PIECE(YA,Y,15))
//<< . FOR II=1:1 QUIT:$PIECE(YI(1),"/",II)=""  SET YI(2)=YI(2)_","""_$PIECE(YI(1),"/",II)_""""
//<< . SET YI(2)=YI(2)_",1)"
//<< . SET @YI(2)=""
//<< 
//<< SET YI(1)=YI(3)
//<< SET YI(2)="^"_$PIECE(YA,Y,15)_"("_$$^WWWYM($PIECE(YA,Y,15))
//<< FOR II=1:1 QUIT:$PIECE(YI(1),"/",II)=""  SET YI(2)=YI(2)_","""_$PIECE(YI(1),"/",II)_""""
//<< SET YI(2)=YI(2)_",1)"
//<< SET @YI(2)=YI_Y_+$HOROLOG
//<< QUIT
//<< ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END */
//<< 
}
