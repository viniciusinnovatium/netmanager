//*****************************************************************************
//** TASC - ALPHALINC - MAC INCostCentre
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:12
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

//<< INCostCentre
public class INCostCentre extends mClass {

  public void main() {
    _INCostCentre();
  }

  public void _INCostCentre() {
  }

  //<< ;-------------------------------------------------------------------------------
  //<< ; Locations are defined in class WWW0121.
  //<< ; Any definitions for finance-related matters are stored in class INFIBPAR,
  //<< ; probably should be hierarchical - may need extra code to traverse tree for
  //<< ; account details, etc.
  //<< ;
  //<< ;
  //<< ; Issues
  //<< ;  1. If ^INFIBPAR exists, shouldn't be able to delete ^WWW0121.
  //<< ;  2. If sub-locations exist, shouldn't be able to delete ^WWW0121.
  //<< ;  2. If records created/deleted in ^WWW0121, ^INCCLocation will be affected.
  //<< ;  3. If hierarchy changes,  ^INCCLocation will be affected for all sub-locns at
  //<< ;     point of change.
  //<< ;
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ;    Defined (INFIBPAR)     ""      A       $$$INFIBPARCostCentre(objFinParam)
  //<< ;    Inherited              X       X
  //<< ;  --------------------------------------
  //<< ;    GetInheritedCC         X       X       << What will/would be inherited
  //<< ;    ShowInheritedCC        X       ""      << Doesn't Inherit in case 2 so leave field blank
  //<< ;    GetCostCentre          X       A       << Effective Cost Centre
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< 
  //<< 
  //<< 
  //<< GetInheritedCC(pidLocn)
  public Object GetInheritedCC(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Proceed up the location hierarchy until a cost centre is found.
    //<< ;
    //<< ; Called By : GetCostCentre, ShowInheritedCC, OnSaveLocation
    //<< ;             Form WWW0121C M16 "CostCentre"
    //<< ;
    //<< ; Returns: Inherited the Cost Centre that will apply if one is not
    //<< ;          explicitly defined.  (Skip current location  - piece 1 in string)
    //<< ;
    //<< ; History:
    //<< ; 23-Oct-2009   GRF     SR16871: CostCentre now in INFIBPAR not WWW0121
    //<< ; 19-Oct-2009   GRF     SR16871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCostCentre,idParent,intLocns,loop,objFinParam,strPath
    mVar idCostCentre = m$.var("idCostCentre");
    mVar idParent = m$.var("idParent");
    mVar intLocns = m$.var("intLocns");
    mVar loop = m$.var("loop");
    mVar objFinParam = m$.var("objFinParam");
    mVar strPath = m$.var("strPath");
    m$.newVar(idCostCentre,idParent,intLocns,loop,objFinParam,strPath);
    //<< 
    //<< quit:pidLocn="" ""
    if (mOp.Equal(pidLocn.get(),"")) {
      return "";
    }
    //<< 
    //<< set idCostCentre = ""
    idCostCentre.set("");
    //<< 
    //<< set strPath = $$LocationPath^WWW0121Utils(0,pidLocn)
    strPath.set(m$.fnc$("WWW0121Utils.LocationPath",0,pidLocn.get()));
    //<< set intLocns = $length(strPath,$$$COMMA)
    intLocns.set(m$.Fnc.$length(strPath.get(),include.COMSYSString.$$$COMMA(m$)));
    //<< for loop = 2:1:intLocns {
    for (loop.set(2);(mOp.LessOrEqual(loop.get(),intLocns.get()));loop.set(mOp.Add(loop.get(),1))) {
      //<< set idParent = $piece(strPath,$$$COMMA,loop)
      idParent.set(m$.Fnc.$piece(strPath.get(),include.COMSYSString.$$$COMMA(m$),loop.get()));
      //<< quit:idParent=""
      if (mOp.Equal(idParent.get(),"")) {
        break;
      }
      //<< 
      //<< set objFinParam  = $get(^INFIBPAR(0,0,idParent,1))
      objFinParam.set(m$.Fnc.$get(m$.var("^INFIBPAR",0,0,idParent.get(),1)));
      //<< set idCostCentre = $$$INFIBPARCostCentre(objFinParam)
      idCostCentre.set(include.INConst.$$$INFIBPARCostCentre(m$,objFinParam));
      //<< quit:idCostCentre'=""
      if (mOp.NotEqual(idCostCentre.get(),"")) {
        break;
      }
    }
    //<< }
    //<< 
    //<< quit idCostCentre
    return idCostCentre.get();
  }

