//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMGridEdit31
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:53:31
//*****************************************************************************

package include;

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

public class COMGridEdit31 extends mInclude {

  //<< 
  //<< #define GRIDName            $get(^CacheTemp(YUSER,"Grid","Name"))
  public static Object $$$GRIDName(mContext m$) {
    return (m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
  }

  //<< ;BR014943 definition of GRIDPerPage/GRIDNumPages changed
  //<< ;SR16026 Removed
  //<< // #define GRIDPerPage     ^COMGridEditPerPage(YBED,YFORM,"Grid","PerPage")
  //<< 
  //<< 
  //<< //Globals
  //<< #define GRIDYVOR(%f)        $$$GetGlobal(^CacheTemp(YUSER,"Grid",%f,"YVOR"),$$GetYVOR^COMGridEdit31Globals(%f))
  public static Object $$$GRIDYVOR(mContext m$, Object ... _p) {
    mVar p$f = m$.varRef("p$f",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (include.COMSYS.$$$GetGlobal(m$,m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid",p$f.get(),"YVOR"),m$.fnc$("COMGridEdit31Globals.GetYVOR",p$f.get())));
  }

  //<< 
  //<< #define GRIDClass(%f)       $$$GetGlobal(^WWWDATEN(0,+$H,YUSER,%f,"V","REFERENCECLASS",1),$$REFERENCECLASS^COMGridEdit31Globals(%f))
  public static Object $$$GRIDClass(mContext m$, Object ... _p) {
    mVar p$f = m$.varRef("p$f",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (include.COMSYS.$$$GetGlobal(m$,m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),p$f.get(),"V","REFERENCECLASS",1),m$.fnc$("COMGridEdit31Globals.REFERENCECLASS",p$f.get())));
  }

  //<< 
  //<< #define GRIDRowCount        ^WWWDATEN(0,+$H,YUSER,YFORM,"V","ROWCOUNT")
  public static Object $$$GRIDRowCount(mContext m$) {
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","ROWCOUNT").get());
  }

  public static mVar $$$GRIDRowCountVar(mContext m$, Object ... _p) {
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","ROWCOUNT"));
  }

  //<< #define GRIDViewableRows    ($get($$$GRIDRowCount)-$get(^WWWDATEN(0,+$H,YUSER,YFORM,"V","HIDDEN")))
  public static Object $$$GRIDViewableRows(mContext m$) {
    return ((mOp.Subtract(m$.Fnc.$get($$$GRIDRowCountVar(m$)),m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","HIDDEN")))));
  }

  //<< #define GRIDPage            ^WWWDATEN(0,+$H,YUSER,YFORM,"V","PAGE")
  public static Object $$$GRIDPage(mContext m$) {
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","PAGE").get());
  }

  public static mVar $$$GRIDPageVar(mContext m$, Object ... _p) {
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","PAGE"));
  }

  //<< 
  //<< ;SR16026 Changed to use function for RowsPerPage
  //<< #define GRIDNumPages        ((($select($$$GRIDViewableRows=0:1,1:$$$GRIDViewableRows)-1) / $$GetRowsPerPage^COMGridEdit31(YBED,YFORM) + 1) \ 1)
  public static Object $$$GRIDNumPages(mContext m$) {
    return ((mOp.IntegerDivide((mOp.Add(mOp.Divide((mOp.Subtract(m$.Fnc.$select(mOp.Equal($$$GRIDViewableRows(m$),0),1,1,$$$GRIDViewableRows(m$)),1)),m$.fnc$("COMGridEdit31.GetRowsPerPage",m$.var("YBED").get(),m$.var("YFORM").get())),1)),1)));
  }

  //<< 
  //<< #define GRIDGetFirstCell(%row)  "tdY"_(%row)_"_"_$$GetFirstColumn^COMGridEdit31(YFORM)
  public static Object $$$GRIDGetFirstCell(mContext m$, Object ... _p) {
    mVar p$row = m$.varRef("p$row",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mOp.Concat(mOp.Concat(mOp.Concat("tdY",(p$row.get())),"_"),m$.fnc$("COMGridEdit31.GetFirstColumn",m$.var("YFORM").get())));
  }

  //<< 
  //<< #define GRIDGoToPage(%a,%b,%c,%d)       " GoToPage("_%a_","_%b_","""_%c_""","_%d_");"
  public static Object $$$GRIDGoToPage(mContext m$, Object ... _p) {
    mVar p$a = m$.varRef("p$a",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$b = m$.varRef("p$b",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$c = m$.varRef("p$c",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar p$d = m$.varRef("p$d",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    return (mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" GoToPage(",p$a.get()),","),p$b.get()),",\""),p$c.get()),"\","),p$d.get()),");"));
  }

  //<< #define GRIDIdx(%row)       $translate(%row,"x",".")
  public static Object $$$GRIDIdx(mContext m$, Object ... _p) {
    mVar p$row = m$.varRef("p$row",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$translate(p$row.get(),"x","."));
  }

  //<< 
  //<< #define SetFocusField(%1)   set ^WWWDATEN(0,+$h,YUSER,$$$GRIDName,"V","FOCUSFIELD") = %1
  public static Object $$$SetFocusField(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),$$$GRIDName(m$),"V","FOCUSFIELD").set(p$1.get());
    return null;
  }

