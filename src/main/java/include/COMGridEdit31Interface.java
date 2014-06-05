//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMGridEdit31Interface
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:53:31
//*****************************************************************************

package include;

import mLibrary.*;


//<< #; COMGridEdit31Interface.inc
//<< #;##############################
//<< 
public class COMGridEdit31Interface extends mInclude {

  //<< #def1arg GRIDStart(%args)   do Start^COMGridEdit31(%args)
  public static Object $$$GRIDStart(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMGridEdit31.Start",p$args.get());
    return null;
  }

  //<< 
  //<< #define GRIDContainer   $get(^CacheTemp(YUSER,"Grid","Container"))
  public static Object $$$GRIDContainer(mContext m$) {
    return (m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")));
  }

  //<< 
  //<< 
  //<< #; Note: Count DOES include Total Row (3WM)
  //<< #; SR13634: WWWDATEN is NOT shared.
  //<< #; SR13659: Edited to look on disk
  //<< #;define EDITGRIDROWCOUNT(%f,%key)  $$$GetGlobal(^WWWDATEN(0,+$h,YUSER,%f,"V","ROWCOUNT"),$$DiskCount^COMGridEdit31Globals(%f,%key))
  //<< 
  //<< #def1arg GRIDGetRowCount(%args) $$RowCount^COMGridEdit31Globals(%args)
  public static Object $$$GRIDGetRowCount(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMGridEdit31Globals.RowCount",p$args.get()));
  }

  //<< 
  //<< 
  //<< 
  //<< // Constants
  //<< #define GRIDAllowLinkedLines            +$get(^CacheTemp(YUSER,"Grid","ExpandLines"))
  public static Object $$$GRIDAllowLinkedLines(mContext m$) {
    return (mOp.Positive(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","ExpandLines"))));
  }

  //<< 
  //<< 
  //<< // Update
  //<< #def1arg GRIDUpdateManualField(%args)   do UpdateManualField^COMGridEdit31G(%args)
  public static Object $$$GRIDUpdateManualField(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMGridEdit31G.UpdateManualField",p$args.get());
    return null;
  }

  //<< 
  //<< 
  //<< 
  //<< #define GRIDAddBatchStart               set ^CacheTemp(YUSER,"Grid","AddBatch") = $$$YES
  public static Object $$$GRIDAddBatchStart(mContext m$) {
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","AddBatch").set(include.COMSYS.$$$YES(m$));
    return null;
  }

  //<< #define GRIDAddBatchStop                do DisplayBatchLines^COMGridEdit31Add()
  public static Object $$$GRIDAddBatchStop(mContext m$) {
    m$.Cmd.Do("COMGridEdit31Add.DisplayBatchLines");
    return null;
  }

  //<< #define GRIDAddBatchStopNoDraw          do DisplayBatchLines^COMGridEdit31Add($$$NO)
  public static Object $$$GRIDAddBatchStopNoDraw(mContext m$) {
    m$.Cmd.Do("COMGridEdit31Add.DisplayBatchLines",include.COMSYS.$$$NO(m$));
    return null;
  }

  //<< 
  //<< #def1arg GRIDAddLine(%args)             do AddLine^COMGridEdit31Add(%args)
  public static Object $$$GRIDAddLine(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMGridEdit31Add.AddLine",p$args.get());
    return null;
  }

  //<< #def1arg GRIDInsertLine(%args)          do InsertLine^COMGridEdit31Add(%args)
  public static Object $$$GRIDInsertLine(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMGridEdit31Add.InsertLine",p$args.get());
    return null;
  }

  //<< 
  //<< #def1arg GRIDHideShowRows(%args)        do HideShowRows^COMGridEdit31R(%args)
  public static Object $$$GRIDHideShowRows(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMGridEdit31R.HideShowRows",p$args.get());
    return null;
  }

  //<< #def1arg GRIDHideShowColumns(%args)     do HideShowColumns^COMGridEdit31R(%args)
  public static Object $$$GRIDHideShowColumns(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMGridEdit31R.HideShowColumns",p$args.get());
    return null;
  }

  //<< 
  //<< #define GRIDGetCurrentYKEY              $$GetKey^COMGridEdit31G()
  public static Object $$$GRIDGetCurrentYKEY(mContext m$) {
    return (m$.fnc$("COMGridEdit31G.GetKey"));
  }

  //<< #define GRIDGetYFELD(%key)              $$GetYFELDEX^COMGridEdit31G(,%key)
  public static Object $$$GRIDGetYFELD(mContext m$, Object ... _p) {
    mVar p$key = m$.varRef("p$key",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMGridEdit31G.GetYFELDEX",null,p$key.get()));
  }

  //<< #def1arg GRIDGetContents(%args)         do GetGridContents^COMGridEdit31G(%args)
  public static Object $$$GRIDGetContents(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMGridEdit31G.GetGridContents",p$args.get());
    return null;
  }

  //<< #def1arg GRIDSetContents(%args)         do SetGridContents^COMGridEdit31G(%args)
  public static Object $$$GRIDSetContents(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMGridEdit31G.SetGridContents",p$args.get());
    return null;
  }

  //<< 
  //<< #;SR13305
  //<< #define GRIDName                        $get(^CacheTemp(YUSER,"Grid","Name"))
  public static Object $$$GRIDName(mContext m$) {
    return (m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
  }

  //<< 
  //<< #define GRIDYKEYContainer               $$GetYKEYContainer^COMGridEdit31Interface()
  public static Object $$$GRIDYKEYContainer(mContext m$) {
    return (m$.fnc$("COMGridEdit31Interface.GetYKEYContainer"));
  }

  //<< #define GRIDYFELDContainer              $$GetYFELDContainer^COMGridEdit31G()
  public static Object $$$GRIDYFELDContainer(mContext m$) {
    return (m$.fnc$("COMGridEdit31G.GetYFELDContainer"));
  }

  //<< #define GRIDYMFELDContainer             $$GetYMFELDContainer^COMGridEdit31G()
  public static Object $$$GRIDYMFELDContainer(mContext m$) {
    return (m$.fnc$("COMGridEdit31G.GetYMFELDContainer"));
  }

  //<< #define GRIDPREVYMFELDContainer         $$GetYMFELDContainer^COMGridEdit31G(2)
  public static Object $$$GRIDPREVYMFELDContainer(mContext m$) {
    return (m$.fnc$("COMGridEdit31G.GetYMFELDContainer",2));
  }

  //<< 
  //<< #def1arg GRIDGoToForm(%args)            do GoToForm^COMGridEdit31G(%args)
  public static Object $$$GRIDGoToForm(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMGridEdit31G.GoToForm",p$args.get());
    return null;
  }

  //<< #def1arg GRIDReloadForm(%args)          do ReloadForm^COMGridEdit31G(%args)
  public static Object $$$GRIDReloadForm(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMGridEdit31G.ReloadForm",p$args.get());
    return null;
  }

  //<< 
  //<< #def1arg GRIDSave(%args)                $$SAVE^COMGridEdit31Save(%args)
  public static Object $$$GRIDSave(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMGridEdit31Save.SAVE",p$args.get()));
  }

  //<< #define GRIDDelete                      do DELETE^COMGridEdit31R()
  public static Object $$$GRIDDelete(mContext m$) {
    m$.Cmd.Do("COMGridEdit31R.DELETE");
    return null;
  }

  //<< #define GRIDSplitKey(%dat,%1,%2)        set %2=$piece(%dat,"_",2) set %1=$translate($piece(%dat,"_",1),"tdY")
  public static Object $$$GRIDSplitKey(mContext m$, Object ... _p) {
    mVar p$dat = m$.varRef("p$dat",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    p$2.set(m$.Fnc.$piece(p$dat.get(),"_",2));
    p$1.set(m$.Fnc.$translate(m$.Fnc.$piece(p$dat.get(),"_",1),"tdY"));
    return null;
  }

  //<< 
  //<< #; FIXME : <GRF> $$Duplicate not Duplicate - macro only in INReqCommon
  //<< #;define GRIDDuplicate                  do Duplicate^COMGridEdit31Add() ; SR15739
  //<< #define GRIDDuplicate                   do Duplicate^COMGridEdit31Copy()
  public static Object $$$GRIDDuplicate(mContext m$) {
    m$.Cmd.Do("COMGridEdit31Copy.Duplicate");
    return null;
  }

  //<< #define GRIDGetOriginalValue            $get(^WWWDATEN(0,+$h,YUSER,YFORM,"V",YLFDAT,2))
  public static Object $$$GRIDGetOriginalValue(mContext m$) {
    return (m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",m$.var("YLFDAT").get(),2)));
  }

  //<< #define GRIDGetPreviousValue            $get(^WWWDATEN(0,+$h,YUSER,YFORM,"V",YLFDAT,"Previous"))
  public static Object $$$GRIDGetPreviousValue(mContext m$) {
    return (m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",m$.var("YLFDAT").get(),"Previous")));
  }

  //<< #define GRIDSetPreviousValue(%1)        set ^WWWDATEN(0,+$h,YUSER,YFORM,"V",YLFDAT,"Previous")=%1
  public static Object $$$GRIDSetPreviousValue(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",m$.var("YLFDAT").get(),"Previous").set(p$1.get());
    return null;
  }

  //<< #define GRIDIsPreviousValueSet          '$data(^WWWDATEN(0,+$h,YUSER,YFORM,"V",YLFDAT,"Previous"))
  public static Object $$$GRIDIsPreviousValueSet(mContext m$) {
    return (mOp.Not(m$.Fnc.$data(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",m$.var("YLFDAT").get(),"Previous"))));
  }

  //<< #define GRIDGetTempValue                $get(^WWWDATEN(0,+$h,YUSER,YFORM,"V",YLFDAT,"Temp"))
  public static Object $$$GRIDGetTempValue(mContext m$) {
    return (m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",m$.var("YLFDAT").get(),"Temp")));
  }

  //<< #define GRIDSetTempValue(%1)            set ^WWWDATEN(0,+$h,YUSER,YFORM,"V",YLFDAT,"Temp")=%1
  public static Object $$$GRIDSetTempValue(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",m$.var("YLFDAT").get(),"Temp").set(p$1.get());
    return null;
  }

  //<< #define GRIDIsTempValueSet              '$data(^WWWDATEN(0,+$h,YUSER,YFORM,"V",YLFDAT,"Temp"))
  public static Object $$$GRIDIsTempValueSet(mContext m$) {
    return (mOp.Not(m$.Fnc.$data(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",m$.var("YLFDAT").get(),"Temp"))));
  }

  //<< #define GRIDColumnOrder                 $get(^CacheTemp(YUSER,"Grid",YFORM,"COLUMNORDER"))
  public static Object $$$GRIDColumnOrder(mContext m$) {
    return (m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid",m$.var("YFORM").get(),"COLUMNORDER")));
  }

}
