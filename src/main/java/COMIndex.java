//*****************************************************************************
//** TASC - ALPHALINC - MAC COMIndex
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:26
//*****************************************************************************

import mLibrary.*;

//<< 
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
//<< #include COMConst
import include.COMConst;

//<< COMIndex
public class COMIndex extends mClass {

  public void main() {
    _COMIndex();
  }

  public void _COMIndex() {
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; CompileCode will generate a routine idx.INABC.mac for @netManager Class INABC.
  //<< ;
  //<< ; If the actual code generated for these idx.* is modified below then the
  //<< ; version number returned by Version() needs to be updated.
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< ReIndexAll(Verbose=$$$NO,Log=0,Classes="")
  public Object ReIndexAll(Object ... _p) {
    mVar Verbose = m$.newVarRef("Verbose",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$NO(m$));
    mVar Log = m$.newVarRef("Log",(((_p!=null)&&(_p.length>=2))?_p[1]:null),0);
    mVar Classes = m$.newVarRef("Classes",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; ReIndex a Class
    //<< ;
    //<< ; Verbose   = Show output
    //<< ; Log       = Log Number for logging
    //<< ; ---Removed--- User        = YBED User
    //<< ; Classes   = Optional list of classes
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 31-May-2007   HeberB  BR014465: Nonexistent parameters
    //<< ; 29-Mar-2006   SC      SR13942: No longer need YUSER and YBED parameter for
    //<< ;                           background processes. Use JobWrapper^COMUtilsJob
    //<< ;                           instead.
    //<< ; 14-Dec-2005   GRF     Boolean Macros
    //<< ; 06-Apr-2005   SCR     SR12040: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Class,Keys
    mVar Class = m$.var("Class");
    mVar Keys = m$.var("Keys");
    m$.newVar(Class,Keys);
    //<< 
    //<< set Class=""
    Class.set("");
    //<< for {
    for (;true;) {
      //<< set Class=$order(^WWW001(0,Class))
      Class.set(m$.Fnc.$order(m$.var("^WWW001",0,Class.get())));
      //<< quit:Class=""
      if (mOp.Equal(Class.get(),"")) {
        break;
      }
      //<< 
      //<< do GetKeys(Class,.Keys)
      m$.Cmd.Do("GetKeys",Class.get(),Keys);
      //<< if $order(Keys(""))'="" {                               ; Only do this when there is an index.
      if (mOp.NotEqual(m$.Fnc.$order(Keys.var("")),"")) {
        //<< if Classes'="" {
        if (mOp.NotEqual(Classes.get(),"")) {
          //<< if (";"_Classes_";")'[(";"_Class_";") continue  ; Classes filter
          if (mOp.NotContains((mOp.Concat(mOp.Concat(";",Classes.get()),";")),(mOp.Concat(mOp.Concat(";",Class.get()),";")))) {
            continue;
          }
        }
        //<< }
        //<< if Verbose {
        if (mOp.Logical(Verbose.get())) {
          //<< write !,Class
          m$.Cmd.Write("\n",Class.get());
        }
        //<< }
        //<< do ReIndex(Class,Verbose,Log)
        m$.Cmd.Do("ReIndex",Class.get(),Verbose.get(),Log.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ReIndex(Class="",Verbose=$$$NO,Log=0) ;SR13942
  public Object ReIndex(Object ... _p) {
    mVar Class = m$.newVarRef("Class",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar Verbose = m$.newVarRef("Verbose",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar Log = m$.newVarRef("Log",(((_p!=null)&&(_p.length>=3))?_p[2]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; ReIndex a Class
    //<< ;
    //<< ; Class     = Class Name
    //<< ; Verbose   = Show output
    //<< ; Log       = Log Number for logging
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Sep-2006   RPW     Let's no do Shared Classes more than once.
    //<< ; 29-Mar-2006   SC      SR13942: No longer need YUSER and YBED parameter for
    //<< ;                           background processes. Use JobWrapper^COMUtilsJob
    //<< ;                           instead.
    //<< ; 19-Jun-2005   SCR     SR12696 Check,Clear & Log Index Dirty
    //<< ; 06-Apr-2005   SCR     SR12040 Added COMIndex & COMIndexHist Data Logging
    //<< ; 14-Feb-2005   SCR/PO  SR11483 Do reindex for all companies.
    //<< ; 11-Jan-2005   SCR     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Code,Count,Duration,EndTime,Entry,HistRec,IndexDirty,intCompany
    mVar Code = m$.var("Code");
    mVar Count = m$.var("Count");
    mVar Duration = m$.var("Duration");
    mVar EndTime = m$.var("EndTime");
    mVar Entry = m$.var("Entry");
    mVar HistRec = m$.var("HistRec");
    mVar IndexDirty = m$.var("IndexDirty");
    mVar intCompany = m$.var("intCompany");
    m$.newVar(Code,Count,Duration,EndTime,Entry,HistRec,IndexDirty,intCompany);
    //<< new Rec,StartTime
    mVar Rec = m$.var("Rec");
    mVar StartTime = m$.var("StartTime");
    m$.newVar(Rec,StartTime);
    //<< 
    //<< do CheckCode(Class)
    m$.Cmd.Do("CheckCode",Class.get());
    //<< 
    //<< set intCompany = ""
    intCompany.set("");
    //<< for {
    for (;true;) {
      //<< set intCompany = $order(^WWW012(0,intCompany))
      intCompany.set(m$.Fnc.$order(m$.var("^WWW012",0,intCompany.get())));
      //<< quit:intCompany=""
      if (mOp.Equal(intCompany.get(),"")) {
        break;
      }
      //<< 
      //<< quit:($$$WWW001SharedFile($get(^WWW001(0,Class,1))))&&(intCompany>0)
      if (mOp.Logical((include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,Class.get(),1))))) && (mOp.Greater(intCompany.get(),0))) {
        break;
      }
      //<< 
      //<< set StartTime = $horolog
      StartTime.set(m$.Fnc.$horolog());
      //<< set Duration  = $zhorolog
      Duration.set(m$.Fnc.$zhorolog());
      //<< set Count     = 0
      Count.set(0);
      //<< 
      //<< set Rec = $get(^COMIndex(intCompany,Class,1))
      Rec.set(m$.Fnc.$get(m$.var("^COMIndex",intCompany.get(),Class.get(),1)));
      //<< set $$$COMIndexLastIndexStartTime(Rec) = StartTime
      include.COMConst.$$$COMIndexLastIndexStartTimeSet(m$,Rec,StartTime.get());
      //<< set $$$COMIndexStatus(Rec)             = "Index Started"
      include.COMConst.$$$COMIndexStatusSet(m$,Rec,"Index Started");
      //<< set IndexDirty = $$$COMIndexIndexDirty(Rec) ; get the "Index Dirty" flag
      IndexDirty.set(include.COMConst.$$$COMIndexIndexDirty(m$,Rec));
      //<< 
      //<< set HistRec=""
      HistRec.set("");
      //<< set $$$COMIndexHistStartTime(HistRec) = StartTime
      include.COMConst.$$$COMIndexHistStartTimeSet(m$,HistRec,StartTime.get());
      //<< set $$$COMIndexHistUser1(HistRec)     = $get(YBED)
      include.COMConst.$$$COMIndexHistUser1Set(m$,HistRec,m$.Fnc.$get(m$.var("YBED")));
      //<< set $$$COMIndexHistStatus(HistRec)    = "Index Started"
      include.COMConst.$$$COMIndexHistStatusSet(m$,HistRec,"Index Started");
      //<< set $$$COMIndexHistType(HistRec)      = "Index"
      include.COMConst.$$$COMIndexHistTypeSet(m$,HistRec,"Index");
      //<< set Entry=$order(^COMIndexHist(intCompany,Class,""),-1)+1
      Entry.set(mOp.Add(m$.Fnc.$order(m$.var("^COMIndexHist",intCompany.get(),Class.get(),""),mOp.Negative(1)),1));
      //<< 
      //<< set ^COMIndexHist(intCompany,Class,Entry,1) = HistRec
      m$.var("^COMIndexHist",intCompany.get(),Class.get(),Entry.get(),1).set(HistRec.get());
      //<< set ^COMIndex(intCompany,Class,1)           = Rec
      m$.var("^COMIndex",intCompany.get(),Class.get(),1).set(Rec.get());
      //<< 
      //<< set Code="Do ReIndex^idx."_Class_"(Verbose,Log,intCompany,.Count)"
      Code.set(mOp.Concat(mOp.Concat("Do ReIndex^idx.",Class.get()),"(Verbose,Log,intCompany,.Count)"));
      //<< xecute Code
      m$.Cmd.Xecute(Code.get());
      //<< 
      //<< set Rec=$get(^COMIndex(intCompany,Class,1))
      Rec.set(m$.Fnc.$get(m$.var("^COMIndex",intCompany.get(),Class.get(),1)));
      //<< 
      //<< set Duration=+$justify($zh-Duration,0,2)
      Duration.set(mOp.Positive(m$.Fnc.$justify(mOp.Subtract(m$.Fnc.$zhorolog(),Duration.get()),0,2)));
      //<< set $$$COMIndexLastIndexEndTime(Rec)  = $horolog
      include.COMConst.$$$COMIndexLastIndexEndTimeSet(m$,Rec,m$.Fnc.$horolog());
      //<< set $$$COMIndexDurationInSeconds(Rec) = Duration
      include.COMConst.$$$COMIndexDurationInSecondsSet(m$,Rec,Duration.get());
      //<< set $$$COMIndexNumberofRecords(Rec)   = Count
      include.COMConst.$$$COMIndexNumberofRecordsSet(m$,Rec,Count.get());
      //<< set $$$COMIndexStatus(Rec)            = "Complete"
      include.COMConst.$$$COMIndexStatusSet(m$,Rec,"Complete");
      //<< if $$$COMIndexIndexDirty(Rec)=IndexDirty {  ; Check for no change in "Index Dirty" flag
      if (mOp.Equal(include.COMConst.$$$COMIndexIndexDirty(m$,Rec),IndexDirty.get())) {
        //<< set $$$COMIndexIndexDirty(Rec)    = ""  ; Clear "Index Dirty"
        include.COMConst.$$$COMIndexIndexDirtySet(m$,Rec,"");
        //<< set $$$COMIndexHistType(HistRec)  = "Index,Clean"
        include.COMConst.$$$COMIndexHistTypeSet(m$,HistRec,"Index,Clean");
      }
      //<< }
      //<< set ^COMIndex(intCompany,Class,1)     = Rec
      m$.var("^COMIndex",intCompany.get(),Class.get(),1).set(Rec.get());
      //<< 
      //<< set $$$COMIndexHistEndTime(HistRec)           = $horolog
      include.COMConst.$$$COMIndexHistEndTimeSet(m$,HistRec,m$.Fnc.$horolog());
      //<< set $$$COMIndexHistDurationInSeconds(HistRec) = Duration
      include.COMConst.$$$COMIndexHistDurationInSecondsSet(m$,HistRec,Duration.get());
      //<< set $$$COMIndexHistNumberofRecords(HistRec)   = Count
      include.COMConst.$$$COMIndexHistNumberofRecordsSet(m$,HistRec,Count.get());
      //<< set $$$COMIndexHistUser1(HistRec)             = $get(YBED)
      include.COMConst.$$$COMIndexHistUser1Set(m$,HistRec,m$.Fnc.$get(m$.var("YBED")));
      //<< set $$$COMIndexHistStatus(HistRec)            = "Complete"
      include.COMConst.$$$COMIndexHistStatusSet(m$,HistRec,"Complete");
      //<< set ^COMIndexHist(intCompany,Class,Entry,1)   = HistRec
      m$.var("^COMIndexHist",intCompany.get(),Class.get(),Entry.get(),1).set(HistRec.get());
      //<< 
      //<< If Verbose {
      if (mOp.Logical(Verbose.get())) {
        //<< write " Complete ",Count," Records in ",Duration," Seconds",!
        m$.Cmd.Write(" Complete ",Count.get()," Records in ",Duration.get()," Seconds","\n");
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetIndexDirty(Class="")
  public Object SetIndexDirty(Object ... _p) {
    mVar Class = m$.newVarRef("Class",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set the Dirty Flag / TimeStamp on a Class
    //<< ; This will be checked during the check class method & reset during a re-index.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2005   SCR     SR12696: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Rec,Entry,HistRec,intCompany
    mVar Rec = m$.var("Rec");
    mVar Entry = m$.var("Entry");
    mVar HistRec = m$.var("HistRec");
    mVar intCompany = m$.var("intCompany");
    m$.newVar(Rec,Entry,HistRec,intCompany);
    //<< 
    //<< set intCompany = +$get(YM) ; Assume YM is set up!
    intCompany.set(mOp.Positive(m$.Fnc.$get(m$.var("YM"))));
    //<< 
    //<< if Class'="" {
    if (mOp.NotEqual(Class.get(),"")) {
      //<< set Rec = $get(^COMIndex(intCompany,Class,1))
      Rec.set(m$.Fnc.$get(m$.var("^COMIndex",intCompany.get(),Class.get(),1)));
      //<< set $$$COMIndexIndexDirty(Rec)    = $horolog
      include.COMConst.$$$COMIndexIndexDirtySet(m$,Rec,m$.Fnc.$horolog());
      //<< set ^COMIndex(intCompany,Class,1) = Rec
      m$.var("^COMIndex",intCompany.get(),Class.get(),1).set(Rec.get());
      //<< 
      //<< set HistRec = ""
      HistRec.set("");
      //<< set $$$COMIndexHistStartTime(HistRec) = $horolog
      include.COMConst.$$$COMIndexHistStartTimeSet(m$,HistRec,m$.Fnc.$horolog());
      //<< set $$$COMIndexHistUser1(HistRec)     = $get(YBED)
      include.COMConst.$$$COMIndexHistUser1Set(m$,HistRec,m$.Fnc.$get(m$.var("YBED")));
      //<< set $$$COMIndexHistStatus(HistRec)    = "Complete"
      include.COMConst.$$$COMIndexHistStatusSet(m$,HistRec,"Complete");
      //<< set $$$COMIndexHistType(HistRec)      = "Set Dirty Flag"
      include.COMConst.$$$COMIndexHistTypeSet(m$,HistRec,"Set Dirty Flag");
      //<< set $$$COMIndexHistEndTime(HistRec)   = $horolog
      include.COMConst.$$$COMIndexHistEndTimeSet(m$,HistRec,m$.Fnc.$horolog());
      //<< set Entry = $order(^COMIndexHist(intCompany,Class,""),-1)+1
      Entry.set(mOp.Add(m$.Fnc.$order(m$.var("^COMIndexHist",intCompany.get(),Class.get(),""),mOp.Negative(1)),1));
      //<< set ^COMIndexHist(intCompany,Class,Entry,1) = HistRec
      m$.var("^COMIndexHist",intCompany.get(),Class.get(),Entry.get(),1).set(HistRec.get());
    }
    //<< 
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetData(Class="",Key="",Data="",Time=0)
  public Object GetData(Object ... _p) {
    mVar Class = m$.newVarRef("Class",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar Key = m$.newVarRef("Key",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar Data = m$.newVarRef("Data",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar Time = m$.newVarRef("Time",(((_p!=null)&&(_p.length>=4))?_p[3]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Data for a Class
    //<< ;
    //<< ; Class     = Class Name
    //<< ; Key       = Class Key
    //<< ; Data      = Data to Pass Back
    //<< ; Time      = Time Flag
    //<< ;
    //<< ; Returns: Status  0 = Ok
    //<< ;
    //<< ; History:
    //<< ; 24-Jan-2005   SCR     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Code,Status
    mVar Code = m$.var("Code");
    mVar Status = m$.var("Status");
    m$.newVar(Code,Status);
    //<< 
    //<< do CheckCode(Class)
    m$.Cmd.Do("CheckCode",Class.get());
    //<< set Code = "set Status=$$Update^idx."_Class_"(Key,.Data,0,Time)"
    Code.set(mOp.Concat(mOp.Concat("set Status=$$Update^idx.",Class.get()),"(Key,.Data,0,Time)"));
    //<< xecute Code
    m$.Cmd.Xecute(Code.get());
    //<< quit $get(Status)
    return m$.Fnc.$get(Status);
  }

  //<< 
  //<< 
  //<< SetData(Class="",Key="",Data="",Time=0)
  public Object SetData(Object ... _p) {
    mVar Class = m$.newVarRef("Class",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar Key = m$.newVarRef("Key",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar Data = m$.newVarRef("Data",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar Time = m$.newVarRef("Time",(((_p!=null)&&(_p.length>=4))?_p[3]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set Data for a Class
    //<< ;
    //<< ; Class     = Class Name
    //<< ; Key       = Class Key
    //<< ; Data      = Data
    //<< ; Time      = Time Flag
    //<< ;
    //<< ; Returns: Status  0 = Ok
    //<< ;
    //<< ; History:
    //<< ; 24-Jan-2005   SCR     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Code,Status
    mVar Code = m$.var("Code");
    mVar Status = m$.var("Status");
    m$.newVar(Code,Status);
    //<< 
    //<< do CheckCode(Class)
    m$.Cmd.Do("CheckCode",Class.get());
    //<< set Code = "set Status=$$Update^idx."_Class_"(Key,Data,1,Time)"
    Code.set(mOp.Concat(mOp.Concat("set Status=$$Update^idx.",Class.get()),"(Key,Data,1,Time)"));
    //<< xecute Code
    m$.Cmd.Xecute(Code.get());
    //<< quit $get(Status)
    return m$.Fnc.$get(Status);
  }

  //<< 
  //<< 
  //<< GetLoc(Class="",Key="",Data="",Time=0)
  public Object GetLoc(Object ... _p) {
    mVar Class = m$.newVarRef("Class",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar Key = m$.newVarRef("Key",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar Data = m$.newVarRef("Data",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar Time = m$.newVarRef("Time",(((_p!=null)&&(_p.length>=4))?_p[3]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Location for Class and Data
    //<< ;
    //<< ; Class     = Class Name
    //<< ; Key       = Class Key
    //<< ; Data      = Location (pass back)
    //<< ; Time      = Time Flag
    //<< ;
    //<< ; Returns: Status  0 = Ok
    //<< ;
    //<< ; History:
    //<< ; 24-Jan-2005   SCR     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Code,Status
    mVar Code = m$.var("Code");
    mVar Status = m$.var("Status");
    m$.newVar(Code,Status);
    //<< 
    //<< do CheckCode(Class)
    m$.Cmd.Do("CheckCode",Class.get());
    //<< set Code = "set Status=$$Update^idx."_Class_"(Key,Data,2,Time)"
    Code.set(mOp.Concat(mOp.Concat("set Status=$$Update^idx.",Class.get()),"(Key,Data,2,Time)"));
    //<< xecute Code
    m$.Cmd.Xecute(Code.get());
    //<< quit $get(Status)
    return m$.Fnc.$get(Status);
  }

  //<< 
  //<< 
  //<< CheckCode(Class="")
  public Object CheckCode(Object ... _p) {
    mVar Class = m$.newVarRef("Class",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check Code
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Apr-2005   SCR     SR12040 Pass in Class to Version
    //<< ; 11-Jan-2005   SCR     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new OK,Rtn,Code,Version
    mVar OK = m$.var("OK");
    mVar Rtn = m$.var("Rtn");
    mVar Code = m$.var("Code");
    mVar Version = m$.var("Version");
    m$.newVar(OK,Rtn,Code,Version);
    //<< 
    //<< set $ztrap="CheckCodeError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("CheckCodeError");
    //<< 
    //<< set Version = ""
    Version.set("");
    //<< set Code    = "set Version=$$Version^idx."_Class_"()"
    Code.set(mOp.Concat(mOp.Concat("set Version=$$Version^idx.",Class.get()),"()"));
    //<< xecute Code
    m$.Cmd.Xecute(Code.get());
    //<< if Version'=$$Version(Class) {
    if (mOp.NotEqual(Version.get(),m$.fnc$("Version",Class.get()))) {
      //<< do CompileCode(Class)
      m$.Cmd.Do("CompileCode",Class.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< CheckCodeError ; Internal Tag for Errors
  public void CheckCodeError() {
    //<< set $zt=""
    mVar $zt = m$.var("$zt");
    $zt.set("");
    //<< do CompileCode(Class)
    m$.Cmd.Do("CompileCode",m$.var("Class").get());
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< Version(Class="")
  public Object Version(Object ... _p) {
    mVar Class = m$.newVarRef("Class",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Version Number
    //<< ;
    //<< ; Update this when ever the Compiled code changes
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-May-2011   shobby  SR17754: Force rebuild of all indices.
    //<< ; 31-May-2007   HeberB  BR014465:To recreate the code
    //<< ; 06-Apr-2005   SCR     SR12040 Include Indexes in version number
    //<< ; 11-Jan-2005   SCR     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Version,Index,Indexes,Keys
    mVar Version = m$.var("Version");
    mVar Index = m$.var("Index");
    mVar Indexes = m$.var("Indexes");
    mVar Keys = m$.var("Keys");
    m$.newVar(Version,Index,Indexes,Keys);
    //<< 
    //<< if Class="" set Class = " "
    if (mOp.Equal(Class.get(),"")) {
      Class.set(" ");
    }
    //<< 
    //<< ;SR17754 2.050
    //<< set Version = "2.051"   ; <<<<<<<<<<<----------------  Update this version number to force a recreate of the code
    Version.set("2.051");
    //<< 
    //<< do GetKeys(Class,.Keys)     ; Get keys for Class
    m$.Cmd.Do("GetKeys",Class.get(),Keys);
    //<< set Indexes = ""
    Indexes.set("");
    //<< set Index = ""
    Index.set("");
    //<< for {
    for (;true;) {
      //<< set Index = $order(Keys(Index))
      Index.set(m$.Fnc.$order(Keys.var(Index.get())));
      //<< quit:Index=""
      if (mOp.Equal(Index.get(),"")) {
        break;
      }
      //<< 
      //<< set Indexes = Indexes_","_Index_"="_$get(Keys(Index)) ; Build Indexes
      Indexes.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(Indexes.get(),","),Index.get()),"="),m$.Fnc.$get(Keys.var(Index.get()))));
    }
    //<< }
    //<< set Version = "Version: "_Version_" Indexes: "_$extract(Indexes,2,9999) ; Add Version Number & Indexes
    Version.set(mOp.Concat(mOp.Concat(mOp.Concat("Version: ",Version.get())," Indexes: "),m$.Fnc.$extract(Indexes.get(),2,9999)));
    //<< quit Version
    return Version.get();
  }

  //<< 
  //<< 
  //<< GetKeys(Class="",Keys)
  public Object GetKeys(Object ... _p) {
    mVar Class = m$.newVarRef("Class",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar Keys = m$.newVarRef("Keys",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Keys for a Class ( a wrapper for WWWSORTKEY )
    //<< ;           Class       = @NM Class
    //<< ; ByRef :   Keys        = Pass back Keys
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 20-Sep-2011   SCR     SR17885 Force No Index option
    //<< ; 06-Apr-2005   SCR     Created SR12040
    //<< ;-------------------------------------------------------------------------------
    //<< new YSKEY
    mVar YSKEY = m$.var("YSKEY");
    m$.newVar(YSKEY);
    //<< 
    //<< kill Keys
    Keys.kill();
    //<< set YSKEY = ""
    YSKEY.set("");
    //<< ;do ^WWWSORTKEY(Class)  ; Get keys for Class
    //<< do ^WWWSORTKEY(Class,$$$YES)    ; SR17885 Get keys for Class
    m$.Cmd.Do("WWWSORTKEY.main",Class.get(),include.COMSYS.$$$YES(m$));
    //<< merge Keys = YSKEY
    m$.Cmd.Merge(Keys,YSKEY);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CompileCode(Class)
  public Object CompileCode(Object ... _p) {
    mVar Class = m$.newVarRef("Class",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Compile Index Code
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-May-2011   shobby  SR17754: Redirected translation through $$Index as the
    //<< ;                           direct translation would produce incorrect results.
    //<< ; 31-May-2007   HeberB  BR014465:Add new characters
    //<< ; 20-Apr-2005   SCR     SR12040 Remove Space from raw data for Index
    //<< ; 18-Apr-2005   SCR     SR12040 Added Skip Code to ReIndex
    //<< ; 06-Apr-2005   SCR     SR12040 Put Quotes on version, Update History & Change
    //<< ;                           WWWSORTKEY to GetKeys
    //<< ; 24-Mar-2005   Paul K  Newed YSKEY
    //<< ; 15-Mar-2005   Paul K  Added macro usage
    //<< ; 20-Feb-2005   SCR     SR11483: Check for bad Index Structure by Defaulting
    //<< ;                           missing indices to "F0"
    //<< ; 14-Feb-2005   SCR/PO  SR11483: Generate procedure ReIndex with YM parameter.
    //<< ; 24-Jan-2005   SCR     Added Global Access ('Update')
    //<< ; 11-Jan-2005   SCR     Added Remove Index option
    //<< ; 11-Jan-2005   SCR     Added Logging
    //<< ; 01-Dec-2004   SCR     Sortend Bug Fix, Null Index fix (1.1,,1.2), Multi part
    //<< ; 03-Oct-2004   SCR     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new ClassRec,Coy,Data,DataList,DataLoc,DataSet,FirstKey
    mVar ClassRec = m$.var("ClassRec");
    mVar Coy = m$.var("Coy");
    mVar Data = m$.var("Data");
    mVar DataList = m$.var("DataList");
    mVar DataLoc = m$.var("DataLoc");
    mVar DataSet = m$.var("DataSet");
    mVar FirstKey = m$.var("FirstKey");
    m$.newVar(ClassRec,Coy,Data,DataList,DataLoc,DataSet,FirstKey);
    //<< new Indent,Index,IndexCode,IndexKey,IndexLoc,IndexSet
    mVar Indent = m$.var("Indent");
    mVar Index = m$.var("Index");
    mVar IndexCode = m$.var("IndexCode");
    mVar IndexKey = m$.var("IndexKey");
    mVar IndexLoc = m$.var("IndexLoc");
    mVar IndexSet = m$.var("IndexSet");
    m$.newVar(Indent,Index,IndexCode,IndexKey,IndexLoc,IndexSet);
    //<< new Key,Keys,LastData,ListLoc,Loc,LoopEndCode,LoopStartCode
    mVar Key = m$.var("Key");
    mVar Keys = m$.var("Keys");
    mVar LastData = m$.var("LastData");
    mVar ListLoc = m$.var("ListLoc");
    mVar Loc = m$.var("Loc");
    mVar LoopEndCode = m$.var("LoopEndCode");
    mVar LoopStartCode = m$.var("LoopStartCode");
    m$.newVar(Key,Keys,LastData,ListLoc,Loc,LoopEndCode,LoopStartCode);
    //<< new NewList,Num,objRtn
    mVar NewList = m$.var("NewList");
    mVar Num = m$.var("Num");
    mVar objRtn = m$.var("objRtn");
    m$.newVar(NewList,Num,objRtn);
    //<< new ReNewList,Rtn,Status,Sub,SubList,Subs,SubSet,Type,Var
    mVar ReNewList = m$.var("ReNewList");
    mVar Rtn = m$.var("Rtn");
    mVar Status = m$.var("Status");
    mVar Sub = m$.var("Sub");
    mVar SubList = m$.var("SubList");
    mVar Subs = m$.var("Subs");
    mVar SubSet = m$.var("SubSet");
    mVar Type = m$.var("Type");
    mVar Var = m$.var("Var");
    m$.newVar(ReNewList,Rtn,Status,Sub,SubList,Subs,SubSet,Type,Var);
    //<< 
    //<< do GetKeys(Class,.Keys) ; Setup YSKEY
    m$.Cmd.Do("GetKeys",Class.get(),Keys);
    //<< set Subs     = $order(^WWW002(0,Class,""),-1)
    Subs.set(m$.Fnc.$order(m$.var("^WWW002",0,Class.get(),""),mOp.Negative(1)));
    //<< ;SR17754 set NewList  = "Data,Rec,lc,uc,SubKey,Key1"
    //<< set NewList  = "Data,Rec,SubKey,Key1"               ;SR17754
    NewList.set("Data,Rec,SubKey,Key1");
    //<< set ClassRec = $get(^WWW001(0,Class,1))
    ClassRec.set(m$.Fnc.$get(m$.var("^WWW001",0,Class.get(),1)));
    //<< set Coy      = "YM"
    Coy.set("YM");
    //<< if $$$WWW001SharedFile(ClassRec)=1 set Coy = 0
    if (mOp.Equal(include.WWWConst.$$$WWW001SharedFile(m$,ClassRec),1)) {
      Coy.set(0);
    }
    //<< set SubList  = ""
    SubList.set("");
    //<< for Sub=1:1:Subs {
    for (Sub.set(1);(mOp.LessOrEqual(Sub.get(),Subs.get()));Sub.set(mOp.Add(Sub.get(),1))) {
      //<< set Var     = "Sub"_Sub
      Var.set(mOp.Concat("Sub",Sub.get()));
      //<< set NewList = NewList_","_Var
      NewList.set(mOp.Concat(mOp.Concat(NewList.get(),","),Var.get()));
      //<< set $piece(SubList,",",Sub) = Var
      m$.pieceVar(SubList,",",Sub.get()).set(Var.get());
      //<< set SubSet(Sub) = " set "_Var_"=$piece(Key,"","","_Sub_") if "_Var_"="""" quit"
      SubSet.var(Sub.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" set ",Var.get()),"=$piece(Key,\",\","),Sub.get()),") if "),Var.get()),"=\"\" quit"));
    }
    //<< }
    //<< set IndexLoc = "^"_Class_"s("_Coy
    IndexLoc.set(mOp.Concat(mOp.Concat(mOp.Concat("^",Class.get()),"s("),Coy.get()));
    //<< set DataLoc  = "^"_Class_"("_Coy_","_SubList_",1)"
    DataLoc.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",Class.get()),"("),Coy.get()),","),SubList.get()),",1)"));
    //<< set IndexSet = 0
    IndexSet.set(0);
    //<< set Index    = ""
    Index.set("");
    //<< for {
    for (;true;) {
      //<< set Index = $order(Keys(Index))
      Index.set(m$.Fnc.$order(Keys.var(Index.get())));
      //<< quit:Index=""
      if (mOp.Equal(Index.get(),"")) {
        break;
      }
      //<< 
      //<< set Keys     = $get(Keys(Index))
      Keys.set(m$.Fnc.$get(Keys.var(Index.get())));
      //<< set LastData = "F0"                 ; Default Data location for missing Keys SR11483
      LastData.set("F0");
      //<< set FirstKey = $piece(Keys,",",1)
      FirstKey.set(m$.Fnc.$piece(Keys.get(),",",1));
      //<< if FirstKey="" set FirstKey = LastData
      if (mOp.Equal(FirstKey.get(),"")) {
        FirstKey.set(LastData.get());
      }
      //<< 
      //<< set IndexCode = " for SubKey=1:1:$length("_FirstKey_","";"") {"
      IndexCode.set(mOp.Concat(mOp.Concat(" for SubKey=1:1:$length(",FirstKey.get()),",\";\") {"));
      //<< set IndexSet  = IndexSet+1
      IndexSet.set(mOp.Add(IndexSet.get(),1));
      //<< set IndexSet(IndexSet) = IndexCode
      IndexSet.var(IndexSet.get()).set(IndexCode.get());
      //<< 
      //<< set IndexCode = "  set Key1=$piece("_FirstKey_","";"",SubKey)"
      IndexCode.set(mOp.Concat(mOp.Concat("  set Key1=$piece(",FirstKey.get()),",\";\",SubKey)"));
      //<< set IndexSet  = IndexSet+1
      IndexSet.set(mOp.Add(IndexSet.get(),1));
      //<< set IndexSet(IndexSet) = IndexCode
      IndexSet.var(IndexSet.get()).set(IndexCode.get());
      //<< 
      //<< set IndexCode = "  set:Key1="""" Key1="" """
      IndexCode.set("  set:Key1=\"\" Key1=\" \"");
      //<< set IndexSet  = IndexSet+1
      IndexSet.set(mOp.Add(IndexSet.get(),1));
      //<< set IndexSet(IndexSet) = IndexCode
      IndexSet.var(IndexSet.get()).set(IndexCode.get());
      //<< 
      //<< set IndexKey = IndexLoc_","_Index
      IndexKey.set(mOp.Concat(mOp.Concat(IndexLoc.get(),","),Index.get()));
      //<< for Key=1:1:$length(Keys,",") {
      for (Key.set(1);(mOp.LessOrEqual(Key.get(),m$.Fnc.$length(Keys.get(),",")));Key.set(mOp.Add(Key.get(),1))) {
        //<< set Data = $piece(Keys,",",Key)
        Data.set(m$.Fnc.$piece(Keys.get(),",",Key.get()));
        //<< if Data="" set Data = LastData       ; This is wrong but is the Intraprend way!
        if (mOp.Equal(Data.get(),"")) {
          Data.set(LastData.get());
        }
        //<< set DataList(Data) = ""
        DataList.var(Data.get()).set("");
        //<< if Key=1 set Data = "Key1"
        if (mOp.Equal(Key.get(),1)) {
          Data.set("Key1");
        }
        //<< set IndexKey = IndexKey_","_Data
        IndexKey.set(mOp.Concat(mOp.Concat(IndexKey.get(),","),Data.get()));
        //<< set LastData = Data
        LastData.set(Data.get());
      }
      //<< }
      //<< set IndexKey = IndexKey_","_SubList_")"
      IndexKey.set(mOp.Concat(mOp.Concat(mOp.Concat(IndexKey.get(),","),SubList.get()),")"));
      //<< set IndexSet = IndexSet+1
      IndexSet.set(mOp.Add(IndexSet.get(),1));
      //<< set IndexSet(IndexSet) = "  set:'Remove "_IndexKey_"="""""
      IndexSet.var(IndexSet.get()).set(mOp.Concat(mOp.Concat("  set:'Remove ",IndexKey.get()),"=\"\""));
      //<< 
      //<< set IndexSet = IndexSet+1
      IndexSet.set(mOp.Add(IndexSet.get(),1));
      //<< set IndexSet(IndexSet) = "  kill:Remove "_IndexKey
      IndexSet.var(IndexSet.get()).set(mOp.Concat("  kill:Remove ",IndexKey.get()));
      //<< 
      //<< set IndexSet = IndexSet+1
      IndexSet.set(mOp.Add(IndexSet.get(),1));
      //<< set IndexSet(IndexSet)=" }"
      IndexSet.var(IndexSet.get()).set(" }");
    }
    //<< }
    //<< set Data = ""
    Data.set("");
    //<< for {
    for (;true;) {
      //<< set Data = $order(DataList(Data))
      Data.set(m$.Fnc.$order(DataList.var(Data.get())));
      //<< quit:Data=""
      if (mOp.Equal(Data.get(),"")) {
        break;
      }
      //<< 
      //<< set Type    =  $extract(Data)
      Type.set(m$.Fnc.$extract(Data.get()));
      //<< set Num     = +$extract(Data,2,99)
      Num.set(mOp.Positive(m$.Fnc.$extract(Data.get(),2,99)));
      //<< set NewList = NewList_","_Data
      NewList.set(mOp.Concat(mOp.Concat(NewList.get(),","),Data.get()));
      //<< set Loc     = "$piece(Rec,Y,"_Num_")"
      Loc.set(mOp.Concat(mOp.Concat("$piece(Rec,Y,",Num.get()),")"));
      //<< if Type="K" {
      if (mOp.Equal(Type.get(),"K")) {
        //<< set Loc = "$get(Sub"_Num_")"
        Loc.set(mOp.Concat(mOp.Concat("$get(Sub",Num.get()),")"));
      }
      //<< }
      //<< ;SR17754 set DataSet(Data) = " set "_Data_"=$extract($translate("_Loc_",lc,uc),1,150) if "_Data_"="""" set "_Data_"="" """
      //<< set DataSet(Data) = " set "_Data_"=$extract($$Index^COMUtilIndex("_Loc_"),1,150)" ;SR17754
      DataSet.var(Data.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" set ",Data.get()),"=$extract($$Index^COMUtilIndex("),Loc.get()),"),1,150)"));
    }
    //<< 
    //<< }
    //<< ; ReIndex setup
    //<< set ReNewList="Key,Ret"
    ReNewList.set("Key,Ret");
    //<< set ListLoc="^"_Class_"("_Coy
    ListLoc.set(mOp.Concat(mOp.Concat(mOp.Concat("^",Class.get()),"("),Coy.get()));
    //<< 
    //<< for Sub=1:1:Subs {
    for (Sub.set(1);(mOp.LessOrEqual(Sub.get(),Subs.get()));Sub.set(mOp.Add(Sub.get(),1))) {
      //<< set Indent    = $justify("",Sub)
      Indent.set(m$.Fnc.$justify("",Sub.get()));
      //<< set Var       = "Sub"_Sub
      Var.set(mOp.Concat("Sub",Sub.get()));
      //<< set ReNewList = ReNewList_","_Var
      ReNewList.set(mOp.Concat(mOp.Concat(ReNewList.get(),","),Var.get()));
      //<< set ListLoc   = ListLoc_","_Var
      ListLoc.set(mOp.Concat(mOp.Concat(ListLoc.get(),","),Var.get()));
      //<< 
      //<< set LoopStartCode($increment(LoopStartCode)) = Indent_"set "_Var_"="""""
      LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(mOp.Concat(mOp.Concat(Indent.get(),"set "),Var.get()),"=\"\""));
      //<< set LoopStartCode($increment(LoopStartCode)) = Indent_"for {"
      LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(Indent.get(),"for {"));
      //<< set LoopStartCode($increment(LoopStartCode)) = Indent_" set "_Var_"=$order("_ListLoc_"))"
      LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(Indent.get()," set "),Var.get()),"=$order("),ListLoc.get()),"))"));
      //<< set LoopStartCode($increment(LoopStartCode)) = Indent_" quit:"_Var_"="""""
      LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(mOp.Concat(mOp.Concat(Indent.get()," quit:"),Var.get()),"=\"\""));
      //<< set LoopStartCode($increment(LoopStartCode)) = Indent_" quit:'Status"
      LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(Indent.get()," quit:'Status"));
      //<< set LoopStartCode($increment(LoopStartCode)) = Indent_" set $piece(Key,"","","_Sub_")="_Var
      LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(Indent.get()," set $piece(Key,\",\","),Sub.get()),")="),Var.get()));
      //<< if Sub=Subs {
      if (mOp.Equal(Sub.get(),Subs.get())) {
        //<< set LoopStartCode($increment(LoopStartCode)) = Indent_" do Index(Key)"
        LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(Indent.get()," do Index(Key)"));
        //<< set LoopStartCode($increment(LoopStartCode)) = Indent_" set Counter=Counter+1"
        LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(Indent.get()," set Counter=Counter+1"));
        //<< set LoopStartCode($increment(LoopStartCode)) = Indent_" set Sort=Sort+1"
        LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(Indent.get()," set Sort=Sort+1"));
        //<< set LoopStartCode($increment(LoopStartCode)) = Indent_" if Sort>1000000 set Sort=0 set Ret=$sortEnd(^"_Class_"s) set Ret=$sortBegin(^"_Class_"s)"
        LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(Indent.get()," if Sort>1000000 set Sort=0 set Ret=$sortEnd(^"),Class.get()),"s) set Ret=$sortBegin(^"),Class.get()),"s)"));
        //<< set LoopStartCode($increment(LoopStartCode)) = Indent_" if LastTime'=($zh\10) {"
        LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(Indent.get()," if LastTime'=($zh\\10) {"));
        //<< set LoopStartCode($increment(LoopStartCode)) = Indent_"  set LastTime=($zh\10)"
        LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(Indent.get(),"  set LastTime=($zh\\10)"));
        //<< set LoopStartCode($increment(LoopStartCode)) = Indent_"  if Verbose write !,$fn(Counter,"",""),"" "",$zdt($h,3)"
        LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(Indent.get(),"  if Verbose write !,$fn(Counter,\",\"),\" \",$zdt($h,3)"));
        //<< set LoopStartCode($increment(LoopStartCode)) = Indent_"  if Log'="""" do AddMessage^COMLog(Log,""ReIndexing Class "_Class_"   ""_$fn(Counter,"","")_"" Records Indexed"",.LogEntry)"
        LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(mOp.Concat(mOp.Concat(Indent.get(),"  if Log'=\"\" do AddMessage^COMLog(Log,\"ReIndexing Class "),Class.get()),"   \"_$fn(Counter,\",\")_\" Records Indexed\",.LogEntry)"));
        //<< set LoopStartCode($increment(LoopStartCode)) = Indent_"  if $get(^COMIndexSkip(0,Class)) set Status=""0~Skipped"""
        LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(Indent.get(),"  if $get(^COMIndexSkip(0,Class)) set Status=\"0~Skipped\""));
        //<< set LoopStartCode($increment(LoopStartCode)) = Indent_" }"
        LoopStartCode.var(m$.Fnc.$increment(LoopStartCode)).set(mOp.Concat(Indent.get()," }"));
      }
      //<< }
      //<< set LoopEndCode($increment(LoopEndCode)) = Indent_"}"
      LoopEndCode.var(m$.Fnc.$increment(LoopEndCode)).set(mOp.Concat(Indent.get(),"}"));
    }
    //<< }
    //<< 
    //<< set Rtn    = "idx."_Class
    Rtn.set(mOp.Concat("idx.",Class.get()));
    //<< set objRtn = ##class(%Routine).%New(Rtn_".mac")
    objRtn.set(m$.fnc$("$Routine.$New",mOp.Concat(Rtn.get(),".mac")));
    //<< set Status = objRtn.Clear()
    Status.set(m$.fnc$(objRtn.getORef(),"Clear"));
    //<< 
    //<< do objRtn.WriteLine(Class_"  ; Class Index compiled by routine 'COMIndex' Method CompileCode "_$zdt($h,3))
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(mOp.Concat(Class.get(),"  ; Class Index compiled by routine 'COMIndex' Method CompileCode "),m$.Fnc.$zdatetime(m$.Fnc.$horolog(),3)));
    //<< do objRtn.WriteLine("Index(Key,Remove=0)")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine","Index(Key,Remove=0)");
    //<< do objRtn.WriteLine(" new "_NewList)
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(" new ",NewList.get()));
    //<< ;BR014465
    //<< ;do objRtn.WriteLine(" set lc=""ÜÄÖüäöß][\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/""_$char(128)_"" """)
    //<< ;do objRtn.WriteLine(" set uc=""UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                  """)
    //<< ;SR17754 do objRtn.WriteLine(" set lc=""áàãâéèêíìîóòõôúùûçÜÄÖüäöß][\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/""_$char(128)_"" """)
    //<< ;SR17754 do objRtn.WriteLine(" set uc=""ÁÀÃÂÉÈÊÍÌÎÓÒÕÔÚÙÛÇUAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                  """)
    //<< 
    //<< 
    //<< set Sub = ""
    Sub.set("");
    //<< for {
    for (;true;) {
      //<< set Sub = $order(SubSet(Sub))
      Sub.set(m$.Fnc.$order(SubSet.var(Sub.get())));
      //<< quit:Sub=""
      if (mOp.Equal(Sub.get(),"")) {
        break;
      }
      //<< 
      //<< do objRtn.WriteLine(SubSet(Sub))
      m$.Cmd.Do(objRtn.getORef(),"WriteLine",SubSet.var(Sub.get()).get());
    }
    //<< }
    //<< do objRtn.WriteLine(" set Rec=$get("_DataLoc_")")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(mOp.Concat(" set Rec=$get(",DataLoc.get()),")"));
    //<< 
    //<< set Data = ""
    Data.set("");
    //<< for {
    for (;true;) {
      //<< set Data = $order(DataSet(Data))
      Data.set(m$.Fnc.$order(DataSet.var(Data.get())));
      //<< quit:Data=""
      if (mOp.Equal(Data.get(),"")) {
        break;
      }
      //<< 
      //<< do objRtn.WriteLine(DataSet(Data))
      m$.Cmd.Do(objRtn.getORef(),"WriteLine",DataSet.var(Data.get()).get());
    }
    //<< }
    //<< 
    //<< set Index = ""
    Index.set("");
    //<< for {
    for (;true;) {
      //<< set Index = $order(IndexSet(Index))
      Index.set(m$.Fnc.$order(IndexSet.var(Index.get())));
      //<< quit:Index=""
      if (mOp.Equal(Index.get(),"")) {
        break;
      }
      //<< 
      //<< do objRtn.WriteLine(IndexSet(Index))
      m$.Cmd.Do(objRtn.getORef(),"WriteLine",IndexSet.var(Index.get()).get());
    }
    //<< }
    //<< do objRtn.WriteLine(" quit")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," quit");
    //<< 
    //<< ; Update Code ;********************************************************************
    //<< do objRtn.WriteLine("Update(Key,Data="""",GetSet=0,Time=0)")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine","Update(Key,Data=\"\",GetSet=0,Time=0)");
    //<< do objRtn.WriteLine(" New Status,DataLoc,"_SubList)
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(" New Status,DataLoc,",SubList.get()));
    //<< do objRtn.WriteLine(" Set Status=0 ; Ok")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," Set Status=0 ; Ok");
    //<< do objRtn.WriteLine(" Set DataLoc=""^"_Class_"""_$select(Time=1:""t"",1:"""")_""(""""""")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(mOp.Concat(" Set DataLoc=\"^",Class.get()),"\"_$select(Time=1:\"t\",1:\"\")_\"(\"\"\""));
    //<< do objRtn.WriteLine(" Set DataLoc=DataLoc_"_Coy_"_"""""",""")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(mOp.Concat(" Set DataLoc=DataLoc_",Coy.get()),"_\"\"\",\""));
    //<< for Sub=1:1:Subs {
    for (Sub.set(1);(mOp.LessOrEqual(Sub.get(),Subs.get()));Sub.set(mOp.Add(Sub.get(),1))) {
      //<< do objRtn.WriteLine(" Set "_Var_"=$piece(Key,"","","_Sub_") set:"_Var_"="""" Status=2 Set DataLoc=DataLoc_""""""""_"_Var_"_"""""",""")
      m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" Set ",Var.get()),"=$piece(Key,\",\","),Sub.get()),") set:"),Var.get()),"=\"\" Status=2 Set DataLoc=DataLoc_\"\"\"\"_"),Var.get()),"_\"\"\",\""));
    }
    //<< }
    //<< do objRtn.WriteLine(" Set DataLoc=DataLoc_""1)""")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," Set DataLoc=DataLoc_\"1)\"");
    //<< do objRtn.WriteLine(" if Status'=0    { Set Data=""Error""} ; Error")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," if Status'=0    { Set Data=\"Error\"} ; Error");
    //<< do objRtn.WriteLine(" ElseIf GetSet=0 { Set Data=$get(@DataLoc) } ; Get Data")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," ElseIf GetSet=0 { Set Data=$get(@DataLoc) } ; Get Data");
    //<< do objRtn.WriteLine(" Elseif GetSet=1 { Set @DataLoc=Data      } ; Set Data")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," Elseif GetSet=1 { Set @DataLoc=Data      } ; Set Data");
    //<< do objRtn.WriteLine(" Elseif GetSet=2 { Set Data=DataLoc       } ; Get DataLoc")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," Elseif GetSet=2 { Set Data=DataLoc       } ; Get DataLoc");
    //<< do objRtn.WriteLine(" Else            { Set Status=3           } ; Poor GetSet Code")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," Else            { Set Status=3           } ; Poor GetSet Code");
    //<< do objRtn.WriteLine(" Quit Status")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," Quit Status");
    //<< 
    //<< ; Reindex Code
    //<< do objRtn.WriteLine("ReIndex(Verbose=0,Log=0,YM=0,Counter)") ; SR11483
    m$.Cmd.Do(objRtn.getORef(),"WriteLine","ReIndex(Verbose=0,Log=0,YM=0,Counter)");
    //<< do objRtn.WriteLine(" new LastTime,LogEntry,Sort,Status,"_ReNewList)
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(" new LastTime,LogEntry,Sort,Status,",ReNewList.get()));
    //<< do objRtn.WriteLine(" kill ^"_Class_"s("_Coy_")")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" kill ^",Class.get()),"s("),Coy.get()),")"));
    //<< do objRtn.WriteLine(" set Ret=$sortbegin(^"_Class_"s)")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(mOp.Concat(" set Ret=$sortbegin(^",Class.get()),"s)"));
    //<< do objRtn.WriteLine(" set Counter=0")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," set Counter=0");
    //<< do objRtn.WriteLine(" set Sort=0")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," set Sort=0");
    //<< do objRtn.WriteLine(" set Status=1")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," set Status=1");
    //<< do objRtn.WriteLine(" set LastTime=$zh")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," set LastTime=$zh");
    //<< 
    //<< set Sub = ""
    Sub.set("");
    //<< for {
    for (;true;) {
      //<< set Sub = $order(LoopStartCode(Sub))
      Sub.set(m$.Fnc.$order(LoopStartCode.var(Sub.get())));
      //<< quit:Sub=""
      if (mOp.Equal(Sub.get(),"")) {
        break;
      }
      //<< 
      //<< do objRtn.WriteLine(LoopStartCode(Sub))
      m$.Cmd.Do(objRtn.getORef(),"WriteLine",LoopStartCode.var(Sub.get()).get());
    }
    //<< }
    //<< 
    //<< set Sub = ""
    Sub.set("");
    //<< for {
    for (;true;) {
      //<< set Sub = $order(LoopEndCode(Sub))
      Sub.set(m$.Fnc.$order(LoopEndCode.var(Sub.get())));
      //<< quit:Sub=""
      if (mOp.Equal(Sub.get(),"")) {
        break;
      }
      //<< 
      //<< do objRtn.WriteLine(LoopEndCode(Sub))
      m$.Cmd.Do(objRtn.getORef(),"WriteLine",LoopEndCode.var(Sub.get()).get());
    }
    //<< }
    //<< do objRtn.WriteLine(" set Ret=$sortend(^"_Class_"s)")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(mOp.Concat(" set Ret=$sortend(^",Class.get()),"s)"));
    //<< do objRtn.WriteLine(" if Log'="""",Counter do AddMessage^COMLog(Log,""ReIndexing Class "_Class_" Complete  ""_$fn(Counter,"","")_"" Records Indexed, Company ""_YM,.LogEntry)") ; SR11483
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(mOp.Concat(" if Log'=\"\",Counter do AddMessage^COMLog(Log,\"ReIndexing Class ",Class.get())," Complete  \"_$fn(Counter,\",\")_\" Records Indexed, Company \"_YM,.LogEntry)"));
    //<< do objRtn.WriteLine(" quit Status")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine"," quit Status");
    //<< do objRtn.WriteLine("Version()")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine","Version()");
    //<< do objRtn.WriteLine(" Quit """_$$Version(Class)_"""")
    m$.Cmd.Do(objRtn.getORef(),"WriteLine",mOp.Concat(mOp.Concat(" Quit \"",m$.fnc$("Version",Class.get())),"\""));
    //<< do objRtn.Compile("-d")
    m$.Cmd.Do(objRtn.getORef(),"Compile","-d");
    //<< do objRtn.%Close()
    m$.Cmd.Do(objRtn.getORef(),"$Close");
    //<< quit
    return null;
  }

//<< 
//<< 
}
