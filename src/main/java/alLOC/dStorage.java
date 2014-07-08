//*****************************************************************************
//** TASC - ALPHALINC - CLASS alLOC.dStorage
//** Innovatium Systems - Code Converter - v1.31
//** 2014-07-07 18:13:02
//*****************************************************************************

package alLOC;

import mLibrary.*;

//<< Class alLOC.dStorage Extends %Persistent [ ClassType = persistent ]
public class dStorage extends mPersistent {
  //<< {
  //<< 
  //<< /*----------------------------------------------------------------------------------
  //<< ;   @netManager Element Mappings
  //<< ;-----------------------------------------------------------------------------------
  //<< ; Number    V1 Description                  Input Type
  //<< ;-----------------------------------------------------------------------------------
  //<< ;   P1      Location Number                 6 - Text        Location
  //<< ;   P2      Storage                         6 - Text
  //<< ;   D9      Not Used Load Points            6 - Text
  //<< ;   D5      Field With Multiple Loads       2 - Yes/No
  //<< ;   D6      Field Is In Use                 2 - Yes/No
  //<< ;   D8      Storage Is Blocked              2 - Yes/No
  //<< ;   D9      Check Digits For Stock Control  6 - Text
  //<< ;   D10     Remarks                         3 - Memo
  //<< ;   D11     Pick Sequence                   4 - Integer
  //<< ;   D15     Bonded                          2 - Yes/No
  //<< ;   D19     Phonetic Description            6 - Text
  //<< ;---------------------------------------------------------------------------------*/
  //<< 
  //<< /*----------------------------------------------------------------------------------
  //<< ; History:
  //<< ; 16-Jun-2011   GRF     SR17716: Replace Closed with Status
  //<< ; 19-Apr-2011   GRF     SR17515: Add IsATempSU
  //<< ; ??-???-????   ???     SR17589: Add Closed and Height
  //<< ; 26-Sep-2008   GRF     SR15932: Add property "StorageIsDisused" and query
  //<< ;                           "GetCurrentStorages"; Add Posting Characteristics
  //<< ;---------------------------------------------------------------------------------*/
  //<< Property Code As alSYS.dt.dtString(CAPTION = "AL00669") [ Required ];
  public String Code;
  //<< 
  //<< /// FieldWithMultipleLoads
  //<< Property MultipleBundlesAllowed As alSYS.dt.dtBoolean(CAPTION = "AL00672");
  public alSYS.dt.dtBoolean MultipleBundlesAllowed;
  //<< 
  //<< //Property StorageIsBlocked As alSYS.dt.dtBoolean(CAPTION = "AL00678");     //SR17929
  //<< 
  //<< //SR17929
  //<< 
  //<< Property StorageIsBlocked As alSYS.dt.dtString(CAPTION = "AL00678") [ Calculated, SqlComputeCode = { Set {StorageIsBlocked}=##class(alLOC.dStorage).IsBlocked({ID})}, SqlComputed ];
  public String StorageIsBlocked;
  //<< 
  //<< Property CurrentStorageIsBlocked As alSYS.dt.dtString(CAPTION = "AL01062");
  public String CurrentStorageIsBlocked;
  //<< 
  //<< Property StorageIsDisused As alSYS.dt.dtBoolean(CAPTION = "AL00679");
  public alSYS.dt.dtBoolean StorageIsDisused;
  //<< 
  //<< /// Checkdigits For Stock Control
  //<< Property StockControlVerification As alSYS.dt.dtString(CAPTION = "AL00677");
  public String StockControlVerification;
  //<< 
  //<< Property Remarks As alSYS.dt.dtString(CAPTION = "AL00676", MAXLEN = 32000);
  public String Remarks;
  //<< 
  //<< Property IsBonded As alSYS.dt.dtBoolean(CAPTION = "AL00670");
  public alSYS.dt.dtBoolean IsBonded;
  //<< 
  //<< Property PhoneticDescription As alSYS.dt.dtString(CAPTION = "AL00673");
  public String PhoneticDescription;
  //<< 
  //<< /// OPTIONAL Location Posting Characteristics override the values at the location level
  //<< Property PostingChar1 As alSYS.dt.dtString(CAPTION = "AL00674");
  public String PostingChar1;
  //<< 
  //<< Property PostingChar2 As alSYS.dt.dtString(CAPTION = "AL00675");
  public String PostingChar2;
  //<< 
  //<< Property CodeWithTSU As %String(CAPTION = "AL00750", TRUNCATE = 1) [ Calculated, SqlComputeCode = { Set {CodeWithTSU}=##class(alLOC.dStorage).CodeWithTSU1({Location},{Code})}, SqlComputed ];
  public String CodeWithTSU;
  //<< 
  //<< Property Physical As alLOC.dStorage(CAPTION = "AL00752");
  public alLOC.dStorage Physical;
  //<< 
  //<< //Property Closed As alSYS.dt.dtBoolean(CAPTION = "AL00754");
  //<< 
  //<< Property Height As alSYS.dt.dtFloat(CAPTION = "AL00755");
  public alSYS.dt.dtFloat Height;
  //<< 
  //<< Property IsATempSU As alSYS.dt.dtBoolean(CAPTION = "AL00764");
  public alSYS.dt.dtBoolean IsATempSU;
  //<< 
  //<< Property Status As alSYS.dt.dtString(CAPTION = "AL00217");
  public String Status;
  //<< 
  //<< //++++++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< Relationship Location As alLOC.dLocation(CAPTION = "AL00671") [ Cardinality = parent, Inverse = Storages, Required ];
  public alLOC.dLocation Location;