  //<< #define FLDRelError(%1)     ^WWWDATEN(0,+$horolog,YUSER,YFORM,"V","ERROR",%1)
  public static Object $$$FLDRelError(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","ERROR",p$1.get()).get());
  }

  public static mVar $$$FLDRelErrorVar(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","ERROR",p$1.get()));
  }

  //<< #define FLDMandatory(%1)    ^WWWDATEN(0,+$horolog,YUSER,YFORM,"V","REQ",%1)
  public static Object $$$FLDMandatory(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","REQ",p$1.get()).get());
  }

  public static mVar $$$FLDMandatoryVar(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","REQ",p$1.get()));
  }

  //<< #def1arg WWWDATEN(%args)    ^WWWDATEN(0,+$horolog,YUSER,YFORM,"V",%args)
  public static Object $$$WWWDATEN(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",p$args.get()).get());
  }

  public static mVar $$$WWWDATENVar(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",p$args.get()));
  }

  //<< 
  //<< 
  //<< #; Use $$$KilledRecord(Row,Form) - returns whether killed
  //<< #define KilledRecord(%r,%f)     ($get(^WWWDATEN(0,+$h,YUSER,%f,"V","KILLEDRECORD",%r))'="")
  public static Object $$$KilledRecord(mContext m$, Object ... _p) {
    mVar p$r = m$.varRef("p$r",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$f = m$.varRef("p$f",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return ((mOp.NotEqual(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),p$f.get(),"V","KILLEDRECORD",p$r.get())),"")));
  }

  //<< #define ViewableRow(%r,%f)      ('$$$KilledRecord(%r,%f)&&($get(^WWWDATEN(0,+$h,YUSER,%f,"V","HIDDEN",%r))=""))
  public static Object $$$ViewableRow(mContext m$, Object ... _p) {
    mVar p$r = m$.varRef("p$r",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$f = m$.varRef("p$f",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return ((mOp.Not($$$KilledRecord(m$,p$r,p$f)) && (mOp.Equal(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),p$f.get(),"V","HIDDEN",p$r.get())),""))));
  }

  //<< #define DisplayedRecord(%r,%f)  ($get(^WWWDATEN(0,+$h,YUSER,%f,"V","DISPLAYED",$$$GRIDIdx(%r)))'="")
  public static Object $$$DisplayedRecord(mContext m$, Object ... _p) {
    mVar p$r = m$.varRef("p$r",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$f = m$.varRef("p$f",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return ((mOp.NotEqual(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),p$f.get(),"V","DISPLAYED",$$$GRIDIdx(m$,p$r))),"")));
  }

  //<< 
  //<< 
  //<< #; Don't call events if function doesn't exist
  //<< #define EventExists(%event)             ^CacheTempEvent(YUCI,YFORM,%event)
  public static Object $$$EventExists(mContext m$, Object ... _p) {
    mVar p$event = m$.varRef("p$event",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^CacheTempEvent",m$.var("YUCI").get(),m$.var("YFORM").get(),p$event.get()).get());
  }

  public static mVar $$$EventExistsVar(mContext m$, Object ... _p) {
    mVar p$event = m$.varRef("p$event",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^CacheTempEvent",m$.var("YUCI").get(),m$.var("YFORM").get(),p$event.get()));
  }

  //<< 
  //<< #def1arg OnBeforeDisplayLine(%args)     ($get($$$EventExists("Display"))=$$$NO || $$OnBeforeDisplayLine^COMGridEdit31Events(%args))
  public static Object $$$OnBeforeDisplayLine(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal(m$.Fnc.$get($$$EventExistsVar(m$,"Display")),include.COMSYS.$$$NO(m$)) || mOp.Logical(m$.fnc$("COMGridEdit31Events.OnBeforeDisplayLine",p$args.get()))));
  }

  //<< #def1arg OnDisplayRightClickMenu(%args) $case($get($$$EventExists("RightClick")),$$$NO:"",:$$OnDisplayRightClickMenu^COMGridEdit31Events(%args))
  public static Object $$$OnDisplayRightClickMenu(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$case(m$.Fnc.$get($$$EventExistsVar(m$,"RightClick")),include.COMSYS.$$$NO(m$),"",m$.fnc$("COMGridEdit31Events.OnDisplayRightClickMenu",p$args.get())));
  }

  //<< #def1arg OnBeforeFormat(%args)          if $get($$$EventExists("Format"))'=$$$NO do OnBeforeFormat^COMGridEdit31Events(%args)
  public static Object $$$OnBeforeFormat(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    if (mOp.NotEqual(m$.Fnc.$get($$$EventExistsVar(m$,"Format")),include.COMSYS.$$$NO(m$))) {
      m$.Cmd.Do("COMGridEdit31Events.OnBeforeFormat",p$args.get());
    }
    return null;
  }

  //<< #def1arg OnLineAdded(%args)             if $get($$$EventExists("LineAdded"))'=$$$NO do OnLineAdded^COMGridEdit31Events(%args)
  public static Object $$$OnLineAdded(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    if (mOp.NotEqual(m$.Fnc.$get($$$EventExistsVar(m$,"LineAdded")),include.COMSYS.$$$NO(m$))) {
      m$.Cmd.Do("COMGridEdit31Events.OnLineAdded",p$args.get());
    }
    return null;
  }

  //<< #def1arg OnLineDeleted(%args)           if $get($$$EventExists("LineDelete"))'=$$$NO do OnLineDeleted^COMGridEdit31Events(%args)
  public static Object $$$OnLineDeleted(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    if (mOp.NotEqual(m$.Fnc.$get($$$EventExistsVar(m$,"LineDelete")),include.COMSYS.$$$NO(m$))) {
      m$.Cmd.Do("COMGridEdit31Events.OnLineDeleted",p$args.get());
    }
    return null;
  }

  //<< #def1arg OnBeforeDisplayCombo(%args)    if $get($$$EventExists("Combo"))'=$$$NO do OnBeforeDisplayCombo^COMGridEdit31Events(%args)
  public static Object $$$OnBeforeDisplayCombo(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    if (mOp.NotEqual(m$.Fnc.$get($$$EventExistsVar(m$,"Combo")),include.COMSYS.$$$NO(m$))) {
      m$.Cmd.Do("COMGridEdit31Events.OnBeforeDisplayCombo",p$args.get());
    }
    return null;
  }

  //<< 
  //<< #define CallEvent(%code,%event)         if $get($$$EventExists(%event))'=$$$NO do CallEvent^COMGridEdit31Events(%code,%event)
  public static Object $$$CallEvent(mContext m$, Object ... _p) {
    mVar p$code = m$.varRef("p$code",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$event = m$.varRef("p$event",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    if (mOp.NotEqual(m$.Fnc.$get($$$EventExistsVar(m$,p$event)),include.COMSYS.$$$NO(m$))) {
      m$.Cmd.Do("COMGridEdit31Events.CallEvent",p$code.get(),p$event.get());
    }
    return null;
  }

}
