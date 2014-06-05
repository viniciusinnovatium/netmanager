//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewSetupVB
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:12
//*****************************************************************************

import mLibrary.*;

//<< #include COMConst
import include.COMConst;
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

//<< ;-------------------------------------------------------------------------------
//<< ; COMViewSetupVB - VBScript for COMView
//<< ;-------------------------------------------------------------------------------
public class COMViewSetupVB extends mClass {

  //<< #define ButtonOK 1
  public static Object $$$ButtonOK(mContext m$) {
    return (1);
  }

  //<< #define ButtonCancel 2
  public static Object $$$ButtonCancel(mContext m$) {
    return (2);
  }

  //<< #define ButtonAbort 3
  public static Object $$$ButtonAbort(mContext m$) {
    return (3);
  }

  //<< #define ButtonRetry 4
  public static Object $$$ButtonRetry(mContext m$) {
    return (4);
  }

  //<< #define ButtonIgnore 5
  public static Object $$$ButtonIgnore(mContext m$) {
    return (5);
  }

  //<< #define ButtonYes 6
  public static Object $$$ButtonYes(mContext m$) {
    return (6);
  }

  //<< #define ButtonNo 7
  public static Object $$$ButtonNo(mContext m$) {
    return (7);
  }

  //<< 
  //<< 
  //<< CallBack(pstrMessage,pintType=$$$EnumCOMMSGOKCancel,pstrTitle="",pstrButton1Code="",pstrButton2Code="",pstrButton3Code="")
  public Object main(Object ... _p) {
    mVar pstrMessage = m$.newVarRef("pstrMessage",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintType = m$.newVarRef("pintType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMConst.$$$EnumCOMMSGOKCancel(m$));
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstrButton1Code = m$.newVarRef("pstrButton1Code",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pstrButton2Code = m$.newVarRef("pstrButton2Code",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pstrButton3Code = m$.newVarRef("pstrButton3Code",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    return CallBack(pstrMessage,pintType,pstrTitle,pstrButton1Code,pstrButton2Code,pstrButton3Code);
  }

  public Object CallBack(Object ... _p) {
    mVar pstrMessage = m$.newVarRef("pstrMessage",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintType = m$.newVarRef("pintType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMConst.$$$EnumCOMMSGOKCancel(m$));
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstrButton1Code = m$.newVarRef("pstrButton1Code",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pstrButton2Code = m$.newVarRef("pstrButton2Code",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pstrButton3Code = m$.newVarRef("pstrButton3Code",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Prompts the user before actioning some javascript code.
    //<< ;
    //<< ; pintype is enums from COMMSG summed together.
    //<< ;
    //<< ; Example:
    //<< ; $$$CallBack("Do you wish to proceed?",$$$EnumCOMMSGYesNo,"Confirm","CallBack('YesCode^YourRoutine','Some Param')","CallBack('NoCode^YourRoutine','Some Param')")
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 08-Apr-2005   Paul K      Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrButton,strCode
    mVar arrButton = m$.var("arrButton");
    mVar strCode = m$.var("strCode");
    m$.newVar(arrButton,strCode);
    //<< 
    //<< 
    //<< if pintType#16=$$$EnumCOMMSGOKOnly {
    if (mOp.Equal(mOp.Modulus(pintType.get(),16),include.COMConst.$$$EnumCOMMSGOKOnly(m$))) {
      //<< set arrButton(1)=$$$ButtonOK
      arrButton.var(1).set($$$ButtonOK(m$));
    }
    //<< } elseif pintType#16=$$$EnumCOMMSGOKCancel {
    else if (mOp.Equal(mOp.Modulus(pintType.get(),16),include.COMConst.$$$EnumCOMMSGOKCancel(m$))) {
      //<< set arrButton(1)=$$$ButtonOK
      arrButton.var(1).set($$$ButtonOK(m$));
      //<< set arrButton(2)=$$$ButtonCancel
      arrButton.var(2).set($$$ButtonCancel(m$));
    }
    //<< } elseif pintType#16=$$$EnumCOMMSGAbortRetryIgnore {
    else if (mOp.Equal(mOp.Modulus(pintType.get(),16),include.COMConst.$$$EnumCOMMSGAbortRetryIgnore(m$))) {
      //<< set arrButton(1)=$$$ButtonAbort
      arrButton.var(1).set($$$ButtonAbort(m$));
      //<< set arrButton(2)=$$$ButtonRetry
      arrButton.var(2).set($$$ButtonRetry(m$));
      //<< set arrButton(3)=$$$ButtonIgnore
      arrButton.var(3).set($$$ButtonIgnore(m$));
    }
    //<< } elseif pintType#16=$$$EnumCOMMSGYesNoCancel {
    else if (mOp.Equal(mOp.Modulus(pintType.get(),16),include.COMConst.$$$EnumCOMMSGYesNoCancel(m$))) {
      //<< set arrButton(1)=$$$ButtonYes
      arrButton.var(1).set($$$ButtonYes(m$));
      //<< set arrButton(2)=$$$ButtonNo
      arrButton.var(2).set($$$ButtonNo(m$));
      //<< set arrButton(3)=$$$ButtonCancel
      arrButton.var(3).set($$$ButtonCancel(m$));
    }
    //<< } elseif pintType#16=$$$EnumCOMMSGYesNo {
    else if (mOp.Equal(mOp.Modulus(pintType.get(),16),include.COMConst.$$$EnumCOMMSGYesNo(m$))) {
      //<< set arrButton(1)=$$$ButtonYes
      arrButton.var(1).set($$$ButtonYes(m$));
      //<< set arrButton(2)=$$$ButtonNo
      arrButton.var(2).set($$$ButtonNo(m$));
    }
    //<< } elseif pintType#16=$$$EnumCOMMSGRetryCancel {
    else if (mOp.Equal(mOp.Modulus(pintType.get(),16),include.COMConst.$$$EnumCOMMSGRetryCancel(m$))) {
      //<< set arrButton(1)=$$$ButtonRetry
      arrButton.var(1).set($$$ButtonRetry(m$));
      //<< set arrButton(2)=$$$ButtonCancel
      arrButton.var(2).set($$$ButtonCancel(m$));
    }
    //<< }
    //<< set strCode="var result="_$$Alert(pstrMessage,pintType,pstrTitle)
    strCode.set(mOp.Concat("var result=",m$.fnc$("Alert",pstrMessage.get(),pintType.get(),pstrTitle.get())));
    //<< if $data(arrButton(1)) if pstrButton1Code'="" set strCode=strCode_"if (result=="_arrButton(1)_") {"_pstrButton1Code_"};"
    if (mOp.Logical(m$.Fnc.$data(arrButton.var(1)))) {
      if (mOp.NotEqual(pstrButton1Code.get(),"")) {
        strCode.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strCode.get(),"if (result=="),arrButton.var(1).get()),") {"),pstrButton1Code.get()),"};"));
      }
    }
    //<< if $data(arrButton(2)) if pstrButton2Code'="" set strCode=strCode_"if (result=="_arrButton(2)_") {"_pstrButton2Code_"};"
    if (mOp.Logical(m$.Fnc.$data(arrButton.var(2)))) {
      if (mOp.NotEqual(pstrButton2Code.get(),"")) {
        strCode.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strCode.get(),"if (result=="),arrButton.var(2).get()),") {"),pstrButton2Code.get()),"};"));
      }
    }
    //<< if $data(arrButton(3)) if pstrButton3Code'="" set strCode=strCode_"if (result=="_arrButton(3)_") {"_pstrButton3Code_"};"
    if (mOp.Logical(m$.Fnc.$data(arrButton.var(3)))) {
      if (mOp.NotEqual(pstrButton3Code.get(),"")) {
        strCode.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strCode.get(),"if (result=="),arrButton.var(3).get()),") {"),pstrButton3Code.get()),"};"));
      }
    }
    //<< quit strCode
    return strCode.get();
  }

  //<< 
  //<< 
  //<< Setup()
  public Object Setup(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Pump VBScript to the screen
    //<< ;
    //<< ; History:
    //<< ; 19-May-2010   FIS     SR17253: various fixes for firefox compatibilety
    //<< ; 08-Apr-2005   Paul K      Commented
    //<< ;-------------------------------------------------------------------------------
    //<< &html<
    //<< <script language=vbscript>
    //<< Function VBConfirm_IE(Message,MsgType,Title)
    //<< VBConfirm_IE = MsgBox (Message, MsgType,Title)
    //<< End Function
    //<< </script>
    //<< <script language=javascript>  //SR17253 vvvvvvvvvvvvvvv
    //<< function VBConfirm(Message,MsgType,Title) {
    //<< if (isIE()) {  //SR17425
    //<< return VBConfirm_IE(Message, MsgType,Title);
    //<< }
    //<< else if (MsgType == 0) {
    //<< alert(Title + ': \n' + Message);
    //<< }
    //<< else {
    //<< if (confirm(Title + ': \n' + Message)) result = true;
    //<< else result = false;
    //<< switch (MsgType) {
    //<< case  1: return result == true ? 1 : 2;
    //<< case  16: return result == true ? 1 : 2;
    //<< case  35: return result == true ? 6 : 7;
    //<< case  36: return result == true ? 6 : 7;
    //<< default: return result;
    //<< }
    //<< }
    //<< }
    //<< </script>
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("    <script language=vbscript>","\n");
    m$.Cmd.WriteHtml("    Function VBConfirm_IE(Message,MsgType,Title)","\n");
    m$.Cmd.WriteHtml("    VBConfirm_IE = MsgBox (Message, MsgType,Title)","\n");
    m$.Cmd.WriteHtml("    End Function","\n");
    m$.Cmd.WriteHtml("    </script>","\n");
    m$.Cmd.WriteHtml("    <script language=javascript>  //SR17253 vvvvvvvvvvvvvvv","\n");
    m$.Cmd.WriteHtml("    function VBConfirm(Message,MsgType,Title) {","\n");
    m$.Cmd.WriteHtml("        if (isIE()) {  //SR17425","\n");
    m$.Cmd.WriteHtml("            return VBConfirm_IE(Message, MsgType,Title);","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        else if (MsgType == 0) {","\n");
    m$.Cmd.WriteHtml("            alert(Title + ': \\n' + Message);","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("        else {","\n");
    m$.Cmd.WriteHtml("            if (confirm(Title + ': \\n' + Message)) result = true;","\n");
    m$.Cmd.WriteHtml("            else result = false;","\n");
    m$.Cmd.WriteHtml("            switch (MsgType) {","\n");
    m$.Cmd.WriteHtml("                case  1: return result == true ? 1 : 2;","\n");
    m$.Cmd.WriteHtml("                case  16: return result == true ? 1 : 2;","\n");
    m$.Cmd.WriteHtml("                case  35: return result == true ? 6 : 7;","\n");
    m$.Cmd.WriteHtml("                case  36: return result == true ? 6 : 7;","\n");
    m$.Cmd.WriteHtml("                default: return result;","\n");
    m$.Cmd.WriteHtml("            }","\n");
    m$.Cmd.WriteHtml("        }","\n");
    m$.Cmd.WriteHtml("    }","\n");
    m$.Cmd.WriteHtml("    </script>","\n");
    m$.Cmd.WriteHtml("    ");
    //<< quit
    return null;
  }

  //<< 
  //<< Alert(pstrMessage,pintType=$$$EnumCOMMSGOKOnly,pstrTitle="")
  public Object Alert(Object ... _p) {
    mVar pstrMessage = m$.newVarRef("pstrMessage",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintType = m$.newVarRef("pintType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMConst.$$$EnumCOMMSGOKOnly(m$));
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show a message on the screen
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 08-Apr-2005   Paul K      Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< if pintType#256\16=0 {
    if (mOp.Equal(mOp.IntegerDivide(mOp.Modulus(pintType.get(),256),16),0)) {
      //<< set pintType=pintType+64
      pintType.set(mOp.Add(pintType.get(),64));
    }
    //<< }
    //<< if pstrTitle="" {
    if (mOp.Equal(pstrTitle.get(),"")) {
      //<< if pintType#256\16=($$$EnumCOMMSGCritical/16) {
      if (mOp.Equal(mOp.IntegerDivide(mOp.Modulus(pintType.get(),256),16),(mOp.Divide(include.COMConst.$$$EnumCOMMSGCritical(m$),16)))) {
        //<< set pstrTitle=$$$Text("Com00177")  ;System Error
        pstrTitle.set(include.COMSYS.$$$Text(m$,"Com00177"));
      }
      //<< } elseif pintType#256\16=($$$EnumCOMMSGQuestion/16) {
      else if (mOp.Equal(mOp.IntegerDivide(mOp.Modulus(pintType.get(),256),16),(mOp.Divide(include.COMConst.$$$EnumCOMMSGQuestion(m$),16)))) {
        //<< set pstrTitle=$$$Text("Com00180")  ;Question
        pstrTitle.set(include.COMSYS.$$$Text(m$,"Com00180"));
      }
      //<< } elseif pintType#256\16=($$$EnumCOMMSGExclamation/16) {
      else if (mOp.Equal(mOp.IntegerDivide(mOp.Modulus(pintType.get(),256),16),(mOp.Divide(include.COMConst.$$$EnumCOMMSGExclamation(m$),16)))) {
        //<< set pstrTitle=$$$Text("Com00179")  ;Warning
        pstrTitle.set(include.COMSYS.$$$Text(m$,"Com00179"));
      }
      //<< } elseif pintType#256\16=($$$EnumCOMMSGInformation/16) {
      else if (mOp.Equal(mOp.IntegerDivide(mOp.Modulus(pintType.get(),256),16),(mOp.Divide(include.COMConst.$$$EnumCOMMSGInformation(m$),16)))) {
        //<< set pstrTitle=$$$Text("Com00178")  ;Information
        pstrTitle.set(include.COMSYS.$$$Text(m$,"Com00178"));
      }
    }
    //<< }
    //<< }
    //<< quit "VBConfirm('"_$zcvt(pstrMessage,"o","JS")_"',"_pintType_",'"_$zcvt(pstrTitle,"o","JS")_"');"
    return mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("VBConfirm('",m$.Fnc.$zconvert(pstrMessage.get(),"o","JS")),"',"),pintType.get()),",'"),m$.Fnc.$zconvert(pstrTitle.get(),"o","JS")),"');");
  }

