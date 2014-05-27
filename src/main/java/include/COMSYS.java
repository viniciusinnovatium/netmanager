//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMSYS
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 14:50:15
//*****************************************************************************

package include;

import mLibrary.*;

//<< #include COMSYSDate
import include.COMSYSDate;
//<< #include COMSYSNum
import include.COMSYSNum;
//<< #include COMSYSString
import include.COMSYSString;
//<< #include COMSYSWWW
import include.COMSYSWWW;
import include.WWWConst;
//<< #include COMSYSOutput
import include.COMSYSOutput;
//<< #include COMSYSEnum
import include.COMSYSEnum;
//<< #include COMGridEdit31Interface
import include.COMGridEdit31Interface;
//<< #include COMTab
import include.COMTab;
//<< #include COMEditor
import include.COMEditor;
//<< #include COMSYSJS
import include.COMSYSJS;
//<< #include %occInclude
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;

//<< #;-------------------------------------------------------------------------------
//<< #; History: (purged old entries 07-Aug-2006 GRF)
//<< #; 03-Dec-2013  SCR     SESDF-655: CacheIndex macro
//<< #; 19-Mar-2011  shobby  SR17682: %occInclude
//<< #; 20-Jul-2009  PPP     SR16773: ScanDelimiter is a function now
//<< #; 08-Jan-2009  GRF     SR15632: prepare AddQuotes definition
//<< #; 25-Sep-2008  GRF     Added following 3 changes from OLDDEV
//<< #; 05-Jun-2008  GRF     BR014941: Parentheses around %obj
//<< #; 08-May-2008  shobby  BR014941: Improved speed of $$$Index
//<< #; 11-Feb-2008  shobby  BR014697: Removed ROLLBACK test from ISERR
//<< #; 05-Jul-2007  shobby  BR014409: include COMSYSJS
//<< #; 28-Feb-2007  GRF     Moved string and date macro definitions to those files.
//<< #; 09-Jan-2007  Steve S SR15342: Reverse Order Macros
//<< #; 03-Jan-2007  GRF     SR15338: ISOK/ISERR revised; removed obsolete barcode tags;
//<< #;                          Define MakeStatus and DecomposeStatus
//<< #; 02-Jan-2007  GRF     SR15337: WWWSPEI codes
//<< #; 25-Oct-2006  Steve S SR14915: FormatParagraph
//<< #; 18-Oct-2006  JW      SR15134: Edited Kill macro
//<< #; 13-Oct-2006  RPW     SR14914: Let's macro the Replace command. (JW - Let's not)
//<< #; 28-Sep-2006  Steve S SR14956: RangeCheck Macro
//<< #; 21-Aug-2006  PO      SR14549: New date range macro
//<< #; 09-Aug-2006  PO      SR14877: Include new date macros
//<< #; 19-Jun-2006  Steve S SR14613: JSText/HTMLText
//<< #; 21-Apr-2006  PO/RPW  SR14427: Moved JS from FINSYS
//<< #; 09-Mar-2006  JW      SR14265: Added KEY1, KEY2
//<< #; 27-Jan-2006  PO      SR14130: Included UnEscapeHyperEventData & removed check for
//<< #;                          whether sub-routine call is required in EscapeHyperEventData
//<< #; 23-Jan-2006  PO      SR14109: Macros OrdersInvoiceEndsWithDot & OrderLinesInvoiceEndsWithDot
//<< #; 06-Jan-2006  SC      SR13798: reinstated decode wrapper for @Net button error messages
//<< #;-------------------------------------------------------------------------------
//<< 
//<< #; NOTE : COMSYSWWW includes WWWConst
//<< 
public class COMSYS extends mInclude {

  //<< 
  //<< #;-------------------------------------------------------------------------------
  //<< #; SR13395 - whether we can use syntax highlighting.
  //<< #define CANCODECHECK    (($System.Version.GetOS()["Windows") || ($System.Version.GetNumber()>=5.2))
  public static Object $$$CANCODECHECK(mContext m$) {
    return (((mOp.Contains(m$.getSystem().getVersion().GetOS(),"Windows")) || (mOp.GreaterOrEqual(m$.getSystem().getVersion().GetNumber(),5.2))));
  }

