//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewCommand
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-16 18:53:06
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; optional commands for rows. Setup is in COMViewCustom
//<< ;-------------------------------------------------------------------------------
//<< #include COMView
import include.COMView;
import include.COMSYS;
//<< #include COMConst
import include.COMConst;
//<< #include WWWConst
import include.WWWConst;

//<< COMViewCommand
public class COMViewCommand extends mClass {

  public void main() {
    _COMViewCommand();
  }

  public void _COMViewCommand() {
  }

  //<< 
  //<< GetCommands()
  public Object GetCommands() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the commands that are attached to buttons.
    //<< ;
    //<< ; Returns:String (HTML)
    //<< ;
    //<< ; History:
    //<< ; 12-Apr-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML,idCommand,objCommand
    mVar strHTML = m$.var("strHTML");
    mVar idCommand = m$.var("idCommand");
    mVar objCommand = m$.var("objCommand");
    m$.newVar(strHTML,idCommand,objCommand);
    //<< 
    //<< set strHTML=""
    strHTML.set("");
    //<< set idCommand=""
    idCommand.set("");
    //<< for {
    for (;true;) {
      //<< set idCommand=$order(^CacheTempView(YUSER,"Command",idCommand))
      idCommand.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Command",idCommand.get())));
      //<< quit:idCommand=""
      if (mOp.Equal(idCommand.get(),"")) {
        break;
      }
      //<< 
      //<< set objCommand=$get(^CacheTempView(YUSER,"Command",idCommand))
      objCommand.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Command",idCommand.get())));
      //<< set strHTML=strHTML_"<img src="""_YGIF_$$$COMViewCommandImage(objCommand)_""" "
      strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"<img src=\""),m$.var("YGIF").get()),include.COMConst.$$$COMViewCommandImage(m$,objCommand)),"\" "));
      //<< set strHTML=strHTML_"title="""_$zcvt($$$COMViewCommandDescription(objCommand),"o","HTML")_""" "
      strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"title=\""),m$.Fnc.$zconvert(include.COMConst.$$$COMViewCommandDescription(m$,objCommand),"o","HTML")),"\" "));
      //<< set strHTML=strHTML_"class=""coolButton"" "
      strHTML.set(mOp.Concat(strHTML.get(),"class=\"coolButton\" "));
      //<< set strHTML=strHTML_"onclick=""CommandClick("_idCommand_",'"_$zcvt($$$COMViewCommandConfirmText(objCommand),"o","JS")_"');"">"
      strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"onclick=\"CommandClick("),idCommand.get()),",'"),m$.Fnc.$zconvert(include.COMConst.$$$COMViewCommandConfirmText(m$,objCommand),"o","JS")),"');\">"));
    }
    //<< }
    //<< if strHTML'="" set strHTML=strHTML_Y
    if (mOp.NotEqual(strHTML.get(),"")) {
      strHTML.set(mOp.Concat(strHTML.get(),m$.var("Y").get()));
    }
    //<< 
    //<< quit strHTML
    return strHTML.get();
  }

  //<< 
  //<< CallBack(pidKey="",pidCommand="")
  public Object CallBack(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidCommand = m$.newVarRef("pidCommand",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Used for callbacks of commands. If command returns 1, refresh the grid
    //<< ;
    //<< ; Called by JS: CommandClick()
    //<< ;
    //<< ; History:
    //<< ; 09-Sep-2008   PP      SR15866:Update COMView to Objects
    //<< ; 14-Sep-2006   RPW     SR15041: If we need to refresh, then we MUST kill the
    //<< ;                           SQL as well.
    //<< ; 29-Aug-2006   JW      SR14763: Set status
    //<< ; 12-Apr-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,strSQL,strCallBack,objResult,blnRefresh
    mVar idClass = m$.var("idClass");
    mVar strSQL = m$.var("strSQL");
    mVar strCallBack = m$.var("strCallBack");
    mVar objResult = m$.var("objResult");
    mVar blnRefresh = m$.var("blnRefresh");
    m$.newVar(idClass,strSQL,strCallBack,objResult,blnRefresh);
    //<< new blnObj
    mVar blnObj = m$.var("blnObj");
    m$.newVar(blnObj);
    //<< 
    //<< set blnObj=+$get(^CacheTempObj(YUSER,"Object"))     //SR15866
    blnObj.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object"))));
    //<< 
    //<< if (pidKey'="") && (pidCommand'="") {
    if ((mOp.NotEqual(pidKey.get(),"")) && (mOp.NotEqual(pidCommand.get(),""))) {
      //<< set idClass=$get(^CacheTempView(YUSER,"Class"))
      idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
      //<< if $$Group^COMViewSQL() {
      if (mOp.Logical(m$.fnc$("COMViewSQL.Group"))) {
        //<< set strSQL=$$GenerateSQL^COMViewSQL(idClass,"",pidKey)
        strSQL.set(m$.fnc$("COMViewSQL.GenerateSQL",idClass.get(),"",pidKey.get()));
      }
      //<< } else {
      else {
        //<< if 'blnObj {
        if (mOp.Not(blnObj.get())) {
          //<< set strSQL="select ID from "_idClass_" where ID='"_$select($$$WWW001SharedFile($get(^WWW001(0,idClass,1))):"",1:"0||")_$$Replace^COMUtilStr(pidKey,",","||")_"'"
          strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("select ID from ",idClass.get())," where ID='"),m$.Fnc.$select(include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,idClass.get(),1))),"",1,"0||")),m$.fnc$("COMUtilStr.Replace",pidKey.get(),",","||")),"'"));
        }
        //<< } else {
        else {
          //<< set strSQL="select ID from "_idClass_" where ID='"_$$Replace^COMUtilStr(pidKey,",","||")_"'"
          strSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("select ID from ",idClass.get())," where ID='"),m$.fnc$("COMUtilStr.Replace",pidKey.get(),",","||")),"'"));
        }
      }
      //<< }
      //<< 
      //<< }
      //<< set strCallBack = $$$COMViewCommandCode($get(^CacheTempView(YUSER,"Command",pidCommand)))
      strCallBack.set(include.COMConst.$$$COMViewCommandCode(m$,m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Command",pidCommand.get()))));
      //<< set objResult = ##class(%Library.ResultSet).%New()
      objResult.set(m$.fnc$("$Library.ResultSet.$New"));
      //<< do objResult.Prepare(strSQL)
      m$.Cmd.Do(objResult.getORef(),"Prepare",strSQL.get());
      //<< do objResult.Execute()
      m$.Cmd.Do(objResult.getORef(),"Execute");
      //<< set blnRefresh=$$$NO
      blnRefresh.set(include.COMSYS.$$$NO(m$));
      //<< 
      //<< xecute "set blnRefresh=$$"_strCallBack_"(objResult)"
      m$.Cmd.Xecute(mOp.Concat(mOp.Concat("set blnRefresh=$$",strCallBack.get()),"(objResult)"));
      //<< 
      //<< if blnRefresh {
      if (mOp.Logical(blnRefresh.get())) {
        //<< kill ^CacheTempSQL($$$SQLID)         // SR15041
        m$.var("^CacheTempSQL",include.COMView.$$$SQLID(m$)).kill();
        //<< do DisplayGrid^COMViewFilter()
        m$.Cmd.Do("COMViewFilter.DisplayGrid");
      }
      //<< } else {
      else {
        //<< $$$SetStatus                         //SR14763
        include.COMView.$$$SetStatus(m$);
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

//<< 
//<< 
}
