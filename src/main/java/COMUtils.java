//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUtils
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:53:58
//*****************************************************************************

import mLibrary.*;

//<< #include COMConst
import include.COMConst;
import include.COMSYS;
//<< #include WWWConst
import include.WWWConst;
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

//<< COMUtils
public class COMUtils extends mClass {

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
    _COMUtils();
  }

  public void _COMUtils() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^COMUtils("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Common Utilities
  //<< ;
  //<< ; See also :
  //<< ;   COMUtilDate     Date/Time Utilities
  //<< ;   COMUtilStr      String Manipulation
  //<< ;   COMUtilGlo      Global Manipulation
  //<< ;   COMUtilForm     @netManager Form Utilities
  //<< ;   COMUtilClass    @netManager Class Utilities
  //<< ;   COMUtilError    Error Handling Utilities
  //<< ;
  //<< ; History:
  //<< ; 18-Jan-2007   GRF     SR15387: Doco
  //<< ; 24-Jun-2005   RobertW SR12690: Fixed up local calls to DecodeError to use the one on COMUtilError
  //<< ; 23-Feb-2005   GRF     SR11499: moved some routines to COMUtilClass
  //<< ;                       COMUtilForm and COMUtilError
  //<< ; 05-Nov-2004   GRF     Rationalise Utility Types; moved some routines to
  //<< ;                       COMUtilStr & COMUtilDate
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< HideControl(YFORM,pidClassField,pidField,pblnHidden,pstrType="D")  ;SR18016
  public Object HideControl(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidClassField = m$.newVarRef("pidClassField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnHidden = m$.newVarRef("pblnHidden",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"D");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Hide some controls based on 'Rules' including the group (FIELDSET) that the control
    //<< ; is contained in.
    //<< ; Warning: The group will disappear based on whether the first control disappears.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Feb-2013   shobby      SESPE-467: Adjustment for firefox.
    //<< ; 01-Jun-2012   shobby      SR18027: More protection if CAPTION or CONTROL don't exist (Maybe
    //<< ;                               on another page).
    //<< ; 01-Jun-2012   shobby      SR18027: Only hide the group if all fields are hidden.
    //<< ; 23-May-2012   shobby      SR18016: pstrType so that Manual fields can be hidden as well.
    //<< ; 23-Aug-2011   shobby      SR17784: Check that the fieldset object exists.
    //<< ; 16-Aug-2011   shobby      SR17784: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHidden,objWWW122
    mVar strHidden = m$.var("strHidden");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(strHidden,objWWW122);
    //<< 
    //<< 
    //<< ;SR18027 if pblnHidden { set strHidden="none" } else { set strHidden="block" }
    //<< ;SR18027 if pstrType="D" set pidField=pidClassField                                                                      ;SR18016
    //<< ;SR18027 write "var obj=document.getElementById('Y"_pYFORM_pstrType_pidField_"').parentNode.parentNode.parentNode;"       ;SR18016
    //<< ;SR18027 write "obj.style.display='"_strHidden_"';"
    //<< ;SR18027 set objWWW122   = $get(^WWW122(0,pYFORM,pidField,1))
    //<< ;SR18027 if ($$$WWW122NewGroup(objWWW122)=1)||($$$WWW122NewGroup(objWWW122)=2) {
    //<< ;SR18027    write "  var obj=getParent(obj,'FIELDSET');"
    //<< ;SR18027    write "  if (obj!=null) obj.style.display='"_strHidden_"';"
    //<< ;SR18027 }
    //<< 
    //<< ;SR18027 quit
    //<< 
    //<< if pblnHidden { set strHidden="none" } else { set strHidden="block" }
    if (mOp.Logical(pblnHidden.get())) {
      strHidden.set("none");
    }
    else {
      strHidden.set("block");
    }
    //<< if ($get(YUSERAGENT)'="MSIE") && (strHidden="block") set strHidden=""   ;SESPE-467
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) && (mOp.Equal(strHidden.get(),"block"))) {
      strHidden.set("");
    }
    //<< if pstrType="D" set pidField=pidClassField                                                                       ;SR18016
    if (mOp.Equal(pstrType.get(),"D")) {
      pidField.set(pidClassField.get());
    }
    //<< write "var obj=document.getElementById('Y"_pYFORM_pstrType_pidField_"_CAPTION');"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("var obj=document.getElementById('Y",m$.var("pYFORM").get()),pstrType.get()),pidField.get()),"_CAPTION');"));
    //<< write "if(obj!=null) obj.style.display='"_strHidden_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("if(obj!=null) obj.style.display='",strHidden.get()),"';"));
    //<< write "var obj=document.getElementById('Y"_pYFORM_pstrType_pidField_"_CONTROL');"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("var obj=document.getElementById('Y",m$.var("pYFORM").get()),pstrType.get()),pidField.get()),"_CONTROL');"));
    //<< write "if(obj!=null) {"
    m$.Cmd.Write("if(obj!=null) {");
    //<< write "  obj.style.display='"_strHidden_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("  obj.style.display='",strHidden.get()),"';"));
    //<< 
    //<< set objWWW122   = $get(^WWW122(0,pYFORM,pidField,1))
    objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("pYFORM").get(),pidField.get(),1)));
    //<< if ($$$WWW122NewGroup(objWWW122)=1)||($$$WWW122NewGroup(objWWW122)=2) {
    if ((mOp.Equal(include.WWWConst.$$$WWW122NewGroup(m$,objWWW122),1)) || (mOp.Equal(include.WWWConst.$$$WWW122NewGroup(m$,objWWW122),2))) {
      //<< &html<
      //<< if ('#(strHidden)#'=='none') {
      //<< var obj3;
      //<< var blnHide=true;
      //<< var intChildren=obj.parentNode.children.length;
      //<< for (var i=0;i!=intChildren;i++) {
      //<< obj3=obj.parentNode.children[i];
      //<< if (obj3.id!='') {
      //<< if (obj3.style.display!='hidden') {
      //<< var blnHide=false;
      //<< }
      //<< }
      //<< }
      //<< } else {
      //<< blnHide=true;
      //<< }
      //<< if (blnHide) {
      //<< var obj1=getParent(obj,'FIELDSET');
      //<< obj1.style.display='#(strHidden)#';
      //<< }
      //<< >
      m$.Cmd.WriteHtml("","\n");
      m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("            if ('",(strHidden.get())),"'=='none') {"),"\n");
      m$.Cmd.WriteHtml("                var obj3;","\n");
      m$.Cmd.WriteHtml("                var blnHide=true;","\n");
      m$.Cmd.WriteHtml("                var intChildren=obj.parentNode.children.length;","\n");
      m$.Cmd.WriteHtml("                for (var i=0;i!=intChildren;i++) {","\n");
      m$.Cmd.WriteHtml("                    obj3=obj.parentNode.children[i];","\n");
      m$.Cmd.WriteHtml("                    if (obj3.id!='') {","\n");
      m$.Cmd.WriteHtml("                        if (obj3.style.display!='hidden') {","\n");
      m$.Cmd.WriteHtml("                            var blnHide=false;","\n");
      m$.Cmd.WriteHtml("                        }","\n");
      m$.Cmd.WriteHtml("                    }","\n");
      m$.Cmd.WriteHtml("                }","\n");
      m$.Cmd.WriteHtml("            } else {","\n");
      m$.Cmd.WriteHtml("                blnHide=true;","\n");
      m$.Cmd.WriteHtml("            }","\n");
      m$.Cmd.WriteHtml("            if (blnHide) {","\n");
      m$.Cmd.WriteHtml("                var obj1=getParent(obj,'FIELDSET');","\n");
      m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                obj1.style.display='",(strHidden.get())),"';"),"\n");
      m$.Cmd.WriteHtml("            }","\n");
      m$.Cmd.WriteHtml("        ");
    }
    //<< }
    //<< write "}"
    m$.Cmd.Write("}");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SplitNumeric(pstrNumber,&pstrAlpha,&pstrDigits)
  public Object SplitNumeric(Object ... _p) {
    mVar pstrNumber = m$.newVarRef("pstrNumber",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrAlpha = m$.newVarRef("pstrAlpha",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrDigits = m$.newVarRef("pstrDigits",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Takes a input and splits the numeric from the digit components
    //<< ;
    //<< ; P0006 > 6000P intPos=4    pstrAlpha = "P"     pstrDigits = "0006"
    //<< ; 00006 > 60000 intPos=5    pstrAlpha = ""      pstrDigits = "00006"
    //<< ; 00P06 > 60P00 intPos=2    pstrAlpha = "00P"   pstrDigits = "06"
    //<< ; ABCDE > EDCBA intPos=0    pstrAlpha = "ABCDE" pstrDigits = ""
    //<< ; P6.01 > 01.6P intPos=4    pstrAlpha = "P"     pstrDigits = "6.01"
    //<< ;
    //<< ; Inputs:
    //<< ;   pstrNumber: The original "number" contains alpha/numeric data
    //<< ;
    //<< ; ByRef:
    //<< ;   pstrAlpha : The alphabetic portion (can contain numbers)
    //<< ;   pstrDigits: The numeric only portion
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-May-2007   RPW     SR15514: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intLength,intPos,loop,strChar,strNumber
    mVar intLength = m$.var("intLength");
    mVar intPos = m$.var("intPos");
    mVar loop = m$.var("loop");
    mVar strChar = m$.var("strChar");
    mVar strNumber = m$.var("strNumber");
    m$.newVar(intLength,intPos,loop,strChar,strNumber);
    //<< 
    //<< set intLength = $length(pstrNumber)
    intLength.set(m$.Fnc.$length(pstrNumber.get()));
    //<< set strNumber = $reverse(pstrNumber)
    strNumber.set(m$.Fnc.$reverse(pstrNumber.get()));
    //<< 
    //<< set intPos=0
    intPos.set(0);
    //<< for loop=1:1:intLength {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),intLength.get()));loop.set(mOp.Add(loop.get(),1))) {
      //<< set strChar=$extract(strNumber,loop)
      strChar.set(m$.Fnc.$extract(strNumber.get(),loop.get()));
      //<< quit:('(strChar?1N))&&(strChar'=".")
      if ((mOp.Not((mOp.Match(strChar.get(),"1N")))) && (mOp.NotEqual(strChar.get(),"."))) {
        break;
      }
      //<< 
      //<< set intPos=loop
      intPos.set(loop.get());
    }
    //<< }
    //<< 
    //<< set intPos     = intLength-intPos
    intPos.set(mOp.Subtract(intLength.get(),intPos.get()));
    //<< set pstrAlpha  = $extract(pstrNumber,1,intPos)
    pstrAlpha.set(m$.Fnc.$extract(pstrNumber.get(),1,intPos.get()));
    //<< set pstrDigits = $extract(pstrNumber,intPos+1,intLength)
    pstrDigits.set(m$.Fnc.$extract(pstrNumber.get(),mOp.Add(intPos.get(),1),intLength.get()));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< AddSeconds(pdteDate="",lngSeconds=0)
  public Object AddSeconds(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar lngSeconds = m$.newVarRef("lngSeconds",(((_p!=null)&&(_p.length>=2))?_p[1]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; 12-Jul-2005   shobby      Scheduler running from old namespaces still requires this link.
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$AddSeconds^COMUtilDate(pdteDate,lngSeconds)
    return m$.fnc$("COMUtilDate.AddSeconds",pdteDate.get(),lngSeconds.get());
  }

  //<< 
  //<< DateDiff(pdteFirst="",pdteSecond="")
  public Object DateDiff(Object ... _p) {
    mVar pdteFirst = m$.newVarRef("pdteFirst",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pdteSecond = m$.newVarRef("pdteSecond",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; 12-Jul-2005   shobby      Scheduler running from old namespaces still requires this link.
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$DateDiff^COMUtilDate(pdteFirst,pdteSecond)
    return m$.fnc$("COMUtilDate.DateDiff",pdteFirst.get(),pdteSecond.get());
  }

  //<< 
  //<< GetDaysInMonth(pdteDate="")
  public Object GetDaysInMonth(Object ... _p) {
    mVar pdteDate = m$.newVarRef("pdteDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; 12-Jul-2005   shobby      Scheduler running from old namespaces still requires this link.
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$GetDaysInMonth^COMUtilDate(pdteDate)
    return m$.fnc$("COMUtilDate.GetDaysInMonth",pdteDate.get());
  }

  //<< 
  //<< DisplayMessage(YBACK,YKEY,plstMessage,pstrAppend="",pblnNewLine=$$$YES,YSEITE="")
  public Object DisplayMessage(Object ... _p) {
    mVar YBACK = m$.newVarRef("YBACK",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar plstMessage = m$.newVarRef("plstMessage",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrAppend = m$.newVarRef("pstrAppend",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pblnNewLine = m$.newVarRef("pblnNewLine",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$YES(m$));
    mVar YSEITE = m$.newVarRef("YSEITE",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Displays a linked warning message to the screen.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2005   shobby  SR12786: Included YSEITE.
    //<< ; 07-Jun-2005   shobby  SR12408: Placed YFORM into the YBACK variable to correct problem
    //<< ;                       pressing the back button.  Note: Won't work if hyperlink
    //<< ;                       jumps to same form but different key. @netManager limitation.
    //<< ; 02-Jun-2005   PO      FIXME: SR:12050 quick workaround for FC mode display
    //<< ; 01-Jun-2005   shobby  SR12245: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if pblnNewLine WRITE YCR,"<br>"
    if (mOp.Logical(pblnNewLine.get())) {
      m$.Cmd.Write(m$.var("YCR").get(),"<br>");
    }
    //<< write "<A HREF="""_YAKTION_"EP=WWWFORM&amp;YFORM="_YBACK
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),YBACK.get()));
    //<< if YSEITE'="" WRITE "&amp;YSEITE="_YSEITE
    if (mOp.NotEqual(YSEITE.get(),"")) {
      m$.Cmd.Write(mOp.Concat("&amp;YSEITE=",YSEITE.get()));
    }
    //<< SET YBACK=YFORM_","
    YBACK.set(mOp.Concat(m$.var("YFORM").get(),","));
    //<< DO ^WWWCGI
    m$.Cmd.Do("WWWCGI.main");
    //<< write """><font size=2 color="_YRED_">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("\"><font size=2 color=",m$.var("YRED").get()),">"));
    //<< write $$$Text(plstMessage)_pstrAppend
    m$.Cmd.Write(mOp.Concat(include.COMSYS.$$$Text(m$,plstMessage),pstrAppend.get()));
    //<< write "</font></A>"
    m$.Cmd.Write("</font></A>");
    //<< quit
    return null;
  }

  //<< 
  //<< GetAmount(pcurDebit,pcurCredit,pcurAmountBase,pstrCurrency,pcurAmountFC,pfltRate)
  public Object GetAmount(Object ... _p) {
    mVar pcurDebit = m$.newVarRef("pcurDebit",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pcurCredit = m$.newVarRef("pcurCredit",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pcurAmountBase = m$.newVarRef("pcurAmountBase",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrCurrency = m$.newVarRef("pstrCurrency",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pcurAmountFC = m$.newVarRef("pcurAmountFC",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pfltRate = m$.newVarRef("pfltRate",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; TODO : Should identify ByRef inputs - routine doesn't appear to be called
    //<< ;        anywhere. Should it be part of COMSYSFC instead? <GRF>
    //<< ;-------------------------------------------------------------------------------
    //<< new curCreditBase,curCreditFC,curDebitBase,curDebitFC
    mVar curCreditBase = m$.var("curCreditBase");
    mVar curCreditFC = m$.var("curCreditFC");
    mVar curDebitBase = m$.var("curDebitBase");
    mVar curDebitFC = m$.var("curDebitFC");
    m$.newVar(curCreditBase,curCreditFC,curDebitBase,curDebitFC);
    //<< 
    //<< if pcurAmountBase>0 {
    if (mOp.Greater(pcurAmountBase.get(),0)) {
      //<< set curCreditBase = pcurAmountBase
      curCreditBase.set(pcurAmountBase.get());
      //<< set curCreditFC   = +$get(pcurAmountFC)
      curCreditFC.set(mOp.Positive(m$.Fnc.$get(pcurAmountFC)));
      //<< set curDebitBase  = 0
      curDebitBase.set(0);
      //<< set curDebitFC    = 0
      curDebitFC.set(0);
    }
    //<< } else {
    else {
      //<< set curDebitBase  = -pcurAmountBase
      curDebitBase.set(mOp.Negative(pcurAmountBase.get()));
      //<< set curDebitFC    = -$get(pcurAmountFC)
      curDebitFC.set(mOp.Negative(m$.Fnc.$get(pcurAmountFC)));
      //<< set curCreditBase = 0
      curCreditBase.set(0);
      //<< set curCreditFC   = 0
      curCreditFC.set(0);
    }
    //<< }
    //<< 
    //<< if pstrCurrency'="" {
    if (mOp.NotEqual(pstrCurrency.get(),"")) {
      //<< set pcurDebit =curDebitBase _"@"_pstrCurrency_"@"_curDebitFC _"@"_pfltRate
      pcurDebit.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(curDebitBase.get(),"@"),pstrCurrency.get()),"@"),curDebitFC.get()),"@"),pfltRate.get()));
      //<< set pcurCredit=curCreditBase_"@"_pstrCurrency_"@"_curCreditFC_"@"_pfltRate
      pcurCredit.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(curCreditBase.get(),"@"),pstrCurrency.get()),"@"),curCreditFC.get()),"@"),pfltRate.get()));
    }
    //<< } else {
    else {
      //<< set pcurDebit =curDebitBase
      pcurDebit.set(curDebitBase.get());
      //<< set pcurCredit=curCreditBase
      pcurCredit.set(curCreditBase.get());
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< Round(pcurAmount)
  public Object Round(Object ... _p) {
    mVar pcurAmount = m$.newVarRef("pcurAmount",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Rounding routine currently employed system wide.
    //<< ; Will need to change depending on currency involved
    //<< ;
    //<< ; History:
    //<< ; 28-Mar-2003   Paul K  Created(Commented)
    //<< ;-------------------------------------------------------------------------------
    //<< ; *******************************************
    //<< ; FIXME : Should calls to this use Round^COMUtilNum instead which isn't hard coded to 2dp? <GRF>
    //<< ; *******************************************
    //<< 
    //<< $$$LogR("Round",pcurAmount)
    $$$LogR(m$,"Round",pcurAmount);
    //<< 
    //<< quit $fnumber(pcurAmount,"",2)
    return m$.Fnc.$fnumber(pcurAmount.get(),"",2);
  }

  //<< 
  //<< 
  //<< GetColour(pstrParam,plngNumber)
  public Object GetColour(Object ... _p) {
    mVar pstrParam = m$.newVarRef("pstrParam",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar plngNumber = m$.newVarRef("plngNumber",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; gets a color for an application Parameter
    //<< ;
    //<< ; History:
    //<< ; 12-May-2006   RPW     SR14609: Do not use $$Upper^COMUtils, use $$$UPPER
    //<< ; 15-Jul-2005   shobby  SR12754:Replaced LANGUAGE global (not always reliable)
    //<< ; 15-Mar-2004   Paul K  Added macro usage
    //<< ;-------------------------------------------------------------------------------
    //<< new strColourNumber,strColour
    mVar strColourNumber = m$.var("strColourNumber");
    mVar strColour = m$.var("strColour");
    m$.newVar(strColourNumber,strColour);
    //<< 
    //<< set strColour=""
    strColour.set("");
    //<< set pstrParam=$$$UPPER(pstrParam)
    pstrParam.set(include.COMSYSString.$$$UPPER(m$,pstrParam));
    //<< if $data(^WWW101(0,pstrParam,SPRACHE,plngNumber,1)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW101",0,pstrParam.get(),m$.var("SPRACHE").get(),plngNumber.get(),1)))) {
      //<< set strColourNumber=$$$WWW101ColorCode($get(^WWW101(0,pstrParam,SPRACHE,plngNumber,1)))
      strColourNumber.set(include.WWWConst.$$$WWW101ColorCode(m$,m$.Fnc.$get(m$.var("^WWW101",0,pstrParam.get(),m$.var("SPRACHE").get(),plngNumber.get(),1))));
    }
    //<< }
    //<< 
    //<< if $get(strColourNumber)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(strColourNumber),"")) {
      //<< if $data(^WWW100(0,"FARBE",SPRACHE,strColourNumber,1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),strColourNumber.get(),1)))) {
        //<< set strColour=$get(^WWW100(0,"FARBE",SPRACHE,strColourNumber,1))
        strColour.set(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),strColourNumber.get(),1)));
      }
    }
    //<< }
    //<< }
    //<< quit strColour
    return strColour.get();
  }

  //<< 
  //<< GetEnumDescription(pstrParam="",plngNumber="",pblnSysParam=$$$NO)
  public Object GetEnumDescription(Object ... _p) {
    mVar pstrParam = m$.newVarRef("pstrParam",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar plngNumber = m$.newVarRef("plngNumber",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnSysParam = m$.newVarRef("pblnSysParam",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets the description of an application/system parameter
    //<< ;
    //<< ; Inputs:
    //<< ;   pblnSysParam        $$$NO   Application Parameter (WWW101)
    //<< ;                       $$$YES  System Parameter      (WWW100)
    //<< ; History :
    //<< ; 12-May-2006   RPW     SR14609: Do not use $$Upper^COMUtils, use $$$UPPER
    //<< ; 15-Jul-2005   shobby  SR12754: Replaced LANGUAGE global (not always reliable)
    //<< ; 20-Dec-2004   GRF     SR10478: Extract from System Parameters as well as
    //<< ;                       from Application Parameters; add defaults
    //<< ;-------------------------------------------------------------------------------
    //<< new strDescription
    mVar strDescription = m$.var("strDescription");
    m$.newVar(strDescription);
    //<< 
    //<< if $get(SPRACHE)="" do ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< set strDescription = plngNumber
    strDescription.set(plngNumber.get());
    //<< set pstrParam      = $$$UPPER(pstrParam)
    pstrParam.set(include.COMSYSString.$$$UPPER(m$,pstrParam));
    //<< 
    //<< if plngNumber'="" {
    if (mOp.NotEqual(plngNumber.get(),"")) {
      //<< if pblnSysParam {
      if (mOp.Logical(pblnSysParam.get())) {
        //<< set strDescription=$$$WWW100Text($get(^WWW100(0,pstrParam,SPRACHE,plngNumber,1)))
        strDescription.set(include.WWWConst.$$$WWW100Text(m$,m$.Fnc.$get(m$.var("^WWW100",0,pstrParam.get(),m$.var("SPRACHE").get(),plngNumber.get(),1))));
      }
      //<< } else {
      else {
        //<< set strDescription=$$$WWW101Text($get(^WWW101(0,pstrParam,SPRACHE,plngNumber,1)))
        strDescription.set(include.WWWConst.$$$WWW101Text(m$,m$.Fnc.$get(m$.var("^WWW101",0,pstrParam.get(),m$.var("SPRACHE").get(),plngNumber.get(),1))));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strDescription
    return strDescription.get();
  }

  //<< 
  //<< GetFullGlobalID(pstrId)
  public Object GetFullGlobalID(Object ... _p) {
    mVar pstrId = m$.newVarRef("pstrId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 05-Nov-2004   GRF     Convert dot to { form
    //<< ;-------------------------------------------------------------------------------
    //<< new strResult
    mVar strResult = m$.var("strResult");
    m$.newVar(strResult);
    //<< 
    //<< set strResult=""
    strResult.set("");
    //<< if pstrId'="" {
    if (mOp.NotEqual(pstrId.get(),"")) {
      //<< if +pstrId'=pstrId {
      if (mOp.NotEqual(mOp.Positive(pstrId.get()),pstrId.get())) {
        //<< set pstrId=""""_pstrId_""""
        pstrId.set(mOp.Concat(mOp.Concat("\"",pstrId.get()),"\""));
      }
      //<< }
      //<< set strResult=YM_","_pstrId_",1"
      strResult.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YM").get(),","),pstrId.get()),",1"));
    }
    //<< }
    //<< quit strResult
    return strResult.get();
  }

  //<< 
  //<< 
  //<< IsList(pstrList)
  public Object IsList(Object ... _p) {
    mVar pstrList = m$.newVarRef("pstrList",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;---------------------------------------------------------------------------------
    //<< ; Determines whether a variable is a list or a string.
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 03-Jun-2009   SCR     SR16603: Added $listvalid function for versio 2008.2.3
    //<< ; 29-Jan-2007   JW      SR15358: Add extra islist check. This is the best we have so far.
    //<< ; 02-Oct-2006   RPW     SRBR014006: Reverted below changes. Check for >253 characters.
    //<< ;                       NOTES: 1) Will need to check if string length becomes >
    //<< ;                            32000 characters
    //<< ;                         2) Cache >=5.1 support new list functions, this should
    //<< ;                            negate this routine entirely
    //<< ;                         3) Exceptions are basically for that purpose, unknown
    //<< ;                            issues, they are slow and do a lot of unnecessary work.
    //<< ; 01-Oct-2006   shobby  SRBR014006 Reverted previous change.  Did not always work.
    //<< ; 23-May-2005   RobertW SR10256: Rewritten to not use an error. The error is expensive.
    //<< ; 28-Jun-2003   LW      Re-written to work
    //<< ; 28-Mar-2003   Paul K  Created(Commented)
    //<< ;---------------------------------------------------------------------------------
    //<< new loop,blnList
    mVar loop = m$.var("loop");
    mVar blnList = m$.var("blnList");
    m$.newVar(loop,blnList);
    //<< 
    //<< set blnList = $$$NO
    blnList.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< //if ##class(%SYSTEM.Version).GetNumber()>2008.1 {         ; SR16603
    //<< //xecute "set blnList=$listvalid(pstrList)" ; Execute required so it will compile for older versions
    //<< set blnList=$listvalid(pstrList)
    blnList.set(m$.Fnc.$listvalid(pstrList.get()));
    //<< 
    //<< //}
    //<< //
    //<< //else {
    //<< //  if $$islist^%occRun(pstrList) {     //SR15358
    //<< //      for loop=1:1:$length(pstrList) {
    //<< //          if $ascii($extract(pstrList,loop))<8 {
    //<< //              set blnList=$$$YES
    //<< //              quit
    //<< //          }
    //<< //      }
    //<< //  }
    //<< //}
    //<< quit blnList
    return blnList.get();
  }

  //<< 
  //<< /*
  //<< ;new dummy,blnList
  //<< ;set blnList=$$$NO
  //<< ;if $length(pstrList)'>253 { // The minimum list size is 255 chars, 253 + pointer + type (for 8 bit).
  //<< ;   set dummy=$ascii($extract(pstrList,2))
  //<< ;} else {
  //<< ;set dummy=$ascii($extract(pstrList,4))
  //<< ;}
  //<< ;if (dummy<8) {
  //<< ;   set blnList=$$$YES
  //<< ;}
  //<< ;quit blnList
  //<< 
  //<< new dummy
  //<< set $ZTRAP="IsListErr"
  //<< set dummy=$list(pstrList,1)
  //<< quit $$$YES
  //<< */
  //<< 
  //<< IsBase64(pstrText="",pblnDblCrypt=$$$NO)
  public Object IsBase64(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pblnDblCrypt = m$.newVarRef("pblnDblCrypt",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;---------------------------------------------------------------------------------
    //<< ; Determines whether a string is base64 encrypted
    //<< ;
    //<< ; Inputs: pstrText     = String to be checked
    //<< ;         pblnDblCrypt = Expect Decoded String to be Crypted (ie. MD5 Encryption)
    //<< ;
    //<< ; History:
    //<< ; 24-Oct-2008   FIS     SR16058: No Decode Check if Encoded String is expected to be crypted
    //<< ;                           Check for Hieroglyphics changed (spec. chars >50% = hieroglyphics)
    //<< ; 23-Oct-2008   FIS     SR16058: Changed to work without Error catching
    //<< ; 21-Oct-2008   FIS     SR16058: Created
    //<< ;---------------------------------------------------------------------------------
    //<< new strTemp,blnIsBase64,idx,strTemp2
    mVar strTemp = m$.var("strTemp");
    mVar blnIsBase64 = m$.var("blnIsBase64");
    mVar idx = m$.var("idx");
    mVar strTemp2 = m$.var("strTemp2");
    m$.newVar(strTemp,blnIsBase64,idx,strTemp2);
    //<< 
    //<< set blnIsBase64 = $$$NO
    blnIsBase64.set(include.COMSYS.$$$NO(m$));
    //<< set pstrText    = $translate(pstrText,$char(10,13))  //kill CR/LF
    pstrText.set(m$.Fnc.$translate(pstrText.get(),m$.Fnc.$char(10,13)));
    //<< 
    //<< if (pstrText '= "") && ($length(pstrText)#4 = 0) {  //valid string length ?
    if ((mOp.NotEqual(pstrText.get(),"")) && (mOp.Equal(mOp.Modulus(m$.Fnc.$length(pstrText.get()),4),0))) {
      //<< 
      //<< set blnIsBase64 = $$$YES
      blnIsBase64.set(include.COMSYS.$$$YES(m$));
      //<< set strTemp     = pstrText
      strTemp.set(pstrText.get());
      //<< if ($extract(pstrText,$length(pstrText)-1,$length(pstrText)) = "==") {  //remove 0 bytes
      if ((mOp.Equal(m$.Fnc.$extract(pstrText.get(),mOp.Subtract(m$.Fnc.$length(pstrText.get()),1),m$.Fnc.$length(pstrText.get())),"=="))) {
        //<< set strTemp = $extract(pstrText,1,$length(pstrText)-2)
        strTemp.set(m$.Fnc.$extract(pstrText.get(),1,mOp.Subtract(m$.Fnc.$length(pstrText.get()),2)));
      }
      //<< 
      //<< } elseif ($extract(pstrText,$length(pstrText)) = "=") {        //remove 0 byte
      else if ((mOp.Equal(m$.Fnc.$extract(pstrText.get(),m$.Fnc.$length(pstrText.get())),"="))) {
        //<< set strTemp = $extract(pstrText,1,$length(pstrText)-1)
        strTemp.set(m$.Fnc.$extract(pstrText.get(),1,mOp.Subtract(m$.Fnc.$length(pstrText.get()),1)));
      }
      //<< }
      //<< for idx = 1:1:$length(strTemp) {                  //illegal value
      for (idx.set(1);(mOp.LessOrEqual(idx.get(),m$.Fnc.$length(strTemp.get())));idx.set(mOp.Add(idx.get(),1))) {
        //<< if '$find("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/",$extract(strTemp,idx)) {
        if (mOp.Not(m$.Fnc.$find("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/",m$.Fnc.$extract(strTemp.get(),idx.get())))) {
          //<< set blnIsBase64 = $$$NO
          blnIsBase64.set(include.COMSYS.$$$NO(m$));
          //<< quit
          break;
        }
      }
      //<< }
      //<< }
      //<< if (blnIsBase64 = $$$YES) && (pblnDblCrypt = $$$NO) {
      if ((mOp.Equal(blnIsBase64.get(),include.COMSYS.$$$YES(m$))) && (mOp.Equal(pblnDblCrypt.get(),include.COMSYS.$$$NO(m$)))) {
        //<< set strTemp = $system.Encryption.Base64Decode(pstrText)  //Verify Decode Result
        strTemp.set(m$.getSystem().getEncryption().Base64Decode(pstrText.get()));
        //<< if (strTemp '= "") {  //OriginalText Or Hieroglyphics  ?
        if ((mOp.NotEqual(strTemp.get(),""))) {
          //<< set strTemp2 = $translate(strTemp,"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ÜÄÖüäöß][\}{|~.,;:()@#$%^°&*-_=+<>?/´`'"_""""_$CHAR(128,10,13))
          strTemp2.set(m$.Fnc.$translate(strTemp.get(),mOp.Concat(mOp.Concat("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ÜÄÖüäöß][\\}{|~.,;:()@#$%^°&*-_=+<>?/´`'","\""),m$.Fnc.$char(128,10,13))));
          //<< if ($length(strTemp)-$length(strTemp2) '> 0) {
          if ((mOp.NotGreater(mOp.Subtract(m$.Fnc.$length(strTemp.get()),m$.Fnc.$length(strTemp2.get())),0))) {
            //<< set blnIsBase64 = $$$NO  //Not 1 useful character
            blnIsBase64.set(include.COMSYS.$$$NO(m$));
          }
          //<< 
          //<< } elseif ($length(strTemp2) > ($length(strTemp)/2)) {
          else if ((mOp.Greater(m$.Fnc.$length(strTemp2.get()),(mOp.Divide(m$.Fnc.$length(strTemp.get()),2))))) {
            //<< set blnIsBase64 = $$$NO  //more than 50% special characters = hieroglyphics
            blnIsBase64.set(include.COMSYS.$$$NO(m$));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit blnIsBase64
    return blnIsBase64.get();
  }

  //<< 
  //<< RebuildIndexes(pidClass)
  public Object RebuildIndexes(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;---------------------------------------------------------------------------------
    //<< ;---------------------------------------------------------------------------------
    //<< new idLog,strStatus,idClass
    mVar idLog = m$.var("idLog");
    mVar strStatus = m$.var("strStatus");
    mVar idClass = m$.var("idClass");
    m$.newVar(idLog,strStatus,idClass);
    //<< 
    //<< set idLog=""
    idLog.set("");
    //<< set strStatus=$$StartLog^COMLog($$DecodeError^COMUtilError($listbuild("Com00060",pidClass)),.idLog)  ; Reindexing classes starting with : %1
    strStatus.set(m$.fnc$("COMLog.StartLog",m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild("Com00060",pidClass.get())),idLog));
    //<< if pidClass="" {
    if (mOp.Equal(pidClass.get(),"")) {
      //<< set idClass=""
      idClass.set("");
    }
    //<< } else {
    else {
      //<< set idClass=$order(^WWW001(0,pidClass),-1)
      idClass.set(m$.Fnc.$order(m$.var("^WWW001",0,pidClass.get()),mOp.Negative(1)));
    }
    //<< }
    //<< 
    //<< for {
    for (;true;) {
      //<< set idClass=$order(^WWW001(0,idClass))
      idClass.set(m$.Fnc.$order(m$.var("^WWW001",0,idClass.get())));
      //<< quit:idClass=""
      if (mOp.Equal(idClass.get(),"")) {
        break;
      }
      //<< quit:$extract(idClass,1,$length(pidClass))'=pidClass
      if (mOp.NotEqual(m$.Fnc.$extract(idClass.get(),1,m$.Fnc.$length(pidClass.get())),pidClass.get())) {
        break;
      }
      //<< quit:strStatus'=$$$OK
      if (mOp.NotEqual(strStatus.get(),include.COMSYS.$$$OK(m$))) {
        break;
      }
      //<< 
      //<< set strStatus=$$AddMessage^COMLog(idLog,$$DecodeError^COMUtilError($listbuild("Com00061",idClass)))  ; Starting reindexing of class : %1
      strStatus.set(m$.fnc$("COMLog.AddMessage",idLog.get(),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild("Com00061",idClass.get()))));
      //<< do START1^WWWSORTGEN(idClass,0)
      m$.Cmd.Do("WWWSORTGEN.START1",idClass.get(),0);
    }
    //<< }
    //<< 
    //<< if strStatus=$$$OK set strStatus=$$AddMessage^COMLog(idLog,$$DecodeError^COMUtilError($listbuild("Com00062",pidClass)))  ; Reindexing complete for classes starting with : %1
    if (mOp.Equal(strStatus.get(),include.COMSYS.$$$OK(m$))) {
      strStatus.set(m$.fnc$("COMLog.AddMessage",idLog.get(),m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild("Com00062",pidClass.get()))));
    }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< GetNextNumber(pidClass,YLOCATION)
  public Object GetNextNumber(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YLOCATION = m$.newVarRef("YLOCATION",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;  WWW1280 : Sequence Number Data Input
    //<< ;-------------------------------------------------------------------------------
    //<< if (pidClass'="") && (YLOCATION'="") {
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(YLOCATION.get(),""))) {
      //<< if $get(^WWW1280(YM,pidClass,YLOCATION,1))="" {
      if (mOp.Equal(m$.Fnc.$get(m$.var("^WWW1280",m$.var("YM").get(),pidClass.get(),YLOCATION.get(),1)),"")) {
        //<< set ^WWW1280(YM,pidClass,YLOCATION,1)="LOCATION:0"
        m$.var("^WWW1280",m$.var("YM").get(),pidClass.get(),YLOCATION.get(),1).set("LOCATION:0");
      }
    }
    //<< }
    //<< }
    //<< quit $$^WWWNEXT(pidClass)
    return m$.fnc$("WWWNEXT.main",pidClass.get());
  }

  //<< 
  //<< DefaultSequenceNo()
  public Object DefaultSequenceNo(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;-------------------------------------------------------------------------------
    //<< new SeqNo
    mVar SeqNo = m$.var("SeqNo");
    m$.newVar(SeqNo);
    //<< 
    //<< ; try to use Site identifier
    //<< set SeqNo=$$getCurrentLocation^COMDCMUtilities()
    SeqNo.set(m$.fnc$("COMDCMUtilities.getCurrentLocation"));
    //<< if (SeqNo="") {
    if ((mOp.Equal(SeqNo.get(),""))) {
      //<< ; otherwise use Machine name
      //<< set SeqNo=$$^WWWUMLAU($zutil(110),1)
      SeqNo.set(m$.fnc$("WWWUMLAU.main",m$.Fnc.$zutil(110),1));
    }
    //<< }
    //<< set SeqNo=SeqNo_"0000000"
    SeqNo.set(mOp.Concat(SeqNo.get(),"0000000"));
    //<< 
    //<< quit SeqNo
    return SeqNo.get();
  }

  //<< 
  //<< GetIDPart(pstrGlobal,pintIndex)
  public Object GetIDPart(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintIndex = m$.newVarRef("pintIndex",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Function to extract the indexed component out of a global reference
    //<< ;
    //<< ; History:
    //<< ; 20-Jun-2003   shobby  Moved from SYSUtils
    //<< ; 02-Jun-2003   shobby  Creation
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ; TODO : Check if this is required - can use $QS / $QSUBSCRIPT
    //<< ;        The only difference is that $QS will strip any enclosing quotes
    //<< ;        while this routine passes them back.
    //<< ;        (can then check if +x'=x to wrap in quotes if required)
    //<< 
    //<< new strPart
    mVar strPart = m$.var("strPart");
    m$.newVar(strPart);
    //<< 
    //<< set strPart = $piece(pstrGlobal,"(",2)
    strPart.set(m$.Fnc.$piece(pstrGlobal.get(),"(",2));
    //<< set strPart = $extract(strPart,1,$length(strPart)-1)
    strPart.set(m$.Fnc.$extract(strPart.get(),1,mOp.Subtract(m$.Fnc.$length(strPart.get()),1)));
    //<< set strPart = $piece(strPart,",",pintIndex)
    strPart.set(m$.Fnc.$piece(strPart.get(),",",pintIndex.get()));
    //<< 
    //<< quit strPart
    return strPart.get();
  }

  //<< 
  //<< 
  //<< NotifyAdmin(pstrSource,pstrMsg)
  public Object NotifyAdmin(Object ... _p) {
    mVar pstrSource = m$.newVarRef("pstrSource",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrMsg = m$.newVarRef("pstrMsg",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Notify the Administrators with a message
    //<< ; optionally include a link to a form and key
    //<< ;
    //<< ; History:
    //<< ; 23-Mar-2007   GRF     SR15482: Use intLine and strNewLine with "<PRE>"
    //<< ; 21-Mar-2007   GRF     SR15482: replace to package message in ^WWWSOR
    //<< ; 21-Mar-2007   GRF     SR15046: Don't use default if no host is set up.
    //<< ; 20-Mar-2007   GRF     SR12293: use common function and restrict duplications
    //<< ; 20-Mar-2007   GRF     SR15478: Truncate Link message
    //<< ; 16-Oct-2006   JW      Added DEVMODE dump
    //<< ; 15-Mar-2005   Paul K  Added macro usage
    //<< ;-------------------------------------------------------------------------------
    //<< new arrEmail,idMessage,idUserAccess,idUser,intLine,intUser,lstUsers,objUser,strEmailAddr,strNewLine,strStatus,strSubject,YI
    mVar arrEmail = m$.var("arrEmail");
    mVar idMessage = m$.var("idMessage");
    mVar idUserAccess = m$.var("idUserAccess");
    mVar idUser = m$.var("idUser");
    mVar intLine = m$.var("intLine");
    mVar intUser = m$.var("intUser");
    mVar lstUsers = m$.var("lstUsers");
    mVar objUser = m$.var("objUser");
    mVar strEmailAddr = m$.var("strEmailAddr");
    mVar strNewLine = m$.var("strNewLine");
    mVar strStatus = m$.var("strStatus");
    mVar strSubject = m$.var("strSubject");
    mVar YI = m$.var("YI");
    m$.newVar(arrEmail,idMessage,idUserAccess,idUser,intLine,intUser,lstUsers,objUser,strEmailAddr,strNewLine,strStatus,strSubject,YI);
    //<< 
    //<< if $$$DEVMODE {
    if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
      //<< $$$Dump
      include.COMSYS.$$$Dump(m$);
    }
    //<< }
    //<< set strNewLine = "<BR>"
    strNewLine.set("<BR>");
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idMessage = $$Allocate^WWWMAILS()
    idMessage.set(m$.fnc$("WWWMAILS.Allocate"));
    //<< 
    //<< ; TODO : pstrMsg could be passed as actual strStatus list and then be converted
    //<< ;        to language-based text relevant to each recipient's specified language.  <GRF>
    //<< 
    //<< set intLine = 0
    intLine.set(0);
    //<< //SR15482: vvv
    //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine_"<PRE>"
    m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(mOp.Concat(strNewLine.get(),"<PRE>"));
    //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine_"Error occurred in "_pstrSource
    m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(mOp.Concat(mOp.Concat(strNewLine.get(),"Error occurred in "),pstrSource.get()));
    //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine
    m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(strNewLine.get());
    //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine_"Error returned is "_pstrMsg
    m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(mOp.Concat(mOp.Concat(strNewLine.get(),"Error returned is "),pstrMsg.get()));
    //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine
    m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(strNewLine.get());
    //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine_"     Host: "_$zutil(110)
    m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(mOp.Concat(mOp.Concat(strNewLine.get(),"     Host: "),m$.Fnc.$zutil(110)));
    //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine_"Namespace: "_$zutil(5)
    m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(mOp.Concat(mOp.Concat(strNewLine.get(),"Namespace: "),m$.Fnc.$zutil(5)));
    //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine_"     User: "_$get(YBED)
    m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(mOp.Concat(mOp.Concat(strNewLine.get(),"     User: "),m$.Fnc.$get(m$.var("YBED"))));
    //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine_"  Session: "_$get(YUSER)
    m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(mOp.Concat(mOp.Concat(strNewLine.get(),"  Session: "),m$.Fnc.$get(m$.var("YUSER"))));
    //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine_"     Time: "_$zdatetime($horolog)
    m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(mOp.Concat(mOp.Concat(strNewLine.get(),"     Time: "),m$.Fnc.$zdatetime(m$.Fnc.$horolog())));
    //<< //SR15482: ^^^
    //<< 
    //<< if ($get(YFORM)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),""))) {
      //<< set YI=$get(YAKTION)_"EP=WWWFORM&amp;YFORM="_YFORM_"&amp;YKEY="_$get(YKEY)
      YI.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YAKTION")),"EP=WWWFORM&amp;YFORM="),m$.var("YFORM").get()),"&amp;YKEY="),m$.Fnc.$get(m$.var("YKEY"))));
      //<< if ($get(YPARA)'="")  set YI=YI_"&amp;YPARA="_YPARA
      if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YPARA")),""))) {
        YI.set(mOp.Concat(mOp.Concat(YI.get(),"&amp;YPARA="),m$.var("YPARA").get()));
      }
      //<< if ($get(YSEITE)'="") set YI=YI_"&amp;YSEITE="_YSEITE
      if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YSEITE")),""))) {
        YI.set(mOp.Concat(mOp.Concat(YI.get(),"&amp;YSEITE="),m$.var("YSEITE").get()));
      }
      //<< do VAR^WWWCGI
      m$.Cmd.Do("WWWCGI.VAR");
      //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine_"       Link: "_YI
      m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(mOp.Concat(mOp.Concat(strNewLine.get(),"       Link: "),YI.get()));
    }
    //<< }
    //<< set ^WWWSOR(idMessage,$increment(intLine)) = strNewLine_"</PRE>"
    m$.var("^WWWSOR",idMessage.get(),m$.Fnc.$increment(intLine)).set(mOp.Concat(strNewLine.get(),"</PRE>"));
    //<< 
    //<< 
    //<< set strSubject = "Error Report from "_pstrSource
    strSubject.set(mOp.Concat("Error Report from ",pstrSource.get()));
    //<< 
    //<< ; Send to each administrator; once only to each e-mail address
    //<< set lstUsers=$$GetDataBaseAdministrator^COMUtilUser()
    lstUsers.set(m$.fnc$("COMUtilUser.GetDataBaseAdministrator"));
    //<< for intUser=1:1:$listlength(lstUsers) {
    for (intUser.set(1);(mOp.LessOrEqual(intUser.get(),m$.Fnc.$listlength(lstUsers.get())));intUser.set(mOp.Add(intUser.get(),1))) {
      //<< set idUser = $listget(lstUsers,intUser)
      idUser.set(m$.Fnc.$listget(lstUsers.get(),intUser.get()));
      //<< continue:idUser=""
      if (mOp.Equal(idUser.get(),"")) {
        continue;
      }
      //<< 
      //<< set objUser=$get(^WWW013(0,idUser,1))
      objUser.set(m$.Fnc.$get(m$.var("^WWW013",0,idUser.get(),1)));
      //<< set strEmailAddr = $$$WWW013EMailAddress($get(^WWW013(0,idUser,1)))
      strEmailAddr.set(include.WWWConst.$$$WWW013EMailAddress(m$,m$.Fnc.$get(m$.var("^WWW013",0,idUser.get(),1))));
      //<< if (strEmailAddr'="") {
      if ((mOp.NotEqual(strEmailAddr.get(),""))) {
        //<< if '$data(arrEmail(strEmailAddr)) {
        if (mOp.Not(m$.Fnc.$data(arrEmail.var(strEmailAddr.get())))) {
          //<< set arrEmail(strEmailAddr) = ""
          arrEmail.var(strEmailAddr.get()).set("");
          //<< set strStatus=$$PackageMail^WWWMAILS(idMessage,strSubject,strEmailAddr,$$$WWW013Name(objUser))
          strStatus.set(m$.fnc$("WWWMAILS.PackageMail",idMessage.get(),strSubject.get(),strEmailAddr.get(),include.WWWConst.$$$WWW013Name(m$,objUser)));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< do Deallocate^WWWMAILS(idMessage)
    m$.Cmd.Do("WWWMAILS.Deallocate",idMessage.get());
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< checkPatternMatch(pattern,value)
  public Object checkPatternMatch(Object ... _p) {
    mVar pattern = m$.newVarRef("pattern",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar value = m$.newVarRef("value",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; check whether the pattern matches the value
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2008   GRF     SR15787: Use Boolean Macros
    //<< ;-------------------------------------------------------------------------------
    //<< new match,tmpPattern,numWildcards,cnt
    mVar match = m$.var("match");
    mVar tmpPattern = m$.var("tmpPattern");
    mVar numWildcards = m$.var("numWildcards");
    mVar cnt = m$.var("cnt");
    m$.newVar(match,tmpPattern,numWildcards,cnt);
    //<< 
    //<< set match = $$$NO
    match.set(include.COMSYS.$$$NO(m$));
    //<< if (pattern'=value) {                             ; wildcard pattern
    if ((mOp.NotEqual(pattern.get(),value.get()))) {
      //<< set numWildcards = $length(pattern,"*")
      numWildcards.set(m$.Fnc.$length(pattern.get(),"*"));
      //<< set tmpPattern   = ""
      tmpPattern.set("");
      //<< for cnt = 1:1:numWildcards {
      for (cnt.set(1);(mOp.LessOrEqual(cnt.get(),numWildcards.get()));cnt.set(mOp.Add(cnt.get(),1))) {
        //<< set:(cnt'=1) tmpPattern=tmpPattern_".E"
        if ((mOp.NotEqual(cnt.get(),1))) {
          tmpPattern.set(mOp.Concat(tmpPattern.get(),".E"));
        }
        //<< if ($piece(pattern,"*",cnt)'="") {
        if ((mOp.NotEqual(m$.Fnc.$piece(pattern.get(),"*",cnt.get()),""))) {
          //<< set tmpPattern = tmpPattern_"1"""_$piece(pattern,"*",cnt)_""""
          tmpPattern.set(mOp.Concat(mOp.Concat(mOp.Concat(tmpPattern.get(),"1\""),m$.Fnc.$piece(pattern.get(),"*",cnt.get())),"\""));
        }
      }
      //<< }
      //<< }
      //<< if (value?@tmpPattern) {                      ; found a match
      if ((mOp.Match(value.get(),m$.indirectVar("tmpPattern").get()))) {
        //<< set match = $$$YES
        match.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set match = $$$YES                            ; direct match
      match.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< quit match
    return match.get();
  }

  //<< 
  //<< 
  //<< LastData(Form="",Piece="",Type="M")
  public Object LastData(Object ... _p) {
    mVar Form = m$.newVarRef("Form",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar Piece = m$.newVarRef("Piece",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar Type = m$.newVarRef("Type",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"M");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Last Data from ^WWWDATEN
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 05-Mar-2004   SCR     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Data,Date,User
    mVar Data = m$.var("Data");
    mVar Date = m$.var("Date");
    mVar User = m$.var("User");
    m$.newVar(Data,Date,User);
    //<< 
    //<< set Data=""
    Data.set("");
    //<< set Date=+$horolog
    Date.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< set User=$get(YUSER)
    User.set(m$.Fnc.$get(m$.var("YUSER")));
    //<< 
    //<< if Form="" set Form=" "
    if (mOp.Equal(Form.get(),"")) {
      Form.set(" ");
    }
    //<< if User="" set User=" "
    if (mOp.Equal(User.get(),"")) {
      User.set(" ");
    }
    //<< if Type="" set Type="M"
    if (mOp.Equal(Type.get(),"")) {
      Type.set("M");
    }
    //<< 
    //<< set Data=$piece($get(^WWWDATEN(YM,Date,User,Form,Type,1)),"~",Piece)
    Data.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),Date.get(),User.get(),Form.get(),Type.get(),1)),"~",Piece.get()));
    //<< 
    //<< if Data="" {
    if (mOp.Equal(Data.get(),"")) {
      //<< set Data=$piece($get(^WWWDATEN(YM,Date,User,Form,Type,2)),"~",Piece)
      Data.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),Date.get(),User.get(),Form.get(),Type.get(),2)),"~",Piece.get()));
    }
    //<< }
    //<< 
    //<< quit Data
    return Data.get();
  }

  //<< 
  //<< 
  //<< GetNumNodes(pstrRootNode,pintMax=1E16)
  public Object GetNumNodes(Object ... _p) {
    mVar pstrRootNode = m$.newVarRef("pstrRootNode",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintMax = m$.newVarRef("pintMax",(((_p!=null)&&(_p.length>=2))?_p[1]:null),Double.parseDouble("1E16"));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the number of data nodes of a particular subsript
    //<< ;
    //<< ; e.g. Pass in "^INAUFP(0,1234" would return the number of line in an order.
    //<< ;
    //<< ; Returns:Integer
    //<< ;
    //<< ; History:
    //<< ; 01-Feb-2006   RPW     SR13710: Removed the default value of 1000, please pass in the default
    //<< ; 27-Oct-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intCount,intLength,strSearchLoop
    mVar intCount = m$.var("intCount");
    mVar intLength = m$.var("intLength");
    mVar strSearchLoop = m$.var("strSearchLoop");
    m$.newVar(intCount,intLength,strSearchLoop);
    //<< 
    //<< set intCount=0
    intCount.set(0);
    //<< set intLength=$length(pstrRootNode)
    intLength.set(m$.Fnc.$length(pstrRootNode.get()));
    //<< set strSearchLoop=pstrRootNode_")"
    strSearchLoop.set(mOp.Concat(pstrRootNode.get(),")"));
    //<< 
    //<< for {
    for (;true;) {
      //<< set strSearchLoop=$query(@strSearchLoop)
      strSearchLoop.set(m$.Fnc.$query(m$.indirectVar(strSearchLoop.get())));
      //<< quit:$extract(strSearchLoop,1,intLength)'=pstrRootNode
      if (mOp.NotEqual(m$.Fnc.$extract(strSearchLoop.get(),1,intLength.get()),pstrRootNode.get())) {
        break;
      }
      //<< 
      //<< set intCount=intCount+1
      intCount.set(mOp.Add(intCount.get(),1));
      //<< quit:intCount=pintMax
      if (mOp.Equal(intCount.get(),pintMax.get())) {
        break;
      }
    }
    //<< }
    //<< 
    //<< if intCount=pintMax {
    if (mOp.Equal(intCount.get(),pintMax.get())) {
      //<< set intCount=intCount_"+"
      intCount.set(mOp.Concat(intCount.get(),"+"));
    }
    //<< }
    //<< 
    //<< quit intCount
    return intCount.get();
  }

  //<< 
  //<< 
  //<< UserHasAccess(pstrUserID,pstrAccessLevels,pstrDelim=";",pblnDefault=$$$YES)
  public Object UserHasAccess(Object ... _p) {
    mVar pstrUserID = m$.newVarRef("pstrUserID",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrAccessLevels = m$.newVarRef("pstrAccessLevels",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrDelim = m$.newVarRef("pstrDelim",(((_p!=null)&&(_p.length>=3))?_p[2]:null),";");
    mVar pblnDefault = m$.newVarRef("pblnDefault",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Given a user name and string of access codes (semi-colon delimited), does
    //<< ; this user have the given access levels?
    //<< ;
    //<< ; pstrUserID       : The User ID we are checking (eg, STEVES, MARIA, SHOBBY, etc.)
    //<< ; pstrAccessLevels : The string of access levels to check this user for (eg, 1;3;5).
    //<< ;
    //<< ; if pstrUserID is not passed in, defaults to the current user (the YBED variable.)
    //<< ;
    //<< ; Returns: boolean ($$$YES/$$$NO)
    //<< ;
    //<< ; History:
    //<< ; 10-Spe-2012   SCR     SR18112: Add Default parameter
    //<< ; 26-Jul-2007   GRF     SRBR014575: Replace idx with loop!
    //<< ; 15-Sep-2005   SS / JW SR13502: Only match one access level
    //<< ; 31-Jan-2005   Steve S Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnHasAccess,idUser,strViewAccess,objUser,strUserAccess,loop,strAccess
    mVar blnHasAccess = m$.var("blnHasAccess");
    mVar idUser = m$.var("idUser");
    mVar strViewAccess = m$.var("strViewAccess");
    mVar objUser = m$.var("objUser");
    mVar strUserAccess = m$.var("strUserAccess");
    mVar loop = m$.var("loop");
    mVar strAccess = m$.var("strAccess");
    m$.newVar(blnHasAccess,idUser,strViewAccess,objUser,strUserAccess,loop,strAccess);
    //<< 
    //<< ;set blnHasAccess=$$$NO
    //<< set blnHasAccess=pblnDefault ;SR18112
    blnHasAccess.set(pblnDefault.get());
    //<< 
    //<< set idUser=$get(pstrUserID)
    idUser.set(m$.Fnc.$get(pstrUserID));
    //<< if idUser="" set idUser=$get(YBED)
    if (mOp.Equal(idUser.get(),"")) {
      idUser.set(m$.Fnc.$get(m$.var("YBED")));
    }
    //<< 
    //<< set strViewAccess=$get(pstrAccessLevels)
    strViewAccess.set(m$.Fnc.$get(pstrAccessLevels));
    //<< 
    //<< if (idUser'="") {
    if ((mOp.NotEqual(idUser.get(),""))) {
      //<< if strViewAccess="" {
      if (mOp.Equal(strViewAccess.get(),"")) {
        //<< ;set blnHasAccess=$$$YES
        //<< set blnHasAccess=pblnDefault ;SR18112
        blnHasAccess.set(pblnDefault.get());
      }
      //<< } else {
      else {
        //<< set objUser=$get(^WWW013(0,idUser,1))
        objUser.set(m$.Fnc.$get(m$.var("^WWW013",0,idUser.get(),1)));
        //<< set strUserAccess=$translate($$$WWW013UserAccess(objUser),";",pstrDelim)
        strUserAccess.set(m$.Fnc.$translate(include.WWWConst.$$$WWW013UserAccess(m$,objUser),";",pstrDelim.get()));
        //<< set strViewAccess = pstrDelim_strViewAccess_pstrDelim
        strViewAccess.set(mOp.Concat(mOp.Concat(pstrDelim.get(),strViewAccess.get()),pstrDelim.get()));
        //<< 
        //<< for loop=1:1:$length(strUserAccess,pstrDelim) {
        for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strUserAccess.get(),pstrDelim.get())));loop.set(mOp.Add(loop.get(),1))) {
          //<< quit:(blnHasAccess)
          if (mOp.Logical((blnHasAccess.get()))) {
            break;
          }
          //<< 
          //<< set strAccess=$piece(strUserAccess,pstrDelim,loop)
          strAccess.set(m$.Fnc.$piece(strUserAccess.get(),pstrDelim.get(),loop.get()));
          //<< if $find(strViewAccess,pstrDelim_strAccess_pstrDelim) {
          if (mOp.Logical(m$.Fnc.$find(strViewAccess.get(),mOp.Concat(mOp.Concat(pstrDelim.get(),strAccess.get()),pstrDelim.get())))) {
            //<< set blnHasAccess=$$$YES ;One match is sufficient
            blnHasAccess.set(include.COMSYS.$$$YES(m$));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit blnHasAccess
    return blnHasAccess.get();
  }

  //<< 
  //<< 
  //<< PopulateComboBox(pstrForm, pstrFieldNumber, pstrValue="", pstrFieldType="D", pstrRelationClass, pstrRelationKeys="",pstrFilter="") ;CORE-114
  public Object PopulateComboBox(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrFieldNumber = m$.newVarRef("pstrFieldNumber",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstrFieldType = m$.newVarRef("pstrFieldType",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"D");
    mVar pstrRelationClass = m$.newVarRef("pstrRelationClass",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pstrRelationKeys = m$.newVarRef("pstrRelationKeys",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    mVar pstrFilter = m$.newVarRef("pstrFilter",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; This method is used to change a Datafield into a Combo Box. The options for
    //<< ; the combo box will be based on the relation class and on the relation primary
    //<< ; keys. This works exactly like on the relation of the data field definition.
    //<< ;
    //<< ; Params:   pstrForm                    - form name
    //<< ;           pstrFieldNumber             - manual or data field number
    //<< ;           pstrValue                   - value to be stored in field
    //<< ;           pstrFieldType               - field type - "M" or "D"
    //<< ;           pstrRelationClass           - the relation class used to build the combo
    //<< ;           pstrRelationKeys    - the relation primary keys used together with the relation class
    //<< ;
    //<< ; History:
    //<< ; 29-May-2013   shobby  CORE-114: New 'Filter' field to limit results collected by 'Rules'
    //<< ; 27-May-2013   shobby  CORE-110: Limit list based on conditions.
    //<< ; 26-Jul-2007   GRF     SRBR014575: Replace unnecessary indirect reference;
    //<< ;                           replace idx with loop and increment as part of FOR
    //<< ;                           command; replace objRecord with strData.
    //<< ; 18-Jul-2007   Frank   SRBR014575: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idCompany,loop,objClass,strClassDef,strClassLoop,strCommand,strData,strYField
    mVar idClass = m$.var("idClass");
    mVar idCompany = m$.var("idCompany");
    mVar loop = m$.var("loop");
    mVar objClass = m$.var("objClass");
    mVar strClassDef = m$.var("strClassDef");
    mVar strClassLoop = m$.var("strClassLoop");
    mVar strCommand = m$.var("strCommand");
    mVar strData = m$.var("strData");
    mVar strYField = m$.var("strYField");
    m$.newVar(idClass,idCompany,loop,objClass,strClassDef,strClassLoop,strCommand,strData,strYField);
    //<< new intLine,blnAdd,YKEY ;CORE-110.1 ;CORE-114
    mVar intLine = m$.var("intLine");
    mVar blnAdd = m$.var("blnAdd");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(intLine,blnAdd,YKEY);
    //<< 
    //<< set strYField = "Y"_pstrForm_pstrFieldType_pstrFieldNumber
    strYField.set(mOp.Concat(mOp.Concat(mOp.Concat("Y",pstrForm.get()),pstrFieldType.get()),pstrFieldNumber.get()));
    //<< 
    //<< set objClass = $get(^WWW001(0,pstrRelationClass,1))
    objClass.set(m$.Fnc.$get(m$.var("^WWW001",0,pstrRelationClass.get(),1)));
    //<< if +$$$WWW001SharedFile(objClass) {
    if (mOp.Logical(mOp.Positive(include.WWWConst.$$$WWW001SharedFile(m$,objClass)))) {
      //<< set idCompany = 0
      idCompany.set(0);
    }
    //<< } else {
    else {
      //<< set idCompany = YM
      idCompany.set(m$.var("YM").get());
    }
    //<< }
    //<< 
    //<< // If the user set the primary keys for the relation database.
    //<< if pstrRelationKeys '= "" {
    if (mOp.NotEqual(pstrRelationKeys.get(),"")) {
      //<< set pstrRelationKeys=$$^WWWKEYBUILD(pstrRelationKeys)
      pstrRelationKeys.set(m$.fnc$("WWWKEYBUILD.main",pstrRelationKeys.get()));
      //<< set strClassDef = "^"_pstrRelationClass_"("_idCompany_","_pstrRelationKeys_",idClass"
      strClassDef.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",pstrRelationClass.get()),"("),idCompany.get()),","),pstrRelationKeys.get()),",idClass"));
    }
    //<< 
    //<< } else {
    else {
      //<< set strClassDef = "^"_pstrRelationClass_"("_idCompany_",idClass"
      strClassDef.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",pstrRelationClass.get()),"("),idCompany.get()),",idClass"));
    }
    //<< }
    //<< set strClassLoop = "set idClass = $order("_strClassDef_"))"
    strClassLoop.set(mOp.Concat(mOp.Concat("set idClass = $order(",strClassDef.get()),"))"));
    //<< // Get the values to be populated.
    //<< write "var arrValues = new Array();"
    m$.Cmd.Write("var arrValues = new Array();");
    //<< write "var arrKeys = new Array();"
    m$.Cmd.Write("var arrKeys = new Array();");
    //<< set idClass = ""
    idClass.set("");
    //<< set intLine=-1                                                                            ;CORE-110.1
    intLine.set(mOp.Negative(1));
    //<< for loop=0:1 {
    for (loop.set(0);(true);loop.set(mOp.Add(loop.get(),1))) {
      //<< xecute strClassLoop
      m$.Cmd.Xecute(strClassLoop.get());
      //<< quit:idClass=""
      if (mOp.Equal(idClass.get(),"")) {
        break;
      }
      //<< set blnAdd=$$$YES ;CORE-114
      blnAdd.set(include.COMSYS.$$$YES(m$));
      //<< if $extract(pstrFilter)="@" {
      if (mOp.Equal(m$.Fnc.$extract(pstrFilter.get()),"@")) {
        //<< set YKEY=idClass
        YKEY.set(idClass.get());
        //<< xecute "set blnAdd="_$extract(pstrFilter,2,$length(pstrFilter))
        m$.Cmd.Xecute(mOp.Concat("set blnAdd=",m$.Fnc.$extract(pstrFilter.get(),2,m$.Fnc.$length(pstrFilter.get()))));
      }
      //<< }
      //<< if blnAdd { ;CORE-110.1 ;CORE-114
      if (mOp.Logical(blnAdd.get())) {
        //<< set intLine=$increment(intLine)                                                   ;CORE-110.1
        intLine.set(m$.Fnc.$increment(intLine));
        //<< set strData    = ""
        strData.set("");
        //<< set strCommand = "set strData = $piece($get("_strClassDef_",1)),Y,1)"
        strCommand.set(mOp.Concat(mOp.Concat("set strData = $piece($get(",strClassDef.get()),",1)),Y,1)"));
        //<< xecute strCommand
        m$.Cmd.Xecute(strCommand.get());
        //<< 
        //<< ; TODO Don't display primary key if checked off.
        //<< write "arrValues["_intLine_"] = '"_idClass_" - "_$zconvert(strData,"o","JS")_"';" ;CORE-110.1
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("arrValues[",intLine.get()),"] = '"),idClass.get())," - "),m$.Fnc.$zconvert(strData.get(),"o","JS")),"';"));
        //<< write "arrKeys["_intLine_"] = '"_idClass_"';"                                     ;CORE-110.1
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("arrKeys[",intLine.get()),"] = '"),idClass.get()),"';"));
      }
    }
    //<< }
    //<< }
    //<< write "PopulateComboBox('"_pstrRelationClass_"','"_pstrRelationKeys_"','"_YHTMFORM_"','"_strYField_"',arrValues,arrKeys,'"_pstrValue_"');"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("PopulateComboBox('",pstrRelationClass.get()),"','"),pstrRelationKeys.get()),"','"),m$.var("YHTMFORM").get()),"','"),strYField.get()),"',arrValues,arrKeys,'"),pstrValue.get()),"');"));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PopulateDataField(pstrForm,pstrFieldNumber,pstrValue,pstrFieldType="D",&pYFELD="",pblnDoEvent=$$$YES)
  public Object PopulateDataField(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrFieldNumber = m$.newVarRef("pstrFieldNumber",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrFieldType = m$.newVarRef("pstrFieldType",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"D");
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pblnDoEvent = m$.newVarRef("pblnDoEvent",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; NOTE: Please try and use this method with pblnDoEvent=$$$NO because the aim
    //<< ; will be to remove the call to EventValue!!
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Populate a data field with any data so that it will be "modified" allowing
    //<< ; the save data to work.
    //<< ; E.g. Pass in "FINAPInv",26,"Robert Wuttke" would update the field
    //<< ;       YFINAPInvD26 with the value Robert Wuttke
    //<< ;
    //<< ; Params:   pstrForm        - form name
    //<< ;           pstrFieldNumber - manual or data field number
    //<< ;           pstrValue       - value to be stored in field
    //<< ;           pstrFieldType   - field type - "M" or "D"
    //<< ;           pYFELD          - can update pYFELD with value as well (reference)
    //<< ;           pblnDoEvent     - $$$YES - do call WWWEVENT which does OnBlurs etc
    //<< ;                             $$$NO - just store and display - no event.
    //<< ;
    //<< ;           Note: In the future, it may be appropriate to remove the parameter
    //<< ;           pblnDoEvent, and never do the event.
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; Caveat: Currently only works for text/memo fields.
    //<< ;
    //<< ; History:
    //<< ; 30-Apr-2013   shobby  CORE-88: Reset _oldvalue to detect later changes by user entry.
    //<< ; 08-Nov-2012   shobby  SR18182: WWW2 could now be a DIV not a FORM.
    //<< ; 21-Jun-2012   shobby  SR18026: Call to Fieldsize on type 7. Commented added 21-Sep to aid in patching.
    //<< ; 23-May-2012   shobby  SR18016: Optionally blur from the updated control when Manual Field
    //<< ; 07-Jan-2011   GRF     SR17579: Use explicit tag for WWWTR calls
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 31-Jan-2008   shobby  SRBR014861: Correct the screen update values.
    //<< ; 22-Aug-2007   shobby  SRBR014618: Get a value for YDECIMALLEN (Used in WWWTR)
    //<< ;  9-Dec-2005   JW      SR13195: Removed unecessary call
    //<< ; 03-Nov-2005   RPW     SR13085: Make the manual field update the pYFELD parameter
    //<< ;                       as well. Useful for YMFELD
    //<< ; 17-Jun-2005   PO      Only use AmountForCurrentMode if type is currency
    //<< ; 15-Jun-2005   PO      SR:12626 Display right currency form forms current mode
    //<< ; 09-Jun-2005   shobby  Display the save changes message.  SR12408
    //<< ;  9-May-2005   JW      SR12309 - pblnDoEvent param added
    //<< ;  4-Mar-2005   JW      Change pstrClass to pstrForm. Get Class.
    //<< ;                       Convert the value for display
    //<< ; 03-Mar-2005   Paul K  Modified to use with YES/NO fields.
    //<< ; 18-Feb-2005   JW      Use pstrClass instead of YFORM. Save to YMFELD.
    //<< ; 28-Dec-2004   RW      Created (SR10061)
    //<< ;-------------------------------------------------------------------------------
    //<< new class,showVal,strModifier,strYField,type,YDECIMALLEN
    mVar _class = m$.var("_class");
    mVar showVal = m$.var("showVal");
    mVar strModifier = m$.var("strModifier");
    mVar strYField = m$.var("strYField");
    mVar type = m$.var("type");
    mVar YDECIMALLEN = m$.var("YDECIMALLEN");
    m$.newVar(_class,showVal,strModifier,strYField,type,YDECIMALLEN);
    //<< 
    //<< quit:pstrForm=""
    if (mOp.Equal(pstrForm.get(),"")) {
      return null;
    }
    //<< 
    //<< set class = $$$WWW120ClassUsedInForm($get(^WWW120(0,pstrForm,1)))
    _class.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,pstrForm.get(),1))));
    //<< 
    //<< set YDECIMALLEN=$$^WWWDECIMALLEN(pstrForm,pstrFieldNumber)
    YDECIMALLEN.set(m$.fnc$("WWWDECIMALLEN.main",pstrForm.get(),pstrFieldNumber.get()));
    //<< 
    //<< set strModifier="value"
    strModifier.set("value");
    //<< set type = $$$WWW003InputType($$GetRelation^COMViewUtils(class,pstrFieldType_pstrFieldNumber,pstrForm))
    type.set(include.WWWConst.$$$WWW003InputType(m$,m$.fnc$("COMViewUtils.GetRelation",_class.get(),mOp.Concat(pstrFieldType.get(),pstrFieldNumber.get()),pstrForm.get())));
    //<< if (type = 2) {  ;yes/no field
    if ((mOp.Equal(type.get(),2))) {
      //<< set strModifier="checked"
      strModifier.set("checked");
      //<< if pstrValue {
      if (mOp.Logical(pstrValue.get())) {
        //<< set showVal="true"
        showVal.set("true");
      }
      //<< } else {
      else {
        //<< set showVal="false"
        showVal.set("false");
      }
    }
    //<< }
    //<< } elseif type = 8 {
    else if (mOp.Equal(type.get(),8)) {
      //<< set showVal = "'"_$zconvert($$GetLiteral^WWWTR(type,$$AmountForCurrentMode^COMUtilCurrency(pstrValue,pstrForm)),"o","JS")_"'" ; Set display value.
      showVal.set(mOp.Concat(mOp.Concat("'",m$.Fnc.$zconvert(m$.fnc$("WWWTR.GetLiteral",type.get(),m$.fnc$("COMUtilCurrency.AmountForCurrentMode",pstrValue.get(),pstrForm.get())),"o","JS")),"'"));
    }
    //<< } elseif type =7  {
    else if (mOp.Equal(type.get(),7)) {
      //<< set showVal = "'"_$zconvert($$FieldSize(pstrForm,pstrFieldNumber,$$GetLiteral^WWWTR(type,pstrValue)),"o","JS")_"'" ; Set display value.
      showVal.set(mOp.Concat(mOp.Concat("'",m$.Fnc.$zconvert(m$.fnc$("FieldSize",pstrForm.get(),pstrFieldNumber.get(),m$.fnc$("WWWTR.GetLiteral",type.get(),pstrValue.get())),"o","JS")),"'"));
    }
    //<< } else {
    else {
      //<< set showVal = "'"_$zconvert($$GetLiteral^WWWTR(type,pstrValue),"o","JS")_"'" ; Set display value.
      showVal.set(mOp.Concat(mOp.Concat("'",m$.Fnc.$zconvert(m$.fnc$("WWWTR.GetLiteral",type.get(),pstrValue.get()),"o","JS")),"'"));
    }
    //<< }
    //<< 
    //<< set strYField="Y"_pstrForm_pstrFieldType_pstrFieldNumber
    strYField.set(mOp.Concat(mOp.Concat(mOp.Concat("Y",pstrForm.get()),pstrFieldType.get()),pstrFieldNumber.get()));
    //<< ;set blnNotInHyperEvent = $$$NO
    //<< ;if '$$$InHyperEvent {
    //<< ;   set blnNotInHyperEvent = $$$YES
    //<< ;   write "<script type='text/javascript'><!--"_$$$CRLF
    //<< ;}
    //<< ;SR18182 write "document.WWW2."_strYField_"."_strModifier_"="_showVal_";" ; TODO: **** if save server data not checked on form then WWW2 form will not exist, could this ever be a problem ? should YHTMFORM be used instead. ****
    //<< write "document.getElementById('"_strYField_"')."_strModifier_"="_showVal_";" ;SR18182 :Should fix previous comment.
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('",strYField.get()),"')."),strModifier.get()),"="),showVal.get()),";"));
    //<< write "document.getElementById('"_strYField_"').setAttribute('_oldValue','"_$$$JSText(showVal)_"');" ;CORE-88
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('",strYField.get()),"').setAttribute('_oldValue','"),include.COMSYSString.$$$JSText(m$,showVal)),"');"));
    //<< ;if blnNotInHyperEvent {
    //<< ;   write $$$CRLF_"//-->"_$$$CRLF_"</script>"
    //<< ;}
    //<< 
    //<< ; This line is the onblur event on the field which enables the data to be saved.
    //<< 
    //<< if pstrFieldType="M" {
    if (mOp.Equal(pstrFieldType.get(),"M")) {
      //<< set $piece(^WWWDATEN(YM,+$horolog,YUSER,pstrForm,"M",1),Y,pstrFieldNumber) = pstrValue
      m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pstrForm.get(),"M",1),m$.var("Y").get(),pstrFieldNumber.get()).set(pstrValue.get());
      //<< set $piece(pYFELD,Y,pstrFieldNumber)=pstrValue ; SR13085
      m$.pieceVar(pYFELD,m$.var("Y").get(),pstrFieldNumber.get()).set(pstrValue.get());
      //<< if pblnDoEvent {
      if (mOp.Logical(pblnDoEvent.get())) {
        //<< write "EventValue('"_YUCI_"','"_YUSER_"','"_pstrForm_"','FIX','"_strYField_"','"_pstrValue_"','2','NOVALUE');"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),pstrForm.get()),"','FIX','"),strYField.get()),"','"),pstrValue.get()),"','2','NOVALUE');"));
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set $piece(pYFELD,Y,pstrFieldNumber)=pstrValue
      m$.pieceVar(pYFELD,m$.var("Y").get(),pstrFieldNumber.get()).set(pstrValue.get());
      //<< 
      //<< if pblnDoEvent {
      if (mOp.Logical(pblnDoEvent.get())) {
        //<< ;   write "EventValue('"_YUCI_"','"_YUSER_"','"_YFORM_"','FIX"_YKEY_"','"_strYField_"','"_$zconvert(pstrValue,"o","JS")_"','2','NOVALUE');"
        //<< 
        //<< ;BR014861 vvv To rollback replace 2nd line with first line
        //<< ;   write "EventValue('"_YUCI_"','"_YUSER_"','"_pstrForm_"','FIX"_YKEY_"','"_strYField_"','"_$zconvert(pstrValue,"o","JS")_"','2','NOVALUE');"
        //<< write "EventValue('"_YUCI_"','"_YUSER_"','"_pstrForm_"','FIX"_YKEY_"','"_strYField_"',"_showVal_",'2','NOVALUE');"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("EventValue('",m$.var("YUCI").get()),"','"),m$.var("YUSER").get()),"','"),pstrForm.get()),"','FIX"),m$.var("YKEY").get()),"','"),strYField.get()),"',"),showVal.get()),",'2','NOVALUE');"));
      }
      //<< ;BR014861 ^^^
      //<< 
      //<< ;The following line can replace the line above and is guaranteed to be relative to the current page displayed.
      //<< ;write "with (document.WWW) { EventValue(YUCI.value,YUSER.value,'"_pstrForm_"','FIX"_YKEY_"','"_strYField_"','"_$zconvert(pstrValue,"o","JS")_"','2','NOVALUE'); }"
      //<< } else {
      else {
        //<< set $piece(^WWWDATEN(YM,+$horolog,YUSER,pstrForm,"D",1),Y,pstrFieldNumber) = pstrValue
        m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pstrForm.get(),"D",1),m$.var("Y").get(),pstrFieldNumber.get()).set(pstrValue.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< FieldSize(YFORM,YBBN,pstrValue)
  public Object FieldSize(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YBBN = m$.newVarRef("YBBN",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Limits the returned result to the specified length
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Jun-2012   shobby      SR18026: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strValue,objWWW122
    mVar strValue = m$.var("strValue");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(strValue,objWWW122);
    //<< 
    //<< set objWWW122=$$Get^WWW122(YFORM,YBBN)
    objWWW122.set(m$.fnc$("WWW122.Get",YFORM.get(),YBBN.get()));
    //<< if $$$WWW122FieldSize(objWWW122)'="" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW122FieldSize(m$,objWWW122),"")) {
      //<< set pstrValue=$extract(pstrValue,1, $$$WWW122FieldSize(objWWW122)) ;SR18026
      pstrValue.set(m$.Fnc.$extract(pstrValue.get(),1,include.WWWConst.$$$WWW122FieldSize(m$,objWWW122)));
    }
    //<< }
    //<< quit pstrValue
    return pstrValue.get();
  }

  //<< 
  //<< 
  //<< UpdateFieldFormat(pstrObjectName,pstrPropertyName,pstrValue="")
  public Object UpdateFieldFormat(Object ... _p) {
    mVar pstrObjectName = m$.newVarRef("pstrObjectName",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrPropertyName = m$.newVarRef("pstrPropertyName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update a data field format. Pass in the fully formed field, ie YFINAPInvD1
    //<< ; and the object, ie style.backgroundColor and then the value.
    //<< ;
    //<< ;       js function "PrepareUpdate" is defined in WWWFORM8
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 24-Jun-2010   SCR     SR17348: Quit if Mobile (PDA)
    //<< ; 27-Apr-2007   RPW     SRBR014310: Make the updates just a single call to a javascript function
    //<< ; 09-Apr-2007   shobby  SRBR014409:Stringent checking to see if the object exists.
    //<< ;                       TODO:To improve performance move this testing in to the UpdateFieldFormat function.
    //<< ; 08-Sep-2005   shobby  SR13455: Watched JW put in a YHTMFORM test.
    //<< ; 13-Jul-2005   JW      SR12615: Use YHTMFORM. Call function if not true/false
    //<< ; 15-Mar-2005   JW      Added pString parameter - to add quotes.
    //<< ; 03-Jan-2005   RobW    Created (SR10061)
    //<< ;-------------------------------------------------------------------------------
    //<< quit:($get(pstrPropertyName)="")||(pstrObjectName="")||($get(YHTMFORM)="")
    if ((mOp.Equal(m$.Fnc.$get(pstrPropertyName),"")) || (mOp.Equal(pstrObjectName.get(),"")) || (mOp.Equal(m$.Fnc.$get(m$.var("YHTMFORM")),""))) {
      return null;
    }
    //<< if ($get(%request)'="") && $find($get(%request.CgiEnvs("HTTP_USER_AGENT")),"Windows CE") {  ;SR17348
    if ((mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),"")) && mOp.Logical(m$.Fnc.$find(m$.Fnc.$get(m$.getRequest().getCgiEnvs("HTTP_USER_AGENT")),"Windows CE"))) {
      //<< quit
      return null;
    }
    //<< }
    //<< ;TODO Should have some sort of caching here... don't write to the screen if nothing has changed.
    //<< ;if YBED["SHOBBY" set ^zzSCH($i(^zzSCH))="PrepareUpdate('"_YHTMFORM_"','"_pstrObjectName_"','"_pstrPropertyName_"','"_pstrValue_"');"
    //<< write "PrepareUpdate('"_YHTMFORM_"','"_pstrObjectName_"','"_pstrPropertyName_"','"_pstrValue_"');"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("PrepareUpdate('",m$.var("YHTMFORM").get()),"','"),pstrObjectName.get()),"','"),pstrPropertyName.get()),"','"),pstrValue.get()),"');"));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ResetFieldFormat(pstrObjectName,pstrPropertyName)
  public Object ResetFieldFormat(Object ... _p) {
    mVar pstrObjectName = m$.newVarRef("pstrObjectName",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrPropertyName = m$.newVarRef("pstrPropertyName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Reset a data field format. Pass in the fully formed field, ie YFINAPInvD1
    //<< ; and the object, ie style.backgroundColor and then the value.
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 24-Jun-2010   SCR     SR17348: Quit if Mobile (PDA)
    //<< ; 08-Sep-2005   shobby  SR13455: Don't write when redrawing form, YHTMFORM is not defined.
    //<< ; 13-Jul-2005   JW      SR12615: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit:pstrPropertyName=""
    if (mOp.Equal(pstrPropertyName.get(),"")) {
      return null;
    }
    //<< quit:pstrObjectName=""
    if (mOp.Equal(pstrObjectName.get(),"")) {
      return null;
    }
    //<< quit:$get(YHTMFORM)="" ;SR13455
    if (mOp.Equal(m$.Fnc.$get(m$.var("YHTMFORM")),"")) {
      return null;
    }
    //<< 
    //<< $$$LogR("ResetFieldFormat",pstrObjectName_"<"_pstrPropertyName_"<")
    $$$LogR(m$,"ResetFieldFormat",mOp.Concat(mOp.Concat(mOp.Concat(pstrObjectName.get(),"<"),pstrPropertyName.get()),"<"));
    //<< 
    //<< if ($get(%request)'="") && $find($get(%request.CgiEnvs("HTTP_USER_AGENT")),"Windows CE") { ; SR17348
    if ((mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),"")) && mOp.Logical(m$.Fnc.$find(m$.Fnc.$get(m$.getRequest().getCgiEnvs("HTTP_USER_AGENT")),"Windows CE"))) {
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< write "ResetFieldFormat('document."_YHTMFORM_"."_pstrObjectName_"','"_pstrPropertyName_"'); "
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ResetFieldFormat('document.",m$.var("YHTMFORM").get()),"."),pstrObjectName.get()),"','"),pstrPropertyName.get()),"'); "));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< writeOutScript(strScript="",strScriptType="type='text/javascript'")
  public Object writeOutScript(Object ... _p) {
    mVar strScript = m$.newVarRef("strScript",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar strScriptType = m$.newVarRef("strScriptType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"type='text/javascript'");
    //<< ;-------------------------------------------------------------------------------
    //<< ; TODO: Use attachEvent instead of dodgy setTimeout
    //<< ; SR11188
    //<< ;-------------------------------------------------------------------------------
    //<< write "<script "_strScriptType_"><!--",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<script ",strScriptType.get()),"><!--"),"\n");
    //<< write "function pjoAfterFormLoad() {",!
    m$.Cmd.Write("function pjoAfterFormLoad() {","\n");
    //<< write strScript,!
    m$.Cmd.Write(strScript.get(),"\n");
    //<< write "}",!
    m$.Cmd.Write("}","\n");
    //<< write "window.setTimeout('pjoAfterFormLoad()',500);",!
    m$.Cmd.Write("window.setTimeout('pjoAfterFormLoad()',500);","\n");
    //<< ;write "document.body.attachEvent('onload',pjoAfterFormLoad);",!
    //<< write "// -->",!
    m$.Cmd.Write("// -->","\n");
    //<< write "</script>",!
    m$.Cmd.Write("</script>","\n");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ExecuteCode(pstrCode)
  public Object ExecuteCode(Object ... _p) {
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Attempt to execute the code and log an error on failure.
    //<< ;
    //<< ; Frequent attempts to check subroutines that are validly not present so don't
    //<< ; record those of them as errors.  Would be nice to distinguish between real
    //<< ; errors and expected "not found".
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-May-2007   GRF     SR15508: Make sure this error handler is called.
    //<< ;  6-Oct-2005   JW      SR11573: Quit with "exists" boolean
    //<< ; 15-Feb-2005   RobertW Do not log NOLINE errors at all.
    //<< ; 03-Feb-2005   RobertW Modified to show the error on the screen except for
    //<< ;                           NOLINE or NOROUTINE errors
    //<< ; 28-Jan-2005   RobertW Created (SR10061)
    //<< ;-------------------------------------------------------------------------------
    //<< set $ztrap="ExecuteCodeError^COMUtils"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("ExecuteCodeError^COMUtils");
    //<< xecute pstrCode
    m$.Cmd.Xecute(pstrCode.get());
    //<< quit $$$YES
    return include.COMSYS.$$$YES(m$);
  }

  //<< 
  //<< ///ExecuteCodeError  ; Internal Tag
  //<< ExecuteCodeError()  ; Internal Tag
  public Object ExecuteCodeError(Object ... _p) {
    //<< new blnExists,strError,strUser
    mVar blnExists = m$.var("blnExists");
    mVar strError = m$.var("strError");
    mVar strUser = m$.var("strUser");
    m$.newVar(blnExists,strError,strUser);
    //<< 
    //<< set $ztrap=""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< 
    //<< set strError=$zerror
    strError.set(m$.Fnc.$zerror());
    //<< 
    //<< if '$find(strError,"<NOLINE>") && '$find(strError,"<NOROUTINE>") {
    if (mOp.Not(m$.Fnc.$find(strError.get(),"<NOLINE>")) && mOp.Not(m$.Fnc.$find(strError.get(),"<NOROUTINE>"))) {
      //<< set blnExists = $$$YES
      blnExists.set(include.COMSYS.$$$YES(m$));
      //<< 
      //<< if ($get(^DebugExecuteCode,0)'=0) {   ; SR16315 moved up
      if ((mOp.NotEqual(m$.Fnc.$get(m$.var("^DebugExecuteCode"),0),0))) {
        //<< set strUser = $get(YBED,"UNKNOWN")
        strUser.set(m$.Fnc.$get(m$.var("YBED"),"UNKNOWN"));
        //<< set ^ExecuteCodeError(strUser,$increment(^ExecuteCodeError(strUser)),$zdatetime($horolog,3),"Code")  = pstrCode
        m$.var("^ExecuteCodeError",strUser.get(),m$.Fnc.$increment(m$.var("^ExecuteCodeError",strUser.get())),m$.Fnc.$zdatetime(m$.Fnc.$horolog(),3),"Code").set(m$.var("pstrCode").get());
        //<< set ^ExecuteCodeError(strUser,$increment(^ExecuteCodeError(strUser)),$zdatetime($horolog,3),"Error") = strError
        m$.var("^ExecuteCodeError",strUser.get(),m$.Fnc.$increment(m$.var("^ExecuteCodeError",strUser.get())),m$.Fnc.$zdatetime(m$.Fnc.$horolog(),3),"Error").set(strError.get());
      }
      //<< }
      //<< 
      //<< // If the Routine doesn't exist or the Routine does, but the Label/Subroutine/Function doesn't,
      //<< // let the user know with a popup.
      //<< 
      //<< ; "Code: ### Error: ###"
      //<< set strError=$$DecodeError^COMUtilError($listbuild("Com00160"))_" "_$zconvert(pstrCode,"o","JS")_"\r\n"_$$DecodeError($listbuild("Com00161"))_" "_$zconvert(strError,"o","JS")
      strError.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("COMUtilError.DecodeError",m$.Fnc.$listbuild("Com00160"))," "),m$.Fnc.$zconvert(m$.var("pstrCode").get(),"o","JS")),"\\r\\n"),m$.fnc$("DecodeError",m$.Fnc.$listbuild("Com00161")))," "),m$.Fnc.$zconvert(strError.get(),"o","JS")));
      //<< write "alert('"_strError_"');"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("alert('",strError.get()),"');"));
    }
    //<< 
    //<< } else {
    else {
      //<< set blnExists = $$$NO
      blnExists.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< 
    //<< quit blnExists
    return blnExists.get();
  }

  //<< 
  //<< 
  //<< KillChildren(pidClass,pstrKeys)
  public Object KillChildren(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrKeys = m$.newVarRef("pstrKeys",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Kill all the child nodes of a global reference
    //<< ;
    //<< ; Params:   pidClass - @net class id, eg: "WWW124"
    //<< ;           pstrKeys - parent key, eg: "<form>,<language>"
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ;  6-Jul-2006   JW      Get @Net key not all keys, keybuild
    //<< ; 28-Apr-2006   JW      SR14508: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strGlobal,query,strStatus
    mVar strGlobal = m$.var("strGlobal");
    mVar query = m$.var("query");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strGlobal,query,strStatus);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set strGlobal = "^"_pidClass_"("_$$$WWWYM(pidClass)_","_$$^WWWKEYBUILD(pstrKeys)_")"
    strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",pidClass.get()),"("),include.COMSYSWWW.$$$WWWYM(m$,pidClass)),","),m$.fnc$("WWWKEYBUILD.main",pstrKeys.get())),")"));
    //<< 
    //<< //$$$Query(strGlobal,query)
    //<< set query=strGlobal,v$level=$qlength(query),v$name=$name(@query,v$level)
    query.set(strGlobal.get());
    mVar v$level = m$.var("v$level");
    v$level.set(m$.Fnc.$qlength(query));
    mVar v$name = m$.var("v$name");
    v$name.set(m$.Fnc.$name(m$.indirectVar(query.get()),v$level.get()));
    //<< for { set query=$query(@query) quit:(query="")||($name(@query,v$level)'=v$name)
    for (;true;) {
      query.set(m$.Fnc.$query(m$.indirectVar(query.get())));
      if ((mOp.Equal(query.get(),"")) || (mOp.NotEqual(m$.Fnc.$name(m$.indirectVar(query.get()),v$level.get()),v$name.get()))) {
        break;
      }
      //<< set strStatus = $$KILL(pidClass,$$$QueryANKey(query))
      strStatus.set(m$.fnc$("KILL",pidClass.get(),include.COMSYS.$$$QueryANKey(m$,query)));
      //<< quit:$$$ISERR(strStatus)
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        break;
      }
    }
    //<< //$$$End
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetScanDelim()
  public Object GetScanDelim(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the delimiter for the Scan Data
    //<< ; Usage : #include COMSYS
    //<< ;         set strDelim = $$$ScanDelim
    //<< ;
    //<< ; Returns: Scan delim char
    //<< ;
    //<< ; History:
    //<< ; 20-Jul-2009   PPP     SR16773:Creation
    //<< ;-------------------------------------------------------------------------------
    //<< new strDelim
    mVar strDelim = m$.var("strDelim");
    m$.newVar(strDelim);
    //<< 
    //<< set strDelim = "@"
    strDelim.set("@");
    //<< if $get(^SysSetup("ScanDelim"))'="" set strDelim = $get(^SysSetup("ScanDelim"))
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("^SysSetup","ScanDelim")),"")) {
      strDelim.set(m$.Fnc.$get(m$.var("^SysSetup","ScanDelim")));
    }
    //<< quit strDelim
    return strDelim.get();
  }

  //<< 
  //<< 
  //<< ;********************************************************************
  //<< ; Relocated to COMUtilClass - please redirect calls to these routines
  //<< ;********************************************************************
  //<< 
  //<< KILL(pstrClass,pid)
  public Object KILL(Object ... _p) {
    mVar pstrClass = m$.newVarRef("pstrClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< ; Revised code in ^COMUtilClass             <<<<<<<<<<<<<<<<<<<<<<<<<<<
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; WWWKILL Wrapper  -  see also DCMEvent : pidClass_"Kill"
    //<< ;
    //<< ; Calling WWWKILL within a WWWKILL will fail because YFORM is not scoped
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Sep-2006   JW      SR14979: New YFELD. Not newed in WWWKILL.
    //<< ; 26-Apr-2006   SC      SR14414: Return strStatus from WWWKILL. Used to return VARHooks error.
    //<< ; 01-Jul-2004   shobby  Creation (Copied from FINSYS)
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,YFELD,YFORM
    mVar strStatus = m$.var("strStatus");
    mVar YFELD = m$.var("YFELD");
    mVar YFORM = m$.var("YFORM");
    m$.newVar(strStatus,YFELD,YFORM);
    //<< 
    //<< set YFORM     = pstrClass
    YFORM.set(pstrClass.get());
    //<< set strStatus = $$^WWWKILL(pstrClass,pid)
    strStatus.set(m$.fnc$("WWWKILL.main",pstrClass.get(),pid.get()));
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< Save(Class,Key,Data,pblnLock,pblnBlockEvent=$$$NO)
  public Object Save(Object ... _p) {
    mVar Class = m$.newVarRef("Class",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Key = m$.newVarRef("Key",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar Data = m$.newVarRef("Data",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnLock = m$.newVarRef("pblnLock",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnBlockEvent = m$.newVarRef("pblnBlockEvent",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    //<< 
    //<< ; Revised code in ^COMUtilClass             <<<<<<<<<<<<<<<<<<<<<<<<<<<
    //<< ;
    //<< ; TODO : <GRF> Add extra parameter to pass pblnDoOnBeforeSave to WWWSPEI as
    //<< ;              Argument 8 (Default $$$YES)
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< ; WWWSPEI Wrapper  -  see also DCMEvent : pidClass_"Save"
    //<< ;
    //<< ; History:
    //<< ; 27-Jul-2009   GRF     SR16602: use $$$MakeStatus
    //<< ; 31-Jul-2008   Luke    SR15814: added "0 " to the return status
    //<< ; 13-Apr-2006   SC      SR14414: Pass strStatus to WWWSPEI, gives VAR code an
    //<< ;                           option to return a custom error message.
    //<< ; 17-Feb-2006   RPW     SR13697: If this a grid form do not overwrite the lock.
    //<< ; 09-Jun-2005   Steve S Use $get for YKEY
    //<< ; 18-Mar-2005   GRF     SR10478 : Include parameter to stop WWWSPEI putting
    //<< ;                           message on DCM Queue.
    //<< ; 19-Jan-2005   Steve S Added $$$OK macro usage for Status
    //<< ; 19-Aug-2004   SCR     Copied from FINSYS
    //<< ; 27-Feb-2004   shobby  Set default locking to 0 but not allow locking of 1
    //<< ;                           when Class=YFORM
    //<< ; 26-Feb-2004   shobby  Returned default locking to 1 but override with 0 when
    //<< ;                           Class=YFORM (Awaiting SR discussion with Germany
    //<< ;                           before finalising this)
    //<< ; 09-Jan-2004   lwaugh  Ensured Lock flag is passed to WWWSPEI
    //<< ; 07-Jul-2003   SCR     Added Lock Option, New YVOR
    //<< ;-------------------------------------------------------------------------------
    //<< new Status,YVOR,objClass,strStatus
    mVar Status = m$.var("Status");
    mVar YVOR = m$.var("YVOR");
    mVar objClass = m$.var("objClass");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(Status,YVOR,objClass,strStatus);
    //<< 
    //<< if $get(pblnLock)'=$$$YES {
    if (mOp.NotEqual(m$.Fnc.$get(pblnLock),include.COMSYS.$$$YES(m$))) {
      //<< set pblnLock = $$$NO
      pblnLock.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } else {
    else {
      //<< if Key=$get(YKEY) {
      if (mOp.Equal(Key.get(),m$.Fnc.$get(m$.var("YKEY")))) {
        //<< set objClass = $get(^WWW120(0,Class,1))
        objClass.set(m$.Fnc.$get(m$.var("^WWW120",0,Class.get(),1)));
        //<< if ($get(YFORM)'="")                                &&
        //<< ($$$WWW120ClassUsedInForm(objClass)=$get(YFORM)) &&
        //<< ($$$WWW120FormType(objClass)'=12)                   {
        if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.Equal(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objClass),m$.Fnc.$get(m$.var("YFORM")))) && (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,objClass),12))) {
          //<< 
          //<< set pblnLock=$$$NO
          pblnLock.set(include.COMSYS.$$$NO(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< new YFORM  ;*** Must be after the test that not saving to the currently displayed record
    mVar YFORM = m$.var("YFORM");
    m$.newVar(YFORM);
    //<< 
    //<< set YFORM = Class
    YFORM.set(Class.get());
    //<< set Status = $$^WWWSPEI(Class,Key,Data,pblnLock,pblnBlockEvent,,.strStatus)
    Status.set(m$.fnc$("WWWSPEI.main",Class.get(),Key.get(),Data.get(),pblnLock.get(),pblnBlockEvent.get(),null,strStatus));
    //<< 
    //<< if Status'=$$$OK {
    if (mOp.NotEqual(Status.get(),include.COMSYS.$$$OK(m$))) {
      //<< if $$$ISERR(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        //<< set Status = strStatus  // used if returning an error via VARHook code
        Status.set(strStatus.get());
      }
      //<< 
      //<< } else  {
      else {
        //<< // FIXME : A "Fin" language text in COM?
        //<< set Status = $$$MakeStatus("Fin00212",Class,Key,Status)    ;SR15814: "System save failed, Class:%1 Key:2 Error%3"
        Status.set(include.COMSYS.$$$MakeStatus(m$,"Fin00212",Class,Key,Status));
      }
    }
    //<< // FIXME : Return more meaningful error messages instead of 0, 9, etc.
    //<< }
    //<< }
    //<< 
    //<< quit Status
    return Status.get();
  }

  //<< 
  //<< 
  //<< ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^;
  //<< ;                                                                              ;
  //<< ;                 O B S O L E T E   S U B R O U T I N E S                      ;
  //<< ;                                                                              ;
  //<< ;                 Please redirect calls to these routines                      ;
  //<< ;                                                                              ;
  //<< ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
  //<< 
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ;  OBSOLETE : $$$Index has been redefined - use that
  //<< ;             or a direct reference to COMUtilIndex if necessary
  //<< ;-------------------------------------------------------------------------------
  //<< Index(pstrVal="")
  public Object Index(Object ... _p) {
    mVar pstrVal = m$.newVarRef("pstrVal",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< quit $$Index^COMUtilIndex(pstrVal) ;BR014941
    return m$.fnc$("COMUtilIndex.Index",pstrVal.get());
  }

  //<< 
  //<< 
  //<< ;********************************************************************
  //<< ; Relocated to COMUtilForm - please redirect calls to these routines
  //<< ; Check that parameters are initialised if defaults are not present
  //<< ; in replacement tag.
  //<< ;********************************************************************
  //<< 
  //<< GoToForm(pstrForm="",pidKey="",plngPage="",pstrParam="",pblnOpenNewWindow=$$$NO,pstrWindowName="")
  public Object GoToForm(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar plngPage = m$.newVarRef("plngPage",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstrParam = m$.newVarRef("pstrParam",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pblnOpenNewWindow = m$.newVarRef("pblnOpenNewWindow",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    mVar pstrWindowName = m$.newVarRef("pstrWindowName",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    //<< do GoToForm^COMUtilForm(pstrForm,pidKey,plngPage,pstrParam,pblnOpenNewWindow,pstrWindowName)
    m$.Cmd.Do("COMUtilForm.GoToForm",pstrForm.get(),pidKey.get(),plngPage.get(),pstrParam.get(),pblnOpenNewWindow.get(),pstrWindowName.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< RedirectForm(YFORM="",YKEY="",YBACK="",YPARA="",YSEITE="")
  public Object RedirectForm(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar YBACK = m$.newVarRef("YBACK",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar YPARA = m$.newVarRef("YPARA",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar YSEITE = m$.newVarRef("YSEITE",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    //<< do RedirectForm^COMUtilForm(YFORM,YKEY,YBACK,YPARA,YSEITE)
    m$.Cmd.Do("COMUtilForm.RedirectForm",YFORM.get(),YKEY.get(),YBACK.get(),YPARA.get(),YSEITE.get());
    //<< quit
    return null;
  }

  //<< 
  //<< ;********************************************************************
  //<< ; Relocated to COMUtilError - please redirect calls to these routines
  //<< ;********************************************************************
  //<< 
  //<< ReturnError(plstParams="")
  public Object ReturnError(Object ... _p) {
    mVar plstParams = m$.newVarRef("plstParams",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< do ReturnError^COMUtilError(plstParams)
    m$.Cmd.Do("COMUtilError.ReturnError",plstParams.get());
    //<< quit
    return null;
  }

  //<< 
  //<< DecodeError(plstParams="",pblnDecode=$$$NO,pidLang="")
  public Object DecodeError(Object ... _p) {
    mVar plstParams = m$.newVarRef("plstParams",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pblnDecode = m$.newVarRef("pblnDecode",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ; 24-Jun-2005   RobertW SR12690: Removed this as it's causing HTML issues with \'s.
    //<< quit $$DecodeError^COMUtilError(plstParams,pblnDecode,pidLang)
    return m$.fnc$("COMUtilError.DecodeError",plstParams.get(),pblnDecode.get(),pidLang.get());
  }

//<< 
//<< 
//<< ;****************************************************************
//<< ;
//<< ;
//<< ; Please add new subroutines ABOVE the obsolete tag marker ^^^^^
//<< ;
//<< ; Preferably categorise code so this routine gets no bigger!
//<< ;
//<< ;
//<< ;****************************************************************
}