  //<< 
  //<< //++++++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< Index Index On Code [ IdKey, PrimaryKey, Unique ];
  //<< 
  //<< Index LocationIDX On Location;
  //<< 
  //<< Index PhysicalIDX On Physical;
  //<< 
  //<< //++++++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< Query GetCurrentStorages(pidLocn As alLOC.dLocation) As %SQLQuery(CONTAINID = 1)
  public Object GetCurrentStorages(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(pidLocn);
    //<< {
    //<< SELECT %ID FROM alLOC.dStorage
    //<< WHERE (Location->Code = :pidLocn AND StorageIsDisused = "0") ORDER BY Code
    m$.Cmd.SQL();
    return null;
  //<< }
  }

  //<< 
  //<< //++++++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< Method CodeWithTSUGet() As %String
  public Object CodeWithTSUGet() {
    m$.newVar();
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 30-Sep-2010   shobby      SR17541: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit ##class(alLOC.dStorage).CodeWithTSU1(..Location.Code,..Code)
    return m$.fnc$("alLOC.dStorage.CodeWithTSU1",m$.prop(this.Location,"Code").get(),this.Code);
  //<< }
  }

  //<< 
  //<< ClassMethod CodeWithTSU1(
  //<< pidLocn As alSYS.dt.dtString,
  //<< pstrCode As alSYS.dt.dtString) As %String
  public Object CodeWithTSU1(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.newVarExcept(pidLocn,pstrCode);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 30-Sep-2010   shobby      SR17714.4: Redirected to INLP
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$CodeWithTSU1^INLP(pidLocn,pstrCode)
    return m$.fnc$("INLP.CodeWithTSU1",pidLocn.get(),pstrCode.get());
  //<< }
  }

  //<< 
  //<< ClassMethod IsBlocked(pidStorage) As alSYS.dt.dtBoolean
  public Object IsBlocked(Object ... _p) {
    mVar pidStorage = m$.newVarRef("pidStorage",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    m$.newVarExcept(pidStorage);
    //<< {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 09-Nov-2011   PPP     SR17927: Get the Storage/TSU is blocked
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< set objStorage = ##class(alLOC.dStorage).%OpenId(pidStorage)
    mVar objStorage = m$.var("objStorage");
    objStorage.set(m$.fnc$("alLOC.dStorage.$OpenId",pidStorage.get()));
    //<< 
    //<< set blnBlocked = +objStorage.CurrentStorageIsBlocked
    mVar blnBlocked = m$.var("blnBlocked");
    blnBlocked.set(mOp.Positive(m$.prop(objStorage.get(),"CurrentStorageIsBlocked").get()));
    //<< 
    //<< if blnBlocked = $$$NO {
    if (mOp.Equal(blnBlocked.get(),include.COMSYS.$$$NO(m$))) {
      //<< if objStorage.IsATempSU {
      if (mOp.Logical(m$.prop(objStorage.get(),"IsATempSU").get())) {
        //<< set blnBlocked = objStorage.Physical.CurrentStorageIsBlocked
        blnBlocked.set(m$.prop(objStorage.get(),"Physical.CurrentStorageIsBlocked").get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit blnBlocked
    return blnBlocked.get();
  //<< }
  }

//<< 
//<< }
}
