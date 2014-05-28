//*****************************************************************************
//** TASC - ALPHALINC - MAC COMConversion
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:12
//*****************************************************************************

import mLibrary.*;

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
//<< #include %occInclude
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;

//<< COMConversion
public class COMConversion extends mClass {

  public void main() {
    _COMConversion();
  }

  public void _COMConversion() {
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Conversion of @net Manager global-based classes into AlphaLinc V2 object-based
  //<< ; classes.
  //<< ;
  //<< ; Basic stategy :
  //<< ;   open class
  //<< ;   assign pieces of objData plus keys to properties
  //<< ;   save class
  //<< ;
  //<< ;
  //<< ;  V1 => V2
  //<< ; INART   WWW0121   INLP   WWW013   INLIEF   INKUNDE
  //<< ;
  //<< ;  V2 => V1
  //<< ; INWE
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< ConvertOnSave(pClass,pKey)
  public Object ConvertOnSave(Object ... _p) {
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called by WWWSPEI
    //<< ;
    //<< ; History:
    //<< ; 29-May-2008   GRF     YM=>0 for shared class
    //<< ; 16-May-2008   GRF     SR15649: Removed ^SysSetup("COMConversion") switch
    //<< ; 28-Mar-2008   GRF     SR15649: limit activity at present to development and QA
    //<< ; 27-Mar-2008   HQN     SR?????: Return meaningful error when conversion
    //<< ;                           specified and not implemented
    //<< ; 25-Feb-2008   GRF     SR15622: build and use execution string
    //<< ; 18-Jan-2008   GRF     SR15622: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strExecute,strPackage,strStatus,sc
    mVar strExecute = m$.var("strExecute");
    mVar strPackage = m$.var("strPackage");
    mVar strStatus = m$.var("strStatus");
    mVar sc = m$.var("sc");
    m$.newVar(strExecute,strPackage,strStatus,sc);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< set strPackage = $$$COMConversionPackage($get(^COMConversion(0,pClass,1)))
    strPackage.set(include.COMConst.$$$COMConversionPackage(m$,m$.Fnc.$get(m$.var("^COMConversion",0,pClass.get(),1))));
    //<< 
    //<< if strPackage'="" {
    if (mOp.NotEqual(strPackage.get(),"")) {
      //<< set strStatus = ##class(%Dictionary.MethodDefinition).%Exists($listbuild(strPackage_"||ConvertOnSave"))
      strStatus.set(m$.fnc$("$Dictionary.MethodDefinition.$Exists",m$.Fnc.$listbuild(mOp.Concat(strPackage.get(),"||ConvertOnSave"))));
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< set strExecute = "set sc=##class("_strPackage_").ConvertOnSave(pKey)"
        strExecute.set(mOp.Concat(mOp.Concat("set sc=##class(",strPackage.get()),").ConvertOnSave(pKey)"));
        //<< 
        //<< //if $g(YBED)="PAULP" for x=1:1:100 h 1
        //<< xecute strExecute                              ; *** EXECUTE Save ? ***
        m$.Cmd.Xecute(strExecute.get());
        //<< 
        //<< if $$$ISERR(sc) {
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
          //<< set strStatus = $$DecodeCacheError^COMUtilError(sc)
          strStatus.set(m$.fnc$("COMUtilError.DecodeCacheError",sc.get()));
        }
      }
      //<< }
      //<< } else {
      else {
        //<< set strStatus = $$DecodeCacheError^COMUtilError($system.Status.Error(5395,strPackage,"ConvertOnSave","ConvertOnSave^COMConversion()"))
        strStatus.set(m$.fnc$("COMUtilError.DecodeCacheError",m$.getSystem().getStatus().Error(5395,strPackage.get(),"ConvertOnSave","ConvertOnSave^COMConversion()")));
      }
    }
    //<< }
    //<< 
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< ConvertOnDelete(pClass,pKey)
  public Object ConvertOnDelete(Object ... _p) {
    mVar pClass = m$.newVarRef("pClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called by WWWKILL
    //<< ;
    //<< ; History:
    //<< ; 17-Mar-2011   shobby  SR17686: Strip out quotes from primary key.
    //<< ; 22-Sep-2008   Luke    SR15936 Corrected the SC conversion and pass back
    //<< ; 29-May-2008   GRF     YM=>0 for shared class
    //<< ; 16-May-2008   GRF     SR15649: Removed ^SysSetup("COMConversion") switch
    //<< ; 28-Mar-2008   GRF     SR15649: limit activity at present to development and QA
    //<< ; 27-Mar-2008   HQN     SR?????: Return meaningful error when conversion
    //<< ;                           specified and not implemented
    //<< ; 25-Feb-2008   GRF     SR15622: build and use execution string
    //<< ; 18-Jan-2008   GRF     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strExecute,strPackage,strStatus, sc
    mVar strExecute = m$.var("strExecute");
    mVar strPackage = m$.var("strPackage");
    mVar strStatus = m$.var("strStatus");
    mVar sc = m$.var("sc");
    m$.newVar(strExecute,strPackage,strStatus,sc);
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set pKey=$translate(pKey,"""")      ;SR17686
    pKey.set(m$.Fnc.$translate(pKey.get(),"\""));
    //<< set strPackage = $$$COMConversionPackage($get(^COMConversion(0,pClass,1)))
    strPackage.set(include.COMConst.$$$COMConversionPackage(m$,m$.Fnc.$get(m$.var("^COMConversion",0,pClass.get(),1))));
    //<< if strPackage'="" {
    if (mOp.NotEqual(strPackage.get(),"")) {
      //<< set strStatus = ##class(%Dictionary.MethodDefinition).%Exists($listbuild(strPackage_"||ConvertOnDelete"))
      strStatus.set(m$.fnc$("$Dictionary.MethodDefinition.$Exists",m$.Fnc.$listbuild(mOp.Concat(strPackage.get(),"||ConvertOnDelete"))));
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< set strExecute = "set sc=##class("_strPackage_").ConvertOnDelete(pKey)"
        strExecute.set(mOp.Concat(mOp.Concat("set sc=##class(",strPackage.get()),").ConvertOnDelete(pKey)"));
        //<< 
        //<< xecute strExecute                              ; *** EXECUTE Kill 3 ***
        m$.Cmd.Xecute(strExecute.get());
        //<< 
        //<< if $$$ISERR(sc) {
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
          //<< set strStatus = $$DecodeCacheError^COMUtilError(sc)
          strStatus.set(m$.fnc$("COMUtilError.DecodeCacheError",sc.get()));
        }
      }
      //<< }
      //<< 
      //<< } else {
      else {
        //<< set strStatus = $$DecodeCacheError^COMUtilError($system.Status.Error(5395,strPackage,"ConvertOnDelete","ConvertOnDelete^COMConversion()"))
        strStatus.set(m$.fnc$("COMUtilError.DecodeCacheError",m$.getSystem().getStatus().Error(5395,strPackage.get(),"ConvertOnDelete","ConvertOnDelete^COMConversion()")));
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< ConvertAll
  public void ConvertAll() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Run at the terminal prompt
    //<< ;
    //<< ; This routine will be run after the build has been loaded (1.50)
    //<< ; Any errors will need to be corrected by the CS personnel when running at a client's site.
    //<< ; It is advisable that this process be run on a copy of the Production N/S before
    //<< ; it is run on the Actual Production N/S.
    //<< ;
    //<< ; History:
    //<< ; 24-Jan-2011   PPP     SR17652 - SOH Transactions no longer converted from INWE (deprecated)
    //<< ; 24-Nov-2008   PPP     SR..:Continued with the Sync tests
    //<< ; 09-sep-2008   Luke    SR15897 Reverted SR15800:
    //<< ; 16-Jul-2008   Luke    SR15800: Add check if the Conversion has been run
    //<< ; 29-May-2008   GRF     Avoid single character variables (i => loop); new variables
    //<< ; 21-May-2008   HQN     SR15764: Kill err byref variable before using,
    //<< ;                       one shot usage and routine appends to it
    //<< ; 20-May-2008   Luke    SR15764 Corrected Logic Flow and user feedback for sync tests
    //<< ; 16-May-2008   Luke    SR15754: added calls to Status population
    //<< ; 15-May-2008   PPP     SR15749: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new chContinue,err,loop,sc,strClass,tempSC
    mVar chContinue = m$.var("chContinue");
    mVar err = m$.var("err");
    mVar loop = m$.var("loop");
    mVar sc = m$.var("sc");
    mVar strClass = m$.var("strClass");
    mVar tempSC = m$.var("tempSC");
    m$.newVar(chContinue,err,loop,sc,strClass,tempSC);
    //<< 
    //<< write !," ***********************************************************************"
    m$.Cmd.Write("\n"," ***********************************************************************");
    //<< write !," ****   WARNING THIS PROCESS WILL DELETE ALL V2 DATA   *****************"
    m$.Cmd.Write("\n"," ****   WARNING THIS PROCESS WILL DELETE ALL V2 DATA   *****************");
    //<< write !," ***********************************************************************"
    m$.Cmd.Write("\n"," ***********************************************************************");
    //<< write !!
    m$.Cmd.Write("\n","\n");
    //<< write !,"Enter 'C' or 'c' to continue, any other key to quit"
    m$.Cmd.Write("\n","Enter 'C' or 'c' to continue, any other key to quit");
    //<< read *chContinue
    m$.Cmd.Read(chContinue);
    //<< 
    //<< if $zconvert($char(chContinue),"U") '= "C" quit
    if (mOp.NotEqual(m$.Fnc.$zconvert(m$.Fnc.$char(chContinue.get()),"U"),"C")) {
      return;
    }
    //<< //set ^SysSetup("V2Convert")= $$$NO //SR15800: //SR15897
    //<< write !
    m$.Cmd.Write("\n");
    //<< 
    //<< set sc = $$$OK
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< kill ^ConvertErr
    m$.var("^ConvertErr").kill();
    //<< 
    //<< set strClass="Scripts"
    strClass.set("Scripts");
    //<< write !,"Converting "_strClass
    m$.Cmd.Write("\n",mOp.Concat("Converting ",strClass.get()));
    //<< set sc = ##class(alSYS.Script.iScript).OnBuild()
    sc.set(m$.fnc$("alSYS.Script.iScript.OnBuild"));
    //<< write !,"Status Converting "_strClass_" : "_sc,!
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat("Status Converting ",strClass.get())," : "),sc.get()),"\n");
    //<< set ^ConvertErr(strClass)=sc
    m$.var("^ConvertErr",strClass.get()).set(sc.get());
    //<< 
    //<< /// VVVV SR15754
    //<< set strClass="Status"
    strClass.set("Status");
    //<< write !,"Converting "_strClass
    m$.Cmd.Write("\n",mOp.Concat("Converting ",strClass.get()));
    //<< set sc = ##class(alSYS.Status.iStatus).OnBuild()
    sc.set(m$.fnc$("alSYS.Status.iStatus.OnBuild"));
    //<< write !,"Status Converting "_strClass_" : "_sc,!
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat("Status Converting ",strClass.get())," : "),sc.get()),"\n");
    //<< set ^ConvertErr(strClass)=sc
    m$.var("^ConvertErr",strClass.get()).set(sc.get());
    //<< 
    //<< set strClass="State"
    strClass.set("State");
    //<< write !,"Converting "_strClass
    m$.Cmd.Write("\n",mOp.Concat("Converting ",strClass.get()));
    //<< set sc = ##class(alREC.iREC).Populate()
    sc.set(m$.fnc$("alREC.iREC.Populate"));
    //<< write !,"Status Converting "_strClass_" : "_sc,!
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat("Status Converting ",strClass.get())," : "),sc.get()),"\n");
    //<< set ^ConvertErr(strClass)=sc
    m$.var("^ConvertErr",strClass.get()).set(sc.get());
    //<< 
    //<< set strClass="Movement Status"
    strClass.set("Movement Status");
    //<< write !,"Converting "_strClass
    m$.Cmd.Write("\n",mOp.Concat("Converting ",strClass.get()));
    //<< set sc = ##class(alDRP.iDRP).OnBuild()
    sc.set(m$.fnc$("alDRP.iDRP.OnBuild"));
    //<< write !,"Status Converting "_strClass_" : "_sc,!
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat("Status Converting ",strClass.get())," : "),sc.get()),"\n");
    //<< set ^ConvertErr(strClass)=sc
    m$.var("^ConvertErr",strClass.get()).set(sc.get());
    //<< 
    //<< set strClass="Location"
    strClass.set("Location");
    //<< write !,"Converting "_strClass
    m$.Cmd.Write("\n",mOp.Concat("Converting ",strClass.get()));
    //<< set sc = ##class(alLOC.iLOC).ConvertAll()
    sc.set(m$.fnc$("alLOC.iLOC.ConvertAll"));
    //<< write !,"Status Converting "_strClass_" : "_sc,!
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat("Status Converting ",strClass.get())," : "),sc.get()),"\n");
    //<< set ^ConvertErr(strClass)=sc
    m$.var("^ConvertErr",strClass.get()).set(sc.get());
    //<< 
    //<< set strClass="Inventory-SOH"
    strClass.set("Inventory-SOH");
    //<< write !,"Converting "_strClass
    m$.Cmd.Write("\n",mOp.Concat("Converting ",strClass.get()));
    //<< set sc = ##class(alINV.iINV).ConvertAll()
    sc.set(m$.fnc$("alINV.iINV.ConvertAll"));
    //<< write !,"Status Converting "_strClass_" : "_sc,!
    m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat("Status Converting ",strClass.get())," : "),sc.get()),"\n");
    //<< set ^ConvertErr(strClass)=sc
    m$.var("^ConvertErr",strClass.get()).set(sc.get());
    Sync();
  }

  //<< 
  //<< Sync ; FIXME : Not actually called anywhere - if desired as a manual entry point should have been called specifically from ConvertAll
  public void Sync() {
    //<< if $get(^ConvertErr) {
    if (mOp.Logical(m$.Fnc.$get(m$.var("^ConvertErr")))) {
      //<< write !,"Conversion Errors : "_+$get(^ConvertErr)
      m$.Cmd.Write("\n",mOp.Concat("Conversion Errors : ",mOp.Positive(m$.Fnc.$get(m$.var("^ConvertErr")))));
      //<< write !,"Please check global ^ConvertErr",!,!
      m$.Cmd.Write("\n","Please check global ^ConvertErr","\n","\n");
    }
    //<< }
    //<< 
    //<< set sc = $$$OK
    mVar sc = m$.var("sc");
    sc.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< /// VVVV SR15764
    //<< if $$$ISOK(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,sc))) {
      //<< write !!,"Testing Data Sync"
      m$.Cmd.Write("\n","\n","Testing Data Sync");
      //<< set tempSC = $$$OK
      mVar tempSC = m$.var("tempSC");
      tempSC.set(include.COMSYS.$$$OK(m$));
      //<< 
      //<< write !, "Items Data Sync Test"
      m$.Cmd.Write("\n","Items Data Sync Test");
      //<< set tempSC = ##class(alINV.iUINV).IsSynced()
      tempSC.set(m$.fnc$("alINV.iUINV.IsSynced"));
      //<< if $$$ISERR(tempSC) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,tempSC))) {
        //<< write "<Failed Details Below>",!
        m$.Cmd.Write("<Failed Details Below>","\n");
        //<< kill err
        m$.var("err").kill();
        //<< do DecomposeStatus^%apiOBJ(tempSC,.err,"-d")
        m$.Cmd.Do("$apiOBJ.DecomposeStatus",tempSC.get(),m$.var("err"),"-d");
        //<< for loop=1:1:err write err(loop),!
        mVar loop = m$.var("loop");
        for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.var("err").get()));loop.set(mOp.Add(loop.get(),1))) {
          m$.Cmd.Write(m$.var("err").var(loop.get()).get(),"\n");
        }
      }
      //<< } else {
      else {
        //<< write " <Passed>",!
        m$.Cmd.Write(" <Passed>","\n");
      }
      //<< }
      //<< 
      //<< set tempSC = $$$OK
      tempSC.set(include.COMSYS.$$$OK(m$));
      //<< write !,"Location Data Sync Test"
      m$.Cmd.Write("\n","Location Data Sync Test");
      //<< set tempSC = ##class(alLOC.iULOC).IsSynced()
      tempSC.set(m$.fnc$("alLOC.iULOC.IsSynced"));
      //<< if $$$ISERR(tempSC) {
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,tempSC))) {
        //<< write "<Failed Details Below>",!
        m$.Cmd.Write("<Failed Details Below>","\n");
        //<< kill err
        m$.var("err").kill();
        //<< do DecomposeStatus^%apiOBJ(tempSC,.err,"-d")
        m$.Cmd.Do("$apiOBJ.DecomposeStatus",tempSC.get(),m$.var("err"),"-d");
        //<< for loop=1:1:err write err(loop),!
        mVar loop = m$.var("loop");
        for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.var("err").get()));loop.set(mOp.Add(loop.get(),1))) {
          m$.Cmd.Write(m$.var("err").var(loop.get()).get(),"\n");
        }
      }
      //<< } else {
      else {
        //<< write " <Passed>",!
        m$.Cmd.Write(" <Passed>","\n");
      }
    }
    //<< }
    //<< 
    //<< //SR17652 - SOH Transactions no longer converted from INWE (deprecated)
    //<< /*
    //<< set tempSC = $$$OK
    //<< write !,"SOH Data Sync Test"
    //<< set tempSC = ##class(alSOH.iUSOH).IsSynced()
    //<< if $$$ISERR(tempSC) {
    //<< write !, "Failed Details Below ",!
    //<< kill err
    //<< do DecomposeStatus^%apiOBJ(tempSC,.err,"-d")
    //<< for loop=1:1:err write err(loop),!
    //<< } else {
    //<< write !, "Passed",!
    //<< }
    //<< */
    //<< 
    //<< }
    //<< if $$$ISERR(sc) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,sc))) {
      //<< write !, "Error During Conversion ",!
      m$.Cmd.Write("\n","Error During Conversion ","\n");
      //<< kill err
      m$.var("err").kill();
      //<< do DecomposeStatus^%apiOBJ(sc,.err,"-d")
      m$.Cmd.Do("$apiOBJ.DecomposeStatus",sc.get(),m$.var("err"),"-d");
      //<< for loop=1:1:err write err(loop),!
      mVar loop = m$.var("loop");
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.var("err").get()));loop.set(mOp.Add(loop.get(),1))) {
        m$.Cmd.Write(m$.var("err").var(loop.get()).get(),"\n");
      }
    }
    //<< }
    //<< quit
    return;
  }

//<< 
}