  //<< 
  //<< 
  //<< ShowInheritedCC(pidLocn)
  public Object ShowInheritedCC(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If cost centre is not defined for the location, return the inherited cost centre.
    //<< ;
    //<< ; Called By : Form INFIBPAR M18 "Inherited"
    //<< ;
    //<< ; Returns: Inherited Cost Centre if not explicitly defined, otherwise null since
    //<< ;          skips current location (piece 1 in string).  This allows the inherited
    //<< ;          field to be blank if not relevant.
    //<< ;
    //<< ; History:
    //<< ; 19-Nov-2009   GRF     SR16871: Created following change to GetInheritedCC
    //<< ;-------------------------------------------------------------------------------
    //<< new idCostCentre,idParent,intLocns,loop,objFinParam,strPath
    mVar idCostCentre = m$.var("idCostCentre");
    mVar idParent = m$.var("idParent");
    mVar intLocns = m$.var("intLocns");
    mVar loop = m$.var("loop");
    mVar objFinParam = m$.var("objFinParam");
    mVar strPath = m$.var("strPath");
    m$.newVar(idCostCentre,idParent,intLocns,loop,objFinParam,strPath);
    //<< 
    //<< quit:pidLocn="" ""
    if (mOp.Equal(pidLocn.get(),"")) {
      return "";
    }
    //<< 
    //<< set idCostCentre = ""
    idCostCentre.set("");
    //<< 
    //<< set objFinParam  = $get(^INFIBPAR(0,0,pidLocn,1))
    objFinParam.set(m$.Fnc.$get(m$.var("^INFIBPAR",0,0,pidLocn.get(),1)));
    //<< if $$$INFIBPARCostCentre(objFinParam)="" set idCostCentre = $$GetInheritedCC(pidLocn)
    if (mOp.Equal(include.INConst.$$$INFIBPARCostCentre(m$,objFinParam),"")) {
      idCostCentre.set(m$.fnc$("GetInheritedCC",pidLocn.get()));
    }
    //<< 
    //<< quit idCostCentre
    return idCostCentre.get();
  }

  //<< 
  //<< 
  //<< GetCostCentre(pidLocn)
  public Object GetCostCentre(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns : Explicitly defined cost centre for location if present, otherwise
    //<< ;           the inherited cost centre
    //<< ;
    //<< ; History:
    //<< ; 06-Nov-2009   GRF     SR16871: Default to top level location (has no parent)
    //<< ; 23-Oct-2009   GRF     SR16871: CostCentre now in INFIBPAR not WWW0121
    //<< ; 19-Oct-2009   GRF     SR16871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCostCentre,objFinParam
    mVar idCostCentre = m$.var("idCostCentre");
    mVar objFinParam = m$.var("objFinParam");
    m$.newVar(idCostCentre,objFinParam);
    //<< 
    //<< if $get(pidLocn)="" set pidLocn = $order(^WWW0121s(0,2,0," ",0,""))  ; Top Level
    if (mOp.Equal(m$.Fnc.$get(pidLocn),"")) {
      pidLocn.set(m$.Fnc.$order(m$.var("^WWW0121s",0,2,0," ",0,"")));
    }
    //<< quit:pidLocn="" ""
    if (mOp.Equal(pidLocn.get(),"")) {
      return "";
    }
    //<< 
    //<< set objFinParam  = $get(^INFIBPAR(0,0,pidLocn,1))
    objFinParam.set(m$.Fnc.$get(m$.var("^INFIBPAR",0,0,pidLocn.get(),1)));
    //<< set idCostCentre = $$$INFIBPARCostCentre(objFinParam)
    idCostCentre.set(include.INConst.$$$INFIBPARCostCentre(m$,objFinParam));
    //<< 
    //<< if idCostCentre="" set idCostCentre = $$GetInheritedCC(pidLocn)
    if (mOp.Equal(idCostCentre.get(),"")) {
      idCostCentre.set(m$.fnc$("GetInheritedCC",pidLocn.get()));
    }
    //<< quit idCostCentre
    return idCostCentre.get();
  }

