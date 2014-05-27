//*****************************************************************************
//** TASC - ALPHALINC - MAC COMDCMUtilities
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:23
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; History:
//<< ; 18-Jan-2007   GRF     SR14365: doco
//<< ; 17-Nov-2004   GRF     Replace YKOMMA with $$$COMMA
//<< ;-------------------------------------------------------------------------------
//<< #include %occConstant
import include.$occConstant;
//<< #include %occStatus
import include.$occStatus;
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

//<< COMDCMUtilities
public class COMDCMUtilities extends mClass {

  public void main() {
    _COMDCMUtilities();
  }

  public void _COMDCMUtilities() {
  }

  //<< 
  //<< 
  //<< GetBase64Decode(pstrText="")
  public Object GetBase64Decode(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Deprecated function
    //<< ;   Base64Encode is limited to creating strings of 12000 characters
    //<< ;   For larger strings this breaks the translation into pieces.
    //<< ;   Note:This makes the encoding string invalid for use outside of cache
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ;
    //<< ; 22-Jan-2009   SCR     SR16320:  Deprecated function use $$GetBase64Decode^COMUtilStr
    //<< ; 23-Nov-2006   shobby  SRBR014006: Removed dodgy processing for long strings.
    //<< ;                       This is handled by breaking up the strings before this
    //<< ;                       routine is called.
    //<< ; 13-Oct-2006   shobby  SRBR014006: Reverted previous change.  $lb can cause a failure
    //<< ;                       Message format not understood: ERROR #6301: SAX XML Parser
    //<< ;                       Error: The input ended before all started tags were ended.
    //<< ;                       Last tag started was 'Val' at line 1 offset 293
    //<< ;                       ^WWW127(0,"INDRPPLANNER","M",1,"PT",1)
    //<< ; 01-Oct-2006   shobby  SRBR014006  Rewrote to use list as the string concatenation method.
    //<< ; 15-Mar-2006   shobby  SR14410     Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< ;
    //<< quit $$GetBase64Decode^COMUtilStr(pstrText)
    return m$.fnc$("COMUtilStr.GetBase64Decode",pstrText.get());
  }

