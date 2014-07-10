//*****************************************************************************
//** TASC - ALPHALINC - CLASS alLOC.dLocation
//** Innovatium Systems - Code Converter - v1.31
//** 2014-07-07 17:54:16
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
//<< Class alLOC.dLocation Extends %Persistent [ ClassType = persistent ]
public class dLocation extends mPersistent {
  //<< {
  //<< 
  //<< /*----------------------------------------------------------------------------------
  //<< ;   @netManager Element Mappings
  //<< ;-----------------------------------------------------------------------------------
  //<< ; Number    V1 Description                      Input Type
  //<< ;-----------------------------------------------------------------------------------
  //<< ;   P1      Location Number                     6 - Text
  //<< ;   D1      Location Name                       6 - Text
  //<< ;   D2      Company Name                        6 - Text
  //<< ;   D3      Company Name                        6 - Text
  //<< ;   D4      Street                              6 - Text
  //<< ;   D5      Location Type                       6 - Text
  //<< ;   D6      Zipcode                             6 - Text
  //<< ;   D8      City                                6 - Text
  //<< ;   D11     Tel.                                6 - Text
  //<< ;   D12     Telefax                             6 - Text
  //<< ;   D13     Email                               3 - Memo
  //<< ;   D14     Routing Description                 3 - Memo
  //<< ;   D15     Picture                             6 - Text
  //<< ;   D20     Parent Location                     6 - Text
  //<< ;   D21     Production Location                 2 - Yes/No
  //<< ;   D22     Transfer Location                   2 - Yes/No
  //<< ;   D23     Sales Location                      2 - Yes/No
  //<< ;   D24     Inventory Location                  2 - Yes/No
  //<< ;   D25     Purchase Location                   2 - Yes/No
  //<< ;   D26     Administrative Location             2 - Yes/No
  //<< ;   D27     Planning Location                   2 - Yes/No
  //<< ;   D40     On Hand Storage                     6 - Text
  //<< ;   D41     Receipt Storage                     6 - Text
  //<< ;   D42     Despatch Storage                    6 - Text
  //<< ;   D43     Supplier Return Storage             6 - Text
  //<< ;   D44     Customer Return Storage             6 - Text
  //<< ;   D45     Missing Stock Storage               6 - Text
  //<< ;   D46     Damaged Stock Storage               6 - Text
  //<< ;   D53     Time difference GMT                 12 - Floating
  //<< ;   D72     Telephone 2                         6 - Text
  //<< ;   D76     Auto Receipt of Transfer Orders     2 - Yes/No
  //<< ;   D94     Manufacturing Return Storage        6 - Text        //SR16573
  //<< /---------------------------------------------------------------------------------*/
  //<< 
  //<< /*----------------------------------------------------------------------------------
  //<< ; History:
  //<< ; 05-Jan-2011   shobby  SR17646: Changes to 'Route' as provided by Pablo.
  //<< ; 16-Aug-2010   PPP     SR16573: Added D94 (Manufacturing Return Storage)
  //<< ; 26-Sep-2008   GRF     SR15932: Add Posting Characteristics properties
  //<< ; 19-May-2008   Luke    SR15754 added MAXLEN of 1000 to Name, Company Name & Street
  //<< ;---------------------------------------------------------------------------------*/
  //<< Property Code As alSYS.dt.dtString(CAPTION = "AL00714") [ Required ];
  public String Code;
  //<< 
  //<< Property Name As alSYS.dt.dtString(CAPTION = "AL00730", MAXLEN = 1000) [ Required ];
  public String Name;
  //<< 
  //<< Property CompanyName As alSYS.dt.dtString(CAPTION = "AL00715", MAXLEN = 1000);
  public String CompanyName;
  //<< 
  //<< Property Street As alSYS.dt.dtString(CAPTION = "AL00739", MAXLEN = 1000);
  public String Street;
  //<< 
  //<< /*  D5  Location Type   6 - Text */
  //<< Property Zipcode As alSYS.dt.dtString(CAPTION = "AL00745");
  public String Zipcode;
  //<< 
  //<< Property City As alSYS.dt.dtString(CAPTION = "AL00713");
  public String City;
  //<< 
  //<< Property Telephone As alSYS.dt.dtString(CAPTION = "AL00742");
  public String Telephone;
  //<< 
  //<< Property Telephone2 As alSYS.dt.dtString(CAPTION = "AL00743");
  public String Telephone2;
  //<< 
  //<< Property Telefax As alSYS.dt.dtString(CAPTION = "AL00741");
  public String Telefax;
  //<< 
  //<< Property Email As alSYS.dt.dtString(CAPTION = "AL00719");
  public String Email;
  //<< 
  //<< /// Routing Description
  //<< Property Route As alSYS.dt.dtString(CAPTION = "AL00737", MAXLEN = 1000, TRUNCATE = 1);
  public String Route;
  //<< 
  //<< Property Picture As alSYS.dt.dtString(CAPTION = "AL00733");
  public String Picture;
  //<< 
  //<< Property ParentLocn As alLOC.dLocation(CAPTION = "AL00732");
  public alLOC.dLocation ParentLocn;
  //<< 
  //<< Property IsProductionLocn As alSYS.dt.dtBoolean(CAPTION = "AL00723");
  public alSYS.dt.dtBoolean IsProductionLocn;
  //<< 
  //<< Property IsTransferLocn As alSYS.dt.dtBoolean(CAPTION = "AL00726");
  public alSYS.dt.dtBoolean IsTransferLocn;
  //<< 
  //<< Property IsSalesLocn As alSYS.dt.dtBoolean(CAPTION = "AL00725");
  public alSYS.dt.dtBoolean IsSalesLocn;
  //<< 
  //<< Property IsInventoryLocn As alSYS.dt.dtBoolean(CAPTION = "AL00721");
  public alSYS.dt.dtBoolean IsInventoryLocn;
  //<< 
  //<< Property IsPurchaseLocn As alSYS.dt.dtBoolean(CAPTION = "AL00724");
  public alSYS.dt.dtBoolean IsPurchaseLocn;
  //<< 
  //<< Property IsAdminLocn As alSYS.dt.dtBoolean(CAPTION = "AL00720");
  public alSYS.dt.dtBoolean IsAdminLocn;
  //<< 
  //<< Property IsPlanningLocn As alSYS.dt.dtBoolean(CAPTION = "AL00722");
  public alSYS.dt.dtBoolean IsPlanningLocn;
  //<< 
  //<< Property TimeZoneGMT As alSYS.dt.dtFloat(CAPTION = "AL00744");
  public alSYS.dt.dtFloat TimeZoneGMT;
  //<< 
  //<< Property AutoReceiptOfTransfers As alSYS.dt.dtBoolean(CAPTION = "AL00712");
  public alSYS.dt.dtBoolean AutoReceiptOfTransfers;
  //<< 
  //<< /// the Default OnHand storage
  //<< Property OnHandStorage As alLOC.dStorage(CAPTION = "AL00731");
  public alLOC.dStorage OnHandStorage;
  //<< 
  //<< /// the Default Receipt storage
  //<< Property ReceiptStorage As alLOC.dStorage(CAPTION = "AL00736");
  public alLOC.dStorage ReceiptStorage;
  //<< 
  //<< /// the Default Despatch storage
  //<< Property DespatchStorage As alLOC.dStorage(CAPTION = "AL00718");
  public alLOC.dStorage DespatchStorage;
  //<< 
  //<< /// the Default Supplier returns storage
  //<< Property SupplierReturnStorage As alLOC.dStorage(CAPTION = "AL00740");
  public alLOC.dStorage SupplierReturnStorage;
  //<< 
  //<< /// the Default customer returns storage
  //<< Property CustomerReturnStorage As alLOC.dStorage(CAPTION = "AL00716");
  public alLOC.dStorage CustomerReturnStorage;
  //<< 
  //<< /// The Default missing stock storage
  //<< Property MissingStockStorage As alLOC.dStorage(CAPTION = "AL00729");
  public alLOC.dStorage MissingStockStorage;
  //<< 
  //<< /// The Default Damage stock storage
  //<< Property DamagedStockStorage As alLOC.dStorage(CAPTION = "AL00717");
  public alLOC.dStorage DamagedStockStorage;
  //<< 
  //<< /// list of Locations Located directly below this level in the
  //<< /// Location tree
  //<< Property Locations As list Of dLocation(CAPTION = "AL00727");
  public mList<dLocation> Locations;
  //<< 
  //<< /// Location Posting Characteristics may be overridden at the storage level
  //<< Property PostingChar1 As alSYS.dt.dtString(CAPTION = "AL00734");
  public String PostingChar1;
  //<< 
  //<< Property PostingChar2 As alSYS.dt.dtString(CAPTION = "AL00735");
  public String PostingChar2;
  //<< 
  //<< /// the Default Manufacturing returns storage
  //<< Property ManuReturnStorage As alLOC.dStorage(CAPTION = "AL00728");
  public alLOC.dStorage ManuReturnStorage;
  //<< 
  //<< //++++++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< /// list of Storages attached to this Location
  //<< Relationship Storages As alLOC.dStorage(CAPTION = "AL00738") [ Cardinality = children, Inverse = Location ];
  public mList<alLOC.dStorage> Storages;

//<< 
//<< //++++++++++++++++++++++++++++++++++++++++++
//<< 
//<< Index Index On Code [ IdKey, Unique ];
//<< 
//<< //++++++++++++++++++++++++++++++++++++++++++
//<< 
//<< /*
//<< Method ReceiptStorageGet(objItem As alINV.dItem = "") As %Status
//<< {
//<< ;-------------------------------------------------------------------------------
//<< ; History:
//<< ; 19-May-2208   Luke    SR15749 Commented out
//<< ; 09-Apr-2008   HQN     Attempt at Property Overide dependent on parameter
//<< ;                           Attempt to load Overloaded property if objItem set
//<< ;-------------------------------------------------------------------------------
//<< set objStorage = ""
//<< if objItem '= "" {
//<< set objOverideProperty = ##class(alLOC.dItem.ReceiptStorage).%OpenId(%this.%Id()_"||"_objItem.%Id()_"||ReceiptStorage")
//<< if objOverideProperty '= $$$NULLOREF {
//<< set objStorage = objOverideProperty.PropertyValue
//<< }
//<< }
//<< if ((objStorage = "") || (objItem = "")) {
//<< set:'$IsObject(i%ReceiptStorage) i%ReceiptStorage = %this.ReceiptStorageGetSwizzled()
//<< set blnIsModified = %this.%IsModified()
//<< set objStorage    = i%ReceiptStorage
//<< do %this.%SetModified(blnIsModified)
//<< }
//<< quit objStorage
//<< }*/
//<< 
//<< /*
//<< Method ReceiptStorageSet(objStorage As alLOC.dStorage, objItem As alINV.dItem = "") As %Status
//<< {
//<< ;-------------------------------------------------------------------------------
//<< ; History:
//<< ; 19-May-2208   Luke    SR15749 Commented out
//<< ; 09-Apr-2008   HQN     Attempt at Property Overide dependent on parameter
//<< ;-------------------------------------------------------------------------------
//<< set sc = $$$OK
//<< if objItem '= "" {
//<< set objOverideProperty = ##class(alLOC.dItem.ReceiptStorage).%OpenId(%this,objItem,"ReceiptStorage")
//<< if objOverideProperty = $$$NULLOREF {
//<< set objOverideProperty = ##class(alLOC.dItem.ReceiptStorage).%New()
//<< set objOverideProperty.SourceInstance    = %this
//<< set objOverideProperty.DependentInstance = objItem
//<< }
//<< set objOverideProperty.PropertyValue = objStorage
//<< set sc = objOverideProperty.%Save()
//<< } else {
//<< set i%ReceiptStorage = objStorage
//<< }
//<< quit sc
//<< }*/
//<< }
}
