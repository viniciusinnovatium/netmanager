//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM91
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:41
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

//<< WWWFORM91       ;WWWFORM91;DT;MULTI SCHLUESSELVORGABE;26.08.2000
public class WWWFORM91 extends mClass {

  public void main() {
    _WWWFORM91();
  }

  public void _WWWFORM91() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       MULTI SCHLUESSELVORGABE
    //<< ;   "Internal Message Display" Form Button - dropdown with "Open" and MRU list
    //<< ;
    //<< ;   Called by WWWFORMF
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;   YFORART     Form Type
    //<< ;   YVOR        WWW120-D88      No of items in MRU List
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 17-Oct-2011   GRF     -:  field macros
    //<< ; 23-Aug-2011   shobby  SR17861: Fixed the height of the input box so that it
    //<< ;                           doesn't appear too small using FF and Windows 7.
    //<< ; 22-Dec-2005   JW      SR13195: Edited SAVENOW call.
    //<< ; 11-Oct-2005   GRF     Doco (SR13195 research); eliminate long space strings
    //<< ; 07-Jul-2005   shobby  SR12892: WWW1262 is no longer shared.
    //<< ; 19-Mar-2003   PK      alteration
    //<< ; 26-Aug-2000   DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YI,YA,YK,YLSTKEY
    mVar YI = m$.var("YI");
    mVar YA = m$.var("YA");
    mVar YK = m$.var("YK");
    mVar YLSTKEY = m$.var("YLSTKEY");
    m$.newVar(YI,YA,YK,YLSTKEY);
    //<< 
    //<< set YLSTKEY=""
    YLSTKEY.set("");
    //<< quit:$get(YFOART)'=1   ;NUR STANDARD FORMULARE ;only
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFOART")),1)) {
      return;
    }
    //<< 
    //<< write YCR,"<select NAME=""YOPEN1"""
    m$.Cmd.Write(m$.var("YCR").get(),"<select NAME=\"YOPEN1\"");
    //<< write " size=1 onChange=""javascript:SAVENOW(document.WWW.YOPEN1.options[document.WWW.YOPEN1.selectedIndex].value);"""
    m$.Cmd.Write(" size=1 onChange=\"javascript:SAVENOW(document.WWW.YOPEN1.options[document.WWW.YOPEN1.selectedIndex].value);\"");
    //<< 
    //<< ;SR17861 WRITE " style=""padding-top:0 ;padding-bottom:0; """   ;style
    //<< write " style=""padding-top:0px ;padding-bottom:0px; height:20px; """   ;style ;SR17861
    m$.Cmd.Write(" style=\"padding-top:0px ;padding-bottom:0px; height:20px; \"");
    //<< ;WRITE " style="""
    //<< ;WRITE "font-face: 'Courier New'"
    //<< ;WRITE "; font-family: 'Courier New'"
    //<< ;WRITE """"
    //<< write ">"
    m$.Cmd.Write(">");
    //<< 
    //<< ;"Open"   ;ÖFFNEN
    //<< ;---------------------------------------
    //<< write YCR,"<option value=""1"">"_$$^WWWNBSP($extract($$^WWWTEXT(101)_$justify("",34),1,34))_"</option>"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<option value=\"1\">",m$.fnc$("WWWNBSP.main",m$.Fnc.$extract(mOp.Concat(m$.fnc$("WWWTEXT.main",101),m$.Fnc.$justify("",34)),1,34))),"</option>"));
    //<< ; FIXME : Why is this 34 chars wide when MRU list is 14? <GRF>  Can we be wider?
    //<< ;         NOTE : Reversal of MRU entries before truncation to 14 characters leads to weird appearance
    //<< 
    //<< ; MRU List
    //<< ;---------------------------------------
    //<< set YSORT=""
    mVar YSORT = m$.var("YSORT");
    YSORT.set("");
    //<< for YI=1:1 set YSORT=$order(^WWW1262(0,YFORM,YBED,YSORT),-1) quit:YSORT=""  do
    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
      YSORT.set(m$.Fnc.$order(m$.var("^WWW1262",0,m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get()),mOp.Negative(1)));
      if (mOp.Equal(YSORT.get(),"")) {
        break;
      }
      do {
        //<< . if YI>$$$WWW120NumberofMRURecordListItem(YVOR) kill ^WWW1262(0,YFORM,YBED,YSORT) quit  ;ZU VIELE  ;within much  D88
        if (mOp.Greater(YI.get(),include.WWWConst.$$$WWW120NumberofMRURecordListItem(m$,m$.var("YVOR")))) {
          m$.var("^WWW1262",0,m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get()).kill();
          break;
        }
        //<< . if '$$Exists(YFORM,YBED,YSORT,YDATEI)          kill ^WWW1262(0,YFORM,YBED,YSORT) quit             ;sun shobby
        if (mOp.Not(m$.fnc$("Exists",m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get(),m$.var("YDATEI").get()))) {
          m$.var("^WWW1262",0,m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get()).kill();
          break;
        }
        //<< . set YA=""
        YA.set("");
        //<< . set YK=""
        YK.set("");
        //<< . for  set YK=$order(^WWW1262(0,YFORM,YBED,YSORT,YK)) quit:YK=""  do       ;SUCHEN DER KEY'S ;seek the
        for (;true;) {
          YK.set(m$.Fnc.$order(m$.var("^WWW1262",0,m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get(),YK.get())));
          if (mOp.Equal(YK.get(),"")) {
            break;
          }
          do {
            //<< . . set YA=YA_", "_$extract($get(^WWW1262(0,YFORM,YBED,YSORT,YK,1)),1,30)  ;DATENSATZ ;data record
            YA.set(mOp.Concat(mOp.Concat(YA.get(),", "),m$.Fnc.$extract(m$.Fnc.$get(m$.var("^WWW1262",0,m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get(),YK.get(),1)),1,30)));
            //<< . . quit
            break;
          } while (false);
        }
        //<< . ;
        //<< . ;ggf wieder rausnehmen, da nicht funktioniert, wenn user an anderen Rechner eingelogt ist:
        //<< . if YLSTKEY'="" if $listfind(YLSTKEY,YA) kill ^WWW1262(0,YFORM,YBED,YSORT) set YI=YI-1 quit
        if (mOp.NotEqual(YLSTKEY.get(),"")) {
          if (mOp.Logical(m$.Fnc.$listfind(YLSTKEY.get(),YA.get()))) {
            m$.var("^WWW1262",0,m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get()).kill();
            YI.set(mOp.Subtract(YI.get(),1));
            break;
          }
        }
        //<< . set YLSTKEY=YLSTKEY_$listbuild(YA)
        YLSTKEY.set(mOp.Concat(YLSTKEY.get(),m$.Fnc.$listbuild(YA.get())));
        //<< . ;
        //<< . if $extract(YA)="," set YA=$extract(YA,2,200)
        if (mOp.Equal(m$.Fnc.$extract(YA.get()),",")) {
          YA.set(m$.Fnc.$extract(YA.get(),2,200));
        }
        //<< . write YCR,"<option value="""_1_YSORT_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat("<option value=\"",1),YSORT.get()),"\""));
        //<< . set YA=$reverse($extract($reverse(YA),1,14))
        YA.set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(YA.get()),1,14)));
        //<< . write ">"_$$^WWWNBSP($extract(YA_$justify("",14),1,14))_"</option>"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.fnc$("WWWNBSP.main",m$.Fnc.$extract(mOp.Concat(YA.get(),m$.Fnc.$justify("",14)),1,14))),"</option>"));
      } while (false);
    }
    //<< 
    //<< write "</select>"
    m$.Cmd.Write("</select>");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< Exists(YFORM="",YBED="",YSORT="",YDATEI="")
  public Object Exists(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YBED = m$.newVarRef("YBED",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar YSORT = m$.newVarRef("YSORT",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; If the data record does not exist it can be removed from the MRU
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Nov-2008   shobby  SRAdhoc: Can crash if very long key. (probably from corrupt data)
    //<< ; 07-Jul-2005   shobby  SR12892: WWW1262 is no longer shared.
    //<< ; 27-Jun-2005   shobby  SR12442
    //<< ;-------------------------------------------------------------------------------
    //<< new blnExists,objWWW1262,idKey,idIndex,strGlobal,strKey,intLoop,blnInvalidKey
    mVar blnExists = m$.var("blnExists");
    mVar objWWW1262 = m$.var("objWWW1262");
    mVar idKey = m$.var("idKey");
    mVar idIndex = m$.var("idIndex");
    mVar strGlobal = m$.var("strGlobal");
    mVar strKey = m$.var("strKey");
    mVar intLoop = m$.var("intLoop");
    mVar blnInvalidKey = m$.var("blnInvalidKey");
    m$.newVar(blnExists,objWWW1262,idKey,idIndex,strGlobal,strKey,intLoop,blnInvalidKey);
    //<< 
    //<< set blnExists = $$$YES
    blnExists.set(include.COMSYS.$$$YES(m$));
    //<< if (YDATEI'="") && (YFORM'="") && (YBED'="") && (YSORT'="") {
    if ((mOp.NotEqual(YDATEI.get(),"")) && (mOp.NotEqual(YFORM.get(),"")) && (mOp.NotEqual(YBED.get(),"")) && (mOp.NotEqual(YSORT.get(),""))) {
      //<< set blnExists = $$$NO
      blnExists.set(include.COMSYS.$$$NO(m$));
      //<< set idKey     = ""
      idKey.set("");
      //<< set idIndex   = ""
      idIndex.set("");
      //<< for {
      for (;true;) {
        //<< set idIndex = $order(^WWW1262(0,YFORM,YBED,YSORT,idIndex))
        idIndex.set(m$.Fnc.$order(m$.var("^WWW1262",0,YFORM.get(),YBED.get(),YSORT.get(),idIndex.get())));
        //<< quit:(idIndex="")
        if ((mOp.Equal(idIndex.get(),""))) {
          break;
        }
        //<< 
        //<< set objWWW1262 = $get(^WWW1262(0,YFORM,YBED,YSORT,idIndex,1))
        objWWW1262.set(m$.Fnc.$get(m$.var("^WWW1262",0,YFORM.get(),YBED.get(),YSORT.get(),idIndex.get(),1)));
        //<< if (objWWW1262="") || (objWWW1262="+") set idKey="" quit
        if ((mOp.Equal(objWWW1262.get(),"")) || (mOp.Equal(objWWW1262.get(),"+"))) {
          idKey.set("");
          break;
        }
        //<< quit:objWWW1262=""
        if (mOp.Equal(objWWW1262.get(),"")) {
          break;
        }
        //<< 
        //<< set idKey = idKey_objWWW1262_","
        idKey.set(mOp.Concat(mOp.Concat(idKey.get(),objWWW1262.get()),","));
      }
      //<< }
      //<< 
      //<< if idKey'="" {
      if (mOp.NotEqual(idKey.get(),"")) {
        //<< set blnInvalidKey = $$$NO
        blnInvalidKey.set(include.COMSYS.$$$NO(m$));
        //<< set idKey  = $extract(idKey,1,$length(idKey)-1)
        idKey.set(m$.Fnc.$extract(idKey.get(),1,mOp.Subtract(m$.Fnc.$length(idKey.get()),1)));
        //<< set strKey = $$^WWWKEYBUILD(idKey)
        strKey.set(m$.fnc$("WWWKEYBUILD.main",idKey.get()));
        //<< for intLoop=1:1:$length(strKey,",") {
        for (intLoop.set(1);(mOp.LessOrEqual(intLoop.get(),m$.Fnc.$length(strKey.get(),",")));intLoop.set(mOp.Add(intLoop.get(),1))) {
          //<< if $length($piece(strKey,",",intLoop))>255 {
          if (mOp.Greater(m$.Fnc.$length(m$.Fnc.$piece(strKey.get(),",",intLoop.get())),255)) {
            //<< set blnInvalidKey=$$$YES   ;SRAdhoc
            blnInvalidKey.set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< }
        //<< }
        //<< if 'blnInvalidKey {
        if (mOp.Not(blnInvalidKey.get())) {
          //<< set strGlobal="^"_YDATEI_"("""_$$^WWWYM(YDATEI)_""","_$$^WWWKEYBUILD(strKey)_",1)"
          strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"(\""),m$.fnc$("WWWYM.main",YDATEI.get())),"\","),m$.fnc$("WWWKEYBUILD.main",strKey.get())),",1)"));
          //<< set blnExists=$data(@strGlobal) ;SRAdhoc
          blnExists.set(m$.Fnc.$data(m$.indirectVar(strGlobal.get())));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnExists
    return blnExists.get();
  }

  //<< 
  //<< 
  //<< BUTTON
  public void BUTTON() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   BUTTONEFFECT -> NICHT EINGEBAUT, DA OPTISCH NICHT SO GUT.
    //<< ;   ERFORDERT MENU.HTC IN WWWSTART
    //<< ;
    //<< ; History:
    //<< ; 27-Sep-2011   shobby  SR17853: Reverted doCancelEvent
    //<< ; 22-Dec-2005   JW      SR13195: Edited SAVENOW call.
    //<< ; 07-Jul-2005   shobby  SR12892: WWW1262 is no longer shared.
    //<< ; 19-Mar-2003   PK      alteration
    //<< ;-------------------------------------------------------------------------------
    //<< new YI,YA,YK,YLSTKEY,LNK,LINKS,YDISABLED
    mVar YI = m$.var("YI");
    mVar YA = m$.var("YA");
    mVar YK = m$.var("YK");
    mVar YLSTKEY = m$.var("YLSTKEY");
    mVar LNK = m$.var("LNK");
    mVar LINKS = m$.var("LINKS");
    mVar YDISABLED = m$.var("YDISABLED");
    m$.newVar(YI,YA,YK,YLSTKEY,LNK,LINKS,YDISABLED);
    //<< 
    //<< set YLSTKEY=""
    YLSTKEY.set("");
    //<< quit:$get(YFOART)'=1   ;NUR STANDARD FORMULARE ;only
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFOART")),1)) {
      return;
    }
    //<< 
    //<< ;SUCHEN HISTORY ;seek
    //<< ;ANZEIEN MENU
    //<< ;WRITE YCR,"<div id=""cmdPanelMain"" style=""border:1px solid black; padding:0px; WIDTH: 100px;"">"
    //<< write YCR,"<table style=""padding-top:1px; border:none;"" cellspacing=0 cellpadding=0>"
    m$.Cmd.Write(m$.var("YCR").get(),"<table style=\"padding-top:1px; border:none;\" cellspacing=0 cellpadding=0>");
    //<< write YCR,"<tr><td>"
    m$.Cmd.Write(m$.var("YCR").get(),"<tr><td>");
    //<< write YCR,"<table style=""table-layout:fixed; border-left:1px solid ButtonHighLight; border-top:1px solid ButtonHighLight; border-right:2px solid ButtonShadow; border-bottom:2px solid ButtonShadow;"" cellspacing=0 cellpadding=0>"
    m$.Cmd.Write(m$.var("YCR").get(),"<table style=\"table-layout:fixed; border-left:1px solid ButtonHighLight; border-top:1px solid ButtonHighLight; border-right:2px solid ButtonShadow; border-bottom:2px solid ButtonShadow;\" cellspacing=0 cellpadding=0>");
    //<< write YCR,"<tr><td height=17 width=135 valign=top>"
    m$.Cmd.Write(m$.var("YCR").get(),"<tr><td height=17 width=135 valign=top>");
    //<< write YCR,"<myMenu:menu id=""MyPage"" access=""enabled"""
    m$.Cmd.Write(m$.var("YCR").get(),"<myMenu:menu id=\"MyPage\" access=\"enabled\"");
    //<< write " onsubmenu_click=""var x = event.result; SAVENOW(x); window.event.returnValue = false; window.event.cancelBubble = true;"""  //SR17253 //SR17853
    m$.Cmd.Write(" onsubmenu_click=\"var x = event.result; SAVENOW(x); window.event.returnValue = false; window.event.cancelBubble = true;\"");
    //<< write " style=""cursor:pointer; text-align:middle; text-align:center; font-family:arial; width:135px;"">"       ;SR17253
    m$.Cmd.Write(" style=\"cursor:pointer; text-align:middle; text-align:center; font-family:arial; width:135px;\">");
    //<< 
    //<< write $$^WWWTEXT(101)  ; "Open"
    m$.Cmd.Write(m$.fnc$("WWWTEXT.main",101));
    //<< 
    //<< set YSORT=""
    mVar YSORT = m$.var("YSORT");
    YSORT.set("");
    //<< for YI=1:1 set YSORT=$order(^WWW1262(0,YFORM,YBED,YSORT),-1) quit:YSORT=""  do
    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
      YSORT.set(m$.Fnc.$order(m$.var("^WWW1262",0,m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get()),mOp.Negative(1)));
      if (mOp.Equal(YSORT.get(),"")) {
        break;
      }
      do {
        //<< . if YI>$$$WWW120NumberofMRURecordListItem(YVOR) kill ^WWW1262(0,YFORM,YBED,YSORT) quit  ;ZU VIELE  ;within much   ; D88
        if (mOp.Greater(YI.get(),include.WWWConst.$$$WWW120NumberofMRURecordListItem(m$,m$.var("YVOR")))) {
          m$.var("^WWW1262",0,m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get()).kill();
          break;
        }
        //<< . set YA=""
        YA.set("");
        //<< . set YK=""
        YK.set("");
        //<< . for  set YK=$order(^WWW1262(0,YFORM,YBED,YSORT,YK)) quit:YK=""  do       ;SUCHEN DER KEY'S ;seek the
        for (;true;) {
          YK.set(m$.Fnc.$order(m$.var("^WWW1262",0,m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get(),YK.get())));
          if (mOp.Equal(YK.get(),"")) {
            break;
          }
          //<< . . set YA=YA_", "_$extract($get(^WWW1262(0,YFORM,YBED,YSORT,YK,1)),1,30)  ;DATENSATZ ;data record
          YA.set(mOp.Concat(mOp.Concat(YA.get(),", "),m$.Fnc.$extract(m$.Fnc.$get(m$.var("^WWW1262",0,m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get(),YK.get(),1)),1,30)));
        }
        //<< . ;
        //<< . if YLSTKEY'="" if $listfind(YLSTKEY,YA) kill ^WWW1262(0,YFORM,YBED,YSORT) set YI=YI-1 quit  ;ÄNDERUNG VON DISC/PAUL KALENJUK 19.03.03 ;alteration
        if (mOp.NotEqual(YLSTKEY.get(),"")) {
          if (mOp.Logical(m$.Fnc.$listfind(YLSTKEY.get(),YA.get()))) {
            m$.var("^WWW1262",0,m$.var("YFORM").get(),m$.var("YBED").get(),YSORT.get()).kill();
            YI.set(mOp.Subtract(YI.get(),1));
            break;
          }
        }
        //<< . set YLSTKEY=YLSTKEY_$listbuild(YA)
        YLSTKEY.set(mOp.Concat(YLSTKEY.get(),m$.Fnc.$listbuild(YA.get())));
        //<< . if $extract(YA)="," set YA=$extract(YA,2,200)
        if (mOp.Equal(m$.Fnc.$extract(YA.get()),",")) {
          YA.set(m$.Fnc.$extract(YA.get(),2,200));
        }
        //<< . set YA=$reverse($extract($reverse(YA),1,14))
        YA.set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(YA.get()),1,14)));
        //<< . ;
        //<< . set YDISABLED="enabled"
        YDISABLED.set("enabled");
        //<< . write YCR,"   <myMenu:menu access="""_YDISABLED_""" id=""1"_YSORT_""">"_YA_"</myMenu:menu>"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("   <myMenu:menu access=\"",YDISABLED.get()),"\" id=\"1"),YSORT.get()),"\">"),YA.get()),"</myMenu:menu>"));
      } while (false);
    }
    //<< 
    //<< write YCR,"</myMenu:menu>"
    m$.Cmd.Write(m$.var("YCR").get(),"</myMenu:menu>");
    //<< write YCR,"</tr></td>"
    m$.Cmd.Write(m$.var("YCR").get(),"</tr></td>");
    //<< write YCR,"</table>"
    m$.Cmd.Write(m$.var("YCR").get(),"</table>");
    //<< write YCR,"</tr></td>"
    m$.Cmd.Write(m$.var("YCR").get(),"</tr></td>");
    //<< write YCR,"</table>"
    m$.Cmd.Write(m$.var("YCR").get(),"</table>");
    //<< ;WRITE YCR,"</div>"
    //<< quit
    return;
  }

//<< 
//<< 
}
