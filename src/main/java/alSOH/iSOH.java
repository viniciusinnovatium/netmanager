//*****************************************************************************
//** TASC - ALPHALINC - CLASS alSOH.iSOH
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 18:20:21
//*****************************************************************************

package alSOH;

import mLibrary.*;

//<< Include (%occInclude, COMSYS)
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;
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

//<< 
//<< /// <h1><u>Stock On Hand (SOH) Module</u></h1>
//<< /// <br>
//<< /// To use the SOH module, you must first create a transaction. <br>
//<< /// All changes to the SOH must be instigated by a correctly formed <code>StockHistory</code> object<br>
//<< /// This forces a Audit trail to be formed and the correct use of the module.<br>
//<< /// However, GetSOH <b>does not</b> need a <code>StockHistory</code> object as it only<br>
//<< /// reports the amount on hand and does not change the data of the module.
//<< /// <p>
//<< Class alSOH.iSOH [ Abstract, ClassType = "", ProcedureBlock ]
public class iSOH extends mAbstract {

  //<< {
  //<< 
  //<< /// <h3>Get a Bundle for an Item</h3>
  //<< /// <PRE>
  //<< ///  This will check for an existing bundle and create a new bundle if required
  //<< ///
  //<< ///  <h4>Params:</h4>
  //<< ///  pBundleProperties          Array of Attributes to search for
  //<< ///
  //<< ///  <h4>Returns:</h4>
  //<< ///  Returns alSOH.dBundle id.
  //<< ///  </pre>
  //<< ClassMethod testBundle() As alSOH.dBundle
  public Object testBundle() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 21-Apr-2008   HQN     SR15651: Changed concurrency to none, Item isn't changed
    //<< ;                           Changed from SQL Lookup to code generated hashcode
    //<< ; 15-Apr-2008   HQN     SR15673: Removed %RegisteredObject, interfaces should
    //<< ;                           never be able to be instantiated
    //<< ;-------------------------------------------------------------------------------
    //<< set pidItem = "dev00"
    mVar pidItem = m$.var("pidItem");
    pidItem.set("dev00");
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< set pBundleProperties = ##class(%ArrayOfDataTypes).%New()
    mVar pBundleProperties = m$.var("pBundleProperties");
    pBundleProperties.set(m$.fnc$("$ArrayOfDataTypes.$New"));
    //<< set objItem           = ##class(alINV.dItem).%OpenId(pidItem,0)
    mVar objItem = m$.var("objItem");
    objItem.set(m$.fnc$("alINV.dItem.$OpenId",pidItem.get(),0));
    //<< set objItemPolicy = objItem.ItemPolicy
    mVar objItemPolicy = m$.var("objItemPolicy");
    objItemPolicy.set(m$.prop(objItem.get(),"ItemPolicy").get());
    //<< set strHashCode   = objItemPolicy.GenerateBundleHash(objItem,.pBundleProperties)
    mVar strHashCode = m$.var("strHashCode");
    strHashCode.set(m$.fnc$(objItemPolicy.getORef(),"GenerateBundleHash",objItem.get(),pBundleProperties));
    //<< set rs = ##class(%Library.ResultSet).%New()
    mVar rs = m$.var("rs");
    rs.set(m$.fnc$("$Library.ResultSet.$New"));
    //<< 
    //<< if rs.Prepare("SELECT %ID FROM alSOH.dBundle WHERE HashKey ="""_strHashCode_"""") {
    if (mOp.Logical(m$.fnc$(rs.getORef(),"Prepare",mOp.Concat(mOp.Concat("SELECT %ID FROM alSOH.dBundle WHERE HashKey =\"",strHashCode.get()),"\"")))) {
      //<< if rs.Execute() {
      if (mOp.Logical(m$.fnc$(rs.getORef(),"Execute"))) {
        //<< if rs.Next(.sc) {
        if (mOp.Logical(m$.fnc$(rs.getORef(),"Next",sc))) {
          //<< ; Concurrency Set to 'no locking', Bundles shouldn't be edited
          //<< set objBundle = ##class(alSOH.dBundle).%OpenId(rs.Data("ID"),0)
          mVar objBundle = m$.var("objBundle");
          objBundle.set(m$.fnc$("alSOH.dBundle.$OpenId",m$.fnc$(rs.getORef(),"Data","ID"),0));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< do rs.%Close()
    m$.Cmd.Do(rs.getORef(),"$Close");
    //<< 
    //<< ; Return a new bundle based on defaults since existing one not found
    //<< if '$data(objBundle) {
    if (mOp.Not(m$.Fnc.$data(m$.var("objBundle")))) {
      //<< ; create new bundle based on policy and attributes passed in
      //<< set objBundle = ##class(alSOH.dBundle).%New()
      mVar objBundle = m$.var("objBundle");
      objBundle.set(m$.fnc$("alSOH.dBundle.$New"));
      //<< set objBundle.ItemPolicy = objItem.ItemPolicy
      m$.prop(objBundle.get(),"ItemPolicy").set(m$.prop(objItem.get(),"ItemPolicy").get());
      //<< set objBundle.Item       = objItem
      m$.prop(objBundle.get(),"Item").set(objItem.get());
      //<< 
      //<< for loop=1:1:objItemPolicy.Attributes.Count() {
      mVar loop = m$.var("loop");
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.fnc$(objItemPolicy.getORef(),"Attributes.Count")));loop.set(mOp.Add(loop.get(),1))) {
        //<< set objAttribute = objItem.ItemPolicy.Attributes.GetAt(loop).Attribute
        mVar objAttribute = m$.var("objAttribute");
        //TODO REVISAR ERRO .Attribute não esperado objAttribute.set(m$.fnc$(objItem.getORef(),"ItemPolicy.Attributes.GetAt",loop.get()).Attribute);
        //<< set objBundleAttribute = ##class(alSOH.dBundleAttribute).%New()
        mVar objBundleAttribute = m$.var("objBundleAttribute");
        objBundleAttribute.set(m$.fnc$("alSOH.dBundleAttribute.$New"));
        //<< set objBundleAttribute.Bundle         = objBundle
        m$.prop(objBundleAttribute.get(),"Bundle").set(objBundle.get());
        //<< set objBundleAttribute.AttributeName  = objAttribute.Name
        m$.prop(objBundleAttribute.get(),"AttributeName").set(m$.prop(objAttribute.get(),"Name").get());
        //<< set objBundleAttribute.AttributeValue = pBundleProperties.GetAt(objAttribute.Name)
        m$.prop(objBundleAttribute.get(),"AttributeValue").set(m$.fnc$(pBundleProperties.getORef(),"GetAt",m$.prop(objAttribute.get(),"Name").get()));
      }
      //<< }
      //<< set pStatus = objBundle.%Save()
      mVar pStatus = m$.var("pStatus");
      pStatus.set(m$.fnc$(objBundle.getORef(),"%Save"));
    }
    //<< }
    //<< quit objBundle
    return m$.var("objBundle").get();
  //<< }
  }

  //<< 
  //<< // ClassMethod GetBundle(pidItem As %String, ByRef pBundleProperties As %Library.ArrayOfDataTypes, ByRef pStatus As %Status = 1) As alSOH.dBundle
  //<< 
  //<< ClassMethod ValidateBundleProps(
  //<< pidItem As %String,
  //<< ByRef pBundleProperties As %Library.ArrayOfDataTypes,
  //<< ByRef pbundle As alSOH.dBundle) As %Status
  public Object ValidateBundleProps(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pBundleProperties = m$.newVarRef("pBundleProperties",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pbundle = m$.newVarRef("pbundle",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(pidItem,pBundleProperties,pbundle);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 18-Mar-2009   DavidR  SR16406: Adde listbuild to error
    //<< ; 23-Sep-2008   Luke    SR15877: Created added validity checks on the passed in
    //<< ;                           parameters; added a byref Status for testing
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< set objItem = ##class(alINV.dItem).%OpenId(pidItem,0)
    mVar objItem = m$.var("objItem");
    objItem.set(m$.fnc$("alINV.dItem.$OpenId",pidItem.get(),0));
    //<< 
    //<< /********************************************
    //<< Data Check
    //<< *********************************************/
    //<< 
    //<< if objItem = $$$NULLOREF {
    if (mOp.Equal(objItem.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< set strMessage = $$$Text("IN00800")
      mVar strMessage = m$.var("strMessage");
      strMessage.set(include.COMSYS.$$$Text(m$,"IN00800"));
      //<< set sc         = $$$ERROR($$$GeneralError,strMessage)
      sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
    }
    //<< } ; "Item not provided"
    //<< 
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< set objItemPolicy = objItem.ItemPolicy
      mVar objItemPolicy = m$.var("objItemPolicy");
      objItemPolicy.set(m$.prop(objItem.get(),"ItemPolicy").get());
      //<< if objItemPolicy.Attributes.Count() '= pBundleProperties.Count(){
      if (mOp.NotEqual(m$.fnc$(objItemPolicy.getORef(),"Attributes.Count"),m$.fnc$(m$.var("pBundleProperties").getORef(),"Count"))) {
        //<< set strMessage = $$$Text("alSOH0004")
        mVar strMessage = m$.var("strMessage");
        strMessage.set(include.COMSYS.$$$Text(m$,"alSOH0004"));
        //<< set sc         = $$$ERROR($$$GeneralError,strMessage)
        sc.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
      }
      //<< } ; "Incorrect amount of Properties being set for Bundle attributes"
      //<< 
      //<< 
      //<< if $$$ISOK(sc) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
        //<< for loopPolicyAttributes=1:1:objItemPolicy.Attributes.Count() {
        mVar loopPolicyAttributes = m$.var("loopPolicyAttributes");
        for (loopPolicyAttributes.set(1);(mOp.LessOrEqual(loopPolicyAttributes.get(),m$.fnc$(objItemPolicy.getORef(),"Attributes.Count")));loopPolicyAttributes.set(mOp.Add(loopPolicyAttributes.get(),1))) {
          //<< set objAttribute = objItem.ItemPolicy.Attributes.GetAt(loopPolicyAttributes).Attribute
          mVar objAttribute = m$.var("objAttribute");
        //TODO REVISAR ERRO .Attribute não esperado objAttribute.set(m$.fnc$(objItem.getORef(),"ItemPolicy.Attributes.GetAt",loopPolicyAttributes.get()).Attribute);
          //<< 
          //<< if 'pBundleProperties.IsDefined(objAttribute.Name) {
          if (mOp.Not(m$.fnc$(m$.var("pBundleProperties").getORef(),"IsDefined",m$.prop(objAttribute.get(),"Name").get()))) {
            //<< set strMessage = $$$Text($listbuild("alSOH0005",objAttribute.Name))  ;SR16406
            mVar strMessage = m$.var("strMessage");
            strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("alSOH0005",m$.prop(objAttribute.get(),"Name").get())));
            //<< set tempSC     = $$$ERROR($$$GeneralError,strMessage)
            mVar tempSC = m$.var("tempSC");
            tempSC.set(include.$occStatus.$$$ERROR(m$,include.$occErrors.$$$GeneralError(m$),strMessage));
            //<< set sc         = $$$ADDSC(tempSC,sc)
            //TODO REVISAR INCLUDE NÃO IMPLEMENTADO sc.set($$$include.$$$ADDSC(m$,tempSC,sc));
          }
        }
      }
    }
    //<< } ; "Attribute (%1) is not set correctly on the Bundle"
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< set pbundle = ##class(alSOH.iSOH).GetBundle(pidItem,pBundleProperties)
      pbundle.set(m$.fnc$("alSOH.iSOH.GetBundle",pidItem.get(),pBundleProperties.get()));
    }
    //<< }
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< /// <h3>Get a Bundle for an Item</h3>
  //<< /// <PRE>
  //<< ///  This will check for an existing bundle and create a new bundle if required
  //<< ///
  //<< ///  <h4>Params:</h4>
  //<< ///  pBundleProperties          Array of Attributes to search for
  //<< ///
  //<< ///  <h4>Returns:</h4>
  //<< ///  Returns alSOH.dBundle id.
  //<< ///  </pre>
  //<< ClassMethod GetBundle(
  //<< pidItem As %String,
  //<< ByRef pBundleProperties As %Library.ArrayOfDataTypes) As alSOH.dBundle
  public Object GetBundle(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pBundleProperties = m$.newVarRef("pBundleProperties",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.newVarExcept(pidItem,pBundleProperties);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 18-Mar-2010   PPP     SR17237: Replaced the SQL Prepare to a SQL compiled Method
    //<< ;                       (alSOH.iBundle::GetBundleIDforHashKey)
    //<< ; 06-Jan-2009   HQN     SR16268: Validation for attribute values may fail, return
    //<< ;                       $$$NULLOREF
    //<< ; 21-Apr-2008   HQN     SR15651: Changed concurrency to none, Item isn't changed
    //<< ;                           Changed from SQL Lookup to code generated hashcode
    //<< ; 15-Apr-2008   HQN     SR15673: Removed %RegisteredObject, interfaces should
    //<< ;                           never be able to be instantiated
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set objItem       = ##class(alINV.dItem).%OpenId(pidItem,0)
    mVar objItem = m$.var("objItem");
    objItem.set(m$.fnc$("alINV.dItem.$OpenId",pidItem.get(),0));
    //<< set objItemPolicy = objItem.ItemPolicy
    mVar objItemPolicy = m$.var("objItemPolicy");
    objItemPolicy.set(m$.prop(objItem.get(),"ItemPolicy").get());
    //<< 
    //<< /********************************************
    //<< get bundle
    //<< *********************************************/
    //<< 
    //<< set strHashCode   = objItemPolicy.GenerateBundleHash(objItem,.pBundleProperties)
    mVar strHashCode = m$.var("strHashCode");
    strHashCode.set(m$.fnc$(objItemPolicy.getORef(),"GenerateBundleHash",objItem.get(),pBundleProperties));
    //<< 
    //<< set idBundle = ##class(alSOH.iBundle).GetBundleIDforHashKey(strHashCode)
    mVar idBundle = m$.var("idBundle");
    idBundle.set(m$.fnc$("alSOH.iBundle.GetBundleIDforHashKey",strHashCode.get()));
    //<< if idBundle'=$$$NULLOID {
    if (mOp.NotEqual(idBundle.get(),include.$occConstant.$$$NULLOID(m$))) {
      //<< set pobjBundle = ##class(alSOH.dBundle).%OpenId(idBundle,0,.sc)
      mVar pobjBundle = m$.var("pobjBundle");
      pobjBundle.set(m$.fnc$("alSOH.dBundle.$OpenId",idBundle.get(),0,sc));
    }
    //<< }
    //<< 
    //<< /********************************************
    //<< create bundle
    //<< *********************************************/
    //<< 
    //<< ; Return a new bundle based on defaults since existing one not found
    //<< if '$data(objBundle) {
    if (mOp.Not(m$.Fnc.$data(m$.var("objBundle")))) {
      //<< ; create new bundle based on policy and attributes passed in
      //<< set objBundle = ##class(alSOH.dBundle).%New()
      mVar objBundle = m$.var("objBundle");
      objBundle.set(m$.fnc$("alSOH.dBundle.$New"));
      //<< set objBundle.ItemPolicy = objItem.ItemPolicy
      m$.prop(objBundle.get(),"ItemPolicy").set(m$.prop(objItem.get(),"ItemPolicy").get());
      //<< set objBundle.Item       = objItem
      m$.prop(objBundle.get(),"Item").set(objItem.get());
      //<< 
      //<< for loopPolicyAttributes=1:1:objItemPolicy.Attributes.Count() {
      mVar loopPolicyAttributes = m$.var("loopPolicyAttributes");
      for (loopPolicyAttributes.set(1);(mOp.LessOrEqual(loopPolicyAttributes.get(),m$.fnc$(objItemPolicy.getORef(),"Attributes.Count")));loopPolicyAttributes.set(mOp.Add(loopPolicyAttributes.get(),1))) {
        //<< set objAttribute = objItem.ItemPolicy.Attributes.GetAt(loopPolicyAttributes).Attribute
        mVar objAttribute = m$.var("objAttribute");
      //TODO REVISAR ERRO .Attribute não esperado objAttribute.set(m$.fnc$(objItem.getORef(),"ItemPolicy.Attributes.GetAt",loopPolicyAttributes.get()).Attribute);
        //<< set objBundleAttribute = ##class(alSOH.dBundleAttribute).%New()
        mVar objBundleAttribute = m$.var("objBundleAttribute");
        objBundleAttribute.set(m$.fnc$("alSOH.dBundleAttribute.$New"));
        //<< set objBundleAttribute.Bundle         = objBundle
        m$.prop(objBundleAttribute.get(),"Bundle").set(objBundle.get());
        //<< set objBundleAttribute.AttributeName  = objAttribute.Name
        m$.prop(objBundleAttribute.get(),"AttributeName").set(m$.prop(objAttribute.get(),"Name").get());
        //<< set objBundleAttribute.AttributeValue = pBundleProperties.GetAt(objAttribute.Name)
        m$.prop(objBundleAttribute.get(),"AttributeValue").set(m$.fnc$(m$.var("pBundleProperties").getORef(),"GetAt",m$.prop(objAttribute.get(),"Name").get()));
      }
      //<< }
      //<< set sc = objBundle.%Save()
      sc.set(m$.fnc$(objBundle.getORef(),"%Save"));
      //<< set:$$$ISERR(sc) objBundle = $$$NULLOREF ; SR16268
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
        objBundle.set(include.$occConstant.$$$NULLOREF(m$));
      }
    }
    //<< }
    //<< quit objBundle
    return m$.var("objBundle").get();
  //<< }
  }

  //<< 
  //<< ClassMethod SourceStock(
  //<< pidItem As %String,
  //<< pidLocn As %String,
  //<< pidStorage As %String) As %Library.ListOfObjects
  public Object SourceStock(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidStorage = m$.newVarRef("pidStorage",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(pidItem,pidLocn,pidStorage);
    //<< {
    //<< //////////////////
    //<< ///  KEEP      ///
    //<< //////////////////
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns list of alSOH.dBundleStock
    //<< ;
    //<< ; History:
    //<< ; 29-Apr-2008   GRF     SR15694: Pass optional Storage through to GetStock to
    //<< ;                           limit BundleStorages to those in that storage;
    //<< ;                           Put Item first to keep Locn with Storage
    //<< ; 22-Apr-2008   HQN     SR15673: Corrected reference to iUINV
    //<< ; 25-Mar-2008   HQN     Changed for pi calls to use true objects instead of pids
    //<< ; 20-Feb-2008   Luke    SR15625 change method callsto V2 objects
    //<< ; 24-Jan-2008   HQN     SR15625 Changed class signature dLocation to dULocation
    //<< ; 16-Nov-2007   LB      SR15598: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set objItem  = ##class(alINV.iUINV).GetItem(pidItem)   ; FIXME ,.sc // SR15673
    mVar objItem = m$.var("objItem");
    objItem.set(m$.fnc$("alINV.iUINV.GetItem",pidItem.get()));
    //<< set objLocn  = ##class(alLOC.iLOC).GetLocation(pidLocn)
    mVar objLocn = m$.var("objLocn");
    objLocn.set(m$.fnc$("alLOC.iLOC.GetLocation",pidLocn.get()));
    //<< set objStore = ##class(alLOC.iLOC).GetStorage(pidLocn,$get(pidStorage))  ; $$$NULLOREF okay here
    mVar objStore = m$.var("objStore");
    objStore.set(m$.fnc$("alLOC.iLOC.GetStorage",pidLocn.get(),m$.Fnc.$get(pidStorage)));
    //<< 
    //<< set lstStock = ##class(alSOH.piSOH).GetStock(objItem,objLocn,objStore)
    mVar lstStock = m$.var("lstStock");
    lstStock.set(m$.fnc$("alSOH.piSOH.GetStock",objItem.get(),objLocn.get(),objStore.get()));
    //<< 
    //<< quit lstStock
    return lstStock.get();
  //<< }
  }

  //<< 
  //<< ClassMethod SourceStockV2(
  //<< objItem As alINV.dItem,
  //<< objLocn As alLOC.dLocation,
  //<< objStore As alLOC.dStorage) As %Library.ListOfObjects
  public Object SourceStockV2(Object ... _p) {
    mVar objItem = m$.newVarRef("objItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar objLocn = m$.newVarRef("objLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar objStore = m$.newVarRef("objStore",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.newVarExcept(objItem,objLocn,objStore);
    //<< {
    //<< ///KEEP
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns list of alSOH.dBundleStock
    //<< ;
    //<< ; History:
    //<< ; 16-May-2008   GRF     SR15694: Copied from SourceStock
    //<< ;-------------------------------------------------------------------------------
    //<< set lstStock = ##class(alSOH.piSOH).GetStock(objItem,objLocn,$get(objStore))
    mVar lstStock = m$.var("lstStock");
    lstStock.set(m$.fnc$("alSOH.piSOH.GetStock",objItem.get(),objLocn.get(),m$.Fnc.$get(objStore)));
    //<< 
    //<< quit lstStock
    return lstStock.get();
  //<< }
  }

  //<< 
  //<< ClassMethod GetQtyOnHand(
  //<< pidItem As alINV.dItem,
  //<< pidLocn As alLOC.dLocation = "",
  //<< pidStorage As alLOC.dStorage = "",
  //<< pblnExclBlocked As %Boolean = 1) As %Float
  public Object GetQtyOnHand(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pidStorage = m$.newVarRef("pidStorage",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnExclBlocked = m$.newVarRef("pblnExclBlocked",(((_p!=null)&&(_p.length>=4))?_p[3]:null),1);
    m$.newVarExcept(pidItem,pidLocn,pidStorage,pblnExclBlocked);
    //<< {
    //<< quit ##class(alSOH.piSOHQty).GetQtyOnHand(pidItem,pidLocn,pidStorage,pblnExclBlocked)
    return m$.fnc$("alSOH.piSOHQty.GetQtyOnHand",pidItem.get(),pidLocn.get(),pidStorage.get(),pblnExclBlocked.get());
  //<< }
  }

  //<< 
  //<< ClassMethod GetQtyAvailable(
  //<< pidItem As alINV.dItem,
  //<< pidLocn As alLOC.dLocation = "",
  //<< pidStorage As alLOC.dStorage = "",
  //<< pblnExclBlocked As %Boolean = 1,
  //<< pidProgram As %String = "",
  //<< pidExclExpired As %Boolean = 1) As %Float
  public Object GetQtyAvailable(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pidStorage = m$.newVarRef("pidStorage",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnExclBlocked = m$.newVarRef("pblnExclBlocked",(((_p!=null)&&(_p.length>=4))?_p[3]:null),1);
    mVar pidProgram = m$.newVarRef("pidProgram",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pidExclExpired = m$.newVarRef("pidExclExpired",(((_p!=null)&&(_p.length>=6))?_p[5]:null),1);
    m$.newVarExcept(pidItem,pidLocn,pidStorage,pblnExclBlocked,pidProgram,pidExclExpired);
    //<< {
    //<< quit ##class(alSOH.piSOHQty).GetQtyAvailable(pidItem,pidLocn,pidStorage,pblnExclBlocked,pidProgram,pidExclExpired)
    return 1;//TODO REVISAR CLASSE piSOHQty NÃO IMPLEMENTADA m$.fnc$("alSOH.piSOHQty.GetQtyAvailable",pidItem.get(),pidLocn.get(),pidStorage.get(),pblnExclBlocked.get(),pidProgram.get(),pidExclExpired.get());
  //<< }
  }

  //<< 
  //<< // 06-Jul-2012  shobby  SR18055: New parameter pidExclExpired on GetQtyAvailable
  //<< 
  //<< ClassMethod GetQtyPlanned(
  //<< pidItem As alINV.dItem,
  //<< pidLocn As alLOC.dLocation = "",
  //<< pidStorage As alLOC.dStorage = "",
  //<< pblnExclBlocked As %Boolean = 1) As %Float
  public Object GetQtyPlanned(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pidStorage = m$.newVarRef("pidStorage",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnExclBlocked = m$.newVarRef("pblnExclBlocked",(((_p!=null)&&(_p.length>=4))?_p[3]:null),1);
    m$.newVarExcept(pidItem,pidLocn,pidStorage,pblnExclBlocked);
    //<< {
    //<< quit ##class(alSOH.piSOHQty).GetQtyPlanned(pidItem,pidLocn,pidStorage,pblnExclBlocked)
    return m$.fnc$("alSOH.piSOHQty.GetQtyPlanned",pidItem.get(),pidLocn.get(),pidStorage.get(),pblnExclBlocked.get());
  //<< }
  }

  //<< 
  //<< ClassMethod GetQtyBlocked(
  //<< pidItem As alINV.dItem,
  //<< pidLocn As alLOC.dLocation = "",
  //<< pidStorage As alLOC.dStorage = "",
  //<< pblnExclBlocked As %Boolean = 1) As %Float
  public Object GetQtyBlocked(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pidStorage = m$.newVarRef("pidStorage",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnExclBlocked = m$.newVarRef("pblnExclBlocked",(((_p!=null)&&(_p.length>=4))?_p[3]:null),1);
    m$.newVarExcept(pidItem,pidLocn,pidStorage,pblnExclBlocked);
    //<< {
    //<< quit ##class(alSOH.piSOHQty).GetQtyBlocked(pidItem,pidLocn,pidStorage,pblnExclBlocked)
    return m$.fnc$("alSOH.piSOHQty.GetQtyBlocked",pidItem.get(),pidLocn.get(),pidStorage.get(),pblnExclBlocked.get());
  //<< }
  }

  //<< 
  //<< ClassMethod GetDefaultItemPolicy(ItemId As %String) As alINV.dItemPolicy
  public Object GetDefaultItemPolicy(Object ... _p) {
    mVar ItemId = m$.newVarRef("ItemId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(ItemId);
    //<< {
    //<< //////////////////
    //<< ///  KEEP      ///
    //<< //////////////////
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;  FIXME : Don't need ItemId.
    //<< ;
    //<< ; History:
    //<< ; 22-Feb-2008   HQN     Moved logic into alINV.dItemPolicy
    //<< ; 20-Feb-2008   HQN     Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit ##class(alINV.dItemPolicy).GetDefaultItemPolicy()
    return m$.fnc$("alINV.dItemPolicy.GetDefaultItemPolicy");
  //<< }
  }

  //<< 
  //<< ClassMethod OnBuild(blnDelete As %Boolean = 0) As %Status
  public Object OnBuild(Object ... _p) {
    mVar blnDelete = m$.newVarRef("blnDelete",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    m$.newVarExcept(blnDelete);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;      ************* IF ANY CHANGES ARE TO BE MADE, LOOK AT *****************
    //<< ;                            'ConvertSOH' method
    //<< ;
    //<< ;  FIXME : Don't need blnDelete.
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 04-Sep-2008   GRF     Cleanup - disabled block => zzRetain
    //<< ; 15-Aug-2008   Luke    SR15813: Populate dTransactionType
    //<< ; 05-May-2008   HQN     Removed ReceiveDate from LotNumber Policy lookup
    //<< ; 01-May-2008   PPP     SR15705: Use ConvertSOH
    //<< ; 29-Apr-2008   Luke    SR15695: removed the purchase cost settings for the bundle creation
    //<< ; 28-Apr-2008   HQN     SR15692: Corrected Lot Number Lookup
    //<< ; 24-Apr-2008   Luke    SR15688 Removed the Storage from the Item policy
    //<< ; 22-Apr-2008   HQN     SR15673: Added dMovement to Deletions,
    //<< ;                           dStockHistory links to dMovement
    //<< ;                           Changed dStockHistory to %KillExtent due to failsafe
    //<< ;                           built in to %DeleteExtent
    //<< ; 21-Apr-2008   HQN     SR15673: Added Blank Policy, was missing
    //<< ;                           Using alSOH.dUINWE instead of User.INWE
    //<< ;                           Optionally Delete extents of SOH before repopulating
    //<< ;                           Added additional ::%Close()'s to mimise meory footprint
    //<< ; 17-Apr-2008   Luke    SR15676: Change the cost geting mechanisim
    //<< ; 16-Apr-2008   GRF     standardise layout
    //<< ; 07-Mar-2008   Luke    Moved code to use New Movements with State Engine
    //<< ; 03-Mar-2008   Luke    Edited to allow transaction handling (alSOH.dStockHistory)
    //<< ; 27-Feb-2008   Luke    Created
    //<< ;-------------------------------------------------------------------------------
    //<< set sc = ##class(alSOH.dTransactionType).Populate() ; 15-Aug-2008 Luke SR15813
    mVar sc = m$.var("sc");
    sc.set(m$.fnc$("alSOH.dTransactionType.Populate"));
    //<< quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< ClassMethod SanityCheck() As %Status
  public Object SanityCheck() {
    m$.newVar();
    //<< {
    //<< set lstFails = ##class(%Library.ListOfDataTypes).%New()
    mVar lstFails = m$.var("lstFails");
    lstFails.set(m$.fnc$("$Library.ListOfDataTypes.$New"));
    //<< 
    //<< set rs = ##class(%ResultSet).%New()
    mVar rs = m$.var("rs");
    rs.set(m$.fnc$("$ResultSet.$New"));
    //<< do rs.Prepare("select ID from alSOH.dStockBalance")
    m$.Cmd.Do(rs.getORef(),"Prepare","select ID from alSOH.dStockBalance");
    //<< do rs.Execute()
    m$.Cmd.Do(rs.getORef(),"Execute");
    //<< 
    //<< //do lstFails.Insert("Bundles to INWE")
    //<< set bundleStockTotal = 0
    mVar bundleStockTotal = m$.var("bundleStockTotal");
    bundleStockTotal.set(0);
    //<< set message2 = ""
    mVar message2 = m$.var("message2");
    message2.set("");
    //<< set message1 = ""
    mVar message1 = m$.var("message1");
    message1.set("");
    //<< 
    //<< while (rs.Next(.sc)) {
    while (mOp.Logical((m$.fnc$(rs.getORef(),"Next",m$.var("sc"))))) {
      //<< if ($SYSTEM.Status.IsOK(sc)) {  // check if this succeeded without errors
      if (mOp.Logical((m$.getSystem().getStatus().IsOK(m$.var("sc").get())))) {
        //<< set objBundleStock = ##class(alSOH.dStockBalance).%OpenId(rs.Data("ID"))
        mVar objBundleStock = m$.var("objBundleStock");
        objBundleStock.set(m$.fnc$("alSOH.dStockBalance.$OpenId",m$.fnc$(rs.getORef(),"Data","ID")));
        //<< set bundleStockTotal = objBundleStock.QtyOnHand
        bundleStockTotal.set(m$.prop(objBundleStock.get(),"QtyOnHand").get());
        //<< set tempItem = objBundleStock.Item
        mVar tempItem = m$.var("tempItem");
        tempItem.set(m$.prop(objBundleStock.get(),"Item").get());
        //<< set tempLocn = objBundleStock.Location
        mVar tempLocn = m$.var("tempLocn");
        tempLocn.set(m$.prop(objBundleStock.get(),"Location").get());
        //<< set SOHqty = 0
        mVar SOHqty = m$.var("SOHqty");
        SOHqty.set(0);
        //<< for locLoop = 1:1:tempLocn.Storages.Count() {
        mVar locLoop = m$.var("locLoop");
        for (locLoop.set(1);(mOp.LessOrEqual(locLoop.get(),m$.fnc$(tempLocn.getORef(),"Storages.Count")));locLoop.set(mOp.Add(locLoop.get(),1))) {
          //<< set tempStore = tempLocn.Storages.GetAt(locLoop)
          mVar tempStore = m$.var("tempStore");
          tempStore.set(m$.fnc$(tempLocn.getORef(),"Storages.GetAt",locLoop.get()));
          //<< set objSOH =##class(alSOH.dSOH).%OpenId(tempStore.%Id()_"||"_tempItem.%Id())
          mVar objSOH = m$.var("objSOH");
          objSOH.set(m$.fnc$("alSOH.dSOH.$OpenId",mOp.Concat(mOp.Concat(m$.fnc$(tempStore.getORef(),"%Id"),"||"),m$.fnc$(tempItem.getORef(),"%Id"))));
          //<< if objSOH '= "" {
          if (mOp.NotEqual(objSOH.get(),"")) {
            //<< //  write !,"Stockbalance" _objBundleStock.%Id()_"         SOH :" _objSOH.%Id()_"              List Count :" _lstFails.Count()
            //<< set SOHqty = SOHqty+objSOH.QtyOnHand
            SOHqty.set(mOp.Add(SOHqty.get(),m$.prop(objSOH.get(),"QtyOnHand").get()));
            //<< 
            //<< set rs3 = ##class(%ResultSet).%New()
            mVar rs3 = m$.var("rs3");
            rs3.set(m$.fnc$("$ResultSet.$New"));
            //<< do rs3.Prepare("select ID from alSOH.dBundleStock Where Storage ='" _ tempStore.%Id()_"' and Item = '" _ tempItem.%Id() _"'")
            m$.Cmd.Do(rs3.getORef(),"Prepare",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("select ID from alSOH.dBundleStock Where Storage ='",m$.fnc$(tempStore.getORef(),"%Id")),"' and Item = '"),m$.fnc$(tempItem.getORef(),"%Id")),"'"));
            //<< do rs3.Execute()
            m$.Cmd.Do(rs3.getORef(),"Execute");
            //<< set BundleQty = 0
            mVar BundleQty = m$.var("BundleQty");
            BundleQty.set(0);
            //<< while (rs3.Next(.sc)) {
            while (mOp.Logical((m$.fnc$(rs3.getORef(),"Next",m$.var("sc"))))) {
              //<< if ($SYSTEM.Status.IsOK(sc)) {  // check if this succeeded without errors
              if (mOp.Logical((m$.getSystem().getStatus().IsOK(m$.var("sc").get())))) {
                //<< set objBundle = ##class(alSOH.dBundleStock).%OpenId(rs3.Data("ID"))
                mVar objBundle = m$.var("objBundle");
                objBundle.set(m$.fnc$("alSOH.dBundleStock.$OpenId",m$.fnc$(rs3.getORef(),"Data","ID")));
                //<< set BundleQty = BundleQty + objBundle.QtyOnHand
                BundleQty.set(mOp.Add(BundleQty.get(),m$.prop(objBundle.get(),"QtyOnHand").get()));
              }
            }
            //<< }
            //<< }
            //<< if objSOH.QtyOnHand '= BundleQty {
            if (mOp.NotEqual(m$.prop(objSOH.get(),"QtyOnHand").get(),BundleQty.get())) {
              //<< set message1 = "SOH Failed With Bundles : SOH Qty " _SOHqty_ "     Over All Bundles : "_BundleQty
              message1.set(mOp.Concat(mOp.Concat(mOp.Concat("SOH Failed With Bundles : SOH Qty ",SOHqty.get()),"     Over All Bundles : "),BundleQty.get()));
              //<< do lstFails.Insert(message1)
              m$.Cmd.Do(lstFails.getORef(),"Insert",message1.get());
            }
          }
        }
        //<< }
        //<< }
        //<< 
        //<< }
        //<< 
        //<< if SOHqty '= bundleStockTotal {
        if (mOp.NotEqual(SOHqty.get(),bundleStockTotal.get())) {
          //<< set message2 = "Stockbalance Failed With SOH : bundleStockTotal :"_bundleStockTotal  _"   SOH Qty " _SOHqty_ "Over All Bundles :"
          message2.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Stockbalance Failed With SOH : bundleStockTotal :",bundleStockTotal.get()),"   SOH Qty "),SOHqty.get()),"Over All Bundles :"));
          //<< do lstFails.Insert(message2)
          m$.Cmd.Do(lstFails.getORef(),"Insert",message2.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< for loopk = 1:1:lstFails.Count() {
    mVar loopk = m$.var("loopk");
    for (loopk.set(1);(mOp.LessOrEqual(loopk.get(),m$.fnc$(lstFails.getORef(),"Count")));loopk.set(mOp.Add(loopk.get(),1))) {
      //<< write !,lstFails.GetAt(loopk)
      m$.Cmd.Write("\n",m$.fnc$(lstFails.getORef(),"GetAt",loopk.get()));
    }
    //<< }
    //<< quit
    return null; //TODO REVISAR ESTAVA RETORNANDO RETURN;
  //<< }
  }

  //<< 
  //<< ClassMethod ConvertSOH(pidItem As %String = "") As %Status
  public Object ConvertSOH(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    m$.newVarExcept(pidItem);
    //<< {
    //<< ///KEEP
    //<< ;-------------------------------------------------------------------------------
    //<< ; Interface call for the rebuilding of SOH
    //<< ;
    //<< ; History:
    //<< ; 02-May-2008   Luke    removed core code into private population interface
    //<< ; 01-May-2008   PPP     Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit ##class(alSOH.piPopulate).ConvertSOHV2(pidItem)
    return m$.fnc$("alSOH.piPopulate.ConvertSOHV2",pidItem.get());
  //<< }
  }

  //<< 
  //<< ClassMethod IsQtyAvailable(
  //<< pidItem As alSYS.dt.dtString,
  //<< pstrLocList As alSYS.dt.dtString) As alSYS.dt.dtBoolean
  public Object IsQtyAvailable(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrLocList = m$.newVarRef("pstrLocList",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.newVarExcept(pidItem,pstrLocList);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Given an Item and Location List, return if QOH exist
    //<< ;
    //<< ; Inputs :
    //<< ;   1. pidItem      alSYS.dt.dtString
    //<< ;   2. pstrLocList  alSYS.dt.dtString  e.g "5,5072" (Comma Separated List)
    //<< ;
    //<< ; Returns
    //<< ;   Boolean
    //<< ;
    //<< ; History:
    //<< ; 06-Aug-2010   PPP     SR17296: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set fltQty = 0
    mVar fltQty = m$.var("fltQty");
    fltQty.set(0);
    //<< set strLocList = (","_pstrLocList_",")
    mVar strLocList = m$.var("strLocList");
    strLocList.set((mOp.Concat(mOp.Concat(",",pstrLocList.get()),",")));
    //<< 
    //<< &SQL(
    //<< SELECT Sum({fn ABS(QtyOnHand)})
    //<< INTO :fltQty
    //<< FROM alSOH.dSOH
    //<< WHERE Item = :pidItem
    //<< AND :strLocList [ ("," || Storage->Location || ",")
    //<< 
    //<< )
    m$.Cmd.SQL();
    //<< 
    //<< quit $select(fltQty:$$$YES,1:$$$NO)
    return m$.Fnc.$select(fltQty.get(),include.COMSYS.$$$YES(m$),1,include.COMSYS.$$$NO(m$));
  //<< }
  }

//<< 
//<< }
}
