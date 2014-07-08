//*****************************************************************************
//** TASC - ALPHALINC - CLASS alLOC.dULocation
//** Innovatium Systems - Code Converter - v1.31
//** 2014-07-07 17:54:39
//*****************************************************************************

package alLOC;

import mLibrary.*;

//<< Include (INConst, COMSYS)
import include.INConst;
import include.COMSYS;
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

//<< 
//<< Class alLOC.dULocation Extends User.WWW0121 [ ClassType = persistent ]
public class dULocation extends User.WWW0121 {
  //<< {
  //<< 
  //<< Property ParentLocation As alLOC.dULocation(CAPTION = "AL00621") [ Transient ];
  public alLOC.dULocation ParentLocation;
  //<< 
  //<< Property Storages As %Library.ListOfObjects(CAPTION = "AL00622") [ Transient ];
  public mList<Object> Storages;

  //<< 
  //<< //++++++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< Method ParentLocationGet() As alLOC.dULocation
  public Object ParentLocationGet() {
    m$.newVar();
    //<< {
    //<< if (i%ParentLocation = $$$NULLOREF) {
    if ((mOp.Equal(m$.var("i%ParentLocation").get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< set objParentLocation = ##class(alLOC.dULocation).%OpenId("0||"_%this.ParentLocn)
      mVar objParentLocation = m$.var("objParentLocation");
      objParentLocation.set(m$.fnc$("alLOC.dULocation.$OpenId",mOp.Concat("0||",this.ParentLocn)));
      //<< if (objParentLocation '= $$$NULLOREF) {
      if ((mOp.NotEqual(objParentLocation.get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< set i%ParentLocation = objParentLocation
        m$.prop(this,"ParentLocation").set(objParentLocation.get());
      }
    }
    //<< }
    //<< }
    //<< quit i%ParentLocation
    return m$.var("i%ParentLocation").get();
  //<< }
  }

  //<< 
  //<< Method StoragesGet() As %Library.ListOfObjects
  public Object StoragesGet() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dStorage to dUStorage
    //<< ;-------------------------------------------------------------------------------
    //<< if (i%Storages = $$$NULLOREF) {
    if ((mOp.Equal(m$.var("i%Storages").get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< set i%Storages   = ##class(%Library.ListOfObjects).%New()
      m$.prop(this,"Storages").set(m$.fnc$("$Library.ListOfObjects.$New"));
      //<< set objResultSet = ##class(%Library.ResultSet).%New("alLOC.dUStorage:GetStoragesForLocation")
      mVar objResultSet = m$.var("objResultSet");
      objResultSet.set(m$.fnc$("$Library.ResultSet.$New","alLOC.dUStorage:GetStoragesForLocation"));
      //<< do objResultSet.Execute(%this.Location)
      m$.Cmd.Do(objResultSet.getORef(),"Execute",this.Location);
      //<< 
      //<< while (objResultSet.Next()) {
      while (mOp.Logical((m$.fnc$(objResultSet.getORef(),"Next")))) {
        //<< ; We could do this as an $order(^INREQ(0,%this.Location,strStorageId))
        //<< set objLocn = ##class(alLOC.dUStorage).%OpenId("0||"_%this.Location_"||"_objResultSet.Data("StockLocation"))
        mVar objLocn = m$.var("objLocn");
        objLocn.set(m$.fnc$("alLOC.dUStorage.$OpenId",mOp.Concat(mOp.Concat(mOp.Concat("0||",this.Location),"||"),m$.fnc$(objResultSet.getORef(),"Data","StockLocation"))));
        //<< if (objLocn '= $$$NULLOREF) {
        if ((mOp.NotEqual(objLocn.get(),include.$occConstant.$$$NULLOREF(m$)))) {
          //<< set objLocn.ParentLocation = %this
          m$.prop(objLocn.get(),"ParentLocation").set(this);
          //<< do i%Storages.Insert(objLocn)
          m$.Cmd.Do(m$.var("i%Storages").getORef(),"Insert",objLocn.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit i%Storages
    return m$.var("i%Storages").get();
  //<< }
  }

  //<< 
  //<< Method GetStock(objItem) As %Library.ListOfObjects
  public Object GetStock(Object ... _p) {
    mVar objItem = m$.newVarRef("objItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(objItem);
    //<< {
    //<< set objStockList = ##class(%Library.ListOfObjects).%New()
    mVar objStockList = m$.var("objStockList");
    objStockList.set(m$.fnc$("$Library.ListOfObjects.$New"));
    //<< 
    //<< ; FIXME : Complete population or remove <GRF/HQN>
    //<< 
    //<< quit objStockList
    return objStockList.get();
  //<< }
  }

  //<< 
  //<< Method GetDefaultStorage(
  //<< pidItem,
  //<< Output sc As %Status) As alLOC.dUStorage
  public Object GetDefaultStorage(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Output = m$.newVarRef("Output",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(pidItem,Output,sc);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;     OBSOLETE : Replace with calls to methods below for specific storage types
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; look at ANM: Item Location Parameters
    //<< ; 1.  Stock Item + Location                     (^INARTLOCPAR)
    //<< ;     (Alphalinc >> Items >> Item Master Data >> ItemLocationParameter Button)
    //<< ;     a)    Receipt
    //<< ;     b)    On Hand
    //<< ; 2.  Location Master Data                      (^WWW0121)
    //<< ;     (Alphalinc >> System >> Company Parameters >> Edit Locations >> Storage Tab)
    //<< ;     a)    Receipt
    //<< ;     b)    On Hand
    //<< ; 3.  General Location Parameters for Location  (^INVORGB)
    //<< ;     (Alphalinc >> Program Parameters >> Edit General Parameters >> Location Button)
    //<< ;     a)    On Hand
    //<< ;
    //<< ; History:
    //<< ; 09-Nov-2009   GRF     string check is for null not NULLOREF
    //<< ; 31-Jul-2008   Luke    SR15814: corrected the sc formation
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dStorage to dUStorage
    //<< ; 04-Dec-2007   HQN     Implemented more lookups and fixed loading of storage
    //<< ;-------------------------------------------------------------------------------
    //<< ;  See also : DefaultStkLoc^INARTUtilities
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< // lookup ^INARTLOCPAR
    //<< set strDefaultStorage = $$$INARTLOCPARDefaultReceiptStorage($get(^INARTLOCPAR(0,pidItem,%this.Location,1)))
    mVar strDefaultStorage = m$.var("strDefaultStorage");
    strDefaultStorage.set(include.INConst.$$$INARTLOCPARDefaultReceiptStorage(m$,m$.Fnc.$get(m$.var("^INARTLOCPAR",0,pidItem.get(),this.Location,1))));
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = $$$INARTLOCPARDefaultOnHandStorage($get(^INARTLOCPAR(0,pidItem,%this.Location,1)))
      strDefaultStorage.set(include.INConst.$$$INARTLOCPARDefaultOnHandStorage(m$,m$.Fnc.$get(m$.var("^INARTLOCPAR",0,pidItem.get(),this.Location,1))));
    }
    //<< }
    //<< 
    //<< // lookup ^WWW0121
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = %this.ReceiptStorage
      strDefaultStorage.set(this.ReceiptStorage);
    }
    //<< }
    //<< 
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = %this.OnHandStorage
      strDefaultStorage.set(this.OnHandStorage);
    }
    //<< }
    //<< 
    //<< ; lookup ^INVORGB
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = $$$INVORGBOnHandLocation($get(^INVORGB(0,%this.Company,%this.Location,1)))
      strDefaultStorage.set(include.INConst.$$$INVORGBOnHandLocation(m$,m$.Fnc.$get(m$.var("^INVORGB",0,this.Company,this.Location,1))));
    }
    //<< }
    //<< 
    //<< ;-----
    //<< 
    //<< set objStorage = $$$NULLOREF
    mVar objStorage = m$.var("objStorage");
    objStorage.set(include.$occConstant.$$$NULLOREF(m$));
    //<< if (strDefaultStorage '= "") {
    if ((mOp.NotEqual(strDefaultStorage.get(),""))) {
      //<< set objStorage = ##class(alLOC.dUStorage).%OpenId("0||"_%this.Location_"||"_strDefaultStorage)
      objStorage.set(m$.fnc$("alLOC.dUStorage.$OpenId",mOp.Concat(mOp.Concat(mOp.Concat("0||",this.Location),"||"),strDefaultStorage.get())));
    }
    //<< }
    //<< if (objStorage = $$$NULLOREF) {
    if ((mOp.Equal(objStorage.get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< 
      //<< set strMessage = $$$Text($listbuild("alLOC0001",%this.Location))
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0001",this.Location)));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< } ; "No default storage found for location %1"
    //<< quit objStorage
    return objStorage.get();
  //<< }
  }

  //<< 
  //<< /*
  //<< ;-------------------------------------------------------------------------------
  //<< ;  Generic note for all GetDefault...Storage methods
  //<< ;        (1 >> 2 >> 3)   may not invoke all three in each case.
  //<< ;
  //<< ; 1.  Stock Item + Location                     (^INARTLOCPAR)
  //<< ;       (Alphalinc >> Items >> Item Master Data >> ItemLocationParameter Button)
  //<< ;
  //<< ; 2.  Location Master Data                      (^WWW0121)
  //<< ;       (Alphalinc >> System >> Company Parameters >> Edit Locations >> Storage Tab)
  //<< ;
  //<< ; 3.  General Location Parameters for Location  (^INVORGB)
  //<< ;       (Alphalinc >> Program Parameters >> Edit General Parameters >> Location Button)
  //<< ;
  //<< ;  See also : DefaultStkLoc^INARTUtilities and some other specific instances for
  //<< ;  obsolete code that needs to be mapped here instead.
  //<< ;-------------------------------------------------------------------------------
  //<< */
  //<< Method GetDefaultOnHandStorage(
  //<< pidItem,
  //<< Output sc As %Status) As alLOC.dUStorage
  public Object GetDefaultOnHandStorage(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Output = m$.newVarRef("Output",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(pidItem,Output,sc);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; On Hand Storage   (1 >> 2 >> 3)
    //<< ;
    //<< ; History:
    //<< ; 18-Nov-2009   DWR     SR17044: extened the error string message to include the
    //<< ;                           specific type of storage being looked at.
    //<< ; 31-Jul-2008   Luke    SR15814: corrected the sc formation
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dStorage to dUStorage
    //<< ; 07-Dec-2007   GRF     Adapted for specific Storage Type
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set strDefaultStorage = $$$INARTLOCPARDefaultOnHandStorage($get(^INARTLOCPAR(0,pidItem,%this.Location,1)))
    mVar strDefaultStorage = m$.var("strDefaultStorage");
    strDefaultStorage.set(include.INConst.$$$INARTLOCPARDefaultOnHandStorage(m$,m$.Fnc.$get(m$.var("^INARTLOCPAR",0,pidItem.get(),this.Location,1))));
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = %this.OnHandStorage
      strDefaultStorage.set(this.OnHandStorage);
    }
    //<< }
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = $$$INVORGBOnHandLocation($get(^INVORGB(0,%this.Company,%this.Location,1)))
      strDefaultStorage.set(include.INConst.$$$INVORGBOnHandLocation(m$,m$.Fnc.$get(m$.var("^INVORGB",0,this.Company,this.Location,1))));
    }
    //<< }
    //<< set objStorage = $$$NULLOREF
    mVar objStorage = m$.var("objStorage");
    objStorage.set(include.$occConstant.$$$NULLOREF(m$));
    //<< if (strDefaultStorage '= "") {
    if ((mOp.NotEqual(strDefaultStorage.get(),""))) {
      //<< set objStorage = ##class(alLOC.dUStorage).%OpenId("0||"_%this.Location_"||"_strDefaultStorage)
      objStorage.set(m$.fnc$("alLOC.dUStorage.$OpenId",mOp.Concat(mOp.Concat(mOp.Concat("0||",this.Location),"||"),strDefaultStorage.get())));
    }
    //<< }
    //<< 
    //<< if (objStorage = $$$NULLOREF) {
    if ((mOp.Equal(objStorage.get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< ;      set strMessage = $$$Text($listbuild("alLOC0001",%this.Location))
      //<< set strMessage = $$$Text($listbuild("alLOC0010",$$$StrWWW0121OnHandStorage,%this.Location))
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0010",include.WWWConst.$$$StrWWW0121OnHandStorage(m$),this.Location)));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< } ; "No default storage found for location %1"
    //<< 
    //<< quit objStorage
    return objStorage.get();
  //<< }
  }

  //<< 
  //<< Method GetDefaultReceiptStorage(
  //<< pidItem = "",
  //<< Output sc As %Status) As alLOC.dUStorage
  public Object GetDefaultReceiptStorage(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar Output = m$.newVarRef("Output",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(pidItem,Output,sc);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Goods Receipt Storage   (1 >> 2)
    //<< ;
    //<< ; History:
    //<< ; 18-Nov-2009   DWR     SR17044: extened the error string message to include the
    //<< ;                           specific type of storage being looked at.
    //<< ; 31-Jul-2008   Luke    SR15814: corrected the sc formation
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dStorage to dUStorage
    //<< ; 07-Dec-2007   PPP     Added Consumable Item Storage definition
    //<< ; 07-Dec-2007   GRF     Adapted for specific Storage Type
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< set strDefaultStorage = ""
    mVar strDefaultStorage = m$.var("strDefaultStorage");
    strDefaultStorage.set("");
    //<< 
    //<< if (pidItem '= "") {
    if ((mOp.NotEqual(pidItem.get(),""))) {
      //<< if $$IsConsumable^INARTLOCPAR(pidItem,%this.Location) {
      if (mOp.Logical(m$.fnc$("INARTLOCPAR.IsConsumable",pidItem.get(),this.Location))) {
        //<< set strDefaultStorage = $$$INVORGDeleteStockLocation($get(^INVORG(0,0,1)))
        strDefaultStorage.set(include.INConst.$$$INVORGDeleteStockLocation(m$,m$.Fnc.$get(m$.var("^INVORG",0,0,1))));
      }
      //<< 
      //<< } else {
      else {
        //<< set strDefaultStorage = $$$INARTLOCPARDefaultReceiptStorage($get(^INARTLOCPAR(0,pidItem,%this.Location,1)))
        strDefaultStorage.set(include.INConst.$$$INARTLOCPARDefaultReceiptStorage(m$,m$.Fnc.$get(m$.var("^INARTLOCPAR",0,pidItem.get(),this.Location,1))));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if (strDefaultStorage="") set strDefaultStorage = %this.ReceiptStorage
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      strDefaultStorage.set(this.ReceiptStorage);
    }
    //<< 
    //<< set objStorage = $$$NULLOREF
    mVar objStorage = m$.var("objStorage");
    objStorage.set(include.$occConstant.$$$NULLOREF(m$));
    //<< if (strDefaultStorage '= "") {
    if ((mOp.NotEqual(strDefaultStorage.get(),""))) {
      //<< set objStorage = ##class(alLOC.dUStorage).%OpenId("0||"_%this.Location_"||"_strDefaultStorage)
      objStorage.set(m$.fnc$("alLOC.dUStorage.$OpenId",mOp.Concat(mOp.Concat(mOp.Concat("0||",this.Location),"||"),strDefaultStorage.get())));
    }
    //<< }
    //<< 
    //<< if (objStorage = $$$NULLOREF) {
    if ((mOp.Equal(objStorage.get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< ;      set strMessage = $$$Text($listbuild("alLOC0001",%this.Location))
      //<< set strMessage = $$$Text($listbuild("alLOC0010",$$$StrWWW0121ReceiptStorage,%this.Location))
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0010",include.WWWConst.$$$StrWWW0121ReceiptStorage(m$),this.Location)));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< } ; "No default storage found for location %1"
    //<< 
    //<< quit objStorage
    return objStorage.get();
  //<< }
  }

  //<< 
  //<< Method GetDefaultDespatchStorage(
  //<< pidItem,
  //<< Output sc As %Status) As alLOC.dUStorage
  public Object GetDefaultDespatchStorage(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Output = m$.newVarRef("Output",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(pidItem,Output,sc);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Despatch Storage   (1 >> 2)
    //<< ;
    //<< ; History:
    //<< ; 18-Nov-2009   DWR     SR17044: extened the error string message to include the
    //<< ;                           specific type of storage being looked at.
    //<< ; 31-Jul-2008   Luke    SR15814: corrected the sc formation
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dStorage to dUStorage
    //<< ; 07-Dec-2007   GRF     Adapted for specific Storage Type
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set strDefaultStorage = $$$INARTLOCPARDefaultDespatchStorage($get(^INARTLOCPAR(0,pidItem,%this.Location,1)))
    mVar strDefaultStorage = m$.var("strDefaultStorage");
    strDefaultStorage.set(include.INConst.$$$INARTLOCPARDefaultDespatchStorage(m$,m$.Fnc.$get(m$.var("^INARTLOCPAR",0,pidItem.get(),this.Location,1))));
    //<< 
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = %this.DespatchStorage
      strDefaultStorage.set(this.DespatchStorage);
    }
    //<< }
    //<< 
    //<< set objStorage = $$$NULLOREF
    mVar objStorage = m$.var("objStorage");
    objStorage.set(include.$occConstant.$$$NULLOREF(m$));
    //<< if (strDefaultStorage '= "") {
    if ((mOp.NotEqual(strDefaultStorage.get(),""))) {
      //<< set objStorage = ##class(alLOC.dUStorage).%OpenId("0||"_%this.Location_"||"_strDefaultStorage)
      objStorage.set(m$.fnc$("alLOC.dUStorage.$OpenId",mOp.Concat(mOp.Concat(mOp.Concat("0||",this.Location),"||"),strDefaultStorage.get())));
    }
    //<< }
    //<< 
    //<< if (objStorage = $$$NULLOREF) {
    if ((mOp.Equal(objStorage.get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< ;      set strMessage = $$$Text($listbuild("alLOC0001",%this.Location))
      //<< set strMessage = $$$Text($listbuild("alLOC0010",$$$StrWWW0121DespatchStorage,%this.Location))
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0010",include.WWWConst.$$$StrWWW0121DespatchStorage(m$),this.Location)));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< } ; "No default storage found for location %1"
    //<< 
    //<< quit objStorage
    return objStorage.get();
  //<< }
  }

  //<< 
  //<< Method GetDefaultMissingStorage(
  //<< pidItem,
  //<< Output sc As %Status) As alLOC.dUStorage
  public Object GetDefaultMissingStorage(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Output = m$.newVarRef("Output",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(pidItem,Output,sc);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Missing Stock Storage   (1 >> 2)
    //<< ;
    //<< ; History:
    //<< ; 18-Nov-2009   DWR     SR17044: extened the error string message to include the
    //<< ;                           specific type of storage being looked at.
    //<< ; 31-Jul-2008   Luke    SR15814: corrected the sc formation
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dStorage to dUStorage
    //<< ; 07-Dec-2007   GRF     Adapted for specific Storage Type
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set strDefaultStorage = $$$INARTLOCPARDefaultMissingStorage($get(^INARTLOCPAR(0,pidItem,%this.Location,1)))
    mVar strDefaultStorage = m$.var("strDefaultStorage");
    strDefaultStorage.set(include.INConst.$$$INARTLOCPARDefaultMissingStorage(m$,m$.Fnc.$get(m$.var("^INARTLOCPAR",0,pidItem.get(),this.Location,1))));
    //<< 
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = %this.MissingStockStorage
      strDefaultStorage.set(this.MissingStockStorage);
    }
    //<< }
    //<< 
    //<< set objStorage = $$$NULLOREF
    mVar objStorage = m$.var("objStorage");
    objStorage.set(include.$occConstant.$$$NULLOREF(m$));
    //<< if (strDefaultStorage '= "") {
    if ((mOp.NotEqual(strDefaultStorage.get(),""))) {
      //<< set objStorage = ##class(alLOC.dUStorage).%OpenId("0||"_%this.Location_"||"_strDefaultStorage)
      objStorage.set(m$.fnc$("alLOC.dUStorage.$OpenId",mOp.Concat(mOp.Concat(mOp.Concat("0||",this.Location),"||"),strDefaultStorage.get())));
    }
    //<< }
    //<< 
    //<< if (objStorage = $$$NULLOREF) {
    if ((mOp.Equal(objStorage.get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< ;      set strMessage = $$$Text($listbuild("alLOC0001",%this.Location))
      //<< set strMessage = $$$Text($listbuild("alLOC0010",$$$StrWWW0121MissingStockStorage,%this.Location))
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0010",include.WWWConst.$$$StrWWW0121MissingStockStorage(m$),this.Location)));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< } ; "No default storage found for location %1"
    //<< 
    //<< quit objStorage
    return objStorage.get();
  //<< }
  }

  //<< 
  //<< Method GetDefaultDamagedStorage(
  //<< pidItem,
  //<< Output sc As %Status) As alLOC.dUStorage
  public Object GetDefaultDamagedStorage(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Output = m$.newVarRef("Output",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(pidItem,Output,sc);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Damaged Stock Storage   (1 >> 2)
    //<< ;
    //<< ; History:
    //<< ; 18-Nov-2009   DWR     SR17044: extened the error string message to include the
    //<< ;                           specific type of storage being looked at.
    //<< ; 31-Jul-2008   Luke    SR15814: corrected the sc formation
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dStorage to dUStorage
    //<< ; 07-Dec-2007   GRF     Adapted for specific Storage Type
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set strDefaultStorage = $$$INARTLOCPARDefaultDamagedStorage($get(^INARTLOCPAR(0,pidItem,%this.Location,1)))
    mVar strDefaultStorage = m$.var("strDefaultStorage");
    strDefaultStorage.set(include.INConst.$$$INARTLOCPARDefaultDamagedStorage(m$,m$.Fnc.$get(m$.var("^INARTLOCPAR",0,pidItem.get(),this.Location,1))));
    //<< 
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = %this.DamagedStockStorage
      strDefaultStorage.set(this.DamagedStockStorage);
    }
    //<< }
    //<< 
    //<< set objStorage = $$$NULLOREF
    mVar objStorage = m$.var("objStorage");
    objStorage.set(include.$occConstant.$$$NULLOREF(m$));
    //<< if (strDefaultStorage '= "") {
    if ((mOp.NotEqual(strDefaultStorage.get(),""))) {
      //<< set objStorage = ##class(alLOC.dUStorage).%OpenId("0||"_%this.Location_"||"_strDefaultStorage)
      objStorage.set(m$.fnc$("alLOC.dUStorage.$OpenId",mOp.Concat(mOp.Concat(mOp.Concat("0||",this.Location),"||"),strDefaultStorage.get())));
    }
    //<< }
    //<< 
    //<< if (objStorage = $$$NULLOREF) {
    if ((mOp.Equal(objStorage.get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< ;      set strMessage = $$$Text($listbuild("alLOC0001",%this.Location))
      //<< set strMessage = $$$Text($listbuild("alLOC0010",$$$StrWWW0121DamagedStockStorage,%this.Location))
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0010",include.WWWConst.$$$StrWWW0121DamagedStockStorage(m$),this.Location)));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< } ; "No default %1 found for location %2"
    //<< 
    //<< quit objStorage
    return objStorage.get();
  //<< }
  }

  //<< 
  //<< Method GetDefaultSuppReturnStorage(
  //<< pidItem,
  //<< Output sc As %Status) As alLOC.dUStorage
  public Object GetDefaultSuppReturnStorage(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Output = m$.newVarRef("Output",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(pidItem,Output,sc);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return To Supplier Storage   (2 >> 3)
    //<< ;
    //<< ; History:
    //<< ; 18-Nov-2009   DWR     SR17044: extened the error string message to include the
    //<< ;                           specific type of storage being looked at.
    //<< ; 31-Jul-2008   Luke    SR15814: corrected the sc formation
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dStorage to dUStorage
    //<< ; 07-Dec-2007   GRF     Adapted for specific Storage Type
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set strDefaultStorage = %this.SuppReturnStorage
    mVar strDefaultStorage = m$.var("strDefaultStorage");
    strDefaultStorage.set(this.SuppReturnStorage);
    //<< 
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = $$$INVORGBReturnStockLocation($get(^INVORGB(0,%this.Company,%this.Location,1)))
      strDefaultStorage.set(include.INConst.$$$INVORGBReturnStockLocation(m$,m$.Fnc.$get(m$.var("^INVORGB",0,this.Company,this.Location,1))));
    }
    //<< }
    //<< 
    //<< set objStorage = $$$NULLOREF
    mVar objStorage = m$.var("objStorage");
    objStorage.set(include.$occConstant.$$$NULLOREF(m$));
    //<< if (strDefaultStorage '= "") {
    if ((mOp.NotEqual(strDefaultStorage.get(),""))) {
      //<< set objStorage = ##class(alLOC.dUStorage).%OpenId("0||"_%this.Location_"||"_strDefaultStorage)
      objStorage.set(m$.fnc$("alLOC.dUStorage.$OpenId",mOp.Concat(mOp.Concat(mOp.Concat("0||",this.Location),"||"),strDefaultStorage.get())));
    }
    //<< }
    //<< 
    //<< if (objStorage = $$$NULLOREF) {
    if ((mOp.Equal(objStorage.get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< ;      set strMessage = $$$Text($listbuild("alLOC0001",%this.Location))
      //<< set strMessage = $$$Text($listbuild("alLOC0010",$$$StrWWW0121SuppReturnStorage,%this.Location))
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0010",include.WWWConst.$$$StrWWW0121SuppReturnStorage(m$),this.Location)));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< } ; "No default storage found for location %1"
    //<< 
    //<< quit objStorage
    return objStorage.get();
  //<< }
  }

  //<< 
  //<< Method GetDefaultCustReturnStorage(
  //<< pidItem,
  //<< Output sc As %Status) As alLOC.dUStorage
  public Object GetDefaultCustReturnStorage(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Output = m$.newVarRef("Output",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(pidItem,Output,sc);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returned from Customer Storage   (2 >> 3)
    //<< ;
    //<< ; History:
    //<< ; 18-Nov-2009   DWR     SR17044: extened the error string message to include the
    //<< ;                           specific type of storage being looked at.
    //<< ; 31-Jul-2008   Luke    SR15814: corrected the sc formation
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dStorage to dUStorage
    //<< ; 07-Dec-2007   GRF     Adapted for specific Storage Type
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set strDefaultStorage = %this.CustReturnStorage
    mVar strDefaultStorage = m$.var("strDefaultStorage");
    strDefaultStorage.set(this.CustReturnStorage);
    //<< 
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = $$$INVORGBReturnStockLocation($get(^INVORGB(0,%this.Company,%this.Location,1)))
      strDefaultStorage.set(include.INConst.$$$INVORGBReturnStockLocation(m$,m$.Fnc.$get(m$.var("^INVORGB",0,this.Company,this.Location,1))));
    }
    //<< }
    //<< 
    //<< set objStorage = $$$NULLOREF
    mVar objStorage = m$.var("objStorage");
    objStorage.set(include.$occConstant.$$$NULLOREF(m$));
    //<< if (strDefaultStorage '= "") {
    if ((mOp.NotEqual(strDefaultStorage.get(),""))) {
      //<< set objStorage = ##class(alLOC.dUStorage).%OpenId("0||"_%this.Location_"||"_strDefaultStorage)
      objStorage.set(m$.fnc$("alLOC.dUStorage.$OpenId",mOp.Concat(mOp.Concat(mOp.Concat("0||",this.Location),"||"),strDefaultStorage.get())));
    }
    //<< }
    //<< 
    //<< if (objStorage = $$$NULLOREF) {
    if ((mOp.Equal(objStorage.get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< ;      set strMessage = $$$Text($listbuild("alLOC0001",%this.Location))
      //<< set strMessage = $$$Text($listbuild("alLOC0010",$$$StrWWW0121CustReturnStorage,%this.Location))
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0010",include.WWWConst.$$$StrWWW0121CustReturnStorage(m$),this.Location)));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< } ; "No default storage found for location %1"
    //<< 
    //<< quit objStorage
    return objStorage.get();
  //<< }
  }

  //<< 
  //<< Method GetDefaultManuReturnStorage(
  //<< pidItem,
  //<< Output sc As %Status) As alLOC.dUStorage
  public Object GetDefaultManuReturnStorage(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Output = m$.newVarRef("Output",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(pidItem,Output,sc);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returned from Customer Storage   (2 >> 3)
    //<< ;
    //<< ; History:
    //<< ; 16-Aug-2010   PPP     SR16573:Created
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set strDefaultStorage = %this.ManuReturnStorage
    mVar strDefaultStorage = m$.var("strDefaultStorage");
    strDefaultStorage.set(this.ManuReturnStorage);
    //<< 
    //<< if (strDefaultStorage = "") {
    if ((mOp.Equal(strDefaultStorage.get(),""))) {
      //<< set strDefaultStorage = $$$INVORGBReturnStockLocation($get(^INVORGB(0,%this.Company,%this.Location,1)))
      strDefaultStorage.set(include.INConst.$$$INVORGBReturnStockLocation(m$,m$.Fnc.$get(m$.var("^INVORGB",0,this.Company,this.Location,1))));
    }
    //<< }
    //<< 
    //<< set objStorage = $$$NULLOREF
    mVar objStorage = m$.var("objStorage");
    objStorage.set(include.$occConstant.$$$NULLOREF(m$));
    //<< if (strDefaultStorage '= "") {
    if ((mOp.NotEqual(strDefaultStorage.get(),""))) {
      //<< set objStorage = ##class(alLOC.dUStorage).%OpenId("0||"_%this.Location_"||"_strDefaultStorage)
      objStorage.set(m$.fnc$("alLOC.dUStorage.$OpenId",mOp.Concat(mOp.Concat(mOp.Concat("0||",this.Location),"||"),strDefaultStorage.get())));
    }
    //<< }
    //<< 
    //<< if (objStorage = $$$NULLOREF) {
    if ((mOp.Equal(objStorage.get(),include.$occConstant.$$$NULLOREF(m$)))) {
      //<< set strMessage = $$$Text($listbuild("alLOC0010",$$$StrWWW0121ManuReturnStorage,%this.Location))
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0010",include.WWWConst.$$$StrWWW0121ManuReturnStorage(m$),this.Location)));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< } ; "No default storage found for location %1"
    //<< 
    //<< quit objStorage
    return objStorage.get();
  //<< }
  }

  //<< 
  //<< /*
  //<< /// Checks to see if the object identified by the ID <var>id</var> exists in the extent.
  //<< ///
  //<< /// <p>Returns <CLASS>%Boolean</CLASS> TRUE is it exists, FALSE if it does not.
  //<< ClassMethod %ExistsId(id As %String) As %Boolean [ CodeMode = generator, ProcedureBlock = 1 ]
  //<< {
  //<< ;-------------------------------------------------------------------------------
  //<< ; Wrapper to prepend company to key before checking for record
  //<< ;
  //<< ; History
  //<< ; 27-Nov-2007   GRF     SR15615: Created
  //<< ;-------------------------------------------------------------------------------
  //<< set %code=0
  //<< $$$GENERATE(" quit ##super(""0||""_id)")
  //<< quit $$$OK
  //<< }
  //<< */
  //<< ClassMethod ConvertOnSave(
  //<< pKey As %String,
  //<< pblnExcludeStorage = 0) As %Status
  public Object ConvertOnSave(Object ... _p) {
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnExcludeStorage = m$.newVarRef("pblnExcludeStorage",(((_p!=null)&&(_p.length>=2))?_p[1]:null),0);
    m$.newVarExcept(pKey,pblnExcludeStorage);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 24-Jan-2011   PPP     SR17652 - New parameter and check (pblnExcludeStorage)
    //<< ; 21-Jan-2009   HQN     SR16318: Save Storage info
    //<< ; 24-Oct-2008   PPP     SR16057:1. If no Name set it to be the Code
    //<< ; 26-Sep-2008   GRF     SR15932: '' for boolean conversion; Update Posting
    //<< ;                           Characteristics
    //<< ; 31-Jul-2008   Luke    SR15814: corrected the sc formation using $$$Text
    //<< ; 26-Jun-2008   GRF     SR15796: Standardise error text
    //<< ; 20-Jun-2008   GRF     SR15793: split key if necessary
    //<< ; 23-May-2008   GRF     Remove duplicated NULLOREF test
    //<< ; 04-Apr-2008   GRF     SR15650: sc is third parameter of %OpenId
    //<< ; 04-Mar-2008   Luke    added storages V2 through iLoc interface
    //<< ; 21-feb-2008   Luke    SR15634: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< if pKey[$$$COMMA set pKey = $$$KEY2(pKey)  ; SR15793
    if (mOp.Contains(pKey.get(),include.COMSYSString.$$$COMMA(m$))) {
      pKey.set(include.COMSYSWWW.$$$KEY2(m$,pKey));
    }
    //<< 
    //<< set objV1 = ##class(alLOC.dULocation).%OpenId("0||"_pKey,2)
    mVar objV1 = m$.var("objV1");
    objV1.set(m$.fnc$("alLOC.dULocation.$OpenId",mOp.Concat("0||",pKey.get()),2));
    //<< 
    //<< if objV1 '= $$$NULLOREF {
    if (mOp.NotEqual(objV1.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< if ##class(alLOC.dLocation).%ExistsId(objV1.Location) {
      if (mOp.Logical(m$.fnc$("alLOC.dLocation.$ExistsId",m$.prop(objV1.get(),"Location").get()))) {
        //<< set objLocn  = ##class(alLOC.dLocation).%OpenId(objV1.Location)
        mVar objLocn = m$.var("objLocn");
        objLocn.set(m$.fnc$("alLOC.dLocation.$OpenId",m$.prop(objV1.get(),"Location").get()));
      }
      //<< } else {
      else {
        //<< set objLocn  = ##class(alLOC.dLocation).%New()
        mVar objLocn = m$.var("objLocn");
        objLocn.set(m$.fnc$("alLOC.dLocation.$New"));
      }
      //<< }
      //<< 
      //<< set objPar = $$$NULLOREF
      mVar objPar = m$.var("objPar");
      objPar.set(include.$occConstant.$$$NULLOREF(m$));
      //<< if objV1.ParentLocn '= $$$NULLOREF {
      if (mOp.NotEqual(m$.prop(objV1.get(),"ParentLocn").get(),include.$occConstant.$$$NULLOREF(m$))) {
        //<< set sc = ##class(alLOC.dULocation).ConvertOnSave(objV1.ParentLocn,pblnExcludeStorage)   //SR17652
        sc.set(m$.fnc$("alLOC.dULocation.ConvertOnSave",m$.prop(objV1.get(),"ParentLocn").get(),pblnExcludeStorage.get()));
        //<< if $$$ISOK(sc) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
          //<< set objPar = ##class(alLOC.dLocation).%OpenId(objV1.ParentLocn,,.sc)
          objPar.set(m$.fnc$("alLOC.dLocation.$OpenId",m$.prop(objV1.get(),"ParentLocn").get(),null,sc));
        }
      }
      //<< }
      //<< }
      //<< if $$$ISOK(sc) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
        //<< set objLocn.ParentLocn   = objPar
        mVar objLocn = m$.var("objLocn");
        m$.prop(objLocn.get(),"ParentLocn").set(objPar.get());
        //<< 
        //<< set strName = objV1.LocationName
        mVar strName = m$.var("strName");
        strName.set(m$.prop(objV1.get(),"LocationName").get());
        //<< if strName="" {
        if (mOp.Equal(strName.get(),"")) {
          //<< set strName = objV1.Location
          strName.set(m$.prop(objV1.get(),"Location").get());
        }
        //<< }
        //<< 
        //<< set objLocn.Code         = objV1.Location
        m$.prop(objLocn.get(),"Code").set(m$.prop(objV1.get(),"Location").get());
        //<< set objLocn.Name         = strName
        m$.prop(objLocn.get(),"Name").set(strName.get());
        //<< set objLocn.CompanyName  = objV1.CompanyName
        m$.prop(objLocn.get(),"CompanyName").set(m$.prop(objV1.get(),"CompanyName").get());
        //<< set objLocn.Street       = objV1.Street
        m$.prop(objLocn.get(),"Street").set(m$.prop(objV1.get(),"Street").get());
        //<< set objLocn.Zipcode      = objV1.Zipcode
        m$.prop(objLocn.get(),"Zipcode").set(m$.prop(objV1.get(),"Zipcode").get());
        //<< set objLocn.City         = objV1.City
        m$.prop(objLocn.get(),"City").set(m$.prop(objV1.get(),"City").get());
        //<< set objLocn.Telephone    = objV1.Tel
        m$.prop(objLocn.get(),"Telephone").set(m$.prop(objV1.get(),"Tel").get());
        //<< set objLocn.Telephone2   = objV1.Telephone2
        m$.prop(objLocn.get(),"Telephone2").set(m$.prop(objV1.get(),"Telephone2").get());
        //<< set objLocn.Telefax      = objV1.Telefax
        m$.prop(objLocn.get(),"Telefax").set(m$.prop(objV1.get(),"Telefax").get());
        //<< set objLocn.Email        = objV1.Email
        m$.prop(objLocn.get(),"Email").set(m$.prop(objV1.get(),"Email").get());
        //<< set objLocn.Route        = objV1.RoutingDescription
        m$.prop(objLocn.get(),"Route").set(m$.prop(objV1.get(),"RoutingDescription").get());
        //<< set objLocn.Picture      = objV1.Picture
        m$.prop(objLocn.get(),"Picture").set(m$.prop(objV1.get(),"Picture").get());
        //<< set objLocn.TimeZoneGMT  = objV1.TimedifferenceGMT
        m$.prop(objLocn.get(),"TimeZoneGMT").set(m$.prop(objV1.get(),"TimedifferenceGMT").get());
        //<< set objLocn.PostingChar1 = objV1.PostingCharacteristic1
        m$.prop(objLocn.get(),"PostingChar1").set(m$.prop(objV1.get(),"PostingCharacteristic1").get());
        //<< set objLocn.PostingChar2 = objV1.PostingCharacteristic2
        m$.prop(objLocn.get(),"PostingChar2").set(m$.prop(objV1.get(),"PostingCharacteristic2").get());
        //<< 
        //<< set objLocn.IsProductionLocn       = ''objV1.ProductionLocn
        m$.prop(objLocn.get(),"IsProductionLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"ProductionLocn").get())));
        //<< set objLocn.IsTransferLocn         = ''objV1.DistributionLocn
        m$.prop(objLocn.get(),"IsTransferLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"DistributionLocn").get())));
        //<< set objLocn.IsSalesLocn            = ''objV1.SalesLocn
        m$.prop(objLocn.get(),"IsSalesLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"SalesLocn").get())));
        //<< set objLocn.IsInventoryLocn        = ''objV1.StorageLocn
        m$.prop(objLocn.get(),"IsInventoryLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"StorageLocn").get())));
        //<< set objLocn.IsPurchaseLocn         = ''objV1.PurchaseLocn
        m$.prop(objLocn.get(),"IsPurchaseLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"PurchaseLocn").get())));
        //<< set objLocn.IsAdminLocn            = ''objV1.AdminLocn
        m$.prop(objLocn.get(),"IsAdminLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"AdminLocn").get())));
        //<< set objLocn.IsPlanningLocn         = ''objV1.PlanningLocn
        m$.prop(objLocn.get(),"IsPlanningLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"PlanningLocn").get())));
        //<< set objLocn.AutoReceiptOfTransfers = ''objV1.AutoReceiptTransferOrders
        m$.prop(objLocn.get(),"AutoReceiptOfTransfers").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"AutoReceiptTransferOrders").get())));
        //<< 
        //<< //SR17652 PPP
        //<< if '$get(pblnExcludeStorage) {
        if (mOp.Not(m$.Fnc.$get(pblnExcludeStorage))) {
          //<< ; SR16318 vvvv
          //<< if $$$ISOK(sc) && (objV1.OnHandStorage      '="") set objLocn.OnHandStorage         = ##class(alLOC.iLOC).GetStorage(objV1.Location,objV1.OnHandStorage,.sc)
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc)) && (mOp.NotEqual(m$.prop(objV1.get(),"OnHandStorage").get(),""))) {
            m$.prop(objLocn.get(),"OnHandStorage").set(m$.fnc$("alLOC.iLOC.GetStorage",m$.prop(objV1.get(),"Location").get(),m$.prop(objV1.get(),"OnHandStorage").get(),sc));
          }
          //<< if $$$ISOK(sc) && (objV1.ReceiptStorage     '="") set objLocn.ReceiptStorage        = ##class(alLOC.iLOC).GetStorage(objV1.Location,objV1.ReceiptStorage,.sc)
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc)) && (mOp.NotEqual(m$.prop(objV1.get(),"ReceiptStorage").get(),""))) {
            m$.prop(objLocn.get(),"ReceiptStorage").set(m$.fnc$("alLOC.iLOC.GetStorage",m$.prop(objV1.get(),"Location").get(),m$.prop(objV1.get(),"ReceiptStorage").get(),sc));
          }
          //<< if $$$ISOK(sc) && (objV1.DespatchStorage    '="") set objLocn.DespatchStorage       = ##class(alLOC.iLOC).GetStorage(objV1.Location,objV1.DespatchStorage,.sc)
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc)) && (mOp.NotEqual(m$.prop(objV1.get(),"DespatchStorage").get(),""))) {
            m$.prop(objLocn.get(),"DespatchStorage").set(m$.fnc$("alLOC.iLOC.GetStorage",m$.prop(objV1.get(),"Location").get(),m$.prop(objV1.get(),"DespatchStorage").get(),sc));
          }
          //<< if $$$ISOK(sc) && (objV1.SuppReturnStorage  '="") set objLocn.SupplierReturnStorage = ##class(alLOC.iLOC).GetStorage(objV1.Location,objV1.SuppReturnStorage,.sc)
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc)) && (mOp.NotEqual(m$.prop(objV1.get(),"SuppReturnStorage").get(),""))) {
            m$.prop(objLocn.get(),"SupplierReturnStorage").set(m$.fnc$("alLOC.iLOC.GetStorage",m$.prop(objV1.get(),"Location").get(),m$.prop(objV1.get(),"SuppReturnStorage").get(),sc));
          }
          //<< if $$$ISOK(sc) && (objV1.CustReturnStorage  '="") set objLocn.CustomerReturnStorage = ##class(alLOC.iLOC).GetStorage(objV1.Location,objV1.CustReturnStorage,.sc)
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc)) && (mOp.NotEqual(m$.prop(objV1.get(),"CustReturnStorage").get(),""))) {
            m$.prop(objLocn.get(),"CustomerReturnStorage").set(m$.fnc$("alLOC.iLOC.GetStorage",m$.prop(objV1.get(),"Location").get(),m$.prop(objV1.get(),"CustReturnStorage").get(),sc));
          }
          //<< if $$$ISOK(sc) && (objV1.MissingStockStorage'="") set objLocn.MissingStockStorage   = ##class(alLOC.iLOC).GetStorage(objV1.Location,objV1.MissingStockStorage,.sc)
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc)) && (mOp.NotEqual(m$.prop(objV1.get(),"MissingStockStorage").get(),""))) {
            m$.prop(objLocn.get(),"MissingStockStorage").set(m$.fnc$("alLOC.iLOC.GetStorage",m$.prop(objV1.get(),"Location").get(),m$.prop(objV1.get(),"MissingStockStorage").get(),sc));
          }
          //<< if $$$ISOK(sc) && (objV1.DamagedStockStorage'="") set objLocn.DamagedStockStorage   = ##class(alLOC.iLOC).GetStorage(objV1.Location,objV1.DamagedStockStorage,.sc)
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc)) && (mOp.NotEqual(m$.prop(objV1.get(),"DamagedStockStorage").get(),""))) {
            m$.prop(objLocn.get(),"DamagedStockStorage").set(m$.fnc$("alLOC.iLOC.GetStorage",m$.prop(objV1.get(),"Location").get(),m$.prop(objV1.get(),"DamagedStockStorage").get(),sc));
          }
          //<< ; SR16318 ^^^^
          //<< //SR16573
          //<< if $$$ISOK(sc) && (objV1.ManuReturnStorage  '="") set objLocn.ManuReturnStorage = ##class(alLOC.iLOC).GetStorage(objV1.Location,objV1.ManuReturnStorage,.sc)
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc)) && (mOp.NotEqual(m$.prop(objV1.get(),"ManuReturnStorage").get(),""))) {
            m$.prop(objLocn.get(),"ManuReturnStorage").set(m$.fnc$("alLOC.iLOC.GetStorage",m$.prop(objV1.get(),"Location").get(),m$.prop(objV1.get(),"ManuReturnStorage").get(),sc));
          }
        }
        //<< }
        //<< 
        //<< if $$$ISOK(sc) set sc = objLocn.%Save() ; SR16318
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
          sc.set(m$.fnc$(objLocn.getORef(),"%Save"));
        }
      }
    }
    //<< }
    //<< 
    //<< ; TODO : <GRF> Need to pass Posting Characteristics and Location Type as well
    //<< } else {
    else {
      //<< set strMessage = $$$Text($listbuild("alLOC0005",pKey))
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0005",pKey.get())));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< }  ; "Can not Convert Location (%1)"
    //<< 
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< ClassMethod ConvertOnDelete(pKey As %String) As %Status
  public Object ConvertOnDelete(Object ... _p) {
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(pKey);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Assumes @nM validation will ensure all storages and child locations are
    //<< ; deleted before location is deleted.
    //<< ;
    //<< ; History
    //<< ; 18-Mar-2009   DavidR  SR16406: added Listbuild to error
    //<< ; 29-sep-2008   Luke    SR15936: Check the V2 data reply to the user
    //<< ; 22-Sep-2008   Luke    SR15936: added message to inform user of issues with data
    //<< ; 18-Sep-2008   GRF     SR15927: variable should be objLocn; operation should be
    //<< ;                           %DeleteId not %Delete
    //<< ; 20-Jun-2008   GRF     SR15793: split key if necessary
    //<< ; 26-Feb-2008   GRF     SR15622: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< if pKey[$$$COMMA set pKey = $$$KEY2(pKey)
    if (mOp.Contains(pKey.get(),include.COMSYSString.$$$COMMA(m$))) {
      pKey.set(include.COMSYSWWW.$$$KEY2(m$,pKey));
    }
    //<< 
    //<< set objV1 = ##class(alLOC.dULocation).%OpenId("0||"_pKey)
    mVar objV1 = m$.var("objV1");
    objV1.set(m$.fnc$("alLOC.dULocation.$OpenId",mOp.Concat("0||",pKey.get())));
    //<< if objV1 '= $$$NULLOREF {
    if (mOp.NotEqual(objV1.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< set objLocn = ##class(alLOC.dLocation).%OpenId(objV1.Location)
      mVar objLocn = m$.var("objLocn");
      objLocn.set(m$.fnc$("alLOC.dLocation.$OpenId",m$.prop(objV1.get(),"Location").get()));
      //<< if objLocn '= $$$NULLOREF {
      if (mOp.NotEqual(objLocn.get(),include.$occConstant.$$$NULLOREF(m$))) {
        //<< 
        //<< if objLocn.Storages.Count() > 0 {
        if (mOp.Greater(m$.fnc$(objLocn.getORef(),"Storages.Count"),0)) {
          //<< set strMessage = $$$Text($listbuild("alLOC0008",pKey))
          mVar strMessage = m$.var("strMessage");
          strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0008",pKey.get())));
          //<< set sc = $$$ERROR($$$GeneralError,strMessage)
          sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
        }
        //<< ;   "Can not Delete Location (%1) as storages still exist. Please remove all Storages from this location"
        //<< 
        //<< } else {
        else {
          //<< set sc = ##class(alLOC.dLocation).%DeleteId(objLocn.%Id())
          sc.set(m$.fnc$("alLOC.dLocation.$DeleteId",m$.fnc$(objLocn.getORef(),"%Id")));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set strMessage = $$$Text($listbuild("alLOC0007",pKey))
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alLOC0007",pKey.get())));
      //<< set sc = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< }  ; "Can not delete location (%1).  Please review the validity of the data."
    //<< 
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< ClassMethod LoadV2() As %Status
  public Object LoadV2() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Initial take on of V1 data to V2
    //<< ;
    //<< ; History
    //<< ; 26-Feb-2008   GRF     SR15622: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set sc      = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< set strTemp = " Start load V2"
    mVar strTemp = m$.var("strTemp");
    strTemp.set(" Start load V2");
    //<< 
    //<< set idLocn = ""
    mVar idLocn = m$.var("idLocn");
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
      //<< //Exclude Storages conversion (flag)
      //<< set sc = ##class(alLOC.dULocation).ConvertOnSave(idLocn,$$$YES)
      sc.set(m$.fnc$("alLOC.dULocation.ConvertOnSave",idLocn.get(),include.COMSYS.$$$YES(m$)));
      //<< 
      //<< if $$$ISOK(sc) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
        //<< set idStore = ""
        mVar idStore = m$.var("idStore");
        idStore.set("");
        //<< for {
        for (;true;) {
          //<< set idStore = $order(^INLP(0,idLocn,idStore))
          idStore.set(m$.Fnc.$order(m$.var("^INLP",0,idLocn.get(),idStore.get())));
          //<< quit:idStore=""
          if (mOp.Equal(idStore.get(),"")) {
            break;
          }
          //<< 
          //<< 
          //<< set sc = ##class(alLOC.dUStorage).ConvertOnSave(idLocn_","_idStore)
          sc.set(m$.fnc$("alLOC.dUStorage.ConvertOnSave",mOp.Concat(mOp.Concat(idLocn.get(),","),idStore.get())));
          //<< 
          //<< quit:$$$ISERR(sc)
          if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
            break;
          }
        }
      }
      //<< }
      //<< }
      //<< quit:$$$ISERR(sc)
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
        break;
      }
      //<< 
      //<< //Adhoc PPP
      //<< set sc = ##class(alLOC.dULocation).ConvertOnSave(idLocn)
      sc.set(m$.fnc$("alLOC.dULocation.ConvertOnSave",idLocn.get()));
      //<< quit:$$$ISERR(sc)
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
        break;
      }
    }
    //<< 
    //<< }
    //<< 
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< ClassMethod ConvertOnSaveTest(pKey As %String) As %Status
  public Object ConvertOnSaveTest(Object ... _p) {
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(pKey);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History
    //<< ; 20-Jun-2008   GRF     SR15793: split key if necessary
    //<< ; 04-Mar-2008   Luke    added storages V2 through iLoc interface
    //<< ; 21-feb-2008   Luke    SR15634: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< if pKey[$$$COMMA set pKey = $$$KEY2(pKey)
    if (mOp.Contains(pKey.get(),include.COMSYSString.$$$COMMA(m$))) {
      pKey.set(include.COMSYSWWW.$$$KEY2(m$,pKey));
    }
    //<< 
    //<< set objV1 = ##class(alLOC.dULocation).%OpenId("0||"_pKey)
    mVar objV1 = m$.var("objV1");
    objV1.set(m$.fnc$("alLOC.dULocation.$OpenId",mOp.Concat("0||",pKey.get())));
    //<< if objV1 '= $$$NULLOREF {
    if (mOp.NotEqual(objV1.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< set objLocn  = ##class(alLOC.dLocation).%OpenId(objV1.Location)
      mVar objLocn = m$.var("objLocn");
      objLocn.set(m$.fnc$("alLOC.dLocation.$OpenId",m$.prop(objV1.get(),"Location").get()));
      //<< if objLocn = $$$NULLOREF {
      if (mOp.Equal(objLocn.get(),include.$occConstant.$$$NULLOREF(m$))) {
        //<< set objLocn  = ##class(alLOC.dLocation).%New()
        objLocn.set(m$.fnc$("alLOC.dLocation.$New"));
      }
      //<< }
      //<< set objPar  = $$$NULLOREF
      mVar objPar = m$.var("objPar");
      objPar.set(include.$occConstant.$$$NULLOREF(m$));
      //<< if objV1.ParentLocn '= $$$NULLOREF {
      if (mOp.NotEqual(m$.prop(objV1.get(),"ParentLocn").get(),include.$occConstant.$$$NULLOREF(m$))) {
        //<< set sc = ##class(alLOC.dULocation).ConvertOnSave(objV1.ParentLocn)
        sc.set(m$.fnc$("alLOC.dULocation.ConvertOnSave",m$.prop(objV1.get(),"ParentLocn").get()));
        //<< if $$$ISOK(sc) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
          //<< set objPar = ##class(alLOC.dLocation).%OpenId(objV1.ParentLocn)
          objPar.set(m$.fnc$("alLOC.dLocation.$OpenId",m$.prop(objV1.get(),"ParentLocn").get()));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if $$$ISOK(sc) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
        //<< set objLocn.ParentLocn     = objPar
        m$.prop(objLocn.get(),"ParentLocn").set(objPar.get());
        //<< set objLocn.Code           = objV1.Location
        m$.prop(objLocn.get(),"Code").set(m$.prop(objV1.get(),"Location").get());
        //<< set objLocn.Name           = objV1.LocationName
        m$.prop(objLocn.get(),"Name").set(m$.prop(objV1.get(),"LocationName").get());
        //<< 
        //<< set objLocn.CompanyName    = objV1.CompanyName
        m$.prop(objLocn.get(),"CompanyName").set(m$.prop(objV1.get(),"CompanyName").get());
        //<< set objLocn.Street         = objV1.Street
        m$.prop(objLocn.get(),"Street").set(m$.prop(objV1.get(),"Street").get());
        //<< set objLocn.Zipcode        = objV1.Zipcode
        m$.prop(objLocn.get(),"Zipcode").set(m$.prop(objV1.get(),"Zipcode").get());
        //<< set objLocn.City           = objV1.City
        m$.prop(objLocn.get(),"City").set(m$.prop(objV1.get(),"City").get());
        //<< set objLocn.Telephone      = objV1.Tel
        m$.prop(objLocn.get(),"Telephone").set(m$.prop(objV1.get(),"Tel").get());
        //<< set objLocn.Telephone2     = objV1.Telephone2
        m$.prop(objLocn.get(),"Telephone2").set(m$.prop(objV1.get(),"Telephone2").get());
        //<< set objLocn.Telefax        = objV1.Telefax
        m$.prop(objLocn.get(),"Telefax").set(m$.prop(objV1.get(),"Telefax").get());
        //<< set objLocn.Email          = objV1.Email
        m$.prop(objLocn.get(),"Email").set(m$.prop(objV1.get(),"Email").get());
        //<< set objLocn.Route          = objV1.RoutingDescription
        m$.prop(objLocn.get(),"Route").set(m$.prop(objV1.get(),"RoutingDescription").get());
        //<< set objLocn.Picture        = objV1.Picture
        m$.prop(objLocn.get(),"Picture").set(m$.prop(objV1.get(),"Picture").get());
        //<< set objLocn.TimeZoneGMT    = objV1.TimedifferenceGMT
        m$.prop(objLocn.get(),"TimeZoneGMT").set(m$.prop(objV1.get(),"TimedifferenceGMT").get());
        //<< 
        //<< set objLocn.IsProductionLocn       = ''objV1.ProductionLocn
        m$.prop(objLocn.get(),"IsProductionLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"ProductionLocn").get())));
        //<< set objLocn.IsTransferLocn         = ''objV1.DistributionLocn
        m$.prop(objLocn.get(),"IsTransferLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"DistributionLocn").get())));
        //<< set objLocn.IsSalesLocn            = ''objV1.SalesLocn
        m$.prop(objLocn.get(),"IsSalesLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"SalesLocn").get())));
        //<< set objLocn.IsInventoryLocn        = ''objV1.StorageLocn
        m$.prop(objLocn.get(),"IsInventoryLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"StorageLocn").get())));
        //<< set objLocn.IsPurchaseLocn         = ''objV1.PurchaseLocn
        m$.prop(objLocn.get(),"IsPurchaseLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"PurchaseLocn").get())));
        //<< set objLocn.IsAdminLocn            = ''objV1.AdminLocn
        m$.prop(objLocn.get(),"IsAdminLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"AdminLocn").get())));
        //<< set objLocn.IsPlanningLocn         = ''objV1.PlanningLocn
        m$.prop(objLocn.get(),"IsPlanningLocn").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"PlanningLocn").get())));
        //<< set objLocn.AutoReceiptOfTransfers = ''objV1.AutoReceiptTransferOrders
        m$.prop(objLocn.get(),"AutoReceiptOfTransfers").set(mOp.Not(mOp.Not(m$.prop(objV1.get(),"AutoReceiptTransferOrders").get())));
        //<< set sc = objLocn.%Save()
        sc.set(m$.fnc$(objLocn.getORef(),"%Save"));
      }
    }
    //<< }
    //<< }
    //<< ; TODO : <GRF> Need to pass Posting Characteristics as well
    //<< 
    //<< quit sc
    return sc.get();
  //<< /*
  }

  //<< set objLocn.OnHandStorage As alLOC.dStorage;
  //<< set objLocn.ReceiptStorage As alLOC.dStorage;
  //<< set objLocn.DespatchStorage As alLOC.dStorage;
  //<< set objLocn.SupplierReturnStorage As alLOC.dStorage;
  //<< set objLocn.CustomerReturnStorage As alLOC.dStorage;
  //<< set objLocn.MissingStockStorage As alLOC.dStorage;
  //<< set objLocn.DamagedStockStorage As alLOC.dStorage;
  //<< */
  //<< //set objLocn.Locations As dLocation [ Collection = list ];
  //<< }
  //<< 
  //<< /// This callback method is invoked by the <METHOD>%Open</METHOD> method to
  //<< /// provide notification that the object specified by <VAR>oid</VAR> is being opened.
  //<< ///
  //<< /// <P>If this method returns an error then the object will not be opened.
  //<< Method %OnOpen() As %Status [ Private ]
  public Object $OnOpen() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 18-Nov-2008   HQN     Only do it if there is an error: Cache2008 fixes this
    //<< ; 01-Apr-2008   HQN     Resetting %objlasterror on SQL projection warning
    //<< ;-------------------------------------------------------------------------------
    //<< if $get(%objlasterror) '= "" { ; 18-Nov-2008
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("%objlasterror")),"")) {
      //<< if (%this.%Oid() '= $$$NULLOREF) && ($$$GETERRORCODE(%objlasterror) = 5809) {
      if ((mOp.NotEqual(m$.fnc$(this,"$Oid"),include.$occConstant.$$$NULLOREF(m$))) && (mOp.Equal(include.$occStatus.$$$GETERRORCODE(m$,m$.var("%objlasterror")),5809))) {
        //<< set %objlasterror = ""
        m$.var("%objlasterror").set("");
      }
    }
    //<< }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  //<< }
  }

  //<< 
  //<< Method IsSynced() As %Status
  public Object IsSynced() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; TODO : transfer text to WWW009 - If this class is only temporary this may not
    //<< ;        be necessary.  Similarly - error processing using $$$ERROR is faster.
    //<< ;
    //<< ;
    //<< ; Validates this V1 Location against its V2 intstance,
    //<< ; show inconsistencies as errors property errors
    //<< ;
    //<< ; History:
    //<< ; 16-Aug-2010   PPP     SR16573:Added Manufacturing Return Storage check
    //<< ; 09-Nov-2009   GRF     objLocation => objLocn to shortand lines and standardise
    //<< ; 19-May-2008   Luke    SR15749 Corrected the Compare for storages
    //<< ; 15-Apr-2008   HQN     SR15672: Corrected V1 property names
    //<< ;                           Added Object lookups on storages and lists
    //<< ; 11-Apr-2008   HQN     SR15672: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set sc      = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< set objLocn = ##class(alLOC.dLocation).%OpenId(%this.Location,0,.sc)
    mVar objLocn = m$.var("objLocn");
    objLocn.set(m$.fnc$("alLOC.dLocation.$OpenId",this.Location,0,sc));
    //<< /*
    //<< if $$$ISERR(sc) {
    //<< ; Couldn't load, attempt to ConvertOnSave
    //<< set sc = ##class(alLOC.dULocation).ConvertOnSave(%this.Location)
    //<< if $$$ISOK(sc) {
    //<< set objLocn = ##class(alLOC.dLocation).%OpenId(%this.Location,0,.sc)
    //<< }
    //<< }
    //<< */
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< if (objLocn.Name        '= %this.LocationName) set sc = $system.Status.AppendStatus($system.Status.Error(5001,"LocationName Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"Name").get(),this.LocationName))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("LocationName Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.CompanyName '= %this.CompanyName)  set sc = $system.Status.AppendStatus($system.Status.Error(5001,"CompanyName Property mismatch " _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"CompanyName").get(),this.CompanyName))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CompanyName Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.Street      '= %this.Street)       set sc = $system.Status.AppendStatus($system.Status.Error(5001,"Street Property mismatch "      _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"Street").get(),this.Street))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Street Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.Zipcode     '= %this.Zipcode)      set sc = $system.Status.AppendStatus($system.Status.Error(5001,"Zipcode Property mismatch "     _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"Zipcode").get(),this.Zipcode))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Zipcode Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.City        '= %this.City)         set sc = $system.Status.AppendStatus($system.Status.Error(5001,"City Property mismatch "        _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"City").get(),this.City))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("City Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.Telephone   '= %this.Tel)          set sc = $system.Status.AppendStatus($system.Status.Error(5001,"Tel Property mismatch "         _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"Telephone").get(),this.Tel))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Tel Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.Telephone2  '= %this.Telephone2)   set sc = $system.Status.AppendStatus($system.Status.Error(5001,"Telephone2 Property mismatch "  _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"Telephone2").get(),this.Telephone2))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Telephone2 Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.Telefax     '= %this.Telefax)      set sc = $system.Status.AppendStatus($system.Status.Error(5001,"Telefax Property mismatch "     _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"Telefax").get(),this.Telefax))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Telefax Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.Email       '= %this.Email)        set sc = $system.Status.AppendStatus($system.Status.Error(5001,"Email Property mismatch "       _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"Email").get(),this.Email))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Email Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.Route '= %this.RoutingDescription) set sc = $system.Status.AppendStatus($system.Status.Error(5001,"Route Property mismatch "       _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"Route").get(),this.RoutingDescription))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Route Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< 
      //<< if (objLocn.IsProductionLocn '= ''%this.ProductionLocn)   set sc = $system.Status.AppendStatus($system.Status.Error(5001,"ProductionLocn Property mismatch "   _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"IsProductionLocn").get(),mOp.Not(mOp.Not(this.ProductionLocn))))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ProductionLocn Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.IsTransferLocn   '= ''%this.DistributionLocn) set sc = $system.Status.AppendStatus($system.Status.Error(5001,"DistributionLocn Property mismatch " _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"IsTransferLocn").get(),mOp.Not(mOp.Not(this.DistributionLocn))))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DistributionLocn Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.IsSalesLocn      '= ''%this.SalesLocn)        set sc = $system.Status.AppendStatus($system.Status.Error(5001,"SalesLocn Property mismatch "        _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"IsSalesLocn").get(),mOp.Not(mOp.Not(this.SalesLocn))))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("SalesLocn Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.IsInventoryLocn  '= ''%this.StorageLocn)      set sc = $system.Status.AppendStatus($system.Status.Error(5001,"StorageLocn Property mismatch "      _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"IsInventoryLocn").get(),mOp.Not(mOp.Not(this.StorageLocn))))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("StorageLocn Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.IsPurchaseLocn   '= ''%this.PurchaseLocn)     set sc = $system.Status.AppendStatus($system.Status.Error(5001,"PurchaseLocn Property mismatch "     _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"IsPurchaseLocn").get(),mOp.Not(mOp.Not(this.PurchaseLocn))))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("PurchaseLocn Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.IsAdminLocn      '= ''%this.AdminLocn)        set sc = $system.Status.AppendStatus($system.Status.Error(5001,"AdminLocn Property mismatch "        _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"IsAdminLocn").get(),mOp.Not(mOp.Not(this.AdminLocn))))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("AdminLocn Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.IsPlanningLocn   '= ''%this.PlanningLocn)     set sc = $system.Status.AppendStatus($system.Status.Error(5001,"PlanningLocn Property mismatch "     _%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"IsPlanningLocn").get(),mOp.Not(mOp.Not(this.PlanningLocn))))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("PlanningLocn Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.TimeZoneGMT      '= %this.TimedifferenceGMT)  set sc = $system.Status.AppendStatus($system.Status.Error(5001,"TimedifferenceGMT Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"TimeZoneGMT").get(),this.TimedifferenceGMT))) {
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("TimedifferenceGMT Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< if (objLocn.AutoReceiptOfTransfers '= ''%this.AutoReceiptTransferOrders) {
      if ((mOp.NotEqual(m$.prop(objLocn.get(),"AutoReceiptOfTransfers").get(),mOp.Not(mOp.Not(this.AutoReceiptTransferOrders))))) {
        //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"AutoReceiptTransferOrders Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("AutoReceiptTransferOrders Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< }
      //<< 
      //<< if (objLocn.OnHandStorage = $$$NULLOREF) {
      if ((mOp.Equal(m$.prop(objLocn.get(),"OnHandStorage").get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< if (%this.OnHandStorage '= "") {
        if ((mOp.NotEqual(this.OnHandStorage,""))) {
          //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"OnHandStorage property not set "_objLocn.%ClassName(1)_"::%Id("_objLocn.%Id()_")"),sc)
          sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("OnHandStorage property not set ",m$.fnc$(objLocn.getORef(),"%ClassName",1)),"::%Id("),m$.fnc$(objLocn.getORef(),"%Id")),")")),sc.get()));
        }
      }
      //<< }
      //<< } elseif (objLocn.OnHandStorage.Code '= %this.OnHandStorage) {
      else if ((mOp.NotEqual(m$.prop(objLocn.get(),"OnHandStorage.Code").get(),this.OnHandStorage))) {
        //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"OnHandStorage Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("OnHandStorage Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< }
      //<< 
      //<< if (objLocn.ReceiptStorage = $$$NULLOREF) {
      if ((mOp.Equal(m$.prop(objLocn.get(),"ReceiptStorage").get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< if (%this.ReceiptStorage '= "") {
        if ((mOp.NotEqual(this.ReceiptStorage,""))) {
          //<< write !,%this.ReceiptStorage
          m$.Cmd.Write("\n",this.ReceiptStorage);
          //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"ReceiptStorage property not set "_objLocn.%ClassName(1)_"::%Id("_objLocn.%Id()_")"),sc)
          sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ReceiptStorage property not set ",m$.fnc$(objLocn.getORef(),"%ClassName",1)),"::%Id("),m$.fnc$(objLocn.getORef(),"%Id")),")")),sc.get()));
        }
      }
      //<< }
      //<< } elseif (objLocn.ReceiptStorage.Code '= %this.ReceiptStorage) {
      else if ((mOp.NotEqual(m$.prop(objLocn.get(),"ReceiptStorage.Code").get(),this.ReceiptStorage))) {
        //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"ReceiptStorage Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ReceiptStorage Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< }
      //<< 
      //<< if (objLocn.DespatchStorage = $$$NULLOREF) {
      if ((mOp.Equal(m$.prop(objLocn.get(),"DespatchStorage").get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< if (%this.DespatchStorage '= "") {
        if ((mOp.NotEqual(this.DespatchStorage,""))) {
          //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"DespatchStorage property not set "_objLocn.%ClassName(1)_"::%Id("_objLocn.%Id()_")"),sc)
          sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DespatchStorage property not set ",m$.fnc$(objLocn.getORef(),"%ClassName",1)),"::%Id("),m$.fnc$(objLocn.getORef(),"%Id")),")")),sc.get()));
        }
      }
      //<< }
      //<< } elseif (objLocn.DespatchStorage.Code '= %this.DespatchStorage) {
      else if ((mOp.NotEqual(m$.prop(objLocn.get(),"DespatchStorage.Code").get(),this.DespatchStorage))) {
        //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"DespatchStorage Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DespatchStorage Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< }
      //<< 
      //<< if (objLocn.SupplierReturnStorage = $$$NULLOREF) {
      if ((mOp.Equal(m$.prop(objLocn.get(),"SupplierReturnStorage").get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< if (%this.SuppReturnStorage '= "") {
        if ((mOp.NotEqual(this.SuppReturnStorage,""))) {
          //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"SupplierReturnStorage property not set "_objLocn.%ClassName(1)_"::%Id("_objLocn.%Id()_")"),sc)
          sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("SupplierReturnStorage property not set ",m$.fnc$(objLocn.getORef(),"%ClassName",1)),"::%Id("),m$.fnc$(objLocn.getORef(),"%Id")),")")),sc.get()));
        }
      }
      //<< }
      //<< } elseif (objLocn.SupplierReturnStorage.Code '= %this.SuppReturnStorage) {
      else if ((mOp.NotEqual(m$.prop(objLocn.get(),"SupplierReturnStorage.Code").get(),this.SuppReturnStorage))) {
        //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"SuppReturnStorage Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("SuppReturnStorage Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< }
      //<< 
      //<< if (objLocn.CustomerReturnStorage = $$$NULLOREF) {
      if ((mOp.Equal(m$.prop(objLocn.get(),"CustomerReturnStorage").get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< if (%this.CustReturnStorage '= "") {
        if ((mOp.NotEqual(this.CustReturnStorage,""))) {
          //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001, "CustomerReturnStorage property not set "_objLocn.%ClassName(1)_"::%Id("_objLocn.%Id()_")"),sc)
          sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CustomerReturnStorage property not set ",m$.fnc$(objLocn.getORef(),"%ClassName",1)),"::%Id("),m$.fnc$(objLocn.getORef(),"%Id")),")")),sc.get()));
        }
      }
      //<< }
      //<< } elseif (objLocn.CustomerReturnStorage.Code '= %this.CustReturnStorage) {
      else if ((mOp.NotEqual(m$.prop(objLocn.get(),"CustomerReturnStorage.Code").get(),this.CustReturnStorage))) {
        //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"CustReturnStorage Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CustReturnStorage Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< }
      //<< 
      //<< //SR16573
      //<< if (objLocn.ManuReturnStorage = $$$NULLOREF) {
      if ((mOp.Equal(m$.prop(objLocn.get(),"ManuReturnStorage").get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< if (%this.ManuReturnStorage '= "") {
        if ((mOp.NotEqual(this.ManuReturnStorage,""))) {
          //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001, "ManuReturnStorage property not set "_objLocn.%ClassName(1)_"::%Id("_objLocn.%Id()_")"),sc)
          sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ManuReturnStorage property not set ",m$.fnc$(objLocn.getORef(),"%ClassName",1)),"::%Id("),m$.fnc$(objLocn.getORef(),"%Id")),")")),sc.get()));
        }
      }
      //<< }
      //<< } elseif (objLocn.ManuReturnStorage.Code '= %this.ManuReturnStorage) {
      else if ((mOp.NotEqual(m$.prop(objLocn.get(),"ManuReturnStorage.Code").get(),this.ManuReturnStorage))) {
        //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"ManuReturnStorage Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ManuReturnStorage Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< }
      //<< 
      //<< if (objLocn.MissingStockStorage = $$$NULLOREF) {
      if ((mOp.Equal(m$.prop(objLocn.get(),"MissingStockStorage").get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< if (%this.MissingStockStorage '= "") {
        if ((mOp.NotEqual(this.MissingStockStorage,""))) {
          //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001, "MissingStockStorage property not set "_objLocn.%ClassName(1)_"::%Id("_objLocn.%Id()_")"),sc)
          sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("MissingStockStorage property not set ",m$.fnc$(objLocn.getORef(),"%ClassName",1)),"::%Id("),m$.fnc$(objLocn.getORef(),"%Id")),")")),sc.get()));
        }
      }
      //<< }
      //<< } elseif (objLocn.MissingStockStorage.Code '= %this.MissingStockStorage) {
      else if ((mOp.NotEqual(m$.prop(objLocn.get(),"MissingStockStorage.Code").get(),this.MissingStockStorage))) {
        //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"MissingStockStorage Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("MissingStockStorage Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< }
      //<< 
      //<< if (objLocn.DamagedStockStorage = $$$NULLOREF) {
      if ((mOp.Equal(m$.prop(objLocn.get(),"DamagedStockStorage").get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< if (%this.DamagedStockStorage '= "") {
        if ((mOp.NotEqual(this.DamagedStockStorage,""))) {
          //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"DamagedStockStorage property not set "_objLocn.%ClassName(1)_"::%Id("_objLocn.%Id()_")"),sc)
          sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DamagedStockStorage property not set ",m$.fnc$(objLocn.getORef(),"%ClassName",1)),"::%Id("),m$.fnc$(objLocn.getORef(),"%Id")),")")),sc.get()));
        }
      }
      //<< }
      //<< } elseif (objLocn.DamagedStockStorage.Code '= %this.DamagedStockStorage) {
      else if ((mOp.NotEqual(m$.prop(objLocn.get(),"DamagedStockStorage.Code").get(),this.DamagedStockStorage))) {
        //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"DamagedStockStorage Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DamagedStockStorage Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
      //<< }
      //<< 
      //<< /*
      //<< /// list of Locations Located directly below this level in the
      //<< /// Location tree
      //<< Property Locations As dLocation [ Collection = list ];
      //<< 
      //<< /// list of Storages attached to this Location
      //<< Relationship Storages As alLOC.dStorage [ Cardinality = children, Inverse = Location ];
      //<< */
      //<< 
      //<< if (objLocn.ParentLocn = $$$NULLOREF) {
      if ((mOp.Equal(m$.prop(objLocn.get(),"ParentLocn").get(),include.$occConstant.$$$NULLOREF(m$)))) {
        //<< if (%this.ParentLocn '= "") {
        if ((mOp.NotEqual(this.ParentLocn,""))) {
          //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"ParentLocn property not set "_objLocn.%ClassName(1)_"::%Id("_objLocn.%Id()_")"),sc)
          sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ParentLocn property not set ",m$.fnc$(objLocn.getORef(),"%ClassName",1)),"::%Id("),m$.fnc$(objLocn.getORef(),"%Id")),")")),sc.get()));
        }
      }
      //<< }
      //<< } elseif (objLocn.ParentLocn.%Id() '= %this.ParentLocn) {
      else if ((mOp.NotEqual(m$.fnc$(objLocn.getORef(),"ParentLocn.%Id"),this.ParentLocn))) {
        //<< set sc = $system.Status.AppendStatus($system.Status.Error(5001,"ParentLocn Property mismatch "_%this.%ClassName(1)_"::%Id("_%this.%Id()_")"),sc)
        sc.set(m$.getSystem().getStatus().AppendStatus(m$.getSystem().getStatus().Error(5001,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("ParentLocn Property mismatch ",m$.fnc$(this,"$ClassName",1)),"::%Id("),m$.fnc$(this,"$Id")),")")),sc.get()));
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set sc = $system.Status.Error(6236,%this.Location,""_objLocn.%ClassName(1)_"::%OpenId()")
      sc.set(m$.getSystem().getStatus().Error(6236,this.Location,mOp.Concat(mOp.Concat("",m$.fnc$(objLocn.getORef(),"%ClassName",1)),"::%OpenId()")));
    }
    //<< }
    //<< quit sc
    return sc.get();
  //<< }
  }

//<< 
//<< }
}
