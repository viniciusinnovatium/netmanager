//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTMENGE
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 20:31:29
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
//<< #include INConst
import include.INConst;
//<< #include %occInclude
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;

//<< INARTMENGE(pidItem,pintBreakDown,pidLocn,pblnReturnAll,penumCalcType,pblnShowConsign,pblnExclBlocked,pidProgram) ; <<< DO NOT USE DIRECT LINK ;SR17034
public class INARTMENGE extends mClass {

  //<< 
  //<< #define enumSingleTotal     0
  public static Object $$$enumSingleTotal(mContext m$) {
    return (0);
  }

  //<< #define enumSeparated       1
  public static Object $$$enumSeparated(mContext m$) {
    return (1);
  }

  //<< #define enumDateSeparation  2
  public static Object $$$enumDateSeparation(mContext m$) {
    return (2);
  }

  //<< 
  //<< #define NoStorageSpecified ""
  public static Object $$$NoStorageSpecified(mContext m$) {
    return ("");
  }

  public Object main(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintBreakDown = m$.newVarRef("pintBreakDown",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnReturnAll = m$.newVarRef("pblnReturnAll",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar penumCalcType = m$.newVarRef("penumCalcType",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pblnShowConsign = m$.newVarRef("pblnShowConsign",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pblnExclBlocked = m$.newVarRef("pblnExclBlocked",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pidProgram = m$.newVarRef("pidProgram",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    return _INARTMENGE(pidItem,pintBreakDown,pidLocn,pblnReturnAll,penumCalcType,pblnShowConsign,pblnExclBlocked,pidProgram);
  }

  public Object _INARTMENGE(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintBreakDown = m$.newVarRef("pintBreakDown",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnReturnAll = m$.newVarRef("pblnReturnAll",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar penumCalcType = m$.newVarRef("penumCalcType",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pblnShowConsign = m$.newVarRef("pblnShowConsign",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pblnExclBlocked = m$.newVarRef("pblnExclBlocked",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pidProgram = m$.newVarRef("pidProgram",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ERRECHNEN MENGE EINES ARTIKELS (CALCULATE QUANTITY OF AN ARTICLE)
    //<< ;
    //<< ; * * *   Call $$GetQty^INARTMENGE() or specific entry   * * *
    //<< ; * * *   wrappers instead of the main routine.          * * *
    //<< ; * * *   Don't call individual calculations unless specifically necessary * * *
    //<< ;
    //<< ; TODO : Change other routines to call subroutine rather than main routine and
    //<< ;        to use Boolean Macros. This is not immediately necessary - calling
    //<< ;        routines have been checked. <GRF>
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumCalcType : The list has been consolidated with the revision to Reservations
    //<< ;                 It is better to use explicit entry points that better describe
    //<< ;                 the operation.
    //<< ;
    //<< ;       0               GetQtyAvailable - use pblnExclBlocked with INVORG override
    //<< ;       1, 2            GetQtyOnHand    - use pblnExclBlocked
    //<< ;       3, 4, 8         GetQtyPlanned   - use pblnExclBlocked
    //<< ;       5               GetQtyBlocked   - (pblnExclBlocked is irrelevant)
    //<< ;       6, 7                 UNSUPPORTED
    //<< ;       9               GetQtyOnHand   (incl Blocked)
    //<< ;       10              GetQtyPlanned  (incl Blocked)
    //<< ;       other           GetQtyAvailable - use pblnExclBlocked
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$GetQty($get(pidItem),$get(pintBreakDown,$$$enumSingleTotal),$get(pidLocn),$get(pblnReturnAll,$$$NO),
    //<< $get(penumCalcType,0),$get(pblnShowConsign,$$$NO),$get(pblnExclBlocked,$$$NO),$get(pidProgram))  ;SR17034
    return m$.fnc$("GetQty",m$.Fnc.$get(pidItem),m$.Fnc.$get(pintBreakDown,$$$enumSingleTotal(m$)),m$.Fnc.$get(pidLocn),m$.Fnc.$get(pblnReturnAll,include.COMSYS.$$$NO(m$)),m$.Fnc.$get(penumCalcType,0),m$.Fnc.$get(pblnShowConsign,include.COMSYS.$$$NO(m$)),m$.Fnc.$get(pblnExclBlocked,include.COMSYS.$$$NO(m$)),m$.Fnc.$get(pidProgram));
  }

  //<< 
  //<< 
  //<< QtyForAvgCost(pidItem="",pidLocn="")                                    ; DEPRECATED
  public Object QtyForAvgCost(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By :
    //<< ;   INARTAVG
    //<< ;   INARTHIST
    //<< ;
    //<< ; History :
    //<< ; 30-Oct-2009   GRF     SR16871: DEPRECATED - Use QtyForCC
    //<< ;
    //<< ; 14-Sep-2009   PPP     SR16888: Updated to get the Entity Qty
    //<< ; 18-Dec-2006   GRF     SR15312: Create as explicit tag
    //<< ;-------------------------------------------------------------------------------
    //<< //quit $$GetQty(pidItem,$$$enumSingleTotal,pidLocn,$$$NO,9,$$$NO,$$$NO)
    //<< quit $$EntityQty(pidItem,pidLocn)
    return m$.fnc$("EntityQty",pidItem.get(),pidLocn.get());
  }

  //<< 
  //<< 
  //<< EntityQty(pidItem,pidSiteLocn)
  public Object EntityQty(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidSiteLocn = m$.newVarRef("pidSiteLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; The total Quantity for all Locations that are children of an Entity
    //<< ; The input is any Location - of any Type
    //<< ; 1. the routines goes up the hierarchy of Locations and finds the first Entity
    //<< ; 2. Then for each child of the Entity, the QOH is added
    //<< ;
    //<< ;                           Locn XXX (Top Level Entity)
    //<< ;                                      |
    //<< ;                           Locn YYY (Mid Level Entity)
    //<< ;                                      |
    //<< ;                    --------------------------------------
    //<< ;                    |                                    |
    //<< ;      Locn ABC (Bottom Level Entity)       Locn BCD (Bottom Level Entity)
    //<< ;                    |                                    |
    //<< ;        -------------------------              -----------------------
    //<< ;        |                       |              |                     |
    //<< ;  Locn A (Site)           Locn B (Site)    Locn C  (Site)      Locn D (Site)
    //<< ;        |                       |
    //<< ; ---------------         ---------------
    //<< ; |             |         |             |
    //<< ; Dep X        Dep Y     Dep Z        Dep C
    //<< ;
    //<< ;
    //<< ; e.g.
    //<< ; 1) input = Dep X ; SOH includes Dep X, Dep Y, Dep Z, Dep C, Loc A, Loc B
    //<< ; 2) input = Loc C ; SOH includes Loc C, Loc D
    //<< ;
    //<< ; Called By :
    //<< ;   INARTAVG
    //<< ;   INARTHIST
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Sep-2009   PPP     SR16892: Bug fix for Entity and Children
    //<< ; 11-Sep-2009   PPP     SR16888: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrLocns,fltQty,idEntity,idLocn
    mVar arrLocns = m$.var("arrLocns");
    mVar fltQty = m$.var("fltQty");
    mVar idEntity = m$.var("idEntity");
    mVar idLocn = m$.var("idLocn");
    m$.newVar(arrLocns,fltQty,idEntity,idLocn);
    //<< 
    //<< set fltQty = 0
    fltQty.set(0);
    //<< 
    //<< if $get(pidSiteLocn)="" {
    if (mOp.Equal(m$.Fnc.$get(pidSiteLocn),"")) {
      //<< set pidSiteLocn = $get(YLOCATION)
      pidSiteLocn.set(m$.Fnc.$get(m$.var("YLOCATION")));
    }
    //<< }
    //<< 
    //<< if pidSiteLocn'="" {     ; Get the Sub Entity for the Current Location
    if (mOp.NotEqual(pidSiteLocn.get(),"")) {
      //<< set idEntity = $$SubEntity^WWW0121Utils(0,pidSiteLocn)
      idEntity.set(m$.fnc$("WWW0121Utils.SubEntity",0,pidSiteLocn.get()));
      //<< 
      //<< if idEntity'="" {    ; Get the children for the Entity
      if (mOp.NotEqual(idEntity.get(),"")) {
        //<< do Children^WWW0121Utils(0,idEntity,,1,"Cache",.arrLocns)
        m$.Cmd.Do("WWW0121Utils.Children",0,idEntity.get(),null,1,"Cache",arrLocns);
        //<< 
        //<< set idLocn = ""
        idLocn.set("");
        //<< for {
        for (;true;) {
          //<< set idLocn = $order(arrLocns(idLocn))
          idLocn.set(m$.Fnc.$order(arrLocns.var(idLocn.get())));
          //<< quit:idLocn=""
          if (mOp.Equal(idLocn.get(),"")) {
            break;
          }
          //<< continue:'$$$WWW0121StorageLocn($get(^WWW0121(0,0,idLocn,1)))  ; Not an Inventory Location
          if (mOp.Not(include.WWWConst.$$$WWW0121StorageLocn(m$,m$.Fnc.$get(m$.var("^WWW0121",0,0,idLocn.get(),1))))) {
            continue;
          }
          //<< 
          //<< set fltQty = fltQty + $$GetQty(pidItem,$$$enumSingleTotal,idLocn,$$$NO,9,$$$NO,$$$NO)
          fltQty.set(mOp.Add(fltQty.get(),m$.fnc$("GetQty",pidItem.get(),$$$enumSingleTotal(m$),idLocn.get(),include.COMSYS.$$$NO(m$),9,include.COMSYS.$$$NO(m$),include.COMSYS.$$$NO(m$))));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit fltQty
    return fltQty.get();
  }

  //<< 
  //<< 
  //<< QtyForCC(pidItem,pidCostCentre)
  public Object QtyForCC(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidCostCentre = m$.newVarRef("pidCostCentre",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return the total quantity for all locations within a cost centre
    //<< ;
    //<< ; History:
    //<< ; 19-Oct-2009   GRF     SR16871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new fltQty,idLocn
    mVar fltQty = m$.var("fltQty");
    mVar idLocn = m$.var("idLocn");
    m$.newVar(fltQty,idLocn);
    //<< 
    //<< set fltQty = 0
    fltQty.set(0);
    //<< set idLocn = ""
    idLocn.set("");
    //<< for {
    for (;true;) {
      //<< set idLocn = $order(^INCCLocation(0,pidCostCentre,idLocn))
      idLocn.set(m$.Fnc.$order(m$.var("^INCCLocation",0,pidCostCentre.get(),idLocn.get())));
      //<< quit:idLocn=""
      if (mOp.Equal(idLocn.get(),"")) {
        break;
      }
      //<< 
      //<< set fltQty = fltQty + $$GetQty(pidItem,$$$enumSingleTotal,idLocn,$$$NO,9,$$$NO,$$$NO)
      fltQty.set(mOp.Add(fltQty.get(),m$.fnc$("GetQty",pidItem.get(),$$$enumSingleTotal(m$),idLocn.get(),include.COMSYS.$$$NO(m$),9,include.COMSYS.$$$NO(m$),include.COMSYS.$$$NO(m$))));
    }
    //<< }
    //<< quit fltQty
    return fltQty.get();
  }

  //<< 
  //<< 
  //<< AvailQtyByLocn(pidItem="",pidSiteLocn="")
  public Object AvailQtyByLocn(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidSiteLocn = m$.newVarRef("pidSiteLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; ENTRY POINT : Stock available for sourcing - exclude reserved stock,
    //<< ;               stock in blocked storages (and expired stock?)
    //<< ;               broken down by storage
    //<< ;
    //<< ; Called By :
    //<< ;
    //<< ; Returns:  TotalQty#SLQty*Storage;SLQty*Storage;...   or
    //<< ;           0
    //<< ;
    //<< ; History :
    //<< ; 16-Nov-2007   GRF/LB  SR15598: Create as explicit tag; remove obsolete version
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$GetQty(pidItem,$$$enumSeparated,pidSiteLocn,$$$NO,0,$$$YES,$$$YES)
    return m$.fnc$("GetQty",pidItem.get(),$$$enumSeparated(m$),pidSiteLocn.get(),include.COMSYS.$$$NO(m$),0,include.COMSYS.$$$YES(m$),include.COMSYS.$$$YES(m$));
  }

  //<< 
  //<< 
  //<< AvailToPromise(pidItem="",pidSiteLocn="")
  public Object AvailToPromise(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidSiteLocn = m$.newVarRef("pidSiteLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; ENTRY POINT : Stock available for sourcing - exclude reserved stock,
    //<< ;               stock in blocked storages (and expired stock?)
    //<< ;               broken down by storage
    //<< ;
    //<< ; Called By :   INDRPRUN (setting ATPMENGE)
    //<< ;               INATP1 (equivalent)
    //<< ;
    //<< ; Returns:  TotalQty
    //<< ;
    //<< ; History :
    //<< ; 28-May-2008   GRF     SR15776: Create as explicit tag
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$GetQty(pidItem,$$$enumSingleTotal,pidSiteLocn,$$$NO,0,$$$NO,$$$YES)
    return m$.fnc$("GetQty",pidItem.get(),$$$enumSingleTotal(m$),pidSiteLocn.get(),include.COMSYS.$$$NO(m$),0,include.COMSYS.$$$NO(m$),include.COMSYS.$$$YES(m$));
  }

  //<< 
  //<< ; FIXME : <GRF> Should we be able to promise consignment stock as well as our own?
  //<< 
  //<< 
  //<< MovingStockByLocn(pidItem="",pidSiteLocn="")
  public Object MovingStockByLocn(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidSiteLocn = m$.newVarRef("pidSiteLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; ENTRY POINT : Stock available for moving
    //<< ;               INCLUDES on hand with blocked storages
    //<< ;               excludes reserved stock (and expired stock?)
    //<< ;               broken down by storage
    //<< ;
    //<< ; Called By :
    //<< ;
    //<< ; Returns:  TotalQty#SLQty*Storage;SLQty*Storage;...   or
    //<< ;           0
    //<< ;
    //<< ; History :
    //<< ; 07-Dec-2007   GRF     Entry point for type 11 - equivalent to type 0 but
    //<< ;                           includes blocked storages
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$GetQty(pidItem,$$$enumSeparated,pidSiteLocn,$$$NO,11,$$$YES,$$$NO)
    return m$.fnc$("GetQty",pidItem.get(),$$$enumSeparated(m$),pidSiteLocn.get(),include.COMSYS.$$$NO(m$),11,include.COMSYS.$$$YES(m$),include.COMSYS.$$$NO(m$));
  }

  //<< 
  //<< 
  //<< GetBundleQty(pidBundleStock,&pstrStatus)
  public Object GetBundleQty(Object ... _p) {
    mVar pidBundleStock = m$.newVarRef("pidBundleStock",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrStatus = m$.newVarRef("pstrStatus",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Inputs : pidBundleStock   e.g. SI01||LOCA||BIN2||2||1000
    //<< ;                            (Item||Locn||Storage||Bundle where Bundle = 2||1000)
    //<< ;
    //<< ; ByRef : pstrStatus
    //<< ;
    //<< ; History:
    //<< ; 18-Mar-2011   PPP     SRAdhoc: Pablo - need to ensure strStatus is set to OK if OK
    //<< ; 23-Sep-2010   GRF     SR17539: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new fltQtyOH,objBS,sc
    mVar fltQtyOH = m$.var("fltQtyOH");
    mVar objBS = m$.var("objBS");
    mVar sc = m$.var("sc");
    m$.newVar(fltQtyOH,objBS,sc);
    //<< 
    //<< set fltQtyOH = 0
    fltQtyOH.set(0);
    //<< set objBS = ##class(alSOH.dBundleStock).%OpenId(pidBundleStock,.sc)
    objBS.set(m$.fnc$("alSOH.dBundleStock.$OpenId",pidBundleStock.get(),sc));
    //<< if $$$ISERR(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
      //<< set pstrStatus = $$ISStatusToDLStatus^COMUtilError(sc)
      pstrStatus.set(m$.fnc$("COMUtilError.ISStatusToDLStatus",sc.get()));
    }
    //<< 
    //<< } else {
    else {
      //<< if objBS'=$$$NULLOREF set fltQtyOH = +objBS.QtyOnHand
      if (mOp.NotEqual(objBS.get(),include.$occConstant.$$$NULLOREF(m$))) {
        fltQtyOH.set(mOp.Positive(m$.prop(objBS.get(),"QtyOnHand").get()));
      }
      //<< set pstrStatus = $$$OK  //SRAdhoc
      pstrStatus.set(include.COMSYS.$$$OK(m$));
    }
    //<< }
    //<< quit fltQtyOH
    return fltQtyOH.get();
  }

  //<< 
  //<< 
  //<< GetQty(pidItem="",pintBreakDown=$$$enumSingleTotal,pidSiteLocn="",pblnReturnAll=$$$NO,
  //<< penumCalcType=0,pblnShowConsign=$$$NO,pblnExclBlocked=$$$NO,pidProgram="")  ;17034
  public Object GetQty(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintBreakDown = m$.newVarRef("pintBreakDown",(((_p!=null)&&(_p.length>=2))?_p[1]:null),$$$enumSingleTotal(m$));
    mVar pidSiteLocn = m$.newVarRef("pidSiteLocn",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnReturnAll = m$.newVarRef("pblnReturnAll",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    mVar penumCalcType = m$.newVarRef("penumCalcType",(((_p!=null)&&(_p.length>=5))?_p[4]:null),0);
    mVar pblnShowConsign = m$.newVarRef("pblnShowConsign",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$NO(m$));
    mVar pblnExclBlocked = m$.newVarRef("pblnExclBlocked",(((_p!=null)&&(_p.length>=7))?_p[6]:null),include.COMSYS.$$$NO(m$));
    mVar pidProgram = m$.newVarRef("pidProgram",(((_p!=null)&&(_p.length>=8))?_p[7]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Lookup quantities from V2 SOH records
    //<< ;
    //<< ; Inputs:
    //<< ; pintBreakDown     0  = Single total
    //<< ;                 1/2  = Breakdown by Storage - see "Returns" below
    //<< ;                     1 = accumulated by storage                (RETVAL=TOTALQTY#QTY1*STORAGE1;QTY2*STORAGE2;...)
    //<< ;                     2 = separated by storage / receiving date (RETVAL=TOTALQTY#QTY1*STORAGE1*DATE1;QTY2*STORAGE2*DATE2;...)
    //<< ;
    //<< ; pidSiteLocn       Specify a single location or set to null if wish to see all.
    //<< ;                   This will be subject to system parameter 218 [ViewStockFromAllLocations])
    //<< ;                   Which determines whether stock details for one location are
    //<< ;                   accessible by other locations.
    //<< ;
    //<< ; pblnReturnAll     $$$YES      Return All (Don't check Parameter 218)
    //<< ;                   $$$NO       Return All or single location depending on 218.
    //<< ;
    //<< ; pblnShowConsign   $$$YES  Include Consignment Stock    ; TODO : Not implemented under V2 yet - see INWE D60?
    //<< ;
    //<< ; pblnExclBlocked   $$$YES  Don't include blocked storages or expired stock
    //<< ;                           (overwritten by INVORG D157)
    //<< ;
    //<< ; pidProgram        ""      will use different SQL to find only those
    //<< ;                           items that have a relevant Bundle property.
    //<< ;
    //<< ; History:
    //<< ; 24-Feb-2010   GRF     SR17034: use $$$NoStorageSpecified for clarity
    //<< ; 09-Dec-2009   shobby  SR17034: Passed in an additional parameter, pidProgram.
    //<< ; 12-Nov-2009   GRF     further to 17-Dec-2008 change - $$$YES/$$$NO passed in
    //<< ;                           changed to enum macros; removed AvgCost macro - "9"
    //<< ;                           is QtyOnHand instead
    //<< ; 17-Dec-2008   FIS     SRBR014564: changed pintBreakDown from $$$NO to 0 as it
    //<< ;                           is not boolean
    //<< ; 13-Oct-2008   PPP     SR16029 - Replaced the original checks for Locn definition.
    //<< ;                           However it does not look right, but we have to keep
    //<< ;                           it the same as before for backward compatibility -
    //<< ;                           pblnReturnAll is actually a boolean to check if the
    //<< ;                           view locations check should be applied rather
    //<< ;                           than the what it suggests ie return all locations.
    //<< ; 01-Oct-2008   HQN     Removing support for penumCalcType 6/7 from defaulting
    //<< ; 17-Sep-2008   HQN     SR15861: Moved logic into alSOH.iUSOH:::GetQtyOnHand()
    //<< ; 16-Sep-2008   HQN     SR15861: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objINVORG,Qty,QtyOnHand,strSQL
    mVar objINVORG = m$.var("objINVORG");
    mVar Qty = m$.var("Qty");
    mVar QtyOnHand = m$.var("QtyOnHand");
    mVar strSQL = m$.var("strSQL");
    m$.newVar(objINVORG,Qty,QtyOnHand,strSQL);
    //<< 
    //<< if $get(Y)="" do ^WWWVAR            ; SR12738
    if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< 
    //<< ;---------------------------------------
    //<< set Qty = 0
    Qty.set(0);
    //<< if pidItem="" quit Qty
    if (mOp.Equal(pidItem.get(),"")) {
      return Qty.get();
    }
    //<< ;---------------------------------------
    //<< 
    //<< set QtyOnHand = 0
    QtyOnHand.set(0);
    //<< set objINVORG = $get(^INVORG(YM,YM,1))
    objINVORG.set(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)));
    //<< 
    //<< // no location set: Either trying to retrieve single location or all locations but overide says you can't
    //<< if (pidSiteLocn="") && 'pblnReturnAll && (+$$$INVORGViewStockFromAllLocations(objINVORG)=$$$NO) {
    if ((mOp.Equal(pidSiteLocn.get(),"")) && mOp.Not(pblnReturnAll.get()) && (mOp.Equal(mOp.Positive(include.INConst.$$$INVORGViewStockFromAllLocations(m$,objINVORG)),include.COMSYS.$$$NO(m$)))) {
      //<< set pidSiteLocn = $get(YLOCATION)
      pidSiteLocn.set(m$.Fnc.$get(m$.var("YLOCATION")));
    }
    //<< }
    //<< 
    //<< 
    //<< /*
    //<< ClassMethod GetQtyOnHand   (pidItem As alINV.dItem, pidLocn As alLOC.dLocation = "", pidStorage As alLOC.dStorage = "", pblnExclBlocked As %Boolean = 1) As %Float [ CodeMode = expression ]
    //<< ClassMethod GetQtyAvailable(pidItem As alINV.dItem, pidLocn As alLOC.dLocation = "", pidStorage As alLOC.dStorage = "", pblnExclBlocked As %Boolean = 1, pidProgram As %String = "") As %Float [ CodeMode = expression ]
    //<< ClassMethod GetQtyPlanned  (pidItem As alINV.dItem, pidLocn As alLOC.dLocation = "", pidStorage As alLOC.dStorage = "", pblnExclBlocked As %Boolean = 1) As %Float [ CodeMode = expression ]
    //<< ClassMethod GetQtyBlocked  (pidItem As alINV.dItem, pidLocn As alLOC.dLocation = "", pidStorage As alLOC.dStorage = "", pblnExclBlocked As %Boolean = 1) As %Float [ CodeMode = expression ]
    //<< */
    //<< 
    //<< ; If no breakdown, probably more efficient to do SQL SUM() queries
    //<< if pintBreakDown = $$$enumSingleTotal {
    if (mOp.Equal(pintBreakDown.get(),$$$enumSingleTotal(m$))) {
      //<< ; need to remove sourced and reserved quantity from this
      //<< if penumCalcType = 0 {
      if (mOp.Equal(penumCalcType.get(),0)) {
        //<< if +$$$INVORGStockLocnProductionBlock(objINVORG)=$$$YES set pblnExclBlocked = $$$YES   ; (D157)
        if (mOp.Equal(mOp.Positive(include.INConst.$$$INVORGStockLocnProductionBlock(m$,objINVORG)),include.COMSYS.$$$YES(m$))) {
          pblnExclBlocked.set(include.COMSYS.$$$YES(m$));
        }
        //<< set Qty = ##class(alSOH.iSOH).GetQtyAvailable(pidItem,pidSiteLocn,$$$NoStorageSpecified,pblnExclBlocked,pidProgram) ;SR17034
        Qty.set(m$.fnc$("alSOH.iSOH.GetQtyAvailable",pidItem.get(),pidSiteLocn.get(),$$$NoStorageSpecified(m$),pblnExclBlocked.get(),pidProgram.get()));
      }
      //<< 
      //<< } elseif (penumCalcType = 1) || (penumCalcType = 2) {
      else if ((mOp.Equal(penumCalcType.get(),1)) || (mOp.Equal(penumCalcType.get(),2))) {
        //<< set Qty = ##class(alSOH.iSOH).GetQtyOnHand(pidItem,pidSiteLocn,$$$NoStorageSpecified,pblnExclBlocked)
        Qty.set(m$.fnc$("alSOH.iSOH.GetQtyOnHand",pidItem.get(),pidSiteLocn.get(),$$$NoStorageSpecified(m$),pblnExclBlocked.get()));
      }
      //<< 
      //<< } elseif (penumCalcType = 3) || (penumCalcType = 4) || (penumCalcType = 8) {
      else if ((mOp.Equal(penumCalcType.get(),3)) || (mOp.Equal(penumCalcType.get(),4)) || (mOp.Equal(penumCalcType.get(),8))) {
        //<< set Qty = ##class(alSOH.iSOH).GetQtyPlanned(pidItem,pidSiteLocn,$$$NoStorageSpecified,pblnExclBlocked)
        Qty.set(m$.fnc$("alSOH.iSOH.GetQtyPlanned",pidItem.get(),pidSiteLocn.get(),$$$NoStorageSpecified(m$),pblnExclBlocked.get()));
      }
      //<< 
      //<< } elseif penumCalcType = 5 {
      else if (mOp.Equal(penumCalcType.get(),5)) {
        //<< set Qty = ##class(alSOH.iSOH).GetQtyBlocked(pidItem,pidSiteLocn,$$$NoStorageSpecified,pblnExclBlocked)
        Qty.set(m$.fnc$("alSOH.iSOH.GetQtyBlocked",pidItem.get(),pidSiteLocn.get(),$$$NoStorageSpecified(m$),pblnExclBlocked.get()));
      }
      //<< 
      //<< } elseif (penumCalcType = 9) {
      else if ((mOp.Equal(penumCalcType.get(),9))) {
        //<< set Qty = ##class(alSOH.iSOH).GetQtyOnHand(pidItem,pidSiteLocn,$$$NoStorageSpecified,$$$NO)
        Qty.set(m$.fnc$("alSOH.iSOH.GetQtyOnHand",pidItem.get(),pidSiteLocn.get(),$$$NoStorageSpecified(m$),include.COMSYS.$$$NO(m$)));
      }
      //<< 
      //<< } elseif penumCalcType = 10 {
      else if (mOp.Equal(penumCalcType.get(),10)) {
        //<< set Qty = ##class(alSOH.iSOH).GetQtyBlocked(pidItem,pidSiteLocn,$$$NoStorageSpecified,$$$NO)
        Qty.set(m$.fnc$("alSOH.iSOH.GetQtyBlocked",pidItem.get(),pidSiteLocn.get(),$$$NoStorageSpecified(m$),include.COMSYS.$$$NO(m$)));
      }
      //<< 
      //<< } elseif (penumCalcType = 6) || (penumCalcType = 7) {
      else if ((mOp.Equal(penumCalcType.get(),6)) || (mOp.Equal(penumCalcType.get(),7))) {
        //<< set Qty = $$$MakeStatus("UNSUPPORTED AT THIS TIME")
        Qty.set(include.COMSYS.$$$MakeStatus(m$,"UNSUPPORTED AT THIS TIME"));
      }
      //<< 
      //<< } else {
      else {
        //<< set Qty = ##class(alSOH.iSOH).GetQtyAvailable(pidItem,pidSiteLocn,$$$NoStorageSpecified,pblnExclBlocked,pidProgram) ;SR17034
        Qty.set(m$.fnc$("alSOH.iSOH.GetQtyAvailable",pidItem.get(),pidSiteLocn.get(),$$$NoStorageSpecified(m$),pblnExclBlocked.get(),pidProgram.get()));
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set Qty = $$GetQtyBreakDown(pidItem,pintBreakDown,pidSiteLocn,pblnReturnAll,penumCalcType,pblnShowConsign,pblnExclBlocked)
      Qty.set(m$.fnc$("GetQtyBreakDown",pidItem.get(),pintBreakDown.get(),pidSiteLocn.get(),pblnReturnAll.get(),penumCalcType.get(),pblnShowConsign.get(),pblnExclBlocked.get()));
    }
    //<< }
    //<< quit Qty
    return Qty.get();
  }

  //<< 
  //<< 
  //<< GetStockStorages(pidItem,pidLocation="")
  public Object GetStockStorages(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return
    //<< ;   List of storages containing stock for this item
    //<< ;
    //<< ; History:
    //<< ; 19-Sep-2008   HQN SR15861: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new lstStorages,idStorage,SQLCODE
    mVar lstStorages = m$.var("lstStorages");
    mVar idStorage = m$.var("idStorage");
    mVar SQLCODE = m$.var("SQLCODE");
    m$.newVar(lstStorages,idStorage,SQLCODE);
    //<< 
    //<< set lstStorages = ""
    lstStorages.set("");
    //<< set idStorage   = ""
    idStorage.set("");
    //<< set SQLCODE     = 0
    SQLCODE.set(0);
    //<< if pidLocation = "" {
    if (mOp.Equal(pidLocation.get(),"")) {
      //<< ; Get valid storages
      //<< &sql(DECLARE storagecursor01 CURSOR FOR
      //<< SELECT DISTINCT Storage INTO :idStorage
      //<< FROM alSOH.dBundleStock
      //<< WHERE Item=:pidItem
      //<< )
      m$.Cmd.SQL();
      //<< &sql(OPEN storagecursor01)
      m$.Cmd.SQL();
      //<< &sql(FETCH storagecursor01)
      m$.Cmd.SQL();
      //<< while SQLCODE = 0 {
      while (mOp.Equal(SQLCODE.get(),0)) {
        //<< set lstStorages = lstStorages_$lb(idStorage)
        lstStorages.set(mOp.Concat(lstStorages.get(),m$.Fnc.$listbuild(idStorage.get())));
        //<< &sql(FETCH storagecursor01)
        m$.Cmd.SQL();
      }
      //<< }
      //<< &sql(CLOSE storagecursor01)
      m$.Cmd.SQL();
    }
    //<< 
    //<< } else {
    else {
      //<< &sql(DECLARE storagecursor02 CURSOR FOR
      //<< SELECT DISTINCT Storage INTO :idStorage
      //<< FROM alSOH.dBundleStock
      //<< WHERE
      //<< Item=:pidItem AND
      //<< Storage->Location=:pidLocation
      //<< )
      m$.Cmd.SQL();
      //<< &sql(OPEN storagecursor02)
      m$.Cmd.SQL();
      //<< &sql(FETCH storagecursor02)
      m$.Cmd.SQL();
      //<< while SQLCODE = 0 {
      while (mOp.Equal(SQLCODE.get(),0)) {
        //<< set lstStorages = lstStorages_$lb(idStorage)
        lstStorages.set(mOp.Concat(lstStorages.get(),m$.Fnc.$listbuild(idStorage.get())));
        //<< &sql(FETCH storagecursor02)
        m$.Cmd.SQL();
      }
      //<< }
      //<< &sql(CLOSE storagecursor02)
      m$.Cmd.SQL();
    }
    //<< }
    //<< quit lstStorages
    return lstStorages.get();
  }

  //<< 
  //<< 
  //<< GetQtyBreakDown(pidItem,pintBreakDown,pidSiteLocn="",pblnReturnAll=$$$NO,penumCalcType="",pblnShowConsign=$$$NO,pblnExclBlocked=$$$NO)
  public Object GetQtyBreakDown(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintBreakDown = m$.newVarRef("pintBreakDown",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidSiteLocn = m$.newVarRef("pidSiteLocn",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnReturnAll = m$.newVarRef("pblnReturnAll",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    mVar penumCalcType = m$.newVarRef("penumCalcType",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pblnShowConsign = m$.newVarRef("pblnShowConsign",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$NO(m$));
    mVar pblnExclBlocked = m$.newVarRef("pblnExclBlocked",(((_p!=null)&&(_p.length>=7))?_p[6]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns :
    //<< ;   Quantity    if pintBreakDown = $$$enumSingleTotal      [0]   Handled elsewhere
    //<< ;                                           TotalQty
    //<< ;
    //<< ;               if pintBreakDown = $$$enumSeparated         [1]
    //<< ;                   if Qty=0                TotalQty
    //<< ;                   if Qty'=0               TotalQty#SLQty*StorageId;SLQty*StorageId;...
    //<< ;
    //<< ;               if pintBreakDown = $$$enumDateSeparation   [2]           //BR014564
    //<< ;                   if Qty=0                TotalQty
    //<< ;                   if Qty'=0               TotalQty#SLQty*StorageId*BundleId;SLQty*StorageId*BundleId;...
    //<< ;
    //<< ; History:
    //<< ; 31-Aug-2010   GRF     -: Spelling (enumSeparated)
    //<< ; 12-Nov-2009   GRF     SR16871: Location associated with storage will not be
    //<< ;                           pidSiteLocn if asking for all sites with null value;
    //<< ;                           use blnShow to identify where matching +ve and -ve
    //<< ; 08-Oct-2008   HQN     SR16006: Removed DEPRECATED direct SQL, utilising looped
    //<< ;                           queries via iSOH
    //<< ; 19-Sep-2008   HQN     SR15861: Implemented for penumCalcType 1->4
    //<< ; 17-Sep-2008   HQN     SR15861: Implemented embedded sql for (penumCalcType=0
    //<< ;                           && pidSiteLocn="")
    //<< ;-------------------------------------------------------------------------------
    //<< new arrQty,blnShow,fltQtyOnHand,fltQuantity,idBundle,idLocn,idStorage
    mVar arrQty = m$.var("arrQty");
    mVar blnShow = m$.var("blnShow");
    mVar fltQtyOnHand = m$.var("fltQtyOnHand");
    mVar fltQuantity = m$.var("fltQuantity");
    mVar idBundle = m$.var("idBundle");
    mVar idLocn = m$.var("idLocn");
    mVar idStorage = m$.var("idStorage");
    m$.newVar(arrQty,blnShow,fltQtyOnHand,fltQuantity,idBundle,idLocn,idStorage);
    //<< new lstStorages,loop,objINVORG,strPairs,SQLCODE
    mVar lstStorages = m$.var("lstStorages");
    mVar loop = m$.var("loop");
    mVar objINVORG = m$.var("objINVORG");
    mVar strPairs = m$.var("strPairs");
    mVar SQLCODE = m$.var("SQLCODE");
    m$.newVar(lstStorages,loop,objINVORG,strPairs,SQLCODE);
    //<< 
    //<< set fltQuantity  = 0
    fltQuantity.set(0);
    //<< set fltQtyOnHand = 0
    fltQtyOnHand.set(0);
    //<< set SQLCODE      = 0
    SQLCODE.set(0);
    //<< set idStorage    = ""
    idStorage.set("");
    //<< set idBundle     = ""
    idBundle.set("");
    //<< set blnShow      = $$$NO
    blnShow.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set objINVORG = $get(^INVORG(0,0,1))
    objINVORG.set(m$.Fnc.$get(m$.var("^INVORG",0,0,1)));
    //<< if (pidSiteLocn="") && 'pblnReturnAll && (+$$$INVORGViewStockFromAllLocations(objINVORG)=$$$NO) {
    if ((mOp.Equal(pidSiteLocn.get(),"")) && mOp.Not(pblnReturnAll.get()) && (mOp.Equal(mOp.Positive(include.INConst.$$$INVORGViewStockFromAllLocations(m$,objINVORG)),include.COMSYS.$$$NO(m$)))) {
      //<< set pidSiteLocn=$get(YLOCATION)
      pidSiteLocn.set(m$.Fnc.$get(m$.var("YLOCATION")));
    }
    //<< }
    //<< 
    //<< set lstStorages = $$GetStockStorages(pidItem,pidSiteLocn)
    lstStorages.set(m$.fnc$("GetStockStorages",pidItem.get(),pidSiteLocn.get()));
    //<< 
    //<< if penumCalcType = 0 {
    if (mOp.Equal(penumCalcType.get(),0)) {
      //<< if +$$$INVORGStockLocnProductionBlock(objINVORG)=$$$YES set pblnExclBlocked = $$$YES
      if (mOp.Equal(mOp.Positive(include.INConst.$$$INVORGStockLocnProductionBlock(m$,objINVORG)),include.COMSYS.$$$YES(m$))) {
        pblnExclBlocked.set(include.COMSYS.$$$YES(m$));
      }
      //<< for loop=1:1:$listlength(lstStorages) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(lstStorages.get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idStorage = $list(lstStorages,loop)
        idStorage.set(m$.Fnc.$list(lstStorages.get(),loop.get()));
        //<< set idLocn    = $piece(idStorage,"||",1)
        idLocn.set(m$.Fnc.$piece(idStorage.get(),"||",1));
        //<< if pintBreakDown = $$$enumSeparated {
        if (mOp.Equal(pintBreakDown.get(),$$$enumSeparated(m$))) {
          //<< set arrQty(idStorage) = ##class(alSOH.iSOH).GetQtyAvailable(pidItem,idLocn,idStorage,pblnExclBlocked)
          arrQty.var(idStorage.get()).set(m$.fnc$("alSOH.iSOH.GetQtyAvailable",pidItem.get(),idLocn.get(),idStorage.get(),pblnExclBlocked.get()));
          //<< set fltQuantity = fltQuantity + arrQty(idStorage)
          fltQuantity.set(mOp.Add(fltQuantity.get(),arrQty.var(idStorage.get()).get()));
          //<< if arrQty(idStorage) set blnShow = $$$YES
          if (mOp.Logical(arrQty.var(idStorage.get()).get())) {
            blnShow.set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< 
        //<< } else {
        else {
          //<< set fltQuantity = $$$MakeStatus("UNSUPPORTED AT THIS TIME")
          fltQuantity.set(include.COMSYS.$$$MakeStatus(m$,"UNSUPPORTED AT THIS TIME"));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< } elseif (penumCalcType = 1) || (penumCalcType = 2) {
    else if ((mOp.Equal(penumCalcType.get(),1)) || (mOp.Equal(penumCalcType.get(),2))) {
      //<< for loop=1:1:$listlength(lstStorages) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(lstStorages.get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idStorage = $list(lstStorages,loop)
        idStorage.set(m$.Fnc.$list(lstStorages.get(),loop.get()));
        //<< set idLocn    = $piece(idStorage,"||",1)
        idLocn.set(m$.Fnc.$piece(idStorage.get(),"||",1));
        //<< if pintBreakDown = $$$enumSeparated {
        if (mOp.Equal(pintBreakDown.get(),$$$enumSeparated(m$))) {
          //<< set arrQty(idStorage) = ##class(alSOH.iSOH).GetQtyOnHand(pidItem,idLocn,idStorage,pblnExclBlocked)
          arrQty.var(idStorage.get()).set(m$.fnc$("alSOH.iSOH.GetQtyOnHand",pidItem.get(),idLocn.get(),idStorage.get(),pblnExclBlocked.get()));
          //<< set fltQuantity = fltQuantity + arrQty(idStorage)
          fltQuantity.set(mOp.Add(fltQuantity.get(),arrQty.var(idStorage.get()).get()));
          //<< if arrQty(idStorage) set blnShow = $$$YES
          if (mOp.Logical(arrQty.var(idStorage.get()).get())) {
            blnShow.set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< } else {
        else {
          //<< set fltQuantity = $$$MakeStatus("UNSUPPORTED AT THIS TIME")
          fltQuantity.set(include.COMSYS.$$$MakeStatus(m$,"UNSUPPORTED AT THIS TIME"));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< 
    //<< } elseif (penumCalcType = 3) || (penumCalcType = 4) || (penumCalcType = 8) {
    else if ((mOp.Equal(penumCalcType.get(),3)) || (mOp.Equal(penumCalcType.get(),4)) || (mOp.Equal(penumCalcType.get(),8))) {
      //<< for loop=1:1:$listlength(lstStorages) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(lstStorages.get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idStorage = $list(lstStorages,loop)
        idStorage.set(m$.Fnc.$list(lstStorages.get(),loop.get()));
        //<< set idLocn    = $piece(idStorage,"||",1)
        idLocn.set(m$.Fnc.$piece(idStorage.get(),"||",1));
        //<< if pintBreakDown = $$$enumSeparated {
        if (mOp.Equal(pintBreakDown.get(),$$$enumSeparated(m$))) {
          //<< set arrQty(idStorage) = ##class(alSOH.iSOH).GetQtyPlanned(pidItem,idLocn,idStorage,pblnExclBlocked)
          arrQty.var(idStorage.get()).set(m$.fnc$("alSOH.iSOH.GetQtyPlanned",pidItem.get(),idLocn.get(),idStorage.get(),pblnExclBlocked.get()));
          //<< set fltQuantity = fltQuantity + arrQty(idStorage)
          fltQuantity.set(mOp.Add(fltQuantity.get(),arrQty.var(idStorage.get()).get()));
          //<< if arrQty(idStorage) set blnShow = $$$YES
          if (mOp.Logical(arrQty.var(idStorage.get()).get())) {
            blnShow.set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< } else {
        else {
          //<< set fltQuantity = $$$MakeStatus("UNSUPPORTED AT THIS TIME")
          fltQuantity.set(include.COMSYS.$$$MakeStatus(m$,"UNSUPPORTED AT THIS TIME"));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< 
    //<< } elseif (penumCalcType = 5) {
    else if ((mOp.Equal(penumCalcType.get(),5))) {
      //<< for loop=1:1:$listlength(lstStorages) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(lstStorages.get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idStorage = $list(lstStorages,loop)
        idStorage.set(m$.Fnc.$list(lstStorages.get(),loop.get()));
        //<< set idLocn    = $piece(idStorage,"||",1)
        idLocn.set(m$.Fnc.$piece(idStorage.get(),"||",1));
        //<< if pintBreakDown = $$$enumSeparated {
        if (mOp.Equal(pintBreakDown.get(),$$$enumSeparated(m$))) {
          //<< set arrQty(idStorage) = ##class(alSOH.iSOH).GetQtyBlocked(pidItem,idLocn,idStorage,pblnExclBlocked)
          arrQty.var(idStorage.get()).set(m$.fnc$("alSOH.iSOH.GetQtyBlocked",pidItem.get(),idLocn.get(),idStorage.get(),pblnExclBlocked.get()));
          //<< set fltQuantity = fltQuantity + arrQty(idStorage)
          fltQuantity.set(mOp.Add(fltQuantity.get(),arrQty.var(idStorage.get()).get()));
          //<< if arrQty(idStorage) set blnShow = $$$YES
          if (mOp.Logical(arrQty.var(idStorage.get()).get())) {
            blnShow.set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< } else {
        else {
          //<< set fltQuantity = $$$MakeStatus("UNSUPPORTED AT THIS TIME")
          fltQuantity.set(include.COMSYS.$$$MakeStatus(m$,"UNSUPPORTED AT THIS TIME"));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< 
    //<< } elseif (penumCalcType = 9) {
    else if ((mOp.Equal(penumCalcType.get(),9))) {
      //<< for loop=1:1:$listlength(lstStorages) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(lstStorages.get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idStorage = $list(lstStorages,loop)
        idStorage.set(m$.Fnc.$list(lstStorages.get(),loop.get()));
        //<< set idLocn    = $piece(idStorage,"||",1)
        idLocn.set(m$.Fnc.$piece(idStorage.get(),"||",1));
        //<< if pintBreakDown = $$$enumSeparated {
        if (mOp.Equal(pintBreakDown.get(),$$$enumSeparated(m$))) {
          //<< set arrQty(idStorage) = ##class(alSOH.iSOH).GetQtyOnHand(pidItem,idLocn,idStorage,$$$NO)
          arrQty.var(idStorage.get()).set(m$.fnc$("alSOH.iSOH.GetQtyOnHand",pidItem.get(),idLocn.get(),idStorage.get(),include.COMSYS.$$$NO(m$)));
          //<< set fltQuantity = fltQuantity + arrQty(idStorage)
          fltQuantity.set(mOp.Add(fltQuantity.get(),arrQty.var(idStorage.get()).get()));
          //<< if arrQty(idStorage) set blnShow = $$$YES
          if (mOp.Logical(arrQty.var(idStorage.get()).get())) {
            blnShow.set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< } else {
        else {
          //<< set fltQuantity = $$$MakeStatus("UNSUPPORTED AT THIS TIME")
          fltQuantity.set(include.COMSYS.$$$MakeStatus(m$,"UNSUPPORTED AT THIS TIME"));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< 
    //<< } elseif (penumCalcType = 10) {
    else if ((mOp.Equal(penumCalcType.get(),10))) {
      //<< for loop=1:1:$listlength(lstStorages) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(lstStorages.get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idStorage = $list(lstStorages,loop)
        idStorage.set(m$.Fnc.$list(lstStorages.get(),loop.get()));
        //<< set idLocn    = $piece(idStorage,"||",1)
        idLocn.set(m$.Fnc.$piece(idStorage.get(),"||",1));
        //<< if pintBreakDown = $$$enumSeparated {
        if (mOp.Equal(pintBreakDown.get(),$$$enumSeparated(m$))) {
          //<< set arrQty(idStorage) = ##class(alSOH.iSOH).GetQtyBlocked(pidItem,idLocn,idStorage,$$$NO)
          arrQty.var(idStorage.get()).set(m$.fnc$("alSOH.iSOH.GetQtyBlocked",pidItem.get(),idLocn.get(),idStorage.get(),include.COMSYS.$$$NO(m$)));
          //<< set fltQuantity = fltQuantity + arrQty(idStorage)
          fltQuantity.set(mOp.Add(fltQuantity.get(),arrQty.var(idStorage.get()).get()));
          //<< if arrQty(idStorage) set blnShow = $$$YES
          if (mOp.Logical(arrQty.var(idStorage.get()).get())) {
            blnShow.set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< } else {
        else {
          //<< set fltQuantity = $$$MakeStatus("UNSUPPORTED AT THIS TIME")
          fltQuantity.set(include.COMSYS.$$$MakeStatus(m$,"UNSUPPORTED AT THIS TIME"));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set fltQuantity = $$$MakeStatus("UNSUPPORTED AT THIS TIME")
      fltQuantity.set(include.COMSYS.$$$MakeStatus(m$,"UNSUPPORTED AT THIS TIME"));
    }
    //<< }
    //<< 
    //<< 
    //<< ;  total +ve might match total -ve, hiding details
    //<< if blnShow {
    if (mOp.Logical(blnShow.get())) {
      //<< if (pintBreakDown = $$$enumSeparated) {
      if ((mOp.Equal(pintBreakDown.get(),$$$enumSeparated(m$)))) {
        //<< set strPairs = ""
        strPairs.set("");
        //<< set idStorage = ""
        idStorage.set("");
        //<< for {
        for (;true;) {
          //<< set idStorage = $order(arrQty(idStorage))
          idStorage.set(m$.Fnc.$order(arrQty.var(idStorage.get())));
          //<< quit:idStorage=""
          if (mOp.Equal(idStorage.get(),"")) {
            break;
          }
          //<< continue:arrQty(idStorage)=0 ; prior algorithm may return empty quantities
          if (mOp.Equal(arrQty.var(idStorage.get()).get(),0)) {
            continue;
          }
          //<< 
          //<< set strPairs = strPairs_";"_arrQty(idStorage)_"*"_idStorage
          strPairs.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strPairs.get(),";"),arrQty.var(idStorage.get()).get()),"*"),idStorage.get()));
        }
        //<< }
        //<< set fltQuantity = fltQuantity_"#"_$extract(strPairs,2,9999)
        fltQuantity.set(mOp.Concat(mOp.Concat(fltQuantity.get(),"#"),m$.Fnc.$extract(strPairs.get(),2,9999)));
      }
      //<< 
      //<< } elseif (pintBreakDown = $$$enumDateSeparation) {
      else if ((mOp.Equal(pintBreakDown.get(),$$$enumDateSeparation(m$)))) {
        //<< set strPairs = ""
        strPairs.set("");
        //<< set idStorage = ""
        idStorage.set("");
        //<< set idBundle = ""
        idBundle.set("");
        //<< for {
        for (;true;) {
          //<< set idStorage = $order(arrQty(idStorage))
          idStorage.set(m$.Fnc.$order(arrQty.var(idStorage.get())));
          //<< quit:idStorage=""
          if (mOp.Equal(idStorage.get(),"")) {
            break;
          }
          //<< 
          //<< for {
          for (;true;) {
            //<< set idBundle = $order(arrQty(idStorage,idBundle))
            idBundle.set(m$.Fnc.$order(arrQty.var(idStorage.get(),idBundle.get())));
            //<< quit:idBundle=""
            if (mOp.Equal(idBundle.get(),"")) {
              break;
            }
            //<< continue:arrQty(idStorage,idBundle)=0
            if (mOp.Equal(arrQty.var(idStorage.get(),idBundle.get()).get(),0)) {
              continue;
            }
            //<< 
            //<< set strPairs = strPairs_";"_arrQty(idStorage,idBundle)_"*"_idStorage_"*"_idBundle
            strPairs.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strPairs.get(),";"),arrQty.var(idStorage.get(),idBundle.get()).get()),"*"),idStorage.get()),"*"),idBundle.get()));
          }
        }
        //<< }
        //<< }
        //<< set fltQuantity = fltQuantity_"#"_$extract(strPairs,2,9999)
        fltQuantity.set(mOp.Concat(mOp.Concat(fltQuantity.get(),"#"),m$.Fnc.$extract(strPairs.get(),2,9999)));
      }
    }
    //<< }
    //<< }
    //<< quit fltQuantity
    return fltQuantity.get();
  }

  //<< 
  //<< 
  //<< GetQuantityOnHand(pidItem,pidLocn)
  public Object GetQuantityOnHand(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the QOH, if consumable item then return 1E16
    //<< ;
    //<< ; Called By:    INRECReverse
    //<< ;               INStockReservation
    //<< ;               INTRNValidation
    //<< ; Params:
    //<< ;   pidItem - Item Id
    //<< ;   pidLocn - Site Location Id
    //<< ;
    //<< ; ByRefs: None
    //<< ;
    //<< ; Returns: Quantity On Hand
    //<< ;
    //<< ; History:
    //<< ; 09-Mar-2010   GRF     SR17196: use explicit tag
    //<< ; 10-Jul-2006   PO      SR14669: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new fltQuantity
    mVar fltQuantity = m$.var("fltQuantity");
    m$.newVar(fltQuantity);
    //<< 
    //<< if $$IsConsumable^INARTLOCPAR(pidItem,pidLocn) {
    if (mOp.Logical(m$.fnc$("INARTLOCPAR.IsConsumable",pidItem.get(),pidLocn.get()))) {
      //<< set fltQuantity = 1E16
      fltQuantity.set(Double.parseDouble("1E16"));
    }
    //<< } else {
    else {
      //<< ;   set fltQuantity = $$INARTMENGE(pidItem,,pidLocn)
      //<< set fltQuantity = $$GetQty^INARTMENGE(pidItem,,pidLocn)
      fltQuantity.set(m$.fnc$("INARTMENGE.GetQty",pidItem.get(),null,pidLocn.get()));
    }
    //<< }
    //<< quit fltQuantity
    return fltQuantity.get();
  }

  //<< 
  //<< 
  //<< QtyByBin(pstrQtyOutput,&parrQty)         ; DEPRECATED
  public Object QtyByBin(Object ... _p) {
    mVar pstrQtyOutput = m$.newVarRef("pstrQtyOutput",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar parrQty = m$.newVarRef("parrQty",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;                     DEPRECATED
    //<< ;
    //<< ;
    //<< ; Decodes a "break-down" INARTMENGE string into an array with bin
    //<< ; as the subscript
    //<< ;
    //<< ; Called By :   alLoc.dUStorage::GetItemSOHIncBlocked
    //<< ;               INAUFWH
    //<< ;               INMOVSearch
    //<< ;               INTRN
    //<< ;               INTRNUpdate
    //<< ;               WWWRECORDUtils
    //<< ;
    //<< ; Params:   pstrQtyOutput   : The "break-down" INARTMENGE output string
    //<< ;                             TotalQty#SLQty*StockLocn;SLQty*StockLocn;...
    //<< ;           parrQty         : (By ref) The array with bin >> qty
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; NOTE: DEPRECATED under V2...use iSOH!
    //<< ; History:
    //<< ; 01-Oct-2008   HQN     SR15970: Storage now a complete key, discarded under
    //<< ;                       V1 processing
    //<< ; 20-Dec-2006   SS      SR15244: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new fltQty,idBin,intLoop,strQty,strQtyBin
    mVar fltQty = m$.var("fltQty");
    mVar idBin = m$.var("idBin");
    mVar intLoop = m$.var("intLoop");
    mVar strQty = m$.var("strQty");
    mVar strQtyBin = m$.var("strQtyBin");
    m$.newVar(fltQty,idBin,intLoop,strQty,strQtyBin);
    //<< 
    //<< kill parrQty
    parrQty.kill();
    //<< 
    //<< set strQty = $piece(pstrQtyOutput,"#",2)
    strQty.set(m$.Fnc.$piece(pstrQtyOutput.get(),"#",2));
    //<< for intLoop = 1:1:$length(strQty,";") {
    for (intLoop.set(1);(mOp.LessOrEqual(intLoop.get(),m$.Fnc.$length(strQty.get(),";")));intLoop.set(mOp.Add(intLoop.get(),1))) {
      //<< set strQtyBin = $piece(strQty,";",intLoop)
      strQtyBin.set(m$.Fnc.$piece(strQty.get(),";",intLoop.get()));
      //<< set fltQty    = $piece(strQtyBin,"*",1)
      fltQty.set(m$.Fnc.$piece(strQtyBin.get(),"*",1));
      //<< set idBin     = $piece(strQtyBin,"*",2)
      idBin.set(m$.Fnc.$piece(strQtyBin.get(),"*",2));
      //<< set:idBin?.E1"||".E idBin = $piece(idBin,"||",2) ; SR15970
      if (mOp.Match(idBin.get(),".E1\"||\".E")) {
        idBin.set(m$.Fnc.$piece(idBin.get(),"||",2));
      }
      //<< if (idBin'="") set parrQty(idBin) = +fltQty
      if ((mOp.NotEqual(idBin.get(),""))) {
        parrQty.var(idBin.get()).set(mOp.Positive(fltQty.get()));
      }
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetStockByItem(pidItem,&arrBundleStock,pidLocn="")
  public Object GetStockByItem(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar arrBundleStock = m$.newVarRef("arrBundleStock",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Used By webservices to obtain a list of stock with 2 attributes
    //<< ; (Lot Number, Expiry Date and Bundle ID)
    //<< ;
    //<< ; Called By:    alSOH.iBundle::GetStockByItem
    //<< ;               alSOH.iBundle::GetStockByItemAttrib
    //<< ;               INIssueAuto
    //<< ;               INWSConsumptionInterface
    //<< ;               SALIss
    //<< ;               SALLot
    //<< ;
    //<< ; Inputs:
    //<< ;   pidLocn = return details for specific location only
    //<< ;
    //<< ; Returns:
    //<< ;   error code on failure
    //<< ;
    //<< ; History:
    //<< ;
    //<< ; 20-Aug-2010   sh/pp   SR17516: There may be multiple records with the same Lot
    //<< ;                           Number (due to prior faulty allocation)
    //<< ; 06-Apr-2010   shobby  SR17266: UseByDate from Lot Number is not unique.
    //<< ;                           Changed to use bundle.
    //<< ; 05-May-2009   SCR     SR16199: Return Bundle ID
    //<< ; 11-Mar-2009   GRF     SR16413: sc not changed since prior quit; doco; add else
    //<< ;                           to idBundle not found so don't re-get attributes
    //<< ; 26-Feb-2009   SCR     SR16256  Improved Null Lot Number checking
    //<< ; 16-Feb-2009   SCR     SR16348: Remove trailing space from Lot Number when
    //<< ;                           there is no expiry date & Improve the speed / reliability
    //<< ; 07-Jan-2009   SCR     SR16256: Included Logic to Handle a space in the Lot Number
    //<< ; 02-Jan-2009   SCR     SR16256: 1 Changed the Lot number code to return the lot number only
    //<< ;                                2 Excluded blocked locations
    //<< ;                                3 Excluded Reserved stock
    //<< ; 24-Dec-2008   FIS     SR16256: return details for specific location only
    //<< ; 24-Dec-2008   FIS     SR16256: return lot " " if no lot number exists (solves undef error)
    //<< ; 22-Dec-2008   HQN     SR16256: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrBundle,arrReserved,blnBlocked,idBundle,intLotCnt,intPosEnd,intPosStart,intQty
    mVar arrBundle = m$.var("arrBundle");
    mVar arrReserved = m$.var("arrReserved");
    mVar blnBlocked = m$.var("blnBlocked");
    mVar idBundle = m$.var("idBundle");
    mVar intLotCnt = m$.var("intLotCnt");
    mVar intPosEnd = m$.var("intPosEnd");
    mVar intPosStart = m$.var("intPosStart");
    mVar intQty = m$.var("intQty");
    m$.newVar(arrBundle,arrReserved,blnBlocked,idBundle,intLotCnt,intPosEnd,intPosStart,intQty);
    //<< new objResultSet,sc,strBundle,strDescription,strLotNumber,strStatus,strStorage,strToken,strUseByDate
    mVar objResultSet = m$.var("objResultSet");
    mVar sc = m$.var("sc");
    mVar strBundle = m$.var("strBundle");
    mVar strDescription = m$.var("strDescription");
    mVar strLotNumber = m$.var("strLotNumber");
    mVar strStatus = m$.var("strStatus");
    mVar strStorage = m$.var("strStorage");
    mVar strToken = m$.var("strToken");
    mVar strUseByDate = m$.var("strUseByDate");
    m$.newVar(objResultSet,sc,strBundle,strDescription,strLotNumber,strStatus,strStorage,strToken,strUseByDate);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< kill arrBundleStock
    arrBundleStock.kill();
    //<< 
    //<< set strStatus = $$GetReservedLots(pidItem,.arrReserved,pidLocn)
    strStatus.set(m$.fnc$("GetReservedLots",pidItem.get(),arrReserved,pidLocn.get()));
    //<< 
    //<< if (pidLocn '= "") {  ; get stock details for specific location only
    if ((mOp.NotEqual(pidLocn.get(),""))) {
      //<< set objResultSet = ##class(%Library.ResultSet).%New("alSOH.dBundleStock:GetAllLocnBundles")
      objResultSet.set(m$.fnc$("$Library.ResultSet.$New","alSOH.dBundleStock:GetAllLocnBundles"));
      //<< set sc = objResultSet.Execute(pidItem,pidLocn)
      sc.set(m$.fnc$(objResultSet.getORef(),"Execute",pidItem.get(),pidLocn.get()));
    }
    //<< 
    //<< } else {
    else {
      //<< set objResultSet = ##class(%Library.ResultSet).%New("alSOH.dBundleStock:GetAllBundles")
      objResultSet.set(m$.fnc$("$Library.ResultSet.$New","alSOH.dBundleStock:GetAllBundles"));
      //<< set sc = objResultSet.Execute(pidItem)
      sc.set(m$.fnc$(objResultSet.getORef(),"Execute",pidItem.get()));
    }
    //<< }
    //<< 
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< while (objResultSet.Next(.sc)) {
      while (mOp.Logical((m$.fnc$(objResultSet.getORef(),"Next",sc)))) {
        //<< set idBundle = objResultSet.Data("Bundle")
        idBundle.set(m$.fnc$(objResultSet.getORef(),"Data","Bundle"));
        //<< if '$data(arrBundle(idBundle)) {      ; First instance of bundle - get and preserve attribute values
        if (mOp.Not(m$.Fnc.$data(arrBundle.var(idBundle.get())))) {
          //<< set strLotNumber = $$GetLotNumber(pidItem,idBundle,.sc)
          strLotNumber.set(m$.fnc$("GetLotNumber",pidItem.get(),idBundle.get(),sc));
          //<< if strLotNumber="" set strLotNumber = " "
          if (mOp.Equal(strLotNumber.get(),"")) {
            strLotNumber.set(" ");
          }
          //<< 
          //<< quit:'$$$ISOK(sc)
          if (mOp.Not(include.COMSYS.$$$ISOK(m$,sc))) {
            break;
          }
          //<< 
          //<< ;   set strUseByDate = $$^WWWDATE($$GetUseByDate(pidItem,strLotNumber)) ;SR17266
          //<< set strUseByDate = $$^WWWDATE(##class(alSOH.dBundle).GetProperty(idBundle,"Use By Date"))    ;SR17266
          strUseByDate.set(m$.fnc$("WWWDATE.main",m$.fnc$("alSOH.dBundle.GetProperty",idBundle.get(),"Use By Date")));
          //<< set arrBundle(idBundle,"LotNumber") = strLotNumber
          arrBundle.var(idBundle.get(),"LotNumber").set(strLotNumber.get());
          //<< set arrBundle(idBundle,"UseByDate") = strUseByDate
          arrBundle.var(idBundle.get(),"UseByDate").set(strUseByDate.get());
        }
        //<< ;   if '$$$ISOK(sc) quit   ; sc not changed since prior quit
        //<< 
        //<< } else {                               ; Bundle has been used before
        else {
          //<< set strLotNumber = $get(arrBundle(idBundle,"LotNumber"))
          strLotNumber.set(m$.Fnc.$get(arrBundle.var(idBundle.get(),"LotNumber")));
          //<< set strUseByDate = $get(arrBundle(idBundle,"UseByDate"))
          strUseByDate.set(m$.Fnc.$get(arrBundle.var(idBundle.get(),"UseByDate")));
        }
        //<< }
        //<< set strStorage = objResultSet.Data("Storage")
        strStorage.set(m$.fnc$(objResultSet.getORef(),"Data","Storage"));
        //<< set blnBlocked = $$$NO
        blnBlocked.set(include.COMSYS.$$$NO(m$));
        //<< 
        //<< &sql(select StorageIsBlocked into :blnBlocked
        //<< from alLOC.dStorage
        //<< where id = :strStorage
        //<< )
        m$.Cmd.SQL();
        //<< 
        //<< continue:(blnBlocked = $$$YES)
        if ((mOp.Equal(blnBlocked.get(),include.COMSYS.$$$YES(m$)))) {
          continue;
        }
        //<< 
        //<< set intQty = objResultSet.Data("QtyOnHand")
        intQty.set(m$.fnc$(objResultSet.getORef(),"Data","QtyOnHand"));
        //<< set intQty = intQty+$get(arrBundleStock(pidItem,strStorage,strLotNumber))  ; This should not happen if there is only one lot number per item!
        intQty.set(mOp.Add(intQty.get(),m$.Fnc.$get(arrBundleStock.var(pidItem.get(),strStorage.get(),strLotNumber.get()))));
        //<< if $data(arrReserved(pidItem,strStorage,strLotNumber)) {
        if (mOp.Logical(m$.Fnc.$data(arrReserved.var(pidItem.get(),strStorage.get(),strLotNumber.get())))) {
          //<< set intQty = intQty-$get(arrReserved(pidItem,strStorage,strLotNumber)) ; Less reserved
          intQty.set(mOp.Subtract(intQty.get(),m$.Fnc.$get(arrReserved.var(pidItem.get(),strStorage.get(),strLotNumber.get()))));
          //<< kill arrReserved(pidItem,strStorage,strLotNumber)                      ; ensure that is only done once!
          arrReserved.var(pidItem.get(),strStorage.get(),strLotNumber.get()).kill();
        }
        //<< }
        //<< 
        //<< set strBundle=intQty
        strBundle.set(intQty.get());
        //<< if strUseByDate'="" {
        if (mOp.NotEqual(strUseByDate.get(),"")) {
          //<< set strBundle=intQty_"+"_strUseByDate
          strBundle.set(mOp.Concat(mOp.Concat(intQty.get(),"+"),strUseByDate.get()));
        }
        //<< }
        //<< set $piece(strBundle,"+",3) = idBundle
        m$.pieceVar(strBundle,"+",3).set(idBundle.get());
        //<< if $data(arrBundleStock(pidItem,strStorage,strLotNumber)) {
        if (mOp.Logical(m$.Fnc.$data(arrBundleStock.var(pidItem.get(),strStorage.get(),strLotNumber.get())))) {
          //<< set strLotNumber = strLotNumber_"#"_$increment(intLotCnt)      ; SR17516
          strLotNumber.set(mOp.Concat(mOp.Concat(strLotNumber.get(),"#"),m$.Fnc.$increment(intLotCnt)));
        }
        //<< }
        //<< set arrBundleStock(pidItem,strStorage,strLotNumber) = strBundle
        arrBundleStock.var(pidItem.get(),strStorage.get(),strLotNumber.get()).set(strBundle.get());
      }
    }
    //<< }
    //<< }
    //<< if $$$ISERR(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
      //<< set strStatus = $$ISStatusToDLStatus^COMUtilError(sc)
      strStatus.set(m$.fnc$("COMUtilError.ISStatusToDLStatus",sc.get()));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetReservedLots(pidItem,&parrReserved,pidLocn="")
  public Object GetReservedLots(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar parrReserved = m$.newVarRef("parrReserved",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return an array of lots (" " = none) that have a reservations (alDRP.dPlannedMovement)
    //<< ; (LotNumber and expiry)
    //<< ;
    //<< ; pidItem = the Item
    //<< ; parrReserver = arrar to pass back
    //<< ; pidLocn = return details for specific location only
    //<< ;
    //<< ; Returns:
    //<< ;   error code on failure
    //<< ;
    //<< ; History:
    //<< ; 13-Apr-2010   SCR     SR16256.1: Check for null Bundle id
    //<< ; 19-Mar-2009   GRF     SR16256: Copied null Lot No test from GetStockByItem
    //<< ; 16-Feb-2009   SCR     SR16348: Remove trailing space from Lot Number when
    //<< ;                           there is no expiry date
    //<< ; 07-Jan-2009   SCR     SR16256: Included Logic to Handle a space in the Lot Number
    //<< ; 02-Jan-2009   SCR     SR16256: Create
    //<< ;-------------------------------------------------------------------------------
    //<< new arrBundle,idBundle,intQty,objResultSet,sc
    mVar arrBundle = m$.var("arrBundle");
    mVar idBundle = m$.var("idBundle");
    mVar intQty = m$.var("intQty");
    mVar objResultSet = m$.var("objResultSet");
    mVar sc = m$.var("sc");
    m$.newVar(arrBundle,idBundle,intQty,objResultSet,sc);
    //<< new strDescription,strLotNumber,strStatus,strStorage,strToken
    mVar strDescription = m$.var("strDescription");
    mVar strLotNumber = m$.var("strLotNumber");
    mVar strStatus = m$.var("strStatus");
    mVar strStorage = m$.var("strStorage");
    mVar strToken = m$.var("strToken");
    m$.newVar(strDescription,strLotNumber,strStatus,strStorage,strToken);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if (pidLocn '= "") {
    if ((mOp.NotEqual(pidLocn.get(),""))) {
      //<< set objResultSet = ##class(%Library.ResultSet).%New("alDRP.dPlannedMovement.GetReservedForLocn")
      objResultSet.set(m$.fnc$("$Library.ResultSet.$New","alDRP.dPlannedMovement.GetReservedForLocn"));
      //<< set sc = objResultSet.Execute(pidItem,pidLocn)
      sc.set(m$.fnc$(objResultSet.getORef(),"Execute",pidItem.get(),pidLocn.get()));
    }
    //<< } else {
    else {
      //<< set objResultSet = ##class(%Library.ResultSet).%New("alDRP.dPlannedMovement.GetAllReserved")
      objResultSet.set(m$.fnc$("$Library.ResultSet.$New","alDRP.dPlannedMovement.GetAllReserved"));
      //<< set sc = objResultSet.Execute(pidItem)
      sc.set(m$.fnc$(objResultSet.getORef(),"Execute",pidItem.get()));
    }
    //<< }
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< while (objResultSet.Next(.sc)) {
      while (mOp.Logical((m$.fnc$(objResultSet.getORef(),"Next",sc)))) {
        //<< set idBundle = objResultSet.Data("Bundle")
        idBundle.set(m$.fnc$(objResultSet.getORef(),"Data","Bundle"));
        //<< if idBundle'="" {                                        ; SR16256.1
        if (mOp.NotEqual(idBundle.get(),"")) {
          //<< if '$data(arrBundle(idBundle)) {      ; First instance of bundle - get and preserve attribute values
          if (mOp.Not(m$.Fnc.$data(arrBundle.var(idBundle.get())))) {
            //<< set strLotNumber = $$GetLotNumber(pidItem,idBundle,.sc)
            strLotNumber.set(m$.fnc$("GetLotNumber",pidItem.get(),idBundle.get(),sc));
            //<< if strLotNumber="" set strLotNumber = " "        ; SR16256
            if (mOp.Equal(strLotNumber.get(),"")) {
              strLotNumber.set(" ");
            }
            //<< quit:'$$$ISOK(sc)
            if (mOp.Not(include.COMSYS.$$$ISOK(m$,sc))) {
              break;
            }
            //<< 
            //<< set arrBundle(idBundle,"LotNumber") = strLotNumber
            arrBundle.var(idBundle.get(),"LotNumber").set(strLotNumber.get());
          }
          //<< 
          //<< } else {                               ; Bundle has been used before
          else {
            //<< set strLotNumber = $get(arrBundle(idBundle,"LotNumber"))
            strLotNumber.set(m$.Fnc.$get(arrBundle.var(idBundle.get(),"LotNumber")));
          }
        }
        //<< }
        //<< }
        //<< set strStorage = objResultSet.Data("FromLocn")_"||"_objResultSet.Data("Storage")
        strStorage.set(mOp.Concat(mOp.Concat(m$.fnc$(objResultSet.getORef(),"Data","FromLocn"),"||"),m$.fnc$(objResultSet.getORef(),"Data","Storage")));
        //<< set intQty     = objResultSet.Data("QtyRequired")
        intQty.set(m$.fnc$(objResultSet.getORef(),"Data","QtyRequired"));
        //<< ;   set intQty     = intQty+$get(parrReserved(pidItem,strStorage,$get(strLotNumber," ")))  ; This should not happen if there is only one lot number per item!
        //<< ;   set parrReserved(pidItem,strStorage,$get(strLotNumber," ")) = intQty         ; SR16256
        //<< set intQty     = intQty+$get(parrReserved(pidItem,strStorage,strLotNumber))  ; This should not happen if there is only one lot number per item!
        intQty.set(mOp.Add(intQty.get(),m$.Fnc.$get(parrReserved.var(pidItem.get(),strStorage.get(),strLotNumber.get()))));
        //<< set parrReserved(pidItem,strStorage,strLotNumber) = intQty
        parrReserved.var(pidItem.get(),strStorage.get(),strLotNumber.get()).set(intQty.get());
      }
    }
    //<< }
    //<< }
    //<< if $$$ISERR(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
      //<< set strStatus = $$ISStatusToDLStatus^COMUtilError(sc)
      strStatus.set(m$.fnc$("COMUtilError.ISStatusToDLStatus",sc.get()));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetLotNumber(pidItem,pidBundle,&pstrStatus)
  public Object GetLotNumber(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidBundle = m$.newVarRef("pidBundle",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrStatus = m$.newVarRef("pstrStatus",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the Lot Number for a Bundle
    //<< ;
    //<< ; pidItem = the Item
    //<< ; pidBundle = the Bundle
    //<< ;
    //<< ; Returns:
    //<< ;   Lot No if there is one
    //<< ;
    //<< ; History:
    //<< ; 16-Feb-2009   SCR     SR16348: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new SQLCODE,strLot
    mVar SQLCODE = m$.var("SQLCODE");
    mVar strLot = m$.var("strLot");
    m$.newVar(SQLCODE,strLot);
    //<< 
    //<< ; TODO Add Error status for no item, no lot, no LotNo policy
    //<< 
    //<< set strLot = ""
    strLot.set("");
    //<< 
    //<< ; Get the Lot Number  for the bundle
    //<< &sql(select AttributeValue into :strLot
    //<< from alSOH.dBundleAttribute
    //<< where Bundle=:pidBundle          and
    //<< AttributeName="Lot Number"
    //<< )
    m$.Cmd.SQL();
    //<< 
    //<< set pstrStatus = $$$OK
    pstrStatus.set(include.COMSYS.$$$OK(m$));
    //<< quit strLot
    return strLot.get();
  }

//<< 
//<< 
//<< ;SR17266 GetUseByDate(pidItem,pstrLot,&pstrStatus)
//<< ;SR17266 ;-------------------------------------------------------------------------------
//<< ;SR17266 ; Get Expiry Date for a Item/Lot Number     (LotNumber and expiry)
//<< ;SR17266 ;
//<< ;SR17266 ; Called By: GetStockByItem^INARTMENGE
//<< ;SR17266 ;            INWSConsumptionInterface (Commented)
//<< ;SR17266 ;
//<< ;SR17266 ; Inputs : pidItem = the Item
//<< ;SR17266 ;          pstrLot = the Lot Number
//<< ;SR17266 ;
//<< ;SR17266 ; Returns:
//<< ;SR17266 ;  UseByDate if there is one (In $horolog format)
//<< ;SR17266 ;
//<< ;SR17266 ; History:
//<< ;SR17266 ; 03-Jan-2009  SCR     SR16256: Create
//<< ;SR17266 ;-------------------------------------------------------------------------------
//<< ;SR17266 new dteUseBy,idBundle,SQLCODE
//<< 
//<< ;SR17266 ; TODO : Add Error status for no item, no lot, no UseByDate policy
//<< 
//<< ;SR17266 set dteUseBy = ""
//<< ;SR17266 set idBundle = ""
//<< 
//<< ;SR17266 ; Get the bundle for the Item and the Lot
//<< ;SR17266 &sql(select bundle into :idBundle from alSOH.dBundleAttribute
//<< ;SR17266      where (AttributeName="Lot Number") and
//<< ;SR17266            (bundle->item = :pidItem)    and
//<< ;SR17266            (%EXACT(AttributeValue) = :pstrLot)
//<< ;SR17266 )
//<< 
//<< ;SR17266 if (idBundle'="") && (SQLCODE=0) {     ; Get the Use by date for the bundle
//<< ;SR17266    &sql(select AttributeValue into :dteUseBy
//<< ;SR17266         from alSOH.dBundleAttribute
//<< ;SR17266         where Bundle=:idBundle            and
//<< ;SR17266               AttributeName="Use By Date"
//<< ;SR17266    )
//<< ;SR17266 }
//<< 
//<< ;SR17266 set pstrStatus = $$$OK
//<< ;SR17266 quit dteUseBy
//<< 
//<< 
}
