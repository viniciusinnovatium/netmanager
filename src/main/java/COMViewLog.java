//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewLog
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-16 16:22:45
//*****************************************************************************

import mLibrary.*;

//<< 
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

//<< COMViewLog    ; Logging of SQL statements, and how long they took.
public class COMViewLog extends mClass {

  public void main() {
    _COMViewLog();
  }

  public void _COMViewLog() {
  }

  //<< 
  //<< LogSQL(pstrSQL,pstrExecute,pfltTimeTaken,pblnManual=$$$NO)
  public Object LogSQL(Object ... _p) {
    mVar pstrSQL = m$.newVarRef("pstrSQL",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrExecute = m$.newVarRef("pstrExecute",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pfltTimeTaken = m$.newVarRef("pfltTimeTaken",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnManual = m$.newVarRef("pblnManual",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Log the history of SQL for this session, and if it took too long,
    //<< ; log the SQL statement for later tuning.
    //<< ;
    //<< ; Called By: DisplayGrid^COMViewFilter, ReRun^COMViewLog
    //<< ;
    //<< ; Returns:Status
    //<< ;
    //<< ; History:
    //<< ; 01-Oct-2009   SRC     SR16921: Added Last Used
    //<< ; 20-Dec-2004   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idHistory,objConfig,objLog,strStatus,strSQL,idLog
    mVar idHistory = m$.var("idHistory");
    mVar objConfig = m$.var("objConfig");
    mVar objLog = m$.var("objLog");
    mVar strStatus = m$.var("strStatus");
    mVar strSQL = m$.var("strSQL");
    mVar idLog = m$.var("idLog");
    m$.newVar(idHistory,objConfig,objLog,strStatus,strSQL,idLog);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set objConfig = $get(^COMViewConfig(0,YM,1))
    objConfig.set(m$.Fnc.$get(m$.var("^COMViewConfig",0,m$.var("YM").get(),1)));
    //<< 
    //<< if $$$COMViewConfigMinimumSQLLogtime(objConfig)="" set $$$COMViewConfigMinimumSQLLogtime(objConfig) = 0.5
    if (mOp.Equal(include.COMConst.$$$COMViewConfigMinimumSQLLogtime(m$,objConfig),"")) {
      include.COMConst.$$$COMViewConfigMinimumSQLLogtimeSet(m$,objConfig,0.5);
    }
    //<< 
    //<< set idHistory=$increment(^CacheTempView(YUSER,"History"))
    idHistory.set(m$.Fnc.$increment(m$.var("^CacheTempView",m$.var("YUSER").get(),"History")));
    //<< if pblnManual set ^CacheTempView(YUSER,"LastSQL") = idHistory
    if (mOp.Logical(pblnManual.get())) {
      m$.var("^CacheTempView",m$.var("YUSER").get(),"LastSQL").set(idHistory.get());
    }
    //<< 
    //<< set ^CacheTempView(YUSER,"History",idHistory,"Time")   = pfltTimeTaken
    m$.var("^CacheTempView",m$.var("YUSER").get(),"History",idHistory.get(),"Time").set(pfltTimeTaken.get());
    //<< set ^CacheTempView(YUSER,"History",idHistory,"SQL")    = pstrSQL
    m$.var("^CacheTempView",m$.var("YUSER").get(),"History",idHistory.get(),"SQL").set(pstrSQL.get());
    //<< set ^CacheTempView(YUSER,"History",idHistory,"Params") = pstrExecute
    m$.var("^CacheTempView",m$.var("YUSER").get(),"History",idHistory.get(),"Params").set(pstrExecute.get());
    //<< ;kill ^CacheTempView(YUSER,"History",idHistory-5)  ;remove old items
    //<< 
    //<< if pfltTimeTaken>=$$$COMViewConfigMinimumSQLLogtime(objConfig) {
    if (mOp.GreaterOrEqual(pfltTimeTaken.get(),include.COMConst.$$$COMViewConfigMinimumSQLLogtime(m$,objConfig))) {
      //<< set strSQL = $$$Index(pstrSQL)
      strSQL.set(include.MEDConst.$$$Index(m$,pstrSQL));
      //<< set idLog  = ""
      idLog.set("");
      //<< for {
      for (;true;) {
        //<< set idLog = $order(^COMViewLogs(0,1,strSQL,idLog))
        idLog.set(m$.Fnc.$order(m$.var("^COMViewLogs",0,1,strSQL.get(),idLog.get())));
        //<< quit:idLog=""
        if (mOp.Equal(idLog.get(),"")) {
          break;
        }
        //<< set objLog = $get(^COMViewLog(0,idLog,1))
        objLog.set(m$.Fnc.$get(m$.var("^COMViewLog",0,idLog.get(),1)));
        //<< quit:$$$COMViewLogSQLStatement(objLog)=pstrSQL
        if (mOp.Equal(include.COMConst.$$$COMViewLogSQLStatement(m$,objLog),pstrSQL.get())) {
          break;
        }
      }
      //<< }
      //<< if idLog="" set idLog = $order(^COMViewLog(0,""),-1)+1
      if (mOp.Equal(idLog.get(),"")) {
        idLog.set(mOp.Add(m$.Fnc.$order(m$.var("^COMViewLog",0,""),mOp.Negative(1)),1));
      }
      //<< 
      //<< set objLog = $get(^COMViewLog(0,idLog,1))
      objLog.set(m$.Fnc.$get(m$.var("^COMViewLog",0,idLog.get(),1)));
      //<< set $$$COMViewLogNumberofhits(objLog)     = $$$COMViewLogNumberofhits(objLog)+1
      include.COMConst.$$$COMViewLogNumberofhitsSet(m$,objLog,mOp.Add(include.COMConst.$$$COMViewLogNumberofhits(m$,objLog),1));
      //<< set $$$COMViewLogTotalTimeTaken(objLog)   = $$$COMViewLogTotalTimeTaken(objLog)+pfltTimeTaken
      include.COMConst.$$$COMViewLogTotalTimeTakenSet(m$,objLog,mOp.Add(include.COMConst.$$$COMViewLogTotalTimeTaken(m$,objLog),pfltTimeTaken.get()));
      //<< set $$$COMViewLogAverageTimeTaken(objLog) = $$$COMViewLogTotalTimeTaken(objLog)/$$$COMViewLogNumberofhits(objLog)
      include.COMConst.$$$COMViewLogAverageTimeTakenSet(m$,objLog,mOp.Divide(include.COMConst.$$$COMViewLogTotalTimeTaken(m$,objLog),include.COMConst.$$$COMViewLogNumberofhits(m$,objLog)));
      //<< set $$$COMViewLogLastTimeTaken(objLog)    = pfltTimeTaken
      include.COMConst.$$$COMViewLogLastTimeTakenSet(m$,objLog,pfltTimeTaken.get());
      //<< set $$$COMViewLogLastParams(objLog)       = pstrExecute
      include.COMConst.$$$COMViewLogLastParamsSet(m$,objLog,pstrExecute.get());
      //<< set $$$COMViewLogSQLStatement(objLog)     = pstrSQL
      include.COMConst.$$$COMViewLogSQLStatementSet(m$,objLog,pstrSQL.get());
      //<< set $$$COMViewLogClassesUsed(objLog)      = $translate($$GetClass(pstrSQL),",",";")
      include.COMConst.$$$COMViewLogClassesUsedSet(m$,objLog,m$.Fnc.$translate(m$.fnc$("GetClass",pstrSQL.get()),",",";"));
      //<< set $$$COMViewLogLastUsed(objLog)         = $horolog  ; SR16921
      include.COMConst.$$$COMViewLogLastUsedSet(m$,objLog,m$.Fnc.$horolog());
      //<< set strStatus = $$$Save("COMViewLog",idLog,objLog)
      strStatus.set(include.COMSYS.$$$Save(m$,"COMViewLog",idLog,objLog));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< AfterDataFields(pidLog)
  public Object AfterDataFields(Object ... _p) {
    mVar pidLog = m$.newVarRef("pidLog",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new objLog
    mVar objLog = m$.var("objLog");
    m$.newVar(objLog);
    //<< 
    //<< if pidLog'="" {
    if (mOp.NotEqual(pidLog.get(),"")) {
      //<< set objLog = $get(^COMViewLog(0,pidLog,1))
      objLog.set(m$.Fnc.$get(m$.var("^COMViewLog",0,pidLog.get(),1)));
      //<< write $$GetPlan^COMViewPlan($$$COMViewLogSQLStatement(objLog))
      m$.Cmd.Write(m$.fnc$("COMViewPlan.GetPlan",include.COMConst.$$$COMViewLogSQLStatement(m$,objLog)));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Tune(pidClass="",pidLog="")
  public Object Tune(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidLog = m$.newVarRef("pidLog",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< new idClass,ClassLoop,objLog
    mVar idClass = m$.var("idClass");
    mVar ClassLoop = m$.var("ClassLoop");
    mVar objLog = m$.var("objLog");
    m$.newVar(idClass,ClassLoop,objLog);
    //<< 
    //<< set YNOFOOT = 1
    mVar YNOFOOT = m$.var("YNOFOOT");
    YNOFOOT.set(1);
    //<< if pidLog'="" {
    if (mOp.NotEqual(pidLog.get(),"")) {
      //<< set objLog   = $get(^COMViewLog(0,pidLog,1))
      objLog.set(m$.Fnc.$get(m$.var("^COMViewLog",0,pidLog.get(),1)));
      //<< set pidClass = $$$COMViewLogClassesUsed(objLog)
      pidClass.set(include.COMConst.$$$COMViewLogClassesUsed(m$,objLog));
    }
    //<< }
    //<< if pidClass'="" {
    if (mOp.NotEqual(pidClass.get(),"")) {
      //<< write "<textarea style='width:100%;height:99%;'>"
      m$.Cmd.Write("<textarea style='width:100%;height:99%;'>");
      //<< for ClassLoop=1:1:$length(pidClass,";") {
      for (ClassLoop.set(1);(mOp.LessOrEqual(ClassLoop.get(),m$.Fnc.$length(pidClass.get(),";")));ClassLoop.set(mOp.Add(ClassLoop.get(),1))) {
        //<< set idClass = $piece(pidClass,";",ClassLoop)
        idClass.set(m$.Fnc.$piece(pidClass.get(),";",ClassLoop.get()));
        //<< do ##Class(%SYSTEM.SQL).TuneTable(idClass,1,1,,1)
        //TODO REVISAR m$.Cmd.Do("##Class",%SYSTEM.SQL);
        //<< do ##Class(%SYSTEM.SQL).PurgeForTable(idClass)
        //TODO REVISAR m$.Cmd.Do("##Class",%SYSTEM.SQL);
      }
      //<< }
      //<< write "</textarea>"
      m$.Cmd.Write("</textarea>");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ReRun(pidLog)
  public Object ReRun(Object ... _p) {
    mVar pidLog = m$.newVarRef("pidLog",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;
    //<< ; History:
    //<< ; 23-Sep-2013   shobby  UFH-11.24: Change Row to intRow in 2010 the Library.ResultSet may modify the Row variable
    //<< ;-------------------------------------------------------------------------------
    //<< new objResult,intRow,strParams,dteStart,strStatus,objLog ;UFH-11
    mVar objResult = m$.var("objResult");
    mVar intRow = m$.var("intRow");
    mVar strParams = m$.var("strParams");
    mVar dteStart = m$.var("dteStart");
    mVar strStatus = m$.var("strStatus");
    mVar objLog = m$.var("objLog");
    m$.newVar(objResult,intRow,strParams,dteStart,strStatus,objLog);
    //<< 
    //<< if pidLog'="" {
    if (mOp.NotEqual(pidLog.get(),"")) {
      //<< set objLog = $get(^COMViewLog(0,pidLog,1))
      objLog.set(m$.Fnc.$get(m$.var("^COMViewLog",0,pidLog.get(),1)));
      //<< 
      //<< set dteStart  = $ztimestamp
      dteStart.set(m$.Fnc.$ztimestamp());
      //<< set strParams = $$$COMViewLogLastParams(objLog)
      strParams.set(include.COMConst.$$$COMViewLogLastParams(m$,objLog));
      //<< Set objResult = ##class(%Library.ResultSet).%New()
      objResult.set(m$.fnc$("$Library.ResultSet.$New"));
      //<< do objResult.Prepare($$$COMViewLogSQLStatement(objLog))
      m$.Cmd.Do(objResult.getORef(),"Prepare",include.COMConst.$$$COMViewLogSQLStatement(m$,objLog));
      //<< xecute "do objResult.Execute("_strParams_")"
      m$.Cmd.Xecute(mOp.Concat(mOp.Concat("do objResult.Execute(",strParams.get()),")"));
      //<< for intRow=1:1:20 { ;UFH-11
      for (intRow.set(1);(mOp.LessOrEqual(intRow.get(),20));intRow.set(mOp.Add(intRow.get(),1))) {
        //<< quit:'objResult.Next()
        if (mOp.Not(m$.fnc$(objResult.getORef(),"Next"))) {
          break;
        }
      }
      //<< }
      //<< set strStatus = $$LogSQL^COMViewLog($$$COMViewLogSQLStatement(objLog),strParams,$$DateDiff^COMUtilDate(dteStart,$zts))
      strStatus.set(m$.fnc$("COMViewLog.LogSQL",include.COMConst.$$$COMViewLogSQLStatement(m$,objLog),strParams.get(),m$.fnc$("COMUtilDate.DateDiff",dteStart.get(),m$.Fnc.$ztimestamp())));
      //<< if strStatus=$$$OK set strStatus = $listbuild("Com00133",$$DateDiff^COMUtilDate(dteStart,$zts))
      if (mOp.Equal(strStatus.get(),include.COMSYS.$$$OK(m$))) {
        strStatus.set(m$.Fnc.$listbuild("Com00133",m$.fnc$("COMUtilDate.DateDiff",dteStart.get(),m$.Fnc.$ztimestamp())));
      }
      //<< write $$$Text(strStatus)    ; "Time Taken: %1"
      m$.Cmd.Write(include.COMSYS.$$$Text(m$,strStatus));
    }
    //<< }
    //<< do ^WWWFORM
    m$.Cmd.Do("WWWFORM.main");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetClass(pstrSQL)
  public Object GetClass(Object ... _p) {
    mVar pstrSQL = m$.newVarRef("pstrSQL",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the primary class for an SQL statement.
    //<< ;
    //<< ; Returns:ID (WWW001)
    //<< ;
    //<< ; History:
    //<< ; 20-Dec-2004   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass
    mVar idClass = m$.var("idClass");
    m$.newVar(idClass);
    //<< 
    //<< set idClass = $piece(pstrSQL,"from ",2)
    idClass.set(m$.Fnc.$piece(pstrSQL.get(),"from ",2));
    //<< set idClass = $piece(idClass," ",1)
    idClass.set(m$.Fnc.$piece(idClass.get()," ",1));
    //<< quit idClass
    return idClass.get();
  }

  //<< 
  //<< 
  //<< ClearLogs()
  public Object ClearLogs() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Clear the COMView performance logs
    //<< ;
    //<< ; Params: None
    //<< ;
    //<< ; ByRefs: None
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 18-Oct-2006   JW      SR15134: Look at kill status. Note - not used.
    //<< ; 31-Jan-2006   PO      SR14252: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLog,strStatus
    mVar idLog = m$.var("idLog");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idLog,strStatus);
    //<< 
    //<< set idLog = ""
    idLog.set("");
    //<< for {
    for (;true;) {
      //<< set idLog = $order(^COMViewLog(0,idLog))
      idLog.set(m$.Fnc.$order(m$.var("^COMViewLog",0,idLog.get())));
      //<< quit:idLog=""
      if (mOp.Equal(idLog.get(),"")) {
        break;
      }
      //<< 
      //<< set strStatus = $$$Kill("COMViewLog",idLog)     //SR15134
      strStatus.set(include.COMSYS.$$$Kill(m$,"COMViewLog",idLog));
    }
    //<< }
    //<< 
    //<< do ReloadForm^COMUtilForm()
    m$.Cmd.Do("COMUtilForm.ReloadForm");
    //<< quit
    return null;
  }

//<< 
//<< 
}
