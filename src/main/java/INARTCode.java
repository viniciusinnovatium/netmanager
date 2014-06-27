//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTCode
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 20:29:04
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

//<< INARTCode
public class INARTCode extends mClass {

  public void main() {
    _INARTCode();
  }

  public void _INARTCode() {
  }

  //<< 
  //<< GetCode(pstrKey,&pidUnit)
  public Object GetCode(Object ... _p) {
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidUnit = m$.newVarRef("pidUnit",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;----------------------------------------------------------------------------------------------
    //<< ; Get Item Code and Unit for an entry of a String
    //<< ;
    //<< ; Params:   pstrKey : string representing Item - e.g. Our Item No, Supplier's Item No, Barcode, etc
    //<< ;
    //<< ; Returns:  idItem & Unit
    //<< ;
    //<< ; History:
    //<< ; 15-Jun-2010   SCR     SR17371: Return Unit also
    //<< ; 28-Sep-2009   shobby  SR16708: Make the test on INART the last.
    //<< ; 19-May-2009   PPP     SR16549: Updated the list to include UPC code on Supplier & Item
    //<< ;                           (INARTUPC1, INARTUPC)
    //<< ; 06-May-2009   PPP     SR16521: Barcode Scanning to identify Item
    //<< ;                       1. if Relation class = INART check for matches in the follwing  order
    //<< ;----------------------------------------------------------------------------------------------
    //<< new idItem,idxKey,idSup,idUPC,objItem,objSup,objUPC
    mVar idItem = m$.var("idItem");
    mVar idxKey = m$.var("idxKey");
    mVar idSup = m$.var("idSup");
    mVar idUPC = m$.var("idUPC");
    mVar objItem = m$.var("objItem");
    mVar objSup = m$.var("objSup");
    mVar objUPC = m$.var("objUPC");
    m$.newVar(idItem,idxKey,idSup,idUPC,objItem,objSup,objUPC);
    //<< 
    //<< set idItem  = pstrKey  ; Initially assume we are given our Item Number
    idItem.set(pstrKey.get());
    //<< ; FIXME : If that is most likely, why not check that first and bypass the other checks?
    //<< set pidUnit = ""                                                    ; SR17371:
    pidUnit.set("");
    //<< 
    //<< if $get(pstrKey)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pstrKey),"")) {
      //<< set idxKey = $$$Index(pstrKey)
      idxKey.set(include.MEDConst.$$$Index(m$,pstrKey));
      //<< 
      //<< if $order(^INARTPACKs(0,1,idxKey,""))'="" {                     ; UPC Code INARTPACK D3
      if (mOp.NotEqual(m$.Fnc.$order(m$.var("^INARTPACKs",0,1,idxKey.get(),"")),"")) {
        //<< set idItem  = $order(^INARTPACKs(0,1,idxKey,""))
        idItem.set(m$.Fnc.$order(m$.var("^INARTPACKs",0,1,idxKey.get(),"")));
        //<< set pidUnit = $order(^INARTPACKs(0,1,idxKey,idItem,""))     ; SR17371: Use the Outer unit
        pidUnit.set(m$.Fnc.$order(m$.var("^INARTPACKs",0,1,idxKey.get(),idItem.get(),"")));
      }
      //<< 
      //<< } elseif $order(^INARTKs(0,2,idxKey,""))'="" {                  ; Suppliers UPC Code INARTK D73
      else if (mOp.NotEqual(m$.Fnc.$order(m$.var("^INARTKs",0,2,idxKey.get(),"")),"")) {
        //<< set idItem = $order(^INARTKs(0,2,idxKey,""))
        idItem.set(m$.Fnc.$order(m$.var("^INARTKs",0,2,idxKey.get(),"")));
        //<< set idSup  = $order(^INARTKs(0,2,idxKey,idItem,""))         ; SR17371: Start
        idSup.set(m$.Fnc.$order(m$.var("^INARTKs",0,2,idxKey.get(),idItem.get(),"")));
        //<< if idSup'="" {
        if (mOp.NotEqual(idSup.get(),"")) {
          //<< set objSup  = $get(^INARTK(0,idItem,idSup,1))
          objSup.set(m$.Fnc.$get(m$.var("^INARTK",0,idItem.get(),idSup.get(),1)));
          //<< set pidUnit = $$$INARTKSupplierUPCCode(objSup)          ; SR17371: use supplier unit
          pidUnit.set(include.INConst.$$$INARTKSupplierUPCCode(m$,objSup));
        }
      }
      //<< } ; FIXME : $$$INARTKSupplierUPCCode is not an "EINHEIT" relation
      //<< 
      //<< } elseif $order(^INARTUPCs(0,1,idxKey,""))'="" {                ; UPC Code for Supplier INARTUPC1 P2
      else if (mOp.NotEqual(m$.Fnc.$order(m$.var("^INARTUPCs",0,1,idxKey.get(),"")),"")) {
        //<< set idItem = $order(^INARTUPCs(0,1,idxKey,""))
        idItem.set(m$.Fnc.$order(m$.var("^INARTUPCs",0,1,idxKey.get(),"")));
        //<< set idSup  = $order(^INARTUPCs(0,1,idxKey,idItem,""))       ; SR17371: Start
        idSup.set(m$.Fnc.$order(m$.var("^INARTUPCs",0,1,idxKey.get(),idItem.get(),"")));
        //<< if idSup'="" {
        if (mOp.NotEqual(idSup.get(),"")) {
          //<< set idUPC = $order(^INARTUPCs(0,1,idxKey,idItem,idSup,""))
          idUPC.set(m$.Fnc.$order(m$.var("^INARTUPCs",0,1,idxKey.get(),idItem.get(),idSup.get(),"")));
          //<< if idUPC'="" {
          if (mOp.NotEqual(idUPC.get(),"")) {
            //<< set objUPC  = $get(^INARTUPC(0,idItem,idSup,idUPC,1))
            objUPC.set(m$.Fnc.$get(m$.var("^INARTUPC",0,idItem.get(),idSup.get(),idUPC.get(),1)));
            //<< set pidUnit = $$$INARTUPCPackingUnit(objUPC)        ; Use suppliers upc unit
            pidUnit.set(include.INConst.$$$INARTUPCPackingUnit(m$,objUPC));
          }
          //<< }
          //<< if pidUnit="" {
          if (mOp.Equal(pidUnit.get(),"")) {
            //<< set objSup  = $get(^INARTK(0,idItem,idSup,1))
            objSup.set(m$.Fnc.$get(m$.var("^INARTK",0,idItem.get(),idSup.get(),1)));
            //<< set pidUnit = $$$INARTKSupplierUPCCode(objSup)      ; SR17371: else use suppliers unit
            pidUnit.set(include.INConst.$$$INARTKSupplierUPCCode(m$,objSup));
          }
        }
      }
      //<< } ; FIXME : $$$INARTKSupplierUPCCode is not an "EINHEIT" relation
      //<< }
      //<< 
      //<< } elseif $order(^INARTUPC1s(0,1,idxKey,""))'="" {               ; UPC Code Item INARTUPC P2
      else if (mOp.NotEqual(m$.Fnc.$order(m$.var("^INARTUPC1s",0,1,idxKey.get(),"")),"")) {
        //<< set idItem = $order(^INARTUPC1s(0,1,idxKey,""))
        idItem.set(m$.Fnc.$order(m$.var("^INARTUPC1s",0,1,idxKey.get(),"")));
        //<< set idUPC  = $order(^INARTUPC1s(0,1,idxKey,idItem,""))      ; SR17371: Start
        idUPC.set(m$.Fnc.$order(m$.var("^INARTUPC1s",0,1,idxKey.get(),idItem.get(),"")));
        //<< if idUPC'="" {
        if (mOp.NotEqual(idUPC.get(),"")) {
          //<< set objUPC  = $get(^INARTUPC1(0,idItem,idUPC,1))
          objUPC.set(m$.Fnc.$get(m$.var("^INARTUPC1",0,idItem.get(),idUPC.get(),1)));
          //<< set pidUnit = $$$INARTUPC1PackingUnit(objUPC)           ; SR17371: use item upc
          pidUnit.set(include.INConst.$$$INARTUPC1PackingUnit(m$,objUPC));
        }
      }
      //<< }
      //<< 
      //<< } elseif ($order(^INARTs(0,3,idxKey,""))'="") {                 ; UPC Code INART D2
      else if ((mOp.NotEqual(m$.Fnc.$order(m$.var("^INARTs",0,3,idxKey.get(),"")),""))) {
        //<< set idItem = $order(^INARTs(0,3,idxKey,""))
        idItem.set(m$.Fnc.$order(m$.var("^INARTs",0,3,idxKey.get(),"")));
      }
      //<< 
      //<< } elseif $data(^INART(0,pstrKey)) {                             ; Item Code INART P1
      else if (mOp.Logical(m$.Fnc.$data(m$.var("^INART",0,pstrKey.get())))) {
        //<< set idItem = pstrKey  ; FIXME : This was set in the first lines - redundant
        idItem.set(pstrKey.get());
      }
    }
    //<< }
    //<< 
    //<< }
    //<< if (pidUnit="") && (idItem'="") {                           ; SR17371: Start
    if ((mOp.Equal(pidUnit.get(),"")) && (mOp.NotEqual(idItem.get(),""))) {
      //<< set objItem = $get(^INART(0,idItem,1))
      objItem.set(m$.Fnc.$get(m$.var("^INART",0,idItem.get(),1)));
      //<< set pidUnit = $$$INARTUnitofMeasure(objItem)            ; SR17371: Default to item unit
      pidUnit.set(include.INConst.$$$INARTUnitofMeasure(m$,objItem));
    }
    //<< }
    //<< quit idItem
    return idItem.get();
  }

//<< 
//<< 
}
