//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWNEXT
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:38
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
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

//<< WWWNEXT(pYFORMDATEI,YZAHL)
public class WWWNEXT extends mClass {

  public Object main(Object ... _p) {
    mVar pYFORMDATEI = m$.newVarRef("pYFORMDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YZAHL = m$.newVarRef("YZAHL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _WWWNEXT(pYFORMDATEI,YZAHL);
  }

  public Object _WWWNEXT(Object ... _p) {
    mVar pYFORMDATEI = m$.newVarRef("pYFORMDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YZAHL = m$.newVarRef("YZAHL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< ;---------------------------------------
    //<< ; Numerator Classes
    //<< ;           WWW128      WWW1280     WWW1281     WWW128Form
    //<< ;   P1      Form        Form        Form        Class
    //<< ;   P2       -          Location    Sequence    Form (associated with P1)
    //<< ;
    //<< ;   D1      SeqNo       SeqNo       SeqNo       Prefix
    //<< ;   D2      Increment   Increment    -          Link Class
    //<< ;   D3      Reset       Reset
    //<< ;   D4      ResetYear   ResetYear
    //<< ;---------------------------------------
    //<< 
    //<< ;------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       NAESCHSTE LAUFENDE NUMMER
    //<< ;      SET NO=$$^WWWNEXT(FORMNAME)
    //<< ;
    //<< ; Inputs :
    //<< ;   pYFORMDATEI  : FORMUALR / FORM ;shape
    //<< ;   YZAHL  : ZAHLER, UM DEN HOCHGEZÄHLT WIRD / SEQUENCE
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 28-Aug-2013   shobby  CORE-251: Fixed problem with INCALL form
    //<< ; 02-May-2012   shobby  SR17817: Check whether this has been called from a save
    //<< ;                           in a form (idYFORM).  Otherwise for background processes
    //<< ;                           continue as before.
    //<< ; 02-Jul-2008   shobby  SRBR014965: Reworked so that multiple forms/classes can
    //<< ;                           share a numbering sequence (with a different prefix)
    //<< ; 25-Sep-2007   GRF     SR15602: variables moved to NEW in subroutine; A=>idNext;
    //<< ;                       Consolidate YDATEI/YFKEY decisions
    //<< ; 12-Aug-2005   Steve S Macro Usage
    //<< ; 06-Jun-2005   GRF     Replace $data(YM) with $get; !=>||
    //<< ; 31-May-2005   RobertW SR12056: Attempt at Performance Improvement
    //<< ; 17.03.1999    DT
    //<< ;-----------------------------------------------------------------------------
    //<< new idNext,YDATEI,YI
    mVar idNext = m$.var("idNext");
    mVar YDATEI = m$.var("YDATEI");
    mVar YI = m$.var("YI");
    m$.newVar(idNext,YDATEI,YI);
    //<< new idYFORM,objWWW128,strCheckList,strLink,strPrefix
    mVar idYFORM = m$.var("idYFORM");
    mVar objWWW128 = m$.var("objWWW128");
    mVar strCheckList = m$.var("strCheckList");
    mVar strLink = m$.var("strLink");
    mVar strPrefix = m$.var("strPrefix");
    m$.newVar(idYFORM,objWWW128,strCheckList,strLink,strPrefix);
    //<< 
    //<< ; BR014965.  A bit of juggling of parameters here.  previously the parameter YFORM contained the class (usually)
    //<< ; and the actual YFORM in the calling routines could be different.
    //<< set idYFORM=$get(YFORM)
    idYFORM.set(m$.Fnc.$get(m$.var("YFORM")));
    //<< new YFORM
    mVar YFORM = m$.var("YFORM");
    m$.newVar(YFORM);
    //<< set YFORM = $get(pYFORMDATEI)
    YFORM.set(m$.Fnc.$get(pYFORMDATEI));
    //<< ;==========================================================================
    //<< set YZAHL =+$get(YZAHL)
    YZAHL.set(mOp.Positive(m$.Fnc.$get(YZAHL)));
    //<< if YZAHL=0 set YZAHL=1
    if (mOp.Equal(YZAHL.get(),0)) {
      YZAHL.set(1);
    }
    //<< if $get(YM)="" set YM=0
    if (mOp.Equal(m$.Fnc.$get(m$.var("YM")),"")) {
      mVar YM = m$.var("YM");
      YM.set(0);
    }
    //<< 
    //<< set idNext=""
    idNext.set("");
    //<< if YFORM="" quit ""   ;KEIN FORMULAR ;no form
    if (mOp.Equal(YFORM.get(),"")) {
      return "";
    }
    //<< 
    //<< if $get(YUCI)="" set YUCI=$ZUTIL(5)
    if (mOp.Equal(m$.Fnc.$get(m$.var("YUCI")),"")) {
      mVar YUCI = m$.var("YUCI");
      YUCI.set(m$.Fnc.$zutil(5));
    }
    //<< if $get(Y)="" do ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< 
    //<< set strPrefix = $$GetPrefix^WWW128Form(YFORM,idYFORM)
    strPrefix.set(m$.fnc$("WWW128Form.GetPrefix",YFORM.get(),idYFORM.get()));
    //<< set strLink   = $$GetLink^WWW128Form(YFORM,idYFORM)
    strLink.set(m$.fnc$("WWW128Form.GetLink",YFORM.get(),idYFORM.get()));
    //<< 
    //<< set YDATEI = $$$WWW120ClassUsedInForm($get(^WWW120(0,YFORM,1)))
    YDATEI.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1))));
    //<< if YDATEI'="" if ($$$WWW001SharedFile($get(^WWW001(0,YDATEI,1)))=1)||(YDATEI="WWW009") new YM set YM=0  ;when shared data file - Deprecated
    if (mOp.NotEqual(YDATEI.get(),"")) {
      if ((mOp.Equal(include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1))),1)) || (mOp.Equal(YDATEI.get(),"WWW009"))) {
        mVar YM = m$.var("YM");
        m$.newVar(YM);
        YM.set(0);
      }
    }
    //<< if strLink'="" set YFORM = strLink  ; Redirect the Numerator to another class
    if (mOp.NotEqual(strLink.get(),"")) {
      YFORM.set(strLink.get());
    }
    //<< 
    //<< if '$DATA(^WWW128(YM,YFORM,1)) set ^WWW128(YM,YFORM,1) = $$DefaultSequenceNo^COMUtils()  ; returns site or server with "0000000"
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW128",m$.var("YM").get(),YFORM.get(),1)))) {
      m$.var("^WWW128",m$.var("YM").get(),YFORM.get(),1).set(m$.fnc$("COMUtils.DefaultSequenceNo"));
    }
    //<< if '$DATA(^WWW128(YM,YFORM,1)) set ^WWW128(YM,YFORM,1) = 0     ; FIXME : The previous line will ensure $data is "true" - deprecated? <GRF>
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW128",m$.var("YM").get(),YFORM.get(),1)))) {
      m$.var("^WWW128",m$.var("YM").get(),YFORM.get(),1).set(0);
    }
    //<< 
    //<< if YDATEI="" {  ; without a class
    if (mOp.Equal(YDATEI.get(),"")) {
      //<< do NEXT
      m$.Cmd.Do("NEXT");
    }
    //<< } else {
    else {
      //<< set strCheckList = $$GetPrefixes^WWW128Form(YFORM)
      strCheckList.set(m$.fnc$("WWW128Form.GetPrefixes",YFORM.get()));
      //<< for {
      for (;true;) {
        //<< do NEXT
        m$.Cmd.Do("NEXT");
        //<< quit:'$$Find(strCheckList,idNext,$piece($$GetKey(.YKEY,$get(YFKEY)),Y,1)) ;CORE-251
        if (mOp.Not(m$.fnc$("Find",strCheckList.get(),idNext.get(),m$.Fnc.$piece(m$.fnc$("GetKey",m$.var("YKEY"),m$.Fnc.$get(m$.var("YFKEY"))),m$.var("Y").get(),1)))) {
          break;
        }
      }
    }
    //<< ; 17974 the following line caused translation DCM to stop and exceed license limit preventing login with
    //<< ; browser or studio as many processes were stuck in WWWNEXT.
    //<< ; Further investigation as some processes won't have anything in WWWDATEN
    //<< ; maybe if $get(YFKEY)="" set YFKEY=$piece(^WWWDATEN(YM,+$h,YUSER,YFORM,"P",1),",",1)
    //<< ;SR17817 (reverted 28-Dec-2011 17974) quit:'$$Find(strCheckList,idNext,$piece(^WWWDATEN(YM,+$h,YUSER,YFORM,"P",1),",",1)) ;SR17817
    //<< ;CORE-251 will cause failure on current record. quit:($get(YUSER)'="")&&($get(idYFORM)'="")&&'$$Find(strCheckList,idNext,$piece(^WWWDATEN(YM,+$h,YUSER,idYFORM,"P",1),",",1)) ;SR17817
    //<< }
    //<< }
    //<< 
    //<< quit strPrefix_idNext
    return mOp.Concat(strPrefix.get(),idNext.get());
  }

  //<< 
  //<< GetKey(&YKEY,YFKEY="") ;CORE-251
  public Object GetKey(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFKEY = m$.newVarRef("YFKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Build up the key
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Aug-2013   shobby  CORE-251: Removed trailing ,
    //<< ; 24-Aug-2013   shobby  CORE-251: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YFKEY,i
    YFKEY = m$.var("YFKEY");
    mVar i = m$.var("i");
    m$.newVar(YFKEY,i);
    //<< 
    //<< if $get(YFKEY)="" {
    if (mOp.Equal(m$.Fnc.$get(YFKEY),"")) {
      //<< set YFKEY=""
      YFKEY.set("");
      //<< set i=$order(YKEY(""),-1)
      i.set(m$.Fnc.$order(YKEY.var(""),mOp.Negative(1)));
      //<< for {
      for (;true;) {
        //<< set i=$order(YKEY(i),-1)
        i.set(m$.Fnc.$order(YKEY.var(i.get()),mOp.Negative(1)));
        //<< quit:(i="")
        if ((mOp.Equal(i.get(),""))) {
          break;
        }
        //<< set YFKEY=YFKEY_YKEY(i)_","
        YFKEY.set(mOp.Concat(mOp.Concat(YFKEY.get(),YKEY.var(i.get()).get()),","));
      }
    }
    //<< }
    //<< }
    //<< if $extract(YFKEY,$length(YFKEY))="," set $extract(YFKEY,$length(YFKEY))="" ; CORE-251
    if (mOp.Equal(m$.Fnc.$extract(YFKEY.get(),m$.Fnc.$length(YFKEY.get())),",")) {
      mVar $extract = m$.var("$extract");
      $extract.var(YFKEY.get(),m$.Fnc.$length(YFKEY.get())).set("");
    }
    //<< 
    //<< quit YFKEY
    return YFKEY.get();
  }

  //<< 
  //<< Index(YDATEI)
  public Object Index(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Find the index on the last primary key
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Aug-2013   shobby  CORE-251: Initialise intIndex
    //<< ; 01-Dec-2011   shobby  SR17817 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idWWW002,intIndex,objWWW002
    mVar idWWW002 = m$.var("idWWW002");
    mVar intIndex = m$.var("intIndex");
    mVar objWWW002 = m$.var("objWWW002");
    m$.newVar(idWWW002,intIndex,objWWW002);
    //<< set idWWW002=$order(^WWW002(0,YDATEI,""),-1)
    idWWW002.set(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1)));
    //<< set intIndex="" ;CORE-251
    intIndex.set("");
    //<< if idWWW002'="" {
    if (mOp.NotEqual(idWWW002.get(),"")) {
      //<< set objWWW002=$get(^WWW002(0,YDATEI,idWWW002,1))
      objWWW002.set(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),idWWW002.get(),1)));
      //<< set intIndex=$$$WWW002IndexKey(objWWW002)
      intIndex.set(include.WWWConst.$$$WWW002IndexKey(m$,objWWW002));
    }
    //<< }
    //<< quit intIndex
    return intIndex.get();
  }

  //<< 
  //<< 
  //<< Find(pstrCheckList,pidNext,pYFKEY)
  public Object Find(Object ... _p) {
    mVar pstrCheckList = m$.newVarRef("pstrCheckList",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidNext = m$.newVarRef("pidNext",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYFKEY = m$.newVarRef("pYFKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine whether this record has already been used, considering the sharing of
    //<< ; IDs (ignoring prefix)
    //<< ;
    //<< ; When allocating a new sequence number it is necessary to check all associated
    //<< ; classes - each potentially its own prefix - to ensure that the number has not
    //<< ; been allocated elsewhere.  pstrCheckList contains all possible cross-checks
    //<< ; that are required.
    //<< ;
    //<< ; Inputs:
    //<< ;   pstrCheckList       Prefix1;Class1~Prefix2;Class2~...
    //<< ;   pidNext             Sequence key generated by NEXT that needs testing
    //<< ;   pYFKEY              Prior keys for record (Counter key may not be the first key)
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-May-2009   GRF     SRBR014965: standardise variables; doco; YM already set.
    //<< ; 04-Jul-2008   GRF     SRBR014965: Doco
    //<< ; 03-Jul-2008   shobby  SRBR014965: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnFound,idClass,objPrefix,loop,strPrefix,strKey
    mVar blnFound = m$.var("blnFound");
    mVar idClass = m$.var("idClass");
    mVar objPrefix = m$.var("objPrefix");
    mVar loop = m$.var("loop");
    mVar strPrefix = m$.var("strPrefix");
    mVar strKey = m$.var("strKey");
    m$.newVar(blnFound,idClass,objPrefix,loop,strPrefix,strKey);
    //<< new intIndex ;SR17817
    mVar intIndex = m$.var("intIndex");
    m$.newVar(intIndex);
    //<< 
    //<< set blnFound = $$$NO
    blnFound.set(include.COMSYS.$$$NO(m$));
    //<< for loop=1:1:$length(pstrCheckList,Y) {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(pstrCheckList.get(),m$.var("Y").get())));loop.set(mOp.Add(loop.get(),1))) {
      //<< quit:blnFound
      if (mOp.Logical(blnFound.get())) {
        break;
      }
      //<< 
      //<< set objPrefix = $piece(pstrCheckList,Y,loop)
      objPrefix.set(m$.Fnc.$piece(pstrCheckList.get(),m$.var("Y").get(),loop.get()));
      //<< set strPrefix = $piece(objPrefix,";",1)
      strPrefix.set(m$.Fnc.$piece(objPrefix.get(),";",1));
      //<< set idClass   = $piece(objPrefix,";",2)
      idClass.set(m$.Fnc.$piece(objPrefix.get(),";",2));
      //<< 
      //<< if pYFKEY="" {
      if (mOp.Equal(pYFKEY.get(),"")) {
        //<< set blnFound = $data(@("^"_idClass_"("""_YM_""","""_strPrefix_pidNext_""")"))
        blnFound.set(m$.Fnc.$data(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",idClass.get()),"(\""),m$.var("YM").get()),"\",\""),strPrefix.get()),pidNext.get()),"\")")))));
      }
      //<< } else {
      else {
        //<< set intIndex=$$Index(idClass)
        intIndex.set(m$.fnc$("Index",idClass.get()));
        //<< if (intIndex'="") {
        if ((mOp.NotEqual(intIndex.get(),""))) {
          //<< ; This will ensure that the counter field is unique even if proceeding primary keys are different.
          //<< set blnFound=$data(@("^"_idClass_"s("""_YM_""","""_intIndex_""","""_$$Index^COMUtils(strPrefix_pidNext)_""")"))
          blnFound.set(m$.Fnc.$data(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",idClass.get()),"s(\""),m$.var("YM").get()),"\",\""),intIndex.get()),"\",\""),m$.fnc$("COMUtils.Index",mOp.Concat(strPrefix.get(),pidNext.get()))),"\")")))));
        }
        //<< } else {
        else {
          //<< set blnFound = $data(@("^"_idClass_"("""_YM_""","""_pYFKEY_""","""_strPrefix_pidNext_""")"))
          blnFound.set(m$.Fnc.$data(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",idClass.get()),"(\""),m$.var("YM").get()),"\",\""),pYFKEY.get()),"\",\""),strPrefix.get()),pidNext.get()),"\")")))));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnFound
    return blnFound.get();
  }

  //<< 
  //<< 
  //<< NEXT
  public void NEXT() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History :
    //<< ; 20-Sep-2013   shobby  HEVA-922: When reset the first number in the new series will be 1 not 0
    //<< ; 20-Feb-2008   GRF     SRBR014880: Peer Review corrections
    //<< ; 19-Feb-2008   GM      SRBR014880: set increment value to zero When "$$MustResetYear() = 1"
    //<< ; 12-Feb-2008   GM      SRBR014880: back increment value to zero when start new year
    //<< ;                           and button "ResetOnChangeOver" is selected
    //<< ; 25-Sep-2007   GRF     SR15602: don't override general setting with location-based
    //<< ;                           update; determine split of prefix and value from RHS
    //<< ;                           when find non-numeric rather than from LHS with
    //<< ;                           first digit; Increment factor 10/100 converted to
    //<< ;                           while statement; avoid single digit variables
    //<< ;                           (A=>idNext, B=>strPrefix, Q=>intIncr, replace C, D
    //<< ;                           and with intLenValue)   (original code moved to
    //<< ;                           oldNEXT with wrapper RunOldNEXT)
    //<< ; 20-Sep-2007   GRF     SRBR014719: Doco
    //<< ; 17-Sep-2007   GRF     SR15601: Replace "YEAR" transformation with "YYYY" and
    //<< ;                           generate 2 digit year from "YEAR"
    //<< ; 04-Jun-2007   GRF     SR15533: Never rollback a new number record
    //<< ; 13-Mar-2007   GRF     Highlight locking
    //<< ; 08-May-2006   Steve S Use $$^WWWFORMNAME
    //<< ; 18-Jan-2006   PO      SR14109: Wait for 10s to get lock - if lock not granted,
    //<< ;                           error out with reason why then terminate process.
    //<< ;                           Included error trap for extra precaution - should
    //<< ;                           not be required.  Immediately remove lock in case
    //<< ;                           called from within a transaction.
    //<< ; 18-Jul-2005   RobertW SR12994: Fix a missing $get around YLOCATION
    //<< ;-------------------------------------------------------------------------------
    //<< set $ztrap = "NEXTError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("NEXTError");
    //<< 
    //<< new blnLocnBased,blnResetYear,char,intIncr,intLenValue,intValue
    mVar blnLocnBased = m$.var("blnLocnBased");
    mVar blnResetYear = m$.var("blnResetYear");
    mVar _char = m$.var("_char");
    mVar intIncr = m$.var("intIncr");
    mVar intLenValue = m$.var("intLenValue");
    mVar intValue = m$.var("intValue");
    m$.newVar(blnLocnBased,blnResetYear,_char,intIncr,intLenValue,intValue);
    //<< new objWWW128,objWWW1280,strDescription,strPrefix
    mVar objWWW128 = m$.var("objWWW128");
    mVar objWWW1280 = m$.var("objWWW1280");
    mVar strDescription = m$.var("strDescription");
    mVar strPrefix = m$.var("strPrefix");
    m$.newVar(objWWW128,objWWW1280,strDescription,strPrefix);
    //<< 
    //<< ; FIXME : <GRF> May have two forms with same class.  If using a numerator they will
    //<< ;               have separate streams of numbers though these could possibly just
    //<< ;               leapfrog over each other.  If both forms are used at the same time
    //<< ;               the locks below will fail allowing them to possibly get the same
    //<< ;               number.  (Small window of opportunity - only open until the class
    //<< ;               record is written at which time the $data test above will stop any
    //<< ;               duplication.)
    //<< 
    //<< 
    //<< ;***************************************
    //<< lock +^WWW128(YM,YFORM):10
    m$.Cmd.LockInc(m$.var("^WWW128",m$.var("YM").get(),m$.var("YFORM").get()),10);
    //<< ;***************************************
    //<< 
    //<< if $test {
    if (mOp.Logical(m$.Fnc.$test())) {
      //<< set objWWW128  = $get(^WWW128(YM,YFORM,1))
      objWWW128.set(m$.Fnc.$get(m$.var("^WWW128",m$.var("YM").get(),m$.var("YFORM").get(),1)));
      //<< if ($get(YLOCATION)'="") && $data(^WWW1280(YM,YFORM,YLOCATION,1)) {
      if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YLOCATION")),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^WWW1280",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YLOCATION").get(),1)))) {
        //<< set objWWW1280 = $get(^WWW1280(YM,YFORM,YLOCATION,1))
        objWWW1280.set(m$.Fnc.$get(m$.var("^WWW1280",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YLOCATION").get(),1)));
        //<< set blnLocnBased = $$$YES
        blnLocnBased.set(include.COMSYS.$$$YES(m$));
      }
      //<< } else {
      else {
        //<< set objWWW1280=""
        objWWW1280.set("");
        //<< set blnLocnBased = $$$NO
        blnLocnBased.set(include.COMSYS.$$$NO(m$));
      }
      //<< }
      //<< 
      //<< ;-----------------------------------
      //<< ;  YZAHL : Increment by (default 1)  ;ZÄHLER
      //<< ;-----------------------------------
      //<< if blnLocnBased {
      if (mOp.Logical(blnLocnBased.get())) {
        //<< if YZAHL=1 {
        if (mOp.Equal(m$.var("YZAHL").get(),1)) {
          //<< set intIncr = +$piece(objWWW1280,Y,2)
          intIncr.set(mOp.Positive(m$.Fnc.$piece(objWWW1280.get(),m$.var("Y").get(),2)));
          //<< if intIncr set YZAHL=intIncr
          if (mOp.Logical(intIncr.get())) {
            mVar YZAHL = m$.var("YZAHL");
            YZAHL.set(intIncr.get());
          }
        }
        //<< }
        //<< 
        //<< set idNext = $piece(objWWW1280,Y,1)
        mVar idNext = m$.var("idNext");
        idNext.set(m$.Fnc.$piece(objWWW1280.get(),m$.var("Y").get(),1));
        //<< if idNext="" {
        if (mOp.Equal(idNext.get(),"")) {
          //<< set idNext=$piece(objWWW128,Y,1)   ; only basing increment locally - can't
          idNext.set(m$.Fnc.$piece(objWWW128.get(),m$.var("Y").get(),1));
          //<< set blnLocnBased = $$$NO           ; tell why this would occur but handles it
          blnLocnBased.set(include.COMSYS.$$$NO(m$));
        }
      }
      //<< }
      //<< } else {
      else {
        //<< if YZAHL=1 {
        if (mOp.Equal(m$.var("YZAHL").get(),1)) {
          //<< set intIncr = +$piece(objWWW128,Y,2)
          intIncr.set(mOp.Positive(m$.Fnc.$piece(objWWW128.get(),m$.var("Y").get(),2)));
          //<< if intIncr set YZAHL = intIncr
          if (mOp.Logical(intIncr.get())) {
            mVar YZAHL = m$.var("YZAHL");
            YZAHL.set(intIncr.get());
          }
        }
        //<< }
        //<< set idNext = $piece(objWWW128,Y,1)
        mVar idNext = m$.var("idNext");
        idNext.set(m$.Fnc.$piece(objWWW128.get(),m$.var("Y").get(),1));
      }
      //<< 
      //<< }
      //<< 
      //<< ;---------------------------------------------------------------------------
      //<< ;  e.g. based on "ABC2:00007"
      //<< ;                      "ABC2:00007"
      //<< ;                      "70000:2CBA" => "70000"
      //<< ;       strPrefix      ":2CBA"      => "ABC2:"
      //<< ;                      "00007"
      //<< ;       intLenValue     5
      //<< ;       +1  intValue   7 => 8             (with ...0 or ...00 rounding)
      //<< ;                      "00008"
      //<< ;       idNext         "ABC2:00008"
      //<< ;---------------------------------------------------------------------------
      //<< 
      //<< set strPrefix = $reverse(idNext)
      strPrefix.set(m$.Fnc.$reverse(m$.var("idNext").get()));
      //<< for {
      for (;true;) {
        //<< quit:'$find("1234567890",$extract(strPrefix))
        if (mOp.Not(m$.Fnc.$find("1234567890",m$.Fnc.$extract(strPrefix.get())))) {
          break;
        }
        //<< quit:strPrefix=""
        if (mOp.Equal(strPrefix.get(),"")) {
          break;
        }
        //<< 
        //<< set strPrefix=$extract(strPrefix,2,999)
        strPrefix.set(m$.Fnc.$extract(strPrefix.get(),2,999));
      }
      //<< }
      //<< set strPrefix = $reverse(strPrefix)
      strPrefix.set(m$.Fnc.$reverse(strPrefix.get()));
      //<< if strPrefix'="" {
      if (mOp.NotEqual(strPrefix.get(),"")) {
        //<< set intValue = $piece(idNext,strPrefix,2)
        intValue.set(m$.Fnc.$piece(m$.var("idNext").get(),strPrefix.get(),2));
      }
      //<< } else {
      else {
        //<< set intValue = idNext
        intValue.set(m$.var("idNext").get());
      }
      //<< }
      //<< set intLenValue = $length(intValue)      ; includes leading zeros
      intLenValue.set(m$.Fnc.$length(intValue.get()));
      //<< set intValue = intValue + YZAHL          ; strips leading zeros when increments
      intValue.set(mOp.Add(intValue.get(),m$.var("YZAHL").get()));
      //<< 
      //<< set blnResetYear =  $$MustResetYear(YFORM,YLOCATION,blnLocnBased)
      blnResetYear.set(m$.fnc$("MustResetYear",m$.var("YFORM").get(),m$.var("YLOCATION").get(),blnLocnBased.get()));
      //<< if blnResetYear set intValue = 1 ; HEVA-922
      if (mOp.Logical(blnResetYear.get())) {
        intValue.set(1);
      }
      //<< 
      //<< ; If trailing zeros are specified in increment
      //<< ;-----------------------------------
      //<< ; FIXME : <GRF> Is it more appropriate to use "intValue#YZAHL'=0"?
      //<< ;         This will ensure rounded to next multiple of say 20 rather than
      //<< ;         rounding to powers of 10 after adding 20.
      //<< ;-----------------------------------
      //<< ; Next 10*x
      //<< ; NOTE: may skip an entry
      //<< ;       e.g. last number = 206, increment => 216, next "0" = 220, doesn't set 210.
      //<< if $extract(YZAHL,$length(YZAHL))="0" {
      if (mOp.Equal(m$.Fnc.$extract(m$.var("YZAHL").get(),m$.Fnc.$length(m$.var("YZAHL").get())),"0")) {
        //<< while intValue#10'=0 {
        while (mOp.NotEqual(mOp.Modulus(intValue.get(),10),0)) {
          //<< set intValue = intValue+1
          intValue.set(mOp.Add(intValue.get(),1));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< ; Next 100*x
      //<< ; NOTE: may skip an entry
      //<< ;       e.g. last number = 206, increment => 306, next "00" = 400, doesn't set 300.
      //<< if $extract(YZAHL,$length(YZAHL)-1,$length(YZAHL))="00" {
      if (mOp.Equal(m$.Fnc.$extract(m$.var("YZAHL").get(),mOp.Subtract(m$.Fnc.$length(m$.var("YZAHL").get()),1),m$.Fnc.$length(m$.var("YZAHL").get())),"00")) {
        //<< while intValue#100'=0 {
        while (mOp.NotEqual(mOp.Modulus(intValue.get(),100),0)) {
          //<< set intValue = intValue+1
          intValue.set(mOp.Add(intValue.get(),1));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< ; Reconstruct identifier
      //<< ;-----------------------------------
      //<< set idNext = strPrefix_$translate($justify(intValue,intLenValue)," ","0")
      mVar idNext = m$.var("idNext");
      idNext.set(mOp.Concat(strPrefix.get(),m$.Fnc.$translate(m$.Fnc.$justify(intValue.get(),intLenValue.get())," ","0")));
      //<< 
      //<< ;+++++++++++++++++++++++++++++++++++   ; Never rollback a new number record
      //<< $$$JournalOff
      include.COMSYS.$$$JournalOff(m$);
      //<< ;+++++++++++++++++++++++++++++++++++
      //<< 
      //<< ;-----------------------------------
      //<< ; Save the change - ONLY at the level the original value came from.
      //<< ;-----------------------------------
      //<< if blnLocnBased {
      if (mOp.Logical(blnLocnBased.get())) {
        //<< set $$$WWW1280LastUsedSequenceNumber(^WWW1280(YM,YFORM,YLOCATION,1)) = idNext
        include.WWWConst.$$$WWW1280LastUsedSequenceNumberSet(m$,m$.var("^WWW1280",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YLOCATION").get(),1),idNext.get());
        //<< if blnResetYear set $$$WWW1280LastResetYear(^WWW1280(YM,YFORM,YLOCATION,1)) = +$zdate($horolog,3)
        if (mOp.Logical(blnResetYear.get())) {
          include.WWWConst.$$$WWW1280LastResetYearSet(m$,m$.var("^WWW1280",m$.var("YM").get(),m$.var("YFORM").get(),m$.var("YLOCATION").get(),1),mOp.Positive(m$.Fnc.$zdate(m$.Fnc.$horolog(),3)));
        }
      }
      //<< } else {
      else {
        //<< set $$$WWW128SequenceNumber(^WWW128(YM,YFORM,1))                     = idNext
        include.WWWConst.$$$WWW128SequenceNumberSet(m$,m$.var("^WWW128",m$.var("YM").get(),m$.var("YFORM").get(),1),idNext.get());
        //<< if blnResetYear set $$$WWW128LastResetYear(^WWW128(YM,YFORM,1))      = +$zdate($horolog,3)
        if (mOp.Logical(blnResetYear.get())) {
          include.WWWConst.$$$WWW128LastResetYearSet(m$,m$.var("^WWW128",m$.var("YM").get(),m$.var("YFORM").get(),1),mOp.Positive(m$.Fnc.$zdate(m$.Fnc.$horolog(),3)));
        }
      }
      //<< }
      //<< ;+++++++++++++++++++++++++++++++++++
      //<< $$$JournalOn
      include.COMSYS.$$$JournalOn(m$);
      //<< ;+++++++++++++++++++++++++++++++++++
      //<< 
      //<< ;***********************************
      //<< lock -^WWW128(YM,YFORM)#"I"            ; SR14109
      m$.Cmd.Unlock(m$.var("^WWW128",m$.var("YM").get(),m$.var("YFORM").get()),"I");
      //<< ;***********************************
      //<< 
      //<< if $find(idNext,"YEAR")     set idNext = $piece(idNext,"YEAR",1)    _$extract($$^WWWYEAR(),3,4)_$piece(idNext,"YEAR",2)
      if (mOp.Logical(m$.Fnc.$find(idNext.get(),"YEAR"))) {
        idNext.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(idNext.get(),"YEAR",1),m$.Fnc.$extract(m$.fnc$("WWWYEAR.main"),3,4)),m$.Fnc.$piece(idNext.get(),"YEAR",2)));
      }
      //<< if $find(idNext,"YYYY")     set idNext = $piece(idNext,"YYYY",1)    _$$^WWWYEAR()              _$piece(idNext,"YYYY",2)
      if (mOp.Logical(m$.Fnc.$find(idNext.get(),"YYYY"))) {
        idNext.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(idNext.get(),"YYYY",1),m$.fnc$("WWWYEAR.main")),m$.Fnc.$piece(idNext.get(),"YYYY",2)));
      }
      //<< if $find(idNext,"USER")     set idNext = $piece(idNext,"USER",1)    _$get(YBED)                _$piece(idNext,"USER",2)
      if (mOp.Logical(m$.Fnc.$find(idNext.get(),"USER"))) {
        idNext.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(idNext.get(),"USER",1),m$.Fnc.$get(m$.var("YBED"))),m$.Fnc.$piece(idNext.get(),"USER",2)));
      }
      //<< if $find(idNext,"LOCATION") set idNext = $piece(idNext,"LOCATION",1)_$get(YLOCATION)           _$piece(idNext,"LOCATION",2)
      if (mOp.Logical(m$.Fnc.$find(idNext.get(),"LOCATION"))) {
        idNext.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(idNext.get(),"LOCATION",1),m$.Fnc.$get(m$.var("YLOCATION"))),m$.Fnc.$piece(idNext.get(),"LOCATION",2)));
      }
      //<< if $find(idNext,"BETRIEB")  set idNext = $piece(idNext,"BETRIEB",1) _$get(YLOCATION)           _$piece(idNext,"BETRIEB",2)
      if (mOp.Logical(m$.Fnc.$find(idNext.get(),"BETRIEB"))) {
        idNext.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(idNext.get(),"BETRIEB",1),m$.Fnc.$get(m$.var("YLOCATION"))),m$.Fnc.$piece(idNext.get(),"BETRIEB",2)));
      }
      //<< if $find(idNext,"COMPANY")  set idNext = $piece(idNext,"COMPANY",1) _$get(YM)                  _$piece(idNext,"COMPANY",2) ; Deprecated
      if (mOp.Logical(m$.Fnc.$find(idNext.get(),"COMPANY"))) {
        idNext.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(idNext.get(),"COMPANY",1),m$.Fnc.$get(m$.var("YM"))),m$.Fnc.$piece(idNext.get(),"COMPANY",2)));
      }
      //<< if $find(idNext,"MANDANT")  set idNext = $piece(idNext,"MANDANT",1) _$get(YM)                  _$piece(idNext,"MANDANT",2) ; Deprecated
      if (mOp.Logical(m$.Fnc.$find(idNext.get(),"MANDANT"))) {
        idNext.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(idNext.get(),"MANDANT",1),m$.Fnc.$get(m$.var("YM"))),m$.Fnc.$piece(idNext.get(),"MANDANT",2)));
      }
    }
    //<< 
    //<< } else {
    else {
      //<< set strDescription = $$^WWWFORMNAME(YFORM)
      strDescription.set(m$.fnc$("WWWFORMNAME.main",m$.var("YFORM").get()));
      //<< set:strDescription="" strDescription = YFORM
      if (mOp.Equal(strDescription.get(),"")) {
        strDescription.set(m$.var("YFORM").get());
      }
      //<< 
      //<< ;-----------------------------------
      //<< ; Next number for ´%1´ can not be determined, contact your systems administrator.
      //<< ;-----------------------------------
      //<< if $get(%("%KEY","HYPEREVENT")) {
      if (mOp.Logical(m$.Fnc.$get(m$.var("%","%KEY","HYPEREVENT")))) {
        //<< $$$Alert($listbuild("WWW00001",strDescription))
        include.COMSYS.$$$Alert(m$,m$.Fnc.$listbuild("WWW00001",strDescription.get()));
      }
      //<< } else {
      else {
        //<< $$$AlertInScript($listbuild("WWW00001",strDescription))
        include.COMSYS.$$$AlertInScript(m$,m$.Fnc.$listbuild("WWW00001",strDescription.get()));
      }
    }
    //<< }
    //<< halt
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< NEXTError ; Internal Tag
  public void NEXTError() {
    //<< set $ztrap = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< ;***************************************
    //<< lock -^WWW128(YM,YFORM)
    m$.Cmd.Unlock(m$.var("^WWW128",m$.var("YM").get(),m$.var("YFORM").get()));
    //<< ;***************************************
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< Reset(pidForm,pidReset,pidLoc="")
  public Object Reset(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidReset = m$.newVarRef("pidReset",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidLoc = m$.newVarRef("pidLoc",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Reset the sequence number.
    //<< ;
    //<< ; Note: Currently only works if numerator form is same as class.
    //<< ;
    //<< ; Params:   pidForm     - numerator id (WWW128)
    //<< ;           pidLoc      - (optional) 2nd key to WWW1280
    //<< ;           pidReset    - value to re-use.
    //<< ;                         ie - the numerator should be set to a value before this one
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jan-2007   JW      SR15347: Created. Moved from INDRPAUFKILL.
    //<< ;-------------------------------------------------------------------------------
    //<< new idLast,idNewLast,blnLoc
    mVar idLast = m$.var("idLast");
    mVar idNewLast = m$.var("idNewLast");
    mVar blnLoc = m$.var("blnLoc");
    m$.newVar(idLast,idNewLast,blnLoc);
    //<< 
    //<< set idNewLast=""
    idNewLast.set("");
    //<< 
    //<< set $ztrap = "NEXTError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("NEXTError");
    //<< ;***************************************
    //<< LOCK +^WWW128(YM,pidForm):10
    m$.Cmd.LockInc(m$.var("^WWW128",m$.var("YM").get(),pidForm.get()),10);
    //<< ;***************************************
    //<< 
    //<< // If can't get the lock, don't worry about re-setting, not that important.
    //<< if $test {
    if (mOp.Logical(m$.Fnc.$test())) {
      //<< set blnLoc = ((pidLoc'="") && $data(^WWW1280(YM,pidForm,pidLoc)))  ; Location Dependant Numerator
      blnLoc.set(((mOp.NotEqual(pidLoc.get(),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^WWW1280",m$.var("YM").get(),pidForm.get(),pidLoc.get())))));
      //<< 
      //<< if blnLoc {
      if (mOp.Logical(blnLoc.get())) {
        //<< set idLast = $$$WWW1280LastUsedSequenceNumber($get(^WWW1280(YM,pidForm,pidLoc,1)))
        idLast.set(include.WWWConst.$$$WWW1280LastUsedSequenceNumber(m$,m$.Fnc.$get(m$.var("^WWW1280",m$.var("YM").get(),pidForm.get(),pidLoc.get(),1))));
      }
      //<< } else {
      else {
        //<< set idLast = $$$WWW128SequenceNumber($get(^WWW128(YM,pidForm,1)))
        idLast.set(include.WWWConst.$$$WWW128SequenceNumber(m$,m$.Fnc.$get(m$.var("^WWW128",m$.var("YM").get(),pidForm.get(),1))));
      }
      //<< }
      //<< 
      //<< // Note - the following block was not changed from the original. It probably should be
      //<< //        optimised using the same sort of functionality as WWWNEXT or FINAPChequeBook.
      //<< //        I'm sure the execution isn't great.
      //<< 
      //<< if $$$IsPosInt(idLast) && (idLast'<(pidReset-1)) {      ; Numeric
      if (mOp.Logical(include.COMSYSNum.$$$IsPosInt(m$,idLast)) && (mOp.NotLess(idLast.get(),(mOp.Subtract(pidReset.get(),1))))) {
        //<< set idNewLast = pidReset-1
        idNewLast.set(mOp.Subtract(pidReset.get(),1));
      }
      //<< 
      //<< } else {
      else {
        //<< xecute "set idLast = $order("_$$$GlobalString(pidForm,idLast)_",-1)"
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat("set idLast = $order(",include.COMSYSWWW.$$$GlobalString(m$,pidForm,idLast)),",-1)"));
        //<< if (idLast'="") && (pidReset]]idLast) {             ; Alphanumeric
        if ((mOp.NotEqual(idLast.get(),"")) && mOp.Logical((mOp.SortsAfter(pidReset.get(),idLast.get())))) {
          //<< set idNewLast = idLast
          idNewLast.set(idLast.get());
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if idNewLast'="" {      // Are we re-setting ?
      if (mOp.NotEqual(idNewLast.get(),"")) {
        //<< if blnLoc {
        if (mOp.Logical(blnLoc.get())) {
          //<< set $$$WWW1280LastUsedSequenceNumber(^WWW1280(YM,pidForm,pidLoc,1)) = idNewLast
          include.WWWConst.$$$WWW1280LastUsedSequenceNumberSet(m$,m$.var("^WWW1280",m$.var("YM").get(),pidForm.get(),pidLoc.get(),1),idNewLast.get());
        }
        //<< 
        //<< } else {
        else {
          //<< set $$$WWW128SequenceNumber(^WWW128(YM,pidForm,1)) = idNewLast
          include.WWWConst.$$$WWW128SequenceNumberSet(m$,m$.var("^WWW128",m$.var("YM").get(),pidForm.get(),1),idNewLast.get());
        }
      }
      //<< }
      //<< }
      //<< 
      //<< ;***********************************
      //<< LOCK -^WWW128(YM,pidForm)#"I"
      m$.Cmd.Unlock(m$.var("^WWW128",m$.var("YM").get(),pidForm.get()),"I");
    }
    //<< ;***********************************
    //<< }
    //<< quit idNewLast
    return idNewLast.get();
  }

  //<< 
  //<< 
  //<< MustResetYear(pidForm,pidLocn,pblnLocnBased) PRIVATE
  public Object MustResetYear(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnLocnBased = m$.newVarRef("pblnLocnBased",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check data to reset the sequence number.
    //<< ;
    //<< ; Params:
    //<< ;   pidForm         - form name
    //<< ;   pidLocn         - location
    //<< ;   pblnLocnBased   - is numbering based on location
    //<< ;
    //<< ; Returns:
    //<< ;   boolean
    //<< ; History:
    //<< ; 20-Feb-2008   GRF     SRBR014880: Peer Review corrections
    //<< ; 13-Feb-2008   GM      SRBR014880: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnReset,blnResult,intLastReset
    mVar blnReset = m$.var("blnReset");
    mVar blnResult = m$.var("blnResult");
    mVar intLastReset = m$.var("intLastReset");
    m$.newVar(blnReset,blnResult,intLastReset);
    //<< 
    //<< if pblnLocnBased {
    if (mOp.Logical(pblnLocnBased.get())) {
      //<< set blnReset = $$$WWW1280ResetOnChangeOver($get(^WWW1280(YM,pidForm,pidLocn,1)))
      blnReset.set(include.WWWConst.$$$WWW1280ResetOnChangeOver(m$,m$.Fnc.$get(m$.var("^WWW1280",m$.var("YM").get(),pidForm.get(),pidLocn.get(),1))));
      //<< set intLastReset = $$$WWW1280LastResetYear($get(^WWW1280(YM,pidForm,pidLocn,1)))
      intLastReset.set(include.WWWConst.$$$WWW1280LastResetYear(m$,m$.Fnc.$get(m$.var("^WWW1280",m$.var("YM").get(),pidForm.get(),pidLocn.get(),1))));
    }
    //<< } else {
    else {
      //<< set blnReset = $$$WWW128ResetOnChangeOver($get(^WWW128(YM,pidForm,1)))
      blnReset.set(include.WWWConst.$$$WWW128ResetOnChangeOver(m$,m$.Fnc.$get(m$.var("^WWW128",m$.var("YM").get(),pidForm.get(),1))));
      //<< set intLastReset = $$$WWW128LastResetYear($get(^WWW128(YM,pidForm,1)))
      intLastReset.set(include.WWWConst.$$$WWW128LastResetYear(m$,m$.Fnc.$get(m$.var("^WWW128",m$.var("YM").get(),pidForm.get(),1))));
    }
    //<< }
    //<< 
    //<< if blnReset="" {
    if (mOp.Equal(blnReset.get(),"")) {
      //<< set blnResult = $$$NO
      blnResult.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif intLastReset=+$zdate($horolog,3) {
    else if (mOp.Equal(intLastReset.get(),mOp.Positive(m$.Fnc.$zdate(m$.Fnc.$horolog(),3)))) {
      //<< set blnResult = $$$NO
      blnResult.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } else {
    else {
      //<< set blnResult = $$$YES
      blnResult.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< quit blnResult
    return blnResult.get();
  }

//<< 
//<< 
//<< 
//<< 
//<< 
}
