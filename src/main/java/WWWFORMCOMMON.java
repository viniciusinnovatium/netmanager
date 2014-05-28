//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMCOMMON
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:12:56
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

//<< WWWFORMCOMMON
public class WWWFORMCOMMON extends mClass {

  //<< 
  //<< #define FindOption(%1,%2) $find(","_$translate(%1,";",",")_",",","_%2_",")
  public static Object $$$FindOption(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(p$1.get(),";",",")),","),mOp.Concat(mOp.Concat(",",p$2.get()),",")));
  }

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
    _WWWFORMCOMMON();
  }

  public void _WWWFORMCOMMON() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORMCOMMON("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ;WWWFORMD
  //<< ;   $$NoAccess^WWWFORMCOMMON(YFORM,YDATEI,YBBN,"",   "",   "",    $get(YOPTION),$get(YOPTION1),$get(YPARA1))
  //<< ;WWWFORM4
  //<< ;   $$NoAccess^WWWFORMCOMMON(YFORM,YDATEI,YBBN,.YTXT,.YLFN,"",    $get(YOPTION),$get(YOPTION1),$get(YPARA1))
  //<< ;WWWFORM3
  //<< ;   $$NoAccess^WWWFORMCOMMON(YFORM,YDATEI,YBBN,.YTXT,.YLFN,.YTEXT,$get(YOPTION),$get(YOPTION1),$get(YPARA1))
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< NoAccess(pYFORM,pYDATEI,pYBBN,&pYTXT="",&pYLFN="",&pstrFieldName="",pYOPTION="",pYOPTION1="",pYPARA1="")
  public Object NoAccess(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYDATEI = m$.newVarRef("pYDATEI",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYBBN = m$.newVarRef("pYBBN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYTXT = m$.newVarRef("pYTXT",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pYLFN = m$.newVarRef("pYLFN",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pstrFieldName = m$.newVarRef("pstrFieldName",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    mVar pYOPTION = m$.newVarRef("pYOPTION",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    mVar pYOPTION1 = m$.newVarRef("pYOPTION1",(((_p!=null)&&(_p.length>=8))?_p[7]:null),"");
    mVar pYPARA1 = m$.newVarRef("pYPARA1",(((_p!=null)&&(_p.length>=9))?_p[8]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Notes:
    //<< ;   Some Y* parameters are passed by reference as they may be used at other levels
    //<< ;   in the call stack after this routine is called.
    //<< ;
    //<< ; Params:
    //<< ;   pYFORM:     Form Name
    //<< ;   pYDATEI:    Class Name
    //<< ;   pYBBN:      Field on form
    //<< ;   pYTXT:      Form field design (including customisation)
    //<< ;   pYLFN:      Class field associated with form field
    //<< ;   pstrFieldName:  Name of the field.   **** Note:Only relevant if YHIDDSE=0  ****
    //<< ;   pYOPTION:   A field can be hidden based on the definition of YOPTION
    //<< ;   pYOPTION1:  A field can be hidden based on the definition of YOPTION1
    //<< ;   pYPARA:     A field can be hidden based on the definition of YPARA
    //<< ;
    //<< ; Returns:
    //<< ;   blnHIDDSE:  Whether the field should be hidden
    //<< ;
    //<< ; History:
    //<< ; 12-Apr-2011   GRF     SR17711: Allow customisation of Manual field names
    //<< ; 11-Feb-2009   GRF     SR16347: Get name from form for manual field
    //<< ; 28-Oct-2007   shobby  SRBR014755: Incorrect parameter passed to WWWFELDNAME
    //<< ; 03-Jul-2007   GRF     SRBR014615: $get is not needed for pYOPTION since has
    //<< ;                           default value so will always exist.
    //<< ; 27-Jul-2007   shobby  SRBR014615: Return the field name if relevant.  Removed
    //<< ;                           YHIDDSE as a parameter.  Corrected default setting
    //<< ;                           for Manual fields.
    //<< ; 27-Jul-2007   shobby  SRBR014615: Prefixed parameter names with p, 2nd char Y
    //<< ;                           is suitable as the 'type' identifier.
    //<< ; 27-Jul-2007   shobby  SRBR014586: Include YOPTION,YOPTION1 and YPARA tests
    //<< ; 18-Jul-2007   shobby  SRBR014615: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnHIDDSE
    mVar blnHIDDSE = m$.var("blnHIDDSE");
    m$.newVar(blnHIDDSE);
    //<< 
    //<< $$$LogR("NoAccess",pYFORM_"<"_pYBBN)
    $$$LogR(m$,"NoAccess",mOp.Concat(mOp.Concat(pYFORM.get(),"<"),pYBBN.get()));
    //<< 
    //<< ; These may not be defined and will error if a null value is passed in to this routine as a parameter
    //<< set blnHIDDSE = $$$NO
    blnHIDDSE.set(include.COMSYS.$$$NO(m$));
    //<< set pYTXT     = $$Get^WWW122(pYFORM,pYBBN)
    pYTXT.set(m$.fnc$("WWW122.Get",pYFORM.get(),pYBBN.get()));
    //<< 
    //<< if (pYOPTION="") && ($$$WWW122OnlyShowIfOptionYOPTION(pYTXT)'="") set blnHIDDSE = $$$YES
    if ((mOp.Equal(pYOPTION.get(),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW122OnlyShowIfOptionYOPTION(m$,pYTXT),""))) {
      blnHIDDSE.set(include.COMSYS.$$$YES(m$));
    }
    //<< if (blnHIDDSE=$$$NO) set blnHIDDSE = $$Hidden(pYOPTION, pYTXT,$$$FldWWW122OnlyShowIfOptionYOPTION)
    if ((mOp.Equal(blnHIDDSE.get(),include.COMSYS.$$$NO(m$)))) {
      blnHIDDSE.set(m$.fnc$("Hidden",pYOPTION.get(),pYTXT.get(),include.WWWConst.$$$FldWWW122OnlyShowIfOptionYOPTION(m$)));
    }
    //<< if (blnHIDDSE=$$$NO) set blnHIDDSE = $$Hidden(pYOPTION1,pYTXT,$$$FldWWW122OnlyShowIfOptionYOPTION1)
    if ((mOp.Equal(blnHIDDSE.get(),include.COMSYS.$$$NO(m$)))) {
      blnHIDDSE.set(m$.fnc$("Hidden",pYOPTION1.get(),pYTXT.get(),include.WWWConst.$$$FldWWW122OnlyShowIfOptionYOPTION1(m$)));
    }
    //<< if (blnHIDDSE=$$$NO) set blnHIDDSE = $$Hidden(pYPARA1,  pYTXT,$$$FldWWW122DisplayItemOnlyWhenMenuPa)
    if ((mOp.Equal(blnHIDDSE.get(),include.COMSYS.$$$NO(m$)))) {
      blnHIDDSE.set(m$.fnc$("Hidden",pYPARA1.get(),pYTXT.get(),include.WWWConst.$$$FldWWW122DisplayItemOnlyWhenMenuPa(m$)));
    }
    //<< 
    //<< if blnHIDDSE=$$$NO {
    if (mOp.Equal(blnHIDDSE.get(),include.COMSYS.$$$NO(m$))) {
      //<< set pYLFN = $$$WWW122SequenceNumber(pYTXT)
      pYLFN.set(include.WWWConst.$$$WWW122SequenceNumber(m$,pYTXT));
      //<< if pYLFN'="" {
      if (mOp.NotEqual(pYLFN.get(),"")) {
        //<< set blnHIDDSE     = $$$YES ; Uncustomised free fields are hidden but manual shields should still show.
        blnHIDDSE.set(include.COMSYS.$$$YES(m$));
        //<< set pstrFieldName = $$^WWWFELDNAME(pYFORM,"D",pYLFN)
        pstrFieldName.set(m$.fnc$("WWWFELDNAME.main",pYFORM.get(),"D",pYLFN.get()));
        //<< if $extract(pstrFieldName,1,5)'="_FREE" {
        if (mOp.NotEqual(m$.Fnc.$extract(pstrFieldName.get(),1,5),"_FREE")) {
          //<< ;           if not hidden by either setting, check authorisation
          //<< if ($$$WWW122InputType(pYTXT)'=0) && ($$$WWW122DataInputType(pYTXT)'=15) {
          if ((mOp.NotEqual(include.WWWConst.$$$WWW122InputType(m$,pYTXT),0)) && (mOp.NotEqual(include.WWWConst.$$$WWW122DataInputType(m$,pYTXT),15))) {
            //<< set blnHIDDSE = ($$^WWWACCESS($$$WWW122UserAccess(pYTXT),$$$WWW122Module1(pYTXT))'=1)
            blnHIDDSE.set((mOp.NotEqual(m$.fnc$("WWWACCESS.main",include.WWWConst.$$$WWW122UserAccess(m$,pYTXT),include.WWWConst.$$$WWW122Module1(m$,pYTXT)),1)));
          }
        }
      }
      //<< }
      //<< }
      //<< } else {    ; Manual field
      else {
        //<< ;   set pstrFieldName = $$$WWW122ManualCaption(pYTXT)  ; SR17711
        //<< set pstrFieldName = $$^WWWFELDNAME(pYFORM,"M",pYBBN)
        pstrFieldName.set(m$.fnc$("WWWFELDNAME.main",pYFORM.get(),"M",pYBBN.get()));
      }
    }
    //<< }
    //<< }
    //<< quit blnHIDDSE
    return blnHIDDSE.get();
  }

  //<< 
  //<< 
  //<< Hidden(pstrValue="",pobjWWW122="",pintField="")
  public Object Hidden(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pobjWWW122 = m$.newVarRef("pobjWWW122",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pintField = m$.newVarRef("pintField",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; determines, based on meta data rules for YOPTION, YOPTION1 and YPARA whether a field
    //<< ; is hidden
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Aug-2007   GRF     SRBR014615: reuse $piece(pobjWWW122,Y,pintField) variable
    //<< ; 26-Jul-2007   shobby  SRBR014615: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnTest,strData
    mVar blnTest = m$.var("blnTest");
    mVar strData = m$.var("strData");
    m$.newVar(blnTest,strData);
    //<< 
    //<< $$$LogR("Hidden",pstrValue_"<"_pintField)
    $$$LogR(m$,"Hidden",mOp.Concat(mOp.Concat(pstrValue.get(),"<"),pintField.get()));
    //<< 
    //<< set blnTest = $$$NO
    blnTest.set(include.COMSYS.$$$NO(m$));
    //<< if pstrValue'="" {
    if (mOp.NotEqual(pstrValue.get(),"")) {
      //<< set strData = $piece(pobjWWW122,Y,pintField)
      strData.set(m$.Fnc.$piece(pobjWWW122.get(),m$.var("Y").get(),pintField.get()));
      //<< if strData'="" {
      if (mOp.NotEqual(strData.get(),"")) {
        //<< if strData'="'" {
        if (mOp.NotEqual(strData.get(),"'")) {
          //<< if '$$$FindOption(strData,pstrValue)                set blnTest = $$$YES
          if (mOp.Not($$$FindOption(m$,strData,pstrValue))) {
            blnTest.set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< } else {
        else {
          //<< if $$$FindOption($extract(strData,2,999),pstrValue) set blnTest = $$$YES
          if (mOp.Logical($$$FindOption(m$,m$.Fnc.$extract(strData.get(),2,999),pstrValue))) {
            blnTest.set(include.COMSYS.$$$YES(m$));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnTest
    return blnTest.get();
  }

  //<< 
  //<< 
  //<< Coolbar(YVOR="")
  public Object Coolbar(Object ... _p) {
    mVar YVOR = m$.newVarRef("YVOR",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Common method to create Coolbars adjusting the background colour if necessary.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-May-2012   shobby  SR17998: id on the COOLBAR
    //<< ; 17-Apr-2009   shobby  SR16455: Moved <table> tags in to this routine.
    //<< ; 14-Feb-2008   shobby  SRBR014526: Corrected set strText=" STYLE='"
    //<< ; 24-Jan-2008   shobby  SRBR014526: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strText,objWWW012
    mVar strText = m$.var("strText");
    mVar objWWW012 = m$.var("objWWW012");
    m$.newVar(strText,objWWW012);
    //<< 
    //<< set strText = "<table NOWRAP width=100% cellspacing=0 cellpadding=0"
    strText.set("<table NOWRAP width=100% cellspacing=0 cellpadding=0");
    //<< if (YVOR="") || ($$$WWW120PicturesAsButtons(YVOR)=$$$YES) {
    if ((mOp.Equal(YVOR.get(),"")) || (mOp.Equal(include.WWWConst.$$$WWW120PicturesAsButtons(m$,YVOR),include.COMSYS.$$$YES(m$)))) {
      //<< set strText   = strText_" class=""coolBar"" id='COOLBAR' " ;SR17998
      strText.set(mOp.Concat(strText.get()," class=\"coolBar\" id='COOLBAR' "));
      //<< set objWWW012 = $get(^WWW012(0,YM,1))
      objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
      //<< if $$$WWW012CoolbarBackgroundColor(objWWW012)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW012CoolbarBackgroundColor(m$,objWWW012),"")) {
        //<< set strText=strText_" STYLE=""background-color:"_$$$SysEnum("FARBE",$$$WWW012CoolbarBackgroundColor(objWWW012))_""""
        strText.set(mOp.Concat(mOp.Concat(mOp.Concat(strText.get()," STYLE=\"background-color:"),include.COMSYSWWW.$$$SysEnum(m$,"FARBE",include.WWWConst.$$$WWW012CoolbarBackgroundColor(m$,objWWW012))),"\""));
      }
    }
    //<< }
    //<< }
    //<< set strText = strText_">"_YCR
    strText.set(mOp.Concat(mOp.Concat(strText.get(),">"),m$.var("YCR").get()));
    //<< quit strText
    return strText.get();
  }

  //<< 
  //<< 
  //<< OpenTD(pblnUnselectable=$$$NO)
  public Object OpenTD(Object ... _p) {
    mVar pblnUnselectable = m$.newVarRef("pblnUnselectable",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; 03-May-2010   shobby  SR17253 filter to make more obvious button is disabled.
    //<< ;-------------------------------------------------------------------------------
    //<< ;quit YCR_"<TD WIDTH=10"_$select(pblnUnselectable:" unselectable style='filter:BlendTrans(Percent=60) gray();'",1:"")_$select($$$WWW120PicturesAsButtons(YVOR):" class=""coolButton""",1:"")_">"
    //<< quit YCR_"<TD WIDTH=10"_$select(pblnUnselectable:" unselectable=1 ",1:"")_$select($$$WWW120PicturesAsButtons(YVOR):" class=""coolButton""",1:"")_">"
    return mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YCR").get(),"<TD WIDTH=10"),m$.Fnc.$select(pblnUnselectable.get()," unselectable=1 ",1,"")),m$.Fnc.$select(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.var("YVOR"))," class=\"coolButton\"",1,"")),">");
  }

  //<< 
  //<< 
  //<< CloseTD()
  public Object CloseTD(Object ... _p) {
    //<< quit YCR_"</TD>"_YCR
    return mOp.Concat(mOp.Concat(m$.var("YCR").get(),"</TD>"),m$.var("YCR").get());
  }

  //<< 
  //<< 
  //<< Delimiter()
  public Object Delimiter(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Creates a toolbar delimiter.  Common code to replace existing repeated code.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Jul-2012   shobby  SR18053: Removed redundant code
    //<< ; 25-Aug-2010   GRF     Clarify code
    //<< ; 20-Apr-2009   shobby  SR16455: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit "<TD WIDTH=3><IMG SRC="""_YGIF_"delimiter.gif""></TD>"
    return mOp.Concat(mOp.Concat("<TD WIDTH=3><IMG SRC=\"",m$.var("YGIF").get()),"delimiter.gif\"></TD>");
  }

  //<< 
  //<< 
  //<< StopButton(pstrTitle,pstrImage,pstrName="",pblnEnabled=$$$YES,pblnStatus=$$$NO,pstrStyle="cursor:pointer",pblnCloseA=$$$NO)
  public Object StopButton(Object ... _p) {
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrImage = m$.newVarRef("pstrImage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrName = m$.newVarRef("pstrName",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnEnabled = m$.newVarRef("pblnEnabled",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$YES(m$));
    mVar pblnStatus = m$.newVarRef("pblnStatus",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    mVar pstrStyle = m$.newVarRef("pstrStyle",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"cursor:pointer");
    mVar pblnCloseA = m$.newVarRef("pblnCloseA",(((_p!=null)&&(_p.length>=7))?_p[6]:null),include.COMSYS.$$$NO(m$));
    //<< write $$StopButtonEx(pstrTitle,pstrImage,pstrName,pblnEnabled,pblnStatus,pstrStyle,pblnCloseA)
    m$.Cmd.Write(m$.fnc$("StopButtonEx",pstrTitle.get(),pstrImage.get(),pstrName.get(),pblnEnabled.get(),pblnStatus.get(),pstrStyle.get(),pblnCloseA.get()));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< StopButtonEx(pstrTitle,pstrImage,pstrName="",pblnEnabled=$$$YES,pblnStatus=$$$NO,pstrStyle="cursor:pointer",pblnCloseA=$$$NO)
  public Object StopButtonEx(Object ... _p) {
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrImage = m$.newVarRef("pstrImage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrName = m$.newVarRef("pstrName",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnEnabled = m$.newVarRef("pblnEnabled",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$YES(m$));
    mVar pblnStatus = m$.newVarRef("pblnStatus",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    mVar pstrStyle = m$.newVarRef("pstrStyle",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"cursor:pointer");
    mVar pblnCloseA = m$.newVarRef("pblnCloseA",(((_p!=null)&&(_p.length>=7))?_p[6]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Creates a button.  Common code to replace existing repeated code.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Dec-2013   shobby  SESDF-655: Disabled new buttons should be grey.
    //<< ; 04-Jul-2012   shobby  SR18053: Removed redundant code from 16455
    //<< ; 12-Jun-2012   shobby  SR18033: Rewrote to obtain HTML instead of write
    //<< ; 26-Jul-2011   GRF     Comment out SR16827 block so user "test" doesn't use
    //<< ; 20-Aug-2010   GRF     SR17512: increase opacity level from 30 to 50%
    //<< ; 02-Aug-2010   shobby  SR17481: $$Gray^WWWFORMCrossBrowserSupport
    //<< ; 17-Aug-2009   DWR     SR16827: added testing section to check for possible
    //<< ;                           extension to buttons.
    //<< ; 20-Apr-2009   shobby  SR16455: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnPicButton,strFilter,HTML,strImageMouseOver
    mVar blnPicButton = m$.var("blnPicButton");
    mVar strFilter = m$.var("strFilter");
    mVar HTML = m$.var("HTML");
    mVar strImageMouseOver = m$.var("strImageMouseOver");
    m$.newVar(blnPicButton,strFilter,HTML,strImageMouseOver);
    //<< 
    //<< set HTML=""
    HTML.set("");
    //<< 
    //<< set strFilter = ""
    strFilter.set("");
    //<< 
    //<< ;SESDF-655 if '$$UseNewButtons() {
    //<< if 'pblnEnabled set strFilter = "; "_$$Gray^WWWFORMCrossBrowserSupportVisual(50) ;SR17481  ; SR17512
    if (mOp.Not(pblnEnabled.get())) {
      strFilter.set(mOp.Concat("; ",m$.fnc$("WWWFORMCrossBrowserSupportVisual.Gray",50)));
    }
    //<< ;SESDF-655 }
    //<< if $$$WWW120PicturesAsButtons(YVOR) {
    if (mOp.Logical(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.var("YVOR")))) {
      //<< if '$$UseNewButtons() {
      if (mOp.Not(m$.fnc$("UseNewButtons"))) {
        //<< set HTML=HTML_$$$CRLF_"   <IMG align=absbottom id="""_pstrName_""""
        HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),include.COMSYSString.$$$CRLF(m$)),"   <IMG align=absbottom id=\""),pstrName.get()),"\""));
        //<< if pblnStatus set HTML=HTML_$$STATEX^WWWFORMF()
        if (mOp.Logical(pblnStatus.get())) {
          HTML.set(mOp.Concat(HTML.get(),m$.fnc$("WWWFORMF.STATEX")));
        }
        //<< set HTML=HTML_" SRC="""_YGIF_pstrImage_""""
        HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get()," SRC=\""),m$.var("YGIF").get()),pstrImage.get()),"\""));
        //<< if pstrStyle'="" set HTML=HTML_" style="""_pstrStyle_strFilter_""" "
        if (mOp.NotEqual(pstrStyle.get(),"")) {
          HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get()," style=\""),pstrStyle.get()),strFilter.get()),"\" "));
        }
        //<< set HTML=HTML_YHEIGHT_" "_YWIDTH_" TITLE="""_pstrTitle_""" border=0>"
        HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),m$.var("YHEIGHT").get())," "),m$.var("YWIDTH").get())," TITLE=\""),pstrTitle.get()),"\" border=0>"));
        //<< ;if pblnCloseA set HTML=HTML_$$$CRLF,"</A>"
        //<< set HTML=HTML_$$$CRLF
        HTML.set(mOp.Concat(HTML.get(),include.COMSYSString.$$$CRLF(m$)));
      }
      //<< } else {
      else {
        //<< new strLetter,blnMouseOver
        mVar strLetter = m$.var("strLetter");
        mVar blnMouseOver = m$.var("blnMouseOver");
        m$.newVar(strLetter,blnMouseOver);
        //<< if $length($replace(pstrImage,"_dis.gif",""))=1 set pstrImage=$replace(pstrImage,"_dis.gif","")
        if (mOp.Equal(m$.Fnc.$length(m$.Fnc.$replace(pstrImage.get(),"_dis.gif","")),1)) {
          pstrImage.set(m$.Fnc.$replace(pstrImage.get(),"_dis.gif",""));
        }
        //<< set strLetter=$piece(pstrImage,".",1)
        strLetter.set(m$.Fnc.$piece(pstrImage.get(),".",1));
        //<< if $length(strLetter)=1 set HTML=HTML_"<div>"
        if (mOp.Equal(m$.Fnc.$length(strLetter.get()),1)) {
          HTML.set(mOp.Concat(HTML.get(),"<div>"));
        }
        //<< set HTML=HTML_$$$CRLF_"   <IMG id='"_pstrName_"'"
        HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),include.COMSYSString.$$$CRLF(m$)),"   <IMG id='"),pstrName.get()),"'"));
        //<< if pblnStatus set HTML=HTML_$$STATEX^WWWFORMF()
        if (mOp.Logical(pblnStatus.get())) {
          HTML.set(mOp.Concat(HTML.get(),m$.fnc$("WWWFORMF.STATEX")));
        }
        //<< set HTML=HTML_" SRC="""_$$GetSRC(YGIF,.pstrImage,.blnMouseOver,.strImageMouseOver)_"""" ;SR18053
        HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get()," SRC=\""),m$.fnc$("GetSRC",m$.var("YGIF").get(),pstrImage,blnMouseOver,strImageMouseOver)),"\""));
        //<< 
        //<< if blnMouseOver {
        if (mOp.Logical(blnMouseOver.get())) {
          //<< set HTML=HTML_" _MouseOverImage=1 "                                                 ;SR18053
          HTML.set(mOp.Concat(HTML.get()," _MouseOverImage=1 "));
          //<< set HTML=HTML_" _Image="_pstrImage_" "                                              ;SR18053
          HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get()," _Image="),pstrImage.get())," "));
          //<< set HTML=HTML_" _ImageMouseOver="_strImageMouseOver_" "                             ;SR18053
          HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get()," _ImageMouseOver="),strImageMouseOver.get())," "));
        }
        //<< }
        //<< 
        //<< if pstrStyle'="" set HTML=HTML_" style='"_pstrStyle_strFilter_"; ' " ;SESDF-655
        if (mOp.NotEqual(pstrStyle.get(),"")) {
          HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get()," style='"),pstrStyle.get()),strFilter.get()),"; ' "));
        }
        //<< set HTML=HTML_YHEIGHT_" "_YWIDTH_" TITLE="""_pstrTitle_""" >"
        HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),m$.var("YHEIGHT").get())," "),m$.var("YWIDTH").get())," TITLE=\""),pstrTitle.get()),"\" >"));
        //<< set HTML=HTML_$$$CRLF
        HTML.set(mOp.Concat(HTML.get(),include.COMSYSString.$$$CRLF(m$)));
        //<< if $length(strLetter)=1 {
        if (mOp.Equal(m$.Fnc.$length(strLetter.get()),1)) {
          //<< set HTML=HTML_"<div"
          HTML.set(mOp.Concat(HTML.get(),"<div"));
          //<< if 'pblnEnabled set HTML=HTML_" class='Letter_Disabled'"
          if (mOp.Not(pblnEnabled.get())) {
            HTML.set(mOp.Concat(HTML.get()," class='Letter_Disabled'"));
          }
          //<< set HTML=HTML_">"_$zconvert(strLetter,"U")_"</div></div>"
          HTML.set(mOp.Concat(mOp.Concat(mOp.Concat(HTML.get(),">"),m$.Fnc.$zconvert(strLetter.get(),"U")),"</div></div>"));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit HTML
    return HTML.get();
  }

  //<< 
  //<< GetSRC(YGIF,&pstrImage,&pblnMouseOver,&pstrImageMouseOver)  ;SR18053
  public Object GetSRC(Object ... _p) {
    mVar YGIF = m$.newVarRef("YGIF",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrImage = m$.newVarRef("pstrImage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnMouseOver = m$.newVarRef("pblnMouseOver",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrImageMouseOver = m$.newVarRef("pstrImageMouseOver",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Replacement of old buttons with new buttons.
    //<< ; At some point it will be decided this should be a configuration or whether
    //<< ; old buttons are retired from the system.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Jul-2012   shobby      SR18053: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strImage
    mVar strImage = m$.var("strImage");
    m$.newVar(strImage);
    //<< 
    //<< set pblnMouseOver=$$$NO
    pblnMouseOver.set(include.COMSYS.$$$NO(m$));
    //<< if $$UseNewButtons() {
    if (mOp.Logical(m$.fnc$("UseNewButtons"))) {
      //<< set strImage=pstrImage
      strImage.set(pstrImage.get());
      //<< if $length($piece(strImage,".",1))=1 { set strImage="blank.gif"
      if (mOp.Equal(m$.Fnc.$length(m$.Fnc.$piece(strImage.get(),".",1)),1)) {
        strImage.set("blank.gif");
      }
      //<< } elseif pstrImage="listg.gif"      { set strImage="print.gif"
      else if (mOp.Equal(pstrImage.get(),"listg.gif")) {
        strImage.set("print.gif");
      }
      //<< } elseif pstrImage="del.gif"        { set strImage="delete.gif"
      else if (mOp.Equal(pstrImage.get(),"del.gif")) {
        strImage.set("delete.gif");
      }
      //<< } elseif pstrImage="action.gif"     { set strImage="processar.gif"
      else if (mOp.Equal(pstrImage.get(),"action.gif")) {
        strImage.set("processar.gif");
      }
      //<< } elseif pstrImage="actionno.gif"   { set strImage="processar_off.gif"
      else if (mOp.Equal(pstrImage.get(),"actionno.gif")) {
        strImage.set("processar_off.gif");
      }
      //<< } elseif pstrImage="text.gif"       { set strImage="relatorio02.gif"
      else if (mOp.Equal(pstrImage.get(),"text.gif")) {
        strImage.set("relatorio02.gif");
      }
      //<< } elseif pstrImage="hback.gif"      { set strImage="back.gif"
      else if (mOp.Equal(pstrImage.get(),"hback.gif")) {
        strImage.set("back.gif");
      }
      //<< } elseif pstrImage="hbackd.gif"     { set strImage="back_off.gif"
      else if (mOp.Equal(pstrImage.get(),"hbackd.gif")) {
        strImage.set("back_off.gif");
      }
      //<< } elseif pstrImage="rrev.gif"       { set strImage="first.gif"
      else if (mOp.Equal(pstrImage.get(),"rrev.gif")) {
        strImage.set("first.gif");
      }
      //<< } elseif pstrImage="rev.gif"        { set strImage="previous.gif"
      else if (mOp.Equal(pstrImage.get(),"rev.gif")) {
        strImage.set("previous.gif");
      }
      //<< } elseif pstrImage="for.gif"        { set strImage="next.gif"
      else if (mOp.Equal(pstrImage.get(),"for.gif")) {
        strImage.set("next.gif");
      }
      //<< } elseif pstrImage="ffor.gif"       { set strImage="last.gif"
      else if (mOp.Equal(pstrImage.get(),"ffor.gif")) {
        strImage.set("last.gif");
      }
      //<< } elseif pstrImage="disdel.gif"     { set strImage="delete_off.gif"
      else if (mOp.Equal(pstrImage.get(),"disdel.gif")) {
        strImage.set("delete_off.gif");
      }
      //<< } elseif pstrImage="hook.gif"       { set strImage="hook.gif"
      else if (mOp.Equal(pstrImage.get(),"hook.gif")) {
        strImage.set("hook.gif");
      }
      //<< } elseif pstrImage="key.gif"        { set strImage="Key.gif"
      else if (mOp.Equal(pstrImage.get(),"key.gif")) {
        strImage.set("Key.gif");
      }
      //<< }
      //<< if ##class(%Library.File).Exists($$$WWW012PhysicalWWWDirectory($get(^WWW012(0,0,1)))_"Buttons/"_strImage) {
      if (mOp.Logical(m$.fnc$("$Library.File.Exists",mOp.Concat(mOp.Concat(include.WWWConst.$$$WWW012PhysicalWWWDirectory(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))),"Buttons/"),strImage.get())))) {
        //<< set pstrImage="Buttons/"_strImage
        pstrImage.set(mOp.Concat("Buttons/",strImage.get()));
      }
      //<< }
      //<< set strImage=$piece(strImage,".gif",1)_"_mouseover.gif"
      strImage.set(mOp.Concat(m$.Fnc.$piece(strImage.get(),".gif",1),"_mouseover.gif"));
      //<< if ##class(%Library.File).Exists($$$WWW012PhysicalWWWDirectory($get(^WWW012(0,0,1)))_"Buttons/"_strImage) {
      if (mOp.Logical(m$.fnc$("$Library.File.Exists",mOp.Concat(mOp.Concat(include.WWWConst.$$$WWW012PhysicalWWWDirectory(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))),"Buttons/"),strImage.get())))) {
        //<< set pblnMouseOver=$$$YES
        pblnMouseOver.set(include.COMSYS.$$$YES(m$));
        //<< set pstrImageMouseOver=YGIF_"Buttons/"_strImage
        pstrImageMouseOver.set(mOp.Concat(mOp.Concat(YGIF.get(),"Buttons/"),strImage.get()));
      }
      //<< } else {
      else {
        //<< set pstrImageMouseOver=pstrImage
        pstrImageMouseOver.set(pstrImage.get());
      }
    }
    //<< }
    //<< }
    //<< ;set pstrImage=strImage
    //<< set pstrImage=YGIF_pstrImage
    pstrImage.set(mOp.Concat(YGIF.get(),pstrImage.get()));
    //<< quit pstrImage
    return pstrImage.get();
  }

  //<< 
  //<< UseNewButtons() ;SR18053
  public Object UseNewButtons(Object ... _p) {
    //<< ; 23-Aug-2012   shobby  SR18053:  Only do the new buttons in the toolbar
    //<< ;
    //<< quit (+$$$WWW013ButtonStyle($get(^WWW013(0,YBED,1))))&&($get(^CacheTempToolbar(YUSER))) ;SR18053
    return mOp.Logical((mOp.Positive(include.WWWConst.$$$WWW013ButtonStyle(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)))))) && mOp.Logical((m$.Fnc.$get(m$.var("^CacheTempToolbar",m$.var("YUSER").get()))));
  }

  //<< 
  //<< 
  //<< PreProcessText(pobj,pintField) ;SR16925
  public Object PreProcessText(Object ... _p) {
    mVar pobj = m$.newVarRef("pobj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintField = m$.newVarRef("pintField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; In some cases we don't want to try and translate the input text if there is
    //<< ; no corresponding language code that matches exactly the passed in string.
    //<< ; In that case we just want to return the original string.
    //<< ; A number of fields on forms have the option of entering a language code OR
    //<< ; straight text.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Oct-2009   shobby  SR16977: Don't check texts of 255 characters or longer.
    //<< ; 15-Oct-2009   shobby  SR16925: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strText
    mVar strText = m$.var("strText");
    m$.newVar(strText);
    //<< 
    //<< set strText = $piece(pobj,Y,pintField)
    strText.set(m$.Fnc.$piece(pobj.get(),m$.var("Y").get(),pintField.get()));
    //<< 
    //<< if (strText'="") && ($length(strText)<255) {
    if ((mOp.NotEqual(strText.get(),"")) && (mOp.Less(m$.Fnc.$length(strText.get()),255))) {
      //<< if $data(^WWW009(0,SPRACHE,strText)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW009",0,m$.var("SPRACHE").get(),strText.get())))) {
        //<< set strText = $$$Text(strText)
        strText.set(include.COMSYS.$$$Text(m$,strText));
      }
    }
    //<< }
    //<< }
    //<< quit strText
    return strText.get();
  }

//<< 
}
