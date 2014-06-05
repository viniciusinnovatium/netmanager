//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWDataExchange
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:17
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
//<< #include COMConst
import include.COMConst;

//<< WWWDataExchange ;Data Exchange System
public class WWWDataExchange extends mClass {

  public void main() {
    _WWWDataExchange();
  }

  public void _WWWDataExchange() {
  }

  //<< 
  //<< AllOut(pstrType,pstrGlobal)
  public Object AllOut(Object ... _p) {
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Resend all contents of global through data exchange.
    //<< ;
    //<< ; Inputs:
    //<< ;   pstrType    : Type of Action to perform.
    //<< ;                   Save
    //<< ;                   Delete
    //<< ;   pstrGlobal  : Record to send (eg INART).
    //<< ;
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Sep-2009   shobby      SR16906: Out routine expects id's to be in quotes. ^INART(0,"2",1) not ^INART(0,2,1)
    //<< ; 24-Sep-2009   shobby      SR16906: Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< new idGlobal,id,intCount
    mVar idGlobal = m$.var("idGlobal");
    mVar id = m$.var("id");
    mVar intCount = m$.var("intCount");
    m$.newVar(idGlobal,id,intCount);
    //<< 
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< 
    //<< set intCount=0
    intCount.set(0);
    //<< set idGlobal = "^"_pstrGlobal
    idGlobal.set(mOp.Concat("^",pstrGlobal.get()));
    //<< for {
    for (;true;) {
      //<< set idGlobal = $query(@idGlobal)
      idGlobal.set(m$.Fnc.$query(m$.indirectVar(idGlobal.get())));
      //<< quit:idGlobal=""
      if (mOp.Equal(idGlobal.get(),"")) {
        break;
      }
      //<< 
      //<< set id=$piece(idGlobal,",",2)
      id.set(m$.Fnc.$piece(idGlobal.get(),",",2));
      //<< if $extract(id)'="""" {
      if (mOp.NotEqual(m$.Fnc.$extract(id.get()),"\"")) {
        //<< set id=""""_id_""""
        id.set(mOp.Concat(mOp.Concat("\"",id.get()),"\""));
        //<< set $piece(idGlobal,",",2)=id
        m$.pieceVar(idGlobal,",",2).set(id.get());
      }
      //<< }
      //<< ;continue:(+$translate(id,"""")>5)
      //<< write !,idGlobal
      m$.Cmd.Write("\n",idGlobal.get());
      //<< set intCount=intCount+1
      intCount.set(mOp.Add(intCount.get(),1));
      //<< do Out(pstrType,idGlobal,@idGlobal,$$$YES)
      m$.Cmd.Do("Out",pstrType.get(),idGlobal.get(),m$.indirectVar(idGlobal.get()).get(),include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< write !,!,intCount_" records sent."
    m$.Cmd.Write("\n","\n",mOp.Concat(intCount.get()," records sent."));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< 
  //<< ConvertAsciiCode(pidText)
  public Object ConvertAsciiCode(Object ... _p) {
    mVar pidText = m$.newVarRef("pidText",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Finds the ASCII code of the relevant Application Parameter code.  Used in
    //<< ; the mapping of data exchange fields.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Nov-2008   shobby  SR16126: Return the default string if not a code
    //<< ; 07-Nov-2008   shobby  SRBR014985: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intAsciiCode,idxSourceValue,strValue
    mVar intAsciiCode = m$.var("intAsciiCode");
    mVar idxSourceValue = m$.var("idxSourceValue");
    mVar strValue = m$.var("strValue");
    m$.newVar(intAsciiCode,idxSourceValue,strValue);
    //<< 
    //<< set intAsciiCode=""
    intAsciiCode.set("");
    //<< set idxSourceValue=$$Index^COMUtils(pidText)
    idxSourceValue.set(m$.fnc$("COMUtils.Index",pidText.get()));
    //<< if idxSourceValue'="" {
    if (mOp.NotEqual(idxSourceValue.get(),"")) {
      //<< set intAsciiCode=$order(^WWW101s(0,1,idxSourceValue,"COMDELIMITER","EN",""))
      intAsciiCode.set(m$.Fnc.$order(m$.var("^WWW101s",0,1,idxSourceValue.get(),"COMDELIMITER","EN","")));
    }
    //<< }
    //<< if intAsciiCode="" {
    if (mOp.Equal(intAsciiCode.get(),"")) {
      //<< set strValue=pidText
      strValue.set(pidText.get());
    }
    //<< } else {
    else {
      //<< set strValue=$char(intAsciiCode)
      strValue.set(m$.Fnc.$char(intAsciiCode.get()));
    }
    //<< }
    //<< quit strValue
    return strValue.get();
  }

  //<< 
  //<< 
  //<< Out(pstrType,pstrGlobal,pobjRecord="",pblnForce=$$$NO)
  public Object Out(Object ... _p) {
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjRecord = m$.newVarRef("pobjRecord",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnForce = m$.newVarRef("pblnForce",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; put data in queue for exchanging with other systems
    //<< ;
    //<< ; Inputs :
    //<< ; pstrType   = Sync Type: "Save" / "Delete"
    //<< ; pstrGlobal = global string: ^TEST(0,1,1)
    //<< ; pobjRecord = record string: DATA~DATA~DATA
    //<< ;
    //<< ; History :
    //<< ; 21-Oct-2009   SCR     SR16929:  Added Data to Message Send Class
    //<< ; 24-Sep-2009   shobby  SR16906:  New flag pblnForce.  Puts records on the queue even if they have not changed.
    //<< ;                                   As when called from AllOut
    //<< ; 09-Sep-2009   FIS     SR16881:  new YSKEY as it caused trouble in WWWSPEI (save within save)
    //<< ; 20-Apr-2009   shobby  SR16438:  Call out to notify external systems that data
    //<< ;                                   is on the queue.
    //<< ; 09-Apr-2009   shobby  SR16479:  Reviewed 'newing' of variables.
    //<< ; 28-Nov-2008   shobby  BR014985: Subroutined some code and added support for
    //<< ;                                   calculated fields.
    //<< ; 05-Nov-2008   shobby  BR014985: Force the value of a checkbox to be 0 if unchecked.
    //<< ; 04-Nov-2008   shobby  BR014985: Moved the $$Interested check and rearranged
    //<< ;                                   some continue commands.
    //<< ; 31-Oct-2008   shobby  BR014985: Only if enabled.
    //<< ; 29-Oct-2008   shobby  BR014985: Always do KILL
    //<< ; 22-Oct-2008   shobby  BR014985: Default value for pobjRecord.  Used during
    //<< ;                           'kill' operation.
    //<< ; 21-Oct-2008   shobby  BR014985: Exclude records based on specified keys
    //<< ; 29-Apr-2008   CHINMAY Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idMsgProp,intPropNum,intRule,objExMsgData,objMessage,objMsgProp,objRuleset
    mVar idMsgProp = m$.var("idMsgProp");
    mVar intPropNum = m$.var("intPropNum");
    mVar intRule = m$.var("intRule");
    mVar objExMsgData = m$.var("objExMsgData");
    mVar objMessage = m$.var("objMessage");
    mVar objMsgProp = m$.var("objMsgProp");
    mVar objRuleset = m$.var("objRuleset");
    m$.newVar(idMsgProp,intPropNum,intRule,objExMsgData,objMessage,objMsgProp,objRuleset);
    //<< new strDelimiter,strDisplayField,strGlobalName,strGlobalSortName,strMsgNo,strMultiVal
    mVar strDelimiter = m$.var("strDelimiter");
    mVar strDisplayField = m$.var("strDisplayField");
    mVar strGlobalName = m$.var("strGlobalName");
    mVar strGlobalSortName = m$.var("strGlobalSortName");
    mVar strMsgNo = m$.var("strMsgNo");
    mVar strMultiVal = m$.var("strMultiVal");
    m$.newVar(strDelimiter,strDisplayField,strGlobalName,strGlobalSortName,strMsgNo,strMultiVal);
    //<< new strResolveClass,strResolvePKey,strSourcePropName,strStatus,strTargetProperty,strValue
    mVar strResolveClass = m$.var("strResolveClass");
    mVar strResolvePKey = m$.var("strResolvePKey");
    mVar strSourcePropName = m$.var("strSourcePropName");
    mVar strStatus = m$.var("strStatus");
    mVar strTargetProperty = m$.var("strTargetProperty");
    mVar strValue = m$.var("strValue");
    m$.newVar(strResolveClass,strResolvePKey,strSourcePropName,strStatus,strTargetProperty,strValue);
    //<< new strData
    mVar strData = m$.var("strData");
    m$.newVar(strData);
    //<< 
    //<< new YSKEY  //causes trouble in @net Manager because of save within save process
    mVar YSKEY = m$.var("YSKEY");
    m$.newVar(YSKEY);
    //<< 
    //<< quit:pstrGlobal="" 0
    if (mOp.Equal(pstrGlobal.get(),"")) {
      return 0;
    }
    //<< 
    //<< set strGlobalName = $piece($piece(pstrGlobal,"^",2),"(",1)
    strGlobalName.set(m$.Fnc.$piece(m$.Fnc.$piece(pstrGlobal.get(),"^",2),"(",1));
    //<< set strGlobalSortName = $$$Index(strGlobalName)
    strGlobalSortName.set(include.MEDConst.$$$Index(m$,strGlobalName));
    //<< 
    //<< if $data(^WWWDataExchanges(0,1,strGlobalSortName)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDataExchanges",0,1,strGlobalSortName.get())))) {
      //<< set intRule = ""
      intRule.set("");
      //<< for {
      for (;true;) {
        //<< set intRule = $order(^WWWDataExchanges(0,1,strGlobalSortName,intRule))
        intRule.set(m$.Fnc.$order(m$.var("^WWWDataExchanges",0,1,strGlobalSortName.get(),intRule.get())));
        //<< quit:intRule=""
        if (mOp.Equal(intRule.get(),"")) {
          break;
        }
        //<< 
        //<< set objRuleset = $get(^WWWDataExchange(0,intRule,1))
        objRuleset.set(m$.Fnc.$get(m$.var("^WWWDataExchange",0,intRule.get(),1)));
        //<< 
        //<< continue:($$$WWWDataExchangeActsAs(objRuleset) = 1) //not if remote system is master
        if ((mOp.Equal(include.WWWConst.$$$WWWDataExchangeActsAs(m$,objRuleset),1))) {
          continue;
        }
        //<< continue:'$$$WWWDataExchangeEnabled(objRuleset)     ;Only if enabled.
        if (mOp.Not(include.WWWConst.$$$WWWDataExchangeEnabled(m$,objRuleset))) {
          continue;
        }
        //<< continue:($$Access(intRule,objRuleset) = 1)
        if ((mOp.Equal(m$.fnc$("Access",intRule.get(),objRuleset.get()),1))) {
          continue;
        }
        //<< continue:($$$WWWDataExchangeRemoteSystem(objRuleset) = "") //recipient required
        if ((mOp.Equal(include.WWWConst.$$$WWWDataExchangeRemoteSystem(m$,objRuleset),""))) {
          continue;
        }
        //<< continue:'(pblnForce||(pstrType = "Delete")||$$CheckData($$$WWWDataExchangeMessageType(objRuleset),pstrGlobal,pobjRecord))
        if (mOp.Not((mOp.Logical(pblnForce.get()) || (mOp.Equal(pstrType.get(),"Delete")) || mOp.Logical(m$.fnc$("CheckData",include.WWWConst.$$$WWWDataExchangeMessageType(m$,objRuleset),pstrGlobal.get(),pobjRecord.get()))))) {
          continue;
        }
        //<< 
        //<< set objExMsgData = $get(^WWWDataExMessage(0,$$$WWWDataExchangeMessageType(objRuleset),1))
        objExMsgData.set(m$.Fnc.$get(m$.var("^WWWDataExMessage",0,include.WWWConst.$$$WWWDataExchangeMessageType(m$,objRuleset),1)));
        //<< continue:'$$Interested(pstrGlobal,$$$WWWDataExMessageSourceKeys(objExMsgData))  ;BR014985
        if (mOp.Not(m$.fnc$("Interested",pstrGlobal.get(),include.WWWConst.$$$WWWDataExMessageSourceKeys(m$,objExMsgData)))) {
          continue;
        }
        //<< continue:$$Excluded($$$WWWDataExchangeMessageType(objRuleset),pobjRecord,pstrGlobal) ;SR16437
        if (mOp.Logical(m$.fnc$("Excluded",include.WWWConst.$$$WWWDataExchangeMessageType(m$,objRuleset),pobjRecord.get(),pstrGlobal.get()))) {
          continue;
        }
        //<< 
        //<< //build message if there are some changes in the record
        //<< set strMsgNo = $$^WWWNEXT("WWWDataExMsgNo")
        strMsgNo.set(m$.fnc$("WWWNEXT.main","WWWDataExMsgNo"));
        //<< set objMessage = ""
        objMessage.set("");
        //<< set $$$WWWDataExMessageSendType(objMessage) = "Update"
        include.WWWConst.$$$WWWDataExMessageSendTypeSet(m$,objMessage,"Update");
        //<< if (pstrType = "Delete") {
        if ((mOp.Equal(pstrType.get(),"Delete"))) {
          //<< set $$$WWWDataExMessageSendType(objMessage) = "Delete"
          include.WWWConst.$$$WWWDataExMessageSendTypeSet(m$,objMessage,"Delete");
        }
        //<< 
        //<< } elseif ('$data(@pstrGlobal)) {
        else if ((mOp.Not(m$.Fnc.$data(m$.indirectVar(pstrGlobal.get()))))) {
          //<< set $$$WWWDataExMessageSendType(objMessage) = "New"
          include.WWWConst.$$$WWWDataExMessageSendTypeSet(m$,objMessage,"New");
        }
        //<< }
        //<< set $$$WWWDataExMessageSendTimestampCreated(objMessage)=$horolog
        include.WWWConst.$$$WWWDataExMessageSendTimestampCreatedSet(m$,objMessage,m$.Fnc.$horolog());
        //<< set $$$WWWDataExMessageSendMessageType(objMessage)= $$$WWWDataExchangeMessageType(objRuleset)
        include.WWWConst.$$$WWWDataExMessageSendMessageTypeSet(m$,objMessage,include.WWWConst.$$$WWWDataExchangeMessageType(m$,objRuleset));
        //<< set $$$WWWDataExMessageSendDataClass(objMessage)=strGlobalSortName
        include.WWWConst.$$$WWWDataExMessageSendDataClassSet(m$,objMessage,strGlobalSortName.get());
        //<< set strData   = ""
        strData.set("");
        //<< set strStatus = $$$OK
        strStatus.set(include.COMSYS.$$$OK(m$));
        //<< 
        //<< if $$$ISOK(strStatus) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
          //<< // run through the Exchange message properties
          //<< set idMsgProp = ""
          idMsgProp.set("");
          //<< for {
          for (;true;) {
            //<< set idMsgProp = $order(^WWWDataExMessageProp(0,$$$WWWDataExchangeMessageType(objRuleset),idMsgProp))
            idMsgProp.set(m$.Fnc.$order(m$.var("^WWWDataExMessageProp",0,include.WWWConst.$$$WWWDataExchangeMessageType(m$,objRuleset),idMsgProp.get())));
            //<< quit:idMsgProp=""
            if (mOp.Equal(idMsgProp.get(),"")) {
              break;
            }
            //<< 
            //<< set objMsgProp = $get(^WWWDataExMessageProp(0,$$$WWWDataExchangeMessageType(objRuleset),idMsgProp,1))
            objMsgProp.set(m$.Fnc.$get(m$.var("^WWWDataExMessageProp",0,include.WWWConst.$$$WWWDataExchangeMessageType(m$,objRuleset),idMsgProp.get(),1)));
            //<< set strSourcePropName = $$$WWWDataExMessagePropSourcePropertyName(objMsgProp)
            strSourcePropName.set(include.WWWConst.$$$WWWDataExMessagePropSourcePropertyName(m$,objMsgProp));
            //<< set strTargetProperty = $$$WWWDataExMessagePropTargetPropertyName(objMsgProp)
            strTargetProperty.set(include.WWWConst.$$$WWWDataExMessagePropTargetPropertyName(m$,objMsgProp));
            //<< set strResolveClass   = $$$WWWDataExMessagePropResolveRelationClass(objMsgProp)
            strResolveClass.set(include.WWWConst.$$$WWWDataExMessagePropResolveRelationClass(m$,objMsgProp));
            //<< set strResolvePKey    = $$$WWWDataExMessagePropResolveRelationalPrimaryK(objMsgProp)
            strResolvePKey.set(include.WWWConst.$$$WWWDataExMessagePropResolveRelationalPrimaryK(m$,objMsgProp));
            //<< set strDisplayField   = $$$WWWDataExMessagePropResolveRelationalDisplayF(objMsgProp)
            strDisplayField.set(include.WWWConst.$$$WWWDataExMessagePropResolveRelationalDisplayF(m$,objMsgProp));
            //<< set strDelimiter      = $char($$$WWWDataExMessageDelimeterASCII(objExMsgData))
            strDelimiter.set(m$.Fnc.$char(include.WWWConst.$$$WWWDataExMessageDelimeterASCII(m$,objExMsgData)));
            //<< // pick up each property, get data out of pobjRecord (use Source Property Name)
            //<< 
            //<< // run through the primary fields and get the property number
            //<< set intPropNum = ""
            intPropNum.set("");
            //<< if (strSourcePropName'="") {
            if ((mOp.NotEqual(strSourcePropName.get(),""))) {
              //<< set intPropNum = $order(^WWW002s(0,3,strGlobalSortName,$$$Index(strSourcePropName),strGlobalName,intPropNum))
              intPropNum.set(m$.Fnc.$order(m$.var("^WWW002s",0,3,strGlobalSortName.get(),include.MEDConst.$$$Index(m$,strSourcePropName),strGlobalName.get(),intPropNum.get())));
              //<< if (intPropNum'="") {
              if ((mOp.NotEqual(intPropNum.get(),""))) {
                //<< set strValue = $piece($piece(pstrGlobal,",",intPropNum+1),"""",2) //get the value from pstrGlobal.Incremented by one since the first value is company id.
                strValue.set(m$.Fnc.$piece(m$.Fnc.$piece(pstrGlobal.get(),",",mOp.Add(intPropNum.get(),1)),"\"",2));
                //<< ;   set strValue = $translate($piece(pstrGlobal,",",intPropNum+1),"""") //get the value from pstrGlobal.Incremented by one since the first value is company id.
                //<< // Do resolution of relation files
                //<< if (strResolveClass'="") {
                if ((mOp.NotEqual(strResolveClass.get(),""))) {
                  //<< set strValue = $$ResolveRltnClass(strResolveClass,strResolvePKey,strDisplayField,strValue,strDelimiter)
                  strValue.set(m$.fnc$("ResolveRltnClass",strResolveClass.get(),strResolvePKey.get(),strDisplayField.get(),strValue.get(),strDelimiter.get()));
                }
                //<< }
                //<< set strStatus=$$SaveMessageData(strMsgNo,idMsgProp,objMsgProp,objExMsgData,strTargetProperty,strSourcePropName,strValue)
                strStatus.set(m$.fnc$("SaveMessageData",strMsgNo.get(),idMsgProp.get(),objMsgProp.get(),objExMsgData.get(),strTargetProperty.get(),strSourcePropName.get(),strValue.get()));
                //<< set strData=strData_","_strValue ; SR16929:
                strData.set(mOp.Concat(mOp.Concat(strData.get(),","),strValue.get()));
              }
            }
            //<< }
            //<< }
            //<< 
            //<< // run through the data fields and get the property number
            //<< set intPropNum = ""
            intPropNum.set("");
            //<< if (strSourcePropName'="") {
            if ((mOp.NotEqual(strSourcePropName.get(),""))) {
              //<< set intPropNum = $order(^WWW003s(0,3,strGlobalSortName,$$$Index(strSourcePropName),strGlobalName,intPropNum)) ;BR014985
              intPropNum.set(m$.Fnc.$order(m$.var("^WWW003s",0,3,strGlobalSortName.get(),include.MEDConst.$$$Index(m$,strSourcePropName),strGlobalName.get(),intPropNum.get())));
              //<< if (intPropNum'="") {
              if ((mOp.NotEqual(intPropNum.get(),""))) {
                //<< set strValue = $piece(pobjRecord,Y,intPropNum)
                strValue.set(m$.Fnc.$piece(pobjRecord.get(),m$.var("Y").get(),intPropNum.get()));
                //<< if $$GetDataType(strGlobalName,intPropNum)= 2 {
                if (mOp.Equal(m$.fnc$("GetDataType",strGlobalName.get(),intPropNum.get()),2)) {
                  //<< ; If this is a yes/no field, force an unchecked state to equal 0 BR014985
                  //<< set strValue=+strValue
                  strValue.set(mOp.Positive(strValue.get()));
                }
                //<< }
                //<< // Do resolution of relation files
                //<< if (strResolveClass'="") {
                if ((mOp.NotEqual(strResolveClass.get(),""))) {
                  //<< set strMultiVal = $$ResolveRltnClass(strResolveClass,strResolvePKey,strDisplayField,strValue,strDelimiter)
                  strMultiVal.set(m$.fnc$("ResolveRltnClass",strResolveClass.get(),strResolvePKey.get(),strDisplayField.get(),strValue.get(),strDelimiter.get()));
                  //<< // if the value is for a multi select the embed inside double quotes
                  //<< if (($length(strMultiVal,";")>1)||($length(strMultiVal,"|")>1)) {
                  if (mOp.Logical(((mOp.Greater(m$.Fnc.$length(strMultiVal.get(),";"),1)) || (mOp.Greater(m$.Fnc.$length(strMultiVal.get(),"|"),1))))) {
                    //<< set strValue = """"_strMultiVal_""""                // Embed the multi select data String inside double quotes
                    strValue.set(mOp.Concat(mOp.Concat("\"",strMultiVal.get()),"\""));
                  }
                  //<< } else {
                  else {
                    //<< set strValue = strMultiVal
                    strValue.set(strMultiVal.get());
                  }
                }
                //<< }
                //<< }
                //<< set strStatus=$$SaveMessageData(strMsgNo,idMsgProp,objMsgProp,objExMsgData,strTargetProperty,strSourcePropName,strValue)
                strStatus.set(m$.fnc$("SaveMessageData",strMsgNo.get(),idMsgProp.get(),objMsgProp.get(),objExMsgData.get(),strTargetProperty.get(),strSourcePropName.get(),strValue.get()));
                //<< set strData=strData_","_strValue ; SR16929:
                strData.set(mOp.Concat(mOp.Concat(strData.get(),","),strValue.get()));
              }
            }
            //<< }
            //<< }
            //<< 
            //<< // calculated fields
            //<< set intPropNum = ""
            intPropNum.set("");
            //<< if (strSourcePropName'="") {
            if ((mOp.NotEqual(strSourcePropName.get(),""))) {
              //<< set intPropNum = $order(^WWW003Calcs(0,1,$$$Index(strSourcePropName),strGlobalName,intPropNum))
              intPropNum.set(m$.Fnc.$order(m$.var("^WWW003Calcs",0,1,include.MEDConst.$$$Index(m$,strSourcePropName),strGlobalName.get(),intPropNum.get())));
              //<< if (intPropNum'="") {
              if ((mOp.NotEqual(intPropNum.get(),""))) {
                //<< set strValue =$$GetCalculatedValue^COMViewFilter(strGlobalName,"x"_intPropNum,$qsubscript(pstrGlobal,2),pobjRecord," ")
                strValue.set(m$.fnc$("COMViewFilter.GetCalculatedValue",strGlobalName.get(),mOp.Concat("x",intPropNum.get()),m$.Fnc.$qsubscript(pstrGlobal,2),pobjRecord.get()," "));
                //<< set strStatus=$$SaveMessageData(strMsgNo,idMsgProp,objMsgProp,objExMsgData,strTargetProperty,strSourcePropName,strValue)
                strStatus.set(m$.fnc$("SaveMessageData",strMsgNo.get(),idMsgProp.get(),objMsgProp.get(),objExMsgData.get(),strTargetProperty.get(),strSourcePropName.get(),strValue.get()));
                //<< set strData=strData_","_strValue ; SR16929:
                strData.set(mOp.Concat(mOp.Concat(strData.get(),","),strValue.get()));
              }
            }
          }
          //<< }
          //<< }
          //<< 
          //<< }
          //<< if $$$ISOK(strStatus) {                                                 ; SR16929
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
            //<< set $$$WWWDataExMessageSendData(objMessage)=$extract(strData,2,999) ; Save the Message data
            include.WWWConst.$$$WWWDataExMessageSendDataSet(m$,objMessage,m$.Fnc.$extract(strData.get(),2,999));
            //<< set $$$WWWDataExMessageSendRule(objMessage)=intRule                 ; Save the Rule ( Used by the Slave Push )
            include.WWWConst.$$$WWWDataExMessageSendRuleSet(m$,objMessage,intRule.get());
            //<< set strStatus = $$$Save("WWWDataExMessageSend",$$$WWWDataExchangeRemoteSystem(objRuleset)_","_strMsgNo,objMessage)
            strStatus.set(include.COMSYS.$$$Save(m$,"WWWDataExMessageSend",mOp.Concat(mOp.Concat(include.WWWConst.$$$WWWDataExchangeRemoteSystem(m$,objRuleset),","),strMsgNo.get()),objMessage));
          }
          //<< }
          //<< if $$$ISOK(strStatus) job NotifyExternalSystems^WWWDataExchangePoke()  ;16438
          if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
            m$.Cmd.Job("WWWDataExchangePoke.NotifyExternalSystems");
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit 1
    return 1;
  }

  //<< 
  //<< 
  //<< SaveMessageData(pstrMsgNo,pidMsgProp,pobjMsgProp,pobjExMsgData,pstrTargetProperty,pstrSourcePropName,pstrValue)
  public Object SaveMessageData(Object ... _p) {
    mVar pstrMsgNo = m$.newVarRef("pstrMsgNo",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidMsgProp = m$.newVarRef("pidMsgProp",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjMsgProp = m$.newVarRef("pobjMsgProp",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pobjExMsgData = m$.newVarRef("pobjExMsgData",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pstrTargetProperty = m$.newVarRef("pstrTargetProperty",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pstrSourcePropName = m$.newVarRef("pstrSourcePropName",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Nov-2008   shobby  SRBR014985: Common code brought out of 'Out' method.
    //<< ;-------------------------------------------------------------------------------
    //<< new objMsgData
    mVar objMsgData = m$.var("objMsgData");
    m$.newVar(objMsgData);
    //<< 
    //<< set pstrValue=$$UndoMappingClass(pobjMsgProp,pstrValue)
    pstrValue.set(m$.fnc$("UndoMappingClass",pobjMsgProp.get(),pstrValue.get()));
    //<< 
    //<< // set data into data file:
    //<< set objMsgData = ""
    objMsgData.set("");
    //<< set $$$WWWDataExMessageDataValue1(objMsgData)=pstrValue
    include.WWWConst.$$$WWWDataExMessageDataValue1Set(m$,objMsgData,pstrValue.get());
    //<< if (pstrTargetProperty="") {
    if ((mOp.Equal(pstrTargetProperty.get(),""))) {
      //<< set pstrTargetProperty = pstrSourcePropName
      pstrTargetProperty.set(pstrSourcePropName.get());
    }
    //<< }
    //<< if +$$$WWWDataExMessageFileType(pobjExMsgData)=0 set pstrTargetProperty = pidMsgProp  //save seq. no. as property if delimetered string
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWWDataExMessageFileType(m$,pobjExMsgData)),0)) {
      pstrTargetProperty.set(pidMsgProp.get());
    }
    //<< quit $$$Save("WWWDataExMessageData",pstrMsgNo_","_pstrTargetProperty,objMsgData)
    return include.COMSYS.$$$Save(m$,"WWWDataExMessageData",mOp.Concat(mOp.Concat(pstrMsgNo.get(),","),pstrTargetProperty.get()),objMsgData);
  }

  //<< 
  //<< 
  //<< GetDataType(pidGlobal,pintField)
  public Object GetDataType(Object ... _p) {
    mVar pidGlobal = m$.newVarRef("pidGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintField = m$.newVarRef("pintField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines what the data type is.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2008   shobby  BR01985: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW003
    mVar objWWW003 = m$.var("objWWW003");
    m$.newVar(objWWW003);
    //<< 
    //<< set objWWW003 = $get(^WWW003(0,pidGlobal,pintField,1))
    objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,pidGlobal.get(),pintField.get(),1)));
    //<< quit $$$WWW003InputType(objWWW003)
    return include.WWWConst.$$$WWW003InputType(m$,objWWW003);
  }

  //<< 
  //<< 
  //<< Interested(pstrGlobal,pstrSourceKeys)
  public Object Interested(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrSourceKeys = m$.newVarRef("pstrSourceKeys",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; Check to see if we are interested in excluding records based on subscripts
    //<< ; defined in the SourceKeys property
    //<< ;
    //<< ; Inputs :
    //<< ; pstrGloba = Record being tested
    //<< ; pstrSourceKeys = Only the keys specified should be sent
    //<< ;
    //<< ; History :
    //<< ; 21-Oct-2008   shobby  BR014985: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnInterested,loop,strSubscript
    mVar blnInterested = m$.var("blnInterested");
    mVar loop = m$.var("loop");
    mVar strSubscript = m$.var("strSubscript");
    m$.newVar(blnInterested,loop,strSubscript);
    //<< 
    //<< set blnInterested=$$$YES
    blnInterested.set(include.COMSYS.$$$YES(m$));
    //<< if pstrSourceKeys'="" {
    if (mOp.NotEqual(pstrSourceKeys.get(),"")) {
      //<< for loop=1:1:$length(pstrSourceKeys) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(pstrSourceKeys.get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< set strSubscript = $piece(pstrSourceKeys,",",loop)
        strSubscript.set(m$.Fnc.$piece(pstrSourceKeys.get(),",",loop.get()));
        //<< continue:strSubscript=""
        if (mOp.Equal(strSubscript.get(),"")) {
          continue;
        }
        //<< 
        //<< if '($extract(strSubscript)="""") {
        if (mOp.Not((mOp.Equal(m$.Fnc.$extract(strSubscript.get()),"\"")))) {
          //<< set strSubscript=@strSubscript
          strSubscript.set(m$.indirectVar(strSubscript.get()).get());
        }
        //<< 
        //<< } else {
        else {
          //<< set strSubscript=$translate(strSubscript,"""")
          strSubscript.set(m$.Fnc.$translate(strSubscript.get(),"\""));
        }
        //<< }
        //<< if strSubscript'=$qsubscript(pstrGlobal,loop+1) {
        if (mOp.NotEqual(strSubscript.get(),m$.Fnc.$qsubscript(pstrGlobal,mOp.Add(loop.get(),1)))) {
          //<< set blnInterested=$$$NO
          blnInterested.set(include.COMSYS.$$$NO(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnInterested
    return blnInterested.get();
  }

  //<< 
  //<< Excluded(pidMessageType,pobjRecord="",pstrGlobal="")
  public Object Excluded(Object ... _p) {
    mVar pidMessageType = m$.newVarRef("pidMessageType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjRecord = m$.newVarRef("pobjRecord",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; See if any rules will exclude this record from DataExchange.
    //<< ;
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Apr-2009   shobby  SR16479: Reviewed 'newing' of variables.
    //<< ; 27-Mar-2009   shobby  SR16347: Additional test of the existing 'on disk' value.
    //<< ;                           This caters for the following situation.  An Item
    //<< ;                           becomes excluded from DataExchange if the 'Hold
    //<< ;                           Reason' is set to an inactive state.  However we
    //<< ;                           still want to send a notification that the 'Hold
    //<< ;                           Reason' has changed, to the remote system.
    //<< ;                           Thereafter it should be excluded, but not the 'first
    //<< ;                           save' that makes it excluded.
    //<< ; 25-Mar-2009   shobby  SR16437: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idNumber,objWWWDataExMessageRulesD,blnInclude,intField,strTest,blnExcluded
    mVar idNumber = m$.var("idNumber");
    mVar objWWWDataExMessageRulesD = m$.var("objWWWDataExMessageRulesD");
    mVar blnInclude = m$.var("blnInclude");
    mVar intField = m$.var("intField");
    mVar strTest = m$.var("strTest");
    mVar blnExcluded = m$.var("blnExcluded");
    m$.newVar(idNumber,objWWWDataExMessageRulesD,blnInclude,intField,strTest,blnExcluded);
    //<< 
    //<< set blnExcluded=$$$NO
    blnExcluded.set(include.COMSYS.$$$NO(m$));
    //<< set idNumber = ""
    idNumber.set("");
    //<< for {
    for (;true;) {
      //<< set idNumber = $order(^WWWDataExMessageRulesD(0,pidMessageType,idNumber))
      idNumber.set(m$.Fnc.$order(m$.var("^WWWDataExMessageRulesD",0,pidMessageType.get(),idNumber.get())));
      //<< quit:idNumber=""
      if (mOp.Equal(idNumber.get(),"")) {
        break;
      }
      //<< quit:blnExcluded
      if (mOp.Logical(blnExcluded.get())) {
        break;
      }
      //<< 
      //<< set objWWWDataExMessageRulesD = $get(^WWWDataExMessageRulesD(0,pidMessageType,idNumber,1))
      objWWWDataExMessageRulesD.set(m$.Fnc.$get(m$.var("^WWWDataExMessageRulesD",0,pidMessageType.get(),idNumber.get(),1)));
      //<< if objWWWDataExMessageRulesD'="" {
      if (mOp.NotEqual(objWWWDataExMessageRulesD.get(),"")) {
        //<< set intField = $$$WWWDataExMessageRulesDSourcePropertyName(objWWWDataExMessageRulesD)
        intField.set(include.WWWConst.$$$WWWDataExMessageRulesDSourcePropertyName(m$,objWWWDataExMessageRulesD));
        //<< set strTest  = $$$WWWDataExMessageRulesDValue1(objWWWDataExMessageRulesD)
        strTest.set(include.WWWConst.$$$WWWDataExMessageRulesDValue1(m$,objWWWDataExMessageRulesD));
        //<< set blnExcluded = $$TestRule($$$WWWDataExMessageRulesDTest(objWWWDataExMessageRulesD),$piece(pobjRecord,Y,intField),strTest)
        blnExcluded.set(m$.fnc$("TestRule",include.WWWConst.$$$WWWDataExMessageRulesDTest(m$,objWWWDataExMessageRulesD),m$.Fnc.$piece(pobjRecord.get(),m$.var("Y").get(),intField.get()),strTest.get()));
        //<< if blnExcluded && $data(@pstrGlobal) {
        if (mOp.Logical(blnExcluded.get()) && mOp.Logical(m$.Fnc.$data(m$.indirectVar(pstrGlobal.get())))) {
          //<< set blnExcluded = $$TestRule($$$WWWDataExMessageRulesDTest(objWWWDataExMessageRulesD),$piece(@pstrGlobal,Y,intField),strTest)
          blnExcluded.set(m$.fnc$("TestRule",include.WWWConst.$$$WWWDataExMessageRulesDTest(m$,objWWWDataExMessageRulesD),m$.Fnc.$piece(m$.indirectVar(pstrGlobal.get()).get(),m$.var("Y").get(),intField.get()),strTest.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnExcluded
    return blnExcluded.get();
  }

  //<< 
  //<< 
  //<< TestRule(pstrRule,pstrValue,pstrTest)
  public Object TestRule(Object ... _p) {
    mVar pstrRule = m$.newVarRef("pstrRule",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrTest = m$.newVarRef("pstrTest",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; See if the rule applies in this case
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Mar-2009   shobby      SR16437: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnExcluded
    mVar blnExcluded = m$.var("blnExcluded");
    m$.newVar(blnExcluded);
    //<< 
    //<< set blnExcluded = $$$NO
    blnExcluded.set(include.COMSYS.$$$NO(m$));
    //<< if pstrRule=$$$EnumCOMVIEWCOMPARATORGreaterThan {
    if (mOp.Equal(pstrRule.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORGreaterThan(m$))) {
      //<< set blnExcluded = (pstrValue>pstrTest)
      blnExcluded.set((mOp.Greater(pstrValue.get(),pstrTest.get())));
    }
    //<< 
    //<< } elseif pstrRule=$$$EnumCOMVIEWCOMPARATORLessThan {
    else if (mOp.Equal(pstrRule.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORLessThan(m$))) {
      //<< set blnExcluded = (pstrValue<pstrTest)
      blnExcluded.set((mOp.Less(pstrValue.get(),pstrTest.get())));
    }
    //<< 
    //<< } elseif pstrRule=$$$EnumCOMVIEWCOMPARATOREquals {
    else if (mOp.Equal(pstrRule.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATOREquals(m$))) {
      //<< set blnExcluded = (pstrValue=pstrTest)
      blnExcluded.set((mOp.Equal(pstrValue.get(),pstrTest.get())));
    }
    //<< 
    //<< } elseif pstrRule=$$$EnumCOMVIEWCOMPARATORNotEquals {
    else if (mOp.Equal(pstrRule.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORNotEquals(m$))) {
      //<< set blnExcluded = (pstrValue'=pstrTest)
      blnExcluded.set((mOp.NotEqual(pstrValue.get(),pstrTest.get())));
    }
    //<< 
    //<< } elseif pstrRule=$$$EnumCOMVIEWCOMPARATORStartsWith {
    else if (mOp.Equal(pstrRule.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORStartsWith(m$))) {
      //<< set blnExcluded = ($extract(pstrValue,1,$length(pstrTest))=pstrTest)
      blnExcluded.set((mOp.Equal(m$.Fnc.$extract(pstrValue.get(),1,m$.Fnc.$length(pstrTest.get())),pstrTest.get())));
    }
    //<< 
    //<< } elseif pstrRule=$$$EnumCOMVIEWCOMPARATORContains {
    else if (mOp.Equal(pstrRule.get(),include.COMConst.$$$EnumCOMVIEWCOMPARATORContains(m$))) {
      //<< set blnExcluded = (pstrValue[pstrTest)
      blnExcluded.set((mOp.Contains(pstrValue.get(),pstrTest.get())));
    }
    //<< }
    //<< 
    //<< quit blnExcluded
    return blnExcluded.get();
  }

  //<< 
  //<< 
  //<< ResolveRltnClass(pstrResolveClass,pstrResolvePKey,pstrDisplayField,pstrValue,pstrDelimiter)
  public Object ResolveRltnClass(Object ... _p) {
    mVar pstrResolveClass = m$.newVarRef("pstrResolveClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrResolvePKey = m$.newVarRef("pstrResolvePKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrDisplayField = m$.newVarRef("pstrDisplayField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pstrDelimiter = m$.newVarRef("pstrDelimiter",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; check the incoming new data record with the existing data record.
    //<< ;
    //<< ; Inputs :
    //<< ; pstrResolveClass = Relation Class Name
    //<< ; pstrResolvePKey = Relation Class Primary Key
    //<< ; pstrDisplayField = Relation Class Display Field
    //<< ; pstrValue = Data Value
    //<< ; pstrDelimiter = Delimiter
    //<< ;
    //<< ; History :
    //<< ; 09-Apr-2009   shobby  SR16479: Reviewed 'newing' of variables.
    //<< ; 07-Jun-2008   CHINMAY Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strResolveClass,strVal,strTempValue,loop,strResolveCls,objResolveClass
    mVar strResolveClass = m$.var("strResolveClass");
    mVar strVal = m$.var("strVal");
    mVar strTempValue = m$.var("strTempValue");
    mVar loop = m$.var("loop");
    mVar strResolveCls = m$.var("strResolveCls");
    mVar objResolveClass = m$.var("objResolveClass");
    m$.newVar(strResolveClass,strVal,strTempValue,loop,strResolveCls,objResolveClass);
    //<< 
    //<< set strVal=""
    strVal.set("");
    //<< set strResolveClass="^"_pstrResolveClass
    strResolveClass.set(mOp.Concat("^",pstrResolveClass.get()));
    //<< for loop=1:1:$length(pstrValue,";") {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(pstrValue.get(),";")));loop.set(mOp.Add(loop.get(),1))) {
      //<< set strTempValue =""
      strTempValue.set("");
      //<< // if the relation primary key property in WWWDataExMessageProp is present
      //<< if (pstrResolvePKey'="") && ($piece(pstrValue,";",loop)'="") {
      if ((mOp.NotEqual(pstrResolvePKey.get(),"")) && (mOp.NotEqual(m$.Fnc.$piece(pstrValue.get(),";",loop.get()),""))) {
        //<< set strResolveCls=strResolveClass_"(0,"_pstrResolvePKey_","""_$piece(pstrValue,";",loop)_""",1)"
        strResolveCls.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strResolveClass.get(),"(0,"),pstrResolvePKey.get()),",\""),m$.Fnc.$piece(pstrValue.get(),";",loop.get())),"\",1)"));
        //<< set objResolveClass = $get(@strResolveCls)
        objResolveClass.set(m$.Fnc.$get(m$.indirectVar(strResolveCls.get())));
        //<< if (objResolveClass '= "") {
        if ((mOp.NotEqual(objResolveClass.get(),""))) {
          //<< if (pstrDisplayField'="") {
          if ((mOp.NotEqual(pstrDisplayField.get(),""))) {
            //<< set strTempValue = $piece(objResolveClass,Y,pstrDisplayField)   // set the value to the display field value
            strTempValue.set(m$.Fnc.$piece(objResolveClass.get(),m$.var("Y").get(),pstrDisplayField.get()));
          }
        }
      }
      //<< }
      //<< }
      //<< 
      //<< } elseif ($piece(pstrValue,";",loop)'="")  {  // if the relation primary key property in WWWDataExMessageProp is not present
      else if ((mOp.NotEqual(m$.Fnc.$piece(pstrValue.get(),";",loop.get()),""))) {
        //<< set objResolveClass = $get(@strResolveClass@(0,$piece(pstrValue,";",loop),1))
        objResolveClass.set(m$.Fnc.$get(m$.indirectVar(strResolveClass.get()).var(0,m$.Fnc.$piece(pstrValue.get(),";",loop.get()),1)));
        //<< if (objResolveClass '= "") {
        if ((mOp.NotEqual(objResolveClass.get(),""))) {
          //<< if (pstrDisplayField'="") {
          if ((mOp.NotEqual(pstrDisplayField.get(),""))) {
            //<< set strTempValue = $piece(objResolveClass,Y,pstrDisplayField)   // set the value to the display field value
            strTempValue.set(m$.Fnc.$piece(objResolveClass.get(),m$.var("Y").get(),pstrDisplayField.get()));
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< if (strVal="") {
      if ((mOp.Equal(strVal.get(),""))) {
        //<< set strVal=strTempValue
        strVal.set(strTempValue.get());
      }
      //<< 
      //<< } else {  // To build the data value for multiple select
      else {
        //<< if (pstrDelimiter'=";") {
        if ((mOp.NotEqual(pstrDelimiter.get(),";"))) {
          //<< set strVal=strVal_";"_strTempValue
          strVal.set(mOp.Concat(mOp.Concat(strVal.get(),";"),strTempValue.get()));
        }
        //<< } else {
        else {
          //<< set strVal=strVal_"|"_strTempValue
          strVal.set(mOp.Concat(mOp.Concat(strVal.get(),"|"),strTempValue.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit strVal
    return strVal.get();
  }

  //<< 
  //<< 
  //<< CheckData(pidMsgType,pstrGlobal,pobjRecord)
  public Object CheckData(Object ... _p) {
    mVar pidMsgType = m$.newVarRef("pidMsgType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjRecord = m$.newVarRef("pobjRecord",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; check the incoming new data record with the existing data record.
    //<< ;
    //<< ; Inputs :
    //<< ; pidMsgType = id of WWWDataExMessage
    //<< ; pstrGlobal = global string: ^TEST(0,1,1)
    //<< ; pobjRecord = record string: DATA~DATA~DATA
    //<< ;
    //<< ; History :
    //<< ; 09-Apr-2009   shobby  SR16479: Reviewed 'newing' of variables.
    //<< ; 05-Nov-2008   shobby  SRBR014985: Don't continue checking if we have found a change.
    //<< ; 04-Nov-2008   shobby  SRBR014985: strGlobalSortName should only be $$$Index'd
    //<< ;                           for the first occurence in the WWW003s global.
    //<< ; 23-May-2008   CHINMAY Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idMsgProp,objMsgProp,objOldRecord,blnFlag,strNewValue,strOldValue,strSourcePropName,intPropNum
    mVar idMsgProp = m$.var("idMsgProp");
    mVar objMsgProp = m$.var("objMsgProp");
    mVar objOldRecord = m$.var("objOldRecord");
    mVar blnFlag = m$.var("blnFlag");
    mVar strNewValue = m$.var("strNewValue");
    mVar strOldValue = m$.var("strOldValue");
    mVar strSourcePropName = m$.var("strSourcePropName");
    mVar intPropNum = m$.var("intPropNum");
    m$.newVar(idMsgProp,objMsgProp,objOldRecord,blnFlag,strNewValue,strOldValue,strSourcePropName,intPropNum);
    //<< new idxGlobalSortName,strGlobalName
    mVar idxGlobalSortName = m$.var("idxGlobalSortName");
    mVar strGlobalName = m$.var("strGlobalName");
    m$.newVar(idxGlobalSortName,strGlobalName);
    //<< 
    //<< set objOldRecord      = $get(@pstrGlobal)
    objOldRecord.set(m$.Fnc.$get(m$.indirectVar(pstrGlobal.get())));
    //<< set strGlobalName     = $piece($piece(pstrGlobal,"^",2),"(",1)
    strGlobalName.set(m$.Fnc.$piece(m$.Fnc.$piece(pstrGlobal.get(),"^",2),"(",1));
    //<< set idxGlobalSortName = $$$Index(strGlobalName)
    idxGlobalSortName.set(include.MEDConst.$$$Index(m$,strGlobalName));
    //<< 
    //<< set blnFlag = $$$NO
    blnFlag.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< // Run through the data fields to check for if there are any difference between the old value and new value or not
    //<< set idMsgProp = ""
    idMsgProp.set("");
    //<< for {
    for (;true;) {
      //<< quit:blnFlag
      if (mOp.Logical(blnFlag.get())) {
        break;
      }
      //<< set idMsgProp = $order(^WWWDataExMessageProp(0,pidMsgType,idMsgProp))
      idMsgProp.set(m$.Fnc.$order(m$.var("^WWWDataExMessageProp",0,pidMsgType.get(),idMsgProp.get())));
      //<< quit:idMsgProp=""
      if (mOp.Equal(idMsgProp.get(),"")) {
        break;
      }
      //<< 
      //<< set objMsgProp        = $get(^WWWDataExMessageProp(0,pidMsgType,idMsgProp,1))
      objMsgProp.set(m$.Fnc.$get(m$.var("^WWWDataExMessageProp",0,pidMsgType.get(),idMsgProp.get(),1)));
      //<< set strSourcePropName = $$$WWWDataExMessagePropSourcePropertyName(objMsgProp)
      strSourcePropName.set(include.WWWConst.$$$WWWDataExMessagePropSourcePropertyName(m$,objMsgProp));
      //<< set intPropNum        = ""
      intPropNum.set("");
      //<< 
      //<< if (strSourcePropName'="") {          //get the property number from the ^WWW003 global
      if ((mOp.NotEqual(strSourcePropName.get(),""))) {
        //<< set intPropNum = $order(^WWW003s(0,3,idxGlobalSortName,$$$Index(strSourcePropName),strGlobalName,intPropNum))
        intPropNum.set(m$.Fnc.$order(m$.var("^WWW003s",0,3,idxGlobalSortName.get(),include.MEDConst.$$$Index(m$,strSourcePropName),strGlobalName.get(),intPropNum.get())));
        //<< if (intPropNum'="") {
        if ((mOp.NotEqual(intPropNum.get(),""))) {
          //<< set strNewValue = $piece(pobjRecord,Y,intPropNum)
          strNewValue.set(m$.Fnc.$piece(pobjRecord.get(),m$.var("Y").get(),intPropNum.get()));
          //<< set strOldValue = $piece(objOldRecord,Y,intPropNum) //get the old Value from @pstrGlobal
          strOldValue.set(m$.Fnc.$piece(objOldRecord.get(),m$.var("Y").get(),intPropNum.get()));
          //<< //compare the new value with old, if any changes then set boolean to true
          //<< if (strNewValue'=strOldValue) {
          if ((mOp.NotEqual(strNewValue.get(),strOldValue.get()))) {
            //<< set blnFlag = $$$YES
            blnFlag.set(include.COMSYS.$$$YES(m$));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit blnFlag
    return blnFlag.get();
  }

  //<< 
  //<< 
  //<< In(pstrSender)
  public Object In(Object ... _p) {
    mVar pstrSender = m$.newVarRef("pstrSender",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; Read data in exchange queue and save
    //<< ;
    //<< ; Inputs :
    //<< ; pstrSender = Sending Remote System (make sure message was fore this sender)
    //<< ;
    //<< ; History :
    //<< ; 30-Apr-2009   shobby  SR16438: If no WWWDataExchange message is set up, don't
    //<< ;                           use the last in the loop.
    //<< ; 09-Apr-2009   shobby  SR16479: Reviewed 'newing' of variables.
    //<< ; 07-Nov-2008   shobby  BR014985: Empty key may return double quotes.  Strip before testing.
    //<< ; 05-Nov-2008   shobby  BR014985: Use the definitions of the properties in the
    //<< ;                           data exchange setup as the loop to populate the record.
    //<< ;                           This handles the case where there are required fields
    //<< ;                           with default values that don't come from the remote system.
    //<< ; 04-Nov-2008   shobby  BR014985: Some changes to allow for default values if
    //<< ;                           required.  Fields in Alphalinc are not known in the
    //<< ;                           remote system.
    //<< ; 29-Oct-2008   shobby  BR014985: More rewrites for multiple keys
    //<< ; 27-Oct-2008   shobby  BR014985: Start of work to support multiple keys
    //<< ; 22-Oct-2008   FIS     BR014985: Kill Record if Action Type = Delete
    //<< ; 21-05-2008    VIJAY   Modified
    //<< ; 05-05-2008    KALYAN  Created
    //<< ;-------------------------------------------------------------------------------
    //<< // TO DO
    //<< new idMsgReceive,objMsgReceive,idMsgProperty,objMsgData
    mVar idMsgReceive = m$.var("idMsgReceive");
    mVar objMsgReceive = m$.var("objMsgReceive");
    mVar idMsgProperty = m$.var("idMsgProperty");
    mVar objMsgData = m$.var("objMsgData");
    m$.newVar(idMsgReceive,objMsgReceive,idMsgProperty,objMsgData);
    //<< new idMsgType,objDataClass,idGlobal,strGlobal,objWWWDataExMessageProp
    mVar idMsgType = m$.var("idMsgType");
    mVar objDataClass = m$.var("objDataClass");
    mVar idGlobal = m$.var("idGlobal");
    mVar strGlobal = m$.var("strGlobal");
    mVar objWWWDataExMessageProp = m$.var("objWWWDataExMessageProp");
    m$.newVar(idMsgType,objDataClass,idGlobal,strGlobal,objWWWDataExMessageProp);
    //<< new strPrimaryKey,idMsgPrimaryKey,idPrimaryKey,objGlobalData
    mVar strPrimaryKey = m$.var("strPrimaryKey");
    mVar idMsgPrimaryKey = m$.var("idMsgPrimaryKey");
    mVar idPrimaryKey = m$.var("idPrimaryKey");
    mVar objGlobalData = m$.var("objGlobalData");
    m$.newVar(strPrimaryKey,idMsgPrimaryKey,idPrimaryKey,objGlobalData);
    //<< new strDataItem,strStatus,errcode,objMsgSrcProp,idMsgSrcProp,strSrcProp,blnNewRecord
    mVar strDataItem = m$.var("strDataItem");
    mVar strStatus = m$.var("strStatus");
    mVar errcode = m$.var("errcode");
    mVar objMsgSrcProp = m$.var("objMsgSrcProp");
    mVar idMsgSrcProp = m$.var("idMsgSrcProp");
    mVar strSrcProp = m$.var("strSrcProp");
    mVar blnNewRecord = m$.var("blnNewRecord");
    m$.newVar(strDataItem,strStatus,errcode,objMsgSrcProp,idMsgSrcProp,strSrcProp,blnNewRecord);
    //<< // run through the WWWDataExMessageReceive
    //<< 
    //<< set $ztrap = "DataError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("DataError");
    //<< set errcode = 1
    errcode.set(1);
    //<< set idMsgReceive = ""
    idMsgReceive.set("");
    //<< for {
    for (;true;) {
      //<< set idMsgReceive= $order(^WWWDataExMessageReceives(0,1," ",pstrSender,idMsgReceive))
      idMsgReceive.set(m$.Fnc.$order(m$.var("^WWWDataExMessageReceives",0,1," ",pstrSender.get(),idMsgReceive.get())));
      //<< quit:idMsgReceive=""
      if (mOp.Equal(idMsgReceive.get(),"")) {
        break;
      }
      //<< 
      //<< set objMsgReceive = $get(^WWWDataExMessageReceive(0,pstrSender,idMsgReceive,1))
      objMsgReceive.set(m$.Fnc.$get(m$.var("^WWWDataExMessageReceive",0,pstrSender.get(),idMsgReceive.get(),1)));
      //<< ;   FIXME : Get $$$WWWDataExMessageReceiveMessageType(objMsgReceive) here rather than inside next loop. <GRF>
      //<< 
      //<< //Loop for getting the DataClass from the MessageType setting
      //<< set idMsgType = ""
      idMsgType.set("");
      //<< for {
      for (;true;) {
        //<< set idMsgType = $order(^WWWDataExchange(0,idMsgType))
        idMsgType.set(m$.Fnc.$order(m$.var("^WWWDataExchange",0,idMsgType.get())));
        //<< quit:idMsgType=""
        if (mOp.Equal(idMsgType.get(),"")) {
          break;
        }
        //<< set objDataClass = $get(^WWWDataExchange(0,idMsgType,1))
        objDataClass.set(m$.Fnc.$get(m$.var("^WWWDataExchange",0,idMsgType.get(),1)));
        //<< quit:(($$$WWWDataExMessageReceiveMessageType(objMsgReceive)=$$$WWWDataExchangeMessageType(objDataClass)) && ($$$WWWDataExchangeRemoteSystem(objDataClass)=pstrSender))
        if (mOp.Logical(((mOp.Equal(include.WWWConst.$$$WWWDataExMessageReceiveMessageType(m$,objMsgReceive),include.WWWConst.$$$WWWDataExchangeMessageType(m$,objDataClass))) && (mOp.Equal(include.WWWConst.$$$WWWDataExchangeRemoteSystem(m$,objDataClass),pstrSender.get()))))) {
          break;
        }
        //<< 
        //<< set objDataClass=""
        objDataClass.set("");
      }
      //<< }
      //<< quit:objDataClass=""
      if (mOp.Equal(objDataClass.get(),"")) {
        break;
      }
      //<< set idGlobal = $$$WWWDataExchangeDataClass(objDataClass)
      idGlobal.set(include.WWWConst.$$$WWWDataExchangeDataClass(m$,objDataClass));
      //<< set strGlobal = "^"_idGlobal
      strGlobal.set(mOp.Concat("^",idGlobal.get()));
      //<< 
      //<< // read data out of WWWDataExMessageData
      //<< set strPrimaryKey=$$GetPrimaryKey(idGlobal,idMsgReceive,.idMsgPrimaryKey)
      strPrimaryKey.set(m$.fnc$("GetPrimaryKey",idGlobal.get(),idMsgReceive.get(),idMsgPrimaryKey));
      //<< quit:$translate(strPrimaryKey,"""")=""
      if (mOp.Equal(m$.Fnc.$translate(strPrimaryKey.get(),"\""),"")) {
        break;
      }
      //<< 
      //<< //Delete Record
      //<< if $$$WWWDataExMessageReceiveType(objMsgReceive) = "Delete" {
      if (mOp.Equal(include.WWWConst.$$$WWWDataExMessageReceiveType(m$,objMsgReceive),"Delete")) {
        //<< if (strPrimaryKey '= "") {
        if ((mOp.NotEqual(strPrimaryKey.get(),""))) {
          //<< do ^WWWSKILL(idGlobal,strPrimaryKey)
          m$.Cmd.Do("WWWSKILL.main",idGlobal.get(),strPrimaryKey.get());
        }
        //<< }
        //<< set strStatus = $$$OK
        strStatus.set(include.COMSYS.$$$OK(m$));
      }
      //<< 
      //<< } else {
      else {
        //<< //Save Records
        //<< xecute "set objGlobalData = $get("_strGlobal_"(0,"_strPrimaryKey_",1))"
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("set objGlobalData = $get(",strGlobal.get()),"(0,"),strPrimaryKey.get()),",1))"));
        //<< 
        //<< set blnNewRecord  = (objGlobalData="")
        blnNewRecord.set((mOp.Equal(objGlobalData.get(),"")));
        //<< set idMsgProperty = idMsgPrimaryKey
        idMsgProperty.set(idMsgPrimaryKey.get());
        //<< for {
        for (;true;) {
          //<< set idMsgProperty = $order(^WWWDataExMessageProp(0,$$$WWWDataExchangeMessageType(objDataClass),idMsgProperty))
          idMsgProperty.set(m$.Fnc.$order(m$.var("^WWWDataExMessageProp",0,include.WWWConst.$$$WWWDataExchangeMessageType(m$,objDataClass),idMsgProperty.get())));
          //<< quit:idMsgProperty=""
          if (mOp.Equal(idMsgProperty.get(),"")) {
            break;
          }
          //<< 
          //<< set objWWWDataExMessageProp = $get(^WWWDataExMessageProp(0,$$$WWWDataExchangeMessageType(objDataClass),idMsgProperty,1))
          objWWWDataExMessageProp.set(m$.Fnc.$get(m$.var("^WWWDataExMessageProp",0,include.WWWConst.$$$WWWDataExchangeMessageType(m$,objDataClass),idMsgProperty.get(),1)));
          //<< set strSrcProp  = $$$WWWDataExMessagePropSourcePropertyName(objWWWDataExMessageProp)
          strSrcProp.set(include.WWWConst.$$$WWWDataExMessagePropSourcePropertyName(m$,objWWWDataExMessageProp));
          //<< set strDataItem = "" ; FIXME : determine $$$Index(idGlobal) *OUTSIDE* of for loop <GRF>
          strDataItem.set("");
          //<< set strDataItem = $order(^WWW003s(0,3,$$$Index(idGlobal),$$$Index(strSrcProp),idGlobal,strDataItem))
          strDataItem.set(m$.Fnc.$order(m$.var("^WWW003s",0,3,include.MEDConst.$$$Index(m$,idGlobal),include.MEDConst.$$$Index(m$,strSrcProp),idGlobal.get(),strDataItem.get())));
          //<< 
          //<< ;   FIXME : Should not new inside block - scope is not the same as for dot level format
          //<< new strDefaultValue
          mVar strDefaultValue = m$.var("strDefaultValue");
          m$.newVar(strDefaultValue);
          //<< 
          //<< set strDefaultValue=$$$WWWDataExMessagePropDefaultValue(objWWWDataExMessageProp)
          strDefaultValue.set(include.WWWConst.$$$WWWDataExMessagePropDefaultValue(m$,objWWWDataExMessageProp));
          //<< 
          //<< if $data(^WWWDataExMessageData(0,idMsgReceive,idMsgProperty,1)) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDataExMessageData",0,idMsgReceive.get(),idMsgProperty.get(),1)))) {
            //<< set $piece(objGlobalData,Y,strDataItem) = $get(^WWWDataExMessageData(0,idMsgReceive,idMsgProperty,1))
            m$.pieceVar(objGlobalData,m$.var("Y").get(),strDataItem.get()).set(m$.Fnc.$get(m$.var("^WWWDataExMessageData",0,idMsgReceive.get(),idMsgProperty.get(),1)));
          }
          //<< 
          //<< } else {
          else {
            //<< if (strDefaultValue'="") && (blnNewRecord) {
            if ((mOp.NotEqual(strDefaultValue.get(),"")) && mOp.Logical((blnNewRecord.get()))) {
              //<< if ($extract(strDefaultValue,1)="{") && ($extract(strDefaultValue,$length(strDefaultValue))="}") {
              if ((mOp.Equal(m$.Fnc.$extract(strDefaultValue.get(),1),"{")) && (mOp.Equal(m$.Fnc.$extract(strDefaultValue.get(),m$.Fnc.$length(strDefaultValue.get())),"}"))) {
                //<< set strDefaultValue = $extract(strDefaultValue,2,$length(strDefaultValue)-1)
                strDefaultValue.set(m$.Fnc.$extract(strDefaultValue.get(),2,mOp.Subtract(m$.Fnc.$length(strDefaultValue.get()),1)));
                //<< set $piece(objGlobalData,Y,strDataItem) = $get(^WWWDataExMessageData(0,idMsgReceive,$$GetPropertyNumber($$$WWWDataExchangeMessageType(objDataClass),strDefaultValue),1))
                m$.pieceVar(objGlobalData,m$.var("Y").get(),strDataItem.get()).set(m$.Fnc.$get(m$.var("^WWWDataExMessageData",0,idMsgReceive.get(),m$.fnc$("GetPropertyNumber",include.WWWConst.$$$WWWDataExchangeMessageType(m$,objDataClass),strDefaultValue.get()),1)));
              }
              //<< 
              //<< } else {
              else {
                //<< set $piece(objGlobalData,Y,strDataItem) = strDefaultValue
                m$.pieceVar(objGlobalData,m$.var("Y").get(),strDataItem.get()).set(strDefaultValue.get());
              }
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< }
        //<< // save data in globals
        //<< set strStatus = $$$Save(idGlobal,strPrimaryKey,objGlobalData,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,idGlobal,strPrimaryKey,objGlobalData,include.COMSYS.$$$YES(m$)));
      }
      //<< }
      //<< // mark message as processed
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< set $$$WWWDataExMessageReceiveTimestampProcessed(objMsgReceive)=$horolog
        include.WWWConst.$$$WWWDataExMessageReceiveTimestampProcessedSet(m$,objMsgReceive,m$.Fnc.$horolog());
        //<< set strStatus = $$$Save("WWWDataExMessageReceive",pstrSender_","_idMsgReceive,objMsgReceive,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"WWWDataExMessageReceive",mOp.Concat(mOp.Concat(pstrSender.get(),","),idMsgReceive.get()),objMsgReceive,include.COMSYS.$$$YES(m$)));
        //<< do ClearDataContainer(idMsgReceive)
        m$.Cmd.Do("ClearDataContainer",idMsgReceive.get());
      }
      //<< 
      //<< } else {
      else {
        //<< set errcode = 0
        errcode.set(0);
      }
    }
    //<< }
    //<< }
    //<< quit errcode
    return errcode.get();
  }

  //<< 
  //<< 
  //<< GetPropertyNumber(pidDataClass,pstrProperty)
  public Object GetPropertyNumber(Object ... _p) {
    mVar pidDataClass = m$.newVarRef("pidDataClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrProperty = m$.newVarRef("pstrProperty",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; From the description find the number of the property
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 04-Nov-2008   shobby  SRBR014965: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intNumber
    mVar intNumber = m$.var("intNumber");
    m$.newVar(intNumber);
    //<< 
    //<< set intNumber = $order(^WWWDataExMessageProps(0,1,$$$Index(pstrProperty),pidDataClass,""))
    intNumber.set(m$.Fnc.$order(m$.var("^WWWDataExMessageProps",0,1,include.MEDConst.$$$Index(m$,pstrProperty),pidDataClass.get(),"")));
    //<< quit intNumber
    return intNumber.get();
  }

  //<< 
  //<< 
  //<< GetPrimaryKey(pidGlobal,pidMsgReceive,&pidMsgPrimaryKey)
  public Object GetPrimaryKey(Object ... _p) {
    mVar pidGlobal = m$.newVarRef("pidGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidMsgReceive = m$.newVarRef("pidMsgReceive",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidMsgPrimaryKey = m$.newVarRef("pidMsgPrimaryKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets the primary key, supports multi part primary keys
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Apr-2009   shobby  SR16479: WWWDataExMessageData was using 0 not YM
    //<< ; 27-Oct-2008   shobby  SRBR014985: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idWWW002,strPrimaryKey,intKey,intId,strValue,intPiece
    mVar idWWW002 = m$.var("idWWW002");
    mVar strPrimaryKey = m$.var("strPrimaryKey");
    mVar intKey = m$.var("intKey");
    mVar intId = m$.var("intId");
    mVar strValue = m$.var("strValue");
    mVar intPiece = m$.var("intPiece");
    m$.newVar(idWWW002,strPrimaryKey,intKey,intId,strValue,intPiece);
    //<< 
    //<< set strPrimaryKey    = ""
    strPrimaryKey.set("");
    //<< set idWWW002         = ""
    idWWW002.set("");
    //<< set pidMsgPrimaryKey = 0
    pidMsgPrimaryKey.set(0);
    //<< set intPiece         = 0
    intPiece.set(0);
    //<< 
    //<< for {
    for (;true;) {
      //<< set idWWW002 = $order(^WWW002(0,pidGlobal,idWWW002))
      idWWW002.set(m$.Fnc.$order(m$.var("^WWW002",0,pidGlobal.get(),idWWW002.get())));
      //<< quit:(idWWW002="")
      if ((mOp.Equal(idWWW002.get(),""))) {
        break;
      }
      //<< set pidMsgPrimaryKey = $order(^WWWDataExMessageData(0,pidMsgReceive,pidMsgPrimaryKey))
      pidMsgPrimaryKey.set(m$.Fnc.$order(m$.var("^WWWDataExMessageData",0,pidMsgReceive.get(),pidMsgPrimaryKey.get())));
      //<< quit:pidMsgPrimaryKey=""
      if (mOp.Equal(pidMsgPrimaryKey.get(),"")) {
        break;
      }
      //<< 
      //<< set strValue = $$$WWWDataExMessageDataValue1($get(^WWWDataExMessageData(0,pidMsgReceive,pidMsgPrimaryKey,1)))
      strValue.set(include.WWWConst.$$$WWWDataExMessageDataValue1(m$,m$.Fnc.$get(m$.var("^WWWDataExMessageData",0,pidMsgReceive.get(),pidMsgPrimaryKey.get(),1))));
      //<< set strValue = $$DoMappingClass("Primary Key",strValue)
      strValue.set(m$.fnc$("DoMappingClass","Primary Key",strValue.get()));
      //<< set $piece(strPrimaryKey,$$$COMMA,$increment(intPiece)) = strValue_$$$COMMA   ; FIXME : This puts 2 pieces in position - $$$COMMA suffix not required <GRF>
      m$.pieceVar(strPrimaryKey,include.COMSYSString.$$$COMMA(m$),m$.Fnc.$increment(intPiece)).set(mOp.Concat(strValue.get(),include.COMSYSString.$$$COMMA(m$)));
    }
    //<< }
    //<< set strPrimaryKey=$$^WWWKEYBUILD(strPrimaryKey)
    strPrimaryKey.set(m$.fnc$("WWWKEYBUILD.main",strPrimaryKey.get()));
    //<< quit strPrimaryKey
    return strPrimaryKey.get();
  }

  //<< 
  //<< 
  //<< GetDataExMessage(pidRecipient,pidMessage,pidDataExMessage)
  public Object GetDataExMessage(Object ... _p) {
    mVar pidRecipient = m$.newVarRef("pidRecipient",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidMessage = m$.newVarRef("pidMessage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidDataExMessage = m$.newVarRef("pidDataExMessage",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Updates the message with an error if there is a problem
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Apr-2009   shobby  SR16479: Reviewed 'newing' of variables.
    //<< ; 08-Dec-2008   shobby  BR014985: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objDataExMessage,objWWWDataExMessageSend,strStatus
    mVar objDataExMessage = m$.var("objDataExMessage");
    mVar objWWWDataExMessageSend = m$.var("objWWWDataExMessageSend");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objDataExMessage,objWWWDataExMessageSend,strStatus);
    //<< 
    //<< set objDataExMessage = $get(^WWWDataExMessage(0,pidDataExMessage,1))
    objDataExMessage.set(m$.Fnc.$get(m$.var("^WWWDataExMessage",0,pidDataExMessage.get(),1)));
    //<< if objDataExMessage="" {
    if (mOp.Equal(objDataExMessage.get(),"")) {
      //<< set objWWWDataExMessageSend = $get(^WWWDataExMessageSend(0,pidRecipient,pidMessage,1))
      objWWWDataExMessageSend.set(m$.Fnc.$get(m$.var("^WWWDataExMessageSend",0,pidRecipient.get(),pidMessage.get(),1)));
      //<< set $$$WWWDataExMessageSendStatus(objWWWDataExMessageSend) = 0      ;Error
      include.WWWConst.$$$WWWDataExMessageSendStatusSet(m$,objWWWDataExMessageSend,0);
      //<< set strStatus = $$$Save("WWWDataExMessageSend",pidRecipient_","_pidMessage,objWWWDataExMessageSend,$$$YES)
      strStatus.set(include.COMSYS.$$$Save(m$,"WWWDataExMessageSend",mOp.Concat(mOp.Concat(pidRecipient.get(),","),pidMessage.get()),objWWWDataExMessageSend,include.COMSYS.$$$YES(m$)));
    }
    //<< }
    //<< quit objDataExMessage
    return objDataExMessage.get();
  }

  //<< 
  //<< 
  //<< GetData(pstrRecipient,&strData="",&syncMsg="",&blnEncrypt=$$$NO)    ; FIXME : prefixes <GRF>
  public Object GetData(Object ... _p) {
    mVar pstrRecipient = m$.newVarRef("pstrRecipient",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar strData = m$.newVarRef("strData",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar syncMsg = m$.newVarRef("syncMsg",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar blnEncrypt = m$.newVarRef("blnEncrypt",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; pick up data out of message queue
    //<< ;
    //<< ; This will be called from Webservice "alWEB.WS.DataExchange.cls"
    //<< ;
    //<< ; Inputs :
    //<< ; pstrRecipient = Data Recipient (to validate access)
    //<< ; ByRef Data = data file string
    //<< ; ByRef syncMsg = Message No. (for confirmation)
    //<< ; ByRef blnEncrypt = Encrypt Message yes/no
    //<< ;
    //<< ; History :
    //<< ; 22-Oct-2008   FIS     BR014985: Action Type added to the delimitered string
    //<< ; 29-May-2008   CHINMAY The structure of the Data String sent over webservice is
    //<< ;                           changed to contain only modified data.
    //<< ; 02-May-2008   CHINMAY Changed the structure of XML and Delimitered Data String
    //<< ; 30-Apr-2008   SRINIVAS RAPOL  created
    //<< ;-------------------------------------------------------------------------------
    //<< new strDataExMsgKey,objDataExMsg,idMsgQueue,objMsgData,strFileType
    mVar strDataExMsgKey = m$.var("strDataExMsgKey");
    mVar objDataExMsg = m$.var("objDataExMsg");
    mVar idMsgQueue = m$.var("idMsgQueue");
    mVar objMsgData = m$.var("objMsgData");
    mVar strFileType = m$.var("strFileType");
    m$.newVar(strDataExMsgKey,objDataExMsg,idMsgQueue,objMsgData,strFileType);
    //<< new strMsgProps,strDelimeter,idTargetProp,objMsgQueue
    mVar strMsgProps = m$.var("strMsgProps");
    mVar strDelimeter = m$.var("strDelimeter");
    mVar idTargetProp = m$.var("idTargetProp");
    mVar objMsgQueue = m$.var("objMsgQueue");
    m$.newVar(strMsgProps,strDelimeter,idTargetProp,objMsgQueue);
    //<< 
    //<< // search for next message (oldest, not processed message)
    //<< set idMsgQueue = $order(^WWWDataExMessageSends(0,1," ",pstrRecipient,""))
    idMsgQueue.set(m$.Fnc.$order(m$.var("^WWWDataExMessageSends",0,1," ",pstrRecipient.get(),"")));
    //<< 
    //<< if (idMsgQueue '= "") {
    if ((mOp.NotEqual(idMsgQueue.get(),""))) {
      //<< set objMsgQueue  = $get(^WWWDataExMessageSend(0,pstrRecipient,idMsgQueue,1))
      objMsgQueue.set(m$.Fnc.$get(m$.var("^WWWDataExMessageSend",0,pstrRecipient.get(),idMsgQueue.get(),1)));
      //<< set objDataExMsg = $$GetDataExMessage(pstrRecipient,idMsgQueue,$$$WWWDataExMessageSendMessageType(objMsgQueue))
      objDataExMsg.set(m$.fnc$("GetDataExMessage",pstrRecipient.get(),idMsgQueue.get(),include.WWWConst.$$$WWWDataExMessageSendMessageType(m$,objMsgQueue)));
      //<< if objDataExMsg'="" {
      if (mOp.NotEqual(objDataExMsg.get(),"")) {
        //<< if ($$$WWWDataExMessageFileType(objDataExMsg)=0) { ;File Types:1.Delimitered
        if ((mOp.Equal(include.WWWConst.$$$WWWDataExMessageFileType(m$,objDataExMsg),0))) {
          //<< // read data out of WWWDataExMessageData and form the delimitered String data
          //<< set strDelimeter = $char($$$WWWDataExMessageDelimeterASCII(objDataExMsg))
          strDelimeter.set(m$.Fnc.$char(include.WWWConst.$$$WWWDataExMessageDelimeterASCII(m$,objDataExMsg)));
          //<< if strDelimeter="" set strDelimeter = $char(126)  ;~
          if (mOp.Equal(strDelimeter.get(),"")) {
            strDelimeter.set(m$.Fnc.$char(126));
          }
          //<< set strData = strData_strDelimeter_$$$WWWDataExMessageSendMessageType(objMsgQueue)  ;piece2 = Message Type
          strData.set(mOp.Concat(mOp.Concat(strData.get(),strDelimeter.get()),include.WWWConst.$$$WWWDataExMessageSendMessageType(m$,objMsgQueue)));
          //<< set strData = strData_strDelimeter_idMsgQueue                                       ;piece3 = Message Id
          strData.set(mOp.Concat(mOp.Concat(strData.get(),strDelimeter.get()),idMsgQueue.get()));
          //<< set strData = strData_strDelimeter_$$$WWWDataExMessageSendType(objMsgQueue)         ;piece4 = Action Type
          strData.set(mOp.Concat(mOp.Concat(strData.get(),strDelimeter.get()),include.WWWConst.$$$WWWDataExMessageSendType(m$,objMsgQueue)));
          //<< set idTargetProp = ""
          idTargetProp.set("");
          //<< for {
          for (;true;) {
            //<< set idTargetProp = $order(^WWWDataExMessageData(0,idMsgQueue,idTargetProp))
            idTargetProp.set(m$.Fnc.$order(m$.var("^WWWDataExMessageData",0,idMsgQueue.get(),idTargetProp.get())));
            //<< quit:idTargetProp=""
            if (mOp.Equal(idTargetProp.get(),"")) {
              break;
            }
            //<< 
            //<< set objMsgData=$get(^WWWDataExMessageData(0,idMsgQueue,idTargetProp,1))
            objMsgData.set(m$.Fnc.$get(m$.var("^WWWDataExMessageData",0,idMsgQueue.get(),idTargetProp.get(),1)));
            //<< 
            //<< if (idTargetProp'=$$$WWWDataExMessageSendMessageType(objMsgQueue)) {
            if ((mOp.NotEqual(idTargetProp.get(),include.WWWConst.$$$WWWDataExMessageSendMessageType(m$,objMsgQueue)))) {
              //<< set $piece(strData,strDelimeter,idTargetProp+9)=$$$WWWDataExMessageDataValue1(objMsgData)  ;piece10-n = Data
              m$.pieceVar(strData,strDelimeter.get(),mOp.Add(idTargetProp.get(),9)).set(include.WWWConst.$$$WWWDataExMessageDataValue1(m$,objMsgData));
            }
          }
          //<< }
          //<< }
          //<< if $$$WWWDataExMessageEncryptMessage(objDataExMsg)=1 {
          if (mOp.Equal(include.WWWConst.$$$WWWDataExMessageEncryptMessage(m$,objDataExMsg),1)) {
            //<< set blnEncrypt = $$$YES
            blnEncrypt.set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< // create  XML structured string in any case ;File Types:1.XML
          //<< // read data out of WWWDataExMessageData and form the Xml String data
          //<< set strData = strData_"<Message"
          strData.set(mOp.Concat(strData.get(),"<Message"));
          //<< set strData = strData_" Type="_""""_$$$WWWDataExMessageSendMessageType(objMsgQueue)_""""
          strData.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strData.get()," Type="),"\""),include.WWWConst.$$$WWWDataExMessageSendMessageType(m$,objMsgQueue)),"\""));
          //<< set strData = strData_" Action="_""""_$$$WWWDataExMessageSendType(objMsgQueue)_""""
          strData.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strData.get()," Action="),"\""),include.WWWConst.$$$WWWDataExMessageSendType(m$,objMsgQueue)),"\""));
          //<< set strData = strData_" Id="_""""_idMsgQueue_""""
          strData.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strData.get()," Id="),"\""),idMsgQueue.get()),"\""));
          //<< set strData = strData_">"
          strData.set(mOp.Concat(strData.get(),">"));
          //<< set idTargetProp = ""
          idTargetProp.set("");
          //<< for {
          for (;true;) {
            //<< set idTargetProp = $order(^WWWDataExMessageData(0,idMsgQueue,idTargetProp))
            idTargetProp.set(m$.Fnc.$order(m$.var("^WWWDataExMessageData",0,idMsgQueue.get(),idTargetProp.get())));
            //<< quit:idTargetProp=""
            if (mOp.Equal(idTargetProp.get(),"")) {
              break;
            }
            //<< 
            //<< set objMsgData=$get(^WWWDataExMessageData(0,idMsgQueue,idTargetProp,1))
            objMsgData.set(m$.Fnc.$get(m$.var("^WWWDataExMessageData",0,idMsgQueue.get(),idTargetProp.get(),1)));
            //<< 
            //<< if (idTargetProp'=$$$WWWDataExMessageSendMessageType(objMsgQueue)) {
            if ((mOp.NotEqual(idTargetProp.get(),include.WWWConst.$$$WWWDataExMessageSendMessageType(m$,objMsgQueue)))) {
              //<< set strData = strData_"<"_idTargetProp_">"_$$$WWWDataExMessageDataValue1(objMsgData)_"</"_idTargetProp_">"
              strData.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strData.get(),"<"),idTargetProp.get()),">"),include.WWWConst.$$$WWWDataExMessageDataValue1(m$,objMsgData)),"</"),idTargetProp.get()),">"));
            }
          }
          //<< }
          //<< }
          //<< set strData = strData_"</Message>"
          strData.set(mOp.Concat(strData.get(),"</Message>"));
        }
        //<< }
        //<< set syncMsg = idMsgQueue
        syncMsg.set(idMsgQueue.get());
      }
    }
    //<< }
    //<< }
    //<< quit 1
    return 1;
  }

  //<< 
  //<< 
  //<< FlagProcessed(pstrRecipient,pstrMessageNo)
  public Object FlagProcessed(Object ... _p) {
    mVar pstrRecipient = m$.newVarRef("pstrRecipient",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrMessageNo = m$.newVarRef("pstrMessageNo",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; kill data out of queue, mark message as processed
    //<< ;
    //<< ; Inputs :
    //<< ; pstrRecipient = Data Recipient (to validate kill)
    //<< ; pstrMessageNo = Messege Queue No.
    //<< ;
    //<< ; History :
    //<< ; 08-Dec-2008   shobby  BR014985: Clear out status in case there was an error previously
    //<< ; 17-May-2008   SUDHA   created
    //<< ; 07-May-2008   CHINMAY Modified : To update the timestamp processed flag and
    //<< ;                           delete the data for data class
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,idTargetProp,objMsg
    mVar strStatus = m$.var("strStatus");
    mVar idTargetProp = m$.var("idTargetProp");
    mVar objMsg = m$.var("objMsg");
    m$.newVar(strStatus,idTargetProp,objMsg);
    //<< 
    //<< set strStatus=0
    strStatus.set(0);
    //<< if ($get(pstrRecipient)'="") && ($get(pstrMessageNo)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(pstrRecipient),"")) && (mOp.NotEqual(m$.Fnc.$get(pstrMessageNo),""))) {
      //<< set objMsg=$get(^WWWDataExMessageSend(0,pstrRecipient,pstrMessageNo,1))
      objMsg.set(m$.Fnc.$get(m$.var("^WWWDataExMessageSend",0,pstrRecipient.get(),pstrMessageNo.get(),1)));
      //<< if objMsg'="" {
      if (mOp.NotEqual(objMsg.get(),"")) {
        //<< // mark message as processed i.e. update the TimeStampProcessed property
        //<< set $$$WWWDataExMessageSendTimestampProcessed(objMsg)=$horolog
        include.WWWConst.$$$WWWDataExMessageSendTimestampProcessedSet(m$,objMsg,m$.Fnc.$horolog());
        //<< set $$$WWWDataExMessageSendStatus(objMsg)=""
        include.WWWConst.$$$WWWDataExMessageSendStatusSet(m$,objMsg,"");
        //<< set strStatus = $$$Save("WWWDataExMessageSend",pstrRecipient_","_pstrMessageNo,objMsg,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"WWWDataExMessageSend",mOp.Concat(mOp.Concat(pstrRecipient.get(),","),pstrMessageNo.get()),objMsg,include.COMSYS.$$$YES(m$)));
        //<< 
        //<< // kill data out of queue
        //<< do ClearDataContainer(pstrMessageNo)
        m$.Cmd.Do("ClearDataContainer",pstrMessageNo.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< ClearDataContainer(pstrMessageNo)
  public Object ClearDataContainer(Object ... _p) {
    mVar pstrMessageNo = m$.newVarRef("pstrMessageNo",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; clear WWWDataExMessageData data
    //<< ;
    //<< ; Inputs :
    //<< ; pidMsgType = id of WWWDataExMessage
    //<< ; pstrGlobal = global string: ^TEST(0,1,1)
    //<< ; pobjRecord = record string: DATA~DATA~DATA
    //<< ;
    //<< ; History :
    //<< ; 23-May-2008   CHINMAY Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idTargetProp,strStatus
    mVar idTargetProp = m$.var("idTargetProp");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idTargetProp,strStatus);
    //<< 
    //<< // kill data out of queue
    //<< set idTargetProp = ""
    idTargetProp.set("");
    //<< for {
    for (;true;) {
      //<< set idTargetProp = $order(^WWWDataExMessageData(0,pstrMessageNo,idTargetProp))
      idTargetProp.set(m$.Fnc.$order(m$.var("^WWWDataExMessageData",0,pstrMessageNo.get(),idTargetProp.get())));
      //<< quit:idTargetProp=""
      if (mOp.Equal(idTargetProp.get(),"")) {
        break;
      }
      //<< 
      //<< set strStatus = $$$Kill("WWWDataExMessageData",pstrMessageNo_","_idTargetProp)
      strStatus.set(include.COMSYS.$$$Kill(m$,"WWWDataExMessageData",mOp.Concat(mOp.Concat(pstrMessageNo.get(),","),idTargetProp.get())));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AddDefaultKeys(pstrData,pintFirstPiece)
  public Object AddDefaultKeys(Object ... _p) {
    mVar pstrData = m$.newVarRef("pstrData",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintFirstPiece = m$.newVarRef("pintFirstPiece",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; This routine adds in the default values when a multi key message has fixed components
    //<< ; ie for Units of Measure the EINHEIT part of WWW101 is fixed and the remote system
    //<< ; need not send that key
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Nov-2008   shobby  SRBR014985: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idMessageType,strDelimiter,objWWWDataExMessage,strSourceKeys,intLoop
    mVar idMessageType = m$.var("idMessageType");
    mVar strDelimiter = m$.var("strDelimiter");
    mVar objWWWDataExMessage = m$.var("objWWWDataExMessage");
    mVar strSourceKeys = m$.var("strSourceKeys");
    mVar intLoop = m$.var("intLoop");
    m$.newVar(idMessageType,strDelimiter,objWWWDataExMessage,strSourceKeys,intLoop);
    //<< 
    //<< set strDelimiter  = $extract(pstrData,1)
    strDelimiter.set(m$.Fnc.$extract(pstrData.get(),1));
    //<< set idMessageType = $piece(pstrData,strDelimiter,2)
    idMessageType.set(m$.Fnc.$piece(pstrData.get(),strDelimiter.get(),2));
    //<< set objWWWDataExMessage = $get(^WWWDataExMessage(0,idMessageType,1))
    objWWWDataExMessage.set(m$.Fnc.$get(m$.var("^WWWDataExMessage",0,idMessageType.get(),1)));
    //<< set strSourceKeys = $$$WWWDataExMessageSourceKeys(objWWWDataExMessage)
    strSourceKeys.set(include.WWWConst.$$$WWWDataExMessageSourceKeys(m$,objWWWDataExMessage));
    //<< if strSourceKeys'="" {
    if (mOp.NotEqual(strSourceKeys.get(),"")) {
      //<< for intLoop=1:1:$length(strSourceKeys,",") {
      for (intLoop.set(1);(mOp.LessOrEqual(intLoop.get(),m$.Fnc.$length(strSourceKeys.get(),",")));intLoop.set(mOp.Add(intLoop.get(),1))) {
        //<< if $piece(strSourceKeys,",",intLoop) '="" {
        if (mOp.NotEqual(m$.Fnc.$piece(strSourceKeys.get(),",",intLoop.get()),"")) {
          //<< set $piece(pstrData,strDelimiter,pintFirstPiece+intLoop) = $translate($piece(strSourceKeys,",",intLoop),"""")
          m$.pieceVar(pstrData,strDelimiter.get(),mOp.Add(pintFirstPiece.get(),intLoop.get())).set(m$.Fnc.$translate(m$.Fnc.$piece(strSourceKeys.get(),",",intLoop.get()),"\""));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit pstrData
    return pstrData.get();
  }

  //<< 
  //<< 
  //<< PushData(pstrSender,strData)
  public Object PushData(Object ... _p) {
    mVar pstrSender = m$.newVarRef("pstrSender",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar strData = m$.newVarRef("strData",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; get the data from xml or delimitered string and save in into data container
    //<< ; The structure of data is : 1.String Delimitered
    //<< ;                            2.Xml
    //<< ;
    //<< ; Inputs :
    //<< ; pstrSender = Data Sender (to validate access)
    //<< ; strData = data file
    //<< ;
    //<< ; History :
    //<< ; 09-Apr-2009   shobby  SR16479: Reviewed 'newing' of variables.
    //<< ; 09-Apr-2009   shobby  SR16479: Changed to objDataReceive
    //<< ; 03-Nov-2008   shobby  BR014985: Call to AddDefaultKeys
    //<< ; 03-Nov-2008   shobby  BR014985:Quit when a rule is found
    //<< ; 22-Oct-2008   FIS     BR014985: Start Data from piece 10 (in delimitered string)
    //<< ;                           Save Action Type in Receive Header
    //<< ; 09-Jun-2008   CHINMAY Modified
    //<< ; 07-May-2008   CHINMAY created
    //<< ;----------------------------------------------------------------------------------
    //<< set $ztrap="DataError"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("DataError");
    //<< new strDelimiter,strDataExMsgKey,objDataExMsg,strMsgNo,strStatus,objMsgData,strValue,reader,SC
    mVar strDelimiter = m$.var("strDelimiter");
    mVar strDataExMsgKey = m$.var("strDataExMsgKey");
    mVar objDataExMsg = m$.var("objDataExMsg");
    mVar strMsgNo = m$.var("strMsgNo");
    mVar strStatus = m$.var("strStatus");
    mVar objMsgData = m$.var("objMsgData");
    mVar strValue = m$.var("strValue");
    mVar reader = m$.var("reader");
    mVar SC = m$.var("SC");
    m$.newVar(strDelimiter,strDataExMsgKey,objDataExMsg,strMsgNo,strStatus,objMsgData,strValue,reader,SC);
    //<< new objDataReceive,loop,strMsgPropDet,strActVal,idMsgProp,objMsgProp,idDataEx,objDataEx,idMsgType
    mVar objDataReceive = m$.var("objDataReceive");
    mVar loop = m$.var("loop");
    mVar strMsgPropDet = m$.var("strMsgPropDet");
    mVar strActVal = m$.var("strActVal");
    mVar idMsgProp = m$.var("idMsgProp");
    mVar objMsgProp = m$.var("objMsgProp");
    mVar idDataEx = m$.var("idDataEx");
    mVar objDataEx = m$.var("objDataEx");
    mVar idMsgType = m$.var("idMsgType");
    m$.newVar(objDataReceive,loop,strMsgPropDet,strActVal,idMsgProp,objMsgProp,idDataEx,objDataEx,idMsgType);
    //<< new idMapping,objMapping,strResolveClass,strRltnClass,strRltnClassObj,idResolve,objResolve,strPropName
    mVar idMapping = m$.var("idMapping");
    mVar objMapping = m$.var("objMapping");
    mVar strResolveClass = m$.var("strResolveClass");
    mVar strRltnClass = m$.var("strRltnClass");
    mVar strRltnClassObj = m$.var("strRltnClassObj");
    mVar idResolve = m$.var("idResolve");
    mVar objResolve = m$.var("objResolve");
    mVar strPropName = m$.var("strPropName");
    m$.newVar(idMapping,objMapping,strResolveClass,strRltnClass,strRltnClassObj,idResolve,objResolve,strPropName);
    //<< new blnAccess,idRule,objRuleset,errcode,strTemp,strMsgVal,strTempDelimiter,strMsgProp
    mVar blnAccess = m$.var("blnAccess");
    mVar idRule = m$.var("idRule");
    mVar objRuleset = m$.var("objRuleset");
    mVar errcode = m$.var("errcode");
    mVar strTemp = m$.var("strTemp");
    mVar strMsgVal = m$.var("strMsgVal");
    mVar strTempDelimiter = m$.var("strTempDelimiter");
    mVar strMsgProp = m$.var("strMsgProp");
    m$.newVar(blnAccess,idRule,objRuleset,errcode,strTemp,strMsgVal,strTempDelimiter,strMsgProp);
    //<< 
    //<< set strStatus = $$$NO
    strStatus.set(include.COMSYS.$$$NO(m$));
    //<< set errcode   = $$$NO
    errcode.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if ($get(strData) '= "") {
    if ((mOp.NotEqual(m$.Fnc.$get(strData),""))) {
      //<< set strTemp = $extract(strData,1,8)                         // extract the first character to check for the delimiter(if the value :- '<' , its a XML string
      strTemp.set(m$.Fnc.$extract(strData.get(),1,8));
      //<< 
      //<< //file type : Delimitered String
      //<< //------------------------------
      //<< if (strTemp '= "<Message") {
      if ((mOp.NotEqual(strTemp.get(),"<Message"))) {
        //<< set strDelimiter = $extract(strData,1)                  // Since the first character is a delimiter in Delimitered string
        strDelimiter.set(m$.Fnc.$extract(strData.get(),1));
        //<< set strMsgNo = $$^WWWNEXT("WWWDataExMsgNo")
        strMsgNo.set(m$.fnc$("WWWNEXT.main","WWWDataExMsgNo"));
        //<< 
        //<< set blnAccess = $$$NO
        blnAccess.set(include.COMSYS.$$$NO(m$));
        //<< set idRule    = ""
        idRule.set("");
        //<< for {
        for (;true;) {
          //<< set idRule = $order(^WWWDataExchange(0,idRule))
          idRule.set(m$.Fnc.$order(m$.var("^WWWDataExchange",0,idRule.get())));
          //<< quit:idRule=""
          if (mOp.Equal(idRule.get(),"")) {
            break;
          }
          //<< 
          //<< set objRuleset = $get(^WWWDataExchange(0,idRule,1))
          objRuleset.set(m$.Fnc.$get(m$.var("^WWWDataExchange",0,idRule.get(),1)));
          //<< if ($$$WWWDataExchangeRemoteSystem(objRuleset) = pstrSender)                     &&    //Sender
          //<< ($$$WWWDataExchangeMessageType(objRuleset) = $piece(strData,strDelimiter,2))  &&    //Message Type
          //<< ($$$WWWDataExchangeActsAs(objRuleset) = 1)                                       {  //Sender Is Master
          if ((mOp.Equal(include.WWWConst.$$$WWWDataExchangeRemoteSystem(m$,objRuleset),pstrSender.get())) && (mOp.Equal(include.WWWConst.$$$WWWDataExchangeMessageType(m$,objRuleset),m$.Fnc.$piece(strData.get(),strDelimiter.get(),2))) && (mOp.Equal(include.WWWConst.$$$WWWDataExchangeActsAs(m$,objRuleset),1))) {
            //<< set blnAccess = $$$YES
            blnAccess.set(include.COMSYS.$$$YES(m$));
            //<< quit
            break;
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if (blnAccess = $$$YES) {
        if ((mOp.Equal(blnAccess.get(),include.COMSYS.$$$YES(m$)))) {
          //<< set strData=$$AddDefaultKeys(strData,10) ;BR014985
          strData.set(m$.fnc$("AddDefaultKeys",strData.get(),10));
          //<< for loop=10:1:$LENGTH(strData,strDelimiter) {  //piece2=message type, piece3=messageid, piece4=action type, piece10-n:data  ;BR014985
          for (loop.set(10);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strData.get(),strDelimiter.get())));loop.set(mOp.Add(loop.get(),1))) {
            //<< set idMsgProp  = (loop-9)                 //(piece-9) = property id  ;BR014985
            idMsgProp.set((mOp.Subtract(loop.get(),9)));
            //<< set strMsgProp = $$$WWWDataExMessagePropTargetPropertyName($get(^WWWDataExMessageProp(0,$piece(strData,strDelimiter,2),(loop-9),1)))
            strMsgProp.set(include.WWWConst.$$$WWWDataExMessagePropTargetPropertyName(m$,m$.Fnc.$get(m$.var("^WWWDataExMessageProp",0,m$.Fnc.$piece(strData.get(),strDelimiter.get(),2),(mOp.Subtract(loop.get(),9)),1))));
            //<< if strMsgProp="" set strMsgProp = $$$WWWDataExMessagePropSourcePropertyName($get(^WWWDataExMessageProp(0,$piece(strData,strDelimiter,2),(loop-9),1)))
            if (mOp.Equal(strMsgProp.get(),"")) {
              strMsgProp.set(include.WWWConst.$$$WWWDataExMessagePropSourcePropertyName(m$,m$.Fnc.$get(m$.var("^WWWDataExMessageProp",0,m$.Fnc.$piece(strData.get(),strDelimiter.get(),2),(mOp.Subtract(loop.get(),9)),1))));
            }
            //<< set strActVal  = $piece(strData,strDelimiter,loop)    //   Value
            strActVal.set(m$.Fnc.$piece(strData.get(),strDelimiter.get(),loop.get()));
            //<< set strTempDelimiter=""        // Variable that holds the value of delimiter of multiple selects
            strTempDelimiter.set("");
            //<< if (strDelimiter '= ";") {
            if ((mOp.NotEqual(strDelimiter.get(),";"))) {
              //<< if ($length(strActVal,";") > 1) {
              if ((mOp.Greater(m$.Fnc.$length(strActVal.get(),";"),1))) {
                //<< set strTempDelimiter = $char(59)                  //Delimiter used in multiple select
                strTempDelimiter.set(m$.Fnc.$char(59));
                //<< set strActVal        = $piece(strActVal,"""",2)   //only 1st value
                strActVal.set(m$.Fnc.$piece(strActVal.get(),"\"",2));
              }
            }
            //<< }
            //<< } else {
            else {
              //<< if ($length(strActVal,"|") > 1) {
              if ((mOp.Greater(m$.Fnc.$length(strActVal.get(),"|"),1))) {
                //<< set strTempDelimiter = $char(124)                 //Delimiter used in memo field
                strTempDelimiter.set(m$.Fnc.$char(124));
                //<< set strActVal        = $piece(strActVal,"""",2)   //only 1st value
                strActVal.set(m$.Fnc.$piece(strActVal.get(),"\"",2));
              }
            }
            //<< }
            //<< }
            //<< 
            //<< set objMsgProp = $get(^WWWDataExMessageProp(0,$piece(strData,strDelimiter,2),idMsgProp,1))
            objMsgProp.set(m$.Fnc.$get(m$.var("^WWWDataExMessageProp",0,m$.Fnc.$piece(strData.get(),strDelimiter.get(),2),idMsgProp.get(),1)));
            //<< set strMsgVal = ""
            strMsgVal.set("");
            //<< 
            //<< if (objMsgProp '= "") {
            if ((mOp.NotEqual(objMsgProp.get(),""))) {
              //<< // check if mapping table property in WWWDataExMessageProp class is not empty
              //<< if ($$$WWWDataExMessagePropMappingTable(objMsgProp)'="") {
              if ((mOp.NotEqual(include.WWWConst.$$$WWWDataExMessagePropMappingTable(m$,objMsgProp),""))) {
                //<< set strMsgVal = $$UndoMappingClass(objMsgProp,strActVal)
                strMsgVal.set(m$.fnc$("UndoMappingClass",objMsgProp.get(),strActVal.get()));
              }
              //<< ;if strMsgVal'="" set strActVal = strMsgVal
              //<< }
              //<< 
              //<< // check if resolve relation class property in WWWDataExMessageProp class is not empty
              //<< if ($$$WWWDataExMessagePropResolveRelationClass(objMsgProp)'="") {
              if ((mOp.NotEqual(include.WWWConst.$$$WWWDataExMessagePropResolveRelationClass(m$,objMsgProp),""))) {
                //<< set strMsgVal = $$UnResolveRltnClass(objMsgProp,strTempDelimiter,strActVal)
                strMsgVal.set(m$.fnc$("UnResolveRltnClass",objMsgProp.get(),strTempDelimiter.get(),strActVal.get()));
              }
              //<< }
              //<< 
              //<< // if the data is not successfully mapped or resolved then set errcode to true
              //<< if (($$$WWWDataExMessagePropResolveRelationClass(objMsgProp)'="") ||
              //<< ($$$WWWDataExMessagePropMappingTable(objMsgProp)'=""))           {
              if (mOp.Logical(((mOp.NotEqual(include.WWWConst.$$$WWWDataExMessagePropResolveRelationClass(m$,objMsgProp),"")) || (mOp.NotEqual(include.WWWConst.$$$WWWDataExMessagePropMappingTable(m$,objMsgProp),""))))) {
                //<< if ($length(strActVal,strTempDelimiter) > 1) {   // check for multiple select value
                if ((mOp.Greater(m$.Fnc.$length(strActVal.get(),strTempDelimiter.get()),1))) {
                  //<< if ($length(strMsgVal,";") = $length(strActVal,strTempDelimiter)) {
                  if ((mOp.Equal(m$.Fnc.$length(strMsgVal.get(),";"),m$.Fnc.$length(strActVal.get(),strTempDelimiter.get())))) {
                    //<< set strActVal = strMsgVal
                    strActVal.set(strMsgVal.get());
                  }
                  //<< } else {
                  else {
                    //<< set errcode = $$$MakeStatus("Mapping or Resolve Relation Error")
                    errcode.set(include.COMSYS.$$$MakeStatus(m$,"Mapping or Resolve Relation Error"));
                  }
                }
                //<< }
                //<< } else {
                else {
                  //<< if (strMsgVal '= "") {          // check for single data value
                  if ((mOp.NotEqual(strMsgVal.get(),""))) {
                    //<< set strActVal = strMsgVal
                    strActVal.set(strMsgVal.get());
                  }
                  //<< } elseif (strActVal '="" ) {
                  else if ((mOp.NotEqual(strActVal.get(),""))) {
                    //<< set errcode = $$$MakeStatus("Mapping or Resolve Relation Error")
                    errcode.set(include.COMSYS.$$$MakeStatus(m$,"Mapping or Resolve Relation Error"));
                  }
                }
              }
            }
            //<< }  ; FIXME : Any else case to process? <GRF>
            //<< }
            //<< }
            //<< }
            //<< quit:errcode'=$$$NO
            if (mOp.NotEqual(errcode.get(),include.COMSYS.$$$NO(m$))) {
              break;
            }
            //<< //save the data in WWWDataExMessageData
            //<< set objMsgData = ""
            objMsgData.set("");
            //<< set $$$WWWDataExMessageDataValue1(objMsgData)=strActVal
            include.WWWConst.$$$WWWDataExMessageDataValue1Set(m$,objMsgData,strActVal.get());
            //<< set strStatus = $$$Save("WWWDataExMessageData",strMsgNo_","_strMsgProp,objMsgData)
            strStatus.set(include.COMSYS.$$$Save(m$,"WWWDataExMessageData",mOp.Concat(mOp.Concat(strMsgNo.get(),","),strMsgProp.get()),objMsgData));
          }
          //<< }
          //<< if (errcode = $$$NO) {
          if ((mOp.Equal(errcode.get(),include.COMSYS.$$$NO(m$)))) {
            //<< set objDataReceive = ""
            objDataReceive.set("");
            //<< set $$$WWWDataExMessageReceiveTimestampCreated(objDataReceive) = $horolog
            include.WWWConst.$$$WWWDataExMessageReceiveTimestampCreatedSet(m$,objDataReceive,m$.Fnc.$horolog());
            //<< set $$$WWWDataExMessageReceiveType(objDataReceive) = $piece(strData,strDelimiter,4)  ;Action Type ;BR014985
            include.WWWConst.$$$WWWDataExMessageReceiveTypeSet(m$,objDataReceive,m$.Fnc.$piece(strData.get(),strDelimiter.get(),4));
            //<< set $$$WWWDataExMessageReceiveMessageType(objDataReceive) = $piece(strData,strDelimiter,2)
            include.WWWConst.$$$WWWDataExMessageReceiveMessageTypeSet(m$,objDataReceive,m$.Fnc.$piece(strData.get(),strDelimiter.get(),2));
            //<< //Run through the WWWDataExchange to get the value of DataClass
            //<< set idDataEx=""
            idDataEx.set("");
            //<< for {
            for (;true;) {
              //<< set idDataEx=$order(^WWWDataExchange(0,idDataEx))
              idDataEx.set(m$.Fnc.$order(m$.var("^WWWDataExchange",0,idDataEx.get())));
              //<< quit:idDataEx=""
              if (mOp.Equal(idDataEx.get(),"")) {
                break;
              }
              //<< 
              //<< set objDataEx=$get(^WWWDataExchange(0,idDataEx,1))
              objDataEx.set(m$.Fnc.$get(m$.var("^WWWDataExchange",0,idDataEx.get(),1)));
              //<< if ($$$WWWDataExchangeRemoteSystem(objDataEx)=pstrSender)                    &&
              //<< ($$$WWWDataExchangeMessageType(objDataEx)=$piece(strData,strDelimiter,2))    {
              if ((mOp.Equal(include.WWWConst.$$$WWWDataExchangeRemoteSystem(m$,objDataEx),pstrSender.get())) && (mOp.Equal(include.WWWConst.$$$WWWDataExchangeMessageType(m$,objDataEx),m$.Fnc.$piece(strData.get(),strDelimiter.get(),2)))) {
                //<< set $$$WWWDataExMessageReceiveDataClass(objDataReceive)=$$$WWWDataExchangeDataClass(objDataEx)
                include.WWWConst.$$$WWWDataExMessageReceiveDataClassSet(m$,objDataReceive,include.WWWConst.$$$WWWDataExchangeDataClass(m$,objDataEx));
              }
            }
            //<< }
            //<< }
            //<< set strStatus = $$$Save("WWWDataExMessageReceive",pstrSender_","_strMsgNo,objDataReceive,$$$YES)
            strStatus.set(include.COMSYS.$$$Save(m$,"WWWDataExMessageReceive",mOp.Concat(mOp.Concat(pstrSender.get(),","),strMsgNo.get()),objDataReceive,include.COMSYS.$$$YES(m$)));
          }
          //<< } else {
          else {
            //<< // kill saved data from data Container
            //<< do ClearDataContainer(strMsgNo)
            m$.Cmd.Do("ClearDataContainer",strMsgNo.get());
          }
        }
        //<< }
        //<< } else {
        else {
          //<< set errcode = $$$MakeStatus("No Access")
          errcode.set(include.COMSYS.$$$MakeStatus(m$,"No Access"));
        }
      }
      //<< }
      //<< 
      //<< //file type : xml String
      //<< //------------------------------
      //<< } else {
      else {
        //<< set strValue=""
        strValue.set("");
        //<< set idMsgType=""
        idMsgType.set("");
        //<< set strActVal=""
        strActVal.set("");
        //<< set strDelimiter=" "
        strDelimiter.set(" ");
        //<< set strMsgNo = $$^WWWNEXT("WWWDataExMsgNo")     //generate the next sequence unique message no
        strMsgNo.set(m$.fnc$("WWWNEXT.main","WWWDataExMsgNo"));
        //<< // Create a new XML Reader class
        //<< set reader = ##class(%XML.Reader).%New()
        reader.set(m$.fnc$("$XML.Reader.$New"));
        //<< // Create an instance of %XML.TextReader
        //<< set SC = ##class(%XML.TextReader).ParseString(strData,.reader)
        SC.set(m$.fnc$("$XML.TextReader.ParseString",strData.get(),reader));
        //<< if $$$ISOK(SC) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,SC))) {
          //<< // Read all elements within the document
          //<< while (reader.Read()) {
          while (mOp.Logical((m$.fnc$(reader.getORef(),"Read")))) {
            //<< if (reader.NodeType = "element") {
            if ((mOp.Equal(m$.prop(reader.get(),"NodeType").get(),"element"))) {
              //<< set strValue = reader.Name                 //The target property name from data string
              strValue.set(m$.prop(reader.get(),"Name").get());
              //<< if (reader.MoveToAttributeName("Type")) {   //from the message node take out the type attribute
              if (mOp.Logical((m$.fnc$(reader.getORef(),"MoveToAttributeName","Type")))) {
                //<< set idMsgType=reader.Value
                idMsgType.set(m$.prop(reader.get(),"Value").get());
              }
            }
            //<< }
            //<< }
            //<< if (reader.NodeType = "chars") {
            if ((mOp.Equal(m$.prop(reader.get(),"NodeType").get(),"chars"))) {
              //<< // the the content between elements
              //<< if (strValue'="Message") {
              if ((mOp.NotEqual(strValue.get(),"Message"))) {
                //<< set strMsgVal   = ""
                strMsgVal.set("");
                //<< set strActVal   = reader.Value    // get the value from data string
                strActVal.set(m$.prop(reader.get(),"Value").get());
                //<< set strPropName = strValue
                strPropName.set(strValue.get());
                //<< if ($length(strActVal,";") > 1) {
                if ((mOp.Greater(m$.Fnc.$length(strActVal.get(),";"),1))) {
                  //<< set strActVal = $piece(strActVal,"""",2)
                  strActVal.set(m$.Fnc.$piece(strActVal.get(),"\"",2));
                }
                //<< }
                //<< set idMsgProp=""
                idMsgProp.set("");
                //<< for {
                for (;true;) {
                  //<< set idMsgProp = $order(^WWWDataExMessageProp(0,idMsgType,idMsgProp))
                  idMsgProp.set(m$.Fnc.$order(m$.var("^WWWDataExMessageProp",0,idMsgType.get(),idMsgProp.get())));
                  //<< quit:idMsgProp=""
                  if (mOp.Equal(idMsgProp.get(),"")) {
                    break;
                  }
                  //<< 
                  //<< set objMsgProp = $get(^WWWDataExMessageProp(0,idMsgType,idMsgProp,1))
                  objMsgProp.set(m$.Fnc.$get(m$.var("^WWWDataExMessageProp",0,idMsgType.get(),idMsgProp.get(),1)));
                  //<< 
                  //<< 
                  //<< //If Targetproperty name is blank then  the value is set to SourceProperty Name
                  //<< if ($$$WWWDataExMessagePropTargetPropertyName(objMsgProp)="") {
                  if ((mOp.Equal(include.WWWConst.$$$WWWDataExMessagePropTargetPropertyName(m$,objMsgProp),""))) {
                    //<< set $$$WWWDataExMessagePropTargetPropertyName(objMsgProp)=$$$WWWDataExMessagePropSourcePropertyName(objMsgProp)
                    include.WWWConst.$$$WWWDataExMessagePropTargetPropertyNameSet(m$,objMsgProp,include.WWWConst.$$$WWWDataExMessagePropSourcePropertyName(m$,objMsgProp));
                  }
                  //<< }
                  //<< //check if the target property name equals to the property name contained in data string
                  //<< if ($$$WWWDataExMessagePropTargetPropertyName(objMsgProp)=strPropName) {
                  if ((mOp.Equal(include.WWWConst.$$$WWWDataExMessagePropTargetPropertyName(m$,objMsgProp),strPropName.get()))) {
                    //<< // check if mapping table property in WWWDataExMessageProp class is not empty
                    //<< if ($$$WWWDataExMessagePropMappingTable(objMsgProp)'="") {
                    if ((mOp.NotEqual(include.WWWConst.$$$WWWDataExMessagePropMappingTable(m$,objMsgProp),""))) {
                      //<< set strMsgVal = $$UndoMappingClass(objMsgProp,strActVal)
                      strMsgVal.set(m$.fnc$("UndoMappingClass",objMsgProp.get(),strActVal.get()));
                      //<< if strMsgVal'="" set strActVal = strMsgVal
                      if (mOp.NotEqual(strMsgVal.get(),"")) {
                        strActVal.set(strMsgVal.get());
                      }
                    }
                    //<< }
                    //<< // check if resolve relation class property in WWWDataExMessageProp class is not empty
                    //<< if ($$$WWWDataExMessagePropResolveRelationClass(objMsgProp)'="") {
                    if ((mOp.NotEqual(include.WWWConst.$$$WWWDataExMessagePropResolveRelationClass(m$,objMsgProp),""))) {
                      //<< set strMsgVal = $$UnResolveRltnClass(objMsgProp,";",strActVal)
                      strMsgVal.set(m$.fnc$("UnResolveRltnClass",objMsgProp.get(),";",strActVal.get()));
                    }
                    //<< }
                    //<< // if the data is successfully mapped or resolved then set errcode to true
                    //<< if (($$$WWWDataExMessagePropResolveRelationClass(objMsgProp)'="") || ($$$WWWDataExMessagePropMappingTable(objMsgProp)'="")) {
                    if (mOp.Logical(((mOp.NotEqual(include.WWWConst.$$$WWWDataExMessagePropResolveRelationClass(m$,objMsgProp),"")) || (mOp.NotEqual(include.WWWConst.$$$WWWDataExMessagePropMappingTable(m$,objMsgProp),""))))) {
                      //<< if ($length(strActVal,";") > 1) {   // check for multiple select value
                      if ((mOp.Greater(m$.Fnc.$length(strActVal.get(),";"),1))) {
                        //<< if ($length(strMsgVal,";") = $length(strActVal,";")) {
                        if ((mOp.Equal(m$.Fnc.$length(strMsgVal.get(),";"),m$.Fnc.$length(strActVal.get(),";")))) {
                          //<< set strActVal = strMsgVal
                          strActVal.set(strMsgVal.get());
                          //<< set errcode = $$$YES
                          errcode.set(include.COMSYS.$$$YES(m$));
                        }
                        //<< } else {
                        else {
                          //<< set errcode = $$$NO
                          errcode.set(include.COMSYS.$$$NO(m$));
                          //<< quit
                          break;
                        }
                      }
                      //<< }
                      //<< } else {
                      else {
                        //<< if (strMsgVal '= "") {          // check for single data value
                        if ((mOp.NotEqual(strMsgVal.get(),""))) {
                          //<< set strActVal = strMsgVal
                          strActVal.set(strMsgVal.get());
                          //<< set errcode = $$$YES
                          errcode.set(include.COMSYS.$$$YES(m$));
                        }
                        //<< } elseif(strActVal '= "") {
                        else if ((mOp.NotEqual(strActVal.get(),""))) {
                          //<< set errcode = $$$NO
                          errcode.set(include.COMSYS.$$$NO(m$));
                          //<< quit
                          break;
                        }
                      }
                    }
                  }
                }
                //<< }
                //<< }
                //<< }
                //<< }
                //<< }
                //<< quit:errcode=0
                if (mOp.Equal(errcode.get(),0)) {
                  break;
                }
                //<< //save the data in WWWDataExMessageData
                //<< set objMsgData = ""
                objMsgData.set("");
                //<< set $$$WWWDataExMessageDataValue1(objMsgData)=strActVal
                include.WWWConst.$$$WWWDataExMessageDataValue1Set(m$,objMsgData,strActVal.get());
                //<< set strStatus = $$$Save("WWWDataExMessageData",strMsgNo_","_strValue,objMsgData)
                strStatus.set(include.COMSYS.$$$Save(m$,"WWWDataExMessageData",mOp.Concat(mOp.Concat(strMsgNo.get(),","),strValue.get()),objMsgData));
              }
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< }
        //<< if (strStatus) {
        if (mOp.Logical((strStatus.get()))) {
          //<< // save data information in WWWDataExMessageReceive
          //<< set objDataReceive = ""
          objDataReceive.set("");
          //<< set $$$WWWDataExMessageReceiveTimestampCreated(objDataReceive) = $horolog
          include.WWWConst.$$$WWWDataExMessageReceiveTimestampCreatedSet(m$,objDataReceive,m$.Fnc.$horolog());
          //<< set $$$WWWDataExMessageReceiveMessageType(objDataReceive)      = idMsgType
          include.WWWConst.$$$WWWDataExMessageReceiveMessageTypeSet(m$,objDataReceive,idMsgType.get());
          //<< set idDataEx=""
          idDataEx.set("");
          //<< for {
          for (;true;) {
            //<< set idDataEx=$order(^WWWDataExchange(0,idDataEx))
            idDataEx.set(m$.Fnc.$order(m$.var("^WWWDataExchange",0,idDataEx.get())));
            //<< quit:idDataEx=""
            if (mOp.Equal(idDataEx.get(),"")) {
              break;
            }
            //<< set objDataEx=$get(^WWWDataExchange(0,idDataEx,1))
            objDataEx.set(m$.Fnc.$get(m$.var("^WWWDataExchange",0,idDataEx.get(),1)));
            //<< if ($$$WWWDataExchangeRemoteSystem(objDataEx)=pstrSender)         &&
            //<< ($$$WWWDataExchangeMessageType(objDataEx)=$piece(strData,Y,1))    {
            if ((mOp.Equal(include.WWWConst.$$$WWWDataExchangeRemoteSystem(m$,objDataEx),pstrSender.get())) && (mOp.Equal(include.WWWConst.$$$WWWDataExchangeMessageType(m$,objDataEx),m$.Fnc.$piece(strData.get(),m$.var("Y").get(),1)))) {
              //<< set $$$WWWDataExMessageReceiveDataClass(objDataReceive) = $$$WWWDataExchangeDataClass(objDataEx)
              include.WWWConst.$$$WWWDataExMessageReceiveDataClassSet(m$,objDataReceive,include.WWWConst.$$$WWWDataExchangeDataClass(m$,objDataEx));
            }
          }
          //<< }
          //<< }
          //<< set strStatus = $$$Save("WWWDataExMessageReceive",pstrSender_","_strMsgNo,objDataReceive,$$$YES)
          strStatus.set(include.COMSYS.$$$Save(m$,"WWWDataExMessageReceive",mOp.Concat(mOp.Concat(pstrSender.get(),","),strMsgNo.get()),objDataReceive,include.COMSYS.$$$YES(m$)));
        }
        //<< } else {
        else {
          //<< // kill saved data from data Container
          //<< do ClearDataContainer(strMsgNo)
          m$.Cmd.Do("ClearDataContainer",strMsgNo.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< if (errcode = $$$NO) quit 1
    if ((mOp.Equal(errcode.get(),include.COMSYS.$$$NO(m$)))) {
      return 1;
    }
    //<< quit errcode
    return errcode.get();
  }

  //<< 
  //<< DataError()
  public Object DataError(Object ... _p) {
    //<< set $zerror=" "
    mVar $zerror = m$.var("$zerror");
    $zerror.set(" ");
    //<< quit $$$MakeStatus("Internal Error")
    return include.COMSYS.$$$MakeStatus(m$,"Internal Error");
  }

  //<< 
  //<< 
  //<< DoMappingClass(pidMappingTable,pstrValue,pintDirection=1)
  public Object DoMappingClass(Object ... _p) {
    mVar pidMappingTable = m$.newVarRef("pidMappingTable",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintDirection = m$.newVarRef("pintDirection",(((_p!=null)&&(_p.length>=3))?_p[2]:null),1);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Translates fields based on mapping setups
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Feb-2009   shobby  SR16126: Don't try and translate if the string is empty.
    //<< ; 20-Nov-2008   shobby  SR16126: Rewrote to handle both directions
    //<< ; 07-Nov-2008   shobby  SRBR014985: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objMapping,idSourceValue,intAsciiCode,strText
    mVar objMapping = m$.var("objMapping");
    mVar idSourceValue = m$.var("idSourceValue");
    mVar intAsciiCode = m$.var("intAsciiCode");
    mVar strText = m$.var("strText");
    m$.newVar(objMapping,idSourceValue,intAsciiCode,strText);
    //<< 
    //<< if pstrValue'="" {
    if (mOp.NotEqual(pstrValue.get(),"")) {
      //<< if (pidMappingTable'="") {
      if ((mOp.NotEqual(pidMappingTable.get(),""))) {
        //<< set objMapping = $get(^WWWDataExDataMapping(0,pidMappingTable,pstrValue,1))
        objMapping.set(m$.Fnc.$get(m$.var("^WWWDataExDataMapping",0,pidMappingTable.get(),pstrValue.get(),1)));
        //<< if (objMapping'="") {
        if ((mOp.NotEqual(objMapping.get(),""))) {
          //<< set pstrValue=$$$WWWDataExDataMappingTargetValue(objMapping)
          pstrValue.set(include.WWWConst.$$$WWWDataExDataMappingTargetValue(m$,objMapping));
        }
        //<< } else {
        else {
          //<< set idSourceValue=""
          idSourceValue.set("");
          //<< for {
          for (;true;) {
            //<< set idSourceValue=$order(^WWWDataExDataMapping(0,pidMappingTable,idSourceValue))
            idSourceValue.set(m$.Fnc.$order(m$.var("^WWWDataExDataMapping",0,pidMappingTable.get(),idSourceValue.get())));
            //<< quit:idSourceValue=""
            if (mOp.Equal(idSourceValue.get(),"")) {
              break;
            }
            //<< set intAsciiCode(pintDirection) =$$ConvertAsciiCode(idSourceValue)
            intAsciiCode.var(pintDirection.get()).set(m$.fnc$("ConvertAsciiCode",idSourceValue.get()));
            //<< set objMapping = $get(^WWWDataExDataMapping(0,pidMappingTable,idSourceValue,1))
            objMapping.set(m$.Fnc.$get(m$.var("^WWWDataExDataMapping",0,pidMappingTable.get(),idSourceValue.get(),1)));
            //<< set intAsciiCode('pintDirection)=$$ConvertAsciiCode($$$WWWDataExDataMappingTargetValue(objMapping))
            intAsciiCode.var(mOp.Not(pintDirection.get())).set(m$.fnc$("ConvertAsciiCode",include.WWWConst.$$$WWWDataExDataMappingTargetValue(m$,objMapping)));
            //<< set pstrValue=$$FullReplace^COMUtilStr(pstrValue,intAsciiCode(1),intAsciiCode(0))
            pstrValue.set(m$.fnc$("COMUtilStr.FullReplace",pstrValue.get(),intAsciiCode.var(1).get(),intAsciiCode.var(0).get()));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit pstrValue
    return pstrValue.get();
  }

  //<< 
  //<< 
  //<< UndoMappingClass(pobjMsgProp,pstrActVal)
  public Object UndoMappingClass(Object ... _p) {
    mVar pobjMsgProp = m$.newVarRef("pobjMsgProp",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrActVal = m$.newVarRef("pstrActVal",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; undo mapping class
    //<< ;
    //<< ; Inputs :
    //<< ; pobjMsgProp = WWWDataExMessageProp class object
    //<< ; pstrActVal = Data Value
    //<< ;
    //<< ; History :
    //<< ; 09-June-2008       CHINMAY       created
    //<< ;----------------------------------------------------------------------------------
    //<< quit $$DoMappingClass($$$WWWDataExMessagePropMappingTable(pobjMsgProp),pstrActVal,0)
    return m$.fnc$("DoMappingClass",include.WWWConst.$$$WWWDataExMessagePropMappingTable(m$,pobjMsgProp),pstrActVal.get(),0);
  }

  //<< 
  //<< 
  //<< UnResolveRltnClass(pobjMsgProp,pstrDelimiter,pstrMsgVal)
  public Object UnResolveRltnClass(Object ... _p) {
    mVar pobjMsgProp = m$.newVarRef("pobjMsgProp",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrDelimiter = m$.newVarRef("pstrDelimiter",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrMsgVal = m$.newVarRef("pstrMsgVal",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; undo resolving of relation class . Used in the PushData routine.
    //<< ;
    //<< ; Inputs :
    //<< ; pobjMsgProp   = WWWDataExMessageProp class object
    //<< ; pstrDelimiter = Delimiter
    //<< ; pstrMsgVal    = data value
    //<< ;
    //<< ; History :
    //<< ; 09-Jun-2008   CHINMAY created
    //<< ;----------------------------------------------------------------------------------
    //<< new strResolveClass,strResRltnClsDisplay,strMsgVal,strTempVal,strMultiVal,strVal,strRltnClass,count,strRltnClassObj
    mVar strResolveClass = m$.var("strResolveClass");
    mVar strResRltnClsDisplay = m$.var("strResRltnClsDisplay");
    mVar strMsgVal = m$.var("strMsgVal");
    mVar strTempVal = m$.var("strTempVal");
    mVar strMultiVal = m$.var("strMultiVal");
    mVar strVal = m$.var("strVal");
    mVar strRltnClass = m$.var("strRltnClass");
    mVar count = m$.var("count");
    mVar strRltnClassObj = m$.var("strRltnClassObj");
    m$.newVar(strResolveClass,strResRltnClsDisplay,strMsgVal,strTempVal,strMultiVal,strVal,strRltnClass,count,strRltnClassObj);
    //<< 
    //<< set strResRltnClsDisplay = $$$WWWDataExMessagePropResolveRelationalDisplayF(pobjMsgProp)
    strResRltnClsDisplay.set(include.WWWConst.$$$WWWDataExMessagePropResolveRelationalDisplayF(m$,pobjMsgProp));
    //<< set strMsgVal = pstrMsgVal
    strMsgVal.set(pstrMsgVal.get());
    //<< set strVal = ""
    strVal.set("");
    //<< // check if resolve relation class property in WWWDataExMessageProp class is not empty
    //<< if ($$$WWWDataExMessagePropResolveRelationClass(pobjMsgProp)'="") {
    if ((mOp.NotEqual(include.WWWConst.$$$WWWDataExMessagePropResolveRelationClass(m$,pobjMsgProp),""))) {
      //<< set strResolveClass = "^"_$$$WWWDataExMessagePropResolveRelationClass(pobjMsgProp)
      strResolveClass.set(mOp.Concat("^",include.WWWConst.$$$WWWDataExMessagePropResolveRelationClass(m$,pobjMsgProp)));
      //<< //  if primarykey property in WWWDataExMessageProp class is present
      //<< if ($$$WWWDataExMessagePropResolveRelationalPrimaryK(pobjMsgProp) '= "") {
      if ((mOp.NotEqual(include.WWWConst.$$$WWWDataExMessagePropResolveRelationalPrimaryK(m$,pobjMsgProp),""))) {
        //<< set strRltnClass    = strResolveClass_"("""_YM_""","_$$$WWWDataExMessagePropResolveRelationalPrimaryK(pobjMsgProp)_",idResolve)"
        strRltnClass.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strResolveClass.get(),"(\""),m$.var("YM").get()),"\","),include.WWWConst.$$$WWWDataExMessagePropResolveRelationalPrimaryK(m$,pobjMsgProp)),",idResolve)"));
        //<< set strRltnClassObj = strResolveClass_"("""_YM_""","_$$$WWWDataExMessagePropResolveRelationalPrimaryK(pobjMsgProp)_",idResolve,1)"
        strRltnClassObj.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strResolveClass.get(),"(\""),m$.var("YM").get()),"\","),include.WWWConst.$$$WWWDataExMessagePropResolveRelationalPrimaryK(m$,pobjMsgProp)),",idResolve,1)"));
        //<< //  if contains data for multiple select field or not
        //<< if ($length(strMsgVal,pstrDelimiter) > 1) {
        if ((mOp.Greater(m$.Fnc.$length(strMsgVal.get(),pstrDelimiter.get()),1))) {
          //<< set strMultiVal=""
          strMultiVal.set("");
          //<< // run through the individual values in the multiple select msg value to pick its respective Id
          //<< for count=1:1:$length(strMsgVal,pstrDelimiter) {
          for (count.set(1);(mOp.LessOrEqual(count.get(),m$.Fnc.$length(strMsgVal.get(),pstrDelimiter.get())));count.set(mOp.Add(count.get(),1))) {
            //<< set strTempVal = ""
            strTempVal.set("");
            //<< set strTempVal = $$ResolveWithPKey(strRltnClass,strRltnClassObj,$piece(strMsgVal,pstrDelimiter,count),strResRltnClsDisplay)
            strTempVal.set(m$.fnc$("ResolveWithPKey",strRltnClass.get(),strRltnClassObj.get(),m$.Fnc.$piece(strMsgVal.get(),pstrDelimiter.get(),count.get()),strResRltnClsDisplay.get()));
            //<< // to build the actual multiple select msg value
            //<< if (strMultiVal = "") {
            if ((mOp.Equal(strMultiVal.get(),""))) {
              //<< set strMultiVal = strTempVal
              strMultiVal.set(strTempVal.get());
            }
            //<< } else {
            else {
              //<< if (strTempVal'="") {
              if ((mOp.NotEqual(strTempVal.get(),""))) {
                //<< set strMultiVal = strMultiVal_";"_strTempVal
                strMultiVal.set(mOp.Concat(mOp.Concat(strMultiVal.get(),";"),strTempVal.get()));
              }
            }
          }
          //<< }
          //<< }
          //<< }
          //<< // assign it to actual value variable
          //<< set strVal = strMultiVal
          strVal.set(strMultiVal.get());
        }
        //<< 
        //<< // if the value is for single select field
        //<< } else {
        else {
          //<< // assign it to actual value variable
          //<< set strVal = $$ResolveWithPKey(strRltnClass,strRltnClassObj,strMsgVal,strResRltnClsDisplay)
          strVal.set(m$.fnc$("ResolveWithPKey",strRltnClass.get(),strRltnClassObj.get(),strMsgVal.get(),strResRltnClsDisplay.get()));
        }
      }
      //<< }
      //<< 
      //<< } else {     // if primary key not present for relation class
      else {
        //<< 
        //<< // if the value is for multiple select field
        //<< if ($length(strMsgVal,pstrDelimiter) > 1) {
        if ((mOp.Greater(m$.Fnc.$length(strMsgVal.get(),pstrDelimiter.get()),1))) {
          //<< set strMultiVal = ""
          strMultiVal.set("");
          //<< for count=1:1:$length(strMsgVal,pstrDelimiter) {
          for (count.set(1);(mOp.LessOrEqual(count.get(),m$.Fnc.$length(strMsgVal.get(),pstrDelimiter.get())));count.set(mOp.Add(count.get(),1))) {
            //<< set strTempVal = ""
            strTempVal.set("");
            //<< set strTempVal = $$ResolveWithoutPKey(strResolveClass,$piece(strMsgVal,pstrDelimiter,count),strResRltnClsDisplay)
            strTempVal.set(m$.fnc$("ResolveWithoutPKey",strResolveClass.get(),m$.Fnc.$piece(strMsgVal.get(),pstrDelimiter.get(),count.get()),strResRltnClsDisplay.get()));
            //<< // to build the actual multiple select msg value
            //<< if (strMultiVal = "") {
            if ((mOp.Equal(strMultiVal.get(),""))) {
              //<< set strMultiVal = strTempVal
              strMultiVal.set(strTempVal.get());
            }
            //<< } else {
            else {
              //<< set strMultiVal = strMultiVal_";"_strTempVal
              strMultiVal.set(mOp.Concat(mOp.Concat(strMultiVal.get(),";"),strTempVal.get()));
            }
          }
          //<< }
          //<< }
          //<< // assign it to actual value variable
          //<< set strVal = strMultiVal
          strVal.set(strMultiVal.get());
        }
        //<< 
        //<< } else {   // if the value is for single select field
        else {
          //<< set strVal = $$ResolveWithoutPKey(strResolveClass,strMsgVal,strResRltnClsDisplay)
          strVal.set(m$.fnc$("ResolveWithoutPKey",strResolveClass.get(),strMsgVal.get(),strResRltnClsDisplay.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strVal
    return strVal.get();
  }

  //<< 
  //<< ResolveWithoutPKey(pstrResolveClass,pstrMsgVal,pstrResRltnClsDisplay)
  public Object ResolveWithoutPKey(Object ... _p) {
    mVar pstrResolveClass = m$.newVarRef("pstrResolveClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrMsgVal = m$.newVarRef("pstrMsgVal",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrResRltnClsDisplay = m$.newVarRef("pstrResRltnClsDisplay",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; resolve relation class without primary key. Used in the UnResolveRltnClass routine.
    //<< ;
    //<< ; Inputs :
    //<< ; pstrResolveClass = Relation Class Name
    //<< ; pstrMsgVal = data value
    //<< ; pstrResRltnClsDisplay = Relation class display field
    //<< ;
    //<< ; History :
    //<< ; 09-Apr-2009   shobby  SR16479: Reviewed 'newing' of variables.
    //<< ; 09-Jun-2008   CHINMAY created
    //<< ;----------------------------------------------------------------------------------
    //<< new strTempVal,idResolve,objResolve
    mVar strTempVal = m$.var("strTempVal");
    mVar idResolve = m$.var("idResolve");
    mVar objResolve = m$.var("objResolve");
    m$.newVar(strTempVal,idResolve,objResolve);
    //<< 
    //<< set strTempVal=""
    strTempVal.set("");
    //<< set idResolve=""
    idResolve.set("");
    //<< for {
    for (;true;) {
      //<< set idResolve=$order(@pstrResolveClass@(0,idResolve))
      idResolve.set(m$.Fnc.$order(m$.indirectVar(pstrResolveClass.get()).var(0,idResolve.get())));
      //<< quit:idResolve=""
      if (mOp.Equal(idResolve.get(),"")) {
        break;
      }
      //<< 
      //<< set objResolve=$get(@pstrResolveClass@(0,idResolve,1))
      objResolve.set(m$.Fnc.$get(m$.indirectVar(pstrResolveClass.get()).var(0,idResolve.get(),1)));
      //<< // if the value in the data string is same as the value in the relation class object
      //<< if (pstrMsgVal=$piece(objResolve,Y,pstrResRltnClsDisplay)) {
      if ((mOp.Equal(pstrMsgVal.get(),m$.Fnc.$piece(objResolve.get(),m$.var("Y").get(),pstrResRltnClsDisplay.get())))) {
        //<< set strTempVal=idResolve
        strTempVal.set(idResolve.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strTempVal
    return strTempVal.get();
  }

  //<< 
  //<< ResolveWithPKey(pstrResolveClass,pstrResolveClassObj,pstrMsgVal,pstrResRltnClsDisplay)
  public Object ResolveWithPKey(Object ... _p) {
    mVar pstrResolveClass = m$.newVarRef("pstrResolveClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrResolveClassObj = m$.newVarRef("pstrResolveClassObj",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrMsgVal = m$.newVarRef("pstrMsgVal",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrResRltnClsDisplay = m$.newVarRef("pstrResRltnClsDisplay",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; resolve relation class with primary key. Used in the UnResolveRltnClass routine.
    //<< ;
    //<< ; Inputs :
    //<< ; pstrResolveClass      = Relation Class Name for using in $order
    //<< ; pstrResolveClassObj   = Relation class Name for getting the object
    //<< ; pstrMsgVal            = data value
    //<< ; pstrResRltnClsDisplay = Relation class display field
    //<< ;
    //<< ; History :
    //<< ; 09-Apr-2009   shobby  SR16479: Reviewed 'newing' of variables.
    //<< ; 09-Jun-2008   CHINMAY created
    //<< ;----------------------------------------------------------------------------------
    //<< new idResolve,objResolve,strTempVal
    mVar idResolve = m$.var("idResolve");
    mVar objResolve = m$.var("objResolve");
    mVar strTempVal = m$.var("strTempVal");
    m$.newVar(idResolve,objResolve,strTempVal);
    //<< 
    //<< set strTempVal=""
    strTempVal.set("");
    //<< set idResolve=""
    idResolve.set("");
    //<< for {
    for (;true;) {
      //<< set idResolve=$order(@pstrResolveClass)
      idResolve.set(m$.Fnc.$order(m$.indirectVar(pstrResolveClass.get())));
      //<< quit:idResolve=""
      if (mOp.Equal(idResolve.get(),"")) {
        break;
      }
      //<< 
      //<< set objResolve = $get(@pstrResolveClassObj)
      objResolve.set(m$.Fnc.$get(m$.indirectVar(pstrResolveClassObj.get())));
      //<< // if the value in the data string is same as the value in the relation class object
      //<< if (pstrMsgVal=$piece(objResolve,Y,pstrResRltnClsDisplay)) {
      if ((mOp.Equal(pstrMsgVal.get(),m$.Fnc.$piece(objResolve.get(),m$.var("Y").get(),pstrResRltnClsDisplay.get())))) {
        //<< set strTempVal = idResolve
        strTempVal.set(idResolve.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strTempVal
    return strTempVal.get();
  }

  //<< 
  //<< Access(pintRule,pObjRule)
  public Object Access(Object ... _p) {
    mVar pintRule = m$.newVarRef("pintRule",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pObjRule = m$.newVarRef("pObjRule",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ; To grant access for a slave to become a master and vice versa temporarily .
    //<< ;
    //<< ; Inputs :
    //<< ; pintRule = rule Id
    //<< ;
    //<< ; History :
    //<< ; 27-June-2008  VIJAY   Modified
    //<< ; 05-June-2008  KALYAN  created
    //<< ;----------------------------------------------------------------------------------
    //<< new errcode,intDifference,intTimeStamp,strStatus
    mVar errcode = m$.var("errcode");
    mVar intDifference = m$.var("intDifference");
    mVar intTimeStamp = m$.var("intTimeStamp");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(errcode,intDifference,intTimeStamp,strStatus);
    //<< 
    //<< set errcode = $$$YES
    errcode.set(include.COMSYS.$$$YES(m$));
    //<< quit:($$$WWWDataExchangeTimeStampCreated(pObjRule)="") $$$NO
    if ((mOp.Equal(include.WWWConst.$$$WWWDataExchangeTimeStampCreated(m$,pObjRule),""))) {
      return include.COMSYS.$$$NO(m$);
    }
    //<< 
    //<< set intTimeStamp  = $$$WWWDataExchangeTimeStampCreated(pObjRule)
    intTimeStamp.set(include.WWWConst.$$$WWWDataExchangeTimeStampCreated(m$,pObjRule));
    //<< set intDifference = $$DateDiff^COMUtilDate(intTimeStamp,$horolog)
    intDifference.set(m$.fnc$("COMUtilDate.DateDiff",intTimeStamp.get(),m$.Fnc.$horolog()));
    //<< if (($$$WWWDataExchangeAccessTime(pObjRule))>intDifference) {   ;time period in seconds
    if ((mOp.Greater((include.WWWConst.$$$WWWDataExchangeAccessTime(m$,pObjRule)),intDifference.get()))) {
      //<< if ($$$WWWDataExchangeActsAs(pObjRule)=1) set errcode = $$$YES
      if ((mOp.Equal(include.WWWConst.$$$WWWDataExchangeActsAs(m$,pObjRule),1))) {
        errcode.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< 
    //<< } else {
    else {
      //<< set $$$WWWDataExchangeTimeStampCreated(pObjRule) = ""
      include.WWWConst.$$$WWWDataExchangeTimeStampCreatedSet(m$,pObjRule,"");
      //<< set $$$WWWDataExchangeAccessTime(pObjRule)       = ""
      include.WWWConst.$$$WWWDataExchangeAccessTimeSet(m$,pObjRule,"");
      //<< set $$$WWWDataExchangeActsAs(pObjRule)           = 0  ;always Slave '$$$WWWDataExchangeActsAs(pObjRule)
      include.WWWConst.$$$WWWDataExchangeActsAsSet(m$,pObjRule,0);
      //<< set strStatus = $$$Save("WWWDataExchange",pintRule,pObjRule,$$$YES)
      strStatus.set(include.COMSYS.$$$Save(m$,"WWWDataExchange",pintRule,pObjRule,include.COMSYS.$$$YES(m$)));
      //<< set errcode   = $$$NO
      errcode.set(include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< quit errcode
    return errcode.get();
  }

  //<< 
  //<< 
  //<< ChangeAccessRights(pstrSender,pstrRuleId,pintAccessPeriod)
  public Object ChangeAccessRights(Object ... _p) {
    mVar pstrSender = m$.newVarRef("pstrSender",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrRuleId = m$.newVarRef("pstrRuleId",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintAccessPeriod = m$.newVarRef("pintAccessPeriod",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets the Rule Id and Changes The Access Rights of the Remote System from Master to Client or Vice versa
    //<< ;
    //<< ; This will be called from Webservice "alWEB.WS.DataExchange.cls"
    //<< ;
    //<< ; Params:
    //<< ; pstrSender = Sending Remote System
    //<< ; pstrRuleId = RuleId from "WWWDataExchange"to which the Remote system Wants the access to be changed
    //<< ; pintAccessPeriod = Period for which a Remote System will Change its Access Rights
    //<< ;
    //<< ; History:
    //<< ; 27-Jun-2008   VIJAY   Modified
    //<< ; 05-Jun-2008   VIJAY   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objDataExchange,strStatus
    mVar objDataExchange = m$.var("objDataExchange");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objDataExchange,strStatus);
    //<< 
    //<< set strStatus = 0
    strStatus.set(0);
    //<< if ($get(pstrRuleId) '= "") && ($get(pintAccessPeriod) '= "") {
    if ((mOp.NotEqual(m$.Fnc.$get(pstrRuleId),"")) && (mOp.NotEqual(m$.Fnc.$get(pintAccessPeriod),""))) {
      //<< set objDataExchange = $get(^WWWDataExchange(0,pstrRuleId,1))
      objDataExchange.set(m$.Fnc.$get(m$.var("^WWWDataExchange",0,pstrRuleId.get(),1)));
      //<< if (objDataExchange '="") {
      if ((mOp.NotEqual(objDataExchange.get(),""))) {
        //<< if (pintAccessPeriod '= 0) {
        if ((mOp.NotEqual(pintAccessPeriod.get(),0))) {
          //<< set $$$WWWDataExchangeTimeStampCreated(objDataExchange) = $horolog
          include.WWWConst.$$$WWWDataExchangeTimeStampCreatedSet(m$,objDataExchange,m$.Fnc.$horolog());
          //<< set $$$WWWDataExchangeAccessTime(objDataExchange)       = pintAccessPeriod
          include.WWWConst.$$$WWWDataExchangeAccessTimeSet(m$,objDataExchange,pintAccessPeriod.get());
          //<< set $$$WWWDataExchangeActsAs(objDataExchange)           = 1  //always Master '$$$WWWDataExchangeActsAs(objDataExchange)
          include.WWWConst.$$$WWWDataExchangeActsAsSet(m$,objDataExchange,1);
        }
        //<< 
        //<< } else {
        else {
          //<< set $$$WWWDataExchangeTimeStampCreated(objDataExchange) = ""
          include.WWWConst.$$$WWWDataExchangeTimeStampCreatedSet(m$,objDataExchange,"");
          //<< set $$$WWWDataExchangeAccessTime(objDataExchange)       = ""
          include.WWWConst.$$$WWWDataExchangeAccessTimeSet(m$,objDataExchange,"");
          //<< set $$$WWWDataExchangeActsAs(objDataExchange)           = 0  //always Slave '$$$WWWDataExchangeActsAs(objDataExchange)
          include.WWWConst.$$$WWWDataExchangeActsAsSet(m$,objDataExchange,0);
        }
      }
      //<< }
      //<< }
      //<< set strStatus = $$$Save("WWWDataExchange",pstrRuleId,objDataExchange,$$$YES)
      strStatus.set(include.COMSYS.$$$Save(m$,"WWWDataExchange",pstrRuleId,objDataExchange,include.COMSYS.$$$YES(m$)));
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< ClearMessages()
  public Object ClearMessages(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Clear out the message queues
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Nov-2008   shobby  SRBR014985: Created
    //<< ;-------------------------------------------------------------------------------
    //<< kill ^WWWDataExMessageSend
    m$.var("^WWWDataExMessageSend").kill();
    //<< kill ^WWWDataExMessageSends
    m$.var("^WWWDataExMessageSends").kill();
    //<< kill ^WWWDataExMessageReceive
    m$.var("^WWWDataExMessageReceive").kill();
    //<< kill ^WWWDataExMessageReceives
    m$.var("^WWWDataExMessageReceives").kill();
    //<< kill ^WWWDataExMessageData
    m$.var("^WWWDataExMessageData").kill();
    //<< kill ^WWWDataExMessageData
    m$.var("^WWWDataExMessageData").kill();
    //<< quit
    return null;
  }

//<< 
}