  //<< 
  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< ; INCCLocation Update Code
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< OnSaveLocation(pidLocn,pidNewCC)
  public Object OnSaveLocation(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidNewCC = m$.newVarRef("pidNewCC",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; OnSave process for INFIBPAR
    //<< ;
    //<< ; Called By: OnBeforeSave^INFIBPAR
    //<< ;
    //<< ; History:
    //<< ; 19-Nov-2009   GRF     SR16871: inherit for blank new CC
    //<< ; 19-Oct-2009   GRF     SR16871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idOldCC,strStatus
    mVar idOldCC = m$.var("idOldCC");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idOldCC,strStatus);
    //<< 
    //<< if pidNewCC="" set pidNewCC = $$GetInheritedCC(pidLocn)
    if (mOp.Equal(pidNewCC.get(),"")) {
      pidNewCC.set(m$.fnc$("GetInheritedCC",pidLocn.get()));
    }
    //<< 
    //<< set idOldCC = $$GetCostCentre(pidLocn)
    idOldCC.set(m$.fnc$("GetCostCentre",pidLocn.get()));
    //<< if idOldCC'=pidNewCC {
    if (mOp.NotEqual(idOldCC.get(),pidNewCC.get())) {
      //<< do UpdateCCLocn(pidLocn,idOldCC,pidNewCC)
      m$.Cmd.Do("UpdateCCLocn",pidLocn.get(),idOldCC.get(),pidNewCC.get());
      //<< do UpdateSubLocns(pidLocn,idOldCC,pidNewCC)
      m$.Cmd.Do("UpdateSubLocns",pidLocn.get(),idOldCC.get(),pidNewCC.get());
      //<< do UpdateStockVal(pidLocn,idOldCC,pidNewCC)   ; TODO : If possible, perform as background job
      m$.Cmd.Do("UpdateStockVal",pidLocn.get(),idOldCC.get(),pidNewCC.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnDeleteLocation(pidLocn)
  public Object OnDeleteLocation(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; OnDelete process for INFIBPAR - NOTE : Locn is not deleted from WWW0121
    //<< ;
    //<< ;   If Parameters are deleted for A Location then Cost Centre will be
    //<< ;   inherited from the Parent of the Location
    //<< ;
    //<< ; Called By: OnBeforeDelete^INFIBPAR
    //<< ;
    //<< ; History:
    //<< ; 19-Oct-2009   GRF     SR16871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idNewCC,idOldCC,idParent,objLocation,strStatus
    mVar idNewCC = m$.var("idNewCC");
    mVar idOldCC = m$.var("idOldCC");
    mVar idParent = m$.var("idParent");
    mVar objLocation = m$.var("objLocation");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idNewCC,idOldCC,idParent,objLocation,strStatus);
    //<< 
    //<< set objLocation = $get(^WWW0121(0,0,pidLocn,1))
    objLocation.set(m$.Fnc.$get(m$.var("^WWW0121",0,0,pidLocn.get(),1)));
    //<< 
    //<< set idOldCC  = $$GetCostCentre(pidLocn)
    idOldCC.set(m$.fnc$("GetCostCentre",pidLocn.get()));
    //<< set idParent = $$$WWW0121ParentLocn(objLocation)
    idParent.set(include.WWWConst.$$$WWW0121ParentLocn(m$,objLocation));
    //<< if idParent'="" {
    if (mOp.NotEqual(idParent.get(),"")) {
      //<< set idNewCC = $$GetCostCentre(idParent)
      idNewCC.set(m$.fnc$("GetCostCentre",idParent.get()));
    }
    //<< } else {
    else {
      //<< set idNewCC = ""   ; Top-level Entity
      idNewCC.set("");
    }
    //<< }
    //<< if idOldCC'=idNewCC {
    if (mOp.NotEqual(idOldCC.get(),idNewCC.get())) {
      //<< do UpdateCCLocn(pidLocn,idOldCC,idNewCC)
      m$.Cmd.Do("UpdateCCLocn",pidLocn.get(),idOldCC.get(),idNewCC.get());
      //<< do UpdateSubLocns(pidLocn,idOldCC,idNewCC)
      m$.Cmd.Do("UpdateSubLocns",pidLocn.get(),idOldCC.get(),idNewCC.get());
      //<< do UpdateStockVal(pidLocn,idOldCC,idNewCC)   ; TODO : If possible, perform as background job
      m$.Cmd.Do("UpdateStockVal",pidLocn.get(),idOldCC.get(),idNewCC.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnLocnChange(pidLocn,pobjLocation)
  public Object OnLocnChange(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjLocation = m$.newVarRef("pobjLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Review consequences of change to WWW0121 on INCCLocation
    //<< ;
    //<< ; Called By: OnBeforeSave^WWW0121, OnBeforeDelete^WWW0121
    //<< ;
    //<< ; Params: Location key and new data from WWW0121
    //<< ;
    //<< ; History:
    //<< ; 23-Oct-2009   GRF     SR16871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;  1. If Parent is changed, then may get different cost centre (only if inheriting)
    //<< ;  2. Can't delete if have sub-locations or Finance parameters
    //<< ;  3. Can't have sub-locations when first create
    //<< ;-------------------------------------------------------------------------------
    //<< new idNewCC,idOldCC,idParent,objFinParam
    mVar idNewCC = m$.var("idNewCC");
    mVar idOldCC = m$.var("idOldCC");
    mVar idParent = m$.var("idParent");
    mVar objFinParam = m$.var("objFinParam");
    m$.newVar(idNewCC,idOldCC,idParent,objFinParam);
    //<< 
    //<< set objFinParam  = $get(^INFIBPAR(0,0,pidLocn,1))
    objFinParam.set(m$.Fnc.$get(m$.var("^INFIBPAR",0,0,pidLocn.get(),1)));
    //<< set idNewCC = $$$INFIBPARCostCentre(objFinParam)
    idNewCC.set(include.INConst.$$$INFIBPARCostCentre(m$,objFinParam));
    //<< 
    //<< if idNewCC="" {  ; If explicitly defined will retain and will have OldCC = NewCC
    if (mOp.Equal(idNewCC.get(),"")) {
      //<< set idOldCC  = $$GetCostCentre(pidLocn)
      idOldCC.set(m$.fnc$("GetCostCentre",pidLocn.get()));
      //<< set idParent = $$$WWW0121ParentLocn(pobjLocation)
      idParent.set(include.WWWConst.$$$WWW0121ParentLocn(m$,pobjLocation));
      //<< 
      //<< if idParent'="" {   ; not a Top-level Entity
      if (mOp.NotEqual(idParent.get(),"")) {
        //<< set idNewCC = $$GetCostCentre(idParent)
        idNewCC.set(m$.fnc$("GetCostCentre",idParent.get()));
      }
      //<< }
      //<< if idNewCC'="" {    ; should never be otherwise if setup properly
      if (mOp.NotEqual(idNewCC.get(),"")) {
        //<< if idOldCC'=idNewCC {
        if (mOp.NotEqual(idOldCC.get(),idNewCC.get())) {
          //<< do UpdateCCLocn(pidLocn,idOldCC,idNewCC)
          m$.Cmd.Do("UpdateCCLocn",pidLocn.get(),idOldCC.get(),idNewCC.get());
          //<< do UpdateSubLocns(pidLocn,idOldCC,idNewCC)
          m$.Cmd.Do("UpdateSubLocns",pidLocn.get(),idOldCC.get(),idNewCC.get());
          //<< do UpdateStockVal(pidLocn,idOldCC,idNewCC)   ; TODO : If possible, perform as background job
          m$.Cmd.Do("UpdateStockVal",pidLocn.get(),idOldCC.get(),idNewCC.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< UpdateSubLocns(pidStartLocn,pidOldCC,pidNewCC)
  public Object UpdateSubLocns(Object ... _p) {
    mVar pidStartLocn = m$.newVarRef("pidStartLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidOldCC = m$.newVarRef("pidOldCC",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidNewCC = m$.newVarRef("pidNewCC",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; History:
    //<< ; 23-Oct-2009   GRF     SR16871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrLocns,idCostCentre,idLocn
    mVar arrLocns = m$.var("arrLocns");
    mVar idCostCentre = m$.var("idCostCentre");
    mVar idLocn = m$.var("idLocn");
    m$.newVar(arrLocns,idCostCentre,idLocn);
    //<< 
    //<< do Children^WWW0121Utils(0,pidStartLocn,,$$$YES,"Cache",.arrLocns)  ; all descendants of pidStartLocn
    m$.Cmd.Do("WWW0121Utils.Children",0,pidStartLocn.get(),null,include.COMSYS.$$$YES(m$),"Cache",arrLocns);
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
      //<< ;   continue:'$$$WWW0121StorageLocn($get(^WWW0121(0,0,idLocn,1)))   ; Not an Inventory Location
      //<< 
      //<< set idCostCentre = $$GetCostCentre(idLocn)
      idCostCentre.set(m$.fnc$("GetCostCentre",idLocn.get()));
      //<< continue:idCostCentre'=""                    ; explicit over-ride - no change
      if (mOp.NotEqual(idCostCentre.get(),"")) {
        continue;
      }
      //<< 
      //<< do UpdateCCLocn(idLocn,pidOldCC,pidNewCC)
      m$.Cmd.Do("UpdateCCLocn",idLocn.get(),pidOldCC.get(),pidNewCC.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< UpdateCCLocn(pidLocn,pidOldCC,pidNewCC)
  public Object UpdateCCLocn(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidOldCC = m$.newVarRef("pidOldCC",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidNewCC = m$.newVarRef("pidNewCC",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Common code for changing special index global ^INCCLocation
    //<< ; due to change in INFIBPAR or WWW0121
    //<< ;
    //<< ; Called By : OnSaveLocation, OnDeleteLocation, OnLocnChange, UpdateSubLocns
    //<< ;
    //<< ; History:
    //<< ; 23-Oct-2009   GRF     SR16871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< if pidNewCC'="" set strStatus = $$$Save("INCCLocation",pidNewCC_$$$COMMA_pidLocn,$$$YES)
    if (mOp.NotEqual(pidNewCC.get(),"")) {
      strStatus.set(include.COMSYS.$$$Save(m$,"INCCLocation",mOp.Concat(mOp.Concat(pidNewCC.get(),include.COMSYSString.$$$COMMA(m$)),pidLocn.get()),include.COMSYS.$$$YES(m$)));
    }
    //<< if pidOldCC'="" set strStatus = $$$Kill("INCCLocation",pidOldCC_$$$COMMA_pidLocn)
    if (mOp.NotEqual(pidOldCC.get(),"")) {
      strStatus.set(include.COMSYS.$$$Kill(m$,"INCCLocation",mOp.Concat(mOp.Concat(pidOldCC.get(),include.COMSYSString.$$$COMMA(m$)),pidLocn.get())));
    }
    //<< 
    //<< do ChangeCCStock^INAvgCost(pidLocn,pidOldCC,pidNewCC)
    m$.Cmd.Do("INAvgCost.ChangeCCStock",pidLocn.get(),pidOldCC.get(),pidNewCC.get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< UpdateStockVal(pidLocn,pidOldCC,pidNewCC) ; TODO : What if not Avg Cost Costing Method?
  public Object UpdateStockVal(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidOldCC = m$.newVarRef("pidOldCC",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidNewCC = m$.newVarRef("pidNewCC",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; After average costs have been updated for all locations moved between cost
    //<< ; centres, need to recalculate Stock Values as a single update pass rather than
    //<< ; having a pass for each sub-location change.  This should reduce the effect on
    //<< ; the ledger interface.
    //<< ;
    //<< ; If possible, perform as background job.
    //<< ;
    //<< ; Called By : OnSaveLocation, OnDeleteLocation, OnLocnChange
    //<< ;
    //<< ; History
    //<< ; 10-Nov-2009   GRF     SR16871: include location in strRef
    //<< ; 27-Oct-2009   GRF     SR16871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new curAvgCost,dteNow,idItem,strRef,strStatus
    mVar curAvgCost = m$.var("curAvgCost");
    mVar dteNow = m$.var("dteNow");
    mVar idItem = m$.var("idItem");
    mVar strRef = m$.var("strRef");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(curAvgCost,dteNow,idItem,strRef,strStatus);
    //<< 
    //<< set dteNow = +$horolog
    dteNow.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< set strRef = $$$Text($listbuild("IN01145",pidLocn,pidOldCC,pidNewCC))   ; "Change Location %1 from Cost Centre %2 to %3"
    strRef.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("IN01145",pidLocn.get(),pidOldCC.get(),pidNewCC.get())));
    //<< 
    //<< set idItem = ""
    idItem.set("");
    //<< for {
    for (;true;) {
      //<< set idItem = $order(^INStockVal(0,idItem))
      idItem.set(m$.Fnc.$order(m$.var("^INStockVal",0,idItem.get())));
      //<< quit:idItem=""
      if (mOp.Equal(idItem.get(),"")) {
        break;
      }
      //<< 
      //<< set curAvgCost = $$GetCostForCC^INAvgCost(idItem,pidNewCC,dteNow)
      curAvgCost.set(m$.fnc$("INAvgCost.GetCostForCC",idItem.get(),pidNewCC.get(),dteNow.get()));
      //<< set strStatus  = $$AutoUpdate^INStockValCCAdj("ChangeCC",strRef,idItem,pidNewCC,curAvgCost)
      strStatus.set(m$.fnc$("INStockValCCAdj.AutoUpdate","ChangeCC",strRef.get(),idItem.get(),pidNewCC.get(),curAvgCost.get()));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< /*
  //<< ;===============================================================================
  //<< ;   Locn B with 200 units @ $3.00 changes from Cost Centre Y to Cost Centre Z
  //<< ;   where there are 100 units (60 in Location L and 40 in Location M) at $3.30.
  //<< ;
  //<< ;---------
  //<< ;   INStockVal                                     INAvgCost
  //<< ;       A   ...      ...                CC-Y        $3.00
  //<< ;       B   200     $600.00             CC-Y        $3.00
  //<< ;       L    60     $198.00             CC-Z        $3.30
  //<< ;       M    40     $132.00             CC-Z        $3.30
  //<< ;---------
  //<< ;
  //<< ;       [ INCostCentre : OnSaveLocation, OnDeleteLocation, OnLocnChange ]
  //<< ;   1.  Record Old Cost Centre [Y] and original Value ($600)
  //<< ;
  //<< ;   2.  [ UpdateCCLocn^INCostCentre ]
  //<< ;       Change INCCLocation from Cost Centre Y to Cost Centre Z)
  //<< ;
  //<< ;       [ UpdateCCLocn^INCostCentre => ChangeCCStock^INAvgCost => UpdateFinance^INAvgCost ]
  //<< ;   3.  Credit SOH (Locn B, Cost Centre Y)                  $600.00
  //<< ;       Debit  SOH (Locn B, Cost Centre Z)                              $600.00
  //<< ;
  //<< ;   4.  Average Cost recalculation
  //<< ;       [ UpdateCCLocn^INCostCentre => ChangeCCStock^INAvgCost ]
  //<< ;           (200 * 3.00) + (100 * 3.30)  /  (200 + 100)  =  $930.00 / 300 = $3.10
  //<< ;
  //<< ;---------
  //<< ;   INStockVal                                     INAvgCost
  //<< ;       A   ...      ...                CC-Y        $3.00
  //<< ;       B   200     $600.00             CC-Z        $3.10
  //<< ;                => $620.00 (+$20.00)
  //<< ;       L    60     $198.00             CC-Z        $3.10
  //<< ;                => $186.00 (-$12.00)
  //<< ;       M    40     $132.00             CC-Z        $3.10
  //<< ;                => $124.00 (-$ 8.00)
  //<< ;---------
  //<< ;
  //<< ;   5.  Update Stock Val
  //<< ;       [ UpdateStockVal^INCostCentre => $$AutoUpdate^INStockValCCAdj ]
  //<< ;       Debit  SOH (LocnB, Cost Centre Z)                               $ 20.00
  //<< ;       Credit SOH (LocnL, Cost Centre Z)                   $ 12.00
  //<< ;       Credit SOH (LocnM, Cost Centre Z)                   $  8.00
  //<< ;===============================================================================
  //<< */
  //<< 
  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< ; Version Update Code
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< PopulateCCLocn()
  public Object PopulateCCLocn(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Initial population - run once on upgrade
    //<< ;
    //<< ; Note : Locations may have WWW0121 record but not INFIBPAR  -  inherit
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 30-Nov-2011   GRF     SR17967.1: move from CacheTemp to common global in nspace
    //<< ; 29-Nov-2011   GRF     SR17967: Clear CacheTemp so GetCostCentre has up-to-date
    //<< ; 06-May-2010   GRF     SR16871: Add Force Save flag
    //<< ; 19-Oct-2009   GRF     SR16871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCostCentre,idLocn,strStatus
    mVar idCostCentre = m$.var("idCostCentre");
    mVar idLocn = m$.var("idLocn");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idCostCentre,idLocn,strStatus);
    //<< 
    //<< ;kill ^CacheTempWWW0121    ; SR17967, SR17967.1
    //<< kill ^WWW0121Path
    m$.var("^WWW0121Path").kill();
    //<< kill ^WWW0121Hier
    m$.var("^WWW0121Hier").kill();
    //<< 
    //<< kill ^INCCLocation
    m$.var("^INCCLocation").kill();
    //<< set idLocn = ""
    idLocn.set("");
    //<< for {
    for (;true;) {
      //<< set idLocn = $order(^WWW0121(0,0,idLocn))
      idLocn.set(m$.Fnc.$order(m$.var("^WWW0121",0,0,idLocn.get())));
      //<< quit:idLocn=""
      if (mOp.Equal(idLocn.get(),"")) {
        break;
      }
      //<< 
      //<< set idCostCentre = $$GetCostCentre(idLocn)
      idCostCentre.set(m$.fnc$("GetCostCentre",idLocn.get()));
      //<< if idCostCentre'="" set strStatus = $$$Save("INCCLocation",idCostCentre_$$$COMMA_idLocn,$$$YES,$$$YES)
      if (mOp.NotEqual(idCostCentre.get(),"")) {
        strStatus.set(include.COMSYS.$$$Save(m$,"INCCLocation",mOp.Concat(mOp.Concat(idCostCentre.get(),include.COMSYSString.$$$COMMA(m$)),idLocn.get()),include.COMSYS.$$$YES(m$),include.COMSYS.$$$YES(m$)));
      }
    }
    //<< }
    //<< quit
    return null;
  }

//<< 
//<< 
}
