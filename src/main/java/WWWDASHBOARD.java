//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWDASHBOARD
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:16
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

//<< WWWDASHBOARD
public class WWWDASHBOARD extends mClass {

  public void main() {
    _WWWDASHBOARD();
  }

  public void _WWWDASHBOARD() {
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; ( ) Standard Currency                       AUD   1                     * 1 *
  //<< ; ( ) Entity Setup       THIS NAMESPACE       XXX   XXX                   * 2 *
  //<< ; ( ) Entity Setup       LiveNamespace        XXX   XXX                   * 2 *
  //<< ; ( ) Entity Setup       TestNamespace        XXX   XXX                   * 2 *
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< OnAfterDataFields()
  public Object OnAfterDataFields(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Sep-2011   shobby  SR17835: Internationalised some text.
    //<< ; 19-Jul-2011   shobby  SR17835: CheckBudget
    //<< ; 08-Feb-2011   shobby  SR17657: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCurrency,strImage,strText,YKEY,YTOOLTIP
    mVar idCurrency = m$.var("idCurrency");
    mVar strImage = m$.var("strImage");
    mVar strText = m$.var("strText");
    mVar YKEY = m$.var("YKEY");
    mVar YTOOLTIP = m$.var("YTOOLTIP");
    m$.newVar(idCurrency,strImage,strText,YKEY,YTOOLTIP);
    //<< 
    //<< kill ^WWWDASHBOARD
    m$.var("^WWWDASHBOARD").kill();
    //<< set idCurrency = $$StandardCurrency()
    idCurrency.set(m$.fnc$("StandardCurrency"));
    //<< 
    //<< write "<TABLE>"
    m$.Cmd.Write("<TABLE>");
    //<< 
    //<< ;---------------------------------------
    //<< ; 34458     "'%1' field in the '%2' screen must be '%3'."
    //<< ; WWW00148  "Must have at least one 'Transaction Type' of type 'Budget'."
    //<< ; WWW00151  "Transaction Types"
    //<< ; WWW00149  "Session IDs should have a regularly scheduled tasks to clear out old records.||do ##class(alWEB.WS.Session).ClearSessions()"
    //<< ; WWW00150  "SessionIDs"
    //<< ;---------------------------------------
    //<< ;  * 1 * Currency Test
    //<< ;---------------------------------------
    //<< do MessageLine^WWWDASHBOARDEntity($$CheckStandardCurrency(),$$$Text($listbuild(34358,$$^WWWFELDNAME("WWWWAE","D",5),$$^WWWFORMNAME("WWWWAE"),1)),$$^WWWFELDNAME("WWW012","D",75),"",idCurrency,+$$UnitPrice(idCurrency),"WWW012") ;SR17835
    m$.Cmd.Do("WWWDASHBOARDEntity.MessageLine",m$.fnc$("CheckStandardCurrency"),include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild(34358,m$.fnc$("WWWFELDNAME.main","WWWWAE","D",5),m$.fnc$("WWWFORMNAME.main","WWWWAE"),1)),m$.fnc$("WWWFELDNAME.main","WWW012","D",75),"",idCurrency.get(),mOp.Positive(m$.fnc$("UnitPrice",idCurrency.get())),"WWW012");
    //<< 
    //<< ;---------------------------------------
    //<< ;  * 2 * Dataset Test - may be multiple lines
    //<< ;---------------------------------------
    //<< do Message^WWWDASHBOARDEntity()
    m$.Cmd.Do("WWWDASHBOARDEntity.Message");
    //<< do MessageLine^WWWDASHBOARDEntity($$CheckBudget()    ,$$$Text("WWW00148"),$$$Text("WWW00151"),"+","*","","FINGLTranType") ;SR17835
    m$.Cmd.Do("WWWDASHBOARDEntity.MessageLine",m$.fnc$("CheckBudget"),include.COMSYS.$$$Text(m$,"WWW00148"),include.COMSYS.$$$Text(m$,"WWW00151"),"+","*","","FINGLTranType");
    //<< do MessageLine^WWWDASHBOARDEntity($$CheckSessionIDs(),$$$Text("WWW00149"),$$$Text("WWW00150"),"+","*","","COMSchedule")   ;SR17835
    m$.Cmd.Do("WWWDASHBOARDEntity.MessageLine",m$.fnc$("CheckSessionIDs"),include.COMSYS.$$$Text(m$,"WWW00149"),include.COMSYS.$$$Text(m$,"WWW00150"),"+","*","","COMSchedule");
    //<< write "</TABLE>"
    m$.Cmd.Write("</TABLE>");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ; ******************* Checks ********************************
  //<< CheckSessionIDs()
  public Object CheckSessionIDs(Object ... _p) {
    //<< ;SR17778
    //<< new blnFound,idSchedule,objSchedule
    mVar blnFound = m$.var("blnFound");
    mVar idSchedule = m$.var("idSchedule");
    mVar objSchedule = m$.var("objSchedule");
    m$.newVar(blnFound,idSchedule,objSchedule);
    //<< 
    //<< set blnFound = $$$NO
    blnFound.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if $data(^alWEB.WS.SessionD) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^alWEB.WS.SessionD")))) {
      //<< set idSchedule = ""
      idSchedule.set("");
      //<< for {
      for (;true;) {
        //<< set idSchedule = $order(^COMSchedule(0,idSchedule))
        idSchedule.set(m$.Fnc.$order(m$.var("^COMSchedule",0,idSchedule.get())));
        //<< quit:idSchedule=""
        if (mOp.Equal(idSchedule.get(),"")) {
          break;
        }
        //<< 
        //<< set objSchedule = $get(^COMSchedule(0,idSchedule,1))
        objSchedule.set(m$.Fnc.$get(m$.var("^COMSchedule",0,idSchedule.get(),1)));
        //<< if $$$COMScheduleCode(objSchedule)="##class(alWEB.WS.Session).ClearSessions()" {
        if (mOp.Equal(include.COMConst.$$$COMScheduleCode(m$,objSchedule),"##class(alWEB.WS.Session).ClearSessions()")) {
          //<< set blnFound = $$$YES
          blnFound.set(include.COMSYS.$$$YES(m$));
          //<< quit
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< } else {
    else {
      //<< set blnFound=$$$YES
      blnFound.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< quit blnFound
    return blnFound.get();
  }

  //<< 
  //<< 
  //<< CheckBudget()
  public Object CheckBudget(Object ... _p) {
    //<< ;SR17835 - check if a budget type is defined.
    //<< quit $data(^FINGLTranTypes(0,1,1))
    return m$.Fnc.$data(m$.var("^FINGLTranTypes",0,1,1));
  }

  //<< 
  //<< 
  //<< CheckStandardCurrency()
  public Object CheckStandardCurrency(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Feb-2011   shobby  SR17657: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new fltUnitPrice,idCurrency
    mVar fltUnitPrice = m$.var("fltUnitPrice");
    mVar idCurrency = m$.var("idCurrency");
    m$.newVar(fltUnitPrice,idCurrency);
    //<< 
    //<< set fltUnitPrice = 0
    fltUnitPrice.set(0);
    //<< set idCurrency   = $$StandardCurrency()
    idCurrency.set(m$.fnc$("StandardCurrency"));
    //<< if idCurrency'="" {
    if (mOp.NotEqual(idCurrency.get(),"")) {
      //<< set fltUnitPrice = $$UnitPrice(idCurrency)
      fltUnitPrice.set(m$.fnc$("UnitPrice",idCurrency.get()));
    }
    //<< }
    //<< quit (fltUnitPrice=1)
    return (mOp.Equal(fltUnitPrice.get(),1));
  }

  //<< 
  //<< 
  //<< StandardCurrency()
  public Object StandardCurrency(Object ... _p) {
    //<< quit $$$WWW012StandardCurrency($get(^WWW012(0,0,1)))
    return include.WWWConst.$$$WWW012StandardCurrency(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
  }

  //<< 
  //<< 
  //<< UnitPrice(pidCurrency)
  public Object UnitPrice(Object ... _p) {
    mVar pidCurrency = m$.newVarRef("pidCurrency",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$$WWWWAEUnitPrice($get(^WWWWAE(0,pidCurrency,1)))
    return include.WWWConst.$$$WWWWAEUnitPrice(m$,m$.Fnc.$get(m$.var("^WWWWAE",0,pidCurrency.get(),1)));
  }

  //<< 
  //<< 
  //<< AllChecks(&pintWarnings)
  public Object AllChecks(Object ... _p) {
    mVar pintWarnings = m$.newVarRef("pintWarnings",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; See if there are any warnings.  Will run once every 60 seconds.  So as not
    //<< ; to slow down the loading of every form for a test that you never really fail.
    //<< ;
    //<< ; Called By : WarningIndicator^WWWDASHBOARD
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-May-2013   shobby  CORE-81: Include SessionID check. Count number of warnings.
    //<< ; 12-Jul-2012   shobby  SR18040: CheckMidnight.
    //<< ; 19-Jul-2011   shobby  SR17835: Check to see whether a 'Budget' transaction type
    //<< ;                                has been setup.
    //<< ; 03-Mar-2011   shobby  SR17661: WWWDASHBOARD now exists as a class and can
    //<< ;                           be managed in a standard @netManager.
    //<< ; 17-Feb-2011   shobby  SR17661: When there are a lot of tests this will start
    //<< ;                           to get slow, so only check once a minute.
    //<< ; 17-Feb-2011   shobby  SR17661: Check the COMEntity setups.
    //<< ; 08-Feb-2011   shobby  SR17657: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnResult,objWWWDASHBOARD,strStatus
    mVar blnResult = m$.var("blnResult");
    mVar objWWWDASHBOARD = m$.var("objWWWDASHBOARD");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnResult,objWWWDASHBOARD,strStatus);
    //<< 
    //<< set objWWWDASHBOARD = $get(^WWWDASHBOARD(0,0,1))
    objWWWDASHBOARD.set(m$.Fnc.$get(m$.var("^WWWDASHBOARD",0,0,1)));
    //<< 
    //<< if $zabs($piece($horolog,",",2)-$piece($$$WWWDASHBOARDDate1(objWWWDASHBOARD),",",2))>60 {  ; $zabs allows for different date
    if (mOp.Greater(m$.Fnc.$zabs(mOp.Subtract(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),m$.Fnc.$piece(include.WWWConst.$$$WWWDASHBOARDDate1(m$,objWWWDASHBOARD),",",2))),60)) {
      //<< set $$$WWWDASHBOARDDate1(objWWWDASHBOARD) = $horolog
      include.WWWConst.$$$WWWDASHBOARDDate1Set(m$,objWWWDASHBOARD,m$.Fnc.$horolog());
      //<< set blnResult = $$$OK
      blnResult.set(include.COMSYS.$$$OK(m$));
      //<< set pintWarnings = 0
      pintWarnings.set(0);
      //<< if '$$Check^WWWDASHBOARDEntity() set blnResult=$$$NO set pintWarnings=pintWarnings+1
      if (mOp.Not(m$.fnc$("WWWDASHBOARDEntity.Check"))) {
        blnResult.set(include.COMSYS.$$$NO(m$));
        pintWarnings.set(mOp.Add(pintWarnings.get(),1));
      }
      //<< if '$$CheckStandardCurrency() set blnResult=$$$NO set pintWarnings=pintWarnings+1
      if (mOp.Not(m$.fnc$("CheckStandardCurrency"))) {
        blnResult.set(include.COMSYS.$$$NO(m$));
        pintWarnings.set(mOp.Add(pintWarnings.get(),1));
      }
      //<< if '$$CheckBudget() set blnResult=$$$NO set pintWarnings=pintWarnings+1
      if (mOp.Not(m$.fnc$("CheckBudget"))) {
        blnResult.set(include.COMSYS.$$$NO(m$));
        pintWarnings.set(mOp.Add(pintWarnings.get(),1));
      }
      //<< if '$$CheckMidnight() set blnResult=$$$NO set pintWarnings=pintWarnings+1
      if (mOp.Not(m$.fnc$("CheckMidnight"))) {
        blnResult.set(include.COMSYS.$$$NO(m$));
        pintWarnings.set(mOp.Add(pintWarnings.get(),1));
      }
      //<< if '$$CheckSessionIDs()  set blnResult=$$$NO set pintWarnings=pintWarnings+1 ;CORE-81
      if (mOp.Not(m$.fnc$("CheckSessionIDs"))) {
        blnResult.set(include.COMSYS.$$$NO(m$));
        pintWarnings.set(mOp.Add(pintWarnings.get(),1));
      }
      //<< set $$$WWWDASHBOARDResult(objWWWDASHBOARD) = blnResult
      include.WWWConst.$$$WWWDASHBOARDResultSet(m$,objWWWDASHBOARD,blnResult.get());
      //<< set strStatus = $$$Save("WWWDASHBOARD",pintWarnings,objWWWDASHBOARD,$$$YES)
      strStatus.set(include.COMSYS.$$$Save(m$,"WWWDASHBOARD",pintWarnings,objWWWDASHBOARD,include.COMSYS.$$$YES(m$)));
    }
    //<< 
    //<< }
    //<< quit $$$WWWDASHBOARDResult(objWWWDASHBOARD)
    return include.WWWConst.$$$WWWDASHBOARDResult(m$,objWWWDASHBOARD);
  }

  //<< 
  //<< 
  //<< WarningIndicator(pstrColorRHS)
  public Object WarningIndicator(Object ... _p) {
    mVar pstrColorRHS = m$.newVarRef("pstrColorRHS",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Puts a warning light in the top right of the screen if there are any incorrect
    //<< ; or missing critical setups.
    //<< ;
    //<< ; Called By : V2^WWWKOPF (draws form title line)
    //<< ;
    //<< ; Inputs: pstrColorRHS - colour for Right Hand Side of form title line
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Apr-2011   GRF     SR17657/17661: YBACK is not necessarily defined - add $get
    //<< ; 25-Feb-2011   GRF     SR17661: Pass ColorCodeForHeaderRight to Warning Light
    //<< ; 08-Feb-2011   shobby  SR17657: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strBack
    mVar strBack = m$.var("strBack");
    m$.newVar(strBack);
    //<< 
    //<< set strBack = $get(YBACK)
    strBack.set(m$.Fnc.$get(m$.var("YBACK")));
    //<< new YBACK
    mVar YBACK = m$.var("YBACK");
    m$.newVar(YBACK);
    //<< 
    //<< if '$$AllChecks() {
    if (mOp.Not(m$.fnc$("AllChecks"))) {
      //<< write "<TD padding=0 bgcolor="_pstrColorRHS_" align=center width=24>"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD padding=0 bgcolor=",pstrColorRHS.get())," align=center width=24>"));
      //<< set YBACK = strBack_YFORM_","
      YBACK.set(mOp.Concat(mOp.Concat(strBack.get(),m$.var("YFORM").get()),","));
      //<< write "<A border=none class=link onclick=""window.location='"_YAKTION_"EP=WWWFORM&amp;YFORM=WWWDASHBOARD"_$$WWWCGI2^WWWCGI()_"'"">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A border=none class=link onclick=\"window.location='",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM=WWWDASHBOARD"),m$.fnc$("WWWCGI.WWWCGI2")),"'\">"));
      //<< write "<IMG style='margin:0px; border:0px; padding:0px; vertical-align:middle;' align=right SRC="_YGIF_"ball.gif"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<IMG style='margin:0px; border:0px; padding:0px; vertical-align:middle;' align=right SRC=",m$.var("YGIF").get()),"ball.gif"));
      //<< write ">"
      m$.Cmd.Write(">");
      //<< write "&nbsp;</TD>",YCR
      m$.Cmd.Write("&nbsp;</TD>",m$.var("YCR").get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CheckMidnight()
  public Object CheckMidnight(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check whether the change of day, WWWDATEN protection is set up as a schedule task.
    //<< ; If not create it.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Jul-2012   shobby      SR18040: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idSchedule,idType,blnFound,objCOMSchedule,strStatus,YKEY
    mVar idSchedule = m$.var("idSchedule");
    mVar idType = m$.var("idType");
    mVar blnFound = m$.var("blnFound");
    mVar objCOMSchedule = m$.var("objCOMSchedule");
    mVar strStatus = m$.var("strStatus");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(idSchedule,idType,blnFound,objCOMSchedule,strStatus,YKEY);
    //<< 
    //<< set blnFound=$$$NO
    blnFound.set(include.COMSYS.$$$NO(m$));
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set idType="" for { set idType=$order(^COMSchedules(0,1,"WWWTAG",idType)) quit:idType=""
    idType.set("");
    for (;true;) {
      idType.set(m$.Fnc.$order(m$.var("^COMSchedules",0,1,"WWWTAG",idType.get())));
      if (mOp.Equal(idType.get(),"")) {
        break;
      }
      //<< set idSchedule="" for { set idSchedule=$order(^COMSchedules(0,1,"WWWTAG",idType,idSchedule)) quit:idSchedule=""
      idSchedule.set("");
      for (;true;) {
        idSchedule.set(m$.Fnc.$order(m$.var("^COMSchedules",0,1,"WWWTAG",idType.get(),idSchedule.get())));
        if (mOp.Equal(idSchedule.get(),"")) {
          break;
        }
        //<< set objCOMSchedule=$get(^COMSchedule(0,idSchedule,1))
        objCOMSchedule.set(m$.Fnc.$get(m$.var("^COMSchedule",0,idSchedule.get(),1)));
        //<< if $$$COMScheduleCode(objCOMSchedule)="Midnight^WWWDATEN()" {
        if (mOp.Equal(include.COMConst.$$$COMScheduleCode(m$,objCOMSchedule),"Midnight^WWWDATEN()")) {
          //<< set blnFound=$$$YES
          blnFound.set(include.COMSYS.$$$YES(m$));
          //<< quit
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< if 'blnFound {
    if (mOp.Not(blnFound.get())) {
      //<< ;"WWWTAG~1~4~~1;2;3;4;5;6;7~~~86340~~62651,86340~~Midnight~Midnight^WWWDATEN()~~"
      //<< set objCOMSchedule=""
      objCOMSchedule.set("");
      //<< set $$$COMScheduleClass(objCOMSchedule)="WWWTAG"
      include.COMConst.$$$COMScheduleClassSet(m$,objCOMSchedule,"WWWTAG");
      //<< set $$$COMScheduleTypeReference(objCOMSchedule)=1
      include.COMConst.$$$COMScheduleTypeReferenceSet(m$,objCOMSchedule,1);
      //<< set $$$COMScheduleTimeIncrement(objCOMSchedule)=4
      include.COMConst.$$$COMScheduleTimeIncrementSet(m$,objCOMSchedule,4);
      //<< set $$$COMScheduleTimeToRun(objCOMSchedule)=86340
      include.COMConst.$$$COMScheduleTimeToRunSet(m$,objCOMSchedule,86340);
      //<< set $$$COMScheduleDaysOfWeek(objCOMSchedule)="1;2;3;4;5;6;7"
      include.COMConst.$$$COMScheduleDaysOfWeekSet(m$,objCOMSchedule,"1;2;3;4;5;6;7");
      //<< set $$$COMScheduleDescription(objCOMSchedule)="Midnight"
      include.COMConst.$$$COMScheduleDescriptionSet(m$,objCOMSchedule,"Midnight");
      //<< set $$$COMScheduleCode(objCOMSchedule)="Midnight^WWWDATEN()"
      include.COMConst.$$$COMScheduleCodeSet(m$,objCOMSchedule,"Midnight^WWWDATEN()");
      //<< set YKEY=$$^WWWNEXT("COMSchedule")
      YKEY.set(m$.fnc$("WWWNEXT.main","COMSchedule"));
      //<< set strStatus=$$Save^COMUtils("COMSchedule",YKEY,objCOMSchedule,1)
      strStatus.set(m$.fnc$("COMUtils.Save","COMSchedule",YKEY.get(),objCOMSchedule.get(),1));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

//<< 
//<< 
}
