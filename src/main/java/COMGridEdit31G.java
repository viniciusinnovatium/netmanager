//*****************************************************************************
//** TASC - ALPHALINC - MAC COMGridEdit31G
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:03
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include COMConst
import include.COMConst;
import include.COMSYS;
//<< #include WWWConst
import include.WWWConst;
//<< #include COMGridEdit31
import include.COMGridEdit31;

//<< COMGridEdit31G
public class COMGridEdit31G extends mClass {

  //<< 
  //<< ; Macro override : based on ^CacheTemp rather than YFORM
  //<< #def1arg WWWDATEN(%args)    ^WWWDATEN(YM,+$horolog,YUSER,$get(^CacheTemp(YUSER,"Grid","Name")," "),"V",%args)
  public static Object $$$WWWDATEN(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")," "),"V",p$args.get()).get());
  }

  public static mVar $$$WWWDATENVar(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")," "),"V",p$args.get()));
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

  public void main() {
    _COMGridEdit31G();
  }

  public void _COMGridEdit31G() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^CGEG("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Standardised variables :
  //<< ; (p)idGridRow  contains the 2x01    format for grid rows - as used for REFERENCEKEY
  //<< ;    idLastKey  contains the 2.01    format for grid rows - this is the last of the REFERNENCEROW entries
  //<< ;    idCell     contains the Y2x01_5 format for grid row and column
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< BodyName(YFORM)
  public Object BodyName(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new strName
    mVar strName = m$.var("strName");
    m$.newVar(strName);
    //<< 
    //<< if $get(YFORM)=$get(^CacheTemp(YUSER,"Grid","Name")) {
    if (mOp.Equal(m$.Fnc.$get(YFORM),m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")))) {
      //<< set strName = "gridbody"
      strName.set("gridbody");
    }
    //<< } else {
    else {
      //<< set strName = "ELBody"
      strName.set("ELBody");
    }
    //<< }
    //<< quit strName
    return strName.get();
  }

  //<< 
  //<< 
  //<< Header(pstrPiece,pstrValue)
  public Object Header(Object ... _p) {
    mVar pstrPiece = m$.newVarRef("pstrPiece",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Updates items on the header screen.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-May-2008   GRF     Cleanup old change history (2006 and earlier)
    //<< ; 07-Dec-2004   Shobby  SR10468: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idPiece,strContainer,strType
    mVar idPiece = m$.var("idPiece");
    mVar strContainer = m$.var("strContainer");
    mVar strType = m$.var("strType");
    m$.newVar(idPiece,strContainer,strType);
    //<< 
    //<< set strContainer = $get(^CacheTemp(YUSER,"Grid","Container"))
    strContainer.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")));
    //<< if strContainer'="" {
    if (mOp.NotEqual(strContainer.get(),"")) {
      //<< write "document.getElementById('Y"_strContainer_pstrPiece_"').value='"_pstrValue_"';"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('Y",strContainer.get()),pstrPiece.get()),"').value='"),pstrValue.get()),"';"));
      //<< set strType = $extract(pstrPiece,1,1)              ; P, D, M ?
      strType.set(m$.Fnc.$extract(pstrPiece.get(),1,1));
      //<< set idPiece = $piece(pstrPiece,strType,2)          ; field number ?
      idPiece.set(m$.Fnc.$piece(pstrPiece.get(),strType.get(),2));
      //<< 
      //<< set $piece(^WWWDATEN(YM,+$horolog,YUSER,strContainer,strType,1),Y,idPiece) = pstrValue
      m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),strContainer.get(),strType.get(),1),m$.var("Y").get(),idPiece.get()).set(pstrValue.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetGridContents(&parrGrid,pYFORM="",pblnIncludeKilled=$$$NO,pstrKey="")
  public Object GetGridContents(Object ... _p) {
    mVar parrGrid = m$.newVarRef("parrGrid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnIncludeKilled = m$.newVarRef("pblnIncludeKilled",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; AKA: $$$GRIDGetContents(%args)
    //<< ;      [GetGridContents^COMGridEdit31Interface - deprecated link - use macro]
    //<< ;
    //<< ; Called By:
    //<< ;      UpdateContainer^COMGridEdit31G
    //<< ;      CallBacks^COMGridEdit31S
    //<< ;      OnBeforeSave^FINAPPaymentLine
    //<< ;      PopulateFields^FINAPPaymentLine
    //<< ;      OnBlurPost^FINInvGroupPost
    //<< ;      LoadGrid^INADJ
    //<< ;      UpdateContainer^INWEINVELINE
    //<< ;      GetLineDistribution^FINAPInvDiscount
    //<< ;      InvoiceTotals^FINAPVoucher2
    //<< ;      QuantityBreaksValid^INDPPLineDispRule, NoOverlappingMinQuantities^INDPPLineDispRule
    //<< ;      GetQtyEntered^INItemStoreExists
    //<< ;      LoadLinesByReq^INMOV, LoadLinesByIss^INMOV, IssueRevLine^INMOV, OnGridExists^INMOV
    //<< ;      GetQtyEntered^INReceiptLine
    //<< ;      GetQtyEntered^INRECLine
    //<< ;      CacheLinkExists^INRECSearch
    //<< ;      GetQtyEntered^INRECSummary
    //<< ;      EnsureTransfersCanBeReceived^INRECTFR
    //<< ;      HandlePartial^INReqToSupOrderLine
    //<< ;      OnBeforeSave^WWW120
    //<< ;      ValidateLines^WWW120DynTable
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 01-Feb-2012   shobby  SR17948: if pYFORM'="" then also need pstrKey'="" to get
    //<< ;                           the key from WWWDATEN
    //<< ; 09-Nov-2011   GRF     SR17948: subscript error from undefined Grid Name entry     *** REVERTED ***
    //<< ; 30-Jun-2010   shobby  SR17779: New parameter pstrKey to be used when WWWDATEN
    //<< ;                           has not yet been prepared such as when determing the
    //<< ;                           status of buttons.
    //<< ; 08-Apr-2010   GRF     SR17177: pobjGrid should be parrGrid
    //<< ; 15-Jul-2009   GRF     SR16669: clarify idGridRow use
    //<< ; 21-Oct-2008   FIS     BR014981: I think this is the wrong solution for the problem
    //<< ;                           to save a value with quotes with an execute command.
    //<< ;                           I changed to how I think it should work.
    //<< ; 23-Sep-2008   shobby  BR014981: If data returned from @query contains double
    //<< ;                           quotes then the line following will crash.  (Change
    //<< ;                           made on site at SES)
    //<< ; 03-Feb-2006   RPW     SR14093: Use a variable for $h instead of recalculating it
    //<< ; 18-Oct-2005   PO      Newed query
    //<< ; 30-Sep-2005   JW      SR11573: Big speed up. Remove unnecessary keybuilds. Use macros.
    //<< ; 05-Apr-2005   shobby  Fixed removing of Killed records.
    //<< ; 04-Apr-2005   shobby  SR11983: Reworked to include save records that aren't yet in grid
    //<< ; 24-Mar-2005   shobby  Flag to include Killed records, useful to find the next
    //<< ;                           Available ID when creating a new record.
    //<< ; 24-Mar-2005   shobby  Grid may contain multiple form structures if not using
    //<< ;                           the default then pass in the Form Name.
    //<< ;-------------------------------------------------------------------------------
    //<< new strClassName,idGridRow,strYKEY,strYFELD,strCommand,YFORM,YDATEI,strKey
    mVar strClassName = m$.var("strClassName");
    mVar idGridRow = m$.var("idGridRow");
    mVar strYKEY = m$.var("strYKEY");
    mVar strYFELD = m$.var("strYFELD");
    mVar strCommand = m$.var("strCommand");
    mVar YFORM = m$.var("YFORM");
    mVar YDATEI = m$.var("YDATEI");
    mVar strKey = m$.var("strKey");
    m$.newVar(strClassName,idGridRow,strYKEY,strYFELD,strCommand,YFORM,YDATEI,strKey);
    //<< new blnMultiple,subscriptParent,subscriptChild,idParent,query,dteHorolog,strQuery
    mVar blnMultiple = m$.var("blnMultiple");
    mVar subscriptParent = m$.var("subscriptParent");
    mVar subscriptChild = m$.var("subscriptChild");
    mVar idParent = m$.var("idParent");
    mVar query = m$.var("query");
    mVar dteHorolog = m$.var("dteHorolog");
    mVar strQuery = m$.var("strQuery");
    m$.newVar(blnMultiple,subscriptParent,subscriptChild,idParent,query,dteHorolog,strQuery);
    //<< 
    //<< kill parrGrid
    parrGrid.kill();
    //<< 
    //<< set dteHorolog = +$horolog
    dteHorolog.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< if ($get(^CacheTemp(YUSER,"Grid","Name"))'="") || ((pYFORM'="")&&(pstrKey'="")) { ;SR17948
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")),"")) || mOp.Logical(((mOp.NotEqual(pYFORM.get(),"")) && (mOp.NotEqual(pstrKey.get(),""))))) {
      //<< set blnMultiple = (pYFORM'="")
      blnMultiple.set((mOp.NotEqual(pYFORM.get(),"")));
      //<< 
      //<< if blnMultiple {
      if (mOp.Logical(blnMultiple.get())) {
        //<< set YFORM = pYFORM
        YFORM.set(pYFORM.get());
      }
      //<< } else {
      else {
        //<< set YFORM = $get(^CacheTemp(YUSER,"Grid","Name"))
        YFORM.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
      }
      //<< }
      //<< 
      //<< set YDATEI = $$$GRIDClass(YFORM)
      YDATEI.set(include.COMGridEdit31.$$$GRIDClass(m$,YFORM));
      //<< if blnMultiple {
      if (mOp.Logical(blnMultiple.get())) {
        //<< ;SR17779 vvvvv
        //<< if pstrKey'="" {
        if (mOp.NotEqual(pstrKey.get(),"")) {
          //<< set strKey=pstrKey
          strKey.set(pstrKey.get());
        }
        //<< } else {
        else {
          //<< set strKey = $get(^WWWDATEN(YM,dteHorolog,YUSER,$get(^CacheTemp(YUSER,"Grid","Name")),"V","REFERENCEKEY")) ; Keys for header class
          strKey.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteHorolog.get(),m$.var("YUSER").get(),m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")),"V","REFERENCEKEY")));
        }
        //<< }
        //<< ;SR17779 set strKey = $get(^WWWDATEN(YM,dteHorolog,YUSER,$get(^CacheTemp(YUSER,"Grid","Container")),"P","1")) ; Keys for header class
        //<< ;SR17779 ^^^^^^^
        //<< set subscriptParent = $length(strKey,",")+1
        subscriptParent.set(mOp.Add(m$.Fnc.$length(strKey.get(),","),1));
        //<< set subscriptChild  = subscriptParent+1
        subscriptChild.set(mOp.Add(subscriptParent.get(),1));
        //<< set idParent        = $piece(strKey,",",subscriptParent-1)
        idParent.set(m$.Fnc.$piece(strKey.get(),",",mOp.Subtract(subscriptParent.get(),1)));
        //<< set strKey          = $$^WWWKEYBUILD($$$WWWYM(YDATEI)_","_strKey)
        strKey.set(m$.fnc$("WWWKEYBUILD.main",mOp.Concat(mOp.Concat(include.COMSYSWWW.$$$WWWYM(m$,YDATEI),","),strKey.get())));
        //<< 
        //<< set query = "^"_YDATEI_"("_strKey_")"
        query.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"("),strKey.get()),")"));
        //<< for {
        for (;true;) {
          //<< set query = $query(@query)
          query.set(m$.Fnc.$query(m$.indirectVar(query.get())));
          //<< quit:query=""
          if (mOp.Equal(query.get(),"")) {
            break;
          }
          //<< quit:$qsubscript(query,subscriptParent)'=idParent
          if (mOp.NotEqual(m$.Fnc.$qsubscript(query,subscriptParent.get()),idParent.get())) {
            break;
          }
          //<< 
          //<< set strQuery = $$Replace^COMUtilStr(@query,"""","""""")
          strQuery.set(m$.fnc$("COMUtilStr.Replace",m$.indirectVar(query.get()).get(),"\"","\"\""));
          //<< xecute "set parrGrid("_$piece(query,",",2,subscriptChild)_")="""_strQuery_""""
          m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("set parrGrid(",m$.Fnc.$piece(query.get(),",",2,subscriptChild.get())),")=\""),strQuery.get()),"\""));
        }
      }
      //<< }
      //<< /*Note: Why is this required ?
      //<< set parrGrid = ^Global(0,"abc",1)       -> fails
      //<< set parrGrid = "^Global(0,"abc",1)"     -> fails
      //<< set parrGrid = "^Global(0,""abc"",1)"   -> OK
      //<< -> guessing this is why all quotes gets converted into double quotes:
      //<< xecute 'set parrGrid(...) = "^Global(0,""abc"",1)" '
      //<< But:
      //<< set parrGrid = strQuery                     -> is OK, too !
      //<< -> xecute 'set parrGrid(...) = strQuery' -> should do same thing !
      //<< 
      //<< Conclusion:
      //<< the right command should be:
      //<< xecute "set parrGrid("_$piece(query,",",2,subscriptChild)_") = strQuery"
      //<< 
      //<< FIXME: Check conclusion is right.
      //<< */
      //<< }
      //<< 
      //<< if (pstrKey="") || ($get(^WWWDATEN(YM,dteHorolog,YUSER,YFORM,"V","REFERENCEKEY"))=pstrKey) {
      if ((mOp.Equal(pstrKey.get(),"")) || (mOp.Equal(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteHorolog.get(),m$.var("YUSER").get(),YFORM.get(),"V","REFERENCEKEY")),pstrKey.get()))) {
        //<< ; ...,"REFERENCEKEY","2x01",1) = "Pref0123",2.01
        //<< ; generates parrGrid("Pref0123",2.01) = """Pref0123"",2.01"
        //<< set idGridRow = ""
        idGridRow.set("");
        //<< for {
        for (;true;) {
          //<< set idGridRow = $order(^WWWDATEN(YM,dteHorolog,YUSER,YFORM,"V","REFERENCEKEY",idGridRow))
          idGridRow.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),dteHorolog.get(),m$.var("YUSER").get(),YFORM.get(),"V","REFERENCEKEY",idGridRow.get())));
          //<< quit:idGridRow=""
          if (mOp.Equal(idGridRow.get(),"")) {
            break;
          }
          //<< 
          //<< set strYKEY = $get(^WWWDATEN(YM,dteHorolog,YUSER,YFORM,"V","REFERENCEKEY",idGridRow,1))
          strYKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteHorolog.get(),m$.var("YUSER").get(),YFORM.get(),"V","REFERENCEKEY",idGridRow.get(),1)));
          //<< 
          //<< if pblnIncludeKilled || '$$$KilledRecord(idGridRow,YFORM) {
          if (mOp.Logical(pblnIncludeKilled.get()) || mOp.Not(include.COMGridEdit31.$$$KilledRecord(m$,idGridRow,YFORM))) {
            //<< set strYFELD = $$GetYFELD(YFORM,idGridRow)
            strYFELD.set(m$.fnc$("GetYFELD",YFORM.get(),idGridRow.get()));
            //<< set strYFELD = $translate(strYFELD,"""")
            strYFELD.set(m$.Fnc.$translate(strYFELD.get(),"\""));
            //<< xecute "set parrGrid("_strYKEY_")="""_strYFELD_""""
            m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("set parrGrid(",strYKEY.get()),")=\""),strYFELD.get()),"\""));
          }
          //<< 
          //<< } elseif 'pblnIncludeKilled && blnMultiple {
          else if (mOp.Not(pblnIncludeKilled.get()) && mOp.Logical(blnMultiple.get())) {
            //<< xecute "kill parrGrid("_strYKEY_")"
            m$.Cmd.Xecute(mOp.Concat(mOp.Concat("kill parrGrid(",strYKEY.get()),")"));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetGridContents(&parrGrid,pblnUpdateScreen=$$$YES,YFORM="",pblnAllLines=$$$NO,pblnUpdateStyle=$$$YES)
  public Object SetGridContents(Object ... _p) {
    mVar parrGrid = m$.newVarRef("parrGrid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnUpdateScreen = m$.newVarRef("pblnUpdateScreen",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnAllLines = m$.newVarRef("pblnAllLines",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    mVar pblnUpdateStyle = m$.newVarRef("pblnUpdateStyle",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks the entire grid for changes and updates screen accordingly.
    //<< ;
    //<< ; AKA: $$$GRIDSetContents(%args)
    //<< ;      [SetGridContents^COMGridEdit31Interface - deprecated link - use macro]
    //<< ;
    //<< ; Called By:
    //<< ;     OnBlur^FINAPInvLineEvents2, HandlePartial^INReqToSupOrderLine (from OnBlur)
    //<< ;     [UpdateContainer^COMGridEdit31G - commented]
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Apr-2010   GRF     SR17177: pobjGrid should be parrGrid (with &)
    //<< ; 15-Jul-2009   GRF     SR16669: clarify idGridRow use
    //<< ; 29-May-2007   RPW     SR15513: Broke out the code to actually draw the rows.
    //<< ; 17-Aug-2005   PO      SR12965: Allow all lines in grid to be updated using
    //<< ;                           added references
    //<< ; 03-Feb-2005   shobby  Flag for updating screen (may want to update data only
    //<< ;                           such as when called from Update^FINAPInv)
    //<< ; 02-Feb-2005   shobby  Code Check.
    //<< ; 01-Feb-2005   Shobby  SR10061: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idGridRow,strClassName,strRefList,strYFELDNew,strYFELDOld,strYKEY
    mVar idGridRow = m$.var("idGridRow");
    mVar strClassName = m$.var("strClassName");
    mVar strRefList = m$.var("strRefList");
    mVar strYFELDNew = m$.var("strYFELDNew");
    mVar strYFELDOld = m$.var("strYFELDOld");
    mVar strYKEY = m$.var("strYKEY");
    m$.newVar(idGridRow,strClassName,strRefList,strYFELDNew,strYFELDOld,strYKEY);
    //<< 
    //<< if $get(^CacheTemp(YUSER,"Grid","Name"))'="" {
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")),"")) {
      //<< if YFORM=""     set YFORM      = ^CacheTemp(YUSER,"Grid","Name")
      if (mOp.Equal(YFORM.get(),"")) {
        YFORM.set(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name").get());
      }
      //<< if pblnAllLines set strRefList = $get($$$WWWDATEN("REFERENCELIST"))    ; Macro override : based on ^CacheTemp rather than YFORM
      if (mOp.Logical(pblnAllLines.get())) {
        strRefList.set(m$.Fnc.$get($$$WWWDATENVar(m$,"REFERENCELIST")));
      }
      //<< 
      //<< set idGridRow = ""
      idGridRow.set("");
      //<< for {
      for (;true;) {
        //<< set idGridRow = $order(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","REFERENCEKEY",idGridRow))
        idGridRow.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V","REFERENCEKEY",idGridRow.get())));
        //<< quit:idGridRow=""
        if (mOp.Equal(idGridRow.get(),"")) {
          break;
        }
        //<< 
        //<< if '$$$KilledRecord(idGridRow,YFORM) {
        if (mOp.Not(include.COMGridEdit31.$$$KilledRecord(m$,idGridRow,YFORM))) {
          //<< do SetGridLineContents(pblnUpdateScreen,.parrGrid,idGridRow,pblnAllLines,$get(strRefList),pblnUpdateStyle)
          m$.Cmd.Do("SetGridLineContents",pblnUpdateScreen.get(),parrGrid,idGridRow.get(),pblnAllLines.get(),m$.Fnc.$get(strRefList),pblnUpdateStyle.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetGridLineContents(pblnUpdateScreen,&parrGrid,pidGridRow,pblnAllLines=$$$NO,pstrRefList="",pblnUpdateStyle=$$$YES)
  public Object SetGridLineContents(Object ... _p) {
    mVar pblnUpdateScreen = m$.newVarRef("pblnUpdateScreen",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar parrGrid = m$.newVarRef("parrGrid",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidGridRow = m$.newVarRef("pidGridRow",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnAllLines = m$.newVarRef("pblnAllLines",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    mVar pstrRefList = m$.newVarRef("pstrRefList",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pblnUpdateStyle = m$.newVarRef("pblnUpdateStyle",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; This sets the contents of the grid on the screen, broken out of SetGridContents above.
    //<< ;
    //<< ; Called By: SetGridContents^COMGridEdit31G     [ IncreaseQuantity^INReqCommon - commented ]
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 17-Sep-2013   shobby  HEVA-1113: Define YKEY for use later by OnBeforeFormat
    //<< ; 08-Apr-2010   GRF     SR17177: pobjGrid should be parrGrid
    //<< ; 15-Jul-2009   GRF     SR16669: clarify pidGridRow use
    //<< ; 28-May-2007   RPW     SR15513: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strYKEY,strYFELDNew,strYFELDOld,YKEY ;HEVA-1113A
    mVar strYKEY = m$.var("strYKEY");
    mVar strYFELDNew = m$.var("strYFELDNew");
    mVar strYFELDOld = m$.var("strYFELDOld");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(strYKEY,strYFELDNew,strYFELDOld,YKEY);
    //<< 
    //<< ; strYKEY : HeaderKeyList,idDataLine
    //<< set strYKEY     = $get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","REFERENCEKEY",pidGridRow,1))
    strYKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","REFERENCEKEY",pidGridRow.get(),1)));
    //<< set YKEY= $translate(strYKEY,"""","") ;HEVA-1113A
    YKEY.set(m$.Fnc.$translate(strYKEY.get(),"\"",""));
    //<< set strYFELDOld = $translate($$GetYFELDEX(YFORM,strYKEY),"""")
    strYFELDOld.set(m$.Fnc.$translate(m$.fnc$("GetYFELDEX",m$.var("YFORM").get(),strYKEY.get()),"\""));
    //<< set strYFELDNew = ""
    strYFELDNew.set("");
    //<< xecute "set strYFELDNew=parrGrid("_strYKEY_")"
    m$.Cmd.Xecute(mOp.Concat(mOp.Concat("set strYFELDNew=parrGrid(",strYKEY.get()),")"));
    //<< 
    //<< if pblnAllLines set $$$WWWDATEN("REFERENCELIST") = pstrRefList    ; Macro override : based on ^CacheTemp rather than YFORM
    if (mOp.Logical(pblnAllLines.get())) {
      $$$WWWDATENVar(m$,"REFERENCELIST").set(pstrRefList.get());
    }
    //<< 
    //<< do ScreenUpdate^COMGridEdit31S("Y"_pidGridRow_"_0",strYFELDNew,strYFELDOld,,pblnUpdateScreen,pblnUpdateStyle)
    m$.Cmd.Do("COMGridEdit31S.ScreenUpdate",mOp.Concat(mOp.Concat("Y",pidGridRow.get()),"_0"),strYFELDNew.get(),strYFELDOld.get(),null,pblnUpdateScreen.get(),pblnUpdateStyle.get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetYKEY(pidGridRow,YFORM="")
  public Object GetYKEY(Object ... _p) {
    mVar pidGridRow = m$.newVarRef("pidGridRow",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create a YKEY, needed in these methods and calls to external routines.
    //<< ; Returns the full YKEY if it can be found otherwise a partial YKEY with
    //<< ; two part YKEY's.
    //<< ;
    //<< ; TODO - Might need to have another look at this when YKEY has more than two parts.
    //<< ;
    //<< ; Compare with ReferenceKey^COMGridEdit31Interface
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2009   GRF     SR16669: clarify pidGridRow use
    //<< ; 06-Dec-2004   shobby  Moved from COMGridEdit31
    //<< ; 24-Nov-2004   Shobby  Created (SR10468)
    //<< ;-------------------------------------------------------------------------------
    //<< new strYKEY
    mVar strYKEY = m$.var("strYKEY");
    m$.newVar(strYKEY);
    //<< 
    //<< set strYKEY=""
    strYKEY.set("");
    //<< if YFORM="" set YFORM = $get(^CacheTemp(YUSER,"Grid","Name"))
    if (mOp.Equal(YFORM.get(),"")) {
      YFORM.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    }
    //<< 
    //<< if $get(pidGridRow)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidGridRow),"")) {
      //<< set strYKEY = $get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","REFERENCEKEY",pidGridRow,1))
      strYKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V","REFERENCEKEY",pidGridRow.get(),1)));
    }
    //<< }
    //<< if strYKEY="" {  ; Container Key without line no      FIXME : Always from ...("Grid","Name") regardless of parameter passed in ?
    if (mOp.Equal(strYKEY.get(),"")) {
      //<< set strYKEY = $get($$$WWWDATEN("REFERENCEKEY"))    ; Macro override : based on ^CacheTemp rather than YFORM
      strYKEY.set(m$.Fnc.$get($$$WWWDATENVar(m$,"REFERENCEKEY")));
    }
    //<< }
    //<< 
    //<< quit strYKEY
    return strYKEY.get();
  }

  //<< 
  //<< 
  //<< GetYFELDContainer()     ;  ********************  Not completed  ********************
  public Object GetYFELDContainer(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; use $$$GRIDYFELDContainer rather than calling directly
    //<< ;
    //<< ; History:
    //<< ; 14-Mar-2005   JW      Used new function GetYFELD
    //<< ;-------------------------------------------------------------------------------
    //<< new strContainer
    mVar strContainer = m$.var("strContainer");
    m$.newVar(strContainer);
    //<< 
    //<< set strContainer = $get(^CacheTemp(YUSER,"Grid","Container"))
    strContainer.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")));
    //<< ; TODO : if strContainer is null will base on current YFORM - is this valid?
    //<< quit $$GetFormData^COMUtilForm(strContainer)
    return m$.fnc$("COMUtilForm.GetFormData",strContainer.get());
  }

  //<< 
  //<< 
  //<< GetYMFELDContainer(pidType=1)
  public Object GetYMFELDContainer(Object ... _p) {
    mVar pidType = m$.newVarRef("pidType",(((_p!=null)&&(_p.length>=1))?_p[0]:null),1);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get manual fields.
    //<< ;
    //<< ; Input:    pidType     1 : Current, 2: Original
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 16-May-2007   RPW     SR15513: Allow to get current or previous
    //<< ; 29-Nov-2006   PO      SR15249: Removed quotes
    //<< ; 17-Feb-2005   JW      SR11456: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strYMFELD,strContainer,strKey,strGlobal
    mVar strYMFELD = m$.var("strYMFELD");
    mVar strContainer = m$.var("strContainer");
    mVar strKey = m$.var("strKey");
    mVar strGlobal = m$.var("strGlobal");
    m$.newVar(strYMFELD,strContainer,strKey,strGlobal);
    //<< 
    //<< ; TODO : Could call $$GetFormData^COMUtilForm(strContainer,"M")
    //<< set strYMFELD    = ""
    strYMFELD.set("");
    //<< set strContainer = $get(^CacheTemp(YUSER,"Grid","Container"))
    strContainer.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")));
    //<< if strContainer'="" {
    if (mOp.NotEqual(strContainer.get(),"")) {
      //<< set strYMFELD = $get(^WWWDATEN(YM,+$horolog,YUSER,strContainer,"M",pidType)) // SR15513
      strYMFELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),strContainer.get(),"M",pidType.get())));
    }
    //<< }
    //<< quit strYMFELD
    return strYMFELD.get();
  }

  //<< 
  //<< 
  //<< GetYMFELDValue(pidGridRow="",pintCol="")
  public Object GetYMFELDValue(Object ... _p) {
    mVar pidGridRow = m$.newVarRef("pidGridRow",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintCol = m$.newVarRef("pintCol",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; ByRef: YUSER
    //<< ; Returns: Manual form field value
    //<< ;
    //<< ; History:
    //<< ; 01-Feb-2010   GRF     SR17074: Simplified, variable prefix, standard variable
    //<< ; 20-Jan-2010   DWR     SR17074: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $get($$$WWWDATEN("REFERENCEVALUE","Y"_pidGridRow_"_"_pintCol,1))
    return m$.Fnc.$get($$$WWWDATENVar(m$,"REFERENCEVALUE",mOp.Concat(mOp.Concat(mOp.Concat("Y",pidGridRow.get()),"_"),pintCol.get()),1));
  }

  //<< /*
  //<< GetYMFELDValue(pGridRow="",pidFormField="")
  //<< new ManFldVal
  //<< 
  //<< if $data($$$WWWDATEN("REFERENCEVALUE","Y"_pGridRow_"_"_pidFormField)) {
  //<< set ManFldVal = $$$WWWDATEN("REFERENCEVALUE","Y"_pGridRow_"_"_pidFormField,1)
  //<< } else {
  //<< set ManFldVal = ""
  //<< }
  //<< quit ManFldVal
  //<< */
  //<< 
  //<< 
  //<< GetYFELDEX(YFORM,pYKEY)
  public Object GetYFELDEX(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets a value of YFELD based on YKEY
    //<< ;
    //<< ; Macro Call : $$$GRIDGetYFELD(%key) - getting YFORM from CacheTemp
    //<< ;
    //<< ; Inputs :
    //<< ;   YFORM       Form ID
    //<< ;   pYKEY       HeaderKeyList,idDataLine   e.g. "REC123",1.01
    //<< ;
    //<< ; Returns:      $$$WWWDATEN("YFELD",idGridRow,1)
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2009   GRF     SR16669: clarify idGridRow use
    //<< ; 22-Jun-2009   GRF     Clarify key usage (idLastKey rather than reuse pYKEY)
    //<< ; 30-Sep-2005   JW      SR11573: Big speed up.
    //<< ; 29-Jun-2005   JW      SR10412: Added default for pYKEY
    //<< ; 28-Nov-2004   Shobby  Created (SR10468)
    //<< ;-------------------------------------------------------------------------------
    //<< new idGridRow,idLastKey,strYFELD,strYFORM
    mVar idGridRow = m$.var("idGridRow");
    mVar idLastKey = m$.var("idLastKey");
    mVar strYFELD = m$.var("strYFELD");
    mVar strYFORM = m$.var("strYFORM");
    m$.newVar(idGridRow,idLastKey,strYFELD,strYFORM);
    //<< 
    //<< set strYFELD=""
    strYFELD.set("");
    //<< set idGridRow=""
    idGridRow.set("");
    //<< if $get(YFORM)="" set YFORM = $get(^CacheTemp(YUSER,"Grid","Name"))
    if (mOp.Equal(m$.Fnc.$get(YFORM),"")) {
      YFORM.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    }
    //<< if $get(pYKEY)="" set pYKEY = $$GetKey()
    if (mOp.Equal(m$.Fnc.$get(pYKEY),"")) {
      pYKEY.set(m$.fnc$("GetKey"));
    }
    //<< 
    //<< set idLastKey = $translate($piece(pYKEY,",",$length(pYKEY,",")),"""")                         ; 2.01
    idLastKey.set(m$.Fnc.$translate(m$.Fnc.$piece(pYKEY.get(),",",m$.Fnc.$length(pYKEY.get(),",")),"\""));
    //<< if idLastKey'="" {
    if (mOp.NotEqual(idLastKey.get(),"")) {
      //<< set idGridRow = $get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","REFERENCEROW",idLastKey,1))  ; 2x01
      idGridRow.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V","REFERENCEROW",idLastKey.get(),1)));
      //<< if idGridRow'="" {
      if (mOp.NotEqual(idGridRow.get(),"")) {
        //<< set strYFELD = $$GetYFELD(YFORM,idGridRow)
        strYFELD.set(m$.fnc$("GetYFELD",YFORM.get(),idGridRow.get()));
      }
    }
    //<< }
    //<< }
    //<< quit strYFELD
    return strYFELD.get();
  }

  //<< 
  //<< 
  //<< GetYFELD(pstrForm,pidGridRow,pblnGetOrig=$$$NO,&pobjOriginal,pblnGetSaved=$$$NO,&pobjSaved)
  public Object GetYFELD(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidGridRow = m$.newVarRef("pidGridRow",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnGetOrig = m$.newVarRef("pblnGetOrig",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    mVar pobjOriginal = m$.newVarRef("pobjOriginal",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnGetSaved = m$.newVarRef("pblnGetSaved",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    mVar pobjSaved = m$.newVarRef("pobjSaved",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets the "On Disk" version of the object [$sortbegin/$sortend delay writing
    //<< ; any changes back to disk] and then applies the updates in memory to find what
    //<< ; record would be saved or validated.
    //<< ;
    //<< ; Returns:  objYFELD     - current record
    //<< ;           pobjOriginal - (by Ref) original record (loaded data - before changes)
    //<< ;                           Not defined if line is added from outside grid (eg button)
    //<< ;           pobjSaved    - (by Ref) saved record at disc
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2009   GRF     SR16669: clarify pidGridRow use
    //<< ; 29-Aug-2008   FIS     SR15828: return saved data at disc (at the time of saving)
    //<< ; 03-Feb-2006   RPW     SR14093: Use a variable for $h instead of recalculating it
    //<< ; 31-Oct-2005   JW      SR13207: Use original WWWDATEN record (2) as well
    //<< ; 18-Oct-2005   JW      SR11573: Get the class. Don't need key build.
    //<< ; 02-Jun-2005   GRF     Add call to WWWKEYBUILD
    //<< ; 28-Feb-2005   JW      Leave pobjOriginal undefined if not on disk (undefined)
    //<< ; 13-Jan-2005   JW      Data may not be on disk yet if adding a line.
    //<< ; 19-Nov-2004   Shobby  Created (SR10468)
    //<< ;-------------------------------------------------------------------------------
    //<< new arrFields,dteHorolog,idCell,idClass,idColumn,idField,idForm,idKey
    mVar arrFields = m$.var("arrFields");
    mVar dteHorolog = m$.var("dteHorolog");
    mVar idCell = m$.var("idCell");
    mVar idClass = m$.var("idClass");
    mVar idColumn = m$.var("idColumn");
    mVar idField = m$.var("idField");
    mVar idForm = m$.var("idForm");
    mVar idKey = m$.var("idKey");
    m$.newVar(arrFields,dteHorolog,idCell,idClass,idColumn,idField,idForm,idKey);
    //<< new objYFELD,strGlobal
    mVar objYFELD = m$.var("objYFELD");
    mVar strGlobal = m$.var("strGlobal");
    m$.newVar(objYFELD,strGlobal);
    //<< 
    //<< set objYFELD   = ""
    objYFELD.set("");
    //<< set dteHorolog = +$horolog
    dteHorolog.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< kill pobjOriginal                  // Start with undefined
    pobjOriginal.kill();
    //<< kill pobjSaved                     // SR15828
    pobjSaved.kill();
    //<< 
    //<< ; idKey = HeaderKeyList,idDataLine
    //<< set idKey = $get(^WWWDATEN(YM,dteHorolog,YUSER,pstrForm,"V","REFERENCEKEY",pidGridRow,1)) ; FIXME : see GetYFELDEX FIXME above <GRF>
    idKey.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteHorolog.get(),m$.var("YUSER").get(),pstrForm.get(),"V","REFERENCEKEY",pidGridRow.get(),1)));
    //<< 
    //<< if (idKey'="") {
    if ((mOp.NotEqual(idKey.get(),""))) {
      //<< set idClass   = $$$GRIDClass(pstrForm)
      idClass.set(include.COMGridEdit31.$$$GRIDClass(m$,pstrForm));
      //<< set strGlobal = "^"_idClass_"("""_$$$WWWYM(idClass)_""","_idKey_",1)"
      strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",idClass.get()),"(\""),include.COMSYSWWW.$$$WWWYM(m$,idClass)),"\","),idKey.get()),",1)"));
      //<< 
      //<< if $data(@strGlobal) {
      if (mOp.Logical(m$.Fnc.$data(m$.indirectVar(strGlobal.get())))) {
        //<< set objYFELD     = $get(@strGlobal)    ; objYFELD will be the up to date version
        objYFELD.set(m$.Fnc.$get(m$.indirectVar(strGlobal.get())));
        //<< set pobjOriginal = objYFELD            ; pobjOriginal is the on disk version
        pobjOriginal.set(objYFELD.get());
      }
      //<< } else {
      else {
        //<< if $data(^WWWDATEN(YM,dteHorolog,YUSER,pstrForm,"V","YFELD",pidGridRow,1)) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDATEN",m$.var("YM").get(),dteHorolog.get(),m$.var("YUSER").get(),pstrForm.get(),"V","YFELD",pidGridRow.get(),1)))) {
          //<< set objYFELD     = $get(^WWWDATEN(YM,dteHorolog,YUSER,pstrForm,"V","YFELD",pidGridRow,1))
          objYFELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteHorolog.get(),m$.var("YUSER").get(),pstrForm.get(),"V","YFELD",pidGridRow.get(),1)));
          //<< set pblnGetOrig  = $$$NO         // If line was added specifically
          pblnGetOrig.set(include.COMSYS.$$$NO(m$));
          //<< set pblnGetSaved = $$$NO         // SR15828
          pblnGetSaved.set(include.COMSYS.$$$NO(m$));
        }
        //<< 
        //<< } else {
        else {
          //<< set pobjOriginal = ""
          pobjOriginal.set("");
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if (pblnGetSaved = $$$YES) {  //SR15828
      if ((mOp.Equal(pblnGetSaved.get(),include.COMSYS.$$$YES(m$)))) {
        //<< set pobjSaved = pobjOriginal
        pobjSaved.set(pobjOriginal.get());
      }
      //<< }
      //<< 
      //<< set idCell = "Y"_pidGridRow_"_"
      idCell.set(mOp.Concat(mOp.Concat("Y",pidGridRow.get()),"_"));
      //<< for {
      for (;true;) {
        //<< set idCell = $order(^WWWDATEN(YM,dteHorolog,YUSER,pstrForm,"V",idCell))
        idCell.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),dteHorolog.get(),m$.var("YUSER").get(),pstrForm.get(),"V",idCell.get())));
        //<< quit:idCell=""
        if (mOp.Equal(idCell.get(),"")) {
          break;
        }
        //<< quit:($piece($piece(idCell,"Y",2),"_",1)'=pidGridRow)
        if ((mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$piece(idCell.get(),"Y",2),"_",1),pidGridRow.get()))) {
          break;
        }
        //<< 
        //<< set idColumn = $piece(idCell,"_",2)
        idColumn.set(m$.Fnc.$piece(idCell.get(),"_",2));
        //<< set idField  = $$$GetClassField(pstrForm,idColumn)
        idField.set(include.COMSYSWWW.$$$GetClassField(m$,pstrForm,idColumn));
        //<< 
        //<< if idField'="" {
        if (mOp.NotEqual(idField.get(),"")) {
          //<< set $piece(objYFELD,Y,idField) = $get(^WWWDATEN(YM,dteHorolog,YUSER,pstrForm,"V",idCell,1))
          m$.pieceVar(objYFELD,m$.var("Y").get(),idField.get()).set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteHorolog.get(),m$.var("YUSER").get(),pstrForm.get(),"V",idCell.get(),1)));
          //<< if pblnGetOrig set $piece(pobjOriginal,Y,idField) = $get(^WWWDATEN(YM,dteHorolog,YUSER,pstrForm,"V",idCell,2))
          if (mOp.Logical(pblnGetOrig.get())) {
            m$.pieceVar(pobjOriginal,m$.var("Y").get(),idField.get()).set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteHorolog.get(),m$.var("YUSER").get(),pstrForm.get(),"V",idCell.get(),2)));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit objYFELD
    return objYFELD.get();
  }

  //<< 
  //<< 
  //<< ; FIXME : bln arguments should default to $$$NO rather than null. <GRF>
  //<< Enabled(YVOR,YTXT,YHID,pYFELD,YTYP,pidKey="",pidYFORM="",pidYBBN="",pblnHidden="",pblnReadOnly="",pintNewFieldColor="",&pblnMandatory="",pblnKeepDefaults=$$$NO,&pstrNewFieldColor="",&pstrValue="",&pstrFontColor="")
  public Object Enabled(Object ... _p) {
    mVar YVOR = m$.newVarRef("YVOR",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YTXT = m$.newVarRef("YTXT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YHID = m$.newVarRef("YHID",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YTYP = m$.newVarRef("YTYP",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    mVar pidYFORM = m$.newVarRef("pidYFORM",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    mVar pidYBBN = m$.newVarRef("pidYBBN",(((_p!=null)&&(_p.length>=8))?_p[7]:null),"");
    mVar pblnHidden = m$.newVarRef("pblnHidden",(((_p!=null)&&(_p.length>=9))?_p[8]:null),"");
    mVar pblnReadOnly = m$.newVarRef("pblnReadOnly",(((_p!=null)&&(_p.length>=10))?_p[9]:null),"");
    mVar pintNewFieldColor = m$.newVarRef("pintNewFieldColor",(((_p!=null)&&(_p.length>=11))?_p[10]:null),"");
    mVar pblnMandatory = m$.newVarRef("pblnMandatory",(((_p!=null)&&(_p.length>=12))?_p[11]:null),"");
    mVar pblnKeepDefaults = m$.newVarRef("pblnKeepDefaults",(((_p!=null)&&(_p.length>=13))?_p[12]:null),include.COMSYS.$$$NO(m$));
    mVar pstrNewFieldColor = m$.newVarRef("pstrNewFieldColor",(((_p!=null)&&(_p.length>=14))?_p[13]:null),"");
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=15))?_p[14]:null),"");
    mVar pstrFontColor = m$.newVarRef("pstrFontColor",(((_p!=null)&&(_p.length>=16))?_p[15]:null),"");
    //<< ;------------------------------------------------------------------------------
    //<< ; Works out whether a field should be readonly.
    //<< ;
    //<< ; Called By :
    //<< ;   BodyFieldCell^COMGridEdit31Body     all 14 arguments (9-11 null : pblnHidden,pblnReadOnly,pintNewFieldColor)
    //<< ;   Buttons^COMGridEdit31Head           3 arguments       (2 & 3 null)
    //<< ;   OnBeforeFormat^FINAPInvLineDisplay  Arguments 2, 4, 5 (1 & 3 null)
    //<< ;   OnBeforeFormat^FINAPInvoice         Arguments 2, 4    (1 & 3 null)
    //<< ;
    //<< ; Parameters:
    //<< ;   YTXT            objWWW122 or objWWW121 or null
    //<< ;
    //<< ; Returns: blnEnabled
    //<< ;
    //<< ; History:
    //<< ; 26-Aug-2009   shobby  Font Color
    //<< ; 17-Jun-2009   GRF     Doco, show byRef arguments with "&"
    //<< ; 10-Jun-2009   GRF     SR16598: Authorisation Macros
    //<< ; 22-Jan-2007   heber   BR014794: fix byref parameter
    //<< ; xx-xxx-2007   shobby  BR014409: Made some changes and forgot to document them
    //<< ; 13-Apr-2007   shobby  BR014343:Added additional parameters, pblnHidden->pstrNewFieldColor.
    //<< ;                           Parameters are passed through to CheckRules.
    //<< ; 27-Nov-2006   HeberB  BR014330: Check if field is disabled by customization rules (WWW122D2)
    //<< ; 08-Nov-2006   PO      SR15201: Enable Create and Modify Only capability
    //<< ; 04-Apr-2006   RW      Added hidden check
    //<< ; 16-Sep-2005   JW      SR13309 Check if inactive correctly
    //<< ; 13-Apr-2005   PO      SR11349 If current parent record in FC but parent form
    //<< ;                       currently displaying base, disable currency fields
    //<< ; 17-Jan-2005   PO      SR10941 Add quotes around key parts if not quoted
    //<< ; 10-Dec-2004   PO      SR11192
    //<< ; 08-Dec-2004   PO      SR11075 Enable field based inactivity
    //<< ; 26-Nov-2004   Shobby  SR10468: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnEnabled,blnLineSaved,intIndex,strField,strIndirection,strName,strValue,YFELD
    mVar blnEnabled = m$.var("blnEnabled");
    mVar blnLineSaved = m$.var("blnLineSaved");
    mVar intIndex = m$.var("intIndex");
    mVar strField = m$.var("strField");
    mVar strIndirection = m$.var("strIndirection");
    mVar strName = m$.var("strName");
    mVar strValue = m$.var("strValue");
    mVar YFELD = m$.var("YFELD");
    m$.newVar(blnEnabled,blnLineSaved,intIndex,strField,strIndirection,strName,strValue,YFELD);
    //<< 
    //<< $$$LogR("Enabled",pidYFORM_"<"_pidYBBN_"<"_pidKey_"<"_pblnHidden_","_pblnReadOnly_","_pblnMandatory_"<"_pintNewFieldColor_">"_$get(YHID)_">")
    $$$LogR(m$,"Enabled",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidYFORM.get(),"<"),pidYBBN.get()),"<"),pidKey.get()),"<"),pblnHidden.get()),","),pblnReadOnly.get()),","),pblnMandatory.get()),"<"),pintNewFieldColor.get()),">"),m$.Fnc.$get(YHID)),">"));
    //<< 
    //<< set blnEnabled = $$$YES
    blnEnabled.set(include.COMSYS.$$$YES(m$));
    //<< if $get(YHID)=1 {             ; FIXME : Should we be checking for YHID=2 as well?  <GRF>
    if (mOp.Equal(m$.Fnc.$get(YHID),1)) {
      //<< set blnEnabled = $$$NO
      blnEnabled.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif ($get(^CacheTemp(YUSER,"Grid","Enabled"))=$$$NO) {
    else if ((mOp.Equal(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Enabled")),include.COMSYS.$$$NO(m$)))) {
      //<< set blnEnabled = $$$NO
      blnEnabled.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif ($$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly) {
    else if ((mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,YVOR),include.COMSYSEnum.$$$EnumReadOnly(m$)))) {
      //<< set blnEnabled = $$$NO
      blnEnabled.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif ($$$WWW122UserAccessForChange(YTXT) = $$$EnumReadOnly) {
    else if ((mOp.Equal(include.WWWConst.$$$WWW122UserAccessForChange(m$,YTXT),include.COMSYSEnum.$$$EnumReadOnly(m$)))) {
      //<< set blnEnabled = $$$NO
      blnEnabled.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif ($$$WWW122DataInputType(YTXT)=15) {           ; Hidden
    else if ((mOp.Equal(include.WWWConst.$$$WWW122DataInputType(m$,YTXT),15))) {
      //<< set blnEnabled = $$$NO
      blnEnabled.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif $data(pYFELD) {
    else if (mOp.Logical(m$.Fnc.$data(pYFELD))) {
      //<< if $$$WWW122FieldIsInactiveIfDataFiel(YTXT) {
      if (mOp.Logical(include.WWWConst.$$$WWW122FieldIsInactiveIfDataFiel(m$,YTXT))) {
        //<< do IsInactive^WWWFORM9(YTXT,pYFELD,.YHID)
        m$.Cmd.Do("WWWFORM9.IsInactive",YTXT.get(),pYFELD.get(),YHID);
        //<< if $get(YHID)=2 {
        if (mOp.Equal(m$.Fnc.$get(YHID),2)) {
          //<< set blnEnabled = $$$NO
          blnEnabled.set(include.COMSYS.$$$NO(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< $$$LogRx("CGEG-E1:"_blnEnabled)
    $$$LogRx(m$,mOp.Concat("CGEG-E1:",blnEnabled.get()));
    //<< 
    //<< if blnEnabled {
    if (mOp.Logical(blnEnabled.get())) {
      //<< if ($get(YTYP)=8) && ($$$CurrencyToUse="Base") {   ; Currency Type
      if ((mOp.Equal(m$.Fnc.$get(YTYP),8)) && (mOp.Equal(include.COMSYSNum.$$$CurrencyToUse(m$),"Base"))) {
        //<< set blnEnabled = $$$NO
        blnEnabled.set(include.COMSYS.$$$NO(m$));
      }
      //<< 
      //<< } elseif (pidKey '= "") {
      else if ((mOp.NotEqual(pidKey.get(),""))) {
        //<< set blnLineSaved = $$IsSavedLine($get(^CacheTemp(YUSER,"Grid","Name")),pidKey)
        blnLineSaved.set(m$.fnc$("IsSavedLine",m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")),pidKey.get()));
        //<< if blnLineSaved && ($$$WWW122UserAccessForChange(YTXT) = $$$EnumCreateOnly) {
        if (mOp.Logical(blnLineSaved.get()) && (mOp.Equal(include.WWWConst.$$$WWW122UserAccessForChange(m$,YTXT),include.COMSYSEnum.$$$EnumCreateOnly(m$)))) {
          //<< set blnEnabled = $$$NO
          blnEnabled.set(include.COMSYS.$$$NO(m$));
        }
        //<< 
        //<< } elseif 'blnLineSaved && ($$$WWW122UserAccessForChange(YTXT) = $$$EnumModifyOnly) {
        else if (mOp.Not(blnLineSaved.get()) && (mOp.Equal(include.WWWConst.$$$WWW122UserAccessForChange(m$,YTXT),include.COMSYSEnum.$$$EnumModifyOnly(m$)))) {
          //<< set blnEnabled = $$$NO
          blnEnabled.set(include.COMSYS.$$$NO(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< if (pidYFORM'="") && (pidYBBN'="") && $data(pYFELD)  {
    if ((mOp.NotEqual(pidYFORM.get(),"")) && (mOp.NotEqual(pidYBBN.get(),"")) && mOp.Logical(m$.Fnc.$data(pYFELD))) {
      //<< if blnEnabled{
      if (mOp.Logical(blnEnabled.get())) {
        //<< if (pidYFORM = "VARAtaLinha"){ ; SESDF-631
        if ((mOp.Equal(pidYFORM.get(),"VARAtaLinha"))) {
          //<< do CheckRules^WWWFORMD(pidYFORM,pidYBBN,.pYFELD,.pblnHidden,.pblnReadOnly,
          //<< .pintNewFieldColor,.pblnMandatory,pblnKeepDefaults,
          //<< .pstrNewFieldColor,,,,,,,.pstrFontColor)  ;SR16704
          m$.Cmd.Do("WWWFORMD.CheckRules",pidYFORM.get(),pidYBBN.get(),pYFELD,pblnHidden,pblnReadOnly,pintNewFieldColor,pblnMandatory,pblnKeepDefaults.get(),pstrNewFieldColor,null,null,null,null,null,null,pstrFontColor);
        }
        //<< } else {
        else {
          //<< do CheckRules^WWWFORMD(pidYFORM,pidYBBN,.pYFELD,.pblnHidden,.pblnReadOnly,
          //<< .pintNewFieldColor,.pblnMandatory,pblnKeepDefaults,
          //<< .pstrNewFieldColor,,,,,,.pstrValue,.pstrFontColor)  ;SR16704
          m$.Cmd.Do("WWWFORMD.CheckRules",pidYFORM.get(),pidYBBN.get(),pYFELD,pblnHidden,pblnReadOnly,pintNewFieldColor,pblnMandatory,pblnKeepDefaults.get(),pstrNewFieldColor,null,null,null,null,null,pstrValue,pstrFontColor);
        }
        //<< }
        //<< if pblnReadOnly set blnEnabled = $$$NO
        if (mOp.Logical(pblnReadOnly.get())) {
          blnEnabled.set(include.COMSYS.$$$NO(m$));
        }
      }
      //<< 
      //<< } else {  ;16511
      else {
        //<< do CheckRules^WWWFORMD(pidYFORM,pidYBBN,pYFELD,pblnHidden,pblnReadOnly,
        //<< pintNewFieldColor,pblnMandatory,pblnKeepDefaults,
        //<< .pstrNewFieldColor,,,,,,pstrValue,.pstrFontColor)   ;SR16704
        m$.Cmd.Do("WWWFORMD.CheckRules",pidYFORM.get(),pidYBBN.get(),pYFELD.get(),pblnHidden.get(),pblnReadOnly.get(),pintNewFieldColor.get(),pblnMandatory.get(),pblnKeepDefaults.get(),pstrNewFieldColor,null,null,null,null,null,pstrValue.get(),pstrFontColor);
      }
    }
    //<< }
    //<< }
    //<< quit blnEnabled
    return blnEnabled.get();
  }

  //<< 
  //<< 
  //<< GetKey()   ; USE MACRO : $$$GRIDGetCurrentKey
  public Object GetKey(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the value of the YKEY for the current row.
    //<< ;
    //<< ; Returns: YKEY   = HeaderKeyList,idDataLine  e.g. "REC0123",2.01
    //<< ;
    //<< ; History:
    //<< ; 07-Aug-2009   GRF     SR16787: standard variables and doco
    //<< ; 31-Oct-2006   JW      BR014279: Return null if there is no focus field (empty grid)
    //<< ; 02-Feb-2005   shobby  CodeCheck.
    //<< ; 02-Dec-2004   JW      SR11066 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCell,idGridRow,strDataKeys
    mVar idCell = m$.var("idCell");
    mVar idGridRow = m$.var("idGridRow");
    mVar strDataKeys = m$.var("strDataKeys");
    m$.newVar(idCell,idGridRow,strDataKeys);
    //<< 
    //<< set strDataKeys = ""
    strDataKeys.set("");
    //<< set idCell = $get($$$WWWDATEN("FOCUSFIELD")) ; Macro override : based on ^CacheTemp rather than YFORM
    idCell.set(m$.Fnc.$get($$$WWWDATENVar(m$,"FOCUSFIELD")));
    //<< if idCell'="" {                                        ; e.g. Y2x01_5
    if (mOp.NotEqual(idCell.get(),"")) {
      //<< set $extract(idCell,1) = ""
      mVar $extract = m$.var("$extract");
      $extract.var(idCell.get(),1).set("");
      //<< set idGridRow = $piece(idCell,"_",1)               ; 2x01
      idGridRow.set(m$.Fnc.$piece(idCell.get(),"_",1));
      //<< set strDataKeys = $$$DEQUOTE($$GetYKEY(idGridRow)) ; "REC0123",2.01 => REC0123,2.01
      strDataKeys.set(include.COMSYSString.$$$DEQUOTE(m$,m$.fnc$("GetYKEY",idGridRow.get())));
    }
    //<< }
    //<< quit strDataKeys
    return strDataKeys.get();
  }

  //<< 
  //<< 
  //<< GoToFormWithFld(newForm,pField="",pPage="",pParam="")
  public Object GoToFormWithFld(Object ... _p) {
    mVar newForm = m$.newVarRef("newForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pField = m$.newVarRef("pField",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pPage = m$.newVarRef("pPage",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pParam = m$.newVarRef("pParam",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Go to a new form using the value of a field of the current row of the grid.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 14-Aug-2006   JW      SR14730: Added popup param
    //<< ; 02-Feb-2005   shobby  CodeCheck.
    //<< ; 06-Dec-2004   JW      SR10541: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new focusField,value
    mVar focusField = m$.var("focusField");
    mVar value = m$.var("value");
    m$.newVar(focusField,value);
    //<< 
    //<< set focusField = $get($$$WWWDATEN("FOCUSFIELD"))    ; Macro override : based on ^CacheTemp rather than YFORM
    focusField.set(m$.Fnc.$get($$$WWWDATENVar(m$,"FOCUSFIELD")));
    //<< 
    //<< set $piece(focusField,"_",2) = pField
    m$.pieceVar(focusField,"_",2).set(pField.get());
    //<< set value=$get($$$WWWDATEN(focusField,1))           ; Macro override : based on ^CacheTemp rather than YFORM
    value.set(m$.Fnc.$get($$$WWWDATENVar(m$,focusField,1)));
    //<< 
    //<< do GoToForm(newForm,value,$$$NO,pPage,pParam)
    m$.Cmd.Do("GoToForm",newForm.get(),value.get(),include.COMSYS.$$$NO(m$),pPage.get(),pParam.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GoToForm(pnewForm,pKey,pblnPopup=$$$NO,pPage="",pParam="")
  public Object GoToForm(Object ... _p) {
    mVar pnewForm = m$.newVarRef("pnewForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnPopup = m$.newVarRef("pblnPopup",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    mVar pPage = m$.newVarRef("pPage",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pParam = m$.newVarRef("pParam",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Go to a new form from the grid. Either use the YKEY of the current row of the grid,
    //<< ; or a specified key.
    //<< ;
    //<< ; Params:   pstrForm - Form to go to.
    //<< ;           pKey - Key to use
    //<< ;           pPage,pParam - page and paramaters
    //<< ;
    //<< ; Returns:  nil
    //<< ;
    //<< ; History:
    //<< ; 08-Aug-2006   JW      SR14730: Simplified. Added popup
    //<< ; 06-Dec-2004   JW      SR10541: Split into more functions.
    //<< ; 02-Dec-2004   JW      SR11066: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $get(pKey)="" {
    if (mOp.Equal(m$.Fnc.$get(pKey),"")) {
      //<< set pKey = $$GetKey()
      pKey.set(m$.fnc$("GetKey"));
    }
    //<< }
    //<< 
    //<< if pblnPopup {
    if (mOp.Logical(pblnPopup.get())) {
      //<< set YBACK=""
      mVar YBACK = m$.var("YBACK");
      YBACK.set("");
      //<< set %("VAR","YUSER") = $$GetChildUser^WWWUSER(YUSER)
      m$.var("%","VAR","YUSER").set(m$.fnc$("WWWUSER.GetChildUser",m$.var("YUSER").get()));
    }
    //<< } else {
    else {
      //<< ; replace grid form in YBACK with main form
      //<< set $piece(YBACK,YKOMMA,$length(YBACK,YKOMMA)-1) = $get(^CacheTemp(YUSER,"Grid","Container"))
      m$.pieceVar(m$.var("YBACK"),m$.var("YKOMMA").get(),mOp.Subtract(m$.Fnc.$length(m$.var("YBACK").get(),m$.var("YKOMMA").get()),1)).set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")));
    }
    //<< }
    //<< do LoadFormNow(pnewForm,pKey,pPage,pParam)
    m$.Cmd.Do("LoadFormNow",pnewForm.get(),pKey.get(),pPage.get(),pParam.get());
    //<< 
    //<< // Don't Display the footer twice
    //<< set YNOFOOT = 1                   // FIXME: Is there an extra call to WWWFORM?
    mVar YNOFOOT = m$.var("YNOFOOT");
    YNOFOOT.set(1);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ReloadForm(pParam="")
  public Object ReloadForm(Object ... _p) {
    mVar pParam = m$.newVarRef("pParam",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Reload the current form
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Dec-2004   JW      SR10541: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new form,lenBack
    mVar form = m$.var("form");
    mVar lenBack = m$.var("lenBack");
    m$.newVar(form,lenBack);
    //<< ; remove grid form from YBACK
    //<< set lenBack = $length(YBACK,YKOMMA)
    lenBack.set(m$.Fnc.$length(m$.var("YBACK").get(),m$.var("YKOMMA").get()));
    //<< set $piece(YBACK,YKOMMA,lenBack-1,lenBack) = ""
    m$.pieceVar(m$.var("YBACK"),m$.var("YKOMMA").get(),mOp.Subtract(lenBack.get(),1),lenBack.get()).set("");
    //<< 
    //<< set form = $get(^CacheTemp(YUSER,"Grid","Container"))
    form.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")));
    //<< 
    //<< do LoadFormNow(form,YKEY,YSEITE,pParam)
    m$.Cmd.Do("LoadFormNow",form.get(),m$.var("YKEY").get(),m$.var("YSEITE").get(),pParam.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< LoadFormNow(pForm,pidKey,pPage,pParam,pYUSER) private
  public Object LoadFormNow(Object ... _p) {
    mVar pForm = m$.newVarRef("pForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pPage = m$.newVarRef("pPage",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pParam = m$.newVarRef("pParam",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pYUSER = m$.newVarRef("pYUSER",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update Variables and load form
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Dec-2004   JW      SR10541: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set %("VAR","YBACK") = YBACK
    m$.var("%","VAR","YBACK").set(m$.var("YBACK").get());
    //<< if $get(pParam)'="" set %("VAR","YPARA")  = pParam
    if (mOp.NotEqual(m$.Fnc.$get(pParam),"")) {
      m$.var("%","VAR","YPARA").set(pParam.get());
    }
    //<< if $get(pPage)'=""  set %("VAR","YSEITE") = pPage
    if (mOp.NotEqual(m$.Fnc.$get(pPage),"")) {
      m$.var("%","VAR","YSEITE").set(pPage.get());
    }
    //<< if $get(pYUSER)'="" set %("VAR","YUSER")  = pYUSER
    if (mOp.NotEqual(m$.Fnc.$get(pYUSER),"")) {
      m$.var("%","VAR","YUSER").set(pYUSER.get());
    }
    //<< set %("VAR","YKEY")  = pidKey
    m$.var("%","VAR","YKEY").set(pidKey.get());
    //<< set %("VAR","YFORM") = pForm
    m$.var("%","VAR","YFORM").set(pForm.get());
    //<< 
    //<< do ^WWWFORM
    m$.Cmd.Do("WWWFORM.main");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< UpdateHeaderField(pstrField,pstrValue="",pFieldType="")
  public Object UpdateHeaderField(Object ... _p) {
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pFieldType = m$.newVarRef("pFieldType",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Call PopulateDataField in a way that people think the grid is doing the work.
    //<< ; It pulls apart pstrField, ie if pstrField is "D17" then it says it's a data field
    //<< ; at position 17 in the form definition.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 30-Mar-2010   shobby  SR16606: Get the field to change colour $$$NO->$$$YES
    //<< ; 17-Jun-2005   PO      No longer adjusting value passed into PopulateDataFields,
    //<< ;                           work now done by PopulateDataFields.
    //<< ; 14-Jun-2005   PO      Used equality test instead of case statement on CurrencyToUse
    //<< ; 17-Mar-2005   PO      SR11349 Support FC
    //<< ; 16-Feb-2005   RobertW Put some value checking in place.
    //<< ; 28-Dec-2004   RobertW SR10061: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strContainer,strType,intField
    mVar strContainer = m$.var("strContainer");
    mVar strType = m$.var("strType");
    mVar intField = m$.var("intField");
    m$.newVar(strContainer,strType,intField);
    //<< 
    //<< if $get(pstrField)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pstrField),"")) {
      //<< set strContainer = $get(^CacheTemp(YUSER,"Grid","Container"))
      strContainer.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")));
      //<< if strContainer="" set strContainer = $get(YFORM)
      if (mOp.Equal(strContainer.get(),"")) {
        strContainer.set(m$.Fnc.$get(m$.var("YFORM")));
      }
      //<< 
      //<< set strType  = $extract(pstrField,1)
      strType.set(m$.Fnc.$extract(pstrField.get(),1));
      //<< set intField = $extract(pstrField,2,$length(pstrField))
      intField.set(m$.Fnc.$extract(pstrField.get(),2,m$.Fnc.$length(pstrField.get())));
      //<< 
      //<< ; To speed things up may want to pass in CurrencyToUse value since to determine
      //<< ; which currency to use involves two global accesses every time.
      //<< 
      //<< do PopulateDataField^COMUtils(strContainer,intField,pstrValue,strType,,$$$YES)  ;SR16606
      m$.Cmd.Do("COMUtils.PopulateDataField",strContainer.get(),intField.get(),pstrValue.get(),strType.get(),null,include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetLineId(YKEY,pYFORM="")
  public Object GetLineId(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; NOTE :
    //<< ;    ReferenceRow^COMGridEdit31Interface returns same but passes idDataLine
    //<< ;    instead of "HeaderKeyList,idDataLine".
    //<< ;
    //<< ;
    //<< ; Returns: idGridRow (e.g. 2x01 or 3)
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2009   GRF     SR16669: clarify idGridRow use
    //<< ; 19-Oct-2005   JW      SR11573: Use last piece, not 2nd.
    //<< ; 24-Mar-2005   shobby  Get the ID of the line in the grid from its YKEY
    //<< ;-------------------------------------------------------------------------------
    //<< new idGridRow,idLastKey,YFORM
    mVar idGridRow = m$.var("idGridRow");
    mVar idLastKey = m$.var("idLastKey");
    mVar YFORM = m$.var("YFORM");
    m$.newVar(idGridRow,idLastKey,YFORM);
    //<< 
    //<< set idGridRow = ""
    idGridRow.set("");
    //<< if $get(pYFORM)="" {   ; FIXME : WWWDATEN Macro uses ^CacheTemp(YUSER,"Grid","Name") not YFORM - pYFORM & this block not effective <GRF>
    if (mOp.Equal(m$.Fnc.$get(pYFORM),"")) {
      //<< set YFORM = $get(^CacheTemp(YUSER,"Grid","Name"))
      YFORM.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    }
    //<< } else {
    else {
      //<< set YFORM = pYFORM
      YFORM.set(pYFORM.get());
    }
    //<< }
    //<< set idLastKey = $$$KEYMAX(YKEY)    // SR11573
    idLastKey.set(include.COMSYSWWW.$$$KEYMAX(m$,YKEY));
    //<< if idLastKey'="" {
    if (mOp.NotEqual(idLastKey.get(),"")) {
      //<< set idGridRow = $get($$$WWWDATEN("REFERENCEROW",idLastKey,1))    ; Macro override : based on ^CacheTemp rather than YFORM
      idGridRow.set(m$.Fnc.$get($$$WWWDATENVar(m$,"REFERENCEROW",idLastKey,1)));
    }
    //<< }
    //<< quit idGridRow
    return idGridRow.get();
  }

  //<< 
  //<< 
  //<< GetLineIds(&parrLines) ; FIXME : Poor naming differentiation for tag <GRF>
  public Object GetLineIds(Object ... _p) {
    mVar parrLines = m$.newVarRef("parrLines",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns (ByRef) : Array based on "2x01" form of grid row identifiers
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2009   GRF     SR16669: clarify idGridRow use
    //<< ;-------------------------------------------------------------------------------
    //<< new idGridRow
    mVar idGridRow = m$.var("idGridRow");
    m$.newVar(idGridRow);
    //<< 
    //<< set idGridRow = ""
    idGridRow.set("");
    //<< for {
    for (;true;) {
      //<< set idGridRow = $order($$$WWWDATEN("REFERENCEKEY",idGridRow))    ; Macro override : based on ^CacheTemp rather than YFORM
      idGridRow.set(m$.Fnc.$order($$$WWWDATENVar(m$,"REFERENCEKEY",idGridRow)));
      //<< quit:idGridRow=""
      if (mOp.Equal(idGridRow.get(),"")) {
        break;
      }
      //<< 
      //<< set parrLines(idGridRow) = ""
      parrLines.var(idGridRow.get()).set("");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GridExists()
  public Object GridExists(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; xx-Jan-2005   JW      Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit ($get(^CacheTemp(YUSER,"Grid","Container"))'="")
    return (mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")),""));
  }

  //<< 
  //<< 
  //<< UpdateContainer(pstrFld="",blnUpdateYFELD=$$$YES)
  public Object UpdateContainer(Object ... _p) {
    mVar pstrFld = m$.newVarRef("pstrFld",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar blnUpdateYFELD = m$.newVarRef("blnUpdateYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update the header YFELD and YMFELD.
    //<< ; This function is called After: OnBlur,OnAfterDataFields,OnAfterDelete.
    //<< ;
    //<< ; Params:   pstrFld - reference to which class field has just changed (if any)
    //<< ;           blnUpdateYFELD - whether to update YFELD or not
    //<< ;
    //<< ; Returns: nil
    //<< ;
    //<< ; History:
    //<< ; 08-Apr-2010   GRF     SR17177: objGrid should be arrGrid
    //<< ; 12-Dec-2007   GRF     i=>loop
    //<< ; 10-Apr-2006   JW      Moved check inside this routine
    //<< ; 06-Oct-2005   JW      SR11573: Call CallEvent
    //<< ; 09-May-2005   JW      SR12309: Added param blnUpdateYFELD
    //<< ; 22-Mar-2005   PO      SR11349: FC support, pass through field type
    //<< ; 16-Mar-2005   JW      SR11916: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit:$get(^CacheTemp(YUSER,"Grid","DontUpdateContainer"))        ; nothing to do
    if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","DontUpdateContainer")))) {
      return null;
    }
    //<< 
    //<< new arrGrid,headYFELDOld,headYMFELDOld,headYFELD,headYMFELD,loop,strName,strOldName
    mVar arrGrid = m$.var("arrGrid");
    mVar headYFELDOld = m$.var("headYFELDOld");
    mVar headYMFELDOld = m$.var("headYMFELDOld");
    mVar headYFELD = m$.var("headYFELD");
    mVar headYMFELD = m$.var("headYMFELD");
    mVar loop = m$.var("loop");
    mVar strName = m$.var("strName");
    mVar strOldName = m$.var("strOldName");
    m$.newVar(arrGrid,headYFELDOld,headYMFELDOld,headYFELD,headYMFELD,loop,strName,strOldName);
    //<< 
    //<< do GetGridContents(.arrGrid)
    m$.Cmd.Do("GetGridContents",arrGrid);
    //<< set headYFELD  = $$GetYFELDContainer()
    headYFELD.set(m$.fnc$("GetYFELDContainer"));
    //<< set headYMFELD = $$GetYMFELDContainer()
    headYMFELD.set(m$.fnc$("GetYMFELDContainer"));
    //<< ; TODO: set arrGrid = headYFELD ; so detail does not need to be retrieved later
    //<< 
    //<< set headYFELDOld  = headYFELD
    headYFELDOld.set(headYFELD.get());
    //<< set headYMFELDOld = headYMFELD
    headYMFELDOld.set(headYMFELD.get());
    //<< 
    //<< set strName = $get(^CacheTemp(YUSER,"Grid","Name"))      ; e.g. INRECSummary
    strName.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    //<< 
    //<< if strName'="" {
    if (mOp.NotEqual(strName.get(),"")) {
      //<< do CalculatedFields(.arrGrid,pstrFld,.headYFELD,.headYMFELD)
      m$.Cmd.Do("CalculatedFields",arrGrid,pstrFld.get(),headYFELD,headYMFELD);
      //<< $$$CallEvent("do UpdateContainer^"_strName_"(pstrFld,.arrGrid,.headYFELD,.headYMFELD)","Container")
      include.COMGridEdit31.$$$CallEvent(m$,mOp.Concat(mOp.Concat("do UpdateContainer^",strName.get()),"(pstrFld,.arrGrid,.headYFELD,.headYMFELD)"),"Container");
    }
    //<< 
    //<< } else {
    else {
      //<< set headYFELD  = $get(YFELD)                        //
      headYFELD.set(m$.Fnc.$get(m$.var("YFELD")));
      //<< set headYMFELD = $get(YMFELD)                       //
      headYMFELD.set(m$.Fnc.$get(m$.var("YMFELD")));
    }
    //<< }                                                       // <-- FIXME : Is this code required? JW
    //<< set strName = $get(^CacheTemp(YUSER,"Grid","Container"))    //
    strName.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")));
    //<< if strName="" set strName = YFORM                           //
    if (mOp.Equal(strName.get(),"")) {
      strName.set(m$.var("YFORM").get());
    }
    //<< 
    //<< if (blnUpdateYFELD) && (headYFELD'=headYFELDOld) {
    if (mOp.Logical((blnUpdateYFELD.get())) && (mOp.NotEqual(headYFELD.get(),headYFELDOld.get()))) {
      //<< for loop=1:1:$length(headYFELD,Y) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(headYFELD.get(),m$.var("Y").get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< if $piece(headYFELD,Y,loop)'=$piece(headYFELDOld,Y,loop) {
        if (mOp.NotEqual(m$.Fnc.$piece(headYFELD.get(),m$.var("Y").get(),loop.get()),m$.Fnc.$piece(headYFELDOld.get(),m$.var("Y").get(),loop.get()))) {
          //<< set strOldName = strName
          strOldName.set(strName.get());
          //<< set strName    = $$$WWW120ClassUsedInForm($get(^WWW120(0,strName,1)))
          strName.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,strName.get(),1))));
          //<< if strName = "" set strName = strOldName
          if (mOp.Equal(strName.get(),"")) {
            strName.set(strOldName.get());
          }
          //<< do UpdateHeaderField("D"_loop,$piece(headYFELD,Y,loop),$$$WWW003InputType($get(^WWW003(0,strName,loop,1))))
          m$.Cmd.Do("UpdateHeaderField",mOp.Concat("D",loop.get()),m$.Fnc.$piece(headYFELD.get(),m$.var("Y").get(),loop.get()),include.WWWConst.$$$WWW003InputType(m$,m$.Fnc.$get(m$.var("^WWW003",0,strName.get(),loop.get(),1))));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if headYMFELD'=headYMFELDOld {
    if (mOp.NotEqual(headYMFELD.get(),headYMFELDOld.get())) {
      //<< for loop=1:1:$length(headYMFELD,Y) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(headYMFELD.get(),m$.var("Y").get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< if $piece(headYMFELD,Y,loop)'=$piece(headYMFELDOld,Y,loop) {
        if (mOp.NotEqual(m$.Fnc.$piece(headYMFELD.get(),m$.var("Y").get(),loop.get()),m$.Fnc.$piece(headYMFELDOld.get(),m$.var("Y").get(),loop.get()))) {
          //<< do UpdateHeaderField("M"_loop,$piece(headYMFELD,Y,loop),$$GetFieldType^COMUtilClass(strName,loop))
          m$.Cmd.Do("UpdateHeaderField",mOp.Concat("M",loop.get()),m$.Fnc.$piece(headYMFELD.get(),m$.var("Y").get(),loop.get()),m$.fnc$("COMUtilClass.GetFieldType",strName.get(),loop.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< // do SetGridContents - Maybe do this in the future for callbacks
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CalculatedFields(&parrGrid,pstrFld,pheadYFELD,pheadYMFELD)
  public Object CalculatedFields(Object ... _p) {
    mVar parrGrid = m$.newVarRef("parrGrid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrFld = m$.newVarRef("pstrFld",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pheadYFELD = m$.newVarRef("pheadYFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pheadYMFELD = m$.newVarRef("pheadYMFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Calculates totals for 'bound' fields in the header record and updates those
    //<< ; fields appropriately.
    //<< ;
    //<< ; Called By : UpdateContainer^COMGridEdit31G
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Apr-2010   GRF     SR17177: pobjGrid should be parrGrid (with &)
    //<< ; 18-Oct-2005   PO      Newed strType,intFormField
    //<< ; 30-Sep-2005   JW      SR11573: Added phead params. Moved from COMGridEdit31S
    //<< ; 18-Nov-2004   Shobby  SR10468: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrResults,fltTotal,idField,intFormField,strField,strType
    mVar arrResults = m$.var("arrResults");
    mVar fltTotal = m$.var("fltTotal");
    mVar idField = m$.var("idField");
    mVar intFormField = m$.var("intFormField");
    mVar strField = m$.var("strField");
    mVar strType = m$.var("strType");
    m$.newVar(arrResults,fltTotal,idField,intFormField,strField,strType);
    //<< 
    //<< set idField = ""
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField = $order(^CacheTemp(YUSER,"Grid","Update",idField))
      idField.set(m$.Fnc.$order(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Update",idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< 
      //<< set strField = $get(^CacheTemp(YUSER,"Grid","Update",idField))
      strField.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Update",idField.get())));
      //<< if strField'="" {
      if (mOp.NotEqual(strField.get(),"")) {
        //<< set fltTotal = $$Sum(.parrGrid,idField)
        fltTotal.set(m$.fnc$("Sum",parrGrid,idField.get()));
        //<< set fltTotal = $justify(fltTotal,1,2)
        fltTotal.set(m$.Fnc.$justify(fltTotal.get(),1,2));
        //<< set arrResults(idField) = strField_Y_fltTotal
        arrResults.var(idField.get()).set(mOp.Concat(mOp.Concat(strField.get(),m$.var("Y").get()),fltTotal.get()));
      }
    }
    //<< }
    //<< }
    //<< set idField = ""
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField = $order(^CacheTemp(YUSER,"Grid","Calculated",idField))
      idField.set(m$.Fnc.$order(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Calculated",idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< 
      //<< set strField = $get(^CacheTemp(YUSER,"Grid","Calculated",idField))
      strField.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Calculated",idField.get())));
      //<< 
      //<< if strField'="" {
      if (mOp.NotEqual(strField.get(),"")) {
        //<< set strField(1) = $piece(idField,"-",1)
        strField.var(1).set(m$.Fnc.$piece(idField.get(),"-",1));
        //<< set strField(2) = $piece(idField,"-",2)
        strField.var(2).set(m$.Fnc.$piece(idField.get(),"-",2));
        //<< if '$data(arrResults(strField(1))) {
        if (mOp.Not(m$.Fnc.$data(arrResults.var(strField.var(1).get())))) {
          //<< set arrResults(strField(1)) = Y_$$Sum(.parrGrid,strField(1))
          arrResults.var(strField.var(1).get()).set(mOp.Concat(m$.var("Y").get(),m$.fnc$("Sum",parrGrid,strField.var(1).get())));
        }
        //<< }
        //<< if '$data(arrResults(strField(2))) {
        if (mOp.Not(m$.Fnc.$data(arrResults.var(strField.var(2).get())))) {
          //<< set arrResults(strField(2)) = Y_$$Sum(.parrGrid,strField(2))
          arrResults.var(strField.var(2).get()).set(mOp.Concat(m$.var("Y").get(),m$.fnc$("Sum",parrGrid,strField.var(2).get())));
        }
        //<< }
        //<< set fltTotal = $justify($$$FCSub($piece(arrResults(strField(1)),Y,2),$piece(arrResults(strField(2)),Y,2)),1,2)
        fltTotal.set(m$.Fnc.$justify(include.COMSYSNum.$$$FCSub(m$,m$.Fnc.$piece(arrResults.var(strField.var(1).get()).get(),m$.var("Y").get(),2),m$.Fnc.$piece(arrResults.var(strField.var(2).get()).get(),m$.var("Y").get(),2)),1,2));
        //<< set arrResults(strField) = strField_Y_fltTotal
        arrResults.var(strField.get()).set(mOp.Concat(mOp.Concat(strField.get(),m$.var("Y").get()),fltTotal.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set idField = ""
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField = $order(arrResults(idField))
      idField.set(m$.Fnc.$order(arrResults.var(idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< 
      //<< set strField = $piece(arrResults(idField),Y,1)
      strField.set(m$.Fnc.$piece(arrResults.var(idField.get()).get(),m$.var("Y").get(),1));
      //<< if strField'="" {
      if (mOp.NotEqual(strField.get(),"")) {
        //<< ;Only display results that have a field set up to send to.
        //<< ;Some results may just have been used to calculate other fields.
        //<< /*
        //<< set %TXT(1)=$get(%TXT(1))_$get(arrResults(YBBN))
        //<< set YRETVAL=$get(YRETVAL)_$get(arrResults(YBBN))
        //<< do UpdateContainerBackEnd(arrResults(YBBN))
        //<< */
        //<< 
        //<< set strType      = $extract(strField,1)
        strType.set(m$.Fnc.$extract(strField.get(),1));
        //<< set intFormField = $extract(strField,2,999)
        intFormField.set(m$.Fnc.$extract(strField.get(),2,999));
        //<< if strType="D" {
        if (mOp.Equal(strType.get(),"D")) {
          //<< set $piece(pheadYFELD,Y,intFormField)  = $piece(arrResults(idField),Y,2)
          m$.pieceVar(pheadYFELD,m$.var("Y").get(),intFormField.get()).set(m$.Fnc.$piece(arrResults.var(idField.get()).get(),m$.var("Y").get(),2));
        }
        //<< 
        //<< } else {
        else {
          //<< set $piece(pheadYMFELD,Y,intFormField) = $piece(arrResults(idField),Y,2)
          m$.pieceVar(pheadYMFELD,m$.var("Y").get(),intFormField.get()).set(m$.Fnc.$piece(arrResults.var(idField.get()).get(),m$.var("Y").get(),2));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Sum(&parrGrid,pidField)
  public Object Sum(Object ... _p) {
    mVar parrGrid = m$.newVarRef("parrGrid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;/*------------------------------------------------------------------------------
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Apr-2010   GRF     SR17177: pobjGrid should be parrGrid (with &)
    //<< ; 30-Sep-2005   JW      SR11573: Rewrote to use pobjGrid. Moved from COMGridEdit31S
    //<< ; 31-Jan-2005   Shobby  Code Check
    //<< ;-----------------------------------------------------------------------------*/
    //<< new fltTotal,query,strKey
    mVar fltTotal = m$.var("fltTotal");
    mVar query = m$.var("query");
    mVar strKey = m$.var("strKey");
    m$.newVar(fltTotal,query,strKey);
    //<< 
    //<< set fltTotal = 0
    fltTotal.set(0);
    //<< set pidField = $$$GetClassField($get(^CacheTemp(YUSER,"Grid","Name")),pidField)
    pidField.set(include.COMSYSWWW.$$$GetClassField(m$,m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")),pidField));
    //<< set query    = "parrGrid"
    query.set("parrGrid");
    //<< for {
    for (;true;) {
      //<< set query = $query(@query)
      query.set(m$.Fnc.$query(m$.indirectVar(query.get())));
      //<< quit:query=""
      if (mOp.Equal(query.get(),"")) {
        break;
      }
      //<< 
      //<< set fltTotal = $$$FCAdd(fltTotal,$piece(@query,Y,pidField))
      fltTotal.set(include.COMSYSNum.$$$FCAdd(m$,fltTotal,m$.Fnc.$piece(m$.indirectVar(query.get()).get(),m$.var("Y").get(),pidField.get())));
    }
    //<< }
    //<< quit fltTotal
    return fltTotal.get();
  }

  //<< 
  //<< 
  //<< UpdateManualField(pROW,pCOL,pVALUE,pYFORM)
  public Object UpdateManualField(Object ... _p) {
    mVar pROW = m$.newVarRef("pROW",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pCOL = m$.newVarRef("pCOL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pVALUE = m$.newVarRef("pVALUE",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update a manual field in the grid
    //<< ;
    //<< ; Params:
    //<< ;  pROW     Grid RowId
    //<< ;  pCOL     Grid ColId
    //<< ;  pValue   Value to set in selected cell
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Oct-2008   HQN     SR15893: Added params details
    //<< ; 24-Nov-2005   JW      SR13883: Store formatted value in REFERENCEVALUE.
    //<< ; 19-Oct-2005   JW      SR11573: Update JS only if displayed. Update WWWDATEN.
    //<< ; 08-Sep-2005   shobby  SR13455:Don't write when redrawing form, YHTMFORM is
    //<< ;                           not defined.
    //<< ; 29-Jun-2005   JW      Added method header
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,refValue
    mVar idField = m$.var("idField");
    mVar refValue = m$.var("refValue");
    m$.newVar(idField,refValue);
    //<< 
    //<< $$$LogR("UpdateManualField",$get(pROW)_","_$get(pCOL)_":"_$get(pVALUE)_":"_$get(pYFORM)_"<")
    $$$LogR(m$,"UpdateManualField",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(pROW),","),m$.Fnc.$get(pCOL)),":"),m$.Fnc.$get(pVALUE)),":"),m$.Fnc.$get(pYFORM)),"<"));
    //<< 
    //<< quit:($get(pROW)="")||($get(pCOL)="")
    if ((mOp.Equal(m$.Fnc.$get(pROW),"")) || (mOp.Equal(m$.Fnc.$get(pCOL),""))) {
      return null;
    }
    //<< 
    //<< if $get(pYFORM) = "" {
    if (mOp.Equal(m$.Fnc.$get(pYFORM),"")) {
      //<< set pYFORM = $$$GRIDName
      pYFORM.set(include.COMGridEdit31Interface.$$$GRIDName(m$));
    }
    //<< }
    //<< set idField = "Y"_pROW_"_"_pCOL
    idField.set(mOp.Concat(mOp.Concat(mOp.Concat("Y",pROW.get()),"_"),pCOL.get()));
    //<< set refValue = $$Format(pCOL,pVALUE)
    refValue.set(m$.fnc$("Format",pCOL.get(),pVALUE.get()));
    //<< 
    //<< set ^WWWDATEN(YM,+$horolog,YUSER,pYFORM,"V",idField,1) = pVALUE
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pYFORM.get(),"V",idField.get(),1).set(pVALUE.get());
    //<< set ^WWWDATEN(YM,+$horolog,YUSER,pYFORM,"V","REFERENCEVALUE",idField,1) = refValue
    m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pYFORM.get(),"V","REFERENCEVALUE",idField.get(),1).set(refValue.get());
    //<< 
    //<< if $$$DisplayedRecord(pROW,pYFORM) {
    if (mOp.Logical(include.COMGridEdit31.$$$DisplayedRecord(m$,pROW,pYFORM))) {
      //<< write "cgeUpdateValue('td"_idField_"','"_refValue_"');"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("cgeUpdateValue('td",idField.get()),"','"),refValue.get()),"');"));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Format(pCOL,pVALUE)
  public Object Format(Object ... _p) {
    mVar pCOL = m$.newVarRef("pCOL",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pVALUE = m$.newVarRef("pVALUE",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Jan-2011   GRF     SR17579: Use explicit tag for WWWTR calls
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 05-Jul-2007   shobby  SR14917: Consider customisation of Input Type
    //<< ; 29-Jun-2005   JW      SR10412: Added space
    //<< ; 14-Mar-2005   PO      SR11349 support FC
    //<< ;-------------------------------------------------------------------------------
    //<< new strValue,YTXT,YTYP
    mVar strValue = m$.var("strValue");
    mVar YTXT = m$.var("YTXT");
    mVar YTYP = m$.var("YTYP");
    m$.newVar(strValue,YTXT,YTYP);
    //<< 
    //<< set YTXT = $$Get^WWW122($get(^CacheTemp(YUSER,"Grid","Name")),pCOL)     ;SR14917
    YTXT.set(m$.fnc$("WWW122.Get",m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")),pCOL.get()));
    //<< set YTYP = $$$WWW122InputType(YTXT)                                     ;SR14917
    YTYP.set(include.WWWConst.$$$WWW122InputType(m$,YTXT));
    //<< if (YTYP=8) && $$$AmountIsFC(pVALUE) && ($$$CurrencyToUse="Foreign") {
    if ((mOp.Equal(YTYP.get(),8)) && mOp.Logical(include.COMSYSNum.$$$AmountIsFC(m$,pVALUE)) && (mOp.Equal(include.COMSYSNum.$$$CurrencyToUse(m$),"Foreign"))) {
      //<< set pVALUE=$$$FCAmount(pVALUE)
      pVALUE.set(include.COMSYSNum.$$$FCAmount(m$,pVALUE));
    }
    //<< }
    //<< set strValue = $$GetLiteral^WWWTR(YTYP,pVALUE)
    strValue.set(m$.fnc$("WWWTR.GetLiteral",YTYP.get(),pVALUE.get()));
    //<< if strValue="" set strValue = "&nbsp;"
    if (mOp.Equal(strValue.get(),"")) {
      strValue.set("&nbsp;");
    }
    //<< 
    //<< quit strValue
    return strValue.get();
  }

  //<< 
  //<< 
  //<< IsSavedLine(pidForm,pidKey="")
  public Object IsSavedLine(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Whether the current line is a saved record or not.
    //<< ;
    //<< ; Params:   pidForm - grid form
    //<< ;           pidKey - key of line
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  boolean
    //<< ;
    //<< ; History:
    //<< ; 26-Nov-2009   DWR     SR17057: rare occasion error <subscript> occuring, check
    //<< ;                           for form name before checking is $data in calss
    //<< ; 08-Nov-2006   PO      SR15201: Enable ability to determine whether particular line is saved.
    //<< ; 25-Oct-2006   JW      BR014279: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnSaved,idClass,strKey
    mVar blnSaved = m$.var("blnSaved");
    mVar idClass = m$.var("idClass");
    mVar strKey = m$.var("strKey");
    m$.newVar(blnSaved,idClass,strKey);
    //<< 
    //<< set blnSaved = $$$NO
    blnSaved.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if pidKey = "" {
    if (mOp.Equal(pidKey.get(),"")) {
      //<< set strKey = $$GetKey()
      strKey.set(m$.fnc$("GetKey"));
    }
    //<< } else {
    else {
      //<< set strKey = pidKey
      strKey.set(pidKey.get());
    }
    //<< }
    //<< if (strKey'="") && (pidForm'="") {   ; SR17057
    if ((mOp.NotEqual(strKey.get(),"")) && (mOp.NotEqual(pidForm.get(),""))) {
      //<< set idClass = $$$GRIDClass(pidForm)
      idClass.set(include.COMGridEdit31.$$$GRIDClass(m$,pidForm));
      //<< if $data($$$DATA(idClass,strKey)) {
      if (mOp.Logical(m$.Fnc.$data(include.COMSYSWWW.$$$DATAVar(m$,idClass,strKey)))) {
        //<< set blnSaved = $$$YES
        blnSaved.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnSaved
    return blnSaved.get();
  }

  //<< 
  //<< 
  //<< SwitchReadOnly(pidLine,pidClassFld,pblnDisabled)
  public Object SwitchReadOnly(Object ... _p) {
    mVar pidLine = m$.newVarRef("pidLine",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidClassFld = m$.newVarRef("pidClassFld",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnDisabled = m$.newVarRef("pblnDisabled",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Switch between read only and editable
    //<< ;
    //<< ; Params:
    //<< ; pidLine      - The id (key) of the Edit Grid Line
    //<< ; pidClassFld  - The class field id of the Edit Grid field  - what if manual field?
    //<< ; pblnDisabled - What state to set the field to
    //<< ;                   $$$YES : Read Only
    //<< ;                   $$$NO  : Editable
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 01-Apr-2009   GRF     Clarify *CLASS* Field # & Disabled switch
    //<< ; 21-Jan-2009   HQN     Corrected argument passing to SwitchReadOnly,
    //<< ;                           JS function incorrectly handled rows and columns
    //<< ; 21-Dec-2006   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCol,idRow
    mVar idCol = m$.var("idCol");
    mVar idRow = m$.var("idRow");
    m$.newVar(idCol,idRow);
    //<< 
    //<< set idRow = $$GetLineId(pidLine)
    idRow.set(m$.fnc$("GetLineId",pidLine.get()));
    //<< set idCol = $$$GetFormField($$$GRIDName,pidClassFld)
    idCol.set(include.COMSYSWWW.$$$GetFormField(m$,include.COMGridEdit31Interface.$$$GRIDName(m$),pidClassFld));
    //<< write "SwitchReadOnly("_idRow_","_idCol_","_pblnDisabled_",'"_YGRIDWHITE_"','"_YGRIDGRAY_"');"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("SwitchReadOnly(",idRow.get()),","),idCol.get()),","),pblnDisabled.get()),",'"),m$.var("YGRIDWHITE").get()),"','"),m$.var("YGRIDGRAY").get()),"');"));
    //<< 
    //<< quit
    return null;
  }

//<< 
//<< 
}