  //<< ;new strText,intLoop,strPiece,intPieces,intStart
  //<< 
  //<< ;set strText=""
  //<< ;;if '$$IsList^COMUtils(pstrText) {
  //<< ;;  set pstrText=$lb(pstrText)
  //<< ;;}
  //<< ;;for intLoop=1:1:$listlength(pstrText) {
  //<< ;for intLoop=1:1:$length(pstrText,"!@#$%%$#@!") {
  //<< ;   ;set strText=strText_$SYSTEM.Encryption.Base64Decode($listget(pstrText,intLoop))
  //<< ;   set strText=strText_$SYSTEM.Encryption.Base64Decode($piece(pstrText,"!@#$%%$#@!",intLoop))
  //<< ;}
  //<< ;quit strText
  //<< 
  //<< 
  //<< GetBase64Encode(pstrText="",parrText)
  public Object GetBase64Encode(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar parrText = m$.newVarRef("parrText",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Deprecated function
    //<< ;   Base64Encode is limited to creating strings of 12000 characters
    //<< ;   For larger strings this breaks the translation into pieces.
    //<< ;   Note:This makes the encoding string invalid for use outside of cache
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Jan-2009   SCR     SR16320:  Deprecated function use $$GetBase64Encode^COMUtilStr
    //<< ; 23-Nov-2006   shobby  SRBR014006: Removed dodgy processing for long strings.
    //<< ;                       This is handled by breaking up the strings before this
    //<< ;                       routine is called.
    //<< ; 13-Oct-2006   shobby  SRBR014006: Reverted previous change.  $lb can cause a failure
    //<< ;                       Message format not understood: ERROR #6301: SAX XML Parser
    //<< ;                       Error: The input ended before all started tags were ended.
    //<< ;                       Last tag started was 'Val' at line 1 offset 293
    //<< ;                       ^WWW127(0,"INDRPPLANNER","M",1,"PT",1)
    //<< ; 01-Oct-2006   shobby  SRBR014006  Rewrote to use list as the string concatenation method.
    //<< ; 15-Mar-2006   shobby  SR14410: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< ;
    //<< quit $$GetBase64Encode^COMUtilStr(pstrText)
    return m$.fnc$("COMUtilStr.GetBase64Encode",pstrText.get());
  }

  //<< ;new strText,intLoop,strPiece,intPieces
  //<< 
  //<< ;set strText=""
  //<< ;set intPieces=$normalize($length(pstrText)/12000+.5,0)
  //<< ;if intPieces>1 {
  //<< ;   for intLoop=1:1:intPieces {
  //<< ;       set strPiece=$extract(pstrText,(intLoop-1)*12000+1,(intLoop*12000))
  //<< ;       ;set strText=strText_$lb($SYSTEM.Encryption.Base64Encode(strPiece))
  //<< ;       set strText=strText_"!@#$%%$#@!"_$SYSTEM.Encryption.Base64Encode(strPiece)
  //<< ;       ;set parrText($order(parrText(""),-1)+1)=$SYSTEM.Encryption.Base64Encode(strPiece)
  //<< ;   }
  //<< ;} else {
  //<< ;   set strText=$SYSTEM.Encryption.Base64Encode(pstrText)
  //<< ;}
  //<< ;
  //<< ;quit strText
  //<< 
  //<< DCMSave(Global,Key,Data)
  public Object DCMSave(Object ... _p) {
    mVar Global = m$.newVarRef("Global",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Key = m$.newVarRef("Key",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar Data = m$.newVarRef("Data",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 05-Feb-2010   GRF     SR17166: need access to avoid consequences of change in SR16718
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$IntraprendSave(Global,Key,Data)
    return m$.fnc$("IntraprendSave",Global.get(),Key.get(),Data.get());
  }

  //<< 
  //<< IntraprendSave(Global,Key,Data)
  public Object IntraprendSave(Object ... _p) {
    mVar Global = m$.newVarRef("Global",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Key = m$.newVarRef("Key",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar Data = m$.newVarRef("Data",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   This routine simulates the @NetManager routine to save a global
    //<< ;
    //<< ; Inputs:
    //<< ;   Global  The global name
    //<< ;   Key     The key values in a comma separated string      e.g. KEY1,KEY2,KEYn
    //<< ;   Data    The data values in a tilde separated string     e.g. XX~XX~XX~
    //<< ;
    //<< ; History:
    //<< ; 05-Feb-2003   SCR     New YFORM,YVOR
    //<< ;-------------------------------------------------------------------------------
    //<< new ok,result,txtlist,YFORM,YVOR
    mVar ok = m$.var("ok");
    mVar result = m$.var("result");
    mVar txtlist = m$.var("txtlist");
    mVar YFORM = m$.var("YFORM");
    mVar YVOR = m$.var("YVOR");
    m$.newVar(ok,result,txtlist,YFORM,YVOR);
    //<< 
    //<< set ok=$$^WWWSPEI(Global,Key,Data,1)
    ok.set(m$.fnc$("WWWSPEI.main",Global.get(),Key.get(),Data.get(),1));
    //<< 
    //<< if (ok=0) {
    if ((mOp.Equal(ok.get(),0))) {
      //<< set txtlist = $listbuild("Com00072",Global,Key)      ; Error returned from WWWSPEI
      txtlist.set(m$.Fnc.$listbuild("Com00072",Global.get(),Key.get()));
      //<< set result  = 0_Y_$$DecodeError^COMUtilError(txtlist)
      result.set(mOp.Concat(mOp.Concat(0,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
    }
    //<< } elseif (ok=1) {
    else if ((mOp.Equal(ok.get(),1))) {
      //<< set txtlist = $listbuild("Com00073")                 ; Save performed correctly
      txtlist.set(m$.Fnc.$listbuild("Com00073"));
      //<< set result  = 1_Y_$$DecodeError^COMUtilError(txtlist)
      result.set(mOp.Concat(mOp.Concat(1,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
    }
    //<< } elseif (ok=9) {
    else if ((mOp.Equal(ok.get(),9))) {
      //<< set txtlist = $listbuild("Com00074",Global,Key)      ; Unable to save - not owner
      txtlist.set(m$.Fnc.$listbuild("Com00074",Global.get(),Key.get()));
      //<< set result  = 0_Y_$$DecodeError^COMUtilError(txtlist)
      result.set(mOp.Concat(mOp.Concat(0,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
    }
    //<< } else {
    else {
      //<< set txtlist = $listbuild("Com00075",ok,Global,Key)   ; Unknown response(%1) from WWWSPEI
      txtlist.set(m$.Fnc.$listbuild("Com00075",ok.get(),Global.get(),Key.get()));
      //<< set result  = 0_Y_$$DecodeError^COMUtilError(txtlist)
      result.set(mOp.Concat(mOp.Concat(0,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
    }
    //<< }
    //<< 
    //<< if (($piece(result,Y,1)) && (Global="COMDCMLocation")) {
    if ((mOp.Logical((m$.Fnc.$piece(result.get(),m$.var("Y").get(),1))) && (mOp.Equal(Global.get(),"COMDCMLocation")))) {
      //<< ; Handle WSDL loading on Location Saves
      //<< set result=$$LoadLocationWSDL^COMDCMLocation(Key)
      result.set(m$.fnc$("COMDCMLocation.LoadLocationWSDL",Key.get()));
    }
    //<< }
    //<< 
    //<< quit result
    return result.get();
  }

  //<< 
  //<< 
  //<< GetCheckSum(pYFELD="",pYVOR="")
  public Object GetCheckSum(Object ... _p) {
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pYVOR = m$.newVarRef("pYVOR",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;This routine retrieves the checksum of a record, excluding the 'Data Field Entry Date'
    //<< ;and 'Data Field Date Modified' as these will be changed by WWWSPEI to reflect the local
    //<< ;time.
    //<< ;
    //<< ; Inputs:
    //<< ;   pYFELD  The data record
    //<< ;   pYVOR   Form definition   (objWWW120)
    //<< ;
    //<< ; History:
    //<< ; 18-Sep-2006   shobby  Creation:SR14365
    //<< ;-------------------------------------------------------------------------------
    //<< new strCheckSum
    mVar strCheckSum = m$.var("strCheckSum");
    m$.newVar(strCheckSum);
    //<< 
    //<< set strCheckSum=0
    strCheckSum.set(0);
    //<< if pYFELD'="" {
    if (mOp.NotEqual(pYFELD.get(),"")) {
      //<< if $PIECE(pYVOR,Y,25)'="" set $PIECE(pYFELD,Y,$PIECE(pYVOR,Y,25))=""        ; $$$WWW120DataFieldEntryDate
      if (mOp.NotEqual(m$.Fnc.$piece(pYVOR.get(),m$.var("Y").get(),25),"")) {
        m$.pieceVar(pYFELD,m$.var("Y").get(),m$.Fnc.$piece(pYVOR.get(),m$.var("Y").get(),25)).set("");
      }
      //<< if $PIECE(pYVOR,Y,27)'="" set $PIECE(pYFELD,Y,$PIECE(pYVOR,Y,27))=""        ; $$$WWW120DataFieldForDateModified
      if (mOp.NotEqual(m$.Fnc.$piece(pYVOR.get(),m$.var("Y").get(),27),"")) {
        m$.pieceVar(pYFELD,m$.var("Y").get(),m$.Fnc.$piece(pYVOR.get(),m$.var("Y").get(),27)).set("");
      }
      //<< if YFORM="WWW013" {
      if (mOp.Equal(m$.var("YFORM").get(),"WWW013")) {
        //<< for i=12,13,14,15,16,19,20,21 {
        mVar i = m$.var("i");
        for (Object _i: new Object[] {12,13,14,15,16,19,20,21}) {
          i.set(_i);
          //<< set $piece(pYFELD,Y,i)=""
          m$.pieceVar(pYFELD,m$.var("Y").get(),_i).set("");
        }
      }
      //<< }
      //<< }
      //<< set strCheckSum=$zcrc(pYFELD,7)
      strCheckSum.set(m$.Fnc.$zcrc(pYFELD.get(),7));
    }
    //<< }
    //<< quit strCheckSum
    return strCheckSum.get();
  }

  //<< 
  //<< 
  //<< AdvancedSave(Global,Key,Data,CheckSum="",blnEINMAL=$$$NO) ;SR14365
  public Object AdvancedSave(Object ... _p) {
    mVar Global = m$.newVarRef("Global",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Key = m$.newVarRef("Key",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar Data = m$.newVarRef("Data",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar CheckSum = m$.newVarRef("CheckSum",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar blnEINMAL = m$.newVarRef("blnEINMAL",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ;This routine simulates the @NetManager routine to save a global
    //<< ;
    //<< ; Inputs:
    //<< ;   Global  The global name
    //<< ;   Key     The key values in a comma separated string      e.g. KEY1,KEY2,KEYn
    //<< ;   Data    The data values in a tilde separated string     e.g. XX~XX~XX~
    //<< ;
    //<< ; History:
    //<< ; 18-Sep-2006   shobby  SR14365:Do not block entries where the destination record
    //<< ;                       is the same as the source record... will happen when DCM
    //<< ;                       queue entry is processed but the return message is logged
    //<< ;                       when the destination system goes down for backup.
    //<< ; 04-Apr-2006   shobby  SR14365:Renamed from IntraprendSave
    //<< ; 09-Mar-2006   shobby  SR14365:Get YBED from Data not %FELD1.
    //<< ; 08-Mar-2006   shobby  SR14365:Ignore the last changed time in the checksum this
    //<< ;                       will be updated to use the local time after DCM
    //<< ; 08-Mar-2006   shobby  SR14365:Set up values for YFORM to force WWWPRO and WWWLAST
    //<< ;                       logging when calling WWWSPEI
    //<< ; 02-Mar-2006   shobby  SR14365:New optional field 'blnEINMAL' if there is two way
    //<< ;                       DCM we do not want to return record to calling site.
    //<< ;                       TODO - But we may want to send it to other spokes.  !!!
    //<< ; 02-Mar-2006   shobby  New optional field 'checkSum'. This can be used to determine
    //<< ;                       if the record at both sites was the same before modification.
    //<< ;                       Used if configured in 'Available Events'.
    //<< ; 05-Feb-2003   SCR     New YFORM,YVOR
    //<< ;-------------------------------------------------------------------------------
    //<< new ok,result,txtlist,YFORM,YVOR,strCheckSum,%FELD1,strCommand,strFELD,strCheckSumNew
    mVar ok = m$.var("ok");
    mVar result = m$.var("result");
    mVar txtlist = m$.var("txtlist");
    mVar YFORM = m$.var("YFORM");
    mVar YVOR = m$.var("YVOR");
    mVar strCheckSum = m$.var("strCheckSum");
    mVar strCommand = m$.var("strCommand");
    mVar strFELD = m$.var("strFELD");
    mVar strCheckSumNew = m$.var("strCheckSumNew");
    m$.newVar(ok,result,txtlist,YFORM,YVOR,strCheckSum,strCommand,strFELD,strCheckSumNew);
    //<< 
    //<< set ok    = $$$YES
    ok.set(include.COMSYS.$$$YES(m$));
    //<< set YFORM = $get(Global)
    YFORM.set(m$.Fnc.$get(Global));
    //<< set YVOR  = $get(^WWW120(0,YFORM,1))
    YVOR.set(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)));
    //<< 
    //<< if (CheckSum'="") {
    if ((mOp.NotEqual(CheckSum.get(),""))) {
      //<< set strCommand="set %FELD1=$get(^"_Global_"("_$$^WWWYM(Global)_","_$$^WWWKEYBUILD(Key)_",1))"
      strCommand.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("set %FELD1=$get(^",Global.get()),"("),m$.fnc$("WWWYM.main",Global.get())),","),m$.fnc$("WWWKEYBUILD.main",Key.get())),",1))"));
      //<< xecute strCommand
      m$.Cmd.Xecute(strCommand.get());
      //<< 
      //<< set strCheckSum=$$GetCheckSum(%FELD1,YVOR)
      strCheckSum.set(m$.fnc$("GetCheckSum",m$.var("%FELD1").get(),YVOR.get()));
      //<< if (CheckSum'=strCheckSum)&&(strCheckSum'=0) {
      if ((mOp.NotEqual(CheckSum.get(),strCheckSum.get())) && (mOp.NotEqual(strCheckSum.get(),0))) {
        //<< set strCheckSumNew=$$GetCheckSum(Data,YVOR)
        strCheckSumNew.set(m$.fnc$("GetCheckSum",Data.get(),YVOR.get()));
        //<< ; Record ´%1´ of class ´%2´ has been changed by another user.  This DCM queue entry should be skipped and a manual synchronisation of the data is required.
        //<< if (strCheckSum'=strCheckSumNew) {
        if ((mOp.NotEqual(strCheckSum.get(),strCheckSumNew.get()))) {
          //<< set txtlist = $listbuild("Com00243",Key,Global)
          txtlist.set(m$.Fnc.$listbuild("Com00243",Key.get(),Global.get()));
          //<< set result  = 0_Y_$$DecodeError^COMUtilError(txtlist)
          result.set(mOp.Concat(mOp.Concat(0,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
          //<< set ok=0
          ok.set(0);
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< set YBED=$PIECE(Data,Y,$PIECE(YVOR,Y,28))
    mVar YBED = m$.var("YBED");
    YBED.set(m$.Fnc.$piece(Data.get(),m$.var("Y").get(),m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),28)));
    //<< if YBED="" set YBED=$PIECE(Data,Y,$PIECE(YVOR,Y,26))
    if (mOp.Equal(YBED.get(),"")) {
      YBED.set(m$.Fnc.$piece(Data.get(),m$.var("Y").get(),m$.Fnc.$piece(YVOR.get(),m$.var("Y").get(),26)));
    }
    //<< if YBED="" set YBED="DCM"
    if (mOp.Equal(YBED.get(),"")) {
      YBED.set("DCM");
    }
    //<< 
    //<< if ok {
    if (mOp.Logical(ok.get())) {
      //<< if blnEINMAL {
      if (mOp.Logical(blnEINMAL.get())) {
        //<< set ok=$$^WWWSPEI(Global,Key,Data,1,,blnEINMAL)
        ok.set(m$.fnc$("WWWSPEI.main",Global.get(),Key.get(),Data.get(),1,null,blnEINMAL.get()));
      }
      //<< } else {
      else {
        //<< set ok=$$^WWWSPEI(Global,Key,Data,1)
        ok.set(m$.fnc$("WWWSPEI.main",Global.get(),Key.get(),Data.get(),1));
      }
      //<< }
      //<< if (ok=0) {
      if ((mOp.Equal(ok.get(),0))) {
        //<< set txtlist = $listbuild("Com00072",Global,Key)      ; Error returned from WWWSPEI
        txtlist.set(m$.Fnc.$listbuild("Com00072",Global.get(),Key.get()));
        //<< set result  = 0_Y_$$DecodeError^COMUtilError(txtlist)
        result.set(mOp.Concat(mOp.Concat(0,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
      }
      //<< } elseif (ok=1) {
      else if ((mOp.Equal(ok.get(),1))) {
        //<< set txtlist = $listbuild("Com00073")                 ; Save performed correctly
        txtlist.set(m$.Fnc.$listbuild("Com00073"));
        //<< set result  = 1_Y_$$DecodeError^COMUtilError(txtlist)
        result.set(mOp.Concat(mOp.Concat(1,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
      }
      //<< } elseif (ok=9) {
      else if ((mOp.Equal(ok.get(),9))) {
        //<< set txtlist = $listbuild("Com00074",Global,Key)      ; Unable to save - not owner
        txtlist.set(m$.Fnc.$listbuild("Com00074",Global.get(),Key.get()));
        //<< set result  = 0_Y_$$DecodeError^COMUtilError(txtlist)
        result.set(mOp.Concat(mOp.Concat(0,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
      }
      //<< } else {
      else {
        //<< set txtlist = $listbuild("Com00075",ok,Global,Key)   ; Unknown response(%1) from WWWSPEI
        txtlist.set(m$.Fnc.$listbuild("Com00075",ok.get(),Global.get(),Key.get()));
        //<< set result  = 0_Y_$$DecodeError^COMUtilError(txtlist)
        result.set(mOp.Concat(mOp.Concat(0,m$.var("Y").get()),m$.fnc$("COMUtilError.DecodeError",txtlist.get())));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if (($piece(result,Y,1)) && (Global="COMDCMLocation")) {
    if ((mOp.Logical((m$.Fnc.$piece(result.get(),m$.var("Y").get(),1))) && (mOp.Equal(Global.get(),"COMDCMLocation")))) {
      //<< ; Handle WSDL loading on Location Saves
      //<< set result=$$LoadLocationWSDL^COMDCMLocation(Key)
      result.set(m$.fnc$("COMDCMLocation.LoadLocationWSDL",Key.get()));
    }
    //<< }
    //<< 
    //<< quit result
    return result.get();
  }

  //<< 
  //<< DCMDelete(Global,Key)
  public Object DCMDelete(Object ... _p) {
    mVar Global = m$.newVarRef("Global",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Key = m$.newVarRef("Key",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 05-Mar-2010   GRF     SR17166.1: only 2 parameters
    //<< ; 05-Feb-2010   GRF     SR17166: need access to avoid consequences of change in SR16718
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$IntraprendDelete(Global,Key)
    return m$.fnc$("IntraprendDelete",Global.get(),Key.get());
  }

  //<< 
  //<< IntraprendDelete(Global,Key)
  public Object IntraprendDelete(Object ... _p) {
    mVar Global = m$.newVarRef("Global",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Key = m$.newVarRef("Key",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;This routine simulates the @NetManager routine to delete a global
    //<< ;
    //<< ;Global  This is the global name
    //<< ;Key    This is the key values in a comma separated string, e.g. KEY1,KEY2,KEYn
    //<< ;
    //<< ; History:
    //<< ; 26-Oct-2006   RPW     SR15134: Fixed undefined var.
    //<< ; 19-Oct-2006   JW      SR15134: Look at kill status
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$^WWWKILL(Global,Key,1)        //SR15134
    strStatus.set(m$.fnc$("WWWKILL.main",Global.get(),Key.get(),1));
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set strStatus = 1_Y_$$^WWWTEXT("Com00076")  ; Delete performed
      strStatus.set(mOp.Concat(mOp.Concat(1,m$.var("Y").get()),m$.fnc$("WWWTEXT.main","Com00076")));
    }
    //<< } else {
    else {
      //<< set strStatus = 0_Y_$$$Text(strStatus)  //SR15134
      strStatus.set(mOp.Concat(mOp.Concat(0,m$.var("Y").get()),include.COMSYS.$$$Text(m$,strStatus)));
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< LogDebugMessage(Reason,Msg)
  public Object LogDebugMessage(Object ... _p) {
    mVar Reason = m$.newVarRef("Reason",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Msg = m$.newVarRef("Msg",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History :
    //<< ; 05-Jan-2005   GRF     SR11415 : Use Macros
    //<< ;-------------------------------------------------------------------------------
    //<< $$$JournalOff   ;   Ensure log is outside transaction boundary
    include.COMSYS.$$$JournalOff(m$);
    //<< set ^COMDCMDebug($job,$INCREMENT(^COMDCMDebug("LastLogNo")),$zdatetime($horolog),Reason)=Msg
    m$.var("^COMDCMDebug",m$.Fnc.$job(),m$.Fnc.$increment(m$.var("^COMDCMDebug","LastLogNo")),m$.Fnc.$zdatetime(m$.Fnc.$horolog()),Reason.get()).set(Msg.get());
    //<< $$$JournalOn
    include.COMSYS.$$$JournalOn(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< CleanupObjects(parentObject)
  public Object CleanupObjects(Object ... _p) {
    mVar parentObject = m$.newVarRef("parentObject",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;-------------------------------------------------------------------------------
    //<< new childKey,elementObject
    mVar childKey = m$.var("childKey");
    mVar elementObject = m$.var("elementObject");
    m$.newVar(childKey,elementObject);
    //<< 
    //<< quit:'parentObject.ChildElements.Count()
    if (mOp.Not(m$.fnc$(m$.var("parentObject").getORef(),"ChildElements.Count"))) {
      return null;
    }
    //<< 
    //<< set childKey=""
    childKey.set("");
    //<< for    {
    for (;true;) {
      //<< set elementObject=parentObject.ChildElements.GetPrevious(.childKey)
      elementObject.set(m$.fnc$(m$.var("parentObject").getORef(),"ChildElements.GetPrevious",childKey));
      //<< quit:childKey=""
      if (mOp.Equal(childKey.get(),"")) {
        break;
      }
      //<< 
      //<< do CleanupObjects(elementObject)
      m$.Cmd.Do("CleanupObjects",elementObject.get());
      //<< do parentObject.ChildElements.RemoveAt(childKey)
      m$.Cmd.Do(parentObject.getORef(),"ChildElements.RemoveAt",childKey.get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CombineErrorText(ErrorNo,sc)
  public Object CombineErrorText(Object ... _p) {
    mVar ErrorNo = m$.newVarRef("ErrorNo",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar sc = m$.newVarRef("sc",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;-------------------------------------------------------------------------------
    //<< new errlist,txtlist
    mVar errlist = m$.var("errlist");
    mVar txtlist = m$.var("txtlist");
    m$.newVar(errlist,txtlist);
    //<< 
    //<< do ##class(%SYSTEM.Status).DecomposeStatus(sc,.errlist)
    m$.getSystem().getStatus().DecomposeStatus(sc.get(),errlist);
    //<< set txtlist=$listbuild(ErrorNo,errlist(1))
    txtlist.set(m$.Fnc.$listbuild(ErrorNo.get(),errlist.var(1).get()));
    //<< quit $$DecodeError^COMUtilError(txtlist)
    return m$.fnc$("COMUtilError.DecodeError",txtlist.get());
  }

  //<< 
  //<< getCurrentLocation()
  public Object getCurrentLocation(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Location name based upon current Machine name
    //<< ; and Namespace
    //<< ;
    //<< ; History:
    //<< ; 03-Aug-2005   RPW     QuickFix: The Company Check must use YM, not 0.
    //<< ; 27-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 05-May-2005   PaulK   Added checking of company number
    //<< ;-------------------------------------------------------------------------------
    //<< new idLocation,strMachine,strNamespace
    mVar idLocation = m$.var("idLocation");
    mVar strMachine = m$.var("strMachine");
    mVar strNamespace = m$.var("strNamespace");
    m$.newVar(idLocation,strMachine,strNamespace);
    //<< new objLocation
    mVar objLocation = m$.var("objLocation");
    m$.newVar(objLocation);
    //<< 
    //<< set strNamespace= $$$Index($zutil(5))
    strNamespace.set(include.MEDConst.$$$Index(m$,m$.Fnc.$zutil(5)));
    //<< set strMachine  = $$$Index($zutil(110))
    strMachine.set(include.MEDConst.$$$Index(m$,m$.Fnc.$zutil(110)));
    //<< 
    //<< set idLocation=""
    idLocation.set("");
    //<< for {
    for (;true;) {
      //<< set idLocation=$order(^COMDCMLocations(0,2,strMachine,strNamespace,idLocation))
      idLocation.set(m$.Fnc.$order(m$.var("^COMDCMLocations",0,2,strMachine.get(),strNamespace.get(),idLocation.get())));
      //<< quit:idLocation=""
      if (mOp.Equal(idLocation.get(),"")) {
        break;
      }
      //<< set objLocation=$get(^COMDCMLocation(0,idLocation,1))
      objLocation.set(m$.Fnc.$get(m$.var("^COMDCMLocation",0,idLocation.get(),1)));
      //<< quit:$$$COMDCMLocationCompany1(objLocation)=""
      if (mOp.Equal(include.COMConst.$$$COMDCMLocationCompany1(m$,objLocation),"")) {
        break;
      }
      //<< quit:$$$COMDCMLocationCompany1(objLocation)=YM
      if (mOp.Equal(include.COMConst.$$$COMDCMLocationCompany1(m$,objLocation),m$.var("YM").get())) {
        break;
      }
    }
    //<< }
    //<< 
    //<< quit idLocation
    return idLocation.get();
  }

  //<< 
  //<< checkInterestedEvent(currLoc,eventName,methodName="")
  public Object checkInterestedEvent(Object ... _p) {
    mVar currLoc = m$.newVarRef("currLoc",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar eventName = m$.newVarRef("eventName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar methodName = m$.newVarRef("methodName",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; check to see whether we have an interest in this event
    //<< ;
    //<< ; Returns:Boolean
    //<< ;
    //<< ; History:
    //<< ; 05-Jan-2005   GRF     SR11415 : Use Macros
    //<< ; 12-Nov-2004           Don't add items to the queue if no valid methods for event.
    //<< ;-------------------------------------------------------------------------------
    //<< new interested,eventRule,methodRule,lstMethods,MethodLoop
    mVar interested = m$.var("interested");
    mVar eventRule = m$.var("eventRule");
    mVar methodRule = m$.var("methodRule");
    mVar lstMethods = m$.var("lstMethods");
    mVar MethodLoop = m$.var("MethodLoop");
    m$.newVar(interested,eventRule,methodRule,lstMethods,MethodLoop);
    //<< 
    //<< if $data(^COMDCMDebug) do LogDebugMessage^COMDCMUtilities("START","checkInterestedEvent")
    if (mOp.Logical(m$.Fnc.$data(m$.var("^COMDCMDebug")))) {
      m$.Cmd.Do("COMDCMUtilities.LogDebugMessage","START","checkInterestedEvent");
    }
    //<< set interested = $$$NO
    interested.set(include.COMSYS.$$$NO(m$));
    //<< set lstMethods = ""
    lstMethods.set("");
    //<< 
    //<< ; have an explicit setup
    //<< if (methodName="") {
    if ((mOp.Equal(methodName.get(),""))) {
      //<< if $data(^COMDCMLocEvent(0,currLoc,eventName)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^COMDCMLocEvent",0,currLoc.get(),eventName.get())))) {
        //<< set interested = $$$YES
        interested.set(include.COMSYS.$$$YES(m$));
      }
      //<< } else {
      else {
        //<< for {
        for (;true;) {
          //<< set methodName=$order(^COMDCMMethod(0,eventName,methodName))
          methodName.set(m$.Fnc.$order(m$.var("^COMDCMMethod",0,eventName.get(),methodName.get())));
          //<< quit:methodName=""
          if (mOp.Equal(methodName.get(),"")) {
            break;
          }
          //<< 
          //<< set lstMethods = lstMethods_$listbuild(methodName)
          lstMethods.set(mOp.Concat(lstMethods.get(),m$.Fnc.$listbuild(methodName.get())));
        }
      }
    }
    //<< }
    //<< }
    //<< } else {
    else {
      //<< if $data(^COMDCMLocEvent(0,currLoc,eventName,methodName)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^COMDCMLocEvent",0,currLoc.get(),eventName.get(),methodName.get())))) {
        //<< set interested = $$$YES
        interested.set(include.COMSYS.$$$YES(m$));
      }
      //<< } else {
      else {
        //<< set lstMethods = lstMethods_$listbuild(methodName)
        lstMethods.set(mOp.Concat(lstMethods.get(),m$.Fnc.$listbuild(methodName.get())));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set eventRule=""
    eventRule.set("");
    //<< for {
    for (;true;) {
      //<< set eventRule=$order(^COMDCMLocEvent(0,currLoc,eventRule))
      eventRule.set(m$.Fnc.$order(m$.var("^COMDCMLocEvent",0,currLoc.get(),eventRule.get())));
      //<< quit:(eventRule="")
      if ((mOp.Equal(eventRule.get(),""))) {
        break;
      }
      //<< quit:interested
      if (mOp.Logical(interested.get())) {
        break;
      }
      //<< 
      //<< if (eventRule["*") {
      if ((mOp.Contains(eventRule.get(),"*"))) {
        //<< if $$checkPatternMatch^COMUtils(eventRule,eventName) {
        if (mOp.Logical(m$.fnc$("COMUtils.checkPatternMatch",eventRule.get(),eventName.get()))) {
          //<< set methodRule=""
          methodRule.set("");
          //<< for {
          for (;true;) {
            //<< set methodRule=$order(^COMDCMLocEvent(0,currLoc,eventRule,methodRule))
            methodRule.set(m$.Fnc.$order(m$.var("^COMDCMLocEvent",0,currLoc.get(),eventRule.get(),methodRule.get())));
            //<< quit:methodRule=""
            if (mOp.Equal(methodRule.get(),"")) {
              break;
            }
            //<< quit:interested
            if (mOp.Logical(interested.get())) {
              break;
            }
            //<< 
            //<< for MethodLoop=1:1:$listlength(lstMethods) {
            for (MethodLoop.set(1);(mOp.LessOrEqual(MethodLoop.get(),m$.Fnc.$listlength(lstMethods.get())));MethodLoop.set(mOp.Add(MethodLoop.get(),1))) {
              //<< quit:interested
              if (mOp.Logical(interested.get())) {
                break;
              }
              //<< 
              //<< if ((methodRule["*")||(methodRule=$listget(lstMethods,MethodLoop))) {
              if (mOp.Logical(((mOp.Contains(methodRule.get(),"*")) || (mOp.Equal(methodRule.get(),m$.Fnc.$listget(lstMethods.get(),MethodLoop.get())))))) {
                //<< set interested=$$checkPatternMatch^COMUtils(methodRule,$listget(lstMethods,MethodLoop))
                interested.set(m$.fnc$("COMUtils.checkPatternMatch",methodRule.get(),m$.Fnc.$listget(lstMethods.get(),MethodLoop.get())));
              }
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
    //<< }
    //<< quit interested
    return interested.get();
  }

  //<< 
  //<< checkInterestedData(eventName,%recordKeys,%recordData)
  public Object checkInterestedData(Object ... _p) {
    mVar eventName = m$.newVarRef("eventName",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$recordKeys = m$.newVarRef("p$recordKeys",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$recordData = m$.newVarRef("p$recordData",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Before sending a DCM message check for a callback that may exclude this item
    //<< ; from being placed on the DCM queue.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 01-Jul-2005   RPW     CodeCheck: COMDCMEvent is shared.
    //<< ; 30-Jun-2005   shobby  SR12578
    //<< ;-------------------------------------------------------------------------------
    //<< new objCOMDCMEvent,strEvent,strStatus
    mVar objCOMDCMEvent = m$.var("objCOMDCMEvent");
    mVar strEvent = m$.var("strEvent");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objCOMDCMEvent,strEvent,strStatus);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if eventName'="" {
    if (mOp.NotEqual(eventName.get(),"")) {
      //<< set objCOMDCMEvent=$get(^COMDCMEvent(0,eventName,1))
      objCOMDCMEvent.set(m$.Fnc.$get(m$.var("^COMDCMEvent",0,eventName.get(),1)));
      //<< if $$$COMDCMEventOnBeforeDCM(objCOMDCMEvent)'="" {
      if (mOp.NotEqual(include.COMConst.$$$COMDCMEventOnBeforeDCM(m$,objCOMDCMEvent),"")) {
        //<< set strEvent="set strStatus=$$"_$$$COMDCMEventOnBeforeDCM(objCOMDCMEvent)
        strEvent.set(mOp.Concat("set strStatus=$$",include.COMConst.$$$COMDCMEventOnBeforeDCM(m$,objCOMDCMEvent)));
        //<< xecute strEvent
        m$.Cmd.Xecute(strEvent.get());
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
  //<< GenerateAllSaveEvents(Global)
  public Object GenerateAllSaveEvents(Object ... _p) {
    mVar Global = m$.newVarRef("Global",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Routine to Generate a Save event for every node in
    //<< ; the current company for the nominated global - useful
    //<< ; for initialising a dataset
    //<< ;
    //<< ; History :
    //<< ; 05-Jan-2005   GRF     SR11415 : Use Macros
    //<< ;-------------------------------------------------------------------------------
    //<< new GlobalNode,num,YKEY
    mVar GlobalNode = m$.var("GlobalNode");
    mVar num = m$.var("num");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(GlobalNode,num,YKEY);
    //<< 
    //<< if ($data(@Global@(YM))) {
    if (mOp.Logical((m$.Fnc.$data(m$.indirectVar(Global.get()).var(m$.var("YM").get()))))) {
      //<< set GlobalNode=$QUERY(@Global@(YM))
      GlobalNode.set(m$.Fnc.$query(m$.indirectVar(Global.get()).var(m$.var("YM").get())));
      //<< while (GlobalNode'="") {
      while ((mOp.NotEqual(GlobalNode.get(),""))) {
        //<< ; Get the YKEY from the global node id
        //<< set YKEY=$piece($piece(GlobalNode,")",1),"(",2)
        YKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(GlobalNode.get(),")",1),"(",2));
        //<< quit:($piece(YKEY,$$$COMMA,1)'=YM)              ; end of required company
        if ((mOp.NotEqual(m$.Fnc.$piece(YKEY.get(),include.COMSYSString.$$$COMMA(m$),1),m$.var("YM").get()))) {
          break;
        }
        //<< 
        //<< set YKEY=$piece(YKEY,$$$COMMA,2,999)            ; remove company
        YKEY.set(m$.Fnc.$piece(YKEY.get(),include.COMSYSString.$$$COMMA(m$),2,999));
        //<< set num =$length(YKEY)-2
        num.set(mOp.Subtract(m$.Fnc.$length(YKEY.get()),2));
        //<< if ($extract(YKEY,num+1,num+2)=",1") {
        if ((mOp.Equal(m$.Fnc.$extract(YKEY.get(),mOp.Add(num.get(),1),mOp.Add(num.get(),2)),",1"))) {
          //<< set YKEY=$extract(YKEY,1,num)               ; remove ,1
          YKEY.set(m$.Fnc.$extract(YKEY.get(),1,num.get()));
          //<< set YKEY=$translate(YKEY,$$$DBLQUOTE)       ; remove quotes
          YKEY.set(m$.Fnc.$translate(YKEY.get(),include.COMSYSString.$$$DBLQUOTE(m$)));
          //<< 
          //<< do setRelevantEvents^COMDCMControlModule("INTRAPREND",$piece(Global,"^",2),"save",YKEY,@GlobalNode)
          m$.Cmd.Do("COMDCMControlModule.setRelevantEvents","INTRAPREND",m$.Fnc.$piece(Global.get(),"^",2),"save",YKEY.get(),m$.indirectVar(GlobalNode.get()).get());
        }
        //<< }
        //<< set GlobalNode=$QUERY(@GlobalNode)
        GlobalNode.set(m$.Fnc.$query(m$.indirectVar(GlobalNode.get())));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< GetSitesForLocation(Location)
  public Object GetSitesForLocation(Object ... _p) {
    mVar Location = m$.newVarRef("Location",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Routine to return a list of sites for a nominated Location
    //<< ; Returns a comma separated list of Site names
    //<< ;-------------------------------------------------------------------------------
    //<< new Site,SiteList
    mVar Site = m$.var("Site");
    mVar SiteList = m$.var("SiteList");
    m$.newVar(Site,SiteList);
    //<< 
    //<< quit:($get(Location)="") "" ; return nothing if Location not specified
    if ((mOp.Equal(m$.Fnc.$get(Location),""))) {
      return "";
    }
    //<< 
    //<< set Location=$$^WWWUMLAU(YM_","_Location,1)
    Location.set(m$.fnc$("WWWUMLAU.main",mOp.Concat(mOp.Concat(m$.var("YM").get(),","),Location.get()),1));
    //<< set SiteList=""
    SiteList.set("");
    //<< set Site=""
    Site.set("");
    //<< for {
    for (;true;) {
      //<< set Site=$order(^COMDCMLocations(0,3,Location,Site))
      Site.set(m$.Fnc.$order(m$.var("^COMDCMLocations",0,3,Location.get(),Site.get())));
      //<< quit:(Site="")
      if ((mOp.Equal(Site.get(),""))) {
        break;
      }
      //<< 
      //<< if (SiteList'="") set SiteList=SiteList_","
      if ((mOp.NotEqual(SiteList.get(),""))) {
        SiteList.set(mOp.Concat(SiteList.get(),","));
      }
      //<< set SiteList=SiteList_Site
      SiteList.set(mOp.Concat(SiteList.get(),Site.get()));
    }
    //<< }
    //<< 
    //<< quit SiteList
    return SiteList.get();
  }

  //<< 
  //<< NotifyAdmin(sender,msg)
  public Object NotifyAdmin(Object ... _p) {
    mVar sender = m$.newVarRef("sender",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar msg = m$.newVarRef("msg",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Routine has been moved - this function is only to maintain compatibility
    //<< ; Date: 22 July 03
    //<< ;-------------------------------------------------------------------------------
    //<< do NotifyAdmin^COMUtils(sender,msg)
    m$.Cmd.Do("COMUtils.NotifyAdmin",sender.get(),msg.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateAllLocEvents(pstrSite,pstrCondition="CT")
  public Object CreateAllLocEvents(Object ... _p) {
    mVar pstrSite = m$.newVarRef("pstrSite",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrCondition = m$.newVarRef("pstrCondition",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"CT");
    //<< /*-------------------------------------------------------------------------------
    //<< ; Creates the COMDCMLocEvent globals specifically related to language translations
    //<< ; (As per email from AZ)
    //<< ;
    //<< ; Example Usage:
    //<< ;   w $$CreateAllLocEvents^COMDCMUtilities("MORENA_TRANSLATION")
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Jun-2009   shobby  SR16656:    Include two TSFormTranslation* classes which are sent to
    //<< ;                           DEV unconditionally.
    //<< ; 10-Sep-2008   shobby  BR014980:   Don't include COMHelp* classes (temporary data)
    //<< ; 28-Sep-2006   shobby  SRBR014260: Remove COMViewLanguageText
    //<< ; 26-Sep-2006   shobby  SRBR014260: Include all classes with Language in the primary
    //<< ;                       keys except Customisation classes.
    //<< ; 21-Sep-2006   shobby  SRBR014260: Include INForeCalcLang
    //<< ; 14-Feb-2006   shobby  SR14281   : Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< ;
    //<< new strClass,strStatus,lstClasses,idx,strCustomClasses,strCondition
    mVar strClass = m$.var("strClass");
    mVar strStatus = m$.var("strStatus");
    mVar lstClasses = m$.var("lstClasses");
    mVar idx = m$.var("idx");
    mVar strCustomClasses = m$.var("strCustomClasses");
    mVar strCondition = m$.var("strCondition");
    m$.newVar(strClass,strStatus,lstClasses,idx,strCustomClasses,strCondition);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set strCustomClasses=";WWW002D;WWW003D;WWW1203D;WWW121D1;WWW122D1;WWW124D;COMViewLanguageText;"
    strCustomClasses.set(";WWW002D;WWW003D;WWW1203D;WWW121D1;WWW122D1;WWW124D;COMViewLanguageText;");
    //<< set strCustomClasses=strCustomClasses_"COMHelp;COMHelpButton;COMHelpField;"
    strCustomClasses.set(mOp.Concat(strCustomClasses.get(),"COMHelp;COMHelpButton;COMHelpField;"));
    //<< set lstClasses=$$GetLanguageClasses^COMLanguage()
    lstClasses.set(m$.fnc$("COMLanguage.GetLanguageClasses"));
    //<< set lstClasses=lstClasses_$listbuild("TSFormTranslationToDo","TSFormTranslationStatus") ;16656
    lstClasses.set(mOp.Concat(lstClasses.get(),m$.Fnc.$listbuild("TSFormTranslationToDo","TSFormTranslationStatus")));
    //<< 
    //<< for idx=1:1:$listlength(lstClasses) {
    for (idx.set(1);(mOp.LessOrEqual(idx.get(),m$.Fnc.$listlength(lstClasses.get())));idx.set(mOp.Add(idx.get(),1))) {
      //<< set strClass=$listget(lstClasses,idx)
      strClass.set(m$.Fnc.$listget(lstClasses.get(),idx.get()));
      //<< if '(strCustomClasses[(";"_strClass_";")) {
      if (mOp.Not((mOp.Contains(strCustomClasses.get(),(mOp.Concat(mOp.Concat(";",strClass.get()),";")))))) {
        //<< if (";TSFormTranslationToDo;TSFormTranslationStatus;"[(";"_strClass_";")) {   ;16656
        if ((mOp.Contains(";TSFormTranslationToDo;TSFormTranslationStatus;",(mOp.Concat(mOp.Concat(";",strClass.get()),";"))))) {
          //<< set strCondition=""                                                       ;16656
          strCondition.set("");
        }
        //<< } else {
        else {
          //<< set strCondition=pstrCondition
          strCondition.set(pstrCondition.get());
        }
        //<< }
        //<< write !,strClass ;," ",$$CreateLocEvents(pstrSite,strClass,strCondition)
        m$.Cmd.Write("\n",strClass.get());
      }
    }
    //<< 
    //<< }
    //<< }
    //<< ;set strClass="SALCSTGridColText" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="SALCSTGridText" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="SALCSTMenuContentText" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="SALCSTMenuHeaderText" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="SALCSTSegmentLayerText" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="SALCSTSegmentText" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="SALRuleText" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="SALRuleTypeText" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="CSTCharValue1" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="INDRPPARA" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="INForeCalcLang" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="SALAccountText" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="SALCSTButtonText" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW0011" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW0021" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW0031" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW0041" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW00411" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW009" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW100" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW101" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW1201" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW1203" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW1211" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW121D1" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW1221" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW122D1" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW124" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW124D" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW127" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWW1271" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< ;set strClass="WWWEDUSP" w !,strClass," ",$$CreateLocEvents(pstrSite,strClass,pstrCondition)
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< 
  //<< 
  //<< CreateLocEvents(pstrSite,pstrClass,pstrCondition="")
  public Object CreateLocEvents(Object ... _p) {
    mVar pstrSite = m$.newVarRef("pstrSite",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrClass = m$.newVarRef("pstrClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrCondition = m$.newVarRef("pstrCondition",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< /*-------------------------------------------------------------------------------
    //<< ; Creates the COMDCMLocEvent globals
    //<< ;
    //<< ; Example Usage:
    //<< ;   w $$CreateLocEvents^COMDCMUtilities("MORENA_TRANSLATION",
    //<< ;                                       "WWW0011",
    //<< ;                   "$$CanTransfer^COMDCMLanguage($get(%eventFields(´Global´)),$get(%eventFields(´Key´)),$get(%eventFields(´Data´)))"
    //<< ;                                      )
    //<< ;
    //<< ; Params:
    //<< ;   pstrSite
    //<< ;   pstrClass
    //<< ;   pstrCondition
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Jun-2009   shobby  SR16656: Send to Hub regardless of condition
    //<< ; 16-Feb-2006   shobby  SR14281: Put $get around parameters.  'Data' is not defined for Delete events.
    //<< ; 15-Feb-2006   shobby  SR14281: Changed pstrCondition details
    //<< ; 14-Feb-2006   shobby  SR14281: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< ;
    //<< new strStatus,objCOMDCMLocEvent,strKey
    mVar strStatus = m$.var("strStatus");
    mVar objCOMDCMLocEvent = m$.var("objCOMDCMLocEvent");
    mVar strKey = m$.var("strKey");
    m$.newVar(strStatus,objCOMDCMLocEvent,strKey);
    //<< 
    //<< if $get(Y)="" do ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< set strStatus=$$$YES
    strStatus.set(include.COMSYS.$$$YES(m$));
    //<< set objCOMDCMLocEvent=""
    objCOMDCMLocEvent.set("");
    //<< if pstrCondition="CT" set pstrCondition="$$CanTransfer^COMDCMLanguage($get(%eventFields(´Global´)),$get(%eventFields(´Key´)),$get(%eventFields(´Data´)))"
    if (mOp.Equal(pstrCondition.get(),"CT")) {
      pstrCondition.set("$$CanTransfer^COMDCMLanguage($get(%eventFields(´Global´)),$get(%eventFields(´Key´)),$get(%eventFields(´Data´)))");
    }
    //<< 
    //<< set strKey=pstrSite_$$$COMMA_pstrClass_"*"_$$$COMMA_pstrClass_"*"_$$$COMMA
    strKey.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrSite.get(),include.COMSYSString.$$$COMMA(m$)),pstrClass.get()),"*"),include.COMSYSString.$$$COMMA(m$)),pstrClass.get()),"*"),include.COMSYSString.$$$COMMA(m$)));
    //<< 
    //<< set $$$COMDCMLocEventPrecedence(objCOMDCMLocEvent)=1
    include.COMConst.$$$COMDCMLocEventPrecedenceSet(m$,objCOMDCMLocEvent,1);
    //<< if pstrCondition'="" {
    if (mOp.NotEqual(pstrCondition.get(),"")) {
      //<< set $$$COMDCMLocEventConditionallyRun(objCOMDCMLocEvent)=$$$YES
      include.COMConst.$$$COMDCMLocEventConditionallyRunSet(m$,objCOMDCMLocEvent,include.COMSYS.$$$YES(m$));
      //<< set $$$COMDCMLocEventCondition(objCOMDCMLocEvent)=pstrCondition
      include.COMConst.$$$COMDCMLocEventConditionSet(m$,objCOMDCMLocEvent,pstrCondition.get());
    }
    //<< }
    //<< set $$$COMDCMLocEventTarget(objCOMDCMLocEvent)="Hub" ;16656
    include.COMConst.$$$COMDCMLocEventTargetSet(m$,objCOMDCMLocEvent,"Hub");
    //<< 
    //<< do ^WWWSPEI("COMDCMLocEvent",strKey,objCOMDCMLocEvent,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMLocEvent",strKey.get(),objCOMDCMLocEvent.get(),1);
    //<< 
    //<< if $$$ISOK(strStatus) set strStatus=$$CreateInterSiteEvents(pstrClass,$$$YES,$$$YES)
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      strStatus.set(m$.fnc$("CreateInterSiteEvents",pstrClass.get(),include.COMSYS.$$$YES(m$),include.COMSYS.$$$YES(m$)));
    }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< CreateInterSiteEvents(pstrClass,pblnForce=$$$NO,pblnUseClassName=$$$NO)
  public Object CreateInterSiteEvents(Object ... _p) {
    mVar pstrClass = m$.newVarRef("pstrClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnForce = m$.newVarRef("pblnForce",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar pblnUseClassName = m$.newVarRef("pblnUseClassName",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Routine to create the default intersite events for a given class
    //<< ;
    //<< ; History :
    //<< ; 14-Feb-2006   shobby  SR14281: Modified to force overwrite of existing records.
    //<< ; 14-Feb-2006   shobby  SR14281: pblnUseClassName uses the class name as the
    //<< ;                       basis of the COMDCMMethod ID to force association with
    //<< ;                       the Installed Site list
    //<< ; 05-Jan-2005   GRF     SR11415 : Use Macros
    //<< ;-------------------------------------------------------------------------------
    //<< new NewEvent,NewField,NewMethod,NewParam,strSave,strDelete
    mVar NewEvent = m$.var("NewEvent");
    mVar NewField = m$.var("NewField");
    mVar NewMethod = m$.var("NewMethod");
    mVar NewParam = m$.var("NewParam");
    mVar strSave = m$.var("strSave");
    mVar strDelete = m$.var("strDelete");
    m$.newVar(NewEvent,NewField,NewMethod,NewParam,strSave,strDelete);
    //<< 
    //<< set pstrClass=$g(pstrClass)
    pstrClass.set(m$.Fnc.$get(pstrClass));
    //<< if (($data(^COMDCMEvent(0,pstrClass_"Save"))) || ($data(^COMDCMEvent(0,pstrClass_"Delete")))) {
    if ((mOp.Logical((m$.Fnc.$data(m$.var("^COMDCMEvent",0,mOp.Concat(pstrClass.get(),"Save"))))) || mOp.Logical((m$.Fnc.$data(m$.var("^COMDCMEvent",0,mOp.Concat(pstrClass.get(),"Delete"))))))) {
      //<< ; TODO : Internationalise?
      //<< if 'pblnForce {
      if (mOp.Not(pblnForce.get())) {
        //<< quit "Events already exist - no action performed"
        return "Events already exist - no action performed";
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    //<< ; Establish the Save event
    //<< ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    //<< set NewEvent=""
    NewEvent.set("");
    //<< set $$$COMDCMEventDescription(NewEvent)="save the "_pstrClass_" structure"
    include.COMConst.$$$COMDCMEventDescriptionSet(m$,NewEvent,mOp.Concat(mOp.Concat("save the ",pstrClass.get())," structure"));
    //<< set $$$COMDCMEventEventType(NewEvent)=$$$EnumCOMDCMEVENTTYPESave
    include.COMConst.$$$COMDCMEventEventTypeSet(m$,NewEvent,include.COMConst.$$$EnumCOMDCMEVENTTYPESave(m$));
    //<< set $$$COMDCMEventDataSourceType(NewEvent)=$$$EnumCOMDCMDATASOURCETYPEGlobal
    include.COMConst.$$$COMDCMEventDataSourceTypeSet(m$,NewEvent,include.COMConst.$$$EnumCOMDCMDATASOURCETYPEGlobal(m$));
    //<< set $$$COMDCMEventDataSourceName(NewEvent)=pstrClass
    include.COMConst.$$$COMDCMEventDataSourceNameSet(m$,NewEvent,pstrClass.get());
    //<< do ^WWWSPEI("COMDCMEvent",pstrClass_"Save",NewEvent,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMEvent",mOp.Concat(pstrClass.get(),"Save"),NewEvent.get(),1);
    //<< 
    //<< ; Establish the Event Fields
    //<< set NewField=""
    NewField.set("");
    //<< set $$$COMDCMEventFieldsFunctionCall(NewField)=$$$ACUTE_pstrClass_$$$ACUTE
    include.COMConst.$$$COMDCMEventFieldsFunctionCallSet(m$,NewField,mOp.Concat(mOp.Concat(include.COMSYSString.$$$ACUTE(m$),pstrClass.get()),include.COMSYSString.$$$ACUTE(m$)));
    //<< set $$$COMDCMEventFieldsUsedByMethod(NewField)=1
    include.COMConst.$$$COMDCMEventFieldsUsedByMethodSet(m$,NewField,1);
    //<< do ^WWWSPEI("COMDCMEventFields",pstrClass_"Save"_$$$COMMA_"Global",NewField,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMEventFields",mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Save"),include.COMSYSString.$$$COMMA(m$)),"Global"),NewField.get(),1);
    //<< set NewField=""
    NewField.set("");
    //<< set $$$COMDCMEventFieldsFunctionCall(NewField)="%recordKeys"
    include.COMConst.$$$COMDCMEventFieldsFunctionCallSet(m$,NewField,"%recordKeys");
    //<< set $$$COMDCMEventFieldsUsedByMethod(NewField)=1
    include.COMConst.$$$COMDCMEventFieldsUsedByMethodSet(m$,NewField,1);
    //<< do ^WWWSPEI("COMDCMEventFields",pstrClass_"Save"_$$$COMMA_"Key",NewField,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMEventFields",mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Save"),include.COMSYSString.$$$COMMA(m$)),"Key"),NewField.get(),1);
    //<< set NewField=""
    NewField.set("");
    //<< set $$$COMDCMEventFieldsFunctionCall(NewField)="%recordData"
    include.COMConst.$$$COMDCMEventFieldsFunctionCallSet(m$,NewField,"%recordData");
    //<< set $$$COMDCMEventFieldsUsedByMethod(NewField)=1
    include.COMConst.$$$COMDCMEventFieldsUsedByMethodSet(m$,NewField,1);
    //<< do ^WWWSPEI("COMDCMEventFields",pstrClass_"Save"_$$$COMMA_"Data",NewField,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMEventFields",mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Save"),include.COMSYSString.$$$COMMA(m$)),"Data"),NewField.get(),1);
    //<< 
    //<< ; Establish the Event Method
    //<< set NewMethod=""
    NewMethod.set("");
    //<< set $$$COMDCMMethodCacheRoutine(NewMethod)="$$IntraprendSave^COMDCMUtilities"
    include.COMConst.$$$COMDCMMethodCacheRoutineSet(m$,NewMethod,"$$IntraprendSave^COMDCMUtilities");
    //<< 
    //<< if pblnUseClassName {
    if (mOp.Logical(pblnUseClassName.get())) {
      //<< set strSave=pstrClass_"Save"
      strSave.set(mOp.Concat(pstrClass.get(),"Save"));
    }
    //<< } else {
    else {
      //<< set strSave="COMDCMSaveIntraprendData"
      strSave.set("COMDCMSaveIntraprendData");
    }
    //<< }
    //<< do ^WWWSPEI("COMDCMMethod",pstrClass_"Save"_$$$COMMA_strSave,NewMethod,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMMethod",mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Save"),include.COMSYSString.$$$COMMA(m$)),strSave.get()),NewMethod.get(),1);
    //<< 
    //<< ; Establish the Method Parameters
    //<< set NewParam=""
    NewParam.set("");
    //<< set $$$COMDCMMethodParamParamName(NewParam)="Global"
    include.COMConst.$$$COMDCMMethodParamParamNameSet(m$,NewParam,"Global");
    //<< set $$$COMDCMMethodParamFieldName(NewParam)="Global"
    include.COMConst.$$$COMDCMMethodParamFieldNameSet(m$,NewParam,"Global");
    //<< do ^WWWSPEI("COMDCMMethodParam",pstrClass_"Save"_$$$COMMA_strSave_$$$COMMA_1,NewParam,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMMethodParam",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Save"),include.COMSYSString.$$$COMMA(m$)),strSave.get()),include.COMSYSString.$$$COMMA(m$)),1),NewParam.get(),1);
    //<< set NewParam=""
    NewParam.set("");
    //<< set $$$COMDCMMethodParamParamName(NewParam)="Key"
    include.COMConst.$$$COMDCMMethodParamParamNameSet(m$,NewParam,"Key");
    //<< set $$$COMDCMMethodParamFieldName(NewParam)="Key"
    include.COMConst.$$$COMDCMMethodParamFieldNameSet(m$,NewParam,"Key");
    //<< do ^WWWSPEI("COMDCMMethodParam",pstrClass_"Save"_$$$COMMA_strSave_$$$COMMA_2,NewParam,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMMethodParam",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Save"),include.COMSYSString.$$$COMMA(m$)),strSave.get()),include.COMSYSString.$$$COMMA(m$)),2),NewParam.get(),1);
    //<< set NewParam=""
    NewParam.set("");
    //<< set $$$COMDCMMethodParamParamName(NewParam)="Data"
    include.COMConst.$$$COMDCMMethodParamParamNameSet(m$,NewParam,"Data");
    //<< set $$$COMDCMMethodParamFieldName(NewParam)="Data"
    include.COMConst.$$$COMDCMMethodParamFieldNameSet(m$,NewParam,"Data");
    //<< do ^WWWSPEI("COMDCMMethodParam",pstrClass_"Save"_$$$COMMA_strSave_$$$COMMA_3,NewParam,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMMethodParam",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Save"),include.COMSYSString.$$$COMMA(m$)),strSave.get()),include.COMSYSString.$$$COMMA(m$)),3),NewParam.get(),1);
    //<< 
    //<< ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    //<< ; Establish the Delete event
    //<< ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    //<< set NewEvent=""
    NewEvent.set("");
    //<< set $$$COMDCMEventDescription(NewEvent)="delete the "_pstrClass_" structure"
    include.COMConst.$$$COMDCMEventDescriptionSet(m$,NewEvent,mOp.Concat(mOp.Concat("delete the ",pstrClass.get())," structure"));
    //<< set $$$COMDCMEventEventType(NewEvent)=$$$EnumCOMDCMEVENTTYPEDelete
    include.COMConst.$$$COMDCMEventEventTypeSet(m$,NewEvent,include.COMConst.$$$EnumCOMDCMEVENTTYPEDelete(m$));
    //<< set $$$COMDCMEventDataSourceType(NewEvent)=$$$EnumCOMDCMDATASOURCETYPEGlobal
    include.COMConst.$$$COMDCMEventDataSourceTypeSet(m$,NewEvent,include.COMConst.$$$EnumCOMDCMDATASOURCETYPEGlobal(m$));
    //<< set $$$COMDCMEventDataSourceName(NewEvent)=pstrClass
    include.COMConst.$$$COMDCMEventDataSourceNameSet(m$,NewEvent,pstrClass.get());
    //<< do ^WWWSPEI("COMDCMEvent",pstrClass_"Delete",NewEvent,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMEvent",mOp.Concat(pstrClass.get(),"Delete"),NewEvent.get(),1);
    //<< 
    //<< ; Establish the Event Fields
    //<< set NewField=""
    NewField.set("");
    //<< set $$$COMDCMEventFieldsFunctionCall(NewField)=$$$ACUTE_pstrClass_$$$ACUTE
    include.COMConst.$$$COMDCMEventFieldsFunctionCallSet(m$,NewField,mOp.Concat(mOp.Concat(include.COMSYSString.$$$ACUTE(m$),pstrClass.get()),include.COMSYSString.$$$ACUTE(m$)));
    //<< set $$$COMDCMEventFieldsUsedByMethod(NewField)=1
    include.COMConst.$$$COMDCMEventFieldsUsedByMethodSet(m$,NewField,1);
    //<< do ^WWWSPEI("COMDCMEventFields",pstrClass_"Delete"_$$$COMMA_"Global",NewField,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMEventFields",mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Delete"),include.COMSYSString.$$$COMMA(m$)),"Global"),NewField.get(),1);
    //<< set NewField=""
    NewField.set("");
    //<< set $$$COMDCMEventFieldsFunctionCall(NewField)="%recordKeys"
    include.COMConst.$$$COMDCMEventFieldsFunctionCallSet(m$,NewField,"%recordKeys");
    //<< set $$$COMDCMEventFieldsUsedByMethod(NewField)=1
    include.COMConst.$$$COMDCMEventFieldsUsedByMethodSet(m$,NewField,1);
    //<< do ^WWWSPEI("COMDCMEventFields",pstrClass_"Delete"_$$$COMMA_"Key",NewField,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMEventFields",mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Delete"),include.COMSYSString.$$$COMMA(m$)),"Key"),NewField.get(),1);
    //<< 
    //<< ; Establish the Event Method
    //<< set NewMethod=""
    NewMethod.set("");
    //<< if pblnUseClassName {
    if (mOp.Logical(pblnUseClassName.get())) {
      //<< set strDelete=pstrClass_"Delete"
      strDelete.set(mOp.Concat(pstrClass.get(),"Delete"));
    }
    //<< } else {
    else {
      //<< set strDelete="COMDCMDeleteIntraprendData"
      strDelete.set("COMDCMDeleteIntraprendData");
    }
    //<< }
    //<< set $$$COMDCMMethodCacheRoutine(NewMethod)="$$IntraprendDelete^COMDCMUtilities"
    include.COMConst.$$$COMDCMMethodCacheRoutineSet(m$,NewMethod,"$$IntraprendDelete^COMDCMUtilities");
    //<< do ^WWWSPEI("COMDCMMethod",pstrClass_"Delete"_$$$COMMA_strDelete,NewMethod,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMMethod",mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Delete"),include.COMSYSString.$$$COMMA(m$)),strDelete.get()),NewMethod.get(),1);
    //<< 
    //<< ; Establish the Method Parameters
    //<< set NewParam=""
    NewParam.set("");
    //<< set $$$COMDCMMethodParamParamName(NewParam)="Global"
    include.COMConst.$$$COMDCMMethodParamParamNameSet(m$,NewParam,"Global");
    //<< set $$$COMDCMMethodParamFieldName(NewParam)="Global"
    include.COMConst.$$$COMDCMMethodParamFieldNameSet(m$,NewParam,"Global");
    //<< do ^WWWSPEI("COMDCMMethodParam",pstrClass_"Delete"_$$$COMMA_strDelete_$$$COMMA_1,NewParam,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMMethodParam",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Delete"),include.COMSYSString.$$$COMMA(m$)),strDelete.get()),include.COMSYSString.$$$COMMA(m$)),1),NewParam.get(),1);
    //<< set NewParam=""
    NewParam.set("");
    //<< set $$$COMDCMMethodParamParamName(NewParam)="Key"
    include.COMConst.$$$COMDCMMethodParamParamNameSet(m$,NewParam,"Key");
    //<< set $$$COMDCMMethodParamFieldName(NewParam)="Key"
    include.COMConst.$$$COMDCMMethodParamFieldNameSet(m$,NewParam,"Key");
    //<< do ^WWWSPEI("COMDCMMethodParam",pstrClass_"Delete"_$$$COMMA_strDelete_$$$COMMA_2,NewParam,1)
    m$.Cmd.Do("WWWSPEI.main","COMDCMMethodParam",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrClass.get(),"Delete"),include.COMSYSString.$$$COMMA(m$)),strDelete.get()),include.COMSYSString.$$$COMMA(m$)),2),NewParam.get(),1);
    //<< 
    //<< quit "All ok"
    return "All ok";
  }

  //<< 
  //<< getCurrentWebHostname()
  public Object getCurrentWebHostname(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Function to return the Hostname component of the current Sites URL
    //<< ;-------------------------------------------------------------------------------
    //<< new hostname,objLocation,sitename,siteURL,UrlComponents
    mVar hostname = m$.var("hostname");
    mVar objLocation = m$.var("objLocation");
    mVar sitename = m$.var("sitename");
    mVar siteURL = m$.var("siteURL");
    mVar UrlComponents = m$.var("UrlComponents");
    m$.newVar(hostname,objLocation,sitename,siteURL,UrlComponents);
    //<< 
    //<< set hostname=""
    hostname.set("");
    //<< set sitename=$$getCurrentLocation^COMDCMUtilities()
    sitename.set(m$.fnc$("COMDCMUtilities.getCurrentLocation"));
    //<< if ($get(sitename)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(sitename),""))) {
      //<< set objLocation=$get(^COMDCMLocation(0,sitename,1))
      objLocation.set(m$.Fnc.$get(m$.var("^COMDCMLocation",0,sitename.get(),1)));
      //<< set siteURL=$$$COMDCMLocationURLPath(objLocation)
      siteURL.set(include.COMConst.$$$COMDCMLocationURLPath(m$,objLocation));
      //<< do ##class(%Net.URLParser).Parse(siteURL,.UrlComponents)
      m$.Cmd.Do("$Net.URLParser.Parse",siteURL.get(),UrlComponents);
      //<< set hostname=$get(UrlComponents("host"))
      hostname.set(m$.Fnc.$get(UrlComponents.var("host")));
    }
    //<< }
    //<< 
    //<< quit hostname
    return hostname.get();
  }

  //<< 
  //<< getPackageName(Name)
  public Object getPackageName(Object ... _p) {
    mVar Name = m$.newVarRef("Name",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Function to return a suitable package name
    //<< ;-------------------------------------------------------------------------------
    //<< quit (##class(%SOAP.WebBase).NormalizeName(Name,25))
    return (m$.fnc$("$SOAP.WebBase.NormalizeName",Name.get(),25));
  }

//<< 
//<< 
}
