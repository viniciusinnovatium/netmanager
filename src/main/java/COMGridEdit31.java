//*****************************************************************************
//** TASC - ALPHALINC - MAC COMGridEdit31
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:24
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;
//<< #include COMConst
import include.COMConst;
//<< #include COMGridEdit31
//import include.COMGridEdit31;

public class COMGridEdit31 extends mClass {

  //<< 
  //<< #def1arg WWWDATEN(%args) ^WWWDATEN(0,+$horolog,YUSER,YFORM,"V",%args)
  public static Object $$$WWWDATEN(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",p$args.get()).get());
  }

  public static mVar $$$WWWDATENVar(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V",p$args.get()));
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

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^CGE31("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< COMGridEdit31  ; DEPRECATED - call Start directly - may be needed via JS call
  public void main() {
    _COMGridEdit31();
  }

  public void _COMGridEdit31() {
    //<< do Start(YFORM,YKEY)
    m$.Cmd.Do("Start",m$.var("YFORM").get(),m$.var("YKEY").get());
    //<< quit
    return;
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ;  *1  COMGridEdit31Head  (Followed by tag creating that part of the grid)
  //<< ;  *2  COMGridEdit31
  //<< ;  *3  COMGridEdit31Body
  //<< ;  *4  COMGridEdit31Body2
  //<< ;  *5  WWW120DynTable
  //<< ;-------------------------------------------------------------------------------
  //<< ;    Favourites                                                   [ ][ ][ ]        *** COMView
  //<< ;    (.) In form default                                          [ ][ ][ ]            External Filter
  //<< ; +- Field Selection --------------------------------------------------------+
  //<< ; | Field  [Comparator][Value]                                               |
  //<< ; | Field  [Comparator][Value]                                               |
  //<< ; +--------------------------------------------------------------------------+
  //<< ;    Status :
  //<< ; Search complete.  # record(s) found
  //<< ;-------------------------------------------------------------------------------
  //<< ; Key Name : Key Value         [optional - ^CacheTemp(YUSER,"Grid","ShowKeys") ]   *1 HEAD
  //<< ; Per Page: [   ]   Pages: .....                        [  ][  ][  ][  ][  ][  ]   *1 Pages / Buttons
  //<< ;-------------------------------------------------------------------------------
  //<< ;  Line  |  P1  |  P2  |   Da Name   |   Db Name   |   Dc Name   |   Dd Name   |
  //<< ; Number | Name | Name |             |             |             |             |   *3 Head
  //<< ;--------+------+------+-------------+-------------+-------------+-------------+
  //<< ;        |      |      |             |             |             |             |   *4 CreateData / *3 AddLines
  //<< ;--------+------+------+-------------+-------------+-------------+-------------+
  //<< ;        |      |      |             |             |             |             |
  //<< ;--------+------+------+-------------+-------------+-------------+-------------+
  //<< ;
  //<< ;  Dynamic Table                                                                   *5 CreateDynTableCall
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< 
  //<< Start(YFORM,YKEY)
  public Object Start(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Start
    //<< ;
    //<< ; Called as : $$$GRIDStart(...)
    //<< ;
    //<< ; Params:   YFORM   Grid (child) form
    //<< ;           YKEY    Header (parent) key
    //<< ; ByRef :
    //<< ;   YAUSWAHL
    //<< ;   YFELD
    //<< ;   YKILL
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Jun-2012   shobby  SR18026: Call to set up any LinkedTo controls
    //<< ; 16-Mar-2007   GRF     SR12505: doco; boolean macros
    //<< ; 31-Oct-2006   JW      BR014279: Added params
    //<< ; 21-Sep-2006   JW      SR15062: Removed FINGLBankRecon exception
    //<< ; 07-Aug-2006   JW      SR14730: Added Start tag, moved key check
    //<< ; 07-Feb-2006   JW      SR13305 : FINGLBankRecon exception.
    //<< ; 13-Feb-2006   JW      Check form type
    //<< ; 24-Oct-2005   JW      SR11573: Work out if same record.
    //<< ; 14-Oct-2005   JW      SR13581: Reverted below changes, don't cleanup if tab only.
    //<< ; 10-Oct-2005   shobby  SR13581: When changing tabs don't reload from disk but
    //<< ;                           use the in memory version. (CacheTempTabSwitch)
    //<< ; 22-Aug-2005   JW      SR13274: Check key is valid
    //<< ; 19-Jul-2005   RPW     SR12981: Moved CleanupPreviousInstance to COMGridEdit31Tools
    //<< ; 10-Dec-2004   JW      SR11004: Callbacks to be called on startup.
    //<< ; 10-Dec-2004   Shobby  Clean up (SR11175)
    //<< ;-------------------------------------------------------------------------------
    //<< new blnSameRecord,blnTabOnly,idContainer,strStatus
    mVar blnSameRecord = m$.var("blnSameRecord");
    mVar blnTabOnly = m$.var("blnTabOnly");
    mVar idContainer = m$.var("idContainer");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnSameRecord,blnTabOnly,idContainer,strStatus);
    //<< new YANZ,YCOL,YCOLON,YCOLUMNS,YDATEI,YDDSATZ,YFELD,YI,YMAXKEY,YROW,YSATZ
    mVar YANZ = m$.var("YANZ");
    mVar YCOL = m$.var("YCOL");
    mVar YCOLON = m$.var("YCOLON");
    mVar YCOLUMNS = m$.var("YCOLUMNS");
    mVar YDATEI = m$.var("YDATEI");
    mVar YDDSATZ = m$.var("YDDSATZ");
    mVar YFELD = m$.var("YFELD");
    mVar YI = m$.var("YI");
    mVar YMAXKEY = m$.var("YMAXKEY");
    mVar YROW = m$.var("YROW");
    mVar YSATZ = m$.var("YSATZ");
    m$.newVar(YANZ,YCOL,YCOLON,YCOLUMNS,YDATEI,YDDSATZ,YFELD,YI,YMAXKEY,YROW,YSATZ);
    //<< 
    //<< $$$LogR("Start",YFORM_":"_YKEY_":"_YKILL)
    $$$LogR(m$,"Start",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YFORM.get(),":"),YKEY.get()),":"),m$.var("YKILL").get()));
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  blnTabOnly
    //<< ;  blnSameRecord
    //<< ;
    //<< ;  YSATZ                objWWW120  - Form Header
    //<< ;  YVOR1                objWWW012  - General Parameters
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< set blnTabOnly  = $$$NO
    blnTabOnly.set(include.COMSYS.$$$NO(m$));
    //<< set idContainer = $$$COMGridEditParameterContainer(YAUSWAHL)
    idContainer.set(include.COMConst.$$$COMGridEditParameterContainer(m$,m$.var("YAUSWAHL")));
    //<< 
    //<< if (idContainer'="") && (YFORM'="") && $data(^WWWDATEN(0,+$horolog,YUSER,idContainer,"Grid",YFORM)) {
    if ((mOp.NotEqual(idContainer.get(),"")) && (mOp.NotEqual(YFORM.get(),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),idContainer.get(),"Grid",YFORM.get())))) {
      //<< set blnTabOnly = $$$YES
      blnTabOnly.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< set blnSameRecord = (YKEY=$$GetYKEY^COMGridEdit31G(,YFORM))
    blnSameRecord.set((mOp.Equal(YKEY.get(),m$.fnc$("COMGridEdit31G.GetYKEY",null,YFORM.get()))));
    //<< 
    //<< $$$LogRx("31*1:"_blnTabOnly_"<"_blnSameRecord)
    $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat("31*1:",blnTabOnly.get()),"<"),blnSameRecord.get()));
    //<< 
    //<< if (YKILL'=3) && 'blnTabOnly {
    if ((mOp.NotEqual(m$.var("YKILL").get(),3)) && mOp.Not(blnTabOnly.get())) {
      //<< do CleanUpPreviousInstance^COMGridEdit31Tools(YFORM,blnSameRecord)
      m$.Cmd.Do("COMGridEdit31Tools.CleanUpPreviousInstance",YFORM.get(),blnSameRecord.get());
    }
    //<< }
    //<< 
    //<< kill ^CacheTemp(YUSER,"Grid") ;Clean up any previous settings.
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid").kill();
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if (YFORM="") || '$data(^WWW120(0,YFORM)) {
    if ((mOp.Equal(YFORM.get(),"")) || mOp.Not(m$.Fnc.$data(m$.var("^WWW120",0,YFORM.get())))) {
      //<< set strStatus = $listbuild(35)                      ; "No Form Default"
      strStatus.set(m$.Fnc.$listbuild(35));
    }
    //<< 
    //<< } else {
    else {
      //<< set YSATZ = $get(^WWW120(0,YFORM,1))
      YSATZ.set(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)));
      //<< if YSATZ="" {
      if (mOp.Equal(YSATZ.get(),"")) {
        //<< set strStatus = $listbuild(35)                  ; "No Form Default"
        strStatus.set(m$.Fnc.$listbuild(35));
      }
      //<< 
      //<< } else {
      else {
        //<< set YDATEI = $$$WWW120ClassUsedInForm(YSATZ)
        YDATEI.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,YSATZ));
        //<< if (YDATEI="") || '$data(^WWW001(0,YDATEI)) {
        if ((mOp.Equal(YDATEI.get(),"")) || mOp.Not(m$.Fnc.$data(m$.var("^WWW001",0,YDATEI.get())))) {
          //<< set strStatus = $listbuild(191)             ; "Wrong Class Default"
          strStatus.set(m$.Fnc.$listbuild(191));
        }
        //<< 
        //<< } elseif $$$WWW120FormType(YSATZ)'=12 {
        else if (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,YSATZ),12)) {
          //<< set strStatus = $listbuild("Com00242")      ; "Form is not of type 12 - Grid Edit Only"
          strStatus.set(m$.Fnc.$listbuild("Com00242"));
        }
        //<< 
        //<< } else {
        else {
          //<< set YMAXKEY = $order(^WWW002(0,YDATEI,""),-1)             ; Last Key #
          YMAXKEY.set(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1)));
          //<< 
          //<< if $$GetKey^COMUtilClass(YKEY,YMAXKEY-1) {
          if (mOp.Logical(m$.fnc$("COMUtilClass.GetKey",YKEY.get(),mOp.Subtract(YMAXKEY.get(),1)))) {
            //<< do GetGridDefaults(.YAUSWAHL,YSATZ)
            m$.Cmd.Do("GetGridDefaults",m$.var("YAUSWAHL"),YSATZ.get());
            //<< do GetLinkedTo^COMGridEdit31Links()  ;SR18026
            m$.Cmd.Do("COMGridEdit31Links.GetLinkedTo");
            //<< set $$$WWWDATEN("REFERENCEKEY") = $get(YKEY)
            $$$WWWDATENVar(m$,"REFERENCEKEY").set(m$.Fnc.$get(YKEY));
            //<< 
            //<< if $get(YVOR1)="" set YVOR1 = $get(^WWW012(0,0,1))   ; Company Defaults
            if (mOp.Equal(m$.Fnc.$get(m$.var("YVOR1")),"")) {
              mVar YVOR1 = m$.var("YVOR1");
              YVOR1.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
            }
            //<< 
            //<< write YCR,"<LINK REL=""stylesheet"" TYPE=""text/css"" HREF="""_YGIF_"GridEdit.css"">"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"",m$.var("YGIF").get()),"GridEdit.css\">"));
            //<< 
            //<< do CreateJavaScript^COMGridEdit31J3()
            m$.Cmd.Do("COMGridEdit31J3.CreateJavaScript");
            //<< do CreateJavaScript^COMGridEdit31J2()
            m$.Cmd.Do("COMGridEdit31J2.CreateJavaScript");
            //<< do CreateGrid(YDATEI,YKEY,YMAXKEY,blnTabOnly)
            m$.Cmd.Do("CreateGrid",YDATEI.get(),YKEY.get(),YMAXKEY.get(),blnTabOnly.get());
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< write "<B><center><br>"_$$$Text(strStatus)_"</b>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<B><center><br>",include.COMSYS.$$$Text(m$,strStatus)),"</b>"));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetFirstColumn(YFORM)
  public Object GetFirstColumn(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 17-Mar-2005   Shobby  Created (Rewrite of previous GetFirstColumn)
    //<< ;-------------------------------------------------------------------------------
    //<< quit:$get(YFORM)="" ""
    if (mOp.Equal(m$.Fnc.$get(YFORM),"")) {
      return "";
    }
    //<< quit $piece($get(^CacheTemp(YUSER,"Grid",YFORM,"COLUMNORDER")),",",1)
    return m$.Fnc.$piece(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid",YFORM.get(),"COLUMNORDER")),",",1);
  }

  //<< 
  //<< 
  //<< GetGridDefaults(&pYAUSWAHL,pYSATZ)
  public Object GetGridDefaults(Object ... _p) {
    mVar pYAUSWAHL = m$.newVarRef("pYAUSWAHL",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYSATZ = m$.newVarRef("pYSATZ",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Stores configuration type globals for this grid as set up in the AfterDataFields
    //<< ; method on the calling form.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Dec-2012   shobby  HEVA-694: Removed redundant cell height calculation
    //<< ; 21-May-2012   shobby  SR18017: NewLine
    //<< ; 04-Apr-2012   shobby  SR17995: MaxWidth
    //<< ; 15-Sep-2010   shobby  SR17543: Hidden Columns
    //<< ; 18-May-2010   GRF     SR17253: replace 'i' with 'loop'; distinguish between
    //<< ;                           strPiece and strPieces (now strParamList)
    //<< ; 30-Oct-2008   SCR     SR16026: Use Get Rows Per Page function instead of Macro
    //<< ; 14-May-2008   shobby  SRBR014943: Each user has their own settings for PerPage
    //<< ; 30-Mar-2007   RPW     SRBR014416: Added new default for joining grids & comviews.
    //<< ; 15-Nov-2006   JW      SR14915: Added row height
    //<< ; 31-Aug-2006   JW      SR14907: ShowHeaderKeys
    //<< ; 09-Aug-2006   JW      SR14730: DontStoreAll
    //<< ; 03-Feb-2006   RPW     SR14093: Added support for Allow Delete when the grid is
    //<< ;                           locked and attempts to improve the draw speed of the
    //<< ;                           grid and do not draw the container.
    //<< ; 18-Oct-2005   PO      Newed idName,idContainer,intRows
    //<< ; 29-Mar-2005   shobby  Included a parameter for linked classes.
    //<< ; 11-Mar-2005   JW      Preserve YSEITE
    //<< ; 16-Feb-2005   shobby  Preserved VORG.
    //<< ; 09-Dec-2004   JW      SR11068: Added Field 'Link'. Not used at the moment
    //<< ; 06-Dec-2004   Shobby  Created (SR10468)
    //<< ;-------------------------------------------------------------------------------
    //<< new idName,idContainer,intRows,loop,strParamList,strPiece
    mVar idName = m$.var("idName");
    mVar idContainer = m$.var("idContainer");
    mVar intRows = m$.var("intRows");
    mVar loop = m$.var("loop");
    mVar strParamList = m$.var("strParamList");
    mVar strPiece = m$.var("strPiece");
    m$.newVar(idName,idContainer,intRows,loop,strParamList,strPiece);
    //<< 
    //<< kill ^CacheTemp(YUSER,"Grid")
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid").kill();
    //<< merge ^CacheTemp(YUSER,"Grid","VORG") = VORG
    mVar VORG = m$.var("VORG");
    m$.Cmd.Merge(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","VORG"),VORG);
    //<< 
    //<< if $get(pYAUSWAHL)="" {   ; Defaults if nothing specified
    if (mOp.Equal(m$.Fnc.$get(pYAUSWAHL),"")) {
      //<< set $$$COMGridEditParameterSharedForm(pYAUSWAHL)    = $$$NO
      include.COMConst.$$$COMGridEditParameterSharedFormSet(m$,pYAUSWAHL,include.COMSYS.$$$NO(m$));
      //<< set $$$COMGridEditParameterMaximumHeight(pYAUSWAHL) = 500
      include.COMConst.$$$COMGridEditParameterMaximumHeightSet(m$,pYAUSWAHL,500);
      //<< set $$$COMGridEditParameterGridName(pYAUSWAHL)      = YFORM
      include.COMConst.$$$COMGridEditParameterGridNameSet(m$,pYAUSWAHL,m$.var("YFORM").get());
      //<< set $$$COMGridEditParameterUpdateFields(pYAUSWAHL)  = ""
      include.COMConst.$$$COMGridEditParameterUpdateFieldsSet(m$,pYAUSWAHL,"");
      //<< set $$$COMGridEditParameterClearFields(pYAUSWAHL)   = ""
      include.COMConst.$$$COMGridEditParameterClearFieldsSet(m$,pYAUSWAHL,"");
      //<< set $$$COMGridEditParameterDefaultFields(pYAUSWAHL) = ""
      include.COMConst.$$$COMGridEditParameterDefaultFieldsSet(m$,pYAUSWAHL,"");
      //<< set $$$COMGridEditParameterEnabled(pYAUSWAHL)       = $$$YES
      include.COMConst.$$$COMGridEditParameterEnabledSet(m$,pYAUSWAHL,include.COMSYS.$$$YES(m$));
      //<< set $$$COMGridEditParameterCOMViewGrid(pYAUSWAHL)   = $$$NO
      include.COMConst.$$$COMGridEditParameterCOMViewGridSet(m$,pYAUSWAHL,include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< 
    //<< set ^CacheTemp(YUSER,"Grid","DontUpdateContainer") = +$$$COMGridEditParameterDontUpdateContainer(pYAUSWAHL)
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","DontUpdateContainer").set(mOp.Positive(include.COMConst.$$$COMGridEditParameterDontUpdateContainer(m$,pYAUSWAHL)));
    //<< set ^CacheTemp(YUSER,"Grid","DontStoreAll")        = +$$$COMGridEditParameterDontStoreAll(pYAUSWAHL)
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","DontStoreAll").set(mOp.Positive(include.COMConst.$$$COMGridEditParameterDontStoreAll(m$,pYAUSWAHL)));
    //<< set ^CacheTemp(YUSER,"Grid","SharedForm")          = +$$$COMGridEditParameterSharedForm(pYAUSWAHL)
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","SharedForm").set(mOp.Positive(include.COMConst.$$$COMGridEditParameterSharedForm(m$,pYAUSWAHL)));
    //<< set ^CacheTemp(YUSER,"Grid","MaxHeight")           = +$$$COMGridEditParameterMaximumHeight(pYAUSWAHL)
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","MaxHeight").set(mOp.Positive(include.COMConst.$$$COMGridEditParameterMaximumHeight(m$,pYAUSWAHL)));
    //<< set ^CacheTemp(YUSER,"Grid","MaxWidth")            =  $$$COMGridEditParameterMaxWidth(pYAUSWAHL)    ;SR17995
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","MaxWidth").set(include.COMConst.$$$COMGridEditParameterMaxWidth(m$,pYAUSWAHL));
    //<< set ^CacheTemp(YUSER,"Grid","COMView")             = +$$$COMGridEditParameterCOMViewGrid(pYAUSWAHL)
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","COMView").set(mOp.Positive(include.COMConst.$$$COMGridEditParameterCOMViewGrid(m$,pYAUSWAHL)));
    //<< set ^CacheTemp(YUSER,"Grid","NewLine")             = +$$$COMGridEditParameterNewLine(pYAUSWAHL)      ;SR18017
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","NewLine").set(mOp.Positive(include.COMConst.$$$COMGridEditParameterNewLine(m$,pYAUSWAHL)));
    //<< 
    //<< set ^CacheTemp(YUSER,"Grid","HiddenColumns")       = $$$COMGridEditParameterHiddenColumns(pYAUSWAHL) ;SR17543
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","HiddenColumns").set(include.COMConst.$$$COMGridEditParameterHiddenColumns(m$,pYAUSWAHL));
    //<< 
    //<< set idName      = $$$COMGridEditParameterGridName(pYAUSWAHL)
    idName.set(include.COMConst.$$$COMGridEditParameterGridName(m$,pYAUSWAHL));
    //<< set idContainer = $$$COMGridEditParameterContainer(pYAUSWAHL)
    idContainer.set(include.COMConst.$$$COMGridEditParameterContainer(m$,pYAUSWAHL));
    //<< 
    //<< set ^CacheTemp(YUSER,"Grid","Name")      = idName
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name").set(idName.get());
    //<< set ^CacheTemp(YUSER,"Grid","Container") = idContainer
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container").set(idContainer.get());
    //<< if (idName'="") && (idContainer'="") {
    if ((mOp.NotEqual(idName.get(),"")) && (mOp.NotEqual(idContainer.get(),""))) {
      //<< set ^WWWDATEN(0,+$horolog,YUSER,idContainer,"Grid",idName) = $$$YES // Store form - for saving
      m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),idContainer.get(),"Grid",idName.get()).set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< set intRows=+$$GetRowsPerPage(YBED,YFORM)
    intRows.set(mOp.Positive(m$.fnc$("GetRowsPerPage",m$.var("YBED").get(),m$.var("YFORM").get())));
    //<< if intRows=0 {
    if (mOp.Equal(intRows.get(),0)) {
      //<< set intRows = +$$$WWW120DGridRecordsPerPage($get(^WWW120D(0,idName,0,1)))
      intRows.set(mOp.Positive(include.WWWConst.$$$WWW120DGridRecordsPerPage(m$,m$.Fnc.$get(m$.var("^WWW120D",0,idName.get(),0,1)))));
      //<< if intRows=0 {
      if (mOp.Equal(intRows.get(),0)) {
        //<< set intRows = +$$$WWW120GridRecordsPerPage(pYSATZ)
        intRows.set(mOp.Positive(include.WWWConst.$$$WWW120GridRecordsPerPage(m$,pYSATZ)));
        //<< if intRows=0 set intRows = 20
        if (mOp.Equal(intRows.get(),0)) {
          intRows.set(20);
        }
      }
    }
    //<< }
    //<< }
    //<< do GetRowsPerPage(YBED,YFORM,intRows)
    m$.Cmd.Do("GetRowsPerPage",m$.var("YBED").get(),m$.var("YFORM").get(),intRows.get());
    //<< 
    //<< set strParamList = $$$COMGridEditParameterUpdateFields(pYAUSWAHL)
    strParamList.set(include.COMConst.$$$COMGridEditParameterUpdateFields(m$,pYAUSWAHL));
    //<< for i=1:1:$length(strParamList,";") {
    mVar i = m$.var("i");
    for (i.set(1);(mOp.LessOrEqual(i.get(),m$.Fnc.$length(strParamList.get(),";")));i.set(mOp.Add(i.get(),1))) {
      //<< set strPiece=$piece(strParamList,";",i)
      strPiece.set(m$.Fnc.$piece(strParamList.get(),";",i.get()));
      //<< if strPiece'="" {
      if (mOp.NotEqual(strPiece.get(),"")) {
        //<< if $piece(strPiece,"=",2)["-" {
        if (mOp.Contains(m$.Fnc.$piece(strPiece.get(),"=",2),"-")) {
          //<< set ^CacheTemp(YUSER,"Grid","Calculated",$piece(strPiece,"=",2)) = $piece(strPiece,"=",1)
          m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Calculated",m$.Fnc.$piece(strPiece.get(),"=",2)).set(m$.Fnc.$piece(strPiece.get(),"=",1));
        }
        //<< } else {
        else {
          //<< set ^CacheTemp(YUSER,"Grid","Update",$piece(strPiece,"=",2))     = $piece(strPiece,"=",1)
          m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Update",m$.Fnc.$piece(strPiece.get(),"=",2)).set(m$.Fnc.$piece(strPiece.get(),"=",1));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< set strParamList = $$$COMGridEditParameterClearFields(pYAUSWAHL)
    strParamList.set(include.COMConst.$$$COMGridEditParameterClearFields(m$,pYAUSWAHL));
    //<< for loop=1:1:$length(strParamList,";") {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strParamList.get(),";")));loop.set(mOp.Add(loop.get(),1))) {
      //<< set strPiece = $piece(strParamList,";",loop)
      strPiece.set(m$.Fnc.$piece(strParamList.get(),";",loop.get()));
      //<< if strPiece'="" {
      if (mOp.NotEqual(strPiece.get(),"")) {
        //<< set ^CacheTemp(YUSER,"Grid","Clear",$piece(strPiece,",",1)) = $piece(strPiece,",",2)
        m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Clear",m$.Fnc.$piece(strPiece.get(),",",1)).set(m$.Fnc.$piece(strPiece.get(),",",2));
      }
    }
    //<< }
    //<< }
    //<< set strParamList = $$$COMGridEditParameterDefaultFields(pYAUSWAHL)
    strParamList.set(include.COMConst.$$$COMGridEditParameterDefaultFields(m$,pYAUSWAHL));
    //<< for loop=1:1:$length(strParamList,";") {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strParamList.get(),";")));loop.set(mOp.Add(loop.get(),1))) {
      //<< set strPiece = $piece(strParamList,";",loop)
      strPiece.set(m$.Fnc.$piece(strParamList.get(),";",loop.get()));
      //<< if strPiece'="" {
      if (mOp.NotEqual(strPiece.get(),"")) {
        //<< set ^CacheTemp(YUSER,"Grid","DefaultFromPreviousLine",$piece(strPiece,",",1)) = $$$YES           ; SR12505
        m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","DefaultFromPreviousLine",m$.Fnc.$piece(strPiece.get(),",",1)).set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< set ^CacheTemp(YUSER,"Grid","Enabled")=+$$$COMGridEditParameterEnabled(pYAUSWAHL)
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Enabled").set(mOp.Positive(include.COMConst.$$$COMGridEditParameterEnabled(m$,pYAUSWAHL)));
    //<< 
    //<< set strParamList = $$$COMGridEditParameterCallBack(pYAUSWAHL)
    strParamList.set(include.COMConst.$$$COMGridEditParameterCallBack(m$,pYAUSWAHL));
    //<< for loop=1:1:$length(strParamList,";") {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strParamList.get(),";")));loop.set(mOp.Add(loop.get(),1))) {
      //<< set strPiece = $piece(strParamList,";",loop)
      strPiece.set(m$.Fnc.$piece(strParamList.get(),";",loop.get()));
      //<< if strPiece'="" {
      if (mOp.NotEqual(strPiece.get(),"")) {
        //<< set ^CacheTemp(YUSER,"Grid","CallBack",$piece(strPiece,",",1)) = $piece(strPiece,",",2,999)
        m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","CallBack",m$.Fnc.$piece(strPiece.get(),",",1)).set(m$.Fnc.$piece(strPiece.get(),",",2,999));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set ^CacheTemp(YUSER,"Grid","ExpandLines")=$$$COMGridEditParameterExpandLines(pYAUSWAHL)
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","ExpandLines").set(include.COMConst.$$$COMGridEditParameterExpandLines(m$,pYAUSWAHL));
    //<< if $$$COMGridEditParameterLinks(pYAUSWAHL)'="" {
    if (mOp.NotEqual(include.COMConst.$$$COMGridEditParameterLinks(m$,pYAUSWAHL),"")) {
      //<< set ^WWWDATEN(0,+$horolog,YUSER,$$$COMGridEditParameterGridName(pYAUSWAHL),"V","LINKS") = $$$COMGridEditParameterLinks(pYAUSWAHL)
      m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),include.COMConst.$$$COMGridEditParameterGridName(m$,pYAUSWAHL),"V","LINKS").set(include.COMConst.$$$COMGridEditParameterLinks(m$,pYAUSWAHL));
    }
    //<< }
    //<< 
    //<< set ^CacheTemp(YUSER,"Grid","ShowKeys") = $$$COMGridEditParameterShowHeaderKeys(pYAUSWAHL)
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","ShowKeys").set(include.COMConst.$$$COMGridEditParameterShowHeaderKeys(m$,pYAUSWAHL));
    //<< set ^CacheTemp(YUSER,"Grid","YOPTION")  = $get(YOPTION)
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","YOPTION").set(m$.Fnc.$get(m$.var("YOPTION")));
    //<< set ^CacheTemp(YUSER,"Grid","YOPTION1") = $get(YOPTION1)
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","YOPTION1").set(m$.Fnc.$get(m$.var("YOPTION1")));
    //<< set ^CacheTemp(YUSER,"Grid","YSEITE")   = $get(YSEITE)
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","YSEITE").set(m$.Fnc.$get(m$.var("YSEITE")));
    //<< set ^CacheTemp(YUSER,"Grid","YHEIGHT")  = 16 ; $$GetCellHeight^COMGridEdit31Tools(idName) ;HEVA-694
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","YHEIGHT").set(16);
    //<< 
    //<< kill pYAUSWAHL
    pYAUSWAHL.kill();
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateGrid(YDATEI,YKEY,YMAXKEY,pblnTabOnly)
  public Object CreateGrid(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YMAXKEY = m$.newVarRef("YMAXKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnTabOnly = m$.newVarRef("pblnTabOnly",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Creates the header and body of the grid
    //<< ;
    //<< ; Called By: Start^COMGridEdit31
    //<< ;
    //<< ; Params:   YDATEI      - parent class
    //<< ;           YKEY        - parent key
    //<< ;           YMAXKEY     - number of grid keys
    //<< ;           blnTabOnly  - whether just changing tabs
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 01-Dec-2010   GRF     SR17597: add DEVinfo textarea for debugging.
    //<< ;   Usage Example : (replace [text] with appropriate values)
    //<< ;       var DEVinfo = document.getElementById('DEVinfo');
    //<< ;       DEVinfo.value = '[Source :]\n';
    //<< ;       DEVinfo.value += '[DataName : ]'+document.getElementById('[idString]').[attribute]+'\n';
    //<< ;
    //<< ;
    //<< ; 04-Mar-2012   shobby  CORE-69.1: Remove height setting in Firefox.
    //<< ; 08-Nov-2012   shobby  SR18190: cgeShowGrid can now retry on failure.
    //<< ; 18-Apr-2012   shobby  SR17995: If maxwidth of grid is -1 (autosize) then hide it until
    //<< ;                           the width can be determined (from other displayed controls).
    //<< ; 04-Apr-2012   shobby  SR17995: Set a maximum width of an edit grid.
    //<< ; 14-Feb-2012   shobby  SR17724: Fixed columns in grid
    //<< ; 14-Feb-2012   shobby  SR17724: Sizing of grid with Firefox.
    //<< ; 27-Sep-2011   shobby  SR17853: Reverted doCancelEvent
    //<< ; 28-Mar-2011   shobby  SR17597.1 Make the displaying of DEVinfo user based.
    //<< ; 24-Mar-2011   shobby  SR17687: Removed unnecessary cancelBubble
    //<< ; 15-Sep-2010   shobby  SR17543: Increase width to 99%
    //<< ; 24-Aug-2010   GRF     SR17515: FF:use width=95% rather than hardcoded 1000px
    //<< ; 06-Jul-2010   GRF     SR17414: replace expression with hard-coded height &
    //<< ;                           width for Firefox *AND* expression for MSIE.
    //<< ; 05-Jul-2010   GRF     SR17413: Right Mouse Button menu fix
    //<< ; 25-May-2009   PPP     SR16565: Scanning Prompt for Grid
    //<< ;                            Create a New Line only if not a scan form
    //<< ; 03-Sep-2008   shobby  SRBR014893: Add a new line by default to an empty grid.
    //<< ; 29-Jun-2008   shobby  SRBR014962: More changes to grid heights.
    //<< ; 03-Jun-2008   GRF     SR15739: Revisions to CREATEDATA moved to new routine
    //<< ; 30-Jan-2008   shobby  SRBR014889: Better management of grid heights.
    //<< ; 27-Nov-2007   shobby  SRBR014779: Give the grid a tab sequence.
    //<< ; 06-Jul-2007   shobby  SRBR014553: Use standard routine to get form field data
    //<< ;                           (including customisations)
    //<< ; 04-Jun-2007   RPW     SR15524: Do not draw the grid data if this is a COMView grid.
    //<< ; 15-Jan-2007   RPW     SR15339: Do not focus the grid if the form is manually
    //<< ;                           set to focus via the forms "focus to data field number"
    //<< ;                           field. Also check form customisation
    //<< ; 04-Jan-2007   PO      SR15351: Hook for Dynamic Table
    //<< ; 31-Oct-2006   JW      BR014279: Added params
    //<< ; 21-Apr-2006   SC      SR14427: Add option to give focus to a grid line.
    //<< ; 25-Jan-2005   JW      SR13087: Call AddLine when changing tabs
    //<< ; 07-Dev-2005   PO      Onclick of the activefield will now open improved DOM viewer
    //<< ; 14-Oct-2005   JW      SR13581: pblnTabOnly param - don't recreate data
    //<< ; 28-Jan-2005   RPW     Made the line field bold on the first cell.
    //<< ; 17-Jan-2005   shobby  Made the grid a bit narrower for when there is a
    //<< ;                           vertical scrollbar.
    //<< ; 17-Jan-2004   RPW     Moved all default hidden fields before the
    //<< ;                           div in case they are needed.
    //<< ; 09-Oct-2004   shobby  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intLeft,intTop,intMaxHeight,blnSharedForm,intMaxWidth,strFocus,idRow,intPage
    mVar intLeft = m$.var("intLeft");
    mVar intTop = m$.var("intTop");
    mVar intMaxHeight = m$.var("intMaxHeight");
    mVar blnSharedForm = m$.var("blnSharedForm");
    mVar intMaxWidth = m$.var("intMaxWidth");
    mVar strFocus = m$.var("strFocus");
    mVar idRow = m$.var("idRow");
    mVar intPage = m$.var("intPage");
    m$.newVar(intLeft,intTop,intMaxHeight,blnSharedForm,intMaxWidth,strFocus,idRow,intPage);
    //<< new intFormFocus,blnFocusGrid,intDisplay
    mVar intFormFocus = m$.var("intFormFocus");
    mVar blnFocusGrid = m$.var("blnFocusGrid");
    mVar intDisplay = m$.var("intDisplay");
    m$.newVar(intFormFocus,blnFocusGrid,intDisplay);
    //<< new strWidth ;SR17995
    mVar strWidth = m$.var("strWidth");
    m$.newVar(strWidth);
    //<< 
    //<< set intLeft       = +$get(^CacheTemp(YUSER,"Grid","Left"))
    intLeft.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Left"))));
    //<< set intTop        = +$get(^CacheTemp(YUSER,"Grid","Top"))
    intTop.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Top"))));
    //<< set blnSharedForm = +$get(^CacheTemp(YUSER,"Grid","SharedForm"))
    blnSharedForm.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","SharedForm"))));
    //<< 
    //<< set intMaxWidth   = $get(^CacheTemp(YUSER,"Grid","MaxWidth"))           ;SR17995
    intMaxWidth.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","MaxWidth")));
    //<< if YUSERAGENT="MSIE" {
    if (mOp.Equal(m$.var("YUSERAGENT").get(),"MSIE")) {
      //<< if intMaxWidth'="" {
      if (mOp.NotEqual(intMaxWidth.get(),"")) {
        //<< set strWidth      = "width:expression(Math.min("_intMaxWidth_",document.body.clientWidth-gridDIV.offsetLeft-16)); "   ;SR17995
        strWidth.set(mOp.Concat(mOp.Concat("width:expression(Math.min(",intMaxWidth.get()),",document.body.clientWidth-gridDIV.offsetLeft-16)); "));
      }
      //<< } else {
      else {
        //<< set strWidth      = "width:expression(document.body.clientWidth-gridDIV.offsetLeft-16);"   ;SR17995
        strWidth.set("width:expression(document.body.clientWidth-gridDIV.offsetLeft-16);");
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set strWidth          = "width:-moz-available; max-width:"_intMaxWidth_"; "   ;SR17995
      strWidth.set(mOp.Concat(mOp.Concat("width:-moz-available; max-width:",intMaxWidth.get()),"; "));
    }
    //<< }
    //<< set intMaxHeight = +$get(^CacheTemp(YUSER,"Grid","MaxHeight"))
    intMaxHeight.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","MaxHeight"))));
    //<< if intMaxHeight<1 set intMaxHeight=9999999999999
    if (mOp.Less(intMaxHeight.get(),1)) {
      intMaxHeight.set(9999999999999D);
    }
    //<< set intMaxHeight="getGridHeight("_intMaxHeight_","_+$$$WWW012IgnoreMaximumHeight($get(^WWW012(0,0,1)))_")"
    intMaxHeight.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("getGridHeight(",intMaxHeight.get()),","),mOp.Positive(include.WWWConst.$$$WWW012IgnoreMaximumHeight(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))))),")"));
    //<< 
    //<< write YCR,"<input type=""hidden"" id=""nextactivefield"" value="""">"
    m$.Cmd.Write(m$.var("YCR").get(),"<input type=\"hidden\" id=\"nextactivefield\" value=\"\">");
    //<< write YCR,"<input type=""hidden"" id=""activegrid"" value="""">"
    m$.Cmd.Write(m$.var("YCR").get(),"<input type=\"hidden\" id=\"activegrid\" value=\"\">");
    //<< write YCR,"<input type=""hidden"" id=""sharedform"" value="""_blnSharedForm_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<input type=\"hidden\" id=\"sharedform\" value=\"",blnSharedForm.get()),"\">"));
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< ; *** COMView External Filter generated somewhere here
    //<< ;     or generated later and ends up displayed in the DIV <GRF>
    //<< 
    //<< ; SR17416 : expression() is a deprecated MSIE-only feature
    //<< 
    //<< if (intMaxWidth=-1)||($$AutoResizeRows^WWW120($get(YFORM))) set intTop=intTop-10000 ;SR17995 ;SR18004
    if ((mOp.Equal(intMaxWidth.get(),mOp.Negative(1))) || mOp.Logical((m$.fnc$("WWW120.AutoResizeRows",m$.Fnc.$get(m$.var("YFORM")))))) {
      intTop.set(mOp.Subtract(intTop.get(),10000));
    }
    //<< ;SR18004 if (intMaxWidth=-1) set intTop=intTop-10000 ;SR17995
    //<< if blnSharedForm {
    if (mOp.Logical(blnSharedForm.get())) {
      //<< write YCR,"<DIV TABINDEX=10000 id='gridDIV' class=gDIVsh _MaxWidth='"_intMaxWidth_"' " ;SR17995
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<DIV TABINDEX=10000 id='gridDIV' class=gDIVsh _MaxWidth='",intMaxWidth.get()),"' "));
      //<< ;CORE-69.1 write "style='table-layout:fixed; top:"_intTop_"px; left:"_intLeft_"px; height:300px; width:99%; height:expression("_intMaxHeight_"); "_strWidth_" '" ;SR17543 ;SR17724 ;SR17995
      //<< write "style='table-layout:fixed; top:"_intTop_"px; left:"_intLeft_"px; width:99%; height:expression("_intMaxHeight_"); "_strWidth_" '" ;SR17543 ;SR17724 ;SR17995 ;CORE-69.1
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("style='table-layout:fixed; top:",intTop.get()),"px; left:"),intLeft.get()),"px; width:99%; height:expression("),intMaxHeight.get()),"); "),strWidth.get())," '"));
    }
    //<< 
    //<< } else {
    else {
      //<< write YCR,"<DIV TABINDEX=10000 id='gridDIV' class=gDIVex _MaxWidth='"_intMaxWidth_"' " ;SR17995
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<DIV TABINDEX=10000 id='gridDIV' class=gDIVex _MaxWidth='",intMaxWidth.get()),"' "));
      //<< ;CORE-69.1 write "style='table-layout:fixed; top:"_intTop_"px; left:"_intLeft_"px; height:300px; width:99%; height:expression("_intMaxHeight_"); "_strWidth_" '" ;SR17543 ;SR17724 ;SR17995
      //<< write "style='table-layout:fixed; top:"_intTop_"px; left:"_intLeft_"px; width:99%; height:expression("_intMaxHeight_"); "_strWidth_" '" ;SR17543 ;SR17724 ;SR17995 ;CORE-69.1
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("style='table-layout:fixed; top:",intTop.get()),"px; left:"),intLeft.get()),"px; width:99%; height:expression("),intMaxHeight.get()),"); "),strWidth.get())," '"));
    }
    //<< }
    //<< 
    //<< ; FF: onfocusin  IE: onfocus
    //<< write YCR," "_$$Event^WWWFORMCrossBrowserSupport("onfocusin")_"='var retval=SetFocus(""Grid""); window.event.returnValue = false; window.event.cancelBubble = true;'"  //SR17253 ;SR17853
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" ",m$.fnc$("WWWFORMCrossBrowserSupport.Event","onfocusin")),"='var retval=SetFocus(\"Grid\"); window.event.returnValue = false; window.event.cancelBubble = true;'"));
    //<< write YCR," oncontextmenu='cgeRightClick(event); window.event.returnValue = false; window.event.cancelBubble = true;'"  //SR17253 SR17413 ;SR17853
    m$.Cmd.Write(m$.var("YCR").get()," oncontextmenu='cgeRightClick(event); window.event.returnValue = false; window.event.cancelBubble = true;'");
    //<< 
    //<< write YCR," onclick ='cgeTest2(event)'" ;  //SR17253 //SR17687
    m$.Cmd.Write(m$.var("YCR").get()," onclick ='cgeTest2(event)'");
    //<< write YCR,">"
    m$.Cmd.Write(m$.var("YCR").get(),">");
    //<< write YCR,"<a name='grid'>"
    m$.Cmd.Write(m$.var("YCR").get(),"<a name='grid'>");
    //<< write "</a>"
    m$.Cmd.Write("</a>");
    //<< 
    //<< do HEAD^COMGridEdit31Head(YDATEI,YKEY,YMAXKEY)
    m$.Cmd.Do("COMGridEdit31Head.HEAD",YDATEI.get(),YKEY.get(),YMAXKEY.get());
    //<< if $$GridVersion^COMGridEdit31V2() do BODY^COMGridEdit31V2()  ;SR17724
    if (mOp.Logical(m$.fnc$("COMGridEdit31V2.GridVersion"))) {
      m$.Cmd.Do("COMGridEdit31V2.BODY");
    }
    //<< if '$$GridVersion^COMGridEdit31V2() do BODY                     ;SR17724
    if (mOp.Not(m$.fnc$("COMGridEdit31V2.GridVersion"))) {
      m$.Cmd.Do("BODY");
    }
    //<< 
    //<< write YCR,"</DIV>"
    m$.Cmd.Write(m$.var("YCR").get(),"</DIV>");
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< if $data(^WWW120DynTable(0,$$$GRIDContainer)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW120DynTable",0,include.COMGridEdit31Interface.$$$GRIDContainer(m$))))) {
      //<< write "<div id='DynamicArea'>"
      m$.Cmd.Write("<div id='DynamicArea'>");
      //<< do CreateDynTableCall^WWW120DynTable($$$GRIDContainer,YFORM,YSEITE)
      m$.Cmd.Do("WWW120DynTable.CreateDynTableCall",include.COMGridEdit31Interface.$$$GRIDContainer(m$),m$.var("YFORM").get(),m$.var("YSEITE").get());
      //<< write YCR,"</div>"
      m$.Cmd.Write(m$.var("YCR").get(),"</div>");
    }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< if $$$DEVMODE {
    if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
      //<< write YCR,"<b>AF: <input id=""activefield"" value="""" onclick=""window.open('/global/dv.html');"">"
      m$.Cmd.Write(m$.var("YCR").get(),"<b>AF: <input id=\"activefield\" value=\"\" onclick=\"window.open('/global/dv.html');\">");
      //<< write YCR,"FF: <input id=""focusfield"" value="""_$get(YFOCUSID)_""">"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("FF: <input id=\"focusfield\" value=\"",m$.Fnc.$get(m$.var("YFOCUSID"))),"\">"));
      //<< write YCR,"T:<input id=""test"" value="""_$get(YFOCUSID)_"""></b>"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("T:<input id=\"test\" value=\"",m$.Fnc.$get(m$.var("YFOCUSID"))),"\"></b>"));
      //<< write YCR,"<a class=""link"" onclick=""cgeClearDEVinfo();""><img src="""_YGIF_"c.gif""></a>"    ; SR17597
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<a class=\"link\" onclick=\"cgeClearDEVinfo();\"><img src=\"",m$.var("YGIF").get()),"c.gif\"></a>"));
      //<< if $get(^SysSetup(YBED,"DEVinfo"))=0 {                                                  ;SR17597.1 User based.
      if (mOp.Equal(m$.Fnc.$get(m$.var("^SysSetup",m$.var("YBED").get(),"DEVinfo")),0)) {
        //<< write YCR,"<input type=""hidden"" id=""DEVinfo"" value="""">"                      ; SR17597
        m$.Cmd.Write(m$.var("YCR").get(),"<input type=\"hidden\" id=\"DEVinfo\" value=\"\">");
      }
      //<< } else {
      else {
        //<< write YCR,"<br/><textarea id='DEVinfo' cols=100 rows=20>DEVinfo</textarea><br/>"    ; SR17597
        m$.Cmd.Write(m$.var("YCR").get(),"<br/><textarea id='DEVinfo' cols=100 rows=20>DEVinfo</textarea><br/>");
      }
    }
    //<< }
    //<< } else {
    else {
      //<< write YCR,"<input type=""hidden"" id=""activefield"" value="""">"
      m$.Cmd.Write(m$.var("YCR").get(),"<input type=\"hidden\" id=\"activefield\" value=\"\">");
      //<< write YCR,"<input type=""hidden"" id=""focusfield"" value="""_$get(YFOCUSID)_""">"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<input type=\"hidden\" id=\"focusfield\" value=\"",m$.Fnc.$get(m$.var("YFOCUSID"))),"\">"));
      //<< write YCR,"<input type=""hidden"" id=""test"" value="""_$get(YFOCUSID)_""">"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<input type=\"hidden\" id=\"test\" value=\"",m$.Fnc.$get(m$.var("YFOCUSID"))),"\">"));
      //<< write YCR,"<input type=""hidden"" id=""DEVinfo"" value="""">"                      ; SR17597
      m$.Cmd.Write(m$.var("YCR").get(),"<input type=\"hidden\" id=\"DEVinfo\" value=\"\">");
    }
    //<< }
    //<< write YCR,YCR
    m$.Cmd.Write(m$.var("YCR").get(),m$.var("YCR").get());
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write YCR,"InitGlobals('"_YUSER_"','"_YUCI_"','"_YFORM_"','"_$$GetDateFormat()_"','"_$zconvert(YGIF,"o","JS")_"','"_$get(YBED)_"');"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("InitGlobals('",m$.var("YUSER").get()),"','"),m$.var("YUCI").get()),"','"),m$.var("YFORM").get()),"','"),m$.fnc$("GetDateFormat")),"','"),m$.Fnc.$zconvert(m$.var("YGIF").get(),"o","JS")),"','"),m$.Fnc.$get(m$.var("YBED"))),"');"));
    //<< write YCR,"  var focusfield=document.getElementById('focusfield').value;" ;W3C
    m$.Cmd.Write(m$.var("YCR").get(),"  var focusfield=document.getElementById('focusfield').value;");
    //<< write YCR,"  if (focusfield != '') { "
    m$.Cmd.Write(m$.var("YCR").get(),"  if (focusfield != '') { ");
    //<< write YCR,"     var thefield=document.getElementById(focusfield);"
    m$.Cmd.Write(m$.var("YCR").get(),"     var thefield=document.getElementById(focusfield);");
    //<< write YCR,"     if (thefield!=null) {"
    m$.Cmd.Write(m$.var("YCR").get(),"     if (thefield!=null) {");
    //<< write YCR,"        thefield.parentNode.firstChild.style.fontWeight='bold';"
    m$.Cmd.Write(m$.var("YCR").get(),"        thefield.parentNode.firstChild.style.fontWeight='bold';");
    //<< write YCR,"     } "
    m$.Cmd.Write(m$.var("YCR").get(),"     } ");
    //<< write YCR,"  } "
    m$.Cmd.Write(m$.var("YCR").get(),"  } ");
    //<< 
    //<< 
    //<< 
    //<< do StoreColumnOrder(YFORM)
    m$.Cmd.Do("StoreColumnOrder",m$.var("YFORM").get());
    //<< do Head^COMGridEdit31Body(YKEY,YFORM,YMAXKEY,"gridheadRow")
    m$.Cmd.Do("COMGridEdit31Body.Head",YKEY.get(),m$.var("YFORM").get(),YMAXKEY.get(),"gridheadRow");
    //<< 
    //<< if 'pblnTabOnly {
    if (mOp.Not(pblnTabOnly.get())) {
      //<< if '$get(^CacheTemp(YUSER,"Grid","COMView")) {
      if (mOp.Not(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","COMView")))) {
        //<< do CreateData^COMGridEdit31Body2(YKEY,YFORM)
        m$.Cmd.Do("COMGridEdit31Body2.CreateData",YKEY.get(),m$.var("YFORM").get());
      }
      //<< }
      //<< do AllCallBacks^COMGridEdit31S()
      m$.Cmd.Do("COMGridEdit31S.AllCallBacks");
    }
    //<< 
    //<< } else {
    else {
      //<< if '$get(^CacheTemp(YUSER,"Grid","COMView")) {
      if (mOp.Not(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","COMView")))) {
        //<< do AddLines^COMGridEdit31Body(YKEY,YFORM)
        m$.Cmd.Do("COMGridEdit31Body.AddLines",YKEY.get(),m$.var("YFORM").get());
      }
    }
    //<< }
    //<< }
    //<< do OnAfterDataFields^COMGridEdit31Events()
    m$.Cmd.Do("COMGridEdit31Events.OnAfterDataFields");
    //<< 
    //<< set intPage      = $get($$$GRIDPage,1)
    intPage.set(m$.Fnc.$get(include.COMGridEdit31.$$$GRIDPageVar(m$),1));
    //<< // If we are in form where the focus has been specifically set, do not focus the grid.
    //<< set intFormFocus = $$$WWW120FirstFocusToDataFieldNumb($get(^WWW120(0,$$$GRIDContainer,1)))
    intFormFocus.set(include.WWWConst.$$$WWW120FirstFocusToDataFieldNumb(m$,m$.Fnc.$get(m$.var("^WWW120",0,include.COMGridEdit31Interface.$$$GRIDContainer(m$),1))));
    //<< set blnFocusGrid = $$$YES
    blnFocusGrid.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< if intFormFocus'="" {
    if (mOp.NotEqual(intFormFocus.get(),"")) {
      //<< set intDisplay = $$$WWW122DisplayOnPageNumber($$Get^WWW122(YFORM,intFormFocus))
      intDisplay.set(include.WWWConst.$$$WWW122DisplayOnPageNumber(m$,m$.fnc$("WWW122.Get",m$.var("YFORM").get(),intFormFocus.get())));
      //<< if YSEITE=intDisplay {
      if (mOp.Equal(m$.var("YSEITE").get(),intDisplay.get())) {
        //<< set blnFocusGrid = $$$NO
        blnFocusGrid.set(include.COMSYS.$$$NO(m$));
        //<< set strFocus     = ""
        strFocus.set("");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if blnFocusGrid {
    if (mOp.Logical(blnFocusGrid.get())) {
      //<< set strFocus="T"                         //Default Focus = Top
      strFocus.set("T");
      //<< if $get(^CacheTemp(YUSER,"GridLine"))'="" {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"GridLine")),"")) {
        //<< set idRow = $get($$$WWWDATEN("REFERENCEROW",$get(^CacheTemp(YUSER,"GridLine")),1))
        idRow.set(m$.Fnc.$get(COMGridEdit31.$$$WWWDATENVar(m$,"REFERENCEROW",m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"GridLine")),1)));
        //<< if idRow'="" {
        if (mOp.NotEqual(idRow.get(),"")) {
          //<< set intPage  = $$GetPage^COMGridEdit31R(idRow)
          intPage.set(m$.fnc$("COMGridEdit31R.GetPage",idRow.get()));
          //<< set strFocus = $$$GRIDGetFirstCell(idRow)
          strFocus.set(include.COMGridEdit31.$$$GRIDGetFirstCell(m$,idRow));
          //<< kill ^CacheTemp(YUSER,"GridLine")
          m$.var("^CacheTemp",m$.var("YUSER").get(),"GridLine").kill();
        }
      }
      //<< }
      //<< } else {
      else {
        //<< if '$$IsScanReq^WWW120Scan(YFORM) {  //SR16565
        if (mOp.Not(m$.fnc$("WWW120Scan.IsScanReq",m$.var("YFORM").get()))) {
          //<< do AddDefaultLine()
          m$.Cmd.Do("AddDefaultLine");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< if intPage > $$$GRIDNumPages set intPage = $$$GRIDNumPages
    if (mOp.Greater(intPage.get(),include.COMGridEdit31.$$$GRIDNumPages(m$))) {
      intPage.set(include.COMGridEdit31.$$$GRIDNumPages(m$));
    }
    //<< 
    //<< write YCR,$$$GRIDGoToPage(intPage,$$$GRIDNumPages,strFocus,$$$NO)
    m$.Cmd.Write(m$.var("YCR").get(),include.COMGridEdit31.$$$GRIDGoToPage(m$,intPage,include.COMGridEdit31.$$$GRIDNumPages(m$),strFocus,include.COMSYS.$$$NO(m$)));
    //<< 
    //<< if (intMaxWidth=-1)||($$AutoResizeRows^WWW120($get(YFORM))) {
    if ((mOp.Equal(intMaxWidth.get(),mOp.Negative(1))) || mOp.Logical((m$.fnc$("WWW120.AutoResizeRows",m$.Fnc.$get(m$.var("YFORM")))))) {
      //<< write YCR,"window.setTimeout(function() { cgeShowGrid(1); },1);" ;SR17995  ;SR18190
      m$.Cmd.Write(m$.var("YCR").get(),"window.setTimeout(function() { cgeShowGrid(1); },1);");
    }
    //<< }
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AddDefaultLine()
  public Object AddDefaultLine(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Open grid automatically for editing
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Apr-2013   shobby  CORE-78:    CanAddLine
    //<< ; 24-Sep-2012   shobby  SR18021:    Line of code commented to assist in patching
    //<< ;                                   SR18017.
    //<< ; 21-May-2012   shobby  SR18017:    Create a new line if configured.
    //<< ; 03-Sep-2008   shobby  SRBR014893: Created (based on Karine's changes)
    //<< ;-------------------------------------------------------------------------------
    //<< new blnIsEnabled,intRowCount
    mVar blnIsEnabled = m$.var("blnIsEnabled");
    mVar intRowCount = m$.var("intRowCount");
    m$.newVar(blnIsEnabled,intRowCount);
    //<< 
    //<< set YVOR=$get(^WWW120(0,YFORM,1)) ;SR18017
    mVar YVOR = m$.var("YVOR");
    YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
    //<< 
    //<< set blnIsEnabled = $get(^CacheTemp(YUSER,"Grid","Enabled"))                     //Karine@20/12/07 - Grid em edição
    blnIsEnabled.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Enabled")));
    //<< set intRowCount  = $get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"V","ROWCOUNT"))      //Karine@20/12/07 - Existe registro ?
    intRowCount.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","ROWCOUNT")));
    //<< 
    //<< //Karine@20/12/07 - Abrir grid para edição automaticamente vvv
    //<< if (blnIsEnabled=$$$YES)  {  //Karine@30/01/08  // Grid em edição && não existe nenhum registro ;SR18021 ;SR18017
    if ((mOp.Equal(blnIsEnabled.get(),include.COMSYS.$$$YES(m$)))) {
      //<< if (";"_$$$WWW120DoNOTDisplayStandardButto($get(^WWW120(0,YFORM,1)))_";")'[";1;" { ;SR18017
      if (mOp.NotContains((mOp.Concat(mOp.Concat(";",include.WWWConst.$$$WWW120DoNOTDisplayStandardButto(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)))),";")),";1;")) {
        //<< ; Don't do it if not allowed to add a new line
        //<< if (intRowCount=0) {                                                    ;SR18017
        if ((mOp.Equal(intRowCount.get(),0))) {
          //<< do AddLine^COMGridEdit31Add(,,YFORM,,,,,$$$YES)
          m$.Cmd.Do("COMGridEdit31Add.AddLine",null,null,m$.var("YFORM").get(),null,null,null,null,include.COMSYS.$$$YES(m$));
        }
      }
      //<< }
      //<< }
      //<< if ^CacheTemp(YUSER,"Grid","NewLine")  {                                    ;SR18017
      if (mOp.Logical(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","NewLine").get())) {
        //<< if $$CanAddLine(YFORM,YVOR) do AddLine^COMGridEdit31Add(,,YFORM,,,,,$$$YES)     ;SR18017 ;CORE-78
        if (mOp.Logical(m$.fnc$("CanAddLine",m$.var("YFORM").get(),YVOR.get()))) {
          m$.Cmd.Do("COMGridEdit31Add.AddLine",null,null,m$.var("YFORM").get(),null,null,null,null,include.COMSYS.$$$YES(m$));
        }
        //<< write YCR," window.setTimeout('moveFocusBottom();',1);"                 ;SR18017
        m$.Cmd.Write(m$.var("YCR").get()," window.setTimeout('moveFocusBottom();',1);");
      }
    }
    //<< }                                                                           ;SR18017
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< CanAddLine(YFORM,YVOR)
  public Object CanAddLine(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YVOR = m$.newVarRef("YVOR",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines if the last line on the grid has been saved.  If so we can add a
    //<< ; new line, if not then use the existing unfinished line
    //<< ;
    //<< ; Optional set lines if the pintRows is set
    //<< ;
    //<< ; Returns:Number of Rows
    //<< ;
    //<< ; History:
    //<< ; 18-Apr-2013   shobby      CORE-78: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnAdd,intLast,idClass,YKEY,strGlobal,blnData
    mVar blnAdd = m$.var("blnAdd");
    mVar intLast = m$.var("intLast");
    mVar idClass = m$.var("idClass");
    mVar YKEY = m$.var("YKEY");
    mVar strGlobal = m$.var("strGlobal");
    mVar blnData = m$.var("blnData");
    m$.newVar(blnAdd,intLast,idClass,YKEY,strGlobal,blnData);
    //<< 
    //<< set blnAdd=$$$YES
    blnAdd.set(include.COMSYS.$$$YES(m$));
    //<< set intLast = $order(^WWWDATEN(0,+$horolog,YUSER,YFORM,"V","REFERENCEKEY",""),-1)
    intLast.set(m$.Fnc.$order(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V","REFERENCEKEY",""),mOp.Negative(1)));
    //<< set YKEY = $get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"V","REFERENCEKEY"))
    YKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V","REFERENCEKEY")));
    //<< set idClass = $$$WWW120ClassUsedInForm(YVOR)
    idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,YVOR));
    //<< if (intLast'="") && (idClass'="") {
    if ((mOp.NotEqual(intLast.get(),"")) && (mOp.NotEqual(idClass.get(),""))) {
      //<< set strGlobal="^"_idClass_"("_$$$WWWYM(idClass)_","""_YKEY_""","_intLast_",1)"
      strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",idClass.get()),"("),include.COMSYSWWW.$$$WWWYM(m$,idClass)),",\""),YKEY.get()),"\","),intLast.get()),",1)"));
      //<< set blnData=$get(@strGlobal)
      blnData.set(m$.Fnc.$get(m$.indirectVar(strGlobal.get())));
      //<< if blnData="" set blnAdd=$$$NO
      if (mOp.Equal(blnData.get(),"")) {
        blnAdd.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< quit blnAdd
    return blnAdd.get();
  }

  //<< 
  //<< GetRowsPerPage(pidUser,pidForm,pintRows=0)
  public Object GetRowsPerPage(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintRows = m$.newVarRef("pintRows",(((_p!=null)&&(_p.length>=3))?_p[2]:null),0);
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets the number of rows per page for the User / Form
    //<< ;   from the ^COMGridEditPerPage(YBED,YFORM,"Grid","PerPage") Global
    //<< ;   If not defined return 20
    //<< ;
    //<< ; Optional set lines if the pintRows is set
    //<< ;
    //<< ; Returns:Number of Rows
    //<< ;
    //<< ; History:
    //<< ; 30-Oct-2008   SCR     SR16026 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intRows
    mVar intRows = m$.var("intRows");
    m$.newVar(intRows);
    //<< 
    //<< ; Null or Invalid User or Form should not happen
    //<< ;   if it does, force to space and don't error.
    //<< if $get(pidUser)="" set pidUser = " "
    if (mOp.Equal(m$.Fnc.$get(pidUser),"")) {
      pidUser.set(" ");
    }
    //<< if $get(pidForm)="" set pidForm = " "
    if (mOp.Equal(m$.Fnc.$get(pidForm),"")) {
      pidForm.set(" ");
    }
    //<< 
    //<< if $get(pintRows) {
    if (mOp.Logical(m$.Fnc.$get(pintRows))) {
      //<< set ^COMGridEditPerPage(pidUser,pidForm,"Grid","PerPage") = pintRows
      m$.var("^COMGridEditPerPage",pidUser.get(),pidForm.get(),"Grid","PerPage").set(pintRows.get());
    }
    //<< }
    //<< set intRows = $get(^COMGridEditPerPage(pidUser,pidForm,"Grid","PerPage"))
    intRows.set(m$.Fnc.$get(m$.var("^COMGridEditPerPage",pidUser.get(),pidForm.get(),"Grid","PerPage")));
    //<< if intRows<1 set intRows = 20
    if (mOp.Less(intRows.get(),1)) {
      intRows.set(20);
    }
    //<< 
    //<< quit intRows
    return intRows.get();
  }

  //<< 
  //<< 
  //<< GetDateFormat()
  public Object GetDateFormat(Object ... _p) {
    //<< ; FIXME : GetDateFormat^COMUtilLocale also ensures TT/MM/JJJJ or DD/MM/AAAA => DD/MM/YYYY - replace this with common call?
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets the date format used for dates in the grid. This is used for sorting purposes.
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 20-Jul-2011   shobby  SR17807:    GetFormat has moved.
    //<< ; 22-Apr-2010   GRF     -: Clear old commented code
    //<< ; 20-Aug-2007   GM      SR13729: Change "FELDFORMAT" parameter to $$GetFormat^INPARA()
    //<< ; 15-Jul-2005   shobby  SR12754:Replaced LANGUAGE global (not always reliable)
    //<< ; 14-Feb-2005   Paul K  Tested for LANGAUGE being defined.
    //<< ; 11-Feb-2005   Paul K  Created (SR#11717)
    //<< ;-------------------------------------------------------------------------------
    //<< ;SR17807 quit $$GetFormat^INPARA(1,"DD/MM/YYYY")  ;SR13729
    //<< quit $$GetFormat^WWW100(1,"DD/MM/YYYY")  ;SR13729
    return m$.fnc$("WWW100.GetFormat",1,"DD/MM/YYYY");
  }

  //<< 
  //<< GetMaxHeight() ;CORE-69.1
  public Object GetMaxHeight(Object ... _p) {
    //<< new strMaxHeight
    mVar strMaxHeight = m$.var("strMaxHeight");
    m$.newVar(strMaxHeight);
    //<< 
    //<< set strMaxHeight=""
    strMaxHeight.set("");
    //<< 
    //<< if '$$$WWW012IgnoreMaximumHeight($get(^WWW012(0,0,1))) {
    if (mOp.Not(include.WWWConst.$$$WWW012IgnoreMaximumHeight(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))))) {
      //<< set strMaxHeight = +$get(^CacheTemp(YUSER,"Grid","MaxHeight"))
      strMaxHeight.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","MaxHeight"))));
      //<< if strMaxHeight<1 set strMaxHeight=9999999999999
      if (mOp.Less(strMaxHeight.get(),1)) {
        strMaxHeight.set(9999999999999D);
      }
      //<< set strMaxHeight="max-height:"_strMaxHeight_"px;"
      strMaxHeight.set(mOp.Concat(mOp.Concat("max-height:",strMaxHeight.get()),"px;"));
    }
    //<< }
    //<< quit strMaxHeight
    return strMaxHeight.get();
  }

  //<< 
  //<< 
  //<< BODY
  public void BODY() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; TABLE BODY
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Mar-2013   shobby  CORE-69.1: Height setting in Firefox.
    //<< ; 19-Apr-2011   shobby  SR17724: Removed old commented code.
    //<< ; 13-Jul-2010   GRF     SR17414: consolidate TABLEbd style in CSS file.
    //<< ; 08-Jul-2010   GRF     SR17408: use 100% for default width
    //<< ; 06-Jul-2010   GRF     SR17414: replace expression with hard-coded height &
    //<< ;                           width for Firefox *AND* expression for MSIE.
    //<< ; 17-Feb-2009   shobby  SRAdHoc: Rewrote as HTML.  Commented out New's.  Can't
    //<< ;                           see why these are necessary.
    //<< ; 05-Sep-2008   HQN     Script is keyword, must enclose in quotes for font-family
    //<< ; 28-Feb-2008   shobby  SRBR014904: Allow grid lines to auto resize.
    //<< ; 26-Oct-2005   JW      SR13744: Remove $etrap - causing problems...
    //<< ; 04-May-2005   shobby  Consolidate code from BODY, BodyStart and BodyEnd
    //<< ;  2-Mar-2005   JW      OnAfterDataFields is done later in BODYADDROWS.
    //<< ; 19-Jan-2005   Shobby  Rewrite to remove the . notation.
    //<< ;-------------------------------------------------------------------------------
    //<< ; CORE-69.1     style='height:200px; width:100%; height:expression(gridDIV.clientHeight-gridbodyDIV.offsetTop); width:expression(gridDIV.offsetWidth-4); table-layout:fixed;'
    //<< 
    //<< &html<
    //<< <DIV id='gridbodyDIV'
    //<< class='gDIVbd'
    //<< style='#($$GetMaxHeight())# width:100%; height:expression(gridDIV.clientHeight-gridbodyDIV.offsetTop); width:expression(gridDIV.offsetWidth-4); table-layout:fixed;'
    //<< onscroll='cgeOnScroll();'>
    //<< <TABLE cellspacing=0
    //<< cellpadding=0
    //<< AutoResizeRows=#($$AutoResizeRows^WWW120($get(YFORM)))#
    //<< id='gridbody'
    //<< class='TABLEbd'>
    //<< <TBODY id='TBODY'>
    //<< </TBODY>
    //<< </TABLE>
    //<< </DIV>
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml("<DIV id='gridbodyDIV'","\n");
    m$.Cmd.WriteHtml("    class='gDIVbd'","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("    style='",(m$.fnc$("GetMaxHeight"))),") width:100%; height:expression(gridDIV.clientHeight-gridbodyDIV.offsetTop); width:expression(gridDIV.offsetWidth-4); table-layout:fixed;'"),"\n");
    m$.Cmd.WriteHtml("    onscroll='cgeOnScroll();'>","\n");
    m$.Cmd.WriteHtml("  <TABLE cellspacing=0","\n");
    m$.Cmd.WriteHtml("      cellpadding=0","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("      AutoResizeRows=",(m$.fnc$("WWW120.AutoResizeRows",m$.Fnc.$get(m$.var("YFORM"))))),")"),"\n");
    m$.Cmd.WriteHtml("      id='gridbody'","\n");
    m$.Cmd.WriteHtml("      class='TABLEbd'>","\n");
    m$.Cmd.WriteHtml("    <TBODY id='TBODY'>","\n");
    m$.Cmd.WriteHtml("    </TBODY>","\n");
    m$.Cmd.WriteHtml("  </TABLE>","\n");
    m$.Cmd.WriteHtml("</DIV>","\n");
    m$.Cmd.WriteHtml("    ");
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< AddRows()
  public Object AddRows(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; 12-Apr-2010   GRF     - : Replace single character variables
    //<< ;-------------------------------------------------------------------------------
    //<< new idx,intSub,loop,strPiece,strBigString
    mVar idx = m$.var("idx");
    mVar intSub = m$.var("intSub");
    mVar loop = m$.var("loop");
    mVar strPiece = m$.var("strPiece");
    mVar strBigString = m$.var("strBigString");
    m$.newVar(idx,intSub,loop,strPiece,strBigString);
    //<< 
    //<< set intSub = 1
    intSub.set(1);
    //<< set strBigString(intSub) = ""
    strBigString.var(intSub.get()).set("");
    //<< set idx = ""
    idx.set("");
    //<< for {
    for (;true;) {
      //<< set idx = $order(^CacheTemp(YUSER,"Grid","Rows",idx))
      idx.set(m$.Fnc.$order(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Rows",idx.get())));
      //<< quit:idx=""
      if (mOp.Equal(idx.get(),"")) {
        break;
      }
      //<< 
      //<< set strPiece = $get(^CacheTemp(YUSER,"Grid","Rows",idx))
      strPiece.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Rows",idx.get())));
      //<< set strBigString(intSub) = strBigString(intSub)_strPiece_Y_"!@#$"_Y
      strBigString.var(intSub.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strBigString.var(intSub.get()).get(),strPiece.get()),m$.var("Y").get()),"!@#$"),m$.var("Y").get()));
      //<< if $length(strBigString(intSub))>25000 {
      if (mOp.Greater(m$.Fnc.$length(strBigString.var(intSub.get()).get()),25000)) {
        //<< set intSub = intSub+1
        intSub.set(mOp.Add(intSub.get(),1));
        //<< set strBigString(intSub) = ""
        strBigString.var(intSub.get()).set("");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if strBigString(intSub)'="" {
    if (mOp.NotEqual(strBigString.var(intSub.get()).get(),"")) {
      //<< set strBigString(intSub)=$extract(strBigString(intSub),1,$length(strBigString(intSub))-6)
      strBigString.var(intSub.get()).set(m$.Fnc.$extract(strBigString.var(intSub.get()).get(),1,mOp.Subtract(m$.Fnc.$length(strBigString.var(intSub.get()).get()),6)));
      //<< write !,"cgeAddManyRows(TBODY,"""
      m$.Cmd.Write("\n","cgeAddManyRows(TBODY,\"");
      //<< for loop=1:1:intSub {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),intSub.get()));loop.set(mOp.Add(loop.get(),1))) {
        //<< write strBigString(loop)
        m$.Cmd.Write(strBigString.var(loop.get()).get());
      }
      //<< }
      //<< write """);"
      m$.Cmd.Write("\");");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< StoreColumnOrder(YFORM)
  public Object StoreColumnOrder(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the current column order
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-May-2010   GRF     -: Clear old commented code
    //<< ; 10-Jul-2007   RPW     SRBR014553: The class field and form fields are always
    //<< ;                           1 for 1.  WWWFELDNAME uses the class field.
    //<< ; 06-Jul-2006   shobby  SRBR014553: Use standard method to get form field information.
    //<< ; 23-Jun-2006   FrankF  SRBR014063: Don't show not customized free fields on the grid.
    //<< ; 28-Sep-2005   JW      SR11573: Remove pblnKill - now not needed. Changed name.
    //<< ; 08-Sep-2005   JW      SR13099: Check WWW122D properly. Use better variable
    //<< ;                           names. Return order.
    //<< ; 17-Mar-2005   shobby  Additional Charges.  Put the column order into a comma
    //<< ;                           separated string indexed by YFORM to support
    //<< ;                           multiple classes in a single grid.
    //<< ;  9-Mar-2005   JW      SR11848: Removed ShowCell - moved elsewhere
    //<< ;-------------------------------------------------------------------------------
    //<< quit:$get(YFORM)="" ""
    if (mOp.Equal(m$.Fnc.$get(YFORM),"")) {
      return "";
    }
    //<< 
    //<< new arrOrder,idCol,idField,idPage,idRow,idxYFORM,intCount,objField,objWWW122,strOrder
    mVar arrOrder = m$.var("arrOrder");
    mVar idCol = m$.var("idCol");
    mVar idField = m$.var("idField");
    mVar idPage = m$.var("idPage");
    mVar idRow = m$.var("idRow");
    mVar idxYFORM = m$.var("idxYFORM");
    mVar intCount = m$.var("intCount");
    mVar objField = m$.var("objField");
    mVar objWWW122 = m$.var("objWWW122");
    mVar strOrder = m$.var("strOrder");
    m$.newVar(arrOrder,idCol,idField,idPage,idRow,idxYFORM,intCount,objField,objWWW122,strOrder);
    //<< 
    //<< ; FIXME : Perhaps hide some columns if fields aren't needed? <GRF> - e.g. Lot No where no items use it?
    //<< set idxYFORM = $$$Index(YFORM)
    idxYFORM.set(include.MEDConst.$$$Index(m$,YFORM));
    //<< set idPage   = ""
    idPage.set("");
    //<< for {
    for (;true;) {
      //<< set idPage = $order(^WWW122s(0,3,idxYFORM,idPage))
      idPage.set(m$.Fnc.$order(m$.var("^WWW122s",0,3,idxYFORM.get(),idPage.get())));
      //<< quit:idPage=""
      if (mOp.Equal(idPage.get(),"")) {
        break;
      }
      //<< 
      //<< set idRow = ""
      idRow.set("");
      //<< for {
      for (;true;) {
        //<< set idRow = $order(^WWW122s(0,3,idxYFORM,idPage,idRow))
        idRow.set(m$.Fnc.$order(m$.var("^WWW122s",0,3,idxYFORM.get(),idPage.get(),idRow.get())));
        //<< quit:idRow=""
        if (mOp.Equal(idRow.get(),"")) {
          break;
        }
        //<< 
        //<< set idCol = ""
        idCol.set("");
        //<< for {
        for (;true;) {
          //<< set idCol = $order(^WWW122s(0,3,idxYFORM,idPage,idRow,idCol))
          idCol.set(m$.Fnc.$order(m$.var("^WWW122s",0,3,idxYFORM.get(),idPage.get(),idRow.get(),idCol.get())));
          //<< quit:idCol=""
          if (mOp.Equal(idCol.get(),"")) {
            break;
          }
          //<< 
          //<< set idField = ""
          idField.set("");
          //<< for {
          for (;true;) {
            //<< set idField = $order(^WWW122s(0,3,idxYFORM,idPage,idRow,idCol,YFORM,idField))
            idField.set(m$.Fnc.$order(m$.var("^WWW122s",0,3,idxYFORM.get(),idPage.get(),idRow.get(),idCol.get(),YFORM.get(),idField.get())));
            //<< quit:idField=""
            if (mOp.Equal(idField.get(),"")) {
              break;
            }
            //<< 
            //<< set objWWW122 = $$Get^WWW122(YFORM,idField) ; Don't show columns for free fields unless have a customization
            objWWW122.set(m$.fnc$("WWW122.Get",YFORM.get(),idField.get()));
            //<< 
            //<< if $$^WWWFELDNAME(YFORM,"D",$$$WWW122SequenceNumber(objWWW122))'="_FREE" {
            if (mOp.NotEqual(m$.fnc$("WWWFELDNAME.main",YFORM.get(),"D",include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122)),"_FREE")) {
              //<< set arrOrder($case($$$WWW122DisplayOnPageNumber(objWWW122),"":idPage,:$$$WWW122DisplayOnPageNumber(objWWW122)),
              //<< $case($$$WWW122ColumnPosition(objWWW122),"":idCol,:$$$WWW122ColumnPosition(objWWW122)),
              //<< $case($$$WWW122RowPosition(objWWW122),"":idRow,:$$$WWW122RowPosition(objWWW122)),
              //<< idField) = ""
              arrOrder.var(m$.Fnc.$case(include.WWWConst.$$$WWW122DisplayOnPageNumber(m$,objWWW122),"",idPage.get(),include.WWWConst.$$$WWW122DisplayOnPageNumber(m$,objWWW122)),m$.Fnc.$case(include.WWWConst.$$$WWW122ColumnPosition(m$,objWWW122),"",idCol.get(),include.WWWConst.$$$WWW122ColumnPosition(m$,objWWW122)),m$.Fnc.$case(include.WWWConst.$$$WWW122RowPosition(m$,objWWW122),"",idRow.get(),include.WWWConst.$$$WWW122RowPosition(m$,objWWW122)),idField.get()).set("");
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< set strOrder = ""
    strOrder.set("");
    //<< for {
    for (;true;) {
      //<< set idPage = $order(arrOrder(idPage))
      idPage.set(m$.Fnc.$order(arrOrder.var(idPage.get())));
      //<< quit:idPage=""
      if (mOp.Equal(idPage.get(),"")) {
        break;
      }
      //<< 
      //<< for {
      for (;true;) {
        //<< set idCol = $order(arrOrder(idPage,idCol))
        idCol.set(m$.Fnc.$order(arrOrder.var(idPage.get(),idCol.get())));
        //<< quit:idCol=""
        if (mOp.Equal(idCol.get(),"")) {
          break;
        }
        //<< 
        //<< for {
        for (;true;) {
          //<< set idRow = $order(arrOrder(idPage,idCol,idRow))
          idRow.set(m$.Fnc.$order(arrOrder.var(idPage.get(),idCol.get(),idRow.get())));
          //<< quit:idRow=""
          if (mOp.Equal(idRow.get(),"")) {
            break;
          }
          //<< 
          //<< for {
          for (;true;) {
            //<< set idField = $order(arrOrder(idPage,idCol,idRow,idField))
            idField.set(m$.Fnc.$order(arrOrder.var(idPage.get(),idCol.get(),idRow.get(),idField.get())));
            //<< quit:idField=""
            if (mOp.Equal(idField.get(),"")) {
              break;
            }
            //<< 
            //<< set strOrder = strOrder_","_idField
            strOrder.set(mOp.Concat(mOp.Concat(strOrder.get(),","),idField.get()));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< set $extract(strOrder) = ""
    mVar $extract = m$.var("$extract");
    $extract.var(strOrder.get()).set("");
    //<< set ^CacheTemp(YUSER,"Grid",YFORM,"COLUMNORDER") = strOrder
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid",YFORM.get(),"COLUMNORDER").set(strOrder.get());
    //<< 
    //<< quit strOrder
    return strOrder.get();
  }

//<< 
//<< 
}
