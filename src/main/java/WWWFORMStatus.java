//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMStatus
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:49
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

//<< WWWFORMStatus
public class WWWFORMStatus extends mClass {

  public void main() {
    _WWWFORMStatus();
  }

  public void _WWWFORMStatus() {
  }

  //<< 
  //<< CheckStatus()
  public Object CheckStatus(Object ... _p) {
    //<< ;/*------------------------------------------------------------------------------
    //<< ; Check whether datafields have changed - update status
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns: nil
    //<< ;
    //<< ; History:
    //<< ; 1-Dec-2005    JW      SR13195: Created
    //<< ;-----------------------------------------------------------------------------*/
    //<< new idStatus,newStatus
    mVar idStatus = m$.var("idStatus");
    mVar newStatus = m$.var("newStatus");
    m$.newVar(idStatus,newStatus);
    //<< 
    //<< if ($get(YART)="D") && '$$GridHasChanged() {
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YART")),"D")) && mOp.Not(m$.fnc$("GridHasChanged"))) {
      //<< 
      //<< // 1: New
      //<< // 2: Save Changes
      //<< // 3: Saved
      //<< // 4: Data Item in Use
      //<< set idStatus = $get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"STATUS",1))
      idStatus.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"STATUS",1)));
      //<< set newStatus = idStatus
      newStatus.set(idStatus.get());
      //<< 
      //<< if idStatus=$$$Changed {        // Changes have been made
      if (mOp.Equal(idStatus.get(),include.COMSYSWWW.$$$Changed(m$))) {
        //<< if '$$Changed() {
        if (mOp.Not(m$.fnc$("Changed"))) {
          //<< set newStatus = $case($$IsNewRecord(), $$$YES:$$$New, $$$NO:$$$Saved )
          newStatus.set(m$.Fnc.$case(m$.fnc$("IsNewRecord"),include.COMSYS.$$$YES(m$),include.COMSYSWWW.$$$New(m$),include.COMSYS.$$$NO(m$),include.COMSYSWWW.$$$Saved(m$)));
        }
      }
      //<< }
      //<< 
      //<< } elseif idStatus'=$$$InUse {       // Record is not in use
      else if (mOp.NotEqual(idStatus.get(),include.COMSYSWWW.$$$InUse(m$))) {
        //<< if $$Changed(YLFN) {
        if (mOp.Logical(m$.fnc$("Changed",m$.var("YLFN").get()))) {
          //<< set newStatus = $$$Changed
          newStatus.set(include.COMSYSWWW.$$$Changed(m$));
        }
      }
      //<< }
      //<< }
      //<< do UpdateStatus(YFORM,newStatus)
      m$.Cmd.Do("UpdateStatus",m$.var("YFORM").get(),newStatus.get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Changed(pintPiece=0)
  public Object Changed(Object ... _p) {
    mVar pintPiece = m$.newVarRef("pintPiece",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check whether (a piece of) the form has changed
    //<< ;
    //<< ; Inputs: YART,YFORM,YUSER
    //<< ;
    //<< ; Params: pintPiece - piece to check. if not defined, it checks entire form
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ;  1-Dec-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idx,val
    mVar idx = m$.var("idx");
    mVar val = m$.var("val");
    m$.newVar(idx,val);
    //<< 
    //<< for idx=1:1:2 {
    for (idx.set(1);(mOp.LessOrEqual(idx.get(),2));idx.set(mOp.Add(idx.get(),1))) {
      //<< set val(idx) = $get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,YART,idx))
      val.var(idx.get()).set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),m$.var("YART").get(),idx.get())));
      //<< if pintPiece set val(idx) = $piece(val(idx),Y,YLFN)
      if (mOp.Logical(pintPiece.get())) {
        val.var(idx.get()).set(m$.Fnc.$piece(val.var(idx.get()).get(),m$.var("Y").get(),m$.var("YLFN").get()));
      }
    }
    //<< }
    //<< 
    //<< quit val(1)'=val(2)
    return mOp.NotEqual(val.var(1).get(),val.var(2).get());
  }

  //<< 
  //<< 
  //<< UpdateStatus(pstrForm,pnewStatus,pblnForce=$$$NO,pstrText="")
  public Object UpdateStatus(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pnewStatus = m$.newVarRef("pnewStatus",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnForce = m$.newVarRef("pblnForce",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;/*-------------------------------------------------------------------------------
    //<< ; Update the "changed" status of the form
    //<< ;
    //<< ; Params:   pstrForm - form to change
    //<< ;           pnewStatus - new status (BEARBEITUNG app param)
    //<< ;           pblnForce - whether to force the change
    //<< ;           pstrText - override of the default text
    //<< ;
    //<< ; ByRefs: nil
    //<< ;
    //<< ; Returns: nil
    //<< ;
    //<< ; History:
    //<< ; 12-Dec-2007   LB      SR15598: Surrounded write with start & end JavaScript Macros
    //<< ;  6-Jul-2006   JW      Added SysEnum macro; changed pblnForce default "" -> $$$NO
    //<< ; 09-Dec-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< new oldStatus
    mVar oldStatus = m$.var("oldStatus");
    m$.newVar(oldStatus);
    //<< 
    //<< set oldStatus = $get(^WWWDATEN(YM,+$horolog,YUSER,pstrForm,"STATUS",1))
    oldStatus.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pstrForm.get(),"STATUS",1)));
    //<< 
    //<< if pblnForce || (pnewStatus '= oldStatus) {
    if (mOp.Logical(pblnForce.get()) || (mOp.NotEqual(pnewStatus.get(),oldStatus.get()))) {
      //<< set ^WWWDATEN(YM,+$horolog,YUSER,pstrForm,"STATUS",1) = pnewStatus
      m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pstrForm.get(),"STATUS",1).set(pnewStatus.get());
      //<< if pstrText = "" set pstrText = $$$SysEnum("BEARBEITUNG",pnewStatus)
      if (mOp.Equal(pstrText.get(),"")) {
        pstrText.set(include.COMSYSWWW.$$$SysEnum(m$,"BEARBEITUNG",pnewStatus));
      }
      //<< 
      //<< $$$StartScript()
      include.COMSYS.$$$StartScript(m$);
      //<< write " BEARB("""_pstrText_""","_(pnewStatus'=$$$Changed)_");"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" BEARB(\"",pstrText.get()),"\","),(mOp.NotEqual(pnewStatus.get(),include.COMSYSWWW.$$$Changed(m$)))),");"));
      //<< $$$EndScript()
      include.COMSYS.$$$EndScript(m$);
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< IsNewRecord()
  public Object IsNewRecord(Object ... _p) {
    //<< ;/*-------------------------------------------------------------------------------
    //<< ; Determine whether the current record is on disk or new.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Nov-2008   HQN     Additional check for multipiece keys, check last key
    //<< ;                       for new strings too
    //<< ; 29-May-2006   JW      Remove + and ,
    //<< ; 01-Dec-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< new oldKey,newKey,blnNew,strOldKey,strNewKey
    mVar oldKey = m$.var("oldKey");
    mVar newKey = m$.var("newKey");
    mVar blnNew = m$.var("blnNew");
    mVar strOldKey = m$.var("strOldKey");
    mVar strNewKey = m$.var("strNewKey");
    m$.newVar(oldKey,newKey,blnNew,strOldKey,strNewKey);
    //<< 
    //<< ; 19-Nov-2008 vvvv
    //<< set strOldKey = $get(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"P",2))
    strOldKey.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",2)));
    //<< set strNewKey = $get(^WWWDATEN(YM,+$HOROLOG,YUSER,YFORM,"P",1))
    strNewKey.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1)));
    //<< ; 19-Nov-2008 ^^^^
    //<< set oldKey = $translate(strOldKey,"+,")
    oldKey.set(m$.Fnc.$translate(strOldKey.get(),"+,"));
    //<< set newKey = $translate(strNewKey,"+,")
    newKey.set(m$.Fnc.$translate(strNewKey.get(),"+,"));
    //<< ;set blnNew = (oldKey="") || (oldKey'=newKey) ; 19-Nov-2008
    //<< set blnNew = (oldKey="") || (oldKey'=newKey) || ($length(strOldKey,$$$COMMA)'=$length(strNewKey,$$$COMMA)) || ($piece(strNewKey,$$$COMMA,$length(strNewKey,$$$COMMA)) = "+")
    blnNew.set((mOp.Equal(oldKey.get(),"")) || (mOp.NotEqual(oldKey.get(),newKey.get())) || (mOp.NotEqual(m$.Fnc.$length(strOldKey.get(),include.COMSYSString.$$$COMMA(m$)),m$.Fnc.$length(strNewKey.get(),include.COMSYSString.$$$COMMA(m$)))) || (mOp.Equal(m$.Fnc.$piece(strNewKey.get(),include.COMSYSString.$$$COMMA(m$),m$.Fnc.$length(strNewKey.get(),include.COMSYSString.$$$COMMA(m$))),"+")));
    //<< 
    //<< quit blnNew
    return blnNew.get();
  }

  //<< 
  //<< 
  //<< GridHasChanged()
  public Object GridHasChanged(Object ... _p) {
    //<< ;/*-------------------------------------------------------------------------------
    //<< ; Whether any of the grids have changed
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  boolean
    //<< ;
    //<< ; History:
    //<< ; 02-Dec-2005   JW      SR13195: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< new idGrid,blnChanged
    mVar idGrid = m$.var("idGrid");
    mVar blnChanged = m$.var("blnChanged");
    m$.newVar(idGrid,blnChanged);
    //<< 
    //<< set blnChanged=$$$NO
    blnChanged.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set idGrid=""
    idGrid.set("");
    //<< for {
    for (;true;) {
      //<< set idGrid = $order(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"Grid",idGrid))
      idGrid.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"Grid",idGrid.get())));
      //<< quit:(idGrid="")
      if ((mOp.Equal(idGrid.get(),""))) {
        break;
      }
      //<< continue:$get(^WWWDATEN(YM,+$horolog,YUSER,idGrid,"V","STATUS",1))'=$$$Changed
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),idGrid.get(),"V","STATUS",1)),include.COMSYSWWW.$$$Changed(m$))) {
        continue;
      }
      //<< 
      //<< set blnChanged = $$$YES
      blnChanged.set(include.COMSYS.$$$YES(m$));
      //<< quit
      break;
    }
    //<< }
    //<< 
    //<< quit blnChanged
    return blnChanged.get();
  }

//<< 
//<< 
//<< 
}