//<< 
//<< 
//<< 
//<< 
//<< 
//<< 
//<< 
//<< /*Constant Value Description
//<< vbOKOnly            0 Display OK button only.
//<< vbOKCancel          1 Display OK and Cancel buttons.
//<< vbAbortRetryIgnore  2 Display Abort, Retry, and Ignore buttons.
//<< vbYesNoCancel       3 Display Yes, No, and Cancel buttons.
//<< vbYesNo             4 Display Yes and No buttons.
//<< vbRetryCancel       5 Display Retry and Cancel buttons.
//<< vbCritical          16 Display Critical Message icon.
//<< vbQuestion          32 Display Warning Query icon.
//<< vbExclamation       48 Display Warning Message icon.
//<< vbInformation       64 Display Information Message icon.
//<< vbDefaultButton1    0 First button is default.
//<< vbDefaultButton2    256 Second button is default.
//<< vbDefaultButton3    512 Third button is default.
//<< vbDefaultButton4    768 Fourth button is default.
//<< vbApplicationModal  0 Application modal; the user must respond to the message box before continuing work in the current application.
//<< vbSystemModal       4096 System modal; all applications are suspended until the user responds to the message box.
//<< 
//<< 
//<< Return Values
//<< The MsgBox function has the following return values:
//<< 
//<< Constant Value Button
//<< vbOK 1 OK
//<< vbCancel 2 Cancel
//<< vbAbort 3 Abort
//<< vbRetry 4 Retry
//<< vbIgnore 5 Ignore
//<< vbYes 6 Yes
//<< vbNo 7 No */
//<< 
//<< 
}
