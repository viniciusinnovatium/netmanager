//*****************************************************************************
//** TASC - ALPHALINC - CLASS alSYS.Session.Session
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:03
//*****************************************************************************

package alSYS.Session;

import mLibrary.*;

//<< Include %occInclude
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;

//<< 
//<< Class alSYS.Session.Session Extends %Persistent [ Not Abstract, ClassType = persistent, ProcedureBlock ]
public class Session extends mPersistent {
  //<< {
  //<< 
  //<< Property Var As %String(TRUNCATE = 1) [ MultiDimensional ];
  public mMultiDimensional Var;

  //<< 
  //<< /// Capture Session Variables
  //<< Method Capture() As %Status [ ProcedureBlock = 0 ]
  public Object Capture(Object ... _p) {
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; 26-Oct-2007   SCR     SR15606: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnLogging,blnOk,intCount,intEntry,sc,strStart,strVar
    mVar blnLogging = m$.var("blnLogging");
    mVar blnOk = m$.var("blnOk");
    mVar intCount = m$.var("intCount");
    mVar intEntry = m$.var("intEntry");
    mVar sc = m$.var("sc");
    mVar strStart = m$.var("strStart");
    mVar strVar = m$.var("strVar");
    m$.newVar(blnLogging,blnOk,intCount,intEntry,sc,strStart,strVar);
    //<< set sc=$$$OK  ; OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< kill ..Var          ; Kill Existing
    m$.prop(this,"Var").kill();
    //<< 
    //<< set intCount=0      ; Used for Logging
    intCount.set(0);
    //<< set strStart=$zh    ; Used for Logging
    strStart.set(m$.Fnc.$zhorolog());
    //<< set blnLogging=0    ; Used for Logging
    blnLogging.set(0);
    //<< 
    //<< set strVar="%"  ; Start of Variables
    strVar.set("%");
    //<< for {
    for (;true;) {
      //<< set strVar=$order(@strVar)  ; get next var
      strVar.set(m$.Fnc.$order(m$.indirectVar(strVar.get())));
      //<< quit:strVar=""
      if (mOp.Equal(strVar.get(),"")) {
        break;
      }
      //<< 
      //<< set blnOk=0  ; Assume the Variable is not ok to Load into the Var array
      blnOk.set(0);
      //<< 
      //<< if $extract(strVar)="Y" set blnOk=1     ; Load all Y vars
      if (mOp.Equal(m$.Fnc.$extract(strVar.get()),"Y")) {
        blnOk.set(1);
      }
      //<< if strVar="LANGUAGE"    set blnOk=1     ; Include Language
      if (mOp.Equal(strVar.get(),"LANGUAGE")) {
        blnOk.set(1);
      }
      //<< if strVar="SPRACHE"     set blnOk=1     ; Include Language
      if (mOp.Equal(strVar.get(),"SPRACHE")) {
        blnOk.set(1);
      }
      //<< 
      //<< if blnOk=1 {
      if (mOp.Equal(blnOk.get(),1)) {
        //<< set intCount=intCount+1
        intCount.set(mOp.Add(intCount.get(),1));
        //<< merge ..Var(strVar)=@strVar
        m$.Cmd.Merge(m$.prop(this,"Var").var(strVar.get()),m$.indirectVar(strVar.get()));
      }
    }
    //<< }
    //<< }
    //<< if blnLogging {
    if (mOp.Logical(blnLogging.get())) {
      //<< set intEntry=$increment(^CacheTemp("alSession"))
      intEntry.set(m$.Fnc.$increment(m$.var("^CacheTemp","alSession")));
      //<< set ^CacheTemp("alSession",intEntry)="Capture|"_($zh-strStart)_"|"_intCount
      m$.var("^CacheTemp","alSession",intEntry.get()).set(mOp.Concat(mOp.Concat(mOp.Concat("Capture|",(mOp.Subtract(m$.Fnc.$zhorolog(),strStart.get()))),"|"),intCount.get()));
    }
    //<< }
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< /// Set the Variables from the Var property
  //<< Method Set() As %Status [ ProcedureBlock = 0 ]
  public Object Set(Object ... _p) {
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; 26-Oct-2007   SCR     SR15606: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnLogging,intEntry,sc,strStart,strVar
    mVar blnLogging = m$.var("blnLogging");
    mVar intEntry = m$.var("intEntry");
    mVar sc = m$.var("sc");
    mVar strStart = m$.var("strStart");
    mVar strVar = m$.var("strVar");
    m$.newVar(blnLogging,intEntry,sc,strStart,strVar);
    //<< 
    //<< set sc=$$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set intCount=0      ; Used for Logging
    mVar intCount = m$.var("intCount");
    intCount.set(0);
    //<< set strStart=$zh    ; Used for Logging
    strStart.set(m$.Fnc.$zhorolog());
    //<< set blnLogging=0    ; Used for Logging
    blnLogging.set(0);
    //<< 
    //<< set strVar=""       ; Start Pos
    strVar.set("");
    //<< 
    //<< for intCount=0:1 {
    for (intCount.set(0);(true);intCount.set(mOp.Add(intCount.get(),1))) {
      //<< set strVar=$order(..Var(strVar))
      strVar.set(m$.Fnc.$order(m$.prop(this,"Var").var(strVar.get())));
      //<< quit:strVar=""
      if (mOp.Equal(strVar.get(),"")) {
        break;
      }
      //<< 
      //<< merge @strVar=..Var(strVar) ; Restore Variable
      m$.Cmd.Merge(m$.indirectVar(strVar.get()),m$.prop(this,"Var").var(strVar.get()));
    }
    //<< }
    //<< if blnLogging {
    if (mOp.Logical(blnLogging.get())) {
      //<< set intEntry=$increment(^CacheTemp("alSession"))
      intEntry.set(m$.Fnc.$increment(m$.var("^CacheTemp","alSession")));
      //<< set ^CacheTemp("alSession",intEntry)="Set|"_($zh-strStart)_"|"_intCount
      m$.var("^CacheTemp","alSession",intEntry.get()).set(mOp.Concat(mOp.Concat(mOp.Concat("Set|",(mOp.Subtract(m$.Fnc.$zhorolog(),strStart.get()))),"|"),intCount.get()));
    }
    //<< }
    //<< quit sc
    return sc.get();
  //<< }
  }

//<< 
//<< }
}
