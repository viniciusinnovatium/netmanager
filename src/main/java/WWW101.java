//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW101
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:13
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

//<< WWW101
public class WWW101 extends mClass {

  public void main() {
    _WWW101();
  }

  public void _WWW101() {
  }

  //<< 
  //<< OnAfterPrimaryKey(YKEY="")
  public Object OnAfterPrimaryKey(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check if there are any UOM parameters that are marked to distribute when there
    //<< ; shouldn't be.  Report only the first occurence.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Feb-2010   GRF     -: not strStatus, rework as blnStop
    //<< ; 16-Nov-2009   DWR     SR16955: layout - no programming changes
    //<< ; 20-Oct-2009   shobby  SR16955: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnStop,idLanguage,idUnit,objWWW101
    mVar blnStop = m$.var("blnStop");
    mVar idLanguage = m$.var("idLanguage");
    mVar idUnit = m$.var("idUnit");
    mVar objWWW101 = m$.var("objWWW101");
    m$.newVar(blnStop,idLanguage,idUnit,objWWW101);
    //<< 
    //<< if ($$$KEY1(YKEY)="EINHEIT") && ($$$DEVMODE) {  ; Only applicable in development environment
    if ((mOp.Equal(include.COMSYSWWW.$$$KEY1(m$,YKEY),"EINHEIT")) && mOp.Logical((include.COMSYS.$$$DEVMODE(m$)))) {
      //<< set blnStop  = $$$NO
      blnStop.set(include.COMSYS.$$$NO(m$));
      //<< set idLanguage = ""
      idLanguage.set("");
      //<< for {
      for (;true;) {
        //<< set idLanguage = $order(^WWW101(0,"EINHEIT",idLanguage))
        idLanguage.set(m$.Fnc.$order(m$.var("^WWW101",0,"EINHEIT",idLanguage.get())));
        //<< quit:idLanguage=""
        if (mOp.Equal(idLanguage.get(),"")) {
          break;
        }
        //<< 
        //<< set idUnit = ""
        idUnit.set("");
        //<< for {
        for (;true;) {
          //<< set idUnit = $order(^WWW101(0,"EINHEIT",idLanguage,idUnit))
          idUnit.set(m$.Fnc.$order(m$.var("^WWW101",0,"EINHEIT",idLanguage.get(),idUnit.get())));
          //<< quit:idUnit=""
          if (mOp.Equal(idUnit.get(),"")) {
            break;
          }
          //<< 
          //<< set objWWW101 = $get(^WWW101(0,"EINHEIT",idLanguage,idUnit,1))
          objWWW101.set(m$.Fnc.$get(m$.var("^WWW101",0,"EINHEIT",idLanguage.get(),idUnit.get(),1)));
          //<< if $$$WWW101SendForNewVersion(objWWW101) &&
          //<< ((idUnit>49) || (+idUnit'=idUnit))       {
          if (mOp.Logical(include.WWWConst.$$$WWW101SendForNewVersion(m$,objWWW101)) && mOp.Logical(((mOp.Greater(idUnit.get(),49)) || (mOp.NotEqual(mOp.Positive(idUnit.get()),idUnit.get()))))) {
            //<< 
            //<< write "<FONT color=red>"_$$$Text($listbuild("WWW00128",idLanguage_","_idUnit_"="_$$$WWW101Text(objWWW101)))_"</FONT>"
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT color=red>",include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("WWW00128",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idLanguage.get(),","),idUnit.get()),"="),include.WWWConst.$$$WWW101Text(m$,objWWW101))))),"</FONT>"));
            //<< ; "Warning! Parameter %1 is out of range for a Parameter marked as 'Send For New Version'.  (Numeric id less than 50)."
            //<< set blnStop = $$$YES
            blnStop.set(include.COMSYS.$$$YES(m$));
          }
          //<< }
          //<< quit:blnStop
          if (mOp.Logical(blnStop.get())) {
            break;
          }
        }
        //<< }
        //<< quit:blnStop
        if (mOp.Logical(blnStop.get())) {
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeDataAccess(YFORM="",YKEY="",YFELD="")
  public Object OnBeforeDataAccess(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Limit values in the list
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRef: YKEYCONTAINER - for form WWWDataExMessageRulesD
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-May-2011   PPP     SR17752: "INDispenseToPatient" - Cut the list only to 1 - Inter Departmental,3 - Dispense Sale
    //<< ; 14-Aug-2009   shobby  SR16791: More generic method to exclude items from dropdowns.
    //<< ; 27-Mar-2009   shobby  SR16437: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if YFORM="WWWDataExMessageRulesD" {
    if (mOp.Equal(YFORM.get(),"WWWDataExMessageRulesD")) {
      //<< set strStatus = $$OnBeforeDataAccessTest^WWWDataExMessageRulesD(YKEY,YFELD,YKEYCONTAINER)
      strStatus.set(m$.fnc$("WWWDataExMessageRulesD.OnBeforeDataAccessTest",YKEY.get(),YFELD.get(),m$.var("YKEYCONTAINER").get()));
    }
    //<< 
    //<< //SR17752
    //<< } elseif (YFORM="INDispenseToPatient") {
    else if ((mOp.Equal(YFORM.get(),"INDispenseToPatient"))) {
      //<< //1 - Inter Departmental
      //<< //3 - Dispense Sale
      //<< set strStatus = ((",1,3,")[(","_$$$KEY3(YKEY)_","))
      strStatus.set((mOp.Contains((",1,3,"),(mOp.Concat(mOp.Concat(",",include.COMSYSWWW.$$$KEY3(m$,YKEY)),",")))));
    }
    //<< 
    //<< } elseif (YFORM'="") {
    else if ((mOp.NotEqual(YFORM.get(),""))) {
      //<< if $data(^rOBJ(YFORM_"OBDA")) xecute "set strStatus=$$OnBeforeDataAccess^"_YFORM_"OBDA(YKEY,YFELD)"
      if (mOp.Logical(m$.Fnc.$data(m$.var("^rOBJ",mOp.Concat(YFORM.get(),"OBDA"))))) {
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat("set strStatus=$$OnBeforeDataAccess^",YFORM.get()),"OBDA(YKEY,YFELD)"));
      }
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< Check(pidDate="",pidSeries="")
  public Object Check(Object ... _p) {
    mVar pidDate = m$.newVarRef("pidDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidSeries = m$.newVarRef("pidSeries",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Compares application parameters before and after an upgrade to list
    //<< ; those that have changed.  Useful for determining parameters that are
    //<< ; distributed but really shouldn't have been.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Jun-2009   GRF     Refactor $order macros
    //<< ; 09-Apr-2007   shobby  SRBR014354: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idDate,idSeries,idDescription,idLanguage,idKey,objWWW101,objWWW101BACKUP
    mVar idDate = m$.var("idDate");
    mVar idSeries = m$.var("idSeries");
    mVar idDescription = m$.var("idDescription");
    mVar idLanguage = m$.var("idLanguage");
    mVar idKey = m$.var("idKey");
    mVar objWWW101 = m$.var("objWWW101");
    mVar objWWW101BACKUP = m$.var("objWWW101BACKUP");
    m$.newVar(idDate,idSeries,idDescription,idLanguage,idKey,objWWW101,objWWW101BACKUP);
    //<< 
    //<< kill ^CacheTempWWW101Check
    m$.var("^CacheTempWWW101Check").kill();
    //<< if $get(Y)'="" do ^WWWVAR
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< 
    //<< if pidDate="" {
    if (mOp.Equal(pidDate.get(),"")) {
      //<< set idDate = $order(^WWW101BACKUP(0,""),-1)
      idDate.set(m$.Fnc.$order(m$.var("^WWW101BACKUP",0,""),mOp.Negative(1)));
    }
    //<< } else {
    else {
      //<< set idDate = pidDate
      idDate.set(pidDate.get());
    }
    //<< }
    //<< 
    //<< if pidSeries="" {
    if (mOp.Equal(pidSeries.get(),"")) {
      //<< set idSeries = $order(^WWW101BACKUP(0,idDate,""),-1)
      idSeries.set(m$.Fnc.$order(m$.var("^WWW101BACKUP",0,idDate.get(),""),mOp.Negative(1)));
    }
    //<< } else {
    else {
      //<< set idSeries = pidSeries
      idSeries.set(pidSeries.get());
    }
    //<< }
    //<< 
    //<< if (idDate'="") && (idSeries'="") {
    if ((mOp.NotEqual(idDate.get(),"")) && (mOp.NotEqual(idSeries.get(),""))) {
      //<< set idDescription = ""
      idDescription.set("");
      //<< for {
      for (;true;) {
        //<< set idDescription = $order(^WWW101(0,idDescription))
        idDescription.set(m$.Fnc.$order(m$.var("^WWW101",0,idDescription.get())));
        //<< quit:idDescription=""
        if (mOp.Equal(idDescription.get(),"")) {
          break;
        }
        //<< 
        //<< set idLanguage = ""
        idLanguage.set("");
        //<< for {
        for (;true;) {
          //<< set idLanguage = $order(^WWW101(0,idDescription,idLanguage))
          idLanguage.set(m$.Fnc.$order(m$.var("^WWW101",0,idDescription.get(),idLanguage.get())));
          //<< quit:idLanguage=""
          if (mOp.Equal(idLanguage.get(),"")) {
            break;
          }
          //<< 
          //<< set idKey = ""
          idKey.set("");
          //<< for {
          for (;true;) {
            //<< set idKey = $order(^WWW101(0,idDescription,idLanguage,idKey))
            idKey.set(m$.Fnc.$order(m$.var("^WWW101",0,idDescription.get(),idLanguage.get(),idKey.get())));
            //<< quit:idKey=""
            if (mOp.Equal(idKey.get(),"")) {
              break;
            }
            //<< 
            //<< set objWWW101       = $get(^WWW101(0,idDescription,idLanguage,idKey,1))
            objWWW101.set(m$.Fnc.$get(m$.var("^WWW101",0,idDescription.get(),idLanguage.get(),idKey.get(),1)));
            //<< set objWWW101BACKUP = $get(^WWW101BACKUP(0,idDate,idSeries,idDescription,idLanguage,idKey,1))
            objWWW101BACKUP.set(m$.Fnc.$get(m$.var("^WWW101BACKUP",0,idDate.get(),idSeries.get(),idDescription.get(),idLanguage.get(),idKey.get(),1)));
            //<< if objWWW101'=objWWW101BACKUP {
            if (mOp.NotEqual(objWWW101.get(),objWWW101BACKUP.get())) {
              //<< set ^CacheTempWWW101Check(0,idDate,idSeries,idDescription,idLanguage,idKey,"BACKUP") = objWWW101BACKUP
              m$.var("^CacheTempWWW101Check",0,idDate.get(),idSeries.get(),idDescription.get(),idLanguage.get(),idKey.get(),"BACKUP").set(objWWW101BACKUP.get());
              //<< set ^CacheTempWWW101Check(0,idDate,idSeries,idDescription,idLanguage,idKey,"NEW   ") = objWWW101
              m$.var("^CacheTempWWW101Check",0,idDate.get(),idSeries.get(),idDescription.get(),idLanguage.get(),idKey.get(),"NEW   ").set(objWWW101.get());
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< set idDescription = ""
      idDescription.set("");
      //<< for {
      for (;true;) {
        //<< set idDescription = $order(^WWW101BACKUP(0,idDate,idSeries,idDescription))
        idDescription.set(m$.Fnc.$order(m$.var("^WWW101BACKUP",0,idDate.get(),idSeries.get(),idDescription.get())));
        //<< quit:idDescription=""
        if (mOp.Equal(idDescription.get(),"")) {
          break;
        }
        //<< 
        //<< set idLanguage = ""
        idLanguage.set("");
        //<< for {
        for (;true;) {
          //<< set idLanguage = $order(^WWW101BACKUP(0,idDate,idSeries,idDescription,idLanguage))
          idLanguage.set(m$.Fnc.$order(m$.var("^WWW101BACKUP",0,idDate.get(),idSeries.get(),idDescription.get(),idLanguage.get())));
          //<< quit:idLanguage=""
          if (mOp.Equal(idLanguage.get(),"")) {
            break;
          }
          //<< 
          //<< set idKey = ""
          idKey.set("");
          //<< for {
          for (;true;) {
            //<< set idKey = $order(^WWW101BACKUP(idDate,idSeries,0,idDescription,idLanguage,idKey))
            idKey.set(m$.Fnc.$order(m$.var("^WWW101BACKUP",idDate.get(),idSeries.get(),0,idDescription.get(),idLanguage.get(),idKey.get())));
            //<< quit:idKey=""
            if (mOp.Equal(idKey.get(),"")) {
              break;
            }
            //<< 
            //<< set objWWW101       = $get(^WWW101(0,idDescription,idLanguage,idKey,1))
            objWWW101.set(m$.Fnc.$get(m$.var("^WWW101",0,idDescription.get(),idLanguage.get(),idKey.get(),1)));
            //<< set objWWW101BACKUP = $get(^WWW101BACKUP(0,idDate,idSeries,idDescription,idLanguage,idKey,1))
            objWWW101BACKUP.set(m$.Fnc.$get(m$.var("^WWW101BACKUP",0,idDate.get(),idSeries.get(),idDescription.get(),idLanguage.get(),idKey.get(),1)));
            //<< if objWWW101'=objWWW101BACKUP {
            if (mOp.NotEqual(objWWW101.get(),objWWW101BACKUP.get())) {
              //<< set ^CacheTempWWW101Check(0,idDate,idSeries,idDescription,idLanguage,idKey,"BACKUP") = objWWW101BACKUP
              m$.var("^CacheTempWWW101Check",0,idDate.get(),idSeries.get(),idDescription.get(),idLanguage.get(),idKey.get(),"BACKUP").set(objWWW101BACKUP.get());
              //<< set ^CacheTempWWW101Check(0,idDate,idSeries,idDescription,idLanguage,idKey,"NEW   ") = objWWW101
              m$.var("^CacheTempWWW101Check",0,idDate.get(),idSeries.get(),idDescription.get(),idLanguage.get(),idKey.get(),"NEW   ").set(objWWW101.get());
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
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterButtonLine(pidWWW101="")
  public Object OnAfterButtonLine(Object ... _p) {
    mVar pidWWW101 = m$.newVarRef("pidWWW101",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Recovers YVOR value
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Jun-2009   GRF     SR16598: Authorization Macro
    //<< ; 05-May-2007   Karine  BR014574: Disable change parameters in english
    //<< ; 16-May-2007   HeberB  SRBR014447: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set $$$WWW120AuthorizationToModifyData(YVOR) = $get(^CacheTempWWW101Enabled(YUCI,YUSER))
    include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),m$.Fnc.$get(m$.var("^CacheTempWWW101Enabled",m$.var("YUCI").get(),m$.var("YUSER").get())));
    //<< kill ^CacheTempWWW101Enabled(YUCI,YUSER)
    m$.var("^CacheTempWWW101Enabled",m$.var("YUCI").get(),m$.var("YUSER").get()).kill();
    //<< ;BR014574  vvv
    //<< ;IF $$$KEY2(YKEY) = "EN" {
    //<< ;       set $$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly
    //<< ;}
    //<< ;BR014574 ^^^
    //<< quit
    return null;
  }

  //<< 
  //<< OnBeforeButtonLine(pidWWW101="")
  public Object OnBeforeButtonLine(Object ... _p) {
    mVar pidWWW101 = m$.newVarRef("pidWWW101",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Backup YVOR value and sets RO/RW
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Jun-2009   GRF     SR16598: Authorization Macro
    //<< ; 09-Jul-2007   GM      SRBR014574: Call routine to let fields read only
    //<< ; 16-May-2007   HeberB  SRBR014447: Created
    //<< ;-------------------------------------------------------------------------------
    //<< do ReadOnly^WWWFORM("TSUtilityApplicationParameter") ;BR014574
    m$.Cmd.Do("WWWFORM.ReadOnly","TSUtilityApplicationParameter");
    //<< 
    //<< set ^CacheTempWWW101Enabled(YUCI,YUSER) = $$$WWW120AuthorizationToModifyData(YVOR)
    m$.var("^CacheTempWWW101Enabled",m$.var("YUCI").get(),m$.var("YUSER").get()).set(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")));
    //<< if $get(pidWWW101)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidWWW101),"")) {
      //<< if '$$EnableDisableField(pidWWW101) {
      if (mOp.Not(m$.fnc$("EnableDisableField",pidWWW101.get()))) {
        //<< set $$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly
        include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< EnableDisableField(pidWWW101="")
  public Object EnableDisableField(Object ... _p) {
    mVar pidWWW101 = m$.newVarRef("pidWWW101",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Restrict Create of Application Parameters
    //<< ;
    //<< ; If the ^SysSetup("Edit","ApplicationParameters") flag *IS NOT* set then
    //<< ;   1) The WWW101 screen is read only for all application parameters
    //<< ;        that are not EINHEIT/BERECHTIGUNG.
    //<< ;   2) When the application parameter is EINHEIT/BERECHTIGUNG the screen is read
    //<< ;        only for application parameters with an ID less than 50/100.
    //<< ;   3) When the application parameter is EINHEIT/BERECHTIGUNG the screen is editable
    //<< ;      for application parameters with an ID greater or equal to 50/100.
    //<< ;   4) When the ^SysSetup flag is not set the reverse is true.
    //<< ;
    //<< ;       ^SysSetup("Edit","ApplicationParameters")
    //<< ;               =0 (Var)        =1 (Dev)
    //<< ;           EINH  'EINH     EINH  'EINH
    //<< ;   <50      RO     RO      RW      RW
    //<< ;   >=50     RW     RO      RO      RW
    //<< ;   EMPTY    RW     RO      RW      RW
    //<< ;           BERE  'BERE     BERE  'BERE
    //<< ;   <100     RO     RO      RW      RW
    //<< ;   >=100    RW     RO      RO      RW
    //<< ;   EMPTY    RW     RO      RW      RW
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Jun-2009   GRF     SR16598: Clear old commented code; clarify if tests
    //<< ; 27-Jun-2007   RPW     SRBR014554: Use a variable instead of recalculating IsValidNum
    //<< ; 25-Jun-2007   HeberB  SRBR014554: Added BERECHTIGUNG >=100 and updated doco above
    //<< ; 21-Jun-2007   HeberB  SRBR014523: Deal with app.param char as >= 50
    //<< ; 16-May-2007   HeberB  SRBR014447: Amend doco above and deals with empty KEY3
    //<< ; 14-May-2007   GRF     SRBR014447: Amend doco above
    //<< ; 09-May-2007   RPW     SRBR014447: Use good global, not ^Development
    //<< ; 03-May-2007   HeberB  SRBR014447: Logic corrected
    //<< ; 27-Apr-2007   HeberB  SRBR014447: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnEditable,blnKey3Valid
    mVar blnEditable = m$.var("blnEditable");
    mVar blnKey3Valid = m$.var("blnKey3Valid");
    m$.newVar(blnEditable,blnKey3Valid);
    //<< 
    //<< set YHID = 0    // Enable field
    mVar YHID = m$.var("YHID");
    YHID.set(0);
    //<< ; on edition
    //<< quit:($$$KEY1(pidWWW101) = "") $$$YES
    if ((mOp.Equal(include.COMSYSWWW.$$$KEY1(m$,pidWWW101),""))) {
      return include.COMSYS.$$$YES(m$);
    }
    //<< 
    //<< set blnEditable = $$$NO
    blnEditable.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if ($$$KEY3(pidWWW101) = "") {
    if ((mOp.Equal(include.COMSYSWWW.$$$KEY3(m$,pidWWW101),""))) {
      //<< if '( ($$$KEY1(pidWWW101)'="EINHEIT")                       &&
      //<< ($$$KEY1(pidWWW101)'="BERECHTIGUNG")                  &&
      //<< ($get(^SysSetup("Edit","ApplicationParameters")) = 0) )  {
      if (mOp.Not(((mOp.NotEqual(include.COMSYSWWW.$$$KEY1(m$,pidWWW101),"EINHEIT")) && (mOp.NotEqual(include.COMSYSWWW.$$$KEY1(m$,pidWWW101),"BERECHTIGUNG")) && (mOp.Equal(m$.Fnc.$get(m$.var("^SysSetup","Edit","ApplicationParameters")),0))))) {
        //<< set blnEditable = $$$YES
        blnEditable.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set blnKey3Valid = $ISVALIDNUM($$$KEY3(pidWWW101))
      blnKey3Valid.set(m$.Fnc.$isvalidnum(include.COMSYSWWW.$$$KEY3(m$,pidWWW101)));
      //<< 
      //<< if ($$$KEY1(pidWWW101)="EINHEIT") {
      if ((mOp.Equal(include.COMSYSWWW.$$$KEY1(m$,pidWWW101),"EINHEIT"))) {
        //<< if ($$$KEY3(pidWWW101) >= "50") || 'blnKey3Valid   set blnEditable  = $$$YES  ; SR16598
        if ((mOp.GreaterOrEqual(include.COMSYSWWW.$$$KEY3(m$,pidWWW101),"50")) || mOp.Not(blnKey3Valid.get())) {
          blnEditable.set(include.COMSYS.$$$YES(m$));
        }
      }
      //<< }
      //<< if ($$$KEY1(pidWWW101)="BERECHTIGUNG") {
      if ((mOp.Equal(include.COMSYSWWW.$$$KEY1(m$,pidWWW101),"BERECHTIGUNG"))) {
        //<< if ($$$KEY3(pidWWW101) >= "100") || 'blnKey3Valid  set blnEditable  = $$$YES  ; SR16598
        if ((mOp.GreaterOrEqual(include.COMSYSWWW.$$$KEY3(m$,pidWWW101),"100")) || mOp.Not(blnKey3Valid.get())) {
          blnEditable.set(include.COMSYS.$$$YES(m$));
        }
      }
      //<< }
      //<< if ($get(^SysSetup("Edit","ApplicationParameters")) = 1) {       //  doesn't need quotes
      if ((mOp.Equal(m$.Fnc.$get(m$.var("^SysSetup","Edit","ApplicationParameters")),1))) {
        //<< set blnEditable  = 'blnEditable
        blnEditable.set(mOp.Not(blnEditable.get()));
      }
    }
    //<< }
    //<< }
    //<< if 'blnEditable {
    if (mOp.Not(blnEditable.get())) {
      //<< set YHID = 2 // Disable field
      YHID.set(2);
    }
    //<< }
    //<< quit blnEditable
    return blnEditable.get();
  }

  //<< 
  //<< 
  //<< OnBeforeSave(pidWWW101="")
  public Object OnBeforeSave(Object ... _p) {
    mVar pidWWW101 = m$.newVarRef("pidWWW101",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;  Do not allow creation of non-EINHEIT records.
    //<< ;  Allow creation of EINHEIT but disallow save when ID is less than 50.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 17-May-2007   HeberB      SRBR014447: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set Q = $$$QSave
    mVar Q = m$.var("Q");
    Q.set(include.COMSYSWWW.$$$QSave(m$));
    //<< if $get(pidWWW101)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidWWW101),"")) {
      //<< if '$$EnableDisableField(pidWWW101) {
      if (mOp.Not(m$.fnc$("EnableDisableField",pidWWW101.get()))) {
        //<< set Q = $$$QDontSave
        Q.set(include.COMSYSWWW.$$$QDontSave(m$));
        //<< $$$Alert(33426)            ; "The entered data has not been saved!"
        include.COMSYS.$$$Alert(m$,33426);
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Get(pstrParam,pstrLang,pstrCode)
  public Object Get(Object ... _p) {
    mVar pstrParam = m$.newVarRef("pstrParam",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrLang = m$.newVarRef("pstrLang",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< quit $get(^WWW101(0,pstrParam,pstrLang,pstrCode,1))
    return m$.Fnc.$get(m$.var("^WWW101",0,pstrParam.get(),pstrLang.get(),pstrCode.get(),1));
  }

  //<< 
  //<< 
  //<< OnDataAccess(YKEY,YFORM,pstrParam)
  public Object OnDataAccess(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrParam = m$.newVarRef("pstrParam",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ;                 PROTOTYPING - IN DEVELOPMENT - GRF
    //<< ;
    //<< ;
    //<< ;   Add the following to the Class Call Backs for WWW101 to activate
    //<< ;  $$OnDataAccess^WWW101(YKEY,YFORM,$g(VORG(1)))
    //<< ;
    //<< ;  VORG(1) is based on the "Input In Variable" for INRECSummary : Item
    //<< ;
    //<< ;  NOTE : not called for grid.
    //<< ;-------------------------------------------------------------------------------
    //<< new blnResult,enumValue,idLanguage,idParam
    mVar blnResult = m$.var("blnResult");
    mVar enumValue = m$.var("enumValue");
    mVar idLanguage = m$.var("idLanguage");
    mVar idParam = m$.var("idParam");
    m$.newVar(blnResult,enumValue,idLanguage,idParam);
    //<< 
    //<< set idParam    = $$$KEY1(YKEY)
    idParam.set(include.COMSYSWWW.$$$KEY1(m$,YKEY));
    //<< set idLanguage = $$$KEY2(YKEY)
    idLanguage.set(include.COMSYSWWW.$$$KEY2(m$,YKEY));
    //<< set enumValue  = $$$KEY3(YKEY)
    enumValue.set(include.COMSYSWWW.$$$KEY3(m$,YKEY));
    //<< set blnResult  = $$$YES
    blnResult.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< if idParam = "EINHEIT" {
    if (mOp.Equal(idParam.get(),"EINHEIT")) {
      //<< if YFORM="INRECSummary" {
      if (mOp.Equal(YFORM.get(),"INRECSummary")) {
        //<< if pstrParam'="" {
        if (mOp.NotEqual(pstrParam.get(),"")) {
          //<< set blnResult = ''$data(^INARTPACK(0,"FSM",enumValue,1))
          blnResult.set(mOp.Not(mOp.Not(m$.Fnc.$data(m$.var("^INARTPACK",0,"FSM",enumValue.get(),1)))));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit blnResult
    return blnResult.get();
  }

//<< 
//<< 
}