  //<< 
  //<< #;define DEVMODE        $get(^Development)
  //<< #define DEVMODE     $select($get(%request)'="":('$find($get(%request.CgiEnvs("HTTP_USER_AGENT")),"Windows CE"))&&($get(^Development)),1:$get(^Development))
  public static Object $$$DEVMODE(mContext m$) {
    return (m$.Fnc.$select(mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),""),(mOp.Not(m$.Fnc.$find(m$.Fnc.$get(m$.getRequest().getCgiEnvs("HTTP_USER_AGENT")),"Windows CE"))) && mOp.Logical((m$.Fnc.$get(m$.var("^Development")))),1,m$.Fnc.$get(m$.var("^Development"))));
  }

  //<< 
  //<< #; SR17612  - Change INHERIT from 2 to ""
  //<< #; SR17541 - Inherited switches are set to 2 and resolved as boolean values
  //<< #;           at a higher level (e.g. through the Location Hierarchy)
  //<< #define INHERIT     ""
  public static Object $$$INHERIT(mContext m$) {
    return ("");
  }

  //<< #define OK          1
  public static Object $$$OK(mContext m$) {
    return (1);
  }

  //<< #define YES         1
  public static Object $$$YES(mContext m$) {
    return (1);
  }

  //<< #define NO          0
  public static Object $$$NO(mContext m$) {
    return (0);
  }

  //<< #define HASERROR    -1
  public static Object $$$HASERROR(mContext m$) {
    return (mOp.Negative(1));
  }

  //<< #define ALWAYS      1
  public static Object $$$ALWAYS(mContext m$) {
    return (1);
  }

  //<< #define NEVER       0
  public static Object $$$NEVER(mContext m$) {
    return (0);
  }

  //<< #; @NetManager No and Indexed No
  //<< #define ANNO        ""
  public static Object $$$ANNO(mContext m$) {
    return ("");
  }

  //<< #define ANINO       " "
  public static Object $$$ANINO(mContext m$) {
    return (" ");
  }

  //<< #define ANBOOLEAN(%1)   $select(%1:$$$YES,1:$$$ANNO)
  public static Object $$$ANBOOLEAN(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(p$1.get(),$$$YES(m$),1,$$$ANNO(m$)));
  }

  //<< #; WWWSPEI special status
  //<< #define SPEINotOwned  9
  public static Object $$$SPEINotOwned(mContext m$) {
    return (9);
  }

  //<< #define HardFail      0
  public static Object $$$HardFail(mContext m$) {
    return (0);
  }

  //<< #define SaveOkay      1
  public static Object $$$SaveOkay(mContext m$) {
    return (1);
  }

  //<< #define SoftFail      9
  public static Object $$$SoftFail(mContext m$) {
    return (9);
  }

  //<< #; Bit Mapping processing (WWWBITSET)
  //<< #define BitMapSet     1
  public static Object $$$BitMapSet(mContext m$) {
    return (1);
  }

  //<< #define BitMapKill    0
  public static Object $$$BitMapKill(mContext m$) {
    return (0);
  }

  //<< 
  //<< #;-------------------------------------------------------------------------------
  //<< #; The listbuild function can generate a numeric value from the binary prefix
  //<< #; in certain circumstances.
  //<< #; e.g. if the first binary characters are hex "32 01" simply using + will
  //<< #; generate a value 2, incorrectly reporting the status is correct.
  //<< #;
  //<< #; Usage:
  //<< #;    set strStatus = $$$YES
  //<< #;    set strStatus = $$$MakeStatus(idErrorNo)
  //<< #;
  //<< #;    $$$DecomposeStatus(strStatus)
  //<< #;         - resets strStatus to value $listbuild(idErrorNo) if has error prefix
  //<< #;
  //<< #; strStatus should return "0"_space_list or "1" (cf Intersystem errors).
  //<< #define ISOK(%sc)           (+%sc)
  public static Object $$$ISOK(mContext m$, Object ... _p) {
    mVar p$sc = m$.varRef("p$sc",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Positive(p$sc.get())));
  }

  //<< #;define ISERR(%sc)         (('%sc)&&(%sc'="ROLLBACK"))    ;BR014697
  //<< #define ISERR(%sc)          ('%sc)
  public static Object $$$ISERR(mContext m$, Object ... _p) {
    mVar p$sc = m$.varRef("p$sc",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Not(p$sc.get())));
  }

  //<< #define ErrorPrefix         "0 "
  public static Object $$$ErrorPrefix(mContext m$) {
    return ("0 ");
  }

  //<< #def1arg MakeStatus(%1)     $$$ErrorPrefix_$listbuild(%1)
  public static Object $$$MakeStatus(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mOp.Concat($$$ErrorPrefix(m$),m$.Fnc.$listbuild(p$1.get())));
  }

  //<< #define DecomposeStatus(%1) s:($e(%1,1,2)=$$$ErrorPrefix) %1=$e(%1,3,$l(%1))
  public static Object $$$DecomposeStatus(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    if ((mOp.Equal(m$.Fnc.$extract(p$1.get(),1,2),$$$ErrorPrefix(m$)))) {
      p$1.set(m$.Fnc.$extract(p$1.get(),3,m$.Fnc.$length(p$1.get())));
    }
    return null;
  }

  //<< #;-------------------------------------------------------------------------------
  //<< 
  //<< #def1arg Colour(%obj)       $$Colour^COMUtilStr(%obj)
  public static Object $$$Colour(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMUtilStr.Colour",p$obj.get()));
  }

  //<< #def1arg Storage(%obj)      ^mtemp("Tree",YUSER,%obj)
  public static Object $$$Storage(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^mtemp","Tree",m$.var("YUSER").get(),p$obj.get()).get());
  }

  public static mVar $$$StorageVar(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^mtemp","Tree",m$.var("YUSER").get(),p$obj.get()));
  }

  //<< ;BR014941 #define  Index(%obj)     $$Index^COMUtils(%obj)
  //<< #define  Index(%obj)        $select(+(%obj)=(%obj):(%obj),1:$$Index^COMUtilIndex(%obj))
  public static Object $$$Index(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Equal(mOp.Positive((p$obj.get())),(p$obj.get())),(p$obj.get()),1,m$.fnc$("COMUtilIndex.Index",p$obj.get())));
  }

  //<< #define  CacheIndex(%obj)       $select(+(%obj)=(%obj):(%obj),1:$$CacheIndex^COMUtilIndex(%obj))
  public static Object $$$CacheIndex(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Equal(mOp.Positive((p$obj.get())),(p$obj.get())),(p$obj.get()),1,m$.fnc$("COMUtilIndex.CacheIndex",p$obj.get())));
  }

  //<< #def1arg Save(%obj)         $$Save^COMUtils(%obj)
  public static Object $$$Save(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMUtils.Save",p$obj.get()));
  }

  //<< #; define  Kill(%class,%id) KILL^COMUtils(%class,%id)       SR15134
  //<< #define  Kill(%class,%id)   $$KILL^COMUtils(%class,%id)
  public static Object $$$Kill(mContext m$, Object ... _p) {
    mVar p$class = m$.varRef("p$class",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$id = m$.varRef("p$id",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.fnc$("COMUtils.KILL",p$class.get(),p$id.get()));
  }

  //<< #def1arg Text(%str)         $$DecodeError^COMUtilError(%str)
  public static Object $$$Text(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMUtilError.DecodeError",p$str.get()));
  }

  //<< #define  TextSimple(%str)   $$^WWWTEXT(%str)
  public static Object $$$TextSimple(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("WWWTEXT.main",p$str.get()));
  }

  //<< #define  Error(%obj)        do ReturnError^COMUtilError(%obj)
  public static Object $$$Error(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMUtilError.ReturnError",p$obj.get());
    return null;
  }

  //<< 
  //<< #; SR15632 - AddQuotes defn added to clarify multiple definitions of $$$Add
  //<< #; This Add definition is deprecated and should be replaced by $$$AddQuotes - where not defined differently
  //<< #define Add(%obj)           $select(%obj=+%obj:%obj,1:""""_%obj_"""")
  public static Object $$$Add(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Equal(p$obj.get(),mOp.Positive(p$obj.get())),p$obj.get(),1,mOp.Concat(mOp.Concat("\"",p$obj.get()),"\"")));
  }

  //<< #define AddQuotes(%obj)     $select(%obj=+%obj:%obj,1:""""_%obj_"""")
  public static Object $$$AddQuotes(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Equal(p$obj.get(),mOp.Positive(p$obj.get())),p$obj.get(),1,mOp.Concat(mOp.Concat("\"",p$obj.get()),"\"")));
  }

  //<< #define AddToRow(%1)        set lstRow = lstRow_$listbuild(%1)
  public static Object $$$AddToRow(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar lstRow = m$.var("lstRow");
    lstRow.set(mOp.Concat(m$.var("lstRow").get(),m$.Fnc.$listbuild(p$1.get())));
    return null;
  }

  //<< #define Display(%1)         $select(%1="":"---",$$$YES:%1)
  public static Object $$$Display(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Equal(p$1.get(),""),"---",$$$YES(m$),p$1.get()));
  }

  //<< 
  //<< 
  //<< #define NoKey(%obj)         (($get(%obj)="")||(%obj="+"))
  public static Object $$$NoKey(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (((mOp.Equal(m$.Fnc.$get(p$obj),"")) || (mOp.Equal(p$obj.get(),"+"))));
  }

  //<< #define Escape(%obj)        ##class(%CSP.Page).EscapeURL(%obj)
  public static Object $$$Escape(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mLibrary.mPage.EscapeURL(p$obj.get()));
  }

  //<< #define Unescape(%obj)      ##class(%CSP.Page).UnescapeURL(%obj)
  public static Object $$$Unescape(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mLibrary.mPage.UnescapeURL(p$obj.get()));
  }

  //<< #define NoCR(%str)          $translate($get(%str),"|")
  public static Object $$$NoCR(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$translate(m$.Fnc.$get(p$str),"|"));
  }

  //<< #define VStoBreak(%str)     $$Replace^COMUtilStr($get(%str),"|","<BR>")
  public static Object $$$VStoBreak(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMUtilStr.Replace",m$.Fnc.$get(p$str),"|","<BR>"));
  }

  //<< #;SR14915
  //<< #define FormatParagraph(%1) $$Replace^COMUtilStr($get(%1),"|","<p />")
  public static Object $$$FormatParagraph(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMUtilStr.Replace",m$.Fnc.$get(p$1),"|","<p />"));
  }

  //<< #define NoRecord(%str)      ($translate(%str,Y)="")
  public static Object $$$NoRecord(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal(m$.Fnc.$translate(p$str.get(),m$.var("Y").get()),"")));
  }

  //<< 
  //<< 
  //<< #; SR14956 - Check that a value (string/number) falls within a range.
  //<< #define RangeCheck(%1,%2,%3) $select(((%3'="")&&(%1]]%3)):$$$NO,((%2'="")&&(%2'=%1)&&(%2]]%1)):$$$NO,1:$$$YES)
  public static Object $$$RangeCheck(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$3 = m$.varRef("p$3",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return (m$.Fnc.$select(((mOp.NotEqual(p$3.get(),"")) && mOp.Logical((mOp.SortsAfter(p$1.get(),p$3.get())))),$$$NO(m$),((mOp.NotEqual(p$2.get(),"")) && (mOp.NotEqual(p$2.get(),p$1.get())) && mOp.Logical((mOp.SortsAfter(p$2.get(),p$1.get())))),$$$NO(m$),1,$$$YES(m$)));
  }

  //<< 
  //<< #def1arg ExecuteSite(%obj)  $$trySiteEvent^COMDCMSiteEvent(%obj)
  public static Object $$$ExecuteSite(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMDCMSiteEvent.trySiteEvent",p$obj.get()));
  }

  //<< 
  //<< #; <GRF>  TODO
  //<< #;     remove *Const.INC entries
  //<< #; #def1arg SaveGlobal(%obj) $$Save^SALUtils(YM,%obj)
  //<< #;     changed to entry here
  //<< #; #defarg SaveGlobal(%Class,%Keys,%Data) $$Save^COMUtilGlo(%Class,%Keys,%Data)
  //<< #;     Already added #include COMSYS to COM* and IN* routines using $$$SaveGlobal
  //<< #;     Need to check SAL*
  //<< #;     Need to make key string before each $$$SaveGlobal - more efficient than
  //<< #;     trying to work out if right number of keys - entries are hard coded.
  //<< 
  //<< ////#define PublicANMVars APMCO,APMLANG,APMNAMESPACE,APMQUERY,APMUSER,Y,YC,YM,YUCI,YUSER,YBED
  //<< #define PublicANMVars "APMCO,APMLANG,APMNAMESPACE,APMQUERY,APMUSER,Y,YC,YM,YUCI,YUSER,YBED"
  public static Object $$$PublicANMVars(mContext m$) {
    return ("APMCO,APMLANG,APMNAMESPACE,APMQUERY,APMUSER,Y,YC,YM,YUCI,YUSER,YBED");
  }

  //<< 
  //<< // ***********************************************
  //<< // Set debug entries that are maintained if TROLLBACK occurs
  //<< // e.g.  if $$$DebugTest $$$JournalOff set ^SAVE=value $$$JournalOn
  //<< #define JournalOn   do $zu(139,0)
  public static Object $$$JournalOn(mContext m$) {
    m$.Fnc.$zutil(139,0);
    return null;
  }

  //<< #define JournalOff  do $zu(139,1)
  public static Object $$$JournalOff(mContext m$) {
    m$.Fnc.$zutil(139,1);
    return null;
  }

  //<< // ***********************************************
  //<< 
  //<< // Write variables in memory to file in disclinc/dump/{user}
  //<< #define DevMem(%1)  do DevMem^COMUtilLog(%1)
  public static Object $$$DevMem(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMUtilLog.DevMem",p$1.get());
    return null;
  }

  //<< 
  //<< // ***********************************************
  //<< // TODO : Use macro to clarify operation
  //<< //    End-Of-File handling for sequential files
  //<< // do $ZUTIL(68,40,1)
  //<< //    Eliminates the <ENDOFFILE> error for sequential
  //<< //    files for the current process. Instead, when
  //<< //    the end of a file is reached, the READ command
  //<< //    returns a null string, the $ZPOS special variable
  //<< //    is set to "" (the null string), and the $ZEOF
  //<< //    special variable is set to –1.
  //<< // ***********************************************
  //<< 
  //<< #; TODO : Are these required - taken from SYSDisc.INC and may be obsolete
  //<< #;        Note variation in CacheTemp Global used
  //<< ////#define TStart(%1,%2)   new TransactionLevel do $zu(139,1) set TransactionLevel=$I(^CacheTempTransactionCount),^CacheTempTransactions($job,%1,TransactionLevel)=$h_""|""_%2 do $zu(139,0) tstart
  //<< #define TStart(%1,%2)   new TransactionLevel do $zu(139,1) set TransactionLevel=$I(^CacheTempTransactionCount),^CacheTempTransactions($job,%1,TransactionLevel)=$h_"|"_%2 do $zu(139,0) tstart
  public static Object $$$TStart(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar TransactionLevel = m$.var("TransactionLevel");
    m$.newVar(TransactionLevel);
    m$.Fnc.$zutil(139,1);
    TransactionLevel.set(m$.Fnc.$increment(m$.var("^CacheTempTransactionCount")));
    m$.var("^CacheTempTransactions",m$.Fnc.$job(),p$1.get(),TransactionLevel.get()).set(mOp.Concat(mOp.Concat(m$.Fnc.$horolog(),"|"),p$2.get()));
    m$.Fnc.$zutil(139,0);
    return null;
  }

  //<< #define TCommit(%1)     new CurrentTlevel,NewTLevel set CurrentTlevel=$tlevel tcommit:CurrentTlevel  set NewTLevel=$tlevel if CurrentTlevel>NewTLevel do $zu(139,1) kill ^CacheTempTransactions($job,%1,TransactionLevel) do $zu(139,0)
  public static Object $$$TCommit(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar CurrentTlevel = m$.var("CurrentTlevel");
    mVar NewTLevel = m$.var("NewTLevel");
    m$.newVar(CurrentTlevel,NewTLevel);
    CurrentTlevel.set(m$.Fnc.$tlevel());
    NewTLevel.set(m$.Fnc.$tlevel());
    if (mOp.Greater(CurrentTlevel.get(),NewTLevel.get())) {
      m$.Fnc.$zutil(139,1);
      m$.var("^CacheTempTransactions",m$.Fnc.$job(),p$1.get(),m$.var("TransactionLevel").get()).kill();
      m$.Fnc.$zutil(139,0);
    }
    return null;
  }

  //<< #define TRollback(%1)   trollback:$tlevel>0  do $zu(139,1) kill:$d(TransactionLevel) ^CacheTempDiscTransactions($job,%1,TransactionLevel) do $zu(139,0)
  public static Object $$$TRollback(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Fnc.$zutil(139,1);
    if (mOp.Logical(m$.Fnc.$data(m$.var("TransactionLevel")))) {
      m$.var("^CacheTempDiscTransactions",m$.Fnc.$job(),p$1.get(),m$.var("TransactionLevel").get()).kill();
    }
    m$.Fnc.$zutil(139,0);
    return null;
  }

  //<< // ***********************************************
  //<< 
  //<< #; NOTE : %str passed to $$$Text *MUST* be include $listbuild if message contains values.
  //<< #def1arg AlertVB(%str)          write $$Alert^COMViewSetupVB(%str)
  public static Object $$$AlertVB(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Write(m$.fnc$("COMViewSetupVB.Alert",p$str.get()));
    return null;
  }

  //<< #define Alert(%str)             do Alert^COMConst($$$Text(%str,1))
  public static Object $$$Alert(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMConst.Alert",$$$Text(m$,p$str,1));
    return null;
  }

  //<< #define AlertInScript(%str)     do AlertInScript^COMConst($$$Text(%str,1))
  public static Object $$$AlertInScript(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMConst.AlertInScript",$$$Text(m$,p$str,1));
    return null;
  }

  //<< #define AlertString(%str)       do Alert^COMConst(%str)
  public static Object $$$AlertString(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMConst.Alert",p$str.get());
    return null;
  }

  //<< #def1arg CallBack(%str)         $$CallBack^COMViewSetupVB(%str)
  public static Object $$$CallBack(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMViewSetupVB.CallBack",p$str.get()));
  }

  //<< #define ShowPrompt(%1,%2,%3)    do ShowPrompt^COMConst(%1,%2,%3)
  public static Object $$$ShowPrompt(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$3 = m$.varRef("p$3",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.Cmd.Do("COMConst.ShowPrompt",p$1.get(),p$2.get(),p$3.get());
    return null;
  }

  //<< 
  //<< #define DLFError            zt "DLFE"
  public static Object $$$DLFError(mContext m$) {
    return null;
  }

  //<< 
  //<< 
  //<< #;  ^Dump = "\\orion\DiscLinc\Dump\,####"         updated on call and creates file
  //<< #;  \\orion\DiscLinc\Dump\{YBED}\Dump-YYYY-MM-DD-hh-mm-ss-####@Subr+Offset^Routine-+1.htm
  //<< #define Dump                do ##class(Common.Dump).DumpFile()
  public static Object $$$Dump(mContext m$) {
    m$.Cmd.Do("Common.Dump.DumpFile");
    return null;
  }

  //<< 
  //<< 
  //<< #; If global %g is not null, return %g. Otherwise return %r (which should set %g)
  //<< #define GetGlobal(%g,%r)    $select($get(%g)'="":$get(%g),1:%r)
  public static Object $$$GetGlobal(mContext m$, Object ... _p) {
    mVar p$g = m$.varRef("p$g",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$r = m$.varRef("p$r",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select(mOp.NotEqual(m$.Fnc.$get(p$g),""),m$.Fnc.$get(p$g),1,p$r.get()));
  }

  //<< 
  //<< 
  //<< #; Micro Operations:
  //<< #;
  //<< #; For the client side javascript code see the function retvalcheck in library eventbroker??.js
  //<< 
  //<< #define EscapeHyperEventData(%str) $$EscapeString^COMUtilStr(%str,$$$AllMicroOps,$$$YES)
  public static Object $$$EscapeHyperEventData(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMUtilStr.EscapeString",p$str.get(),$$$AllMicroOps(m$),$$$YES(m$)));
  }

  //<< #define UnEscapeHyperEventData(%str) $$UnEscapeString^COMUtilStr(%str,$$$AllMicroOps,$$$YES)
  public static Object $$$UnEscapeHyperEventData(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMUtilStr.UnEscapeString",p$str.get(),$$$AllMicroOps(m$),$$$YES(m$)));
  }

  //<< 
  //<< #define AllMicroOps $$$AlertFollowing_$$$AlertAndFocus_$$$Confirm_$$$Prompt_$$$Open_$$$Perform_$$$ParentPerform
  public static Object $$$AllMicroOps(mContext m$) {
    return (mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat($$$AlertFollowing(m$),$$$AlertAndFocus(m$)),$$$Confirm(m$)),$$$Prompt(m$)),$$$Open(m$)),$$$Perform(m$)),$$$ParentPerform(m$)));
  }

  //<< #define AlertFollowing "!"
  public static Object $$$AlertFollowing(mContext m$) {
    return ("!");
  }

  //<< #define AlertAndFocus  "§"
  public static Object $$$AlertAndFocus(mContext m$) {
    return ("§");
  }

  //<< #define Confirm        "&"
  public static Object $$$Confirm(mContext m$) {
    return ("&");
  }

  //<< #define Prompt         "?"
  public static Object $$$Prompt(mContext m$) {
    return ("?");
  }

  //<< #define Open           "@"
  public static Object $$$Open(mContext m$) {
    return ("@");
  }

  //<< #define Perform        "#"
  public static Object $$$Perform(mContext m$) {
    return ("#");
  }

  //<< #define ParentPerform  "þ"
  public static Object $$$ParentPerform(mContext m$) {
    return ("þ");
  }

  //<< 
  //<< #define CONTEXT ('$get(^SysSetup("ContextMenu")) && ($get(YUSER)'=""))
  public static Object $$$CONTEXT(mContext m$) {
    return ((mOp.Not(m$.Fnc.$get(m$.var("^SysSetup","ContextMenu"))) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),""))));
  }

  //<< #define TERMRUN ($piece($IO,"|",2)'="TNT")&&($piece($IO,"|",2)'="TRM")
  public static Object $$$TERMRUN(mContext m$) {
    return ((mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$io(),"|",2),"TNT")) && (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$io(),"|",2),"TRM")));
  }

  //<< 
  //<< #define OrdersInvoiceEndsWithDot(%obj)     ($get(^SysSetup("Duplicate invoice fix"))=1 && ($extract($reverse($$$INAUFInvoiceNumber(%obj)))=".") && ($length($$$INAUFInvoiceNumber(%obj)) > 1))
  public static Object $$$OrdersInvoiceEndsWithDot(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal(m$.Fnc.$get(m$.var("^SysSetup","Duplicate invoice fix")),1) && (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(include.INConst.$$$INAUFInvoiceNumber(m$,p$obj))),".")) && (mOp.Greater(m$.Fnc.$length(include.INConst.$$$INAUFInvoiceNumber(m$,p$obj)),1))));
  }

  //<< #define OrderLinesInvoiceEndsWithDot(%obj) ($get(^SysSetup("Duplicate invoice fix"))=1 && ($extract($reverse($$$INAUFPInvoiceNumber(%obj)))=".") && ($length($$$INAUFPInvoiceNumber(%obj)) > 1))
  public static Object $$$OrderLinesInvoiceEndsWithDot(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal(m$.Fnc.$get(m$.var("^SysSetup","Duplicate invoice fix")),1) && (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(include.INConst.$$$INAUFPInvoiceNumber(m$,p$obj))),".")) && (mOp.Greater(m$.Fnc.$length(include.INConst.$$$INAUFPInvoiceNumber(m$,p$obj)),1))));
  }

  //<< 
  //<< #define ButtonOK        1
  public static Object $$$ButtonOK(mContext m$) {
    return (1);
  }

  //<< #define ButtonCancel    2
  public static Object $$$ButtonCancel(mContext m$) {
    return (2);
  }

  //<< #define ButtonAbort     3
  public static Object $$$ButtonAbort(mContext m$) {
    return (3);
  }

  //<< #define ButtonRetry     4
  public static Object $$$ButtonRetry(mContext m$) {
    return (4);
  }

  //<< #define ButtonIgnore    5
  public static Object $$$ButtonIgnore(mContext m$) {
    return (5);
  }

  //<< #define ButtonYes       6
  public static Object $$$ButtonYes(mContext m$) {
    return (6);
  }

  //<< #define ButtonNo        7
  public static Object $$$ButtonNo(mContext m$) {
    return (7);
  }

  //<< 
  //<< 
  //<< #define VAR if $get(Y)="" do ^WWWVAR
  public static Object $$$VAR(mContext m$) {
    if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    return null;
  }

  //<< 
  //<< #define REPFolder       "Report"
  public static Object $$$REPFolder(mContext m$) {
    return ("Report");
  }

  //<< 
  //<< #define DirDown     1
  public static Object $$$DirDown(mContext m$) {
    return (1);
  }

  //<< #define DirUp       -1
  public static Object $$$DirUp(mContext m$) {
    return (mOp.Negative(1));
  }

  //<< 
  //<< #define YQHandler(%1)   if $$$ISOK(%1) { set YQ = $$$YQEnable } else { set YQ = $$$YQDisable(%1) }
  public static Object $$$YQHandler(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    if (mOp.Logical($$$ISOK(m$,p$1))) {
      mVar YQ = m$.var("YQ");
      YQ.set(include.COMSYSWWW.$$$YQEnable(m$));
    }
    else {
      mVar YQ = m$.var("YQ");
      YQ.set(include.COMSYSWWW.$$$YQDisable(m$,p$1));
    }
    return null;
  }

  //<< #define YQMessage       $extract(YQ,2,$length(YQ))
  public static Object $$$YQMessage(mContext m$) {
    return (m$.Fnc.$extract(m$.var("YQ").get(),2,m$.Fnc.$length(m$.var("YQ").get())));
  }

  //<< 
  //<< ////#define JS(%1)          $$$StartScript() write %1 $$$EndScript()
  //<< #define JS(%1)          do StartScript^COMUtiljavascript() write %1 do EndScript^COMUtiljavascript()
  public static Object $$$JS(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMUtiljavascript.StartScript");
    m$.Cmd.Write(p$1.get());
    m$.Cmd.Do("COMUtiljavascript.EndScript");
    return null;
  }

  //<< #define JSBoolean(%1)   $select(%1="true":$$$YES,1:$$$NO)
  public static Object $$$JSBoolean(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Equal(p$1.get(),"true"),$$$YES(m$),1,$$$NO(m$)));
  }

  //<< 
  //<< 
  //<< #define LOCKCODE    "="
  public static Object $$$LOCKCODE(mContext m$) {
    return ("=");
  }

  //<< #; THE LENGTH OF THE ABOVE!!!
  //<< #define LOCKCODELEN 1
  public static Object $$$LOCKCODELEN(mContext m$) {
    return (1);
  }

  //<< #define LOCKCALL    "$$"
  public static Object $$$LOCKCALL(mContext m$) {
    return ("$$");
  }

  //<< 
  //<< #define InHyperEvent            (($get(%session)'="")&&$IsObject(%session)&&($get(^CacheTempInHyperEvent(%session.SessionId,$job))))
  public static Object $$$InHyperEvent(mContext m$) {
    return (((mOp.NotEqual(m$.Fnc.$get(m$.getSession()),"")) && mOp.Logical(m$.Fnc.$isobject(m$.getSession())) && mOp.Logical((m$.Fnc.$get(m$.var("^CacheTempInHyperEvent",m$.getSession().getSessionId(),m$.Fnc.$job()))))));
  }

  //<< #define NotInHyperEvent         (($get(%session)'="")&&$IsObject(%session)&&'($get(^CacheTempInHyperEvent(%session.SessionId,$job))))
  public static Object $$$NotInHyperEvent(mContext m$) {
    return (((mOp.NotEqual(m$.Fnc.$get(m$.getSession()),"")) && mOp.Logical(m$.Fnc.$isobject(m$.getSession())) && mOp.Not((m$.Fnc.$get(m$.var("^CacheTempInHyperEvent",m$.getSession().getSessionId(),m$.Fnc.$job()))))));
  }

  //<< 
  //<< #define StartScript(%str)       do StartScript^COMUtiljavascript(%str)
  public static Object $$$StartScript(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMUtiljavascript.StartScript",p$str.get());
    return null;
  }

  //<< #define EndScript(%str)         do EndScript^COMUtiljavascript()
  public static Object $$$EndScript(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("COMUtiljavascript.EndScript");
    return null;
  }

  //<< #define InScriptTag             $data(^CacheTempjavascript(YUSER))
  public static Object $$$InScriptTag(mContext m$) {
    return (m$.Fnc.$data(m$.var("^CacheTempjavascript",m$.var("YUSER").get())));
  }

  //<< #define AtScriptClosingLevel    ($get(^CacheTempjavascript(YUSER))=1)
  public static Object $$$AtScriptClosingLevel(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempjavascript",m$.var("YUSER").get())),1)));
  }

  //<< 
  //<< #; Would have liked to YERROR to report detail of application error in email but
  //<< #; YERROR is changed before writting mailto hyperlink
  //<< #define AppError(%1)    $listbuild("Com00251",%1) do ##class(Common.Dump).DumpFile($$$Text($listbuild("Com00251",%1)))
  public static Object $$$AppError(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.Cmd.Do("Common.Dump.DumpFile",$$$Text(m$,m$.Fnc.$listbuild("Com00251",p$1.get())));
    return (m$.Fnc.$listbuild("Com00251",p$1.get()));
  }

  //<< 
  //<< #define EnumDisplayTypeExcel    0
  public static Object $$$EnumDisplayTypeExcel(mContext m$) {
    return (0);
  }

  //<< #define EnumDisplayTypeCSV      1
  public static Object $$$EnumDisplayTypeCSV(mContext m$) {
    return (1);
  }

  //<< #define EnumDisplayTypeCOMView  -1
  public static Object $$$EnumDisplayTypeCOMView(mContext m$) {
    return (mOp.Negative(1));
  }

  //<< 
  //<< 
  //<< //#define   Contains(%1,%2)         $listfind($listbuild%1,%2)
  //<< #define Contains(%1,%2)         $listfind($listbuild(%1),%2)
  public static Object $$$Contains(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$listfind(m$.Fnc.$listbuild(p$1.get()),p$2.get()));
  }

  //<< 
  //<< #define Coalesce(%1,%2)         $select(%1'="":%1,1:%2)
  public static Object $$$Coalesce(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$select(mOp.NotEqual(p$1.get(),""),p$1.get(),1,p$2.get()));
  }

  //<< 
  //<< 
  //<< #define HYPERValidation(%f)     ($$$WWW120ConstantFieldValidating($get(^WWW120(0,%f,1)))&&'$get(^SysSetup("NoHyper",%f)))
  public static Object $$$HYPERValidation(mContext m$, Object ... _p) {
    mVar p$f = m$.varRef("p$f",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Logical(include.WWWConst.$$$WWW120ConstantFieldValidating(m$,m$.Fnc.$get(m$.var("^WWW120",0,p$f.get(),1)))) && mOp.Not(m$.Fnc.$get(m$.var("^SysSetup","NoHyper",p$f.get())))));
  }

  //<< 
  //<< #; Formula Evaluation Calculator
  //<< #;------------------------------------------
  //<< #define NotANumber      ":NaN"
  public static Object $$$NotANumber(mContext m$) {
    return (":NaN");
  }

  //<< #define InvalidChar     ":ERR"
  public static Object $$$InvalidChar(mContext m$) {
    return (":ERR");
  }

  //<< #define BadFunction     ":BF"
  public static Object $$$BadFunction(mContext m$) {
    return (":BF");
  }

  //<< #define BracketCount    ":BC"
  public static Object $$$BracketCount(mContext m$) {
    return (":BC");
  }

  //<< #define UnknownFunction ":UF"
  public static Object $$$UnknownFunction(mContext m$) {
    return (":UF");
  }

  //<< 
  //<< #;  used by build routines
  //<< #define KILLOUT(%1)     set ^WWWOUT(0,$increment(NUMMER),0,1)=%1
  public static Object $$$KILLOUT(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.var("^WWWOUT",0,m$.Fnc.$increment(m$.var("NUMMER")),0,1).set(p$1.get());
    return null;
  }

  //<< 
  //<< #define ExecuteCode(%1) $$ExecuteCode^COMUtils(%1)
  public static Object $$$ExecuteCode(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMUtils.ExecuteCode",p$1.get()));
  }

  //<< #define FREE            "_FREE"
  public static Object $$$FREE(mContext m$) {
    return ("_FREE");
  }

  //<< 
  //<< #define NewLineCharForMemoFields "|"
  public static Object $$$NewLineCharForMemoFields(mContext m$) {
    return ("|");
  }

  //<< 
  //<< #define GetSizeEvent(%1,%2) "var result=EventValue(document.WWW.YUCI.value,document.WWW.YUSER.value,document.WWW.YFORM.value,'Start','GetSize^COMViewSession','"_%2_"','6','NOVALUE');result=result.split('"_%1_"'); var "_%2_"Height=result[0];"_%2_"Width=result[1];"
  public static Object $$$GetSizeEvent(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("var result=EventValue(document.WWW.YUCI.value,document.WWW.YUSER.value,document.WWW.YFORM.value,'Start','GetSize^COMViewSession','",p$2.get()),"','6','NOVALUE');result=result.split('"),p$1.get()),"'); var "),p$2.get()),"Height=result[0];"),p$2.get()),"Width=result[1];"));
  }

  //<< 
  //<< #;SR16773
  //<< #define ScanDelim $$GetScanDelim^COMUtils()
  public static Object $$$ScanDelim(mContext m$) {
    return (m$.fnc$("COMUtils.GetScanDelim"));
  }

  //<< 
  //<< #; $order   SR14421
  //<< #; vvvvvvvvvvvvvvvvvvvvv
  //<< #;
  //<< #; Because functionality is obscured using these macros, their use is now     *** DEPRECATED ***
  //<< #;
  //<< ////#define Order1(%2,%1)                       set %1 = "" for { set %1 = $order(%2(%1)) quit:%1=""
  //<< ////#define Order2(%2,%3,%1)                    set %1 = "" for { set %1 = $order(%2(%3,%1)) quit:%1=""
  //<< ////#define Order3(%2,%3,%4,%1)                 set %1 = "" for { set %1 = $order(%2(%3,%4,%1)) quit:%1=""
  //<< ////#define Order4(%2,%3,%4,%5,%1)              set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%1)) quit:%1=""
  //<< ////#define Order5(%2,%3,%4,%5,%6,%1)           set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%1)) quit:%1=""
  //<< ////#define Order6(%2,%3,%4,%5,%6,%7,%1)        set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%7,%1)) quit:%1=""
  //<< ////#define Order7(%2,%3,%4,%5,%6,%7,%8,%1)     set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%7,%8,%1)) quit:%1=""
  //<< ////#define Order8(%2,%3,%4,%5,%6,%7,%8,%9,%1)  set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%7,%8,%9,%1)) quit:%1=""
  //<< 
  //<< #; $order macros in reverse SR15342
  //<< ////#define RevOrder1(%2,%1)                        set %1 = "" for { set %1 = $order(%2(%1),-1) quit:%1=""
  //<< ////#define RevOrder2(%2,%3,%1)                     set %1 = "" for { set %1 = $order(%2(%3,%1),-1) quit:%1=""
  //<< ////#define RevOrder3(%2,%3,%4,%1)                  set %1 = "" for { set %1 = $order(%2(%3,%4,%1),-1) quit:%1=""
  //<< ////#define RevOrder4(%2,%3,%4,%5,%1)               set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%1),-1) quit:%1=""
  //<< ////#define RevOrder5(%2,%3,%4,%5,%6,%1)            set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%1),-1) quit:%1=""
  //<< ////#define RevOrder6(%2,%3,%4,%5,%6,%7,%1)         set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%7,%1),-1) quit:%1=""
  //<< ////#define RevOrder7(%2,%3,%4,%5,%6,%7,%8,%1)      set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%7,%8,%1),-1) quit:%1=""
  //<< ////#define RevOrder8(%2,%3,%4,%5,%6,%7,%8,%9,%1)   set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%7,%8,%9,%1),-1) quit:%1=""
  //<< 
  //<< ////#define DirOrder1(%2,%1,%dir)                       set %1 = "" for { set %1 = $order(%2(%1),%dir) quit:%1=""
  //<< ////#define DirOrder2(%2,%3,%1,%dir)                    set %1 = "" for { set %1 = $order(%2(%3,%1),%dir) quit:%1=""
  //<< ////#define DirOrder3(%2,%3,%4,%1,%dir)                 set %1 = "" for { set %1 = $order(%2(%3,%4,%1),%dir) quit:%1=""
  //<< ////#define DirOrder4(%2,%3,%4,%5,%1,%dir)              set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%1),%dir) quit:%1=""
  //<< ////#define DirOrder5(%2,%3,%4,%5,%6,%1,%dir)           set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%1),%dir) quit:%1=""
  //<< ////#define DirOrder6(%2,%3,%4,%5,%6,%7,%1,%dir)        set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%7,%1),%dir) quit:%1=""
  //<< ////#define DirOrder7(%2,%3,%4,%5,%6,%7,%8,%1,%dir)     set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%7,%8,%1),%dir) quit:%1=""
  //<< ////#define DirOrder8(%2,%3,%4,%5,%6,%7,%8,%9,%1,%dir)  set %1 = "" for { set %1 = $order(%2(%3,%4,%5,%6,%7,%8,%9,%1),%dir) quit:%1=""
  //<< 
  //<< #; $query - %2 is the array, and %1 the variable    SR14508
  //<< #; QueryKey returns all the array subscripts
  //<< #; QueryANKey - returns the @net key (no company / trailing 1)
  //<< #; QueryANid - returns last @net node               SR15084
  //<< ////#define Query(%2,%1)                set %1=%2,%3=$qlength(%1),%4=$name(@%1,%3) for { set %1=$query(@%1) quit:(%1="")||($name(@%1,%3)'=%4)
  //<< #define QueryKey(%1)                $piece($extract(%1,1,$length(%1)-1),"(",2)
  public static Object $$$QueryKey(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(m$.Fnc.$extract(p$1.get(),1,mOp.Subtract(m$.Fnc.$length(p$1.get()),1)),"(",2));
  }

  //<< #define QueryANKey(%1)              $piece(%1,",",2,$length(%1,",")-1)
  public static Object $$$QueryANKey(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),",",2,mOp.Subtract(m$.Fnc.$length(p$1.get(),","),1)));
  }

  public static void $$$QueryANKeySet(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,",",2,mOp.Subtract(m$.Fnc.$length(p$1.get(),","),1)).set(_setval.get());
  }

  //<< #define QueryANid(%1)               $piece(%1,",",$length(%1,",")-1)
  public static Object $$$QueryANid(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),",",mOp.Subtract(m$.Fnc.$length(p$1.get(),","),1)));
  }

  public static void $$$QueryANidSet(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,",",mOp.Subtract(m$.Fnc.$length(p$1.get(),","),1)).set(_setval.get());
  }

//<< 
//<< 
//<< ////#define End                                 }
//<< ////#define EndErr(%1)                          quit:$$$ISERR(%1) }
//<< 
//<< #; ^^^^^^^^^^^^^^^^^^^^^
}
